
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
import java.util.Objects;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
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

import com.bornfire.xbrl.config.SequenceGenerator;
import com.bornfire.xbrl.entities.UserProfile;
import com.bornfire.xbrl.entities.UserProfileRep;
import com.bornfire.xbrl.entities.BRBS.BRF1_REPORT_ENTITY;
import com.bornfire.xbrl.entities.BRBS.BRF206A_RPT;
import com.bornfire.xbrl.entities.BRBS.BRF300AServiceRepo;
import com.bornfire.xbrl.entities.BRBS.BRF300_ARCHIVENTITY;
import com.bornfire.xbrl.entities.BRBS.BRF300_DETAIL_ENTITY;
import com.bornfire.xbrl.entities.BRBS.BRF300_Detailrepo;
import com.bornfire.xbrl.entities.BRBS.BRF300_ENTITY;
import com.bornfire.xbrl.entities.BRBS.BRF64_Entity;
import com.bornfire.xbrl.entities.BRBS.BRF70_ENTITY;
import com.bornfire.xbrl.entities.BRBS.MANUAL_Service_Entity;
import com.bornfire.xbrl.entities.BRBS.MANUAL_Service_Rep;
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
public class BRF300AReportService {
	private static final Logger logger = LoggerFactory.getLogger(BRF300AReportService.class);

	@Autowired
	SessionFactory sessionFactory;

	@Autowired
	DataSource srcdataSource;

	@Autowired
	Environment env;

	@Autowired
	BRF300_Detailrepo brf300_detailrepo;

	@Autowired
	BRF300AServiceRepo brf300aServiceRepo;

	@Autowired
	MANUAL_Service_Rep mANUAL_Service_Rep;

	@Autowired
	SequenceGenerator sequence;

	@Autowired
	UserProfileRep userProfileRep;

	DateFormat df = new SimpleDateFormat("dd-MMM-yyyy");

	public String preCheckBRF300A(String reportid, String fromdate, String todate) {

		String msg = "";
		Session hs = sessionFactory.getCurrentSession();
		Date dt1;
		Date dt9;
		logger.info("Report precheck : " + reportid);

		try {
			/* dt1 = new SimpleDateFormat("dd/MM/yyyy").parse(fromdate); */
			dt9 = new SimpleDateFormat("dd/MM/yyyy").parse(todate);
			logger.info("Getting No of records in Master table :" + reportid);
			Long dtlcnt = (Long) hs.createQuery("select count(*) from BRF300_ENTITY a where a.report_date=?1")
					.setParameter(1, dt9).getSingleResult();

			if (dtlcnt > 0) {
				logger.info("Getting No of records in Mod table :" + reportid);
				Long modcnt = (Long) hs.createQuery("select count(*) from BRF300_ENTITY a ").getSingleResult();
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

	public ModelAndView getBRF300AView(String reportId, String fromdate, String todate, String currency, String dtltype,
			Pageable pageable) {

		ModelAndView mv = new ModelAndView();

		Session hs = sessionFactory.getCurrentSession();
		int pageSize = pageable.getPageSize();
		int currentPage = pageable.getPageNumber();
		int startItem = currentPage * pageSize;
		List<BRF300_ENTITY> T1rep = new ArrayList<BRF300_ENTITY>();
		// Query<Object[]> qr;

		List<BRF300_ENTITY> T1Master = new ArrayList<BRF300_ENTITY>();

		logger.info("Inside archive" + currency);

		try {

			Date d1 = df.parse(todate);
			// T1rep = t1CurProdServiceRepo.getT1CurProdServices(d1);

			T1Master = hs.createQuery("from BRF300_ENTITY a where a.report_date = ?1 ", BRF300_ENTITY.class)
					.setParameter(1, df.parse(todate)).getResultList();

		} catch (ParseException e) {
			e.printStackTrace();
		}

		// T1rep = t1CurProdServiceRepo.getT1CurProdServices(d1);

		mv.setViewName("RR/BRF300");
		// mv.addObject("currlist", refCodeConfig.currList());
		mv.addObject("reportsummary", T1Master);
		mv.addObject("reportmaster", T1Master);
		mv.addObject("displaymode", "summary");
		mv.addObject("reportsflag", "reportsflag");
		mv.addObject("modify_flg", T1Master.size() > 0 ? T1Master.get(0).getModify_flg() : null);
		mv.addObject("modify_user", T1Master.size() > 0 ? T1Master.get(0).getModify_user() : null);
		mv.addObject("menu", reportId);
		System.out.println("scv" + mv.getViewName());

		return mv;

	}

	public ModelAndView getBRF300ADetails(String reportId, String fromdate, String todate, String currency,
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
						"select * from BRF300_DETAILTABLE  a where report_date = ?1 and report_label_1 =?2");

				qr.setParameter(2, filter);

			} else {
				qr = hs.createNativeQuery("select * from BRF300_DETAILTABLE a where report_date = ?1");

			}
		} else {
			qr = hs.createNativeQuery("select * from BRF300_DETAILTABLE  where report_date = ?1");
		}

		try {
			qr.setParameter(1, df.parse(todate));

		} catch (ParseException e) {
			e.printStackTrace();
		}
		List<BRF300_DETAIL_ENTITY> T1Master = new ArrayList<BRF300_DETAIL_ENTITY>();

		try {
			T1Master = hs
					.createQuery("from BRF300_DETAIL_ENTITY a where a.report_date = ?1", BRF300_DETAIL_ENTITY.class)
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

			BRF300_DETAIL_ENTITY py = new BRF300_DETAIL_ENTITY(cust_id, foracid, act_balance_amt_lc, eab_lc, acct_name,
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

		mv.setViewName("RR" + "/" + "BRF300::reportcontent");
		mv.addObject("reportdetails", T1Dt1Page.getContent());
		mv.addObject("reportmaster", T1Master);
		mv.addObject("reportmaster12", T1Dt1);
		mv.addObject("reportmaster1", qr);
		mv.addObject("singledetail", new T1CurProdDetail());
		mv.addObject("reportsflag", "reportsflag");
		mv.addObject("menu", reportId);
		return mv;
	}

	public File getFileBRF300A(String reportId, String fromdate, String todate, String currency, String dtltype,
			String filetype) throws FileNotFoundException, JRException, SQLException {

		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

		String path = this.env.getProperty("output.exportpath");
		String fileName = "";
		String zipFileName = "";
		File outputFile;

		logger.info("Getting Output file :" + reportId);
		fileName = "011-BRF-300-A";
		
		
		if (!filetype.equals("xbrl")) {
			if(!filetype.equals("BRF")) {
			

			try {
				InputStream jasperFile;
				logger.info("Getting Jasper file :" + reportId);
				if (filetype.equals("detailexcel")) {
					if (dtltype.equals("report")) {
						jasperFile = this.getClass().getResourceAsStream("/static/jasper/BRF300_Detail.jrxml");
					} else {
						jasperFile = this.getClass().getResourceAsStream("/static/jasper/BRF300_Detail.jrxml");
					}
 
				} else {
					if (dtltype.equals("report")) {
						logger.info("Inside report");
						jasperFile = this.getClass().getResourceAsStream("/static/jasper/BRF300.jrxml");
					} else {
						jasperFile = this.getClass().getResourceAsStream("/static/jasper/BRF300.jrxml");
					}
				}
 
				/* JasperReport jr = (JasperReport) JRLoader.loadObject(jasperFile); */
				JasperReport jr = JasperCompileManager.compileReport(jasperFile);
				HashMap<String, Object> map = new HashMap<String, Object>();
 
				logger.info("Assigning Parameters for Jasper");
				map.put("REPORT_DATE", todate);
 
				if (filetype.equals("pdf")) {
					System.out.println("PDF");
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
		List<BRF300_ENTITY> T1Master = new ArrayList<BRF300_ENTITY>();
		Session hs = sessionFactory.getCurrentSession();
		try {
			Date d1 = df.parse(todate);
		
		// T1rep = t1CurProdServiceRepo.getT1CurProdServices(d1);

		T1Master = hs.createQuery("from  BRF300_ENTITY a where a.report_date = ?1 ", BRF300_ENTITY.class)
				.setParameter(1, df.parse(todate)).getResultList();
		
		if(T1Master.size() == 1) {
			
			for(BRF300_ENTITY BRF300 : T1Master ) {
		
		File Responsecamt = new File(env.getProperty("output.exportpathtemp")+"011-BRF-300-AT.xls");
		
		  // Load the Excel file
    	Workbook workbook = WorkbookFactory.create(Responsecamt);

        // Get the first sheet
    	Sheet sheet = workbook.getSheetAt(0);
    	
							Row row = sheet.getRow(9);

							Cell R2cell = row.getCell(3);
							if (R2cell != null) {
								R2cell.setCellValue(
										BRF300.getR2_ABU_DHABI() == null ? 0 : BRF300.getR2_ABU_DHABI().intValue());
							}

							Cell R2cell1 = row.getCell(4);
							if (R2cell1 != null) {
								R2cell1.setCellValue(BRF300.getR2_WESTERNM_REGION() == null ? 0
										: BRF300.getR2_WESTERNM_REGION().intValue());
							}

							Cell R2cell2 = row.getCell(5);
							if (R2cell2 != null) {
								R2cell2.setCellValue(
										BRF300.getR2_AL_AIN() == null ? 0 : BRF300.getR2_AL_AIN().intValue());
							}

							Cell R2cell3 = row.getCell(6);
							if (R2cell3 != null) {
								R2cell3.setCellValue(
										BRF300.getR2_ISLAND() == null ? 0 : BRF300.getR2_ISLAND().intValue());
							}

							Cell R2cell4 = row.getCell(7);
							if (R2cell4 != null) {
								R2cell4.setCellValue(
										BRF300.getR2_DUBAI() == null ? 0 : BRF300.getR2_DUBAI().intValue());
							}

							Cell R2cell5 = row.getCell(8);
							if (R2cell5 != null) {
								R2cell5.setCellValue(
										BRF300.getR2_SHARJAH() == null ? 0 : BRF300.getR2_SHARJAH().intValue());
							}

							Cell R2cell6 = row.getCell(9);
							if (R2cell6 != null) {
								R2cell6.setCellValue(
										BRF300.getR2_AJMAN() == null ? 0 : BRF300.getR2_AJMAN().intValue());
							}

							Cell R2cell7 = row.getCell(10);
							if (R2cell7 != null) {
								R2cell7.setCellValue(
										BRF300.getR2_RAS_AL() == null ? 0 : BRF300.getR2_RAS_AL().intValue());
							}

							Cell R2cell8 = row.getCell(11);
							if (R2cell8 != null) {
								R2cell8.setCellValue(
										BRF300.getR2_UMM_AL() == null ? 0 : BRF300.getR2_UMM_AL().intValue());
							}

							Cell R2cell9 = row.getCell(12);
							if (R2cell9 != null) {
								R2cell9.setCellValue(
										BRF300.getR2_FUJAIRAH() == null ? 0 : BRF300.getR2_FUJAIRAH().intValue());
							}

//////////////////////R3///////////////////////            

							Row R3row = sheet.getRow(10);

							Cell R3cell = R3row.getCell(3);
							if (R3cell != null) {
								R3cell.setCellValue(
										BRF300.getR3_ABU_DHABI() == null ? 0 : BRF300.getR3_ABU_DHABI().intValue());
							}

							Cell R3cell1 = R3row.getCell(4);
							if (R3cell1 != null) {
								R3cell1.setCellValue(BRF300.getR3_WESTERNM_REGION() == null ? 0
										: BRF300.getR3_WESTERNM_REGION().intValue());
							}

							Cell R3cell2 = R3row.getCell(5);
							if (R3cell2 != null) {
								R3cell2.setCellValue(
										BRF300.getR3_AL_AIN() == null ? 0 : BRF300.getR3_AL_AIN().intValue());
							}

							Cell R3cell3 = R3row.getCell(6);
							if (R3cell3 != null) {
								R3cell3.setCellValue(
										BRF300.getR3_ISLAND() == null ? 0 : BRF300.getR3_ISLAND().intValue());
							}

							Cell R3cell4 = R3row.getCell(7);
							if (R3cell4 != null) {
								R3cell4.setCellValue(
										BRF300.getR3_DUBAI() == null ? 0 : BRF300.getR3_DUBAI().intValue());
							}

							Cell R3cell5 = R3row.getCell(8);
							if (R3cell5 != null) {
								R3cell5.setCellValue(
										BRF300.getR3_SHARJAH() == null ? 0 : BRF300.getR3_SHARJAH().intValue());
							}

							Cell R3cell6 = R3row.getCell(9);
							if (R3cell6 != null) {
								R3cell6.setCellValue(
										BRF300.getR3_AJMAN() == null ? 0 : BRF300.getR3_AJMAN().intValue());
							}

							Cell R3cell7 = R3row.getCell(10);
							if (R3cell7 != null) {
								R3cell7.setCellValue(
										BRF300.getR3_RAS_AL() == null ? 0 : BRF300.getR3_RAS_AL().intValue());
							}

							Cell R3cell8 = R3row.getCell(11);
							if (R3cell8 != null) {
								R3cell8.setCellValue(
										BRF300.getR3_UMM_AL() == null ? 0 : BRF300.getR3_UMM_AL().intValue());
							}

							Cell R3cell9 = R3row.getCell(12);
							if (R3cell9 != null) {
								R3cell9.setCellValue(
										BRF300.getR3_FUJAIRAH() == null ? 0 : BRF300.getR3_FUJAIRAH().intValue());
							}

//////////////////////R4///////////////////////            

							Row R4row = sheet.getRow(11);

							Cell R4cell = R4row.getCell(3);
							if (R4cell != null) {
								R4cell.setCellValue(
										BRF300.getR4_ABU_DHABI() == null ? 0 : BRF300.getR4_ABU_DHABI().intValue());
							}

							Cell R4cell1 = R4row.getCell(4);
							if (R4cell1 != null) {
								R4cell1.setCellValue(BRF300.getR4_WESTERNM_REGION() == null ? 0
										: BRF300.getR4_WESTERNM_REGION().intValue());
							}

							Cell R4cell2 = R4row.getCell(5);
							if (R4cell2 != null) {
								R4cell2.setCellValue(
										BRF300.getR4_AL_AIN() == null ? 0 : BRF300.getR4_AL_AIN().intValue());
							}

							Cell R4cell3 = R4row.getCell(6);
							if (R4cell3 != null) {
								R4cell3.setCellValue(
										BRF300.getR4_ISLAND() == null ? 0 : BRF300.getR4_ISLAND().intValue());
							}

							Cell R4cell4 = R4row.getCell(7);
							if (R4cell4 != null) {
								R4cell4.setCellValue(
										BRF300.getR4_DUBAI() == null ? 0 : BRF300.getR4_DUBAI().intValue());
							}

							Cell R4cell5 = R4row.getCell(8);
							if (R4cell5 != null) {
								R4cell5.setCellValue(
										BRF300.getR4_SHARJAH() == null ? 0 : BRF300.getR4_SHARJAH().intValue());
							}

							Cell R4cell6 = row.getCell(9);
							if (R4cell6 != null) {
								R4cell6.setCellValue(
										BRF300.getR4_AJMAN() == null ? 0 : BRF300.getR4_AJMAN().intValue());
							}

							Cell R4cell7 = R4row.getCell(10);
							if (R4cell7 != null) {
								R4cell7.setCellValue(
										BRF300.getR4_RAS_AL() == null ? 0 : BRF300.getR4_RAS_AL().intValue());
							}

							Cell R4cell8 = R4row.getCell(11);
							if (R4cell8 != null) {
								R4cell8.setCellValue(
										BRF300.getR4_UMM_AL() == null ? 0 : BRF300.getR4_UMM_AL().intValue());
							}

							Cell R4cell9 = R4row.getCell(12);
							if (R4cell9 != null) {
								R4cell9.setCellValue(
										BRF300.getR4_FUJAIRAH() == null ? 0 : BRF300.getR4_FUJAIRAH().intValue());
							}

//////////////////////R5///////////////////////            

							Row R5row = sheet.getRow(12);

							Cell R5cell = R5row.getCell(3);
							if (R5cell != null) {
								R5cell.setCellValue(
										BRF300.getR5_ABU_DHABI() == null ? 0 : BRF300.getR5_ABU_DHABI().intValue());
							}

							Cell R5cell1 = R5row.getCell(4);
							if (R5cell1 != null) {
								R5cell1.setCellValue(BRF300.getR5_WESTERNM_REGION() == null ? 0
										: BRF300.getR5_WESTERNM_REGION().intValue());
							}

							Cell R5cell2 = R5row.getCell(5);
							if (R5cell2 != null) {
								R5cell2.setCellValue(
										BRF300.getR5_AL_AIN() == null ? 0 : BRF300.getR5_AL_AIN().intValue());
							}

							Cell R5cell3 = R5row.getCell(6);
							if (R5cell3 != null) {
								R5cell3.setCellValue(
										BRF300.getR5_ISLAND() == null ? 0 : BRF300.getR5_ISLAND().intValue());
							}

							Cell R5cell4 = R5row.getCell(7);
							if (R5cell4 != null) {
								R5cell4.setCellValue(
										BRF300.getR5_DUBAI() == null ? 0 : BRF300.getR5_DUBAI().intValue());
							}

							Cell R5cell5 = R5row.getCell(8);
							if (R5cell5 != null) {
								R5cell5.setCellValue(
										BRF300.getR5_SHARJAH() == null ? 0 : BRF300.getR5_SHARJAH().intValue());
							}

							Cell R5cell6 = R5row.getCell(9);
							if (R5cell6 != null) {
								R5cell6.setCellValue(
										BRF300.getR5_AJMAN() == null ? 0 : BRF300.getR5_AJMAN().intValue());
							}

							Cell R5cell7 = R5row.getCell(10);
							if (R5cell7 != null) {
								R5cell7.setCellValue(
										BRF300.getR5_RAS_AL() == null ? 0 : BRF300.getR5_RAS_AL().intValue());
							}

							Cell R5cell8 = R5row.getCell(11);
							if (R5cell8 != null) {
								R5cell8.setCellValue(
										BRF300.getR5_UMM_AL() == null ? 0 : BRF300.getR5_UMM_AL().intValue());
							}

							Cell R5cell9 = row.getCell(12);
							if (R5cell9 != null) {
								R5cell9.setCellValue(
										BRF300.getR5_FUJAIRAH() == null ? 0 : BRF300.getR5_FUJAIRAH().intValue());
							}

//////////////////////R7///////////////////////            

							Row R7row = sheet.getRow(14);

							Cell R7cell = R7row.getCell(3);
							if (R7cell != null) {
								R7cell.setCellValue(
										BRF300.getR7_ABU_DHABI() == null ? 0 : BRF300.getR7_ABU_DHABI().intValue());
							}

							Cell R7cell1 = R7row.getCell(4);
							if (R7cell1 != null) {
								R7cell1.setCellValue(BRF300.getR7_WESTERNM_REGION() == null ? 0
										: BRF300.getR7_WESTERNM_REGION().intValue());
							}

							Cell R7cell2 = R7row.getCell(5);
							if (R7cell2 != null) {
								R7cell2.setCellValue(
										BRF300.getR7_AL_AIN() == null ? 0 : BRF300.getR7_AL_AIN().intValue());
							}

							Cell R7cell3 = R7row.getCell(6);
							if (R7cell3 != null) {
								R7cell3.setCellValue(
										BRF300.getR7_ISLAND() == null ? 0 : BRF300.getR7_ISLAND().intValue());
							}

							Cell R7cell4 = R7row.getCell(7);
							if (R7cell4 != null) {
								R7cell4.setCellValue(
										BRF300.getR7_DUBAI() == null ? 0 : BRF300.getR7_DUBAI().intValue());
							}

							Cell R7cell5 = R7row.getCell(8);
							if (R7cell5 != null) {
								R7cell5.setCellValue(
										BRF300.getR7_SHARJAH() == null ? 0 : BRF300.getR7_SHARJAH().intValue());
							}

							Cell R7cell6 = R7row.getCell(9);
							if (R7cell6 != null) {
								R7cell6.setCellValue(
										BRF300.getR7_AJMAN() == null ? 0 : BRF300.getR7_AJMAN().intValue());
							}

							Cell R7cell7 = R7row.getCell(10);
							if (R7cell7 != null) {
								R7cell7.setCellValue(
										BRF300.getR7_RAS_AL() == null ? 0 : BRF300.getR7_RAS_AL().intValue());
							}

							Cell R7cell8 = R7row.getCell(11);
							if (R7cell8 != null) {
								R7cell8.setCellValue(
										BRF300.getR7_UMM_AL() == null ? 0 : BRF300.getR7_UMM_AL().intValue());
							}

							Cell R7cell9 = R7row.getCell(12);
							if (R7cell9 != null) {
								R7cell9.setCellValue(
										BRF300.getR7_FUJAIRAH() == null ? 0 : BRF300.getR7_FUJAIRAH().intValue());
							}

//////////////////////R8///////////////////////            

							Row R8row = sheet.getRow(15);

							Cell R8cell = R8row.getCell(3);
							if (R8cell != null) {
								R8cell.setCellValue(
										BRF300.getR8_ABU_DHABI() == null ? 0 : BRF300.getR8_ABU_DHABI().intValue());
							}

							Cell R8cell1 = R8row.getCell(4);
							if (R8cell1 != null) {
								R8cell1.setCellValue(BRF300.getR8_WESTERNM_REGION() == null ? 0
										: BRF300.getR8_WESTERNM_REGION().intValue());
							}

							Cell R8cell2 = R8row.getCell(5);
							if (R8cell2 != null) {
								R8cell2.setCellValue(
										BRF300.getR8_AL_AIN() == null ? 0 : BRF300.getR8_AL_AIN().intValue());
							}

							Cell R8cell3 = R8row.getCell(6);
							if (R8cell3 != null) {
								R8cell3.setCellValue(
										BRF300.getR8_ISLAND() == null ? 0 : BRF300.getR8_ISLAND().intValue());
							}

							Cell R8cell4 = R8row.getCell(7);
							if (R8cell4 != null) {
								R8cell4.setCellValue(
										BRF300.getR8_DUBAI() == null ? 0 : BRF300.getR8_DUBAI().intValue());
							}

							Cell R8cell5 = R8row.getCell(8);
							if (R8cell5 != null) {
								R8cell5.setCellValue(
										BRF300.getR8_SHARJAH() == null ? 0 : BRF300.getR8_SHARJAH().intValue());
							}

							Cell R8cell6 = R8row.getCell(9);
							if (R8cell6 != null) {
								R8cell6.setCellValue(
										BRF300.getR8_AJMAN() == null ? 0 : BRF300.getR8_AJMAN().intValue());
							}

							Cell R8cell7 = R8row.getCell(10);
							if (R8cell7 != null) {
								R8cell7.setCellValue(
										BRF300.getR8_RAS_AL() == null ? 0 : BRF300.getR8_RAS_AL().intValue());
							}

							Cell R8cell8 = R8row.getCell(11);
							if (R8cell8 != null) {
								R8cell8.setCellValue(
										BRF300.getR8_UMM_AL() == null ? 0 : BRF300.getR8_UMM_AL().intValue());
							}

							Cell R8cell9 = R8row.getCell(12);
							if (R8cell9 != null) {
								R8cell9.setCellValue(
										BRF300.getR8_FUJAIRAH() == null ? 0 : BRF300.getR8_FUJAIRAH().intValue());
							}

//////////////////////R9///////////////////////            

							Row R9row = sheet.getRow(16);

							Cell R9cell = R9row.getCell(3);
							if (R9cell != null) {
								R9cell.setCellValue(
										BRF300.getR9_ABU_DHABI() == null ? 0 : BRF300.getR9_ABU_DHABI().intValue());
							}

							Cell R9cell1 = R9row.getCell(4);
							if (R9cell1 != null) {
								R9cell1.setCellValue(BRF300.getR9_WESTERNM_REGION() == null ? 0
										: BRF300.getR9_WESTERNM_REGION().intValue());
							}

							Cell R9cell2 = R9row.getCell(5);
							if (R9cell2 != null) {
								R9cell2.setCellValue(
										BRF300.getR9_AL_AIN() == null ? 0 : BRF300.getR9_AL_AIN().intValue());
							}

							Cell R9cell3 = R9row.getCell(6);
							if (R9cell3 != null) {
								R9cell3.setCellValue(
										BRF300.getR9_ISLAND() == null ? 0 : BRF300.getR9_ISLAND().intValue());
							}

							Cell R9cell4 = R9row.getCell(7);
							if (R9cell4 != null) {
								R9cell4.setCellValue(
										BRF300.getR9_DUBAI() == null ? 0 : BRF300.getR9_DUBAI().intValue());
							}

							Cell R9cell5 = R9row.getCell(8);
							if (R9cell5 != null) {
								R9cell5.setCellValue(
										BRF300.getR9_SHARJAH() == null ? 0 : BRF300.getR9_SHARJAH().intValue());
							}

							Cell R9cell6 = R9row.getCell(9);
							if (R9cell6 != null) {
								R9cell6.setCellValue(
										BRF300.getR9_AJMAN() == null ? 0 : BRF300.getR9_AJMAN().intValue());
							}

							Cell R9cell7 = R9row.getCell(10);
							if (R9cell7 != null) {
								R9cell7.setCellValue(
										BRF300.getR9_RAS_AL() == null ? 0 : BRF300.getR9_RAS_AL().intValue());
							}

							Cell R9cell8 = R9row.getCell(11);
							if (R9cell8 != null) {
								R9cell8.setCellValue(
										BRF300.getR9_UMM_AL() == null ? 0 : BRF300.getR9_UMM_AL().intValue());
							}

							Cell R9cell9 = R9row.getCell(12);
							if (R9cell9 != null) {
								R9cell9.setCellValue(
										BRF300.getR9_FUJAIRAH() == null ? 0 : BRF300.getR9_FUJAIRAH().intValue());
							}

//////////////////////R10///////////////////////            

							Row R10row = sheet.getRow(17);

							Cell R10cell = R10row.getCell(3);
							if (R10cell != null) {
								R10cell.setCellValue(
										BRF300.getR10_ABU_DHABI() == null ? 0 : BRF300.getR10_ABU_DHABI().intValue());
							}

							Cell R10cell1 = R10row.getCell(4);
							if (R10cell1 != null) {
								R10cell1.setCellValue(BRF300.getR10_WESTERNM_REGION() == null ? 0
										: BRF300.getR10_WESTERNM_REGION().intValue());
							}

							Cell R10cell2 = R10row.getCell(5);
							if (R10cell2 != null) {
								R10cell2.setCellValue(
										BRF300.getR10_AL_AIN() == null ? 0 : BRF300.getR10_AL_AIN().intValue());
							}

							Cell R10cell3 = R10row.getCell(6);
							if (R10cell3 != null) {
								R10cell3.setCellValue(
										BRF300.getR10_ISLAND() == null ? 0 : BRF300.getR10_ISLAND().intValue());
							}

							Cell R10cell4 = R10row.getCell(7);
							if (R10cell4 != null) {
								R10cell4.setCellValue(
										BRF300.getR10_DUBAI() == null ? 0 : BRF300.getR10_DUBAI().intValue());
							}

							Cell R10cell5 = R10row.getCell(8);
							if (R10cell5 != null) {
								R10cell5.setCellValue(
										BRF300.getR10_SHARJAH() == null ? 0 : BRF300.getR10_SHARJAH().intValue());
							}

							Cell R10cell6 = R10row.getCell(9);
							if (R10cell6 != null) {
								R10cell6.setCellValue(
										BRF300.getR10_AJMAN() == null ? 0 : BRF300.getR10_AJMAN().intValue());
							}

							Cell R10cell7 = R10row.getCell(10);
							if (R10cell7 != null) {
								R10cell7.setCellValue(
										BRF300.getR10_RAS_AL() == null ? 0 : BRF300.getR10_RAS_AL().intValue());
							}

							Cell R10cell8 = R10row.getCell(11);
							if (R10cell8 != null) {
								R10cell8.setCellValue(
										BRF300.getR10_UMM_AL() == null ? 0 : BRF300.getR10_UMM_AL().intValue());
							}

							Cell R10cell9 = R10row.getCell(12);
							if (R10cell9 != null) {
								R10cell9.setCellValue(
										BRF300.getR10_FUJAIRAH() == null ? 0 : BRF300.getR10_FUJAIRAH().intValue());
							}

//////////////////////R12///////////////////////            

							Row R12row = sheet.getRow(19);

							Cell R12cell = R12row.getCell(3);
							if (R12cell != null) {
								R12cell.setCellValue(
										BRF300.getR12_ABU_DHABI() == null ? 0 : BRF300.getR12_ABU_DHABI().intValue());
							}

							Cell R12cell1 = R12row.getCell(4);
							if (R12cell1 != null) {
								R12cell1.setCellValue(BRF300.getR12_WESTERNM_REGION() == null ? 0
										: BRF300.getR12_WESTERNM_REGION().intValue());
							}

							Cell R12cell2 = R12row.getCell(5);
							if (R12cell2 != null) {
								R12cell2.setCellValue(
										BRF300.getR12_AL_AIN() == null ? 0 : BRF300.getR12_AL_AIN().intValue());
							}

							Cell R12cell3 = R12row.getCell(6);
							if (R12cell3 != null) {
								R12cell3.setCellValue(
										BRF300.getR12_ISLAND() == null ? 0 : BRF300.getR12_ISLAND().intValue());
							}

							Cell R12cell4 = R12row.getCell(7);
							if (R12cell4 != null) {
								R12cell4.setCellValue(
										BRF300.getR12_DUBAI() == null ? 0 : BRF300.getR12_DUBAI().intValue());
							}

							Cell R12cell5 = R12row.getCell(8);
							if (R12cell5 != null) {
								R12cell5.setCellValue(
										BRF300.getR12_SHARJAH() == null ? 0 : BRF300.getR12_SHARJAH().intValue());
							}

							Cell R12cell6 = R12row.getCell(9);
							if (R12cell6 != null) {
								R12cell6.setCellValue(
										BRF300.getR12_AJMAN() == null ? 0 : BRF300.getR12_AJMAN().intValue());
							}

							Cell R12cell7 = R12row.getCell(10);
							if (R12cell7 != null) {
								R12cell7.setCellValue(
										BRF300.getR12_RAS_AL() == null ? 0 : BRF300.getR12_RAS_AL().intValue());
							}

							Cell R12cell8 = R12row.getCell(11);
							if (R12cell8 != null) {
								R12cell8.setCellValue(
										BRF300.getR12_UMM_AL() == null ? 0 : BRF300.getR12_UMM_AL().intValue());
							}

							Cell R12cell9 = R12row.getCell(12);
							if (R12cell9 != null) {
								R12cell9.setCellValue(
										BRF300.getR12_FUJAIRAH() == null ? 0 : BRF300.getR12_FUJAIRAH().intValue());
							}

//////////////////////R13///////////////////////            

							Row R13row = sheet.getRow(20);

							Cell R13cell = R13row.getCell(3);
							if (R13cell != null) {
								R13cell.setCellValue(
										BRF300.getR13_ABU_DHABI() == null ? 0 : BRF300.getR13_ABU_DHABI().intValue());
							}

							Cell R13cell1 = R13row.getCell(4);
							if (R13cell1 != null) {
								R13cell1.setCellValue(BRF300.getR13_WESTERNM_REGION() == null ? 0
										: BRF300.getR13_WESTERNM_REGION().intValue());
							}

							Cell R13cell2 = R13row.getCell(5);
							if (R13cell2 != null) {
								R13cell2.setCellValue(
										BRF300.getR13_AL_AIN() == null ? 0 : BRF300.getR13_AL_AIN().intValue());
							}

							Cell R13cell3 = R13row.getCell(6);
							if (R13cell3 != null) {
								R13cell3.setCellValue(
										BRF300.getR13_ISLAND() == null ? 0 : BRF300.getR13_ISLAND().intValue());
							}

							Cell R13cell4 = R13row.getCell(7);
							if (R13cell4 != null) {
								R13cell4.setCellValue(
										BRF300.getR13_DUBAI() == null ? 0 : BRF300.getR13_DUBAI().intValue());
							}

							Cell R13cell5 = R13row.getCell(8);
							if (R13cell5 != null) {
								R13cell5.setCellValue(
										BRF300.getR13_SHARJAH() == null ? 0 : BRF300.getR13_SHARJAH().intValue());
							}

							Cell R13cell6 = R13row.getCell(9);
							if (R13cell6 != null) {
								R13cell6.setCellValue(
										BRF300.getR13_AJMAN() == null ? 0 : BRF300.getR13_AJMAN().intValue());
							}

							Cell R13cell7 = R13row.getCell(10);
							if (R13cell7 != null) {
								R13cell7.setCellValue(
										BRF300.getR13_RAS_AL() == null ? 0 : BRF300.getR13_RAS_AL().intValue());
							}

							Cell R13cell8 = R13row.getCell(11);
							if (R13cell8 != null) {
								R13cell8.setCellValue(
										BRF300.getR13_UMM_AL() == null ? 0 : BRF300.getR13_UMM_AL().intValue());
							}

							Cell R13cell9 = R13row.getCell(12);
							if (R13cell9 != null) {
								R13cell9.setCellValue(
										BRF300.getR13_FUJAIRAH() == null ? 0 : BRF300.getR13_FUJAIRAH().intValue());
							}

//////////////////////R14///////////////////////            

							Row R14row = sheet.getRow(21);

							Cell R14cell = R14row.getCell(3);
							if (R14cell != null) {
								R14cell.setCellValue(
										BRF300.getR14_ABU_DHABI() == null ? 0 : BRF300.getR14_ABU_DHABI().intValue());
							}

							Cell R14cell1 = R14row.getCell(4);
							if (R14cell1 != null) {
								R14cell1.setCellValue(BRF300.getR14_WESTERNM_REGION() == null ? 0
										: BRF300.getR14_WESTERNM_REGION().intValue());
							}

							Cell R14cell2 = R14row.getCell(5);
							if (R14cell2 != null) {
								R14cell2.setCellValue(
										BRF300.getR14_AL_AIN() == null ? 0 : BRF300.getR14_AL_AIN().intValue());
							}

							Cell R14cell3 = R14row.getCell(6);
							if (R14cell3 != null) {
								R14cell3.setCellValue(
										BRF300.getR14_ISLAND() == null ? 0 : BRF300.getR14_ISLAND().intValue());
							}

							Cell R14cell4 = R14row.getCell(7);
							if (R14cell4 != null) {
								R14cell4.setCellValue(
										BRF300.getR14_DUBAI() == null ? 0 : BRF300.getR14_DUBAI().intValue());
							}

							Cell R14cell5 = R14row.getCell(8);
							if (R14cell5 != null) {
								R14cell5.setCellValue(
										BRF300.getR14_SHARJAH() == null ? 0 : BRF300.getR14_SHARJAH().intValue());
							}

							Cell R14cell6 = R14row.getCell(9);
							if (R14cell6 != null) {
								R14cell6.setCellValue(
										BRF300.getR14_AJMAN() == null ? 0 : BRF300.getR14_AJMAN().intValue());
							}

							Cell R14cell7 = R14row.getCell(10);
							if (R14cell7 != null) {
								R14cell7.setCellValue(
										BRF300.getR14_RAS_AL() == null ? 0 : BRF300.getR14_RAS_AL().intValue());
							}

							Cell R14cell8 = R14row.getCell(11);
							if (R14cell8 != null) {
								R14cell8.setCellValue(
										BRF300.getR14_UMM_AL() == null ? 0 : BRF300.getR14_UMM_AL().intValue());
							}

							Cell R14cell9 = R14row.getCell(12);
							if (R14cell9 != null) {
								R14cell9.setCellValue(
										BRF300.getR14_FUJAIRAH() == null ? 0 : BRF300.getR14_FUJAIRAH().intValue());
							}

//////////////////////R15///////////////////////            

							Row R15row = sheet.getRow(22);

							Cell R15cell = R15row.getCell(3);
							if (R15cell != null) {
								R15cell.setCellValue(
										BRF300.getR15_ABU_DHABI() == null ? 0 : BRF300.getR15_ABU_DHABI().intValue());
							}

							Cell R15cell1 = R15row.getCell(4);
							if (R15cell1 != null) {
								R15cell1.setCellValue(BRF300.getR15_WESTERNM_REGION() == null ? 0
										: BRF300.getR15_WESTERNM_REGION().intValue());
							}

							Cell R15cell2 = R15row.getCell(5);
							if (R15cell2 != null) {
								R15cell2.setCellValue(
										BRF300.getR15_AL_AIN() == null ? 0 : BRF300.getR15_AL_AIN().intValue());
							}

							Cell R15cell3 = R15row.getCell(6);
							if (R15cell3 != null) {
								R15cell3.setCellValue(
										BRF300.getR15_ISLAND() == null ? 0 : BRF300.getR15_ISLAND().intValue());
							}

							Cell R15cell4 = R15row.getCell(7);
							if (R15cell4 != null) {
								R15cell4.setCellValue(
										BRF300.getR15_DUBAI() == null ? 0 : BRF300.getR15_DUBAI().intValue());
							}

							Cell R15cell5 = R15row.getCell(8);
							if (R15cell5 != null) {
								R15cell5.setCellValue(
										BRF300.getR15_SHARJAH() == null ? 0 : BRF300.getR15_SHARJAH().intValue());
							}

							Cell R15cell6 = R15row.getCell(9);
							if (R15cell6 != null) {
								R15cell6.setCellValue(
										BRF300.getR15_AJMAN() == null ? 0 : BRF300.getR15_AJMAN().intValue());
							}

							Cell R15cell7 = R15row.getCell(10);
							if (R15cell7 != null) {
								R15cell7.setCellValue(
										BRF300.getR15_RAS_AL() == null ? 0 : BRF300.getR15_RAS_AL().intValue());
							}

							Cell R15cell8 = R15row.getCell(11);
							if (R15cell8 != null) {
								R15cell8.setCellValue(
										BRF300.getR15_UMM_AL() == null ? 0 : BRF300.getR15_UMM_AL().intValue());
							}

							Cell R15cell9 = R15row.getCell(12);
							if (R15cell9 != null) {
								R15cell9.setCellValue(
										BRF300.getR15_FUJAIRAH() == null ? 0 : BRF300.getR15_FUJAIRAH().intValue());
							}

//////////////////////R17///////////////////////            

							Row R17row = sheet.getRow(24);

							Cell R17cell = R17row.getCell(3);
							if (R17cell != null) {
								R17cell.setCellValue(
										BRF300.getR17_ABU_DHABI() == null ? 0 : BRF300.getR17_ABU_DHABI().intValue());
							}

							Cell R17cell1 = R17row.getCell(4);
							if (R17cell1 != null) {
								R17cell1.setCellValue(BRF300.getR17_WESTERNM_REGION() == null ? 0
										: BRF300.getR17_WESTERNM_REGION().intValue());
							}

							Cell R17cell2 = R17row.getCell(5);
							if (R17cell2 != null) {
								R17cell2.setCellValue(
										BRF300.getR17_AL_AIN() == null ? 0 : BRF300.getR17_AL_AIN().intValue());
							}

							Cell R17cell3 = R17row.getCell(6);
							if (R17cell3 != null) {
								R17cell3.setCellValue(
										BRF300.getR17_ISLAND() == null ? 0 : BRF300.getR17_ISLAND().intValue());
							}

							Cell R17cell4 = R17row.getCell(7);
							if (R17cell4 != null) {
								R17cell4.setCellValue(
										BRF300.getR17_DUBAI() == null ? 0 : BRF300.getR17_DUBAI().intValue());
							}

							Cell R17cell5 = R17row.getCell(8);
							if (R17cell5 != null) {
								R17cell5.setCellValue(
										BRF300.getR17_SHARJAH() == null ? 0 : BRF300.getR17_SHARJAH().intValue());
							}

							Cell R17cell6 = R17row.getCell(9);
							if (R17cell6 != null) {
								R17cell6.setCellValue(
										BRF300.getR17_AJMAN() == null ? 0 : BRF300.getR17_AJMAN().intValue());
							}

							Cell R17cell7 = R17row.getCell(10);
							if (R17cell7 != null) {
								R17cell7.setCellValue(
										BRF300.getR17_RAS_AL() == null ? 0 : BRF300.getR17_RAS_AL().intValue());
							}

							Cell R17cell8 = R17row.getCell(11);
							if (R17cell8 != null) {
								R17cell8.setCellValue(
										BRF300.getR17_UMM_AL() == null ? 0 : BRF300.getR17_UMM_AL().intValue());
							}

							Cell R17cell9 = R17row.getCell(12);
							if (R17cell9 != null) {
								R17cell9.setCellValue(
										BRF300.getR17_FUJAIRAH() == null ? 0 : BRF300.getR17_FUJAIRAH().intValue());
							}

//////////////////////R18///////////////////////            

							Row R18row = sheet.getRow(25);

							Cell R18cell = R18row.getCell(3);
							if (R18cell != null) {
								R18cell.setCellValue(
										BRF300.getR18_ABU_DHABI() == null ? 0 : BRF300.getR18_ABU_DHABI().intValue());
							}

							Cell R18cell1 = R18row.getCell(4);
							if (R18cell1 != null) {
								R18cell1.setCellValue(BRF300.getR18_WESTERNM_REGION() == null ? 0
										: BRF300.getR18_WESTERNM_REGION().intValue());
							}

							Cell R18cell2 = R18row.getCell(5);
							if (R18cell2 != null) {
								R18cell2.setCellValue(
										BRF300.getR18_AL_AIN() == null ? 0 : BRF300.getR18_AL_AIN().intValue());
							}

							Cell R18cell3 = R18row.getCell(6);
							if (R18cell3 != null) {
								R18cell3.setCellValue(
										BRF300.getR18_ISLAND() == null ? 0 : BRF300.getR18_ISLAND().intValue());
							}

							Cell R18cell4 = R18row.getCell(7);
							if (R18cell4 != null) {
								R18cell4.setCellValue(
										BRF300.getR18_DUBAI() == null ? 0 : BRF300.getR18_DUBAI().intValue());
							}

							Cell R18cell5 = R18row.getCell(8);
							if (R18cell5 != null) {
								R18cell5.setCellValue(
										BRF300.getR18_SHARJAH() == null ? 0 : BRF300.getR18_SHARJAH().intValue());
							}

							Cell R18cell6 = R18row.getCell(9);
							if (R18cell6 != null) {
								R18cell6.setCellValue(
										BRF300.getR18_AJMAN() == null ? 0 : BRF300.getR18_AJMAN().intValue());
							}

							Cell R18cell7 = R18row.getCell(10);
							if (R18cell7 != null) {
								R18cell7.setCellValue(
										BRF300.getR18_RAS_AL() == null ? 0 : BRF300.getR18_RAS_AL().intValue());
							}

							Cell R18cell8 = R18row.getCell(11);
							if (R18cell8 != null) {
								R18cell8.setCellValue(
										BRF300.getR18_UMM_AL() == null ? 0 : BRF300.getR18_UMM_AL().intValue());
							}

							Cell R18cell9 = R18row.getCell(12);
							if (R18cell9 != null) {
								R18cell9.setCellValue(
										BRF300.getR18_FUJAIRAH() == null ? 0 : BRF300.getR18_FUJAIRAH().intValue());
							}

//////////////////////R19///////////////////////            

							Row R19row = sheet.getRow(26);

							Cell R19cell = R19row.getCell(3);
							if (R19cell != null) {
								R19cell.setCellValue(
										BRF300.getR19_ABU_DHABI() == null ? 0 : BRF300.getR19_ABU_DHABI().intValue());
							}

							Cell R19cell1 = R19row.getCell(4);
							if (R19cell1 != null) {
								R19cell1.setCellValue(BRF300.getR19_WESTERNM_REGION() == null ? 0
										: BRF300.getR19_WESTERNM_REGION().intValue());
							}

							Cell R19cell2 = R19row.getCell(5);
							if (R19cell2 != null) {
								R19cell2.setCellValue(
										BRF300.getR19_AL_AIN() == null ? 0 : BRF300.getR19_AL_AIN().intValue());
							}

							Cell R19cell3 = R19row.getCell(6);
							if (R19cell3 != null) {
								R19cell3.setCellValue(
										BRF300.getR19_ISLAND() == null ? 0 : BRF300.getR19_ISLAND().intValue());
							}

							Cell R19cell4 = R19row.getCell(7);
							if (R19cell4 != null) {
								R19cell4.setCellValue(
										BRF300.getR19_DUBAI() == null ? 0 : BRF300.getR19_DUBAI().intValue());
							}

							Cell R19cell5 = R19row.getCell(8);
							if (R19cell5 != null) {
								R19cell5.setCellValue(
										BRF300.getR19_SHARJAH() == null ? 0 : BRF300.getR19_SHARJAH().intValue());
							}

							Cell R19cell6 = R19row.getCell(9);
							if (R19cell6 != null) {
								R19cell6.setCellValue(
										BRF300.getR19_AJMAN() == null ? 0 : BRF300.getR19_AJMAN().intValue());
							}

							Cell R19cell7 = R19row.getCell(10);
							if (R19cell7 != null) {
								R19cell7.setCellValue(
										BRF300.getR19_RAS_AL() == null ? 0 : BRF300.getR19_RAS_AL().intValue());
							}

							Cell R19cell8 = R19row.getCell(11);
							if (R19cell8 != null) {
								R19cell8.setCellValue(
										BRF300.getR19_UMM_AL() == null ? 0 : BRF300.getR19_UMM_AL().intValue());
							}

							Cell R19cell9 = R19row.getCell(12);
							if (R19cell9 != null) {
								R19cell9.setCellValue(
										BRF300.getR19_FUJAIRAH() == null ? 0 : BRF300.getR19_FUJAIRAH().intValue());
							}

//////////////////////R22///////////////////////            

							Row R22row = sheet.getRow(29);

							Cell R22cell = R22row.getCell(3);
							if (R22cell != null) {
								R22cell.setCellValue(
										BRF300.getR22_ABU_DHABI() == null ? 0 : BRF300.getR22_ABU_DHABI().intValue());
							}

							Cell R22cell1 = R22row.getCell(4);
							if (R22cell1 != null) {
								R22cell1.setCellValue(BRF300.getR22_WESTERNM_REGION() == null ? 0
										: BRF300.getR22_WESTERNM_REGION().intValue());
							}

							Cell R22cell2 = R22row.getCell(5);
							if (R22cell2 != null) {
								R22cell2.setCellValue(
										BRF300.getR22_AL_AIN() == null ? 0 : BRF300.getR22_AL_AIN().intValue());
							}

							Cell R22cell3 = R22row.getCell(6);
							if (R22cell3 != null) {
								R22cell3.setCellValue(
										BRF300.getR22_ISLAND() == null ? 0 : BRF300.getR22_ISLAND().intValue());
							}

							Cell R22cell4 = R22row.getCell(7);
							if (R22cell4 != null) {
								R22cell4.setCellValue(
										BRF300.getR22_DUBAI() == null ? 0 : BRF300.getR22_DUBAI().intValue());
							}

							Cell R22cell5 = R22row.getCell(8);
							if (R22cell5 != null) {
								R22cell5.setCellValue(
										BRF300.getR22_SHARJAH() == null ? 0 : BRF300.getR22_SHARJAH().intValue());
							}

							Cell R22cell6 = R22row.getCell(9);
							if (R22cell6 != null) {
								R22cell6.setCellValue(
										BRF300.getR22_AJMAN() == null ? 0 : BRF300.getR22_AJMAN().intValue());
							}

							Cell R22cell7 = R22row.getCell(10);
							if (R22cell7 != null) {
								R22cell7.setCellValue(
										BRF300.getR22_RAS_AL() == null ? 0 : BRF300.getR22_RAS_AL().intValue());
							}

							Cell R22cell8 = R22row.getCell(11);
							if (R22cell8 != null) {
								R22cell8.setCellValue(
										BRF300.getR22_UMM_AL() == null ? 0 : BRF300.getR22_UMM_AL().intValue());
							}

							Cell R22cell9 = R22row.getCell(12);
							if (R22cell9 != null) {
								R22cell9.setCellValue(
										BRF300.getR22_FUJAIRAH() == null ? 0 : BRF300.getR22_FUJAIRAH().intValue());
							}

//////////////////////R23///////////////////////            

							Row R23row = sheet.getRow(30);

							Cell R23cell = R23row.getCell(3);
							if (R23cell != null) {
								R23cell.setCellValue(
										BRF300.getR23_ABU_DHABI() == null ? 0 : BRF300.getR23_ABU_DHABI().intValue());
							}

							Cell R23cell1 = R23row.getCell(4);
							if (R23cell1 != null) {
								R23cell1.setCellValue(BRF300.getR23_WESTERNM_REGION() == null ? 0
										: BRF300.getR23_WESTERNM_REGION().intValue());
							}

							Cell R23cell2 = R23row.getCell(5);
							if (R23cell2 != null) {
								R23cell2.setCellValue(
										BRF300.getR23_AL_AIN() == null ? 0 : BRF300.getR23_AL_AIN().intValue());
							}

							Cell R23cell3 = R23row.getCell(6);
							if (R23cell3 != null) {
								R23cell3.setCellValue(
										BRF300.getR23_ISLAND() == null ? 0 : BRF300.getR23_ISLAND().intValue());
							}

							Cell R23cell4 = R23row.getCell(7);
							if (R23cell4 != null) {
								R23cell4.setCellValue(
										BRF300.getR23_DUBAI() == null ? 0 : BRF300.getR23_DUBAI().intValue());
							}

							Cell R23cell5 = R23row.getCell(8);
							if (R23cell5 != null) {
								R23cell5.setCellValue(
										BRF300.getR23_SHARJAH() == null ? 0 : BRF300.getR23_SHARJAH().intValue());
							}

							Cell R23cell6 = R23row.getCell(9);
							if (R23cell6 != null) {
								R23cell6.setCellValue(
										BRF300.getR23_AJMAN() == null ? 0 : BRF300.getR23_AJMAN().intValue());
							}

							Cell R23cell7 = R23row.getCell(10);
							if (R23cell7 != null) {
								R23cell7.setCellValue(
										BRF300.getR23_RAS_AL() == null ? 0 : BRF300.getR23_RAS_AL().intValue());
							}

							Cell R23cell8 = R23row.getCell(11);
							if (R23cell8 != null) {
								R23cell8.setCellValue(
										BRF300.getR23_UMM_AL() == null ? 0 : BRF300.getR23_UMM_AL().intValue());
							}

							Cell R23cell9 = R23row.getCell(12);
							if (R23cell9 != null) {
								R23cell9.setCellValue(
										BRF300.getR23_FUJAIRAH() == null ? 0 : BRF300.getR23_FUJAIRAH().intValue());
							}

//////////////////////R24///////////////////////            

							Row R24row = sheet.getRow(31);

							Cell R24cell = R24row.getCell(3);
							if (R24cell != null) {
								R24cell.setCellValue(
										BRF300.getR24_ABU_DHABI() == null ? 0 : BRF300.getR24_ABU_DHABI().intValue());
							}

							Cell R24cell1 = R24row.getCell(4);
							if (R24cell1 != null) {
								R24cell1.setCellValue(BRF300.getR24_WESTERNM_REGION() == null ? 0
										: BRF300.getR24_WESTERNM_REGION().intValue());
							}

							Cell R24cell2 = R24row.getCell(5);
							if (R24cell2 != null) {
								R24cell2.setCellValue(
										BRF300.getR24_AL_AIN() == null ? 0 : BRF300.getR24_AL_AIN().intValue());
							}

							Cell R24cell3 = R24row.getCell(6);
							if (R24cell3 != null) {
								R24cell3.setCellValue(
										BRF300.getR24_ISLAND() == null ? 0 : BRF300.getR24_ISLAND().intValue());
							}

							Cell R24cell4 = R24row.getCell(7);
							if (R24cell4 != null) {
								R24cell4.setCellValue(
										BRF300.getR24_DUBAI() == null ? 0 : BRF300.getR24_DUBAI().intValue());
							}

							Cell R24cell5 = R24row.getCell(8);
							if (R24cell5 != null) {
								R24cell5.setCellValue(
										BRF300.getR24_SHARJAH() == null ? 0 : BRF300.getR24_SHARJAH().intValue());
							}

							Cell R24cell6 = R24row.getCell(9);
							if (R24cell6 != null) {
								R24cell6.setCellValue(
										BRF300.getR24_AJMAN() == null ? 0 : BRF300.getR24_AJMAN().intValue());
							}

							Cell R24cell7 = R24row.getCell(10);
							if (R24cell7 != null) {
								R24cell7.setCellValue(
										BRF300.getR24_RAS_AL() == null ? 0 : BRF300.getR24_RAS_AL().intValue());
							}

							Cell R24cell8 = R24row.getCell(11);
							if (R24cell8 != null) {
								R24cell8.setCellValue(
										BRF300.getR24_UMM_AL() == null ? 0 : BRF300.getR24_UMM_AL().intValue());
							}

							Cell R24cell9 = R24row.getCell(12);
							if (R24cell9 != null) {
								R24cell9.setCellValue(
										BRF300.getR24_FUJAIRAH() == null ? 0 : BRF300.getR24_FUJAIRAH().intValue());
							}

//////////////////////R25///////////////////////            

							Row R25row = sheet.getRow(32);

							Cell R25cell = R25row.getCell(3);
							if (R25cell != null) {
								R25cell.setCellValue(
										BRF300.getR25_ABU_DHABI() == null ? 0 : BRF300.getR25_ABU_DHABI().intValue());
							}

							Cell R25cell1 = R25row.getCell(4);
							if (R25cell1 != null) {
								R25cell1.setCellValue(BRF300.getR25_WESTERNM_REGION() == null ? 0
										: BRF300.getR25_WESTERNM_REGION().intValue());
							}

							Cell R25cell2 = R25row.getCell(5);
							if (R25cell2 != null) {
								R25cell2.setCellValue(
										BRF300.getR25_AL_AIN() == null ? 0 : BRF300.getR25_AL_AIN().intValue());
							}

							Cell R25cell3 = R25row.getCell(6);
							if (R25cell3 != null) {
								R25cell3.setCellValue(
										BRF300.getR25_ISLAND() == null ? 0 : BRF300.getR25_ISLAND().intValue());
							}

							Cell R25cell4 = R25row.getCell(7);
							if (R25cell4 != null) {
								R25cell4.setCellValue(
										BRF300.getR25_DUBAI() == null ? 0 : BRF300.getR25_DUBAI().intValue());
							}

							Cell R25cell5 = R25row.getCell(8);
							if (R25cell5 != null) {
								R25cell5.setCellValue(
										BRF300.getR25_SHARJAH() == null ? 0 : BRF300.getR25_SHARJAH().intValue());
							}

							Cell R25cell6 = R25row.getCell(9);
							if (R25cell6 != null) {
								R25cell6.setCellValue(
										BRF300.getR25_AJMAN() == null ? 0 : BRF300.getR25_AJMAN().intValue());
							}

							Cell R25cell7 = R25row.getCell(10);
							if (R25cell7 != null) {
								R25cell7.setCellValue(
										BRF300.getR25_RAS_AL() == null ? 0 : BRF300.getR25_RAS_AL().intValue());
							}

							Cell R25cell8 = R25row.getCell(11);
							if (R25cell8 != null) {
								R25cell8.setCellValue(
										BRF300.getR25_UMM_AL() == null ? 0 : BRF300.getR25_UMM_AL().intValue());
							}

							Cell R25cell9 = R25row.getCell(12);
							if (R25cell9 != null) {
								R25cell9.setCellValue(
										BRF300.getR25_FUJAIRAH() == null ? 0 : BRF300.getR25_FUJAIRAH().intValue());
							}

//////////////////////R26///////////////////////            

							Row R26row = sheet.getRow(33);

							Cell R26cell = R26row.getCell(3);
							if (R26cell != null) {
								R26cell.setCellValue(
										BRF300.getR26_ABU_DHABI() == null ? 0 : BRF300.getR26_ABU_DHABI().intValue());
							}

							Cell R26cell1 = R26row.getCell(4);
							if (R26cell1 != null) {
								R26cell1.setCellValue(BRF300.getR26_WESTERNM_REGION() == null ? 0
										: BRF300.getR26_WESTERNM_REGION().intValue());
							}

							Cell R26cell2 = R26row.getCell(5);
							if (R26cell2 != null) {
								R26cell2.setCellValue(
										BRF300.getR26_AL_AIN() == null ? 0 : BRF300.getR26_AL_AIN().intValue());
							}

							Cell R26cell3 = R26row.getCell(6);
							if (R26cell3 != null) {
								R26cell3.setCellValue(
										BRF300.getR26_ISLAND() == null ? 0 : BRF300.getR26_ISLAND().intValue());
							}

							Cell R26cell4 = R26row.getCell(7);
							if (R26cell4 != null) {
								R26cell4.setCellValue(
										BRF300.getR26_DUBAI() == null ? 0 : BRF300.getR26_DUBAI().intValue());
							}

							Cell R26cell5 = R26row.getCell(8);
							if (R26cell5 != null) {
								R26cell5.setCellValue(
										BRF300.getR26_SHARJAH() == null ? 0 : BRF300.getR26_SHARJAH().intValue());
							}

							Cell R26cell6 = R26row.getCell(9);
							if (R26cell6 != null) {
								R26cell6.setCellValue(
										BRF300.getR26_AJMAN() == null ? 0 : BRF300.getR26_AJMAN().intValue());
							}

							Cell R26cell7 = R26row.getCell(10);
							if (R26cell7 != null) {
								R26cell7.setCellValue(
										BRF300.getR26_RAS_AL() == null ? 0 : BRF300.getR26_RAS_AL().intValue());
							}

							Cell R26cell8 = R26row.getCell(11);
							if (R26cell8 != null) {
								R26cell8.setCellValue(
										BRF300.getR26_UMM_AL() == null ? 0 : BRF300.getR26_UMM_AL().intValue());
							}

							Cell R26cell9 = R26row.getCell(12);
							if (R26cell9 != null) {
								R26cell9.setCellValue(
										BRF300.getR26_FUJAIRAH() == null ? 0 : BRF300.getR26_FUJAIRAH().intValue());
							}

//////////////////////R27///////////////////////            

							Row R27row = sheet.getRow(34);

							Cell R27cell = R27row.getCell(3);
							if (R27cell != null) {
								R27cell.setCellValue(
										BRF300.getR27_ABU_DHABI() == null ? 0 : BRF300.getR27_ABU_DHABI().intValue());
							}

							Cell R27cell1 = R27row.getCell(4);
							if (R27cell1 != null) {
								R27cell1.setCellValue(BRF300.getR27_WESTERNM_REGION() == null ? 0
										: BRF300.getR27_WESTERNM_REGION().intValue());
							}

							Cell R27cell2 = R27row.getCell(5);
							if (R27cell2 != null) {
								R27cell2.setCellValue(
										BRF300.getR27_AL_AIN() == null ? 0 : BRF300.getR27_AL_AIN().intValue());
							}

							Cell R27cell3 = R27row.getCell(6);
							if (R27cell3 != null) {
								R27cell3.setCellValue(
										BRF300.getR27_ISLAND() == null ? 0 : BRF300.getR27_ISLAND().intValue());
							}

							Cell R27cell4 = R27row.getCell(7);
							if (R27cell4 != null) {
								R27cell4.setCellValue(
										BRF300.getR27_DUBAI() == null ? 0 : BRF300.getR27_DUBAI().intValue());
							}

							Cell R27cell5 = R27row.getCell(8);
							if (R27cell5 != null) {
								R27cell5.setCellValue(
										BRF300.getR27_SHARJAH() == null ? 0 : BRF300.getR27_SHARJAH().intValue());
							}

							Cell R27cell6 = R27row.getCell(9);
							if (R27cell6 != null) {
								R27cell6.setCellValue(
										BRF300.getR27_AJMAN() == null ? 0 : BRF300.getR27_AJMAN().intValue());
							}

							Cell R27cell7 = R27row.getCell(10);
							if (R27cell7 != null) {
								R27cell7.setCellValue(
										BRF300.getR27_RAS_AL() == null ? 0 : BRF300.getR27_RAS_AL().intValue());
							}

							Cell R27cell8 = R27row.getCell(11);
							if (R27cell8 != null) {
								R27cell8.setCellValue(
										BRF300.getR27_UMM_AL() == null ? 0 : BRF300.getR27_UMM_AL().intValue());
							}

							Cell R27cell9 = R27row.getCell(12);
							if (R27cell9 != null) {
								R27cell9.setCellValue(
										BRF300.getR27_FUJAIRAH() == null ? 0 : BRF300.getR27_FUJAIRAH().intValue());
							}

//////////////////////R28///////////////////////            

							Row R28row = sheet.getRow(35);

							Cell R28cell = R28row.getCell(3);
							if (R28cell != null) {
								R28cell.setCellValue(
										BRF300.getR28_ABU_DHABI() == null ? 0 : BRF300.getR28_ABU_DHABI().intValue());
							}

							Cell R28cell1 = R28row.getCell(4);
							if (R28cell1 != null) {
								R28cell1.setCellValue(BRF300.getR28_WESTERNM_REGION() == null ? 0
										: BRF300.getR28_WESTERNM_REGION().intValue());
							}

							Cell R28cell2 = R28row.getCell(5);
							if (R28cell2 != null) {
								R28cell2.setCellValue(
										BRF300.getR28_AL_AIN() == null ? 0 : BRF300.getR28_AL_AIN().intValue());
							}

							Cell R28cell3 = R28row.getCell(6);
							if (R28cell3 != null) {
								R28cell3.setCellValue(
										BRF300.getR28_ISLAND() == null ? 0 : BRF300.getR28_ISLAND().intValue());
							}

							Cell R28cell4 = R28row.getCell(7);
							if (R28cell4 != null) {
								R28cell4.setCellValue(
										BRF300.getR28_DUBAI() == null ? 0 : BRF300.getR28_DUBAI().intValue());
							}

							Cell R28cell5 = R28row.getCell(8);
							if (R28cell5 != null) {
								R28cell5.setCellValue(
										BRF300.getR28_SHARJAH() == null ? 0 : BRF300.getR28_SHARJAH().intValue());
							}

							Cell R28cell6 = R28row.getCell(9);
							if (R28cell6 != null) {
								R28cell6.setCellValue(
										BRF300.getR28_AJMAN() == null ? 0 : BRF300.getR28_AJMAN().intValue());
							}

							Cell R28cell7 = R28row.getCell(10);
							if (R28cell7 != null) {
								R28cell7.setCellValue(
										BRF300.getR28_RAS_AL() == null ? 0 : BRF300.getR28_RAS_AL().intValue());
							}

							Cell R28cell8 = R28row.getCell(11);
							if (R28cell8 != null) {
								R28cell8.setCellValue(
										BRF300.getR28_UMM_AL() == null ? 0 : BRF300.getR28_UMM_AL().intValue());
							}

							Cell R28cell9 = R28row.getCell(12);
							if (R28cell9 != null) {
								R28cell9.setCellValue(
										BRF300.getR28_FUJAIRAH() == null ? 0 : BRF300.getR28_FUJAIRAH().intValue());
							}

//////////////////////R29///////////////////////            

							Row R29row = sheet.getRow(36);

							Cell R29cell = R29row.getCell(3);
							if (R29cell != null) {
								R29cell.setCellValue(
										BRF300.getR29_ABU_DHABI() == null ? 0 : BRF300.getR29_ABU_DHABI().intValue());
							}

							Cell R29cell1 = R29row.getCell(4);
							if (R29cell1 != null) {
								R29cell1.setCellValue(BRF300.getR29_WESTERNM_REGION() == null ? 0
										: BRF300.getR29_WESTERNM_REGION().intValue());
							}

							Cell R29cell2 = R29row.getCell(5);
							if (R29cell2 != null) {
								R29cell2.setCellValue(
										BRF300.getR29_AL_AIN() == null ? 0 : BRF300.getR29_AL_AIN().intValue());
							}

							Cell R29cell3 = R29row.getCell(6);
							if (R29cell3 != null) {
								R29cell3.setCellValue(
										BRF300.getR29_ISLAND() == null ? 0 : BRF300.getR29_ISLAND().intValue());
							}

							Cell R29cell4 = R29row.getCell(7);
							if (R29cell4 != null) {
								R29cell4.setCellValue(
										BRF300.getR29_DUBAI() == null ? 0 : BRF300.getR29_DUBAI().intValue());
							}

							Cell R29cell5 = R29row.getCell(8);
							if (R29cell5 != null) {
								R29cell5.setCellValue(
										BRF300.getR29_SHARJAH() == null ? 0 : BRF300.getR29_SHARJAH().intValue());
							}

							Cell R29cell6 = R29row.getCell(9);
							if (R29cell6 != null) {
								R29cell6.setCellValue(
										BRF300.getR29_AJMAN() == null ? 0 : BRF300.getR29_AJMAN().intValue());
							}

							Cell R29cell7 = R29row.getCell(10);
							if (R29cell7 != null) {
								R29cell7.setCellValue(
										BRF300.getR29_RAS_AL() == null ? 0 : BRF300.getR29_RAS_AL().intValue());
							}

							Cell R29cell8 = R29row.getCell(11);
							if (R29cell8 != null) {
								R29cell8.setCellValue(
										BRF300.getR29_UMM_AL() == null ? 0 : BRF300.getR29_UMM_AL().intValue());
							}

							Cell R29cell9 = R29row.getCell(12);
							if (R29cell9 != null) {
								R29cell9.setCellValue(
										BRF300.getR29_FUJAIRAH() == null ? 0 : BRF300.getR29_FUJAIRAH().intValue());
							}

//////////////////////R30///////////////////////            

							Row R30row = sheet.getRow(37);

							Cell R30cell = R30row.getCell(3);
							if (R30cell != null) {
								R30cell.setCellValue(
										BRF300.getR30_ABU_DHABI() == null ? 0 : BRF300.getR30_ABU_DHABI().intValue());
							}

							Cell R30cell1 = R30row.getCell(4);
							if (R30cell1 != null) {
								R30cell1.setCellValue(BRF300.getR30_WESTERNM_REGION() == null ? 0
										: BRF300.getR30_WESTERNM_REGION().intValue());
							}

							Cell R30cell2 = R30row.getCell(5);
							if (R30cell2 != null) {
								R30cell2.setCellValue(
										BRF300.getR30_AL_AIN() == null ? 0 : BRF300.getR30_AL_AIN().intValue());
							}

							Cell R30cell3 = R30row.getCell(6);
							if (R30cell3 != null) {
								R30cell3.setCellValue(
										BRF300.getR30_ISLAND() == null ? 0 : BRF300.getR30_ISLAND().intValue());
							}

							Cell R30cell4 = R30row.getCell(7);
							if (R30cell4 != null) {
								R30cell4.setCellValue(
										BRF300.getR30_DUBAI() == null ? 0 : BRF300.getR30_DUBAI().intValue());
							}

							Cell R30cell5 = R30row.getCell(8);
							if (R30cell5 != null) {
								R30cell5.setCellValue(
										BRF300.getR30_SHARJAH() == null ? 0 : BRF300.getR30_SHARJAH().intValue());
							}

							Cell R30cell6 = R30row.getCell(9);
							if (R30cell6 != null) {
								R30cell6.setCellValue(
										BRF300.getR30_AJMAN() == null ? 0 : BRF300.getR30_AJMAN().intValue());
							}

							Cell R30cell7 = R30row.getCell(10);
							if (R30cell7 != null) {
								R30cell7.setCellValue(
										BRF300.getR30_RAS_AL() == null ? 0 : BRF300.getR30_RAS_AL().intValue());
							}

							Cell R30cell8 = R30row.getCell(11);
							if (R30cell8 != null) {
								R30cell8.setCellValue(
										BRF300.getR30_UMM_AL() == null ? 0 : BRF300.getR30_UMM_AL().intValue());
							}

							Cell R30cell9 = R30row.getCell(12);
							if (R30cell9 != null) {
								R30cell9.setCellValue(
										BRF300.getR30_FUJAIRAH() == null ? 0 : BRF300.getR30_FUJAIRAH().intValue());
							}

//////////////////////R31///////////////////////            

							Row R31row = sheet.getRow(38);

							Cell R31cell = R31row.getCell(3);
							if (R31cell != null) {
								R31cell.setCellValue(
										BRF300.getR31_ABU_DHABI() == null ? 0 : BRF300.getR31_ABU_DHABI().intValue());
							}

							Cell R31cell1 = R31row.getCell(4);
							if (R31cell1 != null) {
								R31cell1.setCellValue(BRF300.getR31_WESTERNM_REGION() == null ? 0
										: BRF300.getR31_WESTERNM_REGION().intValue());
							}

							Cell R31cell2 = R31row.getCell(5);
							if (R31cell2 != null) {
								R31cell2.setCellValue(
										BRF300.getR31_AL_AIN() == null ? 0 : BRF300.getR31_AL_AIN().intValue());
							}

							Cell R31cell3 = R31row.getCell(6);
							if (R31cell3 != null) {
								R31cell3.setCellValue(
										BRF300.getR31_ISLAND() == null ? 0 : BRF300.getR31_ISLAND().intValue());
							}

							Cell R31cell4 = R31row.getCell(7);
							if (R31cell4 != null) {
								R31cell4.setCellValue(
										BRF300.getR31_DUBAI() == null ? 0 : BRF300.getR31_DUBAI().intValue());
							}

							Cell R31cell5 = R31row.getCell(8);
							if (R31cell5 != null) {
								R31cell5.setCellValue(
										BRF300.getR31_SHARJAH() == null ? 0 : BRF300.getR31_SHARJAH().intValue());
							}

							Cell R31cell6 = R31row.getCell(9);
							if (R31cell6 != null) {
								R31cell6.setCellValue(
										BRF300.getR31_AJMAN() == null ? 0 : BRF300.getR31_AJMAN().intValue());
							}

							Cell R31cell7 = R31row.getCell(10);
							if (R31cell7 != null) {
								R31cell7.setCellValue(
										BRF300.getR31_RAS_AL() == null ? 0 : BRF300.getR31_RAS_AL().intValue());
							}

							Cell R31cell8 = R31row.getCell(11);
							if (R31cell8 != null) {
								R31cell8.setCellValue(
										BRF300.getR31_UMM_AL() == null ? 0 : BRF300.getR31_UMM_AL().intValue());
							}

							Cell R31cell9 = R31row.getCell(12);
							if (R31cell9 != null) {
								R31cell9.setCellValue(
										BRF300.getR31_FUJAIRAH() == null ? 0 : BRF300.getR31_FUJAIRAH().intValue());
							}

//////////////////////R32///////////////////////            

							Row R32row = sheet.getRow(39);

							Cell R32cell = R32row.getCell(3);
							if (R32cell != null) {
								R32cell.setCellValue(
										BRF300.getR32_ABU_DHABI() == null ? 0 : BRF300.getR32_ABU_DHABI().intValue());
							}

							Cell R32cell1 = R32row.getCell(4);
							if (R32cell1 != null) {
								R32cell1.setCellValue(BRF300.getR32_WESTERNM_REGION() == null ? 0
										: BRF300.getR32_WESTERNM_REGION().intValue());
							}

							Cell R32cell2 = R32row.getCell(5);
							if (R32cell2 != null) {
								R32cell2.setCellValue(
										BRF300.getR32_AL_AIN() == null ? 0 : BRF300.getR32_AL_AIN().intValue());
							}

							Cell R32cell3 = R32row.getCell(6);
							if (R32cell3 != null) {
								R32cell3.setCellValue(
										BRF300.getR32_ISLAND() == null ? 0 : BRF300.getR32_ISLAND().intValue());
							}

							Cell R32cell4 = R32row.getCell(7);
							if (R32cell4 != null) {
								R32cell4.setCellValue(
										BRF300.getR32_DUBAI() == null ? 0 : BRF300.getR32_DUBAI().intValue());
							}

							Cell R32cell5 = R32row.getCell(8);
							if (R32cell5 != null) {
								R32cell5.setCellValue(
										BRF300.getR32_SHARJAH() == null ? 0 : BRF300.getR32_SHARJAH().intValue());
							}

							Cell R32cell6 = R32row.getCell(9);
							if (R32cell6 != null) {
								R32cell6.setCellValue(
										BRF300.getR32_AJMAN() == null ? 0 : BRF300.getR32_AJMAN().intValue());
							}

							Cell R32cell7 = R32row.getCell(10);
							if (R32cell7 != null) {
								R32cell7.setCellValue(
										BRF300.getR32_RAS_AL() == null ? 0 : BRF300.getR32_RAS_AL().intValue());
							}

							Cell R32cell8 = R32row.getCell(11);
							if (R32cell8 != null) {
								R32cell8.setCellValue(
										BRF300.getR32_UMM_AL() == null ? 0 : BRF300.getR32_UMM_AL().intValue());
							}

							Cell R32cell9 = R32row.getCell(12);
							if (R32cell9 != null) {
								R32cell9.setCellValue(
										BRF300.getR32_FUJAIRAH() == null ? 0 : BRF300.getR32_FUJAIRAH().intValue());
							}

//////////////////////R33///////////////////////            

							Row R33row = sheet.getRow(40);

							Cell R33cell = R33row.getCell(3);
							if (R33cell != null) {
								R33cell.setCellValue(
										BRF300.getR33_ABU_DHABI() == null ? 0 : BRF300.getR33_ABU_DHABI().intValue());
							}

							Cell R33cell1 = R33row.getCell(4);
							if (R33cell1 != null) {
								R33cell1.setCellValue(BRF300.getR33_WESTERNM_REGION() == null ? 0
										: BRF300.getR33_WESTERNM_REGION().intValue());
							}

							Cell R33cell2 = R33row.getCell(5);
							if (R33cell2 != null) {
								R33cell2.setCellValue(
										BRF300.getR33_AL_AIN() == null ? 0 : BRF300.getR33_AL_AIN().intValue());
							}

							Cell R33cell3 = R33row.getCell(6);
							if (R33cell3 != null) {
								R33cell3.setCellValue(
										BRF300.getR33_ISLAND() == null ? 0 : BRF300.getR33_ISLAND().intValue());
							}

							Cell R33cell4 = R33row.getCell(7);
							if (R33cell4 != null) {
								R33cell4.setCellValue(
										BRF300.getR33_DUBAI() == null ? 0 : BRF300.getR33_DUBAI().intValue());
							}

							Cell R33cell5 = R33row.getCell(8);
							if (R33cell5 != null) {
								R33cell5.setCellValue(
										BRF300.getR33_SHARJAH() == null ? 0 : BRF300.getR33_SHARJAH().intValue());
							}

							Cell R33cell6 = R33row.getCell(9);
							if (R33cell6 != null) {
								R33cell6.setCellValue(
										BRF300.getR33_AJMAN() == null ? 0 : BRF300.getR33_AJMAN().intValue());
							}

							Cell R33cell7 = R33row.getCell(10);
							if (R33cell7 != null) {
								R33cell7.setCellValue(
										BRF300.getR33_RAS_AL() == null ? 0 : BRF300.getR33_RAS_AL().intValue());
							}

							Cell R33cell8 = R33row.getCell(11);
							if (R33cell8 != null) {
								R33cell8.setCellValue(
										BRF300.getR33_UMM_AL() == null ? 0 : BRF300.getR33_UMM_AL().intValue());
							}

							Cell R33cell9 = R33row.getCell(12);
							if (R33cell9 != null) {
								R33cell9.setCellValue(
										BRF300.getR33_FUJAIRAH() == null ? 0 : BRF300.getR33_FUJAIRAH().intValue());
							}

//////////////////////R34///////////////////////            

							Row R34row = sheet.getRow(41);

							Cell R34cell = R34row.getCell(3);
							if (R34cell != null) {
								R34cell.setCellValue(
										BRF300.getR34_ABU_DHABI() == null ? 0 : BRF300.getR34_ABU_DHABI().intValue());
							}

							Cell R34cell1 = R34row.getCell(4);
							if (R34cell1 != null) {
								R34cell1.setCellValue(BRF300.getR34_WESTERNM_REGION() == null ? 0
										: BRF300.getR34_WESTERNM_REGION().intValue());
							}

							Cell R34cell2 = R34row.getCell(5);
							if (R34cell2 != null) {
								R34cell2.setCellValue(
										BRF300.getR34_AL_AIN() == null ? 0 : BRF300.getR34_AL_AIN().intValue());
							}

							Cell R34cell3 = R34row.getCell(6);
							if (R34cell3 != null) {
								R34cell3.setCellValue(
										BRF300.getR34_ISLAND() == null ? 0 : BRF300.getR34_ISLAND().intValue());
							}

							Cell R34cell4 = R34row.getCell(7);
							if (R34cell4 != null) {
								R34cell4.setCellValue(
										BRF300.getR34_DUBAI() == null ? 0 : BRF300.getR34_DUBAI().intValue());
							}

							Cell R34cell5 = R34row.getCell(8);
							if (R34cell5 != null) {
								R34cell5.setCellValue(
										BRF300.getR34_SHARJAH() == null ? 0 : BRF300.getR34_SHARJAH().intValue());
							}

							Cell R34cell6 = R34row.getCell(9);
							if (R34cell6 != null) {
								R34cell6.setCellValue(
										BRF300.getR34_AJMAN() == null ? 0 : BRF300.getR34_AJMAN().intValue());
							}

							Cell R34cell7 = R34row.getCell(10);
							if (R34cell7 != null) {
								R34cell7.setCellValue(
										BRF300.getR34_RAS_AL() == null ? 0 : BRF300.getR34_RAS_AL().intValue());
							}

							Cell R34cell8 = R34row.getCell(11);
							if (R34cell8 != null) {
								R34cell8.setCellValue(
										BRF300.getR34_UMM_AL() == null ? 0 : BRF300.getR34_UMM_AL().intValue());
							}

							Cell R34cell9 = R34row.getCell(12);
							if (R34cell9 != null) {
								R34cell9.setCellValue(
										BRF300.getR34_FUJAIRAH() == null ? 0 : BRF300.getR34_FUJAIRAH().intValue());
							}

//////////////////////R35///////////////////////            

							Row R35row = sheet.getRow(42);

							Cell R35cell = R35row.getCell(3);
							if (R35cell != null) {
								R35cell.setCellValue(
										BRF300.getR35_ABU_DHABI() == null ? 0 : BRF300.getR35_ABU_DHABI().intValue());
							}

							Cell R35cell1 = R35row.getCell(4);
							if (R35cell1 != null) {
								R35cell1.setCellValue(BRF300.getR35_WESTERNM_REGION() == null ? 0
										: BRF300.getR35_WESTERNM_REGION().intValue());
							}

							Cell R35cell2 = R35row.getCell(5);
							if (R35cell2 != null) {
								R35cell2.setCellValue(
										BRF300.getR35_AL_AIN() == null ? 0 : BRF300.getR35_AL_AIN().intValue());
							}

							Cell R35cell3 = R35row.getCell(6);
							if (R35cell3 != null) {
								R35cell3.setCellValue(
										BRF300.getR35_ISLAND() == null ? 0 : BRF300.getR35_ISLAND().intValue());
							}

							Cell R35cell4 = R35row.getCell(7);
							if (R35cell4 != null) {
								R35cell4.setCellValue(
										BRF300.getR35_DUBAI() == null ? 0 : BRF300.getR35_DUBAI().intValue());
							}

							Cell R35cell5 = R35row.getCell(8);
							if (R35cell5 != null) {
								R35cell5.setCellValue(
										BRF300.getR35_SHARJAH() == null ? 0 : BRF300.getR35_SHARJAH().intValue());
							}

							Cell R35cell6 = R35row.getCell(9);
							if (R35cell6 != null) {
								R35cell6.setCellValue(
										BRF300.getR35_AJMAN() == null ? 0 : BRF300.getR35_AJMAN().intValue());
							}

							Cell R35cell7 = R35row.getCell(10);
							if (R35cell7 != null) {
								R35cell7.setCellValue(
										BRF300.getR35_RAS_AL() == null ? 0 : BRF300.getR35_RAS_AL().intValue());
							}

							Cell R35cell8 = R35row.getCell(11);
							if (R35cell8 != null) {
								R35cell8.setCellValue(
										BRF300.getR35_UMM_AL() == null ? 0 : BRF300.getR35_UMM_AL().intValue());
							}

							Cell R35cell9 = R35row.getCell(12);
							if (R35cell9 != null) {
								R35cell9.setCellValue(
										BRF300.getR35_FUJAIRAH() == null ? 0 : BRF300.getR35_FUJAIRAH().intValue());
							}

//////////////////////R36///////////////////////            

							Row R36row = sheet.getRow(43);

							Cell R36cell = R36row.getCell(3);
							if (R36cell != null) {
								R36cell.setCellValue(
										BRF300.getR36_ABU_DHABI() == null ? 0 : BRF300.getR36_ABU_DHABI().intValue());
							}

							Cell R36cell1 = R36row.getCell(4);
							if (R36cell1 != null) {
								R36cell1.setCellValue(BRF300.getR36_WESTERNM_REGION() == null ? 0
										: BRF300.getR36_WESTERNM_REGION().intValue());
							}

							Cell R36cell2 = R36row.getCell(5);
							if (R36cell2 != null) {
								R36cell2.setCellValue(
										BRF300.getR36_AL_AIN() == null ? 0 : BRF300.getR36_AL_AIN().intValue());
							}

							Cell R36cell3 = R36row.getCell(6);
							if (R36cell3 != null) {
								R36cell3.setCellValue(
										BRF300.getR36_ISLAND() == null ? 0 : BRF300.getR36_ISLAND().intValue());
							}

							Cell R36cell4 = R36row.getCell(7);
							if (R36cell4 != null) {
								R36cell4.setCellValue(
										BRF300.getR36_DUBAI() == null ? 0 : BRF300.getR36_DUBAI().intValue());
							}

							Cell R36cell5 = R36row.getCell(8);
							if (R36cell5 != null) {
								R36cell5.setCellValue(
										BRF300.getR36_SHARJAH() == null ? 0 : BRF300.getR36_SHARJAH().intValue());
							}

							Cell R36cell6 = R36row.getCell(9);
							if (R36cell6 != null) {
								R36cell6.setCellValue(
										BRF300.getR36_AJMAN() == null ? 0 : BRF300.getR36_AJMAN().intValue());
							}

							Cell R36cell7 = R36row.getCell(10);
							if (R36cell7 != null) {
								R36cell7.setCellValue(
										BRF300.getR36_RAS_AL() == null ? 0 : BRF300.getR36_RAS_AL().intValue());
							}

							Cell R36cell8 = R36row.getCell(11);
							if (R36cell8 != null) {
								R36cell8.setCellValue(
										BRF300.getR36_UMM_AL() == null ? 0 : BRF300.getR36_UMM_AL().intValue());
							}

							Cell R36cell9 = R36row.getCell(12);
							if (R36cell9 != null) {
								R36cell9.setCellValue(
										BRF300.getR36_FUJAIRAH() == null ? 0 : BRF300.getR36_FUJAIRAH().intValue());
							}

//////////////////////R37///////////////////////            

							Row R37row = sheet.getRow(44);

							Cell R37cell = R37row.getCell(3);
							if (R37cell != null) {
								R37cell.setCellValue(
										BRF300.getR37_ABU_DHABI() == null ? 0 : BRF300.getR37_ABU_DHABI().intValue());
							}

							Cell R37cell1 = R37row.getCell(4);
							if (R37cell1 != null) {
								R37cell1.setCellValue(BRF300.getR37_WESTERNM_REGION() == null ? 0
										: BRF300.getR37_WESTERNM_REGION().intValue());
							}

							Cell R37cell2 = R37row.getCell(5);
							if (R37cell2 != null) {
								R37cell2.setCellValue(
										BRF300.getR37_AL_AIN() == null ? 0 : BRF300.getR37_AL_AIN().intValue());
							}

							Cell R37cell3 = R37row.getCell(6);
							if (R37cell3 != null) {
								R37cell3.setCellValue(
										BRF300.getR37_ISLAND() == null ? 0 : BRF300.getR37_ISLAND().intValue());
							}

							Cell R37cell4 = R37row.getCell(7);
							if (R37cell4 != null) {
								R37cell4.setCellValue(
										BRF300.getR37_DUBAI() == null ? 0 : BRF300.getR37_DUBAI().intValue());
							}

							Cell R37cell5 = R37row.getCell(8);
							if (R37cell5 != null) {
								R37cell5.setCellValue(
										BRF300.getR37_SHARJAH() == null ? 0 : BRF300.getR37_SHARJAH().intValue());
							}

							Cell R37cell6 = R37row.getCell(9);
							if (R37cell6 != null) {
								R37cell6.setCellValue(
										BRF300.getR37_AJMAN() == null ? 0 : BRF300.getR37_AJMAN().intValue());
							}

							Cell R37cell7 = R37row.getCell(10);
							if (R37cell7 != null) {
								R37cell7.setCellValue(
										BRF300.getR37_RAS_AL() == null ? 0 : BRF300.getR37_RAS_AL().intValue());
							}

							Cell R37cell8 = R37row.getCell(11);
							if (R37cell8 != null) {
								R37cell8.setCellValue(
										BRF300.getR37_UMM_AL() == null ? 0 : BRF300.getR37_UMM_AL().intValue());
							}

							Cell R37cell9 = R37row.getCell(12);
							if (R37cell9 != null) {
								R37cell9.setCellValue(
										BRF300.getR37_FUJAIRAH() == null ? 0 : BRF300.getR37_FUJAIRAH().intValue());
							}

//////////////////////R38///////////////////////            

							Row R38row = sheet.getRow(45);

							Cell R38cell = R38row.getCell(3);
							if (R38cell != null) {
								R38cell.setCellValue(
										BRF300.getR38_ABU_DHABI() == null ? 0 : BRF300.getR38_ABU_DHABI().intValue());
							}

							Cell R38cell1 = R38row.getCell(4);
							if (R38cell1 != null) {
								R38cell1.setCellValue(BRF300.getR38_WESTERNM_REGION() == null ? 0
										: BRF300.getR38_WESTERNM_REGION().intValue());
							}

							Cell R38cell2 = R38row.getCell(5);
							if (R38cell2 != null) {
								R38cell2.setCellValue(
										BRF300.getR38_AL_AIN() == null ? 0 : BRF300.getR38_AL_AIN().intValue());
							}

							Cell R38cell3 = R38row.getCell(6);
							if (R38cell3 != null) {
								R38cell3.setCellValue(
										BRF300.getR38_ISLAND() == null ? 0 : BRF300.getR38_ISLAND().intValue());
							}

							Cell R38cell4 = R38row.getCell(7);
							if (R38cell4 != null) {
								R38cell4.setCellValue(
										BRF300.getR38_DUBAI() == null ? 0 : BRF300.getR38_DUBAI().intValue());
							}

							Cell R38cell5 = R38row.getCell(8);
							if (R38cell5 != null) {
								R38cell5.setCellValue(
										BRF300.getR38_SHARJAH() == null ? 0 : BRF300.getR38_SHARJAH().intValue());
							}

							Cell R38cell6 = R38row.getCell(9);
							if (R38cell6 != null) {
								R38cell6.setCellValue(
										BRF300.getR38_AJMAN() == null ? 0 : BRF300.getR38_AJMAN().intValue());
							}

							Cell R38cell7 = R38row.getCell(10);
							if (R38cell7 != null) {
								R38cell7.setCellValue(
										BRF300.getR38_RAS_AL() == null ? 0 : BRF300.getR38_RAS_AL().intValue());
							}

							Cell R38cell8 = R38row.getCell(11);
							if (R38cell8 != null) {
								R38cell8.setCellValue(
										BRF300.getR38_UMM_AL() == null ? 0 : BRF300.getR38_UMM_AL().intValue());
							}

							Cell R38cell9 = R38row.getCell(12);
							if (R38cell9 != null) {
								R38cell9.setCellValue(
										BRF300.getR38_FUJAIRAH() == null ? 0 : BRF300.getR38_FUJAIRAH().intValue());
							}

//////////////////////R39///////////////////////            

							Row R39row = sheet.getRow(46);

							Cell R39cell = R39row.getCell(3);
							if (R39cell != null) {
								R39cell.setCellValue(
										BRF300.getR39_ABU_DHABI() == null ? 0 : BRF300.getR39_ABU_DHABI().intValue());
							}

							Cell R39cell1 = R39row.getCell(4);
							if (R39cell1 != null) {
								R39cell1.setCellValue(BRF300.getR39_WESTERNM_REGION() == null ? 0
										: BRF300.getR39_WESTERNM_REGION().intValue());
							}

							Cell R39cell2 = R39row.getCell(5);
							if (R39cell2 != null) {
								R39cell2.setCellValue(
										BRF300.getR39_AL_AIN() == null ? 0 : BRF300.getR39_AL_AIN().intValue());
							}

							Cell R39cell3 = R39row.getCell(6);
							if (R39cell3 != null) {
								R39cell3.setCellValue(
										BRF300.getR39_ISLAND() == null ? 0 : BRF300.getR39_ISLAND().intValue());
							}

							Cell R39cell4 = R39row.getCell(7);
							if (R39cell4 != null) {
								R39cell4.setCellValue(
										BRF300.getR39_DUBAI() == null ? 0 : BRF300.getR39_DUBAI().intValue());
							}

							Cell R39cell5 = R39row.getCell(8);
							if (R39cell5 != null) {
								R39cell5.setCellValue(
										BRF300.getR39_SHARJAH() == null ? 0 : BRF300.getR39_SHARJAH().intValue());
							}

							Cell R39cell6 = R39row.getCell(9);
							if (R39cell6 != null) {
								R39cell6.setCellValue(
										BRF300.getR39_AJMAN() == null ? 0 : BRF300.getR39_AJMAN().intValue());
							}

							Cell R39cell7 = R39row.getCell(10);
							if (R39cell7 != null) {
								R39cell7.setCellValue(
										BRF300.getR39_RAS_AL() == null ? 0 : BRF300.getR39_RAS_AL().intValue());
							}

							Cell R39cell8 = R39row.getCell(11);
							if (R39cell8 != null) {
								R39cell8.setCellValue(
										BRF300.getR39_UMM_AL() == null ? 0 : BRF300.getR39_UMM_AL().intValue());
							}

							Cell R39cell9 = R39row.getCell(12);
							if (R39cell9 != null) {
								R39cell9.setCellValue(
										BRF300.getR39_FUJAIRAH() == null ? 0 : BRF300.getR39_FUJAIRAH().intValue());
							}

//////////////////////R40///////////////////////            

							Row R40row = sheet.getRow(47);

							Cell R40cell = R40row.getCell(3);
							if (R40cell != null) {
								R40cell.setCellValue(
										BRF300.getR40_ABU_DHABI() == null ? 0 : BRF300.getR40_ABU_DHABI().intValue());
							}

							Cell R40cell1 = R40row.getCell(4);
							if (R40cell1 != null) {
								R40cell1.setCellValue(BRF300.getR40_WESTERNM_REGION() == null ? 0
										: BRF300.getR40_WESTERNM_REGION().intValue());
							}

							Cell R40cell2 = R40row.getCell(5);
							if (R40cell2 != null) {
								R40cell2.setCellValue(
										BRF300.getR40_AL_AIN() == null ? 0 : BRF300.getR40_AL_AIN().intValue());
							}

							Cell R40cell3 = R40row.getCell(6);
							if (R40cell3 != null) {
								R40cell3.setCellValue(
										BRF300.getR40_ISLAND() == null ? 0 : BRF300.getR40_ISLAND().intValue());
							}

							Cell R40cell4 = R40row.getCell(7);
							if (R40cell4 != null) {
								R40cell4.setCellValue(
										BRF300.getR40_DUBAI() == null ? 0 : BRF300.getR40_DUBAI().intValue());
							}

							Cell R40cell5 = R40row.getCell(8);
							if (R40cell5 != null) {
								R40cell5.setCellValue(
										BRF300.getR40_SHARJAH() == null ? 0 : BRF300.getR40_SHARJAH().intValue());
							}

							Cell R40cell6 = R40row.getCell(9);
							if (R40cell6 != null) {
								R40cell6.setCellValue(
										BRF300.getR40_AJMAN() == null ? 0 : BRF300.getR40_AJMAN().intValue());
							}

							Cell R40cell7 = R40row.getCell(10);
							if (R40cell7 != null) {
								R40cell7.setCellValue(
										BRF300.getR40_RAS_AL() == null ? 0 : BRF300.getR40_RAS_AL().intValue());
							}

							Cell R40cell8 = R40row.getCell(11);
							if (R40cell8 != null) {
								R40cell8.setCellValue(
										BRF300.getR40_UMM_AL() == null ? 0 : BRF300.getR40_UMM_AL().intValue());
							}

							Cell R40cell9 = R40row.getCell(12);
							if (R40cell9 != null) {
								R40cell9.setCellValue(
										BRF300.getR40_FUJAIRAH() == null ? 0 : BRF300.getR40_FUJAIRAH().intValue());
							}

//////////////////////R41///////////////////////            

							Row R41row = sheet.getRow(48);

							Cell R41cell = R41row.getCell(3);
							if (R41cell != null) {
								R41cell.setCellValue(
										BRF300.getR41_ABU_DHABI() == null ? 0 : BRF300.getR41_ABU_DHABI().intValue());
							}

							Cell R41cell1 = R41row.getCell(4);
							if (R41cell1 != null) {
								R41cell1.setCellValue(BRF300.getR41_WESTERNM_REGION() == null ? 0
										: BRF300.getR41_WESTERNM_REGION().intValue());
							}

							Cell R41cell2 = R41row.getCell(5);
							if (R41cell2 != null) {
								R41cell2.setCellValue(
										BRF300.getR41_AL_AIN() == null ? 0 : BRF300.getR41_AL_AIN().intValue());
							}

							Cell R41cell3 = R41row.getCell(6);
							if (R41cell3 != null) {
								R41cell3.setCellValue(
										BRF300.getR41_ISLAND() == null ? 0 : BRF300.getR41_ISLAND().intValue());
							}

							Cell R41cell4 = R41row.getCell(7);
							if (R41cell4 != null) {
								R41cell4.setCellValue(
										BRF300.getR41_DUBAI() == null ? 0 : BRF300.getR41_DUBAI().intValue());
							}

							Cell R41cell5 = R41row.getCell(8);
							if (R41cell5 != null) {
								R41cell5.setCellValue(
										BRF300.getR41_SHARJAH() == null ? 0 : BRF300.getR41_SHARJAH().intValue());
							}

							Cell R41cell6 = R41row.getCell(9);
							if (R41cell6 != null) {
								R41cell6.setCellValue(
										BRF300.getR41_AJMAN() == null ? 0 : BRF300.getR41_AJMAN().intValue());
							}

							Cell R41cell7 = R41row.getCell(10);
							if (R41cell7 != null) {
								R41cell7.setCellValue(
										BRF300.getR41_RAS_AL() == null ? 0 : BRF300.getR41_RAS_AL().intValue());
							}

							Cell R41cell8 = R41row.getCell(11);
							if (R41cell8 != null) {
								R41cell8.setCellValue(
										BRF300.getR41_UMM_AL() == null ? 0 : BRF300.getR41_UMM_AL().intValue());
							}

							Cell R41cell9 = R41row.getCell(12);
							if (R41cell9 != null) {
								R41cell9.setCellValue(
										BRF300.getR41_FUJAIRAH() == null ? 0 : BRF300.getR41_FUJAIRAH().intValue());
							}

//////////////////////R42///////////////////////            

							Row R42row = sheet.getRow(49);

							Cell R42cell = R42row.getCell(3);
							if (R42cell != null) {
								R42cell.setCellValue(
										BRF300.getR42_ABU_DHABI() == null ? 0 : BRF300.getR42_ABU_DHABI().intValue());
							}

							Cell R42cell1 = R42row.getCell(4);
							if (R42cell1 != null) {
								R42cell1.setCellValue(BRF300.getR42_WESTERNM_REGION() == null ? 0
										: BRF300.getR42_WESTERNM_REGION().intValue());
							}

							Cell R42cell2 = R42row.getCell(5);
							if (R42cell2 != null) {
								R42cell2.setCellValue(
										BRF300.getR42_AL_AIN() == null ? 0 : BRF300.getR42_AL_AIN().intValue());
							}

							Cell R42cell3 = R42row.getCell(6);
							if (R42cell3 != null) {
								R42cell3.setCellValue(
										BRF300.getR42_ISLAND() == null ? 0 : BRF300.getR42_ISLAND().intValue());
							}

							Cell R42cell4 = R42row.getCell(7);
							if (R42cell4 != null) {
								R42cell4.setCellValue(
										BRF300.getR42_DUBAI() == null ? 0 : BRF300.getR42_DUBAI().intValue());
							}

							Cell R42cell5 = R42row.getCell(8);
							if (R42cell5 != null) {
								R42cell5.setCellValue(
										BRF300.getR42_SHARJAH() == null ? 0 : BRF300.getR42_SHARJAH().intValue());
							}

							Cell R42cell6 = R42row.getCell(9);
							if (R42cell6 != null) {
								R42cell6.setCellValue(
										BRF300.getR42_AJMAN() == null ? 0 : BRF300.getR42_AJMAN().intValue());
							}

							Cell R42cell7 = R42row.getCell(10);
							if (R42cell7 != null) {
								R42cell7.setCellValue(
										BRF300.getR42_RAS_AL() == null ? 0 : BRF300.getR42_RAS_AL().intValue());
							}

							Cell R42cell8 = R42row.getCell(11);
							if (R42cell8 != null) {
								R42cell8.setCellValue(
										BRF300.getR42_UMM_AL() == null ? 0 : BRF300.getR42_UMM_AL().intValue());
							}

							Cell R42cell9 = R42row.getCell(12);
							if (R42cell9 != null) {
								R42cell9.setCellValue(
										BRF300.getR42_FUJAIRAH() == null ? 0 : BRF300.getR42_FUJAIRAH().intValue());
							}

							// Save the changes
							workbook.getCreationHelper().createFormulaEvaluator().evaluateAll();
							FileOutputStream fileOut = new FileOutputStream(
									env.getProperty("output.exportpathfinal") + "011-BRF-300-A.xls");
							workbook.write(fileOut);
							fileOut.close();
							System.out.println(fileOut);
							path = fileOut.toString();
							// Close the workbook
							System.out.println("PATH : " + path);
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

			} //// else end

		}
		outputFile = new File(env.getProperty("output.exportpathfinal") + "011-BRF-300-A.xls");

		return outputFile;

	}

	public String detailChanges300(BRF300_DETAIL_ENTITY detail, String report_label_1, BigDecimal act_balance_amt_lc,
			String foracid, String report_name_1, String report_addl_criteria_1) {

		String msg = "";

		try {

			Session hs = sessionFactory.getCurrentSession();
			Optional<BRF300_DETAIL_ENTITY> Brf300detail = brf300_detailrepo.findById(foracid);

			if (Brf300detail.isPresent()) {
				BRF300_DETAIL_ENTITY BRFdetail = Brf300detail.get();

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
					brf300_detailrepo.save(BRFdetail);

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

	public ModelAndView getArchieveBRF300View(String reportId, String fromdate, String todate, String currency,
			String dtltype, Pageable pageable) {

		ModelAndView mv = new ModelAndView();

		Session hs = sessionFactory.getCurrentSession();
		int pageSize = pageable.getPageSize();
		int currentPage = pageable.getPageNumber();
		int startItem = currentPage * pageSize;
		List<BRF300_ENTITY> T1rep = new ArrayList<BRF300_ENTITY>();
		// Query<Object[]> qr;

		List<BRF300_ENTITY> T1Master = new ArrayList<BRF300_ENTITY>();

		logger.info("Inside archive" + currency);

		try {

			Date d1 = df.parse(todate);
			// T1rep = t1CurProdServiceRepo.getT1CurProdServices(d1);

			T1Master = hs.createQuery("from BRF300_ENTITY a where a.report_date = ?1 ", BRF300_ENTITY.class)
					.setParameter(1, df.parse(todate)).getResultList();

		} catch (ParseException e) {
			e.printStackTrace();
		}

		// T1rep = t1CurProdServiceRepo.getT1CurProdServices(d1);

		mv.setViewName("RR/BRF300ARCH");
		// mv.addObject("currlist", refCodeConfig.currList());
		mv.addObject("reportsummary", T1Master);
		mv.addObject("reportmaster", T1Master);
		mv.addObject("displaymode", "summary");
		mv.addObject("reportsflag", "reportsflag");
		mv.addObject("modify_flg", T1Master.size() > 0 ? T1Master.get(0).getModify_flg() : null);
		mv.addObject("modify_user", T1Master.size() > 0 ? T1Master.get(0).getModify_user() : null);
		mv.addObject("menu", reportId);
		System.out.println("scv" + mv.getViewName());

		return mv;
	}

	/****
	 * ARCH DETAILS
	 * 
	 * @throws ParseException
	 ****/

	public ModelAndView ARCHgetBRF300currentDtl(String reportId, String fromdate, String todate, String currency,
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
						"select * from BRF300_ARCHIVTABLE a where report_date=?1 and report_label_1=?2");
				qr.setParameter(1, df.parse(todate));
				qr.setParameter(2, filter);

			} else {
				System.out.println("2");
				qr = hs.createNativeQuery("select * from BRF300_ARCHIVTABLE");

			}
		} else {
			System.out.println("3");
			qr = hs.createNativeQuery("select * from BRF300_ARCHIVTABLE  where report_date = ?1");
		}

		List<BRF300_ARCHIVENTITY> T1Master = new ArrayList<BRF300_ARCHIVENTITY>();

		try {
			System.out.println("Values entered");
			T1Master = hs.createQuery("from BRF300_ARCHIVENTITY a where a.report_date = ?1", BRF300_ARCHIVENTITY.class)
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

			BRF300_ARCHIVENTITY py = new BRF300_ARCHIVENTITY(cust_id, foracid, act_balance_amt_lc, eab_lc, acct_name,
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

		mv.setViewName("RR" + "/" + "BRF300ARCH::reportcontent");
		mv.addObject("reportdetails", T1Dt1Page.getContent());
		mv.addObject("reportmaster", T1Master);
		mv.addObject("reportmaster1", qr);
		mv.addObject("singledetail", new T1CurProdDetail());
		mv.addObject("reportsflag", "reportsflag");
		mv.addObject("menu", reportId);
		return mv;
	}

	public String modifyBRF300Report(Date asondate, BRF300_ENTITY brf300_ENTITY, String userId,
			HttpServletRequest req) {
		String msg = "";
		BRF300_ENTITY up = brf300aServiceRepo.getBRF300AReport(asondate);

		// Lists for change tracking
		List<String> oldValuesList = new ArrayList<>();
		List<String> newValuesList = new ArrayList<>();
		List<String> fieldNames = new ArrayList<>();

		// StringBuilders to capture detailed changes
		StringBuilder oldChange = new StringBuilder();
		StringBuilder newChange = new StringBuilder();
		boolean rowEdited = false; // Flag to track if the row has any changes

		
		//Headquarters function start
		
		if (brf300_ENTITY.getR2_S_NO().compareTo(up.getR2_S_NO()) != 0) {
			fieldNames.add("S.No");
			oldChange.append("R2_COL_1: ").append(up.getR2_S_NO()).append("; ");
			newChange.append("R2_COL_1: ").append(brf300_ENTITY.getR2_S_NO()).append("; ");
			rowEdited = true;
		}

		if (brf300_ENTITY.getR2_HEADQUATERS().compareTo(up.getR2_HEADQUATERS()) != 0) {
			fieldNames.add("Headquarters - HQ location");
			oldChange.append("R2_COL_2: ").append(up.getR2_HEADQUATERS()).append("; ");
			newChange.append("R2_COL_2: ").append(brf300_ENTITY.getR2_HEADQUATERS()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR2_ABU_DHABI().compareTo(up.getR2_ABU_DHABI()) != 0) {
			fieldNames.add("Abu Dhabi - Abu Dhabi City");
			oldChange.append("R2_COL_3: ").append(up.getR2_ABU_DHABI()).append("; ");
			newChange.append("R2_COL_3: ").append(brf300_ENTITY.getR2_ABU_DHABI()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR2_WESTERNM_REGION().compareTo(up.getR2_WESTERNM_REGION()) != 0) {
			fieldNames.add("Abu Dhabi - Western Region");
			oldChange.append("R2_COL_4: ").append(up.getR2_WESTERNM_REGION()).append("; ");
			newChange.append("R2_COL_4: ").append(brf300_ENTITY.getR2_WESTERNM_REGION()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR2_AL_AIN().compareTo(up.getR2_AL_AIN()) != 0) {
			fieldNames.add("Abu Dhabi - Al Ain");
			oldChange.append("R2_COL_5: ").append(up.getR2_AL_AIN()).append("; ");
			newChange.append("R2_COL_5: ").append(brf300_ENTITY.getR2_AL_AIN()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR2_ISLAND().compareTo(up.getR2_ISLAND()) != 0) {
			fieldNames.add("Abu Dhabi - Islands");
			oldChange.append("R2_COL_6: ").append(up.getR2_ISLAND()).append("; ");
			newChange.append("R2_COL_6: ").append(brf300_ENTITY.getR2_ISLAND()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR2_DUBAI().compareTo(up.getR2_DUBAI()) != 0) {
			fieldNames.add("Dubai");
			oldChange.append("R2_COL_7: ").append(up.getR2_DUBAI()).append("; ");
			newChange.append("R2_COL_7: ").append(brf300_ENTITY.getR2_DUBAI()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR2_SHARJAH().compareTo(up.getR2_SHARJAH()) != 0) {
			fieldNames.add("Sharjah");
			oldChange.append("R2_COL_8: ").append(up.getR2_SHARJAH()).append("; ");
			newChange.append("R2_COL_8: ").append(brf300_ENTITY.getR2_SHARJAH()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR2_AJMAN().compareTo(up.getR2_AJMAN()) != 0) {
			fieldNames.add("Ajman");
			oldChange.append("R2_COL_9: ").append(up.getR2_AJMAN()).append("; ");
			newChange.append("R2_COL_9: ").append(brf300_ENTITY.getR2_AJMAN()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR2_RAS_AL().compareTo(up.getR2_RAS_AL()) != 0) {
			fieldNames.add("Ras al-Khaimah");
			oldChange.append("R2_COL_10: ").append(up.getR2_RAS_AL()).append("; ");
			newChange.append("R2_COL_10: ").append(brf300_ENTITY.getR2_RAS_AL()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR2_UMM_AL().compareTo(up.getR2_UMM_AL()) != 0) {
			fieldNames.add("Umm al-Quwain");
			oldChange.append("R2_COL_11: ").append(up.getR2_UMM_AL()).append("; ");
			newChange.append("R2_COL_11: ").append(brf300_ENTITY.getR2_UMM_AL()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR2_FUJAIRAH().compareTo(up.getR2_FUJAIRAH()) != 0) {
			fieldNames.add("Fujairah");
			oldChange.append("R2_COL_12: ").append(up.getR2_FUJAIRAH()).append("; ");
			newChange.append("R2_COL_12: ").append(brf300_ENTITY.getR2_FUJAIRAH()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR2_ABU_SUB().compareTo(up.getR2_ABU_SUB()) != 0) {
			fieldNames.add("Abu Dhabi Sub-total (D+E+F+G)");
			oldChange.append("R2_COL_13: ").append(up.getR2_ABU_SUB()).append("; ");
			newChange.append("R2_COL_13: ").append(brf300_ENTITY.getR2_ABU_SUB()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR2_TOTAL().compareTo(up.getR2_TOTAL()) != 0) {
			fieldNames.add("Total");
			oldChange.append("R2_COL_14: ").append(up.getR2_TOTAL()).append("; ");
			newChange.append("R2_COL_14: ").append(brf300_ENTITY.getR2_TOTAL()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR3_S_NO().compareTo(up.getR3_S_NO()) != 0) {
			fieldNames.add("S.No");
			oldChange.append("R3_COL_1: ").append(up.getR3_S_NO()).append("; ");
			newChange.append("R3_COL_1: ").append(brf300_ENTITY.getR3_S_NO()).append("; ");
			rowEdited = true;
		}

		if (brf300_ENTITY.getR3_HEADQUATERS().compareTo(up.getR3_HEADQUATERS()) != 0) {
			fieldNames.add("Headquarters - No. of HQ employees");
			oldChange.append("R3_COL_2: ").append(up.getR3_HEADQUATERS()).append("; ");
			newChange.append("R3_COL_2: ").append(brf300_ENTITY.getR3_HEADQUATERS()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR3_ABU_DHABI().compareTo(up.getR3_ABU_DHABI()) != 0) {
			fieldNames.add("Abu Dhabi - Abu Dhabi City");
			oldChange.append("R3_COL_3: ").append(up.getR3_ABU_DHABI()).append("; ");
			newChange.append("R3_COL_3: ").append(brf300_ENTITY.getR3_ABU_DHABI()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR3_WESTERNM_REGION().compareTo(up.getR3_WESTERNM_REGION()) != 0) {
			fieldNames.add("Abu Dhabi - Western Region");
			oldChange.append("R3_COL_4: ").append(up.getR3_WESTERNM_REGION()).append("; ");
			newChange.append("R3_COL_4: ").append(brf300_ENTITY.getR3_WESTERNM_REGION()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR3_AL_AIN().compareTo(up.getR3_AL_AIN()) != 0) {
			fieldNames.add("Abu Dhabi - Al Ain");
			oldChange.append("R3_COL_5: ").append(up.getR3_AL_AIN()).append("; ");
			newChange.append("R3_COL_5: ").append(brf300_ENTITY.getR3_AL_AIN()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR3_ISLAND().compareTo(up.getR3_ISLAND()) != 0) {
			fieldNames.add("Abu Dhabi - Islands");
			oldChange.append("R3_COL_6: ").append(up.getR3_ISLAND()).append("; ");
			newChange.append("R3_COL_6: ").append(brf300_ENTITY.getR3_ISLAND()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR3_DUBAI().compareTo(up.getR3_DUBAI()) != 0) {
			fieldNames.add("Dubai");
			oldChange.append("R3_COL_7: ").append(up.getR3_DUBAI()).append("; ");
			newChange.append("R3_COL_7: ").append(brf300_ENTITY.getR3_DUBAI()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR3_SHARJAH().compareTo(up.getR3_SHARJAH()) != 0) {
			fieldNames.add("Sharjah");
			oldChange.append("R3_COL_8: ").append(up.getR3_SHARJAH()).append("; ");
			newChange.append("R3_COL_8: ").append(brf300_ENTITY.getR3_SHARJAH()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR3_AJMAN().compareTo(up.getR3_AJMAN()) != 0) {
			fieldNames.add("Ajman");
			oldChange.append("R3_COL_9: ").append(up.getR3_AJMAN()).append("; ");
			newChange.append("R3_COL_9: ").append(brf300_ENTITY.getR3_AJMAN()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR3_RAS_AL().compareTo(up.getR3_RAS_AL()) != 0) {
			fieldNames.add("Ras al-Khaimah");
			oldChange.append("R3_COL_10: ").append(up.getR3_RAS_AL()).append("; ");
			newChange.append("R3_COL_10: ").append(brf300_ENTITY.getR3_RAS_AL()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR3_UMM_AL().compareTo(up.getR3_UMM_AL()) != 0) {
			fieldNames.add("Umm al-Quwain");
			oldChange.append("R3_COL_11: ").append(up.getR3_UMM_AL()).append("; ");
			newChange.append("R3_COL_11: ").append(brf300_ENTITY.getR3_UMM_AL()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR3_FUJAIRAH().compareTo(up.getR3_FUJAIRAH()) != 0) {
			fieldNames.add("Fujairah");
			oldChange.append("R3_COL_12: ").append(up.getR3_FUJAIRAH()).append("; ");
			newChange.append("R3_COL_12: ").append(brf300_ENTITY.getR3_FUJAIRAH()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR3_ABU_SUB().compareTo(up.getR3_ABU_SUB()) != 0) {
			fieldNames.add("Abu Dhabi Sub-total (D+E+F+G)");
			oldChange.append("R3_COL_13: ").append(up.getR3_ABU_SUB()).append("; ");
			newChange.append("R3_COL_13: ").append(brf300_ENTITY.getR3_ABU_SUB()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR3_TOTAL().compareTo(up.getR3_TOTAL()) != 0) {
			fieldNames.add("Total");
			oldChange.append("R3_COL_14: ").append(up.getR3_TOTAL()).append("; ");
			newChange.append("R3_COL_14: ").append(brf300_ENTITY.getR3_TOTAL()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR4_S_NO().compareTo(up.getR4_S_NO()) != 0) {
			fieldNames.add("S.No");
			oldChange.append("R4_COL_1: ").append(up.getR4_S_NO()).append("; ");
			newChange.append("R4_COL_1: ").append(brf300_ENTITY.getR4_S_NO()).append("; ");
			rowEdited = true;
		}

		if (brf300_ENTITY.getR4_HEADQUATERS().compareTo(up.getR4_HEADQUATERS()) != 0) {
			fieldNames.add("Headquarters - No. of HQ Nationals employees");
			oldChange.append("R4_COL_2: ").append(up.getR4_HEADQUATERS()).append("; ");
			newChange.append("R4_COL_2: ").append(brf300_ENTITY.getR4_HEADQUATERS()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR4_ABU_DHABI().compareTo(up.getR4_ABU_DHABI()) != 0) {
			fieldNames.add("Abu Dhabi - Abu Dhabi City");
			oldChange.append("R4_COL_3: ").append(up.getR4_ABU_DHABI()).append("; ");
			newChange.append("R4_COL_3: ").append(brf300_ENTITY.getR4_ABU_DHABI()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR4_WESTERNM_REGION().compareTo(up.getR4_WESTERNM_REGION()) != 0) {
			fieldNames.add("Abu Dhabi - Western Region");
			oldChange.append("R4_COL_4: ").append(up.getR4_WESTERNM_REGION()).append("; ");
			newChange.append("R4_COL_4: ").append(brf300_ENTITY.getR4_WESTERNM_REGION()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR4_AL_AIN().compareTo(up.getR4_AL_AIN()) != 0) {
			fieldNames.add("Abu Dhabi - Al Ain");
			oldChange.append("R4_COL_5: ").append(up.getR4_AL_AIN()).append("; ");
			newChange.append("R4_COL_5: ").append(brf300_ENTITY.getR4_AL_AIN()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR4_ISLAND().compareTo(up.getR4_ISLAND()) != 0) {
			fieldNames.add("Abu Dhabi - Islands");
			oldChange.append("R4_COL_6: ").append(up.getR4_ISLAND()).append("; ");
			newChange.append("R4_COL_6: ").append(brf300_ENTITY.getR4_ISLAND()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR4_DUBAI().compareTo(up.getR4_DUBAI()) != 0) {
			fieldNames.add("Dubai");
			oldChange.append("R4_COL_7: ").append(up.getR4_DUBAI()).append("; ");
			newChange.append("R4_COL_7: ").append(brf300_ENTITY.getR4_DUBAI()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR4_SHARJAH().compareTo(up.getR4_SHARJAH()) != 0) {
			fieldNames.add("Sharjah");
			oldChange.append("R4_COL_8: ").append(up.getR4_SHARJAH()).append("; ");
			newChange.append("R4_COL_8: ").append(brf300_ENTITY.getR4_SHARJAH()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR4_AJMAN().compareTo(up.getR4_AJMAN()) != 0) {
			fieldNames.add("Ajman");
			oldChange.append("R4_COL_9: ").append(up.getR4_AJMAN()).append("; ");
			newChange.append("R4_COL_9: ").append(brf300_ENTITY.getR4_AJMAN()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR4_RAS_AL().compareTo(up.getR4_RAS_AL()) != 0) {
			fieldNames.add("Ras al-Khaimah");
			oldChange.append("R4_COL_10: ").append(up.getR4_RAS_AL()).append("; ");
			newChange.append("R4_COL_10: ").append(brf300_ENTITY.getR4_RAS_AL()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR4_UMM_AL().compareTo(up.getR4_UMM_AL()) != 0) {
			fieldNames.add("Umm al-Quwain");
			oldChange.append("R4_COL_11: ").append(up.getR4_UMM_AL()).append("; ");
			newChange.append("R4_COL_11: ").append(brf300_ENTITY.getR4_UMM_AL()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR4_FUJAIRAH().compareTo(up.getR4_FUJAIRAH()) != 0) {
			fieldNames.add("Fujairah");
			oldChange.append("R4_COL_12: ").append(up.getR4_FUJAIRAH()).append("; ");
			newChange.append("R4_COL_12: ").append(brf300_ENTITY.getR4_FUJAIRAH()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR4_ABU_SUB().compareTo(up.getR4_ABU_SUB()) != 0) {
			fieldNames.add("Abu Dhabi Sub-total (D+E+F+G)");
			oldChange.append("R4_COL_13: ").append(up.getR4_ABU_SUB()).append("; ");
			newChange.append("R4_COL_13: ").append(brf300_ENTITY.getR4_ABU_SUB()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR4_TOTAL().compareTo(up.getR4_TOTAL()) != 0) {
			fieldNames.add("Total");
			oldChange.append("R4_COL_14: ").append(up.getR4_TOTAL()).append("; ");
			newChange.append("R4_COL_14: ").append(brf300_ENTITY.getR4_TOTAL()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR5_S_NO().compareTo(up.getR5_S_NO()) != 0) {
			fieldNames.add("S.No");
			oldChange.append("R5_COL_1: ").append(up.getR5_S_NO()).append("; ");
			newChange.append("R5_COL_1: ").append(brf300_ENTITY.getR5_S_NO()).append("; ");
			rowEdited = true;
		}

		if (brf300_ENTITY.getR5_HEADQUATERS().compareTo(up.getR5_HEADQUATERS()) != 0) {
			fieldNames.add("Headquarters - No. of HQ Nationals Female employees");
			oldChange.append("R5_COL_2: ").append(up.getR5_HEADQUATERS()).append("; ");
			newChange.append("R5_COL_2: ").append(brf300_ENTITY.getR5_HEADQUATERS()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR5_ABU_DHABI().compareTo(up.getR5_ABU_DHABI()) != 0) {
			fieldNames.add("Abu Dhabi - Abu Dhabi City");
			oldChange.append("R5_COL_3: ").append(up.getR5_ABU_DHABI()).append("; ");
			newChange.append("R5_COL_3: ").append(brf300_ENTITY.getR5_ABU_DHABI()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR5_WESTERNM_REGION().compareTo(up.getR5_WESTERNM_REGION()) != 0) {
			fieldNames.add("Abu Dhabi - Western Region");
			oldChange.append("R5_COL_4: ").append(up.getR5_WESTERNM_REGION()).append("; ");
			newChange.append("R5_COL_4: ").append(brf300_ENTITY.getR5_WESTERNM_REGION()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR5_AL_AIN().compareTo(up.getR5_AL_AIN()) != 0) {
			fieldNames.add("Abu Dhabi - Al Ain");
			oldChange.append("R5_COL_5: ").append(up.getR5_AL_AIN()).append("; ");
			newChange.append("R5_COL_5: ").append(brf300_ENTITY.getR5_AL_AIN()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR5_ISLAND().compareTo(up.getR5_ISLAND()) != 0) {
			fieldNames.add("Abu Dhabi - Islands");
			oldChange.append("R5_COL_6: ").append(up.getR5_ISLAND()).append("; ");
			newChange.append("R5_COL_6: ").append(brf300_ENTITY.getR5_ISLAND()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR5_DUBAI().compareTo(up.getR5_DUBAI()) != 0) {
			fieldNames.add("Dubai");
			oldChange.append("R5_COL_7: ").append(up.getR5_DUBAI()).append("; ");
			newChange.append("R5_COL_7: ").append(brf300_ENTITY.getR5_DUBAI()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR5_SHARJAH().compareTo(up.getR5_SHARJAH()) != 0) {
			fieldNames.add("Sharjah");
			oldChange.append("R5_COL_8: ").append(up.getR5_SHARJAH()).append("; ");
			newChange.append("R5_COL_8: ").append(brf300_ENTITY.getR5_SHARJAH()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR5_AJMAN().compareTo(up.getR5_AJMAN()) != 0) {
			fieldNames.add("Ajman");
			oldChange.append("R5_COL_9: ").append(up.getR5_AJMAN()).append("; ");
			newChange.append("R5_COL_9: ").append(brf300_ENTITY.getR5_AJMAN()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR5_RAS_AL().compareTo(up.getR5_RAS_AL()) != 0) {
			fieldNames.add("Ras al-Khaimah");
			oldChange.append("R5_COL_10: ").append(up.getR5_RAS_AL()).append("; ");
			newChange.append("R5_COL_10: ").append(brf300_ENTITY.getR5_RAS_AL()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR5_UMM_AL().compareTo(up.getR5_UMM_AL()) != 0) {
			fieldNames.add("Umm al-Quwain");
			oldChange.append("R5_COL_11: ").append(up.getR5_UMM_AL()).append("; ");
			newChange.append("R5_COL_11: ").append(brf300_ENTITY.getR5_UMM_AL()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR5_FUJAIRAH().compareTo(up.getR5_FUJAIRAH()) != 0) {
			fieldNames.add("Fujairah");
			oldChange.append("R5_COL_12: ").append(up.getR5_FUJAIRAH()).append("; ");
			newChange.append("R5_COL_12: ").append(brf300_ENTITY.getR5_FUJAIRAH()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR5_ABU_SUB().compareTo(up.getR5_ABU_SUB()) != 0) {
			fieldNames.add("Abu Dhabi Sub-total (D+E+F+G)");
			oldChange.append("R5_COL_13: ").append(up.getR5_ABU_SUB()).append("; ");
			newChange.append("R5_COL_13: ").append(brf300_ENTITY.getR5_ABU_SUB()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR5_TOTAL().compareTo(up.getR5_TOTAL()) != 0) {
			fieldNames.add("Total");
			oldChange.append("R5_COL_14: ").append(up.getR5_TOTAL()).append("; ");
			newChange.append("R5_COL_14: ").append(brf300_ENTITY.getR5_TOTAL()).append("; ");
			rowEdited = true;
		}
		
		//Branches function start
		
		if (brf300_ENTITY.getR7_S_NO().compareTo(up.getR7_S_NO()) != 0) {
			fieldNames.add("S.No");
			oldChange.append("R7_COL_1: ").append(up.getR7_S_NO()).append("; ");
			newChange.append("R7_COL_1: ").append(brf300_ENTITY.getR7_S_NO()).append("; ");
			rowEdited = true;
		}

		if (brf300_ENTITY.getR7_HEADQUATERS().compareTo(up.getR7_HEADQUATERS()) != 0) {
			fieldNames.add("Branches - No. of branches");
			oldChange.append("R7_COL_2: ").append(up.getR7_HEADQUATERS()).append("; ");
			newChange.append("R7_COL_2: ").append(brf300_ENTITY.getR7_HEADQUATERS()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR7_ABU_DHABI().compareTo(up.getR7_ABU_DHABI()) != 0) {
			fieldNames.add("Abu Dhabi - Abu Dhabi City");
			oldChange.append("R7_COL_3: ").append(up.getR7_ABU_DHABI()).append("; ");
			newChange.append("R7_COL_3: ").append(brf300_ENTITY.getR7_ABU_DHABI()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR7_WESTERNM_REGION().compareTo(up.getR7_WESTERNM_REGION()) != 0) {
			fieldNames.add("Abu Dhabi - Western Region");
			oldChange.append("R7_COL_4: ").append(up.getR7_WESTERNM_REGION()).append("; ");
			newChange.append("R7_COL_4: ").append(brf300_ENTITY.getR7_WESTERNM_REGION()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR7_AL_AIN().compareTo(up.getR7_AL_AIN()) != 0) {
			fieldNames.add("Abu Dhabi - Al Ain");
			oldChange.append("R7_COL_5: ").append(up.getR7_AL_AIN()).append("; ");
			newChange.append("R7_COL_5: ").append(brf300_ENTITY.getR7_AL_AIN()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR7_ISLAND().compareTo(up.getR7_ISLAND()) != 0) {
			fieldNames.add("Abu Dhabi - Islands");
			oldChange.append("R7_COL_6: ").append(up.getR7_ISLAND()).append("; ");
			newChange.append("R7_COL_6: ").append(brf300_ENTITY.getR7_ISLAND()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR7_DUBAI().compareTo(up.getR7_DUBAI()) != 0) {
			fieldNames.add("Dubai");
			oldChange.append("R7_COL_7: ").append(up.getR7_DUBAI()).append("; ");
			newChange.append("R7_COL_7: ").append(brf300_ENTITY.getR7_DUBAI()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR7_SHARJAH().compareTo(up.getR7_SHARJAH()) != 0) {
			fieldNames.add("Sharjah");
			oldChange.append("R7_COL_8: ").append(up.getR7_SHARJAH()).append("; ");
			newChange.append("R7_COL_8: ").append(brf300_ENTITY.getR7_SHARJAH()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR7_AJMAN().compareTo(up.getR7_AJMAN()) != 0) {
			fieldNames.add("Ajman");
			oldChange.append("R7_COL_9: ").append(up.getR7_AJMAN()).append("; ");
			newChange.append("R7_COL_9: ").append(brf300_ENTITY.getR7_AJMAN()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR7_RAS_AL().compareTo(up.getR7_RAS_AL()) != 0) {
			fieldNames.add("Ras al-Khaimah");
			oldChange.append("R7_COL_10: ").append(up.getR7_RAS_AL()).append("; ");
			newChange.append("R7_COL_10: ").append(brf300_ENTITY.getR7_RAS_AL()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR7_UMM_AL().compareTo(up.getR7_UMM_AL()) != 0) {
			fieldNames.add("Umm al-Quwain");
			oldChange.append("R7_COL_11: ").append(up.getR7_UMM_AL()).append("; ");
			newChange.append("R7_COL_11: ").append(brf300_ENTITY.getR7_UMM_AL()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR7_FUJAIRAH().compareTo(up.getR7_FUJAIRAH()) != 0) {
			fieldNames.add("Fujairah");
			oldChange.append("R7_COL_12: ").append(up.getR7_FUJAIRAH()).append("; ");
			newChange.append("R7_COL_12: ").append(brf300_ENTITY.getR7_FUJAIRAH()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR7_ABU_SUB().compareTo(up.getR7_ABU_SUB()) != 0) {
			fieldNames.add("Abu Dhabi Sub-total (D+E+F+G)");
			oldChange.append("R7_COL_13: ").append(up.getR7_ABU_SUB()).append("; ");
			newChange.append("R7_COL_13: ").append(brf300_ENTITY.getR7_ABU_SUB()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR7_TOTAL().compareTo(up.getR7_TOTAL()) != 0) {
			fieldNames.add("Total");
			oldChange.append("R7_COL_14: ").append(up.getR7_TOTAL()).append("; ");
			newChange.append("R7_COL_14: ").append(brf300_ENTITY.getR7_TOTAL()).append("; ");
			rowEdited = true;
		}

		if (brf300_ENTITY.getR8_S_NO().compareTo(up.getR8_S_NO()) != 0) {
			fieldNames.add("S.No");
			oldChange.append("R8_COL_1: ").append(up.getR8_S_NO()).append("; ");
			newChange.append("R8_COL_1: ").append(brf300_ENTITY.getR8_S_NO()).append("; ");
			rowEdited = true;
		}

		if (brf300_ENTITY.getR8_HEADQUATERS().compareTo(up.getR8_HEADQUATERS()) != 0) {
			fieldNames.add("Branches - No. of employees in branches");
			oldChange.append("R8_COL_2: ").append(up.getR8_HEADQUATERS()).append("; ");
			newChange.append("R8_COL_2: ").append(brf300_ENTITY.getR8_HEADQUATERS()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR8_ABU_DHABI().compareTo(up.getR8_ABU_DHABI()) != 0) {
			fieldNames.add("Abu Dhabi - Abu Dhabi City");
			oldChange.append("R8_COL_3: ").append(up.getR8_ABU_DHABI()).append("; ");
			newChange.append("R8_COL_3: ").append(brf300_ENTITY.getR8_ABU_DHABI()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR8_WESTERNM_REGION().compareTo(up.getR8_WESTERNM_REGION()) != 0) {
			fieldNames.add("Abu Dhabi - Western Region");
			oldChange.append("R8_COL_4: ").append(up.getR8_WESTERNM_REGION()).append("; ");
			newChange.append("R8_COL_4: ").append(brf300_ENTITY.getR8_WESTERNM_REGION()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR8_AL_AIN().compareTo(up.getR8_AL_AIN()) != 0) {
			fieldNames.add("Abu Dhabi - Al Ain");
			oldChange.append("R8_COL_5: ").append(up.getR8_AL_AIN()).append("; ");
			newChange.append("R8_COL_5: ").append(brf300_ENTITY.getR8_AL_AIN()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR8_ISLAND().compareTo(up.getR8_ISLAND()) != 0) {
			fieldNames.add("Abu Dhabi - Islands");
			oldChange.append("R8_COL_6: ").append(up.getR8_ISLAND()).append("; ");
			newChange.append("R8_COL_6: ").append(brf300_ENTITY.getR8_ISLAND()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR8_DUBAI().compareTo(up.getR8_DUBAI()) != 0) {
			fieldNames.add("Dubai");
			oldChange.append("R8_COL_7: ").append(up.getR8_DUBAI()).append("; ");
			newChange.append("R8_COL_7: ").append(brf300_ENTITY.getR8_DUBAI()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR8_SHARJAH().compareTo(up.getR8_SHARJAH()) != 0) {
			fieldNames.add("Sharjah");
			oldChange.append("R8_COL_8: ").append(up.getR8_SHARJAH()).append("; ");
			newChange.append("R8_COL_8: ").append(brf300_ENTITY.getR8_SHARJAH()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR8_AJMAN().compareTo(up.getR8_AJMAN()) != 0) {
			fieldNames.add("Ajman");
			oldChange.append("R8_COL_9: ").append(up.getR8_AJMAN()).append("; ");
			newChange.append("R8_COL_9: ").append(brf300_ENTITY.getR8_AJMAN()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR8_RAS_AL().compareTo(up.getR8_RAS_AL()) != 0) {
			fieldNames.add("Ras al-Khaimah");
			oldChange.append("R8_COL_10: ").append(up.getR8_RAS_AL()).append("; ");
			newChange.append("R8_COL_10: ").append(brf300_ENTITY.getR8_RAS_AL()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR8_UMM_AL().compareTo(up.getR8_UMM_AL()) != 0) {
			fieldNames.add("Umm al-Quwain");
			oldChange.append("R8_COL_11: ").append(up.getR8_UMM_AL()).append("; ");
			newChange.append("R8_COL_11: ").append(brf300_ENTITY.getR8_UMM_AL()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR8_FUJAIRAH().compareTo(up.getR8_FUJAIRAH()) != 0) {
			fieldNames.add("Fujairah");
			oldChange.append("R8_COL_12: ").append(up.getR8_FUJAIRAH()).append("; ");
			newChange.append("R8_COL_12: ").append(brf300_ENTITY.getR8_FUJAIRAH()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR8_ABU_SUB().compareTo(up.getR8_ABU_SUB()) != 0) {
			fieldNames.add("Abu Dhabi Sub-total (D+E+F+G)");
			oldChange.append("R8_COL_13: ").append(up.getR8_ABU_SUB()).append("; ");
			newChange.append("R8_COL_13: ").append(brf300_ENTITY.getR8_ABU_SUB()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR8_TOTAL().compareTo(up.getR8_TOTAL()) != 0) {
			fieldNames.add("Total");
			oldChange.append("R8_COL_14: ").append(up.getR8_TOTAL()).append("; ");
			newChange.append("R8_COL_14: ").append(brf300_ENTITY.getR8_TOTAL()).append("; ");
			rowEdited = true;
		}
		
		
		if (brf300_ENTITY.getR9_S_NO().compareTo(up.getR9_S_NO()) != 0) {
			fieldNames.add("S.No");
			oldChange.append("R9_COL_1: ").append(up.getR9_S_NO()).append("; ");
			newChange.append("R9_COL_1: ").append(brf300_ENTITY.getR9_S_NO()).append("; ");
			rowEdited = true;
		}

		if (brf300_ENTITY.getR9_HEADQUATERS().compareTo(up.getR9_HEADQUATERS()) != 0) {
			fieldNames.add("Branches - No. of Nationals in branches");
			oldChange.append("R9_COL_2: ").append(up.getR9_HEADQUATERS()).append("; ");
			newChange.append("R9_COL_2: ").append(brf300_ENTITY.getR9_HEADQUATERS()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR9_ABU_DHABI().compareTo(up.getR9_ABU_DHABI()) != 0) {
			fieldNames.add("Abu Dhabi - Abu Dhabi City");
			oldChange.append("R9_COL_3: ").append(up.getR9_ABU_DHABI()).append("; ");
			newChange.append("R9_COL_3: ").append(brf300_ENTITY.getR9_ABU_DHABI()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR9_WESTERNM_REGION().compareTo(up.getR9_WESTERNM_REGION()) != 0) {
			fieldNames.add("Abu Dhabi - Western Region");
			oldChange.append("R9_COL_4: ").append(up.getR9_WESTERNM_REGION()).append("; ");
			newChange.append("R9_COL_4: ").append(brf300_ENTITY.getR9_WESTERNM_REGION()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR9_AL_AIN().compareTo(up.getR9_AL_AIN()) != 0) {
			fieldNames.add("Abu Dhabi - Al Ain");
			oldChange.append("R9_COL_5: ").append(up.getR9_AL_AIN()).append("; ");
			newChange.append("R9_COL_5: ").append(brf300_ENTITY.getR9_AL_AIN()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR9_ISLAND().compareTo(up.getR9_ISLAND()) != 0) {
			fieldNames.add("Abu Dhabi - Islands");
			oldChange.append("R9_COL_6: ").append(up.getR9_ISLAND()).append("; ");
			newChange.append("R9_COL_6: ").append(brf300_ENTITY.getR9_ISLAND()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR9_DUBAI().compareTo(up.getR9_DUBAI()) != 0) {
			fieldNames.add("Dubai");
			oldChange.append("R9_COL_7: ").append(up.getR9_DUBAI()).append("; ");
			newChange.append("R9_COL_7: ").append(brf300_ENTITY.getR9_DUBAI()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR9_SHARJAH().compareTo(up.getR9_SHARJAH()) != 0) {
			fieldNames.add("Sharjah");
			oldChange.append("R9_COL_8: ").append(up.getR9_SHARJAH()).append("; ");
			newChange.append("R9_COL_8: ").append(brf300_ENTITY.getR9_SHARJAH()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR9_AJMAN().compareTo(up.getR9_AJMAN()) != 0) {
			fieldNames.add("Ajman");
			oldChange.append("R9_COL_9: ").append(up.getR9_AJMAN()).append("; ");
			newChange.append("R9_COL_9: ").append(brf300_ENTITY.getR9_AJMAN()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR9_RAS_AL().compareTo(up.getR9_RAS_AL()) != 0) {
			fieldNames.add("Ras al-Khaimah");
			oldChange.append("R9_COL_10: ").append(up.getR9_RAS_AL()).append("; ");
			newChange.append("R9_COL_10: ").append(brf300_ENTITY.getR9_RAS_AL()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR9_UMM_AL().compareTo(up.getR9_UMM_AL()) != 0) {
			fieldNames.add("Umm al-Quwain");
			oldChange.append("R9_COL_11: ").append(up.getR9_UMM_AL()).append("; ");
			newChange.append("R9_COL_11: ").append(brf300_ENTITY.getR9_UMM_AL()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR9_FUJAIRAH().compareTo(up.getR9_FUJAIRAH()) != 0) {
			fieldNames.add("Fujairah");
			oldChange.append("R9_COL_12: ").append(up.getR9_FUJAIRAH()).append("; ");
			newChange.append("R9_COL_12: ").append(brf300_ENTITY.getR9_FUJAIRAH()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR9_ABU_SUB().compareTo(up.getR9_ABU_SUB()) != 0) {
			fieldNames.add("Abu Dhabi Sub-total (D+E+F+G)");
			oldChange.append("R9_COL_13: ").append(up.getR9_ABU_SUB()).append("; ");
			newChange.append("R9_COL_13: ").append(brf300_ENTITY.getR9_ABU_SUB()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR9_TOTAL().compareTo(up.getR9_TOTAL()) != 0) {
			fieldNames.add("Total");
			oldChange.append("R9_COL_14: ").append(up.getR9_TOTAL()).append("; ");
			newChange.append("R9_COL_14: ").append(brf300_ENTITY.getR9_TOTAL()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR10_S_NO().compareTo(up.getR10_S_NO()) != 0) {
			fieldNames.add("S.No");
			oldChange.append("R10_COL_1: ").append(up.getR10_S_NO()).append("; ");
			newChange.append("R10_COL_1: ").append(brf300_ENTITY.getR10_S_NO()).append("; ");
			rowEdited = true;
		}

		if (brf300_ENTITY.getR10_HEADQUATERS().compareTo(up.getR10_HEADQUATERS()) != 0) {
			fieldNames.add("Branches - No. of Nationals Female in branches");
			oldChange.append("R10_COL_2: ").append(up.getR10_HEADQUATERS()).append("; ");
			newChange.append("R10_COL_2: ").append(brf300_ENTITY.getR10_HEADQUATERS()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR10_ABU_DHABI().compareTo(up.getR10_ABU_DHABI()) != 0) {
			fieldNames.add("Abu Dhabi - Abu Dhabi City");
			oldChange.append("R10_COL_3: ").append(up.getR10_ABU_DHABI()).append("; ");
			newChange.append("R10_COL_3: ").append(brf300_ENTITY.getR10_ABU_DHABI()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR10_WESTERNM_REGION().compareTo(up.getR10_WESTERNM_REGION()) != 0) {
			fieldNames.add("Abu Dhabi - Western Region");
			oldChange.append("R10_COL_4: ").append(up.getR10_WESTERNM_REGION()).append("; ");
			newChange.append("R10_COL_4: ").append(brf300_ENTITY.getR10_WESTERNM_REGION()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR10_AL_AIN().compareTo(up.getR10_AL_AIN()) != 0) {
			fieldNames.add("Abu Dhabi - Al Ain");
			oldChange.append("R10_COL_5: ").append(up.getR10_AL_AIN()).append("; ");
			newChange.append("R10_COL_5: ").append(brf300_ENTITY.getR10_AL_AIN()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR10_ISLAND().compareTo(up.getR10_ISLAND()) != 0) {
			fieldNames.add("Abu Dhabi - Islands");
			oldChange.append("R10_COL_6: ").append(up.getR10_ISLAND()).append("; ");
			newChange.append("R10_COL_6: ").append(brf300_ENTITY.getR10_ISLAND()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR10_DUBAI().compareTo(up.getR10_DUBAI()) != 0) {
			fieldNames.add("Dubai");
			oldChange.append("R10_COL_7: ").append(up.getR10_DUBAI()).append("; ");
			newChange.append("R10_COL_7: ").append(brf300_ENTITY.getR10_DUBAI()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR10_SHARJAH().compareTo(up.getR10_SHARJAH()) != 0) {
			fieldNames.add("Sharjah");
			oldChange.append("R10_COL_8: ").append(up.getR10_SHARJAH()).append("; ");
			newChange.append("R10_COL_8: ").append(brf300_ENTITY.getR10_SHARJAH()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR10_AJMAN().compareTo(up.getR10_AJMAN()) != 0) {
			fieldNames.add("Ajman");
			oldChange.append("R10_COL_9: ").append(up.getR10_AJMAN()).append("; ");
			newChange.append("R10_COL_9: ").append(brf300_ENTITY.getR10_AJMAN()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR10_RAS_AL().compareTo(up.getR10_RAS_AL()) != 0) {
			fieldNames.add("Ras al-Khaimah");
			oldChange.append("R10_COL_10: ").append(up.getR10_RAS_AL()).append("; ");
			newChange.append("R10_COL_10: ").append(brf300_ENTITY.getR10_RAS_AL()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR10_UMM_AL().compareTo(up.getR10_UMM_AL()) != 0) {
			fieldNames.add("Umm al-Quwain");
			oldChange.append("R10_COL_11: ").append(up.getR10_UMM_AL()).append("; ");
			newChange.append("R10_COL_11: ").append(brf300_ENTITY.getR10_UMM_AL()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR10_FUJAIRAH().compareTo(up.getR10_FUJAIRAH()) != 0) {
			fieldNames.add("Fujairah");
			oldChange.append("R10_COL_12: ").append(up.getR10_FUJAIRAH()).append("; ");
			newChange.append("R10_COL_12: ").append(brf300_ENTITY.getR10_FUJAIRAH()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR10_ABU_SUB().compareTo(up.getR10_ABU_SUB()) != 0) {
			fieldNames.add("Abu Dhabi Sub-total (D+E+F+G)");
			oldChange.append("R10_COL_13: ").append(up.getR10_ABU_SUB()).append("; ");
			newChange.append("R10_COL_13: ").append(brf300_ENTITY.getR10_ABU_SUB()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR10_TOTAL().compareTo(up.getR10_TOTAL()) != 0) {
			fieldNames.add("Total");
			oldChange.append("R10_COL_14: ").append(up.getR10_TOTAL()).append("; ");
			newChange.append("R10_COL_14: ").append(brf300_ENTITY.getR10_TOTAL()).append("; ");
			rowEdited = true;
		}
		
		//Backoffice operations (call center, direct sales, operations, collections) function start
		
		if (brf300_ENTITY.getR12_S_NO().compareTo(up.getR12_S_NO()) != 0) {
			fieldNames.add("S.No");
			oldChange.append("R12_COL_1: ").append(up.getR12_S_NO()).append("; ");
			newChange.append("R12_COL_1: ").append(brf300_ENTITY.getR12_S_NO()).append("; ");
			rowEdited = true;
		}

		if (brf300_ENTITY.getR12_HEADQUATERS().compareTo(up.getR12_HEADQUATERS()) != 0) {
			fieldNames.add("Backoffice operations - No. of backoffice operations ");
			oldChange.append("R12_COL_2: ").append(up.getR12_HEADQUATERS()).append("; ");
			newChange.append("R12_COL_2: ").append(brf300_ENTITY.getR12_HEADQUATERS()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR12_ABU_DHABI().compareTo(up.getR12_ABU_DHABI()) != 0) {
			fieldNames.add("Abu Dhabi - Abu Dhabi City");
			oldChange.append("R12_COL_3: ").append(up.getR12_ABU_DHABI()).append("; ");
			newChange.append("R12_COL_3: ").append(brf300_ENTITY.getR12_ABU_DHABI()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR12_WESTERNM_REGION().compareTo(up.getR12_WESTERNM_REGION()) != 0) {
			fieldNames.add("Abu Dhabi - Western Region");
			oldChange.append("R12_COL_4: ").append(up.getR12_WESTERNM_REGION()).append("; ");
			newChange.append("R12_COL_4: ").append(brf300_ENTITY.getR12_WESTERNM_REGION()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR12_AL_AIN().compareTo(up.getR12_AL_AIN()) != 0) {
			fieldNames.add("Abu Dhabi - Al Ain");
			oldChange.append("R12_COL_5: ").append(up.getR12_AL_AIN()).append("; ");
			newChange.append("R12_COL_5: ").append(brf300_ENTITY.getR12_AL_AIN()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR12_ISLAND().compareTo(up.getR12_ISLAND()) != 0) {
			fieldNames.add("Abu Dhabi - Islands");
			oldChange.append("R12_COL_6: ").append(up.getR12_ISLAND()).append("; ");
			newChange.append("R12_COL_6: ").append(brf300_ENTITY.getR12_ISLAND()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR12_DUBAI().compareTo(up.getR12_DUBAI()) != 0) {
			fieldNames.add("Dubai");
			oldChange.append("R12_COL_7: ").append(up.getR12_DUBAI()).append("; ");
			newChange.append("R12_COL_7: ").append(brf300_ENTITY.getR12_DUBAI()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR12_SHARJAH().compareTo(up.getR12_SHARJAH()) != 0) {
			fieldNames.add("Sharjah");
			oldChange.append("R12_COL_8: ").append(up.getR12_SHARJAH()).append("; ");
			newChange.append("R12_COL_8: ").append(brf300_ENTITY.getR12_SHARJAH()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR12_AJMAN().compareTo(up.getR12_AJMAN()) != 0) {
			fieldNames.add("Ajman");
			oldChange.append("R12_COL_9: ").append(up.getR12_AJMAN()).append("; ");
			newChange.append("R12_COL_9: ").append(brf300_ENTITY.getR12_AJMAN()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR12_RAS_AL().compareTo(up.getR12_RAS_AL()) != 0) {
			fieldNames.add("Ras al-Khaimah");
			oldChange.append("R12_COL_10: ").append(up.getR12_RAS_AL()).append("; ");
			newChange.append("R12_COL_10: ").append(brf300_ENTITY.getR12_RAS_AL()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR12_UMM_AL().compareTo(up.getR12_UMM_AL()) != 0) {
			fieldNames.add("Umm al-Quwain");
			oldChange.append("R12_COL_11: ").append(up.getR12_UMM_AL()).append("; ");
			newChange.append("R12_COL_11: ").append(brf300_ENTITY.getR12_UMM_AL()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR12_FUJAIRAH().compareTo(up.getR12_FUJAIRAH()) != 0) {
			fieldNames.add("Fujairah");
			oldChange.append("R12_COL_12: ").append(up.getR12_FUJAIRAH()).append("; ");
			newChange.append("R12_COL_12: ").append(brf300_ENTITY.getR12_FUJAIRAH()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR12_ABU_SUB().compareTo(up.getR12_ABU_SUB()) != 0) {
			fieldNames.add("Abu Dhabi Sub-total (D+E+F+G)");
			oldChange.append("R12_COL_13: ").append(up.getR12_ABU_SUB()).append("; ");
			newChange.append("R12_COL_13: ").append(brf300_ENTITY.getR12_ABU_SUB()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR12_TOTAL().compareTo(up.getR12_TOTAL()) != 0) {
			fieldNames.add("Total");
			oldChange.append("R12_COL_14: ").append(up.getR12_TOTAL()).append("; ");
			newChange.append("R12_COL_14: ").append(brf300_ENTITY.getR12_TOTAL()).append("; ");
			rowEdited = true;
		}
		
		
		if (brf300_ENTITY.getR13_S_NO().compareTo(up.getR13_S_NO()) != 0) {
			fieldNames.add("S.No");
			oldChange.append("R13_COL_1: ").append(up.getR13_S_NO()).append("; ");
			newChange.append("R13_COL_1: ").append(brf300_ENTITY.getR13_S_NO()).append("; ");
			rowEdited = true;
		}

		if (brf300_ENTITY.getR13_HEADQUATERS().compareTo(up.getR13_HEADQUATERS()) != 0) {
			fieldNames.add("Backoffice operations - No. of employees in backoffice operations");
			oldChange.append("R13_COL_2: ").append(up.getR13_HEADQUATERS()).append("; ");
			newChange.append("R13_COL_2: ").append(brf300_ENTITY.getR13_HEADQUATERS()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR13_ABU_DHABI().compareTo(up.getR13_ABU_DHABI()) != 0) {
			fieldNames.add("Abu Dhabi - Abu Dhabi City");
			oldChange.append("R13_COL_3: ").append(up.getR13_ABU_DHABI()).append("; ");
			newChange.append("R13_COL_3: ").append(brf300_ENTITY.getR13_ABU_DHABI()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR13_WESTERNM_REGION().compareTo(up.getR13_WESTERNM_REGION()) != 0) {
			fieldNames.add("Abu Dhabi - Western Region");
			oldChange.append("R13_COL_4: ").append(up.getR13_WESTERNM_REGION()).append("; ");
			newChange.append("R13_COL_4: ").append(brf300_ENTITY.getR13_WESTERNM_REGION()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR13_AL_AIN().compareTo(up.getR13_AL_AIN()) != 0) {
			fieldNames.add("Abu Dhabi - Al Ain");
			oldChange.append("R13_COL_5: ").append(up.getR13_AL_AIN()).append("; ");
			newChange.append("R13_COL_5: ").append(brf300_ENTITY.getR13_AL_AIN()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR13_ISLAND().compareTo(up.getR13_ISLAND()) != 0) {
			fieldNames.add("Abu Dhabi - Islands");
			oldChange.append("R13_COL_6: ").append(up.getR13_ISLAND()).append("; ");
			newChange.append("R13_COL_6: ").append(brf300_ENTITY.getR13_ISLAND()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR13_DUBAI().compareTo(up.getR13_DUBAI()) != 0) {
			fieldNames.add("Dubai");
			oldChange.append("R13_COL_7: ").append(up.getR13_DUBAI()).append("; ");
			newChange.append("R13_COL_7: ").append(brf300_ENTITY.getR13_DUBAI()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR13_SHARJAH().compareTo(up.getR13_SHARJAH()) != 0) {
			fieldNames.add("Sharjah");
			oldChange.append("R13_COL_8: ").append(up.getR13_SHARJAH()).append("; ");
			newChange.append("R13_COL_8: ").append(brf300_ENTITY.getR13_SHARJAH()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR13_AJMAN().compareTo(up.getR13_AJMAN()) != 0) {
			fieldNames.add("Ajman");
			oldChange.append("R13_COL_9: ").append(up.getR13_AJMAN()).append("; ");
			newChange.append("R13_COL_9: ").append(brf300_ENTITY.getR13_AJMAN()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR13_RAS_AL().compareTo(up.getR13_RAS_AL()) != 0) {
			fieldNames.add("Ras al-Khaimah");
			oldChange.append("R13_COL_10: ").append(up.getR13_RAS_AL()).append("; ");
			newChange.append("R13_COL_10: ").append(brf300_ENTITY.getR13_RAS_AL()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR13_UMM_AL().compareTo(up.getR13_UMM_AL()) != 0) {
			fieldNames.add("Umm al-Quwain");
			oldChange.append("R13_COL_11: ").append(up.getR13_UMM_AL()).append("; ");
			newChange.append("R13_COL_11: ").append(brf300_ENTITY.getR13_UMM_AL()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR13_FUJAIRAH().compareTo(up.getR13_FUJAIRAH()) != 0) {
			fieldNames.add("Fujairah");
			oldChange.append("R13_COL_12: ").append(up.getR13_FUJAIRAH()).append("; ");
			newChange.append("R13_COL_12: ").append(brf300_ENTITY.getR13_FUJAIRAH()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR13_ABU_SUB().compareTo(up.getR13_ABU_SUB()) != 0) {
			fieldNames.add("Abu Dhabi Sub-total (D+E+F+G)");
			oldChange.append("R13_COL_13: ").append(up.getR13_ABU_SUB()).append("; ");
			newChange.append("R13_COL_13: ").append(brf300_ENTITY.getR13_ABU_SUB()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR13_TOTAL().compareTo(up.getR13_TOTAL()) != 0) {
			fieldNames.add("Total");
			oldChange.append("R13_COL_14: ").append(up.getR13_TOTAL()).append("; ");
			newChange.append("R13_COL_14: ").append(brf300_ENTITY.getR13_TOTAL()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR14_S_NO().compareTo(up.getR14_S_NO()) != 0) {
			fieldNames.add("S.No");
			oldChange.append("R14_COL_1: ").append(up.getR14_S_NO()).append("; ");
			newChange.append("R14_COL_1: ").append(brf300_ENTITY.getR14_S_NO()).append("; ");
			rowEdited = true;
		}

		if (brf300_ENTITY.getR14_HEADQUATERS().compareTo(up.getR14_HEADQUATERS()) != 0) {
			fieldNames.add("Backoffice operations - No. of Nationals in backoffice operations");
			oldChange.append("R14_COL_2: ").append(up.getR14_HEADQUATERS()).append("; ");
			newChange.append("R14_COL_2: ").append(brf300_ENTITY.getR14_HEADQUATERS()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR14_ABU_DHABI().compareTo(up.getR14_ABU_DHABI()) != 0) {
			fieldNames.add("Abu Dhabi - Abu Dhabi City");
			oldChange.append("R14_COL_3: ").append(up.getR14_ABU_DHABI()).append("; ");
			newChange.append("R14_COL_3: ").append(brf300_ENTITY.getR14_ABU_DHABI()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR14_WESTERNM_REGION().compareTo(up.getR14_WESTERNM_REGION()) != 0) {
			fieldNames.add("Abu Dhabi - Western Region");
			oldChange.append("R14_COL_4: ").append(up.getR14_WESTERNM_REGION()).append("; ");
			newChange.append("R14_COL_4: ").append(brf300_ENTITY.getR14_WESTERNM_REGION()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR14_AL_AIN().compareTo(up.getR14_AL_AIN()) != 0) {
			fieldNames.add("Abu Dhabi - Al Ain");
			oldChange.append("R14_COL_5: ").append(up.getR14_AL_AIN()).append("; ");
			newChange.append("R14_COL_5: ").append(brf300_ENTITY.getR14_AL_AIN()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR14_ISLAND().compareTo(up.getR14_ISLAND()) != 0) {
			fieldNames.add("Abu Dhabi - Islands");
			oldChange.append("R14_COL_6: ").append(up.getR14_ISLAND()).append("; ");
			newChange.append("R14_COL_6: ").append(brf300_ENTITY.getR14_ISLAND()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR14_DUBAI().compareTo(up.getR14_DUBAI()) != 0) {
			fieldNames.add("Dubai");
			oldChange.append("R14_COL_7: ").append(up.getR14_DUBAI()).append("; ");
			newChange.append("R14_COL_7: ").append(brf300_ENTITY.getR14_DUBAI()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR14_SHARJAH().compareTo(up.getR14_SHARJAH()) != 0) {
			fieldNames.add("Sharjah");
			oldChange.append("R14_COL_8: ").append(up.getR14_SHARJAH()).append("; ");
			newChange.append("R14_COL_8: ").append(brf300_ENTITY.getR14_SHARJAH()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR14_AJMAN().compareTo(up.getR14_AJMAN()) != 0) {
			fieldNames.add("Ajman");
			oldChange.append("R14_COL_9: ").append(up.getR14_AJMAN()).append("; ");
			newChange.append("R14_COL_9: ").append(brf300_ENTITY.getR14_AJMAN()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR14_RAS_AL().compareTo(up.getR14_RAS_AL()) != 0) {
			fieldNames.add("Ras al-Khaimah");
			oldChange.append("R14_COL_10: ").append(up.getR14_RAS_AL()).append("; ");
			newChange.append("R14_COL_10: ").append(brf300_ENTITY.getR14_RAS_AL()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR14_UMM_AL().compareTo(up.getR14_UMM_AL()) != 0) {
			fieldNames.add("Umm al-Quwain");
			oldChange.append("R14_COL_11: ").append(up.getR14_UMM_AL()).append("; ");
			newChange.append("R14_COL_11: ").append(brf300_ENTITY.getR14_UMM_AL()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR14_FUJAIRAH().compareTo(up.getR14_FUJAIRAH()) != 0) {
			fieldNames.add("Fujairah");
			oldChange.append("R14_COL_12: ").append(up.getR14_FUJAIRAH()).append("; ");
			newChange.append("R14_COL_12: ").append(brf300_ENTITY.getR14_FUJAIRAH()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR14_ABU_SUB().compareTo(up.getR14_ABU_SUB()) != 0) {
			fieldNames.add("Abu Dhabi Sub-total (D+E+F+G)");
			oldChange.append("R14_COL_13: ").append(up.getR14_ABU_SUB()).append("; ");
			newChange.append("R14_COL_13: ").append(brf300_ENTITY.getR14_ABU_SUB()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR14_TOTAL().compareTo(up.getR14_TOTAL()) != 0) {
			fieldNames.add("Total");
			oldChange.append("R14_COL_14: ").append(up.getR14_TOTAL()).append("; ");
			newChange.append("R14_COL_14: ").append(brf300_ENTITY.getR14_TOTAL()).append("; ");
			rowEdited = true;
		}

		
		if (brf300_ENTITY.getR15_S_NO().compareTo(up.getR15_S_NO()) != 0) {
			fieldNames.add("S.No");
			oldChange.append("R15_COL_1: ").append(up.getR15_S_NO()).append("; ");
			newChange.append("R15_COL_1: ").append(brf300_ENTITY.getR15_S_NO()).append("; ");
			rowEdited = true;
		}

		if (brf300_ENTITY.getR15_HEADQUATERS().compareTo(up.getR15_HEADQUATERS()) != 0) {
			fieldNames.add("Backoffice operations - No. of Nationals Female in backoffice operations");
			oldChange.append("R15_COL_2: ").append(up.getR15_HEADQUATERS()).append("; ");
			newChange.append("R15_COL_2: ").append(brf300_ENTITY.getR15_HEADQUATERS()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR15_ABU_DHABI().compareTo(up.getR15_ABU_DHABI()) != 0) {
			fieldNames.add("Abu Dhabi - Abu Dhabi City");
			oldChange.append("R15_COL_3: ").append(up.getR15_ABU_DHABI()).append("; ");
			newChange.append("R15_COL_3: ").append(brf300_ENTITY.getR15_ABU_DHABI()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR15_WESTERNM_REGION().compareTo(up.getR15_WESTERNM_REGION()) != 0) {
			fieldNames.add("Abu Dhabi - Western Region");
			oldChange.append("R15_COL_4: ").append(up.getR15_WESTERNM_REGION()).append("; ");
			newChange.append("R15_COL_4: ").append(brf300_ENTITY.getR15_WESTERNM_REGION()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR15_AL_AIN().compareTo(up.getR15_AL_AIN()) != 0) {
			fieldNames.add("Abu Dhabi - Al Ain");
			oldChange.append("R15_COL_5: ").append(up.getR15_AL_AIN()).append("; ");
			newChange.append("R15_COL_5: ").append(brf300_ENTITY.getR15_AL_AIN()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR15_ISLAND().compareTo(up.getR15_ISLAND()) != 0) {
			fieldNames.add("Abu Dhabi - Islands");
			oldChange.append("R15_COL_6: ").append(up.getR15_ISLAND()).append("; ");
			newChange.append("R15_COL_6: ").append(brf300_ENTITY.getR15_ISLAND()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR15_DUBAI().compareTo(up.getR15_DUBAI()) != 0) {
			fieldNames.add("Dubai");
			oldChange.append("R15_COL_7: ").append(up.getR15_DUBAI()).append("; ");
			newChange.append("R15_COL_7: ").append(brf300_ENTITY.getR15_DUBAI()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR15_SHARJAH().compareTo(up.getR15_SHARJAH()) != 0) {
			fieldNames.add("Sharjah");
			oldChange.append("R15_COL_8: ").append(up.getR15_SHARJAH()).append("; ");
			newChange.append("R15_COL_8: ").append(brf300_ENTITY.getR15_SHARJAH()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR15_AJMAN().compareTo(up.getR15_AJMAN()) != 0) {
			fieldNames.add("Ajman");
			oldChange.append("R15_COL_9: ").append(up.getR15_AJMAN()).append("; ");
			newChange.append("R15_COL_9: ").append(brf300_ENTITY.getR15_AJMAN()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR15_RAS_AL().compareTo(up.getR15_RAS_AL()) != 0) {
			fieldNames.add("Ras al-Khaimah");
			oldChange.append("R15_COL_10: ").append(up.getR15_RAS_AL()).append("; ");
			newChange.append("R15_COL_10: ").append(brf300_ENTITY.getR15_RAS_AL()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR15_UMM_AL().compareTo(up.getR15_UMM_AL()) != 0) {
			fieldNames.add("Umm al-Quwain");
			oldChange.append("R15_COL_11: ").append(up.getR15_UMM_AL()).append("; ");
			newChange.append("R15_COL_11: ").append(brf300_ENTITY.getR15_UMM_AL()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR15_FUJAIRAH().compareTo(up.getR15_FUJAIRAH()) != 0) {
			fieldNames.add("Fujairah");
			oldChange.append("R15_COL_12: ").append(up.getR15_FUJAIRAH()).append("; ");
			newChange.append("R15_COL_12: ").append(brf300_ENTITY.getR15_FUJAIRAH()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR15_ABU_SUB().compareTo(up.getR15_ABU_SUB()) != 0) {
			fieldNames.add("Abu Dhabi Sub-total (D+E+F+G)");
			oldChange.append("R15_COL_13: ").append(up.getR15_ABU_SUB()).append("; ");
			newChange.append("R15_COL_13: ").append(brf300_ENTITY.getR15_ABU_SUB()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR15_TOTAL().compareTo(up.getR15_TOTAL()) != 0) {
			fieldNames.add("Total");
			oldChange.append("R15_COL_14: ").append(up.getR15_TOTAL()).append("; ");
			newChange.append("R15_COL_14: ").append(brf300_ENTITY.getR15_TOTAL()).append("; ");
			rowEdited = true;
		}
		
		//Support Services (HR, IT, Legal,etc.) function start
		
		if (brf300_ENTITY.getR17_S_NO().compareTo(up.getR17_S_NO()) != 0) {
			fieldNames.add("S.No");
			oldChange.append("R17_COL_1: ").append(up.getR17_S_NO()).append("; ");
			newChange.append("R17_COL_1: ").append(brf300_ENTITY.getR17_S_NO()).append("; ");
			rowEdited = true;
		}

		if (brf300_ENTITY.getR17_HEADQUATERS().compareTo(up.getR17_HEADQUATERS()) != 0) {
			fieldNames.add("Support Services  - No. of employees in Support Services");
			oldChange.append("R17_COL_2: ").append(up.getR17_HEADQUATERS()).append("; ");
			newChange.append("R17_COL_2: ").append(brf300_ENTITY.getR17_HEADQUATERS()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR17_ABU_DHABI().compareTo(up.getR17_ABU_DHABI()) != 0) {
			fieldNames.add("Abu Dhabi - Abu Dhabi City");
			oldChange.append("R17_COL_3: ").append(up.getR17_ABU_DHABI()).append("; ");
			newChange.append("R17_COL_3: ").append(brf300_ENTITY.getR17_ABU_DHABI()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR17_WESTERNM_REGION().compareTo(up.getR17_WESTERNM_REGION()) != 0) {
			fieldNames.add("Abu Dhabi - Western Region");
			oldChange.append("R17_COL_4: ").append(up.getR17_WESTERNM_REGION()).append("; ");
			newChange.append("R17_COL_4: ").append(brf300_ENTITY.getR17_WESTERNM_REGION()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR17_AL_AIN().compareTo(up.getR17_AL_AIN()) != 0) {
			fieldNames.add("Abu Dhabi - Al Ain");
			oldChange.append("R17_COL_5: ").append(up.getR17_AL_AIN()).append("; ");
			newChange.append("R17_COL_5: ").append(brf300_ENTITY.getR17_AL_AIN()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR17_ISLAND().compareTo(up.getR17_ISLAND()) != 0) {
			fieldNames.add("Abu Dhabi - Islands");
			oldChange.append("R17_COL_6: ").append(up.getR17_ISLAND()).append("; ");
			newChange.append("R17_COL_6: ").append(brf300_ENTITY.getR17_ISLAND()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR17_DUBAI().compareTo(up.getR17_DUBAI()) != 0) {
			fieldNames.add("Dubai");
			oldChange.append("R17_COL_7: ").append(up.getR17_DUBAI()).append("; ");
			newChange.append("R17_COL_7: ").append(brf300_ENTITY.getR17_DUBAI()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR17_SHARJAH().compareTo(up.getR17_SHARJAH()) != 0) {
			fieldNames.add("Sharjah");
			oldChange.append("R17_COL_8: ").append(up.getR17_SHARJAH()).append("; ");
			newChange.append("R17_COL_8: ").append(brf300_ENTITY.getR17_SHARJAH()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR17_AJMAN().compareTo(up.getR17_AJMAN()) != 0) {
			fieldNames.add("Ajman");
			oldChange.append("R17_COL_9: ").append(up.getR17_AJMAN()).append("; ");
			newChange.append("R17_COL_9: ").append(brf300_ENTITY.getR17_AJMAN()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR17_RAS_AL().compareTo(up.getR17_RAS_AL()) != 0) {
			fieldNames.add("Ras al-Khaimah");
			oldChange.append("R17_COL_10: ").append(up.getR17_RAS_AL()).append("; ");
			newChange.append("R17_COL_10: ").append(brf300_ENTITY.getR17_RAS_AL()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR17_UMM_AL().compareTo(up.getR17_UMM_AL()) != 0) {
			fieldNames.add("Umm al-Quwain");
			oldChange.append("R17_COL_11: ").append(up.getR17_UMM_AL()).append("; ");
			newChange.append("R17_COL_11: ").append(brf300_ENTITY.getR17_UMM_AL()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR17_FUJAIRAH().compareTo(up.getR17_FUJAIRAH()) != 0) {
			fieldNames.add("Fujairah");
			oldChange.append("R17_COL_12: ").append(up.getR17_FUJAIRAH()).append("; ");
			newChange.append("R17_COL_12: ").append(brf300_ENTITY.getR17_FUJAIRAH()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR17_ABU_SUB().compareTo(up.getR17_ABU_SUB()) != 0) {
			fieldNames.add("Abu Dhabi Sub-total (D+E+F+G)");
			oldChange.append("R17_COL_13: ").append(up.getR17_ABU_SUB()).append("; ");
			newChange.append("R17_COL_13: ").append(brf300_ENTITY.getR17_ABU_SUB()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR17_TOTAL().compareTo(up.getR17_TOTAL()) != 0) {
			fieldNames.add("Total");
			oldChange.append("R17_COL_14: ").append(up.getR17_TOTAL()).append("; ");
			newChange.append("R17_COL_14: ").append(brf300_ENTITY.getR17_TOTAL()).append("; ");
			rowEdited = true;
		}
		
		
		if (brf300_ENTITY.getR18_S_NO().compareTo(up.getR18_S_NO()) != 0) {
			fieldNames.add("S.No");
			oldChange.append("R18_COL_1: ").append(up.getR18_S_NO()).append("; ");
			newChange.append("R18_COL_1: ").append(brf300_ENTITY.getR18_S_NO()).append("; ");
			rowEdited = true;
		}

		if (brf300_ENTITY.getR18_HEADQUATERS().compareTo(up.getR18_HEADQUATERS()) != 0) {
			fieldNames.add("Support Services  - No. of Nationals in Support Services");
			oldChange.append("R18_COL_2: ").append(up.getR18_HEADQUATERS()).append("; ");
			newChange.append("R18_COL_2: ").append(brf300_ENTITY.getR18_HEADQUATERS()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR18_ABU_DHABI().compareTo(up.getR18_ABU_DHABI()) != 0) {
			fieldNames.add("Abu Dhabi - Abu Dhabi City");
			oldChange.append("R18_COL_3: ").append(up.getR18_ABU_DHABI()).append("; ");
			newChange.append("R18_COL_3: ").append(brf300_ENTITY.getR18_ABU_DHABI()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR18_WESTERNM_REGION().compareTo(up.getR18_WESTERNM_REGION()) != 0) {
			fieldNames.add("Abu Dhabi - Western Region");
			oldChange.append("R18_COL_4: ").append(up.getR18_WESTERNM_REGION()).append("; ");
			newChange.append("R18_COL_4: ").append(brf300_ENTITY.getR18_WESTERNM_REGION()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR18_AL_AIN().compareTo(up.getR18_AL_AIN()) != 0) {
			fieldNames.add("Abu Dhabi - Al Ain");
			oldChange.append("R18_COL_5: ").append(up.getR18_AL_AIN()).append("; ");
			newChange.append("R18_COL_5: ").append(brf300_ENTITY.getR18_AL_AIN()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR18_ISLAND().compareTo(up.getR18_ISLAND()) != 0) {
			fieldNames.add("Abu Dhabi - Islands");
			oldChange.append("R18_COL_6: ").append(up.getR18_ISLAND()).append("; ");
			newChange.append("R18_COL_6: ").append(brf300_ENTITY.getR18_ISLAND()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR18_DUBAI().compareTo(up.getR18_DUBAI()) != 0) {
			fieldNames.add("Dubai");
			oldChange.append("R18_COL_7: ").append(up.getR18_DUBAI()).append("; ");
			newChange.append("R18_COL_7: ").append(brf300_ENTITY.getR18_DUBAI()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR18_SHARJAH().compareTo(up.getR18_SHARJAH()) != 0) {
			fieldNames.add("Sharjah");
			oldChange.append("R18_COL_8: ").append(up.getR18_SHARJAH()).append("; ");
			newChange.append("R18_COL_8: ").append(brf300_ENTITY.getR18_SHARJAH()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR18_AJMAN().compareTo(up.getR18_AJMAN()) != 0) {
			fieldNames.add("Ajman");
			oldChange.append("R18_COL_9: ").append(up.getR18_AJMAN()).append("; ");
			newChange.append("R18_COL_9: ").append(brf300_ENTITY.getR18_AJMAN()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR18_RAS_AL().compareTo(up.getR18_RAS_AL()) != 0) {
			fieldNames.add("Ras al-Khaimah");
			oldChange.append("R18_COL_10: ").append(up.getR18_RAS_AL()).append("; ");
			newChange.append("R18_COL_10: ").append(brf300_ENTITY.getR18_RAS_AL()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR18_UMM_AL().compareTo(up.getR18_UMM_AL()) != 0) {
			fieldNames.add("Umm al-Quwain");
			oldChange.append("R18_COL_11: ").append(up.getR18_UMM_AL()).append("; ");
			newChange.append("R18_COL_11: ").append(brf300_ENTITY.getR18_UMM_AL()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR18_FUJAIRAH().compareTo(up.getR18_FUJAIRAH()) != 0) {
			fieldNames.add("Fujairah");
			oldChange.append("R18_COL_12: ").append(up.getR18_FUJAIRAH()).append("; ");
			newChange.append("R18_COL_12: ").append(brf300_ENTITY.getR18_FUJAIRAH()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR18_ABU_SUB().compareTo(up.getR18_ABU_SUB()) != 0) {
			fieldNames.add("Abu Dhabi Sub-total (D+E+F+G)");
			oldChange.append("R18_COL_13: ").append(up.getR18_ABU_SUB()).append("; ");
			newChange.append("R18_COL_13: ").append(brf300_ENTITY.getR18_ABU_SUB()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR18_TOTAL().compareTo(up.getR18_TOTAL()) != 0) {
			fieldNames.add("Total");
			oldChange.append("R18_COL_14: ").append(up.getR18_TOTAL()).append("; ");
			newChange.append("R18_COL_14: ").append(brf300_ENTITY.getR18_TOTAL()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR19_S_NO().compareTo(up.getR19_S_NO()) != 0) {
			fieldNames.add("S.No");
			oldChange.append("R19_COL_1: ").append(up.getR19_S_NO()).append("; ");
			newChange.append("R19_COL_1: ").append(brf300_ENTITY.getR19_S_NO()).append("; ");
			rowEdited = true;
		}

		if (brf300_ENTITY.getR19_HEADQUATERS().compareTo(up.getR19_HEADQUATERS()) != 0) {
			fieldNames.add("Support Services  - No. of Nationals Female in Support Services");
			oldChange.append("R19_COL_2: ").append(up.getR19_HEADQUATERS()).append("; ");
			newChange.append("R19_COL_2: ").append(brf300_ENTITY.getR19_HEADQUATERS()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR19_ABU_DHABI().compareTo(up.getR19_ABU_DHABI()) != 0) {
			fieldNames.add("Abu Dhabi - Abu Dhabi City");
			oldChange.append("R19_COL_3: ").append(up.getR19_ABU_DHABI()).append("; ");
			newChange.append("R19_COL_3: ").append(brf300_ENTITY.getR19_ABU_DHABI()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR19_WESTERNM_REGION().compareTo(up.getR19_WESTERNM_REGION()) != 0) {
			fieldNames.add("Abu Dhabi - Western Region");
			oldChange.append("R19_COL_4: ").append(up.getR19_WESTERNM_REGION()).append("; ");
			newChange.append("R19_COL_4: ").append(brf300_ENTITY.getR19_WESTERNM_REGION()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR19_AL_AIN().compareTo(up.getR19_AL_AIN()) != 0) {
			fieldNames.add("Abu Dhabi - Al Ain");
			oldChange.append("R19_COL_5: ").append(up.getR19_AL_AIN()).append("; ");
			newChange.append("R19_COL_5: ").append(brf300_ENTITY.getR19_AL_AIN()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR19_ISLAND().compareTo(up.getR19_ISLAND()) != 0) {
			fieldNames.add("Abu Dhabi - Islands");
			oldChange.append("R19_COL_6: ").append(up.getR19_ISLAND()).append("; ");
			newChange.append("R19_COL_6: ").append(brf300_ENTITY.getR19_ISLAND()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR19_DUBAI().compareTo(up.getR19_DUBAI()) != 0) {
			fieldNames.add("Dubai");
			oldChange.append("R19_COL_7: ").append(up.getR19_DUBAI()).append("; ");
			newChange.append("R19_COL_7: ").append(brf300_ENTITY.getR19_DUBAI()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR19_SHARJAH().compareTo(up.getR19_SHARJAH()) != 0) {
			fieldNames.add("Sharjah");
			oldChange.append("R19_COL_8: ").append(up.getR19_SHARJAH()).append("; ");
			newChange.append("R19_COL_8: ").append(brf300_ENTITY.getR19_SHARJAH()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR19_AJMAN().compareTo(up.getR19_AJMAN()) != 0) {
			fieldNames.add("Ajman");
			oldChange.append("R19_COL_9: ").append(up.getR19_AJMAN()).append("; ");
			newChange.append("R19_COL_9: ").append(brf300_ENTITY.getR19_AJMAN()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR19_RAS_AL().compareTo(up.getR19_RAS_AL()) != 0) {
			fieldNames.add("Ras al-Khaimah");
			oldChange.append("R19_COL_10: ").append(up.getR19_RAS_AL()).append("; ");
			newChange.append("R19_COL_10: ").append(brf300_ENTITY.getR19_RAS_AL()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR19_UMM_AL().compareTo(up.getR19_UMM_AL()) != 0) {
			fieldNames.add("Umm al-Quwain");
			oldChange.append("R19_COL_11: ").append(up.getR19_UMM_AL()).append("; ");
			newChange.append("R19_COL_11: ").append(brf300_ENTITY.getR19_UMM_AL()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR19_FUJAIRAH().compareTo(up.getR19_FUJAIRAH()) != 0) {
			fieldNames.add("Fujairah");
			oldChange.append("R19_COL_12: ").append(up.getR19_FUJAIRAH()).append("; ");
			newChange.append("R19_COL_12: ").append(brf300_ENTITY.getR19_FUJAIRAH()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR19_ABU_SUB().compareTo(up.getR19_ABU_SUB()) != 0) {
			fieldNames.add("Abu Dhabi Sub-total (D+E+F+G)");
			oldChange.append("R19_COL_13: ").append(up.getR19_ABU_SUB()).append("; ");
			newChange.append("R19_COL_13: ").append(brf300_ENTITY.getR19_ABU_SUB()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR19_TOTAL().compareTo(up.getR19_TOTAL()) != 0) {
			fieldNames.add("Total");
			oldChange.append("R19_COL_14: ").append(up.getR19_TOTAL()).append("; ");
			newChange.append("R19_COL_14: ").append(brf300_ENTITY.getR19_TOTAL()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR20_S_NO().compareTo(up.getR20_S_NO()) != 0) {
			fieldNames.add("S.No");
			oldChange.append("R20_COL_1: ").append(up.getR20_S_NO()).append("; ");
			newChange.append("R20_COL_1: ").append(brf300_ENTITY.getR20_S_NO()).append("; ");
			rowEdited = true;
		}

		if (brf300_ENTITY.getR20_HEADQUATERS().compareTo(up.getR20_HEADQUATERS()) != 0) {
			fieldNames.add("Support Services - Blocked - Reserved Cells (Future Use)");
			oldChange.append("R20_COL_2: ").append(up.getR20_HEADQUATERS()).append("; ");
			newChange.append("R20_COL_2: ").append(brf300_ENTITY.getR20_HEADQUATERS()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR20_ABU_DHABI().compareTo(up.getR20_ABU_DHABI()) != 0) {
			fieldNames.add("Abu Dhabi - Abu Dhabi City");
			oldChange.append("R20_COL_3: ").append(up.getR20_ABU_DHABI()).append("; ");
			newChange.append("R20_COL_3: ").append(brf300_ENTITY.getR20_ABU_DHABI()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR20_WESTERNM_REGION().compareTo(up.getR20_WESTERNM_REGION()) != 0) {
			fieldNames.add("Abu Dhabi - Western Region");
			oldChange.append("R20_COL_4: ").append(up.getR20_WESTERNM_REGION()).append("; ");
			newChange.append("R20_COL_4: ").append(brf300_ENTITY.getR20_WESTERNM_REGION()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR20_AL_AIN().compareTo(up.getR20_AL_AIN()) != 0) {
			fieldNames.add("Abu Dhabi - Al Ain");
			oldChange.append("R20_COL_5: ").append(up.getR20_AL_AIN()).append("; ");
			newChange.append("R20_COL_5: ").append(brf300_ENTITY.getR20_AL_AIN()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR20_ISLAND().compareTo(up.getR20_ISLAND()) != 0) {
			fieldNames.add("Abu Dhabi - Islands");
			oldChange.append("R20_COL_6: ").append(up.getR20_ISLAND()).append("; ");
			newChange.append("R20_COL_6: ").append(brf300_ENTITY.getR20_ISLAND()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR20_DUBAI().compareTo(up.getR20_DUBAI()) != 0) {
			fieldNames.add("Dubai");
			oldChange.append("R20_COL_7: ").append(up.getR20_DUBAI()).append("; ");
			newChange.append("R20_COL_7: ").append(brf300_ENTITY.getR20_DUBAI()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR20_SHARJAH().compareTo(up.getR20_SHARJAH()) != 0) {
			fieldNames.add("Sharjah");
			oldChange.append("R20_COL_8: ").append(up.getR20_SHARJAH()).append("; ");
			newChange.append("R20_COL_8: ").append(brf300_ENTITY.getR20_SHARJAH()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR20_AJMAN().compareTo(up.getR20_AJMAN()) != 0) {
			fieldNames.add("Ajman");
			oldChange.append("R20_COL_9: ").append(up.getR20_AJMAN()).append("; ");
			newChange.append("R20_COL_9: ").append(brf300_ENTITY.getR20_AJMAN()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR20_RAS_AL().compareTo(up.getR20_RAS_AL()) != 0) {
			fieldNames.add("Ras al-Khaimah");
			oldChange.append("R20_COL_10: ").append(up.getR20_RAS_AL()).append("; ");
			newChange.append("R20_COL_10: ").append(brf300_ENTITY.getR20_RAS_AL()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR20_UMM_AL().compareTo(up.getR20_UMM_AL()) != 0) {
			fieldNames.add("Umm al-Quwain");
			oldChange.append("R20_COL_11: ").append(up.getR20_UMM_AL()).append("; ");
			newChange.append("R20_COL_11: ").append(brf300_ENTITY.getR20_UMM_AL()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR20_FUJAIRAH().compareTo(up.getR20_FUJAIRAH()) != 0) {
			fieldNames.add("Fujairah");
			oldChange.append("R20_COL_12: ").append(up.getR20_FUJAIRAH()).append("; ");
			newChange.append("R20_COL_12: ").append(brf300_ENTITY.getR20_FUJAIRAH()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR20_ABU_SUB().compareTo(up.getR20_ABU_SUB()) != 0) {
			fieldNames.add("Abu Dhabi Sub-total (D+E+F+G)");
			oldChange.append("R20_COL_13: ").append(up.getR20_ABU_SUB()).append("; ");
			newChange.append("R20_COL_13: ").append(brf300_ENTITY.getR20_ABU_SUB()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR20_TOTAL().compareTo(up.getR20_TOTAL()) != 0) {
			fieldNames.add("Total");
			oldChange.append("R20_COL_14: ").append(up.getR20_TOTAL()).append("; ");
			newChange.append("R20_COL_14: ").append(brf300_ENTITY.getR20_TOTAL()).append("; ");
			rowEdited = true;
		}
		
		
		//Additional details function start
		
		if (brf300_ENTITY.getR22_S_NO().compareTo(up.getR22_S_NO()) != 0) {
			fieldNames.add("S.No");
			oldChange.append("R22_COL_1: ").append(up.getR22_S_NO()).append("; ");
			newChange.append("R22_COL_1: ").append(brf300_ENTITY.getR22_S_NO()).append("; ");
			rowEdited = true;
		}

		if (brf300_ENTITY.getR22_HEADQUATERS().compareTo(up.getR22_HEADQUATERS()) != 0) {
			fieldNames.add("Additional details - No. of employees as Non-managerial staff ");
			oldChange.append("R22_COL_2: ").append(up.getR22_HEADQUATERS()).append("; ");
			newChange.append("R22_COL_2: ").append(brf300_ENTITY.getR22_HEADQUATERS()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR22_ABU_DHABI().compareTo(up.getR22_ABU_DHABI()) != 0) {
			fieldNames.add("Abu Dhabi - Abu Dhabi City");
			oldChange.append("R22_COL_3: ").append(up.getR22_ABU_DHABI()).append("; ");
			newChange.append("R22_COL_3: ").append(brf300_ENTITY.getR22_ABU_DHABI()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR22_WESTERNM_REGION().compareTo(up.getR22_WESTERNM_REGION()) != 0) {
			fieldNames.add("Abu Dhabi - Western Region");
			oldChange.append("R22_COL_4: ").append(up.getR22_WESTERNM_REGION()).append("; ");
			newChange.append("R22_COL_4: ").append(brf300_ENTITY.getR22_WESTERNM_REGION()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR22_AL_AIN().compareTo(up.getR22_AL_AIN()) != 0) {
			fieldNames.add("Abu Dhabi - Al Ain");
			oldChange.append("R22_COL_5: ").append(up.getR22_AL_AIN()).append("; ");
			newChange.append("R22_COL_5: ").append(brf300_ENTITY.getR22_AL_AIN()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR22_ISLAND().compareTo(up.getR22_ISLAND()) != 0) {
			fieldNames.add("Abu Dhabi - Islands");
			oldChange.append("R22_COL_6: ").append(up.getR22_ISLAND()).append("; ");
			newChange.append("R22_COL_6: ").append(brf300_ENTITY.getR22_ISLAND()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR22_DUBAI().compareTo(up.getR22_DUBAI()) != 0) {
			fieldNames.add("Dubai");
			oldChange.append("R22_COL_7: ").append(up.getR22_DUBAI()).append("; ");
			newChange.append("R22_COL_7: ").append(brf300_ENTITY.getR22_DUBAI()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR22_SHARJAH().compareTo(up.getR22_SHARJAH()) != 0) {
			fieldNames.add("Sharjah");
			oldChange.append("R22_COL_8: ").append(up.getR22_SHARJAH()).append("; ");
			newChange.append("R22_COL_8: ").append(brf300_ENTITY.getR22_SHARJAH()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR22_AJMAN().compareTo(up.getR22_AJMAN()) != 0) {
			fieldNames.add("Ajman");
			oldChange.append("R22_COL_9: ").append(up.getR22_AJMAN()).append("; ");
			newChange.append("R22_COL_9: ").append(brf300_ENTITY.getR22_AJMAN()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR22_RAS_AL().compareTo(up.getR22_RAS_AL()) != 0) {
			fieldNames.add("Ras al-Khaimah");
			oldChange.append("R22_COL_10: ").append(up.getR22_RAS_AL()).append("; ");
			newChange.append("R22_COL_10: ").append(brf300_ENTITY.getR22_RAS_AL()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR22_UMM_AL().compareTo(up.getR22_UMM_AL()) != 0) {
			fieldNames.add("Umm al-Quwain");
			oldChange.append("R22_COL_11: ").append(up.getR22_UMM_AL()).append("; ");
			newChange.append("R22_COL_11: ").append(brf300_ENTITY.getR22_UMM_AL()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR22_FUJAIRAH().compareTo(up.getR22_FUJAIRAH()) != 0) {
			fieldNames.add("Fujairah");
			oldChange.append("R22_COL_12: ").append(up.getR22_FUJAIRAH()).append("; ");
			newChange.append("R22_COL_12: ").append(brf300_ENTITY.getR22_FUJAIRAH()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR22_ABU_SUB().compareTo(up.getR22_ABU_SUB()) != 0) {
			fieldNames.add("Abu Dhabi Sub-total (D+E+F+G)");
			oldChange.append("R22_COL_13: ").append(up.getR22_ABU_SUB()).append("; ");
			newChange.append("R22_COL_13: ").append(brf300_ENTITY.getR22_ABU_SUB()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR22_TOTAL().compareTo(up.getR22_TOTAL()) != 0) {
			fieldNames.add("Total");
			oldChange.append("R22_COL_14: ").append(up.getR22_TOTAL()).append("; ");
			newChange.append("R22_COL_14: ").append(brf300_ENTITY.getR22_TOTAL()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR23_S_NO().compareTo(up.getR23_S_NO()) != 0) {
			fieldNames.add("S.No");
			oldChange.append("R23_COL_1: ").append(up.getR23_S_NO()).append("; ");
			newChange.append("R23_COL_1: ").append(brf300_ENTITY.getR23_S_NO()).append("; ");
			rowEdited = true;
		}

		if (brf300_ENTITY.getR23_HEADQUATERS().compareTo(up.getR23_HEADQUATERS()) != 0) {
			fieldNames.add("Additional details - No. of National employees as Non-managerial staff ");
			oldChange.append("R23_COL_2: ").append(up.getR23_HEADQUATERS()).append("; ");
			newChange.append("R23_COL_2: ").append(brf300_ENTITY.getR23_HEADQUATERS()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR23_ABU_DHABI().compareTo(up.getR23_ABU_DHABI()) != 0) {
			fieldNames.add("Abu Dhabi - Abu Dhabi City");
			oldChange.append("R23_COL_3: ").append(up.getR23_ABU_DHABI()).append("; ");
			newChange.append("R23_COL_3: ").append(brf300_ENTITY.getR23_ABU_DHABI()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR23_WESTERNM_REGION().compareTo(up.getR23_WESTERNM_REGION()) != 0) {
			fieldNames.add("Abu Dhabi - Western Region");
			oldChange.append("R23_COL_4: ").append(up.getR23_WESTERNM_REGION()).append("; ");
			newChange.append("R23_COL_4: ").append(brf300_ENTITY.getR23_WESTERNM_REGION()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR23_AL_AIN().compareTo(up.getR23_AL_AIN()) != 0) {
			fieldNames.add("Abu Dhabi - Al Ain");
			oldChange.append("R23_COL_5: ").append(up.getR23_AL_AIN()).append("; ");
			newChange.append("R23_COL_5: ").append(brf300_ENTITY.getR23_AL_AIN()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR23_ISLAND().compareTo(up.getR23_ISLAND()) != 0) {
			fieldNames.add("Abu Dhabi - Islands");
			oldChange.append("R23_COL_6: ").append(up.getR23_ISLAND()).append("; ");
			newChange.append("R23_COL_6: ").append(brf300_ENTITY.getR23_ISLAND()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR23_DUBAI().compareTo(up.getR23_DUBAI()) != 0) {
			fieldNames.add("Dubai");
			oldChange.append("R23_COL_7: ").append(up.getR23_DUBAI()).append("; ");
			newChange.append("R23_COL_7: ").append(brf300_ENTITY.getR23_DUBAI()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR23_SHARJAH().compareTo(up.getR23_SHARJAH()) != 0) {
			fieldNames.add("Sharjah");
			oldChange.append("R23_COL_8: ").append(up.getR23_SHARJAH()).append("; ");
			newChange.append("R23_COL_8: ").append(brf300_ENTITY.getR23_SHARJAH()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR23_AJMAN().compareTo(up.getR23_AJMAN()) != 0) {
			fieldNames.add("Ajman");
			oldChange.append("R23_COL_9: ").append(up.getR23_AJMAN()).append("; ");
			newChange.append("R23_COL_9: ").append(brf300_ENTITY.getR23_AJMAN()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR23_RAS_AL().compareTo(up.getR23_RAS_AL()) != 0) {
			fieldNames.add("Ras al-Khaimah");
			oldChange.append("R23_COL_10: ").append(up.getR23_RAS_AL()).append("; ");
			newChange.append("R23_COL_10: ").append(brf300_ENTITY.getR23_RAS_AL()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR23_UMM_AL().compareTo(up.getR23_UMM_AL()) != 0) {
			fieldNames.add("Umm al-Quwain");
			oldChange.append("R23_COL_11: ").append(up.getR23_UMM_AL()).append("; ");
			newChange.append("R23_COL_11: ").append(brf300_ENTITY.getR23_UMM_AL()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR23_FUJAIRAH().compareTo(up.getR23_FUJAIRAH()) != 0) {
			fieldNames.add("Fujairah");
			oldChange.append("R23_COL_12: ").append(up.getR23_FUJAIRAH()).append("; ");
			newChange.append("R23_COL_12: ").append(brf300_ENTITY.getR23_FUJAIRAH()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR23_ABU_SUB().compareTo(up.getR23_ABU_SUB()) != 0) {
			fieldNames.add("Abu Dhabi Sub-total (D+E+F+G)");
			oldChange.append("R23_COL_13: ").append(up.getR23_ABU_SUB()).append("; ");
			newChange.append("R23_COL_13: ").append(brf300_ENTITY.getR23_ABU_SUB()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR23_TOTAL().compareTo(up.getR23_TOTAL()) != 0) {
			fieldNames.add("Total");
			oldChange.append("R23_COL_14: ").append(up.getR23_TOTAL()).append("; ");
			newChange.append("R23_COL_14: ").append(brf300_ENTITY.getR23_TOTAL()).append("; ");
			rowEdited = true;
		}
		
		
		if (brf300_ENTITY.getR24_S_NO().compareTo(up.getR24_S_NO()) != 0) {
			fieldNames.add("S.No");
			oldChange.append("R24_COL_1: ").append(up.getR24_S_NO()).append("; ");
			newChange.append("R24_COL_1: ").append(brf300_ENTITY.getR24_S_NO()).append("; ");
			rowEdited = true;
		}

		if (brf300_ENTITY.getR24_HEADQUATERS().compareTo(up.getR24_HEADQUATERS()) != 0) {
			fieldNames.add("Additional details - No. of National Female employees as Non-managerial staff ");
			oldChange.append("R24_COL_2: ").append(up.getR24_HEADQUATERS()).append("; ");
			newChange.append("R24_COL_2: ").append(brf300_ENTITY.getR24_HEADQUATERS()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR24_ABU_DHABI().compareTo(up.getR24_ABU_DHABI()) != 0) {
			fieldNames.add("Abu Dhabi - Abu Dhabi City");
			oldChange.append("R24_COL_3: ").append(up.getR24_ABU_DHABI()).append("; ");
			newChange.append("R24_COL_3: ").append(brf300_ENTITY.getR24_ABU_DHABI()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR24_WESTERNM_REGION().compareTo(up.getR24_WESTERNM_REGION()) != 0) {
			fieldNames.add("Abu Dhabi - Western Region");
			oldChange.append("R24_COL_4: ").append(up.getR24_WESTERNM_REGION()).append("; ");
			newChange.append("R24_COL_4: ").append(brf300_ENTITY.getR24_WESTERNM_REGION()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR24_AL_AIN().compareTo(up.getR24_AL_AIN()) != 0) {
			fieldNames.add("Abu Dhabi - Al Ain");
			oldChange.append("R24_COL_5: ").append(up.getR24_AL_AIN()).append("; ");
			newChange.append("R24_COL_5: ").append(brf300_ENTITY.getR24_AL_AIN()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR24_ISLAND().compareTo(up.getR24_ISLAND()) != 0) {
			fieldNames.add("Abu Dhabi - Islands");
			oldChange.append("R24_COL_6: ").append(up.getR24_ISLAND()).append("; ");
			newChange.append("R24_COL_6: ").append(brf300_ENTITY.getR24_ISLAND()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR24_DUBAI().compareTo(up.getR24_DUBAI()) != 0) {
			fieldNames.add("Dubai");
			oldChange.append("R24_COL_7: ").append(up.getR24_DUBAI()).append("; ");
			newChange.append("R24_COL_7: ").append(brf300_ENTITY.getR24_DUBAI()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR24_SHARJAH().compareTo(up.getR24_SHARJAH()) != 0) {
			fieldNames.add("Sharjah");
			oldChange.append("R24_COL_8: ").append(up.getR24_SHARJAH()).append("; ");
			newChange.append("R24_COL_8: ").append(brf300_ENTITY.getR24_SHARJAH()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR24_AJMAN().compareTo(up.getR24_AJMAN()) != 0) {
			fieldNames.add("Ajman");
			oldChange.append("R24_COL_9: ").append(up.getR24_AJMAN()).append("; ");
			newChange.append("R24_COL_9: ").append(brf300_ENTITY.getR24_AJMAN()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR24_RAS_AL().compareTo(up.getR24_RAS_AL()) != 0) {
			fieldNames.add("Ras al-Khaimah");
			oldChange.append("R24_COL_10: ").append(up.getR24_RAS_AL()).append("; ");
			newChange.append("R24_COL_10: ").append(brf300_ENTITY.getR24_RAS_AL()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR24_UMM_AL().compareTo(up.getR24_UMM_AL()) != 0) {
			fieldNames.add("Umm al-Quwain");
			oldChange.append("R24_COL_11: ").append(up.getR24_UMM_AL()).append("; ");
			newChange.append("R24_COL_11: ").append(brf300_ENTITY.getR24_UMM_AL()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR24_FUJAIRAH().compareTo(up.getR24_FUJAIRAH()) != 0) {
			fieldNames.add("Fujairah");
			oldChange.append("R24_COL_12: ").append(up.getR24_FUJAIRAH()).append("; ");
			newChange.append("R24_COL_12: ").append(brf300_ENTITY.getR24_FUJAIRAH()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR24_ABU_SUB().compareTo(up.getR24_ABU_SUB()) != 0) {
			fieldNames.add("Abu Dhabi Sub-total (D+E+F+G)");
			oldChange.append("R24_COL_13: ").append(up.getR24_ABU_SUB()).append("; ");
			newChange.append("R24_COL_13: ").append(brf300_ENTITY.getR24_ABU_SUB()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR24_TOTAL().compareTo(up.getR24_TOTAL()) != 0) {
			fieldNames.add("Total");
			oldChange.append("R24_COL_14: ").append(up.getR24_TOTAL()).append("; ");
			newChange.append("R24_COL_14: ").append(brf300_ENTITY.getR24_TOTAL()).append("; ");
			rowEdited = true;
		}
		
		
		if (brf300_ENTITY.getR25_S_NO().compareTo(up.getR25_S_NO()) != 0) {
			fieldNames.add("S.No");
			oldChange.append("R25_COL_1: ").append(up.getR25_S_NO()).append("; ");
			newChange.append("R25_COL_1: ").append(brf300_ENTITY.getR25_S_NO()).append("; ");
			rowEdited = true;
		}

		if (brf300_ENTITY.getR25_HEADQUATERS().compareTo(up.getR25_HEADQUATERS()) != 0) {
			fieldNames.add("Additional details - No. of Branch managers");
			oldChange.append("R25_COL_2: ").append(up.getR25_HEADQUATERS()).append("; ");
			newChange.append("R25_COL_2: ").append(brf300_ENTITY.getR25_HEADQUATERS()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR25_ABU_DHABI().compareTo(up.getR25_ABU_DHABI()) != 0) {
			fieldNames.add("Abu Dhabi - Abu Dhabi City");
			oldChange.append("R25_COL_3: ").append(up.getR25_ABU_DHABI()).append("; ");
			newChange.append("R25_COL_3: ").append(brf300_ENTITY.getR25_ABU_DHABI()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR25_WESTERNM_REGION().compareTo(up.getR25_WESTERNM_REGION()) != 0) {
			fieldNames.add("Abu Dhabi - Western Region");
			oldChange.append("R25_COL_4: ").append(up.getR25_WESTERNM_REGION()).append("; ");
			newChange.append("R25_COL_4: ").append(brf300_ENTITY.getR25_WESTERNM_REGION()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR25_AL_AIN().compareTo(up.getR25_AL_AIN()) != 0) {
			fieldNames.add("Abu Dhabi - Al Ain");
			oldChange.append("R25_COL_5: ").append(up.getR25_AL_AIN()).append("; ");
			newChange.append("R25_COL_5: ").append(brf300_ENTITY.getR25_AL_AIN()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR25_ISLAND().compareTo(up.getR25_ISLAND()) != 0) {
			fieldNames.add("Abu Dhabi - Islands");
			oldChange.append("R25_COL_6: ").append(up.getR25_ISLAND()).append("; ");
			newChange.append("R25_COL_6: ").append(brf300_ENTITY.getR25_ISLAND()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR25_DUBAI().compareTo(up.getR25_DUBAI()) != 0) {
			fieldNames.add("Dubai");
			oldChange.append("R25_COL_7: ").append(up.getR25_DUBAI()).append("; ");
			newChange.append("R25_COL_7: ").append(brf300_ENTITY.getR25_DUBAI()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR25_SHARJAH().compareTo(up.getR25_SHARJAH()) != 0) {
			fieldNames.add("Sharjah");
			oldChange.append("R25_COL_8: ").append(up.getR25_SHARJAH()).append("; ");
			newChange.append("R25_COL_8: ").append(brf300_ENTITY.getR25_SHARJAH()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR25_AJMAN().compareTo(up.getR25_AJMAN()) != 0) {
			fieldNames.add("Ajman");
			oldChange.append("R25_COL_9: ").append(up.getR25_AJMAN()).append("; ");
			newChange.append("R25_COL_9: ").append(brf300_ENTITY.getR25_AJMAN()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR25_RAS_AL().compareTo(up.getR25_RAS_AL()) != 0) {
			fieldNames.add("Ras al-Khaimah");
			oldChange.append("R25_COL_10: ").append(up.getR25_RAS_AL()).append("; ");
			newChange.append("R25_COL_10: ").append(brf300_ENTITY.getR25_RAS_AL()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR25_UMM_AL().compareTo(up.getR25_UMM_AL()) != 0) {
			fieldNames.add("Umm al-Quwain");
			oldChange.append("R25_COL_11: ").append(up.getR25_UMM_AL()).append("; ");
			newChange.append("R25_COL_11: ").append(brf300_ENTITY.getR25_UMM_AL()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR25_FUJAIRAH().compareTo(up.getR25_FUJAIRAH()) != 0) {
			fieldNames.add("Fujairah");
			oldChange.append("R25_COL_12: ").append(up.getR25_FUJAIRAH()).append("; ");
			newChange.append("R25_COL_12: ").append(brf300_ENTITY.getR25_FUJAIRAH()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR25_ABU_SUB().compareTo(up.getR25_ABU_SUB()) != 0) {
			fieldNames.add("Abu Dhabi Sub-total (D+E+F+G)");
			oldChange.append("R25_COL_13: ").append(up.getR25_ABU_SUB()).append("; ");
			newChange.append("R25_COL_13: ").append(brf300_ENTITY.getR25_ABU_SUB()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR25_TOTAL().compareTo(up.getR25_TOTAL()) != 0) {
			fieldNames.add("Total");
			oldChange.append("R25_COL_14: ").append(up.getR25_TOTAL()).append("; ");
			newChange.append("R25_COL_14: ").append(brf300_ENTITY.getR25_TOTAL()).append("; ");
			rowEdited = true;
		}
		
		
		if (brf300_ENTITY.getR26_S_NO().compareTo(up.getR26_S_NO()) != 0) {
			fieldNames.add("S.No");
			oldChange.append("R26_COL_1: ").append(up.getR26_S_NO()).append("; ");
			newChange.append("R26_COL_1: ").append(brf300_ENTITY.getR26_S_NO()).append("; ");
			rowEdited = true;
		}

		if (brf300_ENTITY.getR26_HEADQUATERS().compareTo(up.getR26_HEADQUATERS()) != 0) {
			fieldNames.add("Additional details - No. of National employees as Branch Managers");
			oldChange.append("R26_COL_2: ").append(up.getR26_HEADQUATERS()).append("; ");
			newChange.append("R26_COL_2: ").append(brf300_ENTITY.getR26_HEADQUATERS()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR26_ABU_DHABI().compareTo(up.getR26_ABU_DHABI()) != 0) {
			fieldNames.add("Abu Dhabi - Abu Dhabi City");
			oldChange.append("R26_COL_3: ").append(up.getR26_ABU_DHABI()).append("; ");
			newChange.append("R26_COL_3: ").append(brf300_ENTITY.getR26_ABU_DHABI()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR26_WESTERNM_REGION().compareTo(up.getR26_WESTERNM_REGION()) != 0) {
			fieldNames.add("Abu Dhabi - Western Region");
			oldChange.append("R26_COL_4: ").append(up.getR26_WESTERNM_REGION()).append("; ");
			newChange.append("R26_COL_4: ").append(brf300_ENTITY.getR26_WESTERNM_REGION()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR26_AL_AIN().compareTo(up.getR26_AL_AIN()) != 0) {
			fieldNames.add("Abu Dhabi - Al Ain");
			oldChange.append("R26_COL_5: ").append(up.getR26_AL_AIN()).append("; ");
			newChange.append("R26_COL_5: ").append(brf300_ENTITY.getR26_AL_AIN()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR26_ISLAND().compareTo(up.getR26_ISLAND()) != 0) {
			fieldNames.add("Abu Dhabi - Islands");
			oldChange.append("R26_COL_6: ").append(up.getR26_ISLAND()).append("; ");
			newChange.append("R26_COL_6: ").append(brf300_ENTITY.getR26_ISLAND()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR26_DUBAI().compareTo(up.getR26_DUBAI()) != 0) {
			fieldNames.add("Dubai");
			oldChange.append("R26_COL_7: ").append(up.getR26_DUBAI()).append("; ");
			newChange.append("R26_COL_7: ").append(brf300_ENTITY.getR26_DUBAI()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR26_SHARJAH().compareTo(up.getR26_SHARJAH()) != 0) {
			fieldNames.add("Sharjah");
			oldChange.append("R26_COL_8: ").append(up.getR26_SHARJAH()).append("; ");
			newChange.append("R26_COL_8: ").append(brf300_ENTITY.getR26_SHARJAH()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR26_AJMAN().compareTo(up.getR26_AJMAN()) != 0) {
			fieldNames.add("Ajman");
			oldChange.append("R26_COL_9: ").append(up.getR26_AJMAN()).append("; ");
			newChange.append("R26_COL_9: ").append(brf300_ENTITY.getR26_AJMAN()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR26_RAS_AL().compareTo(up.getR26_RAS_AL()) != 0) {
			fieldNames.add("Ras al-Khaimah");
			oldChange.append("R26_COL_10: ").append(up.getR26_RAS_AL()).append("; ");
			newChange.append("R26_COL_10: ").append(brf300_ENTITY.getR26_RAS_AL()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR26_UMM_AL().compareTo(up.getR26_UMM_AL()) != 0) {
			fieldNames.add("Umm al-Quwain");
			oldChange.append("R26_COL_11: ").append(up.getR26_UMM_AL()).append("; ");
			newChange.append("R26_COL_11: ").append(brf300_ENTITY.getR26_UMM_AL()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR26_FUJAIRAH().compareTo(up.getR26_FUJAIRAH()) != 0) {
			fieldNames.add("Fujairah");
			oldChange.append("R26_COL_12: ").append(up.getR26_FUJAIRAH()).append("; ");
			newChange.append("R26_COL_12: ").append(brf300_ENTITY.getR26_FUJAIRAH()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR26_ABU_SUB().compareTo(up.getR26_ABU_SUB()) != 0) {
			fieldNames.add("Abu Dhabi Sub-total (D+E+F+G)");
			oldChange.append("R26_COL_13: ").append(up.getR26_ABU_SUB()).append("; ");
			newChange.append("R26_COL_13: ").append(brf300_ENTITY.getR26_ABU_SUB()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR26_TOTAL().compareTo(up.getR26_TOTAL()) != 0) {
			fieldNames.add("Total");
			oldChange.append("R26_COL_14: ").append(up.getR26_TOTAL()).append("; ");
			newChange.append("R26_COL_14: ").append(brf300_ENTITY.getR26_TOTAL()).append("; ");
			rowEdited = true;
		}
		
		
		if (brf300_ENTITY.getR27_S_NO().compareTo(up.getR27_S_NO()) != 0) {
			fieldNames.add("S.No");
			oldChange.append("R27_COL_1: ").append(up.getR27_S_NO()).append("; ");
			newChange.append("R27_COL_1: ").append(brf300_ENTITY.getR27_S_NO()).append("; ");
			rowEdited = true;
		}

		if (brf300_ENTITY.getR27_HEADQUATERS().compareTo(up.getR27_HEADQUATERS()) != 0) {
			fieldNames.add("Additional details - No. of National Female employees as Branch Managers");
			oldChange.append("R27_COL_2: ").append(up.getR27_HEADQUATERS()).append("; ");
			newChange.append("R27_COL_2: ").append(brf300_ENTITY.getR27_HEADQUATERS()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR27_ABU_DHABI().compareTo(up.getR27_ABU_DHABI()) != 0) {
			fieldNames.add("Abu Dhabi - Abu Dhabi City");
			oldChange.append("R27_COL_3: ").append(up.getR27_ABU_DHABI()).append("; ");
			newChange.append("R27_COL_3: ").append(brf300_ENTITY.getR27_ABU_DHABI()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR27_WESTERNM_REGION().compareTo(up.getR27_WESTERNM_REGION()) != 0) {
			fieldNames.add("Abu Dhabi - Western Region");
			oldChange.append("R27_COL_4: ").append(up.getR27_WESTERNM_REGION()).append("; ");
			newChange.append("R27_COL_4: ").append(brf300_ENTITY.getR27_WESTERNM_REGION()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR27_AL_AIN().compareTo(up.getR27_AL_AIN()) != 0) {
			fieldNames.add("Abu Dhabi - Al Ain");
			oldChange.append("R27_COL_5: ").append(up.getR27_AL_AIN()).append("; ");
			newChange.append("R27_COL_5: ").append(brf300_ENTITY.getR27_AL_AIN()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR27_ISLAND().compareTo(up.getR27_ISLAND()) != 0) {
			fieldNames.add("Abu Dhabi - Islands");
			oldChange.append("R27_COL_6: ").append(up.getR27_ISLAND()).append("; ");
			newChange.append("R27_COL_6: ").append(brf300_ENTITY.getR27_ISLAND()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR27_DUBAI().compareTo(up.getR27_DUBAI()) != 0) {
			fieldNames.add("Dubai");
			oldChange.append("R27_COL_7: ").append(up.getR27_DUBAI()).append("; ");
			newChange.append("R27_COL_7: ").append(brf300_ENTITY.getR27_DUBAI()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR27_SHARJAH().compareTo(up.getR27_SHARJAH()) != 0) {
			fieldNames.add("Sharjah");
			oldChange.append("R27_COL_8: ").append(up.getR27_SHARJAH()).append("; ");
			newChange.append("R27_COL_8: ").append(brf300_ENTITY.getR27_SHARJAH()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR27_AJMAN().compareTo(up.getR27_AJMAN()) != 0) {
			fieldNames.add("Ajman");
			oldChange.append("R27_COL_9: ").append(up.getR27_AJMAN()).append("; ");
			newChange.append("R27_COL_9: ").append(brf300_ENTITY.getR27_AJMAN()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR27_RAS_AL().compareTo(up.getR27_RAS_AL()) != 0) {
			fieldNames.add("Ras al-Khaimah");
			oldChange.append("R27_COL_10: ").append(up.getR27_RAS_AL()).append("; ");
			newChange.append("R27_COL_10: ").append(brf300_ENTITY.getR27_RAS_AL()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR27_UMM_AL().compareTo(up.getR27_UMM_AL()) != 0) {
			fieldNames.add("Umm al-Quwain");
			oldChange.append("R27_COL_11: ").append(up.getR27_UMM_AL()).append("; ");
			newChange.append("R27_COL_11: ").append(brf300_ENTITY.getR27_UMM_AL()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR27_FUJAIRAH().compareTo(up.getR27_FUJAIRAH()) != 0) {
			fieldNames.add("Fujairah");
			oldChange.append("R27_COL_12: ").append(up.getR27_FUJAIRAH()).append("; ");
			newChange.append("R27_COL_12: ").append(brf300_ENTITY.getR27_FUJAIRAH()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR27_ABU_SUB().compareTo(up.getR27_ABU_SUB()) != 0) {
			fieldNames.add("Abu Dhabi Sub-total (D+E+F+G)");
			oldChange.append("R27_COL_13: ").append(up.getR27_ABU_SUB()).append("; ");
			newChange.append("R27_COL_13: ").append(brf300_ENTITY.getR27_ABU_SUB()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR27_TOTAL().compareTo(up.getR27_TOTAL()) != 0) {
			fieldNames.add("Total");
			oldChange.append("R27_COL_14: ").append(up.getR27_TOTAL()).append("; ");
			newChange.append("R27_COL_14: ").append(brf300_ENTITY.getR27_TOTAL()).append("; ");
			rowEdited = true;
		}
		
		
		if (brf300_ENTITY.getR28_S_NO().compareTo(up.getR28_S_NO()) != 0) {
			fieldNames.add("S.No");
			oldChange.append("R28_COL_1: ").append(up.getR28_S_NO()).append("; ");
			newChange.append("R28_COL_1: ").append(brf300_ENTITY.getR28_S_NO()).append("; ");
			rowEdited = true;
		}

		if (brf300_ENTITY.getR28_HEADQUATERS().compareTo(up.getR28_HEADQUATERS()) != 0) {
			fieldNames.add("Additional details - No. of employees as Unit manager ");
			oldChange.append("R28_COL_2: ").append(up.getR28_HEADQUATERS()).append("; ");
			newChange.append("R28_COL_2: ").append(brf300_ENTITY.getR28_HEADQUATERS()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR28_ABU_DHABI().compareTo(up.getR28_ABU_DHABI()) != 0) {
			fieldNames.add("Abu Dhabi - Abu Dhabi City");
			oldChange.append("R28_COL_3: ").append(up.getR28_ABU_DHABI()).append("; ");
			newChange.append("R28_COL_3: ").append(brf300_ENTITY.getR28_ABU_DHABI()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR28_WESTERNM_REGION().compareTo(up.getR28_WESTERNM_REGION()) != 0) {
			fieldNames.add("Abu Dhabi - Western Region");
			oldChange.append("R28_COL_4: ").append(up.getR28_WESTERNM_REGION()).append("; ");
			newChange.append("R28_COL_4: ").append(brf300_ENTITY.getR28_WESTERNM_REGION()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR28_AL_AIN().compareTo(up.getR28_AL_AIN()) != 0) {
			fieldNames.add("Abu Dhabi - Al Ain");
			oldChange.append("R28_COL_5: ").append(up.getR28_AL_AIN()).append("; ");
			newChange.append("R28_COL_5: ").append(brf300_ENTITY.getR28_AL_AIN()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR28_ISLAND().compareTo(up.getR28_ISLAND()) != 0) {
			fieldNames.add("Abu Dhabi - Islands");
			oldChange.append("R28_COL_6: ").append(up.getR28_ISLAND()).append("; ");
			newChange.append("R28_COL_6: ").append(brf300_ENTITY.getR28_ISLAND()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR28_DUBAI().compareTo(up.getR28_DUBAI()) != 0) {
			fieldNames.add("Dubai");
			oldChange.append("R28_COL_7: ").append(up.getR28_DUBAI()).append("; ");
			newChange.append("R28_COL_7: ").append(brf300_ENTITY.getR28_DUBAI()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR28_SHARJAH().compareTo(up.getR28_SHARJAH()) != 0) {
			fieldNames.add("Sharjah");
			oldChange.append("R28_COL_8: ").append(up.getR28_SHARJAH()).append("; ");
			newChange.append("R28_COL_8: ").append(brf300_ENTITY.getR28_SHARJAH()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR28_AJMAN().compareTo(up.getR28_AJMAN()) != 0) {
			fieldNames.add("Ajman");
			oldChange.append("R28_COL_9: ").append(up.getR28_AJMAN()).append("; ");
			newChange.append("R28_COL_9: ").append(brf300_ENTITY.getR28_AJMAN()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR28_RAS_AL().compareTo(up.getR28_RAS_AL()) != 0) {
			fieldNames.add("Ras al-Khaimah");
			oldChange.append("R28_COL_10: ").append(up.getR28_RAS_AL()).append("; ");
			newChange.append("R28_COL_10: ").append(brf300_ENTITY.getR28_RAS_AL()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR28_UMM_AL().compareTo(up.getR28_UMM_AL()) != 0) {
			fieldNames.add("Umm al-Quwain");
			oldChange.append("R28_COL_11: ").append(up.getR28_UMM_AL()).append("; ");
			newChange.append("R28_COL_11: ").append(brf300_ENTITY.getR28_UMM_AL()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR28_FUJAIRAH().compareTo(up.getR28_FUJAIRAH()) != 0) {
			fieldNames.add("Fujairah");
			oldChange.append("R28_COL_12: ").append(up.getR28_FUJAIRAH()).append("; ");
			newChange.append("R28_COL_12: ").append(brf300_ENTITY.getR28_FUJAIRAH()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR28_ABU_SUB().compareTo(up.getR28_ABU_SUB()) != 0) {
			fieldNames.add("Abu Dhabi Sub-total (D+E+F+G)");
			oldChange.append("R28_COL_13: ").append(up.getR28_ABU_SUB()).append("; ");
			newChange.append("R28_COL_13: ").append(brf300_ENTITY.getR28_ABU_SUB()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR28_TOTAL().compareTo(up.getR28_TOTAL()) != 0) {
			fieldNames.add("Total");
			oldChange.append("R28_COL_14: ").append(up.getR28_TOTAL()).append("; ");
			newChange.append("R28_COL_14: ").append(brf300_ENTITY.getR28_TOTAL()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR29_S_NO().compareTo(up.getR29_S_NO()) != 0) {
			fieldNames.add("S.No");
			oldChange.append("R29_COL_1: ").append(up.getR29_S_NO()).append("; ");
			newChange.append("R29_COL_1: ").append(brf300_ENTITY.getR29_S_NO()).append("; ");
			rowEdited = true;
		}

		if (brf300_ENTITY.getR29_HEADQUATERS().compareTo(up.getR29_HEADQUATERS()) != 0) {
			fieldNames.add("Additional details - No. of National employees as Unit manager ");
			oldChange.append("R29_COL_2: ").append(up.getR29_HEADQUATERS()).append("; ");
			newChange.append("R29_COL_2: ").append(brf300_ENTITY.getR29_HEADQUATERS()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR29_ABU_DHABI().compareTo(up.getR29_ABU_DHABI()) != 0) {
			fieldNames.add("Abu Dhabi - Abu Dhabi City");
			oldChange.append("R29_COL_3: ").append(up.getR29_ABU_DHABI()).append("; ");
			newChange.append("R29_COL_3: ").append(brf300_ENTITY.getR29_ABU_DHABI()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR29_WESTERNM_REGION().compareTo(up.getR29_WESTERNM_REGION()) != 0) {
			fieldNames.add("Abu Dhabi - Western Region");
			oldChange.append("R29_COL_4: ").append(up.getR29_WESTERNM_REGION()).append("; ");
			newChange.append("R29_COL_4: ").append(brf300_ENTITY.getR29_WESTERNM_REGION()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR29_AL_AIN().compareTo(up.getR29_AL_AIN()) != 0) {
			fieldNames.add("Abu Dhabi - Al Ain");
			oldChange.append("R29_COL_5: ").append(up.getR29_AL_AIN()).append("; ");
			newChange.append("R29_COL_5: ").append(brf300_ENTITY.getR29_AL_AIN()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR29_ISLAND().compareTo(up.getR29_ISLAND()) != 0) {
			fieldNames.add("Abu Dhabi - Islands");
			oldChange.append("R29_COL_6: ").append(up.getR29_ISLAND()).append("; ");
			newChange.append("R29_COL_6: ").append(brf300_ENTITY.getR29_ISLAND()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR29_DUBAI().compareTo(up.getR29_DUBAI()) != 0) {
			fieldNames.add("Dubai");
			oldChange.append("R29_COL_7: ").append(up.getR29_DUBAI()).append("; ");
			newChange.append("R29_COL_7: ").append(brf300_ENTITY.getR29_DUBAI()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR29_SHARJAH().compareTo(up.getR29_SHARJAH()) != 0) {
			fieldNames.add("Sharjah");
			oldChange.append("R29_COL_8: ").append(up.getR29_SHARJAH()).append("; ");
			newChange.append("R29_COL_8: ").append(brf300_ENTITY.getR29_SHARJAH()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR29_AJMAN().compareTo(up.getR29_AJMAN()) != 0) {
			fieldNames.add("Ajman");
			oldChange.append("R29_COL_9: ").append(up.getR29_AJMAN()).append("; ");
			newChange.append("R29_COL_9: ").append(brf300_ENTITY.getR29_AJMAN()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR29_RAS_AL().compareTo(up.getR29_RAS_AL()) != 0) {
			fieldNames.add("Ras al-Khaimah");
			oldChange.append("R29_COL_10: ").append(up.getR29_RAS_AL()).append("; ");
			newChange.append("R29_COL_10: ").append(brf300_ENTITY.getR29_RAS_AL()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR29_UMM_AL().compareTo(up.getR29_UMM_AL()) != 0) {
			fieldNames.add("Umm al-Quwain");
			oldChange.append("R29_COL_11: ").append(up.getR29_UMM_AL()).append("; ");
			newChange.append("R29_COL_11: ").append(brf300_ENTITY.getR29_UMM_AL()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR29_FUJAIRAH().compareTo(up.getR29_FUJAIRAH()) != 0) {
			fieldNames.add("Fujairah");
			oldChange.append("R29_COL_12: ").append(up.getR29_FUJAIRAH()).append("; ");
			newChange.append("R29_COL_12: ").append(brf300_ENTITY.getR29_FUJAIRAH()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR29_ABU_SUB().compareTo(up.getR29_ABU_SUB()) != 0) {
			fieldNames.add("Abu Dhabi Sub-total (D+E+F+G)");
			oldChange.append("R29_COL_13: ").append(up.getR29_ABU_SUB()).append("; ");
			newChange.append("R29_COL_13: ").append(brf300_ENTITY.getR29_ABU_SUB()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR29_TOTAL().compareTo(up.getR29_TOTAL()) != 0) {
			fieldNames.add("Total");
			oldChange.append("R29_COL_14: ").append(up.getR29_TOTAL()).append("; ");
			newChange.append("R29_COL_14: ").append(brf300_ENTITY.getR29_TOTAL()).append("; ");
			rowEdited = true;
		}
		
		
		if (brf300_ENTITY.getR30_S_NO().compareTo(up.getR30_S_NO()) != 0) {
			fieldNames.add("S.No");
			oldChange.append("R30_COL_1: ").append(up.getR30_S_NO()).append("; ");
			newChange.append("R30_COL_1: ").append(brf300_ENTITY.getR30_S_NO()).append("; ");
			rowEdited = true;
		}

		if (brf300_ENTITY.getR30_HEADQUATERS().compareTo(up.getR30_HEADQUATERS()) != 0) {
			fieldNames.add("Additional details - No. of  National Female employees as Unit manager ");
			oldChange.append("R30_COL_2: ").append(up.getR30_HEADQUATERS()).append("; ");
			newChange.append("R30_COL_2: ").append(brf300_ENTITY.getR30_HEADQUATERS()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR30_ABU_DHABI().compareTo(up.getR30_ABU_DHABI()) != 0) {
			fieldNames.add("Abu Dhabi - Abu Dhabi City");
			oldChange.append("R30_COL_3: ").append(up.getR30_ABU_DHABI()).append("; ");
			newChange.append("R30_COL_3: ").append(brf300_ENTITY.getR30_ABU_DHABI()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR30_WESTERNM_REGION().compareTo(up.getR30_WESTERNM_REGION()) != 0) {
			fieldNames.add("Abu Dhabi - Western Region");
			oldChange.append("R30_COL_4: ").append(up.getR30_WESTERNM_REGION()).append("; ");
			newChange.append("R30_COL_4: ").append(brf300_ENTITY.getR30_WESTERNM_REGION()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR30_AL_AIN().compareTo(up.getR30_AL_AIN()) != 0) {
			fieldNames.add("Abu Dhabi - Al Ain");
			oldChange.append("R30_COL_5: ").append(up.getR30_AL_AIN()).append("; ");
			newChange.append("R30_COL_5: ").append(brf300_ENTITY.getR30_AL_AIN()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR30_ISLAND().compareTo(up.getR30_ISLAND()) != 0) {
			fieldNames.add("Abu Dhabi - Islands");
			oldChange.append("R30_COL_6: ").append(up.getR30_ISLAND()).append("; ");
			newChange.append("R30_COL_6: ").append(brf300_ENTITY.getR30_ISLAND()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR30_DUBAI().compareTo(up.getR30_DUBAI()) != 0) {
			fieldNames.add("Dubai");
			oldChange.append("R30_COL_7: ").append(up.getR30_DUBAI()).append("; ");
			newChange.append("R30_COL_7: ").append(brf300_ENTITY.getR30_DUBAI()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR30_SHARJAH().compareTo(up.getR30_SHARJAH()) != 0) {
			fieldNames.add("Sharjah");
			oldChange.append("R30_COL_8: ").append(up.getR30_SHARJAH()).append("; ");
			newChange.append("R30_COL_8: ").append(brf300_ENTITY.getR30_SHARJAH()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR30_AJMAN().compareTo(up.getR30_AJMAN()) != 0) {
			fieldNames.add("Ajman");
			oldChange.append("R30_COL_9: ").append(up.getR30_AJMAN()).append("; ");
			newChange.append("R30_COL_9: ").append(brf300_ENTITY.getR30_AJMAN()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR30_RAS_AL().compareTo(up.getR30_RAS_AL()) != 0) {
			fieldNames.add("Ras al-Khaimah");
			oldChange.append("R30_COL_10: ").append(up.getR30_RAS_AL()).append("; ");
			newChange.append("R30_COL_10: ").append(brf300_ENTITY.getR30_RAS_AL()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR30_UMM_AL().compareTo(up.getR30_UMM_AL()) != 0) {
			fieldNames.add("Umm al-Quwain");
			oldChange.append("R30_COL_11: ").append(up.getR30_UMM_AL()).append("; ");
			newChange.append("R30_COL_11: ").append(brf300_ENTITY.getR30_UMM_AL()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR30_FUJAIRAH().compareTo(up.getR30_FUJAIRAH()) != 0) {
			fieldNames.add("Fujairah");
			oldChange.append("R30_COL_12: ").append(up.getR30_FUJAIRAH()).append("; ");
			newChange.append("R30_COL_12: ").append(brf300_ENTITY.getR30_FUJAIRAH()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR30_ABU_SUB().compareTo(up.getR30_ABU_SUB()) != 0) {
			fieldNames.add("Abu Dhabi Sub-total (D+E+F+G)");
			oldChange.append("R30_COL_13: ").append(up.getR30_ABU_SUB()).append("; ");
			newChange.append("R30_COL_13: ").append(brf300_ENTITY.getR30_ABU_SUB()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR30_TOTAL().compareTo(up.getR30_TOTAL()) != 0) {
			fieldNames.add("Total");
			oldChange.append("R30_COL_14: ").append(up.getR30_TOTAL()).append("; ");
			newChange.append("R30_COL_14: ").append(brf300_ENTITY.getR30_TOTAL()).append("; ");
			rowEdited = true;
		}
		
		
		if (brf300_ENTITY.getR31_S_NO().compareTo(up.getR31_S_NO()) != 0) {
			fieldNames.add("S.No");
			oldChange.append("R31_COL_1: ").append(up.getR31_S_NO()).append("; ");
			newChange.append("R31_COL_1: ").append(brf300_ENTITY.getR31_S_NO()).append("; ");
			rowEdited = true;
		}

		if (brf300_ENTITY.getR31_HEADQUATERS().compareTo(up.getR31_HEADQUATERS()) != 0) {
			fieldNames.add("Additional details - No. of employees as Division management");
			oldChange.append("R31_COL_2: ").append(up.getR31_HEADQUATERS()).append("; ");
			newChange.append("R31_COL_2: ").append(brf300_ENTITY.getR31_HEADQUATERS()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR31_ABU_DHABI().compareTo(up.getR31_ABU_DHABI()) != 0) {
			fieldNames.add("Abu Dhabi - Abu Dhabi City");
			oldChange.append("R31_COL_3: ").append(up.getR31_ABU_DHABI()).append("; ");
			newChange.append("R31_COL_3: ").append(brf300_ENTITY.getR31_ABU_DHABI()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR31_WESTERNM_REGION().compareTo(up.getR31_WESTERNM_REGION()) != 0) {
			fieldNames.add("Abu Dhabi - Western Region");
			oldChange.append("R31_COL_4: ").append(up.getR31_WESTERNM_REGION()).append("; ");
			newChange.append("R31_COL_4: ").append(brf300_ENTITY.getR31_WESTERNM_REGION()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR31_AL_AIN().compareTo(up.getR31_AL_AIN()) != 0) {
			fieldNames.add("Abu Dhabi - Al Ain");
			oldChange.append("R31_COL_5: ").append(up.getR31_AL_AIN()).append("; ");
			newChange.append("R31_COL_5: ").append(brf300_ENTITY.getR31_AL_AIN()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR31_ISLAND().compareTo(up.getR31_ISLAND()) != 0) {
			fieldNames.add("Abu Dhabi - Islands");
			oldChange.append("R31_COL_6: ").append(up.getR31_ISLAND()).append("; ");
			newChange.append("R31_COL_6: ").append(brf300_ENTITY.getR31_ISLAND()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR31_DUBAI().compareTo(up.getR31_DUBAI()) != 0) {
			fieldNames.add("Dubai");
			oldChange.append("R31_COL_7: ").append(up.getR31_DUBAI()).append("; ");
			newChange.append("R31_COL_7: ").append(brf300_ENTITY.getR31_DUBAI()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR31_SHARJAH().compareTo(up.getR31_SHARJAH()) != 0) {
			fieldNames.add("Sharjah");
			oldChange.append("R31_COL_8: ").append(up.getR31_SHARJAH()).append("; ");
			newChange.append("R31_COL_8: ").append(brf300_ENTITY.getR31_SHARJAH()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR31_AJMAN().compareTo(up.getR31_AJMAN()) != 0) {
			fieldNames.add("Ajman");
			oldChange.append("R31_COL_9: ").append(up.getR31_AJMAN()).append("; ");
			newChange.append("R31_COL_9: ").append(brf300_ENTITY.getR31_AJMAN()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR31_RAS_AL().compareTo(up.getR31_RAS_AL()) != 0) {
			fieldNames.add("Ras al-Khaimah");
			oldChange.append("R31_COL_10: ").append(up.getR31_RAS_AL()).append("; ");
			newChange.append("R31_COL_10: ").append(brf300_ENTITY.getR31_RAS_AL()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR31_UMM_AL().compareTo(up.getR31_UMM_AL()) != 0) {
			fieldNames.add("Umm al-Quwain");
			oldChange.append("R31_COL_11: ").append(up.getR31_UMM_AL()).append("; ");
			newChange.append("R31_COL_11: ").append(brf300_ENTITY.getR31_UMM_AL()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR31_FUJAIRAH().compareTo(up.getR31_FUJAIRAH()) != 0) {
			fieldNames.add("Fujairah");
			oldChange.append("R31_COL_12: ").append(up.getR31_FUJAIRAH()).append("; ");
			newChange.append("R31_COL_12: ").append(brf300_ENTITY.getR31_FUJAIRAH()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR31_ABU_SUB().compareTo(up.getR31_ABU_SUB()) != 0) {
			fieldNames.add("Abu Dhabi Sub-total (D+E+F+G)");
			oldChange.append("R31_COL_13: ").append(up.getR31_ABU_SUB()).append("; ");
			newChange.append("R31_COL_13: ").append(brf300_ENTITY.getR31_ABU_SUB()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR31_TOTAL().compareTo(up.getR31_TOTAL()) != 0) {
			fieldNames.add("Total");
			oldChange.append("R31_COL_14: ").append(up.getR31_TOTAL()).append("; ");
			newChange.append("R31_COL_14: ").append(brf300_ENTITY.getR31_TOTAL()).append("; ");
			rowEdited = true;
		}
		
		
		if (brf300_ENTITY.getR32_S_NO().compareTo(up.getR32_S_NO()) != 0) {
			fieldNames.add("S.No");
			oldChange.append("R32_COL_1: ").append(up.getR32_S_NO()).append("; ");
			newChange.append("R32_COL_1: ").append(brf300_ENTITY.getR32_S_NO()).append("; ");
			rowEdited = true;
		}

		if (brf300_ENTITY.getR32_HEADQUATERS().compareTo(up.getR32_HEADQUATERS()) != 0) {
			fieldNames.add("Additional details - No. of National employees as Division management");
			oldChange.append("R32_COL_2: ").append(up.getR32_HEADQUATERS()).append("; ");
			newChange.append("R32_COL_2: ").append(brf300_ENTITY.getR32_HEADQUATERS()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR32_ABU_DHABI().compareTo(up.getR32_ABU_DHABI()) != 0) {
			fieldNames.add("Abu Dhabi - Abu Dhabi City");
			oldChange.append("R32_COL_3: ").append(up.getR32_ABU_DHABI()).append("; ");
			newChange.append("R32_COL_3: ").append(brf300_ENTITY.getR32_ABU_DHABI()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR32_WESTERNM_REGION().compareTo(up.getR32_WESTERNM_REGION()) != 0) {
			fieldNames.add("Abu Dhabi - Western Region");
			oldChange.append("R32_COL_4: ").append(up.getR32_WESTERNM_REGION()).append("; ");
			newChange.append("R32_COL_4: ").append(brf300_ENTITY.getR32_WESTERNM_REGION()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR32_AL_AIN().compareTo(up.getR32_AL_AIN()) != 0) {
			fieldNames.add("Abu Dhabi - Al Ain");
			oldChange.append("R32_COL_5: ").append(up.getR32_AL_AIN()).append("; ");
			newChange.append("R32_COL_5: ").append(brf300_ENTITY.getR32_AL_AIN()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR32_ISLAND().compareTo(up.getR32_ISLAND()) != 0) {
			fieldNames.add("Abu Dhabi - Islands");
			oldChange.append("R32_COL_6: ").append(up.getR32_ISLAND()).append("; ");
			newChange.append("R32_COL_6: ").append(brf300_ENTITY.getR32_ISLAND()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR32_DUBAI().compareTo(up.getR32_DUBAI()) != 0) {
			fieldNames.add("Dubai");
			oldChange.append("R32_COL_7: ").append(up.getR32_DUBAI()).append("; ");
			newChange.append("R32_COL_7: ").append(brf300_ENTITY.getR32_DUBAI()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR32_SHARJAH().compareTo(up.getR32_SHARJAH()) != 0) {
			fieldNames.add("Sharjah");
			oldChange.append("R32_COL_8: ").append(up.getR32_SHARJAH()).append("; ");
			newChange.append("R32_COL_8: ").append(brf300_ENTITY.getR32_SHARJAH()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR32_AJMAN().compareTo(up.getR32_AJMAN()) != 0) {
			fieldNames.add("Ajman");
			oldChange.append("R32_COL_9: ").append(up.getR32_AJMAN()).append("; ");
			newChange.append("R32_COL_9: ").append(brf300_ENTITY.getR32_AJMAN()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR32_RAS_AL().compareTo(up.getR32_RAS_AL()) != 0) {
			fieldNames.add("Ras al-Khaimah");
			oldChange.append("R32_COL_10: ").append(up.getR32_RAS_AL()).append("; ");
			newChange.append("R32_COL_10: ").append(brf300_ENTITY.getR32_RAS_AL()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR32_UMM_AL().compareTo(up.getR32_UMM_AL()) != 0) {
			fieldNames.add("Umm al-Quwain");
			oldChange.append("R32_COL_11: ").append(up.getR32_UMM_AL()).append("; ");
			newChange.append("R32_COL_11: ").append(brf300_ENTITY.getR32_UMM_AL()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR32_FUJAIRAH().compareTo(up.getR32_FUJAIRAH()) != 0) {
			fieldNames.add("Fujairah");
			oldChange.append("R32_COL_12: ").append(up.getR32_FUJAIRAH()).append("; ");
			newChange.append("R32_COL_12: ").append(brf300_ENTITY.getR32_FUJAIRAH()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR32_ABU_SUB().compareTo(up.getR32_ABU_SUB()) != 0) {
			fieldNames.add("Abu Dhabi Sub-total (D+E+F+G)");
			oldChange.append("R32_COL_13: ").append(up.getR32_ABU_SUB()).append("; ");
			newChange.append("R32_COL_13: ").append(brf300_ENTITY.getR32_ABU_SUB()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR32_TOTAL().compareTo(up.getR32_TOTAL()) != 0) {
			fieldNames.add("Total");
			oldChange.append("R32_COL_14: ").append(up.getR32_TOTAL()).append("; ");
			newChange.append("R32_COL_14: ").append(brf300_ENTITY.getR32_TOTAL()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR33_S_NO().compareTo(up.getR33_S_NO()) != 0) {
			fieldNames.add("S.No");
			oldChange.append("R33_COL_1: ").append(up.getR33_S_NO()).append("; ");
			newChange.append("R33_COL_1: ").append(brf300_ENTITY.getR33_S_NO()).append("; ");
			rowEdited = true;
		}

		if (brf300_ENTITY.getR33_HEADQUATERS().compareTo(up.getR33_HEADQUATERS()) != 0) {
			fieldNames.add("Additional details - No. of National Female employees as Division management");
			oldChange.append("R33_COL_2: ").append(up.getR33_HEADQUATERS()).append("; ");
			newChange.append("R33_COL_2: ").append(brf300_ENTITY.getR33_HEADQUATERS()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR33_ABU_DHABI().compareTo(up.getR33_ABU_DHABI()) != 0) {
			fieldNames.add("Abu Dhabi - Abu Dhabi City");
			oldChange.append("R33_COL_3: ").append(up.getR33_ABU_DHABI()).append("; ");
			newChange.append("R33_COL_3: ").append(brf300_ENTITY.getR33_ABU_DHABI()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR33_WESTERNM_REGION().compareTo(up.getR33_WESTERNM_REGION()) != 0) {
			fieldNames.add("Abu Dhabi - Western Region");
			oldChange.append("R33_COL_4: ").append(up.getR33_WESTERNM_REGION()).append("; ");
			newChange.append("R33_COL_4: ").append(brf300_ENTITY.getR33_WESTERNM_REGION()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR33_AL_AIN().compareTo(up.getR33_AL_AIN()) != 0) {
			fieldNames.add("Abu Dhabi - Al Ain");
			oldChange.append("R33_COL_5: ").append(up.getR33_AL_AIN()).append("; ");
			newChange.append("R33_COL_5: ").append(brf300_ENTITY.getR33_AL_AIN()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR33_ISLAND().compareTo(up.getR33_ISLAND()) != 0) {
			fieldNames.add("Abu Dhabi - Islands");
			oldChange.append("R33_COL_6: ").append(up.getR33_ISLAND()).append("; ");
			newChange.append("R33_COL_6: ").append(brf300_ENTITY.getR33_ISLAND()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR33_DUBAI().compareTo(up.getR33_DUBAI()) != 0) {
			fieldNames.add("Dubai");
			oldChange.append("R33_COL_7: ").append(up.getR33_DUBAI()).append("; ");
			newChange.append("R33_COL_7: ").append(brf300_ENTITY.getR33_DUBAI()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR33_SHARJAH().compareTo(up.getR33_SHARJAH()) != 0) {
			fieldNames.add("Sharjah");
			oldChange.append("R33_COL_8: ").append(up.getR33_SHARJAH()).append("; ");
			newChange.append("R33_COL_8: ").append(brf300_ENTITY.getR33_SHARJAH()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR33_AJMAN().compareTo(up.getR33_AJMAN()) != 0) {
			fieldNames.add("Ajman");
			oldChange.append("R33_COL_9: ").append(up.getR33_AJMAN()).append("; ");
			newChange.append("R33_COL_9: ").append(brf300_ENTITY.getR33_AJMAN()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR33_RAS_AL().compareTo(up.getR33_RAS_AL()) != 0) {
			fieldNames.add("Ras al-Khaimah");
			oldChange.append("R33_COL_10: ").append(up.getR33_RAS_AL()).append("; ");
			newChange.append("R33_COL_10: ").append(brf300_ENTITY.getR33_RAS_AL()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR33_UMM_AL().compareTo(up.getR33_UMM_AL()) != 0) {
			fieldNames.add("Umm al-Quwain");
			oldChange.append("R33_COL_11: ").append(up.getR33_UMM_AL()).append("; ");
			newChange.append("R33_COL_11: ").append(brf300_ENTITY.getR33_UMM_AL()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR33_FUJAIRAH().compareTo(up.getR33_FUJAIRAH()) != 0) {
			fieldNames.add("Fujairah");
			oldChange.append("R33_COL_12: ").append(up.getR33_FUJAIRAH()).append("; ");
			newChange.append("R33_COL_12: ").append(brf300_ENTITY.getR33_FUJAIRAH()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR33_ABU_SUB().compareTo(up.getR33_ABU_SUB()) != 0) {
			fieldNames.add("Abu Dhabi Sub-total (D+E+F+G)");
			oldChange.append("R33_COL_13: ").append(up.getR33_ABU_SUB()).append("; ");
			newChange.append("R33_COL_13: ").append(brf300_ENTITY.getR33_ABU_SUB()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR33_TOTAL().compareTo(up.getR33_TOTAL()) != 0) {
			fieldNames.add("Total");
			oldChange.append("R33_COL_14: ").append(up.getR33_TOTAL()).append("; ");
			newChange.append("R33_COL_14: ").append(brf300_ENTITY.getR33_TOTAL()).append("; ");
			rowEdited = true;
		}
		
		
		if (brf300_ENTITY.getR34_S_NO().compareTo(up.getR34_S_NO()) != 0) {
			fieldNames.add("S.No");
			oldChange.append("R34_COL_1: ").append(up.getR34_S_NO()).append("; ");
			newChange.append("R34_COL_1: ").append(brf300_ENTITY.getR34_S_NO()).append("; ");
			rowEdited = true;
		}

		if (brf300_ENTITY.getR34_HEADQUATERS().compareTo(up.getR34_HEADQUATERS()) != 0) {
			fieldNames.add("Additional details - No. of employees as Executive management ");
			oldChange.append("R34_COL_2: ").append(up.getR34_HEADQUATERS()).append("; ");
			newChange.append("R34_COL_2: ").append(brf300_ENTITY.getR34_HEADQUATERS()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR34_ABU_DHABI().compareTo(up.getR34_ABU_DHABI()) != 0) {
			fieldNames.add("Abu Dhabi - Abu Dhabi City");
			oldChange.append("R34_COL_3: ").append(up.getR34_ABU_DHABI()).append("; ");
			newChange.append("R34_COL_3: ").append(brf300_ENTITY.getR34_ABU_DHABI()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR34_WESTERNM_REGION().compareTo(up.getR34_WESTERNM_REGION()) != 0) {
			fieldNames.add("Abu Dhabi - Western Region");
			oldChange.append("R34_COL_4: ").append(up.getR34_WESTERNM_REGION()).append("; ");
			newChange.append("R34_COL_4: ").append(brf300_ENTITY.getR34_WESTERNM_REGION()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR34_AL_AIN().compareTo(up.getR34_AL_AIN()) != 0) {
			fieldNames.add("Abu Dhabi - Al Ain");
			oldChange.append("R34_COL_5: ").append(up.getR34_AL_AIN()).append("; ");
			newChange.append("R34_COL_5: ").append(brf300_ENTITY.getR34_AL_AIN()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR34_ISLAND().compareTo(up.getR34_ISLAND()) != 0) {
			fieldNames.add("Abu Dhabi - Islands");
			oldChange.append("R34_COL_6: ").append(up.getR34_ISLAND()).append("; ");
			newChange.append("R34_COL_6: ").append(brf300_ENTITY.getR34_ISLAND()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR34_DUBAI().compareTo(up.getR34_DUBAI()) != 0) {
			fieldNames.add("Dubai");
			oldChange.append("R34_COL_7: ").append(up.getR34_DUBAI()).append("; ");
			newChange.append("R34_COL_7: ").append(brf300_ENTITY.getR34_DUBAI()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR34_SHARJAH().compareTo(up.getR34_SHARJAH()) != 0) {
			fieldNames.add("Sharjah");
			oldChange.append("R34_COL_8: ").append(up.getR34_SHARJAH()).append("; ");
			newChange.append("R34_COL_8: ").append(brf300_ENTITY.getR34_SHARJAH()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR34_AJMAN().compareTo(up.getR34_AJMAN()) != 0) {
			fieldNames.add("Ajman");
			oldChange.append("R34_COL_9: ").append(up.getR34_AJMAN()).append("; ");
			newChange.append("R34_COL_9: ").append(brf300_ENTITY.getR34_AJMAN()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR34_RAS_AL().compareTo(up.getR34_RAS_AL()) != 0) {
			fieldNames.add("Ras al-Khaimah");
			oldChange.append("R34_COL_10: ").append(up.getR34_RAS_AL()).append("; ");
			newChange.append("R34_COL_10: ").append(brf300_ENTITY.getR34_RAS_AL()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR34_UMM_AL().compareTo(up.getR34_UMM_AL()) != 0) {
			fieldNames.add("Umm al-Quwain");
			oldChange.append("R34_COL_11: ").append(up.getR34_UMM_AL()).append("; ");
			newChange.append("R34_COL_11: ").append(brf300_ENTITY.getR34_UMM_AL()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR34_FUJAIRAH().compareTo(up.getR34_FUJAIRAH()) != 0) {
			fieldNames.add("Fujairah");
			oldChange.append("R34_COL_12: ").append(up.getR34_FUJAIRAH()).append("; ");
			newChange.append("R34_COL_12: ").append(brf300_ENTITY.getR34_FUJAIRAH()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR34_ABU_SUB().compareTo(up.getR34_ABU_SUB()) != 0) {
			fieldNames.add("Abu Dhabi Sub-total (D+E+F+G)");
			oldChange.append("R34_COL_13: ").append(up.getR34_ABU_SUB()).append("; ");
			newChange.append("R34_COL_13: ").append(brf300_ENTITY.getR34_ABU_SUB()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR34_TOTAL().compareTo(up.getR34_TOTAL()) != 0) {
			fieldNames.add("Total");
			oldChange.append("R34_COL_14: ").append(up.getR34_TOTAL()).append("; ");
			newChange.append("R34_COL_14: ").append(brf300_ENTITY.getR34_TOTAL()).append("; ");
			rowEdited = true;
		}
		
		
		if (brf300_ENTITY.getR35_S_NO().compareTo(up.getR35_S_NO()) != 0) {
			fieldNames.add("S.No");
			oldChange.append("R35_COL_1: ").append(up.getR35_S_NO()).append("; ");
			newChange.append("R35_COL_1: ").append(brf300_ENTITY.getR35_S_NO()).append("; ");
			rowEdited = true;
		}

		if (brf300_ENTITY.getR35_HEADQUATERS().compareTo(up.getR35_HEADQUATERS()) != 0) {
			fieldNames.add("Additional details - No. of National employees as Executive management");
			oldChange.append("R35_COL_2: ").append(up.getR35_HEADQUATERS()).append("; ");
			newChange.append("R35_COL_2: ").append(brf300_ENTITY.getR35_HEADQUATERS()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR35_ABU_DHABI().compareTo(up.getR35_ABU_DHABI()) != 0) {
			fieldNames.add("Abu Dhabi - Abu Dhabi City");
			oldChange.append("R35_COL_3: ").append(up.getR35_ABU_DHABI()).append("; ");
			newChange.append("R35_COL_3: ").append(brf300_ENTITY.getR35_ABU_DHABI()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR35_WESTERNM_REGION().compareTo(up.getR35_WESTERNM_REGION()) != 0) {
			fieldNames.add("Abu Dhabi - Western Region");
			oldChange.append("R35_COL_4: ").append(up.getR35_WESTERNM_REGION()).append("; ");
			newChange.append("R35_COL_4: ").append(brf300_ENTITY.getR35_WESTERNM_REGION()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR35_AL_AIN().compareTo(up.getR35_AL_AIN()) != 0) {
			fieldNames.add("Abu Dhabi - Al Ain");
			oldChange.append("R35_COL_5: ").append(up.getR35_AL_AIN()).append("; ");
			newChange.append("R35_COL_5: ").append(brf300_ENTITY.getR35_AL_AIN()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR35_ISLAND().compareTo(up.getR35_ISLAND()) != 0) {
			fieldNames.add("Abu Dhabi - Islands");
			oldChange.append("R35_COL_6: ").append(up.getR35_ISLAND()).append("; ");
			newChange.append("R35_COL_6: ").append(brf300_ENTITY.getR35_ISLAND()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR35_DUBAI().compareTo(up.getR35_DUBAI()) != 0) {
			fieldNames.add("Dubai");
			oldChange.append("R35_COL_7: ").append(up.getR35_DUBAI()).append("; ");
			newChange.append("R35_COL_7: ").append(brf300_ENTITY.getR35_DUBAI()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR35_SHARJAH().compareTo(up.getR35_SHARJAH()) != 0) {
			fieldNames.add("Sharjah");
			oldChange.append("R35_COL_8: ").append(up.getR35_SHARJAH()).append("; ");
			newChange.append("R35_COL_8: ").append(brf300_ENTITY.getR35_SHARJAH()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR35_AJMAN().compareTo(up.getR35_AJMAN()) != 0) {
			fieldNames.add("Ajman");
			oldChange.append("R35_COL_9: ").append(up.getR35_AJMAN()).append("; ");
			newChange.append("R35_COL_9: ").append(brf300_ENTITY.getR35_AJMAN()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR35_RAS_AL().compareTo(up.getR35_RAS_AL()) != 0) {
			fieldNames.add("Ras al-Khaimah");
			oldChange.append("R35_COL_10: ").append(up.getR35_RAS_AL()).append("; ");
			newChange.append("R35_COL_10: ").append(brf300_ENTITY.getR35_RAS_AL()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR35_UMM_AL().compareTo(up.getR35_UMM_AL()) != 0) {
			fieldNames.add("Umm al-Quwain");
			oldChange.append("R35_COL_11: ").append(up.getR35_UMM_AL()).append("; ");
			newChange.append("R35_COL_11: ").append(brf300_ENTITY.getR35_UMM_AL()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR35_FUJAIRAH().compareTo(up.getR35_FUJAIRAH()) != 0) {
			fieldNames.add("Fujairah");
			oldChange.append("R35_COL_12: ").append(up.getR35_FUJAIRAH()).append("; ");
			newChange.append("R35_COL_12: ").append(brf300_ENTITY.getR35_FUJAIRAH()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR35_ABU_SUB().compareTo(up.getR35_ABU_SUB()) != 0) {
			fieldNames.add("Abu Dhabi Sub-total (D+E+F+G)");
			oldChange.append("R35_COL_13: ").append(up.getR35_ABU_SUB()).append("; ");
			newChange.append("R35_COL_13: ").append(brf300_ENTITY.getR35_ABU_SUB()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR35_TOTAL().compareTo(up.getR35_TOTAL()) != 0) {
			fieldNames.add("Total");
			oldChange.append("R35_COL_14: ").append(up.getR35_TOTAL()).append("; ");
			newChange.append("R35_COL_14: ").append(brf300_ENTITY.getR35_TOTAL()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR36_S_NO().compareTo(up.getR36_S_NO()) != 0) {
			fieldNames.add("S.No");
			oldChange.append("R36_COL_1: ").append(up.getR36_S_NO()).append("; ");
			newChange.append("R36_COL_1: ").append(brf300_ENTITY.getR36_S_NO()).append("; ");
			rowEdited = true;
		}

		if (brf300_ENTITY.getR36_HEADQUATERS().compareTo(up.getR36_HEADQUATERS()) != 0) {
			fieldNames.add("Additional details - No. of National Female employees as Executive management");
			oldChange.append("R36_COL_2: ").append(up.getR36_HEADQUATERS()).append("; ");
			newChange.append("R36_COL_2: ").append(brf300_ENTITY.getR36_HEADQUATERS()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR36_ABU_DHABI().compareTo(up.getR36_ABU_DHABI()) != 0) {
			fieldNames.add("Abu Dhabi - Abu Dhabi City");
			oldChange.append("R36_COL_3: ").append(up.getR36_ABU_DHABI()).append("; ");
			newChange.append("R36_COL_3: ").append(brf300_ENTITY.getR36_ABU_DHABI()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR36_WESTERNM_REGION().compareTo(up.getR36_WESTERNM_REGION()) != 0) {
			fieldNames.add("Abu Dhabi - Western Region");
			oldChange.append("R36_COL_4: ").append(up.getR36_WESTERNM_REGION()).append("; ");
			newChange.append("R36_COL_4: ").append(brf300_ENTITY.getR36_WESTERNM_REGION()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR36_AL_AIN().compareTo(up.getR36_AL_AIN()) != 0) {
			fieldNames.add("Abu Dhabi - Al Ain");
			oldChange.append("R36_COL_5: ").append(up.getR36_AL_AIN()).append("; ");
			newChange.append("R36_COL_5: ").append(brf300_ENTITY.getR36_AL_AIN()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR36_ISLAND().compareTo(up.getR36_ISLAND()) != 0) {
			fieldNames.add("Abu Dhabi - Islands");
			oldChange.append("R36_COL_6: ").append(up.getR36_ISLAND()).append("; ");
			newChange.append("R36_COL_6: ").append(brf300_ENTITY.getR36_ISLAND()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR36_DUBAI().compareTo(up.getR36_DUBAI()) != 0) {
			fieldNames.add("Dubai");
			oldChange.append("R36_COL_7: ").append(up.getR36_DUBAI()).append("; ");
			newChange.append("R36_COL_7: ").append(brf300_ENTITY.getR36_DUBAI()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR36_SHARJAH().compareTo(up.getR36_SHARJAH()) != 0) {
			fieldNames.add("Sharjah");
			oldChange.append("R36_COL_8: ").append(up.getR36_SHARJAH()).append("; ");
			newChange.append("R36_COL_8: ").append(brf300_ENTITY.getR36_SHARJAH()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR36_AJMAN().compareTo(up.getR36_AJMAN()) != 0) {
			fieldNames.add("Ajman");
			oldChange.append("R36_COL_9: ").append(up.getR36_AJMAN()).append("; ");
			newChange.append("R36_COL_9: ").append(brf300_ENTITY.getR36_AJMAN()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR36_RAS_AL().compareTo(up.getR36_RAS_AL()) != 0) {
			fieldNames.add("Ras al-Khaimah");
			oldChange.append("R36_COL_10: ").append(up.getR36_RAS_AL()).append("; ");
			newChange.append("R36_COL_10: ").append(brf300_ENTITY.getR36_RAS_AL()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR36_UMM_AL().compareTo(up.getR36_UMM_AL()) != 0) {
			fieldNames.add("Umm al-Quwain");
			oldChange.append("R36_COL_11: ").append(up.getR36_UMM_AL()).append("; ");
			newChange.append("R36_COL_11: ").append(brf300_ENTITY.getR36_UMM_AL()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR36_FUJAIRAH().compareTo(up.getR36_FUJAIRAH()) != 0) {
			fieldNames.add("Fujairah");
			oldChange.append("R36_COL_12: ").append(up.getR36_FUJAIRAH()).append("; ");
			newChange.append("R36_COL_12: ").append(brf300_ENTITY.getR36_FUJAIRAH()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR36_ABU_SUB().compareTo(up.getR36_ABU_SUB()) != 0) {
			fieldNames.add("Abu Dhabi Sub-total (D+E+F+G)");
			oldChange.append("R36_COL_13: ").append(up.getR36_ABU_SUB()).append("; ");
			newChange.append("R36_COL_13: ").append(brf300_ENTITY.getR36_ABU_SUB()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR36_TOTAL().compareTo(up.getR36_TOTAL()) != 0) {
			fieldNames.add("Total");
			oldChange.append("R36_COL_14: ").append(up.getR36_TOTAL()).append("; ");
			newChange.append("R36_COL_14: ").append(brf300_ENTITY.getR36_TOTAL()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR37_S_NO().compareTo(up.getR37_S_NO()) != 0) {
			fieldNames.add("S.No");
			oldChange.append("R37_COL_1: ").append(up.getR37_S_NO()).append("; ");
			newChange.append("R37_COL_1: ").append(brf300_ENTITY.getR37_S_NO()).append("; ");
			rowEdited = true;
		}

		if (brf300_ENTITY.getR37_HEADQUATERS().compareTo(up.getR37_HEADQUATERS()) != 0) {
			fieldNames.add("Additional details - No. of National employees promoted to managerial level as career progression during the year");
			oldChange.append("R37_COL_2: ").append(up.getR37_HEADQUATERS()).append("; ");
			newChange.append("R37_COL_2: ").append(brf300_ENTITY.getR37_HEADQUATERS()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR37_ABU_DHABI().compareTo(up.getR37_ABU_DHABI()) != 0) {
			fieldNames.add("Abu Dhabi - Abu Dhabi City");
			oldChange.append("R37_COL_3: ").append(up.getR37_ABU_DHABI()).append("; ");
			newChange.append("R37_COL_3: ").append(brf300_ENTITY.getR37_ABU_DHABI()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR37_WESTERNM_REGION().compareTo(up.getR37_WESTERNM_REGION()) != 0) {
			fieldNames.add("Abu Dhabi - Western Region");
			oldChange.append("R37_COL_4: ").append(up.getR37_WESTERNM_REGION()).append("; ");
			newChange.append("R37_COL_4: ").append(brf300_ENTITY.getR37_WESTERNM_REGION()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR37_AL_AIN().compareTo(up.getR37_AL_AIN()) != 0) {
			fieldNames.add("Abu Dhabi - Al Ain");
			oldChange.append("R37_COL_5: ").append(up.getR37_AL_AIN()).append("; ");
			newChange.append("R37_COL_5: ").append(brf300_ENTITY.getR37_AL_AIN()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR37_ISLAND().compareTo(up.getR37_ISLAND()) != 0) {
			fieldNames.add("Abu Dhabi - Islands");
			oldChange.append("R37_COL_6: ").append(up.getR37_ISLAND()).append("; ");
			newChange.append("R37_COL_6: ").append(brf300_ENTITY.getR37_ISLAND()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR37_DUBAI().compareTo(up.getR37_DUBAI()) != 0) {
			fieldNames.add("Dubai");
			oldChange.append("R37_COL_7: ").append(up.getR37_DUBAI()).append("; ");
			newChange.append("R37_COL_7: ").append(brf300_ENTITY.getR37_DUBAI()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR37_SHARJAH().compareTo(up.getR37_SHARJAH()) != 0) {
			fieldNames.add("Sharjah");
			oldChange.append("R37_COL_8: ").append(up.getR37_SHARJAH()).append("; ");
			newChange.append("R37_COL_8: ").append(brf300_ENTITY.getR37_SHARJAH()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR37_AJMAN().compareTo(up.getR37_AJMAN()) != 0) {
			fieldNames.add("Ajman");
			oldChange.append("R37_COL_9: ").append(up.getR37_AJMAN()).append("; ");
			newChange.append("R37_COL_9: ").append(brf300_ENTITY.getR37_AJMAN()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR37_RAS_AL().compareTo(up.getR37_RAS_AL()) != 0) {
			fieldNames.add("Ras al-Khaimah");
			oldChange.append("R37_COL_10: ").append(up.getR37_RAS_AL()).append("; ");
			newChange.append("R37_COL_10: ").append(brf300_ENTITY.getR37_RAS_AL()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR37_UMM_AL().compareTo(up.getR37_UMM_AL()) != 0) {
			fieldNames.add("Umm al-Quwain");
			oldChange.append("R37_COL_11: ").append(up.getR37_UMM_AL()).append("; ");
			newChange.append("R37_COL_11: ").append(brf300_ENTITY.getR37_UMM_AL()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR37_FUJAIRAH().compareTo(up.getR37_FUJAIRAH()) != 0) {
			fieldNames.add("Fujairah");
			oldChange.append("R37_COL_12: ").append(up.getR37_FUJAIRAH()).append("; ");
			newChange.append("R37_COL_12: ").append(brf300_ENTITY.getR37_FUJAIRAH()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR37_ABU_SUB().compareTo(up.getR37_ABU_SUB()) != 0) {
			fieldNames.add("Abu Dhabi Sub-total (D+E+F+G)");
			oldChange.append("R37_COL_13: ").append(up.getR37_ABU_SUB()).append("; ");
			newChange.append("R37_COL_13: ").append(brf300_ENTITY.getR37_ABU_SUB()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR37_TOTAL().compareTo(up.getR37_TOTAL()) != 0) {
			fieldNames.add("Total");
			oldChange.append("R37_COL_14: ").append(up.getR37_TOTAL()).append("; ");
			newChange.append("R37_COL_14: ").append(brf300_ENTITY.getR37_TOTAL()).append("; ");
			rowEdited = true;
		}
		
		
		if (brf300_ENTITY.getR38_S_NO().compareTo(up.getR38_S_NO()) != 0) {
			fieldNames.add("S.No");
			oldChange.append("R38_COL_1: ").append(up.getR38_S_NO()).append("; ");
			newChange.append("R38_COL_1: ").append(brf300_ENTITY.getR38_S_NO()).append("; ");
			rowEdited = true;
		}

		if (brf300_ENTITY.getR38_HEADQUATERS().compareTo(up.getR38_HEADQUATERS()) != 0) {
			fieldNames.add("Additional details - No. of National Female employees promoted to managerial level as career progression during the year");
			oldChange.append("R38_COL_2: ").append(up.getR38_HEADQUATERS()).append("; ");
			newChange.append("R38_COL_2: ").append(brf300_ENTITY.getR38_HEADQUATERS()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR38_ABU_DHABI().compareTo(up.getR38_ABU_DHABI()) != 0) {
			fieldNames.add("Abu Dhabi - Abu Dhabi City");
			oldChange.append("R38_COL_3: ").append(up.getR38_ABU_DHABI()).append("; ");
			newChange.append("R38_COL_3: ").append(brf300_ENTITY.getR38_ABU_DHABI()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR38_WESTERNM_REGION().compareTo(up.getR38_WESTERNM_REGION()) != 0) {
			fieldNames.add("Abu Dhabi - Western Region");
			oldChange.append("R38_COL_4: ").append(up.getR38_WESTERNM_REGION()).append("; ");
			newChange.append("R38_COL_4: ").append(brf300_ENTITY.getR38_WESTERNM_REGION()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR38_AL_AIN().compareTo(up.getR38_AL_AIN()) != 0) {
			fieldNames.add("Abu Dhabi - Al Ain");
			oldChange.append("R38_COL_5: ").append(up.getR38_AL_AIN()).append("; ");
			newChange.append("R38_COL_5: ").append(brf300_ENTITY.getR38_AL_AIN()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR38_ISLAND().compareTo(up.getR38_ISLAND()) != 0) {
			fieldNames.add("Abu Dhabi - Islands");
			oldChange.append("R38_COL_6: ").append(up.getR38_ISLAND()).append("; ");
			newChange.append("R38_COL_6: ").append(brf300_ENTITY.getR38_ISLAND()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR38_DUBAI().compareTo(up.getR38_DUBAI()) != 0) {
			fieldNames.add("Dubai");
			oldChange.append("R38_COL_7: ").append(up.getR38_DUBAI()).append("; ");
			newChange.append("R38_COL_7: ").append(brf300_ENTITY.getR38_DUBAI()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR38_SHARJAH().compareTo(up.getR38_SHARJAH()) != 0) {
			fieldNames.add("Sharjah");
			oldChange.append("R38_COL_8: ").append(up.getR38_SHARJAH()).append("; ");
			newChange.append("R38_COL_8: ").append(brf300_ENTITY.getR38_SHARJAH()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR38_AJMAN().compareTo(up.getR38_AJMAN()) != 0) {
			fieldNames.add("Ajman");
			oldChange.append("R38_COL_9: ").append(up.getR38_AJMAN()).append("; ");
			newChange.append("R38_COL_9: ").append(brf300_ENTITY.getR38_AJMAN()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR38_RAS_AL().compareTo(up.getR38_RAS_AL()) != 0) {
			fieldNames.add("Ras al-Khaimah");
			oldChange.append("R38_COL_10: ").append(up.getR38_RAS_AL()).append("; ");
			newChange.append("R38_COL_10: ").append(brf300_ENTITY.getR38_RAS_AL()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR38_UMM_AL().compareTo(up.getR38_UMM_AL()) != 0) {
			fieldNames.add("Umm al-Quwain");
			oldChange.append("R38_COL_11: ").append(up.getR38_UMM_AL()).append("; ");
			newChange.append("R38_COL_11: ").append(brf300_ENTITY.getR38_UMM_AL()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR38_FUJAIRAH().compareTo(up.getR38_FUJAIRAH()) != 0) {
			fieldNames.add("Fujairah");
			oldChange.append("R38_COL_12: ").append(up.getR38_FUJAIRAH()).append("; ");
			newChange.append("R38_COL_12: ").append(brf300_ENTITY.getR38_FUJAIRAH()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR38_ABU_SUB().compareTo(up.getR38_ABU_SUB()) != 0) {
			fieldNames.add("Abu Dhabi Sub-total (D+E+F+G)");
			oldChange.append("R38_COL_13: ").append(up.getR38_ABU_SUB()).append("; ");
			newChange.append("R38_COL_13: ").append(brf300_ENTITY.getR38_ABU_SUB()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR38_TOTAL().compareTo(up.getR38_TOTAL()) != 0) {
			fieldNames.add("Total");
			oldChange.append("R38_COL_14: ").append(up.getR38_TOTAL()).append("; ");
			newChange.append("R38_COL_14: ").append(brf300_ENTITY.getR38_TOTAL()).append("; ");
			rowEdited = true;
		}
		
		
		
		if (brf300_ENTITY.getR39_S_NO().compareTo(up.getR39_S_NO()) != 0) {
			fieldNames.add("S.No");
			oldChange.append("R39_COL_1: ").append(up.getR39_S_NO()).append("; ");
			newChange.append("R39_COL_1: ").append(brf300_ENTITY.getR39_S_NO()).append("; ");
			rowEdited = true;
		}

		if (brf300_ENTITY.getR39_HEADQUATERS().compareTo(up.getR39_HEADQUATERS()) != 0) {
			fieldNames.add("Additional details - No. of Resigned Non-managerial National employees during the year");
			oldChange.append("R39_COL_2: ").append(up.getR39_HEADQUATERS()).append("; ");
			newChange.append("R39_COL_2: ").append(brf300_ENTITY.getR39_HEADQUATERS()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR39_ABU_DHABI().compareTo(up.getR39_ABU_DHABI()) != 0) {
			fieldNames.add("Abu Dhabi - Abu Dhabi City");
			oldChange.append("R39_COL_3: ").append(up.getR39_ABU_DHABI()).append("; ");
			newChange.append("R39_COL_3: ").append(brf300_ENTITY.getR39_ABU_DHABI()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR39_WESTERNM_REGION().compareTo(up.getR39_WESTERNM_REGION()) != 0) {
			fieldNames.add("Abu Dhabi - Western Region");
			oldChange.append("R39_COL_4: ").append(up.getR39_WESTERNM_REGION()).append("; ");
			newChange.append("R39_COL_4: ").append(brf300_ENTITY.getR39_WESTERNM_REGION()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR39_AL_AIN().compareTo(up.getR39_AL_AIN()) != 0) {
			fieldNames.add("Abu Dhabi - Al Ain");
			oldChange.append("R39_COL_5: ").append(up.getR39_AL_AIN()).append("; ");
			newChange.append("R39_COL_5: ").append(brf300_ENTITY.getR39_AL_AIN()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR39_ISLAND().compareTo(up.getR39_ISLAND()) != 0) {
			fieldNames.add("Abu Dhabi - Islands");
			oldChange.append("R39_COL_6: ").append(up.getR39_ISLAND()).append("; ");
			newChange.append("R39_COL_6: ").append(brf300_ENTITY.getR39_ISLAND()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR39_DUBAI().compareTo(up.getR39_DUBAI()) != 0) {
			fieldNames.add("Dubai");
			oldChange.append("R39_COL_7: ").append(up.getR39_DUBAI()).append("; ");
			newChange.append("R39_COL_7: ").append(brf300_ENTITY.getR39_DUBAI()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR39_SHARJAH().compareTo(up.getR39_SHARJAH()) != 0) {
			fieldNames.add("Sharjah");
			oldChange.append("R39_COL_8: ").append(up.getR39_SHARJAH()).append("; ");
			newChange.append("R39_COL_8: ").append(brf300_ENTITY.getR39_SHARJAH()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR39_AJMAN().compareTo(up.getR39_AJMAN()) != 0) {
			fieldNames.add("Ajman");
			oldChange.append("R39_COL_9: ").append(up.getR39_AJMAN()).append("; ");
			newChange.append("R39_COL_9: ").append(brf300_ENTITY.getR39_AJMAN()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR39_RAS_AL().compareTo(up.getR39_RAS_AL()) != 0) {
			fieldNames.add("Ras al-Khaimah");
			oldChange.append("R39_COL_10: ").append(up.getR39_RAS_AL()).append("; ");
			newChange.append("R39_COL_10: ").append(brf300_ENTITY.getR39_RAS_AL()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR39_UMM_AL().compareTo(up.getR39_UMM_AL()) != 0) {
			fieldNames.add("Umm al-Quwain");
			oldChange.append("R39_COL_11: ").append(up.getR39_UMM_AL()).append("; ");
			newChange.append("R39_COL_11: ").append(brf300_ENTITY.getR39_UMM_AL()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR39_FUJAIRAH().compareTo(up.getR39_FUJAIRAH()) != 0) {
			fieldNames.add("Fujairah");
			oldChange.append("R39_COL_12: ").append(up.getR39_FUJAIRAH()).append("; ");
			newChange.append("R39_COL_12: ").append(brf300_ENTITY.getR39_FUJAIRAH()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR39_ABU_SUB().compareTo(up.getR39_ABU_SUB()) != 0) {
			fieldNames.add("Abu Dhabi Sub-total (D+E+F+G)");
			oldChange.append("R39_COL_13: ").append(up.getR39_ABU_SUB()).append("; ");
			newChange.append("R39_COL_13: ").append(brf300_ENTITY.getR39_ABU_SUB()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR39_TOTAL().compareTo(up.getR39_TOTAL()) != 0) {
			fieldNames.add("Total");
			oldChange.append("R39_COL_14: ").append(up.getR39_TOTAL()).append("; ");
			newChange.append("R39_COL_14: ").append(brf300_ENTITY.getR39_TOTAL()).append("; ");
			rowEdited = true;
		}
		
		
		if (brf300_ENTITY.getR40_S_NO().compareTo(up.getR40_S_NO()) != 0) {
			fieldNames.add("S.No");
			oldChange.append("R40_COL_1: ").append(up.getR40_S_NO()).append("; ");
			newChange.append("R40_COL_1: ").append(brf300_ENTITY.getR40_S_NO()).append("; ");
			rowEdited = true;
		}

		if (brf300_ENTITY.getR40_HEADQUATERS().compareTo(up.getR40_HEADQUATERS()) != 0) {
			fieldNames.add("Additional details - No. of Resigned Non-managerial National Female employees during the year");
			oldChange.append("R40_COL_2: ").append(up.getR40_HEADQUATERS()).append("; ");
			newChange.append("R40_COL_2: ").append(brf300_ENTITY.getR40_HEADQUATERS()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR40_ABU_DHABI().compareTo(up.getR40_ABU_DHABI()) != 0) {
			fieldNames.add("Abu Dhabi - Abu Dhabi City");
			oldChange.append("R40_COL_3: ").append(up.getR40_ABU_DHABI()).append("; ");
			newChange.append("R40_COL_3: ").append(brf300_ENTITY.getR40_ABU_DHABI()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR40_WESTERNM_REGION().compareTo(up.getR40_WESTERNM_REGION()) != 0) {
			fieldNames.add("Abu Dhabi - Western Region");
			oldChange.append("R40_COL_4: ").append(up.getR40_WESTERNM_REGION()).append("; ");
			newChange.append("R40_COL_4: ").append(brf300_ENTITY.getR40_WESTERNM_REGION()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR40_AL_AIN().compareTo(up.getR40_AL_AIN()) != 0) {
			fieldNames.add("Abu Dhabi - Al Ain");
			oldChange.append("R40_COL_5: ").append(up.getR40_AL_AIN()).append("; ");
			newChange.append("R40_COL_5: ").append(brf300_ENTITY.getR40_AL_AIN()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR40_ISLAND().compareTo(up.getR40_ISLAND()) != 0) {
			fieldNames.add("Abu Dhabi - Islands");
			oldChange.append("R40_COL_6: ").append(up.getR40_ISLAND()).append("; ");
			newChange.append("R40_COL_6: ").append(brf300_ENTITY.getR40_ISLAND()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR40_DUBAI().compareTo(up.getR40_DUBAI()) != 0) {
			fieldNames.add("Dubai");
			oldChange.append("R40_COL_7: ").append(up.getR40_DUBAI()).append("; ");
			newChange.append("R40_COL_7: ").append(brf300_ENTITY.getR40_DUBAI()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR40_SHARJAH().compareTo(up.getR40_SHARJAH()) != 0) {
			fieldNames.add("Sharjah");
			oldChange.append("R40_COL_8: ").append(up.getR40_SHARJAH()).append("; ");
			newChange.append("R40_COL_8: ").append(brf300_ENTITY.getR40_SHARJAH()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR40_AJMAN().compareTo(up.getR40_AJMAN()) != 0) {
			fieldNames.add("Ajman");
			oldChange.append("R40_COL_9: ").append(up.getR40_AJMAN()).append("; ");
			newChange.append("R40_COL_9: ").append(brf300_ENTITY.getR40_AJMAN()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR40_RAS_AL().compareTo(up.getR40_RAS_AL()) != 0) {
			fieldNames.add("Ras al-Khaimah");
			oldChange.append("R40_COL_10: ").append(up.getR40_RAS_AL()).append("; ");
			newChange.append("R40_COL_10: ").append(brf300_ENTITY.getR40_RAS_AL()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR40_UMM_AL().compareTo(up.getR40_UMM_AL()) != 0) {
			fieldNames.add("Umm al-Quwain");
			oldChange.append("R40_COL_11: ").append(up.getR40_UMM_AL()).append("; ");
			newChange.append("R40_COL_11: ").append(brf300_ENTITY.getR40_UMM_AL()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR40_FUJAIRAH().compareTo(up.getR40_FUJAIRAH()) != 0) {
			fieldNames.add("Fujairah");
			oldChange.append("R40_COL_12: ").append(up.getR40_FUJAIRAH()).append("; ");
			newChange.append("R40_COL_12: ").append(brf300_ENTITY.getR40_FUJAIRAH()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR40_ABU_SUB().compareTo(up.getR40_ABU_SUB()) != 0) {
			fieldNames.add("Abu Dhabi Sub-total (D+E+F+G)");
			oldChange.append("R40_COL_13: ").append(up.getR40_ABU_SUB()).append("; ");
			newChange.append("R40_COL_13: ").append(brf300_ENTITY.getR40_ABU_SUB()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR40_TOTAL().compareTo(up.getR40_TOTAL()) != 0) {
			fieldNames.add("Total");
			oldChange.append("R40_COL_14: ").append(up.getR40_TOTAL()).append("; ");
			newChange.append("R40_COL_14: ").append(brf300_ENTITY.getR40_TOTAL()).append("; ");
			rowEdited = true;
		}
		
		
		if (brf300_ENTITY.getR41_S_NO().compareTo(up.getR41_S_NO()) != 0) {
			fieldNames.add("S.No");
			oldChange.append("R41_COL_1: ").append(up.getR41_S_NO()).append("; ");
			newChange.append("R41_COL_1: ").append(brf300_ENTITY.getR41_S_NO()).append("; ");
			rowEdited = true;
		}

		if (brf300_ENTITY.getR41_HEADQUATERS().compareTo(up.getR41_HEADQUATERS()) != 0) {
			fieldNames.add("Additional details - No. of Resigned managerial National employees during the year");
			oldChange.append("R41_COL_2: ").append(up.getR41_HEADQUATERS()).append("; ");
			newChange.append("R41_COL_2: ").append(brf300_ENTITY.getR41_HEADQUATERS()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR41_ABU_DHABI().compareTo(up.getR41_ABU_DHABI()) != 0) {
			fieldNames.add("Abu Dhabi - Abu Dhabi City");
			oldChange.append("R41_COL_3: ").append(up.getR41_ABU_DHABI()).append("; ");
			newChange.append("R41_COL_3: ").append(brf300_ENTITY.getR41_ABU_DHABI()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR41_WESTERNM_REGION().compareTo(up.getR41_WESTERNM_REGION()) != 0) {
			fieldNames.add("Abu Dhabi - Western Region");
			oldChange.append("R41_COL_4: ").append(up.getR41_WESTERNM_REGION()).append("; ");
			newChange.append("R41_COL_4: ").append(brf300_ENTITY.getR41_WESTERNM_REGION()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR41_AL_AIN().compareTo(up.getR41_AL_AIN()) != 0) {
			fieldNames.add("Abu Dhabi - Al Ain");
			oldChange.append("R41_COL_5: ").append(up.getR41_AL_AIN()).append("; ");
			newChange.append("R41_COL_5: ").append(brf300_ENTITY.getR41_AL_AIN()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR41_ISLAND().compareTo(up.getR41_ISLAND()) != 0) {
			fieldNames.add("Abu Dhabi - Islands");
			oldChange.append("R41_COL_6: ").append(up.getR41_ISLAND()).append("; ");
			newChange.append("R41_COL_6: ").append(brf300_ENTITY.getR41_ISLAND()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR41_DUBAI().compareTo(up.getR41_DUBAI()) != 0) {
			fieldNames.add("Dubai");
			oldChange.append("R41_COL_7: ").append(up.getR41_DUBAI()).append("; ");
			newChange.append("R41_COL_7: ").append(brf300_ENTITY.getR41_DUBAI()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR41_SHARJAH().compareTo(up.getR41_SHARJAH()) != 0) {
			fieldNames.add("Sharjah");
			oldChange.append("R41_COL_8: ").append(up.getR41_SHARJAH()).append("; ");
			newChange.append("R41_COL_8: ").append(brf300_ENTITY.getR41_SHARJAH()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR41_AJMAN().compareTo(up.getR41_AJMAN()) != 0) {
			fieldNames.add("Ajman");
			oldChange.append("R41_COL_9: ").append(up.getR41_AJMAN()).append("; ");
			newChange.append("R41_COL_9: ").append(brf300_ENTITY.getR41_AJMAN()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR41_RAS_AL().compareTo(up.getR41_RAS_AL()) != 0) {
			fieldNames.add("Ras al-Khaimah");
			oldChange.append("R41_COL_10: ").append(up.getR41_RAS_AL()).append("; ");
			newChange.append("R41_COL_10: ").append(brf300_ENTITY.getR41_RAS_AL()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR41_UMM_AL().compareTo(up.getR41_UMM_AL()) != 0) {
			fieldNames.add("Umm al-Quwain");
			oldChange.append("R41_COL_11: ").append(up.getR41_UMM_AL()).append("; ");
			newChange.append("R41_COL_11: ").append(brf300_ENTITY.getR41_UMM_AL()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR41_FUJAIRAH().compareTo(up.getR41_FUJAIRAH()) != 0) {
			fieldNames.add("Fujairah");
			oldChange.append("R41_COL_12: ").append(up.getR41_FUJAIRAH()).append("; ");
			newChange.append("R41_COL_12: ").append(brf300_ENTITY.getR41_FUJAIRAH()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR41_ABU_SUB().compareTo(up.getR41_ABU_SUB()) != 0) {
			fieldNames.add("Abu Dhabi Sub-total (D+E+F+G)");
			oldChange.append("R41_COL_13: ").append(up.getR41_ABU_SUB()).append("; ");
			newChange.append("R41_COL_13: ").append(brf300_ENTITY.getR41_ABU_SUB()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR41_TOTAL().compareTo(up.getR41_TOTAL()) != 0) {
			fieldNames.add("Total");
			oldChange.append("R41_COL_14: ").append(up.getR41_TOTAL()).append("; ");
			newChange.append("R41_COL_14: ").append(brf300_ENTITY.getR41_TOTAL()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR42_S_NO().compareTo(up.getR42_S_NO()) != 0) {
			fieldNames.add("S.No");
			oldChange.append("R42_COL_1: ").append(up.getR42_S_NO()).append("; ");
			newChange.append("R42_COL_1: ").append(brf300_ENTITY.getR42_S_NO()).append("; ");
			rowEdited = true;
		}

		if (brf300_ENTITY.getR42_HEADQUATERS().compareTo(up.getR42_HEADQUATERS()) != 0) {
			fieldNames.add("Additional details - No. of Resigned managerial National Female employees during the year");
			oldChange.append("R42_COL_2: ").append(up.getR42_HEADQUATERS()).append("; ");
			newChange.append("R42_COL_2: ").append(brf300_ENTITY.getR42_HEADQUATERS()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR42_ABU_DHABI().compareTo(up.getR42_ABU_DHABI()) != 0) {
			fieldNames.add("Abu Dhabi - Abu Dhabi City");
			oldChange.append("R42_COL_3: ").append(up.getR42_ABU_DHABI()).append("; ");
			newChange.append("R42_COL_3: ").append(brf300_ENTITY.getR42_ABU_DHABI()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR42_WESTERNM_REGION().compareTo(up.getR42_WESTERNM_REGION()) != 0) {
			fieldNames.add("Abu Dhabi - Western Region");
			oldChange.append("R42_COL_4: ").append(up.getR42_WESTERNM_REGION()).append("; ");
			newChange.append("R42_COL_4: ").append(brf300_ENTITY.getR42_WESTERNM_REGION()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR42_AL_AIN().compareTo(up.getR42_AL_AIN()) != 0) {
			fieldNames.add("Abu Dhabi - Al Ain");
			oldChange.append("R42_COL_5: ").append(up.getR42_AL_AIN()).append("; ");
			newChange.append("R42_COL_5: ").append(brf300_ENTITY.getR42_AL_AIN()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR42_ISLAND().compareTo(up.getR42_ISLAND()) != 0) {
			fieldNames.add("Abu Dhabi - Islands");
			oldChange.append("R42_COL_6: ").append(up.getR42_ISLAND()).append("; ");
			newChange.append("R42_COL_6: ").append(brf300_ENTITY.getR42_ISLAND()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR42_DUBAI().compareTo(up.getR42_DUBAI()) != 0) {
			fieldNames.add("Dubai");
			oldChange.append("R42_COL_7: ").append(up.getR42_DUBAI()).append("; ");
			newChange.append("R42_COL_7: ").append(brf300_ENTITY.getR42_DUBAI()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR42_SHARJAH().compareTo(up.getR42_SHARJAH()) != 0) {
			fieldNames.add("Sharjah");
			oldChange.append("R42_COL_8: ").append(up.getR42_SHARJAH()).append("; ");
			newChange.append("R42_COL_8: ").append(brf300_ENTITY.getR42_SHARJAH()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR42_AJMAN().compareTo(up.getR42_AJMAN()) != 0) {
			fieldNames.add("Ajman");
			oldChange.append("R42_COL_9: ").append(up.getR42_AJMAN()).append("; ");
			newChange.append("R42_COL_9: ").append(brf300_ENTITY.getR42_AJMAN()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR42_RAS_AL().compareTo(up.getR42_RAS_AL()) != 0) {
			fieldNames.add("Ras al-Khaimah");
			oldChange.append("R42_COL_10: ").append(up.getR42_RAS_AL()).append("; ");
			newChange.append("R42_COL_10: ").append(brf300_ENTITY.getR42_RAS_AL()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR42_UMM_AL().compareTo(up.getR42_UMM_AL()) != 0) {
			fieldNames.add("Umm al-Quwain");
			oldChange.append("R42_COL_11: ").append(up.getR42_UMM_AL()).append("; ");
			newChange.append("R42_COL_11: ").append(brf300_ENTITY.getR42_UMM_AL()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR42_FUJAIRAH().compareTo(up.getR42_FUJAIRAH()) != 0) {
			fieldNames.add("Fujairah");
			oldChange.append("R42_COL_12: ").append(up.getR42_FUJAIRAH()).append("; ");
			newChange.append("R42_COL_12: ").append(brf300_ENTITY.getR42_FUJAIRAH()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR42_ABU_SUB().compareTo(up.getR42_ABU_SUB()) != 0) {
			fieldNames.add("Abu Dhabi Sub-total (D+E+F+G)");
			oldChange.append("R42_COL_13: ").append(up.getR42_ABU_SUB()).append("; ");
			newChange.append("R42_COL_13: ").append(brf300_ENTITY.getR42_ABU_SUB()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR42_TOTAL().compareTo(up.getR42_TOTAL()) != 0) {
			fieldNames.add("Total");
			oldChange.append("R42_COL_14: ").append(up.getR42_TOTAL()).append("; ");
			newChange.append("R42_COL_14: ").append(brf300_ENTITY.getR42_TOTAL()).append("; ");
			rowEdited = true;
		}
		
		
		if (brf300_ENTITY.getR43_S_NO().compareTo(up.getR43_S_NO()) != 0) {
			fieldNames.add("S.No");
			oldChange.append("R43_COL_1: ").append(up.getR43_S_NO()).append("; ");
			newChange.append("R43_COL_1: ").append(brf300_ENTITY.getR43_S_NO()).append("; ");
			rowEdited = true;
		}

		if (brf300_ENTITY.getR43_HEADQUATERS().compareTo(up.getR43_HEADQUATERS()) != 0) {
			fieldNames.add("Additional details - Blocked - Reserved Cells (Future Use)");
			oldChange.append("R43_COL_2: ").append(up.getR43_HEADQUATERS()).append("; ");
			newChange.append("R43_COL_2: ").append(brf300_ENTITY.getR43_HEADQUATERS()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR43_ABU_DHABI().compareTo(up.getR43_ABU_DHABI()) != 0) {
			fieldNames.add("Abu Dhabi - Abu Dhabi City");
			oldChange.append("R43_COL_3: ").append(up.getR43_ABU_DHABI()).append("; ");
			newChange.append("R43_COL_3: ").append(brf300_ENTITY.getR43_ABU_DHABI()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR43_WESTERNM_REGION().compareTo(up.getR43_WESTERNM_REGION()) != 0) {
			fieldNames.add("Abu Dhabi - Western Region");
			oldChange.append("R43_COL_4: ").append(up.getR43_WESTERNM_REGION()).append("; ");
			newChange.append("R43_COL_4: ").append(brf300_ENTITY.getR43_WESTERNM_REGION()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR43_AL_AIN().compareTo(up.getR43_AL_AIN()) != 0) {
			fieldNames.add("Abu Dhabi - Al Ain");
			oldChange.append("R43_COL_5: ").append(up.getR43_AL_AIN()).append("; ");
			newChange.append("R43_COL_5: ").append(brf300_ENTITY.getR43_AL_AIN()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR43_ISLAND().compareTo(up.getR43_ISLAND()) != 0) {
			fieldNames.add("Abu Dhabi - Islands");
			oldChange.append("R43_COL_6: ").append(up.getR43_ISLAND()).append("; ");
			newChange.append("R43_COL_6: ").append(brf300_ENTITY.getR43_ISLAND()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR43_DUBAI().compareTo(up.getR43_DUBAI()) != 0) {
			fieldNames.add("Dubai");
			oldChange.append("R43_COL_7: ").append(up.getR43_DUBAI()).append("; ");
			newChange.append("R43_COL_7: ").append(brf300_ENTITY.getR43_DUBAI()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR43_SHARJAH().compareTo(up.getR43_SHARJAH()) != 0) {
			fieldNames.add("Sharjah");
			oldChange.append("R43_COL_8: ").append(up.getR43_SHARJAH()).append("; ");
			newChange.append("R43_COL_8: ").append(brf300_ENTITY.getR43_SHARJAH()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR43_AJMAN().compareTo(up.getR43_AJMAN()) != 0) {
			fieldNames.add("Ajman");
			oldChange.append("R43_COL_9: ").append(up.getR43_AJMAN()).append("; ");
			newChange.append("R43_COL_9: ").append(brf300_ENTITY.getR43_AJMAN()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR43_RAS_AL().compareTo(up.getR43_RAS_AL()) != 0) {
			fieldNames.add("Ras al-Khaimah");
			oldChange.append("R43_COL_10: ").append(up.getR43_RAS_AL()).append("; ");
			newChange.append("R43_COL_10: ").append(brf300_ENTITY.getR43_RAS_AL()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR43_UMM_AL().compareTo(up.getR43_UMM_AL()) != 0) {
			fieldNames.add("Umm al-Quwain");
			oldChange.append("R43_COL_11: ").append(up.getR43_UMM_AL()).append("; ");
			newChange.append("R43_COL_11: ").append(brf300_ENTITY.getR43_UMM_AL()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR43_FUJAIRAH().compareTo(up.getR43_FUJAIRAH()) != 0) {
			fieldNames.add("Fujairah");
			oldChange.append("R43_COL_12: ").append(up.getR43_FUJAIRAH()).append("; ");
			newChange.append("R43_COL_12: ").append(brf300_ENTITY.getR43_FUJAIRAH()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR43_ABU_SUB().compareTo(up.getR43_ABU_SUB()) != 0) {
			fieldNames.add("Abu Dhabi Sub-total (D+E+F+G)");
			oldChange.append("R43_COL_13: ").append(up.getR43_ABU_SUB()).append("; ");
			newChange.append("R43_COL_13: ").append(brf300_ENTITY.getR43_ABU_SUB()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR43_TOTAL().compareTo(up.getR43_TOTAL()) != 0) {
			fieldNames.add("Total");
			oldChange.append("R43_COL_14: ").append(up.getR43_TOTAL()).append("; ");
			newChange.append("R43_COL_14: ").append(brf300_ENTITY.getR43_TOTAL()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR44_S_NO().compareTo(up.getR44_S_NO()) != 0) {
			fieldNames.add("S.No");
			oldChange.append("R44_COL_1: ").append(up.getR44_S_NO()).append("; ");
			newChange.append("R44_COL_1: ").append(brf300_ENTITY.getR44_S_NO()).append("; ");
			rowEdited = true;
		}

		if (brf300_ENTITY.getR44_HEADQUATERS().compareTo(up.getR44_HEADQUATERS()) != 0) {
			fieldNames.add("Additional details - Blocked - Reserved Cells (Future Use)");
			oldChange.append("R44_COL_2: ").append(up.getR44_HEADQUATERS()).append("; ");
			newChange.append("R44_COL_2: ").append(brf300_ENTITY.getR44_HEADQUATERS()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR44_ABU_DHABI().compareTo(up.getR44_ABU_DHABI()) != 0) {
			fieldNames.add("Abu Dhabi - Abu Dhabi City");
			oldChange.append("R44_COL_3: ").append(up.getR44_ABU_DHABI()).append("; ");
			newChange.append("R44_COL_3: ").append(brf300_ENTITY.getR44_ABU_DHABI()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR44_WESTERNM_REGION().compareTo(up.getR44_WESTERNM_REGION()) != 0) {
			fieldNames.add("Abu Dhabi - Western Region");
			oldChange.append("R44_COL_4: ").append(up.getR44_WESTERNM_REGION()).append("; ");
			newChange.append("R44_COL_4: ").append(brf300_ENTITY.getR44_WESTERNM_REGION()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR44_AL_AIN().compareTo(up.getR44_AL_AIN()) != 0) {
			fieldNames.add("Abu Dhabi - Al Ain");
			oldChange.append("R44_COL_5: ").append(up.getR44_AL_AIN()).append("; ");
			newChange.append("R44_COL_5: ").append(brf300_ENTITY.getR44_AL_AIN()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR44_ISLAND().compareTo(up.getR44_ISLAND()) != 0) {
			fieldNames.add("Abu Dhabi - Islands");
			oldChange.append("R44_COL_6: ").append(up.getR44_ISLAND()).append("; ");
			newChange.append("R44_COL_6: ").append(brf300_ENTITY.getR44_ISLAND()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR44_DUBAI().compareTo(up.getR44_DUBAI()) != 0) {
			fieldNames.add("Dubai");
			oldChange.append("R44_COL_7: ").append(up.getR44_DUBAI()).append("; ");
			newChange.append("R44_COL_7: ").append(brf300_ENTITY.getR44_DUBAI()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR44_SHARJAH().compareTo(up.getR44_SHARJAH()) != 0) {
			fieldNames.add("Sharjah");
			oldChange.append("R44_COL_8: ").append(up.getR44_SHARJAH()).append("; ");
			newChange.append("R44_COL_8: ").append(brf300_ENTITY.getR44_SHARJAH()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR44_AJMAN().compareTo(up.getR44_AJMAN()) != 0) {
			fieldNames.add("Ajman");
			oldChange.append("R44_COL_9: ").append(up.getR44_AJMAN()).append("; ");
			newChange.append("R44_COL_9: ").append(brf300_ENTITY.getR44_AJMAN()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR44_RAS_AL().compareTo(up.getR44_RAS_AL()) != 0) {
			fieldNames.add("Ras al-Khaimah");
			oldChange.append("R44_COL_10: ").append(up.getR44_RAS_AL()).append("; ");
			newChange.append("R44_COL_10: ").append(brf300_ENTITY.getR44_RAS_AL()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR44_UMM_AL().compareTo(up.getR44_UMM_AL()) != 0) {
			fieldNames.add("Umm al-Quwain");
			oldChange.append("R44_COL_11: ").append(up.getR44_UMM_AL()).append("; ");
			newChange.append("R44_COL_11: ").append(brf300_ENTITY.getR44_UMM_AL()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR44_FUJAIRAH().compareTo(up.getR44_FUJAIRAH()) != 0) {
			fieldNames.add("Fujairah");
			oldChange.append("R44_COL_12: ").append(up.getR44_FUJAIRAH()).append("; ");
			newChange.append("R44_COL_12: ").append(brf300_ENTITY.getR44_FUJAIRAH()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR44_ABU_SUB().compareTo(up.getR44_ABU_SUB()) != 0) {
			fieldNames.add("Abu Dhabi Sub-total (D+E+F+G)");
			oldChange.append("R44_COL_13: ").append(up.getR44_ABU_SUB()).append("; ");
			newChange.append("R44_COL_13: ").append(brf300_ENTITY.getR44_ABU_SUB()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR44_TOTAL().compareTo(up.getR44_TOTAL()) != 0) {
			fieldNames.add("Total");
			oldChange.append("R44_COL_14: ").append(up.getR44_TOTAL()).append("; ");
			newChange.append("R44_COL_14: ").append(brf300_ENTITY.getR44_TOTAL()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR45_S_NO().compareTo(up.getR45_S_NO()) != 0) {
			fieldNames.add("S.No");
			oldChange.append("R45_COL_1: ").append(up.getR45_S_NO()).append("; ");
			newChange.append("R45_COL_1: ").append(brf300_ENTITY.getR45_S_NO()).append("; ");
			rowEdited = true;
		}

		if (brf300_ENTITY.getR45_HEADQUATERS().compareTo(up.getR45_HEADQUATERS()) != 0) {
			fieldNames.add("Additional details - Blocked - Reserved Cells (Future Use)");
			oldChange.append("R45_COL_2: ").append(up.getR45_HEADQUATERS()).append("; ");
			newChange.append("R45_COL_2: ").append(brf300_ENTITY.getR45_HEADQUATERS()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR45_ABU_DHABI().compareTo(up.getR45_ABU_DHABI()) != 0) {
			fieldNames.add("Abu Dhabi - Abu Dhabi City");
			oldChange.append("R45_COL_3: ").append(up.getR45_ABU_DHABI()).append("; ");
			newChange.append("R45_COL_3: ").append(brf300_ENTITY.getR45_ABU_DHABI()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR45_WESTERNM_REGION().compareTo(up.getR45_WESTERNM_REGION()) != 0) {
			fieldNames.add("Abu Dhabi - Western Region");
			oldChange.append("R45_COL_4: ").append(up.getR45_WESTERNM_REGION()).append("; ");
			newChange.append("R45_COL_4: ").append(brf300_ENTITY.getR45_WESTERNM_REGION()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR45_AL_AIN().compareTo(up.getR45_AL_AIN()) != 0) {
			fieldNames.add("Abu Dhabi - Al Ain");
			oldChange.append("R45_COL_5: ").append(up.getR45_AL_AIN()).append("; ");
			newChange.append("R45_COL_5: ").append(brf300_ENTITY.getR45_AL_AIN()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR45_ISLAND().compareTo(up.getR45_ISLAND()) != 0) {
			fieldNames.add("Abu Dhabi - Islands");
			oldChange.append("R45_COL_6: ").append(up.getR45_ISLAND()).append("; ");
			newChange.append("R45_COL_6: ").append(brf300_ENTITY.getR45_ISLAND()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR45_DUBAI().compareTo(up.getR45_DUBAI()) != 0) {
			fieldNames.add("Dubai");
			oldChange.append("R45_COL_7: ").append(up.getR45_DUBAI()).append("; ");
			newChange.append("R45_COL_7: ").append(brf300_ENTITY.getR45_DUBAI()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR45_SHARJAH().compareTo(up.getR45_SHARJAH()) != 0) {
			fieldNames.add("Sharjah");
			oldChange.append("R45_COL_8: ").append(up.getR45_SHARJAH()).append("; ");
			newChange.append("R45_COL_8: ").append(brf300_ENTITY.getR45_SHARJAH()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR45_AJMAN().compareTo(up.getR45_AJMAN()) != 0) {
			fieldNames.add("Ajman");
			oldChange.append("R45_COL_9: ").append(up.getR45_AJMAN()).append("; ");
			newChange.append("R45_COL_9: ").append(brf300_ENTITY.getR45_AJMAN()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR45_RAS_AL().compareTo(up.getR45_RAS_AL()) != 0) {
			fieldNames.add("Ras al-Khaimah");
			oldChange.append("R45_COL_10: ").append(up.getR45_RAS_AL()).append("; ");
			newChange.append("R45_COL_10: ").append(brf300_ENTITY.getR45_RAS_AL()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR45_UMM_AL().compareTo(up.getR45_UMM_AL()) != 0) {
			fieldNames.add("Umm al-Quwain");
			oldChange.append("R45_COL_11: ").append(up.getR45_UMM_AL()).append("; ");
			newChange.append("R45_COL_11: ").append(brf300_ENTITY.getR45_UMM_AL()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR45_FUJAIRAH().compareTo(up.getR45_FUJAIRAH()) != 0) {
			fieldNames.add("Fujairah");
			oldChange.append("R45_COL_12: ").append(up.getR45_FUJAIRAH()).append("; ");
			newChange.append("R45_COL_12: ").append(brf300_ENTITY.getR45_FUJAIRAH()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR45_ABU_SUB().compareTo(up.getR45_ABU_SUB()) != 0) {
			fieldNames.add("Abu Dhabi Sub-total (D+E+F+G)");
			oldChange.append("R45_COL_13: ").append(up.getR45_ABU_SUB()).append("; ");
			newChange.append("R45_COL_13: ").append(brf300_ENTITY.getR45_ABU_SUB()).append("; ");
			rowEdited = true;
		}
		
		if (brf300_ENTITY.getR45_TOTAL().compareTo(up.getR45_TOTAL()) != 0) {
			fieldNames.add("Total");
			oldChange.append("R45_COL_14: ").append(up.getR45_TOTAL()).append("; ");
			newChange.append("R45_COL_14: ").append(brf300_ENTITY.getR45_TOTAL()).append("; ");
			rowEdited = true;
		}
		
		// If any changes were detected, save the changes with a row identifier
		if (rowEdited) {
			oldValuesList.add(oldChange.toString().trim());
			newValuesList.add(newChange.toString().trim());

			// Here, save the updated report for each row in the database
			// Example: yourRepository.save(userReport);
		}

		if (Objects.nonNull(up)) {
			up = brf300_ENTITY;
			up.setDel_flg("N");
			up.setEntity_flg("Y");
			up.setModify_flg("Y");
			up.setModify_user(userId);
			up.setReport_date(asondate);
			up.setReport_to_date(asondate);
			brf300aServiceRepo.save(up);
			msg = "Updated Successfully";
			
			String auditID = sequence.generateRequestUUId();
			String user1 = (String) req.getSession().getAttribute("USERID");
			String username = (String) req.getSession().getAttribute("USERNAME");

			MANUAL_Service_Entity audit = new MANUAL_Service_Entity();
			audit.setAudit_date(new Date());
			audit.setEntry_time(new Date());
			audit.setEntry_user(user1);
			audit.setFunc_code("MODIFY");
			audit.setAudit_table("BRF300_SUMMARYTABLE");
			audit.setAudit_screen("MODIFY");
			audit.setEvent_id(user1);
			audit.setEvent_name(username);
			audit.setOld_value(String.join("; ", oldValuesList));
			audit.setNew_value(String.join("; ", newValuesList));
			System.out.println("New Values: " + String.join("; ", newValuesList));
			audit.setField_name(String.join("; ", fieldNames));
			audit.setRemarks("Modify Successfully");

			UserProfile values1 = userProfileRep.getRole(user1);
			audit.setAuth_user(values1.getAuth_user());
			audit.setAuth_time(values1.getAuth_time());
			audit.setAudit_ref_no(auditID);

			mANUAL_Service_Rep.save(audit);
		} else {
			msg = "Data Not Found";
		}
		return msg;
	}

	public String verifyBRF300Report(Date asondate, String userId, HttpServletRequest req) {
		String msg = "";
		BRF300_ENTITY up = brf300aServiceRepo.getBRF300AReport(asondate);
		if (Objects.nonNull(up)) {
			up.setModify_flg("N");
			up.setVerify_time(new Date());
			up.setVerify_user(userId);
			up.setVerify_user(userId);
			up.setVerify_time(asondate);
			brf300aServiceRepo.save(up);
			msg = "Verified Successfully";

			String auditID = sequence.generateRequestUUId();
			String user1 = (String) req.getSession().getAttribute("USERID");
			String username = (String) req.getSession().getAttribute("USERNAME");

			MANUAL_Service_Entity audit = new MANUAL_Service_Entity();
			audit.setAudit_date(new Date());
			audit.setEntry_time(new Date());
			audit.setEntry_user(user1);
			audit.setFunc_code("VERIFY");
			audit.setAudit_table("BRF300_SUMMARYTABLE");
			audit.setAudit_screen("VERIFY");
			audit.setEvent_id(user1);
			audit.setEvent_name(username);
			audit.setRemarks("Verify Successfully");

			UserProfile values1 = userProfileRep.getRole(user1);
			audit.setAuth_user(values1.getAuth_user());
			audit.setAuth_time(values1.getAuth_time());
			audit.setAudit_ref_no(auditID);
			mANUAL_Service_Rep.save(audit);
		} else {
			msg = "Data Not Found";
		}
		return msg;
	}
}
