package com.bornfire.xbrl.services;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.math.MathContext;
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
import org.apache.poi.ss.usermodel.FormulaEvaluator;
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

import com.bornfire.xbrl.entities.BRBS.BRF81_ARCHIVENTITY;
import com.bornfire.xbrl.entities.BRBS.BRF81_ENTITY;
import com.bornfire.xbrl.entities.BRBS.BRF80_ENTITY;
import com.bornfire.xbrl.entities.BRBS.BRF81DetailRep;
import com.bornfire.xbrl.entities.BRBS.BRF81_ENTITYREP;
import com.bornfire.xbrl.entities.BRBS.BRF81_DETAIL_ENTITY;
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
public class BRF81ReportService {
	private static final Logger logger = LoggerFactory.getLogger(BRF81ReportService.class);

	@Autowired
	SessionFactory sessionFactory;

	@Autowired
	DataSource srcdataSource;
	
	@Autowired
	Environment env;
	
	@Autowired
	BRF81DetailRep brf81DetailRep;
	
	@Autowired
	BRF81_ENTITYREP BRF81_ENTITYREP;

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
			Long dtlcnt = (Long) hs.createQuery("select count(*) from BRF81_ENTITY a where a.report_date=?1")
					.setParameter(1, dt9).getSingleResult();

			if (dtlcnt > 0) {
				logger.info("Getting No of records in Mod table :" + reportid);
				Long modcnt = (Long) hs.createQuery("select count(*) from BRF81_ENTITY a").getSingleResult();
				if (modcnt > 0) {
					msg = "success";
				}
			} else {

				msg = "success";

			}

		} catch (Exception e) {
			logger.info(e.getMessage());
			msg = "success";
			e.printStackTrace();

		}

		return msg;

	}
	public ModelAndView getBRF81View(String reportId, String fromDate, String toDate, String currency, String dtlType, Pageable pageable) {
	    ModelAndView mv = new ModelAndView();
	    Session hs = sessionFactory.getCurrentSession();
	    int pageSize = pageable.getPageSize();
	    int currentPage = pageable.getPageNumber();
	    int startItem = currentPage * pageSize;
	    List<BRF81_ENTITY> T1rep = new ArrayList<>();
	    logger.info("Inside archive " + currency);

	    try {
	        Date d1 = df.parse(toDate);
	        List<Object[]> T1Master1 = BRF81_ENTITYREP.findllvalues(toDate);

	        for (Object[] brf81Entity : T1Master1) {
	            BRF81_ENTITY brf81 = new BRF81_ENTITY();
	            
	            brf81.setName_of_borrower(brf81Entity[2] != null ? brf81Entity[2].toString() : "");
	            brf81.setCin_figi_gleiid(brf81Entity[3] != null ? brf81Entity[3].toString() : "");
	            brf81.setBorrower_type(brf81Entity[4] != null ? brf81Entity[4].toString() : "");
	            brf81.setGroup_name(brf81Entity[5] != null ? brf81Entity[5].toString() : "");
	            brf81.setResident(brf81Entity[6] != null ? brf81Entity[6].toString() : "");
	            brf81.setCountry_incorporate(brf81Entity[7] != null ? brf81Entity[7].toString() : "");
	            brf81.setCredit_rating(brf81Entity[8] != null ? brf81Entity[8].toString() : "");
	            brf81.setCredit_rating_type(brf81Entity[9] != null ? brf81Entity[9].toString() : "");
	            brf81.setEconomic_sector(brf81Entity[10] != null ? brf81Entity[10].toString() : "");
	            brf81.setCurrency(brf81Entity[11] != null ? brf81Entity[11].toString() : "");
	            BigDecimal funded_os = brf81Entity[12] != null ? new BigDecimal(brf81Entity[12].toString()) : BigDecimal.ZERO;
	            brf81.setFunded_os(funded_os);
	            BigDecimal debit = brf81Entity[13] != null ? new BigDecimal(brf81Entity[13].toString()) : BigDecimal.ZERO;
	            brf81.setDebit(debit);
	            BigDecimal equities = brf81Entity[14] != null ? new BigDecimal(brf81Entity[14].toString()) : BigDecimal.ZERO;
	            brf81.setEquities(equities);
	            BigDecimal unfunded_os = brf81Entity[15] != null ? new BigDecimal(brf81Entity[15].toString()) : BigDecimal.ZERO;
	            brf81.setUnfunded_os(unfunded_os);
	            BigDecimal ccf_equi_unfuned_os = brf81Entity[16] != null ? new BigDecimal(brf81Entity[16].toString()) : BigDecimal.ZERO;
	            brf81.setCcf_equi_unfuned_os(ccf_equi_unfuned_os);
	            BigDecimal ccf_equi_funded_n_unfuned_limits = brf81Entity[17] != null ? new BigDecimal(brf81Entity[17].toString()) : BigDecimal.ZERO;
	            brf81.setCcf_equi_funded_n_unfuned_limits(ccf_equi_funded_n_unfuned_limits);
	            BigDecimal total_exposer = brf81Entity[18] != null ? new BigDecimal(brf81Entity[18].toString()) : BigDecimal.ZERO;
	            brf81.setTotal_exposer(total_exposer);
	            BigDecimal as_of_tier1_capital = brf81Entity[19] != null ? new BigDecimal(brf81Entity[19].toString()) : BigDecimal.ZERO;
	            brf81.setAs_of_tier1_capital(as_of_tier1_capital);
	            brf81.setCredit_risk_miti_type(brf81Entity[20] != null ? brf81Entity[20].toString() : "");
	            BigDecimal credit_risk_miti_hair_cut = brf81Entity[21] != null ? new BigDecimal(brf81Entity[21].toString()) : BigDecimal.ZERO;
	            brf81.setCredit_risk_miti_hair_cut(credit_risk_miti_hair_cut);
	            BigDecimal collateral_hair_cut = brf81Entity[22] != null ? new BigDecimal(brf81Entity[22].toString()) : BigDecimal.ZERO;
	            brf81.setCollateral_hair_cut(collateral_hair_cut);
	            brf81.setCbuae_class(brf81Entity[23] != null ? brf81Entity[23].toString() : "");
	            BigDecimal provision = brf81Entity[24] != null ? new BigDecimal(brf81Entity[24].toString()) : BigDecimal.ZERO;
	            brf81.setProvision(provision);
	            brf81.setRemarks(brf81Entity[25] != null ? brf81Entity[25].toString() : "");
	            T1rep.add(brf81);
	        }
	    } catch (ParseException e) {
	        logger.error("Error occurred while parsing date: " + e.getMessage());
	    }

	    // Adding objects to the ModelAndView
	    mv.setViewName("RR/BRF81");
	    mv.addObject("reportsummary", T1rep);
	    mv.addObject("getTier1_capital", BRF81_ENTITYREP.getTier1_capital(toDate));
	    mv.addObject("getEntity_level", BRF81_ENTITYREP.getEntity_level(toDate));
	    mv.addObject("getFundedOs", BRF81_ENTITYREP.getFundedOs(toDate));
	    mv.addObject("getDebit", BRF81_ENTITYREP.getDebit(toDate));
	    mv.addObject("getEquities", BRF81_ENTITYREP.getEquities(toDate));
	    mv.addObject("getUnfundedOs", BRF81_ENTITYREP.getUnfundedOs(toDate));
	    mv.addObject("getCcfEquiUnfundedOs", BRF81_ENTITYREP.getCcfEquiUnfundedOs(toDate));
	    mv.addObject("getCcfEquiFundedAndUnfundedLimits", BRF81_ENTITYREP.getCcfEquiFundedAndUnfundedLimits(toDate));
	    mv.addObject("getCredit_risk_miti_hair_cut", BRF81_ENTITYREP.getCredit_risk_miti_hair_cut(toDate));
	    mv.addObject("getCollateral_hair_cut", BRF81_ENTITYREP.getCollateral_hair_cut(toDate));
	    mv.addObject("getProvision", BRF81_ENTITYREP.getProvision(toDate));
	   
	    BigDecimal funded_os = BRF81_ENTITYREP.getFundedOs(toDate) != null
	            ? new BigDecimal(BRF81_ENTITYREP.getFundedOs(toDate))
	            : BigDecimal.ZERO;
	    BigDecimal debit = BRF81_ENTITYREP.getDebit(toDate) != null
	            ? new BigDecimal(BRF81_ENTITYREP.getDebit(toDate))
	            : BigDecimal.ZERO;
	    BigDecimal equities = BRF81_ENTITYREP.getEquities(toDate) != null
	            ? new BigDecimal(BRF81_ENTITYREP.getEquities(toDate))
	            : BigDecimal.ZERO;
	    BigDecimal ccf_equi_unfuned_os = BRF81_ENTITYREP.getCcfEquiUnfundedOs(toDate) != null
	            ? new BigDecimal(BRF81_ENTITYREP.getCcfEquiUnfundedOs(toDate))
	            : BigDecimal.ZERO;
	    BigDecimal ccf_equi_funded_n_unfuned_limits = BRF81_ENTITYREP.getCcfEquiFundedAndUnfundedLimits(toDate) != null
	            ? new BigDecimal(BRF81_ENTITYREP.getCcfEquiFundedAndUnfundedLimits(toDate))
	            : BigDecimal.ZERO;

	    // Adding individual values to the model
	    mv.addObject("getfunded_os", funded_os);
	    mv.addObject("getdebt_securities", debit);
	    mv.addObject("getequities", equities);
	    mv.addObject("getccf_equivalent_of_unfunded_os", ccf_equi_unfuned_os);
	    mv.addObject("getccf_equivalent_limits", ccf_equi_funded_n_unfuned_limits);

	    // Summing up the values
	    BigDecimal total_exposer = funded_os.add(debit).add(equities).add(ccf_equi_unfuned_os).add(ccf_equi_funded_n_unfuned_limits);
	    mv.addObject("total_exposer", total_exposer);

	    // Fetching the value of getTier1_capital
	    String getTier1_capital = BRF81_ENTITYREP.getTier1_capital(toDate);
	    String getEntity_level = BRF81_ENTITYREP.getEntity_level(toDate);

	    // Adding total_exposer and getTier1_capital to the ModelAndView
	    mv.addObject("total_exposer", total_exposer);
	    mv.addObject("getTier1_capital", getTier1_capital);
	    mv.addObject("getEntity_level", getEntity_level);

	    BigDecimal tier1_capital_result;
	    if (getTier1_capital.equals(BigDecimal.ZERO)) {
	        tier1_capital_result = BigDecimal.ZERO;
	    } else {
	        tier1_capital_result = total_exposer.divide(new BigDecimal(getTier1_capital), MathContext.DECIMAL128);
	    }

	    // Adding expressionResult to the ModelAndView
	    mv.addObject("tier1_capital_result", tier1_capital_result);

	    // Additional objects for the view
	    mv.addObject("reportmaster", T1rep);
	    mv.addObject("displaymode", "summary");
	    mv.addObject("reportsflag", "reportsflag");
	    mv.addObject("menu", reportId);

	    System.out.println("scv" + mv.getViewName());

	    return mv;
	}




	public ModelAndView getBRF81Details(String reportId, String fromdate, String todate, String currency,
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
				qr = hs.createNativeQuery("select * from BRF81_DETAILTABLE");

				//qr.setParameter(2, filter);

			} else {
				qr = hs.createNativeQuery("select * from BRF81_DETAILTABLE");

			}
		} else {
			qr = hs.createNativeQuery("select * from BRF81_DETAILTABLE  where report_label_1 = ?1");
		}
		List<BRF81_DETAIL_ENTITY> T1Master = new ArrayList<BRF81_DETAIL_ENTITY>();
		 try {
	            T1Master = hs.createQuery("from BRF81_DETAIL_ENTITY a where a.report_date = ?1", BRF81_DETAIL_ENTITY.class)
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
			BigDecimal eab_lc  = (BigDecimal) a[3];
			String acct_name = (String) a[4];
			String acct_crncy_code= (String) a[5];
			String gl_code = (String) a[6];
			String gl_sub_head_code = (String) a[7];
			String gl_sub_head_desc = (String) a[8];
			String country_of_incorp = (String) a[9];
			String cust_type = (String) a[10];
			String schm_code  = (String) a[11];
			String schm_type  = (String) a[12];
			String sol_id  = (String) a[13];
			String acid = (String) a[14];
			String segment  = (String) a[15];
			String sub_segment  = (String) a[16];
			BigDecimal sector  = (BigDecimal) a[17];
			String sub_sector  = (String) a[18];
			String sector_code = (String) a[19];
			String group_id  = (String) a[20];
			String constitution_code = (String) a[21];
			String country = (String) a[22];
			String legal_entity_type  = (String) a[23];
			String constitution_desc = (String) a[24];
			String purpose_of_advn  = (String) a[25];
			BigDecimal hni_networth  = (BigDecimal) a[26];
			String turnover  = (String) a[27];
			String bacid = (String) a[28];
			String report_name_1 = (String) a[29];
			String report_label_1  = (String) a[30];
			String report_addl_criteria_1 = (String) a[31];
			String report_addl_criteria_2 = (String) a[32];
			String report_addl_criteria_3 = (String) a[33];	
			String create_user = (String) a[34];
		    Date create_time  = (Date) a[35];
		    String modify_user  = (String) a[36];
		    Date modify_time  = (Date) a[37];
		    String verify_user = (String) a[38];
			Date verify_time = (Date)  a[39];
			String entity_flg = (String) a[40];				
			String modify_flg = (String) a[41];
			String del_flg =(String) a[42];
			String nre_status  = (String) a[43];
			Date   report_date= (Date) a[44];
			Date maturity_date  = (Date) a[45];
			String gender = (String) a[46];
			String version=(String)a[47];		
			String remarks=(String)a[48];
			Character nre_flg=(Character)a[49];
		
											
			BRF81_DETAIL_ENTITY py = new BRF81_DETAIL_ENTITY( cust_id,  foracid,   act_balance_amt_lc,   eab_lc,
					 acct_name,  acct_crncy_code,  gl_code,  gl_sub_head_code,  gl_sub_head_desc,
					 country_of_incorp,  cust_type,  schm_code,  schm_type,  sol_id,  acid,
					 segment,  sub_segment,   sector,  sub_sector,  sector_code,
					 group_id,  constitution_code,  country,  legal_entity_type,
					 constitution_desc,  purpose_of_advn,   hni_networth,  turnover,  bacid,
					 report_name_1,  report_label_1,  report_addl_criteria_1,  report_addl_criteria_2,
					 report_addl_criteria_3,  create_user,   create_time,  modify_user,   modify_time,
					 verify_user,   verify_time,  entity_flg,  modify_flg,  del_flg,
					 nre_status,   report_date,   maturity_date,  gender,  version,  remarks,
					 nre_flg);
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

		mv.setViewName("RR" + "/" + "BRF81::reportcontent");
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
		fileName = "011-BRF-081-A";
		if (!filetype.equals("xbrl")) {
			if (!filetype.equals("BRF")) {
			try {
				InputStream jasperFile;
				logger.info("Getting Jasper file :" + reportId);
				if (filetype.equals("detailexcel")) {
					if (dtltype.equals("report")) {

						jasperFile = this.getClass().getResourceAsStream("/static/jasper/BRF81_Detail.jrxml");
					} else {
						jasperFile = this.getClass().getResourceAsStream("/static/jasper/BRF81_Detail.jrxml");
					}

				} else {
					if (dtltype.equals("report")) {
						logger.info("Inside report");
						jasperFile = this.getClass().getResourceAsStream("/static/jasper/BRF81.jrxml");
					} else {
						jasperFile = this.getClass().getResourceAsStream("/static/jasper/BRF81.jrxml");
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
		}else {
			List<BRF81_ENTITY> T1Master = new ArrayList<>();
			Session hs = sessionFactory.getCurrentSession();
			try {
				Date d1 = df.parse(todate);

				// Retrieve data
				List<Object[]> T1Master1 = BRF81_ENTITYREP.findllvalues(todate);

				File responseFile = new File(env.getProperty("output.exportpathtemp") + "011-BRF-081-AT.xls");

				// Load the Excel file
				Workbook workbook = WorkbookFactory.create(responseFile);
				Sheet sheet = workbook.getSheetAt(0);
				FormulaEvaluator evaluator = workbook.getCreationHelper().createFormulaEvaluator();
				
				if (!T1Master1.isEmpty()) {
					int startRow = 9;
					System.out.println("T1Master size: " + T1Master.size());

					for (int index = 0; index < T1Master1.size(); index++) {
						Object[] BRF080 = T1Master1.get(index);
						Row row = sheet.getRow(startRow + index);
						if (row == null) {
							row = sheet.createRow(startRow + index);
						}


						Cell cell1 = row.getCell(2);
						if (cell1 == null) {
							cell1 = row.createCell(2);
						}
						cell1.setCellValue(BRF080[2] == null ? "0" : (String) BRF080[2]);

						// ISSUE_NAME
						Cell cell2 = row.getCell(3);
						if (cell2 == null) {
							cell2 = row.createCell(3);
						}
						cell2.setCellValue(BRF080[3] == null ? "0" : (String) BRF080[3]);

						// ISSUE_TRACKER
						Cell cell3 = row.getCell(4);
						if (cell3 == null) {
							cell3 = row.createCell(4);
						}
						cell3.setCellValue(BRF080[4] == null ? "0" : (String) BRF080[4]);

						// COUNTRY
						Cell cell4 = row.getCell(5);
						if (cell4 == null) {
							cell4 = row.createCell(5);
						}
						cell4.setCellValue(BRF080[5] == null ? "0" : (String) BRF080[5]);

						// COUNTRY_PARTY

						Cell cell5 = row.getCell(6);  // Assuming column 5 is where you want to place totalExposure
						if (cell5 == null) {
						    cell5 = row.createCell(6);
						}
						cell5.setCellValue(BRF080[6] == null ? "0" : (String) BRF080[6]);

						// AMOUNT
						Cell cell6 = row.getCell(7);
						if (cell6 == null) {
							cell6 = row.createCell(7);
						}
						cell6.setCellValue(BRF080[7] == null ? "0" : (String) BRF080[7]);
						
						// INDENTIFCATION_NUMBER
						Cell cell7 = row.getCell(8);
						if (cell7 == null) {
							cell7 = row.createCell(8);
						}
						cell7.setCellValue(BRF080[8] == null ? "0" : (String) BRF080[8]);

						// ISSUE_NAME
						Cell cell8 = row.getCell(9);
						if (cell8 == null) {
							cell8 = row.createCell(9);
						}
						cell8.setCellValue(BRF080[9] == null ? "0" : (String) BRF080[9]);

						// ISSUE_TRACKER
						Cell cell9 = row.getCell(10);
						if (cell9 == null) {
							cell9 = row.createCell(10);
						}
						cell9.setCellValue(BRF080[10] == null ? "0" : (String) BRF080[10]);

						// COUNTRY
						Cell cell10 = row.getCell(11);
						if (cell10 == null) {
							cell10 = row.createCell(11);
						}
						cell10.setCellValue(BRF080[11] == null ? "0" : (String) BRF080[11]);

						// COUNTRY_PARTY

						Cell cell11 = row.getCell(12);  // Assuming column 5 is where you want to place totalExposure
						if (cell11 == null) {
						    cell11 = row.createCell(12);
						}
						cell11.setCellValue(BRF080[12] == null ? 0 : ((BigDecimal) BRF080[12]).intValue());
						
						Cell cell12 = row.getCell(13);  // Assuming column 5 is where you want to place totalExposure
						if (cell12 == null) {
						    cell12 = row.createCell(13);
						}
						cell12.setCellValue(BRF080[13] == null ? 0 : ((BigDecimal) BRF080[13]).intValue());
						
						
						Cell cell13 = row.getCell(14);  // Assuming column 5 is where you want to place totalExposure
						if (cell13 == null) {
						    cell13 = row.createCell(14);
						}
						cell13.setCellValue(BRF080[14] == null ? 0 : ((BigDecimal) BRF080[14]).intValue());
						

						Cell cell14 = row.getCell(15);  // Assuming column 5 is where you want to place totalExposure
						if (cell14 == null) {
						    cell14 = row.createCell(15);
						}
						cell14.setCellValue(BRF080[15] == null ? 0 : ((BigDecimal) BRF080[15]).intValue());
						
						Cell cell15 = row.getCell(16);
						if (cell15 == null) {
							cell15 = row.createCell(16);
						}
						cell15.setCellValue(BRF080[16] == null ? 0 : ((BigDecimal) BRF080[16]).intValue());
						
						Cell cell16 = row.getCell(17);  // Assuming column 5 is where you want to place totalExposure
						if (cell16 == null) {
						    cell16 = row.createCell(17);
						}
						cell16.setCellValue(BRF080[17] == null ? 0 : ((BigDecimal) BRF080[17]).intValue());
						
						Cell cell17 = row.getCell(18);  // Assuming column 5 is where you want to place totalExposure
						if (cell17 == null) {
						    cell17 = row.createCell(18);
						}
						cell17.setCellValue(BRF080[18] == null ? 0 : ((BigDecimal) BRF080[18]).intValue());
						
						Cell cell18 = row.getCell(19);
						if (cell18 == null) {
							cell18 = row.createCell(19);
						}
						cell18.setCellValue(BRF080[19] == null ? 0 : ((BigDecimal) BRF080[19]).intValue());
						
						Cell cell19 = row.getCell(20);
						if (cell19 == null) {
							cell19 = row.createCell(20);
						}
						cell19.setCellValue(BRF080[20] == null ? "0" : (String) BRF080[20]);
						
						Cell cell20 = row.getCell(21);
						if (cell20 == null) {
							cell20 = row.createCell(21);
						}
						cell20.setCellValue(BRF080[21] == null ? 0 : ((BigDecimal) BRF080[21]).intValue());
						
						Cell cell21 = row.getCell(22);
						if (cell21 == null) {
							cell21 = row.createCell(22);
						}
						cell21.setCellValue(BRF080[22] == null ? 0 : ((BigDecimal) BRF080[22]).intValue());
						
						Cell cell22 = row.getCell(23);
						if (cell22 == null) {
							cell22 = row.createCell(23);
						}
						cell22.setCellValue(BRF080[23] == null ? "0" : (String) BRF080[23]);
						
						Cell cell23 = row.getCell(24);
						if (cell23 == null) {
							cell23 = row.createCell(24);
						}
						cell23.setCellValue(BRF080[24] == null ? 0 : ((BigDecimal) BRF080[24]).intValue());
						
						Cell cell24 = row.getCell(25);
						if (cell24 == null) {
							cell24 = row.createCell(25);
						}
						cell24.setCellValue(BRF080[25] == null ? "0" : (String) BRF080[25]);
						
					}

					// workbook.getCreationHelper().createFormulaEvaluator().evaluateAll();

					for (Row row : sheet) {
						for (Cell cell : row) {
							if (cell.getCellType() == cell.CELL_TYPE_FORMULA) {
								try {
									evaluator.evaluateFormulaCell(cell);
								} catch (Exception e) {
									System.err.println("Skipping formula evaluation for cell " + cell.getAddress()
											+ ": " + e.getMessage());
								}

							}
						}
					}

					try (FileOutputStream fileOut = new FileOutputStream(
							env.getProperty("output.exportpathfinal") + "011-BRF-081-A.xls")) {
						workbook.write(fileOut);
						System.out.println("File saved successfully at: "
								+ env.getProperty("output.exportpathfinal") + "011-BRF-081-A.xls");
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
	outputFile = new File(env.getProperty("output.exportpathfinal") + "011-BRF-081-A.xls");

	return outputFile;

}

	
	public String detailChanges81(BRF81_DETAIL_ENTITY detail, String foracid, String report_addl_criteria_1,
	        BigDecimal act_balance_amt_lc, String report_label_1, String report_name_1) {

	    String msg = "";

	    try {
	        // Get the current Hibernate session
	        Session hs = sessionFactory.getCurrentSession();

	        // Find the BRF81_DETAIL_ENTITY object by its foracid
	        Optional<BRF81_DETAIL_ENTITY> brf81DetailOptional = brf81DetailRep.findById(foracid);

	        if (brf81DetailOptional.isPresent()) {
	            BRF81_DETAIL_ENTITY brfDetail = brf81DetailOptional.get();
	            if (brfDetail != null && report_label_1 != null && report_name_1 != null && report_addl_criteria_1 != null) {
	            	if (act_balance_amt_lc.equals(brfDetail.getAct_balance_amt_lc()) &&
	                        report_label_1.equals(brfDetail.getReport_label_1()) &&
	                        report_name_1.equals(brfDetail.getReport_name_1()) &&
	                        report_addl_criteria_1.equals(brfDetail.getReport_addl_criteria_1())) {
	                    msg = "No modification done";
	                } else {
	                    // Update the BRF81_DETAIL_ENTITY object with the provided parameters
	                    brfDetail.setAct_balance_amt_lc(act_balance_amt_lc);
	                    brfDetail.setReport_label_1(report_label_1);
	                    brfDetail.setReport_name_1(report_name_1);
	                    brfDetail.setReport_addl_criteria_1(report_addl_criteria_1);

	                    // Save the updated object
	                    brf81DetailRep.save(brfDetail);

	                    // Log the action
	                    logger.info("Edited Record");
	                    msg = "Edited Successfully";
	                }
	            } else {
	                msg = "Some parameters are null";
	            }
	        } else {
	            msg = "No data Found";
	        }

	    } catch (Exception e) {
	        // Handle any exceptions
	        msg = "An error occurred. Please contact Administrator";
	        e.printStackTrace();
	    }

	    return msg;
	}
	public ModelAndView getArchieveBRF081View(String reportId, String fromdate, String todate, String currency,
			String dtltype, Pageable pageable) {
		 ModelAndView mv = new ModelAndView();
		    Session hs = sessionFactory.getCurrentSession();
		    int pageSize = pageable.getPageSize();
		    int currentPage = pageable.getPageNumber();
		    int startItem = currentPage * pageSize;
		    List<BRF81_ENTITY> T1rep = new ArrayList<>();
		    logger.info("Inside archive " + currency);

		    try {
		        Date d1 = df.parse(todate);
		        List<Object[]> T1Master1 = BRF81_ENTITYREP.findllvalues(todate);

		        for (Object[] brf81Entity : T1Master1) {
		            BRF81_ENTITY brf81 = new BRF81_ENTITY();
		            
		            brf81.setName_of_borrower(brf81Entity[2] != null ? brf81Entity[2].toString() : "");
		            brf81.setCin_figi_gleiid(brf81Entity[3] != null ? brf81Entity[3].toString() : "");
		            brf81.setBorrower_type(brf81Entity[4] != null ? brf81Entity[4].toString() : "");
		            brf81.setGroup_name(brf81Entity[5] != null ? brf81Entity[5].toString() : "");
		            brf81.setResident(brf81Entity[6] != null ? brf81Entity[6].toString() : "");
		            brf81.setCountry_incorporate(brf81Entity[7] != null ? brf81Entity[7].toString() : "");
		            brf81.setCredit_rating(brf81Entity[8] != null ? brf81Entity[8].toString() : "");
		            brf81.setCredit_rating_type(brf81Entity[9] != null ? brf81Entity[9].toString() : "");
		            brf81.setEconomic_sector(brf81Entity[10] != null ? brf81Entity[10].toString() : "");
		            brf81.setCurrency(brf81Entity[11] != null ? brf81Entity[11].toString() : "");
		            BigDecimal funded_os = brf81Entity[12] != null ? new BigDecimal(brf81Entity[12].toString()) : BigDecimal.ZERO;
		            brf81.setFunded_os(funded_os);
		            BigDecimal debit = brf81Entity[13] != null ? new BigDecimal(brf81Entity[13].toString()) : BigDecimal.ZERO;
		            brf81.setDebit(debit);
		            BigDecimal equities = brf81Entity[14] != null ? new BigDecimal(brf81Entity[14].toString()) : BigDecimal.ZERO;
		            brf81.setEquities(equities);
		            BigDecimal unfunded_os = brf81Entity[15] != null ? new BigDecimal(brf81Entity[15].toString()) : BigDecimal.ZERO;
		            brf81.setUnfunded_os(unfunded_os);
		            BigDecimal ccf_equi_unfuned_os = brf81Entity[16] != null ? new BigDecimal(brf81Entity[16].toString()) : BigDecimal.ZERO;
		            brf81.setCcf_equi_unfuned_os(ccf_equi_unfuned_os);
		            BigDecimal ccf_equi_funded_n_unfuned_limits = brf81Entity[17] != null ? new BigDecimal(brf81Entity[17].toString()) : BigDecimal.ZERO;
		            brf81.setCcf_equi_funded_n_unfuned_limits(ccf_equi_funded_n_unfuned_limits);
		            BigDecimal total_exposer = brf81Entity[18] != null ? new BigDecimal(brf81Entity[18].toString()) : BigDecimal.ZERO;
		            brf81.setTotal_exposer(total_exposer);
		            BigDecimal as_of_tier1_capital = brf81Entity[19] != null ? new BigDecimal(brf81Entity[19].toString()) : BigDecimal.ZERO;
		            brf81.setAs_of_tier1_capital(as_of_tier1_capital);
		            brf81.setCredit_risk_miti_type(brf81Entity[20] != null ? brf81Entity[20].toString() : "");
		            BigDecimal credit_risk_miti_hair_cut = brf81Entity[21] != null ? new BigDecimal(brf81Entity[21].toString()) : BigDecimal.ZERO;
		            brf81.setCredit_risk_miti_hair_cut(credit_risk_miti_hair_cut);
		            BigDecimal collateral_hair_cut = brf81Entity[22] != null ? new BigDecimal(brf81Entity[22].toString()) : BigDecimal.ZERO;
		            brf81.setCollateral_hair_cut(collateral_hair_cut);
		            brf81.setCbuae_class(brf81Entity[23] != null ? brf81Entity[23].toString() : "");
		            BigDecimal provision = brf81Entity[24] != null ? new BigDecimal(brf81Entity[24].toString()) : BigDecimal.ZERO;
		            brf81.setProvision(provision);
		            brf81.setRemarks(brf81Entity[25] != null ? brf81Entity[25].toString() : "");
		            T1rep.add(brf81);
		        }
		    } catch (ParseException e) {
		        logger.error("Error occurred while parsing date: " + e.getMessage());
		    }

		    // Adding objects to the ModelAndView
		    mv.setViewName("RR/BRF81ARCH");
		    mv.addObject("reportsummary", T1rep);
		    mv.addObject("getTier1_capital", BRF81_ENTITYREP.getTier1_capital(todate));
		    mv.addObject("getEntity_level", BRF81_ENTITYREP.getEntity_level(todate));
		    mv.addObject("getFundedOs", BRF81_ENTITYREP.getFundedOs(todate));
		    mv.addObject("getDebit", BRF81_ENTITYREP.getDebit(todate));
		    mv.addObject("getEquities", BRF81_ENTITYREP.getEquities(todate));
		    mv.addObject("getUnfundedOs", BRF81_ENTITYREP.getUnfundedOs(todate));
		    mv.addObject("getCcfEquiUnfundedOs", BRF81_ENTITYREP.getCcfEquiUnfundedOs(todate));
		    mv.addObject("getCcfEquiFundedAndUnfundedLimits", BRF81_ENTITYREP.getCcfEquiFundedAndUnfundedLimits(todate));
		    mv.addObject("getCredit_risk_miti_hair_cut", BRF81_ENTITYREP.getCredit_risk_miti_hair_cut(todate));
		    mv.addObject("getCollateral_hair_cut", BRF81_ENTITYREP.getCollateral_hair_cut(todate));
		    mv.addObject("getProvision", BRF81_ENTITYREP.getProvision(todate));
		   
		    BigDecimal funded_os = BRF81_ENTITYREP.getFundedOs(todate) != null
		            ? new BigDecimal(BRF81_ENTITYREP.getFundedOs(todate))
		            : BigDecimal.ZERO;
		    BigDecimal debit = BRF81_ENTITYREP.getDebit(todate) != null
		            ? new BigDecimal(BRF81_ENTITYREP.getDebit(todate))
		            : BigDecimal.ZERO;
		    BigDecimal equities = BRF81_ENTITYREP.getEquities(todate) != null
		            ? new BigDecimal(BRF81_ENTITYREP.getEquities(todate))
		            : BigDecimal.ZERO;
		    BigDecimal ccf_equi_unfuned_os = BRF81_ENTITYREP.getCcfEquiUnfundedOs(todate) != null
		            ? new BigDecimal(BRF81_ENTITYREP.getCcfEquiUnfundedOs(todate))
		            : BigDecimal.ZERO;
		    BigDecimal ccf_equi_funded_n_unfuned_limits = BRF81_ENTITYREP.getCcfEquiFundedAndUnfundedLimits(todate) != null
		            ? new BigDecimal(BRF81_ENTITYREP.getCcfEquiFundedAndUnfundedLimits(todate))
		            : BigDecimal.ZERO;

		    // Adding individual values to the model
		    mv.addObject("getfunded_os", funded_os);
		    mv.addObject("getdebt_securities", debit);
		    mv.addObject("getequities", equities);
		    mv.addObject("getccf_equivalent_of_unfunded_os", ccf_equi_unfuned_os);
		    mv.addObject("getccf_equivalent_limits", ccf_equi_funded_n_unfuned_limits);

		    // Summing up the values
		    BigDecimal total_exposer = funded_os.add(debit).add(equities).add(ccf_equi_unfuned_os).add(ccf_equi_funded_n_unfuned_limits);
		    mv.addObject("total_exposer", total_exposer);

		    // Fetching the value of getTier1_capital
		    String getTier1_capital = BRF81_ENTITYREP.getTier1_capital(todate);
		    String getEntity_level = BRF81_ENTITYREP.getEntity_level(todate);

		    // Adding total_exposer and getTier1_capital to the ModelAndView
		    mv.addObject("total_exposer", total_exposer);
		    mv.addObject("getTier1_capital", getTier1_capital);
		    mv.addObject("getEntity_level", getEntity_level);

		    BigDecimal tier1_capital_result;
		    if (getTier1_capital.equals(BigDecimal.ZERO)) {
		        tier1_capital_result = BigDecimal.ZERO;
		    } else {
		        tier1_capital_result = total_exposer.divide(new BigDecimal(getTier1_capital), MathContext.DECIMAL128);
		    }

		    // Adding expressionResult to the ModelAndView
		    mv.addObject("tier1_capital_result", tier1_capital_result);

		    // Additional objects for the view
		    mv.addObject("reportmaster", T1rep);
		    mv.addObject("displaymode", "summary");
		    mv.addObject("reportsflag", "reportsflag");
		    mv.addObject("menu", reportId);

		    System.out.println("scv" + mv.getViewName());

		    return mv;
		}
		


	/**** ARCH DETAILS 
	 * @throws ParseException ****/



	public ModelAndView ARCHgetBRF081currentDtl(String reportId, String fromdate, String todate, String currency,
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
				
				
					qr = hs.createNativeQuery("select * from BRF81_ARCHIVTABLE a where report_date=?1 and report_lable=?2");
					qr.setParameter(1,  df.parse(todate));
					qr.setParameter(2,filter);
						

			} else {
				System.out.println("2");
				qr = hs.createNativeQuery("select * from BRF81_ARCHIVTABLE");

			}
		} else {
			System.out.println("3");
			qr = hs.createNativeQuery("select * from BRF81_ARCHIVTABLE  where report_date = ?1");
		}

		List<BRF81_ARCHIVENTITY> T1Master = new ArrayList<BRF81_ARCHIVENTITY>();

		try {
			System.out.println("Values entered");
			T1Master = hs.createQuery("from BRF81_ARCHIVENTITY a where a.report_date = ?1", BRF81_ARCHIVENTITY.class)
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
			BigDecimal eab_lc  = (BigDecimal) a[3];
			String acct_name = (String) a[4];
			String acct_crncy_code= (String) a[5];
			String gl_code = (String) a[6];
			String gl_sub_head_code = (String) a[7];
			String gl_sub_head_desc = (String) a[8];
			String country_of_incorp = (String) a[9];
			String cust_type = (String) a[10];
			String schm_code  = (String) a[11];
			String schm_type  = (String) a[12];
			String sol_id  = (String) a[13];
			String acid = (String) a[14];
			String segment  = (String) a[15];
			String sub_segment  = (String) a[16];
			BigDecimal sector  = (BigDecimal) a[17];
			String sub_sector  = (String) a[18];
			String sector_code = (String) a[19];
			String group_id  = (String) a[20];
			String constitution_code = (String) a[21];
			String country = (String) a[22];
			String legal_entity_type  = (String) a[23];
			String constitution_desc = (String) a[24];
			String purpose_of_advn  = (String) a[25];
			BigDecimal hni_networth  = (BigDecimal) a[26];
			String turnover  = (String) a[27];
			String bacid = (String) a[28];
			String report_name_1 = (String) a[29];
			String report_label_1  = (String) a[30];
			String report_addl_criteria_1 = (String) a[31];
			String report_addl_criteria_2 = (String) a[32];
			String report_addl_criteria_3 = (String) a[33];	
			String create_user = (String) a[34];
		    Date create_time  = (Date) a[35];
		    String modify_user  = (String) a[36];
		    Date modify_time  = (Date) a[37];
		    String verify_user = (String) a[38];
			Date verify_time = (Date)  a[39];
			String entity_flg = (String) a[40];				
			String modify_flg = (String) a[41];
			String del_flg =(String) a[42];
			String nre_status  = (String) a[43];
			Date   report_date= (Date) a[44];
			Date maturity_date  = (Date) a[45];
			String gender = (String) a[46];
			String version=(String)a[47];		
			String remarks=(String)a[48];
			Character nre_flg=(Character)a[49];

											
			BRF81_ARCHIVENTITY py = new BRF81_ARCHIVENTITY( cust_id,  foracid,   act_balance_amt_lc,   eab_lc,
					 acct_name,  acct_crncy_code,  gl_code,  gl_sub_head_code,  gl_sub_head_desc,
					 country_of_incorp,  cust_type,  schm_code,  schm_type,  sol_id,  acid,
					 segment,  sub_segment,   sector,  sub_sector,  sector_code,
					 group_id,  constitution_code,  country,  legal_entity_type,
					 constitution_desc,  purpose_of_advn,   hni_networth,  turnover,  bacid,
					 report_name_1,  report_label_1,  report_addl_criteria_1,  report_addl_criteria_2,
					 report_addl_criteria_3,  create_user,   create_time,  modify_user,   modify_time,
					 verify_user,   verify_time,  entity_flg,  modify_flg,  del_flg,
					 nre_status,   report_date,   maturity_date,  gender,  version,  remarks,
					 nre_flg);
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

		mv.setViewName("RR" + "/" + "BRF81ARCH::reportcontent");
		mv.addObject("reportdetails", T1Dt1Page.getContent());
		mv.addObject("reportmaster", T1Master);
		mv.addObject("reportmaster1", qr);
		mv.addObject("singledetail", new T1CurProdDetail());
		mv.addObject("reportsflag", "reportsflag");
		mv.addObject("menu", reportId);
		return mv;
	}

	}



