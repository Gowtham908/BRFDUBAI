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

import com.bornfire.xbrl.entities.BRF92_ARCHIV_ENTITY;
import com.bornfire.xbrl.entities.BRBS.BRF92_DetailRepo;
import com.bornfire.xbrl.entities.BRBS.BRF46_Entity;
import com.bornfire.xbrl.entities.BRBS.BRF92_DETAIL_ENTITY;
import com.bornfire.xbrl.entities.BRBS.BRF92_DETAIL_ENTITY;
import com.bornfire.xbrl.entities.BRBS.BRF92_TABLE;

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
public class BRF92ReportService {
	private static final Logger logger = LoggerFactory.getLogger(BRF92ReportService.class);

	@Autowired
	SessionFactory sessionFactory;

	@Autowired
	DataSource srcdataSource;
	
	@Autowired
	Environment env;

	 @Autowired 
	 BRF92_DetailRepo brf92_detailrepo;

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
			Long dtlcnt = (Long) hs.createQuery("select count(*) from BRF92_TABLE a where a.report_date=?1")
					.setParameter(1, dt9).getSingleResult();

			if (dtlcnt > 0) {
				logger.info("Getting No of records in Mod table :" + reportid);
				Long modcnt = (Long) hs.createQuery("select count(*) from BRF92_TABLE a").getSingleResult();
				if (modcnt > 0) {
					msg = "success";
				}
			} else {

				msg = "success";

			}

		} catch (Exception e) {
			logger.info(e.getMessage());
			msg = "success";
			e.printStackTrace();

		}

		return msg;

	}
	public ModelAndView getBRF92View(String reportId, String fromdate, String todate, String currency, String dtltype,
			Pageable pageable) {
				ModelAndView mv = new ModelAndView();
				Session hs = sessionFactory.getCurrentSession();
				int pageSize = pageable.getPageSize();
				int currentPage = pageable.getPageNumber();
				int startItem = currentPage * pageSize;
				List<BRF92_TABLE> T1rep = new ArrayList<BRF92_TABLE>();


				List<BRF92_TABLE> T1Master = new ArrayList<BRF92_TABLE>();


				logger.info("Inside archive" +currency);

				try {
					Date d1 = df.parse(todate);


					T1Master = hs.createQuery("from BRF92_TABLE a where a.report_date = ?1 ", BRF92_TABLE.class)
							.setParameter(1, df.parse(todate)).getResultList();




				} catch (ParseException e) {
					e.printStackTrace();
				}



				mv.setViewName("RR/BRF92");
				mv.addObject("reportsummary", T1Master);
				mv.addObject("reportmaster", T1Master);
				mv.addObject("displaymode", "summary");
				mv.addObject("reportsflag", "reportsflag");
				mv.addObject("menu", reportId);
				System.out.println("scv" + mv.getViewName());

				return mv;

			}
	public ModelAndView getBRF92Details(String reportId, String fromdate, String todate, String currency,
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
                qr = hs.createNativeQuery("select * from BRF92_DETAILTABLE");
                //qr.setParameter(2, filter);
            } else {
                qr = hs.createNativeQuery("select * from BRF92_DETAILTABLE");
            }
        } else {
            qr = hs.createNativeQuery("select * from BRF92_DETAILTABLE  where report_date = ?1");
        }
        List<BRF92_DETAIL_ENTITY> T1Master = new ArrayList<BRF92_DETAIL_ENTITY>();
 
        try {
            T1Master = hs.createQuery("from BRF92_DETAIL_ENTITY a where a.report_date = ?1", BRF92_DETAIL_ENTITY.class)
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
			

			BRF92_DETAIL_ENTITY py = new BRF92_DETAIL_ENTITY(cust_id, foracid,acct_name, eab_lc, act_balance_amt_lc,  acct_crncy_code, gl_code,
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

		mv.setViewName("RR"+"/"+"BRF92::reportcontent");
		mv.addObject("reportdetails", T1Dt1Page);
		mv.addObject("reportmaster", T1Master);
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
		fileName = "011-BRF-092-A" ;
					if (!filetype.equals("xbrl")) {
						if(!filetype.equals("BRF")) {

			try {
				InputStream jasperFile;
				logger.info("Getting Jasper file :" + reportId);
				if (filetype.equals("detailexcel")) {
					if (dtltype.equals("report")) {

						jasperFile = this.getClass().getResourceAsStream("/static/jasper/BRF92_Detail.jrxml");
					} else {
						jasperFile = this.getClass().getResourceAsStream("/static/jasper/BRF92_Detail.jrxml");
					}
				} else {
					if (dtltype.equals("report")) {
						logger.info("Inside report");
						jasperFile = this.getClass().getResourceAsStream("/static/jasper/BRF92_A.jrxml");
					} else {
						jasperFile = this.getClass().getResourceAsStream("/static/jasper/BRF92_A.jrxml");
					}
				}


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
			}else {
							
							List<BRF92_TABLE> T1Master = new ArrayList<BRF92_TABLE>();
							Session hs = sessionFactory.getCurrentSession();
							try {
								Date d1 = df.parse(todate);
							
							// T1rep = t1CurProdServiceRepo.getT1CurProdServices(d1);

							T1Master = hs.createQuery("from  BRF92_TABLE a where a.report_date = ?1 ", BRF92_TABLE.class)
									.setParameter(1, df.parse(todate)).getResultList();
							
							if(T1Master.size() == 1) {
								
								for(BRF92_TABLE BRF92 : T1Master ) {
							
							File Responsecamt = new File(env.getProperty("output.exportpathtemp")+"011-BRF-092-AT.xls");
							
							  // Load the Excel file
				        	Workbook workbook = WorkbookFactory.create(Responsecamt);

				            // Get the first sheet
				        	//////////////////////////////ROW 11 ///////////////////////
				            Sheet sheet = workbook.getSheetAt(0);
				            Row row = sheet.getRow(11);
				            Cell cell = row.getCell(3);
				            if (cell != null) {
				                cell.setCellValue(BRF92.getR3_position_at_begin() == null ? 0 :
				                	BRF92.getR3_position_at_begin().intValue());
				            }
				            Cell cell1 = row.getCell(4);
				            if (cell1 != null) {
				                cell1.setCellValue(BRF92.getR3_financial_acc_changes() == null ? 0 :
				                	BRF92.getR3_financial_acc_changes().intValue());
				            }
				            Cell cell2 = row.getCell(5);
				            if (cell2 != null) {
				                cell2.setCellValue(BRF92.getR3_exchange_rate_changes() == null ? 0 :
				                	BRF92.getR3_exchange_rate_changes().intValue());
				            }
				            Cell cell3 = row.getCell(6);
				            if (cell3 != null) {
				                cell3.setCellValue(BRF92.getR3_other_price_changes() == null ? 0 :
				                	BRF92.getR3_other_price_changes().intValue());
				            }
				            Cell cell4 = row.getCell(7);
				            if (cell4 != null) {
				                cell4.setCellValue(BRF92.getR3_other_changes() == null ? 0 :
				                	BRF92.getR3_other_changes().intValue());
				            }
				            Cell cell5 = row.getCell(8);
				            if (cell5 != null) {
				                cell5.setCellValue(BRF92.getR3_position_at_end() == null ? 0 :
				                	BRF92.getR3_position_at_end().intValue());
				            }
				            //////////////////////////////ROW 12 ///////////////////////
				            Row row1 = sheet.getRow(12);
				            Cell row1cell = row1.getCell(3);
				            if (row1cell != null) {
				            	row1cell.setCellValue(BRF92.getR4_position_at_begin() == null ? 0 :
				                	BRF92.getR4_position_at_begin().intValue());
				            }
				            Cell row1cell1 = row1.getCell(4);
				            if (row1cell1 != null) {
				            	row1cell1.setCellValue(BRF92.getR4_financial_acc_changes() == null ? 0 :
				                	BRF92.getR4_financial_acc_changes().intValue());
				            }
				            Cell row1cell2 = row1.getCell(5);
				            if (row1cell2 != null) {
				            	row1cell2.setCellValue(BRF92.getR4_exchange_rate_changes() == null ? 0 :
				                	BRF92.getR4_exchange_rate_changes().intValue());
				            }
				            Cell row1cell3 = row1.getCell(6);
				            if (row1cell3 != null) {
				            	row1cell3.setCellValue(BRF92.getR4_other_price_changes() == null ? 0 :
				                	BRF92.getR4_other_price_changes().intValue());
				            }
				            Cell row1cell4 = row1.getCell(7);
				            if (row1cell4 != null) {
				            	row1cell4.setCellValue(BRF92.getR4_other_changes() == null ? 0 :
				                	BRF92.getR4_other_changes().intValue());
				            }
				            Cell row1cell5 = row1.getCell(8);
				            if (row1cell5 != null) {
				            	row1cell5.setCellValue(BRF92.getR4_position_at_end() == null ? 0 :
				                	BRF92.getR4_position_at_end().intValue());
				            }
//////////////////////////////ROW 14 ///////////////////////
Row row2 = sheet.getRow(14);
				            Cell row2cell = row2.getCell(3);
				            if (row2cell != null) {
				            	row2cell.setCellValue(BRF92.getR6_position_at_begin() == null ? 0 :
				                	BRF92.getR6_position_at_begin().intValue());
				            }
				            Cell row2cell1 = row2.getCell(4);
				            if (row2cell1 != null) {
				            	row2cell1.setCellValue(BRF92.getR6_financial_acc_changes() == null ? 0 :
				                	BRF92.getR6_financial_acc_changes().intValue());
				            }
				            Cell row2cell2 = row2.getCell(5);
				            if (row2cell2 != null) {
				            	row2cell2.setCellValue(BRF92.getR6_exchange_rate_changes() == null ? 0 :
				                	BRF92.getR6_exchange_rate_changes().intValue());
				            }
				            Cell row2cell3 = row2.getCell(6);
				            if (row2cell3 != null) {
				            	row2cell3.setCellValue(BRF92.getR6_other_price_changes() == null ? 0 :
				                	BRF92.getR6_other_price_changes().intValue());
				            }
				            Cell row2cell4 = row2.getCell(7);
				            if (row2cell4 != null) {
				            	row2cell4.setCellValue(BRF92.getR6_other_changes() == null ? 0 :
				                	BRF92.getR6_other_changes().intValue());
				            }
				            Cell row2cell5 = row2.getCell(8);
				            if (row2cell5 != null) {
				            	row2cell5.setCellValue(BRF92.getR6_position_at_end() == null ? 0 :
				                	BRF92.getR6_position_at_end().intValue());
				            }


//////////////////////////////ROW 15 ///////////////////////
Row row3 = sheet.getRow(15);
				            Cell row3cell = row3.getCell(3);
				            if (row3cell != null) {
				            	row3cell.setCellValue(BRF92.getR7_position_at_begin() == null ? 0 :
				                	BRF92.getR7_position_at_begin().intValue());
				            }
				            Cell row3cell1 = row3.getCell(4);
				            if (row3cell1 != null) {
				            	row3cell1.setCellValue(BRF92.getR7_financial_acc_changes() == null ? 0 :
				                	BRF92.getR7_financial_acc_changes().intValue());
				            }
				            Cell row3cell2 = row3.getCell(5);
				            if (row3cell2 != null) {
				            	row3cell2.setCellValue(BRF92.getR7_exchange_rate_changes() == null ? 0 :
				                	BRF92.getR7_exchange_rate_changes().intValue());
				            }
				            Cell row3cell3 = row3.getCell(6);
				            if (row3cell3 != null) {
				            	row3cell3.setCellValue(BRF92.getR7_other_price_changes() == null ? 0 :
				                	BRF92.getR7_other_price_changes().intValue());
				            }
				            Cell row3cell4 = row3.getCell(7);
				            if (row3cell4 != null) {
				            	row3cell4.setCellValue(BRF92.getR7_other_changes() == null ? 0 :
				                	BRF92.getR7_other_changes().intValue());
				            }
				            Cell row3cell5 = row3.getCell(8);
				            if (row3cell5 != null) {
				            	row3cell5.setCellValue(BRF92.getR7_position_at_end() == null ? 0 :
				                	BRF92.getR7_position_at_end().intValue());
				            }


//////////////////////////////ROW 16 ///////////////////////
Row row4 = sheet.getRow(16);
				            Cell row4cell = row4.getCell(3);
				            if (row4cell != null) {
				            	row4cell.setCellValue(BRF92.getR8_position_at_begin() == null ? 0 :
				                	BRF92.getR8_position_at_begin().intValue());
				            }
				            Cell row4cell1 = row4.getCell(4);
				            if (row4cell1 != null) {
				            	row4cell1.setCellValue(BRF92.getR8_financial_acc_changes() == null ? 0 :
				                	BRF92.getR8_financial_acc_changes().intValue());
				            }
				            Cell row4cell2 = row4.getCell(5);
				            if (row4cell2 != null) {
				            	row4cell2.setCellValue(BRF92.getR8_exchange_rate_changes() == null ? 0 :
				                	BRF92.getR8_exchange_rate_changes().intValue());
				            }
				            Cell row4cell3 = row4.getCell(6);
				            if (row4cell3 != null) {
				            	row4cell3.setCellValue(BRF92.getR8_other_price_changes() == null ? 0 :
				                	BRF92.getR8_other_price_changes().intValue());
				            }
				            Cell row4cell4 = row4.getCell(7);
				            if (row4cell4 != null) {
				            	row4cell4.setCellValue(BRF92.getR8_other_changes() == null ? 0 :
				                	BRF92.getR8_other_changes().intValue());
				            }
				            Cell row4cell5 = row4.getCell(8);
				            if (row4cell5 != null) {
				            	row4cell5.setCellValue(BRF92.getR8_position_at_end() == null ? 0 :
				                	BRF92.getR8_position_at_end().intValue());
				            }
//////////////////////////////ROW 19///////////////////////
Row row5 = sheet.getRow(19);
				            Cell row5cell = row5.getCell(3);
				            if (row5cell != null) {
				            	row5cell.setCellValue(BRF92.getR11_position_at_begin() == null ? 0 :
				                	BRF92.getR11_position_at_begin().intValue());
				            }
				            Cell row5cell1 = row5.getCell(4);
				            if (row5cell1 != null) {
				            	row5cell1.setCellValue(BRF92.getR11_financial_acc_changes() == null ? 0 :
				                	BRF92.getR11_financial_acc_changes().intValue());
				            }
				            Cell row5cell2 = row5.getCell(5);
				            if (row5cell2 != null) {
				            	row5cell2.setCellValue(BRF92.getR11_exchange_rate_changes() == null ? 0 :
				                	BRF92.getR11_exchange_rate_changes().intValue());
				            }
				            Cell row5cell3 = row5.getCell(6);
				            if (row5cell3 != null) {
				            	row5cell3.setCellValue(BRF92.getR11_other_price_changes() == null ? 0 :
				                	BRF92.getR11_other_price_changes().intValue());
				            }
				            Cell row5cell4 = row5.getCell(7);
				            if (row5cell4 != null) {
				            	row5cell4.setCellValue(BRF92.getR11_other_changes() == null ? 0 :
				                	BRF92.getR11_other_changes().intValue());
				            }
				            Cell row5cell5 = row5.getCell(8);
				            if (row5cell5 != null) {
				            	row5cell5.setCellValue(BRF92.getR11_position_at_end() == null ? 0 :
				                	BRF92.getR11_position_at_end().intValue());
				            }


//////////////////////////////ROW 20///////////////////////
Row row6 = sheet.getRow(20);
				            Cell row6cell = row6.getCell(3);
				            if (row6cell != null) {
				            	row6cell.setCellValue(BRF92.getR12_position_at_begin() == null ? 0 :
				                	BRF92.getR12_position_at_begin().intValue());
				            }
				            Cell row6cell1 = row6.getCell(4);
				            if (row6cell1 != null) {
				            	row6cell1.setCellValue(BRF92.getR12_financial_acc_changes() == null ? 0 :
				                	BRF92.getR12_financial_acc_changes().intValue());
				            }
				            Cell row6cell2 = row6.getCell(5);
				            if (row6cell2 != null) {
				            	row6cell2.setCellValue(BRF92.getR12_exchange_rate_changes() == null ? 0 :
				                	BRF92.getR12_exchange_rate_changes().intValue());
				            }
				            Cell row6cell3 = row6.getCell(6);
				            if (row6cell3 != null) {
				            	row6cell3.setCellValue(BRF92.getR12_other_price_changes() == null ? 0 :
				                	BRF92.getR12_other_price_changes().intValue());
				            }
				            Cell row6cell4 = row6.getCell(7);
				            if (row6cell4 != null) {
				            	row6cell4.setCellValue(BRF92.getR12_other_changes() == null ? 0 :
				                	BRF92.getR12_other_changes().intValue());
				            }
				            Cell row6cell5 = row6.getCell(8);
				            if (row6cell5 != null) {
				            	row6cell5.setCellValue(BRF92.getR12_position_at_end() == null ? 0 :
				                	BRF92.getR12_position_at_end().intValue());
				            }


//////////////////////////////ROW 22///////////////////////
Row row7 = sheet.getRow(22);
				            Cell row7cell = row7.getCell(3);
				            if (row7cell != null) {
				            	row7cell.setCellValue(BRF92.getR14_position_at_begin() == null ? 0 :
				                	BRF92.getR14_position_at_begin().intValue());
				            }
				            Cell row7cell1 = row7.getCell(4);
				            if (row7cell1 != null) {
				            	row7cell1.setCellValue(BRF92.getR14_financial_acc_changes() == null ? 0 :
				                	BRF92.getR14_financial_acc_changes().intValue());
				            }
				            Cell row7cell2 = row7.getCell(5);
				            if (row7cell2 != null) {
				            	row7cell2.setCellValue(BRF92.getR14_exchange_rate_changes() == null ? 0 :
				                	BRF92.getR14_exchange_rate_changes().intValue());
				            }
				            Cell row7cell3 = row7.getCell(6);
				            if (row7cell3 != null) {
				            	row7cell3.setCellValue(BRF92.getR14_other_price_changes() == null ? 0 :
				                	BRF92.getR14_other_price_changes().intValue());
				            }
				            Cell row7cell4 = row7.getCell(7);
				            if (row7cell4 != null) {
				            	row7cell4.setCellValue(BRF92.getR14_other_changes() == null ? 0 :
				                	BRF92.getR14_other_changes().intValue());
				            }
				            Cell row7cell5 = row7.getCell(8);
				            if (row7cell5 != null) {
				            	row7cell5.setCellValue(BRF92.getR14_position_at_end() == null ? 0 :
				                	BRF92.getR14_position_at_end().intValue());
				            }


//////////////////////////////ROW 23///////////////////////
Row row8 = sheet.getRow(23);
				            Cell row8cell = row8.getCell(3);
				            if (row8cell != null) {
				            	row8cell.setCellValue(BRF92.getR15_position_at_begin() == null ? 0 :
				                	BRF92.getR15_position_at_begin().intValue());
				            }
				            Cell row8cell1 = row8.getCell(4);
				            if (row8cell1 != null) {
				            	row8cell1.setCellValue(BRF92.getR15_financial_acc_changes() == null ? 0 :
				                	BRF92.getR15_financial_acc_changes().intValue());
				            }
				            Cell row8cell2 = row8.getCell(5);
				            if (row8cell2 != null) {
				            	row8cell2.setCellValue(BRF92.getR15_exchange_rate_changes() == null ? 0 :
				                	BRF92.getR15_exchange_rate_changes().intValue());
				            }
				            Cell row8cell3 = row8.getCell(6);
				            if (row8cell3 != null) {
				            	row8cell3.setCellValue(BRF92.getR15_other_price_changes() == null ? 0 :
				                	BRF92.getR15_other_price_changes().intValue());
				            }
				            Cell row8cell4 = row8.getCell(7);
				            if (row8cell4 != null) {
				            	row8cell4.setCellValue(BRF92.getR15_other_changes() == null ? 0 :
				                	BRF92.getR15_other_changes().intValue());
				            }
				            Cell row8cell5 = row8.getCell(8);
				            if (row8cell5 != null) {
				            	row8cell5.setCellValue(BRF92.getR15_position_at_end() == null ? 0 :
				                	BRF92.getR15_position_at_end().intValue());
				            }


//////////////////////////////ROW 24///////////////////////
Row row9 = sheet.getRow(24);
				            Cell row9cell = row9.getCell(3);
				            if (row9cell != null) {
				            	row9cell.setCellValue(BRF92.getR16_position_at_begin() == null ? 0 :
				                	BRF92.getR16_position_at_begin().intValue());
				            }
				            Cell row9cell1 = row9.getCell(4);
				            if (row9cell1 != null) {
				            	row9cell1.setCellValue(BRF92.getR16_financial_acc_changes() == null ? 0 :
				                	BRF92.getR16_financial_acc_changes().intValue());
				            }
				            Cell row9cell2 = row9.getCell(5);
				            if (row9cell2 != null) {
				            	row9cell2.setCellValue(BRF92.getR16_exchange_rate_changes() == null ? 0 :
				                	BRF92.getR16_exchange_rate_changes().intValue());
				            }
				            Cell row9cell3 = row9.getCell(6);
				            if (row9cell3 != null) {
				            	row9cell3.setCellValue(BRF92.getR16_other_price_changes() == null ? 0 :
				                	BRF92.getR16_other_price_changes().intValue());
				            }
				            Cell row9cell4 = row9.getCell(7);
				            if (row9cell4 != null) {
				            	row9cell4.setCellValue(BRF92.getR16_other_changes() == null ? 0 :
				                	BRF92.getR16_other_changes().intValue());
				            }
				            Cell row9cell5 = row9.getCell(8);
				            if (row9cell5 != null) {
				            	row9cell5.setCellValue(BRF92.getR16_position_at_end() == null ? 0 :
				                	BRF92.getR16_position_at_end().intValue());
				            }


//////////////////////////////ROW 27///////////////////////
Row row10 = sheet.getRow(27);
				            Cell row10cell = row10.getCell(3);
				            if (row10cell != null) {
				            	row10cell.setCellValue(BRF92.getR19_position_at_begin() == null ? 0 :
				                	BRF92.getR19_position_at_begin().intValue());
				            }
				            Cell row10cell1 = row10.getCell(4);
				            if (row10cell1 != null) {
				            	row10cell1.setCellValue(BRF92.getR19_financial_acc_changes() == null ? 0 :
				                	BRF92.getR19_financial_acc_changes().intValue());
				            }
				            Cell row10cell2 = row10.getCell(5);
				            if (row10cell2 != null) {
				            	row10cell2.setCellValue(BRF92.getR19_exchange_rate_changes() == null ? 0 :
				                	BRF92.getR19_exchange_rate_changes().intValue());
				            }
				            Cell row10cell3 = row10.getCell(6);
				            if (row10cell3 != null) {
				            	row10cell3.setCellValue(BRF92.getR19_other_price_changes() == null ? 0 :
				                	BRF92.getR19_other_price_changes().intValue());
				            }
				            Cell row10cell4 = row10.getCell(7);
				            if (row10cell4 != null) {
				            	row10cell4.setCellValue(BRF92.getR19_other_changes() == null ? 0 :
				                	BRF92.getR19_other_changes().intValue());
				            }
				            Cell row10cell5 = row10.getCell(8);
				            if (row10cell5 != null) {
				            	row10cell5.setCellValue(BRF92.getR19_position_at_end() == null ? 0 :
				                	BRF92.getR19_position_at_end().intValue());
				            }


//////////////////////////////ROW 28///////////////////////
Row row11 = sheet.getRow(28);
				            Cell row11cell = row11.getCell(3);
				            if (row11cell != null) {
				            	row11cell.setCellValue(BRF92.getR20_position_at_begin() == null ? 0 :
				                	BRF92.getR20_position_at_begin().intValue());
				            }
				            Cell row11cell1 = row11.getCell(4);
				            if (row11cell1 != null) {
				            	row11cell1.setCellValue(BRF92.getR20_financial_acc_changes() == null ? 0 :
				                	BRF92.getR20_financial_acc_changes().intValue());
				            }
				            Cell row11cell2 = row11.getCell(5);
				            if (row11cell2 != null) {
				            	row11cell2.setCellValue(BRF92.getR20_exchange_rate_changes() == null ? 0 :
				                	BRF92.getR20_exchange_rate_changes().intValue());
				            }
				            Cell row11cell3 = row11.getCell(6);
				            if (row11cell3 != null) {
				            	row11cell3.setCellValue(BRF92.getR20_other_price_changes() == null ? 0 :
				                	BRF92.getR20_other_price_changes().intValue());
				            }
				            Cell row11cell4 = row11.getCell(7);
				            if (row11cell4 != null) {
				            	row11cell4.setCellValue(BRF92.getR20_other_changes() == null ? 0 :
				                	BRF92.getR20_other_changes().intValue());
				            }
				            Cell row11cell5 = row11.getCell(8);
				            if (row11cell5 != null) {
				            	row11cell5.setCellValue(BRF92.getR20_position_at_end() == null ? 0 :
				                	BRF92.getR20_position_at_end().intValue());
				            }


//////////////////////////////ROW 30///////////////////////
Row row12 = sheet.getRow(30);
				            Cell row12cell = row12.getCell(3);
				            if (row12cell != null) {
				            	row12cell.setCellValue(BRF92.getR22_position_at_begin() == null ? 0 :
				                	BRF92.getR22_position_at_begin().intValue());
				            }
				            Cell row12cell1 = row12.getCell(4);
				            if (row12cell1 != null) {
				            	row12cell1.setCellValue(BRF92.getR22_financial_acc_changes() == null ? 0 :
				                	BRF92.getR22_financial_acc_changes().intValue());
				            }
				            Cell row12cell2 = row12.getCell(5);
				            if (row12cell2 != null) {
				            	row12cell2.setCellValue(BRF92.getR22_exchange_rate_changes() == null ? 0 :
				                	BRF92.getR22_exchange_rate_changes().intValue());
				            }
				            Cell row12cell3 = row12.getCell(6);
				            if (row12cell3 != null) {
				            	row12cell3.setCellValue(BRF92.getR22_other_price_changes() == null ? 0 :
				                	BRF92.getR22_other_price_changes().intValue());
				            }
				            Cell row12cell4 = row12.getCell(7);
				            if (row12cell4 != null) {
				            	row12cell4.setCellValue(BRF92.getR22_other_changes() == null ? 0 :
				                	BRF92.getR22_other_changes().intValue());
				            }
				            Cell row12cell5 = row12.getCell(8);
				            if (row12cell5 != null) {
				            	row12cell5.setCellValue(BRF92.getR22_position_at_end() == null ? 0 :
				                	BRF92.getR22_position_at_end().intValue());
				            }


//////////////////////////////ROW 31///////////////////////
Row row13 = sheet.getRow(31);
				            Cell row13cell = row13.getCell(3);
				            if (row13cell != null) {
				            	row13cell.setCellValue(BRF92.getR23_position_at_begin() == null ? 0 :
				                	BRF92.getR23_position_at_begin().intValue());
				            }
				            Cell row13cell1 = row13.getCell(4);
				            if (row13cell1 != null) {
				            	row13cell1.setCellValue(BRF92.getR23_financial_acc_changes() == null ? 0 :
				                	BRF92.getR23_financial_acc_changes().intValue());
				            }
				            Cell row13cell2 = row13.getCell(5);
				            if (row13cell2 != null) {
				            	row13cell2.setCellValue(BRF92.getR23_exchange_rate_changes() == null ? 0 :
				                	BRF92.getR23_exchange_rate_changes().intValue());
				            }
				            Cell row13cell3 = row13.getCell(6);
				            if (row13cell3 != null) {
				            	row13cell3.setCellValue(BRF92.getR23_other_price_changes() == null ? 0 :
				                	BRF92.getR23_other_price_changes().intValue());
				            }
				            Cell row13cell4 = row13.getCell(7);
				            if (row13cell4 != null) {
				            	row13cell4.setCellValue(BRF92.getR23_other_changes() == null ? 0 :
				                	BRF92.getR23_other_changes().intValue());
				            }
				            Cell row13cell5 = row13.getCell(8);
				            if (row13cell5 != null) {
				            	row13cell5.setCellValue(BRF92.getR23_position_at_end() == null ? 0 :
				                	BRF92.getR23_position_at_end().intValue());
				            }


//////////////////////////////ROW 32///////////////////////
Row row14 = sheet.getRow(32);
				            Cell row14cell = row14.getCell(3);
				            if (row14cell != null) {
				            	row14cell.setCellValue(BRF92.getR24_position_at_begin() == null ? 0 :
				                	BRF92.getR24_position_at_begin().intValue());
				            }
				            Cell row14cell1 = row14.getCell(4);
				            if (row14cell1 != null) {
				            	row14cell1.setCellValue(BRF92.getR24_financial_acc_changes() == null ? 0 :
				                	BRF92.getR24_financial_acc_changes().intValue());
				            }
				            Cell row14cell2 = row14.getCell(5);
				            if (row14cell2 != null) {
				            	row14cell2.setCellValue(BRF92.getR24_exchange_rate_changes() == null ? 0 :
				                	BRF92.getR24_exchange_rate_changes().intValue());
				            }
				            Cell row14cell3 = row14.getCell(6);
				            if (row14cell3 != null) {
				            	row14cell3.setCellValue(BRF92.getR24_other_price_changes() == null ? 0 :
				                	BRF92.getR24_other_price_changes().intValue());
				            }
				            Cell row14cell4 = row14.getCell(7);
				            if (row14cell4 != null) {
				            	row14cell4.setCellValue(BRF92.getR24_other_changes() == null ? 0 :
				                	BRF92.getR24_other_changes().intValue());
				            }
				            Cell row14cell5 = row14.getCell(8);
				            if (row14cell5 != null) {
				            	row14cell5.setCellValue(BRF92.getR24_position_at_end() == null ? 0 :
				                	BRF92.getR24_position_at_end().intValue());
				            }


//////////////////////////////ROW 35///////////////////////
Row row15 = sheet.getRow(35);
				            Cell row15cell = row15.getCell(3);
				            if (row15cell != null) {
				            	row15cell.setCellValue(BRF92.getR27_position_at_begin() == null ? 0 :
				                	BRF92.getR27_position_at_begin().intValue());
				            }
				            Cell row15cell1 = row15.getCell(4);
				            if (row15cell1 != null) {
				            	row15cell1.setCellValue(BRF92.getR27_financial_acc_changes() == null ? 0 :
				                	BRF92.getR27_financial_acc_changes().intValue());
				            }
				            Cell row15cell2 = row15.getCell(5);
				            if (row15cell2 != null) {
				            	row15cell2.setCellValue(BRF92.getR27_exchange_rate_changes() == null ? 0 :
				                	BRF92.getR27_exchange_rate_changes().intValue());
				            }
				            Cell row15cell3 = row15.getCell(6);
				            if (row15cell3 != null) {
				            	row15cell3.setCellValue(BRF92.getR27_other_price_changes() == null ? 0 :
				                	BRF92.getR27_other_price_changes().intValue());
				            }
				            Cell row15cell4 = row15.getCell(7);
				            if (row15cell4 != null) {
				            	row15cell4.setCellValue(BRF92.getR27_other_changes() == null ? 0 :
				                	BRF92.getR27_other_changes().intValue());
				            }
				            Cell row15cell5 = row15.getCell(8);
				            if (row15cell5 != null) {
				            	row15cell5.setCellValue(BRF92.getR27_position_at_end() == null ? 0 :
				                	BRF92.getR27_position_at_end().intValue());
				            }


//////////////////////////////ROW 36///////////////////////
Row row16 = sheet.getRow(36);
				            Cell row16cell = row16.getCell(3);
				            if (row16cell != null) {
				            	row16cell.setCellValue(BRF92.getR28_position_at_begin() == null ? 0 :
				                	BRF92.getR28_position_at_begin().intValue());
				            }
				            Cell row16cell1 = row16.getCell(4);
				            if (row16cell1 != null) {
				            	row16cell1.setCellValue(BRF92.getR28_financial_acc_changes() == null ? 0 :
				                	BRF92.getR28_financial_acc_changes().intValue());
				            }
				            Cell row16cell2 = row16.getCell(5);
				            if (row16cell2 != null) {
				            	row16cell2.setCellValue(BRF92.getR28_exchange_rate_changes() == null ? 0 :
				                	BRF92.getR28_exchange_rate_changes().intValue());
				            }
				            Cell row16cell3 = row16.getCell(6);
				            if (row16cell3 != null) {
				            	row16cell3.setCellValue(BRF92.getR28_other_price_changes() == null ? 0 :
				                	BRF92.getR28_other_price_changes().intValue());
				            }
				            Cell row16cell4 = row16.getCell(7);
				            if (row16cell4 != null) {
				            	row16cell4.setCellValue(BRF92.getR28_other_changes() == null ? 0 :
				                	BRF92.getR28_other_changes().intValue());
				            }
				            Cell row16cell5 = row16.getCell(8);
				            if (row16cell5 != null) {
				            	row16cell5.setCellValue(BRF92.getR28_position_at_end() == null ? 0 :
				                	BRF92.getR28_position_at_end().intValue());
				            }


//////////////////////////////ROW 38///////////////////////
Row row17 = sheet.getRow(38);
				            Cell row17cell = row17.getCell(3);
				            if (row17cell != null) {
				            	row17cell.setCellValue(BRF92.getR30_position_at_begin() == null ? 0 :
				                	BRF92.getR30_position_at_begin().intValue());
				            }
				            Cell row17cell1 = row17.getCell(4);
				            if (row17cell1 != null) {
				            	row17cell1.setCellValue(BRF92.getR30_financial_acc_changes() == null ? 0 :
				                	BRF92.getR30_financial_acc_changes().intValue());
				            }
				            Cell row17cell2 = row17.getCell(5);
				            if (row17cell2 != null) {
				            	row17cell2.setCellValue(BRF92.getR30_exchange_rate_changes() == null ? 0 :
				                	BRF92.getR30_exchange_rate_changes().intValue());
				            }
				            Cell row17cell3 = row17.getCell(6);
				            if (row17cell3 != null) {
				            	row17cell3.setCellValue(BRF92.getR30_other_price_changes() == null ? 0 :
				                	BRF92.getR30_other_price_changes().intValue());
				            }
				            Cell row17cell4 = row17.getCell(7);
				            if (row17cell4 != null) {
				            	row17cell4.setCellValue(BRF92.getR30_other_changes() == null ? 0 :
				                	BRF92.getR30_other_changes().intValue());
				            }
				            Cell row17cell5 = row17.getCell(8);
				            if (row17cell5 != null) {
				            	row17cell5.setCellValue(BRF92.getR30_position_at_end() == null ? 0 :
				                	BRF92.getR30_position_at_end().intValue());
				            }


//////////////////////////////ROW 39///////////////////////
Row row18 = sheet.getRow(39);
				            Cell row18cell = row18.getCell(3);
				            if (row18cell != null) {
				            	row18cell.setCellValue(BRF92.getR31_position_at_begin() == null ? 0 :
				                	BRF92.getR31_position_at_begin().intValue());
				            }
				            Cell row18cell1 = row18.getCell(4);
				            if (row18cell1 != null) {
				            	row18cell1.setCellValue(BRF92.getR31_financial_acc_changes() == null ? 0 :
				                	BRF92.getR31_financial_acc_changes().intValue());
				            }
				            Cell row18cell2 = row18.getCell(5);
				            if (row18cell2 != null) {
				            	row18cell2.setCellValue(BRF92.getR31_exchange_rate_changes() == null ? 0 :
				                	BRF92.getR31_exchange_rate_changes().intValue());
				            }
				            Cell row18cell3 = row18.getCell(6);
				            if (row18cell3 != null) {
				            	row18cell3.setCellValue(BRF92.getR31_other_price_changes() == null ? 0 :
				                	BRF92.getR31_other_price_changes().intValue());
				            }
				            Cell row18cell4 = row18.getCell(7);
				            if (row18cell4 != null) {
				            	row18cell4.setCellValue(BRF92.getR31_other_changes() == null ? 0 :
				                	BRF92.getR31_other_changes().intValue());
				            }
				            Cell row18cell5 = row18.getCell(8);
				            if (row18cell5 != null) {
				            	row18cell5.setCellValue(BRF92.getR31_position_at_end() == null ? 0 :
				                	BRF92.getR31_position_at_end().intValue());
				            }


//////////////////////////////ROW 40///////////////////////
Row row19 = sheet.getRow(40);
				            Cell row19cell = row19.getCell(3);
				            if (row19cell != null) {
				            	row19cell.setCellValue(BRF92.getR32_position_at_begin() == null ? 0 :
				                	BRF92.getR32_position_at_begin().intValue());
				            }
				            Cell row19cell1 = row19.getCell(4);
				            if (row19cell1 != null) {
				            	row19cell1.setCellValue(BRF92.getR32_financial_acc_changes() == null ? 0 :
				                	BRF92.getR32_financial_acc_changes().intValue());
				            }
				            Cell row19cell2 = row19.getCell(5);
				            if (row19cell2 != null) {
				            	row19cell2.setCellValue(BRF92.getR32_exchange_rate_changes() == null ? 0 :
				                	BRF92.getR32_exchange_rate_changes().intValue());
				            }
				            Cell row19cell3 = row19.getCell(6);
				            if (row19cell3 != null) {
				            	row19cell3.setCellValue(BRF92.getR32_other_price_changes() == null ? 0 :
				                	BRF92.getR32_other_price_changes().intValue());
				            }
				            Cell row19cell4 = row19.getCell(7);
				            if (row19cell4 != null) {
				            	row19cell4.setCellValue(BRF92.getR32_other_changes() == null ? 0 :
				                	BRF92.getR32_other_changes().intValue());
				            }
				            Cell row19cell5 = row19.getCell(8);
				            if (row19cell5 != null) {
				            	row19cell5.setCellValue(BRF92.getR32_position_at_end() == null ? 0 :
				                	BRF92.getR32_position_at_end().intValue());
				            }


//////////////////////////////ROW 46///////////////////////
Row row20 = sheet.getRow(46);
				            Cell row20cell = row20.getCell(3);
				            if (row20cell != null) {
				            	row20cell.setCellValue(BRF92.getR34_q1() == null ? 0 :
				                	BRF92.getR34_q1().intValue());
				            }
				            Cell row20cell1 = row20.getCell(4);
				            if (row20cell1 != null) {
				            	row20cell1.setCellValue(BRF92.getR34_q2() == null ? 0 :
				                	BRF92.getR34_q2().intValue());
				            }
				            Cell row20cell2 = row20.getCell(5);
				            if (row20cell2 != null) {
				            	row20cell2.setCellValue(BRF92.getR34_q3() == null ? 0 :
				                	BRF92.getR34_q3().intValue());
				            }
				            Cell row20cell3 = row20.getCell(6);
				            if (row20cell3 != null) {
				            	row20cell3.setCellValue(BRF92.getR34_q4() == null ? 0 :
				                	BRF92.getR34_q4().intValue());
				            }
				           


//////////////////////////////ROW 47///////////////////////
Row row21 = sheet.getRow(47);
				            Cell row21cell = row21.getCell(3);
				            if (row21cell != null) {
				            	row21cell.setCellValue(BRF92.getR35_q1() == null ? 0 :
				                	BRF92.getR35_q1().intValue());
				            }
				            Cell row21cell1 = row21.getCell(4);
				            if (row21cell1 != null) {
				            	row21cell1.setCellValue(BRF92.getR35_q2() == null ? 0 :
				                	BRF92.getR35_q2().intValue());
				            }
				            Cell row21cell2 = row21.getCell(5);
				            if (row21cell2 != null) {
				            	row21cell2.setCellValue(BRF92.getR35_q3() == null ? 0 :
				                	BRF92.getR35_q3().intValue());
				            }
				            Cell row21cell3 = row21.getCell(6);
				            if (row21cell3 != null) {
				            	row21cell3.setCellValue(BRF92.getR35_q4() == null ? 0 :
				                	BRF92.getR35_q4().intValue());
				            }
				           


//////////////////////////////ROW 48///////////////////////
Row row22 = sheet.getRow(48);
				            Cell row22cell = row22.getCell(3);
				            if (row22cell != null) {
				            	row22cell.setCellValue(BRF92.getR36_q1() == null ? 0 :
				                	BRF92.getR36_q1().intValue());
				            }
				            Cell row22cell1 = row22.getCell(4);
				            if (row22cell1 != null) {
				            	row22cell1.setCellValue(BRF92.getR36_q2() == null ? 0 :
				                	BRF92.getR36_q2().intValue());
				            }
				            Cell row22cell2 = row22.getCell(5);
				            if (row22cell2 != null) {
				            	row22cell2.setCellValue(BRF92.getR36_q3() == null ? 0 :
				                	BRF92.getR36_q3().intValue());
				            }
				            Cell row22cell3 = row22.getCell(6);
				            if (row22cell3 != null) {
				            	row22cell3.setCellValue(BRF92.getR36_q4() == null ? 0 :
				                	BRF92.getR36_q4().intValue());
				            }
				           


//////////////////////////////ROW 50///////////////////////
Row row23 = sheet.getRow(50);
				            Cell row23cell = row23.getCell(3);
				            if (row23cell != null) {
				            	row23cell.setCellValue(BRF92.getR38_q1() == null ? 0 :
				                	BRF92.getR38_q1().intValue());
				            }
				            Cell row23cell1 = row23.getCell(4);
				            if (row23cell1 != null) {
				            	row23cell1.setCellValue(BRF92.getR38_q2() == null ? 0 :
				                	BRF92.getR38_q2().intValue());
				            }
				            Cell row23cell2 = row23.getCell(5);
				            if (row23cell2 != null) {
				            	row23cell2.setCellValue(BRF92.getR38_q3() == null ? 0 :
				                	BRF92.getR38_q3().intValue());
				            }
				            Cell row23cell3 = row23.getCell(6);
				            if (row23cell3 != null) {
				            	row23cell3.setCellValue(BRF92.getR38_q4() == null ? 0 :
				                	BRF92.getR38_q4().intValue());
				            }
				           


//////////////////////////////ROW 51///////////////////////
Row row24 = sheet.getRow(51);
				            Cell row24cell = row24.getCell(3);
				            if (row24cell != null) {
				            	row24cell.setCellValue(BRF92.getR39_q1() == null ? 0 :
				                	BRF92.getR39_q1().intValue());
				            }
				            Cell row24cell1 = row24.getCell(4);
				            if (row24cell1 != null) {
				            	row24cell1.setCellValue(BRF92.getR39_q2() == null ? 0 :
				                	BRF92.getR39_q2().intValue());
				            }
				            Cell row24cell2 = row24.getCell(5);
				            if (row24cell2 != null) {
				            	row24cell2.setCellValue(BRF92.getR39_q3() == null ? 0 :
				                	BRF92.getR39_q3().intValue());
				            }
				            Cell row24cell3 = row24.getCell(6);
				            if (row24cell3 != null) {
				            	row24cell3.setCellValue(BRF92.getR39_q4() == null ? 0 :
				                	BRF92.getR39_q4().intValue());
				            }
				           


//////////////////////////////ROW 52///////////////////////
Row row25 = sheet.getRow(52);
				            Cell row25cell = row25.getCell(3);
				            if (row25cell != null) {
				            	row25cell.setCellValue(BRF92.getR40_q1() == null ? 0 :
				                	BRF92.getR40_q1().intValue());
				            }
				            Cell row25cell1 = row25.getCell(4);
				            if (row25cell1 != null) {
				            	row25cell1.setCellValue(BRF92.getR40_q2() == null ? 0 :
				                	BRF92.getR40_q2().intValue());
				            }
				            Cell row25cell2 = row25.getCell(5);
				            if (row25cell2 != null) {
				            	row25cell2.setCellValue(BRF92.getR40_q3() == null ? 0 :
				                	BRF92.getR40_q3().intValue());
				            }
				            Cell row25cell3 = row25.getCell(6);
				            if (row25cell3 != null) {
				            	row25cell3.setCellValue(BRF92.getR40_q4() == null ? 0 :
				                	BRF92.getR40_q4().intValue());
				            }
				           


//////////////////////////////ROW 57///////////////////////
Row row26 = sheet.getRow(57);
				            Cell row26cell = row26.getCell(3);
				            if (row26cell != null) {
				            	row26cell.setCellValue(BRF92.getR41_q1() == null ? 0 :
				                	BRF92.getR41_q1().intValue());
				            }
				            Cell row26cell1 = row26.getCell(4);
				            if (row26cell1 != null) {
				            	row26cell1.setCellValue(BRF92.getR41_q2() == null ? 0 :
				                	BRF92.getR41_q2().intValue());
				            }
				            Cell row26cell2 = row26.getCell(5);
				            if (row26cell2 != null) {
				            	row26cell2.setCellValue(BRF92.getR41_q3() == null ? 0 :
				                	BRF92.getR41_q3().intValue());
				            }
				            Cell row26cell3 = row26.getCell(6);
				            if (row26cell3 != null) {
				            	row26cell3.setCellValue(BRF92.getR41_q4() == null ? 0 :
				                	BRF92.getR41_q4().intValue());
				            }
				           
				            
				            
				            // Save the changes
				            workbook.getCreationHelper().createFormulaEvaluator().evaluateAll();
				            FileOutputStream fileOut = new FileOutputStream(env.getProperty("output.exportpathfinal")+"011-BRF-092-A.xls");
				            workbook.write(fileOut);
				            fileOut.close();
				            System.out.println(fileOut);
				            path= fileOut.toString();
				            // Close the workbook
				            System.out.println("PATH : "+path);
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
							
							

							
						}////else end

					}
					outputFile = new File(env.getProperty("output.exportpathfinal")+"011-BRF-092-A.xls");

					return outputFile;
				
				
				
				}



	public String detailChanges92(BRF92_DETAIL_ENTITY detail, String foracid, String report_addl_criteria_1,
			BigDecimal act_balance_amt_lc, String report_label_1, String report_name_1) {

		String msg = "";

		try {

			Session hs = sessionFactory.getCurrentSession();
			Optional<BRF92_DETAIL_ENTITY> Brf92detail = brf92_detailrepo.findById(foracid);

			if (Brf92detail.isPresent()) {
				BRF92_DETAIL_ENTITY BRFdetail = Brf92detail.get();

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
					brf92_detailrepo.save(BRFdetail);

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


	
	
	
	public ModelAndView getArchieveBRF092View(String reportId, String fromdate, String todate, String currency,
		String dtltype, Pageable pageable) {

	ModelAndView mv = new ModelAndView();
	Session hs = sessionFactory.getCurrentSession();
	int pageSize = pageable.getPageSize();
	int currentPage = pageable.getPageNumber();
	int startItem = currentPage * pageSize;
	List<BRF92_TABLE> T1rep = new ArrayList<BRF92_TABLE>();
	// Query<Object[]> qr;

	List<BRF92_TABLE> T1Master = new ArrayList<BRF92_TABLE>();
	/* List<BRF73_TABLE2> T1Master1 = new ArrayList<BRF73_TABLE2>(); */

	logger.info("Inside archive" + currency);

	try {
		Date d1 = df.parse(todate);
		// T1rep = t1CurProdServiceRepo.getT1CurProdServices(d1);

		T1Master = hs.createQuery("from  BRF92_TABLE a where a.report_date = ?1 ", BRF92_TABLE.class)
				.setParameter(1, df.parse(todate)).getResultList();

		/*
		 * T1Master1 = hs.createQuery("from BRF73_TABLE2 a where a.report_date = ?1 ",
		 * BRF73_TABLE2.class) .setParameter(1, df.parse(todate)).getResultList();
		 */

	} catch (ParseException e) {
		e.printStackTrace();
	}

	// T1rep = t1CurProdServiceRepo.getT1CurProdServices(d1);

	mv.setViewName("RR/BRF92ARCH");
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

public ModelAndView ARCHgetBRF092currentDtl(String reportId, String fromdate, String todate, String currency,
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
			
			
				qr = hs.createNativeQuery("select * from BRF92_ARCHIVTABLE a where report_date=?1 and report_label=?2");
				qr.setParameter(1,  df.parse(todate));
				qr.setParameter(2,filter);
					

		} else {
			System.out.println("2");
			qr = hs.createNativeQuery("select * from BRF92_ARCHIVTABLE");

		}
	} else {
		System.out.println("3");
		qr = hs.createNativeQuery("select * from BRF92_ARCHIVTABLE  where report_date = ?1");
	}

	List<BRF92_ARCHIV_ENTITY> T1Master = new ArrayList<BRF92_ARCHIV_ENTITY>();

	try {
		System.out.println("Values entered");
		T1Master = hs.createQuery("from BRF92_ARCHIV_ENTITY a where a.report_date = ?1", BRF92_ARCHIV_ENTITY.class)
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
		

		BRF92_ARCHIV_ENTITY py = new BRF92_ARCHIV_ENTITY(cust_id, foracid,acct_name, eab_lc, act_balance_amt_lc,  acct_crncy_code, gl_code,
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

	mv.setViewName("RR" + "/" + "BRF92ARCH::reportcontent");
	mv.addObject("reportdetails", T1Dt1Page.getContent());
	mv.addObject("reportmaster", T1Master);
	mv.addObject("reportmaster1", qr);
	mv.addObject("singledetail", new T1CurProdDetail());
	mv.addObject("reportsflag", "reportsflag");
	mv.addObject("menu", reportId);
	return mv;
}

}



