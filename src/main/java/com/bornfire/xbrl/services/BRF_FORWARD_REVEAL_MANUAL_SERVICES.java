package com.bornfire.xbrl.services;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.math.BigDecimal;
import java.sql.Clob;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;
import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;
import javax.validation.constraints.NotNull;

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
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ResourceUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.bornfire.xbrl.config.CompressFiles;
import com.bornfire.xbrl.entities.ArchDates;
import com.bornfire.xbrl.entities.XBRLReportsMasterRep;
import com.bornfire.xbrl.entities.FWD_REVEAL.BRF_FORWARD_REVEALDetail;
import com.bornfire.xbrl.entities.FWD_REVEAL.BRF_FORWARD_REVEALDetail_Id;
import com.bornfire.xbrl.entities.FWD_REVEAL.BRF_FORWARD_REVEALReport;
import com.bornfire.xbrl.entities.FWD_REVEAL.BRF_FORWARD_REVEALReport_Id;
import com.bornfire.xbrl.entities.FWD_REVEAL.BRF_FORWARD_REVEAL_History;
import com.bornfire.xbrl.entities.FWD_REVEAL.BRF_FORWARD_REVEAL_MANUAL_ENTITY;
import com.bornfire.xbrl.entities.FWD_REVEAL.BRF_FORWARD_REVEAL_MANUAL_ID;
import com.bornfire.xbrl.entities.FWD_REVEAL.BRF_FORWARD_REVEAL_MOD;
import com.bornfire.xbrl.entities.FWD_REVEAL.Brf_FORWARD_REVEAL_MANUAL_REP;
import com.monitorjbl.xlsx.StreamingReader;

import au.com.bytecode.opencsv.CSVReader;
import net.sf.jasperreports.engine.JRException;
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
public class BRF_FORWARD_REVEAL_MANUAL_SERVICES {

	private static final Logger logger = LoggerFactory.getLogger(BRF_FORWARD_REVEAL_MANUAL_SERVICES.class);

	@Autowired
	SessionFactory sessionFactory;

	@Autowired
	XBRLReportsMasterRep xbrlReportsMasterRep;

	@Autowired
	DataSource srcdataSource;

	@NotNull
	private String exportpath;

	@Autowired
	HttpServletRequest request;

	@Autowired
	ReferenceCodeConfigure refCodeConfig;
	
	@Autowired
	Brf_FORWARD_REVEAL_MANUAL_REP Brf_FORWARD_REVEAL_MANUAL_rep;
	DateFormat df = new SimpleDateFormat("dd-MMM-yyyy");
	
	public String getExportpath() {
		return exportpath;
	}

	public void setExportpath(String exportpath) {
		this.exportpath = exportpath;
	}

	public ModelAndView getBRF_FORWARD_REVEALRView(String reportId, String reportDate, String fromdate, String todate,
			String currency, String dtltype,String subreportid, String secid, Pageable pageable) {

		ModelAndView mv = new ModelAndView();

		int pageSize = pageable.getPageSize();
		int currentPage = pageable.getPageNumber();
		int startItem = currentPage * pageSize;

		Session hs = sessionFactory.getCurrentSession();
		List<Object> BRF_FORWARD_REVEALRep = new ArrayList<Object>();
		
		Query<Object[]> qr;

		if (dtltype.equals("report")) {
			logger.info("Inside report");
			qr = hs.createNativeQuery("select * from table(BRF_FORWARD_REVEAL_RPT_TB bls0100_s1_rpt_fun(?1,?2,?3,?4,?5,?6))");

			qr.setParameter(1, reportId);
			qr.setParameter(2, "0");
			qr.setParameter(3, reportDate);
			qr.setParameter(4, fromdate);
			qr.setParameter(5, todate);
			qr.setParameter(6, currency);

		
		} else {

			logger.info("Inside archive");
			qr = hs.createNativeQuery("select * from BRF_FORWARD_REVEAL_RPT_TB a where report_date = ?1 order by instance_code");
			try {
				qr.setParameter(1, df.parse(reportDate));
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}

		logger.info("Getting Report Summary for : " + reportId + "," + reportDate + "," + fromdate + "," + todate + ","
				+ currency);

		List<Object[]> result = qr.getResultList();
		for (Object[] a : result) {
			String report_id = (String) a[0];
			Date report_date = (Date) a[1];
			Date from_date = (Date) a[2];
			Date to_date = (Date) a[3];
			String version_no = (String) a[4];
			String instance_name = (String) a[5];
			BigDecimal instance_code = (BigDecimal) a[6];
			BigDecimal resident = (BigDecimal) a[7];
			BigDecimal non_resident = (BigDecimal) a[8];
			BigDecimal total = (BigDecimal) a[9];

			BRF_FORWARD_REVEALReport_Id BRF_FORWARD_REVEALReport_Id = new BRF_FORWARD_REVEALReport_Id(instance_code, report_date);
			BRF_FORWARD_REVEALReport BRF_FORWARD_REVEALReport = new BRF_FORWARD_REVEALReport(BRF_FORWARD_REVEALReport_Id, report_id, from_date, to_date, version_no, instance_name, resident, non_resident, total);
			
			BRF_FORWARD_REVEALRep.add(BRF_FORWARD_REVEALReport);

		};

		List<Object> pagedlist;

		if (BRF_FORWARD_REVEALRep.size() < startItem) {
			pagedlist = Collections.emptyList();
		} else {
			int toIndex = Math.min(startItem + pageSize, BRF_FORWARD_REVEALRep.size());
			pagedlist = BRF_FORWARD_REVEALRep.subList(startItem, toIndex);
		}
		logger.info("Converting to Page");
		Page<Object> BRF_FORWARD_REVEALRepPage = new PageImpl<Object>(pagedlist, PageRequest.of(currentPage, pageSize),
				BRF_FORWARD_REVEALRep.size());

		mv.setViewName(reportId + "/" + reportId);
		mv.addObject("subreportid", "SUP1500");
		//mv.addObject("currlist", refCodeConfig.currList());
		//mv.addObject("councodelist", refCodeConfig.councodelist());
		
		mv.addObject("reportsummary", BRF_FORWARD_REVEALRepPage);

		return mv;

	}

	public ModelAndView BRF_FORWARD_REVEALRep(String reportId, String reportDate, String fromdate, String todate,
			String currency, String dtltype,String subreportid, String secid, Pageable pageable) {

		ModelAndView mv = new ModelAndView();

		int pageSize = pageable.getPageSize();
		int currentPage = pageable.getPageNumber();
		int startItem = currentPage * pageSize;

		Session hs = sessionFactory.getCurrentSession();
		List<Object> BRF_FORWARD_REVEALRep = new ArrayList<Object>();
		
		Query<Object[]> qr;

		if (dtltype.equals("report")) {
			logger.info("Inside report");
		
		qr = hs.createNativeQuery("select * from BRF_FORWARD_REVEAL_RPT_TB a where report_date = ?1 ");
		qr.setParameter(1, reportDate);
	

		} else {

			logger.info("Inside archive");
			qr = hs.createNativeQuery("select * from BRF_FORWARD_REVEAL_RPT_TB a where report_date = ?1 ");
			try {
				qr.setParameter(1, df.parse(reportDate));
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		
		logger.info("Getting Report Summary for : " + reportId + "," + reportDate + "," + fromdate + "," + todate + ","
				+ currency);

		List<Object[]> result = qr.getResultList();
		for (Object[] a : result) {
			
			String report_id = (String) a[0];
			Date report_date = (Date) a[1];
			Date from_date = (Date) a[2];
			Date to_date = (Date) a[3];
			String version_no = (String) a[4];
			String instance_name = (String) a[5];
			BigDecimal instance_code = (BigDecimal) a[6];
			BigDecimal resident = (BigDecimal) a[7];
			BigDecimal non_resident = (BigDecimal) a[8];
			BigDecimal total = (BigDecimal) a[9];


			
			
			BRF_FORWARD_REVEALReport_Id BRF_FORWARD_REVEALReport_Id = new BRF_FORWARD_REVEALReport_Id(instance_code, report_date);
			BRF_FORWARD_REVEALReport BRF_FORWARD_REVEALReport = new BRF_FORWARD_REVEALReport(BRF_FORWARD_REVEALReport_Id, 
										report_id, from_date, to_date, version_no, instance_name, 
										resident, non_resident, total);
			
			BRF_FORWARD_REVEALRep.add(BRF_FORWARD_REVEALReport);


		}
		;

		List<Object> pagedlist;

		if (BRF_FORWARD_REVEALRep.size() < startItem) {
			pagedlist = Collections.emptyList();
		} else {
			int toIndex = Math.min(startItem + pageSize, BRF_FORWARD_REVEALRep.size());
			pagedlist = BRF_FORWARD_REVEALRep.subList(startItem, toIndex);
		}

		logger.info("Converting to Page");
		Page<Object> BRF_FORWARD_REVEALRepPage = new PageImpl<Object>(pagedlist, PageRequest.of(currentPage, pageSize),
				BRF_FORWARD_REVEALRep.size());

		mv.setViewName(reportId + "/" + reportId + ":: reportcontent");
		mv.addObject("reportsummary", BRF_FORWARD_REVEALRepPage);

		return mv;

	}

	public ModelAndView getBRF_FORWARD_REVEALDtl(String reportId, String instanceCode, String reportDate, String fromdate,
			String todate, String currency, String dtltype, String subreportid, String secid, Pageable pageable) {
		
		

		int pageSize = pageable.getPageSize();
		int currentPage = pageable.getPageNumber();
		int startItem = currentPage * pageSize;

		ModelAndView mv = new ModelAndView();

		Session hs = sessionFactory.getCurrentSession();
		List<Object> BRF_FORWARD_REVEALDtl = new ArrayList<Object>();
		Query<Object[]> qr;

		if (dtltype.equals("report")) {
			qr = hs.createNativeQuery("select * from table(sup1500_dtl_fun(?1,?2,?3,?4,?5,?6,?7))");
		} else {
			qr = hs.createNativeQuery("select * from table(sup1500_dtl_h_fun(?1,?2,?3,?4,?5,?6,?7))");
		}

		qr.setParameter(1, reportId);
		qr.setParameter(2, "0");
		qr.setParameter(3, instanceCode);
		qr.setParameter(4, reportDate);
		qr.setParameter(5, fromdate);
		qr.setParameter(6, todate);
		qr.setParameter(7, currency);

		logger.info("Getting Report Detail for : "+reportId+","+reportDate+","+fromdate+","+todate+","+currency);
		List<Object[]> result = qr.getResultList();

		for (Object[] a : result) { 
			
			Date report_date = (Date)a[1];
			
			BigDecimal instance_code = (BigDecimal) a[6];
			BigDecimal resident = (BigDecimal) a[7];
			BigDecimal non_resident = (BigDecimal) a[8];
			
			

			BRF_FORWARD_REVEALDetail_Id BRF_FORWARD_REVEALDetail_Id = new BRF_FORWARD_REVEALDetail_Id(instance_code, report_date);
			BRF_FORWARD_REVEALDetail BRF_FORWARD_REVEALDetail = new BRF_FORWARD_REVEALDetail(BRF_FORWARD_REVEALDetail_Id, resident, non_resident);
			
		
		
			BRF_FORWARD_REVEALDtl.add(BRF_FORWARD_REVEALDetail);
			


		}
		;

		List<Object> pagedlist;

		if (BRF_FORWARD_REVEALDtl.size() < startItem) {
			pagedlist = Collections.emptyList();
		} else {
			int toIndex = Math.min(startItem + pageSize, BRF_FORWARD_REVEALDtl.size());
			pagedlist = BRF_FORWARD_REVEALDtl.subList(startItem, toIndex);
		}

		logger.info("Converting to Page");
		Page<Object> sup1500DtlPage = new PageImpl<Object>(pagedlist, PageRequest.of(currentPage, pageSize),
				BRF_FORWARD_REVEALDtl.size());

		mv.setViewName(reportId + "/" + reportId + ":: reportcontent");
		mv.addObject("reportdetails", sup1500DtlPage);
		mv.addObject("singledetail", new BRF_FORWARD_REVEALDetail());

		return mv;
	}

	public File getFile(String reportId, String asondate, String fromdate, String todate, String currency,
			String subreportid, String secid, String dtltype, String filetype)
			throws FileNotFoundException, JRException, SQLException {

		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

		String path = exportpath;
		String fileName = "";
		String zipFileName = "";
		File outputFile;

		logger.info("Getting Output file :" + reportId);

		try {
			fileName = reportId + "_" + xbrlReportsMasterRep.getBankCode(reportId) + "_"
					+ dateFormat.format(new SimpleDateFormat("dd-MMM-yyyy").parse(asondate));

		} catch (ParseException e1) {

			logger.info(e1.getMessage());
			e1.printStackTrace();
		}

		zipFileName = path + "/" + fileName + ".zip";

		if (!filetype.equals("xbrl")) {

			try {
				File jasperFile;
				logger.info("Getting Jasper file :" + reportId);
				if (filetype.equals("detailexcel")) {
					jasperFile = ResourceUtils.getFile("classpath:static/jasper/SUP1500/SUP1500_DTL.jasper");
				} else {
					jasperFile = ResourceUtils.getFile("classpath:static/jasper/SUP1500/SUP1500.jasper");
				}

				JasperReport jr = (JasperReport) JRLoader.loadObject(jasperFile);
				HashMap<String, Object> map = new HashMap<String, Object>();

				logger.info("Assigning Parameters for Jasper");
				map.put("REPORT_ID", reportId);
				map.put("VERSION_NO", "0");
				map.put("REPORT_DATE", asondate);
				map.put("FROM_DATE", fromdate);
				map.put("TO_DATE", todate);
				map.put("CRNCY_CODE", currency);
				map.put("TAXONOMY", xbrlReportsMasterRep.getTaxonomyVersion(reportId));
				map.put("REPORTING_FREQUENCY", xbrlReportsMasterRep.getReportFrq(reportId));

				File folders = new File(path);
				if (!folders.exists()) {
					folders.mkdirs();
				}

				if (filetype.equals("pdf")) {
					fileName = fileName + ".pdf";
					path = path + "/" + fileName;
					JasperPrint jp = JasperFillManager.fillReport(jr, map, srcdataSource.getConnection());
					JasperExportManager.exportReportToPdfFile(jp, path);
					logger.info("PDF File exported");
				} else {
					fileName = fileName + ".xlsx";
					path = path + "/" + fileName;
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

		} else {

			Session hs = sessionFactory.getCurrentSession();
			try {

				File folders = new File(path);
				if (!folders.exists()) {
					folders.mkdirs();
				}

				fileName = fileName + ".xml";
				path = path + "/" + fileName;

				Query qr = hs.createNativeQuery(
						"SELECT a.xbrl_rpt.getClobVal() as xbrl FROM SUP1500_XBRL_OUTPUT a where a.report_date=?1");

				qr.setParameter(1, asondate);
				logger.info("Getting XBRL File");
				Clob clob = (Clob) qr.getSingleResult();

				Reader reader = clob.getCharacterStream();
				FileWriter fileWriter = new FileWriter(path);
				int i;
				while ((i = reader.read()) != -1) {
					fileWriter.write((char) i);
				}
				fileWriter.close();
				reader.close();
			} catch (Exception e) {
				e.printStackTrace();

			}

		}

		if (filetype.equals("xbrl")) {
			logger.info("Compressing XBRL File");
			CompressFiles.zipSingleFile(new File(path), zipFileName);
			outputFile = new File(zipFileName);
		} else {
			outputFile = new File(path);
		}

		return outputFile;

	}

	public String detailChanges(BRF_FORWARD_REVEALDetail detail, Character changeType, String userid) {

		String msg = "";

		try {
			BRF_FORWARD_REVEAL_MOD mod = new BRF_FORWARD_REVEAL_MOD(detail);

			mod.setDel_flg(changeType);
			mod.setLchg_user_id(userid);
			mod.setLchg_time(new Date());

			Session hs = sessionFactory.getCurrentSession();
			
		
			hs.saveOrUpdate(mod);

			if (changeType.equals('A')) {
				logger.info("Added Record");
				msg = "Added Successfully";
			} else if (changeType.equals('E')) {
				logger.info("Edited Record");
				msg = "Edited Successfully";
			} else if (changeType.equals('D')) {
				logger.info("Deleted Record");
				msg = "Deleted Successfully";
			}

		} catch (Exception e) {

			msg = "error occured. Please contact Administrator";
			e.printStackTrace();
		}

		return msg;
	}

	public String preCheck(String reportid, String asondate, String fromdate, String todate) {

		String msg = "";
		Session hs = sessionFactory.getCurrentSession();
		Date dt;

		try {
			dt = new SimpleDateFormat("dd-MM-yyyy").parse(asondate);
			logger.info("Getting No of records in Master table :" + reportid);
			Long dtlcnt = (Long) hs
					.createQuery("select count(*) from BRF_FORWARD_REVEAL_MANUAL_ENTITY a where a.BRF_FORWARD_REVEAL_MANUAL_ID.report_date=?1")
					.setParameter(1, dt).getSingleResult();

			if (dtlcnt > 0) {	 
					msg = "success";			
			} else {
				msg = "Data Not available for the Report. Please Contact Administrator";
			}

		} catch (Exception e) {
			logger.info(e.getMessage());
			msg = "Error";
			e.printStackTrace();

		}

		return msg;

	}

	public ModelAndView getModData(String reportId, Pageable pageable) {

		int pageSize = pageable.getPageSize();
		int currentPage = pageable.getPageNumber();
		int startItem = currentPage * pageSize;

		ModelAndView mv = new ModelAndView(reportId + "/" + reportId + "Verify");
		Session hs = sessionFactory.getCurrentSession();
		logger.info("Getting Mod data");
		List<BRF_FORWARD_REVEAL_MOD> BRF_FORWARD_REVEAL_MOD = hs.createQuery("from BRF_FORWARD_REVEAL_MOD", BRF_FORWARD_REVEAL_MOD.class).getResultList();
		
		List<BRF_FORWARD_REVEAL_MOD> pagedlist;

		if (BRF_FORWARD_REVEAL_MOD.size() < startItem) {
			pagedlist = Collections.emptyList();
		} else {
			int toIndex = Math.min(startItem + pageSize, BRF_FORWARD_REVEAL_MOD.size());
			pagedlist = BRF_FORWARD_REVEAL_MOD.subList(startItem, toIndex);
		}

		logger.info("Pagination of Mod data");
		Page<BRF_FORWARD_REVEAL_MOD> BRF_FORWARD_REVEAL_MODPage = new PageImpl<BRF_FORWARD_REVEAL_MOD>(pagedlist, PageRequest.of(currentPage, pageSize),
				BRF_FORWARD_REVEAL_MOD.size());


		mv.setViewName(reportId + "/" + reportId + "Verify");
		mv.addObject("ModData", BRF_FORWARD_REVEAL_MODPage);
		mv.addObject("singleMod", new BRF_FORWARD_REVEAL_MOD());

		return mv;
	}

	public String verifyChanges(BRF_FORWARD_REVEAL_MOD moddata, String userid) {

		String msg = "";

		Session hs = sessionFactory.getCurrentSession();

		try {
			BRF_FORWARD_REVEAL_MOD mod = hs.find(BRF_FORWARD_REVEAL_MOD.class, moddata.getBRF_FORWARD_REVEAL_MOD_Id());
			mod.setLchg_user_id(userid);
			mod.setLchg_time(new Date());
			hs.flush();
			
			BRF_FORWARD_REVEALDetail detail = new BRF_FORWARD_REVEALDetail(mod);
			if (mod.getDel_flg().equals('D'))

			{
				logger.info("Verifying Record");
				hs.remove(detail);
			} else {
				hs.saveOrUpdate(detail);
			}
			hs.remove(mod);
			msg = "Verified Successfully";
		} catch (Exception e) {
			logger.info(e.getMessage());
			e.printStackTrace();
			msg = "Error Occured. Please contact Administrator";
		}

		return msg;
	}

	public String RejectChanges(BRF_FORWARD_REVEAL_MOD moddata, String userid) {

		String msg = "";

		Session hs = sessionFactory.getCurrentSession();

		try {
			BRF_FORWARD_REVEAL_MOD mod = hs.find(BRF_FORWARD_REVEAL_MOD.class, moddata.getBRF_FORWARD_REVEAL_MOD_Id());
			mod.setLchg_user_id(userid);
			hs.flush();
			logger.info("Deleting record form Mod table");
			hs.remove(mod);
			msg = "Rejected Successfully";
		} catch (Exception e) {
			logger.info(e.getMessage());
			e.printStackTrace();
			msg = "Error Occured. Please contact Administrator";
		}
		return msg;
	}

	
public List<ArchDates> getArchRepDates(String reportid) {
		
		Session hs = sessionFactory.getCurrentSession();

		SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");

		List<Object[]> result = hs.createQuery(
				"select distinct a.BRF_FORWARD_REVEAL_MANUAL_ID.report_date, a.from_date, a.to_date from BRF_FORWARD_REVEAL_MANUAL_ENTITY a ")
				.getResultList();

		List<ArchDates> archDates = new ArrayList<ArchDates>();

		for (Object[] a : result) {

			Date report_date = (Date) a[0];
			Date from_date = (Date) a[1];
			Date to_date = (Date) a[2];

			archDates.add(new ArchDates(df.format(report_date), df.format(from_date), df.format(to_date)));

		};

		return archDates;
	}


	public ModelAndView getSearchDetails(String reportId, String instancecode, String asondate, String fromdate,
			String todate, String currency, String dtltype, String subreportid, String secid, Pageable pageable,
			BRF_FORWARD_REVEALDetail detail) {

		ModelAndView mv = new ModelAndView();

		int pageSize = pageable.getPageSize();
		int currentPage = pageable.getPageNumber();
		int startItem = currentPage * pageSize;

		Session hs = sessionFactory.getCurrentSession();
		List<Object> BRF_FORWARD_REVEALDtl = new ArrayList<Object>();

		BRF_FORWARD_REVEALDetail dtl;

		if (dtltype.equals("report")) {
			dtl = hs.find(BRF_FORWARD_REVEALDetail.class, detail.getBRF_FORWARD_REVEALDetail_Id());
			
			
		} else {
			BRF_FORWARD_REVEAL_History hist = hs.find(BRF_FORWARD_REVEAL_History.class, detail.getBRF_FORWARD_REVEALDetail_Id());
			dtl = new BRF_FORWARD_REVEALDetail(hist);
		}

		if (dtl == null) {

			mv.addObject("searchmsg", "No Data Available");

		}

		BRF_FORWARD_REVEALDtl.add(dtl);

		List<Object> pagedlist;

		if (BRF_FORWARD_REVEALDtl.size() < startItem) {
			pagedlist = Collections.emptyList();
		} else {
			int toIndex = Math.min(startItem + pageSize, BRF_FORWARD_REVEALDtl.size());
			pagedlist = BRF_FORWARD_REVEALDtl.subList(startItem, toIndex);
		}

		logger.info("Converting to Page");
		Page<Object> BRF_FORWARD_REVEALDtlPage = new PageImpl<Object>(pagedlist, PageRequest.of(currentPage, pageSize),
				BRF_FORWARD_REVEALDtl.size());

		mv.setViewName(reportId + "/" + reportId + ":: reportcontent");
		mv.addObject("reportdetails", BRF_FORWARD_REVEALDtlPage);
		mv.addObject("singledetail", new BRF_FORWARD_REVEALDetail());

		return mv;

	}
	
	public String uploadPreCheck(String reportId, String reportDate) {

		String msg = "";
		Date repDate = null;
		try {
			repDate = new SimpleDateFormat("dd-MM-yyyy").parse(reportDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		Long cnt1 = (Long) sessionFactory.getCurrentSession()
				.createQuery("select count(*) from BRF_FORWARD_REVEALReport where BRF_FORWARD_REVEALReport_Id.report_date=?1")
				.setParameter(1, repDate).getSingleResult();

		if (cnt1 > 0) {
			msg = "Data Already available for the Report. Do you want to Replace?";
		} else {
			msg = "success";
		}

		return msg;
	}
	
	public String processUpload(String asondate, MultipartFile[] files, String userid)
			throws SQLException, FileNotFoundException, IOException {

		String result = "";

		String status = "";

		for (int i = 0; i < files.length; i++) {

			if (i == 0) {
				logger.info("processing BRF_FORWARD_REVEAL_MANUAL upload file");
				MultipartFile uploadedFile = files[i];
				result = BRF_FORWARD_REVEALUpload(uploadedFile, asondate, userid);
				if (result.equals("success")) {
					status = "success";
				}
				if (!status.equals("success")) {
					break;
				}
			}
		}
		return status;
	}
	
	public static File multipartToFile(MultipartFile multipart, String fileName)
			throws IllegalStateException, IOException {
		File convFile = new File(System.getProperty("java.io.tmpdir") + "/" + fileName);
		multipart.transferTo(convFile);
		return convFile;
	}
	
	public String BRF_FORWARD_REVEALUpload(MultipartFile file, String asondate, String userid)
			throws SQLException, FileNotFoundException, IOException {

		logger.info("crr0100ReportServices->crr0100Upload()");
		String fileName = file.getOriginalFilename();
		File convertedFile = multipartToFile(file, fileName);

		String fileExt = "";

		int i = fileName.lastIndexOf('.');
		if (i > 0) {
			fileExt = fileName.substring(i + 1);
		}

		logger.info("file extension : " + fileExt);

		String Errormsg = "";

		String status = "";

		logger.info("truncating table: BRF_FORWARD_REVEAL_MANUAL_TABLE");

		Session theSession = sessionFactory.getCurrentSession();
		theSession.createSQLQuery(" truncate table BRF_FORWARD_REVEAL_MANUAL_TABLE ").executeUpdate();
		

		logger.info("BRF_FORWARD_REVEAL_MANUAL_TABLE truncated");

		if (fileExt.equals("xlsx") || fileExt.equals("xls")) {
			
			logger.info("reading values from Excel");

			String cellval = "";

			try (InputStream is = new FileInputStream(convertedFile);

					Workbook workbook = StreamingReader.builder().rowCacheSize(100).bufferSize(4096).open(is)) {
				
				
				
				for (Sheet s : workbook) {
					
					int sheetNumber = workbook.getSheetIndex(s);
					if(sheetNumber == 0 ) {
			
					logger.info("inside workbook");
					
					for (Row r : s) {
									
						ArrayList<String> resultList = new ArrayList<>();
						if (r.getRowNum() == 0) {
							continue;
						}

						cellval = "";
						String val = null;
						for (int j = 0; j < 30; j++) {
							Cell cell = r.getCell(j);
							if (cell == null || cell.getStringCellValue().length() == 0) {
								val = null;
							} else {
								val = cell.getStringCellValue();
							
							}
							resultList.add(val);

						}

						 //String	poste = resultList.get(0);
						// String	treasury_bills_trade = resultList.get(1);
						// String value_date = resultList.get(2);
						 
						 //String num_operation = null;
						 //String gl_values= null;
						// if( resultList.get(1) == null || resultList.get(1)=="") {
						//	 System.out.println("hii");
						// }
						// else {
							//  num_operation = resultList.get(1);
		                  //    gl_values = resultList.get(2);

						// }

						 
					//	 NUM_OPERATION	GL_VALUES	OP_REFERENCE	POSTE	DEALDATE	VALUEDATE	MATURITYDATE	CURRENCY1	CURRENCY2	NOMINAL_1	RAMOUNT	NO_OF_DAYS	AMOUNT1	DEALRATE	AMOUNT2	REVAL_RATE	REVAL_AMOUNT	PROFITLOSS	CONTREPARTIE	BRANCH_CODE	LCYRATE	LCYPROFITLOSS

						 String num_operation = resultList.get(0);
                         String gl_values = resultList.get(1);
                         String op_reference = resultList.get(2);
                         String poste = resultList.get(3);
                         String dealdate = resultList.get(4);
                         String valuedate = resultList.get(5);
                         String maturitydate = resultList.get(6);
                         String currency1 = resultList.get(7);
                         String currency2 = resultList.get(8);
                         String nominal_1 = resultList.get(9);
                         String ramount = resultList.get(10);
                         String no_of_days = resultList.get(11);
                         String amount1 = resultList.get(12);
                         String dealrate = resultList.get(13);
                         String amount2 = resultList.get(14);
                         String reval_rate = resultList.get(15);
                         String reval_amount = resultList.get(16);
                         String profitloss = resultList.get(17);
                         String contrepartie = resultList.get(18);
                         String branch_code = resultList.get(19);
                         String lcyrate = resultList.get(20);
                         String lcyprofitloss = resultList.get(21);       
                         String report_date = resultList.get(22);
                         String entry_user = resultList.get(23);
                         String modify_user = resultList.get(24);
                         String verify_user = resultList.get(25);
                         String del_flg = resultList.get(26);
                         String entity_flg = resultList.get(27);
                         String modify_flg = resultList.get(28);
                        
                       	 if(num_operation == null) {
									 logger.info("break -> due to null value");
									 break;
								 }
								 BRF_FORWARD_REVEAL_MANUAL_ENTITY Brf_FORWARD_REVEAL_MANUAL_ENTITY = new BRF_FORWARD_REVEAL_MANUAL_ENTITY(num_operation,report_date,gl_values,op_reference,
											poste,currency1,currency2,nominal_1,ramount,no_of_days,amount1,dealrate,amount2,reval_rate,reval_amount,
											profitloss,contrepartie,branch_code,lcyrate,lcyprofitloss,entry_user,modify_user,verify_user,del_flg,entity_flg,modify_flg,new Date());
	//	 NUM_OPERATION	GL_VALUES	OP_REFERENCE	POSTE	DEALDATE	VALUEDATE	MATURITYDATE	CURRENCY1	CURRENCY2	NOMINAL_1	AMOUNT	NO_OF_DAYS	AMOUNT1	
	//DEALRATE	AMOUNT2	REVAL_RATE	REVAL_AMOUNT	PROFITLOSS	CONTREPARTIE	BRANCH_CODE	LCYRATE	LCYPROFITLOSS
					
								// BRF_FORWARD_REVEAL_MANUAL_ENTITY Brf_FORWARD_REVEAL_MANUAL_ENTITY1 = new BRF_FORWARD_REVEAL_MANUAL_ENTITY();								
								   Brf_FORWARD_REVEAL_MANUAL_ENTITY.setNum_operation(resultList.get(0));
								   Brf_FORWARD_REVEAL_MANUAL_ENTITY.setGl_values(resultList.get(1));
									
								   Brf_FORWARD_REVEAL_MANUAL_ENTITY.setOp_reference(resultList.get(2));
								   Brf_FORWARD_REVEAL_MANUAL_ENTITY.setPoste(resultList.get(3)); //
								   //Brf_FORWARD_REVEAL_MANUAL_ENTITY.setDealdate(resultList.get(4));
									  //Brf_FORWARD_REVEAL_MANUAL_ENTITY1.setNum_operation(resultList.get(1)); //
								   Brf_FORWARD_REVEAL_MANUAL_ENTITY.setNum_operation(resultList.get(1));
								   Brf_FORWARD_REVEAL_MANUAL_ENTITY.setCurrency1(resultList.get(7));
								   Brf_FORWARD_REVEAL_MANUAL_ENTITY.setCurrency2(resultList.get(8));
								   Brf_FORWARD_REVEAL_MANUAL_ENTITY.setNominal_1(resultList.get(9));
								   Brf_FORWARD_REVEAL_MANUAL_ENTITY.setRamount(resultList.get(10));
								   Brf_FORWARD_REVEAL_MANUAL_ENTITY.setNo_of_days(resultList.get(11));
								   Brf_FORWARD_REVEAL_MANUAL_ENTITY.setAmount1(resultList.get(12));
								   Brf_FORWARD_REVEAL_MANUAL_ENTITY.setDealrate(resultList.get(13));
								   Brf_FORWARD_REVEAL_MANUAL_ENTITY.setAmount2(resultList.get(14));
								   Brf_FORWARD_REVEAL_MANUAL_ENTITY.setReval_rate(resultList.get(15)); //
									//  REVAL_AMOUNT PROFITLOSS CONTREPARTIE BRANCH_CODE LCYRATE LCYPROFITLOSS
									  
								   Brf_FORWARD_REVEAL_MANUAL_ENTITY.setReval_amount(resultList.get(16));
								   Brf_FORWARD_REVEAL_MANUAL_ENTITY.setProfitloss(resultList.get(17));
								   Brf_FORWARD_REVEAL_MANUAL_ENTITY.setContrepartie(resultList.get(18));
								   Brf_FORWARD_REVEAL_MANUAL_ENTITY.setBranch_code(resultList.get(19));
								   Brf_FORWARD_REVEAL_MANUAL_ENTITY.setLcyrate(resultList.get(20));
								   Brf_FORWARD_REVEAL_MANUAL_ENTITY.setLcyprofitloss(resultList.get(21));
									  
									  // Brf_FORWARD_REVEAL_MANUAL_ENTITY1.setNum_operation(resultList.get(1)); //
								   //Brf_FORWARD_REVEAL_MANUAL_ENTITY.setNum_operation(resultList.get(1));
									  //Brf_FORWARD_REVEAL_MANUAL_ENTITY1.setNum_operation(resultList.get(1)); //
								   //Brf_FORWARD_REVEAL_MANUAL_ENTITY.setNum_operation(resultList.get(1)); //
								  // Brf_FORWARD_REVEAL_MANUAL_ENTITY.setNum_operation(resultList.get(1));
									  
									 	
								 Brf_FORWARD_REVEAL_MANUAL_rep.save(Brf_FORWARD_REVEAL_MANUAL_ENTITY);
								 
								 
						// System.out.println(Brf_FORWARD_REVEAL_MANUAL_ENTITY.toString());
						 logger.info("saving values:");
						//theSession.saveOrUpdate(Brf_FORWARD_REVEAL_MANUAL_ENTITY);
						theSession.flush();
						theSession.clear();
					}

					logger.info("inserted values into BRF_FORWARD_REVEAL_MANUAL_TABLE");
				}
				

				status = "success";
				}
			} catch (Exception e) {
				e.printStackTrace();
				status = "failed";
			}
		}

		else {
			logger.info("reading values from CSV");

			try {

				CSVReader reader = new CSVReader(new FileReader(convertedFile.getAbsolutePath()), ',');
				String[] nextLine;
				int skipRow = 0;
				while ((nextLine = reader.readNext()) != null) {

					if (skipRow > 0) {

						//String	treasury_bills_bank = nextLine[0];
						// String	treasury_bills_trade = nextLine[1];
						// String	report_date = nextLine[2];
						 
							String op_reference = nextLine[0];
	                        String poste = nextLine[1];
	                        String currency1 = nextLine[2];
	                        String currency2 = nextLine[3];
	                        String branch_code = nextLine[4];
	                        String contrepartie = nextLine[5];
	                        String num_operation = nextLine[6];
	                        String report_date = nextLine[7];
	                        String entry_user = nextLine[8];
	                        String modify_user = nextLine[9];
	                        String verify_user = nextLine[10];
	                        String del_flg = nextLine[11];
	                        String entity_flg = nextLine[12];
	                        String modify_flg = nextLine[13];
	                       
	                        String gl_values = nextLine[14];
	                        String nominal_1 = nextLine[15];
	                        String ramount = nextLine[16];
	                        String no_of_days = nextLine[17];
	                        String amount1 = nextLine[18];
	                        String amount2 = nextLine[19];
	                        String dealrate = nextLine[20];
	                        String reval_rate = nextLine[21];
	                        String reval_amount = nextLine[22];
	                        String profitloss = nextLine[23];
	                        String lcyrate = nextLine[24];
	                        String lcyprofitloss = nextLine[25];
					
								 if(report_date == null) {
									 logger.info("break -> due to null value");
									 break;
								 }
								 
								// BRF_FORWARD_REVEAL_MANUAL_ID bRF_FORWARD_REVEAL_MANUAL_ID = new BRF_FORWARD_REVEAL_MANUAL_ID(num_operation,report_date);
								 BRF_FORWARD_REVEAL_MANUAL_ENTITY Brf_FORWARD_REVEAL_MANUAL_ENTITY = new BRF_FORWARD_REVEAL_MANUAL_ENTITY(num_operation,report_date,gl_values,op_reference,
											poste,currency1,currency2,nominal_1,ramount,no_of_days,amount1,dealrate,amount2,reval_rate,reval_amount,
											profitloss,contrepartie,branch_code,lcyrate,lcyprofitloss,entry_user,modify_user,verify_user,del_flg,entity_flg,modify_flg,new Date());
								
								 
								// Brf_FORWARD_REVEAL_MANUAL_ENTITY1.setId(123); // Manually assign the identifier
								 // Set other attributes of the entity
								// session.save(entity); // Save the entity
								 //Brf_FORWARD_REVEAL_MANUAL_ENTITY1.setNum_operation(num_operation);
								 logger.info("saving values");
								 
						theSession.save(Brf_FORWARD_REVEAL_MANUAL_ENTITY);
						theSession.flush();
						theSession.clear();
					}
					skipRow++;
				}
				// theSession.saveOrUpdate(sup1000ManualS1List);
				logger.info("inserted values into CRR0100_MANUAL_TABLE");
				status = "success";
			} catch (Exception e) {
				e.printStackTrace();
				status = "failed";
			}

		}

		return status;

	}

	private String validateUpload(String asondate, String fileName) {

		String errormsg = null;

		logger.info("before procedure call");

		Session theSession = sessionFactory.getCurrentSession();

		
		
		StoredProcedureQuery query = theSession.createStoredProcedureQuery("COMMON_VALIDATION_SP")
				.registerStoredProcedureParameter("FILE_NAME", String.class, ParameterMode.IN)
				.registerStoredProcedureParameter("REPORT_DATE", String.class, ParameterMode.IN)
				.registerStoredProcedureParameter("VALD_STATUS", String.class, ParameterMode.OUT)
				.registerStoredProcedureParameter("ERROR_DTL", Clob.class, ParameterMode.OUT);

		logger.info("setting procedure variable");

		query.setParameter("FILE_NAME", fileName);
		query.setParameter("REPORT_DATE", asondate);
		logger.info("fileName--->>>"+fileName);
		logger.info("executing");

		query.execute();

		logger.info("setting out variable");
		String validStatus = (String) query.getOutputParameterValue("VALD_STATUS");
		Clob errorDtl = (Clob) query.getOutputParameterValue("ERROR_DTL");

		if (validStatus.equals("Y")) {
			System.out.println("HII");
			errormsg = "success";
			logger.info(errormsg);

		} else {

			
			try {
				errormsg = errorDtl.getSubString(1, (int) errorDtl.length());
				System.out.println(errorDtl.length());
			} catch (SQLException e) {
				e.printStackTrace();
			}
			logger.info(errormsg);
		}

		return errormsg;
	}
		

}