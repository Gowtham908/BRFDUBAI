
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

import com.bornfire.xbrl.entities.BRF153_ARCHIV_ENTITY;
import com.bornfire.xbrl.entities.BRF153_ARCHIV_ENTITY;
import com.bornfire.xbrl.entities.BRF153_ARCHIV_ENTITY;
//import com.bornfire.xbrl.entities.BRF153_ARCHIV_ENTITY;
import com.bornfire.xbrl.entities.BRBS.BRF153ReportEntity;
import com.bornfire.xbrl.entities.BRBS.BRF153ServiceRepo;
import com.bornfire.xbrl.entities.BRBS.BRF153_DETAIL_ENTITY;
import com.bornfire.xbrl.entities.BRBS.BRF153_DetailRepo;
import com.bornfire.xbrl.entities.BRBS.BRF46_Entity;
import com.bornfire.xbrl.entities.BRBS.BRF153_DETAIL_ENTITY;
import com.bornfire.xbrl.entities.BRBS.BRF153_DETAIL_ENTITY;
import com.bornfire.xbrl.entities.BRBS.RBSTransactionMasterEntity;
import com.bornfire.xbrl.entities.BRBS.T1CurProdDetail;
import com.bornfire.xbrl.entities.BRBS.T1CurProdServicesRepo;



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

public class BRF153ReportService {
	private static final Logger logger = LoggerFactory.getLogger(BRF153ReportService.class);

	@Autowired
	SessionFactory sessionFactory;

	@Autowired
	DataSource srcdataSource;
	
	@Autowired
	T1CurProdServicesRepo t1CurProdServiceRepo;
	
	@Autowired
	Environment env;

	@Autowired
	BRF153ServiceRepo brf153ServiceRepo;
	@Autowired
	BRF153_DetailRepo brf153_detailrepo;
	
	DateFormat df = new SimpleDateFormat("dd-MMM-yyyy");

	public String preCheckBRF153(String reportId, String fromdate, String todate) {

		String msg = "";
		Session hs = sessionFactory.getCurrentSession();
		Date dt1;
		Date dt9;
		logger.info("Report precheck : " + reportId);

		try {
			//dt1 = new SimpleDateFormat("dd/MM/yyyy").parse(fromdate);
			dt9 = new SimpleDateFormat("dd/MM/yyyy").parse(todate);
			logger.info("Getting No of records in Master table :" + reportId);
			Long dtlcnt = (Long) hs.createQuery("select count(*) from BRF153ReportEntity a where a.report_date=?1")
					.setParameter(1, dt9).getSingleResult();

			if (dtlcnt > 0) {
				logger.info("Getting No of records in Mod table :" + reportId);
				Long modcnt = (Long) hs.createQuery("select count(*) from BRF153ReportEntity a").getSingleResult();
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
	
	public ModelAndView getBRF153View(String reportId, String fromdate, String todate, String currency, String dtltype,
			Pageable pageable) {

		ModelAndView mv = new ModelAndView();

		Session hs = sessionFactory.getCurrentSession();
		int pageSize = pageable.getPageSize();
		int currentPage = pageable.getPageNumber();
		int startItem = currentPage * pageSize;
		List<BRF153ReportEntity> T1rep = new ArrayList<BRF153ReportEntity>();
		// Query<Object[]> qr;

		List<BRF153ReportEntity> T1Master = new ArrayList<BRF153ReportEntity>();

		logger.info("Inside archive" +currency);

		try {
			
			
			Date d1 = df.parse(todate);
		//T1rep = brf32ServiceRepo .getBRF32reportService(d1);

			T1Master = hs.createQuery("from BRF153ReportEntity a where a.report_date = ?1 ", BRF153ReportEntity.class)
					.setParameter(1, df.parse(todate)).getResultList();

		} catch (ParseException e) {
			e.printStackTrace();
		}

		// T1rep = t1CurProdServiceRepo.getT1CurProdServices(d1);

		mv.setViewName("RR/BRF153");
		// mv.addObject("currlist", refCodeConfig.currList());
		mv.addObject("reportsummary", T1Master);
		mv.addObject("reportmaster", T1Master);
		mv.addObject("displaymode", "summary");
		mv.addObject("reportsflag", "reportsflag");
		mv.addObject("menu", reportId);
		System.out.println("scv" + mv.getViewName());

		return mv;

	}
	public ModelAndView getBRF153Details(String reportId, String fromdate, String todate, String currency,
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
                qr = hs.createNativeQuery("select * from BRF153_DETAILTABLE");
                //qr.setParameter(2, filter);
            } else {
                qr = hs.createNativeQuery("select * from BRF153_DETAILTABLE");
            }
        } else {
            qr = hs.createNativeQuery("select * from BRF153_DETAILTABLE  where report_date = ?1");
        }
        List<BRF153_DETAIL_ENTITY> T1Master = new ArrayList<BRF153_DETAIL_ENTITY>();
 
        try {
            T1Master = hs.createQuery("from BRF153_DETAIL_ENTITY a where a.report_date = ?1", BRF153_DETAIL_ENTITY.class)
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
			BigDecimal amt_ac = (BigDecimal) a[5];
			String acct_crncy_code = (String) a[6];
			String gl_code = (String) a[7];
			String gl_sub_head_code = (String) a[8];
			String gl_sub_head_desc = (String) a[9];
			String country_of_incorp = (String) a[10];
			String cust_type = (String) a[11];
			String schm_code = (String) a[12];
			String schm_type = (String) a[13];
			String sol_id = (String) a[14];
			String acid = (String) a[15];
			String segment = (String) a[16];
			String sub_segment = (String) a[17];
			BigDecimal sector = (BigDecimal) a[18];
			String sub_sector = (String) a[19];
			String sector_code = (String) a[20];
			String group_id = (String) a[21];
			String constitution_code = (String) a[22];
			String country = (String) a[23];
			String legal_entity_type = (String) a[24];
			String constitution_desc = (String) a[25];
			String purpose_of_advn = (String) a[26];
			BigDecimal hni_networth = (BigDecimal) a[27];
			String turnover = (String) a[28];
			String bacid = (String) a[29];
			String report_name_1 = (String) a[30];
			String report_label_1 = (String) a[31];
			String report_addl_criteria_1 = (String) a[32];
			String report_addl_criteria_2 = (String) a[33];
			String report_addl_criteria_3 = (String) a[34];
			String create_user = (String) a[35];
			Date create_time = (Date) a[36];
			String modify_user = (String) a[37];
			Date modify_time = (Date) a[38];
			String verify_user = (String) a[39];
			Date verify_time = (Date) a[40];
			String entity_flg = (String) a[41];
			String modify_flg = (String) a[42];
			String del_flg = (String) a[43];
			String nre_status = (String) a[44];
			Date report_date = (Date) a[45];
			String maturity_date = (String) a[46];
			String gender = (String) a[47];
			String version = (String) a[48];
			String remarks = (String) a[49];
			

			BRF153_DETAIL_ENTITY py = new BRF153_DETAIL_ENTITY(cust_id, foracid, acct_name, eab_lc, act_balance_amt_lc,amt_ac, 
					acct_crncy_code, gl_code, gl_sub_head_code, gl_sub_head_desc, country_of_incorp, cust_type, schm_code, 
					schm_type, sol_id, acid, segment, sub_segment, sector, sub_sector, sector_code, group_id, constitution_code, 
					country, legal_entity_type, constitution_desc, purpose_of_advn, hni_networth, turnover, bacid, report_name_1,
					report_label_1, report_addl_criteria_1, report_addl_criteria_2, report_addl_criteria_3, create_user, 
					create_time, modify_user, modify_time, verify_user, verify_time, entity_flg, modify_flg, del_flg, 
					nre_status, report_date, maturity_date, version, gender, remarks);


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

		mv.setViewName("RR" + "/" + "BRF153::reportcontent");
		mv.addObject("reportdetails", T1Dt1Page.getContent());
		mv.addObject("reportmaster", T1Master);
		mv.addObject("reportmaster12", T1Dt1);
		mv.addObject("reportmaster1", qr);
		mv.addObject("singledetail", new T1CurProdDetail());
		mv.addObject("reportsflag", "reportsflag");
		mv.addObject("menu", reportId);
		return mv;
	}

	public File getFileBRF153(String reportId, String fromdate, String todate, String currency, String dtltype,

			String filetype) throws FileNotFoundException, JRException, SQLException {

		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

		String path = this.env.getProperty("output.exportpath");
		String fileName = "";
		String zipFileName = "";
		File outputFile;

		logger.info("Getting Output file :" + reportId);
		fileName = "011-BRF-153-A" ;
					if (!filetype.equals("xbrl")) {
						if(!filetype.equals("BRF")) {


			try {
				InputStream jasperFile;
				logger.info("Getting Jasper file :" + reportId);
				if (filetype.equals("detailexcel")) {
					if (dtltype.equals("report")) {

						jasperFile = this.getClass().getResourceAsStream("/static/jasper/BRF153_Detail.jrxml");
					} else {
						jasperFile = this.getClass().getResourceAsStream("/static/jasper/BRF153_Detail.jrxml");
					}
				} else {
					if (dtltype.equals("report")) {
						logger.info("Inside report");
						jasperFile = this.getClass().getResourceAsStream("/static/jasper/BRF153.jrxml");
					} else {
						jasperFile = this.getClass().getResourceAsStream("/static/jasper/BRF153.jrxml");
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
			}outputFile = new File(path);
			return outputFile;
						}else {
							
							List<BRF153ReportEntity> T1Master = new ArrayList<BRF153ReportEntity>();
							Session hs = sessionFactory.getCurrentSession();
							try {
								Date d1 = df.parse(todate);
							
							// T1rep = t1CurProdServiceRepo.getT1CurProdServices(d1);

							T1Master = hs.createQuery("from  BRF153ReportEntity a where a.report_date = ?1 ", BRF153ReportEntity.class)
									.setParameter(1, df.parse(todate)).getResultList();
							
							if(T1Master.size() == 1) {
								
								for(BRF153ReportEntity BRF153 : T1Master ) {
							
							File Responsecamt = new File(env.getProperty("output.exportpathtemp")+"011-BRF-153-AT.xls");
							
							  // Load the Excel file
				        	Workbook workbook = WorkbookFactory.create(Responsecamt);

				            // Get the first sheet
				            Sheet sheet = workbook.getSheetAt(0);
				            Row row = sheet.getRow(10);
				            Cell cell = row.getCell(3);
				            if (cell != null) {
				                cell.setCellValue(BRF153.getR1_notational_amount() == null ? 0 :
				                	BRF153.getR1_notational_amount().intValue());
				            }
				            Cell cell1 = row.getCell(4);
				            if (cell1 != null) {
				                cell1.setCellValue(BRF153.getR1_gross_market() == null ? 0 :
				                	BRF153.getR1_gross_market().intValue());
				            }
				            Cell cell2 = row.getCell(5);
				            if (cell2 != null) {
				                cell2.setCellValue(BRF153.getR1_lessthan_oneyear() == null ? 0 :
				                	BRF153.getR1_lessthan_oneyear().intValue());
				            }

				            
				            Cell cell3 = row.getCell(6);
				            if (cell3 != null) {
				                cell3.setCellValue(BRF153.getR1_onetothree_year() == null ? 0 :
				                	BRF153.getR1_onetothree_year().intValue());
				            }
				            
				            Cell cell4 = row.getCell(7);
				            if (cell4 != null) {
				                cell4.setCellValue(BRF153.getR1_morethan_threeyear() == null ? 0 :
				                	BRF153.getR1_morethan_threeyear().intValue());
				            }
				            
				            Cell cell5 = row.getCell(8);
				            if (cell5 != null) {
				                cell5.setCellValue(BRF153.getR1_plusten_oneyear() == null ? 0 :
				                	BRF153.getR1_plusten_oneyear().intValue());
				            }
				            
				            Cell cell6 = row.getCell(9);
				            if (cell6 != null) {
				                cell6.setCellValue(BRF153.getR1_minusten_oneyear() == null ? 0 :
				                	BRF153.getR1_minusten_oneyear().intValue());
				            }
				            
				            Cell cell7 = row.getCell(10);
				            if (cell7 != null) {
				                cell7.setCellValue(BRF153.getR1_plusten_onetothreeyear() == null ? 0 :
				                	BRF153.getR1_plusten_onetothreeyear().intValue());
				            }
				          
				            Cell cell8 = row.getCell(11);
				            if (cell8 != null) {
				                cell8.setCellValue(BRF153.getR1_minusten_onetothreeyear() == null ? 0 :
				                	BRF153.getR1_minusten_onetothreeyear().intValue());
				            } 
				            
				            Cell cell9 = row.getCell(12);
				            if (cell9 != null) {
				                cell9.setCellValue(BRF153.getR1_plusten_threeyear() == null ? 0 :
				                	BRF153.getR1_plusten_threeyear().intValue());
				            } 
				            
				            Cell cell10 = row.getCell(13);
				            if (cell10 != null) {
				                cell10.setCellValue(BRF153.getR1_minusten_threeyear() == null ? 0 :
				                	BRF153.getR1_minusten_threeyear().intValue());
				            }
				            
				            ///////////////////R2///////////////////////
				            
				            Row row1 = sheet.getRow(11);
				            Cell R1cell = row1.getCell(3);
				            if (R1cell != null) {
				                R1cell.setCellValue(BRF153.getR2_notational_amount() == null ? 0 :
				                	BRF153.getR2_notational_amount().intValue());
				            }
				            Cell R1cell1 = row1.getCell(4);
				            if (R1cell1 != null) {
				                R1cell1.setCellValue(BRF153.getR2_gross_market() == null ? 0 :
				                	BRF153.getR2_gross_market().intValue());
				            }
				            Cell R1cell2 = row1.getCell(5);
				            if (R1cell2 != null) {
				                R1cell2.setCellValue(BRF153.getR2_lessthan_oneyear() == null ? 0 :
				                	BRF153.getR2_lessthan_oneyear().intValue());
				            }

				            
				            Cell R1cell3 = row1.getCell(6);
				            if (R1cell3 != null) {
				                R1cell3.setCellValue(BRF153.getR2_onetothree_year() == null ? 0 :
				                	BRF153.getR2_onetothree_year().intValue());
				            }
				            
				            Cell R1cell4 = row1.getCell(7);
				            if (R1cell4 != null) {
				                R1cell4.setCellValue(BRF153.getR2_morethan_threeyear() == null ? 0 :
				                	BRF153.getR2_morethan_threeyear().intValue());
				            }
				            
				            Cell R1cell5 = row1.getCell(8);
				            if (R1cell5 != null) {
				                R1cell5.setCellValue(BRF153.getR2_plusten_oneyear() == null ? 0 :
				                	BRF153.getR2_plusten_oneyear().intValue());
				            }
				            
				            Cell R1cell6 = row1.getCell(9);
				            if (R1cell6 != null) {
				                R1cell6.setCellValue(BRF153.getR2_minusten_oneyear() == null ? 0 :
				                	BRF153.getR2_minusten_oneyear().intValue());
				            }
				            
				            Cell R1cell7 = row1.getCell(10);
				            if (R1cell7 != null) {
				                R1cell7.setCellValue(BRF153.getR2_plusten_onetothreeyear() == null ? 0 :
				                	BRF153.getR2_plusten_onetothreeyear().intValue());
				            }
				          
				            Cell R1cell8 = row1.getCell(11);
				            if (R1cell8 != null) {
				                R1cell8.setCellValue(BRF153.getR2_minusten_onetothreeyear() == null ? 0 :
				                	BRF153.getR2_minusten_onetothreeyear().intValue());
				            } 
				            
				            Cell R1cell9 = row1.getCell(12);
				            if (R1cell9 != null) {
				                R1cell9.setCellValue(BRF153.getR2_plusten_threeyear() == null ? 0 :
				                	BRF153.getR2_plusten_threeyear().intValue());
				            } 
				            
				            Cell R1cell10 = row1.getCell(13);
				            if (R1cell10 != null) {
				                R1cell10.setCellValue(BRF153.getR2_minusten_threeyear() == null ? 0 :
				                	BRF153.getR2_minusten_threeyear().intValue());
				            }
				            
				            /////////////////////R3////////////////////
				            
				            Row row2 = sheet.getRow(12);
				            Cell R2cell = row2.getCell(3);
				            if (R2cell != null) {
				                R2cell.setCellValue(BRF153.getR3_notational_amount() == null ? 0 :
				                	BRF153.getR3_notational_amount().intValue());
				            }
				            Cell R2cell1 = row2.getCell(4);
				            if (R2cell1 != null) {
				                R2cell1.setCellValue(BRF153.getR3_gross_market() == null ? 0 :
				                	BRF153.getR3_gross_market().intValue());
				            }
				            Cell R2cell2 = row2.getCell(5);
				            if (R2cell2 != null) {
				                R2cell2.setCellValue(BRF153.getR3_lessthan_oneyear() == null ? 0 :
				                	BRF153.getR3_lessthan_oneyear().intValue());
				            }

				            
				            Cell R2cell3 = row2.getCell(6);
				            if (R2cell3 != null) {
				                R2cell3.setCellValue(BRF153.getR3_onetothree_year() == null ? 0 :
				                	BRF153.getR3_onetothree_year().intValue());
				            }
				            
				            Cell R2cell4 = row2.getCell(7);
				            if (R2cell4 != null) {
				                R2cell4.setCellValue(BRF153.getR3_morethan_threeyear() == null ? 0 :
				                	BRF153.getR3_morethan_threeyear().intValue());
				            }
				            
				            Cell R2cell5 = row2.getCell(8);
				            if (R2cell5 != null) {
				                R2cell5.setCellValue(BRF153.getR3_plusten_oneyear() == null ? 0 :
				                	BRF153.getR3_plusten_oneyear().intValue());
				            }
				            
				            Cell R2cell6 = row2.getCell(9);
				            if (R2cell6 != null) {
				                R2cell6.setCellValue(BRF153.getR3_minusten_oneyear() == null ? 0 :
				                	BRF153.getR3_minusten_oneyear().intValue());
				            }
				            
				            Cell R2cell7 = row2.getCell(10);
				            if (R2cell7 != null) {
				                R2cell7.setCellValue(BRF153.getR3_plusten_onetothreeyear() == null ? 0 :
				                	BRF153.getR3_plusten_onetothreeyear().intValue());
				            }
				          
				            Cell R2cell8 = row2.getCell(11);
				            if (R2cell8 != null) {
				                R2cell8.setCellValue(BRF153.getR3_minusten_onetothreeyear() == null ? 0 :
				                	BRF153.getR3_minusten_onetothreeyear().intValue());
				            } 
				            
				            Cell R2cell9 = row2.getCell(12);
				            if (R2cell9 != null) {
				                R2cell9.setCellValue(BRF153.getR3_plusten_threeyear() == null ? 0 :
				                	BRF153.getR3_plusten_threeyear().intValue());
				            } 
				            
				            Cell R2cell10 = row2.getCell(13);
				            if (R2cell10 != null) {
				                R2cell10.setCellValue(BRF153.getR3_minusten_threeyear() == null ? 0 :
				                	BRF153.getR3_minusten_threeyear().intValue());
				            }
				            
				            /////////////////R4/////////////////////////
				            Row row3 = sheet.getRow(13);
				            Cell R3cell = row3.getCell(3);
				            if (R3cell != null) {
				                R3cell.setCellValue(BRF153.getR4_notational_amount() == null ? 0 :
				                	BRF153.getR4_notational_amount().intValue());
				            }
				            Cell R3cell1 = row3.getCell(4);
				            if (R3cell1 != null) {
				                R3cell1.setCellValue(BRF153.getR4_gross_market() == null ? 0 :
				                	BRF153.getR4_gross_market().intValue());
				            }
				            Cell R3cell2 = row3.getCell(5);
				            if (R3cell2 != null) {
				                R3cell2.setCellValue(BRF153.getR4_lessthan_oneyear() == null ? 0 :
				                	BRF153.getR4_lessthan_oneyear().intValue());
				            }

				            
				            Cell R3cell3 = row3.getCell(6);
				            if (R3cell3 != null) {
				                R3cell3.setCellValue(BRF153.getR4_onetothree_year() == null ? 0 :
				                	BRF153.getR4_onetothree_year().intValue());
				            }
				            
				            Cell R3cell4 = row3.getCell(7);
				            if (R3cell4 != null) {
				                R3cell4.setCellValue(BRF153.getR4_morethan_threeyear() == null ? 0 :
				                	BRF153.getR4_morethan_threeyear().intValue());
				            }
				            
				            Cell R3cell5 = row3.getCell(8);
				            if (R3cell5 != null) {
				                R3cell5.setCellValue(BRF153.getR4_plusten_oneyear() == null ? 0 :
				                	BRF153.getR4_plusten_oneyear().intValue());
				            }
				            
				            Cell R3cell6 = row3.getCell(9);
				            if (R3cell6 != null) {
				                R3cell6.setCellValue(BRF153.getR4_minusten_oneyear() == null ? 0 :
				                	BRF153.getR4_minusten_oneyear().intValue());
				            }
				            
				            Cell R3cell7 = row3.getCell(10);
				            if (R3cell7 != null) {
				                R3cell7.setCellValue(BRF153.getR4_plusten_onetothreeyear() == null ? 0 :
				                	BRF153.getR4_plusten_onetothreeyear().intValue());
				            }
				          
				            Cell R3cell8 = row3.getCell(11);
				            if (R3cell8 != null) {
				                R3cell8.setCellValue(BRF153.getR4_minusten_onetothreeyear() == null ? 0 :
				                	BRF153.getR4_minusten_onetothreeyear().intValue());
				            } 
				            
				            Cell R3cell9 = row3.getCell(12);
				            if (R3cell9 != null) {
				                R3cell9.setCellValue(BRF153.getR4_plusten_threeyear() == null ? 0 :
				                	BRF153.getR4_plusten_threeyear().intValue());
				            } 
				            
				            Cell R3cell10 = row3.getCell(13);
				            if (R3cell10 != null) {
				                R3cell10.setCellValue(BRF153.getR4_minusten_threeyear() == null ? 0 :
				                	BRF153.getR4_minusten_threeyear().intValue());
				            }
				            
				            
				            //////////////R5/////////////////////
				            
				            Row row4 = sheet.getRow(14);
				            Cell R4cell = row4.getCell(3);
				            if (R4cell != null) {
				                R4cell.setCellValue(BRF153.getR5_notational_amount() == null ? 0 :
				                	BRF153.getR5_notational_amount().intValue());
				            }
				            Cell R4cell1 = row4.getCell(4);
				            if (R4cell1 != null) {
				                R4cell1.setCellValue(BRF153.getR5_gross_market() == null ? 0 :
				                	BRF153.getR5_gross_market().intValue());
				            }
				            Cell R4cell2 = row4.getCell(5);
				            if (R4cell2 != null) {
				                R4cell2.setCellValue(BRF153.getR5_lessthan_oneyear() == null ? 0 :
				                	BRF153.getR5_lessthan_oneyear().intValue());
				            }

				            
				            Cell R4cell3 = row4.getCell(6);
				            if (R4cell3 != null) {
				                R4cell3.setCellValue(BRF153.getR5_onetothree_year() == null ? 0 :
				                	BRF153.getR5_onetothree_year().intValue());
				            }
				            
				            Cell R4cell4 = row4.getCell(7);
				            if (R4cell4 != null) {
				                R4cell4.setCellValue(BRF153.getR5_morethan_threeyear() == null ? 0 :
				                	BRF153.getR5_morethan_threeyear().intValue());
				            }
				            
				            Cell R4cell5 = row4.getCell(8);
				            if (R4cell5 != null) {
				                R4cell5.setCellValue(BRF153.getR5_plusten_oneyear() == null ? 0 :
				                	BRF153.getR5_plusten_oneyear().intValue());
				            }
				            
				            Cell R4cell6 = row4.getCell(9);
				            if (R4cell6 != null) {
				                R4cell6.setCellValue(BRF153.getR5_minusten_oneyear() == null ? 0 :
				                	BRF153.getR5_minusten_oneyear().intValue());
				            }
				            
				            Cell R4cell7 = row4.getCell(10);
				            if (R4cell7 != null) {
				                R4cell7.setCellValue(BRF153.getR5_plusten_onetothreeyear() == null ? 0 :
				                	BRF153.getR5_plusten_onetothreeyear().intValue());
				            }
				          
				            Cell R4cell8 = row4.getCell(11);
				            if (R4cell8 != null) {
				                R4cell8.setCellValue(BRF153.getR5_minusten_onetothreeyear() == null ? 0 :
				                	BRF153.getR5_minusten_onetothreeyear().intValue());
				            } 
				            
				            Cell R4cell9 = row4.getCell(12);
				            if (R4cell9 != null) {
				                R4cell9.setCellValue(BRF153.getR5_plusten_threeyear() == null ? 0 :
				                	BRF153.getR5_plusten_threeyear().intValue());
				            } 
				            
				            Cell R4cell10 = row4.getCell(13);
				            if (R4cell10 != null) {
				                R4cell10.setCellValue(BRF153.getR5_minusten_threeyear() == null ? 0 :
				                	BRF153.getR5_minusten_threeyear().intValue());
				            }
				            
				            
				            /////////////////R6///////////////////////
				            
				            Row row5 = sheet.getRow(15);
				            Cell R5cell = row5.getCell(3);
				            if (R5cell != null) {
				                R5cell.setCellValue(BRF153.getR6_notational_amount() == null ? 0 :
				                	BRF153.getR6_notational_amount().intValue());
				            }
				            Cell R5cell1 = row5.getCell(4);
				            if (R5cell1 != null) {
				                R5cell1.setCellValue(BRF153.getR6_gross_market() == null ? 0 :
				                	BRF153.getR6_gross_market().intValue());
				            }
				            Cell R5cell2 = row5.getCell(5);
				            if (R5cell2 != null) {
				                R5cell2.setCellValue(BRF153.getR6_lessthan_oneyear() == null ? 0 :
				                	BRF153.getR6_lessthan_oneyear().intValue());
				            }

				            
				            Cell R5cell3 = row5.getCell(6);
				            if (R5cell3 != null) {
				                R5cell3.setCellValue(BRF153.getR6_onetothree_year() == null ? 0 :
				                	BRF153.getR6_onetothree_year().intValue());
				            }
				            
				            Cell R5cell4 = row5.getCell(7);
				            if (R5cell4 != null) {
				                R5cell4.setCellValue(BRF153.getR6_morethan_threeyear() == null ? 0 :
				                	BRF153.getR6_morethan_threeyear().intValue());
				            }
				            
				            Cell R5cell5 = row5.getCell(8);
				            if (R5cell5 != null) {
				                R5cell5.setCellValue(BRF153.getR6_plusten_oneyear() == null ? 0 :
				                	BRF153.getR6_plusten_oneyear().intValue());
				            }
				            
				            Cell R5cell6 = row5.getCell(9);
				            if (R5cell6 != null) {
				                R5cell6.setCellValue(BRF153.getR6_minusten_oneyear() == null ? 0 :
				                	BRF153.getR6_minusten_oneyear().intValue());
				            }
				            
				            Cell R5cell7 = row5.getCell(10);
				            if (R5cell7 != null) {
				                R5cell7.setCellValue(BRF153.getR6_plusten_onetothreeyear() == null ? 0 :
				                	BRF153.getR6_plusten_onetothreeyear().intValue());
				            }
				          
				            Cell R5cell8 = row5.getCell(11);
				            if (R5cell8 != null) {
				                R5cell8.setCellValue(BRF153.getR6_minusten_onetothreeyear() == null ? 0 :
				                	BRF153.getR6_minusten_onetothreeyear().intValue());
				            } 
				            
				            Cell R5cell9 = row5.getCell(12);
				            if (R5cell9 != null) {
				                R5cell9.setCellValue(BRF153.getR6_plusten_threeyear() == null ? 0 :
				                	BRF153.getR6_plusten_threeyear().intValue());
				            } 
				            
				            Cell R5cell10 = row5.getCell(13);
				            if (R5cell10 != null) {
				                R5cell10.setCellValue(BRF153.getR6_minusten_threeyear() == null ? 0 :
				                	BRF153.getR6_minusten_threeyear().intValue());
				            }
				            
				            
				            //////////////////////R7////////////////////
				            
				            Row row6 = sheet.getRow(16);
				            Cell R6cell = row6.getCell(3);
				            if (R6cell != null) {
				                R6cell.setCellValue(BRF153.getR7_notational_amount() == null ? 0 :
				                	BRF153.getR7_notational_amount().intValue());
				            }
				            Cell R6cell1 = row6.getCell(4);
				            if (R6cell1 != null) {
				                R6cell1.setCellValue(BRF153.getR7_gross_market() == null ? 0 :
				                	BRF153.getR7_gross_market().intValue());
				            }
				            Cell R6cell2 = row6.getCell(5);
				            if (R6cell2 != null) {
				                R6cell2.setCellValue(BRF153.getR7_lessthan_oneyear() == null ? 0 :
				                	BRF153.getR7_lessthan_oneyear().intValue());
				            }

				            
				            Cell R6cell3 = row6.getCell(6);
				            if (R6cell3 != null) {
				                R6cell3.setCellValue(BRF153.getR7_onetothree_year() == null ? 0 :
				                	BRF153.getR7_onetothree_year().intValue());
				            }
				            
				            Cell R6cell4 = row6.getCell(7);
				            if (R6cell4 != null) {
				                R6cell4.setCellValue(BRF153.getR7_morethan_threeyear() == null ? 0 :
				                	BRF153.getR7_morethan_threeyear().intValue());
				            }
				            
				            Cell R6cell5 = row6.getCell(8);
				            if (R6cell5 != null) {
				                R6cell5.setCellValue(BRF153.getR7_plusten_oneyear() == null ? 0 :
				                	BRF153.getR7_plusten_oneyear().intValue());
				            }
				            
				            Cell R6cell6 = row6.getCell(9);
				            if (R6cell6 != null) {
				                R6cell6.setCellValue(BRF153.getR7_minusten_oneyear() == null ? 0 :
				                	BRF153.getR7_minusten_oneyear().intValue());
				            }
				            
				            Cell R6cell7 = row6.getCell(10);
				            if (R6cell7 != null) {
				                R6cell7.setCellValue(BRF153.getR7_plusten_onetothreeyear() == null ? 0 :
				                	BRF153.getR7_plusten_onetothreeyear().intValue());
				            }
				          
				            Cell R6cell8 = row6.getCell(11);
				            if (R6cell8 != null) {
				                R6cell8.setCellValue(BRF153.getR7_minusten_onetothreeyear() == null ? 0 :
				                	BRF153.getR7_minusten_onetothreeyear().intValue());
				            } 
				            
				            Cell R6cell9 = row6.getCell(12);
				            if (R6cell9 != null) {
				                R6cell9.setCellValue(BRF153.getR7_plusten_threeyear() == null ? 0 :
				                	BRF153.getR7_plusten_threeyear().intValue());
				            } 
				            
				            Cell R6cell10 = row6.getCell(13);
				            if (R6cell10 != null) {
				                R6cell10.setCellValue(BRF153.getR7_minusten_threeyear() == null ? 0 :
				                	BRF153.getR7_minusten_threeyear().intValue());
				            }
				            
				            ////////////////R8////////////////////////
				            
				            Row row7 = sheet.getRow(17);
				            Cell R7cell = row7.getCell(3);
				            if (R7cell != null) {
				                R7cell.setCellValue(BRF153.getR8_notational_amount() == null ? 0 :
				                	BRF153.getR8_notational_amount().intValue());
				            }
				            Cell R7cell1 = row7.getCell(4);
				            if (R7cell1 != null) {
				                R7cell1.setCellValue(BRF153.getR8_gross_market() == null ? 0 :
				                	BRF153.getR8_gross_market().intValue());
				            }
				            Cell R7cell2 = row7.getCell(5);
				            if (R7cell2 != null) {
				                R7cell2.setCellValue(BRF153.getR8_lessthan_oneyear() == null ? 0 :
				                	BRF153.getR8_lessthan_oneyear().intValue());
				            }

				            
				            Cell R7cell3 = row7.getCell(6);
				            if (R7cell3 != null) {
				                R7cell3.setCellValue(BRF153.getR8_onetothree_year() == null ? 0 :
				                	BRF153.getR8_onetothree_year().intValue());
				            }
				            
				            Cell R7cell4 = row7.getCell(7);
				            if (R7cell4 != null) {
				                R7cell4.setCellValue(BRF153.getR8_morethan_threeyear() == null ? 0 :
				                	BRF153.getR8_morethan_threeyear().intValue());
				            }
				            
				            Cell R7cell5 = row7.getCell(8);
				            if (R7cell5 != null) {
				                R7cell5.setCellValue(BRF153.getR8_plusten_oneyear() == null ? 0 :
				                	BRF153.getR8_plusten_oneyear().intValue());
				            }
				            
				            Cell R7cell6 = row7.getCell(9);
				            if (R7cell6 != null) {
				                R7cell6.setCellValue(BRF153.getR8_minusten_oneyear() == null ? 0 :
				                	BRF153.getR8_minusten_oneyear().intValue());
				            }
				            
				            Cell R7cell7 = row7.getCell(10);
				            if (R7cell7 != null) {
				                R7cell7.setCellValue(BRF153.getR8_plusten_onetothreeyear() == null ? 0 :
				                	BRF153.getR8_plusten_onetothreeyear().intValue());
				            }
				          
				            Cell R7cell8 = row7.getCell(11);
				            if (R7cell8 != null) {
				                R7cell8.setCellValue(BRF153.getR8_minusten_onetothreeyear() == null ? 0 :
				                	BRF153.getR8_minusten_onetothreeyear().intValue());
				            } 
				            
				            Cell R7cell9 = row7.getCell(12);
				            if (R7cell9 != null) {
				                R7cell9.setCellValue(BRF153.getR8_plusten_threeyear() == null ? 0 :
				                	BRF153.getR8_plusten_threeyear().intValue());
				            } 
				            
				            Cell R7cell10 = row7.getCell(13);
				            if (R7cell10 != null) {
				                R7cell10.setCellValue(BRF153.getR8_minusten_threeyear() == null ? 0 :
				                	BRF153.getR8_minusten_threeyear().intValue());
				            }
				            
				            ///////////////////////R9//////////////////////
				            
				            Row row8 = sheet.getRow(18);
				            Cell R8cell = row8.getCell(3);
				            if (R8cell != null) {
				                R8cell.setCellValue(BRF153.getR9_notational_amount() == null ? 0 :
				                	BRF153.getR9_notational_amount().intValue());
				            }
				            Cell R8cell1 = row8.getCell(4);
				            if (R8cell1 != null) {
				                R8cell1.setCellValue(BRF153.getR9_gross_market() == null ? 0 :
				                	BRF153.getR9_gross_market().intValue());
				            }
				            Cell R8cell2 = row8.getCell(5);
				            if (R8cell2 != null) {
				                R8cell2.setCellValue(BRF153.getR9_lessthan_oneyear() == null ? 0 :
				                	BRF153.getR9_lessthan_oneyear().intValue());
				            }

				            
				            Cell R8cell3 = row8.getCell(6);
				            if (R8cell3 != null) {
				                R8cell3.setCellValue(BRF153.getR9_onetothree_year() == null ? 0 :
				                	BRF153.getR9_onetothree_year().intValue());
				            }
				            
				            Cell R8cell4 = row8.getCell(7);
				            if (R8cell4 != null) {
				                R8cell4.setCellValue(BRF153.getR9_morethan_threeyear() == null ? 0 :
				                	BRF153.getR9_morethan_threeyear().intValue());
				            }
				            
				            Cell R8cell5 = row8.getCell(8);
				            if (R8cell5 != null) {
				                R8cell5.setCellValue(BRF153.getR9_plusten_oneyear() == null ? 0 :
				                	BRF153.getR9_plusten_oneyear().intValue());
				            }
				            
				            Cell R8cell6 = row8.getCell(9);
				            if (R8cell6 != null) {
				                R8cell6.setCellValue(BRF153.getR9_minusten_oneyear() == null ? 0 :
				                	BRF153.getR9_minusten_oneyear().intValue());
				            }
				            
				            Cell R8cell7 = row8.getCell(10);
				            if (R8cell7 != null) {
				                R8cell7.setCellValue(BRF153.getR9_plusten_onetothreeyear() == null ? 0 :
				                	BRF153.getR9_plusten_onetothreeyear().intValue());
				            }
				          
				            Cell R8cell8 = row8.getCell(11);
				            if (R8cell8 != null) {
				                R8cell8.setCellValue(BRF153.getR9_minusten_onetothreeyear() == null ? 0 :
				                	BRF153.getR9_minusten_onetothreeyear().intValue());
				            } 
				            
				            Cell R8cell9 = row8.getCell(12);
				            if (R8cell9 != null) {
				                R8cell9.setCellValue(BRF153.getR9_plusten_threeyear() == null ? 0 :
				                	BRF153.getR9_plusten_threeyear().intValue());
				            } 
				            
				            Cell R8cell10 = row8.getCell(13);
				            if (R8cell10 != null) {
				                R8cell10.setCellValue(BRF153.getR9_minusten_threeyear() == null ? 0 :
				                	BRF153.getR9_minusten_threeyear().intValue());
				            }
				            
				            
				            ////////////////////////R10//////////////////////
				            
				            Row row9 = sheet.getRow(19);
				            Cell R9cell = row9.getCell(3);
				            if (R9cell != null) {
				                R9cell.setCellValue(BRF153.getR10_notational_amount() == null ? 0 :
				                	BRF153.getR10_notational_amount().intValue());
				            }
				            Cell R9cell1 = row9.getCell(4);
				            if (R9cell1 != null) {
				                R9cell1.setCellValue(BRF153.getR10_gross_market() == null ? 0 :
				                	BRF153.getR10_gross_market().intValue());
				            }
				            Cell R9cell2 = row9.getCell(5);
				            if (R9cell2 != null) {
				                R9cell2.setCellValue(BRF153.getR10_lessthan_oneyear() == null ? 0 :
				                	BRF153.getR10_lessthan_oneyear().intValue());
				            }

				            
				            Cell R9cell3 = row9.getCell(6);
				            if (R9cell3 != null) {
				                R9cell3.setCellValue(BRF153.getR10_onetothree_year() == null ? 0 :
				                	BRF153.getR10_onetothree_year().intValue());
				            }
				            
				            Cell R9cell4 = row9.getCell(7);
				            if (R9cell4 != null) {
				                R9cell4.setCellValue(BRF153.getR10_morethan_threeyear() == null ? 0 :
				                	BRF153.getR10_morethan_threeyear().intValue());
				            }
				            
				            Cell R9cell5 = row9.getCell(8);
				            if (R9cell5 != null) {
				                R9cell5.setCellValue(BRF153.getR10_plusten_oneyear() == null ? 0 :
				                	BRF153.getR10_plusten_oneyear().intValue());
				            }
				            
				            Cell R9cell6 = row9.getCell(9);
				            if (R9cell6 != null) {
				                R9cell6.setCellValue(BRF153.getR10_minusten_oneyear() == null ? 0 :
				                	BRF153.getR10_minusten_oneyear().intValue());
				            }
				            
				            Cell R9cell7 = row9.getCell(10);
				            if (R9cell7 != null) {
				                R9cell7.setCellValue(BRF153.getR10_plusten_onetothreeyear() == null ? 0 :
				                	BRF153.getR10_plusten_onetothreeyear().intValue());
				            }
				          
				            Cell R9cell8 = row9.getCell(11);
				            if (R9cell8 != null) {
				                R9cell8.setCellValue(BRF153.getR10_minusten_onetothreeyear() == null ? 0 :
				                	BRF153.getR10_minusten_onetothreeyear().intValue());
				            } 
				            
				            Cell R9cell9 = row9.getCell(12);
				            if (R9cell9 != null) {
				                R9cell9.setCellValue(BRF153.getR10_plusten_threeyear() == null ? 0 :
				                	BRF153.getR10_plusten_threeyear().intValue());
				            } 
				            
				            Cell R9cell10 = row9.getCell(13);
				            if (R9cell10 != null) {
				                R9cell10.setCellValue(BRF153.getR10_minusten_threeyear() == null ? 0 :
				                	BRF153.getR10_minusten_threeyear().intValue());
				            }
				            
				            ///////////////////////////////R11////////////////////////////
				            
				            Row row10 = sheet.getRow(20);
				            Cell R10cell = row10.getCell(3);
				            if (R10cell != null) {
				                R10cell.setCellValue(BRF153.getR11_notational_amount() == null ? 0 :
				                	BRF153.getR11_notational_amount().intValue());
				            }
				            Cell R10cell1 = row10.getCell(4);
				            if (R10cell1 != null) {
				                R10cell1.setCellValue(BRF153.getR11_gross_market() == null ? 0 :
				                	BRF153.getR11_gross_market().intValue());
				            }
				            Cell R10cell2 = row10.getCell(5);
				            if (R10cell2 != null) {
				                R10cell2.setCellValue(BRF153.getR11_lessthan_oneyear() == null ? 0 :
				                	BRF153.getR11_lessthan_oneyear().intValue());
				            }

				            
				            Cell R10cell3 = row10.getCell(6);
				            if (R10cell3 != null) {
				                R10cell3.setCellValue(BRF153.getR11_onetothree_year() == null ? 0 :
				                	BRF153.getR11_onetothree_year().intValue());
				            }
				            
				            Cell R10cell4 = row10.getCell(7);
				            if (R10cell4 != null) {
				                R10cell4.setCellValue(BRF153.getR11_morethan_threeyear() == null ? 0 :
				                	BRF153.getR11_morethan_threeyear().intValue());
				            }
				            
				            Cell R10cell5 = row10.getCell(8);
				            if (R10cell5 != null) {
				                R10cell5.setCellValue(BRF153.getR11_plusten_oneyear() == null ? 0 :
				                	BRF153.getR11_plusten_oneyear().intValue());
				            }
				            
				            Cell R10cell6 = row10.getCell(9);
				            if (R10cell6 != null) {
				                R10cell6.setCellValue(BRF153.getR11_minusten_oneyear() == null ? 0 :
				                	BRF153.getR11_minusten_oneyear().intValue());
				            }
				            
				            Cell R10cell7 = row10.getCell(10);
				            if (R10cell7 != null) {
				                R10cell7.setCellValue(BRF153.getR11_plusten_onetothreeyear() == null ? 0 :
				                	BRF153.getR11_plusten_onetothreeyear().intValue());
				            }
				          
				            Cell R10cell8 = row10.getCell(11);
				            if (R10cell8 != null) {
				                R10cell8.setCellValue(BRF153.getR11_minusten_onetothreeyear() == null ? 0 :
				                	BRF153.getR11_minusten_onetothreeyear().intValue());
				            } 
				            
				            Cell R10cell9 = row10.getCell(12);
				            if (R10cell9 != null) {
				                R10cell9.setCellValue(BRF153.getR11_plusten_threeyear() == null ? 0 :
				                	BRF153.getR11_plusten_threeyear().intValue());
				            } 
				            
				            Cell R10cell10 = row10.getCell(13);
				            if (R10cell10 != null) {
				                R10cell10.setCellValue(BRF153.getR11_minusten_threeyear() == null ? 0 :
				                	BRF153.getR11_minusten_threeyear().intValue());
				            }
				            
				            //////////////////R12//////////////////
				           
				            Row row11 = sheet.getRow(21);
				            Cell R11cell = row11.getCell(3);
				            if (R11cell != null) {
				                R11cell.setCellValue(BRF153.getR12_notational_amount() == null ? 0 :
				                	BRF153.getR12_notational_amount().intValue());
				            }
				            Cell R11cell1 = row11.getCell(4);
				            if (R11cell1 != null) {
				                R11cell1.setCellValue(BRF153.getR12_gross_market() == null ? 0 :
				                	BRF153.getR12_gross_market().intValue());
				            }
				            Cell R11cell2 = row11.getCell(5);
				            if (R11cell2 != null) {
				                R11cell2.setCellValue(BRF153.getR12_lessthan_oneyear() == null ? 0 :
				                	BRF153.getR12_lessthan_oneyear().intValue());
				            }

				            
				            Cell R11cell3 = row11.getCell(6);
				            if (R11cell3 != null) {
				                R11cell3.setCellValue(BRF153.getR12_onetothree_year() == null ? 0 :
				                	BRF153.getR12_onetothree_year().intValue());
				            }
				            
				            Cell R11cell4 = row11.getCell(7);
				            if (R11cell4 != null) {
				                R11cell4.setCellValue(BRF153.getR12_morethan_threeyear() == null ? 0 :
				                	BRF153.getR12_morethan_threeyear().intValue());
				            }
				            
				            Cell R11cell5 = row11.getCell(8);
				            if (R11cell5 != null) {
				                R11cell5.setCellValue(BRF153.getR12_plusten_oneyear() == null ? 0 :
				                	BRF153.getR12_plusten_oneyear().intValue());
				            }
				            
				            Cell R11cell6 = row11.getCell(9);
				            if (R11cell6 != null) {
				                R11cell6.setCellValue(BRF153.getR12_minusten_oneyear() == null ? 0 :
				                	BRF153.getR12_minusten_oneyear().intValue());
				            }
				            
				            Cell R11cell7 = row11.getCell(10);
				            if (R11cell7 != null) {
				                R11cell7.setCellValue(BRF153.getR12_plusten_onetothreeyear() == null ? 0 :
				                	BRF153.getR12_plusten_onetothreeyear().intValue());
				            }
				          
				            Cell R11cell8 = row11.getCell(11);
				            if (R11cell8 != null) {
				                R11cell8.setCellValue(BRF153.getR12_minusten_onetothreeyear() == null ? 0 :
				                	BRF153.getR12_minusten_onetothreeyear().intValue());
				            } 
				            
				            Cell R11cell9 = row11.getCell(12);
				            if (R11cell9 != null) {
				                R11cell9.setCellValue(BRF153.getR12_plusten_threeyear() == null ? 0 :
				                	BRF153.getR12_plusten_threeyear().intValue());
				            } 
				            
				            Cell R11cell10 = row11.getCell(13);
				            if (R11cell10 != null) {
				                R11cell10.setCellValue(BRF153.getR12_minusten_threeyear() == null ? 0 :
				                	BRF153.getR12_minusten_threeyear().intValue());
				            }
				            
				            //////////////////R13///////////////////
				            
				            Row row12 = sheet.getRow(22);
				            Cell R12cell = row12.getCell(3);
				            if (R12cell != null) {
				                R12cell.setCellValue(BRF153.getR13_notational_amount() == null ? 0 :
				                	BRF153.getR13_notational_amount().intValue());
				            }
				            Cell R12cell1 = row12.getCell(4);
				            if (R12cell1 != null) {
				                R12cell1.setCellValue(BRF153.getR13_gross_market() == null ? 0 :
				                	BRF153.getR13_gross_market().intValue());
				            }
				            Cell R12cell2 = row12.getCell(5);
				            if (R12cell2 != null) {
				                R12cell2.setCellValue(BRF153.getR13_lessthan_oneyear() == null ? 0 :
				                	BRF153.getR13_lessthan_oneyear().intValue());
				            }

				            
				            Cell R12cell3 = row12.getCell(6);
				            if (R12cell3 != null) {
				                R12cell3.setCellValue(BRF153.getR13_onetothree_year() == null ? 0 :
				                	BRF153.getR13_onetothree_year().intValue());
				            }
				            
				            Cell R12cell4 = row12.getCell(7);
				            if (R12cell4 != null) {
				                R12cell4.setCellValue(BRF153.getR13_morethan_threeyear() == null ? 0 :
				                	BRF153.getR13_morethan_threeyear().intValue());
				            }
				            
				            Cell R12cell5 = row12.getCell(8);
				            if (R12cell5 != null) {
				                R12cell5.setCellValue(BRF153.getR13_plusten_oneyear() == null ? 0 :
				                	BRF153.getR13_plusten_oneyear().intValue());
				            }
				            
				            Cell R12cell6 = row12.getCell(9);
				            if (R12cell6 != null) {
				                R12cell6.setCellValue(BRF153.getR13_minusten_oneyear() == null ? 0 :
				                	BRF153.getR13_minusten_oneyear().intValue());
				            }
				            
				            Cell R12cell7 = row12.getCell(10);
				            if (R12cell7 != null) {
				                R12cell7.setCellValue(BRF153.getR13_plusten_onetothreeyear() == null ? 0 :
				                	BRF153.getR13_plusten_onetothreeyear().intValue());
				            }
				          
				            Cell R12cell8 = row12.getCell(11);
				            if (R12cell8 != null) {
				                R12cell8.setCellValue(BRF153.getR13_minusten_onetothreeyear() == null ? 0 :
				                	BRF153.getR13_minusten_onetothreeyear().intValue());
				            } 
				            
				            Cell R12cell9 = row12.getCell(12);
				            if (R12cell9 != null) {
				                R12cell9.setCellValue(BRF153.getR13_plusten_threeyear() == null ? 0 :
				                	BRF153.getR13_plusten_threeyear().intValue());
				            } 
				            
				            Cell R12cell10 = row12.getCell(13);
				            if (R12cell10 != null) {
				                R12cell10.setCellValue(BRF153.getR13_minusten_threeyear() == null ? 0 :
				                	BRF153.getR13_minusten_threeyear().intValue());
				            }
				            
				            
				            ///////////////////////R14/////////////////////////
				            
				            
				            Row row13 = sheet.getRow(23);
				            Cell R13cell = row13.getCell(3);
				            if (R13cell != null) {
				                R13cell.setCellValue(BRF153.getR14_notational_amount() == null ? 0 :
				                	BRF153.getR14_notational_amount().intValue());
				            }
				            Cell R13cell1 = row13.getCell(4);
				            if (R13cell1 != null) {
				                R13cell1.setCellValue(BRF153.getR14_gross_market() == null ? 0 :
				                	BRF153.getR14_gross_market().intValue());
				            }
				            Cell R13cell2 = row13.getCell(5);
				            if (R13cell2 != null) {
				                R13cell2.setCellValue(BRF153.getR14_lessthan_oneyear() == null ? 0 :
				                	BRF153.getR14_lessthan_oneyear().intValue());
				            }

				            
				            Cell R13cell3 = row13.getCell(6);
				            if (R13cell3 != null) {
				                R13cell3.setCellValue(BRF153.getR14_onetothree_year() == null ? 0 :
				                	BRF153.getR14_onetothree_year().intValue());
				            }
				            
				            Cell R13cell4 = row13.getCell(7);
				            if (R13cell4 != null) {
				                R13cell4.setCellValue(BRF153.getR14_morethan_threeyear() == null ? 0 :
				                	BRF153.getR14_morethan_threeyear().intValue());
				            }
				            
				            Cell R13cell5 = row13.getCell(8);
				            if (R13cell5 != null) {
				                R13cell5.setCellValue(BRF153.getR14_plusten_oneyear() == null ? 0 :
				                	BRF153.getR14_plusten_oneyear().intValue());
				            }
				            
				            Cell R13cell6 = row13.getCell(9);
				            if (R13cell6 != null) {
				                R13cell6.setCellValue(BRF153.getR14_minusten_oneyear() == null ? 0 :
				                	BRF153.getR14_minusten_oneyear().intValue());
				            }
				            
				            Cell R13cell7 = row13.getCell(10);
				            if (R13cell7 != null) {
				                R13cell7.setCellValue(BRF153.getR14_plusten_onetothreeyear() == null ? 0 :
				                	BRF153.getR14_plusten_onetothreeyear().intValue());
				            }
				          
				            Cell R13cell8 = row13.getCell(11);
				            if (R13cell8 != null) {
				                R13cell8.setCellValue(BRF153.getR14_minusten_onetothreeyear() == null ? 0 :
				                	BRF153.getR14_minusten_onetothreeyear().intValue());
				            } 
				            
				            Cell R13cell9 = row13.getCell(12);
				            if (R13cell9 != null) {
				                R13cell9.setCellValue(BRF153.getR14_plusten_threeyear() == null ? 0 :
				                	BRF153.getR14_plusten_threeyear().intValue());
				            } 
				            
				            Cell R13cell10 = row13.getCell(13);
				            if (R13cell10 != null) {
				                R13cell10.setCellValue(BRF153.getR14_minusten_threeyear() == null ? 0 :
				                	BRF153.getR14_minusten_threeyear().intValue());
				            }
				            
				            
				            /////////////////////R15/////////////////////
				            
				            Row row14 = sheet.getRow(24);
				            Cell R14cell = row14.getCell(3);
				            if (R14cell != null) {
				                R14cell.setCellValue(BRF153.getR15_notational_amount() == null ? 0 :
				                	BRF153.getR15_notational_amount().intValue());
				            }
				            Cell R14cell1 = row14.getCell(4);
				            if (R14cell1 != null) {
				                R14cell1.setCellValue(BRF153.getR15_gross_market() == null ? 0 :
				                	BRF153.getR15_gross_market().intValue());
				            }
				            Cell R14cell2 = row14.getCell(5);
				            if (R14cell2 != null) {
				                R14cell2.setCellValue(BRF153.getR15_lessthan_oneyear() == null ? 0 :
				                	BRF153.getR15_lessthan_oneyear().intValue());
				            }

				            
				            Cell R14cell3 = row14.getCell(6);
				            if (R14cell3 != null) {
				                R14cell3.setCellValue(BRF153.getR15_onetothree_year() == null ? 0 :
				                	BRF153.getR15_onetothree_year().intValue());
				            }
				            
				            Cell R14cell4 = row14.getCell(7);
				            if (R14cell4 != null) {
				                R14cell4.setCellValue(BRF153.getR15_morethan_threeyear() == null ? 0 :
				                	BRF153.getR15_morethan_threeyear().intValue());
				            }
				            
				            Cell R14cell5 = row14.getCell(8);
				            if (R14cell5 != null) {
				                R14cell5.setCellValue(BRF153.getR15_plusten_oneyear() == null ? 0 :
				                	BRF153.getR15_plusten_oneyear().intValue());
				            }
				            
				            Cell R14cell6 = row14.getCell(9);
				            if (R14cell6 != null) {
				                R14cell6.setCellValue(BRF153.getR15_minusten_oneyear() == null ? 0 :
				                	BRF153.getR15_minusten_oneyear().intValue());
				            }
				            
				            Cell R14cell7 = row14.getCell(10);
				            if (R14cell7 != null) {
				                R14cell7.setCellValue(BRF153.getR15_plusten_onetothreeyear() == null ? 0 :
				                	BRF153.getR15_plusten_onetothreeyear().intValue());
				            }
				          
				            Cell R14cell8 = row14.getCell(11);
				            if (R14cell8 != null) {
				                R14cell8.setCellValue(BRF153.getR15_minusten_onetothreeyear() == null ? 0 :
				                	BRF153.getR15_minusten_onetothreeyear().intValue());
				            } 
				            
				            Cell R14cell9 = row14.getCell(12);
				            if (R14cell9 != null) {
				                R14cell9.setCellValue(BRF153.getR15_plusten_threeyear() == null ? 0 :
				                	BRF153.getR15_plusten_threeyear().intValue());
				            } 
				            
				            Cell R14cell10 = row14.getCell(13);
				            if (R14cell10 != null) {
				                R14cell10.setCellValue(BRF153.getR15_minusten_threeyear() == null ? 0 :
				                	BRF153.getR15_minusten_threeyear().intValue());
				            }
				            
				            
				            ////////////////R16//////////////////////////////////
				            
				            Row row15 = sheet.getRow(27);
				            Cell R15cell = row15.getCell(3);
				            if (R15cell != null) {
				                R15cell.setCellValue(BRF153.getR16_notational_amount() == null ? 0 :
				                	BRF153.getR16_notational_amount().intValue());
				            }
				            Cell R15cell1 = row15.getCell(4);
				            if (R15cell1 != null) {
				                R15cell1.setCellValue(BRF153.getR16_gross_market() == null ? 0 :
				                	BRF153.getR16_gross_market().intValue());
				            }
				            Cell R15cell2 = row15.getCell(5);
				            if (R15cell2 != null) {
				                R15cell2.setCellValue(BRF153.getR16_lessthan_oneyear() == null ? 0 :
				                	BRF153.getR16_lessthan_oneyear().intValue());
				            }

				            
				            Cell R15cell3 = row15.getCell(6);
				            if (R15cell3 != null) {
				                R15cell3.setCellValue(BRF153.getR16_onetothree_year() == null ? 0 :
				                	BRF153.getR16_onetothree_year().intValue());
				            }
				            
				            Cell R15cell4 = row15.getCell(7);
				            if (R15cell4 != null) {
				                R15cell4.setCellValue(BRF153.getR16_morethan_threeyear() == null ? 0 :
				                	BRF153.getR16_morethan_threeyear().intValue());
				            }
				            
				            Cell R15cell5 = row15.getCell(8);
				            if (R15cell5 != null) {
				                R15cell5.setCellValue(BRF153.getR16_plusten_oneyear() == null ? 0 :
				                	BRF153.getR16_plusten_oneyear().intValue());
				            }
				            
				            Cell R15cell6 = row15.getCell(9);
				            if (R15cell6 != null) {
				                R15cell6.setCellValue(BRF153.getR16_minusten_oneyear() == null ? 0 :
				                	BRF153.getR16_minusten_oneyear().intValue());
				            }
				            
				            Cell R15cell7 = row15.getCell(10);
				            if (R15cell7 != null) {
				                R15cell7.setCellValue(BRF153.getR16_plusten_onetothreeyear() == null ? 0 :
				                	BRF153.getR16_plusten_onetothreeyear().intValue());
				            }
				          
				            Cell R15cell8 = row15.getCell(11);
				            if (R15cell8 != null) {
				                R15cell8.setCellValue(BRF153.getR16_minusten_onetothreeyear() == null ? 0 :
				                	BRF153.getR16_minusten_onetothreeyear().intValue());
				            } 
				            
				            Cell R15cell9 = row15.getCell(12);
				            if (R15cell9 != null) {
				                R15cell9.setCellValue(BRF153.getR16_plusten_threeyear() == null ? 0 :
				                	BRF153.getR16_plusten_threeyear().intValue());
				            } 
				            
				            Cell R15cell10 = row15.getCell(13);
				            if (R15cell10 != null) {
				                R15cell10.setCellValue(BRF153.getR16_minusten_threeyear() == null ? 0 :
				                	BRF153.getR16_minusten_threeyear().intValue());
				            }
				            
				            
				            
				            //////////////////R17///////////////////////////
				            
				            Row row16 = sheet.getRow(28);
				            Cell R16cell = row16.getCell(3);
				            if (R16cell != null) {
				                R16cell.setCellValue(BRF153.getR17_notational_amount() == null ? 0 :
				                	BRF153.getR17_notational_amount().intValue());
				            }
				            Cell R16cell1 = row16.getCell(4);
				            if (R16cell1 != null) {
				                R16cell1.setCellValue(BRF153.getR17_gross_market() == null ? 0 :
				                	BRF153.getR17_gross_market().intValue());
				            }
				            Cell R16cell2 = row16.getCell(5);
				            if (R16cell2 != null) {
				                R16cell2.setCellValue(BRF153.getR17_lessthan_oneyear() == null ? 0 :
				                	BRF153.getR17_lessthan_oneyear().intValue());
				            }

				            
				            Cell R16cell3 = row16.getCell(6);
				            if (R16cell3 != null) {
				                R16cell3.setCellValue(BRF153.getR17_onetothree_year() == null ? 0 :
				                	BRF153.getR17_onetothree_year().intValue());
				            }
				            
				            Cell R16cell4 = row16.getCell(7);
				            if (R16cell4 != null) {
				                R16cell4.setCellValue(BRF153.getR17_morethan_threeyear() == null ? 0 :
				                	BRF153.getR17_morethan_threeyear().intValue());
				            }
				            
				            Cell R16cell5 = row16.getCell(8);
				            if (R16cell5 != null) {
				                R16cell5.setCellValue(BRF153.getR17_plusten_oneyear() == null ? 0 :
				                	BRF153.getR17_plusten_oneyear().intValue());
				            }
				            
				            Cell R16cell6 = row16.getCell(9);
				            if (R16cell6 != null) {
				                R16cell6.setCellValue(BRF153.getR17_minusten_oneyear() == null ? 0 :
				                	BRF153.getR17_minusten_oneyear().intValue());
				            }
				            
				            Cell R16cell7 = row16.getCell(10);
				            if (R16cell7 != null) {
				                R16cell7.setCellValue(BRF153.getR17_plusten_onetothreeyear() == null ? 0 :
				                	BRF153.getR17_plusten_onetothreeyear().intValue());
				            }
				          
				            Cell R16cell8 = row16.getCell(11);
				            if (R16cell8 != null) {
				                R16cell8.setCellValue(BRF153.getR17_minusten_onetothreeyear() == null ? 0 :
				                	BRF153.getR17_minusten_onetothreeyear().intValue());
				            } 
				            
				            Cell R16cell9 = row16.getCell(12);
				            if (R16cell9 != null) {
				                R16cell9.setCellValue(BRF153.getR17_plusten_threeyear() == null ? 0 :
				                	BRF153.getR17_plusten_threeyear().intValue());
				            } 
				            
				            Cell R16cell10 = row16.getCell(13);
				            if (R16cell10 != null) {
				                R16cell10.setCellValue(BRF153.getR17_minusten_threeyear() == null ? 0 :
				                	BRF153.getR17_minusten_threeyear().intValue());
				            }
				            
				            /////////////////////////R18/////////////////////////////
				            
				            Row row17 = sheet.getRow(29);
				            Cell R17cell = row17.getCell(3);
				            if (R17cell != null) {
				                R17cell.setCellValue(BRF153.getR18_notational_amount() == null ? 0 :
				                	BRF153.getR18_notational_amount().intValue());
				            }
				            Cell R17cell1 = row17.getCell(4);
				            if (R17cell1 != null) {
				                R17cell1.setCellValue(BRF153.getR18_gross_market() == null ? 0 :
				                	BRF153.getR18_gross_market().intValue());
				            }
				            Cell R17cell2 = row17.getCell(5);
				            if (R17cell2 != null) {
				                R17cell2.setCellValue(BRF153.getR18_lessthan_oneyear() == null ? 0 :
				                	BRF153.getR18_lessthan_oneyear().intValue());
				            }

				            
				            Cell R17cell3 = row17.getCell(6);
				            if (R17cell3 != null) {
				                R17cell3.setCellValue(BRF153.getR18_onetothree_year() == null ? 0 :
				                	BRF153.getR18_onetothree_year().intValue());
				            }
				            
				            Cell R17cell4 = row17.getCell(7);
				            if (R17cell4 != null) {
				                R17cell4.setCellValue(BRF153.getR18_morethan_threeyear() == null ? 0 :
				                	BRF153.getR18_morethan_threeyear().intValue());
				            }
				            
				            Cell R17cell5 = row17.getCell(8);
				            if (R17cell5 != null) {
				                R17cell5.setCellValue(BRF153.getR18_plusten_oneyear() == null ? 0 :
				                	BRF153.getR18_plusten_oneyear().intValue());
				            }
				            
				            Cell R17cell6 = row17.getCell(9);
				            if (R17cell6 != null) {
				                R17cell6.setCellValue(BRF153.getR18_minusten_oneyear() == null ? 0 :
				                	BRF153.getR18_minusten_oneyear().intValue());
				            }
				            
				            Cell R17cell7 = row17.getCell(10);
				            if (R17cell7 != null) {
				                R17cell7.setCellValue(BRF153.getR18_plusten_onetothreeyear() == null ? 0 :
				                	BRF153.getR18_plusten_onetothreeyear().intValue());
				            }
				          
				            Cell R17cell8 = row17.getCell(11);
				            if (R17cell8 != null) {
				                R17cell8.setCellValue(BRF153.getR18_minusten_onetothreeyear() == null ? 0 :
				                	BRF153.getR18_minusten_onetothreeyear().intValue());
				            } 
				            
				            Cell R17cell9 = row17.getCell(12);
				            if (R17cell9 != null) {
				                R17cell9.setCellValue(BRF153.getR18_plusten_threeyear() == null ? 0 :
				                	BRF153.getR18_plusten_threeyear().intValue());
				            } 
				            
				            Cell R17cell10 = row17.getCell(13);
				            if (R17cell10 != null) {
				                R17cell10.setCellValue(BRF153.getR18_minusten_threeyear() == null ? 0 :
				                	BRF153.getR18_minusten_threeyear().intValue());
				            }
				            
				            ///////////////////////////R19//////////////////////////
				            
				            Row row18 = sheet.getRow(30);
				            Cell R18cell = row18.getCell(3);
				            if (R18cell != null) {
				                R18cell.setCellValue(BRF153.getR19_notational_amount() == null ? 0 :
				                	BRF153.getR19_notational_amount().intValue());
				            }
				            Cell R18cell1 = row18.getCell(4);
				            if (R18cell1 != null) {
				                R18cell1.setCellValue(BRF153.getR19_gross_market() == null ? 0 :
				                	BRF153.getR19_gross_market().intValue());
				            }
				            Cell R18cell2 = row18.getCell(5);
				            if (R18cell2 != null) {
				                R18cell2.setCellValue(BRF153.getR19_lessthan_oneyear() == null ? 0 :
				                	BRF153.getR19_lessthan_oneyear().intValue());
				            }

				            
				            Cell R18cell3 = row18.getCell(6);
				            if (R18cell3 != null) {
				                R18cell3.setCellValue(BRF153.getR19_onetothree_year() == null ? 0 :
				                	BRF153.getR19_onetothree_year().intValue());
				            }
				            
				            Cell R18cell4 = row18.getCell(7);
				            if (R18cell4 != null) {
				                R18cell4.setCellValue(BRF153.getR19_morethan_threeyear() == null ? 0 :
				                	BRF153.getR19_morethan_threeyear().intValue());
				            }
				            
				            Cell R18cell5 = row18.getCell(8);
				            if (R18cell5 != null) {
				                R18cell5.setCellValue(BRF153.getR19_plusten_oneyear() == null ? 0 :
				                	BRF153.getR19_plusten_oneyear().intValue());
				            }
				            
				            Cell R18cell6 = row18.getCell(9);
				            if (R18cell6 != null) {
				                R18cell6.setCellValue(BRF153.getR19_minusten_oneyear() == null ? 0 :
				                	BRF153.getR19_minusten_oneyear().intValue());
				            }
				            
				            Cell R18cell7 = row18.getCell(10);
				            if (R18cell7 != null) {
				                R18cell7.setCellValue(BRF153.getR19_plusten_onetothreeyear() == null ? 0 :
				                	BRF153.getR19_plusten_onetothreeyear().intValue());
				            }
				          
				            Cell R18cell8 = row18.getCell(11);
				            if (R18cell8 != null) {
				                R18cell8.setCellValue(BRF153.getR19_minusten_onetothreeyear() == null ? 0 :
				                	BRF153.getR19_minusten_onetothreeyear().intValue());
				            } 
				            
				            Cell R18cell9 = row18.getCell(12);
				            if (R18cell9 != null) {
				                R18cell9.setCellValue(BRF153.getR19_plusten_threeyear() == null ? 0 :
				                	BRF153.getR19_plusten_threeyear().intValue());
				            } 
				            
				            Cell R18cell10 = row18.getCell(13);
				            if (R18cell10 != null) {
				                R18cell10.setCellValue(BRF153.getR19_minusten_threeyear() == null ? 0 :
				                	BRF153.getR19_minusten_threeyear().intValue());
				            }
				            
				            /////////////////////////R20////////////////////////
				            
				            Row row19 = sheet.getRow(31);
				            Cell R19cell = row19.getCell(3);
				            if (R19cell != null) {
				                R19cell.setCellValue(BRF153.getR20_notational_amount() == null ? 0 :
				                	BRF153.getR20_notational_amount().intValue());
				            }
				            Cell R19cell1 = row19.getCell(4);
				            if (R19cell1 != null) {
				                R19cell1.setCellValue(BRF153.getR20_gross_market() == null ? 0 :
				                	BRF153.getR20_gross_market().intValue());
				            }
				            Cell R19cell2 = row19.getCell(5);
				            if (R19cell2 != null) {
				                R19cell2.setCellValue(BRF153.getR20_lessthan_oneyear() == null ? 0 :
				                	BRF153.getR20_lessthan_oneyear().intValue());
				            }

				            
				            Cell R19cell3 = row19.getCell(6);
				            if (R19cell3 != null) {
				                R19cell3.setCellValue(BRF153.getR20_onetothree_year() == null ? 0 :
				                	BRF153.getR20_onetothree_year().intValue());
				            }
				            
				            Cell R19cell4 = row19.getCell(7);
				            if (R19cell4 != null) {
				                R19cell4.setCellValue(BRF153.getR20_morethan_threeyear() == null ? 0 :
				                	BRF153.getR20_morethan_threeyear().intValue());
				            }
				            
				            Cell R19cell5 = row19.getCell(8);
				            if (R19cell5 != null) {
				                R19cell5.setCellValue(BRF153.getR20_plusten_oneyear() == null ? 0 :
				                	BRF153.getR20_plusten_oneyear().intValue());
				            }
				            
				            Cell R19cell6 = row19.getCell(9);
				            if (R19cell6 != null) {
				                R19cell6.setCellValue(BRF153.getR20_minusten_oneyear() == null ? 0 :
				                	BRF153.getR20_minusten_oneyear().intValue());
				            }
				            
				            Cell R19cell7 = row19.getCell(10);
				            if (R19cell7 != null) {
				                R19cell7.setCellValue(BRF153.getR20_plusten_onetothreeyear() == null ? 0 :
				                	BRF153.getR20_plusten_onetothreeyear().intValue());
				            }
				          
				            Cell R19cell8 = row19.getCell(11);
				            if (R19cell8 != null) {
				                R19cell8.setCellValue(BRF153.getR20_minusten_onetothreeyear() == null ? 0 :
				                	BRF153.getR20_minusten_onetothreeyear().intValue());
				            } 
				            
				            Cell R19cell9 = row19.getCell(12);
				            if (R19cell9 != null) {
				                R19cell9.setCellValue(BRF153.getR20_plusten_threeyear() == null ? 0 :
				                	BRF153.getR20_plusten_threeyear().intValue());
				            } 
				            
				            Cell R19cell10 = row19.getCell(13);
				            if (R19cell10 != null) {
				                R19cell10.setCellValue(BRF153.getR20_minusten_threeyear() == null ? 0 :
				                	BRF153.getR20_minusten_threeyear().intValue());
				            }
				            
				            /////////////////////R21/////////////////////
				            
				            Row row20 = sheet.getRow(32);
				            Cell R20cell = row20.getCell(3);
				            if (R20cell != null) {
				                R20cell.setCellValue(BRF153.getR21_notational_amount() == null ? 0 :
				                	BRF153.getR21_notational_amount().intValue());
				            }
				            Cell R20cell1 = row20.getCell(4);
				            if (R20cell1 != null) {
				                R20cell1.setCellValue(BRF153.getR21_gross_market() == null ? 0 :
				                	BRF153.getR21_gross_market().intValue());
				            }
				            Cell R20cell2 = row20.getCell(5);
				            if (R20cell2 != null) {
				                R20cell2.setCellValue(BRF153.getR21_lessthan_oneyear() == null ? 0 :
				                	BRF153.getR21_lessthan_oneyear().intValue());
				            }

				            
				            Cell R20cell3 = row20.getCell(6);
				            if (R20cell3 != null) {
				                R20cell3.setCellValue(BRF153.getR21_onetothree_year() == null ? 0 :
				                	BRF153.getR21_onetothree_year().intValue());
				            }
				            
				            Cell R20cell4 = row20.getCell(7);
				            if (R20cell4 != null) {
				                R20cell4.setCellValue(BRF153.getR21_morethan_threeyear() == null ? 0 :
				                	BRF153.getR21_morethan_threeyear().intValue());
				            }
				            
				            Cell R20cell5 = row20.getCell(8);
				            if (R20cell5 != null) {
				                R20cell5.setCellValue(BRF153.getR21_plusten_oneyear() == null ? 0 :
				                	BRF153.getR21_plusten_oneyear().intValue());
				            }
				            
				            Cell R20cell6 = row20.getCell(9);
				            if (R20cell6 != null) {
				                R20cell6.setCellValue(BRF153.getR21_minusten_oneyear() == null ? 0 :
				                	BRF153.getR21_minusten_oneyear().intValue());
				            }
				            
				            Cell R20cell7 = row20.getCell(10);
				            if (R20cell7 != null) {
				                R20cell7.setCellValue(BRF153.getR21_plusten_onetothreeyear() == null ? 0 :
				                	BRF153.getR21_plusten_onetothreeyear().intValue());
				            }
				          
				            Cell R20cell8 = row20.getCell(11);
				            if (R20cell8 != null) {
				                R20cell8.setCellValue(BRF153.getR21_minusten_onetothreeyear() == null ? 0 :
				                	BRF153.getR21_minusten_onetothreeyear().intValue());
				            } 
				            
				            Cell R20cell9 = row20.getCell(12);
				            if (R20cell9 != null) {
				                R20cell9.setCellValue(BRF153.getR21_plusten_threeyear() == null ? 0 :
				                	BRF153.getR21_plusten_threeyear().intValue());
				            } 
				            
				            Cell R20cell10 = row20.getCell(13);
				            if (R20cell10 != null) {
				                R20cell10.setCellValue(BRF153.getR21_minusten_threeyear() == null ? 0 :
				                	BRF153.getR21_minusten_threeyear().intValue());
				            }
				            
				            
				            ////////////////////////R22//////////////////////////
				            
				            
				            Row row21 = sheet.getRow(33);
				            Cell R21cell = row21.getCell(3);
				            if (R21cell != null) {
				                R21cell.setCellValue(BRF153.getR22_notational_amount() == null ? 0 :
				                	BRF153.getR22_notational_amount().intValue());
				            }
				            Cell R21cell1 = row21.getCell(4);
				            if (R21cell1 != null) {
				                R21cell1.setCellValue(BRF153.getR22_gross_market() == null ? 0 :
				                	BRF153.getR22_gross_market().intValue());
				            }
				            Cell R21cell2 = row21.getCell(5);
				            if (R21cell2 != null) {
				                R21cell2.setCellValue(BRF153.getR22_lessthan_oneyear() == null ? 0 :
				                	BRF153.getR22_lessthan_oneyear().intValue());
				            }

				            
				            Cell R21cell3 = row21.getCell(6);
				            if (R21cell3 != null) {
				                R21cell3.setCellValue(BRF153.getR22_onetothree_year() == null ? 0 :
				                	BRF153.getR22_onetothree_year().intValue());
				            }
				            
				            Cell R21cell4 = row21.getCell(7);
				            if (R21cell4 != null) {
				                R21cell4.setCellValue(BRF153.getR22_morethan_threeyear() == null ? 0 :
				                	BRF153.getR22_morethan_threeyear().intValue());
				            }
				            
				            Cell R21cell5 = row21.getCell(8);
				            if (R21cell5 != null) {
				                R21cell5.setCellValue(BRF153.getR22_plusten_oneyear() == null ? 0 :
				                	BRF153.getR22_plusten_oneyear().intValue());
				            }
				            
				            Cell R21cell6 = row21.getCell(9);
				            if (R21cell6 != null) {
				                R21cell6.setCellValue(BRF153.getR22_minusten_oneyear() == null ? 0 :
				                	BRF153.getR22_minusten_oneyear().intValue());
				            }
				            
				            Cell R21cell7 = row21.getCell(10);
				            if (R21cell7 != null) {
				                R21cell7.setCellValue(BRF153.getR22_plusten_onetothreeyear() == null ? 0 :
				                	BRF153.getR22_plusten_onetothreeyear().intValue());
				            }
				          
				            Cell R21cell8 = row21.getCell(11);
				            if (R21cell8 != null) {
				                R21cell8.setCellValue(BRF153.getR22_minusten_onetothreeyear() == null ? 0 :
				                	BRF153.getR22_minusten_onetothreeyear().intValue());
				            } 
				            
				            Cell R21cell9 = row21.getCell(12);
				            if (R21cell9 != null) {
				                R21cell9.setCellValue(BRF153.getR22_plusten_threeyear() == null ? 0 :
				                	BRF153.getR22_plusten_threeyear().intValue());
				            } 
				            
				            Cell R21cell10 = row21.getCell(13);
				            if (R21cell10 != null) {
				                R21cell10.setCellValue(BRF153.getR22_minusten_threeyear() == null ? 0 :
				                	BRF153.getR22_minusten_threeyear().intValue());
				            }
				            
				            
				            ////////////////////////////R23////////////////////////////////
				            
				            
				            Row row22 = sheet.getRow(34);
				            Cell R22cell = row22.getCell(3);
				            if (R22cell != null) {
				                R22cell.setCellValue(BRF153.getR23_notational_amount() == null ? 0 :
				                	BRF153.getR23_notational_amount().intValue());
				            }
				            Cell R22cell1 = row22.getCell(4);
				            if (R22cell1 != null) {
				                R22cell1.setCellValue(BRF153.getR23_gross_market() == null ? 0 :
				                	BRF153.getR23_gross_market().intValue());
				            }
				            Cell R22cell2 = row22.getCell(5);
				            if (R22cell2 != null) {
				                R22cell2.setCellValue(BRF153.getR23_lessthan_oneyear() == null ? 0 :
				                	BRF153.getR23_lessthan_oneyear().intValue());
				            }

				            
				            Cell R22cell3 = row22.getCell(6);
				            if (R22cell3 != null) {
				                R22cell3.setCellValue(BRF153.getR23_onetothree_year() == null ? 0 :
				                	BRF153.getR23_onetothree_year().intValue());
				            }
				            
				            Cell R22cell4 = row22.getCell(7);
				            if (R22cell4 != null) {
				                R22cell4.setCellValue(BRF153.getR23_morethan_threeyear() == null ? 0 :
				                	BRF153.getR23_morethan_threeyear().intValue());
				            }
				            
				            Cell R22cell5 = row22.getCell(8);
				            if (R22cell5 != null) {
				                R22cell5.setCellValue(BRF153.getR23_plusten_oneyear() == null ? 0 :
				                	BRF153.getR23_plusten_oneyear().intValue());
				            }
				            
				            Cell R22cell6 = row22.getCell(9);
				            if (R22cell6 != null) {
				                R22cell6.setCellValue(BRF153.getR23_minusten_oneyear() == null ? 0 :
				                	BRF153.getR23_minusten_oneyear().intValue());
				            }
				            
				            Cell R22cell7 = row22.getCell(10);
				            if (R22cell7 != null) {
				                R22cell7.setCellValue(BRF153.getR23_plusten_onetothreeyear() == null ? 0 :
				                	BRF153.getR23_plusten_onetothreeyear().intValue());
				            }
				          
				            Cell R22cell8 = row22.getCell(11);
				            if (R22cell8 != null) {
				                R22cell8.setCellValue(BRF153.getR23_minusten_onetothreeyear() == null ? 0 :
				                	BRF153.getR23_minusten_onetothreeyear().intValue());
				            } 
				            
				            Cell R22cell9 = row22.getCell(12);
				            if (R22cell9 != null) {
				                R22cell9.setCellValue(BRF153.getR23_plusten_threeyear() == null ? 0 :
				                	BRF153.getR23_plusten_threeyear().intValue());
				            } 
				            
				            Cell R22cell10 = row22.getCell(13);
				            if (R22cell10 != null) {
				                R22cell10.setCellValue(BRF153.getR23_minusten_threeyear() == null ? 0 :
				                	BRF153.getR23_minusten_threeyear().intValue());
				            }
				            
				            
				            ///////////////////R24/////////////////////////
				            
				            Row row23 = sheet.getRow(35);
				            Cell R23cell = row23.getCell(3);
				            if (R23cell != null) {
				                R23cell.setCellValue(BRF153.getR24_notational_amount() == null ? 0 :
				                	BRF153.getR24_notational_amount().intValue());
				            }
				            Cell R23cell1 = row23.getCell(4);
				            if (R23cell1 != null) {
				                R23cell1.setCellValue(BRF153.getR24_gross_market() == null ? 0 :
				                	BRF153.getR24_gross_market().intValue());
				            }
				            Cell R23cell2 = row23.getCell(5);
				            if (R23cell2 != null) {
				                R23cell2.setCellValue(BRF153.getR24_lessthan_oneyear() == null ? 0 :
				                	BRF153.getR24_lessthan_oneyear().intValue());
				            }

				            
				            Cell R23cell3 = row23.getCell(6);
				            if (R23cell3 != null) {
				                R23cell3.setCellValue(BRF153.getR24_onetothree_year() == null ? 0 :
				                	BRF153.getR24_onetothree_year().intValue());
				            }
				            
				            Cell R23cell4 = row23.getCell(7);
				            if (R23cell4 != null) {
				                R23cell4.setCellValue(BRF153.getR24_morethan_threeyear() == null ? 0 :
				                	BRF153.getR24_morethan_threeyear().intValue());
				            }
				            
				            Cell R23cell5 = row23.getCell(8);
				            if (R23cell5 != null) {
				                R23cell5.setCellValue(BRF153.getR24_plusten_oneyear() == null ? 0 :
				                	BRF153.getR24_plusten_oneyear().intValue());
				            }
				            
				            Cell R23cell6 = row23.getCell(9);
				            if (R23cell6 != null) {
				                R23cell6.setCellValue(BRF153.getR24_minusten_oneyear() == null ? 0 :
				                	BRF153.getR24_minusten_oneyear().intValue());
				            }
				            
				            Cell R23cell7 = row23.getCell(10);
				            if (R23cell7 != null) {
				                R23cell7.setCellValue(BRF153.getR24_plusten_onetothreeyear() == null ? 0 :
				                	BRF153.getR24_plusten_onetothreeyear().intValue());
				            }
				          
				            Cell R23cell8 = row23.getCell(11);
				            if (R23cell8 != null) {
				                R23cell8.setCellValue(BRF153.getR24_minusten_onetothreeyear() == null ? 0 :
				                	BRF153.getR24_minusten_onetothreeyear().intValue());
				            } 
				            
				            Cell R23cell9 = row23.getCell(12);
				            if (R23cell9 != null) {
				                R23cell9.setCellValue(BRF153.getR24_plusten_threeyear() == null ? 0 :
				                	BRF153.getR24_plusten_threeyear().intValue());
				            } 
				            
				            Cell R23cell10 = row23.getCell(13);
				            if (R23cell10 != null) {
				                R23cell10.setCellValue(BRF153.getR24_minusten_threeyear() == null ? 0 :
				                	BRF153.getR24_minusten_threeyear().intValue());
				            }
				            
				            
				            ///////////////////R25//////////////////////////
				            
				            Row row24 = sheet.getRow(36);
				            Cell R24cell = row24.getCell(3);
				            if (R24cell != null) {
				                R24cell.setCellValue(BRF153.getR25_notational_amount() == null ? 0 :
				                	BRF153.getR25_notational_amount().intValue());
				            }
				            Cell R24cell1 = row24.getCell(4);
				            if (R24cell1 != null) {
				                R24cell1.setCellValue(BRF153.getR25_gross_market() == null ? 0 :
				                	BRF153.getR25_gross_market().intValue());
				            }
				            Cell R24cell2 = row24.getCell(5);
				            if (R24cell2 != null) {
				                R24cell2.setCellValue(BRF153.getR25_lessthan_oneyear() == null ? 0 :
				                	BRF153.getR25_lessthan_oneyear().intValue());
				            }

				            
				            Cell R24cell3 = row24.getCell(6);
				            if (R24cell3 != null) {
				                R24cell3.setCellValue(BRF153.getR25_onetothree_year() == null ? 0 :
				                	BRF153.getR25_onetothree_year().intValue());
				            }
				            
				            Cell R24cell4 = row24.getCell(7);
				            if (R24cell4 != null) {
				                R24cell4.setCellValue(BRF153.getR25_morethan_threeyear() == null ? 0 :
				                	BRF153.getR25_morethan_threeyear().intValue());
				            }
				            
				            Cell R24cell5 = row24.getCell(8);
				            if (R24cell5 != null) {
				                R24cell5.setCellValue(BRF153.getR25_plusten_oneyear() == null ? 0 :
				                	BRF153.getR25_plusten_oneyear().intValue());
				            }
				            
				            Cell R24cell6 = row24.getCell(9);
				            if (R24cell6 != null) {
				                R24cell6.setCellValue(BRF153.getR25_minusten_oneyear() == null ? 0 :
				                	BRF153.getR25_minusten_oneyear().intValue());
				            }
				            
				            Cell R24cell7 = row24.getCell(10);
				            if (R24cell7 != null) {
				                R24cell7.setCellValue(BRF153.getR25_plusten_onetothreeyear() == null ? 0 :
				                	BRF153.getR25_plusten_onetothreeyear().intValue());
				            }
				          
				            Cell R24cell8 = row24.getCell(11);
				            if (R24cell8 != null) {
				                R24cell8.setCellValue(BRF153.getR25_minusten_onetothreeyear() == null ? 0 :
				                	BRF153.getR25_minusten_onetothreeyear().intValue());
				            } 
				            
				            Cell R24cell9 = row24.getCell(12);
				            if (R24cell9 != null) {
				                R24cell9.setCellValue(BRF153.getR25_plusten_threeyear() == null ? 0 :
				                	BRF153.getR25_plusten_threeyear().intValue());
				            } 
				            
				            Cell R24cell10 = row24.getCell(13);
				            if (R24cell10 != null) {
				                R24cell10.setCellValue(BRF153.getR25_minusten_threeyear() == null ? 0 :
				                	BRF153.getR25_minusten_threeyear().intValue());
				            }
				            
				            
				            ////////////////////R26//////////////////////////
				            
				            Row row25 = sheet.getRow(37);
				            Cell R25cell = row25.getCell(3);
				            if (R25cell != null) {
				                R25cell.setCellValue(BRF153.getR26_notational_amount() == null ? 0 :
				                	BRF153.getR26_notational_amount().intValue());
				            }
				            Cell R25cell1 = row25.getCell(4);
				            if (R25cell1 != null) {
				                R25cell1.setCellValue(BRF153.getR26_gross_market() == null ? 0 :
				                	BRF153.getR26_gross_market().intValue());
				            }
				            Cell R25cell2 = row25.getCell(5);
				            if (R25cell2 != null) {
				                R25cell2.setCellValue(BRF153.getR26_lessthan_oneyear() == null ? 0 :
				                	BRF153.getR26_lessthan_oneyear().intValue());
				            }

				            
				            Cell R25cell3 = row25.getCell(6);
				            if (R25cell3 != null) {
				                R25cell3.setCellValue(BRF153.getR26_onetothree_year() == null ? 0 :
				                	BRF153.getR26_onetothree_year().intValue());
				            }
				            
				            Cell R25cell4 = row25.getCell(7);
				            if (R25cell4 != null) {
				                R25cell4.setCellValue(BRF153.getR26_morethan_threeyear() == null ? 0 :
				                	BRF153.getR26_morethan_threeyear().intValue());
				            }
				            
				            Cell R25cell5 = row25.getCell(8);
				            if (R25cell5 != null) {
				                R25cell5.setCellValue(BRF153.getR26_plusten_oneyear() == null ? 0 :
				                	BRF153.getR26_plusten_oneyear().intValue());
				            }
				            
				            Cell R25cell6 = row25.getCell(9);
				            if (R25cell6 != null) {
				                R25cell6.setCellValue(BRF153.getR26_minusten_oneyear() == null ? 0 :
				                	BRF153.getR26_minusten_oneyear().intValue());
				            }
				            
				            Cell R25cell7 = row25.getCell(10);
				            if (R25cell7 != null) {
				                R25cell7.setCellValue(BRF153.getR26_plusten_onetothreeyear() == null ? 0 :
				                	BRF153.getR26_plusten_onetothreeyear().intValue());
				            }
				          
				            Cell R25cell8 = row25.getCell(11);
				            if (R25cell8 != null) {
				                R25cell8.setCellValue(BRF153.getR26_minusten_onetothreeyear() == null ? 0 :
				                	BRF153.getR26_minusten_onetothreeyear().intValue());
				            } 
				            
				            Cell R25cell9 = row25.getCell(12);
				            if (R25cell9 != null) {
				                R25cell9.setCellValue(BRF153.getR26_plusten_threeyear() == null ? 0 :
				                	BRF153.getR26_plusten_threeyear().intValue());
				            } 
				            
				            Cell R25cell10 = row25.getCell(13);
				            if (R25cell10 != null) {
				                R25cell10.setCellValue(BRF153.getR26_minusten_threeyear() == null ? 0 :
				                	BRF153.getR26_minusten_threeyear().intValue());
				            }
				            
				            
				            ///////////////////////////R27/////////////////////////////
				            
				            Row row26 = sheet.getRow(38);
				            Cell R26cell = row26.getCell(3);
				            if (R26cell != null) {
				                R26cell.setCellValue(BRF153.getR27_notational_amount() == null ? 0 :
				                	BRF153.getR27_notational_amount().intValue());
				            }
				            Cell R26cell1 = row26.getCell(4);
				            if (R26cell1 != null) {
				                R26cell1.setCellValue(BRF153.getR27_gross_market() == null ? 0 :
				                	BRF153.getR27_gross_market().intValue());
				            }
				            Cell R26cell2 = row26.getCell(5);
				            if (R26cell2 != null) {
				                R26cell2.setCellValue(BRF153.getR27_lessthan_oneyear() == null ? 0 :
				                	BRF153.getR27_lessthan_oneyear().intValue());
				            }

				            
				            Cell R26cell3 = row26.getCell(6);
				            if (R26cell3 != null) {
				                R26cell3.setCellValue(BRF153.getR27_onetothree_year() == null ? 0 :
				                	BRF153.getR27_onetothree_year().intValue());
				            }
				            
				            Cell R26cell4 = row26.getCell(7);
				            if (R26cell4 != null) {
				                R26cell4.setCellValue(BRF153.getR27_morethan_threeyear() == null ? 0 :
				                	BRF153.getR27_morethan_threeyear().intValue());
				            }
				            
				            Cell R26cell5 = row26.getCell(8);
				            if (R26cell5 != null) {
				                R26cell5.setCellValue(BRF153.getR27_plusten_oneyear() == null ? 0 :
				                	BRF153.getR27_plusten_oneyear().intValue());
				            }
				            
				            Cell R26cell6 = row26.getCell(9);
				            if (R26cell6 != null) {
				                R26cell6.setCellValue(BRF153.getR27_minusten_oneyear() == null ? 0 :
				                	BRF153.getR27_minusten_oneyear().intValue());
				            }
				            
				            Cell R26cell7 = row26.getCell(10);
				            if (R26cell7 != null) {
				                R26cell7.setCellValue(BRF153.getR27_plusten_onetothreeyear() == null ? 0 :
				                	BRF153.getR27_plusten_onetothreeyear().intValue());
				            }
				          
				            Cell R26cell8 = row26.getCell(11);
				            if (R26cell8 != null) {
				                R26cell8.setCellValue(BRF153.getR27_minusten_onetothreeyear() == null ? 0 :
				                	BRF153.getR27_minusten_onetothreeyear().intValue());
				            } 
				            
				            Cell R26cell9 = row26.getCell(12);
				            if (R26cell9 != null) {
				                R26cell9.setCellValue(BRF153.getR27_plusten_threeyear() == null ? 0 :
				                	BRF153.getR27_plusten_threeyear().intValue());
				            } 
				            
				            Cell R26cell10 = row26.getCell(13);
				            if (R26cell10 != null) {
				                R26cell10.setCellValue(BRF153.getR27_minusten_threeyear() == null ? 0 :
				                	BRF153.getR27_minusten_threeyear().intValue());
				            }
				            
				            
				            ////////////////////////////////R27////////////////////////
				            
				            Row row27 = sheet.getRow(39);
				            Cell R27cell = row27.getCell(3);
				            if (R27cell != null) {
				                R27cell.setCellValue(BRF153.getR28_notational_amount() == null ? 0 :
				                	BRF153.getR28_notational_amount().intValue());
				            }
				            Cell R27cell1 = row27.getCell(4);
				            if (R27cell1 != null) {
				                R27cell1.setCellValue(BRF153.getR28_gross_market() == null ? 0 :
				                	BRF153.getR28_gross_market().intValue());
				            }
				            Cell R27cell2 = row27.getCell(5);
				            if (R27cell2 != null) {
				                R27cell2.setCellValue(BRF153.getR28_lessthan_oneyear() == null ? 0 :
				                	BRF153.getR28_lessthan_oneyear().intValue());
				            }

				            
				            Cell R27cell3 = row27.getCell(6);
				            if (R27cell3 != null) {
				                R27cell3.setCellValue(BRF153.getR28_onetothree_year() == null ? 0 :
				                	BRF153.getR28_onetothree_year().intValue());
				            }
				            
				            Cell R27cell4 = row27.getCell(7);
				            if (R27cell4 != null) {
				                R27cell4.setCellValue(BRF153.getR28_morethan_threeyear() == null ? 0 :
				                	BRF153.getR28_morethan_threeyear().intValue());
				            }
				            
				            Cell R27cell5 = row27.getCell(8);
				            if (R27cell5 != null) {
				                R27cell5.setCellValue(BRF153.getR28_plusten_oneyear() == null ? 0 :
				                	BRF153.getR28_plusten_oneyear().intValue());
				            }
				            
				            Cell R27cell6 = row27.getCell(9);
				            if (R27cell6 != null) {
				                R27cell6.setCellValue(BRF153.getR28_minusten_oneyear() == null ? 0 :
				                	BRF153.getR28_minusten_oneyear().intValue());
				            }
				            
				            Cell R27cell7 = row27.getCell(10);
				            if (R27cell7 != null) {
				                R27cell7.setCellValue(BRF153.getR28_plusten_onetothreeyear() == null ? 0 :
				                	BRF153.getR28_plusten_onetothreeyear().intValue());
				            }
				          
				            Cell R27cell8 = row27.getCell(11);
				            if (R27cell8 != null) {
				                R27cell8.setCellValue(BRF153.getR28_minusten_onetothreeyear() == null ? 0 :
				                	BRF153.getR28_minusten_onetothreeyear().intValue());
				            } 
				            
				            Cell R27cell9 = row27.getCell(12);
				            if (R27cell9 != null) {
				                R27cell9.setCellValue(BRF153.getR28_plusten_threeyear() == null ? 0 :
				                	BRF153.getR28_plusten_threeyear().intValue());
				            } 
				            
				            Cell R27cell10 = row27.getCell(13);
				            if (R27cell10 != null) {
				                R27cell10.setCellValue(BRF153.getR28_minusten_threeyear() == null ? 0 :
				                	BRF153.getR28_minusten_threeyear().intValue());
				            }
				            
				            //////////////////////R29/////////////////////
				            
				            
				            Row row28 = sheet.getRow(40);
				            Cell R28cell = row28.getCell(3);
				            if (R28cell != null) {
				                R28cell.setCellValue(BRF153.getR29_notational_amount() == null ? 0 :
				                	BRF153.getR29_notational_amount().intValue());
				            }
				            Cell R28cell1 = row28.getCell(4);
				            if (R28cell1 != null) {
				                R28cell1.setCellValue(BRF153.getR29_gross_market() == null ? 0 :
				                	BRF153.getR29_gross_market().intValue());
				            }
				            Cell R28cell2 = row28.getCell(5);
				            if (R28cell2 != null) {
				                R28cell2.setCellValue(BRF153.getR29_lessthan_oneyear() == null ? 0 :
				                	BRF153.getR29_lessthan_oneyear().intValue());
				            }

				            
				            Cell R28cell3 = row28.getCell(6);
				            if (R28cell3 != null) {
				                R28cell3.setCellValue(BRF153.getR29_onetothree_year() == null ? 0 :
				                	BRF153.getR29_onetothree_year().intValue());
				            }
				            
				            Cell R28cell4 = row28.getCell(7);
				            if (R28cell4 != null) {
				                R28cell4.setCellValue(BRF153.getR29_morethan_threeyear() == null ? 0 :
				                	BRF153.getR29_morethan_threeyear().intValue());
				            }
				            
				            Cell R28cell5 = row28.getCell(8);
				            if (R28cell5 != null) {
				                R28cell5.setCellValue(BRF153.getR29_plusten_oneyear() == null ? 0 :
				                	BRF153.getR29_plusten_oneyear().intValue());
				            }
				            
				            Cell R28cell6 = row28.getCell(9);
				            if (R28cell6 != null) {
				                R28cell6.setCellValue(BRF153.getR29_minusten_oneyear() == null ? 0 :
				                	BRF153.getR29_minusten_oneyear().intValue());
				            }
				            
				            Cell R28cell7 = row28.getCell(10);
				            if (R28cell7 != null) {
				                R28cell7.setCellValue(BRF153.getR29_plusten_onetothreeyear() == null ? 0 :
				                	BRF153.getR29_plusten_onetothreeyear().intValue());
				            }
				          
				            Cell R28cell8 = row28.getCell(11);
				            if (R28cell8 != null) {
				                R28cell8.setCellValue(BRF153.getR29_minusten_onetothreeyear() == null ? 0 :
				                	BRF153.getR29_minusten_onetothreeyear().intValue());
				            } 
				            
				            Cell R28cell9 = row28.getCell(12);
				            if (R28cell9 != null) {
				                R28cell9.setCellValue(BRF153.getR29_plusten_threeyear() == null ? 0 :
				                	BRF153.getR29_plusten_threeyear().intValue());
				            } 
				            
				            Cell R28cell10 = row28.getCell(13);
				            if (R28cell10 != null) {
				                R28cell10.setCellValue(BRF153.getR29_minusten_threeyear() == null ? 0 :
				                	BRF153.getR29_minusten_threeyear().intValue());
				            }
				            
				            
				            ///////////////////////R30/////////////////////////
				            
				            Row row29 = sheet.getRow(41);
				            Cell R29cell = row29.getCell(3);
				            if (R29cell != null) {
				                R29cell.setCellValue(BRF153.getR30_notational_amount() == null ? 0 :
				                	BRF153.getR30_notational_amount().intValue());
				            }
				            Cell R29cell1 = row29.getCell(4);
				            if (R29cell1 != null) {
				                R29cell1.setCellValue(BRF153.getR30_gross_market() == null ? 0 :
				                	BRF153.getR30_gross_market().intValue());
				            }
				            Cell R29cell2 = row29.getCell(5);
				            if (R29cell2 != null) {
				                R29cell2.setCellValue(BRF153.getR30_lessthan_oneyear() == null ? 0 :
				                	BRF153.getR30_lessthan_oneyear().intValue());
				            }

				            
				            Cell R29cell3 = row29.getCell(6);
				            if (R29cell3 != null) {
				                R29cell3.setCellValue(BRF153.getR30_onetothree_year() == null ? 0 :
				                	BRF153.getR30_onetothree_year().intValue());
				            }
				            
				            Cell R29cell4 = row29.getCell(7);
				            if (R29cell4 != null) {
				                R29cell4.setCellValue(BRF153.getR30_morethan_threeyear() == null ? 0 :
				                	BRF153.getR30_morethan_threeyear().intValue());
				            }
				            
				            Cell R29cell5 = row29.getCell(8);
				            if (R29cell5 != null) {
				                R29cell5.setCellValue(BRF153.getR30_plusten_oneyear() == null ? 0 :
				                	BRF153.getR30_plusten_oneyear().intValue());
				            }
				            
				            Cell R29cell6 = row29.getCell(9);
				            if (R29cell6 != null) {
				                R29cell6.setCellValue(BRF153.getR30_minusten_oneyear() == null ? 0 :
				                	BRF153.getR30_minusten_oneyear().intValue());
				            }
				            
				            Cell R29cell7 = row29.getCell(10);
				            if (R29cell7 != null) {
				                R29cell7.setCellValue(BRF153.getR30_plusten_onetothreeyear() == null ? 0 :
				                	BRF153.getR30_plusten_onetothreeyear().intValue());
				            }
				          
				            Cell R29cell8 = row29.getCell(11);
				            if (R29cell8 != null) {
				                R29cell8.setCellValue(BRF153.getR30_minusten_onetothreeyear() == null ? 0 :
				                	BRF153.getR30_minusten_onetothreeyear().intValue());
				            } 
				            
				            Cell R29cell9 = row29.getCell(12);
				            if (R29cell9 != null) {
				                R29cell9.setCellValue(BRF153.getR30_plusten_threeyear() == null ? 0 :
				                	BRF153.getR30_plusten_threeyear().intValue());
				            } 
				            
				            Cell R29cell10 = row29.getCell(13);
				            if (R29cell10 != null) {
				                R29cell10.setCellValue(BRF153.getR30_minusten_threeyear() == null ? 0 :
				                	BRF153.getR30_minusten_threeyear().intValue());
				            }
				            
				            
				            ////////////////////R31////////////////////////
				            
				            Row row30 = sheet.getRow(46);
				            Cell R30cell = row30.getCell(3);
				            if (R30cell != null) {
				                R30cell.setCellValue(BRF153.getR31_notational_amount() == null ? 0 :
				                	BRF153.getR31_notational_amount().intValue());
				            }
				            Cell R30cell1 = row30.getCell(4);
				            if (R30cell1 != null) {
				                R30cell1.setCellValue(BRF153.getR31_gross_market() == null ? 0 :
				                	BRF153.getR31_gross_market().intValue());
				            }
				            Cell R30cell2 = row30.getCell(5);
				            if (R30cell2 != null) {
				                R30cell2.setCellValue(BRF153.getR31_lessthan_oneyear() == null ? 0 :
				                	BRF153.getR31_lessthan_oneyear().intValue());
				            }

				            
				            Cell R30cell3 = row30.getCell(6);
				            if (R30cell3 != null) {
				                R30cell3.setCellValue(BRF153.getR31_onetothree_year() == null ? 0 :
				                	BRF153.getR31_onetothree_year().intValue());
				            }
				            
				            Cell R30cell4 = row30.getCell(7);
				            if (R30cell4 != null) {
				                R30cell4.setCellValue(BRF153.getR31_morethan_threeyear() == null ? 0 :
				                	BRF153.getR31_morethan_threeyear().intValue());
				            }
				            
				            Cell R30cell5 = row30.getCell(8);
				            if (R30cell5 != null) {
				                R30cell5.setCellValue(BRF153.getR31_plusten_oneyear() == null ? 0 :
				                	BRF153.getR31_plusten_oneyear().intValue());
				            }
				            
				            Cell R30cell6 = row30.getCell(9);
				            if (R30cell6 != null) {
				                R30cell6.setCellValue(BRF153.getR31_minusten_oneyear() == null ? 0 :
				                	BRF153.getR31_minusten_oneyear().intValue());
				            }
				            
				            Cell R30cell7 = row30.getCell(10);
				            if (R30cell7 != null) {
				                R30cell7.setCellValue(BRF153.getR31_plusten_onetothreeyear() == null ? 0 :
				                	BRF153.getR31_plusten_onetothreeyear().intValue());
				            }
				          
				            Cell R30cell8 = row30.getCell(11);
				            if (R30cell8 != null) {
				                R30cell8.setCellValue(BRF153.getR31_minusten_onetothreeyear() == null ? 0 :
				                	BRF153.getR31_minusten_onetothreeyear().intValue());
				            } 
				            
				            Cell R30cell9 = row30.getCell(12);
				            if (R30cell9 != null) {
				                R30cell9.setCellValue(BRF153.getR31_plusten_threeyear() == null ? 0 :
				                	BRF153.getR31_plusten_threeyear().intValue());
				            } 
				            
				            Cell R30cell10 = row30.getCell(13);
				            if (R30cell10 != null) {
				                R30cell10.setCellValue(BRF153.getR31_minusten_threeyear() == null ? 0 :
				                	BRF153.getR31_minusten_threeyear().intValue());
				            }
				            
				            
				            /////////////////////R32////////////////
				            
				            
				            Row row31 = sheet.getRow(47);
				            Cell R31cell = row31.getCell(3);
				            if (R31cell != null) {
				                R31cell.setCellValue(BRF153.getR32_notational_amount() == null ? 0 :
				                	BRF153.getR32_notational_amount().intValue());
				            }
				            Cell R31cell1 = row31.getCell(4);
				            if (R31cell1 != null) {
				                R31cell1.setCellValue(BRF153.getR32_gross_market() == null ? 0 :
				                	BRF153.getR32_gross_market().intValue());
				            }
				            Cell R31cell2 = row31.getCell(5);
				            if (R31cell2 != null) {
				                R31cell2.setCellValue(BRF153.getR32_lessthan_oneyear() == null ? 0 :
				                	BRF153.getR32_lessthan_oneyear().intValue());
				            }

				            
				            Cell R31cell3 = row31.getCell(6);
				            if (R31cell3 != null) {
				                R31cell3.setCellValue(BRF153.getR32_onetothree_year() == null ? 0 :
				                	BRF153.getR32_onetothree_year().intValue());
				            }
				            
				            Cell R31cell4 = row31.getCell(7);
				            if (R31cell4 != null) {
				                R31cell4.setCellValue(BRF153.getR32_morethan_threeyear() == null ? 0 :
				                	BRF153.getR32_morethan_threeyear().intValue());
				            }
				            
				            Cell R31cell5 = row31.getCell(8);
				            if (R31cell5 != null) {
				                R31cell5.setCellValue(BRF153.getR32_plusten_oneyear() == null ? 0 :
				                	BRF153.getR32_plusten_oneyear().intValue());
				            }
				            
				            Cell R31cell6 = row31.getCell(9);
				            if (R31cell6 != null) {
				                R31cell6.setCellValue(BRF153.getR32_minusten_oneyear() == null ? 0 :
				                	BRF153.getR32_minusten_oneyear().intValue());
				            }
				            
				            Cell R31cell7 = row31.getCell(10);
				            if (R31cell7 != null) {
				                R31cell7.setCellValue(BRF153.getR32_plusten_onetothreeyear() == null ? 0 :
				                	BRF153.getR32_plusten_onetothreeyear().intValue());
				            }
				          
				            Cell R31cell8 = row31.getCell(11);
				            if (R31cell8 != null) {
				                R31cell8.setCellValue(BRF153.getR32_minusten_onetothreeyear() == null ? 0 :
				                	BRF153.getR32_minusten_onetothreeyear().intValue());
				            } 
				            
				            Cell R31cell9 = row31.getCell(12);
				            if (R31cell9 != null) {
				                R31cell9.setCellValue(BRF153.getR32_plusten_threeyear() == null ? 0 :
				                	BRF153.getR32_plusten_threeyear().intValue());
				            } 
				            
				            Cell R31cell10 = row31.getCell(13);
				            if (R31cell10 != null) {
				                R31cell10.setCellValue(BRF153.getR32_minusten_threeyear() == null ? 0 :
				                	BRF153.getR32_minusten_threeyear().intValue());
				            }
				            
				            
				            /////////////////////////R33/////////////////////
				            
				            Row row32 = sheet.getRow(48);
				            Cell R32cell = row32.getCell(3);
				            if (R32cell != null) {
				                R32cell.setCellValue(BRF153.getR33_notational_amount() == null ? 0 :
				                	BRF153.getR33_notational_amount().intValue());
				            }
				            Cell R32cell1 = row32.getCell(4);
				            if (R32cell1 != null) {
				                R32cell1.setCellValue(BRF153.getR33_gross_market() == null ? 0 :
				                	BRF153.getR33_gross_market().intValue());
				            }
				            Cell R32cell2 = row32.getCell(5);
				            if (R32cell2 != null) {
				                R32cell2.setCellValue(BRF153.getR33_lessthan_oneyear() == null ? 0 :
				                	BRF153.getR33_lessthan_oneyear().intValue());
				            }

				            
				            Cell R32cell3 = row32.getCell(6);
				            if (R32cell3 != null) {
				                R32cell3.setCellValue(BRF153.getR33_onetothree_year() == null ? 0 :
				                	BRF153.getR33_onetothree_year().intValue());
				            }
				            
				            Cell R32cell4 = row32.getCell(7);
				            if (R32cell4 != null) {
				                R32cell4.setCellValue(BRF153.getR33_morethan_threeyear() == null ? 0 :
				                	BRF153.getR33_morethan_threeyear().intValue());
				            }
				            
				            Cell R32cell5 = row32.getCell(8);
				            if (R32cell5 != null) {
				                R32cell5.setCellValue(BRF153.getR33_plusten_oneyear() == null ? 0 :
				                	BRF153.getR33_plusten_oneyear().intValue());
				            }
				            
				            Cell R32cell6 = row32.getCell(9);
				            if (R32cell6 != null) {
				                R32cell6.setCellValue(BRF153.getR33_minusten_oneyear() == null ? 0 :
				                	BRF153.getR33_minusten_oneyear().intValue());
				            }
				            
				            Cell R32cell7 = row32.getCell(10);
				            if (R32cell7 != null) {
				                R32cell7.setCellValue(BRF153.getR33_plusten_onetothreeyear() == null ? 0 :
				                	BRF153.getR33_plusten_onetothreeyear().intValue());
				            }
				          
				            Cell R32cell8 = row32.getCell(11);
				            if (R32cell8 != null) {
				                R32cell8.setCellValue(BRF153.getR33_minusten_onetothreeyear() == null ? 0 :
				                	BRF153.getR33_minusten_onetothreeyear().intValue());
				            } 
				            
				            Cell R32cell9 = row32.getCell(12);
				            if (R32cell9 != null) {
				                R32cell9.setCellValue(BRF153.getR33_plusten_threeyear() == null ? 0 :
				                	BRF153.getR33_plusten_threeyear().intValue());
				            } 
				            
				            Cell R32cell10 = row32.getCell(13);
				            if (R32cell10 != null) {
				                R32cell10.setCellValue(BRF153.getR33_minusten_threeyear() == null ? 0 :
				                	BRF153.getR33_minusten_threeyear().intValue());
				            }
				            
				            ////////////////////R34////////////////////
				            
				            Row row33 = sheet.getRow(49);
				            Cell R33cell = row33.getCell(3);
				            if (R33cell != null) {
				                R33cell.setCellValue(BRF153.getR34_notational_amount() == null ? 0 :
				                	BRF153.getR34_notational_amount().intValue());
				            }
				            Cell R33cell1 = row33.getCell(4);
				            if (R33cell1 != null) {
				                R33cell1.setCellValue(BRF153.getR34_gross_market() == null ? 0 :
				                	BRF153.getR34_gross_market().intValue());
				            }
				            Cell R33cell2 = row33.getCell(5);
				            if (R33cell2 != null) {
				                R33cell2.setCellValue(BRF153.getR34_lessthan_oneyear() == null ? 0 :
				                	BRF153.getR34_lessthan_oneyear().intValue());
				            }

				            
				            Cell R33cell3 = row33.getCell(6);
				            if (R33cell3 != null) {
				                R33cell3.setCellValue(BRF153.getR34_onetothree_year() == null ? 0 :
				                	BRF153.getR34_onetothree_year().intValue());
				            }
				            
				            Cell R33cell4 = row33.getCell(7);
				            if (R33cell4 != null) {
				                R33cell4.setCellValue(BRF153.getR34_morethan_threeyear() == null ? 0 :
				                	BRF153.getR34_morethan_threeyear().intValue());
				            }
				            
				            Cell R33cell5 = row33.getCell(8);
				            if (R33cell5 != null) {
				                R33cell5.setCellValue(BRF153.getR34_plusten_oneyear() == null ? 0 :
				                	BRF153.getR34_plusten_oneyear().intValue());
				            }
				            
				            Cell R33cell6 = row33.getCell(9);
				            if (R33cell6 != null) {
				                R33cell6.setCellValue(BRF153.getR34_minusten_oneyear() == null ? 0 :
				                	BRF153.getR34_minusten_oneyear().intValue());
				            }
				            
				            Cell R33cell7 = row33.getCell(10);
				            if (R33cell7 != null) {
				                R33cell7.setCellValue(BRF153.getR34_plusten_onetothreeyear() == null ? 0 :
				                	BRF153.getR34_plusten_onetothreeyear().intValue());
				            }
				          
				            Cell R33cell8 = row33.getCell(11);
				            if (R33cell8 != null) {
				                R33cell8.setCellValue(BRF153.getR34_minusten_onetothreeyear() == null ? 0 :
				                	BRF153.getR34_minusten_onetothreeyear().intValue());
				            } 
				            
				            Cell R33cell9 = row33.getCell(12);
				            if (R33cell9 != null) {
				                R33cell9.setCellValue(BRF153.getR34_plusten_threeyear() == null ? 0 :
				                	BRF153.getR34_plusten_threeyear().intValue());
				            } 
				            
				            Cell R33cell10 = row33.getCell(13);
				            if (R33cell10 != null) {
				                R33cell10.setCellValue(BRF153.getR34_minusten_threeyear() == null ? 0 :
				                	BRF153.getR34_minusten_threeyear().intValue());
				            }
				            
				            
				            ///////////////////////////////R35///////////////////////
				            
				            
				            Row row34 = sheet.getRow(50);
				            Cell R34cell = row34.getCell(3);
				            if (R34cell != null) {
				                R34cell.setCellValue(BRF153.getR35_notational_amount() == null ? 0 :
				                	BRF153.getR35_notational_amount().intValue());
				            }
				            Cell R34cell1 = row34.getCell(4);
				            if (R34cell1 != null) {
				                R34cell1.setCellValue(BRF153.getR35_gross_market() == null ? 0 :
				                	BRF153.getR35_gross_market().intValue());
				            }
				            Cell R34cell2 = row34.getCell(5);
				            if (R34cell2 != null) {
				                R34cell2.setCellValue(BRF153.getR35_lessthan_oneyear() == null ? 0 :
				                	BRF153.getR35_lessthan_oneyear().intValue());
				            }

				            
				            Cell R34cell3 = row34.getCell(6);
				            if (R34cell3 != null) {
				                R34cell3.setCellValue(BRF153.getR35_onetothree_year() == null ? 0 :
				                	BRF153.getR35_onetothree_year().intValue());
				            }
				            
				            Cell R34cell4 = row34.getCell(7);
				            if (R34cell4 != null) {
				                R34cell4.setCellValue(BRF153.getR35_morethan_threeyear() == null ? 0 :
				                	BRF153.getR35_morethan_threeyear().intValue());
				            }
				            
				            Cell R34cell5 = row34.getCell(8);
				            if (R34cell5 != null) {
				                R34cell5.setCellValue(BRF153.getR35_plusten_oneyear() == null ? 0 :
				                	BRF153.getR35_plusten_oneyear().intValue());
				            }
				            
				            Cell R34cell6 = row34.getCell(9);
				            if (R34cell6 != null) {
				                R34cell6.setCellValue(BRF153.getR35_minusten_oneyear() == null ? 0 :
				                	BRF153.getR35_minusten_oneyear().intValue());
				            }
				            
				            Cell R34cell7 = row34.getCell(10);
				            if (R34cell7 != null) {
				                R34cell7.setCellValue(BRF153.getR35_plusten_onetothreeyear() == null ? 0 :
				                	BRF153.getR35_plusten_onetothreeyear().intValue());
				            }
				          
				            Cell R34cell8 = row34.getCell(11);
				            if (R34cell8 != null) {
				                R34cell8.setCellValue(BRF153.getR35_minusten_onetothreeyear() == null ? 0 :
				                	BRF153.getR35_minusten_onetothreeyear().intValue());
				            } 
				            
				            Cell R34cell9 = row34.getCell(12);
				            if (R34cell9 != null) {
				                R34cell9.setCellValue(BRF153.getR35_plusten_threeyear() == null ? 0 :
				                	BRF153.getR35_plusten_threeyear().intValue());
				            } 
				            
				            Cell R34cell10 = row34.getCell(13);
				            if (R34cell10 != null) {
				                R34cell10.setCellValue(BRF153.getR35_minusten_threeyear() == null ? 0 :
				                	BRF153.getR35_minusten_threeyear().intValue());
				            }
				            
				            
				            
				            /////////////////////R36///////////////////////////
				            
				            Row row35 = sheet.getRow(51);
				            Cell R35cell = row35.getCell(3);
				            if (R35cell != null) {
				                R35cell.setCellValue(BRF153.getR36_notational_amount() == null ? 0 :
				                	BRF153.getR36_notational_amount().intValue());
				            }
				            Cell R35cell1 = row35.getCell(4);
				            if (R35cell1 != null) {
				                R35cell1.setCellValue(BRF153.getR36_gross_market() == null ? 0 :
				                	BRF153.getR36_gross_market().intValue());
				            }
				            Cell R35cell2 = row35.getCell(5);
				            if (R35cell2 != null) {
				                R35cell2.setCellValue(BRF153.getR36_lessthan_oneyear() == null ? 0 :
				                	BRF153.getR36_lessthan_oneyear().intValue());
				            }

				            
				            Cell R35cell3 = row35.getCell(6);
				            if (R35cell3 != null) {
				                R35cell3.setCellValue(BRF153.getR36_onetothree_year() == null ? 0 :
				                	BRF153.getR36_onetothree_year().intValue());
				            }
				            
				            Cell R35cell4 = row35.getCell(7);
				            if (R35cell4 != null) {
				                R35cell4.setCellValue(BRF153.getR36_morethan_threeyear() == null ? 0 :
				                	BRF153.getR36_morethan_threeyear().intValue());
				            }
				            
				            Cell R35cell5 = row35.getCell(8);
				            if (R35cell5 != null) {
				                R35cell5.setCellValue(BRF153.getR36_plusten_oneyear() == null ? 0 :
				                	BRF153.getR36_plusten_oneyear().intValue());
				            }
				            
				            Cell R35cell6 = row35.getCell(9);
				            if (R35cell6 != null) {
				                R35cell6.setCellValue(BRF153.getR36_minusten_oneyear() == null ? 0 :
				                	BRF153.getR36_minusten_oneyear().intValue());
				            }
				            
				            Cell R35cell7 = row35.getCell(10);
				            if (R35cell7 != null) {
				                R35cell7.setCellValue(BRF153.getR36_plusten_onetothreeyear() == null ? 0 :
				                	BRF153.getR36_plusten_onetothreeyear().intValue());
				            }
				          
				            Cell R35cell8 = row35.getCell(11);
				            if (R35cell8 != null) {
				                R35cell8.setCellValue(BRF153.getR36_minusten_onetothreeyear() == null ? 0 :
				                	BRF153.getR36_minusten_onetothreeyear().intValue());
				            } 
				            
				            Cell R35cell9 = row35.getCell(12);
				            if (R35cell9 != null) {
				                R35cell9.setCellValue(BRF153.getR36_plusten_threeyear() == null ? 0 :
				                	BRF153.getR36_plusten_threeyear().intValue());
				            } 
				            
				            Cell R35cell10 = row35.getCell(13);
				            if (R35cell10 != null) {
				                R35cell10.setCellValue(BRF153.getR36_minusten_threeyear() == null ? 0 :
				                	BRF153.getR36_minusten_threeyear().intValue());
				            }
				            
				            
				            ///////////////////////////////////R37/////////////////////////////
				            
				            Row row36 = sheet.getRow(52);
				            Cell R36cell = row36.getCell(3);
				            if (R36cell != null) {
				                R36cell.setCellValue(BRF153.getR37_notational_amount() == null ? 0 :
				                	BRF153.getR37_notational_amount().intValue());
				            }
				            Cell R36cell1 = row36.getCell(4);
				            if (R36cell1 != null) {
				                R36cell1.setCellValue(BRF153.getR37_gross_market() == null ? 0 :
				                	BRF153.getR37_gross_market().intValue());
				            }
				            Cell R36cell2 = row36.getCell(5);
				            if (R36cell2 != null) {
				                R36cell2.setCellValue(BRF153.getR37_lessthan_oneyear() == null ? 0 :
				                	BRF153.getR37_lessthan_oneyear().intValue());
				            }

				            
				            Cell R36cell3 = row36.getCell(6);
				            if (R36cell3 != null) {
				                R36cell3.setCellValue(BRF153.getR37_onetothree_year() == null ? 0 :
				                	BRF153.getR37_onetothree_year().intValue());
				            }
				            
				            Cell R36cell4 = row36.getCell(7);
				            if (R36cell4 != null) {
				                R36cell4.setCellValue(BRF153.getR37_morethan_threeyear() == null ? 0 :
				                	BRF153.getR37_morethan_threeyear().intValue());
				            }
				            
				            Cell R36cell5 = row36.getCell(8);
				            if (R36cell5 != null) {
				                R36cell5.setCellValue(BRF153.getR37_plusten_oneyear() == null ? 0 :
				                	BRF153.getR37_plusten_oneyear().intValue());
				            }
				            
				            Cell R36cell6 = row36.getCell(9);
				            if (R36cell6 != null) {
				                R36cell6.setCellValue(BRF153.getR37_minusten_oneyear() == null ? 0 :
				                	BRF153.getR37_minusten_oneyear().intValue());
				            }
				            
				            Cell R36cell7 = row36.getCell(10);
				            if (R36cell7 != null) {
				                R36cell7.setCellValue(BRF153.getR37_plusten_onetothreeyear() == null ? 0 :
				                	BRF153.getR37_plusten_onetothreeyear().intValue());
				            }
				          
				            Cell R36cell8 = row36.getCell(11);
				            if (R36cell8 != null) {
				                R36cell8.setCellValue(BRF153.getR37_minusten_onetothreeyear() == null ? 0 :
				                	BRF153.getR37_minusten_onetothreeyear().intValue());
				            } 
				            
				            Cell R36cell9 = row36.getCell(12);
				            if (R36cell9 != null) {
				                R36cell9.setCellValue(BRF153.getR37_plusten_threeyear() == null ? 0 :
				                	BRF153.getR37_plusten_threeyear().intValue());
				            } 
				            
				            Cell R36cell10 = row36.getCell(13);
				            if (R36cell10 != null) {
				                R36cell10.setCellValue(BRF153.getR37_minusten_threeyear() == null ? 0 :
				                	BRF153.getR37_minusten_threeyear().intValue());
				            }
				            
				            
				            //////////////////////////R38/////////////////////////////
				            
				            Row row37 = sheet.getRow(53);
				            Cell R37cell = row37.getCell(3);
				            if (R37cell != null) {
				                R37cell.setCellValue(BRF153.getR38_notational_amount() == null ? 0 :
				                	BRF153.getR38_notational_amount().intValue());
				            }
				            Cell R37cell1 = row37.getCell(4);
				            if (R37cell1 != null) {
				                R37cell1.setCellValue(BRF153.getR38_gross_market() == null ? 0 :
				                	BRF153.getR38_gross_market().intValue());
				            }
				            Cell R37cell2 = row37.getCell(5);
				            if (R37cell2 != null) {
				                R37cell2.setCellValue(BRF153.getR38_lessthan_oneyear() == null ? 0 :
				                	BRF153.getR38_lessthan_oneyear().intValue());
				            }

				            
				            Cell R37cell3 = row37.getCell(6);
				            if (R37cell3 != null) {
				                R37cell3.setCellValue(BRF153.getR38_onetothree_year() == null ? 0 :
				                	BRF153.getR38_onetothree_year().intValue());
				            }
				            
				            Cell R37cell4 = row37.getCell(7);
				            if (R37cell4 != null) {
				                R37cell4.setCellValue(BRF153.getR38_morethan_threeyear() == null ? 0 :
				                	BRF153.getR38_morethan_threeyear().intValue());
				            }
				            
				            Cell R37cell5 = row37.getCell(8);
				            if (R37cell5 != null) {
				                R37cell5.setCellValue(BRF153.getR38_plusten_oneyear() == null ? 0 :
				                	BRF153.getR38_plusten_oneyear().intValue());
				            }
				            
				            Cell R37cell6 = row37.getCell(9);
				            if (R37cell6 != null) {
				                R37cell6.setCellValue(BRF153.getR38_minusten_oneyear() == null ? 0 :
				                	BRF153.getR38_minusten_oneyear().intValue());
				            }
				            
				            Cell R37cell7 = row37.getCell(10);
				            if (R37cell7 != null) {
				                R37cell7.setCellValue(BRF153.getR38_plusten_onetothreeyear() == null ? 0 :
				                	BRF153.getR38_plusten_onetothreeyear().intValue());
				            }
				          
				            Cell R37cell8 = row37.getCell(11);
				            if (R37cell8 != null) {
				                R37cell8.setCellValue(BRF153.getR38_minusten_onetothreeyear() == null ? 0 :
				                	BRF153.getR38_minusten_onetothreeyear().intValue());
				            } 
				            
				            Cell R37cell9 = row37.getCell(12);
				            if (R37cell9 != null) {
				                R37cell9.setCellValue(BRF153.getR38_plusten_threeyear() == null ? 0 :
				                	BRF153.getR38_plusten_threeyear().intValue());
				            } 
				            
				            Cell R37cell10 = row37.getCell(13);
				            if (R37cell10 != null) {
				                R37cell10.setCellValue(BRF153.getR38_minusten_threeyear() == null ? 0 :
				                	BRF153.getR38_minusten_threeyear().intValue());
				            }
				            
				            
				            /////////////////////////////R39//////////////////////////////
				          
				            Row row38 = sheet.getRow(54);
				            Cell R38cell = row38.getCell(3);
				            if (R38cell != null) {
				                R38cell.setCellValue(BRF153.getR39_notational_amount() == null ? 0 :
				                	BRF153.getR39_notational_amount().intValue());
				            }
				            Cell R38cell1 = row38.getCell(4);
				            if (R38cell1 != null) {
				                R38cell1.setCellValue(BRF153.getR39_gross_market() == null ? 0 :
				                	BRF153.getR39_gross_market().intValue());
				            }
				            Cell R38cell2 = row38.getCell(5);
				            if (R38cell2 != null) {
				                R38cell2.setCellValue(BRF153.getR39_lessthan_oneyear() == null ? 0 :
				                	BRF153.getR39_lessthan_oneyear().intValue());
				            }

				            
				            Cell R38cell3 = row38.getCell(6);
				            if (R38cell3 != null) {
				                R38cell3.setCellValue(BRF153.getR39_onetothree_year() == null ? 0 :
				                	BRF153.getR39_onetothree_year().intValue());
				            }
				            
				            Cell R38cell4 = row38.getCell(7);
				            if (R38cell4 != null) {
				                R38cell4.setCellValue(BRF153.getR39_morethan_threeyear() == null ? 0 :
				                	BRF153.getR39_morethan_threeyear().intValue());
				            }
				            
				            Cell R38cell5 = row38.getCell(8);
				            if (R38cell5 != null) {
				                R38cell5.setCellValue(BRF153.getR39_plusten_oneyear() == null ? 0 :
				                	BRF153.getR39_plusten_oneyear().intValue());
				            }
				            
				            Cell R38cell6 = row38.getCell(9);
				            if (R38cell6 != null) {
				                R38cell6.setCellValue(BRF153.getR39_minusten_oneyear() == null ? 0 :
				                	BRF153.getR39_minusten_oneyear().intValue());
				            }
				            
				            Cell R38cell7 = row38.getCell(10);
				            if (R38cell7 != null) {
				                R38cell7.setCellValue(BRF153.getR39_plusten_onetothreeyear() == null ? 0 :
				                	BRF153.getR39_plusten_onetothreeyear().intValue());
				            }
				          
				            Cell R38cell8 = row38.getCell(11);
				            if (R38cell8 != null) {
				                R38cell8.setCellValue(BRF153.getR39_minusten_onetothreeyear() == null ? 0 :
				                	BRF153.getR39_minusten_onetothreeyear().intValue());
				            } 
				            
				            Cell R38cell9 = row38.getCell(12);
				            if (R38cell9 != null) {
				                R38cell9.setCellValue(BRF153.getR39_plusten_threeyear() == null ? 0 :
				                	BRF153.getR39_plusten_threeyear().intValue());
				            } 
				            
				            Cell R38cell10 = row38.getCell(13);
				            if (R38cell10 != null) {
				                R38cell10.setCellValue(BRF153.getR39_minusten_threeyear() == null ? 0 :
				                	BRF153.getR39_minusten_threeyear().intValue());
				            }
				            
				            
				            /////////////////////////////R40//////////////////////////////
					          
		
				            Row row39 = sheet.getRow(57);
				            Cell R39cell = row39.getCell(3);
				            if (R39cell != null) {
				                R39cell.setCellValue(BRF153.getR40_notational_amount() == null ? 0 :
				                	BRF153.getR40_notational_amount().intValue());
				            }
				            Cell R39cell1 = row39.getCell(4);
				            if (R39cell1 != null) {
				                R39cell1.setCellValue(BRF153.getR40_gross_market() == null ? 0 :
				                	BRF153.getR40_gross_market().intValue());
				            }
				            Cell R39cell2 = row39.getCell(5);
				            if (R39cell2 != null) {
				                R39cell2.setCellValue(BRF153.getR40_lessthan_oneyear() == null ? 0 :
				                	BRF153.getR40_lessthan_oneyear().intValue());
				            }

				            
				            Cell R39cell3 = row39.getCell(6);
				            if (R39cell3 != null) {
				                R39cell3.setCellValue(BRF153.getR40_onetothree_year() == null ? 0 :
				                	BRF153.getR40_onetothree_year().intValue());
				            }
				            
				            Cell R39cell4 = row39.getCell(7);
				            if (R39cell4 != null) {
				                R39cell4.setCellValue(BRF153.getR40_morethan_threeyear() == null ? 0 :
				                	BRF153.getR40_morethan_threeyear().intValue());
				            }
				            
				            Cell R39cell5 = row39.getCell(8);
				            if (R39cell5 != null) {
				                R39cell5.setCellValue(BRF153.getR40_plusten_oneyear() == null ? 0 :
				                	BRF153.getR40_plusten_oneyear().intValue());
				            }
				            
				            Cell R39cell6 = row39.getCell(9);
				            if (R39cell6 != null) {
				                R39cell6.setCellValue(BRF153.getR40_minusten_oneyear() == null ? 0 :
				                	BRF153.getR40_minusten_oneyear().intValue());
				            }
				            
				            Cell R39cell7 = row39.getCell(10);
				            if (R39cell7 != null) {
				                R39cell7.setCellValue(BRF153.getR40_plusten_onetothreeyear() == null ? 0 :
				                	BRF153.getR40_plusten_onetothreeyear().intValue());
				            }
				          
				            Cell R39cell8 = row39.getCell(11);
				            if (R39cell8 != null) {
				                R39cell8.setCellValue(BRF153.getR40_minusten_onetothreeyear() == null ? 0 :
				                	BRF153.getR40_minusten_onetothreeyear().intValue());
				            } 
				            
				            Cell R39cell9 = row39.getCell(12);
				            if (R39cell9 != null) {
				                R39cell9.setCellValue(BRF153.getR40_plusten_threeyear() == null ? 0 :
				                	BRF153.getR40_plusten_threeyear().intValue());
				            } 
				            
				            Cell R39cell10 = row39.getCell(13);
				            if (R39cell10 != null) {
				                R39cell10.setCellValue(BRF153.getR40_minusten_threeyear() == null ? 0 :
				                	BRF153.getR40_minusten_threeyear().intValue());
				            }
				            
				            
				            //////////////////////R41////////////////////////////
				            
				            Row row40 = sheet.getRow(58);
				            Cell R40cell = row40.getCell(3);
				            if (R40cell != null) {
				                R40cell.setCellValue(BRF153.getR41_notational_amount() == null ? 0 :
				                	BRF153.getR41_notational_amount().intValue());
				            }
				            Cell R40cell1 = row40.getCell(4);
				            if (R40cell1 != null) {
				                R40cell1.setCellValue(BRF153.getR41_gross_market() == null ? 0 :
				                	BRF153.getR41_gross_market().intValue());
				            }
				            Cell R40cell2 = row40.getCell(5);
				            if (R40cell2 != null) {
				                R40cell2.setCellValue(BRF153.getR41_lessthan_oneyear() == null ? 0 :
				                	BRF153.getR41_lessthan_oneyear().intValue());
				            }

				            
				            Cell R40cell3 = row40.getCell(6);
				            if (R40cell3 != null) {
				                R40cell3.setCellValue(BRF153.getR41_onetothree_year() == null ? 0 :
				                	BRF153.getR41_onetothree_year().intValue());
				            }
				            
				            Cell R40cell4 = row40.getCell(7);
				            if (R40cell4 != null) {
				                R40cell4.setCellValue(BRF153.getR41_morethan_threeyear() == null ? 0 :
				                	BRF153.getR41_morethan_threeyear().intValue());
				            }
				            
				            Cell R40cell5 = row40.getCell(8);
				            if (R40cell5 != null) {
				                R40cell5.setCellValue(BRF153.getR41_plusten_oneyear() == null ? 0 :
				                	BRF153.getR41_plusten_oneyear().intValue());
				            }
				            
				            Cell R40cell6 = row40.getCell(9);
				            if (R40cell6 != null) {
				                R40cell6.setCellValue(BRF153.getR41_minusten_oneyear() == null ? 0 :
				                	BRF153.getR41_minusten_oneyear().intValue());
				            }
				            
				            Cell R40cell7 = row40.getCell(10);
				            if (R40cell7 != null) {
				                R40cell7.setCellValue(BRF153.getR41_plusten_onetothreeyear() == null ? 0 :
				                	BRF153.getR41_plusten_onetothreeyear().intValue());
				            }
				          
				            Cell R40cell8 = row40.getCell(11);
				            if (R40cell8 != null) {
				                R40cell8.setCellValue(BRF153.getR41_minusten_onetothreeyear() == null ? 0 :
				                	BRF153.getR41_minusten_onetothreeyear().intValue());
				            } 
				            
				            Cell R40cell9 = row40.getCell(12);
				            if (R40cell9 != null) {
				                R40cell9.setCellValue(BRF153.getR41_plusten_threeyear() == null ? 0 :
				                	BRF153.getR41_plusten_threeyear().intValue());
				            } 
				            
				            Cell R40cell10 = row40.getCell(13);
				            if (R40cell10 != null) {
				                R40cell10.setCellValue(BRF153.getR41_minusten_threeyear() == null ? 0 :
				                	BRF153.getR41_minusten_threeyear().intValue());
				            }
				            
				            
				            //////////////////R42/////////////////////////////
				            
				            
				            Row row41 = sheet.getRow(59);
				            Cell R41cell = row41.getCell(3);
				            if (R41cell != null) {
				                R41cell.setCellValue(BRF153.getR42_notational_amount() == null ? 0 :
				                	BRF153.getR42_notational_amount().intValue());
				            }
				            Cell R41cell1 = row41.getCell(4);
				            if (R41cell1 != null) {
				                R41cell1.setCellValue(BRF153.getR42_gross_market() == null ? 0 :
				                	BRF153.getR42_gross_market().intValue());
				            }
				            Cell R41cell2 = row41.getCell(5);
				            if (R41cell2 != null) {
				                R41cell2.setCellValue(BRF153.getR42_lessthan_oneyear() == null ? 0 :
				                	BRF153.getR42_lessthan_oneyear().intValue());
				            }

				            
				            Cell R41cell3 = row41.getCell(6);
				            if (R41cell3 != null) {
				                R41cell3.setCellValue(BRF153.getR42_onetothree_year() == null ? 0 :
				                	BRF153.getR42_onetothree_year().intValue());
				            }
				            
				            Cell R41cell4 = row41.getCell(7);
				            if (R41cell4 != null) {
				                R41cell4.setCellValue(BRF153.getR42_morethan_threeyear() == null ? 0 :
				                	BRF153.getR42_morethan_threeyear().intValue());
				            }
				            
				            Cell R41cell5 = row41.getCell(8);
				            if (R41cell5 != null) {
				                R41cell5.setCellValue(BRF153.getR42_plusten_oneyear() == null ? 0 :
				                	BRF153.getR42_plusten_oneyear().intValue());
				            }
				            
				            Cell R41cell6 = row41.getCell(9);
				            if (R41cell6 != null) {
				                R41cell6.setCellValue(BRF153.getR42_minusten_oneyear() == null ? 0 :
				                	BRF153.getR42_minusten_oneyear().intValue());
				            }
				            
				            Cell R41cell7 = row41.getCell(10);
				            if (R41cell7 != null) {
				                R41cell7.setCellValue(BRF153.getR42_plusten_onetothreeyear() == null ? 0 :
				                	BRF153.getR42_plusten_onetothreeyear().intValue());
				            }
				          
				            Cell R41cell8 = row41.getCell(11);
				            if (R41cell8 != null) {
				                R41cell8.setCellValue(BRF153.getR42_minusten_onetothreeyear() == null ? 0 :
				                	BRF153.getR42_minusten_onetothreeyear().intValue());
				            } 
				            
				            Cell R41cell9 = row41.getCell(12);
				            if (R41cell9 != null) {
				                R41cell9.setCellValue(BRF153.getR42_plusten_threeyear() == null ? 0 :
				                	BRF153.getR42_plusten_threeyear().intValue());
				            } 
				            
				            Cell R41cell10 = row41.getCell(13);
				            if (R41cell10 != null) {
				                R41cell10.setCellValue(BRF153.getR42_minusten_threeyear() == null ? 0 :
				                	BRF153.getR42_minusten_threeyear().intValue());
				            }
				            
				            
				            ///////////////////////R43////////////////////
				            
				            Row row42 = sheet.getRow(60);
				            Cell R42cell = row42.getCell(3);
				            if (R42cell != null) {
				                R42cell.setCellValue(BRF153.getR43_notational_amount() == null ? 0 :
				                	BRF153.getR43_notational_amount().intValue());
				            }
				            Cell R42cell1 = row42.getCell(4);
				            if (R42cell1 != null) {
				                R42cell1.setCellValue(BRF153.getR43_gross_market() == null ? 0 :
				                	BRF153.getR43_gross_market().intValue());
				            }
				            Cell R42cell2 = row42.getCell(5);
				            if (R42cell2 != null) {
				                R42cell2.setCellValue(BRF153.getR43_lessthan_oneyear() == null ? 0 :
				                	BRF153.getR43_lessthan_oneyear().intValue());
				            }

				            
				            Cell R42cell3 = row42.getCell(6);
				            if (R42cell3 != null) {
				                R42cell3.setCellValue(BRF153.getR43_onetothree_year() == null ? 0 :
				                	BRF153.getR43_onetothree_year().intValue());
				            }
				            
				            Cell R42cell4 = row42.getCell(7);
				            if (R42cell4 != null) {
				                R42cell4.setCellValue(BRF153.getR43_morethan_threeyear() == null ? 0 :
				                	BRF153.getR43_morethan_threeyear().intValue());
				            }
				            
				            Cell R42cell5 = row42.getCell(8);
				            if (R42cell5 != null) {
				                R42cell5.setCellValue(BRF153.getR43_plusten_oneyear() == null ? 0 :
				                	BRF153.getR43_plusten_oneyear().intValue());
				            }
				            
				            Cell R42cell6 = row42.getCell(9);
				            if (R42cell6 != null) {
				                R42cell6.setCellValue(BRF153.getR43_minusten_oneyear() == null ? 0 :
				                	BRF153.getR43_minusten_oneyear().intValue());
				            }
				            
				            Cell R42cell7 = row42.getCell(10);
				            if (R42cell7 != null) {
				                R42cell7.setCellValue(BRF153.getR43_plusten_onetothreeyear() == null ? 0 :
				                	BRF153.getR43_plusten_onetothreeyear().intValue());
				            }
				          
				            Cell R42cell8 = row42.getCell(11);
				            if (R42cell8 != null) {
				                R42cell8.setCellValue(BRF153.getR43_minusten_onetothreeyear() == null ? 0 :
				                	BRF153.getR43_minusten_onetothreeyear().intValue());
				            } 
				            
				            Cell R42cell9 = row42.getCell(12);
				            if (R42cell9 != null) {
				                R42cell9.setCellValue(BRF153.getR43_plusten_threeyear() == null ? 0 :
				                	BRF153.getR43_plusten_threeyear().intValue());
				            } 
				            
				            Cell R42cell10 = row42.getCell(13);
				            if (R42cell10 != null) {
				                R42cell10.setCellValue(BRF153.getR43_minusten_threeyear() == null ? 0 :
				                	BRF153.getR43_minusten_threeyear().intValue());
				            }
				            
				            
				            ////////////////////R44///////////////////////////////
				            
				            Row row43 = sheet.getRow(61);
				            Cell R43cell = row43.getCell(3);
				            if (R43cell != null) {
				                R43cell.setCellValue(BRF153.getR44_notational_amount() == null ? 0 :
				                	BRF153.getR44_notational_amount().intValue());
				            }
				            Cell R43cell1 = row43.getCell(4);
				            if (R43cell1 != null) {
				                R43cell1.setCellValue(BRF153.getR44_gross_market() == null ? 0 :
				                	BRF153.getR44_gross_market().intValue());
				            }
				            Cell R43cell2 = row43.getCell(5);
				            if (R43cell2 != null) {
				                R43cell2.setCellValue(BRF153.getR44_lessthan_oneyear() == null ? 0 :
				                	BRF153.getR44_lessthan_oneyear().intValue());
				            }

				            
				            Cell R43cell3 = row43.getCell(6);
				            if (R43cell3 != null) {
				                R43cell3.setCellValue(BRF153.getR44_onetothree_year() == null ? 0 :
				                	BRF153.getR44_onetothree_year().intValue());
				            }
				            
				            Cell R43cell4 = row43.getCell(7);
				            if (R43cell4 != null) {
				                R43cell4.setCellValue(BRF153.getR44_morethan_threeyear() == null ? 0 :
				                	BRF153.getR44_morethan_threeyear().intValue());
				            }
				            
				            Cell R43cell5 = row43.getCell(8);
				            if (R43cell5 != null) {
				                R43cell5.setCellValue(BRF153.getR44_plusten_oneyear() == null ? 0 :
				                	BRF153.getR44_plusten_oneyear().intValue());
				            }
				            
				            Cell R43cell6 = row43.getCell(9);
				            if (R43cell6 != null) {
				                R43cell6.setCellValue(BRF153.getR44_minusten_oneyear() == null ? 0 :
				                	BRF153.getR44_minusten_oneyear().intValue());
				            }
				            
				            Cell R43cell7 = row43.getCell(10);
				            if (R43cell7 != null) {
				                R43cell7.setCellValue(BRF153.getR44_plusten_onetothreeyear() == null ? 0 :
				                	BRF153.getR44_plusten_onetothreeyear().intValue());
				            }
				          
				            Cell R43cell8 = row43.getCell(11);
				            if (R43cell8 != null) {
				                R43cell8.setCellValue(BRF153.getR44_minusten_onetothreeyear() == null ? 0 :
				                	BRF153.getR44_minusten_onetothreeyear().intValue());
				            } 
				            
				            Cell R43cell9 = row43.getCell(12);
				            if (R43cell9 != null) {
				                R43cell9.setCellValue(BRF153.getR44_plusten_threeyear() == null ? 0 :
				                	BRF153.getR44_plusten_threeyear().intValue());
				            } 
				            
				            Cell R43cell10 = row43.getCell(13);
				            if (R43cell10 != null) {
				                R43cell10.setCellValue(BRF153.getR44_minusten_threeyear() == null ? 0 :
				                	BRF153.getR44_minusten_threeyear().intValue());
				            }
				            
				            
				            /////////////////////////R45///////////////////////////
				            
				            
				            Row row44 = sheet.getRow(62);
				            Cell R44cell = row44.getCell(3);
				            if (R44cell != null) {
				                R44cell.setCellValue(BRF153.getR45_notational_amount() == null ? 0 :
				                	BRF153.getR45_notational_amount().intValue());
				            }
				            Cell R44cell1 = row44.getCell(4);
				            if (R44cell1 != null) {
				                R44cell1.setCellValue(BRF153.getR45_gross_market() == null ? 0 :
				                	BRF153.getR45_gross_market().intValue());
				            }
				            Cell R44cell2 = row44.getCell(5);
				            if (R44cell2 != null) {
				                R44cell2.setCellValue(BRF153.getR45_lessthan_oneyear() == null ? 0 :
				                	BRF153.getR45_lessthan_oneyear().intValue());
				            }

				            
				            Cell R44cell3 = row44.getCell(6);
				            if (R44cell3 != null) {
				                R44cell3.setCellValue(BRF153.getR45_onetothree_year() == null ? 0 :
				                	BRF153.getR45_onetothree_year().intValue());
				            }
				            
				            Cell R44cell4 = row44.getCell(7);
				            if (R44cell4 != null) {
				                R44cell4.setCellValue(BRF153.getR45_morethan_threeyear() == null ? 0 :
				                	BRF153.getR45_morethan_threeyear().intValue());
				            }
				            
				            Cell R44cell5 = row44.getCell(8);
				            if (R44cell5 != null) {
				                R44cell5.setCellValue(BRF153.getR45_plusten_oneyear() == null ? 0 :
				                	BRF153.getR45_plusten_oneyear().intValue());
				            }
				            
				            Cell R44cell6 = row44.getCell(9);
				            if (R44cell6 != null) {
				                R44cell6.setCellValue(BRF153.getR45_minusten_oneyear() == null ? 0 :
				                	BRF153.getR45_minusten_oneyear().intValue());
				            }
				            
				            Cell R44cell7 = row44.getCell(10);
				            if (R44cell7 != null) {
				                R44cell7.setCellValue(BRF153.getR45_plusten_onetothreeyear() == null ? 0 :
				                	BRF153.getR45_plusten_onetothreeyear().intValue());
				            }
				          
				            Cell R44cell8 = row44.getCell(11);
				            if (R44cell8 != null) {
				                R44cell8.setCellValue(BRF153.getR45_minusten_onetothreeyear() == null ? 0 :
				                	BRF153.getR45_minusten_onetothreeyear().intValue());
				            } 
				            
				            Cell R44cell9 = row44.getCell(12);
				            if (R44cell9 != null) {
				                R44cell9.setCellValue(BRF153.getR45_plusten_threeyear() == null ? 0 :
				                	BRF153.getR45_plusten_threeyear().intValue());
				            } 
				            
				            Cell R44cell10 = row44.getCell(13);
				            if (R44cell10 != null) {
				                R44cell10.setCellValue(BRF153.getR45_minusten_threeyear() == null ? 0 :
				                	BRF153.getR45_minusten_threeyear().intValue());
				            }
				            
				            
				            ////////////////////////////R46////////////////////////
				            
				            Row row45 = sheet.getRow(63);
				            Cell R45cell = row45.getCell(3);
				            if (R45cell != null) {
				                R45cell.setCellValue(BRF153.getR46_notational_amount() == null ? 0 :
				                	BRF153.getR46_notational_amount().intValue());
				            }
				            Cell R45cell1 = row45.getCell(4);
				            if (R45cell1 != null) {
				                R45cell1.setCellValue(BRF153.getR46_gross_market() == null ? 0 :
				                	BRF153.getR46_gross_market().intValue());
				            }
				            Cell R45cell2 = row45.getCell(5);
				            if (R45cell2 != null) {
				                R45cell2.setCellValue(BRF153.getR46_lessthan_oneyear() == null ? 0 :
				                	BRF153.getR46_lessthan_oneyear().intValue());
				            }

				            
				            Cell R45cell3 = row45.getCell(6);
				            if (R45cell3 != null) {
				                R45cell3.setCellValue(BRF153.getR46_onetothree_year() == null ? 0 :
				                	BRF153.getR46_onetothree_year().intValue());
				            }
				            
				            Cell R45cell4 = row45.getCell(7);
				            if (R45cell4 != null) {
				                R45cell4.setCellValue(BRF153.getR46_morethan_threeyear() == null ? 0 :
				                	BRF153.getR46_morethan_threeyear().intValue());
				            }
				            
				            Cell R45cell5 = row45.getCell(8);
				            if (R45cell5 != null) {
				                R45cell5.setCellValue(BRF153.getR46_plusten_oneyear() == null ? 0 :
				                	BRF153.getR46_plusten_oneyear().intValue());
				            }
				            
				            Cell R45cell6 = row45.getCell(9);
				            if (R45cell6 != null) {
				                R45cell6.setCellValue(BRF153.getR46_minusten_oneyear() == null ? 0 :
				                	BRF153.getR46_minusten_oneyear().intValue());
				            }
				            
				            Cell R45cell7 = row45.getCell(10);
				            if (R45cell7 != null) {
				                R45cell7.setCellValue(BRF153.getR46_plusten_onetothreeyear() == null ? 0 :
				                	BRF153.getR46_plusten_onetothreeyear().intValue());
				            }
				          
				            Cell R45cell8 = row45.getCell(11);
				            if (R45cell8 != null) {
				                R45cell8.setCellValue(BRF153.getR46_minusten_onetothreeyear() == null ? 0 :
				                	BRF153.getR46_minusten_onetothreeyear().intValue());
				            } 
				            
				            Cell R45cell9 = row45.getCell(12);
				            if (R45cell9 != null) {
				                R45cell9.setCellValue(BRF153.getR46_plusten_threeyear() == null ? 0 :
				                	BRF153.getR46_plusten_threeyear().intValue());
				            } 
				            
				            Cell R45cell10 = row45.getCell(13);
				            if (R45cell10 != null) {
				                R45cell10.setCellValue(BRF153.getR46_minusten_threeyear() == null ? 0 :
				                	BRF153.getR46_minusten_threeyear().intValue());
				            }
				            
				            
				            ///////////////////////////R47////////////////////////
				            
				            Row row46 = sheet.getRow(64);
				            Cell R46cell = row46.getCell(3);
				            if (R46cell != null) {
				                R46cell.setCellValue(BRF153.getR47_notational_amount() == null ? 0 :
				                	BRF153.getR47_notational_amount().intValue());
				            }
				            Cell R46cell1 = row46.getCell(4);
				            if (R46cell1 != null) {
				                R46cell1.setCellValue(BRF153.getR47_gross_market() == null ? 0 :
				                	BRF153.getR47_gross_market().intValue());
				            }
				            Cell R46cell2 = row46.getCell(5);
				            if (R46cell2 != null) {
				                R46cell2.setCellValue(BRF153.getR47_lessthan_oneyear() == null ? 0 :
				                	BRF153.getR47_lessthan_oneyear().intValue());
				            }

				            
				            Cell R46cell3 = row46.getCell(6);
				            if (R46cell3 != null) {
				                R46cell3.setCellValue(BRF153.getR47_onetothree_year() == null ? 0 :
				                	BRF153.getR47_onetothree_year().intValue());
				            }
				            
				            Cell R46cell4 = row46.getCell(7);
				            if (R46cell4 != null) {
				                R46cell4.setCellValue(BRF153.getR47_morethan_threeyear() == null ? 0 :
				                	BRF153.getR47_morethan_threeyear().intValue());
				            }
				            
				            Cell R46cell5 = row46.getCell(8);
				            if (R46cell5 != null) {
				                R46cell5.setCellValue(BRF153.getR47_plusten_oneyear() == null ? 0 :
				                	BRF153.getR47_plusten_oneyear().intValue());
				            }
				            
				            Cell R46cell6 = row46.getCell(9);
				            if (R46cell6 != null) {
				                R46cell6.setCellValue(BRF153.getR47_minusten_oneyear() == null ? 0 :
				                	BRF153.getR47_minusten_oneyear().intValue());
				            }
				            
				            Cell R46cell7 = row46.getCell(10);
				            if (R46cell7 != null) {
				                R46cell7.setCellValue(BRF153.getR47_plusten_onetothreeyear() == null ? 0 :
				                	BRF153.getR47_plusten_onetothreeyear().intValue());
				            }
				          
				            Cell R46cell8 = row46.getCell(11);
				            if (R46cell8 != null) {
				                R46cell8.setCellValue(BRF153.getR47_minusten_onetothreeyear() == null ? 0 :
				                	BRF153.getR47_minusten_onetothreeyear().intValue());
				            } 
				            
				            Cell R46cell9 = row46.getCell(12);
				            if (R46cell9 != null) {
				                R46cell9.setCellValue(BRF153.getR47_plusten_threeyear() == null ? 0 :
				                	BRF153.getR47_plusten_threeyear().intValue());
				            } 
				            
				            Cell R46cell10 = row46.getCell(13);
				            if (R46cell10 != null) {
				                R46cell10.setCellValue(BRF153.getR47_minusten_threeyear() == null ? 0 :
				                	BRF153.getR47_minusten_threeyear().intValue());
				            }
				            
				            
				            /////////////////////R48/////////////////////////
				            
				            Row row47 = sheet.getRow(65);
				            Cell R47cell = row47.getCell(3);
				            if (R47cell != null) {
				                R47cell.setCellValue(BRF153.getR48_notational_amount() == null ? 0 :
				                	BRF153.getR48_notational_amount().intValue());
				            }
				            Cell R47cell1 = row47.getCell(4);
				            if (R47cell1 != null) {
				                R47cell1.setCellValue(BRF153.getR48_gross_market() == null ? 0 :
				                	BRF153.getR48_gross_market().intValue());
				            }
				            Cell R47cell2 = row47.getCell(5);
				            if (R47cell2 != null) {
				                R47cell2.setCellValue(BRF153.getR48_lessthan_oneyear() == null ? 0 :
				                	BRF153.getR48_lessthan_oneyear().intValue());
				            }

				            
				            Cell R47cell3 = row47.getCell(6);
				            if (R47cell3 != null) {
				                R47cell3.setCellValue(BRF153.getR48_onetothree_year() == null ? 0 :
				                	BRF153.getR48_onetothree_year().intValue());
				            }
				            
				            Cell R47cell4 = row47.getCell(7);
				            if (R47cell4 != null) {
				                R47cell4.setCellValue(BRF153.getR48_morethan_threeyear() == null ? 0 :
				                	BRF153.getR48_morethan_threeyear().intValue());
				            }
				            
				            Cell R47cell5 = row47.getCell(8);
				            if (R47cell5 != null) {
				                R47cell5.setCellValue(BRF153.getR48_plusten_oneyear() == null ? 0 :
				                	BRF153.getR48_plusten_oneyear().intValue());
				            }
				            
				            Cell R47cell6 = row47.getCell(9);
				            if (R47cell6 != null) {
				                R47cell6.setCellValue(BRF153.getR48_minusten_oneyear() == null ? 0 :
				                	BRF153.getR48_minusten_oneyear().intValue());
				            }
				            
				            Cell R47cell7 = row47.getCell(10);
				            if (R47cell7 != null) {
				                R47cell7.setCellValue(BRF153.getR48_plusten_onetothreeyear() == null ? 0 :
				                	BRF153.getR48_plusten_onetothreeyear().intValue());
				            }
				          
				            Cell R47cell8 = row47.getCell(11);
				            if (R47cell8 != null) {
				                R47cell8.setCellValue(BRF153.getR48_minusten_onetothreeyear() == null ? 0 :
				                	BRF153.getR48_minusten_onetothreeyear().intValue());
				            } 
				            
				            Cell R47cell9 = row47.getCell(12);
				            if (R47cell9 != null) {
				                R47cell9.setCellValue(BRF153.getR48_plusten_threeyear() == null ? 0 :
				                	BRF153.getR48_plusten_threeyear().intValue());
				            } 
				            
				            Cell R47cell10 = row47.getCell(13);
				            if (R47cell10 != null) {
				                R47cell10.setCellValue(BRF153.getR48_minusten_threeyear() == null ? 0 :
				                	BRF153.getR48_minusten_threeyear().intValue());
				            }
				            
				            
				       
				            
				            // Save the changes
				            workbook.getCreationHelper().createFormulaEvaluator().evaluateAll();
				            FileOutputStream fileOut = new FileOutputStream(env.getProperty("output.exportpathfinal")+"011-BRF-153-A.xls");
				            workbook.write(fileOut);
				            fileOut.close();
				            System.out.println(fileOut);
				            path= fileOut.toString();
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
					outputFile = new File(env.getProperty("output.exportpathfinal")+"011-BRF-153-A.xls");

					return outputFile;
				
				
				
				}
	
	
	public String detailChanges153(BRF153_DETAIL_ENTITY detail, String foracid, String report_addl_criteria_1,
			BigDecimal act_balance_amt_lc, BigDecimal amt_ac,String report_label_1, String report_name_1) {

		String msg = "";

		try {

			Session hs = sessionFactory.getCurrentSession();
			Optional<BRF153_DETAIL_ENTITY> Brf153detail = brf153_detailrepo.findById(foracid);

			if (Brf153detail.isPresent()) {
				BRF153_DETAIL_ENTITY BRFdetail = Brf153detail.get();

				if (BRFdetail.getReport_label_1().equals(report_label_1)
						&& BRFdetail.getReport_name_1().equals(report_name_1)
						&& BRFdetail.getAct_balance_amt_lc().equals(act_balance_amt_lc)
						&& BRFdetail.getAmt_ac().equals(amt_ac)
						&& BRFdetail.getReport_addl_criteria_1().equals(report_addl_criteria_1)

				) {
					msg = "No modification done";
				} else {

					BRFdetail.setAct_balance_amt_lc(act_balance_amt_lc);
					BRFdetail.setAmt_ac(amt_ac);
					BRFdetail.setReport_label_1(report_label_1);
					BRFdetail.setReport_name_1(report_name_1);
					BRFdetail.setReport_addl_criteria_1(report_addl_criteria_1);
					brf153_detailrepo.save(BRFdetail);

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
			
public ModelAndView getArchieveBRF0153View(String reportId, String fromdate, String todate, String currency,
		String dtltype, Pageable pageable) {

	ModelAndView mv = new ModelAndView();
	Session hs = sessionFactory.getCurrentSession();
	int pageSize = pageable.getPageSize();
	int currentPage = pageable.getPageNumber();
	int startItem = currentPage * pageSize;
	List<BRF153ReportEntity> T1rep = new ArrayList<BRF153ReportEntity>();
	// Query<Object[]> qr;

	List<BRF153ReportEntity> T1Master = new ArrayList<BRF153ReportEntity>();
	/* List<BRF73_TABLE2> T1Master1 = new ArrayList<BRF73_TABLE2>(); */

	logger.info("Inside archive" + currency);

	try {
		Date d1 = df.parse(todate);
		// T1rep = t1CurProdServiceRepo.getT1CurProdServices(d1);

		T1Master = hs.createQuery("from  BRF153ReportEntity a where a.report_date = ?1 ", BRF153ReportEntity.class)
				.setParameter(1, df.parse(todate)).getResultList();

		/*
		 * T1Master1 = hs.createQuery("from BRF73_TABLE2 a where a.report_date = ?1 ",
		 * BRF73_TABLE2.class) .setParameter(1, df.parse(todate)).getResultList();
		 */

	} catch (ParseException e) {
		e.printStackTrace();
	}

	// T1rep = t1CurProdServiceRepo.getT1CurProdServices(d1);

	mv.setViewName("RR/BRF153ARCH");
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


  public ModelAndView ARCHgetBRF153currentDtl(String reportId, String
  fromdate, String todate, String currency, String dtltype, Pageable pageable,
  String filter) throws ParseException {
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
				
				
					qr = hs.createNativeQuery("select * from BRF153_ARCHIVTABLE a where report_date=?1 and report_label=?2");
					qr.setParameter(1,  df.parse(todate));
					qr.setParameter(2,filter);
						

			} else {
				System.out.println("2");
				qr = hs.createNativeQuery("select * from BRF153_ARCHIVTABLE");

			}
		} else {
			System.out.println("3");
			qr = hs.createNativeQuery("select * from BRF153_ARCHIVTABLE  where report_date = ?1");
		}

		List<BRF153_ARCHIV_ENTITY> T1Master = new ArrayList<BRF153_ARCHIV_ENTITY>();

		try {
			System.out.println("Values entered");
			T1Master = hs.createQuery("from BRF153_ARCHIV_ENTITY a where a.report_date = ?1", BRF153_ARCHIV_ENTITY.class)
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
			BigDecimal amt_ac = (BigDecimal) a[5];
			String acct_crncy_code = (String) a[6];
			String gl_code = (String) a[7];
			String gl_sub_head_code = (String) a[8];
			String gl_sub_head_desc = (String) a[9];
			String country_of_incorp = (String) a[10];
			String cust_type = (String) a[11];
			String schm_code = (String) a[12];
			String schm_type = (String) a[13];
			String sol_id = (String) a[14];
			String acid = (String) a[15];
			String segment = (String) a[16];
			String sub_segment = (String) a[17];
			BigDecimal sector = (BigDecimal) a[18];
			String sub_sector = (String) a[19];
			String sector_code = (String) a[20];
			String group_id = (String) a[21];
			String constitution_code = (String) a[22];
			String country = (String) a[23];
			String legal_entity_type = (String) a[24];
			String constitution_desc = (String) a[25];
			String purpose_of_advn = (String) a[26];
			BigDecimal hni_networth = (BigDecimal) a[27];
			String turnover = (String) a[28];
			String bacid = (String) a[29];
			String report_name_1 = (String) a[30];
			String report_label_1 = (String) a[31];
			String report_addl_criteria_1 = (String) a[32];
			String report_addl_criteria_2 = (String) a[33];
			String report_addl_criteria_3 = (String) a[34];
			String create_user = (String) a[35];
			Date create_time = (Date) a[36];
			String modify_user = (String) a[37];
			Date modify_time = (Date) a[38];
			String verify_user = (String) a[39];
			Date verify_time = (Date) a[40];
			String entity_flg = (String) a[41];
			String modify_flg = (String) a[42];
			String del_flg = (String) a[43];
			String nre_status = (String) a[44];
			Date report_date = (Date) a[45];
			String maturity_date = (String) a[46];
			String gender = (String) a[47];
			String version = (String) a[48];
			String remarks = (String) a[49];
			

			BRF153_ARCHIV_ENTITY py = new BRF153_ARCHIV_ENTITY( cust_id,  foracid,  acct_name,  eab_lc,
					 act_balance_amt_lc,  acct_crncy_code,  gl_code,  gl_sub_head_code,
					 gl_sub_head_desc,  country_of_incorp,  cust_type,  schm_code,  schm_type,
					 sol_id,  acid,  segment,  sub_segment,  sector,  sub_sector,
					 sector_code,  group_id,  constitution_code,  country,  legal_entity_type,
					 constitution_desc,  purpose_of_advn,  hni_networth,  turnover,  bacid,
					 report_name_1,  report_label_1,  report_addl_criteria_1,  report_addl_criteria_2,
					 report_addl_criteria_3,  create_user,  create_time,  modify_user,  modify_time,
					 verify_user,  verify_time,  entity_flg,  modify_flg,  del_flg,
					 nre_status,  report_date,  maturity_date,  version,  gender,  remarks); 

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
  
  logger.info("Converting to Page"); Page<Object> T1Dt1Page = new
  PageImpl<Object>(pagedlist, PageRequest.of(currentPage, pageSize),
  T1Dt1.size());
  
  mv.setViewName("RR" + "/" + "BRF153ARCH::reportcontent");
  mv.addObject("reportdetails", T1Dt1Page.getContent());
  mv.addObject("reportmaster", T1Master); mv.addObject("reportmaster1", qr);
  mv.addObject("singledetail", new T1CurProdDetail());
  mv.addObject("reportsflag", "reportsflag"); mv.addObject("menu", reportId);
  return mv; }
 

}





