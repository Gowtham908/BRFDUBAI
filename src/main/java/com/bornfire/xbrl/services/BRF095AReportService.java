
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

import com.bornfire.xbrl.entities.BRF95_ARCHIV_ENTITY;
import com.bornfire.xbrl.entities.BRBS.BRF093AServiceRepo;
import com.bornfire.xbrl.entities.BRBS.BRF094AServiceRepo;
import com.bornfire.xbrl.entities.BRBS.BRF095AServiceRepo;
import com.bornfire.xbrl.entities.BRBS.BRF102AServiceRepo;
import com.bornfire.xbrl.entities.BRBS.BRF32reportentity;
import com.bornfire.xbrl.entities.BRBS.BRF64_Entity;
import com.bornfire.xbrl.entities.BRBS.BRF73ServiceRepo;
import com.bornfire.xbrl.entities.BRBS.BRF92_DetailRepo;
import com.bornfire.xbrl.entities.BRBS.BRF95_DETAIL_ENTITY;
import com.bornfire.xbrl.entities.BRBS.BRF95_DetailRepo;
import com.bornfire.xbrl.entities.BRBS.BRF96AServiceRepo;

import com.bornfire.xbrl.entities.BRBS.BRF_095_A_REPORT_ENTITY;
import com.bornfire.xbrl.entities.BRBS.BRF_96_REPORT_ENTITY;
import com.bornfire.xbrl.entities.BRBS.RBSTransactionMasterEntity;
import com.bornfire.xbrl.entities.BRBS.T1CurProdDetail;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.export.ooxml.JRXlsxExporter;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;

@Service
@Transactional
@ConfigurationProperties("output")
public class BRF095AReportService {
	private static final Logger logger = LoggerFactory.getLogger(BRF095AReportService.class);

	@Autowired
	SessionFactory sessionFactory;

	@Autowired
	DataSource srcdataSource;
	
	@Autowired
	Environment env;
	
	@Autowired
	BRF73ServiceRepo brf73ServiceRepo;
	
	@Autowired
	BRF093AServiceRepo brf093aServiceRepo;
	
	@Autowired
	BRF094AServiceRepo brf094aServiceRepo;
	
	@Autowired
	BRF96AServiceRepo brf96aServiceRepo;
	
	@Autowired
	BRF095AServiceRepo brf095aServiceRepo;
	
	@Autowired
	BRF102AServiceRepo brf102aServiceRepo;
	
	@Autowired 
	 BRF95_DetailRepo brf95_detailrepo;
	DateFormat df = new SimpleDateFormat("dd-MMM-yyyy");


	public String preCheckBRF095A(String reportid, String fromdate, String todate) {
		
			String msg = "";
			Session hs = sessionFactory.getCurrentSession();
			Date dt1;
			Date dt9;
			logger.info("Report precheck : " + reportid);

			try {
				dt1 = new SimpleDateFormat("dd/MM/yyyy").parse(fromdate);
				dt9 = new SimpleDateFormat("dd/MM/yyyy").parse(todate);
				logger.info("Getting No of records in Master table :" + reportid);
				Long dtlcnt = (Long) hs.createQuery("select count(*) from BRF_095_A_REPORT_ENTITY a where a.report_date=?1")
						.setParameter(1, dt9).getSingleResult();

				if (dtlcnt > 0) {
					logger.info("Getting No of records in Mod table :" + reportid);
					Long modcnt = (Long) hs.createQuery("select count(*) from BRF_095_A_REPORT_ENTITY a ").getSingleResult();
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


	public ModelAndView getBRF095AView(String reportId, String fromdate, String todate, String currency, String dtltype,
			Pageable pageable) {

		ModelAndView mv = new ModelAndView();

		Session hs = sessionFactory.getCurrentSession();
		int pageSize = pageable.getPageSize();
		int currentPage = pageable.getPageNumber();
		int startItem = currentPage * pageSize;
		List<BRF_095_A_REPORT_ENTITY> T1rep = new ArrayList<BRF_095_A_REPORT_ENTITY>();
		// Query<Object[]> qr;

		List<BRF_095_A_REPORT_ENTITY> T1Master = new ArrayList<BRF_095_A_REPORT_ENTITY>();

		logger.info("Inside archive" +currency);

		try {
			
			
			Date d1 = df.parse(todate);
		//	T1rep = t1CurProdServiceRepo.getT1CurProdServices(d1);

			T1Master = hs.createQuery("from BRF_095_A_REPORT_ENTITY a where a.report_date = ?1 ", BRF_095_A_REPORT_ENTITY.class)
					.setParameter(1, df.parse(todate)).getResultList();

		} catch (ParseException e) {
			e.printStackTrace();
		}

		// T1rep = t1CurProdServiceRepo.getT1CurProdServices(d1);

		mv.setViewName("RR/BRF095A");
		// mv.addObject("currlist", refCodeConfig.currList());
		mv.addObject("reportsummary", T1Master);
		mv.addObject("reportmaster", T1Master);
		mv.addObject("displaymode", "summary");
		mv.addObject("reportsflag", "reportsflag");
		mv.addObject("menu", reportId);
		System.out.println("scv" + mv.getViewName());

		return mv;

	}
	public ModelAndView getBRF095ADetails(String reportId, String fromdate, String todate, String currency,
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
                qr = hs.createNativeQuery("select * from BRF95_DETAILTABLE");
                //qr.setParameter(2, filter);
            } else {
                qr = hs.createNativeQuery("select * from BRF95_DETAILTABLE");
            }
        } else {
            qr = hs.createNativeQuery("select * from BRF95_DETAILTABLE  where report_date = ?1");
        }
        List<BRF95_DETAIL_ENTITY> T1Master = new ArrayList<BRF95_DETAIL_ENTITY>();
 
        try {
            T1Master = hs.createQuery("from BRF95_DETAIL_ENTITY a where a.report_date = ?1", BRF95_DETAIL_ENTITY.class)
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
			

			BRF95_DETAIL_ENTITY py = new BRF95_DETAIL_ENTITY(cust_id, foracid,acct_name, eab_lc, act_balance_amt_lc,  acct_crncy_code, gl_code,
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

		mv.setViewName("RR"+"/"+"BRF095A::reportcontent");
		// mv.setViewName("ReportT1");
		mv.addObject("reportdetails", T1Dt1Page);
		mv.addObject("reportmaster", T1Master);
		mv.addObject("singledetail", new T1CurProdDetail());
		mv.addObject("reportsflag", "reportsflag");
		mv.addObject("menu", reportId);
		return mv;
	}
	

	
	public File getFileBRF095A(String reportId, String fromdate, String todate, String currency, String dtltype,
			String filetype) throws FileNotFoundException, JRException, SQLException {

		
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

		String path = this.env.getProperty("output.exportpath");
		String fileName = "";
		String zipFileName = "";
		File outputFile;

		logger.info("Getting Output file :" + reportId);
		fileName = "011-BRF-095-A" ;
					if (!filetype.equals("xbrl")) {
						if (!filetype.equals("BRF")) {

			try {
				InputStream jasperFile;
				logger.info("Getting Jasper file :" + reportId);
				if (filetype.equals("detailexcel")) {
					if (dtltype.equals("report")) {

						jasperFile = this.getClass().getResourceAsStream("/static/jasper/BRF95_Detail.jrxml");
					} else {
						jasperFile = this.getClass().getResourceAsStream("/static/jasper/BRF95_Detail.jrxml");
					}
				} else {
					if (dtltype.equals("report")) {
						logger.info("Inside report");
						jasperFile = this.getClass().getResourceAsStream("/static/jasper/BRF95.jrxml");
					} else {
						jasperFile = this.getClass().getResourceAsStream("/static/jasper/BRF95.jrxml");
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
				
				List<BRF_095_A_REPORT_ENTITY> T1Master = new ArrayList<BRF_095_A_REPORT_ENTITY>();
				Session hs = sessionFactory.getCurrentSession();
				try {
					Date d1 = df.parse(todate);
				
				// T1rep = t1CurProdServiceRepo.getT1CurProdServices(d1);

				T1Master = hs.createQuery("from  BRF_095_A_REPORT_ENTITY a where a.report_date = ?1 ", BRF_095_A_REPORT_ENTITY.class)
						.setParameter(1, df.parse(todate)).getResultList();
				
				if(T1Master.size() == 1) {
					
					for(BRF_095_A_REPORT_ENTITY BRF95 : T1Master ) {
				
				File Responsecamt = new File(env.getProperty("output.exportpathtemp")+"011-BRF-095-AT.xls");
				
				  // Load the Excel file
	        	Workbook workbook = WorkbookFactory.create(Responsecamt);

	            // Get the first sheet
	            Sheet sheet = workbook.getSheetAt(0);
	           
	            Row row = sheet.getRow(13);
	            Cell cell = row.getCell(4);

	            if (cell != null) {
	            cell.setCellValue(BRF95.getR7_RATIOS1() == null ? 0 :
	            BRF95.getR7_RATIOS1().intValue());
	            }

	            ////////////////R8//////////////////////

	            Row row1 = sheet.getRow(14);
	            Cell R1cell = row1.getCell(4);
	            if (R1cell != null) {
	            R1cell.setCellValue(BRF95.getR8_RATIOS1() == null ? 0 :
	            BRF95.getR8_RATIOS1().intValue());
	            }


	            ///////////////////R9/////////////////////////

	            Row row2 = sheet.getRow(17);
	            Cell R2cell = row2.getCell(4);
	            if (R2cell != null) {
	            R2cell.setCellValue(BRF95.getR9_RATIOS1() == null ? 0 :
	            BRF95.getR9_RATIOS1().intValue());
	            }

	            ///////////////////R15/////////////////////////

	            Row row3 = sheet.getRow(25);
	            Cell R3cell1 = row3.getCell(8);
	            if (R3cell1 != null) {
	            R3cell1.setCellValue(BRF95.getR15_RATIOS2() == null ? 0 :
	            BRF95.getR15_RATIOS2().intValue());
	            }


	            ///////////////////R16/////////////////////////

	            Row row4 = sheet.getRow(26);
	            Cell R4cell = row4.getCell(4);
	            if (R4cell != null) {
	            R4cell.setCellValue(BRF95.getR16_RATIOS1() == null ? 0 :
	            BRF95.getR16_RATIOS1().intValue());
	            }

	            Cell R4cell1 = row4.getCell(8);
	            if (R4cell1 != null) {
	            R4cell1.setCellValue(BRF95.getR16_RATIOS2() == null ? 0 :
	            BRF95.getR16_RATIOS2().intValue());
	            }


	            /////////////////R17//////////////////////////

	            Row row5 = sheet.getRow(27);
	            Cell R5cell = row5.getCell(4);
	            if (R5cell != null) {
	            R5cell.setCellValue(BRF95.getR17_RATIOS1() == null ? 0 :
	            BRF95.getR17_RATIOS1().intValue());
	            }

	            Cell R5cell1 = row5.getCell(8);
	            if (R5cell1 != null) {
	            R5cell1.setCellValue(BRF95.getR17_RATIOS2() == null ? 0 :
	            BRF95.getR17_RATIOS2().intValue());
	            }


	            /////////////////R18//////////////////////////

	            Row row6 = sheet.getRow(28);
	            Cell R6cell = row6.getCell(8);
	            if (R6cell != null) {
	            R6cell.setCellValue(BRF95.getR18_RATIOS2() == null ? 0 :
	            BRF95.getR18_RATIOS2().intValue());
	            }


	            /////////////////R19//////////////////////////

	            Row row7 = sheet.getRow(29);
	            Cell R7cell = row7.getCell(4);
	            if (R7cell != null) {
	            R7cell.setCellValue(BRF95.getR19_RATIOS1() == null ? 0 :
	            BRF95.getR19_RATIOS1().intValue());
	            }

	            Cell R7cell1 = row7.getCell(8);
	            if (R7cell1 != null) {
	            R7cell1.setCellValue(BRF95.getR19_RATIOS2() == null ? 0 :
	            BRF95.getR19_RATIOS2().intValue());
	            } 




	            /////////////////R20//////////////////////////

	            Row row8 = sheet.getRow(30);
	            Cell R8cell = row8.getCell(4);
	            if (R8cell != null) {
	            R8cell.setCellValue(BRF95.getR20_RATIOS1() == null ? 0 :
	            BRF95.getR20_RATIOS1().intValue());
	            }

	            Cell R8cell1 = row8.getCell(8);
	            if (R8cell1 != null) {
	            R8cell1.setCellValue(BRF95.getR20_RATIOS2() == null ? 0 :
	            BRF95.getR20_RATIOS2().intValue());
	            }



	            /////////////////R21//////////////////////////

	            Row row9 = sheet.getRow(31);
	            Cell R9cell = row9.getCell(4);
	            if (R9cell != null) {
	            R9cell.setCellValue(BRF95.getR21_RATIOS1() == null ? 0 :
	            BRF95.getR21_RATIOS1().intValue());
	            }

	            /////////////////R22//////////////////////////

	            Row row10 = sheet.getRow(32);
	            Cell R10cell = row10.getCell(4);
	            if (R10cell != null) {
	            R10cell.setCellValue(BRF95.getR22_RATIOS1() == null ? 0 :
	            BRF95.getR22_RATIOS1().intValue());
	            }

	            /////////////////R24//////////////////////////

	            Row row11 = sheet.getRow(34);
	            Cell R11cell = row11.getCell(4);
	            if (R11cell != null) {
	            R11cell.setCellValue(BRF95.getR24_RATIOS1() == null ? 0 :
	            BRF95.getR24_RATIOS1().intValue());
	            }

	            Cell R11cell1 = row11.getCell(8);
	            if (R11cell1 != null) {
	            R11cell1.setCellValue(BRF95.getR24_RATIOS2() == null ? 0 :
	            BRF95.getR24_RATIOS2().intValue());
	            }

	            /////////////////R25//////////////////////////

	            Row row12 = sheet.getRow(35);
	            Cell R12cell = row12.getCell(4);
	            if (R12cell != null) {
	            R12cell.setCellValue(BRF95.getR25_RATIOS1() == null ? 0 :
	            BRF95.getR25_RATIOS1().intValue());
	            }

	            /////////////////R26//////////////////////////

	            Row row13 = sheet.getRow(36);
	            Cell R13cell = row13.getCell(4);
	            if (R13cell != null) {
	            R13cell.setCellValue(BRF95.getR26_RATIOS1() == null ? 0 :
	            BRF95.getR26_RATIOS1().intValue());
	            }

	            Cell R13cell1 = row13.getCell(8);
	            if (R13cell1 != null) {
	            R13cell1.setCellValue(BRF95.getR26_RATIOS2() == null ? 0 :
	            BRF95.getR26_RATIOS2().intValue());
	            }
	            
	            /////////////////R27//////////////////////////

	            Row row14 = sheet.getRow(37);
	            Cell R14cell = row14.getCell(4);
	            if (R14cell != null) {
	            R14cell.setCellValue(BRF95.getR27_RATIOS1() == null ? 0 :
	            BRF95.getR27_RATIOS1().intValue());
	            }

	            Cell R14cell1 = row14.getCell(8);
	            if (R14cell1 != null) {
	            R14cell1.setCellValue(BRF95.getR27_RATIOS2() == null ? 0 :
	            BRF95.getR27_RATIOS2().intValue());
	            }
	            /////////////////R28//////////////////////////

	            Row row15 = sheet.getRow(38);
	            Cell R15cell = row15.getCell(5);
	            if (R15cell != null) {
	            R15cell.setCellValue(BRF95.getR28_RATIOS1() == null ? 0 :
	            BRF95.getR28_RATIOS1().intValue());
	            }
	            
	            Cell R15cell1 = row15.getCell(8);
	            if (R15cell1 != null) {
	            R15cell1.setCellValue(BRF95.getR28_RATIOS2() == null ? 0 :
	            BRF95.getR28_RATIOS2().intValue());
	            }

	            /////////////////R29//////////////////////////

	            Row row16 = sheet.getRow(39);
	            Cell R16cell = row16.getCell(5);
	            if (R16cell != null) {
	            R16cell.setCellValue(BRF95.getR29_RATIOS1() == null ? 0 :
	            BRF95.getR29_RATIOS1().intValue());
	            }

	            Cell R16cell1 = row16.getCell(8);
	            if (R16cell1 != null) {
	            R16cell1.setCellValue(BRF95.getR29_RATIOS2() == null ? 0 :
	            BRF95.getR29_RATIOS2().intValue());
	            }
	            
	            /////////////////R30//////////////////////////

	            Row row17 = sheet.getRow(40);
	            Cell R17cell = row17.getCell(4);
	            if (R17cell != null) {
	            R17cell.setCellValue(BRF95.getR30_RATIOS1() == null ? 0 :
	            BRF95.getR30_RATIOS1().intValue());
	            }

	            Cell R17cell1 = row17.getCell(8);
	            if (R17cell1 != null) {
	            R17cell1.setCellValue(BRF95.getR30_RATIOS2() == null ? 0 :
	            BRF95.getR30_RATIOS2().intValue());
	            }
	            /////////////////R31//////////////////////////

	            Row row18 = sheet.getRow(41);
	            Cell R18cell = row18.getCell(4);
	            if (R18cell != null) {
	            R18cell.setCellValue(BRF95.getR31_RATIOS1() == null ? 0 :
	            BRF95.getR31_RATIOS1().intValue());
	            }

	            Cell R18cell1 = row18.getCell(8);
	            if (R18cell1 != null) {
	            R18cell1.setCellValue(BRF95.getR31_RATIOS2() == null ? 0 :
	            BRF95.getR31_RATIOS2().intValue());
	            }
	            /////////////////R34//////////////////////////

	            Row row19 = sheet.getRow(44);
	            Cell R19cell = row19.getCell(4);
	            if (R19cell != null) {
	            R19cell.setCellValue(BRF95.getR34_RATIOS1() == null ? 0 :
	            BRF95.getR34_RATIOS1().intValue());
	            }

	            Cell R19cell1 = row19.getCell(8);
	            if (R19cell1 != null) {
	            R19cell1.setCellValue(BRF95.getR34_RATIOS2() == null ? 0 :
	            BRF95.getR34_RATIOS2().intValue());
	            }
	            
	            /////////////////R35//////////////////////////

	            Row row20 = sheet.getRow(45);
	            Cell R20cell = row20.getCell(4);
	            if (R20cell != null) {
	            R20cell.setCellValue(BRF95.getR35_RATIOS1() == null ? 0 :
	            BRF95.getR35_RATIOS1().intValue());
	            }
	            
	            Cell R20cell1 = row20.getCell(8);
	            if (R20cell1 != null) {
	            R20cell1.setCellValue(BRF95.getR35_RATIOS2() == null ? 0 :
	            BRF95.getR35_RATIOS2().intValue());
	            }

	            /////////////////R36//////////////////////////

	            Row row21 = sheet.getRow(46);
	            Cell R21cell = row21.getCell(4);
	            if (R21cell != null) {
	            R21cell.setCellValue(BRF95.getR36_RATIOS1() == null ? 0 :
	            BRF95.getR36_RATIOS1().intValue());
	            }

	            Cell R21cell1 = row21.getCell(8);
	            if (R21cell1 != null) {
	            R21cell1.setCellValue(BRF95.getR36_RATIOS2() == null ? 0 :
	            BRF95.getR36_RATIOS2().intValue());
	            }

	            /////////////////R37//////////////////////////

	            Row row22 = sheet.getRow(47);
	            Cell R22cell = row22.getCell(4);
	            if (R22cell != null) {
	            R22cell.setCellValue(BRF95.getR37_RATIOS1() == null ? 0 :
	            BRF95.getR37_RATIOS1().intValue());
	            }

	            Cell R22cell1 = row22.getCell(8);
	            if (R22cell1 != null) {
	            R22cell1.setCellValue(BRF95.getR37_RATIOS2() == null ? 0 :
	            BRF95.getR37_RATIOS2().intValue());
	            }
	            
	            /////////////////R38//////////////////////////

	            Row row23 = sheet.getRow(48);
	            Cell R23cell = row23.getCell(4);
	            if (R23cell != null) {
	            R23cell.setCellValue(BRF95.getR38_RATIOS1() == null ? 0 :
	            BRF95.getR38_RATIOS1().intValue());
	            }

	            Cell R23cell1 = row23.getCell(8);
	            if (R23cell1 != null) {
	            R23cell1.setCellValue(BRF95.getR38_RATIOS2() == null ? 0 :
	            BRF95.getR38_RATIOS2().intValue());
	            }
	            
	            /////////////////R39//////////////////////////

	            Row row24 = sheet.getRow(49);
	            Cell R24cell = row24.getCell(4);
	            if (R24cell != null) {
	            R24cell.setCellValue(BRF95.getR39_RATIOS1() == null ? 0 :
	            BRF95.getR39_RATIOS1().intValue());
	            }

	            Cell R24cell1 = row24.getCell(8);
	            if (R24cell1 != null) {
	            R24cell1.setCellValue(BRF95.getR39_RATIOS2() == null ? 0 :
	            BRF95.getR39_RATIOS2().intValue());
	            }
	            /////////////////R40//////////////////////////

	            Row row25 = sheet.getRow(50);
	            Cell R25cell = row25.getCell(4);
	            if (R25cell != null) {
	            R25cell.setCellValue(BRF95.getR40_RATIOS1() == null ? 0 :
	            BRF95.getR40_RATIOS1().intValue());
	            }

	            Cell R25cell1 = row25.getCell(8);
	            if (R25cell1 != null) {
	            R25cell1.setCellValue(BRF95.getR40_RATIOS2() == null ? 0 :
	            BRF95.getR40_RATIOS2().intValue());
	            }
	            
	            
	          ///////////////////////////R41////////////// 
	            Row row46 = sheet.getRow(51);
	            Cell R46cell1 = row46.getCell(8);
	            if (R46cell1 != null) {
	            R46cell1.setCellValue(BRF95.getR41_RATIOS2() == null ? 0 :
	            BRF95.getR41_RATIOS2().intValue());
	            }
	            
	            
	            /////////////////R42//////////////////////////

	            Row row26 = sheet.getRow(52);
	            Cell R26cell = row26.getCell(4);
	            if (R26cell != null) {
	            R26cell.setCellValue(BRF95.getR42_RATIOS1() == null ? 0 :
	            BRF95.getR42_RATIOS1().intValue());
	            }

	            
	            Cell R26cell1 = row26.getCell(8);
	            if (R26cell1 != null) {
	            R26cell1.setCellValue(BRF95.getR42_RATIOS2() == null ? 0 :
	            BRF95.getR42_RATIOS2().intValue());
	            }
	            
	            /////////////////R43//////////////////////////

	            Row row27 = sheet.getRow(53);
	            Cell R27cell = row27.getCell(4);
	            if (R27cell != null) {
	            R27cell.setCellValue(BRF95.getR43_RATIOS1() == null ? 0 :
	            BRF95.getR43_RATIOS1().intValue());
	            }

	            Cell R27cell1 = row27.getCell(8);
	            if (R27cell1 != null) {
	            R27cell1.setCellValue(BRF95.getR43_RATIOS2() == null ? 0 :
	            BRF95.getR43_RATIOS2().intValue());
	            }

	            /////////////////R44//////////////////////////

	            Row row28 = sheet.getRow(54);
	            Cell R28cell = row28.getCell(4);
	            if (R28cell != null) {
	            R28cell.setCellValue(BRF95.getR44_RATIOS1() == null ? 0 :
	            BRF95.getR44_RATIOS1().intValue());
	            }

	            Cell R28cell1 = row28.getCell(8);
	            if (R28cell1 != null) {
	            R28cell1.setCellValue(BRF95.getR44_RATIOS2() == null ? 0 :
	            BRF95.getR44_RATIOS2().intValue());
	            }
	            
	            ///////////////////////////R46////////////// 
	            Row row47 = sheet.getRow(56);
	            Cell R47cell1 = row47.getCell(8);
	            if (R47cell1 != null) {
	            R47cell1.setCellValue(BRF95.getR46_RATIOS2() == null ? 0 :
	            BRF95.getR46_RATIOS2().intValue());
	            }
	            
	            /////////////////R47//////////////////////////

	            Row row29 = sheet.getRow(57);
	            Cell R29cell = row29.getCell(4);
	            if (R29cell != null) {
	            R29cell.setCellValue(BRF95.getR47_RATIOS1() == null ? 0 :
	            BRF95.getR47_RATIOS1().intValue());
	            }
	            
	            Cell R29cell1 = row29.getCell(8);
	            if (R29cell1 != null) {
	            R29cell1.setCellValue(BRF95.getR47_RATIOS2() == null ? 0 :
	            BRF95.getR47_RATIOS2().intValue());
	            }

	            /////////////////R48//////////////////////////

	            Row row30 = sheet.getRow(58);
	            Cell R30cell = row30.getCell(4);
	            if (R30cell != null) {
	            R30cell.setCellValue(BRF95.getR48_RATIOS1() == null ? 0 :
	            BRF95.getR48_RATIOS1().intValue());
	            }
	            
	            Cell R30cell1 = row30.getCell(8);
	            if (R30cell1 != null) {
	            R30cell1.setCellValue(BRF95.getR48_RATIOS2() == null ? 0 :
	            BRF95.getR48_RATIOS2().intValue());
	            }

	            /////////////////R49//////////////////////////

	            Row row31 = sheet.getRow(59);
	            Cell R31cell = row31.getCell(4);
	            if (R31cell != null) {
	            R31cell.setCellValue(BRF95.getR49_RATIOS1() == null ? 0 :
	            BRF95.getR49_RATIOS1().intValue());
	            }


	            Cell R31cell1 = row31.getCell(8);
	            if (R31cell1 != null) {
	            R31cell1.setCellValue(BRF95.getR49_RATIOS2() == null ? 0 :
	            BRF95.getR49_RATIOS2().intValue());
	            }
	            
				///////////////////////////R50////////////// 
				      Row row48 = sheet.getRow(60);
				      Cell R48cell1 = row48.getCell(8);
				      if (R48cell1 != null) {
				      R48cell1.setCellValue(BRF95.getR50_RATIOS2() == null ? 0 :
				      BRF95.getR50_RATIOS2().intValue());
				      }
	            
      
      /////////////////R52//////////////////////////

	            Row row32 = sheet.getRow(62);
	            Cell R32cell = row32.getCell(4);
	            if (R32cell != null) {
	            R32cell.setCellValue(BRF95.getR52_RATIOS1() == null ? 0 :
	            BRF95.getR52_RATIOS1().intValue());
	            }
	            
	            Cell R32cell1 = row32.getCell(8);
	            if (R32cell1 != null) {
	            R32cell1.setCellValue(BRF95.getR52_RATIOS2() == null ? 0 :
	            BRF95.getR52_RATIOS2().intValue());
	            }

	            /////////////////R53//////////////////////////

	            Row row33 = sheet.getRow(63);
	            Cell R33cell = row33.getCell(4);
	            if (R33cell != null) {
	            R33cell.setCellValue(BRF95.getR53_RATIOS1() == null ? 0 :
	            BRF95.getR53_RATIOS1().intValue());
	            }

	            Cell R33cell1 = row33.getCell(8);
	            if (R33cell1 != null) {
	            R33cell1.setCellValue(BRF95.getR53_RATIOS2() == null ? 0 :
	            BRF95.getR53_RATIOS2().intValue());
	            }

	            /////////////////R54//////////////////////////

	            Row row34 = sheet.getRow(64);
	            Cell R34cell = row34.getCell(4);
	            if (R34cell != null) {
	            R34cell.setCellValue(BRF95.getR54_RATIOS1() == null ? 0 :
	            BRF95.getR54_RATIOS1().intValue());
	            }


	           

	            /////////////////R57//////////////////////////

	            Row row36 = sheet.getRow(67);
	            Cell R36cell = row36.getCell(4);
	            if (R36cell != null) {
	            R36cell.setCellValue(BRF95.getR57_RATIOS1() == null ? 0 :
	            BRF95.getR57_RATIOS1().intValue());
	            }


	            Cell R36cell1 = row36.getCell(8);
	            if (R36cell1 != null) {
	            R36cell1.setCellValue(BRF95.getR57_RATIOS2() == null ? 0 :
	            BRF95.getR57_RATIOS2().intValue());
	            }

	            /////////////////R58//////////////////////////

	            Row row37 = sheet.getRow(68);
	            Cell R37cell = row37.getCell(4);
	            if (R37cell != null) {
	            R37cell.setCellValue(BRF95.getR58_RATIOS1() == null ? 0 :
	            BRF95.getR58_RATIOS1().intValue());
	            }


	            Cell R37cell1 = row37.getCell(8);
	            if (R37cell1 != null) {
	            R37cell1.setCellValue(BRF95.getR58_RATIOS2() == null ? 0 :
	            BRF95.getR58_RATIOS2().intValue());
	            }


	           


	            /////////////////R60//////////////////////////

	            Row row39 = sheet.getRow(70);
	            Cell R39cell = row39.getCell(4);
	            if (R39cell != null) {
	            R39cell.setCellValue(BRF95.getR60_RATIOS1() == null ? 0 :
	            BRF95.getR60_RATIOS1().intValue());
	            }


	            Cell R39cell1 = row39.getCell(8);
	            if (R39cell1 != null) {
	            R39cell1.setCellValue(BRF95.getR60_RATIOS2() == null ? 0 :
	            BRF95.getR60_RATIOS2().intValue());
	            }


	            /////////////////R61//////////////////////////

	            Row row40 = sheet.getRow(71);
	            Cell R40cell = row40.getCell(8);
	            if (R40cell != null) {
	            R40cell.setCellValue(BRF95.getR61_RATIOS2() == null ? 0 :
	            BRF95.getR61_RATIOS2().intValue());
	            }


	            /////////////////R62//////////////////////////

	            Row row41 = sheet.getRow(72);
	            Cell R41cell = row41.getCell(8);
	            if (R41cell != null) {
	            R41cell.setCellValue(BRF95.getR62_RATIOS2() == null ? 0 :
	            BRF95.getR62_RATIOS2().intValue());
	            }


	            /////////////////R63//////////////////////////

	            Row row42 = sheet.getRow(73);
	            Cell R42cell = row42.getCell(4);
	            if (R42cell != null) {
	            R42cell.setCellValue(BRF95.getR63_RATIOS1() == null ? 0 :
	            BRF95.getR63_RATIOS1().intValue());
	            }


	            Cell R42cell1 = row42.getCell(8);
	            if (R42cell1 != null) {
	            R42cell1.setCellValue(BRF95.getR63_RATIOS2() == null ? 0 :
	            BRF95.getR63_RATIOS2().intValue());
	            }


	            /////////////////R64//////////////////////////

	            Row row43 = sheet.getRow(73);
	            Cell R43cell = row43.getCell(4);
	            if (R43cell != null) {
	            R43cell.setCellValue(BRF95.getR64_RATIOS1() == null ? 0 :
	            BRF95.getR64_RATIOS1().intValue());
	            }


	            

	            /////////////////R65//////////////////////////

	            Row row44 = sheet.getRow(73);
	            Cell R44cell = row44.getCell(4);
	            if (R44cell != null) {
	            R44cell.setCellValue(BRF95.getR65_RATIOS1() == null ? 0 :
	            BRF95.getR65_RATIOS1().intValue());
	            }


	            Cell R44cell1 = row44.getCell(8);
	            if (R44cell1 != null) {
	            R44cell1.setCellValue(BRF95.getR65_RATIOS2() == null ? 0 :
	            BRF95.getR65_RATIOS2().intValue());
	            }



	            /////////////////R66//////////////////////////

	            Row row45 = sheet.getRow(75);
	            Cell R45cell = row45.getCell(4);
	            if (R45cell != null) {
	            R45cell.setCellValue(BRF95.getR66_RATIOS1() == null ? 0 :
	            BRF95.getR66_RATIOS1().intValue());
	            }



	         
	         
	         
	      // Save the changes
	            workbook.getCreationHelper().createFormulaEvaluator().evaluateAll();
	            FileOutputStream fileOut = new FileOutputStream(env.getProperty("output.exportpathfinal")+"011-BRF-095-A.xls");
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
		outputFile = new File(env.getProperty("output.exportpathfinal")+"011-BRF-095-A.xls");

		return outputFile;
	
	
	
	}
	       	 
	

	
public String detailChanges95(BRF95_DETAIL_ENTITY detail, String foracid, String report_addl_criteria_1,
		BigDecimal act_balance_amt_lc, String report_label_1, String report_name_1) {

	String msg = "";

	try {

		Session hs = sessionFactory.getCurrentSession();
		Optional<BRF95_DETAIL_ENTITY> Brf95detail = brf95_detailrepo.findById(foracid);

		if (Brf95detail.isPresent()) {
			BRF95_DETAIL_ENTITY BRFdetail = Brf95detail.get();

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
				brf95_detailrepo.save(BRFdetail);

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



/**** ARCH SUMMARY
 * @throws ParseException ****/

public ModelAndView getArchieveBRF095View(String reportId, String fromdate, String todate, String currency,
	String dtltype, Pageable pageable) {

ModelAndView mv = new ModelAndView();
Session hs = sessionFactory.getCurrentSession();
int pageSize = pageable.getPageSize();
int currentPage = pageable.getPageNumber();
int startItem = currentPage * pageSize;
List<BRF_095_A_REPORT_ENTITY> T1rep = new ArrayList<BRF_095_A_REPORT_ENTITY>();
// Query<Object[]> qr;

List<BRF_095_A_REPORT_ENTITY> T1Master = new ArrayList<BRF_095_A_REPORT_ENTITY>();
/* List<BRF73_TABLE2> T1Master1 = new ArrayList<BRF73_TABLE2>(); */

logger.info("Inside archive" + currency);

try {
	Date d1 = df.parse(todate);
	// T1rep = t1CurProdServiceRepo.getT1CurProdServices(d1);

	T1Master = hs.createQuery("from  BRF_095_A_REPORT_ENTITY a where a.report_date = ?1 ", BRF_095_A_REPORT_ENTITY.class)
			.setParameter(1, df.parse(todate)).getResultList();

	/*
	 * T1Master1 = hs.createQuery("from BRF73_TABLE2 a where a.report_date = ?1 ",
	 * BRF73_TABLE2.class) .setParameter(1, df.parse(todate)).getResultList();
	 */

} catch (ParseException e) {
	e.printStackTrace();
}

// T1rep = t1CurProdServiceRepo.getT1CurProdServices(d1);

mv.setViewName("RR/BRF95ARCH");
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

public ModelAndView ARCHgetBRF095currentDtl(String reportId, String fromdate, String todate, String currency,
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
		
		
			qr = hs.createNativeQuery("select * from BRF95_ARCHIVTABLE a where report_date=?1 and report_label=?2");
			qr.setParameter(1,  df.parse(todate));
			qr.setParameter(2,filter);
				

	} else {
		System.out.println("2");
		qr = hs.createNativeQuery("select * from BRF95_ARCHIVTABLE");

	}
} else {
	System.out.println("3");
	qr = hs.createNativeQuery("select * from BRF95_ARCHIVTABLE  where report_date = ?1");
}

List<BRF95_ARCHIV_ENTITY> T1Master = new ArrayList<BRF95_ARCHIV_ENTITY>();

try {
	System.out.println("Values entered");
	T1Master = hs.createQuery("from BRF95_ARCHIV_ENTITY a where a.report_date = ?1", BRF95_ARCHIV_ENTITY.class)
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
	

	BRF95_ARCHIV_ENTITY py = new BRF95_ARCHIV_ENTITY(cust_id, foracid,acct_name, eab_lc, act_balance_amt_lc,  acct_crncy_code, gl_code,
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

mv.setViewName("RR" + "/" + "BRF95ARCH::reportcontent");
mv.addObject("reportdetails", T1Dt1Page.getContent());
mv.addObject("reportmaster", T1Master);
mv.addObject("reportmaster1", qr);
mv.addObject("singledetail", new T1CurProdDetail());
mv.addObject("reportsflag", "reportsflag");
mv.addObject("menu", reportId);
return mv;
}

}




			
		

	
	
	



