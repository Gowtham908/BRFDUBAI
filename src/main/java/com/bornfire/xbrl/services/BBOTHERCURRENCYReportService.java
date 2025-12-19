package com.bornfire.xbrl.services;

import java.io.File;
import java.io.FileNotFoundException;
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

import com.bornfire.xbrl.entities.BRBS.Banking_Book3_OTHERCURRENCY;
import com.bornfire.xbrl.entities.BRBS.Banking_Book1_Cons;
import com.bornfire.xbrl.entities.BRBS.Banking_Book1_OTHERCURRENCY;
import com.bornfire.xbrl.entities.BRBS.Banking_Book2_Cons;
import com.bornfire.xbrl.entities.BRBS.Banking_Book2_OTHERCURRENCY;
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

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.query.Query;

@Service
@Transactional
@ConfigurationProperties("output")
public class BBOTHERCURRENCYReportService {
	private static final Logger logger = LoggerFactory.getLogger(BBOTHERCURRENCYReportService.class);

	@Autowired
	SessionFactory sessionFactory;

	@Autowired
	DataSource srcdataSource;

	@Autowired
	Environment env;

	DateFormat df = new SimpleDateFormat("dd-MMM-yyyy");

	public ModelAndView BRFBankingbookothercurrencyView(Date report_date) {
		ModelAndView mv = new ModelAndView();
		Session hs = sessionFactory.getCurrentSession();
		List<Banking_Book1_OTHERCURRENCY> T1Master = new ArrayList<>();
		List<Banking_Book2_OTHERCURRENCY> T1Master1 = new ArrayList<>();
		List<Banking_Book3_OTHERCURRENCY> T1Master2 = new ArrayList<>();

		try {
			T1Master = hs.createQuery("from Banking_Book1_OTHERCURRENCY a where a.report_date = :report_date",
					Banking_Book1_OTHERCURRENCY.class).setParameter("report_date", report_date).getResultList();

			T1Master1 = hs.createQuery("from Banking_Book2_OTHERCURRENCY a where a.report_date = :report_date",
					Banking_Book2_OTHERCURRENCY.class).setParameter("report_date", report_date).getResultList();
			T1Master2 = hs
					.createQuery("from Banking_Book3_OTHERCURRENCY a where a.REPORT_Date = :reportDate",
							Banking_Book3_OTHERCURRENCY.class)
					.setParameter("reportDate", report_date) // Use a variable with the same name as the parameter in
																// the query
					.getResultList();

		} catch (Exception e) {
			e.printStackTrace();
		}

		for (Banking_Book3_OTHERCURRENCY record : T1Master2) {
			System.out.println(record);
		}

		mv.setViewName("RR/BBOTHERCURRENCY");
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
