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

import com.bornfire.xbrl.entities.BRBS.BRF10DetailRep;
import com.bornfire.xbrl.entities.BRBS.BRF10_ARCHIVENTITY;
import com.bornfire.xbrl.entities.BRBS.BRF10_DETAIL_ENTITY;
import com.bornfire.xbrl.entities.BRBS.BRF10_ENTITY;
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
public class BRF010ReportService {

	private static final Logger logger = LoggerFactory.getLogger(BRF010ReportService.class);

	@Autowired
	SessionFactory sessionFactory;

	@Autowired
	DataSource srcdataSource;

	@Autowired
	Environment env;

	/*
	 * @Autowired BRF73ServiceRepo brf73ServiceRepo;
	 */

	@Autowired
	BRF10DetailRep brf10DetailRep;

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
			Long dtlcnt = (Long) hs.createQuery("select count(*) from BRF10_ENTITY a where a.report_date=?1")
					.setParameter(1, dt9).getSingleResult();

			if (dtlcnt > 0) {
				logger.info("Getting No of records in Mod table :" + reportid);
				Long modcnt = (Long) hs.createQuery("select count(*) from BRF10_ENTITY a").getSingleResult();
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

	public ModelAndView getBRF010View(String reportId, String fromdate, String todate, String currency, String dtltype,
			Pageable pageable) {

		ModelAndView mv = new ModelAndView();
		Session hs = sessionFactory.getCurrentSession();
		int pageSize = pageable.getPageSize();
		int currentPage = pageable.getPageNumber();
		int startItem = currentPage * pageSize;
		List<BRF10_ENTITY> T1rep = new ArrayList<BRF10_ENTITY>();
		// Query<Object[]> qr;

		List<BRF10_ENTITY> T1Master = new ArrayList<BRF10_ENTITY>();
		/* List<BRF73_TABLE2> T1Master1 = new ArrayList<BRF73_TABLE2>(); */

		logger.info("Inside archive" + currency);

		try {
			Date d1 = df.parse(todate);
			// T1rep = t1CurProdServiceRepo.getT1CurProdServices(d1);

			T1Master = hs.createQuery("from  BRF10_ENTITY a where a.report_date = ?1 ", BRF10_ENTITY.class)
					.setParameter(1, df.parse(todate)).getResultList();

			/*
			 * T1Master1 = hs.createQuery("from BRF73_TABLE2 a where a.report_date = ?1 ",
			 * BRF73_TABLE2.class) .setParameter(1, df.parse(todate)).getResultList();
			 */

		} catch (ParseException e) {
			e.printStackTrace();
		}

		// T1rep = t1CurProdServiceRepo.getT1CurProdServices(d1);

		mv.setViewName("RR/BRF10");
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

	public ModelAndView getBRF010currentDtl(String reportId, String fromdate, String todate, String currency,
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
						"select * from BRF10_DETAILTABLE  a where report_date = ?1 and report_label_1 =?2");

				qr.setParameter(2, filter);

			} else {
				qr = hs.createNativeQuery("SELECT * FROM BRF10_DETAILTABLE WHERE report_date = ?1");

			}
		} else {
			qr = hs.createNativeQuery("SELECT * FROM BRF10_DETAILTABLE WHERE report_date = ?1");
		}

		try {
			qr.setParameter(1, df.parse(todate));

		} catch (ParseException e) {
			e.printStackTrace();
		}
		List<BRF10_DETAIL_ENTITY> T1Master = new ArrayList<BRF10_DETAIL_ENTITY>();

		try {
			T1Master = hs.createQuery("from BRF10_DETAIL_ENTITY a where a.report_date = ?1", BRF10_DETAIL_ENTITY.class)
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

			BRF10_DETAIL_ENTITY py = new BRF10_DETAIL_ENTITY(cust_id, foracid, act_balance_amt_lc, eab_lc, acct_name,
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

		mv.setViewName("RR" + "/" + "BRF10::reportcontent");
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
		fileName = "011-BRF-010-A";
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

							jasperFile = this.getClass().getResourceAsStream("/static/jasper/BRF10_Detail.jrxml");
						} else {
							jasperFile = this.getClass().getResourceAsStream("/static/jasper/BRF10_Detail.jrxml");
						}

					} else {
						if (dtltype.equals("report")) {
							logger.info("Inside report");
							jasperFile = this.getClass().getResourceAsStream("/static/jasper/BRF10.jrxml");
						} else {
							jasperFile = this.getClass().getResourceAsStream("/static/jasper/BRF10.jrxml");
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


				List<BRF10_ENTITY> T1Master = new ArrayList<BRF10_ENTITY>();
				Session hs = sessionFactory.getCurrentSession();
				try {
					Date d1 = df.parse(todate);

					// T1rep = t1CurProdServiceRepo.getT1CurProdServices(d1);

					T1Master = hs.createQuery("from  BRF10_ENTITY a where a.report_date = ?1 ", BRF10_ENTITY.class)
							.setParameter(1, df.parse(todate)).getResultList();

					if (T1Master.size() == 1) {

						for (BRF10_ENTITY BRF010 : T1Master) {

							File Responsecamt = new File(
									env.getProperty("output.exportpathtemp") + "011-BRF-010-AT.xls");

							// Load the Excel file
							Workbook workbook = WorkbookFactory.create(Responsecamt);

							// Get the first sheet
							Sheet sheet = workbook.getSheetAt(0);
							
							
							
							/*
							 * Row row5 = sheet.getRow(4); if (row5 != null) { Cell R5cell =
							 * row5.getCell(2); if (R5cell == null) { R5cell = row5.createCell(2); // Create
							 * the cell if it doesn't exist } if (BRF010.getReport_date() != null) { //
							 * Formatting the date to dd-MM-yyyy SimpleDateFormat sdf = new
							 * SimpleDateFormat("dd-MM-yyyy"); String formattedDate =
							 * sdf.format(BRF010.getReport_date()); R5cell.setCellValue(formattedDate); //
							 * Set the formatted date in the cell } else { R5cell.setCellValue(""); // Set
							 * an empty value if the report_date is null } }
							 */
							///// srl_no -10/////////
							Row row10 = sheet.getRow(9);

							Cell R10cell = row10.getCell(2);
							if (R10cell != null) {
								R10cell.setCellValue(
										BRF010.getR10_6month_uae() == null ? 0 : BRF010.getR10_6month_uae().intValue());
							}
							Cell R10cell0 = row10.getCell(3);
							if (R10cell0 != null) {
								R10cell0.setCellValue(BRF010.getR10_12month_uae() == null ? 0
										: BRF010.getR10_12month_uae().intValue());
							}
							Cell R10cell1 = row10.getCell(4);
							if (R10cell1 != null) {
								R10cell1.setCellValue(
										BRF010.getR10_1year_uae() == null ? 0 : BRF010.getR10_1year_uae().intValue());
							}
							Cell R10cell2 = row10.getCell(5);
							if (R10cell2 != null) {
								R10cell2.setCellValue(BRF010.getR10_6month_other_uae() == null ? 0
										: BRF010.getR10_6month_other_uae().intValue());
							}
							Cell R10cell3 = row10.getCell(6);
							if (R10cell3 != null) {
								R10cell3.setCellValue(BRF010.getR10_12month_other_uae() == null ? 0
										: BRF010.getR10_12month_other_uae().intValue());
							}
							Cell R10cell4 = row10.getCell(7);
							if (R10cell4 != null) {
								R10cell4.setCellValue(BRF010.getR10_1year_other_uae() == null ? 0
										: BRF010.getR10_1year_other_uae().intValue());
							}
							Cell R10cell5 = row10.getCell(8);
							if (R10cell5 != null) {
								R10cell5.setCellValue(BRF010.getR10_6month_non_uae() == null ? 0
										: BRF010.getR10_6month_non_uae().intValue());
							}
							Cell R10cell6 = row10.getCell(9);
							if (R10cell6 != null) {
								R10cell6.setCellValue(BRF010.getR10_12month_non_uae() == null ? 0
										: BRF010.getR10_12month_non_uae().intValue());
							}
							Cell R10cell7 = row10.getCell(10);
							if (R10cell7 != null) {
								R10cell7.setCellValue(BRF010.getR10_1year_non_uae() == null ? 0
										: BRF010.getR10_1year_non_uae().intValue());
							}
							Cell R10cell8 = row10.getCell(11);
							if (R10cell8 != null) {
								R10cell8.setCellValue(BRF010.getR10_6month_other_non_uae() == null ? 0
										: BRF010.getR10_6month_other_non_uae().intValue());
							}
							Cell R10cell9 = row10.getCell(12);
							if (R10cell9 != null) {
								R10cell9.setCellValue(BRF010.getR10_12month_other_non_uae() == null ? 0
										: BRF010.getR10_12month_other_non_uae().intValue());
							}

							Cell R10cell10 = row10.getCell(13);
							if (R10cell10 != null) {
								R10cell10.setCellValue(BRF010.getR10_1year_other_non_uae() == null ? 0
										: BRF010.getR10_1year_other_non_uae().intValue());
							}

							Cell R10cell11 = row10.getCell(14);
							if (R10cell11 != null) {
								R10cell11.setCellValue(BRF010.getR10_other_assets() == null ? 0
										: BRF010.getR10_other_assets().intValue());
							}

							Cell R10cell12 = row10.getCell(17);
							if (R10cell12 != null) {
								R10cell12.setCellValue(BRF010.getR10_net_forward() == null ? 0
										: BRF010.getR10_net_forward().intValue());
							}

							///// srl_no -11/////////
							Row row11 = sheet.getRow(10);
							Cell R11cell = row11.getCell(2);
							if (R11cell != null) {
								R11cell.setCellValue(
										BRF010.getR11_6month_uae() == null ? 0 : BRF010.getR11_6month_uae().intValue());
							}
							Cell R11cell0 = row11.getCell(3);
							if (R11cell0 != null) {
								R11cell0.setCellValue(BRF010.getR11_12month_uae() == null ? 0
										: BRF010.getR11_12month_uae().intValue());
							}
							Cell R11cell1 = row11.getCell(4);
							if (R11cell1 != null) {
								R11cell1.setCellValue(
										BRF010.getR11_1year_uae() == null ? 0 : BRF010.getR11_1year_uae().intValue());
							}
							Cell R11cell2 = row11.getCell(5);
							if (R11cell2 != null) {
								R11cell2.setCellValue(BRF010.getR11_6month_other_uae() == null ? 0
										: BRF010.getR11_6month_other_uae().intValue());
							}
							Cell R11cell3 = row11.getCell(6);
							if (R11cell3 != null) {
								R11cell3.setCellValue(BRF010.getR11_12month_other_uae() == null ? 0
										: BRF010.getR11_12month_other_uae().intValue());
							}
							Cell R11cell4 = row11.getCell(7);
							if (R11cell4 != null) {
								R11cell4.setCellValue(BRF010.getR11_1year_other_uae() == null ? 0
										: BRF010.getR11_1year_other_uae().intValue());
							}
							Cell R11cell5 = row11.getCell(8);
							if (R11cell5 != null) {
								R11cell5.setCellValue(BRF010.getR11_6month_non_uae() == null ? 0
										: BRF010.getR11_6month_non_uae().intValue());
							}
							Cell R11cell6 = row11.getCell(9);
							if (R11cell6 != null) {
								R11cell6.setCellValue(BRF010.getR11_12month_non_uae() == null ? 0
										: BRF010.getR11_12month_non_uae().intValue());
							}
							Cell R11cell7 = row11.getCell(10);
							if (R11cell7 != null) {
								R11cell7.setCellValue(BRF010.getR11_1year_non_uae() == null ? 0
										: BRF010.getR11_1year_non_uae().intValue());
							}
							Cell R11cell8 = row11.getCell(11);
							if (R11cell8 != null) {
								R11cell8.setCellValue(BRF010.getR11_6month_other_non_uae() == null ? 0
										: BRF010.getR11_6month_other_non_uae().intValue());
							}
							Cell R11cell9 = row11.getCell(12);
							if (R11cell9 != null) {
								R11cell9.setCellValue(BRF010.getR11_12month_other_non_uae() == null ? 0
										: BRF010.getR11_12month_other_non_uae().intValue());
							}

							Cell R11cell10 = row11.getCell(13);
							if (R11cell10 != null) {
								R11cell10.setCellValue(BRF010.getR11_1year_other_non_uae() == null ? 0
										: BRF010.getR11_1year_other_non_uae().intValue());
							}

							Cell R11cell11 = row11.getCell(14);
							if (R11cell11 != null) {
								R11cell11.setCellValue(BRF010.getR11_other_assets() == null ? 0
										: BRF010.getR11_other_assets().intValue());
							}

							Cell R11cell12 = row11.getCell(17);
							if (R11cell12 != null) {
								R11cell12.setCellValue(BRF010.getR11_net_forward() == null ? 0
										: BRF010.getR11_net_forward().intValue());
							}

							///// srl_no -12/////////
							Row row12 = sheet.getRow(11);
							Cell R12cell = row12.getCell(2);
							if (R12cell != null) {
								R12cell.setCellValue(
										BRF010.getR12_6month_uae() == null ? 0 : BRF010.getR12_6month_uae().intValue());
							}
							Cell R12cell0 = row12.getCell(3);
							if (R12cell0 != null) {
								R12cell0.setCellValue(BRF010.getR12_12month_uae() == null ? 0
										: BRF010.getR12_12month_uae().intValue());
							}
							Cell R12cell1 = row12.getCell(4);
							if (R12cell1 != null) {
								R12cell1.setCellValue(
										BRF010.getR12_1year_uae() == null ? 0 : BRF010.getR12_1year_uae().intValue());
							}
							Cell R12cell2 = row12.getCell(5);
							if (R12cell2 != null) {
								R12cell2.setCellValue(BRF010.getR12_6month_other_uae() == null ? 0
										: BRF010.getR12_6month_other_uae().intValue());
							}
							Cell R12cell3 = row12.getCell(6);
							if (R12cell3 != null) {
								R12cell3.setCellValue(BRF010.getR12_12month_other_uae() == null ? 0
										: BRF010.getR12_12month_other_uae().intValue());
							}
							Cell R12cell4 = row12.getCell(7);
							if (R12cell4 != null) {
								R12cell4.setCellValue(BRF010.getR12_1year_other_uae() == null ? 0
										: BRF010.getR12_1year_other_uae().intValue());
							}
							Cell R12cell5 = row12.getCell(8);
							if (R12cell5 != null) {
								R12cell5.setCellValue(BRF010.getR12_6month_non_uae() == null ? 0
										: BRF010.getR12_6month_non_uae().intValue());
							}
							Cell R12cell6 = row12.getCell(9);
							if (R12cell6 != null) {
								R12cell6.setCellValue(BRF010.getR12_12month_non_uae() == null ? 0
										: BRF010.getR12_12month_non_uae().intValue());
							}
							Cell R12cell7 = row12.getCell(10);
							if (R12cell7 != null) {
								R12cell7.setCellValue(BRF010.getR12_1year_non_uae() == null ? 0
										: BRF010.getR12_1year_non_uae().intValue());
							}
							Cell R12cell8 = row12.getCell(11);
							if (R12cell8 != null) {
								R12cell8.setCellValue(BRF010.getR12_6month_other_non_uae() == null ? 0
										: BRF010.getR12_6month_other_non_uae().intValue());
							}
							Cell R12cell9 = row12.getCell(12);
							if (R12cell9 != null) {
								R12cell9.setCellValue(BRF010.getR12_12month_other_non_uae() == null ? 0
										: BRF010.getR12_12month_other_non_uae().intValue());
							}

							Cell R12cell10 = row12.getCell(13);
							if (R12cell10 != null) {
								R12cell10.setCellValue(BRF010.getR12_1year_other_non_uae() == null ? 0
										: BRF010.getR12_1year_other_non_uae().intValue());
							}

							Cell R12cell11 = row12.getCell(14);
							if (R12cell11 != null) {
								R12cell11.setCellValue(BRF010.getR12_other_assets() == null ? 0
										: BRF010.getR12_other_assets().intValue());
							}

							Cell R12cell12 = row12.getCell(17);
							if (R12cell12 != null) {
								R12cell12.setCellValue(BRF010.getR12_net_forward() == null ? 0
										: BRF010.getR12_net_forward().intValue());
							}

							///// srl_no -13/////////
							Row row13 = sheet.getRow(12);
							Cell R13cell = row13.getCell(2);
							if (R13cell != null) {
								R13cell.setCellValue(
										BRF010.getR13_6month_uae() == null ? 0 : BRF010.getR13_6month_uae().intValue());
							}
							Cell R13cell0 = row13.getCell(3);
							if (R13cell0 != null) {
								R13cell0.setCellValue(BRF010.getR13_12month_uae() == null ? 0
										: BRF010.getR13_12month_uae().intValue());
							}
							Cell R13cell1 = row13.getCell(4);
							if (R13cell1 != null) {
								R13cell1.setCellValue(
										BRF010.getR13_1year_uae() == null ? 0 : BRF010.getR13_1year_uae().intValue());
							}
							Cell R13cell2 = row13.getCell(5);
							if (R13cell2 != null) {
								R13cell2.setCellValue(BRF010.getR13_6month_other_uae() == null ? 0
										: BRF010.getR13_6month_other_uae().intValue());
							}
							Cell R13cell3 = row13.getCell(6);
							if (R13cell3 != null) {
								R13cell3.setCellValue(BRF010.getR13_12month_other_uae() == null ? 0
										: BRF010.getR13_12month_other_uae().intValue());
							}
							Cell R13cell4 = row13.getCell(7);
							if (R13cell4 != null) {
								R13cell4.setCellValue(BRF010.getR13_1year_other_uae() == null ? 0
										: BRF010.getR13_1year_other_uae().intValue());
							}
							Cell R13cell5 = row13.getCell(8);
							if (R13cell5 != null) {
								R13cell5.setCellValue(BRF010.getR13_6month_non_uae() == null ? 0
										: BRF010.getR13_6month_non_uae().intValue());
							}
							Cell R13cell6 = row13.getCell(9);
							if (R13cell6 != null) {
								R13cell6.setCellValue(BRF010.getR13_12month_non_uae() == null ? 0
										: BRF010.getR13_12month_non_uae().intValue());
							}
							Cell R13cell7 = row13.getCell(10);
							if (R13cell7 != null) {
								R13cell7.setCellValue(BRF010.getR13_1year_non_uae() == null ? 0
										: BRF010.getR13_1year_non_uae().intValue());
							}
							Cell R13cell8 = row13.getCell(11);
							if (R13cell8 != null) {
								R13cell8.setCellValue(BRF010.getR13_6month_other_non_uae() == null ? 0
										: BRF010.getR13_6month_other_non_uae().intValue());
							}
							Cell R13cell9 = row13.getCell(12);
							if (R13cell9 != null) {
								R13cell9.setCellValue(BRF010.getR13_12month_other_non_uae() == null ? 0
										: BRF010.getR13_12month_other_non_uae().intValue());
							}

							Cell R13cell10 = row13.getCell(13);
							if (R13cell10 != null) {
								R13cell10.setCellValue(BRF010.getR13_1year_other_non_uae() == null ? 0
										: BRF010.getR13_1year_other_non_uae().intValue());
							}

							Cell R13cell11 = row13.getCell(14);
							if (R13cell11 != null) {
								R13cell11.setCellValue(BRF010.getR13_other_assets() == null ? 0
										: BRF010.getR13_other_assets().intValue());
							}

							Cell R13cell12 = row13.getCell(17);
							if (R13cell12 != null) {
								R13cell12.setCellValue(BRF010.getR13_net_forward() == null ? 0
										: BRF010.getR13_net_forward().intValue());
							}

							///// srl_no -14/////////
							Row row14 = sheet.getRow(13);
							Cell R14cell = row14.getCell(2);
							if (R14cell != null) {
								R14cell.setCellValue(
										BRF010.getR14_6month_uae() == null ? 0 : BRF010.getR14_6month_uae().intValue());
							}
							Cell R14cell0 = row14.getCell(3);
							if (R14cell0 != null) {
								R14cell0.setCellValue(BRF010.getR14_12month_uae() == null ? 0
										: BRF010.getR14_12month_uae().intValue());
							}
							Cell R14cell1 = row14.getCell(4);
							if (R14cell1 != null) {
								R14cell1.setCellValue(
										BRF010.getR14_1year_uae() == null ? 0 : BRF010.getR14_1year_uae().intValue());
							}
							Cell R14cell2 = row14.getCell(5);
							if (R14cell2 != null) {
								R14cell2.setCellValue(BRF010.getR14_6month_other_uae() == null ? 0
										: BRF010.getR14_6month_other_uae().intValue());
							}
							Cell R14cell3 = row14.getCell(6);
							if (R14cell3 != null) {
								R14cell3.setCellValue(BRF010.getR14_12month_other_uae() == null ? 0
										: BRF010.getR14_12month_other_uae().intValue());
							}
							Cell R14cell4 = row14.getCell(7);
							if (R14cell4 != null) {
								R14cell4.setCellValue(BRF010.getR14_1year_other_uae() == null ? 0
										: BRF010.getR14_1year_other_uae().intValue());
							}
							Cell R14cell5 = row14.getCell(8);
							if (R14cell5 != null) {
								R14cell5.setCellValue(BRF010.getR14_6month_non_uae() == null ? 0
										: BRF010.getR14_6month_non_uae().intValue());
							}
							Cell R14cell6 = row14.getCell(9);
							if (R14cell6 != null) {
								R14cell6.setCellValue(BRF010.getR14_12month_non_uae() == null ? 0
										: BRF010.getR14_12month_non_uae().intValue());
							}
							Cell R14cell7 = row14.getCell(10);
							if (R14cell7 != null) {
								R14cell7.setCellValue(BRF010.getR14_1year_non_uae() == null ? 0
										: BRF010.getR14_1year_non_uae().intValue());
							}
							Cell R14cell8 = row14.getCell(11);
							if (R14cell8 != null) {
								R14cell8.setCellValue(BRF010.getR14_6month_other_non_uae() == null ? 0
										: BRF010.getR14_6month_other_non_uae().intValue());
							}
							Cell R14cell9 = row14.getCell(12);
							if (R14cell9 != null) {
								R14cell9.setCellValue(BRF010.getR14_12month_other_non_uae() == null ? 0
										: BRF010.getR14_12month_other_non_uae().intValue());
							}

							Cell R14cell10 = row14.getCell(13);
							if (R14cell10 != null) {
								R14cell10.setCellValue(BRF010.getR14_1year_other_non_uae() == null ? 0
										: BRF010.getR14_1year_other_non_uae().intValue());
							}

							Cell R14cell11 = row14.getCell(14);
							if (R14cell11 != null) {
								R14cell11.setCellValue(BRF010.getR14_other_assets() == null ? 0
										: BRF010.getR14_other_assets().intValue());
							}

							Cell R14cell12 = row14.getCell(17);
							if (R14cell12 != null) {
								R14cell12.setCellValue(BRF010.getR14_net_forward() == null ? 0
										: BRF010.getR14_net_forward().intValue());
							}

							///// srl_no -15/////////
							Row row15 = sheet.getRow(14);
							Cell R15cell = row15.getCell(2);
							if (R15cell != null) {
								R15cell.setCellValue(
										BRF010.getR15_6month_uae() == null ? 0 : BRF010.getR15_6month_uae().intValue());
							}
							Cell R15cell0 = row15.getCell(3);
							if (R15cell0 != null) {
								R15cell0.setCellValue(BRF010.getR15_12month_uae() == null ? 0
										: BRF010.getR15_12month_uae().intValue());
							}
							Cell R15cell1 = row15.getCell(4);
							if (R15cell1 != null) {
								R15cell1.setCellValue(
										BRF010.getR15_1year_uae() == null ? 0 : BRF010.getR15_1year_uae().intValue());
							}
							Cell R15cell2 = row15.getCell(5);
							if (R15cell2 != null) {
								R15cell2.setCellValue(BRF010.getR15_6month_other_uae() == null ? 0
										: BRF010.getR15_6month_other_uae().intValue());
							}
							Cell R15cell3 = row15.getCell(6);
							if (R15cell3 != null) {
								R15cell3.setCellValue(BRF010.getR15_12month_other_uae() == null ? 0
										: BRF010.getR15_12month_other_uae().intValue());
							}
							Cell R15cell4 = row15.getCell(7);
							if (R15cell4 != null) {
								R15cell4.setCellValue(BRF010.getR15_1year_other_uae() == null ? 0
										: BRF010.getR15_1year_other_uae().intValue());
							}
							Cell R15cell5 = row15.getCell(8);
							if (R15cell5 != null) {
								R15cell5.setCellValue(BRF010.getR15_6month_non_uae() == null ? 0
										: BRF010.getR15_6month_non_uae().intValue());
							}
							Cell R15cell6 = row15.getCell(9);
							if (R15cell6 != null) {
								R15cell6.setCellValue(BRF010.getR15_12month_non_uae() == null ? 0
										: BRF010.getR15_12month_non_uae().intValue());
							}
							Cell R15cell7 = row15.getCell(10);
							if (R15cell7 != null) {
								R15cell7.setCellValue(BRF010.getR15_1year_non_uae() == null ? 0
										: BRF010.getR15_1year_non_uae().intValue());
							}
							Cell R15cell8 = row15.getCell(11);
							if (R15cell8 != null) {
								R15cell8.setCellValue(BRF010.getR15_6month_other_non_uae() == null ? 0
										: BRF010.getR15_6month_other_non_uae().intValue());
							}
							Cell R15cell9 = row15.getCell(12);
							if (R15cell9 != null) {
								R15cell9.setCellValue(BRF010.getR15_12month_other_non_uae() == null ? 0
										: BRF010.getR15_12month_other_non_uae().intValue());
							}

							Cell R15cell10 = row15.getCell(13);
							if (R15cell10 != null) {
								R15cell10.setCellValue(BRF010.getR15_1year_other_non_uae() == null ? 0
										: BRF010.getR15_1year_other_non_uae().intValue());
							}

							Cell R15cell11 = row15.getCell(14);
							if (R15cell11 != null) {
								R15cell11.setCellValue(BRF010.getR15_other_assets() == null ? 0
										: BRF010.getR15_other_assets().intValue());
							}

							Cell R15cell12 = row15.getCell(17);
							if (R15cell12 != null) {
								R15cell12.setCellValue(BRF010.getR15_net_forward() == null ? 0
										: BRF010.getR15_net_forward().intValue());
							}

							///// srl_no -16/////////
							Row row16 = sheet.getRow(15);
							Cell R16cell = row16.getCell(2);
							if (R16cell != null) {
								R16cell.setCellValue(
										BRF010.getR16_6month_uae() == null ? 0 : BRF010.getR16_6month_uae().intValue());
							}
							Cell R16cell0 = row16.getCell(3);
							if (R16cell0 != null) {
								R16cell0.setCellValue(BRF010.getR16_12month_uae() == null ? 0
										: BRF010.getR16_12month_uae().intValue());
							}
							Cell R16cell1 = row16.getCell(4);
							if (R16cell1 != null) {
								R16cell1.setCellValue(
										BRF010.getR16_1year_uae() == null ? 0 : BRF010.getR16_1year_uae().intValue());
							}
							Cell R16cell2 = row16.getCell(5);
							if (R16cell2 != null) {
								R16cell2.setCellValue(BRF010.getR16_6month_other_uae() == null ? 0
										: BRF010.getR16_6month_other_uae().intValue());
							}
							Cell R16cell3 = row16.getCell(6);
							if (R16cell3 != null) {
								R16cell3.setCellValue(BRF010.getR16_12month_other_uae() == null ? 0
										: BRF010.getR16_12month_other_uae().intValue());
							}
							Cell R16cell4 = row16.getCell(7);
							if (R16cell4 != null) {
								R16cell4.setCellValue(BRF010.getR16_1year_other_uae() == null ? 0
										: BRF010.getR16_1year_other_uae().intValue());
							}
							Cell R16cell5 = row16.getCell(8);
							if (R16cell5 != null) {
								R16cell5.setCellValue(BRF010.getR16_6month_non_uae() == null ? 0
										: BRF010.getR16_6month_non_uae().intValue());
							}
							Cell R16cell6 = row16.getCell(9);
							if (R16cell6 != null) {
								R16cell6.setCellValue(BRF010.getR16_12month_non_uae() == null ? 0
										: BRF010.getR16_12month_non_uae().intValue());
							}
							Cell R16cell7 = row16.getCell(10);
							if (R16cell7 != null) {
								R16cell7.setCellValue(BRF010.getR16_1year_non_uae() == null ? 0
										: BRF010.getR16_1year_non_uae().intValue());
							}
							Cell R16cell8 = row16.getCell(11);
							if (R16cell8 != null) {
								R16cell8.setCellValue(BRF010.getR16_6month_other_non_uae() == null ? 0
										: BRF010.getR16_6month_other_non_uae().intValue());
							}
							Cell R16cell9 = row16.getCell(12);
							if (R16cell9 != null) {
								R16cell9.setCellValue(BRF010.getR16_12month_other_non_uae() == null ? 0
										: BRF010.getR16_12month_other_non_uae().intValue());
							}

							Cell R16cell10 = row16.getCell(13);
							if (R16cell10 != null) {
								R16cell10.setCellValue(BRF010.getR16_1year_other_non_uae() == null ? 0
										: BRF010.getR16_1year_other_non_uae().intValue());
							}

							Cell R16cell11 = row16.getCell(14);
							if (R16cell11 != null) {
								R16cell11.setCellValue(BRF010.getR16_other_assets() == null ? 0
										: BRF010.getR16_other_assets().intValue());
							}

							Cell R16cell12 = row16.getCell(17);
							if (R16cell12 != null) {
								R16cell12.setCellValue(BRF010.getR16_net_forward() == null ? 0
										: BRF010.getR16_net_forward().intValue());
							}

							///// srl_no -17/////////
							Row row17 = sheet.getRow(16);
							Cell R17cell = row17.getCell(2);
							if (R17cell != null) {
								R17cell.setCellValue(
										BRF010.getR17_6month_uae() == null ? 0 : BRF010.getR17_6month_uae().intValue());
							}
							Cell R17cell0 = row17.getCell(3);
							if (R17cell0 != null) {
								R17cell0.setCellValue(BRF010.getR17_12month_uae() == null ? 0
										: BRF010.getR17_12month_uae().intValue());
							}
							Cell R17cell1 = row17.getCell(4);
							if (R17cell1 != null) {
								R17cell1.setCellValue(
										BRF010.getR17_1year_uae() == null ? 0 : BRF010.getR17_1year_uae().intValue());
							}
							Cell R17cell2 = row17.getCell(5);
							if (R17cell2 != null) {
								R17cell2.setCellValue(BRF010.getR17_6month_other_uae() == null ? 0
										: BRF010.getR17_6month_other_uae().intValue());
							}
							Cell R17cell3 = row17.getCell(6);
							if (R17cell3 != null) {
								R17cell3.setCellValue(BRF010.getR17_12month_other_uae() == null ? 0
										: BRF010.getR17_12month_other_uae().intValue());
							}
							Cell R17cell4 = row17.getCell(7);
							if (R17cell4 != null) {
								R17cell4.setCellValue(BRF010.getR17_1year_other_uae() == null ? 0
										: BRF010.getR17_1year_other_uae().intValue());
							}
							Cell R17cell5 = row17.getCell(8);
							if (R17cell5 != null) {
								R17cell5.setCellValue(BRF010.getR17_6month_non_uae() == null ? 0
										: BRF010.getR17_6month_non_uae().intValue());
							}
							Cell R17cell6 = row17.getCell(9);
							if (R17cell6 != null) {
								R17cell6.setCellValue(BRF010.getR17_12month_non_uae() == null ? 0
										: BRF010.getR17_12month_non_uae().intValue());
							}
							Cell R17cell7 = row17.getCell(10);
							if (R17cell7 != null) {
								R17cell7.setCellValue(BRF010.getR17_1year_non_uae() == null ? 0
										: BRF010.getR17_1year_non_uae().intValue());
							}
							Cell R17cell8 = row17.getCell(11);
							if (R17cell8 != null) {
								R17cell8.setCellValue(BRF010.getR17_6month_other_non_uae() == null ? 0
										: BRF010.getR17_6month_other_non_uae().intValue());
							}
							Cell R17cell9 = row17.getCell(12);
							if (R17cell9 != null) {
								R17cell9.setCellValue(BRF010.getR17_12month_other_non_uae() == null ? 0
										: BRF010.getR17_12month_other_non_uae().intValue());
							}

							Cell R17cell10 = row17.getCell(13);
							if (R17cell10 != null) {
								R17cell10.setCellValue(BRF010.getR17_1year_other_non_uae() == null ? 0
										: BRF010.getR17_1year_other_non_uae().intValue());
							}

							Cell R17cell11 = row17.getCell(14);
							if (R17cell11 != null) {
								R17cell11.setCellValue(BRF010.getR17_other_assets() == null ? 0
										: BRF010.getR17_other_assets().intValue());
							}

							Cell R17cell12 = row17.getCell(17);
							if (R17cell12 != null) {
								R17cell12.setCellValue(BRF010.getR17_net_forward() == null ? 0
										: BRF010.getR17_net_forward().intValue());
							}

							///// srl_no -18/////////
							Row row18 = sheet.getRow(17);
							Cell R18cell = row18.getCell(2);
							if (R18cell != null) {
								R18cell.setCellValue(
										BRF010.getR18_6month_uae() == null ? 0 : BRF010.getR18_6month_uae().intValue());
							}
							Cell R18cell0 = row18.getCell(3);
							if (R18cell0 != null) {
								R18cell0.setCellValue(BRF010.getR18_12month_uae() == null ? 0
										: BRF010.getR18_12month_uae().intValue());
							}
							Cell R18cell1 = row18.getCell(4);
							if (R18cell1 != null) {
								R18cell1.setCellValue(
										BRF010.getR18_1year_uae() == null ? 0 : BRF010.getR18_1year_uae().intValue());
							}
							Cell R18cell2 = row18.getCell(5);
							if (R18cell2 != null) {
								R18cell2.setCellValue(BRF010.getR18_6month_other_uae() == null ? 0
										: BRF010.getR18_6month_other_uae().intValue());
							}
							Cell R18cell3 = row18.getCell(6);
							if (R18cell3 != null) {
								R18cell3.setCellValue(BRF010.getR18_12month_other_uae() == null ? 0
										: BRF010.getR18_12month_other_uae().intValue());
							}
							Cell R18cell4 = row18.getCell(7);
							if (R18cell4 != null) {
								R18cell4.setCellValue(BRF010.getR18_1year_other_uae() == null ? 0
										: BRF010.getR18_1year_other_uae().intValue());
							}
							Cell R18cell5 = row18.getCell(8);
							if (R18cell5 != null) {
								R18cell5.setCellValue(BRF010.getR18_6month_non_uae() == null ? 0
										: BRF010.getR18_6month_non_uae().intValue());
							}
							Cell R18cell6 = row18.getCell(9);
							if (R18cell6 != null) {
								R18cell6.setCellValue(BRF010.getR18_12month_non_uae() == null ? 0
										: BRF010.getR18_12month_non_uae().intValue());
							}
							Cell R18cell7 = row18.getCell(10);
							if (R18cell7 != null) {
								R18cell7.setCellValue(BRF010.getR18_1year_non_uae() == null ? 0
										: BRF010.getR18_1year_non_uae().intValue());
							}
							Cell R18cell8 = row18.getCell(11);
							if (R18cell8 != null) {
								R18cell8.setCellValue(BRF010.getR18_6month_other_non_uae() == null ? 0
										: BRF010.getR18_6month_other_non_uae().intValue());
							}
							Cell R18cell9 = row18.getCell(12);
							if (R18cell9 != null) {
								R18cell9.setCellValue(BRF010.getR18_12month_other_non_uae() == null ? 0
										: BRF010.getR18_12month_other_non_uae().intValue());
							}

							Cell R18cell10 = row18.getCell(13);
							if (R18cell10 != null) {
								R18cell10.setCellValue(BRF010.getR18_1year_other_non_uae() == null ? 0
										: BRF010.getR18_1year_other_non_uae().intValue());
							}

							Cell R18cell11 = row18.getCell(14);
							if (R18cell11 != null) {
								R18cell11.setCellValue(BRF010.getR18_other_assets() == null ? 0
										: BRF010.getR18_other_assets().intValue());
							}

							Cell R18cell12 = row18.getCell(17);
							if (R18cell12 != null) {
								R18cell12.setCellValue(BRF010.getR18_net_forward() == null ? 0
										: BRF010.getR18_net_forward().intValue());
							}

							///// srl_no -19/////////
							Row row19 = sheet.getRow(18);
							Cell R19cell = row19.getCell(2);
							if (R19cell != null) {
								R19cell.setCellValue(
										BRF010.getR19_6month_uae() == null ? 0 : BRF010.getR19_6month_uae().intValue());
							}
							Cell R19cell0 = row19.getCell(3);
							if (R19cell0 != null) {
								R19cell0.setCellValue(BRF010.getR19_12month_uae() == null ? 0
										: BRF010.getR19_12month_uae().intValue());
							}
							Cell R19cell1 = row19.getCell(4);
							if (R19cell1 != null) {
								R19cell1.setCellValue(
										BRF010.getR19_1year_uae() == null ? 0 : BRF010.getR19_1year_uae().intValue());
							}
							Cell R19cell2 = row19.getCell(5);
							if (R19cell2 != null) {
								R19cell2.setCellValue(BRF010.getR19_6month_other_uae() == null ? 0
										: BRF010.getR19_6month_other_uae().intValue());
							}
							Cell R19cell3 = row19.getCell(6);
							if (R19cell3 != null) {
								R19cell3.setCellValue(BRF010.getR19_12month_other_uae() == null ? 0
										: BRF010.getR19_12month_other_uae().intValue());
							}
							Cell R19cell4 = row19.getCell(7);
							if (R19cell4 != null) {
								R19cell4.setCellValue(BRF010.getR19_1year_other_uae() == null ? 0
										: BRF010.getR19_1year_other_uae().intValue());
							}
							Cell R19cell5 = row19.getCell(8);
							if (R19cell5 != null) {
								R19cell5.setCellValue(BRF010.getR19_6month_non_uae() == null ? 0
										: BRF010.getR19_6month_non_uae().intValue());
							}
							Cell R19cell6 = row19.getCell(9);
							if (R19cell6 != null) {
								R19cell6.setCellValue(BRF010.getR19_12month_non_uae() == null ? 0
										: BRF010.getR19_12month_non_uae().intValue());
							}
							Cell R19cell7 = row19.getCell(10);
							if (R19cell7 != null) {
								R19cell7.setCellValue(BRF010.getR19_1year_non_uae() == null ? 0
										: BRF010.getR19_1year_non_uae().intValue());
							}
							Cell R19cell8 = row19.getCell(11);
							if (R19cell8 != null) {
								R19cell8.setCellValue(BRF010.getR19_6month_other_non_uae() == null ? 0
										: BRF010.getR19_6month_other_non_uae().intValue());
							}
							Cell R19cell9 = row19.getCell(12);
							if (R19cell9 != null) {
								R19cell9.setCellValue(BRF010.getR19_12month_other_non_uae() == null ? 0
										: BRF010.getR19_12month_other_non_uae().intValue());
							}

							Cell R19cell10 = row19.getCell(13);
							if (R19cell10 != null) {
								R19cell10.setCellValue(BRF010.getR19_1year_other_non_uae() == null ? 0
										: BRF010.getR19_1year_other_non_uae().intValue());
							}

							Cell R19cell11 = row19.getCell(14);
							if (R19cell11 != null) {
								R19cell11.setCellValue(BRF010.getR19_other_assets() == null ? 0
										: BRF010.getR19_other_assets().intValue());
							}

							Cell R19cell12 = row19.getCell(17);
							if (R19cell12 != null) {
								R19cell12.setCellValue(BRF010.getR19_net_forward() == null ? 0
										: BRF010.getR19_net_forward().intValue());
							}

							///// srl_no -20/////////
							Row row20 = sheet.getRow(19);
							Cell R20cell = row20.getCell(2);
							if (R20cell != null) {
								R20cell.setCellValue(
										BRF010.getR20_6month_uae() == null ? 0 : BRF010.getR20_6month_uae().intValue());
							}
							Cell R20cell0 = row20.getCell(3);
							if (R20cell0 != null) {
								R20cell0.setCellValue(BRF010.getR20_12month_uae() == null ? 0
										: BRF010.getR20_12month_uae().intValue());
							}
							Cell R20cell1 = row20.getCell(4);
							if (R20cell1 != null) {
								R20cell1.setCellValue(
										BRF010.getR20_1year_uae() == null ? 0 : BRF010.getR20_1year_uae().intValue());
							}
							Cell R20cell2 = row20.getCell(5);
							if (R20cell2 != null) {
								R20cell2.setCellValue(BRF010.getR20_6month_other_uae() == null ? 0
										: BRF010.getR20_6month_other_uae().intValue());
							}
							Cell R20cell3 = row20.getCell(6);
							if (R20cell3 != null) {
								R20cell3.setCellValue(BRF010.getR20_12month_other_uae() == null ? 0
										: BRF010.getR20_12month_other_uae().intValue());
							}
							Cell R20cell4 = row20.getCell(7);
							if (R20cell4 != null) {
								R20cell4.setCellValue(BRF010.getR20_1year_other_uae() == null ? 0
										: BRF010.getR20_1year_other_uae().intValue());
							}
							Cell R20cell5 = row20.getCell(8);
							if (R20cell5 != null) {
								R20cell5.setCellValue(BRF010.getR20_6month_non_uae() == null ? 0
										: BRF010.getR20_6month_non_uae().intValue());
							}
							Cell R20cell6 = row20.getCell(9);
							if (R20cell6 != null) {
								R20cell6.setCellValue(BRF010.getR20_12month_non_uae() == null ? 0
										: BRF010.getR20_12month_non_uae().intValue());
							}
							Cell R20cell7 = row20.getCell(10);
							if (R20cell7 != null) {
								R20cell7.setCellValue(BRF010.getR20_1year_non_uae() == null ? 0
										: BRF010.getR20_1year_non_uae().intValue());
							}
							Cell R20cell8 = row20.getCell(11);
							if (R20cell8 != null) {
								R20cell8.setCellValue(BRF010.getR20_6month_other_non_uae() == null ? 0
										: BRF010.getR20_6month_other_non_uae().intValue());
							}
							Cell R20cell9 = row20.getCell(12);
							if (R20cell9 != null) {
								R20cell9.setCellValue(BRF010.getR20_12month_other_non_uae() == null ? 0
										: BRF010.getR20_12month_other_non_uae().intValue());
							}

							Cell R20cell10 = row20.getCell(13);
							if (R20cell10 != null) {
								R20cell10.setCellValue(BRF010.getR20_1year_other_non_uae() == null ? 0
										: BRF010.getR20_1year_other_non_uae().intValue());
							}

							Cell R20cell11 = row20.getCell(14);
							if (R20cell11 != null) {
								R20cell11.setCellValue(BRF010.getR20_other_assets() == null ? 0
										: BRF010.getR20_other_assets().intValue());
							}

							Cell R20cell12 = row20.getCell(17);
							if (R20cell12 != null) {
								R20cell12.setCellValue(BRF010.getR20_net_forward() == null ? 0
										: BRF010.getR20_net_forward().intValue());
							}

							///// srl_no -23/////////
							Row row23 = sheet.getRow(22);
							Cell R23cell = row23.getCell(2);
							if (R23cell != null) {
								R23cell.setCellValue(
										BRF010.getR23_6month_uae() == null ? 0 : BRF010.getR23_6month_uae().intValue());
							}
							Cell R23cell0 = row23.getCell(3);
							if (R23cell0 != null) {
								R23cell0.setCellValue(BRF010.getR23_12month_uae() == null ? 0
										: BRF010.getR23_12month_uae().intValue());
							}
							Cell R23cell1 = row23.getCell(4);
							if (R23cell1 != null) {
								R23cell1.setCellValue(
										BRF010.getR23_1year_uae() == null ? 0 : BRF010.getR23_1year_uae().intValue());
							}
							Cell R23cell2 = row23.getCell(5);
							if (R23cell2 != null) {
								R23cell2.setCellValue(BRF010.getR23_6month_other_uae() == null ? 0
										: BRF010.getR23_6month_other_uae().intValue());
							}
							Cell R23cell3 = row23.getCell(6);
							if (R23cell3 != null) {
								R23cell3.setCellValue(BRF010.getR23_12month_other_uae() == null ? 0
										: BRF010.getR23_12month_other_uae().intValue());
							}
							Cell R23cell4 = row23.getCell(7);
							if (R23cell4 != null) {
								R23cell4.setCellValue(BRF010.getR23_1year_other_uae() == null ? 0
										: BRF010.getR23_1year_other_uae().intValue());
							}
							Cell R23cell5 = row23.getCell(8);
							if (R23cell5 != null) {
								R23cell5.setCellValue(BRF010.getR23_6month_non_uae() == null ? 0
										: BRF010.getR23_6month_non_uae().intValue());
							}
							Cell R23cell6 = row23.getCell(9);
							if (R23cell6 != null) {
								R23cell6.setCellValue(BRF010.getR23_12month_non_uae() == null ? 0
										: BRF010.getR23_12month_non_uae().intValue());
							}
							Cell R23cell7 = row23.getCell(10);
							if (R23cell7 != null) {
								R23cell7.setCellValue(BRF010.getR23_1year_non_uae() == null ? 0
										: BRF010.getR23_1year_non_uae().intValue());
							}
							Cell R23cell8 = row23.getCell(11);
							if (R23cell8 != null) {
								R23cell8.setCellValue(BRF010.getR23_6month_other_non_uae() == null ? 0
										: BRF010.getR23_6month_other_non_uae().intValue());
							}
							Cell R23cell9 = row23.getCell(12);
							if (R23cell9 != null) {
								R23cell9.setCellValue(BRF010.getR23_12month_other_non_uae() == null ? 0
										: BRF010.getR23_12month_other_non_uae().intValue());
							}

							Cell R23cell10 = row23.getCell(13);
							if (R23cell10 != null) {
								R23cell10.setCellValue(BRF010.getR23_1year_other_non_uae() == null ? 0
										: BRF010.getR23_1year_other_non_uae().intValue());
							}

							Cell R23cell11 = row23.getCell(14);
							if (R23cell11 != null) {
								R23cell11.setCellValue(BRF010.getR23_other_assets() == null ? 0
										: BRF010.getR23_other_assets().intValue());
							}

							Cell R23cell12 = row23.getCell(17);
							if (R23cell12 != null) {
								R23cell12.setCellValue(BRF010.getR23_net_forward() == null ? 0
										: BRF010.getR23_net_forward().intValue());
							}

							///// srl_no -24/////////
							Row row24 = sheet.getRow(23);
							Cell R24cell = row24.getCell(2);
							if (R24cell != null) {
								R24cell.setCellValue(
										BRF010.getR24_6month_uae() == null ? 0 : BRF010.getR24_6month_uae().intValue());
							}
							Cell R24cell0 = row24.getCell(3);
							if (R24cell0 != null) {
								R24cell0.setCellValue(BRF010.getR24_12month_uae() == null ? 0
										: BRF010.getR24_12month_uae().intValue());
							}
							Cell R24cell1 = row24.getCell(4);
							if (R24cell1 != null) {
								R24cell1.setCellValue(
										BRF010.getR24_1year_uae() == null ? 0 : BRF010.getR24_1year_uae().intValue());
							}
							Cell R24cell2 = row24.getCell(5);
							if (R24cell2 != null) {
								R24cell2.setCellValue(BRF010.getR24_6month_other_uae() == null ? 0
										: BRF010.getR24_6month_other_uae().intValue());
							}
							Cell R24cell3 = row24.getCell(6);
							if (R24cell3 != null) {
								R24cell3.setCellValue(BRF010.getR24_12month_other_uae() == null ? 0
										: BRF010.getR24_12month_other_uae().intValue());
							}
							Cell R24cell4 = row24.getCell(7);
							if (R24cell4 != null) {
								R24cell4.setCellValue(BRF010.getR24_1year_other_uae() == null ? 0
										: BRF010.getR24_1year_other_uae().intValue());
							}
							Cell R24cell5 = row24.getCell(8);
							if (R24cell5 != null) {
								R24cell5.setCellValue(BRF010.getR24_6month_non_uae() == null ? 0
										: BRF010.getR24_6month_non_uae().intValue());
							}
							Cell R24cell6 = row24.getCell(9);
							if (R24cell6 != null) {
								R24cell6.setCellValue(BRF010.getR24_12month_non_uae() == null ? 0
										: BRF010.getR24_12month_non_uae().intValue());
							}
							Cell R24cell7 = row24.getCell(10);
							if (R24cell7 != null) {
								R24cell7.setCellValue(BRF010.getR24_1year_non_uae() == null ? 0
										: BRF010.getR24_1year_non_uae().intValue());
							}
							Cell R24cell8 = row24.getCell(11);
							if (R24cell8 != null) {
								R24cell8.setCellValue(BRF010.getR24_6month_other_non_uae() == null ? 0
										: BRF010.getR24_6month_other_non_uae().intValue());
							}
							Cell R24cell9 = row24.getCell(12);
							if (R24cell9 != null) {
								R24cell9.setCellValue(BRF010.getR24_12month_other_non_uae() == null ? 0
										: BRF010.getR24_12month_other_non_uae().intValue());
							}

							Cell R24cell10 = row24.getCell(13);
							if (R24cell10 != null) {
								R24cell10.setCellValue(BRF010.getR24_1year_other_non_uae() == null ? 0
										: BRF010.getR24_1year_other_non_uae().intValue());
							}

							Cell R24cell11 = row24.getCell(14);
							if (R24cell11 != null) {
								R24cell11.setCellValue(BRF010.getR24_other_assets() == null ? 0
										: BRF010.getR24_other_assets().intValue());
							}

							Cell R24cell12 = row24.getCell(17);
							if (R24cell12 != null) {
								R24cell12.setCellValue(BRF010.getR24_net_forward() == null ? 0
										: BRF010.getR24_net_forward().intValue());
							}

							///// srl_no -25/////////
							Row row25 = sheet.getRow(24);
							Cell R25cell = row25.getCell(2);
							if (R25cell != null) {
								R25cell.setCellValue(
										BRF010.getR25_6month_uae() == null ? 0 : BRF010.getR25_6month_uae().intValue());
							}
							Cell R25cell0 = row25.getCell(3);
							if (R25cell0 != null) {
								R25cell0.setCellValue(BRF010.getR25_12month_uae() == null ? 0
										: BRF010.getR25_12month_uae().intValue());
							}
							Cell R25cell1 = row25.getCell(4);
							if (R25cell1 != null) {
								R25cell1.setCellValue(
										BRF010.getR25_1year_uae() == null ? 0 : BRF010.getR25_1year_uae().intValue());
							}
							Cell R25cell2 = row25.getCell(5);
							if (R25cell2 != null) {
								R25cell2.setCellValue(BRF010.getR25_6month_other_uae() == null ? 0
										: BRF010.getR25_6month_other_uae().intValue());
							}
							Cell R25cell3 = row25.getCell(6);
							if (R25cell3 != null) {
								R25cell3.setCellValue(BRF010.getR25_12month_other_uae() == null ? 0
										: BRF010.getR25_12month_other_uae().intValue());
							}
							Cell R25cell4 = row25.getCell(7);
							if (R25cell4 != null) {
								R25cell4.setCellValue(BRF010.getR25_1year_other_uae() == null ? 0
										: BRF010.getR25_1year_other_uae().intValue());
							}
							Cell R25cell5 = row25.getCell(8);
							if (R25cell5 != null) {
								R25cell5.setCellValue(BRF010.getR25_6month_non_uae() == null ? 0
										: BRF010.getR25_6month_non_uae().intValue());
							}
							Cell R25cell6 = row25.getCell(9);
							if (R25cell6 != null) {
								R25cell6.setCellValue(BRF010.getR25_12month_non_uae() == null ? 0
										: BRF010.getR25_12month_non_uae().intValue());
							}
							Cell R25cell7 = row25.getCell(10);
							if (R25cell7 != null) {
								R25cell7.setCellValue(BRF010.getR25_1year_non_uae() == null ? 0
										: BRF010.getR25_1year_non_uae().intValue());
							}
							Cell R25cell8 = row25.getCell(11);
							if (R25cell8 != null) {
								R25cell8.setCellValue(BRF010.getR25_6month_other_non_uae() == null ? 0
										: BRF010.getR25_6month_other_non_uae().intValue());
							}
							Cell R25cell9 = row25.getCell(12);
							if (R25cell9 != null) {
								R25cell9.setCellValue(BRF010.getR25_12month_other_non_uae() == null ? 0
										: BRF010.getR25_12month_other_non_uae().intValue());
							}

							Cell R25cell10 = row25.getCell(13);
							if (R25cell10 != null) {
								R25cell10.setCellValue(BRF010.getR25_1year_other_non_uae() == null ? 0
										: BRF010.getR25_1year_other_non_uae().intValue());
							}

							Cell R25cell11 = row25.getCell(14);
							if (R25cell11 != null) {
								R25cell11.setCellValue(BRF010.getR25_other_assets() == null ? 0
										: BRF010.getR25_other_assets().intValue());
							}

							Cell R25cell12 = row25.getCell(17);
							if (R25cell12 != null) {
								R25cell12.setCellValue(BRF010.getR25_net_forward() == null ? 0
										: BRF010.getR25_net_forward().intValue());
							}

							///// srl_no -30/////////
							Row row30 = sheet.getRow(29);
							Cell R30cell = row30.getCell(2);
							if (R30cell != null) {
								R30cell.setCellValue(
										BRF010.getR30_6month_uae() == null ? 0 : BRF010.getR30_6month_uae().intValue());
							}
							Cell R30cell0 = row30.getCell(3);
							if (R30cell0 != null) {
								R30cell0.setCellValue(BRF010.getR30_12month_uae() == null ? 0
										: BRF010.getR30_12month_uae().intValue());
							}
							Cell R30cell1 = row30.getCell(4);
							if (R30cell1 != null) {
								R30cell1.setCellValue(
										BRF010.getR30_1year_uae() == null ? 0 : BRF010.getR30_1year_uae().intValue());
							}
							Cell R30cell2 = row30.getCell(5);
							if (R30cell2 != null) {
								R30cell2.setCellValue(BRF010.getR30_6month_other_uae() == null ? 0
										: BRF010.getR30_6month_other_uae().intValue());
							}
							Cell R30cell3 = row30.getCell(6);
							if (R30cell3 != null) {
								R30cell3.setCellValue(BRF010.getR30_12month_other_uae() == null ? 0
										: BRF010.getR30_12month_other_uae().intValue());
							}
							Cell R30cell4 = row30.getCell(7);
							if (R30cell4 != null) {
								R30cell4.setCellValue(BRF010.getR30_1year_other_uae() == null ? 0
										: BRF010.getR30_1year_other_uae().intValue());
							}
							Cell R30cell5 = row30.getCell(8);
							if (R30cell5 != null) {
								R30cell5.setCellValue(BRF010.getR30_6month_non_uae() == null ? 0
										: BRF010.getR30_6month_non_uae().intValue());
							}
							Cell R30cell6 = row30.getCell(9);
							if (R30cell6 != null) {
								R30cell6.setCellValue(BRF010.getR30_12month_non_uae() == null ? 0
										: BRF010.getR30_12month_non_uae().intValue());
							}
							Cell R30cell7 = row30.getCell(10);
							if (R30cell7 != null) {
								R30cell7.setCellValue(BRF010.getR30_1year_non_uae() == null ? 0
										: BRF010.getR30_1year_non_uae().intValue());
							}
							Cell R30cell8 = row30.getCell(11);
							if (R30cell8 != null) {
								R30cell8.setCellValue(BRF010.getR30_6month_other_non_uae() == null ? 0
										: BRF010.getR30_6month_other_non_uae().intValue());
							}
							Cell R30cell9 = row30.getCell(12);
							if (R30cell9 != null) {
								R30cell9.setCellValue(BRF010.getR30_12month_other_non_uae() == null ? 0
										: BRF010.getR30_12month_other_non_uae().intValue());
							}

							Cell R30cell10 = row30.getCell(13);
							if (R30cell10 != null) {
								R30cell10.setCellValue(BRF010.getR30_1year_other_non_uae() == null ? 0
										: BRF010.getR30_1year_other_non_uae().intValue());
							}

							Cell R30cell11 = row30.getCell(14);
							if (R30cell11 != null) {
								R30cell11.setCellValue(BRF010.getR30_total_libilities() == null ? 0
										: BRF010.getR30_total_libilities().intValue());
							}

							///// srl_no -31/////////
							Row row31 = sheet.getRow(30);
							Cell R31cell = row31.getCell(2);
							if (R31cell != null) {
								R31cell.setCellValue(
										BRF010.getR31_6month_uae() == null ? 0 : BRF010.getR31_6month_uae().intValue());
							}
							Cell R31cell0 = row31.getCell(3);
							if (R31cell0 != null) {
								R31cell0.setCellValue(BRF010.getR31_12month_uae() == null ? 0
										: BRF010.getR31_12month_uae().intValue());
							}
							Cell R31cell1 = row31.getCell(4);
							if (R31cell1 != null) {
								R31cell1.setCellValue(
										BRF010.getR31_1year_uae() == null ? 0 : BRF010.getR31_1year_uae().intValue());
							}
							Cell R31cell2 = row31.getCell(5);
							if (R31cell2 != null) {
								R31cell2.setCellValue(BRF010.getR31_6month_other_uae() == null ? 0
										: BRF010.getR31_6month_other_uae().intValue());
							}
							Cell R31cell3 = row31.getCell(6);
							if (R31cell3 != null) {
								R31cell3.setCellValue(BRF010.getR31_12month_other_uae() == null ? 0
										: BRF010.getR31_12month_other_uae().intValue());
							}
							Cell R31cell4 = row31.getCell(7);
							if (R31cell4 != null) {
								R31cell4.setCellValue(BRF010.getR31_1year_other_uae() == null ? 0
										: BRF010.getR31_1year_other_uae().intValue());
							}
							Cell R31cell5 = row31.getCell(8);
							if (R31cell5 != null) {
								R31cell5.setCellValue(BRF010.getR31_6month_non_uae() == null ? 0
										: BRF010.getR31_6month_non_uae().intValue());
							}
							Cell R31cell6 = row31.getCell(9);
							if (R31cell6 != null) {
								R31cell6.setCellValue(BRF010.getR31_12month_non_uae() == null ? 0
										: BRF010.getR31_12month_non_uae().intValue());
							}
							Cell R31cell7 = row31.getCell(10);
							if (R31cell7 != null) {
								R31cell7.setCellValue(BRF010.getR31_1year_non_uae() == null ? 0
										: BRF010.getR31_1year_non_uae().intValue());
							}
							Cell R31cell8 = row31.getCell(11);
							if (R31cell8 != null) {
								R31cell8.setCellValue(BRF010.getR31_6month_other_non_uae() == null ? 0
										: BRF010.getR31_6month_other_non_uae().intValue());
							}
							Cell R31cell9 = row31.getCell(12);
							if (R31cell9 != null) {
								R31cell9.setCellValue(BRF010.getR31_12month_other_non_uae() == null ? 0
										: BRF010.getR31_12month_other_non_uae().intValue());
							}

							Cell R31cell10 = row31.getCell(13);
							if (R31cell10 != null) {
								R31cell10.setCellValue(BRF010.getR31_1year_other_non_uae() == null ? 0
										: BRF010.getR31_1year_other_non_uae().intValue());
							}

							Cell R31cell11 = row31.getCell(14);
							if (R31cell11 != null) {
								R31cell11.setCellValue(BRF010.getR31_total_libilities() == null ? 0
										: BRF010.getR31_total_libilities().intValue());
							}

							///// srl_no -32/////////
							Row row32 = sheet.getRow(31);
							Cell R32cell = row32.getCell(2);
							if (R32cell != null) {
								R32cell.setCellValue(
										BRF010.getR32_6month_uae() == null ? 0 : BRF010.getR32_6month_uae().intValue());
							}
							Cell R32cell0 = row32.getCell(3);
							if (R32cell0 != null) {
								R32cell0.setCellValue(BRF010.getR32_12month_uae() == null ? 0
										: BRF010.getR32_12month_uae().intValue());
							}
							Cell R32cell1 = row32.getCell(4);
							if (R32cell1 != null) {
								R32cell1.setCellValue(
										BRF010.getR32_1year_uae() == null ? 0 : BRF010.getR32_1year_uae().intValue());
							}
							Cell R32cell2 = row32.getCell(5);
							if (R32cell2 != null) {
								R32cell2.setCellValue(BRF010.getR32_6month_other_uae() == null ? 0
										: BRF010.getR32_6month_other_uae().intValue());
							}
							Cell R32cell3 = row32.getCell(6);
							if (R32cell3 != null) {
								R32cell3.setCellValue(BRF010.getR32_12month_other_uae() == null ? 0
										: BRF010.getR32_12month_other_uae().intValue());
							}
							Cell R32cell4 = row32.getCell(7);
							if (R32cell4 != null) {
								R32cell4.setCellValue(BRF010.getR32_1year_other_uae() == null ? 0
										: BRF010.getR32_1year_other_uae().intValue());
							}
							Cell R32cell5 = row32.getCell(8);
							if (R32cell5 != null) {
								R32cell5.setCellValue(BRF010.getR32_6month_non_uae() == null ? 0
										: BRF010.getR32_6month_non_uae().intValue());
							}
							Cell R32cell6 = row32.getCell(9);
							if (R32cell6 != null) {
								R32cell6.setCellValue(BRF010.getR32_12month_non_uae() == null ? 0
										: BRF010.getR32_12month_non_uae().intValue());
							}
							Cell R32cell7 = row32.getCell(10);
							if (R32cell7 != null) {
								R32cell7.setCellValue(BRF010.getR32_1year_non_uae() == null ? 0
										: BRF010.getR32_1year_non_uae().intValue());
							}
							Cell R32cell8 = row32.getCell(11);
							if (R32cell8 != null) {
								R32cell8.setCellValue(BRF010.getR32_6month_other_non_uae() == null ? 0
										: BRF010.getR32_6month_other_non_uae().intValue());
							}
							Cell R32cell9 = row32.getCell(12);
							if (R32cell9 != null) {
								R32cell9.setCellValue(BRF010.getR32_12month_other_non_uae() == null ? 0
										: BRF010.getR32_12month_other_non_uae().intValue());
							}

							Cell R32cell10 = row32.getCell(13);
							if (R32cell10 != null) {
								R32cell10.setCellValue(BRF010.getR32_1year_other_non_uae() == null ? 0
										: BRF010.getR32_1year_other_non_uae().intValue());
							}

							Cell R32cell11 = row32.getCell(14);
							if (R32cell11 != null) {
								R32cell11.setCellValue(BRF010.getR32_total_libilities() == null ? 0
										: BRF010.getR32_total_libilities().intValue());
							}

							///// srl_no -33/////////
							Row row33 = sheet.getRow(32);
							Cell R33cell = row33.getCell(2);
							if (R33cell != null) {
								R33cell.setCellValue(
										BRF010.getR33_6month_uae() == null ? 0 : BRF010.getR33_6month_uae().intValue());
							}
							Cell R33cell0 = row33.getCell(3);
							if (R33cell0 != null) {
								R33cell0.setCellValue(BRF010.getR33_12month_uae() == null ? 0
										: BRF010.getR33_12month_uae().intValue());
							}
							Cell R33cell1 = row33.getCell(4);
							if (R33cell1 != null) {
								R33cell1.setCellValue(
										BRF010.getR33_1year_uae() == null ? 0 : BRF010.getR33_1year_uae().intValue());
							}
							Cell R33cell2 = row33.getCell(5);
							if (R33cell2 != null) {
								R33cell2.setCellValue(BRF010.getR33_6month_other_uae() == null ? 0
										: BRF010.getR33_6month_other_uae().intValue());
							}
							Cell R33cell3 = row33.getCell(6);
							if (R33cell3 != null) {
								R33cell3.setCellValue(BRF010.getR33_12month_other_uae() == null ? 0
										: BRF010.getR33_12month_other_uae().intValue());
							}
							Cell R33cell4 = row33.getCell(7);
							if (R33cell4 != null) {
								R33cell4.setCellValue(BRF010.getR33_1year_other_uae() == null ? 0
										: BRF010.getR33_1year_other_uae().intValue());
							}
							Cell R33cell5 = row33.getCell(8);
							if (R33cell5 != null) {
								R33cell5.setCellValue(BRF010.getR33_6month_non_uae() == null ? 0
										: BRF010.getR33_6month_non_uae().intValue());
							}
							Cell R33cell6 = row33.getCell(9);
							if (R33cell6 != null) {
								R33cell6.setCellValue(BRF010.getR33_12month_non_uae() == null ? 0
										: BRF010.getR33_12month_non_uae().intValue());
							}
							Cell R33cell7 = row33.getCell(10);
							if (R33cell7 != null) {
								R33cell7.setCellValue(BRF010.getR33_1year_non_uae() == null ? 0
										: BRF010.getR33_1year_non_uae().intValue());
							}
							Cell R33cell8 = row33.getCell(11);
							if (R33cell8 != null) {
								R33cell8.setCellValue(BRF010.getR33_6month_other_non_uae() == null ? 0
										: BRF010.getR33_6month_other_non_uae().intValue());
							}
							Cell R33cell9 = row33.getCell(12);
							if (R33cell9 != null) {
								R33cell9.setCellValue(BRF010.getR33_12month_other_non_uae() == null ? 0
										: BRF010.getR33_12month_other_non_uae().intValue());
							}

							Cell R33cell10 = row33.getCell(13);
							if (R33cell10 != null) {
								R33cell10.setCellValue(BRF010.getR33_1year_other_non_uae() == null ? 0
										: BRF010.getR33_1year_other_non_uae().intValue());
							}

							Cell R33cell11 = row33.getCell(14);
							if (R33cell11 != null) {
								R33cell11.setCellValue(BRF010.getR33_total_libilities() == null ? 0
										: BRF010.getR33_total_libilities().intValue());
							}

							///// srl_no -34/////////
							Row row34 = sheet.getRow(33);
							Cell R34cell = row34.getCell(2);
							if (R34cell != null) {
								R34cell.setCellValue(
										BRF010.getR34_6month_uae() == null ? 0 : BRF010.getR34_6month_uae().intValue());
							}
							Cell R34cell0 = row34.getCell(3);
							if (R34cell0 != null) {
								R34cell0.setCellValue(BRF010.getR34_12month_uae() == null ? 0
										: BRF010.getR34_12month_uae().intValue());
							}
							Cell R34cell1 = row34.getCell(4);
							if (R34cell1 != null) {
								R34cell1.setCellValue(
										BRF010.getR34_1year_uae() == null ? 0 : BRF010.getR34_1year_uae().intValue());
							}
							Cell R34cell2 = row34.getCell(5);
							if (R34cell2 != null) {
								R34cell2.setCellValue(BRF010.getR34_6month_other_uae() == null ? 0
										: BRF010.getR34_6month_other_uae().intValue());
							}
							Cell R34cell3 = row34.getCell(6);
							if (R34cell3 != null) {
								R34cell3.setCellValue(BRF010.getR34_12month_other_uae() == null ? 0
										: BRF010.getR34_12month_other_uae().intValue());
							}
							Cell R34cell4 = row34.getCell(7);
							if (R34cell4 != null) {
								R34cell4.setCellValue(BRF010.getR34_1year_other_uae() == null ? 0
										: BRF010.getR34_1year_other_uae().intValue());
							}
							Cell R34cell5 = row34.getCell(8);
							if (R34cell5 != null) {
								R34cell5.setCellValue(BRF010.getR34_6month_non_uae() == null ? 0
										: BRF010.getR34_6month_non_uae().intValue());
							}
							Cell R34cell6 = row34.getCell(9);
							if (R34cell6 != null) {
								R34cell6.setCellValue(BRF010.getR34_12month_non_uae() == null ? 0
										: BRF010.getR34_12month_non_uae().intValue());
							}
							Cell R34cell7 = row34.getCell(10);
							if (R34cell7 != null) {
								R34cell7.setCellValue(BRF010.getR34_1year_non_uae() == null ? 0
										: BRF010.getR34_1year_non_uae().intValue());
							}
							Cell R34cell8 = row34.getCell(11);
							if (R34cell8 != null) {
								R34cell8.setCellValue(BRF010.getR34_6month_other_non_uae() == null ? 0
										: BRF010.getR34_6month_other_non_uae().intValue());
							}
							Cell R34cell9 = row34.getCell(12);
							if (R34cell9 != null) {
								R34cell9.setCellValue(BRF010.getR34_12month_other_non_uae() == null ? 0
										: BRF010.getR34_12month_other_non_uae().intValue());
							}

							Cell R34cell10 = row34.getCell(13);
							if (R34cell10 != null) {
								R34cell10.setCellValue(BRF010.getR34_1year_other_non_uae() == null ? 0
										: BRF010.getR34_1year_other_non_uae().intValue());
							}

							Cell R34cell11 = row34.getCell(14);
							if (R34cell11 != null) {
								R34cell11.setCellValue(BRF010.getR34_total_libilities() == null ? 0
										: BRF010.getR34_total_libilities().intValue());
							}

							///// srl_no -35/////////
							Row row35 = sheet.getRow(34);
							Cell R35cell = row35.getCell(2);
							if (R35cell != null) {
								R35cell.setCellValue(
										BRF010.getR35_6month_uae() == null ? 0 : BRF010.getR35_6month_uae().intValue());
							}
							Cell R35cell0 = row35.getCell(3);
							if (R35cell0 != null) {
								R35cell0.setCellValue(BRF010.getR35_12month_uae() == null ? 0
										: BRF010.getR35_12month_uae().intValue());
							}
							Cell R35cell1 = row35.getCell(4);
							if (R35cell1 != null) {
								R35cell1.setCellValue(
										BRF010.getR35_1year_uae() == null ? 0 : BRF010.getR35_1year_uae().intValue());
							}
							Cell R35cell2 = row35.getCell(5);
							if (R35cell2 != null) {
								R35cell2.setCellValue(BRF010.getR35_6month_other_uae() == null ? 0
										: BRF010.getR35_6month_other_uae().intValue());
							}
							Cell R35cell3 = row35.getCell(6);
							if (R35cell3 != null) {
								R35cell3.setCellValue(BRF010.getR35_12month_other_uae() == null ? 0
										: BRF010.getR35_12month_other_uae().intValue());
							}
							Cell R35cell4 = row35.getCell(7);
							if (R35cell4 != null) {
								R35cell4.setCellValue(BRF010.getR35_1year_other_uae() == null ? 0
										: BRF010.getR35_1year_other_uae().intValue());
							}
							Cell R35cell5 = row35.getCell(8);
							if (R35cell5 != null) {
								R35cell5.setCellValue(BRF010.getR35_6month_non_uae() == null ? 0
										: BRF010.getR35_6month_non_uae().intValue());
							}
							Cell R35cell6 = row35.getCell(9);
							if (R35cell6 != null) {
								R35cell6.setCellValue(BRF010.getR35_12month_non_uae() == null ? 0
										: BRF010.getR35_12month_non_uae().intValue());
							}
							Cell R35cell7 = row35.getCell(10);
							if (R35cell7 != null) {
								R35cell7.setCellValue(BRF010.getR35_1year_non_uae() == null ? 0
										: BRF010.getR35_1year_non_uae().intValue());
							}
							Cell R35cell8 = row35.getCell(11);
							if (R35cell8 != null) {
								R35cell8.setCellValue(BRF010.getR35_6month_other_non_uae() == null ? 0
										: BRF010.getR35_6month_other_non_uae().intValue());
							}
							Cell R35cell9 = row35.getCell(12);
							if (R35cell9 != null) {
								R35cell9.setCellValue(BRF010.getR35_12month_other_non_uae() == null ? 0
										: BRF010.getR35_12month_other_non_uae().intValue());
							}

							Cell R35cell10 = row35.getCell(13);
							if (R35cell10 != null) {
								R35cell10.setCellValue(BRF010.getR35_1year_other_non_uae() == null ? 0
										: BRF010.getR35_1year_other_non_uae().intValue());
							}

							Cell R35cell11 = row35.getCell(14);
							if (R35cell11 != null) {
								R35cell11.setCellValue(BRF010.getR35_total_libilities() == null ? 0
										: BRF010.getR35_total_libilities().intValue());
							}

							///// srl_no -36/////////
							Row row36 = sheet.getRow(35);
							Cell R36cell = row36.getCell(2);
							if (R36cell != null) {
								R36cell.setCellValue(
										BRF010.getR36_6month_uae() == null ? 0 : BRF010.getR36_6month_uae().intValue());
							}
							Cell R36cell0 = row36.getCell(3);
							if (R36cell0 != null) {
								R36cell0.setCellValue(BRF010.getR36_12month_uae() == null ? 0
										: BRF010.getR36_12month_uae().intValue());
							}
							Cell R36cell1 = row36.getCell(4);
							if (R36cell1 != null) {
								R36cell1.setCellValue(
										BRF010.getR36_1year_uae() == null ? 0 : BRF010.getR36_1year_uae().intValue());
							}
							Cell R36cell2 = row36.getCell(5);
							if (R36cell2 != null) {
								R36cell2.setCellValue(BRF010.getR36_6month_other_uae() == null ? 0
										: BRF010.getR36_6month_other_uae().intValue());
							}
							Cell R36cell3 = row36.getCell(6);
							if (R36cell3 != null) {
								R36cell3.setCellValue(BRF010.getR36_12month_other_uae() == null ? 0
										: BRF010.getR36_12month_other_uae().intValue());
							}
							Cell R36cell4 = row36.getCell(7);
							if (R36cell4 != null) {
								R36cell4.setCellValue(BRF010.getR36_1year_other_uae() == null ? 0
										: BRF010.getR36_1year_other_uae().intValue());
							}
							Cell R36cell5 = row36.getCell(8);
							if (R36cell5 != null) {
								R36cell5.setCellValue(BRF010.getR36_6month_non_uae() == null ? 0
										: BRF010.getR36_6month_non_uae().intValue());
							}
							Cell R36cell6 = row36.getCell(9);
							if (R36cell6 != null) {
								R36cell6.setCellValue(BRF010.getR36_12month_non_uae() == null ? 0
										: BRF010.getR36_12month_non_uae().intValue());
							}
							Cell R36cell7 = row36.getCell(10);
							if (R36cell7 != null) {
								R36cell7.setCellValue(BRF010.getR36_1year_non_uae() == null ? 0
										: BRF010.getR36_1year_non_uae().intValue());
							}
							Cell R36cell8 = row36.getCell(11);
							if (R36cell8 != null) {
								R36cell8.setCellValue(BRF010.getR36_6month_other_non_uae() == null ? 0
										: BRF010.getR36_6month_other_non_uae().intValue());
							}
							Cell R36cell9 = row36.getCell(12);
							if (R36cell9 != null) {
								R36cell9.setCellValue(BRF010.getR36_12month_other_non_uae() == null ? 0
										: BRF010.getR36_12month_other_non_uae().intValue());
							}

							Cell R36cell10 = row36.getCell(13);
							if (R36cell10 != null) {
								R36cell10.setCellValue(BRF010.getR36_1year_other_non_uae() == null ? 0
										: BRF010.getR36_1year_other_non_uae().intValue());
							}

							Cell R36cell11 = row36.getCell(14);
							if (R36cell11 != null) {
								R36cell11.setCellValue(BRF010.getR36_total_libilities() == null ? 0
										: BRF010.getR36_total_libilities().intValue());
							}

							///// srl_no -37/////////
							Row row37 = sheet.getRow(36);
							Cell R37cell = row37.getCell(2);
							if (R37cell != null) {
								R37cell.setCellValue(
										BRF010.getR37_6month_uae() == null ? 0 : BRF010.getR37_6month_uae().intValue());
							}
							Cell R37cell0 = row37.getCell(3);
							if (R37cell0 != null) {
								R37cell0.setCellValue(BRF010.getR37_12month_uae() == null ? 0
										: BRF010.getR37_12month_uae().intValue());
							}
							Cell R37cell1 = row37.getCell(4);
							if (R37cell1 != null) {
								R37cell1.setCellValue(
										BRF010.getR37_1year_uae() == null ? 0 : BRF010.getR37_1year_uae().intValue());
							}
							Cell R37cell2 = row37.getCell(5);
							if (R37cell2 != null) {
								R37cell2.setCellValue(BRF010.getR37_6month_other_uae() == null ? 0
										: BRF010.getR37_6month_other_uae().intValue());
							}
							Cell R37cell3 = row37.getCell(6);
							if (R37cell3 != null) {
								R37cell3.setCellValue(BRF010.getR37_12month_other_uae() == null ? 0
										: BRF010.getR37_12month_other_uae().intValue());
							}
							Cell R37cell4 = row37.getCell(7);
							if (R37cell4 != null) {
								R37cell4.setCellValue(BRF010.getR37_1year_other_uae() == null ? 0
										: BRF010.getR37_1year_other_uae().intValue());
							}
							Cell R37cell5 = row37.getCell(8);
							if (R37cell5 != null) {
								R37cell5.setCellValue(BRF010.getR37_6month_non_uae() == null ? 0
										: BRF010.getR37_6month_non_uae().intValue());
							}
							Cell R37cell6 = row37.getCell(9);
							if (R37cell6 != null) {
								R37cell6.setCellValue(BRF010.getR37_12month_non_uae() == null ? 0
										: BRF010.getR37_12month_non_uae().intValue());
							}
							Cell R37cell7 = row37.getCell(10);
							if (R37cell7 != null) {
								R37cell7.setCellValue(BRF010.getR37_1year_non_uae() == null ? 0
										: BRF010.getR37_1year_non_uae().intValue());
							}
							Cell R37cell8 = row37.getCell(11);
							if (R37cell8 != null) {
								R37cell8.setCellValue(BRF010.getR37_6month_other_non_uae() == null ? 0
										: BRF010.getR37_6month_other_non_uae().intValue());
							}
							Cell R37cell9 = row37.getCell(12);
							if (R37cell9 != null) {
								R37cell9.setCellValue(BRF010.getR37_12month_other_non_uae() == null ? 0
										: BRF010.getR37_12month_other_non_uae().intValue());
							}

							Cell R37cell10 = row37.getCell(13);
							if (R37cell10 != null) {
								R37cell10.setCellValue(BRF010.getR37_1year_other_non_uae() == null ? 0
										: BRF010.getR37_1year_other_non_uae().intValue());
							}

							Cell R37cell11 = row37.getCell(14);
							if (R37cell11 != null) {
								R37cell11.setCellValue(BRF010.getR37_total_libilities() == null ? 0
										: BRF010.getR37_total_libilities().intValue());
							}

							///// srl_no -38/////////
							Row row38 = sheet.getRow(37);
							Cell R38cell = row38.getCell(2);
							if (R38cell != null) {
								R38cell.setCellValue(
										BRF010.getR38_6month_uae() == null ? 0 : BRF010.getR38_6month_uae().intValue());
							}
							Cell R38cell0 = row38.getCell(3);
							if (R38cell0 != null) {
								R38cell0.setCellValue(BRF010.getR38_12month_uae() == null ? 0
										: BRF010.getR38_12month_uae().intValue());
							}
							Cell R38cell1 = row38.getCell(4);
							if (R38cell1 != null) {
								R38cell1.setCellValue(
										BRF010.getR38_1year_uae() == null ? 0 : BRF010.getR38_1year_uae().intValue());
							}
							Cell R38cell2 = row38.getCell(5);
							if (R38cell2 != null) {
								R38cell2.setCellValue(BRF010.getR38_6month_other_uae() == null ? 0
										: BRF010.getR38_6month_other_uae().intValue());
							}
							Cell R38cell3 = row38.getCell(6);
							if (R38cell3 != null) {
								R38cell3.setCellValue(BRF010.getR38_12month_other_uae() == null ? 0
										: BRF010.getR38_12month_other_uae().intValue());
							}
							Cell R38cell4 = row38.getCell(7);
							if (R38cell4 != null) {
								R38cell4.setCellValue(BRF010.getR38_1year_other_uae() == null ? 0
										: BRF010.getR38_1year_other_uae().intValue());
							}
							Cell R38cell5 = row38.getCell(8);
							if (R38cell5 != null) {
								R38cell5.setCellValue(BRF010.getR38_6month_non_uae() == null ? 0
										: BRF010.getR38_6month_non_uae().intValue());
							}
							Cell R38cell6 = row38.getCell(9);
							if (R38cell6 != null) {
								R38cell6.setCellValue(BRF010.getR38_12month_non_uae() == null ? 0
										: BRF010.getR38_12month_non_uae().intValue());
							}
							Cell R38cell7 = row38.getCell(10);
							if (R38cell7 != null) {
								R38cell7.setCellValue(BRF010.getR38_1year_non_uae() == null ? 0
										: BRF010.getR38_1year_non_uae().intValue());
							}
							Cell R38cell8 = row38.getCell(11);
							if (R38cell8 != null) {
								R38cell8.setCellValue(BRF010.getR38_6month_other_non_uae() == null ? 0
										: BRF010.getR38_6month_other_non_uae().intValue());
							}
							Cell R38cell9 = row38.getCell(12);
							if (R38cell9 != null) {
								R38cell9.setCellValue(BRF010.getR38_12month_other_non_uae() == null ? 0
										: BRF010.getR38_12month_other_non_uae().intValue());
							}

							Cell R38cell10 = row38.getCell(13);
							if (R38cell10 != null) {
								R38cell10.setCellValue(BRF010.getR38_1year_other_non_uae() == null ? 0
										: BRF010.getR38_1year_other_non_uae().intValue());
							}

							Cell R38cell11 = row38.getCell(14);
							if (R38cell11 != null) {
								R38cell11.setCellValue(BRF010.getR38_total_libilities() == null ? 0
										: BRF010.getR38_total_libilities().intValue());
							}

							///// srl_no -39/////////
							Row row39 = sheet.getRow(38);
							Cell R39cell = row39.getCell(2);
							if (R39cell != null) {
								R39cell.setCellValue(
										BRF010.getR39_6month_uae() == null ? 0 : BRF010.getR39_6month_uae().intValue());
							}
							Cell R39cell0 = row39.getCell(3);
							if (R39cell0 != null) {
								R39cell0.setCellValue(BRF010.getR39_12month_uae() == null ? 0
										: BRF010.getR39_12month_uae().intValue());
							}
							Cell R39cell1 = row39.getCell(4);
							if (R39cell1 != null) {
								R39cell1.setCellValue(
										BRF010.getR39_1year_uae() == null ? 0 : BRF010.getR39_1year_uae().intValue());
							}
							Cell R39cell2 = row39.getCell(5);
							if (R39cell2 != null) {
								R39cell2.setCellValue(BRF010.getR39_6month_other_uae() == null ? 0
										: BRF010.getR39_6month_other_uae().intValue());
							}
							Cell R39cell3 = row39.getCell(6);
							if (R39cell3 != null) {
								R39cell3.setCellValue(BRF010.getR39_12month_other_uae() == null ? 0
										: BRF010.getR39_12month_other_uae().intValue());
							}
							Cell R39cell4 = row39.getCell(7);
							if (R39cell4 != null) {
								R39cell4.setCellValue(BRF010.getR39_1year_other_uae() == null ? 0
										: BRF010.getR39_1year_other_uae().intValue());
							}
							Cell R39cell5 = row39.getCell(8);
							if (R39cell5 != null) {
								R39cell5.setCellValue(BRF010.getR39_6month_non_uae() == null ? 0
										: BRF010.getR39_6month_non_uae().intValue());
							}
							Cell R39cell6 = row39.getCell(9);
							if (R39cell6 != null) {
								R39cell6.setCellValue(BRF010.getR39_12month_non_uae() == null ? 0
										: BRF010.getR39_12month_non_uae().intValue());
							}
							Cell R39cell7 = row39.getCell(10);
							if (R39cell7 != null) {
								R39cell7.setCellValue(BRF010.getR39_1year_non_uae() == null ? 0
										: BRF010.getR39_1year_non_uae().intValue());
							}
							Cell R39cell8 = row39.getCell(11);
							if (R39cell8 != null) {
								R39cell8.setCellValue(BRF010.getR39_6month_other_non_uae() == null ? 0
										: BRF010.getR39_6month_other_non_uae().intValue());
							}
							Cell R39cell9 = row39.getCell(12);
							if (R39cell9 != null) {
								R39cell9.setCellValue(BRF010.getR39_12month_other_non_uae() == null ? 0
										: BRF010.getR39_12month_other_non_uae().intValue());
							}

							Cell R39cell10 = row39.getCell(13);
							if (R39cell10 != null) {
								R39cell10.setCellValue(BRF010.getR39_1year_other_non_uae() == null ? 0
										: BRF010.getR39_1year_other_non_uae().intValue());
							}

							Cell R39cell11 = row39.getCell(14);
							if (R39cell11 != null) {
								R39cell11.setCellValue(BRF010.getR39_total_libilities() == null ? 0
										: BRF010.getR39_total_libilities().intValue());
							}

							///// srl_no -40/////////
							Row row40 = sheet.getRow(39);
							Cell R40cell = row40.getCell(2);
							if (R40cell != null) {
								R40cell.setCellValue(
										BRF010.getR40_6month_uae() == null ? 0 : BRF010.getR40_6month_uae().intValue());
							}
							Cell R40cell0 = row40.getCell(3);
							if (R40cell0 != null) {
								R40cell0.setCellValue(BRF010.getR40_12month_uae() == null ? 0
										: BRF010.getR40_12month_uae().intValue());
							}
							Cell R40cell1 = row40.getCell(4);
							if (R40cell1 != null) {
								R40cell1.setCellValue(
										BRF010.getR40_1year_uae() == null ? 0 : BRF010.getR40_1year_uae().intValue());
							}
							Cell R40cell2 = row40.getCell(5);
							if (R40cell2 != null) {
								R40cell2.setCellValue(BRF010.getR40_6month_other_uae() == null ? 0
										: BRF010.getR40_6month_other_uae().intValue());
							}
							Cell R40cell3 = row40.getCell(6);
							if (R40cell3 != null) {
								R40cell3.setCellValue(BRF010.getR40_12month_other_uae() == null ? 0
										: BRF010.getR40_12month_other_uae().intValue());
							}
							Cell R40cell4 = row40.getCell(7);
							if (R40cell4 != null) {
								R40cell4.setCellValue(BRF010.getR40_1year_other_uae() == null ? 0
										: BRF010.getR40_1year_other_uae().intValue());
							}
							Cell R40cell5 = row40.getCell(8);
							if (R40cell5 != null) {
								R40cell5.setCellValue(BRF010.getR40_6month_non_uae() == null ? 0
										: BRF010.getR40_6month_non_uae().intValue());
							}
							Cell R40cell6 = row40.getCell(9);
							if (R40cell6 != null) {
								R40cell6.setCellValue(BRF010.getR40_12month_non_uae() == null ? 0
										: BRF010.getR40_12month_non_uae().intValue());
							}
							Cell R40cell7 = row40.getCell(10);
							if (R40cell7 != null) {
								R40cell7.setCellValue(BRF010.getR40_1year_non_uae() == null ? 0
										: BRF010.getR40_1year_non_uae().intValue());
							}
							Cell R40cell8 = row40.getCell(11);
							if (R40cell8 != null) {
								R40cell8.setCellValue(BRF010.getR40_6month_other_non_uae() == null ? 0
										: BRF010.getR40_6month_other_non_uae().intValue());
							}
							Cell R40cell9 = row40.getCell(12);
							if (R40cell9 != null) {
								R40cell9.setCellValue(BRF010.getR40_12month_other_non_uae() == null ? 0
										: BRF010.getR40_12month_other_non_uae().intValue());
							}

							Cell R40cell10 = row40.getCell(13);
							if (R40cell10 != null) {
								R40cell10.setCellValue(BRF010.getR40_1year_other_non_uae() == null ? 0
										: BRF010.getR40_1year_other_non_uae().intValue());
							}

							Cell R40cell11 = row40.getCell(14);
							if (R40cell11 != null) {
								R40cell11.setCellValue(BRF010.getR40_total_libilities() == null ? 0
										: BRF010.getR40_total_libilities().intValue());
							}

							///// srl_no -43/////////
							Row row43 = sheet.getRow(42);
							Cell R43cell = row43.getCell(2);
							if (R43cell != null) {
								R43cell.setCellValue(
										BRF010.getR43_6month_uae() == null ? 0 : BRF010.getR43_6month_uae().intValue());
							}
							Cell R43cell0 = row43.getCell(3);
							if (R43cell0 != null) {
								R43cell0.setCellValue(BRF010.getR43_12month_uae() == null ? 0
										: BRF010.getR43_12month_uae().intValue());
							}
							Cell R43cell1 = row43.getCell(4);
							if (R43cell1 != null) {
								R43cell1.setCellValue(
										BRF010.getR43_1year_uae() == null ? 0 : BRF010.getR43_1year_uae().intValue());
							}
							Cell R43cell2 = row43.getCell(5);
							if (R43cell2 != null) {
								R43cell2.setCellValue(BRF010.getR43_6month_other_uae() == null ? 0
										: BRF010.getR43_6month_other_uae().intValue());
							}
							Cell R43cell3 = row43.getCell(6);
							if (R43cell3 != null) {
								R43cell3.setCellValue(BRF010.getR43_12month_other_uae() == null ? 0
										: BRF010.getR43_12month_other_uae().intValue());
							}
							Cell R43cell4 = row43.getCell(7);
							if (R43cell4 != null) {
								R43cell4.setCellValue(BRF010.getR43_1year_other_uae() == null ? 0
										: BRF010.getR43_1year_other_uae().intValue());
							}
							Cell R43cell5 = row43.getCell(8);
							if (R43cell5 != null) {
								R43cell5.setCellValue(BRF010.getR43_6month_non_uae() == null ? 0
										: BRF010.getR43_6month_non_uae().intValue());
							}
							Cell R43cell6 = row43.getCell(9);
							if (R43cell6 != null) {
								R43cell6.setCellValue(BRF010.getR43_12month_non_uae() == null ? 0
										: BRF010.getR43_12month_non_uae().intValue());
							}
							Cell R43cell7 = row43.getCell(10);
							if (R43cell7 != null) {
								R43cell7.setCellValue(BRF010.getR43_1year_non_uae() == null ? 0
										: BRF010.getR43_1year_non_uae().intValue());
							}
							Cell R43cell8 = row43.getCell(11);
							if (R43cell8 != null) {
								R43cell8.setCellValue(BRF010.getR43_6month_other_non_uae() == null ? 0
										: BRF010.getR43_6month_other_non_uae().intValue());
							}
							Cell R43cell9 = row43.getCell(12);
							if (R43cell9 != null) {
								R43cell9.setCellValue(BRF010.getR43_12month_other_non_uae() == null ? 0
										: BRF010.getR43_12month_other_non_uae().intValue());
							}

							Cell R43cell10 = row43.getCell(13);
							if (R43cell10 != null) {
								R43cell10.setCellValue(BRF010.getR43_1year_other_non_uae() == null ? 0
										: BRF010.getR43_1year_other_non_uae().intValue());
							}

							Cell R43cell11 = row43.getCell(14);
							if (R43cell11 != null) {
								R43cell11.setCellValue(BRF010.getR43_total_libilities() == null ? 0
										: BRF010.getR43_total_libilities().intValue());
							}

							///// srl_no -44/////////
							Row row44 = sheet.getRow(43);
							Cell R44cell = row44.getCell(2);
							if (R44cell != null) {
								R44cell.setCellValue(
										BRF010.getR44_6month_uae() == null ? 0 : BRF010.getR44_6month_uae().intValue());
							}
							Cell R44cell0 = row44.getCell(3);
							if (R44cell0 != null) {
								R44cell0.setCellValue(BRF010.getR44_12month_uae() == null ? 0
										: BRF010.getR44_12month_uae().intValue());
							}
							Cell R44cell1 = row44.getCell(4);
							if (R44cell1 != null) {
								R44cell1.setCellValue(
										BRF010.getR44_1year_uae() == null ? 0 : BRF010.getR44_1year_uae().intValue());
							}
							Cell R44cell2 = row44.getCell(5);
							if (R44cell2 != null) {
								R44cell2.setCellValue(BRF010.getR44_6month_other_uae() == null ? 0
										: BRF010.getR44_6month_other_uae().intValue());
							}
							Cell R44cell3 = row44.getCell(6);
							if (R44cell3 != null) {
								R44cell3.setCellValue(BRF010.getR44_12month_other_uae() == null ? 0
										: BRF010.getR44_12month_other_uae().intValue());
							}
							Cell R44cell4 = row44.getCell(7);
							if (R44cell4 != null) {
								R44cell4.setCellValue(BRF010.getR44_1year_other_uae() == null ? 0
										: BRF010.getR44_1year_other_uae().intValue());
							}
							Cell R44cell5 = row44.getCell(8);
							if (R44cell5 != null) {
								R44cell5.setCellValue(BRF010.getR44_6month_non_uae() == null ? 0
										: BRF010.getR44_6month_non_uae().intValue());
							}
							Cell R44cell6 = row44.getCell(9);
							if (R44cell6 != null) {
								R44cell6.setCellValue(BRF010.getR44_12month_non_uae() == null ? 0
										: BRF010.getR44_12month_non_uae().intValue());
							}
							Cell R44cell7 = row44.getCell(10);
							if (R44cell7 != null) {
								R44cell7.setCellValue(BRF010.getR44_1year_non_uae() == null ? 0
										: BRF010.getR44_1year_non_uae().intValue());
							}
							Cell R44cell8 = row44.getCell(11);
							if (R44cell8 != null) {
								R44cell8.setCellValue(BRF010.getR44_6month_other_non_uae() == null ? 0
										: BRF010.getR44_6month_other_non_uae().intValue());
							}
							Cell R44cell9 = row44.getCell(12);
							if (R44cell9 != null) {
								R44cell9.setCellValue(BRF010.getR44_12month_other_non_uae() == null ? 0
										: BRF010.getR44_12month_other_non_uae().intValue());
							}

							Cell R44cell10 = row44.getCell(13);
							if (R44cell10 != null) {
								R44cell10.setCellValue(BRF010.getR44_1year_other_non_uae() == null ? 0
										: BRF010.getR44_1year_other_non_uae().intValue());
							}

							Cell R44cell11 = row44.getCell(14);
							if (R44cell11 != null) {
								R44cell11.setCellValue(BRF010.getR44_total_libilities() == null ? 0
										: BRF010.getR44_total_libilities().intValue());
							}

							///// srl_no -45/////////
							Row row45 = sheet.getRow(44);
							Cell R45cell = row45.getCell(2);
							if (R45cell != null) {
								R45cell.setCellValue(
										BRF010.getR45_6month_uae() == null ? 0 : BRF010.getR45_6month_uae().intValue());
							}
							Cell R45cell0 = row45.getCell(3);
							if (R45cell0 != null) {
								R45cell0.setCellValue(BRF010.getR45_12month_uae() == null ? 0
										: BRF010.getR45_12month_uae().intValue());
							}
							Cell R45cell1 = row45.getCell(4);
							if (R45cell1 != null) {
								R45cell1.setCellValue(
										BRF010.getR45_1year_uae() == null ? 0 : BRF010.getR45_1year_uae().intValue());
							}
							Cell R45cell2 = row45.getCell(5);
							if (R45cell2 != null) {
								R45cell2.setCellValue(BRF010.getR45_6month_other_uae() == null ? 0
										: BRF010.getR45_6month_other_uae().intValue());
							}
							Cell R45cell3 = row45.getCell(6);
							if (R45cell3 != null) {
								R45cell3.setCellValue(BRF010.getR45_12month_other_uae() == null ? 0
										: BRF010.getR45_12month_other_uae().intValue());
							}
							Cell R45cell4 = row45.getCell(7);
							if (R45cell4 != null) {
								R45cell4.setCellValue(BRF010.getR45_1year_other_uae() == null ? 0
										: BRF010.getR45_1year_other_uae().intValue());
							}
							Cell R45cell5 = row45.getCell(8);
							if (R45cell5 != null) {
								R45cell5.setCellValue(BRF010.getR45_6month_non_uae() == null ? 0
										: BRF010.getR45_6month_non_uae().intValue());
							}
							Cell R45cell6 = row45.getCell(9);
							if (R45cell6 != null) {
								R45cell6.setCellValue(BRF010.getR45_12month_non_uae() == null ? 0
										: BRF010.getR45_12month_non_uae().intValue());
							}
							Cell R45cell7 = row45.getCell(10);
							if (R45cell7 != null) {
								R45cell7.setCellValue(BRF010.getR45_1year_non_uae() == null ? 0
										: BRF010.getR45_1year_non_uae().intValue());
							}
							Cell R45cell8 = row45.getCell(11);
							if (R45cell8 != null) {
								R45cell8.setCellValue(BRF010.getR45_6month_other_non_uae() == null ? 0
										: BRF010.getR45_6month_other_non_uae().intValue());
							}
							Cell R45cell9 = row45.getCell(12);
							if (R45cell9 != null) {
								R45cell9.setCellValue(BRF010.getR45_12month_other_non_uae() == null ? 0
										: BRF010.getR45_12month_other_non_uae().intValue());
							}

							Cell R45cell10 = row45.getCell(13);
							if (R45cell10 != null) {
								R45cell10.setCellValue(BRF010.getR45_1year_other_non_uae() == null ? 0
										: BRF010.getR45_1year_other_non_uae().intValue());
							}

							Cell R45cell11 = row45.getCell(14);
							if (R45cell11 != null) {
								R45cell11.setCellValue(BRF010.getR45_total_libilities() == null ? 0
										: BRF010.getR45_total_libilities().intValue());
							}

							// Save the changes
							workbook.getCreationHelper().createFormulaEvaluator().evaluateAll();
							FileOutputStream fileOut = new FileOutputStream(
									env.getProperty("output.exportpathfinal") + "011-BRF-010-A.xls");
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
		outputFile = new File(env.getProperty("output.exportpathfinal") + "011-BRF-010-A.xls");

		return outputFile;

	}

	public String detailChanges10(BRF10_DETAIL_ENTITY detail, String foracid, String report_addl_criteria_1,
			BigDecimal act_balance_amt_lc, String report_label_1, String report_name_1) {

		String msg = "";

		try {

			Session hs = sessionFactory.getCurrentSession();
			Optional<BRF10_DETAIL_ENTITY> Brf10detail = brf10DetailRep.findById(foracid);

			if (Brf10detail.isPresent()) {
				BRF10_DETAIL_ENTITY BRFdetail = Brf10detail.get();

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
					brf10DetailRep.save(BRFdetail);

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

	public ModelAndView getArchieveBRF010View(String reportId, String fromdate, String todate, String currency,
			String dtltype, Pageable pageable) {

		ModelAndView mv = new ModelAndView();
		Session hs = sessionFactory.getCurrentSession();
		int pageSize = pageable.getPageSize();
		int currentPage = pageable.getPageNumber();
		int startItem = currentPage * pageSize;
		List<BRF10_ENTITY> T1rep = new ArrayList<BRF10_ENTITY>();
		// Query<Object[]> qr;

		List<BRF10_ENTITY> T1Master = new ArrayList<BRF10_ENTITY>();
		/* List<BRF73_TABLE2> T1Master1 = new ArrayList<BRF73_TABLE2>(); */

		logger.info("Inside archive" + currency);

		try {
			Date d1 = df.parse(todate);
			// T1rep = t1CurProdServiceRepo.getT1CurProdServices(d1);

			T1Master = hs.createQuery("from  BRF10_ENTITY a where a.report_date = ?1 ", BRF10_ENTITY.class)
					.setParameter(1, df.parse(todate)).getResultList();

			/*
			 * T1Master1 = hs.createQuery("from BRF73_TABLE2 a where a.report_date = ?1 ",
			 * BRF73_TABLE2.class) .setParameter(1, df.parse(todate)).getResultList();
			 */

		} catch (ParseException e) {
			e.printStackTrace();
		}

		// T1rep = t1CurProdServiceRepo.getT1CurProdServices(d1);

		mv.setViewName("RR/BRF10ARCH");
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
	public ModelAndView ARCHgetBRF010currentDtl(String reportId, String fromdate, String todate, String currency,
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
				qr = hs.createNativeQuery(
						"select * from BRF10_ARCHIVTABLE a where report_date=?1 and report_label_1=?2");
				qr.setParameter(1, df.parse(todate));
				qr.setParameter(2, filter);

			} else {
				System.out.println("2");
				qr = hs.createNativeQuery("select * from BRF10_ARCHIVTABLE");

			}
		} else {
			System.out.println("3");
			qr = hs.createNativeQuery("select * from BRF10_ARCHIVTABLE  where report_date = ?1");
		}

		/*
		 * try { qr.setParameter(1, df.parse(todate));
		 * 
		 * } catch (ParseException e) { e.printStackTrace(); }
		 */
		List<BRF10_ARCHIVENTITY> T1Master = new ArrayList<BRF10_ARCHIVENTITY>();

		try {
			System.out.println("Values entered");
			T1Master = hs.createQuery("from BRF10_ARCHIVENTITY a where a.report_date = ?1", BRF10_ARCHIVENTITY.class)
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

			BRF10_ARCHIVENTITY py = new BRF10_ARCHIVENTITY(cust_id, foracid, act_balance_amt_lc, eab_lc, acct_name,
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

		mv.setViewName("RR" + "/" + "BRF10ARCH::reportcontent");
		mv.addObject("reportdetails", T1Dt1Page.getContent());
		mv.addObject("reportmaster", T1Master);
		mv.addObject("reportmaster1", qr);
		mv.addObject("singledetail", new T1CurProdDetail());
		mv.addObject("reportsflag", "reportsflag");
		mv.addObject("menu", reportId);
		return mv;
	}

}