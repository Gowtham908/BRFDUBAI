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

import com.bornfire.xbrl.entities.BRBS.BRF51_ENTITY1;
import com.bornfire.xbrl.entities.BRBS.BRF51_ENTITY2;
import com.bornfire.xbrl.entities.BRBS.BRF73A_ENTITY;
import com.bornfire.xbrl.entities.BRBS.BRF73B_ENTITY;
import com.bornfire.xbrl.entities.BRBS.BRF73_ARCHIVENTITY;
import com.bornfire.xbrl.entities.BRBS.BRF73_DETAIL_ENTITY;
import com.bornfire.xbrl.entities.BRBS.BRF73_DetailRepo;
import com.bornfire.xbrl.entities.BRBS.BRF78_DETAIL_ENTITY;
import com.bornfire.xbrl.entities.BRBS.BRF7_ENTITY;
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
public class BRF73ReportService {
	private static final Logger logger = LoggerFactory.getLogger(BRF73ReportService.class);

	@Autowired
	SessionFactory sessionFactory;

	@Autowired
	DataSource srcdataSource;
	
	@Autowired
	Environment env;
	
	@Autowired 
	BRF73_DetailRepo brf73_detailrepo;
	
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
				Long dtlcnt = (Long) hs.createQuery("select count(*) from BRF73A_ENTITY a where a.report_date=?1")
						.setParameter(1, dt9).getSingleResult();

				if (dtlcnt > 0) {
					logger.info("Getting No of records in Mod table :" + reportid);
					Long modcnt = (Long) hs.createQuery("select count(*) from BRF73A_ENTITY a").getSingleResult();
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


	public ModelAndView getBRF73View(String reportId, String fromdate, String todate, String currency, String dtltype,
			Pageable pageable) {
		
			ModelAndView mv = new ModelAndView();
			Session hs = sessionFactory.getCurrentSession();
			int pageSize = pageable.getPageSize();
			int currentPage = pageable.getPageNumber();
			int startItem = currentPage * pageSize;
	
			List<BRF73A_ENTITY> T1Master = new ArrayList<BRF73A_ENTITY>();
			List<BRF73B_ENTITY> T1Master1 = new ArrayList<BRF73B_ENTITY>();

			logger.info("Inside archive" +currency);

			try {
				Date d1 = df.parse(todate);
			

				T1Master = hs.createQuery("from BRF73A_ENTITY a where a.report_date = ?1 ", BRF73A_ENTITY.class)
						.setParameter(1, df.parse(todate)).getResultList();

				T1Master1 = hs.createQuery("from BRF73B_ENTITY a where a.report_date = ?1 ", BRF73B_ENTITY.class)
						.setParameter(1, df.parse(todate)).getResultList();

			} catch (ParseException e) {
				e.printStackTrace();
			}

			mv.setViewName("RR/BRF73");
			mv.addObject("reportsummary", T1Master);
			mv.addObject("reportsummary1", T1Master1);
			mv.addObject("reportmaster", T1Master);
			mv.addObject("displaymode", "summary");
			mv.addObject("reportsflag", "reportsflag");
			mv.addObject("menu", reportId);
			System.out.println("scv" + mv.getViewName());

			return mv;

		}
	public ModelAndView getBRF73Details(String reportId, String fromdate, String todate, String currency,
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
						"select * from BRF73_DETAILTABLE  a where report_date = ?1 and report_label_1 =?2");
 
				qr.setParameter(2, filter);
 
			} else {
				qr = hs.createNativeQuery("select * from BRF73_DETAILTABLE a where report_date = ?1");
 
			}
		} else {
			qr = hs.createNativeQuery("select * from BRF73_DETAILTABLE  where report_date = ?1");
		}
 
		try {
			qr.setParameter(1, df.parse(todate));
 
		} catch (ParseException e) {
			e.printStackTrace();
		}
		List<BRF73_DETAIL_ENTITY> T1Master = new ArrayList<BRF73_DETAIL_ENTITY>();
 
		try {
			T1Master = hs.createQuery("from BRF73_DETAIL_ENTITY a where a.report_date = ?1", BRF73_DETAIL_ENTITY.class)
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

			BRF73_DETAIL_ENTITY py = new BRF73_DETAIL_ENTITY(cust_id, foracid, act_balance_amt_lc, eab_lc, acct_name, acct_crncy_code, gl_code, gl_sub_head_code,
				    gl_sub_head_desc, country_of_incorp, cust_type, schm_code, schm_type, sol_id, acid, segment, sub_segment,
				    sector, sub_sector, sector_code, group_id, constitution_code, country, legal_entity_type, constitution_desc,
				    purpose_of_advn, hni_networth, turnover, bacid, report_name_1, report_label_1, report_addl_criteria_1,
				    report_addl_criteria_2, report_addl_criteria_3, create_user, create_time, modify_user, modify_time,
				    verify_user, verify_time, entity_flg, modify_flg, del_flg, nre_status, report_date, maturity_date,
				    gender, version, remarks);
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


		mv.setViewName("RR"+"/"+"BRF73::reportcontent");
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
		String fileName = "";
		String zipFileName = "";
		File outputFile;

		logger.info("Getting Output file :" + reportId);
		fileName = "011-BRF-073-A";

		if (!filetype.equals("xbrl")) {
			if(!filetype.equals("BRF")) {
			try {
				InputStream jasperFile;
				logger.info("Getting Jasper file :" + reportId);
				if (filetype.equals("detailexcel")) {
					if (dtltype.equals("report")) {

						jasperFile = this.getClass().getResourceAsStream("/static/jasper/BRF73_DETAIL.jrxml");
					} else {
						jasperFile = this.getClass().getResourceAsStream("/static/jasper/BRF73_DETAIL.jrxml");
					}

				} else {
					if (dtltype.equals("report")) {
						logger.info("Inside report");
						jasperFile = this.getClass().getResourceAsStream("/static/jasper/BRF73A.jrxml");
					} else {
						jasperFile = this.getClass().getResourceAsStream("/static/jasper/BRF73A.jrxml");
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
		}
		else {
				List<BRF73A_ENTITY> T1Master = new ArrayList<>();
				List<BRF73B_ENTITY> T1Master1 = new ArrayList<>();

				Session hs = sessionFactory.getCurrentSession();
				try {
					Date d1 = df.parse(todate);

					T1Master = hs.createQuery("from BRF73A_ENTITY a where a.report_date = ?1", BRF73A_ENTITY.class)
							.setParameter(1, df.parse(todate)).getResultList();
					T1Master1 = hs.createQuery("from BRF73B_ENTITY a where a.report_date = ?1", BRF73B_ENTITY.class)
							.setParameter(1, df.parse(todate)).getResultList();

					File responseCamt = new File(env.getProperty("output.exportpathtemp") + "011-BRF-073-AT.xls");
					Workbook workbook = WorkbookFactory.create(responseCamt);
					
					Sheet sheet = workbook.getSheetAt(0);
					
					if (T1Master.size() == 1) {
						for (BRF73A_ENTITY BRF73 : T1Master) {
							
					            Row r2row = sheet.getRow(9);
					            Cell r2cell = r2row.getCell(3);
					            if (r2cell != null) {
					            	r2cell.setCellValue(
					            			BRF73.getR2_no_ac_resident() == null ? 0 : BRF73.getR2_no_ac_resident().intValue());
					            }
								 Cell r2cell1 = r2row.getCell(4);
					            if (r2cell1 != null) {
					            	r2cell1.setCellValue(
					            			BRF73.getR2_os_resident() == null ? 0 : BRF73.getR2_os_resident().intValue());
					            }
								 Cell r2cell2 = r2row.getCell(5);
					            if (r2cell2 != null) {
					            	r2cell2.setCellValue(
					            			BRF73.getR2_no_ac_non_resident() == null ? 0 : BRF73.getR2_no_ac_non_resident().intValue());
					            }
								 Cell r2cell3 = r2row.getCell(6);
					            if (r2cell3 != null) {
					            	r2cell3.setCellValue(
					            			BRF73.getR2_os_non_resident() == null ? 0 : BRF73.getR2_os_non_resident().intValue());
					            }
					            Row r3row = sheet.getRow(10);
					            Cell r3cell = r3row.getCell(3);
					            if (r3cell != null) {
					            	r3cell.setCellValue(
					            			BRF73.getR3_no_ac_resident() == null ? 0 : BRF73.getR3_no_ac_resident().intValue());
					            }
								 Cell r3cell1 = r3row.getCell(4);
					            if (r3cell1 != null) {
					            	r3cell1.setCellValue(
					            			BRF73.getR3_os_resident() == null ? 0 : BRF73.getR3_os_resident().intValue());
					            }
								 Cell r3cell3 = r3row.getCell(5);
					            if (r3cell3 != null) {
					            	r3cell3.setCellValue(
					            			BRF73.getR3_no_ac_non_resident() == null ? 0 : BRF73.getR3_no_ac_non_resident().intValue());
					            }
								 Cell r3cell4 = r3row.getCell(6);
					            if (r3cell4 != null) {
					            	r3cell4.setCellValue(
					            			BRF73.getR3_os_non_resident() == null ? 0 : BRF73.getR3_os_non_resident().intValue());
					            }
					            Row r4row = sheet.getRow(11);
					            Cell r4cell = r4row.getCell(3);
					            if (r4cell != null) {
					            	r4cell.setCellValue(
					            			BRF73.getR4_no_ac_resident() == null ? 0 : BRF73.getR4_no_ac_resident().intValue());
					            }
								 Cell r4cell1 = r4row.getCell(4);
					            if (r4cell1 != null) {
					            	r4cell1.setCellValue(
					            			BRF73.getR4_os_resident() == null ? 0 : BRF73.getR4_os_resident().intValue());
					            }
								 Cell r4cell2 = r4row.getCell(5);
					            if (r4cell2 != null) {
					            	r4cell2.setCellValue(
					            			BRF73.getR4_no_ac_non_resident() == null ? 0 : BRF73.getR4_no_ac_non_resident().intValue());
					            }
								 Cell r4cell3 = r4row.getCell(6);
					            if (r4cell3 != null) {
					            	r4cell3.setCellValue(
					            			BRF73.getR4_os_non_resident() == null ? 0 : BRF73.getR4_os_non_resident().intValue());
					            }
					            Row row5 = sheet.getRow(12);
					            Cell r5cell = row5.getCell(3);
					            if (r5cell != null) {
					            	r5cell.setCellValue(
					            			BRF73.getR5_no_ac_resident() == null ? 0 : BRF73.getR5_no_ac_resident().intValue());
					            }
								 Cell r5cell1 = row5.getCell(4);
					            if (r5cell1 != null) {
					            	r5cell1.setCellValue(
					            			BRF73.getR5_os_resident() == null ? 0 : BRF73.getR5_os_resident().intValue());
					            }
								 Cell r5cell2 = row5.getCell(5);
					            if (r5cell2 != null) {
					            	r5cell2.setCellValue(
					            			BRF73.getR5_no_ac_non_resident() == null ? 0 : BRF73.getR5_no_ac_non_resident().intValue());
					            }
								 Cell r5cell3 = row5.getCell(6);
					            if (r5cell3 != null) {
					            	r5cell3.setCellValue(
					            			BRF73.getR5_os_non_resident() == null ? 0 : BRF73.getR5_os_non_resident().intValue());
					            }
					            Row r7row = sheet.getRow(14);
					            Cell r7cell = r7row.getCell(3);
					            if (r7cell != null) {
					            	r7cell.setCellValue(
					            			BRF73.getR7_no_ac_resident() == null ? 0 : BRF73.getR7_no_ac_resident().intValue());
					            }
								 Cell r7cell1 = r7row.getCell(4);
					            if (r7cell1 != null) {
					            	r7cell1.setCellValue(
					            			BRF73.getR7_os_resident() == null ? 0 : BRF73.getR7_os_resident().intValue());
					            }
								 Cell r7cell2 = r7row.getCell(5);
					            if (r7cell2 != null) {
					            	r7cell2.setCellValue(
					            			BRF73.getR7_no_ac_non_resident() == null ? 0 : BRF73.getR7_no_ac_non_resident().intValue());
					            }
								 Cell r7cell3 = r7row.getCell(6);
					            if (r7cell3 != null) {
					            	r7cell3.setCellValue(
					            			BRF73.getR7_os_non_resident() == null ? 0 : BRF73.getR7_os_non_resident().intValue());
					            }
					            Row r8row = sheet.getRow(15);
					            Cell r8cell = r8row.getCell(3);
					            if (r8cell != null) {
					            	r8cell.setCellValue(
					            			BRF73.getR8_no_ac_resident() == null ? 0 : BRF73.getR8_no_ac_resident().intValue());
					            }
								 Cell r8cell1 = r8row.getCell(4);
					            if (r8cell1 != null) {
					            	r8cell1.setCellValue(
					            			BRF73.getR8_os_resident() == null ? 0 : BRF73.getR8_os_resident().intValue());
					            }
								 Cell r8cell2 = r8row.getCell(5);
					            if (r8cell2 != null) {
					            	r8cell2.setCellValue(
					            			BRF73.getR8_no_ac_non_resident() == null ? 0 : BRF73.getR8_no_ac_non_resident().intValue());
					            }
								 Cell r8cell3 = r8row.getCell(6);
					            if (r8cell3 != null) {
					            	r8cell3.setCellValue(
					            			BRF73.getR8_os_non_resident() == null ? 0 : BRF73.getR8_os_non_resident().intValue());
					            }
							 Row r9row = sheet.getRow(16);
							 Cell r9cell = r9row.getCell(3);
					            if (r9cell != null) {
					            	r9cell.setCellValue(
					            			BRF73.getR9_no_ac_resident() == null ? 0 : BRF73.getR9_no_ac_resident().intValue());
					            }
								 Cell r9cell1 = r9row.getCell(4);
					            if (r9cell1 != null) {
					            	r9cell1.setCellValue(
					            			BRF73.getR9_os_resident() == null ? 0 : BRF73.getR9_os_resident().intValue());
					            }
								 Cell r9cell2 = r9row.getCell(5);
					            if (r9cell2 != null) {
					            	r9cell2.setCellValue(
					            			BRF73.getR9_no_ac_non_resident() == null ? 0 : BRF73.getR9_no_ac_non_resident().intValue());
					            }
								 Cell r9cell3 = r9row.getCell(6);
					            if (r9cell3 != null) {
					            	r9cell3.setCellValue(
					            			BRF73.getR9_os_non_resident() == null ? 0 : BRF73.getR9_os_non_resident().intValue());
					            }
					        
					            Row r11row = sheet.getRow(18);
					            Cell r11cell = r11row.getCell(3);
					            if (r11cell != null) {
					            	r11cell.setCellValue(
					            			BRF73.getR11_no_ac_resident() == null ? 0 : BRF73.getR11_no_ac_resident().intValue());
					            }
								 Cell r11cell1 = r11row.getCell(4);
					            if (r11cell1 != null) {
					            	r11cell1.setCellValue(
					            			BRF73.getR11_os_resident() == null ? 0 : BRF73.getR11_os_resident().intValue());
					            }
								 Cell r11cell2 = r11row.getCell(5);
					            if (r11cell2 != null) {
					            	r11cell2.setCellValue(
					            			BRF73.getR11_no_ac_non_resident() == null ? 0 : BRF73.getR11_no_ac_non_resident().intValue());
					            }
								 Cell r11cell3 = r11row.getCell(6);
					            if (r11cell3 != null) {
					            	r11cell3.setCellValue(
					            			BRF73.getR11_os_non_resident() == null ? 0 : BRF73.getR11_os_non_resident().intValue());
					            }
					            Row r12row = sheet.getRow(19);
					            Cell r12cell = r12row.getCell(3);
					            if (r12cell != null) {
					            	r12cell.setCellValue(
					            			BRF73.getR12_no_ac_resident() == null ? 0 : BRF73.getR12_no_ac_resident().intValue());
					            }
								 Cell r12cell1 = r12row.getCell(4);
					            if (r12cell1 != null) {
					            	r12cell1.setCellValue(
					            			BRF73.getR12_os_resident() == null ? 0 : BRF73.getR12_os_resident().intValue());
					            }
								 Cell r12cell2 = r12row.getCell(5);
					            if (r12cell2 != null) {
					            	r12cell2.setCellValue(
					            			BRF73.getR12_no_ac_non_resident() == null ? 0 : BRF73.getR12_no_ac_non_resident().intValue());
					            }
								 Cell r12cell3 = r12row.getCell(6);
					            if (r12cell3 != null) {
					            	r12cell3.setCellValue(
					            			BRF73.getR12_os_non_resident() == null ? 0 : BRF73.getR12_os_non_resident().intValue());
					            }
					            Row r13row = sheet.getRow(20);
					            Cell r13cell = r13row.getCell(3);
					            if (r13cell != null) {
					            	r13cell.setCellValue(
					            			BRF73.getR13_no_ac_resident() == null ? 0 : BRF73.getR13_no_ac_resident().intValue());
					            }
								 Cell r13cell1 = r13row.getCell(4);
					            if (r13cell1 != null) {
					            	r13cell1.setCellValue(
					            			BRF73.getR13_os_resident() == null ? 0 : BRF73.getR13_os_resident().intValue());
					            }
								 Cell r13cell2 = r13row.getCell(5);
					            if (r13cell2 != null) {
					            	r13cell2.setCellValue(
					            			BRF73.getR13_no_ac_non_resident() == null ? 0 : BRF73.getR13_no_ac_non_resident().intValue());
					            }
								 Cell r13cell3 = r13row.getCell(6);
					            if (r13cell3 != null) {
					            	r13cell3.setCellValue(
					            			BRF73.getR13_os_non_resident() == null ? 0 : BRF73.getR13_os_non_resident().intValue());
					            }
					            Row r14row = sheet.getRow(21);
					            Cell r14cell = r14row.getCell(3);
					            if (r14cell != null) {
					            	r14cell.setCellValue(
					            			BRF73.getR14_no_ac_resident() == null ? 0 : BRF73.getR14_no_ac_resident().intValue());
					            }
								 Cell r14cell1 = r14row.getCell(4);
					            if (r14cell1 != null) {
					            	r14cell1.setCellValue(
					            			BRF73.getR14_os_resident() == null ? 0 : BRF73.getR14_os_resident().intValue());
					            }
								 Cell r14cell2 = r14row.getCell(5);
					            if (r14cell2 != null) {
					            	r14cell2.setCellValue(
					            			BRF73.getR14_no_ac_non_resident() == null ? 0 : BRF73.getR14_no_ac_non_resident().intValue());
					            }
								 Cell r14cell3 = r14row.getCell(6);
					            if (r14cell3 != null) {
					            	r14cell3.setCellValue(
					            			BRF73.getR14_os_non_resident() == null ? 0 : BRF73.getR14_os_non_resident().intValue());
					            }
					            Row r15row = sheet.getRow(22);
					            Cell r15cell = r15row.getCell(3);
					            if (r15cell != null) {
					            	r15cell.setCellValue(
					            			BRF73.getR15_no_ac_resident() == null ? 0 : BRF73.getR15_no_ac_resident().intValue());
					            }
								 Cell r15cell1 = r15row.getCell(4);
					            if (r15cell1 != null) {
					            	r15cell1.setCellValue(
					            			BRF73.getR15_os_resident() == null ? 0 : BRF73.getR15_os_resident().intValue());
					            }
								 Cell r15cell2 = r15row.getCell(5);
					            if (r15cell2 != null) {
					            	r15cell2.setCellValue(
					            			BRF73.getR15_no_ac_non_resident() == null ? 0 : BRF73.getR15_no_ac_non_resident().intValue());
					            }
								 Cell r15cell3 = r15row.getCell(6);
					            if (r15cell3 != null) {
					            	r15cell3.setCellValue(
					            			BRF73.getR15_os_non_resident() == null ? 0 : BRF73.getR15_os_non_resident().intValue());
					            }
					            Row r16row = sheet.getRow(23);
					            Cell r16cell = r16row.getCell(3);
					            if (r16cell != null) {
					            	r16cell.setCellValue(
					            			BRF73.getR16_no_ac_resident() == null ? 0 : BRF73.getR16_no_ac_resident().intValue());
					            }
								 Cell r16cell1 = r16row.getCell(4);
					            if (r16cell1 != null) {
					            	r16cell1.setCellValue(
					            			BRF73.getR16_os_resident() == null ? 0 : BRF73.getR16_os_resident().intValue());
					            }
								 Cell r16cell2 = r16row.getCell(5);
					            if (r16cell2 != null) {
					            	r16cell2.setCellValue(
					            			BRF73.getR16_no_ac_non_resident() == null ? 0 : BRF73.getR16_no_ac_non_resident().intValue());
					            }
								 Cell r16cell3 = r16row.getCell(6);
					            if (r16cell3 != null) {
					            	r16cell3.setCellValue(
					            			BRF73.getR16_os_non_resident() == null ? 0 : BRF73.getR16_os_non_resident().intValue());
					            }
					            Row r17row = sheet.getRow(24);
					            Cell r17cell = r17row.getCell(3);
					            if (r17cell != null) {
					            	r17cell.setCellValue(
					            			BRF73.getR17_no_ac_resident() == null ? 0 : BRF73.getR17_no_ac_resident().intValue());
					            }
								 Cell r17cell1 = r17row.getCell(4);
					            if (r17cell1 != null) {
					            	r17cell1.setCellValue(
					            			BRF73.getR17_os_resident() == null ? 0 : BRF73.getR17_os_resident().intValue());
					            }
								 Cell r17cell2 = r17row.getCell(5);
					            if (r17cell2 != null) {
					            	r17cell2.setCellValue(
					            			BRF73.getR17_no_ac_non_resident() == null ? 0 : BRF73.getR17_no_ac_non_resident().intValue());
					            }
								 Cell r17cell3 = r17row.getCell(6);
					            if (r17cell3 != null) {
					            	r17cell3.setCellValue(
					            			BRF73.getR17_os_non_resident() == null ? 0 : BRF73.getR17_os_non_resident().intValue());
					            }
					            Row r18row = sheet.getRow(25);
					            Cell r18cell = r18row.getCell(3);
					            if (r18cell != null) {
					            	r18cell.setCellValue(
					            			BRF73.getR18_no_ac_resident() == null ? 0 : BRF73.getR18_no_ac_resident().intValue());
					            }
								 Cell r18cell1 = r18row.getCell(4);
					            if (r18cell1 != null) {
					            	r18cell1.setCellValue(
					            			BRF73.getR18_os_resident() == null ? 0 : BRF73.getR18_os_resident().intValue());
					            }
								 Cell r18cell2 = r18row.getCell(5);
					            if (r18cell2 != null) {
					            	r18cell2.setCellValue(
					            			BRF73.getR18_no_ac_non_resident() == null ? 0 : BRF73.getR18_no_ac_non_resident().intValue());
					            }
								 Cell r18cell3 = r18row.getCell(6);
					            if (r18cell3 != null) {
					            	r18cell3.setCellValue(
					            			BRF73.getR18_os_non_resident() == null ? 0 : BRF73.getR18_os_non_resident().intValue());
					            }
					            Row r20row = sheet.getRow(27);
					            Cell r20cell = r20row.getCell(3);
					            if (r20cell != null) {
					            	r20cell.setCellValue(
					            			BRF73.getR20_no_ac_resident() == null ? 0 : BRF73.getR20_no_ac_resident().intValue());
					            }
								 Cell r20cell1 = r20row.getCell(4);
					            if (r20cell1 != null) {
					            	r20cell1.setCellValue(
					            			BRF73.getR20_os_resident() == null ? 0 : BRF73.getR20_os_resident().intValue());
					            }
								 Cell r20cell2 = r20row.getCell(5);
					            if (r20cell2 != null) {
					            	r20cell2.setCellValue(
					            			BRF73.getR20_no_ac_non_resident() == null ? 0 : BRF73.getR20_no_ac_non_resident().intValue());
					            }
								 Cell r20cell3 = r20row.getCell(6);
					            if (r20cell3 != null) {
					            	r20cell3.setCellValue(
					            			BRF73.getR20_os_non_resident() == null ? 0 : BRF73.getR20_os_non_resident().intValue());
					            }
					            Row r21row = sheet.getRow(28);
					            Cell r21cell = r21row.getCell(3);
					            if (r21cell != null) {
					            	r21cell.setCellValue(
					            			BRF73.getR21_no_ac_resident() == null ? 0 : BRF73.getR21_no_ac_resident().intValue());
					            }
								 Cell r21cell1 = r21row.getCell(4);
					            if (r21cell1 != null) {
					            	r21cell1.setCellValue(
					            			BRF73.getR21_os_resident() == null ? 0 : BRF73.getR21_os_resident().intValue());
					            }
								 Cell r21cell2 = r21row.getCell(5);
					            if (r21cell2 != null) {
					            	r21cell2.setCellValue(
					            			BRF73.getR21_no_ac_non_resident() == null ? 0 : BRF73.getR21_no_ac_non_resident().intValue());
					            }
								 Cell r21cell3 = r21row.getCell(6);
					            if (r21cell3 != null) {
					            	r21cell3.setCellValue(
					            			BRF73.getR21_os_non_resident() == null ? 0 : BRF73.getR21_os_non_resident().intValue());
					            }
					            Row r22row = sheet.getRow(29);
					            Cell r22cell = r22row.getCell(3);
					            if (r22cell != null) {
					            	r22cell.setCellValue(
					            			BRF73.getR22_no_ac_resident() == null ? 0 : BRF73.getR22_no_ac_resident().intValue());
					            }
								 Cell r22cell1 = r22row.getCell(4);
					            if (r22cell1 != null) {
					            	r22cell1.setCellValue(
					            			BRF73.getR22_os_resident() == null ? 0 : BRF73.getR22_os_resident().intValue());
					            }
								 Cell r22cell2 = r22row.getCell(5);
					            if (r22cell2 != null) {
					            	r22cell2.setCellValue(
					            			BRF73.getR22_no_ac_non_resident() == null ? 0 : BRF73.getR22_no_ac_non_resident().intValue());
					            }
								 Cell r22cell3 = r22row.getCell(6);
					            if (r22cell3 != null) {
					            	r22cell3.setCellValue(
					            			BRF73.getR22_os_non_resident() == null ? 0 : BRF73.getR22_os_non_resident().intValue());
					            }
					            Row r23row = sheet.getRow(30);
					            Cell r23cell = r23row.getCell(3);
					            if (r23cell != null) {
					            	r23cell.setCellValue(
					            			BRF73.getR23_no_ac_resident() == null ? 0 : BRF73.getR23_no_ac_resident().intValue());
					            }
								 Cell r23cell1 = r23row.getCell(4);
					            if (r23cell1 != null) {
					            	r23cell1.setCellValue(
					            			BRF73.getR23_os_resident() == null ? 0 : BRF73.getR23_os_resident().intValue());
					            }
								 Cell r23cell2 = r23row.getCell(5);
					            if (r23cell2 != null) {
					            	r23cell2.setCellValue(
					            			BRF73.getR23_no_ac_non_resident() == null ? 0 : BRF73.getR23_no_ac_non_resident().intValue());
					            }
								 Cell r23cell3 = r23row.getCell(6);
					            if (r23cell3 != null) {
					            	r23cell3.setCellValue(
					            			BRF73.getR23_os_non_resident() == null ? 0 : BRF73.getR23_os_non_resident().intValue());
					            }
					            Row r24row = sheet.getRow(31);
					            Cell r24cell = r24row.getCell(3);
					            if (r24cell != null) {
					            	r24cell.setCellValue(
					            			BRF73.getR24_no_ac_resident() == null ? 0 : BRF73.getR24_no_ac_resident().intValue());
					            }
								 Cell r24cell1 = r24row.getCell(4);
					            if (r24cell1 != null) {
					            	r24cell1.setCellValue(
					            			BRF73.getR24_os_resident() == null ? 0 : BRF73.getR24_os_resident().intValue());
					            }
								 Cell r24cell2 = r24row.getCell(5);
					            if (r24cell2 != null) {
					            	r24cell2.setCellValue(
					            			BRF73.getR24_no_ac_non_resident() == null ? 0 : BRF73.getR24_no_ac_non_resident().intValue());
					            }
								 Cell r24cell3 = r24row.getCell(6);
					            if (r24cell3 != null) {
					            	r24cell3.setCellValue(
					            			BRF73.getR24_os_non_resident() == null ? 0 : BRF73.getR24_os_non_resident().intValue());
					            }
					            Row r25row = sheet.getRow(32);
					            Cell r25cell = r25row.getCell(3);
					            if (r25cell != null) {
					            	r25cell.setCellValue(
					            			BRF73.getR25_no_ac_resident() == null ? 0 : BRF73.getR25_no_ac_resident().intValue());
					            }
								 Cell r25cell1 = r25row.getCell(4);
					            if (r25cell1 != null) {
					            	r25cell1.setCellValue(
					            			BRF73.getR25_os_resident() == null ? 0 : BRF73.getR25_os_resident().intValue());
					            }
								 Cell r25cell2 = r25row.getCell(5);
					            if (r25cell2 != null) {
					            	r25cell2.setCellValue(
					            			BRF73.getR25_no_ac_non_resident() == null ? 0 : BRF73.getR25_no_ac_non_resident().intValue());
					            }
								 Cell r25cell3 = r25row.getCell(6);
					            if (r25cell3 != null) {
					            	r25cell3.setCellValue(
					            			BRF73.getR25_os_non_resident() == null ? 0 : BRF73.getR25_os_non_resident().intValue());
					            }
					            Row r27row = sheet.getRow(34);
					            Cell r27cell = r27row.getCell(3);
					            if (r27cell != null) {
					            	r27cell.setCellValue(
					            			BRF73.getR27_no_ac_resident() == null ? 0 : BRF73.getR27_no_ac_resident().intValue());
					            }
								 Cell r27cell1 = r27row.getCell(4);
					            if (r27cell1 != null) {
					            	r27cell1.setCellValue(
					            			BRF73.getR27_os_resident() == null ? 0 : BRF73.getR27_os_resident().intValue());
					            }
								 Cell r27cell2 = r27row.getCell(5);
					            if (r27cell2 != null) {
					            	r27cell2.setCellValue(
					            			BRF73.getR27_no_ac_non_resident() == null ? 0 : BRF73.getR27_no_ac_non_resident().intValue());
					            }
								 Cell r27cell3 = r27row.getCell(6);
					            if (r27cell3 != null) {
					            	r27cell3.setCellValue(
					            			BRF73.getR27_os_non_resident() == null ? 0 : BRF73.getR27_os_non_resident().intValue());
					            }
					            Row r28row = sheet.getRow(35);
					            Cell r28cell = r28row.getCell(3);
					            if (r28cell != null) {
					            	r28cell.setCellValue(
					            			BRF73.getR28_no_ac_resident() == null ? 0 : BRF73.getR28_no_ac_resident().intValue());
					            }
								 Cell r28cell1 = r28row.getCell(4);
					            if (r28cell1 != null) {
					            	r28cell1.setCellValue(
					            			BRF73.getR28_os_resident() == null ? 0 : BRF73.getR28_os_resident().intValue());
					            }
								 Cell r28cell2 = r28row.getCell(5);
					            if (r28cell2 != null) {
					            	r28cell2.setCellValue(
					            			BRF73.getR28_no_ac_non_resident() == null ? 0 : BRF73.getR28_no_ac_non_resident().intValue());
					            }
								 Cell r28cell3 = r28row.getCell(6);
					            if (r28cell3 != null) {
					            	r28cell3.setCellValue(
					            			BRF73.getR28_os_non_resident() == null ? 0 : BRF73.getR28_os_non_resident().intValue());
					            }
					            Row r29row = sheet.getRow(36);
					            Cell r29cell = r29row.getCell(3);
					            if (r29cell != null) {
					            	r29cell.setCellValue(
					            			BRF73.getR29_no_ac_resident() == null ? 0 : BRF73.getR29_no_ac_resident().intValue());
					            }
								 Cell r29cell1 = r29row.getCell(4);
					            if (r29cell1 != null) {
					            	r29cell1.setCellValue(
					            			BRF73.getR29_os_resident() == null ? 0 : BRF73.getR29_os_resident().intValue());
					            }
								 Cell r29cell2 = r29row.getCell(5);
					            if (r29cell2 != null) {
					            	r29cell2.setCellValue(
					            			BRF73.getR29_no_ac_non_resident() == null ? 0 : BRF73.getR29_no_ac_non_resident().intValue());
					            }
								 Cell r29cell3 = r29row.getCell(6);
					            if (r29cell3 != null) {
					            	r29cell3.setCellValue(
					            			BRF73.getR29_os_non_resident() == null ? 0 : BRF73.getR29_os_non_resident().intValue());
					            }
					         
					            Row r31row = sheet.getRow(38);
					            Cell r31cell = r31row.getCell(3);
					            if (r31cell != null) {
					            	r31cell.setCellValue(
					            			BRF73.getR31_no_ac_resident() == null ? 0 : BRF73.getR31_no_ac_resident().intValue());
					            }
								 Cell r31cell1 = r31row.getCell(4);
					            if (r31cell1 != null) {
					            	r31cell1.setCellValue(
					            			BRF73.getR31_os_resident() == null ? 0 : BRF73.getR31_os_resident().intValue());
					            }
								 Cell r31cell2 = r31row.getCell(5);
					            if (r31cell2 != null) {
					            	r31cell2.setCellValue(
					            			BRF73.getR31_no_ac_non_resident() == null ? 0 : BRF73.getR31_no_ac_non_resident().intValue());
					            }
								 Cell r31cell3 = r31row.getCell(6);
					            if (r31cell3 != null) {
					            	r31cell3.setCellValue(
					            			BRF73.getR31_os_non_resident() == null ? 0 : BRF73.getR31_os_non_resident().intValue());
					            }
					            Row r32row = sheet.getRow(39);
					            Cell r32cell = r32row.getCell(3);
					            if (r32cell != null) {
					            	r32cell.setCellValue(
					            			BRF73.getR32_no_ac_resident() == null ? 0 : BRF73.getR32_no_ac_resident().intValue());
					            }
								 Cell r32cell1 = r32row.getCell(4);
					            if (r32cell1 != null) {
					            	r32cell1.setCellValue(
					            			BRF73.getR32_os_resident() == null ? 0 : BRF73.getR32_os_resident().intValue());
					            }
								 Cell r32cell2 = r32row.getCell(5);
					            if (r32cell2 != null) {
					            	r32cell2.setCellValue(
					            			BRF73.getR32_no_ac_non_resident() == null ? 0 : BRF73.getR32_no_ac_non_resident().intValue());
					            }
								 Cell r32cell3 = r32row.getCell(6);
					            if (r32cell3 != null) {
					            	r32cell3.setCellValue(
					            			BRF73.getR32_os_non_resident() == null ? 0 : BRF73.getR32_os_non_resident().intValue());
					            }
					            Row r33row = sheet.getRow(40);
					            Cell r33cell = r33row.getCell(3);
					            if (r33cell != null) {
					            	r33cell.setCellValue(
					            			BRF73.getR33_no_ac_resident() == null ? 0 : BRF73.getR33_no_ac_resident().intValue());
					            }
								 Cell r33cell1 = r33row.getCell(4);
					            if (r33cell1 != null) {
					            	r33cell1.setCellValue(
					            			BRF73.getR33_os_resident() == null ? 0 : BRF73.getR33_os_resident().intValue());
					            }
								 Cell r33cell2 = r33row.getCell(5);
					            if (r33cell2 != null) {
					            	r33cell2.setCellValue(
					            			BRF73.getR33_no_ac_non_resident() == null ? 0 : BRF73.getR33_no_ac_non_resident().intValue());
					            }
								 Cell r33cell3 = r33row.getCell(6);
					            if (r33cell3 != null) {
					            	r33cell3.setCellValue(
					            			BRF73.getR33_os_non_resident() == null ? 0 : BRF73.getR33_os_non_resident().intValue());
					            }
					            Row r34row = sheet.getRow(41);
					            Cell r34cell = r34row.getCell(3);
					            if (r34cell != null) {
					            	r34cell.setCellValue(
					            			BRF73.getR34_no_ac_resident() == null ? 0 : BRF73.getR34_no_ac_resident().intValue());
					            }
								 Cell r34cell1 = r34row.getCell(4);
					            if (r34cell1 != null) {
					            	r34cell1.setCellValue(
					            			BRF73.getR34_os_resident() == null ? 0 : BRF73.getR34_os_resident().intValue());
					            }
								 Cell r34cell2 = r34row.getCell(5);
					            if (r34cell2 != null) {
					            	r34cell2.setCellValue(
					            			BRF73.getR34_no_ac_non_resident() == null ? 0 : BRF73.getR34_no_ac_non_resident().intValue());
					            }
								 Cell r34cell3 = r34row.getCell(6);
					            if (r34cell3 != null) {
					            	r34cell3.setCellValue(
					            			BRF73.getR34_os_non_resident() == null ? 0 : BRF73.getR34_os_non_resident().intValue());
					            }
					            Row r35row = sheet.getRow(42);
					            Cell r35cell = r35row.getCell(3);
					            if (r35cell != null) {
					            	r35cell.setCellValue(
					            			BRF73.getR35_no_ac_resident() == null ? 0 : BRF73.getR35_no_ac_resident().intValue());
					            }
								 Cell r35cell1 = r35row.getCell(4);
					            if (r35cell1 != null) {
					            	r35cell1.setCellValue(
					            			BRF73.getR35_os_resident() == null ? 0 : BRF73.getR35_os_resident().intValue());
					            }
								 Cell r35cell2 = r35row.getCell(5);
					            if (r35cell2 != null) {
					            	r35cell2.setCellValue(
					            			BRF73.getR35_no_ac_non_resident() == null ? 0 : BRF73.getR35_no_ac_non_resident().intValue());
					            }
								 Cell r35cell3 = r35row.getCell(6);
					            if (r35cell3 != null) {
					            	r35cell3.setCellValue(
					            			BRF73.getR35_os_non_resident() == null ? 0 : BRF73.getR35_os_non_resident().intValue());
					            }
					            Row r36row = sheet.getRow(43);
					            Cell r36cell = r36row.getCell(3);
					            if (r36cell != null) {
					            	r36cell.setCellValue(
					            			BRF73.getR36_no_ac_resident() == null ? 0 : BRF73.getR36_no_ac_resident().intValue());
					            }
								 Cell r36cell1 = r36row.getCell(4);
					            if (r36cell1 != null) {
					            	r36cell1.setCellValue(
					            			BRF73.getR36_os_resident() == null ? 0 : BRF73.getR36_os_resident().intValue());
					            }
								 Cell r36cell2 = r36row.getCell(5);
					            if (r36cell2 != null) {
					            	r36cell2.setCellValue(
					            			BRF73.getR36_no_ac_non_resident() == null ? 0 : BRF73.getR36_no_ac_non_resident().intValue());
					            }
								 Cell r36cell3 = r36row.getCell(6);
					            if (r36cell3 != null) {
					            	r36cell3.setCellValue(
					            			BRF73.getR36_os_non_resident() == null ? 0 : BRF73.getR36_os_non_resident().intValue());
					            }
					            Row r37row = sheet.getRow(44);
					            Cell r37cell = r37row.getCell(3);
					            if (r37cell != null) {
					            	r37cell.setCellValue(
					            			BRF73.getR37_no_ac_resident() == null ? 0 : BRF73.getR37_no_ac_resident().intValue());
					            }
								 Cell r37cell1 = r37row.getCell(4);
					            if (r37cell1 != null) {
					            	r37cell1.setCellValue(
					            			BRF73.getR37_os_resident() == null ? 0 : BRF73.getR37_os_resident().intValue());
					            }
								 Cell r37cell2 = r37row.getCell(5);
					            if (r37cell2 != null) {
					            	r37cell2.setCellValue(
					            			BRF73.getR37_no_ac_non_resident() == null ? 0 : BRF73.getR37_no_ac_non_resident().intValue());
					            }
								 Cell r37cell3 = r37row.getCell(6);
					            if (r37cell3 != null) {
					            	r37cell3.setCellValue(
					            			BRF73.getR37_os_non_resident() == null ? 0 : BRF73.getR37_os_non_resident().intValue());
					            }
					            Row r38row = sheet.getRow(45);
					            Cell r38cell = r38row.getCell(3);
					            if (r38cell != null) {
					            	r38cell.setCellValue(
					            			BRF73.getR38_no_ac_resident() == null ? 0 : BRF73.getR38_no_ac_resident().intValue());
					            }
								 Cell r38cell1 = r38row.getCell(4);
					            if (r38cell1 != null) {
					            	r38cell1.setCellValue(
					            			BRF73.getR38_os_resident() == null ? 0 : BRF73.getR38_os_resident().intValue());
					            }
								 Cell r38cell2 = r38row.getCell(5);
					            if (r38cell2 != null) {
					            	r38cell2.setCellValue(
					            			BRF73.getR38_no_ac_non_resident() == null ? 0 : BRF73.getR38_no_ac_non_resident().intValue());
					            }
								 Cell r38cell3 = r38row.getCell(6);
					            if (r38cell3 != null) {
					            	r38cell3.setCellValue(
					            			BRF73.getR38_os_non_resident() == null ? 0 : BRF73.getR38_os_non_resident().intValue());
					            }
					            Row r39row = sheet.getRow(46);
					            Cell r39cell = r39row.getCell(3);
					            if (r39cell != null) {
					            	r39cell.setCellValue(
					            			BRF73.getR39_no_ac_resident() == null ? 0 : BRF73.getR39_no_ac_resident().intValue());
					            }
								 Cell r39cell1 = r39row.getCell(4);
					            if (r39cell1 != null) {
					            	r39cell1.setCellValue(
					            			BRF73.getR39_os_resident() == null ? 0 : BRF73.getR39_os_resident().intValue());
					            }
								 Cell r39cell2 = r39row.getCell(5);
					            if (r39cell2 != null) {
					            	r39cell2.setCellValue(
					            			BRF73.getR39_no_ac_non_resident() == null ? 0 : BRF73.getR39_no_ac_non_resident().intValue());
					            }
								 Cell r39cell3 = r39row.getCell(6);
					            if (r39cell3 != null) {
					            	r39cell3.setCellValue(
					            			BRF73.getR39_os_non_resident() == null ? 0 : BRF73.getR39_os_non_resident().intValue());
					            }
					            Row r40row = sheet.getRow(47);
					            Cell r40cell = r40row.getCell(3);
					            if (r40cell != null) {
					            	r40cell.setCellValue(
					            			BRF73.getR40_no_ac_resident() == null ? 0 : BRF73.getR40_no_ac_resident().intValue());
					            }
								 Cell r40cell1 = r40row.getCell(4);
					            if (r40cell1 != null) {
					            	r40cell1.setCellValue(
					            			BRF73.getR40_os_resident() == null ? 0 : BRF73.getR40_os_resident().intValue());
					            }
								 Cell r40cell2 = r40row.getCell(5);
					            if (r40cell2 != null) {
					            	r40cell2.setCellValue(
					            			BRF73.getR40_no_ac_non_resident() == null ? 0 : BRF73.getR40_no_ac_non_resident().intValue());
					            }
								 Cell r40cell3 = r40row.getCell(6);
					            if (r40cell3 != null) {
					            	r40cell3.setCellValue(
					            			BRF73.getR40_os_non_resident() == null ? 0 : BRF73.getR40_os_non_resident().intValue());
					            }
					            Row r41row = sheet.getRow(48);
					            Cell r41cell = r41row.getCell(3);
					            if (r41cell != null) {
					            	r41cell.setCellValue(
					            			BRF73.getR41_no_ac_resident() == null ? 0 : BRF73.getR41_no_ac_resident().intValue());
					            }
								 Cell r41cell1 = r41row.getCell(4);
					            if (r41cell1 != null) {
					            	r41cell1.setCellValue(
					            			BRF73.getR41_os_resident() == null ? 0 : BRF73.getR41_os_resident().intValue());
					            }
								 Cell r41cell2 = r41row.getCell(5);
					            if (r41cell2 != null) {
					            	r41cell2.setCellValue(
					            			BRF73.getR41_no_ac_non_resident() == null ? 0 : BRF73.getR41_no_ac_non_resident().intValue());
					            }
								 Cell r41cell3 = r41row.getCell(6);
					            if (r41cell3 != null) {
					            	r41cell3.setCellValue(
					            			BRF73.getR41_os_non_resident() == null ? 0 : BRF73.getR41_os_non_resident().intValue());
					            }
					            Row r42row = sheet.getRow(49);
					            Cell r42cell = r42row.getCell(3);
					            if (r42cell != null) {
					            	r42cell.setCellValue(
					            			BRF73.getR42_no_ac_resident() == null ? 0 : BRF73.getR42_no_ac_resident().intValue());
					            }
								 Cell r42cell1 = r42row.getCell(4);
					            if (r42cell1 != null) {
					            	r42cell1.setCellValue(
					            			BRF73.getR42_os_resident() == null ? 0 : BRF73.getR42_os_resident().intValue());
					            }
								 Cell r42cell2 = r42row.getCell(5);
					            if (r42cell2 != null) {
					            	r42cell2.setCellValue(
					            			BRF73.getR42_no_ac_non_resident() == null ? 0 : BRF73.getR42_no_ac_non_resident().intValue());
					            }
								 Cell r42cell3 = r42row.getCell(6);
					            if (r42cell3 != null) {
					            	r42cell3.setCellValue(
					            			BRF73.getR42_os_non_resident() == null ? 0 : BRF73.getR42_os_non_resident().intValue());
					            }
					            Row r43row = sheet.getRow(50);
					            Cell r43cell = r43row.getCell(3);
					            if (r43cell != null) {
					            	r43cell.setCellValue(
					            			BRF73.getR43_no_ac_resident() == null ? 0 : BRF73.getR43_no_ac_resident().intValue());
					            }
								 Cell r43cell1 = r43row.getCell(4);
					            if (r43cell1 != null) {
					            	r43cell1.setCellValue(
					            			BRF73.getR43_os_resident() == null ? 0 : BRF73.getR43_os_resident().intValue());
					            }
								 Cell r43cell2 = r43row.getCell(5);
					            if (r43cell2 != null) {
					            	r43cell2.setCellValue(
					            			BRF73.getR43_no_ac_non_resident() == null ? 0 : BRF73.getR43_no_ac_non_resident().intValue());
					            }
								 Cell r43cell3 = r43row.getCell(6);
					            if (r43cell3 != null) {
					            	r43cell3.setCellValue(
					            			BRF73.getR43_os_non_resident() == null ? 0 : BRF73.getR43_os_non_resident().intValue());
					            }
					            Row r45row = sheet.getRow(52);
					            Cell r45cell = r45row.getCell(3);
					            if (r45cell != null) {
					            	r45cell.setCellValue(
					            			BRF73.getR45_no_ac_resident() == null ? 0 : BRF73.getR45_no_ac_resident().intValue());
					            }
								 Cell r45cell1 = r45row.getCell(4);
					            if (r45cell1 != null) {
					            	r45cell1.setCellValue(
					            			BRF73.getR45_os_resident() == null ? 0 : BRF73.getR45_os_resident().intValue());
					            }
								 Cell r45cell2 = r45row.getCell(5);
					            if (r45cell2 != null) {
					            	r45cell2.setCellValue(
					            			BRF73.getR45_no_ac_non_resident() == null ? 0 : BRF73.getR45_no_ac_non_resident().intValue());
					            }
								 Cell r45cell3 = r45row.getCell(6);
					            if (r45cell3 != null) {
					            	r45cell3.setCellValue(
					            			BRF73.getR45_os_non_resident() == null ? 0 : BRF73.getR45_os_non_resident().intValue());
					            }
					            Row r46row = sheet.getRow(53);
					            Cell r46cell = r46row.getCell(3);
					            if (r46cell != null) {
					            	r46cell.setCellValue(
					            			BRF73.getR46_no_ac_resident() == null ? 0 : BRF73.getR46_no_ac_resident().intValue());
					            }
								 Cell r46cell1 = r46row.getCell(4);
					            if (r46cell1 != null) {
					            	r46cell1.setCellValue(
					            			BRF73.getR46_os_resident() == null ? 0 : BRF73.getR46_os_resident().intValue());
					            }
								 Cell r46cell2 = r46row.getCell(5);
					            if (r46cell2 != null) {
					            	r46cell2.setCellValue(
					            			BRF73.getR46_no_ac_non_resident() == null ? 0 : BRF73.getR46_no_ac_non_resident().intValue());
					            }
								 Cell r46cell3 = r46row.getCell(6);
					            if (r46cell3 != null) {
					            	r46cell3.setCellValue(
					            			BRF73.getR46_os_non_resident() == null ? 0 : BRF73.getR46_os_non_resident().intValue());
					            }
					            Row r47row = sheet.getRow(54);
					            Cell r47cell = r47row.getCell(3);
					            if (r47cell != null) {
					            	r47cell.setCellValue(
					            			BRF73.getR47_no_ac_resident() == null ? 0 : BRF73.getR47_no_ac_resident().intValue());
					            }
								 Cell r47cell1 = r47row.getCell(4);
					            if (r47cell1 != null) {
					            	r47cell1.setCellValue(
					            			BRF73.getR47_os_resident() == null ? 0 : BRF73.getR47_os_resident().intValue());
					            }
								 Cell r47cell2 = r47row.getCell(5);
					            if (r47cell2 != null) {
					            	r47cell2.setCellValue(
					            			BRF73.getR47_no_ac_non_resident() == null ? 0 : BRF73.getR47_no_ac_non_resident().intValue());
					            }
								 Cell r47cell3 = r47row.getCell(6);
					            if (r47cell3 != null) {
					            	r47cell3.setCellValue(
					            			BRF73.getR47_os_non_resident() == null ? 0 : BRF73.getR47_os_non_resident().intValue());
					            }
					            Row r48row = sheet.getRow(55);
					            Cell r48cell = r48row.getCell(3);
					            if (r48cell != null) {
					            	r48cell.setCellValue(
					            			BRF73.getR48_no_ac_resident() == null ? 0 : BRF73.getR48_no_ac_resident().intValue());
					            }
								 Cell r48cell1 = r48row.getCell(4);
					            if (r48cell1 != null) {
					            	r48cell1.setCellValue(
					            			BRF73.getR48_os_resident() == null ? 0 : BRF73.getR48_os_resident().intValue());
					            }
								 Cell r48cell2 = r48row.getCell(5);
					            if (r48cell2 != null) {
					            	r48cell2.setCellValue(
					            			BRF73.getR48_no_ac_non_resident() == null ? 0 : BRF73.getR48_no_ac_non_resident().intValue());
					            }
								 Cell r48cell3 = r48row.getCell(6);
					            if (r48cell3 != null) {
					            	r48cell3.setCellValue(
					            			BRF73.getR48_os_non_resident() == null ? 0 : BRF73.getR48_os_non_resident().intValue());
					            }
					            Row r50row = sheet.getRow(57);
					            Cell r50cell = r50row.getCell(3);
					            if (r50cell != null) {
					            	r50cell.setCellValue(
					            			BRF73.getR50_no_ac_resident() == null ? 0 : BRF73.getR50_no_ac_resident().intValue());
					            }
								 Cell r50cell1 = r50row.getCell(4);
					            if (r50cell1 != null) {
					            	r50cell1.setCellValue(
					            			BRF73.getR50_os_resident() == null ? 0 : BRF73.getR50_os_resident().intValue());
					            }
								 Cell r50cell2 = r50row.getCell(5);
					            if (r50cell2 != null) {
					            	r50cell2.setCellValue(
					            			BRF73.getR50_no_ac_non_resident() == null ? 0 : BRF73.getR50_no_ac_non_resident().intValue());
					            }
								 Cell r50cell3 = r50row.getCell(6);
					            if (r50cell3 != null) {
					            	r50cell3.setCellValue(
					            			BRF73.getR50_os_non_resident() == null ? 0 : BRF73.getR50_os_non_resident().intValue());
					            }
					            Row r51row = sheet.getRow(58);
					            Cell r51cell = r51row.getCell(3);
					            if (r51cell != null) {
					            	r51cell.setCellValue(
					            			BRF73.getR51_no_ac_resident() == null ? 0 : BRF73.getR51_no_ac_resident().intValue());
					            }
								 Cell r51cell1 = r51row.getCell(4);
					            if (r51cell1 != null) {
					            	r51cell1.setCellValue(
					            			BRF73.getR51_os_resident() == null ? 0 : BRF73.getR51_os_resident().intValue());
					            }
								 Cell r51cell2 = r51row.getCell(5);
					            if (r51cell2 != null) {
					            	r51cell2.setCellValue(
					            			BRF73.getR51_no_ac_non_resident() == null ? 0 : BRF73.getR51_no_ac_non_resident().intValue());
					            }
								 Cell r51cell3 = r51row.getCell(6);
					            if (r51cell3 != null) {
					            	r51cell3.setCellValue(
					            			BRF73.getR51_os_non_resident() == null ? 0 : BRF73.getR51_os_non_resident().intValue());
					            }
					            Row r52row = sheet.getRow(59);
					            Cell r52cell = r52row.getCell(3);
					            if (r52cell != null) {
					            	r52cell.setCellValue(
					            			BRF73.getR52_no_ac_resident() == null ? 0 : BRF73.getR52_no_ac_resident().intValue());
					            }
								 Cell r52cell1 = r52row.getCell(4);
					            if (r52cell1 != null) {
					            	r52cell1.setCellValue(
					            			BRF73.getR52_os_resident() == null ? 0 : BRF73.getR52_os_resident().intValue());
					            }
								 Cell r52cell2 = r52row.getCell(5);
					            if (r52cell2 != null) {
					            	r52cell2.setCellValue(
					            			BRF73.getR52_no_ac_non_resident() == null ? 0 : BRF73.getR52_no_ac_non_resident().intValue());
					            }
								 Cell r52cell3 = r52row.getCell(6);
					            if (r52cell3 != null) {
					            	r52cell3.setCellValue(
					            			BRF73.getR52_os_non_resident() == null ? 0 : BRF73.getR52_os_non_resident().intValue());
					            }           
					            Row r54row = sheet.getRow(61);
					            Cell r54cell = r54row.getCell(3);
					            if (r54cell != null) {
					            	r54cell.setCellValue(
					            			BRF73.getR54_no_ac_resident() == null ? 0 : BRF73.getR54_no_ac_resident().intValue());
					            }
								 Cell r54cell1 = r54row.getCell(4);
					            if (r54cell1 != null) {
					            	r54cell1.setCellValue(
					            			BRF73.getR54_os_resident() == null ? 0 : BRF73.getR54_os_resident().intValue());
					            }
								 Cell r54cell2 = r54row.getCell(5);
					            if (r54cell2 != null) {
					            	r54cell2.setCellValue(
					            			BRF73.getR54_no_ac_non_resident() == null ? 0 : BRF73.getR54_no_ac_non_resident().intValue());
					            }
								 Cell r54cell3 = r54row.getCell(6);
					            if (r54cell3 != null) {
					            	r54cell3.setCellValue(
					            			BRF73.getR54_os_non_resident() == null ? 0 : BRF73.getR54_os_non_resident().intValue());
					            }
					            Row r55row = sheet.getRow(62);
					            Cell r55cell = r55row.getCell(3);
					            if (r55cell != null) {
					            	r55cell.setCellValue(
					            			BRF73.getR55_no_ac_resident() == null ? 0 : BRF73.getR55_no_ac_resident().intValue());
					            }
								 Cell r55cell1 = r55row.getCell(4);
					            if (r55cell1 != null) {
					            	r55cell1.setCellValue(
					            			BRF73.getR55_os_resident() == null ? 0 : BRF73.getR55_os_resident().intValue());
					            }
								 Cell r55cell2 = r55row.getCell(5);
					            if (r55cell2 != null) {
					            	r55cell2.setCellValue(
					            			BRF73.getR55_no_ac_non_resident() == null ? 0 : BRF73.getR55_no_ac_non_resident().intValue());
					            }
								 Cell r55cell3 = r55row.getCell(6);
					            if (r55cell3 != null) {
					            	r55cell3.setCellValue(
					            			BRF73.getR55_os_non_resident() == null ? 0 : BRF73.getR55_os_non_resident().intValue());
					            }
					            Row r56row = sheet.getRow(63);
					            Cell r56cell = r56row.getCell(3);
					            if (r56cell != null) {
					            	r56cell.setCellValue(
					            			BRF73.getR56_no_ac_resident() == null ? 0 : BRF73.getR56_no_ac_resident().intValue());
					            }
								 Cell r56cell1 = r56row.getCell(4);
					            if (r56cell1 != null) {
					            	r56cell1.setCellValue(
					            			BRF73.getR56_os_resident() == null ? 0 : BRF73.getR56_os_resident().intValue());
					            }
								 Cell r56cell2 = r56row.getCell(5);
					            if (r56cell2 != null) {
					            	r56cell2.setCellValue(
					            			BRF73.getR56_no_ac_non_resident() == null ? 0 : BRF73.getR56_no_ac_non_resident().intValue());
					            }
								 Cell r56cell3 = r56row.getCell(6);
					            if (r56cell3 != null) {
					            	r56cell3.setCellValue(
					            			BRF73.getR56_os_non_resident() == null ? 0 : BRF73.getR56_os_non_resident().intValue());
					            }
					            Row r57row = sheet.getRow(64);
					            Cell r57cell = r57row.getCell(3);
					            if (r57cell != null) {
					            	r57cell.setCellValue(
					            			BRF73.getR57_no_ac_resident() == null ? 0 : BRF73.getR57_no_ac_resident().intValue());
					            }
								 Cell r57cell1 = r57row.getCell(4);
					            if (r57cell1 != null) {
					            	r57cell1.setCellValue(
					            			BRF73.getR57_os_resident() == null ? 0 : BRF73.getR57_os_resident().intValue());
					            }
								 Cell r57cell2 = r57row.getCell(5);
					            if (r57cell2 != null) {
					            	r57cell2.setCellValue(
					            			BRF73.getR57_no_ac_non_resident() == null ? 0 : BRF73.getR57_no_ac_non_resident().intValue());
					            }
								 Cell r57cell3 = r57row.getCell(6);
					            if (r57cell3 != null) {
					            	r57cell3.setCellValue(
					            			BRF73.getR57_os_non_resident() == null ? 0 : BRF73.getR57_os_non_resident().intValue());
					            }
					            Row r60row = sheet.getRow(67);
					            Cell r60cell = r60row.getCell(3);
					            if (r60cell != null) {
					            	r60cell.setCellValue(
					            			BRF73.getR60_no_ac_resident() == null ? 0 : BRF73.getR60_no_ac_resident().intValue());
					            }
								 Cell r60cell1 = r60row.getCell(4);
					            if (r60cell1 != null) {
					            	r60cell1.setCellValue(
					            			BRF73.getR60_os_resident() == null ? 0 : BRF73.getR60_os_resident().intValue());
					            }
								 Cell r60cell2 = r60row.getCell(5);
					            if (r60cell2 != null) {
					            	r60cell2.setCellValue(
					            			BRF73.getR60_no_ac_non_resident() == null ? 0 : BRF73.getR60_no_ac_non_resident().intValue());
					            }
								 Cell r60cell3 = r60row.getCell(6);
					            if (r60cell3 != null) {
					            	r60cell3.setCellValue(
					            			BRF73.getR60_os_non_resident() == null ? 0 : BRF73.getR60_os_non_resident().intValue());
					            }
					            Row r61row = sheet.getRow(68);
					            Cell r61cell = r61row.getCell(3);
					            if (r61cell != null) {
					            	r61cell.setCellValue(
					            			BRF73.getR61_no_ac_resident() == null ? 0 : BRF73.getR61_no_ac_resident().intValue());
					            }
								 Cell r61cell1 = r61row.getCell(4);
					            if (r61cell1 != null) {
					            	r61cell1.setCellValue(
					            			BRF73.getR61_os_resident() == null ? 0 : BRF73.getR61_os_resident().intValue());
					            }
								 Cell r61cell2 = r61row.getCell(5);
					            if (r61cell2 != null) {
					            	r61cell2.setCellValue(
					            			BRF73.getR61_no_ac_non_resident() == null ? 0 : BRF73.getR61_no_ac_non_resident().intValue());
					            }
								 Cell r61cell3 = r61row.getCell(6);
					            if (r61cell3 != null) {
					            	r61cell3.setCellValue(
					            			BRF73.getR61_os_non_resident() == null ? 0 : BRF73.getR61_os_non_resident().intValue());
					            }
					            Row r62row = sheet.getRow(69);
					            Cell r62cell = r62row.getCell(3);
					            if (r62cell != null) {
					            	r62cell.setCellValue(
					            			BRF73.getR62_no_ac_resident() == null ? 0 : BRF73.getR62_no_ac_resident().intValue());
					            }
								 Cell r62cell1 = r62row.getCell(4);
					            if (r62cell1 != null) {
					            	r62cell1.setCellValue(
					            			BRF73.getR62_os_resident() == null ? 0 : BRF73.getR62_os_resident().intValue());
					            }
								 Cell r62cell2 = r62row.getCell(5);
					            if (r62cell2 != null) {
					            	r62cell2.setCellValue(
					            			BRF73.getR62_no_ac_non_resident() == null ? 0 : BRF73.getR62_no_ac_non_resident().intValue());
					            }
								 Cell r62cell3 = r62row.getCell(6);
					            if (r62cell3 != null) {
					            	r62cell3.setCellValue(
					            			BRF73.getR62_os_non_resident() == null ? 0 : BRF73.getR62_os_non_resident().intValue());
					            }
					            Row r64row = sheet.getRow(71);
					            Cell r64cell = r64row.getCell(3);
					            if (r64cell != null) {
					            	r64cell.setCellValue(
					            			BRF73.getR64_no_ac_resident() == null ? 0 : BRF73.getR64_no_ac_resident().intValue());
					            }
								 Cell r64cell1 = r64row.getCell(4);
					            if (r64cell1 != null) {
					            	r64cell1.setCellValue(
					            			BRF73.getR64_os_resident() == null ? 0 : BRF73.getR64_os_resident().intValue());
					            }
								 Cell r64cell2 = r64row.getCell(5);
					            if (r64cell2 != null) {
					            	r64cell2.setCellValue(
					            			BRF73.getR64_no_ac_non_resident() == null ? 0 : BRF73.getR64_no_ac_non_resident().intValue());
					            }
								 Cell r64cell3 = r64row.getCell(6);
					            if (r64cell3 != null) {
					            	r64cell3.setCellValue(
					            			BRF73.getR64_os_non_resident() == null ? 0 : BRF73.getR64_os_non_resident().intValue());
					            }
					            Row r65row = sheet.getRow(72);
					            Cell r65cell = r65row.getCell(3);
					            if (r65cell != null) {
					            	r65cell.setCellValue(
					            			BRF73.getR65_no_ac_resident() == null ? 0 : BRF73.getR65_no_ac_resident().intValue());
					            }
								 Cell r65cell1 = r65row.getCell(4);
					            if (r65cell1 != null) {
					            	r65cell1.setCellValue(
					            			BRF73.getR65_os_resident() == null ? 0 : BRF73.getR65_os_resident().intValue());
					            }
								 Cell r65cell2 = r65row.getCell(5);
					            if (r65cell2 != null) {
					            	r65cell2.setCellValue(
					            			BRF73.getR65_no_ac_non_resident() == null ? 0 : BRF73.getR65_no_ac_non_resident().intValue());
					            }
								 Cell r65cell3 = r65row.getCell(6);
					            if (r65cell3 != null) {
					            	r65cell3.setCellValue(
					            			BRF73.getR65_os_non_resident() == null ? 0 : BRF73.getR65_os_non_resident().intValue());
					            }
					            Row r68row = sheet.getRow(75);
					            Cell r68cell = r68row.getCell(3);
					            if (r68cell != null) {
					            	r68cell.setCellValue(
					            			BRF73.getR68_no_ac_resident() == null ? 0 : BRF73.getR68_no_ac_resident().intValue());
					            }
								 Cell r68cell1 = r68row.getCell(4);
					            if (r68cell1 != null) {
					            	r68cell1.setCellValue(
					            			BRF73.getR68_os_resident() == null ? 0 : BRF73.getR68_os_resident().intValue());
					            }
								 Cell r68cell2 = r68row.getCell(5);
					            if (r68cell2 != null) {
					            	r68cell2.setCellValue(
					            			BRF73.getR68_no_ac_non_resident() == null ? 0 : BRF73.getR68_no_ac_non_resident().intValue());
					            }
								 Cell r68cell3 = r68row.getCell(6);
					            if (r68cell3 != null) {
					            	r68cell3.setCellValue(
					            			BRF73.getR68_os_non_resident() == null ? 0 : BRF73.getR68_os_non_resident().intValue());
					            }
					            Row r69row = sheet.getRow(76);
					            Cell r69cell = r69row.getCell(3);
					            if (r69cell != null) {
					            	r69cell.setCellValue(
					            			BRF73.getR69_no_ac_resident() == null ? 0 : BRF73.getR69_no_ac_resident().intValue());
					            }
								 Cell r69cell1 = r69row.getCell(4);
					            if (r69cell1 != null) {
					            	r69cell1.setCellValue(
					            			BRF73.getR69_os_resident() == null ? 0 : BRF73.getR69_os_resident().intValue());
					            }
								 Cell r69cell2 = r69row.getCell(5);
					            if (r69cell2 != null) {
					            	r69cell2.setCellValue(
					            			BRF73.getR69_no_ac_non_resident() == null ? 0 : BRF73.getR69_no_ac_non_resident().intValue());
					            }
								 Cell r69cell3 = r69row.getCell(6);
					            if (r69cell3 != null) {
					            	r69cell3.setCellValue(
					            			BRF73.getR69_os_non_resident() == null ? 0 : BRF73.getR69_os_non_resident().intValue());
					            }
					            Row r71row = sheet.getRow(78);
					            Cell r71cell = r71row.getCell(3);
					            if (r71cell != null) {
					            	r71cell.setCellValue(
					            			BRF73.getR71_no_ac_resident() == null ? 0 : BRF73.getR71_no_ac_resident().intValue());
					            }
								 Cell r71cell1 = r71row.getCell(4);
					            if (r71cell1 != null) {
					            	r71cell1.setCellValue(
					            			BRF73.getR71_os_resident() == null ? 0 : BRF73.getR71_os_resident().intValue());
					            }
								 Cell r71cell2 = r71row.getCell(5);
					            if (r71cell2 != null) {
					            	r71cell2.setCellValue(
					            			BRF73.getR71_no_ac_non_resident() == null ? 0 : BRF73.getR71_no_ac_non_resident().intValue());
					            }
								 Cell r71cell3 = r71row.getCell(6);
					            if (r71cell3 != null) {
					            	r71cell3.setCellValue(
					            			BRF73.getR71_os_non_resident() == null ? 0 : BRF73.getR71_os_non_resident().intValue());
					            }
					            Row r72row = sheet.getRow(79);
					            Cell r72cell = r72row.getCell(3);
					            if (r72cell != null) {
					            	r72cell.setCellValue(
					            			BRF73.getR72_no_ac_resident() == null ? 0 : BRF73.getR72_no_ac_resident().intValue());
					            }
								 Cell r72cell1 = r72row.getCell(4);
					            if (r72cell1 != null) {
					            	r72cell1.setCellValue(
					            			BRF73.getR72_os_resident() == null ? 0 : BRF73.getR72_os_resident().intValue());
					            }
								 Cell r72cell2 = r72row.getCell(5);
					            if (r72cell2 != null) {
					            	r72cell2.setCellValue(
					            			BRF73.getR72_no_ac_non_resident() == null ? 0 : BRF73.getR72_no_ac_non_resident().intValue());
					            }
								 Cell r72cell3 = r72row.getCell(6);
					            if (r72cell3 != null) {
					            	r72cell3.setCellValue(
					            			BRF73.getR72_os_non_resident() == null ? 0 : BRF73.getR72_os_non_resident().intValue());
					            }
					            Row r73row = sheet.getRow(80);
					            Cell r73cell = r73row.getCell(3);
					            if (r73cell != null) {
					            	r73cell.setCellValue(
					            			BRF73.getR73_no_ac_resident() == null ? 0 : BRF73.getR73_no_ac_resident().intValue());
					            }
								 Cell r73cell1 = r73row.getCell(4);
					            if (r73cell1 != null) {
					            	r73cell1.setCellValue(
					            			BRF73.getR73_os_resident() == null ? 0 : BRF73.getR73_os_resident().intValue());
					            }
								 Cell r73cell2 = r73row.getCell(5);
					            if (r73cell2 != null) {
					            	r73cell2.setCellValue(
					            			BRF73.getR73_no_ac_non_resident() == null ? 0 : BRF73.getR73_no_ac_non_resident().intValue());
					            }
								 Cell r73cell3 = r73row.getCell(6);
					            if (r73cell3 != null) {
					            	r73cell3.setCellValue(
					            			BRF73.getR73_os_non_resident() == null ? 0 : BRF73.getR73_os_non_resident().intValue());
					            }
					            Row r74row = sheet.getRow(81);
					            Cell r74cell = r74row.getCell(3);
					            if (r74cell != null) {
					            	r74cell.setCellValue(
					            			BRF73.getR74_no_ac_resident() == null ? 0 : BRF73.getR74_no_ac_resident().intValue());
					            }
								 Cell r74cell1 = r74row.getCell(4);
					            if (r74cell1 != null) {
					            	r74cell1.setCellValue(
					            			BRF73.getR74_os_resident() == null ? 0 : BRF73.getR74_os_resident().intValue());
					            }
								 Cell r74cell2 = r74row.getCell(5);
					            if (r74cell2 != null) {
					            	r74cell2.setCellValue(
					            			BRF73.getR74_no_ac_non_resident() == null ? 0 : BRF73.getR74_no_ac_non_resident().intValue());
					            }
								 Cell r74cell3 = r74row.getCell(6);
					            if (r74cell3 != null) {
					            	r74cell3.setCellValue(
					            			BRF73.getR74_os_non_resident() == null ? 0 : BRF73.getR74_os_non_resident().intValue());
					            }
					            Row r75row = sheet.getRow(82);
					            Cell r75cell = r75row.getCell(3);
					            if (r75cell != null) {
					            	r75cell.setCellValue(
					            			BRF73.getR75_no_ac_resident() == null ? 0 : BRF73.getR75_no_ac_resident().intValue());
					            }
								 Cell r75cell1 = r75row.getCell(4);
					            if (r75cell1 != null) {
					            	r75cell1.setCellValue(
					            			BRF73.getR75_os_resident() == null ? 0 : BRF73.getR75_os_resident().intValue());
					            }
								 Cell r75cell2 = r75row.getCell(5);
					            if (r75cell2 != null) {
					            	r75cell2.setCellValue(
					            			BRF73.getR75_no_ac_non_resident() == null ? 0 : BRF73.getR75_no_ac_non_resident().intValue());
					            }
								 Cell r75cell3 = r75row.getCell(6);
					            if (r75cell3 != null) {
					            	r75cell3.setCellValue(
					            			BRF73.getR75_os_non_resident() == null ? 0 : BRF73.getR75_os_non_resident().intValue());
					            }
					            Row r76row = sheet.getRow(83);
					            Cell r76cell = r76row.getCell(3);
					            if (r76cell != null) {
					            	r76cell.setCellValue(
					            			BRF73.getR76_no_ac_resident() == null ? 0 : BRF73.getR76_no_ac_resident().intValue());
					            }
								 Cell r76cell1 = r76row.getCell(4);
					            if (r76cell1 != null) {
					            	r76cell1.setCellValue(
					            			BRF73.getR76_os_resident() == null ? 0 : BRF73.getR76_os_resident().intValue());
					            }
								 Cell r76cell2 = r76row.getCell(5);
					            if (r76cell2 != null) {
					            	r76cell2.setCellValue(
					            			BRF73.getR76_no_ac_non_resident() == null ? 0 : BRF73.getR76_no_ac_non_resident().intValue());
					            }
								 Cell r76cell3 = r76row.getCell(6);
					            if (r76cell3 != null) {
					            	r76cell3.setCellValue(
					            			BRF73.getR76_os_non_resident() == null ? 0 : BRF73.getR76_os_non_resident().intValue());
					            }
					            Row r77row = sheet.getRow(84);
					            Cell r77cell = r77row.getCell(3);
					            if (r77cell != null) {
					            	r77cell.setCellValue(
					            			BRF73.getR77_no_ac_resident() == null ? 0 : BRF73.getR77_no_ac_resident().intValue());
					            }
								 Cell r77cell1 = r77row.getCell(4);
					            if (r77cell1 != null) {
					            	r77cell1.setCellValue(
					            			BRF73.getR77_os_resident() == null ? 0 : BRF73.getR77_os_resident().intValue());
					            }
								 Cell r77cell2 = r77row.getCell(5);
					            if (r77cell2 != null) {
					            	r77cell2.setCellValue(
					            			BRF73.getR77_no_ac_non_resident() == null ? 0 : BRF73.getR77_no_ac_non_resident().intValue());
					            }
								 Cell r77cell3 = r77row.getCell(6);
					            if (r77cell3 != null) {
					            	r77cell3.setCellValue(
					            			BRF73.getR77_os_non_resident() == null ? 0 : BRF73.getR77_os_non_resident().intValue());
					            }
					            Row r78row = sheet.getRow(85);
					            Cell r78cell = r78row.getCell(3);
					            if (r78cell != null) {
					            	r78cell.setCellValue(
					            			BRF73.getR78_no_ac_resident() == null ? 0 : BRF73.getR78_no_ac_resident().intValue());
					            }
								 Cell r78cell1 = r78row.getCell(4);
					            if (r78cell1 != null) {
					            	r78cell1.setCellValue(
					            			BRF73.getR78_os_resident() == null ? 0 : BRF73.getR78_os_resident().intValue());
					            }
								 Cell r78cell2 = r78row.getCell(5);
					            if (r78cell2 != null) {
					            	r78cell2.setCellValue(
					            			BRF73.getR78_no_ac_non_resident() == null ? 0 : BRF73.getR78_no_ac_non_resident().intValue());
					            }
								 Cell r78cell3 = r78row.getCell(6);
					            if (r78cell3 != null) {
					            	r78cell3.setCellValue(
					            			BRF73.getR78_os_non_resident() == null ? 0 : BRF73.getR78_os_non_resident().intValue());
					            }
					            Row r79row = sheet.getRow(86);
					            Cell r79cell = r79row.getCell(3);
					            if (r79cell != null) {
					            	r79cell.setCellValue(
					            			BRF73.getR79_no_ac_resident() == null ? 0 : BRF73.getR79_no_ac_resident().intValue());
					            }
								 Cell r79cell1 = r79row.getCell(4);
					            if (r79cell1 != null) {
					            	r79cell1.setCellValue(
					            			BRF73.getR79_os_resident() == null ? 0 : BRF73.getR79_os_resident().intValue());
					            }
								 Cell r79cell2 = r79row.getCell(5);
					            if (r79cell2 != null) {
					            	r79cell2.setCellValue(
					            			BRF73.getR79_no_ac_non_resident() == null ? 0 : BRF73.getR79_no_ac_non_resident().intValue());
					            }
								 Cell r79cell3 = r79row.getCell(6);
					            if (r79cell3 != null) {
					            	r79cell3.setCellValue(
					            			BRF73.getR79_os_non_resident() == null ? 0 : BRF73.getR79_os_non_resident().intValue());
					            }
					            Row r81row = sheet.getRow(88);
					            Cell r81cell = r81row.getCell(3);
					            if (r81cell != null) {
					            	r81cell.setCellValue(
					            			BRF73.getR81_no_ac_resident() == null ? 0 : BRF73.getR81_no_ac_resident().intValue());
					            }
								 Cell r81cell1 = r81row.getCell(4);
					            if (r81cell1 != null) {
					            	r81cell1.setCellValue(
					            			BRF73.getR81_os_resident() == null ? 0 : BRF73.getR81_os_resident().intValue());
					            }
								 Cell r81cell2 = r81row.getCell(5);
					            if (r81cell2 != null) {
					            	r81cell2.setCellValue(
					            			BRF73.getR81_no_ac_non_resident() == null ? 0 : BRF73.getR81_no_ac_non_resident().intValue());
					            }
								 Cell r81cell3 = r81row.getCell(6);
					            if (r81cell3 != null) {
					            	r81cell3.setCellValue(
					            			BRF73.getR81_os_non_resident() == null ? 0 : BRF73.getR81_os_non_resident().intValue());
					            }
					            Row r82row = sheet.getRow(89);
					            Cell r82cell = r82row.getCell(3);
					            if (r82cell != null) {
					            	r82cell.setCellValue(
					            			BRF73.getR82_no_ac_resident() == null ? 0 : BRF73.getR82_no_ac_resident().intValue());
					            }
								 Cell r82cell1 = r82row.getCell(4);
					            if (r82cell1 != null) {
					            	r82cell1.setCellValue(
					            			BRF73.getR82_os_resident() == null ? 0 : BRF73.getR82_os_resident().intValue());
					            }
								 Cell r82cell2 = r82row.getCell(5);
					            if (r82cell2 != null) {
					            	r82cell2.setCellValue(
					            			BRF73.getR82_no_ac_non_resident() == null ? 0 : BRF73.getR82_no_ac_non_resident().intValue());
					            }
								 Cell r82cell3 = r82row.getCell(6);
					            if (r82cell3 != null) {
					            	r82cell3.setCellValue(
					            			BRF73.getR82_os_non_resident() == null ? 0 : BRF73.getR82_os_non_resident().intValue());
					            }
					            Row r83row = sheet.getRow(90);
					            Cell r83cell = r83row.getCell(3);
					            if (r83cell != null) {
					            	r83cell.setCellValue(
					            			BRF73.getR83_no_ac_resident() == null ? 0 : BRF73.getR83_no_ac_resident().intValue());
					            }
								 Cell r83cell1 = r83row.getCell(4);
					            if (r83cell1 != null) {
					            	r83cell1.setCellValue(
					            			BRF73.getR83_os_resident() == null ? 0 : BRF73.getR83_os_resident().intValue());
					            }
								 Cell r83cell2 = r83row.getCell(5);
					            if (r83cell2 != null) {
					            	r83cell2.setCellValue(
					            			BRF73.getR83_no_ac_non_resident() == null ? 0 : BRF73.getR83_no_ac_non_resident().intValue());
					            }
								 Cell r83cell3 = r83row.getCell(6);
					            if (r83cell3 != null) {
					            	r83cell3.setCellValue(
					            			BRF73.getR83_os_non_resident() == null ? 0 : BRF73.getR83_os_non_resident().intValue());
					            }
					            Row r84row = sheet.getRow(91);
					            Cell r84cell = r84row.getCell(3);
					            if (r84cell != null) {
					            	r84cell.setCellValue(
					            			BRF73.getR84_no_ac_resident() == null ? 0 : BRF73.getR84_no_ac_resident().intValue());
					            }
								 Cell r84cell1 = r84row.getCell(4);
					            if (r84cell1 != null) {
					            	r84cell1.setCellValue(
					            			BRF73.getR84_os_resident() == null ? 0 : BRF73.getR84_os_resident().intValue());
					            }
								 Cell r84cell2 = r84row.getCell(5);
					            if (r84cell2 != null) {
					            	r84cell2.setCellValue(
					            			BRF73.getR84_no_ac_non_resident() == null ? 0 : BRF73.getR84_no_ac_non_resident().intValue());
					            }
								 Cell r84cell3 = r84row.getCell(6);
					            if (r84cell3 != null) {
					            	r84cell3.setCellValue(
					            			BRF73.getR84_os_non_resident() == null ? 0 : BRF73.getR84_os_non_resident().intValue());
					            }
					            Row r85row = sheet.getRow(92);
					            Cell r85cell = r85row.getCell(3);
					            if (r85cell != null) {
					            	r85cell.setCellValue(
					            			BRF73.getR85_no_ac_resident() == null ? 0 : BRF73.getR85_no_ac_resident().intValue());
					            }
								 Cell r85cell1 = r85row.getCell(4);
					            if (r85cell1 != null) {
					            	r85cell1.setCellValue(
					            			BRF73.getR85_os_resident() == null ? 0 : BRF73.getR85_os_resident().intValue());
					            }
								 Cell r85cell2 = r85row.getCell(5);
					            if (r85cell2 != null) {
					            	r85cell2.setCellValue(
					            			BRF73.getR85_no_ac_non_resident() == null ? 0 : BRF73.getR85_no_ac_non_resident().intValue());
					            }
								 Cell r85cell3 = r85row.getCell(6);
					            if (r85cell3 != null) {
					            	r85cell3.setCellValue(
					            			BRF73.getR85_os_non_resident() == null ? 0 : BRF73.getR85_os_non_resident().intValue());
					            }
					            Row r86row = sheet.getRow(93);
					            Cell r86cell = r86row.getCell(3);
					            if (r86cell != null) {
					            	r86cell.setCellValue(
					            			BRF73.getR86_no_ac_resident() == null ? 0 : BRF73.getR86_no_ac_resident().intValue());
					            }
								 Cell r86cell1 = r86row.getCell(4);
					            if (r86cell1 != null) {
					            	r86cell1.setCellValue(
					            			BRF73.getR86_os_resident() == null ? 0 : BRF73.getR86_os_resident().intValue());
					            }
								 Cell r86cell2 = r86row.getCell(5);
					            if (r86cell2 != null) {
					            	r86cell2.setCellValue(
					            			BRF73.getR86_no_ac_non_resident() == null ? 0 : BRF73.getR86_no_ac_non_resident().intValue());
					            }
								 Cell r86cell3 = r86row.getCell(6);
					            if (r86cell3 != null) {
					            	r86cell3.setCellValue(
					            			BRF73.getR86_os_non_resident() == null ? 0 : BRF73.getR86_os_non_resident().intValue());
					            }
					            Row r87row = sheet.getRow(94);
					            Cell r87cell = r87row.getCell(3);
					            if (r87cell != null) {
					            	r87cell.setCellValue(
					            			BRF73.getR87_no_ac_resident() == null ? 0 : BRF73.getR87_no_ac_resident().intValue());
					            }
								 Cell r87cell1 = r87row.getCell(4);
					            if (r87cell1 != null) {
					            	r87cell1.setCellValue(
					            			BRF73.getR87_os_resident() == null ? 0 : BRF73.getR87_os_resident().intValue());
					            }
								 Cell r87cell2 = r87row.getCell(5);
					            if (r87cell2 != null) {
					            	r87cell2.setCellValue(
					            			BRF73.getR87_no_ac_non_resident() == null ? 0 : BRF73.getR87_no_ac_non_resident().intValue());
					            }
								 Cell r87cell3 = r87row.getCell(6);
					            if (r87cell3 != null) {
					            	r87cell3.setCellValue(
					            			BRF73.getR87_os_non_resident() == null ? 0 : BRF73.getR87_os_non_resident().intValue());
					            }
					          ///////
					            Row r90row = sheet.getRow(97);
					            Cell r90cell = r90row.getCell(3);
					            if (r90cell != null) {
					            	r90cell.setCellValue(
					            			BRF73.getR90_no_ac_resident() == null ? 0 : BRF73.getR90_no_ac_resident().intValue());
					            }
								 Cell r90cell1 = r90row.getCell(4);
					            if (r90cell1 != null) {
					            	r90cell1.setCellValue(
					            			BRF73.getR90_os_resident() == null ? 0 : BRF73.getR90_os_resident().intValue());
					            }
								 Cell r90cell2 = r90row.getCell(5);
					            if (r90cell2 != null) {
					            	r90cell2.setCellValue(
					            			BRF73.getR90_no_ac_non_resident() == null ? 0 : BRF73.getR90_no_ac_non_resident().intValue());
					            }
								 Cell r90cell3 = r90row.getCell(6);
					            if (r90cell3 != null) {
					            	r90cell3.setCellValue(
					            			BRF73.getR90_os_non_resident() == null ? 0 : BRF73.getR90_os_non_resident().intValue());
					            }
					            Row r91row = sheet.getRow(98);
					            Cell r91cell = r91row.getCell(3);
					            if (r91cell != null) {
					            	r91cell.setCellValue(
					            			BRF73.getR91_no_ac_resident() == null ? 0 : BRF73.getR91_no_ac_resident().intValue());
					            }
								 Cell r91cell1 = r91row.getCell(4);
					            if (r91cell1 != null) {
					            	r91cell1.setCellValue(
					            			BRF73.getR91_os_resident() == null ? 0 : BRF73.getR91_os_resident().intValue());
					            }
								 Cell r91cell2 = r91row.getCell(5);
					            if (r91cell2 != null) {
					            	r91cell2.setCellValue(
					            			BRF73.getR91_no_ac_non_resident() == null ? 0 : BRF73.getR91_no_ac_non_resident().intValue());
					            }
								 Cell r91cell3 = r91row.getCell(6);
					            if (r91cell3 != null) {
					            	r91cell3.setCellValue(
					            			BRF73.getR91_os_non_resident() == null ? 0 : BRF73.getR91_os_non_resident().intValue());
					            }
					            Row r92row = sheet.getRow(99);
					            Cell r92cell = r92row.getCell(3);
					            if (r92cell != null) {
					            	r92cell.setCellValue(
					            			BRF73.getR92_no_ac_resident() == null ? 0 : BRF73.getR92_no_ac_resident().intValue());
					            }
								 Cell r92cell1 = r92row.getCell(4);
					            if (r92cell1 != null) {
					            	r92cell1.setCellValue(
					            			BRF73.getR92_os_resident() == null ? 0 : BRF73.getR92_os_resident().intValue());
					            }
								 Cell r92cell2 = r92row.getCell(5);
					            if (r92cell2 != null) {
					            	r92cell2.setCellValue(
					            			BRF73.getR92_no_ac_non_resident() == null ? 0 : BRF73.getR92_no_ac_non_resident().intValue());
					            }
								 Cell r92cell3 = r92row.getCell(6);
					            if (r92cell3 != null) {
					            	r92cell3.setCellValue(
					            			BRF73.getR92_os_non_resident() == null ? 0 : BRF73.getR92_os_non_resident().intValue());
					            }
					            Row r93row = sheet.getRow(100);
					            Cell r93cell = r93row.getCell(3);
					            if (r93cell != null) {
					            	r93cell.setCellValue(
					            			BRF73.getR93_no_ac_resident() == null ? 0 : BRF73.getR93_no_ac_resident().intValue());
					            }
								 Cell r93cell1 = r93row.getCell(4);
					            if (r93cell1 != null) {
					            	r93cell1.setCellValue(
					            			BRF73.getR93_os_resident() == null ? 0 : BRF73.getR93_os_resident().intValue());
					            }
								 Cell r93cell2 = r93row.getCell(5);
					            if (r93cell2 != null) {
					            	r93cell2.setCellValue(
					            			BRF73.getR93_no_ac_non_resident() == null ? 0 : BRF73.getR93_no_ac_non_resident().intValue());
					            }
								 Cell r93cell3 = r93row.getCell(6);
					            if (r93cell3 != null) {
					            	r93cell3.setCellValue(
					            			BRF73.getR93_os_non_resident() == null ? 0 : BRF73.getR93_os_non_resident().intValue());
					            }
					            Row r95row = sheet.getRow(102);
					            Cell r95cell = r95row.getCell(3);
					            if (r95cell != null) {
					            	r95cell.setCellValue(
					            			BRF73.getR95_no_ac_resident() == null ? 0 : BRF73.getR95_no_ac_resident().intValue());
					            }
								 Cell r95cell1 = r95row.getCell(4);
					            if (r95cell1 != null) {
					            	r95cell1.setCellValue(
					            			BRF73.getR95_os_resident() == null ? 0 : BRF73.getR95_os_resident().intValue());
					            }
								 Cell r95cell2 = r95row.getCell(5);
					            if (r95cell2 != null) {
					            	r95cell2.setCellValue(
					            			BRF73.getR95_no_ac_non_resident() == null ? 0 : BRF73.getR95_no_ac_non_resident().intValue());
					            }
								 Cell r95cell3 = r95row.getCell(6);
					            if (r95cell3 != null) {
					            	r95cell3.setCellValue(
					            			BRF73.getR95_os_non_resident() == null ? 0 : BRF73.getR95_os_non_resident().intValue());
					            }
					            Row r97row = sheet.getRow(104);
					            Cell r97cell = r97row.getCell(3);
					            if (r97cell != null) {
					            	r97cell.setCellValue(
					            			BRF73.getR97_no_ac_resident() == null ? 0 : BRF73.getR97_no_ac_resident().intValue());
					            }
								 Cell r97cell1 = r97row.getCell(4);
					            if (r97cell1 != null) {
					            	r97cell1.setCellValue(
					            			BRF73.getR97_os_resident() == null ? 0 : BRF73.getR97_os_resident().intValue());
					            }
								 Cell r97cell2 = r97row.getCell(5);
					            if (r97cell2 != null) {
					            	r97cell2.setCellValue(
					            			BRF73.getR97_no_ac_non_resident() == null ? 0 : BRF73.getR97_no_ac_non_resident().intValue());
					            }
								 Cell r97cell3 = r97row.getCell(6);
					            if (r97cell3 != null) {
					            	r97cell3.setCellValue(
					            			BRF73.getR97_os_non_resident() == null ? 0 : BRF73.getR97_os_non_resident().intValue());
					            }
					            Row r99row = sheet.getRow(106);
					            Cell r99cell = r99row.getCell(3);
					            if (r99cell != null) {
					            	r99cell.setCellValue(
					            			BRF73.getR99_no_ac_resident() == null ? 0 : BRF73.getR99_no_ac_resident().intValue());
					            }
								 Cell r99cell1 = r99row.getCell(4);
					            if (r99cell1 != null) {
					            	r99cell1.setCellValue(
					            			BRF73.getR99_os_resident() == null ? 0 : BRF73.getR99_os_resident().intValue());
					            }
								 Cell r99cell2 = r99row.getCell(5);
					            if (r99cell2 != null) {
					            	r99cell2.setCellValue(
					            			BRF73.getR99_no_ac_non_resident() == null ? 0 : BRF73.getR99_no_ac_non_resident().intValue());
					            }
								 Cell r99cell3 = r99row.getCell(6);
					            if (r99cell3 != null) {
					            	r99cell3.setCellValue(
					            			BRF73.getR99_os_non_resident() == null ? 0 : BRF73.getR99_os_non_resident().intValue());
					            }
					            Row r100row = sheet.getRow(107);
					            Cell r100cell = r100row.getCell(3);
					            if (r100cell != null) {
					            	r100cell.setCellValue(
					            			BRF73.getR100_no_ac_resident() == null ? 0 : BRF73.getR100_no_ac_resident().intValue());
					            }
								 Cell r100cell1 = r100row.getCell(4);
					            if (r100cell1 != null) {
					            	r100cell1.setCellValue(
					            			BRF73.getR100_os_resident() == null ? 0 : BRF73.getR100_os_resident().intValue());
					            }
								 Cell r100cell2 = r100row.getCell(5);
					            if (r100cell2 != null) {
					            	r100cell2.setCellValue(
					            			BRF73.getR100_no_ac_non_resident() == null ? 0 : BRF73.getR100_no_ac_non_resident().intValue());
					            }
								 Cell r100cell3 = r100row.getCell(6);
					            if (r100cell3 != null) {
					            	r100cell3.setCellValue(
					            			BRF73.getR100_os_non_resident() == null ? 0 : BRF73.getR100_os_non_resident().intValue());
					            }
					            Row r102row = sheet.getRow(109);
					            Cell r102cell = r102row.getCell(3);
					            if (r102cell != null) {
					            	r102cell.setCellValue(
					            			BRF73.getR102_no_ac_resident() == null ? 0 : BRF73.getR102_no_ac_resident().intValue());
					            }
								 Cell r102cell1 = r102row.getCell(4);
					            if (r102cell1 != null) {
					            	r102cell1.setCellValue(
					            			BRF73.getR102_os_resident() == null ? 0 : BRF73.getR102_os_resident().intValue());
					            }
								 Cell r102cell2 = r102row.getCell(5);
					            if (r102cell2 != null) {
					            	r102cell2.setCellValue(
					            			BRF73.getR102_no_ac_non_resident() == null ? 0 : BRF73.getR102_no_ac_non_resident().intValue());
					            }
								 Cell r102cell3 = r102row.getCell(6);
					            if (r102cell3 != null) {
					            	r102cell3.setCellValue(
					            			BRF73.getR102_os_non_resident() == null ? 0 : BRF73.getR102_os_non_resident().intValue());
					            }
					            Row r103row = sheet.getRow(110);
					            Cell r103cell = r103row.getCell(3);
					            if (r103cell != null) {
					            	r103cell.setCellValue(
					            			BRF73.getR103_no_ac_resident() == null ? 0 : BRF73.getR103_no_ac_resident().intValue());
					            }
								 Cell r103cell1 = r103row.getCell(4);
					            if (r103cell1 != null) {
					            	r103cell1.setCellValue(
					            			BRF73.getR103_os_resident() == null ? 0 : BRF73.getR103_os_resident().intValue());
					            }
								 Cell r103cell2 = r103row.getCell(5);
					            if (r103cell2 != null) {
					            	r103cell2.setCellValue(
					            			BRF73.getR103_no_ac_non_resident() == null ? 0 : BRF73.getR103_no_ac_non_resident().intValue());
					            }
								 Cell r103cell3 = r103row.getCell(6);
					            if (r103cell3 != null) {
					            	r103cell3.setCellValue(
					            			BRF73.getR103_os_non_resident() == null ? 0 : BRF73.getR103_os_non_resident().intValue());
					            }
					            Row r104row = sheet.getRow(111);
					            Cell r104cell = r104row.getCell(3);
					            if (r104cell != null) {
					            	r104cell.setCellValue(
					            			BRF73.getR104_no_ac_resident() == null ? 0 : BRF73.getR104_no_ac_resident().intValue());
					            }
								 Cell r104cell1 = r104row.getCell(4);
					            if (r104cell1 != null) {
					            	r104cell1.setCellValue(
					            			BRF73.getR104_os_resident() == null ? 0 : BRF73.getR104_os_resident().intValue());
					            }
								 Cell r104cell2 = r104row.getCell(5);
					            if (r104cell2 != null) {
					            	r104cell2.setCellValue(
					            			BRF73.getR104_no_ac_non_resident() == null ? 0 : BRF73.getR104_no_ac_non_resident().intValue());
					            }
								 Cell r104cell3 = r104row.getCell(6);
					            if (r104cell3 != null) {
					            	r104cell3.setCellValue(
					            			BRF73.getR104_os_non_resident() == null ? 0 : BRF73.getR104_os_non_resident().intValue());
					            }
					            Row r105row = sheet.getRow(112);
					            Cell r105cell = r105row.getCell(3);
					            if (r105cell != null) {
					            	r105cell.setCellValue(
					            			BRF73.getR105_no_ac_resident() == null ? 0 : BRF73.getR105_no_ac_resident().intValue());
					            }
								 Cell r105cell1 = r105row.getCell(4);
					            if (r105cell1 != null) {
					            	r105cell1.setCellValue(
					            			BRF73.getR105_os_resident() == null ? 0 : BRF73.getR105_os_resident().intValue());
					            }
								 Cell r105cell2 = r105row.getCell(5);
					            if (r105cell2 != null) {
					            	r105cell2.setCellValue(
					            			BRF73.getR105_no_ac_non_resident() == null ? 0 : BRF73.getR105_no_ac_non_resident().intValue());
					            }
								 Cell r105cell3 = r105row.getCell(6);
					            if (r105cell3 != null) {
					            	r105cell3.setCellValue(
					            			BRF73.getR105_os_non_resident() == null ? 0 : BRF73.getR105_os_non_resident().intValue());
					            }
					            Row r106row = sheet.getRow(113);
					            Cell r106cell = r106row.getCell(3);
					            if (r106cell != null) {
					            	r106cell.setCellValue(
					            			BRF73.getR106_no_ac_resident() == null ? 0 : BRF73.getR106_no_ac_resident().intValue());
					            }
								 Cell r106cell1 = r106row.getCell(4);
					            if (r106cell1 != null) {
					            	r106cell1.setCellValue(
					            			BRF73.getR106_os_resident() == null ? 0 : BRF73.getR106_os_resident().intValue());
					            }
								 Cell r106cell2 = r106row.getCell(5);
					            if (r106cell2 != null) {
					            	r106cell2.setCellValue(
					            			BRF73.getR106_no_ac_non_resident() == null ? 0 : BRF73.getR106_no_ac_non_resident().intValue());
					            }
								 Cell r106cell3 = r106row.getCell(6);
					            if (r106cell3 != null) {
					            	r106cell3.setCellValue(
					            			BRF73.getR106_os_non_resident() == null ? 0 : BRF73.getR106_os_non_resident().intValue());
					            }
					            Row r107row = sheet.getRow(114);
					            Cell r107cell = r107row.getCell(3);
					            if (r107cell != null) {
					            	r107cell.setCellValue(
					            			BRF73.getR107_no_ac_resident() == null ? 0 : BRF73.getR107_no_ac_resident().intValue());
					            }
								 Cell r107cell1 = r107row.getCell(4);
					            if (r107cell1 != null) {
					            	r107cell1.setCellValue(
					            			BRF73.getR107_os_resident() == null ? 0 : BRF73.getR107_os_resident().intValue());
					            }
								 Cell r107cell2 = r107row.getCell(5);
					            if (r107cell2 != null) {
					            	r107cell2.setCellValue(
					            			BRF73.getR107_no_ac_non_resident() == null ? 0 : BRF73.getR107_no_ac_non_resident().intValue());
					            }
								 Cell r107cell3 = r107row.getCell(6);
					            if (r107cell3 != null) {
					            	r107cell3.setCellValue(
					            			BRF73.getR107_os_non_resident() == null ? 0 : BRF73.getR107_os_non_resident().intValue());
					            }
					            Row r110row = sheet.getRow(117);
					            Cell r110cell = r110row.getCell(3);
					            if (r110cell != null) {
					            	r110cell.setCellValue(
					            			BRF73.getR110_no_ac_resident() == null ? 0 : BRF73.getR110_no_ac_resident().intValue());
					            }
								 Cell r110cell1 = r110row.getCell(4);
					            if (r110cell1 != null) {
					            	r110cell1.setCellValue(
					            			BRF73.getR110_os_resident() == null ? 0 : BRF73.getR110_os_resident().intValue());
					            }
								 Cell r110cell2 = r110row.getCell(5);
					            if (r110cell2 != null) {
					            	r110cell2.setCellValue(
					            			BRF73.getR110_no_ac_non_resident() == null ? 0 : BRF73.getR110_no_ac_non_resident().intValue());
					            }
								 Cell r110cell3 = r110row.getCell(6);
					            if (r110cell3 != null) {
					            	r110cell3.setCellValue(
					            			BRF73.getR110_os_non_resident() == null ? 0 : BRF73.getR110_os_non_resident().intValue());
					            }
					            Row r111row = sheet.getRow(118);
					            Cell r111cell = r111row.getCell(3);
					            if (r111cell != null) {
					            	r111cell.setCellValue(
					            			BRF73.getR111_no_ac_resident() == null ? 0 : BRF73.getR111_no_ac_resident().intValue());
					            }
								 Cell r111cell1 = r111row.getCell(4);
					            if (r111cell1 != null) {
					            	r111cell1.setCellValue(
					            			BRF73.getR111_os_resident() == null ? 0 : BRF73.getR111_os_resident().intValue());
					            }
								 Cell r111cell2 = r111row.getCell(5);
					            if (r111cell2 != null) {
					            	r111cell2.setCellValue(
					            			BRF73.getR111_no_ac_non_resident() == null ? 0 : BRF73.getR111_no_ac_non_resident().intValue());
					            }
								 Cell r111cell3 = r111row.getCell(6);
					            if (r111cell3 != null) {
					            	r111cell3.setCellValue(
					            			BRF73.getR111_os_non_resident() == null ? 0 : BRF73.getR111_os_non_resident().intValue());
					            }
					            Row r113row = sheet.getRow(120);
					            Cell r113cell = r113row.getCell(3);
					            if (r113cell != null) {
					            	r113cell.setCellValue(
					            			BRF73.getR113_no_ac_resident() == null ? 0 : BRF73.getR113_no_ac_resident().intValue());
					            }
								 Cell r113cell1 = r113row.getCell(4);
					            if (r113cell1 != null) {
					            	r113cell1.setCellValue(
					            			BRF73.getR113_os_resident() == null ? 0 : BRF73.getR113_os_resident().intValue());
					            }
								 Cell r113cell2 = r113row.getCell(5);
					            if (r113cell2 != null) {
					            	r113cell2.setCellValue(
					            			BRF73.getR113_no_ac_non_resident() == null ? 0 : BRF73.getR113_no_ac_non_resident().intValue());
					            }
								 Cell r113cell3 = r113row.getCell(6);
					            if (r113cell3 != null) {
					            	r113cell3.setCellValue(
					            			BRF73.getR113_os_non_resident() == null ? 0 : BRF73.getR113_os_non_resident().intValue());
					            }
					            Row r114row = sheet.getRow(121);
					            Cell r114cell = r114row.getCell(3);
					            if (r114cell != null) {
					            	r114cell.setCellValue(
					            			BRF73.getR114_no_ac_resident() == null ? 0 : BRF73.getR114_no_ac_resident().intValue());
					            }
								 Cell r114cell1 = r114row.getCell(4);
					            if (r114cell1 != null) {
					            	r114cell1.setCellValue(
					            			BRF73.getR114_os_resident() == null ? 0 : BRF73.getR114_os_resident().intValue());
					            }
								 Cell r114cell2 = r114row.getCell(5);
					            if (r114cell2 != null) {
					            	r114cell2.setCellValue(
					            			BRF73.getR114_no_ac_non_resident() == null ? 0 : BRF73.getR114_no_ac_non_resident().intValue());
					            }
								 Cell r114cell3 = r114row.getCell(6);
					            if (r114cell3 != null) {
					            	r114cell3.setCellValue(
					            			BRF73.getR114_os_non_resident() == null ? 0 : BRF73.getR114_os_non_resident().intValue());
					            }
					            Row r115row = sheet.getRow(122);
					            Cell r115cell = r115row.getCell(3);
					            if (r115cell != null) {
					            	r115cell.setCellValue(
					            			BRF73.getR115_no_ac_resident() == null ? 0 : BRF73.getR115_no_ac_resident().intValue());
					            }
								 Cell r115cell1 = r115row.getCell(4);
					            if (r115cell1 != null) {
					            	r115cell1.setCellValue(
					            			BRF73.getR115_os_resident() == null ? 0 : BRF73.getR115_os_resident().intValue());
					            }
								 Cell r115cell2 = r115row.getCell(5);
					            if (r115cell2 != null) {
					            	r115cell2.setCellValue(
					            			BRF73.getR115_no_ac_non_resident() == null ? 0 : BRF73.getR115_no_ac_non_resident().intValue());
					            }
								 Cell r115cell3 = r115row.getCell(6);
					            if (r115cell3 != null) {
					            	r115cell3.setCellValue(
					            			BRF73.getR115_os_non_resident() == null ? 0 : BRF73.getR115_os_non_resident().intValue());
					            }
					            Row r116row = sheet.getRow(123);
					            Cell r116cell = r116row.getCell(3);
					            if (r116cell != null) {
					            	r116cell.setCellValue(
					            			BRF73.getR116_no_ac_resident() == null ? 0 : BRF73.getR116_no_ac_resident().intValue());
					            }
								 Cell r116cell1 = r116row.getCell(4);
					            if (r116cell1 != null) {
					            	r116cell1.setCellValue(
					            			BRF73.getR116_os_resident() == null ? 0 : BRF73.getR116_os_resident().intValue());
					            }
								 Cell r116cell2 = r116row.getCell(5);
					            if (r116cell2 != null) {
					            	r116cell2.setCellValue(
					            			BRF73.getR116_no_ac_non_resident() == null ? 0 : BRF73.getR116_no_ac_non_resident().intValue());
					            }
								 Cell r116cell3 = r116row.getCell(6);
					            if (r116cell3 != null) {
					            	r116cell3.setCellValue(
					            			BRF73.getR116_os_non_resident() == null ? 0 : BRF73.getR116_os_non_resident().intValue());
					            }
					            Row r117row = sheet.getRow(124);
					            Cell r117cell = r117row.getCell(3);
					            if (r117cell != null) {
					            	r117cell.setCellValue(
					            			BRF73.getR117_no_ac_resident() == null ? 0 : BRF73.getR117_no_ac_resident().intValue());
					            }
								 Cell r117cell1 = r117row.getCell(4);
					            if (r117cell1 != null) {
					            	r117cell1.setCellValue(
					            			BRF73.getR117_os_resident() == null ? 0 : BRF73.getR117_os_resident().intValue());
					            }
								 Cell r117cell2 = r117row.getCell(5);
					            if (r117cell2 != null) {
					            	r117cell2.setCellValue(
					            			BRF73.getR117_no_ac_non_resident() == null ? 0 : BRF73.getR117_no_ac_non_resident().intValue());
					            }
								 Cell r117cell3 = r117row.getCell(6);
					            if (r117cell3 != null) {
					            	r117cell3.setCellValue(
					            			BRF73.getR117_os_non_resident() == null ? 0 : BRF73.getR117_os_non_resident().intValue());
					            }
					            Row r118row = sheet.getRow(125);
					            Cell r118cell = r118row.getCell(3);
					            if (r118cell != null) {
					            	r118cell.setCellValue(
					            			BRF73.getR118_no_ac_resident() == null ? 0 : BRF73.getR118_no_ac_resident().intValue());
					            }
								 Cell r118cell1 = r118row.getCell(4);
					            if (r118cell1 != null) {
					            	r118cell1.setCellValue(
					            			BRF73.getR118_os_resident() == null ? 0 : BRF73.getR118_os_resident().intValue());
					            }
								 Cell r118cell2 = r118row.getCell(5);
					            if (r118cell2 != null) {
					            	r118cell2.setCellValue(
					            			BRF73.getR118_no_ac_non_resident() == null ? 0 : BRF73.getR118_no_ac_non_resident().intValue());
					            }
								 Cell r118cell3 = r118row.getCell(6);
					            if (r118cell3 != null) {
					            	r118cell3.setCellValue(
					            			BRF73.getR118_os_non_resident() == null ? 0 : BRF73.getR118_os_non_resident().intValue());
					            }
					            Row r119row = sheet.getRow(126);
					            Cell r119cell = r119row.getCell(3);
					            if (r119cell != null) {
					            	r119cell.setCellValue(
					            			BRF73.getR119_no_ac_resident() == null ? 0 : BRF73.getR119_no_ac_resident().intValue());
					            }
								 Cell r119cell1 = r119row.getCell(4);
					            if (r119cell1 != null) {
					            	r119cell1.setCellValue(
					            			BRF73.getR119_os_resident() == null ? 0 : BRF73.getR119_os_resident().intValue());
					            }
								 Cell r119cell2 = r119row.getCell(5);
					            if (r119cell2 != null) {
					            	r119cell2.setCellValue(
					            			BRF73.getR119_no_ac_non_resident() == null ? 0 : BRF73.getR119_no_ac_non_resident().intValue());
					            }
								 Cell r119cell3 = r119row.getCell(6);
					            if (r119cell3 != null) {
					            	r119cell3.setCellValue(
					            			BRF73.getR119_os_non_resident() == null ? 0 : BRF73.getR119_os_non_resident().intValue());
					            }
						}
					}
					if (T1Master1.size() == 1) {
						for (BRF73B_ENTITY BRF73a : T1Master1) {
							
					            Row r121row = sheet.getRow(128);
					            Cell r121cell = r121row.getCell(3);
					            if (r121cell != null) {
					            	r121cell.setCellValue(
					            			BRF73a.getR121_no_ac_resident() == null ? 0 : BRF73a.getR121_no_ac_resident().intValue());
					            }
								 Cell r121cell1 = r121row.getCell(4);
					            if (r121cell1 != null) {
					            	r121cell1.setCellValue(
					            			BRF73a.getR121_os_resident() == null ? 0 : BRF73a.getR121_os_resident().intValue());
					            }
								 Cell r121cell2 = r121row.getCell(5);
					            if (r121cell2 != null) {
					            	r121cell2.setCellValue(
					            			BRF73a.getR121_no_ac_non_resident() == null ? 0 : BRF73a.getR121_no_ac_non_resident().intValue());
					            }
								 Cell r121cell3 = r121row.getCell(6);
					            if (r121cell3 != null) {
					            	r121cell3.setCellValue(
					            			BRF73a.getR121_os_non_resident() == null ? 0 : BRF73a.getR121_os_non_resident().intValue());
					            }
					            Row r122row = sheet.getRow(129);
					            Cell r122cell = r122row.getCell(3);
					            if (r122cell != null) {
					            	r122cell.setCellValue(
					            			BRF73a.getR122_no_ac_resident() == null ? 0 : BRF73a.getR122_no_ac_resident().intValue());
					            }
								 Cell r122cell1 = r122row.getCell(4);
					            if (r122cell1 != null) {
					            	r122cell1.setCellValue(
					            			BRF73a.getR122_os_resident() == null ? 0 : BRF73a.getR122_os_resident().intValue());
					            }
								 Cell r122cell2 = r122row.getCell(5);
					            if (r122cell2 != null) {
					            	r122cell2.setCellValue(
					            			BRF73a.getR122_no_ac_non_resident() == null ? 0 : BRF73a.getR122_no_ac_non_resident().intValue());
					            }
								 Cell r122cell3 = r122row.getCell(6);
					            if (r122cell3 != null) {
					            	r122cell3.setCellValue(
					            			BRF73a.getR122_os_non_resident() == null ? 0 : BRF73a.getR122_os_non_resident().intValue());
					            }
					            Row r123row = sheet.getRow(130);
					            Cell r123cell = r123row.getCell(3);
					            if (r123cell != null) {
					            	r123cell.setCellValue(
					            			BRF73a.getR123_no_ac_resident() == null ? 0 : BRF73a.getR123_no_ac_resident().intValue());
					            }
								 Cell r123cell1 = r123row.getCell(4);
					            if (r123cell1 != null) {
					            	r123cell1.setCellValue(
					            			BRF73a.getR123_os_resident() == null ? 0 : BRF73a.getR123_os_resident().intValue());
					            }
								 Cell r123cell2 = r123row.getCell(5);
					            if (r123cell2 != null) {
					            	r123cell2.setCellValue(
					            			BRF73a.getR123_no_ac_non_resident() == null ? 0 : BRF73a.getR123_no_ac_non_resident().intValue());
					            }
								 Cell r123cell3 = r123row.getCell(6);
					            if (r123cell3 != null) {
					            	r123cell3.setCellValue(
					            			BRF73a.getR123_os_non_resident() == null ? 0 : BRF73a.getR123_os_non_resident().intValue());
					            }
					            Row r124row = sheet.getRow(131);
					            Cell r124cell = r124row.getCell(3);
					            if (r124cell != null) {
					            	r124cell.setCellValue(
					            			BRF73a.getR124_no_ac_resident() == null ? 0 : BRF73a.getR124_no_ac_resident().intValue());
					            }
								 Cell r124cell1 = r124row.getCell(4);
					            if (r124cell1 != null) {
					            	r124cell1.setCellValue(
					            			BRF73a.getR124_os_resident() == null ? 0 : BRF73a.getR124_os_resident().intValue());
					            }
								 Cell r124cell2 = r124row.getCell(5);
					            if (r124cell2 != null) {
					            	r124cell2.setCellValue(
					            			BRF73a.getR124_no_ac_non_resident() == null ? 0 : BRF73a.getR124_no_ac_non_resident().intValue());
					            }
								 Cell r124cell3 = r124row.getCell(6);
					            if (r124cell3 != null) {
					            	r124cell3.setCellValue(
					            			BRF73a.getR124_os_non_resident() == null ? 0 : BRF73a.getR124_os_non_resident().intValue());
					            }
					            Row r125row = sheet.getRow(132);
					            Cell r125cell = r125row.getCell(3);
					            if (r125cell != null) {
					            	r125cell.setCellValue(
					            			BRF73a.getR125_no_ac_resident() == null ? 0 : BRF73a.getR125_no_ac_resident().intValue());
					            }
								 Cell r125cell1 = r125row.getCell(4);
					            if (r125cell1 != null) {
					            	r125cell1.setCellValue(
					            			BRF73a.getR125_os_resident() == null ? 0 : BRF73a.getR125_os_resident().intValue());
					            }
								 Cell r125cell2 = r125row.getCell(5);
					            if (r125cell2 != null) {
					            	r125cell2.setCellValue(
					            			BRF73a.getR125_no_ac_non_resident() == null ? 0 : BRF73a.getR125_no_ac_non_resident().intValue());
					            }
								 Cell r125cell3 = r125row.getCell(6);
					            if (r125cell3 != null) {
					            	r125cell3.setCellValue(
					            			BRF73a.getR125_os_non_resident() == null ? 0 : BRF73a.getR125_os_non_resident().intValue());
					            }
					            Row r126row = sheet.getRow(133);
					            Cell r126cell = r126row.getCell(3);
					            if (r126cell != null) {
					            	r126cell.setCellValue(
					            			BRF73a.getR126_no_ac_resident() == null ? 0 : BRF73a.getR126_no_ac_resident().intValue());
					            }
								 Cell r126cell1 = r126row.getCell(4);
					            if (r126cell1 != null) {
					            	r126cell1.setCellValue(
					            			BRF73a.getR126_os_resident() == null ? 0 : BRF73a.getR126_os_resident().intValue());
					            }
								 Cell r126cell2 = r126row.getCell(5);
					            if (r126cell2 != null) {
					            	r126cell2.setCellValue(
					            			BRF73a.getR126_no_ac_non_resident() == null ? 0 : BRF73a.getR126_no_ac_non_resident().intValue());
					            }
								 Cell r126cell3 = r126row.getCell(6);
					            if (r126cell3 != null) {
					            	r126cell3.setCellValue(
					            			BRF73a.getR126_os_non_resident() == null ? 0 : BRF73a.getR126_os_non_resident().intValue());
					            }
					            Row r127row = sheet.getRow(134);
					            Cell r127cell = r127row.getCell(3);
					            if (r127cell != null) {
					            	r127cell.setCellValue(
					            			BRF73a.getR127_no_ac_resident() == null ? 0 : BRF73a.getR127_no_ac_resident().intValue());
					            }
								 Cell r127cell1 = r127row.getCell(4);
					            if (r127cell1 != null) {
					            	r127cell1.setCellValue(
					            			BRF73a.getR127_os_resident() == null ? 0 : BRF73a.getR127_os_resident().intValue());
					            }
								 Cell r127cell2 = r127row.getCell(5);
					            if (r127cell2 != null) {
					            	r127cell2.setCellValue(
					            			BRF73a.getR127_no_ac_non_resident() == null ? 0 : BRF73a.getR127_no_ac_non_resident().intValue());
					            }
								 Cell r127cell3 = r127row.getCell(6);
					            if (r127cell3 != null) {
					            	r127cell3.setCellValue(
					            			BRF73a.getR127_os_non_resident() == null ? 0 : BRF73a.getR127_os_non_resident().intValue());
					            }
					            Row r128row = sheet.getRow(135);
					            Cell r128cell = r128row.getCell(3);
					            if (r128cell != null) {
					            	r128cell.setCellValue(
					            			BRF73a.getR128_no_ac_resident() == null ? 0 : BRF73a.getR128_no_ac_resident().intValue());
					            }
								 Cell r128cell1 = r128row.getCell(4);
					            if (r128cell1 != null) {
					            	r128cell1.setCellValue(
					            			BRF73a.getR128_os_resident() == null ? 0 : BRF73a.getR128_os_resident().intValue());
					            }
								 Cell r128cell2 = r128row.getCell(5);
					            if (r128cell2 != null) {
					            	r128cell2.setCellValue(
					            			BRF73a.getR128_no_ac_non_resident() == null ? 0 : BRF73a.getR128_no_ac_non_resident().intValue());
					            }
								 Cell r128cell3 = r128row.getCell(6);
					            if (r128cell3 != null) {
					            	r128cell3.setCellValue(
					            			BRF73a.getR128_os_non_resident() == null ? 0 : BRF73a.getR128_os_non_resident().intValue());
					            }
					            Row r129row = sheet.getRow(136);
					            Cell r129cell = r129row.getCell(3);
					            if (r129cell != null) {
					            	r129cell.setCellValue(
					            			BRF73a.getR129_no_ac_resident() == null ? 0 : BRF73a.getR129_no_ac_resident().intValue());
					            }
								 Cell r129cell1 = r129row.getCell(4);
					            if (r129cell1 != null) {
					            	r129cell1.setCellValue(
					            			BRF73a.getR129_os_resident() == null ? 0 : BRF73a.getR129_os_resident().intValue());
					            }
								 Cell r129cell2 = r129row.getCell(5);
					            if (r129cell2 != null) {
					            	r129cell2.setCellValue(
					            			BRF73a.getR129_no_ac_non_resident() == null ? 0 : BRF73a.getR129_no_ac_non_resident().intValue());
					            }
								 Cell r129cell3 = r129row.getCell(6);
					            if (r129cell3 != null) {
					            	r129cell3.setCellValue(
					            			BRF73a.getR129_os_non_resident() == null ? 0 : BRF73a.getR129_os_non_resident().intValue());
					            }
					            Row r130row = sheet.getRow(137);
					            Cell r130cell = r130row.getCell(3);
					            if (r130cell != null) {
					            	r130cell.setCellValue(
					            			BRF73a.getR130_no_ac_resident() == null ? 0 : BRF73a.getR130_no_ac_resident().intValue());
					            }
								 Cell r130cell1 = r130row.getCell(4);
					            if (r130cell1 != null) {
					            	r130cell1.setCellValue(
					            			BRF73a.getR130_os_resident() == null ? 0 : BRF73a.getR130_os_resident().intValue());
					            }
								 Cell r130cell2 = r130row.getCell(5);
					            if (r130cell2 != null) {
					            	r130cell2.setCellValue(
					            			BRF73a.getR130_no_ac_non_resident() == null ? 0 : BRF73a.getR130_no_ac_non_resident().intValue());
					            }
								 Cell r130cell3 = r130row.getCell(6);
					            if (r130cell3 != null) {
					            	r130cell3.setCellValue(
					            			BRF73a.getR130_os_non_resident() == null ? 0 : BRF73a.getR130_os_non_resident().intValue());
					            }
					            Row r132row = sheet.getRow(139);
					            Cell r132cell = r132row.getCell(3);
					            if (r132cell != null) {
					            	r132cell.setCellValue(
					            			BRF73a.getR132_no_ac_resident() == null ? 0 : BRF73a.getR132_no_ac_resident().intValue());
					            }
								 Cell r132cell1 = r132row.getCell(4);
					            if (r132cell1 != null) {
					            	r132cell1.setCellValue(
					            			BRF73a.getR132_os_resident() == null ? 0 : BRF73a.getR132_os_resident().intValue());
					            }
								 Cell r132cell2 = r132row.getCell(5);
					            if (r132cell2 != null) {
					            	r132cell2.setCellValue(
					            			BRF73a.getR132_no_ac_non_resident() == null ? 0 : BRF73a.getR132_no_ac_non_resident().intValue());
					            }
								 Cell r132cell3 = r132row.getCell(6);
					            if (r132cell3 != null) {
					            	r132cell3.setCellValue(
					            			BRF73a.getR132_os_non_resident() == null ? 0 : BRF73a.getR132_os_non_resident().intValue());
					            }
					            Row r133row = sheet.getRow(140);
					            Cell r133cell = r133row.getCell(3);
					            if (r133cell != null) {
					            	r133cell.setCellValue(
					            			BRF73a.getR133_no_ac_resident() == null ? 0 : BRF73a.getR133_no_ac_resident().intValue());
					            }
								 Cell r133cell1 = r133row.getCell(4);
					            if (r133cell1 != null) {
					            	r133cell1.setCellValue(
					            			BRF73a.getR133_os_resident() == null ? 0 : BRF73a.getR133_os_resident().intValue());
					            }
								 Cell r133cell2 = r133row.getCell(5);
					            if (r133cell2 != null) {
					            	r133cell2.setCellValue(
					            			BRF73a.getR133_no_ac_non_resident() == null ? 0 : BRF73a.getR133_no_ac_non_resident().intValue());
					            }
								 Cell r133cell3 = r133row.getCell(6);
					            if (r133cell3 != null) {
					            	r133cell3.setCellValue(
					            			BRF73a.getR133_os_non_resident() == null ? 0 : BRF73a.getR133_os_non_resident().intValue());
					            }
					            Row r134row = sheet.getRow(141);
					            Cell r134cell = r134row.getCell(3);
					            if (r134cell != null) {
					            	r134cell.setCellValue(
					            			BRF73a.getR134_no_ac_resident() == null ? 0 : BRF73a.getR134_no_ac_resident().intValue());
					            }
								 Cell r134cell1 = r134row.getCell(4);
					            if (r134cell1 != null) {
					            	r134cell1.setCellValue(
					            			BRF73a.getR134_os_resident() == null ? 0 : BRF73a.getR134_os_resident().intValue());
					            }
								 Cell r134cell2 = r134row.getCell(5);
					            if (r134cell2 != null) {
					            	r134cell2.setCellValue(
					            			BRF73a.getR134_no_ac_non_resident() == null ? 0 : BRF73a.getR134_no_ac_non_resident().intValue());
					            }
								 Cell r134cell3 = r134row.getCell(6);
					            if (r134cell3 != null) {
					            	r134cell3.setCellValue(
					            			BRF73a.getR134_os_non_resident() == null ? 0 : BRF73a.getR134_os_non_resident().intValue());
					            }
					            Row r136row = sheet.getRow(143);
					            Cell r136cell = r136row.getCell(3);
					            if (r136cell != null) {
					            	r136cell.setCellValue(
					            			BRF73a.getR136_no_ac_resident() == null ? 0 : BRF73a.getR136_no_ac_resident().intValue());
					            }
								 Cell r136cell1 = r136row.getCell(4);
					            if (r136cell1 != null) {
					            	r136cell1.setCellValue(
					            			BRF73a.getR136_os_resident() == null ? 0 : BRF73a.getR136_os_resident().intValue());
					            }
								 Cell r136cell2 = r136row.getCell(5);
					            if (r136cell2 != null) {
					            	r136cell2.setCellValue(
					            			BRF73a.getR136_no_ac_non_resident() == null ? 0 : BRF73a.getR136_no_ac_non_resident().intValue());
					            }
								 Cell r136cell3 = r136row.getCell(6);
					            if (r136cell3 != null) {
					            	r136cell3.setCellValue(
					            			BRF73a.getR136_os_non_resident() == null ? 0 : BRF73a.getR136_os_non_resident().intValue());
					            }
					            Row r137row = sheet.getRow(144);
					            Cell r137cell = r137row.getCell(3);
					            if (r137cell != null) {
					            	r137cell.setCellValue(
					            			BRF73a.getR137_no_ac_resident() == null ? 0 : BRF73a.getR137_no_ac_resident().intValue());
					            }
								 Cell r137cell1 = r137row.getCell(4);
					            if (r137cell1 != null) {
					            	r137cell1.setCellValue(
					            			BRF73a.getR137_os_resident() == null ? 0 : BRF73a.getR137_os_resident().intValue());
					            }
								 Cell r137cell2 = r137row.getCell(5);
					            if (r137cell2 != null) {
					            	r137cell2.setCellValue(
					            			BRF73a.getR137_no_ac_non_resident() == null ? 0 : BRF73a.getR137_no_ac_non_resident().intValue());
					            }
								 Cell r137cell3 = r137row.getCell(6);
					            if (r137cell3 != null) {
					            	r137cell3.setCellValue(
					            			BRF73a.getR137_os_non_resident() == null ? 0 : BRF73a.getR137_os_non_resident().intValue());
					            }
					            Row r138row = sheet.getRow(145);
					            Cell r138cell = r138row.getCell(3);
					            if (r138cell != null) {
					            	r138cell.setCellValue(
					            			BRF73a.getR138_no_ac_resident() == null ? 0 : BRF73a.getR138_no_ac_resident().intValue());
					            }
								 Cell r138cell1 = r138row.getCell(4);
					            if (r138cell1 != null) {
					            	r138cell1.setCellValue(
					            			BRF73a.getR138_os_resident() == null ? 0 : BRF73a.getR138_os_resident().intValue());
					            }
								 Cell r138cell2 = r138row.getCell(5);
					            if (r138cell2 != null) {
					            	r138cell2.setCellValue(
					            			BRF73a.getR138_no_ac_non_resident() == null ? 0 : BRF73a.getR138_no_ac_non_resident().intValue());
					            }
								 Cell r138cell3 = r138row.getCell(6);
					            if (r138cell3 != null) {
					            	r138cell3.setCellValue(
					            			BRF73a.getR138_os_non_resident() == null ? 0 : BRF73a.getR138_os_non_resident().intValue());
					            }
					            Row r140row = sheet.getRow(147);
					            Cell r140cell = r140row.getCell(3);
					            if (r140cell != null) {
					            	r140cell.setCellValue(
					            			BRF73a.getR140_no_ac_resident() == null ? 0 : BRF73a.getR140_no_ac_resident().intValue());
					            }
								 Cell r140cell1 = r140row.getCell(4);
					            if (r140cell1 != null) {
					            	r140cell1.setCellValue(
					            			BRF73a.getR140_os_resident() == null ? 0 : BRF73a.getR140_os_resident().intValue());
					            }
								 Cell r140cell2 = r140row.getCell(5);
					            if (r140cell2 != null) {
					            	r140cell2.setCellValue(
					            			BRF73a.getR140_no_ac_non_resident() == null ? 0 : BRF73a.getR140_no_ac_non_resident().intValue());
					            }
								 Cell r140cell3 = r140row.getCell(6);
					            if (r140cell3 != null) {
					            	r140cell3.setCellValue(
					            			BRF73a.getR140_os_non_resident() == null ? 0 : BRF73a.getR140_os_non_resident().intValue());
					            }
					            Row r141row = sheet.getRow(148);
					            Cell r141cell = r141row.getCell(3);
					            if (r141cell != null) {
					            	r141cell.setCellValue(
					            			BRF73a.getR141_no_ac_resident() == null ? 0 : BRF73a.getR141_no_ac_resident().intValue());
					            }
								 Cell r141cell1 = r141row.getCell(4);
					            if (r141cell1 != null) {
					            	r141cell1.setCellValue(
					            			BRF73a.getR141_os_resident() == null ? 0 : BRF73a.getR141_os_resident().intValue());
					            }
								 Cell r141cell2 = r141row.getCell(5);
					            if (r141cell2 != null) {
					            	r141cell2.setCellValue(
					            			BRF73a.getR141_no_ac_non_resident() == null ? 0 : BRF73a.getR141_no_ac_non_resident().intValue());
					            }
								 Cell r141cell3 = r141row.getCell(6);
					            if (r141cell3 != null) {
					            	r141cell3.setCellValue(
					            			BRF73a.getR141_os_non_resident() == null ? 0 : BRF73a.getR141_os_non_resident().intValue());
					            }
					            Row r142row = sheet.getRow(149);
					            Cell r142cell = r142row.getCell(3);
					            if (r142cell != null) {
					            	r142cell.setCellValue(
					            			BRF73a.getR142_no_ac_resident() == null ? 0 : BRF73a.getR142_no_ac_resident().intValue());
					            }
								 Cell r142cell1 = r142row.getCell(4);
					            if (r142cell1 != null) {
					            	r142cell1.setCellValue(
					            			BRF73a.getR142_os_resident() == null ? 0 : BRF73a.getR142_os_resident().intValue());
					            }
								 Cell r142cell2 = r142row.getCell(5);
					            if (r142cell2 != null) {
					            	r142cell2.setCellValue(
					            			BRF73a.getR142_no_ac_non_resident() == null ? 0 : BRF73a.getR142_no_ac_non_resident().intValue());
					            }
								 Cell r142cell3 = r142row.getCell(6);
					            if (r142cell3 != null) {
					            	r142cell3.setCellValue(
					            			BRF73a.getR142_os_non_resident() == null ? 0 : BRF73a.getR142_os_non_resident().intValue());
					            }
						}
					}

			 // Save the changes
        	workbook.getCreationHelper().createFormulaEvaluator().evaluateAll();
        	            FileOutputStream fileOut = new FileOutputStream(env.getProperty("output.exportpathfinal")+"011-BRF-073-A.xls");
        	            workbook.write(fileOut);
        	            fileOut.close();
        	            System.out.println(fileOut);
        	            path= fileOut.toString();
        	            // Close the workbook
        	            System.out.println("PATH : "+path);
        	            workbook.close();
        					
        				
        				}
        				
        				catch (ParseException e) {
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
        		outputFile = new File(env.getProperty("output.exportpathfinal")+"011-BRF-073-A.xls");

        		return outputFile;



        	}

				
	public String detailChanges73(BRF73_DETAIL_ENTITY detail, String foracid, String report_addl_criteria_1,
			BigDecimal act_balance_amt_lc, String report_label_1, String report_name_1) {

		String msg = "";

		try {

			Session hs = sessionFactory.getCurrentSession();
			Optional<BRF73_DETAIL_ENTITY> Brf73detail =brf73_detailrepo.findById(foracid);

			if (Brf73detail.isPresent()) {
				BRF73_DETAIL_ENTITY BRFdetail = Brf73detail.get();

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
					brf73_detailrepo.save(BRFdetail);

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
	
		
/**** ARCH DETAILS 
 * @throws ParseException ****/

public ModelAndView ARCHgetBRF073currentDtl(String reportId, String fromdate, String todate, String currency,
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

			qr = hs.createNativeQuery("select * from BRF73_ARCHIVTABLE a where report_date=?1 and report_label_1=?2");
			qr.setParameter(1, df.parse(todate));
			qr.setParameter(2, filter);

		} else {
			System.out.println("2");
			qr = hs.createNativeQuery("select * from BRF73_ARCHIVTABLE");

		}
	} else {
		System.out.println("3");
		qr = hs.createNativeQuery("select * from BRF73_ARCHIVTABLE  where report_date = ?1");
	}

	/*
	 * try { qr.setParameter(1, df.parse(todate));
	 * 
	 * } catch (ParseException e) { e.printStackTrace(); }
	 */
	List<BRF73_ARCHIVENTITY> T1Master = new ArrayList<BRF73_ARCHIVENTITY>();

	try {
		System.out.println("Values entered");
		T1Master = hs.createQuery("from BRF73_ARCHIVENTITY a where a.report_date = ?1", BRF73_ARCHIVENTITY.class)
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

		BRF73_ARCHIVENTITY py = new BRF73_ARCHIVENTITY(cust_id, foracid, act_balance_amt_lc, eab_lc, acct_name, acct_crncy_code, gl_code, gl_sub_head_code,
			    gl_sub_head_desc, country_of_incorp, cust_type, schm_code, schm_type, sol_id, acid, segment, sub_segment,
			    sector, sub_sector, sector_code, group_id, constitution_code, country, legal_entity_type, constitution_desc,
			    purpose_of_advn, hni_networth, turnover, bacid, report_name_1, report_label_1, report_addl_criteria_1,
			    report_addl_criteria_2, report_addl_criteria_3, create_user, create_time, modify_user, modify_time,
			    verify_user, verify_time, entity_flg, modify_flg, del_flg, nre_status, report_date, maturity_date,gender,
			    version, remarks);
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

	mv.setViewName("RR" + "/" + "BRF073ARCH::reportcontent");
	mv.addObject("reportdetails", T1Dt1Page.getContent());
	mv.addObject("reportmaster", T1Master);
	mv.addObject("reportmaster1", qr);
	mv.addObject("singledetail", new T1CurProdDetail());
	mv.addObject("reportsflag", "reportsflag");
	mv.addObject("menu", reportId);
	return mv;
}


public ModelAndView getArchieveBRF073View(String reportId, String fromdate, String todate, String currency,
		String dtltype, Pageable pageable) {

	ModelAndView mv = new ModelAndView();
	Session hs = sessionFactory.getCurrentSession();
	int pageSize = pageable.getPageSize();
	int currentPage = pageable.getPageNumber();
	int startItem = currentPage * pageSize;
	List<BRF73A_ENTITY> T1rep = new ArrayList<BRF73A_ENTITY>();
	

	List<BRF73A_ENTITY> T1Master = new ArrayList<BRF73A_ENTITY>();
	List<BRF73B_ENTITY> T1Master1 = new ArrayList<BRF73B_ENTITY>();

	logger.info("Inside archive" +currency);

	try {
		Date d1 = df.parse(todate);
	

		T1Master = hs.createQuery("from BRF73A_ENTITY a where a.report_date = ?1 ", BRF73A_ENTITY.class)
				.setParameter(1, df.parse(todate)).getResultList();

		T1Master1 = hs.createQuery("from BRF73B_ENTITY a where a.report_date = ?1 ", BRF73B_ENTITY.class)
				.setParameter(1, df.parse(todate)).getResultList();

	} catch (ParseException e) {
		e.printStackTrace();
	}

	mv.setViewName("RR/BRF073ARCH");
	mv.addObject("reportsummary", T1Master);
	mv.addObject("reportsummary1", T1Master1);
	mv.addObject("reportmaster", T1Master);
	mv.addObject("displaymode", "summary");
	mv.addObject("reportsflag", "reportsflag");
	mv.addObject("menu", reportId);
	System.out.println("scv" + mv.getViewName());

	return mv;


}
	


}
	
	


