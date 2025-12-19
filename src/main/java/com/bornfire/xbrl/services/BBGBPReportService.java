package com.bornfire.xbrl.services;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.ModelAndView;

import com.bornfire.xbrl.entities.BRBS.Banking_Book3_OTHERCURRENCY;
import com.bornfire.xbrl.entities.BRBS.Banking_Book_GBP3;
import com.bornfire.xbrl.entities.BRBS.Banking_Book1_GBP;
import com.bornfire.xbrl.entities.BRBS.Banking_Book2_GBP;

@Service
@Transactional
@ConfigurationProperties("output")
public class BBGBPReportService {
	private static final Logger logger = LoggerFactory.getLogger(BBGBPReportService.class);

	@Autowired
	SessionFactory sessionFactory;

	@Autowired
	DataSource srcdataSource;

	@Autowired
	Environment env;

	DateFormat df = new SimpleDateFormat("dd-MMM-yyyy");

	public ModelAndView BRFBankingbookgbpView(Date report_date) {
	    ModelAndView mv = new ModelAndView();
	    Session hs = sessionFactory.getCurrentSession();
	    List<Banking_Book1_GBP> T1Master = new ArrayList<>();
	    List<Banking_Book2_GBP> T1Master1 = new ArrayList<>();
	    List<Banking_Book_GBP3> T1Master2 = new ArrayList<>();

	    try {
	        // Query for Banking_Book1_GBP
	        T1Master = hs.createQuery("from Banking_Book1_GBP a where a.report_date = :report_date", Banking_Book1_GBP.class)
	                     .setParameter("report_date", report_date)
	                     .getResultList();

	        // Query for Banking_Book2_GBP
	        T1Master1 = hs.createQuery("from Banking_Book2_GBP a where a.report_date = :report_date", Banking_Book2_GBP.class)
	                     .setParameter("report_date", report_date)
	                     .getResultList();
	        
	        // Query for Banking_Book_GBP3
	        T1Master2 = hs.createQuery("from Banking_Book_GBP3 a where a.REPORT_Date = :reportDate", Banking_Book_GBP3.class)
	                     .setParameter("reportDate", report_date)
	                     .getResultList();
	    } catch (Exception e) {
	        e.printStackTrace(); // Consider logging the exception with more detail
	        // Optionally: add error handling logic
	    }

	    mv.setViewName("RR/BBGBP");
	    mv.addObject("reportsummary", T1Master);
	    mv.addObject("reportsummary1", T1Master1);
	    mv.addObject("book3", T1Master2);
	    mv.addObject("reportmaster", T1Master);
	    mv.addObject("displaymode", "summary");
	    mv.addObject("reportsflag", "reportsflag");
	    mv.addObject("menu", report_date);

	    return mv;
	}


}
