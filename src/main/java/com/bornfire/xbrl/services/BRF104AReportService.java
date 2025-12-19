
package com.bornfire.xbrl.services;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.FileOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
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

import com.bornfire.xbrl.entities.BRF104_ARCHIV_ENTITY;
import com.bornfire.xbrl.entities.BRBS.BRF104_REPORTENTITY;
import com.bornfire.xbrl.entities.BRBS.BRF104_REPORTENTITY;
import com.bornfire.xbrl.entities.BRBS.BRF104_DETAIL_ENTITY;
import com.bornfire.xbrl.entities.BRBS.BRF104_DetailRepo;
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
public class BRF104AReportService {
	private static final Logger logger = LoggerFactory.getLogger(BRF104AReportService.class);

	@Autowired
	SessionFactory sessionFactory;

	@Autowired
	DataSource srcdataSource;
	
	@Autowired
	Environment env;
	

	@Autowired
	BRF104_DetailRepo brf104_detailrepo;
	
	DateFormat df = new SimpleDateFormat("dd-MMM-yyyy");


	public String preCheckBRF104A(String reportid, String fromdate, String todate) {
		
			String msg = "";
			Session hs = sessionFactory.getCurrentSession();
			Date dt1;
			Date dt9;
			logger.info("Report precheck : " + reportid);

			try {
				//dt1 = new SimpleDateFormat("dd/MM/yyyy").parse(fromdate);
				dt9 = new SimpleDateFormat("dd/MM/yyyy").parse(todate);
				logger.info("Getting No of records in Master table :" + reportid);
				Long dtlcnt = (Long) hs.createQuery("select count(*) from BRF104_REPORTENTITY a where a.report_date=?1")
						.setParameter(1, dt9).getSingleResult();

				if (dtlcnt > 0) {
					logger.info("Getting No of records in Mod table :" + reportid);
					Long modcnt = (Long) hs.createQuery("select count(*) from BRF104_REPORTENTITY a ").getSingleResult();
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


	public ModelAndView getBRF104AView(String reportId, String fromdate, String todate, String currency, String dtltype,
			Pageable pageable) {

		ModelAndView mv = new ModelAndView();

		Session hs = sessionFactory.getCurrentSession();
		int pageSize = pageable.getPageSize();
		int currentPage = pageable.getPageNumber();
		int startItem = currentPage * pageSize;
		List<BRF104_REPORTENTITY> T1rep = new ArrayList<BRF104_REPORTENTITY>();
		// Query<Object[]> qr;

		List<BRF104_REPORTENTITY> T1Master = new ArrayList<BRF104_REPORTENTITY>();

		logger.info("Inside archive" +currency);

		try {
			
			
			Date d1 = df.parse(todate);
		//	T1rep = t1CurProdServiceRepo.getT1CurProdServices(d1);

			T1Master = hs.createQuery("from BRF104_REPORTENTITY a where a.report_date = ?1 ", BRF104_REPORTENTITY.class)
					.setParameter(1, df.parse(todate)).getResultList();

		} catch (ParseException e) {
			e.printStackTrace();
		}

		// T1rep = t1CurProdServiceRepo.getT1CurProdServices(d1);

		mv.setViewName("RR/BRF104A");
		// mv.addObject("currlist", refCodeConfig.currList());
		mv.addObject("reportsummary", T1Master);
		mv.addObject("reportmaster", T1Master);
		mv.addObject("displaymode", "summary");
		mv.addObject("reportsflag", "reportsflag");
		mv.addObject("menu", reportId);
		System.out.println("scv" + mv.getViewName());

		return mv;

	}
	public ModelAndView getBRF104ADetails(String reportId, String fromdate, String todate, String currency,
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
                qr = hs.createNativeQuery("select * from BRF104A_DETAILTABLE");
                //qr.setParameter(2, filter);
            } else {
                qr = hs.createNativeQuery("select * from BRF104A_DETAILTABLE");
            }
        } else {
            qr = hs.createNativeQuery("select * from BRF104A_DETAILTABLE  where report_date = ?1");
        }
        List<BRF104_DETAIL_ENTITY> T1Master = new ArrayList<BRF104_DETAIL_ENTITY>();
 
        try {
            T1Master = hs.createQuery("from BRF104_DETAIL_ENTITY a where a.report_date = ?1", BRF104_DETAIL_ENTITY.class)
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
			

			BRF104_DETAIL_ENTITY py = new BRF104_DETAIL_ENTITY(cust_id, foracid,acct_name, eab_lc, act_balance_amt_lc,  acct_crncy_code, gl_code,
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

		mv.setViewName("RR"+"/"+"BRF104A::reportcontent");
		// mv.setViewName("ReportT1");
		mv.addObject("reportdetails", T1Dt1Page);
		mv.addObject("reportmaster", T1Master);
		mv.addObject("singledetail", new T1CurProdDetail());
		mv.addObject("reportsflag", "reportsflag");
		mv.addObject("menu", reportId);
		return mv;
	}


	
	public File getFileBRF104A(String reportId, String fromdate, String todate, String currency, String dtltype,
			String filetype) throws FileNotFoundException, JRException, SQLException {

		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

		String path = this.env.getProperty("output.exportpath");
		String fileName = "";
		String zipFileName = "";
		File outputFile;

		logger.info("Getting Output file :" + reportId);
		fileName = "011-BRF-104-A";
		/*try {
			SimpleDateFormat dateFormat1 = new SimpleDateFormat("dd-MM-yyyy");
			Date ConDate = dateFormat1.parse(todate);
			System.out.println(ConDate);
			SimpleDateFormat formatter1 = new SimpleDateFormat("dd-MM-yyyy");
			String strDate1 = formatter1.format(ConDate);
			fileName = "t" + reportId + "_" + strDate1;
			

		} catch (ParseException e1) {

			logger.info(e1.getMessage());
			e1.printStackTrace();
		}*/

		if (!filetype.equals("xbrl")) {
			if(!filetype.equals("BRF")) {
			try {
				InputStream jasperFile;
				logger.info("Getting Jasper file :" + reportId);
				if (filetype.equals("detailexcel")) {
					if (dtltype.equals("report")) {

						jasperFile = this.getClass().getResourceAsStream("/static/jasper/BRF104_Detail.jrxml");
					} else {
						jasperFile = this.getClass().getResourceAsStream("/static/jasper/BRF104_Detail.jrxml");
					}

				} else {
					if (dtltype.equals("report")) {
						logger.info("Inside report");
						jasperFile = this.getClass().getResourceAsStream("/static/jasper/BRF104.jrxml");
					} else {
						jasperFile = this.getClass().getResourceAsStream("/static/jasper/BRF104.jrxml");
					}
				}

				//JasperReport jr = (JasperReport) JRLoader.loadObject(jasperFile);
				JasperReport jr
				  = JasperCompileManager.compileReport(jasperFile);
				HashMap<String, Object> map = new HashMap<String, Object>();

				logger.info("Assigning Parameters for Jasper");
				map.put("REPORT_DATE", todate);
			/*	try {
					SimpleDateFormat dateFormat1 = new SimpleDateFormat("dd-MM-yyyy");
					Date ConDate = dateFormat1.parse(todate);
					SimpleDateFormat formatter1 = new SimpleDateFormat("dd-MMM-yyyy");
					String strDate1 = formatter1.format(ConDate);

					String today = dateFormat.format(new SimpleDateFormat("dd-MMM-yyyy").parse(strDate1));
					
				} catch (ParseException e1) {

					logger.info(e1.getMessage());
					e1.printStackTrace();
				}
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
		}
			else {
				
				List<BRF104_REPORTENTITY> T1Master = new ArrayList<BRF104_REPORTENTITY>();
				Session hs = sessionFactory.getCurrentSession();
				try {
					Date d1 = df.parse(todate);
				
				// T1rep = t1CurProdServiceRepo.getT1CurProdServices(d1);

				T1Master = hs.createQuery("from  BRF104_REPORTENTITY a where a.report_date = ?1 ", BRF104_REPORTENTITY.class)
						.setParameter(1, df.parse(todate)).getResultList();
				
				if(T1Master.size() == 1) {
					
					for(BRF104_REPORTENTITY BRF104 : T1Master ) {
				
				File Responsecamt = new File(env.getProperty("output.exportpathtemp")+"011-BRF-104-AT.xls");
				
				  // Load the Excel file
		    	Workbook workbook = WorkbookFactory.create(Responsecamt);

		        // Get the first sheet
		    	Sheet sheet = workbook.getSheetAt(0);
		    	
		    /////srl_no -9/////////
		    	Row row1 = sheet.getRow(8);
				Cell R1cell = row1.getCell(2);
				 if (R1cell != null) {
				   String value = (BRF104.getR1_BORROWERS_NAME() == null) ? "NA" : BRF104.getR1_BORROWERS_NAME().toString();
				   R1cell.setCellValue(value);
				   }
				   
				   Cell R1cell1 = row1.getCell(3);
				 if (R1cell1 != null) {
				   String value = (BRF104.getR1_CIN() == null) ? "NA" : BRF104.getR1_CIN().toString();
				   R1cell1.setCellValue(value);
				}
				 Cell R1cell2 = row1.getCell(4);
				 if (R1cell2 != null) {
				   String value = (BRF104.getR1_DISTRESSED() == null) ? "NA" : BRF104.getR1_DISTRESSED().toString();
				   R1cell2.setCellValue(value);
				}
		    	Cell R1cell3 = row1.getCell(5);
				 if (R1cell3 != null) {
				   String value = (BRF104.getR1_CURRENT_BANK_INTERNAL_RATING() == null) ? "NA" : BRF104.getR1_CURRENT_BANK_INTERNAL_RATING().toString();
				   R1cell3.setCellValue(value);
				 }
				 
				 Cell R1cell4 = row1.getCell(6);
				 if (R1cell4 != null) {
				   String value = (BRF104.getR1_IFRS_9_STAGE() == null) ? "NA" : BRF104.getR1_IFRS_9_STAGE().toString();
				   R1cell4.setCellValue(value);
				   }
				 Cell R1cell5 = row1.getCell(7);
				 if (R1cell5 != null) {
				     Date dateValue =BRF104.getR1_DATE_OF_RESTRUCTURE (); // Assuming this returns a Date object
				     SimpleDateFormat DateFormat = new SimpleDateFormat("dd/MM/yyyy"); // Specify your desired date format
				     String formattedDate = (dateValue == null) ? "NA" : DateFormat.format(dateValue);
				     R1cell5.setCellValue(formattedDate);
				 }
				 
		    	Cell R1cell6 = row1.getCell(8);
		    	if (R1cell6 != null) {
		    	R1cell6.setCellValue(BRF104.getR1_NUMBER_OF_TIME_RESTRUCTURED() == null ? 0 :
		    	BRF104.getR1_NUMBER_OF_TIME_RESTRUCTURED().intValue());
		    	}
				
				 Cell R1cell7 = row1.getCell(9);
				 if (R1cell7 != null) {
				     Date dateValue =BRF104.getR1_DATE_OF_PREVIOUS_RESTRUCTURE (); // Assuming this returns a Date object
				     SimpleDateFormat DateFormat = new SimpleDateFormat("dd/MM/yyyy"); // Specify your desired date format
				     String formattedDate = (dateValue == null) ? "NA" : DateFormat.format(dateValue);
				     R1cell7.setCellValue(formattedDate);
				 }
				
				Cell R1cell8 = row1.getCell(10);
				 if (R1cell8 != null) {
				   String value = (BRF104.getR1_FUNDED_EXPOSURE() == null) ? "0" : BRF104.getR1_FUNDED_EXPOSURE().toString();
				   R1cell8.setCellValue(value);
				 }
				 
				 Cell R1cell9 = row1.getCell(11);
				 if (R1cell9 != null) {
				   String value = (BRF104.getR1_UNFUNDED_EXPOSURE() == null) ? "NA" : BRF104.getR1_UNFUNDED_EXPOSURE().toString();
				   R1cell9.setCellValue(value);
				 }
				 
				 Cell R1cell10 = row1.getCell(12);
				 if (R1cell10 != null) {
				   String value = (BRF104.getR1_REPAYMENT_AMOUNT() == null) ? "NA" : BRF104.getR1_REPAYMENT_AMOUNT().toString();
				   R1cell10.setCellValue(value);
				 }
				 
				 Cell R1cell11 = row1.getCell(13);
		    	if (R1cell11 != null) {
		    	R1cell11.setCellValue(BRF104.getR1_LEGACY_INTEREST() == null ? 0 :
		    	BRF104.getR1_LEGACY_INTEREST().intValue());
		    	} 
				 
				 
		    	Cell R1cell12 = row1.getCell(14);
		    	if (R1cell12 != null) {
		    	R1cell12.setCellValue(BRF104.getR1_PROVISION_INTEREST() == null ? 0 :
		    	BRF104.getR1_PROVISION_INTEREST().intValue());
		    	}
		    	Cell R1cell13 = row1.getCell(15);
		    	if (R1cell13 != null) {
		    	R1cell13.setCellValue(BRF104.getR1_SPECIFIC_PROVISION() == null ? 0 :
		    	BRF104.getR1_SPECIFIC_PROVISION().intValue());
		    	}
		    	
		    /////srl_no -10/////////
		    	Row row2 = sheet.getRow(9);
		    
				Cell R2cell = row1.getCell(2);
				 if (R2cell != null) {
				   String value = (BRF104.getR2_BORROWERS_NAME() == null) ? "NA" : BRF104.getR2_BORROWERS_NAME().toString();
				   R2cell.setCellValue(value);
				   }
				   
				   Cell R2cell1 = row1.getCell(3);
				 if (R2cell1 != null) {
				   String value = (BRF104.getR2_CIN() == null) ? "NA" : BRF104.getR2_CIN().toString();
				   R2cell1.setCellValue(value);
				}
				 Cell R2cell2 = row1.getCell(4);
				 if (R2cell2 != null) {
				   String value = (BRF104.getR2_DISTRESSED() == null) ? "NA" : BRF104.getR2_DISTRESSED().toString();
				   R2cell2.setCellValue(value);
				}
		    	Cell R2cell3 = row1.getCell(5);
				 if (R2cell3 != null) {
				   String value = (BRF104.getR2_CURRENT_BANK_INTERNAL_RATING() == null) ? "NA" : BRF104.getR2_CURRENT_BANK_INTERNAL_RATING().toString();
				   R2cell3.setCellValue(value);
				 }
				 
				 Cell R2cell4 = row1.getCell(6);
				 if (R2cell4 != null) {
				   String value = (BRF104.getR2_IFRS_9_STAGE() == null) ? "NA" : BRF104.getR2_IFRS_9_STAGE().toString();
				   R2cell4.setCellValue(value);
				   }
				 Cell R2cell5 = row1.getCell(7);
				 if (R2cell5 != null) {
				     Date dateValue =BRF104.getR2_DATE_OF_RESTRUCTURE (); // Assuming this returns a Date object
				     SimpleDateFormat DateFormat = new SimpleDateFormat("dd/MM/yyyy"); // Specify your desired date format
				     String formattedDate = (dateValue == null) ? "NA" : DateFormat.format(dateValue);
				     R2cell5.setCellValue(formattedDate);
				 }
				 
		    	Cell R2cell6 = row1.getCell(8);
		    	if (R2cell6 != null) {
		    	R2cell6.setCellValue(BRF104.getR2_NUMBER_OF_TIME_RESTRUCTURED() == null ? 0 :
		    	BRF104.getR2_NUMBER_OF_TIME_RESTRUCTURED().intValue());
		    	}
				
				 Cell R2cell7 = row1.getCell(9);
				 if (R2cell7 != null) {
				     Date dateValue =BRF104.getR2_DATE_OF_PREVIOUS_RESTRUCTURE (); // Assuming this returns a Date object
				     SimpleDateFormat DateFormat = new SimpleDateFormat("dd/MM/yyyy"); // Specify your desired date format
				     String formattedDate = (dateValue == null) ? "NA" : DateFormat.format(dateValue);
				     R2cell7.setCellValue(formattedDate);
				 }
				
				Cell R2cell8 = row1.getCell(10);
				 if (R2cell8 != null) {
				   String value = (BRF104.getR2_FUNDED_EXPOSURE() == null) ? "0" : BRF104.getR2_FUNDED_EXPOSURE().toString();
				   R2cell8.setCellValue(value);
				 }
				 
				 Cell R2cell9 = row1.getCell(11);
				 if (R2cell9 != null) {
				   String value = (BRF104.getR2_UNFUNDED_EXPOSURE() == null) ? "NA" : BRF104.getR2_UNFUNDED_EXPOSURE().toString();
				   R2cell9.setCellValue(value);
				 }
				 
				 Cell R2cell10 = row1.getCell(12);
				 if (R2cell10 != null) {
				   String value = (BRF104.getR2_REPAYMENT_AMOUNT() == null) ? "NA" : BRF104.getR2_REPAYMENT_AMOUNT().toString();
				   R2cell10.setCellValue(value);
				 }
				 
				 Cell R2cell11 = row1.getCell(13);
		    	if (R2cell11 != null) {
		    	R2cell11.setCellValue(BRF104.getR2_LEGACY_INTEREST() == null ? 0 :
		    	BRF104.getR2_LEGACY_INTEREST().intValue());
		    	} 
				 
				 
		    	Cell R2cell12 = row1.getCell(14);
		    	if (R2cell12 != null) {
		    	R2cell12.setCellValue(BRF104.getR2_PROVISION_INTEREST() == null ? 0 :
		    	BRF104.getR2_PROVISION_INTEREST().intValue());
		    	}
		    	Cell R2cell13 = row1.getCell(15);
		    	if (R2cell13 != null) {
		    	R2cell13.setCellValue(BRF104.getR2_SPECIFIC_PROVISION() == null ? 0 :
		    	BRF104.getR2_SPECIFIC_PROVISION().intValue());
		    	}
		    	
				
		    /////srl_no -11/////////
		    	Row row3 = sheet.getRow(10);
		    
				Cell R3cell = row1.getCell(2);
				 if (R3cell != null) {
				   String value = (BRF104.getR3_BORROWERS_NAME() == null) ? "NA" : BRF104.getR3_BORROWERS_NAME().toString();
				   R3cell.setCellValue(value);
				   }
				   
				   Cell R3cell1 = row1.getCell(3);
				 if (R3cell1 != null) {
				   String value = (BRF104.getR3_CIN() == null) ? "NA" : BRF104.getR3_CIN().toString();
				   R3cell1.setCellValue(value);
				}
				 Cell R3cell2 = row1.getCell(4);
				 if (R3cell2 != null) {
				   String value = (BRF104.getR3_DISTRESSED() == null) ? "NA" : BRF104.getR3_DISTRESSED().toString();
				   R3cell2.setCellValue(value);
				}
		    	Cell R3cell3 = row1.getCell(5);
				 if (R3cell3 != null) {
				   String value = (BRF104.getR3_CURRENT_BANK_INTERNAL_RATING() == null) ? "NA" : BRF104.getR3_CURRENT_BANK_INTERNAL_RATING().toString();
				   R3cell3.setCellValue(value);
				 }
				 
				 Cell R3cell4 = row1.getCell(6);
				 if (R3cell4 != null) {
				   String value = (BRF104.getR3_IFRS_9_STAGE() == null) ? "NA" : BRF104.getR3_IFRS_9_STAGE().toString();
				   R3cell4.setCellValue(value);
				   }
				 Cell R3cell5 = row1.getCell(7);
				 if (R3cell5 != null) {
				     Date dateValue =BRF104.getR3_DATE_OF_RESTRUCTURE (); // Assuming this returns a Date object
				     SimpleDateFormat DateFormat = new SimpleDateFormat("dd/MM/yyyy"); // Specify your desired date format
				     String formattedDate = (dateValue == null) ? "NA" : DateFormat.format(dateValue);
				     R3cell5.setCellValue(formattedDate);
				 }
				 
		    	Cell R3cell6 = row1.getCell(8);
		    	if (R3cell6 != null) {
		    	R3cell6.setCellValue(BRF104.getR3_NUMBER_OF_TIME_RESTRUCTURED() == null ? 0 :
		    	BRF104.getR3_NUMBER_OF_TIME_RESTRUCTURED().intValue());
		    	}
				
				 Cell R3cell7 = row1.getCell(9);
				 if (R3cell7 != null) {
				     Date dateValue =BRF104.getR3_DATE_OF_PREVIOUS_RESTRUCTURE (); // Assuming this returns a Date object
				     SimpleDateFormat DateFormat = new SimpleDateFormat("dd/MM/yyyy"); // Specify your desired date format
				     String formattedDate = (dateValue == null) ? "NA" : DateFormat.format(dateValue);
				     R3cell7.setCellValue(formattedDate);
				 }
				
				Cell R3cell8 = row1.getCell(10);
				 if (R3cell8 != null) {
				   String value = (BRF104.getR3_FUNDED_EXPOSURE() == null) ? "0" : BRF104.getR3_FUNDED_EXPOSURE().toString();
				   R3cell8.setCellValue(value);
				 }
				 
				 Cell R3cell9 = row1.getCell(11);
				 if (R3cell9 != null) {
				   String value = (BRF104.getR3_UNFUNDED_EXPOSURE() == null) ? "NA" : BRF104.getR3_UNFUNDED_EXPOSURE().toString();
				   R3cell9.setCellValue(value);
				 }
				 
				 Cell R3cell10 = row1.getCell(12);
				 if (R3cell10 != null) {
				   String value = (BRF104.getR3_REPAYMENT_AMOUNT() == null) ? "NA" : BRF104.getR3_REPAYMENT_AMOUNT().toString();
				   R3cell10.setCellValue(value);
				 }
				 
				 Cell R3cell11 = row1.getCell(13);
		    	if (R3cell11 != null) {
		    	R3cell11.setCellValue(BRF104.getR3_LEGACY_INTEREST() == null ? 0 :
		    	BRF104.getR3_LEGACY_INTEREST().intValue());
		    	} 
				 
				 
		    	Cell R3cell12 = row1.getCell(14);
		    	if (R3cell12 != null) {
		    	R3cell12.setCellValue(BRF104.getR3_PROVISION_INTEREST() == null ? 0 :
		    	BRF104.getR3_PROVISION_INTEREST().intValue());
		    	}
		    	Cell R3cell13 = row1.getCell(15);
		    	if (R3cell13 != null) {
		    	R3cell13.setCellValue(BRF104.getR3_SPECIFIC_PROVISION() == null ? 0 :
		    	BRF104.getR3_SPECIFIC_PROVISION().intValue());
		    	}
		    	
				
			
		    /////srl_no -12/////////
		    	Row row4 = sheet.getRow(11);
		 
				Cell R4cell = row1.getCell(2);
				 if (R4cell != null) {
				   String value = (BRF104.getR4_BORROWERS_NAME() == null) ? "NA" : BRF104.getR4_BORROWERS_NAME().toString();
				   R4cell.setCellValue(value);
				   }
				   
				   Cell R4cell1 = row1.getCell(3);
				 if (R4cell1 != null) {
				   String value = (BRF104.getR4_CIN() == null) ? "NA" : BRF104.getR4_CIN().toString();
				   R4cell1.setCellValue(value);
				}
				 Cell R4cell2 = row1.getCell(4);
				 if (R4cell2 != null) {
				   String value = (BRF104.getR4_DISTRESSED() == null) ? "NA" : BRF104.getR4_DISTRESSED().toString();
				   R4cell2.setCellValue(value);
				}
		    	Cell R4cell3 = row1.getCell(5);
				 if (R4cell3 != null) {
				   String value = (BRF104.getR4_CURRENT_BANK_INTERNAL_RATING() == null) ? "NA" : BRF104.getR4_CURRENT_BANK_INTERNAL_RATING().toString();
				   R4cell3.setCellValue(value);
				 }
				 
				 Cell R4cell4 = row1.getCell(6);
				 if (R4cell4 != null) {
				   String value = (BRF104.getR4_IFRS_9_STAGE() == null) ? "NA" : BRF104.getR4_IFRS_9_STAGE().toString();
				   R4cell4.setCellValue(value);
				   }
				 Cell R4cell5 = row1.getCell(7);
				 if (R4cell5 != null) {
				     Date dateValue =BRF104.getR4_DATE_OF_RESTRUCTURE (); // Assuming this returns a Date object
				     SimpleDateFormat DateFormat = new SimpleDateFormat("dd/MM/yyyy"); // Specify your desired date format
				     String formattedDate = (dateValue == null) ? "NA" : DateFormat.format(dateValue);
				     R4cell5.setCellValue(formattedDate);
				 }
				 
		    	Cell R4cell6 = row1.getCell(8);
		    	if (R4cell6 != null) {
		    	R4cell6.setCellValue(BRF104.getR4_NUMBER_OF_TIME_RESTRUCTURED() == null ? 0 :
		    	BRF104.getR4_NUMBER_OF_TIME_RESTRUCTURED().intValue());
		    	}
				
				 Cell R4cell7 = row1.getCell(9);
				 if (R4cell7 != null) {
				     Date dateValue =BRF104.getR4_DATE_OF_PREVIOUS_RESTRUCTURE (); // Assuming this returns a Date object
				     SimpleDateFormat DateFormat = new SimpleDateFormat("dd/MM/yyyy"); // Specify your desired date format
				     String formattedDate = (dateValue == null) ? "NA" : DateFormat.format(dateValue);
				     R4cell7.setCellValue(formattedDate);
				 }
				
				Cell R4cell8 = row1.getCell(10);
				 if (R4cell8 != null) {
				   String value = (BRF104.getR4_FUNDED_EXPOSURE() == null) ? "0" : BRF104.getR4_FUNDED_EXPOSURE().toString();
				   R4cell8.setCellValue(value);
				 }
				 
				 Cell R4cell9 = row1.getCell(11);
				 if (R4cell9 != null) {
				   String value = (BRF104.getR4_UNFUNDED_EXPOSURE() == null) ? "NA" : BRF104.getR4_UNFUNDED_EXPOSURE().toString();
				   R4cell9.setCellValue(value);
				 }
				 
				 Cell R4cell10 = row1.getCell(12);
				 if (R4cell10 != null) {
				   String value = (BRF104.getR4_REPAYMENT_AMOUNT() == null) ? "NA" : BRF104.getR4_REPAYMENT_AMOUNT().toString();
				   R4cell10.setCellValue(value);
				 }
				 
				 Cell R4cell11 = row1.getCell(13);
		    	if (R4cell11 != null) {
		    	R4cell11.setCellValue(BRF104.getR4_LEGACY_INTEREST() == null ? 0 :
		    	BRF104.getR4_LEGACY_INTEREST().intValue());
		    	} 
				 
				 
		    	Cell R4cell12 = row1.getCell(14);
		    	if (R4cell12 != null) {
		    	R4cell12.setCellValue(BRF104.getR4_PROVISION_INTEREST() == null ? 0 :
		    	BRF104.getR4_PROVISION_INTEREST().intValue());
		    	}
		    	Cell R4cell13 = row1.getCell(15);
		    	if (R4cell13 != null) {
		    	R4cell13.setCellValue(BRF104.getR4_SPECIFIC_PROVISION() == null ? 0 :
		    	BRF104.getR4_SPECIFIC_PROVISION().intValue());
		    	}
		    	
			
		    /////srl_no -13/////////
		    	Row row5 = sheet.getRow(12);
		    
				Cell R5cell = row1.getCell(2);
				 if (R5cell != null) {
				   String value = (BRF104.getR5_BORROWERS_NAME() == null) ? "NA" : BRF104.getR5_BORROWERS_NAME().toString();
				   R5cell.setCellValue(value);
				   }
				   
				   Cell R5cell1 = row1.getCell(3);
				 if (R5cell1 != null) {
				   String value = (BRF104.getR5_CIN() == null) ? "NA" : BRF104.getR5_CIN().toString();
				   R5cell1.setCellValue(value);
				}
				 Cell R5cell2 = row1.getCell(4);
				 if (R5cell2 != null) {
				   String value = (BRF104.getR5_DISTRESSED() == null) ? "NA" : BRF104.getR5_DISTRESSED().toString();
				   R5cell2.setCellValue(value);
				}
		    	Cell R5cell3 = row1.getCell(5);
				 if (R5cell3 != null) {
				   String value = (BRF104.getR5_CURRENT_BANK_INTERNAL_RATING() == null) ? "NA" : BRF104.getR5_CURRENT_BANK_INTERNAL_RATING().toString();
				   R5cell3.setCellValue(value);
				 }
				 
				 Cell R5cell4 = row1.getCell(6);
				 if (R5cell4 != null) {
				   String value = (BRF104.getR5_IFRS_9_STAGE() == null) ? "NA" : BRF104.getR5_IFRS_9_STAGE().toString();
				   R5cell4.setCellValue(value);
				   }
				 Cell R5cell5 = row1.getCell(7);
				 if (R5cell5 != null) {
				     Date dateValue =BRF104.getR5_DATE_OF_RESTRUCTURE (); // Assuming this returns a Date object
				     SimpleDateFormat DateFormat = new SimpleDateFormat("dd/MM/yyyy"); // Specify your desired date format
				     String formattedDate = (dateValue == null) ? "NA" : DateFormat.format(dateValue);
				     R5cell5.setCellValue(formattedDate);
				 }
				 
		    	Cell R5cell6 = row1.getCell(8);
		    	if (R5cell6 != null) {
		    	R5cell6.setCellValue(BRF104.getR5_NUMBER_OF_TIME_RESTRUCTURED() == null ? 0 :
		    	BRF104.getR5_NUMBER_OF_TIME_RESTRUCTURED().intValue());
		    	}
				
				 Cell R5cell7 = row1.getCell(9);
				 if (R5cell7 != null) {
				     Date dateValue =BRF104.getR5_DATE_OF_PREVIOUS_RESTRUCTURE (); // Assuming this returns a Date object
				     SimpleDateFormat DateFormat = new SimpleDateFormat("dd/MM/yyyy"); // Specify your desired date format
				     String formattedDate = (dateValue == null) ? "NA" : DateFormat.format(dateValue);
				     R5cell7.setCellValue(formattedDate);
				 }
				
				Cell R5cell8 = row1.getCell(10);
				 if (R5cell8 != null) {
				   String value = (BRF104.getR5_FUNDED_EXPOSURE() == null) ? "0" : BRF104.getR5_FUNDED_EXPOSURE().toString();
				   R5cell8.setCellValue(value);
				 }
				 
				 Cell R5cell9 = row1.getCell(11);
				 if (R5cell9 != null) {
				   String value = (BRF104.getR5_UNFUNDED_EXPOSURE() == null) ? "NA" : BRF104.getR5_UNFUNDED_EXPOSURE().toString();
				   R5cell9.setCellValue(value);
				 }
				 
				 Cell R5cell10 = row1.getCell(12);
				 if (R5cell10 != null) {
				   String value = (BRF104.getR5_REPAYMENT_AMOUNT() == null) ? "NA" : BRF104.getR5_REPAYMENT_AMOUNT().toString();
				   R5cell10.setCellValue(value);
				 }
				 
				 Cell R5cell11 = row1.getCell(13);
		    	if (R5cell11 != null) {
		    	R5cell11.setCellValue(BRF104.getR5_LEGACY_INTEREST() == null ? 0 :
		    	BRF104.getR5_LEGACY_INTEREST().intValue());
		    	} 
				 
				 
		    	Cell R5cell12 = row1.getCell(14);
		    	if (R5cell12 != null) {
		    	R5cell12.setCellValue(BRF104.getR5_PROVISION_INTEREST() == null ? 0 :
		    	BRF104.getR5_PROVISION_INTEREST().intValue());
		    	}
		    	Cell R5cell13 = row1.getCell(15);
		    	if (R5cell13 != null) {
		    	R5cell13.setCellValue(BRF104.getR5_SPECIFIC_PROVISION() == null ? 0 :
		    	BRF104.getR5_SPECIFIC_PROVISION().intValue());
		    	}
		    	
				
			
		    /////srl_no -14/////////
		    	Row row6 = sheet.getRow(13);
		    	
				Cell R6cell = row1.getCell(2);
				 if (R6cell != null) {
				   String value = (BRF104.getR6_BORROWERS_NAME() == null) ? "NA" : BRF104.getR6_BORROWERS_NAME().toString();
				   R6cell.setCellValue(value);
				   }
				   
				   Cell R6cell1 = row1.getCell(3);
				 if (R6cell1 != null) {
				   String value = (BRF104.getR6_CIN() == null) ? "NA" : BRF104.getR6_CIN().toString();
				   R6cell1.setCellValue(value);
				}
				 Cell R6cell2 = row1.getCell(4);
				 if (R6cell2 != null) {
				   String value = (BRF104.getR6_DISTRESSED() == null) ? "NA" : BRF104.getR6_DISTRESSED().toString();
				   R6cell2.setCellValue(value);
				}
		    	Cell R6cell3 = row1.getCell(5);
				 if (R6cell3 != null) {
				   String value = (BRF104.getR6_CURRENT_BANK_INTERNAL_RATING() == null) ? "NA" : BRF104.getR6_CURRENT_BANK_INTERNAL_RATING().toString();
				   R6cell3.setCellValue(value);
				 }
				 
				 Cell R6cell4 = row1.getCell(6);
				 if (R6cell4 != null) {
				   String value = (BRF104.getR6_IFRS_9_STAGE() == null) ? "NA" : BRF104.getR6_IFRS_9_STAGE().toString();
				   R6cell4.setCellValue(value);
				   }
				 Cell R6cell5 = row1.getCell(7);
				 if (R6cell5 != null) {
				     Date dateValue =BRF104.getR6_DATE_OF_RESTRUCTURE (); // Assuming this returns a Date object
				     SimpleDateFormat DateFormat = new SimpleDateFormat("dd/MM/yyyy"); // Specify your desired date format
				     String formattedDate = (dateValue == null) ? "NA" : DateFormat.format(dateValue);
				     R6cell5.setCellValue(formattedDate);
				 }
				 
		    	Cell R6cell6 = row1.getCell(8);
		    	if (R6cell6 != null) {
		    	R6cell6.setCellValue(BRF104.getR6_NUMBER_OF_TIME_RESTRUCTURED() == null ? 0 :
		    	BRF104.getR6_NUMBER_OF_TIME_RESTRUCTURED().intValue());
		    	}
				
				 Cell R6cell7 = row1.getCell(9);
				 if (R6cell7 != null) {
				     Date dateValue =BRF104.getR6_DATE_OF_PREVIOUS_RESTRUCTURE (); // Assuming this returns a Date object
				     SimpleDateFormat DateFormat = new SimpleDateFormat("dd/MM/yyyy"); // Specify your desired date format
				     String formattedDate = (dateValue == null) ? "NA" : DateFormat.format(dateValue);
				     R6cell7.setCellValue(formattedDate);
				 }
				
				Cell R6cell8 = row1.getCell(10);
				 if (R6cell8 != null) {
				   String value = (BRF104.getR6_FUNDED_EXPOSURE() == null) ? "0" : BRF104.getR6_FUNDED_EXPOSURE().toString();
				   R6cell8.setCellValue(value);
				 }
				 
				 Cell R6cell9 = row1.getCell(11);
				 if (R6cell9 != null) {
				   String value = (BRF104.getR6_UNFUNDED_EXPOSURE() == null) ? "NA" : BRF104.getR6_UNFUNDED_EXPOSURE().toString();
				   R6cell9.setCellValue(value);
				 }
				 
				 Cell R6cell10 = row1.getCell(12);
				 if (R6cell10 != null) {
				   String value = (BRF104.getR6_REPAYMENT_AMOUNT() == null) ? "NA" : BRF104.getR6_REPAYMENT_AMOUNT().toString();
				   R6cell10.setCellValue(value);
				 }
				 
				 Cell R6cell11 = row1.getCell(13);
		    	if (R6cell11 != null) {
		    	R6cell11.setCellValue(BRF104.getR6_LEGACY_INTEREST() == null ? 0 :
		    	BRF104.getR6_LEGACY_INTEREST().intValue());
		    	} 
				 
				 
		    	Cell R6cell12 = row1.getCell(14);
		    	if (R6cell12 != null) {
		    	R6cell12.setCellValue(BRF104.getR6_PROVISION_INTEREST() == null ? 0 :
		    	BRF104.getR6_PROVISION_INTEREST().intValue());
		    	}
		    	Cell R6cell13 = row1.getCell(15);
		    	if (R6cell13 != null) {
		    	R6cell13.setCellValue(BRF104.getR6_SPECIFIC_PROVISION() == null ? 0 :
		    	BRF104.getR6_SPECIFIC_PROVISION().intValue());
		    	}
		    	
			
		    /////srl_no -15/////////
		    	Row row7 = sheet.getRow(14);
		    	
				Cell R7cell = row1.getCell(2);
				 if (R7cell != null) {
				   String value = (BRF104.getR7_BORROWERS_NAME() == null) ? "NA" : BRF104.getR7_BORROWERS_NAME().toString();
				   R7cell.setCellValue(value);
				   }
				   
				   Cell R7cell1 = row1.getCell(3);
				 if (R7cell1 != null) {
				   String value = (BRF104.getR7_CIN() == null) ? "NA" : BRF104.getR7_CIN().toString();
				   R7cell1.setCellValue(value);
				}
				 Cell R7cell2 = row1.getCell(4);
				 if (R7cell2 != null) {
				   String value = (BRF104.getR7_DISTRESSED() == null) ? "NA" : BRF104.getR7_DISTRESSED().toString();
				   R7cell2.setCellValue(value);
				}
		    	Cell R7cell3 = row1.getCell(5);
				 if (R7cell3 != null) {
				   String value = (BRF104.getR7_CURRENT_BANK_INTERNAL_RATING() == null) ? "NA" : BRF104.getR7_CURRENT_BANK_INTERNAL_RATING().toString();
				   R7cell3.setCellValue(value);
				 }
				 
				 Cell R7cell4 = row1.getCell(6);
				 if (R7cell4 != null) {
				   String value = (BRF104.getR7_IFRS_9_STAGE() == null) ? "NA" : BRF104.getR7_IFRS_9_STAGE().toString();
				   R7cell4.setCellValue(value);
				   }
				 Cell R7cell5 = row1.getCell(7);
				 if (R7cell5 != null) {
				     Date dateValue =BRF104.getR7_DATE_OF_RESTRUCTURE (); // Assuming this returns a Date object
				     SimpleDateFormat DateFormat = new SimpleDateFormat("dd/MM/yyyy"); // Specify your desired date format
				     String formattedDate = (dateValue == null) ? "NA" : DateFormat.format(dateValue);
				     R7cell5.setCellValue(formattedDate);
				 }
				 
		    	Cell R7cell6 = row1.getCell(8);
		    	if (R7cell6 != null) {
		    	R7cell6.setCellValue(BRF104.getR7_NUMBER_OF_TIME_RESTRUCTURED() == null ? 0 :
		    	BRF104.getR7_NUMBER_OF_TIME_RESTRUCTURED().intValue());
		    	}
				
				 Cell R7cell7 = row1.getCell(9);
				 if (R7cell7 != null) {
				     Date dateValue =BRF104.getR7_DATE_OF_PREVIOUS_RESTRUCTURE (); // Assuming this returns a Date object
				     SimpleDateFormat DateFormat = new SimpleDateFormat("dd/MM/yyyy"); // Specify your desired date format
				     String formattedDate = (dateValue == null) ? "NA" : DateFormat.format(dateValue);
				     R7cell7.setCellValue(formattedDate);
				 }
				
				Cell R7cell8 = row1.getCell(10);
				 if (R7cell8 != null) {
				   String value = (BRF104.getR7_FUNDED_EXPOSURE() == null) ? "0" : BRF104.getR7_FUNDED_EXPOSURE().toString();
				   R7cell8.setCellValue(value);
				 }
				 
				 Cell R7cell9 = row1.getCell(11);
				 if (R7cell9 != null) {
				   String value = (BRF104.getR7_UNFUNDED_EXPOSURE() == null) ? "NA" : BRF104.getR7_UNFUNDED_EXPOSURE().toString();
				   R7cell9.setCellValue(value);
				 }
				 
				 Cell R7cell10 = row1.getCell(12);
				 if (R7cell10 != null) {
				   String value = (BRF104.getR7_REPAYMENT_AMOUNT() == null) ? "NA" : BRF104.getR7_REPAYMENT_AMOUNT().toString();
				   R7cell10.setCellValue(value);
				 }
				 
				 Cell R7cell11 = row1.getCell(13);
		    	if (R7cell11 != null) {
		    	R7cell11.setCellValue(BRF104.getR7_LEGACY_INTEREST() == null ? 0 :
		    	BRF104.getR7_LEGACY_INTEREST().intValue());
		    	} 
				 
				 
		    	Cell R7cell12 = row1.getCell(14);
		    	if (R7cell12 != null) {
		    	R7cell12.setCellValue(BRF104.getR7_PROVISION_INTEREST() == null ? 0 :
		    	BRF104.getR7_PROVISION_INTEREST().intValue());
		    	}
		    	Cell R7cell13 = row1.getCell(15);
		    	if (R7cell13 != null) {
		    	R7cell13.setCellValue(BRF104.getR7_SPECIFIC_PROVISION() == null ? 0 :
		    	BRF104.getR7_SPECIFIC_PROVISION().intValue());
		    	}
		    	
				
			
		    /////srl_no -16/////////
		    	Row row8 = sheet.getRow(15);
		    	
				Cell R8cell = row1.getCell(2);
				 if (R8cell != null) {
				   String value = (BRF104.getR8_BORROWERS_NAME() == null) ? "NA" : BRF104.getR8_BORROWERS_NAME().toString();
				   R8cell.setCellValue(value);
				   }
				   
				   Cell R8cell1 = row1.getCell(3);
				 if (R8cell1 != null) {
				   String value = (BRF104.getR8_CIN() == null) ? "NA" : BRF104.getR8_CIN().toString();
				   R8cell1.setCellValue(value);
				}
				 Cell R8cell2 = row1.getCell(4);
				 if (R8cell2 != null) {
				   String value = (BRF104.getR8_DISTRESSED() == null) ? "NA" : BRF104.getR8_DISTRESSED().toString();
				   R8cell2.setCellValue(value);
				}
		    	Cell R8cell3 = row1.getCell(5);
				 if (R8cell3 != null) {
				   String value = (BRF104.getR8_CURRENT_BANK_INTERNAL_RATING() == null) ? "NA" : BRF104.getR8_CURRENT_BANK_INTERNAL_RATING().toString();
				   R8cell3.setCellValue(value);
				 }
				 
				 Cell R8cell4 = row1.getCell(6);
				 if (R8cell4 != null) {
				   String value = (BRF104.getR8_IFRS_9_STAGE() == null) ? "NA" : BRF104.getR8_IFRS_9_STAGE().toString();
				   R8cell4.setCellValue(value);
				   }
				 Cell R8cell5 = row1.getCell(7);
				 if (R8cell5 != null) {
				     Date dateValue =BRF104.getR8_DATE_OF_RESTRUCTURE (); // Assuming this returns a Date object
				     SimpleDateFormat DateFormat = new SimpleDateFormat("dd/MM/yyyy"); // Specify your desired date format
				     String formattedDate = (dateValue == null) ? "NA" : DateFormat.format(dateValue);
				     R8cell5.setCellValue(formattedDate);
				 }
				 
		    	Cell R8cell6 = row1.getCell(8);
		    	if (R8cell6 != null) {
		    	R8cell6.setCellValue(BRF104.getR8_NUMBER_OF_TIME_RESTRUCTURED() == null ? 0 :
		    	BRF104.getR8_NUMBER_OF_TIME_RESTRUCTURED().intValue());
		    	}
				
				 Cell R8cell7 = row1.getCell(9);
				 if (R8cell7 != null) {
				     Date dateValue =BRF104.getR8_DATE_OF_PREVIOUS_RESTRUCTURE (); // Assuming this returns a Date object
				     SimpleDateFormat DateFormat = new SimpleDateFormat("dd/MM/yyyy"); // Specify your desired date format
				     String formattedDate = (dateValue == null) ? "NA" : DateFormat.format(dateValue);
				     R8cell7.setCellValue(formattedDate);
				 }
				
				Cell R8cell8 = row1.getCell(10);
				 if (R8cell8 != null) {
				   String value = (BRF104.getR8_FUNDED_EXPOSURE() == null) ? "0" : BRF104.getR8_FUNDED_EXPOSURE().toString();
				   R8cell8.setCellValue(value);
				 }
				 
				 Cell R8cell9 = row1.getCell(11);
				 if (R8cell9 != null) {
				   String value = (BRF104.getR8_UNFUNDED_EXPOSURE() == null) ? "NA" : BRF104.getR8_UNFUNDED_EXPOSURE().toString();
				   R8cell9.setCellValue(value);
				 }
				 
				 Cell R8cell10 = row1.getCell(12);
				 if (R8cell10 != null) {
				   String value = (BRF104.getR8_REPAYMENT_AMOUNT() == null) ? "NA" : BRF104.getR8_REPAYMENT_AMOUNT().toString();
				   R8cell10.setCellValue(value);
				 }
				 
				 Cell R8cell11 = row1.getCell(13);
		    	if (R8cell11 != null) {
		    	R8cell11.setCellValue(BRF104.getR8_LEGACY_INTEREST() == null ? 0 :
		    	BRF104.getR8_LEGACY_INTEREST().intValue());
		    	} 
				 
				 
		    	Cell R8cell12 = row1.getCell(14);
		    	if (R8cell12 != null) {
		    	R8cell12.setCellValue(BRF104.getR8_PROVISION_INTEREST() == null ? 0 :
		    	BRF104.getR8_PROVISION_INTEREST().intValue());
		    	}
		    	Cell R8cell13 = row1.getCell(15);
		    	if (R8cell13 != null) {
		    	R8cell13.setCellValue(BRF104.getR8_SPECIFIC_PROVISION() == null ? 0 :
		    	BRF104.getR8_SPECIFIC_PROVISION().intValue());
		    	}
		    	
			
		    /////srl_no -17/////////
		    	Row row9 = sheet.getRow(16);
		    	
				Cell R9cell = row1.getCell(2);
				 if (R9cell != null) {
				   String value = (BRF104.getR9_BORROWERS_NAME() == null) ? "NA" : BRF104.getR9_BORROWERS_NAME().toString();
				   R9cell.setCellValue(value);
				   }
				   
				   Cell R9cell1 = row1.getCell(3);
				 if (R9cell1 != null) {
				   String value = (BRF104.getR9_CIN() == null) ? "NA" : BRF104.getR9_CIN().toString();
				   R9cell1.setCellValue(value);
				}
				 Cell R9cell2 = row1.getCell(4);
				 if (R9cell2 != null) {
				   String value = (BRF104.getR9_DISTRESSED() == null) ? "NA" : BRF104.getR9_DISTRESSED().toString();
				   R9cell2.setCellValue(value);
				}
		    	Cell R9cell3 = row1.getCell(5);
				 if (R9cell3 != null) {
				   String value = (BRF104.getR9_CURRENT_BANK_INTERNAL_RATING() == null) ? "NA" : BRF104.getR9_CURRENT_BANK_INTERNAL_RATING().toString();
				   R9cell3.setCellValue(value);
				 }
				 
				 Cell R9cell4 = row1.getCell(6);
				 if (R9cell4 != null) {
				   String value = (BRF104.getR9_IFRS_9_STAGE() == null) ? "NA" : BRF104.getR9_IFRS_9_STAGE().toString();
				   R9cell4.setCellValue(value);
				   }
				 Cell R9cell5 = row1.getCell(7);
				 if (R9cell5 != null) {
				     Date dateValue =BRF104.getR9_DATE_OF_RESTRUCTURE (); // Assuming this returns a Date object
				     SimpleDateFormat DateFormat = new SimpleDateFormat("dd/MM/yyyy"); // Specify your desired date format
				     String formattedDate = (dateValue == null) ? "NA" : DateFormat.format(dateValue);
				     R9cell5.setCellValue(formattedDate);
				 }
				 
		    	Cell R9cell6 = row1.getCell(8);
		    	if (R9cell6 != null) {
		    	R9cell6.setCellValue(BRF104.getR9_NUMBER_OF_TIME_RESTRUCTURED() == null ? 0 :
		    	BRF104.getR9_NUMBER_OF_TIME_RESTRUCTURED().intValue());
		    	}
				
				 Cell R9cell7 = row1.getCell(9);
				 if (R9cell7 != null) {
				     Date dateValue =BRF104.getR9_DATE_OF_PREVIOUS_RESTRUCTURE (); // Assuming this returns a Date object
				     SimpleDateFormat DateFormat = new SimpleDateFormat("dd/MM/yyyy"); // Specify your desired date format
				     String formattedDate = (dateValue == null) ? "NA" : DateFormat.format(dateValue);
				     R9cell7.setCellValue(formattedDate);
				 }
				
				Cell R9cell8 = row1.getCell(10);
				 if (R9cell8 != null) {
				   String value = (BRF104.getR9_FUNDED_EXPOSURE() == null) ? "0" : BRF104.getR9_FUNDED_EXPOSURE().toString();
				   R9cell8.setCellValue(value);
				 }
				 
				 Cell R9cell9 = row1.getCell(11);
				 if (R9cell9 != null) {
				   String value = (BRF104.getR9_UNFUNDED_EXPOSURE() == null) ? "NA" : BRF104.getR9_UNFUNDED_EXPOSURE().toString();
				   R9cell9.setCellValue(value);
				 }
				 
				 Cell R9cell10 = row1.getCell(12);
				 if (R9cell10 != null) {
				   String value = (BRF104.getR9_REPAYMENT_AMOUNT() == null) ? "NA" : BRF104.getR9_REPAYMENT_AMOUNT().toString();
				   R9cell10.setCellValue(value);
				 }
				 
				 Cell R9cell11 = row1.getCell(13);
		    	if (R9cell11 != null) {
		    	R9cell11.setCellValue(BRF104.getR9_LEGACY_INTEREST() == null ? 0 :
		    	BRF104.getR9_LEGACY_INTEREST().intValue());
		    	} 
				 
				 
		    	Cell R9cell12 = row1.getCell(14);
		    	if (R9cell12 != null) {
		    	R9cell12.setCellValue(BRF104.getR9_PROVISION_INTEREST() == null ? 0 :
		    	BRF104.getR9_PROVISION_INTEREST().intValue());
		    	}
		    	Cell R9cell13 = row1.getCell(15);
		    	if (R9cell13 != null) {
		    	R9cell13.setCellValue(BRF104.getR9_SPECIFIC_PROVISION() == null ? 0 :
		    	BRF104.getR9_SPECIFIC_PROVISION().intValue());
		    	}
		    	
				
		    /////srl_no -18/////////
		    	Row row10 = sheet.getRow(17);
		    	
				Cell R10cell = row1.getCell(2);
				 if (R10cell != null) {
				   String value = (BRF104.getR10_BORROWERS_NAME() == null) ? "NA" : BRF104.getR10_BORROWERS_NAME().toString();
				   R10cell.setCellValue(value);
				   }
				   
				   Cell R10cell1 = row1.getCell(3);
				 if (R10cell1 != null) {
				   String value = (BRF104.getR10_CIN() == null) ? "NA" : BRF104.getR10_CIN().toString();
				   R10cell1.setCellValue(value);
				}
				 Cell R10cell2 = row1.getCell(4);
				 if (R10cell2 != null) {
				   String value = (BRF104.getR10_DISTRESSED() == null) ? "NA" : BRF104.getR10_DISTRESSED().toString();
				   R10cell2.setCellValue(value);
				}
		    	Cell R10cell3 = row1.getCell(5);
				 if (R10cell3 != null) {
				   String value = (BRF104.getR10_CURRENT_BANK_INTERNAL_RATING() == null) ? "NA" : BRF104.getR10_CURRENT_BANK_INTERNAL_RATING().toString();
				   R10cell3.setCellValue(value);
				 }
				 
				 Cell R10cell4 = row1.getCell(6);
				 if (R10cell4 != null) {
				   String value = (BRF104.getR10_IFRS_9_STAGE() == null) ? "NA" : BRF104.getR10_IFRS_9_STAGE().toString();
				   R10cell4.setCellValue(value);
				   }
				 Cell R10cell5 = row1.getCell(7);
				 if (R10cell5 != null) {
				     Date dateValue =BRF104.getR10_DATE_OF_RESTRUCTURE (); // Assuming this returns a Date object
				     SimpleDateFormat DateFormat = new SimpleDateFormat("dd/MM/yyyy"); // Specify your desired date format
				     String formattedDate = (dateValue == null) ? "NA" : DateFormat.format(dateValue);
				     R10cell5.setCellValue(formattedDate);
				 }
				 
		    	Cell R10cell6 = row1.getCell(8);
		    	if (R10cell6 != null) {
		    	R10cell6.setCellValue(BRF104.getR10_NUMBER_OF_TIME_RESTRUCTURED() == null ? 0 :
		    	BRF104.getR10_NUMBER_OF_TIME_RESTRUCTURED().intValue());
		    	}
				
				 Cell R10cell7 = row1.getCell(9);
				 if (R10cell7 != null) {
				     Date dateValue =BRF104.getR10_DATE_OF_PREVIOUS_RESTRUCTURE (); // Assuming this returns a Date object
				     SimpleDateFormat DateFormat = new SimpleDateFormat("dd/MM/yyyy"); // Specify your desired date format
				     String formattedDate = (dateValue == null) ? "NA" : DateFormat.format(dateValue);
				     R10cell7.setCellValue(formattedDate);
				 }
				
				Cell R10cell8 = row1.getCell(10);
				 if (R10cell8 != null) {
				   String value = (BRF104.getR10_FUNDED_EXPOSURE() == null) ? "0" : BRF104.getR10_FUNDED_EXPOSURE().toString();
				   R10cell8.setCellValue(value);
				 }
				 
				 Cell R10cell9 = row1.getCell(11);
				 if (R10cell9 != null) {
				   String value = (BRF104.getR10_UNFUNDED_EXPOSURE() == null) ? "NA" : BRF104.getR10_UNFUNDED_EXPOSURE().toString();
				   R10cell9.setCellValue(value);
				 }
				 
				 Cell R10cell10 = row1.getCell(12);
				 if (R10cell10 != null) {
				   String value = (BRF104.getR10_REPAYMENT_AMOUNT() == null) ? "NA" : BRF104.getR10_REPAYMENT_AMOUNT().toString();
				   R10cell10.setCellValue(value);
				 }
				 
				 Cell R10cell11 = row1.getCell(13);
		    	if (R10cell11 != null) {
		    	R10cell11.setCellValue(BRF104.getR10_LEGACY_INTEREST() == null ? 0 :
		    	BRF104.getR10_LEGACY_INTEREST().intValue());
		    	} 
				 
				 
		    	Cell R10cell12 = row1.getCell(14);
		    	if (R10cell12 != null) {
		    	R10cell12.setCellValue(BRF104.getR10_PROVISION_INTEREST() == null ? 0 :
		    	BRF104.getR10_PROVISION_INTEREST().intValue());
		    	}
		    	Cell R10cell13 = row1.getCell(15);
		    	if (R10cell13 != null) {
		    	R10cell13.setCellValue(BRF104.getR10_SPECIFIC_PROVISION() == null ? 0 :
		    	BRF104.getR10_SPECIFIC_PROVISION().intValue());
		    	}
		    	
				
			
		    /////srl_no -19/////////
		    	Row row11 = sheet.getRow(18);

				Cell R11cell = row1.getCell(2);
				 if (R11cell != null) {
				   String value = (BRF104.getR11_BORROWERS_NAME() == null) ? "NA" : BRF104.getR11_BORROWERS_NAME().toString();
				   R11cell.setCellValue(value);
				   }
				   
				   Cell R11cell1 = row1.getCell(3);
				 if (R11cell1 != null) {
				   String value = (BRF104.getR11_CIN() == null) ? "NA" : BRF104.getR11_CIN().toString();
				   R11cell1.setCellValue(value);
				}
				 Cell R11cell2 = row1.getCell(4);
				 if (R11cell2 != null) {
				   String value = (BRF104.getR11_DISTRESSED() == null) ? "NA" : BRF104.getR11_DISTRESSED().toString();
				   R11cell2.setCellValue(value);
				}
		    	Cell R11cell3 = row1.getCell(5);
				 if (R11cell3 != null) {
				   String value = (BRF104.getR11_CURRENT_BANK_INTERNAL_RATING() == null) ? "NA" : BRF104.getR11_CURRENT_BANK_INTERNAL_RATING().toString();
				   R11cell3.setCellValue(value);
				 }
				 
				 Cell R11cell4 = row1.getCell(6);
				 if (R11cell4 != null) {
				   String value = (BRF104.getR11_IFRS_9_STAGE() == null) ? "NA" : BRF104.getR11_IFRS_9_STAGE().toString();
				   R11cell4.setCellValue(value);
				   }
				 Cell R11cell5 = row1.getCell(7);
				 if (R11cell5 != null) {
				     Date dateValue =BRF104.getR11_DATE_OF_RESTRUCTURE (); // Assuming this returns a Date object
				     SimpleDateFormat DateFormat = new SimpleDateFormat("dd/MM/yyyy"); // Specify your desired date format
				     String formattedDate = (dateValue == null) ? "NA" : DateFormat.format(dateValue);
				     R11cell5.setCellValue(formattedDate);
				 }
				 
		    	Cell R11cell6 = row1.getCell(8);
		    	if (R11cell6 != null) {
		    	R11cell6.setCellValue(BRF104.getR11_NUMBER_OF_TIME_RESTRUCTURED() == null ? 0 :
		    	BRF104.getR11_NUMBER_OF_TIME_RESTRUCTURED().intValue());
		    	}
				
				 Cell R11cell7 = row1.getCell(9);
				 if (R11cell7 != null) {
				     Date dateValue =BRF104.getR11_DATE_OF_PREVIOUS_RESTRUCTURE (); // Assuming this returns a Date object
				     SimpleDateFormat DateFormat = new SimpleDateFormat("dd/MM/yyyy"); // Specify your desired date format
				     String formattedDate = (dateValue == null) ? "NA" : DateFormat.format(dateValue);
				     R11cell7.setCellValue(formattedDate);
				 }
				
				Cell R11cell8 = row1.getCell(10);
				 if (R11cell8 != null) {
				   String value = (BRF104.getR11_FUNDED_EXPOSURE() == null) ? "0" : BRF104.getR11_FUNDED_EXPOSURE().toString();
				   R11cell8.setCellValue(value);
				 }
				 
				 Cell R11cell9 = row1.getCell(11);
				 if (R11cell9 != null) {
				   String value = (BRF104.getR11_UNFUNDED_EXPOSURE() == null) ? "NA" : BRF104.getR11_UNFUNDED_EXPOSURE().toString();
				   R11cell9.setCellValue(value);
				 }
				 
				 Cell R11cell10 = row1.getCell(12);
				 if (R11cell10 != null) {
				   String value = (BRF104.getR11_REPAYMENT_AMOUNT() == null) ? "NA" : BRF104.getR11_REPAYMENT_AMOUNT().toString();
				   R11cell10.setCellValue(value);
				 }
				 
				 Cell R11cell11 = row1.getCell(13);
		    	if (R11cell11 != null) {
		    	R11cell11.setCellValue(BRF104.getR11_LEGACY_INTEREST() == null ? 0 :
		    	BRF104.getR11_LEGACY_INTEREST().intValue());
		    	} 
				 
				 
		    	Cell R11cell12 = row1.getCell(14);
		    	if (R11cell12 != null) {
		    	R11cell12.setCellValue(BRF104.getR11_PROVISION_INTEREST() == null ? 0 :
		    	BRF104.getR11_PROVISION_INTEREST().intValue());
		    	}
		    	Cell R11cell13 = row1.getCell(15);
		    	if (R11cell13 != null) {
		    	R11cell13.setCellValue(BRF104.getR11_SPECIFIC_PROVISION() == null ? 0 :
		    	BRF104.getR11_SPECIFIC_PROVISION().intValue());
		    	}
		    	
				
			
		    /////srl_no -20/////////
		    	Row row12 = sheet.getRow(19);

				Cell R12cell = row1.getCell(2);
				 if (R12cell != null) {
				   String value = (BRF104.getR12_BORROWERS_NAME() == null) ? "NA" : BRF104.getR12_BORROWERS_NAME().toString();
				   R12cell.setCellValue(value);
				   }
				   
				   Cell R12cell1 = row1.getCell(3);
				 if (R12cell1 != null) {
				   String value = (BRF104.getR12_CIN() == null) ? "NA" : BRF104.getR12_CIN().toString();
				   R12cell1.setCellValue(value);
				}
				 Cell R12cell2 = row1.getCell(4);
				 if (R12cell2 != null) {
				   String value = (BRF104.getR12_DISTRESSED() == null) ? "NA" : BRF104.getR12_DISTRESSED().toString();
				   R12cell2.setCellValue(value);
				}
		    	Cell R12cell3 = row1.getCell(5);
				 if (R12cell3 != null) {
				   String value = (BRF104.getR12_CURRENT_BANK_INTERNAL_RATING() == null) ? "NA" : BRF104.getR12_CURRENT_BANK_INTERNAL_RATING().toString();
				   R12cell3.setCellValue(value);
				 }
				 
				 Cell R12cell4 = row1.getCell(6);
				 if (R12cell4 != null) {
				   String value = (BRF104.getR12_IFRS_9_STAGE() == null) ? "NA" : BRF104.getR12_IFRS_9_STAGE().toString();
				   R12cell4.setCellValue(value);
				   }
				 Cell R12cell5 = row1.getCell(7);
				 if (R12cell5 != null) {
				     Date dateValue =BRF104.getR12_DATE_OF_RESTRUCTURE (); // Assuming this returns a Date object
				     SimpleDateFormat DateFormat = new SimpleDateFormat("dd/MM/yyyy"); // Specify your desired date format
				     String formattedDate = (dateValue == null) ? "NA" : DateFormat.format(dateValue);
				     R12cell5.setCellValue(formattedDate);
				 }
				 
		    	Cell R12cell6 = row1.getCell(8);
		    	if (R12cell6 != null) {
		    	R12cell6.setCellValue(BRF104.getR12_NUMBER_OF_TIME_RESTRUCTURED() == null ? 0 :
		    	BRF104.getR12_NUMBER_OF_TIME_RESTRUCTURED().intValue());
		    	}
				
				 Cell R12cell7 = row1.getCell(9);
				 if (R12cell7 != null) {
				     Date dateValue =BRF104.getR12_DATE_OF_PREVIOUS_RESTRUCTURE (); // Assuming this returns a Date object
				     SimpleDateFormat DateFormat = new SimpleDateFormat("dd/MM/yyyy"); // Specify your desired date format
				     String formattedDate = (dateValue == null) ? "NA" : DateFormat.format(dateValue);
				     R12cell7.setCellValue(formattedDate);
				 }
				
				Cell R12cell8 = row1.getCell(10);
				 if (R12cell8 != null) {
				   String value = (BRF104.getR12_FUNDED_EXPOSURE() == null) ? "0" : BRF104.getR12_FUNDED_EXPOSURE().toString();
				   R12cell8.setCellValue(value);
				 }
				 
				 Cell R12cell9 = row1.getCell(11);
				 if (R12cell9 != null) {
				   String value = (BRF104.getR12_UNFUNDED_EXPOSURE() == null) ? "NA" : BRF104.getR12_UNFUNDED_EXPOSURE().toString();
				   R12cell9.setCellValue(value);
				 }
				 
				 Cell R12cell10 = row1.getCell(12);
				 if (R12cell10 != null) {
				   String value = (BRF104.getR12_REPAYMENT_AMOUNT() == null) ? "NA" : BRF104.getR12_REPAYMENT_AMOUNT().toString();
				   R12cell10.setCellValue(value);
				 }
				 
				 Cell R12cell11 = row1.getCell(13);
		    	if (R12cell11 != null) {
		    	R12cell11.setCellValue(BRF104.getR12_LEGACY_INTEREST() == null ? 0 :
		    	BRF104.getR12_LEGACY_INTEREST().intValue());
		    	} 
				 
				 
		    	Cell R12cell12 = row1.getCell(14);
		    	if (R12cell12 != null) {
		    	R12cell12.setCellValue(BRF104.getR12_PROVISION_INTEREST() == null ? 0 :
		    	BRF104.getR12_PROVISION_INTEREST().intValue());
		    	}
		    	Cell R12cell13 = row1.getCell(15);
		    	if (R12cell13 != null) {
		    	R12cell13.setCellValue(BRF104.getR12_SPECIFIC_PROVISION() == null ? 0 :
		    	BRF104.getR12_SPECIFIC_PROVISION().intValue());
		    	}
		    	
			
		    /////srl_no -21/////////
		    	Row row13 = sheet.getRow(20);

				Cell R13cell = row1.getCell(2);
				 if (R13cell != null) {
				   String value = (BRF104.getR13_BORROWERS_NAME() == null) ? "NA" : BRF104.getR13_BORROWERS_NAME().toString();
				   R13cell.setCellValue(value);
				   }
				   
				   Cell R13cell1 = row1.getCell(3);
				 if (R13cell1 != null) {
				   String value = (BRF104.getR13_CIN() == null) ? "NA" : BRF104.getR13_CIN().toString();
				   R13cell1.setCellValue(value);
				}
				 Cell R13cell2 = row1.getCell(4);
				 if (R13cell2 != null) {
				   String value = (BRF104.getR13_DISTRESSED() == null) ? "NA" : BRF104.getR13_DISTRESSED().toString();
				   R13cell2.setCellValue(value);
				}
		    	Cell R13cell3 = row1.getCell(5);
				 if (R13cell3 != null) {
				   String value = (BRF104.getR13_CURRENT_BANK_INTERNAL_RATING() == null) ? "NA" : BRF104.getR13_CURRENT_BANK_INTERNAL_RATING().toString();
				   R13cell3.setCellValue(value);
				 }
				 
				 Cell R13cell4 = row1.getCell(6);
				 if (R13cell4 != null) {
				   String value = (BRF104.getR13_IFRS_9_STAGE() == null) ? "NA" : BRF104.getR13_IFRS_9_STAGE().toString();
				   R13cell4.setCellValue(value);
				   }
				 Cell R13cell5 = row1.getCell(7);
				 if (R13cell5 != null) {
				     Date dateValue =BRF104.getR13_DATE_OF_RESTRUCTURE (); // Assuming this returns a Date object
				     SimpleDateFormat DateFormat = new SimpleDateFormat("dd/MM/yyyy"); // Specify your desired date format
				     String formattedDate = (dateValue == null) ? "NA" : DateFormat.format(dateValue);
				     R13cell5.setCellValue(formattedDate);
				 }
				 
		    	Cell R13cell6 = row1.getCell(8);
		    	if (R13cell6 != null) {
		    	R13cell6.setCellValue(BRF104.getR13_NUMBER_OF_TIME_RESTRUCTURED() == null ? 0 :
		    	BRF104.getR13_NUMBER_OF_TIME_RESTRUCTURED().intValue());
		    	}
				
				 Cell R13cell7 = row1.getCell(9);
				 if (R13cell7 != null) {
				     Date dateValue =BRF104.getR13_DATE_OF_PREVIOUS_RESTRUCTURE (); // Assuming this returns a Date object
				     SimpleDateFormat DateFormat = new SimpleDateFormat("dd/MM/yyyy"); // Specify your desired date format
				     String formattedDate = (dateValue == null) ? "NA" : DateFormat.format(dateValue);
				     R13cell7.setCellValue(formattedDate);
				 }
				
				Cell R13cell8 = row1.getCell(10);
				 if (R13cell8 != null) {
				   String value = (BRF104.getR13_FUNDED_EXPOSURE() == null) ? "0" : BRF104.getR13_FUNDED_EXPOSURE().toString();
				   R13cell8.setCellValue(value);
				 }
				 
				 Cell R13cell9 = row1.getCell(11);
				 if (R13cell9 != null) {
				   String value = (BRF104.getR13_UNFUNDED_EXPOSURE() == null) ? "NA" : BRF104.getR13_UNFUNDED_EXPOSURE().toString();
				   R13cell9.setCellValue(value);
				 }
				 
				 Cell R13cell10 = row1.getCell(12);
				 if (R13cell10 != null) {
				   String value = (BRF104.getR13_REPAYMENT_AMOUNT() == null) ? "NA" : BRF104.getR13_REPAYMENT_AMOUNT().toString();
				   R13cell10.setCellValue(value);
				 }
				 
				 Cell R13cell11 = row1.getCell(13);
		    	if (R13cell11 != null) {
		    	R13cell11.setCellValue(BRF104.getR13_LEGACY_INTEREST() == null ? 0 :
		    	BRF104.getR13_LEGACY_INTEREST().intValue());
		    	} 
				 
				 
		    	Cell R13cell12 = row1.getCell(14);
		    	if (R13cell12 != null) {
		    	R13cell12.setCellValue(BRF104.getR13_PROVISION_INTEREST() == null ? 0 :
		    	BRF104.getR13_PROVISION_INTEREST().intValue());
		    	}
		    	Cell R13cell13 = row1.getCell(15);
		    	if (R13cell13 != null) {
		    	R13cell13.setCellValue(BRF104.getR13_SPECIFIC_PROVISION() == null ? 0 :
		    	BRF104.getR13_SPECIFIC_PROVISION().intValue());
		    	}
		    	
				
		    	
		    /////srl_no -22/////////
		    	Row row14 = sheet.getRow(21);

				Cell R14cell = row1.getCell(2);
				 if (R14cell != null) {
				   String value = (BRF104.getR14_BORROWERS_NAME() == null) ? "NA" : BRF104.getR14_BORROWERS_NAME().toString();
				   R14cell.setCellValue(value);
				   }
				   
				   Cell R14cell1 = row1.getCell(3);
				 if (R14cell1 != null) {
				   String value = (BRF104.getR14_CIN() == null) ? "NA" : BRF104.getR14_CIN().toString();
				   R14cell1.setCellValue(value);
				}
				 Cell R14cell2 = row1.getCell(4);
				 if (R14cell2 != null) {
				   String value = (BRF104.getR14_DISTRESSED() == null) ? "NA" : BRF104.getR14_DISTRESSED().toString();
				   R14cell2.setCellValue(value);
				}
		    	Cell R14cell3 = row1.getCell(5);
				 if (R14cell3 != null) {
				   String value = (BRF104.getR14_CURRENT_BANK_INTERNAL_RATING() == null) ? "NA" : BRF104.getR14_CURRENT_BANK_INTERNAL_RATING().toString();
				   R14cell3.setCellValue(value);
				 }
				 
				 Cell R14cell4 = row1.getCell(6);
				 if (R14cell4 != null) {
				   String value = (BRF104.getR14_IFRS_9_STAGE() == null) ? "NA" : BRF104.getR14_IFRS_9_STAGE().toString();
				   R14cell4.setCellValue(value);
				   }
				 Cell R14cell5 = row1.getCell(7);
				 if (R14cell5 != null) {
				     Date dateValue =BRF104.getR14_DATE_OF_RESTRUCTURE (); // Assuming this returns a Date object
				     SimpleDateFormat DateFormat = new SimpleDateFormat("dd/MM/yyyy"); // Specify your desired date format
				     String formattedDate = (dateValue == null) ? "NA" : DateFormat.format(dateValue);
				     R14cell5.setCellValue(formattedDate);
				 }
				 
		    	Cell R14cell6 = row1.getCell(8);
		    	if (R14cell6 != null) {
		    	R14cell6.setCellValue(BRF104.getR14_NUMBER_OF_TIME_RESTRUCTURED() == null ? 0 :
		    	BRF104.getR14_NUMBER_OF_TIME_RESTRUCTURED().intValue());
		    	}
				
				 Cell R14cell7 = row1.getCell(9);
				 if (R14cell7 != null) {
				     Date dateValue =BRF104.getR14_DATE_OF_PREVIOUS_RESTRUCTURE (); // Assuming this returns a Date object
				     SimpleDateFormat DateFormat = new SimpleDateFormat("dd/MM/yyyy"); // Specify your desired date format
				     String formattedDate = (dateValue == null) ? "NA" : DateFormat.format(dateValue);
				     R14cell7.setCellValue(formattedDate);
				 }
				
				Cell R14cell8 = row1.getCell(10);
				 if (R14cell8 != null) {
				   String value = (BRF104.getR14_FUNDED_EXPOSURE() == null) ? "0" : BRF104.getR14_FUNDED_EXPOSURE().toString();
				   R14cell8.setCellValue(value);
				 }
				 
				 Cell R14cell9 = row1.getCell(11);
				 if (R14cell9 != null) {
				   String value = (BRF104.getR14_UNFUNDED_EXPOSURE() == null) ? "NA" : BRF104.getR14_UNFUNDED_EXPOSURE().toString();
				   R14cell9.setCellValue(value);
				 }
				 
				 Cell R14cell10 = row1.getCell(12);
				 if (R14cell10 != null) {
				   String value = (BRF104.getR14_REPAYMENT_AMOUNT() == null) ? "NA" : BRF104.getR14_REPAYMENT_AMOUNT().toString();
				   R14cell10.setCellValue(value);
				 }
				 
				 Cell R14cell11 = row1.getCell(13);
		    	if (R14cell11 != null) {
		    	R14cell11.setCellValue(BRF104.getR14_LEGACY_INTEREST() == null ? 0 :
		    	BRF104.getR14_LEGACY_INTEREST().intValue());
		    	} 
				 
				 
		    	Cell R14cell12 = row1.getCell(14);
		    	if (R14cell12 != null) {
		    	R14cell12.setCellValue(BRF104.getR14_PROVISION_INTEREST() == null ? 0 :
		    	BRF104.getR14_PROVISION_INTEREST().intValue());
		    	}
		    	Cell R14cell13 = row1.getCell(15);
		    	if (R14cell13 != null) {
		    	R14cell13.setCellValue(BRF104.getR14_SPECIFIC_PROVISION() == null ? 0 :
		    	BRF104.getR14_SPECIFIC_PROVISION().intValue());
		    	}
		    	
				
				
			
		    /////srl_no -23/////////
		    	Row row15 = sheet.getRow(22);

				Cell R15cell = row1.getCell(2);
				 if (R15cell != null) {
				   String value = (BRF104.getR15_BORROWERS_NAME() == null) ? "NA" : BRF104.getR15_BORROWERS_NAME().toString();
				   R15cell.setCellValue(value);
				   }
				   
				   Cell R15cell1 = row1.getCell(3);
				 if (R15cell1 != null) {
				   String value = (BRF104.getR15_CIN() == null) ? "NA" : BRF104.getR15_CIN().toString();
				   R15cell1.setCellValue(value);
				}
				 Cell R15cell2 = row1.getCell(4);
				 if (R15cell2 != null) {
				   String value = (BRF104.getR15_DISTRESSED() == null) ? "NA" : BRF104.getR15_DISTRESSED().toString();
				   R15cell2.setCellValue(value);
				}
		    	Cell R15cell3 = row1.getCell(5);
				 if (R15cell3 != null) {
				   String value = (BRF104.getR15_CURRENT_BANK_INTERNAL_RATING() == null) ? "NA" : BRF104.getR15_CURRENT_BANK_INTERNAL_RATING().toString();
				   R15cell3.setCellValue(value);
				 }
				 
				 Cell R15cell4 = row1.getCell(6);
				 if (R15cell4 != null) {
				   String value = (BRF104.getR15_IFRS_9_STAGE() == null) ? "NA" : BRF104.getR15_IFRS_9_STAGE().toString();
				   R15cell4.setCellValue(value);
				   }
				 Cell R15cell5 = row1.getCell(7);
				 if (R15cell5 != null) {
				     Date dateValue =BRF104.getR15_DATE_OF_RESTRUCTURE (); // Assuming this returns a Date object
				     SimpleDateFormat DateFormat = new SimpleDateFormat("dd/MM/yyyy"); // Specify your desired date format
				     String formattedDate = (dateValue == null) ? "NA" : DateFormat.format(dateValue);
				     R15cell5.setCellValue(formattedDate);
				 }
				 
		    	Cell R15cell6 = row1.getCell(8);
		    	if (R15cell6 != null) {
		    	R15cell6.setCellValue(BRF104.getR15_NUMBER_OF_TIME_RESTRUCTURED() == null ? 0 :
		    	BRF104.getR15_NUMBER_OF_TIME_RESTRUCTURED().intValue());
		    	}
				
				 Cell R15cell7 = row1.getCell(9);
				 if (R15cell7 != null) {
				     Date dateValue =BRF104.getR15_DATE_OF_PREVIOUS_RESTRUCTURE (); // Assuming this returns a Date object
				     SimpleDateFormat DateFormat = new SimpleDateFormat("dd/MM/yyyy"); // Specify your desired date format
				     String formattedDate = (dateValue == null) ? "NA" : DateFormat.format(dateValue);
				     R15cell7.setCellValue(formattedDate);
				 }
				
				Cell R15cell8 = row1.getCell(10);
				 if (R15cell8 != null) {
				   String value = (BRF104.getR15_FUNDED_EXPOSURE() == null) ? "0" : BRF104.getR15_FUNDED_EXPOSURE().toString();
				   R15cell8.setCellValue(value);
				 }
				 
				 Cell R15cell9 = row1.getCell(11);
				 if (R15cell9 != null) {
				   String value = (BRF104.getR15_UNFUNDED_EXPOSURE() == null) ? "NA" : BRF104.getR15_UNFUNDED_EXPOSURE().toString();
				   R15cell9.setCellValue(value);
				 }
				 
				 Cell R15cell10 = row1.getCell(12);
				 if (R15cell10 != null) {
				   String value = (BRF104.getR15_REPAYMENT_AMOUNT() == null) ? "NA" : BRF104.getR15_REPAYMENT_AMOUNT().toString();
				   R15cell10.setCellValue(value);
				 }
				 
				 Cell R15cell11 = row1.getCell(13);
		    	if (R15cell11 != null) {
		    	R15cell11.setCellValue(BRF104.getR15_LEGACY_INTEREST() == null ? 0 :
		    	BRF104.getR15_LEGACY_INTEREST().intValue());
		    	} 
				 
				 
		    	Cell R15cell12 = row1.getCell(14);
		    	if (R15cell12 != null) {
		    	R15cell12.setCellValue(BRF104.getR15_PROVISION_INTEREST() == null ? 0 :
		    	BRF104.getR15_PROVISION_INTEREST().intValue());
		    	}
		    	Cell R15cell13 = row1.getCell(15);
		    	if (R15cell13 != null) {
		    	R15cell13.setCellValue(BRF104.getR15_SPECIFIC_PROVISION() == null ? 0 :
		    	BRF104.getR15_SPECIFIC_PROVISION().intValue());
		    	}
		    	
				
				
			
		    /////srl_no -24/////////
		    	Row row16 = sheet.getRow(23);

				Cell R16cell = row1.getCell(2);
				 if (R16cell != null) {
				   String value = (BRF104.getR16_BORROWERS_NAME() == null) ? "NA" : BRF104.getR16_BORROWERS_NAME().toString();
				   R16cell.setCellValue(value);
				   }
				   
				   Cell R16cell1 = row1.getCell(3);
				 if (R16cell1 != null) {
				   String value = (BRF104.getR16_CIN() == null) ? "NA" : BRF104.getR16_CIN().toString();
				   R16cell1.setCellValue(value);
				}
				 Cell R16cell2 = row1.getCell(4);
				 if (R16cell2 != null) {
				   String value = (BRF104.getR16_DISTRESSED() == null) ? "NA" : BRF104.getR16_DISTRESSED().toString();
				   R16cell2.setCellValue(value);
				}
		    	Cell R16cell3 = row1.getCell(5);
				 if (R16cell3 != null) {
				   String value = (BRF104.getR16_CURRENT_BANK_INTERNAL_RATING() == null) ? "NA" : BRF104.getR16_CURRENT_BANK_INTERNAL_RATING().toString();
				   R16cell3.setCellValue(value);
				 }
				 
				 Cell R16cell4 = row1.getCell(6);
				 if (R16cell4 != null) {
				   String value = (BRF104.getR16_IFRS_9_STAGE() == null) ? "NA" : BRF104.getR16_IFRS_9_STAGE().toString();
				   R16cell4.setCellValue(value);
				   }
				 Cell R16cell5 = row1.getCell(7);
				 if (R16cell5 != null) {
				     Date dateValue =BRF104.getR16_DATE_OF_RESTRUCTURE (); // Assuming this returns a Date object
				     SimpleDateFormat DateFormat = new SimpleDateFormat("dd/MM/yyyy"); // Specify your desired date format
				     String formattedDate = (dateValue == null) ? "NA" : DateFormat.format(dateValue);
				     R16cell5.setCellValue(formattedDate);
				 }
				 
		    	Cell R16cell6 = row1.getCell(8);
		    	if (R16cell6 != null) {
		    	R16cell6.setCellValue(BRF104.getR16_NUMBER_OF_TIME_RESTRUCTURED() == null ? 0 :
		    	BRF104.getR16_NUMBER_OF_TIME_RESTRUCTURED().intValue());
		    	}
				
				 Cell R16cell7 = row1.getCell(9);
				 if (R16cell7 != null) {
				     Date dateValue =BRF104.getR16_DATE_OF_PREVIOUS_RESTRUCTURE (); // Assuming this returns a Date object
				     SimpleDateFormat DateFormat = new SimpleDateFormat("dd/MM/yyyy"); // Specify your desired date format
				     String formattedDate = (dateValue == null) ? "NA" : DateFormat.format(dateValue);
				     R16cell7.setCellValue(formattedDate);
				 }
				
				Cell R16cell8 = row1.getCell(10);
				 if (R16cell8 != null) {
				   String value = (BRF104.getR16_FUNDED_EXPOSURE() == null) ? "0" : BRF104.getR16_FUNDED_EXPOSURE().toString();
				   R16cell8.setCellValue(value);
				 }
				 
				 Cell R16cell9 = row1.getCell(11);
				 if (R16cell9 != null) {
				   String value = (BRF104.getR16_UNFUNDED_EXPOSURE() == null) ? "NA" : BRF104.getR16_UNFUNDED_EXPOSURE().toString();
				   R16cell9.setCellValue(value);
				 }
				 
				 Cell R16cell10 = row1.getCell(12);
				 if (R16cell10 != null) {
				   String value = (BRF104.getR16_REPAYMENT_AMOUNT() == null) ? "NA" : BRF104.getR16_REPAYMENT_AMOUNT().toString();
				   R16cell10.setCellValue(value);
				 }
				 
				 Cell R16cell11 = row1.getCell(13);
		    	if (R16cell11 != null) {
		    	R16cell11.setCellValue(BRF104.getR16_LEGACY_INTEREST() == null ? 0 :
		    	BRF104.getR16_LEGACY_INTEREST().intValue());
		    	} 
				 
				 
		    	Cell R16cell12 = row1.getCell(14);
		    	if (R16cell12 != null) {
		    	R16cell12.setCellValue(BRF104.getR16_PROVISION_INTEREST() == null ? 0 :
		    	BRF104.getR16_PROVISION_INTEREST().intValue());
		    	}
		    	Cell R16cell13 = row1.getCell(15);
		    	if (R16cell13 != null) {
		    	R16cell13.setCellValue(BRF104.getR16_SPECIFIC_PROVISION() == null ? 0 :
		    	BRF104.getR16_SPECIFIC_PROVISION().intValue());
		    	}
		    	
				
				
			
		    /////srl_no -25/////////
		    	Row row17 = sheet.getRow(24);

				Cell R17cell = row1.getCell(2);
				 if (R17cell != null) {
				   String value = (BRF104.getR17_BORROWERS_NAME() == null) ? "NA" : BRF104.getR17_BORROWERS_NAME().toString();
				   R17cell.setCellValue(value);
				   }
				   
				   Cell R17cell1 = row1.getCell(3);
				 if (R17cell1 != null) {
				   String value = (BRF104.getR17_CIN() == null) ? "NA" : BRF104.getR17_CIN().toString();
				   R17cell1.setCellValue(value);
				}
				 Cell R17cell2 = row1.getCell(4);
				 if (R17cell2 != null) {
				   String value = (BRF104.getR17_DISTRESSED() == null) ? "NA" : BRF104.getR17_DISTRESSED().toString();
				   R17cell2.setCellValue(value);
				}
		    	Cell R17cell3 = row1.getCell(5);
				 if (R17cell3 != null) {
				   String value = (BRF104.getR17_CURRENT_BANK_INTERNAL_RATING() == null) ? "NA" : BRF104.getR17_CURRENT_BANK_INTERNAL_RATING().toString();
				   R17cell3.setCellValue(value);
				 }
				 
				 Cell R17cell4 = row1.getCell(6);
				 if (R17cell4 != null) {
				   String value = (BRF104.getR17_IFRS_9_STAGE() == null) ? "NA" : BRF104.getR17_IFRS_9_STAGE().toString();
				   R17cell4.setCellValue(value);
				   }
				 Cell R17cell5 = row1.getCell(7);
				 if (R17cell5 != null) {
				     Date dateValue =BRF104.getR17_DATE_OF_RESTRUCTURE (); // Assuming this returns a Date object
				     SimpleDateFormat DateFormat = new SimpleDateFormat("dd/MM/yyyy"); // Specify your desired date format
				     String formattedDate = (dateValue == null) ? "NA" : DateFormat.format(dateValue);
				     R17cell5.setCellValue(formattedDate);
				 }
				 
		    	Cell R17cell6 = row1.getCell(8);
		    	if (R17cell6 != null) {
		    	R17cell6.setCellValue(BRF104.getR17_NUMBER_OF_TIME_RESTRUCTURED() == null ? 0 :
		    	BRF104.getR17_NUMBER_OF_TIME_RESTRUCTURED().intValue());
		    	}
				
				 Cell R17cell7 = row1.getCell(9);
				 if (R17cell7 != null) {
				     Date dateValue =BRF104.getR17_DATE_OF_PREVIOUS_RESTRUCTURE (); // Assuming this returns a Date object
				     SimpleDateFormat DateFormat = new SimpleDateFormat("dd/MM/yyyy"); // Specify your desired date format
				     String formattedDate = (dateValue == null) ? "NA" : DateFormat.format(dateValue);
				     R17cell7.setCellValue(formattedDate);
				 }
				
				Cell R17cell8 = row1.getCell(10);
				 if (R17cell8 != null) {
				   String value = (BRF104.getR17_FUNDED_EXPOSURE() == null) ? "0" : BRF104.getR17_FUNDED_EXPOSURE().toString();
				   R17cell8.setCellValue(value);
				 }
				 
				 Cell R17cell9 = row1.getCell(11);
				 if (R17cell9 != null) {
				   String value = (BRF104.getR17_UNFUNDED_EXPOSURE() == null) ? "NA" : BRF104.getR17_UNFUNDED_EXPOSURE().toString();
				   R17cell9.setCellValue(value);
				 }
				 
				 Cell R17cell10 = row1.getCell(12);
				 if (R17cell10 != null) {
				   String value = (BRF104.getR17_REPAYMENT_AMOUNT() == null) ? "NA" : BRF104.getR17_REPAYMENT_AMOUNT().toString();
				   R17cell10.setCellValue(value);
				 }
				 
				 Cell R17cell11 = row1.getCell(13);
		    	if (R17cell11 != null) {
		    	R17cell11.setCellValue(BRF104.getR17_LEGACY_INTEREST() == null ? 0 :
		    	BRF104.getR17_LEGACY_INTEREST().intValue());
		    	} 
				 
				 
		    	Cell R17cell12 = row1.getCell(14);
		    	if (R17cell12 != null) {
		    	R17cell12.setCellValue(BRF104.getR17_PROVISION_INTEREST() == null ? 0 :
		    	BRF104.getR17_PROVISION_INTEREST().intValue());
		    	}
		    	Cell R17cell13 = row1.getCell(15);
		    	if (R17cell13 != null) {
		    	R17cell13.setCellValue(BRF104.getR17_SPECIFIC_PROVISION() == null ? 0 :
		    	BRF104.getR17_SPECIFIC_PROVISION().intValue());
		    	}
		    	
				
				
			
		    /////srl_no -26/////////
		    	Row row18 = sheet.getRow(25);

				Cell R18cell = row1.getCell(2);
				 if (R18cell != null) {
				   String value = (BRF104.getR18_BORROWERS_NAME() == null) ? "NA" : BRF104.getR18_BORROWERS_NAME().toString();
				   R18cell.setCellValue(value);
				   }
				   
				   Cell R18cell1 = row1.getCell(3);
				 if (R18cell1 != null) {
				   String value = (BRF104.getR18_CIN() == null) ? "NA" : BRF104.getR18_CIN().toString();
				   R18cell1.setCellValue(value);
				}
				 Cell R18cell2 = row1.getCell(4);
				 if (R18cell2 != null) {
				   String value = (BRF104.getR18_DISTRESSED() == null) ? "NA" : BRF104.getR18_DISTRESSED().toString();
				   R18cell2.setCellValue(value);
				}
		    	Cell R18cell3 = row1.getCell(5);
				 if (R18cell3 != null) {
				   String value = (BRF104.getR18_CURRENT_BANK_INTERNAL_RATING() == null) ? "NA" : BRF104.getR18_CURRENT_BANK_INTERNAL_RATING().toString();
				   R18cell3.setCellValue(value);
				 }
				 
				 Cell R18cell4 = row1.getCell(6);
				 if (R18cell4 != null) {
				   String value = (BRF104.getR18_IFRS_9_STAGE() == null) ? "NA" : BRF104.getR18_IFRS_9_STAGE().toString();
				   R18cell4.setCellValue(value);
				   }
				 Cell R18cell5 = row1.getCell(7);
				 if (R18cell5 != null) {
				     Date dateValue =BRF104.getR18_DATE_OF_RESTRUCTURE (); // Assuming this returns a Date object
				     SimpleDateFormat DateFormat = new SimpleDateFormat("dd/MM/yyyy"); // Specify your desired date format
				     String formattedDate = (dateValue == null) ? "NA" : DateFormat.format(dateValue);
				     R18cell5.setCellValue(formattedDate);
				 }
				 
		    	Cell R18cell6 = row1.getCell(8);
		    	if (R18cell6 != null) {
		    	R18cell6.setCellValue(BRF104.getR18_NUMBER_OF_TIME_RESTRUCTURED() == null ? 0 :
		    	BRF104.getR18_NUMBER_OF_TIME_RESTRUCTURED().intValue());
		    	}
				
				 Cell R18cell7 = row1.getCell(9);
				 if (R18cell7 != null) {
				     Date dateValue =BRF104.getR18_DATE_OF_PREVIOUS_RESTRUCTURE (); // Assuming this returns a Date object
				     SimpleDateFormat DateFormat = new SimpleDateFormat("dd/MM/yyyy"); // Specify your desired date format
				     String formattedDate = (dateValue == null) ? "NA" : DateFormat.format(dateValue);
				     R18cell7.setCellValue(formattedDate);
				 }
				
				Cell R18cell8 = row1.getCell(10);
				 if (R18cell8 != null) {
				   String value = (BRF104.getR18_FUNDED_EXPOSURE() == null) ? "0" : BRF104.getR18_FUNDED_EXPOSURE().toString();
				   R18cell8.setCellValue(value);
				 }
				 
				 Cell R18cell9 = row1.getCell(11);
				 if (R18cell9 != null) {
				   String value = (BRF104.getR18_UNFUNDED_EXPOSURE() == null) ? "NA" : BRF104.getR18_UNFUNDED_EXPOSURE().toString();
				   R18cell9.setCellValue(value);
				 }
				 
				 Cell R18cell10 = row1.getCell(12);
				 if (R18cell10 != null) {
				   String value = (BRF104.getR18_REPAYMENT_AMOUNT() == null) ? "NA" : BRF104.getR18_REPAYMENT_AMOUNT().toString();
				   R18cell10.setCellValue(value);
				 }
				 
				 Cell R18cell11 = row1.getCell(13);
		    	if (R18cell11 != null) {
		    	R18cell11.setCellValue(BRF104.getR18_LEGACY_INTEREST() == null ? 0 :
		    	BRF104.getR18_LEGACY_INTEREST().intValue());
		    	} 
				 
				 
		    	Cell R18cell12 = row1.getCell(14);
		    	if (R18cell12 != null) {
		    	R18cell12.setCellValue(BRF104.getR18_PROVISION_INTEREST() == null ? 0 :
		    	BRF104.getR18_PROVISION_INTEREST().intValue());
		    	}
		    	Cell R18cell13 = row1.getCell(15);
		    	if (R18cell13 != null) {
		    	R18cell13.setCellValue(BRF104.getR18_SPECIFIC_PROVISION() == null ? 0 :
		    	BRF104.getR18_SPECIFIC_PROVISION().intValue());
		    	}
		    	
		    	
		    /////srl_no -27/////////
		    	Row row19 = sheet.getRow(26);

				Cell R19cell = row1.getCell(2);
				 if (R19cell != null) {
				   String value = (BRF104.getR19_BORROWERS_NAME() == null) ? "NA" : BRF104.getR19_BORROWERS_NAME().toString();
				   R19cell.setCellValue(value);
				   }
				   
				   Cell R19cell1 = row1.getCell(3);
				 if (R19cell1 != null) {
				   String value = (BRF104.getR19_CIN() == null) ? "NA" : BRF104.getR19_CIN().toString();
				   R19cell1.setCellValue(value);
				}
				 Cell R19cell2 = row1.getCell(4);
				 if (R19cell2 != null) {
				   String value = (BRF104.getR19_DISTRESSED() == null) ? "NA" : BRF104.getR19_DISTRESSED().toString();
				   R19cell2.setCellValue(value);
				}
		    	Cell R19cell3 = row1.getCell(5);
				 if (R19cell3 != null) {
				   String value = (BRF104.getR19_CURRENT_BANK_INTERNAL_RATING() == null) ? "NA" : BRF104.getR19_CURRENT_BANK_INTERNAL_RATING().toString();
				   R19cell3.setCellValue(value);
				 }
				 
				 Cell R19cell4 = row1.getCell(6);
				 if (R19cell4 != null) {
				   String value = (BRF104.getR19_IFRS_9_STAGE() == null) ? "NA" : BRF104.getR19_IFRS_9_STAGE().toString();
				   R19cell4.setCellValue(value);
				   }
				 Cell R19cell5 = row1.getCell(7);
				 if (R19cell5 != null) {
				     Date dateValue =BRF104.getR19_DATE_OF_RESTRUCTURE (); // Assuming this returns a Date object
				     SimpleDateFormat DateFormat = new SimpleDateFormat("dd/MM/yyyy"); // Specify your desired date format
				     String formattedDate = (dateValue == null) ? "NA" : DateFormat.format(dateValue);
				     R19cell5.setCellValue(formattedDate);
				 }
				 
		    	Cell R19cell6 = row1.getCell(8);
		    	if (R19cell6 != null) {
		    	R19cell6.setCellValue(BRF104.getR19_NUMBER_OF_TIME_RESTRUCTURED() == null ? 0 :
		    	BRF104.getR19_NUMBER_OF_TIME_RESTRUCTURED().intValue());
		    	}
				
				 Cell R19cell7 = row1.getCell(9);
				 if (R19cell7 != null) {
				     Date dateValue =BRF104.getR19_DATE_OF_PREVIOUS_RESTRUCTURE (); // Assuming this returns a Date object
				     SimpleDateFormat DateFormat = new SimpleDateFormat("dd/MM/yyyy"); // Specify your desired date format
				     String formattedDate = (dateValue == null) ? "NA" : DateFormat.format(dateValue);
				     R19cell7.setCellValue(formattedDate);
				 }
				
				Cell R19cell8 = row1.getCell(10);
				 if (R19cell8 != null) {
				   String value = (BRF104.getR19_FUNDED_EXPOSURE() == null) ? "0" : BRF104.getR19_FUNDED_EXPOSURE().toString();
				   R19cell8.setCellValue(value);
				 }
				 
				 Cell R19cell9 = row1.getCell(11);
				 if (R19cell9 != null) {
				   String value = (BRF104.getR19_UNFUNDED_EXPOSURE() == null) ? "NA" : BRF104.getR19_UNFUNDED_EXPOSURE().toString();
				   R19cell9.setCellValue(value);
				 }
				 
				 Cell R19cell10 = row1.getCell(12);
				 if (R19cell10 != null) {
				   String value = (BRF104.getR19_REPAYMENT_AMOUNT() == null) ? "NA" : BRF104.getR19_REPAYMENT_AMOUNT().toString();
				   R19cell10.setCellValue(value);
				 }
				 
				 Cell R19cell11 = row1.getCell(13);
		    	if (R19cell11 != null) {
		    	R19cell11.setCellValue(BRF104.getR19_LEGACY_INTEREST() == null ? 0 :
		    	BRF104.getR19_LEGACY_INTEREST().intValue());
		    	} 
				 
				 
		    	Cell R19cell12 = row1.getCell(14);
		    	if (R19cell12 != null) {
		    	R19cell12.setCellValue(BRF104.getR19_PROVISION_INTEREST() == null ? 0 :
		    	BRF104.getR19_PROVISION_INTEREST().intValue());
		    	}
		    	Cell R19cell13 = row1.getCell(15);
		    	if (R19cell13 != null) {
		    	R19cell13.setCellValue(BRF104.getR19_SPECIFIC_PROVISION() == null ? 0 :
		    	BRF104.getR19_SPECIFIC_PROVISION().intValue());
		    	}
		    	
		    	
		    /////srl_no -28/////////
		    	Row row20 = sheet.getRow(27);

				Cell R20cell = row1.getCell(2);
				 if (R20cell != null) {
				   String value = (BRF104.getR20_BORROWERS_NAME() == null) ? "NA" : BRF104.getR20_BORROWERS_NAME().toString();
				   R20cell.setCellValue(value);
				   }
				   
				   Cell R20cell1 = row1.getCell(3);
				 if (R20cell1 != null) {
				   String value = (BRF104.getR20_CIN() == null) ? "NA" : BRF104.getR20_CIN().toString();
				   R20cell1.setCellValue(value);
				}
				 Cell R20cell2 = row1.getCell(4);
				 if (R20cell2 != null) {
				   String value = (BRF104.getR20_DISTRESSED() == null) ? "NA" : BRF104.getR20_DISTRESSED().toString();
				   R20cell2.setCellValue(value);
				}
		    	Cell R20cell3 = row1.getCell(5);
				 if (R20cell3 != null) {
				   String value = (BRF104.getR20_CURRENT_BANK_INTERNAL_RATING() == null) ? "NA" : BRF104.getR20_CURRENT_BANK_INTERNAL_RATING().toString();
				   R20cell3.setCellValue(value);
				 }
				 
				 Cell R20cell4 = row1.getCell(6);
				 if (R20cell4 != null) {
				   String value = (BRF104.getR20_IFRS_9_STAGE() == null) ? "NA" : BRF104.getR20_IFRS_9_STAGE().toString();
				   R20cell4.setCellValue(value);
				   }
				 Cell R20cell5 = row1.getCell(7);
				 if (R20cell5 != null) {
				     Date dateValue =BRF104.getR20_DATE_OF_RESTRUCTURE (); // Assuming this returns a Date object
				     SimpleDateFormat DateFormat = new SimpleDateFormat("dd/MM/yyyy"); // Specify your desired date format
				     String formattedDate = (dateValue == null) ? "NA" : DateFormat.format(dateValue);
				     R20cell5.setCellValue(formattedDate);
				 }
				 
		    	Cell R20cell6 = row1.getCell(8);
		    	if (R20cell6 != null) {
		    	R20cell6.setCellValue(BRF104.getR20_NUMBER_OF_TIME_RESTRUCTURED() == null ? 0 :
		    	BRF104.getR20_NUMBER_OF_TIME_RESTRUCTURED().intValue());
		    	}
				
				 Cell R20cell7 = row1.getCell(9);
				 if (R20cell7 != null) {
				     Date dateValue =BRF104.getR20_DATE_OF_PREVIOUS_RESTRUCTURE (); // Assuming this returns a Date object
				     SimpleDateFormat DateFormat = new SimpleDateFormat("dd/MM/yyyy"); // Specify your desired date format
				     String formattedDate = (dateValue == null) ? "NA" : DateFormat.format(dateValue);
				     R20cell7.setCellValue(formattedDate);
				 }
				
				Cell R20cell8 = row1.getCell(10);
				 if (R20cell8 != null) {
				   String value = (BRF104.getR20_FUNDED_EXPOSURE() == null) ? "0" : BRF104.getR20_FUNDED_EXPOSURE().toString();
				   R20cell8.setCellValue(value);
				 }
				 
				 Cell R20cell9 = row1.getCell(11);
				 if (R20cell9 != null) {
				   String value = (BRF104.getR20_UNFUNDED_EXPOSURE() == null) ? "NA" : BRF104.getR20_UNFUNDED_EXPOSURE().toString();
				   R20cell9.setCellValue(value);
				 }
				 
				 Cell R20cell10 = row1.getCell(12);
				 if (R20cell10 != null) {
				   String value = (BRF104.getR20_REPAYMENT_AMOUNT() == null) ? "NA" : BRF104.getR20_REPAYMENT_AMOUNT().toString();
				   R20cell10.setCellValue(value);
				 }
				 
				 Cell R20cell11 = row1.getCell(13);
		    	if (R20cell11 != null) {
		    	R20cell11.setCellValue(BRF104.getR20_LEGACY_INTEREST() == null ? 0 :
		    	BRF104.getR20_LEGACY_INTEREST().intValue());
		    	} 
				 
				 
		    	Cell R20cell12 = row1.getCell(14);
		    	if (R20cell12 != null) {
		    	R20cell12.setCellValue(BRF104.getR20_PROVISION_INTEREST() == null ? 0 :
		    	BRF104.getR20_PROVISION_INTEREST().intValue());
		    	}
		    	Cell R20cell13 = row1.getCell(15);
		    	if (R20cell13 != null) {
		    	R20cell13.setCellValue(BRF104.getR20_SPECIFIC_PROVISION() == null ? 0 :
		    	BRF104.getR20_SPECIFIC_PROVISION().intValue());
		    	}
		    	
		    	
		    /////srl_no -29/////////
		    	Row row21 = sheet.getRow(28);

				Cell R21cell = row1.getCell(2);
				 if (R21cell != null) {
				   String value = (BRF104.getR21_BORROWERS_NAME() == null) ? "NA" : BRF104.getR21_BORROWERS_NAME().toString();
				   R21cell.setCellValue(value);
				   }
				   
				   Cell R21cell1 = row1.getCell(3);
				 if (R21cell1 != null) {
				   String value = (BRF104.getR21_CIN() == null) ? "NA" : BRF104.getR21_CIN().toString();
				   R21cell1.setCellValue(value);
				}
				 Cell R21cell2 = row1.getCell(4);
				 if (R21cell2 != null) {
				   String value = (BRF104.getR21_DISTRESSED() == null) ? "NA" : BRF104.getR21_DISTRESSED().toString();
				   R21cell2.setCellValue(value);
				}
		    	Cell R21cell3 = row1.getCell(5);
				 if (R21cell3 != null) {
				   String value = (BRF104.getR21_CURRENT_BANK_INTERNAL_RATING() == null) ? "NA" : BRF104.getR21_CURRENT_BANK_INTERNAL_RATING().toString();
				   R21cell3.setCellValue(value);
				 }
				 
				 Cell R21cell4 = row1.getCell(6);
				 if (R21cell4 != null) {
				   String value = (BRF104.getR21_IFRS_9_STAGE() == null) ? "NA" : BRF104.getR21_IFRS_9_STAGE().toString();
				   R21cell4.setCellValue(value);
				   }
				 Cell R21cell5 = row1.getCell(7);
				 if (R21cell5 != null) {
				     Date dateValue =BRF104.getR21_DATE_OF_RESTRUCTURE (); // Assuming this returns a Date object
				     SimpleDateFormat DateFormat = new SimpleDateFormat("dd/MM/yyyy"); // Specify your desired date format
				     String formattedDate = (dateValue == null) ? "NA" : DateFormat.format(dateValue);
				     R21cell5.setCellValue(formattedDate);
				 }
				 
		    	Cell R21cell6 = row1.getCell(8);
		    	if (R21cell6 != null) {
		    	R21cell6.setCellValue(BRF104.getR21_NUMBER_OF_TIME_RESTRUCTURED() == null ? 0 :
		    	BRF104.getR21_NUMBER_OF_TIME_RESTRUCTURED().intValue());
		    	}
				
				 Cell R21cell7 = row1.getCell(9);
				 if (R21cell7 != null) {
				     Date dateValue =BRF104.getR21_DATE_OF_PREVIOUS_RESTRUCTURE (); // Assuming this returns a Date object
				     SimpleDateFormat DateFormat = new SimpleDateFormat("dd/MM/yyyy"); // Specify your desired date format
				     String formattedDate = (dateValue == null) ? "NA" : DateFormat.format(dateValue);
				     R21cell7.setCellValue(formattedDate);
				 }
				
				Cell R21cell8 = row1.getCell(10);
				 if (R21cell8 != null) {
				   String value = (BRF104.getR21_FUNDED_EXPOSURE() == null) ? "0" : BRF104.getR21_FUNDED_EXPOSURE().toString();
				   R21cell8.setCellValue(value);
				 }
				 
				 Cell R21cell9 = row1.getCell(11);
				 if (R21cell9 != null) {
				   String value = (BRF104.getR21_UNFUNDED_EXPOSURE() == null) ? "NA" : BRF104.getR21_UNFUNDED_EXPOSURE().toString();
				   R21cell9.setCellValue(value);
				 }
				 
				 Cell R21cell10 = row1.getCell(12);
				 if (R21cell10 != null) {
				   String value = (BRF104.getR21_REPAYMENT_AMOUNT() == null) ? "NA" : BRF104.getR21_REPAYMENT_AMOUNT().toString();
				   R21cell10.setCellValue(value);
				 }
				 
				 Cell R21cell11 = row1.getCell(13);
		    	if (R21cell11 != null) {
		    	R21cell11.setCellValue(BRF104.getR21_LEGACY_INTEREST() == null ? 0 :
		    	BRF104.getR21_LEGACY_INTEREST().intValue());
		    	} 
				 
				 
		    	Cell R21cell12 = row1.getCell(14);
		    	if (R21cell12 != null) {
		    	R21cell12.setCellValue(BRF104.getR21_PROVISION_INTEREST() == null ? 0 :
		    	BRF104.getR21_PROVISION_INTEREST().intValue());
		    	}
		    	Cell R21cell13 = row1.getCell(15);
		    	if (R21cell13 != null) {
		    	R21cell13.setCellValue(BRF104.getR21_SPECIFIC_PROVISION() == null ? 0 :
		    	BRF104.getR21_SPECIFIC_PROVISION().intValue());
		    	}
		    	
		    	
		    /////srl_no -30/////////
		    	Row row22 = sheet.getRow(29);

				Cell R22cell = row1.getCell(2);
				 if (R22cell != null) {
				   String value = (BRF104.getR22_BORROWERS_NAME() == null) ? "NA" : BRF104.getR22_BORROWERS_NAME().toString();
				   R22cell.setCellValue(value);
				   }
				   
				   Cell R22cell1 = row1.getCell(3);
				 if (R22cell1 != null) {
				   String value = (BRF104.getR22_CIN() == null) ? "NA" : BRF104.getR22_CIN().toString();
				   R22cell1.setCellValue(value);
				}
				 Cell R22cell2 = row1.getCell(4);
				 if (R22cell2 != null) {
				   String value = (BRF104.getR22_DISTRESSED() == null) ? "NA" : BRF104.getR22_DISTRESSED().toString();
				   R22cell2.setCellValue(value);
				}
		    	Cell R22cell3 = row1.getCell(5);
				 if (R22cell3 != null) {
				   String value = (BRF104.getR22_CURRENT_BANK_INTERNAL_RATING() == null) ? "NA" : BRF104.getR22_CURRENT_BANK_INTERNAL_RATING().toString();
				   R22cell3.setCellValue(value);
				 }
				 
				 Cell R22cell4 = row1.getCell(6);
				 if (R22cell4 != null) {
				   String value = (BRF104.getR22_IFRS_9_STAGE() == null) ? "NA" : BRF104.getR22_IFRS_9_STAGE().toString();
				   R22cell4.setCellValue(value);
				   }
				 Cell R22cell5 = row1.getCell(7);
				 if (R22cell5 != null) {
				     Date dateValue =BRF104.getR22_DATE_OF_RESTRUCTURE (); // Assuming this returns a Date object
				     SimpleDateFormat DateFormat = new SimpleDateFormat("dd/MM/yyyy"); // Specify your desired date format
				     String formattedDate = (dateValue == null) ? "NA" : DateFormat.format(dateValue);
				     R22cell5.setCellValue(formattedDate);
				 }
				 
		    	Cell R22cell6 = row1.getCell(8);
		    	if (R22cell6 != null) {
		    	R22cell6.setCellValue(BRF104.getR22_NUMBER_OF_TIME_RESTRUCTURED() == null ? 0 :
		    	BRF104.getR22_NUMBER_OF_TIME_RESTRUCTURED().intValue());
		    	}
				
				 Cell R22cell7 = row1.getCell(9);
				 if (R22cell7 != null) {
				     Date dateValue =BRF104.getR22_DATE_OF_PREVIOUS_RESTRUCTURE (); // Assuming this returns a Date object
				     SimpleDateFormat DateFormat = new SimpleDateFormat("dd/MM/yyyy"); // Specify your desired date format
				     String formattedDate = (dateValue == null) ? "NA" : DateFormat.format(dateValue);
				     R22cell7.setCellValue(formattedDate);
				 }
				
				Cell R22cell8 = row1.getCell(10);
				 if (R22cell8 != null) {
				   String value = (BRF104.getR22_FUNDED_EXPOSURE() == null) ? "0" : BRF104.getR22_FUNDED_EXPOSURE().toString();
				   R22cell8.setCellValue(value);
				 }
				 
				 Cell R22cell9 = row1.getCell(11);
				 if (R22cell9 != null) {
				   String value = (BRF104.getR22_UNFUNDED_EXPOSURE() == null) ? "NA" : BRF104.getR22_UNFUNDED_EXPOSURE().toString();
				   R22cell9.setCellValue(value);
				 }
				 
				 Cell R22cell10 = row1.getCell(12);
				 if (R22cell10 != null) {
				   String value = (BRF104.getR22_REPAYMENT_AMOUNT() == null) ? "NA" : BRF104.getR22_REPAYMENT_AMOUNT().toString();
				   R22cell10.setCellValue(value);
				 }
				 
				 Cell R22cell11 = row1.getCell(13);
		    	if (R22cell11 != null) {
		    	R22cell11.setCellValue(BRF104.getR22_LEGACY_INTEREST() == null ? 0 :
		    	BRF104.getR22_LEGACY_INTEREST().intValue());
		    	} 
				 
				 
		    	Cell R22cell12 = row1.getCell(14);
		    	if (R22cell12 != null) {
		    	R22cell12.setCellValue(BRF104.getR22_PROVISION_INTEREST() == null ? 0 :
		    	BRF104.getR22_PROVISION_INTEREST().intValue());
		    	}
		    	Cell R22cell13 = row1.getCell(15);
		    	if (R22cell13 != null) {
		    	R22cell13.setCellValue(BRF104.getR22_SPECIFIC_PROVISION() == null ? 0 :
		    	BRF104.getR22_SPECIFIC_PROVISION().intValue());
		    	}
		    	
		    	
		    /////srl_no -31/////////
		    	Row row23 = sheet.getRow(30);

				Cell R23cell = row1.getCell(2);
				 if (R23cell != null) {
				   String value = (BRF104.getR23_BORROWERS_NAME() == null) ? "NA" : BRF104.getR23_BORROWERS_NAME().toString();
				   R23cell.setCellValue(value);
				   }
				   
				   Cell R23cell1 = row1.getCell(3);
				 if (R23cell1 != null) {
				   String value = (BRF104.getR23_CIN() == null) ? "NA" : BRF104.getR23_CIN().toString();
				   R23cell1.setCellValue(value);
				}
				 Cell R23cell2 = row1.getCell(4);
				 if (R23cell2 != null) {
				   String value = (BRF104.getR23_DISTRESSED() == null) ? "NA" : BRF104.getR23_DISTRESSED().toString();
				   R23cell2.setCellValue(value);
				}
		    	Cell R23cell3 = row1.getCell(5);
				 if (R23cell3 != null) {
				   String value = (BRF104.getR23_CURRENT_BANK_INTERNAL_RATING() == null) ? "NA" : BRF104.getR23_CURRENT_BANK_INTERNAL_RATING().toString();
				   R23cell3.setCellValue(value);
				 }
				 
				 Cell R23cell4 = row1.getCell(6);
				 if (R23cell4 != null) {
				   String value = (BRF104.getR23_IFRS_9_STAGE() == null) ? "NA" : BRF104.getR23_IFRS_9_STAGE().toString();
				   R23cell4.setCellValue(value);
				   }
				 Cell R23cell5 = row1.getCell(7);
				 if (R23cell5 != null) {
				     Date dateValue =BRF104.getR23_DATE_OF_RESTRUCTURE (); // Assuming this returns a Date object
				     SimpleDateFormat DateFormat = new SimpleDateFormat("dd/MM/yyyy"); // Specify your desired date format
				     String formattedDate = (dateValue == null) ? "NA" : DateFormat.format(dateValue);
				     R23cell5.setCellValue(formattedDate);
				 }
				 
		    	Cell R23cell6 = row1.getCell(8);
		    	if (R23cell6 != null) {
		    	R23cell6.setCellValue(BRF104.getR23_NUMBER_OF_TIME_RESTRUCTURED() == null ? 0 :
		    	BRF104.getR23_NUMBER_OF_TIME_RESTRUCTURED().intValue());
		    	}
				
				 Cell R23cell7 = row1.getCell(9);
				 if (R23cell7 != null) {
				     Date dateValue =BRF104.getR23_DATE_OF_PREVIOUS_RESTRUCTURE (); // Assuming this returns a Date object
				     SimpleDateFormat DateFormat = new SimpleDateFormat("dd/MM/yyyy"); // Specify your desired date format
				     String formattedDate = (dateValue == null) ? "NA" : DateFormat.format(dateValue);
				     R23cell7.setCellValue(formattedDate);
				 }
				
				Cell R23cell8 = row1.getCell(10);
				 if (R23cell8 != null) {
				   String value = (BRF104.getR23_FUNDED_EXPOSURE() == null) ? "0" : BRF104.getR23_FUNDED_EXPOSURE().toString();
				   R23cell8.setCellValue(value);
				 }
				 
				 Cell R23cell9 = row1.getCell(11);
				 if (R23cell9 != null) {
				   String value = (BRF104.getR23_UNFUNDED_EXPOSURE() == null) ? "NA" : BRF104.getR23_UNFUNDED_EXPOSURE().toString();
				   R23cell9.setCellValue(value);
				 }
				 
				 Cell R23cell10 = row1.getCell(12);
				 if (R23cell10 != null) {
				   String value = (BRF104.getR23_REPAYMENT_AMOUNT() == null) ? "NA" : BRF104.getR23_REPAYMENT_AMOUNT().toString();
				   R23cell10.setCellValue(value);
				 }
				 
				 Cell R23cell11 = row1.getCell(13);
		    	if (R23cell11 != null) {
		    	R23cell11.setCellValue(BRF104.getR23_LEGACY_INTEREST() == null ? 0 :
		    	BRF104.getR23_LEGACY_INTEREST().intValue());
		    	} 
				 
				 
		    	Cell R23cell12 = row1.getCell(14);
		    	if (R23cell12 != null) {
		    	R23cell12.setCellValue(BRF104.getR23_PROVISION_INTEREST() == null ? 0 :
		    	BRF104.getR23_PROVISION_INTEREST().intValue());
		    	}
		    	Cell R23cell13 = row1.getCell(15);
		    	if (R23cell13 != null) {
		    	R23cell13.setCellValue(BRF104.getR23_SPECIFIC_PROVISION() == null ? 0 :
		    	BRF104.getR23_SPECIFIC_PROVISION().intValue());
		    	}
		    	
		    	
		    /////srl_no -32/////////
		    	Row row24 = sheet.getRow(31);

				Cell R24cell = row1.getCell(2);
				 if (R24cell != null) {
				   String value = (BRF104.getR24_BORROWERS_NAME() == null) ? "NA" : BRF104.getR24_BORROWERS_NAME().toString();
				   R24cell.setCellValue(value);
				   }
				   
				   Cell R24cell1 = row1.getCell(3);
				 if (R24cell1 != null) {
				   String value = (BRF104.getR24_CIN() == null) ? "NA" : BRF104.getR24_CIN().toString();
				   R24cell1.setCellValue(value);
				}
				 Cell R24cell2 = row1.getCell(4);
				 if (R24cell2 != null) {
				   String value = (BRF104.getR24_DISTRESSED() == null) ? "NA" : BRF104.getR24_DISTRESSED().toString();
				   R24cell2.setCellValue(value);
				}
		    	Cell R24cell3 = row1.getCell(5);
				 if (R24cell3 != null) {
				   String value = (BRF104.getR24_CURRENT_BANK_INTERNAL_RATING() == null) ? "NA" : BRF104.getR24_CURRENT_BANK_INTERNAL_RATING().toString();
				   R24cell3.setCellValue(value);
				 }
				 
				 Cell R24cell4 = row1.getCell(6);
				 if (R24cell4 != null) {
				   String value = (BRF104.getR24_IFRS_9_STAGE() == null) ? "NA" : BRF104.getR24_IFRS_9_STAGE().toString();
				   R24cell4.setCellValue(value);
				   }
				 Cell R24cell5 = row1.getCell(7);
				 if (R24cell5 != null) {
				     Date dateValue =BRF104.getR24_DATE_OF_RESTRUCTURE (); // Assuming this returns a Date object
				     SimpleDateFormat DateFormat = new SimpleDateFormat("dd/MM/yyyy"); // Specify your desired date format
				     String formattedDate = (dateValue == null) ? "NA" : DateFormat.format(dateValue);
				     R24cell5.setCellValue(formattedDate);
				 }
				 
		    	Cell R24cell6 = row1.getCell(8);
		    	if (R24cell6 != null) {
		    	R24cell6.setCellValue(BRF104.getR24_NUMBER_OF_TIME_RESTRUCTURED() == null ? 0 :
		    	BRF104.getR24_NUMBER_OF_TIME_RESTRUCTURED().intValue());
		    	}
				
				 Cell R24cell7 = row1.getCell(9);
				 if (R24cell7 != null) {
				     Date dateValue =BRF104.getR24_DATE_OF_PREVIOUS_RESTRUCTURE (); // Assuming this returns a Date object
				     SimpleDateFormat DateFormat = new SimpleDateFormat("dd/MM/yyyy"); // Specify your desired date format
				     String formattedDate = (dateValue == null) ? "NA" : DateFormat.format(dateValue);
				     R24cell7.setCellValue(formattedDate);
				 }
				
				Cell R24cell8 = row1.getCell(10);
				 if (R24cell8 != null) {
				   String value = (BRF104.getR24_FUNDED_EXPOSURE() == null) ? "0" : BRF104.getR24_FUNDED_EXPOSURE().toString();
				   R24cell8.setCellValue(value);
				 }
				 
				 Cell R24cell9 = row1.getCell(11);
				 if (R24cell9 != null) {
				   String value = (BRF104.getR24_UNFUNDED_EXPOSURE() == null) ? "NA" : BRF104.getR24_UNFUNDED_EXPOSURE().toString();
				   R24cell9.setCellValue(value);
				 }
				 
				 Cell R24cell10 = row1.getCell(12);
				 if (R24cell10 != null) {
				   String value = (BRF104.getR24_REPAYMENT_AMOUNT() == null) ? "NA" : BRF104.getR24_REPAYMENT_AMOUNT().toString();
				   R24cell10.setCellValue(value);
				 }
				 
				 Cell R24cell11 = row1.getCell(13);
		    	if (R24cell11 != null) {
		    	R24cell11.setCellValue(BRF104.getR24_LEGACY_INTEREST() == null ? 0 :
		    	BRF104.getR24_LEGACY_INTEREST().intValue());
		    	} 
				 
				 
		    	Cell R24cell12 = row1.getCell(14);
		    	if (R24cell12 != null) {
		    	R24cell12.setCellValue(BRF104.getR24_PROVISION_INTEREST() == null ? 0 :
		    	BRF104.getR24_PROVISION_INTEREST().intValue());
		    	}
		    	Cell R24cell13 = row1.getCell(15);
		    	if (R24cell13 != null) {
		    	R24cell13.setCellValue(BRF104.getR24_SPECIFIC_PROVISION() == null ? 0 :
		    	BRF104.getR24_SPECIFIC_PROVISION().intValue());
		    	}
		    	
		    	
		    /////srl_no -33/////////
		    	Row row25 = sheet.getRow(32);

				Cell R25cell = row1.getCell(2);
				 if (R25cell != null) {
				   String value = (BRF104.getR25_BORROWERS_NAME() == null) ? "NA" : BRF104.getR25_BORROWERS_NAME().toString();
				   R25cell.setCellValue(value);
				   }
				   
				   Cell R25cell1 = row1.getCell(3);
				 if (R25cell1 != null) {
				   String value = (BRF104.getR25_CIN() == null) ? "NA" : BRF104.getR25_CIN().toString();
				   R25cell1.setCellValue(value);
				}
				 Cell R25cell2 = row1.getCell(4);
				 if (R25cell2 != null) {
				   String value = (BRF104.getR25_DISTRESSED() == null) ? "NA" : BRF104.getR25_DISTRESSED().toString();
				   R25cell2.setCellValue(value);
				}
		    	Cell R25cell3 = row1.getCell(5);
				 if (R25cell3 != null) {
				   String value = (BRF104.getR25_CURRENT_BANK_INTERNAL_RATING() == null) ? "NA" : BRF104.getR25_CURRENT_BANK_INTERNAL_RATING().toString();
				   R25cell3.setCellValue(value);
				 }
				 
				 Cell R25cell4 = row1.getCell(6);
				 if (R25cell4 != null) {
				   String value = (BRF104.getR25_IFRS_9_STAGE() == null) ? "NA" : BRF104.getR25_IFRS_9_STAGE().toString();
				   R25cell4.setCellValue(value);
				   }
				 Cell R25cell5 = row1.getCell(7);
				 if (R25cell5 != null) {
				     Date dateValue =BRF104.getR25_DATE_OF_RESTRUCTURE (); // Assuming this returns a Date object
				     SimpleDateFormat DateFormat = new SimpleDateFormat("dd/MM/yyyy"); // Specify your desired date format
				     String formattedDate = (dateValue == null) ? "NA" : DateFormat.format(dateValue);
				     R25cell5.setCellValue(formattedDate);
				 }
				 
		    	Cell R25cell6 = row1.getCell(8);
		    	if (R25cell6 != null) {
		    	R25cell6.setCellValue(BRF104.getR25_NUMBER_OF_TIME_RESTRUCTURED() == null ? 0 :
		    	BRF104.getR25_NUMBER_OF_TIME_RESTRUCTURED().intValue());
		    	}
				
				 Cell R25cell7 = row1.getCell(9);
				 if (R25cell7 != null) {
				     Date dateValue =BRF104.getR25_DATE_OF_PREVIOUS_RESTRUCTURE (); // Assuming this returns a Date object
				     SimpleDateFormat DateFormat = new SimpleDateFormat("dd/MM/yyyy"); // Specify your desired date format
				     String formattedDate = (dateValue == null) ? "NA" : DateFormat.format(dateValue);
				     R25cell7.setCellValue(formattedDate);
				 }
				
				Cell R25cell8 = row1.getCell(10);
				 if (R25cell8 != null) {
				   String value = (BRF104.getR25_FUNDED_EXPOSURE() == null) ? "0" : BRF104.getR25_FUNDED_EXPOSURE().toString();
				   R25cell8.setCellValue(value);
				 }
				 
				 Cell R25cell9 = row1.getCell(11);
				 if (R25cell9 != null) {
				   String value = (BRF104.getR25_UNFUNDED_EXPOSURE() == null) ? "NA" : BRF104.getR25_UNFUNDED_EXPOSURE().toString();
				   R25cell9.setCellValue(value);
				 }
				 
				 Cell R25cell10 = row1.getCell(12);
				 if (R25cell10 != null) {
				   String value = (BRF104.getR25_REPAYMENT_AMOUNT() == null) ? "NA" : BRF104.getR25_REPAYMENT_AMOUNT().toString();
				   R25cell10.setCellValue(value);
				 }
				 
				 Cell R25cell11 = row1.getCell(13);
		    	if (R25cell11 != null) {
		    	R25cell11.setCellValue(BRF104.getR25_LEGACY_INTEREST() == null ? 0 :
		    	BRF104.getR25_LEGACY_INTEREST().intValue());
		    	} 
				 
				 
		    	Cell R25cell12 = row1.getCell(14);
		    	if (R25cell12 != null) {
		    	R25cell12.setCellValue(BRF104.getR25_PROVISION_INTEREST() == null ? 0 :
		    	BRF104.getR25_PROVISION_INTEREST().intValue());
		    	}
		    	Cell R25cell13 = row1.getCell(15);
		    	if (R25cell13 != null) {
		    	R25cell13.setCellValue(BRF104.getR25_SPECIFIC_PROVISION() == null ? 0 :
		    	BRF104.getR25_SPECIFIC_PROVISION().intValue());
		    	}
		    	
		    	
		    /////srl_no -34/////////
		    	Row row26 = sheet.getRow(33);

				Cell R26cell = row1.getCell(2);
				 if (R26cell != null) {
				   String value = (BRF104.getR26_BORROWERS_NAME() == null) ? "NA" : BRF104.getR26_BORROWERS_NAME().toString();
				   R26cell.setCellValue(value);
				   }
				   
				   Cell R26cell1 = row1.getCell(3);
				 if (R26cell1 != null) {
				   String value = (BRF104.getR26_CIN() == null) ? "NA" : BRF104.getR26_CIN().toString();
				   R26cell1.setCellValue(value);
				}
				 Cell R26cell2 = row1.getCell(4);
				 if (R26cell2 != null) {
				   String value = (BRF104.getR26_DISTRESSED() == null) ? "NA" : BRF104.getR26_DISTRESSED().toString();
				   R26cell2.setCellValue(value);
				}
		    	Cell R26cell3 = row1.getCell(5);
				 if (R26cell3 != null) {
				   String value = (BRF104.getR26_CURRENT_BANK_INTERNAL_RATING() == null) ? "NA" : BRF104.getR26_CURRENT_BANK_INTERNAL_RATING().toString();
				   R26cell3.setCellValue(value);
				 }
				 
				 Cell R26cell4 = row1.getCell(6);
				 if (R26cell4 != null) {
				   String value = (BRF104.getR26_IFRS_9_STAGE() == null) ? "NA" : BRF104.getR26_IFRS_9_STAGE().toString();
				   R26cell4.setCellValue(value);
				   }
				 Cell R26cell5 = row1.getCell(7);
				 if (R26cell5 != null) {
				     Date dateValue =BRF104.getR26_DATE_OF_RESTRUCTURE (); // Assuming this returns a Date object
				     SimpleDateFormat DateFormat = new SimpleDateFormat("dd/MM/yyyy"); // Specify your desired date format
				     String formattedDate = (dateValue == null) ? "NA" : DateFormat.format(dateValue);
				     R26cell5.setCellValue(formattedDate);
				 }
				 
		    	Cell R26cell6 = row1.getCell(8);
		    	if (R26cell6 != null) {
		    	R26cell6.setCellValue(BRF104.getR26_NUMBER_OF_TIME_RESTRUCTURED() == null ? 0 :
		    	BRF104.getR26_NUMBER_OF_TIME_RESTRUCTURED().intValue());
		    	}
				
				 Cell R26cell7 = row1.getCell(9);
				 if (R26cell7 != null) {
				     Date dateValue =BRF104.getR26_DATE_OF_PREVIOUS_RESTRUCTURE (); // Assuming this returns a Date object
				     SimpleDateFormat DateFormat = new SimpleDateFormat("dd/MM/yyyy"); // Specify your desired date format
				     String formattedDate = (dateValue == null) ? "NA" : DateFormat.format(dateValue);
				     R26cell7.setCellValue(formattedDate);
				 }
				
				Cell R26cell8 = row1.getCell(10);
				 if (R26cell8 != null) {
				   String value = (BRF104.getR26_FUNDED_EXPOSURE() == null) ? "0" : BRF104.getR26_FUNDED_EXPOSURE().toString();
				   R26cell8.setCellValue(value);
				 }
				 
				 Cell R26cell9 = row1.getCell(11);
				 if (R26cell9 != null) {
				   String value = (BRF104.getR26_UNFUNDED_EXPOSURE() == null) ? "NA" : BRF104.getR26_UNFUNDED_EXPOSURE().toString();
				   R26cell9.setCellValue(value);
				 }
				 
				 Cell R26cell10 = row1.getCell(12);
				 if (R26cell10 != null) {
				   String value = (BRF104.getR26_REPAYMENT_AMOUNT() == null) ? "NA" : BRF104.getR26_REPAYMENT_AMOUNT().toString();
				   R26cell10.setCellValue(value);
				 }
				 
				 Cell R26cell11 = row1.getCell(13);
		    	if (R26cell11 != null) {
		    	R26cell11.setCellValue(BRF104.getR26_LEGACY_INTEREST() == null ? 0 :
		    	BRF104.getR26_LEGACY_INTEREST().intValue());
		    	} 
				 
				 
		    	Cell R26cell12 = row1.getCell(14);
		    	if (R26cell12 != null) {
		    	R26cell12.setCellValue(BRF104.getR26_PROVISION_INTEREST() == null ? 0 :
		    	BRF104.getR26_PROVISION_INTEREST().intValue());
		    	}
		    	Cell R26cell13 = row1.getCell(15);
		    	if (R26cell13 != null) {
		    	R26cell13.setCellValue(BRF104.getR26_SPECIFIC_PROVISION() == null ? 0 :
		    	BRF104.getR26_SPECIFIC_PROVISION().intValue());
		    	}
		    	
		    	
		    /////srl_no -35/////////
		    	Row row27 = sheet.getRow(34);

				Cell R27cell = row1.getCell(2);
				 if (R27cell != null) {
				   String value = (BRF104.getR27_BORROWERS_NAME() == null) ? "NA" : BRF104.getR27_BORROWERS_NAME().toString();
				   R27cell.setCellValue(value);
				   }
				   
				   Cell R27cell1 = row1.getCell(3);
				 if (R27cell1 != null) {
				   String value = (BRF104.getR27_CIN() == null) ? "NA" : BRF104.getR27_CIN().toString();
				   R27cell1.setCellValue(value);
				}
				 Cell R27cell2 = row1.getCell(4);
				 if (R27cell2 != null) {
				   String value = (BRF104.getR27_DISTRESSED() == null) ? "NA" : BRF104.getR27_DISTRESSED().toString();
				   R27cell2.setCellValue(value);
				}
		    	Cell R27cell3 = row1.getCell(5);
				 if (R27cell3 != null) {
				   String value = (BRF104.getR27_CURRENT_BANK_INTERNAL_RATING() == null) ? "NA" : BRF104.getR27_CURRENT_BANK_INTERNAL_RATING().toString();
				   R27cell3.setCellValue(value);
				 }
				 
				 Cell R27cell4 = row1.getCell(6);
				 if (R27cell4 != null) {
				   String value = (BRF104.getR27_IFRS_9_STAGE() == null) ? "NA" : BRF104.getR27_IFRS_9_STAGE().toString();
				   R27cell4.setCellValue(value);
				   }
				 Cell R27cell5 = row1.getCell(7);
				 if (R27cell5 != null) {
				     Date dateValue =BRF104.getR27_DATE_OF_RESTRUCTURE (); // Assuming this returns a Date object
				     SimpleDateFormat DateFormat = new SimpleDateFormat("dd/MM/yyyy"); // Specify your desired date format
				     String formattedDate = (dateValue == null) ? "NA" : DateFormat.format(dateValue);
				     R27cell5.setCellValue(formattedDate);
				 }
				 
		    	Cell R27cell6 = row1.getCell(8);
		    	if (R27cell6 != null) {
		    	R27cell6.setCellValue(BRF104.getR27_NUMBER_OF_TIME_RESTRUCTURED() == null ? 0 :
		    	BRF104.getR27_NUMBER_OF_TIME_RESTRUCTURED().intValue());
		    	}
				
				 Cell R27cell7 = row1.getCell(9);
				 if (R27cell7 != null) {
				     Date dateValue =BRF104.getR27_DATE_OF_PREVIOUS_RESTRUCTURE (); // Assuming this returns a Date object
				     SimpleDateFormat DateFormat = new SimpleDateFormat("dd/MM/yyyy"); // Specify your desired date format
				     String formattedDate = (dateValue == null) ? "NA" : DateFormat.format(dateValue);
				     R27cell7.setCellValue(formattedDate);
				 }
				
				Cell R27cell8 = row1.getCell(10);
				 if (R27cell8 != null) {
				   String value = (BRF104.getR27_FUNDED_EXPOSURE() == null) ? "0" : BRF104.getR27_FUNDED_EXPOSURE().toString();
				   R27cell8.setCellValue(value);
				 }
				 
				 Cell R27cell9 = row1.getCell(11);
				 if (R27cell9 != null) {
				   String value = (BRF104.getR27_UNFUNDED_EXPOSURE() == null) ? "NA" : BRF104.getR27_UNFUNDED_EXPOSURE().toString();
				   R27cell9.setCellValue(value);
				 }
				 
				 Cell R27cell10 = row1.getCell(12);
				 if (R27cell10 != null) {
				   String value = (BRF104.getR27_REPAYMENT_AMOUNT() == null) ? "NA" : BRF104.getR27_REPAYMENT_AMOUNT().toString();
				   R27cell10.setCellValue(value);
				 }
				 
				 Cell R27cell11 = row1.getCell(13);
		    	if (R27cell11 != null) {
		    	R27cell11.setCellValue(BRF104.getR27_LEGACY_INTEREST() == null ? 0 :
		    	BRF104.getR27_LEGACY_INTEREST().intValue());
		    	} 
				 
				 
		    	Cell R27cell12 = row1.getCell(14);
		    	if (R27cell12 != null) {
		    	R27cell12.setCellValue(BRF104.getR27_PROVISION_INTEREST() == null ? 0 :
		    	BRF104.getR27_PROVISION_INTEREST().intValue());
		    	}
		    	Cell R27cell13 = row1.getCell(15);
		    	if (R27cell13 != null) {
		    	R27cell13.setCellValue(BRF104.getR27_SPECIFIC_PROVISION() == null ? 0 :
		    	BRF104.getR27_SPECIFIC_PROVISION().intValue());
		    	}
		    	
		    	
		    /////srl_no -36/////////
		    	Row row28 = sheet.getRow(35);

				Cell R28cell = row1.getCell(2);
				 if (R28cell != null) {
				   String value = (BRF104.getR28_BORROWERS_NAME() == null) ? "NA" : BRF104.getR28_BORROWERS_NAME().toString();
				   R28cell.setCellValue(value);
				   }
				   
				   Cell R28cell1 = row1.getCell(3);
				 if (R28cell1 != null) {
				   String value = (BRF104.getR28_CIN() == null) ? "NA" : BRF104.getR28_CIN().toString();
				   R28cell1.setCellValue(value);
				}
				 Cell R28cell2 = row1.getCell(4);
				 if (R28cell2 != null) {
				   String value = (BRF104.getR28_DISTRESSED() == null) ? "NA" : BRF104.getR28_DISTRESSED().toString();
				   R28cell2.setCellValue(value);
				}
		    	Cell R28cell3 = row1.getCell(5);
				 if (R28cell3 != null) {
				   String value = (BRF104.getR28_CURRENT_BANK_INTERNAL_RATING() == null) ? "NA" : BRF104.getR28_CURRENT_BANK_INTERNAL_RATING().toString();
				   R28cell3.setCellValue(value);
				 }
				 
				 Cell R28cell4 = row1.getCell(6);
				 if (R28cell4 != null) {
				   String value = (BRF104.getR28_IFRS_9_STAGE() == null) ? "NA" : BRF104.getR28_IFRS_9_STAGE().toString();
				   R28cell4.setCellValue(value);
				   }
				 Cell R28cell5 = row1.getCell(7);
				 if (R28cell5 != null) {
				     Date dateValue =BRF104.getR28_DATE_OF_RESTRUCTURE (); // Assuming this returns a Date object
				     SimpleDateFormat DateFormat = new SimpleDateFormat("dd/MM/yyyy"); // Specify your desired date format
				     String formattedDate = (dateValue == null) ? "NA" : DateFormat.format(dateValue);
				     R28cell5.setCellValue(formattedDate);
				 }
				 
		    	Cell R28cell6 = row1.getCell(8);
		    	if (R28cell6 != null) {
		    	R28cell6.setCellValue(BRF104.getR28_NUMBER_OF_TIME_RESTRUCTURED() == null ? 0 :
		    	BRF104.getR28_NUMBER_OF_TIME_RESTRUCTURED().intValue());
		    	}
				
				 Cell R28cell7 = row1.getCell(9);
				 if (R28cell7 != null) {
				     Date dateValue =BRF104.getR28_DATE_OF_PREVIOUS_RESTRUCTURE (); // Assuming this returns a Date object
				     SimpleDateFormat DateFormat = new SimpleDateFormat("dd/MM/yyyy"); // Specify your desired date format
				     String formattedDate = (dateValue == null) ? "NA" : DateFormat.format(dateValue);
				     R28cell7.setCellValue(formattedDate);
				 }
				
				Cell R28cell8 = row1.getCell(10);
				 if (R28cell8 != null) {
				   String value = (BRF104.getR28_FUNDED_EXPOSURE() == null) ? "0" : BRF104.getR28_FUNDED_EXPOSURE().toString();
				   R28cell8.setCellValue(value);
				 }
				 
				 Cell R28cell9 = row1.getCell(11);
				 if (R28cell9 != null) {
				   String value = (BRF104.getR28_UNFUNDED_EXPOSURE() == null) ? "NA" : BRF104.getR28_UNFUNDED_EXPOSURE().toString();
				   R28cell9.setCellValue(value);
				 }
				 
				 Cell R28cell10 = row1.getCell(12);
				 if (R28cell10 != null) {
				   String value = (BRF104.getR28_REPAYMENT_AMOUNT() == null) ? "NA" : BRF104.getR28_REPAYMENT_AMOUNT().toString();
				   R28cell10.setCellValue(value);
				 }
				 
				 Cell R28cell11 = row1.getCell(13);
		    	if (R28cell11 != null) {
		    	R28cell11.setCellValue(BRF104.getR28_LEGACY_INTEREST() == null ? 0 :
		    	BRF104.getR28_LEGACY_INTEREST().intValue());
		    	} 
				 
				 
		    	Cell R28cell12 = row1.getCell(14);
		    	if (R28cell12 != null) {
		    	R28cell12.setCellValue(BRF104.getR28_PROVISION_INTEREST() == null ? 0 :
		    	BRF104.getR28_PROVISION_INTEREST().intValue());
		    	}
		    	Cell R28cell13 = row1.getCell(15);
		    	if (R28cell13 != null) {
		    	R28cell13.setCellValue(BRF104.getR28_SPECIFIC_PROVISION() == null ? 0 :
		    	BRF104.getR28_SPECIFIC_PROVISION().intValue());
		    	}
		    	
		    	
		    	
		    /////srl_no -37/////////
		    	Row row29 = sheet.getRow(36);

				Cell R29cell = row1.getCell(2);
				 if (R29cell != null) {
				   String value = (BRF104.getR29_BORROWERS_NAME() == null) ? "NA" : BRF104.getR29_BORROWERS_NAME().toString();
				   R29cell.setCellValue(value);
				   }
				   
				   Cell R29cell1 = row1.getCell(3);
				 if (R29cell1 != null) {
				   String value = (BRF104.getR29_CIN() == null) ? "NA" : BRF104.getR29_CIN().toString();
				   R29cell1.setCellValue(value);
				}
				 Cell R29cell2 = row1.getCell(4);
				 if (R29cell2 != null) {
				   String value = (BRF104.getR29_DISTRESSED() == null) ? "NA" : BRF104.getR29_DISTRESSED().toString();
				   R29cell2.setCellValue(value);
				}
		    	Cell R29cell3 = row1.getCell(5);
				 if (R29cell3 != null) {
				   String value = (BRF104.getR29_CURRENT_BANK_INTERNAL_RATING() == null) ? "NA" : BRF104.getR29_CURRENT_BANK_INTERNAL_RATING().toString();
				   R29cell3.setCellValue(value);
				 }
				 
				 Cell R29cell4 = row1.getCell(6);
				 if (R29cell4 != null) {
				   String value = (BRF104.getR29_IFRS_9_STAGE() == null) ? "NA" : BRF104.getR29_IFRS_9_STAGE().toString();
				   R29cell4.setCellValue(value);
				   }
				 Cell R29cell5 = row1.getCell(7);
				 if (R29cell5 != null) {
				     Date dateValue =BRF104.getR29_DATE_OF_RESTRUCTURE (); // Assuming this returns a Date object
				     SimpleDateFormat DateFormat = new SimpleDateFormat("dd/MM/yyyy"); // Specify your desired date format
				     String formattedDate = (dateValue == null) ? "NA" : DateFormat.format(dateValue);
				     R29cell5.setCellValue(formattedDate);
				 }
				 
		    	Cell R29cell6 = row1.getCell(8);
		    	if (R29cell6 != null) {
		    	R29cell6.setCellValue(BRF104.getR29_NUMBER_OF_TIME_RESTRUCTURED() == null ? 0 :
		    	BRF104.getR29_NUMBER_OF_TIME_RESTRUCTURED().intValue());
		    	}
				
				 Cell R29cell7 = row1.getCell(9);
				 if (R29cell7 != null) {
				     Date dateValue =BRF104.getR29_DATE_OF_PREVIOUS_RESTRUCTURE (); // Assuming this returns a Date object
				     SimpleDateFormat DateFormat = new SimpleDateFormat("dd/MM/yyyy"); // Specify your desired date format
				     String formattedDate = (dateValue == null) ? "NA" : DateFormat.format(dateValue);
				     R29cell7.setCellValue(formattedDate);
				 }
				
				Cell R29cell8 = row1.getCell(10);
				 if (R29cell8 != null) {
				   String value = (BRF104.getR29_FUNDED_EXPOSURE() == null) ? "0" : BRF104.getR29_FUNDED_EXPOSURE().toString();
				   R29cell8.setCellValue(value);
				 }
				 
				 Cell R29cell9 = row1.getCell(11);
				 if (R29cell9 != null) {
				   String value = (BRF104.getR29_UNFUNDED_EXPOSURE() == null) ? "NA" : BRF104.getR29_UNFUNDED_EXPOSURE().toString();
				   R29cell9.setCellValue(value);
				 }
				 
				 Cell R29cell10 = row1.getCell(12);
				 if (R29cell10 != null) {
				   String value = (BRF104.getR29_REPAYMENT_AMOUNT() == null) ? "NA" : BRF104.getR29_REPAYMENT_AMOUNT().toString();
				   R29cell10.setCellValue(value);
				 }
				 
				 Cell R29cell11 = row1.getCell(13);
		    	if (R29cell11 != null) {
		    	R29cell11.setCellValue(BRF104.getR29_LEGACY_INTEREST() == null ? 0 :
		    	BRF104.getR29_LEGACY_INTEREST().intValue());
		    	} 
				 
				 
		    	Cell R29cell12 = row1.getCell(14);
		    	if (R29cell12 != null) {
		    	R29cell12.setCellValue(BRF104.getR29_PROVISION_INTEREST() == null ? 0 :
		    	BRF104.getR29_PROVISION_INTEREST().intValue());
		    	}
		    	Cell R29cell13 = row1.getCell(15);
		    	if (R29cell13 != null) {
		    	R29cell13.setCellValue(BRF104.getR29_SPECIFIC_PROVISION() == null ? 0 :
		    	BRF104.getR29_SPECIFIC_PROVISION().intValue());
		    	}
		    	
		    	
		    /////srl_no -38/////////
		    	Row row30 = sheet.getRow(37);

				Cell R30cell = row1.getCell(2);
				 if (R30cell != null) {
				   String value = (BRF104.getR30_BORROWERS_NAME() == null) ? "NA" : BRF104.getR30_BORROWERS_NAME().toString();
				   R30cell.setCellValue(value);
				   }
				   
				   Cell R30cell1 = row1.getCell(3);
				 if (R30cell1 != null) {
				   String value = (BRF104.getR30_CIN() == null) ? "NA" : BRF104.getR30_CIN().toString();
				   R30cell1.setCellValue(value);
				}
				 Cell R30cell2 = row1.getCell(4);
				 if (R30cell2 != null) {
				   String value = (BRF104.getR30_DISTRESSED() == null) ? "NA" : BRF104.getR30_DISTRESSED().toString();
				   R30cell2.setCellValue(value);
				}
		    	Cell R30cell3 = row1.getCell(5);
				 if (R30cell3 != null) {
				   String value = (BRF104.getR30_CURRENT_BANK_INTERNAL_RATING() == null) ? "NA" : BRF104.getR30_CURRENT_BANK_INTERNAL_RATING().toString();
				   R30cell3.setCellValue(value);
				 }
				 
				 Cell R30cell4 = row1.getCell(6);
				 if (R30cell4 != null) {
				   String value = (BRF104.getR30_IFRS_9_STAGE() == null) ? "NA" : BRF104.getR30_IFRS_9_STAGE().toString();
				   R30cell4.setCellValue(value);
				   }
				 Cell R30cell5 = row1.getCell(7);
				 if (R30cell5 != null) {
				     Date dateValue =BRF104.getR30_DATE_OF_RESTRUCTURE (); // Assuming this returns a Date object
				     SimpleDateFormat DateFormat = new SimpleDateFormat("dd/MM/yyyy"); // Specify your desired date format
				     String formattedDate = (dateValue == null) ? "NA" : DateFormat.format(dateValue);
				     R30cell5.setCellValue(formattedDate);
				 }
				 
		    	Cell R30cell6 = row1.getCell(8);
		    	if (R30cell6 != null) {
		    	R30cell6.setCellValue(BRF104.getR30_NUMBER_OF_TIME_RESTRUCTURED() == null ? 0 :
		    	BRF104.getR30_NUMBER_OF_TIME_RESTRUCTURED().intValue());
		    	}
				
				 Cell R30cell7 = row1.getCell(9);
				 if (R30cell7 != null) {
				     Date dateValue =BRF104.getR30_DATE_OF_PREVIOUS_RESTRUCTURE (); // Assuming this returns a Date object
				     SimpleDateFormat DateFormat = new SimpleDateFormat("dd/MM/yyyy"); // Specify your desired date format
				     String formattedDate = (dateValue == null) ? "NA" : DateFormat.format(dateValue);
				     R30cell7.setCellValue(formattedDate);
				 }
				
				Cell R30cell8 = row1.getCell(10);
				 if (R30cell8 != null) {
				   String value = (BRF104.getR30_FUNDED_EXPOSURE() == null) ? "0" : BRF104.getR30_FUNDED_EXPOSURE().toString();
				   R30cell8.setCellValue(value);
				 }
				 
				 Cell R30cell9 = row1.getCell(11);
				 if (R30cell9 != null) {
				   String value = (BRF104.getR30_UNFUNDED_EXPOSURE() == null) ? "NA" : BRF104.getR30_UNFUNDED_EXPOSURE().toString();
				   R30cell9.setCellValue(value);
				 }
				 
				 Cell R30cell10 = row1.getCell(12);
				 if (R30cell10 != null) {
				   String value = (BRF104.getR30_REPAYMENT_AMOUNT() == null) ? "NA" : BRF104.getR30_REPAYMENT_AMOUNT().toString();
				   R30cell10.setCellValue(value);
				 }
				 
				 Cell R30cell11 = row1.getCell(13);
		    	if (R30cell11 != null) {
		    	R30cell11.setCellValue(BRF104.getR30_LEGACY_INTEREST() == null ? 0 :
		    	BRF104.getR30_LEGACY_INTEREST().intValue());
		    	} 
				 
				 
		    	Cell R30cell12 = row1.getCell(14);
		    	if (R30cell12 != null) {
		    	R30cell12.setCellValue(BRF104.getR30_PROVISION_INTEREST() == null ? 0 :
		    	BRF104.getR30_PROVISION_INTEREST().intValue());
		    	}
		    	Cell R30cell13 = row1.getCell(15);
		    	if (R30cell13 != null) {
		    	R30cell13.setCellValue(BRF104.getR30_SPECIFIC_PROVISION() == null ? 0 :
		    	BRF104.getR30_SPECIFIC_PROVISION().intValue());
		    	}
		    	
		    /////srl_no -39/////////
		    	Row row31 = sheet.getRow(38);

				Cell R31cell = row1.getCell(2);
				 if (R31cell != null) {
				   String value = (BRF104.getR31_BORROWERS_NAME() == null) ? "NA" : BRF104.getR31_BORROWERS_NAME().toString();
				   R31cell.setCellValue(value);
				   }
				   
				   Cell R31cell1 = row1.getCell(3);
				 if (R31cell1 != null) {
				   String value = (BRF104.getR31_CIN() == null) ? "NA" : BRF104.getR31_CIN().toString();
				   R31cell1.setCellValue(value);
				}
				 Cell R31cell2 = row1.getCell(4);
				 if (R31cell2 != null) {
				   String value = (BRF104.getR31_DISTRESSED() == null) ? "NA" : BRF104.getR31_DISTRESSED().toString();
				   R31cell2.setCellValue(value);
				}
		    	Cell R31cell3 = row1.getCell(5);
				 if (R31cell3 != null) {
				   String value = (BRF104.getR31_CURRENT_BANK_INTERNAL_RATING() == null) ? "NA" : BRF104.getR31_CURRENT_BANK_INTERNAL_RATING().toString();
				   R31cell3.setCellValue(value);
				 }
				 
				 Cell R31cell4 = row1.getCell(6);
				 if (R31cell4 != null) {
				   String value = (BRF104.getR31_IFRS_9_STAGE() == null) ? "NA" : BRF104.getR31_IFRS_9_STAGE().toString();
				   R31cell4.setCellValue(value);
				   }
				 Cell R31cell5 = row1.getCell(7);
				 if (R31cell5 != null) {
				     Date dateValue =BRF104.getR31_DATE_OF_RESTRUCTURE (); // Assuming this returns a Date object
				     SimpleDateFormat DateFormat = new SimpleDateFormat("dd/MM/yyyy"); // Specify your desired date format
				     String formattedDate = (dateValue == null) ? "NA" : DateFormat.format(dateValue);
				     R31cell5.setCellValue(formattedDate);
				 }
				 
		    	Cell R31cell6 = row1.getCell(8);
		    	if (R31cell6 != null) {
		    	R31cell6.setCellValue(BRF104.getR31_NUMBER_OF_TIME_RESTRUCTURED() == null ? 0 :
		    	BRF104.getR31_NUMBER_OF_TIME_RESTRUCTURED().intValue());
		    	}
				
				 Cell R31cell7 = row1.getCell(9);
				 if (R31cell7 != null) {
				     Date dateValue =BRF104.getR31_DATE_OF_PREVIOUS_RESTRUCTURE (); // Assuming this returns a Date object
				     SimpleDateFormat DateFormat = new SimpleDateFormat("dd/MM/yyyy"); // Specify your desired date format
				     String formattedDate = (dateValue == null) ? "NA" : DateFormat.format(dateValue);
				     R31cell7.setCellValue(formattedDate);
				 }
				
				Cell R31cell8 = row1.getCell(10);
				 if (R31cell8 != null) {
				   String value = (BRF104.getR31_FUNDED_EXPOSURE() == null) ? "0" : BRF104.getR31_FUNDED_EXPOSURE().toString();
				   R31cell8.setCellValue(value);
				 }
				 
				 Cell R31cell9 = row1.getCell(11);
				 if (R31cell9 != null) {
				   String value = (BRF104.getR31_UNFUNDED_EXPOSURE() == null) ? "NA" : BRF104.getR31_UNFUNDED_EXPOSURE().toString();
				   R31cell9.setCellValue(value);
				 }
				 
				 Cell R31cell10 = row1.getCell(12);
				 if (R31cell10 != null) {
				   String value = (BRF104.getR31_REPAYMENT_AMOUNT() == null) ? "NA" : BRF104.getR31_REPAYMENT_AMOUNT().toString();
				   R31cell10.setCellValue(value);
				 }
				 
				 Cell R31cell11 = row1.getCell(13);
		    	if (R31cell11 != null) {
		    	R31cell11.setCellValue(BRF104.getR31_LEGACY_INTEREST() == null ? 0 :
		    	BRF104.getR31_LEGACY_INTEREST().intValue());
		    	} 
				 
				 
		    	Cell R31cell12 = row1.getCell(14);
		    	if (R31cell12 != null) {
		    	R31cell12.setCellValue(BRF104.getR31_PROVISION_INTEREST() == null ? 0 :
		    	BRF104.getR31_PROVISION_INTEREST().intValue());
		    	}
		    	Cell R31cell13 = row1.getCell(15);
		    	if (R31cell13 != null) {
		    	R31cell13.setCellValue(BRF104.getR31_SPECIFIC_PROVISION() == null ? 0 :
		    	BRF104.getR31_SPECIFIC_PROVISION().intValue());
		    	}
		    	
		    	
		    /////srl_no -40/////////
		    	Row row32 = sheet.getRow(39);

				Cell R32cell = row1.getCell(2);
				 if (R32cell != null) {
				   String value = (BRF104.getR32_BORROWERS_NAME() == null) ? "NA" : BRF104.getR32_BORROWERS_NAME().toString();
				   R32cell.setCellValue(value);
				   }
				   
				   Cell R32cell1 = row1.getCell(3);
				 if (R32cell1 != null) {
				   String value = (BRF104.getR32_CIN() == null) ? "NA" : BRF104.getR32_CIN().toString();
				   R32cell1.setCellValue(value);
				}
				 Cell R32cell2 = row1.getCell(4);
				 if (R32cell2 != null) {
				   String value = (BRF104.getR32_DISTRESSED() == null) ? "NA" : BRF104.getR32_DISTRESSED().toString();
				   R32cell2.setCellValue(value);
				}
		    	Cell R32cell3 = row1.getCell(5);
				 if (R32cell3 != null) {
				   String value = (BRF104.getR32_CURRENT_BANK_INTERNAL_RATING() == null) ? "NA" : BRF104.getR32_CURRENT_BANK_INTERNAL_RATING().toString();
				   R32cell3.setCellValue(value);
				 }
				 
				 Cell R32cell4 = row1.getCell(6);
				 if (R32cell4 != null) {
				   String value = (BRF104.getR32_IFRS_9_STAGE() == null) ? "NA" : BRF104.getR32_IFRS_9_STAGE().toString();
				   R32cell4.setCellValue(value);
				   }
				 Cell R32cell5 = row1.getCell(7);
				 if (R32cell5 != null) {
				     Date dateValue =BRF104.getR32_DATE_OF_RESTRUCTURE (); // Assuming this returns a Date object
				     SimpleDateFormat DateFormat = new SimpleDateFormat("dd/MM/yyyy"); // Specify your desired date format
				     String formattedDate = (dateValue == null) ? "NA" : DateFormat.format(dateValue);
				     R32cell5.setCellValue(formattedDate);
				 }
				 
		    	Cell R32cell6 = row1.getCell(8);
		    	if (R32cell6 != null) {
		    	R32cell6.setCellValue(BRF104.getR32_NUMBER_OF_TIME_RESTRUCTURED() == null ? 0 :
		    	BRF104.getR32_NUMBER_OF_TIME_RESTRUCTURED().intValue());
		    	}
				
				 Cell R32cell7 = row1.getCell(9);
				 if (R32cell7 != null) {
				     Date dateValue =BRF104.getR32_DATE_OF_PREVIOUS_RESTRUCTURE (); // Assuming this returns a Date object
				     SimpleDateFormat DateFormat = new SimpleDateFormat("dd/MM/yyyy"); // Specify your desired date format
				     String formattedDate = (dateValue == null) ? "NA" : DateFormat.format(dateValue);
				     R32cell7.setCellValue(formattedDate);
				 }
				
				Cell R32cell8 = row1.getCell(10);
				 if (R32cell8 != null) {
				   String value = (BRF104.getR32_FUNDED_EXPOSURE() == null) ? "0" : BRF104.getR32_FUNDED_EXPOSURE().toString();
				   R32cell8.setCellValue(value);
				 }
				 
				 Cell R32cell9 = row1.getCell(11);
				 if (R32cell9 != null) {
				   String value = (BRF104.getR32_UNFUNDED_EXPOSURE() == null) ? "NA" : BRF104.getR32_UNFUNDED_EXPOSURE().toString();
				   R32cell9.setCellValue(value);
				 }
				 
				 Cell R32cell10 = row1.getCell(12);
				 if (R32cell10 != null) {
				   String value = (BRF104.getR32_REPAYMENT_AMOUNT() == null) ? "NA" : BRF104.getR32_REPAYMENT_AMOUNT().toString();
				   R32cell10.setCellValue(value);
				 }
				 
				 Cell R32cell11 = row1.getCell(13);
		    	if (R32cell11 != null) {
		    	R32cell11.setCellValue(BRF104.getR32_LEGACY_INTEREST() == null ? 0 :
		    	BRF104.getR32_LEGACY_INTEREST().intValue());
		    	} 
				 
				 
		    	Cell R32cell12 = row1.getCell(14);
		    	if (R32cell12 != null) {
		    	R32cell12.setCellValue(BRF104.getR32_PROVISION_INTEREST() == null ? 0 :
		    	BRF104.getR32_PROVISION_INTEREST().intValue());
		    	}
		    	Cell R32cell13 = row1.getCell(15);
		    	if (R32cell13 != null) {
		    	R32cell13.setCellValue(BRF104.getR32_SPECIFIC_PROVISION() == null ? 0 :
		    	BRF104.getR32_SPECIFIC_PROVISION().intValue());
		    	}
		    	
		    	
		    /////srl_no -41/////////
		    	Row row33 = sheet.getRow(40);

				Cell R33cell = row1.getCell(2);
				 if (R33cell != null) {
				   String value = (BRF104.getR33_BORROWERS_NAME() == null) ? "NA" : BRF104.getR33_BORROWERS_NAME().toString();
				   R33cell.setCellValue(value);
				   }
				   
				   Cell R33cell1 = row1.getCell(3);
				 if (R33cell1 != null) {
				   String value = (BRF104.getR33_CIN() == null) ? "NA" : BRF104.getR33_CIN().toString();
				   R33cell1.setCellValue(value);
				}
				 Cell R33cell2 = row1.getCell(4);
				 if (R33cell2 != null) {
				   String value = (BRF104.getR33_DISTRESSED() == null) ? "NA" : BRF104.getR33_DISTRESSED().toString();
				   R33cell2.setCellValue(value);
				}
		    	Cell R33cell3 = row1.getCell(5);
				 if (R33cell3 != null) {
				   String value = (BRF104.getR33_CURRENT_BANK_INTERNAL_RATING() == null) ? "NA" : BRF104.getR33_CURRENT_BANK_INTERNAL_RATING().toString();
				   R33cell3.setCellValue(value);
				 }
				 
				 Cell R33cell4 = row1.getCell(6);
				 if (R33cell4 != null) {
				   String value = (BRF104.getR33_IFRS_9_STAGE() == null) ? "NA" : BRF104.getR33_IFRS_9_STAGE().toString();
				   R33cell4.setCellValue(value);
				   }
				 Cell R33cell5 = row1.getCell(7);
				 if (R33cell5 != null) {
				     Date dateValue =BRF104.getR33_DATE_OF_RESTRUCTURE (); // Assuming this returns a Date object
				     SimpleDateFormat DateFormat = new SimpleDateFormat("dd/MM/yyyy"); // Specify your desired date format
				     String formattedDate = (dateValue == null) ? "NA" : DateFormat.format(dateValue);
				     R33cell5.setCellValue(formattedDate);
				 }
				 
		    	Cell R33cell6 = row1.getCell(8);
		    	if (R33cell6 != null) {
		    	R33cell6.setCellValue(BRF104.getR33_NUMBER_OF_TIME_RESTRUCTURED() == null ? 0 :
		    	BRF104.getR33_NUMBER_OF_TIME_RESTRUCTURED().intValue());
		    	}
				
				 Cell R33cell7 = row1.getCell(9);
				 if (R33cell7 != null) {
				     Date dateValue =BRF104.getR33_DATE_OF_PREVIOUS_RESTRUCTURE (); // Assuming this returns a Date object
				     SimpleDateFormat DateFormat = new SimpleDateFormat("dd/MM/yyyy"); // Specify your desired date format
				     String formattedDate = (dateValue == null) ? "NA" : DateFormat.format(dateValue);
				     R33cell7.setCellValue(formattedDate);
				 }
				
				Cell R33cell8 = row1.getCell(10);
				 if (R33cell8 != null) {
				   String value = (BRF104.getR33_FUNDED_EXPOSURE() == null) ? "0" : BRF104.getR33_FUNDED_EXPOSURE().toString();
				   R33cell8.setCellValue(value);
				 }
				 
				 Cell R33cell9 = row1.getCell(11);
				 if (R33cell9 != null) {
				   String value = (BRF104.getR33_UNFUNDED_EXPOSURE() == null) ? "NA" : BRF104.getR33_UNFUNDED_EXPOSURE().toString();
				   R33cell9.setCellValue(value);
				 }
				 
				 Cell R33cell10 = row1.getCell(12);
				 if (R33cell10 != null) {
				   String value = (BRF104.getR33_REPAYMENT_AMOUNT() == null) ? "NA" : BRF104.getR33_REPAYMENT_AMOUNT().toString();
				   R33cell10.setCellValue(value);
				 }
				 
				 Cell R33cell11 = row1.getCell(13);
		    	if (R33cell11 != null) {
		    	R33cell11.setCellValue(BRF104.getR33_LEGACY_INTEREST() == null ? 0 :
		    	BRF104.getR33_LEGACY_INTEREST().intValue());
		    	} 
				 
				 
		    	Cell R33cell12 = row1.getCell(14);
		    	if (R33cell12 != null) {
		    	R33cell12.setCellValue(BRF104.getR33_PROVISION_INTEREST() == null ? 0 :
		    	BRF104.getR33_PROVISION_INTEREST().intValue());
		    	}
		    	Cell R33cell13 = row1.getCell(15);
		    	if (R33cell13 != null) {
		    	R33cell13.setCellValue(BRF104.getR33_SPECIFIC_PROVISION() == null ? 0 :
		    	BRF104.getR33_SPECIFIC_PROVISION().intValue());
		    	}
		    	
		    	
		    /////srl_no -42/////////
		    	Row row34 = sheet.getRow(41);

				Cell R34cell = row1.getCell(2);
				 if (R34cell != null) {
				   String value = (BRF104.getR34_BORROWERS_NAME() == null) ? "NA" : BRF104.getR34_BORROWERS_NAME().toString();
				   R34cell.setCellValue(value);
				   }
				   
				   Cell R34cell1 = row1.getCell(3);
				 if (R34cell1 != null) {
				   String value = (BRF104.getR34_CIN() == null) ? "NA" : BRF104.getR34_CIN().toString();
				   R34cell1.setCellValue(value);
				}
				 Cell R34cell2 = row1.getCell(4);
				 if (R34cell2 != null) {
				   String value = (BRF104.getR34_DISTRESSED() == null) ? "NA" : BRF104.getR34_DISTRESSED().toString();
				   R34cell2.setCellValue(value);
				}
		    	Cell R34cell3 = row1.getCell(5);
				 if (R34cell3 != null) {
				   String value = (BRF104.getR34_CURRENT_BANK_INTERNAL_RATING() == null) ? "NA" : BRF104.getR34_CURRENT_BANK_INTERNAL_RATING().toString();
				   R34cell3.setCellValue(value);
				 }
				 
				 Cell R34cell4 = row1.getCell(6);
				 if (R34cell4 != null) {
				   String value = (BRF104.getR34_IFRS_9_STAGE() == null) ? "NA" : BRF104.getR34_IFRS_9_STAGE().toString();
				   R34cell4.setCellValue(value);
				   }
				 Cell R34cell5 = row1.getCell(7);
				 if (R34cell5 != null) {
				     Date dateValue =BRF104.getR34_DATE_OF_RESTRUCTURE (); // Assuming this returns a Date object
				     SimpleDateFormat DateFormat = new SimpleDateFormat("dd/MM/yyyy"); // Specify your desired date format
				     String formattedDate = (dateValue == null) ? "NA" : DateFormat.format(dateValue);
				     R34cell5.setCellValue(formattedDate);
				 }
				 
		    	Cell R34cell6 = row1.getCell(8);
		    	if (R34cell6 != null) {
		    	R34cell6.setCellValue(BRF104.getR34_NUMBER_OF_TIME_RESTRUCTURED() == null ? 0 :
		    	BRF104.getR34_NUMBER_OF_TIME_RESTRUCTURED().intValue());
		    	}
				
				 Cell R34cell7 = row1.getCell(9);
				 if (R34cell7 != null) {
				     Date dateValue =BRF104.getR34_DATE_OF_PREVIOUS_RESTRUCTURE (); // Assuming this returns a Date object
				     SimpleDateFormat DateFormat = new SimpleDateFormat("dd/MM/yyyy"); // Specify your desired date format
				     String formattedDate = (dateValue == null) ? "NA" : DateFormat.format(dateValue);
				     R34cell7.setCellValue(formattedDate);
				 }
				
				Cell R34cell8 = row1.getCell(10);
				 if (R34cell8 != null) {
				   String value = (BRF104.getR34_FUNDED_EXPOSURE() == null) ? "0" : BRF104.getR34_FUNDED_EXPOSURE().toString();
				   R34cell8.setCellValue(value);
				 }
				 
				 Cell R34cell9 = row1.getCell(11);
				 if (R34cell9 != null) {
				   String value = (BRF104.getR34_UNFUNDED_EXPOSURE() == null) ? "NA" : BRF104.getR34_UNFUNDED_EXPOSURE().toString();
				   R34cell9.setCellValue(value);
				 }
				 
				 Cell R34cell10 = row1.getCell(12);
				 if (R34cell10 != null) {
				   String value = (BRF104.getR34_REPAYMENT_AMOUNT() == null) ? "NA" : BRF104.getR34_REPAYMENT_AMOUNT().toString();
				   R34cell10.setCellValue(value);
				 }
				 
				 Cell R34cell11 = row1.getCell(13);
		    	if (R34cell11 != null) {
		    	R34cell11.setCellValue(BRF104.getR34_LEGACY_INTEREST() == null ? 0 :
		    	BRF104.getR34_LEGACY_INTEREST().intValue());
		    	} 
				 
				 
		    	Cell R34cell12 = row1.getCell(14);
		    	if (R34cell12 != null) {
		    	R34cell12.setCellValue(BRF104.getR34_PROVISION_INTEREST() == null ? 0 :
		    	BRF104.getR34_PROVISION_INTEREST().intValue());
		    	}
		    	Cell R34cell13 = row1.getCell(15);
		    	if (R34cell13 != null) {
		    	R34cell13.setCellValue(BRF104.getR34_SPECIFIC_PROVISION() == null ? 0 :
		    	BRF104.getR34_SPECIFIC_PROVISION().intValue());
		    	}
		    	
		    	
		    /////srl_no -43/////////
		    	Row row35 = sheet.getRow(42);

				Cell R35cell = row1.getCell(2);
				 if (R35cell != null) {
				   String value = (BRF104.getR35_BORROWERS_NAME() == null) ? "NA" : BRF104.getR35_BORROWERS_NAME().toString();
				   R35cell.setCellValue(value);
				   }
				   
				   Cell R35cell1 = row1.getCell(3);
				 if (R35cell1 != null) {
				   String value = (BRF104.getR35_CIN() == null) ? "NA" : BRF104.getR35_CIN().toString();
				   R35cell1.setCellValue(value);
				}
				 Cell R35cell2 = row1.getCell(4);
				 if (R35cell2 != null) {
				   String value = (BRF104.getR35_DISTRESSED() == null) ? "NA" : BRF104.getR35_DISTRESSED().toString();
				   R35cell2.setCellValue(value);
				}
		    	Cell R35cell3 = row1.getCell(5);
				 if (R35cell3 != null) {
				   String value = (BRF104.getR35_CURRENT_BANK_INTERNAL_RATING() == null) ? "NA" : BRF104.getR35_CURRENT_BANK_INTERNAL_RATING().toString();
				   R35cell3.setCellValue(value);
				 }
				 
				 Cell R35cell4 = row1.getCell(6);
				 if (R35cell4 != null) {
				   String value = (BRF104.getR35_IFRS_9_STAGE() == null) ? "NA" : BRF104.getR35_IFRS_9_STAGE().toString();
				   R35cell4.setCellValue(value);
				   }
				 Cell R35cell5 = row1.getCell(7);
				 if (R35cell5 != null) {
				     Date dateValue =BRF104.getR35_DATE_OF_RESTRUCTURE (); // Assuming this returns a Date object
				     SimpleDateFormat DateFormat = new SimpleDateFormat("dd/MM/yyyy"); // Specify your desired date format
				     String formattedDate = (dateValue == null) ? "NA" : DateFormat.format(dateValue);
				     R35cell5.setCellValue(formattedDate);
				 }
				 
		    	Cell R35cell6 = row1.getCell(8);
		    	if (R35cell6 != null) {
		    	R35cell6.setCellValue(BRF104.getR35_NUMBER_OF_TIME_RESTRUCTURED() == null ? 0 :
		    	BRF104.getR35_NUMBER_OF_TIME_RESTRUCTURED().intValue());
		    	}
				
				 Cell R35cell7 = row1.getCell(9);
				 if (R35cell7 != null) {
				     Date dateValue =BRF104.getR35_DATE_OF_PREVIOUS_RESTRUCTURE (); // Assuming this returns a Date object
				     SimpleDateFormat DateFormat = new SimpleDateFormat("dd/MM/yyyy"); // Specify your desired date format
				     String formattedDate = (dateValue == null) ? "NA" : DateFormat.format(dateValue);
				     R35cell7.setCellValue(formattedDate);
				 }
				
				Cell R35cell8 = row1.getCell(10);
				 if (R35cell8 != null) {
				   String value = (BRF104.getR35_FUNDED_EXPOSURE() == null) ? "0" : BRF104.getR35_FUNDED_EXPOSURE().toString();
				   R35cell8.setCellValue(value);
				 }
				 
				 Cell R35cell9 = row1.getCell(11);
				 if (R35cell9 != null) {
				   String value = (BRF104.getR35_UNFUNDED_EXPOSURE() == null) ? "NA" : BRF104.getR35_UNFUNDED_EXPOSURE().toString();
				   R35cell9.setCellValue(value);
				 }
				 
				 Cell R35cell10 = row1.getCell(12);
				 if (R35cell10 != null) {
				   String value = (BRF104.getR35_REPAYMENT_AMOUNT() == null) ? "NA" : BRF104.getR35_REPAYMENT_AMOUNT().toString();
				   R35cell10.setCellValue(value);
				 }
				 
				 Cell R35cell11 = row1.getCell(13);
		    	if (R35cell11 != null) {
		    	R35cell11.setCellValue(BRF104.getR35_LEGACY_INTEREST() == null ? 0 :
		    	BRF104.getR35_LEGACY_INTEREST().intValue());
		    	} 
				 
				 
		    	Cell R35cell12 = row1.getCell(14);
		    	if (R35cell12 != null) {
		    	R35cell12.setCellValue(BRF104.getR35_PROVISION_INTEREST() == null ? 0 :
		    	BRF104.getR35_PROVISION_INTEREST().intValue());
		    	}
		    	Cell R35cell13 = row1.getCell(15);
		    	if (R35cell13 != null) {
		    	R35cell13.setCellValue(BRF104.getR35_SPECIFIC_PROVISION() == null ? 0 :
		    	BRF104.getR35_SPECIFIC_PROVISION().intValue());
		    	}
		    	
		    	
		    /////srl_no -44/////////
		    	Row row36 = sheet.getRow(43);

				Cell R36cell = row1.getCell(2);
				 if (R36cell != null) {
				   String value = (BRF104.getR36_BORROWERS_NAME() == null) ? "NA" : BRF104.getR36_BORROWERS_NAME().toString();
				   R36cell.setCellValue(value);
				   }
				   
				   Cell R36cell1 = row1.getCell(3);
				 if (R36cell1 != null) {
				   String value = (BRF104.getR36_CIN() == null) ? "NA" : BRF104.getR36_CIN().toString();
				   R36cell1.setCellValue(value);
				}
				 Cell R36cell2 = row1.getCell(4);
				 if (R36cell2 != null) {
				   String value = (BRF104.getR36_DISTRESSED() == null) ? "NA" : BRF104.getR36_DISTRESSED().toString();
				   R36cell2.setCellValue(value);
				}
		    	Cell R36cell3 = row1.getCell(5);
				 if (R36cell3 != null) {
				   String value = (BRF104.getR36_CURRENT_BANK_INTERNAL_RATING() == null) ? "NA" : BRF104.getR36_CURRENT_BANK_INTERNAL_RATING().toString();
				   R36cell3.setCellValue(value);
				 }
				 
				 Cell R36cell4 = row1.getCell(6);
				 if (R36cell4 != null) {
				   String value = (BRF104.getR36_IFRS_9_STAGE() == null) ? "NA" : BRF104.getR36_IFRS_9_STAGE().toString();
				   R36cell4.setCellValue(value);
				   }
				 Cell R36cell5 = row1.getCell(7);
				 if (R36cell5 != null) {
				     Date dateValue =BRF104.getR36_DATE_OF_RESTRUCTURE (); // Assuming this returns a Date object
				     SimpleDateFormat DateFormat = new SimpleDateFormat("dd/MM/yyyy"); // Specify your desired date format
				     String formattedDate = (dateValue == null) ? "NA" : DateFormat.format(dateValue);
				     R36cell5.setCellValue(formattedDate);
				 }
				 
		    	Cell R36cell6 = row1.getCell(8);
		    	if (R36cell6 != null) {
		    	R36cell6.setCellValue(BRF104.getR36_NUMBER_OF_TIME_RESTRUCTURED() == null ? 0 :
		    	BRF104.getR36_NUMBER_OF_TIME_RESTRUCTURED().intValue());
		    	}
				
				 Cell R36cell7 = row1.getCell(9);
				 if (R36cell7 != null) {
				     Date dateValue =BRF104.getR36_DATE_OF_PREVIOUS_RESTRUCTURE (); // Assuming this returns a Date object
				     SimpleDateFormat DateFormat = new SimpleDateFormat("dd/MM/yyyy"); // Specify your desired date format
				     String formattedDate = (dateValue == null) ? "NA" : DateFormat.format(dateValue);
				     R36cell7.setCellValue(formattedDate);
				 }
				
				Cell R36cell8 = row1.getCell(10);
				 if (R36cell8 != null) {
				   String value = (BRF104.getR36_FUNDED_EXPOSURE() == null) ? "0" : BRF104.getR36_FUNDED_EXPOSURE().toString();
				   R36cell8.setCellValue(value);
				 }
				 
				 Cell R36cell9 = row1.getCell(11);
				 if (R36cell9 != null) {
				   String value = (BRF104.getR36_UNFUNDED_EXPOSURE() == null) ? "NA" : BRF104.getR36_UNFUNDED_EXPOSURE().toString();
				   R36cell9.setCellValue(value);
				 }
				 
				 Cell R36cell10 = row1.getCell(12);
				 if (R36cell10 != null) {
				   String value = (BRF104.getR36_REPAYMENT_AMOUNT() == null) ? "NA" : BRF104.getR36_REPAYMENT_AMOUNT().toString();
				   R36cell10.setCellValue(value);
				 }
				 
				 Cell R36cell11 = row1.getCell(13);
		    	if (R36cell11 != null) {
		    	R36cell11.setCellValue(BRF104.getR36_LEGACY_INTEREST() == null ? 0 :
		    	BRF104.getR36_LEGACY_INTEREST().intValue());
		    	} 
				 
				 
		    	Cell R36cell12 = row1.getCell(14);
		    	if (R36cell12 != null) {
		    	R36cell12.setCellValue(BRF104.getR36_PROVISION_INTEREST() == null ? 0 :
		    	BRF104.getR36_PROVISION_INTEREST().intValue());
		    	}
		    	Cell R36cell13 = row1.getCell(15);
		    	if (R36cell13 != null) {
		    	R36cell13.setCellValue(BRF104.getR36_SPECIFIC_PROVISION() == null ? 0 :
		    	BRF104.getR36_SPECIFIC_PROVISION().intValue());
		    	}
		    	
		    	
		    /////srl_no -45/////////
		    	Row row37 = sheet.getRow(44);

				Cell R37cell = row1.getCell(2);
				 if (R37cell != null) {
				   String value = (BRF104.getR37_BORROWERS_NAME() == null) ? "NA" : BRF104.getR37_BORROWERS_NAME().toString();
				   R37cell.setCellValue(value);
				   }
				   
				   Cell R37cell1 = row1.getCell(3);
				 if (R37cell1 != null) {
				   String value = (BRF104.getR37_CIN() == null) ? "NA" : BRF104.getR37_CIN().toString();
				   R37cell1.setCellValue(value);
				}
				 Cell R37cell2 = row1.getCell(4);
				 if (R37cell2 != null) {
				   String value = (BRF104.getR37_DISTRESSED() == null) ? "NA" : BRF104.getR37_DISTRESSED().toString();
				   R37cell2.setCellValue(value);
				}
		    	Cell R37cell3 = row1.getCell(5);
				 if (R37cell3 != null) {
				   String value = (BRF104.getR37_CURRENT_BANK_INTERNAL_RATING() == null) ? "NA" : BRF104.getR37_CURRENT_BANK_INTERNAL_RATING().toString();
				   R37cell3.setCellValue(value);
				 }
				 
				 Cell R37cell4 = row1.getCell(6);
				 if (R37cell4 != null) {
				   String value = (BRF104.getR37_IFRS_9_STAGE() == null) ? "NA" : BRF104.getR37_IFRS_9_STAGE().toString();
				   R37cell4.setCellValue(value);
				   }
				 Cell R37cell5 = row1.getCell(7);
				 if (R37cell5 != null) {
				     Date dateValue =BRF104.getR37_DATE_OF_RESTRUCTURE (); // Assuming this returns a Date object
				     SimpleDateFormat DateFormat = new SimpleDateFormat("dd/MM/yyyy"); // Specify your desired date format
				     String formattedDate = (dateValue == null) ? "NA" : DateFormat.format(dateValue);
				     R37cell5.setCellValue(formattedDate);
				 }
				 
		    	Cell R37cell6 = row1.getCell(8);
		    	if (R37cell6 != null) {
		    	R37cell6.setCellValue(BRF104.getR37_NUMBER_OF_TIME_RESTRUCTURED() == null ? 0 :
		    	BRF104.getR37_NUMBER_OF_TIME_RESTRUCTURED().intValue());
		    	}
				
				 Cell R37cell7 = row1.getCell(9);
				 if (R37cell7 != null) {
				     Date dateValue =BRF104.getR37_DATE_OF_PREVIOUS_RESTRUCTURE (); // Assuming this returns a Date object
				     SimpleDateFormat DateFormat = new SimpleDateFormat("dd/MM/yyyy"); // Specify your desired date format
				     String formattedDate = (dateValue == null) ? "NA" : DateFormat.format(dateValue);
				     R37cell7.setCellValue(formattedDate);
				 }
				
				Cell R37cell8 = row1.getCell(10);
				 if (R37cell8 != null) {
				   String value = (BRF104.getR37_FUNDED_EXPOSURE() == null) ? "0" : BRF104.getR37_FUNDED_EXPOSURE().toString();
				   R37cell8.setCellValue(value);
				 }
				 
				 Cell R37cell9 = row1.getCell(11);
				 if (R37cell9 != null) {
				   String value = (BRF104.getR37_UNFUNDED_EXPOSURE() == null) ? "NA" : BRF104.getR37_UNFUNDED_EXPOSURE().toString();
				   R37cell9.setCellValue(value);
				 }
				 
				 Cell R37cell10 = row1.getCell(12);
				 if (R37cell10 != null) {
				   String value = (BRF104.getR37_REPAYMENT_AMOUNT() == null) ? "NA" : BRF104.getR37_REPAYMENT_AMOUNT().toString();
				   R37cell10.setCellValue(value);
				 }
				 
				 Cell R37cell11 = row1.getCell(13);
		    	if (R37cell11 != null) {
		    	R37cell11.setCellValue(BRF104.getR37_LEGACY_INTEREST() == null ? 0 :
		    	BRF104.getR37_LEGACY_INTEREST().intValue());
		    	} 
				 
				 
		    	Cell R37cell12 = row1.getCell(14);
		    	if (R37cell12 != null) {
		    	R37cell12.setCellValue(BRF104.getR37_PROVISION_INTEREST() == null ? 0 :
		    	BRF104.getR37_PROVISION_INTEREST().intValue());
		    	}
		    	Cell R37cell13 = row1.getCell(15);
		    	if (R37cell13 != null) {
		    	R37cell13.setCellValue(BRF104.getR37_SPECIFIC_PROVISION() == null ? 0 :
		    	BRF104.getR37_SPECIFIC_PROVISION().intValue());
		    	}
		    	
		    	
		    	
		    /////srl_no -46/////////
		    	Row row38 = sheet.getRow(45);

				Cell R38cell = row1.getCell(2);
				 if (R38cell != null) {
				   String value = (BRF104.getR38_BORROWERS_NAME() == null) ? "NA" : BRF104.getR38_BORROWERS_NAME().toString();
				   R38cell.setCellValue(value);
				   }
				   
				   Cell R38cell1 = row1.getCell(3);
				 if (R38cell1 != null) {
				   String value = (BRF104.getR38_CIN() == null) ? "NA" : BRF104.getR38_CIN().toString();
				   R38cell1.setCellValue(value);
				}
				 Cell R38cell2 = row1.getCell(4);
				 if (R38cell2 != null) {
				   String value = (BRF104.getR38_DISTRESSED() == null) ? "NA" : BRF104.getR38_DISTRESSED().toString();
				   R38cell2.setCellValue(value);
				}
		    	Cell R38cell3 = row1.getCell(5);
				 if (R38cell3 != null) {
				   String value = (BRF104.getR38_CURRENT_BANK_INTERNAL_RATING() == null) ? "NA" : BRF104.getR38_CURRENT_BANK_INTERNAL_RATING().toString();
				   R38cell3.setCellValue(value);
				 }
				 
				 Cell R38cell4 = row1.getCell(6);
				 if (R38cell4 != null) {
				   String value = (BRF104.getR38_IFRS_9_STAGE() == null) ? "NA" : BRF104.getR38_IFRS_9_STAGE().toString();
				   R38cell4.setCellValue(value);
				   }
				 Cell R38cell5 = row1.getCell(7);
				 if (R38cell5 != null) {
				     Date dateValue =BRF104.getR38_DATE_OF_RESTRUCTURE (); // Assuming this returns a Date object
				     SimpleDateFormat DateFormat = new SimpleDateFormat("dd/MM/yyyy"); // Specify your desired date format
				     String formattedDate = (dateValue == null) ? "NA" : DateFormat.format(dateValue);
				     R38cell5.setCellValue(formattedDate);
				 }
				 
		    	Cell R38cell6 = row1.getCell(8);
		    	if (R38cell6 != null) {
		    	R38cell6.setCellValue(BRF104.getR38_NUMBER_OF_TIME_RESTRUCTURED() == null ? 0 :
		    	BRF104.getR38_NUMBER_OF_TIME_RESTRUCTURED().intValue());
		    	}
				
				 Cell R38cell7 = row1.getCell(9);
				 if (R38cell7 != null) {
				     Date dateValue =BRF104.getR38_DATE_OF_PREVIOUS_RESTRUCTURE (); // Assuming this returns a Date object
				     SimpleDateFormat DateFormat = new SimpleDateFormat("dd/MM/yyyy"); // Specify your desired date format
				     String formattedDate = (dateValue == null) ? "NA" : DateFormat.format(dateValue);
				     R38cell7.setCellValue(formattedDate);
				 }
				
				Cell R38cell8 = row1.getCell(10);
				 if (R38cell8 != null) {
				   String value = (BRF104.getR38_FUNDED_EXPOSURE() == null) ? "0" : BRF104.getR38_FUNDED_EXPOSURE().toString();
				   R38cell8.setCellValue(value);
				 }
				 
				 Cell R38cell9 = row1.getCell(11);
				 if (R38cell9 != null) {
				   String value = (BRF104.getR38_UNFUNDED_EXPOSURE() == null) ? "NA" : BRF104.getR38_UNFUNDED_EXPOSURE().toString();
				   R38cell9.setCellValue(value);
				 }
				 
				 Cell R38cell10 = row1.getCell(12);
				 if (R38cell10 != null) {
				   String value = (BRF104.getR38_REPAYMENT_AMOUNT() == null) ? "NA" : BRF104.getR38_REPAYMENT_AMOUNT().toString();
				   R38cell10.setCellValue(value);
				 }
				 
				 Cell R38cell11 = row1.getCell(13);
		    	if (R38cell11 != null) {
		    	R38cell11.setCellValue(BRF104.getR38_LEGACY_INTEREST() == null ? 0 :
		    	BRF104.getR38_LEGACY_INTEREST().intValue());
		    	} 
				 
				 
		    	Cell R38cell12 = row1.getCell(14);
		    	if (R38cell12 != null) {
		    	R38cell12.setCellValue(BRF104.getR38_PROVISION_INTEREST() == null ? 0 :
		    	BRF104.getR38_PROVISION_INTEREST().intValue());
		    	}
		    	Cell R38cell13 = row1.getCell(15);
		    	if (R38cell13 != null) {
		    	R38cell13.setCellValue(BRF104.getR38_SPECIFIC_PROVISION() == null ? 0 :
		    	BRF104.getR38_SPECIFIC_PROVISION().intValue());
		    	}
		    	
		    	
		    /////srl_no -47/////////
		    	Row row39 = sheet.getRow(46);

				Cell R39cell = row1.getCell(2);
				 if (R39cell != null) {
				   String value = (BRF104.getR39_BORROWERS_NAME() == null) ? "NA" : BRF104.getR39_BORROWERS_NAME().toString();
				   R39cell.setCellValue(value);
				   }
				   
				   Cell R39cell1 = row1.getCell(3);
				 if (R39cell1 != null) {
				   String value = (BRF104.getR39_CIN() == null) ? "NA" : BRF104.getR39_CIN().toString();
				   R39cell1.setCellValue(value);
				}
				 Cell R39cell2 = row1.getCell(4);
				 if (R39cell2 != null) {
				   String value = (BRF104.getR39_DISTRESSED() == null) ? "NA" : BRF104.getR39_DISTRESSED().toString();
				   R39cell2.setCellValue(value);
				}
		    	Cell R39cell3 = row1.getCell(5);
				 if (R39cell3 != null) {
				   String value = (BRF104.getR39_CURRENT_BANK_INTERNAL_RATING() == null) ? "NA" : BRF104.getR39_CURRENT_BANK_INTERNAL_RATING().toString();
				   R39cell3.setCellValue(value);
				 }
				 
				 Cell R39cell4 = row1.getCell(6);
				 if (R39cell4 != null) {
				   String value = (BRF104.getR39_IFRS_9_STAGE() == null) ? "NA" : BRF104.getR39_IFRS_9_STAGE().toString();
				   R39cell4.setCellValue(value);
				   }
				 Cell R39cell5 = row1.getCell(7);
				 if (R39cell5 != null) {
				     Date dateValue =BRF104.getR39_DATE_OF_RESTRUCTURE (); // Assuming this returns a Date object
				     SimpleDateFormat DateFormat = new SimpleDateFormat("dd/MM/yyyy"); // Specify your desired date format
				     String formattedDate = (dateValue == null) ? "NA" : DateFormat.format(dateValue);
				     R39cell5.setCellValue(formattedDate);
				 }
				 
		    	Cell R39cell6 = row1.getCell(8);
		    	if (R39cell6 != null) {
		    	R39cell6.setCellValue(BRF104.getR39_NUMBER_OF_TIME_RESTRUCTURED() == null ? 0 :
		    	BRF104.getR39_NUMBER_OF_TIME_RESTRUCTURED().intValue());
		    	}
				
				 Cell R39cell7 = row1.getCell(9);
				 if (R39cell7 != null) {
				     Date dateValue =BRF104.getR39_DATE_OF_PREVIOUS_RESTRUCTURE (); // Assuming this returns a Date object
				     SimpleDateFormat DateFormat = new SimpleDateFormat("dd/MM/yyyy"); // Specify your desired date format
				     String formattedDate = (dateValue == null) ? "NA" : DateFormat.format(dateValue);
				     R39cell7.setCellValue(formattedDate);
				 }
				
				Cell R39cell8 = row1.getCell(10);
				 if (R39cell8 != null) {
				   String value = (BRF104.getR39_FUNDED_EXPOSURE() == null) ? "0" : BRF104.getR39_FUNDED_EXPOSURE().toString();
				   R39cell8.setCellValue(value);
				 }
				 
				 Cell R39cell9 = row1.getCell(11);
				 if (R39cell9 != null) {
				   String value = (BRF104.getR39_UNFUNDED_EXPOSURE() == null) ? "NA" : BRF104.getR39_UNFUNDED_EXPOSURE().toString();
				   R39cell9.setCellValue(value);
				 }
				 
				 Cell R39cell10 = row1.getCell(12);
				 if (R39cell10 != null) {
				   String value = (BRF104.getR39_REPAYMENT_AMOUNT() == null) ? "NA" : BRF104.getR39_REPAYMENT_AMOUNT().toString();
				   R39cell10.setCellValue(value);
				 }
				 
				 Cell R39cell11 = row1.getCell(13);
		    	if (R39cell11 != null) {
		    	R39cell11.setCellValue(BRF104.getR39_LEGACY_INTEREST() == null ? 0 :
		    	BRF104.getR39_LEGACY_INTEREST().intValue());
		    	} 
				 
				 
		    	Cell R39cell12 = row1.getCell(14);
		    	if (R39cell12 != null) {
		    	R39cell12.setCellValue(BRF104.getR39_PROVISION_INTEREST() == null ? 0 :
		    	BRF104.getR39_PROVISION_INTEREST().intValue());
		    	}
		    	Cell R39cell13 = row1.getCell(15);
		    	if (R39cell13 != null) {
		    	R39cell13.setCellValue(BRF104.getR39_SPECIFIC_PROVISION() == null ? 0 :
		    	BRF104.getR39_SPECIFIC_PROVISION().intValue());
		    	}
		    	
		    	
		    /////srl_no -48/////////
		    	Row row40 = sheet.getRow(47);

				Cell R40cell = row1.getCell(2);
				 if (R40cell != null) {
				   String value = (BRF104.getR40_BORROWERS_NAME() == null) ? "NA" : BRF104.getR40_BORROWERS_NAME().toString();
				   R40cell.setCellValue(value);
				   }
				   
				   Cell R40cell1 = row1.getCell(3);
				 if (R40cell1 != null) {
				   String value = (BRF104.getR40_CIN() == null) ? "NA" : BRF104.getR40_CIN().toString();
				   R40cell1.setCellValue(value);
				}
				 Cell R40cell2 = row1.getCell(4);
				 if (R40cell2 != null) {
				   String value = (BRF104.getR40_DISTRESSED() == null) ? "NA" : BRF104.getR40_DISTRESSED().toString();
				   R40cell2.setCellValue(value);
				}
		    	Cell R40cell3 = row1.getCell(5);
				 if (R40cell3 != null) {
				   String value = (BRF104.getR40_CURRENT_BANK_INTERNAL_RATING() == null) ? "NA" : BRF104.getR40_CURRENT_BANK_INTERNAL_RATING().toString();
				   R40cell3.setCellValue(value);
				 }
				 
				 Cell R40cell4 = row1.getCell(6);
				 if (R40cell4 != null) {
				   String value = (BRF104.getR40_IFRS_9_STAGE() == null) ? "NA" : BRF104.getR40_IFRS_9_STAGE().toString();
				   R40cell4.setCellValue(value);
				   }
				 Cell R40cell5 = row1.getCell(7);
				 if (R40cell5 != null) {
				     Date dateValue =BRF104.getR40_DATE_OF_RESTRUCTURE (); // Assuming this returns a Date object
				     SimpleDateFormat DateFormat = new SimpleDateFormat("dd/MM/yyyy"); // Specify your desired date format
				     String formattedDate = (dateValue == null) ? "NA" : DateFormat.format(dateValue);
				     R40cell5.setCellValue(formattedDate);
				 }
				 
		    	Cell R40cell6 = row1.getCell(8);
		    	if (R40cell6 != null) {
		    	R40cell6.setCellValue(BRF104.getR40_NUMBER_OF_TIME_RESTRUCTURED() == null ? 0 :
		    	BRF104.getR40_NUMBER_OF_TIME_RESTRUCTURED().intValue());
		    	}
				
				 Cell R40cell7 = row1.getCell(9);
				 if (R40cell7 != null) {
				     Date dateValue =BRF104.getR40_DATE_OF_PREVIOUS_RESTRUCTURE (); // Assuming this returns a Date object
				     SimpleDateFormat DateFormat = new SimpleDateFormat("dd/MM/yyyy"); // Specify your desired date format
				     String formattedDate = (dateValue == null) ? "NA" : DateFormat.format(dateValue);
				     R40cell7.setCellValue(formattedDate);
				 }
				
				Cell R40cell8 = row1.getCell(10);
				 if (R40cell8 != null) {
				   String value = (BRF104.getR40_FUNDED_EXPOSURE() == null) ? "0" : BRF104.getR40_FUNDED_EXPOSURE().toString();
				   R40cell8.setCellValue(value);
				 }
				 
				 Cell R40cell9 = row1.getCell(11);
				 if (R40cell9 != null) {
				   String value = (BRF104.getR40_UNFUNDED_EXPOSURE() == null) ? "NA" : BRF104.getR40_UNFUNDED_EXPOSURE().toString();
				   R40cell9.setCellValue(value);
				 }
				 
				 Cell R40cell10 = row1.getCell(12);
				 if (R40cell10 != null) {
				   String value = (BRF104.getR40_REPAYMENT_AMOUNT() == null) ? "NA" : BRF104.getR40_REPAYMENT_AMOUNT().toString();
				   R40cell10.setCellValue(value);
				 }
				 
				 Cell R40cell11 = row1.getCell(13);
		    	if (R40cell11 != null) {
		    	R40cell11.setCellValue(BRF104.getR40_LEGACY_INTEREST() == null ? 0 :
		    	BRF104.getR40_LEGACY_INTEREST().intValue());
		    	} 
				 
				 
		    	Cell R40cell12 = row1.getCell(14);
		    	if (R40cell12 != null) {
		    	R40cell12.setCellValue(BRF104.getR40_PROVISION_INTEREST() == null ? 0 :
		    	BRF104.getR40_PROVISION_INTEREST().intValue());
		    	}
		    	Cell R40cell13 = row1.getCell(15);
		    	if (R40cell13 != null) {
		    	R40cell13.setCellValue(BRF104.getR40_SPECIFIC_PROVISION() == null ? 0 :
		    	BRF104.getR40_SPECIFIC_PROVISION().intValue());
		    	}
		    	
		    	
		    /////srl_no -49/////////
		    	Row row41 = sheet.getRow(48);

				Cell R41cell = row1.getCell(2);
				 if (R41cell != null) {
				   String value = (BRF104.getR41_BORROWERS_NAME() == null) ? "NA" : BRF104.getR41_BORROWERS_NAME().toString();
				   R41cell.setCellValue(value);
				   }
				   
				   Cell R41cell1 = row1.getCell(3);
				 if (R41cell1 != null) {
				   String value = (BRF104.getR41_CIN() == null) ? "NA" : BRF104.getR41_CIN().toString();
				   R41cell1.setCellValue(value);
				}
				 Cell R41cell2 = row1.getCell(4);
				 if (R41cell2 != null) {
				   String value = (BRF104.getR41_DISTRESSED() == null) ? "NA" : BRF104.getR41_DISTRESSED().toString();
				   R41cell2.setCellValue(value);
				}
		    	Cell R41cell3 = row1.getCell(5);
				 if (R41cell3 != null) {
				   String value = (BRF104.getR41_CURRENT_BANK_INTERNAL_RATING() == null) ? "NA" : BRF104.getR41_CURRENT_BANK_INTERNAL_RATING().toString();
				   R41cell3.setCellValue(value);
				 }
				 
				 Cell R41cell4 = row1.getCell(6);
				 if (R41cell4 != null) {
				   String value = (BRF104.getR41_IFRS_9_STAGE() == null) ? "NA" : BRF104.getR41_IFRS_9_STAGE().toString();
				   R41cell4.setCellValue(value);
				   }
				 Cell R41cell5 = row1.getCell(7);
				 if (R41cell5 != null) {
				     Date dateValue =BRF104.getR41_DATE_OF_RESTRUCTURE (); // Assuming this returns a Date object
				     SimpleDateFormat DateFormat = new SimpleDateFormat("dd/MM/yyyy"); // Specify your desired date format
				     String formattedDate = (dateValue == null) ? "NA" : DateFormat.format(dateValue);
				     R41cell5.setCellValue(formattedDate);
				 }
				 
		    	Cell R41cell6 = row1.getCell(8);
		    	if (R41cell6 != null) {
		    	R41cell6.setCellValue(BRF104.getR41_NUMBER_OF_TIME_RESTRUCTURED() == null ? 0 :
		    	BRF104.getR41_NUMBER_OF_TIME_RESTRUCTURED().intValue());
		    	}
				
				 Cell R41cell7 = row1.getCell(9);
				 if (R41cell7 != null) {
				     Date dateValue =BRF104.getR41_DATE_OF_PREVIOUS_RESTRUCTURE (); // Assuming this returns a Date object
				     SimpleDateFormat DateFormat = new SimpleDateFormat("dd/MM/yyyy"); // Specify your desired date format
				     String formattedDate = (dateValue == null) ? "NA" : DateFormat.format(dateValue);
				     R41cell7.setCellValue(formattedDate);
				 }
				
				Cell R41cell8 = row1.getCell(10);
				 if (R41cell8 != null) {
				   String value = (BRF104.getR41_FUNDED_EXPOSURE() == null) ? "0" : BRF104.getR41_FUNDED_EXPOSURE().toString();
				   R41cell8.setCellValue(value);
				 }
				 
				 Cell R41cell9 = row1.getCell(11);
				 if (R41cell9 != null) {
				   String value = (BRF104.getR41_UNFUNDED_EXPOSURE() == null) ? "NA" : BRF104.getR41_UNFUNDED_EXPOSURE().toString();
				   R41cell9.setCellValue(value);
				 }
				 
				 Cell R41cell10 = row1.getCell(12);
				 if (R41cell10 != null) {
				   String value = (BRF104.getR41_REPAYMENT_AMOUNT() == null) ? "NA" : BRF104.getR41_REPAYMENT_AMOUNT().toString();
				   R41cell10.setCellValue(value);
				 }
				 
				 Cell R41cell11 = row1.getCell(13);
		    	if (R41cell11 != null) {
		    	R41cell11.setCellValue(BRF104.getR41_LEGACY_INTEREST() == null ? 0 :
		    	BRF104.getR41_LEGACY_INTEREST().intValue());
		    	} 
				 
				 
		    	Cell R41cell12 = row1.getCell(14);
		    	if (R41cell12 != null) {
		    	R41cell12.setCellValue(BRF104.getR41_PROVISION_INTEREST() == null ? 0 :
		    	BRF104.getR41_PROVISION_INTEREST().intValue());
		    	}
		    	Cell R41cell13 = row1.getCell(15);
		    	if (R41cell13 != null) {
		    	R41cell13.setCellValue(BRF104.getR41_SPECIFIC_PROVISION() == null ? 0 :
		    	BRF104.getR41_SPECIFIC_PROVISION().intValue());
		    	}
		    	
		    	
		    /////srl_no -50/////////
		    	Row row42 = sheet.getRow(49);

				Cell R42cell = row1.getCell(2);
				 if (R42cell != null) {
				   String value = (BRF104.getR42_BORROWERS_NAME() == null) ? "NA" : BRF104.getR42_BORROWERS_NAME().toString();
				   R42cell.setCellValue(value);
				   }
				   
				   Cell R42cell1 = row1.getCell(3);
				 if (R42cell1 != null) {
				   String value = (BRF104.getR42_CIN() == null) ? "NA" : BRF104.getR42_CIN().toString();
				   R42cell1.setCellValue(value);
				}
				 Cell R42cell2 = row1.getCell(4);
				 if (R42cell2 != null) {
				   String value = (BRF104.getR42_DISTRESSED() == null) ? "NA" : BRF104.getR42_DISTRESSED().toString();
				   R42cell2.setCellValue(value);
				}
		    	Cell R42cell3 = row1.getCell(5);
				 if (R42cell3 != null) {
				   String value = (BRF104.getR42_CURRENT_BANK_INTERNAL_RATING() == null) ? "NA" : BRF104.getR42_CURRENT_BANK_INTERNAL_RATING().toString();
				   R42cell3.setCellValue(value);
				 }
				 
				 Cell R42cell4 = row1.getCell(6);
				 if (R42cell4 != null) {
				   String value = (BRF104.getR42_IFRS_9_STAGE() == null) ? "NA" : BRF104.getR42_IFRS_9_STAGE().toString();
				   R42cell4.setCellValue(value);
				   }
				 Cell R42cell5 = row1.getCell(7);
				 if (R42cell5 != null) {
				     Date dateValue =BRF104.getR42_DATE_OF_RESTRUCTURE (); // Assuming this returns a Date object
				     SimpleDateFormat DateFormat = new SimpleDateFormat("dd/MM/yyyy"); // Specify your desired date format
				     String formattedDate = (dateValue == null) ? "NA" : DateFormat.format(dateValue);
				     R42cell5.setCellValue(formattedDate);
				 }
				 
		    	Cell R42cell6 = row1.getCell(8);
		    	if (R42cell6 != null) {
		    	R42cell6.setCellValue(BRF104.getR42_NUMBER_OF_TIME_RESTRUCTURED() == null ? 0 :
		    	BRF104.getR42_NUMBER_OF_TIME_RESTRUCTURED().intValue());
		    	}
				
				 Cell R42cell7 = row1.getCell(9);
				 if (R42cell7 != null) {
				     Date dateValue =BRF104.getR42_DATE_OF_PREVIOUS_RESTRUCTURE (); // Assuming this returns a Date object
				     SimpleDateFormat DateFormat = new SimpleDateFormat("dd/MM/yyyy"); // Specify your desired date format
				     String formattedDate = (dateValue == null) ? "NA" : DateFormat.format(dateValue);
				     R42cell7.setCellValue(formattedDate);
				 }
				
				Cell R42cell8 = row1.getCell(10);
				 if (R42cell8 != null) {
				   String value = (BRF104.getR42_FUNDED_EXPOSURE() == null) ? "0" : BRF104.getR42_FUNDED_EXPOSURE().toString();
				   R42cell8.setCellValue(value);
				 }
				 
				 Cell R42cell9 = row1.getCell(11);
				 if (R42cell9 != null) {
				   String value = (BRF104.getR42_UNFUNDED_EXPOSURE() == null) ? "NA" : BRF104.getR42_UNFUNDED_EXPOSURE().toString();
				   R42cell9.setCellValue(value);
				 }
				 
				 Cell R42cell10 = row1.getCell(12);
				 if (R42cell10 != null) {
				   String value = (BRF104.getR42_REPAYMENT_AMOUNT() == null) ? "NA" : BRF104.getR42_REPAYMENT_AMOUNT().toString();
				   R42cell10.setCellValue(value);
				 }
				 
				 Cell R42cell11 = row1.getCell(13);
		    	if (R42cell11 != null) {
		    	R42cell11.setCellValue(BRF104.getR42_LEGACY_INTEREST() == null ? 0 :
		    	BRF104.getR42_LEGACY_INTEREST().intValue());
		    	} 
				 
				 
		    	Cell R42cell12 = row1.getCell(14);
		    	if (R42cell12 != null) {
		    	R42cell12.setCellValue(BRF104.getR42_PROVISION_INTEREST() == null ? 0 :
		    	BRF104.getR42_PROVISION_INTEREST().intValue());
		    	}
		    	Cell R42cell13 = row1.getCell(15);
		    	if (R42cell13 != null) {
		    	R42cell13.setCellValue(BRF104.getR42_SPECIFIC_PROVISION() == null ? 0 :
		    	BRF104.getR42_SPECIFIC_PROVISION().intValue());
		    	}
		    	
		    	
		    /////srl_no -51/////////
		    	Row row43 = sheet.getRow(50);

				Cell R43cell = row1.getCell(2);
				 if (R43cell != null) {
				   String value = (BRF104.getR43_BORROWERS_NAME() == null) ? "NA" : BRF104.getR43_BORROWERS_NAME().toString();
				   R43cell.setCellValue(value);
				   }
				   
				   Cell R43cell1 = row1.getCell(3);
				 if (R43cell1 != null) {
				   String value = (BRF104.getR43_CIN() == null) ? "NA" : BRF104.getR43_CIN().toString();
				   R43cell1.setCellValue(value);
				}
				 Cell R43cell2 = row1.getCell(4);
				 if (R43cell2 != null) {
				   String value = (BRF104.getR43_DISTRESSED() == null) ? "NA" : BRF104.getR43_DISTRESSED().toString();
				   R43cell2.setCellValue(value);
				}
		    	Cell R43cell3 = row1.getCell(5);
				 if (R43cell3 != null) {
				   String value = (BRF104.getR43_CURRENT_BANK_INTERNAL_RATING() == null) ? "NA" : BRF104.getR43_CURRENT_BANK_INTERNAL_RATING().toString();
				   R43cell3.setCellValue(value);
				 }
				 
				 Cell R43cell4 = row1.getCell(6);
				 if (R43cell4 != null) {
				   String value = (BRF104.getR43_IFRS_9_STAGE() == null) ? "NA" : BRF104.getR43_IFRS_9_STAGE().toString();
				   R43cell4.setCellValue(value);
				   }
				 Cell R43cell5 = row1.getCell(7);
				 if (R43cell5 != null) {
				     Date dateValue =BRF104.getR43_DATE_OF_RESTRUCTURE (); // Assuming this returns a Date object
				     SimpleDateFormat DateFormat = new SimpleDateFormat("dd/MM/yyyy"); // Specify your desired date format
				     String formattedDate = (dateValue == null) ? "NA" : DateFormat.format(dateValue);
				     R43cell5.setCellValue(formattedDate);
				 }
				 
		    	Cell R43cell6 = row1.getCell(8);
		    	if (R43cell6 != null) {
		    	R43cell6.setCellValue(BRF104.getR43_NUMBER_OF_TIME_RESTRUCTURED() == null ? 0 :
		    	BRF104.getR43_NUMBER_OF_TIME_RESTRUCTURED().intValue());
		    	}
				
				 Cell R43cell7 = row1.getCell(9);
				 if (R43cell7 != null) {
				     Date dateValue =BRF104.getR43_DATE_OF_PREVIOUS_RESTRUCTURE (); // Assuming this returns a Date object
				     SimpleDateFormat DateFormat = new SimpleDateFormat("dd/MM/yyyy"); // Specify your desired date format
				     String formattedDate = (dateValue == null) ? "NA" : DateFormat.format(dateValue);
				     R43cell7.setCellValue(formattedDate);
				 }
				
				Cell R43cell8 = row1.getCell(10);
				 if (R43cell8 != null) {
				   String value = (BRF104.getR43_FUNDED_EXPOSURE() == null) ? "0" : BRF104.getR43_FUNDED_EXPOSURE().toString();
				   R43cell8.setCellValue(value);
				 }
				 
				 Cell R43cell9 = row1.getCell(11);
				 if (R43cell9 != null) {
				   String value = (BRF104.getR43_UNFUNDED_EXPOSURE() == null) ? "NA" : BRF104.getR43_UNFUNDED_EXPOSURE().toString();
				   R43cell9.setCellValue(value);
				 }
				 
				 Cell R43cell10 = row1.getCell(12);
				 if (R43cell10 != null) {
				   String value = (BRF104.getR43_REPAYMENT_AMOUNT() == null) ? "NA" : BRF104.getR43_REPAYMENT_AMOUNT().toString();
				   R43cell10.setCellValue(value);
				 }
				 
				 Cell R43cell11 = row1.getCell(13);
		    	if (R43cell11 != null) {
		    	R43cell11.setCellValue(BRF104.getR43_LEGACY_INTEREST() == null ? 0 :
		    	BRF104.getR43_LEGACY_INTEREST().intValue());
		    	} 
				 
				 
		    	Cell R43cell12 = row1.getCell(14);
		    	if (R43cell12 != null) {
		    	R43cell12.setCellValue(BRF104.getR43_PROVISION_INTEREST() == null ? 0 :
		    	BRF104.getR43_PROVISION_INTEREST().intValue());
		    	}
		    	Cell R43cell13 = row1.getCell(15);
		    	if (R43cell13 != null) {
		    	R43cell13.setCellValue(BRF104.getR43_SPECIFIC_PROVISION() == null ? 0 :
		    	BRF104.getR43_SPECIFIC_PROVISION().intValue());
		    	}
		    	
		    	
		    /////srl_no -52/////////
		    	Row row44 = sheet.getRow(51);

				Cell R44cell = row1.getCell(2);
				 if (R44cell != null) {
				   String value = (BRF104.getR44_BORROWERS_NAME() == null) ? "NA" : BRF104.getR44_BORROWERS_NAME().toString();
				   R44cell.setCellValue(value);
				   }
				   
				   Cell R44cell1 = row1.getCell(3);
				 if (R44cell1 != null) {
				   String value = (BRF104.getR44_CIN() == null) ? "NA" : BRF104.getR44_CIN().toString();
				   R44cell1.setCellValue(value);
				}
				 Cell R44cell2 = row1.getCell(4);
				 if (R44cell2 != null) {
				   String value = (BRF104.getR44_DISTRESSED() == null) ? "NA" : BRF104.getR44_DISTRESSED().toString();
				   R44cell2.setCellValue(value);
				}
		    	Cell R44cell3 = row1.getCell(5);
				 if (R44cell3 != null) {
				   String value = (BRF104.getR44_CURRENT_BANK_INTERNAL_RATING() == null) ? "NA" : BRF104.getR44_CURRENT_BANK_INTERNAL_RATING().toString();
				   R44cell3.setCellValue(value);
				 }
				 
				 Cell R44cell4 = row1.getCell(6);
				 if (R44cell4 != null) {
				   String value = (BRF104.getR44_IFRS_9_STAGE() == null) ? "NA" : BRF104.getR44_IFRS_9_STAGE().toString();
				   R44cell4.setCellValue(value);
				   }
				 Cell R44cell5 = row1.getCell(7);
				 if (R44cell5 != null) {
				     Date dateValue =BRF104.getR44_DATE_OF_RESTRUCTURE (); // Assuming this returns a Date object
				     SimpleDateFormat DateFormat = new SimpleDateFormat("dd/MM/yyyy"); // Specify your desired date format
				     String formattedDate = (dateValue == null) ? "NA" : DateFormat.format(dateValue);
				     R44cell5.setCellValue(formattedDate);
				 }
				 
		    	Cell R44cell6 = row1.getCell(8);
		    	if (R44cell6 != null) {
		    	R44cell6.setCellValue(BRF104.getR44_NUMBER_OF_TIME_RESTRUCTURED() == null ? 0 :
		    	BRF104.getR44_NUMBER_OF_TIME_RESTRUCTURED().intValue());
		    	}
				
				 Cell R44cell7 = row1.getCell(9);
				 if (R44cell7 != null) {
				     Date dateValue =BRF104.getR44_DATE_OF_PREVIOUS_RESTRUCTURE (); // Assuming this returns a Date object
				     SimpleDateFormat DateFormat = new SimpleDateFormat("dd/MM/yyyy"); // Specify your desired date format
				     String formattedDate = (dateValue == null) ? "NA" : DateFormat.format(dateValue);
				     R44cell7.setCellValue(formattedDate);
				 }
				
				Cell R44cell8 = row1.getCell(10);
				 if (R44cell8 != null) {
				   String value = (BRF104.getR44_FUNDED_EXPOSURE() == null) ? "0" : BRF104.getR44_FUNDED_EXPOSURE().toString();
				   R44cell8.setCellValue(value);
				 }
				 
				 Cell R44cell9 = row1.getCell(11);
				 if (R44cell9 != null) {
				   String value = (BRF104.getR44_UNFUNDED_EXPOSURE() == null) ? "NA" : BRF104.getR44_UNFUNDED_EXPOSURE().toString();
				   R44cell9.setCellValue(value);
				 }
				 
				 Cell R44cell10 = row1.getCell(12);
				 if (R44cell10 != null) {
				   String value = (BRF104.getR44_REPAYMENT_AMOUNT() == null) ? "NA" : BRF104.getR44_REPAYMENT_AMOUNT().toString();
				   R44cell10.setCellValue(value);
				 }
				 
				 Cell R44cell11 = row1.getCell(13);
		    	if (R44cell11 != null) {
		    	R44cell11.setCellValue(BRF104.getR44_LEGACY_INTEREST() == null ? 0 :
		    	BRF104.getR44_LEGACY_INTEREST().intValue());
		    	} 
				 
				 
		    	Cell R44cell12 = row1.getCell(14);
		    	if (R44cell12 != null) {
		    	R44cell12.setCellValue(BRF104.getR44_PROVISION_INTEREST() == null ? 0 :
		    	BRF104.getR44_PROVISION_INTEREST().intValue());
		    	}
		    	Cell R44cell13 = row1.getCell(15);
		    	if (R44cell13 != null) {
		    	R44cell13.setCellValue(BRF104.getR44_SPECIFIC_PROVISION() == null ? 0 :
		    	BRF104.getR44_SPECIFIC_PROVISION().intValue());
		    	}
		    	
		    	
		    /////srl_no -53/////////
		    	Row row45 = sheet.getRow(52);

				Cell R45cell = row1.getCell(2);
				 if (R45cell != null) {
				   String value = (BRF104.getR45_BORROWERS_NAME() == null) ? "NA" : BRF104.getR45_BORROWERS_NAME().toString();
				   R45cell.setCellValue(value);
				   }
				   
				   Cell R45cell1 = row1.getCell(3);
				 if (R45cell1 != null) {
				   String value = (BRF104.getR45_CIN() == null) ? "NA" : BRF104.getR45_CIN().toString();
				   R45cell1.setCellValue(value);
				}
				 Cell R45cell2 = row1.getCell(4);
				 if (R45cell2 != null) {
				   String value = (BRF104.getR45_DISTRESSED() == null) ? "NA" : BRF104.getR45_DISTRESSED().toString();
				   R45cell2.setCellValue(value);
				}
		    	Cell R45cell3 = row1.getCell(5);
				 if (R45cell3 != null) {
				   String value = (BRF104.getR45_CURRENT_BANK_INTERNAL_RATING() == null) ? "NA" : BRF104.getR45_CURRENT_BANK_INTERNAL_RATING().toString();
				   R45cell3.setCellValue(value);
				 }
				 
				 Cell R45cell4 = row1.getCell(6);
				 if (R45cell4 != null) {
				   String value = (BRF104.getR45_IFRS_9_STAGE() == null) ? "NA" : BRF104.getR45_IFRS_9_STAGE().toString();
				   R45cell4.setCellValue(value);
				   }
				 Cell R45cell5 = row1.getCell(7);
				 if (R45cell5 != null) {
				     Date dateValue =BRF104.getR45_DATE_OF_RESTRUCTURE (); // Assuming this returns a Date object
				     SimpleDateFormat DateFormat = new SimpleDateFormat("dd/MM/yyyy"); // Specify your desired date format
				     String formattedDate = (dateValue == null) ? "NA" : DateFormat.format(dateValue);
				     R45cell5.setCellValue(formattedDate);
				 }
				 
		    	Cell R45cell6 = row1.getCell(8);
		    	if (R45cell6 != null) {
		    	R45cell6.setCellValue(BRF104.getR45_NUMBER_OF_TIME_RESTRUCTURED() == null ? 0 :
		    	BRF104.getR45_NUMBER_OF_TIME_RESTRUCTURED().intValue());
		    	}
				
				 Cell R45cell7 = row1.getCell(9);
				 if (R45cell7 != null) {
				     Date dateValue =BRF104.getR45_DATE_OF_PREVIOUS_RESTRUCTURE (); // Assuming this returns a Date object
				     SimpleDateFormat DateFormat = new SimpleDateFormat("dd/MM/yyyy"); // Specify your desired date format
				     String formattedDate = (dateValue == null) ? "NA" : DateFormat.format(dateValue);
				     R45cell7.setCellValue(formattedDate);
				 }
				
				Cell R45cell8 = row1.getCell(10);
				 if (R45cell8 != null) {
				   String value = (BRF104.getR45_FUNDED_EXPOSURE() == null) ? "0" : BRF104.getR45_FUNDED_EXPOSURE().toString();
				   R45cell8.setCellValue(value);
				 }
				 
				 Cell R45cell9 = row1.getCell(11);
				 if (R45cell9 != null) {
				   String value = (BRF104.getR45_UNFUNDED_EXPOSURE() == null) ? "NA" : BRF104.getR45_UNFUNDED_EXPOSURE().toString();
				   R45cell9.setCellValue(value);
				 }
				 
				 Cell R45cell10 = row1.getCell(12);
				 if (R45cell10 != null) {
				   String value = (BRF104.getR45_REPAYMENT_AMOUNT() == null) ? "NA" : BRF104.getR45_REPAYMENT_AMOUNT().toString();
				   R45cell10.setCellValue(value);
				 }
				 
				 Cell R45cell11 = row1.getCell(13);
		    	if (R45cell11 != null) {
		    	R45cell11.setCellValue(BRF104.getR45_LEGACY_INTEREST() == null ? 0 :
		    	BRF104.getR45_LEGACY_INTEREST().intValue());
		    	} 
				 
				 
		    	Cell R45cell12 = row1.getCell(14);
		    	if (R45cell12 != null) {
		    	R45cell12.setCellValue(BRF104.getR45_PROVISION_INTEREST() == null ? 0 :
		    	BRF104.getR45_PROVISION_INTEREST().intValue());
		    	}
		    	Cell R45cell13 = row1.getCell(15);
		    	if (R45cell13 != null) {
		    	R45cell13.setCellValue(BRF104.getR45_SPECIFIC_PROVISION() == null ? 0 :
		    	BRF104.getR45_SPECIFIC_PROVISION().intValue());
		    	}
		    	
		    	
		    /////srl_no -54/////////
		    	Row row46 = sheet.getRow(53);

				Cell R46cell = row1.getCell(2);
				 if (R46cell != null) {
				   String value = (BRF104.getR46_BORROWERS_NAME() == null) ? "NA" : BRF104.getR46_BORROWERS_NAME().toString();
				   R46cell.setCellValue(value);
				   }
				   
				   Cell R46cell1 = row1.getCell(3);
				 if (R46cell1 != null) {
				   String value = (BRF104.getR46_CIN() == null) ? "NA" : BRF104.getR46_CIN().toString();
				   R46cell1.setCellValue(value);
				}
				 Cell R46cell2 = row1.getCell(4);
				 if (R46cell2 != null) {
				   String value = (BRF104.getR46_DISTRESSED() == null) ? "NA" : BRF104.getR46_DISTRESSED().toString();
				   R46cell2.setCellValue(value);
				}
		    	Cell R46cell3 = row1.getCell(5);
				 if (R46cell3 != null) {
				   String value = (BRF104.getR46_CURRENT_BANK_INTERNAL_RATING() == null) ? "NA" : BRF104.getR46_CURRENT_BANK_INTERNAL_RATING().toString();
				   R46cell3.setCellValue(value);
				 }
				 
				 Cell R46cell4 = row1.getCell(6);
				 if (R46cell4 != null) {
				   String value = (BRF104.getR46_IFRS_9_STAGE() == null) ? "NA" : BRF104.getR46_IFRS_9_STAGE().toString();
				   R46cell4.setCellValue(value);
				   }
				 Cell R46cell5 = row1.getCell(7);
				 if (R46cell5 != null) {
				     Date dateValue =BRF104.getR46_DATE_OF_RESTRUCTURE (); // Assuming this returns a Date object
				     SimpleDateFormat DateFormat = new SimpleDateFormat("dd/MM/yyyy"); // Specify your desired date format
				     String formattedDate = (dateValue == null) ? "NA" : DateFormat.format(dateValue);
				     R46cell5.setCellValue(formattedDate);
				 }
				 
		    	Cell R46cell6 = row1.getCell(8);
		    	if (R46cell6 != null) {
		    	R46cell6.setCellValue(BRF104.getR46_NUMBER_OF_TIME_RESTRUCTURED() == null ? 0 :
		    	BRF104.getR46_NUMBER_OF_TIME_RESTRUCTURED().intValue());
		    	}
				
				 Cell R46cell7 = row1.getCell(9);
				 if (R46cell7 != null) {
				     Date dateValue =BRF104.getR46_DATE_OF_PREVIOUS_RESTRUCTURE (); // Assuming this returns a Date object
				     SimpleDateFormat DateFormat = new SimpleDateFormat("dd/MM/yyyy"); // Specify your desired date format
				     String formattedDate = (dateValue == null) ? "NA" : DateFormat.format(dateValue);
				     R46cell7.setCellValue(formattedDate);
				 }
				
				Cell R46cell8 = row1.getCell(10);
				 if (R46cell8 != null) {
				   String value = (BRF104.getR46_FUNDED_EXPOSURE() == null) ? "0" : BRF104.getR46_FUNDED_EXPOSURE().toString();
				   R46cell8.setCellValue(value);
				 }
				 
				 Cell R46cell9 = row1.getCell(11);
				 if (R46cell9 != null) {
				   String value = (BRF104.getR46_UNFUNDED_EXPOSURE() == null) ? "NA" : BRF104.getR46_UNFUNDED_EXPOSURE().toString();
				   R46cell9.setCellValue(value);
				 }
				 
				 Cell R46cell10 = row1.getCell(12);
				 if (R46cell10 != null) {
				   String value = (BRF104.getR46_REPAYMENT_AMOUNT() == null) ? "NA" : BRF104.getR46_REPAYMENT_AMOUNT().toString();
				   R46cell10.setCellValue(value);
				 }
				 
				 Cell R46cell11 = row1.getCell(13);
		    	if (R46cell11 != null) {
		    	R46cell11.setCellValue(BRF104.getR46_LEGACY_INTEREST() == null ? 0 :
		    	BRF104.getR46_LEGACY_INTEREST().intValue());
		    	} 
				 
				 
		    	Cell R46cell12 = row1.getCell(14);
		    	if (R46cell12 != null) {
		    	R46cell12.setCellValue(BRF104.getR46_PROVISION_INTEREST() == null ? 0 :
		    	BRF104.getR46_PROVISION_INTEREST().intValue());
		    	}
		    	Cell R46cell13 = row1.getCell(15);
		    	if (R46cell13 != null) {
		    	R46cell13.setCellValue(BRF104.getR46_SPECIFIC_PROVISION() == null ? 0 :
		    	BRF104.getR46_SPECIFIC_PROVISION().intValue());
		    	}
		    	
		    	
		    	
		    /////srl_no -55/////////
		    	Row row47 = sheet.getRow(54);

				Cell R47cell = row1.getCell(2);
				 if (R47cell != null) {
				   String value = (BRF104.getR47_BORROWERS_NAME() == null) ? "NA" : BRF104.getR47_BORROWERS_NAME().toString();
				   R47cell.setCellValue(value);
				   }
				   
				   Cell R47cell1 = row1.getCell(3);
				 if (R47cell1 != null) {
				   String value = (BRF104.getR47_CIN() == null) ? "NA" : BRF104.getR47_CIN().toString();
				   R47cell1.setCellValue(value);
				}
				 Cell R47cell2 = row1.getCell(4);
				 if (R47cell2 != null) {
				   String value = (BRF104.getR47_DISTRESSED() == null) ? "NA" : BRF104.getR47_DISTRESSED().toString();
				   R47cell2.setCellValue(value);
				}
		    	Cell R47cell3 = row1.getCell(5);
				 if (R47cell3 != null) {
				   String value = (BRF104.getR47_CURRENT_BANK_INTERNAL_RATING() == null) ? "NA" : BRF104.getR47_CURRENT_BANK_INTERNAL_RATING().toString();
				   R47cell3.setCellValue(value);
				 }
				 
				 Cell R47cell4 = row1.getCell(6);
				 if (R47cell4 != null) {
				   String value = (BRF104.getR47_IFRS_9_STAGE() == null) ? "NA" : BRF104.getR47_IFRS_9_STAGE().toString();
				   R47cell4.setCellValue(value);
				   }
				 Cell R47cell5 = row1.getCell(7);
				 if (R47cell5 != null) {
				     Date dateValue =BRF104.getR47_DATE_OF_RESTRUCTURE (); // Assuming this returns a Date object
				     SimpleDateFormat DateFormat = new SimpleDateFormat("dd/MM/yyyy"); // Specify your desired date format
				     String formattedDate = (dateValue == null) ? "NA" : DateFormat.format(dateValue);
				     R47cell5.setCellValue(formattedDate);
				 }
				 
		    	Cell R47cell6 = row1.getCell(8);
		    	if (R47cell6 != null) {
		    	R47cell6.setCellValue(BRF104.getR47_NUMBER_OF_TIME_RESTRUCTURED() == null ? 0 :
		    	BRF104.getR47_NUMBER_OF_TIME_RESTRUCTURED().intValue());
		    	}
				
				 Cell R47cell7 = row1.getCell(9);
				 if (R47cell7 != null) {
				     Date dateValue =BRF104.getR47_DATE_OF_PREVIOUS_RESTRUCTURE (); // Assuming this returns a Date object
				     SimpleDateFormat DateFormat = new SimpleDateFormat("dd/MM/yyyy"); // Specify your desired date format
				     String formattedDate = (dateValue == null) ? "NA" : DateFormat.format(dateValue);
				     R47cell7.setCellValue(formattedDate);
				 }
				
				Cell R47cell8 = row1.getCell(10);
				 if (R47cell8 != null) {
				   String value = (BRF104.getR47_FUNDED_EXPOSURE() == null) ? "0" : BRF104.getR47_FUNDED_EXPOSURE().toString();
				   R47cell8.setCellValue(value);
				 }
				 
				 Cell R47cell9 = row1.getCell(11);
				 if (R47cell9 != null) {
				   String value = (BRF104.getR47_UNFUNDED_EXPOSURE() == null) ? "NA" : BRF104.getR47_UNFUNDED_EXPOSURE().toString();
				   R47cell9.setCellValue(value);
				 }
				 
				 Cell R47cell10 = row1.getCell(12);
				 if (R47cell10 != null) {
				   String value = (BRF104.getR47_REPAYMENT_AMOUNT() == null) ? "NA" : BRF104.getR47_REPAYMENT_AMOUNT().toString();
				   R47cell10.setCellValue(value);
				 }
				 
				 Cell R47cell11 = row1.getCell(13);
		    	if (R47cell11 != null) {
		    	R47cell11.setCellValue(BRF104.getR47_LEGACY_INTEREST() == null ? 0 :
		    	BRF104.getR47_LEGACY_INTEREST().intValue());
		    	} 
				 
				 
		    	Cell R47cell12 = row1.getCell(14);
		    	if (R47cell12 != null) {
		    	R47cell12.setCellValue(BRF104.getR47_PROVISION_INTEREST() == null ? 0 :
		    	BRF104.getR47_PROVISION_INTEREST().intValue());
		    	}
		    	Cell R47cell13 = row1.getCell(15);
		    	if (R47cell13 != null) {
		    	R47cell13.setCellValue(BRF104.getR47_SPECIFIC_PROVISION() == null ? 0 :
		    	BRF104.getR47_SPECIFIC_PROVISION().intValue());
		    	}
		    	
		    	
		    /////srl_no -56/////////
		    	Row row48 = sheet.getRow(55);

				Cell R48cell = row1.getCell(2);
				 if (R48cell != null) {
				   String value = (BRF104.getR48_BORROWERS_NAME() == null) ? "NA" : BRF104.getR48_BORROWERS_NAME().toString();
				   R48cell.setCellValue(value);
				   }
				   
				   Cell R48cell1 = row1.getCell(3);
				 if (R48cell1 != null) {
				   String value = (BRF104.getR48_CIN() == null) ? "NA" : BRF104.getR48_CIN().toString();
				   R48cell1.setCellValue(value);
				}
				 Cell R48cell2 = row1.getCell(4);
				 if (R48cell2 != null) {
				   String value = (BRF104.getR48_DISTRESSED() == null) ? "NA" : BRF104.getR48_DISTRESSED().toString();
				   R48cell2.setCellValue(value);
				}
		    	Cell R48cell3 = row1.getCell(5);
				 if (R48cell3 != null) {
				   String value = (BRF104.getR48_CURRENT_BANK_INTERNAL_RATING() == null) ? "NA" : BRF104.getR48_CURRENT_BANK_INTERNAL_RATING().toString();
				   R48cell3.setCellValue(value);
				 }
				 
				 Cell R48cell4 = row1.getCell(6);
				 if (R48cell4 != null) {
				   String value = (BRF104.getR48_IFRS_9_STAGE() == null) ? "NA" : BRF104.getR48_IFRS_9_STAGE().toString();
				   R48cell4.setCellValue(value);
				   }
				 Cell R48cell5 = row1.getCell(7);
				 if (R48cell5 != null) {
				     Date dateValue =BRF104.getR48_DATE_OF_RESTRUCTURE (); // Assuming this returns a Date object
				     SimpleDateFormat DateFormat = new SimpleDateFormat("dd/MM/yyyy"); // Specify your desired date format
				     String formattedDate = (dateValue == null) ? "NA" : DateFormat.format(dateValue);
				     R48cell5.setCellValue(formattedDate);
				 }
				 
		    	Cell R48cell6 = row1.getCell(8);
		    	if (R48cell6 != null) {
		    	R48cell6.setCellValue(BRF104.getR48_NUMBER_OF_TIME_RESTRUCTURED() == null ? 0 :
		    	BRF104.getR48_NUMBER_OF_TIME_RESTRUCTURED().intValue());
		    	}
				
				 Cell R48cell7 = row1.getCell(9);
				 if (R48cell7 != null) {
				     Date dateValue =BRF104.getR48_DATE_OF_PREVIOUS_RESTRUCTURE (); // Assuming this returns a Date object
				     SimpleDateFormat DateFormat = new SimpleDateFormat("dd/MM/yyyy"); // Specify your desired date format
				     String formattedDate = (dateValue == null) ? "NA" : DateFormat.format(dateValue);
				     R48cell7.setCellValue(formattedDate);
				 }
				
				Cell R48cell8 = row1.getCell(10);
				 if (R48cell8 != null) {
				   String value = (BRF104.getR48_FUNDED_EXPOSURE() == null) ? "0" : BRF104.getR48_FUNDED_EXPOSURE().toString();
				   R48cell8.setCellValue(value);
				 }
				 
				 Cell R48cell9 = row1.getCell(11);
				 if (R48cell9 != null) {
				   String value = (BRF104.getR48_UNFUNDED_EXPOSURE() == null) ? "NA" : BRF104.getR48_UNFUNDED_EXPOSURE().toString();
				   R48cell9.setCellValue(value);
				 }
				 
				 Cell R48cell10 = row1.getCell(12);
				 if (R48cell10 != null) {
				   String value = (BRF104.getR48_REPAYMENT_AMOUNT() == null) ? "NA" : BRF104.getR48_REPAYMENT_AMOUNT().toString();
				   R48cell10.setCellValue(value);
				 }
				 
				 Cell R48cell11 = row1.getCell(13);
		    	if (R48cell11 != null) {
		    	R48cell11.setCellValue(BRF104.getR48_LEGACY_INTEREST() == null ? 0 :
		    	BRF104.getR48_LEGACY_INTEREST().intValue());
		    	} 
				 
				 
		    	Cell R48cell12 = row1.getCell(14);
		    	if (R48cell12 != null) {
		    	R48cell12.setCellValue(BRF104.getR48_PROVISION_INTEREST() == null ? 0 :
		    	BRF104.getR48_PROVISION_INTEREST().intValue());
		    	}
		    	Cell R48cell13 = row1.getCell(15);
		    	if (R48cell13 != null) {
		    	R48cell13.setCellValue(BRF104.getR48_SPECIFIC_PROVISION() == null ? 0 :
		    	BRF104.getR48_SPECIFIC_PROVISION().intValue());
		    	}
		    	
		    	
		    /////srl_no -57/////////
		    	Row row49 = sheet.getRow(56);

				Cell R49cell = row1.getCell(2);
				 if (R49cell != null) {
				   String value = (BRF104.getR49_BORROWERS_NAME() == null) ? "NA" : BRF104.getR49_BORROWERS_NAME().toString();
				   R49cell.setCellValue(value);
				   }
				   
				   Cell R49cell1 = row1.getCell(3);
				 if (R49cell1 != null) {
				   String value = (BRF104.getR49_CIN() == null) ? "NA" : BRF104.getR49_CIN().toString();
				   R49cell1.setCellValue(value);
				}
				 Cell R49cell2 = row1.getCell(4);
				 if (R49cell2 != null) {
				   String value = (BRF104.getR49_DISTRESSED() == null) ? "NA" : BRF104.getR49_DISTRESSED().toString();
				   R49cell2.setCellValue(value);
				}
		    	Cell R49cell3 = row1.getCell(5);
				 if (R49cell3 != null) {
				   String value = (BRF104.getR49_CURRENT_BANK_INTERNAL_RATING() == null) ? "NA" : BRF104.getR49_CURRENT_BANK_INTERNAL_RATING().toString();
				   R49cell3.setCellValue(value);
				 }
				 
				 Cell R49cell4 = row1.getCell(6);
				 if (R49cell4 != null) {
				   String value = (BRF104.getR49_IFRS_9_STAGE() == null) ? "NA" : BRF104.getR49_IFRS_9_STAGE().toString();
				   R49cell4.setCellValue(value);
				   }
				 Cell R49cell5 = row1.getCell(7);
				 if (R49cell5 != null) {
				     Date dateValue =BRF104.getR49_DATE_OF_RESTRUCTURE (); // Assuming this returns a Date object
				     SimpleDateFormat DateFormat = new SimpleDateFormat("dd/MM/yyyy"); // Specify your desired date format
				     String formattedDate = (dateValue == null) ? "NA" : DateFormat.format(dateValue);
				     R49cell5.setCellValue(formattedDate);
				 }
				 
		    	Cell R49cell6 = row1.getCell(8);
		    	if (R49cell6 != null) {
		    	R49cell6.setCellValue(BRF104.getR49_NUMBER_OF_TIME_RESTRUCTURED() == null ? 0 :
		    	BRF104.getR49_NUMBER_OF_TIME_RESTRUCTURED().intValue());
		    	}
				
				 Cell R49cell7 = row1.getCell(9);
				 if (R49cell7 != null) {
				     Date dateValue =BRF104.getR49_DATE_OF_PREVIOUS_RESTRUCTURE (); // Assuming this returns a Date object
				     SimpleDateFormat DateFormat = new SimpleDateFormat("dd/MM/yyyy"); // Specify your desired date format
				     String formattedDate = (dateValue == null) ? "NA" : DateFormat.format(dateValue);
				     R49cell7.setCellValue(formattedDate);
				 }
				
				Cell R49cell8 = row1.getCell(10);
				 if (R49cell8 != null) {
				   String value = (BRF104.getR49_FUNDED_EXPOSURE() == null) ? "0" : BRF104.getR49_FUNDED_EXPOSURE().toString();
				   R49cell8.setCellValue(value);
				 }
				 
				 Cell R49cell9 = row1.getCell(11);
				 if (R49cell9 != null) {
				   String value = (BRF104.getR49_UNFUNDED_EXPOSURE() == null) ? "NA" : BRF104.getR49_UNFUNDED_EXPOSURE().toString();
				   R49cell9.setCellValue(value);
				 }
				 
				 Cell R49cell10 = row1.getCell(12);
				 if (R49cell10 != null) {
				   String value = (BRF104.getR49_REPAYMENT_AMOUNT() == null) ? "NA" : BRF104.getR49_REPAYMENT_AMOUNT().toString();
				   R49cell10.setCellValue(value);
				 }
				 
				 Cell R49cell11 = row1.getCell(13);
		    	if (R49cell11 != null) {
		    	R49cell11.setCellValue(BRF104.getR49_LEGACY_INTEREST() == null ? 0 :
		    	BRF104.getR49_LEGACY_INTEREST().intValue());
		    	} 
				 
				 
		    	Cell R49cell12 = row1.getCell(14);
		    	if (R49cell12 != null) {
		    	R49cell12.setCellValue(BRF104.getR49_PROVISION_INTEREST() == null ? 0 :
		    	BRF104.getR49_PROVISION_INTEREST().intValue());
		    	}
		    	Cell R49cell13 = row1.getCell(15);
		    	if (R49cell13 != null) {
		    	R49cell13.setCellValue(BRF104.getR49_SPECIFIC_PROVISION() == null ? 0 :
		    	BRF104.getR49_SPECIFIC_PROVISION().intValue());
		    	}
		    	
		    	
		    /////srl_no -58/////////
		    	Row row50 = sheet.getRow(57);

				Cell R50cell = row1.getCell(2);
				 if (R50cell != null) {
				   String value = (BRF104.getR50_BORROWERS_NAME() == null) ? "NA" : BRF104.getR50_BORROWERS_NAME().toString();
				   R50cell.setCellValue(value);
				   }
				   
				   Cell R50cell1 = row1.getCell(3);
				 if (R50cell1 != null) {
				   String value = (BRF104.getR50_CIN() == null) ? "NA" : BRF104.getR50_CIN().toString();
				   R50cell1.setCellValue(value);
				}
				 Cell R50cell2 = row1.getCell(4);
				 if (R50cell2 != null) {
				   String value = (BRF104.getR50_DISTRESSED() == null) ? "NA" : BRF104.getR50_DISTRESSED().toString();
				   R50cell2.setCellValue(value);
				}
		    	Cell R50cell3 = row1.getCell(5);
				 if (R50cell3 != null) {
				   String value = (BRF104.getR50_CURRENT_BANK_INTERNAL_RATING() == null) ? "NA" : BRF104.getR50_CURRENT_BANK_INTERNAL_RATING().toString();
				   R50cell3.setCellValue(value);
				 }
				 
				 Cell R50cell4 = row1.getCell(6);
				 if (R50cell4 != null) {
				   String value = (BRF104.getR50_IFRS_9_STAGE() == null) ? "NA" : BRF104.getR50_IFRS_9_STAGE().toString();
				   R50cell4.setCellValue(value);
				   }
				 Cell R50cell5 = row1.getCell(7);
				 if (R50cell5 != null) {
				     Date dateValue =BRF104.getR50_DATE_OF_RESTRUCTURE (); // Assuming this returns a Date object
				     SimpleDateFormat DateFormat = new SimpleDateFormat("dd/MM/yyyy"); // Specify your desired date format
				     String formattedDate = (dateValue == null) ? "NA" : DateFormat.format(dateValue);
				     R50cell5.setCellValue(formattedDate);
				 }
				 
		    	Cell R50cell6 = row1.getCell(8);
		    	if (R50cell6 != null) {
		    	R50cell6.setCellValue(BRF104.getR50_NUMBER_OF_TIME_RESTRUCTURED() == null ? 0 :
		    	BRF104.getR50_NUMBER_OF_TIME_RESTRUCTURED().intValue());
		    	}
				
				 Cell R50cell7 = row1.getCell(9);
				 if (R50cell7 != null) {
				     Date dateValue =BRF104.getR50_DATE_OF_PREVIOUS_RESTRUCTURE (); // Assuming this returns a Date object
				     SimpleDateFormat DateFormat = new SimpleDateFormat("dd/MM/yyyy"); // Specify your desired date format
				     String formattedDate = (dateValue == null) ? "NA" : DateFormat.format(dateValue);
				     R50cell7.setCellValue(formattedDate);
				 }
				
				Cell R50cell8 = row1.getCell(10);
				 if (R50cell8 != null) {
				   String value = (BRF104.getR50_FUNDED_EXPOSURE() == null) ? "0" : BRF104.getR50_FUNDED_EXPOSURE().toString();
				   R50cell8.setCellValue(value);
				 }
				 
				 Cell R50cell9 = row1.getCell(11);
				 if (R50cell9 != null) {
				   String value = (BRF104.getR50_UNFUNDED_EXPOSURE() == null) ? "NA" : BRF104.getR50_UNFUNDED_EXPOSURE().toString();
				   R50cell9.setCellValue(value);
				 }
				 
				 Cell R50cell10 = row1.getCell(12);
				 if (R50cell10 != null) {
				   String value = (BRF104.getR50_REPAYMENT_AMOUNT() == null) ? "NA" : BRF104.getR50_REPAYMENT_AMOUNT().toString();
				   R50cell10.setCellValue(value);
				 }
				 
				 Cell R50cell11 = row1.getCell(13);
		    	if (R50cell11 != null) {
		    	R50cell11.setCellValue(BRF104.getR50_LEGACY_INTEREST() == null ? 0 :
		    	BRF104.getR50_LEGACY_INTEREST().intValue());
		    	} 
				 
				 
		    	Cell R50cell12 = row1.getCell(14);
		    	if (R50cell12 != null) {
		    	R50cell12.setCellValue(BRF104.getR50_PROVISION_INTEREST() == null ? 0 :
		    	BRF104.getR50_PROVISION_INTEREST().intValue());
		    	}
		    	Cell R50cell13 = row1.getCell(15);
		    	if (R50cell13 != null) {
		    	R50cell13.setCellValue(BRF104.getR50_SPECIFIC_PROVISION() == null ? 0 :
		    	BRF104.getR50_SPECIFIC_PROVISION().intValue());
		    	}
		    	
    	
		
    	// Save the changes
 	   workbook.getCreationHelper().createFormulaEvaluator().evaluateAll();
 	        FileOutputStream fileOut = new FileOutputStream(env.getProperty("output.exportpathfinal")+"011-BRF-104-A.xls");
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
 	outputFile = new File(env.getProperty("output.exportpathfinal")+"011-BRF-104-A.xls");

 	return outputFile;



 	}
 			

	
	public String detailChanges104(BRF104_DETAIL_ENTITY detail, String foracid, String report_addl_criteria_1,
	        BigDecimal act_balance_amt_lc, String report_label_1, String report_name_1) {

	    String msg = "";

	    try {
	        // Get the current Hibernate session
	        Session hs = sessionFactory.getCurrentSession();

	        // Find the BRF104_DETAIL_ENTITY object by its foracid
	        Optional<BRF104_DETAIL_ENTITY> brf104DetailOptional = brf104_detailrepo.findById(foracid);

	        if (brf104DetailOptional.isPresent()) {
	            BRF104_DETAIL_ENTITY brfDetail = brf104DetailOptional.get();
	            if (brfDetail != null && report_label_1 != null && report_name_1 != null && report_addl_criteria_1 != null) {
	            	if (act_balance_amt_lc.equals(brfDetail.getAct_balance_amt_lc()) &&
	                        report_label_1.equals(brfDetail.getReport_label_1()) &&
	                        report_name_1.equals(brfDetail.getReport_name_1()) &&
	                        report_addl_criteria_1.equals(brfDetail.getReport_addl_criteria_1())) {
	                    msg = "No modification done";
	                } else {
	                    // Update the BRF104_DETAIL_ENTITY object with the provided parameters
	                    brfDetail.setAct_balance_amt_lc(act_balance_amt_lc);
	                    brfDetail.setReport_label_1(report_label_1);
	                    brfDetail.setReport_name_1(report_name_1);
	                    brfDetail.setReport_addl_criteria_1(report_addl_criteria_1);

	                    // Save the updated object
	                    brf104_detailrepo.save(brfDetail);

	                    // Log the action
	                    logger.info("Edited Record");
	                    msg = "Edited Successfully";
	                }
	            } else {
	                msg = "Some parameters are null";
	            }
	        } else {
	            msg = "No data Found";
	        }

	    } catch (Exception e) {
	        // Handle any exceptions
	        msg = "An error occurred. Please contact Administrator";
	        e.printStackTrace();
	    }

	    return msg;
	}



	/**** ARCH SUMMARY
	 * @throws ParseException ****/

	public ModelAndView getArchieveBRF0104View(String reportId, String fromdate, String todate, String currency,
		String dtltype, Pageable pageable) {

		ModelAndView mv = new ModelAndView();

		Session hs = sessionFactory.getCurrentSession();
		int pageSize = pageable.getPageSize();
		int currentPage = pageable.getPageNumber();
		int startItem = currentPage * pageSize;
		List<BRF104_REPORTENTITY> T1rep = new ArrayList<BRF104_REPORTENTITY>();
		// Query<Object[]> qr;

		List<BRF104_REPORTENTITY> T1Master = new ArrayList<BRF104_REPORTENTITY>();

		logger.info("Inside archive" +currency);

		try {
			
			
			Date d1 = df.parse(todate);
		//	T1rep = t1CurProdServiceRepo.getT1CurProdServices(d1);

			T1Master = hs.createQuery("from BRF104_REPORTENTITY a where a.report_date = ?1 ", BRF104_REPORTENTITY.class)
					.setParameter(1, df.parse(todate)).getResultList();

		} catch (ParseException e) {
			e.printStackTrace();
		}

		// T1rep = t1CurProdServiceRepo.getT1CurProdServices(d1);

		mv.setViewName("RR/BRF104ARCH");
		// mv.addObject("currlist", refCodeConfig.currList());
		mv.addObject("reportsummary", T1Master);
		mv.addObject("reportmaster", T1Master);
		mv.addObject("displaymode", "summary");
		mv.addObject("reportsflag", "reportsflag");
		mv.addObject("menu", reportId);
		System.out.println("scv" + mv.getViewName());

		return mv;

	}
	/**** ARCH DETAILS 
	* @throws ParseException ****/

	public ModelAndView ARCHgetBRF0104currentDtl(String reportId, String fromdate, String todate, String currency,
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
			
			
				qr = hs.createNativeQuery("select * from BRF104_ARCHIVTABLE a where report_date=?1 and report_label=?2");
				qr.setParameter(1,  df.parse(todate));
				qr.setParameter(2,filter);
					

		} else {
			System.out.println("2");
			qr = hs.createNativeQuery("select * from BRF104_ARCHIVTABLE");

		}
	} else {
		System.out.println("3");
		qr = hs.createNativeQuery("select * from BRF104_ARCHIVTABLE  where report_date = ?1");
	}

	List<BRF104_ARCHIV_ENTITY> T1Master = new ArrayList<BRF104_ARCHIV_ENTITY>();

	try {
		System.out.println("Values entered");
		T1Master = hs.createQuery("from BRF104_ARCHIV_ENTITY a where a.report_date = ?1", BRF104_ARCHIV_ENTITY.class)
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
		

		BRF104_ARCHIV_ENTITY py = new BRF104_ARCHIV_ENTITY(cust_id, foracid,acct_name, eab_lc, act_balance_amt_lc,  acct_crncy_code, gl_code,
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

	mv.setViewName("RR" + "/" + "BRF104ARCH::reportcontent");
	mv.addObject("reportdetails", T1Dt1Page.getContent());
	mv.addObject("reportmaster", T1Master);
	mv.addObject("reportmaster1", qr);
	mv.addObject("singledetail", new T1CurProdDetail());
	mv.addObject("reportsflag", "reportsflag");
	mv.addObject("menu", reportId);
	return mv;
	}

	}






			
		

	
	
	


