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

import com.bornfire.xbrl.entities.BRF32_ARCHIVENTITY;
import com.bornfire.xbrl.entities.BRBS.BRF32B_DETAIL_ENTITY;
import com.bornfire.xbrl.entities.BRBS.BRF32B_DetailRepo;
import com.bornfire.xbrl.entities.BRBS.BRF32C_DetailRepo;
import com.bornfire.xbrl.entities.BRBS.BRF32D_DetailRepo;
import com.bornfire.xbrl.entities.BRBS.BRF32E_DetailRepo;
import com.bornfire.xbrl.entities.BRBS.BRF32ServiceRepo;
import com.bornfire.xbrl.entities.BRBS.BRF32_DetailRepo;
import com.bornfire.xbrl.entities.BRBS.BRF32_ENTITY;
import com.bornfire.xbrl.entities.BRBS.T1CurProdDetail;
import com.bornfire.xbrl.entities.BRBS.T1CurProdServicesRepo;

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
public class BRF32ReportService {

	private static final Logger logger = LoggerFactory.getLogger(BRF32ReportService.class);

	@Autowired
	SessionFactory sessionFactory;

	@Autowired
	DataSource srcdataSource;

	@Autowired
	T1CurProdServicesRepo t1CurProdServiceRepo;

	@Autowired
	Environment env;

	@Autowired
	BRF32ServiceRepo brf32ServiceRepo;

	@Autowired
	BRF32_DetailRepo brf32_detailrepo;
	@Autowired
	BRF32B_DetailRepo brf32b_detailrepo;
	@Autowired
	BRF32C_DetailRepo brf32c_detailrepo;
	@Autowired
	BRF32D_DetailRepo brf32d_detailrepo;
	@Autowired
	BRF32E_DetailRepo brf32e_detailrepo;

	DateFormat df = new SimpleDateFormat("dd-MMM-yyyy");

	public String preCheckBRF32(String reportId, String fromdate, String todate) {

		String msg = "";
		Session hs = sessionFactory.getCurrentSession();
		Date dt1;
		Date dt9;
		logger.info("Report precheck : " + reportId);

		try {
			// dt1 = new SimpleDateFormat("dd/MM/yyyy").parse(fromdate);
			dt9 = new SimpleDateFormat("dd/MM/yyyy").parse(todate);
			logger.info("Getting No of records in Master table :" + reportId);
			Long dtlcnt = (Long) hs.createQuery("select count(*) from BRF32_ENTITY a where a.report_date=?1")
					.setParameter(1, dt9).getSingleResult();

			if (dtlcnt > 0) {
				logger.info("Getting No of records in Mod table :" + reportId);
				Long modcnt = (Long) hs.createQuery("select count(*) from BRF32_ENTITY a").getSingleResult();
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

	public ModelAndView getBRF32View(String reportId, String fromdate, String todate, String currency, String dtltype,
			Pageable pageable) {

		ModelAndView mv = new ModelAndView();

		Session hs = sessionFactory.getCurrentSession();
		int pageSize = pageable.getPageSize();
		int currentPage = pageable.getPageNumber();
		int startItem = currentPage * pageSize;

		List<BRF32_ENTITY> T1rep = new ArrayList<BRF32_ENTITY>();
		// Query<Object[]> qr;

		List<BRF32_ENTITY> T1Master = new ArrayList<BRF32_ENTITY>();

		logger.info("Inside archive" + currency);

		try {

			Date d1 = df.parse(todate);
			// T1rep = brf32ServiceRepo .getBRF32reportService(d1);

			T1Master = hs.createQuery("from BRF32_ENTITY a where a.report_date = ?1 ", BRF32_ENTITY.class)
					.setParameter(1, df.parse(todate)).getResultList();

		} catch (ParseException e) {
			e.printStackTrace();
		}

		// T1rep = t1CurProdServiceRepo.getT1CurProdServices(d1);

		mv.setViewName("RR/BRF32");
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

	public ModelAndView getBRF32Details(String reportId, String fromdate, String todate, String currency,
			String dtltype, Pageable pageable, String filter) {

		int pageSize = pageable.getPageSize();
		int currentPage = pageable.getPageNumber();
		int startItem = currentPage * pageSize;

		ModelAndView mv = new ModelAndView();

		Session hs = sessionFactory.getCurrentSession();
		List<Object> T1Dt1 = new ArrayList<Object>();
		Query<Object[]> qr1;

		if (dtltype.equals("report")) {
			if (!filter.equals("null")) {

				qr1 = hs.createNativeQuery(
						"select * from  BRF32B_DETAILTABLE  a where report_date = ?1 and report_label_1=?2");

				qr1.setParameter(2, filter);

			} else {
				qr1 = hs.createNativeQuery("select * from BRF32B_DETAILTABLE a where report_date = ?1");

			}
		} else {
			qr1 = hs.createNativeQuery("select * from BRF32B_DETAILTABLE  where report_date = ?1");
		}

		try {
			qr1.setParameter(1, df.parse(todate));

		} catch (ParseException e) {
			e.printStackTrace();
		}
		List<BRF32B_DETAIL_ENTITY> T1Master = new ArrayList<BRF32B_DETAIL_ENTITY>();

		try {
			T1Master = hs
					.createQuery("from BRF32B_DETAIL_ENTITY a where a.report_date = ?1", BRF32B_DETAIL_ENTITY.class)
					.setParameter(1, df.parse(todate)).getResultList();
		} catch (ParseException e) {

			e.printStackTrace();
		}

		logger.info("Getting Report Detail for : " + reportId + "," + fromdate + "," + todate + "," + currency);
		List<Object[]> result = qr1.getResultList();
		for (Object[] a : result) {

			String acct_crncy_code = (String) a[0];
			String acct_name = (String) a[1];
			String acid = (String) a[2];
			BigDecimal act_balance_amt_lc = (BigDecimal) a[3];
			String bacid = (String) a[4];
			String constitution_code = (String) a[5];
			String constitution_desc = (String) a[6];
			String country = (String) a[7];
			String country_of_incorp = (String) a[8];
			Date create_time = (Date) a[9];
			String create_user = (String) a[10];
			String cust_id = (String) a[11];
			String cust_type = (String) a[12];
			String del_flg = (String) a[13];
			BigDecimal eab_lc = (BigDecimal) a[14];
			String entity_flg = (String) a[15];
			String foracid = (String) a[16];
			String gender = (String) a[17];
			String gl_code = (String) a[18];
			String gl_sub_head_code = (String) a[19];
			String gl_sub_head_desc = (String) a[20];
			String group_id = (String) a[21];
			BigDecimal hni_networth = (BigDecimal) a[22];
			String legal_entity_type = (String) a[23];
			Date maturity_date = (Date) a[24];
			String modify_flg = (String) a[25];
			Date modify_time = (Date) a[26];
			String modify_user = (String) a[27];
			String nre_flg = (String) a[28];
			String nre_status = (String) a[29];
			String purpose_of_advn = (String) a[30];
			String remarks = (String) a[31];
			String report_addl_criteria_1 = (String) a[32];
			String report_addl_criteria_2 = (String) a[33];
			String report_addl_criteria_3 = (String) a[34];
			Date report_date = (Date) a[35];
			String report_label_1 = (String) a[36];
			String report_name_1 = (String) a[37];
			String schm_code = (String) a[38];
			String schm_type = (String) a[39];
			BigDecimal sector = (BigDecimal) a[40];
			String sector_code = (String) a[41];
			String segment = (String) a[42];
			String sol_id = (String) a[43];
			String sub_sector = (String) a[44];
			String sub_segment = (String) a[45];
			String turnover = (String) a[46];
			Date verify_time = (Date) a[47];
			String verify_user = (String) a[48];
			String version = (String) a[49];
			String group_name = (String) a[50];
			BigDecimal stage3_provision = (BigDecimal) a[51];
			BigDecimal stage2_provision = (BigDecimal) a[52];
			String legal_case = (String) a[53];
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

			BRF32B_DETAIL_ENTITY py = new BRF32B_DETAIL_ENTITY(acct_crncy_code, acct_name, acid, act_balance_amt_lc,
					bacid, constitution_code, constitution_desc, country, country_of_incorp, create_time, create_user,
					cust_id, cust_type, del_flg, eab_lc, entity_flg, foracid, gender, gl_code, gl_sub_head_code,
					gl_sub_head_desc, group_id, hni_networth, legal_entity_type, maturity_date, modify_flg, modify_time,
					modify_user, nre_flg, nre_status, purpose_of_advn, remarks, report_addl_criteria_1,
					report_addl_criteria_2, report_addl_criteria_3, report_date, report_label_1, report_name_1,
					schm_code, schm_type, sector, sector_code, segment, sol_id, sub_sector, sub_segment, turnover,
					verify_time, verify_user, version, group_name, stage3_provision, stage2_provision, legal_case);
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

		mv.setViewName("RR" + "/" + "BRF32::reportcontent");
		mv.addObject("reportdetails", T1Dt1Page);
		mv.addObject("reportmaster", T1Master);
		mv.addObject("singledetail", new T1CurProdDetail());
		mv.addObject("reportsflag", "reportsflag");
		mv.addObject("menu", reportId);
		return mv;
	}

	public File getFileBRF32(String reportId, String fromdate, String todate, String currency, String dtltype,

			String filetype) throws FileNotFoundException, JRException, SQLException {

		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

		String path = this.env.getProperty("output.exportpath");
		String fileName = "";
		String zipFileName = "";
		File outputFile;

		logger.info("Getting Output file :" + reportId);
		fileName = "011-BRF-32-A";

		if (!filetype.equals("xbrl")) {
			if (!filetype.equals("BRF")) {
				try {
					InputStream jasperFile;
					logger.info("Getting Jasper file :" + reportId);
					if (filetype.equals("detailexcel")) {
						if (dtltype.equals("report")) {

							jasperFile = this.getClass().getResourceAsStream("/static/jasper/BRF32_Detail.jrxml");
						} else {
							jasperFile = this.getClass().getResourceAsStream("/static/jasper/BRF32_Detail.jrxml");
						}

					} else {
						if (dtltype.equals("report")) {
							logger.info("Inside report");
							jasperFile = this.getClass().getResourceAsStream("/static/jasper/BRF32.jrxml");
						} else {
							jasperFile = this.getClass().getResourceAsStream("/static/jasper/BRF32.jrxml");
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
				List<BRF32_ENTITY> T1Master = new ArrayList<>();

				Session hs = sessionFactory.getCurrentSession();
				try {
					Date d1 = df.parse(todate);

					T1Master = hs.createQuery("from  BRF32_ENTITY a where a.report_date = ?1 ", BRF32_ENTITY.class)
							.setParameter(1, df.parse(todate)).getResultList();

					File responseCamt = new File(env.getProperty("output.exportpathtemp") + "011-BRF-032-AT.xls");
					Workbook workbook = WorkbookFactory.create(responseCamt);

					Sheet sheet = workbook.getSheetAt(0);

					if (T1Master.size() == 1) {
						for (BRF32_ENTITY BRF32 : T1Master) {
							/*
							 * //report_date Row r1row = sheet.getRow(4); if (r1row != null) { Cell r1cell =
							 * r1row.getCell(2); if (r1cell == null) { r1cell = r1row.createCell(2); //
							 * Create the cell if it doesn't exist } if (BRF32.getReport_date() != null) {
							 * // Formatting the date to dd-MM-yyyy SimpleDateFormat sdf = new
							 * SimpleDateFormat("dd-MM-yyyy"); String formattedDate =
							 * sdf.format(BRF32.getReport_date()); r1cell.setCellValue(formattedDate); //
							 * Set the formatted date in the cell } else { r1cell.setCellValue(""); // Set
							 * an empty value if the report_date is null } }
							 */

							/// row1
							Row row1 = sheet.getRow(8);

							Cell R1cell1 = row1.getCell(2);
							if (R1cell1 != null) {
								String value = (BRF32.getR1_borrower_name() == null) ? ""
										: BRF32.getR1_borrower_name().toString();
								R1cell1.setCellValue(value);
							}
							Cell R1cell2 = row1.getCell(3);
							if (R1cell2 != null) {
								String value = (BRF32.getR1_group_name() == null) ? ""
										: BRF32.getR1_group_name().toString();
								R1cell2.setCellValue(value);
							}
							Cell R1cell3 = row1.getCell(4);
							if (R1cell3 != null) {
								String value = (BRF32.getR1_emirate() == null) ? "" : BRF32.getR1_emirate().toString();
								R1cell3.setCellValue(value);
							}
							Cell R1cell4 = row1.getCell(5);
							if (R1cell4 != null) {
								R1cell4.setCellValue(BRF32.getR1_outstanding_amount() == null ? 0
										: BRF32.getR1_outstanding_amount().intValue());
							}
							Cell R1cell5 = row1.getCell(6);
							if (R1cell5 != null) {
								R1cell5.setCellValue(BRF32.getR1_stage3_provisions() == null ? 0
										: BRF32.getR1_stage3_provisions().intValue());
							}
							Cell R1cell6 = row1.getCell(7);
							if (R1cell6 != null) {
								R1cell6.setCellValue(BRF32.getR1_stage2_provisions() == null ? 0
										: BRF32.getR1_stage2_provisions().intValue());
							}
							Cell R1cell7 = row1.getCell(8);
							if (R1cell7 != null) {
								String value = (BRF32.getR1_legal_case() == null) ? ""
										: BRF32.getR1_legal_case().toString();
								R1cell7.setCellValue(value);
							}
							Cell R1cell8 = row1.getCell(9);
							if (R1cell8 != null) {
								String value = (BRF32.getR1_remarks() == null) ? "" : BRF32.getR1_remarks().toString();
								R1cell8.setCellValue(value);
							}
							/// row2
							Row row2 = sheet.getRow(9);
							Cell R2cell1 = row2.getCell(2);
							if (R2cell1 != null) {
								String value = (BRF32.getR2_borrower_name() == null) ? ""
										: BRF32.getR2_borrower_name().toString();
								R2cell1.setCellValue(value);
							}
							Cell R2cell2 = row2.getCell(3);
							if (R2cell2 != null) {
								String value = (BRF32.getR2_group_name() == null) ? ""
										: BRF32.getR2_group_name().toString();
								R2cell2.setCellValue(value);
							}
							Cell R2cell3 = row2.getCell(4);
							if (R2cell3 != null) {
								String value = (BRF32.getR2_emirate() == null) ? "" : BRF32.getR2_emirate().toString();
								R2cell3.setCellValue(value);
							}
							Cell R2cell4 = row2.getCell(5);
							if (R2cell4 != null) {
								R2cell4.setCellValue(BRF32.getR2_outstanding_amount() == null ? 0
										: BRF32.getR2_outstanding_amount().intValue());
							}
							Cell R2cell5 = row2.getCell(6);
							if (R2cell5 != null) {
								R2cell5.setCellValue(BRF32.getR2_stage3_provisions() == null ? 0
										: BRF32.getR2_stage3_provisions().intValue());
							}
							Cell R2cell6 = row2.getCell(7);
							if (R2cell6 != null) {
								R2cell6.setCellValue(BRF32.getR2_stage2_provisions() == null ? 0
										: BRF32.getR2_stage2_provisions().intValue());
							}
							Cell R2cell7 = row2.getCell(8);
							if (R2cell7 != null) {
								String value = (BRF32.getR2_legal_case() == null) ? ""
										: BRF32.getR2_legal_case().toString();
								R2cell7.setCellValue(value);
							}
							Cell R2cell8 = row2.getCell(9);
							if (R2cell8 != null) {
								String value = (BRF32.getR2_remarks() == null) ? "" : BRF32.getR2_remarks().toString();
								R2cell8.setCellValue(value);
							}
							/// row3
							Row row3 = sheet.getRow(10);
							Cell R3cell1 = row3.getCell(2);
							if (R3cell1 != null) {
								String value = (BRF32.getR3_borrower_name() == null) ? ""
										: BRF32.getR3_borrower_name().toString();
								R3cell1.setCellValue(value);
							}
							Cell R3cell2 = row3.getCell(3);
							if (R3cell2 != null) {
								String value = (BRF32.getR3_group_name() == null) ? ""
										: BRF32.getR3_group_name().toString();
								R3cell2.setCellValue(value);
							}
							Cell R3cell3 = row3.getCell(4);
							if (R3cell3 != null) {
								String value = (BRF32.getR3_emirate() == null) ? "" : BRF32.getR3_emirate().toString();
								R3cell3.setCellValue(value);
							}
							Cell R3cell4 = row3.getCell(5);
							if (R3cell4 != null) {
								R3cell4.setCellValue(BRF32.getR3_outstanding_amount() == null ? 0
										: BRF32.getR3_outstanding_amount().intValue());
							}
							Cell R3cell5 = row3.getCell(6);
							if (R3cell5 != null) {
								R3cell5.setCellValue(BRF32.getR3_stage3_provisions() == null ? 0
										: BRF32.getR3_stage3_provisions().intValue());
							}
							Cell R3cell6 = row3.getCell(7);
							if (R3cell6 != null) {
								R3cell6.setCellValue(BRF32.getR3_stage2_provisions() == null ? 0
										: BRF32.getR3_stage2_provisions().intValue());
							}
							Cell R3cell7 = row3.getCell(8);
							if (R3cell7 != null) {
								String value = (BRF32.getR3_legal_case() == null) ? ""
										: BRF32.getR3_legal_case().toString();
								R3cell7.setCellValue(value);
							}
							Cell R3cell8 = row3.getCell(9);
							if (R3cell8 != null) {
								String value = (BRF32.getR3_remarks() == null) ? "" : BRF32.getR3_remarks().toString();
								R3cell8.setCellValue(value);
							}
							/// row4
							Row row4 = sheet.getRow(11);
							Cell R4cell1 = row4.getCell(2);
							if (R4cell1 != null) {
								String value = (BRF32.getR4_borrower_name() == null) ? ""
										: BRF32.getR4_borrower_name().toString();
								R4cell1.setCellValue(value);
							}
							Cell R4cell2 = row4.getCell(3);
							if (R4cell2 != null) {
								String value = (BRF32.getR4_group_name() == null) ? ""
										: BRF32.getR4_group_name().toString();
								R4cell2.setCellValue(value);
							}
							Cell R4cell3 = row4.getCell(4);
							if (R4cell3 != null) {
								String value = (BRF32.getR4_emirate() == null) ? "" : BRF32.getR4_emirate().toString();
								R4cell3.setCellValue(value);
							}
							Cell R4cell4 = row4.getCell(5);
							if (R4cell4 != null) {
								R4cell4.setCellValue(BRF32.getR4_outstanding_amount() == null ? 0
										: BRF32.getR4_outstanding_amount().intValue());
							}
							Cell R4cell5 = row4.getCell(6);
							if (R4cell5 != null) {
								R4cell5.setCellValue(BRF32.getR4_stage3_provisions() == null ? 0
										: BRF32.getR4_stage3_provisions().intValue());
							}
							Cell R4cell6 = row4.getCell(7);
							if (R4cell6 != null) {
								R4cell6.setCellValue(BRF32.getR4_stage2_provisions() == null ? 0
										: BRF32.getR4_stage2_provisions().intValue());
							}
							Cell R4cell7 = row4.getCell(8);
							if (R4cell7 != null) {
								String value = (BRF32.getR4_legal_case() == null) ? ""
										: BRF32.getR4_legal_case().toString();
								R4cell7.setCellValue(value);
							}
							Cell R4cell8 = row4.getCell(9);
							if (R4cell8 != null) {
								String value = (BRF32.getR4_remarks() == null) ? "" : BRF32.getR4_remarks().toString();
								R4cell8.setCellValue(value);
							}
							/// row5
							Row row5 = sheet.getRow(12);
							Cell R5cell1 = row5.getCell(2);
							if (R5cell1 != null) {
								String value = (BRF32.getR5_borrower_name() == null) ? ""
										: BRF32.getR5_borrower_name().toString();
								R5cell1.setCellValue(value);
							}
							Cell R5cell2 = row5.getCell(3);
							if (R5cell2 != null) {
								String value = (BRF32.getR5_group_name() == null) ? ""
										: BRF32.getR5_group_name().toString();
								R5cell2.setCellValue(value);
							}
							Cell R5cell3 = row5.getCell(4);
							if (R5cell3 != null) {
								String value = (BRF32.getR5_emirate() == null) ? "" : BRF32.getR5_emirate().toString();
								R5cell3.setCellValue(value);
							}
							Cell R5cell4 = row5.getCell(5);
							if (R5cell4 != null) {
								R5cell4.setCellValue(BRF32.getR5_outstanding_amount() == null ? 0
										: BRF32.getR5_outstanding_amount().intValue());
							}
							Cell R5cell5 = row5.getCell(6);
							if (R5cell5 != null) {
								R5cell5.setCellValue(BRF32.getR5_stage3_provisions() == null ? 0
										: BRF32.getR5_stage3_provisions().intValue());
							}
							Cell R5cell6 = row5.getCell(7);
							if (R5cell6 != null) {
								R5cell6.setCellValue(BRF32.getR5_stage2_provisions() == null ? 0
										: BRF32.getR5_stage2_provisions().intValue());
							}
							Cell R5cell7 = row5.getCell(8);
							if (R5cell7 != null) {
								String value = (BRF32.getR5_legal_case() == null) ? ""
										: BRF32.getR5_legal_case().toString();
								R5cell7.setCellValue(value);
							}
							Cell R5cell8 = row5.getCell(9);
							if (R5cell8 != null) {
								String value = (BRF32.getR5_remarks() == null) ? "" : BRF32.getR5_remarks().toString();
								R5cell8.setCellValue(value);
							}
							/// row6
							Row row6 = sheet.getRow(13);
							Cell R6cell1 = row6.getCell(2);
							if (R6cell1 != null) {
								String value = (BRF32.getR6_borrower_name() == null) ? ""
										: BRF32.getR6_borrower_name().toString();
								R6cell1.setCellValue(value);
							}
							Cell R6cell2 = row6.getCell(3);
							if (R6cell2 != null) {
								String value = (BRF32.getR6_group_name() == null) ? ""
										: BRF32.getR6_group_name().toString();
								R6cell2.setCellValue(value);
							}
							Cell R6cell3 = row6.getCell(4);
							if (R6cell3 != null) {
								String value = (BRF32.getR6_emirate() == null) ? "" : BRF32.getR6_emirate().toString();
								R6cell3.setCellValue(value);
							}
							Cell R6cell4 = row6.getCell(5);
							if (R6cell4 != null) {
								R6cell4.setCellValue(BRF32.getR6_outstanding_amount() == null ? 0
										: BRF32.getR6_outstanding_amount().intValue());
							}
							Cell R6cell5 = row6.getCell(6);
							if (R6cell5 != null) {
								R6cell5.setCellValue(BRF32.getR6_stage3_provisions() == null ? 0
										: BRF32.getR6_stage3_provisions().intValue());
							}
							Cell R6cell6 = row6.getCell(7);
							if (R6cell6 != null) {
								R6cell6.setCellValue(BRF32.getR6_stage2_provisions() == null ? 0
										: BRF32.getR6_stage2_provisions().intValue());
							}
							Cell R6cell7 = row6.getCell(8);
							if (R6cell7 != null) {
								String value = (BRF32.getR6_legal_case() == null) ? ""
										: BRF32.getR6_legal_case().toString();
								R6cell7.setCellValue(value);
							}
							Cell R6cell8 = row6.getCell(9);
							if (R6cell8 != null) {
								String value = (BRF32.getR6_remarks() == null) ? "" : BRF32.getR6_remarks().toString();
								R6cell8.setCellValue(value);
							}
							/// row7
							Row row7 = sheet.getRow(14);
							Cell R7cell1 = row7.getCell(2);
							if (R7cell1 != null) {
								String value = (BRF32.getR7_borrower_name() == null) ? ""
										: BRF32.getR7_borrower_name().toString();
								R7cell1.setCellValue(value);
							}
							Cell R7cell2 = row7.getCell(3);
							if (R7cell2 != null) {
								String value = (BRF32.getR7_group_name() == null) ? ""
										: BRF32.getR7_group_name().toString();
								R7cell2.setCellValue(value);
							}
							Cell R7cell3 = row7.getCell(4);
							if (R7cell3 != null) {
								String value = (BRF32.getR7_emirate() == null) ? "" : BRF32.getR7_emirate().toString();
								R7cell3.setCellValue(value);
							}
							Cell R7cell4 = row7.getCell(5);
							if (R7cell4 != null) {
								R7cell4.setCellValue(BRF32.getR7_outstanding_amount() == null ? 0
										: BRF32.getR7_outstanding_amount().intValue());
							}
							Cell R7cell5 = row7.getCell(6);
							if (R7cell5 != null) {
								R7cell5.setCellValue(BRF32.getR7_stage3_provisions() == null ? 0
										: BRF32.getR7_stage3_provisions().intValue());
							}
							Cell R7cell6 = row7.getCell(7);
							if (R7cell6 != null) {
								R7cell6.setCellValue(BRF32.getR7_stage2_provisions() == null ? 0
										: BRF32.getR7_stage2_provisions().intValue());
							}
							Cell R7cell7 = row7.getCell(8);
							if (R7cell7 != null) {
								String value = (BRF32.getR7_legal_case() == null) ? ""
										: BRF32.getR7_legal_case().toString();
								R7cell7.setCellValue(value);
							}
							Cell R7cell8 = row7.getCell(9);
							if (R7cell8 != null) {
								String value = (BRF32.getR7_remarks() == null) ? "" : BRF32.getR7_remarks().toString();
								R7cell8.setCellValue(value);
							}
							/// row8
							Row row8 = sheet.getRow(15);
							Cell R8cell1 = row8.getCell(2);
							if (R8cell1 != null) {
								String value = (BRF32.getR8_borrower_name() == null) ? ""
										: BRF32.getR8_borrower_name().toString();
								R8cell1.setCellValue(value);
							}
							Cell R8cell2 = row8.getCell(3);
							if (R8cell2 != null) {
								String value = (BRF32.getR8_group_name() == null) ? ""
										: BRF32.getR8_group_name().toString();
								R8cell2.setCellValue(value);
							}
							Cell R8cell3 = row8.getCell(4);
							if (R8cell3 != null) {
								String value = (BRF32.getR8_emirate() == null) ? "" : BRF32.getR8_emirate().toString();
								R8cell3.setCellValue(value);
							}
							Cell R8cell4 = row8.getCell(5);
							if (R8cell4 != null) {
								R8cell4.setCellValue(BRF32.getR8_outstanding_amount() == null ? 0
										: BRF32.getR8_outstanding_amount().intValue());
							}
							Cell R8cell5 = row8.getCell(6);
							if (R8cell5 != null) {
								R8cell5.setCellValue(BRF32.getR8_stage3_provisions() == null ? 0
										: BRF32.getR8_stage3_provisions().intValue());
							}
							Cell R8cell6 = row8.getCell(7);
							if (R8cell6 != null) {
								R8cell6.setCellValue(BRF32.getR8_stage2_provisions() == null ? 0
										: BRF32.getR8_stage2_provisions().intValue());
							}
							Cell R8cell7 = row8.getCell(8);
							if (R8cell7 != null) {
								String value = (BRF32.getR8_legal_case() == null) ? ""
										: BRF32.getR8_legal_case().toString();
								R8cell7.setCellValue(value);
							}
							Cell R8cell8 = row8.getCell(9);
							if (R8cell8 != null) {
								String value = (BRF32.getR8_remarks() == null) ? "" : BRF32.getR8_remarks().toString();
								R8cell8.setCellValue(value);
							}
							/// row9
							Row row9 = sheet.getRow(16);
							Cell R9cell1 = row9.getCell(2);
							if (R9cell1 != null) {
								String value = (BRF32.getR9_borrower_name() == null) ? ""
										: BRF32.getR9_borrower_name().toString();
								R9cell1.setCellValue(value);
							}
							Cell R9cell2 = row9.getCell(3);
							if (R9cell2 != null) {
								String value = (BRF32.getR9_group_name() == null) ? ""
										: BRF32.getR9_group_name().toString();
								R9cell2.setCellValue(value);
							}
							Cell R9cell3 = row9.getCell(4);
							if (R9cell3 != null) {
								String value = (BRF32.getR9_emirate() == null) ? "" : BRF32.getR9_emirate().toString();
								R9cell3.setCellValue(value);
							}
							Cell R9cell4 = row9.getCell(5);
							if (R9cell4 != null) {
								R9cell4.setCellValue(BRF32.getR9_outstanding_amount() == null ? 0
										: BRF32.getR9_outstanding_amount().intValue());
							}
							Cell R9cell5 = row9.getCell(6);
							if (R9cell5 != null) {
								R9cell5.setCellValue(BRF32.getR9_stage3_provisions() == null ? 0
										: BRF32.getR9_stage3_provisions().intValue());
							}
							Cell R9cell6 = row9.getCell(7);
							if (R9cell6 != null) {
								R9cell6.setCellValue(BRF32.getR9_stage2_provisions() == null ? 0
										: BRF32.getR9_stage2_provisions().intValue());
							}
							Cell R9cell7 = row9.getCell(8);
							if (R9cell7 != null) {
								String value = (BRF32.getR9_legal_case() == null) ? ""
										: BRF32.getR9_legal_case().toString();
								R9cell7.setCellValue(value);
							}
							Cell R9cell8 = row9.getCell(9);
							if (R9cell8 != null) {
								String value = (BRF32.getR9_remarks() == null) ? "" : BRF32.getR9_remarks().toString();
								R9cell8.setCellValue(value);
							}
							/// row10
							Row row10 = sheet.getRow(17);
							Cell R10cell1 = row10.getCell(2);
							if (R10cell1 != null) {
								String value = (BRF32.getR10_borrower_name() == null) ? ""
										: BRF32.getR10_borrower_name().toString();
								R10cell1.setCellValue(value);
							}
							Cell R10cell2 = row10.getCell(3);
							if (R10cell2 != null) {
								String value = (BRF32.getR10_group_name() == null) ? ""
										: BRF32.getR10_group_name().toString();
								R10cell2.setCellValue(value);
							}
							Cell R10cell3 = row10.getCell(4);
							if (R10cell3 != null) {
								String value = (BRF32.getR10_emirate() == null) ? ""
										: BRF32.getR10_emirate().toString();
								R10cell3.setCellValue(value);
							}
							Cell R10cell4 = row10.getCell(5);
							if (R10cell4 != null) {
								R10cell4.setCellValue(BRF32.getR10_outstanding_amount() == null ? 0
										: BRF32.getR10_outstanding_amount().intValue());
							}
							Cell R10cell5 = row10.getCell(6);
							if (R10cell5 != null) {
								R10cell5.setCellValue(BRF32.getR10_stage3_provisions() == null ? 0
										: BRF32.getR10_stage3_provisions().intValue());
							}
							Cell R10cell6 = row10.getCell(7);
							if (R10cell6 != null) {
								R10cell6.setCellValue(BRF32.getR10_stage2_provisions() == null ? 0
										: BRF32.getR10_stage2_provisions().intValue());
							}
							Cell R10cell7 = row10.getCell(8);
							if (R10cell7 != null) {
								String value = (BRF32.getR10_legal_case() == null) ? ""
										: BRF32.getR10_legal_case().toString();
								R10cell7.setCellValue(value);
							}
							Cell R10cell8 = row10.getCell(9);
							if (R10cell8 != null) {
								String value = (BRF32.getR10_remarks() == null) ? ""
										: BRF32.getR10_remarks().toString();
								R10cell8.setCellValue(value);
							}
							/// row11
							Row row11 = sheet.getRow(18);
							Cell R11cell1 = row11.getCell(2);
							if (R11cell1 != null) {
								String value = (BRF32.getR11_borrower_name() == null) ? ""
										: BRF32.getR11_borrower_name().toString();
								R11cell1.setCellValue(value);
							}
							Cell R11cell2 = row11.getCell(3);
							if (R11cell2 != null) {
								String value = (BRF32.getR11_group_name() == null) ? ""
										: BRF32.getR11_group_name().toString();
								R11cell2.setCellValue(value);
							}
							Cell R11cell3 = row11.getCell(4);
							if (R11cell3 != null) {
								String value = (BRF32.getR11_emirate() == null) ? ""
										: BRF32.getR11_emirate().toString();
								R11cell3.setCellValue(value);
							}
							Cell R11cell4 = row11.getCell(5);
							if (R11cell4 != null) {
								R11cell4.setCellValue(BRF32.getR11_outstanding_amount() == null ? 0
										: BRF32.getR11_outstanding_amount().intValue());
							}
							Cell R11cell5 = row11.getCell(6);
							if (R11cell5 != null) {
								R11cell5.setCellValue(BRF32.getR11_stage3_provisions() == null ? 0
										: BRF32.getR11_stage3_provisions().intValue());
							}
							Cell R11cell6 = row11.getCell(7);
							if (R11cell6 != null) {
								R11cell6.setCellValue(BRF32.getR11_stage2_provisions() == null ? 0
										: BRF32.getR11_stage2_provisions().intValue());
							}
							Cell R11cell7 = row11.getCell(8);
							if (R11cell7 != null) {
								String value = (BRF32.getR11_legal_case() == null) ? ""
										: BRF32.getR11_legal_case().toString();
								R11cell7.setCellValue(value);
							}
							Cell R11cell8 = row11.getCell(9);
							if (R11cell8 != null) {
								String value = (BRF32.getR11_remarks() == null) ? ""
										: BRF32.getR11_remarks().toString();
								R11cell8.setCellValue(value);
							}
							/// row12
							Row row12 = sheet.getRow(19);
							Cell R12cell1 = row12.getCell(2);
							if (R12cell1 != null) {
								String value = (BRF32.getR12_borrower_name() == null) ? ""
										: BRF32.getR12_borrower_name().toString();
								R12cell1.setCellValue(value);
							}
							Cell R12cell2 = row12.getCell(3);
							if (R12cell2 != null) {
								String value = (BRF32.getR12_group_name() == null) ? ""
										: BRF32.getR12_group_name().toString();
								R12cell2.setCellValue(value);
							}
							Cell R12cell3 = row12.getCell(4);
							if (R12cell3 != null) {
								String value = (BRF32.getR12_emirate() == null) ? ""
										: BRF32.getR12_emirate().toString();
								R12cell3.setCellValue(value);
							}
							Cell R12cell4 = row12.getCell(5);
							if (R12cell4 != null) {
								R12cell4.setCellValue(BRF32.getR12_outstanding_amount() == null ? 0
										: BRF32.getR12_outstanding_amount().intValue());
							}
							Cell R12cell5 = row12.getCell(6);
							if (R12cell5 != null) {
								R12cell5.setCellValue(BRF32.getR12_stage3_provisions() == null ? 0
										: BRF32.getR12_stage3_provisions().intValue());
							}
							Cell R12cell6 = row12.getCell(7);
							if (R12cell6 != null) {
								R12cell6.setCellValue(BRF32.getR12_stage2_provisions() == null ? 0
										: BRF32.getR12_stage2_provisions().intValue());
							}
							Cell R12cell7 = row12.getCell(8);
							if (R12cell7 != null) {
								String value = (BRF32.getR12_legal_case() == null) ? ""
										: BRF32.getR12_legal_case().toString();
								R12cell7.setCellValue(value);
							}
							Cell R12cell8 = row12.getCell(9);
							if (R12cell8 != null) {
								String value = (BRF32.getR12_remarks() == null) ? ""
										: BRF32.getR12_remarks().toString();
								R12cell8.setCellValue(value);
							}
							/// row13
							Row row13 = sheet.getRow(20);
							Cell R13cell1 = row13.getCell(2);
							if (R13cell1 != null) {
								String value = (BRF32.getR13_borrower_name() == null) ? ""
										: BRF32.getR13_borrower_name().toString();
								R13cell1.setCellValue(value);
							}
							Cell R13cell2 = row13.getCell(3);
							if (R13cell2 != null) {
								String value = (BRF32.getR13_group_name() == null) ? ""
										: BRF32.getR13_group_name().toString();
								R13cell2.setCellValue(value);
							}
							Cell R13cell3 = row13.getCell(4);
							if (R13cell3 != null) {
								String value = (BRF32.getR13_emirate() == null) ? ""
										: BRF32.getR13_emirate().toString();
								R13cell3.setCellValue(value);
							}
							Cell R13cell4 = row13.getCell(5);
							if (R13cell4 != null) {
								R13cell4.setCellValue(BRF32.getR13_outstanding_amount() == null ? 0
										: BRF32.getR13_outstanding_amount().intValue());
							}
							Cell R13cell5 = row13.getCell(6);
							if (R13cell5 != null) {
								R13cell5.setCellValue(BRF32.getR13_stage3_provisions() == null ? 0
										: BRF32.getR13_stage3_provisions().intValue());
							}
							Cell R13cell6 = row13.getCell(7);
							if (R13cell6 != null) {
								R13cell6.setCellValue(BRF32.getR13_stage2_provisions() == null ? 0
										: BRF32.getR13_stage2_provisions().intValue());
							}
							Cell R13cell7 = row13.getCell(8);
							if (R13cell7 != null) {
								String value = (BRF32.getR13_legal_case() == null) ? ""
										: BRF32.getR13_legal_case().toString();
								R13cell7.setCellValue(value);
							}
							Cell R13cell8 = row13.getCell(9);
							if (R13cell8 != null) {
								String value = (BRF32.getR13_remarks() == null) ? ""
										: BRF32.getR13_remarks().toString();
								R13cell8.setCellValue(value);
							}
							/// row14
							Row row14 = sheet.getRow(21);
							Cell R14cell1 = row14.getCell(2);
							if (R14cell1 != null) {
								String value = (BRF32.getR14_borrower_name() == null) ? ""
										: BRF32.getR14_borrower_name().toString();
								R14cell1.setCellValue(value);
							}
							Cell R14cell2 = row14.getCell(3);
							if (R14cell2 != null) {
								String value = (BRF32.getR14_group_name() == null) ? ""
										: BRF32.getR14_group_name().toString();
								R14cell2.setCellValue(value);
							}
							Cell R14cell3 = row14.getCell(4);
							if (R14cell3 != null) {
								String value = (BRF32.getR14_emirate() == null) ? ""
										: BRF32.getR14_emirate().toString();
								R14cell3.setCellValue(value);
							}
							Cell R14cell4 = row14.getCell(5);
							if (R14cell4 != null) {
								R14cell4.setCellValue(BRF32.getR14_outstanding_amount() == null ? 0
										: BRF32.getR14_outstanding_amount().intValue());
							}
							Cell R14cell5 = row14.getCell(6);
							if (R14cell5 != null) {
								R14cell5.setCellValue(BRF32.getR14_stage3_provisions() == null ? 0
										: BRF32.getR14_stage3_provisions().intValue());
							}
							Cell R14cell6 = row14.getCell(7);
							if (R14cell6 != null) {
								R14cell6.setCellValue(BRF32.getR14_stage2_provisions() == null ? 0
										: BRF32.getR14_stage2_provisions().intValue());
							}
							Cell R14cell7 = row14.getCell(8);
							if (R14cell7 != null) {
								String value = (BRF32.getR14_legal_case() == null) ? ""
										: BRF32.getR14_legal_case().toString();
								R14cell7.setCellValue(value);
							}
							Cell R14cell8 = row14.getCell(9);
							if (R14cell8 != null) {
								String value = (BRF32.getR14_remarks() == null) ? ""
										: BRF32.getR14_remarks().toString();
								R14cell8.setCellValue(value);
							}
							/// row15
							Row row15 = sheet.getRow(22);
							Cell R15cell1 = row15.getCell(2);
							if (R15cell1 != null) {
								String value = (BRF32.getR15_borrower_name() == null) ? ""
										: BRF32.getR15_borrower_name().toString();
								R15cell1.setCellValue(value);
							}
							Cell R15cell2 = row15.getCell(3);
							if (R15cell2 != null) {
								String value = (BRF32.getR15_group_name() == null) ? ""
										: BRF32.getR15_group_name().toString();
								R15cell2.setCellValue(value);
							}
							Cell R15cell3 = row15.getCell(4);
							if (R15cell3 != null) {
								String value = (BRF32.getR15_emirate() == null) ? ""
										: BRF32.getR15_emirate().toString();
								R15cell3.setCellValue(value);
							}
							Cell R15cell4 = row15.getCell(5);
							if (R15cell4 != null) {
								R15cell4.setCellValue(BRF32.getR15_outstanding_amount() == null ? 0
										: BRF32.getR15_outstanding_amount().intValue());
							}
							Cell R15cell5 = row15.getCell(6);
							if (R15cell5 != null) {
								R15cell5.setCellValue(BRF32.getR15_stage3_provisions() == null ? 0
										: BRF32.getR15_stage3_provisions().intValue());
							}
							Cell R15cell6 = row15.getCell(7);
							if (R15cell6 != null) {
								R15cell6.setCellValue(BRF32.getR15_stage2_provisions() == null ? 0
										: BRF32.getR15_stage2_provisions().intValue());
							}
							Cell R15cell7 = row15.getCell(8);
							if (R15cell7 != null) {
								String value = (BRF32.getR15_legal_case() == null) ? ""
										: BRF32.getR15_legal_case().toString();
								R15cell7.setCellValue(value);
							}
							Cell R15cell8 = row15.getCell(9);
							if (R15cell8 != null) {
								String value = (BRF32.getR15_remarks() == null) ? ""
										: BRF32.getR15_remarks().toString();
								R15cell8.setCellValue(value);
							}
							/// row17
							Row row17 = sheet.getRow(25);
							Cell R17cell1 = row17.getCell(2);
							if (R17cell1 != null) {
								String value = (BRF32.getR17_borrower_name() == null) ? ""
										: BRF32.getR17_borrower_name().toString();
								R17cell1.setCellValue(value);
							}
							Cell R17cell2 = row17.getCell(3);
							if (R17cell2 != null) {
								String value = (BRF32.getR17_group_name() == null) ? ""
										: BRF32.getR17_group_name().toString();
								R17cell2.setCellValue(value);
							}
							Cell R17cell3 = row17.getCell(4);
							if (R17cell3 != null) {
								String value = (BRF32.getR17_emirate() == null) ? ""
										: BRF32.getR17_emirate().toString();
								R17cell3.setCellValue(value);
							}
							Cell R17cell4 = row17.getCell(5);
							if (R17cell4 != null) {
								R17cell4.setCellValue(BRF32.getR17_outstanding_amount() == null ? 0
										: BRF32.getR17_outstanding_amount().intValue());
							}
							Cell R17cell5 = row17.getCell(6);
							if (R17cell5 != null) {
								R17cell5.setCellValue(BRF32.getR17_stage3_provisions() == null ? 0
										: BRF32.getR17_stage3_provisions().intValue());
							}
							Cell R17cell6 = row17.getCell(7);
							if (R17cell6 != null) {
								R17cell6.setCellValue(BRF32.getR17_stage2_provisions() == null ? 0
										: BRF32.getR17_stage2_provisions().intValue());
							}
							Cell R17cell7 = row17.getCell(8);
							if (R17cell7 != null) {
								String value = (BRF32.getR17_legal_case() == null) ? ""
										: BRF32.getR17_legal_case().toString();
								R17cell7.setCellValue(value);
							}
							Cell R17cell8 = row17.getCell(9);
							if (R17cell8 != null) {
								String value = (BRF32.getR17_remarks() == null) ? ""
										: BRF32.getR17_remarks().toString();
								R17cell8.setCellValue(value);
							}
							/// row18
							Row row18 = sheet.getRow(26);
							Cell R18cell1 = row18.getCell(2);
							if (R18cell1 != null) {
								String value = (BRF32.getR18_borrower_name() == null) ? ""
										: BRF32.getR18_borrower_name().toString();
								R18cell1.setCellValue(value);
							}
							Cell R18cell2 = row18.getCell(3);
							if (R18cell2 != null) {
								String value = (BRF32.getR18_group_name() == null) ? ""
										: BRF32.getR18_group_name().toString();
								R18cell2.setCellValue(value);
							}
							Cell R18cell3 = row18.getCell(4);
							if (R18cell3 != null) {
								String value = (BRF32.getR18_emirate() == null) ? ""
										: BRF32.getR18_emirate().toString();
								R18cell3.setCellValue(value);
							}
							Cell R18cell4 = row18.getCell(5);
							if (R18cell4 != null) {
								R18cell4.setCellValue(BRF32.getR18_outstanding_amount() == null ? 0
										: BRF32.getR18_outstanding_amount().intValue());
							}
							Cell R18cell5 = row18.getCell(6);
							if (R18cell5 != null) {
								R18cell5.setCellValue(BRF32.getR18_stage3_provisions() == null ? 0
										: BRF32.getR18_stage3_provisions().intValue());
							}
							Cell R18cell6 = row18.getCell(7);
							if (R18cell6 != null) {
								R18cell6.setCellValue(BRF32.getR18_stage2_provisions() == null ? 0
										: BRF32.getR18_stage2_provisions().intValue());
							}
							Cell R18cell7 = row18.getCell(8);
							if (R18cell7 != null) {
								String value = (BRF32.getR18_legal_case() == null) ? ""
										: BRF32.getR18_legal_case().toString();
								R18cell7.setCellValue(value);
							}
							Cell R18cell8 = row18.getCell(9);
							if (R18cell8 != null) {
								String value = (BRF32.getR18_remarks() == null) ? ""
										: BRF32.getR18_remarks().toString();
								R18cell8.setCellValue(value);
							}
							/// row19
							Row row19 = sheet.getRow(27);
							Cell R19cell1 = row19.getCell(2);
							if (R19cell1 != null) {
								String value = (BRF32.getR19_borrower_name() == null) ? ""
										: BRF32.getR19_borrower_name().toString();
								R19cell1.setCellValue(value);
							}
							Cell R19cell2 = row19.getCell(3);
							if (R19cell2 != null) {
								String value = (BRF32.getR19_group_name() == null) ? ""
										: BRF32.getR19_group_name().toString();
								R19cell2.setCellValue(value);
							}
							Cell R19cell3 = row19.getCell(4);
							if (R19cell3 != null) {
								String value = (BRF32.getR19_emirate() == null) ? ""
										: BRF32.getR19_emirate().toString();
								R19cell3.setCellValue(value);
							}
							Cell R19cell4 = row19.getCell(5);
							if (R19cell4 != null) {
								R19cell4.setCellValue(BRF32.getR19_outstanding_amount() == null ? 0
										: BRF32.getR19_outstanding_amount().intValue());
							}
							Cell R19cell5 = row19.getCell(6);
							if (R19cell5 != null) {
								R19cell5.setCellValue(BRF32.getR19_stage3_provisions() == null ? 0
										: BRF32.getR19_stage3_provisions().intValue());
							}
							Cell R19cell6 = row19.getCell(7);
							if (R19cell6 != null) {
								R19cell6.setCellValue(BRF32.getR19_stage2_provisions() == null ? 0
										: BRF32.getR19_stage2_provisions().intValue());
							}
							Cell R19cell7 = row19.getCell(8);
							if (R19cell7 != null) {
								String value = (BRF32.getR19_legal_case() == null) ? ""
										: BRF32.getR19_legal_case().toString();
								R19cell7.setCellValue(value);
							}
							Cell R19cell8 = row19.getCell(9);
							if (R19cell8 != null) {
								String value = (BRF32.getR19_remarks() == null) ? ""
										: BRF32.getR19_remarks().toString();
								R19cell8.setCellValue(value);
							}
							/// row20
							Row row20 = sheet.getRow(28);
							Cell R20cell1 = row20.getCell(2);
							if (R20cell1 != null) {
								String value = (BRF32.getR20_borrower_name() == null) ? ""
										: BRF32.getR20_borrower_name().toString();
								R20cell1.setCellValue(value);
							}
							Cell R20cell2 = row20.getCell(3);
							if (R20cell2 != null) {
								String value = (BRF32.getR20_group_name() == null) ? ""
										: BRF32.getR20_group_name().toString();
								R20cell2.setCellValue(value);
							}
							Cell R20cell3 = row20.getCell(4);
							if (R20cell3 != null) {
								String value = (BRF32.getR20_emirate() == null) ? ""
										: BRF32.getR20_emirate().toString();
								R20cell3.setCellValue(value);
							}
							Cell R20cell4 = row20.getCell(5);
							if (R20cell4 != null) {
								R20cell4.setCellValue(BRF32.getR20_outstanding_amount() == null ? 0
										: BRF32.getR20_outstanding_amount().intValue());
							}
							Cell R20cell5 = row20.getCell(6);
							if (R20cell5 != null) {
								R20cell5.setCellValue(BRF32.getR20_stage3_provisions() == null ? 0
										: BRF32.getR20_stage3_provisions().intValue());
							}
							Cell R20cell6 = row20.getCell(7);
							if (R20cell6 != null) {
								R20cell6.setCellValue(BRF32.getR20_stage2_provisions() == null ? 0
										: BRF32.getR20_stage2_provisions().intValue());
							}
							Cell R20cell7 = row20.getCell(8);
							if (R20cell7 != null) {
								String value = (BRF32.getR20_legal_case() == null) ? ""
										: BRF32.getR20_legal_case().toString();
								R20cell7.setCellValue(value);
							}
							Cell R20cell8 = row20.getCell(9);
							if (R20cell8 != null) {
								String value = (BRF32.getR20_remarks() == null) ? ""
										: BRF32.getR20_remarks().toString();
								R20cell8.setCellValue(value);
							}
							/// row21
							Row row21 = sheet.getRow(29);
							Cell R21cell1 = row21.getCell(2);
							if (R21cell1 != null) {
								String value = (BRF32.getR21_borrower_name() == null) ? ""
										: BRF32.getR21_borrower_name().toString();
								R21cell1.setCellValue(value);
							}
							Cell R21cell2 = row21.getCell(3);
							if (R21cell2 != null) {
								String value = (BRF32.getR21_group_name() == null) ? ""
										: BRF32.getR21_group_name().toString();
								R21cell2.setCellValue(value);
							}
							Cell R21cell3 = row21.getCell(4);
							if (R21cell3 != null) {
								String value = (BRF32.getR21_emirate() == null) ? ""
										: BRF32.getR21_emirate().toString();
								R21cell3.setCellValue(value);
							}
							Cell R21cell4 = row21.getCell(5);
							if (R21cell4 != null) {
								R21cell4.setCellValue(BRF32.getR21_outstanding_amount() == null ? 0
										: BRF32.getR21_outstanding_amount().intValue());
							}
							Cell R21cell5 = row21.getCell(6);
							if (R21cell5 != null) {
								R21cell5.setCellValue(BRF32.getR21_stage3_provisions() == null ? 0
										: BRF32.getR21_stage3_provisions().intValue());
							}
							Cell R21cell6 = row21.getCell(7);
							if (R21cell6 != null) {
								R21cell6.setCellValue(BRF32.getR21_stage2_provisions() == null ? 0
										: BRF32.getR21_stage2_provisions().intValue());
							}
							Cell R21cell7 = row21.getCell(8);
							if (R21cell7 != null) {
								String value = (BRF32.getR21_legal_case() == null) ? ""
										: BRF32.getR21_legal_case().toString();
								R21cell7.setCellValue(value);
							}
							Cell R21cell8 = row21.getCell(9);
							if (R21cell8 != null) {
								String value = (BRF32.getR21_remarks() == null) ? ""
										: BRF32.getR21_remarks().toString();
								R21cell8.setCellValue(value);
							}
							/// row22
							Row row22 = sheet.getRow(30);
							Cell R22cell1 = row22.getCell(2);
							if (R22cell1 != null) {
								String value = (BRF32.getR22_borrower_name() == null) ? ""
										: BRF32.getR22_borrower_name().toString();
								R22cell1.setCellValue(value);
							}
							Cell R22cell2 = row22.getCell(3);
							if (R22cell2 != null) {
								String value = (BRF32.getR22_group_name() == null) ? ""
										: BRF32.getR22_group_name().toString();
								R22cell2.setCellValue(value);
							}
							Cell R22cell3 = row22.getCell(4);
							if (R22cell3 != null) {
								String value = (BRF32.getR22_emirate() == null) ? ""
										: BRF32.getR22_emirate().toString();
								R22cell3.setCellValue(value);
							}
							Cell R22cell4 = row22.getCell(5);
							if (R22cell4 != null) {
								R22cell4.setCellValue(BRF32.getR22_outstanding_amount() == null ? 0
										: BRF32.getR22_outstanding_amount().intValue());
							}
							Cell R22cell5 = row22.getCell(6);
							if (R22cell5 != null) {
								R22cell5.setCellValue(BRF32.getR22_stage3_provisions() == null ? 0
										: BRF32.getR22_stage3_provisions().intValue());
							}
							Cell R22cell6 = row22.getCell(7);
							if (R22cell6 != null) {
								R22cell6.setCellValue(BRF32.getR22_stage2_provisions() == null ? 0
										: BRF32.getR22_stage2_provisions().intValue());
							}
							Cell R22cell7 = row22.getCell(8);
							if (R22cell7 != null) {
								String value = (BRF32.getR22_legal_case() == null) ? ""
										: BRF32.getR22_legal_case().toString();
								R22cell7.setCellValue(value);
							}
							Cell R22cell8 = row22.getCell(9);
							if (R22cell8 != null) {
								String value = (BRF32.getR22_remarks() == null) ? ""
										: BRF32.getR22_remarks().toString();
								R22cell8.setCellValue(value);
							}
							/// row23
							Row row23 = sheet.getRow(31);
							Cell R23cell1 = row23.getCell(2);
							if (R23cell1 != null) {
								String value = (BRF32.getR23_borrower_name() == null) ? ""
										: BRF32.getR23_borrower_name().toString();
								R23cell1.setCellValue(value);
							}
							Cell R23cell2 = row23.getCell(3);
							if (R23cell2 != null) {
								String value = (BRF32.getR23_group_name() == null) ? ""
										: BRF32.getR23_group_name().toString();
								R23cell2.setCellValue(value);
							}
							Cell R23cell3 = row23.getCell(4);
							if (R23cell3 != null) {
								String value = (BRF32.getR23_emirate() == null) ? ""
										: BRF32.getR23_emirate().toString();
								R23cell3.setCellValue(value);
							}
							Cell R23cell4 = row23.getCell(5);
							if (R23cell4 != null) {
								R23cell4.setCellValue(BRF32.getR23_outstanding_amount() == null ? 0
										: BRF32.getR23_outstanding_amount().intValue());
							}
							Cell R23cell5 = row23.getCell(6);
							if (R23cell5 != null) {
								R23cell5.setCellValue(BRF32.getR23_stage3_provisions() == null ? 0
										: BRF32.getR23_stage3_provisions().intValue());
							}
							Cell R23cell6 = row23.getCell(7);
							if (R23cell6 != null) {
								R23cell6.setCellValue(BRF32.getR23_stage2_provisions() == null ? 0
										: BRF32.getR23_stage2_provisions().intValue());
							}
							Cell R23cell7 = row23.getCell(8);
							if (R23cell7 != null) {
								String value = (BRF32.getR23_legal_case() == null) ? ""
										: BRF32.getR23_legal_case().toString();
								R23cell7.setCellValue(value);
							}
							Cell R23cell8 = row23.getCell(9);
							if (R23cell8 != null) {
								String value = (BRF32.getR23_remarks() == null) ? ""
										: BRF32.getR23_remarks().toString();
								R23cell8.setCellValue(value);
							}
							/// row24
							Row row24 = sheet.getRow(32);
							Cell R24cell1 = row24.getCell(2);
							if (R24cell1 != null) {
								String value = (BRF32.getR24_borrower_name() == null) ? ""
										: BRF32.getR24_borrower_name().toString();
								R24cell1.setCellValue(value);
							}
							Cell R24cell2 = row24.getCell(3);
							if (R24cell2 != null) {
								String value = (BRF32.getR24_group_name() == null) ? ""
										: BRF32.getR24_group_name().toString();
								R24cell2.setCellValue(value);
							}
							Cell R24cell3 = row24.getCell(4);
							if (R24cell3 != null) {
								String value = (BRF32.getR24_emirate() == null) ? ""
										: BRF32.getR24_emirate().toString();
								R24cell3.setCellValue(value);
							}
							Cell R24cell4 = row24.getCell(5);
							if (R24cell4 != null) {
								R24cell4.setCellValue(BRF32.getR24_outstanding_amount() == null ? 0
										: BRF32.getR24_outstanding_amount().intValue());
							}
							Cell R24cell5 = row24.getCell(6);
							if (R24cell5 != null) {
								R24cell5.setCellValue(BRF32.getR24_stage3_provisions() == null ? 0
										: BRF32.getR24_stage3_provisions().intValue());
							}
							Cell R24cell6 = row24.getCell(7);
							if (R24cell6 != null) {
								R24cell6.setCellValue(BRF32.getR24_stage2_provisions() == null ? 0
										: BRF32.getR24_stage2_provisions().intValue());
							}
							Cell R24cell7 = row24.getCell(8);
							if (R24cell7 != null) {
								String value = (BRF32.getR24_legal_case() == null) ? ""
										: BRF32.getR24_legal_case().toString();
								R24cell7.setCellValue(value);
							}
							Cell R24cell8 = row24.getCell(9);
							if (R24cell8 != null) {
								String value = (BRF32.getR24_remarks() == null) ? ""
										: BRF32.getR24_remarks().toString();
								R24cell8.setCellValue(value);
							}
							/// row25
							Row row25 = sheet.getRow(33);
							Cell R25cell1 = row25.getCell(2);
							if (R25cell1 != null) {
								String value = (BRF32.getR25_borrower_name() == null) ? ""
										: BRF32.getR25_borrower_name().toString();
								R25cell1.setCellValue(value);
							}
							Cell R25cell2 = row25.getCell(3);
							if (R25cell2 != null) {
								String value = (BRF32.getR25_group_name() == null) ? ""
										: BRF32.getR25_group_name().toString();
								R25cell2.setCellValue(value);
							}
							Cell R25cell3 = row25.getCell(4);
							if (R25cell3 != null) {
								String value = (BRF32.getR25_emirate() == null) ? ""
										: BRF32.getR25_emirate().toString();
								R25cell3.setCellValue(value);
							}
							Cell R25cell4 = row25.getCell(5);
							if (R25cell4 != null) {
								R25cell4.setCellValue(BRF32.getR25_outstanding_amount() == null ? 0
										: BRF32.getR25_outstanding_amount().intValue());
							}
							Cell R25cell5 = row25.getCell(6);
							if (R25cell5 != null) {
								R25cell5.setCellValue(BRF32.getR25_stage3_provisions() == null ? 0
										: BRF32.getR25_stage3_provisions().intValue());
							}
							Cell R25cell6 = row25.getCell(7);
							if (R25cell6 != null) {
								R25cell6.setCellValue(BRF32.getR25_stage2_provisions() == null ? 0
										: BRF32.getR25_stage2_provisions().intValue());
							}
							Cell R25cell7 = row25.getCell(8);
							if (R25cell7 != null) {
								String value = (BRF32.getR25_legal_case() == null) ? ""
										: BRF32.getR25_legal_case().toString();
								R25cell7.setCellValue(value);
							}
							Cell R25cell8 = row25.getCell(9);
							if (R25cell8 != null) {
								String value = (BRF32.getR25_remarks() == null) ? ""
										: BRF32.getR25_remarks().toString();
								R25cell8.setCellValue(value);
							}
							/// row26
							Row row26 = sheet.getRow(34);
							Cell R26cell1 = row26.getCell(2);
							if (R26cell1 != null) {
								String value = (BRF32.getR26_borrower_name() == null) ? ""
										: BRF32.getR26_borrower_name().toString();
								R26cell1.setCellValue(value);
							}
							Cell R26cell2 = row26.getCell(3);
							if (R26cell2 != null) {
								String value = (BRF32.getR26_group_name() == null) ? ""
										: BRF32.getR26_group_name().toString();
								R26cell2.setCellValue(value);
							}
							Cell R26cell3 = row26.getCell(4);
							if (R26cell3 != null) {
								String value = (BRF32.getR26_emirate() == null) ? ""
										: BRF32.getR26_emirate().toString();
								R26cell3.setCellValue(value);
							}
							Cell R26cell4 = row26.getCell(5);
							if (R26cell4 != null) {
								R26cell4.setCellValue(BRF32.getR26_outstanding_amount() == null ? 0
										: BRF32.getR26_outstanding_amount().intValue());
							}
							Cell R26cell5 = row26.getCell(6);
							if (R26cell5 != null) {
								R26cell5.setCellValue(BRF32.getR26_stage3_provisions() == null ? 0
										: BRF32.getR26_stage3_provisions().intValue());
							}
							Cell R26cell6 = row26.getCell(7);
							if (R26cell6 != null) {
								R26cell6.setCellValue(BRF32.getR26_stage2_provisions() == null ? 0
										: BRF32.getR26_stage2_provisions().intValue());
							}
							Cell R26cell7 = row26.getCell(8);
							if (R26cell7 != null) {
								String value = (BRF32.getR26_legal_case() == null) ? ""
										: BRF32.getR26_legal_case().toString();
								R26cell7.setCellValue(value);
							}
							Cell R26cell8 = row26.getCell(9);
							if (R26cell8 != null) {
								String value = (BRF32.getR26_remarks() == null) ? ""
										: BRF32.getR26_remarks().toString();
								R26cell8.setCellValue(value);
							}
							/// row27
							Row row27 = sheet.getRow(35);
							Cell R27cell1 = row27.getCell(2);
							if (R27cell1 != null) {
								String value = (BRF32.getR27_borrower_name() == null) ? ""
										: BRF32.getR27_borrower_name().toString();
								R27cell1.setCellValue(value);
							}
							Cell R27cell2 = row27.getCell(3);
							if (R27cell2 != null) {
								String value = (BRF32.getR27_group_name() == null) ? ""
										: BRF32.getR27_group_name().toString();
								R27cell2.setCellValue(value);
							}
							Cell R27cell3 = row27.getCell(4);
							if (R27cell3 != null) {
								String value = (BRF32.getR27_emirate() == null) ? ""
										: BRF32.getR27_emirate().toString();
								R27cell3.setCellValue(value);
							}
							Cell R27cell4 = row27.getCell(5);
							if (R27cell4 != null) {
								R27cell4.setCellValue(BRF32.getR27_outstanding_amount() == null ? 0
										: BRF32.getR27_outstanding_amount().intValue());
							}
							Cell R27cell5 = row27.getCell(6);
							if (R27cell5 != null) {
								R27cell5.setCellValue(BRF32.getR27_stage3_provisions() == null ? 0
										: BRF32.getR27_stage3_provisions().intValue());
							}
							Cell R27cell6 = row27.getCell(7);
							if (R27cell6 != null) {
								R27cell6.setCellValue(BRF32.getR27_stage2_provisions() == null ? 0
										: BRF32.getR27_stage2_provisions().intValue());
							}
							Cell R27cell7 = row27.getCell(8);
							if (R27cell7 != null) {
								String value = (BRF32.getR27_legal_case() == null) ? ""
										: BRF32.getR27_legal_case().toString();
								R27cell7.setCellValue(value);
							}
							Cell R27cell8 = row27.getCell(9);
							if (R27cell8 != null) {
								String value = (BRF32.getR27_remarks() == null) ? ""
										: BRF32.getR27_remarks().toString();
								R27cell8.setCellValue(value);
							}
							/// row28
							Row row28 = sheet.getRow(36);
							Cell R28cell1 = row28.getCell(2);
							if (R28cell1 != null) {
								String value = (BRF32.getR28_borrower_name() == null) ? ""
										: BRF32.getR28_borrower_name().toString();
								R28cell1.setCellValue(value);
							}
							Cell R28cell2 = row28.getCell(3);
							if (R28cell2 != null) {
								String value = (BRF32.getR28_group_name() == null) ? ""
										: BRF32.getR28_group_name().toString();
								R28cell2.setCellValue(value);
							}
							Cell R28cell3 = row28.getCell(4);
							if (R28cell3 != null) {
								String value = (BRF32.getR28_emirate() == null) ? ""
										: BRF32.getR28_emirate().toString();
								R28cell3.setCellValue(value);
							}
							Cell R28cell4 = row28.getCell(5);
							if (R28cell4 != null) {
								R28cell4.setCellValue(BRF32.getR28_outstanding_amount() == null ? 0
										: BRF32.getR28_outstanding_amount().intValue());
							}
							Cell R28cell5 = row28.getCell(6);
							if (R28cell5 != null) {
								R28cell5.setCellValue(BRF32.getR28_stage3_provisions() == null ? 0
										: BRF32.getR28_stage3_provisions().intValue());
							}
							Cell R28cell6 = row28.getCell(7);
							if (R28cell6 != null) {
								R28cell6.setCellValue(BRF32.getR28_stage2_provisions() == null ? 0
										: BRF32.getR28_stage2_provisions().intValue());
							}
							Cell R28cell7 = row28.getCell(8);
							if (R28cell7 != null) {
								String value = (BRF32.getR28_legal_case() == null) ? ""
										: BRF32.getR28_legal_case().toString();
								R28cell7.setCellValue(value);
							}
							Cell R28cell8 = row28.getCell(9);
							if (R28cell8 != null) {
								String value = (BRF32.getR28_remarks() == null) ? ""
										: BRF32.getR28_remarks().toString();
								R28cell8.setCellValue(value);
							}

							/// row29
							Row row29 = sheet.getRow(37);
							Cell R29cell1 = row29.getCell(2);
							if (R29cell1 != null) {
								String value = (BRF32.getR29_borrower_name() == null) ? ""
										: BRF32.getR29_borrower_name().toString();
								R29cell1.setCellValue(value);
							}
							Cell R29cell2 = row29.getCell(3);
							if (R29cell2 != null) {
								String value = (BRF32.getR29_group_name() == null) ? ""
										: BRF32.getR29_group_name().toString();
								R29cell2.setCellValue(value);
							}
							Cell R29cell3 = row29.getCell(4);
							if (R29cell3 != null) {
								String value = (BRF32.getR29_emirate() == null) ? ""
										: BRF32.getR29_emirate().toString();
								R29cell3.setCellValue(value);
							}
							Cell R29cell4 = row29.getCell(5);
							if (R29cell4 != null) {
								R29cell4.setCellValue(BRF32.getR29_outstanding_amount() == null ? 0
										: BRF32.getR29_outstanding_amount().intValue());
							}
							Cell R29cell5 = row29.getCell(6);
							if (R29cell5 != null) {
								R29cell5.setCellValue(BRF32.getR29_stage3_provisions() == null ? 0
										: BRF32.getR29_stage3_provisions().intValue());
							}
							Cell R29cell6 = row29.getCell(7);
							if (R29cell6 != null) {
								R29cell6.setCellValue(BRF32.getR29_stage2_provisions() == null ? 0
										: BRF32.getR29_stage2_provisions().intValue());
							}
							Cell R29cell7 = row29.getCell(8);
							if (R29cell7 != null) {
								String value = (BRF32.getR29_legal_case() == null) ? ""
										: BRF32.getR29_legal_case().toString();
								R29cell7.setCellValue(value);
							}
							Cell R29cell8 = row29.getCell(9);
							if (R29cell8 != null) {
								String value = (BRF32.getR29_remarks() == null) ? ""
										: BRF32.getR29_remarks().toString();
								R29cell8.setCellValue(value);
							}
							/// row30
							Row row30 = sheet.getRow(38);
							Cell R30cell1 = row30.getCell(2);
							if (R30cell1 != null) {
								String value = (BRF32.getR30_borrower_name() == null) ? ""
										: BRF32.getR30_borrower_name().toString();
								R30cell1.setCellValue(value);
							}
							Cell R30cell2 = row30.getCell(3);
							if (R30cell2 != null) {
								String value = (BRF32.getR30_group_name() == null) ? ""
										: BRF32.getR30_group_name().toString();
								R30cell2.setCellValue(value);
							}
							Cell R30cell3 = row30.getCell(4);
							if (R30cell3 != null) {
								String value = (BRF32.getR30_emirate() == null) ? ""
										: BRF32.getR30_emirate().toString();
								R30cell3.setCellValue(value);
							}
							Cell R30cell4 = row30.getCell(5);
							if (R30cell4 != null) {
								R30cell4.setCellValue(BRF32.getR30_outstanding_amount() == null ? 0
										: BRF32.getR30_outstanding_amount().intValue());
							}
							Cell R30cell5 = row30.getCell(6);
							if (R30cell5 != null) {
								R30cell5.setCellValue(BRF32.getR30_stage3_provisions() == null ? 0
										: BRF32.getR30_stage3_provisions().intValue());
							}
							Cell R30cell6 = row30.getCell(7);
							if (R30cell6 != null) {
								R30cell6.setCellValue(BRF32.getR30_stage2_provisions() == null ? 0
										: BRF32.getR30_stage2_provisions().intValue());
							}
							Cell R30cell7 = row30.getCell(8);
							if (R30cell7 != null) {
								String value = (BRF32.getR30_legal_case() == null) ? ""
										: BRF32.getR30_legal_case().toString();
								R30cell7.setCellValue(value);
							}
							Cell R30cell8 = row30.getCell(9);
							if (R30cell8 != null) {
								String value = (BRF32.getR30_remarks() == null) ? ""
										: BRF32.getR30_remarks().toString();
								R30cell8.setCellValue(value);
							}
							/// row31
							Row row31 = sheet.getRow(39);
							Cell R31cell1 = row31.getCell(2);
							if (R31cell1 != null) {
								String value = (BRF32.getR31_borrower_name() == null) ? ""
										: BRF32.getR31_borrower_name().toString();
								R31cell1.setCellValue(value);
							}
							Cell R31cell2 = row31.getCell(3);
							if (R31cell2 != null) {
								String value = (BRF32.getR31_group_name() == null) ? ""
										: BRF32.getR31_group_name().toString();
								R31cell2.setCellValue(value);
							}
							Cell R31cell3 = row31.getCell(4);
							if (R31cell3 != null) {
								String value = (BRF32.getR31_emirate() == null) ? ""
										: BRF32.getR31_emirate().toString();
								R31cell3.setCellValue(value);
							}
							Cell R31cell4 = row31.getCell(5);
							if (R31cell4 != null) {
								R31cell4.setCellValue(BRF32.getR31_outstanding_amount() == null ? 0
										: BRF32.getR31_outstanding_amount().intValue());
							}
							Cell R31cell5 = row31.getCell(6);
							if (R31cell5 != null) {
								R31cell5.setCellValue(BRF32.getR31_stage3_provisions() == null ? 0
										: BRF32.getR31_stage3_provisions().intValue());
							}
							Cell R31cell6 = row31.getCell(7);
							if (R31cell6 != null) {
								R31cell6.setCellValue(BRF32.getR31_stage2_provisions() == null ? 0
										: BRF32.getR31_stage2_provisions().intValue());
							}
							Cell R31cell7 = row31.getCell(8);
							if (R31cell7 != null) {
								String value = (BRF32.getR31_legal_case() == null) ? ""
										: BRF32.getR31_legal_case().toString();
								R31cell7.setCellValue(value);
							}
							Cell R31cell8 = row31.getCell(9);
							if (R31cell8 != null) {
								String value = (BRF32.getR31_remarks() == null) ? ""
										: BRF32.getR31_remarks().toString();
								R31cell8.setCellValue(value);
							}
							/// row33
							Row row33 = sheet.getRow(42);
							Cell R33cell1 = row33.getCell(2);
							if (R33cell1 != null) {
								String value = (BRF32.getR33_borrower_name() == null) ? ""
										: BRF32.getR33_borrower_name().toString();
								R33cell1.setCellValue(value);
							}
							Cell R33cell2 = row33.getCell(3);
							if (R33cell2 != null) {
								String value = (BRF32.getR33_group_name() == null) ? ""
										: BRF32.getR33_group_name().toString();
								R33cell2.setCellValue(value);
							}
							Cell R33cell3 = row33.getCell(4);
							if (R33cell3 != null) {
								String value = (BRF32.getR33_emirate() == null) ? ""
										: BRF32.getR33_emirate().toString();
								R33cell3.setCellValue(value);
							}
							Cell R33cell4 = row33.getCell(5);
							if (R33cell4 != null) {
								R33cell4.setCellValue(BRF32.getR33_outstanding_amount() == null ? 0
										: BRF32.getR33_outstanding_amount().intValue());
							}
							Cell R33cell5 = row33.getCell(6);
							if (R33cell5 != null) {
								R33cell5.setCellValue(BRF32.getR33_stage3_provisions() == null ? 0
										: BRF32.getR33_stage3_provisions().intValue());
							}
							Cell R33cell6 = row33.getCell(7);
							if (R33cell6 != null) {
								R33cell6.setCellValue(BRF32.getR33_stage2_provisions() == null ? 0
										: BRF32.getR33_stage2_provisions().intValue());
							}
							Cell R33cell7 = row33.getCell(8);
							if (R33cell7 != null) {
								String value = (BRF32.getR33_legal_case() == null) ? ""
										: BRF32.getR33_legal_case().toString();
								R33cell7.setCellValue(value);
							}
							Cell R33cell8 = row33.getCell(9);
							if (R33cell8 != null) {
								String value = (BRF32.getR33_remarks() == null) ? ""
										: BRF32.getR33_remarks().toString();
								R33cell8.setCellValue(value);
							}
							/// row34
							Row row34 = sheet.getRow(43);
							Cell R34cell1 = row34.getCell(2);
							if (R34cell1 != null) {
								String value = (BRF32.getR34_borrower_name() == null) ? ""
										: BRF32.getR34_borrower_name().toString();
								R34cell1.setCellValue(value);
							}
							Cell R34cell2 = row34.getCell(3);
							if (R34cell2 != null) {
								String value = (BRF32.getR34_group_name() == null) ? ""
										: BRF32.getR34_group_name().toString();
								R34cell2.setCellValue(value);
							}
							Cell R34cell3 = row34.getCell(4);
							if (R34cell3 != null) {
								String value = (BRF32.getR34_emirate() == null) ? ""
										: BRF32.getR34_emirate().toString();
								R34cell3.setCellValue(value);
							}
							Cell R34cell4 = row34.getCell(5);
							if (R34cell4 != null) {
								R34cell4.setCellValue(BRF32.getR34_outstanding_amount() == null ? 0
										: BRF32.getR34_outstanding_amount().intValue());
							}
							Cell R34cell5 = row34.getCell(6);
							if (R34cell5 != null) {
								R34cell5.setCellValue(BRF32.getR34_stage3_provisions() == null ? 0
										: BRF32.getR34_stage3_provisions().intValue());
							}
							Cell R34cell6 = row34.getCell(7);
							if (R34cell6 != null) {
								R34cell6.setCellValue(BRF32.getR34_stage2_provisions() == null ? 0
										: BRF32.getR34_stage2_provisions().intValue());
							}
							Cell R34cell7 = row34.getCell(8);
							if (R34cell7 != null) {
								String value = (BRF32.getR34_legal_case() == null) ? ""
										: BRF32.getR34_legal_case().toString();
								R34cell7.setCellValue(value);
							}
							Cell R34cell8 = row34.getCell(9);
							if (R34cell8 != null) {
								String value = (BRF32.getR34_remarks() == null) ? ""
										: BRF32.getR34_remarks().toString();
								R34cell8.setCellValue(value);
							}
							/// row35
							Row row35 = sheet.getRow(44);
							Cell R35cell1 = row35.getCell(2);
							if (R35cell1 != null) {
								String value = (BRF32.getR35_borrower_name() == null) ? ""
										: BRF32.getR35_borrower_name().toString();
								R35cell1.setCellValue(value);
							}
							Cell R35cell2 = row35.getCell(3);
							if (R35cell2 != null) {
								String value = (BRF32.getR35_group_name() == null) ? ""
										: BRF32.getR35_group_name().toString();
								R35cell2.setCellValue(value);
							}
							Cell R35cell3 = row35.getCell(4);
							if (R35cell3 != null) {
								String value = (BRF32.getR35_emirate() == null) ? ""
										: BRF32.getR35_emirate().toString();
								R35cell3.setCellValue(value);
							}
							Cell R35cell4 = row35.getCell(5);
							if (R35cell4 != null) {
								R35cell4.setCellValue(BRF32.getR35_outstanding_amount() == null ? 0
										: BRF32.getR35_outstanding_amount().intValue());
							}
							Cell R35cell5 = row35.getCell(6);
							if (R35cell5 != null) {
								R35cell5.setCellValue(BRF32.getR35_stage3_provisions() == null ? 0
										: BRF32.getR35_stage3_provisions().intValue());
							}
							Cell R35cell6 = row35.getCell(7);
							if (R35cell6 != null) {
								R35cell6.setCellValue(BRF32.getR35_stage2_provisions() == null ? 0
										: BRF32.getR35_stage2_provisions().intValue());
							}
							Cell R35cell7 = row35.getCell(8);
							if (R35cell7 != null) {
								String value = (BRF32.getR35_legal_case() == null) ? ""
										: BRF32.getR35_legal_case().toString();
								R35cell7.setCellValue(value);
							}
							Cell R35cell8 = row35.getCell(9);
							if (R35cell8 != null) {
								String value = (BRF32.getR35_remarks() == null) ? ""
										: BRF32.getR35_remarks().toString();
								R35cell8.setCellValue(value);
							}
							/// row36
							Row row36 = sheet.getRow(45);
							Cell R36cell1 = row36.getCell(2);
							if (R36cell1 != null) {
								String value = (BRF32.getR36_borrower_name() == null) ? ""
										: BRF32.getR36_borrower_name().toString();
								R36cell1.setCellValue(value);
							}
							Cell R36cell2 = row36.getCell(3);
							if (R36cell2 != null) {
								String value = (BRF32.getR36_group_name() == null) ? ""
										: BRF32.getR36_group_name().toString();
								R36cell2.setCellValue(value);
							}
							Cell R36cell3 = row36.getCell(4);
							if (R36cell3 != null) {
								String value = (BRF32.getR36_emirate() == null) ? ""
										: BRF32.getR36_emirate().toString();
								R36cell3.setCellValue(value);
							}
							Cell R36cell4 = row36.getCell(5);
							if (R36cell4 != null) {
								R36cell4.setCellValue(BRF32.getR36_outstanding_amount() == null ? 0
										: BRF32.getR36_outstanding_amount().intValue());
							}
							Cell R36cell5 = row36.getCell(6);
							if (R36cell5 != null) {
								R36cell5.setCellValue(BRF32.getR36_stage3_provisions() == null ? 0
										: BRF32.getR36_stage3_provisions().intValue());
							}
							Cell R36cell6 = row36.getCell(7);
							if (R36cell6 != null) {
								R36cell6.setCellValue(BRF32.getR36_stage2_provisions() == null ? 0
										: BRF32.getR36_stage2_provisions().intValue());
							}
							Cell R36cell7 = row36.getCell(8);
							if (R36cell7 != null) {
								String value = (BRF32.getR36_legal_case() == null) ? ""
										: BRF32.getR36_legal_case().toString();
								R36cell7.setCellValue(value);
							}
							Cell R36cell8 = row36.getCell(9);
							if (R36cell8 != null) {
								String value = (BRF32.getR36_remarks() == null) ? ""
										: BRF32.getR36_remarks().toString();
								R36cell8.setCellValue(value);
							}
							/// row37
							Row row37 = sheet.getRow(46);
							Cell R37cell1 = row37.getCell(2);
							if (R37cell1 != null) {
								String value = (BRF32.getR37_borrower_name() == null) ? ""
										: BRF32.getR37_borrower_name().toString();
								R37cell1.setCellValue(value);
							}
							Cell R37cell2 = row37.getCell(3);
							if (R37cell2 != null) {
								String value = (BRF32.getR37_group_name() == null) ? ""
										: BRF32.getR37_group_name().toString();
								R37cell2.setCellValue(value);
							}
							Cell R37cell3 = row37.getCell(4);
							if (R37cell3 != null) {
								String value = (BRF32.getR37_emirate() == null) ? ""
										: BRF32.getR37_emirate().toString();
								R37cell3.setCellValue(value);
							}
							Cell R37cell4 = row37.getCell(5);
							if (R37cell4 != null) {
								R37cell4.setCellValue(BRF32.getR37_outstanding_amount() == null ? 0
										: BRF32.getR37_outstanding_amount().intValue());
							}
							Cell R37cell5 = row37.getCell(6);
							if (R37cell5 != null) {
								R37cell5.setCellValue(BRF32.getR37_stage3_provisions() == null ? 0
										: BRF32.getR37_stage3_provisions().intValue());
							}
							Cell R37cell6 = row37.getCell(7);
							if (R37cell6 != null) {
								R37cell6.setCellValue(BRF32.getR37_stage2_provisions() == null ? 0
										: BRF32.getR37_stage2_provisions().intValue());
							}
							Cell R37cell7 = row37.getCell(8);
							if (R37cell7 != null) {
								String value = (BRF32.getR37_legal_case() == null) ? ""
										: BRF32.getR37_legal_case().toString();
								R37cell7.setCellValue(value);
							}
							Cell R37cell8 = row37.getCell(9);
							if (R37cell8 != null) {
								String value = (BRF32.getR37_remarks() == null) ? ""
										: BRF32.getR37_remarks().toString();
								R37cell8.setCellValue(value);
							}
							/// row38
							Row row38 = sheet.getRow(47);
							Cell R38cell1 = row38.getCell(2);
							if (R38cell1 != null) {
								String value = (BRF32.getR38_borrower_name() == null) ? ""
										: BRF32.getR38_borrower_name().toString();
								R38cell1.setCellValue(value);
							}
							Cell R38cell2 = row38.getCell(3);
							if (R38cell2 != null) {
								String value = (BRF32.getR38_group_name() == null) ? ""
										: BRF32.getR38_group_name().toString();
								R38cell2.setCellValue(value);
							}
							Cell R38cell3 = row38.getCell(4);
							if (R38cell3 != null) {
								String value = (BRF32.getR38_emirate() == null) ? ""
										: BRF32.getR38_emirate().toString();
								R38cell3.setCellValue(value);
							}
							Cell R38cell4 = row38.getCell(5);
							if (R38cell4 != null) {
								R38cell4.setCellValue(BRF32.getR38_outstanding_amount() == null ? 0
										: BRF32.getR38_outstanding_amount().intValue());
							}
							Cell R38cell5 = row38.getCell(6);
							if (R38cell5 != null) {
								R38cell5.setCellValue(BRF32.getR38_stage3_provisions() == null ? 0
										: BRF32.getR38_stage3_provisions().intValue());
							}
							Cell R38cell6 = row38.getCell(7);
							if (R38cell6 != null) {
								R38cell6.setCellValue(BRF32.getR38_stage2_provisions() == null ? 0
										: BRF32.getR38_stage2_provisions().intValue());
							}
							Cell R38cell7 = row38.getCell(8);
							if (R38cell7 != null) {
								String value = (BRF32.getR38_legal_case() == null) ? ""
										: BRF32.getR38_legal_case().toString();
								R38cell7.setCellValue(value);
							}
							Cell R38cell8 = row38.getCell(9);
							if (R38cell8 != null) {
								String value = (BRF32.getR38_remarks() == null) ? ""
										: BRF32.getR38_remarks().toString();
								R38cell8.setCellValue(value);
							}
							/// row39
							Row row39 = sheet.getRow(48);
							Cell R39cell1 = row39.getCell(2);
							if (R39cell1 != null) {
								String value = (BRF32.getR39_borrower_name() == null) ? ""
										: BRF32.getR39_borrower_name().toString();
								R39cell1.setCellValue(value);
							}
							Cell R39cell2 = row39.getCell(3);
							if (R39cell2 != null) {
								String value = (BRF32.getR39_group_name() == null) ? ""
										: BRF32.getR39_group_name().toString();
								R39cell2.setCellValue(value);
							}
							Cell R39cell3 = row39.getCell(4);
							if (R39cell3 != null) {
								String value = (BRF32.getR39_emirate() == null) ? ""
										: BRF32.getR39_emirate().toString();
								R39cell3.setCellValue(value);
							}
							Cell R39cell4 = row39.getCell(5);
							if (R39cell4 != null) {
								R39cell4.setCellValue(BRF32.getR39_outstanding_amount() == null ? 0
										: BRF32.getR39_outstanding_amount().intValue());
							}
							Cell R39cell5 = row39.getCell(6);
							if (R39cell5 != null) {
								R39cell5.setCellValue(BRF32.getR39_stage3_provisions() == null ? 0
										: BRF32.getR39_stage3_provisions().intValue());
							}
							Cell R39cell6 = row39.getCell(7);
							if (R39cell6 != null) {
								R39cell6.setCellValue(BRF32.getR39_stage2_provisions() == null ? 0
										: BRF32.getR39_stage2_provisions().intValue());
							}
							Cell R39cell7 = row39.getCell(8);
							if (R39cell7 != null) {
								String value = (BRF32.getR39_legal_case() == null) ? ""
										: BRF32.getR39_legal_case().toString();
								R39cell7.setCellValue(value);
							}
							Cell R39cell8 = row39.getCell(9);
							if (R39cell8 != null) {
								String value = (BRF32.getR39_remarks() == null) ? ""
										: BRF32.getR39_remarks().toString();
								R39cell8.setCellValue(value);
							}
							/// row40
							Row row40 = sheet.getRow(49);
							Cell R40cell1 = row40.getCell(2);
							if (R40cell1 != null) {
								String value = (BRF32.getR40_borrower_name() == null) ? ""
										: BRF32.getR40_borrower_name().toString();
								R40cell1.setCellValue(value);
							}
							Cell R40cell2 = row40.getCell(3);
							if (R40cell2 != null) {
								String value = (BRF32.getR40_group_name() == null) ? ""
										: BRF32.getR40_group_name().toString();
								R40cell2.setCellValue(value);
							}
							Cell R40cell3 = row40.getCell(4);
							if (R40cell3 != null) {
								String value = (BRF32.getR40_emirate() == null) ? ""
										: BRF32.getR40_emirate().toString();
								R40cell3.setCellValue(value);
							}
							Cell R40cell4 = row40.getCell(5);
							if (R40cell4 != null) {
								R40cell4.setCellValue(BRF32.getR40_outstanding_amount() == null ? 0
										: BRF32.getR40_outstanding_amount().intValue());
							}
							Cell R40cell5 = row40.getCell(6);
							if (R40cell5 != null) {
								R40cell5.setCellValue(BRF32.getR40_stage3_provisions() == null ? 0
										: BRF32.getR40_stage3_provisions().intValue());
							}
							Cell R40cell6 = row40.getCell(7);
							if (R40cell6 != null) {
								R40cell6.setCellValue(BRF32.getR40_stage2_provisions() == null ? 0
										: BRF32.getR40_stage2_provisions().intValue());
							}
							Cell R40cell7 = row40.getCell(8);
							if (R40cell7 != null) {
								String value = (BRF32.getR40_legal_case() == null) ? ""
										: BRF32.getR40_legal_case().toString();
								R40cell7.setCellValue(value);
							}
							Cell R40cell8 = row40.getCell(9);
							if (R40cell8 != null) {
								String value = (BRF32.getR40_remarks() == null) ? ""
										: BRF32.getR40_remarks().toString();
								R40cell8.setCellValue(value);
							}
							/// row41
							Row row41 = sheet.getRow(50);
							Cell R41cell1 = row41.getCell(2);
							if (R41cell1 != null) {
								String value = (BRF32.getR41_borrower_name() == null) ? ""
										: BRF32.getR41_borrower_name().toString();
								R41cell1.setCellValue(value);
							}
							Cell R41cell2 = row41.getCell(3);
							if (R41cell2 != null) {
								String value = (BRF32.getR41_group_name() == null) ? ""
										: BRF32.getR41_group_name().toString();
								R41cell2.setCellValue(value);
							}
							Cell R41cell3 = row41.getCell(4);
							if (R41cell3 != null) {
								String value = (BRF32.getR41_emirate() == null) ? ""
										: BRF32.getR41_emirate().toString();
								R41cell3.setCellValue(value);
							}
							Cell R41cell4 = row41.getCell(5);
							if (R41cell4 != null) {
								R41cell4.setCellValue(BRF32.getR41_outstanding_amount() == null ? 0
										: BRF32.getR41_outstanding_amount().intValue());
							}
							Cell R41cell5 = row41.getCell(6);
							if (R41cell5 != null) {
								R41cell5.setCellValue(BRF32.getR41_stage3_provisions() == null ? 0
										: BRF32.getR41_stage3_provisions().intValue());
							}
							Cell R41cell6 = row41.getCell(7);
							if (R41cell6 != null) {
								R41cell6.setCellValue(BRF32.getR41_stage2_provisions() == null ? 0
										: BRF32.getR41_stage2_provisions().intValue());
							}
							Cell R41cell7 = row41.getCell(8);
							if (R41cell7 != null) {
								String value = (BRF32.getR41_legal_case() == null) ? ""
										: BRF32.getR41_legal_case().toString();
								R41cell7.setCellValue(value);
							}
							Cell R41cell8 = row41.getCell(9);
							if (R41cell8 != null) {
								String value = (BRF32.getR41_remarks() == null) ? ""
										: BRF32.getR41_remarks().toString();
								R41cell8.setCellValue(value);
							}
							/// row42
							Row row42 = sheet.getRow(51);
							Cell R42cell1 = row42.getCell(2);
							if (R42cell1 != null) {
								String value = (BRF32.getR42_borrower_name() == null) ? ""
										: BRF32.getR42_borrower_name().toString();
								R42cell1.setCellValue(value);
							}
							Cell R42cell2 = row42.getCell(3);
							if (R42cell2 != null) {
								String value = (BRF32.getR42_group_name() == null) ? ""
										: BRF32.getR42_group_name().toString();
								R42cell2.setCellValue(value);
							}
							Cell R42cell3 = row42.getCell(4);
							if (R42cell3 != null) {
								String value = (BRF32.getR42_emirate() == null) ? ""
										: BRF32.getR42_emirate().toString();
								R42cell3.setCellValue(value);
							}
							Cell R42cell4 = row42.getCell(5);
							if (R42cell4 != null) {
								R42cell4.setCellValue(BRF32.getR42_outstanding_amount() == null ? 0
										: BRF32.getR42_outstanding_amount().intValue());
							}
							Cell R42cell5 = row42.getCell(6);
							if (R42cell5 != null) {
								R42cell5.setCellValue(BRF32.getR42_stage3_provisions() == null ? 0
										: BRF32.getR42_stage3_provisions().intValue());
							}
							Cell R42cell6 = row42.getCell(7);
							if (R42cell6 != null) {
								R42cell6.setCellValue(BRF32.getR42_stage2_provisions() == null ? 0
										: BRF32.getR42_stage2_provisions().intValue());
							}
							Cell R42cell7 = row42.getCell(8);
							if (R42cell7 != null) {
								String value = (BRF32.getR42_legal_case() == null) ? ""
										: BRF32.getR42_legal_case().toString();
								R42cell7.setCellValue(value);
							}
							Cell R42cell8 = row42.getCell(9);
							if (R42cell8 != null) {
								String value = (BRF32.getR42_remarks() == null) ? ""
										: BRF32.getR42_remarks().toString();
								R42cell8.setCellValue(value);
							}
							/// row43
							Row row43 = sheet.getRow(52);
							Cell R43cell1 = row43.getCell(2);
							if (R43cell1 != null) {
								String value = (BRF32.getR43_borrower_name() == null) ? ""
										: BRF32.getR43_borrower_name().toString();
								R43cell1.setCellValue(value);
							}
							Cell R43cell2 = row43.getCell(3);
							if (R43cell2 != null) {
								String value = (BRF32.getR43_group_name() == null) ? ""
										: BRF32.getR43_group_name().toString();
								R43cell2.setCellValue(value);
							}
							Cell R43cell3 = row43.getCell(4);
							if (R43cell3 != null) {
								String value = (BRF32.getR43_emirate() == null) ? ""
										: BRF32.getR43_emirate().toString();
								R43cell3.setCellValue(value);
							}
							Cell R43cell4 = row43.getCell(5);
							if (R43cell4 != null) {
								R43cell4.setCellValue(BRF32.getR43_outstanding_amount() == null ? 0
										: BRF32.getR43_outstanding_amount().intValue());
							}
							Cell R43cell5 = row43.getCell(6);
							if (R43cell5 != null) {
								R43cell5.setCellValue(BRF32.getR43_stage3_provisions() == null ? 0
										: BRF32.getR43_stage3_provisions().intValue());
							}
							Cell R43cell6 = row43.getCell(7);
							if (R43cell6 != null) {
								R43cell6.setCellValue(BRF32.getR43_stage2_provisions() == null ? 0
										: BRF32.getR43_stage2_provisions().intValue());
							}
							Cell R43cell7 = row43.getCell(8);
							if (R43cell7 != null) {
								String value = (BRF32.getR43_legal_case() == null) ? ""
										: BRF32.getR43_legal_case().toString();
								R43cell7.setCellValue(value);
							}
							Cell R43cell8 = row43.getCell(9);
							if (R43cell8 != null) {
								String value = (BRF32.getR43_remarks() == null) ? ""
										: BRF32.getR43_remarks().toString();
								R43cell8.setCellValue(value);
							}
							/// row44
							Row row44 = sheet.getRow(53);
							Cell R44cell1 = row44.getCell(2);
							if (R44cell1 != null) {
								String value = (BRF32.getR44_borrower_name() == null) ? ""
										: BRF32.getR44_borrower_name().toString();
								R44cell1.setCellValue(value);
							}
							Cell R44cell2 = row44.getCell(3);
							if (R44cell2 != null) {
								String value = (BRF32.getR44_group_name() == null) ? ""
										: BRF32.getR44_group_name().toString();
								R44cell2.setCellValue(value);
							}
							Cell R44cell3 = row44.getCell(4);
							if (R44cell3 != null) {
								String value = (BRF32.getR44_emirate() == null) ? ""
										: BRF32.getR44_emirate().toString();
								R44cell3.setCellValue(value);
							}
							Cell R44cell4 = row44.getCell(5);
							if (R44cell4 != null) {
								R44cell4.setCellValue(BRF32.getR44_outstanding_amount() == null ? 0
										: BRF32.getR44_outstanding_amount().intValue());
							}
							Cell R44cell5 = row44.getCell(6);
							if (R44cell5 != null) {
								R44cell5.setCellValue(BRF32.getR44_stage3_provisions() == null ? 0
										: BRF32.getR44_stage3_provisions().intValue());
							}
							Cell R44cell6 = row44.getCell(7);
							if (R44cell6 != null) {
								R44cell6.setCellValue(BRF32.getR44_stage2_provisions() == null ? 0
										: BRF32.getR44_stage2_provisions().intValue());
							}
							Cell R44cell7 = row44.getCell(8);
							if (R44cell7 != null) {
								String value = (BRF32.getR44_legal_case() == null) ? ""
										: BRF32.getR44_legal_case().toString();
								R44cell7.setCellValue(value);
							}
							Cell R44cell8 = row44.getCell(9);
							if (R44cell8 != null) {
								String value = (BRF32.getR44_remarks() == null) ? ""
										: BRF32.getR44_remarks().toString();
								R44cell8.setCellValue(value);
							}
							/// row45
							Row row45 = sheet.getRow(54);
							Cell R45cell1 = row45.getCell(2);
							if (R45cell1 != null) {
								String value = (BRF32.getR45_borrower_name() == null) ? ""
										: BRF32.getR45_borrower_name().toString();
								R45cell1.setCellValue(value);
							}
							Cell R45cell2 = row45.getCell(3);
							if (R45cell2 != null) {
								String value = (BRF32.getR45_group_name() == null) ? ""
										: BRF32.getR45_group_name().toString();
								R45cell2.setCellValue(value);
							}
							Cell R45cell3 = row45.getCell(4);
							if (R45cell3 != null) {
								String value = (BRF32.getR45_emirate() == null) ? ""
										: BRF32.getR45_emirate().toString();
								R45cell3.setCellValue(value);
							}
							Cell R45cell4 = row45.getCell(5);
							if (R45cell4 != null) {
								R45cell4.setCellValue(BRF32.getR45_outstanding_amount() == null ? 0
										: BRF32.getR45_outstanding_amount().intValue());
							}
							Cell R45cell5 = row45.getCell(6);
							if (R45cell5 != null) {
								R45cell5.setCellValue(BRF32.getR45_stage3_provisions() == null ? 0
										: BRF32.getR45_stage3_provisions().intValue());
							}
							Cell R45cell6 = row45.getCell(7);
							if (R45cell6 != null) {
								R45cell6.setCellValue(BRF32.getR45_stage2_provisions() == null ? 0
										: BRF32.getR45_stage2_provisions().intValue());
							}
							Cell R45cell7 = row45.getCell(8);
							if (R45cell7 != null) {
								String value = (BRF32.getR45_legal_case() == null) ? ""
										: BRF32.getR45_legal_case().toString();
								R45cell7.setCellValue(value);
							}
							Cell R45cell8 = row45.getCell(9);
							if (R45cell8 != null) {
								String value = (BRF32.getR45_remarks() == null) ? ""
										: BRF32.getR45_remarks().toString();
								R45cell8.setCellValue(value);
							}
							/// row46
							Row row46 = sheet.getRow(55);
							Cell R46cell1 = row46.getCell(2);
							if (R46cell1 != null) {
								String value = (BRF32.getR46_borrower_name() == null) ? ""
										: BRF32.getR46_borrower_name().toString();
								R46cell1.setCellValue(value);
							}
							Cell R46cell2 = row46.getCell(3);
							if (R46cell2 != null) {
								String value = (BRF32.getR46_group_name() == null) ? ""
										: BRF32.getR46_group_name().toString();
								R46cell2.setCellValue(value);
							}
							Cell R46cell3 = row46.getCell(4);
							if (R46cell3 != null) {
								String value = (BRF32.getR46_emirate() == null) ? ""
										: BRF32.getR46_emirate().toString();
								R46cell3.setCellValue(value);
							}
							Cell R46cell4 = row46.getCell(5);
							if (R46cell4 != null) {
								R46cell4.setCellValue(BRF32.getR46_outstanding_amount() == null ? 0
										: BRF32.getR46_outstanding_amount().intValue());
							}
							Cell R46cell5 = row46.getCell(6);
							if (R46cell5 != null) {
								R46cell5.setCellValue(BRF32.getR46_stage3_provisions() == null ? 0
										: BRF32.getR46_stage3_provisions().intValue());
							}
							Cell R46cell6 = row46.getCell(7);
							if (R46cell6 != null) {
								R46cell6.setCellValue(BRF32.getR46_stage2_provisions() == null ? 0
										: BRF32.getR46_stage2_provisions().intValue());
							}
							Cell R46cell7 = row46.getCell(8);
							if (R46cell7 != null) {
								String value = (BRF32.getR46_legal_case() == null) ? ""
										: BRF32.getR46_legal_case().toString();
								R46cell7.setCellValue(value);
							}
							Cell R46cell8 = row46.getCell(9);
							if (R46cell8 != null) {
								String value = (BRF32.getR46_remarks() == null) ? ""
										: BRF32.getR46_remarks().toString();
								R46cell8.setCellValue(value);
							}
							/// row47
							Row row47 = sheet.getRow(56);
							Cell R47cell1 = row47.getCell(2);
							if (R47cell1 != null) {
								String value = (BRF32.getR47_borrower_name() == null) ? ""
										: BRF32.getR47_borrower_name().toString();
								R47cell1.setCellValue(value);
							}
							Cell R47cell2 = row47.getCell(3);
							if (R47cell2 != null) {
								String value = (BRF32.getR47_group_name() == null) ? ""
										: BRF32.getR47_group_name().toString();
								R47cell2.setCellValue(value);
							}
							Cell R47cell3 = row47.getCell(4);
							if (R47cell3 != null) {
								String value = (BRF32.getR47_emirate() == null) ? ""
										: BRF32.getR47_emirate().toString();
								R47cell3.setCellValue(value);
							}
							Cell R47cell4 = row47.getCell(5);
							if (R47cell4 != null) {
								R47cell4.setCellValue(BRF32.getR47_outstanding_amount() == null ? 0
										: BRF32.getR47_outstanding_amount().intValue());
							}
							Cell R47cell5 = row47.getCell(6);
							if (R47cell5 != null) {
								R47cell5.setCellValue(BRF32.getR47_stage3_provisions() == null ? 0
										: BRF32.getR47_stage3_provisions().intValue());
							}
							Cell R47cell6 = row47.getCell(7);
							if (R47cell6 != null) {
								R47cell6.setCellValue(BRF32.getR47_stage2_provisions() == null ? 0
										: BRF32.getR47_stage2_provisions().intValue());
							}
							Cell R47cell7 = row47.getCell(8);
							if (R47cell7 != null) {
								String value = (BRF32.getR47_legal_case() == null) ? ""
										: BRF32.getR47_legal_case().toString();
								R47cell7.setCellValue(value);
							}
							Cell R47cell8 = row47.getCell(9);
							if (R47cell8 != null) {
								String value = (BRF32.getR47_remarks() == null) ? ""
										: BRF32.getR47_remarks().toString();
								R47cell8.setCellValue(value);
							}
							/// row49
							Row row49 = sheet.getRow(59);
							Cell R49cell1 = row49.getCell(2);
							if (R49cell1 != null) {
								String value = (BRF32.getR49_borrower_name() == null) ? ""
										: BRF32.getR49_borrower_name().toString();
								R49cell1.setCellValue(value);
							}
							Cell R49cell2 = row49.getCell(3);
							if (R49cell2 != null) {
								String value = (BRF32.getR49_group_name() == null) ? ""
										: BRF32.getR49_group_name().toString();
								R49cell2.setCellValue(value);
							}
							Cell R49cell3 = row49.getCell(4);
							if (R49cell3 != null) {
								String value = (BRF32.getR49_emirate() == null) ? ""
										: BRF32.getR49_emirate().toString();
								R49cell3.setCellValue(value);
							}
							Cell R49cell4 = row49.getCell(5);
							if (R49cell4 != null) {
								R49cell4.setCellValue(BRF32.getR49_outstanding_amount() == null ? 0
										: BRF32.getR49_outstanding_amount().intValue());
							}
							Cell R49cell5 = row49.getCell(6);
							if (R49cell5 != null) {
								R49cell5.setCellValue(BRF32.getR49_stage3_provisions() == null ? 0
										: BRF32.getR49_stage3_provisions().intValue());
							}
							Cell R49cell6 = row49.getCell(7);
							if (R49cell6 != null) {
								R49cell6.setCellValue(BRF32.getR49_stage2_provisions() == null ? 0
										: BRF32.getR49_stage2_provisions().intValue());
							}
							Cell R49cell7 = row49.getCell(8);
							if (R49cell7 != null) {
								String value = (BRF32.getR49_legal_case() == null) ? ""
										: BRF32.getR49_legal_case().toString();
								R49cell7.setCellValue(value);
							}
							Cell R49cell8 = row49.getCell(9);
							if (R49cell8 != null) {
								String value = (BRF32.getR49_remarks() == null) ? ""
										: BRF32.getR49_remarks().toString();
								R49cell8.setCellValue(value);
							}
							/// row50
							Row row50 = sheet.getRow(60);
							Cell R50cell1 = row50.getCell(2);
							if (R50cell1 != null) {
								String value = (BRF32.getR50_borrower_name() == null) ? ""
										: BRF32.getR50_borrower_name().toString();
								R50cell1.setCellValue(value);
							}
							Cell R50cell2 = row50.getCell(3);
							if (R50cell2 != null) {
								String value = (BRF32.getR50_group_name() == null) ? ""
										: BRF32.getR50_group_name().toString();
								R50cell2.setCellValue(value);
							}
							Cell R50cell3 = row50.getCell(4);
							if (R50cell3 != null) {
								String value = (BRF32.getR50_emirate() == null) ? ""
										: BRF32.getR50_emirate().toString();
								R50cell3.setCellValue(value);
							}
							Cell R50cell4 = row50.getCell(5);
							if (R50cell4 != null) {
								R50cell4.setCellValue(BRF32.getR50_outstanding_amount() == null ? 0
										: BRF32.getR50_outstanding_amount().intValue());
							}
							Cell R50cell5 = row50.getCell(6);
							if (R50cell5 != null) {
								R50cell5.setCellValue(BRF32.getR50_stage3_provisions() == null ? 0
										: BRF32.getR50_stage3_provisions().intValue());
							}
							Cell R50cell6 = row50.getCell(7);
							if (R50cell6 != null) {
								R50cell6.setCellValue(BRF32.getR50_stage2_provisions() == null ? 0
										: BRF32.getR50_stage2_provisions().intValue());
							}
							Cell R50cell7 = row50.getCell(8);
							if (R50cell7 != null) {
								String value = (BRF32.getR50_legal_case() == null) ? ""
										: BRF32.getR50_legal_case().toString();
								R50cell7.setCellValue(value);
							}
							Cell R50cell8 = row50.getCell(9);
							if (R50cell8 != null) {
								String value = (BRF32.getR50_remarks() == null) ? ""
										: BRF32.getR50_remarks().toString();
								R50cell8.setCellValue(value);
							}
							/// row51
							Row row51 = sheet.getRow(61);
							Cell R51cell1 = row51.getCell(2);
							if (R51cell1 != null) {
								String value = (BRF32.getR51_borrower_name() == null) ? ""
										: BRF32.getR51_borrower_name().toString();
								R51cell1.setCellValue(value);
							}
							Cell R51cell2 = row51.getCell(3);
							if (R51cell2 != null) {
								String value = (BRF32.getR51_group_name() == null) ? ""
										: BRF32.getR51_group_name().toString();
								R51cell2.setCellValue(value);
							}
							Cell R51cell3 = row51.getCell(4);
							if (R51cell3 != null) {
								String value = (BRF32.getR51_emirate() == null) ? ""
										: BRF32.getR51_emirate().toString();
								R51cell3.setCellValue(value);
							}
							Cell R51cell4 = row51.getCell(5);
							if (R51cell4 != null) {
								R51cell4.setCellValue(BRF32.getR51_outstanding_amount() == null ? 0
										: BRF32.getR51_outstanding_amount().intValue());
							}
							Cell R51cell5 = row51.getCell(6);
							if (R51cell5 != null) {
								R51cell5.setCellValue(BRF32.getR51_stage3_provisions() == null ? 0
										: BRF32.getR51_stage3_provisions().intValue());
							}
							Cell R51cell6 = row51.getCell(7);
							if (R51cell6 != null) {
								R51cell6.setCellValue(BRF32.getR51_stage2_provisions() == null ? 0
										: BRF32.getR51_stage2_provisions().intValue());
							}
							Cell R51cell7 = row51.getCell(8);
							if (R51cell7 != null) {
								String value = (BRF32.getR51_legal_case() == null) ? ""
										: BRF32.getR51_legal_case().toString();
								R51cell7.setCellValue(value);
							}
							Cell R51cell8 = row51.getCell(9);
							if (R51cell8 != null) {
								String value = (BRF32.getR51_remarks() == null) ? ""
										: BRF32.getR51_remarks().toString();
								R51cell8.setCellValue(value);
							}
							/// row52
							Row row52 = sheet.getRow(62);
							Cell R52cell1 = row52.getCell(2);
							if (R52cell1 != null) {
								String value = (BRF32.getR52_borrower_name() == null) ? ""
										: BRF32.getR52_borrower_name().toString();
								R52cell1.setCellValue(value);
							}
							Cell R52cell2 = row52.getCell(3);
							if (R52cell2 != null) {
								String value = (BRF32.getR52_group_name() == null) ? ""
										: BRF32.getR52_group_name().toString();
								R52cell2.setCellValue(value);
							}
							Cell R52cell3 = row52.getCell(4);
							if (R52cell3 != null) {
								String value = (BRF32.getR52_emirate() == null) ? ""
										: BRF32.getR52_emirate().toString();
								R52cell3.setCellValue(value);
							}
							Cell R52cell4 = row52.getCell(5);
							if (R52cell4 != null) {
								R52cell4.setCellValue(BRF32.getR52_outstanding_amount() == null ? 0
										: BRF32.getR52_outstanding_amount().intValue());
							}
							Cell R52cell5 = row52.getCell(6);
							if (R52cell5 != null) {
								R52cell5.setCellValue(BRF32.getR52_stage3_provisions() == null ? 0
										: BRF32.getR52_stage3_provisions().intValue());
							}
							Cell R52cell6 = row52.getCell(7);
							if (R52cell6 != null) {
								R52cell6.setCellValue(BRF32.getR52_stage2_provisions() == null ? 0
										: BRF32.getR52_stage2_provisions().intValue());
							}
							Cell R52cell7 = row52.getCell(8);
							if (R52cell7 != null) {
								String value = (BRF32.getR52_legal_case() == null) ? ""
										: BRF32.getR52_legal_case().toString();
								R52cell7.setCellValue(value);
							}
							Cell R52cell8 = row52.getCell(9);
							if (R52cell8 != null) {
								String value = (BRF32.getR52_remarks() == null) ? ""
										: BRF32.getR52_remarks().toString();
								R52cell8.setCellValue(value);
							}
							/// row53
							Row row53 = sheet.getRow(63);
							Cell R53cell1 = row53.getCell(2);
							if (R53cell1 != null) {
								String value = (BRF32.getR53_borrower_name() == null) ? ""
										: BRF32.getR53_borrower_name().toString();
								R53cell1.setCellValue(value);
							}
							Cell R53cell2 = row53.getCell(3);
							if (R53cell2 != null) {
								String value = (BRF32.getR53_group_name() == null) ? ""
										: BRF32.getR53_group_name().toString();
								R53cell2.setCellValue(value);
							}
							Cell R53cell3 = row53.getCell(4);
							if (R53cell3 != null) {
								String value = (BRF32.getR53_emirate() == null) ? ""
										: BRF32.getR53_emirate().toString();
								R53cell3.setCellValue(value);
							}
							Cell R53cell4 = row53.getCell(5);
							if (R53cell4 != null) {
								R53cell4.setCellValue(BRF32.getR53_outstanding_amount() == null ? 0
										: BRF32.getR53_outstanding_amount().intValue());
							}
							Cell R53cell5 = row53.getCell(6);
							if (R53cell5 != null) {
								R53cell5.setCellValue(BRF32.getR53_stage3_provisions() == null ? 0
										: BRF32.getR53_stage3_provisions().intValue());
							}
							Cell R53cell6 = row53.getCell(7);
							if (R53cell6 != null) {
								R53cell6.setCellValue(BRF32.getR53_stage2_provisions() == null ? 0
										: BRF32.getR53_stage2_provisions().intValue());
							}
							Cell R53cell7 = row53.getCell(8);
							if (R53cell7 != null) {
								String value = (BRF32.getR53_legal_case() == null) ? ""
										: BRF32.getR53_legal_case().toString();
								R53cell7.setCellValue(value);
							}
							Cell R53cell8 = row53.getCell(9);
							if (R53cell8 != null) {
								String value = (BRF32.getR53_remarks() == null) ? ""
										: BRF32.getR53_remarks().toString();
								R53cell8.setCellValue(value);
							}
							/// row54
							Row row54 = sheet.getRow(64);
							Cell R54cell1 = row54.getCell(2);
							if (R54cell1 != null) {
								String value = (BRF32.getR54_borrower_name() == null) ? ""
										: BRF32.getR54_borrower_name().toString();
								R54cell1.setCellValue(value);
							}
							Cell R54cell2 = row54.getCell(3);
							if (R54cell2 != null) {
								String value = (BRF32.getR54_group_name() == null) ? ""
										: BRF32.getR54_group_name().toString();
								R54cell2.setCellValue(value);
							}
							Cell R54cell3 = row54.getCell(4);
							if (R54cell3 != null) {
								String value = (BRF32.getR54_emirate() == null) ? ""
										: BRF32.getR54_emirate().toString();
								R54cell3.setCellValue(value);
							}
							Cell R54cell4 = row54.getCell(5);
							if (R54cell4 != null) {
								R54cell4.setCellValue(BRF32.getR54_outstanding_amount() == null ? 0
										: BRF32.getR54_outstanding_amount().intValue());
							}
							Cell R54cell5 = row54.getCell(6);
							if (R54cell5 != null) {
								R54cell5.setCellValue(BRF32.getR54_stage3_provisions() == null ? 0
										: BRF32.getR54_stage3_provisions().intValue());
							}
							Cell R54cell6 = row54.getCell(7);
							if (R54cell6 != null) {
								R54cell6.setCellValue(BRF32.getR54_stage2_provisions() == null ? 0
										: BRF32.getR54_stage2_provisions().intValue());
							}
							Cell R54cell7 = row54.getCell(8);
							if (R54cell7 != null) {
								String value = (BRF32.getR54_legal_case() == null) ? ""
										: BRF32.getR54_legal_case().toString();
								R54cell7.setCellValue(value);
							}
							Cell R54cell8 = row54.getCell(9);
							if (R54cell8 != null) {
								String value = (BRF32.getR54_remarks() == null) ? ""
										: BRF32.getR54_remarks().toString();
								R54cell8.setCellValue(value);
							}
							/// row55
							Row row55 = sheet.getRow(65);
							Cell R55cell1 = row55.getCell(2);
							if (R55cell1 != null) {
								String value = (BRF32.getR55_borrower_name() == null) ? ""
										: BRF32.getR55_borrower_name().toString();
								R55cell1.setCellValue(value);
							}
							Cell R55cell2 = row55.getCell(3);
							if (R55cell2 != null) {
								String value = (BRF32.getR55_group_name() == null) ? ""
										: BRF32.getR55_group_name().toString();
								R55cell2.setCellValue(value);
							}
							Cell R55cell3 = row55.getCell(4);
							if (R55cell3 != null) {
								String value = (BRF32.getR55_emirate() == null) ? ""
										: BRF32.getR55_emirate().toString();
								R55cell3.setCellValue(value);
							}
							Cell R55cell4 = row55.getCell(5);
							if (R55cell4 != null) {
								R55cell4.setCellValue(BRF32.getR55_outstanding_amount() == null ? 0
										: BRF32.getR55_outstanding_amount().intValue());
							}
							Cell R55cell5 = row55.getCell(6);
							if (R55cell5 != null) {
								R55cell5.setCellValue(BRF32.getR55_stage3_provisions() == null ? 0
										: BRF32.getR55_stage3_provisions().intValue());
							}
							Cell R55cell6 = row55.getCell(7);
							if (R55cell6 != null) {
								R55cell6.setCellValue(BRF32.getR55_stage2_provisions() == null ? 0
										: BRF32.getR55_stage2_provisions().intValue());
							}
							Cell R55cell7 = row55.getCell(8);
							if (R55cell7 != null) {
								String value = (BRF32.getR55_legal_case() == null) ? ""
										: BRF32.getR55_legal_case().toString();
								R55cell7.setCellValue(value);
							}
							Cell R55cell8 = row55.getCell(9);
							if (R55cell8 != null) {
								String value = (BRF32.getR55_remarks() == null) ? ""
										: BRF32.getR55_remarks().toString();
								R55cell8.setCellValue(value);
							}
							/// row56
							Row row56 = sheet.getRow(66);
							Cell R56cell1 = row56.getCell(2);
							if (R56cell1 != null) {
								String value = (BRF32.getR56_borrower_name() == null) ? ""
										: BRF32.getR56_borrower_name().toString();
								R56cell1.setCellValue(value);
							}
							Cell R56cell2 = row56.getCell(3);
							if (R56cell2 != null) {
								String value = (BRF32.getR56_group_name() == null) ? ""
										: BRF32.getR56_group_name().toString();
								R56cell2.setCellValue(value);
							}
							Cell R56cell3 = row56.getCell(4);
							if (R56cell3 != null) {
								String value = (BRF32.getR56_emirate() == null) ? ""
										: BRF32.getR56_emirate().toString();
								R56cell3.setCellValue(value);
							}
							Cell R56cell4 = row56.getCell(5);
							if (R56cell4 != null) {
								R56cell4.setCellValue(BRF32.getR56_outstanding_amount() == null ? 0
										: BRF32.getR56_outstanding_amount().intValue());
							}
							Cell R56cell5 = row56.getCell(6);
							if (R56cell5 != null) {
								R56cell5.setCellValue(BRF32.getR56_stage3_provisions() == null ? 0
										: BRF32.getR56_stage3_provisions().intValue());
							}
							Cell R56cell6 = row56.getCell(7);
							if (R56cell6 != null) {
								R56cell6.setCellValue(BRF32.getR56_stage2_provisions() == null ? 0
										: BRF32.getR56_stage2_provisions().intValue());
							}
							Cell R56cell7 = row56.getCell(8);
							if (R56cell7 != null) {
								String value = (BRF32.getR56_legal_case() == null) ? ""
										: BRF32.getR56_legal_case().toString();
								R56cell7.setCellValue(value);
							}
							Cell R56cell8 = row56.getCell(9);
							if (R56cell8 != null) {
								String value = (BRF32.getR56_remarks() == null) ? ""
										: BRF32.getR56_remarks().toString();
								R56cell8.setCellValue(value);
							}
							/// row57
							Row row57 = sheet.getRow(67);
							Cell R57cell1 = row57.getCell(2);
							if (R57cell1 != null) {
								String value = (BRF32.getR57_borrower_name() == null) ? ""
										: BRF32.getR57_borrower_name().toString();
								R57cell1.setCellValue(value);
							}
							Cell R57cell2 = row57.getCell(3);
							if (R57cell2 != null) {
								String value = (BRF32.getR57_group_name() == null) ? ""
										: BRF32.getR57_group_name().toString();
								R57cell2.setCellValue(value);
							}
							Cell R57cell3 = row57.getCell(4);
							if (R57cell3 != null) {
								String value = (BRF32.getR57_emirate() == null) ? ""
										: BRF32.getR57_emirate().toString();
								R57cell3.setCellValue(value);
							}
							Cell R57cell4 = row57.getCell(5);
							if (R57cell4 != null) {
								R57cell4.setCellValue(BRF32.getR57_outstanding_amount() == null ? 0
										: BRF32.getR57_outstanding_amount().intValue());
							}
							Cell R57cell5 = row57.getCell(6);
							if (R57cell5 != null) {
								R57cell5.setCellValue(BRF32.getR57_stage3_provisions() == null ? 0
										: BRF32.getR57_stage3_provisions().intValue());
							}
							Cell R57cell6 = row57.getCell(7);
							if (R57cell6 != null) {
								R57cell6.setCellValue(BRF32.getR57_stage2_provisions() == null ? 0
										: BRF32.getR57_stage2_provisions().intValue());
							}
							Cell R57cell7 = row57.getCell(8);
							if (R57cell7 != null) {
								String value = (BRF32.getR57_legal_case() == null) ? ""
										: BRF32.getR57_legal_case().toString();
								R57cell7.setCellValue(value);
							}
							Cell R57cell8 = row57.getCell(9);
							if (R57cell8 != null) {
								String value = (BRF32.getR57_remarks() == null) ? ""
										: BRF32.getR57_remarks().toString();
								R57cell8.setCellValue(value);
							}
							/// row58
							Row row58 = sheet.getRow(68);
							Cell R58cell1 = row58.getCell(2);
							if (R58cell1 != null) {
								String value = (BRF32.getR58_borrower_name() == null) ? ""
										: BRF32.getR58_borrower_name().toString();
								R58cell1.setCellValue(value);
							}
							Cell R58cell2 = row58.getCell(3);
							if (R58cell2 != null) {
								String value = (BRF32.getR58_group_name() == null) ? ""
										: BRF32.getR58_group_name().toString();
								R58cell2.setCellValue(value);
							}
							Cell R58cell3 = row58.getCell(4);
							if (R58cell3 != null) {
								String value = (BRF32.getR58_emirate() == null) ? ""
										: BRF32.getR58_emirate().toString();
								R58cell3.setCellValue(value);
							}
							Cell R58cell4 = row58.getCell(5);
							if (R58cell4 != null) {
								R58cell4.setCellValue(BRF32.getR58_outstanding_amount() == null ? 0
										: BRF32.getR58_outstanding_amount().intValue());
							}
							Cell R58cell5 = row58.getCell(6);
							if (R58cell5 != null) {
								R58cell5.setCellValue(BRF32.getR58_stage3_provisions() == null ? 0
										: BRF32.getR58_stage3_provisions().intValue());
							}
							Cell R58cell6 = row58.getCell(7);
							if (R58cell6 != null) {
								R58cell6.setCellValue(BRF32.getR58_stage2_provisions() == null ? 0
										: BRF32.getR58_stage2_provisions().intValue());
							}
							Cell R58cell7 = row58.getCell(8);
							if (R58cell7 != null) {
								String value = (BRF32.getR58_legal_case() == null) ? ""
										: BRF32.getR58_legal_case().toString();
								R58cell7.setCellValue(value);
							}
							Cell R58cell8 = row58.getCell(9);
							if (R58cell8 != null) {
								String value = (BRF32.getR58_remarks() == null) ? ""
										: BRF32.getR58_remarks().toString();
								R58cell8.setCellValue(value);
							}
							/// row59
							Row row59 = sheet.getRow(69);
							Cell R59cell1 = row59.getCell(2);
							if (R59cell1 != null) {
								String value = (BRF32.getR59_borrower_name() == null) ? ""
										: BRF32.getR59_borrower_name().toString();
								R59cell1.setCellValue(value);
							}
							Cell R59cell2 = row59.getCell(3);
							if (R59cell2 != null) {
								String value = (BRF32.getR59_group_name() == null) ? ""
										: BRF32.getR59_group_name().toString();
								R59cell2.setCellValue(value);
							}
							Cell R59cell3 = row59.getCell(4);
							if (R59cell3 != null) {
								String value = (BRF32.getR59_emirate() == null) ? ""
										: BRF32.getR59_emirate().toString();
								R59cell3.setCellValue(value);
							}
							Cell R59cell4 = row59.getCell(5);
							if (R59cell4 != null) {
								R59cell4.setCellValue(BRF32.getR59_outstanding_amount() == null ? 0
										: BRF32.getR59_outstanding_amount().intValue());
							}
							Cell R59cell5 = row59.getCell(6);
							if (R59cell5 != null) {
								R59cell5.setCellValue(BRF32.getR59_stage3_provisions() == null ? 0
										: BRF32.getR59_stage3_provisions().intValue());
							}
							Cell R59cell6 = row59.getCell(7);
							if (R59cell6 != null) {
								R59cell6.setCellValue(BRF32.getR59_stage2_provisions() == null ? 0
										: BRF32.getR59_stage2_provisions().intValue());
							}
							Cell R59cell7 = row59.getCell(8);
							if (R59cell7 != null) {
								String value = (BRF32.getR59_legal_case() == null) ? ""
										: BRF32.getR59_legal_case().toString();
								R59cell7.setCellValue(value);
							}
							Cell R59cell8 = row59.getCell(9);
							if (R59cell8 != null) {
								String value = (BRF32.getR59_remarks() == null) ? ""
										: BRF32.getR59_remarks().toString();
								R59cell8.setCellValue(value);
							}
							/// row60
							Row row60 = sheet.getRow(70);
							Cell R60cell1 = row60.getCell(2);
							if (R60cell1 != null) {
								String value = (BRF32.getR60_borrower_name() == null) ? ""
										: BRF32.getR60_borrower_name().toString();
								R60cell1.setCellValue(value);
							}
							Cell R60cell2 = row60.getCell(3);
							if (R60cell2 != null) {
								String value = (BRF32.getR60_group_name() == null) ? ""
										: BRF32.getR60_group_name().toString();
								R60cell2.setCellValue(value);
							}
							Cell R60cell3 = row60.getCell(4);
							if (R60cell3 != null) {
								String value = (BRF32.getR60_emirate() == null) ? ""
										: BRF32.getR60_emirate().toString();
								R60cell3.setCellValue(value);
							}
							Cell R60cell4 = row60.getCell(5);
							if (R60cell4 != null) {
								R60cell4.setCellValue(BRF32.getR60_outstanding_amount() == null ? 0
										: BRF32.getR60_outstanding_amount().intValue());
							}
							Cell R60cell5 = row60.getCell(6);
							if (R60cell5 != null) {
								R60cell5.setCellValue(BRF32.getR60_stage3_provisions() == null ? 0
										: BRF32.getR60_stage3_provisions().intValue());
							}
							Cell R60cell6 = row60.getCell(7);
							if (R60cell6 != null) {
								R60cell6.setCellValue(BRF32.getR60_stage2_provisions() == null ? 0
										: BRF32.getR60_stage2_provisions().intValue());
							}
							Cell R60cell7 = row60.getCell(8);
							if (R60cell7 != null) {
								String value = (BRF32.getR60_legal_case() == null) ? ""
										: BRF32.getR60_legal_case().toString();
								R60cell7.setCellValue(value);
							}
							Cell R60cell8 = row60.getCell(9);
							if (R60cell8 != null) {
								String value = (BRF32.getR60_remarks() == null) ? ""
										: BRF32.getR60_remarks().toString();
								R60cell8.setCellValue(value);
							}
							/// row61
							Row row61 = sheet.getRow(71);
							Cell R61cell1 = row61.getCell(2);
							if (R61cell1 != null) {
								String value = (BRF32.getR61_borrower_name() == null) ? ""
										: BRF32.getR61_borrower_name().toString();
								R61cell1.setCellValue(value);
							}
							Cell R61cell2 = row61.getCell(3);
							if (R61cell2 != null) {
								String value = (BRF32.getR61_group_name() == null) ? ""
										: BRF32.getR61_group_name().toString();
								R61cell2.setCellValue(value);
							}
							Cell R61cell3 = row61.getCell(4);
							if (R61cell3 != null) {
								String value = (BRF32.getR61_emirate() == null) ? ""
										: BRF32.getR61_emirate().toString();
								R61cell3.setCellValue(value);
							}
							Cell R61cell4 = row61.getCell(5);
							if (R61cell4 != null) {
								R61cell4.setCellValue(BRF32.getR61_outstanding_amount() == null ? 0
										: BRF32.getR61_outstanding_amount().intValue());
							}
							Cell R61cell5 = row61.getCell(6);
							if (R61cell5 != null) {
								R61cell5.setCellValue(BRF32.getR61_stage3_provisions() == null ? 0
										: BRF32.getR61_stage3_provisions().intValue());
							}
							Cell R61cell6 = row61.getCell(7);
							if (R61cell6 != null) {
								R61cell6.setCellValue(BRF32.getR61_stage2_provisions() == null ? 0
										: BRF32.getR61_stage2_provisions().intValue());
							}
							Cell R61cell7 = row61.getCell(8);
							if (R61cell7 != null) {
								String value = (BRF32.getR61_legal_case() == null) ? ""
										: BRF32.getR61_legal_case().toString();
								R61cell7.setCellValue(value);
							}
							Cell R61cell8 = row61.getCell(9);
							if (R61cell8 != null) {
								String value = (BRF32.getR61_remarks() == null) ? ""
										: BRF32.getR61_remarks().toString();
								R61cell8.setCellValue(value);
							}
							/// row62
							Row row62 = sheet.getRow(72);
							Cell R62cell1 = row62.getCell(2);
							if (R62cell1 != null) {
								String value = (BRF32.getR62_borrower_name() == null) ? ""
										: BRF32.getR62_borrower_name().toString();
								R62cell1.setCellValue(value);
							}
							Cell R62cell2 = row62.getCell(3);
							if (R62cell2 != null) {
								String value = (BRF32.getR62_group_name() == null) ? ""
										: BRF32.getR62_group_name().toString();
								R62cell2.setCellValue(value);
							}
							Cell R62cell3 = row62.getCell(4);
							if (R62cell3 != null) {
								String value = (BRF32.getR62_emirate() == null) ? ""
										: BRF32.getR62_emirate().toString();
								R62cell3.setCellValue(value);
							}
							Cell R62cell4 = row62.getCell(5);
							if (R62cell4 != null) {
								R62cell4.setCellValue(BRF32.getR62_outstanding_amount() == null ? 0
										: BRF32.getR62_outstanding_amount().intValue());
							}
							Cell R62cell5 = row62.getCell(6);
							if (R62cell5 != null) {
								R62cell5.setCellValue(BRF32.getR62_stage3_provisions() == null ? 0
										: BRF32.getR62_stage3_provisions().intValue());
							}
							Cell R62cell6 = row62.getCell(7);
							if (R62cell6 != null) {
								R62cell6.setCellValue(BRF32.getR62_stage2_provisions() == null ? 0
										: BRF32.getR62_stage2_provisions().intValue());
							}
							Cell R62cell7 = row62.getCell(8);
							if (R62cell7 != null) {
								String value = (BRF32.getR62_legal_case() == null) ? ""
										: BRF32.getR62_legal_case().toString();
								R62cell7.setCellValue(value);
							}
							Cell R62cell8 = row62.getCell(9);
							if (R62cell8 != null) {
								String value = (BRF32.getR62_remarks() == null) ? ""
										: BRF32.getR62_remarks().toString();
								R62cell8.setCellValue(value);
							}
							/// row63
							Row row63 = sheet.getRow(73);

							Cell R63cell1 = row63.getCell(2);
							if (R63cell1 != null) {
								String value = (BRF32.getR63_borrower_name() == null) ? ""
										: BRF32.getR63_borrower_name().toString();
								R63cell1.setCellValue(value);
							}
							Cell R63cell2 = row63.getCell(3);
							if (R63cell2 != null) {
								String value = (BRF32.getR63_group_name() == null) ? ""
										: BRF32.getR63_group_name().toString();
								R63cell2.setCellValue(value);
							}
							Cell R63cell3 = row63.getCell(4);
							if (R63cell3 != null) {
								String value = (BRF32.getR63_emirate() == null) ? ""
										: BRF32.getR63_emirate().toString();
								R63cell3.setCellValue(value);
							}
							Cell R63cell4 = row63.getCell(5);
							if (R63cell4 != null) {
								R63cell4.setCellValue(BRF32.getR63_outstanding_amount() == null ? 0
										: BRF32.getR63_outstanding_amount().intValue());
							}
							Cell R63cell5 = row63.getCell(6);
							if (R63cell5 != null) {
								R63cell5.setCellValue(BRF32.getR63_stage3_provisions() == null ? 0
										: BRF32.getR63_stage3_provisions().intValue());
							}
							Cell R63cell6 = row63.getCell(7);
							if (R63cell6 != null) {
								R63cell6.setCellValue(BRF32.getR63_stage2_provisions() == null ? 0
										: BRF32.getR63_stage2_provisions().intValue());
							}
							Cell R63cell7 = row63.getCell(8);
							if (R63cell7 != null) {
								String value = (BRF32.getR63_legal_case() == null) ? ""
										: BRF32.getR63_legal_case().toString();
								R63cell7.setCellValue(value);
							}
							Cell R63cell8 = row63.getCell(9);
							if (R63cell8 != null) {
								String value = (BRF32.getR63_remarks() == null) ? ""
										: BRF32.getR63_remarks().toString();
								R63cell8.setCellValue(value);
							}

						}
					}
					workbook.getCreationHelper().createFormulaEvaluator().evaluateAll();
					FileOutputStream fileOut = new FileOutputStream(
							env.getProperty("output.exportpathfinal") + "011-BRF-032-A.xls");
					workbook.write(fileOut);
					fileOut.close();
					System.out.println(fileOut);
					path = fileOut.toString();
					// Close the workbook
					System.out.println("PATH : " + path);
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

			} //// else end

		}
		outputFile = new File(env.getProperty("output.exportpathfinal") + "011-BRF-032-A.xls");

		return outputFile;

	}

	public String detailChanges32(BRF32B_DETAIL_ENTITY detail, String foracid, String report_addl_criteria_1,
			BigDecimal act_balance_amt_lc, String report_label_1, String report_name_1) {

		String msg = "";

		try {

			Session hs = sessionFactory.getCurrentSession();
			Optional<BRF32B_DETAIL_ENTITY> Brf32detail = brf32b_detailrepo.findById(foracid);

			if (Brf32detail.isPresent()) {
				BRF32B_DETAIL_ENTITY BRFdetail = Brf32detail.get();

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
					brf32b_detailrepo.save(BRFdetail);

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

	public ModelAndView getArchieveBRF032View(String reportId, String fromdate, String todate, String currency,
			String dtltype, Pageable pageable) {

		ModelAndView mv = new ModelAndView();
		Session hs = sessionFactory.getCurrentSession();
		int pageSize = pageable.getPageSize();
		int currentPage = pageable.getPageNumber();
		int startItem = currentPage * pageSize;
		List<BRF32_ENTITY> T1rep = new ArrayList<BRF32_ENTITY>();
		// Query<Object[]> qr;

		List<BRF32_ENTITY> T1Master = new ArrayList<BRF32_ENTITY>();
		/* List<BRF73_TABLE2> T1Master1 = new ArrayList<BRF73_TABLE2>(); */

		logger.info("Inside archive" + currency);

		try {
			Date d1 = df.parse(todate);
			// T1rep = t1CurProdServiceRepo.getT1CurProdServices(d1);

			T1Master = hs.createQuery("from  BRF32_ENTITY a where a.report_date = ?1 ", BRF32_ENTITY.class)
					.setParameter(1, df.parse(todate)).getResultList();

			/*
			 * T1Master1 = hs.createQuery("from BRF73_TABLE2 a where a.report_date = ?1 ",
			 * BRF73_TABLE2.class) .setParameter(1, df.parse(todate)).getResultList();
			 */

		} catch (ParseException e) {
			e.printStackTrace();
		}

		// T1rep = t1CurProdServiceRepo.getT1CurProdServices(d1);

		mv.setViewName("RR/BRF32ARCH");
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

	public ModelAndView ARCHgetBRF032currentDtl(String reportId, String fromdate, String todate, String currency,
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

				qr = hs.createNativeQuery("select * from BRF32_ARCHIVTABLE a where report_date=?1 and report_label=?2");
				qr.setParameter(1, df.parse(todate));
				qr.setParameter(2, filter);

			} else {
				System.out.println("2");
				qr = hs.createNativeQuery("select * from BRF32_ARCHIVTABLE");

			}
		} else {
			System.out.println("3");
			qr = hs.createNativeQuery("select * from BRF32_ARCHIVTABLE  where report_date = ?1");
		}

		List<BRF32_ARCHIVENTITY> T1Master = new ArrayList<BRF32_ARCHIVENTITY>();

		try {
			System.out.println("Values entered");
			T1Master = hs.createQuery("from BRF32_ARCHIVENTITY a where a.report_date = ?1", BRF32_ARCHIVENTITY.class)
					.setParameter(1, df.parse(todate)).getResultList();
		} catch (ParseException e) {

			e.printStackTrace();
		}

		logger.info("Getting Report Detail for : " + reportId + "," + fromdate + "," + todate + "," + currency);
		List<Object[]> result = qr.getResultList();
		for (Object[] a : result) {

			String acct_crncy_code = (String) a[0];
			String acct_name = (String) a[1];
			String acid = (String) a[2];
			BigDecimal act_balance_amt_lc = (BigDecimal) a[3];
			String bacid = (String) a[4];
			String constitution_code = (String) a[5];
			String constitution_desc = (String) a[6];
			String country = (String) a[7];
			String country_of_incorp = (String) a[8];
			Date create_time = (Date) a[9];
			String create_user = (String) a[10];
			String cust_id = (String) a[11];
			String cust_type = (String) a[12];
			String del_flg = (String) a[13];
			BigDecimal eab_lc = (BigDecimal) a[14];
			String entity_flg = (String) a[15];
			String foracid = (String) a[16];
			String gender = (String) a[17];
			String gl_code = (String) a[18];
			String gl_sub_head_code = (String) a[19];
			String gl_sub_head_desc = (String) a[20];
			String group_id = (String) a[21];
			BigDecimal hni_networth = (BigDecimal) a[22];
			String legal_entity_type = (String) a[23];
			Date maturity_date = (Date) a[24];
			String modify_flg = (String) a[25];
			Date modify_time = (Date) a[26];
			String modify_user = (String) a[27];
			String nre_flg = (String) a[28];
			String nre_status = (String) a[29];
			String purpose_of_advn = (String) a[30];
			String remarks = (String) a[31];
			String report_addl_criteria_1 = (String) a[32];
			String report_addl_criteria_2 = (String) a[33];
			String report_addl_criteria_3 = (String) a[34];
			Date report_date = (Date) a[35];
			String report_label_1 = (String) a[36];
			String report_name_1 = (String) a[37];
			String schm_code = (String) a[38];
			String schm_type = (String) a[39];
			BigDecimal sector = (BigDecimal) a[40];
			String sector_code = (String) a[41];
			String segment = (String) a[42];
			String sol_id = (String) a[43];
			String sub_sector = (String) a[44];
			String sub_segment = (String) a[45];
			String turnover = (String) a[46];
			Date verify_time = (Date) a[47];
			String verify_user = (String) a[48];
			String version = (String) a[49];
			String group_name = (String) a[50];
			BigDecimal stage3_provision = (BigDecimal) a[51];
			BigDecimal stage2_provision = (BigDecimal) a[52];
			String legal_case = (String) a[53];
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

			BRF32_ARCHIVENTITY py = new BRF32_ARCHIVENTITY(acct_crncy_code, acct_name, acid, act_balance_amt_lc, bacid,
					constitution_code, constitution_desc, country, country_of_incorp, create_time, create_user, cust_id,
					cust_type, del_flg, eab_lc, entity_flg, foracid, gender, gl_code, gl_sub_head_code,
					gl_sub_head_desc, group_id, hni_networth, legal_entity_type, maturity_date, modify_flg, modify_time,
					modify_user, nre_flg, nre_status, purpose_of_advn, remarks, report_addl_criteria_1,
					report_addl_criteria_2, report_addl_criteria_3, report_date, report_label_1, report_name_1,
					schm_code, schm_type, sector, sector_code, segment, sol_id, sub_sector, sub_segment, turnover,
					verify_time, verify_user, version, group_name, stage3_provision, stage2_provision, legal_case);
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

		mv.setViewName("RR" + "/" + "BRF32ARCH::reportcontent");
		mv.addObject("reportdetails", T1Dt1Page.getContent());
		mv.addObject("reportmaster", T1Master);
		mv.addObject("reportmaster1", qr);
		mv.addObject("singledetail", new T1CurProdDetail());
		mv.addObject("reportsflag", "reportsflag");
		mv.addObject("menu", reportId);
		return mv;
	}

	public String modifyRecord32(Date asondate, BRF32_ENTITY BRF32_ENTITY, String userId) {
		String msg = "";
		Optional<BRF32_ENTITY> up = brf32ServiceRepo.getBRF32Report(asondate);

		if (up.isPresent()) {
			BRF32_ENTITY brf32 = up.get();

//stage3
			if (BRF32_ENTITY.getR1_stage3_provisions() != null) {
				brf32.setR1_stage3_provisions(BRF32_ENTITY.getR1_stage3_provisions());
			}

			if (BRF32_ENTITY.getR2_stage3_provisions() != null) {
				brf32.setR2_stage3_provisions(BRF32_ENTITY.getR2_stage3_provisions());
			}
			if (BRF32_ENTITY.getR3_stage3_provisions() != null) {
				brf32.setR3_stage3_provisions(BRF32_ENTITY.getR3_stage3_provisions());
			}
			if (BRF32_ENTITY.getR4_stage3_provisions() != null) {
				brf32.setR4_stage3_provisions(BRF32_ENTITY.getR4_stage3_provisions());
			}
			if (BRF32_ENTITY.getR5_stage3_provisions() != null) {
				brf32.setR5_stage3_provisions(BRF32_ENTITY.getR5_stage3_provisions());
			}

			if (BRF32_ENTITY.getR6_stage3_provisions() != null) {
				brf32.setR6_stage3_provisions(BRF32_ENTITY.getR6_stage3_provisions());
			}
			if (BRF32_ENTITY.getR7_stage3_provisions() != null) {
				brf32.setR7_stage3_provisions(BRF32_ENTITY.getR7_stage3_provisions());
			}
			if (BRF32_ENTITY.getR8_stage3_provisions() != null) {
				brf32.setR8_stage3_provisions(BRF32_ENTITY.getR8_stage3_provisions());
			}
			if (BRF32_ENTITY.getR9_stage3_provisions() != null) {
				brf32.setR9_stage3_provisions(BRF32_ENTITY.getR9_stage3_provisions());
			}
			if (BRF32_ENTITY.getR10_stage3_provisions() != null) {
				brf32.setR10_stage3_provisions(BRF32_ENTITY.getR10_stage3_provisions());
			}
			if (BRF32_ENTITY.getR11_stage3_provisions() != null) {
				brf32.setR11_stage3_provisions(BRF32_ENTITY.getR11_stage3_provisions());
			}
			if (BRF32_ENTITY.getR12_stage3_provisions() != null) {
				brf32.setR12_stage3_provisions(BRF32_ENTITY.getR12_stage3_provisions());
			}
			if (BRF32_ENTITY.getR13_stage3_provisions() != null) {
				brf32.setR13_stage3_provisions(BRF32_ENTITY.getR13_stage3_provisions());
			}
			if (BRF32_ENTITY.getR14_stage3_provisions() != null) {
				brf32.setR14_stage3_provisions(BRF32_ENTITY.getR14_stage3_provisions());
			}
			if (BRF32_ENTITY.getR15_stage3_provisions() != null) {
				brf32.setR15_stage3_provisions(BRF32_ENTITY.getR15_stage3_provisions());
			}

			if (BRF32_ENTITY.getR16_stage3_provisions() != null) {
				brf32.setR16_stage3_provisions(BRF32_ENTITY.getR16_stage3_provisions());
			}
			if (BRF32_ENTITY.getR17_stage3_provisions() != null) {
				brf32.setR17_stage3_provisions(BRF32_ENTITY.getR17_stage3_provisions());
			}
			if (BRF32_ENTITY.getR18_stage3_provisions() != null) {
				brf32.setR18_stage3_provisions(BRF32_ENTITY.getR18_stage3_provisions());
			}
			if (BRF32_ENTITY.getR19_stage3_provisions() != null) {
				brf32.setR19_stage3_provisions(BRF32_ENTITY.getR19_stage3_provisions());
			}
			if (BRF32_ENTITY.getR20_stage3_provisions() != null) {
				brf32.setR20_stage3_provisions(BRF32_ENTITY.getR20_stage3_provisions());
			}

			if (BRF32_ENTITY.getR21_stage3_provisions() != null) {
				brf32.setR21_stage3_provisions(BRF32_ENTITY.getR21_stage3_provisions());
			}
			if (BRF32_ENTITY.getR22_stage3_provisions() != null) {
				brf32.setR22_stage3_provisions(BRF32_ENTITY.getR22_stage3_provisions());
			}
			if (BRF32_ENTITY.getR23_stage3_provisions() != null) {
				brf32.setR23_stage3_provisions(BRF32_ENTITY.getR23_stage3_provisions());
			}
			if (BRF32_ENTITY.getR24_stage3_provisions() != null) {
				brf32.setR24_stage3_provisions(BRF32_ENTITY.getR24_stage3_provisions());
			}
			if (BRF32_ENTITY.getR25_stage3_provisions() != null) {
				brf32.setR25_stage3_provisions(BRF32_ENTITY.getR25_stage3_provisions());
			}

			if (BRF32_ENTITY.getR26_stage3_provisions() != null) {
				brf32.setR26_stage3_provisions(BRF32_ENTITY.getR26_stage3_provisions());
			}
			if (BRF32_ENTITY.getR27_stage3_provisions() != null) {
				brf32.setR27_stage3_provisions(BRF32_ENTITY.getR27_stage3_provisions());
			}
			if (BRF32_ENTITY.getR28_stage3_provisions() != null) {
				brf32.setR28_stage3_provisions(BRF32_ENTITY.getR28_stage3_provisions());
			}
			if (BRF32_ENTITY.getR29_stage3_provisions() != null) {
				brf32.setR29_stage3_provisions(BRF32_ENTITY.getR29_stage3_provisions());
			}

			if (BRF32_ENTITY.getR30_stage3_provisions() != null) {
				brf32.setR30_stage3_provisions(BRF32_ENTITY.getR30_stage3_provisions());
			}
			if (BRF32_ENTITY.getR31_stage3_provisions() != null) {
				brf32.setR31_stage3_provisions(BRF32_ENTITY.getR31_stage3_provisions());
			}
			if (BRF32_ENTITY.getR32_stage3_provisions() != null) {
				brf32.setR32_stage3_provisions(BRF32_ENTITY.getR32_stage3_provisions());
			}
			if (BRF32_ENTITY.getR33_stage3_provisions() != null) {
				brf32.setR33_stage3_provisions(BRF32_ENTITY.getR33_stage3_provisions());
			}
			if (BRF32_ENTITY.getR34_stage3_provisions() != null) {
				brf32.setR34_stage3_provisions(BRF32_ENTITY.getR34_stage3_provisions());
			}
			if (BRF32_ENTITY.getR35_stage3_provisions() != null) {
				brf32.setR35_stage3_provisions(BRF32_ENTITY.getR35_stage3_provisions());
			}

			if (BRF32_ENTITY.getR36_stage3_provisions() != null) {
				brf32.setR36_stage3_provisions(BRF32_ENTITY.getR36_stage3_provisions());
			}
			if (BRF32_ENTITY.getR37_stage3_provisions() != null) {
				brf32.setR37_stage3_provisions(BRF32_ENTITY.getR37_stage3_provisions());
			}
			if (BRF32_ENTITY.getR38_stage3_provisions() != null) {
				brf32.setR38_stage3_provisions(BRF32_ENTITY.getR38_stage3_provisions());
			}
			if (BRF32_ENTITY.getR39_stage3_provisions() != null) {
				brf32.setR39_stage3_provisions(BRF32_ENTITY.getR39_stage3_provisions());
			}
			if (BRF32_ENTITY.getR40_stage3_provisions() != null) {
				brf32.setR40_stage3_provisions(BRF32_ENTITY.getR40_stage3_provisions());
			}

			if (BRF32_ENTITY.getR41_stage3_provisions() != null) {
				brf32.setR41_stage3_provisions(BRF32_ENTITY.getR41_stage3_provisions());
			}
			if (BRF32_ENTITY.getR42_stage3_provisions() != null) {
				brf32.setR42_stage3_provisions(BRF32_ENTITY.getR42_stage3_provisions());
			}
			if (BRF32_ENTITY.getR43_stage3_provisions() != null) {
				brf32.setR43_stage3_provisions(BRF32_ENTITY.getR43_stage3_provisions());
			}
			if (BRF32_ENTITY.getR44_stage3_provisions() != null) {
				brf32.setR44_stage3_provisions(BRF32_ENTITY.getR44_stage3_provisions());
			}
			if (BRF32_ENTITY.getR45_stage3_provisions() != null) {
				brf32.setR45_stage3_provisions(BRF32_ENTITY.getR45_stage3_provisions());
			}

			if (BRF32_ENTITY.getR46_stage3_provisions() != null) {
				brf32.setR46_stage3_provisions(BRF32_ENTITY.getR46_stage3_provisions());
			}
			if (BRF32_ENTITY.getR47_stage3_provisions() != null) {
				brf32.setR47_stage3_provisions(BRF32_ENTITY.getR47_stage3_provisions());
			}
			if (BRF32_ENTITY.getR48_stage3_provisions() != null) {
				brf32.setR48_stage3_provisions(BRF32_ENTITY.getR48_stage3_provisions());
			}
			if (BRF32_ENTITY.getR49_stage3_provisions() != null) {
				brf32.setR49_stage3_provisions(BRF32_ENTITY.getR49_stage3_provisions());
			}

			if (BRF32_ENTITY.getR50_stage3_provisions() != null) {
				brf32.setR50_stage3_provisions(BRF32_ENTITY.getR50_stage3_provisions());
			}
			if (BRF32_ENTITY.getR51_stage3_provisions() != null) {
				brf32.setR51_stage3_provisions(BRF32_ENTITY.getR51_stage3_provisions());
			}
			if (BRF32_ENTITY.getR52_stage3_provisions() != null) {
				brf32.setR52_stage3_provisions(BRF32_ENTITY.getR52_stage3_provisions());
			}
			if (BRF32_ENTITY.getR53_stage3_provisions() != null) {
				brf32.setR53_stage3_provisions(BRF32_ENTITY.getR53_stage3_provisions());
			}
			if (BRF32_ENTITY.getR54_stage3_provisions() != null) {
				brf32.setR54_stage3_provisions(BRF32_ENTITY.getR54_stage3_provisions());
			}
			if (BRF32_ENTITY.getR55_stage3_provisions() != null) {
				brf32.setR55_stage3_provisions(BRF32_ENTITY.getR55_stage3_provisions());
			}

			if (BRF32_ENTITY.getR56_stage3_provisions() != null) {
				brf32.setR56_stage3_provisions(BRF32_ENTITY.getR56_stage3_provisions());
			}
			if (BRF32_ENTITY.getR57_stage3_provisions() != null) {
				brf32.setR57_stage3_provisions(BRF32_ENTITY.getR57_stage3_provisions());
			}
			if (BRF32_ENTITY.getR58_stage3_provisions() != null) {
				brf32.setR58_stage3_provisions(BRF32_ENTITY.getR58_stage3_provisions());
			}
			if (BRF32_ENTITY.getR59_stage3_provisions() != null) {
				brf32.setR59_stage3_provisions(BRF32_ENTITY.getR59_stage3_provisions());
			}
			if (BRF32_ENTITY.getR60_stage3_provisions() != null) {
				brf32.setR60_stage3_provisions(BRF32_ENTITY.getR60_stage3_provisions());
			}

			if (BRF32_ENTITY.getR61_stage3_provisions() != null) {
				brf32.setR61_stage3_provisions(BRF32_ENTITY.getR61_stage3_provisions());
			}
			if (BRF32_ENTITY.getR62_stage3_provisions() != null) {
				brf32.setR62_stage3_provisions(BRF32_ENTITY.getR62_stage3_provisions());
			}
			if (BRF32_ENTITY.getR63_stage3_provisions() != null) {
				brf32.setR63_stage3_provisions(BRF32_ENTITY.getR63_stage3_provisions());
			}
			if (BRF32_ENTITY.getR64_stage3_provisions() != null) {
				brf32.setR64_stage3_provisions(BRF32_ENTITY.getR64_stage3_provisions());
			}

			/// stage2

			if (BRF32_ENTITY.getR1_stage2_provisions() != null) {
				brf32.setR1_stage2_provisions(BRF32_ENTITY.getR1_stage2_provisions());
			}

			if (BRF32_ENTITY.getR2_stage2_provisions() != null) {
				brf32.setR2_stage2_provisions(BRF32_ENTITY.getR2_stage2_provisions());
			}
			if (BRF32_ENTITY.getR3_stage2_provisions() != null) {
				brf32.setR3_stage2_provisions(BRF32_ENTITY.getR3_stage2_provisions());
			}
			if (BRF32_ENTITY.getR4_stage2_provisions() != null) {
				brf32.setR4_stage2_provisions(BRF32_ENTITY.getR4_stage2_provisions());
			}
			if (BRF32_ENTITY.getR5_stage2_provisions() != null) {
				brf32.setR5_stage2_provisions(BRF32_ENTITY.getR5_stage2_provisions());
			}

			if (BRF32_ENTITY.getR6_stage2_provisions() != null) {
				brf32.setR6_stage2_provisions(BRF32_ENTITY.getR6_stage2_provisions());
			}

			if (BRF32_ENTITY.getR7_stage2_provisions() != null) {
				brf32.setR7_stage2_provisions(BRF32_ENTITY.getR7_stage2_provisions());
			}
			if (BRF32_ENTITY.getR8_stage2_provisions() != null) {
				brf32.setR8_stage2_provisions(BRF32_ENTITY.getR8_stage2_provisions());
			}
			if (BRF32_ENTITY.getR9_stage2_provisions() != null) {
				brf32.setR9_stage2_provisions(BRF32_ENTITY.getR9_stage2_provisions());
			}
			if (BRF32_ENTITY.getR10_stage2_provisions() != null) {
				brf32.setR10_stage2_provisions(BRF32_ENTITY.getR10_stage2_provisions());
			}

			if (BRF32_ENTITY.getR11_stage2_provisions() != null) {
				brf32.setR11_stage2_provisions(BRF32_ENTITY.getR11_stage2_provisions());
			}

			if (BRF32_ENTITY.getR12_stage2_provisions() != null) {
				brf32.setR12_stage2_provisions(BRF32_ENTITY.getR12_stage2_provisions());
			}
			if (BRF32_ENTITY.getR13_stage2_provisions() != null) {
				brf32.setR13_stage2_provisions(BRF32_ENTITY.getR13_stage2_provisions());
			}
			if (BRF32_ENTITY.getR14_stage2_provisions() != null) {
				brf32.setR14_stage2_provisions(BRF32_ENTITY.getR14_stage2_provisions());
			}
			if (BRF32_ENTITY.getR15_stage2_provisions() != null) {
				brf32.setR15_stage2_provisions(BRF32_ENTITY.getR15_stage2_provisions());
			}

			if (BRF32_ENTITY.getR16_stage2_provisions() != null) {
				brf32.setR16_stage2_provisions(BRF32_ENTITY.getR16_stage2_provisions());
			}

			if (BRF32_ENTITY.getR17_stage2_provisions() != null) {
				brf32.setR17_stage2_provisions(BRF32_ENTITY.getR17_stage2_provisions());
			}
			if (BRF32_ENTITY.getR18_stage2_provisions() != null) {
				brf32.setR18_stage2_provisions(BRF32_ENTITY.getR18_stage2_provisions());
			}
			if (BRF32_ENTITY.getR19_stage2_provisions() != null) {
				brf32.setR19_stage2_provisions(BRF32_ENTITY.getR19_stage2_provisions());
			}
			if (BRF32_ENTITY.getR20_stage2_provisions() != null) {
				brf32.setR20_stage2_provisions(BRF32_ENTITY.getR20_stage2_provisions());
			}

			if (BRF32_ENTITY.getR21_stage2_provisions() != null) {
				brf32.setR21_stage2_provisions(BRF32_ENTITY.getR21_stage2_provisions());
			}

			if (BRF32_ENTITY.getR22_stage2_provisions() != null) {
				brf32.setR22_stage2_provisions(BRF32_ENTITY.getR22_stage2_provisions());
			}
			if (BRF32_ENTITY.getR23_stage2_provisions() != null) {
				brf32.setR23_stage2_provisions(BRF32_ENTITY.getR23_stage2_provisions());
			}
			if (BRF32_ENTITY.getR24_stage2_provisions() != null) {
				brf32.setR24_stage2_provisions(BRF32_ENTITY.getR24_stage2_provisions());
			}
			if (BRF32_ENTITY.getR25_stage2_provisions() != null) {
				brf32.setR25_stage2_provisions(BRF32_ENTITY.getR25_stage2_provisions());
			}
			if (BRF32_ENTITY.getR26_stage2_provisions() != null) {
				brf32.setR26_stage2_provisions(BRF32_ENTITY.getR26_stage2_provisions());
			}

			if (BRF32_ENTITY.getR27_stage2_provisions() != null) {
				brf32.setR27_stage2_provisions(BRF32_ENTITY.getR27_stage2_provisions());
			}
			if (BRF32_ENTITY.getR28_stage2_provisions() != null) {
				brf32.setR28_stage2_provisions(BRF32_ENTITY.getR28_stage2_provisions());
			}
			if (BRF32_ENTITY.getR29_stage2_provisions() != null) {
				brf32.setR29_stage2_provisions(BRF32_ENTITY.getR29_stage2_provisions());
			}
			if (BRF32_ENTITY.getR30_stage2_provisions() != null) {
				brf32.setR30_stage2_provisions(BRF32_ENTITY.getR30_stage2_provisions());
			}
			if (BRF32_ENTITY.getR31_stage2_provisions() != null) {
				brf32.setR31_stage2_provisions(BRF32_ENTITY.getR31_stage2_provisions());
			}

			if (BRF32_ENTITY.getR32_stage2_provisions() != null) {
				brf32.setR22_stage2_provisions(BRF32_ENTITY.getR22_stage2_provisions());
			}
			if (BRF32_ENTITY.getR33_stage2_provisions() != null) {
				brf32.setR23_stage2_provisions(BRF32_ENTITY.getR23_stage2_provisions());
			}
			if (BRF32_ENTITY.getR34_stage2_provisions() != null) {
				brf32.setR24_stage2_provisions(BRF32_ENTITY.getR24_stage2_provisions());
			}
			if (BRF32_ENTITY.getR35_stage2_provisions() != null) {
				brf32.setR25_stage2_provisions(BRF32_ENTITY.getR25_stage2_provisions());
			}

			if (BRF32_ENTITY.getR36_stage2_provisions() != null) {
				brf32.setR26_stage2_provisions(BRF32_ENTITY.getR26_stage2_provisions());
			}

			if (BRF32_ENTITY.getR37_stage2_provisions() != null) {
				brf32.setR27_stage2_provisions(BRF32_ENTITY.getR27_stage2_provisions());
			}
			if (BRF32_ENTITY.getR38_stage2_provisions() != null) {
				brf32.setR28_stage2_provisions(BRF32_ENTITY.getR28_stage2_provisions());
			}
			if (BRF32_ENTITY.getR39_stage2_provisions() != null) {
				brf32.setR29_stage2_provisions(BRF32_ENTITY.getR29_stage2_provisions());
			}
			if (BRF32_ENTITY.getR40_stage2_provisions() != null) {
				brf32.setR30_stage2_provisions(BRF32_ENTITY.getR30_stage2_provisions());
			}
			if (BRF32_ENTITY.getR41_stage2_provisions() != null) {
				brf32.setR31_stage2_provisions(BRF32_ENTITY.getR31_stage2_provisions());
			}

			if (BRF32_ENTITY.getR42_stage2_provisions() != null) {
				brf32.setR42_stage2_provisions(BRF32_ENTITY.getR42_stage2_provisions());
			}
			if (BRF32_ENTITY.getR43_stage2_provisions() != null) {
				brf32.setR23_stage2_provisions(BRF32_ENTITY.getR23_stage2_provisions());
			}
			if (BRF32_ENTITY.getR44_stage2_provisions() != null) {
				brf32.setR44_stage2_provisions(BRF32_ENTITY.getR44_stage2_provisions());
			}
			if (BRF32_ENTITY.getR45_stage2_provisions() != null) {
				brf32.setR45_stage2_provisions(BRF32_ENTITY.getR45_stage2_provisions());
			}

			if (BRF32_ENTITY.getR46_stage2_provisions() != null) {
				brf32.setR46_stage2_provisions(BRF32_ENTITY.getR46_stage2_provisions());
			}

			if (BRF32_ENTITY.getR47_stage2_provisions() != null) {
				brf32.setR47_stage2_provisions(BRF32_ENTITY.getR47_stage2_provisions());
			}
			if (BRF32_ENTITY.getR48_stage2_provisions() != null) {
				brf32.setR48_stage2_provisions(BRF32_ENTITY.getR48_stage2_provisions());
			}
			if (BRF32_ENTITY.getR49_stage2_provisions() != null) {
				brf32.setR49_stage2_provisions(BRF32_ENTITY.getR49_stage2_provisions());
			}
			if (BRF32_ENTITY.getR50_stage2_provisions() != null) {
				brf32.setR50_stage2_provisions(BRF32_ENTITY.getR50_stage2_provisions());
			}
			if (BRF32_ENTITY.getR51_stage2_provisions() != null) {
				brf32.setR51_stage2_provisions(BRF32_ENTITY.getR51_stage2_provisions());
			}

			if (BRF32_ENTITY.getR52_stage2_provisions() != null) {
				brf32.setR52_stage2_provisions(BRF32_ENTITY.getR52_stage2_provisions());
			}
			if (BRF32_ENTITY.getR53_stage2_provisions() != null) {
				brf32.setR53_stage2_provisions(BRF32_ENTITY.getR53_stage2_provisions());
			}
			if (BRF32_ENTITY.getR54_stage2_provisions() != null) {
				brf32.setR54_stage2_provisions(BRF32_ENTITY.getR54_stage2_provisions());
			}
			if (BRF32_ENTITY.getR55_stage2_provisions() != null) {
				brf32.setR55_stage2_provisions(BRF32_ENTITY.getR55_stage2_provisions());
			}

			if (BRF32_ENTITY.getR56_stage2_provisions() != null) {
				brf32.setR56_stage2_provisions(BRF32_ENTITY.getR56_stage2_provisions());
			}

			if (BRF32_ENTITY.getR57_stage2_provisions() != null) {
				brf32.setR57_stage2_provisions(BRF32_ENTITY.getR57_stage2_provisions());
			}
			if (BRF32_ENTITY.getR58_stage2_provisions() != null) {
				brf32.setR58_stage2_provisions(BRF32_ENTITY.getR58_stage2_provisions());
			}
			if (BRF32_ENTITY.getR59_stage2_provisions() != null) {
				brf32.setR59_stage2_provisions(BRF32_ENTITY.getR59_stage2_provisions());
			}
			if (BRF32_ENTITY.getR60_stage2_provisions() != null) {
				brf32.setR60_stage2_provisions(BRF32_ENTITY.getR60_stage2_provisions());
			}
			if (BRF32_ENTITY.getR61_stage2_provisions() != null) {
				brf32.setR61_stage2_provisions(BRF32_ENTITY.getR61_stage2_provisions());
			}
			if (BRF32_ENTITY.getR62_stage2_provisions() != null) {
				brf32.setR62_stage2_provisions(BRF32_ENTITY.getR62_stage2_provisions());
			}
			if (BRF32_ENTITY.getR63_stage2_provisions() != null) {
				brf32.setR63_stage2_provisions(BRF32_ENTITY.getR63_stage2_provisions());
			}
			if (BRF32_ENTITY.getR64_stage2_provisions() != null) {
				brf32.setR64_stage2_provisions(BRF32_ENTITY.getR64_stage2_provisions());
			}
			// LEGAL CASE
			if (BRF32_ENTITY.getR1_legal_case() != null) {
				brf32.setR1_legal_case(BRF32_ENTITY.getR1_legal_case());
			}
			if (BRF32_ENTITY.getR2_legal_case() != null) {
				brf32.setR2_legal_case(BRF32_ENTITY.getR2_legal_case());
			}
			if (BRF32_ENTITY.getR3_legal_case() != null) {
				brf32.setR3_legal_case(BRF32_ENTITY.getR3_legal_case());
			}
			if (BRF32_ENTITY.getR4_legal_case() != null) {
				brf32.setR4_legal_case(BRF32_ENTITY.getR4_legal_case());
			}
			if (BRF32_ENTITY.getR5_legal_case() != null) {
				brf32.setR5_legal_case(BRF32_ENTITY.getR5_legal_case());
			}
			if (BRF32_ENTITY.getR6_legal_case() != null) {
				brf32.setR6_legal_case(BRF32_ENTITY.getR6_legal_case());
			}
			if (BRF32_ENTITY.getR7_legal_case() != null) {
				brf32.setR7_legal_case(BRF32_ENTITY.getR7_legal_case());
			}
			if (BRF32_ENTITY.getR8_legal_case() != null) {
				brf32.setR8_legal_case(BRF32_ENTITY.getR8_legal_case());
			}
			if (BRF32_ENTITY.getR9_legal_case() != null) {
				brf32.setR9_legal_case(BRF32_ENTITY.getR9_legal_case());
			}
			if (BRF32_ENTITY.getR10_legal_case() != null) {
				brf32.setR10_legal_case(BRF32_ENTITY.getR10_legal_case());
			}
			//

			if (BRF32_ENTITY.getR11_legal_case() != null) {
				brf32.setR11_legal_case(BRF32_ENTITY.getR11_legal_case());
			}
			if (BRF32_ENTITY.getR12_legal_case() != null) {
				brf32.setR12_legal_case(BRF32_ENTITY.getR12_legal_case());
			}
			if (BRF32_ENTITY.getR13_legal_case() != null) {
				brf32.setR13_legal_case(BRF32_ENTITY.getR13_legal_case());
			}
			if (BRF32_ENTITY.getR14_legal_case() != null) {
				brf32.setR14_legal_case(BRF32_ENTITY.getR14_legal_case());
			}
			if (BRF32_ENTITY.getR15_legal_case() != null) {
				brf32.setR15_legal_case(BRF32_ENTITY.getR15_legal_case());
			}
			if (BRF32_ENTITY.getR16_legal_case() != null) {
				brf32.setR16_legal_case(BRF32_ENTITY.getR16_legal_case());
			}
			if (BRF32_ENTITY.getR17_legal_case() != null) {
				brf32.setR17_legal_case(BRF32_ENTITY.getR17_legal_case());
			}
			if (BRF32_ENTITY.getR18_legal_case() != null) {
				brf32.setR18_legal_case(BRF32_ENTITY.getR18_legal_case());
			}
			if (BRF32_ENTITY.getR19_legal_case() != null) {
				brf32.setR19_legal_case(BRF32_ENTITY.getR19_legal_case());
			}
			if (BRF32_ENTITY.getR20_legal_case() != null) {
				brf32.setR20_legal_case(BRF32_ENTITY.getR20_legal_case());
			}
			if (BRF32_ENTITY.getR21_legal_case() != null) {
				brf32.setR21_legal_case(BRF32_ENTITY.getR21_legal_case());
			}
			if (BRF32_ENTITY.getR22_legal_case() != null) {
				brf32.setR22_legal_case(BRF32_ENTITY.getR22_legal_case());
			}
			if (BRF32_ENTITY.getR23_legal_case() != null) {
				brf32.setR23_legal_case(BRF32_ENTITY.getR23_legal_case());
			}
			if (BRF32_ENTITY.getR24_legal_case() != null) {
				brf32.setR24_legal_case(BRF32_ENTITY.getR24_legal_case());
			}
			if (BRF32_ENTITY.getR25_legal_case() != null) {
				brf32.setR25_legal_case(BRF32_ENTITY.getR25_legal_case());
			}
			if (BRF32_ENTITY.getR26_legal_case() != null) {
				brf32.setR26_legal_case(BRF32_ENTITY.getR26_legal_case());
			}
			if (BRF32_ENTITY.getR27_legal_case() != null) {
				brf32.setR27_legal_case(BRF32_ENTITY.getR27_legal_case());
			}
			if (BRF32_ENTITY.getR28_legal_case() != null) {
				brf32.setR28_legal_case(BRF32_ENTITY.getR28_legal_case());
			}
			if (BRF32_ENTITY.getR29_legal_case() != null) {
				brf32.setR29_legal_case(BRF32_ENTITY.getR29_legal_case());
			}
			if (BRF32_ENTITY.getR30_legal_case() != null) {
				brf32.setR30_legal_case(BRF32_ENTITY.getR30_legal_case());
			}
			if (BRF32_ENTITY.getR21_legal_case() != null) {
				brf32.setR21_legal_case(BRF32_ENTITY.getR31_legal_case());
			}
			if (BRF32_ENTITY.getR22_legal_case() != null) {
				brf32.setR22_legal_case(BRF32_ENTITY.getR32_legal_case());
			}
			if (BRF32_ENTITY.getR23_legal_case() != null) {
				brf32.setR23_legal_case(BRF32_ENTITY.getR33_legal_case());
			}
			if (BRF32_ENTITY.getR24_legal_case() != null) {
				brf32.setR24_legal_case(BRF32_ENTITY.getR34_legal_case());
			}
			if (BRF32_ENTITY.getR25_legal_case() != null) {
				brf32.setR25_legal_case(BRF32_ENTITY.getR35_legal_case());
			}
			if (BRF32_ENTITY.getR26_legal_case() != null) {
				brf32.setR26_legal_case(BRF32_ENTITY.getR36_legal_case());
			}
			if (BRF32_ENTITY.getR27_legal_case() != null) {
				brf32.setR27_legal_case(BRF32_ENTITY.getR37_legal_case());
			}
			if (BRF32_ENTITY.getR28_legal_case() != null) {
				brf32.setR28_legal_case(BRF32_ENTITY.getR38_legal_case());
			}
			if (BRF32_ENTITY.getR29_legal_case() != null) {
				brf32.setR29_legal_case(BRF32_ENTITY.getR39_legal_case());
			}
			if (BRF32_ENTITY.getR30_legal_case() != null) {
				brf32.setR30_legal_case(BRF32_ENTITY.getR40_legal_case());
			}
			if (BRF32_ENTITY.getR21_legal_case() != null) {
				brf32.setR21_legal_case(BRF32_ENTITY.getR41_legal_case());
			}
			if (BRF32_ENTITY.getR22_legal_case() != null) {
				brf32.setR22_legal_case(BRF32_ENTITY.getR42_legal_case());
			}
			if (BRF32_ENTITY.getR23_legal_case() != null) {
				brf32.setR23_legal_case(BRF32_ENTITY.getR43_legal_case());
			}
			if (BRF32_ENTITY.getR24_legal_case() != null) {
				brf32.setR24_legal_case(BRF32_ENTITY.getR44_legal_case());
			}
			if (BRF32_ENTITY.getR25_legal_case() != null) {
				brf32.setR25_legal_case(BRF32_ENTITY.getR45_legal_case());
			}
			if (BRF32_ENTITY.getR26_legal_case() != null) {
				brf32.setR26_legal_case(BRF32_ENTITY.getR46_legal_case());
			}
			if (BRF32_ENTITY.getR27_legal_case() != null) {
				brf32.setR27_legal_case(BRF32_ENTITY.getR47_legal_case());
			}
			if (BRF32_ENTITY.getR28_legal_case() != null) {
				brf32.setR28_legal_case(BRF32_ENTITY.getR48_legal_case());
			}
			if (BRF32_ENTITY.getR29_legal_case() != null) {
				brf32.setR29_legal_case(BRF32_ENTITY.getR49_legal_case());
			}
			if (BRF32_ENTITY.getR30_legal_case() != null) {
				brf32.setR30_legal_case(BRF32_ENTITY.getR50_legal_case());
			}
			if (BRF32_ENTITY.getR21_legal_case() != null) {
				brf32.setR21_legal_case(BRF32_ENTITY.getR51_legal_case());
			}
			if (BRF32_ENTITY.getR22_legal_case() != null) {
				brf32.setR22_legal_case(BRF32_ENTITY.getR52_legal_case());
			}
			if (BRF32_ENTITY.getR23_legal_case() != null) {
				brf32.setR23_legal_case(BRF32_ENTITY.getR53_legal_case());
			}
			if (BRF32_ENTITY.getR24_legal_case() != null) {
				brf32.setR24_legal_case(BRF32_ENTITY.getR54_legal_case());
			}
			if (BRF32_ENTITY.getR25_legal_case() != null) {
				brf32.setR25_legal_case(BRF32_ENTITY.getR55_legal_case());
			}
			if (BRF32_ENTITY.getR26_legal_case() != null) {
				brf32.setR26_legal_case(BRF32_ENTITY.getR56_legal_case());
			}
			if (BRF32_ENTITY.getR27_legal_case() != null) {
				brf32.setR27_legal_case(BRF32_ENTITY.getR57_legal_case());
			}
			if (BRF32_ENTITY.getR28_legal_case() != null) {
				brf32.setR28_legal_case(BRF32_ENTITY.getR58_legal_case());
			}
			if (BRF32_ENTITY.getR29_legal_case() != null) {
				brf32.setR29_legal_case(BRF32_ENTITY.getR59_legal_case());
			}
			if (BRF32_ENTITY.getR30_legal_case() != null) {
				brf32.setR30_legal_case(BRF32_ENTITY.getR60_legal_case());
			}
			if (BRF32_ENTITY.getR21_legal_case() != null) {
				brf32.setR21_legal_case(BRF32_ENTITY.getR61_legal_case());
			}
			if (BRF32_ENTITY.getR22_legal_case() != null) {
				brf32.setR22_legal_case(BRF32_ENTITY.getR62_legal_case());
			}
			if (BRF32_ENTITY.getR23_legal_case() != null) {
				brf32.setR23_legal_case(BRF32_ENTITY.getR63_legal_case());
			}
			if (BRF32_ENTITY.getR24_legal_case() != null) {
				brf32.setR24_legal_case(BRF32_ENTITY.getR64_legal_case());
			}

///remarks
			if (BRF32_ENTITY.getR1_remarks() != null) {
				brf32.setR1_remarks(BRF32_ENTITY.getR1_remarks());
			}
			if (BRF32_ENTITY.getR2_remarks() != null) {
				brf32.setR2_remarks(BRF32_ENTITY.getR2_remarks());
			}
			if (BRF32_ENTITY.getR3_remarks() != null) {
				brf32.setR3_remarks(BRF32_ENTITY.getR3_remarks());
			}

			if (BRF32_ENTITY.getR4_remarks() != null) {
				brf32.setR4_remarks(BRF32_ENTITY.getR4_remarks());
			}
			if (BRF32_ENTITY.getR5_remarks() != null) {
				brf32.setR5_remarks(BRF32_ENTITY.getR5_remarks());
			}
			if (BRF32_ENTITY.getR6_remarks() != null) {
				brf32.setR6_remarks(BRF32_ENTITY.getR6_remarks());
			}

			if (BRF32_ENTITY.getR7_remarks() != null) {
				brf32.setR7_remarks(BRF32_ENTITY.getR7_remarks());
			}
			if (BRF32_ENTITY.getR8_remarks() != null) {
				brf32.setR8_remarks(BRF32_ENTITY.getR8_remarks());
			}
			if (BRF32_ENTITY.getR9_remarks() != null) {
				brf32.setR9_remarks(BRF32_ENTITY.getR9_remarks());
			}
			if (BRF32_ENTITY.getR10_remarks() != null) {
				brf32.setR10_remarks(BRF32_ENTITY.getR10_remarks());
			}
			if (BRF32_ENTITY.getR11_remarks() != null) {
				brf32.setR11_remarks(BRF32_ENTITY.getR11_remarks());

			}
			if (BRF32_ENTITY.getR12_remarks() != null) {
				brf32.setR12_remarks(BRF32_ENTITY.getR12_remarks());

			}
			if (BRF32_ENTITY.getR13_remarks() != null) {
				brf32.setR13_remarks(BRF32_ENTITY.getR13_remarks());
			}

			if (BRF32_ENTITY.getR14_remarks() != null) {
				brf32.setR14_remarks(BRF32_ENTITY.getR14_remarks());
			}
			if (BRF32_ENTITY.getR15_remarks() != null) {
				brf32.setR15_remarks(BRF32_ENTITY.getR15_remarks());
			}
			if (BRF32_ENTITY.getR16_remarks() != null) {
				brf32.setR16_remarks(BRF32_ENTITY.getR16_remarks());
			}

			if (BRF32_ENTITY.getR17_remarks() != null) {
				brf32.setR17_remarks(BRF32_ENTITY.getR17_remarks());
			}
			if (BRF32_ENTITY.getR18_remarks() != null) {
				brf32.setR18_remarks(BRF32_ENTITY.getR18_remarks());
			}
			if (BRF32_ENTITY.getR19_remarks() != null) {
				brf32.setR19_remarks(BRF32_ENTITY.getR19_remarks());
			}
			if (BRF32_ENTITY.getR20_remarks() != null) {
				brf32.setR20_remarks(BRF32_ENTITY.getR20_remarks());
			}
			if (BRF32_ENTITY.getR21_remarks() != null) {
				brf32.setR21_remarks(BRF32_ENTITY.getR21_remarks());
			}
			if (BRF32_ENTITY.getR22_remarks() != null) {
				brf32.setR22_remarks(BRF32_ENTITY.getR22_remarks());
			}

			if (BRF32_ENTITY.getR23_remarks() != null) {
				brf32.setR23_remarks(BRF32_ENTITY.getR23_remarks());
			}

			if (BRF32_ENTITY.getR24_remarks() != null) {
				brf32.setR24_remarks(BRF32_ENTITY.getR24_remarks());
			}
			if (BRF32_ENTITY.getR25_remarks() != null) {
				brf32.setR25_remarks(BRF32_ENTITY.getR25_remarks());
			}
			if (BRF32_ENTITY.getR26_remarks() != null) {
				brf32.setR26_remarks(BRF32_ENTITY.getR26_remarks());
			}

			if (BRF32_ENTITY.getR27_remarks() != null) {
				brf32.setR27_remarks(BRF32_ENTITY.getR27_remarks());
			}
			if (BRF32_ENTITY.getR28_remarks() != null) {
				brf32.setR28_remarks(BRF32_ENTITY.getR28_remarks());
			}
			if (BRF32_ENTITY.getR29_remarks() != null) {
				brf32.setR29_remarks(BRF32_ENTITY.getR29_remarks());
			}
			if (BRF32_ENTITY.getR30_remarks() != null) {
				brf32.setR30_remarks(BRF32_ENTITY.getR30_remarks());
			}
			if (BRF32_ENTITY.getR31_remarks() != null) {
				brf32.setR31_remarks(BRF32_ENTITY.getR31_remarks());
			}
			if (BRF32_ENTITY.getR32_remarks() != null) {
				brf32.setR32_remarks(BRF32_ENTITY.getR32_remarks());
			}

			if (BRF32_ENTITY.getR33_remarks() != null) {
				brf32.setR33_remarks(BRF32_ENTITY.getR33_remarks());
			}

			if (BRF32_ENTITY.getR34_remarks() != null) {
				brf32.setR34_remarks(BRF32_ENTITY.getR34_remarks());
			}
			if (BRF32_ENTITY.getR35_remarks() != null) {
				brf32.setR35_remarks(BRF32_ENTITY.getR35_remarks());
			}
			if (BRF32_ENTITY.getR36_remarks() != null) {
				brf32.setR36_remarks(BRF32_ENTITY.getR36_remarks());
			}

			if (BRF32_ENTITY.getR37_remarks() != null) {
				brf32.setR37_remarks(BRF32_ENTITY.getR37_remarks());
			}
			if (BRF32_ENTITY.getR38_remarks() != null) {
				brf32.setR38_remarks(BRF32_ENTITY.getR38_remarks());
			}
			if (BRF32_ENTITY.getR39_remarks() != null) {
				brf32.setR39_remarks(BRF32_ENTITY.getR39_remarks());
			}
			if (BRF32_ENTITY.getR40_remarks() != null) {
				brf32.setR40_remarks(BRF32_ENTITY.getR40_remarks());
			}

			if (BRF32_ENTITY.getR41_remarks() != null) {
				brf32.setR41_remarks(BRF32_ENTITY.getR41_remarks());
			}
			if (BRF32_ENTITY.getR42_remarks() != null) {
				brf32.setR42_remarks(BRF32_ENTITY.getR42_remarks());
			}

			if (BRF32_ENTITY.getR43_remarks() != null) {
				brf32.setR43_remarks(BRF32_ENTITY.getR43_remarks());
			}

			if (BRF32_ENTITY.getR44_remarks() != null) {
				brf32.setR44_remarks(BRF32_ENTITY.getR44_remarks());
			}
			if (BRF32_ENTITY.getR45_remarks() != null) {
				brf32.setR45_remarks(BRF32_ENTITY.getR45_remarks());
			}
			if (BRF32_ENTITY.getR46_remarks() != null) {
				brf32.setR46_remarks(BRF32_ENTITY.getR46_remarks());
			}

			if (BRF32_ENTITY.getR47_remarks() != null) {
				brf32.setR47_remarks(BRF32_ENTITY.getR47_remarks());
			}
			if (BRF32_ENTITY.getR48_remarks() != null) {
				brf32.setR48_remarks(BRF32_ENTITY.getR48_remarks());
			}
			if (BRF32_ENTITY.getR49_remarks() != null) {
				brf32.setR49_remarks(BRF32_ENTITY.getR49_remarks());
			}
			if (BRF32_ENTITY.getR50_remarks() != null) {
				brf32.setR50_remarks(BRF32_ENTITY.getR50_remarks());
			}
			if (BRF32_ENTITY.getR51_remarks() != null) {
				brf32.setR51_remarks(BRF32_ENTITY.getR51_remarks());
			}
			if (BRF32_ENTITY.getR52_remarks() != null) {
				brf32.setR52_remarks(BRF32_ENTITY.getR52_remarks());
			}

			if (BRF32_ENTITY.getR53_remarks() != null) {
				brf32.setR53_remarks(BRF32_ENTITY.getR53_remarks());
			}

			if (BRF32_ENTITY.getR54_remarks() != null) {
				brf32.setR54_remarks(BRF32_ENTITY.getR54_remarks());
			}
			if (BRF32_ENTITY.getR55_remarks() != null) {
				brf32.setR55_remarks(BRF32_ENTITY.getR55_remarks());
			}
			if (BRF32_ENTITY.getR56_remarks() != null) {
				brf32.setR56_remarks(BRF32_ENTITY.getR56_remarks());
			}

			if (BRF32_ENTITY.getR57_remarks() != null) {
				brf32.setR57_remarks(BRF32_ENTITY.getR57_remarks());
			}
			if (BRF32_ENTITY.getR58_remarks() != null) {
				brf32.setR58_remarks(BRF32_ENTITY.getR58_remarks());
			}
			if (BRF32_ENTITY.getR59_remarks() != null) {
				brf32.setR59_remarks(BRF32_ENTITY.getR59_remarks());
			}
			if (BRF32_ENTITY.getR60_remarks() != null) {
				brf32.setR60_remarks(BRF32_ENTITY.getR60_remarks());
			}
			if (BRF32_ENTITY.getR61_remarks() != null) {
				brf32.setR61_remarks(BRF32_ENTITY.getR61_remarks());
			}
			if (BRF32_ENTITY.getR62_remarks() != null) {
				brf32.setR62_remarks(BRF32_ENTITY.getR62_remarks());
			}

			if (BRF32_ENTITY.getR63_remarks() != null) {
				brf32.setR63_remarks(BRF32_ENTITY.getR63_remarks());
			}

			if (BRF32_ENTITY.getR64_remarks() != null) {
				brf32.setR64_remarks(BRF32_ENTITY.getR64_remarks());
			}

			brf32.setDel_flg("N");
			brf32.setEntity_flg("Y");
			brf32.setModify_flg("Y");
			brf32.setModify_user(userId);
			brf32.setReport_date(asondate);
			brf32.setReport_to_date(asondate);

			brf32ServiceRepo.save(brf32);

			System.out.println("BRF32_ENTITY: " + brf32.getR10_stage3_provisions());
			System.out.println("BRF32_ENTITY: " + brf32.getR1_stage2_provisions());
			System.out.println("BRF32_ENTITY: " + brf32.getR1_stage3_provisions());
			System.out.println("BRF32_ENTITY: " + brf32.getR1_borrower_name());
			System.out.println("BRF32_ENTITY(R2_stage3_provisions): " + brf32.getR2_stage3_provisions());

			msg = "Updated Successfully";
		} else {
			logger.info("Data Not Found");
			msg = "Data Not Found";
		}

		return msg;
	}

	public String verifyBRF32Report(Date asondate, String userId) {
		String msg = "";
		Optional<BRF32_ENTITY> up = brf32ServiceRepo.getBRF32Report(asondate);

		if (up.isPresent()) {
			BRF32_ENTITY brf32 = up.get();
			brf32.setModify_flg("N");
			brf32.setVerify_time(new Date());
			brf32.setVerify_user(userId);
			brf32.setVerify_user(userId);
			brf32.setVerify_time(asondate);
			brf32ServiceRepo.save(brf32);
			msg = "Verified Successfully";
		} else {
			msg = "Data Not Found";
		}
		return msg;
	}
}
