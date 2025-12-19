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
import javax.transaction.Transactional;

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
import org.springframework.web.servlet.ModelAndView;

import com.bornfire.xbrl.entities.BRBS.BRF41_ARCHIVENTITY;
import com.bornfire.xbrl.entities.BRBS.BRF41DetailRepo;
import com.bornfire.xbrl.entities.BRBS.BRF41_DETAILENTITY;
import com.bornfire.xbrl.entities.BRBS.BRF41_Entity1;
import com.bornfire.xbrl.entities.BRBS.BRF41_Entity2;
import com.bornfire.xbrl.entities.BRBS.BRF41_Entity3;
import com.bornfire.xbrl.entities.BRBS.BRF52_ENTITY1;
import com.bornfire.xbrl.entities.BRBS.BRF52_ENTITY2;
import com.bornfire.xbrl.entities.BRBS.BRF52_ENTITY3;
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
public class BRF41ReportService {
	private static final Logger logger = LoggerFactory.getLogger(BRF41ReportService.class);

	@Autowired
	SessionFactory sessionFactory;

	@Autowired
	DataSource srcdataSource;
	
	@Autowired
	Environment env;
	
	@Autowired
	BRF41DetailRepo brf41DetailRepo;
	
	
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
			Long dtlcnt = (Long) hs.createQuery("select count(*) from  BRF41_Entity1 a where a.report_date=?1")
					.setParameter(1, dt9).getSingleResult();

			if (dtlcnt > 0) {
				logger.info("Getting No of records in Mod table :" + reportid);
				Long modcnt = (Long) hs.createQuery("select count(*) from  BRF41_Entity1 a").getSingleResult();
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
public ModelAndView getBRF41View(String reportId, String fromdate, String todate, String currency, String dtltype,
		Pageable pageable) {
	
		ModelAndView mv = new ModelAndView();
		Session hs = sessionFactory.getCurrentSession();
		int pageSize = pageable.getPageSize();
		int currentPage = pageable.getPageNumber();
		int startItem = currentPage * pageSize;
		/* List<BRF036_ENTITY> T1rep = new ArrayList<BRF036_ENTITY>(); */
		// Query<Object[]> qr;

		List<BRF41_Entity1> T1Master1= new ArrayList<BRF41_Entity1>();
	     List<BRF41_Entity2> T1Master2 = new ArrayList<BRF41_Entity2>(); 
	     List<BRF41_Entity3> T1Master3 = new ArrayList<BRF41_Entity3>(); 

		logger.info("Inside archive" +currency);

		try {
			Date d1 = df.parse(todate);
		//	T1rep = t1CurProdServiceRepo.getT1CurProdServices(d1);

			T1Master1 = hs.createQuery("from  BRF41_Entity1 a where a.report_date = ?1 ", BRF41_Entity1 .class)
					.setParameter(1, df.parse(todate)).getResultList();

			T1Master2 = hs.createQuery("from  BRF41_Entity2 a where a.report_date = ?1 ", BRF41_Entity2 .class)
					.setParameter(1, df.parse(todate)).getResultList();

			T1Master3 = hs.createQuery("from  BRF41_Entity3 a where a.report_date = ?1 ", BRF41_Entity3 .class)
					.setParameter(1, df.parse(todate)).getResultList();

			
			/*
			 * T1Master1 = hs.createQuery("from BRF47_Entity a where a.report_date = ?1 ",
			 * BRF40_Entity2.class) .setParameter(1, df.parse(todate)).getResultList();
			 */
			 

		} catch (ParseException e) {
			e.printStackTrace();
		}

		// T1rep = t1CurProdServiceRepo.getT1CurProdServices(d1);

		mv.setViewName("RR/BRF41");
		// mv.addObject("currlist", refCodeConfig.currList());
		mv.addObject("reportsummary1", T1Master1);
		 mv.addObject("reportsummary2", T1Master2); 
		 mv.addObject("reportsummary3", T1Master3); 
		mv.addObject("reportmaster1", T1Master1);
		mv.addObject("displaymode", "summary");
		mv.addObject("reportsflag", "reportsflag");
		mv.addObject("menu", reportId);
		System.out.println("scv" + mv.getViewName());

		return mv;

	}


	/*
	 * public ModelAndView getBRF036currentDtl(String reportId, String fromdate,
	 * String todate, String currency, String dtltype, Pageable pageable, String
	 * filter) {
	 * 
	 * int pageSize = pageable.getPageSize(); int currentPage =
	 * pageable.getPageNumber(); int startItem = currentPage * pageSize;
	 * 
	 * ModelAndView mv = new ModelAndView();
	 * 
	 * Session hs = sessionFactory.getCurrentSession(); List<Object> T1Dt1 = new
	 * ArrayList<Object>(); Query<Object[]> qr;
	 * 
	 * if (dtltype.equals("report")) { if (!filter.equals("null")) { qr =
	 * hs.createNativeQuery(
	 * "select * from TRAN_MASTER_DETAIL  where report_date = ?1 and t1_report =?2"
	 * ); qr.setParameter(2, filter); } else { qr = hs.
	 * createNativeQuery("select * from TRAN_MASTER_DETAIL  where report_date = ?1"
	 * ); } } else { qr = hs.
	 * createNativeQuery("select * from TRAN_MASTER_DETAIL  where report_date = ?1"
	 * ); } try { qr.setParameter(1, df.parse(todate)); } catch (ParseException e) {
	 * // TODO Auto-generated catch block e.printStackTrace(); } List<BRF036_ENTITY>
	 * T1Master = new ArrayList< BRF036_ENTITY>();
	 * 
	 * try { T1Master =
	 * hs.createQuery("from  BRF036_ENTITY a where a.report_date = ?1",
	 * BRF036_ENTITY.class) .setParameter(1, df.parse(todate)).getResultList(); }
	 * catch (ParseException e) { // TODO Auto-generated catch block
	 * e.printStackTrace(); } return mv;
	 * 
	 * }
	 */
public ModelAndView getBRF41currentDtl(String reportId, String fromdate, String todate, String currency,
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
            qr = hs.createNativeQuery("select * from BRF41_DETAILTABLE");
            //qr.setParameter(2, filter);
        } else {
            qr = hs.createNativeQuery("select * from BRF41_DETAILTABLE");
        }
    } else {
        qr = hs.createNativeQuery("select * from BRF41_DETAILTABLE  where report_date = ?1");
    }
    List<BRF41_DETAILENTITY> T1Master = new ArrayList<BRF41_DETAILENTITY>();

    try {
        T1Master = hs.createQuery("from BRF41_DETAILENTITY a where a.report_date = ?1", BRF41_DETAILENTITY.class)
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
		String maturity_date = (String) a[45];
		String gender = (String) a[46];
		String version = (String) a[46];
		String remarks = (String) a[47];
		String nationality = (String) a[48];
		String state = (String) a[49];
		
		

		BRF41_DETAILENTITY py = new BRF41_DETAILENTITY(cust_id, foracid, act_balance_amt_lc, eab_lc, acct_name, acct_crncy_code, gl_code,
				gl_sub_head_code, gl_sub_head_desc, country_of_incorp, cust_type,
				schm_code, schm_type, sol_id, acid, segment,
				sub_segment, sector, sub_sector,  sector_code, group_id,
				constitution_code, country, legal_entity_type, constitution_desc, purpose_of_advn,
				hni_networth, turnover, bacid, report_name_1,report_label_1,
				report_addl_criteria_1, report_addl_criteria_2, report_addl_criteria_3, create_user, create_time,
				 modify_user, modify_time, verify_user, verify_time,
				entity_flg, modify_flg, del_flg, nre_status, report_date,
				maturity_date, gender,version, remarks, nationality, state);
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

	mv.setViewName("RR"+"/"+"BRF41::reportcontent");
	// mv.setViewName("ReportT1");
	mv.addObject("reportdetails", T1Dt1Page);
	mv.addObject("reportmaster", T1Master);
	mv.addObject("singledetail", new T1CurProdDetail());
	mv.addObject("reportsflag", "reportsflag");
	mv.addObject("menu", reportId);
	return mv;
}

public List<BRF41_Entity1> fetchEntity1Data(Session session, Date date) throws ParseException {
    return session.createQuery("from BRF41_Entity1 a where a.report_date = :date", BRF41_Entity1.class)
                  .setParameter("date", date)
                  .getResultList();
}

public List<BRF41_Entity2> fetchEntity2Data(Session session, Date date) throws ParseException {
    return session.createQuery("from BRF41_Entity2 a where a.report_date = :date", BRF41_Entity2.class)
                  .setParameter("date", date)
                  .getResultList();
}

public List<BRF41_Entity3> fetchEntity3Data(Session session, Date date) throws ParseException {
    return session.createQuery("from BRF41_Entity3 a where a.report_date = :date", BRF41_Entity3.class)
                  .setParameter("date", date)
                  .getResultList();
}

public void updateSheetWithEntity1Data(Sheet sheet, List<BRF41_Entity1> BRF41_Entity1) {
    if (BRF41_Entity1.size() == 1) {
        BRF41_Entity1 brf41 = BRF41_Entity1.get(0);
        
      ///ROW13
		  Row row13 = sheet.getRow(12);
		  Cell R13cell1 = row13.getCell(4); 
			if (R13cell1 != null) {
				R13cell1.setCellValue(brf41.getR13_no_of_accounts_uae() == null ? 0 : brf41.getR13_no_of_accounts_uae().intValue());
			}
			Cell R13cell2 = row13.getCell(5); 
			if (R13cell2 != null) {
				R13cell2.setCellValue(brf41.getR13_amount_uae() == null ? 0 : brf41.getR13_amount_uae().intValue());
			}
			Cell R13cell3 = row13.getCell(6); 
			if (R13cell3 != null) {
				R13cell3.setCellValue(brf41.getR13_no_of_accounts_resident() == null ? 0 : brf41.getR13_no_of_accounts_resident().intValue());
			}
			Cell R13cell4 = row13.getCell(7); 
			if (R13cell4 != null) {
				R13cell4.setCellValue(brf41.getR13_amount_resident() == null ? 0 : brf41.getR13_amount_resident().intValue());
			}
			Cell R13cell5 = row13.getCell(8); 
			if (R13cell5 != null) {
				R13cell5.setCellValue(brf41.getR13_no_of_accounts_non_resident() == null ? 0 : brf41.getR13_no_of_accounts_non_resident().intValue());
			}
			Cell R13cell6 = row13.getCell(9); 
			if (R13cell6 != null) {
				R13cell6.setCellValue(brf41.getR13_amount_non_resident() == null ? 0 : brf41.getR13_amount_non_resident().intValue());
			}
			Cell R13cell7 = row13.getCell(13); 
			if (R13cell7 != null) {
				R13cell7.setCellValue(brf41.getR13_no_of_accounts_uae_abu() == null ? 0 : brf41.getR13_no_of_accounts_uae_abu().intValue());
			}
			Cell R13cell8 = row13.getCell(14); 
			if (R13cell8 != null) {
				R13cell8.setCellValue(brf41.getR13_amount_uae_abu() == null ? 0 : brf41.getR13_amount_uae_abu().intValue());
			}
			Cell R13cell9 = row13.getCell(15); 
			if (R13cell9 != null) {
				R13cell9.setCellValue(brf41.getR13_no_of_accounts_non_uae_abu() == null ? 0 : brf41.getR13_no_of_accounts_non_uae_abu().intValue());
			}
			Cell R13cell10 = row13.getCell(16); 
			if (R13cell10 != null) {
				R13cell10.setCellValue(brf41.getR13_amount_non_uae_abu() == null ? 0 : brf41.getR13_amount_non_uae_abu().intValue());
			}
			Cell R13cell11 = row13.getCell(18); 
			if (R13cell11 != null) {
				R13cell11.setCellValue(brf41.getR13_no_of_accounts_uae_dubai() == null ? 0 : brf41.getR13_no_of_accounts_uae_dubai().intValue());
			}
			Cell R13cell12 = row13.getCell(19); 
			if (R13cell12 != null) {
				R13cell12.setCellValue(brf41.getR13_amount_uae_dubai() == null ? 0 : brf41.getR13_amount_uae_dubai().intValue());
			}
			Cell R13cell13 = row13.getCell(20); 
			if (R13cell13 != null) {
				R13cell13.setCellValue(brf41.getR13_no_of_accounts_non_uae_dubai() == null ? 0 : brf41.getR13_no_of_accounts_non_uae_dubai().intValue());
			}
			Cell R13cell14 = row13.getCell(21); 
			if (R13cell14 != null) {
				R13cell14.setCellValue(brf41.getR13_amount_non_uae_dubai() == null ? 0 : brf41.getR13_amount_non_uae_dubai().intValue());
			}
			Cell R13cell15 = row13.getCell(23); 
			if (R13cell15 != null) {
				R13cell15.setCellValue(brf41.getR13_no_of_accounts_uae_sharjah() == null ? 0 : brf41.getR13_no_of_accounts_uae_sharjah().intValue());
			}
			Cell R13cell16 = row13.getCell(24); 
			if (R13cell16 != null) {
				R13cell16.setCellValue(brf41.getR13_amount_uae_sharjah() == null ? 0 : brf41.getR13_amount_uae_sharjah().intValue());
			}
			Cell  R13cell17 = row13.getCell(25); 
			if (R13cell17 != null) {
				R13cell17.setCellValue(brf41.getR13_no_of_accounts_non_uae_sharjah() == null ? 0 : brf41.getR13_no_of_accounts_non_uae_sharjah().intValue());
			}
			Cell  R13cell18 = row13.getCell(26); 
			if (R13cell18 != null) {
				R13cell18.setCellValue(brf41.getR13_amount_non_uae_sharjah() == null ? 0 : brf41.getR13_amount_non_uae_sharjah().intValue());
			}
			Cell  R13cell19 = row13.getCell(28); 
			if (R13cell19 != null) {
				R13cell19.setCellValue(brf41.getR13_no_of_accounts_uae_ajman() == null ? 0 : brf41.getR13_no_of_accounts_uae_ajman().intValue());
			}
			Cell  R13cell20 = row13.getCell(29); 
			if (R13cell20 != null) {
				R13cell20.setCellValue(brf41.getR13_amount_uae_ajman() == null ? 0 : brf41.getR13_amount_uae_ajman().intValue());
			}
			Cell  R13cell21 = row13.getCell(30); 
			if (R13cell21 != null) {
				R13cell21.setCellValue(brf41.getR13_no_of_accounts_non_uae_ajman() == null ? 0 : brf41.getR13_no_of_accounts_non_uae_ajman().intValue());
			}
			Cell R13cell22 = row13.getCell(31); 
			if (R13cell22 != null) {
				R13cell22.setCellValue(brf41.getR13_amount_non_uae_ajman() == null ? 0 : brf41.getR13_amount_non_uae_ajman().intValue());
			}
			Cell  R13cell23 = row13.getCell(33); 
			if (R13cell23 != null) {
				R13cell23.setCellValue(brf41.getR13_no_of_accounts_uae_ras() == null ? 0 : brf41.getR13_no_of_accounts_uae_ras().intValue());
			}
			Cell R13cell24 = row13.getCell(34); 
			if (R13cell24 != null) {
				R13cell24.setCellValue(brf41.getR13_amount_uae_ras() == null ? 0 : brf41.getR13_amount_uae_ras().intValue());
			}
			Cell  R13cell25 = row13.getCell(35); 
			if (R13cell25 != null) {
				R13cell25.setCellValue(brf41.getR13_no_of_accounts_non_uae_ras() == null ? 0 : brf41.getR13_no_of_accounts_non_uae_ras().intValue());
			}
			Cell  R13cell26 = row13.getCell(36); 
			if (R13cell26 != null) {
				R13cell26.setCellValue(brf41.getR13_amount_non_uae_ras() == null ? 0 : brf41.getR13_amount_non_uae_ras().intValue());
			}
			Cell  R13cell27 = row13.getCell(38); 
			if (R13cell27 != null) {
				R13cell27.setCellValue(brf41.getR13_no_of_accounts_uae_umm() == null ? 0 : brf41.getR13_no_of_accounts_uae_umm().intValue());
			}
			Cell  R13cell28 = row13.getCell(39); 
			if (R13cell28 != null) {
				R13cell28.setCellValue(brf41.getR13_amount_uae_umm() == null ? 0 : brf41.getR13_amount_uae_umm().intValue());
			}
			Cell  R13cell29 = row13.getCell(40); 
			if (R13cell29 != null) {
				R13cell29.setCellValue(brf41.getR13_no_of_accounts_non_uae_umm() == null ? 0 : brf41.getR13_no_of_accounts_non_uae_umm().intValue());
			}
			Cell  R13cell30 = row13.getCell(41); 
			if (R13cell30 != null) {
				R13cell30.setCellValue(brf41.getR13_amount_non_uae_umm() == null ? 0 : brf41.getR13_amount_non_uae_umm().intValue());
			}
			Cell  R13cell31 = row13.getCell(43); 
			if (R13cell31 != null) {
				R13cell31.setCellValue(brf41.getR13_no_of_accounts_uae_fujairah() == null ? 0 : brf41.getR13_no_of_accounts_uae_fujairah().intValue());
			}
			Cell  R13cell32 = row13.getCell(44); 
			if (R13cell32 != null) {
				R13cell32.setCellValue(brf41.getR13_amount_uae_fujairah() == null ? 0 : brf41.getR13_amount_uae_fujairah().intValue());
			}
			Cell  R13cell33 = row13.getCell(45); 
			if (R13cell33 != null) {
				R13cell33.setCellValue(brf41.getR13_no_of_accounts_non_uae_fujairah() == null ? 0 : brf41.getR13_no_of_accounts_non_uae_fujairah().intValue());
			} 													
			Cell  R13cell34 = row13.getCell(46); 
			if (R13cell34 != null) {
				R13cell34.setCellValue(brf41.getR13_amount_non_uae_fujairah() == null ? 0 : brf41.getR13_amount_non_uae_fujairah().intValue());
			}
			///ROW14
			  Row row14 = sheet.getRow(13);
			  Cell R14cell1 = row14.getCell(4); 
				if (R14cell1 != null) {
					R14cell1.setCellValue(brf41.getR14_no_of_accounts_uae() == null ? 0 : brf41.getR14_no_of_accounts_uae().intValue());
				}
				Cell R14cell2 = row14.getCell(5); 
				if (R14cell2 != null) {
					R14cell2.setCellValue(brf41.getR14_amount_uae() == null ? 0 : brf41.getR14_amount_uae().intValue());
				}
				Cell R14cell3 = row14.getCell(6); 
				if (R14cell3 != null) {
					R14cell3.setCellValue(brf41.getR14_no_of_accounts_resident() == null ? 0 : brf41.getR14_no_of_accounts_resident().intValue());
				}
				Cell R14cell4 = row14.getCell(7); 
				if (R14cell4 != null) {
					R14cell4.setCellValue(brf41.getR14_amount_resident() == null ? 0 : brf41.getR14_amount_resident().intValue());
				}
				Cell R14cell5 = row14.getCell(8); 
				if (R14cell5 != null) {
					R14cell5.setCellValue(brf41.getR14_no_of_accounts_non_resident() == null ? 0 : brf41.getR14_no_of_accounts_non_resident().intValue());
				}
				Cell R14cell6 = row14.getCell(9); 
				if (R14cell6 != null) {
					R14cell6.setCellValue(brf41.getR14_amount_non_resident() == null ? 0 : brf41.getR14_amount_non_resident().intValue());
				}
				Cell R14cell7 = row14.getCell(13); 
				if (R14cell7 != null) {
					R14cell7.setCellValue(brf41.getR14_no_of_accounts_uae_abu() == null ? 0 : brf41.getR14_no_of_accounts_uae_abu().intValue());
				}
				Cell R14cell8 = row14.getCell(14); 
				if (R14cell8 != null) {
					R14cell8.setCellValue(brf41.getR14_amount_uae_abu() == null ? 0 : brf41.getR14_amount_uae_abu().intValue());
				}
				Cell R14cell9 = row14.getCell(15); 
				if (R14cell9 != null) {
					R14cell9.setCellValue(brf41.getR14_no_of_accounts_non_uae_abu() == null ? 0 : brf41.getR14_no_of_accounts_non_uae_abu().intValue());
				}
				Cell R14cell10 = row14.getCell(16); 
				if (R14cell10 != null) {
					R14cell10.setCellValue(brf41.getR14_amount_non_uae_abu() == null ? 0 : brf41.getR14_amount_non_uae_abu().intValue());
				}
				Cell R14cell11 = row14.getCell(18); 
				if (R14cell11 != null) {
					R14cell11.setCellValue(brf41.getR14_no_of_accounts_uae_dubai() == null ? 0 : brf41.getR14_no_of_accounts_uae_dubai().intValue());
				}
				Cell R14cell12 = row14.getCell(19); 
				if (R14cell12 != null) {
					R14cell12.setCellValue(brf41.getR14_amount_uae_dubai() == null ? 0 : brf41.getR14_amount_uae_dubai().intValue());
				}

				Cell R14cell13 = row14.getCell(20); 
				if (R14cell13 != null) {
					R14cell13.setCellValue(brf41.getR14_no_of_accounts_non_uae_dubai() == null ? 0 : brf41.getR14_no_of_accounts_non_uae_dubai().intValue());
				}
				Cell R14cell14 = row14.getCell(21); 
				if (R14cell14 != null) {
					R14cell14.setCellValue(brf41.getR14_amount_non_uae_dubai() == null ? 0 : brf41.getR14_amount_non_uae_dubai().intValue());
				}
				Cell R14cell15 = row14.getCell(23); 
				if (R14cell15 != null) {
					R14cell15.setCellValue(brf41.getR14_no_of_accounts_uae_sharjah() == null ? 0 : brf41.getR14_no_of_accounts_uae_sharjah().intValue());
				}
				Cell R14cell16 = row14.getCell(24); 
				if (R14cell16 != null) {
					R14cell16.setCellValue(brf41.getR14_amount_uae_sharjah() == null ? 0 : brf41.getR14_amount_uae_sharjah().intValue());
				}
				Cell  R14cell17 = row14.getCell(25); 
				if (R14cell17 != null) {
					R14cell17.setCellValue(brf41.getR14_no_of_accounts_non_uae_sharjah() == null ? 0 : brf41.getR14_no_of_accounts_non_uae_sharjah().intValue());
				}
				Cell  R14cell18 = row14.getCell(26); 
				if (R14cell18 != null) {
					R14cell18.setCellValue(brf41.getR14_amount_non_uae_sharjah() == null ? 0 : brf41.getR14_amount_non_uae_sharjah().intValue());
				}
				Cell  R14cell19 = row14.getCell(28); 
				if (R14cell19 != null) {
					R14cell19.setCellValue(brf41.getR14_no_of_accounts_uae_ajman() == null ? 0 : brf41.getR14_no_of_accounts_uae_ajman().intValue());
				}

				Cell  R14cell20 = row14.getCell(29); 
				if (R14cell20 != null) {
					R14cell20.setCellValue(brf41.getR14_amount_uae_ajman() == null ? 0 : brf41.getR14_amount_uae_ajman().intValue());
				}
				Cell  R14cell21 = row14.getCell(30); 
				if (R14cell21 != null) {
					R14cell21.setCellValue(brf41.getR14_no_of_accounts_non_uae_ajman() == null ? 0 : brf41.getR14_no_of_accounts_non_uae_ajman().intValue());
				}

				Cell R14cell22 = row14.getCell(31); 
				if (R14cell22 != null) {
					R14cell22.setCellValue(brf41.getR14_amount_non_uae_ajman() == null ? 0 : brf41.getR14_amount_non_uae_ajman().intValue());
				}
				Cell  R14cell23 = row14.getCell(33); 
				if (R14cell23 != null) {
					R14cell23.setCellValue(brf41.getR14_no_of_accounts_uae_ras() == null ? 0 : brf41.getR14_no_of_accounts_uae_ras().intValue());
				}
				Cell R14cell24 = row14.getCell(34); 
				if (R14cell24 != null) {
					R14cell24.setCellValue(brf41.getR14_amount_uae_ras() == null ? 0 : brf41.getR14_amount_uae_ras().intValue());
				}
				Cell  R14cell25 = row14.getCell(35); 
				if (R14cell25 != null) {
					R14cell25.setCellValue(brf41.getR14_no_of_accounts_non_uae_ras() == null ? 0 : brf41.getR14_no_of_accounts_non_uae_ras().intValue());
				}
				Cell  R14cell26 = row14.getCell(36); 
				if (R14cell26 != null) {
					R14cell26.setCellValue(brf41.getR14_amount_non_uae_ras() == null ? 0 : brf41.getR14_amount_non_uae_ras().intValue());
				}
				Cell  R14cell27 = row14.getCell(38); 
				if (R14cell27 != null) {
					R14cell27.setCellValue(brf41.getR14_no_of_accounts_uae_umm() == null ? 0 : brf41.getR14_no_of_accounts_uae_umm().intValue());
				}
				Cell  R14cell28 = row14.getCell(39); 
				if (R14cell28 != null) {
					R14cell28.setCellValue(brf41.getR14_amount_uae_umm() == null ? 0 : brf41.getR14_amount_uae_umm().intValue());
				}
				Cell  R14cell29 = row14.getCell(40); 
				if (R14cell29 != null) {
					R14cell29.setCellValue(brf41.getR14_no_of_accounts_non_uae_umm() == null ? 0 : brf41.getR14_no_of_accounts_non_uae_umm().intValue());
				}
				Cell  R14cell30 = row14.getCell(41); 
				if (R14cell30 != null) {
					R14cell30.setCellValue(brf41.getR14_amount_non_uae_umm() == null ? 0 : brf41.getR14_amount_non_uae_umm().intValue());
				}
				Cell  R14cell31 = row14.getCell(43); 
				if (R14cell31 != null) {
					R14cell31.setCellValue(brf41.getR14_no_of_accounts_uae_fujairah() == null ? 0 : brf41.getR14_no_of_accounts_uae_fujairah().intValue());
				}
				Cell  R14cell32 = row14.getCell(44); 
				if (R14cell32 != null) {
					R14cell32.setCellValue(brf41.getR14_amount_uae_fujairah() == null ? 0 : brf41.getR14_amount_uae_fujairah().intValue());
				}
				Cell  R14cell33 = row14.getCell(45); 
				if (R14cell33 != null) {
					R14cell33.setCellValue(brf41.getR14_no_of_accounts_non_uae_fujairah() == null ? 0 : brf41.getR14_no_of_accounts_non_uae_fujairah().intValue());
				}
										
				Cell  R14cell34 = row14.getCell(46); 
				if (R14cell34 != null) {
					R14cell34.setCellValue(brf41.getR14_amount_non_uae_fujairah() == null ? 0 : brf41.getR14_amount_non_uae_fujairah().intValue());
				}
			///ROW16
			  Row row16 = sheet.getRow(15);
			  Cell R16cell1 = row16.getCell(4); 
				if (R16cell1 != null) {
					R16cell1.setCellValue(brf41.getR16_no_of_accounts_uae() == null ? 0 : brf41.getR16_no_of_accounts_uae().intValue());
				}
				Cell R16cell2 = row16.getCell(5); 
				if (R16cell2 != null) {
					R16cell2.setCellValue(brf41.getR16_amount_uae() == null ? 0 : brf41.getR16_amount_uae().intValue());
				}
				Cell R16cell3 = row16.getCell(6); 
				if (R16cell3 != null) {
					R16cell3.setCellValue(brf41.getR16_no_of_accounts_resident() == null ? 0 : brf41.getR16_no_of_accounts_resident().intValue());
				}
				Cell R16cell4 = row16.getCell(7); 
				if (R16cell4 != null) {
					R16cell4.setCellValue(brf41.getR16_amount_resident() == null ? 0 : brf41.getR16_amount_resident().intValue());
				}
				Cell R16cell5 = row16.getCell(8); 
				if (R16cell5 != null) {
					R16cell5.setCellValue(brf41.getR16_no_of_accounts_non_resident() == null ? 0 : brf41.getR16_no_of_accounts_non_resident().intValue());
				}
				Cell R16cell6 = row16.getCell(9); 
				if (R16cell6 != null) {
					R16cell6.setCellValue(brf41.getR16_amount_non_resident() == null ? 0 : brf41.getR16_amount_non_resident().intValue());
				}
				Cell R16cell7 = row16.getCell(13); 
				if (R16cell7 != null) {
					R16cell7.setCellValue(brf41.getR16_no_of_accounts_uae_abu() == null ? 0 : brf41.getR16_no_of_accounts_uae_abu().intValue());
				}
				Cell R16cell8 = row16.getCell(14); 
				if (R16cell8 != null) {
					R16cell8.setCellValue(brf41.getR16_amount_uae_abu() == null ? 0 : brf41.getR16_amount_uae_abu().intValue());
				}
				Cell R16cell9 = row16.getCell(15); 
				if (R16cell9 != null) {
					R16cell9.setCellValue(brf41.getR16_no_of_accounts_non_uae_abu() == null ? 0 : brf41.getR16_no_of_accounts_non_uae_abu().intValue());
				}
				Cell R16cell10 = row16.getCell(16); 
				if (R16cell10 != null) {
					R16cell10.setCellValue(brf41.getR16_amount_non_uae_abu() == null ? 0 : brf41.getR16_amount_non_uae_abu().intValue());
				}

				Cell R16cell11 = row16.getCell(18); 
				if (R16cell11 != null) {
					R16cell11.setCellValue(brf41.getR16_no_of_accounts_uae_dubai() == null ? 0 : brf41.getR16_no_of_accounts_uae_dubai().intValue());
				}
				Cell R16cell12 = row16.getCell(19); 
				if (R16cell12 != null) {
					R16cell12.setCellValue(brf41.getR16_amount_uae_dubai() == null ? 0 : brf41.getR16_amount_uae_dubai().intValue());
				}

				Cell R16cell13 = row16.getCell(20); 
				if (R16cell13 != null) {
					R16cell13.setCellValue(brf41.getR16_no_of_accounts_non_uae_dubai() == null ? 0 : brf41.getR16_no_of_accounts_non_uae_dubai().intValue());
				}
				Cell R16cell14 = row16.getCell(21); 
				if (R16cell14 != null) {
					R16cell14.setCellValue(brf41.getR16_amount_non_uae_dubai() == null ? 0 : brf41.getR16_amount_non_uae_dubai().intValue());
				}
				Cell R16cell15 = row16.getCell(23); 
				if (R16cell15 != null) {
					R16cell15.setCellValue(brf41.getR16_no_of_accounts_uae_sharjah() == null ? 0 : brf41.getR16_no_of_accounts_uae_sharjah().intValue());
				}
				Cell R16cell16 = row16.getCell(24); 
				if (R16cell16 != null) {
					R16cell16.setCellValue(brf41.getR16_amount_uae_sharjah() == null ? 0 : brf41.getR16_amount_uae_sharjah().intValue());
				}
				Cell  R16cell17 = row16.getCell(25); 
				if (R16cell17 != null) {
					R16cell17.setCellValue(brf41.getR16_no_of_accounts_non_uae_sharjah() == null ? 0 : brf41.getR16_no_of_accounts_non_uae_sharjah().intValue());
				}
				Cell  R16cell18 = row16.getCell(26); 
				if (R16cell18 != null) {
					R16cell18.setCellValue(brf41.getR16_amount_non_uae_sharjah() == null ? 0 : brf41.getR16_amount_non_uae_sharjah().intValue());
				}
				Cell  R16cell19 = row16.getCell(28); 
				if (R16cell19 != null) {
					R16cell19.setCellValue(brf41.getR16_no_of_accounts_uae_ajman() == null ? 0 : brf41.getR16_no_of_accounts_uae_ajman().intValue());
				}

				Cell  R16cell20 = row16.getCell(29); 
				if (R16cell20 != null) {
					R16cell20.setCellValue(brf41.getR16_amount_uae_ajman() == null ? 0 : brf41.getR16_amount_uae_ajman().intValue());
				}
				Cell  R16cell21 = row16.getCell(30); 
				if (R16cell21 != null) {
					R16cell21.setCellValue(brf41.getR16_no_of_accounts_non_uae_ajman() == null ? 0 : brf41.getR16_no_of_accounts_non_uae_ajman().intValue());
				}

				Cell R16cell22 = row16.getCell(31); 
				if (R16cell22 != null) {
					R16cell22.setCellValue(brf41.getR16_amount_non_uae_ajman() == null ? 0 : brf41.getR16_amount_non_uae_ajman().intValue());
				}
				Cell  R16cell23 = row16.getCell(33); 
				if (R16cell23 != null) {
					R16cell23.setCellValue(brf41.getR16_no_of_accounts_uae_ras() == null ? 0 : brf41.getR16_no_of_accounts_uae_ras().intValue());
				}
				Cell R16cell24 = row16.getCell(34); 
				if (R16cell24 != null) {
					R16cell24.setCellValue(brf41.getR16_amount_uae_ras() == null ? 0 : brf41.getR16_amount_uae_ras().intValue());
				}
				Cell  R16cell25 = row16.getCell(35); 
				if (R16cell25 != null) {
					R16cell25.setCellValue(brf41.getR16_no_of_accounts_non_uae_ras() == null ? 0 : brf41.getR16_no_of_accounts_non_uae_ras().intValue());
				}
				Cell  R16cell26 = row16.getCell(36); 
				if (R16cell26 != null) {
					R16cell26.setCellValue(brf41.getR16_amount_non_uae_ras() == null ? 0 : brf41.getR16_amount_non_uae_ras().intValue());
				}
				Cell  R16cell27 = row16.getCell(38); 
				if (R16cell27 != null) {
					R16cell27.setCellValue(brf41.getR16_no_of_accounts_uae_umm() == null ? 0 : brf41.getR16_no_of_accounts_uae_umm().intValue());
				}
				Cell  R16cell28 = row16.getCell(39); 
				if (R16cell28 != null) {
					R16cell28.setCellValue(brf41.getR16_amount_uae_umm() == null ? 0 : brf41.getR16_amount_uae_umm().intValue());
				}
				Cell  R16cell29 = row16.getCell(40); 
				if (R16cell29 != null) {
					R16cell29.setCellValue(brf41.getR16_no_of_accounts_non_uae_umm() == null ? 0 : brf41.getR16_no_of_accounts_non_uae_umm().intValue());
				}
				Cell  R16cell30 = row16.getCell(41); 
				if (R16cell30 != null) {
					R16cell30.setCellValue(brf41.getR16_amount_non_uae_umm() == null ? 0 : brf41.getR16_amount_non_uae_umm().intValue());
				}
				Cell  R16cell31 = row16.getCell(43); 
				if (R16cell31 != null) {
					R16cell31.setCellValue(brf41.getR16_no_of_accounts_uae_fujairah() == null ? 0 : brf41.getR16_no_of_accounts_uae_fujairah().intValue());
				}
				Cell  R16cell32 = row16.getCell(44); 
				if (R16cell32 != null) {
					R16cell32.setCellValue(brf41.getR16_amount_uae_fujairah() == null ? 0 : brf41.getR16_amount_uae_fujairah().intValue());
				}
				Cell  R16cell33 = row16.getCell(45); 
				if (R16cell33 != null) {
					R16cell33.setCellValue(brf41.getR16_no_of_accounts_non_uae_fujairah() == null ? 0 : brf41.getR16_no_of_accounts_non_uae_fujairah().intValue());
				}
										
				Cell  R16cell34 = row16.getCell(46); 
				if (R16cell34 != null) {
					R16cell34.setCellValue(brf41.getR16_amount_non_uae_fujairah() == null ? 0 : brf41.getR16_amount_non_uae_fujairah().intValue());
				}
			///ROW17
			  Row row17 = sheet.getRow(16);
			  Cell R17cell1 = row17.getCell(4); 
				if (R17cell1 != null) {
					R17cell1.setCellValue(brf41.getR17_no_of_accounts_uae() == null ? 0 : brf41.getR17_no_of_accounts_uae().intValue());
				}
				Cell R17cell2 = row17.getCell(5); 
				if (R17cell2 != null) {
					R17cell2.setCellValue(brf41.getR17_amount_uae() == null ? 0 : brf41.getR17_amount_uae().intValue());
				}
				Cell R17cell3 = row17.getCell(6); 
				if (R17cell3 != null) {
					R17cell3.setCellValue(brf41.getR17_no_of_accounts_resident() == null ? 0 : brf41.getR17_no_of_accounts_resident().intValue());
				}
				Cell R17cell4 = row17.getCell(7); 
				if (R17cell4 != null) {
					R17cell4.setCellValue(brf41.getR17_amount_resident() == null ? 0 : brf41.getR17_amount_resident().intValue());
				}
				Cell R17cell5 = row17.getCell(8); 
				if (R17cell5 != null) {
					R17cell5.setCellValue(brf41.getR17_no_of_accounts_non_resident() == null ? 0 : brf41.getR17_no_of_accounts_non_resident().intValue());
				}
				Cell R17cell6 = row17.getCell(9); 
				if (R17cell6 != null) {
					R17cell6.setCellValue(brf41.getR17_amount_non_resident() == null ? 0 : brf41.getR17_amount_non_resident().intValue());
				}
				Cell R17cell7 = row17.getCell(13); 
				if (R17cell7 != null) {
					R17cell7.setCellValue(brf41.getR17_no_of_accounts_uae_abu() == null ? 0 : brf41.getR17_no_of_accounts_uae_abu().intValue());
				}
				Cell R17cell8 = row17.getCell(14); 
				if (R17cell8 != null) {
					R17cell8.setCellValue(brf41.getR17_amount_uae_abu() == null ? 0 : brf41.getR17_amount_uae_abu().intValue());
				}
				Cell R17cell9 = row17.getCell(15); 
				if (R17cell9 != null) {
					R17cell9.setCellValue(brf41.getR17_no_of_accounts_non_uae_abu() == null ? 0 : brf41.getR17_no_of_accounts_non_uae_abu().intValue());
				}
				Cell R17cell10 = row17.getCell(16); 
				if (R17cell10 != null) {
					R17cell10.setCellValue(brf41.getR17_amount_non_uae_abu() == null ? 0 : brf41.getR17_amount_non_uae_abu().intValue());
				}

				Cell R17cell11 = row17.getCell(18); 
				if (R17cell11 != null) {
					R17cell11.setCellValue(brf41.getR17_no_of_accounts_uae_dubai() == null ? 0 : brf41.getR17_no_of_accounts_uae_dubai().intValue());
				}
				Cell R17cell12 = row17.getCell(19); 
				if (R17cell12 != null) {
					R17cell12.setCellValue(brf41.getR17_amount_uae_dubai() == null ? 0 : brf41.getR17_amount_uae_dubai().intValue());
				}

				Cell R17cell13 = row17.getCell(20); 
				if (R17cell13 != null) {
					R17cell13.setCellValue(brf41.getR17_no_of_accounts_non_uae_dubai() == null ? 0 : brf41.getR17_no_of_accounts_non_uae_dubai().intValue());
				}
				Cell R17cell14 = row17.getCell(21); 
				if (R17cell14 != null) {
					R17cell14.setCellValue(brf41.getR17_amount_non_uae_dubai() == null ? 0 : brf41.getR17_amount_non_uae_dubai().intValue());
				}
				Cell R17cell15 = row17.getCell(23); 
				if (R17cell15 != null) {
					R17cell15.setCellValue(brf41.getR17_no_of_accounts_uae_sharjah() == null ? 0 : brf41.getR17_no_of_accounts_uae_sharjah().intValue());
				}
				Cell R17cell16 = row17.getCell(24); 
				if (R17cell16 != null) {
					R17cell16.setCellValue(brf41.getR17_amount_uae_sharjah() == null ? 0 : brf41.getR17_amount_uae_sharjah().intValue());
				}
				Cell  R17cell17 = row17.getCell(25); 
				if (R17cell17 != null) {
					R17cell17.setCellValue(brf41.getR17_no_of_accounts_non_uae_sharjah() == null ? 0 : brf41.getR17_no_of_accounts_non_uae_sharjah().intValue());
				}
				Cell  R17cell18 = row17.getCell(26); 
				if (R17cell18 != null) {
					R17cell18.setCellValue(brf41.getR17_amount_non_uae_sharjah() == null ? 0 : brf41.getR17_amount_non_uae_sharjah().intValue());
				}
				Cell  R17cell19 = row17.getCell(28); 
				if (R17cell19 != null) {
					R17cell19.setCellValue(brf41.getR17_no_of_accounts_uae_ajman() == null ? 0 : brf41.getR17_no_of_accounts_uae_ajman().intValue());
				}

				Cell  R17cell20 = row17.getCell(29); 
				if (R17cell20 != null) {
					R17cell20.setCellValue(brf41.getR17_amount_uae_ajman() == null ? 0 : brf41.getR17_amount_uae_ajman().intValue());
				}
				Cell  R17cell21 = row17.getCell(30); 
				if (R17cell21 != null) {
					R17cell21.setCellValue(brf41.getR17_no_of_accounts_non_uae_ajman() == null ? 0 : brf41.getR17_no_of_accounts_non_uae_ajman().intValue());
				}

				Cell R17cell22 = row17.getCell(31); 
				if (R17cell22 != null) {
					R17cell22.setCellValue(brf41.getR17_amount_non_uae_ajman() == null ? 0 : brf41.getR17_amount_non_uae_ajman().intValue());
				}
				Cell  R17cell23 = row17.getCell(33); 
				if (R17cell23 != null) {
					R17cell23.setCellValue(brf41.getR17_no_of_accounts_uae_ras() == null ? 0 : brf41.getR17_no_of_accounts_uae_ras().intValue());
				}
				Cell R17cell24 = row17.getCell(34); 
				if (R17cell24 != null) {
					R17cell24.setCellValue(brf41.getR17_amount_uae_ras() == null ? 0 : brf41.getR17_amount_uae_ras().intValue());
				}
				Cell  R17cell25 = row17.getCell(35); 
				if (R17cell25 != null) {
					R17cell25.setCellValue(brf41.getR17_no_of_accounts_non_uae_ras() == null ? 0 : brf41.getR17_no_of_accounts_non_uae_ras().intValue());
				}
				Cell  R17cell26 = row17.getCell(36); 
				if (R17cell26 != null) {
					R17cell26.setCellValue(brf41.getR17_amount_non_uae_ras() == null ? 0 : brf41.getR17_amount_non_uae_ras().intValue());
				}
				Cell  R17cell27 = row17.getCell(38); 
				if (R17cell27 != null) {
					R17cell27.setCellValue(brf41.getR17_no_of_accounts_uae_umm() == null ? 0 : brf41.getR17_no_of_accounts_uae_umm().intValue());
				}
				Cell  R17cell28 = row17.getCell(39); 
				if (R17cell28 != null) {
					R17cell28.setCellValue(brf41.getR17_amount_uae_umm() == null ? 0 : brf41.getR17_amount_uae_umm().intValue());
				}
				Cell  R17cell29 = row17.getCell(40); 
				if (R17cell29 != null) {
					R17cell29.setCellValue(brf41.getR17_no_of_accounts_non_uae_umm() == null ? 0 : brf41.getR17_no_of_accounts_non_uae_umm().intValue());
				}
				Cell  R17cell30 = row17.getCell(41); 
				if (R17cell30 != null) {
					R17cell30.setCellValue(brf41.getR17_amount_non_uae_umm() == null ? 0 : brf41.getR17_amount_non_uae_umm().intValue());
				}
				Cell  R17cell31 = row17.getCell(43); 
				if (R17cell31 != null) {
					R17cell31.setCellValue(brf41.getR17_no_of_accounts_uae_fujairah() == null ? 0 : brf41.getR17_no_of_accounts_uae_fujairah().intValue());
				}
				Cell  R17cell32 = row17.getCell(44); 
				if (R17cell32 != null) {
					R17cell32.setCellValue(brf41.getR17_amount_uae_fujairah() == null ? 0 : brf41.getR17_amount_uae_fujairah().intValue());
				}
				Cell  R17cell33 = row17.getCell(45); 
				if (R17cell33 != null) {
					R17cell33.setCellValue(brf41.getR17_no_of_accounts_non_uae_fujairah() == null ? 0 : brf41.getR17_no_of_accounts_non_uae_fujairah().intValue());
				}
										
				Cell  R17cell34 = row17.getCell(46); 
				if (R17cell34 != null) {
					R17cell34.setCellValue(brf41.getR17_amount_non_uae_fujairah() == null ? 0 : brf41.getR17_amount_non_uae_fujairah().intValue());
				}
			///ROW18
			  Row row18 = sheet.getRow(17);
			  Cell R18cell1 = row18.getCell(4); 
				if (R18cell1 != null) {
					R18cell1.setCellValue(brf41.getR18_no_of_accounts_uae() == null ? 0 : brf41.getR18_no_of_accounts_uae().intValue());
				}
				Cell R18cell2 = row18.getCell(5); 
				if (R18cell2 != null) {
					R18cell2.setCellValue(brf41.getR18_amount_uae() == null ? 0 : brf41.getR18_amount_uae().intValue());
				}
				Cell R18cell3 = row18.getCell(6); 
				if (R18cell3 != null) {
					R18cell3.setCellValue(brf41.getR18_no_of_accounts_resident() == null ? 0 : brf41.getR18_no_of_accounts_resident().intValue());
				}
				Cell R18cell4 = row18.getCell(7); 
				if (R18cell4 != null) {
					R18cell4.setCellValue(brf41.getR18_amount_resident() == null ? 0 : brf41.getR18_amount_resident().intValue());
				}
				Cell R18cell5 = row18.getCell(8); 
				if (R18cell5 != null) {
					R18cell5.setCellValue(brf41.getR18_no_of_accounts_non_resident() == null ? 0 : brf41.getR18_no_of_accounts_non_resident().intValue());
				}
				Cell R18cell6 = row18.getCell(9); 
				if (R18cell6 != null) {
					R18cell6.setCellValue(brf41.getR18_amount_non_resident() == null ? 0 : brf41.getR18_amount_non_resident().intValue());
				}
				Cell R18cell7 = row18.getCell(13); 
				if (R18cell7 != null) {
					R18cell7.setCellValue(brf41.getR18_no_of_accounts_uae_abu() == null ? 0 : brf41.getR18_no_of_accounts_uae_abu().intValue());
				}
				Cell R18cell8 = row18.getCell(14); 
				if (R18cell8 != null) {
					R18cell8.setCellValue(brf41.getR18_amount_uae_abu() == null ? 0 : brf41.getR18_amount_uae_abu().intValue());
				}
				Cell R18cell9 = row18.getCell(15); 
				if (R18cell9 != null) {
					R18cell9.setCellValue(brf41.getR18_no_of_accounts_non_uae_abu() == null ? 0 : brf41.getR18_no_of_accounts_non_uae_abu().intValue());
				}
				Cell R18cell10 = row18.getCell(16); 
				if (R18cell10 != null) {
					R18cell10.setCellValue(brf41.getR18_amount_non_uae_abu() == null ? 0 : brf41.getR18_amount_non_uae_abu().intValue());
				}

				Cell R18cell11 = row18.getCell(18); 
				if (R18cell11 != null) {
					R18cell11.setCellValue(brf41.getR18_no_of_accounts_uae_dubai() == null ? 0 : brf41.getR18_no_of_accounts_uae_dubai().intValue());
				}
				Cell R18cell12 = row18.getCell(19); 
				if (R18cell12 != null) {
					R18cell12.setCellValue(brf41.getR18_amount_uae_dubai() == null ? 0 : brf41.getR18_amount_uae_dubai().intValue());
				}

				Cell R18cell13 = row18.getCell(20); 
				if (R18cell13 != null) {
					R18cell13.setCellValue(brf41.getR18_no_of_accounts_non_uae_dubai() == null ? 0 : brf41.getR18_no_of_accounts_non_uae_dubai().intValue());
				}
				Cell R18cell14 = row18.getCell(21); 
				if (R18cell14 != null) {
					R18cell14.setCellValue(brf41.getR18_amount_non_uae_dubai() == null ? 0 : brf41.getR18_amount_non_uae_dubai().intValue());
				}
				Cell R18cell15 = row18.getCell(23); 
				if (R18cell15 != null) {
					R18cell15.setCellValue(brf41.getR18_no_of_accounts_uae_sharjah() == null ? 0 : brf41.getR18_no_of_accounts_uae_sharjah().intValue());
				}
				Cell R18cell16 = row18.getCell(24); 
				if (R18cell16 != null) {
					R18cell16.setCellValue(brf41.getR18_amount_uae_sharjah() == null ? 0 : brf41.getR18_amount_uae_sharjah().intValue());
				}
				Cell  R18cell17 = row18.getCell(25); 
				if (R18cell17 != null) {
					R18cell17.setCellValue(brf41.getR18_no_of_accounts_non_uae_sharjah() == null ? 0 : brf41.getR18_no_of_accounts_non_uae_sharjah().intValue());
				}
				Cell  R18cell18 = row18.getCell(26); 
				if (R18cell18 != null) {
					R18cell18.setCellValue(brf41.getR18_amount_non_uae_sharjah() == null ? 0 : brf41.getR18_amount_non_uae_sharjah().intValue());
				}
				Cell  R18cell19 = row18.getCell(28); 
				if (R18cell19 != null) {
					R18cell19.setCellValue(brf41.getR18_no_of_accounts_uae_ajman() == null ? 0 : brf41.getR18_no_of_accounts_uae_ajman().intValue());
				}

				Cell  R18cell20 = row18.getCell(29); 
				if (R18cell20 != null) {
					R18cell20.setCellValue(brf41.getR18_amount_uae_ajman() == null ? 0 : brf41.getR18_amount_uae_ajman().intValue());
				}
				Cell  R18cell21 = row18.getCell(30); 
				if (R18cell21 != null) {
					R18cell21.setCellValue(brf41.getR18_no_of_accounts_non_uae_ajman() == null ? 0 : brf41.getR18_no_of_accounts_non_uae_ajman().intValue());
				}

				Cell R18cell22 = row18.getCell(31); 
				if (R18cell22 != null) {
					R18cell22.setCellValue(brf41.getR18_amount_non_uae_ajman() == null ? 0 : brf41.getR18_amount_non_uae_ajman().intValue());
				}
				Cell  R18cell23 = row18.getCell(33); 
				if (R18cell23 != null) {
					R18cell23.setCellValue(brf41.getR18_no_of_accounts_uae_ras() == null ? 0 : brf41.getR18_no_of_accounts_uae_ras().intValue());
				}
				Cell R18cell24 = row18.getCell(34); 
				if (R18cell24 != null) {
					R18cell24.setCellValue(brf41.getR18_amount_uae_ras() == null ? 0 : brf41.getR18_amount_uae_ras().intValue());
				}
				Cell  R18cell25 = row18.getCell(35); 
				if (R18cell25 != null) {
					R18cell25.setCellValue(brf41.getR18_no_of_accounts_non_uae_ras() == null ? 0 : brf41.getR18_no_of_accounts_non_uae_ras().intValue());
				}
				Cell  R18cell26 = row18.getCell(36); 
				if (R18cell26 != null) {
					R18cell26.setCellValue(brf41.getR18_amount_non_uae_ras() == null ? 0 : brf41.getR18_amount_non_uae_ras().intValue());
				}
				Cell  R18cell27 = row18.getCell(38); 
				if (R18cell27 != null) {
					R18cell27.setCellValue(brf41.getR18_no_of_accounts_uae_umm() == null ? 0 : brf41.getR18_no_of_accounts_uae_umm().intValue());
				}
				Cell  R18cell28 = row18.getCell(39); 
				if (R18cell28 != null) {
					R18cell28.setCellValue(brf41.getR18_amount_uae_umm() == null ? 0 : brf41.getR18_amount_uae_umm().intValue());
				}
				Cell  R18cell29 = row18.getCell(40); 
				if (R18cell29 != null) {
					R18cell29.setCellValue(brf41.getR18_no_of_accounts_non_uae_umm() == null ? 0 : brf41.getR18_no_of_accounts_non_uae_umm().intValue());
				}
				Cell  R18cell30 = row18.getCell(41); 
				if (R18cell30 != null) {
					R18cell30.setCellValue(brf41.getR18_amount_non_uae_umm() == null ? 0 : brf41.getR18_amount_non_uae_umm().intValue());
				}
				Cell  R18cell31 = row18.getCell(43); 
				if (R18cell31 != null) {
					R18cell31.setCellValue(brf41.getR18_no_of_accounts_uae_fujairah() == null ? 0 : brf41.getR18_no_of_accounts_uae_fujairah().intValue());
				}
				Cell  R18cell32 = row18.getCell(44); 
				if (R18cell32 != null) {
					R18cell32.setCellValue(brf41.getR18_amount_uae_fujairah() == null ? 0 : brf41.getR18_amount_uae_fujairah().intValue());
				}
				Cell  R18cell33 = row18.getCell(45); 
				if (R18cell33 != null) {
					R18cell33.setCellValue(brf41.getR18_no_of_accounts_non_uae_fujairah() == null ? 0 : brf41.getR18_no_of_accounts_non_uae_fujairah().intValue());
				}
										
				Cell  R18cell34 = row18.getCell(46); 
				if (R18cell34 != null) {
					R18cell34.setCellValue(brf41.getR18_amount_non_uae_fujairah() == null ? 0 : brf41.getR18_amount_non_uae_fujairah().intValue());
				}
			///ROW19
			  Row row19 = sheet.getRow(18);
			  Cell R19cell1 = row19.getCell(4); 
				if (R19cell1 != null) {
					R19cell1.setCellValue(brf41.getR19_no_of_accounts_uae() == null ? 0 : brf41.getR19_no_of_accounts_uae().intValue());
				}
				Cell R19cell2 = row19.getCell(5); 
				if (R19cell2 != null) {
					R19cell2.setCellValue(brf41.getR19_amount_uae() == null ? 0 : brf41.getR19_amount_uae().intValue());
				}
				Cell R19cell3 = row19.getCell(6); 
				if (R19cell3 != null) {
					R19cell3.setCellValue(brf41.getR19_no_of_accounts_resident() == null ? 0 : brf41.getR19_no_of_accounts_resident().intValue());
				}
				Cell R19cell4 = row19.getCell(7); 
				if (R19cell4 != null) {
					R19cell4.setCellValue(brf41.getR19_amount_resident() == null ? 0 : brf41.getR19_amount_resident().intValue());
				}
				Cell R19cell5 = row19.getCell(8); 
				if (R19cell5 != null) {
					R19cell5.setCellValue(brf41.getR19_no_of_accounts_non_resident() == null ? 0 : brf41.getR19_no_of_accounts_non_resident().intValue());
				}
				Cell R19cell6 = row19.getCell(9); 
				if (R19cell6 != null) {
					R19cell6.setCellValue(brf41.getR19_amount_non_resident() == null ? 0 : brf41.getR19_amount_non_resident().intValue());
				}
				Cell R19cell7 = row19.getCell(13); 
				if (R19cell7 != null) {
					R19cell7.setCellValue(brf41.getR19_no_of_accounts_uae_abu() == null ? 0 : brf41.getR19_no_of_accounts_uae_abu().intValue());
				}
				Cell R19cell8 = row19.getCell(14); 
				if (R19cell8 != null) {
					R19cell8.setCellValue(brf41.getR19_amount_uae_abu() == null ? 0 : brf41.getR19_amount_uae_abu().intValue());
				}
				Cell R19cell9 = row19.getCell(15); 
				if (R19cell9 != null) {
					R19cell9.setCellValue(brf41.getR19_no_of_accounts_non_uae_abu() == null ? 0 : brf41.getR19_no_of_accounts_non_uae_abu().intValue());
				}
				Cell R19cell10 = row19.getCell(16); 
				if (R19cell10 != null) {
					R19cell10.setCellValue(brf41.getR19_amount_non_uae_abu() == null ? 0 : brf41.getR19_amount_non_uae_abu().intValue());
				}

				Cell R19cell11 = row19.getCell(18); 
				if (R19cell11 != null) {
					R19cell11.setCellValue(brf41.getR19_no_of_accounts_uae_dubai() == null ? 0 : brf41.getR19_no_of_accounts_uae_dubai().intValue());
				}
				Cell R19cell12 = row19.getCell(19); 
				if (R19cell12 != null) {
					R19cell12.setCellValue(brf41.getR19_amount_uae_dubai() == null ? 0 : brf41.getR19_amount_uae_dubai().intValue());
				}

				Cell R19cell13 = row19.getCell(20); 
				if (R19cell13 != null) {
					R19cell13.setCellValue(brf41.getR19_no_of_accounts_non_uae_dubai() == null ? 0 : brf41.getR19_no_of_accounts_non_uae_dubai().intValue());
				}
				Cell R19cell14 = row19.getCell(21); 
				if (R19cell14 != null) {
					R19cell14.setCellValue(brf41.getR19_amount_non_uae_dubai() == null ? 0 : brf41.getR19_amount_non_uae_dubai().intValue());
				}
				Cell R19cell15 = row19.getCell(23); 
				if (R19cell15 != null) {
					R19cell15.setCellValue(brf41.getR19_no_of_accounts_uae_sharjah() == null ? 0 : brf41.getR19_no_of_accounts_uae_sharjah().intValue());
				}
				Cell R19cell16 = row19.getCell(24); 
				if (R19cell16 != null) {
					R19cell16.setCellValue(brf41.getR19_amount_uae_sharjah() == null ? 0 : brf41.getR19_amount_uae_sharjah().intValue());
				}
				Cell  R19cell17 = row19.getCell(25); 
				if (R19cell17 != null) {
					R19cell17.setCellValue(brf41.getR19_no_of_accounts_non_uae_sharjah() == null ? 0 : brf41.getR19_no_of_accounts_non_uae_sharjah().intValue());
				}
				Cell  R19cell18 = row19.getCell(26); 
				if (R19cell18 != null) {
					R19cell18.setCellValue(brf41.getR19_amount_non_uae_sharjah() == null ? 0 : brf41.getR19_amount_non_uae_sharjah().intValue());
				}
				Cell  R19cell19 = row19.getCell(28); 
				if (R19cell19 != null) {
					R19cell19.setCellValue(brf41.getR19_no_of_accounts_uae_ajman() == null ? 0 : brf41.getR19_no_of_accounts_uae_ajman().intValue());
				}

				Cell  R19cell20 = row19.getCell(29); 
				if (R19cell20 != null) {
					R19cell20.setCellValue(brf41.getR19_amount_uae_ajman() == null ? 0 : brf41.getR19_amount_uae_ajman().intValue());
				}
				Cell  R19cell21 = row19.getCell(30); 
				if (R19cell21 != null) {
					R19cell21.setCellValue(brf41.getR19_no_of_accounts_non_uae_ajman() == null ? 0 : brf41.getR19_no_of_accounts_non_uae_ajman().intValue());
				}

				Cell R19cell22 = row19.getCell(31); 
				if (R19cell22 != null) {
					R19cell22.setCellValue(brf41.getR19_amount_non_uae_ajman() == null ? 0 : brf41.getR19_amount_non_uae_ajman().intValue());
				}
				Cell  R19cell23 = row19.getCell(33); 
				if (R19cell23 != null) {
					R19cell23.setCellValue(brf41.getR19_no_of_accounts_uae_ras() == null ? 0 : brf41.getR19_no_of_accounts_uae_ras().intValue());
				}
				Cell R19cell24 = row19.getCell(34); 
				if (R19cell24 != null) {
					R19cell24.setCellValue(brf41.getR19_amount_uae_ras() == null ? 0 : brf41.getR19_amount_uae_ras().intValue());
				}
				Cell  R19cell25 = row19.getCell(35); 
				if (R19cell25 != null) {
					R19cell25.setCellValue(brf41.getR19_no_of_accounts_non_uae_ras() == null ? 0 : brf41.getR19_no_of_accounts_non_uae_ras().intValue());
				}
				Cell  R19cell26 = row19.getCell(36); 
				if (R19cell26 != null) {
					R19cell26.setCellValue(brf41.getR19_amount_non_uae_ras() == null ? 0 : brf41.getR19_amount_non_uae_ras().intValue());
				}
				Cell  R19cell27 = row19.getCell(38); 
				if (R19cell27 != null) {
					R19cell27.setCellValue(brf41.getR19_no_of_accounts_uae_umm() == null ? 0 : brf41.getR19_no_of_accounts_uae_umm().intValue());
				}
				Cell  R19cell28 = row19.getCell(39); 
				if (R19cell28 != null) {
					R19cell28.setCellValue(brf41.getR19_amount_uae_umm() == null ? 0 : brf41.getR19_amount_uae_umm().intValue());
				}
				Cell  R19cell29 = row19.getCell(40); 
				if (R19cell29 != null) {
					R19cell29.setCellValue(brf41.getR19_no_of_accounts_non_uae_umm() == null ? 0 : brf41.getR19_no_of_accounts_non_uae_umm().intValue());
				}
				Cell  R19cell30 = row19.getCell(41); 
				if (R19cell30 != null) {
					R19cell30.setCellValue(brf41.getR19_amount_non_uae_umm() == null ? 0 : brf41.getR19_amount_non_uae_umm().intValue());
				}
				Cell  R19cell31 = row19.getCell(43); 
				if (R19cell31 != null) {
					R19cell31.setCellValue(brf41.getR19_no_of_accounts_uae_fujairah() == null ? 0 : brf41.getR19_no_of_accounts_uae_fujairah().intValue());
				}
				Cell  R19cell32 = row19.getCell(44); 
				if (R19cell32 != null) {
					R19cell32.setCellValue(brf41.getR19_amount_uae_fujairah() == null ? 0 : brf41.getR19_amount_uae_fujairah().intValue());
				}
				Cell  R19cell33 = row19.getCell(45); 
				if (R19cell33 != null) {
					R19cell33.setCellValue(brf41.getR19_no_of_accounts_non_uae_fujairah() == null ? 0 : brf41.getR19_no_of_accounts_non_uae_fujairah().intValue());
				}
										
				Cell  R19cell34 = row19.getCell(46); 
				if (R19cell34 != null) {
					R19cell34.setCellValue(brf41.getR19_amount_non_uae_fujairah() == null ? 0 : brf41.getR19_amount_non_uae_fujairah().intValue());
				}
			///ROW22
			  Row row22 = sheet.getRow(21);
			  Cell R22cell1 = row22.getCell(4); 
				if (R22cell1 != null) {
					R22cell1.setCellValue(brf41.getR22_no_of_accounts_uae() == null ? 0 : brf41.getR22_no_of_accounts_uae().intValue());
				}
				Cell R22cell2 = row22.getCell(5); 
				if (R22cell2 != null) {
					R22cell2.setCellValue(brf41.getR22_amount_uae() == null ? 0 : brf41.getR22_amount_uae().intValue());
				}
				Cell R22cell3 = row22.getCell(6); 
				if (R22cell3 != null) {
					R22cell3.setCellValue(brf41.getR22_no_of_accounts_resident() == null ? 0 : brf41.getR22_no_of_accounts_resident().intValue());
				}
				Cell R22cell4 = row22.getCell(7); 
				if (R22cell4 != null) {
					R22cell4.setCellValue(brf41.getR22_amount_resident() == null ? 0 : brf41.getR22_amount_resident().intValue());
				}
				Cell R22cell5 = row22.getCell(8); 
				if (R22cell5 != null) {
					R22cell5.setCellValue(brf41.getR22_no_of_accounts_non_resident() == null ? 0 : brf41.getR22_no_of_accounts_non_resident().intValue());
				}
				Cell R22cell6 = row22.getCell(9); 
				if (R22cell6 != null) {
					R22cell6.setCellValue(brf41.getR22_amount_non_resident() == null ? 0 : brf41.getR22_amount_non_resident().intValue());
				}
				Cell R22cell7 = row22.getCell(13); 
				if (R22cell7 != null) {
					R22cell7.setCellValue(brf41.getR22_no_of_accounts_uae_abu() == null ? 0 : brf41.getR22_no_of_accounts_uae_abu().intValue());
				}
				Cell R22cell8 = row22.getCell(14); 
				if (R22cell8 != null) {
					R22cell8.setCellValue(brf41.getR22_amount_uae_abu() == null ? 0 : brf41.getR22_amount_uae_abu().intValue());
				}
				Cell R22cell9 = row22.getCell(15); 
				if (R22cell9 != null) {
					R22cell9.setCellValue(brf41.getR22_no_of_accounts_non_uae_abu() == null ? 0 : brf41.getR22_no_of_accounts_non_uae_abu().intValue());
				}
				Cell R22cell10 = row22.getCell(16); 
				if (R22cell10 != null) {
					R22cell10.setCellValue(brf41.getR22_amount_non_uae_abu() == null ? 0 : brf41.getR22_amount_non_uae_abu().intValue());
				}

				Cell R22cell11 = row22.getCell(18); 
				if (R22cell11 != null) {
					R22cell11.setCellValue(brf41.getR22_no_of_accounts_uae_dubai() == null ? 0 : brf41.getR22_no_of_accounts_uae_dubai().intValue());
				}
				Cell R22cell12 = row22.getCell(19); 
				if (R22cell12 != null) {
					R22cell12.setCellValue(brf41.getR22_amount_uae_dubai() == null ? 0 : brf41.getR22_amount_uae_dubai().intValue());
				}

				Cell R22cell13 = row22.getCell(20); 
				if (R22cell13 != null) {
					R22cell13.setCellValue(brf41.getR22_no_of_accounts_non_uae_dubai() == null ? 0 : brf41.getR22_no_of_accounts_non_uae_dubai().intValue());
				}
				Cell R22cell14 = row22.getCell(21); 
				if (R22cell14 != null) {
					R22cell14.setCellValue(brf41.getR22_amount_non_uae_dubai() == null ? 0 : brf41.getR22_amount_non_uae_dubai().intValue());
				}
				Cell R22cell15 = row22.getCell(23); 
				if (R22cell15 != null) {
					R22cell15.setCellValue(brf41.getR22_no_of_accounts_uae_sharjah() == null ? 0 : brf41.getR22_no_of_accounts_uae_sharjah().intValue());
				}
				Cell R22cell16 = row22.getCell(24); 
				if (R22cell16 != null) {
					R22cell16.setCellValue(brf41.getR22_amount_uae_sharjah() == null ? 0 : brf41.getR22_amount_uae_sharjah().intValue());
				}
				Cell  R22cell17 = row22.getCell(25); 
				if (R22cell17 != null) {
					R22cell17.setCellValue(brf41.getR22_no_of_accounts_non_uae_sharjah() == null ? 0 : brf41.getR22_no_of_accounts_non_uae_sharjah().intValue());
				}
				Cell  R22cell18 = row22.getCell(26); 
				if (R22cell18 != null) {
					R22cell18.setCellValue(brf41.getR22_amount_non_uae_sharjah() == null ? 0 : brf41.getR22_amount_non_uae_sharjah().intValue());
				}
				Cell  R22cell19 = row22.getCell(28); 
				if (R22cell19 != null) {
					R22cell19.setCellValue(brf41.getR22_no_of_accounts_uae_ajman() == null ? 0 : brf41.getR22_no_of_accounts_uae_ajman().intValue());
				}

				Cell  R22cell20 = row22.getCell(29); 
				if (R22cell20 != null) {
					R22cell20.setCellValue(brf41.getR22_amount_uae_ajman() == null ? 0 : brf41.getR22_amount_uae_ajman().intValue());
				}
				Cell  R22cell21 = row22.getCell(30); 
				if (R22cell21 != null) {
					R22cell21.setCellValue(brf41.getR22_no_of_accounts_non_uae_ajman() == null ? 0 : brf41.getR22_no_of_accounts_non_uae_ajman().intValue());
				}

				Cell R22cell22 = row22.getCell(31); 
				if (R22cell22 != null) {
					R22cell22.setCellValue(brf41.getR22_amount_non_uae_ajman() == null ? 0 : brf41.getR22_amount_non_uae_ajman().intValue());
				}
				Cell  R22cell23 = row22.getCell(33); 
				if (R22cell23 != null) {
					R22cell23.setCellValue(brf41.getR22_no_of_accounts_uae_ras() == null ? 0 : brf41.getR22_no_of_accounts_uae_ras().intValue());
				}
				Cell R22cell24 = row22.getCell(34); 
				if (R22cell24 != null) {
					R22cell24.setCellValue(brf41.getR22_amount_uae_ras() == null ? 0 : brf41.getR22_amount_uae_ras().intValue());
				}
				Cell  R22cell25 = row22.getCell(35); 
				if (R22cell25 != null) {
					R22cell25.setCellValue(brf41.getR22_no_of_accounts_non_uae_ras() == null ? 0 : brf41.getR22_no_of_accounts_non_uae_ras().intValue());
				}
				Cell  R22cell26 = row22.getCell(36); 
				if (R22cell26 != null) {
					R22cell26.setCellValue(brf41.getR22_amount_non_uae_ras() == null ? 0 : brf41.getR22_amount_non_uae_ras().intValue());
				}
				Cell  R22cell27 = row22.getCell(38); 
				if (R22cell27 != null) {
					R22cell27.setCellValue(brf41.getR22_no_of_accounts_uae_umm() == null ? 0 : brf41.getR22_no_of_accounts_uae_umm().intValue());
				}
				Cell  R22cell28 = row22.getCell(39); 
				if (R22cell28 != null) {
					R22cell28.setCellValue(brf41.getR22_amount_uae_umm() == null ? 0 : brf41.getR22_amount_uae_umm().intValue());
				}
				Cell  R22cell29 = row22.getCell(40); 
				if (R22cell29 != null) {
					R22cell29.setCellValue(brf41.getR22_no_of_accounts_non_uae_umm() == null ? 0 : brf41.getR22_no_of_accounts_non_uae_umm().intValue());
				}
				Cell  R22cell30 = row22.getCell(41); 
				if (R22cell30 != null) {
					R22cell30.setCellValue(brf41.getR22_amount_non_uae_umm() == null ? 0 : brf41.getR22_amount_non_uae_umm().intValue());
				}
				Cell  R22cell31 = row22.getCell(43); 
				if (R22cell31 != null) {
					R22cell31.setCellValue(brf41.getR22_no_of_accounts_uae_fujairah() == null ? 0 : brf41.getR22_no_of_accounts_uae_fujairah().intValue());
				}
				Cell  R22cell32 = row22.getCell(44); 
				if (R22cell32 != null) {
					R22cell32.setCellValue(brf41.getR22_amount_uae_fujairah() == null ? 0 : brf41.getR22_amount_uae_fujairah().intValue());
				}
				Cell  R22cell33 = row22.getCell(45); 
				if (R22cell33 != null) {
					R22cell33.setCellValue(brf41.getR22_no_of_accounts_non_uae_fujairah() == null ? 0 : brf41.getR22_no_of_accounts_non_uae_fujairah().intValue());
				}
										
				Cell  R22cell34 = row22.getCell(46); 
				if (R22cell34 != null) {
					R22cell34.setCellValue(brf41.getR22_amount_non_uae_fujairah() == null ? 0 : brf41.getR22_amount_non_uae_fujairah().intValue());
				}
			///ROW23
			  Row row23 = sheet.getRow(22);
			  Cell R23cell1 = row23.getCell(4); 
				if (R23cell1 != null) {
					R23cell1.setCellValue(brf41.getR23_no_of_accounts_uae() == null ? 0 : brf41.getR23_no_of_accounts_uae().intValue());
				}
				Cell R23cell2 = row23.getCell(5); 
				if (R23cell2 != null) {
					R23cell2.setCellValue(brf41.getR23_amount_uae() == null ? 0 : brf41.getR23_amount_uae().intValue());
				}
				Cell R23cell3 = row23.getCell(6); 
				if (R23cell3 != null) {
					R23cell3.setCellValue(brf41.getR23_no_of_accounts_resident() == null ? 0 : brf41.getR23_no_of_accounts_resident().intValue());
				}
				Cell R23cell4 = row23.getCell(7); 
				if (R23cell4 != null) {
					R23cell4.setCellValue(brf41.getR23_amount_resident() == null ? 0 : brf41.getR23_amount_resident().intValue());
				}
				Cell R23cell5 = row23.getCell(8); 
				if (R23cell5 != null) {
					R23cell5.setCellValue(brf41.getR23_no_of_accounts_non_resident() == null ? 0 : brf41.getR23_no_of_accounts_non_resident().intValue());
				}
				Cell R23cell6 = row23.getCell(9); 
				if (R23cell6 != null) {
					R23cell6.setCellValue(brf41.getR23_amount_non_resident() == null ? 0 : brf41.getR23_amount_non_resident().intValue());
				}
				Cell R23cell7 = row23.getCell(13); 
				if (R23cell7 != null) {
					R23cell7.setCellValue(brf41.getR23_no_of_accounts_uae_abu() == null ? 0 : brf41.getR23_no_of_accounts_uae_abu().intValue());
				}
				Cell R23cell8 = row23.getCell(14); 
				if (R23cell8 != null) {
					R23cell8.setCellValue(brf41.getR23_amount_uae_abu() == null ? 0 : brf41.getR23_amount_uae_abu().intValue());
				}
				Cell R23cell9 = row23.getCell(15); 
				if (R23cell9 != null) {
					R23cell9.setCellValue(brf41.getR23_no_of_accounts_non_uae_abu() == null ? 0 : brf41.getR23_no_of_accounts_non_uae_abu().intValue());
				}
				Cell R23cell10 = row23.getCell(16); 
				if (R23cell10 != null) {
					R23cell10.setCellValue(brf41.getR23_amount_non_uae_abu() == null ? 0 : brf41.getR23_amount_non_uae_abu().intValue());
				}

				Cell R23cell11 = row23.getCell(18); 
				if (R23cell11 != null) {
					R23cell11.setCellValue(brf41.getR23_no_of_accounts_uae_dubai() == null ? 0 : brf41.getR23_no_of_accounts_uae_dubai().intValue());
				}
				Cell R23cell12 = row23.getCell(19); 
				if (R23cell12 != null) {
					R23cell12.setCellValue(brf41.getR23_amount_uae_dubai() == null ? 0 : brf41.getR23_amount_uae_dubai().intValue());
				}

				Cell R23cell13 = row23.getCell(20); 
				if (R23cell13 != null) {
					R23cell13.setCellValue(brf41.getR23_no_of_accounts_non_uae_dubai() == null ? 0 : brf41.getR23_no_of_accounts_non_uae_dubai().intValue());
				}
				Cell R23cell14 = row23.getCell(21); 
				if (R23cell14 != null) {
					R23cell14.setCellValue(brf41.getR23_amount_non_uae_dubai() == null ? 0 : brf41.getR23_amount_non_uae_dubai().intValue());
				}
				Cell R23cell15 = row23.getCell(23); 
				if (R23cell15 != null) {
					R23cell15.setCellValue(brf41.getR23_no_of_accounts_uae_sharjah() == null ? 0 : brf41.getR23_no_of_accounts_uae_sharjah().intValue());
				}
				Cell R23cell16 = row23.getCell(24); 
				if (R23cell16 != null) {
					R23cell16.setCellValue(brf41.getR23_amount_uae_sharjah() == null ? 0 : brf41.getR23_amount_uae_sharjah().intValue());
				}
				Cell  R23cell17 = row23.getCell(25); 
				if (R23cell17 != null) {
					R23cell17.setCellValue(brf41.getR23_no_of_accounts_non_uae_sharjah() == null ? 0 : brf41.getR23_no_of_accounts_non_uae_sharjah().intValue());
				}
				Cell  R23cell18 = row23.getCell(26); 
				if (R23cell18 != null) {
					R23cell18.setCellValue(brf41.getR23_amount_non_uae_sharjah() == null ? 0 : brf41.getR23_amount_non_uae_sharjah().intValue());
				}
				Cell  R23cell19 = row23.getCell(28); 
				if (R23cell19 != null) {
					R23cell19.setCellValue(brf41.getR23_no_of_accounts_uae_ajman() == null ? 0 : brf41.getR23_no_of_accounts_uae_ajman().intValue());
				}

				Cell  R23cell20 = row23.getCell(29); 
				if (R23cell20 != null) {
					R23cell20.setCellValue(brf41.getR23_amount_uae_ajman() == null ? 0 : brf41.getR23_amount_uae_ajman().intValue());
				}
				Cell  R23cell21 = row23.getCell(30); 
				if (R23cell21 != null) {
					R23cell21.setCellValue(brf41.getR23_no_of_accounts_non_uae_ajman() == null ? 0 : brf41.getR23_no_of_accounts_non_uae_ajman().intValue());
				}

				Cell R23cell22 = row23.getCell(31); 
				if (R23cell22 != null) {
					R23cell22.setCellValue(brf41.getR23_amount_non_uae_ajman() == null ? 0 : brf41.getR23_amount_non_uae_ajman().intValue());
				}
				Cell  R23cell23 = row23.getCell(33); 
				if (R23cell23 != null) {
					R23cell23.setCellValue(brf41.getR23_no_of_accounts_uae_ras() == null ? 0 : brf41.getR23_no_of_accounts_uae_ras().intValue());
				}
				Cell R23cell24 = row23.getCell(34); 
				if (R23cell24 != null) {
					R23cell24.setCellValue(brf41.getR23_amount_uae_ras() == null ? 0 : brf41.getR23_amount_uae_ras().intValue());
				}
				Cell  R23cell25 = row23.getCell(35); 
				if (R23cell25 != null) {
					R23cell25.setCellValue(brf41.getR23_no_of_accounts_non_uae_ras() == null ? 0 : brf41.getR23_no_of_accounts_non_uae_ras().intValue());
				}
				Cell  R23cell26 = row23.getCell(36); 
				if (R23cell26 != null) {
					R23cell26.setCellValue(brf41.getR23_amount_non_uae_ras() == null ? 0 : brf41.getR23_amount_non_uae_ras().intValue());
				}
				Cell  R23cell27 = row23.getCell(38); 
				if (R23cell27 != null) {
					R23cell27.setCellValue(brf41.getR23_no_of_accounts_uae_umm() == null ? 0 : brf41.getR23_no_of_accounts_uae_umm().intValue());
				}
				Cell  R23cell28 = row23.getCell(39); 
				if (R23cell28 != null) {
					R23cell28.setCellValue(brf41.getR23_amount_uae_umm() == null ? 0 : brf41.getR23_amount_uae_umm().intValue());
				}
				Cell  R23cell29 = row23.getCell(40); 
				if (R23cell29 != null) {
					R23cell29.setCellValue(brf41.getR23_no_of_accounts_non_uae_umm() == null ? 0 : brf41.getR23_no_of_accounts_non_uae_umm().intValue());
				}
				Cell  R23cell30 = row23.getCell(41); 
				if (R23cell30 != null) {
					R23cell30.setCellValue(brf41.getR23_amount_non_uae_umm() == null ? 0 : brf41.getR23_amount_non_uae_umm().intValue());
				}
				Cell  R23cell31 = row23.getCell(43); 
				if (R23cell31 != null) {
					R23cell31.setCellValue(brf41.getR23_no_of_accounts_uae_fujairah() == null ? 0 : brf41.getR23_no_of_accounts_uae_fujairah().intValue());
				}
				Cell  R23cell32 = row23.getCell(44); 
				if (R23cell32 != null) {
					R23cell32.setCellValue(brf41.getR23_amount_uae_fujairah() == null ? 0 : brf41.getR23_amount_uae_fujairah().intValue());
				}
				Cell  R23cell33 = row23.getCell(45); 
				if (R23cell33 != null) {
					R23cell33.setCellValue(brf41.getR23_no_of_accounts_non_uae_fujairah() == null ? 0 : brf41.getR23_no_of_accounts_non_uae_fujairah().intValue());
				}
										
				Cell  R23cell34 = row23.getCell(46); 
				if (R23cell34 != null) {
					R23cell34.setCellValue(brf41.getR23_amount_non_uae_fujairah() == null ? 0 : brf41.getR23_amount_non_uae_fujairah().intValue());
				}
			///ROW24
			  Row row24 = sheet.getRow(23);
			  Cell R24cell1 = row24.getCell(4); 
				if (R24cell1 != null) {
					R24cell1.setCellValue(brf41.getR24_no_of_accounts_uae() == null ? 0 : brf41.getR24_no_of_accounts_uae().intValue());
				}
				Cell R24cell2 = row24.getCell(5); 
				if (R24cell2 != null) {
					R24cell2.setCellValue(brf41.getR24_amount_uae() == null ? 0 : brf41.getR24_amount_uae().intValue());
				}
				Cell R24cell3 = row24.getCell(6); 
				if (R24cell3 != null) {
					R24cell3.setCellValue(brf41.getR24_no_of_accounts_resident() == null ? 0 : brf41.getR24_no_of_accounts_resident().intValue());
				}
				Cell R24cell4 = row24.getCell(7); 
				if (R24cell4 != null) {
					R24cell4.setCellValue(brf41.getR24_amount_resident() == null ? 0 : brf41.getR24_amount_resident().intValue());
				}
				Cell R24cell5 = row24.getCell(8); 
				if (R24cell5 != null) {
					R24cell5.setCellValue(brf41.getR24_no_of_accounts_non_resident() == null ? 0 : brf41.getR24_no_of_accounts_non_resident().intValue());
				}
				Cell R24cell6 = row24.getCell(9); 
				if (R24cell6 != null) {
					R24cell6.setCellValue(brf41.getR24_amount_non_resident() == null ? 0 : brf41.getR24_amount_non_resident().intValue());
				}
				Cell R24cell7 = row24.getCell(13); 
				if (R24cell7 != null) {
					R24cell7.setCellValue(brf41.getR24_no_of_accounts_uae_abu() == null ? 0 : brf41.getR24_no_of_accounts_uae_abu().intValue());
				}
				Cell R24cell8 = row24.getCell(14); 
				if (R24cell8 != null) {
					R24cell8.setCellValue(brf41.getR24_amount_uae_abu() == null ? 0 : brf41.getR24_amount_uae_abu().intValue());
				}
				Cell R24cell9 = row24.getCell(15); 
				if (R24cell9 != null) {
					R24cell9.setCellValue(brf41.getR24_no_of_accounts_non_uae_abu() == null ? 0 : brf41.getR24_no_of_accounts_non_uae_abu().intValue());
				}
				Cell R24cell10 = row24.getCell(16); 
				if (R24cell10 != null) {
					R24cell10.setCellValue(brf41.getR24_amount_non_uae_abu() == null ? 0 : brf41.getR24_amount_non_uae_abu().intValue());
				}

				Cell R24cell11 = row24.getCell(18); 
				if (R24cell11 != null) {
					R24cell11.setCellValue(brf41.getR24_no_of_accounts_uae_dubai() == null ? 0 : brf41.getR24_no_of_accounts_uae_dubai().intValue());
				}
				Cell R24cell12 = row24.getCell(19); 
				if (R24cell12 != null) {
					R24cell12.setCellValue(brf41.getR24_amount_uae_dubai() == null ? 0 : brf41.getR24_amount_uae_dubai().intValue());
				}

				Cell R24cell13 = row24.getCell(20); 
				if (R24cell13 != null) {
					R24cell13.setCellValue(brf41.getR24_no_of_accounts_non_uae_dubai() == null ? 0 : brf41.getR24_no_of_accounts_non_uae_dubai().intValue());
				}
				Cell R24cell14 = row24.getCell(21); 
				if (R24cell14 != null) {
					R24cell14.setCellValue(brf41.getR24_amount_non_uae_dubai() == null ? 0 : brf41.getR24_amount_non_uae_dubai().intValue());
				}
				Cell R24cell15 = row24.getCell(23); 
				if (R24cell15 != null) {
					R24cell15.setCellValue(brf41.getR24_no_of_accounts_uae_sharjah() == null ? 0 : brf41.getR24_no_of_accounts_uae_sharjah().intValue());
				}
				Cell R24cell16 = row24.getCell(24); 
				if (R24cell16 != null) {
					R24cell16.setCellValue(brf41.getR24_amount_uae_sharjah() == null ? 0 : brf41.getR24_amount_uae_sharjah().intValue());
				}
				Cell  R24cell17 = row24.getCell(25); 
				if (R24cell17 != null) {
					R24cell17.setCellValue(brf41.getR24_no_of_accounts_non_uae_sharjah() == null ? 0 : brf41.getR24_no_of_accounts_non_uae_sharjah().intValue());
				}
				Cell  R24cell18 = row24.getCell(26); 
				if (R24cell18 != null) {
					R24cell18.setCellValue(brf41.getR24_amount_non_uae_sharjah() == null ? 0 : brf41.getR24_amount_non_uae_sharjah().intValue());
				}
				Cell  R24cell19 = row24.getCell(28); 
				if (R24cell19 != null) {
					R24cell19.setCellValue(brf41.getR24_no_of_accounts_uae_ajman() == null ? 0 : brf41.getR24_no_of_accounts_uae_ajman().intValue());
				}

				Cell  R24cell20 = row24.getCell(29); 
				if (R24cell20 != null) {
					R24cell20.setCellValue(brf41.getR24_amount_uae_ajman() == null ? 0 : brf41.getR24_amount_uae_ajman().intValue());
				}
				Cell  R24cell21 = row24.getCell(30); 
				if (R24cell21 != null) {
					R24cell21.setCellValue(brf41.getR24_no_of_accounts_non_uae_ajman() == null ? 0 : brf41.getR24_no_of_accounts_non_uae_ajman().intValue());
				}

				Cell R24cell22 = row24.getCell(31); 
				if (R24cell22 != null) {
					R24cell22.setCellValue(brf41.getR24_amount_non_uae_ajman() == null ? 0 : brf41.getR24_amount_non_uae_ajman().intValue());
				}
				Cell  R24cell23 = row24.getCell(33); 
				if (R24cell23 != null) {
					R24cell23.setCellValue(brf41.getR24_no_of_accounts_uae_ras() == null ? 0 : brf41.getR24_no_of_accounts_uae_ras().intValue());
				}
				Cell R24cell24 = row24.getCell(34); 
				if (R24cell24 != null) {
					R24cell24.setCellValue(brf41.getR24_amount_uae_ras() == null ? 0 : brf41.getR24_amount_uae_ras().intValue());
				}
				Cell  R24cell25 = row24.getCell(35); 
				if (R24cell25 != null) {
					R24cell25.setCellValue(brf41.getR24_no_of_accounts_non_uae_ras() == null ? 0 : brf41.getR24_no_of_accounts_non_uae_ras().intValue());
				}
				Cell  R24cell26 = row24.getCell(36); 
				if (R24cell26 != null) {
					R24cell26.setCellValue(brf41.getR24_amount_non_uae_ras() == null ? 0 : brf41.getR24_amount_non_uae_ras().intValue());
				}
				Cell  R24cell27 = row24.getCell(38); 
				if (R24cell27 != null) {
					R24cell27.setCellValue(brf41.getR24_no_of_accounts_uae_umm() == null ? 0 : brf41.getR24_no_of_accounts_uae_umm().intValue());
				}
				Cell  R24cell28 = row24.getCell(39); 
				if (R24cell28 != null) {
					R24cell28.setCellValue(brf41.getR24_amount_uae_umm() == null ? 0 : brf41.getR24_amount_uae_umm().intValue());
				}
				Cell  R24cell29 = row24.getCell(40); 
				if (R24cell29 != null) {
					R24cell29.setCellValue(brf41.getR24_no_of_accounts_non_uae_umm() == null ? 0 : brf41.getR24_no_of_accounts_non_uae_umm().intValue());
				}
				Cell  R24cell30 = row24.getCell(41); 
				if (R24cell30 != null) {
					R24cell30.setCellValue(brf41.getR24_amount_non_uae_umm() == null ? 0 : brf41.getR24_amount_non_uae_umm().intValue());
				}
				Cell  R24cell31 = row24.getCell(43); 
				if (R24cell31 != null) {
					R24cell31.setCellValue(brf41.getR24_no_of_accounts_uae_fujairah() == null ? 0 : brf41.getR24_no_of_accounts_uae_fujairah().intValue());
				}
				Cell  R24cell32 = row24.getCell(44); 
				if (R24cell32 != null) {
					R24cell32.setCellValue(brf41.getR24_amount_uae_fujairah() == null ? 0 : brf41.getR24_amount_uae_fujairah().intValue());
				}
				Cell  R24cell33 = row24.getCell(45); 
				if (R24cell33 != null) {
					R24cell33.setCellValue(brf41.getR24_no_of_accounts_non_uae_fujairah() == null ? 0 : brf41.getR24_no_of_accounts_non_uae_fujairah().intValue());
				}
										
				Cell  R24cell34 = row24.getCell(46); 
				if (R24cell34 != null) {
					R24cell34.setCellValue(brf41.getR24_amount_non_uae_fujairah() == null ? 0 : brf41.getR24_amount_non_uae_fujairah().intValue());
				} 
    }
}

public void updateSheetWithEntity2Data(Sheet sheet, List<BRF41_Entity2> BRF41_Entity2) {
    if (BRF41_Entity2.size() == 1) {
        BRF41_Entity2 brf41a = BRF41_Entity2.get(0);
        
      ///ROW26
		  Row row26 = sheet.getRow(25);
		  Cell R26cell1 = row26.getCell(4); 
			if (R26cell1 != null) {
				R26cell1.setCellValue(brf41a.getR26_no_of_accounts_uae() == null ? 0 : brf41a.getR26_no_of_accounts_uae().intValue());
			}
			Cell R26cell2 = row26.getCell(5); 
			if (R26cell2 != null) {
				R26cell2.setCellValue(brf41a.getR26_amount_uae() == null ? 0 : brf41a.getR26_amount_uae().intValue());
			}
			Cell R26cell3 = row26.getCell(6); 
			if (R26cell3 != null) {
				R26cell3.setCellValue(brf41a.getR26_no_of_accounts_resident() == null ? 0 : brf41a.getR26_no_of_accounts_resident().intValue());
			}
			Cell R26cell4 = row26.getCell(7); 
			if (R26cell4 != null) {
				R26cell4.setCellValue(brf41a.getR26_amount_resident() == null ? 0 : brf41a.getR26_amount_resident().intValue());
			}
			Cell R26cell5 = row26.getCell(8); 
			if (R26cell5 != null) {
				R26cell5.setCellValue(brf41a.getR26_no_of_accounts_non_resident() == null ? 0 : brf41a.getR26_no_of_accounts_non_resident().intValue());
			}
			Cell R26cell6 = row26.getCell(9); 
			if (R26cell6 != null) {
				R26cell6.setCellValue(brf41a.getR26_amount_non_resident() == null ? 0 : brf41a.getR26_amount_non_resident().intValue());
			}
			Cell R26cell7 = row26.getCell(13); 
			if (R26cell7 != null) {
				R26cell7.setCellValue(brf41a.getR26_no_of_accounts_uae_abu() == null ? 0 : brf41a.getR26_no_of_accounts_uae_abu().intValue());
			}
			Cell R26cell8 = row26.getCell(14); 
			if (R26cell8 != null) {
				R26cell8.setCellValue(brf41a.getR26_amount_uae_abu() == null ? 0 : brf41a.getR26_amount_uae_abu().intValue());
			}
			Cell R26cell9 = row26.getCell(15); 
			if (R26cell9 != null) {
				R26cell9.setCellValue(brf41a.getR26_no_of_accounts_non_uae_abu() == null ? 0 : brf41a.getR26_no_of_accounts_non_uae_abu().intValue());
			}
			Cell R26cell10 = row26.getCell(16); 
			if (R26cell10 != null) {
				R26cell10.setCellValue(brf41a.getR26_amount_non_uae_abu() == null ? 0 : brf41a.getR26_amount_non_uae_abu().intValue());
			}

			Cell R26cell11 = row26.getCell(18); 
			if (R26cell11 != null) {
				R26cell11.setCellValue(brf41a.getR26_no_of_accounts_uae_dubai() == null ? 0 : brf41a.getR26_no_of_accounts_uae_dubai().intValue());
			}
			Cell R26cell12 = row26.getCell(19); 
			if (R26cell12 != null) {
				R26cell12.setCellValue(brf41a.getR26_amount_uae_dubai() == null ? 0 : brf41a.getR26_amount_uae_dubai().intValue());
			}

			Cell R26cell13 = row26.getCell(20); 
			if (R26cell13 != null) {
				R26cell13.setCellValue(brf41a.getR26_no_of_accounts_non_uae_dubai() == null ? 0 : brf41a.getR26_no_of_accounts_non_uae_dubai().intValue());
			}
			Cell R26cell14 = row26.getCell(21); 
			if (R26cell14 != null) {
				R26cell14.setCellValue(brf41a.getR26_amount_non_uae_dubai() == null ? 0 : brf41a.getR26_amount_non_uae_dubai().intValue());
			}
			Cell R26cell15 = row26.getCell(23); 
			if (R26cell15 != null) {
				R26cell15.setCellValue(brf41a.getR26_no_of_accounts_uae_sharjah() == null ? 0 : brf41a.getR26_no_of_accounts_uae_sharjah().intValue());
			}
			Cell R26cell16 = row26.getCell(24); 
			if (R26cell16 != null) {
				R26cell16.setCellValue(brf41a.getR26_amount_uae_sharjah() == null ? 0 : brf41a.getR26_amount_uae_sharjah().intValue());
			}
			Cell  R26cell17 = row26.getCell(25); 
			if (R26cell17 != null) {
				R26cell17.setCellValue(brf41a.getR26_no_of_accounts_non_uae_sharjah() == null ? 0 : brf41a.getR26_no_of_accounts_non_uae_sharjah().intValue());
			}
			Cell  R26cell18 = row26.getCell(26); 
			if (R26cell18 != null) {
				R26cell18.setCellValue(brf41a.getR26_amount_non_uae_sharjah() == null ? 0 : brf41a.getR26_amount_non_uae_sharjah().intValue());
			}
			Cell  R26cell19 = row26.getCell(28); 
			if (R26cell19 != null) {
				R26cell19.setCellValue(brf41a.getR26_no_of_accounts_uae_ajman() == null ? 0 : brf41a.getR26_no_of_accounts_uae_ajman().intValue());
			}

			Cell  R26cell20 = row26.getCell(29); 
			if (R26cell20 != null) {
				R26cell20.setCellValue(brf41a.getR26_amount_uae_ajman() == null ? 0 : brf41a.getR26_amount_uae_ajman().intValue());
			}
			Cell  R26cell21 = row26.getCell(30); 
			if (R26cell21 != null) {
				R26cell21.setCellValue(brf41a.getR26_no_of_accounts_non_uae_ajman() == null ? 0 : brf41a.getR26_no_of_accounts_non_uae_ajman().intValue());
			}

			Cell R26cell22 = row26.getCell(31); 
			if (R26cell22 != null) {
				R26cell22.setCellValue(brf41a.getR26_amount_non_uae_ajman() == null ? 0 : brf41a.getR26_amount_non_uae_ajman().intValue());
			}
			Cell  R26cell23 = row26.getCell(33); 
			if (R26cell23 != null) {
				R26cell23.setCellValue(brf41a.getR26_no_of_accounts_uae_ras() == null ? 0 : brf41a.getR26_no_of_accounts_uae_ras().intValue());
			}
			Cell R26cell24 = row26.getCell(34); 
			if (R26cell24 != null) {
				R26cell24.setCellValue(brf41a.getR26_amount_uae_ras() == null ? 0 : brf41a.getR26_amount_uae_ras().intValue());
			}
			Cell  R26cell25 = row26.getCell(35); 
			if (R26cell25 != null) {
				R26cell25.setCellValue(brf41a.getR26_no_of_accounts_non_uae_ras() == null ? 0 : brf41a.getR26_no_of_accounts_non_uae_ras().intValue());
			}
			Cell  R26cell26 = row26.getCell(36); 
			if (R26cell26 != null) {
				R26cell26.setCellValue(brf41a.getR26_amount_non_uae_ras() == null ? 0 : brf41a.getR26_amount_non_uae_ras().intValue());
			}
			Cell  R26cell27 = row26.getCell(38); 
			if (R26cell27 != null) {
				R26cell27.setCellValue(brf41a.getR26_no_of_accounts_uae_umm() == null ? 0 : brf41a.getR26_no_of_accounts_uae_umm().intValue());
			}
			Cell  R26cell28 = row26.getCell(39); 
			if (R26cell28 != null) {
				R26cell28.setCellValue(brf41a.getR26_amount_uae_umm() == null ? 0 : brf41a.getR26_amount_uae_umm().intValue());
			}
			Cell  R26cell29 = row26.getCell(40); 
			if (R26cell29 != null) {
				R26cell29.setCellValue(brf41a.getR26_no_of_accounts_non_uae_umm() == null ? 0 : brf41a.getR26_no_of_accounts_non_uae_umm().intValue());
			}
			Cell  R26cell30 = row26.getCell(41); 
			if (R26cell30 != null) {
				R26cell30.setCellValue(brf41a.getR26_amount_non_uae_umm() == null ? 0 : brf41a.getR26_amount_non_uae_umm().intValue());
			}
			Cell  R26cell31 = row26.getCell(43); 
			if (R26cell31 != null) {
				R26cell31.setCellValue(brf41a.getR26_no_of_accounts_uae_fujairah() == null ? 0 : brf41a.getR26_no_of_accounts_uae_fujairah().intValue());
			}
			Cell  R26cell32 = row26.getCell(44); 
			if (R26cell32 != null) {
				R26cell32.setCellValue(brf41a.getR26_amount_uae_fujairah() == null ? 0 : brf41a.getR26_amount_uae_fujairah().intValue());
			}
			Cell  R26cell33 = row26.getCell(45); 
			if (R26cell33 != null) {
				R26cell33.setCellValue(brf41a.getR26_no_of_accounts_non_uae_fujairah() == null ? 0 : brf41a.getR26_no_of_accounts_non_uae_fujairah().intValue());
			}
									
			Cell  R26cell34 = row26.getCell(46); 
			if (R26cell34 != null) {
				R26cell34.setCellValue(brf41a.getR26_amount_non_uae_fujairah() == null ? 0 : brf41a.getR26_amount_non_uae_fujairah().intValue());
			}
		///ROW27
		  Row row27 = sheet.getRow(26);
		  Cell R27cell1 = row27.getCell(4); 
			if (R27cell1 != null) {
				R27cell1.setCellValue(brf41a.getR27_no_of_accounts_uae() == null ? 0 : brf41a.getR27_no_of_accounts_uae().intValue());
			}
			Cell R27cell2 = row27.getCell(5); 
			if (R27cell2 != null) {
				R27cell2.setCellValue(brf41a.getR27_amount_uae() == null ? 0 : brf41a.getR27_amount_uae().intValue());
			}
			Cell R27cell3 = row27.getCell(6); 
			if (R27cell3 != null) {
				R27cell3.setCellValue(brf41a.getR27_no_of_accounts_resident() == null ? 0 : brf41a.getR27_no_of_accounts_resident().intValue());
			}
			Cell R27cell4 = row27.getCell(7); 
			if (R27cell4 != null) {
				R27cell4.setCellValue(brf41a.getR27_amount_resident() == null ? 0 : brf41a.getR27_amount_resident().intValue());
			}
			Cell R27cell5 = row27.getCell(8); 
			if (R27cell5 != null) {
				R27cell5.setCellValue(brf41a.getR27_no_of_accounts_non_resident() == null ? 0 : brf41a.getR27_no_of_accounts_non_resident().intValue());
			}
			Cell R27cell6 = row27.getCell(9); 
			if (R27cell6 != null) {
				R27cell6.setCellValue(brf41a.getR27_amount_non_resident() == null ? 0 : brf41a.getR27_amount_non_resident().intValue());
			}
			Cell R27cell7 = row27.getCell(13); 
			if (R27cell7 != null) {
				R27cell7.setCellValue(brf41a.getR27_no_of_accounts_uae_abu() == null ? 0 : brf41a.getR27_no_of_accounts_uae_abu().intValue());
			}
			Cell R27cell8 = row27.getCell(14); 
			if (R27cell8 != null) {
				R27cell8.setCellValue(brf41a.getR27_amount_uae_abu() == null ? 0 : brf41a.getR27_amount_uae_abu().intValue());
			}
			Cell R27cell9 = row27.getCell(15); 
			if (R27cell9 != null) {
				R27cell9.setCellValue(brf41a.getR27_no_of_accounts_non_uae_abu() == null ? 0 : brf41a.getR27_no_of_accounts_non_uae_abu().intValue());
			}
			Cell R27cell10 = row27.getCell(16); 
			if (R27cell10 != null) {
				R27cell10.setCellValue(brf41a.getR27_amount_non_uae_abu() == null ? 0 : brf41a.getR27_amount_non_uae_abu().intValue());
			}

			Cell R27cell11 = row27.getCell(18); 
			if (R27cell11 != null) {
				R27cell11.setCellValue(brf41a.getR27_no_of_accounts_uae_dubai() == null ? 0 : brf41a.getR27_no_of_accounts_uae_dubai().intValue());
			}
			Cell R27cell12 = row27.getCell(19); 
			if (R27cell12 != null) {
				R27cell12.setCellValue(brf41a.getR27_amount_uae_dubai() == null ? 0 : brf41a.getR27_amount_uae_dubai().intValue());
			}

			Cell R27cell13 = row27.getCell(20); 
			if (R27cell13 != null) {
				R27cell13.setCellValue(brf41a.getR27_no_of_accounts_non_uae_dubai() == null ? 0 : brf41a.getR27_no_of_accounts_non_uae_dubai().intValue());
			}
			Cell R27cell14 = row27.getCell(21); 
			if (R27cell14 != null) {
				R27cell14.setCellValue(brf41a.getR27_amount_non_uae_dubai() == null ? 0 : brf41a.getR27_amount_non_uae_dubai().intValue());
			}
			Cell R27cell15 = row27.getCell(23); 
			if (R27cell15 != null) {
				R27cell15.setCellValue(brf41a.getR27_no_of_accounts_uae_sharjah() == null ? 0 : brf41a.getR27_no_of_accounts_uae_sharjah().intValue());
			}
			Cell R27cell16 = row27.getCell(24); 
			if (R27cell16 != null) {
				R27cell16.setCellValue(brf41a.getR27_amount_uae_sharjah() == null ? 0 : brf41a.getR27_amount_uae_sharjah().intValue());
			}
			Cell  R27cell17 = row27.getCell(25); 
			if (R27cell17 != null) {
				R27cell17.setCellValue(brf41a.getR27_no_of_accounts_non_uae_sharjah() == null ? 0 : brf41a.getR27_no_of_accounts_non_uae_sharjah().intValue());
			}
			Cell  R27cell18 = row27.getCell(26); 
			if (R27cell18 != null) {
				R27cell18.setCellValue(brf41a.getR27_amount_non_uae_sharjah() == null ? 0 : brf41a.getR27_amount_non_uae_sharjah().intValue());
			}
			Cell  R27cell19 = row27.getCell(28); 
			if (R27cell19 != null) {
				R27cell19.setCellValue(brf41a.getR27_no_of_accounts_uae_ajman() == null ? 0 : brf41a.getR27_no_of_accounts_uae_ajman().intValue());
			}

			Cell  R27cell20 = row27.getCell(29); 
			if (R27cell20 != null) {
				R27cell20.setCellValue(brf41a.getR27_amount_uae_ajman() == null ? 0 : brf41a.getR27_amount_uae_ajman().intValue());
			}
			Cell  R27cell21 = row27.getCell(30); 
			if (R27cell21 != null) {
				R27cell21.setCellValue(brf41a.getR27_no_of_accounts_non_uae_ajman() == null ? 0 : brf41a.getR27_no_of_accounts_non_uae_ajman().intValue());
			}

			Cell R27cell22 = row27.getCell(31); 
			if (R27cell22 != null) {
				R27cell22.setCellValue(brf41a.getR27_amount_non_uae_ajman() == null ? 0 : brf41a.getR27_amount_non_uae_ajman().intValue());
			}
			Cell  R27cell23 = row27.getCell(33); 
			if (R27cell23 != null) {
				R27cell23.setCellValue(brf41a.getR27_no_of_accounts_uae_ras() == null ? 0 : brf41a.getR27_no_of_accounts_uae_ras().intValue());
			}
			Cell R27cell24 = row27.getCell(34); 
			if (R27cell24 != null) {
				R27cell24.setCellValue(brf41a.getR27_amount_uae_ras() == null ? 0 : brf41a.getR27_amount_uae_ras().intValue());
			}
			Cell  R27cell25 = row27.getCell(35); 
			if (R27cell25 != null) {
				R27cell25.setCellValue(brf41a.getR27_no_of_accounts_non_uae_ras() == null ? 0 : brf41a.getR27_no_of_accounts_non_uae_ras().intValue());
			}
			Cell  R27cell26 = row27.getCell(36); 
			if (R27cell26 != null) {
				R27cell26.setCellValue(brf41a.getR27_amount_non_uae_ras() == null ? 0 : brf41a.getR27_amount_non_uae_ras().intValue());
			}
			Cell  R27cell27 = row27.getCell(38); 
			if (R27cell27 != null) {
				R27cell27.setCellValue(brf41a.getR27_no_of_accounts_uae_umm() == null ? 0 : brf41a.getR27_no_of_accounts_uae_umm().intValue());
			}
			Cell  R27cell28 = row27.getCell(39); 
			if (R27cell28 != null) {
				R27cell28.setCellValue(brf41a.getR27_amount_uae_umm() == null ? 0 : brf41a.getR27_amount_uae_umm().intValue());
			}
			Cell  R27cell29 = row27.getCell(40); 
			if (R27cell29 != null) {
				R27cell29.setCellValue(brf41a.getR27_no_of_accounts_non_uae_umm() == null ? 0 : brf41a.getR27_no_of_accounts_non_uae_umm().intValue());
			}
			Cell  R27cell30 = row27.getCell(41); 
			if (R27cell30 != null) {
				R27cell30.setCellValue(brf41a.getR27_amount_non_uae_umm() == null ? 0 : brf41a.getR27_amount_non_uae_umm().intValue());
			}
			Cell  R27cell31 = row27.getCell(43); 
			if (R27cell31 != null) {
				R27cell31.setCellValue(brf41a.getR27_no_of_accounts_uae_fujairah() == null ? 0 : brf41a.getR27_no_of_accounts_uae_fujairah().intValue());
			}
			Cell  R27cell32 = row27.getCell(44); 
			if (R27cell32 != null) {
				R27cell32.setCellValue(brf41a.getR27_amount_uae_fujairah() == null ? 0 : brf41a.getR27_amount_uae_fujairah().intValue());
			}
			Cell  R27cell33 = row27.getCell(45); 
			if (R27cell33 != null) {
				R27cell33.setCellValue(brf41a.getR27_no_of_accounts_non_uae_fujairah() == null ? 0 : brf41a.getR27_no_of_accounts_non_uae_fujairah().intValue());
			}
									
			Cell  R27cell34 = row27.getCell(46); 
			if (R27cell34 != null) {
				R27cell34.setCellValue(brf41a.getR27_amount_non_uae_fujairah() == null ? 0 : brf41a.getR27_amount_non_uae_fujairah().intValue());
			}
		///ROW28
		  Row row28 = sheet.getRow(27);
		  Cell R28cell1 = row28.getCell(4); 
			if (R28cell1 != null) {
				R28cell1.setCellValue(brf41a.getR28_no_of_accounts_uae() == null ? 0 : brf41a.getR28_no_of_accounts_uae().intValue());
			}
			Cell R28cell2 = row28.getCell(5); 
			if (R28cell2 != null) {
				R28cell2.setCellValue(brf41a.getR28_amount_uae() == null ? 0 : brf41a.getR28_amount_uae().intValue());
			}
			Cell R28cell3 = row28.getCell(6); 
			if (R28cell3 != null) {
				R28cell3.setCellValue(brf41a.getR28_no_of_accounts_resident() == null ? 0 : brf41a.getR28_no_of_accounts_resident().intValue());
			}
			Cell R28cell4 = row28.getCell(7); 
			if (R28cell4 != null) {
				R28cell4.setCellValue(brf41a.getR28_amount_resident() == null ? 0 : brf41a.getR28_amount_resident().intValue());
			}
			Cell R28cell5 = row28.getCell(8); 
			if (R28cell5 != null) {
				R28cell5.setCellValue(brf41a.getR28_no_of_accounts_non_resident() == null ? 0 : brf41a.getR28_no_of_accounts_non_resident().intValue());
			}
			Cell R28cell6 = row28.getCell(9); 
			if (R28cell6 != null) {
				R28cell6.setCellValue(brf41a.getR28_amount_non_resident() == null ? 0 : brf41a.getR28_amount_non_resident().intValue());
			}
			Cell R28cell7 = row28.getCell(13); 
			if (R28cell7 != null) {
				R28cell7.setCellValue(brf41a.getR28_no_of_accounts_uae_abu() == null ? 0 : brf41a.getR28_no_of_accounts_uae_abu().intValue());
			}
			Cell R28cell8 = row28.getCell(14); 
			if (R28cell8 != null) {
				R28cell8.setCellValue(brf41a.getR28_amount_uae_abu() == null ? 0 : brf41a.getR28_amount_uae_abu().intValue());
			}
			Cell R28cell9 = row28.getCell(15); 
			if (R28cell9 != null) {
				R28cell9.setCellValue(brf41a.getR28_no_of_accounts_non_uae_abu() == null ? 0 : brf41a.getR28_no_of_accounts_non_uae_abu().intValue());
			}
			Cell R28cell10 = row28.getCell(16); 
			if (R28cell10 != null) {
				R28cell10.setCellValue(brf41a.getR28_amount_non_uae_abu() == null ? 0 : brf41a.getR28_amount_non_uae_abu().intValue());
			}

			Cell R28cell11 = row28.getCell(18); 
			if (R28cell11 != null) {
				R28cell11.setCellValue(brf41a.getR28_no_of_accounts_uae_dubai() == null ? 0 : brf41a.getR28_no_of_accounts_uae_dubai().intValue());
			}
			Cell R28cell12 = row28.getCell(19); 
			if (R28cell12 != null) {
				R28cell12.setCellValue(brf41a.getR28_amount_uae_dubai() == null ? 0 : brf41a.getR28_amount_uae_dubai().intValue());
			}

			Cell R28cell13 = row28.getCell(20); 
			if (R28cell13 != null) {
				R28cell13.setCellValue(brf41a.getR28_no_of_accounts_non_uae_dubai() == null ? 0 : brf41a.getR28_no_of_accounts_non_uae_dubai().intValue());
			}
			Cell R28cell14 = row28.getCell(21); 
			if (R28cell14 != null) {
				R28cell14.setCellValue(brf41a.getR28_amount_non_uae_dubai() == null ? 0 : brf41a.getR28_amount_non_uae_dubai().intValue());
			}
			Cell R28cell15 = row28.getCell(23); 
			if (R28cell15 != null) {
				R28cell15.setCellValue(brf41a.getR28_no_of_accounts_uae_sharjah() == null ? 0 : brf41a.getR28_no_of_accounts_uae_sharjah().intValue());
			}
			Cell R28cell16 = row28.getCell(24); 
			if (R28cell16 != null) {
				R28cell16.setCellValue(brf41a.getR28_amount_uae_sharjah() == null ? 0 : brf41a.getR28_amount_uae_sharjah().intValue());
			}
			Cell  R28cell17 = row28.getCell(25); 
			if (R28cell17 != null) {
				R28cell17.setCellValue(brf41a.getR28_no_of_accounts_non_uae_sharjah() == null ? 0 : brf41a.getR28_no_of_accounts_non_uae_sharjah().intValue());
			}
			Cell  R28cell18 = row28.getCell(26); 
			if (R28cell18 != null) {
				R28cell18.setCellValue(brf41a.getR28_amount_non_uae_sharjah() == null ? 0 : brf41a.getR28_amount_non_uae_sharjah().intValue());
			}
			Cell  R28cell19 = row28.getCell(28); 
			if (R28cell19 != null) {
				R28cell19.setCellValue(brf41a.getR28_no_of_accounts_uae_ajman() == null ? 0 : brf41a.getR28_no_of_accounts_uae_ajman().intValue());
			}

			Cell  R28cell20 = row28.getCell(29); 
			if (R28cell20 != null) {
				R28cell20.setCellValue(brf41a.getR28_amount_uae_ajman() == null ? 0 : brf41a.getR28_amount_uae_ajman().intValue());
			}
			Cell  R28cell21 = row28.getCell(30); 
			if (R28cell21 != null) {
				R28cell21.setCellValue(brf41a.getR28_no_of_accounts_non_uae_ajman() == null ? 0 : brf41a.getR28_no_of_accounts_non_uae_ajman().intValue());
			}

			Cell R28cell22 = row28.getCell(31); 
			if (R28cell22 != null) {
				R28cell22.setCellValue(brf41a.getR28_amount_non_uae_ajman() == null ? 0 : brf41a.getR28_amount_non_uae_ajman().intValue());
			}
			Cell  R28cell23 = row28.getCell(33); 
			if (R28cell23 != null) {
				R28cell23.setCellValue(brf41a.getR28_no_of_accounts_uae_ras() == null ? 0 : brf41a.getR28_no_of_accounts_uae_ras().intValue());
			}
			Cell R28cell24 = row28.getCell(34); 
			if (R28cell24 != null) {
				R28cell24.setCellValue(brf41a.getR28_amount_uae_ras() == null ? 0 : brf41a.getR28_amount_uae_ras().intValue());
			}
			Cell  R28cell25 = row28.getCell(35); 
			if (R28cell25 != null) {
				R28cell25.setCellValue(brf41a.getR28_no_of_accounts_non_uae_ras() == null ? 0 : brf41a.getR28_no_of_accounts_non_uae_ras().intValue());
			}
			Cell  R28cell26 = row28.getCell(36); 
			if (R28cell26 != null) {
				R28cell26.setCellValue(brf41a.getR28_amount_non_uae_ras() == null ? 0 : brf41a.getR28_amount_non_uae_ras().intValue());
			}
			Cell  R28cell27 = row28.getCell(38); 
			if (R28cell27 != null) {
				R28cell27.setCellValue(brf41a.getR28_no_of_accounts_uae_umm() == null ? 0 : brf41a.getR28_no_of_accounts_uae_umm().intValue());
			}
			Cell  R28cell28 = row28.getCell(39); 
			if (R28cell28 != null) {
				R28cell28.setCellValue(brf41a.getR28_amount_uae_umm() == null ? 0 : brf41a.getR28_amount_uae_umm().intValue());
			}
			Cell  R28cell29 = row28.getCell(40); 
			if (R28cell29 != null) {
				R28cell29.setCellValue(brf41a.getR28_no_of_accounts_non_uae_umm() == null ? 0 : brf41a.getR28_no_of_accounts_non_uae_umm().intValue());
			}
			Cell  R28cell30 = row28.getCell(41); 
			if (R28cell30 != null) {
				R28cell30.setCellValue(brf41a.getR28_amount_non_uae_umm() == null ? 0 : brf41a.getR28_amount_non_uae_umm().intValue());
			}
			Cell  R28cell31 = row28.getCell(43); 
			if (R28cell31 != null) {
				R28cell31.setCellValue(brf41a.getR28_no_of_accounts_uae_fujairah() == null ? 0 : brf41a.getR28_no_of_accounts_uae_fujairah().intValue());
			}
			Cell  R28cell32 = row28.getCell(44); 
			if (R28cell32 != null) {
				R28cell32.setCellValue(brf41a.getR28_amount_uae_fujairah() == null ? 0 : brf41a.getR28_amount_uae_fujairah().intValue());
			}
			Cell  R28cell33 = row28.getCell(45); 
			if (R28cell33 != null) {
				R28cell33.setCellValue(brf41a.getR28_no_of_accounts_non_uae_fujairah() == null ? 0 : brf41a.getR28_no_of_accounts_non_uae_fujairah().intValue());
			}
									
			Cell  R28cell34 = row28.getCell(46); 
			if (R28cell34 != null) {
				R28cell34.setCellValue(brf41a.getR28_amount_non_uae_fujairah() == null ? 0 : brf41a.getR28_amount_non_uae_fujairah().intValue());
			}
		///ROW29
		  Row row29 = sheet.getRow(28);
		  Cell R29cell1 = row29.getCell(4); 
			if (R29cell1 != null) {
				R29cell1.setCellValue(brf41a.getR29_no_of_accounts_uae() == null ? 0 : brf41a.getR29_no_of_accounts_uae().intValue());
			}
			Cell R29cell2 = row29.getCell(5); 
			if (R29cell2 != null) {
				R29cell2.setCellValue(brf41a.getR29_amount_uae() == null ? 0 : brf41a.getR29_amount_uae().intValue());
			}
			Cell R29cell3 = row29.getCell(6); 
			if (R29cell3 != null) {
				R29cell3.setCellValue(brf41a.getR29_no_of_accounts_resident() == null ? 0 : brf41a.getR29_no_of_accounts_resident().intValue());
			}
			Cell R29cell4 = row29.getCell(7); 
			if (R29cell4 != null) {
				R29cell4.setCellValue(brf41a.getR29_amount_resident() == null ? 0 : brf41a.getR29_amount_resident().intValue());
			}
			Cell R29cell5 = row29.getCell(8); 
			if (R29cell5 != null) {
				R29cell5.setCellValue(brf41a.getR29_no_of_accounts_non_resident() == null ? 0 : brf41a.getR29_no_of_accounts_non_resident().intValue());
			}
			Cell R29cell6 = row29.getCell(9); 
			if (R29cell6 != null) {
				R29cell6.setCellValue(brf41a.getR29_amount_non_resident() == null ? 0 : brf41a.getR29_amount_non_resident().intValue());
			}
			Cell R29cell7 = row29.getCell(13); 
			if (R29cell7 != null) {
				R29cell7.setCellValue(brf41a.getR29_no_of_accounts_uae_abu() == null ? 0 : brf41a.getR29_no_of_accounts_uae_abu().intValue());
			}
			Cell R29cell8 = row29.getCell(14); 
			if (R29cell8 != null) {
				R29cell8.setCellValue(brf41a.getR29_amount_uae_abu() == null ? 0 : brf41a.getR29_amount_uae_abu().intValue());
			}
			Cell R29cell9 = row29.getCell(15); 
			if (R29cell9 != null) {
				R29cell9.setCellValue(brf41a.getR29_no_of_accounts_non_uae_abu() == null ? 0 : brf41a.getR29_no_of_accounts_non_uae_abu().intValue());
			}
			Cell R29cell10 = row29.getCell(16); 
			if (R29cell10 != null) {
				R29cell10.setCellValue(brf41a.getR29_amount_non_uae_abu() == null ? 0 : brf41a.getR29_amount_non_uae_abu().intValue());
			}

			Cell R29cell11 = row29.getCell(18); 
			if (R29cell11 != null) {
				R29cell11.setCellValue(brf41a.getR29_no_of_accounts_uae_dubai() == null ? 0 : brf41a.getR29_no_of_accounts_uae_dubai().intValue());
			}
			Cell R29cell12 = row29.getCell(19); 
			if (R29cell12 != null) {
				R29cell12.setCellValue(brf41a.getR29_amount_uae_dubai() == null ? 0 : brf41a.getR29_amount_uae_dubai().intValue());
			}

			Cell R29cell13 = row29.getCell(20); 
			if (R29cell13 != null) {
				R29cell13.setCellValue(brf41a.getR29_no_of_accounts_non_uae_dubai() == null ? 0 : brf41a.getR29_no_of_accounts_non_uae_dubai().intValue());
			}
			Cell R29cell14 = row29.getCell(21); 
			if (R29cell14 != null) {
				R29cell14.setCellValue(brf41a.getR29_amount_non_uae_dubai() == null ? 0 : brf41a.getR29_amount_non_uae_dubai().intValue());
			}
			Cell R29cell15 = row29.getCell(23); 
			if (R29cell15 != null) {
				R29cell15.setCellValue(brf41a.getR29_no_of_accounts_uae_sharjah() == null ? 0 : brf41a.getR29_no_of_accounts_uae_sharjah().intValue());
			}
			Cell R29cell16 = row29.getCell(24); 
			if (R29cell16 != null) {
				R29cell16.setCellValue(brf41a.getR29_amount_uae_sharjah() == null ? 0 : brf41a.getR29_amount_uae_sharjah().intValue());
			}
			Cell  R29cell17 = row29.getCell(25); 
			if (R29cell17 != null) {
				R29cell17.setCellValue(brf41a.getR29_no_of_accounts_non_uae_sharjah() == null ? 0 : brf41a.getR29_no_of_accounts_non_uae_sharjah().intValue());
			}
			Cell  R29cell18 = row29.getCell(26); 
			if (R29cell18 != null) {
				R29cell18.setCellValue(brf41a.getR29_amount_non_uae_sharjah() == null ? 0 : brf41a.getR29_amount_non_uae_sharjah().intValue());
			}
			Cell  R29cell19 = row29.getCell(28); 
			if (R29cell19 != null) {
				R29cell19.setCellValue(brf41a.getR29_no_of_accounts_uae_ajman() == null ? 0 : brf41a.getR29_no_of_accounts_uae_ajman().intValue());
			}

			Cell  R29cell20 = row29.getCell(29); 
			if (R29cell20 != null) {
				R29cell20.setCellValue(brf41a.getR29_amount_uae_ajman() == null ? 0 : brf41a.getR29_amount_uae_ajman().intValue());
			}
			Cell  R29cell21 = row29.getCell(30); 
			if (R29cell21 != null) {
				R29cell21.setCellValue(brf41a.getR29_no_of_accounts_non_uae_ajman() == null ? 0 : brf41a.getR29_no_of_accounts_non_uae_ajman().intValue());
			}

			Cell R29cell22 = row29.getCell(31); 
			if (R29cell22 != null) {
				R29cell22.setCellValue(brf41a.getR29_amount_non_uae_ajman() == null ? 0 : brf41a.getR29_amount_non_uae_ajman().intValue());
			}
			Cell  R29cell23 = row29.getCell(33); 
			if (R29cell23 != null) {
				R29cell23.setCellValue(brf41a.getR29_no_of_accounts_uae_ras() == null ? 0 : brf41a.getR29_no_of_accounts_uae_ras().intValue());
			}
			Cell R29cell24 = row29.getCell(34); 
			if (R29cell24 != null) {
				R29cell24.setCellValue(brf41a.getR29_amount_uae_ras() == null ? 0 : brf41a.getR29_amount_uae_ras().intValue());
			}
			Cell  R29cell25 = row29.getCell(35); 
			if (R29cell25 != null) {
				R29cell25.setCellValue(brf41a.getR29_no_of_accounts_non_uae_ras() == null ? 0 : brf41a.getR29_no_of_accounts_non_uae_ras().intValue());
			}
			Cell  R29cell26 = row29.getCell(36); 
			if (R29cell26 != null) {
				R29cell26.setCellValue(brf41a.getR29_amount_non_uae_ras() == null ? 0 : brf41a.getR29_amount_non_uae_ras().intValue());
			}
			Cell  R29cell27 = row29.getCell(38); 
			if (R29cell27 != null) {
				R29cell27.setCellValue(brf41a.getR29_no_of_accounts_uae_umm() == null ? 0 : brf41a.getR29_no_of_accounts_uae_umm().intValue());
			}
			Cell  R29cell28 = row29.getCell(39); 
			if (R29cell28 != null) {
				R29cell28.setCellValue(brf41a.getR29_amount_uae_umm() == null ? 0 : brf41a.getR29_amount_uae_umm().intValue());
			}
			Cell  R29cell29 = row29.getCell(40); 
			if (R29cell29 != null) {
				R29cell29.setCellValue(brf41a.getR29_no_of_accounts_non_uae_umm() == null ? 0 : brf41a.getR29_no_of_accounts_non_uae_umm().intValue());
			}
			Cell  R29cell30 = row29.getCell(41); 
			if (R29cell30 != null) {
				R29cell30.setCellValue(brf41a.getR29_amount_non_uae_umm() == null ? 0 : brf41a.getR29_amount_non_uae_umm().intValue());
			}
			Cell  R29cell31 = row29.getCell(43); 
			if (R29cell31 != null) {
				R29cell31.setCellValue(brf41a.getR29_no_of_accounts_uae_fujairah() == null ? 0 : brf41a.getR29_no_of_accounts_uae_fujairah().intValue());
			}
			Cell  R29cell32 = row29.getCell(44); 
			if (R29cell32 != null) {
				R29cell32.setCellValue(brf41a.getR29_amount_uae_fujairah() == null ? 0 : brf41a.getR29_amount_uae_fujairah().intValue());
			}
			Cell  R29cell33 = row29.getCell(45); 
			if (R29cell33 != null) {
				R29cell33.setCellValue(brf41a.getR29_no_of_accounts_non_uae_fujairah() == null ? 0 : brf41a.getR29_no_of_accounts_non_uae_fujairah().intValue());
			}
									
			Cell  R29cell34 = row29.getCell(46); 
			if (R29cell34 != null) {
				R29cell34.setCellValue(brf41a.getR29_amount_non_uae_fujairah() == null ? 0 : brf41a.getR29_amount_non_uae_fujairah().intValue());
			}
		///ROW32
		  Row row32 = sheet.getRow(31);
		  Cell R32cell1 = row32.getCell(4); 
			if (R32cell1 != null) {
				R32cell1.setCellValue(brf41a.getR32_no_of_accounts_uae() == null ? 0 : brf41a.getR32_no_of_accounts_uae().intValue());
			}
			Cell R32cell2 = row32.getCell(5); 
			if (R32cell2 != null) {
				R32cell2.setCellValue(brf41a.getR32_amount_uae() == null ? 0 : brf41a.getR32_amount_uae().intValue());
			}
			Cell R32cell3 = row32.getCell(6); 
			if (R32cell3 != null) {
				R32cell3.setCellValue(brf41a.getR32_no_of_accounts_resident() == null ? 0 : brf41a.getR32_no_of_accounts_resident().intValue());
			}
			Cell R32cell4 = row32.getCell(7); 
			if (R32cell4 != null) {
				R32cell4.setCellValue(brf41a.getR32_amount_resident() == null ? 0 : brf41a.getR32_amount_resident().intValue());
			}
			Cell R32cell5 = row32.getCell(8); 
			if (R32cell5 != null) {
				R32cell5.setCellValue(brf41a.getR32_no_of_accounts_non_resident() == null ? 0 : brf41a.getR32_no_of_accounts_non_resident().intValue());
			}
			Cell R32cell6 = row32.getCell(9); 
			if (R32cell6 != null) {
				R32cell6.setCellValue(brf41a.getR32_amount_non_resident() == null ? 0 : brf41a.getR32_amount_non_resident().intValue());
			}
			Cell R32cell7 = row32.getCell(13); 
			if (R32cell7 != null) {
				R32cell7.setCellValue(brf41a.getR32_no_of_accounts_uae_abu() == null ? 0 : brf41a.getR32_no_of_accounts_uae_abu().intValue());
			}
			Cell R32cell8 = row32.getCell(14); 
			if (R32cell8 != null) {
				R32cell8.setCellValue(brf41a.getR32_amount_uae_abu() == null ? 0 : brf41a.getR32_amount_uae_abu().intValue());
			}
			Cell R32cell9 = row32.getCell(15); 
			if (R32cell9 != null) {
				R32cell9.setCellValue(brf41a.getR32_no_of_accounts_non_uae_abu() == null ? 0 : brf41a.getR32_no_of_accounts_non_uae_abu().intValue());
			}
			Cell R32cell10 = row32.getCell(16); 
			if (R32cell10 != null) {
				R32cell10.setCellValue(brf41a.getR32_amount_non_uae_abu() == null ? 0 : brf41a.getR32_amount_non_uae_abu().intValue());
			}

			Cell R32cell11 = row32.getCell(18); 
			if (R32cell11 != null) {
				R32cell11.setCellValue(brf41a.getR32_no_of_accounts_uae_dubai() == null ? 0 : brf41a.getR32_no_of_accounts_uae_dubai().intValue());
			}
			Cell R32cell12 = row32.getCell(19); 
			if (R32cell12 != null) {
				R32cell12.setCellValue(brf41a.getR32_amount_uae_dubai() == null ? 0 : brf41a.getR32_amount_uae_dubai().intValue());
			}

			Cell R32cell13 = row32.getCell(20); 
			if (R32cell13 != null) {
				R32cell13.setCellValue(brf41a.getR32_no_of_accounts_non_uae_dubai() == null ? 0 : brf41a.getR32_no_of_accounts_non_uae_dubai().intValue());
			}
			Cell R32cell14 = row32.getCell(21); 
			if (R32cell14 != null) {
				R32cell14.setCellValue(brf41a.getR32_amount_non_uae_dubai() == null ? 0 : brf41a.getR32_amount_non_uae_dubai().intValue());
			}
			Cell R32cell15 = row32.getCell(23); 
			if (R32cell15 != null) {
				R32cell15.setCellValue(brf41a.getR32_no_of_accounts_uae_sharjah() == null ? 0 : brf41a.getR32_no_of_accounts_uae_sharjah().intValue());
			}
			Cell R32cell16 = row32.getCell(24); 
			if (R32cell16 != null) {
				R32cell16.setCellValue(brf41a.getR32_amount_uae_sharjah() == null ? 0 : brf41a.getR32_amount_uae_sharjah().intValue());
			}
			Cell  R32cell17 = row32.getCell(25); 
			if (R32cell17 != null) {
				R32cell17.setCellValue(brf41a.getR32_no_of_accounts_non_uae_sharjah() == null ? 0 : brf41a.getR32_no_of_accounts_non_uae_sharjah().intValue());
			}
			Cell  R32cell18 = row32.getCell(26); 
			if (R32cell18 != null) {
				R32cell18.setCellValue(brf41a.getR32_amount_non_uae_sharjah() == null ? 0 : brf41a.getR32_amount_non_uae_sharjah().intValue());
			}
			Cell  R32cell19 = row32.getCell(28); 
			if (R32cell19 != null) {
				R32cell19.setCellValue(brf41a.getR32_no_of_accounts_uae_ajman() == null ? 0 : brf41a.getR32_no_of_accounts_uae_ajman().intValue());
			}

			Cell  R32cell20 = row32.getCell(29); 
			if (R32cell20 != null) {
				R32cell20.setCellValue(brf41a.getR32_amount_uae_ajman() == null ? 0 : brf41a.getR32_amount_uae_ajman().intValue());
			}
			Cell  R32cell21 = row32.getCell(30); 
			if (R32cell21 != null) {
				R32cell21.setCellValue(brf41a.getR32_no_of_accounts_non_uae_ajman() == null ? 0 : brf41a.getR32_no_of_accounts_non_uae_ajman().intValue());
			}

			Cell R32cell22 = row32.getCell(31); 
			if (R32cell22 != null) {
				R32cell22.setCellValue(brf41a.getR32_amount_non_uae_ajman() == null ? 0 : brf41a.getR32_amount_non_uae_ajman().intValue());
			}
			Cell  R32cell23 = row32.getCell(33); 
			if (R32cell23 != null) {
				R32cell23.setCellValue(brf41a.getR32_no_of_accounts_uae_ras() == null ? 0 : brf41a.getR32_no_of_accounts_uae_ras().intValue());
			}
			Cell R32cell24 = row32.getCell(34); 
			if (R32cell24 != null) {
				R32cell24.setCellValue(brf41a.getR32_amount_uae_ras() == null ? 0 : brf41a.getR32_amount_uae_ras().intValue());
			}
			Cell  R32cell25 = row32.getCell(35); 
			if (R32cell25 != null) {
				R32cell25.setCellValue(brf41a.getR32_no_of_accounts_non_uae_ras() == null ? 0 : brf41a.getR32_no_of_accounts_non_uae_ras().intValue());
			}
			Cell  R32cell26 = row32.getCell(36); 
			if (R32cell26 != null) {
				R32cell26.setCellValue(brf41a.getR32_amount_non_uae_ras() == null ? 0 : brf41a.getR32_amount_non_uae_ras().intValue());
			}
			Cell  R32cell27 = row32.getCell(38); 
			if (R32cell27 != null) {
				R32cell27.setCellValue(brf41a.getR32_no_of_accounts_uae_umm() == null ? 0 : brf41a.getR32_no_of_accounts_uae_umm().intValue());
			}
			Cell  R32cell28 = row32.getCell(39); 
			if (R32cell28 != null) {
				R32cell28.setCellValue(brf41a.getR32_amount_uae_umm() == null ? 0 : brf41a.getR32_amount_uae_umm().intValue());
			}
			Cell  R32cell29 = row32.getCell(40); 
			if (R32cell29 != null) {
				R32cell29.setCellValue(brf41a.getR32_no_of_accounts_non_uae_umm() == null ? 0 : brf41a.getR32_no_of_accounts_non_uae_umm().intValue());
			}
			Cell  R32cell30 = row32.getCell(41); 
			if (R32cell30 != null) {
				R32cell30.setCellValue(brf41a.getR32_amount_non_uae_umm() == null ? 0 : brf41a.getR32_amount_non_uae_umm().intValue());
			}
			Cell  R32cell31 = row32.getCell(43); 
			if (R32cell31 != null) {
				R32cell31.setCellValue(brf41a.getR32_no_of_accounts_uae_fujairah() == null ? 0 : brf41a.getR32_no_of_accounts_uae_fujairah().intValue());
			}
			Cell  R32cell32 = row32.getCell(44); 
			if (R32cell32 != null) {
				R32cell32.setCellValue(brf41a.getR32_amount_uae_fujairah() == null ? 0 : brf41a.getR32_amount_uae_fujairah().intValue());
			}
			Cell  R32cell33 = row32.getCell(45); 
			if (R32cell33 != null) {
				R32cell33.setCellValue(brf41a.getR32_no_of_accounts_non_uae_fujairah() == null ? 0 : brf41a.getR32_no_of_accounts_non_uae_fujairah().intValue());
			}
									
			Cell  R32cell34 = row32.getCell(46); 
			if (R32cell34 != null) {
				R32cell34.setCellValue(brf41a.getR32_amount_non_uae_fujairah() == null ? 0 : brf41a.getR32_amount_non_uae_fujairah().intValue());
			}
		///ROW33
		  Row row33 = sheet.getRow(32);
		  Cell R33cell1 = row33.getCell(4); 
			if (R33cell1 != null) {
				R33cell1.setCellValue(brf41a.getR33_no_of_accounts_uae() == null ? 0 : brf41a.getR33_no_of_accounts_uae().intValue());
			}
			Cell R33cell2 = row33.getCell(5); 
			if (R33cell2 != null) {
				R33cell2.setCellValue(brf41a.getR33_amount_uae() == null ? 0 : brf41a.getR33_amount_uae().intValue());
			}
			Cell R33cell3 = row33.getCell(6); 
			if (R33cell3 != null) {
				R33cell3.setCellValue(brf41a.getR33_no_of_accounts_resident() == null ? 0 : brf41a.getR33_no_of_accounts_resident().intValue());
			}
			Cell R33cell4 = row33.getCell(7); 
			if (R33cell4 != null) {
				R33cell4.setCellValue(brf41a.getR33_amount_resident() == null ? 0 : brf41a.getR33_amount_resident().intValue());
			}
			Cell R33cell5 = row33.getCell(8); 
			if (R33cell5 != null) {
				R33cell5.setCellValue(brf41a.getR33_no_of_accounts_non_resident() == null ? 0 : brf41a.getR33_no_of_accounts_non_resident().intValue());
			}
			Cell R33cell6 = row33.getCell(9); 
			if (R33cell6 != null) {
				R33cell6.setCellValue(brf41a.getR33_amount_non_resident() == null ? 0 : brf41a.getR33_amount_non_resident().intValue());
			}
			Cell R33cell7 = row33.getCell(13); 
			if (R33cell7 != null) {
				R33cell7.setCellValue(brf41a.getR33_no_of_accounts_uae_abu() == null ? 0 : brf41a.getR33_no_of_accounts_uae_abu().intValue());
			}
			Cell R33cell8 = row33.getCell(14); 
			if (R33cell8 != null) {
				R33cell8.setCellValue(brf41a.getR33_amount_uae_abu() == null ? 0 : brf41a.getR33_amount_uae_abu().intValue());
			}
			Cell R33cell9 = row33.getCell(15); 
			if (R33cell9 != null) {
				R33cell9.setCellValue(brf41a.getR33_no_of_accounts_non_uae_abu() == null ? 0 : brf41a.getR33_no_of_accounts_non_uae_abu().intValue());
			}
			Cell R33cell10 = row33.getCell(16); 
			if (R33cell10 != null) {
				R33cell10.setCellValue(brf41a.getR33_amount_non_uae_abu() == null ? 0 : brf41a.getR33_amount_non_uae_abu().intValue());
			}

			Cell R33cell11 = row33.getCell(18); 
			if (R33cell11 != null) {
				R33cell11.setCellValue(brf41a.getR33_no_of_accounts_uae_dubai() == null ? 0 : brf41a.getR33_no_of_accounts_uae_dubai().intValue());
			}
			Cell R33cell12 = row33.getCell(19); 
			if (R33cell12 != null) {
				R33cell12.setCellValue(brf41a.getR33_amount_uae_dubai() == null ? 0 : brf41a.getR33_amount_uae_dubai().intValue());
			}

			Cell R33cell13 = row33.getCell(20); 
			if (R33cell13 != null) {
				R33cell13.setCellValue(brf41a.getR33_no_of_accounts_non_uae_dubai() == null ? 0 : brf41a.getR33_no_of_accounts_non_uae_dubai().intValue());
			}
			Cell R33cell14 = row33.getCell(21); 
			if (R33cell14 != null) {
				R33cell14.setCellValue(brf41a.getR33_amount_non_uae_dubai() == null ? 0 : brf41a.getR33_amount_non_uae_dubai().intValue());
			}
			Cell R33cell15 = row33.getCell(23); 
			if (R33cell15 != null) {
				R33cell15.setCellValue(brf41a.getR33_no_of_accounts_uae_sharjah() == null ? 0 : brf41a.getR33_no_of_accounts_uae_sharjah().intValue());
			}
			Cell R33cell16 = row33.getCell(24); 
			if (R33cell16 != null) {
				R33cell16.setCellValue(brf41a.getR33_amount_uae_sharjah() == null ? 0 : brf41a.getR33_amount_uae_sharjah().intValue());
			}
			Cell  R33cell17 = row33.getCell(25); 
			if (R33cell17 != null) {
				R33cell17.setCellValue(brf41a.getR33_no_of_accounts_non_uae_sharjah() == null ? 0 : brf41a.getR33_no_of_accounts_non_uae_sharjah().intValue());
			}
			Cell  R33cell18 = row33.getCell(26); 
			if (R33cell18 != null) {
				R33cell18.setCellValue(brf41a.getR33_amount_non_uae_sharjah() == null ? 0 : brf41a.getR33_amount_non_uae_sharjah().intValue());
			}
			Cell  R33cell19 = row33.getCell(28); 
			if (R33cell19 != null) {
				R33cell19.setCellValue(brf41a.getR33_no_of_accounts_uae_ajman() == null ? 0 : brf41a.getR33_no_of_accounts_uae_ajman().intValue());
			}

			Cell  R33cell20 = row33.getCell(29); 
			if (R33cell20 != null) {
				R33cell20.setCellValue(brf41a.getR33_amount_uae_ajman() == null ? 0 : brf41a.getR33_amount_uae_ajman().intValue());
			}
			Cell  R33cell21 = row33.getCell(30); 
			if (R33cell21 != null) {
				R33cell21.setCellValue(brf41a.getR33_no_of_accounts_non_uae_ajman() == null ? 0 : brf41a.getR33_no_of_accounts_non_uae_ajman().intValue());
			}

			Cell R33cell22 = row33.getCell(31); 
			if (R33cell22 != null) {
				R33cell22.setCellValue(brf41a.getR33_amount_non_uae_ajman() == null ? 0 : brf41a.getR33_amount_non_uae_ajman().intValue());
			}
			Cell  R33cell23 = row33.getCell(33); 
			if (R33cell23 != null) {
				R33cell23.setCellValue(brf41a.getR33_no_of_accounts_uae_ras() == null ? 0 : brf41a.getR33_no_of_accounts_uae_ras().intValue());
			}
			Cell R33cell24 = row33.getCell(34); 
			if (R33cell24 != null) {
				R33cell24.setCellValue(brf41a.getR33_amount_uae_ras() == null ? 0 : brf41a.getR33_amount_uae_ras().intValue());
			}
			Cell  R33cell25 = row33.getCell(35); 
			if (R33cell25 != null) {
				R33cell25.setCellValue(brf41a.getR33_no_of_accounts_non_uae_ras() == null ? 0 : brf41a.getR33_no_of_accounts_non_uae_ras().intValue());
			}
			Cell  R33cell26 = row33.getCell(36); 
			if (R33cell26 != null) {
				R33cell26.setCellValue(brf41a.getR33_amount_non_uae_ras() == null ? 0 : brf41a.getR33_amount_non_uae_ras().intValue());
			}
			Cell  R33cell27 = row33.getCell(38); 
			if (R33cell27 != null) {
				R33cell27.setCellValue(brf41a.getR33_no_of_accounts_uae_umm() == null ? 0 : brf41a.getR33_no_of_accounts_uae_umm().intValue());
			}
			Cell  R33cell28 = row33.getCell(39); 
			if (R33cell28 != null) {
				R33cell28.setCellValue(brf41a.getR33_amount_uae_umm() == null ? 0 : brf41a.getR33_amount_uae_umm().intValue());
			}
			Cell  R33cell29 = row33.getCell(40); 
			if (R33cell29 != null) {
				R33cell29.setCellValue(brf41a.getR33_no_of_accounts_non_uae_umm() == null ? 0 : brf41a.getR33_no_of_accounts_non_uae_umm().intValue());
			}
			Cell  R33cell30 = row33.getCell(41); 
			if (R33cell30 != null) {
				R33cell30.setCellValue(brf41a.getR33_amount_non_uae_umm() == null ? 0 : brf41a.getR33_amount_non_uae_umm().intValue());
			}
			Cell  R33cell31 = row33.getCell(43); 
			if (R33cell31 != null) {
				R33cell31.setCellValue(brf41a.getR33_no_of_accounts_uae_fujairah() == null ? 0 : brf41a.getR33_no_of_accounts_uae_fujairah().intValue());
			}
			Cell  R33cell32 = row33.getCell(44); 
			if (R33cell32 != null) {
				R33cell32.setCellValue(brf41a.getR33_amount_uae_fujairah() == null ? 0 : brf41a.getR33_amount_uae_fujairah().intValue());
			}
			Cell  R33cell33 = row33.getCell(45); 
			if (R33cell33 != null) {
				R33cell33.setCellValue(brf41a.getR33_no_of_accounts_non_uae_fujairah() == null ? 0 : brf41a.getR33_no_of_accounts_non_uae_fujairah().intValue());
			}
									
			Cell  R33cell34 = row33.getCell(46); 
			if (R33cell34 != null) {
				R33cell34.setCellValue(brf41a.getR33_amount_non_uae_fujairah() == null ? 0 : brf41a.getR33_amount_non_uae_fujairah().intValue());
			}
		///ROW34
		  Row row34 = sheet.getRow(33);
		  Cell R34cell1 = row34.getCell(4); 
			if (R34cell1 != null) {
				R34cell1.setCellValue(brf41a.getR34_no_of_accounts_uae() == null ? 0 : brf41a.getR34_no_of_accounts_uae().intValue());
			}
			Cell R34cell2 = row34.getCell(5); 
			if (R34cell2 != null) {
				R34cell2.setCellValue(brf41a.getR34_amount_uae() == null ? 0 : brf41a.getR34_amount_uae().intValue());
			}
			Cell R34cell3 = row34.getCell(6); 
			if (R34cell3 != null) {
				R34cell3.setCellValue(brf41a.getR34_no_of_accounts_resident() == null ? 0 : brf41a.getR34_no_of_accounts_resident().intValue());
			}
			Cell R34cell4 = row34.getCell(7); 
			if (R34cell4 != null) {
				R34cell4.setCellValue(brf41a.getR34_amount_resident() == null ? 0 : brf41a.getR34_amount_resident().intValue());
			}
			Cell R34cell5 = row34.getCell(8); 
			if (R34cell5 != null) {
				R34cell5.setCellValue(brf41a.getR34_no_of_accounts_non_resident() == null ? 0 : brf41a.getR34_no_of_accounts_non_resident().intValue());
			}
			Cell R34cell6 = row34.getCell(9); 
			if (R34cell6 != null) {
				R34cell6.setCellValue(brf41a.getR34_amount_non_resident() == null ? 0 : brf41a.getR34_amount_non_resident().intValue());
			}
			Cell R34cell7 = row34.getCell(13); 
			if (R34cell7 != null) {
				R34cell7.setCellValue(brf41a.getR34_no_of_accounts_uae_abu() == null ? 0 : brf41a.getR34_no_of_accounts_uae_abu().intValue());
			}
			Cell R34cell8 = row34.getCell(14); 
			if (R34cell8 != null) {
				R34cell8.setCellValue(brf41a.getR34_amount_uae_abu() == null ? 0 : brf41a.getR34_amount_uae_abu().intValue());
			}
			Cell R34cell9 = row34.getCell(15); 
			if (R34cell9 != null) {
				R34cell9.setCellValue(brf41a.getR34_no_of_accounts_non_uae_abu() == null ? 0 : brf41a.getR34_no_of_accounts_non_uae_abu().intValue());
			}
			Cell R34cell10 = row34.getCell(16); 
			if (R34cell10 != null) {
				R34cell10.setCellValue(brf41a.getR34_amount_non_uae_abu() == null ? 0 : brf41a.getR34_amount_non_uae_abu().intValue());
			}

			Cell R34cell11 = row34.getCell(18); 
			if (R34cell11 != null) {
				R34cell11.setCellValue(brf41a.getR34_no_of_accounts_uae_dubai() == null ? 0 : brf41a.getR34_no_of_accounts_uae_dubai().intValue());
			}
			Cell R34cell12 = row34.getCell(19); 
			if (R34cell12 != null) {
				R34cell12.setCellValue(brf41a.getR34_amount_uae_dubai() == null ? 0 : brf41a.getR34_amount_uae_dubai().intValue());
			}

			Cell R34cell13 = row34.getCell(20); 
			if (R34cell13 != null) {
				R34cell13.setCellValue(brf41a.getR34_no_of_accounts_non_uae_dubai() == null ? 0 : brf41a.getR34_no_of_accounts_non_uae_dubai().intValue());
			}
			Cell R34cell14 = row34.getCell(21); 
			if (R34cell14 != null) {
				R34cell14.setCellValue(brf41a.getR34_amount_non_uae_dubai() == null ? 0 : brf41a.getR34_amount_non_uae_dubai().intValue());
			}
			Cell R34cell15 = row34.getCell(23); 
			if (R34cell15 != null) {
				R34cell15.setCellValue(brf41a.getR34_no_of_accounts_uae_sharjah() == null ? 0 : brf41a.getR34_no_of_accounts_uae_sharjah().intValue());
			}
			Cell R34cell16 = row34.getCell(24); 
			if (R34cell16 != null) {
				R34cell16.setCellValue(brf41a.getR34_amount_uae_sharjah() == null ? 0 : brf41a.getR34_amount_uae_sharjah().intValue());
			}
			Cell  R34cell17 = row34.getCell(25); 
			if (R34cell17 != null) {
				R34cell17.setCellValue(brf41a.getR34_no_of_accounts_non_uae_sharjah() == null ? 0 : brf41a.getR34_no_of_accounts_non_uae_sharjah().intValue());
			}
			Cell  R34cell18 = row34.getCell(26); 
			if (R34cell18 != null) {
				R34cell18.setCellValue(brf41a.getR34_amount_non_uae_sharjah() == null ? 0 : brf41a.getR34_amount_non_uae_sharjah().intValue());
			}
			Cell  R34cell19 = row34.getCell(28); 
			if (R34cell19 != null) {
				R34cell19.setCellValue(brf41a.getR34_no_of_accounts_uae_ajman() == null ? 0 : brf41a.getR34_no_of_accounts_uae_ajman().intValue());
			}

			Cell  R34cell20 = row34.getCell(29); 
			if (R34cell20 != null) {
				R34cell20.setCellValue(brf41a.getR34_amount_uae_ajman() == null ? 0 : brf41a.getR34_amount_uae_ajman().intValue());
			}
			Cell  R34cell21 = row34.getCell(30); 
			if (R34cell21 != null) {
				R34cell21.setCellValue(brf41a.getR34_no_of_accounts_non_uae_ajman() == null ? 0 : brf41a.getR34_no_of_accounts_non_uae_ajman().intValue());
			}

			Cell R34cell22 = row34.getCell(31); 
			if (R34cell22 != null) {
				R34cell22.setCellValue(brf41a.getR34_amount_non_uae_ajman() == null ? 0 : brf41a.getR34_amount_non_uae_ajman().intValue());
			}
			Cell  R34cell23 = row34.getCell(33); 
			if (R34cell23 != null) {
				R34cell23.setCellValue(brf41a.getR34_no_of_accounts_uae_ras() == null ? 0 : brf41a.getR34_no_of_accounts_uae_ras().intValue());
			}
			Cell R34cell24 = row34.getCell(34); 
			if (R34cell24 != null) {
				R34cell24.setCellValue(brf41a.getR34_amount_uae_ras() == null ? 0 : brf41a.getR34_amount_uae_ras().intValue());
			}
			Cell  R34cell25 = row34.getCell(35); 
			if (R34cell25 != null) {
				R34cell25.setCellValue(brf41a.getR34_no_of_accounts_non_uae_ras() == null ? 0 : brf41a.getR34_no_of_accounts_non_uae_ras().intValue());
			}
			Cell  R34cell26 = row34.getCell(36); 
			if (R34cell26 != null) {
				R34cell26.setCellValue(brf41a.getR34_amount_non_uae_ras() == null ? 0 : brf41a.getR34_amount_non_uae_ras().intValue());
			}
			Cell  R34cell27 = row34.getCell(38); 
			if (R34cell27 != null) {
				R34cell27.setCellValue(brf41a.getR34_no_of_accounts_uae_umm() == null ? 0 : brf41a.getR34_no_of_accounts_uae_umm().intValue());
			}
			Cell  R34cell28 = row34.getCell(39); 
			if (R34cell28 != null) {
				R34cell28.setCellValue(brf41a.getR34_amount_uae_umm() == null ? 0 : brf41a.getR34_amount_uae_umm().intValue());
			}
			Cell  R34cell29 = row34.getCell(40); 
			if (R34cell29 != null) {
				R34cell29.setCellValue(brf41a.getR34_no_of_accounts_non_uae_umm() == null ? 0 : brf41a.getR34_no_of_accounts_non_uae_umm().intValue());
			}
			Cell  R34cell30 = row34.getCell(41); 
			if (R34cell30 != null) {
				R34cell30.setCellValue(brf41a.getR34_amount_non_uae_umm() == null ? 0 : brf41a.getR34_amount_non_uae_umm().intValue());
			}
			Cell  R34cell31 = row34.getCell(43); 
			if (R34cell31 != null) {
				R34cell31.setCellValue(brf41a.getR34_no_of_accounts_uae_fujairah() == null ? 0 : brf41a.getR34_no_of_accounts_uae_fujairah().intValue());
			}
			Cell  R34cell32 = row34.getCell(44); 
			if (R34cell32 != null) {
				R34cell32.setCellValue(brf41a.getR34_amount_uae_fujairah() == null ? 0 : brf41a.getR34_amount_uae_fujairah().intValue());
			}
			Cell  R34cell33 = row34.getCell(45); 
			if (R34cell33 != null) {
				R34cell33.setCellValue(brf41a.getR34_no_of_accounts_non_uae_fujairah() == null ? 0 : brf41a.getR34_no_of_accounts_non_uae_fujairah().intValue());
			}
									
			Cell  R34cell34 = row34.getCell(46); 
			if (R34cell34 != null) {
				R34cell34.setCellValue(brf41a.getR34_amount_non_uae_fujairah() == null ? 0 : brf41a.getR34_amount_non_uae_fujairah().intValue());
			}
		///ROW35
		  Row row35 = sheet.getRow(34);
		  Cell R35cell1 = row35.getCell(4); 
			if (R35cell1 != null) {
				R35cell1.setCellValue(brf41a.getR35_no_of_accounts_uae() == null ? 0 : brf41a.getR35_no_of_accounts_uae().intValue());
			}
			Cell R35cell2 = row35.getCell(5); 
			if (R35cell2 != null) {
				R35cell2.setCellValue(brf41a.getR35_amount_uae() == null ? 0 : brf41a.getR35_amount_uae().intValue());
			}
			Cell R35cell3 = row35.getCell(6); 
			if (R35cell3 != null) {
				R35cell3.setCellValue(brf41a.getR35_no_of_accounts_resident() == null ? 0 : brf41a.getR35_no_of_accounts_resident().intValue());
			}
			Cell R35cell4 = row35.getCell(7); 
			if (R35cell4 != null) {
				R35cell4.setCellValue(brf41a.getR35_amount_resident() == null ? 0 : brf41a.getR35_amount_resident().intValue());
			}
			Cell R35cell5 = row35.getCell(8); 
			if (R35cell5 != null) {
				R35cell5.setCellValue(brf41a.getR35_no_of_accounts_non_resident() == null ? 0 : brf41a.getR35_no_of_accounts_non_resident().intValue());
			}
			Cell R35cell6 = row35.getCell(9); 
			if (R35cell6 != null) {
				R35cell6.setCellValue(brf41a.getR35_amount_non_resident() == null ? 0 : brf41a.getR35_amount_non_resident().intValue());
			}
			Cell R35cell7 = row35.getCell(13); 
			if (R35cell7 != null) {
				R35cell7.setCellValue(brf41a.getR35_no_of_accounts_uae_abu() == null ? 0 : brf41a.getR35_no_of_accounts_uae_abu().intValue());
			}
			Cell R35cell8 = row35.getCell(14); 
			if (R35cell8 != null) {
				R35cell8.setCellValue(brf41a.getR35_amount_uae_abu() == null ? 0 : brf41a.getR35_amount_uae_abu().intValue());
			}
			Cell R35cell9 = row35.getCell(15); 
			if (R35cell9 != null) {
				R35cell9.setCellValue(brf41a.getR35_no_of_accounts_non_uae_abu() == null ? 0 : brf41a.getR35_no_of_accounts_non_uae_abu().intValue());
			}
			Cell R35cell10 = row35.getCell(16); 
			if (R35cell10 != null) {
				R35cell10.setCellValue(brf41a.getR35_amount_non_uae_abu() == null ? 0 : brf41a.getR35_amount_non_uae_abu().intValue());
			}

			Cell R35cell11 = row35.getCell(18); 
			if (R35cell11 != null) {
				R35cell11.setCellValue(brf41a.getR35_no_of_accounts_uae_dubai() == null ? 0 : brf41a.getR35_no_of_accounts_uae_dubai().intValue());
			}
			Cell R35cell12 = row35.getCell(19); 
			if (R35cell12 != null) {
				R35cell12.setCellValue(brf41a.getR35_amount_uae_dubai() == null ? 0 : brf41a.getR35_amount_uae_dubai().intValue());
			}

			Cell R35cell13 = row35.getCell(20); 
			if (R35cell13 != null) {
				R35cell13.setCellValue(brf41a.getR35_no_of_accounts_non_uae_dubai() == null ? 0 : brf41a.getR35_no_of_accounts_non_uae_dubai().intValue());
			}
			Cell R35cell14 = row35.getCell(21); 
			if (R35cell14 != null) {
				R35cell14.setCellValue(brf41a.getR35_amount_non_uae_dubai() == null ? 0 : brf41a.getR35_amount_non_uae_dubai().intValue());
			}
			Cell R35cell15 = row35.getCell(23); 
			if (R35cell15 != null) {
				R35cell15.setCellValue(brf41a.getR35_no_of_accounts_uae_sharjah() == null ? 0 : brf41a.getR35_no_of_accounts_uae_sharjah().intValue());
			}
			Cell R35cell16 = row35.getCell(24); 
			if (R35cell16 != null) {
				R35cell16.setCellValue(brf41a.getR35_amount_uae_sharjah() == null ? 0 : brf41a.getR35_amount_uae_sharjah().intValue());
			}
			Cell  R35cell17 = row35.getCell(25); 
			if (R35cell17 != null) {
				R35cell17.setCellValue(brf41a.getR35_no_of_accounts_non_uae_sharjah() == null ? 0 : brf41a.getR35_no_of_accounts_non_uae_sharjah().intValue());
			}
			Cell  R35cell18 = row35.getCell(26); 
			if (R35cell18 != null) {
				R35cell18.setCellValue(brf41a.getR35_amount_non_uae_sharjah() == null ? 0 : brf41a.getR35_amount_non_uae_sharjah().intValue());
			}
			Cell  R35cell19 = row35.getCell(28); 
			if (R35cell19 != null) {
				R35cell19.setCellValue(brf41a.getR35_no_of_accounts_uae_ajman() == null ? 0 : brf41a.getR35_no_of_accounts_uae_ajman().intValue());
			}
			Cell  R35cell20 = row35.getCell(29); 
			if (R35cell20 != null) {
				R35cell20.setCellValue(brf41a.getR35_amount_uae_ajman() == null ? 0 : brf41a.getR35_amount_uae_ajman().intValue());
			}
			Cell  R35cell21 = row35.getCell(30); 
			if (R35cell21 != null) {
				R35cell21.setCellValue(brf41a.getR35_no_of_accounts_non_uae_ajman() == null ? 0 : brf41a.getR35_no_of_accounts_non_uae_ajman().intValue());
			}

			Cell R35cell22 = row35.getCell(31); 
			if (R35cell22 != null) {
				R35cell22.setCellValue(brf41a.getR35_amount_non_uae_ajman() == null ? 0 : brf41a.getR35_amount_non_uae_ajman().intValue());
			}
			Cell  R35cell23 = row35.getCell(33); 
			if (R35cell23 != null) {
				R35cell23.setCellValue(brf41a.getR35_no_of_accounts_uae_ras() == null ? 0 : brf41a.getR35_no_of_accounts_uae_ras().intValue());
			}
			Cell R35cell24 = row35.getCell(34); 
			if (R35cell24 != null) {
				R35cell24.setCellValue(brf41a.getR35_amount_uae_ras() == null ? 0 : brf41a.getR35_amount_uae_ras().intValue());
			}
			Cell  R35cell25 = row35.getCell(35); 
			if (R35cell25 != null) {
				R35cell25.setCellValue(brf41a.getR35_no_of_accounts_non_uae_ras() == null ? 0 : brf41a.getR35_no_of_accounts_non_uae_ras().intValue());
			}
			Cell  R35cell26 = row35.getCell(36); 
			if (R35cell26 != null) {
				R35cell26.setCellValue(brf41a.getR35_amount_non_uae_ras() == null ? 0 : brf41a.getR35_amount_non_uae_ras().intValue());
			}
			Cell  R35cell27 = row35.getCell(38); 
			if (R35cell27 != null) {
				R35cell27.setCellValue(brf41a.getR35_no_of_accounts_uae_umm() == null ? 0 : brf41a.getR35_no_of_accounts_uae_umm().intValue());
			}
			Cell  R35cell28 = row35.getCell(39); 
			if (R35cell28 != null) {
				R35cell28.setCellValue(brf41a.getR35_amount_uae_umm() == null ? 0 : brf41a.getR35_amount_uae_umm().intValue());
			}
			Cell  R35cell29 = row35.getCell(40); 
			if (R35cell29 != null) {
				R35cell29.setCellValue(brf41a.getR35_no_of_accounts_non_uae_umm() == null ? 0 : brf41a.getR35_no_of_accounts_non_uae_umm().intValue());
			}
			Cell  R35cell30 = row35.getCell(41); 
			if (R35cell30 != null) {
				R35cell30.setCellValue(brf41a.getR35_amount_non_uae_umm() == null ? 0 : brf41a.getR35_amount_non_uae_umm().intValue());
			}
			Cell  R35cell31 = row35.getCell(43); 
			if (R35cell31 != null) {
				R35cell31.setCellValue(brf41a.getR35_no_of_accounts_uae_fujairah() == null ? 0 : brf41a.getR35_no_of_accounts_uae_fujairah().intValue());
			}
			Cell  R35cell32 = row35.getCell(44); 
			if (R35cell32 != null) {
				R35cell32.setCellValue(brf41a.getR35_amount_uae_fujairah() == null ? 0 : brf41a.getR35_amount_uae_fujairah().intValue());
			}
			Cell  R35cell33 = row35.getCell(45); 
			if (R35cell33 != null) {
				R35cell33.setCellValue(brf41a.getR35_no_of_accounts_non_uae_fujairah() == null ? 0 : brf41a.getR35_no_of_accounts_non_uae_fujairah().intValue());
			}
									
			Cell  R35cell34 = row35.getCell(46); 
			if (R35cell34 != null) {
				R35cell34.setCellValue(brf41a.getR35_amount_non_uae_fujairah() == null ? 0 : brf41a.getR35_amount_non_uae_fujairah().intValue());
			}
		///ROW36
		  Row row36 = sheet.getRow(35);
		  Cell R36cell1 = row36.getCell(4); 
			if (R36cell1 != null) {
				R36cell1.setCellValue(brf41a.getR36_no_of_accounts_uae() == null ? 0 : brf41a.getR36_no_of_accounts_uae().intValue());
			}
			Cell R36cell2 = row36.getCell(5); 
			if (R36cell2 != null) {
				R36cell2.setCellValue(brf41a.getR36_amount_uae() == null ? 0 : brf41a.getR36_amount_uae().intValue());
			}
			Cell R36cell3 = row36.getCell(6); 
			if (R36cell3 != null) {
				R36cell3.setCellValue(brf41a.getR36_no_of_accounts_resident() == null ? 0 : brf41a.getR36_no_of_accounts_resident().intValue());
			}
			Cell R36cell4 = row36.getCell(7); 
			if (R36cell4 != null) {
				R36cell4.setCellValue(brf41a.getR36_amount_resident() == null ? 0 : brf41a.getR36_amount_resident().intValue());
			}
			Cell R36cell5 = row36.getCell(8); 
			if (R36cell5 != null) {
				R36cell5.setCellValue(brf41a.getR36_no_of_accounts_non_resident() == null ? 0 : brf41a.getR36_no_of_accounts_non_resident().intValue());
			}
			Cell R36cell6 = row36.getCell(9); 
			if (R36cell6 != null) {
				R36cell6.setCellValue(brf41a.getR36_amount_non_resident() == null ? 0 : brf41a.getR36_amount_non_resident().intValue());
			}
			Cell R36cell7 = row36.getCell(13); 
			if (R36cell7 != null) {
				R36cell7.setCellValue(brf41a.getR36_no_of_accounts_uae_abu() == null ? 0 : brf41a.getR36_no_of_accounts_uae_abu().intValue());
			}
			Cell R36cell8 = row36.getCell(14); 
			if (R36cell8 != null) {
				R36cell8.setCellValue(brf41a.getR36_amount_uae_abu() == null ? 0 : brf41a.getR36_amount_uae_abu().intValue());
			}
			Cell R36cell9 = row36.getCell(15); 
			if (R36cell9 != null) {
				R36cell9.setCellValue(brf41a.getR36_no_of_accounts_non_uae_abu() == null ? 0 : brf41a.getR36_no_of_accounts_non_uae_abu().intValue());
			}
			Cell R36cell10 = row36.getCell(16); 
			if (R36cell10 != null) {
				R36cell10.setCellValue(brf41a.getR36_amount_non_uae_abu() == null ? 0 : brf41a.getR36_amount_non_uae_abu().intValue());
			}

			Cell R36cell11 = row36.getCell(18); 
			if (R36cell11 != null) {
				R36cell11.setCellValue(brf41a.getR36_no_of_accounts_uae_dubai() == null ? 0 : brf41a.getR36_no_of_accounts_uae_dubai().intValue());
			}
			Cell R36cell12 = row36.getCell(19); 
			if (R36cell12 != null) {
				R36cell12.setCellValue(brf41a.getR36_amount_uae_dubai() == null ? 0 : brf41a.getR36_amount_uae_dubai().intValue());
			}

			Cell R36cell13 = row36.getCell(20); 
			if (R36cell13 != null) {
				R36cell13.setCellValue(brf41a.getR36_no_of_accounts_non_uae_dubai() == null ? 0 : brf41a.getR36_no_of_accounts_non_uae_dubai().intValue());
			}
			Cell R36cell14 = row36.getCell(21); 
			if (R36cell14 != null) {
				R36cell14.setCellValue(brf41a.getR36_amount_non_uae_dubai() == null ? 0 : brf41a.getR36_amount_non_uae_dubai().intValue());
			}
			Cell R36cell15 = row36.getCell(23); 
			if (R36cell15 != null) {
				R36cell15.setCellValue(brf41a.getR36_no_of_accounts_uae_sharjah() == null ? 0 : brf41a.getR36_no_of_accounts_uae_sharjah().intValue());
			}
			Cell R36cell16 = row36.getCell(24); 
			if (R36cell16 != null) {
				R36cell16.setCellValue(brf41a.getR36_amount_uae_sharjah() == null ? 0 : brf41a.getR36_amount_uae_sharjah().intValue());
			}
			Cell  R36cell17 = row36.getCell(25); 
			if (R36cell17 != null) {
				R36cell17.setCellValue(brf41a.getR36_no_of_accounts_non_uae_sharjah() == null ? 0 : brf41a.getR36_no_of_accounts_non_uae_sharjah().intValue());
			}
			Cell  R36cell18 = row36.getCell(26); 
			if (R36cell18 != null) {
				R36cell18.setCellValue(brf41a.getR36_amount_non_uae_sharjah() == null ? 0 : brf41a.getR36_amount_non_uae_sharjah().intValue());
			}
			Cell  R36cell19 = row36.getCell(28); 
			if (R36cell19 != null) {
				R36cell19.setCellValue(brf41a.getR36_no_of_accounts_uae_ajman() == null ? 0 : brf41a.getR36_no_of_accounts_uae_ajman().intValue());
			}

			Cell  R36cell20 = row36.getCell(29); 
			if (R36cell20 != null) {
				R36cell20.setCellValue(brf41a.getR36_amount_uae_ajman() == null ? 0 : brf41a.getR36_amount_uae_ajman().intValue());
			}
			Cell  R36cell21 = row36.getCell(30); 
			if (R36cell21 != null) {
				R36cell21.setCellValue(brf41a.getR36_no_of_accounts_non_uae_ajman() == null ? 0 : brf41a.getR36_no_of_accounts_non_uae_ajman().intValue());
			}

			Cell R36cell22 = row36.getCell(31); 
			if (R36cell22 != null) {
				R36cell22.setCellValue(brf41a.getR36_amount_non_uae_ajman() == null ? 0 : brf41a.getR36_amount_non_uae_ajman().intValue());
			}
			Cell  R36cell23 = row36.getCell(33); 
			if (R36cell23 != null) {
				R36cell23.setCellValue(brf41a.getR36_no_of_accounts_uae_ras() == null ? 0 : brf41a.getR36_no_of_accounts_uae_ras().intValue());
			}
			Cell R36cell24 = row36.getCell(34); 
			if (R36cell24 != null) {
				R36cell24.setCellValue(brf41a.getR36_amount_uae_ras() == null ? 0 : brf41a.getR36_amount_uae_ras().intValue());
			}
			Cell  R36cell25 = row36.getCell(35); 
			if (R36cell25 != null) {
				R36cell25.setCellValue(brf41a.getR36_no_of_accounts_non_uae_ras() == null ? 0 : brf41a.getR36_no_of_accounts_non_uae_ras().intValue());
			}
			Cell  R36cell26 = row36.getCell(36); 
			if (R36cell26 != null) {
				R36cell26.setCellValue(brf41a.getR36_amount_non_uae_ras() == null ? 0 : brf41a.getR36_amount_non_uae_ras().intValue());
			}
			Cell  R36cell27 = row36.getCell(38); 
			if (R36cell27 != null) {
				R36cell27.setCellValue(brf41a.getR36_no_of_accounts_uae_umm() == null ? 0 : brf41a.getR36_no_of_accounts_uae_umm().intValue());
			}
			Cell  R36cell28 = row36.getCell(39); 
			if (R36cell28 != null) {
				R36cell28.setCellValue(brf41a.getR36_amount_uae_umm() == null ? 0 : brf41a.getR36_amount_uae_umm().intValue());
			}
			Cell  R36cell29 = row36.getCell(40); 
			if (R36cell29 != null) {
				R36cell29.setCellValue(brf41a.getR36_no_of_accounts_non_uae_umm() == null ? 0 : brf41a.getR36_no_of_accounts_non_uae_umm().intValue());
			}
			Cell  R36cell30 = row36.getCell(41); 
			if (R36cell30 != null) {
				R36cell30.setCellValue(brf41a.getR36_amount_non_uae_umm() == null ? 0 : brf41a.getR36_amount_non_uae_umm().intValue());
			}
			Cell  R36cell31 = row36.getCell(43); 
			if (R36cell31 != null) {
				R36cell31.setCellValue(brf41a.getR36_no_of_accounts_uae_fujairah() == null ? 0 : brf41a.getR36_no_of_accounts_uae_fujairah().intValue());
			}
			Cell  R36cell32 = row36.getCell(44); 
			if (R36cell32 != null) {
				R36cell32.setCellValue(brf41a.getR36_amount_uae_fujairah() == null ? 0 : brf41a.getR36_amount_uae_fujairah().intValue());
			}
			Cell  R36cell33 = row36.getCell(45); 
			if (R36cell33 != null) {
				R36cell33.setCellValue(brf41a.getR36_no_of_accounts_non_uae_fujairah() == null ? 0 : brf41a.getR36_no_of_accounts_non_uae_fujairah().intValue());
			}
									
			Cell  R36cell34 = row36.getCell(46); 
			if (R36cell34 != null) {
				R36cell34.setCellValue(brf41a.getR36_amount_non_uae_fujairah() == null ? 0 : brf41a.getR36_amount_non_uae_fujairah().intValue());
			}
		///ROW37
		  Row row37 = sheet.getRow(36);
		  Cell R37cell1 = row37.getCell(4); 
			if (R37cell1 != null) {
				R37cell1.setCellValue(brf41a.getR37_no_of_accounts_uae() == null ? 0 : brf41a.getR37_no_of_accounts_uae().intValue());
			}
			Cell R37cell2 = row37.getCell(5); 
			if (R37cell2 != null) {
				R37cell2.setCellValue(brf41a.getR37_amount_uae() == null ? 0 : brf41a.getR37_amount_uae().intValue());
			}
			Cell R37cell3 = row37.getCell(6); 
			if (R37cell3 != null) {
				R37cell3.setCellValue(brf41a.getR37_no_of_accounts_resident() == null ? 0 : brf41a.getR37_no_of_accounts_resident().intValue());
			}
			Cell R37cell4 = row37.getCell(7); 
			if (R37cell4 != null) {
				R37cell4.setCellValue(brf41a.getR37_amount_resident() == null ? 0 : brf41a.getR37_amount_resident().intValue());
			}
			Cell R37cell5 = row37.getCell(8); 
			if (R37cell5 != null) {
				R37cell5.setCellValue(brf41a.getR37_no_of_accounts_non_resident() == null ? 0 : brf41a.getR37_no_of_accounts_non_resident().intValue());
			}
			Cell R37cell6 = row37.getCell(9); 
			if (R37cell6 != null) {
				R37cell6.setCellValue(brf41a.getR37_amount_non_resident() == null ? 0 : brf41a.getR37_amount_non_resident().intValue());
			}
			Cell R37cell7 = row37.getCell(13); 
			if (R37cell7 != null) {
				R37cell7.setCellValue(brf41a.getR37_no_of_accounts_uae_abu() == null ? 0 : brf41a.getR37_no_of_accounts_uae_abu().intValue());
			}
			Cell R37cell8 = row37.getCell(14); 
			if (R37cell8 != null) {
				R37cell8.setCellValue(brf41a.getR37_amount_uae_abu() == null ? 0 : brf41a.getR37_amount_uae_abu().intValue());
			}
			Cell R37cell9 = row37.getCell(15); 
			if (R37cell9 != null) {
				R37cell9.setCellValue(brf41a.getR37_no_of_accounts_non_uae_abu() == null ? 0 : brf41a.getR37_no_of_accounts_non_uae_abu().intValue());
			}
			Cell R37cell10 = row37.getCell(16); 
			if (R37cell10 != null) {
				R37cell10.setCellValue(brf41a.getR37_amount_non_uae_abu() == null ? 0 : brf41a.getR37_amount_non_uae_abu().intValue());
			}

			Cell R37cell11 = row37.getCell(18); 
			if (R37cell11 != null) {
				R37cell11.setCellValue(brf41a.getR37_no_of_accounts_uae_dubai() == null ? 0 : brf41a.getR37_no_of_accounts_uae_dubai().intValue());
			}
			Cell R37cell12 = row37.getCell(19); 
			if (R37cell12 != null) {
				R37cell12.setCellValue(brf41a.getR37_amount_uae_dubai() == null ? 0 : brf41a.getR37_amount_uae_dubai().intValue());
			}

			Cell R37cell13 = row37.getCell(20); 
			if (R37cell13 != null) {
				R37cell13.setCellValue(brf41a.getR37_no_of_accounts_non_uae_dubai() == null ? 0 : brf41a.getR37_no_of_accounts_non_uae_dubai().intValue());
			}
			Cell R37cell14 = row37.getCell(21); 
			if (R37cell14 != null) {
				R37cell14.setCellValue(brf41a.getR37_amount_non_uae_dubai() == null ? 0 : brf41a.getR37_amount_non_uae_dubai().intValue());
			}
			Cell R37cell15 = row37.getCell(23); 
			if (R37cell15 != null) {
				R37cell15.setCellValue(brf41a.getR37_no_of_accounts_uae_sharjah() == null ? 0 : brf41a.getR37_no_of_accounts_uae_sharjah().intValue());
			}
			Cell R37cell16 = row37.getCell(24); 
			if (R37cell16 != null) {
				R37cell16.setCellValue(brf41a.getR37_amount_uae_sharjah() == null ? 0 : brf41a.getR37_amount_uae_sharjah().intValue());
			}
			Cell  R37cell17 = row37.getCell(25); 
			if (R37cell17 != null) {
				R37cell17.setCellValue(brf41a.getR37_no_of_accounts_non_uae_sharjah() == null ? 0 : brf41a.getR37_no_of_accounts_non_uae_sharjah().intValue());
			}
			Cell  R37cell18 = row37.getCell(26); 
			if (R37cell18 != null) {
				R37cell18.setCellValue(brf41a.getR37_amount_non_uae_sharjah() == null ? 0 : brf41a.getR37_amount_non_uae_sharjah().intValue());
			}
			Cell  R37cell19 = row37.getCell(28); 
			if (R37cell19 != null) {
				R37cell19.setCellValue(brf41a.getR37_no_of_accounts_uae_ajman() == null ? 0 : brf41a.getR37_no_of_accounts_uae_ajman().intValue());
			}

			Cell  R37cell20 = row37.getCell(29); 
			if (R37cell20 != null) {
				R37cell20.setCellValue(brf41a.getR37_amount_uae_ajman() == null ? 0 : brf41a.getR37_amount_uae_ajman().intValue());
			}
			Cell  R37cell21 = row37.getCell(30); 
			if (R37cell21 != null) {
				R37cell21.setCellValue(brf41a.getR37_no_of_accounts_non_uae_ajman() == null ? 0 : brf41a.getR37_no_of_accounts_non_uae_ajman().intValue());
			}

			Cell R37cell22 = row37.getCell(31); 
			if (R37cell22 != null) {
				R37cell22.setCellValue(brf41a.getR37_amount_non_uae_ajman() == null ? 0 : brf41a.getR37_amount_non_uae_ajman().intValue());
			}
			Cell  R37cell23 = row37.getCell(33); 
			if (R37cell23 != null) {
				R37cell23.setCellValue(brf41a.getR37_no_of_accounts_uae_ras() == null ? 0 : brf41a.getR37_no_of_accounts_uae_ras().intValue());
			}
			Cell R37cell24 = row37.getCell(34); 
			if (R37cell24 != null) {
				R37cell24.setCellValue(brf41a.getR37_amount_uae_ras() == null ? 0 : brf41a.getR37_amount_uae_ras().intValue());
			}
			Cell  R37cell25 = row37.getCell(35); 
			if (R37cell25 != null) {
				R37cell25.setCellValue(brf41a.getR37_no_of_accounts_non_uae_ras() == null ? 0 : brf41a.getR37_no_of_accounts_non_uae_ras().intValue());
			}
			Cell  R37cell26 = row37.getCell(36); 
			if (R37cell26 != null) {
				R37cell26.setCellValue(brf41a.getR37_amount_non_uae_ras() == null ? 0 : brf41a.getR37_amount_non_uae_ras().intValue());
			}
			Cell  R37cell27 = row37.getCell(38); 
			if (R37cell27 != null) {
				R37cell27.setCellValue(brf41a.getR37_no_of_accounts_uae_umm() == null ? 0 : brf41a.getR37_no_of_accounts_uae_umm().intValue());
			}
			Cell  R37cell28 = row37.getCell(39); 
			if (R37cell28 != null) {
				R37cell28.setCellValue(brf41a.getR37_amount_uae_umm() == null ? 0 : brf41a.getR37_amount_uae_umm().intValue());
			}
			Cell  R37cell29 = row37.getCell(40); 
			if (R37cell29 != null) {
				R37cell29.setCellValue(brf41a.getR37_no_of_accounts_non_uae_umm() == null ? 0 : brf41a.getR37_no_of_accounts_non_uae_umm().intValue());
			}
			Cell  R37cell30 = row37.getCell(41); 
			if (R37cell30 != null) {
				R37cell30.setCellValue(brf41a.getR37_amount_non_uae_umm() == null ? 0 : brf41a.getR37_amount_non_uae_umm().intValue());
			}
			Cell  R37cell31 = row37.getCell(43); 
			if (R37cell31 != null) {
				R37cell31.setCellValue(brf41a.getR37_no_of_accounts_uae_fujairah() == null ? 0 : brf41a.getR37_no_of_accounts_uae_fujairah().intValue());
			}
			Cell  R37cell32 = row37.getCell(44); 
			if (R37cell32 != null) {
				R37cell32.setCellValue(brf41a.getR37_amount_uae_fujairah() == null ? 0 : brf41a.getR37_amount_uae_fujairah().intValue());
			}
			Cell  R37cell33 = row37.getCell(45); 
			if (R37cell33 != null) {
				R37cell33.setCellValue(brf41a.getR37_no_of_accounts_non_uae_fujairah() == null ? 0 : brf41a.getR37_no_of_accounts_non_uae_fujairah().intValue());
			}
									
			Cell  R37cell34 = row37.getCell(46); 
			if (R37cell34 != null) {
				R37cell34.setCellValue(brf41a.getR37_amount_non_uae_fujairah() == null ? 0 : brf41a.getR37_amount_non_uae_fujairah().intValue());
			}
		///ROW38
		  Row row38 = sheet.getRow(37);
		  Cell R38cell1 = row38.getCell(4); 
			if (R38cell1 != null) {
				R38cell1.setCellValue(brf41a.getR38_no_of_accounts_uae() == null ? 0 : brf41a.getR38_no_of_accounts_uae().intValue());
			}
			Cell R38cell2 = row38.getCell(5); 
			if (R38cell2 != null) {
				R38cell2.setCellValue(brf41a.getR38_amount_uae() == null ? 0 : brf41a.getR38_amount_uae().intValue());
			}
			Cell R38cell3 = row38.getCell(6); 
			if (R38cell3 != null) {
				R38cell3.setCellValue(brf41a.getR38_no_of_accounts_resident() == null ? 0 : brf41a.getR38_no_of_accounts_resident().intValue());
			}
			Cell R38cell4 = row38.getCell(7); 
			if (R38cell4 != null) {
				R38cell4.setCellValue(brf41a.getR38_amount_resident() == null ? 0 : brf41a.getR38_amount_resident().intValue());
			}
			Cell R38cell5 = row38.getCell(8); 
			if (R38cell5 != null) {
				R38cell5.setCellValue(brf41a.getR38_no_of_accounts_non_resident() == null ? 0 : brf41a.getR38_no_of_accounts_non_resident().intValue());
			}
			Cell R38cell6 = row38.getCell(9); 
			if (R38cell6 != null) {
				R38cell6.setCellValue(brf41a.getR38_amount_non_resident() == null ? 0 : brf41a.getR38_amount_non_resident().intValue());
			}
			Cell R38cell7 = row38.getCell(13); 
			if (R38cell7 != null) {
				R38cell7.setCellValue(brf41a.getR38_no_of_accounts_uae_abu() == null ? 0 : brf41a.getR38_no_of_accounts_uae_abu().intValue());
			}
			Cell R38cell8 = row38.getCell(14); 
			if (R38cell8 != null) {
				R38cell8.setCellValue(brf41a.getR38_amount_uae_abu() == null ? 0 : brf41a.getR38_amount_uae_abu().intValue());
			}
			Cell R38cell9 = row38.getCell(15); 
			if (R38cell9 != null) {
				R38cell9.setCellValue(brf41a.getR38_no_of_accounts_non_uae_abu() == null ? 0 : brf41a.getR38_no_of_accounts_non_uae_abu().intValue());
			}
			Cell R38cell10 = row38.getCell(16); 
			if (R38cell10 != null) {
				R38cell10.setCellValue(brf41a.getR38_amount_non_uae_abu() == null ? 0 : brf41a.getR38_amount_non_uae_abu().intValue());
			}

			Cell R38cell11 = row38.getCell(18); 
			if (R38cell11 != null) {
				R38cell11.setCellValue(brf41a.getR38_no_of_accounts_uae_dubai() == null ? 0 : brf41a.getR38_no_of_accounts_uae_dubai().intValue());
			}
			Cell R38cell12 = row38.getCell(19); 
			if (R38cell12 != null) {
				R38cell12.setCellValue(brf41a.getR38_amount_uae_dubai() == null ? 0 : brf41a.getR38_amount_uae_dubai().intValue());
			}

			Cell R38cell13 = row38.getCell(20); 
			if (R38cell13 != null) {
				R38cell13.setCellValue(brf41a.getR38_no_of_accounts_non_uae_dubai() == null ? 0 : brf41a.getR38_no_of_accounts_non_uae_dubai().intValue());
			}
			Cell R38cell14 = row38.getCell(21); 
			if (R38cell14 != null) {
				R38cell14.setCellValue(brf41a.getR38_amount_non_uae_dubai() == null ? 0 : brf41a.getR38_amount_non_uae_dubai().intValue());
			}
			Cell R38cell15 = row38.getCell(23); 
			if (R38cell15 != null) {
				R38cell15.setCellValue(brf41a.getR38_no_of_accounts_uae_sharjah() == null ? 0 : brf41a.getR38_no_of_accounts_uae_sharjah().intValue());
			}
			Cell R38cell16 = row38.getCell(24); 
			if (R38cell16 != null) {
				R38cell16.setCellValue(brf41a.getR38_amount_uae_sharjah() == null ? 0 : brf41a.getR38_amount_uae_sharjah().intValue());
			}
			Cell  R38cell17 = row38.getCell(25); 
			if (R38cell17 != null) {
				R38cell17.setCellValue(brf41a.getR38_no_of_accounts_non_uae_sharjah() == null ? 0 : brf41a.getR38_no_of_accounts_non_uae_sharjah().intValue());
			}
			Cell  R38cell18 = row38.getCell(26); 
			if (R38cell18 != null) {
				R38cell18.setCellValue(brf41a.getR38_amount_non_uae_sharjah() == null ? 0 : brf41a.getR38_amount_non_uae_sharjah().intValue());
			}
			Cell  R38cell19 = row38.getCell(28); 
			if (R38cell19 != null) {
				R38cell19.setCellValue(brf41a.getR38_no_of_accounts_uae_ajman() == null ? 0 : brf41a.getR38_no_of_accounts_uae_ajman().intValue());
			}

			Cell  R38cell20 = row38.getCell(29); 
			if (R38cell20 != null) {
				R38cell20.setCellValue(brf41a.getR38_amount_uae_ajman() == null ? 0 : brf41a.getR38_amount_uae_ajman().intValue());
			}
			Cell  R38cell21 = row38.getCell(30); 
			if (R38cell21 != null) {
				R38cell21.setCellValue(brf41a.getR38_no_of_accounts_non_uae_ajman() == null ? 0 : brf41a.getR38_no_of_accounts_non_uae_ajman().intValue());
			}

			Cell R38cell22 = row38.getCell(31); 
			if (R38cell22 != null) {
				R38cell22.setCellValue(brf41a.getR38_amount_non_uae_ajman() == null ? 0 : brf41a.getR38_amount_non_uae_ajman().intValue());
			}
			Cell  R38cell23 = row38.getCell(33); 
			if (R38cell23 != null) {
				R38cell23.setCellValue(brf41a.getR38_no_of_accounts_uae_ras() == null ? 0 : brf41a.getR38_no_of_accounts_uae_ras().intValue());
			}
			Cell R38cell24 = row38.getCell(34); 
			if (R38cell24 != null) {
				R38cell24.setCellValue(brf41a.getR38_amount_uae_ras() == null ? 0 : brf41a.getR38_amount_uae_ras().intValue());
			}
			Cell  R38cell25 = row38.getCell(35); 
			if (R38cell25 != null) {
				R38cell25.setCellValue(brf41a.getR38_no_of_accounts_non_uae_ras() == null ? 0 : brf41a.getR38_no_of_accounts_non_uae_ras().intValue());
			}
			Cell  R38cell26 = row38.getCell(36); 
			if (R38cell26 != null) {
				R38cell26.setCellValue(brf41a.getR38_amount_non_uae_ras() == null ? 0 : brf41a.getR38_amount_non_uae_ras().intValue());
			}
			Cell  R38cell27 = row38.getCell(38); 
			if (R38cell27 != null) {
				R38cell27.setCellValue(brf41a.getR38_no_of_accounts_uae_umm() == null ? 0 : brf41a.getR38_no_of_accounts_uae_umm().intValue());
			}
			Cell  R38cell28 = row38.getCell(39); 
			if (R38cell28 != null) {
				R38cell28.setCellValue(brf41a.getR38_amount_uae_umm() == null ? 0 : brf41a.getR38_amount_uae_umm().intValue());
			}
			Cell  R38cell29 = row38.getCell(40); 
			if (R38cell29 != null) {
				R38cell29.setCellValue(brf41a.getR38_no_of_accounts_non_uae_umm() == null ? 0 : brf41a.getR38_no_of_accounts_non_uae_umm().intValue());
			}
			Cell  R38cell30 = row38.getCell(41); 
			if (R38cell30 != null) {
				R38cell30.setCellValue(brf41a.getR38_amount_non_uae_umm() == null ? 0 : brf41a.getR38_amount_non_uae_umm().intValue());
			}
			Cell  R38cell31 = row38.getCell(43); 
			if (R38cell31 != null) {
				R38cell31.setCellValue(brf41a.getR38_no_of_accounts_uae_fujairah() == null ? 0 : brf41a.getR38_no_of_accounts_uae_fujairah().intValue());
			}
			Cell  R38cell32 = row38.getCell(44); 
			if (R38cell32 != null) {
				R38cell32.setCellValue(brf41a.getR38_amount_uae_fujairah() == null ? 0 : brf41a.getR38_amount_uae_fujairah().intValue());
			}
			Cell  R38cell33 = row38.getCell(45); 
			if (R38cell33 != null) {
				R38cell33.setCellValue(brf41a.getR38_no_of_accounts_non_uae_fujairah() == null ? 0 : brf41a.getR38_no_of_accounts_non_uae_fujairah().intValue());
			}
									
			Cell  R38cell34 = row38.getCell(46); 
			if (R38cell34 != null) {
				R38cell34.setCellValue(brf41a.getR38_amount_non_uae_fujairah() == null ? 0 : brf41a.getR38_amount_non_uae_fujairah().intValue());
			}
		///ROW39
		  Row row39 = sheet.getRow(38);
		  Cell R39cell1 = row39.getCell(4); 
			if (R39cell1 != null) {
				R39cell1.setCellValue(brf41a.getR39_no_of_accounts_uae() == null ? 0 : brf41a.getR39_no_of_accounts_uae().intValue());
			}
			Cell R39cell2 = row39.getCell(5); 
			if (R39cell2 != null) {
				R39cell2.setCellValue(brf41a.getR39_amount_uae() == null ? 0 : brf41a.getR39_amount_uae().intValue());
			}
			Cell R39cell3 = row39.getCell(6); 
			if (R39cell3 != null) {
				R39cell3.setCellValue(brf41a.getR39_no_of_accounts_resident() == null ? 0 : brf41a.getR39_no_of_accounts_resident().intValue());
			}
			Cell R39cell4 = row39.getCell(7); 
			if (R39cell4 != null) {
				R39cell4.setCellValue(brf41a.getR39_amount_resident() == null ? 0 : brf41a.getR39_amount_resident().intValue());
			}
			Cell R39cell5 = row39.getCell(8); 
			if (R39cell5 != null) {
				R39cell5.setCellValue(brf41a.getR39_no_of_accounts_non_resident() == null ? 0 : brf41a.getR39_no_of_accounts_non_resident().intValue());
			}
			Cell R39cell6 = row39.getCell(9); 
			if (R39cell6 != null) {
				R39cell6.setCellValue(brf41a.getR39_amount_non_resident() == null ? 0 : brf41a.getR39_amount_non_resident().intValue());
			}
			Cell R39cell7 = row39.getCell(13); 
			if (R39cell7 != null) {
				R39cell7.setCellValue(brf41a.getR39_no_of_accounts_uae_abu() == null ? 0 : brf41a.getR39_no_of_accounts_uae_abu().intValue());
			}
			Cell R39cell8 = row39.getCell(14); 
			if (R39cell8 != null) {
				R39cell8.setCellValue(brf41a.getR39_amount_uae_abu() == null ? 0 : brf41a.getR39_amount_uae_abu().intValue());
			}
			Cell R39cell9 = row39.getCell(15); 
			if (R39cell9 != null) {
				R39cell9.setCellValue(brf41a.getR39_no_of_accounts_non_uae_abu() == null ? 0 : brf41a.getR39_no_of_accounts_non_uae_abu().intValue());
			}
			Cell R39cell10 = row39.getCell(16); 
			if (R39cell10 != null) {
				R39cell10.setCellValue(brf41a.getR39_amount_non_uae_abu() == null ? 0 : brf41a.getR39_amount_non_uae_abu().intValue());
			}

			Cell R39cell11 = row39.getCell(18); 
			if (R39cell11 != null) {
				R39cell11.setCellValue(brf41a.getR39_no_of_accounts_uae_dubai() == null ? 0 : brf41a.getR39_no_of_accounts_uae_dubai().intValue());
			}
			Cell R39cell12 = row39.getCell(19); 
			if (R39cell12 != null) {
				R39cell12.setCellValue(brf41a.getR39_amount_uae_dubai() == null ? 0 : brf41a.getR39_amount_uae_dubai().intValue());
			}

			Cell R39cell13 = row39.getCell(20); 
			if (R39cell13 != null) {
				R39cell13.setCellValue(brf41a.getR39_no_of_accounts_non_uae_dubai() == null ? 0 : brf41a.getR39_no_of_accounts_non_uae_dubai().intValue());
			}
			Cell R39cell14 = row39.getCell(21); 
			if (R39cell14 != null) {
				R39cell14.setCellValue(brf41a.getR39_amount_non_uae_dubai() == null ? 0 : brf41a.getR39_amount_non_uae_dubai().intValue());
			}
			Cell R39cell15 = row39.getCell(23); 
			if (R39cell15 != null) {
				R39cell15.setCellValue(brf41a.getR39_no_of_accounts_uae_sharjah() == null ? 0 : brf41a.getR39_no_of_accounts_uae_sharjah().intValue());
			}
			Cell R39cell16 = row39.getCell(24); 
			if (R39cell16 != null) {
				R39cell16.setCellValue(brf41a.getR39_amount_uae_sharjah() == null ? 0 : brf41a.getR39_amount_uae_sharjah().intValue());
			}
			Cell  R39cell17 = row39.getCell(25); 
			if (R39cell17 != null) {
				R39cell17.setCellValue(brf41a.getR39_no_of_accounts_non_uae_sharjah() == null ? 0 : brf41a.getR39_no_of_accounts_non_uae_sharjah().intValue());
			}
			Cell  R39cell18 = row39.getCell(26); 
			if (R39cell18 != null) {
				R39cell18.setCellValue(brf41a.getR39_amount_non_uae_sharjah() == null ? 0 : brf41a.getR39_amount_non_uae_sharjah().intValue());
			}
			Cell  R39cell19 = row39.getCell(28); 
			if (R39cell19 != null) {
				R39cell19.setCellValue(brf41a.getR39_no_of_accounts_uae_ajman() == null ? 0 : brf41a.getR39_no_of_accounts_uae_ajman().intValue());
			}

			Cell  R39cell20 = row39.getCell(29); 
			if (R39cell20 != null) {
				R39cell20.setCellValue(brf41a.getR39_amount_uae_ajman() == null ? 0 : brf41a.getR39_amount_uae_ajman().intValue());
			}
			Cell  R39cell21 = row39.getCell(30); 
			if (R39cell21 != null) {
				R39cell21.setCellValue(brf41a.getR39_no_of_accounts_non_uae_ajman() == null ? 0 : brf41a.getR39_no_of_accounts_non_uae_ajman().intValue());
			}

			Cell R39cell22 = row39.getCell(31); 
			if (R39cell22 != null) {
				R39cell22.setCellValue(brf41a.getR39_amount_non_uae_ajman() == null ? 0 : brf41a.getR39_amount_non_uae_ajman().intValue());
			}
			Cell  R39cell23 = row39.getCell(33); 
			if (R39cell23 != null) {
				R39cell23.setCellValue(brf41a.getR39_no_of_accounts_uae_ras() == null ? 0 : brf41a.getR39_no_of_accounts_uae_ras().intValue());
			}
			Cell R39cell24 = row39.getCell(34); 
			if (R39cell24 != null) {
				R39cell24.setCellValue(brf41a.getR39_amount_uae_ras() == null ? 0 : brf41a.getR39_amount_uae_ras().intValue());
			}
			Cell  R39cell25 = row39.getCell(35); 
			if (R39cell25 != null) {
				R39cell25.setCellValue(brf41a.getR39_no_of_accounts_non_uae_ras() == null ? 0 : brf41a.getR39_no_of_accounts_non_uae_ras().intValue());
			}
			Cell  R39cell26 = row39.getCell(36); 
			if (R39cell26 != null) {
				R39cell26.setCellValue(brf41a.getR39_amount_non_uae_ras() == null ? 0 : brf41a.getR39_amount_non_uae_ras().intValue());
			}
			Cell  R39cell27 = row39.getCell(38); 
			if (R39cell27 != null) {
				R39cell27.setCellValue(brf41a.getR39_no_of_accounts_uae_umm() == null ? 0 : brf41a.getR39_no_of_accounts_uae_umm().intValue());
			}
			Cell  R39cell28 = row39.getCell(39); 
			if (R39cell28 != null) {
				R39cell28.setCellValue(brf41a.getR39_amount_uae_umm() == null ? 0 : brf41a.getR39_amount_uae_umm().intValue());
			}
			Cell  R39cell29 = row39.getCell(40); 
			if (R39cell29 != null) {
				R39cell29.setCellValue(brf41a.getR39_no_of_accounts_non_uae_umm() == null ? 0 : brf41a.getR39_no_of_accounts_non_uae_umm().intValue());
			}
			Cell  R39cell30 = row39.getCell(41); 
			if (R39cell30 != null) {
				R39cell30.setCellValue(brf41a.getR39_amount_non_uae_umm() == null ? 0 : brf41a.getR39_amount_non_uae_umm().intValue());
			}
			Cell  R39cell31 = row39.getCell(43); 
			if (R39cell31 != null) {
				R39cell31.setCellValue(brf41a.getR39_no_of_accounts_uae_fujairah() == null ? 0 : brf41a.getR39_no_of_accounts_uae_fujairah().intValue());
			}
			Cell  R39cell32 = row39.getCell(44); 
			if (R39cell32 != null) {
				R39cell32.setCellValue(brf41a.getR39_amount_uae_fujairah() == null ? 0 : brf41a.getR39_amount_uae_fujairah().intValue());
			}
			Cell  R39cell33 = row39.getCell(45); 
			if (R39cell33 != null) {
				R39cell33.setCellValue(brf41a.getR39_no_of_accounts_non_uae_fujairah() == null ? 0 : brf41a.getR39_no_of_accounts_non_uae_fujairah().intValue());
			}
									
			Cell  R39cell34 = row39.getCell(46); 
			if (R39cell34 != null) {
				R39cell34.setCellValue(brf41a.getR39_amount_non_uae_fujairah() == null ? 0 : brf41a.getR39_amount_non_uae_fujairah().intValue());
			}
		///ROW40
		  Row row40 = sheet.getRow(39);
		  Cell R40cell1 = row40.getCell(4); 
			if (R40cell1 != null) {
				R40cell1.setCellValue(brf41a.getR40_no_of_accounts_uae() == null ? 0 : brf41a.getR40_no_of_accounts_uae().intValue());
			}
			Cell R40cell2 = row40.getCell(5); 
			if (R40cell2 != null) {
				R40cell2.setCellValue(brf41a.getR40_amount_uae() == null ? 0 : brf41a.getR40_amount_uae().intValue());
			}
			Cell R40cell3 = row40.getCell(6); 
			if (R40cell3 != null) {
				R40cell3.setCellValue(brf41a.getR40_no_of_accounts_resident() == null ? 0 : brf41a.getR40_no_of_accounts_resident().intValue());
			}
			Cell R40cell4 = row40.getCell(7); 
			if (R40cell4 != null) {
				R40cell4.setCellValue(brf41a.getR40_amount_resident() == null ? 0 : brf41a.getR40_amount_resident().intValue());
			}
			Cell R40cell5 = row40.getCell(8); 
			if (R40cell5 != null) {
				R40cell5.setCellValue(brf41a.getR40_no_of_accounts_non_resident() == null ? 0 : brf41a.getR40_no_of_accounts_non_resident().intValue());
			}
			Cell R40cell6 = row40.getCell(9); 
			if (R40cell6 != null) {
				R40cell6.setCellValue(brf41a.getR40_amount_non_resident() == null ? 0 : brf41a.getR40_amount_non_resident().intValue());
			}
			Cell R40cell7 = row40.getCell(13); 
			if (R40cell7 != null) {
				R40cell7.setCellValue(brf41a.getR40_no_of_accounts_uae_abu() == null ? 0 : brf41a.getR40_no_of_accounts_uae_abu().intValue());
			}
			Cell R40cell8 = row40.getCell(14); 
			if (R40cell8 != null) {
				R40cell8.setCellValue(brf41a.getR40_amount_uae_abu() == null ? 0 : brf41a.getR40_amount_uae_abu().intValue());
			}
			Cell R40cell9 = row40.getCell(15); 
			if (R40cell9 != null) {
				R40cell9.setCellValue(brf41a.getR40_no_of_accounts_non_uae_abu() == null ? 0 : brf41a.getR40_no_of_accounts_non_uae_abu().intValue());
			}
			Cell R40cell10 = row40.getCell(16); 
			if (R40cell10 != null) {
				R40cell10.setCellValue(brf41a.getR40_amount_non_uae_abu() == null ? 0 : brf41a.getR40_amount_non_uae_abu().intValue());
			}

			Cell R40cell11 = row40.getCell(18); 
			if (R40cell11 != null) {
				R40cell11.setCellValue(brf41a.getR40_no_of_accounts_uae_dubai() == null ? 0 : brf41a.getR40_no_of_accounts_uae_dubai().intValue());
			}
			Cell R40cell12 = row40.getCell(19); 
			if (R40cell12 != null) {
				R40cell12.setCellValue(brf41a.getR40_amount_uae_dubai() == null ? 0 : brf41a.getR40_amount_uae_dubai().intValue());
			}

			Cell R40cell13 = row40.getCell(20); 
			if (R40cell13 != null) {
				R40cell13.setCellValue(brf41a.getR40_no_of_accounts_non_uae_dubai() == null ? 0 : brf41a.getR40_no_of_accounts_non_uae_dubai().intValue());
			}
			Cell R40cell14 = row40.getCell(21); 
			if (R40cell14 != null) {
				R40cell14.setCellValue(brf41a.getR40_amount_non_uae_dubai() == null ? 0 : brf41a.getR40_amount_non_uae_dubai().intValue());
			}
			Cell R40cell15 = row40.getCell(23); 
			if (R40cell15 != null) {
				R40cell15.setCellValue(brf41a.getR40_no_of_accounts_uae_sharjah() == null ? 0 : brf41a.getR40_no_of_accounts_uae_sharjah().intValue());
			}
			Cell R40cell16 = row40.getCell(24); 
			if (R40cell16 != null) {
				R40cell16.setCellValue(brf41a.getR40_amount_uae_sharjah() == null ? 0 : brf41a.getR40_amount_uae_sharjah().intValue());
			}
			Cell  R40cell17 = row40.getCell(25); 
			if (R40cell17 != null) {
				R40cell17.setCellValue(brf41a.getR40_no_of_accounts_non_uae_sharjah() == null ? 0 : brf41a.getR40_no_of_accounts_non_uae_sharjah().intValue());
			}
			Cell  R40cell18 = row40.getCell(26); 
			if (R40cell18 != null) {
				R40cell18.setCellValue(brf41a.getR40_amount_non_uae_sharjah() == null ? 0 : brf41a.getR40_amount_non_uae_sharjah().intValue());
			}
			Cell  R40cell19 = row40.getCell(28); 
			if (R40cell19 != null) {
				R40cell19.setCellValue(brf41a.getR40_no_of_accounts_uae_ajman() == null ? 0 : brf41a.getR40_no_of_accounts_uae_ajman().intValue());
			}

			Cell  R40cell20 = row40.getCell(29); 
			if (R40cell20 != null) {
				R40cell20.setCellValue(brf41a.getR40_amount_uae_ajman() == null ? 0 : brf41a.getR40_amount_uae_ajman().intValue());
			}
			Cell  R40cell21 = row40.getCell(30); 
			if (R40cell21 != null) {
				R40cell21.setCellValue(brf41a.getR40_no_of_accounts_non_uae_ajman() == null ? 0 : brf41a.getR40_no_of_accounts_non_uae_ajman().intValue());
			}

			Cell R40cell22 = row40.getCell(31); 
			if (R40cell22 != null) {
				R40cell22.setCellValue(brf41a.getR40_amount_non_uae_ajman() == null ? 0 : brf41a.getR40_amount_non_uae_ajman().intValue());
			}
			Cell  R40cell23 = row40.getCell(33); 
			if (R40cell23 != null) {
				R40cell23.setCellValue(brf41a.getR40_no_of_accounts_uae_ras() == null ? 0 : brf41a.getR40_no_of_accounts_uae_ras().intValue());
			}
			Cell R40cell24 = row40.getCell(34); 
			if (R40cell24 != null) {
				R40cell24.setCellValue(brf41a.getR40_amount_uae_ras() == null ? 0 : brf41a.getR40_amount_uae_ras().intValue());
			}
			Cell  R40cell25 = row40.getCell(35); 
			if (R40cell25 != null) {
				R40cell25.setCellValue(brf41a.getR40_no_of_accounts_non_uae_ras() == null ? 0 : brf41a.getR40_no_of_accounts_non_uae_ras().intValue());
			}
			Cell  R40cell26 = row40.getCell(36); 
			if (R40cell26 != null) {
				R40cell26.setCellValue(brf41a.getR40_amount_non_uae_ras() == null ? 0 : brf41a.getR40_amount_non_uae_ras().intValue());
			}
			Cell  R40cell27 = row40.getCell(38); 
			if (R40cell27 != null) {
				R40cell27.setCellValue(brf41a.getR40_no_of_accounts_uae_umm() == null ? 0 : brf41a.getR40_no_of_accounts_uae_umm().intValue());
			}
			Cell  R40cell28 = row40.getCell(39); 
			if (R40cell28 != null) {
				R40cell28.setCellValue(brf41a.getR40_amount_uae_umm() == null ? 0 : brf41a.getR40_amount_uae_umm().intValue());
			}
			Cell  R40cell29 = row40.getCell(40); 
			if (R40cell29 != null) {
				R40cell29.setCellValue(brf41a.getR40_no_of_accounts_non_uae_umm() == null ? 0 : brf41a.getR40_no_of_accounts_non_uae_umm().intValue());
			}
			Cell  R40cell30 = row40.getCell(41); 
			if (R40cell30 != null) {
				R40cell30.setCellValue(brf41a.getR40_amount_non_uae_umm() == null ? 0 : brf41a.getR40_amount_non_uae_umm().intValue());
			}
			Cell  R40cell31 = row40.getCell(43); 
			if (R40cell31 != null) {
				R40cell31.setCellValue(brf41a.getR40_no_of_accounts_uae_fujairah() == null ? 0 : brf41a.getR40_no_of_accounts_uae_fujairah().intValue());
			}
			Cell  R40cell32 = row40.getCell(44); 
			if (R40cell32 != null) {
				R40cell32.setCellValue(brf41a.getR40_amount_uae_fujairah() == null ? 0 : brf41a.getR40_amount_uae_fujairah().intValue());
			}
			Cell  R40cell33 = row40.getCell(45); 
			if (R40cell33 != null) {
				R40cell33.setCellValue(brf41a.getR40_no_of_accounts_non_uae_fujairah() == null ? 0 : brf41a.getR40_no_of_accounts_non_uae_fujairah().intValue());
			}
									
			Cell  R40cell34 = row40.getCell(46); 
			if (R40cell34 != null) {
				R40cell34.setCellValue(brf41a.getR40_amount_non_uae_fujairah() == null ? 0 : brf41a.getR40_amount_non_uae_fujairah().intValue());
			}
    }
}

public void updateSheetWithEntity3Data(Sheet sheet, List<BRF41_Entity3> BRF41_Entity3) {
    if (BRF41_Entity3.size() == 1) {
        BRF41_Entity3 brf41b = BRF41_Entity3.get(0);
        
      ///ROW42
		  Row row42 = sheet.getRow(41);
		  Cell R42cell1 = row42.getCell(4); 
			if (R42cell1 != null) {
				R42cell1.setCellValue(brf41b.getR42_no_of_accounts_uae() == null ? 0 : brf41b.getR42_no_of_accounts_uae().intValue());
			}
			Cell R42cell2 = row42.getCell(5); 
			if (R42cell2 != null) {
				R42cell2.setCellValue(brf41b.getR42_amount_uae() == null ? 0 : brf41b.getR42_amount_uae().intValue());
			}
			Cell R42cell3 = row42.getCell(6); 
			if (R42cell3 != null) {
				R42cell3.setCellValue(brf41b.getR42_no_of_accounts_resident() == null ? 0 : brf41b.getR42_no_of_accounts_resident().intValue());
			}
			Cell R42cell4 = row42.getCell(7); 
			if (R42cell4 != null) {
				R42cell4.setCellValue(brf41b.getR42_amount_resident() == null ? 0 : brf41b.getR42_amount_resident().intValue());
			}
			Cell R42cell5 = row42.getCell(8); 
			if (R42cell5 != null) {
				R42cell5.setCellValue(brf41b.getR42_no_of_accounts_non_resident() == null ? 0 : brf41b.getR42_no_of_accounts_non_resident().intValue());
			}
			Cell R42cell6 = row42.getCell(9); 
			if (R42cell6 != null) {
				R42cell6.setCellValue(brf41b.getR42_amount_non_resident() == null ? 0 : brf41b.getR42_amount_non_resident().intValue());
			}
			Cell R42cell7 = row42.getCell(13); 
			if (R42cell7 != null) {
				R42cell7.setCellValue(brf41b.getR42_no_of_accounts_uae_abu() == null ? 0 : brf41b.getR42_no_of_accounts_uae_abu().intValue());
			}
			Cell R42cell8 = row42.getCell(14); 
			if (R42cell8 != null) {
				R42cell8.setCellValue(brf41b.getR42_amount_uae_abu() == null ? 0 : brf41b.getR42_amount_uae_abu().intValue());
			}
			Cell R42cell9 = row42.getCell(15); 
			if (R42cell9 != null) {
				R42cell9.setCellValue(brf41b.getR42_no_of_accounts_non_uae_abu() == null ? 0 : brf41b.getR42_no_of_accounts_non_uae_abu().intValue());
			}
			Cell R42cell10 = row42.getCell(16); 
			if (R42cell10 != null) {
				R42cell10.setCellValue(brf41b.getR42_amount_non_uae_abu() == null ? 0 : brf41b.getR42_amount_non_uae_abu().intValue());
			}

			Cell R42cell11 = row42.getCell(18); 
			if (R42cell11 != null) {
				R42cell11.setCellValue(brf41b.getR42_no_of_accounts_uae_dubai() == null ? 0 : brf41b.getR42_no_of_accounts_uae_dubai().intValue());
			}
			Cell R42cell12 = row42.getCell(19); 
			if (R42cell12 != null) {
				R42cell12.setCellValue(brf41b.getR42_amount_uae_dubai() == null ? 0 : brf41b.getR42_amount_uae_dubai().intValue());
			}

			Cell R42cell13 = row42.getCell(20); 
			if (R42cell13 != null) {
				R42cell13.setCellValue(brf41b.getR42_no_of_accounts_non_uae_dubai() == null ? 0 : brf41b.getR42_no_of_accounts_non_uae_dubai().intValue());
			}
			Cell R42cell14 = row42.getCell(21); 
			if (R42cell14 != null) {
				R42cell14.setCellValue(brf41b.getR42_amount_non_uae_dubai() == null ? 0 : brf41b.getR42_amount_non_uae_dubai().intValue());
			}
			Cell R42cell15 = row42.getCell(23); 
			if (R42cell15 != null) {
				R42cell15.setCellValue(brf41b.getR42_no_of_accounts_uae_sharjah() == null ? 0 : brf41b.getR42_no_of_accounts_uae_sharjah().intValue());
			}
			Cell R42cell16 = row42.getCell(24); 
			if (R42cell16 != null) {
				R42cell16.setCellValue(brf41b.getR42_amount_uae_sharjah() == null ? 0 : brf41b.getR42_amount_uae_sharjah().intValue());
			}
			Cell  R42cell17 = row42.getCell(25); 
			if (R42cell17 != null) {
				R42cell17.setCellValue(brf41b.getR42_no_of_accounts_non_uae_sharjah() == null ? 0 : brf41b.getR42_no_of_accounts_non_uae_sharjah().intValue());
			}
			Cell  R42cell18 = row42.getCell(26); 
			if (R42cell18 != null) {
				R42cell18.setCellValue(brf41b.getR42_amount_non_uae_sharjah() == null ? 0 : brf41b.getR42_amount_non_uae_sharjah().intValue());
			}
			Cell  R42cell19 = row42.getCell(28); 
			if (R42cell19 != null) {
				R42cell19.setCellValue(brf41b.getR42_no_of_accounts_uae_ajman() == null ? 0 : brf41b.getR42_no_of_accounts_uae_ajman().intValue());
			}

			Cell  R42cell20 = row42.getCell(29); 
			if (R42cell20 != null) {
				R42cell20.setCellValue(brf41b.getR42_amount_uae_ajman() == null ? 0 : brf41b.getR42_amount_uae_ajman().intValue());
			}
			Cell  R42cell21 = row42.getCell(30); 
			if (R42cell21 != null) {
				R42cell21.setCellValue(brf41b.getR42_no_of_accounts_non_uae_ajman() == null ? 0 : brf41b.getR42_no_of_accounts_non_uae_ajman().intValue());
			}

			Cell R42cell22 = row42.getCell(31); 
			if (R42cell22 != null) {
				R42cell22.setCellValue(brf41b.getR42_amount_non_uae_ajman() == null ? 0 : brf41b.getR42_amount_non_uae_ajman().intValue());
			}
			Cell  R42cell23 = row42.getCell(33); 
			if (R42cell23 != null) {
				R42cell23.setCellValue(brf41b.getR42_no_of_accounts_uae_ras() == null ? 0 : brf41b.getR42_no_of_accounts_uae_ras().intValue());
			}
			Cell R42cell24 = row42.getCell(34); 
			if (R42cell24 != null) {
				R42cell24.setCellValue(brf41b.getR42_amount_uae_ras() == null ? 0 : brf41b.getR42_amount_uae_ras().intValue());
			}
			Cell  R42cell25 = row42.getCell(35); 
			if (R42cell25 != null) {
				R42cell25.setCellValue(brf41b.getR42_no_of_accounts_non_uae_ras() == null ? 0 : brf41b.getR42_no_of_accounts_non_uae_ras().intValue());
			}
			Cell  R42cell26 = row42.getCell(36); 
			if (R42cell26 != null) {
				R42cell26.setCellValue(brf41b.getR42_amount_non_uae_ras() == null ? 0 : brf41b.getR42_amount_non_uae_ras().intValue());
			}
			Cell  R42cell27 = row42.getCell(38); 
			if (R42cell27 != null) {
				R42cell27.setCellValue(brf41b.getR42_no_of_accounts_uae_umm() == null ? 0 : brf41b.getR42_no_of_accounts_uae_umm().intValue());
			}
			Cell  R42cell28 = row42.getCell(39); 
			if (R42cell28 != null) {
				R42cell28.setCellValue(brf41b.getR42_amount_uae_umm() == null ? 0 : brf41b.getR42_amount_uae_umm().intValue());
			}
			Cell  R42cell29 = row42.getCell(40); 
			if (R42cell29 != null) {
				R42cell29.setCellValue(brf41b.getR42_no_of_accounts_non_uae_umm() == null ? 0 : brf41b.getR42_no_of_accounts_non_uae_umm().intValue());
			}
			Cell  R42cell30 = row42.getCell(41); 
			if (R42cell30 != null) {
				R42cell30.setCellValue(brf41b.getR42_amount_non_uae_umm() == null ? 0 : brf41b.getR42_amount_non_uae_umm().intValue());
			}
			Cell  R42cell31 = row42.getCell(43); 
			if (R42cell31 != null) {
				R42cell31.setCellValue(brf41b.getR42_no_of_accounts_uae_fujairah() == null ? 0 : brf41b.getR42_no_of_accounts_uae_fujairah().intValue());
			}
			Cell  R42cell32 = row42.getCell(44); 
			if (R42cell32 != null) {
				R42cell32.setCellValue(brf41b.getR42_amount_uae_fujairah() == null ? 0 : brf41b.getR42_amount_uae_fujairah().intValue());
			}
			Cell  R42cell33 = row42.getCell(45); 
			if (R42cell33 != null) {
				R42cell33.setCellValue(brf41b.getR42_no_of_accounts_non_uae_fujairah() == null ? 0 : brf41b.getR42_no_of_accounts_non_uae_fujairah().intValue());
			}
									
			Cell  R42cell34 = row42.getCell(46); 
			if (R42cell34 != null) {
				R42cell34.setCellValue(brf41b.getR42_amount_non_uae_fujairah() == null ? 0 : brf41b.getR42_amount_non_uae_fujairah().intValue());
			}
		///ROW43
		  Row row43 = sheet.getRow(42);
		  Cell R43cell1 = row43.getCell(4); 
			if (R43cell1 != null) {
				R43cell1.setCellValue(brf41b.getR43_no_of_accounts_uae() == null ? 0 : brf41b.getR43_no_of_accounts_uae().intValue());
			}
			Cell R43cell2 = row43.getCell(5); 
			if (R43cell2 != null) {
				R43cell2.setCellValue(brf41b.getR43_amount_uae() == null ? 0 : brf41b.getR43_amount_uae().intValue());
			}
			Cell R43cell3 = row43.getCell(6); 
			if (R43cell3 != null) {
				R43cell3.setCellValue(brf41b.getR43_no_of_accounts_resident() == null ? 0 : brf41b.getR43_no_of_accounts_resident().intValue());
			}
			Cell R43cell4 = row43.getCell(7); 
			if (R43cell4 != null) {
				R43cell4.setCellValue(brf41b.getR43_amount_resident() == null ? 0 : brf41b.getR43_amount_resident().intValue());
			}
			Cell R43cell5 = row43.getCell(8); 
			if (R43cell5 != null) {
				R43cell5.setCellValue(brf41b.getR43_no_of_accounts_non_resident() == null ? 0 : brf41b.getR43_no_of_accounts_non_resident().intValue());
			}
			Cell R43cell6 = row43.getCell(9); 
			if (R43cell6 != null) {
				R43cell6.setCellValue(brf41b.getR43_amount_non_resident() == null ? 0 : brf41b.getR43_amount_non_resident().intValue());
			}
			Cell R43cell7 = row43.getCell(13); 
			if (R43cell7 != null) {
				R43cell7.setCellValue(brf41b.getR43_no_of_accounts_uae_abu() == null ? 0 : brf41b.getR43_no_of_accounts_uae_abu().intValue());
			}
			Cell R43cell8 = row43.getCell(14); 
			if (R43cell8 != null) {
				R43cell8.setCellValue(brf41b.getR43_amount_uae_abu() == null ? 0 : brf41b.getR43_amount_uae_abu().intValue());
			}
			Cell R43cell9 = row43.getCell(15); 
			if (R43cell9 != null) {
				R43cell9.setCellValue(brf41b.getR43_no_of_accounts_non_uae_abu() == null ? 0 : brf41b.getR43_no_of_accounts_non_uae_abu().intValue());
			}
			Cell R43cell10 = row43.getCell(16); 
			if (R43cell10 != null) {
				R43cell10.setCellValue(brf41b.getR43_amount_non_uae_abu() == null ? 0 : brf41b.getR43_amount_non_uae_abu().intValue());
			}

			Cell R43cell11 = row43.getCell(18); 
			if (R43cell11 != null) {
				R43cell11.setCellValue(brf41b.getR43_no_of_accounts_uae_dubai() == null ? 0 : brf41b.getR43_no_of_accounts_uae_dubai().intValue());
			}
			Cell R43cell12 = row43.getCell(19); 
			if (R43cell12 != null) {
				R43cell12.setCellValue(brf41b.getR43_amount_uae_dubai() == null ? 0 : brf41b.getR43_amount_uae_dubai().intValue());
			}

			Cell R43cell13 = row43.getCell(20); 
			if (R43cell13 != null) {
				R43cell13.setCellValue(brf41b.getR43_no_of_accounts_non_uae_dubai() == null ? 0 : brf41b.getR43_no_of_accounts_non_uae_dubai().intValue());
			}
			Cell R43cell14 = row43.getCell(21); 
			if (R43cell14 != null) {
				R43cell14.setCellValue(brf41b.getR43_amount_non_uae_dubai() == null ? 0 : brf41b.getR43_amount_non_uae_dubai().intValue());
			}
			Cell R43cell15 = row43.getCell(23); 
			if (R43cell15 != null) {
				R43cell15.setCellValue(brf41b.getR43_no_of_accounts_uae_sharjah() == null ? 0 : brf41b.getR43_no_of_accounts_uae_sharjah().intValue());
			}
			Cell R43cell16 = row43.getCell(24); 
			if (R43cell16 != null) {
				R43cell16.setCellValue(brf41b.getR43_amount_uae_sharjah() == null ? 0 : brf41b.getR43_amount_uae_sharjah().intValue());
			}
			Cell  R43cell17 = row43.getCell(25); 
			if (R43cell17 != null) {
				R43cell17.setCellValue(brf41b.getR43_no_of_accounts_non_uae_sharjah() == null ? 0 : brf41b.getR43_no_of_accounts_non_uae_sharjah().intValue());
			}
			Cell  R43cell18 = row43.getCell(26); 
			if (R43cell18 != null) {
				R43cell18.setCellValue(brf41b.getR43_amount_non_uae_sharjah() == null ? 0 : brf41b.getR43_amount_non_uae_sharjah().intValue());
			}
			Cell  R43cell19 = row43.getCell(28); 
			if (R43cell19 != null) {
				R43cell19.setCellValue(brf41b.getR43_no_of_accounts_uae_ajman() == null ? 0 : brf41b.getR43_no_of_accounts_uae_ajman().intValue());
			}

			Cell  R43cell20 = row43.getCell(29); 
			if (R43cell20 != null) {
				R43cell20.setCellValue(brf41b.getR43_amount_uae_ajman() == null ? 0 : brf41b.getR43_amount_uae_ajman().intValue());
			}
			Cell  R43cell21 = row43.getCell(30); 
			if (R43cell21 != null) {
				R43cell21.setCellValue(brf41b.getR43_no_of_accounts_non_uae_ajman() == null ? 0 : brf41b.getR43_no_of_accounts_non_uae_ajman().intValue());
			}

			Cell R43cell22 = row43.getCell(31); 
			if (R43cell22 != null) {
				R43cell22.setCellValue(brf41b.getR43_amount_non_uae_ajman() == null ? 0 : brf41b.getR43_amount_non_uae_ajman().intValue());
			}
			Cell  R43cell23 = row43.getCell(33); 
			if (R43cell23 != null) {
				R43cell23.setCellValue(brf41b.getR43_no_of_accounts_uae_ras() == null ? 0 : brf41b.getR43_no_of_accounts_uae_ras().intValue());
			}
			Cell R43cell24 = row43.getCell(34); 
			if (R43cell24 != null) {
				R43cell24.setCellValue(brf41b.getR43_amount_uae_ras() == null ? 0 : brf41b.getR43_amount_uae_ras().intValue());
			}
			Cell  R43cell25 = row43.getCell(35); 
			if (R43cell25 != null) {
				R43cell25.setCellValue(brf41b.getR43_no_of_accounts_non_uae_ras() == null ? 0 : brf41b.getR43_no_of_accounts_non_uae_ras().intValue());
			}
			Cell  R43cell26 = row43.getCell(36); 
			if (R43cell26 != null) {
				R43cell26.setCellValue(brf41b.getR43_amount_non_uae_ras() == null ? 0 : brf41b.getR43_amount_non_uae_ras().intValue());
			}
			Cell  R43cell27 = row43.getCell(38); 
			if (R43cell27 != null) {
				R43cell27.setCellValue(brf41b.getR43_no_of_accounts_uae_umm() == null ? 0 : brf41b.getR43_no_of_accounts_uae_umm().intValue());
			}
			Cell  R43cell28 = row43.getCell(39); 
			if (R43cell28 != null) {
				R43cell28.setCellValue(brf41b.getR43_amount_uae_umm() == null ? 0 : brf41b.getR43_amount_uae_umm().intValue());
			}
			Cell  R43cell29 = row43.getCell(40); 
			if (R43cell29 != null) {
				R43cell29.setCellValue(brf41b.getR43_no_of_accounts_non_uae_umm() == null ? 0 : brf41b.getR43_no_of_accounts_non_uae_umm().intValue());
			}
			Cell  R43cell30 = row43.getCell(41); 
			if (R43cell30 != null) {
				R43cell30.setCellValue(brf41b.getR43_amount_non_uae_umm() == null ? 0 : brf41b.getR43_amount_non_uae_umm().intValue());
			}
			Cell  R43cell31 = row43.getCell(43); 
			if (R43cell31 != null) {
				R43cell31.setCellValue(brf41b.getR43_no_of_accounts_uae_fujairah() == null ? 0 : brf41b.getR43_no_of_accounts_uae_fujairah().intValue());
			}
			Cell  R43cell32 = row43.getCell(44); 
			if (R43cell32 != null) {
				R43cell32.setCellValue(brf41b.getR43_amount_uae_fujairah() == null ? 0 : brf41b.getR43_amount_uae_fujairah().intValue());
			}
			Cell  R43cell33 = row43.getCell(45); 
			if (R43cell33 != null) {
				R43cell33.setCellValue(brf41b.getR43_no_of_accounts_non_uae_fujairah() == null ? 0 : brf41b.getR43_no_of_accounts_non_uae_fujairah().intValue());
			}
									
			Cell  R43cell34 = row43.getCell(46); 
			if (R43cell34 != null) {
				R43cell34.setCellValue(brf41b.getR43_amount_non_uae_fujairah() == null ? 0 : brf41b.getR43_amount_non_uae_fujairah().intValue());
			}
		///ROW44
		  Row row44 = sheet.getRow(43);
		  Cell R44cell1 = row44.getCell(4); 
			if (R44cell1 != null) {
				R44cell1.setCellValue(brf41b.getR44_no_of_accounts_uae() == null ? 0 : brf41b.getR44_no_of_accounts_uae().intValue());
			}
			Cell R44cell2 = row44.getCell(5); 
			if (R44cell2 != null) {
				R44cell2.setCellValue(brf41b.getR44_amount_uae() == null ? 0 : brf41b.getR44_amount_uae().intValue());
			}
			Cell R44cell3 = row44.getCell(6); 
			if (R44cell3 != null) {
				R44cell3.setCellValue(brf41b.getR44_no_of_accounts_resident() == null ? 0 : brf41b.getR44_no_of_accounts_resident().intValue());
			}
			Cell R44cell4 = row44.getCell(7); 
			if (R44cell4 != null) {
				R44cell4.setCellValue(brf41b.getR44_amount_resident() == null ? 0 : brf41b.getR44_amount_resident().intValue());
			}
			Cell R44cell5 = row44.getCell(8); 
			if (R44cell5 != null) {
				R44cell5.setCellValue(brf41b.getR44_no_of_accounts_non_resident() == null ? 0 : brf41b.getR44_no_of_accounts_non_resident().intValue());
			}
			Cell R44cell6 = row44.getCell(9); 
			if (R44cell6 != null) {
				R44cell6.setCellValue(brf41b.getR44_amount_non_resident() == null ? 0 : brf41b.getR44_amount_non_resident().intValue());
			}
			Cell R44cell7 = row44.getCell(13); 
			if (R44cell7 != null) {
				R44cell7.setCellValue(brf41b.getR44_no_of_accounts_uae_abu() == null ? 0 : brf41b.getR44_no_of_accounts_uae_abu().intValue());
			}
			Cell R44cell8 = row44.getCell(14); 
			if (R44cell8 != null) {
				R44cell8.setCellValue(brf41b.getR44_amount_uae_abu() == null ? 0 : brf41b.getR44_amount_uae_abu().intValue());
			}
			Cell R44cell9 = row44.getCell(15); 
			if (R44cell9 != null) {
				R44cell9.setCellValue(brf41b.getR44_no_of_accounts_non_uae_abu() == null ? 0 : brf41b.getR44_no_of_accounts_non_uae_abu().intValue());
			}
			Cell R44cell10 = row44.getCell(16); 
			if (R44cell10 != null) {
				R44cell10.setCellValue(brf41b.getR44_amount_non_uae_abu() == null ? 0 : brf41b.getR44_amount_non_uae_abu().intValue());
			}

			Cell R44cell11 = row44.getCell(18); 
			if (R44cell11 != null) {
				R44cell11.setCellValue(brf41b.getR44_no_of_accounts_uae_dubai() == null ? 0 : brf41b.getR44_no_of_accounts_uae_dubai().intValue());
			}
			Cell R44cell12 = row44.getCell(19); 
			if (R44cell12 != null) {
				R44cell12.setCellValue(brf41b.getR44_amount_uae_dubai() == null ? 0 : brf41b.getR44_amount_uae_dubai().intValue());
			}

			Cell R44cell13 = row44.getCell(20); 
			if (R44cell13 != null) {
				R44cell13.setCellValue(brf41b.getR44_no_of_accounts_non_uae_dubai() == null ? 0 : brf41b.getR44_no_of_accounts_non_uae_dubai().intValue());
			}
			Cell R44cell14 = row44.getCell(21); 
			if (R44cell14 != null) {
				R44cell14.setCellValue(brf41b.getR44_amount_non_uae_dubai() == null ? 0 : brf41b.getR44_amount_non_uae_dubai().intValue());
			}
			Cell R44cell15 = row44.getCell(23); 
			if (R44cell15 != null) {
				R44cell15.setCellValue(brf41b.getR44_no_of_accounts_uae_sharjah() == null ? 0 : brf41b.getR44_no_of_accounts_uae_sharjah().intValue());
			}
			Cell R44cell16 = row44.getCell(24); 
			if (R44cell16 != null) {
				R44cell16.setCellValue(brf41b.getR44_amount_uae_sharjah() == null ? 0 : brf41b.getR44_amount_uae_sharjah().intValue());
			}
			Cell  R44cell17 = row44.getCell(25); 
			if (R44cell17 != null) {
				R44cell17.setCellValue(brf41b.getR44_no_of_accounts_non_uae_sharjah() == null ? 0 : brf41b.getR44_no_of_accounts_non_uae_sharjah().intValue());
			}
			Cell  R44cell18 = row44.getCell(26); 
			if (R44cell18 != null) {
				R44cell18.setCellValue(brf41b.getR44_amount_non_uae_sharjah() == null ? 0 : brf41b.getR44_amount_non_uae_sharjah().intValue());
			}
			Cell  R44cell19 = row44.getCell(28); 
			if (R44cell19 != null) {
				R44cell19.setCellValue(brf41b.getR44_no_of_accounts_uae_ajman() == null ? 0 : brf41b.getR44_no_of_accounts_uae_ajman().intValue());
			}

			Cell  R44cell20 = row44.getCell(29); 
			if (R44cell20 != null) {
				R44cell20.setCellValue(brf41b.getR44_amount_uae_ajman() == null ? 0 : brf41b.getR44_amount_uae_ajman().intValue());
			}
			Cell  R44cell21 = row44.getCell(30); 
			if (R44cell21 != null) {
				R44cell21.setCellValue(brf41b.getR44_no_of_accounts_non_uae_ajman() == null ? 0 : brf41b.getR44_no_of_accounts_non_uae_ajman().intValue());
			}

			Cell R44cell22 = row44.getCell(31); 
			if (R44cell22 != null) {
				R44cell22.setCellValue(brf41b.getR44_amount_non_uae_ajman() == null ? 0 : brf41b.getR44_amount_non_uae_ajman().intValue());
			}
			Cell  R44cell23 = row44.getCell(33); 
			if (R44cell23 != null) {
				R44cell23.setCellValue(brf41b.getR44_no_of_accounts_uae_ras() == null ? 0 : brf41b.getR44_no_of_accounts_uae_ras().intValue());
			}
			Cell R44cell24 = row44.getCell(34); 
			if (R44cell24 != null) {
				R44cell24.setCellValue(brf41b.getR44_amount_uae_ras() == null ? 0 : brf41b.getR44_amount_uae_ras().intValue());
			}
			Cell  R44cell25 = row44.getCell(35); 
			if (R44cell25 != null) {
				R44cell25.setCellValue(brf41b.getR44_no_of_accounts_non_uae_ras() == null ? 0 : brf41b.getR44_no_of_accounts_non_uae_ras().intValue());
			}
			Cell  R44cell26 = row44.getCell(36); 
			if (R44cell26 != null) {
				R44cell26.setCellValue(brf41b.getR44_amount_non_uae_ras() == null ? 0 : brf41b.getR44_amount_non_uae_ras().intValue());
			}
			Cell  R44cell27 = row44.getCell(38); 
			if (R44cell27 != null) {
				R44cell27.setCellValue(brf41b.getR44_no_of_accounts_uae_umm() == null ? 0 : brf41b.getR44_no_of_accounts_uae_umm().intValue());
			}
			Cell  R44cell28 = row44.getCell(39); 
			if (R44cell28 != null) {
				R44cell28.setCellValue(brf41b.getR44_amount_uae_umm() == null ? 0 : brf41b.getR44_amount_uae_umm().intValue());
			}
			Cell  R44cell29 = row44.getCell(40); 
			if (R44cell29 != null) {
				R44cell29.setCellValue(brf41b.getR44_no_of_accounts_non_uae_umm() == null ? 0 : brf41b.getR44_no_of_accounts_non_uae_umm().intValue());
			}
			Cell  R44cell30 = row44.getCell(41); 
			if (R44cell30 != null) {
				R44cell30.setCellValue(brf41b.getR44_amount_non_uae_umm() == null ? 0 : brf41b.getR44_amount_non_uae_umm().intValue());
			}
			Cell  R44cell31 = row44.getCell(43); 
			if (R44cell31 != null) {
				R44cell31.setCellValue(brf41b.getR44_no_of_accounts_uae_fujairah() == null ? 0 : brf41b.getR44_no_of_accounts_uae_fujairah().intValue());
			}
			Cell  R44cell32 = row44.getCell(44); 
			if (R44cell32 != null) {
				R44cell32.setCellValue(brf41b.getR44_amount_uae_fujairah() == null ? 0 : brf41b.getR44_amount_uae_fujairah().intValue());
			}
			Cell  R44cell33 = row44.getCell(45); 
			if (R44cell33 != null) {
				R44cell33.setCellValue(brf41b.getR44_no_of_accounts_non_uae_fujairah() == null ? 0 : brf41b.getR44_no_of_accounts_non_uae_fujairah().intValue());
			}
									
			Cell  R44cell34 = row44.getCell(46); 
			if (R44cell34 != null) {
				R44cell34.setCellValue(brf41b.getR44_amount_non_uae_fujairah() == null ? 0 : brf41b.getR44_amount_non_uae_fujairah().intValue());
			}
		///ROW45
		  Row row45 = sheet.getRow(44);
		  Cell R45cell1 = row45.getCell(4); 
			if (R45cell1 != null) {
				R45cell1.setCellValue(brf41b.getR45_no_of_accounts_uae() == null ? 0 : brf41b.getR45_no_of_accounts_uae().intValue());
			}
			Cell R45cell2 = row45.getCell(5); 
			if (R45cell2 != null) {
				R45cell2.setCellValue(brf41b.getR45_amount_uae() == null ? 0 : brf41b.getR45_amount_uae().intValue());
			}
			Cell R45cell3 = row45.getCell(6); 
			if (R45cell3 != null) {
				R45cell3.setCellValue(brf41b.getR45_no_of_accounts_resident() == null ? 0 : brf41b.getR45_no_of_accounts_resident().intValue());
			}
			Cell R45cell4 = row45.getCell(7); 
			if (R45cell4 != null) {
				R45cell4.setCellValue(brf41b.getR45_amount_resident() == null ? 0 : brf41b.getR45_amount_resident().intValue());
			}
			Cell R45cell5 = row45.getCell(8); 
			if (R45cell5 != null) {
				R45cell5.setCellValue(brf41b.getR45_no_of_accounts_non_resident() == null ? 0 : brf41b.getR45_no_of_accounts_non_resident().intValue());
			}
			Cell R45cell6 = row45.getCell(9); 
			if (R45cell6 != null) {
				R45cell6.setCellValue(brf41b.getR45_amount_non_resident() == null ? 0 : brf41b.getR45_amount_non_resident().intValue());
			}
			Cell R45cell7 = row45.getCell(13); 
			if (R45cell7 != null) {
				R45cell7.setCellValue(brf41b.getR45_no_of_accounts_uae_abu() == null ? 0 : brf41b.getR45_no_of_accounts_uae_abu().intValue());
			}
			Cell R45cell8 = row45.getCell(14); 
			if (R45cell8 != null) {
				R45cell8.setCellValue(brf41b.getR45_amount_uae_abu() == null ? 0 : brf41b.getR45_amount_uae_abu().intValue());
			}
			Cell R45cell9 = row45.getCell(15); 
			if (R45cell9 != null) {
				R45cell9.setCellValue(brf41b.getR45_no_of_accounts_non_uae_abu() == null ? 0 : brf41b.getR45_no_of_accounts_non_uae_abu().intValue());
			}
			Cell R45cell10 = row45.getCell(16); 
			if (R45cell10 != null) {
				R45cell10.setCellValue(brf41b.getR45_amount_non_uae_abu() == null ? 0 : brf41b.getR45_amount_non_uae_abu().intValue());
			}

			Cell R45cell11 = row45.getCell(18); 
			if (R45cell11 != null) {
				R45cell11.setCellValue(brf41b.getR45_no_of_accounts_uae_dubai() == null ? 0 : brf41b.getR45_no_of_accounts_uae_dubai().intValue());
			}
			Cell R45cell12 = row45.getCell(19); 
			if (R45cell12 != null) {
				R45cell12.setCellValue(brf41b.getR45_amount_uae_dubai() == null ? 0 : brf41b.getR45_amount_uae_dubai().intValue());
			}

			Cell R45cell13 = row45.getCell(20); 
			if (R45cell13 != null) {
				R45cell13.setCellValue(brf41b.getR45_no_of_accounts_non_uae_dubai() == null ? 0 : brf41b.getR45_no_of_accounts_non_uae_dubai().intValue());
			}
			Cell R45cell14 = row45.getCell(21); 
			if (R45cell14 != null) {
				R45cell14.setCellValue(brf41b.getR45_amount_non_uae_dubai() == null ? 0 : brf41b.getR45_amount_non_uae_dubai().intValue());
			}
			Cell R45cell15 = row45.getCell(23); 
			if (R45cell15 != null) {
				R45cell15.setCellValue(brf41b.getR45_no_of_accounts_uae_sharjah() == null ? 0 : brf41b.getR45_no_of_accounts_uae_sharjah().intValue());
			}
			Cell R45cell16 = row45.getCell(24); 
			if (R45cell16 != null) {
				R45cell16.setCellValue(brf41b.getR45_amount_uae_sharjah() == null ? 0 : brf41b.getR45_amount_uae_sharjah().intValue());
			}
			Cell  R45cell17 = row45.getCell(25); 
			if (R45cell17 != null) {
				R45cell17.setCellValue(brf41b.getR45_no_of_accounts_non_uae_sharjah() == null ? 0 : brf41b.getR45_no_of_accounts_non_uae_sharjah().intValue());
			}
			Cell  R45cell18 = row45.getCell(26); 
			if (R45cell18 != null) {
				R45cell18.setCellValue(brf41b.getR45_amount_non_uae_sharjah() == null ? 0 : brf41b.getR45_amount_non_uae_sharjah().intValue());
			}
			Cell  R45cell19 = row45.getCell(28); 
			if (R45cell19 != null) {
				R45cell19.setCellValue(brf41b.getR45_no_of_accounts_uae_ajman() == null ? 0 : brf41b.getR45_no_of_accounts_uae_ajman().intValue());
			}

			Cell  R45cell20 = row45.getCell(29); 
			if (R45cell20 != null) {
				R45cell20.setCellValue(brf41b.getR45_amount_uae_ajman() == null ? 0 : brf41b.getR45_amount_uae_ajman().intValue());
			}
			Cell  R45cell21 = row45.getCell(30); 
			if (R45cell21 != null) {
				R45cell21.setCellValue(brf41b.getR45_no_of_accounts_non_uae_ajman() == null ? 0 : brf41b.getR45_no_of_accounts_non_uae_ajman().intValue());
			}

			Cell R45cell22 = row45.getCell(31); 
			if (R45cell22 != null) {
				R45cell22.setCellValue(brf41b.getR45_amount_non_uae_ajman() == null ? 0 : brf41b.getR45_amount_non_uae_ajman().intValue());
			}
			Cell  R45cell23 = row45.getCell(33); 
			if (R45cell23 != null) {
				R45cell23.setCellValue(brf41b.getR45_no_of_accounts_uae_ras() == null ? 0 : brf41b.getR45_no_of_accounts_uae_ras().intValue());
			}
			Cell R45cell24 = row45.getCell(34); 
			if (R45cell24 != null) {
				R45cell24.setCellValue(brf41b.getR45_amount_uae_ras() == null ? 0 : brf41b.getR45_amount_uae_ras().intValue());
			}
			Cell  R45cell25 = row45.getCell(35); 
			if (R45cell25 != null) {
				R45cell25.setCellValue(brf41b.getR45_no_of_accounts_non_uae_ras() == null ? 0 : brf41b.getR45_no_of_accounts_non_uae_ras().intValue());
			}
			Cell  R45cell26 = row45.getCell(36); 
			if (R45cell26 != null) {
				R45cell26.setCellValue(brf41b.getR45_amount_non_uae_ras() == null ? 0 : brf41b.getR45_amount_non_uae_ras().intValue());
			}
			Cell  R45cell27 = row45.getCell(38); 
			if (R45cell27 != null) {
				R45cell27.setCellValue(brf41b.getR45_no_of_accounts_uae_umm() == null ? 0 : brf41b.getR45_no_of_accounts_uae_umm().intValue());
			}
			Cell  R45cell28 = row45.getCell(39); 
			if (R45cell28 != null) {
				R45cell28.setCellValue(brf41b.getR45_amount_uae_umm() == null ? 0 : brf41b.getR45_amount_uae_umm().intValue());
			}
			Cell  R45cell29 = row45.getCell(40); 
			if (R45cell29 != null) {
				R45cell29.setCellValue(brf41b.getR45_no_of_accounts_non_uae_umm() == null ? 0 : brf41b.getR45_no_of_accounts_non_uae_umm().intValue());
			}
			Cell  R45cell30 = row45.getCell(41); 
			if (R45cell30 != null) {
				R45cell30.setCellValue(brf41b.getR45_amount_non_uae_umm() == null ? 0 : brf41b.getR45_amount_non_uae_umm().intValue());
			}
			Cell  R45cell31 = row45.getCell(43); 
			if (R45cell31 != null) {
				R45cell31.setCellValue(brf41b.getR45_no_of_accounts_uae_fujairah() == null ? 0 : brf41b.getR45_no_of_accounts_uae_fujairah().intValue());
			}
			Cell  R45cell32 = row45.getCell(44); 
			if (R45cell32 != null) {
				R45cell32.setCellValue(brf41b.getR45_amount_uae_fujairah() == null ? 0 : brf41b.getR45_amount_uae_fujairah().intValue());
			}
			Cell  R45cell33 = row45.getCell(45); 
			if (R45cell33 != null) {
				R45cell33.setCellValue(brf41b.getR45_no_of_accounts_non_uae_fujairah() == null ? 0 : brf41b.getR45_no_of_accounts_non_uae_fujairah().intValue());
			}
									
			Cell  R45cell34 = row45.getCell(46); 
			if (R45cell34 != null) {
				R45cell34.setCellValue(brf41b.getR45_amount_non_uae_fujairah() == null ? 0 : brf41b.getR45_amount_non_uae_fujairah().intValue());
			}
		///ROW46
		  Row row46 = sheet.getRow(45);
		  Cell R46cell1 = row46.getCell(4); 
			if (R46cell1 != null) {
				R46cell1.setCellValue(brf41b.getR46_no_of_accounts_uae() == null ? 0 : brf41b.getR46_no_of_accounts_uae().intValue());
			}
			Cell R46cell2 = row46.getCell(5); 
			if (R46cell2 != null) {
				R46cell2.setCellValue(brf41b.getR46_amount_uae() == null ? 0 : brf41b.getR46_amount_uae().intValue());
			}
			Cell R46cell3 = row46.getCell(6); 
			if (R46cell3 != null) {
				R46cell3.setCellValue(brf41b.getR46_no_of_accounts_resident() == null ? 0 : brf41b.getR46_no_of_accounts_resident().intValue());
			}
			Cell R46cell4 = row46.getCell(7); 
			if (R46cell4 != null) {
				R46cell4.setCellValue(brf41b.getR46_amount_resident() == null ? 0 : brf41b.getR46_amount_resident().intValue());
			}
			Cell R46cell5 = row46.getCell(8); 
			if (R46cell5 != null) {
				R46cell5.setCellValue(brf41b.getR46_no_of_accounts_non_resident() == null ? 0 : brf41b.getR46_no_of_accounts_non_resident().intValue());
			}
			Cell R46cell6 = row46.getCell(9); 
			if (R46cell6 != null) {
				R46cell6.setCellValue(brf41b.getR46_amount_non_resident() == null ? 0 : brf41b.getR46_amount_non_resident().intValue());
			}
			Cell R46cell7 = row46.getCell(13); 
			if (R46cell7 != null) {
				R46cell7.setCellValue(brf41b.getR46_no_of_accounts_uae_abu() == null ? 0 : brf41b.getR46_no_of_accounts_uae_abu().intValue());
			}
			Cell R46cell8 = row46.getCell(14); 
			if (R46cell8 != null) {
				R46cell8.setCellValue(brf41b.getR46_amount_uae_abu() == null ? 0 : brf41b.getR46_amount_uae_abu().intValue());
			}
			Cell R46cell9 = row46.getCell(15); 
			if (R46cell9 != null) {
				R46cell9.setCellValue(brf41b.getR46_no_of_accounts_non_uae_abu() == null ? 0 : brf41b.getR46_no_of_accounts_non_uae_abu().intValue());
			}
			Cell R46cell10 = row46.getCell(16); 
			if (R46cell10 != null) {
				R46cell10.setCellValue(brf41b.getR46_amount_non_uae_abu() == null ? 0 : brf41b.getR46_amount_non_uae_abu().intValue());
			}

			Cell R46cell11 = row46.getCell(18); 
			if (R46cell11 != null) {
				R46cell11.setCellValue(brf41b.getR46_no_of_accounts_uae_dubai() == null ? 0 : brf41b.getR46_no_of_accounts_uae_dubai().intValue());
			}
			Cell R46cell12 = row46.getCell(19); 
			if (R46cell12 != null) {
				R46cell12.setCellValue(brf41b.getR46_amount_uae_dubai() == null ? 0 : brf41b.getR46_amount_uae_dubai().intValue());
			}

			Cell R46cell13 = row46.getCell(20); 
			if (R46cell13 != null) {
				R46cell13.setCellValue(brf41b.getR46_no_of_accounts_non_uae_dubai() == null ? 0 : brf41b.getR46_no_of_accounts_non_uae_dubai().intValue());
			}
			Cell R46cell14 = row46.getCell(21); 
			if (R46cell14 != null) {
				R46cell14.setCellValue(brf41b.getR46_amount_non_uae_dubai() == null ? 0 : brf41b.getR46_amount_non_uae_dubai().intValue());
			}
			Cell R46cell15 = row46.getCell(23); 
			if (R46cell15 != null) {
				R46cell15.setCellValue(brf41b.getR46_no_of_accounts_uae_sharjah() == null ? 0 : brf41b.getR46_no_of_accounts_uae_sharjah().intValue());
			}
			Cell R46cell16 = row46.getCell(24); 
			if (R46cell16 != null) {
				R46cell16.setCellValue(brf41b.getR46_amount_uae_sharjah() == null ? 0 : brf41b.getR46_amount_uae_sharjah().intValue());
			}
			Cell  R46cell17 = row46.getCell(25); 
			if (R46cell17 != null) {
				R46cell17.setCellValue(brf41b.getR46_no_of_accounts_non_uae_sharjah() == null ? 0 : brf41b.getR46_no_of_accounts_non_uae_sharjah().intValue());
			}
			Cell  R46cell18 = row46.getCell(26); 
			if (R46cell18 != null) {
				R46cell18.setCellValue(brf41b.getR46_amount_non_uae_sharjah() == null ? 0 : brf41b.getR46_amount_non_uae_sharjah().intValue());
			}
			Cell  R46cell19 = row46.getCell(28); 
			if (R46cell19 != null) {
				R46cell19.setCellValue(brf41b.getR46_no_of_accounts_uae_ajman() == null ? 0 : brf41b.getR46_no_of_accounts_uae_ajman().intValue());
			}

			Cell  R46cell20 = row46.getCell(29); 
			if (R46cell20 != null) {
				R46cell20.setCellValue(brf41b.getR46_amount_uae_ajman() == null ? 0 : brf41b.getR46_amount_uae_ajman().intValue());
			}
			Cell  R46cell21 = row46.getCell(30); 
			if (R46cell21 != null) {
				R46cell21.setCellValue(brf41b.getR46_no_of_accounts_non_uae_ajman() == null ? 0 : brf41b.getR46_no_of_accounts_non_uae_ajman().intValue());
			}

			Cell R46cell22 = row46.getCell(31); 
			if (R46cell22 != null) {
				R46cell22.setCellValue(brf41b.getR46_amount_non_uae_ajman() == null ? 0 : brf41b.getR46_amount_non_uae_ajman().intValue());
			}
			Cell  R46cell23 = row46.getCell(33); 
			if (R46cell23 != null) {
				R46cell23.setCellValue(brf41b.getR46_no_of_accounts_uae_ras() == null ? 0 : brf41b.getR46_no_of_accounts_uae_ras().intValue());
			}
			Cell R46cell24 = row46.getCell(34); 
			if (R46cell24 != null) {
				R46cell24.setCellValue(brf41b.getR46_amount_uae_ras() == null ? 0 : brf41b.getR46_amount_uae_ras().intValue());
			}
			Cell  R46cell25 = row46.getCell(35); 
			if (R46cell25 != null) {
				R46cell25.setCellValue(brf41b.getR46_no_of_accounts_non_uae_ras() == null ? 0 : brf41b.getR46_no_of_accounts_non_uae_ras().intValue());
			}
			Cell  R46cell26 = row46.getCell(36); 
			if (R46cell26 != null) {
				R46cell26.setCellValue(brf41b.getR46_amount_non_uae_ras() == null ? 0 : brf41b.getR46_amount_non_uae_ras().intValue());
			}
			Cell  R46cell27 = row46.getCell(38); 
			if (R46cell27 != null) {
				R46cell27.setCellValue(brf41b.getR46_no_of_accounts_uae_umm() == null ? 0 : brf41b.getR46_no_of_accounts_uae_umm().intValue());
			}
			Cell  R46cell28 = row46.getCell(39); 
			if (R46cell28 != null) {
				R46cell28.setCellValue(brf41b.getR46_amount_uae_umm() == null ? 0 : brf41b.getR46_amount_uae_umm().intValue());
			}
			Cell  R46cell29 = row46.getCell(40); 
			if (R46cell29 != null) {
				R46cell29.setCellValue(brf41b.getR46_no_of_accounts_non_uae_umm() == null ? 0 : brf41b.getR46_no_of_accounts_non_uae_umm().intValue());
			}
			Cell  R46cell30 = row46.getCell(41); 
			if (R46cell30 != null) {
				R46cell30.setCellValue(brf41b.getR46_amount_non_uae_umm() == null ? 0 : brf41b.getR46_amount_non_uae_umm().intValue());
			}
			Cell  R46cell31 = row46.getCell(43); 
			if (R46cell31 != null) {
				R46cell31.setCellValue(brf41b.getR46_no_of_accounts_uae_fujairah() == null ? 0 : brf41b.getR46_no_of_accounts_uae_fujairah().intValue());
			}
			Cell  R46cell32 = row46.getCell(44); 
			if (R46cell32 != null) {
				R46cell32.setCellValue(brf41b.getR46_amount_uae_fujairah() == null ? 0 : brf41b.getR46_amount_uae_fujairah().intValue());
			}
			Cell  R46cell33 = row46.getCell(45); 
			if (R46cell33 != null) {
				R46cell33.setCellValue(brf41b.getR46_no_of_accounts_non_uae_fujairah() == null ? 0 : brf41b.getR46_no_of_accounts_non_uae_fujairah().intValue());
			}
									
			Cell  R46cell34 = row46.getCell(46); 
			if (R46cell34 != null) {
				R46cell34.setCellValue(brf41b.getR46_amount_non_uae_fujairah() == null ? 0 : brf41b.getR46_amount_non_uae_fujairah().intValue());
			}
		///ROW47
		  Row row47 = sheet.getRow(46);
		  Cell R47cell1 = row47.getCell(4); 
			if (R47cell1 != null) {
				R47cell1.setCellValue(brf41b.getR47_no_of_accounts_uae() == null ? 0 : brf41b.getR47_no_of_accounts_uae().intValue());
			}
			Cell R47cell2 = row47.getCell(5); 
			if (R47cell2 != null) {
				R47cell2.setCellValue(brf41b.getR47_amount_uae() == null ? 0 : brf41b.getR47_amount_uae().intValue());
			}
			Cell R47cell3 = row47.getCell(6); 
			if (R47cell3 != null) {
				R47cell3.setCellValue(brf41b.getR47_no_of_accounts_resident() == null ? 0 : brf41b.getR47_no_of_accounts_resident().intValue());
			}
			Cell R47cell4 = row47.getCell(7); 
			if (R47cell4 != null) {
				R47cell4.setCellValue(brf41b.getR47_amount_resident() == null ? 0 : brf41b.getR47_amount_resident().intValue());
			}
			Cell R47cell5 = row47.getCell(8); 
			if (R47cell5 != null) {
				R47cell5.setCellValue(brf41b.getR47_no_of_accounts_non_resident() == null ? 0 : brf41b.getR47_no_of_accounts_non_resident().intValue());
			}
			Cell R47cell6 = row47.getCell(9); 
			if (R47cell6 != null) {
				R47cell6.setCellValue(brf41b.getR47_amount_non_resident() == null ? 0 : brf41b.getR47_amount_non_resident().intValue());
			}
			Cell R47cell7 = row47.getCell(13); 
			if (R47cell7 != null) {
				R47cell7.setCellValue(brf41b.getR47_no_of_accounts_uae_abu() == null ? 0 : brf41b.getR47_no_of_accounts_uae_abu().intValue());
			}
			Cell R47cell8 = row47.getCell(14); 
			if (R47cell8 != null) {
				R47cell8.setCellValue(brf41b.getR47_amount_uae_abu() == null ? 0 : brf41b.getR47_amount_uae_abu().intValue());
			}
			Cell R47cell9 = row47.getCell(15); 
			if (R47cell9 != null) {
				R47cell9.setCellValue(brf41b.getR47_no_of_accounts_non_uae_abu() == null ? 0 : brf41b.getR47_no_of_accounts_non_uae_abu().intValue());
			}
			Cell R47cell10 = row47.getCell(16); 
			if (R47cell10 != null) {
				R47cell10.setCellValue(brf41b.getR47_amount_non_uae_abu() == null ? 0 : brf41b.getR47_amount_non_uae_abu().intValue());
			}

			Cell R47cell11 = row47.getCell(18); 
			if (R47cell11 != null) {
				R47cell11.setCellValue(brf41b.getR47_no_of_accounts_uae_dubai() == null ? 0 : brf41b.getR47_no_of_accounts_uae_dubai().intValue());
			}
			Cell R47cell12 = row47.getCell(19); 
			if (R47cell12 != null) {
				R47cell12.setCellValue(brf41b.getR47_amount_uae_dubai() == null ? 0 : brf41b.getR47_amount_uae_dubai().intValue());
			}

			Cell R47cell13 = row47.getCell(20); 
			if (R47cell13 != null) {
				R47cell13.setCellValue(brf41b.getR47_no_of_accounts_non_uae_dubai() == null ? 0 : brf41b.getR47_no_of_accounts_non_uae_dubai().intValue());
			}
			Cell R47cell14 = row47.getCell(21); 
			if (R47cell14 != null) {
				R47cell14.setCellValue(brf41b.getR47_amount_non_uae_dubai() == null ? 0 : brf41b.getR47_amount_non_uae_dubai().intValue());
			}
			Cell R47cell15 = row47.getCell(23); 
			if (R47cell15 != null) {
				R47cell15.setCellValue(brf41b.getR47_no_of_accounts_uae_sharjah() == null ? 0 : brf41b.getR47_no_of_accounts_uae_sharjah().intValue());
			}
			Cell R47cell16 = row47.getCell(24); 
			if (R47cell16 != null) {
				R47cell16.setCellValue(brf41b.getR47_amount_uae_sharjah() == null ? 0 : brf41b.getR47_amount_uae_sharjah().intValue());
			}
			Cell  R47cell17 = row47.getCell(25); 
			if (R47cell17 != null) {
				R47cell17.setCellValue(brf41b.getR47_no_of_accounts_non_uae_sharjah() == null ? 0 : brf41b.getR47_no_of_accounts_non_uae_sharjah().intValue());
			}
			Cell  R47cell18 = row47.getCell(26); 
			if (R47cell18 != null) {
				R47cell18.setCellValue(brf41b.getR47_amount_non_uae_sharjah() == null ? 0 : brf41b.getR47_amount_non_uae_sharjah().intValue());
			}
			Cell  R47cell19 = row47.getCell(28); 
			if (R47cell19 != null) {
				R47cell19.setCellValue(brf41b.getR47_no_of_accounts_uae_ajman() == null ? 0 : brf41b.getR47_no_of_accounts_uae_ajman().intValue());
			}

			Cell  R47cell20 = row47.getCell(29); 
			if (R47cell20 != null) {
				R47cell20.setCellValue(brf41b.getR47_amount_uae_ajman() == null ? 0 : brf41b.getR47_amount_uae_ajman().intValue());
			}
			Cell  R47cell21 = row47.getCell(30); 
			if (R47cell21 != null) {
				R47cell21.setCellValue(brf41b.getR47_no_of_accounts_non_uae_ajman() == null ? 0 : brf41b.getR47_no_of_accounts_non_uae_ajman().intValue());
			}

			Cell R47cell22 = row47.getCell(31); 
			if (R47cell22 != null) {
				R47cell22.setCellValue(brf41b.getR47_amount_non_uae_ajman() == null ? 0 : brf41b.getR47_amount_non_uae_ajman().intValue());
			}
			Cell  R47cell23 = row47.getCell(33); 
			if (R47cell23 != null) {
				R47cell23.setCellValue(brf41b.getR47_no_of_accounts_uae_ras() == null ? 0 : brf41b.getR47_no_of_accounts_uae_ras().intValue());
			}
			Cell R47cell24 = row47.getCell(34); 
			if (R47cell24 != null) {
				R47cell24.setCellValue(brf41b.getR47_amount_uae_ras() == null ? 0 : brf41b.getR47_amount_uae_ras().intValue());
			}
			Cell  R47cell25 = row47.getCell(35); 
			if (R47cell25 != null) {
				R47cell25.setCellValue(brf41b.getR47_no_of_accounts_non_uae_ras() == null ? 0 : brf41b.getR47_no_of_accounts_non_uae_ras().intValue());
			}
			Cell  R47cell26 = row47.getCell(36); 
			if (R47cell26 != null) {
				R47cell26.setCellValue(brf41b.getR47_amount_non_uae_ras() == null ? 0 : brf41b.getR47_amount_non_uae_ras().intValue());
			}
			Cell  R47cell27 = row47.getCell(38); 
			if (R47cell27 != null) {
				R47cell27.setCellValue(brf41b.getR47_no_of_accounts_uae_umm() == null ? 0 : brf41b.getR47_no_of_accounts_uae_umm().intValue());
			}
			Cell  R47cell28 = row47.getCell(39); 
			if (R47cell28 != null) {
				R47cell28.setCellValue(brf41b.getR47_amount_uae_umm() == null ? 0 : brf41b.getR47_amount_uae_umm().intValue());
			}
			Cell  R47cell29 = row47.getCell(40); 
			if (R47cell29 != null) {
				R47cell29.setCellValue(brf41b.getR47_no_of_accounts_non_uae_umm() == null ? 0 : brf41b.getR47_no_of_accounts_non_uae_umm().intValue());
			}
			Cell  R47cell30 = row47.getCell(41); 
			if (R47cell30 != null) {
				R47cell30.setCellValue(brf41b.getR47_amount_non_uae_umm() == null ? 0 : brf41b.getR47_amount_non_uae_umm().intValue());
			}
			Cell  R47cell31 = row47.getCell(43); 
			if (R47cell31 != null) {
				R47cell31.setCellValue(brf41b.getR47_no_of_accounts_uae_fujairah() == null ? 0 : brf41b.getR47_no_of_accounts_uae_fujairah().intValue());
			}
			Cell  R47cell32 = row47.getCell(44); 
			if (R47cell32 != null) {
				R47cell32.setCellValue(brf41b.getR47_amount_uae_fujairah() == null ? 0 : brf41b.getR47_amount_uae_fujairah().intValue());
			}
			Cell  R47cell33 = row47.getCell(45); 
			if (R47cell33 != null) {
				R47cell33.setCellValue(brf41b.getR47_no_of_accounts_non_uae_fujairah() == null ? 0 : brf41b.getR47_no_of_accounts_non_uae_fujairah().intValue());
			}
									
			Cell  R47cell34 = row47.getCell(46); 
			if (R47cell34 != null) {
				R47cell34.setCellValue(brf41b.getR47_amount_non_uae_fujairah() == null ? 0 : brf41b.getR47_amount_non_uae_fujairah().intValue());
			}
		///ROW48
		  Row row48 = sheet.getRow(47);
		  Cell R48cell1 = row48.getCell(4); 
			if (R48cell1 != null) {
				R48cell1.setCellValue(brf41b.getR48_no_of_accounts_uae() == null ? 0 : brf41b.getR48_no_of_accounts_uae().intValue());
			}
			Cell R48cell2 = row48.getCell(5); 
			if (R48cell2 != null) {
				R48cell2.setCellValue(brf41b.getR48_amount_uae() == null ? 0 : brf41b.getR48_amount_uae().intValue());
			}
			Cell R48cell3 = row48.getCell(6); 
			if (R48cell3 != null) {
				R48cell3.setCellValue(brf41b.getR48_no_of_accounts_resident() == null ? 0 : brf41b.getR48_no_of_accounts_resident().intValue());
			}
			Cell R48cell4 = row48.getCell(7); 
			if (R48cell4 != null) {
				R48cell4.setCellValue(brf41b.getR48_amount_resident() == null ? 0 : brf41b.getR48_amount_resident().intValue());
			}
			Cell R48cell5 = row48.getCell(8); 
			if (R48cell5 != null) {
				R48cell5.setCellValue(brf41b.getR48_no_of_accounts_non_resident() == null ? 0 : brf41b.getR48_no_of_accounts_non_resident().intValue());
			}
			Cell R48cell6 = row48.getCell(9); 
			if (R48cell6 != null) {
				R48cell6.setCellValue(brf41b.getR48_amount_non_resident() == null ? 0 : brf41b.getR48_amount_non_resident().intValue());
			}
			Cell R48cell7 = row48.getCell(13); 
			if (R48cell7 != null) {
				R48cell7.setCellValue(brf41b.getR48_no_of_accounts_uae_abu() == null ? 0 : brf41b.getR48_no_of_accounts_uae_abu().intValue());
			}
			Cell R48cell8 = row48.getCell(14); 
			if (R48cell8 != null) {
				R48cell8.setCellValue(brf41b.getR48_amount_uae_abu() == null ? 0 : brf41b.getR48_amount_uae_abu().intValue());
			}
			Cell R48cell9 = row48.getCell(15); 
			if (R48cell9 != null) {
				R48cell9.setCellValue(brf41b.getR48_no_of_accounts_non_uae_abu() == null ? 0 : brf41b.getR48_no_of_accounts_non_uae_abu().intValue());
			}
			Cell R48cell10 = row48.getCell(16); 
			if (R48cell10 != null) {
				R48cell10.setCellValue(brf41b.getR48_amount_non_uae_abu() == null ? 0 : brf41b.getR48_amount_non_uae_abu().intValue());
			}

			Cell R48cell11 = row48.getCell(18); 
			if (R48cell11 != null) {
				R48cell11.setCellValue(brf41b.getR48_no_of_accounts_uae_dubai() == null ? 0 : brf41b.getR48_no_of_accounts_uae_dubai().intValue());
			}
			Cell R48cell12 = row48.getCell(19); 
			if (R48cell12 != null) {
				R48cell12.setCellValue(brf41b.getR48_amount_uae_dubai() == null ? 0 : brf41b.getR48_amount_uae_dubai().intValue());
			}

			Cell R48cell13 = row48.getCell(20); 
			if (R48cell13 != null) {
				R48cell13.setCellValue(brf41b.getR48_no_of_accounts_non_uae_dubai() == null ? 0 : brf41b.getR48_no_of_accounts_non_uae_dubai().intValue());
			}
			Cell R48cell14 = row48.getCell(21); 
			if (R48cell14 != null) {
				R48cell14.setCellValue(brf41b.getR48_amount_non_uae_dubai() == null ? 0 : brf41b.getR48_amount_non_uae_dubai().intValue());
			}
			Cell R48cell15 = row48.getCell(23); 
			if (R48cell15 != null) {
				R48cell15.setCellValue(brf41b.getR48_no_of_accounts_uae_sharjah() == null ? 0 : brf41b.getR48_no_of_accounts_uae_sharjah().intValue());
			}
			Cell R48cell16 = row48.getCell(24); 
			if (R48cell16 != null) {
				R48cell16.setCellValue(brf41b.getR48_amount_uae_sharjah() == null ? 0 : brf41b.getR48_amount_uae_sharjah().intValue());
			}
			Cell  R48cell17 = row48.getCell(25); 
			if (R48cell17 != null) {
				R48cell17.setCellValue(brf41b.getR48_no_of_accounts_non_uae_sharjah() == null ? 0 : brf41b.getR48_no_of_accounts_non_uae_sharjah().intValue());
			}
			Cell  R48cell18 = row48.getCell(26); 
			if (R48cell18 != null) {
				R48cell18.setCellValue(brf41b.getR48_amount_non_uae_sharjah() == null ? 0 : brf41b.getR48_amount_non_uae_sharjah().intValue());
			}
			Cell  R48cell19 = row48.getCell(28); 
			if (R48cell19 != null) {
				R48cell19.setCellValue(brf41b.getR48_no_of_accounts_uae_ajman() == null ? 0 : brf41b.getR48_no_of_accounts_uae_ajman().intValue());
			}

			Cell  R48cell20 = row48.getCell(29); 
			if (R48cell20 != null) {
				R48cell20.setCellValue(brf41b.getR48_amount_uae_ajman() == null ? 0 : brf41b.getR48_amount_uae_ajman().intValue());
			}
			Cell  R48cell21 = row48.getCell(30); 
			if (R48cell21 != null) {
				R48cell21.setCellValue(brf41b.getR48_no_of_accounts_non_uae_ajman() == null ? 0 : brf41b.getR48_no_of_accounts_non_uae_ajman().intValue());
			}

			Cell R48cell22 = row48.getCell(31); 
			if (R48cell22 != null) {
				R48cell22.setCellValue(brf41b.getR48_amount_non_uae_ajman() == null ? 0 : brf41b.getR48_amount_non_uae_ajman().intValue());
			}
			Cell  R48cell23 = row48.getCell(33); 
			if (R48cell23 != null) {
				R48cell23.setCellValue(brf41b.getR48_no_of_accounts_uae_ras() == null ? 0 : brf41b.getR48_no_of_accounts_uae_ras().intValue());
			}
			Cell R48cell24 = row48.getCell(34); 
			if (R48cell24 != null) {
				R48cell24.setCellValue(brf41b.getR48_amount_uae_ras() == null ? 0 : brf41b.getR48_amount_uae_ras().intValue());
			}
			Cell  R48cell25 = row48.getCell(35); 
			if (R48cell25 != null) {
				R48cell25.setCellValue(brf41b.getR48_no_of_accounts_non_uae_ras() == null ? 0 : brf41b.getR48_no_of_accounts_non_uae_ras().intValue());
			}
			Cell  R48cell26 = row48.getCell(36); 
			if (R48cell26 != null) {
				R48cell26.setCellValue(brf41b.getR48_amount_non_uae_ras() == null ? 0 : brf41b.getR48_amount_non_uae_ras().intValue());
			}
			Cell  R48cell27 = row48.getCell(38); 
			if (R48cell27 != null) {
				R48cell27.setCellValue(brf41b.getR48_no_of_accounts_uae_umm() == null ? 0 : brf41b.getR48_no_of_accounts_uae_umm().intValue());
			}
			Cell  R48cell28 = row48.getCell(39); 
			if (R48cell28 != null) {
				R48cell28.setCellValue(brf41b.getR48_amount_uae_umm() == null ? 0 : brf41b.getR48_amount_uae_umm().intValue());
			}
			Cell  R48cell29 = row48.getCell(40); 
			if (R48cell29 != null) {
				R48cell29.setCellValue(brf41b.getR48_no_of_accounts_non_uae_umm() == null ? 0 : brf41b.getR48_no_of_accounts_non_uae_umm().intValue());
			}
			Cell  R48cell30 = row48.getCell(41); 
			if (R48cell30 != null) {
				R48cell30.setCellValue(brf41b.getR48_amount_non_uae_umm() == null ? 0 : brf41b.getR48_amount_non_uae_umm().intValue());
			}
			Cell  R48cell31 = row48.getCell(43); 
			if (R48cell31 != null) {
				R48cell31.setCellValue(brf41b.getR48_no_of_accounts_uae_fujairah() == null ? 0 : brf41b.getR48_no_of_accounts_uae_fujairah().intValue());
			}
			Cell  R48cell32 = row48.getCell(44); 
			if (R48cell32 != null) {
				R48cell32.setCellValue(brf41b.getR48_amount_uae_fujairah() == null ? 0 : brf41b.getR48_amount_uae_fujairah().intValue());
			}
			Cell  R48cell33 = row48.getCell(45); 
			if (R48cell33 != null) {
				R48cell33.setCellValue(brf41b.getR48_no_of_accounts_non_uae_fujairah() == null ? 0 : brf41b.getR48_no_of_accounts_non_uae_fujairah().intValue());
			}
									
			Cell  R48cell34 = row48.getCell(46); 
			if (R48cell34 != null) {
				R48cell34.setCellValue(brf41b.getR48_amount_non_uae_fujairah() == null ? 0 : brf41b.getR48_amount_non_uae_fujairah().intValue());
			}
		///ROW49
		  Row row49 = sheet.getRow(48);
		  Cell R49cell1 = row49.getCell(4); 
			if (R49cell1 != null) {
				R49cell1.setCellValue(brf41b.getR49_no_of_accounts_uae() == null ? 0 : brf41b.getR49_no_of_accounts_uae().intValue());
			}
			Cell R49cell2 = row49.getCell(5); 
			if (R49cell2 != null) {
				R49cell2.setCellValue(brf41b.getR49_amount_uae() == null ? 0 : brf41b.getR49_amount_uae().intValue());
			}
			Cell R49cell3 = row49.getCell(6); 
			if (R49cell3 != null) {
				R49cell3.setCellValue(brf41b.getR49_no_of_accounts_resident() == null ? 0 : brf41b.getR49_no_of_accounts_resident().intValue());
			}
			Cell R49cell4 = row49.getCell(7); 
			if (R49cell4 != null) {
				R49cell4.setCellValue(brf41b.getR49_amount_resident() == null ? 0 : brf41b.getR49_amount_resident().intValue());
			}
			Cell R49cell5 = row49.getCell(8); 
			if (R49cell5 != null) {
				R49cell5.setCellValue(brf41b.getR49_no_of_accounts_non_resident() == null ? 0 : brf41b.getR49_no_of_accounts_non_resident().intValue());
			}
			Cell R49cell6 = row49.getCell(9); 
			if (R49cell6 != null) {
				R49cell6.setCellValue(brf41b.getR49_amount_non_resident() == null ? 0 : brf41b.getR49_amount_non_resident().intValue());
			}
			Cell R49cell7 = row49.getCell(13); 
			if (R49cell7 != null) {
				R49cell7.setCellValue(brf41b.getR49_no_of_accounts_uae_abu() == null ? 0 : brf41b.getR49_no_of_accounts_uae_abu().intValue());
			}
			Cell R49cell8 = row49.getCell(14); 
			if (R49cell8 != null) {
				R49cell8.setCellValue(brf41b.getR49_amount_uae_abu() == null ? 0 : brf41b.getR49_amount_uae_abu().intValue());
			}
			Cell R49cell9 = row49.getCell(15); 
			if (R49cell9 != null) {
				R49cell9.setCellValue(brf41b.getR49_no_of_accounts_non_uae_abu() == null ? 0 : brf41b.getR49_no_of_accounts_non_uae_abu().intValue());
			}
			Cell R49cell10 = row49.getCell(16); 
			if (R49cell10 != null) {
				R49cell10.setCellValue(brf41b.getR49_amount_non_uae_abu() == null ? 0 : brf41b.getR49_amount_non_uae_abu().intValue());
			}
			Cell R49cell11 = row49.getCell(18); 
			if (R49cell11 != null) {
				R49cell11.setCellValue(brf41b.getR49_no_of_accounts_uae_dubai() == null ? 0 : brf41b.getR49_no_of_accounts_uae_dubai().intValue());
			}
			Cell R49cell12 = row49.getCell(19); 
			if (R49cell12 != null) {
				R49cell12.setCellValue(brf41b.getR49_amount_uae_dubai() == null ? 0 : brf41b.getR49_amount_uae_dubai().intValue());
			}
			Cell R49cell13 = row49.getCell(20); 
			if (R49cell13 != null) {
				R49cell13.setCellValue(brf41b.getR49_no_of_accounts_non_uae_dubai() == null ? 0 : brf41b.getR49_no_of_accounts_non_uae_dubai().intValue());
			}
			Cell R49cell14 = row49.getCell(21); 
			if (R49cell14 != null) {
				R49cell14.setCellValue(brf41b.getR49_amount_non_uae_dubai() == null ? 0 : brf41b.getR49_amount_non_uae_dubai().intValue());
			}
			Cell R49cell15 = row49.getCell(23); 
			if (R49cell15 != null) {
				R49cell15.setCellValue(brf41b.getR49_no_of_accounts_uae_sharjah() == null ? 0 : brf41b.getR49_no_of_accounts_uae_sharjah().intValue());
			}
			Cell R49cell16 = row49.getCell(24); 
			if (R49cell16 != null) {
				R49cell16.setCellValue(brf41b.getR49_amount_uae_sharjah() == null ? 0 : brf41b.getR49_amount_uae_sharjah().intValue());
			}
			Cell  R49cell17 = row49.getCell(25); 
			if (R49cell17 != null) {
				R49cell17.setCellValue(brf41b.getR49_no_of_accounts_non_uae_sharjah() == null ? 0 : brf41b.getR49_no_of_accounts_non_uae_sharjah().intValue());
			}
			Cell  R49cell18 = row49.getCell(26); 
			if (R49cell18 != null) {
				R49cell18.setCellValue(brf41b.getR49_amount_non_uae_sharjah() == null ? 0 : brf41b.getR49_amount_non_uae_sharjah().intValue());
			}
			Cell  R49cell19 = row49.getCell(28); 
			if (R49cell19 != null) {
				R49cell19.setCellValue(brf41b.getR49_no_of_accounts_uae_ajman() == null ? 0 : brf41b.getR49_no_of_accounts_uae_ajman().intValue());
			}
			Cell  R49cell20 = row49.getCell(29); 
			if (R49cell20 != null) {
				R49cell20.setCellValue(brf41b.getR49_amount_uae_ajman() == null ? 0 : brf41b.getR49_amount_uae_ajman().intValue());
			}
			Cell  R49cell21 = row49.getCell(30); 
			if (R49cell21 != null) {
				R49cell21.setCellValue(brf41b.getR49_no_of_accounts_non_uae_ajman() == null ? 0 : brf41b.getR49_no_of_accounts_non_uae_ajman().intValue());
			}
			Cell R49cell22 = row49.getCell(31); 
			if (R49cell22 != null) {
				R49cell22.setCellValue(brf41b.getR49_amount_non_uae_ajman() == null ? 0 : brf41b.getR49_amount_non_uae_ajman().intValue());
			}
			Cell  R49cell23 = row49.getCell(33); 
			if (R49cell23 != null) {
				R49cell23.setCellValue(brf41b.getR49_no_of_accounts_uae_ras() == null ? 0 : brf41b.getR49_no_of_accounts_uae_ras().intValue());
			}
			Cell R49cell24 = row49.getCell(34); 
			if (R49cell24 != null) {
				R49cell24.setCellValue(brf41b.getR49_amount_uae_ras() == null ? 0 : brf41b.getR49_amount_uae_ras().intValue());
			}
			Cell  R49cell25 = row49.getCell(35); 
			if (R49cell25 != null) {
				R49cell25.setCellValue(brf41b.getR49_no_of_accounts_non_uae_ras() == null ? 0 : brf41b.getR49_no_of_accounts_non_uae_ras().intValue());
			}
			Cell  R49cell26 = row49.getCell(36); 
			if (R49cell26 != null) {
				R49cell26.setCellValue(brf41b.getR49_amount_non_uae_ras() == null ? 0 : brf41b.getR49_amount_non_uae_ras().intValue());
			}
			Cell  R49cell27 = row49.getCell(38); 
			if (R49cell27 != null) {
				R49cell27.setCellValue(brf41b.getR49_no_of_accounts_uae_umm() == null ? 0 : brf41b.getR49_no_of_accounts_uae_umm().intValue());
			}
			Cell  R49cell28 = row49.getCell(39); 
			if (R49cell28 != null) {
				R49cell28.setCellValue(brf41b.getR49_amount_uae_umm() == null ? 0 : brf41b.getR49_amount_uae_umm().intValue());
			}
			Cell  R49cell29 = row49.getCell(40); 
			if (R49cell29 != null) {
				R49cell29.setCellValue(brf41b.getR49_no_of_accounts_non_uae_umm() == null ? 0 : brf41b.getR49_no_of_accounts_non_uae_umm().intValue());
			}
			Cell  R49cell30 = row49.getCell(41); 
			if (R49cell30 != null) {
				R49cell30.setCellValue(brf41b.getR49_amount_non_uae_umm() == null ? 0 : brf41b.getR49_amount_non_uae_umm().intValue());
			}
			Cell  R49cell31 = row49.getCell(43); 
			if (R49cell31 != null) {
				R49cell31.setCellValue(brf41b.getR49_no_of_accounts_uae_fujairah() == null ? 0 : brf41b.getR49_no_of_accounts_uae_fujairah().intValue());
			}
			Cell  R49cell32 = row49.getCell(44); 
			if (R49cell32 != null) {
				R49cell32.setCellValue(brf41b.getR49_amount_uae_fujairah() == null ? 0 : brf41b.getR49_amount_uae_fujairah().intValue());
			}
			Cell  R49cell33 = row49.getCell(45); 
			if (R49cell33 != null) {
				R49cell33.setCellValue(brf41b.getR49_no_of_accounts_non_uae_fujairah() == null ? 0 : brf41b.getR49_no_of_accounts_non_uae_fujairah().intValue());
			}
			Cell  R49cell34 = row49.getCell(46); 
			if (R49cell34 != null) {
				R49cell34.setCellValue(brf41b.getR49_amount_non_uae_fujairah() == null ? 0 : brf41b.getR49_amount_non_uae_fujairah().intValue());
			}
		///ROW50
		  Row row50 = sheet.getRow(49);
		  Cell R50cell1 = row50.getCell(4); 
			if (R50cell1 != null) {
				R50cell1.setCellValue(brf41b.getR50_no_of_accounts_uae() == null ? 0 : brf41b.getR50_no_of_accounts_uae().intValue());
			}
			Cell R50cell2 = row50.getCell(5); 
			if (R50cell2 != null) {
				R50cell2.setCellValue(brf41b.getR50_amount_uae() == null ? 0 : brf41b.getR50_amount_uae().intValue());
			}
			Cell R50cell3 = row50.getCell(6); 
			if (R50cell3 != null) {
				R50cell3.setCellValue(brf41b.getR50_no_of_accounts_resident() == null ? 0 : brf41b.getR50_no_of_accounts_resident().intValue());
			}
			Cell R50cell4 = row50.getCell(7); 
			if (R50cell4 != null) {
				R50cell4.setCellValue(brf41b.getR50_amount_resident() == null ? 0 : brf41b.getR50_amount_resident().intValue());
			}
			Cell R50cell5 = row50.getCell(8); 
			if (R50cell5 != null) {
				R50cell5.setCellValue(brf41b.getR50_no_of_accounts_non_resident() == null ? 0 : brf41b.getR50_no_of_accounts_non_resident().intValue());
			}
			Cell R50cell6 = row50.getCell(9); 
			if (R50cell6 != null) {
				R50cell6.setCellValue(brf41b.getR50_amount_non_resident() == null ? 0 : brf41b.getR50_amount_non_resident().intValue());
			}
			Cell R50cell7 = row50.getCell(13); 
			if (R50cell7 != null) {
				R50cell7.setCellValue(brf41b.getR50_no_of_accounts_uae_abu() == null ? 0 : brf41b.getR50_no_of_accounts_uae_abu().intValue());
			}
			Cell R50cell8 = row50.getCell(14); 
			if (R50cell8 != null) {
				R50cell8.setCellValue(brf41b.getR50_amount_uae_abu() == null ? 0 : brf41b.getR50_amount_uae_abu().intValue());
			}
			Cell R50cell9 = row50.getCell(15); 
			if (R50cell9 != null) {
				R50cell9.setCellValue(brf41b.getR50_no_of_accounts_non_uae_abu() == null ? 0 : brf41b.getR50_no_of_accounts_non_uae_abu().intValue());
			}
			Cell R50cell10 = row50.getCell(16); 
			if (R50cell10 != null) {
				R50cell10.setCellValue(brf41b.getR50_amount_non_uae_abu() == null ? 0 : brf41b.getR50_amount_non_uae_abu().intValue());
			}
			Cell R50cell11 = row50.getCell(18); 
			if (R50cell11 != null) {
				R50cell11.setCellValue(brf41b.getR50_no_of_accounts_uae_dubai() == null ? 0 : brf41b.getR50_no_of_accounts_uae_dubai().intValue());
			}
			Cell R50cell12 = row50.getCell(19); 
			if (R50cell12 != null) {
				R50cell12.setCellValue(brf41b.getR50_amount_uae_dubai() == null ? 0 : brf41b.getR50_amount_uae_dubai().intValue());
			}
			Cell R50cell13 = row50.getCell(20); 
			if (R50cell13 != null) {
				R50cell13.setCellValue(brf41b.getR50_no_of_accounts_non_uae_dubai() == null ? 0 : brf41b.getR50_no_of_accounts_non_uae_dubai().intValue());
			}
			Cell R50cell14 = row50.getCell(21); 
			if (R50cell14 != null) {
				R50cell14.setCellValue(brf41b.getR50_amount_non_uae_dubai() == null ? 0 : brf41b.getR50_amount_non_uae_dubai().intValue());
			}
			Cell R50cell15 = row50.getCell(23); 
			if (R50cell15 != null) {
				R50cell15.setCellValue(brf41b.getR50_no_of_accounts_uae_sharjah() == null ? 0 : brf41b.getR50_no_of_accounts_uae_sharjah().intValue());
			}
			Cell R50cell16 = row50.getCell(24); 
			if (R50cell16 != null) {
				R50cell16.setCellValue(brf41b.getR50_amount_uae_sharjah() == null ? 0 : brf41b.getR50_amount_uae_sharjah().intValue());
			}
			Cell  R50cell17 = row50.getCell(25); 
			if (R50cell17 != null) {
				R50cell17.setCellValue(brf41b.getR50_no_of_accounts_non_uae_sharjah() == null ? 0 : brf41b.getR50_no_of_accounts_non_uae_sharjah().intValue());
			}
			Cell  R50cell18 = row50.getCell(26); 
			if (R50cell18 != null) {
				R50cell18.setCellValue(brf41b.getR50_amount_non_uae_sharjah() == null ? 0 : brf41b.getR50_amount_non_uae_sharjah().intValue());
			}
			Cell  R50cell19 = row50.getCell(28); 
			if (R50cell19 != null) {
				R50cell19.setCellValue(brf41b.getR50_no_of_accounts_uae_ajman() == null ? 0 : brf41b.getR50_no_of_accounts_uae_ajman().intValue());
			}
			Cell  R50cell20 = row50.getCell(29); 
			if (R50cell20 != null) {
				R50cell20.setCellValue(brf41b.getR50_amount_uae_ajman() == null ? 0 : brf41b.getR50_amount_uae_ajman().intValue());
			}
			Cell  R50cell21 = row50.getCell(30); 
			if (R50cell21 != null) {
				R50cell21.setCellValue(brf41b.getR50_no_of_accounts_non_uae_ajman() == null ? 0 : brf41b.getR50_no_of_accounts_non_uae_ajman().intValue());
			}
			Cell R50cell22 = row50.getCell(31); 
			if (R50cell22 != null) {
				R50cell22.setCellValue(brf41b.getR50_amount_non_uae_ajman() == null ? 0 : brf41b.getR50_amount_non_uae_ajman().intValue());
			}
			Cell  R50cell23 = row50.getCell(33); 
			if (R50cell23 != null) {
				R50cell23.setCellValue(brf41b.getR50_no_of_accounts_uae_ras() == null ? 0 : brf41b.getR50_no_of_accounts_uae_ras().intValue());
			}
			Cell R50cell24 = row50.getCell(34); 
			if (R50cell24 != null) {
				R50cell24.setCellValue(brf41b.getR50_amount_uae_ras() == null ? 0 : brf41b.getR50_amount_uae_ras().intValue());
			}
			Cell  R50cell25 = row50.getCell(35); 
			if (R50cell25 != null) {
				R50cell25.setCellValue(brf41b.getR50_no_of_accounts_non_uae_ras() == null ? 0 : brf41b.getR50_no_of_accounts_non_uae_ras().intValue());
			}
			Cell  R50cell26 = row50.getCell(36); 
			if (R50cell26 != null) {
				R50cell26.setCellValue(brf41b.getR50_amount_non_uae_ras() == null ? 0 : brf41b.getR50_amount_non_uae_ras().intValue());
			}
			Cell  R50cell27 = row50.getCell(38); 
			if (R50cell27 != null) {
				R50cell27.setCellValue(brf41b.getR50_no_of_accounts_uae_umm() == null ? 0 : brf41b.getR50_no_of_accounts_uae_umm().intValue());
			}
			Cell  R50cell28 = row50.getCell(39); 
			if (R50cell28 != null) {
				R50cell28.setCellValue(brf41b.getR50_amount_uae_umm() == null ? 0 : brf41b.getR50_amount_uae_umm().intValue());
			}
			Cell  R50cell29 = row50.getCell(40); 
			if (R50cell29 != null) {
				R50cell29.setCellValue(brf41b.getR50_no_of_accounts_non_uae_umm() == null ? 0 : brf41b.getR50_no_of_accounts_non_uae_umm().intValue());
			}
			Cell  R50cell30 = row50.getCell(41); 
			if (R50cell30 != null) {
				R50cell30.setCellValue(brf41b.getR50_amount_non_uae_umm() == null ? 0 : brf41b.getR50_amount_non_uae_umm().intValue());
			}
			Cell  R50cell31 = row50.getCell(43); 
			if (R50cell31 != null) {
				R50cell31.setCellValue(brf41b.getR50_no_of_accounts_uae_fujairah() == null ? 0 : brf41b.getR50_no_of_accounts_uae_fujairah().intValue());
			}
			Cell  R50cell32 = row50.getCell(44); 
			if (R50cell32 != null) {
				R50cell32.setCellValue(brf41b.getR50_amount_uae_fujairah() == null ? 0 : brf41b.getR50_amount_uae_fujairah().intValue());
			}
			Cell  R50cell33 = row50.getCell(45); 
			if (R50cell33 != null) {
				R50cell33.setCellValue(brf41b.getR50_no_of_accounts_non_uae_fujairah() == null ? 0 : brf41b.getR50_no_of_accounts_non_uae_fujairah().intValue());
			}													
			Cell  R50cell34 = row50.getCell(46); 
			if (R50cell34 != null) {
				R50cell34.setCellValue(brf41b.getR50_amount_non_uae_fujairah() == null ? 0 : brf41b.getR50_amount_non_uae_fujairah().intValue());
			}
		///ROW52
		  Row row52 = sheet.getRow(51);
		  Cell R52cell1 = row52.getCell(4); 
			if (R52cell1 != null) {
				R52cell1.setCellValue(brf41b.getR52_no_of_accounts_uae() == null ? 0 : brf41b.getR52_no_of_accounts_uae().intValue());
			}
			Cell R52cell2 = row52.getCell(5); 
			if (R52cell2 != null) {
				R52cell2.setCellValue(brf41b.getR52_amount_uae() == null ? 0 : brf41b.getR52_amount_uae().intValue());
			}
			Cell R52cell3 = row52.getCell(6); 
			if (R52cell3 != null) {
				R52cell3.setCellValue(brf41b.getR52_no_of_accounts_resident() == null ? 0 : brf41b.getR52_no_of_accounts_resident().intValue());
			}
			Cell R52cell4 = row52.getCell(7); 
			if (R52cell4 != null) {
				R52cell4.setCellValue(brf41b.getR52_amount_resident() == null ? 0 : brf41b.getR52_amount_resident().intValue());
			}
			Cell R52cell5 = row52.getCell(8); 
			if (R52cell5 != null) {
				R52cell5.setCellValue(brf41b.getR52_no_of_accounts_non_resident() == null ? 0 : brf41b.getR52_no_of_accounts_non_resident().intValue());
			}
			Cell R52cell6 = row52.getCell(9); 
			if (R52cell6 != null) {
				R52cell6.setCellValue(brf41b.getR52_amount_non_resident() == null ? 0 : brf41b.getR52_amount_non_resident().intValue());
			}
			Cell R52cell7 = row52.getCell(13); 
			if (R52cell7 != null) {
				R52cell7.setCellValue(brf41b.getR52_no_of_accounts_uae_abu() == null ? 0 : brf41b.getR52_no_of_accounts_uae_abu().intValue());
			}
			Cell R52cell8 = row52.getCell(14); 
			if (R52cell8 != null) {
				R52cell8.setCellValue(brf41b.getR52_amount_uae_abu() == null ? 0 : brf41b.getR52_amount_uae_abu().intValue());
			}
			Cell R52cell9 = row52.getCell(15); 
			if (R52cell9 != null) {
				R52cell9.setCellValue(brf41b.getR52_no_of_accounts_non_uae_abu() == null ? 0 : brf41b.getR52_no_of_accounts_non_uae_abu().intValue());
			}
			Cell R52cell10 = row52.getCell(16); 
			if (R52cell10 != null) {
				R52cell10.setCellValue(brf41b.getR52_amount_non_uae_abu() == null ? 0 : brf41b.getR52_amount_non_uae_abu().intValue());
			}
			Cell R52cell11 = row52.getCell(18); 
			if (R52cell11 != null) {
				R52cell11.setCellValue(brf41b.getR52_no_of_accounts_uae_dubai() == null ? 0 : brf41b.getR52_no_of_accounts_uae_dubai().intValue());
			}
			Cell R52cell12 = row52.getCell(19); 
			if (R52cell12 != null) {
				R52cell12.setCellValue(brf41b.getR52_amount_uae_dubai() == null ? 0 : brf41b.getR52_amount_uae_dubai().intValue());
			}

			Cell R52cell13 = row52.getCell(20); 
			if (R52cell13 != null) {
				R52cell13.setCellValue(brf41b.getR52_no_of_accounts_non_uae_dubai() == null ? 0 : brf41b.getR52_no_of_accounts_non_uae_dubai().intValue());
			}
			Cell R52cell14 = row52.getCell(21); 
			if (R52cell14 != null) {
				R52cell14.setCellValue(brf41b.getR52_amount_non_uae_dubai() == null ? 0 : brf41b.getR52_amount_non_uae_dubai().intValue());
			}
			Cell R52cell15 = row52.getCell(23); 
			if (R52cell15 != null) {
				R52cell15.setCellValue(brf41b.getR52_no_of_accounts_uae_sharjah() == null ? 0 : brf41b.getR52_no_of_accounts_uae_sharjah().intValue());
			}
			Cell R52cell16 = row52.getCell(24); 
			if (R52cell16 != null) {
				R52cell16.setCellValue(brf41b.getR52_amount_uae_sharjah() == null ? 0 : brf41b.getR52_amount_uae_sharjah().intValue());
			}
			Cell  R52cell17 = row52.getCell(25); 
			if (R52cell17 != null) {
				R52cell17.setCellValue(brf41b.getR52_no_of_accounts_non_uae_sharjah() == null ? 0 : brf41b.getR52_no_of_accounts_non_uae_sharjah().intValue());
			}
			Cell  R52cell18 = row52.getCell(26); 
			if (R52cell18 != null) {
				R52cell18.setCellValue(brf41b.getR52_amount_non_uae_sharjah() == null ? 0 : brf41b.getR52_amount_non_uae_sharjah().intValue());
			}
			Cell  R52cell19 = row52.getCell(28); 
			if (R52cell19 != null) {
				R52cell19.setCellValue(brf41b.getR52_no_of_accounts_uae_ajman() == null ? 0 : brf41b.getR52_no_of_accounts_uae_ajman().intValue());
			}
			Cell  R52cell20 = row52.getCell(29); 
			if (R52cell20 != null) {
				R52cell20.setCellValue(brf41b.getR52_amount_uae_ajman() == null ? 0 : brf41b.getR52_amount_uae_ajman().intValue());
			}
			Cell  R52cell21 = row52.getCell(30); 
			if (R52cell21 != null) {
				R52cell21.setCellValue(brf41b.getR52_no_of_accounts_non_uae_ajman() == null ? 0 : brf41b.getR52_no_of_accounts_non_uae_ajman().intValue());
			}
			Cell R52cell22 = row52.getCell(31); 
			if (R52cell22 != null) {
				R52cell22.setCellValue(brf41b.getR52_amount_non_uae_ajman() == null ? 0 : brf41b.getR52_amount_non_uae_ajman().intValue());
			}
			Cell  R52cell23 = row52.getCell(33); 
			if (R52cell23 != null) {
				R52cell23.setCellValue(brf41b.getR52_no_of_accounts_uae_ras() == null ? 0 : brf41b.getR52_no_of_accounts_uae_ras().intValue());
			}
			Cell R52cell24 = row52.getCell(34); 
			if (R52cell24 != null) {
				R52cell24.setCellValue(brf41b.getR52_amount_uae_ras() == null ? 0 : brf41b.getR52_amount_uae_ras().intValue());
			}
			Cell  R52cell25 = row52.getCell(35); 
			if (R52cell25 != null) {
				R52cell25.setCellValue(brf41b.getR52_no_of_accounts_non_uae_ras() == null ? 0 : brf41b.getR52_no_of_accounts_non_uae_ras().intValue());
			}
			Cell  R52cell26 = row52.getCell(36); 
			if (R52cell26 != null) {
				R52cell26.setCellValue(brf41b.getR52_amount_non_uae_ras() == null ? 0 : brf41b.getR52_amount_non_uae_ras().intValue());
			}
			Cell  R52cell27 = row52.getCell(38); 
			if (R52cell27 != null) {
				R52cell27.setCellValue(brf41b.getR52_no_of_accounts_uae_umm() == null ? 0 : brf41b.getR52_no_of_accounts_uae_umm().intValue());
			}
			Cell  R52cell28 = row52.getCell(39); 
			if (R52cell28 != null) {
				R52cell28.setCellValue(brf41b.getR52_amount_uae_umm() == null ? 0 : brf41b.getR52_amount_uae_umm().intValue());
			}
			Cell  R52cell29 = row52.getCell(40); 
			if (R52cell29 != null) {
				R52cell29.setCellValue(brf41b.getR52_no_of_accounts_non_uae_umm() == null ? 0 : brf41b.getR52_no_of_accounts_non_uae_umm().intValue());
			}
			Cell  R52cell30 = row52.getCell(41); 
			if (R52cell30 != null) {
				R52cell30.setCellValue(brf41b.getR52_amount_non_uae_umm() == null ? 0 : brf41b.getR52_amount_non_uae_umm().intValue());
			}
			Cell  R52cell31 = row52.getCell(43); 
			if (R52cell31 != null) {
				R52cell31.setCellValue(brf41b.getR52_no_of_accounts_uae_fujairah() == null ? 0 : brf41b.getR52_no_of_accounts_uae_fujairah().intValue());
			}
			Cell  R52cell32 = row52.getCell(44); 
			if (R52cell32 != null) {
				R52cell32.setCellValue(brf41b.getR52_amount_uae_fujairah() == null ? 0 : brf41b.getR52_amount_uae_fujairah().intValue());
			}
			Cell  R52cell33 = row52.getCell(45); 
			if (R52cell33 != null) {
				R52cell33.setCellValue(brf41b.getR52_no_of_accounts_non_uae_fujairah() == null ? 0 : brf41b.getR52_no_of_accounts_non_uae_fujairah().intValue());
			}
									
			Cell  R52cell34 = row52.getCell(46); 
			if (R52cell34 != null) {
				R52cell34.setCellValue(brf41b.getR52_amount_non_uae_fujairah() == null ? 0 : brf41b.getR52_amount_non_uae_fujairah().intValue());
			}
		///ROW53
		  Row row53 = sheet.getRow(52);
		  Cell R53cell1 = row53.getCell(4); 
			if (R53cell1 != null) {
				R53cell1.setCellValue(brf41b.getR53_no_of_accounts_uae() == null ? 0 : brf41b.getR53_no_of_accounts_uae().intValue());
			}
			Cell R53cell2 = row53.getCell(5); 
			if (R53cell2 != null) {
				R53cell2.setCellValue(brf41b.getR53_amount_uae() == null ? 0 : brf41b.getR53_amount_uae().intValue());
			}
			Cell R53cell3 = row53.getCell(6); 
			if (R53cell3 != null) {
				R53cell3.setCellValue(brf41b.getR53_no_of_accounts_resident() == null ? 0 : brf41b.getR53_no_of_accounts_resident().intValue());
			}
			Cell R53cell4 = row53.getCell(7); 
			if (R53cell4 != null) {
				R53cell4.setCellValue(brf41b.getR53_amount_resident() == null ? 0 : brf41b.getR53_amount_resident().intValue());
			}
			Cell R53cell5 = row53.getCell(8); 
			if (R53cell5 != null) {
				R53cell5.setCellValue(brf41b.getR53_no_of_accounts_non_resident() == null ? 0 : brf41b.getR53_no_of_accounts_non_resident().intValue());
			}
			Cell R53cell6 = row53.getCell(9); 
			if (R53cell6 != null) {
				R53cell6.setCellValue(brf41b.getR53_amount_non_resident() == null ? 0 : brf41b.getR53_amount_non_resident().intValue());
			}
			Cell R53cell7 = row53.getCell(13); 
			if (R53cell7 != null) {
				R53cell7.setCellValue(brf41b.getR53_no_of_accounts_uae_abu() == null ? 0 : brf41b.getR53_no_of_accounts_uae_abu().intValue());
			}
			Cell R53cell8 = row53.getCell(14); 
			if (R53cell8 != null) {
				R53cell8.setCellValue(brf41b.getR53_amount_uae_abu() == null ? 0 : brf41b.getR53_amount_uae_abu().intValue());
			}
			Cell R53cell9 = row53.getCell(15); 
			if (R53cell9 != null) {
				R53cell9.setCellValue(brf41b.getR53_no_of_accounts_non_uae_abu() == null ? 0 : brf41b.getR53_no_of_accounts_non_uae_abu().intValue());
			}
			Cell R53cell10 = row53.getCell(16); 
			if (R53cell10 != null) {
				R53cell10.setCellValue(brf41b.getR53_amount_non_uae_abu() == null ? 0 : brf41b.getR53_amount_non_uae_abu().intValue());
			}

			Cell R53cell11 = row53.getCell(18); 
			if (R53cell11 != null) {
				R53cell11.setCellValue(brf41b.getR53_no_of_accounts_uae_dubai() == null ? 0 : brf41b.getR53_no_of_accounts_uae_dubai().intValue());
			}
			Cell R53cell12 = row53.getCell(19); 
			if (R53cell12 != null) {
				R53cell12.setCellValue(brf41b.getR53_amount_uae_dubai() == null ? 0 : brf41b.getR53_amount_uae_dubai().intValue());
			}
			Cell R53cell13 = row53.getCell(20); 
			if (R53cell13 != null) {
				R53cell13.setCellValue(brf41b.getR53_no_of_accounts_non_uae_dubai() == null ? 0 : brf41b.getR53_no_of_accounts_non_uae_dubai().intValue());
			}
			Cell R53cell14 = row53.getCell(21); 
			if (R53cell14 != null) {
				R53cell14.setCellValue(brf41b.getR53_amount_non_uae_dubai() == null ? 0 : brf41b.getR53_amount_non_uae_dubai().intValue());
			}
			Cell R53cell15 = row53.getCell(23); 
			if (R53cell15 != null) {
				R53cell15.setCellValue(brf41b.getR53_no_of_accounts_uae_sharjah() == null ? 0 : brf41b.getR53_no_of_accounts_uae_sharjah().intValue());
			}
			Cell R53cell16 = row53.getCell(24); 
			if (R53cell16 != null) {
				R53cell16.setCellValue(brf41b.getR53_amount_uae_sharjah() == null ? 0 : brf41b.getR53_amount_uae_sharjah().intValue());
			}
			Cell  R53cell17 = row53.getCell(25); 
			if (R53cell17 != null) {
				R53cell17.setCellValue(brf41b.getR53_no_of_accounts_non_uae_sharjah() == null ? 0 : brf41b.getR53_no_of_accounts_non_uae_sharjah().intValue());
			}
			Cell  R53cell18 = row53.getCell(26); 
			if (R53cell18 != null) {
				R53cell18.setCellValue(brf41b.getR53_amount_non_uae_sharjah() == null ? 0 : brf41b.getR53_amount_non_uae_sharjah().intValue());
			}
			Cell  R53cell19 = row53.getCell(28); 
			if (R53cell19 != null) {
				R53cell19.setCellValue(brf41b.getR53_no_of_accounts_uae_ajman() == null ? 0 : brf41b.getR53_no_of_accounts_uae_ajman().intValue());
			}
			Cell  R53cell20 = row53.getCell(29); 
			if (R53cell20 != null) {
				R53cell20.setCellValue(brf41b.getR53_amount_uae_ajman() == null ? 0 : brf41b.getR53_amount_uae_ajman().intValue());
			}
			Cell  R53cell21 = row53.getCell(30); 
			if (R53cell21 != null) {
				R53cell21.setCellValue(brf41b.getR53_no_of_accounts_non_uae_ajman() == null ? 0 : brf41b.getR53_no_of_accounts_non_uae_ajman().intValue());
			}
			Cell R53cell22 = row53.getCell(31); 
			if (R53cell22 != null) {
				R53cell22.setCellValue(brf41b.getR53_amount_non_uae_ajman() == null ? 0 : brf41b.getR53_amount_non_uae_ajman().intValue());
			}
			Cell  R53cell23 = row53.getCell(33); 
			if (R53cell23 != null) {
				R53cell23.setCellValue(brf41b.getR53_no_of_accounts_uae_ras() == null ? 0 : brf41b.getR53_no_of_accounts_uae_ras().intValue());
			}
			Cell R53cell24 = row53.getCell(34); 
			if (R53cell24 != null) {
				R53cell24.setCellValue(brf41b.getR53_amount_uae_ras() == null ? 0 : brf41b.getR53_amount_uae_ras().intValue());
			}
			Cell  R53cell25 = row53.getCell(35); 
			if (R53cell25 != null) {
				R53cell25.setCellValue(brf41b.getR53_no_of_accounts_non_uae_ras() == null ? 0 : brf41b.getR53_no_of_accounts_non_uae_ras().intValue());
			}
			Cell  R53cell26 = row53.getCell(36); 
			if (R53cell26 != null) {
				R53cell26.setCellValue(brf41b.getR53_amount_non_uae_ras() == null ? 0 : brf41b.getR53_amount_non_uae_ras().intValue());
			}
			Cell  R53cell27 = row53.getCell(38); 
			if (R53cell27 != null) {
				R53cell27.setCellValue(brf41b.getR53_no_of_accounts_uae_umm() == null ? 0 : brf41b.getR53_no_of_accounts_uae_umm().intValue());
			}
			Cell  R53cell28 = row53.getCell(39); 
			if (R53cell28 != null) {
				R53cell28.setCellValue(brf41b.getR53_amount_uae_umm() == null ? 0 : brf41b.getR53_amount_uae_umm().intValue());
			}
			Cell  R53cell29 = row53.getCell(40); 
			if (R53cell29 != null) {
				R53cell29.setCellValue(brf41b.getR53_no_of_accounts_non_uae_umm() == null ? 0 : brf41b.getR53_no_of_accounts_non_uae_umm().intValue());
			}
			Cell  R53cell30 = row53.getCell(41); 
			if (R53cell30 != null) {
				R53cell30.setCellValue(brf41b.getR53_amount_non_uae_umm() == null ? 0 : brf41b.getR53_amount_non_uae_umm().intValue());
			}
			Cell  R53cell31 = row53.getCell(43); 
			if (R53cell31 != null) {
				R53cell31.setCellValue(brf41b.getR53_no_of_accounts_uae_fujairah() == null ? 0 : brf41b.getR53_no_of_accounts_uae_fujairah().intValue());
			}
			Cell  R53cell32 = row53.getCell(44); 
			if (R53cell32 != null) {
				R53cell32.setCellValue(brf41b.getR53_amount_uae_fujairah() == null ? 0 : brf41b.getR53_amount_uae_fujairah().intValue());
			}
			Cell  R53cell33 = row53.getCell(45); 
			if (R53cell33 != null) {
				R53cell33.setCellValue(brf41b.getR53_no_of_accounts_non_uae_fujairah() == null ? 0 : brf41b.getR53_no_of_accounts_non_uae_fujairah().intValue());
			}													
			Cell  R53cell34 = row53.getCell(46); 
			if (R53cell34 != null) {
				R53cell34.setCellValue(brf41b.getR53_amount_non_uae_fujairah() == null ? 0 : brf41b.getR53_amount_non_uae_fujairah().intValue());
			}
		///ROW54
		  Row row54 = sheet.getRow(53);
		  Cell R54cell1 = row54.getCell(4); 
			if (R54cell1 != null) {
				R54cell1.setCellValue(brf41b.getR54_no_of_accounts_uae() == null ? 0 : brf41b.getR54_no_of_accounts_uae().intValue());
			}
			Cell R54cell2 = row54.getCell(5); 
			if (R54cell2 != null) {
				R54cell2.setCellValue(brf41b.getR54_amount_uae() == null ? 0 : brf41b.getR54_amount_uae().intValue());
			}
			Cell R54cell3 = row54.getCell(6); 
			if (R54cell3 != null) {
				R54cell3.setCellValue(brf41b.getR54_no_of_accounts_resident() == null ? 0 : brf41b.getR54_no_of_accounts_resident().intValue());
			}
			Cell R54cell4 = row54.getCell(7); 
			if (R54cell4 != null) {
				R54cell4.setCellValue(brf41b.getR54_amount_resident() == null ? 0 : brf41b.getR54_amount_resident().intValue());
			}
			Cell R54cell5 = row54.getCell(8); 
			if (R54cell5 != null) {
				R54cell5.setCellValue(brf41b.getR54_no_of_accounts_non_resident() == null ? 0 : brf41b.getR54_no_of_accounts_non_resident().intValue());
			}
			Cell R54cell6 = row54.getCell(9); 
			if (R54cell6 != null) {
				R54cell6.setCellValue(brf41b.getR54_amount_non_resident() == null ? 0 : brf41b.getR54_amount_non_resident().intValue());
			}
			Cell R54cell7 = row54.getCell(13); 
			if (R54cell7 != null) {
				R54cell7.setCellValue(brf41b.getR54_no_of_accounts_uae_abu() == null ? 0 : brf41b.getR54_no_of_accounts_uae_abu().intValue());
			}
			Cell R54cell8 = row54.getCell(14); 
			if (R54cell8 != null) {
				R54cell8.setCellValue(brf41b.getR54_amount_uae_abu() == null ? 0 : brf41b.getR54_amount_uae_abu().intValue());
			}
			Cell R54cell9 = row54.getCell(15); 
			if (R54cell9 != null) {
				R54cell9.setCellValue(brf41b.getR54_no_of_accounts_non_uae_abu() == null ? 0 : brf41b.getR54_no_of_accounts_non_uae_abu().intValue());
			}
			Cell R54cell10 = row54.getCell(16); 
			if (R54cell10 != null) {
				R54cell10.setCellValue(brf41b.getR54_amount_non_uae_abu() == null ? 0 : brf41b.getR54_amount_non_uae_abu().intValue());
			}
			Cell R54cell11 = row54.getCell(18); 
			if (R54cell11 != null) {
				R54cell11.setCellValue(brf41b.getR54_no_of_accounts_uae_dubai() == null ? 0 : brf41b.getR54_no_of_accounts_uae_dubai().intValue());
			}
			Cell R54cell12 = row54.getCell(19); 
			if (R54cell12 != null) {
				R54cell12.setCellValue(brf41b.getR54_amount_uae_dubai() == null ? 0 : brf41b.getR54_amount_uae_dubai().intValue());
			}
			Cell R54cell13 = row54.getCell(20); 
			if (R54cell13 != null) {
				R54cell13.setCellValue(brf41b.getR54_no_of_accounts_non_uae_dubai() == null ? 0 : brf41b.getR54_no_of_accounts_non_uae_dubai().intValue());
			}
			Cell R54cell14 = row54.getCell(21); 
			if (R54cell14 != null) {
				R54cell14.setCellValue(brf41b.getR54_amount_non_uae_dubai() == null ? 0 : brf41b.getR54_amount_non_uae_dubai().intValue());
			}
			Cell R54cell15 = row54.getCell(23); 
			if (R54cell15 != null) {
				R54cell15.setCellValue(brf41b.getR54_no_of_accounts_uae_sharjah() == null ? 0 : brf41b.getR54_no_of_accounts_uae_sharjah().intValue());
			}
			Cell R54cell16 = row54.getCell(24); 
			if (R54cell16 != null) {
				R54cell16.setCellValue(brf41b.getR54_amount_uae_sharjah() == null ? 0 : brf41b.getR54_amount_uae_sharjah().intValue());
			}
			Cell  R54cell17 = row54.getCell(25); 
			if (R54cell17 != null) {
				R54cell17.setCellValue(brf41b.getR54_no_of_accounts_non_uae_sharjah() == null ? 0 : brf41b.getR54_no_of_accounts_non_uae_sharjah().intValue());
			}
			Cell  R54cell18 = row54.getCell(26); 
			if (R54cell18 != null) {
				R54cell18.setCellValue(brf41b.getR54_amount_non_uae_sharjah() == null ? 0 : brf41b.getR54_amount_non_uae_sharjah().intValue());
			}
			Cell  R54cell19 = row54.getCell(28); 
			if (R54cell19 != null) {
				R54cell19.setCellValue(brf41b.getR54_no_of_accounts_uae_ajman() == null ? 0 : brf41b.getR54_no_of_accounts_uae_ajman().intValue());
			}
			Cell  R54cell20 = row54.getCell(29); 
			if (R54cell20 != null) {
				R54cell20.setCellValue(brf41b.getR54_amount_uae_ajman() == null ? 0 : brf41b.getR54_amount_uae_ajman().intValue());
			}
			Cell  R54cell21 = row54.getCell(30); 
			if (R54cell21 != null) {
				R54cell21.setCellValue(brf41b.getR54_no_of_accounts_non_uae_ajman() == null ? 0 : brf41b.getR54_no_of_accounts_non_uae_ajman().intValue());
			}
			Cell R54cell22 = row54.getCell(31); 
			if (R54cell22 != null) {
				R54cell22.setCellValue(brf41b.getR54_amount_non_uae_ajman() == null ? 0 : brf41b.getR54_amount_non_uae_ajman().intValue());
			}
			Cell  R54cell23 = row54.getCell(33); 
			if (R54cell23 != null) {
				R54cell23.setCellValue(brf41b.getR54_no_of_accounts_uae_ras() == null ? 0 : brf41b.getR54_no_of_accounts_uae_ras().intValue());
			}
			Cell R54cell24 = row54.getCell(34); 
			if (R54cell24 != null) {
				R54cell24.setCellValue(brf41b.getR54_amount_uae_ras() == null ? 0 : brf41b.getR54_amount_uae_ras().intValue());
			}
			Cell  R54cell25 = row54.getCell(35); 
			if (R54cell25 != null) {
				R54cell25.setCellValue(brf41b.getR54_no_of_accounts_non_uae_ras() == null ? 0 : brf41b.getR54_no_of_accounts_non_uae_ras().intValue());
			}
			Cell  R54cell26 = row54.getCell(36); 
			if (R54cell26 != null) {
				R54cell26.setCellValue(brf41b.getR54_amount_non_uae_ras() == null ? 0 : brf41b.getR54_amount_non_uae_ras().intValue());
			}
			Cell  R54cell27 = row54.getCell(38); 
			if (R54cell27 != null) {
				R54cell27.setCellValue(brf41b.getR54_no_of_accounts_uae_umm() == null ? 0 : brf41b.getR54_no_of_accounts_uae_umm().intValue());
			}
			Cell  R54cell28 = row54.getCell(39); 
			if (R54cell28 != null) {
				R54cell28.setCellValue(brf41b.getR54_amount_uae_umm() == null ? 0 : brf41b.getR54_amount_uae_umm().intValue());
			}
			Cell  R54cell29 = row54.getCell(40); 
			if (R54cell29 != null) {
				R54cell29.setCellValue(brf41b.getR54_no_of_accounts_non_uae_umm() == null ? 0 : brf41b.getR54_no_of_accounts_non_uae_umm().intValue());
			}
			Cell  R54cell30 = row54.getCell(41); 
			if (R54cell30 != null) {
				R54cell30.setCellValue(brf41b.getR54_amount_non_uae_umm() == null ? 0 : brf41b.getR54_amount_non_uae_umm().intValue());
			}
			Cell  R54cell31 = row54.getCell(43); 
			if (R54cell31 != null) {
				R54cell31.setCellValue(brf41b.getR54_no_of_accounts_uae_fujairah() == null ? 0 : brf41b.getR54_no_of_accounts_uae_fujairah().intValue());
			}
			Cell  R54cell32 = row54.getCell(44); 
			if (R54cell32 != null) {
				R54cell32.setCellValue(brf41b.getR54_amount_uae_fujairah() == null ? 0 : brf41b.getR54_amount_uae_fujairah().intValue());
			}
			Cell  R54cell33 = row54.getCell(45); 
			if (R54cell33 != null) {
				R54cell33.setCellValue(brf41b.getR54_no_of_accounts_non_uae_fujairah() == null ? 0 : brf41b.getR54_no_of_accounts_non_uae_fujairah().intValue());
			}													
			Cell  R54cell34 = row54.getCell(46); 
			if (R54cell34 != null) {
				R54cell34.setCellValue(brf41b.getR54_amount_non_uae_fujairah() == null ? 0 : brf41b.getR54_amount_non_uae_fujairah().intValue());
			}
		///ROW56
		  Row row56 = sheet.getRow(55);
		  Cell R56cell35 = row56.getCell(11); 
			if (R56cell35 != null) {
				R56cell35.setCellValue(brf41b.getR56_amount_total() == null ? 0 : brf41b.getR56_amount_total().intValue());
			}
		///ROW60
		  Row row60 = sheet.getRow(59);
		  Cell R60cell1 = row60.getCell(11); 
			if (R60cell1 != null) {
				R60cell1.setCellValue(brf41b.getR59_amount_total() == null ? 0 : brf41b.getR59_amount_total().intValue());
			}
		///ROW61
		  Row row61 = sheet.getRow(60);
		  Cell R61cell1 = row61.getCell(11); 
			if (R61cell1 != null) {
				R61cell1.setCellValue(brf41b.getR60_amount_total() == null ? 0 : brf41b.getR60_amount_total().intValue());
			}  
		///ROW62
		  Row row62 = sheet.getRow(61);
		  Cell R62cell1 = row62.getCell(11); 
			if (R62cell1 != null) {
				R62cell1.setCellValue(brf41b.getR61_amount_total() == null ? 0 : brf41b.getR61_amount_total().intValue());
			}
		///ROW63
		  Row row63 = sheet.getRow(62);
		  Cell R63cell1 = row63.getCell(11); 
			if (R63cell1 != null) {
				R63cell1.setCellValue(brf41b.getR62_amount_total() == null ? 0 : brf41b.getR62_amount_total().intValue());
			}
		///ROW64
		  Row row64 = sheet.getRow(63);
		  Cell R64cell1 = row64.getCell(11); 
			if (R64cell1 != null) {
				R64cell1.setCellValue(brf41b.getR63_amount_total() == null ? 0 : brf41b.getR63_amount_total().intValue());
			}						  
		///ROW65
		  Row row65 = sheet.getRow(64);
		  Cell R65cell1 = row65.getCell(11); 
			if (R65cell1 != null) {
				R65cell1.setCellValue(brf41b.getR64_amount_total() == null ? 0 : brf41b.getR64_amount_total().intValue());
			}
		///ROW66
		  Row row66 = sheet.getRow(65);
		  Cell R66cell1 = row66.getCell(11); 
			if (R66cell1 != null) {
				R66cell1.setCellValue(brf41b.getR65_amount_total() == null ? 0 : brf41b.getR65_amount_total().intValue());
			} 
		///ROW67
		  Row row67 = sheet.getRow(66);
		  Cell R67cell1 = row67.getCell(11); 
			if (R67cell1 != null) {
				R67cell1.setCellValue(brf41b.getR66_amount_total() == null ? 0 : brf41b.getR66_amount_total().intValue());
			}						  
		///ROW68
		  Row row68 = sheet.getRow(67);
		  Cell R68cell1 = row68.getCell(11); 
			if (R68cell1 != null) {
				R68cell1.setCellValue(brf41b.getR67_amount_total() == null ? 0 : brf41b.getR67_amount_total().intValue());
			}
    }
}

public File getFileBRF41(String reportId, String fromdate, String todate, String currency, String dtltype,
        String filetype) throws FileNotFoundException, JRException, SQLException {

    DateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");

    String path = this.env.getProperty("output.exportpath");
    String fileName = "";
    File outputFile;

    logger.info("Getting Output file: " + reportId);
    fileName = "011-BRF-041-A";

    if (!filetype.equals("xbrl")) {
        if (!filetype.equals("BRF")) {
            try {
                InputStream jasperFile;
                logger.info("Getting Jasper file: " + reportId);

                if (filetype.equals("detailexcel")) {
                    jasperFile = this.getClass().getResourceAsStream("/static/jasper/BRF41_Detail.jrxml");
                } else {
                    jasperFile = this.getClass().getResourceAsStream("/static/jasper/BRF41.jrxml");
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
            List<BRF41_Entity1> T1Master1 = new ArrayList<>();
            List<BRF41_Entity2> T1Master2 = new ArrayList<>();
            List<BRF41_Entity3> T1Master3 = new ArrayList<>();
            Session hs = sessionFactory.getCurrentSession();

            try {
                Date d1 = dateFormat.parse(todate);
                T1Master1 = fetchEntity1Data(hs, d1);
                T1Master2 = fetchEntity2Data(hs, d1);
                T1Master3 = fetchEntity3Data(hs, d1);

                File responseCamt = new File(env.getProperty("output.exportpathtemp") + "011-BRF-041-AT.xls");
                Workbook workbook = WorkbookFactory.create(responseCamt);
                Sheet sheet = workbook.getSheetAt(0);

                // Update sheet with entity data
                updateSheetWithEntity1Data(sheet, T1Master1);
                updateSheetWithEntity2Data(sheet, T1Master2);
                updateSheetWithEntity3Data(sheet, T1Master3);

                workbook.getCreationHelper().createFormulaEvaluator().evaluateAll();
                FileOutputStream fileOut = new FileOutputStream(env.getProperty("output.exportpathfinal") + "011-BRF-041-A.xls");
                workbook.write(fileOut);
                fileOut.close();
                workbook.close();

                path = fileOut.toString();

            } catch (ParseException e) {
                e.printStackTrace();
            } catch (EncryptedDocumentException | InvalidFormatException | IOException e) {
                e.printStackTrace();
            }
        }
    }

    outputFile = new File(env.getProperty("output.exportpathfinal") + "011-BRF-041-A.xls");
    return outputFile;
}




public String detailChanges41(BRF41_DETAILENTITY detail, String foracid, String report_addl_criteria_1,
		BigDecimal act_balance_amt_lc, String report_label_1, String report_name_1) {

	
	String msg = "";

	try {

		Session hs = sessionFactory.getCurrentSession();
		Optional<BRF41_DETAILENTITY> Brf41detail =brf41DetailRepo.findById(foracid);

		if (Brf41detail.isPresent()) {
			BRF41_DETAILENTITY BRFdetail = Brf41detail.get();

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
				brf41DetailRepo.save(BRFdetail);

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


public ModelAndView getArchieveBRF041View(String reportId, String fromdate, String todate, String currency,
		String dtltype, Pageable pageable) {

	ModelAndView mv = new ModelAndView();
	Session hs = sessionFactory.getCurrentSession();
	int pageSize = pageable.getPageSize();
	int currentPage = pageable.getPageNumber();
	int startItem = currentPage * pageSize;
	//List<BRF81_ENTITY> T1rep = new ArrayList<BRF81_ENTITY>();
	// Query<Object[]> qr;

	

	List<BRF41_Entity1> T1Master1= new ArrayList<BRF41_Entity1>();
     List<BRF41_Entity2> T1Master2 = new ArrayList<BRF41_Entity2>(); 
     List<BRF41_Entity3> T1Master3 = new ArrayList<BRF41_Entity3>(); 


	
	
	logger.info("Inside archive" + currency);

	try {
		Date d1 = df.parse(todate);
		// T1rep = t1CurProdServiceRepo.getT1CurProdServices(d1);

	
		T1Master1 = hs.createQuery("from  BRF41_Entity1 a where a.report_date = ?1 ", BRF41_Entity1 .class)
				.setParameter(1, df.parse(todate)).getResultList();

		T1Master2 = hs.createQuery("from  BRF41_Entity2 a where a.report_date = ?1 ", BRF41_Entity2 .class)
				.setParameter(1, df.parse(todate)).getResultList();

		T1Master3 = hs.createQuery("from  BRF41_Entity3 a where a.report_date = ?1 ", BRF41_Entity3 .class)
				.setParameter(1, df.parse(todate)).getResultList();

		
		
		/*
		 * T1Master1 = hs.createQuery("from BRF73_TABLE2 a where a.report_date = ?1 ",
		 * BRF73_TABLE2.class) .setParameter(1, df.parse(todate)).getResultList();
		 */

	} catch (ParseException e) {
		e.printStackTrace();
	}

	// T1rep = t1CurProdServiceRepo.getT1CurProdServices(d1);



	
	mv.setViewName("RR/BRF41ARCH");
	// mv.addObject("currlist", refCodeConfig.currList());
	mv.addObject("reportsummary1", T1Master1);
	 mv.addObject("reportsummary2", T1Master2); 
	 mv.addObject("reportsummary3", T1Master3); 
	mv.addObject("reportmaster1", T1Master1);
	mv.addObject("displaymode", "summary");
	mv.addObject("reportsflag", "reportsflag");
	mv.addObject("menu", reportId);
	System.out.println("scv" + mv.getViewName());
	
	
	
	return mv;

}


/**** ARCH DETAILS 
 * @throws ParseException ****/



public ModelAndView ARCHgetBRF041currentDtl(String reportId, String fromdate, String todate, String currency,
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
			
			
				qr = hs.createNativeQuery("select * from BRF41_ARCHIVTABLE a where report_date=?1 and report_lable=?2");
				qr.setParameter(1,  df.parse(todate));
				qr.setParameter(2,filter);
					

		} else {
			System.out.println("2");
			qr = hs.createNativeQuery("select * from BRF41_ARCHIVTABLE");

		}
	} else {
		System.out.println("3");
		qr = hs.createNativeQuery("select * from BRF41_ARCHIVTABLE  where report_date = ?1");
	}

	List<BRF41_ARCHIVENTITY> T1Master = new ArrayList<BRF41_ARCHIVENTITY>();

	try {
		System.out.println("Values entered");
		T1Master = hs.createQuery("from BRF41_ARCHIVENTITY a where a.report_date = ?1", BRF41_ARCHIVENTITY.class)
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
		String maturity_date = (String) a[45];
		String gender = (String) a[46];
		String version = (String) a[46];
		String remarks = (String) a[47];
		String nationality = (String) a[48];
		String state = (String) a[49];
		

		BRF41_ARCHIVENTITY py = new BRF41_ARCHIVENTITY(cust_id, foracid, act_balance_amt_lc, eab_lc, acct_name, acct_crncy_code, gl_code,
				gl_sub_head_code, gl_sub_head_desc, country_of_incorp, cust_type,
				schm_code, schm_type, sol_id, acid, segment,
				sub_segment, sector, sub_sector,  sector_code, group_id,
				constitution_code, country, legal_entity_type, constitution_desc, purpose_of_advn,
				hni_networth, turnover, bacid, report_name_1,report_label_1,
				report_addl_criteria_1, report_addl_criteria_2, report_addl_criteria_3, create_user, create_time,
				 modify_user, modify_time, verify_user, verify_time,
				entity_flg, modify_flg, del_flg, nre_status, report_date,
				maturity_date, gender,version, remarks, nationality, state);
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

	mv.setViewName("RR" + "/" + "BRF41ARCH::reportcontent");
	mv.addObject("reportdetails", T1Dt1Page.getContent());
	mv.addObject("reportmaster", T1Master);
	mv.addObject("reportmaster1", qr);
	mv.addObject("singledetail", new T1CurProdDetail());
	mv.addObject("reportsflag", "reportsflag");
	mv.addObject("menu", reportId);
	return mv;
	
	
	

}


}



