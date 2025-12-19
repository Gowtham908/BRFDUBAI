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

import com.bornfire.xbrl.entities.BRF35_ARCHIV_ENTITY;

import com.bornfire.xbrl.entities.BRBS.BRF35_DETAIL_ENTITY;

import com.bornfire.xbrl.entities.BRBS.BRF35_DetaiRep;
import com.bornfire.xbrl.entities.BRBS.BRF35_ENTITY_REP;
import com.bornfire.xbrl.entities.BRBS.BRF35_ENTITY;
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
public class BRF35ReportService {
	private static final Logger logger = LoggerFactory.getLogger(BRF35ReportService.class);

	@Autowired
	SessionFactory sessionFactory;

	@Autowired
	DataSource srcdataSource;

	@Autowired
	Environment env;

	@Autowired
	BRF35_DetaiRep BRF35_DetaiRep;

	@Autowired
	BRF35_ENTITY_REP BRF35_ENTITY1REP;

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
			//dt1 = new SimpleDateFormat("dd/MM/yyyy").parse(fromdate);
			dt9 = new SimpleDateFormat("dd/MM/yyyy").parse(todate);
			logger.info("Getting No of records in Master table :" + reportid);
			Long dtlcnt = (Long) hs.createQuery("select count(*) from BRF35_ENTITY a where a.report_date=?1")
					.setParameter(1, dt9).getSingleResult();

			if (dtlcnt > 0) {
				logger.info("Getting No of records in Mod table :" + reportid);
				Long modcnt = (Long) hs.createQuery("select count(*) from BRF35_ENTITY a").getSingleResult();
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

	public ModelAndView getBRF035View(String reportId, String fromdate, String todate, String currency, String dtltype,
			Pageable pageable) {

		ModelAndView mv = new ModelAndView();
		Session hs = sessionFactory.getCurrentSession();
		int pageSize = pageable.getPageSize();
		int currentPage = pageable.getPageNumber();
		int startItem = currentPage * pageSize;
		List<BRF35_ENTITY> T1rep = new ArrayList<BRF35_ENTITY>();
		// Query<Object[]> qr;

		List<BRF35_ENTITY> T1Master = new ArrayList<BRF35_ENTITY>();
		/* List<BRF73_TABLE2> T1Master1 = new ArrayList<BRF73_TABLE2>(); */

		logger.info("Inside archive" + currency);

		try {
			Date d1 = df.parse(todate);
			// T1rep = t1CurProdServiceRepo.getT1CurProdServices(d1);

			// T1Master = hs.createQuery("from BRF35_ENTITY a where a.report_date = ?1 ",
			// BRF35_ENTITY.class)
			// .setParameter(1, df.parse(todate)).getResultList();

			/*
			 * T1Master1 = hs.createQuery("from BRF73_TABLE2 a where a.report_date = ?1 ",
			 * BRF73_TABLE2.class) .setParameter(1, df.parse(todate)).getResultList();
			 */
			List<Object[]> T1Master1 = BRF35_ENTITY1REP.findllvalues(todate);

			for (Object[] BRF35_ENTITY : T1Master1) {

				BRF35_ENTITY BRF35 = new BRF35_ENTITY();
				System.out.println(BRF35_ENTITY[0]);
				BRF35.setCountry_party(String.valueOf(BRF35_ENTITY[0]));
				BRF35.setBranch(String.valueOf(BRF35_ENTITY[1]));
				BRF35.setHead_office(String.valueOf(BRF35_ENTITY[2]));

				BigDecimal duefrmp = BRF35_ENTITY[3] != null ? (BigDecimal) BRF35_ENTITY[3] : new BigDecimal("0");
				BRF35.setDue_from_placements(duefrmp);
				BigDecimal setDue_to_borrowing = BRF35_ENTITY[4] != null ? (BigDecimal) BRF35_ENTITY[4]
						: new BigDecimal("0");
				BRF35.setDue_to_borrowing(setDue_to_borrowing);
				BigDecimal setDue_from_remaining = BRF35_ENTITY[5] != null ? (BigDecimal) BRF35_ENTITY[5]
						: new BigDecimal("0");
				BRF35.setDue_from_remaining(setDue_from_remaining);
				BigDecimal setDue_to_bremaining = BRF35_ENTITY[6] != null ? (BigDecimal) BRF35_ENTITY[6]
						: new BigDecimal("0");
				BRF35.setDue_to_bremaining(setDue_to_bremaining);
				/*
				 * BigDecimal setDue_to_bremaining = BRF35_ENTITY[3] != null ? (BigDecimal)
				 * BRF35_ENTITY[6] : new BigDecimal("0");
				 * BRF35.setDue_to_bremaining(setDue_to_bremaining);
				 */
				T1Master.add(BRF35);

			}
		} catch (ParseException e) {
			e.printStackTrace();
		}

		// T1rep = t1CurProdServiceRepo.getT1CurProdServices(d1);

		mv.setViewName("RR/BRF35");
		// mv.addObject("currlist", refCodeConfig.currList());
		mv.addObject("reportsummary", T1Master);
		mv.addObject("getduefrmplace", BRF35_ENTITY1REP.getduefrmplace(todate));
		mv.addObject("getduetobrorow", BRF35_ENTITY1REP.getduetobrorow(todate));
		mv.addObject("getduefrmremain", BRF35_ENTITY1REP.getduefrmremain(todate));
		mv.addObject("getduetoremain", BRF35_ENTITY1REP.getduetoremain(todate));

		/* mv.addObject("reportsummary1", T1Master1); */
		mv.addObject("reportmaster", T1Master);
		mv.addObject("displaymode", "summary");
		mv.addObject("reportsflag", "reportsflag");
		mv.addObject("menu", reportId);
		System.out.println("scv" + mv.getViewName());

		return mv;

	}

	public ModelAndView getBRF035currentDtl(String reportId, String fromdate, String todate, String currency,
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
						"select * from BRF35_DETAILTABLE  a where report_date = ?1 and report_lable =?2");

				qr.setParameter(2, filter);

			} else {
				qr = hs.createNativeQuery("select * from BRF35_DETAILTABLE a where report_date = ?1");

			}
		} else {
			qr = hs.createNativeQuery("select * from BRF35_DETAILTABLE  where report_date = ?1");
		}

		try {
			qr.setParameter(1, df.parse(todate));

		} catch (ParseException e) {
			e.printStackTrace();
		}
		List<BRF35_DETAIL_ENTITY> T1Master = new ArrayList<BRF35_DETAIL_ENTITY>();

		try {
			T1Master = hs.createQuery("from BRF35_DETAIL_ENTITY a where a.report_date = ?1", BRF35_DETAIL_ENTITY.class)
					.setParameter(1, df.parse(todate)).getResultList();
		} catch (ParseException e) {

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

			BRF35_DETAIL_ENTITY py = new BRF35_DETAIL_ENTITY(cust_id, foracid, acct_name, eab_lc, act_balance_amt_lc,
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

		mv.setViewName("RR" + "/" + "BRF35::reportcontent");
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
		fileName = "011-BRF-035-A";

		if (!filetype.equals("xbrl")) {

			if (!filetype.equals("BRF")) {

				try {
					InputStream jasperFile;
					logger.info("Getting Jasper file :" + reportId);
					if (filetype.equals("detailexcel")) {
						if (dtltype.equals("report")) {

							jasperFile = this.getClass().getResourceAsStream("/static/jasper/BRF35_DETAIL.jrxml");
						} else {
							jasperFile = this.getClass().getResourceAsStream("/static/jasper/BRF35_DETAIL.jrxml ");
						}

					} else {
						if (dtltype.equals("report")) {
							logger.info("Inside report");
							jasperFile = this.getClass().getResourceAsStream("/static/jasper/BRF35A.jrxml");
						} else {
							jasperFile = this.getClass().getResourceAsStream("/static/jasper/BRF35A.jrxml");
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
				List<BRF35_ENTITY> T1Master = new ArrayList<>();
				Session hs = sessionFactory.getCurrentSession();
				try {
					Date d1 = df.parse(todate);

					// Retrieve data
					List<Object[]> T1Master1 = BRF35_ENTITY1REP.findllvalues(todate);

					File responseFile = new File(env.getProperty("output.exportpathtemp") + "011-BRF-035-AT.xls");

					// Load the Excel file
					Workbook workbook = WorkbookFactory.create(responseFile);
					Sheet sheet = workbook.getSheetAt(0);
					
					
					int rowCount = sheet.getPhysicalNumberOfRows();
					
					System.out.println("Rows in Excel Sheet : "+rowCount);

					if (!T1Master1.isEmpty()) {
						int startRow = 10; // Starting row index
						System.out.println("T1Master size: " + T1Master1.size());

						for (int index = 0; index < T1Master1.size(); index++) {
							Object[] brf47 = T1Master1.get(index);
							Row row = sheet.getRow(startRow + index);
							if (row == null) {
								row = sheet.createRow(startRow + index);
							}

							// Country Party
							Cell cell2 = row.getCell(2);
							if (cell2 == null) {
								cell2 = row.createCell(2);
							}
							cell2.setCellValue(brf47[0] == null ? "" : brf47[0].toString());

							// Country Branch
							Cell cell3 = row.getCell(3);
							if (cell3 == null) {
								cell3 = row.createCell(3);
							}
							
							cell3.setCellValue(brf47[1] == null ? "" : brf47[1].toString());

							// Head Office
							Cell cell4 = row.getCell(4);
							if (cell4 == null) {
								cell4 = row.createCell(4);
							}
							cell4.setCellValue(brf47[2] == null ? "" : brf47[2].toString());

							// Due From placements
							Cell cell5 = row.getCell(5);
							if (cell5 == null) {
								cell5 = row.createCell(5);
							}
							
							cell5.setCellValue(brf47[3] == null ? 0 : ((BigDecimal) brf47[3]).intValue());

							// Due to borrowings
							Cell cell6 = row.getCell(6);
							if (cell6 == null) {
								cell6 = row.createCell(6);
							}
							
							cell6.setCellValue(brf47[4] == null ? 0 : ((BigDecimal) brf47[4]).intValue());

							// Due from remaining
							Cell cell7 = row.getCell(7);
							if (cell7 == null) {
								cell7 = row.createCell(7);
							}
							cell7.setCellValue(brf47[5] == null ? 0 : ((BigDecimal) brf47[5]).intValue());

							// Due to remaining
							Cell cell8 = row.getCell(8);
							if (cell8 == null) {
								cell8 = row.createCell(8);
							}
							cell8.setCellValue(brf47[6] == null ? 0 : ((BigDecimal) brf47[6]).intValue());
						}

						// Save the changes
						workbook.getCreationHelper().createFormulaEvaluator().evaluateAll();

						try (FileOutputStream fileOut = new FileOutputStream(
								env.getProperty("output.exportpathfinal") + "011-BRF-035-A.xls")) {
							workbook.write(fileOut);
							System.out.println("File saved successfully at: "
									+ env.getProperty("output.exportpathfinal") + "011-BRF-035-A.xls");
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
		outputFile = new File(env.getProperty("output.exportpathfinal") + "011-BRF-035-A.xls");

		return outputFile;
	}

	public String detailChanges35(BRF35_DETAIL_ENTITY detail, String report_name_1, String report_label_1,
			BigDecimal act_balance_amt_lc, String foracid, String report_addl_criteria_1) {

		String msg = "";

		try {

			Session hs = sessionFactory.getCurrentSession();
			Optional<BRF35_DETAIL_ENTITY> Brf35detail = BRF35_DetaiRep.findById(foracid);

			if (Brf35detail.isPresent()) {
				BRF35_DETAIL_ENTITY BRFdetail = Brf35detail.get();

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

					BRF35_DetaiRep.save(BRFdetail);

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

	// TO show thw Archieve values
	public ModelAndView getArchieveBRF035View(String reportId, String fromdate, String todate, String currency,
			String dtltype, Pageable pageable) {

		ModelAndView mv = new ModelAndView();
		Session hs = sessionFactory.getCurrentSession();
		int pageSize = pageable.getPageSize();
		int currentPage = pageable.getPageNumber();
		int startItem = currentPage * pageSize;
		List<BRF35_ENTITY> T1rep = new ArrayList<BRF35_ENTITY>();
		// Query<Object[]> qr;

		List<BRF35_ENTITY> T1Master = new ArrayList<BRF35_ENTITY>();
		/* List<BRF73_TABLE2> T1Master1 = new ArrayList<BRF73_TABLE2>(); */

		logger.info("Inside archive" + currency);

		try {
			Date d1 = df.parse(todate);
			// T1rep = t1CurProdServiceRepo.getT1CurProdServices(d1);

			// T1Master = hs.createQuery("from BRF35_ENTITY1 a where a.report_date = ?1 ",
			// BRF35_ENTITY1.class)
			// .setParameter(1, df.parse(todate)).getResultList();

			/*
			 * T1Master1 = hs.createQuery("from BRF73_TABLE2 a where a.report_date = ?1 ",
			 * BRF73_TABLE2.class) .setParameter(1, df.parse(todate)).getResultList();
			 */
			List<Object[]> T1Master1 = BRF35_ENTITY1REP.findllvalues(todate);

			for (Object[] BRF35_ENTITY : T1Master1) {

				BRF35_ENTITY BRF35 = new BRF35_ENTITY();
				System.out.println(BRF35_ENTITY[0]);
				BRF35.setCountry_party(String.valueOf(BRF35_ENTITY[0]));
				BRF35.setBranch(String.valueOf(BRF35_ENTITY[1]));
				BRF35.setHead_office(String.valueOf(BRF35_ENTITY[2]));

				BigDecimal duefrmp = BRF35_ENTITY[3] != null ? (BigDecimal) BRF35_ENTITY[3] : new BigDecimal("0");
				BRF35.setDue_from_placements(duefrmp);
				BigDecimal setDue_to_borrowing = BRF35_ENTITY[4] != null ? (BigDecimal) BRF35_ENTITY[4]
						: new BigDecimal("0");
				BRF35.setDue_to_borrowing(setDue_to_borrowing);
				BigDecimal setDue_from_remaining = BRF35_ENTITY[5] != null ? (BigDecimal) BRF35_ENTITY[5]
						: new BigDecimal("0");
				BRF35.setDue_from_remaining(setDue_from_remaining);
				BigDecimal setDue_to_bremaining = BRF35_ENTITY[6] != null ? (BigDecimal) BRF35_ENTITY[6]
						: new BigDecimal("0");
				BRF35.setDue_to_bremaining(setDue_to_bremaining);
				/*
				 * BigDecimal setDue_to_bremaining = BRF35_ENTITY1[3] != null ? (BigDecimal)
				 * BRF35_ENTITY1[6] : new BigDecimal("0");
				 * BRF35.setDue_to_bremaining(setDue_to_bremaining);
				 */
				T1Master.add(BRF35);

			}
		} catch (ParseException e) {
			e.printStackTrace();
		}

		// T1rep = t1CurProdServiceRepo.getT1CurProdServices(d1);

		mv.setViewName("RR/BRF35ARCH");
		// mv.addObject("currlist", refCodeConfig.currList());
		mv.addObject("reportsummary", T1Master);
		mv.addObject("getduefrmplace", BRF35_ENTITY1REP.getduefrmplace(todate));
		mv.addObject("getduetobrorow", BRF35_ENTITY1REP.getduetobrorow(todate));
		mv.addObject("getduefrmremain", BRF35_ENTITY1REP.getduefrmremain(todate));
		mv.addObject("getduetoremain", BRF35_ENTITY1REP.getduetoremain(todate));

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

	public ModelAndView ARCHgetBRF035currentDtl(String reportId, String fromdate, String todate, String currency,
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
						"select * from BRF35_ARCHIVETABLE  a where report_date = ?1 and report_lable =?2");

				qr.setParameter(2, filter);

			} else {
				qr = hs.createNativeQuery("select * from BRF35_ARCHIVETABLE a where report_date = ?1");

			}
		} else {
			qr = hs.createNativeQuery("select * from BRF35_ARCHIVETABLE  where report_date = ?1");
		}

		try {
			qr.setParameter(1, df.parse(todate));

		} catch (ParseException e) {
			e.printStackTrace();
		}
		List<BRF35_ARCHIV_ENTITY> T1Master = new ArrayList<BRF35_ARCHIV_ENTITY>();

		try {
			T1Master = hs.createQuery("from BRF35_ARCHIV_ENTITY a where a.report_date = ?1", BRF35_ARCHIV_ENTITY.class)
					.setParameter(1, df.parse(todate)).getResultList();
		} catch (ParseException e) {

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

			BRF35_ARCHIV_ENTITY py = new BRF35_ARCHIV_ENTITY(cust_id, foracid, acct_name, eab_lc, act_balance_amt_lc,
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

		mv.setViewName("RR" + "/" + "BRF35ARCH::reportcontent");
		mv.addObject("reportdetails", T1Dt1Page.getContent());
		mv.addObject("reportmaster", T1Master);
		mv.addObject("reportmaster12", T1Dt1);
		mv.addObject("reportmaster1", qr);
		mv.addObject("singledetail", new T1CurProdDetail());
		mv.addObject("reportsflag", "reportsflag");
		mv.addObject("menu", reportId);
		return mv;
	}

}
