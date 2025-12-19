package com.bornfire.xbrl.services;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.bornfire.xbrl.entities.BRBS.SensManUploadRepo;
import com.bornfire.xbrl.entities.FWD_REVEAL.SensUploadOSEntries;
import com.monitorjbl.xlsx.StreamingReader;



@Service
public class UploadServices {
	
	private static final Logger logger = LoggerFactory.getLogger(UploadServices.class);
	
	 @Autowired 
	  BLS0100ReportServices bls0100ReportServices;
	
	@Autowired
	SessionFactory sessionFactory;
	

	
	@Autowired
	BrfMBillService BrfMBillService;

	/*
	 * @Autowired BRF_PROFIT_LOSS_MANUAL_Service brf_profit_loss_manual;
	 */


	

	@Autowired
	BRF_FORWARD_REVEAL_MANUAL_SERVICES BRF_FORWARD_REVEAL_MANUAL_SERVICES;
	@Autowired
	BrfOutstandingReportService BrfOutstandingReportService;
	@Autowired
	BrfprofitlossReportService BrfprofitlossReportService;
	@Autowired
	UploadServices uploadServices;
	
	@Autowired
	TREASURY treasury;
	
	@Autowired
	BRF156_SWAP_DEALS brf156_SWAP_DEALS;
	
	@Autowired
	SensManUploadRepo sensManUploadRepo;
	
	@Autowired
	Master_Tb_Upload master_Tb_Upload;
	
	@Autowired
	Placement_Upload placement_Upload;
	@Autowired
	Invest_Upload Invest_Upload;
	@Autowired
	FORWARD_REVEAL_UPLOAD FORWARD_REVEAL_UPLOAD;
	public String uploadPreCheck(String reportId, String reportDate) {
		
		String msg = "";
		
		switch (reportId) {
		 case "BLS0100": msg = bls0100ReportServices.uploadPreCheck(reportId,
				  reportDate); break;
				  
		 case "TREASURY": msg = treasury.uploadPreCheck(reportId,
				  reportDate); break;
				  
		 case "BRF156": msg = brf156_SWAP_DEALS.uploadPreCheck(reportId,
				  reportDate); break;
			
		case "BRF_FORWARD_REVEAL":
			msg = BRF_FORWARD_REVEAL_MANUAL_SERVICES.uploadPreCheck(reportId, reportDate);
			break;

		case "BRFOUTSTANDING":
			msg = BrfOutstandingReportService.uploadPreCheck(reportId, reportDate);
			break;
		
		case "BRFPROFITLOSS":
			msg = BrfprofitlossReportService.uploadPreCheck(reportId, reportDate);
			break;
			
		case "BRFMBILL":
			msg = BrfMBillService.uploadPreCheck(reportId, reportDate);
			break;
			
		case "MASTER_TB":
			msg = master_Tb_Upload.uploadPreCheck(reportId, reportDate);
			break;
			
		case "PLACEMENT":
			msg = placement_Upload.uploadPreCheck(reportId, reportDate);
			break;
		case "INVESTMENT":
			msg = Invest_Upload.uploadPreCheck(reportId, reportDate);
			break;
		case "FORWARD_REVEAL":
			msg = FORWARD_REVEAL_UPLOAD.uploadPreCheck(reportId, reportDate);
			break;

	
			default:
				logger.info("default -> no report matched in switch");	
		}
		
		return msg;
	}
	
	
	public String processUploadFiles(String reportId, String asondate, MultipartFile[] files, String userid) throws FileNotFoundException, SQLException, IOException {
		
		String msg = "";
		
		switch(reportId) {
		
		case "BLS0100": msg = bls0100ReportServices.processUpload(asondate, files,
				  userid); break;
		case "TREASURY": msg = treasury.processUpload(asondate, files,
				  userid); break;
		case "BRF156": msg = brf156_SWAP_DEALS.processUpload(asondate, files,
				  userid); break;
			
		case "BRF_FORWARD_REVEAL":
			msg = BRF_FORWARD_REVEAL_MANUAL_SERVICES.processUpload(asondate, files, userid);
			break;

	   case "BRFOUTSTANDING":
			msg = BrfOutstandingReportService.processUpload(asondate, files, userid);
			break;
	   case "BRFPROFITLOSS":
		msg = BrfprofitlossReportService.processUpload(asondate, files, userid);
		break;
	  case "BRFMBILL":
			msg = BrfMBillService.processUpload(asondate, files, userid);
			break;
	  case "MASTER_TB":
			msg = master_Tb_Upload.processUpload(asondate, files, userid);
			break;
			
	  case "PLACEMENT":
			msg = placement_Upload.processUpload(asondate, files, userid);
			break;
	  case "INVESTMENT":
			msg = Invest_Upload.processUpload(asondate, files, userid);
			break;
	  case "FORWARD_REVEAL":
			msg = FORWARD_REVEAL_UPLOAD.processUpload(asondate, files, userid);
			break;
	  case "BRF95GL":
		  msg = FORWARD_REVEAL_UPLOAD.processbrf95gl(asondate, files, userid);
		  break;
			
		default:
			logger.info("default -> no report matched in switch");
		
		}
		
		
		return msg;

	}
	
	
	
public String processUploadFiles(String screenId, MultipartFile file, String userid) throws FileNotFoundException, SQLException, IOException, IllegalStateException, ParseException {
		
		String msg = "";
		
		switch(screenId) {
		case "SensUp":
			msg = uploadServices.processUpload(screenId, file, userid);
			break;
		case "BRF156":
			msg = uploadServices.processUpload(screenId, file, userid);
			break;	
				
			
		default:
			System.out.println("default -> no screen matched in switch");
		
		}
		
		
		return msg;

	}


public String processUpload(String screenId,MultipartFile file, String userid) throws IllegalStateException, IOException, ParseException
{
	logger.info("NegativeListService -> processUpload()");

	String fileName = file.getOriginalFilename();
	logger.info(fileName);
	File convertedFile = multipartToFile(file, fileName);

	String fileExt = "";

	int i = fileName.lastIndexOf('.');
	if (i > 0) {
		fileExt = fileName.substring(i + 1);
	}

	logger.info("fileExt: " + fileExt);

	String Errormsg = "";
	
	String catch_Errormsg = "";

	String status = "";

//logger.info("truncating table: Negative List");

	Session theSession = sessionFactory.getCurrentSession();

//theSession.createSQLQuery(" truncate table NEGATIVE_LIST ").executeUpdate();

//logger.info("NEGATIVE_LIST truncated");

	if (fileExt.equals("xlsx") || fileExt.equals("xls")) {
		logger.info("reading values from Excel");

		String cellval = "";

		try (InputStream is = new FileInputStream(convertedFile);

				Workbook workbook = StreamingReader.builder().rowCacheSize(100).bufferSize(4096).open(is)) {

			for (Sheet s : workbook) {

				logger.info("inside workbook");

				for (Row r : s) {
					ArrayList<String> resultList = new ArrayList<>();
					if (r.getRowNum() == 0) {

						continue;

					}

					cellval = "";
					String val = null;
					for (int j = 0; j < 65; j++) {
						Cell cell = r.getCell(j);
						if (cell == null || cell.getStringCellValue().length() == 0) {
							val = null;
						} else {
							val = cell.getStringCellValue();
						}
						resultList.add(val);

					}
					
					
//					String BLACK_LIST_SET_ID = resultList.get(0);
					String sol_id	= resultList.get(0);
					String bacid = resultList.get(1);
					String foracid = resultList.get(2);
					String acct_name	= resultList.get(3);
					
					String tran_date1 = resultList.get(4);	
					
					String tran_id = resultList.get(5);
					String part_tran_id1 = resultList.get(6);
					String tran_amt1 = resultList.get(7);
					String tran_amt_inr1 = resultList.get(8);
					String tran_ref = resultList.get(9);
					String tran_particular = resultList.get(10);	
					String reversal_date1 = resultList.get(11);	
					
										BigDecimal tran_amt = new BigDecimal(tran_amt1);
										BigDecimal tran_amt_inr = new BigDecimal(tran_amt_inr1);
										BigDecimal part_tran_id = new BigDecimal(part_tran_id1);
										SimpleDateFormat dateFormat1 = new SimpleDateFormat("dd-MM-yyyy");

										Date reversal_date = dateFormat1.parse(reversal_date1);
										Date tran_date = dateFormat1.parse(tran_date1);
                                       // Date reversal_date =new Date(reversal_date1);
                                        

					String entry_user = userid;
					String modify_user = userid;
					Date entry_time = new Date();
					Date upl_date = new Date();
					String entity_flg = "Y";
					String modify_flg = "Y";
					String del_flg = "N";

			             SensUploadOSEntries info = new SensUploadOSEntries(sol_id, bacid,  foracid, acct_name,
							 tran_date,  tran_id,  part_tran_id,  
							 tran_amt,  tran_amt_inr,  tran_ref,  tran_particular, 
							   reversal_date,    upl_date,  del_flg,  modify_flg,
							 modify_user );
					
					
					
					BigDecimal billNumber = (BigDecimal) theSession.createNativeQuery("SELECT SEN_MANUAL_SEQ.NEXTVAL AS SRL_NO FROM DUAL").getSingleResult();
				    info.setSrl_num(billNumber.toString());
					
				    sensManUploadRepo.save(info);
				    
				    status="Uploaded Successfully";
				    		
				
	
				}
			}
		}
	}
	return status;
}
public static File multipartToFile(MultipartFile multipart, String fileName)
		throws IllegalStateException, IOException {


Path newFile = Paths.get(multipart.getOriginalFilename());
  try(InputStream is = multipart.getInputStream();
     OutputStream os = Files.newOutputStream(newFile)) {
     byte[] buffer = new byte[4096];
     int read = 0;
     while((read = is.read(buffer)) > 0) {
       os.write(buffer,0,read);
     }
  }
  return newFile.toFile();  



}


}
