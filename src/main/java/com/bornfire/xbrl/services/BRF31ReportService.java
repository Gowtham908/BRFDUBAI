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

import com.bornfire.xbrl.entities.BRBS.BRF31_DETAIL_ENTITY;
import com.bornfire.xbrl.entities.BRBS.BRF31_Entity;
import com.bornfire.xbrl.entities.BRBS.BRF31_ARCHIVENTITY;
import com.bornfire.xbrl.entities.BRBS.BRF31_DetailRep;
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
public class BRF31ReportService {

	private static final Logger logger = LoggerFactory.getLogger(BRF31ReportService.class);

	@Autowired
	SessionFactory sessionFactory;

	@Autowired
	DataSource srcdataSource;

	@Autowired
	BRF31_DetailRep brf31_DetailRep;

	@Autowired
	Environment env;
	DateFormat df = new SimpleDateFormat("dd-MMM-yyyy");

	public String preCheck(String reportid, String fromdate, String todate) {

		String msg = "";
		Session hs = sessionFactory.getCurrentSession();
		Date dt1;
		Date dt9;
		logger.info("Report precheck : " + reportid);

		try {
			// dt1 = new SimpleDateFormat("dd/MM/yyyy").parse(fromdate);
			dt9 = new SimpleDateFormat("dd/MM/yyyy").parse(todate);
			logger.info("Getting No of records in Master table :" + reportid);
			Long dtlcnt = (Long) hs.createQuery("select count(*) from  BRF31_Entity a where a.report_date=?1")
					.setParameter(1, dt9).getSingleResult();

			if (dtlcnt > 0) {
				logger.info("Getting No of records in Mod table :" + reportid);
				Long modcnt = (Long) hs.createQuery("select count(*) from  BRF31_Entity a").getSingleResult();
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

	public ModelAndView getBRF031View(String reportId, String fromdate, String todate, String currency, String dtltype,
			Pageable pageable) {

		ModelAndView mv = new ModelAndView();
		Session hs = sessionFactory.getCurrentSession();
		int pageSize = pageable.getPageSize();
		int currentPage = pageable.getPageNumber();
		int startItem = currentPage * pageSize;
		/* List<BRF036_ENTITY> T1rep = new ArrayList<BRF036_ENTITY>(); */
		// Query<Object[]> qr;

		List<BRF31_Entity> T1Master = new ArrayList<BRF31_Entity>();
		List<BRF31_Entity> T1Master1 = new ArrayList<BRF31_Entity>();

		logger.info("Inside archive" + currency);

		try {
			Date d1 = df.parse(todate);
			// T1rep = t1CurProdServiceRepo.getT1CurProdServices(d1);

			T1Master = hs.createQuery("from  BRF31_Entity a where a.report_date = ?1 ", BRF31_Entity.class)
					.setParameter(1, df.parse(todate)).getResultList();

			/*
			 * T1Master1 = hs.createQuery("from BRF47_Entity a where a.report_date = ?1 ",
			 * BRF40_Entity2.class) .setParameter(1, df.parse(todate)).getResultList();
			 */

		} catch (ParseException e) {
			e.printStackTrace();
		}

		// T1rep = t1CurProdServiceRepo.getT1CurProdServices(d1);

		mv.setViewName("RR/BRF31");
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

	public ModelAndView getBRF031currentDtl(String reportId, String fromdate, String todate, String currency,
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
						"select * from BRF31_DETAILTABLE  a where report_date = ?1 and report_label_1 =?2");

				qr.setParameter(2, filter);

			} else {
				qr = hs.createNativeQuery("select * from BRF31_DETAILTABLE a where report_date = ?1");

			}
		} else {
			qr = hs.createNativeQuery("select * from BRF31_DETAILTABLE  where report_date = ?1");
		}

		try {
			qr.setParameter(1, df.parse(todate));

		} catch (ParseException e) {
			e.printStackTrace();
		}
		List<BRF31_DETAIL_ENTITY> T1Master = new ArrayList<BRF31_DETAIL_ENTITY>();

		try {
			T1Master = hs.createQuery("from BRF31_DETAIL_ENTITY a where a.report_date = ?1", BRF31_DETAIL_ENTITY.class)
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
			Character nreflag = (Character) a[49];

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

			BRF31_DETAIL_ENTITY py = new BRF31_DETAIL_ENTITY(cust_id, foracid, act_balance_amt_lc, eab_lc, acct_name,
					acct_crncy_code, gl_code, gl_sub_head_code, gl_sub_head_desc, country_of_incorp, cust_type,
					schm_code, schm_type, sol_id, acid, segment, sub_segment, sector, sub_sector, sector_code, group_id,
					constitution_code, country, legal_entity_type, constitution_desc, purpose_of_advn, hni_networth,
					turnover, bacid, report_name_1, report_label_1, report_addl_criteria_1, report_addl_criteria_2,
					report_addl_criteria_3, create_user, create_time, modify_user, modify_time, verify_user,
					verify_time, entity_flg, modify_flg, del_flg, nre_status, report_date, maturity_date, gender,
					version, remarks, nreflag);
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

		mv.setViewName("RR" + "/" + "BRF31::reportcontent");
		mv.addObject("reportdetails", T1Dt1Page.getContent());
		mv.addObject("reportmaster", T1Master);
		mv.addObject("reportmaster12", T1Dt1);
		mv.addObject("reportmaster1", qr);
		mv.addObject("singledetail", new T1CurProdDetail());
		mv.addObject("reportsflag", "reportsflag");
		mv.addObject("menu", reportId);
		return mv;
	}

	public File getFileBRF031(String reportId, String fromdate, String todate, String currency, String dtltype,
			String filetype) throws FileNotFoundException, JRException, SQLException {

		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

		String path = this.env.getProperty("output.exportpath");
		String fileName = "";
		String zipFileName = "";
		File outputFile;

		logger.info("Getting Output file :" + reportId);
		fileName = "011-BRF-031-A ";
		/*
		 * try { SimpleDateFormat dateFormat1 = new SimpleDateFormat("dd-MM-yyyy"); Date
		 * ConDate = dateFormat1.parse(todate); System.out.println(ConDate);
		 * SimpleDateFormat formatter1 = new SimpleDateFormat("dd-MM-yyyy"); String
		 * strDate1 = formatter1.format(ConDate); fileName = "t" + reportId + "_" +
		 * strDate1;
		 * 
		 * 
		 * } catch (ParseException e1) {
		 * 
		 * logger.info(e1.getMessage()); e1.printStackTrace(); }
		 */

		if (!filetype.equals("xbrl")) {
			if (!filetype.equals("BRF")) {
				try {
					InputStream jasperFile;
					logger.info("Getting Jasper file :" + reportId);
					if (filetype.equals("detailexcel")) {
						if (dtltype.equals("report")) {

							jasperFile = this.getClass().getResourceAsStream("/static/jasper/BRF31_Detail.jrxml");
						} else {
							jasperFile = this.getClass().getResourceAsStream("/static/jasper/BRF31_Detail.jrxml");
						}

					} else {
						if (dtltype.equals("report")) {
							logger.info("Inside report");
							jasperFile = this.getClass().getResourceAsStream("/static/jasper/BRF31.jrxml");
						} else {
							jasperFile = this.getClass().getResourceAsStream("/static/jasper/BRF31.jrxml");
						}
					}

					/* JasperReport jr = (JasperReport) JRLoader.loadObject(jasperFile); */
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
			} else {

				List<BRF31_Entity> T1Master = new ArrayList<BRF31_Entity>();
				Session hs = sessionFactory.getCurrentSession();
				try {
					Date d1 = df.parse(todate);

					// T1rep = t1CurProdServiceRepo.getT1CurProdServices(d1);

					T1Master = hs.createQuery("from  BRF31_Entity a where a.report_date = ?1 ", BRF31_Entity.class)
							.setParameter(1, df.parse(todate)).getResultList();

					if (T1Master.size() == 1) {

						for (BRF31_Entity BRF31 : T1Master) {

							File Responsecamt = new File(
									env.getProperty("output.exportpathtemp") + "011-BRF-031-AT.xls");

							// Load the Excel file
							Workbook workbook = WorkbookFactory.create(Responsecamt);

							// Get the first sheet
							Sheet sheet = workbook.getSheetAt(0);

							/*
							 * Row r1row = sheet.getRow(4); if (r1row != null) { Cell r1cell =
							 * r1row.getCell(2); if (r1cell == null) { r1cell = r1row.createCell(2); //
							 * Create the cell if it doesn't exist } if (BRF31.getReport_date() != null) {
							 * // Formatting the date to dd-MM-yyyy SimpleDateFormat sdf = new
							 * SimpleDateFormat("dd-MM-yyyy"); String formattedDate =
							 * sdf.format(BRF31.getReport_date()); r1cell.setCellValue(formattedDate); //
							 * Set the formatted date in the cell } else { r1cell.setCellValue(""); // Set
							 * an empty value if the report_date is null } }
							 */

							Row row = sheet.getRow(10);
							Cell cell = row.getCell(3);
							if (cell != null) {
								cell.setCellValue(BRF31.getR11_nos_aed_resident() == null ? 0
										: BRF31.getR11_nos_aed_resident().intValue());
							}
							Cell cell1 = row.getCell(4);
							if (cell1 != null) {
								cell1.setCellValue(BRF31.getR11_amount_aed_resident() == null ? 0
										: BRF31.getR11_amount_aed_resident().intValue());
							}

							Cell cell2 = row.getCell(5);
							if (cell2 != null) {
								cell2.setCellValue(BRF31.getR11_nos_ccy_resident() == null ? 0
										: BRF31.getR11_nos_ccy_resident().intValue());
							}

							Cell cell3 = row.getCell(6);
							if (cell3 != null) {
								cell3.setCellValue(BRF31.getR11_amount_ccy_resident() == null ? 0
										: BRF31.getR11_amount_ccy_resident().intValue());
							}

							Cell cell4 = row.getCell(7);
							if (cell4 != null) {
								cell4.setCellValue(BRF31.getR11_nos_aed_non_resident() == null ? 0
										: BRF31.getR11_nos_aed_non_resident().intValue());
							}

							Cell cell5 = row.getCell(8);
							if (cell5 != null) {
								cell5.setCellValue(BRF31.getR11_amount_aed_non_resident() == null ? 0
										: BRF31.getR11_amount_aed_non_resident().intValue());
							}

							Cell cell6 = row.getCell(9);
							if (cell6 != null) {
								cell6.setCellValue(BRF31.getR11_nos_ccy_non_resident() == null ? 0
										: BRF31.getR11_nos_ccy_non_resident().intValue());
							}

							Cell cell7 = row.getCell(10);
							if (cell7 != null) {
								cell7.setCellValue(BRF31.getR11_amount_ccy_non_resident() == null ? 0
										: BRF31.getR11_amount_ccy_non_resident().intValue());
							}

							/////////////////////// R12/////////////////////////////

							Row row1 = sheet.getRow(11);
							Cell R1cell = row1.getCell(3);
							if (R1cell != null) {
								R1cell.setCellValue(BRF31.getR12_nos_aed_resident() == null ? 0
										: BRF31.getR12_nos_aed_resident().intValue());
							}
							Cell R1cell1 = row1.getCell(4);
							if (R1cell1 != null) {
								R1cell1.setCellValue(BRF31.getR12_amount_aed_resident() == null ? 0
										: BRF31.getR12_amount_aed_resident().intValue());
							}

							Cell R1cell2 = row1.getCell(5);
							if (R1cell2 != null) {
								R1cell2.setCellValue(BRF31.getR12_nos_ccy_resident() == null ? 0
										: BRF31.getR12_nos_ccy_resident().intValue());
							}

							Cell R1cell3 = row1.getCell(6);
							if (R1cell3 != null) {
								R1cell3.setCellValue(BRF31.getR12_amount_ccy_resident() == null ? 0
										: BRF31.getR12_amount_ccy_resident().intValue());
							}

							Cell R1cell4 = row1.getCell(7);
							if (R1cell4 != null) {
								R1cell4.setCellValue(BRF31.getR12_nos_aed_non_resident() == null ? 0
										: BRF31.getR12_nos_aed_non_resident().intValue());
							}

							Cell R1cell5 = row1.getCell(8);
							if (R1cell5 != null) {
								R1cell5.setCellValue(BRF31.getR12_amount_aed_non_resident() == null ? 0
										: BRF31.getR12_amount_aed_non_resident().intValue());
							}

							Cell R1cell6 = row1.getCell(9);
							if (R1cell6 != null) {
								R1cell6.setCellValue(BRF31.getR12_nos_ccy_non_resident() == null ? 0
										: BRF31.getR12_nos_ccy_non_resident().intValue());
							}

							Cell R1cell7 = row1.getCell(10);
							if (R1cell7 != null) {
								R1cell7.setCellValue(BRF31.getR12_amount_ccy_non_resident() == null ? 0
										: BRF31.getR12_amount_ccy_non_resident().intValue());
							}

							/////////////////////// R13/////////////////////////////

							Row row2 = sheet.getRow(12);
							Cell R2cell = row2.getCell(3);
							if (R2cell != null) {
								R2cell.setCellValue(BRF31.getR13_nos_aed_resident() == null ? 0
										: BRF31.getR13_nos_aed_resident().intValue());
							}
							Cell R2cell1 = row2.getCell(4);
							if (R2cell1 != null) {
								R2cell1.setCellValue(BRF31.getR13_amount_aed_resident() == null ? 0
										: BRF31.getR13_amount_aed_resident().intValue());
							}

							Cell R2cell2 = row2.getCell(5);
							if (R2cell2 != null) {
								R2cell2.setCellValue(BRF31.getR13_nos_ccy_resident() == null ? 0
										: BRF31.getR13_nos_ccy_resident().intValue());
							}

							Cell R2cell3 = row2.getCell(6);
							if (R2cell3 != null) {
								R2cell3.setCellValue(BRF31.getR13_amount_ccy_resident() == null ? 0
										: BRF31.getR13_amount_ccy_resident().intValue());
							}

							Cell R2cell4 = row2.getCell(7);
							if (R2cell4 != null) {
								R2cell4.setCellValue(BRF31.getR13_nos_aed_non_resident() == null ? 0
										: BRF31.getR13_nos_aed_non_resident().intValue());
							}

							Cell R2cell5 = row2.getCell(8);
							if (R2cell5 != null) {
								R2cell5.setCellValue(BRF31.getR13_amount_aed_non_resident() == null ? 0
										: BRF31.getR13_amount_aed_non_resident().intValue());
							}

							Cell R2cell6 = row2.getCell(9);
							if (R2cell6 != null) {
								R2cell6.setCellValue(BRF31.getR13_nos_ccy_non_resident() == null ? 0
										: BRF31.getR13_nos_ccy_non_resident().intValue());
							}

							Cell R2cell7 = row2.getCell(10);
							if (R2cell7 != null) {
								R2cell7.setCellValue(BRF31.getR13_amount_ccy_non_resident() == null ? 0
										: BRF31.getR13_amount_ccy_non_resident().intValue());
							}

							/////////////////////// R14/////////////////////////////

							Row row3 = sheet.getRow(13);
							Cell R3cell = row3.getCell(3);
							if (R3cell != null) {
								R3cell.setCellValue(BRF31.getR14_nos_aed_resident() == null ? 0
										: BRF31.getR14_nos_aed_resident().intValue());
							}
							Cell R3cell1 = row3.getCell(4);
							if (R3cell1 != null) {
								R3cell1.setCellValue(BRF31.getR14_amount_aed_resident() == null ? 0
										: BRF31.getR14_amount_aed_resident().intValue());
							}

							Cell R3cell2 = row3.getCell(5);
							if (R3cell2 != null) {
								R3cell2.setCellValue(BRF31.getR14_nos_ccy_resident() == null ? 0
										: BRF31.getR14_nos_ccy_resident().intValue());
							}

							Cell R3cell3 = row3.getCell(6);
							if (R3cell3 != null) {
								R3cell3.setCellValue(BRF31.getR14_amount_ccy_resident() == null ? 0
										: BRF31.getR14_amount_ccy_resident().intValue());
							}

							Cell R3cell4 = row3.getCell(7);
							if (R3cell4 != null) {
								R3cell4.setCellValue(BRF31.getR14_nos_aed_non_resident() == null ? 0
										: BRF31.getR14_nos_aed_non_resident().intValue());
							}

							Cell R3cell5 = row3.getCell(8);
							if (R3cell5 != null) {
								R3cell5.setCellValue(BRF31.getR14_amount_aed_non_resident() == null ? 0
										: BRF31.getR14_amount_aed_non_resident().intValue());
							}

							Cell R3cell6 = row3.getCell(9);
							if (R3cell6 != null) {
								R3cell6.setCellValue(BRF31.getR14_nos_ccy_non_resident() == null ? 0
										: BRF31.getR14_nos_ccy_non_resident().intValue());
							}

							Cell R3cell7 = row3.getCell(10);
							if (R3cell7 != null) {
								R3cell7.setCellValue(BRF31.getR14_amount_ccy_non_resident() == null ? 0
										: BRF31.getR14_amount_ccy_non_resident().intValue());
							}

							/////////////////////// R15/////////////////////////////

							Row row4 = sheet.getRow(14);
							Cell R4cell = row4.getCell(3);
							if (R4cell != null) {
								R4cell.setCellValue(BRF31.getR15_nos_aed_resident() == null ? 0
										: BRF31.getR15_nos_aed_resident().intValue());
							}
							Cell R4cell1 = row4.getCell(4);
							if (R4cell1 != null) {
								R4cell1.setCellValue(BRF31.getR15_amount_aed_resident() == null ? 0
										: BRF31.getR15_amount_aed_resident().intValue());
							}

							Cell R4cell2 = row4.getCell(5);
							if (R4cell2 != null) {
								R4cell2.setCellValue(BRF31.getR15_nos_ccy_resident() == null ? 0
										: BRF31.getR15_nos_ccy_resident().intValue());
							}

							Cell R4cell3 = row4.getCell(6);
							if (R4cell3 != null) {
								R4cell3.setCellValue(BRF31.getR15_amount_ccy_resident() == null ? 0
										: BRF31.getR15_amount_ccy_resident().intValue());
							}

							Cell R4cell4 = row4.getCell(7);
							if (R4cell4 != null) {
								R4cell4.setCellValue(BRF31.getR15_nos_aed_non_resident() == null ? 0
										: BRF31.getR15_nos_aed_non_resident().intValue());
							}

							Cell R4cell5 = row4.getCell(8);
							if (R4cell5 != null) {
								R4cell5.setCellValue(BRF31.getR15_amount_aed_non_resident() == null ? 0
										: BRF31.getR15_amount_aed_non_resident().intValue());
							}

							Cell R4cell6 = row4.getCell(9);
							if (R4cell6 != null) {
								R4cell6.setCellValue(BRF31.getR15_nos_ccy_non_resident() == null ? 0
										: BRF31.getR15_nos_ccy_non_resident().intValue());
							}

							Cell R4cell7 = row4.getCell(10);
							if (R4cell7 != null) {
								R4cell7.setCellValue(BRF31.getR15_amount_ccy_non_resident() == null ? 0
										: BRF31.getR15_amount_ccy_non_resident().intValue());
							}

							/////////////////////// R16/////////////////////////////

							Row row5 = sheet.getRow(15);
							Cell R5cell = row5.getCell(3);
							if (R5cell != null) {
								R5cell.setCellValue(BRF31.getR16_nos_aed_resident() == null ? 0
										: BRF31.getR16_nos_aed_resident().intValue());
							}
							Cell R5cell1 = row5.getCell(4);
							if (R5cell1 != null) {
								R5cell1.setCellValue(BRF31.getR16_amount_aed_resident() == null ? 0
										: BRF31.getR16_amount_aed_resident().intValue());
							}

							Cell R5cell2 = row5.getCell(5);
							if (R5cell2 != null) {
								R5cell2.setCellValue(BRF31.getR16_nos_ccy_resident() == null ? 0
										: BRF31.getR16_nos_ccy_resident().intValue());
							}

							Cell R5cell3 = row5.getCell(6);
							if (R5cell3 != null) {
								R5cell3.setCellValue(BRF31.getR16_amount_ccy_resident() == null ? 0
										: BRF31.getR16_amount_ccy_resident().intValue());
							}

							Cell R5cell4 = row5.getCell(7);
							if (R5cell4 != null) {
								R5cell4.setCellValue(BRF31.getR16_nos_aed_non_resident() == null ? 0
										: BRF31.getR16_nos_aed_non_resident().intValue());
							}

							Cell R5cell5 = row5.getCell(8);
							if (R5cell5 != null) {
								R5cell5.setCellValue(BRF31.getR16_amount_aed_non_resident() == null ? 0
										: BRF31.getR16_amount_aed_non_resident().intValue());
							}

							Cell R5cell6 = row5.getCell(9);
							if (R5cell6 != null) {
								R5cell6.setCellValue(BRF31.getR16_nos_ccy_non_resident() == null ? 0
										: BRF31.getR16_nos_ccy_non_resident().intValue());
							}

							Cell R5cell7 = row5.getCell(10);
							if (R5cell7 != null) {
								R5cell7.setCellValue(BRF31.getR16_amount_ccy_non_resident() == null ? 0
										: BRF31.getR16_amount_ccy_non_resident().intValue());
							}

							/////////////////////// R17/////////////////////////////

							Row row6 = sheet.getRow(16);
							Cell R6cell = row6.getCell(3);
							if (R6cell != null) {
								R6cell.setCellValue(BRF31.getR17_nos_aed_resident() == null ? 0
										: BRF31.getR17_nos_aed_resident().intValue());
							}
							Cell R6cell1 = row6.getCell(4);
							if (R6cell1 != null) {
								R6cell1.setCellValue(BRF31.getR17_amount_aed_resident() == null ? 0
										: BRF31.getR17_amount_aed_resident().intValue());
							}

							Cell R6cell2 = row6.getCell(5);
							if (R6cell2 != null) {
								R6cell2.setCellValue(BRF31.getR17_nos_ccy_resident() == null ? 0
										: BRF31.getR17_nos_ccy_resident().intValue());
							}

							Cell R6cell3 = row6.getCell(6);
							if (R6cell3 != null) {
								R6cell3.setCellValue(BRF31.getR17_amount_ccy_resident() == null ? 0
										: BRF31.getR17_amount_ccy_resident().intValue());
							}

							Cell R6cell4 = row6.getCell(7);
							if (R6cell4 != null) {
								R6cell4.setCellValue(BRF31.getR17_nos_aed_non_resident() == null ? 0
										: BRF31.getR17_nos_aed_non_resident().intValue());
							}

							Cell R6cell5 = row6.getCell(8);
							if (R6cell5 != null) {
								R6cell5.setCellValue(BRF31.getR17_amount_aed_non_resident() == null ? 0
										: BRF31.getR17_amount_aed_non_resident().intValue());
							}

							Cell R6cell6 = row6.getCell(9);
							if (R6cell6 != null) {
								R6cell6.setCellValue(BRF31.getR17_nos_ccy_non_resident() == null ? 0
										: BRF31.getR17_nos_ccy_non_resident().intValue());
							}

							Cell R6cell7 = row6.getCell(10);
							if (R6cell7 != null) {
								R6cell7.setCellValue(BRF31.getR17_amount_ccy_non_resident() == null ? 0
										: BRF31.getR17_amount_ccy_non_resident().intValue());
							}

							/////////////////////// R18/////////////////////////////

							Row row7 = sheet.getRow(17);
							Cell R7cell = row7.getCell(3);
							if (R7cell != null) {
								R7cell.setCellValue(BRF31.getR18_nos_aed_resident() == null ? 0
										: BRF31.getR18_nos_aed_resident().intValue());
							}
							Cell R7cell1 = row7.getCell(4);
							if (R7cell1 != null) {
								R7cell1.setCellValue(BRF31.getR18_amount_aed_resident() == null ? 0
										: BRF31.getR18_amount_aed_resident().intValue());
							}

							Cell R7cell2 = row7.getCell(5);
							if (R7cell2 != null) {
								R7cell2.setCellValue(BRF31.getR18_nos_ccy_resident() == null ? 0
										: BRF31.getR18_nos_ccy_resident().intValue());
							}

							Cell R7cell3 = row7.getCell(6);
							if (R7cell3 != null) {
								R7cell3.setCellValue(BRF31.getR18_amount_ccy_resident() == null ? 0
										: BRF31.getR18_amount_ccy_resident().intValue());
							}

							Cell R7cell4 = row7.getCell(7);
							if (R7cell4 != null) {
								R7cell4.setCellValue(BRF31.getR18_nos_aed_non_resident() == null ? 0
										: BRF31.getR18_nos_aed_non_resident().intValue());
							}

							Cell R7cell5 = row7.getCell(8);
							if (R7cell5 != null) {
								R7cell5.setCellValue(BRF31.getR18_amount_aed_non_resident() == null ? 0
										: BRF31.getR18_amount_aed_non_resident().intValue());
							}

							Cell R7cell6 = row7.getCell(9);
							if (R7cell6 != null) {
								R7cell6.setCellValue(BRF31.getR18_nos_ccy_non_resident() == null ? 0
										: BRF31.getR18_nos_ccy_non_resident().intValue());
							}

							Cell R7cell7 = row7.getCell(10);
							if (R7cell7 != null) {
								R7cell7.setCellValue(BRF31.getR18_amount_ccy_non_resident() == null ? 0
										: BRF31.getR18_amount_ccy_non_resident().intValue());
							}

							/////////////////////// R19/////////////////////////////

							Row row8 = sheet.getRow(18);
							Cell R8cell = row8.getCell(3);
							if (R8cell != null) {
								R8cell.setCellValue(BRF31.getR19_nos_aed_resident() == null ? 0
										: BRF31.getR19_nos_aed_resident().intValue());
							}
							Cell R8cell1 = row8.getCell(4);
							if (R8cell1 != null) {
								R8cell1.setCellValue(BRF31.getR19_amount_aed_resident() == null ? 0
										: BRF31.getR19_amount_aed_resident().intValue());
							}

							Cell R8cell2 = row8.getCell(5);
							if (R8cell2 != null) {
								R8cell2.setCellValue(BRF31.getR19_nos_ccy_resident() == null ? 0
										: BRF31.getR19_nos_ccy_resident().intValue());
							}

							Cell R8cell3 = row8.getCell(6);
							if (R8cell3 != null) {
								R8cell3.setCellValue(BRF31.getR19_amount_ccy_resident() == null ? 0
										: BRF31.getR19_amount_ccy_resident().intValue());
							}

							Cell R8cell4 = row8.getCell(7);
							if (R8cell4 != null) {
								R8cell4.setCellValue(BRF31.getR19_nos_aed_non_resident() == null ? 0
										: BRF31.getR19_nos_aed_non_resident().intValue());
							}

							Cell R8cell5 = row8.getCell(8);
							if (R8cell5 != null) {
								R8cell5.setCellValue(BRF31.getR19_amount_aed_non_resident() == null ? 0
										: BRF31.getR19_amount_aed_non_resident().intValue());
							}

							Cell R8cell6 = row8.getCell(9);
							if (R8cell6 != null) {
								R8cell6.setCellValue(BRF31.getR19_nos_ccy_non_resident() == null ? 0
										: BRF31.getR19_nos_ccy_non_resident().intValue());
							}

							Cell R8cell7 = row8.getCell(10);
							if (R8cell7 != null) {
								R8cell7.setCellValue(BRF31.getR19_amount_ccy_non_resident() == null ? 0
										: BRF31.getR19_amount_ccy_non_resident().intValue());
							}

							/////////////////////// R21/////////////////////////////

							Row row9 = sheet.getRow(20);
							Cell R9cell = row9.getCell(3);
							if (R9cell != null) {
								R9cell.setCellValue(BRF31.getR21_nos_aed_resident() == null ? 0
										: BRF31.getR21_nos_aed_resident().intValue());
							}
							Cell R9cell1 = row9.getCell(4);
							if (R9cell1 != null) {
								R9cell1.setCellValue(BRF31.getR21_amount_aed_resident() == null ? 0
										: BRF31.getR21_amount_aed_resident().intValue());
							}

							Cell R9cell2 = row9.getCell(5);
							if (R9cell2 != null) {
								R9cell2.setCellValue(BRF31.getR21_nos_ccy_resident() == null ? 0
										: BRF31.getR21_nos_ccy_resident().intValue());
							}

							Cell R9cell3 = row9.getCell(6);
							if (R9cell3 != null) {
								R9cell3.setCellValue(BRF31.getR21_amount_ccy_resident() == null ? 0
										: BRF31.getR21_amount_ccy_resident().intValue());
							}

							Cell R9cell4 = row9.getCell(7);
							if (R9cell4 != null) {
								R9cell4.setCellValue(BRF31.getR21_nos_aed_non_resident() == null ? 0
										: BRF31.getR21_nos_aed_non_resident().intValue());
							}

							Cell R9cell5 = row9.getCell(8);
							if (R9cell5 != null) {
								R9cell5.setCellValue(BRF31.getR21_amount_aed_non_resident() == null ? 0
										: BRF31.getR21_amount_aed_non_resident().intValue());
							}

							Cell R9cell6 = row9.getCell(9);
							if (R9cell6 != null) {
								R9cell6.setCellValue(BRF31.getR21_nos_ccy_non_resident() == null ? 0
										: BRF31.getR21_nos_ccy_non_resident().intValue());
							}

							Cell R9cell7 = row9.getCell(10);
							if (R9cell7 != null) {
								R9cell7.setCellValue(BRF31.getR21_amount_ccy_non_resident() == null ? 0
										: BRF31.getR21_amount_ccy_non_resident().intValue());
							}
							/////////////////////// R22/////////////////////////////

							Row row10 = sheet.getRow(21);
							Cell R10cell = row10.getCell(3);
							if (R10cell != null) {
								R10cell.setCellValue(BRF31.getR22_nos_aed_resident() == null ? 0
										: BRF31.getR22_nos_aed_resident().intValue());
							}
							Cell R10cell1 = row10.getCell(4);
							if (R10cell1 != null) {
								R10cell1.setCellValue(BRF31.getR22_amount_aed_resident() == null ? 0
										: BRF31.getR22_amount_aed_resident().intValue());
							}

							Cell R10cell2 = row10.getCell(5);
							if (R10cell2 != null) {
								R10cell2.setCellValue(BRF31.getR22_nos_ccy_resident() == null ? 0
										: BRF31.getR22_nos_ccy_resident().intValue());
							}

							Cell R10cell3 = row10.getCell(6);
							if (R10cell3 != null) {
								R10cell3.setCellValue(BRF31.getR22_amount_ccy_resident() == null ? 0
										: BRF31.getR22_amount_ccy_resident().intValue());
							}

							Cell R10cell4 = row10.getCell(7);
							if (R10cell4 != null) {
								R10cell4.setCellValue(BRF31.getR22_nos_aed_non_resident() == null ? 0
										: BRF31.getR22_nos_aed_non_resident().intValue());
							}

							Cell R10cell5 = row10.getCell(8);
							if (R10cell5 != null) {
								R10cell5.setCellValue(BRF31.getR22_amount_aed_non_resident() == null ? 0
										: BRF31.getR22_amount_aed_non_resident().intValue());
							}

							Cell R10cell6 = row10.getCell(9);
							if (R10cell6 != null) {
								R10cell6.setCellValue(BRF31.getR22_nos_ccy_non_resident() == null ? 0
										: BRF31.getR22_nos_ccy_non_resident().intValue());
							}

							Cell R10cell7 = row10.getCell(10);
							if (R10cell7 != null) {
								R10cell7.setCellValue(BRF31.getR22_amount_ccy_non_resident() == null ? 0
										: BRF31.getR22_amount_ccy_non_resident().intValue());
							}
							/////////////////////// R23/////////////////////////////

							Row row11 = sheet.getRow(22);
							Cell R11cell = row11.getCell(3);
							if (R11cell != null) {
								R11cell.setCellValue(BRF31.getR23_nos_aed_resident() == null ? 0
										: BRF31.getR23_nos_aed_resident().intValue());
							}
							Cell R11cell1 = row11.getCell(4);
							if (R11cell1 != null) {
								R11cell1.setCellValue(BRF31.getR23_amount_aed_resident() == null ? 0
										: BRF31.getR23_amount_aed_resident().intValue());
							}

							Cell R11cell2 = row11.getCell(5);
							if (R11cell2 != null) {
								R11cell2.setCellValue(BRF31.getR23_nos_ccy_resident() == null ? 0
										: BRF31.getR23_nos_ccy_resident().intValue());
							}

							Cell R11cell3 = row11.getCell(6);
							if (R11cell3 != null) {
								R11cell3.setCellValue(BRF31.getR23_amount_ccy_resident() == null ? 0
										: BRF31.getR23_amount_ccy_resident().intValue());
							}

							Cell R11cell4 = row11.getCell(7);
							if (R11cell4 != null) {
								R11cell4.setCellValue(BRF31.getR23_nos_aed_non_resident() == null ? 0
										: BRF31.getR23_nos_aed_non_resident().intValue());
							}

							Cell R11cell5 = row11.getCell(8);
							if (R11cell5 != null) {
								R11cell5.setCellValue(BRF31.getR23_amount_aed_non_resident() == null ? 0
										: BRF31.getR23_amount_aed_non_resident().intValue());
							}

							Cell R11cell6 = row11.getCell(9);
							if (R11cell6 != null) {
								R11cell6.setCellValue(BRF31.getR23_nos_ccy_non_resident() == null ? 0
										: BRF31.getR23_nos_ccy_non_resident().intValue());
							}

							Cell R11cell7 = row11.getCell(10);
							if (R11cell7 != null) {
								R11cell7.setCellValue(BRF31.getR23_amount_ccy_non_resident() == null ? 0
										: BRF31.getR23_amount_ccy_non_resident().intValue());
							}
							/////////////////////// R24/////////////////////////////

							Row row12 = sheet.getRow(23);
							Cell R12cell = row12.getCell(3);
							if (R12cell != null) {
								R12cell.setCellValue(BRF31.getR24_nos_aed_resident() == null ? 0
										: BRF31.getR24_nos_aed_resident().intValue());
							}
							Cell R12cell1 = row12.getCell(4);
							if (R12cell1 != null) {
								R12cell1.setCellValue(BRF31.getR24_amount_aed_resident() == null ? 0
										: BRF31.getR24_amount_aed_resident().intValue());
							}

							Cell R12cell2 = row12.getCell(5);
							if (R12cell2 != null) {
								R12cell2.setCellValue(BRF31.getR24_nos_ccy_resident() == null ? 0
										: BRF31.getR24_nos_ccy_resident().intValue());
							}

							Cell R12cell3 = row12.getCell(6);
							if (R12cell3 != null) {
								R12cell3.setCellValue(BRF31.getR24_amount_ccy_resident() == null ? 0
										: BRF31.getR24_amount_ccy_resident().intValue());
							}

							Cell R12cell4 = row12.getCell(7);
							if (R12cell4 != null) {
								R12cell4.setCellValue(BRF31.getR24_nos_aed_non_resident() == null ? 0
										: BRF31.getR24_nos_aed_non_resident().intValue());
							}

							Cell R12cell5 = row12.getCell(8);
							if (R12cell5 != null) {
								R12cell5.setCellValue(BRF31.getR24_amount_aed_non_resident() == null ? 0
										: BRF31.getR24_amount_aed_non_resident().intValue());
							}

							Cell R12cell6 = row12.getCell(9);
							if (R12cell6 != null) {
								R12cell6.setCellValue(BRF31.getR24_nos_ccy_non_resident() == null ? 0
										: BRF31.getR24_nos_ccy_non_resident().intValue());
							}

							Cell R12cell7 = row12.getCell(10);
							if (R12cell7 != null) {
								R12cell7.setCellValue(BRF31.getR24_amount_ccy_non_resident() == null ? 0
										: BRF31.getR24_amount_ccy_non_resident().intValue());
							}
							/////////////////////// R25/////////////////////////////

							Row row13 = sheet.getRow(24);
							Cell R13cell = row13.getCell(3);
							if (R13cell != null) {
								R13cell.setCellValue(BRF31.getR25_nos_aed_resident() == null ? 0
										: BRF31.getR25_nos_aed_resident().intValue());
							}
							Cell R13cell1 = row13.getCell(4);
							if (R13cell1 != null) {
								R13cell1.setCellValue(BRF31.getR25_amount_aed_resident() == null ? 0
										: BRF31.getR25_amount_aed_resident().intValue());
							}

							Cell R13cell2 = row13.getCell(5);
							if (R13cell2 != null) {
								R13cell2.setCellValue(BRF31.getR25_nos_ccy_resident() == null ? 0
										: BRF31.getR25_nos_ccy_resident().intValue());
							}

							Cell R13cell3 = row13.getCell(6);
							if (R13cell3 != null) {
								R13cell3.setCellValue(BRF31.getR25_amount_ccy_resident() == null ? 0
										: BRF31.getR25_amount_ccy_resident().intValue());
							}

							Cell R13cell4 = row13.getCell(7);
							if (R13cell4 != null) {
								R13cell4.setCellValue(BRF31.getR25_nos_aed_non_resident() == null ? 0
										: BRF31.getR25_nos_aed_non_resident().intValue());
							}

							Cell R13cell5 = row13.getCell(8);
							if (R13cell5 != null) {
								R13cell5.setCellValue(BRF31.getR25_amount_aed_non_resident() == null ? 0
										: BRF31.getR25_amount_aed_non_resident().intValue());
							}

							Cell R13cell6 = row13.getCell(9);
							if (R13cell6 != null) {
								R13cell6.setCellValue(BRF31.getR25_nos_ccy_non_resident() == null ? 0
										: BRF31.getR25_nos_ccy_non_resident().intValue());
							}

							Cell R13cell7 = row13.getCell(10);
							if (R13cell7 != null) {
								R13cell7.setCellValue(BRF31.getR25_amount_ccy_non_resident() == null ? 0
										: BRF31.getR25_amount_ccy_non_resident().intValue());
							}

							/////////////////////// R26/////////////////////////////

							Row row14 = sheet.getRow(25);
							Cell R14cell = row14.getCell(3);
							if (R14cell != null) {
								R14cell.setCellValue(BRF31.getR26_nos_aed_resident() == null ? 0
										: BRF31.getR26_nos_aed_resident().intValue());
							}
							Cell R14cell1 = row14.getCell(4);
							if (R14cell1 != null) {
								R14cell1.setCellValue(BRF31.getR26_amount_aed_resident() == null ? 0
										: BRF31.getR26_amount_aed_resident().intValue());
							}

							Cell R14cell2 = row14.getCell(5);
							if (R14cell2 != null) {
								R14cell2.setCellValue(BRF31.getR26_nos_ccy_resident() == null ? 0
										: BRF31.getR26_nos_ccy_resident().intValue());
							}

							Cell R14cell3 = row14.getCell(6);
							if (R14cell3 != null) {
								R14cell3.setCellValue(BRF31.getR26_amount_ccy_resident() == null ? 0
										: BRF31.getR26_amount_ccy_resident().intValue());
							}

							Cell R14cell4 = row14.getCell(7);
							if (R14cell4 != null) {
								R14cell4.setCellValue(BRF31.getR26_nos_aed_non_resident() == null ? 0
										: BRF31.getR26_nos_aed_non_resident().intValue());
							}

							Cell R14cell5 = row14.getCell(8);
							if (R14cell5 != null) {
								R14cell5.setCellValue(BRF31.getR26_amount_aed_non_resident() == null ? 0
										: BRF31.getR26_amount_aed_non_resident().intValue());
							}

							Cell R14cell6 = row14.getCell(9);
							if (R14cell6 != null) {
								R14cell6.setCellValue(BRF31.getR26_nos_ccy_non_resident() == null ? 0
										: BRF31.getR26_nos_ccy_non_resident().intValue());
							}

							Cell R14cell7 = row14.getCell(10);
							if (R14cell7 != null) {
								R14cell7.setCellValue(BRF31.getR26_amount_ccy_non_resident() == null ? 0
										: BRF31.getR26_amount_ccy_non_resident().intValue());
							}

							/////////////////////// R27/////////////////////////////

							Row row15 = sheet.getRow(26);
							Cell R15cell = row15.getCell(3);
							if (R15cell != null) {
								R15cell.setCellValue(BRF31.getR27_nos_aed_resident() == null ? 0
										: BRF31.getR27_nos_aed_resident().intValue());
							}
							Cell R15cell1 = row15.getCell(4);
							if (R15cell1 != null) {
								R15cell1.setCellValue(BRF31.getR27_amount_aed_resident() == null ? 0
										: BRF31.getR27_amount_aed_resident().intValue());
							}

							Cell R15cell2 = row15.getCell(5);
							if (R15cell2 != null) {
								R15cell2.setCellValue(BRF31.getR27_nos_ccy_resident() == null ? 0
										: BRF31.getR27_nos_ccy_resident().intValue());
							}

							Cell R15cell3 = row15.getCell(6);
							if (R15cell3 != null) {
								R15cell3.setCellValue(BRF31.getR27_amount_ccy_resident() == null ? 0
										: BRF31.getR27_amount_ccy_resident().intValue());
							}

							Cell R15cell4 = row15.getCell(7);
							if (R15cell4 != null) {
								R15cell4.setCellValue(BRF31.getR27_nos_aed_non_resident() == null ? 0
										: BRF31.getR27_nos_aed_non_resident().intValue());
							}

							Cell R15cell5 = row15.getCell(8);
							if (R15cell5 != null) {
								R15cell5.setCellValue(BRF31.getR27_amount_aed_non_resident() == null ? 0
										: BRF31.getR27_amount_aed_non_resident().intValue());
							}

							Cell R15cell6 = row15.getCell(9);
							if (R15cell6 != null) {
								R15cell6.setCellValue(BRF31.getR27_nos_ccy_non_resident() == null ? 0
										: BRF31.getR27_nos_ccy_non_resident().intValue());
							}

							Cell R15cell7 = row15.getCell(10);
							if (R15cell7 != null) {
								R15cell7.setCellValue(BRF31.getR27_amount_ccy_non_resident() == null ? 0
										: BRF31.getR27_amount_ccy_non_resident().intValue());
							}

							/////////////////////// R28/////////////////////////////

							Row row16 = sheet.getRow(27);
							Cell R16cell = row16.getCell(3);
							if (R16cell != null) {
								R16cell.setCellValue(BRF31.getR28_nos_aed_resident() == null ? 0
										: BRF31.getR28_nos_aed_resident().intValue());
							}
							Cell R16cell1 = row16.getCell(4);
							if (R16cell1 != null) {
								R16cell1.setCellValue(BRF31.getR28_amount_aed_resident() == null ? 0
										: BRF31.getR28_amount_aed_resident().intValue());
							}

							Cell R16cell2 = row16.getCell(5);
							if (R16cell2 != null) {
								R16cell2.setCellValue(BRF31.getR28_nos_ccy_resident() == null ? 0
										: BRF31.getR28_nos_ccy_resident().intValue());
							}

							Cell R16cell3 = row16.getCell(6);
							if (R16cell3 != null) {
								R16cell3.setCellValue(BRF31.getR28_amount_ccy_resident() == null ? 0
										: BRF31.getR28_amount_ccy_resident().intValue());
							}

							Cell R16cell4 = row16.getCell(7);
							if (R16cell4 != null) {
								R16cell4.setCellValue(BRF31.getR28_nos_aed_non_resident() == null ? 0
										: BRF31.getR28_nos_aed_non_resident().intValue());
							}

							Cell R16cell5 = row16.getCell(8);
							if (R16cell5 != null) {
								R16cell5.setCellValue(BRF31.getR28_amount_aed_non_resident() == null ? 0
										: BRF31.getR28_amount_aed_non_resident().intValue());
							}

							Cell R16cell6 = row16.getCell(9);
							if (R16cell6 != null) {
								R16cell6.setCellValue(BRF31.getR28_nos_ccy_non_resident() == null ? 0
										: BRF31.getR28_nos_ccy_non_resident().intValue());
							}

							Cell R16cell7 = row16.getCell(10);
							if (R16cell7 != null) {
								R16cell7.setCellValue(BRF31.getR28_amount_ccy_non_resident() == null ? 0
										: BRF31.getR28_amount_ccy_non_resident().intValue());
							}

							// Save the changes
							workbook.getCreationHelper().createFormulaEvaluator().evaluateAll();
							FileOutputStream fileOut = new FileOutputStream(
									env.getProperty("output.exportpathfinal") + "011-BRF-031-A.xls");
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
		outputFile = new File(env.getProperty("output.exportpathfinal") + "011-BRF-031-A.xls");

		return outputFile;

	}

	public String insert(BRF31_DETAIL_ENTITY brf031) {

		BRF31_DETAIL_ENTITY brf31 = new BRF31_DETAIL_ENTITY();
		System.out.println("brf31");

		System.out.println("brf31");
		String msg = "";

		try {

			brf031.setReport_date(new Date());
			Session hs = sessionFactory.getCurrentSession();
			System.out.println("inside.....");
			System.out.println("brf031");

			hs.save(brf031);

			logger.info("Added Record");
			msg = "Added Successfully";

		} catch (Exception e) {

			msg = "error occured. Please contact Administrator";
			e.printStackTrace();
		}

		return msg;
	}

	/**
	 * ARCH DETAILS
	 * 
	 * @throws ParseException
	 **/

	public ModelAndView ARCHgetBRF0031currentDtl(String reportId, String fromdate, String todate, String currency,
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
						"select * from BRF31_DETAILTABLE a where report_date=?1 and report_label_1=?2");
				qr.setParameter(1, df.parse(todate));
				qr.setParameter(2, filter);

			} else {
				System.out.println("2");
				qr = hs.createNativeQuery("select * from BRF31_DETAILTABLE");

			}
		} else {
			System.out.println("3");
			qr = hs.createNativeQuery("select * from BRF31_DETAILTABLE  where report_date = ?1");
		}

		/*
		 * try { qr.setParameter(1, df.parse(todate));
		 * 
		 * } catch (ParseException e) { e.printStackTrace(); }
		 */
		List<BRF31_DETAIL_ENTITY> T1Master = new ArrayList<BRF31_DETAIL_ENTITY>();

		try {
			System.out.println("Values entered");
			T1Master = hs.createQuery("from BRF31_DETAIL_ENTITY a where a.report_date = ?1", BRF31_DETAIL_ENTITY.class)
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
			Character nreflag = (Character) a[49];

			/*
			 * BRF31_ARCH_DETAIL_ENTITY py = new BRF31_DETAIL_ENTITY(sol_id, acid, foracid,
			 * acct_name, acct_no,, accr_bal nre_flg, currency_code, del_flg, create_user,
			 * modify_user, report_lable, report_name, report_date, version_control,
			 * cust_id, verify_user, entity_flg, remarks);
			 */
			BRF31_DETAIL_ENTITY py = new BRF31_DETAIL_ENTITY(cust_id, foracid, act_balance_amt_lc, eab_lc, acct_name,
					acct_crncy_code, gl_code, gl_sub_head_code, gl_sub_head_desc, country_of_incorp, cust_type,
					schm_code, schm_type, sol_id, acid, segment, sub_segment, sector, sub_sector, sector_code, group_id,
					constitution_code, country, legal_entity_type, constitution_desc, purpose_of_advn, hni_networth,
					turnover, bacid, report_name_1, report_label_1, report_addl_criteria_1, report_addl_criteria_2,
					report_addl_criteria_3, create_user, create_time, modify_user, modify_time, verify_user,
					verify_time, entity_flg, modify_flg, del_flg, nre_status, report_date, maturity_date, gender,
					version, remarks, nreflag);
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

		mv.setViewName("RR" + "/" + "BRF31ARCH::reportcontent");
		mv.addObject("reportdetails", T1Dt1Page.getContent());
		mv.addObject("reportmaster", T1Master);
		mv.addObject("reportmaster1", qr);
		mv.addObject("singledetail", new T1CurProdDetail());
		mv.addObject("reportsflag", "reportsflag");
		mv.addObject("menu", reportId);
		return mv;
	}

	public String detailChanges31(BRF31_DETAIL_ENTITY detail, String foracid, String report_addl_criteria_1,
			BigDecimal act_balance_amt_lc, String report_label_1, String report_name_1) {
		String msg = "";

		try {

			Session hs = sessionFactory.getCurrentSession();
			Optional<BRF31_DETAIL_ENTITY> Brf31detail = brf31_DetailRep.findById(foracid);

			if (Brf31detail.isPresent()) {
				BRF31_DETAIL_ENTITY BRFdetail = Brf31detail.get();

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
					brf31_DetailRep.save(BRFdetail);

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

	/****** ARCHEVE VIEW ******/

	public ModelAndView getArchieveBRF031View(String reportId, String fromdate, String todate, String currency,
			String dtltype, Pageable pageable) {

		ModelAndView mv = new ModelAndView();
		Session hs = sessionFactory.getCurrentSession();
		int pageSize = pageable.getPageSize();
		int currentPage = pageable.getPageNumber();
		int startItem = currentPage * pageSize;
		/* List<BRF036_ENTITY> T1rep = new ArrayList<BRF036_ENTITY>(); */
		// Query<Object[]> qr;

		List<BRF31_Entity> T1Master = new ArrayList<BRF31_Entity>();
		List<BRF31_Entity> T1Master1 = new ArrayList<BRF31_Entity>();

		logger.info("Inside archive" + currency);

		try {
			Date d1 = df.parse(todate);
			// T1rep = t1CurProdServiceRepo.getT1CurProdServices(d1);

			T1Master = hs.createQuery("from  BRF31_Entity a where a.report_date = ?1 ", BRF31_Entity.class)
					.setParameter(1, df.parse(todate)).getResultList();

			/*
			 * T1Master1 = hs.createQuery("from BRF47_Entity a where a.report_date = ?1 ",
			 * BRF40_Entity2.class) .setParameter(1, df.parse(todate)).getResultList();
			 */

		} catch (ParseException e) {
			e.printStackTrace();
		}

		// T1rep = t1CurProdServiceRepo.getT1CurProdServices(d1);

		mv.setViewName("RR/BRF31ARCH");
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

	public ModelAndView ARCHgetBRF031currentDtl(String reportId, String fromdate, String todate, String currency,
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
						"select * from BRF31_ARCHIVENTITY a where report_date=?1 and report_label_1=?2");
				qr.setParameter(1, df.parse(todate));
				qr.setParameter(2, filter);

			} else {
				System.out.println("2");
				qr = hs.createNativeQuery("select * from BRF31_ARCHIVENTITY");

			}
		} else {
			System.out.println("3");
			qr = hs.createNativeQuery("select * from BRF31_ARCHIVENTITY  where report_date = ?1");
		}

		/*
		 * try { qr.setParameter(1, df.parse(todate));
		 * 
		 * } catch (ParseException e) { e.printStackTrace(); }
		 */
		List<BRF31_ARCHIVENTITY> T1Master = new ArrayList<BRF31_ARCHIVENTITY>();

		try {
			System.out.println("Values entered");
			T1Master = hs.createQuery("from BRF31_ARCHIVENTITY a where a.report_date = ?1", BRF31_ARCHIVENTITY.class)
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
			Character nreflag = (Character) a[49];

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

			BRF31_ARCHIVENTITY py = new BRF31_ARCHIVENTITY(cust_id, foracid, act_balance_amt_lc, eab_lc, acct_name,
					acct_crncy_code, gl_code, gl_sub_head_code, gl_sub_head_desc, country_of_incorp, cust_type,
					schm_code, schm_type, sol_id, acid, segment, sub_segment, sector, sub_sector, sector_code, group_id,
					constitution_code, country, legal_entity_type, constitution_desc, purpose_of_advn, hni_networth,
					turnover, bacid, report_name_1, report_label_1, report_addl_criteria_1, report_addl_criteria_2,
					report_addl_criteria_3, create_user, create_time, modify_user, modify_time, verify_user,
					verify_time, entity_flg, modify_flg, del_flg, nre_status, report_date, maturity_date, gender,
					version, remarks, nreflag);
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

		mv.setViewName("RR" + "/" + "BRF031ARCH::reportcontent");
		mv.addObject("reportdetails", T1Dt1Page.getContent());
		mv.addObject("reportmaster", T1Master);
		mv.addObject("reportmaster1", qr);
		mv.addObject("singledetail", new T1CurProdDetail());
		mv.addObject("reportsflag", "reportsflag");
		mv.addObject("menu", reportId);
		return mv;
	}

}
