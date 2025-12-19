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
import com.bornfire.xbrl.entities.BRBS.BRF33_ARCHIV_ENTITY;
import com.bornfire.xbrl.entities.BRBS.BRF32_DETAIL_ENTITY;
import com.bornfire.xbrl.entities.BRBS.BRF33_DETAIL_ENTITY;
import com.bornfire.xbrl.entities.BRBS.BRF33_DetailRep;
import com.bornfire.xbrl.entities.BRBS.BRF33_ENTITY;
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
public class BRF033ReportService {
	private static final Logger logger = LoggerFactory.getLogger(BRF033ReportService.class);

	@Autowired
	SessionFactory sessionFactory;

	@Autowired
	DataSource srcdataSource;

	@Autowired
	Environment env;

	@Autowired
	BRF33_DetailRep BRF33_DetailRep1;

	/*
	 * @Autowired BRF73ServiceRepo brf73ServiceRepo;
	 */

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
			Long dtlcnt = (Long) hs.createQuery("select count(*) from BRF33_ENTITY a where a.report_date=?1")
					.setParameter(1, dt9).getSingleResult();

			if (dtlcnt > 0) {
				logger.info("Getting No of records in Mod table :" + reportid);
				Long modcnt = (Long) hs.createQuery("select count(*) from BRF33_ENTITY a").getSingleResult();
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

	public ModelAndView getBRF033View(String reportId, String fromdate, String todate, String currency, String dtltype,
			Pageable pageable) {

		ModelAndView mv = new ModelAndView();
		Session hs = sessionFactory.getCurrentSession();
		int pageSize = pageable.getPageSize();
		int currentPage = pageable.getPageNumber();
		int startItem = currentPage * pageSize;
		List<BRF33_ENTITY> T1rep = new ArrayList<BRF33_ENTITY>();
		// Query<Object[]> qr;

		List<BRF33_ENTITY> T1Master = new ArrayList<BRF33_ENTITY>();
		/* List<BRF73_TABLE2> T1Master1 = new ArrayList<BRF73_TABLE2>(); */

		logger.info("Inside archive" + currency);

		try {
			Date d1 = df.parse(todate);
			// T1rep = t1CurProdServiceRepo.getT1CurProdServices(d1);

			T1Master = hs.createQuery("from  BRF33_ENTITY a where a.report_date = ?1 ", BRF33_ENTITY.class)
					.setParameter(1, df.parse(todate)).getResultList();

			/*
			 * T1Master1 = hs.createQuery("from BRF73_TABLE2 a where a.report_date = ?1 ",
			 * BRF73_TABLE2.class) .setParameter(1, df.parse(todate)).getResultList();
			 */

		} catch (ParseException e) {
			e.printStackTrace();
		}

		// T1rep = t1CurProdServiceRepo.getT1CurProdServices(d1);

		mv.setViewName("RR/BRF033A");
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

	public ModelAndView getBRF033currentDtl(String reportId, String fromdate, String todate, String currency,
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
						"select * from BRF33_DETAILTABLE  a where report_date = ?1 and report_label_1=?2");

				qr.setParameter(2, filter);

			} else {
				qr = hs.createNativeQuery("select * from BRF33_DETAILTABLE a where report_date = ?1");

			}
		} else {
			qr = hs.createNativeQuery("select * from BRF33_DETAILTABLE  where report_date = ?1");
		}

		try {
			qr.setParameter(1, df.parse(todate));

		} catch (ParseException e) {
			e.printStackTrace();
		}
		List<BRF33_DETAIL_ENTITY> T1Master = new ArrayList<BRF33_DETAIL_ENTITY>();

		try {
			T1Master = hs.createQuery("from BRF33_DETAIL_ENTITY a where a.report_date = ?1", BRF33_DETAIL_ENTITY.class)
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
			String gender = (String) a[46];
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

			BRF33_DETAIL_ENTITY py = new BRF33_DETAIL_ENTITY(cust_id, foracid, act_balance_amt_lc, eab_lc, acct_name,
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

		mv.setViewName("RR" + "/" + "BRF033A::reportcontent");
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
		fileName = "011-BRF-033-A";
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

							jasperFile = this.getClass().getResourceAsStream("/static/jasper/BRF33_Detail.jrxml");
						} else {
							jasperFile = this.getClass().getResourceAsStream("/static/jasper/BRF33_Detail.jrxml");
						}

					} else {
						if (dtltype.equals("report")) {
							logger.info("Inside report");
							jasperFile = this.getClass().getResourceAsStream("/static/jasper/BRF33.jrxml");
						} else {
							jasperFile = this.getClass().getResourceAsStream("/static/jasper/BRF33.jrxml");
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
				List<BRF33_ENTITY> T1Master = new ArrayList<>();

				Session hs = sessionFactory.getCurrentSession();
				try {
					Date d1 = df.parse(todate);

					T1Master = hs.createQuery("from  BRF33_ENTITY a where a.report_date = ?1 ", BRF33_ENTITY.class)
							.setParameter(1, df.parse(todate)).getResultList();

					File responseCamt = new File(env.getProperty("output.exportpathtemp") + "011-BRF-033-AT.xls");
					Workbook workbook = WorkbookFactory.create(responseCamt);

					Sheet sheet = workbook.getSheetAt(0);

					if (T1Master.size() == 1) {
						for (BRF33_ENTITY BRF33 : T1Master) {

							/*
							 * //report_date Row r1row = sheet.getRow(4); if (r1row != null) { Cell r1cell =
							 * r1row.getCell(2); if (r1cell == null) { r1cell = r1row.createCell(2); //
							 * Create the cell if it doesn't exist } if (BRF33.getReport_date() != null) {
							 * // Formatting the date to dd-MM-yyyy SimpleDateFormat sdf = new
							 * SimpleDateFormat("dd-MM-yyyy"); String formattedDate =
							 * sdf.format(BRF33.getReport_date()); r1cell.setCellValue(formattedDate); //
							 * Set the formatted date in the cell } else { r1cell.setCellValue(""); // Set
							 * an empty value if the report_date is null } }
							 * 
							 */
							/// row1
							Row row1 = sheet.getRow(8);

							Cell R1cell1 = row1.getCell(2);
							if (R1cell1 != null) {
								String value = (BRF33.getR1_product_res() == null) ? ""
										: BRF33.getR1_product_res().toString();
								R1cell1.setCellValue(value);
							}
							Cell R1cell2 = row1.getCell(3);
							if (R1cell2 != null) {
								String value = (BRF33.getR1_country() == null) ? "" : BRF33.getR1_country().toString();
								R1cell2.setCellValue(value);
							}
							Cell R1cell4 = row1.getCell(4);
							if (R1cell4 != null) {
								R1cell4.setCellValue(
										BRF33.getR1_amount() == null ? 0 : BRF33.getR1_amount().intValue());
							}

							/// row2
							Row row2 = sheet.getRow(9);
							Cell R2cell1 = row2.getCell(2);
							if (R2cell1 != null) {
								String value = (BRF33.getR2_product_res() == null) ? ""
										: BRF33.getR2_product_res().toString();
								R2cell1.setCellValue(value);
							}
							Cell R2cell2 = row2.getCell(3);
							if (R2cell2 != null) {
								String value = (BRF33.getR2_country() == null) ? "" : BRF33.getR2_country().toString();
								R2cell2.setCellValue(value);
							}
							Cell R2cell4 = row2.getCell(4);
							if (R2cell4 != null) {
								R2cell4.setCellValue(
										BRF33.getR2_amount() == null ? 0 : BRF33.getR2_amount().intValue());
							}
							/// row3
							Row row3 = sheet.getRow(10);
							Cell R3cell1 = row3.getCell(2);
							if (R3cell1 != null) {
								String value = (BRF33.getR3_product_res() == null) ? ""
										: BRF33.getR3_product_res().toString();
								R3cell1.setCellValue(value);
							}
							Cell R3cell2 = row3.getCell(3);
							if (R3cell2 != null) {
								String value = (BRF33.getR3_country() == null) ? "" : BRF33.getR3_country().toString();
								R3cell2.setCellValue(value);
							}
							Cell R3cell4 = row3.getCell(4);
							if (R3cell4 != null) {
								R3cell4.setCellValue(
										BRF33.getR3_amount() == null ? 0 : BRF33.getR3_amount().intValue());
							}
							/// row4
							Row row4 = sheet.getRow(11);
							Cell R4cell1 = row4.getCell(2);
							if (R4cell1 != null) {
								String value = (BRF33.getR4_product_res() == null) ? ""
										: BRF33.getR4_product_res().toString();
								R4cell1.setCellValue(value);
							}
							Cell R4cell2 = row4.getCell(3);
							if (R4cell2 != null) {
								String value = (BRF33.getR4_country() == null) ? "" : BRF33.getR4_country().toString();
								R4cell2.setCellValue(value);
							}
							Cell R4cell4 = row4.getCell(4);
							if (R4cell4 != null) {
								R4cell4.setCellValue(
										BRF33.getR4_amount() == null ? 0 : BRF33.getR4_amount().intValue());
							}
							/// row5
							Row row5 = sheet.getRow(12);
							Cell R5cell1 = row5.getCell(2);
							if (R5cell1 != null) {
								String value = (BRF33.getR5_product_res() == null) ? ""
										: BRF33.getR5_product_res().toString();
								R5cell1.setCellValue(value);
							}
							Cell R5cell2 = row5.getCell(3);
							if (R5cell2 != null) {
								String value = (BRF33.getR5_country() == null) ? "" : BRF33.getR5_country().toString();
								R5cell2.setCellValue(value);
							}
							Cell R5cell4 = row5.getCell(4);
							if (R5cell4 != null) {
								R5cell4.setCellValue(
										BRF33.getR5_amount() == null ? 0 : BRF33.getR5_amount().intValue());
							}
							/// row6
							Row row6 = sheet.getRow(13);
							Cell R6cell1 = row6.getCell(2);
							if (R6cell1 != null) {
								String value = (BRF33.getR6_product_res() == null) ? ""
										: BRF33.getR6_product_res().toString();
								R6cell1.setCellValue(value);
							}
							Cell R6cell2 = row6.getCell(3);
							if (R6cell2 != null) {
								String value = (BRF33.getR6_country() == null) ? "" : BRF33.getR6_country().toString();
								R6cell2.setCellValue(value);
							}
							Cell R6cell4 = row6.getCell(4);
							if (R6cell4 != null) {
								R6cell4.setCellValue(
										BRF33.getR6_amount() == null ? 0 : BRF33.getR6_amount().intValue());
							}
							/// row7
							Row row7 = sheet.getRow(14);
							Cell R7cell1 = row7.getCell(2);
							if (R7cell1 != null) {
								String value = (BRF33.getR7_product_res() == null) ? ""
										: BRF33.getR7_product_res().toString();
								R7cell1.setCellValue(value);
							}
							Cell R7cell2 = row7.getCell(3);
							if (R7cell2 != null) {
								String value = (BRF33.getR7_country() == null) ? "" : BRF33.getR7_country().toString();
								R7cell2.setCellValue(value);
							}
							Cell R7cell4 = row7.getCell(4);
							if (R7cell4 != null) {
								R7cell4.setCellValue(
										BRF33.getR7_amount() == null ? 0 : BRF33.getR7_amount().intValue());
							}
							/// row8
							Row row8 = sheet.getRow(15);
							Cell R8cell1 = row8.getCell(2);
							if (R8cell1 != null) {
								String value = (BRF33.getR8_product_res() == null) ? ""
										: BRF33.getR8_product_res().toString();
								R8cell1.setCellValue(value);
							}
							Cell R8cell2 = row8.getCell(3);
							if (R8cell2 != null) {
								String value = (BRF33.getR8_country() == null) ? "" : BRF33.getR8_country().toString();
								R8cell2.setCellValue(value);
							}
							Cell R8cell4 = row8.getCell(4);
							if (R8cell4 != null) {
								R8cell4.setCellValue(
										BRF33.getR8_amount() == null ? 0 : BRF33.getR8_amount().intValue());
							}
							/// row9
							Row row9 = sheet.getRow(16);
							Cell R9cell1 = row9.getCell(2);
							if (R9cell1 != null) {
								String value = (BRF33.getR9_product_res() == null) ? ""
										: BRF33.getR9_product_res().toString();
								R9cell1.setCellValue(value);
							}
							Cell R9cell2 = row9.getCell(3);
							if (R9cell2 != null) {
								String value = (BRF33.getR9_country() == null) ? "" : BRF33.getR9_country().toString();
								R9cell2.setCellValue(value);
							}
							Cell R9cell4 = row9.getCell(4);
							if (R9cell4 != null) {
								R9cell4.setCellValue(
										BRF33.getR9_amount() == null ? 0 : BRF33.getR9_amount().intValue());
							}
							/// row10
							Row row10 = sheet.getRow(17);
							Cell R10cell1 = row10.getCell(2);
							if (R10cell1 != null) {
								String value = (BRF33.getR10_product_res() == null) ? ""
										: BRF33.getR10_product_res().toString();
								R10cell1.setCellValue(value);
							}
							Cell R10cell2 = row10.getCell(3);
							if (R10cell2 != null) {
								String value = (BRF33.getR10_country() == null) ? ""
										: BRF33.getR10_country().toString();
								R10cell2.setCellValue(value);
							}
							Cell R10cell4 = row10.getCell(4);
							if (R10cell4 != null) {
								R10cell4.setCellValue(
										BRF33.getR10_amount() == null ? 0 : BRF33.getR10_amount().intValue());
							}
							/// row11
							Row row11 = sheet.getRow(18);
							Cell R11cell1 = row11.getCell(2);
							if (R11cell1 != null) {
								String value = (BRF33.getR11_product_res() == null) ? ""
										: BRF33.getR11_product_res().toString();
								R11cell1.setCellValue(value);
							}
							Cell R11cell2 = row11.getCell(3);
							if (R11cell2 != null) {
								String value = (BRF33.getR11_country() == null) ? ""
										: BRF33.getR11_country().toString();
								R11cell2.setCellValue(value);
							}
							Cell R11cell4 = row11.getCell(4);
							if (R11cell4 != null) {
								R11cell4.setCellValue(
										BRF33.getR11_amount() == null ? 0 : BRF33.getR11_amount().intValue());
							}
							/// row12
							Row row12 = sheet.getRow(19);
							Cell R12cell1 = row12.getCell(2);
							if (R12cell1 != null) {
								String value = (BRF33.getR12_product_res() == null) ? ""
										: BRF33.getR12_product_res().toString();
								R12cell1.setCellValue(value);
							}
							Cell R12cell2 = row12.getCell(3);
							if (R12cell2 != null) {
								String value = (BRF33.getR12_country() == null) ? ""
										: BRF33.getR12_country().toString();
								R12cell2.setCellValue(value);
							}
							Cell R12cell4 = row12.getCell(4);
							if (R12cell4 != null) {
								R12cell4.setCellValue(
										BRF33.getR12_amount() == null ? 0 : BRF33.getR12_amount().intValue());
							}
							/// row13
							Row row13 = sheet.getRow(20);
							Cell R13cell1 = row13.getCell(2);
							if (R13cell1 != null) {
								String value = (BRF33.getR13_product_res() == null) ? ""
										: BRF33.getR13_product_res().toString();
								R13cell1.setCellValue(value);
							}
							Cell R13cell2 = row13.getCell(3);
							if (R13cell2 != null) {
								String value = (BRF33.getR13_country() == null) ? ""
										: BRF33.getR13_country().toString();
								R13cell2.setCellValue(value);
							}
							Cell R13cell4 = row13.getCell(4);
							if (R13cell4 != null) {
								R13cell4.setCellValue(
										BRF33.getR13_amount() == null ? 0 : BRF33.getR13_amount().intValue());
							}
							/// row14
							Row row14 = sheet.getRow(21);
							Cell R14cell1 = row14.getCell(2);
							if (R14cell1 != null) {
								String value = (BRF33.getR14_product_res() == null) ? ""
										: BRF33.getR14_product_res().toString();
								R14cell1.setCellValue(value);
							}
							Cell R14cell2 = row14.getCell(3);
							if (R14cell2 != null) {
								String value = (BRF33.getR14_country() == null) ? ""
										: BRF33.getR14_country().toString();
								R14cell2.setCellValue(value);
							}
							Cell R14cell4 = row14.getCell(4);
							if (R14cell4 != null) {
								R14cell4.setCellValue(
										BRF33.getR14_amount() == null ? 0 : BRF33.getR14_amount().intValue());
							}
							/// row15
							Row row15 = sheet.getRow(22);
							Cell R15cell1 = row15.getCell(2);
							if (R15cell1 != null) {
								String value = (BRF33.getR15_product_res() == null) ? ""
										: BRF33.getR15_product_res().toString();
								R15cell1.setCellValue(value);
							}
							Cell R15cell2 = row15.getCell(3);
							if (R15cell2 != null) {
								String value = (BRF33.getR15_country() == null) ? ""
										: BRF33.getR15_country().toString();
								R15cell2.setCellValue(value);
							}
							Cell R15cell4 = row15.getCell(4);
							if (R15cell4 != null) {
								R15cell4.setCellValue(
										BRF33.getR15_amount() == null ? 0 : BRF33.getR15_amount().intValue());
							}
							/// row16
							Row row16 = sheet.getRow(27);
							Cell R16cell1 = row16.getCell(2);
							if (R16cell1 != null) {
								String value = (BRF33.getR16_product_nonres() == null) ? ""
										: BRF33.getR16_product_nonres().toString();
								R16cell1.setCellValue(value);
							}
							Cell R16cell2 = row16.getCell(3);
							if (R16cell2 != null) {
								String value = (BRF33.getR16_country_dom() == null) ? ""
										: BRF33.getR16_country_dom().toString();
								R16cell2.setCellValue(value);
							}
							Cell R16cell4 = row16.getCell(4);
							if (R16cell4 != null) {
								R16cell4.setCellValue(
										BRF33.getR16_amount() == null ? 0 : BRF33.getR16_amount().intValue());
							}
							/// row17
							Row row17 = sheet.getRow(28);
							Cell R17cell1 = row17.getCell(2);
							if (R17cell1 != null) {
								String value = (BRF33.getR17_product_nonres() == null) ? ""
										: BRF33.getR17_product_nonres().toString();
								R17cell1.setCellValue(value);
							}
							Cell R17cell2 = row17.getCell(3);
							if (R17cell2 != null) {
								String value = (BRF33.getR17_country_dom() == null) ? ""
										: BRF33.getR17_country_dom().toString();
								R17cell2.setCellValue(value);
							}
							Cell R17cell4 = row17.getCell(4);
							if (R17cell4 != null) {
								R17cell4.setCellValue(
										BRF33.getR17_amount() == null ? 0 : BRF33.getR17_amount().intValue());
							}
							/// row18
							Row row18 = sheet.getRow(29);
							Cell R18cell1 = row18.getCell(2);
							if (R18cell1 != null) {
								String value = (BRF33.getR18_product_nonres() == null) ? ""
										: BRF33.getR18_product_nonres().toString();
								R18cell1.setCellValue(value);
							}
							Cell R18cell2 = row18.getCell(3);
							if (R18cell2 != null) {
								String value = (BRF33.getR18_country_dom() == null) ? ""
										: BRF33.getR18_country_dom().toString();
								R18cell2.setCellValue(value);
							}
							Cell R18cell4 = row18.getCell(4);
							if (R18cell4 != null) {
								R18cell4.setCellValue(
										BRF33.getR18_amount() == null ? 0 : BRF33.getR18_amount().intValue());
							}
							/// row19
							Row row19 = sheet.getRow(30);
							Cell R19cell1 = row19.getCell(2);
							if (R19cell1 != null) {
								String value = (BRF33.getR19_product_nonres() == null) ? ""
										: BRF33.getR19_product_nonres().toString();
								R19cell1.setCellValue(value);
							}
							Cell R19cell2 = row19.getCell(3);
							if (R19cell2 != null) {
								String value = (BRF33.getR19_country_dom() == null) ? ""
										: BRF33.getR19_country_dom().toString();
								R19cell2.setCellValue(value);
							}
							Cell R19cell4 = row19.getCell(4);
							if (R19cell4 != null) {
								R19cell4.setCellValue(
										BRF33.getR19_amount() == null ? 0 : BRF33.getR19_amount().intValue());
							}
							/// row20
							Row row20 = sheet.getRow(31);
							Cell R20cell1 = row20.getCell(2);
							if (R20cell1 != null) {
								String value = (BRF33.getR20_product_nonres() == null) ? ""
										: BRF33.getR20_product_nonres().toString();
								R20cell1.setCellValue(value);
							}
							Cell R20cell2 = row20.getCell(3);
							if (R20cell2 != null) {
								String value = (BRF33.getR20_country_dom() == null) ? ""
										: BRF33.getR20_country_dom().toString();
								R20cell2.setCellValue(value);
							}
							Cell R20cell4 = row20.getCell(4);
							if (R20cell4 != null) {
								R20cell4.setCellValue(
										BRF33.getR20_amount() == null ? 0 : BRF33.getR20_amount().intValue());
							}
							/// row21
							Row row21 = sheet.getRow(32);
							Cell R21cell1 = row21.getCell(2);
							if (R21cell1 != null) {
								String value = (BRF33.getR21_product_nonres() == null) ? ""
										: BRF33.getR21_product_nonres().toString();
								R21cell1.setCellValue(value);
							}
							Cell R21cell2 = row21.getCell(3);
							if (R21cell2 != null) {
								String value = (BRF33.getR21_country_dom() == null) ? ""
										: BRF33.getR21_country_dom().toString();
								R21cell2.setCellValue(value);
							}
							Cell R21cell4 = row21.getCell(4);
							if (R21cell4 != null) {
								R21cell4.setCellValue(
										BRF33.getR21_amount() == null ? 0 : BRF33.getR21_amount().intValue());
							}
							/// row22
							Row row22 = sheet.getRow(33);
							Cell R22cell1 = row22.getCell(2);
							if (R22cell1 != null) {
								String value = (BRF33.getR22_product_nonres() == null) ? ""
										: BRF33.getR22_product_nonres().toString();
								R22cell1.setCellValue(value);
							}
							Cell R22cell2 = row22.getCell(3);
							if (R22cell2 != null) {
								String value = (BRF33.getR22_country_dom() == null) ? ""
										: BRF33.getR22_country_dom().toString();
								R22cell2.setCellValue(value);
							}
							Cell R22cell4 = row22.getCell(4);
							if (R22cell4 != null) {
								R22cell4.setCellValue(
										BRF33.getR22_amount() == null ? 0 : BRF33.getR22_amount().intValue());
							}
							/// row23
							Row row23 = sheet.getRow(34);
							Cell R23cell1 = row23.getCell(2);
							if (R23cell1 != null) {
								String value = (BRF33.getR23_product_nonres() == null) ? ""
										: BRF33.getR23_product_nonres().toString();
								R23cell1.setCellValue(value);
							}
							Cell R23cell2 = row23.getCell(3);
							if (R23cell2 != null) {
								String value = (BRF33.getR23_country_dom() == null) ? ""
										: BRF33.getR23_country_dom().toString();
								R23cell2.setCellValue(value);
							}
							Cell R23cell4 = row23.getCell(4);
							if (R23cell4 != null) {
								R23cell4.setCellValue(
										BRF33.getR23_amount() == null ? 0 : BRF33.getR23_amount().intValue());
							}
							/// row24
							Row row24 = sheet.getRow(35);
							Cell R24cell1 = row24.getCell(2);
							if (R24cell1 != null) {
								String value = (BRF33.getR24_product_nonres() == null) ? ""
										: BRF33.getR24_product_nonres().toString();
								R24cell1.setCellValue(value);
							}
							Cell R24cell2 = row24.getCell(3);
							if (R24cell2 != null) {
								String value = (BRF33.getR24_country_dom() == null) ? ""
										: BRF33.getR24_country_dom().toString();
								R24cell2.setCellValue(value);
							}
							Cell R24cell4 = row24.getCell(4);
							if (R24cell4 != null) {
								R24cell4.setCellValue(
										BRF33.getR24_amount() == null ? 0 : BRF33.getR24_amount().intValue());
							}
							/// row25
							Row row25 = sheet.getRow(36);
							Cell R25cell1 = row25.getCell(2);
							if (R25cell1 != null) {
								String value = (BRF33.getR25_product_nonres() == null) ? ""
										: BRF33.getR25_product_nonres().toString();
								R25cell1.setCellValue(value);
							}
							Cell R25cell2 = row25.getCell(3);
							if (R25cell2 != null) {
								String value = (BRF33.getR25_country_dom() == null) ? ""
										: BRF33.getR25_country_dom().toString();
								R25cell2.setCellValue(value);
							}
							Cell R25cell4 = row25.getCell(4);
							if (R25cell4 != null) {
								R25cell4.setCellValue(
										BRF33.getR25_amount() == null ? 0 : BRF33.getR25_amount().intValue());
							}
							/// row26
							Row row26 = sheet.getRow(37);
							Cell R26cell1 = row26.getCell(2);
							if (R26cell1 != null) {
								String value = (BRF33.getR26_product_nonres() == null) ? ""
										: BRF33.getR26_product_nonres().toString();
								R26cell1.setCellValue(value);
							}
							Cell R26cell2 = row26.getCell(3);
							if (R26cell2 != null) {
								String value = (BRF33.getR26_country_dom() == null) ? ""
										: BRF33.getR26_country_dom().toString();
								R26cell2.setCellValue(value);
							}
							Cell R26cell4 = row26.getCell(4);
							if (R26cell4 != null) {
								R26cell4.setCellValue(
										BRF33.getR26_amount() == null ? 0 : BRF33.getR26_amount().intValue());
							}
							/// row27
							Row row27 = sheet.getRow(38);
							Cell R27cell1 = row27.getCell(2);
							if (R27cell1 != null) {
								String value = (BRF33.getR27_product_nonres() == null) ? ""
										: BRF33.getR27_product_nonres().toString();
								R27cell1.setCellValue(value);
							}
							Cell R27cell2 = row27.getCell(3);
							if (R27cell2 != null) {
								String value = (BRF33.getR27_country_dom() == null) ? ""
										: BRF33.getR27_country_dom().toString();
								R27cell2.setCellValue(value);
							}
							Cell R27cell4 = row27.getCell(4);
							if (R27cell4 != null) {
								R27cell4.setCellValue(
										BRF33.getR27_amount() == null ? 0 : BRF33.getR27_amount().intValue());
							}
							/// row28
							Row row28 = sheet.getRow(39);
							Cell R28cell1 = row28.getCell(2);
							if (R28cell1 != null) {
								String value = (BRF33.getR28_product_nonres() == null) ? ""
										: BRF33.getR28_product_nonres().toString();
								R28cell1.setCellValue(value);
							}
							Cell R28cell2 = row28.getCell(3);
							if (R28cell2 != null) {
								String value = (BRF33.getR28_country_dom() == null) ? ""
										: BRF33.getR28_country_dom().toString();
								R28cell2.setCellValue(value);
							}
							Cell R28cell4 = row28.getCell(4);
							if (R28cell4 != null) {
								R28cell4.setCellValue(
										BRF33.getR28_amount() == null ? 0 : BRF33.getR28_amount().intValue());
							}
							/// row29
							Row row29 = sheet.getRow(40);
							Cell R29cell1 = row29.getCell(2);
							if (R29cell1 != null) {
								String value = (BRF33.getR29_product_nonres() == null) ? ""
										: BRF33.getR29_product_nonres().toString();
								R29cell1.setCellValue(value);
							}
							Cell R29cell2 = row29.getCell(3);
							if (R29cell2 != null) {
								String value = (BRF33.getR29_country_dom() == null) ? ""
										: BRF33.getR29_country_dom().toString();
								R29cell2.setCellValue(value);
							}
							Cell R29cell4 = row29.getCell(4);
							if (R29cell4 != null) {
								R29cell4.setCellValue(
										BRF33.getR29_amount() == null ? 0 : BRF33.getR29_amount().intValue());
							}
							/// row30
							Row row30 = sheet.getRow(41);
							Cell R30cell1 = row30.getCell(2);
							if (R30cell1 != null) {
								String value = (BRF33.getR30_product_nonres() == null) ? ""
										: BRF33.getR30_product_nonres().toString();
								R30cell1.setCellValue(value);
							}
							Cell R30cell2 = row30.getCell(3);
							if (R30cell2 != null) {
								String value = (BRF33.getR30_country_dom() == null) ? ""
										: BRF33.getR30_country_dom().toString();
								R30cell2.setCellValue(value);
							}
							Cell R30cell4 = row30.getCell(4);
							if (R30cell4 != null) {
								R30cell4.setCellValue(
										BRF33.getR30_amount() == null ? 0 : BRF33.getR30_amount().intValue());
							}
							/// row31
							Row row31 = sheet.getRow(46);
							Cell R31cell1 = row31.getCell(2);
							if (R31cell1 != null) {
								String value = (BRF33.getR31_product_bor() == null) ? ""
										: BRF33.getR31_product_bor().toString();
								R31cell1.setCellValue(value);
							}
							Cell R31cell2 = row31.getCell(3);
							if (R31cell2 != null) {
								String value = (BRF33.getR31_country_ho() == null) ? ""
										: BRF33.getR31_country_ho().toString();
								R31cell2.setCellValue(value);
							}
							Cell R31cell4 = row31.getCell(4);
							if (R31cell4 != null) {
								R31cell4.setCellValue(
										BRF33.getR31_amount() == null ? 0 : BRF33.getR31_amount().intValue());
							}
							/// row32
							Row row32 = sheet.getRow(47);
							Cell R32cell1 = row32.getCell(2);
							if (R32cell1 != null) {
								String value = (BRF33.getR32_product_bor() == null) ? ""
										: BRF33.getR32_product_bor().toString();
								R32cell1.setCellValue(value);
							}
							Cell R32cell2 = row32.getCell(3);
							if (R32cell2 != null) {
								String value = (BRF33.getR32_country_ho() == null) ? ""
										: BRF33.getR32_country_ho().toString();
								R32cell2.setCellValue(value);
							}
							Cell R32cell4 = row32.getCell(4);
							if (R32cell4 != null) {
								R32cell4.setCellValue(
										BRF33.getR32_amount() == null ? 0 : BRF33.getR32_amount().intValue());
							}
							/// row33
							Row row33 = sheet.getRow(48);
							Cell R33cell1 = row33.getCell(2);
							if (R33cell1 != null) {
								String value = (BRF33.getR33_product_bor() == null) ? ""
										: BRF33.getR33_product_bor().toString();
								R33cell1.setCellValue(value);
							}
							Cell R33cell2 = row33.getCell(3);
							if (R33cell2 != null) {
								String value = (BRF33.getR33_country_ho() == null) ? ""
										: BRF33.getR33_country_ho().toString();
								R33cell2.setCellValue(value);
							}
							Cell R33cell4 = row33.getCell(4);
							if (R33cell4 != null) {
								R33cell4.setCellValue(
										BRF33.getR33_amount() == null ? 0 : BRF33.getR33_amount().intValue());
							}
							/// row34
							Row row34 = sheet.getRow(49);
							Cell R34cell1 = row34.getCell(2);
							if (R34cell1 != null) {
								String value = (BRF33.getR34_product_bor() == null) ? ""
										: BRF33.getR34_product_bor().toString();
								R34cell1.setCellValue(value);
							}
							Cell R34cell2 = row34.getCell(3);
							if (R34cell2 != null) {
								String value = (BRF33.getR34_country_ho() == null) ? ""
										: BRF33.getR34_country_ho().toString();
								R34cell2.setCellValue(value);
							}
							Cell R34cell4 = row34.getCell(4);
							if (R34cell4 != null) {
								R34cell4.setCellValue(
										BRF33.getR34_amount() == null ? 0 : BRF33.getR34_amount().intValue());
							}
							/// row35
							Row row35 = sheet.getRow(50);
							Cell R35cell1 = row35.getCell(2);
							if (R35cell1 != null) {
								String value = (BRF33.getR35_product_bor() == null) ? ""
										: BRF33.getR35_product_bor().toString();
								R35cell1.setCellValue(value);
							}
							Cell R35cell2 = row35.getCell(3);
							if (R35cell2 != null) {
								String value = (BRF33.getR35_country_ho() == null) ? ""
										: BRF33.getR35_country_ho().toString();
								R35cell2.setCellValue(value);
							}
							Cell R35cell4 = row35.getCell(4);
							if (R35cell4 != null) {
								R35cell4.setCellValue(
										BRF33.getR35_amount() == null ? 0 : BRF33.getR35_amount().intValue());
							}
							/// row36
							Row row36 = sheet.getRow(51);
							Cell R36cell1 = row36.getCell(2);
							if (R36cell1 != null) {
								String value = (BRF33.getR36_product_bor() == null) ? ""
										: BRF33.getR36_product_bor().toString();
								R36cell1.setCellValue(value);
							}
							Cell R36cell2 = row36.getCell(3);
							if (R36cell2 != null) {
								String value = (BRF33.getR36_country_ho() == null) ? ""
										: BRF33.getR36_country_ho().toString();
								R36cell2.setCellValue(value);
							}
							Cell R36cell4 = row36.getCell(4);
							if (R36cell4 != null) {
								R36cell4.setCellValue(
										BRF33.getR36_amount() == null ? 0 : BRF33.getR36_amount().intValue());
							}
							/// row37
							Row row37 = sheet.getRow(52);
							Cell R37cell1 = row37.getCell(2);
							if (R37cell1 != null) {
								String value = (BRF33.getR37_product_bor() == null) ? ""
										: BRF33.getR37_product_bor().toString();
								R37cell1.setCellValue(value);
							}
							Cell R37cell2 = row37.getCell(3);
							if (R37cell2 != null) {
								String value = (BRF33.getR37_country_ho() == null) ? ""
										: BRF33.getR37_country_ho().toString();
								R37cell2.setCellValue(value);
							}
							Cell R37cell4 = row37.getCell(4);
							if (R37cell4 != null) {
								R37cell4.setCellValue(
										BRF33.getR37_amount() == null ? 0 : BRF33.getR37_amount().intValue());
							}
							/// row38
							Row row38 = sheet.getRow(53);
							Cell R38cell1 = row38.getCell(2);
							if (R38cell1 != null) {
								String value = (BRF33.getR38_product_bor() == null) ? ""
										: BRF33.getR38_product_bor().toString();
								R38cell1.setCellValue(value);
							}
							Cell R38cell2 = row38.getCell(3);
							if (R38cell2 != null) {
								String value = (BRF33.getR38_country_ho() == null) ? ""
										: BRF33.getR38_country_ho().toString();
								R38cell2.setCellValue(value);
							}
							Cell R38cell4 = row38.getCell(4);
							if (R38cell4 != null) {
								R38cell4.setCellValue(
										BRF33.getR38_amount() == null ? 0 : BRF33.getR38_amount().intValue());
							}
							/// row39
							Row row39 = sheet.getRow(54);
							Cell R39cell1 = row39.getCell(2);
							if (R39cell1 != null) {
								String value = (BRF33.getR39_product_bor() == null) ? ""
										: BRF33.getR39_product_bor().toString();
								R39cell1.setCellValue(value);
							}
							Cell R39cell2 = row39.getCell(3);
							if (R39cell2 != null) {
								String value = (BRF33.getR39_country_ho() == null) ? ""
										: BRF33.getR39_country_ho().toString();
								R39cell2.setCellValue(value);
							}
							Cell R39cell4 = row39.getCell(4);
							if (R39cell4 != null) {
								R39cell4.setCellValue(
										BRF33.getR39_amount() == null ? 0 : BRF33.getR39_amount().intValue());
							}
							/// row40
							Row row40 = sheet.getRow(55);
							Cell R40cell1 = row40.getCell(2);
							if (R40cell1 != null) {
								String value = (BRF33.getR40_product_bor() == null) ? ""
										: BRF33.getR40_product_bor().toString();
								R40cell1.setCellValue(value);
							}
							Cell R40cell2 = row40.getCell(3);
							if (R40cell2 != null) {
								String value = (BRF33.getR40_country_ho() == null) ? ""
										: BRF33.getR40_country_ho().toString();
								R40cell2.setCellValue(value);
							}
							Cell R40cell4 = row40.getCell(4);
							if (R40cell4 != null) {
								R40cell4.setCellValue(
										BRF33.getR40_amount() == null ? 0 : BRF33.getR40_amount().intValue());
							}
							/// row41
							Row row41 = sheet.getRow(56);
							Cell R41cell1 = row41.getCell(2);
							if (R41cell1 != null) {
								String value = (BRF33.getR41_product_bor() == null) ? ""
										: BRF33.getR41_product_bor().toString();
								R41cell1.setCellValue(value);
							}
							Cell R41cell2 = row41.getCell(3);
							if (R41cell2 != null) {
								String value = (BRF33.getR41_country_ho() == null) ? ""
										: BRF33.getR41_country_ho().toString();
								R41cell2.setCellValue(value);
							}
							Cell R41cell4 = row41.getCell(4);
							if (R41cell4 != null) {
								R41cell4.setCellValue(
										BRF33.getR41_amount() == null ? 0 : BRF33.getR41_amount().intValue());
							}
							/// row42
							Row row42 = sheet.getRow(57);
							Cell R42cell1 = row42.getCell(2);
							if (R42cell1 != null) {
								String value = (BRF33.getR42_product_bor() == null) ? ""
										: BRF33.getR42_product_bor().toString();
								R42cell1.setCellValue(value);
							}
							Cell R42cell2 = row42.getCell(3);
							if (R42cell2 != null) {
								String value = (BRF33.getR42_country_ho() == null) ? ""
										: BRF33.getR42_country_ho().toString();
								R42cell2.setCellValue(value);
							}
							Cell R42cell4 = row42.getCell(4);
							if (R42cell4 != null) {
								R42cell4.setCellValue(
										BRF33.getR42_amount() == null ? 0 : BRF33.getR42_amount().intValue());
							}
							/// row43
							Row row43 = sheet.getRow(58);
							Cell R43cell1 = row43.getCell(2);
							if (R43cell1 != null) {
								String value = (BRF33.getR43_product_bor() == null) ? ""
										: BRF33.getR43_product_bor().toString();
								R43cell1.setCellValue(value);
							}
							Cell R43cell2 = row43.getCell(3);
							if (R43cell2 != null) {
								String value = (BRF33.getR43_country_ho() == null) ? ""
										: BRF33.getR43_country_ho().toString();
								R43cell2.setCellValue(value);
							}
							Cell R43cell4 = row43.getCell(4);
							if (R43cell4 != null) {
								R43cell4.setCellValue(
										BRF33.getR43_amount() == null ? 0 : BRF33.getR43_amount().intValue());
							}
							/// row44
							Row row44 = sheet.getRow(59);
							Cell R44cell1 = row44.getCell(2);
							if (R44cell1 != null) {
								String value = (BRF33.getR44_product_bor() == null) ? ""
										: BRF33.getR44_product_bor().toString();
								R44cell1.setCellValue(value);
							}
							Cell R44cell2 = row44.getCell(3);
							if (R44cell2 != null) {
								String value = (BRF33.getR44_country_ho() == null) ? ""
										: BRF33.getR44_country_ho().toString();
								R44cell2.setCellValue(value);
							}
							Cell R44cell4 = row44.getCell(4);
							if (R44cell4 != null) {
								R44cell4.setCellValue(
										BRF33.getR44_amount() == null ? 0 : BRF33.getR44_amount().intValue());
							}
							/// row45
							Row row45 = sheet.getRow(60);
							Cell R45cell1 = row45.getCell(2);
							if (R45cell1 != null) {
								String value = (BRF33.getR45_product_bor() == null) ? ""
										: BRF33.getR45_product_bor().toString();
								R45cell1.setCellValue(value);
							}
							Cell R45cell2 = row45.getCell(3);
							if (R45cell2 != null) {
								String value = (BRF33.getR45_country_ho() == null) ? ""
										: BRF33.getR45_country_ho().toString();
								R45cell2.setCellValue(value);
							}
							Cell R45cell4 = row45.getCell(4);
							if (R45cell4 != null) {
								R45cell4.setCellValue(
										BRF33.getR45_amount() == null ? 0 : BRF33.getR45_amount().intValue());
							}
						}
					}
					workbook.getCreationHelper().createFormulaEvaluator().evaluateAll();
					FileOutputStream fileOut = new FileOutputStream(
							env.getProperty("output.exportpathfinal") + "011-BRF-033-A.xls");
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
		outputFile = new File(env.getProperty("output.exportpathfinal") + "011-BRF-033-A.xls");

		return outputFile;

	}

	public String detailChanges33(BRF33_DETAIL_ENTITY detail, String foracid, String report_addl_criteria_1,
			BigDecimal acct_balance_amt_lc, String report_label_1, String report_name_1) {

		String msg = "";

		try {

			Session hs = sessionFactory.getCurrentSession();
			Optional<BRF33_DETAIL_ENTITY> Brf33detail = BRF33_DetailRep1.findById(foracid);

			if (Brf33detail.isPresent()) {
				BRF33_DETAIL_ENTITY BRFdetail = Brf33detail.get();

				if (BRFdetail.getReport_label_1().equals(report_label_1)
						&& BRFdetail.getReport_name_1().equals(report_name_1)
						&& BRFdetail.getAct_balance_amt_lc().equals(acct_balance_amt_lc)
						&& BRFdetail.getReport_addl_criteria_1().equals(report_addl_criteria_1)

				) {
					msg = "No modification done";
				} else {

					BRFdetail.setAct_balance_amt_lc(acct_balance_amt_lc);
					BRFdetail.setReport_label_1(report_label_1);
					BRFdetail.setReport_name_1(report_name_1);
					BRFdetail.setReport_addl_criteria_1(report_addl_criteria_1);
					BRF33_DetailRep1.save(BRFdetail);

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

	public ModelAndView getArchieveBRF033View(String reportId, String fromdate, String todate, String currency,
			String dtltype, Pageable pageable) {

		ModelAndView mv = new ModelAndView();
		Session hs = sessionFactory.getCurrentSession();
		int pageSize = pageable.getPageSize();
		int currentPage = pageable.getPageNumber();
		int startItem = currentPage * pageSize;
		List<BRF33_ENTITY> T1rep = new ArrayList<BRF33_ENTITY>();
		// Query<Object[]> qr;

		List<BRF33_ENTITY> T1Master = new ArrayList<BRF33_ENTITY>();
		/* List<BRF73_TABLE2> T1Master1 = new ArrayList<BRF73_TABLE2>(); */

		logger.info("Inside archive" + currency);

		try {
			Date d1 = df.parse(todate);
			// T1rep = t1CurProdServiceRepo.getT1CurProdServices(d1);

			T1Master = hs.createQuery("from  BRF33_ENTITY a where a.report_date = ?1 ", BRF33_ENTITY.class)
					.setParameter(1, df.parse(todate)).getResultList();

			/*
			 * T1Master1 = hs.createQuery("from BRF73_TABLE2 a where a.report_date = ?1 ",
			 * BRF73_TABLE2.class) .setParameter(1, df.parse(todate)).getResultList();
			 */

		} catch (ParseException e) {
			e.printStackTrace();
		}

		// T1rep = t1CurProdServiceRepo.getT1CurProdServices(d1);

		mv.setViewName("RR/BRF033ARCH");
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

	public ModelAndView ARCHgetBRF033currentDtl(String reportId, String fromdate, String todate, String currency,
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

				qr = hs.createNativeQuery("select * from BRF33_ARCHIVTABLE a where report_date=?1 and report_label=?2");
				qr.setParameter(1, df.parse(todate));
				qr.setParameter(2, filter);

			} else {
				System.out.println("2");
				qr = hs.createNativeQuery("select * from BRF33_ARCHIVTABLE");

			}
		} else {
			System.out.println("3");
			qr = hs.createNativeQuery("select * from BRF33_ARCHIVTABLE  where report_date = ?1");
		}

		List<BRF33_ARCHIV_ENTITY> T1Master = new ArrayList<BRF33_ARCHIV_ENTITY>();

		try {
			System.out.println("Values entered");
			T1Master = hs.createQuery("from BRF33_ARCHIV_ENTITY a where a.report_date = ?1", BRF33_ARCHIV_ENTITY.class)
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
			String gender = (String) a[46];
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

			BRF33_ARCHIV_ENTITY py = new BRF33_ARCHIV_ENTITY(cust_id, foracid, act_balance_amt_lc, eab_lc, acct_name,
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

		mv.setViewName("RR" + "/" + "BRF033ARCH::reportcontent");
		mv.addObject("reportdetails", T1Dt1Page.getContent());
		mv.addObject("reportmaster", T1Master);
		mv.addObject("reportmaster1", qr);
		mv.addObject("singledetail", new T1CurProdDetail());
		mv.addObject("reportsflag", "reportsflag");
		mv.addObject("menu", reportId);
		return mv;
	}

	public String detailChanges33(BRF32_DETAIL_ENTITY detail, String foracid, String report_addl_criteria_1,
			BigDecimal act_balance_amt_lc, String report_label_1, String report_name_1) {
		// TODO Auto-generated method stub
		return null;
	}

}
