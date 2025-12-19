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

import com.bornfire.xbrl.entities.BRBS.BRF67_ENTITY;
import com.bornfire.xbrl.entities.BRBS.BRF67ServiceRepo;
import com.bornfire.xbrl.entities.BRBS.BRF67_ARCHIVENTITY;
import com.bornfire.xbrl.entities.BRBS.BRF67_DETAIL_ENTITY;
import com.bornfire.xbrl.entities.BRBS.BRF67_DetailRep;
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
public class BRF67ReportService {
private static final Logger logger = LoggerFactory.getLogger(BRF67ReportService.class);
		@Autowired
		SessionFactory sessionFactory;

		@Autowired
		DataSource srcdataSource;
		
		@Autowired
		Environment env;
		 
		@Autowired
		BRF67ServiceRepo brf67ServiceRepo;
		@Autowired
		BRF67_DetailRep brf67_DetailRep; 
		
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
				Long dtlcnt = (Long) hs.createQuery("select count(*) from  BRF67_ENTITY a where a.report_date=?1")
						.setParameter(1, dt9).getSingleResult();

				if (dtlcnt > 0) {
					logger.info("Getting No of records in Mod table :" + reportid);
					Long modcnt = (Long) hs.createQuery("select count(*) from  BRF67_ENTITY a").getSingleResult();
					if (modcnt > 0) {
						msg = "success";
					}
				} else {
				//	msg = "Data Not available for the Report. Please Contact Administrator";
					msg = "success";

				}

			} catch (Exception e) {
				logger.info(e.getMessage());
				msg = "success";
				e.printStackTrace();

			}

			return msg;

		}
		public File getFileBRF67(String reportId, String fromdate, String todate, String currency, String dtltype,
				String filetype) throws FileNotFoundException, JRException, SQLException {

			DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

			String path =  this.env.getProperty("output.exportpath");
			String fileName = "";
			String zipFileName = "";
			File outputFile;

			logger.info("Getting Output file :" + reportId);
			fileName = "011-BRF-067-A";

			if (!filetype.equals("xbrl")) {
				if(!filetype.equals("BRF")) {
				try {
					InputStream jasperFile;
					logger.info("Getting Jasper file :" + reportId);
					if (filetype.equals("detailexcel")) {
						if (dtltype.equals("report")) {

							jasperFile = this.getClass().getResourceAsStream("/static/jasper/BRF67_Detail.jrxml");
						} else {
							jasperFile = this.getClass().getResourceAsStream("/static/jasper/BRF67_Detail.jrxml");
						}

					} else {
						if (dtltype.equals("report")) {
							logger.info("Inside report");
							jasperFile = this.getClass().getResourceAsStream("/static/jasper/BRF67.jrxml");
						} else {
							jasperFile = this.getClass().getResourceAsStream("/static/jasper/BRF67.jrxml");
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
				List<BRF67_ENTITY> T1Master = new ArrayList<>();

				Session hs = sessionFactory.getCurrentSession();
				try {
					Date d1 = df.parse(todate);

					T1Master = hs.createQuery("from  BRF67_ENTITY a where a.report_date = ?1 ", BRF67_ENTITY.class)
							.setParameter(1, df.parse(todate)).getResultList();

					File responseCamt = new File(env.getProperty("output.exportpathtemp") + "011-BRF-067-AT.xls");
					Workbook workbook = WorkbookFactory.create(responseCamt);

					Sheet sheet = workbook.getSheetAt(0);

					if (T1Master.size() == 1) {
						for (BRF67_ENTITY BRF67 : T1Master) {

							/// row2
							Row row2 = sheet.getRow(10);
							 Cell R2cell1 = row2.getCell(3);
					            if (R2cell1 != null) {
					                R2cell1.setCellValue(BRF67.getR2_noacct_uae() == null ? 0 :
					                	BRF67.getR2_noacct_uae().intValue());
					            }
					            Cell R2cell2 = row2.getCell(4);
					            if (R2cell2 != null) {
					                R2cell2.setCellValue(BRF67.getR2_balos_uae() == null ? 0 :
					                	BRF67.getR2_balos_uae().intValue());
					            }
					            Cell R2cell3 = row2.getCell(5);
					            if (R2cell3 != null) {
					                R2cell3.setCellValue(BRF67.getR2_noacct_other() == null ? 0 :
					                	BRF67.getR2_noacct_other().intValue());
					            }
					            Cell R2cell4 = row2.getCell(6);
					            if (R2cell4 != null) {
					                R2cell4.setCellValue(BRF67.getR2_balos_other() == null ? 0 :
					                	BRF67.getR2_balos_other().intValue());
					            }
					          /// row3
								Row row3 = sheet.getRow(11);
								Cell R3cell1 = row3.getCell(3);
					            if (R3cell1 != null) {
					                R3cell1.setCellValue(BRF67.getR3_noacct_uae() == null ? 0 :
					                	BRF67.getR3_noacct_uae().intValue());
					            }
					            Cell R3cell2 = row3.getCell(4);
					            if (R3cell2 != null) {
					                R3cell2.setCellValue(BRF67.getR3_balos_uae() == null ? 0 :
					                	BRF67.getR3_balos_uae().intValue());
					            }
					            Cell R3cell3 = row3.getCell(5);
					            if (R3cell3 != null) {
					                R3cell3.setCellValue(BRF67.getR3_noacct_other() == null ? 0 :
					                	BRF67.getR3_noacct_other().intValue());
					            }
					            Cell R3cell4 = row3.getCell(6);
					            if (R3cell4 != null) {
					                R3cell4.setCellValue(BRF67.getR3_balos_other() == null ? 0 :
					                	BRF67.getR3_balos_other().intValue());
					            }
								/// row4
								Row row4 = sheet.getRow(12);
								Cell R4cell1 = row4.getCell(3);
					            if (R4cell1 != null) {
					                R4cell1.setCellValue(BRF67.getR4_noacct_uae() == null ? 0 :
					                	BRF67.getR4_noacct_uae().intValue());
					            }
					            Cell R4cell2 = row4.getCell(4);
					            if (R4cell2 != null) {
					                R4cell2.setCellValue(BRF67.getR4_balos_uae() == null ? 0 :
					                	BRF67.getR4_balos_uae().intValue());
					            }
					            Cell R4cell3 = row4.getCell(5);
					            if (R4cell3 != null) {
					                R4cell3.setCellValue(BRF67.getR4_noacct_other() == null ? 0 :
					                	BRF67.getR4_noacct_other().intValue());
					            }
					            Cell R4cell4 = row4.getCell(6);
					            if (R4cell4 != null) {
					                R4cell4.setCellValue(BRF67.getR4_balos_other() == null ? 0 :
					                	BRF67.getR4_balos_other().intValue());
					            }
								/// row5
								Row row5 = sheet.getRow(13);
								Cell R5cell1 = row5.getCell(3);
					            if (R5cell1 != null) {
					                R5cell1.setCellValue(BRF67.getR5_noacct_uae() == null ? 0 :
					                	BRF67.getR5_noacct_uae().intValue());
					            }
					            Cell R5cell2 = row5.getCell(4);
					            if (R5cell2 != null) {
					                R5cell2.setCellValue(BRF67.getR5_balos_uae() == null ? 0 :
					                	BRF67.getR5_balos_uae().intValue());
					            }
					            Cell R5cell3 = row5.getCell(5);
					            if (R5cell3 != null) {
					                R5cell3.setCellValue(BRF67.getR5_noacct_other() == null ? 0 :
					                	BRF67.getR5_noacct_other().intValue());
					            }
					            Cell R5cell4 = row5.getCell(6);
					            if (R5cell4 != null) {
					                R5cell4.setCellValue(BRF67.getR5_balos_other() == null ? 0 :
					                	BRF67.getR5_balos_other().intValue());
					            }
								/// row6
								Row row6 = sheet.getRow(14);
								Cell R6cell1 = row6.getCell(3);
					            if (R6cell1 != null) {
					                R6cell1.setCellValue(BRF67.getR6_noacct_uae() == null ? 0 :
					                	BRF67.getR6_noacct_uae().intValue());
					            }
					            Cell R6cell2 = row6.getCell(4);
					            if (R6cell2 != null) {
					                R6cell2.setCellValue(BRF67.getR6_balos_uae() == null ? 0 :
					                	BRF67.getR6_balos_uae().intValue());
					            }
					            Cell R6cell3 = row6.getCell(5);
					            if (R6cell3 != null) {
					                R6cell3.setCellValue(BRF67.getR6_noacct_other() == null ? 0 :
					                	BRF67.getR6_noacct_other().intValue());
					            }
					            Cell R6cell4 = row6.getCell(6);
					            if (R6cell4 != null) {
					                R6cell4.setCellValue(BRF67.getR6_balos_other() == null ? 0 :
					                	BRF67.getR6_balos_other().intValue());
					            }
								/// row7
								Row row7 = sheet.getRow(15);
								Cell R7cell1 = row7.getCell(3);
					            if (R7cell1 != null) {
					                R7cell1.setCellValue(BRF67.getR7_noacct_uae() == null ? 0 :
					                	BRF67.getR7_noacct_uae().intValue());
					            }
					            Cell R7cell2 = row7.getCell(4);
					            if (R7cell2 != null) {
					                R7cell2.setCellValue(BRF67.getR7_balos_uae() == null ? 0 :
					                	BRF67.getR7_balos_uae().intValue());
					            }
					            Cell R7cell3 = row7.getCell(5);
					            if (R7cell3 != null) {
					                R7cell3.setCellValue(BRF67.getR7_noacct_other() == null ? 0 :
					                	BRF67.getR7_noacct_other().intValue());
					            }
					            Cell R7cell4 = row7.getCell(6);
					            if (R7cell4 != null) {
					                R7cell4.setCellValue(BRF67.getR7_balos_other() == null ? 0 :
					                	BRF67.getR7_balos_other().intValue());
					            }
					            
					            /// (S2)row9
								Row row9 = sheet.getRow(18);
								Cell S2cell3 = row9.getCell(7);
					            if (S2cell3 != null) {
					                S2cell3.setCellValue(BRF67.getS2_noacct_totaldeposit() == null ? 0 :
					                	BRF67.getS2_noacct_totaldeposit().intValue());
					            }
					            Cell S2cell4 = row9.getCell(8);
					            if (S2cell4 != null) {
					                S2cell4.setCellValue(BRF67.getS2_balos_totaldeposit() == null ? 0 :
					                	BRF67.getS2_balos_totaldeposit().intValue());
					            }
								/// (S3)row10
								Row row10 = sheet.getRow(19);
								Cell S3cell3 = row10.getCell(7);
					            if (S3cell3 != null) {
					                S3cell3.setCellValue(BRF67.getS3_noacct_totaldeposit() == null ? 0 :
					                	BRF67.getS3_noacct_totaldeposit().intValue());
					            }
					            Cell S3cell4 = row10.getCell(8);
					            if (S3cell4 != null) {
					                S3cell4.setCellValue(BRF67.getS3_balos_totaldeposit() == null ? 0 :
					                	BRF67.getS3_balos_totaldeposit().intValue());
					            }
								/// (S4)row11
								Row row11 = sheet.getRow(20);
								Cell S4cell3 = row11.getCell(7);
					            if (S4cell3 != null) {
					                S4cell3.setCellValue(BRF67.getS4_noacct_totaldeposit() == null ? 0 :
					                	BRF67.getS4_noacct_totaldeposit().intValue());
					            }
					            Cell S4cell4 = row11.getCell(8);
					            if (S4cell4 != null) {
					                S4cell4.setCellValue(BRF67.getS4_balos_totaldeposit() == null ? 0 :
					                	BRF67.getS4_balos_totaldeposit().intValue());
					            }
								/// (S5)row12
								Row row12 = sheet.getRow(21);
								Cell S5cell3 = row12.getCell(7);
					            if (S5cell3 != null) {
					                S5cell3.setCellValue(BRF67.getS5_noacct_totaldeposit() == null ? 0 :
					                	BRF67.getS5_noacct_totaldeposit().intValue());
					            }
					            Cell S5cell4 = row12.getCell(8);
					            if (S5cell4 != null) {
					                S5cell4.setCellValue(BRF67.getS5_balos_totaldeposit() == null ? 0 :
					                	BRF67.getS5_balos_totaldeposit().intValue());
					            }
								/// (S6)row13
								Row row13 = sheet.getRow(22);
								Cell S6cell3 = row13.getCell(7);
					            if (S6cell3 != null) {
					                S6cell3.setCellValue(BRF67.getS6_noacct_totaldeposit() == null ? 0 :
					                	BRF67.getS6_noacct_totaldeposit().intValue());
					            }
					            Cell S6cell4 = row13.getCell(8);
					            if (S6cell4 != null) {
					                S6cell4.setCellValue(BRF67.getS6_balos_totaldeposit() == null ? 0 :
					                	BRF67.getS6_balos_totaldeposit().intValue());
					            }
								/// (S7)row14
								Row row14 = sheet.getRow(23);
								Cell S7cell3 = row14.getCell(7);
					            if (S7cell3 != null) {
					                S7cell3.setCellValue(BRF67.getS7_noacct_totaldeposit() == null ? 0 :
					                	BRF67.getS7_noacct_totaldeposit().intValue());
					            }
					            Cell S7cell4 = row14.getCell(8);
					            if (S7cell4 != null) {
					                S7cell4.setCellValue(BRF67.getS7_balos_totaldeposit() == null ? 0 :
					                	BRF67.getS7_balos_totaldeposit().intValue());
					            }
						}
					}

					workbook.getCreationHelper().createFormulaEvaluator().evaluateAll();
					FileOutputStream fileOut = new FileOutputStream(
							env.getProperty("output.exportpathfinal") + "011-BRF-067-A.xls");
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
		outputFile = new File(env.getProperty("output.exportpathfinal") + "011-BRF-067-A.xls");

		return outputFile;

	}
		
public ModelAndView getBRF67currentDtl(String reportId, String fromdate, String todate, String currency,
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
							"select * from BRF67_DETAILTABLE  a where report_date = ?1 and report_label_1=?2");
					
					qr.setParameter(2, filter);
				} else {
					qr = hs.createNativeQuery("select * from BRF67_DETAILTABLE a where report_date = ?1");
				}
			} else {
				qr = hs.createNativeQuery("select * from BRF67_DETAILTABLE  where report_date = ?1");
			}
			
			try {
				qr.setParameter(1, df.parse(todate));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			List<BRF67_DETAIL_ENTITY> T1Master = new ArrayList<BRF67_DETAIL_ENTITY>();

			try {
				T1Master = hs.createQuery("from BRF67_DETAIL_ENTITY a where a.report_date = ?1", BRF67_DETAIL_ENTITY.class)
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

				BRF67_DETAIL_ENTITY py = new BRF67_DETAIL_ENTITY(cust_id, foracid,acct_name, eab_lc, act_balance_amt_lc,  acct_crncy_code, gl_code,
						gl_sub_head_code, gl_sub_head_desc, country_of_incorp, cust_type,
						schm_code, schm_type, sol_id, acid, segment,
						sub_segment, sector, sub_sector,  sector_code, group_id,
						constitution_code, country, legal_entity_type, constitution_desc, purpose_of_advn,
						hni_networth, turnover, bacid, report_name_1,report_label_1,
						report_addl_criteria_1, report_addl_criteria_2, report_addl_criteria_3, create_user, create_time,
						 modify_user, modify_time, verify_user, verify_time,
						entity_flg, modify_flg, del_flg, nre_status, report_date,
						maturity_date, version, remarks);

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

			mv.setViewName("RR"+"/"+"BRF67::reportcontent");
			// mv.setViewName("ReportT1");
			mv.addObject("reportdetails", T1Dt1Page);
			mv.addObject("reportmaster", T1Master);
			mv.addObject("singledetail", new T1CurProdDetail());
			mv.addObject("reportsflag", "reportsflag");
			mv.addObject("menu", reportId);
			return mv;
		}
		public ModelAndView getBRF67View(String reportId, String fromdate, String todate, String currency, String dtltype,
				Pageable pageable) {

			ModelAndView mv = new ModelAndView();

			Session hs = sessionFactory.getCurrentSession();
			int pageSize = pageable.getPageSize();
			int currentPage = pageable.getPageNumber();
			int startItem = currentPage * pageSize;
			List<BRF67_ENTITY> T1rep = new ArrayList<BRF67_ENTITY>();
			// Query<Object[]> qr;

			List<BRF67_ENTITY> T1Master = new ArrayList<BRF67_ENTITY>();

			logger.info("Inside archive" +currency);

			try {
				
				
				Date d1 = df.parse(todate);
			//	T1rep = t1CurProdServiceRepo.getT1CurProdServices(d1);

				T1Master = hs.createQuery("from BRF67_ENTITY a where a.report_date = ?1 ", BRF67_ENTITY.class)
						.setParameter(1, df.parse(todate)).getResultList();

			} catch (ParseException e) {
				e.printStackTrace();
			}

			// T1rep = t1CurProdServiceRepo.getT1CurProdServices(d1);

			mv.setViewName("RR/BRF67");
			// mv.addObject("currlist", refCodeConfig.currList());
			mv.addObject("reportsummary", T1Master);
			mv.addObject("reportmaster", T1Master);
			mv.addObject("displaymode", "summary");
			mv.addObject("reportsflag", "reportsflag");
			mv.addObject("menu", reportId);
			System.out.println("scv" + mv.getViewName());

			return mv;

		}
		
		public String detailChanges67(BRF67_DETAIL_ENTITY detail, String foracid, String report_addl_criteria_1,
				BigDecimal act_balance_amt_lc, String report_label_1, String report_name_1) {

			
			String msg = "";

			try {

				Session hs = sessionFactory.getCurrentSession();
				Optional<BRF67_DETAIL_ENTITY> Brf67detail =brf67_DetailRep.findById(foracid);

				if (Brf67detail.isPresent()) {
					BRF67_DETAIL_ENTITY BRFdetail = Brf67detail.get();

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
						brf67_DetailRep.save(BRFdetail);

//							hs.saveOrUpdate(detail);
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


		public ModelAndView getArchieveBRF067View(String reportId, String fromdate, String todate, String currency,
				String dtltype, Pageable pageable) {

			ModelAndView mv = new ModelAndView();
			Session hs = sessionFactory.getCurrentSession();
			int pageSize = pageable.getPageSize();
			int currentPage = pageable.getPageNumber();
			int startItem = currentPage * pageSize;
			//List<BRF81_ENTITY> T1rep = new ArrayList<BRF81_ENTITY>();
			// Query<Object[]> qr;

			List<BRF67_ENTITY> T1Master = new ArrayList<BRF67_ENTITY>();
			/* List<BRF73_TABLE2> T1Master1 = new ArrayList<BRF73_TABLE2>(); */

			
			
			logger.info("Inside archive" + currency);

			try {
				Date d1 = df.parse(todate);
				// T1rep = t1CurProdServiceRepo.getT1CurProdServices(d1);

				T1Master = hs.createQuery("from BRF67_ENTITY a where a.report_date = ?1 ", BRF67_ENTITY.class)
					.setParameter(1, df.parse(todate)).getResultList();

				
				/*
				 * T1Master1 = hs.createQuery("from BRF73_TABLE2 a where a.report_date = ?1 ",
				 * BRF73_TABLE2.class) .setParameter(1, df.parse(todate)).getResultList();
				 */

			} catch (ParseException e) {
				e.printStackTrace();
			}

			// T1rep = t1CurProdServiceRepo.getT1CurProdServices(d1);

			mv.setViewName("RR/BRF67ARCH");
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


		/**** ARCH DETAILS 
		 * @throws ParseException ****/



		public ModelAndView ARCHgetBRF067currentDtl(String reportId, String fromdate, String todate, String currency,
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
					System.out.println("Filter - "+filter);
					
					
						qr = hs.createNativeQuery("select * from BRF67_ARCHIVTABLE a where report_date=?1 and report_label_1=?2");
						qr.setParameter(1,  df.parse(todate));
						qr.setParameter(2,filter);
							

				} else {
					System.out.println("2");
					qr = hs.createNativeQuery("select * from BRF67_ARCHIVTABLE");

				}
			} else {
				System.out.println("3");
				qr = hs.createNativeQuery("select * from BRF67_ARCHIVTABLE  where report_date = ?1");
			}

			List<BRF67_ARCHIVENTITY> T1Master = new ArrayList<BRF67_ARCHIVENTITY>();

			try {
				System.out.println("Values entered");
				T1Master = hs.createQuery("from BRF67_ARCHIVENTITY a where a.report_date = ?1", BRF67_ARCHIVENTITY.class)
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
				BRF67_DETAIL_ENTITY py = new BRF67_DETAIL_ENTITY(cust_id, foracid,acct_name, eab_lc, act_balance_amt_lc,  acct_crncy_code, gl_code,
						gl_sub_head_code, gl_sub_head_desc, country_of_incorp, cust_type,
						schm_code, schm_type, sol_id, acid, segment,
						sub_segment, sector, sub_sector,  sector_code, group_id,
						constitution_code, country, legal_entity_type, constitution_desc, purpose_of_advn,
						hni_networth, turnover, bacid, report_name_1,report_label_1,
						report_addl_criteria_1, report_addl_criteria_2, report_addl_criteria_3, create_user, create_time,
						 modify_user, modify_time, verify_user, verify_time,
						entity_flg, modify_flg, del_flg, nre_status, report_date,
						maturity_date, version, remarks);
				T1Dt1.add(py);

			};

			List<Object> pagedlist;

			if (T1Dt1.size() < startItem) {
				pagedlist = Collections.emptyList();
			} else {
				int toIndex = Math.min(startItem + pageSize, T1Dt1.size());
				pagedlist = T1Dt1.subList(startItem, toIndex);
			}

			logger.info("Converting to Page");
			Page<Object> T1Dt1Page = new PageImpl<Object>(pagedlist, PageRequest.of(currentPage, pageSize), T1Dt1.size());

			mv.setViewName("RR" + "/" + "BRF67ARCH::reportcontent");
			mv.addObject("reportdetails", T1Dt1Page.getContent());
			mv.addObject("reportmaster", T1Master);
			mv.addObject("reportmaster1", qr);
			mv.addObject("singledetail", new T1CurProdDetail());
			mv.addObject("reportsflag", "reportsflag");
			mv.addObject("menu", reportId);
			return mv;
		}


		}