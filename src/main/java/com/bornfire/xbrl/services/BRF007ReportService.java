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

import com.bornfire.xbrl.entities.BRF4_ARCHIVENTITY;
import com.bornfire.xbrl.entities.BRF7_ARCHIVENTITY;
import com.bornfire.xbrl.entities.BRBS.BRF7_DETAIL_ENTITY;
import com.bornfire.xbrl.entities.BRBS.BRF2_ENTITY;
import com.bornfire.xbrl.entities.BRBS.BRF45_DETAIL_ENTITY;
import com.bornfire.xbrl.entities.BRBS.BRF4_ENTITY;
import com.bornfire.xbrl.entities.BRBS.BRF7_DetailRep;
import com.bornfire.xbrl.entities.BRBS.BRF7_ENTITY;
import com.bornfire.xbrl.entities.BRBS.BRF_MAST_ENTITY;
import com.bornfire.xbrl.entities.BRBS.RBSTransactionMasterEntity;
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
public class BRF007ReportService {

	private static final Logger logger = LoggerFactory.getLogger(BRF007ReportService.class);

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
	BRF7_DetailRep bRF7_DetailRep;

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
			Long dtlcnt = (Long) hs.createQuery("select count(*) from BRF7_ENTITY a where a.report_date=?1")
					.setParameter(1, dt9).getSingleResult();

			if (dtlcnt > 0) {
				logger.info("Getting No of records in Mod table :" + reportid);
				Long modcnt = (Long) hs.createQuery("select count(*) from BRF7_ENTITY a").getSingleResult();
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

	public ModelAndView getBRF007View(String reportId, String fromdate, String todate, String currency, String dtltype,
			Pageable pageable) {

		ModelAndView mv = new ModelAndView();
		Session hs = sessionFactory.getCurrentSession();
		int pageSize = pageable.getPageSize();
		int currentPage = pageable.getPageNumber();
		int startItem = currentPage * pageSize;
		List<BRF7_ENTITY> T1rep = new ArrayList<BRF7_ENTITY>();
		// Query<Object[]> qr;

		List<BRF7_ENTITY> T1Master = new ArrayList<BRF7_ENTITY>();
		/* List<BRF73_TABLE2> T1Master1 = new ArrayList<BRF73_TABLE2>(); */

		logger.info("Inside archive" + currency);

		try {
			Date d1 = df.parse(todate);
			// T1rep = t1CurProdServiceRepo.getT1CurProdServices(d1);

			T1Master = hs.createQuery("from  BRF7_ENTITY a where a.report_date = ?1 ", BRF7_ENTITY.class)
					.setParameter(1, df.parse(todate)).getResultList();

			/*
			 * T1Master1 = hs.createQuery("from BRF73_TABLE2 a where a.report_date = ?1 ",
			 * BRF73_TABLE2.class) .setParameter(1, df.parse(todate)).getResultList();
			 */

		} catch (ParseException e) {
			e.printStackTrace();
		}

		// T1rep = t1CurProdServiceRepo.getT1CurProdServices(d1);

		mv.setViewName("RR/BRF7");
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

	public ModelAndView getBRF007currentDtl(String reportId, String fromdate, String todate, String currency,
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
						"select * from BRF7_DETAILTABLE  a where report_date = ?1 and report_label_1 =?2");

				qr.setParameter(2, filter);

			} else {
				qr = hs.createNativeQuery("select * from BRF7_DETAILTABLE a where report_date = ?1");

			}
		} else {
			qr = hs.createNativeQuery("select * from BRF7_DETAILTABLE  where report_date = ?1");
		}

		try {
			qr.setParameter(1, df.parse(todate));

		} catch (ParseException e) {
			e.printStackTrace();
		}
		List<BRF7_DETAIL_ENTITY> T1Master = new ArrayList<BRF7_DETAIL_ENTITY>();

		try {
			T1Master = hs.createQuery("from BRF7_DETAIL_ENTITY a where a.report_date = ?1", BRF7_DETAIL_ENTITY.class)
					.setParameter(1, df.parse(todate)).getResultList();
		} catch (ParseException e) {

			e.printStackTrace();
		}

		logger.info("Getting Report Detail for : " + reportId + "," + fromdate + "," + todate + "," + currency);
		List<Object[]> result = qr.getResultList();
		for (Object[] a : result) {
			String sol_id = (String) a[0];
			String acid = (String) a[1];
			String foracid = (String) a[2];
			String acct_name = (String) a[3];
			Character nre_flg = (Character) a[4];
			Character del_flg = (Character) a[5];
			String create_user = (String) a[6];
			String modify_user = (String) a[7];
			String report_label_1 = (String) a[8];
			String report_name_1 = (String) a[9];
			Date report_date = (Date) a[10];
			String version_control = (String) a[11];
			String cust_id = (String) a[12];
			String verify_user = (String) a[13];
			Character entity_flg = (Character) a[14];
			String remarks = (String) a[15];
			BigDecimal act_balance_amt_lc = (BigDecimal) a[16];
			BigDecimal eab_lc = (BigDecimal) a[17];
			String acct_crncy_code = (String) a[18];
			String gl_code = (String) a[19];
			String gl_sub_head_code = (String) a[20];
			String gl_sub_head_desc = (String) a[21];
			String country_of_incorp = (String) a[22];
			String cust_type = (String) a[23];
			String schm_code = (String) a[24];
			String schm_type = (String) a[25];
			String segment = (String) a[26];
			String sub_segment = (String) a[27];
			BigDecimal sector = (BigDecimal) a[28];
			String sub_sector = (String) a[29];
			String sector_code = (String) a[30];
			String group_id = (String) a[31];
			String constitution_code = (String) a[32];
			String country = (String) a[33];
			String legal_entity_type = (String) a[34];
			String constitution_desc = (String) a[35];
			String purpose_of_advn = (String) a[36];
			BigDecimal hni_networth = (BigDecimal) a[37];
			String turnover = (String) a[38];
			String bacid = (String) a[39];
			String report_addl_criteria_1 = (String) a[40];
			String report_addl_criteria_2 = (String) a[41];
			String report_addl_criteria_3 = (String) a[42];
			Date create_time = (Date) a[43];
			Date modify_time = (Date) a[44];
			Date verify_time = (Date) a[45];
			String maturity_date = (String) a[46];
			String gender = (String) a[47];
			Character nre_status = (Character) a[48];
			Character modify_flg = (Character) a[49];
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

			BRF7_DETAIL_ENTITY py = new BRF7_DETAIL_ENTITY(sol_id, acid, foracid, acct_name, nre_flg, del_flg,
					create_user, modify_user, report_label_1, report_name_1, report_date, version_control, cust_id,
					verify_user, entity_flg, remarks, act_balance_amt_lc, eab_lc, acct_crncy_code, gl_code,
					gl_sub_head_code, gl_sub_head_desc, country_of_incorp, cust_type, schm_code, schm_type, segment,
					sub_segment, sector, sub_sector, sector_code, group_id, constitution_code, country,
					legal_entity_type, constitution_desc, purpose_of_advn, hni_networth, turnover, bacid,
					report_addl_criteria_1, report_addl_criteria_2, report_addl_criteria_3, create_time, modify_time,
					verify_time, maturity_date, gender, nre_status, modify_flg);
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

		mv.setViewName("RR" + "/" + "BRF7::reportcontent");
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
		fileName = "011-BRF-007-A";
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

							jasperFile = this.getClass().getResourceAsStream("/static/jasper/BRF7_Detail.jrxml");
						} else {
							jasperFile = this.getClass().getResourceAsStream("/static/jasper/BRF7_Detail.jrxml");
						}

					} else {
						if (dtltype.equals("report")) {
							logger.info("Inside report");
							jasperFile = this.getClass().getResourceAsStream("/static/jasper/BRF7.jrxml");
						} else {
							jasperFile = this.getClass().getResourceAsStream("/static/jasper/BRF7.jrxml");
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

				List<BRF7_ENTITY> T1Master = new ArrayList<BRF7_ENTITY>();
				Session hs = sessionFactory.getCurrentSession();
				try {
					Date d1 = df.parse(todate);

					// T1rep = t1CurProdServiceRepo.getT1CurProdServices(d1);

					T1Master = hs.createQuery("from  BRF7_ENTITY a where a.report_date = ?1 ", BRF7_ENTITY.class)
							.setParameter(1, df.parse(todate)).getResultList();

					if (T1Master.size() == 1) {

						for (BRF7_ENTITY BRF07 : T1Master) {

							File Responsecamt = new File(
									env.getProperty("output.exportpathtemp") + "011-BRF-007-AT.xls");

							// Load the Excel file
							Workbook workbook = WorkbookFactory.create(Responsecamt);

							// Get the first sheet
							Sheet sheet = workbook.getSheetAt(0);

							/*
							 * Row r1row0 = sheet.getRow(4); if (r1row0 != null) { Cell r1cell0 =
							 * r1row0.getCell(2); if (r1cell0 == null) { r1cell0 = r1row0.createCell(2); //
							 * Create the cell if it doesn't exist } if (BRF07.getReport_date() != null) {
							 * // Formatting the date to dd-MM-yyyy SimpleDateFormat sdf = new
							 * SimpleDateFormat("dd-MM-yyyy"); String formattedDate =
							 * sdf.format(BRF07.getReport_date()); r1cell0.setCellValue(formattedDate); //
							 * Set the formatted date in the cell } else { r1cell0.setCellValue(""); // Set
							 * an empty value if the report_date is null } }
							 */
							/// Row1
							Row r1row = sheet.getRow(8);
							Cell r1cell = r1row.getCell(4);
							if (r1cell != null) {
								r1cell.setCellValue(BRF07.getR1_amount() == null ? 0 : BRF07.getR1_amount().intValue());
							}
							/// Row2
							Row r2row = sheet.getRow(9);
							Cell r2cell = r2row.getCell(4);
							if (r2cell != null) {
								r2cell.setCellValue(BRF07.getR2_amount() == null ? 0 : BRF07.getR2_amount().intValue());
							}
							/// Row3
							Row r3row = sheet.getRow(10);
							Cell r3cell = r3row.getCell(4);
							if (r3cell != null) {
								r3cell.setCellValue(BRF07.getR3_amount() == null ? 0 : BRF07.getR3_amount().intValue());
							}
							/// Row4
							Row r4row = sheet.getRow(11);
							Cell r4cell = r4row.getCell(4);
							if (r4cell != null) {
								r4cell.setCellValue(BRF07.getR4_amount() == null ? 0 : BRF07.getR4_amount().intValue());
							}
							/// Row5
							Row r5row = sheet.getRow(12);
							Cell r5cell = r5row.getCell(4);
							if (r5cell != null) {
								r5cell.setCellValue(BRF07.getR5_amount() == null ? 0 : BRF07.getR5_amount().intValue());
							}
							// Row7
							Row r7row = sheet.getRow(15);
							Cell r7cell = r7row.getCell(4);
							if (r7cell != null) {
								r7cell.setCellValue(BRF07.getR7_amount() == null ? 0 : BRF07.getR7_amount().intValue());
							}
							// Row8
							Row r8row = sheet.getRow(17);
							Cell r8cell = r8row.getCell(4);
							if (r8cell != null) {
								r8cell.setCellValue(BRF07.getR8_amount() == null ? 0 : BRF07.getR8_amount().intValue());
							}
							// Row9
							Row r9row = sheet.getRow(18);
							Cell r9cell = r9row.getCell(4);
							if (r9cell != null) {
								r9cell.setCellValue(BRF07.getR9_amount() == null ? 0 : BRF07.getR9_amount().intValue());
							}
							// Row10
							Row r10row = sheet.getRow(19);
							Cell r10cell = r10row.getCell(4);
							if (r10cell != null) {
								r10cell.setCellValue(
										BRF07.getR10_amount() == null ? 0 : BRF07.getR10_amount().intValue());
							} ////
								// Row12
							Row r12row = sheet.getRow(21);
							Cell r12cell = r12row.getCell(4);
							if (r12cell != null) {
								r12cell.setCellValue(
										BRF07.getR12_amount() == null ? 0 : BRF07.getR12_amount().intValue());
							}
							// Row13
							Row r13row = sheet.getRow(22);
							Cell r13cell = r13row.getCell(4);
							if (r13cell != null) {
								r13cell.setCellValue(
										BRF07.getR13_amount() == null ? 0 : BRF07.getR13_amount().intValue());
							}
							// Row16
							Row r16row = sheet.getRow(26);
							Cell r16cell = r16row.getCell(4);
							if (r16cell != null) {
								r16cell.setCellValue(
										BRF07.getR16_amount() == null ? 0 : BRF07.getR16_amount().intValue());
							}
							// Row17
							Row r17row = sheet.getRow(27);
							Cell r17cell = r17row.getCell(4);
							if (r17cell != null) {
								r17cell.setCellValue(
										BRF07.getR17_amount() == null ? 0 : BRF07.getR17_amount().intValue());
							}
							// Row18
							Row r18row = sheet.getRow(28);
							Cell r18cell = r18row.getCell(4);
							if (r18cell != null) {
								r18cell.setCellValue(
										BRF07.getR18_amount() == null ? 0 : BRF07.getR18_amount().intValue());
							}
							// Row19
							Row r19row = sheet.getRow(29);
							Cell r19cell = r19row.getCell(4);
							if (r19cell != null) {
								r19cell.setCellValue(
										BRF07.getR19_amount() == null ? 0 : BRF07.getR19_amount().intValue());
							}
							// Row20
							Row r20row = sheet.getRow(30);
							Cell r20cell = r20row.getCell(4);
							if (r20cell != null) {
								r20cell.setCellValue(
										BRF07.getR20_amount() == null ? 0 : BRF07.getR20_amount().intValue());
							}
							// Row21
							Row r21row = sheet.getRow(31);
							Cell r21cell = r21row.getCell(4);
							if (r21cell != null) {
								r21cell.setCellValue(
										BRF07.getR21_amount() == null ? 0 : BRF07.getR21_amount().intValue());
							}
							// Row22
							Row r22row = sheet.getRow(32);
							Cell r22cell = r22row.getCell(4);
							if (r22cell != null) {
								r22cell.setCellValue(
										BRF07.getR22_amount() == null ? 0 : BRF07.getR22_amount().intValue());
							}
							// Row23
							Row r23row = sheet.getRow(33);
							Cell r23cell = r23row.getCell(4);
							if (r23cell != null) {
								r23cell.setCellValue(
										BRF07.getR23_amount() == null ? 0 : BRF07.getR23_amount().intValue());
							}
							// Ro24
							Row r24row = sheet.getRow(34);
							Cell r24cell = r24row.getCell(4);
							if (r24cell != null) {
								r24cell.setCellValue(
										BRF07.getR24_amount() == null ? 0 : BRF07.getR24_amount().intValue());
							}

							// Save the changes
							workbook.getCreationHelper().createFormulaEvaluator().evaluateAll();
							FileOutputStream fileOut = new FileOutputStream(
									env.getProperty("output.exportpathfinal") + "011-BRF-007-A.xls");
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
		outputFile = new File(env.getProperty("output.exportpathfinal") + "011-BRF-007-A.xls");

		return outputFile;

	}

	public String detailChanges7(BRF7_DETAIL_ENTITY detail, String report_label_1, BigDecimal act_balance_amt_lc,
			String foracid, String report_name_1, String report_addl_criteria_1) {

		String msg = "";

		try {

			Session hs = sessionFactory.getCurrentSession();
			Optional<BRF7_DETAIL_ENTITY> Brf7detail = bRF7_DetailRep.findById(foracid);

			if (Brf7detail.isPresent()) {
				BRF7_DETAIL_ENTITY BRFdetail = Brf7detail.get();

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
					bRF7_DetailRep.save(BRFdetail);

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

	public ModelAndView getArchieveBRF007View(String reportId, String fromdate, String todate, String currency,
			String dtltype, Pageable pageable) {

		ModelAndView mv = new ModelAndView();
		Session hs = sessionFactory.getCurrentSession();
		int pageSize = pageable.getPageSize();
		int currentPage = pageable.getPageNumber();
		int startItem = currentPage * pageSize;
		List<BRF7_ENTITY> T1rep = new ArrayList<BRF7_ENTITY>();
		// Query<Object[]> qr;

		List<BRF7_ENTITY> T1Master = new ArrayList<BRF7_ENTITY>();
		/* List<BRF73_TABLE2> T1Master1 = new ArrayList<BRF73_TABLE2>(); */

		logger.info("Inside archive" + currency);

		try {
			Date d1 = df.parse(todate);
			// T1rep = t1CurProdServiceRepo.getT1CurProdServices(d1);

			T1Master = hs.createQuery("from  BRF7_ENTITY a where a.report_date = ?1 ", BRF7_ENTITY.class)
					.setParameter(1, df.parse(todate)).getResultList();

			/*
			 * T1Master1 = hs.createQuery("from BRF73_TABLE2 a where a.report_date = ?1 ",
			 * BRF73_TABLE2.class) .setParameter(1, df.parse(todate)).getResultList();
			 */

		} catch (ParseException e) {
			e.printStackTrace();
		}

		// T1rep = t1CurProdServiceRepo.getT1CurProdServices(d1);

		mv.setViewName("RR/BRF7ARCH");
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

	public ModelAndView ARCHgetBRF007currentDtl(String reportId, String fromdate, String todate, String currency,
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
						"select * from BRF7_ARCHIVTABLE a where report_date=?1 and report_label_1=?2");
				qr.setParameter(1, df.parse(todate));
				qr.setParameter(2, filter);

			} else {
				System.out.println("2");
				qr = hs.createNativeQuery("select * from BRF7_ARCHIVTABLE");

			}
		} else {
			System.out.println("3");
			qr = hs.createNativeQuery("select * from BRF7_ARCHIVTABLE  where report_date = ?1");
		}

		/*
		 * try { qr.setParameter(1, df.parse(todate));
		 * 
		 * } catch (ParseException e) { e.printStackTrace(); }
		 */
		List<BRF7_ARCHIVENTITY> T1Master = new ArrayList<BRF7_ARCHIVENTITY>();

		try {
			System.out.println("Values entered");
			T1Master = hs.createQuery("from BRF7_ARCHIVENTITY a where a.report_date = ?1", BRF7_ARCHIVENTITY.class)
					.setParameter(1, df.parse(todate)).getResultList();
		} catch (ParseException e) {

			e.printStackTrace();
		}

		logger.info("Getting Report Detail for : " + reportId + "," + fromdate + "," + todate + "," + currency);
		List<Object[]> result = qr.getResultList();

		for (Object[] a : result) {
			String sol_id = (String) a[0];
			String acid = (String) a[1];
			String foracid = (String) a[2];
			String acct_name = (String) a[3];
			Character nre_flg = (Character) a[4];
			Character del_flg = (Character) a[5];
			String create_user = (String) a[6];
			String modify_user = (String) a[7];
			String report_label_1 = (String) a[8];
			String report_name_1 = (String) a[9];
			Date report_date = (Date) a[10];
			String version_control = (String) a[11];
			String cust_id = (String) a[12];
			String verify_user = (String) a[13];
			Character entity_flg = (Character) a[14];
			String remarks = (String) a[15];
			BigDecimal act_balance_amt_lc = (BigDecimal) a[16];
			BigDecimal eab_lc = (BigDecimal) a[17];
			String acct_crncy_code = (String) a[18];
			String gl_code = (String) a[19];
			String gl_sub_head_code = (String) a[20];
			String gl_sub_head_desc = (String) a[21];
			String country_of_incorp = (String) a[22];
			String cust_type = (String) a[23];
			String schm_code = (String) a[24];
			String schm_type = (String) a[25];
			String segment = (String) a[26];
			String sub_segment = (String) a[27];
			BigDecimal sector = (BigDecimal) a[28];
			String sub_sector = (String) a[29];
			String sector_code = (String) a[30];
			String group_id = (String) a[31];
			String constitution_code = (String) a[32];
			String country = (String) a[33];
			String legal_entity_type = (String) a[34];
			String constitution_desc = (String) a[35];
			String purpose_of_advn = (String) a[36];
			BigDecimal hni_networth = (BigDecimal) a[37];
			String turnover = (String) a[38];
			String bacid = (String) a[39];
			String report_addl_criteria_1 = (String) a[40];
			String report_addl_criteria_2 = (String) a[41];
			String report_addl_criteria_3 = (String) a[42];
			Date create_time = (Date) a[43];
			Date modify_time = (Date) a[44];
			Date verify_time = (Date) a[45];
			String maturity_date = (String) a[46];
			String gender = (String) a[47];
			Character nre_status = (Character) a[48];
			Character modify_flg = (Character) a[49];
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

			BRF7_ARCHIVENTITY py = new BRF7_ARCHIVENTITY(sol_id, acid, foracid, acct_name, nre_flg, del_flg,
					create_user, modify_user, report_label_1, report_name_1, report_date, version_control, cust_id,
					verify_user, entity_flg, remarks, act_balance_amt_lc, eab_lc, acct_crncy_code, gl_code,
					gl_sub_head_code, gl_sub_head_desc, country_of_incorp, cust_type, schm_code, schm_type, segment,
					sub_segment, sector, sub_sector, sector_code, group_id, constitution_code, country,
					legal_entity_type, constitution_desc, purpose_of_advn, hni_networth, turnover, bacid,
					report_addl_criteria_1, report_addl_criteria_2, report_addl_criteria_3, create_time, modify_time,
					verify_time, maturity_date, gender, nre_status, modify_flg);
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

		mv.setViewName("RR" + "/" + "BRF7ARCH::reportcontent");
		mv.addObject("reportdetails", T1Dt1Page.getContent());
		mv.addObject("reportmaster", T1Master);
		mv.addObject("reportmaster1", qr);
		mv.addObject("singledetail", new T1CurProdDetail());
		mv.addObject("reportsflag", "reportsflag");
		mv.addObject("menu", reportId);
		return mv;
	}
}
