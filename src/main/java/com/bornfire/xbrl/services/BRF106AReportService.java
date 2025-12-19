
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

import com.bornfire.xbrl.entities.BRBS.BRF093AServiceRepo;
import com.bornfire.xbrl.entities.BRBS.BRF094AServiceRepo;
import com.bornfire.xbrl.entities.BRBS.BRF095AServiceRepo;
import com.bornfire.xbrl.entities.BRBS.BRF106AServiceRepo;
import com.bornfire.xbrl.entities.BRBS.BRF106DETAIL_Repo;
import com.bornfire.xbrl.entities.BRBS.BRF106_ARCHIVENTITY;
import com.bornfire.xbrl.entities.BRBS.BRF106_DETAIL_ENTITY;
import com.bornfire.xbrl.entities.BRBS.BRF102AServiceRepo;
import com.bornfire.xbrl.entities.BRBS.BRF32reportentity;
import com.bornfire.xbrl.entities.BRBS.BRF73ServiceRepo;
import com.bornfire.xbrl.entities.BRBS.BRF96AServiceRepo;

import com.bornfire.xbrl.entities.BRBS.BRF_106_A_REPORT_ENTITY;
import com.bornfire.xbrl.entities.BRBS.BRF_96_REPORT_ENTITY;
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
public class BRF106AReportService {
	private static final Logger logger = LoggerFactory.getLogger(BRF106AReportService.class);

	@Autowired
	SessionFactory sessionFactory;

	@Autowired
	DataSource srcdataSource;

	@Autowired
	Environment env;

	
	@Autowired
	BRF106AServiceRepo brf106aServiceRepo;

	
	@Autowired
	BRF106DETAIL_Repo bRF106DETAIL_Repo;

	DateFormat df = new SimpleDateFormat("dd-MMM-yyyy");

	public String preCheckBRF106A(String reportid, String fromdate, String todate) {

		String msg = "";
		Session hs = sessionFactory.getCurrentSession();
		Date dt1;
		Date dt9;
		logger.info("Report precheck : " + reportid);
 
		try {
			dt1 = new SimpleDateFormat("dd/MM/yyyy").parse(fromdate);
			dt9 = new SimpleDateFormat("dd/MM/yyyy").parse(todate);
			logger.info("Getting No of records in Master table :" + reportid);
			Long dtlcnt = (Long) hs.createQuery("select count(*) from BRF_106_A_REPORT_ENTITY a where a.report_date=?1")
					.setParameter(1, dt9).getSingleResult();
 
			if (dtlcnt > 0) {
				logger.info("Getting No of records in Mod table :" + reportid);
				Long modcnt = (Long) hs.createQuery("select count(*) from BRF_106_A_REPORT_ENTITY a").getSingleResult();
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
 
	public ModelAndView getBRF106AView(String reportId, String fromdate, String todate, String currency, String dtltype,
			Pageable pageable) {

		ModelAndView mv = new ModelAndView();

		Session hs = sessionFactory.getCurrentSession();
		int pageSize = pageable.getPageSize();
		int currentPage = pageable.getPageNumber();
		int startItem = currentPage * pageSize;
		List<BRF_106_A_REPORT_ENTITY> T1rep = new ArrayList<BRF_106_A_REPORT_ENTITY>();
		// Query<Object[]> qr;

		List<BRF_106_A_REPORT_ENTITY> T1Master = new ArrayList<BRF_106_A_REPORT_ENTITY>();

		logger.info("Inside archive" + currency);

		try {

			Date d1 = df.parse(todate);
			// T1rep = t1CurProdServiceRepo.getT1CurProdServices(d1);

			T1Master = hs.createQuery("from BRF_106_A_REPORT_ENTITY a where a.report_date = ?1 ",BRF_106_A_REPORT_ENTITY.class)
					        .setParameter(1, df.parse(todate)).getResultList();

		} catch (ParseException e) {
			e.printStackTrace();
		}

		// T1rep = t1CurProdServiceRepo.getT1CurProdServices(d1);

		mv.setViewName("RR/BRF106A");
		// mv.addObject("currlist", refCodeConfig.currList());
		mv.addObject("reportsummary", T1Master);
		mv.addObject("reportmaster", T1Master);
		mv.addObject("displaymode", "summary");
		mv.addObject("reportsflag", "reportsflag");
		mv.addObject("menu", reportId);
		System.out.println("scv" + mv.getViewName());

		return mv;

	}

	public ModelAndView getBRF106ADetails(String reportId, String fromdate, String todate, 
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
				qr = hs.createNativeQuery("select * from ECL_BRF106_DETAIL_TABLE  a where report_date = ?1 and report_label_1 =?2");

				qr.setParameter(2, filter);

			} else {
				qr = hs.createNativeQuery("select * from ECL_BRF106_DETAIL_TABLE a where report_date = ?1");

			}
		} else {
			qr = hs.createNativeQuery("select * from ECL_BRF106_DETAIL_TABLE  where report_date = ?1");
		}

		try {
			qr.setParameter(1, df.parse(todate));

		} catch (ParseException e) {
			e.printStackTrace();
		}
		List<BRF106_DETAIL_ENTITY> T1Master = new ArrayList<BRF106_DETAIL_ENTITY>();

		try {
			T1Master = hs.createQuery("from BRF106_DETAIL_ENTITY a where a.report_date = ?1", BRF106_DETAIL_ENTITY.class)
					.setParameter(1, df.parse(todate)).getResultList();
		} catch (ParseException e) {

			e.printStackTrace();
		}

		logger.info("Getting Report Detail for : " + reportId + "," + fromdate + "," + todate + "," );
		List<Object[]> result = qr.getResultList();

		for (Object[] a : result) {
			String cust_id = (String) a[0];
			String cust_name = (String) a[1];
			String branch_name = (String) a[2];
			String productname = (String) a[3];
			String currency = (String) a[4];
			BigDecimal drawnamount = (BigDecimal) a[5];
			BigDecimal undrawnamount = (BigDecimal) a[6];
			BigDecimal ead = (BigDecimal) a[7];
			Date report_date = (Date) a[8];
			Date maturitydate = (Date) a[9];
			String weighted_pd = (String) a[10];
			BigDecimal finalweightedecl = (BigDecimal) a[11];
			BigDecimal ecl_incul_deferral = (BigDecimal) a[12];
			BigDecimal ecl_mgmt_overlay = (BigDecimal) a[13];
			BigDecimal specific_provision = (BigDecimal) a[14];
			BigDecimal interest_suspense = (BigDecimal) a[15];
			String country = (String) a[16];
			String brf_1_classification = (String) a[17];
			String brf_106 = (String) a[18];
			String basel_2_category = (String) a[19];
			String provision_coverage = (String) a[20];
			String mgmtoverlay = (String) a[21];
			BigDecimal total_rwa = (BigDecimal) a[22];
			String report_lable = (String) a[23];
			String report_addl_criteria1 = (String) a[24];
			String report_addl_criteria2 = (String) a[25];
			String facilityid = (String) a[26];
			

			

			BRF106_DETAIL_ENTITY py = new BRF106_DETAIL_ENTITY( cust_id,  cust_name,  branch_name,  productname,
					 currency,  drawnamount,  undrawnamount,  ead,  report_date,
					 maturitydate,  weighted_pd,  finalweightedecl,  ecl_incul_deferral,
					 ecl_mgmt_overlay,  specific_provision,  interest_suspense,
					 country,  brf_1_classification,  brf_106,  basel_2_category,
					 provision_coverage,mgmtoverlay,total_rwa,report_lable,report_addl_criteria1,report_addl_criteria2,facilityid);
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

		mv.setViewName("RR" + "/" + "BRF106A::reportcontent");
		mv.addObject("reportdetails", T1Dt1Page.getContent());
		mv.addObject("reportmaster", T1Master);
		mv.addObject("reportmaster12", T1Dt1);
		mv.addObject("reportmaster1", qr);
		mv.addObject("singledetail", new T1CurProdDetail());
		mv.addObject("reportsflag", "reportsflag");
		mv.addObject("menu", reportId);
		return mv;
	}

	public File getFileBRF106A(String reportId, String fromdate, String todate, String currency, String dtltype,
			String filetype) throws FileNotFoundException, JRException, SQLException {

		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

		String path = this.env.getProperty("output.exportpath");
		String fileName = "";
		String zipFileName = "";
		File outputFile;

		logger.info("Getting Output file :" + reportId);
		fileName =  "011-BRF-106-A";
		

		if (!filetype.equals("xbrl")) {
			if(!filetype.equals("BRF")) {

			try {
				InputStream jasperFile;
				logger.info("Getting Jasper file :" + reportId);
				if (filetype.equals("detailexcel")) {
					if (dtltype.equals("report")) {

						jasperFile = this.getClass().getResourceAsStream("/static/jasper/BRF106_Details.jrxml");
					} else {
						jasperFile = this.getClass().getResourceAsStream("/static/jasper/BRF106_Details.jrxml");
					}

				} else {
					if (dtltype.equals("report")) {
						logger.info("Inside report");
						jasperFile = this.getClass().getResourceAsStream("/static/jasper/BRF_106_A.jrxml");
					} else {
						jasperFile = this.getClass().getResourceAsStream("/static/jasper/BRF_106_A.jrxml");
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
			}
	else {
		
		List<BRF_106_A_REPORT_ENTITY> T1Master = new ArrayList<BRF_106_A_REPORT_ENTITY>();
		Session hs = sessionFactory.getCurrentSession();
		try {
			Date d1 = df.parse(todate);
		
		// T1rep = t1CurProdServiceRepo.getT1CurProdServices(d1);

		T1Master = hs.createQuery("from  BRF_106_A_REPORT_ENTITY a where a.report_date = ?1 ", BRF_106_A_REPORT_ENTITY.class)
				.setParameter(1, df.parse(todate)).getResultList();
		
		if(T1Master.size() == 1) {
			
			for(BRF_106_A_REPORT_ENTITY BRF106 : T1Master ) {
		
		File Responsecamt = new File(env.getProperty("output.exportpathtemp")+"011-BRF-106-AT.xls");
		
		  // Load the Excel file
    	Workbook workbook = WorkbookFactory.create(Responsecamt);

        // Get the first sheet
    	Sheet sheet = workbook.getSheetAt(0);
    	
    	//srl_no -1
    	
        Row row = sheet.getRow(9);
        Cell cell = row.getCell(4);
        if (cell != null) {
            cell.setCellValue(BRF106.getR1_OUTSTANDING_CASH() == null ? 0 :
            	BRF106.getR1_OUTSTANDING_CASH().intValue());
        }
        Cell cell1 = row.getCell(5);
        if (cell1 != null) {
            cell1.setCellValue(BRF106.getR1_PROVISION_CASH() == null ? 0 :
            	BRF106.getR1_PROVISION_CASH().intValue());
        }
        Cell cell2 = row.getCell(6);
        if (cell2 != null) {
            cell2.setCellValue(BRF106.getR1_OUTSTANDING_BALANCE() == null ? 0 :
            	BRF106.getR1_OUTSTANDING_BALANCE().intValue());
        }
        Cell cell3 = row.getCell(7);
        if (cell3 != null) {
            cell3.setCellValue(BRF106.getR1_PROVISION_BALANCE() == null ? 0 :
            	BRF106.getR1_PROVISION_BALANCE().intValue());
        }
        Cell cell4 = row.getCell(8);
        if (cell4 != null) {
            cell4.setCellValue(BRF106.getR1_OUTSTANDING_NON_BANKING() == null ? 0 :
            	BRF106.getR1_OUTSTANDING_NON_BANKING().intValue());
        }
        Cell cell5 = row.getCell(9);
        if (cell5 != null) {
            cell5.setCellValue(BRF106.getR1_PROVISION_NON_BANKING() == null ? 0 :
            	BRF106.getR1_PROVISION_NON_BANKING().intValue());
        }
        Cell cell6 = row.getCell(10);
        if (cell6 != null) {
            cell6.setCellValue(BRF106.getR1_OUTSTANDING_INVESTMENT() == null ? 0 :
            	BRF106.getR1_OUTSTANDING_INVESTMENT().intValue());
        }	
        Cell cell7 = row.getCell(11);
        if (cell7 != null) {
            cell7.setCellValue(BRF106.getR1_PROVISION_INVESTMENT() == null ? 0 :
            	BRF106.getR1_PROVISION_INVESTMENT().intValue());
        }
        Cell cell8 = row.getCell(12);
        if (cell8 != null) {
            cell8.setCellValue(BRF106.getR1_OUTSTANDING_TRADE() == null ? 0 :
            	BRF106.getR1_OUTSTANDING_TRADE().intValue());
        }
        Cell cell9 = row.getCell(13);
        if (cell9 != null) {
            cell9.setCellValue(BRF106.getR1_PROVISION_TRADE() == null ? 0 :
            	BRF106.getR1_PROVISION_TRADE().intValue());
        }
        Cell cell10 = row.getCell(14);
        if (cell10 != null) {
        	cell10.setCellValue(BRF106.getR1_OUTSTANDING_LOAN() == null ? 0 :
            	BRF106.getR1_OUTSTANDING_LOAN().intValue());
        }
        Cell cell11 = row.getCell(15);
        if (cell11 != null) {
        	cell11.setCellValue(BRF106.getR1_PROVISION_LOAN() == null ? 0 :
            	BRF106.getR1_PROVISION_LOAN().intValue());
        }
        Cell cell12 = row.getCell(16);
        if (cell12 != null) {
        	cell12.setCellValue(BRF106.getR1_OUTSTANDING_OTHER_ASSETS() == null ? 0 :
            	BRF106.getR1_OUTSTANDING_OTHER_ASSETS().intValue());
        }
        Cell cell13 = row.getCell(17);
        if (cell13 != null) {
        	cell13.setCellValue(BRF106.getR1_PROVISION_OTHER_ASSETS() == null ? 0 :
            	BRF106.getR1_PROVISION_OTHER_ASSETS().intValue());
        }
        Cell cell16 = row.getCell(20);
        if (cell16 != null) {
        	cell16.setCellValue(BRF106.getR1_INTERESTS() == null ? 0 :
            	BRF106.getR1_INTERESTS().intValue());
        }
        Cell cell17 = row.getCell(21);
        if (cell17 != null) {
        	cell17.setCellValue(BRF106.getR1_EXPOSURE() == null ? 0 :
            	BRF106.getR1_EXPOSURE().intValue());
        }
        Cell cell18 = row.getCell(22);
        if (cell18 != null) {
        	cell18.setCellValue(BRF106.getR1_UNFUNDED() == null ? 0 :
            	BRF106.getR1_UNFUNDED().intValue());
        }
        Cell cell19 = row.getCell(23);
        if (cell19 != null) {
        	cell19.setCellValue(BRF106.getR1_OUTSTANDING_UNFUNDED() == null ? 0 :
            	BRF106.getR1_OUTSTANDING_UNFUNDED().intValue());
        }
        Cell cell20 = row.getCell(24);
        if (cell20 != null) {
        	cell20.setCellValue(BRF106.getR1_PROVISION_UNFUNDED() == null ? 0 :
            	BRF106.getR1_PROVISION_UNFUNDED().intValue());
        }
        //srl_no -2
		/*
		 * Row row1 = sheet.getRow(10); Cell cell22 = row1.getCell(4); if (cell22 !=
		 * null) { cell22.setCellValue(BRF106.getR2_OUTSTANDING_CASH() == null ? 0 :
		 * BRF106.getR2_OUTSTANDING_CASH().intValue()); } Cell cell23 = row1.getCell(5);
		 * if (cell23 != null) { cell23.setCellValue(BRF106.getR2_PROVISION_CASH() ==
		 * null ? 0 : BRF106.getR2_PROVISION_CASH().intValue()); } Cell cell24 =
		 * row1.getCell(6); if (cell24 != null) {
		 * cell24.setCellValue(BRF106.getR2_OUTSTANDING_BALANCE() == null ? 0 :
		 * BRF106.getR2_OUTSTANDING_BALANCE().intValue()); } Cell cell25 =
		 * row1.getCell(7); if (cell25 != null) {
		 * cell25.setCellValue(BRF106.getR2_PROVISION_BALANCE() == null ? 0 :
		 * BRF106.getR2_PROVISION_BALANCE().intValue()); } Cell cell26 =
		 * row1.getCell(8); if (cell26 != null) {
		 * cell26.setCellValue(BRF106.getR2_OUTSTANDING_NON_BANKING() == null ? 0 :
		 * BRF106.getR2_OUTSTANDING_NON_BANKING().intValue()); } Cell cell27 =
		 * row1.getCell(9); if (cell27 != null) {
		 * cell27.setCellValue(BRF106.getR2_PROVISION_NON_BANKING() == null ? 0 :
		 * BRF106.getR2_PROVISION_NON_BANKING().intValue()); } Cell cell28 =
		 * row1.getCell(10); if (cell28 != null) {
		 * cell28.setCellValue(BRF106.getR2_OUTSTANDING_INVESTMENT() == null ? 0 :
		 * BRF106.getR2_OUTSTANDING_INVESTMENT().intValue()); } Cell cell29 =
		 * row1.getCell(11); if (cell29 != null) {
		 * cell29.setCellValue(BRF106.getR2_PROVISION_INVESTMENT() == null ? 0 :
		 * BRF106.getR2_PROVISION_INVESTMENT().intValue()); } Cell cell30 =
		 * row1.getCell(12); if (cell30 != null) {
		 * cell30.setCellValue(BRF106.getR2_OUTSTANDING_TRADE() == null ? 0 :
		 * BRF106.getR2_OUTSTANDING_TRADE().intValue()); } Cell cell31 =
		 * row1.getCell(13); if (cell31 != null) {
		 * cell31.setCellValue(BRF106.getR2_PROVISION_TRADE() == null ? 0 :
		 * BRF106.getR2_PROVISION_TRADE().intValue()); } Cell cell32 = row1.getCell(14);
		 * if (cell32 != null) { cell32.setCellValue(BRF106.getR2_OUTSTANDING_LOAN() ==
		 * null ? 0 : BRF106.getR2_OUTSTANDING_LOAN().intValue()); } Cell cell33 =
		 * row1.getCell(15); if (cell33 != null) {
		 * cell33.setCellValue(BRF106.getR2_PROVISION_LOAN() == null ? 0 :
		 * BRF106.getR2_PROVISION_LOAN().intValue()); } Cell cell34 = row1.getCell(16);
		 * if (cell34 != null) {
		 * cell34.setCellValue(BRF106.getR2_OUTSTANDING_OTHER_ASSETS() == null ? 0 :
		 * BRF106.getR2_OUTSTANDING_OTHER_ASSETS().intValue()); } Cell cell35 =
		 * row1.getCell(17); if (cell35 != null) {
		 * cell35.setCellValue(BRF106.getR2_PROVISION_OTHER_ASSETS() == null ? 0 :
		 * BRF106.getR2_PROVISION_OTHER_ASSETS().intValue()); } Cell cell36 =
		 * row1.getCell(20); if (cell36 != null) {
		 * cell36.setCellValue(BRF106.getR2_INTERESTS() == null ? 0 :
		 * BRF106.getR2_INTERESTS().intValue()); } Cell cell37 = row1.getCell(21); if
		 * (cell37 != null) { cell37.setCellValue(BRF106.getR2_EXPOSURE() == null ? 0 :
		 * BRF106.getR2_EXPOSURE().intValue()); } Cell cell38 = row1.getCell(22); if
		 * (cell38 != null) { cell38.setCellValue(BRF106.getR2_UNFUNDED() == null ? 0 :
		 * BRF106.getR2_UNFUNDED().intValue()); } Cell cell39 = row1.getCell(23); if
		 * (cell39 != null) { cell39.setCellValue(BRF106.getR2_OUTSTANDING_UNFUNDED() ==
		 * null ? 0 : BRF106.getR2_OUTSTANDING_UNFUNDED().intValue()); } Cell cell40=
		 * row1.getCell(24); if (cell40 != null) {
		 * cell40.setCellValue(BRF106.getR2_PROVISION_UNFUNDED() == null ? 0 :
		 * BRF106.getR2_PROVISION_UNFUNDED().intValue()); }
		 */
        //srl_no -5
    	
        Row row2 = sheet.getRow(13);
        Cell cell42 = row2.getCell(4);
        if (cell42 != null) {
            cell42.setCellValue(BRF106.getR5_OUTSTANDING_CASH() == null ? 0 :
            	BRF106.getR5_OUTSTANDING_CASH().intValue());
        }
        Cell cell44 = row2.getCell(6);
        if (cell44 != null) {
            cell44.setCellValue(BRF106.getR5_OUTSTANDING_BALANCE() == null ? 0 :
            	BRF106.getR5_OUTSTANDING_BALANCE().intValue());
        }
        Cell cell46 = row2.getCell(8);
        if (cell46 != null) {
            cell46.setCellValue(BRF106.getR5_OUTSTANDING_NON_BANKING() == null ? 0 :
            	BRF106.getR5_OUTSTANDING_NON_BANKING().intValue());
        }   
        Cell cell48 = row2.getCell(10);
        if (cell48 != null) {
            cell48.setCellValue(BRF106.getR5_OUTSTANDING_INVESTMENT() == null ? 0 :
            	BRF106.getR5_OUTSTANDING_INVESTMENT().intValue());
        }	
        Cell cell50 = row2.getCell(12);
        if (cell50 != null) {
            cell50.setCellValue(BRF106.getR5_OUTSTANDING_TRADE() == null ? 0 :
            	BRF106.getR5_OUTSTANDING_TRADE().intValue());
        }
        Cell cell52 = row2.getCell(14);
        if (cell52 != null) {
        	cell52.setCellValue(BRF106.getR5_OUTSTANDING_LOAN() == null ? 0 :
            	BRF106.getR5_OUTSTANDING_LOAN().intValue());
        }
        Cell cell54 = row2.getCell(16);
        if (cell54 != null) {
        	cell54.setCellValue(BRF106.getR5_OUTSTANDING_OTHER_ASSETS() == null ? 0 :
            	BRF106.getR5_OUTSTANDING_OTHER_ASSETS().intValue());
        }
        Cell cell56 = row2.getCell(20);
        if (cell56 != null) {
        	cell56.setCellValue(BRF106.getR5_INTERESTS() == null ? 0 :
            	BRF106.getR5_INTERESTS().intValue());
        }
        Cell cell57 = row2.getCell(21);
        if (cell57 != null) {
        	cell57.setCellValue(BRF106.getR5_EXPOSURE() == null ? 0 :
            	BRF106.getR5_EXPOSURE().intValue());
        }
        Cell cell58 = row2.getCell(22);
        if (cell58 != null) {
        	cell58.setCellValue(BRF106.getR5_UNFUNDED() == null ? 0 :
            	BRF106.getR5_UNFUNDED().intValue());
        }
        Cell cell59 = row2.getCell(23);
        if (cell59 != null) {
        	cell59.setCellValue(BRF106.getR5_OUTSTANDING_UNFUNDED() == null ? 0 :
            	BRF106.getR5_OUTSTANDING_UNFUNDED().intValue());
        }
        Cell cell60= row2.getCell(24);
        if (cell60 != null) {
        	cell60.setCellValue(BRF106.getR5_PROVISION_UNFUNDED() == null ? 0 :
            	BRF106.getR5_PROVISION_UNFUNDED().intValue());
        }
        //srl_no -6
    	
        Row row3 = sheet.getRow(14);
        Cell cell62 = row3.getCell(4);
        if (cell62 != null) {
            cell62.setCellValue(BRF106.getR6_OUTSTANDING_CASH() == null ? 0 :
            	BRF106.getR6_OUTSTANDING_CASH().intValue());
        }
        Cell cell63 = row3.getCell(5);
        if (cell63 != null) {
            cell63.setCellValue(BRF106.getR6_PROVISION_CASH() == null ? 0 :
            	BRF106.getR6_PROVISION_CASH().intValue());
        }
        Cell cell64 = row3.getCell(6);
        if (cell64 != null) {
            cell64.setCellValue(BRF106.getR6_OUTSTANDING_BALANCE() == null ? 0 :
            	BRF106.getR6_OUTSTANDING_BALANCE().intValue());
        }
        Cell cell65 = row3.getCell(7);
        if (cell65 != null) {
            cell65.setCellValue(BRF106.getR6_PROVISION_BALANCE() == null ? 0 :
            	BRF106.getR6_PROVISION_BALANCE().intValue());
        }
        Cell cell66 = row3.getCell(8);
        if (cell66 != null) {
            cell66.setCellValue(BRF106.getR6_OUTSTANDING_NON_BANKING() == null ? 0 :
            	BRF106.getR6_OUTSTANDING_NON_BANKING().intValue());
        }
        Cell cell67 = row3.getCell(9);
        if (cell67 != null) {
            cell67.setCellValue(BRF106.getR6_PROVISION_NON_BANKING() == null ? 0 :
            	BRF106.getR6_PROVISION_NON_BANKING().intValue());
        }
        Cell cell68 = row3.getCell(10);
        if (cell68 != null) {
            cell68.setCellValue(BRF106.getR6_OUTSTANDING_INVESTMENT() == null ? 0 :
            	BRF106.getR6_OUTSTANDING_INVESTMENT().intValue());
        }	
        Cell cell69 = row3.getCell(11);
        if (cell69 != null) {
            cell69.setCellValue(BRF106.getR6_PROVISION_INVESTMENT() == null ? 0 :
            	BRF106.getR6_PROVISION_INVESTMENT().intValue());
        }
        Cell cell70 = row3.getCell(12);
        if (cell70 != null) {
            cell70.setCellValue(BRF106.getR6_OUTSTANDING_TRADE() == null ? 0 :
            	BRF106.getR6_OUTSTANDING_TRADE().intValue());
        }
        Cell cell71 = row3.getCell(13);
        if (cell71 != null) {
            cell71.setCellValue(BRF106.getR6_PROVISION_TRADE() == null ? 0 :
            	BRF106.getR6_PROVISION_TRADE().intValue());
        }
        Cell cell72 = row3.getCell(14);
        if (cell72 != null) {
        	cell72.setCellValue(BRF106.getR6_OUTSTANDING_LOAN() == null ? 0 :
            	BRF106.getR6_OUTSTANDING_LOAN().intValue());
        }
        Cell cell73 = row3.getCell(15);
        if (cell73 != null) {
        	cell73.setCellValue(BRF106.getR6_PROVISION_LOAN() == null ? 0 :
            	BRF106.getR6_PROVISION_LOAN().intValue());
        }
        Cell cell74 = row3.getCell(16);
        if (cell74 != null) {
        	cell74.setCellValue(BRF106.getR6_OUTSTANDING_OTHER_ASSETS() == null ? 0 :
            	BRF106.getR6_OUTSTANDING_OTHER_ASSETS().intValue());
        }
        Cell cell75 = row3.getCell(17);
        if (cell75 != null) {
        	cell75.setCellValue(BRF106.getR6_PROVISION_OTHER_ASSETS() == null ? 0 :
            	BRF106.getR6_PROVISION_OTHER_ASSETS().intValue());
        }
        Cell cell76 = row3.getCell(20);
        if (cell76 != null) {
        	cell76.setCellValue(BRF106.getR6_INTERESTS() == null ? 0 :
            	BRF106.getR6_INTERESTS().intValue());
        }
        Cell cell77 = row3.getCell(21);
        if (cell77 != null) {
        	cell77.setCellValue(BRF106.getR6_EXPOSURE() == null ? 0 :
            	BRF106.getR6_EXPOSURE().intValue());
        }
        Cell cell78 = row3.getCell(22);
        if (cell78 != null) {
        	cell78.setCellValue(BRF106.getR6_UNFUNDED() == null ? 0 :
            	BRF106.getR6_UNFUNDED().intValue());
        }
        Cell cell79 = row3.getCell(23);
        if (cell79 != null) {
        	cell79.setCellValue(BRF106.getR6_OUTSTANDING_UNFUNDED() == null ? 0 :
            	BRF106.getR6_OUTSTANDING_UNFUNDED().intValue());
        }
        Cell cell80= row3.getCell(24);
        if (cell80 != null) {
        	cell80.setCellValue(BRF106.getR6_PROVISION_UNFUNDED() == null ? 0 :
            	BRF106.getR6_PROVISION_UNFUNDED().intValue());
        }
        //srl_no -7
    	
		/*
		 * Row row4 = sheet.getRow(15); Cell cell82 = row4.getCell(4); if (cell82 !=
		 * null) { cell82.setCellValue(BRF106.getR7_OUTSTANDING_CASH() == null ? 0 :
		 * BRF106.getR7_OUTSTANDING_CASH().intValue()); } Cell cell83 = row4.getCell(5);
		 * if (cell83 != null) { cell83.setCellValue(BRF106.getR7_PROVISION_CASH() ==
		 * null ? 0 : BRF106.getR7_PROVISION_CASH().intValue()); } Cell cell84 =
		 * row4.getCell(6); if (cell84 != null) {
		 * cell84.setCellValue(BRF106.getR7_OUTSTANDING_BALANCE() == null ? 0 :
		 * BRF106.getR7_OUTSTANDING_BALANCE().intValue()); } Cell cell85 =
		 * row4.getCell(7); if (cell85 != null) {
		 * cell85.setCellValue(BRF106.getR7_PROVISION_BALANCE() == null ? 0 :
		 * BRF106.getR7_PROVISION_BALANCE().intValue()); } Cell cell86 =
		 * row4.getCell(8); if (cell86 != null) {
		 * cell86.setCellValue(BRF106.getR7_OUTSTANDING_NON_BANKING() == null ? 0 :
		 * BRF106.getR7_OUTSTANDING_NON_BANKING().intValue()); } Cell cell87 =
		 * row4.getCell(9); if (cell87 != null) {
		 * cell87.setCellValue(BRF106.getR7_PROVISION_NON_BANKING() == null ? 0 :
		 * BRF106.getR7_PROVISION_NON_BANKING().intValue()); } Cell cell88 =
		 * row4.getCell(10); if (cell88 != null) {
		 * cell88.setCellValue(BRF106.getR7_OUTSTANDING_INVESTMENT() == null ? 0 :
		 * BRF106.getR7_OUTSTANDING_INVESTMENT().intValue()); } Cell cell89 =
		 * row4.getCell(11); if (cell89 != null) {
		 * cell89.setCellValue(BRF106.getR7_PROVISION_INVESTMENT() == null ? 0 :
		 * BRF106.getR7_PROVISION_INVESTMENT().intValue()); } Cell cell90 =
		 * row4.getCell(12); if (cell90 != null) {
		 * cell90.setCellValue(BRF106.getR7_OUTSTANDING_TRADE() == null ? 0 :
		 * BRF106.getR7_OUTSTANDING_TRADE().intValue()); } Cell cell91 =
		 * row4.getCell(13); if (cell91 != null) {
		 * cell91.setCellValue(BRF106.getR7_PROVISION_TRADE() == null ? 0 :
		 * BRF106.getR7_PROVISION_TRADE().intValue()); } Cell cell92 = row4.getCell(14);
		 * if (cell92 != null) { cell92.setCellValue(BRF106.getR7_OUTSTANDING_LOAN() ==
		 * null ? 0 : BRF106.getR7_OUTSTANDING_LOAN().intValue()); } Cell cell93 =
		 * row4.getCell(15); if (cell93 != null) {
		 * cell93.setCellValue(BRF106.getR7_PROVISION_LOAN() == null ? 0 :
		 * BRF106.getR7_PROVISION_LOAN().intValue()); } Cell cell94 = row4.getCell(16);
		 * if (cell94 != null) {
		 * cell94.setCellValue(BRF106.getR7_OUTSTANDING_OTHER_ASSETS() == null ? 0 :
		 * BRF106.getR7_OUTSTANDING_OTHER_ASSETS().intValue()); } Cell cell95 =
		 * row4.getCell(17); if (cell95 != null) {
		 * cell95.setCellValue(BRF106.getR7_PROVISION_OTHER_ASSETS() == null ? 0 :
		 * BRF106.getR7_PROVISION_OTHER_ASSETS().intValue()); } Cell cell96 =
		 * row4.getCell(20); if (cell96 != null) {
		 * cell96.setCellValue(BRF106.getR7_INTERESTS() == null ? 0 :
		 * BRF106.getR7_INTERESTS().intValue()); } Cell cell97 = row4.getCell(21); if
		 * (cell97 != null) { cell97.setCellValue(BRF106.getR7_EXPOSURE() == null ? 0 :
		 * BRF106.getR7_EXPOSURE().intValue()); } Cell cell98 = row4.getCell(22); if
		 * (cell98 != null) { cell98.setCellValue(BRF106.getR7_UNFUNDED() == null ? 0 :
		 * BRF106.getR7_UNFUNDED().intValue()); } Cell cell99 = row4.getCell(23); if
		 * (cell99 != null) { cell99.setCellValue(BRF106.getR7_OUTSTANDING_UNFUNDED() ==
		 * null ? 0 : BRF106.getR7_OUTSTANDING_UNFUNDED().intValue()); } Cell cell100=
		 * row4.getCell(24); if (cell100 != null) {
		 * cell100.setCellValue(BRF106.getR7_PROVISION_UNFUNDED() == null ? 0 :
		 * BRF106.getR7_PROVISION_UNFUNDED().intValue()); }
		 */
        //srl_no -10
    	
        Row row5 = sheet.getRow(18);
        Cell cell102 = row5.getCell(4);
        if (cell102 != null) {
            cell102.setCellValue(BRF106.getR10_OUTSTANDING_CASH() == null ? 0 :
            	BRF106.getR10_OUTSTANDING_CASH().intValue());
        }
        Cell cell104 = row5.getCell(6);
        if (cell104 != null) {
            cell104.setCellValue(BRF106.getR10_OUTSTANDING_BALANCE() == null ? 0 :
            	BRF106.getR10_OUTSTANDING_BALANCE().intValue());
        }
        Cell cell106 = row5.getCell(8);
        if (cell106 != null) {
            cell106.setCellValue(BRF106.getR10_OUTSTANDING_NON_BANKING() == null ? 0 :
            	BRF106.getR10_OUTSTANDING_NON_BANKING().intValue());
        }   
        Cell cell108 = row5.getCell(10);
        if (cell108 != null) {
            cell108.setCellValue(BRF106.getR10_OUTSTANDING_INVESTMENT() == null ? 0 :
            	BRF106.getR10_OUTSTANDING_INVESTMENT().intValue());
        }	
        Cell cell110 = row5.getCell(12);
        if (cell110 != null) {
            cell110.setCellValue(BRF106.getR10_OUTSTANDING_TRADE() == null ? 0 :
            	BRF106.getR10_OUTSTANDING_TRADE().intValue());
        }
        Cell cell112 = row5.getCell(14);
        if (cell112 != null) {
        	cell112.setCellValue(BRF106.getR10_OUTSTANDING_LOAN() == null ? 0 :
            	BRF106.getR10_OUTSTANDING_LOAN().intValue());
        }
        Cell cell114 = row5.getCell(16);
        if (cell114 != null) {
        	cell114.setCellValue(BRF106.getR10_OUTSTANDING_OTHER_ASSETS() == null ? 0 :
            	BRF106.getR10_OUTSTANDING_OTHER_ASSETS().intValue());
        }
        Cell cell116 = row5.getCell(20);
        if (cell116 != null) {
        	cell116.setCellValue(BRF106.getR10_INTERESTS() == null ? 0 :
            	BRF106.getR10_INTERESTS().intValue());
        }
        Cell cell117 = row5.getCell(21);
        if (cell117 != null) {
        	cell117.setCellValue(BRF106.getR10_EXPOSURE() == null ? 0 :
            	BRF106.getR10_EXPOSURE().intValue());
        }
        Cell cell118 = row5.getCell(22);
        if (cell118 != null) {
        	cell118.setCellValue(BRF106.getR10_UNFUNDED() == null ? 0 :
            	BRF106.getR10_UNFUNDED().intValue());
        }
        Cell cell119 = row5.getCell(23);
        if (cell119 != null) {
        	cell119.setCellValue(BRF106.getR10_OUTSTANDING_UNFUNDED() == null ? 0 :
            	BRF106.getR10_OUTSTANDING_UNFUNDED().intValue());
        }
        Cell cell120= row5.getCell(24);
        if (cell120 != null) {
        	cell120.setCellValue(BRF106.getR10_PROVISION_UNFUNDED() == null ? 0 :
            	BRF106.getR10_PROVISION_UNFUNDED().intValue());
        }
		//srl_no -11
    	
        Row row6 = sheet.getRow(19);
        Cell cell122 = row6.getCell(4);
        if (cell122 != null) {
            cell122.setCellValue(BRF106.getR11_OUTSTANDING_CASH() == null ? 0 :
            	BRF106.getR11_OUTSTANDING_CASH().intValue());
        }
        Cell cell124 = row6.getCell(6);
        if (cell124 != null) {
            cell124.setCellValue(BRF106.getR11_OUTSTANDING_BALANCE() == null ? 0 :
            	BRF106.getR11_OUTSTANDING_BALANCE().intValue());
        }
        Cell cell126 = row6.getCell(8);
        if (cell126 != null) {
            cell126.setCellValue(BRF106.getR11_OUTSTANDING_NON_BANKING() == null ? 0 :
            	BRF106.getR11_OUTSTANDING_NON_BANKING().intValue());
        }   
        Cell cell128 = row6.getCell(10);
        if (cell128 != null) {
            cell128.setCellValue(BRF106.getR11_OUTSTANDING_INVESTMENT() == null ? 0 :
            	BRF106.getR11_OUTSTANDING_INVESTMENT().intValue());
        }	
        Cell cell130 = row6.getCell(12);
        if (cell130 != null) {
            cell130.setCellValue(BRF106.getR11_OUTSTANDING_TRADE() == null ? 0 :
            	BRF106.getR11_OUTSTANDING_TRADE().intValue());
        }
        Cell cell132 = row6.getCell(14);
        if (cell132 != null) {
        	cell132.setCellValue(BRF106.getR11_OUTSTANDING_LOAN() == null ? 0 :
            	BRF106.getR11_OUTSTANDING_LOAN().intValue());
        }
        Cell cell134 = row6.getCell(16);
        if (cell134 != null) {
        	cell134.setCellValue(BRF106.getR11_OUTSTANDING_OTHER_ASSETS() == null ? 0 :
            	BRF106.getR11_OUTSTANDING_OTHER_ASSETS().intValue());
        }
        Cell cell136 = row6.getCell(20);
        if (cell136 != null) {
        	cell136.setCellValue(BRF106.getR11_INTERESTS() == null ? 0 :
            	BRF106.getR11_INTERESTS().intValue());
        }
        Cell cell137 = row6.getCell(21);
        if (cell137 != null) {
        	cell137.setCellValue(BRF106.getR11_EXPOSURE() == null ? 0 :
            	BRF106.getR11_EXPOSURE().intValue());
        }
        Cell cell138 = row6.getCell(22);
        if (cell138 != null) {
        	cell138.setCellValue(BRF106.getR11_UNFUNDED() == null ? 0 :
            	BRF106.getR11_UNFUNDED().intValue());
        }
        Cell cell139 = row6.getCell(23);
        if (cell139 != null) {
        	cell139.setCellValue(BRF106.getR11_OUTSTANDING_UNFUNDED() == null ? 0 :
            	BRF106.getR11_OUTSTANDING_UNFUNDED().intValue());
        }
        Cell cell140= row6.getCell(24);
        if (cell140 != null) {
        	cell140.setCellValue(BRF106.getR11_PROVISION_UNFUNDED() == null ? 0 :
            	BRF106.getR11_PROVISION_UNFUNDED().intValue());
        }
        //srl_no -12
    	
        Row row7 = sheet.getRow(20);
        Cell cell142 = row7.getCell(4);
        if (cell142 != null) {
            cell142.setCellValue(BRF106.getR12_OUTSTANDING_CASH() == null ? 0 :
            	BRF106.getR12_OUTSTANDING_CASH().intValue());
        }
        Cell cell143 = row7.getCell(5);
        if (cell143 != null) {
            cell143.setCellValue(BRF106.getR12_PROVISION_CASH() == null ? 0 :
            	BRF106.getR12_PROVISION_CASH().intValue());
        }
        Cell cell144 = row7.getCell(6);
        if (cell144 != null) {
            cell144.setCellValue(BRF106.getR12_OUTSTANDING_BALANCE() == null ? 0 :
            	BRF106.getR12_OUTSTANDING_BALANCE().intValue());
        }
        Cell cell145 = row7.getCell(7);
        if (cell145 != null) {
            cell145.setCellValue(BRF106.getR12_PROVISION_BALANCE() == null ? 0 :
            	BRF106.getR12_PROVISION_BALANCE().intValue());
        }
        Cell cell146 = row7.getCell(8);
        if (cell146 != null) {
            cell146.setCellValue(BRF106.getR12_OUTSTANDING_NON_BANKING() == null ? 0 :
            	BRF106.getR12_OUTSTANDING_NON_BANKING().intValue());
        }
        Cell cell147 = row7.getCell(9);
        if (cell147 != null) {
            cell147.setCellValue(BRF106.getR12_PROVISION_NON_BANKING() == null ? 0 :
            	BRF106.getR12_PROVISION_NON_BANKING().intValue());
        }
        Cell cell148 = row7.getCell(10);
        if (cell148 != null) {
            cell148.setCellValue(BRF106.getR12_OUTSTANDING_INVESTMENT() == null ? 0 :
            	BRF106.getR12_OUTSTANDING_INVESTMENT().intValue());
        }	
        Cell cell149 = row7.getCell(11);
        if (cell149 != null) {
            cell149.setCellValue(BRF106.getR12_PROVISION_INVESTMENT() == null ? 0 :
            	BRF106.getR12_PROVISION_INVESTMENT().intValue());
        }
        Cell cell150 = row7.getCell(12);
        if (cell150 != null) {
            cell150.setCellValue(BRF106.getR12_OUTSTANDING_TRADE() == null ? 0 :
            	BRF106.getR12_OUTSTANDING_TRADE().intValue());
        }
        Cell cell151 = row7.getCell(13);
        if (cell151 != null) {
            cell151.setCellValue(BRF106.getR12_PROVISION_TRADE() == null ? 0 :
            	BRF106.getR12_PROVISION_TRADE().intValue());
        }
        Cell cell152 = row7.getCell(14);
        if (cell152 != null) {
        	cell152.setCellValue(BRF106.getR12_OUTSTANDING_LOAN() == null ? 0 :
            	BRF106.getR12_OUTSTANDING_LOAN().intValue());
        }
        Cell cell153 = row7.getCell(15);
        if (cell153 != null) {
        	cell153.setCellValue(BRF106.getR12_PROVISION_LOAN() == null ? 0 :
            	BRF106.getR12_PROVISION_LOAN().intValue());
        }
        Cell cell154 = row7.getCell(16);
        if (cell154 != null) {
        	cell154.setCellValue(BRF106.getR12_OUTSTANDING_OTHER_ASSETS() == null ? 0 :
            	BRF106.getR12_OUTSTANDING_OTHER_ASSETS().intValue());
        }
        Cell cell155 = row7.getCell(17);
        if (cell155 != null) {
        	cell155.setCellValue(BRF106.getR12_PROVISION_OTHER_ASSETS() == null ? 0 :
            	BRF106.getR12_PROVISION_OTHER_ASSETS().intValue());
        }
        Cell cell156 = row7.getCell(20);
        if (cell156 != null) {
        	cell156.setCellValue(BRF106.getR12_INTERESTS() == null ? 0 :
            	BRF106.getR12_INTERESTS().intValue());
        }
        Cell cell157 = row7.getCell(21);
        if (cell157 != null) {
        	cell157.setCellValue(BRF106.getR12_EXPOSURE() == null ? 0 :
            	BRF106.getR12_EXPOSURE().intValue());
        }
        Cell cell158 = row7.getCell(22);
        if (cell158 != null) {
        	cell158.setCellValue(BRF106.getR12_UNFUNDED() == null ? 0 :
            	BRF106.getR12_UNFUNDED().intValue());
        }
        Cell cell159 = row7.getCell(23);
        if (cell159 != null) {
        	cell159.setCellValue(BRF106.getR12_OUTSTANDING_UNFUNDED() == null ? 0 :
            	BRF106.getR12_OUTSTANDING_UNFUNDED().intValue());
        }
        Cell cell160= row7.getCell(24);
        if (cell160 != null) {
        	cell160.setCellValue(BRF106.getR12_PROVISION_UNFUNDED() == null ? 0 :
            	BRF106.getR12_PROVISION_UNFUNDED().intValue());
        }
        //srl_no -13
    	
        Row row8 = sheet.getRow(21);
        Cell cell162 = row8.getCell(4);
        if (cell162 != null) {
            cell162.setCellValue(BRF106.getR13_OUTSTANDING_CASH() == null ? 0 :
            	BRF106.getR13_OUTSTANDING_CASH().intValue());
        }
        Cell cell163 = row8.getCell(5);
        if (cell163 != null) {
            cell163.setCellValue(BRF106.getR13_PROVISION_CASH() == null ? 0 :
            	BRF106.getR13_PROVISION_CASH().intValue());
        }
        Cell cell164 = row8.getCell(6);
        if (cell164 != null) {
            cell164.setCellValue(BRF106.getR13_OUTSTANDING_BALANCE() == null ? 0 :
            	BRF106.getR13_OUTSTANDING_BALANCE().intValue());
        }
        Cell cell165 = row8.getCell(7);
        if (cell165 != null) {
            cell165.setCellValue(BRF106.getR13_PROVISION_BALANCE() == null ? 0 :
            	BRF106.getR13_PROVISION_BALANCE().intValue());
        }
        Cell cell166 = row8.getCell(8);
        if (cell166 != null) {
            cell166.setCellValue(BRF106.getR13_OUTSTANDING_NON_BANKING() == null ? 0 :
            	BRF106.getR13_OUTSTANDING_NON_BANKING().intValue());
        }
        Cell cell167 = row8.getCell(9);
        if (cell167 != null) {
            cell167.setCellValue(BRF106.getR13_PROVISION_NON_BANKING() == null ? 0 :
            	BRF106.getR13_PROVISION_NON_BANKING().intValue());
        }
        Cell cell168 = row8.getCell(10);
        if (cell168 != null) {
            cell168.setCellValue(BRF106.getR13_OUTSTANDING_INVESTMENT() == null ? 0 :
            	BRF106.getR13_OUTSTANDING_INVESTMENT().intValue());
        }	
        Cell cell169 = row8.getCell(11);
        if (cell169 != null) {
            cell169.setCellValue(BRF106.getR13_PROVISION_INVESTMENT() == null ? 0 :
            	BRF106.getR13_PROVISION_INVESTMENT().intValue());
        }
        Cell cell170 = row8.getCell(12);
        if (cell170 != null) {
            cell170.setCellValue(BRF106.getR13_OUTSTANDING_TRADE() == null ? 0 :
            	BRF106.getR13_OUTSTANDING_TRADE().intValue());
        }
        Cell cell171 = row8.getCell(13);
        if (cell171 != null) {
            cell171.setCellValue(BRF106.getR13_PROVISION_TRADE() == null ? 0 :
            	BRF106.getR13_PROVISION_TRADE().intValue());
        }
        Cell cell172 = row8.getCell(14);
        if (cell172 != null) {
        	cell172.setCellValue(BRF106.getR13_OUTSTANDING_LOAN() == null ? 0 :
            	BRF106.getR13_OUTSTANDING_LOAN().intValue());
        }
        Cell cell173 = row8.getCell(15);
        if (cell173 != null) {
        	cell173.setCellValue(BRF106.getR13_PROVISION_LOAN() == null ? 0 :
            	BRF106.getR13_PROVISION_LOAN().intValue());
        }
        Cell cell174 = row8.getCell(16);
        if (cell174 != null) {
        	cell174.setCellValue(BRF106.getR13_OUTSTANDING_OTHER_ASSETS() == null ? 0 :
            	BRF106.getR13_OUTSTANDING_OTHER_ASSETS().intValue());
        }
        Cell cell175 = row8.getCell(17);
        if (cell175 != null) {
        	cell175.setCellValue(BRF106.getR13_PROVISION_OTHER_ASSETS() == null ? 0 :
            	BRF106.getR13_PROVISION_OTHER_ASSETS().intValue());
        }
        Cell cell176 = row8.getCell(20);
        if (cell176 != null) {
        	cell176.setCellValue(BRF106.getR13_INTERESTS() == null ? 0 :
            	BRF106.getR13_INTERESTS().intValue());
        }
        Cell cell177 = row8.getCell(21);
        if (cell177 != null) {
        	cell177.setCellValue(BRF106.getR13_EXPOSURE() == null ? 0 :
            	BRF106.getR13_EXPOSURE().intValue());
        }
        Cell cell178 = row8.getCell(22);
        if (cell178 != null) {
        	cell178.setCellValue(BRF106.getR13_UNFUNDED() == null ? 0 :
            	BRF106.getR13_UNFUNDED().intValue());
        }
        Cell cell179 = row8.getCell(23);
        if (cell179 != null) {
        	cell179.setCellValue(BRF106.getR13_OUTSTANDING_UNFUNDED() == null ? 0 :
            	BRF106.getR13_OUTSTANDING_UNFUNDED().intValue());
        }
        Cell cell180= row8.getCell(24);
        if (cell180 != null) {
        	cell180.setCellValue(BRF106.getR13_PROVISION_UNFUNDED() == null ? 0 :
            	BRF106.getR13_PROVISION_UNFUNDED().intValue());
        }
        //srl_no -14
    	
        Row row9 = sheet.getRow(22);
        Cell cell182 = row9.getCell(4);
        if (cell182 != null) {
            cell182.setCellValue(BRF106.getR14_OUTSTANDING_CASH() == null ? 0 :
            	BRF106.getR14_OUTSTANDING_CASH().intValue());
        }
        Cell cell183 = row9.getCell(5);
        if (cell183 != null) {
            cell183.setCellValue(BRF106.getR14_PROVISION_CASH() == null ? 0 :
            	BRF106.getR14_PROVISION_CASH().intValue());
        }
        Cell cell184 = row9.getCell(6);
        if (cell184 != null) {
            cell184.setCellValue(BRF106.getR14_OUTSTANDING_BALANCE() == null ? 0 :
            	BRF106.getR14_OUTSTANDING_BALANCE().intValue());
        }
        Cell cell185 = row9.getCell(7);
        if (cell185 != null) {
            cell185.setCellValue(BRF106.getR14_PROVISION_BALANCE() == null ? 0 :
            	BRF106.getR14_PROVISION_BALANCE().intValue());
        }
        Cell cell186 = row9.getCell(8);
        if (cell186 != null) {
            cell186.setCellValue(BRF106.getR14_OUTSTANDING_NON_BANKING() == null ? 0 :
            	BRF106.getR14_OUTSTANDING_NON_BANKING().intValue());
        }
        Cell cell187 = row9.getCell(9);
        if (cell187 != null) {
            cell187.setCellValue(BRF106.getR14_PROVISION_NON_BANKING() == null ? 0 :
            	BRF106.getR14_PROVISION_NON_BANKING().intValue());
        }
        Cell cell188 = row9.getCell(10);
        if (cell188 != null) {
            cell188.setCellValue(BRF106.getR14_OUTSTANDING_INVESTMENT() == null ? 0 :
            	BRF106.getR14_OUTSTANDING_INVESTMENT().intValue());
        }	
        Cell cell189 = row9.getCell(11);
        if (cell189 != null) {
            cell189.setCellValue(BRF106.getR14_PROVISION_INVESTMENT() == null ? 0 :
            	BRF106.getR14_PROVISION_INVESTMENT().intValue());
        }
        Cell cell190 = row9.getCell(12);
        if (cell190 != null) {
            cell190.setCellValue(BRF106.getR14_OUTSTANDING_TRADE() == null ? 0 :
            	BRF106.getR14_OUTSTANDING_TRADE().intValue());
        }
        Cell cell191 = row9.getCell(13);
        if (cell191 != null) {
            cell191.setCellValue(BRF106.getR14_PROVISION_TRADE() == null ? 0 :
            	BRF106.getR14_PROVISION_TRADE().intValue());
        }
        Cell cell192 = row9.getCell(14);
        if (cell192 != null) {
        	cell192.setCellValue(BRF106.getR14_OUTSTANDING_LOAN() == null ? 0 :
            	BRF106.getR14_OUTSTANDING_LOAN().intValue());
        }
        Cell cell193 = row9.getCell(15);
        if (cell193 != null) {
        	cell193.setCellValue(BRF106.getR14_PROVISION_LOAN() == null ? 0 :
            	BRF106.getR14_PROVISION_LOAN().intValue());
        }
        Cell cell194 = row9.getCell(16);
        if (cell194 != null) {
        	cell194.setCellValue(BRF106.getR14_OUTSTANDING_OTHER_ASSETS() == null ? 0 :
            	BRF106.getR14_OUTSTANDING_OTHER_ASSETS().intValue());
        }
        Cell cell195 = row9.getCell(17);
        if (cell195 != null) {
        	cell195.setCellValue(BRF106.getR14_PROVISION_OTHER_ASSETS() == null ? 0 :
            	BRF106.getR14_PROVISION_OTHER_ASSETS().intValue());
        }
        Cell cell196 = row9.getCell(20);
        if (cell196 != null) {
        	cell196.setCellValue(BRF106.getR14_INTERESTS() == null ? 0 :
            	BRF106.getR14_INTERESTS().intValue());
        }
        Cell cell197 = row9.getCell(21);
        if (cell197 != null) {
        	cell197.setCellValue(BRF106.getR14_EXPOSURE() == null ? 0 :
            	BRF106.getR14_EXPOSURE().intValue());
        }
        Cell cell198 = row9.getCell(22);
        if (cell198 != null) {
        	cell198.setCellValue(BRF106.getR14_UNFUNDED() == null ? 0 :
            	BRF106.getR14_UNFUNDED().intValue());
        }
        Cell cell199 = row9.getCell(23);
        if (cell199 != null) {
        	cell199.setCellValue(BRF106.getR14_OUTSTANDING_UNFUNDED() == null ? 0 :
            	BRF106.getR14_OUTSTANDING_UNFUNDED().intValue());
        }
        Cell cell200= row9.getCell(24);
        if (cell200 != null) {
        	cell200.setCellValue(BRF106.getR14_PROVISION_UNFUNDED() == null ? 0 :
            	BRF106.getR14_PROVISION_UNFUNDED().intValue());
        }
		//srl_no -17
    	
        Row row10 = sheet.getRow(25);
        Cell cell202 = row10.getCell(4);
        if (cell202 != null) {
            cell202.setCellValue(BRF106.getR17_OUTSTANDING_CASH() == null ? 0 :
            	BRF106.getR17_OUTSTANDING_CASH().intValue());
        }
        Cell cell204 = row10.getCell(6);
        if (cell204 != null) {
            cell204.setCellValue(BRF106.getR17_OUTSTANDING_BALANCE() == null ? 0 :
            	BRF106.getR17_OUTSTANDING_BALANCE().intValue());
        }
        Cell cell206 = row10.getCell(8);
        if (cell206 != null) {
            cell206.setCellValue(BRF106.getR17_OUTSTANDING_NON_BANKING() == null ? 0 :
            	BRF106.getR17_OUTSTANDING_NON_BANKING().intValue());
        }   
        Cell cell208 = row10.getCell(10);
        if (cell208 != null) {
            cell208.setCellValue(BRF106.getR17_OUTSTANDING_INVESTMENT() == null ? 0 :
            	BRF106.getR17_OUTSTANDING_INVESTMENT().intValue());
        }	
        Cell cell210 = row10.getCell(12);
        if (cell210 != null) {
            cell210.setCellValue(BRF106.getR17_OUTSTANDING_TRADE() == null ? 0 :
            	BRF106.getR17_OUTSTANDING_TRADE().intValue());
        }
        Cell cell212 = row10.getCell(14);
        if (cell212 != null) {
        	cell212.setCellValue(BRF106.getR17_OUTSTANDING_LOAN() == null ? 0 :
            	BRF106.getR17_OUTSTANDING_LOAN().intValue());
        }
        Cell cell214 = row10.getCell(16);
        if (cell214 != null) {
        	cell214.setCellValue(BRF106.getR17_OUTSTANDING_OTHER_ASSETS() == null ? 0 :
            	BRF106.getR17_OUTSTANDING_OTHER_ASSETS().intValue());
        }
        Cell cell216 = row10.getCell(20);
        if (cell216 != null) {
        	cell216.setCellValue(BRF106.getR17_INTERESTS() == null ? 0 :
            	BRF106.getR17_INTERESTS().intValue());
        }
        Cell cell217 = row10.getCell(21);
        if (cell217 != null) {
        	cell217.setCellValue(BRF106.getR17_EXPOSURE() == null ? 0 :
            	BRF106.getR17_EXPOSURE().intValue());
        }
        Cell cell218 = row10.getCell(22);
        if (cell218 != null) {
        	cell218.setCellValue(BRF106.getR17_UNFUNDED() == null ? 0 :
            	BRF106.getR17_UNFUNDED().intValue());
        }
        Cell cell219 = row10.getCell(23);
        if (cell219 != null) {
        	cell219.setCellValue(BRF106.getR17_OUTSTANDING_UNFUNDED() == null ? 0 :
            	BRF106.getR17_OUTSTANDING_UNFUNDED().intValue());
        }
        Cell cell220= row10.getCell(24);
        if (cell220 != null) {
        	cell220.setCellValue(BRF106.getR17_PROVISION_UNFUNDED() == null ? 0 :
            	BRF106.getR17_PROVISION_UNFUNDED().intValue());
        }
		//srl_no -18
    	
        Row row11 = sheet.getRow(26);
        Cell cell222 = row11.getCell(4);
        if (cell222 != null) {
            cell222.setCellValue(BRF106.getR18_OUTSTANDING_CASH() == null ? 0 :
            	BRF106.getR18_OUTSTANDING_CASH().intValue());
        }
        Cell cell224 = row11.getCell(6);
        if (cell224 != null) {
            cell224.setCellValue(BRF106.getR18_OUTSTANDING_BALANCE() == null ? 0 :
            	BRF106.getR18_OUTSTANDING_BALANCE().intValue());
        }
        Cell cell226 = row11.getCell(8);
        if (cell226 != null) {
            cell226.setCellValue(BRF106.getR18_OUTSTANDING_NON_BANKING() == null ? 0 :
            	BRF106.getR18_OUTSTANDING_NON_BANKING().intValue());
        }   
        Cell cell228 = row11.getCell(10);
        if (cell228 != null) {
            cell228.setCellValue(BRF106.getR18_OUTSTANDING_INVESTMENT() == null ? 0 :
            	BRF106.getR18_OUTSTANDING_INVESTMENT().intValue());
        }	
        Cell cell230 = row11.getCell(12);
        if (cell230 != null) {
            cell230.setCellValue(BRF106.getR18_OUTSTANDING_TRADE() == null ? 0 :
            	BRF106.getR18_OUTSTANDING_TRADE().intValue());
        }
        Cell cell232 = row11.getCell(14);
        if (cell232 != null) {
        	cell232.setCellValue(BRF106.getR18_OUTSTANDING_LOAN() == null ? 0 :
            	BRF106.getR18_OUTSTANDING_LOAN().intValue());
        }
        Cell cell234 = row11.getCell(16);
        if (cell234 != null) {
        	cell234.setCellValue(BRF106.getR18_OUTSTANDING_OTHER_ASSETS() == null ? 0 :
            	BRF106.getR18_OUTSTANDING_OTHER_ASSETS().intValue());
        }
        Cell cell236 = row11.getCell(20);
        if (cell236 != null) {
        	cell236.setCellValue(BRF106.getR18_INTERESTS() == null ? 0 :
            	BRF106.getR18_INTERESTS().intValue());
        }
        Cell cell237 = row11.getCell(21);
        if (cell237 != null) {
        	cell237.setCellValue(BRF106.getR18_EXPOSURE() == null ? 0 :
            	BRF106.getR18_EXPOSURE().intValue());
        }
        Cell cell238 = row11.getCell(22);
        if (cell238 != null) {
        	cell238.setCellValue(BRF106.getR18_UNFUNDED() == null ? 0 :
            	BRF106.getR18_UNFUNDED().intValue());
        }
        Cell cell239 = row11.getCell(23);
        if (cell239 != null) {
        	cell239.setCellValue(BRF106.getR18_OUTSTANDING_UNFUNDED() == null ? 0 :
            	BRF106.getR18_OUTSTANDING_UNFUNDED().intValue());
        }
        Cell cell240= row11.getCell(24);
        if (cell240 != null) {
        	cell240.setCellValue(BRF106.getR18_PROVISION_UNFUNDED() == null ? 0 :
            	BRF106.getR18_PROVISION_UNFUNDED().intValue());
        }
        //srl_no -19
    	
        Row row12 = sheet.getRow(27);
        Cell cell242 = row12.getCell(4);
        if (cell242 != null) {
            cell242.setCellValue(BRF106.getR19_OUTSTANDING_CASH() == null ? 0 :
            	BRF106.getR19_OUTSTANDING_CASH().intValue());
        }
        Cell cell243 = row12.getCell(5);
        if (cell243 != null) {
            cell243.setCellValue(BRF106.getR19_PROVISION_CASH() == null ? 0 :
            	BRF106.getR19_PROVISION_CASH().intValue());
        }
        Cell cell244 = row12.getCell(6);
        if (cell244 != null) {
            cell244.setCellValue(BRF106.getR19_OUTSTANDING_BALANCE() == null ? 0 :
            	BRF106.getR19_OUTSTANDING_BALANCE().intValue());
        }
        Cell cell245 = row12.getCell(7);
        if (cell245 != null) {
            cell245.setCellValue(BRF106.getR19_PROVISION_BALANCE() == null ? 0 :
            	BRF106.getR19_PROVISION_BALANCE().intValue());
        }
        Cell cell246 = row12.getCell(8);
        if (cell246 != null) {
            cell246.setCellValue(BRF106.getR19_OUTSTANDING_NON_BANKING() == null ? 0 :
            	BRF106.getR19_OUTSTANDING_NON_BANKING().intValue());
        }
        Cell cell247 = row12.getCell(9);
        if (cell247 != null) {
            cell247.setCellValue(BRF106.getR19_PROVISION_NON_BANKING() == null ? 0 :
            	BRF106.getR19_PROVISION_NON_BANKING().intValue());
        }
        Cell cell248 = row12.getCell(10);
        if (cell248 != null) {
            cell248.setCellValue(BRF106.getR19_OUTSTANDING_INVESTMENT() == null ? 0 :
            	BRF106.getR19_OUTSTANDING_INVESTMENT().intValue());
        }	
        Cell cell249 = row12.getCell(11);
        if (cell249 != null) {
            cell249.setCellValue(BRF106.getR19_PROVISION_INVESTMENT() == null ? 0 :
            	BRF106.getR19_PROVISION_INVESTMENT().intValue());
        }
        Cell cell250 = row12.getCell(12);
        if (cell250 != null) {
            cell250.setCellValue(BRF106.getR19_OUTSTANDING_TRADE() == null ? 0 :
            	BRF106.getR19_OUTSTANDING_TRADE().intValue());
        }
        Cell cell251 = row12.getCell(13);
        if (cell251 != null) {
            cell251.setCellValue(BRF106.getR19_PROVISION_TRADE() == null ? 0 :
            	BRF106.getR19_PROVISION_TRADE().intValue());
        }
        Cell cell252 = row12.getCell(14);
        if (cell252 != null) {
        	cell252.setCellValue(BRF106.getR19_OUTSTANDING_LOAN() == null ? 0 :
            	BRF106.getR19_OUTSTANDING_LOAN().intValue());
        }
        Cell cell253 = row12.getCell(15);
        if (cell253 != null) {
        	cell253.setCellValue(BRF106.getR19_PROVISION_LOAN() == null ? 0 :
            	BRF106.getR19_PROVISION_LOAN().intValue());
        }
        Cell cell254 = row12.getCell(16);
        if (cell254 != null) {
        	cell254.setCellValue(BRF106.getR19_OUTSTANDING_OTHER_ASSETS() == null ? 0 :
            	BRF106.getR19_OUTSTANDING_OTHER_ASSETS().intValue());
        }
        Cell cell255 = row12.getCell(17);
        if (cell255 != null) {
        	cell255.setCellValue(BRF106.getR19_PROVISION_OTHER_ASSETS() == null ? 0 :
            	BRF106.getR19_PROVISION_OTHER_ASSETS().intValue());
        }
        Cell cell256 = row12.getCell(20);
        if (cell256 != null) {
        	cell256.setCellValue(BRF106.getR19_INTERESTS() == null ? 0 :
            	BRF106.getR19_INTERESTS().intValue());
        }
        Cell cell257 = row12.getCell(21);
        if (cell257 != null) {
        	cell257.setCellValue(BRF106.getR19_EXPOSURE() == null ? 0 :
            	BRF106.getR19_EXPOSURE().intValue());
        }
        Cell cell258 = row12.getCell(22);
        if (cell258 != null) {
        	cell258.setCellValue(BRF106.getR19_UNFUNDED() == null ? 0 :
            	BRF106.getR19_UNFUNDED().intValue());
        }
        Cell cell259 = row12.getCell(23);
        if (cell259 != null) {
        	cell259.setCellValue(BRF106.getR19_OUTSTANDING_UNFUNDED() == null ? 0 :
            	BRF106.getR19_OUTSTANDING_UNFUNDED().intValue());
        }
        Cell cell260= row12.getCell(24);
        if (cell260 != null) {
        	cell260.setCellValue(BRF106.getR19_PROVISION_UNFUNDED() == null ? 0 :
            	BRF106.getR19_PROVISION_UNFUNDED().intValue());
        }
        //srl_no -20
    	
        Row row13 = sheet.getRow(28);
        Cell cell262 = row13.getCell(4);
        if (cell262 != null) {
            cell262.setCellValue(BRF106.getR20_OUTSTANDING_CASH() == null ? 0 :
            	BRF106.getR20_OUTSTANDING_CASH().intValue());
        }
        Cell cell263 = row13.getCell(5);
        if (cell263 != null) {
            cell263.setCellValue(BRF106.getR20_PROVISION_CASH() == null ? 0 :
            	BRF106.getR20_PROVISION_CASH().intValue());
        }
        Cell cell264 = row13.getCell(6);
        if (cell264 != null) {
            cell264.setCellValue(BRF106.getR20_OUTSTANDING_BALANCE() == null ? 0 :
            	BRF106.getR20_OUTSTANDING_BALANCE().intValue());
        }
        Cell cell265 = row13.getCell(7);
        if (cell265 != null) {
            cell265.setCellValue(BRF106.getR20_PROVISION_BALANCE() == null ? 0 :
            	BRF106.getR20_PROVISION_BALANCE().intValue());
        }
        Cell cell266 = row13.getCell(8);
        if (cell266 != null) {
            cell266.setCellValue(BRF106.getR20_OUTSTANDING_NON_BANKING() == null ? 0 :
            	BRF106.getR20_OUTSTANDING_NON_BANKING().intValue());
        }
        Cell cell267 = row13.getCell(9);
        if (cell267 != null) {
            cell267.setCellValue(BRF106.getR20_PROVISION_NON_BANKING() == null ? 0 :
            	BRF106.getR20_PROVISION_NON_BANKING().intValue());
        }
        Cell cell268 = row13.getCell(10);
        if (cell268 != null) {
            cell268.setCellValue(BRF106.getR20_OUTSTANDING_INVESTMENT() == null ? 0 :
            	BRF106.getR20_OUTSTANDING_INVESTMENT().intValue());
        }	
        Cell cell269 = row13.getCell(11);
        if (cell269 != null) {
            cell269.setCellValue(BRF106.getR20_PROVISION_INVESTMENT() == null ? 0 :
            	BRF106.getR20_PROVISION_INVESTMENT().intValue());
        }
        Cell cell270 = row13.getCell(12);
        if (cell270 != null) {
            cell270.setCellValue(BRF106.getR20_OUTSTANDING_TRADE() == null ? 0 :
            	BRF106.getR20_OUTSTANDING_TRADE().intValue());
        }
        Cell cell271 = row13.getCell(13);
        if (cell271 != null) {
            cell271.setCellValue(BRF106.getR20_PROVISION_TRADE() == null ? 0 :
            	BRF106.getR20_PROVISION_TRADE().intValue());
        }
        Cell cell272 = row13.getCell(14);
        if (cell272 != null) {
        	cell272.setCellValue(BRF106.getR20_OUTSTANDING_LOAN() == null ? 0 :
            	BRF106.getR20_OUTSTANDING_LOAN().intValue());
        }
        Cell cell273 = row13.getCell(15);
        if (cell273 != null) {
        	cell273.setCellValue(BRF106.getR20_PROVISION_LOAN() == null ? 0 :
            	BRF106.getR20_PROVISION_LOAN().intValue());
        }
        Cell cell274 = row13.getCell(16);
        if (cell274 != null) {
        	cell274.setCellValue(BRF106.getR20_OUTSTANDING_OTHER_ASSETS() == null ? 0 :
            	BRF106.getR20_OUTSTANDING_OTHER_ASSETS().intValue());
        }
        Cell cell275 = row13.getCell(17);
        if (cell275 != null) {
        	cell275.setCellValue(BRF106.getR20_PROVISION_OTHER_ASSETS() == null ? 0 :
            	BRF106.getR20_PROVISION_OTHER_ASSETS().intValue());
        }
        Cell cell276 = row13.getCell(20);
        if (cell276 != null) {
        	cell276.setCellValue(BRF106.getR20_INTERESTS() == null ? 0 :
            	BRF106.getR20_INTERESTS().intValue());
        }
        Cell cell277 = row13.getCell(21);
        if (cell277 != null) {
        	cell277.setCellValue(BRF106.getR20_EXPOSURE() == null ? 0 :
            	BRF106.getR20_EXPOSURE().intValue());
        }
        Cell cell278 = row13.getCell(22);
        if (cell278 != null) {
        	cell278.setCellValue(BRF106.getR20_UNFUNDED() == null ? 0 :
            	BRF106.getR20_UNFUNDED().intValue());
        }
        Cell cell279 = row13.getCell(23);
        if (cell279 != null) {
        	cell279.setCellValue(BRF106.getR20_OUTSTANDING_UNFUNDED() == null ? 0 :
            	BRF106.getR20_OUTSTANDING_UNFUNDED().intValue());
        }
        Cell cell280= row13.getCell(24);
        if (cell280 != null) {
        	cell280.setCellValue(BRF106.getR20_PROVISION_UNFUNDED() == null ? 0 :
            	BRF106.getR20_PROVISION_UNFUNDED().intValue());
        }
        //srl_no -21
    	
        Row row14 = sheet.getRow(29);
        Cell cell282 = row14.getCell(4);
        if (cell282 != null) {
            cell282.setCellValue(BRF106.getR21_OUTSTANDING_CASH() == null ? 0 :
            	BRF106.getR21_OUTSTANDING_CASH().intValue());
        }
        Cell cell283 = row14.getCell(5);
        if (cell283 != null) {
            cell283.setCellValue(BRF106.getR21_PROVISION_CASH() == null ? 0 :
            	BRF106.getR21_PROVISION_CASH().intValue());
        }
        Cell cell284 = row14.getCell(6);
        if (cell284 != null) {
            cell284.setCellValue(BRF106.getR21_OUTSTANDING_BALANCE() == null ? 0 :
            	BRF106.getR21_OUTSTANDING_BALANCE().intValue());
        }
        Cell cell285 = row14.getCell(7);
        if (cell285 != null) {
            cell285.setCellValue(BRF106.getR21_PROVISION_BALANCE() == null ? 0 :
            	BRF106.getR21_PROVISION_BALANCE().intValue());
        }
        Cell cell286 = row14.getCell(8);
        if (cell286 != null) {
            cell286.setCellValue(BRF106.getR21_OUTSTANDING_NON_BANKING() == null ? 0 :
            	BRF106.getR21_OUTSTANDING_NON_BANKING().intValue());
        }
        Cell cell287 = row14.getCell(9);
        if (cell287 != null) {
            cell287.setCellValue(BRF106.getR21_PROVISION_NON_BANKING() == null ? 0 :
            	BRF106.getR21_PROVISION_NON_BANKING().intValue());
        }
        Cell cell288 = row14.getCell(10);
        if (cell288 != null) {
            cell288.setCellValue(BRF106.getR21_OUTSTANDING_INVESTMENT() == null ? 0 :
            	BRF106.getR21_OUTSTANDING_INVESTMENT().intValue());
        }	
        Cell cell289 = row14.getCell(11);
        if (cell289 != null) {
            cell289.setCellValue(BRF106.getR21_PROVISION_INVESTMENT() == null ? 0 :
            	BRF106.getR21_PROVISION_INVESTMENT().intValue());
        }
        Cell cell290 = row14.getCell(12);
        if (cell290 != null) {
            cell290.setCellValue(BRF106.getR21_OUTSTANDING_TRADE() == null ? 0 :
            	BRF106.getR21_OUTSTANDING_TRADE().intValue());
        }
        Cell cell291 = row14.getCell(13);
        if (cell291 != null) {
            cell291.setCellValue(BRF106.getR21_PROVISION_TRADE() == null ? 0 :
            	BRF106.getR21_PROVISION_TRADE().intValue());
        }
        Cell cell292 = row14.getCell(14);
        if (cell292 != null) {
        	cell292.setCellValue(BRF106.getR21_OUTSTANDING_LOAN() == null ? 0 :
            	BRF106.getR21_OUTSTANDING_LOAN().intValue());
        }
        Cell cell293 = row14.getCell(15);
        if (cell293 != null) {
        	cell293.setCellValue(BRF106.getR21_PROVISION_LOAN() == null ? 0 :
            	BRF106.getR21_PROVISION_LOAN().intValue());
        }
        Cell cell294 = row14.getCell(16);
        if (cell294 != null) {
        	cell294.setCellValue(BRF106.getR21_OUTSTANDING_OTHER_ASSETS() == null ? 0 :
            	BRF106.getR21_OUTSTANDING_OTHER_ASSETS().intValue());
        }
        Cell cell295 = row14.getCell(17);
        if (cell295 != null) {
        	cell295.setCellValue(BRF106.getR21_PROVISION_OTHER_ASSETS() == null ? 0 :
            	BRF106.getR21_PROVISION_OTHER_ASSETS().intValue());
        }
        Cell cell296 = row14.getCell(20);
        if (cell296 != null) {
        	cell296.setCellValue(BRF106.getR21_INTERESTS() == null ? 0 :
            	BRF106.getR21_INTERESTS().intValue());
        }
        Cell cell297 = row14.getCell(21);
        if (cell297 != null) {
        	cell297.setCellValue(BRF106.getR21_EXPOSURE() == null ? 0 :
            	BRF106.getR21_EXPOSURE().intValue());
        }
        Cell cell298 = row14.getCell(22);
        if (cell298 != null) {
        	cell298.setCellValue(BRF106.getR21_UNFUNDED() == null ? 0 :
            	BRF106.getR21_UNFUNDED().intValue());
        }
        Cell cell299 = row14.getCell(23);
        if (cell299 != null) {
        	cell299.setCellValue(BRF106.getR21_OUTSTANDING_UNFUNDED() == null ? 0 :
            	BRF106.getR21_OUTSTANDING_UNFUNDED().intValue());
        }
        Cell cell300= row14.getCell(24);
        if (cell300 != null) {
        	cell300.setCellValue(BRF106.getR21_PROVISION_UNFUNDED() == null ? 0 :
            	BRF106.getR21_PROVISION_UNFUNDED().intValue());
        }
        //srl_no -22
    	
        Row row15 = sheet.getRow(30);
        Cell cell302 = row15.getCell(4);
        if (cell302 != null) {
            cell302.setCellValue(BRF106.getR22_OUTSTANDING_CASH() == null ? 0 :
            	BRF106.getR22_OUTSTANDING_CASH().intValue());
        }
        Cell cell303 = row15.getCell(5);
        if (cell303 != null) {
            cell303.setCellValue(BRF106.getR22_PROVISION_CASH() == null ? 0 :
            	BRF106.getR22_PROVISION_CASH().intValue());
        }
        Cell cell304 = row15.getCell(6);
        if (cell304 != null) {
            cell304.setCellValue(BRF106.getR22_OUTSTANDING_BALANCE() == null ? 0 :
            	BRF106.getR22_OUTSTANDING_BALANCE().intValue());
        }
        Cell cell305 = row15.getCell(7);
        if (cell305 != null) {
            cell305.setCellValue(BRF106.getR22_PROVISION_BALANCE() == null ? 0 :
            	BRF106.getR22_PROVISION_BALANCE().intValue());
        }
        Cell cell306 = row15.getCell(8);
        if (cell306 != null) {
            cell306.setCellValue(BRF106.getR22_OUTSTANDING_NON_BANKING() == null ? 0 :
            	BRF106.getR22_OUTSTANDING_NON_BANKING().intValue());
        }
        Cell cell307 = row15.getCell(9);
        if (cell307 != null) {
            cell307.setCellValue(BRF106.getR22_PROVISION_NON_BANKING() == null ? 0 :
            	BRF106.getR22_PROVISION_NON_BANKING().intValue());
        }
        Cell cell308 = row15.getCell(10);
        if (cell308 != null) {
            cell308.setCellValue(BRF106.getR22_OUTSTANDING_INVESTMENT() == null ? 0 :
            	BRF106.getR22_OUTSTANDING_INVESTMENT().intValue());
        }	
        Cell cell309 = row15.getCell(11);
        if (cell309 != null) {
            cell309.setCellValue(BRF106.getR22_PROVISION_INVESTMENT() == null ? 0 :
            	BRF106.getR22_PROVISION_INVESTMENT().intValue());
        }
        Cell cell310 = row15.getCell(12);
        if (cell310 != null) {
            cell310.setCellValue(BRF106.getR22_OUTSTANDING_TRADE() == null ? 0 :
            	BRF106.getR22_OUTSTANDING_TRADE().intValue());
        }
        Cell cell311 = row15.getCell(13);
        if (cell311 != null) {
            cell311.setCellValue(BRF106.getR22_PROVISION_TRADE() == null ? 0 :
            	BRF106.getR22_PROVISION_TRADE().intValue());
        }
        Cell cell312 = row15.getCell(14);
        if (cell312 != null) {
        	cell312.setCellValue(BRF106.getR22_OUTSTANDING_LOAN() == null ? 0 :
            	BRF106.getR22_OUTSTANDING_LOAN().intValue());
        }
        Cell cell313 = row15.getCell(15);
        if (cell313 != null) {
        	cell313.setCellValue(BRF106.getR22_PROVISION_LOAN() == null ? 0 :
            	BRF106.getR22_PROVISION_LOAN().intValue());
        }
        Cell cell314 = row15.getCell(16);
        if (cell314 != null) {
        	cell314.setCellValue(BRF106.getR22_OUTSTANDING_OTHER_ASSETS() == null ? 0 :
            	BRF106.getR22_OUTSTANDING_OTHER_ASSETS().intValue());
        }
        Cell cell315 = row15.getCell(17);
        if (cell315 != null) {
        	cell315.setCellValue(BRF106.getR22_PROVISION_OTHER_ASSETS() == null ? 0 :
            	BRF106.getR22_PROVISION_OTHER_ASSETS().intValue());
        }
        Cell cell316 = row15.getCell(20);
        if (cell316 != null) {
        	cell316.setCellValue(BRF106.getR22_INTERESTS() == null ? 0 :
            	BRF106.getR22_INTERESTS().intValue());
        }
        Cell cell317 = row15.getCell(21);
        if (cell317 != null) {
        	cell317.setCellValue(BRF106.getR22_EXPOSURE() == null ? 0 :
            	BRF106.getR22_EXPOSURE().intValue());
        }
        Cell cell318 = row15.getCell(22);
        if (cell318 != null) {
        	cell318.setCellValue(BRF106.getR22_UNFUNDED() == null ? 0 :
            	BRF106.getR22_UNFUNDED().intValue());
        }
        Cell cell319 = row15.getCell(23);
        if (cell319 != null) {
        	cell319.setCellValue(BRF106.getR22_OUTSTANDING_UNFUNDED() == null ? 0 :
            	BRF106.getR22_OUTSTANDING_UNFUNDED().intValue());
        }
        Cell cell320= row15.getCell(24);
        if (cell320 != null) {
        	cell320.setCellValue(BRF106.getR22_PROVISION_UNFUNDED() == null ? 0 :
            	BRF106.getR22_PROVISION_UNFUNDED().intValue());
        }
        //srl_no -23
    	
        Row row16 = sheet.getRow(31);
        Cell cell322 = row16.getCell(4);
        if (cell322 != null) {
            cell322.setCellValue(BRF106.getR23_OUTSTANDING_CASH() == null ? 0 :
            	BRF106.getR23_OUTSTANDING_CASH().intValue());
        }
        Cell cell323 = row16.getCell(5);
        if (cell323 != null) {
            cell323.setCellValue(BRF106.getR23_PROVISION_CASH() == null ? 0 :
            	BRF106.getR23_PROVISION_CASH().intValue());
        }
        Cell cell324 = row16.getCell(6);
        if (cell324 != null) {
            cell324.setCellValue(BRF106.getR23_OUTSTANDING_BALANCE() == null ? 0 :
            	BRF106.getR23_OUTSTANDING_BALANCE().intValue());
        }
        Cell cell325 = row16.getCell(7);
        if (cell325 != null) {
            cell325.setCellValue(BRF106.getR23_PROVISION_BALANCE() == null ? 0 :
            	BRF106.getR23_PROVISION_BALANCE().intValue());
        }
        Cell cell326 = row16.getCell(8);
        if (cell326 != null) {
            cell326.setCellValue(BRF106.getR23_OUTSTANDING_NON_BANKING() == null ? 0 :
            	BRF106.getR23_OUTSTANDING_NON_BANKING().intValue());
        }
        Cell cell327 = row16.getCell(9);
        if (cell327 != null) {
            cell327.setCellValue(BRF106.getR23_PROVISION_NON_BANKING() == null ? 0 :
            	BRF106.getR23_PROVISION_NON_BANKING().intValue());
        }
        Cell cell328 = row16.getCell(10);
        if (cell328 != null) {
            cell328.setCellValue(BRF106.getR23_OUTSTANDING_INVESTMENT() == null ? 0 :
            	BRF106.getR23_OUTSTANDING_INVESTMENT().intValue());
        }	
        Cell cell329 = row16.getCell(11);
        if (cell329 != null) {
            cell329.setCellValue(BRF106.getR23_PROVISION_INVESTMENT() == null ? 0 :
            	BRF106.getR23_PROVISION_INVESTMENT().intValue());
        }
        Cell cell330 = row16.getCell(12);
        if (cell330 != null) {
            cell330.setCellValue(BRF106.getR23_OUTSTANDING_TRADE() == null ? 0 :
            	BRF106.getR23_OUTSTANDING_TRADE().intValue());
        }
        Cell cell331 = row16.getCell(13);
        if (cell331 != null) {
            cell331.setCellValue(BRF106.getR23_PROVISION_TRADE() == null ? 0 :
            	BRF106.getR23_PROVISION_TRADE().intValue());
        }
        Cell cell332 = row16.getCell(14);
        if (cell332 != null) {
        	cell332.setCellValue(BRF106.getR23_OUTSTANDING_LOAN() == null ? 0 :
            	BRF106.getR23_OUTSTANDING_LOAN().intValue());
        }
        Cell cell333 = row16.getCell(15);
        if (cell333 != null) {
        	cell333.setCellValue(BRF106.getR23_PROVISION_LOAN() == null ? 0 :
            	BRF106.getR23_PROVISION_LOAN().intValue());
        }
        Cell cell334 = row16.getCell(16);
        if (cell334 != null) {
        	cell334.setCellValue(BRF106.getR23_OUTSTANDING_OTHER_ASSETS() == null ? 0 :
            	BRF106.getR23_OUTSTANDING_OTHER_ASSETS().intValue());
        }
        Cell cell335 = row16.getCell(17);
        if (cell335 != null) {
        	cell335.setCellValue(BRF106.getR23_PROVISION_OTHER_ASSETS() == null ? 0 :
            	BRF106.getR23_PROVISION_OTHER_ASSETS().intValue());
        }
        Cell cell336 = row16.getCell(20);
        if (cell336 != null) {
        	cell336.setCellValue(BRF106.getR23_INTERESTS() == null ? 0 :
            	BRF106.getR23_INTERESTS().intValue());
        }
        Cell cell337 = row16.getCell(21);
        if (cell337 != null) {
        	cell337.setCellValue(BRF106.getR23_EXPOSURE() == null ? 0 :
            	BRF106.getR23_EXPOSURE().intValue());
        }
        Cell cell338 = row16.getCell(22);
        if (cell338 != null) {
        	cell338.setCellValue(BRF106.getR23_UNFUNDED() == null ? 0 :
            	BRF106.getR23_UNFUNDED().intValue());
        }
        Cell cell339 = row16.getCell(23);
        if (cell339 != null) {
        	cell339.setCellValue(BRF106.getR23_OUTSTANDING_UNFUNDED() == null ? 0 :
            	BRF106.getR23_OUTSTANDING_UNFUNDED().intValue());
        }
        Cell cell340= row16.getCell(24);
        if (cell340 != null) {
        	cell340.setCellValue(BRF106.getR23_PROVISION_UNFUNDED() == null ? 0 :
            	BRF106.getR23_PROVISION_UNFUNDED().intValue());
        }
        //srl_no -26(Subtotal - not covered under IFRS -9)
    	
        Row row17 = sheet.getRow(34);
        Cell cell342 = row17.getCell(4);
        if (cell342 != null) {
            cell342.setCellValue(BRF106.getR26_OUTSTANDING_CASH() == null ? 0 :
            	BRF106.getR26_OUTSTANDING_CASH().intValue());
        }    
        Cell cell344 = row17.getCell(6);
        if (cell344 != null) {
            cell344.setCellValue(BRF106.getR26_OUTSTANDING_BALANCE() == null ? 0 :
            	BRF106.getR26_OUTSTANDING_BALANCE().intValue());
        }  
        Cell cell346 = row17.getCell(8);
        if (cell346 != null) {
            cell346.setCellValue(BRF106.getR26_OUTSTANDING_NON_BANKING() == null ? 0 :
            	BRF106.getR26_OUTSTANDING_NON_BANKING().intValue());
        }
        Cell cell348 = row17.getCell(10);
        if (cell348 != null) {
            cell348.setCellValue(BRF106.getR26_OUTSTANDING_INVESTMENT() == null ? 0 :
            	BRF106.getR26_OUTSTANDING_INVESTMENT().intValue());
        }	
        Cell cell350 = row17.getCell(12);
        if (cell350 != null) {
            cell350.setCellValue(BRF106.getR26_OUTSTANDING_TRADE() == null ? 0 :
            	BRF106.getR26_OUTSTANDING_TRADE().intValue());
        }
        Cell cell352 = row17.getCell(14);
        if (cell352 != null) {
        	cell352.setCellValue(BRF106.getR26_OUTSTANDING_LOAN() == null ? 0 :
            	BRF106.getR26_OUTSTANDING_LOAN().intValue());
        }
        Cell cell354 = row17.getCell(16);
        if (cell354 != null) {
        	cell354.setCellValue(BRF106.getR26_OUTSTANDING_OTHER_ASSETS() == null ? 0 :
            	BRF106.getR26_OUTSTANDING_OTHER_ASSETS().intValue());
        }
        Cell cell355 = row17.getCell(18);
        if (cell355 != null) {
        	cell355.setCellValue(BRF106.getR26_OUTSTANDING_TOTAL() == null ? 0 :
            	BRF106.getR26_OUTSTANDING_TOTAL().intValue());
        }    
        Cell cell358 = row17.getCell(22);
        if (cell358 != null) {
        	cell358.setCellValue(BRF106.getR26_UNFUNDED() == null ? 0 :
            	BRF106.getR26_UNFUNDED().intValue());
        }
        //srl_no -28(All other BRF - 1 items not covered in the above headings i.e. gross sum of Line item: 2, 6, 9, 10, 12 of BRF 1)
    	
        Row row18 = sheet.getRow(36);
        Cell cell362 = row18.getCell(18);
        if (cell362 != null) {
        	cell362.setCellValue(BRF106.getR28_OUTSTANDING_TOTAL() == null ? 0 :
            	BRF106.getR28_OUTSTANDING_TOTAL().intValue());
        } 
        // Save the changes
        workbook.getCreationHelper().createFormulaEvaluator().evaluateAll();
        FileOutputStream fileOut = new FileOutputStream(env.getProperty("output.exportpathfinal")+"011-BRF-106-A.xls");
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
outputFile = new File(env.getProperty("output.exportpathfinal")+"011-BRF-106-A.xls");

return outputFile;



}
        	
        
	
	public String detailChanges106(BRF106_DETAIL_ENTITY detail, String foracid, String report_addl_criteria_1,
			BigDecimal act_balance_amt_lc, String report_label_1, String report_name_1) {

		String msg = "";

		/*
		 * try {
		 * 
		 * Session hs = sessionFactory.getCurrentSession();
		 * Optional<BRF106_DETAIL_ENTITY> Brf106detail =
		 * bRF106DETAIL_Repo.findById(foracid);
		 * 
		 * if (Brf106detail.isPresent()) { BRF106_DETAIL_ENTITY BRFdetail =
		 * Brf106detail.get();
		 * 
		 * if (BRFdetail.getReport_label_1().equals(report_label_1) &&
		 * BRFdetail.getReport_name_1().equals(report_name_1) &&
		 * BRFdetail.getAct_balance_amt_lc().equals(act_balance_amt_lc) &&
		 * BRFdetail.getReport_addl_criteria_1().equals(report_addl_criteria_1)
		 * 
		 * ) { msg = "No modification done"; } else {
		 * 
		 * BRFdetail.setAct_balance_amt_lc(act_balance_amt_lc);
		 * BRFdetail.setReport_label_1(report_label_1);
		 * BRFdetail.setReport_name_1(report_name_1);
		 * BRFdetail.setReport_addl_criteria_1(report_addl_criteria_1);
		 * bRF106DETAIL_Repo.save(BRFdetail);
		 * 
		 * // hs.saveOrUpdate(detail); logger.info("Edited Record"); msg =
		 * "Edited Successfully"; } } else { msg = "No data Found"; }
		 * 
		 * } catch (Exception e) {
		 * 
		 * msg = "error occured. Please contact Administrator"; e.printStackTrace(); }
		 */
		return msg;
	}
	

	public ModelAndView getArchieveBRF106View(String reportId, String fromdate, String todate, String currency,
			String dtltype, Pageable pageable) {

		ModelAndView mv = new ModelAndView();
		Session hs = sessionFactory.getCurrentSession();
		int pageSize = pageable.getPageSize();
		int currentPage = pageable.getPageNumber();
		int startItem = currentPage * pageSize;
		List<BRF_106_A_REPORT_ENTITY> T1rep = new ArrayList<BRF_106_A_REPORT_ENTITY>();
// Query<Object[]> qr;

		List<BRF_106_A_REPORT_ENTITY> T1Master = new ArrayList<BRF_106_A_REPORT_ENTITY>();
		/* List<BRF73_TABLE2> T1Master1 = new ArrayList<BRF73_TABLE2>(); */

		logger.info("Inside archive" + currency);

		try {
			Date d1 = df.parse(todate);
			// T1rep = t1CurProdServiceRepo.getT1CurProdServices(d1);

			T1Master = hs.createQuery("from  BRF_106_A_REPORT_ENTITY a where a.report_date = ?1 ", BRF_106_A_REPORT_ENTITY.class)
					.setParameter(1, df.parse(todate)).getResultList();

			/*
			 * T1Master1 = hs.createQuery("from BRF73_TABLE2 a where a.report_date = ?1 ",
			 * BRF73_TABLE2.class) .setParameter(1, df.parse(todate)).getResultList();
			 */

		} catch (ParseException e) {
			e.printStackTrace();
		}

// T1rep = t1CurProdServiceRepo.getT1CurProdServices(d1);

		mv.setViewName("RR/BRF106ARCH");
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

	public ModelAndView ARCHgetBRF106currentDtl(String reportId, String fromdate, String todate, String currency,
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
						"select * from BRF106_ARCHIVTABLE a where report_date=?1 and report_label_1=?2");
				qr.setParameter(1, df.parse(todate));
				qr.setParameter(2, filter);

			} else {
				System.out.println("2");
				qr = hs.createNativeQuery("select * from BRF106_ARCHIVTABLE");

			}
		} else {
			System.out.println("3");
			qr = hs.createNativeQuery("select * from BRF106_ARCHIVTABLE  where report_date = ?1");
		}

		List<BRF106_ARCHIVENTITY> T1Master = new ArrayList<BRF106_ARCHIVENTITY>();

		try {
			System.out.println("Values entered");
			T1Master = hs.createQuery("from BRF106_ARCHIVENTITY a where a.report_date = ?1", BRF106_ARCHIVENTITY.class)
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

			BRF106_ARCHIVENTITY py = new BRF106_ARCHIVENTITY(cust_id, foracid, act_balance_amt_lc, eab_lc, acct_name, acct_crncy_code, gl_code, gl_sub_head_code,
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
		mv.setViewName("RR" + "/" + "BRF106ARCH::reportcontent");
		mv.addObject("reportdetails", T1Dt1Page.getContent());
		mv.addObject("reportmaster", T1Master);
		mv.addObject("reportmaster1", qr);
		mv.addObject("singledetail", new T1CurProdDetail());
		mv.addObject("reportsflag", "reportsflag");
		mv.addObject("menu", reportId);
		return mv;
	}

}
