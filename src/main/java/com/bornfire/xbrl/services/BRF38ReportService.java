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

import com.bornfire.xbrl.entities.BRF38_ARCHIVENTITY;
import com.bornfire.xbrl.entities.BRBS.BRF038_NEW_REP;
import com.bornfire.xbrl.entities.BRBS.BRF38_DETAIL_ENTITY;
import com.bornfire.xbrl.entities.BRBS.BRF38_DetaiRep;
import com.bornfire.xbrl.entities.BRBS.BRF38_ENTITY1;
import com.bornfire.xbrl.entities.BRBS.BRF38_ENTITY2;
import com.bornfire.xbrl.entities.BRBS.T1CurProdDetail;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRPrintElement;
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
public class BRF38ReportService {
	private static final Logger logger = LoggerFactory.getLogger(BRF38ReportService.class);
	@Autowired
	SessionFactory sessionFactory;

	@Autowired
	DataSource srcdataSource;

	@Autowired
	Environment env;

	@Autowired
	BRF38_DetaiRep BRF38_DetaiRep;

	@Autowired
	BRF038_NEW_REP brf38entity2;

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
			Long dtlcnt = (Long) hs.createQuery("select count(*) from  BRF38_ENTITY1 a where a.report_date=?1")
					.setParameter(1, dt9).getSingleResult();

			if (dtlcnt > 0) {
				logger.info("Getting No of records in Mod table :" + reportid);
				Long modcnt = (Long) hs.createQuery("select count(*) from  BRF38_ENTITY1 a").getSingleResult();
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

	/*
	 * public ModelAndView getBRF038View(String reportId, String fromdate, String
	 * todate, String currency, String dtltype, Pageable pageable) {
	 * 
	 * ModelAndView mv = new ModelAndView(); Session hs =
	 * sessionFactory.getCurrentSession(); int pageSize = pageable.getPageSize();
	 * int currentPage = pageable.getPageNumber(); int startItem = currentPage *
	 * pageSize; List<BRF038_ENTITY> T1rep = new ArrayList<BRF038_ENTITY>(); //
	 * Query<Object[]> qr;
	 * 
	 * List<BRF038_ENTITY> T1Master = new ArrayList<BRF038_ENTITY>();
	 * List<BRF73_TABLE2> T1Master1 = new ArrayList<BRF73_TABLE2>();
	 * 
	 * logger.info("Inside archive" + currency);
	 * 
	 * try { Date d1 = df.parse(todate); // T1rep =
	 * t1CurProdServiceRepo.getT1CurProdServices(d1);
	 * 
	 * T1Master = hs.createQuery("from  BRF038_ENTITY a where a.report_date = ?1 ",
	 * BRF038_ENTITY.class) .setParameter(1, df.parse(todate)).getResultList();
	 * 
	 * 
	 * T1Master1 = hs.createQuery("from BRF73_TABLE2 a where a.report_date = ?1 ",
	 * BRF73_TABLE2.class) .setParameter(1, df.parse(todate)).getResultList();
	 * 
	 * 
	 * } catch (ParseException e) { e.printStackTrace(); }
	 * 
	 * // T1rep = t1CurProdServiceRepo.getT1CurProdServices(d1);
	 * 
	 * mv.setViewName("RR/BRF038"); // mv.addObject("currlist",
	 * refCodeConfig.currList()); mv.addObject("reportsummary", T1Master);
	 * mv.addObject("reportsummary1", T1Master1); mv.addObject("reportmaster",
	 * T1Master); mv.addObject("displaymode", "summary");
	 * mv.addObject("reportsflag", "reportsflag"); mv.addObject("menu", reportId);
	 * System.out.println("scv" + mv.getViewName());
	 * 
	 * return mv;
	 * 
	 * }
	 */

	public ModelAndView getBRF38View(String reportId, String fromdate, String todate, String currency, String dtltype,
			Pageable pageable) {
		String msg = "";
		ModelAndView mv = new ModelAndView();
		Session hs = sessionFactory.getCurrentSession();
		int pageSize = pageable.getPageSize();
		int currentPage = pageable.getPageNumber();
		int startItem = currentPage * pageSize;
		List<BRF38_ENTITY1> T1rep = new ArrayList<BRF38_ENTITY1>();
		// Query<Object[]> qr;
		List<BRF38_ENTITY1> T1Master1 = new ArrayList<BRF38_ENTITY1>();
		// List<BRF38_ENTITY2> T2rep = new ArrayList<BRF38_ENTITY2>();
		List<BRF38_ENTITY2> Remaining = new ArrayList<BRF38_ENTITY2>();
		List<BRF38_ENTITY2> ROWLABEL = new ArrayList<BRF38_ENTITY2>();

		List<Object[]> T2rep = new ArrayList<Object[]>();
		logger.info("Inside archive" + currency);

		try {
			Date d1 = df.parse(todate);
			// T1rep = t1CurProdServiceRepo.getT1CurProdServices(d1);
			T1Master1 = hs.createQuery("from  BRF38_ENTITY1 a where a.report_date = ?1 ", BRF38_ENTITY1.class)
					.setParameter(1, df.parse(todate)).getResultList();
			ROWLABEL = hs.createQuery("from  BRF38_ENTITY2 a where a.report_date = ?1 ", BRF38_ENTITY2.class)
					.setParameter(1, df.parse(todate)).getResultList();

			T2rep = brf38entity2.findallvalues(todate);

			// Initialize Total for each entity
			/*
			 * BigDecimal outwardTotal = BigDecimal.ZERO; BigDecimal inwardTotal =
			 * BigDecimal.ZERO;
			 */
			System.out.println(T2rep.toString());

			if (T2rep.size() > 0) {
				System.out.println(T2rep.toString());
				for (Object[] BRF038 : T2rep) {
					System.out.println("Inside loop");
					BigDecimal outward = BigDecimal.ZERO;
					BigDecimal inward = BigDecimal.ZERO;
					BRF38_ENTITY2 BRF38_ENTITY2 = new BRF38_ENTITY2();
					System.out.println("Sub Countries : " + BRF038.toString());

					BRF38_ENTITY2.setRemaining_countries((String) BRF038[1]);
					// BRF38_ENTITY2.setRemaining_countries(BRF038.get);

					System.out.println(BRF38_ENTITY2.getRemaining_countries());
					BRF38_ENTITY2.setOutward_family1((BigDecimal) BRF038[2]);
					BRF38_ENTITY2.setOutward_investment1((BigDecimal) BRF038[3]);
					BRF38_ENTITY2.setOutward_trade1((BigDecimal) BRF038[4]);
					BRF38_ENTITY2.setOutward_other1((BigDecimal) BRF038[5]);
					BRF38_ENTITY2.setInward_family1((BigDecimal) BRF038[7]);
					BRF38_ENTITY2.setInward_investment1((BigDecimal) BRF038[8]);
					BRF38_ENTITY2.setInward_trade1((BigDecimal) BRF038[9]);
					BRF38_ENTITY2.setInward_other1((BigDecimal) BRF038[10]);
					BRF38_ENTITY2.setRow_label((String) BRF038[12]);

					// data for different columns from BRF38 array
					BigDecimal fam = (BigDecimal) BRF038[2];
					BigDecimal invest = (BigDecimal) BRF038[3];
					BigDecimal trade = (BigDecimal) BRF038[4];
					BigDecimal other = (BigDecimal) BRF038[5];

					// Calculate the sum of values from different columns
					outward = outward.add(fam).add(invest).add(trade).add(other);

					BRF38_ENTITY2.setOutward_total1(outward);

					// Data for different columns from BRF38 array
					BigDecimal fam1 = (BigDecimal) BRF038[7];
					BigDecimal invest1 = (BigDecimal) BRF038[8];
					BigDecimal trade1 = (BigDecimal) BRF038[9];
					BigDecimal other1 = (BigDecimal) BRF038[10];

					// Calculate the sum of values from different columns
					inward = inward.add(fam1).add(invest1).add(trade1).add(other1);

					BRF38_ENTITY2.setInward_total1(inward);

					Remaining.add(BRF38_ENTITY2);

				}
			} else {
				msg = "No data Found";
			}

		} catch (ParseException e) {
			e.printStackTrace();
		}

		// T1rep = t1CurProdServiceRepo.getT1CurProdServices(d1);

		mv.setViewName("RR/BRF38");
		// mv.addObject("currlist", refCodeConfig.currList());
		mv.addObject("reportsummary", T2rep);
		mv.addObject("reportsummary1", T1Master1);
		System.out.println(Remaining);
		mv.addObject("Remaining", Remaining);

		// REMAINING
		mv.addObject("getremainoutwardfam", brf38entity2.getremainoutwardfam(todate));
		mv.addObject("getremaininwardfam", brf38entity2.getremaininwardfam(todate));
		mv.addObject("getremainoutwardinvest", brf38entity2.getremainoutwardinvest(todate));
		mv.addObject("getremaininwardinvest", brf38entity2.getremaininwardinvest(todate));
		mv.addObject("getremainoutwardtrade", brf38entity2.getremainoutwardtrade(todate));
		mv.addObject("getremaininwardtrade", brf38entity2.getremaininwardtrade(todate));
		mv.addObject("getremainoutwardother", brf38entity2.getremainoutwardother(todate));
		mv.addObject("getremaininwardother", brf38entity2.getremaininwardother(todate));

		mv.addObject("getreaminingamouttotal", brf38entity2.getreaminingamouttotal(todate));
		mv.addObject("getreaminingamintotal", brf38entity2.getreaminingamintotal(todate));

		mv.addObject("reportmaster", T2rep);
		mv.addObject("ROWLABEL", ROWLABEL);
		mv.addObject("displaymode", "summary");
		mv.addObject("reportsflag", "reportsflag");
		mv.addObject("menu", reportId);
		System.out.println("scv" + mv.getViewName());

		return mv;

	}

	public ModelAndView getBRF038currentDtl(String reportId, String fromdate, String todate, String currency,
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
						"select * from BRF38A_DETAILTABLE  where report_date = ?1 and report_label_1=?2");
				qr.setParameter(2, filter);
			} else {
				qr = hs.createNativeQuery("select * from BRF38A_DETAILTABLE  where report_date = ?1");
			}
		} else {
			qr = hs.createNativeQuery("select * from BRF38A_DETAILTABLE  where report_date = ?1");
		}

		try {
			qr.setParameter(1, df.parse(todate));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<BRF38_DETAIL_ENTITY> T1Master = new ArrayList<BRF38_DETAIL_ENTITY>();

		try {
			T1Master = hs.createQuery("from BRF38_DETAIL_ENTITY a where a.report_date = ?1", BRF38_DETAIL_ENTITY.class)
					.setParameter(1, df.parse(todate)).getResultList();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		logger.info("Getting Report Detail for : " + reportId + "," + fromdate + "," + todate + "," + currency);
		List<Object[]> result = qr.getResultList();

		for (Object[] a : result) {
			String cust_id = (String) a[0];
			String foracid = (String) a[1];

			String acct_name = (String) a[2];
			BigDecimal eab_lc = (BigDecimal) a[3];
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
			String purpose_of_rem = (String) a[48];
			String collection_code = (String) a[49];
			BigDecimal srl_num = (BigDecimal) a[50];

			BRF38_DETAIL_ENTITY py = new BRF38_DETAIL_ENTITY(cust_id, foracid, acct_name, eab_lc, act_balance_amt_lc,
					acct_crncy_code, gl_code, gl_sub_head_code, gl_sub_head_desc, country_of_incorp, cust_type,
					schm_code, schm_type, sol_id, acid, segment, sub_segment, sector, sub_sector, sector_code, group_id,
					constitution_code, country, legal_entity_type, constitution_desc, purpose_of_advn, hni_networth,
					turnover, bacid, report_name_1, report_label_1, report_addl_criteria_1, report_addl_criteria_2,
					report_addl_criteria_3, create_user, create_time, modify_user, modify_time, verify_user,
					verify_time, entity_flg, modify_flg, del_flg, nre_status, report_date, maturity_date, version,
					remarks, purpose_of_rem, collection_code, srl_num);

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

		mv.setViewName("RR" + "/" + "BRF38::reportcontent");
		// mv.setViewName("ReportT1");
		mv.addObject("reportdetails", T1Dt1Page);
		mv.addObject("reportmaster", T1Master);
		mv.addObject("singledetail", new T1CurProdDetail());
		mv.addObject("reportsflag", "reportsflag");
		mv.addObject("menu", reportId);
		return mv;
	}

	public File getFileBRF038(String reportId, String fromdate, String todate, String currency, String dtltype,
			String filetype) throws FileNotFoundException, JRException, SQLException {
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

		String path = this.env.getProperty("output.exportpath");
		String fileName = "";
		String zipFileName = "";
		File outputFile;

		logger.info("Getting Output file :" + reportId);
		fileName = "011-BRF-38-A";

		if (!filetype.equals("xbrl")) {

			if (!filetype.equals("BRF")) {

				try {
					InputStream jasperFile;
					logger.info("Getting Jasper file :" + reportId);
					if (filetype.equals("detailexcel")) {
						if (dtltype.equals("report")) {

							jasperFile = this.getClass().getResourceAsStream("/static/jasper/BRF38_Detail.jrxml");
						} else {
							jasperFile = this.getClass().getResourceAsStream("/static/jasper/BRF38_Detail.jrxml");
						}

					} else {
						if (dtltype.equals("report")) {
							logger.info("Inside report");
							jasperFile = this.getClass().getResourceAsStream("/static/jasper/BRF38.jrxml");
						} else {
							jasperFile = this.getClass().getResourceAsStream("/static/jasper/BRF38.jrxml");
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

			} else {

				/* file type "BRF" */

				try {

					Session hs = sessionFactory.getCurrentSession();
					Date d1 = df.parse(todate);

					/* Static Values Table */
					List<BRF38_ENTITY1> T1Master = new ArrayList<BRF38_ENTITY1>();

					/* Remaining Countries */
					List<Object[]> T1Master2 = brf38entity2.findallvalues(todate);

					T1Master = hs.createQuery("from BRF38_ENTITY1 a where a.report_date = ?1", BRF38_ENTITY1.class)
							.setParameter(1, df.parse(todate)).getResultList();

					File responseCamt = new File(env.getProperty("output.exportpathtemp") + "011-BRF-038-AT.xls");
					Workbook workbook = WorkbookFactory.create(responseCamt);

					Sheet sheet = workbook.getSheetAt(0);

					/* sheet static values update part */

					if (T1Master.size() == 1) {
						for (BRF38_ENTITY1 brf038 : T1Master) {

							updateSheetStaticValues(sheet, brf038);

						}
					}

					/* Iteration Part */

					/* Remaining Countries */
					if (!T1Master2.isEmpty()) {

						int startRow = 87; // Starting row index
						System.out.println("T1Master2 size: " + T1Master2.size());

						for (int index = 0; index < T1Master2.size(); index++) {
							Object[] brf038 = T1Master2.get(index);
							Row row = sheet.getRow(startRow + index);
							if (row == null) {
								row = sheet.createRow(startRow + index);
							}

							// remaining_countries
							Cell cell2 = row.getCell(2);
							if (cell2 == null) {
								cell2 = row.createCell(2);
							}

							cell2.setCellValue(brf038[1] == null ? "" : brf038[1].toString());

							// outward_family1
							Cell cell3 = row.getCell(3);
							if (cell3 == null) {
								cell3 = row.createCell(3);
							}

							cell3.setCellValue(brf038[2] == null ? 0 : ((BigDecimal) brf038[2]).intValue());

							// outward_investment1
							Cell cell4 = row.getCell(4);
							if (cell4 == null) {
								cell4 = row.createCell(4);
							}
							cell4.setCellValue(brf038[3] == null ? 0 : ((BigDecimal) brf038[3]).intValue());

							// outward_trade1
							Cell cell5 = row.getCell(5);
							if (cell5 == null) {
								cell5 = row.createCell(5);
							}

							cell5.setCellValue(brf038[4] == null ? 0 : ((BigDecimal) brf038[4]).intValue());

							// outward_other1
							Cell cell6 = row.getCell(6);
							if (cell6 == null) {
								cell6 = row.createCell(6);
							}

							cell6.setCellValue(brf038[5] == null ? 0 : ((BigDecimal) brf038[5]).intValue());

							// inward_family1
							Cell cell9 = row.getCell(9);
							if (cell9 == null) {
								cell9 = row.createCell(9);
							}
							cell9.setCellValue(brf038[7] == null ? 0 : ((BigDecimal) brf038[7]).intValue());

							// inward_investment1
							Cell cell10 = row.getCell(10);
							if (cell10 == null) {
								cell10 = row.createCell(10);
							}
							cell10.setCellValue(brf038[8] == null ? 0 : ((BigDecimal) brf038[8]).intValue());

							// inward_trade1
							Cell cell11 = row.getCell(11);
							if (cell11 == null) {
								cell11 = row.createCell(11);
							}
							cell11.setCellValue(brf038[9] == null ? 0 : ((BigDecimal) brf038[9]).intValue());

							// inward_other1
							Cell cell12 = row.getCell(12);
							if (cell12 == null) {
								cell12 = row.createCell(12);
							}
							cell12.setCellValue(brf038[10] == null ? 0 : ((BigDecimal) brf038[10]).intValue());

						}
					} else {
						System.out.println("No data found for the specified date.");
					}

					workbook.getCreationHelper().createFormulaEvaluator().evaluateAll();

					FileOutputStream fileOut = new FileOutputStream(
							env.getProperty("output.exportpathfinal") + "011-BRF-038-A.xls");
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
			}
		}

		outputFile = new File(env.getProperty("output.exportpathfinal") + "011-BRF-038-A.xls");

		return outputFile;

	}

	public String detailChanges38(BRF38_DETAIL_ENTITY detail, String foracid, String report_addl_criteria_1,
			BigDecimal act_balance_amt_lc, String report_label_1, String report_name_1, String report_addl_criteria_2,
			String purpose_of_rem) {

		String msg = "";

		try {

			Session hs = sessionFactory.getCurrentSession();
			System.out.println(foracid + "| |" + purpose_of_rem + "| |" + report_addl_criteria_2);
			BRF38_DETAIL_ENTITY Brf38detail = BRF38_DetaiRep.findByCustomCriteria(foracid, report_addl_criteria_2,
					purpose_of_rem);
			System.out.println(foracid + "| |" + purpose_of_rem + "| |" + report_addl_criteria_2);
			System.out.println(Brf38detail);

			System.out.println(act_balance_amt_lc + report_label_1 + report_name_1 + report_addl_criteria_1);
			if (Brf38detail != null) {

				Brf38detail.setAct_balance_amt_lc(act_balance_amt_lc);
				Brf38detail.setReport_label_1(report_label_1);
				Brf38detail.setReport_name_1(report_name_1);
				Brf38detail.setReport_addl_criteria_1(report_addl_criteria_1);
				BRF38_DetaiRep.save(Brf38detail);

				// hs.saveOrUpdate(detail);
				logger.info("Edited Record");
				msg = "Edited Successfully";

			} else {
				msg = "No data Found";
			}

		} catch (Exception e) {

			msg = "error occured. Please contact Administrator";
			e.printStackTrace();
		}

		return msg;
	}

	// TO show thw Archieve values public ModelAndView
	public ModelAndView getArchieveBRF038View(String reportId, String fromdate, String todate, String currency,
			String dtltype, Pageable pageable) {

		String msg = "";
		ModelAndView mv = new ModelAndView();
		Session hs = sessionFactory.getCurrentSession();
		int pageSize = pageable.getPageSize();
		int currentPage = pageable.getPageNumber();
		int startItem = currentPage * pageSize;
		List<BRF38_ENTITY1> T1rep = new ArrayList<BRF38_ENTITY1>();
		// Query<Object[]> qr;
		List<BRF38_ENTITY1> T1Master1 = new ArrayList<BRF38_ENTITY1>();
		// List<BRF38_ENTITY2> T2rep = new ArrayList<BRF38_ENTITY2>();
		List<BRF38_ENTITY2> Remaining = new ArrayList<BRF38_ENTITY2>();
		List<BRF38_ENTITY2> ROWLABEL = new ArrayList<BRF38_ENTITY2>();

		List<Object[]> T2rep = new ArrayList<Object[]>();
		logger.info("Inside archive" + currency);

		try {
			Date d1 = df.parse(todate);
			// T1rep = t1CurProdServiceRepo.getT1CurProdServices(d1);
			T1Master1 = hs.createQuery("from  BRF38_ENTITY1 a where a.report_date = ?1 ", BRF38_ENTITY1.class)
					.setParameter(1, df.parse(todate)).getResultList();
			ROWLABEL = hs.createQuery("from  BRF38_ENTITY2 a where a.report_date = ?1 ", BRF38_ENTITY2.class)
					.setParameter(1, df.parse(todate)).getResultList();

			T2rep = brf38entity2.findallvalues(todate);

			// Initialize Total for each entity
			/*
			 * BigDecimal outwardTotal = BigDecimal.ZERO; BigDecimal inwardTotal =
			 * BigDecimal.ZERO;
			 */
			System.out.println(T2rep.toString());

			if (T2rep.size() > 0) {
				System.out.println(T2rep.toString());
				for (Object[] BRF038 : T2rep) {
					System.out.println("Inside loop");
					BigDecimal outward = BigDecimal.ZERO;
					BigDecimal inward = BigDecimal.ZERO;
					BRF38_ENTITY2 BRF38_ENTITY2 = new BRF38_ENTITY2();
					System.out.println("Sub Countries : " + BRF038.toString());

					BRF38_ENTITY2.setRemaining_countries((String) BRF038[1]);
					// BRF38_ENTITY2.setRemaining_countries(BRF038.get);

					System.out.println(BRF38_ENTITY2.getRemaining_countries());
					BRF38_ENTITY2.setOutward_family1((BigDecimal) BRF038[2]);
					BRF38_ENTITY2.setOutward_investment1((BigDecimal) BRF038[3]);
					BRF38_ENTITY2.setOutward_trade1((BigDecimal) BRF038[4]);
					BRF38_ENTITY2.setOutward_other1((BigDecimal) BRF038[5]);
					BRF38_ENTITY2.setInward_family1((BigDecimal) BRF038[7]);
					BRF38_ENTITY2.setInward_investment1((BigDecimal) BRF038[8]);
					BRF38_ENTITY2.setInward_trade1((BigDecimal) BRF038[9]);
					BRF38_ENTITY2.setInward_other1((BigDecimal) BRF038[10]);
					BRF38_ENTITY2.setRow_label((String) BRF038[12]);

					// data for different columns from BRF38 array
					BigDecimal fam = (BigDecimal) BRF038[2];
					BigDecimal invest = (BigDecimal) BRF038[3];
					BigDecimal trade = (BigDecimal) BRF038[4];
					BigDecimal other = (BigDecimal) BRF038[5];

					// Calculate the sum of values from different columns
					outward = outward.add(fam).add(invest).add(trade).add(other);

					BRF38_ENTITY2.setOutward_total1(outward);

					// Data for different columns from BRF38 array
					BigDecimal fam1 = (BigDecimal) BRF038[7];
					BigDecimal invest1 = (BigDecimal) BRF038[8];
					BigDecimal trade1 = (BigDecimal) BRF038[9];
					BigDecimal other1 = (BigDecimal) BRF038[10];

					// Calculate the sum of values from different columns
					inward = inward.add(fam1).add(invest1).add(trade1).add(other1);

					BRF38_ENTITY2.setInward_total1(inward);

					Remaining.add(BRF38_ENTITY2);

				}
			} else {
				msg = "No data Found";
			}

		} catch (ParseException e) {
			e.printStackTrace();
		}

		// T1rep = t1CurProdServiceRepo.getT1CurProdServices(d1);

		mv.setViewName("RR/BRF38ARCH");
		// mv.addObject("currlist", refCodeConfig.currList());
		mv.addObject("reportsummary", T2rep);
		mv.addObject("reportsummary1", T1Master1);
		System.out.println(Remaining);
		mv.addObject("Remaining", Remaining);

		// REMAINING
		mv.addObject("getremainoutwardfam", brf38entity2.getremainoutwardfam(todate));
		mv.addObject("getremaininwardfam", brf38entity2.getremaininwardfam(todate));
		mv.addObject("getremainoutwardinvest", brf38entity2.getremainoutwardinvest(todate));
		mv.addObject("getremaininwardinvest", brf38entity2.getremaininwardinvest(todate));
		mv.addObject("getremainoutwardtrade", brf38entity2.getremainoutwardtrade(todate));
		mv.addObject("getremaininwardtrade", brf38entity2.getremaininwardtrade(todate));
		mv.addObject("getremainoutwardother", brf38entity2.getremainoutwardother(todate));
		mv.addObject("getremaininwardother", brf38entity2.getremaininwardother(todate));

		mv.addObject("getreaminingamouttotal", brf38entity2.getreaminingamouttotal(todate));
		mv.addObject("getreaminingamintotal", brf38entity2.getreaminingamintotal(todate));

		mv.addObject("reportmaster", T2rep);
		mv.addObject("ROWLABEL", ROWLABEL);
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
	 ***/

	public ModelAndView ARCHgetBRF038currentDtl(String reportId, String fromdate, String todate, String currency,
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
				qr = hs.createNativeQuery(
						"select * from BRF38_ARCHIVTABLE  where report_date = ?1 and report_label_1=?2");
				qr.setParameter(2, filter);
			} else {
				qr = hs.createNativeQuery("select * from BRF38_ARCHIVTABLE  where report_date = ?1");
			}
		} else {
			qr = hs.createNativeQuery("select * from BRF38_ARCHIVTABLE  where report_date = ?1");
		}

		try {
			qr.setParameter(1, df.parse(todate));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<BRF38_ARCHIVENTITY> T1Master = new ArrayList<BRF38_ARCHIVENTITY>();

		try {
			T1Master = hs.createQuery("from BRF38_ARCHIVENTITY a where a.report_date = ?1", BRF38_ARCHIVENTITY.class)
					.setParameter(1, df.parse(todate)).getResultList();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		logger.info("Getting Report Detail for : " + reportId + "," + fromdate + "," + todate + "," + currency);
		List<Object[]> result = qr.getResultList();

		for (Object[] a : result) {
			String cust_id = (String) a[0];
			String foracid = (String) a[1];

			String acct_name = (String) a[2];
			BigDecimal eab_lc = (BigDecimal) a[3];
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

			BRF38_ARCHIVENTITY py = new BRF38_ARCHIVENTITY(cust_id, foracid, acct_name, eab_lc, act_balance_amt_lc,
					acct_crncy_code, gl_code, gl_sub_head_code, gl_sub_head_desc, country_of_incorp, cust_type,
					schm_code, schm_type, sol_id, acid, segment, sub_segment, sector, sub_sector, sector_code, group_id,
					constitution_code, country, legal_entity_type, constitution_desc, purpose_of_advn, hni_networth,
					turnover, bacid, report_name_1, report_label_1, report_addl_criteria_1, report_addl_criteria_2,
					report_addl_criteria_3, create_user, create_time, modify_user, modify_time, verify_user,
					verify_time, entity_flg, modify_flg, del_flg, nre_status, report_date, maturity_date, version,
					remarks);

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

		mv.setViewName("RR" + "/" + "BRF38ARCH::reportcontent");
		// mv.setViewName("ReportT1");
		mv.addObject("reportdetails", T1Dt1Page);
		mv.addObject("reportmaster", T1Master);
		mv.addObject("singledetail", new T1CurProdDetail());
		mv.addObject("reportsflag", "reportsflag");
		mv.addObject("menu", reportId);
		return mv;
	}

	private static int calculatePageHeight(List<JRPrintElement> elements) {
		int maxHeight = 0;

		for (JRPrintElement element : elements) {
			// Adjust this based on your element's properties
			int elementHeight = element.getY() + element.getHeight();
			maxHeight = Math.max(maxHeight, elementHeight);
		}

		return maxHeight;
	}

	public void updateSheetStaticValues(Sheet sheet, BRF38_ENTITY1 brf038) {
		/* EXCEL ROW 10 - ENTITY ROW 11 */
		Row row10 = sheet.getRow(10);

		Cell row10cell3 = row10.getCell(3);

		if (row10cell3 != null) {
			row10cell3.setCellValue(
					brf038.getR11_outward_family() == null ? 0 : brf038.getR11_outward_family().intValue());
		}

		Cell row10cell4 = row10.getCell(4);

		if (row10cell4 != null) {
			row10cell4.setCellValue(
					brf038.getR11_outward_investment() == null ? 0 : brf038.getR11_outward_investment().intValue());
		}

		Cell row10cell5 = row10.getCell(5);

		if (row10cell5 != null) {
			row10cell5
					.setCellValue(brf038.getR11_outward_trade() == null ? 0 : brf038.getR11_outward_trade().intValue());
		}

		Cell row10cell6 = row10.getCell(6);

		if (row10cell6 != null) {
			row10cell6
					.setCellValue(brf038.getR11_outward_other() == null ? 0 : brf038.getR11_outward_other().intValue());
		}

		Cell row10cell9 = row10.getCell(9);

		if (row10cell9 != null) {
			row10cell9
					.setCellValue(brf038.getR11_inward_family() == null ? 0 : brf038.getR11_inward_family().intValue());
		}

		Cell row10cell10 = row10.getCell(10);

		if (row10cell10 != null) {
			row10cell10.setCellValue(
					brf038.getR11_inward_investment() == null ? 0 : brf038.getR11_inward_investment().intValue());
		}

		Cell row10cell11 = row10.getCell(11);

		if (row10cell11 != null) {
			row10cell11
					.setCellValue(brf038.getR11_inward_trade() == null ? 0 : brf038.getR11_inward_trade().intValue());
		}

		Cell row10cell12 = row10.getCell(12);

		if (row10cell12 != null) {
			row10cell12
					.setCellValue(brf038.getR11_inward_other() == null ? 0 : brf038.getR11_inward_other().intValue());
		}

		/* EXCEL ROW 11 - ENTITY ROW 12 */
		Row row11 = sheet.getRow(11);

		Cell row11cell3 = row11.getCell(3);

		if (row11cell3 != null) {
			row11cell3.setCellValue(
					brf038.getR12_outward_family() == null ? 0 : brf038.getR12_outward_family().intValue());
		}

		Cell row11cell4 = row11.getCell(4);

		if (row11cell4 != null) {
			row11cell4.setCellValue(
					brf038.getR12_outward_investment() == null ? 0 : brf038.getR12_outward_investment().intValue());
		}

		Cell row11cell5 = row11.getCell(5);

		if (row11cell5 != null) {
			row11cell5
					.setCellValue(brf038.getR12_outward_trade() == null ? 0 : brf038.getR12_outward_trade().intValue());
		}

		Cell row11cell6 = row11.getCell(6);

		if (row11cell6 != null) {
			row11cell6
					.setCellValue(brf038.getR12_outward_other() == null ? 0 : brf038.getR12_outward_other().intValue());
		}

		Cell row11cell9 = row11.getCell(9);

		if (row11cell9 != null) {
			row11cell9
					.setCellValue(brf038.getR12_inward_family() == null ? 0 : brf038.getR12_inward_family().intValue());
		}

		Cell row11cell10 = row11.getCell(10);

		if (row11cell10 != null) {
			row11cell10.setCellValue(
					brf038.getR12_inward_investment() == null ? 0 : brf038.getR12_inward_investment().intValue());
		}

		Cell row11cell11 = row11.getCell(11);

		if (row11cell11 != null) {
			row11cell11
					.setCellValue(brf038.getR12_inward_trade() == null ? 0 : brf038.getR12_inward_trade().intValue());
		}

		Cell row11cell12 = row11.getCell(12);

		if (row11cell12 != null) {
			row11cell12
					.setCellValue(brf038.getR12_inward_other() == null ? 0 : brf038.getR12_inward_other().intValue());
		}

		/* EXCEL ROW 13 - ENTITY ROW 14 */
		Row row13 = sheet.getRow(13);

		Cell row13cell3 = row13.getCell(3);

		if (row13cell3 != null) {
			row13cell3.setCellValue(
					brf038.getR14_outward_family() == null ? 0 : brf038.getR14_outward_family().intValue());
		}

		Cell row13cell4 = row13.getCell(4);

		if (row13cell4 != null) {
			row13cell4.setCellValue(
					brf038.getR14_outward_investment() == null ? 0 : brf038.getR14_outward_investment().intValue());
		}

		Cell row13cell5 = row13.getCell(5);

		if (row13cell5 != null) {
			row13cell5
					.setCellValue(brf038.getR14_outward_trade() == null ? 0 : brf038.getR14_outward_trade().intValue());
		}

		Cell row13cell6 = row13.getCell(6);

		if (row13cell6 != null) {
			row13cell6
					.setCellValue(brf038.getR14_outward_other() == null ? 0 : brf038.getR14_outward_other().intValue());
		}

		Cell row13cell9 = row13.getCell(9);

		if (row13cell9 != null) {
			row13cell9
					.setCellValue(brf038.getR14_inward_family() == null ? 0 : brf038.getR14_inward_family().intValue());
		}

		Cell row13cell10 = row13.getCell(10);

		if (row13cell10 != null) {
			row13cell10.setCellValue(
					brf038.getR14_inward_investment() == null ? 0 : brf038.getR14_inward_investment().intValue());
		}

		Cell row13cell11 = row13.getCell(11);

		if (row13cell11 != null) {
			row13cell11
					.setCellValue(brf038.getR14_inward_trade() == null ? 0 : brf038.getR14_inward_trade().intValue());
		}

		Cell row13cell12 = row13.getCell(12);

		if (row13cell12 != null) {
			row13cell12
					.setCellValue(brf038.getR14_inward_other() == null ? 0 : brf038.getR14_inward_other().intValue());
		}

		/* EXCEL ROW 14 - ENTITY ROW 15 */
		Row row14 = sheet.getRow(14);

		Cell row14cell3 = row14.getCell(3);

		if (row14cell3 != null) {
			row14cell3.setCellValue(
					brf038.getR15_outward_family() == null ? 0 : brf038.getR15_outward_family().intValue());
		}

		Cell row14cell4 = row14.getCell(4);

		if (row14cell4 != null) {
			row14cell4.setCellValue(
					brf038.getR15_outward_investment() == null ? 0 : brf038.getR15_outward_investment().intValue());
		}

		Cell row14cell5 = row14.getCell(5);

		if (row14cell5 != null) {
			row14cell5
					.setCellValue(brf038.getR15_outward_trade() == null ? 0 : brf038.getR15_outward_trade().intValue());
		}

		Cell row14cell6 = row14.getCell(6);

		if (row14cell6 != null) {
			row14cell6
					.setCellValue(brf038.getR15_outward_other() == null ? 0 : brf038.getR15_outward_other().intValue());
		}

		Cell row14cell9 = row14.getCell(9);

		if (row14cell9 != null) {
			row14cell9
					.setCellValue(brf038.getR15_inward_family() == null ? 0 : brf038.getR15_inward_family().intValue());
		}

		Cell row14cell10 = row14.getCell(10);

		if (row14cell10 != null) {
			row14cell10.setCellValue(
					brf038.getR15_inward_investment() == null ? 0 : brf038.getR15_inward_investment().intValue());
		}

		Cell row14cell11 = row14.getCell(11);

		if (row14cell11 != null) {
			row14cell11
					.setCellValue(brf038.getR15_inward_trade() == null ? 0 : brf038.getR15_inward_trade().intValue());
		}

		Cell row14cell12 = row14.getCell(12);

		if (row14cell12 != null) {
			row14cell12
					.setCellValue(brf038.getR15_inward_other() == null ? 0 : brf038.getR15_inward_other().intValue());
		}

		/* EXCEL ROW 15 - ENTITY ROW 16 */
		Row row15 = sheet.getRow(15);

		Cell row15cell3 = row15.getCell(3);

		if (row15cell3 != null) {
			row15cell3.setCellValue(
					brf038.getR16_outward_family() == null ? 0 : brf038.getR16_outward_family().intValue());
		}

		Cell row15cell4 = row15.getCell(4);

		if (row15cell4 != null) {
			row15cell4.setCellValue(
					brf038.getR16_outward_investment() == null ? 0 : brf038.getR16_outward_investment().intValue());
		}

		Cell row15cell5 = row15.getCell(5);

		if (row15cell5 != null) {
			row15cell5
					.setCellValue(brf038.getR16_outward_trade() == null ? 0 : brf038.getR16_outward_trade().intValue());
		}

		Cell row15cell6 = row15.getCell(6);

		if (row15cell6 != null) {
			row15cell6
					.setCellValue(brf038.getR16_outward_other() == null ? 0 : brf038.getR16_outward_other().intValue());
		}

		Cell row15cell9 = row15.getCell(9);

		if (row15cell9 != null) {
			row15cell9
					.setCellValue(brf038.getR16_inward_family() == null ? 0 : brf038.getR16_inward_family().intValue());
		}

		Cell row15cell10 = row15.getCell(10);

		if (row15cell10 != null) {
			row15cell10.setCellValue(
					brf038.getR16_inward_investment() == null ? 0 : brf038.getR16_inward_investment().intValue());
		}

		Cell row15cell11 = row15.getCell(11);

		if (row15cell11 != null) {
			row15cell11
					.setCellValue(brf038.getR16_inward_trade() == null ? 0 : brf038.getR16_inward_trade().intValue());
		}

		Cell row15cell12 = row15.getCell(12);

		if (row15cell12 != null) {
			row15cell12
					.setCellValue(brf038.getR16_inward_other() == null ? 0 : brf038.getR16_inward_other().intValue());
		}

		/* EXCEL ROW 16 - ENTITY ROW 17 */
		Row row16 = sheet.getRow(16);

		Cell row16cell3 = row16.getCell(3);

		if (row16cell3 != null) {
			row16cell3.setCellValue(
					brf038.getR17_outward_family() == null ? 0 : brf038.getR17_outward_family().intValue());
		}

		Cell row16cell4 = row16.getCell(4);

		if (row16cell4 != null) {
			row16cell4.setCellValue(
					brf038.getR17_outward_investment() == null ? 0 : brf038.getR17_outward_investment().intValue());
		}

		Cell row16cell5 = row16.getCell(5);

		if (row16cell5 != null) {
			row16cell5
					.setCellValue(brf038.getR17_outward_trade() == null ? 0 : brf038.getR17_outward_trade().intValue());
		}

		Cell row16cell6 = row16.getCell(6);

		if (row16cell6 != null) {
			row16cell6
					.setCellValue(brf038.getR17_outward_other() == null ? 0 : brf038.getR17_outward_other().intValue());
		}

		Cell row16cell9 = row16.getCell(9);

		if (row16cell9 != null) {
			row16cell9
					.setCellValue(brf038.getR17_inward_family() == null ? 0 : brf038.getR17_inward_family().intValue());
		}

		Cell row16cell10 = row16.getCell(10);

		if (row16cell10 != null) {
			row16cell10.setCellValue(
					brf038.getR17_inward_investment() == null ? 0 : brf038.getR17_inward_investment().intValue());
		}

		Cell row16cell11 = row16.getCell(11);

		if (row16cell11 != null) {
			row16cell11
					.setCellValue(brf038.getR17_inward_trade() == null ? 0 : brf038.getR17_inward_trade().intValue());
		}

		Cell row16cell12 = row16.getCell(12);

		if (row16cell12 != null) {
			row16cell12
					.setCellValue(brf038.getR17_inward_other() == null ? 0 : brf038.getR17_inward_other().intValue());
		}

		/* EXCEL ROW 17 - ENTITY ROW 18 */
		Row row17 = sheet.getRow(17);

		Cell row17cell3 = row17.getCell(3);

		if (row17cell3 != null) {
			row17cell3.setCellValue(
					brf038.getR18_outward_family() == null ? 0 : brf038.getR18_outward_family().intValue());
		}

		Cell row17cell4 = row17.getCell(4);

		if (row17cell4 != null) {
			row17cell4.setCellValue(
					brf038.getR18_outward_investment() == null ? 0 : brf038.getR18_outward_investment().intValue());
		}

		Cell row17cell5 = row17.getCell(5);

		if (row17cell5 != null) {
			row17cell5
					.setCellValue(brf038.getR18_outward_trade() == null ? 0 : brf038.getR18_outward_trade().intValue());
		}

		Cell row17cell6 = row17.getCell(6);

		if (row17cell6 != null) {
			row17cell6
					.setCellValue(brf038.getR18_outward_other() == null ? 0 : brf038.getR18_outward_other().intValue());
		}

		Cell row17cell9 = row17.getCell(9);

		if (row17cell9 != null) {
			row17cell9
					.setCellValue(brf038.getR18_inward_family() == null ? 0 : brf038.getR18_inward_family().intValue());
		}

		Cell row17cell10 = row17.getCell(10);

		if (row17cell10 != null) {
			row17cell10.setCellValue(
					brf038.getR18_inward_investment() == null ? 0 : brf038.getR18_inward_investment().intValue());
		}

		Cell row17cell11 = row17.getCell(11);

		if (row17cell11 != null) {
			row17cell11
					.setCellValue(brf038.getR18_inward_trade() == null ? 0 : brf038.getR18_inward_trade().intValue());
		}

		Cell row17cell12 = row17.getCell(12);

		if (row17cell12 != null) {
			row17cell12
					.setCellValue(brf038.getR18_inward_other() == null ? 0 : brf038.getR18_inward_other().intValue());
		}

		/* EXCEL ROW 18 - ENTITY ROW 19 */
		Row row18 = sheet.getRow(18);

		Cell row18cell3 = row18.getCell(3);

		if (row18cell3 != null) {
			row18cell3.setCellValue(
					brf038.getR19_outward_family() == null ? 0 : brf038.getR19_outward_family().intValue());
		}

		Cell row18cell4 = row18.getCell(4);

		if (row18cell4 != null) {
			row18cell4.setCellValue(
					brf038.getR19_outward_investment() == null ? 0 : brf038.getR19_outward_investment().intValue());
		}

		Cell row18cell5 = row18.getCell(5);

		if (row18cell5 != null) {
			row18cell5
					.setCellValue(brf038.getR19_outward_trade() == null ? 0 : brf038.getR19_outward_trade().intValue());
		}

		Cell row18cell6 = row18.getCell(6);

		if (row18cell6 != null) {
			row18cell6
					.setCellValue(brf038.getR19_outward_other() == null ? 0 : brf038.getR19_outward_other().intValue());
		}

		Cell row18cell9 = row18.getCell(9);

		if (row18cell9 != null) {
			row18cell9
					.setCellValue(brf038.getR19_inward_family() == null ? 0 : brf038.getR19_inward_family().intValue());
		}

		Cell row18cell10 = row18.getCell(10);

		if (row18cell10 != null) {
			row18cell10.setCellValue(
					brf038.getR19_inward_investment() == null ? 0 : brf038.getR19_inward_investment().intValue());
		}

		Cell row18cell11 = row18.getCell(11);

		if (row18cell11 != null) {
			row18cell11
					.setCellValue(brf038.getR19_inward_trade() == null ? 0 : brf038.getR19_inward_trade().intValue());
		}

		Cell row18cell12 = row18.getCell(12);

		if (row18cell12 != null) {
			row18cell12
					.setCellValue(brf038.getR19_inward_other() == null ? 0 : brf038.getR19_inward_other().intValue());
		}

		/* EXCEL ROW 19 - ENTITY ROW 20 */
		Row row19 = sheet.getRow(19);

		Cell row19cell3 = row19.getCell(3);

		if (row19cell3 != null) {
			row19cell3.setCellValue(
					brf038.getR20_outward_family() == null ? 0 : brf038.getR20_outward_family().intValue());
		}

		Cell row19cell4 = row19.getCell(4);

		if (row19cell4 != null) {
			row19cell4.setCellValue(
					brf038.getR20_outward_investment() == null ? 0 : brf038.getR20_outward_investment().intValue());
		}

		Cell row19cell5 = row19.getCell(5);

		if (row19cell5 != null) {
			row19cell5
					.setCellValue(brf038.getR20_outward_trade() == null ? 0 : brf038.getR20_outward_trade().intValue());
		}

		Cell row19cell6 = row19.getCell(6);

		if (row19cell6 != null) {
			row19cell6
					.setCellValue(brf038.getR20_outward_other() == null ? 0 : brf038.getR20_outward_other().intValue());
		}

		Cell row19cell9 = row19.getCell(9);

		if (row19cell9 != null) {
			row19cell9
					.setCellValue(brf038.getR20_inward_family() == null ? 0 : brf038.getR20_inward_family().intValue());
		}

		Cell row19cell10 = row19.getCell(10);

		if (row19cell10 != null) {
			row19cell10.setCellValue(
					brf038.getR20_inward_investment() == null ? 0 : brf038.getR20_inward_investment().intValue());
		}

		Cell row19cell11 = row19.getCell(11);

		if (row19cell11 != null) {
			row19cell11
					.setCellValue(brf038.getR20_inward_trade() == null ? 0 : brf038.getR20_inward_trade().intValue());
		}

		Cell row19cell12 = row19.getCell(12);

		if (row19cell12 != null) {
			row19cell12
					.setCellValue(brf038.getR20_inward_other() == null ? 0 : brf038.getR20_inward_other().intValue());
		}

		/* EXCEL ROW 20 - ENTITY ROW 21 */
		Row row20 = sheet.getRow(20);

		Cell row20cell3 = row20.getCell(3);

		if (row20cell3 != null) {
			row20cell3.setCellValue(
					brf038.getR21_outward_family() == null ? 0 : brf038.getR21_outward_family().intValue());
		}

		Cell row20cell4 = row20.getCell(4);

		if (row20cell4 != null) {
			row20cell4.setCellValue(
					brf038.getR21_outward_investment() == null ? 0 : brf038.getR21_outward_investment().intValue());
		}

		Cell row20cell5 = row20.getCell(5);

		if (row20cell5 != null) {
			row20cell5
					.setCellValue(brf038.getR21_outward_trade() == null ? 0 : brf038.getR21_outward_trade().intValue());
		}

		Cell row20cell6 = row20.getCell(6);

		if (row20cell6 != null) {
			row20cell6
					.setCellValue(brf038.getR21_outward_other() == null ? 0 : brf038.getR21_outward_other().intValue());
		}

		Cell row20cell9 = row20.getCell(9);

		if (row20cell9 != null) {
			row20cell9
					.setCellValue(brf038.getR21_inward_family() == null ? 0 : brf038.getR21_inward_family().intValue());
		}

		Cell row20cell10 = row20.getCell(10);

		if (row20cell10 != null) {
			row20cell10.setCellValue(
					brf038.getR21_inward_investment() == null ? 0 : brf038.getR21_inward_investment().intValue());
		}

		Cell row20cell11 = row20.getCell(11);

		if (row20cell11 != null) {
			row20cell11
					.setCellValue(brf038.getR21_inward_trade() == null ? 0 : brf038.getR21_inward_trade().intValue());
		}

		Cell row20cell12 = row20.getCell(12);

		if (row20cell12 != null) {
			row20cell12
					.setCellValue(brf038.getR21_inward_other() == null ? 0 : brf038.getR21_inward_other().intValue());
		}

		/* EXCEL ROW 21 - ENTITY ROW 22 */
		Row row21 = sheet.getRow(21);

		Cell row21cell3 = row21.getCell(3);

		if (row21cell3 != null) {
			row21cell3.setCellValue(
					brf038.getR22_outward_family() == null ? 0 : brf038.getR22_outward_family().intValue());
		}

		Cell row21cell4 = row21.getCell(4);

		if (row21cell4 != null) {
			row21cell4.setCellValue(
					brf038.getR22_outward_investment() == null ? 0 : brf038.getR22_outward_investment().intValue());
		}

		Cell row21cell5 = row21.getCell(5);

		if (row21cell5 != null) {
			row21cell5
					.setCellValue(brf038.getR22_outward_trade() == null ? 0 : brf038.getR22_outward_trade().intValue());
		}

		Cell row21cell6 = row21.getCell(6);

		if (row21cell6 != null) {
			row21cell6
					.setCellValue(brf038.getR22_outward_other() == null ? 0 : brf038.getR22_outward_other().intValue());
		}

		Cell row21cell9 = row21.getCell(9);

		if (row21cell9 != null) {
			row21cell9
					.setCellValue(brf038.getR22_inward_family() == null ? 0 : brf038.getR22_inward_family().intValue());
		}

		Cell row21cell10 = row21.getCell(10);

		if (row21cell10 != null) {
			row21cell10.setCellValue(
					brf038.getR22_inward_investment() == null ? 0 : brf038.getR22_inward_investment().intValue());
		}

		Cell row21cell11 = row21.getCell(11);

		if (row21cell11 != null) {
			row21cell11
					.setCellValue(brf038.getR22_inward_trade() == null ? 0 : brf038.getR22_inward_trade().intValue());
		}

		Cell row21cell12 = row21.getCell(12);

		if (row21cell12 != null) {
			row21cell12
					.setCellValue(brf038.getR22_inward_other() == null ? 0 : brf038.getR22_inward_other().intValue());
		}

		/* EXCEL ROW 22 - ENTITY ROW 23 */
		Row row22 = sheet.getRow(22);

		Cell row22cell3 = row22.getCell(3);

		if (row22cell3 != null) {
			row22cell3.setCellValue(
					brf038.getR23_outward_family() == null ? 0 : brf038.getR23_outward_family().intValue());
		}

		Cell row22cell4 = row22.getCell(4);

		if (row22cell4 != null) {
			row22cell4.setCellValue(
					brf038.getR23_outward_investment() == null ? 0 : brf038.getR23_outward_investment().intValue());
		}

		Cell row22cell5 = row22.getCell(5);

		if (row22cell5 != null) {
			row22cell5
					.setCellValue(brf038.getR23_outward_trade() == null ? 0 : brf038.getR23_outward_trade().intValue());
		}

		Cell row22cell6 = row22.getCell(6);

		if (row22cell6 != null) {
			row22cell6
					.setCellValue(brf038.getR23_outward_other() == null ? 0 : brf038.getR23_outward_other().intValue());
		}

		Cell row22cell9 = row22.getCell(9);

		if (row22cell9 != null) {
			row22cell9
					.setCellValue(brf038.getR23_inward_family() == null ? 0 : brf038.getR23_inward_family().intValue());
		}

		Cell row22cell10 = row22.getCell(10);

		if (row22cell10 != null) {
			row22cell10.setCellValue(
					brf038.getR23_inward_investment() == null ? 0 : brf038.getR23_inward_investment().intValue());
		}

		Cell row22cell11 = row22.getCell(11);

		if (row22cell11 != null) {
			row22cell11
					.setCellValue(brf038.getR23_inward_trade() == null ? 0 : brf038.getR23_inward_trade().intValue());
		}

		Cell row22cell12 = row22.getCell(12);

		if (row22cell12 != null) {
			row22cell12
					.setCellValue(brf038.getR23_inward_other() == null ? 0 : brf038.getR23_inward_other().intValue());
		}

		/* EXCEL ROW 23 - ENTITY ROW 24 */
		Row row23 = sheet.getRow(23);

		Cell row23cell3 = row23.getCell(3);

		if (row23cell3 != null) {
			row23cell3.setCellValue(
					brf038.getR24_outward_family() == null ? 0 : brf038.getR24_outward_family().intValue());
		}

		Cell row23cell4 = row23.getCell(4);

		if (row23cell4 != null) {
			row23cell4.setCellValue(
					brf038.getR24_outward_investment() == null ? 0 : brf038.getR24_outward_investment().intValue());
		}

		Cell row23cell5 = row23.getCell(5);

		if (row23cell5 != null) {
			row23cell5
					.setCellValue(brf038.getR24_outward_trade() == null ? 0 : brf038.getR24_outward_trade().intValue());
		}

		Cell row23cell6 = row23.getCell(6);

		if (row23cell6 != null) {
			row23cell6
					.setCellValue(brf038.getR24_outward_other() == null ? 0 : brf038.getR24_outward_other().intValue());
		}

		Cell row23cell9 = row23.getCell(9);

		if (row23cell9 != null) {
			row23cell9
					.setCellValue(brf038.getR24_inward_family() == null ? 0 : brf038.getR24_inward_family().intValue());
		}

		Cell row23cell10 = row23.getCell(10);

		if (row23cell10 != null) {
			row23cell10.setCellValue(
					brf038.getR24_inward_investment() == null ? 0 : brf038.getR24_inward_investment().intValue());
		}

		Cell row23cell11 = row23.getCell(11);

		if (row23cell11 != null) {
			row23cell11
					.setCellValue(brf038.getR24_inward_trade() == null ? 0 : brf038.getR24_inward_trade().intValue());
		}

		Cell row23cell12 = row23.getCell(12);

		if (row23cell12 != null) {
			row23cell12
					.setCellValue(brf038.getR24_inward_other() == null ? 0 : brf038.getR24_inward_other().intValue());
		}

		/* EXCEL ROW 24 - ENTITY ROW 25 */
		Row row24 = sheet.getRow(24);

		Cell row24cell3 = row24.getCell(3);

		if (row24cell3 != null) {
			row24cell3.setCellValue(
					brf038.getR25_outward_family() == null ? 0 : brf038.getR25_outward_family().intValue());
		}

		Cell row24cell4 = row24.getCell(4);

		if (row24cell4 != null) {
			row24cell4.setCellValue(
					brf038.getR25_outward_investment() == null ? 0 : brf038.getR25_outward_investment().intValue());
		}

		Cell row24cell5 = row24.getCell(5);

		if (row24cell5 != null) {
			row24cell5
					.setCellValue(brf038.getR25_outward_trade() == null ? 0 : brf038.getR25_outward_trade().intValue());
		}

		Cell row24cell6 = row24.getCell(6);

		if (row24cell6 != null) {
			row24cell6
					.setCellValue(brf038.getR25_outward_other() == null ? 0 : brf038.getR25_outward_other().intValue());
		}

		Cell row24cell9 = row24.getCell(9);

		if (row24cell9 != null) {
			row24cell9
					.setCellValue(brf038.getR25_inward_family() == null ? 0 : brf038.getR25_inward_family().intValue());
		}

		Cell row24cell10 = row24.getCell(10);

		if (row24cell10 != null) {
			row24cell10.setCellValue(
					brf038.getR25_inward_investment() == null ? 0 : brf038.getR25_inward_investment().intValue());
		}

		Cell row24cell11 = row24.getCell(11);

		if (row24cell11 != null) {
			row24cell11
					.setCellValue(brf038.getR25_inward_trade() == null ? 0 : brf038.getR25_inward_trade().intValue());
		}

		Cell row24cell12 = row24.getCell(12);

		if (row24cell12 != null) {
			row24cell12
					.setCellValue(brf038.getR25_inward_other() == null ? 0 : brf038.getR25_inward_other().intValue());
		}

		/* EXCEL ROW 25 - ENTITY ROW 26 */
		Row row25 = sheet.getRow(25);

		Cell row25cell3 = row25.getCell(3);

		if (row25cell3 != null) {
			row25cell3.setCellValue(
					brf038.getR26_outward_family() == null ? 0 : brf038.getR26_outward_family().intValue());
		}

		Cell row25cell4 = row25.getCell(4);

		if (row25cell4 != null) {
			row25cell4.setCellValue(
					brf038.getR26_outward_investment() == null ? 0 : brf038.getR26_outward_investment().intValue());
		}

		Cell row25cell5 = row25.getCell(5);

		if (row25cell5 != null) {
			row25cell5
					.setCellValue(brf038.getR26_outward_trade() == null ? 0 : brf038.getR26_outward_trade().intValue());
		}

		Cell row25cell6 = row25.getCell(6);

		if (row25cell6 != null) {
			row25cell6
					.setCellValue(brf038.getR26_outward_other() == null ? 0 : brf038.getR26_outward_other().intValue());
		}

		Cell row25cell9 = row25.getCell(9);

		if (row25cell9 != null) {
			row25cell9
					.setCellValue(brf038.getR26_inward_family() == null ? 0 : brf038.getR26_inward_family().intValue());
		}

		Cell row25cell10 = row25.getCell(10);

		if (row25cell10 != null) {
			row25cell10.setCellValue(
					brf038.getR26_inward_investment() == null ? 0 : brf038.getR26_inward_investment().intValue());
		}

		Cell row25cell11 = row25.getCell(11);

		if (row25cell11 != null) {
			row25cell11
					.setCellValue(brf038.getR26_inward_trade() == null ? 0 : brf038.getR26_inward_trade().intValue());
		}

		Cell row25cell12 = row25.getCell(12);

		if (row25cell12 != null) {
			row25cell12
					.setCellValue(brf038.getR26_inward_other() == null ? 0 : brf038.getR26_inward_other().intValue());
		}

		/* EXCEL ROW 26 - ENTITY ROW 27 */
		Row row26 = sheet.getRow(26);

		Cell row26cell3 = row26.getCell(3);

		if (row26cell3 != null) {
			row26cell3.setCellValue(
					brf038.getR27_outward_family() == null ? 0 : brf038.getR27_outward_family().intValue());
		}

		Cell row26cell4 = row26.getCell(4);

		if (row26cell4 != null) {
			row26cell4.setCellValue(
					brf038.getR27_outward_investment() == null ? 0 : brf038.getR27_outward_investment().intValue());
		}

		Cell row26cell5 = row26.getCell(5);

		if (row26cell5 != null) {
			row26cell5
					.setCellValue(brf038.getR27_outward_trade() == null ? 0 : brf038.getR27_outward_trade().intValue());
		}

		Cell row26cell6 = row26.getCell(6);

		if (row26cell6 != null) {
			row26cell6
					.setCellValue(brf038.getR27_outward_other() == null ? 0 : brf038.getR27_outward_other().intValue());
		}

		Cell row26cell9 = row26.getCell(9);

		if (row26cell9 != null) {
			row26cell9
					.setCellValue(brf038.getR27_inward_family() == null ? 0 : brf038.getR27_inward_family().intValue());
		}

		Cell row26cell10 = row26.getCell(10);

		if (row26cell10 != null) {
			row26cell10.setCellValue(
					brf038.getR27_inward_investment() == null ? 0 : brf038.getR27_inward_investment().intValue());
		}

		Cell row26cell11 = row26.getCell(11);

		if (row26cell11 != null) {
			row26cell11
					.setCellValue(brf038.getR27_inward_trade() == null ? 0 : brf038.getR27_inward_trade().intValue());
		}

		Cell row26cell12 = row26.getCell(12);

		if (row26cell12 != null) {
			row26cell12
					.setCellValue(brf038.getR27_inward_other() == null ? 0 : brf038.getR27_inward_other().intValue());
		}

		/* EXCEL ROW 27 - ENTITY ROW 28 */
		Row row27 = sheet.getRow(27);

		Cell row27cell3 = row27.getCell(3);

		if (row27cell3 != null) {
			row27cell3.setCellValue(
					brf038.getR28_outward_family() == null ? 0 : brf038.getR28_outward_family().intValue());
		}

		Cell row27cell4 = row27.getCell(4);

		if (row27cell4 != null) {
			row27cell4.setCellValue(
					brf038.getR28_outward_investment() == null ? 0 : brf038.getR28_outward_investment().intValue());
		}

		Cell row27cell5 = row27.getCell(5);

		if (row27cell5 != null) {
			row27cell5
					.setCellValue(brf038.getR28_outward_trade() == null ? 0 : brf038.getR28_outward_trade().intValue());
		}

		Cell row27cell6 = row27.getCell(6);

		if (row27cell6 != null) {
			row27cell6
					.setCellValue(brf038.getR28_outward_other() == null ? 0 : brf038.getR28_outward_other().intValue());
		}

		Cell row27cell9 = row27.getCell(9);

		if (row27cell9 != null) {
			row27cell9
					.setCellValue(brf038.getR28_inward_family() == null ? 0 : brf038.getR28_inward_family().intValue());
		}

		Cell row27cell10 = row27.getCell(10);

		if (row27cell10 != null) {
			row27cell10.setCellValue(
					brf038.getR28_inward_investment() == null ? 0 : brf038.getR28_inward_investment().intValue());
		}

		Cell row27cell11 = row27.getCell(11);

		if (row27cell11 != null) {
			row27cell11
					.setCellValue(brf038.getR28_inward_trade() == null ? 0 : brf038.getR28_inward_trade().intValue());
		}

		Cell row27cell12 = row27.getCell(12);

		if (row27cell12 != null) {
			row27cell12
					.setCellValue(brf038.getR28_inward_other() == null ? 0 : brf038.getR28_inward_other().intValue());
		}

		/* EXCEL ROW 28 - ENTITY ROW 29 */
		Row row28 = sheet.getRow(28);

		Cell row28cell3 = row28.getCell(3);

		if (row28cell3 != null) {
			row28cell3.setCellValue(
					brf038.getR29_outward_family() == null ? 0 : brf038.getR29_outward_family().intValue());
		}

		Cell row28cell4 = row28.getCell(4);

		if (row28cell4 != null) {
			row28cell4.setCellValue(
					brf038.getR29_outward_investment() == null ? 0 : brf038.getR29_outward_investment().intValue());
		}

		Cell row28cell5 = row28.getCell(5);

		if (row28cell5 != null) {
			row28cell5
					.setCellValue(brf038.getR29_outward_trade() == null ? 0 : brf038.getR29_outward_trade().intValue());
		}

		Cell row28cell6 = row28.getCell(6);

		if (row28cell6 != null) {
			row28cell6
					.setCellValue(brf038.getR29_outward_other() == null ? 0 : brf038.getR29_outward_other().intValue());
		}

		Cell row28cell9 = row28.getCell(9);

		if (row28cell9 != null) {
			row28cell9
					.setCellValue(brf038.getR29_inward_family() == null ? 0 : brf038.getR29_inward_family().intValue());
		}

		Cell row28cell10 = row28.getCell(10);

		if (row28cell10 != null) {
			row28cell10.setCellValue(
					brf038.getR29_inward_investment() == null ? 0 : brf038.getR29_inward_investment().intValue());
		}

		Cell row28cell11 = row28.getCell(11);

		if (row28cell11 != null) {
			row28cell11
					.setCellValue(brf038.getR29_inward_trade() == null ? 0 : brf038.getR29_inward_trade().intValue());
		}

		Cell row28cell12 = row28.getCell(12);

		if (row28cell12 != null) {
			row28cell12
					.setCellValue(brf038.getR29_inward_other() == null ? 0 : brf038.getR29_inward_other().intValue());
		}

		/* EXCEL ROW 29 - ENTITY ROW 30 */
		Row row29 = sheet.getRow(29);

		Cell row29cell3 = row29.getCell(3);

		if (row29cell3 != null) {
			row29cell3.setCellValue(
					brf038.getR30_outward_family() == null ? 0 : brf038.getR30_outward_family().intValue());
		}

		Cell row29cell4 = row29.getCell(4);

		if (row29cell4 != null) {
			row29cell4.setCellValue(
					brf038.getR30_outward_investment() == null ? 0 : brf038.getR30_outward_investment().intValue());
		}

		Cell row29cell5 = row29.getCell(5);

		if (row29cell5 != null) {
			row29cell5
					.setCellValue(brf038.getR30_outward_trade() == null ? 0 : brf038.getR30_outward_trade().intValue());
		}

		Cell row29cell6 = row29.getCell(6);

		if (row29cell6 != null) {
			row29cell6
					.setCellValue(brf038.getR30_outward_other() == null ? 0 : brf038.getR30_outward_other().intValue());
		}

		Cell row29cell9 = row29.getCell(9);

		if (row29cell9 != null) {
			row29cell9
					.setCellValue(brf038.getR30_inward_family() == null ? 0 : brf038.getR30_inward_family().intValue());
		}

		Cell row29cell10 = row29.getCell(10);

		if (row29cell10 != null) {
			row29cell10.setCellValue(
					brf038.getR30_inward_investment() == null ? 0 : brf038.getR30_inward_investment().intValue());
		}

		Cell row29cell11 = row29.getCell(11);

		if (row29cell11 != null) {
			row29cell11
					.setCellValue(brf038.getR30_inward_trade() == null ? 0 : brf038.getR30_inward_trade().intValue());
		}

		Cell row29cell12 = row29.getCell(12);

		if (row29cell12 != null) {
			row29cell12
					.setCellValue(brf038.getR30_inward_other() == null ? 0 : brf038.getR30_inward_other().intValue());
		}

		/* EXCEL ROW 30 - ENTITY ROW 31 */
		Row row30 = sheet.getRow(30);

		Cell row30cell3 = row30.getCell(3);

		if (row30cell3 != null) {
			row30cell3.setCellValue(
					brf038.getR31_outward_family() == null ? 0 : brf038.getR31_outward_family().intValue());
		}

		Cell row30cell4 = row30.getCell(4);

		if (row30cell4 != null) {
			row30cell4.setCellValue(
					brf038.getR31_outward_investment() == null ? 0 : brf038.getR31_outward_investment().intValue());
		}

		Cell row30cell5 = row30.getCell(5);

		if (row30cell5 != null) {
			row30cell5
					.setCellValue(brf038.getR31_outward_trade() == null ? 0 : brf038.getR31_outward_trade().intValue());
		}

		Cell row30cell6 = row30.getCell(6);

		if (row30cell6 != null) {
			row30cell6
					.setCellValue(brf038.getR31_outward_other() == null ? 0 : brf038.getR31_outward_other().intValue());
		}

		Cell row30cell9 = row30.getCell(9);

		if (row30cell9 != null) {
			row30cell9
					.setCellValue(brf038.getR31_inward_family() == null ? 0 : brf038.getR31_inward_family().intValue());
		}

		Cell row30cell10 = row30.getCell(10);

		if (row30cell10 != null) {
			row30cell10.setCellValue(
					brf038.getR31_inward_investment() == null ? 0 : brf038.getR31_inward_investment().intValue());
		}

		Cell row30cell11 = row30.getCell(11);

		if (row30cell11 != null) {
			row30cell11
					.setCellValue(brf038.getR31_inward_trade() == null ? 0 : brf038.getR31_inward_trade().intValue());
		}

		Cell row30cell12 = row30.getCell(12);

		if (row30cell12 != null) {
			row30cell12
					.setCellValue(brf038.getR31_inward_other() == null ? 0 : brf038.getR31_inward_other().intValue());
		}

		/* EXCEL ROW 31 - ENTITY ROW 32 */
		Row row31 = sheet.getRow(31);

		Cell row31cell3 = row31.getCell(3);

		if (row31cell3 != null) {
			row31cell3.setCellValue(
					brf038.getR32_outward_family() == null ? 0 : brf038.getR32_outward_family().intValue());
		}

		Cell row31cell4 = row31.getCell(4);

		if (row31cell4 != null) {
			row31cell4.setCellValue(
					brf038.getR32_outward_investment() == null ? 0 : brf038.getR32_outward_investment().intValue());
		}

		Cell row31cell5 = row31.getCell(5);

		if (row31cell5 != null) {
			row31cell5
					.setCellValue(brf038.getR32_outward_trade() == null ? 0 : brf038.getR32_outward_trade().intValue());
		}

		Cell row31cell6 = row31.getCell(6);

		if (row31cell6 != null) {
			row31cell6
					.setCellValue(brf038.getR32_outward_other() == null ? 0 : brf038.getR32_outward_other().intValue());
		}

		Cell row31cell9 = row31.getCell(9);

		if (row31cell9 != null) {
			row31cell9
					.setCellValue(brf038.getR32_inward_family() == null ? 0 : brf038.getR32_inward_family().intValue());
		}

		Cell row31cell10 = row31.getCell(10);

		if (row31cell10 != null) {
			row31cell10.setCellValue(
					brf038.getR32_inward_investment() == null ? 0 : brf038.getR32_inward_investment().intValue());
		}

		Cell row31cell11 = row31.getCell(11);

		if (row31cell11 != null) {
			row31cell11
					.setCellValue(brf038.getR32_inward_trade() == null ? 0 : brf038.getR32_inward_trade().intValue());
		}

		Cell row31cell12 = row31.getCell(12);

		if (row31cell12 != null) {
			row31cell12
					.setCellValue(brf038.getR32_inward_other() == null ? 0 : brf038.getR32_inward_other().intValue());
		}

		/* EXCEL ROW 32 - ENTITY ROW 33 */
		Row row32 = sheet.getRow(32);

		Cell row32cell3 = row32.getCell(3);

		if (row32cell3 != null) {
			row32cell3.setCellValue(
					brf038.getR33_outward_family() == null ? 0 : brf038.getR33_outward_family().intValue());
		}

		Cell row32cell4 = row32.getCell(4);

		if (row32cell4 != null) {
			row32cell4.setCellValue(
					brf038.getR33_outward_investment() == null ? 0 : brf038.getR33_outward_investment().intValue());
		}

		Cell row32cell5 = row32.getCell(5);

		if (row32cell5 != null) {
			row32cell5
					.setCellValue(brf038.getR33_outward_trade() == null ? 0 : brf038.getR33_outward_trade().intValue());
		}

		Cell row32cell6 = row32.getCell(6);

		if (row32cell6 != null) {
			row32cell6
					.setCellValue(brf038.getR33_outward_other() == null ? 0 : brf038.getR33_outward_other().intValue());
		}

		Cell row32cell9 = row32.getCell(9);

		if (row32cell9 != null) {
			row32cell9
					.setCellValue(brf038.getR33_inward_family() == null ? 0 : brf038.getR33_inward_family().intValue());
		}

		Cell row32cell10 = row32.getCell(10);

		if (row32cell10 != null) {
			row32cell10.setCellValue(
					brf038.getR33_inward_investment() == null ? 0 : brf038.getR33_inward_investment().intValue());
		}

		Cell row32cell11 = row32.getCell(11);

		if (row32cell11 != null) {
			row32cell11
					.setCellValue(brf038.getR33_inward_trade() == null ? 0 : brf038.getR33_inward_trade().intValue());
		}

		Cell row32cell12 = row32.getCell(12);

		if (row32cell12 != null) {
			row32cell12
					.setCellValue(brf038.getR33_inward_other() == null ? 0 : brf038.getR33_inward_other().intValue());
		}

		/* EXCEL ROW 33 - ENTITY ROW 34 */
		Row row33 = sheet.getRow(33);

		Cell row33cell3 = row33.getCell(3);

		if (row33cell3 != null) {
			row33cell3.setCellValue(
					brf038.getR34_outward_family() == null ? 0 : brf038.getR34_outward_family().intValue());
		}

		Cell row33cell4 = row33.getCell(4);

		if (row33cell4 != null) {
			row33cell4.setCellValue(
					brf038.getR34_outward_investment() == null ? 0 : brf038.getR34_outward_investment().intValue());
		}

		Cell row33cell5 = row33.getCell(5);

		if (row33cell5 != null) {
			row33cell5
					.setCellValue(brf038.getR34_outward_trade() == null ? 0 : brf038.getR34_outward_trade().intValue());
		}

		Cell row33cell6 = row33.getCell(6);

		if (row33cell6 != null) {
			row33cell6
					.setCellValue(brf038.getR34_outward_other() == null ? 0 : brf038.getR34_outward_other().intValue());
		}

		Cell row33cell9 = row33.getCell(9);

		if (row33cell9 != null) {
			row33cell9
					.setCellValue(brf038.getR34_inward_family() == null ? 0 : brf038.getR34_inward_family().intValue());
		}

		Cell row33cell10 = row33.getCell(10);

		if (row33cell10 != null) {
			row33cell10.setCellValue(
					brf038.getR34_inward_investment() == null ? 0 : brf038.getR34_inward_investment().intValue());
		}

		Cell row33cell11 = row33.getCell(11);

		if (row33cell11 != null) {
			row33cell11
					.setCellValue(brf038.getR34_inward_trade() == null ? 0 : brf038.getR34_inward_trade().intValue());
		}

		Cell row33cell12 = row33.getCell(12);

		if (row33cell12 != null) {
			row33cell12
					.setCellValue(brf038.getR34_inward_other() == null ? 0 : brf038.getR34_inward_other().intValue());
		}

		/* EXCEL ROW 35 - ENTITY ROW 36 */
		Row row35 = sheet.getRow(35);

		Cell row35cell3 = row35.getCell(3);

		if (row35cell3 != null) {
			row35cell3.setCellValue(
					brf038.getR36_outward_family() == null ? 0 : brf038.getR36_outward_family().intValue());
		}

		Cell row35cell4 = row35.getCell(4);

		if (row35cell4 != null) {
			row35cell4.setCellValue(
					brf038.getR36_outward_investment() == null ? 0 : brf038.getR36_outward_investment().intValue());
		}

		Cell row35cell5 = row35.getCell(5);

		if (row35cell5 != null) {
			row35cell5
					.setCellValue(brf038.getR36_outward_trade() == null ? 0 : brf038.getR36_outward_trade().intValue());
		}

		Cell row35cell6 = row35.getCell(6);

		if (row35cell6 != null) {
			row35cell6
					.setCellValue(brf038.getR36_outward_other() == null ? 0 : brf038.getR36_outward_other().intValue());
		}

		Cell row35cell9 = row35.getCell(9);

		if (row35cell9 != null) {
			row35cell9
					.setCellValue(brf038.getR36_inward_family() == null ? 0 : brf038.getR36_inward_family().intValue());
		}

		Cell row35cell10 = row35.getCell(10);

		if (row35cell10 != null) {
			row35cell10.setCellValue(
					brf038.getR36_inward_investment() == null ? 0 : brf038.getR36_inward_investment().intValue());
		}

		Cell row35cell11 = row35.getCell(11);

		if (row35cell11 != null) {
			row35cell11
					.setCellValue(brf038.getR36_inward_trade() == null ? 0 : brf038.getR36_inward_trade().intValue());
		}

		Cell row35cell12 = row35.getCell(12);

		if (row35cell12 != null) {
			row35cell12
					.setCellValue(brf038.getR36_inward_other() == null ? 0 : brf038.getR36_inward_other().intValue());
		}

		/* EXCEL ROW 36 - ENTITY ROW 37 */
		Row row36 = sheet.getRow(36);

		Cell row36cell3 = row36.getCell(3);

		if (row36cell3 != null) {
			row36cell3.setCellValue(
					brf038.getR37_outward_family() == null ? 0 : brf038.getR37_outward_family().intValue());
		}

		Cell row36cell4 = row36.getCell(4);

		if (row36cell4 != null) {
			row36cell4.setCellValue(
					brf038.getR37_outward_investment() == null ? 0 : brf038.getR37_outward_investment().intValue());
		}

		Cell row36cell5 = row36.getCell(5);

		if (row36cell5 != null) {
			row36cell5
					.setCellValue(brf038.getR37_outward_trade() == null ? 0 : brf038.getR37_outward_trade().intValue());
		}

		Cell row36cell6 = row36.getCell(6);

		if (row36cell6 != null) {
			row36cell6
					.setCellValue(brf038.getR37_outward_other() == null ? 0 : brf038.getR37_outward_other().intValue());
		}

		Cell row36cell9 = row36.getCell(9);

		if (row36cell9 != null) {
			row36cell9
					.setCellValue(brf038.getR37_inward_family() == null ? 0 : brf038.getR37_inward_family().intValue());
		}

		Cell row36cell10 = row36.getCell(10);

		if (row36cell10 != null) {
			row36cell10.setCellValue(
					brf038.getR37_inward_investment() == null ? 0 : brf038.getR37_inward_investment().intValue());
		}

		Cell row36cell11 = row36.getCell(11);

		if (row36cell11 != null) {
			row36cell11
					.setCellValue(brf038.getR37_inward_trade() == null ? 0 : brf038.getR37_inward_trade().intValue());
		}

		Cell row36cell12 = row36.getCell(12);

		if (row36cell12 != null) {
			row36cell12
					.setCellValue(brf038.getR37_inward_other() == null ? 0 : brf038.getR37_inward_other().intValue());
		}

		/* EXCEL ROW 37 - ENTITY ROW 38 */
		Row row37 = sheet.getRow(37);

		Cell row37cell3 = row37.getCell(3);

		if (row37cell3 != null) {
			row37cell3.setCellValue(
					brf038.getR38_outward_family() == null ? 0 : brf038.getR38_outward_family().intValue());
		}

		Cell row37cell4 = row37.getCell(4);

		if (row37cell4 != null) {
			row37cell4.setCellValue(
					brf038.getR38_outward_investment() == null ? 0 : brf038.getR38_outward_investment().intValue());
		}

		Cell row37cell5 = row37.getCell(5);

		if (row37cell5 != null) {
			row37cell5
					.setCellValue(brf038.getR38_outward_trade() == null ? 0 : brf038.getR38_outward_trade().intValue());
		}

		Cell row37cell6 = row37.getCell(6);

		if (row37cell6 != null) {
			row37cell6
					.setCellValue(brf038.getR38_outward_other() == null ? 0 : brf038.getR38_outward_other().intValue());
		}

		Cell row37cell9 = row37.getCell(9);

		if (row37cell9 != null) {
			row37cell9
					.setCellValue(brf038.getR38_inward_family() == null ? 0 : brf038.getR38_inward_family().intValue());
		}

		Cell row37cell10 = row37.getCell(10);

		if (row37cell10 != null) {
			row37cell10.setCellValue(
					brf038.getR38_inward_investment() == null ? 0 : brf038.getR38_inward_investment().intValue());
		}

		Cell row37cell11 = row37.getCell(11);

		if (row37cell11 != null) {
			row37cell11
					.setCellValue(brf038.getR38_inward_trade() == null ? 0 : brf038.getR38_inward_trade().intValue());
		}

		Cell row37cell12 = row37.getCell(12);

		if (row37cell12 != null) {
			row37cell12
					.setCellValue(brf038.getR38_inward_other() == null ? 0 : brf038.getR38_inward_other().intValue());
		}

		/* EXCEL ROW 38 - ENTITY ROW 39 */
		Row row38 = sheet.getRow(38);

		Cell row38cell3 = row38.getCell(3);

		if (row38cell3 != null) {
			row38cell3.setCellValue(
					brf038.getR39_outward_family() == null ? 0 : brf038.getR39_outward_family().intValue());
		}

		Cell row38cell4 = row38.getCell(4);

		if (row38cell4 != null) {
			row38cell4.setCellValue(
					brf038.getR39_outward_investment() == null ? 0 : brf038.getR39_outward_investment().intValue());
		}

		Cell row38cell5 = row38.getCell(5);

		if (row38cell5 != null) {
			row38cell5
					.setCellValue(brf038.getR39_outward_trade() == null ? 0 : brf038.getR39_outward_trade().intValue());
		}

		Cell row38cell6 = row38.getCell(6);

		if (row38cell6 != null) {
			row38cell6
					.setCellValue(brf038.getR39_outward_other() == null ? 0 : brf038.getR39_outward_other().intValue());
		}

		Cell row38cell9 = row38.getCell(9);

		if (row38cell9 != null) {
			row38cell9
					.setCellValue(brf038.getR39_inward_family() == null ? 0 : brf038.getR39_inward_family().intValue());
		}

		Cell row38cell10 = row38.getCell(10);

		if (row38cell10 != null) {
			row38cell10.setCellValue(
					brf038.getR39_inward_investment() == null ? 0 : brf038.getR39_inward_investment().intValue());
		}

		Cell row38cell11 = row38.getCell(11);

		if (row38cell11 != null) {
			row38cell11
					.setCellValue(brf038.getR39_inward_trade() == null ? 0 : brf038.getR39_inward_trade().intValue());
		}

		Cell row38cell12 = row38.getCell(12);

		if (row38cell12 != null) {
			row38cell12
					.setCellValue(brf038.getR39_inward_other() == null ? 0 : brf038.getR39_inward_other().intValue());
		}

		/* EXCEL ROW 39 - ENTITY ROW 40 */
		Row row39 = sheet.getRow(39);

		Cell row39cell3 = row39.getCell(3);

		if (row39cell3 != null) {
			row39cell3.setCellValue(
					brf038.getR40_outward_family() == null ? 0 : brf038.getR40_outward_family().intValue());
		}

		Cell row39cell4 = row39.getCell(4);

		if (row39cell4 != null) {
			row39cell4.setCellValue(
					brf038.getR40_outward_investment() == null ? 0 : brf038.getR40_outward_investment().intValue());
		}

		Cell row39cell5 = row39.getCell(5);

		if (row39cell5 != null) {
			row39cell5
					.setCellValue(brf038.getR40_outward_trade() == null ? 0 : brf038.getR40_outward_trade().intValue());
		}

		Cell row39cell6 = row39.getCell(6);

		if (row39cell6 != null) {
			row39cell6
					.setCellValue(brf038.getR40_outward_other() == null ? 0 : brf038.getR40_outward_other().intValue());
		}

		Cell row39cell9 = row39.getCell(9);

		if (row39cell9 != null) {
			row39cell9
					.setCellValue(brf038.getR40_inward_family() == null ? 0 : brf038.getR40_inward_family().intValue());
		}

		Cell row39cell10 = row39.getCell(10);

		if (row39cell10 != null) {
			row39cell10.setCellValue(
					brf038.getR40_inward_investment() == null ? 0 : brf038.getR40_inward_investment().intValue());
		}

		Cell row39cell11 = row39.getCell(11);

		if (row39cell11 != null) {
			row39cell11
					.setCellValue(brf038.getR40_inward_trade() == null ? 0 : brf038.getR40_inward_trade().intValue());
		}

		Cell row39cell12 = row39.getCell(12);

		if (row39cell12 != null) {
			row39cell12
					.setCellValue(brf038.getR40_inward_other() == null ? 0 : brf038.getR40_inward_other().intValue());
		}

		/* EXCEL ROW 41 - ENTITY ROW 42 */
		Row row41 = sheet.getRow(41);

		Cell row41cell3 = row41.getCell(3);

		if (row41cell3 != null) {
			row41cell3.setCellValue(
					brf038.getR42_outward_family() == null ? 0 : brf038.getR42_outward_family().intValue());
		}

		Cell row41cell4 = row41.getCell(4);

		if (row41cell4 != null) {
			row41cell4.setCellValue(
					brf038.getR42_outward_investment() == null ? 0 : brf038.getR42_outward_investment().intValue());
		}

		Cell row41cell5 = row41.getCell(5);

		if (row41cell5 != null) {
			row41cell5
					.setCellValue(brf038.getR42_outward_trade() == null ? 0 : brf038.getR42_outward_trade().intValue());
		}

		Cell row41cell6 = row41.getCell(6);

		if (row41cell6 != null) {
			row41cell6
					.setCellValue(brf038.getR42_outward_other() == null ? 0 : brf038.getR42_outward_other().intValue());
		}

		Cell row41cell9 = row41.getCell(9);

		if (row41cell9 != null) {
			row41cell9
					.setCellValue(brf038.getR42_inward_family() == null ? 0 : brf038.getR42_inward_family().intValue());
		}

		Cell row41cell10 = row41.getCell(10);

		if (row41cell10 != null) {
			row41cell10.setCellValue(
					brf038.getR42_inward_investment() == null ? 0 : brf038.getR42_inward_investment().intValue());
		}

		Cell row41cell11 = row41.getCell(11);

		if (row41cell11 != null) {
			row41cell11
					.setCellValue(brf038.getR42_inward_trade() == null ? 0 : brf038.getR42_inward_trade().intValue());
		}

		Cell row41cell12 = row41.getCell(12);

		if (row41cell12 != null) {
			row41cell12
					.setCellValue(brf038.getR42_inward_other() == null ? 0 : brf038.getR42_inward_other().intValue());
		}

		/* EXCEL ROW 42 - ENTITY ROW 43 */
		Row row42 = sheet.getRow(42);

		Cell row42cell3 = row42.getCell(3);

		if (row42cell3 != null) {
			row42cell3.setCellValue(
					brf038.getR43_outward_family() == null ? 0 : brf038.getR43_outward_family().intValue());
		}

		Cell row42cell4 = row42.getCell(4);

		if (row42cell4 != null) {
			row42cell4.setCellValue(
					brf038.getR43_outward_investment() == null ? 0 : brf038.getR43_outward_investment().intValue());
		}

		Cell row42cell5 = row42.getCell(5);

		if (row42cell5 != null) {
			row42cell5
					.setCellValue(brf038.getR43_outward_trade() == null ? 0 : brf038.getR43_outward_trade().intValue());
		}

		Cell row42cell6 = row42.getCell(6);

		if (row42cell6 != null) {
			row42cell6
					.setCellValue(brf038.getR43_outward_other() == null ? 0 : brf038.getR43_outward_other().intValue());
		}

		Cell row42cell9 = row42.getCell(9);

		if (row42cell9 != null) {
			row42cell9
					.setCellValue(brf038.getR43_inward_family() == null ? 0 : brf038.getR43_inward_family().intValue());
		}

		Cell row42cell10 = row42.getCell(10);

		if (row42cell10 != null) {
			row42cell10.setCellValue(
					brf038.getR43_inward_investment() == null ? 0 : brf038.getR43_inward_investment().intValue());
		}

		Cell row42cell11 = row42.getCell(11);

		if (row42cell11 != null) {
			row42cell11
					.setCellValue(brf038.getR43_inward_trade() == null ? 0 : brf038.getR43_inward_trade().intValue());
		}

		Cell row42cell12 = row42.getCell(12);

		if (row42cell12 != null) {
			row42cell12
					.setCellValue(brf038.getR43_inward_other() == null ? 0 : brf038.getR43_inward_other().intValue());
		}

		/* EXCEL ROW 43 - ENTITY ROW 44 */
		Row row43 = sheet.getRow(43);

		Cell row43cell3 = row43.getCell(3);

		if (row43cell3 != null) {
			row43cell3.setCellValue(
					brf038.getR44_outward_family() == null ? 0 : brf038.getR44_outward_family().intValue());
		}

		Cell row43cell4 = row43.getCell(4);

		if (row43cell4 != null) {
			row43cell4.setCellValue(
					brf038.getR44_outward_investment() == null ? 0 : brf038.getR44_outward_investment().intValue());
		}

		Cell row43cell5 = row43.getCell(5);

		if (row43cell5 != null) {
			row43cell5
					.setCellValue(brf038.getR44_outward_trade() == null ? 0 : brf038.getR44_outward_trade().intValue());
		}

		Cell row43cell6 = row43.getCell(6);

		if (row43cell6 != null) {
			row43cell6
					.setCellValue(brf038.getR44_outward_other() == null ? 0 : brf038.getR44_outward_other().intValue());
		}

		Cell row43cell9 = row43.getCell(9);

		if (row43cell9 != null) {
			row43cell9
					.setCellValue(brf038.getR44_inward_family() == null ? 0 : brf038.getR44_inward_family().intValue());
		}

		Cell row43cell10 = row43.getCell(10);

		if (row43cell10 != null) {
			row43cell10.setCellValue(
					brf038.getR44_inward_investment() == null ? 0 : brf038.getR44_inward_investment().intValue());
		}

		Cell row43cell11 = row43.getCell(11);

		if (row43cell11 != null) {
			row43cell11
					.setCellValue(brf038.getR44_inward_trade() == null ? 0 : brf038.getR44_inward_trade().intValue());
		}

		Cell row43cell12 = row43.getCell(12);

		if (row43cell12 != null) {
			row43cell12
					.setCellValue(brf038.getR44_inward_other() == null ? 0 : brf038.getR44_inward_other().intValue());
		}

		/* EXCEL ROW 44 - ENTITY ROW 45 */
		Row row44 = sheet.getRow(44);

		Cell row44cell3 = row44.getCell(3);

		if (row44cell3 != null) {
			row44cell3.setCellValue(
					brf038.getR45_outward_family() == null ? 0 : brf038.getR45_outward_family().intValue());
		}

		Cell row44cell4 = row44.getCell(4);

		if (row44cell4 != null) {
			row44cell4.setCellValue(
					brf038.getR45_outward_investment() == null ? 0 : brf038.getR45_outward_investment().intValue());
		}

		Cell row44cell5 = row44.getCell(5);

		if (row44cell5 != null) {
			row44cell5
					.setCellValue(brf038.getR45_outward_trade() == null ? 0 : brf038.getR45_outward_trade().intValue());
		}

		Cell row44cell6 = row44.getCell(6);

		if (row44cell6 != null) {
			row44cell6
					.setCellValue(brf038.getR45_outward_other() == null ? 0 : brf038.getR45_outward_other().intValue());
		}

		Cell row44cell9 = row44.getCell(9);

		if (row44cell9 != null) {
			row44cell9
					.setCellValue(brf038.getR45_inward_family() == null ? 0 : brf038.getR45_inward_family().intValue());
		}

		Cell row44cell10 = row44.getCell(10);

		if (row44cell10 != null) {
			row44cell10.setCellValue(
					brf038.getR45_inward_investment() == null ? 0 : brf038.getR45_inward_investment().intValue());
		}

		Cell row44cell11 = row44.getCell(11);

		if (row44cell11 != null) {
			row44cell11
					.setCellValue(brf038.getR45_inward_trade() == null ? 0 : brf038.getR45_inward_trade().intValue());
		}

		Cell row44cell12 = row44.getCell(12);

		if (row44cell12 != null) {
			row44cell12
					.setCellValue(brf038.getR45_inward_other() == null ? 0 : brf038.getR45_inward_other().intValue());
		}

		/* EXCEL ROW 45 - ENTITY ROW 46 */
		Row row45 = sheet.getRow(45);

		Cell row45cell3 = row45.getCell(3);

		if (row45cell3 != null) {
			row45cell3.setCellValue(
					brf038.getR46_outward_family() == null ? 0 : brf038.getR46_outward_family().intValue());
		}

		Cell row45cell4 = row45.getCell(4);

		if (row45cell4 != null) {
			row45cell4.setCellValue(
					brf038.getR46_outward_investment() == null ? 0 : brf038.getR46_outward_investment().intValue());
		}

		Cell row45cell5 = row45.getCell(5);

		if (row45cell5 != null) {
			row45cell5
					.setCellValue(brf038.getR46_outward_trade() == null ? 0 : brf038.getR46_outward_trade().intValue());
		}

		Cell row45cell6 = row45.getCell(6);

		if (row45cell6 != null) {
			row45cell6
					.setCellValue(brf038.getR46_outward_other() == null ? 0 : brf038.getR46_outward_other().intValue());
		}

		Cell row45cell9 = row45.getCell(9);

		if (row45cell9 != null) {
			row45cell9
					.setCellValue(brf038.getR46_inward_family() == null ? 0 : brf038.getR46_inward_family().intValue());
		}

		Cell row45cell10 = row45.getCell(10);

		if (row45cell10 != null) {
			row45cell10.setCellValue(
					brf038.getR46_inward_investment() == null ? 0 : brf038.getR46_inward_investment().intValue());
		}

		Cell row45cell11 = row45.getCell(11);

		if (row45cell11 != null) {
			row45cell11
					.setCellValue(brf038.getR46_inward_trade() == null ? 0 : brf038.getR46_inward_trade().intValue());
		}

		Cell row45cell12 = row45.getCell(12);

		if (row45cell12 != null) {
			row45cell12
					.setCellValue(brf038.getR46_inward_other() == null ? 0 : brf038.getR46_inward_other().intValue());
		}

		/* EXCEL ROW 46 - ENTITY ROW 47 */
		Row row46 = sheet.getRow(46);

		Cell row46cell3 = row46.getCell(3);

		if (row46cell3 != null) {
			row46cell3.setCellValue(
					brf038.getR47_outward_family() == null ? 0 : brf038.getR47_outward_family().intValue());
		}

		Cell row46cell4 = row46.getCell(4);

		if (row46cell4 != null) {
			row46cell4.setCellValue(
					brf038.getR47_outward_investment() == null ? 0 : brf038.getR47_outward_investment().intValue());
		}

		Cell row46cell5 = row46.getCell(5);

		if (row46cell5 != null) {
			row46cell5
					.setCellValue(brf038.getR47_outward_trade() == null ? 0 : brf038.getR47_outward_trade().intValue());
		}

		Cell row46cell6 = row46.getCell(6);

		if (row46cell6 != null) {
			row46cell6
					.setCellValue(brf038.getR47_outward_other() == null ? 0 : brf038.getR47_outward_other().intValue());
		}

		Cell row46cell9 = row46.getCell(9);

		if (row46cell9 != null) {
			row46cell9
					.setCellValue(brf038.getR47_inward_family() == null ? 0 : brf038.getR47_inward_family().intValue());
		}

		Cell row46cell10 = row46.getCell(10);

		if (row46cell10 != null) {
			row46cell10.setCellValue(
					brf038.getR47_inward_investment() == null ? 0 : brf038.getR47_inward_investment().intValue());
		}

		Cell row46cell11 = row46.getCell(11);

		if (row46cell11 != null) {
			row46cell11
					.setCellValue(brf038.getR47_inward_trade() == null ? 0 : brf038.getR47_inward_trade().intValue());
		}

		Cell row46cell12 = row46.getCell(12);

		if (row46cell12 != null) {
			row46cell12
					.setCellValue(brf038.getR47_inward_other() == null ? 0 : brf038.getR47_inward_other().intValue());
		}

		/* EXCEL ROW 47 - ENTITY ROW 48 */
		Row row47 = sheet.getRow(47);

		Cell row47cell3 = row47.getCell(3);

		if (row47cell3 != null) {
			row47cell3.setCellValue(
					brf038.getR48_outward_family() == null ? 0 : brf038.getR48_outward_family().intValue());
		}

		Cell row47cell4 = row47.getCell(4);

		if (row47cell4 != null) {
			row47cell4.setCellValue(
					brf038.getR48_outward_investment() == null ? 0 : brf038.getR48_outward_investment().intValue());
		}

		Cell row47cell5 = row47.getCell(5);

		if (row47cell5 != null) {
			row47cell5
					.setCellValue(brf038.getR48_outward_trade() == null ? 0 : brf038.getR48_outward_trade().intValue());
		}

		Cell row47cell6 = row47.getCell(6);

		if (row47cell6 != null) {
			row47cell6
					.setCellValue(brf038.getR48_outward_other() == null ? 0 : brf038.getR48_outward_other().intValue());
		}

		Cell row47cell9 = row47.getCell(9);

		if (row47cell9 != null) {
			row47cell9
					.setCellValue(brf038.getR48_inward_family() == null ? 0 : brf038.getR48_inward_family().intValue());
		}

		Cell row47cell10 = row47.getCell(10);

		if (row47cell10 != null) {
			row47cell10.setCellValue(
					brf038.getR48_inward_investment() == null ? 0 : brf038.getR48_inward_investment().intValue());
		}

		Cell row47cell11 = row47.getCell(11);

		if (row47cell11 != null) {
			row47cell11
					.setCellValue(brf038.getR48_inward_trade() == null ? 0 : brf038.getR48_inward_trade().intValue());
		}

		Cell row47cell12 = row47.getCell(12);

		if (row47cell12 != null) {
			row47cell12
					.setCellValue(brf038.getR48_inward_other() == null ? 0 : brf038.getR48_inward_other().intValue());
		}

		/* EXCEL ROW 48 - ENTITY ROW 49 */
		Row row48 = sheet.getRow(48);

		Cell row48cell3 = row48.getCell(3);

		if (row48cell3 != null) {
			row48cell3.setCellValue(
					brf038.getR49_outward_family() == null ? 0 : brf038.getR49_outward_family().intValue());
		}

		Cell row48cell4 = row48.getCell(4);

		if (row48cell4 != null) {
			row48cell4.setCellValue(
					brf038.getR49_outward_investment() == null ? 0 : brf038.getR49_outward_investment().intValue());
		}

		Cell row48cell5 = row48.getCell(5);

		if (row48cell5 != null) {
			row48cell5
					.setCellValue(brf038.getR49_outward_trade() == null ? 0 : brf038.getR49_outward_trade().intValue());
		}

		Cell row48cell6 = row48.getCell(6);

		if (row48cell6 != null) {
			row48cell6
					.setCellValue(brf038.getR49_outward_other() == null ? 0 : brf038.getR49_outward_other().intValue());
		}

		Cell row48cell9 = row48.getCell(9);

		if (row48cell9 != null) {
			row48cell9
					.setCellValue(brf038.getR49_inward_family() == null ? 0 : brf038.getR49_inward_family().intValue());
		}

		Cell row48cell10 = row48.getCell(10);

		if (row48cell10 != null) {
			row48cell10.setCellValue(
					brf038.getR49_inward_investment() == null ? 0 : brf038.getR49_inward_investment().intValue());
		}

		Cell row48cell11 = row48.getCell(11);

		if (row48cell11 != null) {
			row48cell11
					.setCellValue(brf038.getR49_inward_trade() == null ? 0 : brf038.getR49_inward_trade().intValue());
		}

		Cell row48cell12 = row48.getCell(12);

		if (row48cell12 != null) {
			row48cell12
					.setCellValue(brf038.getR49_inward_other() == null ? 0 : brf038.getR49_inward_other().intValue());
		}

		/* EXCEL ROW 49 - ENTITY ROW 50 */
		Row row49 = sheet.getRow(49);

		Cell row49cell3 = row49.getCell(3);

		if (row49cell3 != null) {
			row49cell3.setCellValue(
					brf038.getR50_outward_family() == null ? 0 : brf038.getR50_outward_family().intValue());
		}

		Cell row49cell4 = row49.getCell(4);

		if (row49cell4 != null) {
			row49cell4.setCellValue(
					brf038.getR50_outward_investment() == null ? 0 : brf038.getR50_outward_investment().intValue());
		}

		Cell row49cell5 = row49.getCell(5);

		if (row49cell5 != null) {
			row49cell5
					.setCellValue(brf038.getR50_outward_trade() == null ? 0 : brf038.getR50_outward_trade().intValue());
		}

		Cell row49cell6 = row49.getCell(6);

		if (row49cell6 != null) {
			row49cell6
					.setCellValue(brf038.getR50_outward_other() == null ? 0 : brf038.getR50_outward_other().intValue());
		}

		Cell row49cell9 = row49.getCell(9);

		if (row49cell9 != null) {
			row49cell9
					.setCellValue(brf038.getR50_inward_family() == null ? 0 : brf038.getR50_inward_family().intValue());
		}

		Cell row49cell10 = row49.getCell(10);

		if (row49cell10 != null) {
			row49cell10.setCellValue(
					brf038.getR50_inward_investment() == null ? 0 : brf038.getR50_inward_investment().intValue());
		}

		Cell row49cell11 = row49.getCell(11);

		if (row49cell11 != null) {
			row49cell11
					.setCellValue(brf038.getR50_inward_trade() == null ? 0 : brf038.getR50_inward_trade().intValue());
		}

		Cell row49cell12 = row49.getCell(12);

		if (row49cell12 != null) {
			row49cell12
					.setCellValue(brf038.getR50_inward_other() == null ? 0 : brf038.getR50_inward_other().intValue());
		}

		/* EXCEL ROW 50 - ENTITY ROW 51 */
		Row row50 = sheet.getRow(50);

		Cell row50cell3 = row50.getCell(3);

		if (row50cell3 != null) {
			row50cell3.setCellValue(
					brf038.getR51_outward_family() == null ? 0 : brf038.getR51_outward_family().intValue());
		}

		Cell row50cell4 = row50.getCell(4);

		if (row50cell4 != null) {
			row50cell4.setCellValue(
					brf038.getR51_outward_investment() == null ? 0 : brf038.getR51_outward_investment().intValue());
		}

		Cell row50cell5 = row50.getCell(5);

		if (row50cell5 != null) {
			row50cell5
					.setCellValue(brf038.getR51_outward_trade() == null ? 0 : brf038.getR51_outward_trade().intValue());
		}

		Cell row50cell6 = row50.getCell(6);

		if (row50cell6 != null) {
			row50cell6
					.setCellValue(brf038.getR51_outward_other() == null ? 0 : brf038.getR51_outward_other().intValue());
		}

		Cell row50cell9 = row50.getCell(9);

		if (row50cell9 != null) {
			row50cell9
					.setCellValue(brf038.getR51_inward_family() == null ? 0 : brf038.getR51_inward_family().intValue());
		}

		Cell row50cell10 = row50.getCell(10);

		if (row50cell10 != null) {
			row50cell10.setCellValue(
					brf038.getR51_inward_investment() == null ? 0 : brf038.getR51_inward_investment().intValue());
		}

		Cell row50cell11 = row50.getCell(11);

		if (row50cell11 != null) {
			row50cell11
					.setCellValue(brf038.getR51_inward_trade() == null ? 0 : brf038.getR51_inward_trade().intValue());
		}

		Cell row50cell12 = row50.getCell(12);

		if (row50cell12 != null) {
			row50cell12
					.setCellValue(brf038.getR51_inward_other() == null ? 0 : brf038.getR51_inward_other().intValue());
		}

		/* EXCEL ROW 52 - ENTITY ROW 53 */
		Row row52 = sheet.getRow(52);

		Cell row52cell3 = row52.getCell(3);

		if (row52cell3 != null) {
			row52cell3.setCellValue(
					brf038.getR53_outward_family() == null ? 0 : brf038.getR53_outward_family().intValue());
		}

		Cell row52cell4 = row52.getCell(4);

		if (row52cell4 != null) {
			row52cell4.setCellValue(
					brf038.getR53_outward_investment() == null ? 0 : brf038.getR53_outward_investment().intValue());
		}

		Cell row52cell5 = row52.getCell(5);

		if (row52cell5 != null) {
			row52cell5
					.setCellValue(brf038.getR53_outward_trade() == null ? 0 : brf038.getR53_outward_trade().intValue());
		}

		Cell row52cell6 = row52.getCell(6);

		if (row52cell6 != null) {
			row52cell6
					.setCellValue(brf038.getR53_outward_other() == null ? 0 : brf038.getR53_outward_other().intValue());
		}

		Cell row52cell9 = row52.getCell(9);

		if (row52cell9 != null) {
			row52cell9
					.setCellValue(brf038.getR53_inward_family() == null ? 0 : brf038.getR53_inward_family().intValue());
		}

		Cell row52cell10 = row52.getCell(10);

		if (row52cell10 != null) {
			row52cell10.setCellValue(
					brf038.getR53_inward_investment() == null ? 0 : brf038.getR53_inward_investment().intValue());
		}

		Cell row52cell11 = row52.getCell(11);

		if (row52cell11 != null) {
			row52cell11
					.setCellValue(brf038.getR53_inward_trade() == null ? 0 : brf038.getR53_inward_trade().intValue());
		}

		Cell row52cell12 = row52.getCell(12);

		if (row52cell12 != null) {
			row52cell12
					.setCellValue(brf038.getR53_inward_other() == null ? 0 : brf038.getR53_inward_other().intValue());
		}

		/* EXCEL ROW 53 - ENTITY ROW 54 */
		Row row53 = sheet.getRow(53);

		Cell row53cell3 = row53.getCell(3);

		if (row53cell3 != null) {
			row53cell3.setCellValue(
					brf038.getR54_outward_family() == null ? 0 : brf038.getR54_outward_family().intValue());
		}

		Cell row53cell4 = row53.getCell(4);

		if (row53cell4 != null) {
			row53cell4.setCellValue(
					brf038.getR54_outward_investment() == null ? 0 : brf038.getR54_outward_investment().intValue());
		}

		Cell row53cell5 = row53.getCell(5);

		if (row53cell5 != null) {
			row53cell5
					.setCellValue(brf038.getR54_outward_trade() == null ? 0 : brf038.getR54_outward_trade().intValue());
		}

		Cell row53cell6 = row53.getCell(6);

		if (row53cell6 != null) {
			row53cell6
					.setCellValue(brf038.getR54_outward_other() == null ? 0 : brf038.getR54_outward_other().intValue());
		}

		Cell row53cell9 = row53.getCell(9);

		if (row53cell9 != null) {
			row53cell9
					.setCellValue(brf038.getR54_inward_family() == null ? 0 : brf038.getR54_inward_family().intValue());
		}

		Cell row53cell10 = row53.getCell(10);

		if (row53cell10 != null) {
			row53cell10.setCellValue(
					brf038.getR54_inward_investment() == null ? 0 : brf038.getR54_inward_investment().intValue());
		}

		Cell row53cell11 = row53.getCell(11);

		if (row53cell11 != null) {
			row53cell11
					.setCellValue(brf038.getR54_inward_trade() == null ? 0 : brf038.getR54_inward_trade().intValue());
		}

		Cell row53cell12 = row53.getCell(12);

		if (row53cell12 != null) {
			row53cell12
					.setCellValue(brf038.getR54_inward_other() == null ? 0 : brf038.getR54_inward_other().intValue());
		}

		/* EXCEL ROW 54 - ENTITY ROW 55 */
		Row row54 = sheet.getRow(54);

		Cell row54cell3 = row54.getCell(3);

		if (row54cell3 != null) {
			row54cell3.setCellValue(
					brf038.getR55_outward_family() == null ? 0 : brf038.getR55_outward_family().intValue());
		}

		Cell row54cell4 = row54.getCell(4);

		if (row54cell4 != null) {
			row54cell4.setCellValue(
					brf038.getR55_outward_investment() == null ? 0 : brf038.getR55_outward_investment().intValue());
		}

		Cell row54cell5 = row54.getCell(5);

		if (row54cell5 != null) {
			row54cell5
					.setCellValue(brf038.getR55_outward_trade() == null ? 0 : brf038.getR55_outward_trade().intValue());
		}

		Cell row54cell6 = row54.getCell(6);

		if (row54cell6 != null) {
			row54cell6
					.setCellValue(brf038.getR55_outward_other() == null ? 0 : brf038.getR55_outward_other().intValue());
		}

		Cell row54cell9 = row54.getCell(9);

		if (row54cell9 != null) {
			row54cell9
					.setCellValue(brf038.getR55_inward_family() == null ? 0 : brf038.getR55_inward_family().intValue());
		}

		Cell row54cell10 = row54.getCell(10);

		if (row54cell10 != null) {
			row54cell10.setCellValue(
					brf038.getR55_inward_investment() == null ? 0 : brf038.getR55_inward_investment().intValue());
		}

		Cell row54cell11 = row54.getCell(11);

		if (row54cell11 != null) {
			row54cell11
					.setCellValue(brf038.getR55_inward_trade() == null ? 0 : brf038.getR55_inward_trade().intValue());
		}

		Cell row54cell12 = row54.getCell(12);

		if (row54cell12 != null) {
			row54cell12
					.setCellValue(brf038.getR55_inward_other() == null ? 0 : brf038.getR55_inward_other().intValue());
		}

		/* EXCEL ROW 55 - ENTITY ROW 56 */
		Row row55 = sheet.getRow(55);

		Cell row55cell3 = row55.getCell(3);

		if (row55cell3 != null) {
			row55cell3.setCellValue(
					brf038.getR56_outward_family() == null ? 0 : brf038.getR56_outward_family().intValue());
		}

		Cell row55cell4 = row55.getCell(4);

		if (row55cell4 != null) {
			row55cell4.setCellValue(
					brf038.getR56_outward_investment() == null ? 0 : brf038.getR56_outward_investment().intValue());
		}

		Cell row55cell5 = row55.getCell(5);

		if (row55cell5 != null) {
			row55cell5
					.setCellValue(brf038.getR56_outward_trade() == null ? 0 : brf038.getR56_outward_trade().intValue());
		}

		Cell row55cell6 = row55.getCell(6);

		if (row55cell6 != null) {
			row55cell6
					.setCellValue(brf038.getR56_outward_other() == null ? 0 : brf038.getR56_outward_other().intValue());
		}

		Cell row55cell9 = row55.getCell(9);

		if (row55cell9 != null) {
			row55cell9
					.setCellValue(brf038.getR56_inward_family() == null ? 0 : brf038.getR56_inward_family().intValue());
		}

		Cell row55cell10 = row55.getCell(10);

		if (row55cell10 != null) {
			row55cell10.setCellValue(
					brf038.getR56_inward_investment() == null ? 0 : brf038.getR56_inward_investment().intValue());
		}

		Cell row55cell11 = row55.getCell(11);

		if (row55cell11 != null) {
			row55cell11
					.setCellValue(brf038.getR56_inward_trade() == null ? 0 : brf038.getR56_inward_trade().intValue());
		}

		Cell row55cell12 = row55.getCell(12);

		if (row55cell12 != null) {
			row55cell12
					.setCellValue(brf038.getR56_inward_other() == null ? 0 : brf038.getR56_inward_other().intValue());
		}

		/* EXCEL ROW 56 - ENTITY ROW 57 */
		Row row56 = sheet.getRow(56);

		Cell row56cell3 = row56.getCell(3);

		if (row56cell3 != null) {
			row56cell3.setCellValue(
					brf038.getR57_outward_family() == null ? 0 : brf038.getR57_outward_family().intValue());
		}

		Cell row56cell4 = row56.getCell(4);

		if (row56cell4 != null) {
			row56cell4.setCellValue(
					brf038.getR57_outward_investment() == null ? 0 : brf038.getR57_outward_investment().intValue());
		}

		Cell row56cell5 = row56.getCell(5);

		if (row56cell5 != null) {
			row56cell5
					.setCellValue(brf038.getR57_outward_trade() == null ? 0 : brf038.getR57_outward_trade().intValue());
		}

		Cell row56cell6 = row56.getCell(6);

		if (row56cell6 != null) {
			row56cell6
					.setCellValue(brf038.getR57_outward_other() == null ? 0 : brf038.getR57_outward_other().intValue());
		}

		Cell row56cell9 = row56.getCell(9);

		if (row56cell9 != null) {
			row56cell9
					.setCellValue(brf038.getR57_inward_family() == null ? 0 : brf038.getR57_inward_family().intValue());
		}

		Cell row56cell10 = row56.getCell(10);

		if (row56cell10 != null) {
			row56cell10.setCellValue(
					brf038.getR57_inward_investment() == null ? 0 : brf038.getR57_inward_investment().intValue());
		}

		Cell row56cell11 = row56.getCell(11);

		if (row56cell11 != null) {
			row56cell11
					.setCellValue(brf038.getR57_inward_trade() == null ? 0 : brf038.getR57_inward_trade().intValue());
		}

		Cell row56cell12 = row56.getCell(12);

		if (row56cell12 != null) {
			row56cell12
					.setCellValue(brf038.getR57_inward_other() == null ? 0 : brf038.getR57_inward_other().intValue());
		}

		/* EXCEL ROW 58 - ENTITY ROW 59 */
		Row row58 = sheet.getRow(58);

		Cell row58cell3 = row58.getCell(3);

		if (row58cell3 != null) {
			row58cell3.setCellValue(
					brf038.getR59_outward_family() == null ? 0 : brf038.getR59_outward_family().intValue());
		}

		Cell row58cell4 = row58.getCell(4);

		if (row58cell4 != null) {
			row58cell4.setCellValue(
					brf038.getR59_outward_investment() == null ? 0 : brf038.getR59_outward_investment().intValue());
		}

		Cell row58cell5 = row58.getCell(5);

		if (row58cell5 != null) {
			row58cell5
					.setCellValue(brf038.getR59_outward_trade() == null ? 0 : brf038.getR59_outward_trade().intValue());
		}

		Cell row58cell6 = row58.getCell(6);

		if (row58cell6 != null) {
			row58cell6
					.setCellValue(brf038.getR59_outward_other() == null ? 0 : brf038.getR59_outward_other().intValue());
		}

		Cell row58cell9 = row58.getCell(9);

		if (row58cell9 != null) {
			row58cell9
					.setCellValue(brf038.getR59_inward_family() == null ? 0 : brf038.getR59_inward_family().intValue());
		}

		Cell row58cell10 = row58.getCell(10);

		if (row58cell10 != null) {
			row58cell10.setCellValue(
					brf038.getR59_inward_investment() == null ? 0 : brf038.getR59_inward_investment().intValue());
		}

		Cell row58cell11 = row58.getCell(11);

		if (row58cell11 != null) {
			row58cell11
					.setCellValue(brf038.getR59_inward_trade() == null ? 0 : brf038.getR59_inward_trade().intValue());
		}

		Cell row58cell12 = row58.getCell(12);

		if (row58cell12 != null) {
			row58cell12
					.setCellValue(brf038.getR59_inward_other() == null ? 0 : brf038.getR59_inward_other().intValue());
		}

		/* EXCEL ROW 59 - ENTITY ROW 60 */
		Row row59 = sheet.getRow(59);

		Cell row59cell3 = row59.getCell(3);

		if (row59cell3 != null) {
			row59cell3.setCellValue(
					brf038.getR60_outward_family() == null ? 0 : brf038.getR60_outward_family().intValue());
		}

		Cell row59cell4 = row59.getCell(4);

		if (row59cell4 != null) {
			row59cell4.setCellValue(
					brf038.getR60_outward_investment() == null ? 0 : brf038.getR60_outward_investment().intValue());
		}

		Cell row59cell5 = row59.getCell(5);

		if (row59cell5 != null) {
			row59cell5
					.setCellValue(brf038.getR60_outward_trade() == null ? 0 : brf038.getR60_outward_trade().intValue());
		}

		Cell row59cell6 = row59.getCell(6);

		if (row59cell6 != null) {
			row59cell6
					.setCellValue(brf038.getR60_outward_other() == null ? 0 : brf038.getR60_outward_other().intValue());
		}

		Cell row59cell9 = row59.getCell(9);

		if (row59cell9 != null) {
			row59cell9
					.setCellValue(brf038.getR60_inward_family() == null ? 0 : brf038.getR60_inward_family().intValue());
		}

		Cell row59cell10 = row59.getCell(10);

		if (row59cell10 != null) {
			row59cell10.setCellValue(
					brf038.getR60_inward_investment() == null ? 0 : brf038.getR60_inward_investment().intValue());
		}

		Cell row59cell11 = row59.getCell(11);

		if (row59cell11 != null) {
			row59cell11
					.setCellValue(brf038.getR60_inward_trade() == null ? 0 : brf038.getR60_inward_trade().intValue());
		}

		Cell row59cell12 = row59.getCell(12);

		if (row59cell12 != null) {
			row59cell12
					.setCellValue(brf038.getR60_inward_other() == null ? 0 : brf038.getR60_inward_other().intValue());
		}

		/* EXCEL ROW 60 - ENTITY ROW 61 */
		Row row60 = sheet.getRow(60);

		Cell row60cell3 = row60.getCell(3);

		if (row60cell3 != null) {
			row60cell3.setCellValue(
					brf038.getR61_outward_family() == null ? 0 : brf038.getR61_outward_family().intValue());
		}

		Cell row60cell4 = row60.getCell(4);

		if (row60cell4 != null) {
			row60cell4.setCellValue(
					brf038.getR61_outward_investment() == null ? 0 : brf038.getR61_outward_investment().intValue());
		}

		Cell row60cell5 = row60.getCell(5);

		if (row60cell5 != null) {
			row60cell5
					.setCellValue(brf038.getR61_outward_trade() == null ? 0 : brf038.getR61_outward_trade().intValue());
		}

		Cell row60cell6 = row60.getCell(6);

		if (row60cell6 != null) {
			row60cell6
					.setCellValue(brf038.getR61_outward_other() == null ? 0 : brf038.getR61_outward_other().intValue());
		}

		Cell row60cell9 = row60.getCell(9);

		if (row60cell9 != null) {
			row60cell9
					.setCellValue(brf038.getR61_inward_family() == null ? 0 : brf038.getR61_inward_family().intValue());
		}

		Cell row60cell10 = row60.getCell(10);

		if (row60cell10 != null) {
			row60cell10.setCellValue(
					brf038.getR61_inward_investment() == null ? 0 : brf038.getR61_inward_investment().intValue());
		}

		Cell row60cell11 = row60.getCell(11);

		if (row60cell11 != null) {
			row60cell11
					.setCellValue(brf038.getR61_inward_trade() == null ? 0 : brf038.getR61_inward_trade().intValue());
		}

		Cell row60cell12 = row60.getCell(12);

		if (row60cell12 != null) {
			row60cell12
					.setCellValue(brf038.getR61_inward_other() == null ? 0 : brf038.getR61_inward_other().intValue());
		}

		/* EXCEL ROW 61 - ENTITY ROW 62 */
		Row row61 = sheet.getRow(61);

		Cell row61cell3 = row61.getCell(3);

		if (row61cell3 != null) {
			row61cell3.setCellValue(
					brf038.getR62_outward_family() == null ? 0 : brf038.getR62_outward_family().intValue());
		}

		Cell row61cell4 = row61.getCell(4);

		if (row61cell4 != null) {
			row61cell4.setCellValue(
					brf038.getR62_outward_investment() == null ? 0 : brf038.getR62_outward_investment().intValue());
		}

		Cell row61cell5 = row61.getCell(5);

		if (row61cell5 != null) {
			row61cell5
					.setCellValue(brf038.getR62_outward_trade() == null ? 0 : brf038.getR62_outward_trade().intValue());
		}

		Cell row61cell6 = row61.getCell(6);

		if (row61cell6 != null) {
			row61cell6
					.setCellValue(brf038.getR62_outward_other() == null ? 0 : brf038.getR62_outward_other().intValue());
		}

		Cell row61cell9 = row61.getCell(9);

		if (row61cell9 != null) {
			row61cell9
					.setCellValue(brf038.getR62_inward_family() == null ? 0 : brf038.getR62_inward_family().intValue());
		}

		Cell row61cell10 = row61.getCell(10);

		if (row61cell10 != null) {
			row61cell10.setCellValue(
					brf038.getR62_inward_investment() == null ? 0 : brf038.getR62_inward_investment().intValue());
		}

		Cell row61cell11 = row61.getCell(11);

		if (row61cell11 != null) {
			row61cell11
					.setCellValue(brf038.getR62_inward_trade() == null ? 0 : brf038.getR62_inward_trade().intValue());
		}

		Cell row61cell12 = row61.getCell(12);

		if (row61cell12 != null) {
			row61cell12
					.setCellValue(brf038.getR62_inward_other() == null ? 0 : brf038.getR62_inward_other().intValue());
		}

		/* EXCEL ROW 62 - ENTITY ROW 63 */
		Row row62 = sheet.getRow(62);

		Cell row62cell3 = row62.getCell(3);

		if (row62cell3 != null) {
			row62cell3.setCellValue(
					brf038.getR63_outward_family() == null ? 0 : brf038.getR63_outward_family().intValue());
		}

		Cell row62cell4 = row62.getCell(4);

		if (row62cell4 != null) {
			row62cell4.setCellValue(
					brf038.getR63_outward_investment() == null ? 0 : brf038.getR63_outward_investment().intValue());
		}

		Cell row62cell5 = row62.getCell(5);

		if (row62cell5 != null) {
			row62cell5
					.setCellValue(brf038.getR63_outward_trade() == null ? 0 : brf038.getR63_outward_trade().intValue());
		}

		Cell row62cell6 = row62.getCell(6);

		if (row62cell6 != null) {
			row62cell6
					.setCellValue(brf038.getR63_outward_other() == null ? 0 : brf038.getR63_outward_other().intValue());
		}

		Cell row62cell9 = row62.getCell(9);

		if (row62cell9 != null) {
			row62cell9
					.setCellValue(brf038.getR63_inward_family() == null ? 0 : brf038.getR63_inward_family().intValue());
		}

		Cell row62cell10 = row62.getCell(10);

		if (row62cell10 != null) {
			row62cell10.setCellValue(
					brf038.getR63_inward_investment() == null ? 0 : brf038.getR63_inward_investment().intValue());
		}

		Cell row62cell11 = row62.getCell(11);

		if (row62cell11 != null) {
			row62cell11
					.setCellValue(brf038.getR63_inward_trade() == null ? 0 : brf038.getR63_inward_trade().intValue());
		}

		Cell row62cell12 = row62.getCell(12);

		if (row62cell12 != null) {
			row62cell12
					.setCellValue(brf038.getR63_inward_other() == null ? 0 : brf038.getR63_inward_other().intValue());
		}

		/* EXCEL ROW 63 - ENTITY ROW 64 */
		Row row63 = sheet.getRow(63);

		Cell row63cell3 = row63.getCell(3);

		if (row63cell3 != null) {
			row63cell3.setCellValue(
					brf038.getR64_outward_family() == null ? 0 : brf038.getR64_outward_family().intValue());
		}

		Cell row63cell4 = row63.getCell(4);

		if (row63cell4 != null) {
			row63cell4.setCellValue(
					brf038.getR64_outward_investment() == null ? 0 : brf038.getR64_outward_investment().intValue());
		}

		Cell row63cell5 = row63.getCell(5);

		if (row63cell5 != null) {
			row63cell5
					.setCellValue(brf038.getR64_outward_trade() == null ? 0 : brf038.getR64_outward_trade().intValue());
		}

		Cell row63cell6 = row63.getCell(6);

		if (row63cell6 != null) {
			row63cell6
					.setCellValue(brf038.getR64_outward_other() == null ? 0 : brf038.getR64_outward_other().intValue());
		}

		Cell row63cell9 = row63.getCell(9);

		if (row63cell9 != null) {
			row63cell9
					.setCellValue(brf038.getR64_inward_family() == null ? 0 : brf038.getR64_inward_family().intValue());
		}

		Cell row63cell10 = row63.getCell(10);

		if (row63cell10 != null) {
			row63cell10.setCellValue(
					brf038.getR64_inward_investment() == null ? 0 : brf038.getR64_inward_investment().intValue());
		}

		Cell row63cell11 = row63.getCell(11);

		if (row63cell11 != null) {
			row63cell11
					.setCellValue(brf038.getR64_inward_trade() == null ? 0 : brf038.getR64_inward_trade().intValue());
		}

		Cell row63cell12 = row63.getCell(12);

		if (row63cell12 != null) {
			row63cell12
					.setCellValue(brf038.getR64_inward_other() == null ? 0 : brf038.getR64_inward_other().intValue());
		}

		/* EXCEL ROW 64 - ENTITY ROW 65 */
		Row row64 = sheet.getRow(64);

		Cell row64cell3 = row64.getCell(3);

		if (row64cell3 != null) {
			row64cell3.setCellValue(
					brf038.getR65_outward_family() == null ? 0 : brf038.getR65_outward_family().intValue());
		}

		Cell row64cell4 = row64.getCell(4);

		if (row64cell4 != null) {
			row64cell4.setCellValue(
					brf038.getR65_outward_investment() == null ? 0 : brf038.getR65_outward_investment().intValue());
		}

		Cell row64cell5 = row64.getCell(5);

		if (row64cell5 != null) {
			row64cell5
					.setCellValue(brf038.getR65_outward_trade() == null ? 0 : brf038.getR65_outward_trade().intValue());
		}

		Cell row64cell6 = row64.getCell(6);

		if (row64cell6 != null) {
			row64cell6
					.setCellValue(brf038.getR65_outward_other() == null ? 0 : brf038.getR65_outward_other().intValue());
		}

		Cell row64cell9 = row64.getCell(9);

		if (row64cell9 != null) {
			row64cell9
					.setCellValue(brf038.getR65_inward_family() == null ? 0 : brf038.getR65_inward_family().intValue());
		}

		Cell row64cell10 = row64.getCell(10);

		if (row64cell10 != null) {
			row64cell10.setCellValue(
					brf038.getR65_inward_investment() == null ? 0 : brf038.getR65_inward_investment().intValue());
		}

		Cell row64cell11 = row64.getCell(11);

		if (row64cell11 != null) {
			row64cell11
					.setCellValue(brf038.getR65_inward_trade() == null ? 0 : brf038.getR65_inward_trade().intValue());
		}

		Cell row64cell12 = row64.getCell(12);

		if (row64cell12 != null) {
			row64cell12
					.setCellValue(brf038.getR65_inward_other() == null ? 0 : brf038.getR65_inward_other().intValue());
		}

		/* EXCEL ROW 65 - ENTITY ROW 66 */
		Row row65 = sheet.getRow(65);

		Cell row65cell3 = row65.getCell(3);

		if (row65cell3 != null) {
			row65cell3.setCellValue(
					brf038.getR66_outward_family() == null ? 0 : brf038.getR66_outward_family().intValue());
		}

		Cell row65cell4 = row65.getCell(4);

		if (row65cell4 != null) {
			row65cell4.setCellValue(
					brf038.getR66_outward_investment() == null ? 0 : brf038.getR66_outward_investment().intValue());
		}

		Cell row65cell5 = row65.getCell(5);

		if (row65cell5 != null) {
			row65cell5
					.setCellValue(brf038.getR66_outward_trade() == null ? 0 : brf038.getR66_outward_trade().intValue());
		}

		Cell row65cell6 = row65.getCell(6);

		if (row65cell6 != null) {
			row65cell6
					.setCellValue(brf038.getR66_outward_other() == null ? 0 : brf038.getR66_outward_other().intValue());
		}

		Cell row65cell9 = row65.getCell(9);

		if (row65cell9 != null) {
			row65cell9
					.setCellValue(brf038.getR66_inward_family() == null ? 0 : brf038.getR66_inward_family().intValue());
		}

		Cell row65cell10 = row65.getCell(10);

		if (row65cell10 != null) {
			row65cell10.setCellValue(
					brf038.getR66_inward_investment() == null ? 0 : brf038.getR66_inward_investment().intValue());
		}

		Cell row65cell11 = row65.getCell(11);

		if (row65cell11 != null) {
			row65cell11
					.setCellValue(brf038.getR66_inward_trade() == null ? 0 : brf038.getR66_inward_trade().intValue());
		}

		Cell row65cell12 = row65.getCell(12);

		if (row65cell12 != null) {
			row65cell12
					.setCellValue(brf038.getR66_inward_other() == null ? 0 : brf038.getR66_inward_other().intValue());
		}

		/* EXCEL ROW 66 - ENTITY ROW 67 */
		Row row66 = sheet.getRow(66);

		Cell row66cell3 = row66.getCell(3);

		if (row66cell3 != null) {
			row66cell3.setCellValue(
					brf038.getR67_outward_family() == null ? 0 : brf038.getR67_outward_family().intValue());
		}

		Cell row66cell4 = row66.getCell(4);

		if (row66cell4 != null) {
			row66cell4.setCellValue(
					brf038.getR67_outward_investment() == null ? 0 : brf038.getR67_outward_investment().intValue());
		}

		Cell row66cell5 = row66.getCell(5);

		if (row66cell5 != null) {
			row66cell5
					.setCellValue(brf038.getR67_outward_trade() == null ? 0 : brf038.getR67_outward_trade().intValue());
		}

		Cell row66cell6 = row66.getCell(6);

		if (row66cell6 != null) {
			row66cell6
					.setCellValue(brf038.getR67_outward_other() == null ? 0 : brf038.getR67_outward_other().intValue());
		}

		Cell row66cell9 = row66.getCell(9);

		if (row66cell9 != null) {
			row66cell9
					.setCellValue(brf038.getR67_inward_family() == null ? 0 : brf038.getR67_inward_family().intValue());
		}

		Cell row66cell10 = row66.getCell(10);

		if (row66cell10 != null) {
			row66cell10.setCellValue(
					brf038.getR67_inward_investment() == null ? 0 : brf038.getR67_inward_investment().intValue());
		}

		Cell row66cell11 = row66.getCell(11);

		if (row66cell11 != null) {
			row66cell11
					.setCellValue(brf038.getR67_inward_trade() == null ? 0 : brf038.getR67_inward_trade().intValue());
		}

		Cell row66cell12 = row66.getCell(12);

		if (row66cell12 != null) {
			row66cell12
					.setCellValue(brf038.getR67_inward_other() == null ? 0 : brf038.getR67_inward_other().intValue());
		}

		/* EXCEL ROW 67 - ENTITY ROW 68 */
		Row row67 = sheet.getRow(67);

		Cell row67cell3 = row67.getCell(3);

		if (row67cell3 != null) {
			row67cell3.setCellValue(
					brf038.getR68_outward_family() == null ? 0 : brf038.getR68_outward_family().intValue());
		}

		Cell row67cell4 = row67.getCell(4);

		if (row67cell4 != null) {
			row67cell4.setCellValue(
					brf038.getR68_outward_investment() == null ? 0 : brf038.getR68_outward_investment().intValue());
		}

		Cell row67cell5 = row67.getCell(5);

		if (row67cell5 != null) {
			row67cell5
					.setCellValue(brf038.getR68_outward_trade() == null ? 0 : brf038.getR68_outward_trade().intValue());
		}

		Cell row67cell6 = row67.getCell(6);

		if (row67cell6 != null) {
			row67cell6
					.setCellValue(brf038.getR68_outward_other() == null ? 0 : brf038.getR68_outward_other().intValue());
		}

		Cell row67cell9 = row67.getCell(9);

		if (row67cell9 != null) {
			row67cell9
					.setCellValue(brf038.getR68_inward_family() == null ? 0 : brf038.getR68_inward_family().intValue());
		}

		Cell row67cell10 = row67.getCell(10);

		if (row67cell10 != null) {
			row67cell10.setCellValue(
					brf038.getR68_inward_investment() == null ? 0 : brf038.getR68_inward_investment().intValue());
		}

		Cell row67cell11 = row67.getCell(11);

		if (row67cell11 != null) {
			row67cell11
					.setCellValue(brf038.getR68_inward_trade() == null ? 0 : brf038.getR68_inward_trade().intValue());
		}

		Cell row67cell12 = row67.getCell(12);

		if (row67cell12 != null) {
			row67cell12
					.setCellValue(brf038.getR68_inward_other() == null ? 0 : brf038.getR68_inward_other().intValue());
		}

		/* EXCEL ROW 68 - ENTITY ROW 69 */
		Row row68 = sheet.getRow(68);

		Cell row68cell3 = row68.getCell(3);

		if (row68cell3 != null) {
			row68cell3.setCellValue(
					brf038.getR69_outward_family() == null ? 0 : brf038.getR69_outward_family().intValue());
		}

		Cell row68cell4 = row68.getCell(4);

		if (row68cell4 != null) {
			row68cell4.setCellValue(
					brf038.getR69_outward_investment() == null ? 0 : brf038.getR69_outward_investment().intValue());
		}

		Cell row68cell5 = row68.getCell(5);

		if (row68cell5 != null) {
			row68cell5
					.setCellValue(brf038.getR69_outward_trade() == null ? 0 : brf038.getR69_outward_trade().intValue());
		}

		Cell row68cell6 = row68.getCell(6);

		if (row68cell6 != null) {
			row68cell6
					.setCellValue(brf038.getR69_outward_other() == null ? 0 : brf038.getR69_outward_other().intValue());
		}

		Cell row68cell9 = row68.getCell(9);

		if (row68cell9 != null) {
			row68cell9
					.setCellValue(brf038.getR69_inward_family() == null ? 0 : brf038.getR69_inward_family().intValue());
		}

		Cell row68cell10 = row68.getCell(10);

		if (row68cell10 != null) {
			row68cell10.setCellValue(
					brf038.getR69_inward_investment() == null ? 0 : brf038.getR69_inward_investment().intValue());
		}

		Cell row68cell11 = row68.getCell(11);

		if (row68cell11 != null) {
			row68cell11
					.setCellValue(brf038.getR69_inward_trade() == null ? 0 : brf038.getR69_inward_trade().intValue());
		}

		Cell row68cell12 = row68.getCell(12);

		if (row68cell12 != null) {
			row68cell12
					.setCellValue(brf038.getR69_inward_other() == null ? 0 : brf038.getR69_inward_other().intValue());
		}

		/* EXCEL ROW 69 - ENTITY ROW 70 */
		Row row69 = sheet.getRow(69);

		Cell row69cell3 = row69.getCell(3);

		if (row69cell3 != null) {
			row69cell3.setCellValue(
					brf038.getR70_outward_family() == null ? 0 : brf038.getR70_outward_family().intValue());
		}

		Cell row69cell4 = row69.getCell(4);

		if (row69cell4 != null) {
			row69cell4.setCellValue(
					brf038.getR70_outward_investment() == null ? 0 : brf038.getR70_outward_investment().intValue());
		}

		Cell row69cell5 = row69.getCell(5);

		if (row69cell5 != null) {
			row69cell5
					.setCellValue(brf038.getR70_outward_trade() == null ? 0 : brf038.getR70_outward_trade().intValue());
		}

		Cell row69cell6 = row69.getCell(6);

		if (row69cell6 != null) {
			row69cell6
					.setCellValue(brf038.getR70_outward_other() == null ? 0 : brf038.getR70_outward_other().intValue());
		}

		Cell row69cell9 = row69.getCell(9);

		if (row69cell9 != null) {
			row69cell9
					.setCellValue(brf038.getR70_inward_family() == null ? 0 : brf038.getR70_inward_family().intValue());
		}

		Cell row69cell10 = row69.getCell(10);

		if (row69cell10 != null) {
			row69cell10.setCellValue(
					brf038.getR70_inward_investment() == null ? 0 : brf038.getR70_inward_investment().intValue());
		}

		Cell row69cell11 = row69.getCell(11);

		if (row69cell11 != null) {
			row69cell11
					.setCellValue(brf038.getR70_inward_trade() == null ? 0 : brf038.getR70_inward_trade().intValue());
		}

		Cell row69cell12 = row69.getCell(12);

		if (row69cell12 != null) {
			row69cell12
					.setCellValue(brf038.getR70_inward_other() == null ? 0 : brf038.getR70_inward_other().intValue());
		}

		/* EXCEL ROW 70 - ENTITY ROW 71 */
		Row row70 = sheet.getRow(70);

		Cell row70cell3 = row70.getCell(3);

		if (row70cell3 != null) {
			row70cell3.setCellValue(
					brf038.getR71_outward_family() == null ? 0 : brf038.getR71_outward_family().intValue());
		}

		Cell row70cell4 = row70.getCell(4);

		if (row70cell4 != null) {
			row70cell4.setCellValue(
					brf038.getR71_outward_investment() == null ? 0 : brf038.getR71_outward_investment().intValue());
		}

		Cell row70cell5 = row70.getCell(5);

		if (row70cell5 != null) {
			row70cell5
					.setCellValue(brf038.getR71_outward_trade() == null ? 0 : brf038.getR71_outward_trade().intValue());
		}

		Cell row70cell6 = row70.getCell(6);

		if (row70cell6 != null) {
			row70cell6
					.setCellValue(brf038.getR71_outward_other() == null ? 0 : brf038.getR71_outward_other().intValue());
		}

		Cell row70cell9 = row70.getCell(9);

		if (row70cell9 != null) {
			row70cell9
					.setCellValue(brf038.getR71_inward_family() == null ? 0 : brf038.getR71_inward_family().intValue());
		}

		Cell row70cell10 = row70.getCell(10);

		if (row70cell10 != null) {
			row70cell10.setCellValue(
					brf038.getR71_inward_investment() == null ? 0 : brf038.getR71_inward_investment().intValue());
		}

		Cell row70cell11 = row70.getCell(11);

		if (row70cell11 != null) {
			row70cell11
					.setCellValue(brf038.getR71_inward_trade() == null ? 0 : brf038.getR71_inward_trade().intValue());
		}

		Cell row70cell12 = row70.getCell(12);

		if (row70cell12 != null) {
			row70cell12
					.setCellValue(brf038.getR71_inward_other() == null ? 0 : brf038.getR71_inward_other().intValue());
		}

		/* EXCEL ROW 71 - ENTITY ROW 72 */
		Row row71 = sheet.getRow(71);

		Cell row71cell3 = row71.getCell(3);

		if (row71cell3 != null) {
			row71cell3.setCellValue(
					brf038.getR72_outward_family() == null ? 0 : brf038.getR72_outward_family().intValue());
		}

		Cell row71cell4 = row71.getCell(4);

		if (row71cell4 != null) {
			row71cell4.setCellValue(
					brf038.getR72_outward_investment() == null ? 0 : brf038.getR72_outward_investment().intValue());
		}

		Cell row71cell5 = row71.getCell(5);

		if (row71cell5 != null) {
			row71cell5
					.setCellValue(brf038.getR72_outward_trade() == null ? 0 : brf038.getR72_outward_trade().intValue());
		}

		Cell row71cell6 = row71.getCell(6);

		if (row71cell6 != null) {
			row71cell6
					.setCellValue(brf038.getR72_outward_other() == null ? 0 : brf038.getR72_outward_other().intValue());
		}

		Cell row71cell9 = row71.getCell(9);

		if (row71cell9 != null) {
			row71cell9
					.setCellValue(brf038.getR72_inward_family() == null ? 0 : brf038.getR72_inward_family().intValue());
		}

		Cell row71cell10 = row71.getCell(10);

		if (row71cell10 != null) {
			row71cell10.setCellValue(
					brf038.getR72_inward_investment() == null ? 0 : brf038.getR72_inward_investment().intValue());
		}

		Cell row71cell11 = row71.getCell(11);

		if (row71cell11 != null) {
			row71cell11
					.setCellValue(brf038.getR72_inward_trade() == null ? 0 : brf038.getR72_inward_trade().intValue());
		}

		Cell row71cell12 = row71.getCell(12);

		if (row71cell12 != null) {
			row71cell12
					.setCellValue(brf038.getR72_inward_other() == null ? 0 : brf038.getR72_inward_other().intValue());
		}

		/* EXCEL ROW 72 - ENTITY ROW 73 */
		Row row72 = sheet.getRow(72);

		Cell row72cell3 = row72.getCell(3);

		if (row72cell3 != null) {
			row72cell3.setCellValue(
					brf038.getR73_outward_family() == null ? 0 : brf038.getR73_outward_family().intValue());
		}

		Cell row72cell4 = row72.getCell(4);

		if (row72cell4 != null) {
			row72cell4.setCellValue(
					brf038.getR73_outward_investment() == null ? 0 : brf038.getR73_outward_investment().intValue());
		}

		Cell row72cell5 = row72.getCell(5);

		if (row72cell5 != null) {
			row72cell5
					.setCellValue(brf038.getR73_outward_trade() == null ? 0 : brf038.getR73_outward_trade().intValue());
		}

		Cell row72cell6 = row72.getCell(6);

		if (row72cell6 != null) {
			row72cell6
					.setCellValue(brf038.getR73_outward_other() == null ? 0 : brf038.getR73_outward_other().intValue());
		}

		Cell row72cell9 = row72.getCell(9);

		if (row72cell9 != null) {
			row72cell9
					.setCellValue(brf038.getR73_inward_family() == null ? 0 : brf038.getR73_inward_family().intValue());
		}

		Cell row72cell10 = row72.getCell(10);

		if (row72cell10 != null) {
			row72cell10.setCellValue(
					brf038.getR73_inward_investment() == null ? 0 : brf038.getR73_inward_investment().intValue());
		}

		Cell row72cell11 = row72.getCell(11);

		if (row72cell11 != null) {
			row72cell11
					.setCellValue(brf038.getR73_inward_trade() == null ? 0 : brf038.getR73_inward_trade().intValue());
		}

		Cell row72cell12 = row72.getCell(12);

		if (row72cell12 != null) {
			row72cell12
					.setCellValue(brf038.getR73_inward_other() == null ? 0 : brf038.getR73_inward_other().intValue());
		}

		/* EXCEL ROW 73 - ENTITY ROW 74 */
		Row row73 = sheet.getRow(73);

		Cell row73cell3 = row73.getCell(3);

		if (row73cell3 != null) {
			row73cell3.setCellValue(
					brf038.getR74_outward_family() == null ? 0 : brf038.getR74_outward_family().intValue());
		}

		Cell row73cell4 = row73.getCell(4);

		if (row73cell4 != null) {
			row73cell4.setCellValue(
					brf038.getR74_outward_investment() == null ? 0 : brf038.getR74_outward_investment().intValue());
		}

		Cell row73cell5 = row73.getCell(5);

		if (row73cell5 != null) {
			row73cell5
					.setCellValue(brf038.getR74_outward_trade() == null ? 0 : brf038.getR74_outward_trade().intValue());
		}

		Cell row73cell6 = row73.getCell(6);

		if (row73cell6 != null) {
			row73cell6
					.setCellValue(brf038.getR74_outward_other() == null ? 0 : brf038.getR74_outward_other().intValue());
		}

		Cell row73cell9 = row73.getCell(9);

		if (row73cell9 != null) {
			row73cell9
					.setCellValue(brf038.getR74_inward_family() == null ? 0 : brf038.getR74_inward_family().intValue());
		}

		Cell row73cell10 = row73.getCell(10);

		if (row73cell10 != null) {
			row73cell10.setCellValue(
					brf038.getR74_inward_investment() == null ? 0 : brf038.getR74_inward_investment().intValue());
		}

		Cell row73cell11 = row73.getCell(11);

		if (row73cell11 != null) {
			row73cell11
					.setCellValue(brf038.getR74_inward_trade() == null ? 0 : brf038.getR74_inward_trade().intValue());
		}

		Cell row73cell12 = row73.getCell(12);

		if (row73cell12 != null) {
			row73cell12
					.setCellValue(brf038.getR74_inward_other() == null ? 0 : brf038.getR74_inward_other().intValue());
		}

		/* EXCEL ROW 74 - ENTITY ROW 75 */
		Row row74 = sheet.getRow(74);

		Cell row74cell3 = row74.getCell(3);

		if (row74cell3 != null) {
			row74cell3.setCellValue(
					brf038.getR75_outward_family() == null ? 0 : brf038.getR75_outward_family().intValue());
		}

		Cell row74cell4 = row74.getCell(4);

		if (row74cell4 != null) {
			row74cell4.setCellValue(
					brf038.getR75_outward_investment() == null ? 0 : brf038.getR75_outward_investment().intValue());
		}

		Cell row74cell5 = row74.getCell(5);

		if (row74cell5 != null) {
			row74cell5
					.setCellValue(brf038.getR75_outward_trade() == null ? 0 : brf038.getR75_outward_trade().intValue());
		}

		Cell row74cell6 = row74.getCell(6);

		if (row74cell6 != null) {
			row74cell6
					.setCellValue(brf038.getR75_outward_other() == null ? 0 : brf038.getR75_outward_other().intValue());
		}

		Cell row74cell9 = row74.getCell(9);

		if (row74cell9 != null) {
			row74cell9
					.setCellValue(brf038.getR75_inward_family() == null ? 0 : brf038.getR75_inward_family().intValue());
		}

		Cell row74cell10 = row74.getCell(10);

		if (row74cell10 != null) {
			row74cell10.setCellValue(
					brf038.getR75_inward_investment() == null ? 0 : brf038.getR75_inward_investment().intValue());
		}

		Cell row74cell11 = row74.getCell(11);

		if (row74cell11 != null) {
			row74cell11
					.setCellValue(brf038.getR75_inward_trade() == null ? 0 : brf038.getR75_inward_trade().intValue());
		}

		Cell row74cell12 = row74.getCell(12);

		if (row74cell12 != null) {
			row74cell12
					.setCellValue(brf038.getR75_inward_other() == null ? 0 : brf038.getR75_inward_other().intValue());
		}

		/* EXCEL ROW 75 - ENTITY ROW 76 */
		Row row75 = sheet.getRow(75);

		Cell row75cell3 = row75.getCell(3);

		if (row75cell3 != null) {
			row75cell3.setCellValue(
					brf038.getR76_outward_family() == null ? 0 : brf038.getR76_outward_family().intValue());
		}

		Cell row75cell4 = row75.getCell(4);

		if (row75cell4 != null) {
			row75cell4.setCellValue(
					brf038.getR76_outward_investment() == null ? 0 : brf038.getR76_outward_investment().intValue());
		}

		Cell row75cell5 = row75.getCell(5);

		if (row75cell5 != null) {
			row75cell5
					.setCellValue(brf038.getR76_outward_trade() == null ? 0 : brf038.getR76_outward_trade().intValue());
		}

		Cell row75cell6 = row75.getCell(6);

		if (row75cell6 != null) {
			row75cell6
					.setCellValue(brf038.getR76_outward_other() == null ? 0 : brf038.getR76_outward_other().intValue());
		}

		Cell row75cell9 = row75.getCell(9);

		if (row75cell9 != null) {
			row75cell9
					.setCellValue(brf038.getR76_inward_family() == null ? 0 : brf038.getR76_inward_family().intValue());
		}

		Cell row75cell10 = row75.getCell(10);

		if (row75cell10 != null) {
			row75cell10.setCellValue(
					brf038.getR76_inward_investment() == null ? 0 : brf038.getR76_inward_investment().intValue());
		}

		Cell row75cell11 = row75.getCell(11);

		if (row75cell11 != null) {
			row75cell11
					.setCellValue(brf038.getR76_inward_trade() == null ? 0 : brf038.getR76_inward_trade().intValue());
		}

		Cell row75cell12 = row75.getCell(12);

		if (row75cell12 != null) {
			row75cell12
					.setCellValue(brf038.getR76_inward_other() == null ? 0 : brf038.getR76_inward_other().intValue());
		}

		/* EXCEL ROW 77 - ENTITY ROW 78 */
		Row row77 = sheet.getRow(77);

		Cell row77cell3 = row77.getCell(3);

		if (row77cell3 != null) {
			row77cell3.setCellValue(
					brf038.getR78_outward_family() == null ? 0 : brf038.getR78_outward_family().intValue());
		}

		Cell row77cell4 = row77.getCell(4);

		if (row77cell4 != null) {
			row77cell4.setCellValue(
					brf038.getR78_outward_investment() == null ? 0 : brf038.getR78_outward_investment().intValue());
		}

		Cell row77cell5 = row77.getCell(5);

		if (row77cell5 != null) {
			row77cell5
					.setCellValue(brf038.getR78_outward_trade() == null ? 0 : brf038.getR78_outward_trade().intValue());
		}

		Cell row77cell6 = row77.getCell(6);

		if (row77cell6 != null) {
			row77cell6
					.setCellValue(brf038.getR78_outward_other() == null ? 0 : brf038.getR78_outward_other().intValue());
		}

		Cell row77cell9 = row77.getCell(9);

		if (row77cell9 != null) {
			row77cell9
					.setCellValue(brf038.getR78_inward_family() == null ? 0 : brf038.getR78_inward_family().intValue());
		}

		Cell row77cell10 = row77.getCell(10);

		if (row77cell10 != null) {
			row77cell10.setCellValue(
					brf038.getR78_inward_investment() == null ? 0 : brf038.getR78_inward_investment().intValue());
		}

		Cell row77cell11 = row77.getCell(11);

		if (row77cell11 != null) {
			row77cell11
					.setCellValue(brf038.getR78_inward_trade() == null ? 0 : brf038.getR78_inward_trade().intValue());
		}

		Cell row77cell12 = row77.getCell(12);

		if (row77cell12 != null) {
			row77cell12
					.setCellValue(brf038.getR78_inward_other() == null ? 0 : brf038.getR78_inward_other().intValue());
		}

		/* EXCEL ROW 78 - ENTITY ROW 79 */
		Row row78 = sheet.getRow(78);

		Cell row78cell3 = row78.getCell(3);

		if (row78cell3 != null) {
			row78cell3.setCellValue(
					brf038.getR79_outward_family() == null ? 0 : brf038.getR79_outward_family().intValue());
		}

		Cell row78cell4 = row78.getCell(4);

		if (row78cell4 != null) {
			row78cell4.setCellValue(
					brf038.getR79_outward_investment() == null ? 0 : brf038.getR79_outward_investment().intValue());
		}

		Cell row78cell5 = row78.getCell(5);

		if (row78cell5 != null) {
			row78cell5
					.setCellValue(brf038.getR79_outward_trade() == null ? 0 : brf038.getR79_outward_trade().intValue());
		}

		Cell row78cell6 = row78.getCell(6);

		if (row78cell6 != null) {
			row78cell6
					.setCellValue(brf038.getR79_outward_other() == null ? 0 : brf038.getR79_outward_other().intValue());
		}

		Cell row78cell9 = row78.getCell(9);

		if (row78cell9 != null) {
			row78cell9
					.setCellValue(brf038.getR79_inward_family() == null ? 0 : brf038.getR79_inward_family().intValue());
		}

		Cell row78cell10 = row78.getCell(10);

		if (row78cell10 != null) {
			row78cell10.setCellValue(
					brf038.getR79_inward_investment() == null ? 0 : brf038.getR79_inward_investment().intValue());
		}

		Cell row78cell11 = row78.getCell(11);

		if (row78cell11 != null) {
			row78cell11
					.setCellValue(brf038.getR79_inward_trade() == null ? 0 : brf038.getR79_inward_trade().intValue());
		}

		Cell row78cell12 = row78.getCell(12);

		if (row78cell12 != null) {
			row78cell12
					.setCellValue(brf038.getR79_inward_other() == null ? 0 : brf038.getR79_inward_other().intValue());
		}

		/* EXCEL ROW 79 - ENTITY ROW 80 */
		Row row79 = sheet.getRow(79);

		Cell row79cell3 = row79.getCell(3);

		if (row79cell3 != null) {
			row79cell3.setCellValue(
					brf038.getR80_outward_family() == null ? 0 : brf038.getR80_outward_family().intValue());
		}

		Cell row79cell4 = row79.getCell(4);

		if (row79cell4 != null) {
			row79cell4.setCellValue(
					brf038.getR80_outward_investment() == null ? 0 : brf038.getR80_outward_investment().intValue());
		}

		Cell row79cell5 = row79.getCell(5);

		if (row79cell5 != null) {
			row79cell5
					.setCellValue(brf038.getR80_outward_trade() == null ? 0 : brf038.getR80_outward_trade().intValue());
		}

		Cell row79cell6 = row79.getCell(6);

		if (row79cell6 != null) {
			row79cell6
					.setCellValue(brf038.getR80_outward_other() == null ? 0 : brf038.getR80_outward_other().intValue());
		}

		Cell row79cell9 = row79.getCell(9);

		if (row79cell9 != null) {
			row79cell9
					.setCellValue(brf038.getR80_inward_family() == null ? 0 : brf038.getR80_inward_family().intValue());
		}

		Cell row79cell10 = row79.getCell(10);

		if (row79cell10 != null) {
			row79cell10.setCellValue(
					brf038.getR80_inward_investment() == null ? 0 : brf038.getR80_inward_investment().intValue());
		}

		Cell row79cell11 = row79.getCell(11);

		if (row79cell11 != null) {
			row79cell11
					.setCellValue(brf038.getR80_inward_trade() == null ? 0 : brf038.getR80_inward_trade().intValue());
		}

		Cell row79cell12 = row79.getCell(12);

		if (row79cell12 != null) {
			row79cell12
					.setCellValue(brf038.getR80_inward_other() == null ? 0 : brf038.getR80_inward_other().intValue());
		}

		/* EXCEL ROW 80 - ENTITY ROW 81 */
		Row row80 = sheet.getRow(80);

		Cell row80cell3 = row80.getCell(3);

		if (row80cell3 != null) {
			row80cell3.setCellValue(
					brf038.getR81_outward_family() == null ? 0 : brf038.getR81_outward_family().intValue());
		}

		Cell row80cell4 = row80.getCell(4);

		if (row80cell4 != null) {
			row80cell4.setCellValue(
					brf038.getR81_outward_investment() == null ? 0 : brf038.getR81_outward_investment().intValue());
		}

		Cell row80cell5 = row80.getCell(5);

		if (row80cell5 != null) {
			row80cell5
					.setCellValue(brf038.getR81_outward_trade() == null ? 0 : brf038.getR81_outward_trade().intValue());
		}

		Cell row80cell6 = row80.getCell(6);

		if (row80cell6 != null) {
			row80cell6
					.setCellValue(brf038.getR81_outward_other() == null ? 0 : brf038.getR81_outward_other().intValue());
		}

		Cell row80cell9 = row80.getCell(9);

		if (row80cell9 != null) {
			row80cell9
					.setCellValue(brf038.getR81_inward_family() == null ? 0 : brf038.getR81_inward_family().intValue());
		}

		Cell row80cell10 = row80.getCell(10);

		if (row80cell10 != null) {
			row80cell10.setCellValue(
					brf038.getR81_inward_investment() == null ? 0 : brf038.getR81_inward_investment().intValue());
		}

		Cell row80cell11 = row80.getCell(11);

		if (row80cell11 != null) {
			row80cell11
					.setCellValue(brf038.getR81_inward_trade() == null ? 0 : brf038.getR81_inward_trade().intValue());
		}

		Cell row80cell12 = row80.getCell(12);

		if (row80cell12 != null) {
			row80cell12
					.setCellValue(brf038.getR81_inward_other() == null ? 0 : brf038.getR81_inward_other().intValue());
		}

		/* EXCEL ROW 81 - ENTITY ROW 82 */
		Row row81 = sheet.getRow(81);

		Cell row81cell3 = row81.getCell(3);

		if (row81cell3 != null) {
			row81cell3.setCellValue(
					brf038.getR82_outward_family() == null ? 0 : brf038.getR82_outward_family().intValue());
		}

		Cell row81cell4 = row81.getCell(4);

		if (row81cell4 != null) {
			row81cell4.setCellValue(
					brf038.getR82_outward_investment() == null ? 0 : brf038.getR82_outward_investment().intValue());
		}

		Cell row81cell5 = row81.getCell(5);

		if (row81cell5 != null) {
			row81cell5
					.setCellValue(brf038.getR82_outward_trade() == null ? 0 : brf038.getR82_outward_trade().intValue());
		}

		Cell row81cell6 = row81.getCell(6);

		if (row81cell6 != null) {
			row81cell6
					.setCellValue(brf038.getR82_outward_other() == null ? 0 : brf038.getR82_outward_other().intValue());
		}

		Cell row81cell9 = row81.getCell(9);

		if (row81cell9 != null) {
			row81cell9
					.setCellValue(brf038.getR82_inward_family() == null ? 0 : brf038.getR82_inward_family().intValue());
		}

		Cell row81cell10 = row81.getCell(10);

		if (row81cell10 != null) {
			row81cell10.setCellValue(
					brf038.getR82_inward_investment() == null ? 0 : brf038.getR82_inward_investment().intValue());
		}

		Cell row81cell11 = row81.getCell(11);

		if (row81cell11 != null) {
			row81cell11
					.setCellValue(brf038.getR82_inward_trade() == null ? 0 : brf038.getR82_inward_trade().intValue());
		}

		Cell row81cell12 = row81.getCell(12);

		if (row81cell12 != null) {
			row81cell12
					.setCellValue(brf038.getR82_inward_other() == null ? 0 : brf038.getR82_inward_other().intValue());
		}

		/* EXCEL ROW 82 - ENTITY ROW 83 */
		Row row82 = sheet.getRow(82);

		Cell row82cell3 = row82.getCell(3);

		if (row82cell3 != null) {
			row82cell3.setCellValue(
					brf038.getR83_outward_family() == null ? 0 : brf038.getR83_outward_family().intValue());
		}

		Cell row82cell4 = row82.getCell(4);

		if (row82cell4 != null) {
			row82cell4.setCellValue(
					brf038.getR83_outward_investment() == null ? 0 : brf038.getR83_outward_investment().intValue());
		}

		Cell row82cell5 = row82.getCell(5);

		if (row82cell5 != null) {
			row82cell5
					.setCellValue(brf038.getR83_outward_trade() == null ? 0 : brf038.getR83_outward_trade().intValue());
		}

		Cell row82cell6 = row82.getCell(6);

		if (row82cell6 != null) {
			row82cell6
					.setCellValue(brf038.getR83_outward_other() == null ? 0 : brf038.getR83_outward_other().intValue());
		}

		Cell row82cell9 = row82.getCell(9);

		if (row82cell9 != null) {
			row82cell9
					.setCellValue(brf038.getR83_inward_family() == null ? 0 : brf038.getR83_inward_family().intValue());
		}

		Cell row82cell10 = row82.getCell(10);

		if (row82cell10 != null) {
			row82cell10.setCellValue(
					brf038.getR83_inward_investment() == null ? 0 : brf038.getR83_inward_investment().intValue());
		}

		Cell row82cell11 = row82.getCell(11);

		if (row82cell11 != null) {
			row82cell11
					.setCellValue(brf038.getR83_inward_trade() == null ? 0 : brf038.getR83_inward_trade().intValue());
		}

		Cell row82cell12 = row82.getCell(12);

		if (row82cell12 != null) {
			row82cell12
					.setCellValue(brf038.getR83_inward_other() == null ? 0 : brf038.getR83_inward_other().intValue());
		}

		/* EXCEL ROW 84 - ENTITY ROW 85 */
		Row row84 = sheet.getRow(84);

		Cell row84cell3 = row84.getCell(3);

		if (row84cell3 != null) {
			row84cell3.setCellValue(
					brf038.getR85_outward_family() == null ? 0 : brf038.getR85_outward_family().intValue());
		}

		Cell row84cell4 = row84.getCell(4);

		if (row84cell4 != null) {
			row84cell4.setCellValue(
					brf038.getR85_outward_investment() == null ? 0 : brf038.getR85_outward_investment().intValue());
		}

		Cell row84cell5 = row84.getCell(5);

		if (row84cell5 != null) {
			row84cell5
					.setCellValue(brf038.getR85_outward_trade() == null ? 0 : brf038.getR85_outward_trade().intValue());
		}

		Cell row84cell6 = row84.getCell(6);

		if (row84cell6 != null) {
			row84cell6
					.setCellValue(brf038.getR85_outward_other() == null ? 0 : brf038.getR85_outward_other().intValue());
		}

		Cell row84cell9 = row84.getCell(9);

		if (row84cell9 != null) {
			row84cell9
					.setCellValue(brf038.getR85_inward_family() == null ? 0 : brf038.getR85_inward_family().intValue());
		}

		Cell row84cell10 = row84.getCell(10);

		if (row84cell10 != null) {
			row84cell10.setCellValue(
					brf038.getR85_inward_investment() == null ? 0 : brf038.getR85_inward_investment().intValue());
		}

		Cell row84cell11 = row84.getCell(11);

		if (row84cell11 != null) {
			row84cell11
					.setCellValue(brf038.getR85_inward_trade() == null ? 0 : brf038.getR85_inward_trade().intValue());
		}

		Cell row84cell12 = row84.getCell(12);

		if (row84cell12 != null) {
			row84cell12
					.setCellValue(brf038.getR85_inward_other() == null ? 0 : brf038.getR85_inward_other().intValue());
		}

		/* EXCEL ROW 85 - ENTITY ROW 86 */
		Row row85 = sheet.getRow(85);

		Cell row85cell3 = row85.getCell(3);

		if (row85cell3 != null) {
			row85cell3.setCellValue(
					brf038.getR86_outward_family() == null ? 0 : brf038.getR86_outward_family().intValue());
		}

		Cell row85cell4 = row85.getCell(4);

		if (row85cell4 != null) {
			row85cell4.setCellValue(
					brf038.getR86_outward_investment() == null ? 0 : brf038.getR86_outward_investment().intValue());
		}

		Cell row85cell5 = row85.getCell(5);

		if (row85cell5 != null) {
			row85cell5
					.setCellValue(brf038.getR86_outward_trade() == null ? 0 : brf038.getR86_outward_trade().intValue());
		}

		Cell row85cell6 = row85.getCell(6);

		if (row85cell6 != null) {
			row85cell6
					.setCellValue(brf038.getR86_outward_other() == null ? 0 : brf038.getR86_outward_other().intValue());
		}

		Cell row85cell9 = row85.getCell(9);

		if (row85cell9 != null) {
			row85cell9
					.setCellValue(brf038.getR86_inward_family() == null ? 0 : brf038.getR86_inward_family().intValue());
		}

		Cell row85cell10 = row85.getCell(10);

		if (row85cell10 != null) {
			row85cell10.setCellValue(
					brf038.getR86_inward_investment() == null ? 0 : brf038.getR86_inward_investment().intValue());
		}

		Cell row85cell11 = row85.getCell(11);

		if (row85cell11 != null) {
			row85cell11
					.setCellValue(brf038.getR86_inward_trade() == null ? 0 : brf038.getR86_inward_trade().intValue());
		}

		Cell row85cell12 = row85.getCell(12);

		if (row85cell12 != null) {
			row85cell12
					.setCellValue(brf038.getR86_inward_other() == null ? 0 : brf038.getR86_inward_other().intValue());
		}

	}

}
