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
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.time.LocalDate;

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

 
import com.bornfire.xbrl.entities.BRBS.BRF155ServiceRepo;
import com.bornfire.xbrl.entities.BRBS.BRF155_ARCHIV_ENTITY;
import com.bornfire.xbrl.entities.BRBS.BRF155_DETAIL_ENTITY;
import com.bornfire.xbrl.entities.BRBS.BRF155_ENTITY;
import com.bornfire.xbrl.entities.BRBS.BRF155_ENTITY_REP;
import com.bornfire.xbrl.entities.BRBS.BRF155_DetailRep;
 import com.bornfire.xbrl.entities.BRBS.T1CurProdDetail;
import com.bornfire.xbrl.entities.BRBS.T1CurProdServicesRepo;

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

public class BRF155ReportService {
	private static final Logger logger = LoggerFactory.getLogger(BRF155ReportService.class);

	@Autowired
	SessionFactory sessionFactory;

	@Autowired
	DataSource srcdataSource;

	@Autowired
	T1CurProdServicesRepo t1CurProdServiceRepo;

	@Autowired
	Environment env;
	@Autowired
	BRF155_DetailRep BRF155_DetailRep;
	@Autowired
	BRF155_ENTITY_REP BRF155_ENTITY_REP;

	@Autowired
	BRF155ServiceRepo brf155ServiceRepo;

	DateFormat df = new SimpleDateFormat("dd-MMM-yyyy");

	public String preCheckBRF155(String reportId, String fromdate, String todate) {

		String msg = "";
		Session hs = sessionFactory.getCurrentSession();
		Date dt1;
		Date dt9;
		logger.info("Report precheck : " + reportId);

		try {
			dt9 = new SimpleDateFormat("dd/MM/yyyy").parse(todate);
			logger.info("Getting No of records in Master table :" + reportId);
			Long dtlcnt = (Long) hs.createQuery("select count(*) from BRF155_ENTITY a where a.report_date=?1")
					.setParameter(1, dt9).getSingleResult();

			if (dtlcnt > 0) {
				logger.info("Getting No of records in Mod table :" + reportId);
				Long modcnt = (Long) hs.createQuery("select count(*) from BRF155_ENTITY a").getSingleResult();
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
	
	public ModelAndView getBRF155View(String reportId, String fromdate, String todate, String currency, String dtltype,
			Pageable pageable) {
		
			ModelAndView mv = new ModelAndView();
			Session hs = sessionFactory.getCurrentSession();
			int pageSize = pageable.getPageSize();
			int currentPage = pageable.getPageNumber();
			int startItem = currentPage * pageSize;
			List<BRF155_ENTITY> T1rep = new ArrayList<BRF155_ENTITY>(); 
			// Query<Object[]> qr;

			List<BRF155_ENTITY> T1Master = new ArrayList<BRF155_ENTITY>();
		    // List<BRF47_Entity1> T1Master1 = new ArrayList<BRF47_Entity1>(); 

			logger.info("Inside archive" +currency);

			try {
				Date d1 = df.parse(todate);
			//	T1rep = t1CurProdServiceRepo.getT1CurProdServices(d1);

//				T1Master = hs.createQuery("from  BRF47_Entity1 a where a.report_date = ?1 ", BRF47_Entity1 .class)
//						.setParameter(1, df.parse(todate)).getResultList();

				
				/*
				 * T1Master1 = hs.createQuery("from BRF47_Entity a where a.report_date = ?1 ",
				 * BRF40_Entity2.class) .setParameter(1, df.parse(todate)).getResultList();
				 */
	List<Object[]> T1Master1 = BRF155_ENTITY_REP.findllvalues(todate);
				
				for( Object[] BRF155_ENTITY : T1Master1) {
					
					BRF155_ENTITY BRF155 = new BRF155_ENTITY();
					System.out.println(BRF155_ENTITY[0]);
					
					Date deal_date = BRF155_ENTITY[0] != null ? (Date) BRF155_ENTITY[0] : null;
					BRF155.setDeal_date(deal_date); 
					
					/*
					 * LocalDate buyDate = BRF155_ENTITY[1] != null ? ((java.sql.Date)
					 * BRF155_ENTITY[1]).toLocalDate() : null; BRF155.setDeal_date(deal_date);
					 */
					
					 
					 
					BigDecimal buy_usd = BRF155_ENTITY[1] != null ? (BigDecimal) BRF155_ENTITY[1] : new BigDecimal("0");
					BRF155.setBuy_usd(buy_usd);  
					
					BigDecimal sell_aed = BRF155_ENTITY[2] != null ? (BigDecimal) BRF155_ENTITY[2] :new BigDecimal("0");
					BRF155.setSell_aed(sell_aed);  
					
					BigDecimal buy_aed = BRF155_ENTITY[3] != null ? (BigDecimal) BRF155_ENTITY[3] : new BigDecimal("0");
					BRF155.setBuy_aed(buy_aed);  
					
					BigDecimal sell_usd = BRF155_ENTITY[4] != null ? (BigDecimal) BRF155_ENTITY[4] :new BigDecimal("0");
					BRF155.setSell_usd(sell_usd);  
					
					BRF155.setDdm(String.valueOf(BRF155_ENTITY[5]));
					
					 
				
					T1Master.add(BRF155);

					
				}
			} catch (ParseException e) {
				e.printStackTrace();
			}

			// T1rep = t1CurProdServiceRepo.getT1CurProdServices(d1);

			mv.setViewName("RR/BRF155");
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


	
		/*
		 * public ModelAndView getBRF155View(String reportId, String fromdate, String
		 * todate, String currency, String dtltype, Pageable pageable,BigDecimal srl_no)
		 * {
		 * 
		 * ModelAndView mv = new ModelAndView();
		 * 
		 * Session hs = sessionFactory.getCurrentSession(); int pageSize =
		 * pageable.getPageSize(); int currentPage = pageable.getPageNumber(); int
		 * startItem = currentPage * pageSize; List<BRF155_ENTITY> T1rep = new
		 * ArrayList<BRF155_ENTITY>(); // Query<Object[]> qr;
		 * 
		 * List<BRF155_ENTITY> T1Master = new ArrayList<BRF155_ENTITY>();
		 * //List<BRF155reportentity> T2Master = new ArrayList<BRF155reportentity>();
		 * logger.info("Inside archive" +currency);
		 * 
		 * List<BRF155_ENTITY> list1 = new ArrayList<BRF155_ENTITY>(); try {
		 * 
		 * 
		 * Date d1 = df.parse(todate); //T1rep = brf32ServiceRepo
		 * .getBRF32reportService(d1);
		 * 
		 * T1Master = hs.
		 * createQuery("from BRF155_ENTITY a where a.report_date = ?1 and a.srl_no = '1'"
		 * , BRF155_ENTITY.class) .setParameter(1, d1).getResultList();
		 * 
		 * 
		 * 
		 * 
		 * BigDecimal srlNoAsBigDecimal = BigDecimal.valueOf(5);
		 * 
		 * // String jpqlQuery =
		 * "SELECT DISTINCT e FROM BRF155reportentity e WHERE e.del_flg = 'N' and e.srl_no IS NOT NULL"
		 * ; // T2Master = hs.createQuery(jpqlQuery, BRF155reportentity.class) //
		 * .getResultList(); // // for (BRF155reportentity entity : T2Master) { // //
		 * Process each entity // // System.out.println(entity+"aaaa"); // }
		 * 
		 * T2Master = hs.createQuery(
		 * "select e FROM BRF155reportentity WHERE e.DEL_FLG = 'N' and e.srl_no=:srl_no"
		 * , BRF155reportentity.class) .setParameter("srl_no",srl_no).getResultList();
		 * 
		 * for(BRF155reportentity instrument:T2Master){
		 * System.out.println("Instrument ID  "+instrument.getSrl_no());
		 * 
		 * }
		 * 
		 * 
		 * List<Object[]> list = brf155ServiceRepo.findByCIFID(srl_no); for(int i =0;i<
		 * list.size();i++) { BRF155_ENTITY bacp = new BRF155_ENTITY();
		 * 
		 * String dealdate = list.get(i)[0].toString(); Date date = new
		 * SimpleDateFormat("yyyy-MM-dd").parse(dealdate); bacp.setDeal_date(date);
		 * //bacp.setDeal_date(new Date()); bacp.setBuy_aed (new
		 * BigDecimal(list.get(i)[1].toString())); bacp.setBuy_usd(new
		 * BigDecimal(list.get(i)[2].toString())); bacp.setDdm
		 * (String.valueOf(list.get(i)[3])); bacp.setSell_aed (new
		 * BigDecimal(list.get(i)[4].toString())); bacp.setSell_usd (new
		 * BigDecimal(list.get(i)[5].toString()));
		 * 
		 * 
		 * bacp.setSrl_no(new BigDecimal(list.get(i)[6].toString()));
		 * 
		 * 
		 * list1.add(bacp); }
		 * 
		 * //try { //bulkTran.setTran_date(new
		 * SimpleDateFormat("dd-MMM-yyyy").parse(val)); bulkTran.setValue_date(new
		 * SimpleDateFormat("dd-MMM-yyyy").parse(val)); } catch (ParseException e) { //
		 * TODO Auto-generated catch block e.printStackTrace(); }
		 * 
		 * } catch (ParseException e) { e.printStackTrace(); }
		 * 
		 * // T1rep = t1CurProdServiceRepo.getT1CurProdServices(d1);
		 * 
		 * mv.setViewName("RR/ReportBRF155"); mv.addObject("DelList", list1); //
		 * mv.addObject("currlist", refCodeConfig.currList());
		 * mv.addObject("reportsummary", T1Master); //mv.addObject("DelList", T2Master);
		 * mv.addObject("reportmaster", T1Master); mv.addObject("displaymode",
		 * "summary"); mv.addObject("reportsflag", "reportsflag"); mv.addObject("menu",
		 * reportId); System.out.println("scv" + mv.getViewName());
		 * 
		 * return mv;
		 * 
		 * }
		 */
	 
	public ModelAndView getBRF155Details(String reportId, String fromdate, String todate, String currency,
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
				qr = hs.createNativeQuery("select * from BRF155_DETAILTABLE");
				// qr.setParameter(2, filter);
			} else {
				qr = hs.createNativeQuery("select * from BRF155_DETAILTABLE");
			}
		} else {
			qr = hs.createNativeQuery("select * from BRF155_DETAILTABLE  where report_date = ?1");
		}
		List<BRF155_DETAIL_ENTITY> T1Master = new ArrayList<BRF155_DETAIL_ENTITY>();

		try {
			T1Master = hs.createQuery("from BRF155_DETAIL_ENTITY a where a.report_date = ?1",BRF155_DETAIL_ENTITY.class).setParameter(1, df.parse(todate)).getResultList();
		} catch (ParseException e) {

			e.printStackTrace();
		}

		logger.info("Getting Report Detail for : " + reportId + "," + fromdate + "," + todate + "," + currency);
		List<Object[]> result = qr.getResultList();

		for (Object[] a : result) {
			String cust_id = (String) a[0];
			String foracid = (String) a[1];

			String acct_name = (String) a[2];
			BigDecimal act_balance_amt_ac = (BigDecimal) a[3];
			BigDecimal act_balance_amt_lc = (BigDecimal) a[4];
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
			String version = (String) a[46];
			String remarks = (String) a[47];
			BigDecimal buy_usd = (BigDecimal) a[48];
			BigDecimal sell_aed  = (BigDecimal) a[49];
			BigDecimal buy_aed = (BigDecimal) a[50];
			BigDecimal sell_usd  = (BigDecimal) a[51];

			BRF155_DETAIL_ENTITY py = new BRF155_DETAIL_ENTITY(cust_id, foracid, acct_name, act_balance_amt_ac, act_balance_amt_lc,
					acct_crncy_code, gl_code, gl_sub_head_code, gl_sub_head_desc, country_of_incorp, cust_type,
					schm_code, schm_type, sol_id, acid, segment, sub_segment, sector, sub_sector, sector_code, group_id,
					constitution_code, country, legal_entity_type, constitution_desc, purpose_of_advn, hni_networth,
					turnover, bacid, report_name_1, report_label_1, report_addl_criteria_1, report_addl_criteria_2,
					report_addl_criteria_3, create_user, create_time, modify_user, modify_time, verify_user,
					verify_time, entity_flg, modify_flg, del_flg, nre_status, report_date, maturity_date, version,
					remarks,buy_usd,sell_aed,buy_aed,sell_usd);

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

		mv.setViewName("RR" + "/" + "BRF155::reportcontent");
		// mv.setViewName("ReportT1");
		mv.addObject("reportdetails", T1Dt1Page);
		mv.addObject("reportmaster", T1Master);
		mv.addObject("singledetail", new T1CurProdDetail());
		mv.addObject("reportsflag", "reportsflag");
		mv.addObject("menu", reportId);
		return mv;
	}

	public File getFileBRF155(String reportId, String fromdate, String todate, String currency, String dtltype,

			String filetype) throws FileNotFoundException, JRException, SQLException {

		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

		String path = this.env.getProperty("output.exportpath");
		String fileName = "";
		String zipFileName = "";
		File outputFile;

		logger.info("Getting Output file :" + reportId);
		fileName = "011-BRF-155-A";
		 

		if (!filetype.equals("xbrl")) {
			if (!filetype.equals("BRF")) {

			try {
				InputStream jasperFile;
				logger.info("Getting Jasper file :" + reportId);
				if (filetype.equals("detailexcel")) {
					if (dtltype.equals("report")) {

						jasperFile = this.getClass().getResourceAsStream("/static/jasper/Details.jrxml");
					} else {
						jasperFile = this.getClass().getResourceAsStream("/static/jasper/BRF155.jrxml");
					}

				} else {
					if (dtltype.equals("report")) {
						logger.info("Inside report");
						jasperFile = this.getClass().getResourceAsStream("/static/jasper/BRF155.jrxml");
					} else {
						jasperFile = this.getClass().getResourceAsStream("/static/jasper/BRF155.jrxml");
					}
				}

				// JasperReport jr = (JasperReport) JRLoader.loadObject(jasperFile);

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
			List<BRF155_ENTITY> T1Master = new ArrayList<>();
			Session hs = sessionFactory.getCurrentSession();
			try {
				Date d1 = df.parse(todate);

				// Retrieve data
				List<Object[]> T1Master1 = BRF155_ENTITY_REP.findllvalues(todate);
				
				File responseFile = new File(env.getProperty("output.exportpathtemp") + "011-BRF-155-AT.xls");

				// Load the Excel file
				Workbook workbook = WorkbookFactory.create(responseFile);
				Sheet sheet = workbook.getSheetAt(0);

				if (!T1Master1.isEmpty()) {
					int startRow = 7; // Starting row index
					System.out.println("T1Master size: " + T1Master.size());

					for (int index = 0; index < T1Master1.size(); index++) {
						Object[] brf155 = T1Master1.get(index);
						Row row = sheet.getRow(startRow + index);
						if (row == null) {
							row = sheet.createRow(startRow + index);
						}

						// Deal Date
						Cell cell = row.getCell(2);
						if (cell == null) {
							cell = row.createCell(2);
						}
						Date dateValue = (Date) brf155[0];
						SimpleDateFormat dateFormat1 = new SimpleDateFormat("dd-MM-yyyy");
						String formattedDate = (dateValue == null) ? "N/A" : dateFormat1.format(dateValue);
						cell.setCellValue(formattedDate);

						// Buy USD
						Cell cell1 = row.getCell(3);
						if (cell1 == null) {
							cell1 = row.createCell(3);
						}
						cell1.setCellValue(brf155[1] == null ? 0 : ((BigDecimal) brf155[1]).intValue());

						// Sell AED
						Cell cell2 = row.getCell(4);
						if (cell2 == null) {
							cell2 = row.createCell(4);
						}
						cell2.setCellValue(brf155[2] == null ? 0 : ((BigDecimal) brf155[2]).intValue());

						// Buy AED
						Cell cell3 = row.getCell(5);
						if (cell3 == null) {
							cell3 = row.createCell(5);
						}
						cell3.setCellValue(brf155[3] == null ? 0 : ((BigDecimal) brf155[3]).intValue());

						// Sell USD
						Cell cell4 = row.getCell(6);
						if (cell4 == null) {
							cell4 = row.createCell(6);
						}
						cell4.setCellValue(brf155[4] == null ? 0 : ((BigDecimal) brf155[4]).intValue());

						// DDM
						Cell cell5 = row.getCell(7);
						if (cell5 == null) {
							cell5 = row.createCell(7);
						}
						String value = (brf155[5] == null) ? "0" : brf155[5].toString();
						cell5.setCellValue(value);
					}

					// Save the changes
					try (FileOutputStream fileOut = new FileOutputStream(
							env.getProperty("output.exportpathfinal") + "011-BRF-155-A.xls")) {
						workbook.write(fileOut);
						System.out.println("File saved successfully at: "
								+ env.getProperty("output.exportpathfinal") + "011-BRF-155-A.xls");
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
	outputFile = new File(env.getProperty("output.exportpathfinal") + "011-BRF-155-A.xls");

	return outputFile;

}


	
	
	public String detailChanges155(BRF155_DETAIL_ENTITY detail, Date maturity_date,BigDecimal buy_usd,
			BigDecimal sell_aed,BigDecimal	buy_aed,BigDecimal sell_usd,String country) {

		String msg = "";

//		try {
//
//			Session hs = sessionFactory.getCurrentSession();
//			Optional<BRF155_DETAIL_ENTITY> Brf155detail = BRF155_DetailRep.findById(foracid);
//
//			if (Brf155detail.isPresent()) {
//				BRF155_DETAIL_ENTITY BRFdetail = Brf155detail.get();
//				if (BRFdetail.getReport_label_1().equals(report_label_1)
//						&& BRFdetail.getReport_name_1().equals(report_name_1)
//						&& BRFdetail.getAct_balance_amt_lc().equals(act_balance_amt_lc)
//						&& BRFdetail.getReport_addl_criteria_1().equals(report_addl_criteria_1)
//
//				) {
//					msg = "No modification done";
//				} else {
//
//					BRFdetail.setAct_balance_amt_lc(act_balance_amt_lc);
//					BRFdetail.setReport_label_1(report_label_1);
//					BRFdetail.setReport_name_1(report_name_1);
//					BRFdetail.setReport_addl_criteria_1(report_addl_criteria_1);
//					BRF155_DetailRep.save(BRFdetail);
//
////						hs.saveOrUpdate(detail);
//					logger.info("Edited Record");
//					msg = "Edited Successfully";
//				}
//			} else {
//				msg = "No data Found";
//			}
//
//		} catch (Exception e) {
//
//			msg = "error occured. Please contact Administrator";
//			e.printStackTrace();
//		}

		return msg;
	}
	
	// TO show thw Archieve values
		public ModelAndView getArchieveBRF155View(String reportId, String fromdate, String todate, String currency,
				String dtltype, Pageable pageable) {

			ModelAndView mv = new ModelAndView();
			Session hs = sessionFactory.getCurrentSession();
			int pageSize = pageable.getPageSize();
			int currentPage = pageable.getPageNumber();
			int startItem = currentPage * pageSize;
			List<BRF155_ENTITY> T1rep = new ArrayList<BRF155_ENTITY>(); 
			// Query<Object[]> qr;

			List<BRF155_ENTITY> T1Master = new ArrayList<BRF155_ENTITY>();
		    // List<BRF47_Entity1> T1Master1 = new ArrayList<BRF47_Entity1>(); 

			logger.info("Inside archive" +currency);

			try {
				Date d1 = df.parse(todate);
			//	T1rep = t1CurProdServiceRepo.getT1CurProdServices(d1);

//				T1Master = hs.createQuery("from  BRF47_Entity1 a where a.report_date = ?1 ", BRF47_Entity1 .class)
//						.setParameter(1, df.parse(todate)).getResultList();

				
				/*
				 * T1Master1 = hs.createQuery("from BRF47_Entity a where a.report_date = ?1 ",
				 * BRF40_Entity2.class) .setParameter(1, df.parse(todate)).getResultList();
				 */
	List<Object[]> T1Master1 = BRF155_ENTITY_REP.findllvalues(todate);
				
				for( Object[] BRF155_ENTITY : T1Master1) {
					
					BRF155_ENTITY BRF155 = new BRF155_ENTITY();
					System.out.println(BRF155_ENTITY[0]);
					
					Date deal_date = BRF155_ENTITY[0] != null ? (Date) BRF155_ENTITY[0] : null;
					BRF155.setDeal_date(deal_date); 
					
					/*
					 * LocalDate buyDate = BRF155_ENTITY[1] != null ? ((java.sql.Date)
					 * BRF155_ENTITY[1]).toLocalDate() : null; BRF155.setDeal_date(deal_date);
					 */
					
					 
					 
					BigDecimal buy_usd = BRF155_ENTITY[1] != null ? (BigDecimal) BRF155_ENTITY[1] : new BigDecimal("0");
					BRF155.setBuy_usd(buy_usd);  
					
					BigDecimal sell_aed = BRF155_ENTITY[2] != null ? (BigDecimal) BRF155_ENTITY[2] :new BigDecimal("0");
					BRF155.setSell_aed(sell_aed);  
					
					BigDecimal buy_aed = BRF155_ENTITY[3] != null ? (BigDecimal) BRF155_ENTITY[3] : new BigDecimal("0");
					BRF155.setBuy_aed(buy_aed);  
					
					BigDecimal sell_usd = BRF155_ENTITY[4] != null ? (BigDecimal) BRF155_ENTITY[4] :new BigDecimal("0");
					BRF155.setSell_usd(sell_usd);  
					
					BRF155.setDdm(String.valueOf(BRF155_ENTITY[5]));
					
					 
				
					T1Master.add(BRF155);

					
				}
			} catch (ParseException e) {
				e.printStackTrace();
			}

			// T1rep = t1CurProdServiceRepo.getT1CurProdServices(d1);

			mv.setViewName("RR/BRF155ARCH");
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

		public ModelAndView ARCHgetBRF155currentDtl(String reportId, String fromdate, String todate, String currency,
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

					qr = hs.createNativeQuery("select * from BRF155_ARCHIVTABLE a where report_date=?1");
					qr.setParameter(1, df.parse(todate));
					qr.setParameter(2, filter);

				} else {
					System.out.println("2");
					qr = hs.createNativeQuery("select * from BRF155_ARCHIVTABLE");

				}
			} else {
				System.out.println("3");
				qr = hs.createNativeQuery("select * from BRF155_ARCHIVTABLE  where report_date = ?1");
			}

			/*
			 * try { qr.setParameter(1, df.parse(todate));
			 * 
			 * } catch (ParseException e) { e.printStackTrace(); }
			 */
			List<BRF155_ARCHIV_ENTITY> T1Master = new ArrayList<BRF155_ARCHIV_ENTITY>();

			try {
				System.out.println("Values entered");
				T1Master = hs.createQuery("from BRF155_ARCHIV_ENTITY a where a.report_date = ?1", BRF155_ARCHIV_ENTITY.class)
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
				BigDecimal act_balance_amt_ac = (BigDecimal) a[3];
				BigDecimal act_balance_amt_lc = (BigDecimal) a[4];
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
				String version = (String) a[46];
				String remarks = (String) a[47];
				BigDecimal buy_usd = (BigDecimal) a[48];
				BigDecimal sell_aed  = (BigDecimal) a[49];
				BigDecimal buy_aed = (BigDecimal) a[50];
				BigDecimal sell_usd  = (BigDecimal) a[51];

				BRF155_ARCHIV_ENTITY py = new BRF155_ARCHIV_ENTITY(cust_id, foracid, acct_name, act_balance_amt_ac, act_balance_amt_lc,
						acct_crncy_code, gl_code, gl_sub_head_code, gl_sub_head_desc, country_of_incorp, cust_type,
						schm_code, schm_type, sol_id, acid, segment, sub_segment, sector, sub_sector, sector_code, group_id,
						constitution_code, country, legal_entity_type, constitution_desc, purpose_of_advn, hni_networth,
						turnover, bacid, report_name_1, report_label_1, report_addl_criteria_1, report_addl_criteria_2,
						report_addl_criteria_3, create_user, create_time, modify_user, modify_time, verify_user,
						verify_time, entity_flg, modify_flg, del_flg, nre_status, report_date, maturity_date, version,
						remarks,buy_usd,sell_aed,buy_aed,sell_usd);

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

			mv.setViewName("RR" + "/" + "BRF155ARCH::reportcontent");
			mv.addObject("reportdetails", T1Dt1Page.getContent());
			mv.addObject("reportmaster", T1Master);
			mv.addObject("reportmaster1", qr);
			mv.addObject("singledetail", new T1CurProdDetail());
			mv.addObject("reportsflag", "reportsflag");
			mv.addObject("menu", reportId);
			return mv;
		}



}
