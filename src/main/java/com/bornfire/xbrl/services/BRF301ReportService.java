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
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.core.env.Environment;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.ModelAndView;

import com.bornfire.xbrl.config.SequenceGenerator;
import com.bornfire.xbrl.entities.UserProfile;
import com.bornfire.xbrl.entities.UserProfileRep;
import com.bornfire.xbrl.entities.BRBS.BRF301_entity;
import com.bornfire.xbrl.entities.BRBS.BRF301_entity_repo;
import com.bornfire.xbrl.entities.BRBS.MANUAL_Service_Entity;
import com.bornfire.xbrl.entities.BRBS.MANUAL_Service_Rep;
import com.bornfire.xbrl.entities.BRBS.ReportBRF301Data;

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
public class BRF301ReportService {
	private static final Logger logger = LoggerFactory.getLogger(BRF301ReportService.class);

	@Autowired
	SessionFactory sessionFactory;

	@Autowired
	DataSource srcdataSource;

	@Autowired
	Environment env;

	@Autowired
	BRF301_entity_repo brf301_entity_repo;

	@Autowired
	MANUAL_Service_Rep mANUAL_Service_Rep;

	@Autowired
	SequenceGenerator sequence;

	@Autowired
	UserProfileRep userProfileRep;

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
			Long dtlcnt = (Long) hs.createQuery("select count(*) from BRF301_entity a where a.report_date=?1")
					.setParameter(1, dt9).getSingleResult();

			if (dtlcnt > 0) {
				logger.info("Getting No of records in Mod table :" + reportid);
				Long modcnt = (Long) hs.createQuery("select count(*) from BRF301_entity a").getSingleResult();
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

	public ModelAndView getBRF301View(String reportId, String fromdate, String todate, String currency, String dtltype,
			Pageable pageable) {
		ModelAndView mv = new ModelAndView();
		Session hs = sessionFactory.getCurrentSession();

		logger.info("Inside archive: " + currency);

		try {
			// Fetching data from BRF301_SUMMARYTABLE
			List<BRF301_entity> T1Master = hs
					.createNativeQuery("SELECT * FROM BRF301_SUMMARYTABLE a WHERE a.report_date = ?1 ORDER BY r1_s_no",
							BRF301_entity.class)
					.setParameter(1, df.parse(todate)).getResultList();

			// Fetching data from XBRL_USER_PROFILE_TABLE
			List<UserProfile> T2Master = hs
					.createNativeQuery("SELECT * FROM XBRL_USER_PROFILE_TABLE", UserProfile.class).getResultList();

			// Logging size for debugging
			System.out.println("The size is: " + T1Master.size());

			// Setting view and attributes
			mv.setViewName("RR/BRF301");
			mv.addObject("modify_flg", T1Master.size() > 0 ? T1Master.get(0).getModify_flg() : null);
			mv.addObject("modify_user", T1Master.size() > 0 ? T1Master.get(0).getModify_user() : null);
			mv.addObject("list", T1Master);
			mv.addObject("list1", T2Master);
			mv.addObject("userid", T2Master.size() > 0 ? T2Master.get(0).getUserid() : null);
			mv.addObject("role_id", T2Master.size() > 0 ? T2Master.get(0).getRole_id() : null);
			mv.addObject("displaymode", "summary");
			mv.addObject("reportsflag", "reportsflag");
			mv.addObject("menu", reportId);
		} catch (Exception e) {
			logger.error("Error while fetching data for BRF301: ", e);
			mv.setViewName("error");
			mv.addObject("message", "An error occurred while processing the request.");
		}

		return mv;
	}

	public File getFileBRF301(String reportId, String fromdate, String todate, String currency, String dtltype,
			String filetype) throws FileNotFoundException, JRException, SQLException {

		System.out.println("inside the path");

		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

		String path = this.env.getProperty("output.exportpath");
		String fileName = "";
		String zipFileName = "";
		File outputFile;

		logger.info("Getting Output file :" + reportId);
		fileName = "011-BRF-301-A";
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

							jasperFile = this.getClass()
									.getResourceAsStream("/static/jasper/BOB_RBS_AML_CONS/RBS_DETAILS/T1Detail.jasper");
						} else {
							jasperFile = this.getClass().getResourceAsStream("/static/jasper/BRF_301_AA.jrxml");
						}

					} else {
						if (dtltype.equals("report")) {
							logger.info("Inside report");
							jasperFile = this.getClass().getResourceAsStream("/static/jasper/BRF301.jrxml");
						} else {
							jasperFile = this.getClass().getResourceAsStream("/static/jasper/BRF301.jrxml");
						}
					}

					// JasperReport jr = (JasperReport) JRLoader.loadObject(jasperFile);
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
				List<BRF301_entity> T1Master = new ArrayList<>();
				Session hs = sessionFactory.getCurrentSession();
				try {
					Date d1 = df.parse(todate);

					// Retrieve data
					List<Object[]> T1Master1 = brf301_entity_repo.findllvalues(todate);

					File responseFile = new File(env.getProperty("output.exportpathtemp") + "011-BRF-301-AT.xls");

					// Load the Excel file
					Workbook workbook = WorkbookFactory.create(responseFile);
					Sheet sheet = workbook.getSheetAt(0);

					if (!T1Master1.isEmpty()) {
						int startRow = 7; // Starting row index
						System.out.println("T1Master size: " + T1Master.size());

						for (int index = 0; index < T1Master1.size(); index++) {
							Object[] brf301 = T1Master1.get(index);
							Row row = sheet.getRow(startRow + index);
							if (row == null) {
								row = sheet.createRow(startRow + index);
							}

							////////// c1////////////

							Cell cell1 = row.getCell(2);
							if (cell1 == null) {
								cell1 = row.createCell(2);
							}
							String value1 = (brf301[1] == null) ? "0" : brf301[1].toString();
							cell1.setCellValue(value1);

							////////// c3////////////

							Cell cell3 = row.getCell(4);
							if (cell3 == null) {
								cell3 = row.createCell(4);
							}
							String value3 = (brf301[3] == null) ? "0" : brf301[3].toString();
							cell3.setCellValue(value3);

							////////// c6////////////

							Cell cell6 = row.getCell(7);
							if (cell6 == null) {
								cell6 = row.createCell(7);
							}
							String value6 = (brf301[6] == null) ? "0" : brf301[6].toString();
							cell6.setCellValue(value6);

							////////// c5////////////

							Cell cell5 = row.getCell(6);
							if (cell5 == null) {
								cell5 = row.createCell(6);
							}
							String value5 = (brf301[5] == null) ? "0" : brf301[5].toString();
							cell5.setCellValue(value5);

							////////// c4////////////

							Cell cell4 = row.getCell(5);
							if (cell4 == null) {
								cell4 = row.createCell(5);
							}
							String value4 = (brf301[4] == null) ? "0" : brf301[4].toString();
							cell4.setCellValue(value4);

							////////// c9////////////

							Cell cell9 = row.getCell(10);
							if (cell9 == null) {
								cell9 = row.createCell(10);
							}
							String value9 = (brf301[9] == null) ? "0" : brf301[9].toString();
							cell9.setCellValue(value9);

							////////// c8////////////

							Cell cell8 = row.getCell(9);
							if (cell8 == null) {
								cell8 = row.createCell(9);
							}
							String value8 = (brf301[8] == null) ? "0" : brf301[8].toString();
							cell8.setCellValue(value8);

							////////// c2////////////

							Cell cell2 = row.getCell(3);
							if (cell2 == null) {
								cell2 = row.createCell(3);
							}
							String value2 = (brf301[2] == null) ? "0" : brf301[2].toString();
							cell2.setCellValue(value2);

							////////// c12////////////

							Cell cell12 = row.getCell(13);
							if (cell12 == null) {
								cell12 = row.createCell(13);
							}
							String value12 = (brf301[12] == null) ? "0" : brf301[12].toString();
							cell12.setCellValue(value12);

							////////// c7////////////

							Cell cell7 = row.getCell(8);
							if (cell7 == null) {
								cell7 = row.createCell(8);
							}
							String value7 = (brf301[7] == null) ? "0" : brf301[7].toString();
							cell7.setCellValue(value7);

							////////// c11////////////

							Cell cell11 = row.getCell(12);
							if (cell11 == null) {
								cell11 = row.createCell(12);
							}
							String value11 = (brf301[11] == null) ? "0" : brf301[11].toString();
							cell11.setCellValue(value11);

							////////// c14////////////

							Cell cell14 = row.getCell(15);
							if (cell14 == null) {
								cell14 = row.createCell(15);
							}
							String value14 = (brf301[14] == null) ? "0" : brf301[14].toString();
							cell14.setCellValue(value14);

							////////// c10////////////

							Cell cell10 = row.getCell(11);
							if (cell10 == null) {
								cell10 = row.createCell(11);
							}
							String value10 = (brf301[10] == null) ? "0" : brf301[10].toString();
							cell10.setCellValue(value10);

							////////// c16////////////

							Cell cell16 = row.getCell(17);
							if (cell16 == null) {
								cell16 = row.createCell(17);
							}
							String value16 = (brf301[16] == null) ? "0" : brf301[16].toString();
							cell16.setCellValue(value16);

							////////// c15////////////

							Cell cell15 = row.getCell(16);
							if (cell15 == null) {
								cell15 = row.createCell(16);
							}
							String value15 = (brf301[15] == null) ? "0" : brf301[15].toString();
							cell15.setCellValue(value15);

							////////// c13////////////

							Cell cell13 = row.getCell(14);
							if (cell13 == null) {
								cell13 = row.createCell(14);
							}
							String value13 = (brf301[13] == null) ? "0" : brf301[13].toString();
							cell13.setCellValue(value13);

							////////// c17////////////

							Cell cell17 = row.getCell(18);
							if (cell17 == null) {
								cell17 = row.createCell(18);
							}
							String value17 = (brf301[17] == null) ? "0" : brf301[17].toString();
							cell17.setCellValue(value17);

							////////// c18////////////

//							Cell cell18 = row.getCell(19);
//							if (cell18 == null) {
//								cell18 = row.createCell(19);
//							}
//							String value18 = (brf301[18] == null) ? "0" : brf301[18].toString();
//							cell18.setCellValue(value18);
							Cell cell18 = row.getCell(19);
							if (cell18 == null) {
								cell18 = row.createCell(19);
							}
							cell18.setCellValue(brf301[18] == null ? 0 : ((BigDecimal) brf301[18]).intValue());

							////////// c21////////////

							Cell cell21 = row.getCell(22);
							if (cell21 == null) {
								cell21 = row.createCell(22);
							}
							String value21 = (brf301[21] == null) ? "0" : brf301[21].toString();
							cell21.setCellValue(value21);

							////////// c20////////////

							Cell cell20 = row.getCell(21);
							if (cell20 == null) {
								cell20 = row.createCell(21);
							}
							String value20 = (brf301[20] == null) ? "0" : brf301[20].toString();
							cell20.setCellValue(value20);

							////////// c23////////////

							Cell cell23 = row.getCell(24);
							if (cell23 == null) {
								cell23 = row.createCell(24);
							}
							String value23 = (brf301[23] == null) ? "0" : brf301[23].toString();
							cell23.setCellValue(value23);

							////////// c22////////////

							Cell cell22 = row.getCell(23);
							if (cell22 == null) {
								cell22 = row.createCell(23);
							}
							String value22 = (brf301[22] == null) ? "0" : brf301[22].toString();
							cell22.setCellValue(value22);

							////////// c24////////////

							Cell cell24 = row.getCell(25);
							if (cell24 == null) {
								cell24 = row.createCell(25);
							}
							String value24 = (brf301[24] == null) ? "0" : brf301[24].toString();
							cell24.setCellValue(value24);

							////////// c25////////////

							Cell cell25 = row.getCell(26);
							if (cell25 == null) {
								cell25 = row.createCell(26);
							}
							String value25 = (brf301[25] == null) ? "0" : brf301[25].toString();
							cell25.setCellValue(value25);

							////////// c19////////////

							/*
							 * Cell cell19 = row.getCell(20); if (cell19 == null) { cell19 =
							 * row.createCell(20); } String value19 = (brf301[19] == null) ? "0" :
							 * brf301[19].toString(); cell19.setCellValue(value19);
							 */

							Cell cell19 = row.getCell(20);
							if (cell19 == null) {
								cell19 = row.createCell(20);
							}
							cell19.setCellValue(brf301[19] == null ? 0 : ((BigDecimal) brf301[19]).intValue());

							////////// c26////////////

							Cell cell26 = row.getCell(27);
							if (cell26 == null) {
								cell26 = row.createCell(27);
							}
							String value26 = (brf301[26] == null) ? "0" : brf301[26].toString();
							cell26.setCellValue(value26);

							////////// c27////////////

							Cell cell27 = row.getCell(28);
							if (cell27 == null) {
								cell27 = row.createCell(28);
							}
							String value27 = (brf301[27] == null) ? "0" : brf301[27].toString();
							cell27.setCellValue(value27);

							////////// c28////////////

							Cell cell28 = row.getCell(29);
							if (cell28 == null) {
								cell28 = row.createCell(29);
							}
							String value28 = (brf301[28] == null) ? "0" : brf301[28].toString();
							cell28.setCellValue(value28);

						}

						// Save the changes
						workbook.getCreationHelper().createFormulaEvaluator().evaluateAll();

						try (FileOutputStream fileOut = new FileOutputStream(
								env.getProperty("output.exportpathfinal") + "011-BRF-047-A.xls")) {
							workbook.write(fileOut);
							System.out.println("File saved successfully at: "
									+ env.getProperty("output.exportpathfinal") + "011-BRF-047-A.xls");
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
		outputFile = new File(env.getProperty("output.exportpathfinal") + "011-BRF-047-A.xls");

		return outputFile;

	}

	public ModelAndView getArchieveBRF301View(String reportId, String fromdate, String todate, String currency,
			String dtltype, Pageable pageable) {

		ModelAndView mv = new ModelAndView();
		Session hs = sessionFactory.getCurrentSession();

		logger.info("Inside archive: " + currency);

		try {
			// Fetching data from BRF301_SUMMARYTABLE
			List<BRF301_entity> T1Master = hs
					.createNativeQuery("SELECT * FROM BRF301_SUMMARYTABLE a WHERE a.report_date = ?1 ORDER BY r1_s_no",
							BRF301_entity.class)
					.setParameter(1, df.parse(todate)).getResultList();

			// Fetching data from XBRL_USER_PROFILE_TABLE
			List<UserProfile> T2Master = hs
					.createNativeQuery("SELECT * FROM XBRL_USER_PROFILE_TABLE", UserProfile.class).getResultList();

			// Logging size for debugging
			System.out.println("The size is: " + T1Master.size());

			// Setting view and attributes
			mv.setViewName("RR/BRF301ARCH");
			mv.addObject("modify_flg", T1Master.size() > 0 ? T1Master.get(0).getModify_flg() : null);
			mv.addObject("modify_user", T1Master.size() > 0 ? T1Master.get(0).getModify_user() : null);
			mv.addObject("list", T1Master);
			mv.addObject("list1", T2Master);
			mv.addObject("userid", T2Master.size() > 0 ? T2Master.get(0).getUserid() : null);
			mv.addObject("role_id", T2Master.size() > 0 ? T2Master.get(0).getRole_id() : null);
			mv.addObject("displaymode", "summary");
			mv.addObject("reportsflag", "reportsflag");
			mv.addObject("menu", reportId);
		} catch (Exception e) {
			logger.error("Error while fetching data for BRF301: ", e);
			mv.setViewName("error");
			mv.addObject("message", "An error occurred while processing the request.");
		}

		return mv;
	}

	public String modifyBrf301(ReportBRF301Data formData, Date asondate, String userId, HttpServletRequest req) {

		String msg = "";
		List<BRF301_entity> existingReports = brf301_entity_repo.getallDetails(asondate);
		List<BRF301_entity> userData = formData.getBrf301_entity();

		List<String> oldValuesList = new ArrayList<>();
		List<String> newValuesList = new ArrayList<>();
		List<String> fieldNames = new ArrayList<>();

		List<String> finaloldval = new ArrayList<>();

		for (BRF301_entity userdatas : userData) {
			boolean found = false;
			for (BRF301_entity exiting : existingReports) {
				if (exiting.getR1_s_no().equals(userdatas.getR1_s_no())) {
					found = true;
					break;
				}
			}
			if (!found) {
				finaloldval.add(userdatas.toString());
			}
		}

		// StringBuilders to capture detailed changes
		StringBuilder oldChange = new StringBuilder();
		StringBuilder newChange = new StringBuilder();

		boolean rowEdited = false;
		for (BRF301_entity datavalues : userData) {
			for (BRF301_entity existingReport : existingReports) {
				// Assuming you want to compare only if the serial numbers match
				if (datavalues.getR1_s_no().compareTo(existingReport.getR1_s_no()) == 0) {
					String rowPrefix = "Row " + datavalues.getR1_s_no() + " : ";

					if (datavalues.getR1_s_no().compareTo(existingReport.getR1_s_no()) != 0) {
						fieldNames.add("Srl no");
						oldChange.append(rowPrefix).append("Column 1: ").append(existingReport.getR1_s_no())
								.append("; ");
						newChange.append(rowPrefix).append("Column 1: ").append(datavalues.getR1_s_no()).append("; ");
						rowEdited = true;
					}
					if (datavalues.getR1_domain().compareTo(existingReport.getR1_domain()) != 0) {
						fieldNames.add("Outsourced Activity Domain");
						oldChange.append(rowPrefix).append("Column 2: ").append(existingReport.getR1_domain())
								.append("; ");
						newChange.append(rowPrefix).append("Column 2: ").append(datavalues.getR1_domain()).append("; ");
						rowEdited = true;
					}
					if (datavalues.getR1_description().compareTo(existingReport.getR1_description()) != 0) {
						fieldNames.add("Description of Outsourced Activity");
						oldChange.append(rowPrefix).append("Column 3: ").append(existingReport.getR1_description())
								.append("; ");
						newChange.append(rowPrefix).append("Column 3: ").append(datavalues.getR1_description())
								.append("; ");
						rowEdited = true;
					}
					if (datavalues.getR1_receiver().compareTo(existingReport.getR1_receiver()) != 0) {
						fieldNames.add("Receiver of third party service");
						oldChange.append(rowPrefix).append("Column 4: ").append(existingReport.getR1_receiver())
								.append("; ");
						newChange.append(rowPrefix).append("Column 4: ").append(datavalues.getR1_receiver())
								.append("; ");
						rowEdited = true;
					}
					if (datavalues.getR1_material().compareTo(existingReport.getR1_material()) != 0) {
						fieldNames.add("Material Outsourcing");
						oldChange.append(rowPrefix).append("Column 5: ").append(existingReport.getR1_material())
								.append("; ");
						newChange.append(rowPrefix).append("Column 5: ").append(datavalues.getR1_material())
								.append("; ");
						rowEdited = true;
					}
					if (datavalues.getR1_cbuae().compareTo(existingReport.getR1_cbuae()) != 0) {
						fieldNames.add("CBUAE No Objection reference number, if any");
						oldChange.append(rowPrefix).append("Column 6: ").append(existingReport.getR1_cbuae())
								.append("; ");
						newChange.append(rowPrefix).append("Column 6: ").append(datavalues.getR1_cbuae()).append("; ");
						rowEdited = true;
					}
					if (datavalues.getR1_out_jobs().compareTo(existingReport.getR1_out_jobs()) != 0) {
						fieldNames.add("Total Numbered of Outsourced Jobs");
						oldChange.append(rowPrefix).append("Column 7: ").append(existingReport.getR1_out_jobs())
								.append("; ");
						newChange.append(rowPrefix).append("Column 7: ").append(datavalues.getR1_out_jobs())
								.append("; ");
						rowEdited = true;
					}
					if (datavalues.getR1_critical_jobs().compareTo(existingReport.getR1_critical_jobs()) != 0) {
						fieldNames.add("Number of Critical Outsourced Jobs");
						oldChange.append(rowPrefix).append("Column 8: ").append(existingReport.getR1_critical_jobs())
								.append("; ");
						newChange.append(rowPrefix).append("Column 8: ").append(datavalues.getR1_critical_jobs())
								.append("; ");
						rowEdited = true;
					}
					if (datavalues.getR1_third_parties().compareTo(existingReport.getR1_third_parties()) != 0) {
						fieldNames.add("Data Access by Third Parties");
						oldChange.append(rowPrefix).append("Column 9: ").append(existingReport.getR1_third_parties())
								.append("; ");
						newChange.append(rowPrefix).append("Column 9: ").append(datavalues.getR1_third_parties())
								.append("; ");
						rowEdited = true;
					}
					if (datavalues.getR1_nature_data().compareTo(existingReport.getR1_nature_data()) != 0) {
						fieldNames.add("Nature of Data Involved");
						oldChange.append(rowPrefix).append("Column 10: ").append(existingReport.getR1_nature_data())
								.append("; ");
						newChange.append(rowPrefix).append("Column 10: ").append(datavalues.getR1_nature_data())
								.append("; ");
						rowEdited = true;
					}
					if (datavalues.getR1_service().compareTo(existingReport.getR1_service()) != 0) {
						fieldNames.add("Is the Service provider Owned by the Bank?");
						oldChange.append(rowPrefix).append("Column 11: ").append(existingReport.getR1_service())
								.append("; ");
						newChange.append(rowPrefix).append("Column 11: ").append(datavalues.getR1_service())
								.append("; ");
						rowEdited = true;
					}
					if (datavalues.getR1_vendor().compareTo(existingReport.getR1_vendor()) != 0) {
						fieldNames.add("Name of the Vendor");
						oldChange.append(rowPrefix).append("Column 12: ").append(existingReport.getR1_vendor())
								.append("; ");
						newChange.append(rowPrefix).append("Column 12: ").append(datavalues.getR1_vendor())
								.append("; ");
						rowEdited = true;
					}
					if (datavalues.getR1_country_reg().compareTo(existingReport.getR1_country_reg()) != 0) {
						fieldNames.add("Country of Registration of the Vendor");
						oldChange.append(rowPrefix).append("Column 13: ").append(existingReport.getR1_country_reg())
								.append("; ");
						newChange.append(rowPrefix).append("Column 13: ").append(datavalues.getR1_country_reg())
								.append("; ");
						rowEdited = true;
					}
					if (datavalues.getR1_lei().compareTo(existingReport.getR1_lei()) != 0) {
						fieldNames.add("LEI or Registration Number of the Vendor");
						oldChange.append(rowPrefix).append("Column 14: ").append(existingReport.getR1_lei())
								.append("; ");
						newChange.append(rowPrefix).append("Column 14: ").append(datavalues.getR1_lei()).append("; ");
						rowEdited = true;
					}
					if (datavalues.getR1_company().compareTo(existingReport.getR1_company()) != 0) {
						fieldNames.add("Holding / Parent Company");
						oldChange.append(rowPrefix).append("Column 15: ").append(existingReport.getR1_company())
								.append("; ");
						newChange.append(rowPrefix).append("Column 15: ").append(datavalues.getR1_company())
								.append("; ");
						rowEdited = true;
					}
					if (datavalues.getR1_country_service().compareTo(existingReport.getR1_country_service()) != 0) {
						fieldNames.add("Countries where the Service is to be Performed");
						oldChange.append(rowPrefix).append("Column 16: ").append(existingReport.getR1_country_service())
								.append("; ");
						newChange.append(rowPrefix).append("Column 16: ").append(datavalues.getR1_country_service())
								.append("; ");
						rowEdited = true;
					}
					if (datavalues.getR1_country_data().compareTo(existingReport.getR1_country_data()) != 0) {
						fieldNames.add("Countries where Data is or may be Stored");
						oldChange.append(rowPrefix).append("Column 17: ").append(existingReport.getR1_country_data())
								.append("; ");
						newChange.append(rowPrefix).append("Column 17: ").append(datavalues.getR1_country_data())
								.append("; ");
						rowEdited = true;
					}
					if (datavalues.getR1_gov_law().compareTo(existingReport.getR1_gov_law()) != 0) {
						fieldNames.add("Governing Law");
						oldChange.append(rowPrefix).append("Column 18: ").append(existingReport.getR1_gov_law())
								.append("; ");
						newChange.append(rowPrefix).append("Column 18: ").append(datavalues.getR1_gov_law())
								.append("; ");
						rowEdited = true;
					}
					/// BigDecimal(r1_annual_con)
					if (datavalues.getR1_annual_con().compareTo(existingReport.getR1_annual_con()) != 0) {
						fieldNames.add("Annual Contract Value");
						oldChange.append(rowPrefix).append("Column 19: ").append(existingReport.getR1_annual_con())
								.append("; ");
						newChange.append(rowPrefix).append("Column 19: ").append(datavalues.getR1_annual_con())
								.append("; ");
						rowEdited = true;
					}

					/// BigDecimal(r1_total_con)
					if (datavalues.getR1_total_con().compareTo(existingReport.getR1_total_con()) != 0) {
						fieldNames.add("Total Contract value ");
						oldChange.append(rowPrefix).append("Column 20: ").append(existingReport.getR1_total_con())
								.append("; ");
						newChange.append(rowPrefix).append("Column 20: ").append(datavalues.getR1_total_con())
								.append("; ");
						rowEdited = true;
					}
					/// Date(r1_ser_date)
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");

					if (!sdf.format(datavalues.getR1_ser_date()).equals(sdf.format(existingReport.getR1_ser_date()))) {
						fieldNames.add("The service commencement (DD/MM/YYY)");
						oldChange.append(rowPrefix).append("Column 21: ")
								.append(sdf.format(existingReport.getR1_ser_date())).append("; ");
						newChange.append(rowPrefix).append("Column 21: ")
								.append(sdf.format(datavalues.getR1_ser_date())).append("; ");
						rowEdited = true;
					}

					/// Date(r1_exp_date)
					if (!sdf.format(datavalues.getR1_exp_date()).equals(sdf.format(existingReport.getR1_exp_date()))) {
						fieldNames.add("The service expiry date (DD/MM/YYY)");
						oldChange.append(rowPrefix).append("Column 22: ")
								.append(sdf.format(existingReport.getR1_exp_date())).append("; ");
						newChange.append(rowPrefix).append("Column 22: ")
								.append(sdf.format(datavalues.getR1_exp_date())).append("; ");
						rowEdited = true;
					}
					if (datavalues.getR1_risk().compareTo(existingReport.getR1_risk()) != 0) {
						fieldNames.add("Outcome of the Risk Assessment");
						oldChange.append(rowPrefix).append("Column 23: ").append(existingReport.getR1_risk())
								.append("; ");
						newChange.append(rowPrefix).append("Column 23: ").append(datavalues.getR1_risk()).append("; ");
						rowEdited = true;
					}
					if (datavalues.getR1_sub1().compareTo(existingReport.getR1_sub1()) != 0) {
						fieldNames.add("Substitutability");
						oldChange.append(rowPrefix).append("Column 24: ").append(existingReport.getR1_sub1())
								.append("; ");
						newChange.append(rowPrefix).append("Column 24: ").append(datavalues.getR1_sub1()).append("; ");
						rowEdited = true;
					}
					if (datavalues.getR1_sub2().compareTo(existingReport.getR1_sub2()) != 0) {
						fieldNames.add("Time Critical Operation");
						oldChange.append(rowPrefix).append("Column 25: ").append(existingReport.getR1_sub2())
								.append("; ");
						newChange.append(rowPrefix).append("Column 25: ").append(datavalues.getR1_sub2()).append("; ");
						rowEdited = true;
					}
					/// Date(r1_last_date)
					if (!sdf.format(datavalues.getR1_last_date())
							.equals(sdf.format(existingReport.getR1_last_date()))) {
						fieldNames.add("Last Audit Date (DD/MM/YYY)");
						oldChange.append(rowPrefix).append("Column 26: ")
								.append(sdf.format(existingReport.getR1_last_date())).append("; ");
						newChange.append(rowPrefix).append("Column 26: ")
								.append(sdf.format(datavalues.getR1_last_date())).append("; ");
						rowEdited = true;
					}
					if (datavalues.getR1_comments().compareTo(existingReport.getR1_comments()) != 0) {
						fieldNames.add("Comments");
						oldChange.append(rowPrefix).append("Column 27: ").append(existingReport.getR1_comments())
								.append("; ");
						newChange.append(rowPrefix).append("Column 27: ").append(datavalues.getR1_comments())
								.append("; ");
						rowEdited = true;
					}
					if (datavalues.getR1_reserve1().compareTo(existingReport.getR1_reserve1()) != 0) {
						fieldNames.add("Reserve 1");
						oldChange.append(rowPrefix).append("Column 28: ").append(existingReport.getR1_reserve1())
								.append("; ");
						newChange.append(rowPrefix).append("Column 28: ").append(datavalues.getR1_reserve1())
								.append("; ");
						rowEdited = true;
					}
					if (datavalues.getR1_reserve2().compareTo(existingReport.getR1_reserve2()) != 0) {
						fieldNames.add("Reserve 2");
						oldChange.append(rowPrefix).append("Column 29: ").append(existingReport.getR1_reserve2())
								.append("; ");
						newChange.append(rowPrefix).append("Column 29: ").append(datavalues.getR1_reserve2())
								.append("; ");
						rowEdited = true;
					}
				}
			}
		}
		if (rowEdited) {
			oldValuesList.add(oldChange.toString().trim());
			newValuesList.add(newChange.toString().trim());
			// Here, save the updated report for each row in the database
			// Example: yourRepository.save(userReport);
		}

		if (Objects.nonNull(userData) && userData.size() > 0) {
			List<BRF301_entity> docDetails = new ArrayList<>();
			for (BRF301_entity entity : userData) {
				entity.setDel_flg("N");
				entity.setEntity_flg("Y");
				entity.setModify_flg("Y");
				entity.setModify_user(userId);
				;
				entity.setReport_date(asondate);
				entity.setReport_submit_date(new Date());
				docDetails.add(entity);
			}
			brf301_entity_repo.saveAll(docDetails);
			msg = "Updated Successfully";
		} else {
			msg = "Data Not Found";
		}
		String auditID = sequence.generateRequestUUId();
		String user1 = (String) req.getSession().getAttribute("USERID");
		String username = (String) req.getSession().getAttribute("USERNAME");

		if (existingReports.size() == userData.size()) {
			MANUAL_Service_Entity audit = new MANUAL_Service_Entity();
			audit.setAudit_date(new Date());
			audit.setEntry_time(new Date());
			audit.setEntry_user(user1);
			audit.setFunc_code("MODIFY");
			audit.setAudit_table("BRF301_SUMMARYTABLE");
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
			MANUAL_Service_Entity audit = new MANUAL_Service_Entity();
			audit.setAudit_date(new Date());
			audit.setEntry_time(new Date());
			audit.setEntry_user(user1);
			audit.setFunc_code("ADD");
			audit.setAudit_table("BRF301_SUMMARYTABLE");
			audit.setAudit_screen("ADD");
			audit.setEvent_id(user1);
			audit.setEvent_name(username);
			audit.setNew_value(String.join("; ", finaloldval));
			audit.setRemarks("Added Successfully");

			UserProfile values1 = userProfileRep.getRole(user1);
			audit.setAuth_user(values1.getAuth_user());
			audit.setAuth_time(values1.getAuth_time());
			audit.setAudit_ref_no(auditID);
			mANUAL_Service_Rep.save(audit);
		}

		return msg;
	}

	public String verifyBRF301Report(Date asondate, String userId, HttpServletRequest req) {
		String msg = "";
		List<BRF301_entity> existingReports = brf301_entity_repo.getallDetails(asondate);

		if (Objects.nonNull(existingReports) && !existingReports.isEmpty()) {
			List<BRF301_entity> updatedReports = new ArrayList<>();
			for (BRF301_entity entity : existingReports) {
				entity.setEntity_flg("Y");
				entity.setModify_flg("N");
				entity.setReport_date(asondate);
				entity.setVerify_time(new Date());
				entity.setVerify_user(userId);
				entity.setVerify_time(asondate);
				entity.setReport_submit_date(new Date());
				updatedReports.add(entity);
			}
			brf301_entity_repo.saveAll(updatedReports);
			msg = "Verify Successfully";
		} else {
			msg = "Data Not Found";
		}
		String auditID = sequence.generateRequestUUId();
		String user1 = (String) req.getSession().getAttribute("USERID");
		String username = (String) req.getSession().getAttribute("USERNAME");

		MANUAL_Service_Entity audit = new MANUAL_Service_Entity();
		audit.setAudit_date(new Date());
		audit.setEntry_time(new Date());
		audit.setEntry_user(user1);
		audit.setFunc_code("VERIFY");
		audit.setAudit_table("BRF301_SUMMARYTABLE");
		audit.setAudit_screen("VERIFY");
		audit.setEvent_id(user1);
		audit.setEvent_name(username);
		audit.setRemarks("Verify Successfully");

		UserProfile values1 = userProfileRep.getRole(user1);
		audit.setAuth_user(values1.getAuth_user());
		audit.setAuth_time(values1.getAuth_time());
		audit.setAudit_ref_no(auditID);
		mANUAL_Service_Rep.save(audit);

		return msg;

	}
}
