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

import com.bornfire.xbrl.entities.BRBS.BRF49_Entity;
import com.bornfire.xbrl.entities.BRBS.BRF64_DETAIL_ENTITY;
import com.bornfire.xbrl.entities.BRBS.BRF81_ARCHIVENTITY;
import com.bornfire.xbrl.entities.BRBS.BRF82DetailRep;
import com.bornfire.xbrl.entities.BRBS.BRF81_DETAIL_ENTITY;
import com.bornfire.xbrl.entities.BRBS.BRF81_ENTITY;
import com.bornfire.xbrl.entities.BRBS.BRF82_ARCHIVENTITY;
import com.bornfire.xbrl.entities.BRBS.BRF82_DETAIL_ENTITY;
import com.bornfire.xbrl.entities.BRBS.BRF82_ENTITY;
import com.bornfire.xbrl.entities.BRBS.BRF82_TABLE;
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
public class BRF82ReportService {
	private static final Logger logger = LoggerFactory.getLogger(BRF82ReportService.class);

	@Autowired
	SessionFactory sessionFactory;

	@Autowired
	DataSource srcdataSource;
	
	@Autowired
	Environment env;
	
	@Autowired
	BRF82DetailRep brf82DetailRep;

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
			Long dtlcnt = (Long) hs.createQuery("select count(*) from BRF82_ENTITY a where a.report_date=?1")
					.setParameter(1, dt9).getSingleResult();

			if (dtlcnt > 0) {
				logger.info("Getting No of records in Mod table :" + reportid);
				Long modcnt = (Long) hs.createQuery("select count(*) from BRF82_ENTITY a").getSingleResult();
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
	public ModelAndView getBRF82View(String reportId, String fromdate, String todate, String currency, String dtltype,
			Pageable pageable) {
		
			ModelAndView mv = new ModelAndView();
			Session hs = sessionFactory.getCurrentSession();
			int pageSize = pageable.getPageSize();
			int currentPage = pageable.getPageNumber();
			int startItem = currentPage * pageSize;
			List<BRF82_ENTITY> T1rep = new ArrayList<BRF82_ENTITY>();
			// Query<Object[]> qr;

			List<BRF82_ENTITY> T1Master = new ArrayList<BRF82_ENTITY>();
			/* List<BRF73_TABLE2> T1Master1 = new ArrayList<BRF73_TABLE2>(); */

			logger.info("Inside archive" +currency);

			try {
				Date d1 = df.parse(todate);
			//	T1rep = t1CurProdServiceRepo.getT1CurProdServices(d1);

				T1Master = hs.createQuery("from  BRF82_ENTITY a where a.report_date = ?1 ", BRF82_ENTITY .class)
						.setParameter(1, df.parse(todate)).getResultList();

				/*
				 * T1Master1 = hs.createQuery("from BRF73_TABLE2 a where a.report_date = ?1 ",
				 * BRF73_TABLE2.class) .setParameter(1, df.parse(todate)).getResultList();
				 */

			} catch (ParseException e) {
				e.printStackTrace();
			}

			// T1rep = t1CurProdServiceRepo.getT1CurProdServices(d1);

			mv.setViewName("RR/BRF82");
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
	public ModelAndView getBRF82Details(String reportId, String fromdate, String todate, String currency,
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
				qr = hs.createNativeQuery("select * from BRF82_DETAILTABLE");

				//qr.setParameter(2, filter);

			} else {
				qr = hs.createNativeQuery("select * from BRF82_DETAILTABLE");

			}
		} else {
			qr = hs.createNativeQuery("select * from BRF82_DETAILTABLE  where report_label_1 = ?1");
		}
		List<BRF82_DETAIL_ENTITY> T1Master = new ArrayList<BRF82_DETAIL_ENTITY>();
		 try {
	            T1Master = hs.createQuery("from BRF82_DETAIL_ENTITY a where a.report_date = ?1", BRF82_DETAIL_ENTITY.class)
	                    .setParameter(1, df.parse(todate)).getResultList();
	        } catch (ParseException e) {

	            e.printStackTrace();
	        }

		logger.info("Getting Report Detail for : " + reportId + "," + fromdate + "," + todate + "," + currency);
		List<Object[]> result = qr.getResultList();
		
		for (Object[] a : result) {
			String acct_crncy_code= (String) a[0];
			String acct_name = (String) a[1];
			String acid = (String) a[2];
			String bacid = (String) a[3];
			String constitution_code = (String) a[4];
			String constitution_desc = (String) a[5];
			String country = (String) a[6];
			String country_of_incorp = (String) a[7];
			Date create_time  = (Date) a[8];
			String create_user = (String) a[9];
			String cust_id = (String) a[10];
			String cust_type = (String) a[11];
			String del_flg =(String) a[12];
			String entity_flg = (String) a[13];
			String foracid = (String) a[14];	
			String gender = (String) a[15];
			String gl_code = (String) a[16];
			String gl_sub_head_code = (String) a[17];
			String gl_sub_head_desc = (String) a[18];
			String group_id  = (String) a[19];
			BigDecimal hni_networth  = (BigDecimal) a[20];
			String legal_entity_type  = (String) a[21];
			String maturity_date  = (String) a[22];
			String modify_flg = (String) a[23];
			Date modify_time  = (Date) a[24];
			String modify_user  = (String) a[25];
			String nre_status  = (String) a[26];
			String purpose_of_advn  = (String) a[27];
			String remarks=(String)a[28];
			String report_addl_criteria_1 = (String) a[29];
			String report_addl_criteria_2 = (String) a[30];
			String report_addl_criteria_3 = (String) a[31];	
			Date   report_date= (Date) a[32];
			String report_label_1  = (String) a[33];
			String report_name_1 = (String) a[34];
			String schm_code  = (String) a[35];
			String schm_type  = (String) a[36];
			BigDecimal sector  = (BigDecimal) a[37];
			String sector_code = (String) a[38];
			String segment  = (String) a[39];
			String sol_id  = (String) a[40];
			String sub_sector  = (String) a[41];
			String sub_segment  = (String) a[42];
			String turnover  = (String) a[43];
			String verify_user = (String) a[44];
			Date verify_time = (Date)  a[45];
			String version=(String)a[46];
			BigDecimal act_balance_amt_lc = (BigDecimal) a[47];
			BigDecimal eab_lc  = (BigDecimal) a[48];
			
			
						
			BRF82_DETAIL_ENTITY py = new BRF82_DETAIL_ENTITY(acct_crncy_code, acct_name, acid, bacid,
			        constitution_code, constitution_desc, country, country_of_incorp,
			        create_time, create_user, cust_id, cust_type, del_flg, entity_flg,
			        foracid, gender, gl_code, gl_sub_head_code, gl_sub_head_desc,
			        group_id, hni_networth, legal_entity_type, maturity_date, modify_flg,
			        modify_time, modify_user, nre_status, purpose_of_advn, remarks,
			        report_addl_criteria_1, report_addl_criteria_2, report_addl_criteria_3,
			        report_date, report_label_1, report_name_1, schm_code, schm_type,
			        sector, sector_code, segment, sol_id, sub_sector, sub_segment,
			        turnover, verify_time, verify_user, version, act_balance_amt_lc, eab_lc);
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
		mv.setViewName("RR" + "/" + "BRF82::reportcontent");
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
		fileName = "011-BRF-082-A" ;
					if (!filetype.equals("xbrl")) {
						if(!filetype.equals("BRF")) {

			try {
				InputStream jasperFile;
				logger.info("Getting Jasper file :" + reportId);
				if (filetype.equals("detailexcel")) {
					if (dtltype.equals("report")) {

						jasperFile = this.getClass().getResourceAsStream("/static/jasper/BRF82_Detail.jrxml");
					} else {
						jasperFile = this.getClass().getResourceAsStream("/static/jasper/BRF82_Detail.jrxml");
					}

				} else {
					if (dtltype.equals("report")) {
						logger.info("Inside report");
						jasperFile = this.getClass().getResourceAsStream("/static/jasper/BRF82A.jrxml");
					} else {
						jasperFile = this.getClass().getResourceAsStream("/static/jasper/BRF82A.jrxml");
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
							
							List<BRF82_ENTITY> T1Master = new ArrayList<BRF82_ENTITY>();
							Session hs = sessionFactory.getCurrentSession();
							try {
								Date d1 = df.parse(todate);
							
							// T1rep = t1CurProdServiceRepo.getT1CurProdServices(d1);

							T1Master = hs.createQuery("from  BRF82_ENTITY a where a.report_date = ?1 ", BRF82_ENTITY.class)
									.setParameter(1, df.parse(todate)).getResultList();
							
							if(T1Master.size() == 1) {
								
								for(BRF82_ENTITY BRF82 : T1Master ) {
							
							File Responsecamt = new File(env.getProperty("output.exportpathtemp")+"011-BRF-082-AT.xls");
							
							  // Load the Excel file
				        	Workbook workbook = WorkbookFactory.create(Responsecamt);
				        	
				        	
				        	
				        	 FileOutputStream fileOut = new FileOutputStream(env.getProperty("output.exportpathfinal")+"011-BRF-082-A.xls");
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
						outputFile = new File(env.getProperty("output.exportpathfinal")+"011-BRF-082-A.xls");

						return outputFile;
					
					
					
					}
					
	
	
	public String detailChanges82(BRF82_DETAIL_ENTITY detail, String foracid, String report_addl_criteria_1,
			BigDecimal act_balance_amt_lc, String report_label_1, String report_name_1) {

		String msg = "";

		try {

			Session hs = sessionFactory.getCurrentSession();
			Optional<BRF82_DETAIL_ENTITY> Brf82detail =brf82DetailRep.findById(foracid);

			if (Brf82detail.isPresent()) {
				BRF82_DETAIL_ENTITY BRFdetail = Brf82detail.get();

				if (BRFdetail.getReport_label_1().equals(report_label_1)
						&& BRFdetail.getReport_name_1().equals(report_name_1)
						&& BRFdetail.getAct_balance_amt_lc().equals(act_balance_amt_lc)
						&& BRFdetail.getReport_addl_criteria_1().equals(report_addl_criteria_1)

				) {
					msg = "No modification done";
				} else {

					BRFdetail.setAct_balance_amt_lc(act_balance_amt_lc);
					BRFdetail.setReport_label_1 (report_label_1);
					BRFdetail.setReport_name_1(report_name_1);
					BRFdetail.setReport_addl_criteria_1(report_addl_criteria_1);
					brf82DetailRep.save(BRFdetail);

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
	public ModelAndView getArchieveBRF082View(String reportId, String fromdate, String todate, String currency,
			String dtltype, Pageable pageable) {

		ModelAndView mv = new ModelAndView();
		Session hs = sessionFactory.getCurrentSession();
		int pageSize = pageable.getPageSize();
		int currentPage = pageable.getPageNumber();
		int startItem = currentPage * pageSize;
		List<BRF82_ENTITY> T1rep = new ArrayList<BRF82_ENTITY>();
		// Query<Object[]> qr;

		List<BRF82_ENTITY> T1Master = new ArrayList<BRF82_ENTITY>();
		/* List<BRF73_TABLE2> T1Master1 = new ArrayList<BRF73_TABLE2>(); */

		logger.info("Inside archive" + currency);

		try {
			Date d1 = df.parse(todate);
			// T1rep = t1CurProdServiceRepo.getT1CurProdServices(d1);

			T1Master = hs.createQuery("from BRF82_ENTITY a where a.report_date = ?1 ", BRF82_ENTITY.class)
					.setParameter(1, df.parse(todate)).getResultList();

			/*
			 * T1Master1 = hs.createQuery("from BRF73_TABLE2 a where a.report_date = ?1 ",
			 * BRF73_TABLE2.class) .setParameter(1, df.parse(todate)).getResultList();
			 */

		} catch (ParseException e) {
			e.printStackTrace();
		}

		// T1rep = t1CurProdServiceRepo.getT1CurProdServices(d1);

		mv.setViewName("RR/BRF82ARCH");
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



	public ModelAndView ARCHgetBRF082currentDtl(String reportId, String fromdate, String todate, String currency,
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
				
				
					qr = hs.createNativeQuery("select * from BRF82_ARCHIVTABLE a where report_date=?1 and report_lable=?2");
					qr.setParameter(1,  df.parse(todate));
					qr.setParameter(2,filter);
						

			} else {
				System.out.println("2");
				qr = hs.createNativeQuery("select * from BRF82_ARCHIVTABLE");

			}
		} else {
			System.out.println("3");
			qr = hs.createNativeQuery("select * from BRF82_ARCHIVTABLE  where report_date = ?1");
		}

		List<BRF82_ARCHIVENTITY> T1Master = new ArrayList<BRF82_ARCHIVENTITY>();

		try {
			System.out.println("Values entered");
			T1Master = hs.createQuery("from BRF82_ARCHIVENTITY a where a.report_date = ?1", BRF82_ARCHIVENTITY.class)
					.setParameter(1, df.parse(todate)).getResultList();
		} catch (ParseException e) {

			e.printStackTrace();
		}

		logger.info("Getting Report Detail for : " + reportId + "," + fromdate + "," + todate + "," + currency);
		List<Object[]> result = qr.getResultList();

		for (Object[] a : result) {
			String acct_crncy_code= (String) a[0];
			String acct_name = (String) a[1];
			String acid = (String) a[2];
			String bacid = (String) a[3];
			String constitution_code = (String) a[4];
			String constitution_desc = (String) a[5];
			String country = (String) a[6];
			String country_of_incorp = (String) a[7];
			Date create_time  = (Date) a[8];
			String create_user = (String) a[9];
			String cust_id = (String) a[10];
			String cust_type = (String) a[11];
			String del_flg =(String) a[12];
			String entity_flg = (String) a[13];
			String foracid = (String) a[14];	
			String gender = (String) a[15];
			String gl_code = (String) a[16];
			String gl_sub_head_code = (String) a[17];
			String gl_sub_head_desc = (String) a[18];
			String group_id  = (String) a[19];
			BigDecimal hni_networth  = (BigDecimal) a[20];
			String legal_entity_type  = (String) a[21];
			String maturity_date  = (String) a[22];
			String modify_flg = (String) a[23];
			Date modify_time  = (Date) a[24];
			String modify_user  = (String) a[25];
			String nre_status  = (String) a[26];
			String purpose_of_advn  = (String) a[27];
			String remarks=(String)a[28];
			String report_addl_criteria_1 = (String) a[29];
			String report_addl_criteria_2 = (String) a[30];
			String report_addl_criteria_3 = (String) a[31];	
			Date	report_date= (Date) a[32];
			String report_label_1  = (String) a[33];
			String report_name_1 = (String) a[34];
			String schm_code  = (String) a[35];
			String schm_type  = (String) a[36];
			BigDecimal sector  = (BigDecimal) a[37];
			String sector_code = (String) a[38];
			String segment  = (String) a[39];
			String sol_id  = (String) a[40];
			String sub_sector  = (String) a[41];
			String sub_segment  = (String) a[42];
			String turnover  = (String) a[43];
			String verify_user = (String) a[44];
			Date verify_time = (Date)  a[45];
			String version=(String)a[46];
			BigDecimal act_balance_amt_lc = (BigDecimal) a[47];
			BigDecimal eab_lc  = (BigDecimal) a[48];
					
			
			if (act_balance_amt_lc != null) {
				if (act_balance_amt_lc.toString().contains("-")) {
					remarks = "DR";
				} else {
					remarks = "CR";
				}
			} else {
				remarks = "";
			}

			BRF82_ARCHIVENTITY py = new BRF82_ARCHIVENTITY(acct_crncy_code,  acct_name,  acid,  bacid,
					 constitution_code,  constitution_desc,  country,  country_of_incorp,
					  create_time,  create_user,  cust_id,  cust_type,  del_flg,  entity_flg,
					 foracid,  gender,  gl_code,  gl_sub_head_code,  gl_sub_head_desc,
					 group_id,  hni_networth,  legal_entity_type,  maturity_date,  modify_flg,
					  modify_time,  modify_user,  nre_status,  purpose_of_advn,  remarks,
					 report_addl_criteria_1,  report_addl_criteria_2,  report_addl_criteria_3,
					  report_date,  report_label_1,  report_name_1,  schm_code,  schm_type,
					 sector,  sector_code,  segment,  sol_id,  sub_sector,  sub_segment,
					 turnover,   verify_time,  verify_user,  version,  act_balance_amt_lc,
					 eab_lc);
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

		mv.setViewName("RR" + "/" + "BRF82ARCH::reportcontent");
		mv.addObject("reportdetails", T1Dt1Page.getContent());
		mv.addObject("reportmaster", T1Master);
		mv.addObject("reportmaster1", qr);
		mv.addObject("singledetail", new T1CurProdDetail());
		mv.addObject("reportsflag", "reportsflag");
		mv.addObject("menu", reportId);
		return mv;
	}

	}
