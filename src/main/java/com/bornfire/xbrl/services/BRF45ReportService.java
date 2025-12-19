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
import org.springframework.core.env.Environment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.ModelAndView;

import com.bornfire.xbrl.entities.BRBS.BRF45_ARCHIVENTITY;
import com.bornfire.xbrl.entities.BRBS.BRF45_DETAIL_ENTITY;
import com.bornfire.xbrl.entities.BRBS.BRF45_DetailRepo;
import com.bornfire.xbrl.entities.BRBS.BRF45_ENTITY2;
import com.bornfire.xbrl.entities.BRBS.BRF45_Entity1;
import com.bornfire.xbrl.entities.BRBS.BRF45_Entity3;
import com.bornfire.xbrl.entities.BRBS.BRF45_EntityRepo;
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

public class BRF45ReportService {
	private static final Logger logger = LoggerFactory.getLogger(BRF45ReportService.class);

	@Autowired
	SessionFactory sessionFactory;

	@Autowired
	DataSource srcdataSource;

	@Autowired
	Environment env;

	@Autowired
	BRF45_DetailRepo brf45_detailrepo;

	@Autowired
	BRF45_EntityRepo BRF45_EntityRepo;

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
			Long dtlcnt = (Long) hs.createQuery("select count(*) from  BRF45_Entity1 a where a.report_date=?1")
					.setParameter(1, dt9).getSingleResult();

			if (dtlcnt > 0) {
				logger.info("Getting No of records in Mod table :" + reportid);
				Long modcnt = (Long) hs.createQuery("select count(*) from  BRF45_Entity1 a").getSingleResult();
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

	public ModelAndView getBRF45View(String reportId, String fromdate, String todate, String currency, String dtltype,
			Pageable pageable) {
		String msg = "";
		ModelAndView mv = new ModelAndView();
		Session hs = sessionFactory.getCurrentSession();
		int pageSize = pageable.getPageSize();
		int currentPage = pageable.getPageNumber();
		int startItem = currentPage * pageSize;
		/* List<BRF036_ENTITY> T1rep = new ArrayList<BRF036_ENTITY>(); */
		// Query<Object[]> qr;

		List<BRF45_Entity1> T1Master = new ArrayList<BRF45_Entity1>();
		List<BRF45_ENTITY2> T1Master1 = new ArrayList<BRF45_ENTITY2>();
		List<BRF45_Entity3> T1Master2 = new ArrayList<BRF45_Entity3>();
		List<Object[]> T2rep = new ArrayList<Object[]>();
		logger.info("Inside archive" + currency);

		try {
			Date d1 = df.parse(todate);
			// T1rep = t1CurProdServiceRepo.getT1CurProdServices(d1);

			T1Master = hs.createQuery("from  BRF45_Entity1 a where a.report_date = ?1 ", BRF45_Entity1.class)
					.setParameter(1, df.parse(todate)).getResultList();

			T1Master1 = hs.createQuery("from BRF45_ENTITY2 a where a.report_date = ?1 ", BRF45_ENTITY2.class)
					.setParameter(1, df.parse(todate)).getResultList();

			T2rep = BRF45_EntityRepo.getReportSummaryC(todate);

			if (T2rep.size() > 0) {
				System.out.println(T2rep.toString());
				for (Object[] BRF038 : T2rep) {
					System.out.println("Inside loop");
					BRF45_Entity3 BRF45_Entity3 = new BRF45_Entity3();
					BRF45_Entity3.setCountry((String) BRF038[0]);
					BRF45_Entity3.setGovernment_resident((BigDecimal) BRF038[1]);
					BRF45_Entity3.setPrivate_resident((BigDecimal) BRF038[2]);
					BRF45_Entity3.setGre_resident((BigDecimal) BRF038[3]);
					BRF45_Entity3.setHni_resident((BigDecimal) BRF038[4]);
					BRF45_Entity3.setIndividual_resident((BigDecimal) BRF038[5]);
					BRF45_Entity3.setBanking_resident((BigDecimal) BRF038[6]);
					BRF45_Entity3.setTrade_resident((BigDecimal) BRF038[7]);
					BRF45_Entity3.setGovernment_non_resident((BigDecimal) BRF038[8]);
					BRF45_Entity3.setPrivate_non_resident((BigDecimal) BRF038[9]);
					BRF45_Entity3.setGre_non_resident((BigDecimal) BRF038[10]);
					BRF45_Entity3.setHni_non_resident((BigDecimal) BRF038[11]);
					BRF45_Entity3.setIndividual_non_resident((BigDecimal) BRF038[12]);
					BRF45_Entity3.setBanking_non_resident((BigDecimal) BRF038[13]);
					BRF45_Entity3.setTrade_non_resident((BigDecimal) BRF038[14]);
					BRF45_Entity3.setReport_label((String) BRF038[30]);

					T1Master2.add(BRF45_Entity3);

				}
			} else {
				msg = "No data Found";
			}

		} catch (ParseException e) {
			e.printStackTrace();
		}

		// T1rep = t1CurProdServiceRepo.getT1CurProdServices(d1);

		mv.setViewName("RR/BRF45");
		// mv.addObject("currlist", refCodeConfig.currList());
		mv.addObject("reportsummary", T1Master);
		mv.addObject("reportsummary1", T1Master1);
		mv.addObject("reportsummary2", T1Master2);
		mv.addObject("reportmaster", T1Master);
		mv.addObject("displaymode", "summary");
		mv.addObject("reportsflag", "reportsflag");
		mv.addObject("menu", reportId);
		System.out.println("scv" + mv.getViewName());

		return mv;

	}

	public ModelAndView getBRF45currentDtl(String reportId, String fromdate, String todate, String currency,
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
						"select * from BRF45A_DETAILTABLE  a where report_date = ?1 and report_label_1=?2");

				qr.setParameter(2, filter);

			} else {
				qr = hs.createNativeQuery("select * from BRF45A_DETAILTABLE a where report_date = ?1");

			}
		} else {
			qr = hs.createNativeQuery("select * from BRF45A_DETAILTABLE  where report_date = ?1");
		}

		try {
			qr.setParameter(1, df.parse(todate));

		} catch (ParseException e) {
			e.printStackTrace();
		}
		List<BRF45_DETAIL_ENTITY> T1Master = new ArrayList<BRF45_DETAIL_ENTITY>();

		try {
			T1Master = hs.createQuery("from BRF45_DETAIL_ENTITY a where a.report_date = ?1", BRF45_DETAIL_ENTITY.class)
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

			BRF45_DETAIL_ENTITY py = new BRF45_DETAIL_ENTITY(cust_id, foracid, act_balance_amt_lc, eab_lc, acct_name,
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

		mv.setViewName("RR" + "/" + "BRF45::reportcontent");
		// mv.setViewName("ReportT1");
		mv.addObject("reportdetails", T1Dt1Page);
		mv.addObject("reportmaster", T1Master);
		mv.addObject("singledetail", new T1CurProdDetail());
		mv.addObject("reportsflag", "reportsflag");
		mv.addObject("menu", reportId);
		return mv;
	}

	public File getFileBRF45(String reportId, String fromdate, String todate, String currency, String dtltype,
			String filetype) throws FileNotFoundException, JRException, SQLException {

		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

		String path = this.env.getProperty("output.exportpath");
		String fileName = "";
		String zipFileName = "";
		File outputFile;

		logger.info("Getting Output file :" + reportId);
		fileName = "011-BRF-045-A";

		if (!filetype.equals("xbrl")) {
			if (!filetype.equals("BRF")) {
				try {
					InputStream jasperFile;
					logger.info("Getting Jasper file :" + reportId);
					if (filetype.equals("detailexcel")) {
						if (dtltype.equals("report")) {

							jasperFile = this.getClass().getResourceAsStream("/static/jasper/BRF45_Details.jrxml");
						} else {
							jasperFile = this.getClass().getResourceAsStream("/static/jasper/BRF45_Details.jrxml");
						}

					} else {
						if (dtltype.equals("report")) {
							logger.info("Inside report");
							jasperFile = this.getClass().getResourceAsStream("/static/jasper/BRF45.jrxml");
						} else {
							jasperFile = this.getClass().getResourceAsStream("/static/jasper/BRF45.jrxml");
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

				Session hs = sessionFactory.getCurrentSession();

				try {
					Date d1 = df.parse(todate);
					System.out.println("the todate value is" + todate);
					// Retrieve data
					List<Object[]> T1Master1 = BRF45_EntityRepo.getReportSummaryC1(todate);

					File responseFile = new File(env.getProperty("output.exportpathtemp") + "011-BRF-045-AT.xls");

					// Load the Excel file
					Workbook workbook = WorkbookFactory.create(responseFile);
					Sheet sheet = workbook.getSheetAt(0);

					List<BRF45_Entity1> updateSheetRow1To61 = hs
							.createQuery("from BRF45_Entity1 a where a.report_date = ?1", BRF45_Entity1.class)
							.setParameter(1, df.parse(todate)).getResultList();

					if (updateSheetRow1To61.size() == 1) {
						for (BRF45_Entity1 brf96ARow1TO471 : updateSheetRow1To61) {

							updateSheetRow1To611(sheet, brf96ARow1TO471);

						}
					}

					List<BRF45_ENTITY2> updateSheetRow62To103 = hs
							.createQuery("from BRF45_ENTITY2 a where a.report_date = ?1", BRF45_ENTITY2.class)
							.setParameter(1, df.parse(todate)).getResultList();

					if (updateSheetRow62To103.size() == 1) {
						for (BRF45_ENTITY2 brf206Row1TO472 : updateSheetRow62To103) {

							updateSheetRow62To1033(sheet, brf206Row1TO472);

						}
					}

					if (!T1Master1.isEmpty()) {
						int startRow = 102;

						for (int index = 0; index < T1Master1.size(); index++) {
							Object[] BRF045 = T1Master1.get(index);
							System.out.println(BRF045[0]);
							Row row = sheet.getRow(startRow + index);
							if (row == null) {
								row = sheet.createRow(startRow + index);
							}

							Cell cell1 = row.getCell(2);
							if (cell1 == null) {
								cell1 = row.createCell(2);
							}
							cell1.setCellValue(BRF045[0] == null ? "0" : (String) BRF045[0]);

							// ISSUE_NAME
							Cell cell2 = row.getCell(3);
							if (cell2 == null) {
								cell2 = row.createCell(3);
							}
							cell2.setCellValue(BRF045[1] == null ? 0 : ((BigDecimal) BRF045[1]).intValue());

							// ISSUE_TRACKER
							Cell cell3 = row.getCell(4);
							if (cell3 == null) {
								cell3 = row.createCell(4);
							}
							cell3.setCellValue(BRF045[2] == null ? 0 : ((BigDecimal) BRF045[2]).intValue());

							// COUNTRY
							Cell cell4 = row.getCell(5);
							if (cell4 == null) {
								cell4 = row.createCell(5);
							}
							cell4.setCellValue(BRF045[3] == null ? 0 : ((BigDecimal) BRF045[3]).intValue());

							// COUNTRY_PARTY

							Cell cell5 = row.getCell(6); // Assuming column 5 is where you want to place
															// totalExposure
							if (cell5 == null) {
								cell5 = row.createCell(6);
							}
							cell5.setCellValue(BRF045[4] == null ? 0 : ((BigDecimal) BRF045[4]).intValue());

							Cell cell6 = row.getCell(7); // Assuming column 5 is where you want to place
															// totalExposure
							if (cell6 == null) {
								cell6 = row.createCell(7);
							}
							cell6.setCellValue(BRF045[5] == null ? 0 : ((BigDecimal) BRF045[5]).intValue());

							Cell cell7 = row.getCell(8); // Assuming column 5 is where you want to place
															// totalExposure
							if (cell7 == null) {
								cell7 = row.createCell(8);
							}
							cell7.setCellValue(BRF045[6] == null ? 0 : ((BigDecimal) BRF045[6]).intValue());

							Cell cell8 = row.getCell(9); // Assuming column 5 is where you want to place
															// totalExposure
							if (cell8 == null) {
								cell8 = row.createCell(9);
							}
							cell8.setCellValue(BRF045[7] == null ? 0 : ((BigDecimal) BRF045[7]).intValue());

							Cell cell9 = row.getCell(10); // Assuming column 5 is where you want to place
															// totalExposure
							if (cell9 == null) {
								cell9 = row.createCell(10);
							}
							cell9.setCellValue(BRF045[8] == null ? 0 : ((BigDecimal) BRF045[8]).intValue());

							Cell cell10 = row.getCell(11); // Assuming column 5 is where you want to place
															// totalExposure
							if (cell10 == null) {
								cell10 = row.createCell(11);
							}
							cell10.setCellValue(BRF045[9] == null ? 0 : ((BigDecimal) BRF045[9]).intValue());

							Cell cell11 = row.getCell(12); // Assuming column 5 is where you want to place
															// totalExposure
							if (cell11 == null) {
								cell11 = row.createCell(12);
							}
							cell11.setCellValue(BRF045[10] == null ? 0 : ((BigDecimal) BRF045[10]).intValue());

							Cell cell12 = row.getCell(13); // Assuming column 5 is where you want to place
															// totalExposure
							if (cell12 == null) {
								cell12 = row.createCell(13);
							}
							cell12.setCellValue(BRF045[11] == null ? 0 : ((BigDecimal) BRF045[11]).intValue());

							Cell cell13 = row.getCell(14); // Assuming column 5 is where you want to place
															// totalExposure
							if (cell13 == null) {
								cell13 = row.createCell(14);
							}
							cell13.setCellValue(BRF045[12] == null ? 0 : ((BigDecimal) BRF045[12]).intValue());

							Cell cell14 = row.getCell(15); // Assuming column 5 is where you want to place
															// totalExposure
							if (cell14 == null) {
								cell14 = row.createCell(15);
							}
							cell14.setCellValue(BRF045[13] == null ? 0 : ((BigDecimal) BRF045[13]).intValue());

							Cell cell15 = row.getCell(16); // Assuming column 5 is where you want to place
															// totalExposure
							if (cell15 == null) {
								cell15 = row.createCell(16);
							}
							cell15.setCellValue(BRF045[14] == null ? 0 : ((BigDecimal) BRF045[14]).intValue());

						}

						// Save the changes
						workbook.getCreationHelper().createFormulaEvaluator().evaluateAll();

						try (FileOutputStream fileOut = new FileOutputStream(
								env.getProperty("output.exportpathfinal") + "011-BRF-045-A.xls")) {
							workbook.write(fileOut);
							System.out.println("File saved successfully at: "
									+ env.getProperty("output.exportpathfinal") + "011-BRF-045-A.xls");
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
		outputFile = new File(env.getProperty("output.exportpathfinal") + "011-BRF-045-A.xls");

		return outputFile;

	}

	public String detailChanges45(BRF45_DETAIL_ENTITY detail, String foracid, String report_addl_criteria_1,
			BigDecimal act_balance_amt_lc, String report_label_1, String report_name_1) {

		String msg = "";

		try {

			Session hs = sessionFactory.getCurrentSession();
			Optional<BRF45_DETAIL_ENTITY> Brf45detail = brf45_detailrepo.findById(foracid);

			if (Brf45detail.isPresent()) {
				BRF45_DETAIL_ENTITY BRFdetail = Brf45detail.get();

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
					brf45_detailrepo.save(BRFdetail);

//					hs.saveOrUpdate(detail);
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

	public ModelAndView getArchieveBRF045View(String reportId, String fromdate, String todate, String currency,
			String dtltype, Pageable pageable) {
		String msg = "";
		ModelAndView mv = new ModelAndView();
		Session hs = sessionFactory.getCurrentSession();
		int pageSize = pageable.getPageSize();
		int currentPage = pageable.getPageNumber();
		int startItem = currentPage * pageSize;
		/* List<BRF036_ENTITY> T1rep = new ArrayList<BRF036_ENTITY>(); */
		// Query<Object[]> qr;

		List<BRF45_Entity1> T1Master = new ArrayList<BRF45_Entity1>();
		List<BRF45_ENTITY2> T1Master1 = new ArrayList<BRF45_ENTITY2>();
		List<BRF45_Entity3> T1Master2 = new ArrayList<BRF45_Entity3>();
		List<Object[]> T2rep = new ArrayList<Object[]>();
		logger.info("Inside archive" + currency);

		try {
			Date d1 = df.parse(todate);
			// T1rep = t1CurProdServiceRepo.getT1CurProdServices(d1);

			T1Master = hs.createQuery("from  BRF45_Entity1 a where a.report_date = ?1 ", BRF45_Entity1.class)
					.setParameter(1, df.parse(todate)).getResultList();

			T1Master1 = hs.createQuery("from BRF45_ENTITY2 a where a.report_date = ?1 ", BRF45_ENTITY2.class)
					.setParameter(1, df.parse(todate)).getResultList();

			T2rep = BRF45_EntityRepo.getReportSummaryC(todate);

			if (T2rep.size() > 0) {
				System.out.println(T2rep.toString());
				for (Object[] BRF038 : T2rep) {
					System.out.println("Inside loop");
					BRF45_Entity3 BRF45_Entity3 = new BRF45_Entity3();
					BRF45_Entity3.setCountry((String) BRF038[0]);
					BRF45_Entity3.setGovernment_resident((BigDecimal) BRF038[1]);
					BRF45_Entity3.setPrivate_resident((BigDecimal) BRF038[2]);
					BRF45_Entity3.setGre_resident((BigDecimal) BRF038[3]);
					BRF45_Entity3.setHni_resident((BigDecimal) BRF038[4]);
					BRF45_Entity3.setIndividual_resident((BigDecimal) BRF038[5]);
					BRF45_Entity3.setBanking_resident((BigDecimal) BRF038[6]);
					BRF45_Entity3.setTrade_resident((BigDecimal) BRF038[7]);
					BRF45_Entity3.setGovernment_non_resident((BigDecimal) BRF038[8]);
					BRF45_Entity3.setPrivate_non_resident((BigDecimal) BRF038[9]);
					BRF45_Entity3.setGre_non_resident((BigDecimal) BRF038[10]);
					BRF45_Entity3.setHni_non_resident((BigDecimal) BRF038[11]);
					BRF45_Entity3.setIndividual_non_resident((BigDecimal) BRF038[12]);
					BRF45_Entity3.setBanking_non_resident((BigDecimal) BRF038[13]);
					BRF45_Entity3.setTrade_non_resident((BigDecimal) BRF038[14]);
					BRF45_Entity3.setReport_label((String) BRF038[30]);

					T1Master2.add(BRF45_Entity3);

				}
			} else {
				msg = "No data Found";
			}

		} catch (ParseException e) {
			e.printStackTrace();
		}

		// T1rep = t1CurProdServiceRepo.getT1CurProdServices(d1);

		mv.setViewName("RR/BRF45ARCH");
		// mv.addObject("currlist", refCodeConfig.currList());
		mv.addObject("reportsummary", T1Master);
		mv.addObject("reportsummary1", T1Master1);
		mv.addObject("reportsummary2", T1Master2);
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

	public ModelAndView ARCHgetBRF045currentDtl(String reportId, String fromdate, String todate, String currency,
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
						"select * from BRF45_ARCHIVTABLE a where report_date=?1 and report_label_1=?2");
				qr.setParameter(1, df.parse(todate));
				qr.setParameter(2, filter);

			} else {
				System.out.println("2");
				qr = hs.createNativeQuery("select * from BRF45_ARCHIVTABLE");

			}
		} else {
			System.out.println("3");
			qr = hs.createNativeQuery("select * from BRF45_ARCHIVTABLE  where report_date = ?1");
		}

		/*
		 * try { qr.setParameter(1, df.parse(todate));
		 * 
		 * } catch (ParseException e) { e.printStackTrace(); }
		 */
		List<BRF45_ARCHIVENTITY> T1Master = new ArrayList<BRF45_ARCHIVENTITY>();

		try {
			System.out.println("Values entered");
			T1Master = hs.createQuery("from BRF45_ARCHIVENTITY a where a.report_date = ?1", BRF45_ARCHIVENTITY.class)
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

			BRF45_ARCHIVENTITY py = new BRF45_ARCHIVENTITY(cust_id, foracid, act_balance_amt_lc, eab_lc, acct_name,
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

		mv.setViewName("RR" + "/" + "BRF45ARCH::reportcontent");
		mv.addObject("reportdetails", T1Dt1Page.getContent());
		mv.addObject("reportmaster", T1Master);
		mv.addObject("reportmaster1", qr);
		mv.addObject("singledetail", new T1CurProdDetail());
		mv.addObject("reportsflag", "reportsflag");
		mv.addObject("menu", reportId);
		return mv;
	}

	public void updateSheetRow1To611(Sheet sheet, BRF45_Entity1 brf96ARow1TO471) {

		// ROW 22

		Row row21 = sheet.getRow(20);

		Cell row21cell1 = row21.getCell(2);

		if (row21cell1 != null) {
			row21cell1.setCellValue(brf96ARow1TO471.getR21_country() == null ? "0" : brf96ARow1TO471.getR21_country());
		}

		Cell row21cell2 = row21.getCell(3);

		if (row21cell2 != null) {
			row21cell2.setCellValue(brf96ARow1TO471.getR21_government_resident() == null ? 0
					: brf96ARow1TO471.getR21_government_resident().intValue());
		}

		Cell row21cell3 = row21.getCell(4);

		if (row21cell3 != null) {
			row21cell3.setCellValue(brf96ARow1TO471.getR21_gre_resident() == null ? 0
					: brf96ARow1TO471.getR21_gre_resident().intValue());
		}

		Cell row21cell4 = row21.getCell(5);

		if (row21cell4 != null) {
			row21cell4.setCellValue(brf96ARow1TO471.getR21_private_resident() == null ? 0
					: brf96ARow1TO471.getR21_private_resident().intValue());
		}

		Cell row21cell5 = row21.getCell(6);

		if (row21cell5 != null) {
			row21cell5.setCellValue(brf96ARow1TO471.getR21_hni_resident() == null ? 0
					: brf96ARow1TO471.getR21_hni_resident().intValue());
		}

		Cell row21cell6 = row21.getCell(7);

		if (row21cell6 != null) {
			row21cell6.setCellValue(brf96ARow1TO471.getR21_individual_resident() == null ? 0
					: brf96ARow1TO471.getR21_individual_resident().intValue());
		}

		Cell row21cell7 = row21.getCell(8);

		if (row21cell7 != null) {
			row21cell7.setCellValue(brf96ARow1TO471.getR21_banking_resident() == null ? 0
					: brf96ARow1TO471.getR21_banking_resident().intValue());
		}

		Cell row21cell8 = row21.getCell(9);

		if (row21cell8 != null) {
			row21cell8.setCellValue(brf96ARow1TO471.getR21_trade_resident() == null ? 0
					: brf96ARow1TO471.getR21_trade_resident().intValue());
		}

		Cell row21cell9 = row21.getCell(10);

		if (row21cell9 != null) {
			row21cell9.setCellValue(brf96ARow1TO471.getR21_government_non_resident() == null ? 0
					: brf96ARow1TO471.getR21_government_non_resident().intValue());
		}

		Cell row21cell10 = row21.getCell(11);

		if (row21cell10 != null) {
			row21cell10.setCellValue(brf96ARow1TO471.getR21_gre_non_resident() == null ? 0
					: brf96ARow1TO471.getR22_gre_non_resident().intValue());
		}

		Cell row21cell11 = row21.getCell(12);

		if (row21cell11 != null) {
			row21cell11.setCellValue(brf96ARow1TO471.getR21_private_non_resident() == null ? 0
					: brf96ARow1TO471.getR21_private_non_resident().intValue());
		}

		Cell row21cell12 = row21.getCell(13);

		if (row21cell12 != null) {
			row21cell12.setCellValue(brf96ARow1TO471.getR21_hni_non_resident() == null ? 0
					: brf96ARow1TO471.getR21_hni_non_resident().intValue());
		}

		Cell row21cell13 = row21.getCell(14);

		if (row21cell13 != null) {
			row21cell13.setCellValue(brf96ARow1TO471.getR21_individual_non_resident() == null ? 0
					: brf96ARow1TO471.getR21_individual_non_resident().intValue());
		}

		Cell row21cell14 = row21.getCell(15);

		if (row21cell14 != null) {
			row21cell14.setCellValue(brf96ARow1TO471.getR21_banking_non_resident() == null ? 0
					: brf96ARow1TO471.getR21_banking_non_resident().intValue());
		}

		Cell row21cell15 = row21.getCell(16);

		if (row21cell15 != null) {
			row21cell15.setCellValue(brf96ARow1TO471.getR21_trade_non_resident() == null ? 0
					: brf96ARow1TO471.getR21_trade_non_resident().intValue());
		}

		Row row22 = sheet.getRow(21);

		Cell row22cell1 = row22.getCell(2);

		if (row22cell1 != null) {
			row22cell1.setCellValue(brf96ARow1TO471.getR22_country() == null ? "0" : brf96ARow1TO471.getR22_country());
		}

		Cell row22cell2 = row22.getCell(3);

		if (row22cell2 != null) {
			row22cell2.setCellValue(brf96ARow1TO471.getR22_government_resident() == null ? 0
					: brf96ARow1TO471.getR22_government_resident().intValue());
		}

		Cell row22cell3 = row22.getCell(4);

		if (row22cell3 != null) {
			row22cell3.setCellValue(brf96ARow1TO471.getR22_gre_resident() == null ? 0
					: brf96ARow1TO471.getR22_gre_resident().intValue());
		}

		Cell row22cell4 = row22.getCell(5);

		if (row22cell4 != null) {
			row22cell4.setCellValue(brf96ARow1TO471.getR22_private_resident() == null ? 0
					: brf96ARow1TO471.getR22_private_resident().intValue());
		}

		Cell row22cell5 = row22.getCell(6);

		if (row22cell5 != null) {
			row22cell5.setCellValue(brf96ARow1TO471.getR22_hni_resident() == null ? 0
					: brf96ARow1TO471.getR22_hni_resident().intValue());
		}

		Cell row22cell6 = row22.getCell(7);

		if (row22cell6 != null) {
			row22cell6.setCellValue(brf96ARow1TO471.getR22_individual_resident() == null ? 0
					: brf96ARow1TO471.getR22_individual_resident().intValue());
		}

		Cell row22cell7 = row22.getCell(8);

		if (row22cell7 != null) {
			row22cell7.setCellValue(brf96ARow1TO471.getR22_banking_resident() == null ? 0
					: brf96ARow1TO471.getR22_banking_resident().intValue());
		}

		Cell row22cell8 = row22.getCell(9);

		if (row22cell8 != null) {
			row22cell8.setCellValue(brf96ARow1TO471.getR22_trade_resident() == null ? 0
					: brf96ARow1TO471.getR22_trade_resident().intValue());
		}

		Cell row22cell9 = row22.getCell(10);

		if (row22cell9 != null) {
			row22cell9.setCellValue(brf96ARow1TO471.getR22_government_non_resident() == null ? 0
					: brf96ARow1TO471.getR22_government_non_resident().intValue());
		}

		Cell row22cell10 = row22.getCell(11);

		if (row22cell10 != null) {
			row22cell10.setCellValue(brf96ARow1TO471.getR22_gre_non_resident() == null ? 0
					: brf96ARow1TO471.getR22_gre_non_resident().intValue());
		}

		Cell row22cell11 = row22.getCell(12);

		if (row22cell11 != null) {
			row22cell11.setCellValue(brf96ARow1TO471.getR22_private_non_resident() == null ? 0
					: brf96ARow1TO471.getR22_private_non_resident().intValue());
		}

		Cell row22cell12 = row22.getCell(13);

		if (row22cell12 != null) {
			row22cell12.setCellValue(brf96ARow1TO471.getR22_hni_non_resident() == null ? 0
					: brf96ARow1TO471.getR22_hni_non_resident().intValue());
		}

		Cell row22cell13 = row22.getCell(14);

		if (row22cell13 != null) {
			row22cell13.setCellValue(brf96ARow1TO471.getR22_individual_non_resident() == null ? 0
					: brf96ARow1TO471.getR22_individual_non_resident().intValue());
		}

		Cell row22cell14 = row22.getCell(15);

		if (row22cell14 != null) {
			row22cell14.setCellValue(brf96ARow1TO471.getR22_banking_non_resident() == null ? 0
					: brf96ARow1TO471.getR22_banking_non_resident().intValue());
		}

		Cell row22cell15 = row22.getCell(16);

		if (row22cell15 != null) {
			row22cell15.setCellValue(brf96ARow1TO471.getR22_trade_non_resident() == null ? 0
					: brf96ARow1TO471.getR22_trade_non_resident().intValue());
		}

		// ROW 24

		Row row24 = sheet.getRow(23);

		Cell row24cell1 = row24.getCell(2);

		if (row24cell1 != null) {
			row24cell1.setCellValue(brf96ARow1TO471.getR24_country() == null ? "0" : brf96ARow1TO471.getR24_country());
		}

		Cell row24cell2 = row24.getCell(3);

		if (row24cell2 != null) {
			row24cell2.setCellValue(brf96ARow1TO471.getR24_government_resident() == null ? 0
					: brf96ARow1TO471.getR24_government_resident().intValue());
		}

		Cell row24cell3 = row24.getCell(4);

		if (row24cell3 != null) {
			row24cell3.setCellValue(brf96ARow1TO471.getR24_gre_resident() == null ? 0
					: brf96ARow1TO471.getR24_gre_resident().intValue());
		}

		Cell row24cell4 = row24.getCell(5);

		if (row24cell4 != null) {
			row24cell4.setCellValue(brf96ARow1TO471.getR24_private_resident() == null ? 0
					: brf96ARow1TO471.getR24_private_resident().intValue());
		}

		Cell row24cell5 = row24.getCell(6);

		if (row24cell5 != null) {
			row24cell5.setCellValue(brf96ARow1TO471.getR24_hni_resident() == null ? 0
					: brf96ARow1TO471.getR24_hni_resident().intValue());
		}

		Cell row24cell6 = row24.getCell(7);

		if (row24cell6 != null) {
			row24cell6.setCellValue(brf96ARow1TO471.getR24_individual_resident() == null ? 0
					: brf96ARow1TO471.getR24_individual_resident().intValue());
		}

		Cell row24cell7 = row24.getCell(8);

		if (row24cell7 != null) {
			row24cell7.setCellValue(brf96ARow1TO471.getR24_banking_resident() == null ? 0
					: brf96ARow1TO471.getR24_banking_resident().intValue());
		}

		Cell row24cell8 = row24.getCell(9);

		if (row24cell8 != null) {
			row24cell8.setCellValue(brf96ARow1TO471.getR24_trade_resident() == null ? 0
					: brf96ARow1TO471.getR24_trade_resident().intValue());
		}

		Cell row24cell9 = row24.getCell(10);

		if (row24cell9 != null) {
			row24cell9.setCellValue(brf96ARow1TO471.getR24_government_non_resident() == null ? 0
					: brf96ARow1TO471.getR24_government_non_resident().intValue());
		}

		Cell row24cell10 = row24.getCell(11);

		if (row24cell10 != null) {
			row24cell10.setCellValue(brf96ARow1TO471.getR24_gre_non_resident() == null ? 0
					: brf96ARow1TO471.getR24_gre_non_resident().intValue());
		}

		Cell row24cell11 = row24.getCell(12);

		if (row24cell11 != null) {
			row24cell11.setCellValue(brf96ARow1TO471.getR24_private_non_resident() == null ? 0
					: brf96ARow1TO471.getR24_private_non_resident().intValue());
		}

		Cell row24cell12 = row24.getCell(13);

		if (row24cell12 != null) {
			row24cell12.setCellValue(brf96ARow1TO471.getR24_hni_non_resident() == null ? 0
					: brf96ARow1TO471.getR24_hni_non_resident().intValue());
		}

		Cell row24cell13 = row24.getCell(14);

		if (row24cell13 != null) {
			row24cell13.setCellValue(brf96ARow1TO471.getR24_individual_non_resident() == null ? 0
					: brf96ARow1TO471.getR24_individual_non_resident().intValue());
		}

		Cell row24cell14 = row24.getCell(15);

		if (row24cell14 != null) {
			row24cell14.setCellValue(brf96ARow1TO471.getR24_banking_non_resident() == null ? 0
					: brf96ARow1TO471.getR24_banking_non_resident().intValue());
		}

		Cell row24cell15 = row24.getCell(16);

		if (row24cell15 != null) {
			row24cell15.setCellValue(brf96ARow1TO471.getR24_trade_non_resident() == null ? 0
					: brf96ARow1TO471.getR24_trade_non_resident().intValue());
		}

		// ROW 25

		Row row25 = sheet.getRow(24);

		Cell row25cell1 = row25.getCell(2);

		if (row25cell1 != null) {
			row25cell1.setCellValue(brf96ARow1TO471.getR25_country() == null ? "0" : brf96ARow1TO471.getR25_country());
		}

		Cell row25cell2 = row25.getCell(3);

		if (row25cell2 != null) {
			row25cell2.setCellValue(brf96ARow1TO471.getR25_government_resident() == null ? 0
					: brf96ARow1TO471.getR25_government_resident().intValue());
		}

		Cell row25cell3 = row25.getCell(4);

		if (row25cell3 != null) {
			row25cell3.setCellValue(brf96ARow1TO471.getR25_gre_resident() == null ? 0
					: brf96ARow1TO471.getR25_gre_resident().intValue());
		}

		Cell row25cell4 = row25.getCell(5);

		if (row25cell4 != null) {
			row25cell4.setCellValue(brf96ARow1TO471.getR25_private_resident() == null ? 0
					: brf96ARow1TO471.getR25_private_resident().intValue());
		}

		Cell row25cell5 = row25.getCell(6);

		if (row25cell5 != null) {
			row25cell5.setCellValue(brf96ARow1TO471.getR25_hni_resident() == null ? 0
					: brf96ARow1TO471.getR25_hni_resident().intValue());
		}

		Cell row25cell6 = row25.getCell(7);

		if (row25cell6 != null) {
			row25cell6.setCellValue(brf96ARow1TO471.getR25_individual_resident() == null ? 0
					: brf96ARow1TO471.getR25_individual_resident().intValue());
		}

		Cell row25cell7 = row25.getCell(8);

		if (row25cell7 != null) {
			row25cell7.setCellValue(brf96ARow1TO471.getR25_banking_resident() == null ? 0
					: brf96ARow1TO471.getR25_banking_resident().intValue());
		}

		Cell row25cell8 = row25.getCell(9);

		if (row25cell8 != null) {
			row25cell8.setCellValue(brf96ARow1TO471.getR25_trade_resident() == null ? 0
					: brf96ARow1TO471.getR25_trade_resident().intValue());
		}

		Cell row25cell9 = row25.getCell(10);

		if (row25cell9 != null) {
			row25cell9.setCellValue(brf96ARow1TO471.getR25_government_non_resident() == null ? 0
					: brf96ARow1TO471.getR25_government_non_resident().intValue());
		}

		Cell row25cell10 = row25.getCell(11);

		if (row25cell10 != null) {
			row25cell10.setCellValue(brf96ARow1TO471.getR25_gre_non_resident() == null ? 0
					: brf96ARow1TO471.getR25_gre_non_resident().intValue());
		}

		Cell row25cell11 = row25.getCell(12);

		if (row25cell11 != null) {
			row25cell11.setCellValue(brf96ARow1TO471.getR25_private_non_resident() == null ? 0
					: brf96ARow1TO471.getR25_private_non_resident().intValue());
		}

		Cell row25cell12 = row25.getCell(13);

		if (row25cell12 != null) {
			row25cell12.setCellValue(brf96ARow1TO471.getR25_hni_non_resident() == null ? 0
					: brf96ARow1TO471.getR25_hni_non_resident().intValue());
		}

		Cell row25cell13 = row25.getCell(14);

		if (row25cell13 != null) {
			row25cell13.setCellValue(brf96ARow1TO471.getR25_individual_non_resident() == null ? 0
					: brf96ARow1TO471.getR25_individual_non_resident().intValue());
		}

		Cell row25cell14 = row25.getCell(15);

		if (row25cell14 != null) {
			row25cell14.setCellValue(brf96ARow1TO471.getR25_banking_non_resident() == null ? 0
					: brf96ARow1TO471.getR25_banking_non_resident().intValue());
		}

		Cell row25cell15 = row25.getCell(16);

		if (row25cell15 != null) {
			row25cell15.setCellValue(brf96ARow1TO471.getR25_trade_non_resident() == null ? 0
					: brf96ARow1TO471.getR25_trade_non_resident().intValue());
		}

		// ROW 26

		Row row26 = sheet.getRow(25);

		Cell row26cell1 = row26.getCell(2);

		if (row26cell1 != null) {
			row26cell1.setCellValue(brf96ARow1TO471.getR26_country() == null ? "0" : brf96ARow1TO471.getR26_country());
		}

		Cell row26cell2 = row26.getCell(3);

		if (row26cell2 != null) {
			row26cell2.setCellValue(brf96ARow1TO471.getR26_government_resident() == null ? 0
					: brf96ARow1TO471.getR26_government_resident().intValue());
		}

		Cell row26cell3 = row26.getCell(4);

		if (row26cell3 != null) {
			row26cell3.setCellValue(brf96ARow1TO471.getR26_gre_resident() == null ? 0
					: brf96ARow1TO471.getR26_gre_resident().intValue());
		}

		Cell row26cell4 = row26.getCell(5);

		if (row26cell4 != null) {
			row26cell4.setCellValue(brf96ARow1TO471.getR26_private_resident() == null ? 0
					: brf96ARow1TO471.getR26_private_resident().intValue());
		}

		Cell row26cell5 = row26.getCell(6);

		if (row26cell5 != null) {
			row26cell5.setCellValue(brf96ARow1TO471.getR26_hni_resident() == null ? 0
					: brf96ARow1TO471.getR26_hni_resident().intValue());
		}

		Cell row26cell6 = row26.getCell(7);

		if (row26cell6 != null) {
			row26cell6.setCellValue(brf96ARow1TO471.getR26_individual_resident() == null ? 0
					: brf96ARow1TO471.getR26_individual_resident().intValue());
		}

		Cell row26cell7 = row26.getCell(8);

		if (row26cell7 != null) {
			row26cell7.setCellValue(brf96ARow1TO471.getR26_banking_resident() == null ? 0
					: brf96ARow1TO471.getR26_banking_resident().intValue());
		}

		Cell row26cell8 = row26.getCell(9);

		if (row26cell8 != null) {
			row26cell8.setCellValue(brf96ARow1TO471.getR26_trade_resident() == null ? 0
					: brf96ARow1TO471.getR26_trade_resident().intValue());
		}

		Cell row26cell9 = row26.getCell(10);

		if (row26cell9 != null) {
			row26cell9.setCellValue(brf96ARow1TO471.getR26_government_non_resident() == null ? 0
					: brf96ARow1TO471.getR26_government_non_resident().intValue());
		}

		Cell row26cell10 = row26.getCell(11);

		if (row26cell10 != null) {
			row26cell10.setCellValue(brf96ARow1TO471.getR26_gre_non_resident() == null ? 0
					: brf96ARow1TO471.getR26_gre_non_resident().intValue());
		}

		Cell row26cell11 = row26.getCell(12);

		if (row26cell11 != null) {
			row26cell11.setCellValue(brf96ARow1TO471.getR26_private_non_resident() == null ? 0
					: brf96ARow1TO471.getR26_private_non_resident().intValue());
		}

		Cell row26cell12 = row26.getCell(13);

		if (row26cell12 != null) {
			row26cell12.setCellValue(brf96ARow1TO471.getR26_hni_non_resident() == null ? 0
					: brf96ARow1TO471.getR26_hni_non_resident().intValue());
		}

		Cell row26cell13 = row26.getCell(14);

		if (row26cell13 != null) {
			row26cell13.setCellValue(brf96ARow1TO471.getR26_individual_non_resident() == null ? 0
					: brf96ARow1TO471.getR26_individual_non_resident().intValue());
		}

		Cell row26cell14 = row26.getCell(15);

		if (row26cell14 != null) {
			row26cell14.setCellValue(brf96ARow1TO471.getR26_banking_non_resident() == null ? 0
					: brf96ARow1TO471.getR26_banking_non_resident().intValue());
		}

		Cell row26cell15 = row26.getCell(16);

		if (row26cell15 != null) {
			row26cell15.setCellValue(brf96ARow1TO471.getR26_trade_non_resident() == null ? 0
					: brf96ARow1TO471.getR26_trade_non_resident().intValue());
		}

		// ROW 27

		Row row27 = sheet.getRow(26);

		Cell row27cell1 = row27.getCell(2);

		if (row27cell1 != null) {
			row27cell1.setCellValue(brf96ARow1TO471.getR27_country() == null ? "0" : brf96ARow1TO471.getR27_country());
		}

		Cell row27cell2 = row27.getCell(3);

		if (row27cell2 != null) {
			row27cell2.setCellValue(brf96ARow1TO471.getR27_government_resident() == null ? 0
					: brf96ARow1TO471.getR27_government_resident().intValue());
		}

		Cell row27cell3 = row27.getCell(4);

		if (row27cell3 != null) {
			row27cell3.setCellValue(brf96ARow1TO471.getR27_gre_resident() == null ? 0
					: brf96ARow1TO471.getR27_gre_resident().intValue());
		}

		Cell row27cell4 = row27.getCell(5);

		if (row27cell4 != null) {
			row27cell4.setCellValue(brf96ARow1TO471.getR27_private_resident() == null ? 0
					: brf96ARow1TO471.getR27_private_resident().intValue());
		}

		Cell row27cell5 = row27.getCell(6);

		if (row27cell5 != null) {
			row27cell5.setCellValue(brf96ARow1TO471.getR27_hni_resident() == null ? 0
					: brf96ARow1TO471.getR27_hni_resident().intValue());
		}

		Cell row27cell6 = row27.getCell(7);

		if (row27cell6 != null) {
			row27cell6.setCellValue(brf96ARow1TO471.getR27_individual_resident() == null ? 0
					: brf96ARow1TO471.getR27_individual_resident().intValue());
		}

		Cell row27cell7 = row27.getCell(8);

		if (row27cell7 != null) {
			row27cell7.setCellValue(brf96ARow1TO471.getR27_banking_resident() == null ? 0
					: brf96ARow1TO471.getR27_banking_resident().intValue());
		}

		Cell row27cell8 = row27.getCell(9);

		if (row27cell8 != null) {
			row27cell8.setCellValue(brf96ARow1TO471.getR27_trade_resident() == null ? 0
					: brf96ARow1TO471.getR27_trade_resident().intValue());
		}

		Cell row27cell9 = row27.getCell(10);

		if (row27cell9 != null) {
			row27cell9.setCellValue(brf96ARow1TO471.getR27_government_non_resident() == null ? 0
					: brf96ARow1TO471.getR27_government_non_resident().intValue());
		}

		Cell row27cell10 = row27.getCell(11);

		if (row27cell10 != null) {
			row27cell10.setCellValue(brf96ARow1TO471.getR27_gre_non_resident() == null ? 0
					: brf96ARow1TO471.getR27_gre_non_resident().intValue());
		}

		Cell row27cell11 = row27.getCell(12);

		if (row27cell11 != null) {
			row27cell11.setCellValue(brf96ARow1TO471.getR27_private_non_resident() == null ? 0
					: brf96ARow1TO471.getR27_private_non_resident().intValue());
		}

		Cell row27cell12 = row27.getCell(13);

		if (row27cell12 != null) {
			row27cell12.setCellValue(brf96ARow1TO471.getR27_hni_non_resident() == null ? 0
					: brf96ARow1TO471.getR27_hni_non_resident().intValue());
		}

		Cell row27cell13 = row27.getCell(14);

		if (row27cell13 != null) {
			row27cell13.setCellValue(brf96ARow1TO471.getR27_individual_non_resident() == null ? 0
					: brf96ARow1TO471.getR27_individual_non_resident().intValue());
		}

		Cell row27cell14 = row27.getCell(15);

		if (row27cell14 != null) {
			row27cell14.setCellValue(brf96ARow1TO471.getR27_banking_non_resident() == null ? 0
					: brf96ARow1TO471.getR27_banking_non_resident().intValue());
		}

		Cell row27cell15 = row27.getCell(16);

		if (row27cell15 != null) {
			row27cell15.setCellValue(brf96ARow1TO471.getR27_trade_non_resident() == null ? 0
					: brf96ARow1TO471.getR27_trade_non_resident().intValue());
		}

		// ROW 28

		Row row28 = sheet.getRow(27);

		Cell row28cell1 = row28.getCell(2);

		if (row28cell1 != null) {
			row28cell1.setCellValue(brf96ARow1TO471.getR28_country() == null ? "0" : brf96ARow1TO471.getR28_country());
		}

		Cell row28cell2 = row28.getCell(3);

		if (row28cell2 != null) {
			row28cell2.setCellValue(brf96ARow1TO471.getR28_government_resident() == null ? 0
					: brf96ARow1TO471.getR28_government_resident().intValue());
		}

		Cell row28cell3 = row28.getCell(4);

		if (row28cell3 != null) {
			row28cell3.setCellValue(brf96ARow1TO471.getR28_gre_resident() == null ? 0
					: brf96ARow1TO471.getR28_gre_resident().intValue());
		}

		Cell row28cell4 = row28.getCell(5);

		if (row28cell4 != null) {
			row28cell4.setCellValue(brf96ARow1TO471.getR28_private_resident() == null ? 0
					: brf96ARow1TO471.getR28_private_resident().intValue());
		}

		Cell row28cell5 = row28.getCell(6);

		if (row28cell5 != null) {
			row28cell5.setCellValue(brf96ARow1TO471.getR28_hni_resident() == null ? 0
					: brf96ARow1TO471.getR28_hni_resident().intValue());
		}

		Cell row28cell6 = row28.getCell(7);

		if (row28cell6 != null) {
			row28cell6.setCellValue(brf96ARow1TO471.getR28_individual_resident() == null ? 0
					: brf96ARow1TO471.getR28_individual_resident().intValue());
		}

		Cell row28cell7 = row28.getCell(8);

		if (row28cell7 != null) {
			row28cell7.setCellValue(brf96ARow1TO471.getR28_banking_resident() == null ? 0
					: brf96ARow1TO471.getR28_banking_resident().intValue());
		}

		Cell row28cell8 = row28.getCell(9);

		if (row28cell8 != null) {
			row28cell8.setCellValue(brf96ARow1TO471.getR28_trade_resident() == null ? 0
					: brf96ARow1TO471.getR28_trade_resident().intValue());
		}

		Cell row28cell9 = row28.getCell(10);

		if (row28cell9 != null) {
			row28cell9.setCellValue(brf96ARow1TO471.getR28_government_non_resident() == null ? 0
					: brf96ARow1TO471.getR28_government_non_resident().intValue());
		}

		Cell row28cell10 = row28.getCell(11);

		if (row28cell10 != null) {
			row28cell10.setCellValue(brf96ARow1TO471.getR28_gre_non_resident() == null ? 0
					: brf96ARow1TO471.getR28_gre_non_resident().intValue());
		}

		Cell row28cell11 = row28.getCell(12);

		if (row28cell11 != null) {
			row28cell11.setCellValue(brf96ARow1TO471.getR28_private_non_resident() == null ? 0
					: brf96ARow1TO471.getR28_private_non_resident().intValue());
		}

		Cell row28cell12 = row28.getCell(13);

		if (row28cell12 != null) {
			row28cell12.setCellValue(brf96ARow1TO471.getR28_hni_non_resident() == null ? 0
					: brf96ARow1TO471.getR28_hni_non_resident().intValue());
		}

		Cell row28cell13 = row28.getCell(14);

		if (row28cell13 != null) {
			row28cell13.setCellValue(brf96ARow1TO471.getR28_individual_non_resident() == null ? 0
					: brf96ARow1TO471.getR28_individual_non_resident().intValue());
		}

		Cell row28cell14 = row28.getCell(15);

		if (row28cell14 != null) {
			row28cell14.setCellValue(brf96ARow1TO471.getR28_banking_non_resident() == null ? 0
					: brf96ARow1TO471.getR28_banking_non_resident().intValue());
		}

		Cell row28cell15 = row28.getCell(16);

		if (row28cell15 != null) {
			row28cell15.setCellValue(brf96ARow1TO471.getR28_trade_non_resident() == null ? 0
					: brf96ARow1TO471.getR28_trade_non_resident().intValue());
		}

		// ROW 29

		Row row29 = sheet.getRow(28);

		Cell row29cell1 = row29.getCell(2);

		if (row29cell1 != null) {
			row29cell1.setCellValue(brf96ARow1TO471.getR29_country() == null ? "0" : brf96ARow1TO471.getR29_country());
		}

		Cell row29cell2 = row29.getCell(3);

		if (row29cell2 != null) {
			row29cell2.setCellValue(brf96ARow1TO471.getR29_government_resident() == null ? 0
					: brf96ARow1TO471.getR29_government_resident().intValue());
		}

		Cell row29cell3 = row29.getCell(4);

		if (row29cell3 != null) {
			row29cell3.setCellValue(brf96ARow1TO471.getR29_gre_resident() == null ? 0
					: brf96ARow1TO471.getR29_gre_resident().intValue());
		}

		Cell row29cell4 = row29.getCell(5);

		if (row29cell4 != null) {
			row29cell4.setCellValue(brf96ARow1TO471.getR29_private_resident() == null ? 0
					: brf96ARow1TO471.getR29_private_resident().intValue());
		}

		Cell row29cell5 = row29.getCell(6);

		if (row29cell5 != null) {
			row29cell5.setCellValue(brf96ARow1TO471.getR29_hni_resident() == null ? 0
					: brf96ARow1TO471.getR29_hni_resident().intValue());
		}

		Cell row29cell6 = row29.getCell(7);

		if (row29cell6 != null) {
			row29cell6.setCellValue(brf96ARow1TO471.getR29_individual_resident() == null ? 0
					: brf96ARow1TO471.getR29_individual_resident().intValue());
		}

		Cell row29cell7 = row29.getCell(8);

		if (row29cell7 != null) {
			row29cell7.setCellValue(brf96ARow1TO471.getR29_banking_resident() == null ? 0
					: brf96ARow1TO471.getR29_banking_resident().intValue());
		}

		Cell row29cell8 = row29.getCell(9);

		if (row29cell8 != null) {
			row29cell8.setCellValue(brf96ARow1TO471.getR29_trade_resident() == null ? 0
					: brf96ARow1TO471.getR29_trade_resident().intValue());
		}

		Cell row29cell9 = row29.getCell(10);

		if (row29cell9 != null) {
			row29cell9.setCellValue(brf96ARow1TO471.getR29_government_non_resident() == null ? 0
					: brf96ARow1TO471.getR29_government_non_resident().intValue());
		}

		Cell row29cell10 = row29.getCell(11);

		if (row29cell10 != null) {
			row29cell10.setCellValue(brf96ARow1TO471.getR29_gre_non_resident() == null ? 0
					: brf96ARow1TO471.getR29_gre_non_resident().intValue());
		}

		Cell row29cell11 = row29.getCell(12);

		if (row29cell11 != null) {
			row29cell11.setCellValue(brf96ARow1TO471.getR29_private_non_resident() == null ? 0
					: brf96ARow1TO471.getR29_private_non_resident().intValue());
		}

		Cell row29cell12 = row29.getCell(13);

		if (row29cell12 != null) {
			row29cell12.setCellValue(brf96ARow1TO471.getR29_hni_non_resident() == null ? 0
					: brf96ARow1TO471.getR29_hni_non_resident().intValue());
		}

		Cell row29cell13 = row29.getCell(14);

		if (row29cell13 != null) {
			row29cell13.setCellValue(brf96ARow1TO471.getR29_individual_non_resident() == null ? 0
					: brf96ARow1TO471.getR29_individual_non_resident().intValue());
		}

		Cell row29cell14 = row29.getCell(15);

		if (row29cell14 != null) {
			row29cell14.setCellValue(brf96ARow1TO471.getR29_banking_non_resident() == null ? 0
					: brf96ARow1TO471.getR29_banking_non_resident().intValue());
		}

		Cell row29cell15 = row29.getCell(16);

		if (row29cell15 != null) {
			row29cell15.setCellValue(brf96ARow1TO471.getR29_trade_non_resident() == null ? 0
					: brf96ARow1TO471.getR29_trade_non_resident().intValue());
		}

		// ROW 30

		Row row30 = sheet.getRow(29);

		Cell row30cell1 = row30.getCell(2);

		if (row30cell1 != null) {
			row30cell1.setCellValue(brf96ARow1TO471.getR30_country() == null ? "0" : brf96ARow1TO471.getR30_country());
		}

		Cell row30cell2 = row30.getCell(3);

		if (row30cell2 != null) {
			row30cell2.setCellValue(brf96ARow1TO471.getR30_government_resident() == null ? 0
					: brf96ARow1TO471.getR30_government_resident().intValue());
		}

		Cell row30cell3 = row30.getCell(4);

		if (row30cell3 != null) {
			row30cell3.setCellValue(brf96ARow1TO471.getR30_gre_resident() == null ? 0
					: brf96ARow1TO471.getR30_gre_resident().intValue());
		}

		Cell row30cell4 = row30.getCell(5);

		if (row30cell4 != null) {
			row30cell4.setCellValue(brf96ARow1TO471.getR30_private_resident() == null ? 0
					: brf96ARow1TO471.getR30_private_resident().intValue());
		}

		Cell row30cell5 = row30.getCell(6);

		if (row30cell5 != null) {
			row30cell5.setCellValue(brf96ARow1TO471.getR30_hni_resident() == null ? 0
					: brf96ARow1TO471.getR30_hni_resident().intValue());
		}

		Cell row30cell6 = row30.getCell(7);

		if (row30cell6 != null) {
			row30cell6.setCellValue(brf96ARow1TO471.getR30_individual_resident() == null ? 0
					: brf96ARow1TO471.getR30_individual_resident().intValue());
		}

		Cell row30cell7 = row30.getCell(8);

		if (row30cell7 != null) {
			row30cell7.setCellValue(brf96ARow1TO471.getR30_banking_resident() == null ? 0
					: brf96ARow1TO471.getR30_banking_resident().intValue());
		}

		Cell row30cell8 = row30.getCell(9);

		if (row30cell8 != null) {
			row30cell8.setCellValue(brf96ARow1TO471.getR30_trade_resident() == null ? 0
					: brf96ARow1TO471.getR30_trade_resident().intValue());
		}

		Cell row30cell9 = row30.getCell(10);

		if (row30cell9 != null) {
			row30cell9.setCellValue(brf96ARow1TO471.getR30_government_non_resident() == null ? 0
					: brf96ARow1TO471.getR30_government_non_resident().intValue());
		}

		Cell row30cell10 = row30.getCell(11);

		if (row30cell10 != null) {
			row30cell10.setCellValue(brf96ARow1TO471.getR30_gre_non_resident() == null ? 0
					: brf96ARow1TO471.getR30_gre_non_resident().intValue());
		}

		Cell row30cell11 = row30.getCell(12);

		if (row30cell11 != null) {
			row30cell11.setCellValue(brf96ARow1TO471.getR30_private_non_resident() == null ? 0
					: brf96ARow1TO471.getR30_private_non_resident().intValue());
		}

		Cell row30cell12 = row30.getCell(13);

		if (row30cell12 != null) {
			row30cell12.setCellValue(brf96ARow1TO471.getR30_hni_non_resident() == null ? 0
					: brf96ARow1TO471.getR30_hni_non_resident().intValue());
		}

		Cell row30cell13 = row30.getCell(14);

		if (row30cell13 != null) {
			row30cell13.setCellValue(brf96ARow1TO471.getR30_individual_non_resident() == null ? 0
					: brf96ARow1TO471.getR30_individual_non_resident().intValue());
		}

		Cell row30cell14 = row30.getCell(15);

		if (row30cell14 != null) {
			row30cell14.setCellValue(brf96ARow1TO471.getR30_banking_non_resident() == null ? 0
					: brf96ARow1TO471.getR30_banking_non_resident().intValue());
		}

		Cell row30cell15 = row30.getCell(16);

		if (row30cell15 != null) {
			row30cell15.setCellValue(brf96ARow1TO471.getR30_trade_non_resident() == null ? 0
					: brf96ARow1TO471.getR30_trade_non_resident().intValue());
		}

		// ROW 31

		Row row31 = sheet.getRow(30);

		Cell row31cell1 = row31.getCell(2);

		if (row31cell1 != null) {
			row31cell1.setCellValue(brf96ARow1TO471.getR31_country() == null ? "0" : brf96ARow1TO471.getR31_country());
		}

		Cell row31cell2 = row31.getCell(3);

		if (row31cell2 != null) {
			row31cell2.setCellValue(brf96ARow1TO471.getR31_government_resident() == null ? 0
					: brf96ARow1TO471.getR31_government_resident().intValue());
		}

		Cell row31cell3 = row31.getCell(4);

		if (row31cell3 != null) {
			row31cell3.setCellValue(brf96ARow1TO471.getR31_gre_resident() == null ? 0
					: brf96ARow1TO471.getR31_gre_resident().intValue());
		}

		Cell row31cell4 = row31.getCell(5);

		if (row31cell4 != null) {
			row31cell4.setCellValue(brf96ARow1TO471.getR31_private_resident() == null ? 0
					: brf96ARow1TO471.getR31_private_resident().intValue());
		}

		Cell row31cell5 = row31.getCell(6);

		if (row31cell5 != null) {
			row31cell5.setCellValue(brf96ARow1TO471.getR31_hni_resident() == null ? 0
					: brf96ARow1TO471.getR31_hni_resident().intValue());
		}

		Cell row31cell6 = row31.getCell(7);

		if (row31cell6 != null) {
			row31cell6.setCellValue(brf96ARow1TO471.getR31_individual_resident() == null ? 0
					: brf96ARow1TO471.getR31_individual_resident().intValue());
		}

		Cell row31cell7 = row31.getCell(8);

		if (row31cell7 != null) {
			row31cell7.setCellValue(brf96ARow1TO471.getR31_banking_resident() == null ? 0
					: brf96ARow1TO471.getR31_banking_resident().intValue());
		}

		Cell row31cell8 = row31.getCell(9);

		if (row31cell8 != null) {
			row31cell8.setCellValue(brf96ARow1TO471.getR31_trade_resident() == null ? 0
					: brf96ARow1TO471.getR31_trade_resident().intValue());
		}

		Cell row31cell9 = row31.getCell(10);

		if (row31cell9 != null) {
			row31cell9.setCellValue(brf96ARow1TO471.getR31_government_non_resident() == null ? 0
					: brf96ARow1TO471.getR31_government_non_resident().intValue());
		}

		Cell row31cell10 = row31.getCell(11);

		if (row31cell10 != null) {
			row31cell10.setCellValue(brf96ARow1TO471.getR31_gre_non_resident() == null ? 0
					: brf96ARow1TO471.getR31_gre_non_resident().intValue());
		}

		Cell row31cell11 = row31.getCell(12);

		if (row31cell11 != null) {
			row31cell11.setCellValue(brf96ARow1TO471.getR31_private_non_resident() == null ? 0
					: brf96ARow1TO471.getR31_private_non_resident().intValue());
		}

		Cell row31cell12 = row31.getCell(13);

		if (row31cell12 != null) {
			row31cell12.setCellValue(brf96ARow1TO471.getR31_hni_non_resident() == null ? 0
					: brf96ARow1TO471.getR31_hni_non_resident().intValue());
		}

		Cell row31cell13 = row31.getCell(14);

		if (row31cell13 != null) {
			row31cell13.setCellValue(brf96ARow1TO471.getR31_individual_non_resident() == null ? 0
					: brf96ARow1TO471.getR31_individual_non_resident().intValue());
		}

		Cell row31cell14 = row31.getCell(15);

		if (row31cell14 != null) {
			row31cell14.setCellValue(brf96ARow1TO471.getR31_banking_non_resident() == null ? 0
					: brf96ARow1TO471.getR31_banking_non_resident().intValue());
		}

		Cell row31cell15 = row31.getCell(16);

		if (row31cell15 != null) {
			row31cell15.setCellValue(brf96ARow1TO471.getR31_trade_non_resident() == null ? 0
					: brf96ARow1TO471.getR31_trade_non_resident().intValue());
		}

		// ROW 32

		Row row32 = sheet.getRow(32);

		Cell row32cell1 = row32.getCell(2);

		if (row32cell1 != null) {
			row32cell1.setCellValue(brf96ARow1TO471.getR32_country() == null ? "0" : brf96ARow1TO471.getR32_country());
		}

		Cell row32cell2 = row32.getCell(3);

		if (row32cell2 != null) {
			row32cell2.setCellValue(brf96ARow1TO471.getR32_government_resident() == null ? 0
					: brf96ARow1TO471.getR32_government_resident().intValue());
		}

		Cell row32cell3 = row32.getCell(4);

		if (row32cell3 != null) {
			row32cell3.setCellValue(brf96ARow1TO471.getR32_gre_resident() == null ? 0
					: brf96ARow1TO471.getR32_gre_resident().intValue());
		}

		Cell row32cell4 = row32.getCell(5);

		if (row32cell4 != null) {
			row32cell4.setCellValue(brf96ARow1TO471.getR32_private_resident() == null ? 0
					: brf96ARow1TO471.getR32_private_resident().intValue());
		}

		Cell row32cell5 = row32.getCell(6);

		if (row32cell5 != null) {
			row32cell5.setCellValue(brf96ARow1TO471.getR32_hni_resident() == null ? 0
					: brf96ARow1TO471.getR32_hni_resident().intValue());
		}

		Cell row32cell6 = row32.getCell(7);

		if (row32cell6 != null) {
			row32cell6.setCellValue(brf96ARow1TO471.getR32_individual_resident() == null ? 0
					: brf96ARow1TO471.getR32_individual_resident().intValue());
		}

		Cell row32cell7 = row32.getCell(8);

		if (row32cell7 != null) {
			row32cell7.setCellValue(brf96ARow1TO471.getR32_banking_resident() == null ? 0
					: brf96ARow1TO471.getR32_banking_resident().intValue());
		}

		Cell row32cell8 = row32.getCell(9);

		if (row32cell8 != null) {
			row32cell8.setCellValue(brf96ARow1TO471.getR32_trade_resident() == null ? 0
					: brf96ARow1TO471.getR32_trade_resident().intValue());
		}

		Cell row32cell9 = row32.getCell(10);

		if (row32cell9 != null) {
			row32cell9.setCellValue(brf96ARow1TO471.getR32_government_non_resident() == null ? 0
					: brf96ARow1TO471.getR32_government_non_resident().intValue());
		}

		Cell row32cell10 = row32.getCell(11);

		if (row32cell10 != null) {
			row32cell10.setCellValue(brf96ARow1TO471.getR32_gre_non_resident() == null ? 0
					: brf96ARow1TO471.getR32_gre_non_resident().intValue());
		}

		Cell row32cell11 = row32.getCell(12);

		if (row32cell11 != null) {
			row32cell11.setCellValue(brf96ARow1TO471.getR32_private_non_resident() == null ? 0
					: brf96ARow1TO471.getR32_private_non_resident().intValue());
		}

		Cell row32cell12 = row32.getCell(13);

		if (row32cell12 != null) {
			row32cell12.setCellValue(brf96ARow1TO471.getR32_hni_non_resident() == null ? 0
					: brf96ARow1TO471.getR32_hni_non_resident().intValue());
		}

		Cell row32cell13 = row32.getCell(14);

		if (row32cell13 != null) {
			row32cell13.setCellValue(brf96ARow1TO471.getR32_individual_non_resident() == null ? 0
					: brf96ARow1TO471.getR32_individual_non_resident().intValue());
		}

		Cell row32cell14 = row32.getCell(15);

		if (row32cell14 != null) {
			row32cell14.setCellValue(brf96ARow1TO471.getR32_banking_non_resident() == null ? 0
					: brf96ARow1TO471.getR32_banking_non_resident().intValue());
		}

		Cell row32cell15 = row32.getCell(16);

		if (row32cell15 != null) {
			row32cell15.setCellValue(brf96ARow1TO471.getR32_trade_non_resident() == null ? 0
					: brf96ARow1TO471.getR32_trade_non_resident().intValue());
		}

		// ROW 33

		Row row33 = sheet.getRow(32);

		Cell row33cell1 = row33.getCell(2);

		if (row33cell1 != null) {
			row33cell1.setCellValue(brf96ARow1TO471.getR33_country() == null ? "0" : brf96ARow1TO471.getR33_country());
		}

		Cell row33cell2 = row33.getCell(3);

		if (row33cell2 != null) {
			row33cell2.setCellValue(brf96ARow1TO471.getR33_government_resident() == null ? 0
					: brf96ARow1TO471.getR33_government_resident().intValue());
		}

		Cell row33cell3 = row33.getCell(4);

		if (row33cell3 != null) {
			row33cell3.setCellValue(brf96ARow1TO471.getR33_gre_resident() == null ? 0
					: brf96ARow1TO471.getR33_gre_resident().intValue());
		}

		Cell row33cell4 = row33.getCell(5);

		if (row33cell4 != null) {
			row33cell4.setCellValue(brf96ARow1TO471.getR33_private_resident() == null ? 0
					: brf96ARow1TO471.getR33_private_resident().intValue());
		}

		Cell row33cell5 = row33.getCell(6);

		if (row33cell5 != null) {
			row33cell5.setCellValue(brf96ARow1TO471.getR33_hni_resident() == null ? 0
					: brf96ARow1TO471.getR33_hni_resident().intValue());
		}

		Cell row33cell6 = row33.getCell(7);

		if (row33cell6 != null) {
			row33cell6.setCellValue(brf96ARow1TO471.getR33_individual_resident() == null ? 0
					: brf96ARow1TO471.getR33_individual_resident().intValue());
		}

		Cell row33cell7 = row33.getCell(8);

		if (row33cell7 != null) {
			row33cell7.setCellValue(brf96ARow1TO471.getR33_banking_resident() == null ? 0
					: brf96ARow1TO471.getR33_banking_resident().intValue());
		}

		Cell row33cell8 = row33.getCell(9);

		if (row33cell8 != null) {
			row33cell8.setCellValue(brf96ARow1TO471.getR33_trade_resident() == null ? 0
					: brf96ARow1TO471.getR33_trade_resident().intValue());
		}

		Cell row33cell9 = row33.getCell(10);

		if (row33cell9 != null) {
			row33cell9.setCellValue(brf96ARow1TO471.getR33_government_non_resident() == null ? 0
					: brf96ARow1TO471.getR33_government_non_resident().intValue());
		}

		Cell row33cell10 = row33.getCell(11);

		if (row33cell10 != null) {
			row33cell10.setCellValue(brf96ARow1TO471.getR33_gre_non_resident() == null ? 0
					: brf96ARow1TO471.getR33_gre_non_resident().intValue());
		}

		Cell row33cell11 = row33.getCell(12);

		if (row33cell11 != null) {
			row33cell11.setCellValue(brf96ARow1TO471.getR33_private_non_resident() == null ? 0
					: brf96ARow1TO471.getR33_private_non_resident().intValue());
		}

		Cell row33cell12 = row33.getCell(13);

		if (row33cell12 != null) {
			row33cell12.setCellValue(brf96ARow1TO471.getR33_hni_non_resident() == null ? 0
					: brf96ARow1TO471.getR33_hni_non_resident().intValue());
		}

		Cell row33cell13 = row33.getCell(14);

		if (row33cell13 != null) {
			row33cell13.setCellValue(brf96ARow1TO471.getR33_individual_non_resident() == null ? 0
					: brf96ARow1TO471.getR33_individual_non_resident().intValue());
		}

		Cell row33cell14 = row33.getCell(15);

		if (row33cell14 != null) {
			row33cell14.setCellValue(brf96ARow1TO471.getR33_banking_non_resident() == null ? 0
					: brf96ARow1TO471.getR33_banking_non_resident().intValue());
		}

		Cell row33cell15 = row33.getCell(16);

		if (row33cell15 != null) {
			row33cell15.setCellValue(brf96ARow1TO471.getR33_trade_non_resident() == null ? 0
					: brf96ARow1TO471.getR33_trade_non_resident().intValue());
		}

		// ROW 34

		Row row34 = sheet.getRow(33);

		Cell row34cell1 = row34.getCell(2);

		if (row34cell1 != null) {
			row34cell1.setCellValue(brf96ARow1TO471.getR34_country() == null ? "0" : brf96ARow1TO471.getR34_country());
		}

		Cell row34cell2 = row34.getCell(3);

		if (row34cell2 != null) {
			row34cell2.setCellValue(brf96ARow1TO471.getR34_government_resident() == null ? 0
					: brf96ARow1TO471.getR34_government_resident().intValue());
		}

		Cell row34cell3 = row34.getCell(4);

		if (row34cell3 != null) {
			row34cell3.setCellValue(brf96ARow1TO471.getR34_gre_resident() == null ? 0
					: brf96ARow1TO471.getR34_gre_resident().intValue());
		}

		Cell row34cell4 = row34.getCell(5);

		if (row34cell4 != null) {
			row34cell4.setCellValue(brf96ARow1TO471.getR34_private_resident() == null ? 0
					: brf96ARow1TO471.getR34_private_resident().intValue());
		}

		Cell row34cell5 = row34.getCell(6);

		if (row34cell5 != null) {
			row34cell5.setCellValue(brf96ARow1TO471.getR34_hni_resident() == null ? 0
					: brf96ARow1TO471.getR34_hni_resident().intValue());
		}

		Cell row34cell6 = row34.getCell(7);

		if (row34cell6 != null) {
			row34cell6.setCellValue(brf96ARow1TO471.getR34_individual_resident() == null ? 0
					: brf96ARow1TO471.getR34_individual_resident().intValue());
		}

		Cell row34cell7 = row34.getCell(8);

		if (row34cell7 != null) {
			row34cell7.setCellValue(brf96ARow1TO471.getR34_banking_resident() == null ? 0
					: brf96ARow1TO471.getR34_banking_resident().intValue());
		}

		Cell row34cell8 = row34.getCell(9);

		if (row34cell8 != null) {
			row34cell8.setCellValue(brf96ARow1TO471.getR34_trade_resident() == null ? 0
					: brf96ARow1TO471.getR34_trade_resident().intValue());
		}

		Cell row34cell9 = row34.getCell(10);

		if (row34cell9 != null) {
			row34cell9.setCellValue(brf96ARow1TO471.getR34_government_non_resident() == null ? 0
					: brf96ARow1TO471.getR34_government_non_resident().intValue());
		}

		Cell row34cell10 = row34.getCell(11);

		if (row34cell10 != null) {
			row34cell10.setCellValue(brf96ARow1TO471.getR34_gre_non_resident() == null ? 0
					: brf96ARow1TO471.getR34_gre_non_resident().intValue());
		}

		Cell row34cell11 = row34.getCell(12);

		if (row34cell11 != null) {
			row34cell11.setCellValue(brf96ARow1TO471.getR34_private_non_resident() == null ? 0
					: brf96ARow1TO471.getR34_private_non_resident().intValue());
		}

		Cell row34cell12 = row34.getCell(13);

		if (row34cell12 != null) {
			row34cell12.setCellValue(brf96ARow1TO471.getR34_hni_non_resident() == null ? 0
					: brf96ARow1TO471.getR34_hni_non_resident().intValue());
		}

		Cell row34cell13 = row34.getCell(14);

		if (row34cell13 != null) {
			row34cell13.setCellValue(brf96ARow1TO471.getR34_individual_non_resident() == null ? 0
					: brf96ARow1TO471.getR34_individual_non_resident().intValue());
		}

		Cell row34cell14 = row34.getCell(15);

		if (row34cell14 != null) {
			row34cell14.setCellValue(brf96ARow1TO471.getR34_banking_non_resident() == null ? 0
					: brf96ARow1TO471.getR34_banking_non_resident().intValue());
		}

		Cell row34cell15 = row34.getCell(16);

		if (row34cell15 != null) {
			row34cell15.setCellValue(brf96ARow1TO471.getR34_trade_non_resident() == null ? 0
					: brf96ARow1TO471.getR34_trade_non_resident().intValue());
		}

		// ROW 35

		Row row35 = sheet.getRow(34);

		Cell row35cell1 = row35.getCell(2);

		if (row35cell1 != null) {
			row35cell1.setCellValue(brf96ARow1TO471.getR35_country() == null ? "0" : brf96ARow1TO471.getR35_country());
		}

		Cell row35cell2 = row35.getCell(3);

		if (row35cell2 != null) {
			row35cell2.setCellValue(brf96ARow1TO471.getR35_government_resident() == null ? 0
					: brf96ARow1TO471.getR35_government_resident().intValue());
		}

		Cell row35cell3 = row35.getCell(4);

		if (row35cell3 != null) {
			row35cell3.setCellValue(brf96ARow1TO471.getR35_gre_resident() == null ? 0
					: brf96ARow1TO471.getR35_gre_resident().intValue());
		}

		Cell row35cell4 = row35.getCell(5);

		if (row35cell4 != null) {
			row35cell4.setCellValue(brf96ARow1TO471.getR35_private_resident() == null ? 0
					: brf96ARow1TO471.getR35_private_resident().intValue());
		}

		Cell row35cell5 = row35.getCell(6);

		if (row35cell5 != null) {
			row35cell5.setCellValue(brf96ARow1TO471.getR35_hni_resident() == null ? 0
					: brf96ARow1TO471.getR35_hni_resident().intValue());
		}

		Cell row35cell6 = row35.getCell(7);

		if (row35cell6 != null) {
			row35cell6.setCellValue(brf96ARow1TO471.getR35_individual_resident() == null ? 0
					: brf96ARow1TO471.getR35_individual_resident().intValue());
		}

		Cell row35cell7 = row35.getCell(8);

		if (row35cell7 != null) {
			row35cell7.setCellValue(brf96ARow1TO471.getR35_banking_resident() == null ? 0
					: brf96ARow1TO471.getR35_banking_resident().intValue());
		}

		Cell row35cell8 = row35.getCell(9);

		if (row35cell8 != null) {
			row35cell8.setCellValue(brf96ARow1TO471.getR35_trade_resident() == null ? 0
					: brf96ARow1TO471.getR35_trade_resident().intValue());
		}

		Cell row35cell9 = row35.getCell(10);

		if (row35cell9 != null) {
			row35cell9.setCellValue(brf96ARow1TO471.getR35_government_non_resident() == null ? 0
					: brf96ARow1TO471.getR35_government_non_resident().intValue());
		}

		Cell row35cell10 = row35.getCell(11);

		if (row35cell10 != null) {
			row35cell10.setCellValue(brf96ARow1TO471.getR35_gre_non_resident() == null ? 0
					: brf96ARow1TO471.getR35_gre_non_resident().intValue());
		}

		Cell row35cell11 = row35.getCell(12);

		if (row35cell11 != null) {
			row35cell11.setCellValue(brf96ARow1TO471.getR35_private_non_resident() == null ? 0
					: brf96ARow1TO471.getR35_private_non_resident().intValue());
		}

		Cell row35cell12 = row35.getCell(13);

		if (row35cell12 != null) {
			row35cell12.setCellValue(brf96ARow1TO471.getR35_hni_non_resident() == null ? 0
					: brf96ARow1TO471.getR35_hni_non_resident().intValue());
		}

		Cell row35cell13 = row35.getCell(14);

		if (row35cell13 != null) {
			row35cell13.setCellValue(brf96ARow1TO471.getR35_individual_non_resident() == null ? 0
					: brf96ARow1TO471.getR35_individual_non_resident().intValue());
		}

		Cell row35cell14 = row35.getCell(15);

		if (row35cell14 != null) {
			row35cell14.setCellValue(brf96ARow1TO471.getR35_banking_non_resident() == null ? 0
					: brf96ARow1TO471.getR35_banking_non_resident().intValue());
		}

		Cell row35cell15 = row35.getCell(16);

		if (row35cell15 != null) {
			row35cell15.setCellValue(brf96ARow1TO471.getR35_trade_non_resident() == null ? 0
					: brf96ARow1TO471.getR35_trade_non_resident().intValue());
		}

		// ROW 36

		Row row36 = sheet.getRow(35);

		Cell row36cell1 = row36.getCell(2);

		if (row36cell1 != null) {
			row36cell1.setCellValue(brf96ARow1TO471.getR36_country() == null ? "0" : brf96ARow1TO471.getR36_country());
		}

		Cell row36cell2 = row36.getCell(3);

		if (row36cell2 != null) {
			row36cell2.setCellValue(brf96ARow1TO471.getR36_government_resident() == null ? 0
					: brf96ARow1TO471.getR36_government_resident().intValue());
		}

		Cell row36cell3 = row36.getCell(4);

		if (row36cell3 != null) {
			row36cell3.setCellValue(brf96ARow1TO471.getR36_gre_resident() == null ? 0
					: brf96ARow1TO471.getR36_gre_resident().intValue());
		}

		Cell row36cell4 = row36.getCell(5);

		if (row36cell4 != null) {
			row36cell4.setCellValue(brf96ARow1TO471.getR36_private_resident() == null ? 0
					: brf96ARow1TO471.getR36_private_resident().intValue());
		}

		Cell row36cell5 = row36.getCell(6);

		if (row36cell5 != null) {
			row36cell5.setCellValue(brf96ARow1TO471.getR36_hni_resident() == null ? 0
					: brf96ARow1TO471.getR36_hni_resident().intValue());
		}

		Cell row36cell6 = row36.getCell(7);

		if (row36cell6 != null) {
			row36cell6.setCellValue(brf96ARow1TO471.getR36_individual_resident() == null ? 0
					: brf96ARow1TO471.getR36_individual_resident().intValue());
		}

		Cell row36cell7 = row36.getCell(8);

		if (row36cell7 != null) {
			row36cell7.setCellValue(brf96ARow1TO471.getR36_banking_resident() == null ? 0
					: brf96ARow1TO471.getR36_banking_resident().intValue());
		}

		Cell row36cell8 = row36.getCell(9);

		if (row36cell8 != null) {
			row36cell8.setCellValue(brf96ARow1TO471.getR36_trade_resident() == null ? 0
					: brf96ARow1TO471.getR36_trade_resident().intValue());
		}

		Cell row36cell9 = row36.getCell(10);

		if (row36cell9 != null) {
			row36cell9.setCellValue(brf96ARow1TO471.getR36_government_non_resident() == null ? 0
					: brf96ARow1TO471.getR36_government_non_resident().intValue());
		}

		Cell row36cell10 = row36.getCell(11);

		if (row36cell10 != null) {
			row36cell10.setCellValue(brf96ARow1TO471.getR36_gre_non_resident() == null ? 0
					: brf96ARow1TO471.getR36_gre_non_resident().intValue());
		}

		Cell row36cell11 = row36.getCell(12);

		if (row36cell11 != null) {
			row36cell11.setCellValue(brf96ARow1TO471.getR36_private_non_resident() == null ? 0
					: brf96ARow1TO471.getR36_private_non_resident().intValue());
		}

		Cell row36cell12 = row36.getCell(13);

		if (row36cell12 != null) {
			row36cell12.setCellValue(brf96ARow1TO471.getR36_hni_non_resident() == null ? 0
					: brf96ARow1TO471.getR36_hni_non_resident().intValue());
		}

		Cell row36cell13 = row36.getCell(14);

		if (row36cell13 != null) {
			row36cell13.setCellValue(brf96ARow1TO471.getR36_individual_non_resident() == null ? 0
					: brf96ARow1TO471.getR36_individual_non_resident().intValue());
		}

		Cell row36cell14 = row36.getCell(15);

		if (row36cell14 != null) {
			row36cell14.setCellValue(brf96ARow1TO471.getR36_banking_non_resident() == null ? 0
					: brf96ARow1TO471.getR36_banking_non_resident().intValue());
		}

		Cell row36cell15 = row36.getCell(16);

		if (row36cell15 != null) {
			row36cell15.setCellValue(brf96ARow1TO471.getR36_trade_non_resident() == null ? 0
					: brf96ARow1TO471.getR36_trade_non_resident().intValue());
		}

		// ROW 37

		Row row37 = sheet.getRow(36);

		Cell row37cell1 = row37.getCell(2);

		if (row37cell1 != null) {
			row37cell1.setCellValue(brf96ARow1TO471.getR37_country() == null ? "0" : brf96ARow1TO471.getR37_country());
		}

		Cell row37cell2 = row37.getCell(3);

		if (row37cell2 != null) {
			row37cell2.setCellValue(brf96ARow1TO471.getR37_government_resident() == null ? 0
					: brf96ARow1TO471.getR37_government_resident().intValue());
		}

		Cell row37cell3 = row37.getCell(4);

		if (row37cell3 != null) {
			row37cell3.setCellValue(brf96ARow1TO471.getR37_gre_resident() == null ? 0
					: brf96ARow1TO471.getR37_gre_resident().intValue());
		}

		Cell row37cell4 = row37.getCell(5);

		if (row37cell4 != null) {
			row37cell4.setCellValue(brf96ARow1TO471.getR37_private_resident() == null ? 0
					: brf96ARow1TO471.getR37_private_resident().intValue());
		}

		Cell row37cell5 = row37.getCell(6);

		if (row37cell5 != null) {
			row37cell5.setCellValue(brf96ARow1TO471.getR37_hni_resident() == null ? 0
					: brf96ARow1TO471.getR37_hni_resident().intValue());
		}

		Cell row37cell6 = row37.getCell(7);

		if (row37cell6 != null) {
			row37cell6.setCellValue(brf96ARow1TO471.getR37_individual_resident() == null ? 0
					: brf96ARow1TO471.getR37_individual_resident().intValue());
		}

		Cell row37cell7 = row37.getCell(8);

		if (row37cell7 != null) {
			row37cell7.setCellValue(brf96ARow1TO471.getR37_banking_resident() == null ? 0
					: brf96ARow1TO471.getR37_banking_resident().intValue());
		}

		Cell row37cell8 = row37.getCell(9);

		if (row37cell8 != null) {
			row37cell8.setCellValue(brf96ARow1TO471.getR37_trade_resident() == null ? 0
					: brf96ARow1TO471.getR37_trade_resident().intValue());
		}

		Cell row37cell9 = row37.getCell(10);

		if (row37cell9 != null) {
			row37cell9.setCellValue(brf96ARow1TO471.getR37_government_non_resident() == null ? 0
					: brf96ARow1TO471.getR37_government_non_resident().intValue());
		}

		Cell row37cell10 = row37.getCell(11);

		if (row37cell10 != null) {
			row37cell10.setCellValue(brf96ARow1TO471.getR37_gre_non_resident() == null ? 0
					: brf96ARow1TO471.getR37_gre_non_resident().intValue());
		}

		Cell row37cell11 = row37.getCell(12);

		if (row37cell11 != null) {
			row37cell11.setCellValue(brf96ARow1TO471.getR37_private_non_resident() == null ? 0
					: brf96ARow1TO471.getR37_private_non_resident().intValue());
		}

		Cell row37cell12 = row37.getCell(13);

		if (row37cell12 != null) {
			row37cell12.setCellValue(brf96ARow1TO471.getR37_hni_non_resident() == null ? 0
					: brf96ARow1TO471.getR37_hni_non_resident().intValue());
		}

		Cell row37cell13 = row37.getCell(14);

		if (row37cell13 != null) {
			row37cell13.setCellValue(brf96ARow1TO471.getR37_individual_non_resident() == null ? 0
					: brf96ARow1TO471.getR37_individual_non_resident().intValue());
		}

		Cell row37cell14 = row37.getCell(15);

		if (row37cell14 != null) {
			row37cell14.setCellValue(brf96ARow1TO471.getR37_banking_non_resident() == null ? 0
					: brf96ARow1TO471.getR37_banking_non_resident().intValue());
		}

		Cell row37cell15 = row37.getCell(16);

		if (row37cell15 != null) {
			row37cell15.setCellValue(brf96ARow1TO471.getR37_trade_non_resident() == null ? 0
					: brf96ARow1TO471.getR37_trade_non_resident().intValue());
		}

		// ROW 38

		Row row38 = sheet.getRow(37);

		Cell row38cell1 = row38.getCell(2);

		if (row38cell1 != null) {
			row38cell1.setCellValue(brf96ARow1TO471.getR38_country() == null ? "0" : brf96ARow1TO471.getR38_country());
		}

		Cell row38cell2 = row38.getCell(3);

		if (row38cell2 != null) {
			row38cell2.setCellValue(brf96ARow1TO471.getR38_government_resident() == null ? 0
					: brf96ARow1TO471.getR38_government_resident().intValue());
		}

		Cell row38cell3 = row38.getCell(4);

		if (row38cell3 != null) {
			row38cell3.setCellValue(brf96ARow1TO471.getR38_gre_resident() == null ? 0
					: brf96ARow1TO471.getR38_gre_resident().intValue());
		}

		Cell row38cell4 = row38.getCell(5);

		if (row38cell4 != null) {
			row38cell4.setCellValue(brf96ARow1TO471.getR38_private_resident() == null ? 0
					: brf96ARow1TO471.getR38_private_resident().intValue());
		}

		Cell row38cell5 = row38.getCell(6);

		if (row38cell5 != null) {
			row38cell5.setCellValue(brf96ARow1TO471.getR38_hni_resident() == null ? 0
					: brf96ARow1TO471.getR38_hni_resident().intValue());
		}

		Cell row38cell6 = row38.getCell(7);

		if (row38cell6 != null) {
			row38cell6.setCellValue(brf96ARow1TO471.getR38_individual_resident() == null ? 0
					: brf96ARow1TO471.getR38_individual_resident().intValue());
		}

		Cell row38cell7 = row38.getCell(8);

		if (row38cell7 != null) {
			row38cell7.setCellValue(brf96ARow1TO471.getR38_banking_resident() == null ? 0
					: brf96ARow1TO471.getR38_banking_resident().intValue());
		}

		Cell row38cell8 = row38.getCell(9);

		if (row38cell8 != null) {
			row38cell8.setCellValue(brf96ARow1TO471.getR38_trade_resident() == null ? 0
					: brf96ARow1TO471.getR38_trade_resident().intValue());
		}

		Cell row38cell9 = row38.getCell(10);

		if (row38cell9 != null) {
			row38cell9.setCellValue(brf96ARow1TO471.getR38_government_non_resident() == null ? 0
					: brf96ARow1TO471.getR38_government_non_resident().intValue());
		}

		Cell row38cell10 = row38.getCell(11);

		if (row38cell10 != null) {
			row38cell10.setCellValue(brf96ARow1TO471.getR38_gre_non_resident() == null ? 0
					: brf96ARow1TO471.getR38_gre_non_resident().intValue());
		}

		Cell row38cell11 = row38.getCell(12);

		if (row38cell11 != null) {
			row38cell11.setCellValue(brf96ARow1TO471.getR38_private_non_resident() == null ? 0
					: brf96ARow1TO471.getR38_private_non_resident().intValue());
		}

		Cell row38cell12 = row38.getCell(13);

		if (row38cell12 != null) {
			row38cell12.setCellValue(brf96ARow1TO471.getR38_hni_non_resident() == null ? 0
					: brf96ARow1TO471.getR38_hni_non_resident().intValue());
		}

		Cell row38cell13 = row38.getCell(14);

		if (row38cell13 != null) {
			row38cell13.setCellValue(brf96ARow1TO471.getR38_individual_non_resident() == null ? 0
					: brf96ARow1TO471.getR38_individual_non_resident().intValue());
		}

		Cell row38cell14 = row38.getCell(15);

		if (row38cell14 != null) {
			row38cell14.setCellValue(brf96ARow1TO471.getR38_banking_non_resident() == null ? 0
					: brf96ARow1TO471.getR38_banking_non_resident().intValue());
		}

		Cell row38cell15 = row38.getCell(16);

		if (row38cell15 != null) {
			row38cell15.setCellValue(brf96ARow1TO471.getR38_trade_non_resident() == null ? 0
					: brf96ARow1TO471.getR38_trade_non_resident().intValue());
		}

		// ROW 39

		Row row39 = sheet.getRow(38);

		Cell row39cell1 = row39.getCell(2);

		if (row39cell1 != null) {
			row39cell1.setCellValue(brf96ARow1TO471.getR39_country() == null ? "0" : brf96ARow1TO471.getR39_country());
		}

		Cell row39cell2 = row39.getCell(3);

		if (row39cell2 != null) {
			row39cell2.setCellValue(brf96ARow1TO471.getR39_government_resident() == null ? 0
					: brf96ARow1TO471.getR39_government_resident().intValue());
		}

		Cell row39cell3 = row39.getCell(4);

		if (row39cell3 != null) {
			row39cell3.setCellValue(brf96ARow1TO471.getR39_gre_resident() == null ? 0
					: brf96ARow1TO471.getR39_gre_resident().intValue());
		}

		Cell row39cell4 = row39.getCell(5);

		if (row39cell4 != null) {
			row39cell4.setCellValue(brf96ARow1TO471.getR39_private_resident() == null ? 0
					: brf96ARow1TO471.getR39_private_resident().intValue());
		}

		Cell row39cell5 = row39.getCell(6);

		if (row39cell5 != null) {
			row39cell5.setCellValue(brf96ARow1TO471.getR39_hni_resident() == null ? 0
					: brf96ARow1TO471.getR39_hni_resident().intValue());
		}

		Cell row39cell6 = row39.getCell(7);

		if (row39cell6 != null) {
			row39cell6.setCellValue(brf96ARow1TO471.getR39_individual_resident() == null ? 0
					: brf96ARow1TO471.getR39_individual_resident().intValue());
		}

		Cell row39cell7 = row39.getCell(8);

		if (row39cell7 != null) {
			row39cell7.setCellValue(brf96ARow1TO471.getR39_banking_resident() == null ? 0
					: brf96ARow1TO471.getR39_banking_resident().intValue());
		}

		Cell row39cell8 = row39.getCell(9);

		if (row39cell8 != null) {
			row39cell8.setCellValue(brf96ARow1TO471.getR39_trade_resident() == null ? 0
					: brf96ARow1TO471.getR39_trade_resident().intValue());
		}

		Cell row39cell9 = row39.getCell(10);

		if (row39cell9 != null) {
			row39cell9.setCellValue(brf96ARow1TO471.getR39_government_non_resident() == null ? 0
					: brf96ARow1TO471.getR39_government_non_resident().intValue());
		}

		Cell row39cell10 = row39.getCell(11);

		if (row39cell10 != null) {
			row39cell10.setCellValue(brf96ARow1TO471.getR39_gre_non_resident() == null ? 0
					: brf96ARow1TO471.getR39_gre_non_resident().intValue());
		}

		Cell row39cell11 = row39.getCell(12);

		if (row39cell11 != null) {
			row39cell11.setCellValue(brf96ARow1TO471.getR39_private_non_resident() == null ? 0
					: brf96ARow1TO471.getR39_private_non_resident().intValue());
		}

		Cell row39cell12 = row39.getCell(13);

		if (row39cell12 != null) {
			row39cell12.setCellValue(brf96ARow1TO471.getR39_hni_non_resident() == null ? 0
					: brf96ARow1TO471.getR39_hni_non_resident().intValue());
		}

		Cell row39cell13 = row39.getCell(14);

		if (row39cell13 != null) {
			row39cell13.setCellValue(brf96ARow1TO471.getR39_individual_non_resident() == null ? 0
					: brf96ARow1TO471.getR39_individual_non_resident().intValue());
		}

		Cell row39cell14 = row39.getCell(15);

		if (row39cell14 != null) {
			row39cell14.setCellValue(brf96ARow1TO471.getR39_banking_non_resident() == null ? 0
					: brf96ARow1TO471.getR39_banking_non_resident().intValue());
		}

		Cell row39cell15 = row39.getCell(16);

		if (row39cell15 != null) {
			row39cell15.setCellValue(brf96ARow1TO471.getR39_trade_non_resident() == null ? 0
					: brf96ARow1TO471.getR39_trade_non_resident().intValue());
		}

		// ROW 40

		Row row40 = sheet.getRow(39);

		Cell row40cell1 = row40.getCell(2);

		if (row40cell1 != null) {
			row40cell1.setCellValue(brf96ARow1TO471.getR40_country() == null ? "0" : brf96ARow1TO471.getR40_country());
		}

		Cell row40cell2 = row40.getCell(3);

		if (row40cell2 != null) {
			row40cell2.setCellValue(brf96ARow1TO471.getR40_government_resident() == null ? 0
					: brf96ARow1TO471.getR40_government_resident().intValue());
		}

		Cell row40cell3 = row40.getCell(4);

		if (row40cell3 != null) {
			row40cell3.setCellValue(brf96ARow1TO471.getR40_gre_resident() == null ? 0
					: brf96ARow1TO471.getR40_gre_resident().intValue());
		}

		Cell row40cell4 = row40.getCell(5);

		if (row40cell4 != null) {
			row40cell4.setCellValue(brf96ARow1TO471.getR40_private_resident() == null ? 0
					: brf96ARow1TO471.getR40_private_resident().intValue());
		}

		Cell row40cell5 = row40.getCell(6);

		if (row40cell5 != null) {
			row40cell5.setCellValue(brf96ARow1TO471.getR40_hni_resident() == null ? 0
					: brf96ARow1TO471.getR40_hni_resident().intValue());
		}

		Cell row40cell6 = row40.getCell(7);

		if (row40cell6 != null) {
			row40cell6.setCellValue(brf96ARow1TO471.getR40_individual_resident() == null ? 0
					: brf96ARow1TO471.getR40_individual_resident().intValue());
		}

		Cell row40cell7 = row40.getCell(8);

		if (row40cell7 != null) {
			row40cell7.setCellValue(brf96ARow1TO471.getR40_banking_resident() == null ? 0
					: brf96ARow1TO471.getR40_banking_resident().intValue());
		}

		Cell row40cell8 = row40.getCell(9);

		if (row40cell8 != null) {
			row40cell8.setCellValue(brf96ARow1TO471.getR40_trade_resident() == null ? 0
					: brf96ARow1TO471.getR40_trade_resident().intValue());
		}

		Cell row40cell9 = row40.getCell(10);

		if (row40cell9 != null) {
			row40cell9.setCellValue(brf96ARow1TO471.getR40_government_non_resident() == null ? 0
					: brf96ARow1TO471.getR40_government_non_resident().intValue());
		}

		Cell row40cell10 = row40.getCell(11);

		if (row40cell10 != null) {
			row40cell10.setCellValue(brf96ARow1TO471.getR40_gre_non_resident() == null ? 0
					: brf96ARow1TO471.getR40_gre_non_resident().intValue());
		}

		Cell row40cell11 = row40.getCell(12);

		if (row40cell11 != null) {
			row40cell11.setCellValue(brf96ARow1TO471.getR40_private_non_resident() == null ? 0
					: brf96ARow1TO471.getR40_private_non_resident().intValue());
		}

		Cell row40cell12 = row40.getCell(13);

		if (row40cell12 != null) {
			row40cell12.setCellValue(brf96ARow1TO471.getR40_hni_non_resident() == null ? 0
					: brf96ARow1TO471.getR40_hni_non_resident().intValue());
		}

		Cell row40cell13 = row40.getCell(14);

		if (row40cell13 != null) {
			row40cell13.setCellValue(brf96ARow1TO471.getR40_individual_non_resident() == null ? 0
					: brf96ARow1TO471.getR40_individual_non_resident().intValue());
		}

		Cell row40cell14 = row40.getCell(15);

		if (row40cell14 != null) {
			row40cell14.setCellValue(brf96ARow1TO471.getR40_banking_non_resident() == null ? 0
					: brf96ARow1TO471.getR40_banking_non_resident().intValue());
		}

		Cell row40cell15 = row40.getCell(16);

		if (row40cell15 != null) {
			row40cell15.setCellValue(brf96ARow1TO471.getR40_trade_non_resident() == null ? 0
					: brf96ARow1TO471.getR40_trade_non_resident().intValue());
		}

		// ROW 41

		Row row41 = sheet.getRow(40);

		Cell row41cell1 = row41.getCell(2);

		if (row41cell1 != null) {
			row41cell1.setCellValue(brf96ARow1TO471.getR41_country() == null ? "0" : brf96ARow1TO471.getR41_country());
		}

		Cell row41cell2 = row41.getCell(3);

		if (row41cell2 != null) {
			row41cell2.setCellValue(brf96ARow1TO471.getR41_government_resident() == null ? 0
					: brf96ARow1TO471.getR41_government_resident().intValue());
		}

		Cell row41cell3 = row41.getCell(4);

		if (row41cell3 != null) {
			row41cell3.setCellValue(brf96ARow1TO471.getR41_gre_resident() == null ? 0
					: brf96ARow1TO471.getR41_gre_resident().intValue());
		}

		Cell row41cell4 = row41.getCell(5);

		if (row41cell4 != null) {
			row41cell4.setCellValue(brf96ARow1TO471.getR41_private_resident() == null ? 0
					: brf96ARow1TO471.getR41_private_resident().intValue());
		}

		Cell row41cell5 = row41.getCell(6);

		if (row41cell5 != null) {
			row41cell5.setCellValue(brf96ARow1TO471.getR41_hni_resident() == null ? 0
					: brf96ARow1TO471.getR41_hni_resident().intValue());
		}

		Cell row41cell6 = row41.getCell(7);

		if (row41cell6 != null) {
			row41cell6.setCellValue(brf96ARow1TO471.getR41_individual_resident() == null ? 0
					: brf96ARow1TO471.getR41_individual_resident().intValue());
		}

		Cell row41cell7 = row41.getCell(8);

		if (row41cell7 != null) {
			row41cell7.setCellValue(brf96ARow1TO471.getR41_banking_resident() == null ? 0
					: brf96ARow1TO471.getR41_banking_resident().intValue());
		}

		Cell row41cell8 = row41.getCell(9);

		if (row41cell8 != null) {
			row41cell8.setCellValue(brf96ARow1TO471.getR41_trade_resident() == null ? 0
					: brf96ARow1TO471.getR41_trade_resident().intValue());
		}

		Cell row41cell9 = row41.getCell(10);

		if (row41cell9 != null) {
			row41cell9.setCellValue(brf96ARow1TO471.getR41_government_non_resident() == null ? 0
					: brf96ARow1TO471.getR41_government_non_resident().intValue());
		}

		Cell row41cell10 = row41.getCell(11);

		if (row41cell10 != null) {
			row41cell10.setCellValue(brf96ARow1TO471.getR41_gre_non_resident() == null ? 0
					: brf96ARow1TO471.getR41_gre_non_resident().intValue());
		}

		Cell row41cell11 = row41.getCell(12);

		if (row41cell11 != null) {
			row41cell11.setCellValue(brf96ARow1TO471.getR41_private_non_resident() == null ? 0
					: brf96ARow1TO471.getR41_private_non_resident().intValue());
		}

		Cell row41cell12 = row41.getCell(13);

		if (row41cell12 != null) {
			row41cell12.setCellValue(brf96ARow1TO471.getR41_hni_non_resident() == null ? 0
					: brf96ARow1TO471.getR41_hni_non_resident().intValue());
		}

		Cell row41cell13 = row41.getCell(14);

		if (row41cell13 != null) {
			row41cell13.setCellValue(brf96ARow1TO471.getR41_individual_non_resident() == null ? 0
					: brf96ARow1TO471.getR41_individual_non_resident().intValue());
		}

		Cell row41cell14 = row41.getCell(15);

		if (row41cell14 != null) {
			row41cell14.setCellValue(brf96ARow1TO471.getR41_banking_non_resident() == null ? 0
					: brf96ARow1TO471.getR41_banking_non_resident().intValue());
		}

		Cell row41cell15 = row41.getCell(16);

		if (row41cell15 != null) {
			row41cell15.setCellValue(brf96ARow1TO471.getR41_trade_non_resident() == null ? 0
					: brf96ARow1TO471.getR41_trade_non_resident().intValue());
		}

		// ROW 42

		Row row42 = sheet.getRow(41);

		Cell row42cell1 = row42.getCell(2);

		if (row42cell1 != null) {
			row42cell1.setCellValue(brf96ARow1TO471.getR42_country() == null ? "0" : brf96ARow1TO471.getR42_country());
		}

		Cell row42cell2 = row42.getCell(3);

		if (row42cell2 != null) {
			row42cell2.setCellValue(brf96ARow1TO471.getR42_government_resident() == null ? 0
					: brf96ARow1TO471.getR42_government_resident().intValue());
		}

		Cell row42cell3 = row42.getCell(4);

		if (row42cell3 != null) {
			row42cell3.setCellValue(brf96ARow1TO471.getR42_gre_resident() == null ? 0
					: brf96ARow1TO471.getR42_gre_resident().intValue());
		}

		Cell row42cell4 = row42.getCell(5);

		if (row42cell4 != null) {
			row42cell4.setCellValue(brf96ARow1TO471.getR42_private_resident() == null ? 0
					: brf96ARow1TO471.getR42_private_resident().intValue());
		}

		Cell row42cell5 = row42.getCell(6);

		if (row42cell5 != null) {
			row42cell5.setCellValue(brf96ARow1TO471.getR42_hni_resident() == null ? 0
					: brf96ARow1TO471.getR42_hni_resident().intValue());
		}

		Cell row42cell6 = row42.getCell(7);

		if (row42cell6 != null) {
			row42cell6.setCellValue(brf96ARow1TO471.getR42_individual_resident() == null ? 0
					: brf96ARow1TO471.getR42_individual_resident().intValue());
		}

		Cell row42cell7 = row42.getCell(8);

		if (row42cell7 != null) {
			row42cell7.setCellValue(brf96ARow1TO471.getR42_banking_resident() == null ? 0
					: brf96ARow1TO471.getR42_banking_resident().intValue());
		}

		Cell row42cell8 = row42.getCell(9);

		if (row42cell8 != null) {
			row42cell8.setCellValue(brf96ARow1TO471.getR42_trade_resident() == null ? 0
					: brf96ARow1TO471.getR42_trade_resident().intValue());
		}

		Cell row42cell9 = row42.getCell(10);

		if (row42cell9 != null) {
			row42cell9.setCellValue(brf96ARow1TO471.getR42_government_non_resident() == null ? 0
					: brf96ARow1TO471.getR42_government_non_resident().intValue());
		}

		Cell row42cell10 = row42.getCell(11);

		if (row42cell10 != null) {
			row42cell10.setCellValue(brf96ARow1TO471.getR42_gre_non_resident() == null ? 0
					: brf96ARow1TO471.getR42_gre_non_resident().intValue());
		}

		Cell row42cell11 = row42.getCell(12);

		if (row42cell11 != null) {
			row42cell11.setCellValue(brf96ARow1TO471.getR42_private_non_resident() == null ? 0
					: brf96ARow1TO471.getR42_private_non_resident().intValue());
		}

		Cell row42cell12 = row42.getCell(13);

		if (row42cell12 != null) {
			row42cell12.setCellValue(brf96ARow1TO471.getR42_hni_non_resident() == null ? 0
					: brf96ARow1TO471.getR42_hni_non_resident().intValue());
		}

		Cell row42cell13 = row42.getCell(14);

		if (row42cell13 != null) {
			row42cell13.setCellValue(brf96ARow1TO471.getR42_individual_non_resident() == null ? 0
					: brf96ARow1TO471.getR42_individual_non_resident().intValue());
		}

		Cell row42cell14 = row42.getCell(15);

		if (row42cell14 != null) {
			row42cell14.setCellValue(brf96ARow1TO471.getR42_banking_non_resident() == null ? 0
					: brf96ARow1TO471.getR42_banking_non_resident().intValue());
		}

		Cell row42cell15 = row42.getCell(16);

		if (row42cell15 != null) {
			row42cell15.setCellValue(brf96ARow1TO471.getR42_trade_non_resident() == null ? 0
					: brf96ARow1TO471.getR42_trade_non_resident().intValue());
		}

		// ROW 43

		Row row43 = sheet.getRow(42);

		Cell row43cell1 = row43.getCell(2);

		if (row43cell1 != null) {
			row43cell1.setCellValue(brf96ARow1TO471.getR43_country() == null ? "0" : brf96ARow1TO471.getR43_country());
		}

		Cell row43cell2 = row43.getCell(3);

		if (row43cell2 != null) {
			row43cell2.setCellValue(brf96ARow1TO471.getR43_government_resident() == null ? 0
					: brf96ARow1TO471.getR43_government_resident().intValue());
		}

		Cell row43cell3 = row43.getCell(4);

		if (row43cell3 != null) {
			row43cell3.setCellValue(brf96ARow1TO471.getR43_gre_resident() == null ? 0
					: brf96ARow1TO471.getR43_gre_resident().intValue());
		}

		Cell row43cell4 = row43.getCell(5);

		if (row43cell4 != null) {
			row43cell4.setCellValue(brf96ARow1TO471.getR43_private_resident() == null ? 0
					: brf96ARow1TO471.getR43_private_resident().intValue());
		}

		Cell row43cell5 = row43.getCell(6);

		if (row43cell5 != null) {
			row43cell5.setCellValue(brf96ARow1TO471.getR43_hni_resident() == null ? 0
					: brf96ARow1TO471.getR43_hni_resident().intValue());
		}

		Cell row43cell6 = row43.getCell(7);

		if (row43cell6 != null) {
			row43cell6.setCellValue(brf96ARow1TO471.getR43_individual_resident() == null ? 0
					: brf96ARow1TO471.getR43_individual_resident().intValue());
		}

		Cell row43cell7 = row43.getCell(8);

		if (row43cell7 != null) {
			row43cell7.setCellValue(brf96ARow1TO471.getR43_banking_resident() == null ? 0
					: brf96ARow1TO471.getR43_banking_resident().intValue());
		}

		Cell row43cell8 = row43.getCell(9);

		if (row43cell8 != null) {
			row43cell8.setCellValue(brf96ARow1TO471.getR43_trade_resident() == null ? 0
					: brf96ARow1TO471.getR43_trade_resident().intValue());
		}

		Cell row43cell9 = row43.getCell(10);

		if (row43cell9 != null) {
			row43cell9.setCellValue(brf96ARow1TO471.getR43_government_non_resident() == null ? 0
					: brf96ARow1TO471.getR43_government_non_resident().intValue());
		}

		Cell row43cell10 = row43.getCell(11);

		if (row43cell10 != null) {
			row43cell10.setCellValue(brf96ARow1TO471.getR43_gre_non_resident() == null ? 0
					: brf96ARow1TO471.getR43_gre_non_resident().intValue());
		}

		Cell row43cell11 = row43.getCell(12);

		if (row43cell11 != null) {
			row43cell11.setCellValue(brf96ARow1TO471.getR43_private_non_resident() == null ? 0
					: brf96ARow1TO471.getR43_private_non_resident().intValue());
		}

		Cell row43cell12 = row43.getCell(13);

		if (row43cell12 != null) {
			row43cell12.setCellValue(brf96ARow1TO471.getR43_hni_non_resident() == null ? 0
					: brf96ARow1TO471.getR43_hni_non_resident().intValue());
		}

		Cell row43cell13 = row43.getCell(14);

		if (row43cell13 != null) {
			row43cell13.setCellValue(brf96ARow1TO471.getR43_individual_non_resident() == null ? 0
					: brf96ARow1TO471.getR43_individual_non_resident().intValue());
		}

		Cell row43cell14 = row43.getCell(15);

		if (row43cell14 != null) {
			row43cell14.setCellValue(brf96ARow1TO471.getR43_banking_non_resident() == null ? 0
					: brf96ARow1TO471.getR43_banking_non_resident().intValue());
		}

		Cell row43cell15 = row43.getCell(16);

		if (row43cell15 != null) {
			row43cell15.setCellValue(brf96ARow1TO471.getR43_trade_non_resident() == null ? 0
					: brf96ARow1TO471.getR43_trade_non_resident().intValue());
		}

		// ROW 44

		Row row44 = sheet.getRow(43);

		Cell row44cell1 = row44.getCell(2);

		if (row44cell1 != null) {
			row44cell1.setCellValue(brf96ARow1TO471.getR44_country() == null ? "0" : brf96ARow1TO471.getR44_country());
		}

		Cell row44cell2 = row44.getCell(3);

		if (row44cell2 != null) {
			row44cell2.setCellValue(brf96ARow1TO471.getR44_government_resident() == null ? 0
					: brf96ARow1TO471.getR44_government_resident().intValue());
		}

		Cell row44cell3 = row44.getCell(4);

		if (row44cell3 != null) {
			row44cell3.setCellValue(brf96ARow1TO471.getR44_gre_resident() == null ? 0
					: brf96ARow1TO471.getR44_gre_resident().intValue());
		}

		Cell row44cell4 = row44.getCell(5);

		if (row44cell4 != null) {
			row44cell4.setCellValue(brf96ARow1TO471.getR44_private_resident() == null ? 0
					: brf96ARow1TO471.getR44_private_resident().intValue());
		}

		Cell row44cell5 = row44.getCell(6);

		if (row44cell5 != null) {
			row44cell5.setCellValue(brf96ARow1TO471.getR44_hni_resident() == null ? 0
					: brf96ARow1TO471.getR44_hni_resident().intValue());
		}

		Cell row44cell6 = row44.getCell(7);

		if (row44cell6 != null) {
			row44cell6.setCellValue(brf96ARow1TO471.getR44_individual_resident() == null ? 0
					: brf96ARow1TO471.getR44_individual_resident().intValue());
		}

		Cell row44cell7 = row44.getCell(8);

		if (row44cell7 != null) {
			row44cell7.setCellValue(brf96ARow1TO471.getR44_banking_resident() == null ? 0
					: brf96ARow1TO471.getR44_banking_resident().intValue());
		}

		Cell row44cell8 = row44.getCell(9);

		if (row44cell8 != null) {
			row44cell8.setCellValue(brf96ARow1TO471.getR44_trade_resident() == null ? 0
					: brf96ARow1TO471.getR44_trade_resident().intValue());
		}

		Cell row44cell9 = row44.getCell(10);

		if (row44cell9 != null) {
			row44cell9.setCellValue(brf96ARow1TO471.getR44_government_non_resident() == null ? 0
					: brf96ARow1TO471.getR44_government_non_resident().intValue());
		}

		Cell row44cell10 = row44.getCell(11);

		if (row44cell10 != null) {
			row44cell10.setCellValue(brf96ARow1TO471.getR44_gre_non_resident() == null ? 0
					: brf96ARow1TO471.getR44_gre_non_resident().intValue());
		}

		Cell row44cell11 = row44.getCell(12);

		if (row44cell11 != null) {
			row44cell11.setCellValue(brf96ARow1TO471.getR44_private_non_resident() == null ? 0
					: brf96ARow1TO471.getR44_private_non_resident().intValue());
		}

		Cell row44cell12 = row44.getCell(13);

		if (row44cell12 != null) {
			row44cell12.setCellValue(brf96ARow1TO471.getR44_hni_non_resident() == null ? 0
					: brf96ARow1TO471.getR44_hni_non_resident().intValue());
		}

		Cell row44cell13 = row44.getCell(14);

		if (row44cell13 != null) {
			row44cell13.setCellValue(brf96ARow1TO471.getR44_individual_non_resident() == null ? 0
					: brf96ARow1TO471.getR44_individual_non_resident().intValue());
		}

		Cell row44cell14 = row44.getCell(15);

		if (row44cell14 != null) {
			row44cell14.setCellValue(brf96ARow1TO471.getR44_banking_non_resident() == null ? 0
					: brf96ARow1TO471.getR44_banking_non_resident().intValue());
		}

		Cell row44cell15 = row44.getCell(16);

		if (row44cell15 != null) {
			row44cell15.setCellValue(brf96ARow1TO471.getR44_trade_non_resident() == null ? 0
					: brf96ARow1TO471.getR44_trade_non_resident().intValue());
		}

		// ROW 46

		Row row46 = sheet.getRow(45);

		Cell row46cell1 = row46.getCell(2);

		if (row46cell1 != null) {
			row46cell1.setCellValue(brf96ARow1TO471.getR46_country() == null ? "0" : brf96ARow1TO471.getR46_country());
		}

		Cell row46cell2 = row46.getCell(3);

		if (row46cell2 != null) {
			row46cell2.setCellValue(brf96ARow1TO471.getR46_government_resident() == null ? 0
					: brf96ARow1TO471.getR46_government_resident().intValue());
		}

		Cell row46cell3 = row46.getCell(4);

		if (row46cell3 != null) {
			row46cell3.setCellValue(brf96ARow1TO471.getR46_gre_resident() == null ? 0
					: brf96ARow1TO471.getR46_gre_resident().intValue());
		}

		Cell row46cell4 = row46.getCell(5);

		if (row46cell4 != null) {
			row46cell4.setCellValue(brf96ARow1TO471.getR46_private_resident() == null ? 0
					: brf96ARow1TO471.getR46_private_resident().intValue());
		}

		Cell row46cell5 = row46.getCell(6);

		if (row46cell5 != null) {
			row46cell5.setCellValue(brf96ARow1TO471.getR46_hni_resident() == null ? 0
					: brf96ARow1TO471.getR46_hni_resident().intValue());
		}

		Cell row46cell6 = row46.getCell(7);

		if (row46cell6 != null) {
			row46cell6.setCellValue(brf96ARow1TO471.getR46_individual_resident() == null ? 0
					: brf96ARow1TO471.getR46_individual_resident().intValue());
		}

		Cell row46cell7 = row46.getCell(8);

		if (row46cell7 != null) {
			row46cell7.setCellValue(brf96ARow1TO471.getR46_banking_resident() == null ? 0
					: brf96ARow1TO471.getR46_banking_resident().intValue());
		}

		Cell row46cell8 = row46.getCell(9);

		if (row46cell8 != null) {
			row46cell8.setCellValue(brf96ARow1TO471.getR46_trade_resident() == null ? 0
					: brf96ARow1TO471.getR46_trade_resident().intValue());
		}

		Cell row46cell9 = row46.getCell(10);

		if (row46cell9 != null) {
			row46cell9.setCellValue(brf96ARow1TO471.getR46_government_non_resident() == null ? 0
					: brf96ARow1TO471.getR46_government_non_resident().intValue());
		}

		Cell row46cell10 = row46.getCell(11);

		if (row46cell10 != null) {
			row46cell10.setCellValue(brf96ARow1TO471.getR46_gre_non_resident() == null ? 0
					: brf96ARow1TO471.getR46_gre_non_resident().intValue());
		}

		Cell row46cell11 = row46.getCell(12);

		if (row46cell11 != null) {
			row46cell11.setCellValue(brf96ARow1TO471.getR46_private_non_resident() == null ? 0
					: brf96ARow1TO471.getR46_private_non_resident().intValue());
		}

		Cell row46cell12 = row46.getCell(13);

		if (row46cell12 != null) {
			row46cell12.setCellValue(brf96ARow1TO471.getR46_hni_non_resident() == null ? 0
					: brf96ARow1TO471.getR46_hni_non_resident().intValue());
		}

		Cell row46cell13 = row46.getCell(14);

		if (row46cell13 != null) {
			row46cell13.setCellValue(brf96ARow1TO471.getR46_individual_non_resident() == null ? 0
					: brf96ARow1TO471.getR46_individual_non_resident().intValue());
		}

		Cell row46cell14 = row46.getCell(15);

		if (row46cell14 != null) {
			row46cell14.setCellValue(brf96ARow1TO471.getR46_banking_non_resident() == null ? 0
					: brf96ARow1TO471.getR46_banking_non_resident().intValue());
		}

		Cell row46cell15 = row46.getCell(16);

		if (row46cell15 != null) {
			row46cell15.setCellValue(brf96ARow1TO471.getR46_trade_non_resident() == null ? 0
					: brf96ARow1TO471.getR46_trade_non_resident().intValue());
		}

		// ROW 47

		Row row47 = sheet.getRow(46);

		Cell row47cell1 = row47.getCell(2);

		if (row47cell1 != null) {
			row47cell1.setCellValue(brf96ARow1TO471.getR47_country() == null ? "0" : brf96ARow1TO471.getR47_country());
		}

		Cell row47cell2 = row47.getCell(3);

		if (row47cell2 != null) {
			row47cell2.setCellValue(brf96ARow1TO471.getR47_government_resident() == null ? 0
					: brf96ARow1TO471.getR47_government_resident().intValue());
		}

		Cell row47cell3 = row47.getCell(4);

		if (row47cell3 != null) {
			row47cell3.setCellValue(brf96ARow1TO471.getR47_gre_resident() == null ? 0
					: brf96ARow1TO471.getR47_gre_resident().intValue());
		}

		Cell row47cell4 = row47.getCell(5);

		if (row47cell4 != null) {
			row47cell4.setCellValue(brf96ARow1TO471.getR47_private_resident() == null ? 0
					: brf96ARow1TO471.getR47_private_resident().intValue());
		}

		Cell row47cell5 = row47.getCell(6);

		if (row47cell5 != null) {
			row47cell5.setCellValue(brf96ARow1TO471.getR47_hni_resident() == null ? 0
					: brf96ARow1TO471.getR47_hni_resident().intValue());
		}

		Cell row47cell6 = row47.getCell(7);

		if (row47cell6 != null) {
			row47cell6.setCellValue(brf96ARow1TO471.getR47_individual_resident() == null ? 0
					: brf96ARow1TO471.getR47_individual_resident().intValue());
		}

		Cell row47cell7 = row47.getCell(8);

		if (row47cell7 != null) {
			row47cell7.setCellValue(brf96ARow1TO471.getR47_banking_resident() == null ? 0
					: brf96ARow1TO471.getR47_banking_resident().intValue());
		}

		Cell row47cell8 = row47.getCell(9);

		if (row47cell8 != null) {
			row47cell8.setCellValue(brf96ARow1TO471.getR47_trade_resident() == null ? 0
					: brf96ARow1TO471.getR47_trade_resident().intValue());
		}

		Cell row47cell9 = row47.getCell(10);

		if (row47cell9 != null) {
			row47cell9.setCellValue(brf96ARow1TO471.getR47_government_non_resident() == null ? 0
					: brf96ARow1TO471.getR47_government_non_resident().intValue());
		}

		Cell row47cell10 = row47.getCell(11);

		if (row47cell10 != null) {
			row47cell10.setCellValue(brf96ARow1TO471.getR47_gre_non_resident() == null ? 0
					: brf96ARow1TO471.getR47_gre_non_resident().intValue());
		}

		Cell row47cell11 = row47.getCell(12);

		if (row47cell11 != null) {
			row47cell11.setCellValue(brf96ARow1TO471.getR47_private_non_resident() == null ? 0
					: brf96ARow1TO471.getR47_private_non_resident().intValue());
		}

		Cell row47cell12 = row47.getCell(13);

		if (row47cell12 != null) {
			row47cell12.setCellValue(brf96ARow1TO471.getR47_hni_non_resident() == null ? 0
					: brf96ARow1TO471.getR47_hni_non_resident().intValue());
		}

		Cell row47cell13 = row47.getCell(14);

		if (row47cell13 != null) {
			row47cell13.setCellValue(brf96ARow1TO471.getR47_individual_non_resident() == null ? 0
					: brf96ARow1TO471.getR47_individual_non_resident().intValue());
		}

		Cell row47cell14 = row47.getCell(15);

		if (row47cell14 != null) {
			row47cell14.setCellValue(brf96ARow1TO471.getR47_banking_non_resident() == null ? 0
					: brf96ARow1TO471.getR47_banking_non_resident().intValue());
		}

		Cell row47cell15 = row47.getCell(16);

		if (row47cell15 != null) {
			row47cell15.setCellValue(brf96ARow1TO471.getR47_trade_non_resident() == null ? 0
					: brf96ARow1TO471.getR47_trade_non_resident().intValue());
		}

		// ROW 47

		Row row48 = sheet.getRow(47);

		Cell row48cell1 = row48.getCell(2);

		if (row48cell1 != null) {
			row48cell1.setCellValue(brf96ARow1TO471.getR48_country() == null ? "0" : brf96ARow1TO471.getR48_country());
		}

		Cell row48cell2 = row48.getCell(3);

		if (row48cell2 != null) {
			row48cell2.setCellValue(brf96ARow1TO471.getR48_government_resident() == null ? 0
					: brf96ARow1TO471.getR48_government_resident().intValue());
		}

		Cell row48cell3 = row48.getCell(4);

		if (row48cell3 != null) {
			row48cell3.setCellValue(brf96ARow1TO471.getR48_gre_resident() == null ? 0
					: brf96ARow1TO471.getR48_gre_resident().intValue());
		}

		Cell row48cell4 = row48.getCell(5);

		if (row48cell4 != null) {
			row48cell4.setCellValue(brf96ARow1TO471.getR48_private_resident() == null ? 0
					: brf96ARow1TO471.getR48_private_resident().intValue());
		}

		Cell row48cell5 = row48.getCell(6);

		if (row48cell5 != null) {
			row48cell5.setCellValue(brf96ARow1TO471.getR48_hni_resident() == null ? 0
					: brf96ARow1TO471.getR48_hni_resident().intValue());
		}

		Cell row48cell6 = row48.getCell(7);

		if (row48cell6 != null) {
			row48cell6.setCellValue(brf96ARow1TO471.getR48_individual_resident() == null ? 0
					: brf96ARow1TO471.getR48_individual_resident().intValue());
		}

		Cell row48cell7 = row48.getCell(8);

		if (row48cell7 != null) {
			row48cell7.setCellValue(brf96ARow1TO471.getR48_banking_resident() == null ? 0
					: brf96ARow1TO471.getR48_banking_resident().intValue());
		}

		Cell row48cell8 = row48.getCell(9);

		if (row48cell8 != null) {
			row48cell8.setCellValue(brf96ARow1TO471.getR48_trade_resident() == null ? 0
					: brf96ARow1TO471.getR48_trade_resident().intValue());
		}

		Cell row48cell9 = row48.getCell(10);

		if (row48cell9 != null) {
			row48cell9.setCellValue(brf96ARow1TO471.getR48_government_non_resident() == null ? 0
					: brf96ARow1TO471.getR48_government_non_resident().intValue());
		}

		Cell row48cell10 = row48.getCell(11);

		if (row48cell10 != null) {
			row48cell10.setCellValue(brf96ARow1TO471.getR48_gre_non_resident() == null ? 0
					: brf96ARow1TO471.getR48_gre_non_resident().intValue());
		}

		Cell row48cell11 = row48.getCell(12);

		if (row48cell11 != null) {
			row48cell11.setCellValue(brf96ARow1TO471.getR48_private_non_resident() == null ? 0
					: brf96ARow1TO471.getR48_private_non_resident().intValue());
		}

		Cell row48cell12 = row48.getCell(13);

		if (row48cell12 != null) {
			row48cell12.setCellValue(brf96ARow1TO471.getR48_hni_non_resident() == null ? 0
					: brf96ARow1TO471.getR48_hni_non_resident().intValue());
		}

		Cell row48cell13 = row48.getCell(14);

		if (row48cell13 != null) {
			row48cell13.setCellValue(brf96ARow1TO471.getR48_individual_non_resident() == null ? 0
					: brf96ARow1TO471.getR48_individual_non_resident().intValue());
		}

		Cell row48cell14 = row48.getCell(15);

		if (row48cell14 != null) {
			row48cell14.setCellValue(brf96ARow1TO471.getR48_banking_non_resident() == null ? 0
					: brf96ARow1TO471.getR48_banking_non_resident().intValue());
		}

		Cell row48cell15 = row48.getCell(16);

		if (row48cell15 != null) {
			row48cell15.setCellValue(brf96ARow1TO471.getR48_trade_non_resident() == null ? 0
					: brf96ARow1TO471.getR48_trade_non_resident().intValue());
		}

		// ROW 47

		Row row49 = sheet.getRow(48);

		Cell row49cell1 = row49.getCell(2);

		if (row49cell1 != null) {
			row49cell1.setCellValue(brf96ARow1TO471.getR49_country() == null ? "0" : brf96ARow1TO471.getR49_country());
		}

		Cell row49cell2 = row49.getCell(3);

		if (row49cell2 != null) {
			row49cell2.setCellValue(brf96ARow1TO471.getR49_government_resident() == null ? 0
					: brf96ARow1TO471.getR49_government_resident().intValue());
		}

		Cell row49cell3 = row49.getCell(4);

		if (row49cell3 != null) {
			row49cell3.setCellValue(brf96ARow1TO471.getR49_gre_resident() == null ? 0
					: brf96ARow1TO471.getR49_gre_resident().intValue());
		}

		Cell row49cell4 = row49.getCell(5);

		if (row49cell4 != null) {
			row49cell4.setCellValue(brf96ARow1TO471.getR49_private_resident() == null ? 0
					: brf96ARow1TO471.getR49_private_resident().intValue());
		}

		Cell row49cell5 = row49.getCell(6);

		if (row49cell5 != null) {
			row49cell5.setCellValue(brf96ARow1TO471.getR49_hni_resident() == null ? 0
					: brf96ARow1TO471.getR49_hni_resident().intValue());
		}

		Cell row49cell6 = row49.getCell(7);

		if (row49cell6 != null) {
			row49cell6.setCellValue(brf96ARow1TO471.getR49_individual_resident() == null ? 0
					: brf96ARow1TO471.getR49_individual_resident().intValue());
		}

		Cell row49cell7 = row49.getCell(8);

		if (row49cell7 != null) {
			row49cell7.setCellValue(brf96ARow1TO471.getR49_banking_resident() == null ? 0
					: brf96ARow1TO471.getR49_banking_resident().intValue());
		}

		Cell row49cell8 = row49.getCell(9);

		if (row49cell8 != null) {
			row49cell8.setCellValue(brf96ARow1TO471.getR49_trade_resident() == null ? 0
					: brf96ARow1TO471.getR49_trade_resident().intValue());
		}

		Cell row49cell9 = row49.getCell(10);

		if (row49cell9 != null) {
			row49cell9.setCellValue(brf96ARow1TO471.getR49_government_non_resident() == null ? 0
					: brf96ARow1TO471.getR49_government_non_resident().intValue());
		}

		Cell row49cell10 = row49.getCell(11);

		if (row49cell10 != null) {
			row49cell10.setCellValue(brf96ARow1TO471.getR49_gre_non_resident() == null ? 0
					: brf96ARow1TO471.getR49_gre_non_resident().intValue());
		}

		Cell row49cell11 = row49.getCell(12);

		if (row49cell11 != null) {
			row49cell11.setCellValue(brf96ARow1TO471.getR49_private_non_resident() == null ? 0
					: brf96ARow1TO471.getR49_private_non_resident().intValue());
		}

		Cell row49cell12 = row49.getCell(13);

		if (row49cell12 != null) {
			row49cell12.setCellValue(brf96ARow1TO471.getR49_hni_non_resident() == null ? 0
					: brf96ARow1TO471.getR49_hni_non_resident().intValue());
		}

		Cell row49cell13 = row49.getCell(14);

		if (row49cell13 != null) {
			row49cell13.setCellValue(brf96ARow1TO471.getR49_individual_non_resident() == null ? 0
					: brf96ARow1TO471.getR49_individual_non_resident().intValue());
		}

		Cell row49cell14 = row49.getCell(15);

		if (row49cell14 != null) {
			row49cell14.setCellValue(brf96ARow1TO471.getR49_banking_non_resident() == null ? 0
					: brf96ARow1TO471.getR49_banking_non_resident().intValue());
		}

		Cell row49cell15 = row49.getCell(16);

		if (row49cell15 != null) {
			row49cell15.setCellValue(brf96ARow1TO471.getR49_trade_non_resident() == null ? 0
					: brf96ARow1TO471.getR49_trade_non_resident().intValue());
		}

		// ROW 47

		Row row50 = sheet.getRow(49);

		Cell row50cell1 = row50.getCell(2);

		if (row50cell1 != null) {
			row50cell1.setCellValue(brf96ARow1TO471.getR50_country() == null ? "0" : brf96ARow1TO471.getR50_country());
		}

		Cell row50cell2 = row50.getCell(3);

		if (row50cell2 != null) {
			row50cell2.setCellValue(brf96ARow1TO471.getR50_government_resident() == null ? 0
					: brf96ARow1TO471.getR50_government_resident().intValue());
		}

		Cell row50cell3 = row50.getCell(4);

		if (row50cell3 != null) {
			row50cell3.setCellValue(brf96ARow1TO471.getR50_gre_resident() == null ? 0
					: brf96ARow1TO471.getR50_gre_resident().intValue());
		}

		Cell row50cell4 = row50.getCell(5);

		if (row50cell4 != null) {
			row50cell4.setCellValue(brf96ARow1TO471.getR50_private_resident() == null ? 0
					: brf96ARow1TO471.getR50_private_resident().intValue());
		}

		Cell row50cell5 = row50.getCell(6);

		if (row50cell5 != null) {
			row50cell5.setCellValue(brf96ARow1TO471.getR50_hni_resident() == null ? 0
					: brf96ARow1TO471.getR50_hni_resident().intValue());
		}

		Cell row50cell6 = row50.getCell(7);

		if (row50cell6 != null) {
			row50cell6.setCellValue(brf96ARow1TO471.getR50_individual_resident() == null ? 0
					: brf96ARow1TO471.getR50_individual_resident().intValue());
		}

		Cell row50cell7 = row50.getCell(8);

		if (row50cell7 != null) {
			row50cell7.setCellValue(brf96ARow1TO471.getR50_banking_resident() == null ? 0
					: brf96ARow1TO471.getR50_banking_resident().intValue());
		}

		Cell row50cell8 = row50.getCell(9);

		if (row50cell8 != null) {
			row50cell8.setCellValue(brf96ARow1TO471.getR50_trade_resident() == null ? 0
					: brf96ARow1TO471.getR50_trade_resident().intValue());
		}

		Cell row50cell9 = row50.getCell(10);

		if (row50cell9 != null) {
			row50cell9.setCellValue(brf96ARow1TO471.getR50_government_non_resident() == null ? 0
					: brf96ARow1TO471.getR50_government_non_resident().intValue());
		}

		Cell row50cell10 = row50.getCell(11);

		if (row50cell10 != null) {
			row50cell10.setCellValue(brf96ARow1TO471.getR50_gre_non_resident() == null ? 0
					: brf96ARow1TO471.getR50_gre_non_resident().intValue());
		}

		Cell row50cell11 = row50.getCell(12);

		if (row50cell11 != null) {
			row50cell11.setCellValue(brf96ARow1TO471.getR50_private_non_resident() == null ? 0
					: brf96ARow1TO471.getR50_private_non_resident().intValue());
		}

		Cell row50cell12 = row50.getCell(13);

		if (row50cell12 != null) {
			row50cell12.setCellValue(brf96ARow1TO471.getR50_hni_non_resident() == null ? 0
					: brf96ARow1TO471.getR50_hni_non_resident().intValue());
		}

		Cell row50cell13 = row50.getCell(14);

		if (row50cell13 != null) {
			row50cell13.setCellValue(brf96ARow1TO471.getR50_individual_non_resident() == null ? 0
					: brf96ARow1TO471.getR50_individual_non_resident().intValue());
		}

		Cell row50cell14 = row50.getCell(15);

		if (row50cell14 != null) {
			row50cell14.setCellValue(brf96ARow1TO471.getR50_banking_non_resident() == null ? 0
					: brf96ARow1TO471.getR50_banking_non_resident().intValue());
		}

		Cell row50cell15 = row50.getCell(16);

		if (row50cell15 != null) {
			row50cell15.setCellValue(brf96ARow1TO471.getR50_trade_non_resident() == null ? 0
					: brf96ARow1TO471.getR50_trade_non_resident().intValue());
		}

		// ROW 47

		Row row51 = sheet.getRow(50);

		Cell row51cell1 = row51.getCell(2);

		if (row51cell1 != null) {
			row51cell1.setCellValue(brf96ARow1TO471.getR51_country() == null ? "0" : brf96ARow1TO471.getR51_country());
		}

		Cell row51cell2 = row51.getCell(3);

		if (row51cell2 != null) {
			row51cell2.setCellValue(brf96ARow1TO471.getR51_government_resident() == null ? 0
					: brf96ARow1TO471.getR51_government_resident().intValue());
		}

		Cell row51cell3 = row51.getCell(4);

		if (row51cell3 != null) {
			row51cell3.setCellValue(brf96ARow1TO471.getR51_gre_resident() == null ? 0
					: brf96ARow1TO471.getR51_gre_resident().intValue());
		}

		Cell row51cell4 = row51.getCell(5);

		if (row51cell4 != null) {
			row51cell4.setCellValue(brf96ARow1TO471.getR51_private_resident() == null ? 0
					: brf96ARow1TO471.getR51_private_resident().intValue());
		}

		Cell row51cell5 = row51.getCell(6);

		if (row51cell5 != null) {
			row51cell5.setCellValue(brf96ARow1TO471.getR51_hni_resident() == null ? 0
					: brf96ARow1TO471.getR51_hni_resident().intValue());
		}

		Cell row51cell6 = row51.getCell(7);

		if (row51cell6 != null) {
			row51cell6.setCellValue(brf96ARow1TO471.getR51_individual_resident() == null ? 0
					: brf96ARow1TO471.getR51_individual_resident().intValue());
		}

		Cell row51cell7 = row51.getCell(8);

		if (row51cell7 != null) {
			row51cell7.setCellValue(brf96ARow1TO471.getR51_banking_resident() == null ? 0
					: brf96ARow1TO471.getR51_banking_resident().intValue());
		}

		Cell row51cell8 = row51.getCell(9);

		if (row51cell8 != null) {
			row51cell8.setCellValue(brf96ARow1TO471.getR51_trade_resident() == null ? 0
					: brf96ARow1TO471.getR51_trade_resident().intValue());
		}

		Cell row51cell9 = row51.getCell(10);

		if (row51cell9 != null) {
			row51cell9.setCellValue(brf96ARow1TO471.getR51_government_non_resident() == null ? 0
					: brf96ARow1TO471.getR51_government_non_resident().intValue());
		}

		Cell row51cell10 = row51.getCell(11);

		if (row51cell10 != null) {
			row51cell10.setCellValue(brf96ARow1TO471.getR51_gre_non_resident() == null ? 0
					: brf96ARow1TO471.getR51_gre_non_resident().intValue());
		}

		Cell row51cell11 = row51.getCell(12);

		if (row51cell11 != null) {
			row51cell11.setCellValue(brf96ARow1TO471.getR51_private_non_resident() == null ? 0
					: brf96ARow1TO471.getR51_private_non_resident().intValue());
		}

		Cell row51cell12 = row51.getCell(13);

		if (row51cell12 != null) {
			row51cell12.setCellValue(brf96ARow1TO471.getR51_hni_non_resident() == null ? 0
					: brf96ARow1TO471.getR51_hni_non_resident().intValue());
		}

		Cell row51cell13 = row51.getCell(14);

		if (row51cell13 != null) {
			row51cell13.setCellValue(brf96ARow1TO471.getR51_individual_non_resident() == null ? 0
					: brf96ARow1TO471.getR51_individual_non_resident().intValue());
		}

		Cell row51cell14 = row51.getCell(15);

		if (row51cell14 != null) {
			row51cell14.setCellValue(brf96ARow1TO471.getR51_banking_non_resident() == null ? 0
					: brf96ARow1TO471.getR51_banking_non_resident().intValue());
		}

		Cell row51cell15 = row51.getCell(16);

		if (row51cell15 != null) {
			row51cell15.setCellValue(brf96ARow1TO471.getR51_trade_non_resident() == null ? 0
					: brf96ARow1TO471.getR51_trade_non_resident().intValue());
		}

		// ROW 47

		Row row52 = sheet.getRow(51);

		Cell row52cell1 = row52.getCell(2);

		if (row52cell1 != null) {
			row52cell1.setCellValue(brf96ARow1TO471.getR52_country() == null ? "0" : brf96ARow1TO471.getR52_country());
		}

		Cell row52cell2 = row52.getCell(3);

		if (row52cell2 != null) {
			row52cell2.setCellValue(brf96ARow1TO471.getR52_government_resident() == null ? 0
					: brf96ARow1TO471.getR52_government_resident().intValue());
		}

		Cell row52cell3 = row52.getCell(4);

		if (row52cell3 != null) {
			row52cell3.setCellValue(brf96ARow1TO471.getR52_gre_resident() == null ? 0
					: brf96ARow1TO471.getR52_gre_resident().intValue());
		}

		Cell row52cell4 = row52.getCell(5);

		if (row52cell4 != null) {
			row52cell4.setCellValue(brf96ARow1TO471.getR52_private_resident() == null ? 0
					: brf96ARow1TO471.getR52_private_resident().intValue());
		}

		Cell row52cell5 = row52.getCell(6);

		if (row52cell5 != null) {
			row52cell5.setCellValue(brf96ARow1TO471.getR52_hni_resident() == null ? 0
					: brf96ARow1TO471.getR52_hni_resident().intValue());
		}

		Cell row52cell6 = row52.getCell(7);

		if (row52cell6 != null) {
			row52cell6.setCellValue(brf96ARow1TO471.getR52_individual_resident() == null ? 0
					: brf96ARow1TO471.getR52_individual_resident().intValue());
		}

		Cell row52cell7 = row52.getCell(8);

		if (row52cell7 != null) {
			row52cell7.setCellValue(brf96ARow1TO471.getR52_banking_resident() == null ? 0
					: brf96ARow1TO471.getR52_banking_resident().intValue());
		}

		Cell row52cell8 = row52.getCell(9);

		if (row52cell8 != null) {
			row52cell8.setCellValue(brf96ARow1TO471.getR52_trade_resident() == null ? 0
					: brf96ARow1TO471.getR52_trade_resident().intValue());
		}

		Cell row52cell9 = row52.getCell(10);

		if (row52cell9 != null) {
			row52cell9.setCellValue(brf96ARow1TO471.getR52_government_non_resident() == null ? 0
					: brf96ARow1TO471.getR52_government_non_resident().intValue());
		}

		Cell row52cell10 = row52.getCell(11);

		if (row52cell10 != null) {
			row52cell10.setCellValue(brf96ARow1TO471.getR52_gre_non_resident() == null ? 0
					: brf96ARow1TO471.getR52_gre_non_resident().intValue());
		}

		Cell row52cell11 = row52.getCell(12);

		if (row52cell11 != null) {
			row52cell11.setCellValue(brf96ARow1TO471.getR52_private_non_resident() == null ? 0
					: brf96ARow1TO471.getR52_private_non_resident().intValue());
		}

		Cell row52cell12 = row52.getCell(13);

		if (row52cell12 != null) {
			row52cell12.setCellValue(brf96ARow1TO471.getR52_hni_non_resident() == null ? 0
					: brf96ARow1TO471.getR52_hni_non_resident().intValue());
		}

		Cell row52cell13 = row52.getCell(14);

		if (row52cell13 != null) {
			row52cell13.setCellValue(brf96ARow1TO471.getR52_individual_non_resident() == null ? 0
					: brf96ARow1TO471.getR52_individual_non_resident().intValue());
		}

		Cell row52cell14 = row52.getCell(15);

		if (row52cell14 != null) {
			row52cell14.setCellValue(brf96ARow1TO471.getR52_banking_non_resident() == null ? 0
					: brf96ARow1TO471.getR52_banking_non_resident().intValue());
		}

		Cell row52cell15 = row52.getCell(16);

		if (row52cell15 != null) {
			row52cell15.setCellValue(brf96ARow1TO471.getR52_trade_non_resident() == null ? 0
					: brf96ARow1TO471.getR52_trade_non_resident().intValue());
		}

		// ROW 47

		Row row53 = sheet.getRow(52);

		Cell row53cell1 = row53.getCell(2);

		if (row53cell1 != null) {
			row53cell1.setCellValue(brf96ARow1TO471.getR53_country() == null ? "0" : brf96ARow1TO471.getR53_country());
		}

		Cell row53cell2 = row53.getCell(3);

		if (row53cell2 != null) {
			row53cell2.setCellValue(brf96ARow1TO471.getR53_government_resident() == null ? 0
					: brf96ARow1TO471.getR53_government_resident().intValue());
		}

		Cell row53cell3 = row53.getCell(4);

		if (row53cell3 != null) {
			row53cell3.setCellValue(brf96ARow1TO471.getR53_gre_resident() == null ? 0
					: brf96ARow1TO471.getR53_gre_resident().intValue());
		}

		Cell row53cell4 = row53.getCell(5);

		if (row53cell4 != null) {
			row53cell4.setCellValue(brf96ARow1TO471.getR53_private_resident() == null ? 0
					: brf96ARow1TO471.getR53_private_resident().intValue());
		}

		Cell row53cell5 = row53.getCell(6);

		if (row53cell5 != null) {
			row53cell5.setCellValue(brf96ARow1TO471.getR53_hni_resident() == null ? 0
					: brf96ARow1TO471.getR53_hni_resident().intValue());
		}

		Cell row53cell6 = row53.getCell(7);

		if (row53cell6 != null) {
			row53cell6.setCellValue(brf96ARow1TO471.getR53_individual_resident() == null ? 0
					: brf96ARow1TO471.getR53_individual_resident().intValue());
		}

		Cell row53cell7 = row53.getCell(8);

		if (row53cell7 != null) {
			row53cell7.setCellValue(brf96ARow1TO471.getR53_banking_resident() == null ? 0
					: brf96ARow1TO471.getR53_banking_resident().intValue());
		}

		Cell row53cell8 = row53.getCell(9);

		if (row53cell8 != null) {
			row53cell8.setCellValue(brf96ARow1TO471.getR53_trade_resident() == null ? 0
					: brf96ARow1TO471.getR53_trade_resident().intValue());
		}

		Cell row53cell9 = row53.getCell(10);

		if (row53cell9 != null) {
			row53cell9.setCellValue(brf96ARow1TO471.getR53_government_non_resident() == null ? 0
					: brf96ARow1TO471.getR53_government_non_resident().intValue());
		}

		Cell row53cell10 = row53.getCell(11);

		if (row53cell10 != null) {
			row53cell10.setCellValue(brf96ARow1TO471.getR53_gre_non_resident() == null ? 0
					: brf96ARow1TO471.getR53_gre_non_resident().intValue());
		}

		Cell row53cell11 = row53.getCell(12);

		if (row53cell11 != null) {
			row53cell11.setCellValue(brf96ARow1TO471.getR53_private_non_resident() == null ? 0
					: brf96ARow1TO471.getR53_private_non_resident().intValue());
		}

		Cell row53cell12 = row53.getCell(13);

		if (row53cell12 != null) {
			row53cell12.setCellValue(brf96ARow1TO471.getR53_hni_non_resident() == null ? 0
					: brf96ARow1TO471.getR53_hni_non_resident().intValue());
		}

		Cell row53cell13 = row53.getCell(14);

		if (row53cell13 != null) {
			row53cell13.setCellValue(brf96ARow1TO471.getR53_individual_non_resident() == null ? 0
					: brf96ARow1TO471.getR53_individual_non_resident().intValue());
		}

		Cell row53cell14 = row53.getCell(15);

		if (row53cell14 != null) {
			row53cell14.setCellValue(brf96ARow1TO471.getR53_banking_non_resident() == null ? 0
					: brf96ARow1TO471.getR53_banking_non_resident().intValue());
		}

		Cell row53cell15 = row53.getCell(16);

		if (row53cell15 != null) {
			row53cell15.setCellValue(brf96ARow1TO471.getR53_trade_non_resident() == null ? 0
					: brf96ARow1TO471.getR53_trade_non_resident().intValue());
		}

		// ROW 47

		Row row55 = sheet.getRow(54);

		Cell row55cell1 = row55.getCell(2);

		if (row55cell1 != null) {
			row55cell1.setCellValue(brf96ARow1TO471.getR55_country() == null ? "0" : brf96ARow1TO471.getR55_country());
		}

		Cell row55cell2 = row55.getCell(3);

		if (row55cell2 != null) {
			row55cell2.setCellValue(brf96ARow1TO471.getR55_government_resident() == null ? 0
					: brf96ARow1TO471.getR55_government_resident().intValue());
		}

		Cell row55cell3 = row55.getCell(4);

		if (row55cell3 != null) {
			row55cell3.setCellValue(brf96ARow1TO471.getR55_gre_resident() == null ? 0
					: brf96ARow1TO471.getR55_gre_resident().intValue());
		}

		Cell row55cell4 = row55.getCell(5);

		if (row55cell4 != null) {
			row55cell4.setCellValue(brf96ARow1TO471.getR55_private_resident() == null ? 0
					: brf96ARow1TO471.getR55_private_resident().intValue());
		}

		Cell row55cell5 = row55.getCell(6);

		if (row55cell5 != null) {
			row55cell5.setCellValue(brf96ARow1TO471.getR55_hni_resident() == null ? 0
					: brf96ARow1TO471.getR55_hni_resident().intValue());
		}

		Cell row55cell6 = row55.getCell(7);

		if (row55cell6 != null) {
			row55cell6.setCellValue(brf96ARow1TO471.getR55_individual_resident() == null ? 0
					: brf96ARow1TO471.getR55_individual_resident().intValue());
		}

		Cell row55cell7 = row55.getCell(8);

		if (row55cell7 != null) {
			row55cell7.setCellValue(brf96ARow1TO471.getR55_banking_resident() == null ? 0
					: brf96ARow1TO471.getR55_banking_resident().intValue());
		}

		Cell row55cell8 = row55.getCell(9);

		if (row55cell8 != null) {
			row55cell8.setCellValue(brf96ARow1TO471.getR55_trade_resident() == null ? 0
					: brf96ARow1TO471.getR55_trade_resident().intValue());
		}

		Cell row55cell9 = row55.getCell(10);

		if (row55cell9 != null) {
			row55cell9.setCellValue(brf96ARow1TO471.getR55_government_non_resident() == null ? 0
					: brf96ARow1TO471.getR55_government_non_resident().intValue());
		}

		Cell row55cell10 = row55.getCell(11);

		if (row55cell10 != null) {
			row55cell10.setCellValue(brf96ARow1TO471.getR55_gre_non_resident() == null ? 0
					: brf96ARow1TO471.getR55_gre_non_resident().intValue());
		}

		Cell row55cell11 = row55.getCell(12);

		if (row55cell11 != null) {
			row55cell11.setCellValue(brf96ARow1TO471.getR55_private_non_resident() == null ? 0
					: brf96ARow1TO471.getR55_private_non_resident().intValue());
		}

		Cell row55cell12 = row55.getCell(13);

		if (row55cell12 != null) {
			row55cell12.setCellValue(brf96ARow1TO471.getR55_hni_non_resident() == null ? 0
					: brf96ARow1TO471.getR55_hni_non_resident().intValue());
		}

		Cell row55cell13 = row55.getCell(14);

		if (row55cell13 != null) {
			row55cell13.setCellValue(brf96ARow1TO471.getR55_individual_non_resident() == null ? 0
					: brf96ARow1TO471.getR55_individual_non_resident().intValue());
		}

		Cell row55cell14 = row55.getCell(15);

		if (row55cell14 != null) {
			row55cell14.setCellValue(brf96ARow1TO471.getR55_banking_non_resident() == null ? 0
					: brf96ARow1TO471.getR55_banking_non_resident().intValue());
		}

		Cell row55cell15 = row55.getCell(16);

		if (row55cell15 != null) {
			row55cell15.setCellValue(brf96ARow1TO471.getR55_trade_non_resident() == null ? 0
					: brf96ARow1TO471.getR55_trade_non_resident().intValue());
		}

		// ROW 47

		Row row56 = sheet.getRow(55);

		Cell row56cell1 = row56.getCell(2);

		if (row56cell1 != null) {
			row56cell1.setCellValue(brf96ARow1TO471.getR56_country() == null ? "0" : brf96ARow1TO471.getR56_country());
		}

		Cell row56cell2 = row56.getCell(3);

		if (row56cell2 != null) {
			row56cell2.setCellValue(brf96ARow1TO471.getR56_government_resident() == null ? 0
					: brf96ARow1TO471.getR56_government_resident().intValue());
		}

		Cell row56cell3 = row56.getCell(4);

		if (row56cell3 != null) {
			row56cell3.setCellValue(brf96ARow1TO471.getR56_gre_resident() == null ? 0
					: brf96ARow1TO471.getR56_gre_resident().intValue());
		}

		Cell row56cell4 = row56.getCell(5);

		if (row56cell4 != null) {
			row56cell4.setCellValue(brf96ARow1TO471.getR56_private_resident() == null ? 0
					: brf96ARow1TO471.getR56_private_resident().intValue());
		}

		Cell row56cell5 = row56.getCell(6);

		if (row56cell5 != null) {
			row56cell5.setCellValue(brf96ARow1TO471.getR56_hni_resident() == null ? 0
					: brf96ARow1TO471.getR56_hni_resident().intValue());
		}

		Cell row56cell6 = row56.getCell(7);

		if (row56cell6 != null) {
			row56cell6.setCellValue(brf96ARow1TO471.getR56_individual_resident() == null ? 0
					: brf96ARow1TO471.getR56_individual_resident().intValue());
		}

		Cell row56cell7 = row56.getCell(8);

		if (row56cell7 != null) {
			row56cell7.setCellValue(brf96ARow1TO471.getR56_banking_resident() == null ? 0
					: brf96ARow1TO471.getR56_banking_resident().intValue());
		}

		Cell row56cell8 = row56.getCell(9);

		if (row56cell8 != null) {
			row56cell8.setCellValue(brf96ARow1TO471.getR56_trade_resident() == null ? 0
					: brf96ARow1TO471.getR56_trade_resident().intValue());
		}

		Cell row56cell9 = row56.getCell(10);

		if (row56cell9 != null) {
			row56cell9.setCellValue(brf96ARow1TO471.getR56_government_non_resident() == null ? 0
					: brf96ARow1TO471.getR56_government_non_resident().intValue());
		}

		Cell row56cell10 = row56.getCell(11);

		if (row56cell10 != null) {
			row56cell10.setCellValue(brf96ARow1TO471.getR56_gre_non_resident() == null ? 0
					: brf96ARow1TO471.getR56_gre_non_resident().intValue());
		}

		Cell row56cell11 = row56.getCell(12);

		if (row56cell11 != null) {
			row56cell11.setCellValue(brf96ARow1TO471.getR56_private_non_resident() == null ? 0
					: brf96ARow1TO471.getR56_private_non_resident().intValue());
		}

		Cell row56cell12 = row56.getCell(13);

		if (row56cell12 != null) {
			row56cell12.setCellValue(brf96ARow1TO471.getR56_hni_non_resident() == null ? 0
					: brf96ARow1TO471.getR56_hni_non_resident().intValue());
		}

		Cell row56cell13 = row56.getCell(14);

		if (row56cell13 != null) {
			row56cell13.setCellValue(brf96ARow1TO471.getR56_individual_non_resident() == null ? 0
					: brf96ARow1TO471.getR56_individual_non_resident().intValue());
		}

		Cell row56cell14 = row56.getCell(15);

		if (row56cell14 != null) {
			row56cell14.setCellValue(brf96ARow1TO471.getR56_banking_non_resident() == null ? 0
					: brf96ARow1TO471.getR56_banking_non_resident().intValue());
		}

		Cell row56cell15 = row56.getCell(16);

		if (row56cell15 != null) {
			row56cell15.setCellValue(brf96ARow1TO471.getR56_trade_non_resident() == null ? 0
					: brf96ARow1TO471.getR56_trade_non_resident().intValue());
		}

		// ROW 47

		Row row57 = sheet.getRow(56);

		Cell row57cell1 = row57.getCell(2);

		if (row57cell1 != null) {
			row57cell1.setCellValue(brf96ARow1TO471.getR57_country() == null ? "0" : brf96ARow1TO471.getR57_country());
		}

		Cell row57cell2 = row57.getCell(3);

		if (row57cell2 != null) {
			row57cell2.setCellValue(brf96ARow1TO471.getR57_government_resident() == null ? 0
					: brf96ARow1TO471.getR57_government_resident().intValue());
		}

		Cell row57cell3 = row57.getCell(4);

		if (row57cell3 != null) {
			row57cell3.setCellValue(brf96ARow1TO471.getR57_gre_resident() == null ? 0
					: brf96ARow1TO471.getR57_gre_resident().intValue());
		}

		Cell row57cell4 = row57.getCell(5);

		if (row57cell4 != null) {
			row57cell4.setCellValue(brf96ARow1TO471.getR57_private_resident() == null ? 0
					: brf96ARow1TO471.getR57_private_resident().intValue());
		}

		Cell row57cell5 = row57.getCell(6);

		if (row57cell5 != null) {
			row57cell5.setCellValue(brf96ARow1TO471.getR57_hni_resident() == null ? 0
					: brf96ARow1TO471.getR57_hni_resident().intValue());
		}

		Cell row57cell6 = row57.getCell(7);

		if (row57cell6 != null) {
			row57cell6.setCellValue(brf96ARow1TO471.getR57_individual_resident() == null ? 0
					: brf96ARow1TO471.getR57_individual_resident().intValue());
		}

		Cell row57cell7 = row57.getCell(8);

		if (row57cell7 != null) {
			row57cell7.setCellValue(brf96ARow1TO471.getR57_banking_resident() == null ? 0
					: brf96ARow1TO471.getR57_banking_resident().intValue());
		}

		Cell row57cell8 = row57.getCell(9);

		if (row57cell8 != null) {
			row57cell8.setCellValue(brf96ARow1TO471.getR57_trade_resident() == null ? 0
					: brf96ARow1TO471.getR57_trade_resident().intValue());
		}

		Cell row57cell9 = row57.getCell(10);

		if (row57cell9 != null) {
			row57cell9.setCellValue(brf96ARow1TO471.getR57_government_non_resident() == null ? 0
					: brf96ARow1TO471.getR57_government_non_resident().intValue());
		}

		Cell row57cell10 = row57.getCell(11);

		if (row57cell10 != null) {
			row57cell10.setCellValue(brf96ARow1TO471.getR57_gre_non_resident() == null ? 0
					: brf96ARow1TO471.getR57_gre_non_resident().intValue());
		}

		Cell row57cell11 = row57.getCell(12);

		if (row57cell11 != null) {
			row57cell11.setCellValue(brf96ARow1TO471.getR57_private_non_resident() == null ? 0
					: brf96ARow1TO471.getR57_private_non_resident().intValue());
		}

		Cell row57cell12 = row57.getCell(13);

		if (row57cell12 != null) {
			row57cell12.setCellValue(brf96ARow1TO471.getR57_hni_non_resident() == null ? 0
					: brf96ARow1TO471.getR57_hni_non_resident().intValue());
		}

		Cell row57cell13 = row57.getCell(14);

		if (row57cell13 != null) {
			row57cell13.setCellValue(brf96ARow1TO471.getR57_individual_non_resident() == null ? 0
					: brf96ARow1TO471.getR57_individual_non_resident().intValue());
		}

		Cell row57cell14 = row57.getCell(15);

		if (row57cell14 != null) {
			row57cell14.setCellValue(brf96ARow1TO471.getR57_banking_non_resident() == null ? 0
					: brf96ARow1TO471.getR57_banking_non_resident().intValue());
		}

		Cell row57cell15 = row57.getCell(16);

		if (row57cell15 != null) {
			row57cell15.setCellValue(brf96ARow1TO471.getR57_trade_non_resident() == null ? 0
					: brf96ARow1TO471.getR57_trade_non_resident().intValue());
		}

		// ROW 47

		Row row58 = sheet.getRow(57);

		Cell row58cell1 = row58.getCell(2);

		if (row58cell1 != null) {
			row58cell1.setCellValue(brf96ARow1TO471.getR58_country() == null ? "0" : brf96ARow1TO471.getR58_country());
		}

		Cell row58cell2 = row58.getCell(3);

		if (row58cell2 != null) {
			row58cell2.setCellValue(brf96ARow1TO471.getR58_government_resident() == null ? 0
					: brf96ARow1TO471.getR58_government_resident().intValue());
		}

		Cell row58cell3 = row58.getCell(4);

		if (row58cell3 != null) {
			row58cell3.setCellValue(brf96ARow1TO471.getR58_gre_resident() == null ? 0
					: brf96ARow1TO471.getR58_gre_resident().intValue());
		}

		Cell row58cell4 = row58.getCell(5);

		if (row58cell4 != null) {
			row58cell4.setCellValue(brf96ARow1TO471.getR58_private_resident() == null ? 0
					: brf96ARow1TO471.getR58_private_resident().intValue());
		}

		Cell row58cell5 = row58.getCell(6);

		if (row58cell5 != null) {
			row58cell5.setCellValue(brf96ARow1TO471.getR58_hni_resident() == null ? 0
					: brf96ARow1TO471.getR58_hni_resident().intValue());
		}

		Cell row58cell6 = row58.getCell(7);

		if (row58cell6 != null) {
			row58cell6.setCellValue(brf96ARow1TO471.getR58_individual_resident() == null ? 0
					: brf96ARow1TO471.getR58_individual_resident().intValue());
		}

		Cell row58cell7 = row58.getCell(8);

		if (row58cell7 != null) {
			row58cell7.setCellValue(brf96ARow1TO471.getR58_banking_resident() == null ? 0
					: brf96ARow1TO471.getR58_banking_resident().intValue());
		}

		Cell row58cell8 = row58.getCell(9);

		if (row58cell8 != null) {
			row58cell8.setCellValue(brf96ARow1TO471.getR58_trade_resident() == null ? 0
					: brf96ARow1TO471.getR58_trade_resident().intValue());
		}

		Cell row58cell9 = row58.getCell(10);

		if (row58cell9 != null) {
			row58cell9.setCellValue(brf96ARow1TO471.getR58_government_non_resident() == null ? 0
					: brf96ARow1TO471.getR58_government_non_resident().intValue());
		}

		Cell row58cell10 = row58.getCell(11);

		if (row58cell10 != null) {
			row58cell10.setCellValue(brf96ARow1TO471.getR58_gre_non_resident() == null ? 0
					: brf96ARow1TO471.getR58_gre_non_resident().intValue());
		}

		Cell row58cell11 = row58.getCell(12);

		if (row58cell11 != null) {
			row58cell11.setCellValue(brf96ARow1TO471.getR58_private_non_resident() == null ? 0
					: brf96ARow1TO471.getR58_private_non_resident().intValue());
		}

		Cell row58cell12 = row58.getCell(13);

		if (row58cell12 != null) {
			row58cell12.setCellValue(brf96ARow1TO471.getR58_hni_non_resident() == null ? 0
					: brf96ARow1TO471.getR58_hni_non_resident().intValue());
		}

		Cell row58cell13 = row58.getCell(14);

		if (row58cell13 != null) {
			row58cell13.setCellValue(brf96ARow1TO471.getR58_individual_non_resident() == null ? 0
					: brf96ARow1TO471.getR58_individual_non_resident().intValue());
		}

		Cell row58cell14 = row58.getCell(15);

		if (row58cell14 != null) {
			row58cell14.setCellValue(brf96ARow1TO471.getR58_banking_non_resident() == null ? 0
					: brf96ARow1TO471.getR58_banking_non_resident().intValue());
		}

		Cell row58cell15 = row58.getCell(16);

		if (row58cell15 != null) {
			row58cell15.setCellValue(brf96ARow1TO471.getR58_trade_non_resident() == null ? 0
					: brf96ARow1TO471.getR58_trade_non_resident().intValue());
		}

		// ROW 47

		Row row59 = sheet.getRow(58);

		Cell row59cell1 = row59.getCell(2);

		if (row59cell1 != null) {
			row59cell1.setCellValue(brf96ARow1TO471.getR59_country() == null ? "0" : brf96ARow1TO471.getR59_country());
		}

		Cell row59cell2 = row59.getCell(3);

		if (row59cell2 != null) {
			row59cell2.setCellValue(brf96ARow1TO471.getR59_government_resident() == null ? 0
					: brf96ARow1TO471.getR59_government_resident().intValue());
		}

		Cell row59cell3 = row59.getCell(4);

		if (row59cell3 != null) {
			row59cell3.setCellValue(brf96ARow1TO471.getR59_gre_resident() == null ? 0
					: brf96ARow1TO471.getR59_gre_resident().intValue());
		}

		Cell row59cell4 = row59.getCell(5);

		if (row59cell4 != null) {
			row59cell4.setCellValue(brf96ARow1TO471.getR59_private_resident() == null ? 0
					: brf96ARow1TO471.getR59_private_resident().intValue());
		}

		Cell row59cell5 = row59.getCell(6);

		if (row59cell5 != null) {
			row59cell5.setCellValue(brf96ARow1TO471.getR59_hni_resident() == null ? 0
					: brf96ARow1TO471.getR59_hni_resident().intValue());
		}

		Cell row59cell6 = row59.getCell(7);

		if (row59cell6 != null) {
			row59cell6.setCellValue(brf96ARow1TO471.getR59_individual_resident() == null ? 0
					: brf96ARow1TO471.getR59_individual_resident().intValue());
		}

		Cell row59cell7 = row59.getCell(8);

		if (row59cell7 != null) {
			row59cell7.setCellValue(brf96ARow1TO471.getR59_banking_resident() == null ? 0
					: brf96ARow1TO471.getR59_banking_resident().intValue());
		}

		Cell row59cell8 = row59.getCell(9);

		if (row59cell8 != null) {
			row59cell8.setCellValue(brf96ARow1TO471.getR59_trade_resident() == null ? 0
					: brf96ARow1TO471.getR59_trade_resident().intValue());
		}

		Cell row59cell9 = row59.getCell(10);

		if (row59cell9 != null) {
			row59cell9.setCellValue(brf96ARow1TO471.getR59_government_non_resident() == null ? 0
					: brf96ARow1TO471.getR59_government_non_resident().intValue());
		}

		Cell row59cell10 = row59.getCell(11);

		if (row59cell10 != null) {
			row59cell10.setCellValue(brf96ARow1TO471.getR59_gre_non_resident() == null ? 0
					: brf96ARow1TO471.getR59_gre_non_resident().intValue());
		}

		Cell row59cell11 = row59.getCell(12);

		if (row59cell11 != null) {
			row59cell11.setCellValue(brf96ARow1TO471.getR59_private_non_resident() == null ? 0
					: brf96ARow1TO471.getR59_private_non_resident().intValue());
		}

		Cell row59cell12 = row59.getCell(13);

		if (row59cell12 != null) {
			row59cell12.setCellValue(brf96ARow1TO471.getR59_hni_non_resident() == null ? 0
					: brf96ARow1TO471.getR59_hni_non_resident().intValue());
		}

		Cell row59cell13 = row59.getCell(14);

		if (row59cell13 != null) {
			row59cell13.setCellValue(brf96ARow1TO471.getR59_individual_non_resident() == null ? 0
					: brf96ARow1TO471.getR59_individual_non_resident().intValue());
		}

		Cell row59cell14 = row59.getCell(15);

		if (row59cell14 != null) {
			row59cell14.setCellValue(brf96ARow1TO471.getR59_banking_non_resident() == null ? 0
					: brf96ARow1TO471.getR59_banking_non_resident().intValue());
		}

		Cell row59cell15 = row59.getCell(16);

		if (row59cell15 != null) {
			row59cell15.setCellValue(brf96ARow1TO471.getR59_trade_non_resident() == null ? 0
					: brf96ARow1TO471.getR59_trade_non_resident().intValue());
		}

		// ROW 47

		Row row60 = sheet.getRow(59);

		Cell row60cell1 = row60.getCell(2);

		if (row60cell1 != null) {
			row60cell1.setCellValue(brf96ARow1TO471.getR60_country() == null ? "0" : brf96ARow1TO471.getR60_country());
		}

		Cell row60cell2 = row60.getCell(3);

		if (row60cell2 != null) {
			row60cell2.setCellValue(brf96ARow1TO471.getR60_government_resident() == null ? 0
					: brf96ARow1TO471.getR60_government_resident().intValue());
		}

		Cell row60cell3 = row60.getCell(4);

		if (row60cell3 != null) {
			row60cell3.setCellValue(brf96ARow1TO471.getR60_gre_resident() == null ? 0
					: brf96ARow1TO471.getR60_gre_resident().intValue());
		}

		Cell row60cell4 = row60.getCell(5);

		if (row60cell4 != null) {
			row60cell4.setCellValue(brf96ARow1TO471.getR60_private_resident() == null ? 0
					: brf96ARow1TO471.getR60_private_resident().intValue());
		}

		Cell row60cell5 = row60.getCell(6);

		if (row60cell5 != null) {
			row60cell5.setCellValue(brf96ARow1TO471.getR60_hni_resident() == null ? 0
					: brf96ARow1TO471.getR60_hni_resident().intValue());
		}

		Cell row60cell6 = row60.getCell(7);

		if (row60cell6 != null) {
			row60cell6.setCellValue(brf96ARow1TO471.getR60_individual_resident() == null ? 0
					: brf96ARow1TO471.getR60_individual_resident().intValue());
		}

		Cell row60cell7 = row60.getCell(8);

		if (row60cell7 != null) {
			row60cell7.setCellValue(brf96ARow1TO471.getR60_banking_resident() == null ? 0
					: brf96ARow1TO471.getR60_banking_resident().intValue());
		}

		Cell row60cell8 = row60.getCell(9);

		if (row60cell8 != null) {
			row60cell8.setCellValue(brf96ARow1TO471.getR60_trade_resident() == null ? 0
					: brf96ARow1TO471.getR60_trade_resident().intValue());
		}

		Cell row60cell9 = row60.getCell(10);

		if (row60cell9 != null) {
			row60cell9.setCellValue(brf96ARow1TO471.getR60_government_non_resident() == null ? 0
					: brf96ARow1TO471.getR60_government_non_resident().intValue());
		}

		Cell row60cell10 = row60.getCell(11);

		if (row60cell10 != null) {
			row60cell10.setCellValue(brf96ARow1TO471.getR60_gre_non_resident() == null ? 0
					: brf96ARow1TO471.getR60_gre_non_resident().intValue());
		}

		Cell row60cell11 = row60.getCell(12);

		if (row60cell11 != null) {
			row60cell11.setCellValue(brf96ARow1TO471.getR60_private_non_resident() == null ? 0
					: brf96ARow1TO471.getR60_private_non_resident().intValue());
		}

		Cell row60cell12 = row60.getCell(13);

		if (row60cell12 != null) {
			row60cell12.setCellValue(brf96ARow1TO471.getR60_hni_non_resident() == null ? 0
					: brf96ARow1TO471.getR60_hni_non_resident().intValue());
		}

		Cell row60cell13 = row60.getCell(14);

		if (row60cell13 != null) {
			row60cell13.setCellValue(brf96ARow1TO471.getR60_individual_non_resident() == null ? 0
					: brf96ARow1TO471.getR60_individual_non_resident().intValue());
		}

		Cell row60cell14 = row60.getCell(15);

		if (row60cell14 != null) {
			row60cell14.setCellValue(brf96ARow1TO471.getR60_banking_non_resident() == null ? 0
					: brf96ARow1TO471.getR60_banking_non_resident().intValue());
		}

		Cell row60cell15 = row60.getCell(16);

		if (row60cell15 != null) {
			row60cell15.setCellValue(brf96ARow1TO471.getR60_trade_non_resident() == null ? 0
					: brf96ARow1TO471.getR60_trade_non_resident().intValue());
		}

		// ROW 47

		Row row61 = sheet.getRow(60);

		Cell row61cell1 = row61.getCell(2);

		if (row61cell1 != null) {
			row61cell1.setCellValue(brf96ARow1TO471.getR61_country() == null ? "0" : brf96ARow1TO471.getR61_country());
		}

		Cell row61cell2 = row61.getCell(3);

		if (row61cell2 != null) {
			row61cell2.setCellValue(brf96ARow1TO471.getR61_government_resident() == null ? 0
					: brf96ARow1TO471.getR61_government_resident().intValue());
		}

		Cell row61cell3 = row61.getCell(4);

		if (row61cell3 != null) {
			row61cell3.setCellValue(brf96ARow1TO471.getR61_gre_resident() == null ? 0
					: brf96ARow1TO471.getR61_gre_resident().intValue());
		}

		Cell row61cell4 = row61.getCell(5);

		if (row61cell4 != null) {
			row61cell4.setCellValue(brf96ARow1TO471.getR61_private_resident() == null ? 0
					: brf96ARow1TO471.getR61_private_resident().intValue());
		}

		Cell row61cell5 = row61.getCell(6);

		if (row61cell5 != null) {
			row61cell5.setCellValue(brf96ARow1TO471.getR61_hni_resident() == null ? 0
					: brf96ARow1TO471.getR61_hni_resident().intValue());
		}

		Cell row61cell6 = row61.getCell(7);

		if (row61cell6 != null) {
			row61cell6.setCellValue(brf96ARow1TO471.getR61_individual_resident() == null ? 0
					: brf96ARow1TO471.getR61_individual_resident().intValue());
		}

		Cell row61cell7 = row61.getCell(8);

		if (row61cell7 != null) {
			row61cell7.setCellValue(brf96ARow1TO471.getR61_banking_resident() == null ? 0
					: brf96ARow1TO471.getR61_banking_resident().intValue());
		}

		Cell row61cell8 = row61.getCell(9);

		if (row61cell8 != null) {
			row61cell8.setCellValue(brf96ARow1TO471.getR61_trade_resident() == null ? 0
					: brf96ARow1TO471.getR61_trade_resident().intValue());
		}

		Cell row61cell9 = row61.getCell(10);

		if (row61cell9 != null) {
			row61cell9.setCellValue(brf96ARow1TO471.getR61_government_non_resident() == null ? 0
					: brf96ARow1TO471.getR61_government_non_resident().intValue());
		}

		Cell row61cell10 = row61.getCell(11);

		if (row61cell10 != null) {
			row61cell10.setCellValue(brf96ARow1TO471.getR61_gre_non_resident() == null ? 0
					: brf96ARow1TO471.getR61_gre_non_resident().intValue());
		}

		Cell row61cell11 = row61.getCell(12);

		if (row61cell11 != null) {
			row61cell11.setCellValue(brf96ARow1TO471.getR61_private_non_resident() == null ? 0
					: brf96ARow1TO471.getR61_private_non_resident().intValue());
		}

		Cell row61cell12 = row61.getCell(13);

		if (row61cell12 != null) {
			row61cell12.setCellValue(brf96ARow1TO471.getR61_hni_non_resident() == null ? 0
					: brf96ARow1TO471.getR61_hni_non_resident().intValue());
		}

		Cell row61cell13 = row61.getCell(14);

		if (row61cell13 != null) {
			row61cell13.setCellValue(brf96ARow1TO471.getR61_individual_non_resident() == null ? 0
					: brf96ARow1TO471.getR61_individual_non_resident().intValue());
		}

		Cell row61cell14 = row61.getCell(15);

		if (row61cell14 != null) {
			row61cell14.setCellValue(brf96ARow1TO471.getR61_banking_non_resident() == null ? 0
					: brf96ARow1TO471.getR61_banking_non_resident().intValue());
		}

		Cell row61cell15 = row61.getCell(16);

		if (row61cell15 != null) {
			row61cell15.setCellValue(brf96ARow1TO471.getR61_trade_non_resident() == null ? 0
					: brf96ARow1TO471.getR61_trade_non_resident().intValue());
		}

	}

	public void updateSheetRow62To1033(Sheet sheet, BRF45_ENTITY2 brf206Row1TO472) {
		// ROW 62

		Row row62 = sheet.getRow(61);

		Cell row62cell1 = row62.getCell(2);

		if (row62cell1 != null) {
			row62cell1.setCellValue(brf206Row1TO472.getR62_country() == null ? "0" : brf206Row1TO472.getR62_country());
		}

		Cell row62cell2 = row62.getCell(3);

		if (row62cell2 != null) {
			row62cell2.setCellValue(brf206Row1TO472.getR62_government_resident() == null ? 0
					: brf206Row1TO472.getR62_government_resident().intValue());
		}

		Cell row62cell3 = row62.getCell(4);

		if (row62cell3 != null) {
			row62cell3.setCellValue(brf206Row1TO472.getR62_gre_resident() == null ? 0
					: brf206Row1TO472.getR62_gre_resident().intValue());
		}

		Cell row62cell4 = row62.getCell(5);

		if (row62cell4 != null) {
			row62cell4.setCellValue(brf206Row1TO472.getR62_private_resident() == null ? 0
					: brf206Row1TO472.getR62_private_resident().intValue());
		}

		Cell row62cell5 = row62.getCell(6);

		if (row62cell5 != null) {
			row62cell5.setCellValue(brf206Row1TO472.getR62_hni_resident() == null ? 0
					: brf206Row1TO472.getR62_hni_resident().intValue());
		}

		Cell row62cell6 = row62.getCell(7);

		if (row62cell6 != null) {
			row62cell6.setCellValue(brf206Row1TO472.getR62_individual_resident() == null ? 0
					: brf206Row1TO472.getR62_individual_resident().intValue());
		}

		Cell row62cell7 = row62.getCell(8);

		if (row62cell7 != null) {
			row62cell7.setCellValue(brf206Row1TO472.getR62_banking_resident() == null ? 0
					: brf206Row1TO472.getR62_banking_resident().intValue());
		}

		Cell row62cell8 = row62.getCell(9);

		if (row62cell8 != null) {
			row62cell8.setCellValue(brf206Row1TO472.getR62_trade_resident() == null ? 0
					: brf206Row1TO472.getR62_trade_resident().intValue());
		}

		Cell row62cell9 = row62.getCell(10);

		if (row62cell9 != null) {
			row62cell9.setCellValue(brf206Row1TO472.getR62_government_non_resident() == null ? 0
					: brf206Row1TO472.getR62_government_non_resident().intValue());
		}

		Cell row62cell10 = row62.getCell(11);

		if (row62cell10 != null) {
			row62cell10.setCellValue(brf206Row1TO472.getR62_gre_non_resident() == null ? 0
					: brf206Row1TO472.getR62_gre_non_resident().intValue());
		}

		Cell row62cell11 = row62.getCell(12);

		if (row62cell11 != null) {
			row62cell11.setCellValue(brf206Row1TO472.getR62_private_non_resident() == null ? 0
					: brf206Row1TO472.getR62_private_non_resident().intValue());
		}

		Cell row62cell12 = row62.getCell(13);

		if (row62cell12 != null) {
			row62cell12.setCellValue(brf206Row1TO472.getR62_hni_non_resident() == null ? 0
					: brf206Row1TO472.getR62_hni_non_resident().intValue());
		}

		Cell row62cell13 = row62.getCell(14);

		if (row62cell13 != null) {
			row62cell13.setCellValue(brf206Row1TO472.getR62_individual_non_resident() == null ? 0
					: brf206Row1TO472.getR62_individual_non_resident().intValue());
		}

		Cell row62cell14 = row62.getCell(15);

		if (row62cell14 != null) {
			row62cell14.setCellValue(brf206Row1TO472.getR62_banking_non_resident() == null ? 0
					: brf206Row1TO472.getR62_banking_non_resident().intValue());
		}

		Cell row62cell15 = row62.getCell(16);

		if (row62cell15 != null) {
			row62cell15.setCellValue(brf206Row1TO472.getR62_trade_non_resident() == null ? 0
					: brf206Row1TO472.getR62_trade_non_resident().intValue());
		}

		// ROW 63

		Row row63 = sheet.getRow(62);

		Cell row63cell1 = row63.getCell(2);

		if (row63cell1 != null) {
			row63cell1.setCellValue(brf206Row1TO472.getR63_country() == null ? "0" : brf206Row1TO472.getR63_country());
		}

		Cell row63cell2 = row63.getCell(3);

		if (row63cell2 != null) {
			row63cell2.setCellValue(brf206Row1TO472.getR63_government_resident() == null ? 0
					: brf206Row1TO472.getR63_government_resident().intValue());
		}

		Cell row63cell3 = row63.getCell(4);

		if (row63cell3 != null) {
			row63cell3.setCellValue(brf206Row1TO472.getR63_gre_resident() == null ? 0
					: brf206Row1TO472.getR63_gre_resident().intValue());
		}

		Cell row63cell4 = row63.getCell(5);

		if (row63cell4 != null) {
			row63cell4.setCellValue(brf206Row1TO472.getR63_private_resident() == null ? 0
					: brf206Row1TO472.getR63_private_resident().intValue());
		}

		Cell row63cell5 = row63.getCell(6);

		if (row63cell5 != null) {
			row63cell5.setCellValue(brf206Row1TO472.getR63_hni_resident() == null ? 0
					: brf206Row1TO472.getR63_hni_resident().intValue());
		}

		Cell row63cell6 = row63.getCell(7);

		if (row63cell6 != null) {
			row63cell6.setCellValue(brf206Row1TO472.getR63_individual_resident() == null ? 0
					: brf206Row1TO472.getR63_individual_resident().intValue());
		}

		Cell row63cell7 = row63.getCell(8);

		if (row63cell7 != null) {
			row63cell7.setCellValue(brf206Row1TO472.getR63_banking_resident() == null ? 0
					: brf206Row1TO472.getR63_banking_resident().intValue());
		}

		Cell row63cell8 = row63.getCell(9);

		if (row63cell8 != null) {
			row63cell8.setCellValue(brf206Row1TO472.getR63_trade_resident() == null ? 0
					: brf206Row1TO472.getR63_trade_resident().intValue());
		}

		Cell row63cell9 = row63.getCell(10);

		if (row63cell9 != null) {
			row63cell9.setCellValue(brf206Row1TO472.getR63_government_non_resident() == null ? 0
					: brf206Row1TO472.getR63_government_non_resident().intValue());
		}

		Cell row63cell10 = row63.getCell(11);

		if (row63cell10 != null) {
			row63cell10.setCellValue(brf206Row1TO472.getR63_gre_non_resident() == null ? 0
					: brf206Row1TO472.getR63_gre_non_resident().intValue());
		}

		Cell row63cell11 = row63.getCell(12);

		if (row63cell11 != null) {
			row63cell11.setCellValue(brf206Row1TO472.getR63_private_non_resident() == null ? 0
					: brf206Row1TO472.getR63_private_non_resident().intValue());
		}

		Cell row63cell12 = row63.getCell(13);

		if (row63cell12 != null) {
			row63cell12.setCellValue(brf206Row1TO472.getR63_hni_non_resident() == null ? 0
					: brf206Row1TO472.getR63_hni_non_resident().intValue());
		}

		Cell row63cell13 = row63.getCell(14);

		if (row63cell13 != null) {
			row63cell13.setCellValue(brf206Row1TO472.getR63_individual_non_resident() == null ? 0
					: brf206Row1TO472.getR63_individual_non_resident().intValue());
		}

		Cell row63cell14 = row63.getCell(15);

		if (row63cell14 != null) {
			row63cell14.setCellValue(brf206Row1TO472.getR63_banking_non_resident() == null ? 0
					: brf206Row1TO472.getR63_banking_non_resident().intValue());
		}

		Cell row63cell15 = row63.getCell(16);

		if (row63cell15 != null) {
			row63cell15.setCellValue(brf206Row1TO472.getR63_trade_non_resident() == null ? 0
					: brf206Row1TO472.getR63_trade_non_resident().intValue());
		}

		// ROW 64

		Row row64 = sheet.getRow(63);

		Cell row64cell1 = row64.getCell(2);

		if (row64cell1 != null) {
			row64cell1.setCellValue(brf206Row1TO472.getR64_country() == null ? "0" : brf206Row1TO472.getR64_country());
		}

		Cell row64cell2 = row64.getCell(3);

		if (row64cell2 != null) {
			row64cell2.setCellValue(brf206Row1TO472.getR64_government_resident() == null ? 0
					: brf206Row1TO472.getR64_government_resident().intValue());
		}

		Cell row64cell3 = row64.getCell(4);

		if (row64cell3 != null) {
			row64cell3.setCellValue(brf206Row1TO472.getR64_gre_resident() == null ? 0
					: brf206Row1TO472.getR64_gre_resident().intValue());
		}

		Cell row64cell4 = row64.getCell(5);

		if (row64cell4 != null) {
			row64cell4.setCellValue(brf206Row1TO472.getR64_private_resident() == null ? 0
					: brf206Row1TO472.getR64_private_resident().intValue());
		}

		Cell row64cell5 = row64.getCell(6);

		if (row64cell5 != null) {
			row64cell5.setCellValue(brf206Row1TO472.getR64_hni_resident() == null ? 0
					: brf206Row1TO472.getR64_hni_resident().intValue());
		}

		Cell row64cell6 = row64.getCell(7);

		if (row64cell6 != null) {
			row64cell6.setCellValue(brf206Row1TO472.getR64_individual_resident() == null ? 0
					: brf206Row1TO472.getR64_individual_resident().intValue());
		}

		Cell row64cell7 = row64.getCell(8);

		if (row64cell7 != null) {
			row64cell7.setCellValue(brf206Row1TO472.getR64_banking_resident() == null ? 0
					: brf206Row1TO472.getR64_banking_resident().intValue());
		}

		Cell row64cell8 = row64.getCell(9);

		if (row64cell8 != null) {
			row64cell8.setCellValue(brf206Row1TO472.getR64_trade_resident() == null ? 0
					: brf206Row1TO472.getR64_trade_resident().intValue());
		}

		Cell row64cell9 = row64.getCell(10);

		if (row64cell9 != null) {
			row64cell9.setCellValue(brf206Row1TO472.getR64_government_non_resident() == null ? 0
					: brf206Row1TO472.getR64_government_non_resident().intValue());
		}

		Cell row64cell10 = row64.getCell(11);

		if (row64cell10 != null) {
			row64cell10.setCellValue(brf206Row1TO472.getR64_gre_non_resident() == null ? 0
					: brf206Row1TO472.getR64_gre_non_resident().intValue());
		}

		Cell row64cell11 = row64.getCell(12);

		if (row64cell11 != null) {
			row64cell11.setCellValue(brf206Row1TO472.getR64_private_non_resident() == null ? 0
					: brf206Row1TO472.getR64_private_non_resident().intValue());
		}

		Cell row64cell12 = row64.getCell(13);

		if (row64cell12 != null) {
			row64cell12.setCellValue(brf206Row1TO472.getR64_hni_non_resident() == null ? 0
					: brf206Row1TO472.getR64_hni_non_resident().intValue());
		}

		Cell row64cell13 = row64.getCell(14);

		if (row64cell13 != null) {
			row64cell13.setCellValue(brf206Row1TO472.getR64_individual_non_resident() == null ? 0
					: brf206Row1TO472.getR64_individual_non_resident().intValue());
		}

		Cell row64cell14 = row64.getCell(15);

		if (row64cell14 != null) {
			row64cell14.setCellValue(brf206Row1TO472.getR64_banking_non_resident() == null ? 0
					: brf206Row1TO472.getR64_banking_non_resident().intValue());
		}

		Cell row64cell15 = row64.getCell(16);

		if (row64cell15 != null) {
			row64cell15.setCellValue(brf206Row1TO472.getR64_trade_non_resident() == null ? 0
					: brf206Row1TO472.getR64_trade_non_resident().intValue());
		}

		// ROW 66

		Row row66 = sheet.getRow(65);

		Cell row66cell1 = row66.getCell(2);

		if (row66cell1 != null) {
			row66cell1.setCellValue(brf206Row1TO472.getR66_country() == null ? "0" : brf206Row1TO472.getR66_country());
		}

		Cell row66cell2 = row66.getCell(3);

		if (row66cell2 != null) {
			row66cell2.setCellValue(brf206Row1TO472.getR66_government_resident() == null ? 0
					: brf206Row1TO472.getR66_government_resident().intValue());
		}

		Cell row66cell3 = row66.getCell(4);

		if (row66cell3 != null) {
			row66cell3.setCellValue(brf206Row1TO472.getR66_gre_resident() == null ? 0
					: brf206Row1TO472.getR66_gre_resident().intValue());
		}

		Cell row66cell4 = row66.getCell(5);

		if (row66cell4 != null) {
			row66cell4.setCellValue(brf206Row1TO472.getR66_private_resident() == null ? 0
					: brf206Row1TO472.getR66_private_resident().intValue());
		}

		Cell row66cell5 = row66.getCell(6);

		if (row66cell5 != null) {
			row66cell5.setCellValue(brf206Row1TO472.getR66_hni_resident() == null ? 0
					: brf206Row1TO472.getR66_hni_resident().intValue());
		}

		Cell row66cell6 = row66.getCell(7);

		if (row66cell6 != null) {
			row66cell6.setCellValue(brf206Row1TO472.getR66_individual_resident() == null ? 0
					: brf206Row1TO472.getR66_individual_resident().intValue());
		}

		Cell row66cell7 = row66.getCell(8);

		if (row66cell7 != null) {
			row66cell7.setCellValue(brf206Row1TO472.getR66_banking_resident() == null ? 0
					: brf206Row1TO472.getR66_banking_resident().intValue());
		}

		Cell row66cell8 = row66.getCell(9);

		if (row66cell8 != null) {
			row66cell8.setCellValue(brf206Row1TO472.getR66_trade_resident() == null ? 0
					: brf206Row1TO472.getR66_trade_resident().intValue());
		}

		Cell row66cell9 = row66.getCell(10);

		if (row66cell9 != null) {
			row66cell9.setCellValue(brf206Row1TO472.getR66_government_non_resident() == null ? 0
					: brf206Row1TO472.getR66_government_non_resident().intValue());
		}

		Cell row66cell10 = row66.getCell(11);

		if (row66cell10 != null) {
			row66cell10.setCellValue(brf206Row1TO472.getR66_gre_non_resident() == null ? 0
					: brf206Row1TO472.getR66_gre_non_resident().intValue());
		}

		Cell row66cell11 = row66.getCell(12);

		if (row66cell11 != null) {
			row66cell11.setCellValue(brf206Row1TO472.getR66_private_non_resident() == null ? 0
					: brf206Row1TO472.getR66_private_non_resident().intValue());
		}

		Cell row66cell12 = row66.getCell(13);

		if (row66cell12 != null) {
			row66cell12.setCellValue(brf206Row1TO472.getR66_hni_non_resident() == null ? 0
					: brf206Row1TO472.getR66_hni_non_resident().intValue());
		}

		Cell row66cell13 = row66.getCell(14);

		if (row66cell13 != null) {
			row66cell13.setCellValue(brf206Row1TO472.getR66_individual_non_resident() == null ? 0
					: brf206Row1TO472.getR66_individual_non_resident().intValue());
		}

		Cell row66cell14 = row66.getCell(15);

		if (row66cell14 != null) {
			row66cell14.setCellValue(brf206Row1TO472.getR66_banking_non_resident() == null ? 0
					: brf206Row1TO472.getR66_banking_non_resident().intValue());
		}

		Cell row66cell15 = row66.getCell(16);

		if (row66cell15 != null) {
			row66cell15.setCellValue(brf206Row1TO472.getR66_trade_non_resident() == null ? 0
					: brf206Row1TO472.getR66_trade_non_resident().intValue());
		}

		// ROW 67

		Row row67 = sheet.getRow(66);

		Cell row67cell1 = row67.getCell(2);

		if (row67cell1 != null) {
			row67cell1.setCellValue(brf206Row1TO472.getR67_country() == null ? "0" : brf206Row1TO472.getR67_country());
		}

		Cell row67cell2 = row67.getCell(3);

		if (row67cell2 != null) {
			row67cell2.setCellValue(brf206Row1TO472.getR67_government_resident() == null ? 0
					: brf206Row1TO472.getR67_government_resident().intValue());
		}

		Cell row67cell3 = row67.getCell(4);

		if (row67cell3 != null) {
			row67cell3.setCellValue(brf206Row1TO472.getR67_gre_resident() == null ? 0
					: brf206Row1TO472.getR67_gre_resident().intValue());
		}

		Cell row67cell4 = row67.getCell(5);

		if (row67cell4 != null) {
			row67cell4.setCellValue(brf206Row1TO472.getR67_private_resident() == null ? 0
					: brf206Row1TO472.getR67_private_resident().intValue());
		}

		Cell row67cell5 = row67.getCell(6);

		if (row67cell5 != null) {
			row67cell5.setCellValue(brf206Row1TO472.getR67_hni_resident() == null ? 0
					: brf206Row1TO472.getR67_hni_resident().intValue());
		}

		Cell row67cell6 = row67.getCell(7);

		if (row67cell6 != null) {
			row67cell6.setCellValue(brf206Row1TO472.getR67_individual_resident() == null ? 0
					: brf206Row1TO472.getR67_individual_resident().intValue());
		}

		Cell row67cell7 = row67.getCell(8);

		if (row67cell7 != null) {
			row67cell7.setCellValue(brf206Row1TO472.getR67_banking_resident() == null ? 0
					: brf206Row1TO472.getR67_banking_resident().intValue());
		}

		Cell row67cell8 = row67.getCell(9);

		if (row67cell8 != null) {
			row67cell8.setCellValue(brf206Row1TO472.getR67_trade_resident() == null ? 0
					: brf206Row1TO472.getR67_trade_resident().intValue());
		}

		Cell row67cell9 = row67.getCell(10);

		if (row67cell9 != null) {
			row67cell9.setCellValue(brf206Row1TO472.getR67_government_non_resident() == null ? 0
					: brf206Row1TO472.getR67_government_non_resident().intValue());
		}

		Cell row67cell10 = row67.getCell(11);

		if (row67cell10 != null) {
			row67cell10.setCellValue(brf206Row1TO472.getR67_gre_non_resident() == null ? 0
					: brf206Row1TO472.getR67_gre_non_resident().intValue());
		}

		Cell row67cell11 = row67.getCell(12);

		if (row67cell11 != null) {
			row67cell11.setCellValue(brf206Row1TO472.getR67_private_non_resident() == null ? 0
					: brf206Row1TO472.getR67_private_non_resident().intValue());
		}

		Cell row67cell12 = row67.getCell(13);

		if (row67cell12 != null) {
			row67cell12.setCellValue(brf206Row1TO472.getR67_hni_non_resident() == null ? 0
					: brf206Row1TO472.getR67_hni_non_resident().intValue());
		}

		Cell row67cell13 = row67.getCell(14);

		if (row67cell13 != null) {
			row67cell13.setCellValue(brf206Row1TO472.getR67_individual_non_resident() == null ? 0
					: brf206Row1TO472.getR67_individual_non_resident().intValue());
		}

		Cell row67cell14 = row67.getCell(15);

		if (row67cell14 != null) {
			row67cell14.setCellValue(brf206Row1TO472.getR67_banking_non_resident() == null ? 0
					: brf206Row1TO472.getR67_banking_non_resident().intValue());
		}

		Cell row67cell15 = row67.getCell(16);

		if (row67cell15 != null) {
			row67cell15.setCellValue(brf206Row1TO472.getR67_trade_non_resident() == null ? 0
					: brf206Row1TO472.getR67_trade_non_resident().intValue());
		}

		// ROW 68

		Row row68 = sheet.getRow(67);

		Cell row68cell1 = row68.getCell(2);

		if (row68cell1 != null) {
			row68cell1.setCellValue(brf206Row1TO472.getR68_country() == null ? "0" : brf206Row1TO472.getR68_country());
		}

		Cell row68cell2 = row68.getCell(3);

		if (row68cell2 != null) {
			row68cell2.setCellValue(brf206Row1TO472.getR68_government_resident() == null ? 0
					: brf206Row1TO472.getR68_government_resident().intValue());
		}

		Cell row68cell3 = row68.getCell(4);

		if (row68cell3 != null) {
			row68cell3.setCellValue(brf206Row1TO472.getR68_gre_resident() == null ? 0
					: brf206Row1TO472.getR68_gre_resident().intValue());
		}

		Cell row68cell4 = row68.getCell(5);

		if (row68cell4 != null) {
			row68cell4.setCellValue(brf206Row1TO472.getR68_private_resident() == null ? 0
					: brf206Row1TO472.getR68_private_resident().intValue());
		}

		Cell row68cell5 = row68.getCell(6);

		if (row68cell5 != null) {
			row68cell5.setCellValue(brf206Row1TO472.getR68_hni_resident() == null ? 0
					: brf206Row1TO472.getR68_hni_resident().intValue());
		}

		Cell row68cell6 = row68.getCell(7);

		if (row68cell6 != null) {
			row68cell6.setCellValue(brf206Row1TO472.getR68_individual_resident() == null ? 0
					: brf206Row1TO472.getR68_individual_resident().intValue());
		}

		Cell row68cell7 = row68.getCell(8);

		if (row68cell7 != null) {
			row68cell7.setCellValue(brf206Row1TO472.getR68_banking_resident() == null ? 0
					: brf206Row1TO472.getR68_banking_resident().intValue());
		}

		Cell row68cell8 = row68.getCell(9);

		if (row68cell8 != null) {
			row68cell8.setCellValue(brf206Row1TO472.getR68_trade_resident() == null ? 0
					: brf206Row1TO472.getR68_trade_resident().intValue());
		}

		Cell row68cell9 = row68.getCell(10);

		if (row68cell9 != null) {
			row68cell9.setCellValue(brf206Row1TO472.getR68_government_non_resident() == null ? 0
					: brf206Row1TO472.getR68_government_non_resident().intValue());
		}

		Cell row68cell10 = row68.getCell(11);

		if (row68cell10 != null) {
			row68cell10.setCellValue(brf206Row1TO472.getR68_gre_non_resident() == null ? 0
					: brf206Row1TO472.getR68_gre_non_resident().intValue());
		}

		Cell row68cell11 = row68.getCell(12);

		if (row68cell11 != null) {
			row68cell11.setCellValue(brf206Row1TO472.getR68_private_non_resident() == null ? 0
					: brf206Row1TO472.getR68_private_non_resident().intValue());
		}

		Cell row68cell12 = row68.getCell(13);

		if (row68cell12 != null) {
			row68cell12.setCellValue(brf206Row1TO472.getR68_hni_non_resident() == null ? 0
					: brf206Row1TO472.getR68_hni_non_resident().intValue());
		}

		Cell row68cell13 = row68.getCell(14);

		if (row68cell13 != null) {
			row68cell13.setCellValue(brf206Row1TO472.getR68_individual_non_resident() == null ? 0
					: brf206Row1TO472.getR68_individual_non_resident().intValue());
		}

		Cell row68cell14 = row68.getCell(15);

		if (row68cell14 != null) {
			row68cell14.setCellValue(brf206Row1TO472.getR68_banking_non_resident() == null ? 0
					: brf206Row1TO472.getR68_banking_non_resident().intValue());
		}

		Cell row68cell15 = row68.getCell(16);

		if (row68cell15 != null) {
			row68cell15.setCellValue(brf206Row1TO472.getR68_trade_non_resident() == null ? 0
					: brf206Row1TO472.getR68_trade_non_resident().intValue());
		}

		// ROW 69

		Row row69 = sheet.getRow(68);

		Cell row69cell1 = row69.getCell(2);

		if (row69cell1 != null) {
			row69cell1.setCellValue(brf206Row1TO472.getR69_country() == null ? "0" : brf206Row1TO472.getR69_country());
		}

		Cell row69cell2 = row69.getCell(3);

		if (row69cell2 != null) {
			row69cell2.setCellValue(brf206Row1TO472.getR69_government_resident() == null ? 0
					: brf206Row1TO472.getR69_government_resident().intValue());
		}

		Cell row69cell3 = row69.getCell(4);

		if (row69cell3 != null) {
			row69cell3.setCellValue(brf206Row1TO472.getR69_gre_resident() == null ? 0
					: brf206Row1TO472.getR69_gre_resident().intValue());
		}

		Cell row69cell4 = row69.getCell(5);

		if (row69cell4 != null) {
			row69cell4.setCellValue(brf206Row1TO472.getR69_private_resident() == null ? 0
					: brf206Row1TO472.getR69_private_resident().intValue());
		}

		Cell row69cell5 = row69.getCell(6);

		if (row69cell5 != null) {
			row69cell5.setCellValue(brf206Row1TO472.getR69_hni_resident() == null ? 0
					: brf206Row1TO472.getR69_hni_resident().intValue());
		}

		Cell row69cell6 = row69.getCell(7);

		if (row69cell6 != null) {
			row69cell6.setCellValue(brf206Row1TO472.getR69_individual_resident() == null ? 0
					: brf206Row1TO472.getR69_individual_resident().intValue());
		}

		Cell row69cell7 = row69.getCell(8);

		if (row69cell7 != null) {
			row69cell7.setCellValue(brf206Row1TO472.getR69_banking_resident() == null ? 0
					: brf206Row1TO472.getR69_banking_resident().intValue());
		}

		Cell row69cell8 = row69.getCell(9);

		if (row69cell8 != null) {
			row69cell8.setCellValue(brf206Row1TO472.getR69_trade_resident() == null ? 0
					: brf206Row1TO472.getR69_trade_resident().intValue());
		}

		Cell row69cell9 = row69.getCell(10);

		if (row69cell9 != null) {
			row69cell9.setCellValue(brf206Row1TO472.getR69_government_non_resident() == null ? 0
					: brf206Row1TO472.getR69_government_non_resident().intValue());
		}

		Cell row69cell10 = row69.getCell(11);

		if (row69cell10 != null) {
			row69cell10.setCellValue(brf206Row1TO472.getR69_gre_non_resident() == null ? 0
					: brf206Row1TO472.getR69_gre_non_resident().intValue());
		}

		Cell row69cell11 = row69.getCell(12);

		if (row69cell11 != null) {
			row69cell11.setCellValue(brf206Row1TO472.getR69_private_non_resident() == null ? 0
					: brf206Row1TO472.getR69_private_non_resident().intValue());
		}

		Cell row69cell12 = row69.getCell(13);

		if (row69cell12 != null) {
			row69cell12.setCellValue(brf206Row1TO472.getR69_hni_non_resident() == null ? 0
					: brf206Row1TO472.getR69_hni_non_resident().intValue());
		}

		Cell row69cell13 = row69.getCell(14);

		if (row69cell13 != null) {
			row69cell13.setCellValue(brf206Row1TO472.getR69_individual_non_resident() == null ? 0
					: brf206Row1TO472.getR69_individual_non_resident().intValue());
		}

		Cell row69cell14 = row69.getCell(15);

		if (row69cell14 != null) {
			row69cell14.setCellValue(brf206Row1TO472.getR69_banking_non_resident() == null ? 0
					: brf206Row1TO472.getR69_banking_non_resident().intValue());
		}

		Cell row69cell15 = row69.getCell(16);

		if (row69cell15 != null) {
			row69cell15.setCellValue(brf206Row1TO472.getR69_trade_non_resident() == null ? 0
					: brf206Row1TO472.getR69_trade_non_resident().intValue());
		}

		// ROW 70

		Row row70 = sheet.getRow(69);

		Cell row70cell1 = row70.getCell(2);

		if (row70cell1 != null) {
			row70cell1.setCellValue(brf206Row1TO472.getR70_country() == null ? "0" : brf206Row1TO472.getR70_country());
		}

		Cell row70cell2 = row70.getCell(3);

		if (row70cell2 != null) {
			row70cell2.setCellValue(brf206Row1TO472.getR70_government_resident() == null ? 0
					: brf206Row1TO472.getR70_government_resident().intValue());
		}

		Cell row70cell3 = row70.getCell(4);

		if (row70cell3 != null) {
			row70cell3.setCellValue(brf206Row1TO472.getR70_gre_resident() == null ? 0
					: brf206Row1TO472.getR70_gre_resident().intValue());
		}

		Cell row70cell4 = row70.getCell(5);

		if (row70cell4 != null) {
			row70cell4.setCellValue(brf206Row1TO472.getR70_private_resident() == null ? 0
					: brf206Row1TO472.getR70_private_resident().intValue());
		}

		Cell row70cell5 = row70.getCell(6);

		if (row70cell5 != null) {
			row70cell5.setCellValue(brf206Row1TO472.getR70_hni_resident() == null ? 0
					: brf206Row1TO472.getR70_hni_resident().intValue());
		}

		Cell row70cell6 = row70.getCell(7);

		if (row70cell6 != null) {
			row70cell6.setCellValue(brf206Row1TO472.getR70_individual_resident() == null ? 0
					: brf206Row1TO472.getR70_individual_resident().intValue());
		}

		Cell row70cell7 = row70.getCell(8);

		if (row70cell7 != null) {
			row70cell7.setCellValue(brf206Row1TO472.getR70_banking_resident() == null ? 0
					: brf206Row1TO472.getR70_banking_resident().intValue());
		}

		Cell row70cell8 = row70.getCell(9);

		if (row70cell8 != null) {
			row70cell8.setCellValue(brf206Row1TO472.getR70_trade_resident() == null ? 0
					: brf206Row1TO472.getR70_trade_resident().intValue());
		}

		Cell row70cell9 = row70.getCell(10);

		if (row70cell9 != null) {
			row70cell9.setCellValue(brf206Row1TO472.getR70_government_non_resident() == null ? 0
					: brf206Row1TO472.getR70_government_non_resident().intValue());
		}

		Cell row70cell10 = row70.getCell(11);

		if (row70cell10 != null) {
			row70cell10.setCellValue(brf206Row1TO472.getR70_gre_non_resident() == null ? 0
					: brf206Row1TO472.getR70_gre_non_resident().intValue());
		}

		Cell row70cell11 = row70.getCell(12);

		if (row70cell11 != null) {
			row70cell11.setCellValue(brf206Row1TO472.getR70_private_non_resident() == null ? 0
					: brf206Row1TO472.getR70_private_non_resident().intValue());
		}

		Cell row70cell12 = row70.getCell(13);

		if (row70cell12 != null) {
			row70cell12.setCellValue(brf206Row1TO472.getR70_hni_non_resident() == null ? 0
					: brf206Row1TO472.getR70_hni_non_resident().intValue());
		}

		Cell row70cell13 = row70.getCell(14);

		if (row70cell13 != null) {
			row70cell13.setCellValue(brf206Row1TO472.getR70_individual_non_resident() == null ? 0
					: brf206Row1TO472.getR70_individual_non_resident().intValue());
		}

		Cell row70cell14 = row70.getCell(15);

		if (row70cell14 != null) {
			row70cell14.setCellValue(brf206Row1TO472.getR70_banking_non_resident() == null ? 0
					: brf206Row1TO472.getR70_banking_non_resident().intValue());
		}

		Cell row70cell15 = row70.getCell(16);

		if (row70cell15 != null) {
			row70cell15.setCellValue(brf206Row1TO472.getR70_trade_non_resident() == null ? 0
					: brf206Row1TO472.getR70_trade_non_resident().intValue());
		}

		// ROW 72

		Row row72 = sheet.getRow(71);

		Cell row72cell1 = row72.getCell(2);

		if (row72cell1 != null) {
			row72cell1.setCellValue(brf206Row1TO472.getR72_country() == null ? "0" : brf206Row1TO472.getR72_country());
		}

		Cell row72cell2 = row72.getCell(3);

		if (row72cell2 != null) {
			row72cell2.setCellValue(brf206Row1TO472.getR72_government_resident() == null ? 0
					: brf206Row1TO472.getR72_government_resident().intValue());
		}

		Cell row72cell3 = row72.getCell(4);

		if (row72cell3 != null) {
			row72cell3.setCellValue(brf206Row1TO472.getR72_gre_resident() == null ? 0
					: brf206Row1TO472.getR72_gre_resident().intValue());
		}

		Cell row72cell4 = row72.getCell(5);

		if (row72cell4 != null) {
			row72cell4.setCellValue(brf206Row1TO472.getR72_private_resident() == null ? 0
					: brf206Row1TO472.getR72_private_resident().intValue());
		}

		Cell row72cell5 = row72.getCell(6);

		if (row72cell5 != null) {
			row72cell5.setCellValue(brf206Row1TO472.getR72_hni_resident() == null ? 0
					: brf206Row1TO472.getR72_hni_resident().intValue());
		}

		Cell row72cell6 = row72.getCell(7);

		if (row72cell6 != null) {
			row72cell6.setCellValue(brf206Row1TO472.getR72_individual_resident() == null ? 0
					: brf206Row1TO472.getR72_individual_resident().intValue());
		}

		Cell row72cell7 = row72.getCell(8);

		if (row72cell7 != null) {
			row72cell7.setCellValue(brf206Row1TO472.getR72_banking_resident() == null ? 0
					: brf206Row1TO472.getR72_banking_resident().intValue());
		}

		Cell row72cell8 = row72.getCell(9);

		if (row72cell8 != null) {
			row72cell8.setCellValue(brf206Row1TO472.getR72_trade_resident() == null ? 0
					: brf206Row1TO472.getR72_trade_resident().intValue());
		}

		Cell row72cell9 = row72.getCell(10);

		if (row72cell9 != null) {
			row72cell9.setCellValue(brf206Row1TO472.getR72_government_non_resident() == null ? 0
					: brf206Row1TO472.getR72_government_non_resident().intValue());
		}

		Cell row72cell10 = row72.getCell(11);

		if (row72cell10 != null) {
			row72cell10.setCellValue(brf206Row1TO472.getR72_gre_non_resident() == null ? 0
					: brf206Row1TO472.getR72_gre_non_resident().intValue());
		}

		Cell row72cell11 = row72.getCell(12);

		if (row72cell11 != null) {
			row72cell11.setCellValue(brf206Row1TO472.getR72_private_non_resident() == null ? 0
					: brf206Row1TO472.getR72_private_non_resident().intValue());
		}

		Cell row72cell12 = row72.getCell(13);

		if (row72cell12 != null) {
			row72cell12.setCellValue(brf206Row1TO472.getR72_hni_non_resident() == null ? 0
					: brf206Row1TO472.getR72_hni_non_resident().intValue());
		}

		Cell row72cell13 = row72.getCell(14);

		if (row72cell13 != null) {
			row72cell13.setCellValue(brf206Row1TO472.getR72_individual_non_resident() == null ? 0
					: brf206Row1TO472.getR72_individual_non_resident().intValue());
		}

		Cell row72cell14 = row72.getCell(15);

		if (row72cell14 != null) {
			row72cell14.setCellValue(brf206Row1TO472.getR72_banking_non_resident() == null ? 0
					: brf206Row1TO472.getR72_banking_non_resident().intValue());
		}

		Cell row72cell15 = row72.getCell(16);

		if (row72cell15 != null) {
			row72cell15.setCellValue(brf206Row1TO472.getR72_trade_non_resident() == null ? 0
					: brf206Row1TO472.getR72_trade_non_resident().intValue());
		}

		// ROW 73

		Row row73 = sheet.getRow(72);

		Cell row73cell1 = row73.getCell(2);

		if (row73cell1 != null) {
			row73cell1.setCellValue(brf206Row1TO472.getR73_country() == null ? "0" : brf206Row1TO472.getR73_country());
		}

		Cell row73cell2 = row73.getCell(3);

		if (row73cell2 != null) {
			row73cell2.setCellValue(brf206Row1TO472.getR73_government_resident() == null ? 0
					: brf206Row1TO472.getR73_government_resident().intValue());
		}

		Cell row73cell3 = row73.getCell(4);

		if (row73cell3 != null) {
			row73cell3.setCellValue(brf206Row1TO472.getR73_gre_resident() == null ? 0
					: brf206Row1TO472.getR73_gre_resident().intValue());
		}

		Cell row73cell4 = row73.getCell(5);

		if (row73cell4 != null) {
			row73cell4.setCellValue(brf206Row1TO472.getR73_private_resident() == null ? 0
					: brf206Row1TO472.getR73_private_resident().intValue());
		}

		Cell row73cell5 = row73.getCell(6);

		if (row73cell5 != null) {
			row73cell5.setCellValue(brf206Row1TO472.getR73_hni_resident() == null ? 0
					: brf206Row1TO472.getR73_hni_resident().intValue());
		}

		Cell row73cell6 = row73.getCell(7);

		if (row73cell6 != null) {
			row73cell6.setCellValue(brf206Row1TO472.getR73_individual_resident() == null ? 0
					: brf206Row1TO472.getR73_individual_resident().intValue());
		}

		Cell row73cell7 = row73.getCell(8);

		if (row73cell7 != null) {
			row73cell7.setCellValue(brf206Row1TO472.getR73_banking_resident() == null ? 0
					: brf206Row1TO472.getR73_banking_resident().intValue());
		}

		Cell row73cell8 = row73.getCell(9);

		if (row73cell8 != null) {
			row73cell8.setCellValue(brf206Row1TO472.getR73_trade_resident() == null ? 0
					: brf206Row1TO472.getR73_trade_resident().intValue());
		}

		Cell row73cell9 = row73.getCell(10);

		if (row73cell9 != null) {
			row73cell9.setCellValue(brf206Row1TO472.getR73_government_non_resident() == null ? 0
					: brf206Row1TO472.getR73_government_non_resident().intValue());
		}

		Cell row73cell10 = row73.getCell(11);

		if (row73cell10 != null) {
			row73cell10.setCellValue(brf206Row1TO472.getR73_gre_non_resident() == null ? 0
					: brf206Row1TO472.getR73_gre_non_resident().intValue());
		}

		Cell row73cell11 = row73.getCell(12);

		if (row73cell11 != null) {
			row73cell11.setCellValue(brf206Row1TO472.getR73_private_non_resident() == null ? 0
					: brf206Row1TO472.getR73_private_non_resident().intValue());
		}

		Cell row73cell12 = row73.getCell(13);

		if (row73cell12 != null) {
			row73cell12.setCellValue(brf206Row1TO472.getR73_hni_non_resident() == null ? 0
					: brf206Row1TO472.getR73_hni_non_resident().intValue());
		}

		Cell row73cell13 = row73.getCell(14);

		if (row73cell13 != null) {
			row73cell13.setCellValue(brf206Row1TO472.getR73_individual_non_resident() == null ? 0
					: brf206Row1TO472.getR73_individual_non_resident().intValue());
		}

		Cell row73cell14 = row73.getCell(15);

		if (row73cell14 != null) {
			row73cell14.setCellValue(brf206Row1TO472.getR73_banking_non_resident() == null ? 0
					: brf206Row1TO472.getR73_banking_non_resident().intValue());
		}

		Cell row73cell15 = row73.getCell(16);

		if (row73cell15 != null) {
			row73cell15.setCellValue(brf206Row1TO472.getR73_trade_non_resident() == null ? 0
					: brf206Row1TO472.getR73_trade_non_resident().intValue());
		}

		// ROW 74

		Row row74 = sheet.getRow(73);

		Cell row74cell1 = row74.getCell(2);

		if (row74cell1 != null) {
			row74cell1.setCellValue(brf206Row1TO472.getR74_country() == null ? "0" : brf206Row1TO472.getR74_country());
		}

		Cell row74cell2 = row74.getCell(3);

		if (row74cell2 != null) {
			row74cell2.setCellValue(brf206Row1TO472.getR74_government_resident() == null ? 0
					: brf206Row1TO472.getR74_government_resident().intValue());
		}

		Cell row74cell3 = row74.getCell(4);

		if (row74cell3 != null) {
			row74cell3.setCellValue(brf206Row1TO472.getR74_gre_resident() == null ? 0
					: brf206Row1TO472.getR74_gre_resident().intValue());
		}

		Cell row74cell4 = row74.getCell(5);

		if (row74cell4 != null) {
			row74cell4.setCellValue(brf206Row1TO472.getR74_private_resident() == null ? 0
					: brf206Row1TO472.getR74_private_resident().intValue());
		}

		Cell row74cell5 = row74.getCell(6);

		if (row74cell5 != null) {
			row74cell5.setCellValue(brf206Row1TO472.getR74_hni_resident() == null ? 0
					: brf206Row1TO472.getR74_hni_resident().intValue());
		}

		Cell row74cell6 = row74.getCell(7);

		if (row74cell6 != null) {
			row74cell6.setCellValue(brf206Row1TO472.getR74_individual_resident() == null ? 0
					: brf206Row1TO472.getR74_individual_resident().intValue());
		}

		Cell row74cell7 = row74.getCell(8);

		if (row74cell7 != null) {
			row74cell7.setCellValue(brf206Row1TO472.getR74_banking_resident() == null ? 0
					: brf206Row1TO472.getR74_banking_resident().intValue());
		}

		Cell row74cell8 = row74.getCell(9);

		if (row74cell8 != null) {
			row74cell8.setCellValue(brf206Row1TO472.getR74_trade_resident() == null ? 0
					: brf206Row1TO472.getR74_trade_resident().intValue());
		}

		Cell row74cell9 = row74.getCell(10);

		if (row74cell9 != null) {
			row74cell9.setCellValue(brf206Row1TO472.getR74_government_non_resident() == null ? 0
					: brf206Row1TO472.getR74_government_non_resident().intValue());
		}

		Cell row74cell10 = row74.getCell(11);

		if (row74cell10 != null) {
			row74cell10.setCellValue(brf206Row1TO472.getR74_gre_non_resident() == null ? 0
					: brf206Row1TO472.getR74_gre_non_resident().intValue());
		}

		Cell row74cell11 = row74.getCell(12);

		if (row74cell11 != null) {
			row74cell11.setCellValue(brf206Row1TO472.getR74_private_non_resident() == null ? 0
					: brf206Row1TO472.getR74_private_non_resident().intValue());
		}

		Cell row74cell12 = row74.getCell(13);

		if (row74cell12 != null) {
			row74cell12.setCellValue(brf206Row1TO472.getR74_hni_non_resident() == null ? 0
					: brf206Row1TO472.getR74_hni_non_resident().intValue());
		}

		Cell row74cell13 = row74.getCell(14);

		if (row74cell13 != null) {
			row74cell13.setCellValue(brf206Row1TO472.getR74_individual_non_resident() == null ? 0
					: brf206Row1TO472.getR74_individual_non_resident().intValue());
		}

		Cell row74cell14 = row74.getCell(15);

		if (row74cell14 != null) {
			row74cell14.setCellValue(brf206Row1TO472.getR74_banking_non_resident() == null ? 0
					: brf206Row1TO472.getR74_banking_non_resident().intValue());
		}

		Cell row74cell15 = row74.getCell(16);

		if (row74cell15 != null) {
			row74cell15.setCellValue(brf206Row1TO472.getR74_trade_non_resident() == null ? 0
					: brf206Row1TO472.getR74_trade_non_resident().intValue());
		}

		// ROW 75

		Row row75 = sheet.getRow(74);

		Cell row75cell1 = row75.getCell(2);

		if (row75cell1 != null) {
			row75cell1.setCellValue(brf206Row1TO472.getR75_country() == null ? "0" : brf206Row1TO472.getR75_country());
		}

		Cell row75cell2 = row75.getCell(3);

		if (row75cell2 != null) {
			row75cell2.setCellValue(brf206Row1TO472.getR75_government_resident() == null ? 0
					: brf206Row1TO472.getR75_government_resident().intValue());
		}

		Cell row75cell3 = row75.getCell(4);

		if (row75cell3 != null) {
			row75cell3.setCellValue(brf206Row1TO472.getR75_gre_resident() == null ? 0
					: brf206Row1TO472.getR75_gre_resident().intValue());
		}

		Cell row75cell4 = row75.getCell(5);

		if (row75cell4 != null) {
			row75cell4.setCellValue(brf206Row1TO472.getR75_private_resident() == null ? 0
					: brf206Row1TO472.getR75_private_resident().intValue());
		}

		Cell row75cell5 = row75.getCell(6);

		if (row75cell5 != null) {
			row75cell5.setCellValue(brf206Row1TO472.getR75_hni_resident() == null ? 0
					: brf206Row1TO472.getR75_hni_resident().intValue());
		}

		Cell row75cell6 = row75.getCell(7);

		if (row75cell6 != null) {
			row75cell6.setCellValue(brf206Row1TO472.getR75_individual_resident() == null ? 0
					: brf206Row1TO472.getR75_individual_resident().intValue());
		}

		Cell row75cell7 = row75.getCell(8);

		if (row75cell7 != null) {
			row75cell7.setCellValue(brf206Row1TO472.getR75_banking_resident() == null ? 0
					: brf206Row1TO472.getR75_banking_resident().intValue());
		}

		Cell row75cell8 = row75.getCell(9);

		if (row75cell8 != null) {
			row75cell8.setCellValue(brf206Row1TO472.getR75_trade_resident() == null ? 0
					: brf206Row1TO472.getR75_trade_resident().intValue());
		}

		Cell row75cell9 = row75.getCell(10);

		if (row75cell9 != null) {
			row75cell9.setCellValue(brf206Row1TO472.getR75_government_non_resident() == null ? 0
					: brf206Row1TO472.getR75_government_non_resident().intValue());
		}

		Cell row75cell10 = row75.getCell(11);

		if (row75cell10 != null) {
			row75cell10.setCellValue(brf206Row1TO472.getR75_gre_non_resident() == null ? 0
					: brf206Row1TO472.getR75_gre_non_resident().intValue());
		}

		Cell row75cell11 = row75.getCell(12);

		if (row75cell11 != null) {
			row75cell11.setCellValue(brf206Row1TO472.getR75_private_non_resident() == null ? 0
					: brf206Row1TO472.getR75_private_non_resident().intValue());
		}

		Cell row75cell12 = row75.getCell(13);

		if (row75cell12 != null) {
			row75cell12.setCellValue(brf206Row1TO472.getR75_hni_non_resident() == null ? 0
					: brf206Row1TO472.getR75_hni_non_resident().intValue());
		}

		Cell row75cell13 = row75.getCell(14);

		if (row75cell13 != null) {
			row75cell13.setCellValue(brf206Row1TO472.getR75_individual_non_resident() == null ? 0
					: brf206Row1TO472.getR75_individual_non_resident().intValue());
		}

		Cell row75cell14 = row75.getCell(15);

		if (row75cell14 != null) {
			row75cell14.setCellValue(brf206Row1TO472.getR75_banking_non_resident() == null ? 0
					: brf206Row1TO472.getR75_banking_non_resident().intValue());
		}

		Cell row75cell15 = row75.getCell(16);

		if (row75cell15 != null) {
			row75cell15.setCellValue(brf206Row1TO472.getR75_trade_non_resident() == null ? 0
					: brf206Row1TO472.getR75_trade_non_resident().intValue());
		}

		// ROW 76

		Row row76 = sheet.getRow(75);

		Cell row76cell1 = row76.getCell(2);

		if (row76cell1 != null) {
			row76cell1.setCellValue(brf206Row1TO472.getR76_country() == null ? "0" : brf206Row1TO472.getR76_country());
		}

		Cell row76cell2 = row76.getCell(3);

		if (row76cell2 != null) {
			row76cell2.setCellValue(brf206Row1TO472.getR76_government_resident() == null ? 0
					: brf206Row1TO472.getR76_government_resident().intValue());
		}

		Cell row76cell3 = row76.getCell(4);

		if (row76cell3 != null) {
			row76cell3.setCellValue(brf206Row1TO472.getR76_gre_resident() == null ? 0
					: brf206Row1TO472.getR76_gre_resident().intValue());
		}

		Cell row76cell4 = row76.getCell(5);

		if (row76cell4 != null) {
			row76cell4.setCellValue(brf206Row1TO472.getR76_private_resident() == null ? 0
					: brf206Row1TO472.getR76_private_resident().intValue());
		}

		Cell row76cell5 = row76.getCell(6);

		if (row76cell5 != null) {
			row76cell5.setCellValue(brf206Row1TO472.getR76_hni_resident() == null ? 0
					: brf206Row1TO472.getR76_hni_resident().intValue());
		}

		Cell row76cell6 = row76.getCell(7);

		if (row76cell6 != null) {
			row76cell6.setCellValue(brf206Row1TO472.getR76_individual_resident() == null ? 0
					: brf206Row1TO472.getR76_individual_resident().intValue());
		}

		Cell row76cell7 = row76.getCell(8);

		if (row76cell7 != null) {
			row76cell7.setCellValue(brf206Row1TO472.getR76_banking_resident() == null ? 0
					: brf206Row1TO472.getR76_banking_resident().intValue());
		}

		Cell row76cell8 = row76.getCell(9);

		if (row76cell8 != null) {
			row76cell8.setCellValue(brf206Row1TO472.getR76_trade_resident() == null ? 0
					: brf206Row1TO472.getR76_trade_resident().intValue());
		}

		Cell row76cell9 = row76.getCell(10);

		if (row76cell9 != null) {
			row76cell9.setCellValue(brf206Row1TO472.getR76_government_non_resident() == null ? 0
					: brf206Row1TO472.getR76_government_non_resident().intValue());
		}

		Cell row76cell10 = row76.getCell(11);

		if (row76cell10 != null) {
			row76cell10.setCellValue(brf206Row1TO472.getR76_gre_non_resident() == null ? 0
					: brf206Row1TO472.getR76_gre_non_resident().intValue());
		}

		Cell row76cell11 = row76.getCell(12);

		if (row76cell11 != null) {
			row76cell11.setCellValue(brf206Row1TO472.getR76_private_non_resident() == null ? 0
					: brf206Row1TO472.getR76_private_non_resident().intValue());
		}

		Cell row76cell12 = row76.getCell(13);

		if (row76cell12 != null) {
			row76cell12.setCellValue(brf206Row1TO472.getR76_hni_non_resident() == null ? 0
					: brf206Row1TO472.getR76_hni_non_resident().intValue());
		}

		Cell row76cell13 = row76.getCell(14);

		if (row76cell13 != null) {
			row76cell13.setCellValue(brf206Row1TO472.getR76_individual_non_resident() == null ? 0
					: brf206Row1TO472.getR76_individual_non_resident().intValue());
		}

		Cell row76cell14 = row76.getCell(15);

		if (row76cell14 != null) {
			row76cell14.setCellValue(brf206Row1TO472.getR76_banking_non_resident() == null ? 0
					: brf206Row1TO472.getR76_banking_non_resident().intValue());
		}

		Cell row76cell15 = row76.getCell(16);

		if (row76cell15 != null) {
			row76cell15.setCellValue(brf206Row1TO472.getR76_trade_non_resident() == null ? 0
					: brf206Row1TO472.getR76_trade_non_resident().intValue());
		}

		// ROW 77

		Row row77 = sheet.getRow(76);

		Cell row77cell1 = row77.getCell(2);

		if (row77cell1 != null) {
			row77cell1.setCellValue(brf206Row1TO472.getR77_country() == null ? "0" : brf206Row1TO472.getR77_country());
		}

		Cell row77cell2 = row77.getCell(3);

		if (row77cell2 != null) {
			row77cell2.setCellValue(brf206Row1TO472.getR77_government_resident() == null ? 0
					: brf206Row1TO472.getR77_government_resident().intValue());
		}

		Cell row77cell3 = row77.getCell(4);

		if (row77cell3 != null) {
			row77cell3.setCellValue(brf206Row1TO472.getR77_gre_resident() == null ? 0
					: brf206Row1TO472.getR77_gre_resident().intValue());
		}

		Cell row77cell4 = row77.getCell(5);

		if (row77cell4 != null) {
			row77cell4.setCellValue(brf206Row1TO472.getR77_private_resident() == null ? 0
					: brf206Row1TO472.getR77_private_resident().intValue());
		}

		Cell row77cell5 = row77.getCell(6);

		if (row77cell5 != null) {
			row77cell5.setCellValue(brf206Row1TO472.getR77_hni_resident() == null ? 0
					: brf206Row1TO472.getR77_hni_resident().intValue());
		}

		Cell row77cell6 = row77.getCell(7);

		if (row77cell6 != null) {
			row77cell6.setCellValue(brf206Row1TO472.getR77_individual_resident() == null ? 0
					: brf206Row1TO472.getR77_individual_resident().intValue());
		}

		Cell row77cell7 = row77.getCell(8);

		if (row77cell7 != null) {
			row77cell7.setCellValue(brf206Row1TO472.getR77_banking_resident() == null ? 0
					: brf206Row1TO472.getR77_banking_resident().intValue());
		}

		Cell row77cell8 = row77.getCell(9);

		if (row77cell8 != null) {
			row77cell8.setCellValue(brf206Row1TO472.getR77_trade_resident() == null ? 0
					: brf206Row1TO472.getR77_trade_resident().intValue());
		}

		Cell row77cell9 = row77.getCell(10);

		if (row77cell9 != null) {
			row77cell9.setCellValue(brf206Row1TO472.getR77_government_non_resident() == null ? 0
					: brf206Row1TO472.getR77_government_non_resident().intValue());
		}

		Cell row77cell10 = row77.getCell(11);

		if (row77cell10 != null) {
			row77cell10.setCellValue(brf206Row1TO472.getR77_gre_non_resident() == null ? 0
					: brf206Row1TO472.getR77_gre_non_resident().intValue());
		}

		Cell row77cell11 = row77.getCell(12);

		if (row77cell11 != null) {
			row77cell11.setCellValue(brf206Row1TO472.getR77_private_non_resident() == null ? 0
					: brf206Row1TO472.getR77_private_non_resident().intValue());
		}

		Cell row77cell12 = row77.getCell(13);

		if (row77cell12 != null) {
			row77cell12.setCellValue(brf206Row1TO472.getR77_hni_non_resident() == null ? 0
					: brf206Row1TO472.getR77_hni_non_resident().intValue());
		}

		Cell row77cell13 = row77.getCell(14);

		if (row77cell13 != null) {
			row77cell13.setCellValue(brf206Row1TO472.getR77_individual_non_resident() == null ? 0
					: brf206Row1TO472.getR77_individual_non_resident().intValue());
		}

		Cell row77cell14 = row77.getCell(15);

		if (row77cell14 != null) {
			row77cell14.setCellValue(brf206Row1TO472.getR77_banking_non_resident() == null ? 0
					: brf206Row1TO472.getR77_banking_non_resident().intValue());
		}

		Cell row77cell15 = row77.getCell(16);

		if (row77cell15 != null) {
			row77cell15.setCellValue(brf206Row1TO472.getR77_trade_non_resident() == null ? 0
					: brf206Row1TO472.getR77_trade_non_resident().intValue());
		}

		// ROW 78

		Row row78 = sheet.getRow(77);

		Cell row78cell1 = row78.getCell(2);

		if (row78cell1 != null) {
			row78cell1.setCellValue(brf206Row1TO472.getR78_country() == null ? "0" : brf206Row1TO472.getR78_country());
		}

		Cell row78cell2 = row78.getCell(3);

		if (row78cell2 != null) {
			row78cell2.setCellValue(brf206Row1TO472.getR78_government_resident() == null ? 0
					: brf206Row1TO472.getR78_government_resident().intValue());
		}

		Cell row78cell3 = row78.getCell(4);

		if (row78cell3 != null) {
			row78cell3.setCellValue(brf206Row1TO472.getR78_gre_resident() == null ? 0
					: brf206Row1TO472.getR78_gre_resident().intValue());
		}

		Cell row78cell4 = row78.getCell(5);

		if (row78cell4 != null) {
			row78cell4.setCellValue(brf206Row1TO472.getR78_private_resident() == null ? 0
					: brf206Row1TO472.getR78_private_resident().intValue());
		}

		Cell row78cell5 = row78.getCell(6);

		if (row78cell5 != null) {
			row78cell5.setCellValue(brf206Row1TO472.getR78_hni_resident() == null ? 0
					: brf206Row1TO472.getR78_hni_resident().intValue());
		}

		Cell row78cell6 = row78.getCell(7);

		if (row78cell6 != null) {
			row78cell6.setCellValue(brf206Row1TO472.getR78_individual_resident() == null ? 0
					: brf206Row1TO472.getR78_individual_resident().intValue());
		}

		Cell row78cell7 = row78.getCell(8);

		if (row78cell7 != null) {
			row78cell7.setCellValue(brf206Row1TO472.getR78_banking_resident() == null ? 0
					: brf206Row1TO472.getR78_banking_resident().intValue());
		}

		Cell row78cell8 = row78.getCell(9);

		if (row78cell8 != null) {
			row78cell8.setCellValue(brf206Row1TO472.getR78_trade_resident() == null ? 0
					: brf206Row1TO472.getR78_trade_resident().intValue());
		}

		Cell row78cell9 = row78.getCell(10);

		if (row78cell9 != null) {
			row78cell9.setCellValue(brf206Row1TO472.getR78_government_non_resident() == null ? 0
					: brf206Row1TO472.getR78_government_non_resident().intValue());
		}

		Cell row78cell10 = row78.getCell(11);

		if (row78cell10 != null) {
			row78cell10.setCellValue(brf206Row1TO472.getR78_gre_non_resident() == null ? 0
					: brf206Row1TO472.getR78_gre_non_resident().intValue());
		}

		Cell row78cell11 = row78.getCell(12);

		if (row78cell11 != null) {
			row78cell11.setCellValue(brf206Row1TO472.getR78_private_non_resident() == null ? 0
					: brf206Row1TO472.getR78_private_non_resident().intValue());
		}

		Cell row78cell12 = row78.getCell(13);

		if (row78cell12 != null) {
			row78cell12.setCellValue(brf206Row1TO472.getR78_hni_non_resident() == null ? 0
					: brf206Row1TO472.getR78_hni_non_resident().intValue());
		}

		Cell row78cell13 = row78.getCell(14);

		if (row78cell13 != null) {
			row78cell13.setCellValue(brf206Row1TO472.getR78_individual_non_resident() == null ? 0
					: brf206Row1TO472.getR78_individual_non_resident().intValue());
		}

		Cell row78cell14 = row78.getCell(15);

		if (row78cell14 != null) {
			row78cell14.setCellValue(brf206Row1TO472.getR78_banking_non_resident() == null ? 0
					: brf206Row1TO472.getR78_banking_non_resident().intValue());
		}

		Cell row78cell15 = row78.getCell(16);

		if (row78cell15 != null) {
			row78cell15.setCellValue(brf206Row1TO472.getR78_trade_non_resident() == null ? 0
					: brf206Row1TO472.getR78_trade_non_resident().intValue());
		}

		// ROW 79

		Row row79 = sheet.getRow(78);

		Cell row79cell1 = row79.getCell(2);

		if (row79cell1 != null) {
			row79cell1.setCellValue(brf206Row1TO472.getR79_country() == null ? "0" : brf206Row1TO472.getR79_country());
		}

		Cell row79cell2 = row79.getCell(3);

		if (row79cell2 != null) {
			row79cell2.setCellValue(brf206Row1TO472.getR79_government_resident() == null ? 0
					: brf206Row1TO472.getR79_government_resident().intValue());
		}

		Cell row79cell3 = row79.getCell(4);

		if (row79cell3 != null) {
			row79cell3.setCellValue(brf206Row1TO472.getR79_gre_resident() == null ? 0
					: brf206Row1TO472.getR79_gre_resident().intValue());
		}

		Cell row79cell4 = row79.getCell(5);

		if (row79cell4 != null) {
			row79cell4.setCellValue(brf206Row1TO472.getR79_private_resident() == null ? 0
					: brf206Row1TO472.getR79_private_resident().intValue());
		}

		Cell row79cell5 = row79.getCell(6);

		if (row79cell5 != null) {
			row79cell5.setCellValue(brf206Row1TO472.getR79_hni_resident() == null ? 0
					: brf206Row1TO472.getR79_hni_resident().intValue());
		}

		Cell row79cell6 = row79.getCell(7);

		if (row79cell6 != null) {
			row79cell6.setCellValue(brf206Row1TO472.getR79_individual_resident() == null ? 0
					: brf206Row1TO472.getR79_individual_resident().intValue());
		}

		Cell row79cell7 = row79.getCell(8);

		if (row79cell7 != null) {
			row79cell7.setCellValue(brf206Row1TO472.getR79_banking_resident() == null ? 0
					: brf206Row1TO472.getR79_banking_resident().intValue());
		}

		Cell row79cell8 = row79.getCell(9);

		if (row79cell8 != null) {
			row79cell8.setCellValue(brf206Row1TO472.getR79_trade_resident() == null ? 0
					: brf206Row1TO472.getR79_trade_resident().intValue());
		}

		Cell row79cell9 = row79.getCell(10);

		if (row79cell9 != null) {
			row79cell9.setCellValue(brf206Row1TO472.getR79_government_non_resident() == null ? 0
					: brf206Row1TO472.getR79_government_non_resident().intValue());
		}

		Cell row79cell10 = row79.getCell(11);

		if (row79cell10 != null) {
			row79cell10.setCellValue(brf206Row1TO472.getR79_gre_non_resident() == null ? 0
					: brf206Row1TO472.getR79_gre_non_resident().intValue());
		}

		Cell row79cell11 = row79.getCell(12);

		if (row79cell11 != null) {
			row79cell11.setCellValue(brf206Row1TO472.getR79_private_non_resident() == null ? 0
					: brf206Row1TO472.getR79_private_non_resident().intValue());
		}

		Cell row79cell12 = row79.getCell(13);

		if (row79cell12 != null) {
			row79cell12.setCellValue(brf206Row1TO472.getR79_hni_non_resident() == null ? 0
					: brf206Row1TO472.getR79_hni_non_resident().intValue());
		}

		Cell row79cell13 = row79.getCell(14);

		if (row79cell13 != null) {
			row79cell13.setCellValue(brf206Row1TO472.getR79_individual_non_resident() == null ? 0
					: brf206Row1TO472.getR79_individual_non_resident().intValue());
		}

		Cell row79cell14 = row79.getCell(15);

		if (row79cell14 != null) {
			row79cell14.setCellValue(brf206Row1TO472.getR79_banking_non_resident() == null ? 0
					: brf206Row1TO472.getR79_banking_non_resident().intValue());
		}

		Cell row79cell15 = row79.getCell(16);

		if (row79cell15 != null) {
			row79cell15.setCellValue(brf206Row1TO472.getR79_trade_non_resident() == null ? 0
					: brf206Row1TO472.getR79_trade_non_resident().intValue());
		}

		// ROW 8-

		Row row80 = sheet.getRow(79);

		Cell row80cell1 = row80.getCell(2);

		if (row80cell1 != null) {
			row80cell1.setCellValue(brf206Row1TO472.getR80_country() == null ? "0" : brf206Row1TO472.getR80_country());
		}

		Cell row80cell2 = row80.getCell(3);

		if (row80cell2 != null) {
			row80cell2.setCellValue(brf206Row1TO472.getR80_government_resident() == null ? 0
					: brf206Row1TO472.getR80_government_resident().intValue());
		}

		Cell row80cell3 = row80.getCell(4);

		if (row80cell3 != null) {
			row80cell3.setCellValue(brf206Row1TO472.getR80_gre_resident() == null ? 0
					: brf206Row1TO472.getR80_gre_resident().intValue());
		}

		Cell row80cell4 = row80.getCell(5);

		if (row80cell4 != null) {
			row80cell4.setCellValue(brf206Row1TO472.getR80_private_resident() == null ? 0
					: brf206Row1TO472.getR80_private_resident().intValue());
		}

		Cell row80cell5 = row80.getCell(6);

		if (row80cell5 != null) {
			row80cell5.setCellValue(brf206Row1TO472.getR80_hni_resident() == null ? 0
					: brf206Row1TO472.getR80_hni_resident().intValue());
		}

		Cell row80cell6 = row80.getCell(7);

		if (row80cell6 != null) {
			row80cell6.setCellValue(brf206Row1TO472.getR80_individual_resident() == null ? 0
					: brf206Row1TO472.getR80_individual_resident().intValue());
		}

		Cell row80cell7 = row80.getCell(8);

		if (row80cell7 != null) {
			row80cell7.setCellValue(brf206Row1TO472.getR80_banking_resident() == null ? 0
					: brf206Row1TO472.getR80_banking_resident().intValue());
		}

		Cell row80cell8 = row80.getCell(9);

		if (row80cell8 != null) {
			row80cell8.setCellValue(brf206Row1TO472.getR80_trade_resident() == null ? 0
					: brf206Row1TO472.getR80_trade_resident().intValue());
		}

		Cell row80cell9 = row80.getCell(10);

		if (row80cell9 != null) {
			row80cell9.setCellValue(brf206Row1TO472.getR80_government_non_resident() == null ? 0
					: brf206Row1TO472.getR80_government_non_resident().intValue());
		}

		Cell row80cell10 = row80.getCell(11);

		if (row80cell10 != null) {
			row80cell10.setCellValue(brf206Row1TO472.getR80_gre_non_resident() == null ? 0
					: brf206Row1TO472.getR80_gre_non_resident().intValue());
		}

		Cell row80cell11 = row80.getCell(12);

		if (row80cell11 != null) {
			row80cell11.setCellValue(brf206Row1TO472.getR80_private_non_resident() == null ? 0
					: brf206Row1TO472.getR80_private_non_resident().intValue());
		}

		Cell row80cell12 = row80.getCell(13);

		if (row80cell12 != null) {
			row80cell12.setCellValue(brf206Row1TO472.getR80_hni_non_resident() == null ? 0
					: brf206Row1TO472.getR80_hni_non_resident().intValue());
		}

		Cell row80cell13 = row80.getCell(14);

		if (row80cell13 != null) {
			row80cell13.setCellValue(brf206Row1TO472.getR80_individual_non_resident() == null ? 0
					: brf206Row1TO472.getR80_individual_non_resident().intValue());
		}

		Cell row80cell14 = row80.getCell(15);

		if (row80cell14 != null) {
			row80cell14.setCellValue(brf206Row1TO472.getR80_banking_non_resident() == null ? 0
					: brf206Row1TO472.getR80_banking_non_resident().intValue());
		}

		Cell row80cell15 = row80.getCell(16);

		if (row80cell15 != null) {
			row80cell15.setCellValue(brf206Row1TO472.getR80_trade_non_resident() == null ? 0
					: brf206Row1TO472.getR80_trade_non_resident().intValue());
		}

		// ROW 81

		Row row81 = sheet.getRow(80);

		Cell row81cell1 = row81.getCell(2);

		if (row81cell1 != null) {
			row81cell1.setCellValue(brf206Row1TO472.getR81_country() == null ? "0" : brf206Row1TO472.getR81_country());
		}

		Cell row81cell2 = row81.getCell(3);

		if (row81cell2 != null) {
			row81cell2.setCellValue(brf206Row1TO472.getR81_government_resident() == null ? 0
					: brf206Row1TO472.getR81_government_resident().intValue());
		}

		Cell row81cell3 = row81.getCell(4);

		if (row81cell3 != null) {
			row81cell3.setCellValue(brf206Row1TO472.getR81_gre_resident() == null ? 0
					: brf206Row1TO472.getR81_gre_resident().intValue());
		}

		Cell row81cell4 = row81.getCell(5);

		if (row81cell4 != null) {
			row81cell4.setCellValue(brf206Row1TO472.getR81_private_resident() == null ? 0
					: brf206Row1TO472.getR81_private_resident().intValue());
		}

		Cell row81cell5 = row81.getCell(6);

		if (row81cell5 != null) {
			row81cell5.setCellValue(brf206Row1TO472.getR81_hni_resident() == null ? 0
					: brf206Row1TO472.getR81_hni_resident().intValue());
		}

		Cell row81cell6 = row81.getCell(7);

		if (row81cell6 != null) {
			row81cell6.setCellValue(brf206Row1TO472.getR81_individual_resident() == null ? 0
					: brf206Row1TO472.getR81_individual_resident().intValue());
		}

		Cell row81cell7 = row81.getCell(8);

		if (row81cell7 != null) {
			row81cell7.setCellValue(brf206Row1TO472.getR81_banking_resident() == null ? 0
					: brf206Row1TO472.getR81_banking_resident().intValue());
		}

		Cell row81cell8 = row81.getCell(9);

		if (row81cell8 != null) {
			row81cell8.setCellValue(brf206Row1TO472.getR81_trade_resident() == null ? 0
					: brf206Row1TO472.getR81_trade_resident().intValue());
		}

		Cell row81cell9 = row81.getCell(10);

		if (row81cell9 != null) {
			row81cell9.setCellValue(brf206Row1TO472.getR81_government_non_resident() == null ? 0
					: brf206Row1TO472.getR81_government_non_resident().intValue());
		}

		Cell row81cell10 = row81.getCell(11);

		if (row81cell10 != null) {
			row81cell10.setCellValue(brf206Row1TO472.getR81_gre_non_resident() == null ? 0
					: brf206Row1TO472.getR81_gre_non_resident().intValue());
		}

		Cell row81cell11 = row81.getCell(12);

		if (row81cell11 != null) {
			row81cell11.setCellValue(brf206Row1TO472.getR81_private_non_resident() == null ? 0
					: brf206Row1TO472.getR81_private_non_resident().intValue());
		}

		Cell row81cell12 = row81.getCell(13);

		if (row81cell12 != null) {
			row81cell12.setCellValue(brf206Row1TO472.getR81_hni_non_resident() == null ? 0
					: brf206Row1TO472.getR81_hni_non_resident().intValue());
		}

		Cell row81cell13 = row81.getCell(14);

		if (row81cell13 != null) {
			row81cell13.setCellValue(brf206Row1TO472.getR81_individual_non_resident() == null ? 0
					: brf206Row1TO472.getR81_individual_non_resident().intValue());
		}

		Cell row81cell14 = row81.getCell(15);

		if (row81cell14 != null) {
			row81cell14.setCellValue(brf206Row1TO472.getR81_banking_non_resident() == null ? 0
					: brf206Row1TO472.getR81_banking_non_resident().intValue());
		}

		Cell row81cell15 = row81.getCell(16);

		if (row81cell15 != null) {
			row81cell15.setCellValue(brf206Row1TO472.getR81_trade_non_resident() == null ? 0
					: brf206Row1TO472.getR81_trade_non_resident().intValue());
		}

		// ROW 82

		Row row82 = sheet.getRow(81);

		Cell row82cell1 = row82.getCell(2);

		if (row82cell1 != null) {
			row82cell1.setCellValue(brf206Row1TO472.getR82_country() == null ? "0" : brf206Row1TO472.getR82_country());
		}

		Cell row82cell2 = row82.getCell(3);

		if (row82cell2 != null) {
			row82cell2.setCellValue(brf206Row1TO472.getR82_government_resident() == null ? 0
					: brf206Row1TO472.getR82_government_resident().intValue());
		}

		Cell row82cell3 = row82.getCell(4);

		if (row82cell3 != null) {
			row82cell3.setCellValue(brf206Row1TO472.getR82_gre_resident() == null ? 0
					: brf206Row1TO472.getR82_gre_resident().intValue());
		}

		Cell row82cell4 = row82.getCell(5);

		if (row82cell4 != null) {
			row82cell4.setCellValue(brf206Row1TO472.getR82_private_resident() == null ? 0
					: brf206Row1TO472.getR82_private_resident().intValue());
		}

		Cell row82cell5 = row82.getCell(6);

		if (row82cell5 != null) {
			row82cell5.setCellValue(brf206Row1TO472.getR82_hni_resident() == null ? 0
					: brf206Row1TO472.getR82_hni_resident().intValue());
		}

		Cell row82cell6 = row82.getCell(7);

		if (row82cell6 != null) {
			row82cell6.setCellValue(brf206Row1TO472.getR82_individual_resident() == null ? 0
					: brf206Row1TO472.getR82_individual_resident().intValue());
		}

		Cell row82cell7 = row82.getCell(8);

		if (row82cell7 != null) {
			row82cell7.setCellValue(brf206Row1TO472.getR82_banking_resident() == null ? 0
					: brf206Row1TO472.getR82_banking_resident().intValue());
		}

		Cell row82cell8 = row82.getCell(9);

		if (row82cell8 != null) {
			row82cell8.setCellValue(brf206Row1TO472.getR82_trade_resident() == null ? 0
					: brf206Row1TO472.getR82_trade_resident().intValue());
		}

		Cell row82cell9 = row82.getCell(10);

		if (row82cell9 != null) {
			row82cell9.setCellValue(brf206Row1TO472.getR82_government_non_resident() == null ? 0
					: brf206Row1TO472.getR82_government_non_resident().intValue());
		}

		Cell row82cell10 = row82.getCell(11);

		if (row82cell10 != null) {
			row82cell10.setCellValue(brf206Row1TO472.getR82_gre_non_resident() == null ? 0
					: brf206Row1TO472.getR82_gre_non_resident().intValue());
		}

		Cell row82cell11 = row82.getCell(12);

		if (row82cell11 != null) {
			row82cell11.setCellValue(brf206Row1TO472.getR82_private_non_resident() == null ? 0
					: brf206Row1TO472.getR82_private_non_resident().intValue());
		}

		Cell row82cell12 = row82.getCell(13);

		if (row82cell12 != null) {
			row82cell12.setCellValue(brf206Row1TO472.getR82_hni_non_resident() == null ? 0
					: brf206Row1TO472.getR82_hni_non_resident().intValue());
		}

		Cell row82cell13 = row82.getCell(14);

		if (row82cell13 != null) {
			row82cell13.setCellValue(brf206Row1TO472.getR82_individual_non_resident() == null ? 0
					: brf206Row1TO472.getR82_individual_non_resident().intValue());
		}

		Cell row82cell14 = row82.getCell(15);

		if (row82cell14 != null) {
			row82cell14.setCellValue(brf206Row1TO472.getR82_banking_non_resident() == null ? 0
					: brf206Row1TO472.getR82_banking_non_resident().intValue());
		}

		Cell row82cell15 = row82.getCell(16);

		if (row82cell15 != null) {
			row82cell15.setCellValue(brf206Row1TO472.getR82_trade_non_resident() == null ? 0
					: brf206Row1TO472.getR82_trade_non_resident().intValue());
		}

		// ROW 83

		Row row83 = sheet.getRow(82);

		Cell row83cell1 = row83.getCell(2);

		if (row83cell1 != null) {
			row83cell1.setCellValue(brf206Row1TO472.getR83_country() == null ? "0" : brf206Row1TO472.getR83_country());
		}

		Cell row83cell2 = row83.getCell(3);

		if (row83cell2 != null) {
			row83cell2.setCellValue(brf206Row1TO472.getR83_government_resident() == null ? 0
					: brf206Row1TO472.getR83_government_resident().intValue());
		}

		Cell row83cell3 = row83.getCell(4);

		if (row83cell3 != null) {
			row83cell3.setCellValue(brf206Row1TO472.getR83_gre_resident() == null ? 0
					: brf206Row1TO472.getR83_gre_resident().intValue());
		}

		Cell row83cell4 = row83.getCell(5);

		if (row83cell4 != null) {
			row83cell4.setCellValue(brf206Row1TO472.getR83_private_resident() == null ? 0
					: brf206Row1TO472.getR83_private_resident().intValue());
		}

		Cell row83cell5 = row83.getCell(6);

		if (row83cell5 != null) {
			row83cell5.setCellValue(brf206Row1TO472.getR83_hni_resident() == null ? 0
					: brf206Row1TO472.getR83_hni_resident().intValue());
		}

		Cell row83cell6 = row83.getCell(7);

		if (row83cell6 != null) {
			row83cell6.setCellValue(brf206Row1TO472.getR83_individual_resident() == null ? 0
					: brf206Row1TO472.getR83_individual_resident().intValue());
		}

		Cell row83cell7 = row83.getCell(8);

		if (row83cell7 != null) {
			row83cell7.setCellValue(brf206Row1TO472.getR83_banking_resident() == null ? 0
					: brf206Row1TO472.getR83_banking_resident().intValue());
		}

		Cell row83cell8 = row83.getCell(9);

		if (row83cell8 != null) {
			row83cell8.setCellValue(brf206Row1TO472.getR83_trade_resident() == null ? 0
					: brf206Row1TO472.getR83_trade_resident().intValue());
		}

		Cell row83cell9 = row83.getCell(10);

		if (row83cell9 != null) {
			row83cell9.setCellValue(brf206Row1TO472.getR83_government_non_resident() == null ? 0
					: brf206Row1TO472.getR83_government_non_resident().intValue());
		}

		Cell row83cell10 = row83.getCell(11);

		if (row83cell10 != null) {
			row83cell10.setCellValue(brf206Row1TO472.getR83_gre_non_resident() == null ? 0
					: brf206Row1TO472.getR83_gre_non_resident().intValue());
		}

		Cell row83cell11 = row83.getCell(12);

		if (row83cell11 != null) {
			row83cell11.setCellValue(brf206Row1TO472.getR83_private_non_resident() == null ? 0
					: brf206Row1TO472.getR83_private_non_resident().intValue());
		}

		Cell row83cell12 = row83.getCell(13);

		if (row83cell12 != null) {
			row83cell12.setCellValue(brf206Row1TO472.getR83_hni_non_resident() == null ? 0
					: brf206Row1TO472.getR83_hni_non_resident().intValue());
		}

		Cell row83cell13 = row83.getCell(14);

		if (row83cell13 != null) {
			row83cell13.setCellValue(brf206Row1TO472.getR83_individual_non_resident() == null ? 0
					: brf206Row1TO472.getR83_individual_non_resident().intValue());
		}

		Cell row83cell14 = row83.getCell(15);

		if (row83cell14 != null) {
			row83cell14.setCellValue(brf206Row1TO472.getR83_banking_non_resident() == null ? 0
					: brf206Row1TO472.getR83_banking_non_resident().intValue());
		}

		Cell row83cell15 = row83.getCell(16);

		if (row83cell15 != null) {
			row83cell15.setCellValue(brf206Row1TO472.getR83_trade_non_resident() == null ? 0
					: brf206Row1TO472.getR83_trade_non_resident().intValue());
		}

		// ROW 84

		Row row84 = sheet.getRow(83);

		Cell row84cell1 = row84.getCell(2);

		if (row84cell1 != null) {
			row84cell1.setCellValue(brf206Row1TO472.getR84_country() == null ? "0" : brf206Row1TO472.getR84_country());
		}

		Cell row84cell2 = row84.getCell(3);

		if (row84cell2 != null) {
			row84cell2.setCellValue(brf206Row1TO472.getR84_government_resident() == null ? 0
					: brf206Row1TO472.getR84_government_resident().intValue());
		}

		Cell row84cell3 = row84.getCell(4);

		if (row84cell3 != null) {
			row84cell3.setCellValue(brf206Row1TO472.getR84_gre_resident() == null ? 0
					: brf206Row1TO472.getR84_gre_resident().intValue());
		}

		Cell row84cell4 = row84.getCell(5);

		if (row84cell4 != null) {
			row84cell4.setCellValue(brf206Row1TO472.getR84_private_resident() == null ? 0
					: brf206Row1TO472.getR84_private_resident().intValue());
		}

		Cell row84cell5 = row84.getCell(6);

		if (row84cell5 != null) {
			row84cell5.setCellValue(brf206Row1TO472.getR84_hni_resident() == null ? 0
					: brf206Row1TO472.getR84_hni_resident().intValue());
		}

		Cell row84cell6 = row84.getCell(7);

		if (row84cell6 != null) {
			row84cell6.setCellValue(brf206Row1TO472.getR84_individual_resident() == null ? 0
					: brf206Row1TO472.getR84_individual_resident().intValue());
		}

		Cell row84cell7 = row84.getCell(8);

		if (row84cell7 != null) {
			row84cell7.setCellValue(brf206Row1TO472.getR84_banking_resident() == null ? 0
					: brf206Row1TO472.getR84_banking_resident().intValue());
		}

		Cell row84cell8 = row84.getCell(9);

		if (row84cell8 != null) {
			row84cell8.setCellValue(brf206Row1TO472.getR84_trade_resident() == null ? 0
					: brf206Row1TO472.getR84_trade_resident().intValue());
		}

		Cell row84cell9 = row84.getCell(10);

		if (row84cell9 != null) {
			row84cell9.setCellValue(brf206Row1TO472.getR84_government_non_resident() == null ? 0
					: brf206Row1TO472.getR84_government_non_resident().intValue());
		}

		Cell row84cell10 = row84.getCell(11);

		if (row84cell10 != null) {
			row84cell10.setCellValue(brf206Row1TO472.getR84_gre_non_resident() == null ? 0
					: brf206Row1TO472.getR84_gre_non_resident().intValue());
		}

		Cell row84cell11 = row84.getCell(12);

		if (row84cell11 != null) {
			row84cell11.setCellValue(brf206Row1TO472.getR84_private_non_resident() == null ? 0
					: brf206Row1TO472.getR84_private_non_resident().intValue());
		}

		Cell row84cell12 = row84.getCell(13);

		if (row84cell12 != null) {
			row84cell12.setCellValue(brf206Row1TO472.getR84_hni_non_resident() == null ? 0
					: brf206Row1TO472.getR84_hni_non_resident().intValue());
		}

		Cell row84cell13 = row84.getCell(14);

		if (row84cell13 != null) {
			row84cell13.setCellValue(brf206Row1TO472.getR84_individual_non_resident() == null ? 0
					: brf206Row1TO472.getR84_individual_non_resident().intValue());
		}

		Cell row84cell14 = row84.getCell(15);

		if (row84cell14 != null) {
			row84cell14.setCellValue(brf206Row1TO472.getR84_banking_non_resident() == null ? 0
					: brf206Row1TO472.getR84_banking_non_resident().intValue());
		}

		Cell row84cell15 = row84.getCell(16);

		if (row84cell15 != null) {
			row84cell15.setCellValue(brf206Row1TO472.getR84_trade_non_resident() == null ? 0
					: brf206Row1TO472.getR84_trade_non_resident().intValue());
		}

		// ROW 85

		Row row85 = sheet.getRow(84);

		Cell row85cell1 = row85.getCell(2);

		if (row85cell1 != null) {
			row85cell1.setCellValue(brf206Row1TO472.getR85_country() == null ? "0" : brf206Row1TO472.getR85_country());
		}

		Cell row85cell2 = row85.getCell(3);

		if (row85cell2 != null) {
			row85cell2.setCellValue(brf206Row1TO472.getR85_government_resident() == null ? 0
					: brf206Row1TO472.getR85_government_resident().intValue());
		}

		Cell row85cell3 = row85.getCell(4);

		if (row85cell3 != null) {
			row85cell3.setCellValue(brf206Row1TO472.getR85_gre_resident() == null ? 0
					: brf206Row1TO472.getR85_gre_resident().intValue());
		}

		Cell row85cell4 = row85.getCell(5);

		if (row85cell4 != null) {
			row85cell4.setCellValue(brf206Row1TO472.getR85_private_resident() == null ? 0
					: brf206Row1TO472.getR85_private_resident().intValue());
		}

		Cell row85cell5 = row85.getCell(6);

		if (row85cell5 != null) {
			row85cell5.setCellValue(brf206Row1TO472.getR85_hni_resident() == null ? 0
					: brf206Row1TO472.getR85_hni_resident().intValue());
		}

		Cell row85cell6 = row85.getCell(7);

		if (row85cell6 != null) {
			row85cell6.setCellValue(brf206Row1TO472.getR85_individual_resident() == null ? 0
					: brf206Row1TO472.getR85_individual_resident().intValue());
		}

		Cell row85cell7 = row85.getCell(8);

		if (row85cell7 != null) {
			row85cell7.setCellValue(brf206Row1TO472.getR85_banking_resident() == null ? 0
					: brf206Row1TO472.getR85_banking_resident().intValue());
		}

		Cell row85cell8 = row85.getCell(9);

		if (row85cell8 != null) {
			row85cell8.setCellValue(brf206Row1TO472.getR85_trade_resident() == null ? 0
					: brf206Row1TO472.getR85_trade_resident().intValue());
		}

		Cell row85cell9 = row85.getCell(10);

		if (row85cell9 != null) {
			row85cell9.setCellValue(brf206Row1TO472.getR85_government_non_resident() == null ? 0
					: brf206Row1TO472.getR85_government_non_resident().intValue());
		}

		Cell row85cell10 = row85.getCell(11);

		if (row85cell10 != null) {
			row85cell10.setCellValue(brf206Row1TO472.getR85_gre_non_resident() == null ? 0
					: brf206Row1TO472.getR85_gre_non_resident().intValue());
		}

		Cell row85cell11 = row85.getCell(12);

		if (row85cell11 != null) {
			row85cell11.setCellValue(brf206Row1TO472.getR85_private_non_resident() == null ? 0
					: brf206Row1TO472.getR85_private_non_resident().intValue());
		}

		Cell row85cell12 = row85.getCell(13);

		if (row85cell12 != null) {
			row85cell12.setCellValue(brf206Row1TO472.getR85_hni_non_resident() == null ? 0
					: brf206Row1TO472.getR85_hni_non_resident().intValue());
		}

		Cell row85cell13 = row85.getCell(14);

		if (row85cell13 != null) {
			row85cell13.setCellValue(brf206Row1TO472.getR85_individual_non_resident() == null ? 0
					: brf206Row1TO472.getR85_individual_non_resident().intValue());
		}

		Cell row85cell14 = row85.getCell(15);

		if (row85cell14 != null) {
			row85cell14.setCellValue(brf206Row1TO472.getR85_banking_non_resident() == null ? 0
					: brf206Row1TO472.getR85_banking_non_resident().intValue());
		}

		Cell row85cell15 = row85.getCell(16);

		if (row85cell15 != null) {
			row85cell15.setCellValue(brf206Row1TO472.getR85_trade_non_resident() == null ? 0
					: brf206Row1TO472.getR85_trade_non_resident().intValue());
		}

		// ROW 86

		Row row86 = sheet.getRow(85);

		Cell row86cell1 = row86.getCell(2);

		if (row86cell1 != null) {
			row86cell1.setCellValue(brf206Row1TO472.getR86_country() == null ? "0" : brf206Row1TO472.getR86_country());
		}

		Cell row86cell2 = row86.getCell(3);

		if (row86cell2 != null) {
			row86cell2.setCellValue(brf206Row1TO472.getR86_government_resident() == null ? 0
					: brf206Row1TO472.getR86_government_resident().intValue());
		}

		Cell row86cell3 = row86.getCell(4);

		if (row86cell3 != null) {
			row86cell3.setCellValue(brf206Row1TO472.getR86_gre_resident() == null ? 0
					: brf206Row1TO472.getR86_gre_resident().intValue());
		}

		Cell row86cell4 = row86.getCell(5);

		if (row86cell4 != null) {
			row86cell4.setCellValue(brf206Row1TO472.getR86_private_resident() == null ? 0
					: brf206Row1TO472.getR86_private_resident().intValue());
		}

		Cell row86cell5 = row86.getCell(6);

		if (row86cell5 != null) {
			row86cell5.setCellValue(brf206Row1TO472.getR86_hni_resident() == null ? 0
					: brf206Row1TO472.getR86_hni_resident().intValue());
		}

		Cell row86cell6 = row86.getCell(7);

		if (row86cell6 != null) {
			row86cell6.setCellValue(brf206Row1TO472.getR86_individual_resident() == null ? 0
					: brf206Row1TO472.getR86_individual_resident().intValue());
		}

		Cell row86cell7 = row86.getCell(8);

		if (row86cell7 != null) {
			row86cell7.setCellValue(brf206Row1TO472.getR86_banking_resident() == null ? 0
					: brf206Row1TO472.getR86_banking_resident().intValue());
		}

		Cell row86cell8 = row86.getCell(9);

		if (row86cell8 != null) {
			row86cell8.setCellValue(brf206Row1TO472.getR86_trade_resident() == null ? 0
					: brf206Row1TO472.getR86_trade_resident().intValue());
		}

		Cell row86cell9 = row86.getCell(10);

		if (row86cell9 != null) {
			row86cell9.setCellValue(brf206Row1TO472.getR86_government_non_resident() == null ? 0
					: brf206Row1TO472.getR86_government_non_resident().intValue());
		}

		Cell row86cell10 = row86.getCell(11);

		if (row86cell10 != null) {
			row86cell10.setCellValue(brf206Row1TO472.getR86_gre_non_resident() == null ? 0
					: brf206Row1TO472.getR86_gre_non_resident().intValue());
		}

		Cell row86cell11 = row86.getCell(12);

		if (row86cell11 != null) {
			row86cell11.setCellValue(brf206Row1TO472.getR86_private_non_resident() == null ? 0
					: brf206Row1TO472.getR86_private_non_resident().intValue());
		}

		Cell row86cell12 = row86.getCell(13);

		if (row86cell12 != null) {
			row86cell12.setCellValue(brf206Row1TO472.getR86_hni_non_resident() == null ? 0
					: brf206Row1TO472.getR86_hni_non_resident().intValue());
		}

		Cell row86cell13 = row86.getCell(14);

		if (row86cell13 != null) {
			row86cell13.setCellValue(brf206Row1TO472.getR86_individual_non_resident() == null ? 0
					: brf206Row1TO472.getR86_individual_non_resident().intValue());
		}

		Cell row86cell14 = row86.getCell(15);

		if (row86cell14 != null) {
			row86cell14.setCellValue(brf206Row1TO472.getR86_banking_non_resident() == null ? 0
					: brf206Row1TO472.getR86_banking_non_resident().intValue());
		}

		Cell row86cell15 = row86.getCell(16);

		if (row86cell15 != null) {
			row86cell15.setCellValue(brf206Row1TO472.getR86_trade_non_resident() == null ? 0
					: brf206Row1TO472.getR86_trade_non_resident().intValue());
		}

		// ROW 87

		Row row87 = sheet.getRow(86);

		Cell row87cell1 = row87.getCell(2);

		if (row87cell1 != null) {
			row87cell1.setCellValue(brf206Row1TO472.getR87_country() == null ? "0" : brf206Row1TO472.getR87_country());
		}

		Cell row87cell2 = row87.getCell(3);

		if (row87cell2 != null) {
			row87cell2.setCellValue(brf206Row1TO472.getR87_government_resident() == null ? 0
					: brf206Row1TO472.getR87_government_resident().intValue());
		}

		Cell row87cell3 = row87.getCell(4);

		if (row87cell3 != null) {
			row87cell3.setCellValue(brf206Row1TO472.getR87_gre_resident() == null ? 0
					: brf206Row1TO472.getR87_gre_resident().intValue());
		}

		Cell row87cell4 = row87.getCell(5);

		if (row87cell4 != null) {
			row87cell4.setCellValue(brf206Row1TO472.getR87_private_resident() == null ? 0
					: brf206Row1TO472.getR87_private_resident().intValue());
		}

		Cell row87cell5 = row87.getCell(6);

		if (row87cell5 != null) {
			row87cell5.setCellValue(brf206Row1TO472.getR87_hni_resident() == null ? 0
					: brf206Row1TO472.getR87_hni_resident().intValue());
		}

		Cell row87cell6 = row87.getCell(7);

		if (row87cell6 != null) {
			row87cell6.setCellValue(brf206Row1TO472.getR87_individual_resident() == null ? 0
					: brf206Row1TO472.getR87_individual_resident().intValue());
		}

		Cell row87cell7 = row87.getCell(8);

		if (row87cell7 != null) {
			row87cell7.setCellValue(brf206Row1TO472.getR87_banking_resident() == null ? 0
					: brf206Row1TO472.getR87_banking_resident().intValue());
		}

		Cell row87cell8 = row87.getCell(9);

		if (row87cell8 != null) {
			row87cell8.setCellValue(brf206Row1TO472.getR87_trade_resident() == null ? 0
					: brf206Row1TO472.getR87_trade_resident().intValue());
		}

		Cell row87cell9 = row87.getCell(10);

		if (row87cell9 != null) {
			row87cell9.setCellValue(brf206Row1TO472.getR87_government_non_resident() == null ? 0
					: brf206Row1TO472.getR87_government_non_resident().intValue());
		}

		Cell row87cell10 = row87.getCell(11);

		if (row87cell10 != null) {
			row87cell10.setCellValue(brf206Row1TO472.getR87_gre_non_resident() == null ? 0
					: brf206Row1TO472.getR87_gre_non_resident().intValue());
		}

		Cell row87cell11 = row87.getCell(12);

		if (row87cell11 != null) {
			row87cell11.setCellValue(brf206Row1TO472.getR87_private_non_resident() == null ? 0
					: brf206Row1TO472.getR87_private_non_resident().intValue());
		}

		Cell row87cell12 = row87.getCell(13);

		if (row87cell12 != null) {
			row87cell12.setCellValue(brf206Row1TO472.getR87_hni_non_resident() == null ? 0
					: brf206Row1TO472.getR87_hni_non_resident().intValue());
		}

		Cell row87cell13 = row87.getCell(14);

		if (row87cell13 != null) {
			row87cell13.setCellValue(brf206Row1TO472.getR87_individual_non_resident() == null ? 0
					: brf206Row1TO472.getR87_individual_non_resident().intValue());
		}

		Cell row87cell14 = row87.getCell(15);

		if (row87cell14 != null) {
			row87cell14.setCellValue(brf206Row1TO472.getR87_banking_non_resident() == null ? 0
					: brf206Row1TO472.getR87_banking_non_resident().intValue());
		}

		Cell row87cell15 = row87.getCell(16);

		if (row87cell15 != null) {
			row87cell15.setCellValue(brf206Row1TO472.getR87_trade_non_resident() == null ? 0
					: brf206Row1TO472.getR87_trade_non_resident().intValue());
		}

		// ROW 88

		Row row88 = sheet.getRow(87);

		Cell row88cell1 = row88.getCell(2);

		if (row88cell1 != null) {
			row88cell1.setCellValue(brf206Row1TO472.getR88_country() == null ? "0" : brf206Row1TO472.getR88_country());
		}

		Cell row88cell2 = row88.getCell(3);

		if (row88cell2 != null) {
			row88cell2.setCellValue(brf206Row1TO472.getR88_government_resident() == null ? 0
					: brf206Row1TO472.getR88_government_resident().intValue());
		}

		Cell row88cell3 = row88.getCell(4);

		if (row88cell3 != null) {
			row88cell3.setCellValue(brf206Row1TO472.getR88_gre_resident() == null ? 0
					: brf206Row1TO472.getR88_gre_resident().intValue());
		}

		Cell row88cell4 = row88.getCell(5);

		if (row88cell4 != null) {
			row88cell4.setCellValue(brf206Row1TO472.getR88_private_resident() == null ? 0
					: brf206Row1TO472.getR88_private_resident().intValue());
		}

		Cell row88cell5 = row88.getCell(6);

		if (row88cell5 != null) {
			row88cell5.setCellValue(brf206Row1TO472.getR88_hni_resident() == null ? 0
					: brf206Row1TO472.getR88_hni_resident().intValue());
		}

		Cell row88cell6 = row88.getCell(7);

		if (row88cell6 != null) {
			row88cell6.setCellValue(brf206Row1TO472.getR88_individual_resident() == null ? 0
					: brf206Row1TO472.getR88_individual_resident().intValue());
		}

		Cell row88cell7 = row88.getCell(8);

		if (row88cell7 != null) {
			row88cell7.setCellValue(brf206Row1TO472.getR88_banking_resident() == null ? 0
					: brf206Row1TO472.getR88_banking_resident().intValue());
		}

		Cell row88cell8 = row88.getCell(9);

		if (row88cell8 != null) {
			row88cell8.setCellValue(brf206Row1TO472.getR88_trade_resident() == null ? 0
					: brf206Row1TO472.getR88_trade_resident().intValue());
		}

		Cell row88cell9 = row88.getCell(10);

		if (row88cell9 != null) {
			row88cell9.setCellValue(brf206Row1TO472.getR88_government_non_resident() == null ? 0
					: brf206Row1TO472.getR88_government_non_resident().intValue());
		}

		Cell row88cell10 = row88.getCell(11);

		if (row88cell10 != null) {
			row88cell10.setCellValue(brf206Row1TO472.getR88_gre_non_resident() == null ? 0
					: brf206Row1TO472.getR88_gre_non_resident().intValue());
		}

		Cell row88cell11 = row88.getCell(12);

		if (row88cell11 != null) {
			row88cell11.setCellValue(brf206Row1TO472.getR88_private_non_resident() == null ? 0
					: brf206Row1TO472.getR88_private_non_resident().intValue());
		}

		Cell row88cell12 = row88.getCell(13);

		if (row88cell12 != null) {
			row88cell12.setCellValue(brf206Row1TO472.getR88_hni_non_resident() == null ? 0
					: brf206Row1TO472.getR88_hni_non_resident().intValue());
		}

		Cell row88cell13 = row88.getCell(14);

		if (row88cell13 != null) {
			row88cell13.setCellValue(brf206Row1TO472.getR88_individual_non_resident() == null ? 0
					: brf206Row1TO472.getR88_individual_non_resident().intValue());
		}

		Cell row88cell14 = row88.getCell(15);

		if (row88cell14 != null) {
			row88cell14.setCellValue(brf206Row1TO472.getR88_banking_non_resident() == null ? 0
					: brf206Row1TO472.getR88_banking_non_resident().intValue());
		}

		Cell row88cell15 = row88.getCell(16);

		if (row88cell15 != null) {
			row88cell15.setCellValue(brf206Row1TO472.getR88_trade_non_resident() == null ? 0
					: brf206Row1TO472.getR88_trade_non_resident().intValue());
		}

		// ROW 89

		Row row89 = sheet.getRow(88);

		Cell row89cell1 = row89.getCell(2);

		if (row89cell1 != null) {
			row89cell1.setCellValue(brf206Row1TO472.getR89_country() == null ? "0" : brf206Row1TO472.getR89_country());
		}

		Cell row89cell2 = row89.getCell(3);

		if (row89cell2 != null) {
			row89cell2.setCellValue(brf206Row1TO472.getR89_government_resident() == null ? 0
					: brf206Row1TO472.getR89_government_resident().intValue());
		}

		Cell row89cell3 = row89.getCell(4);

		if (row89cell3 != null) {
			row89cell3.setCellValue(brf206Row1TO472.getR89_gre_resident() == null ? 0
					: brf206Row1TO472.getR89_gre_resident().intValue());
		}

		Cell row89cell4 = row89.getCell(5);

		if (row89cell4 != null) {
			row89cell4.setCellValue(brf206Row1TO472.getR89_private_resident() == null ? 0
					: brf206Row1TO472.getR89_private_resident().intValue());
		}

		Cell row89cell5 = row89.getCell(6);

		if (row89cell5 != null) {
			row89cell5.setCellValue(brf206Row1TO472.getR89_hni_resident() == null ? 0
					: brf206Row1TO472.getR89_hni_resident().intValue());
		}

		Cell row89cell6 = row89.getCell(7);

		if (row89cell6 != null) {
			row89cell6.setCellValue(brf206Row1TO472.getR89_individual_resident() == null ? 0
					: brf206Row1TO472.getR89_individual_resident().intValue());
		}

		Cell row89cell7 = row89.getCell(8);

		if (row89cell7 != null) {
			row89cell7.setCellValue(brf206Row1TO472.getR89_banking_resident() == null ? 0
					: brf206Row1TO472.getR89_banking_resident().intValue());
		}

		Cell row89cell8 = row89.getCell(9);

		if (row89cell8 != null) {
			row89cell8.setCellValue(brf206Row1TO472.getR89_trade_resident() == null ? 0
					: brf206Row1TO472.getR89_trade_resident().intValue());
		}

		Cell row89cell9 = row89.getCell(10);

		if (row89cell9 != null) {
			row89cell9.setCellValue(brf206Row1TO472.getR89_government_non_resident() == null ? 0
					: brf206Row1TO472.getR89_government_non_resident().intValue());
		}

		Cell row89cell10 = row89.getCell(11);

		if (row89cell10 != null) {
			row89cell10.setCellValue(brf206Row1TO472.getR89_gre_non_resident() == null ? 0
					: brf206Row1TO472.getR89_gre_non_resident().intValue());
		}

		Cell row89cell11 = row89.getCell(12);

		if (row89cell11 != null) {
			row89cell11.setCellValue(brf206Row1TO472.getR89_private_non_resident() == null ? 0
					: brf206Row1TO472.getR89_private_non_resident().intValue());
		}

		Cell row89cell12 = row89.getCell(13);

		if (row89cell12 != null) {
			row89cell12.setCellValue(brf206Row1TO472.getR89_hni_non_resident() == null ? 0
					: brf206Row1TO472.getR89_hni_non_resident().intValue());
		}

		Cell row89cell13 = row89.getCell(14);

		if (row89cell13 != null) {
			row89cell13.setCellValue(brf206Row1TO472.getR89_individual_non_resident() == null ? 0
					: brf206Row1TO472.getR89_individual_non_resident().intValue());
		}

		Cell row89cell14 = row89.getCell(15);

		if (row89cell14 != null) {
			row89cell14.setCellValue(brf206Row1TO472.getR89_banking_non_resident() == null ? 0
					: brf206Row1TO472.getR89_banking_non_resident().intValue());
		}

		Cell row89cell15 = row89.getCell(16);

		if (row89cell15 != null) {
			row89cell15.setCellValue(brf206Row1TO472.getR89_trade_non_resident() == null ? 0
					: brf206Row1TO472.getR89_trade_non_resident().intValue());
		}

		// ROW 91

		Row row91 = sheet.getRow(90);

		Cell row91cell1 = row91.getCell(2);

		if (row91cell1 != null) {
			row91cell1.setCellValue(brf206Row1TO472.getR91_country() == null ? "0" : brf206Row1TO472.getR91_country());
		}

		Cell row91cell2 = row91.getCell(3);

		if (row91cell2 != null) {
			row91cell2.setCellValue(brf206Row1TO472.getR91_government_resident() == null ? 0
					: brf206Row1TO472.getR91_government_resident().intValue());
		}

		Cell row91cell3 = row91.getCell(4);

		if (row91cell3 != null) {
			row91cell3.setCellValue(brf206Row1TO472.getR91_gre_resident() == null ? 0
					: brf206Row1TO472.getR91_gre_resident().intValue());
		}

		Cell row91cell4 = row91.getCell(5);

		if (row91cell4 != null) {
			row91cell4.setCellValue(brf206Row1TO472.getR91_private_resident() == null ? 0
					: brf206Row1TO472.getR91_private_resident().intValue());
		}

		Cell row91cell5 = row91.getCell(6);

		if (row91cell5 != null) {
			row91cell5.setCellValue(brf206Row1TO472.getR91_hni_resident() == null ? 0
					: brf206Row1TO472.getR91_hni_resident().intValue());
		}

		Cell row91cell6 = row91.getCell(7);

		if (row91cell6 != null) {
			row91cell6.setCellValue(brf206Row1TO472.getR91_individual_resident() == null ? 0
					: brf206Row1TO472.getR91_individual_resident().intValue());
		}

		Cell row91cell7 = row91.getCell(8);

		if (row91cell7 != null) {
			row91cell7.setCellValue(brf206Row1TO472.getR91_banking_resident() == null ? 0
					: brf206Row1TO472.getR91_banking_resident().intValue());
		}

		Cell row91cell8 = row91.getCell(9);

		if (row91cell8 != null) {
			row91cell8.setCellValue(brf206Row1TO472.getR91_trade_resident() == null ? 0
					: brf206Row1TO472.getR91_trade_resident().intValue());
		}

		Cell row91cell9 = row91.getCell(10);

		if (row91cell9 != null) {
			row91cell9.setCellValue(brf206Row1TO472.getR91_government_non_resident() == null ? 0
					: brf206Row1TO472.getR91_government_non_resident().intValue());
		}

		Cell row91cell10 = row91.getCell(11);

		if (row91cell10 != null) {
			row91cell10.setCellValue(brf206Row1TO472.getR91_gre_non_resident() == null ? 0
					: brf206Row1TO472.getR91_gre_non_resident().intValue());
		}

		Cell row91cell11 = row91.getCell(12);

		if (row91cell11 != null) {
			row91cell11.setCellValue(brf206Row1TO472.getR91_private_non_resident() == null ? 0
					: brf206Row1TO472.getR91_private_non_resident().intValue());
		}

		Cell row91cell12 = row91.getCell(13);

		if (row91cell12 != null) {
			row91cell12.setCellValue(brf206Row1TO472.getR91_hni_non_resident() == null ? 0
					: brf206Row1TO472.getR91_hni_non_resident().intValue());
		}

		Cell row91cell13 = row91.getCell(14);

		if (row91cell13 != null) {
			row91cell13.setCellValue(brf206Row1TO472.getR91_individual_non_resident() == null ? 0
					: brf206Row1TO472.getR91_individual_non_resident().intValue());
		}

		Cell row91cell14 = row91.getCell(15);

		if (row91cell14 != null) {
			row91cell14.setCellValue(brf206Row1TO472.getR91_banking_non_resident() == null ? 0
					: brf206Row1TO472.getR91_banking_non_resident().intValue());
		}

		Cell row91cell15 = row91.getCell(16);

		if (row91cell15 != null) {
			row91cell15.setCellValue(brf206Row1TO472.getR91_trade_non_resident() == null ? 0
					: brf206Row1TO472.getR91_trade_non_resident().intValue());
		}

		// ROW 92

		Row row92 = sheet.getRow(91);

		Cell row92cell1 = row92.getCell(2);

		if (row92cell1 != null) {
			row92cell1.setCellValue(brf206Row1TO472.getR92_country() == null ? "0" : brf206Row1TO472.getR92_country());
		}

		Cell row92cell2 = row92.getCell(3);

		if (row92cell2 != null) {
			row92cell2.setCellValue(brf206Row1TO472.getR92_government_resident() == null ? 0
					: brf206Row1TO472.getR92_government_resident().intValue());
		}

		Cell row92cell3 = row92.getCell(4);

		if (row92cell3 != null) {
			row92cell3.setCellValue(brf206Row1TO472.getR92_gre_resident() == null ? 0
					: brf206Row1TO472.getR92_gre_resident().intValue());
		}

		Cell row92cell4 = row92.getCell(5);

		if (row92cell4 != null) {
			row92cell4.setCellValue(brf206Row1TO472.getR92_private_resident() == null ? 0
					: brf206Row1TO472.getR92_private_resident().intValue());
		}

		Cell row92cell5 = row92.getCell(6);

		if (row92cell5 != null) {
			row92cell5.setCellValue(brf206Row1TO472.getR92_hni_resident() == null ? 0
					: brf206Row1TO472.getR92_hni_resident().intValue());
		}

		Cell row92cell6 = row92.getCell(7);

		if (row92cell6 != null) {
			row92cell6.setCellValue(brf206Row1TO472.getR92_individual_resident() == null ? 0
					: brf206Row1TO472.getR92_individual_resident().intValue());
		}

		Cell row92cell7 = row92.getCell(8);

		if (row92cell7 != null) {
			row92cell7.setCellValue(brf206Row1TO472.getR92_banking_resident() == null ? 0
					: brf206Row1TO472.getR92_banking_resident().intValue());
		}

		Cell row92cell8 = row92.getCell(9);

		if (row92cell8 != null) {
			row92cell8.setCellValue(brf206Row1TO472.getR92_trade_resident() == null ? 0
					: brf206Row1TO472.getR92_trade_resident().intValue());
		}

		Cell row92cell9 = row92.getCell(10);

		if (row92cell9 != null) {
			row92cell9.setCellValue(brf206Row1TO472.getR92_government_non_resident() == null ? 0
					: brf206Row1TO472.getR92_government_non_resident().intValue());
		}

		Cell row92cell10 = row92.getCell(11);

		if (row92cell10 != null) {
			row92cell10.setCellValue(brf206Row1TO472.getR92_gre_non_resident() == null ? 0
					: brf206Row1TO472.getR92_gre_non_resident().intValue());
		}

		Cell row92cell11 = row92.getCell(12);

		if (row92cell11 != null) {
			row92cell11.setCellValue(brf206Row1TO472.getR92_private_non_resident() == null ? 0
					: brf206Row1TO472.getR92_private_non_resident().intValue());
		}

		Cell row92cell12 = row92.getCell(13);

		if (row92cell12 != null) {
			row92cell12.setCellValue(brf206Row1TO472.getR92_hni_non_resident() == null ? 0
					: brf206Row1TO472.getR92_hni_non_resident().intValue());
		}

		Cell row92cell13 = row92.getCell(14);

		if (row92cell13 != null) {
			row92cell13.setCellValue(brf206Row1TO472.getR92_individual_non_resident() == null ? 0
					: brf206Row1TO472.getR92_individual_non_resident().intValue());
		}

		Cell row92cell14 = row92.getCell(15);

		if (row92cell14 != null) {
			row92cell14.setCellValue(brf206Row1TO472.getR92_banking_non_resident() == null ? 0
					: brf206Row1TO472.getR92_banking_non_resident().intValue());
		}

		Cell row92cell15 = row92.getCell(16);

		if (row92cell15 != null) {
			row92cell15.setCellValue(brf206Row1TO472.getR92_trade_non_resident() == null ? 0
					: brf206Row1TO472.getR92_trade_non_resident().intValue());
		}

		// ROW 93

		Row row93 = sheet.getRow(92);

		Cell row93cell1 = row93.getCell(2);

		if (row93cell1 != null) {
			row93cell1.setCellValue(brf206Row1TO472.getR93_country() == null ? "0" : brf206Row1TO472.getR93_country());
		}

		Cell row93cell2 = row93.getCell(3);

		if (row93cell2 != null) {
			row93cell2.setCellValue(brf206Row1TO472.getR93_government_resident() == null ? 0
					: brf206Row1TO472.getR93_government_resident().intValue());
		}

		Cell row93cell3 = row93.getCell(4);

		if (row93cell3 != null) {
			row93cell3.setCellValue(brf206Row1TO472.getR93_gre_resident() == null ? 0
					: brf206Row1TO472.getR93_gre_resident().intValue());
		}

		Cell row93cell4 = row93.getCell(5);

		if (row93cell4 != null) {
			row93cell4.setCellValue(brf206Row1TO472.getR93_private_resident() == null ? 0
					: brf206Row1TO472.getR93_private_resident().intValue());
		}

		Cell row93cell5 = row93.getCell(6);

		if (row93cell5 != null) {
			row93cell5.setCellValue(brf206Row1TO472.getR93_hni_resident() == null ? 0
					: brf206Row1TO472.getR93_hni_resident().intValue());
		}

		Cell row93cell6 = row93.getCell(7);

		if (row93cell6 != null) {
			row93cell6.setCellValue(brf206Row1TO472.getR93_individual_resident() == null ? 0
					: brf206Row1TO472.getR93_individual_resident().intValue());
		}

		Cell row93cell7 = row93.getCell(8);

		if (row93cell7 != null) {
			row93cell7.setCellValue(brf206Row1TO472.getR93_banking_resident() == null ? 0
					: brf206Row1TO472.getR93_banking_resident().intValue());
		}

		Cell row93cell8 = row93.getCell(9);

		if (row93cell8 != null) {
			row93cell8.setCellValue(brf206Row1TO472.getR93_trade_resident() == null ? 0
					: brf206Row1TO472.getR93_trade_resident().intValue());
		}

		Cell row93cell9 = row93.getCell(10);

		if (row93cell9 != null) {
			row93cell9.setCellValue(brf206Row1TO472.getR93_government_non_resident() == null ? 0
					: brf206Row1TO472.getR93_government_non_resident().intValue());
		}

		Cell row93cell10 = row93.getCell(11);

		if (row93cell10 != null) {
			row93cell10.setCellValue(brf206Row1TO472.getR93_gre_non_resident() == null ? 0
					: brf206Row1TO472.getR93_gre_non_resident().intValue());
		}

		Cell row93cell11 = row93.getCell(12);

		if (row93cell11 != null) {
			row93cell11.setCellValue(brf206Row1TO472.getR93_private_non_resident() == null ? 0
					: brf206Row1TO472.getR93_private_non_resident().intValue());
		}

		Cell row93cell12 = row93.getCell(13);

		if (row93cell12 != null) {
			row93cell12.setCellValue(brf206Row1TO472.getR93_hni_non_resident() == null ? 0
					: brf206Row1TO472.getR93_hni_non_resident().intValue());
		}

		Cell row93cell13 = row93.getCell(14);

		if (row93cell13 != null) {
			row93cell13.setCellValue(brf206Row1TO472.getR93_individual_non_resident() == null ? 0
					: brf206Row1TO472.getR93_individual_non_resident().intValue());
		}

		Cell row93cell14 = row93.getCell(15);

		if (row93cell14 != null) {
			row93cell14.setCellValue(brf206Row1TO472.getR93_banking_non_resident() == null ? 0
					: brf206Row1TO472.getR93_banking_non_resident().intValue());
		}

		Cell row93cell15 = row93.getCell(16);

		if (row93cell15 != null) {
			row93cell15.setCellValue(brf206Row1TO472.getR93_trade_non_resident() == null ? 0
					: brf206Row1TO472.getR93_trade_non_resident().intValue());
		}

		// ROW 94

		Row row94 = sheet.getRow(93);

		Cell row94cell1 = row94.getCell(2);

		if (row94cell1 != null) {
			row94cell1.setCellValue(brf206Row1TO472.getR94_country() == null ? "0" : brf206Row1TO472.getR94_country());
		}

		Cell row94cell2 = row94.getCell(3);

		if (row94cell2 != null) {
			row94cell2.setCellValue(brf206Row1TO472.getR94_government_resident() == null ? 0
					: brf206Row1TO472.getR94_government_resident().intValue());
		}

		Cell row94cell3 = row94.getCell(4);

		if (row94cell3 != null) {
			row94cell3.setCellValue(brf206Row1TO472.getR94_gre_resident() == null ? 0
					: brf206Row1TO472.getR94_gre_resident().intValue());
		}

		Cell row94cell4 = row94.getCell(5);

		if (row94cell4 != null) {
			row94cell4.setCellValue(brf206Row1TO472.getR94_private_resident() == null ? 0
					: brf206Row1TO472.getR94_private_resident().intValue());
		}

		Cell row94cell5 = row94.getCell(6);

		if (row94cell5 != null) {
			row94cell5.setCellValue(brf206Row1TO472.getR94_hni_resident() == null ? 0
					: brf206Row1TO472.getR94_hni_resident().intValue());
		}

		Cell row94cell6 = row94.getCell(7);

		if (row94cell6 != null) {
			row94cell6.setCellValue(brf206Row1TO472.getR94_individual_resident() == null ? 0
					: brf206Row1TO472.getR94_individual_resident().intValue());
		}

		Cell row94cell7 = row94.getCell(8);

		if (row94cell7 != null) {
			row94cell7.setCellValue(brf206Row1TO472.getR94_banking_resident() == null ? 0
					: brf206Row1TO472.getR94_banking_resident().intValue());
		}

		Cell row94cell8 = row94.getCell(9);

		if (row94cell8 != null) {
			row94cell8.setCellValue(brf206Row1TO472.getR94_trade_resident() == null ? 0
					: brf206Row1TO472.getR94_trade_resident().intValue());
		}

		Cell row94cell9 = row94.getCell(10);

		if (row94cell9 != null) {
			row94cell9.setCellValue(brf206Row1TO472.getR94_government_non_resident() == null ? 0
					: brf206Row1TO472.getR94_government_non_resident().intValue());
		}

		Cell row94cell10 = row94.getCell(11);

		if (row94cell10 != null) {
			row94cell10.setCellValue(brf206Row1TO472.getR94_gre_non_resident() == null ? 0
					: brf206Row1TO472.getR94_gre_non_resident().intValue());
		}

		Cell row94cell11 = row94.getCell(12);

		if (row94cell11 != null) {
			row94cell11.setCellValue(brf206Row1TO472.getR94_private_non_resident() == null ? 0
					: brf206Row1TO472.getR94_private_non_resident().intValue());
		}

		Cell row94cell12 = row94.getCell(13);

		if (row94cell12 != null) {
			row94cell12.setCellValue(brf206Row1TO472.getR94_hni_non_resident() == null ? 0
					: brf206Row1TO472.getR94_hni_non_resident().intValue());
		}

		Cell row94cell13 = row94.getCell(14);

		if (row94cell13 != null) {
			row94cell13.setCellValue(brf206Row1TO472.getR94_individual_non_resident() == null ? 0
					: brf206Row1TO472.getR94_individual_non_resident().intValue());
		}

		Cell row94cell14 = row94.getCell(15);

		if (row94cell14 != null) {
			row94cell14.setCellValue(brf206Row1TO472.getR94_banking_non_resident() == null ? 0
					: brf206Row1TO472.getR94_banking_non_resident().intValue());
		}

		Cell row94cell15 = row94.getCell(16);

		if (row94cell15 != null) {
			row94cell15.setCellValue(brf206Row1TO472.getR94_trade_non_resident() == null ? 0
					: brf206Row1TO472.getR94_trade_non_resident().intValue());
		}

		// ROW 95

		Row row95 = sheet.getRow(94);

		Cell row95cell1 = row95.getCell(2);

		if (row95cell1 != null) {
			row95cell1.setCellValue(brf206Row1TO472.getR95_country() == null ? "0" : brf206Row1TO472.getR95_country());
		}

		Cell row95cell2 = row95.getCell(3);

		if (row95cell2 != null) {
			row95cell2.setCellValue(brf206Row1TO472.getR95_government_resident() == null ? 0
					: brf206Row1TO472.getR95_government_resident().intValue());
		}

		Cell row95cell3 = row95.getCell(4);

		if (row95cell3 != null) {
			row95cell3.setCellValue(brf206Row1TO472.getR95_gre_resident() == null ? 0
					: brf206Row1TO472.getR95_gre_resident().intValue());
		}

		Cell row95cell4 = row95.getCell(5);

		if (row95cell4 != null) {
			row95cell4.setCellValue(brf206Row1TO472.getR95_private_resident() == null ? 0
					: brf206Row1TO472.getR95_private_resident().intValue());
		}

		Cell row95cell5 = row95.getCell(6);

		if (row95cell5 != null) {
			row95cell5.setCellValue(brf206Row1TO472.getR95_hni_resident() == null ? 0
					: brf206Row1TO472.getR95_hni_resident().intValue());
		}

		Cell row95cell6 = row95.getCell(7);

		if (row95cell6 != null) {
			row95cell6.setCellValue(brf206Row1TO472.getR95_individual_resident() == null ? 0
					: brf206Row1TO472.getR95_individual_resident().intValue());
		}

		Cell row95cell7 = row95.getCell(8);

		if (row95cell7 != null) {
			row95cell7.setCellValue(brf206Row1TO472.getR95_banking_resident() == null ? 0
					: brf206Row1TO472.getR95_banking_resident().intValue());
		}

		Cell row95cell8 = row95.getCell(9);

		if (row95cell8 != null) {
			row95cell8.setCellValue(brf206Row1TO472.getR95_trade_resident() == null ? 0
					: brf206Row1TO472.getR95_trade_resident().intValue());
		}

		Cell row95cell9 = row95.getCell(10);

		if (row95cell9 != null) {
			row95cell9.setCellValue(brf206Row1TO472.getR95_government_non_resident() == null ? 0
					: brf206Row1TO472.getR95_government_non_resident().intValue());
		}

		Cell row95cell10 = row95.getCell(11);

		if (row95cell10 != null) {
			row95cell10.setCellValue(brf206Row1TO472.getR95_gre_non_resident() == null ? 0
					: brf206Row1TO472.getR95_gre_non_resident().intValue());
		}

		Cell row95cell11 = row95.getCell(12);

		if (row95cell11 != null) {
			row95cell11.setCellValue(brf206Row1TO472.getR95_private_non_resident() == null ? 0
					: brf206Row1TO472.getR95_private_non_resident().intValue());
		}

		Cell row95cell12 = row95.getCell(13);

		if (row95cell12 != null) {
			row95cell12.setCellValue(brf206Row1TO472.getR95_hni_non_resident() == null ? 0
					: brf206Row1TO472.getR95_hni_non_resident().intValue());
		}

		Cell row95cell13 = row95.getCell(14);

		if (row95cell13 != null) {
			row95cell13.setCellValue(brf206Row1TO472.getR95_individual_non_resident() == null ? 0
					: brf206Row1TO472.getR95_individual_non_resident().intValue());
		}

		Cell row95cell14 = row95.getCell(15);

		if (row95cell14 != null) {
			row95cell14.setCellValue(brf206Row1TO472.getR95_banking_non_resident() == null ? 0
					: brf206Row1TO472.getR95_banking_non_resident().intValue());
		}

		Cell row95cell15 = row95.getCell(16);

		if (row95cell15 != null) {
			row95cell15.setCellValue(brf206Row1TO472.getR95_trade_non_resident() == null ? 0
					: brf206Row1TO472.getR95_trade_non_resident().intValue());
		}

		// ROW 96

		Row row96 = sheet.getRow(95);

		Cell row96cell1 = row96.getCell(2);

		if (row96cell1 != null) {
			row96cell1.setCellValue(brf206Row1TO472.getR96_country() == null ? "0" : brf206Row1TO472.getR96_country());
		}

		Cell row96cell2 = row96.getCell(3);

		if (row96cell2 != null) {
			row96cell2.setCellValue(brf206Row1TO472.getR96_government_resident() == null ? 0
					: brf206Row1TO472.getR96_government_resident().intValue());
		}

		Cell row96cell3 = row96.getCell(4);

		if (row96cell3 != null) {
			row96cell3.setCellValue(brf206Row1TO472.getR96_gre_resident() == null ? 0
					: brf206Row1TO472.getR96_gre_resident().intValue());
		}

		Cell row96cell4 = row96.getCell(5);

		if (row96cell4 != null) {
			row96cell4.setCellValue(brf206Row1TO472.getR96_private_resident() == null ? 0
					: brf206Row1TO472.getR96_private_resident().intValue());
		}

		Cell row96cell5 = row96.getCell(6);

		if (row96cell5 != null) {
			row96cell5.setCellValue(brf206Row1TO472.getR96_hni_resident() == null ? 0
					: brf206Row1TO472.getR96_hni_resident().intValue());
		}

		Cell row96cell6 = row96.getCell(7);

		if (row96cell6 != null) {
			row96cell6.setCellValue(brf206Row1TO472.getR96_individual_resident() == null ? 0
					: brf206Row1TO472.getR96_individual_resident().intValue());
		}

		Cell row96cell7 = row96.getCell(8);

		if (row96cell7 != null) {
			row96cell7.setCellValue(brf206Row1TO472.getR96_banking_resident() == null ? 0
					: brf206Row1TO472.getR96_banking_resident().intValue());
		}

		Cell row96cell8 = row96.getCell(9);

		if (row96cell8 != null) {
			row96cell8.setCellValue(brf206Row1TO472.getR96_trade_resident() == null ? 0
					: brf206Row1TO472.getR96_trade_resident().intValue());
		}

		Cell row96cell9 = row96.getCell(10);

		if (row96cell9 != null) {
			row96cell9.setCellValue(brf206Row1TO472.getR96_government_non_resident() == null ? 0
					: brf206Row1TO472.getR96_government_non_resident().intValue());
		}

		Cell row96cell10 = row96.getCell(11);

		if (row96cell10 != null) {
			row96cell10.setCellValue(brf206Row1TO472.getR96_gre_non_resident() == null ? 0
					: brf206Row1TO472.getR96_gre_non_resident().intValue());
		}

		Cell row96cell11 = row96.getCell(12);

		if (row96cell11 != null) {
			row96cell11.setCellValue(brf206Row1TO472.getR96_private_non_resident() == null ? 0
					: brf206Row1TO472.getR96_private_non_resident().intValue());
		}

		Cell row96cell12 = row96.getCell(13);

		if (row96cell12 != null) {
			row96cell12.setCellValue(brf206Row1TO472.getR96_hni_non_resident() == null ? 0
					: brf206Row1TO472.getR96_hni_non_resident().intValue());
		}

		Cell row96cell13 = row96.getCell(14);

		if (row96cell13 != null) {
			row96cell13.setCellValue(brf206Row1TO472.getR96_individual_non_resident() == null ? 0
					: brf206Row1TO472.getR96_individual_non_resident().intValue());
		}

		Cell row96cell14 = row96.getCell(15);

		if (row96cell14 != null) {
			row96cell14.setCellValue(brf206Row1TO472.getR96_banking_non_resident() == null ? 0
					: brf206Row1TO472.getR96_banking_non_resident().intValue());
		}

		Cell row96cell15 = row96.getCell(16);

		if (row96cell15 != null) {
			row96cell15.setCellValue(brf206Row1TO472.getR96_trade_non_resident() == null ? 0
					: brf206Row1TO472.getR96_trade_non_resident().intValue());
		}

		// ROW 98

		Row row98 = sheet.getRow(97);

		Cell row98cell1 = row98.getCell(2);

		if (row98cell1 != null) {
			row98cell1.setCellValue(brf206Row1TO472.getR98_country() == null ? "0" : brf206Row1TO472.getR98_country());
		}

		Cell row98cell2 = row98.getCell(3);

		if (row98cell2 != null) {
			row98cell2.setCellValue(brf206Row1TO472.getR98_government_resident() == null ? 0
					: brf206Row1TO472.getR98_government_resident().intValue());
		}

		Cell row98cell3 = row98.getCell(4);

		if (row98cell3 != null) {
			row98cell3.setCellValue(brf206Row1TO472.getR98_gre_resident() == null ? 0
					: brf206Row1TO472.getR98_gre_resident().intValue());
		}

		Cell row98cell4 = row98.getCell(5);

		if (row98cell4 != null) {
			row98cell4.setCellValue(brf206Row1TO472.getR98_private_resident() == null ? 0
					: brf206Row1TO472.getR98_private_resident().intValue());
		}

		Cell row98cell5 = row98.getCell(6);

		if (row98cell5 != null) {
			row98cell5.setCellValue(brf206Row1TO472.getR98_hni_resident() == null ? 0
					: brf206Row1TO472.getR98_hni_resident().intValue());
		}

		Cell row98cell6 = row98.getCell(7);

		if (row98cell6 != null) {
			row98cell6.setCellValue(brf206Row1TO472.getR98_individual_resident() == null ? 0
					: brf206Row1TO472.getR98_individual_resident().intValue());
		}

		Cell row98cell7 = row98.getCell(8);

		if (row98cell7 != null) {
			row98cell7.setCellValue(brf206Row1TO472.getR98_banking_resident() == null ? 0
					: brf206Row1TO472.getR98_banking_resident().intValue());
		}

		Cell row98cell8 = row98.getCell(9);

		if (row98cell8 != null) {
			row98cell8.setCellValue(brf206Row1TO472.getR98_trade_resident() == null ? 0
					: brf206Row1TO472.getR98_trade_resident().intValue());
		}

		Cell row98cell9 = row98.getCell(10);

		if (row98cell9 != null) {
			row98cell9.setCellValue(brf206Row1TO472.getR98_government_non_resident() == null ? 0
					: brf206Row1TO472.getR98_government_non_resident().intValue());
		}

		Cell row98cell10 = row98.getCell(11);

		if (row98cell10 != null) {
			row98cell10.setCellValue(brf206Row1TO472.getR98_gre_non_resident() == null ? 0
					: brf206Row1TO472.getR98_gre_non_resident().intValue());
		}

		Cell row98cell11 = row98.getCell(12);

		if (row98cell11 != null) {
			row98cell11.setCellValue(brf206Row1TO472.getR98_private_non_resident() == null ? 0
					: brf206Row1TO472.getR98_private_non_resident().intValue());
		}

		Cell row98cell12 = row98.getCell(13);

		if (row98cell12 != null) {
			row98cell12.setCellValue(brf206Row1TO472.getR98_hni_non_resident() == null ? 0
					: brf206Row1TO472.getR98_hni_non_resident().intValue());
		}

		Cell row98cell13 = row98.getCell(14);

		if (row98cell13 != null) {
			row98cell13.setCellValue(brf206Row1TO472.getR98_individual_non_resident() == null ? 0
					: brf206Row1TO472.getR98_individual_non_resident().intValue());
		}

		Cell row98cell14 = row98.getCell(15);

		if (row98cell14 != null) {
			row98cell14.setCellValue(brf206Row1TO472.getR98_banking_non_resident() == null ? 0
					: brf206Row1TO472.getR98_banking_non_resident().intValue());
		}

		Cell row98cell15 = row98.getCell(16);

		if (row98cell15 != null) {
			row98cell15.setCellValue(brf206Row1TO472.getR98_trade_non_resident() == null ? 0
					: brf206Row1TO472.getR98_trade_non_resident().intValue());
		}

		// ROW 99

		Row row99 = sheet.getRow(98);

		Cell row99cell1 = row99.getCell(2);

		if (row99cell1 != null) {
			row99cell1.setCellValue(brf206Row1TO472.getR99_country() == null ? "0" : brf206Row1TO472.getR99_country());
		}

		Cell row99cell2 = row99.getCell(3);

		if (row99cell2 != null) {
			row99cell2.setCellValue(brf206Row1TO472.getR99_government_resident() == null ? 0
					: brf206Row1TO472.getR99_government_resident().intValue());
		}

		Cell row99cell3 = row99.getCell(4);

		if (row99cell3 != null) {
			row99cell3.setCellValue(brf206Row1TO472.getR99_gre_resident() == null ? 0
					: brf206Row1TO472.getR99_gre_resident().intValue());
		}

		Cell row99cell4 = row99.getCell(5);

		if (row99cell4 != null) {
			row99cell4.setCellValue(brf206Row1TO472.getR99_private_resident() == null ? 0
					: brf206Row1TO472.getR99_private_resident().intValue());
		}

		Cell row99cell5 = row99.getCell(6);

		if (row99cell5 != null) {
			row99cell5.setCellValue(brf206Row1TO472.getR99_hni_resident() == null ? 0
					: brf206Row1TO472.getR99_hni_resident().intValue());
		}

		Cell row99cell6 = row99.getCell(7);

		if (row99cell6 != null) {
			row99cell6.setCellValue(brf206Row1TO472.getR99_individual_resident() == null ? 0
					: brf206Row1TO472.getR99_individual_resident().intValue());
		}

		Cell row99cell7 = row99.getCell(8);

		if (row99cell7 != null) {
			row99cell7.setCellValue(brf206Row1TO472.getR99_banking_resident() == null ? 0
					: brf206Row1TO472.getR99_banking_resident().intValue());
		}

		Cell row99cell8 = row99.getCell(9);

		if (row99cell8 != null) {
			row99cell8.setCellValue(brf206Row1TO472.getR99_trade_resident() == null ? 0
					: brf206Row1TO472.getR99_trade_resident().intValue());
		}

		Cell row99cell9 = row99.getCell(10);

		if (row99cell9 != null) {
			row99cell9.setCellValue(brf206Row1TO472.getR99_government_non_resident() == null ? 0
					: brf206Row1TO472.getR99_government_non_resident().intValue());
		}

		Cell row99cell10 = row99.getCell(11);

		if (row99cell10 != null) {
			row99cell10.setCellValue(brf206Row1TO472.getR99_gre_non_resident() == null ? 0
					: brf206Row1TO472.getR99_gre_non_resident().intValue());
		}

		Cell row99cell11 = row99.getCell(12);

		if (row99cell11 != null) {
			row99cell11.setCellValue(brf206Row1TO472.getR99_private_non_resident() == null ? 0
					: brf206Row1TO472.getR99_private_non_resident().intValue());
		}

		Cell row99cell12 = row99.getCell(13);

		if (row99cell12 != null) {
			row99cell12.setCellValue(brf206Row1TO472.getR99_hni_non_resident() == null ? 0
					: brf206Row1TO472.getR99_hni_non_resident().intValue());
		}

		Cell row99cell13 = row99.getCell(14);

		if (row99cell13 != null) {
			row99cell13.setCellValue(brf206Row1TO472.getR99_individual_non_resident() == null ? 0
					: brf206Row1TO472.getR99_individual_non_resident().intValue());
		}

		Cell row99cell14 = row99.getCell(15);

		if (row99cell14 != null) {
			row99cell14.setCellValue(brf206Row1TO472.getR99_banking_non_resident() == null ? 0
					: brf206Row1TO472.getR99_banking_non_resident().intValue());
		}

		Cell row99cell15 = row99.getCell(16);

		if (row99cell15 != null) {
			row99cell15.setCellValue(brf206Row1TO472.getR99_trade_non_resident() == null ? 0
					: brf206Row1TO472.getR99_trade_non_resident().intValue());
		}

		// ROW 101

		Row row101 = sheet.getRow(100);

		Cell row101cell1 = row101.getCell(2);

		if (row101cell1 != null) {
			row101cell1
					.setCellValue(brf206Row1TO472.getR101_country() == null ? "0" : brf206Row1TO472.getR101_country());
		}

		Cell row101cell2 = row101.getCell(3);

		if (row101cell2 != null) {
			row101cell2.setCellValue(brf206Row1TO472.getR101_government_resident() == null ? 0
					: brf206Row1TO472.getR101_government_resident().intValue());
		}

		Cell row101cell3 = row101.getCell(4);

		if (row101cell3 != null) {
			row101cell3.setCellValue(brf206Row1TO472.getR101_gre_resident() == null ? 0
					: brf206Row1TO472.getR101_gre_resident().intValue());
		}

		Cell row101cell4 = row101.getCell(5);

		if (row101cell4 != null) {
			row101cell4.setCellValue(brf206Row1TO472.getR101_private_resident() == null ? 0
					: brf206Row1TO472.getR101_private_resident().intValue());
		}

		Cell row101cell5 = row101.getCell(6);

		if (row101cell5 != null) {
			row101cell5.setCellValue(brf206Row1TO472.getR101_hni_resident() == null ? 0
					: brf206Row1TO472.getR101_hni_resident().intValue());
		}

		Cell row101cell6 = row101.getCell(7);

		if (row101cell6 != null) {
			row101cell6.setCellValue(brf206Row1TO472.getR101_individual_resident() == null ? 0
					: brf206Row1TO472.getR101_individual_resident().intValue());
		}

		Cell row101cell7 = row101.getCell(8);

		if (row101cell7 != null) {
			row101cell7.setCellValue(brf206Row1TO472.getR101_banking_resident() == null ? 0
					: brf206Row1TO472.getR101_banking_resident().intValue());
		}

		Cell row101cell8 = row101.getCell(9);

		if (row101cell8 != null) {
			row101cell8.setCellValue(brf206Row1TO472.getR101_trade_resident() == null ? 0
					: brf206Row1TO472.getR101_trade_resident().intValue());
		}

		Cell row101cell9 = row101.getCell(10);

		if (row101cell9 != null) {
			row101cell9.setCellValue(brf206Row1TO472.getR101_government_non_resident() == null ? 0
					: brf206Row1TO472.getR101_government_non_resident().intValue());
		}

		Cell row101cell10 = row101.getCell(11);

		if (row101cell10 != null) {
			row101cell10.setCellValue(brf206Row1TO472.getR101_gre_non_resident() == null ? 0
					: brf206Row1TO472.getR101_gre_non_resident().intValue());
		}

		Cell row101cell11 = row101.getCell(12);

		if (row101cell11 != null) {
			row101cell11.setCellValue(brf206Row1TO472.getR101_private_non_resident() == null ? 0
					: brf206Row1TO472.getR101_private_non_resident().intValue());
		}

		Cell row101cell12 = row101.getCell(13);

		if (row101cell12 != null) {
			row101cell12.setCellValue(brf206Row1TO472.getR101_hni_non_resident() == null ? 0
					: brf206Row1TO472.getR101_hni_non_resident().intValue());
		}

		Cell row101cell13 = row101.getCell(14);

		if (row101cell13 != null) {
			row101cell13.setCellValue(brf206Row1TO472.getR101_individual_non_resident() == null ? 0
					: brf206Row1TO472.getR101_individual_non_resident().intValue());
		}

		Cell row101cell14 = row101.getCell(15);

		if (row101cell14 != null) {
			row101cell14.setCellValue(brf206Row1TO472.getR101_banking_non_resident() == null ? 0
					: brf206Row1TO472.getR101_banking_non_resident().intValue());
		}

		Cell row101cell15 = row101.getCell(16);

		if (row101cell15 != null) {
			row101cell15.setCellValue(brf206Row1TO472.getR101_trade_non_resident() == null ? 0
					: brf206Row1TO472.getR101_trade_non_resident().intValue());
		}
	}

}
