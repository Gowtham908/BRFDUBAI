package com.bornfire.xbrl.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;

import com.bornfire.xbrl.entities.BRBS.BRFValidations;
import com.bornfire.xbrl.entities.BRBS.BRFValidationsRepo;
import com.bornfire.xbrl.entities.BRBS.ReportValidations;
import com.bornfire.xbrl.entities.BRBS.ReportValidationsRepo;
import com.bornfire.xbrl.entities.BRBS.ValidationResponse;



@Service
@Transactional
@ConfigurationProperties("output")
public class RBSValidationservices {

	@Autowired
	SessionFactory sessionFactory;

	@Autowired
	ReportValidationsRepo reportValidationsRepo;
	
	@Autowired
	BRFValidationsRepo brfValidationsRepo;


	private static final Logger logger = LoggerFactory.getLogger(RBSValidationservices.class);

	public ValidationResponse chkRBSValidations(ReportValidations reportValidations, String srl_no,
			String report_date) throws ParseException {
		logger.info("Entered Services");
		ReportValidations up = reportValidations;
		logger.info("report_date" + report_date);
		ValidationResponse msg = new ValidationResponse();
		Date dateFormat = new SimpleDateFormat("dd/MM/yyyy").parse(report_date);
		String convertDate=new SimpleDateFormat("dd-MMM-yyyy").format(dateFormat);
		
		ReportValidations reportValidation=reportValidationsRepo.findById(srl_no).get();
		String status="";
		List<Object[]> obj=new ArrayList<>();
		switch(srl_no) {
		case "1":
			obj=reportValidationsRepo.getCheckSrlNo1(convertDate);
			
			
			if(obj.size()>0){
				
				if(obj.get(0)[0].toString().equals(obj.get(0)[1].toString())) {
					reportValidation.setCur_status("Y");
					reportValidationsRepo.save(reportValidation);
					
					status="0";
					
					
				}else {
					reportValidation.setCur_status("N");
					reportValidationsRepo.save(reportValidation);
					status="1";
				}
			}else {
				status="1";
			}
			break;
		
		case "2":
			obj=reportValidationsRepo.getCheckSrlNo2(convertDate);
			
			if(obj.size()>0){
				
				if(obj.get(0)[0].toString().equals(obj.get(0)[1].toString())) {
					reportValidation.setCur_status("Y");
					reportValidationsRepo.save(reportValidation);
					status="0";
					
				}else {
					reportValidation.setCur_status("N");
					reportValidationsRepo.save(reportValidation);
					status="1";
					
				}
			}else {
				status="1";
			}
			break;
			
		case "3":
			obj=reportValidationsRepo.getCheckSrlNo3(convertDate);
			
			if(obj.size()>0){
				
				if(obj.get(0)[0].toString().equals(obj.get(0)[1].toString())) {
					reportValidation.setCur_status("Y");
					reportValidationsRepo.save(reportValidation);
					status="0";
					
				}else {
					reportValidation.setCur_status("N");
					reportValidationsRepo.save(reportValidation);
					status="1";
					
				}
			}else {
				status="1";
			}
			break;
		
		case "4":
			obj=reportValidationsRepo.getCheckSrlNo4(convertDate);
			
			if(obj.size()>0){
				
				if(obj.get(0)[0].toString().equals(obj.get(0)[3].toString())&&
						obj.get(0)[1].toString().equals(obj.get(0)[4].toString())&&
						obj.get(0)[2].toString().equals(obj.get(0)[5].toString())) {
					reportValidation.setCur_status("Y");
					reportValidationsRepo.save(reportValidation);
					status="0";
					
				}else {
					reportValidation.setCur_status("N");
					reportValidationsRepo.save(reportValidation);
					status="1";
					
				}
			}else {
				status="1";
			}
			break;
			
		case "5":
			obj=reportValidationsRepo.getCheckSrlNo5(convertDate);
			
			if(obj.size()>0){
				
				if(obj.get(0)[0].toString().equals(obj.get(0)[3].toString())&&
						obj.get(0)[1].toString().equals(obj.get(0)[4].toString())&&
						obj.get(0)[2].toString().equals(obj.get(0)[5].toString())) {
					reportValidation.setCur_status("Y");
					reportValidationsRepo.save(reportValidation);
					status="0";
					
				}else {
					reportValidation.setCur_status("N");
					reportValidationsRepo.save(reportValidation);
					status="1";
					
				}
			}else {
				status="1";
			}
			break;
			
		case "6":
			obj=reportValidationsRepo.getCheckSrlNo6(convertDate);
			
			if(obj.size()>0){
				
				
				
				if(obj.get(0)[0].toString().equals(obj.get(0)[6].toString())&&
						obj.get(0)[1].toString().equals(obj.get(0)[7].toString())&&
						obj.get(0)[2].toString().equals(obj.get(0)[8].toString())&&
						obj.get(0)[3].toString().equals(obj.get(0)[9].toString())&&
						obj.get(0)[4].toString().equals(obj.get(0)[10].toString())&&
						obj.get(0)[5].toString().equals(obj.get(0)[11].toString())) {
					reportValidation.setCur_status("Y");
					reportValidationsRepo.save(reportValidation);
					status="0";
					
				}else {
					reportValidation.setCur_status("N");
					reportValidationsRepo.save(reportValidation);
					status="1";
					
				}
			}else {
				status="1";
			}
			break;
			
		case "7":
			obj=reportValidationsRepo.getCheckSrlNo7(convertDate);
			
			if(obj.size()>0){
				
				if(obj.get(0)[0].toString().equals(obj.get(0)[6].toString())&&
						obj.get(0)[1].toString().equals(obj.get(0)[7].toString())&&
						obj.get(0)[2].toString().equals(obj.get(0)[8].toString())&&
						obj.get(0)[3].toString().equals(obj.get(0)[9].toString())&&
						obj.get(0)[4].toString().equals(obj.get(0)[10].toString())&&
						obj.get(0)[5].toString().equals(obj.get(0)[11].toString())) {
					reportValidation.setCur_status("Y");
					reportValidationsRepo.save(reportValidation);
					status="0";
					
				}else {
					reportValidation.setCur_status("N");
					reportValidationsRepo.save(reportValidation);
					status="1";
					
				}
			}else {
				status="1";
			}
			break;
			
		case "8":
			obj=reportValidationsRepo.getCheckSrlNo8(convertDate);
			
			if(obj.size()>0){
				
				if(obj.get(0)[0].toString().equals(obj.get(0)[6].toString())&&
						obj.get(0)[1].toString().equals(obj.get(0)[7].toString())&&
						obj.get(0)[2].toString().equals(obj.get(0)[8].toString())&&
						obj.get(0)[3].toString().equals(obj.get(0)[9].toString())&&
						obj.get(0)[4].toString().equals(obj.get(0)[10].toString())&&
						obj.get(0)[5].toString().equals(obj.get(0)[11].toString())) {
					reportValidation.setCur_status("Y");
					reportValidationsRepo.save(reportValidation);
					status="0";
					
				}else {
					reportValidation.setCur_status("N");
					reportValidationsRepo.save(reportValidation);
					status="1";
					
				}
			}else {
				status="1";
			}
			break;
			
		case "9":
			obj=reportValidationsRepo.getCheckSrlNo9(convertDate);
			
			if(obj.size()>0){
				
				if(obj.get(0)[0].toString().equals(obj.get(0)[6].toString())&&
						obj.get(0)[1].toString().equals(obj.get(0)[7].toString())&&
						obj.get(0)[2].toString().equals(obj.get(0)[8].toString())&&
						obj.get(0)[3].toString().equals(obj.get(0)[9].toString())&&
						obj.get(0)[4].toString().equals(obj.get(0)[10].toString())&&
						obj.get(0)[5].toString().equals(obj.get(0)[11].toString())) {
					reportValidation.setCur_status("Y");
					reportValidationsRepo.save(reportValidation);
					status="0";
					
				}else {
					reportValidation.setCur_status("N");
					reportValidationsRepo.save(reportValidation);
					status="1";
					
				}
			}else {
				status="1";
			}
			break;
			
		case "10":
			obj=reportValidationsRepo.getCheckSrlNo10(convertDate);
			
			if(obj.size()>0){
				
				if(obj.get(0)[0].toString().equals(obj.get(0)[6].toString())&&
						obj.get(0)[1].toString().equals(obj.get(0)[7].toString())&&
						obj.get(0)[2].toString().equals(obj.get(0)[8].toString())&&
						obj.get(0)[3].toString().equals(obj.get(0)[9].toString())&&
						obj.get(0)[4].toString().equals(obj.get(0)[10].toString())&&
						obj.get(0)[5].toString().equals(obj.get(0)[11].toString())) {
					reportValidation.setCur_status("Y");
					reportValidationsRepo.save(reportValidation);
					status="0";
					
				}else {
					reportValidation.setCur_status("N");
					reportValidationsRepo.save(reportValidation);
					status="1";
					
				}
			}else {
				status="1";
			}
			break;
			
		case "11":
			obj=reportValidationsRepo.getCheckSrlNo11(convertDate);
			
			if(obj.size()>0){
				
				if(obj.get(0)[0].toString().equals(obj.get(0)[6].toString())&&
						obj.get(0)[1].toString().equals(obj.get(0)[7].toString())&&
						obj.get(0)[2].toString().equals(obj.get(0)[8].toString())&&
						obj.get(0)[3].toString().equals(obj.get(0)[9].toString())&&
						obj.get(0)[4].toString().equals(obj.get(0)[10].toString())&&
						obj.get(0)[5].toString().equals(obj.get(0)[11].toString())) {
					reportValidation.setCur_status("Y");
					reportValidationsRepo.save(reportValidation);
					status="0";
					
				}else {
					reportValidation.setCur_status("N");
					reportValidationsRepo.save(reportValidation);
					status="1";
					
				}
			}else {
				status="1";
			}
			break;
			
		case "12":
			obj=reportValidationsRepo.getCheckSrlNo12(convertDate);
			
			if(obj.size()>0){
				
				if(obj.get(0)[0].toString().equals(obj.get(0)[6].toString())&&
						obj.get(0)[1].toString().equals(obj.get(0)[7].toString())&&
						obj.get(0)[2].toString().equals(obj.get(0)[8].toString())&&
						obj.get(0)[3].toString().equals(obj.get(0)[9].toString())&&
						obj.get(0)[4].toString().equals(obj.get(0)[10].toString())&&
						obj.get(0)[5].toString().equals(obj.get(0)[11].toString())) {
					reportValidation.setCur_status("Y");
					reportValidationsRepo.save(reportValidation);
					status="0";
					
				}else {
					reportValidation.setCur_status("N");
					reportValidationsRepo.save(reportValidation);
					status="1";
					
				}
			}else {
				status="1";
			}
			break;
			
		case "13":
			obj=reportValidationsRepo.getCheckSrlNo13(convertDate);
			
			if(obj.size()>0){
				
				if(obj.get(0)[0].toString().equals(obj.get(0)[6].toString())&&
						obj.get(0)[1].toString().equals(obj.get(0)[7].toString())&&
						obj.get(0)[2].toString().equals(obj.get(0)[8].toString())&&
						obj.get(0)[3].toString().equals(obj.get(0)[9].toString())&&
						obj.get(0)[4].toString().equals(obj.get(0)[10].toString())&&
						obj.get(0)[5].toString().equals(obj.get(0)[11].toString())) {
					reportValidation.setCur_status("Y");
					reportValidationsRepo.save(reportValidation);
					status="0";
					
				}else {
					reportValidation.setCur_status("N");
					reportValidationsRepo.save(reportValidation);
					status="1";
					
				}
			}else {
				status="1";
			}
			break;
			
		case "14":
			obj=reportValidationsRepo.getCheckSrlNo14(convertDate);
			
			if(obj.size()>0){
				
				if(obj.get(0)[0].toString().equals(obj.get(0)[2].toString())&&
						obj.get(0)[1].toString().equals(obj.get(0)[3].toString())) {
					reportValidation.setCur_status("Y");
					reportValidationsRepo.save(reportValidation);
					status="0";
					
				}else {
					reportValidation.setCur_status("N");
					reportValidationsRepo.save(reportValidation);
					status="1";
					
				}
			}else {
				status="1";
			}
			break;
			
			
		}
		
		if(status.equals("0")) {
			msg.setGenID("0");
			msg.setStatus("Validation Success");
		}else if(status.equals("1")) {
			msg.setGenID("0");
			msg.setStatus("Validation Failed");
		}

		return msg;

	}
	public ValidationResponse chkBRFValidations(BRFValidations brfValidations, String srl_no, String report_date) throws ParseException {
        logger.info("Entered chkBRFValidations method");
        logger.info("srl_no: {}", srl_no);
        logger.info("report_date: {}", report_date);

        ValidationResponse msg = new ValidationResponse();
        Date dateFormat = new SimpleDateFormat("dd/MM/yyyy").parse(report_date);
        String convertDate = new SimpleDateFormat("dd-MMM-yyyy").format(dateFormat);

        try {
            Optional<BRFValidations> brfValidationOpt = brfValidationsRepo.findById(srl_no);
            if (!brfValidationOpt.isPresent()) {
                logger.error("No BRFValidation found for srl_no: {}", srl_no);
                msg.setGenID("0");
                msg.setStatus("Validation record not found");
                return msg;
            }

            BRFValidations brfValidation = brfValidationOpt.get();
            String status = "";
            switch (srl_no) {
		case "1":
			//obj=brfValidationsRepo.getCheckSrlNo1(report_date);
		
			if(brfValidationsRepo.getCheckSrlNo1(convertDate)>0){
				brfValidation.setCur_status("Y");
				brfValidation.setRemarks2("Data Available for Current Report");
				brfValidationsRepo.save(brfValidation);	
				status="0";
			}else {
				brfValidation.setCur_status("N");
				brfValidation.setRemarks2("Generate Treasury Data for Current Report");
				brfValidationsRepo.save(brfValidation);
				status="2";
			}
			break;
		
		case "2":
			//obj=brfValidationsRepo.getCheckSrlNo1(report_date);
		
			if(brfValidationsRepo.getCheckSrlNo2(convertDate)>0){
				brfValidation.setCur_status("N");
				brfValidation.setRemarks2("Unmapped Accounts Available");
				brfValidationsRepo.save(brfValidation);	
				status="1";
			}else {
				brfValidation.setCur_status("Y");
				brfValidation.setRemarks2("No Unmapped Accounts");
				brfValidationsRepo.save(brfValidation);
				status="0";
			}
			break;
			
		case "3":
			//obj=brfValidationsRepo.getCheckSrlNo1(report_date);
		
			if(brfValidationsRepo.getCheckSrlNo3(convertDate)>0){
				brfValidation.setCur_status("Y");
				brfValidation.setRemarks2("Data Available for Current Report");
				brfValidationsRepo.save(brfValidation);	
				status="0";
			}else {
				brfValidation.setCur_status("N");
				brfValidation.setRemarks2("Generate Summary for Current Report");
				brfValidationsRepo.save(brfValidation);
				status="2";
			}
			break;
			
		case "4":
			//obj=brfValidationsRepo.getCheckSrlNo1(report_date);
		
			if(brfValidationsRepo.getCheckSrlNo4(convertDate)>0){
				brfValidation.setCur_status("Y");
				brfValidation.setRemarks2("Data Available for Current Report");
				brfValidationsRepo.save(brfValidation);	
				status="0";
			}else {
				brfValidation.setCur_status("N");
				brfValidation.setRemarks2("Generate Summary for Current Report");
				brfValidationsRepo.save(brfValidation);
				status="2";
			}
			break;
			
			
			case "5":
				//obj=brfValidationsRepo.getCheckSrlNo1(report_date);
			
				if(brfValidationsRepo.getCheckSrlNo5(convertDate)>0){
					brfValidation.setCur_status("N");
					brfValidation.setRemarks2("Unmapped Accounts Available");
					brfValidationsRepo.save(brfValidation);	
					status="1";
				}else {
					brfValidation.setCur_status("Y");
					brfValidation.setRemarks2("No Unmapped Accounts");
					brfValidationsRepo.save(brfValidation);
					status="0";
				}
				break;
			case "6":
				//obj=brfValidationsRepo.getCheckSrlNo1(report_date);
			
				if(brfValidationsRepo.getCheckSrlNo6(convertDate)>0){
					brfValidation.setCur_status("Y");
					brfValidation.setRemarks2("Data Available for Current Report");
					brfValidationsRepo.save(brfValidation);	
					status="0";
				}else {
					brfValidation.setCur_status("N");
					brfValidation.setRemarks2("Generate Treasury Data for Current Report");
					brfValidationsRepo.save(brfValidation);
					status="2";
				}
				break;
			case "7":
                List<Object[]> result = brfValidationsRepo.getCheckSrlNo7(convertDate);
                if (!result.isEmpty()) {
                    brfValidation.setCur_status("Y");
                    brfValidation.setRemarks2("ASSETS AND LIABILITIES ARE EQUAL");
                    status = "0";
                } else {
                    brfValidation.setCur_status("N");
                    brfValidation.setRemarks2("ASSETS AND LIABILITIES ARE NOT EQUAL");
                    status = "2";
                }
                brfValidationsRepo.save(brfValidation);
                break;
			case "8":
                List<Object[]> result1 = brfValidationsRepo.getCheckSrlNo8(convertDate);
                if (!result1.isEmpty()) {
                    brfValidation.setCur_status("Y");
                    brfValidation.setRemarks2("ASSETS AND LIABILITIES ARE EQUAL");
                    status = "0";
                } else {
                    brfValidation.setCur_status("N");
                    brfValidation.setRemarks2("ASSETS AND LIABILITIES ARE NOT EQUAL");
                    status = "2";
                }
                brfValidationsRepo.save(brfValidation);
                break;
			case "9":
                List<Object[]> result2 = brfValidationsRepo.getCheckSrlNo9(convertDate);
                if (!result2.isEmpty()) {
                    brfValidation.setCur_status("Y");
                    brfValidation.setRemarks2("PROFIT AND LOSS ARE EQUAL");
                    status = "0";
                } else {
                    brfValidation.setCur_status("N");
                    brfValidation.setRemarks2("PROFIT AND LOSS ARE NOT EQUAL");
                    status = "2";
                }
                brfValidationsRepo.save(brfValidation);
                break;
			case "10":
				//obj=brfValidationsRepo.getCheckSrlNo1(report_date);
			
				if(brfValidationsRepo.getCheckSrlNo10(convertDate)>0){
					brfValidation.setCur_status("Y");
					brfValidation.setRemarks2("Data Available for Current Report");
					brfValidationsRepo.save(brfValidation);	
					status="0";
				}else {
					brfValidation.setCur_status("N");
					brfValidation.setRemarks2("Generate Treasury Data for Current Report");
					brfValidationsRepo.save(brfValidation);
					status="2";
				}
				break;
			case "11":
				//obj=brfValidationsRepo.getCheckSrlNo1(report_date);
			
				if(brfValidationsRepo.getCheckSrlNo11(convertDate)>0){
					brfValidation.setCur_status("N");
					brfValidation.setRemarks2("Unmapped Accounts Available");
					brfValidationsRepo.save(brfValidation);	
					status="1";
				}else {
					brfValidation.setCur_status("Y");
					brfValidation.setRemarks2("No Unmapped Accounts");
					brfValidationsRepo.save(brfValidation);
					status="0";
				}
				break;
			case "12":
				//obj=brfValidationsRepo.getCheckSrlNo1(report_date);
			
				if(brfValidationsRepo.getCheckSrlNo12(convertDate)>0){
					brfValidation.setCur_status("Y");
					brfValidation.setRemarks2("Data Available for Current Report");
					brfValidationsRepo.save(brfValidation);	
					status="0";
				}else {
					brfValidation.setCur_status("N");
					brfValidation.setRemarks2("Generate Summary for Current Report");
					brfValidationsRepo.save(brfValidation);
					status="2";
				}
				break;
			case "13":
				//obj=brfValidationsRepo.getCheckSrlNo1(report_date);
			
				if(brfValidationsRepo.getCheckSrlNo13(convertDate)>0){
					brfValidation.setCur_status("Y");
					brfValidation.setRemarks2("Data Available for Current Report");
					brfValidationsRepo.save(brfValidation);	
					status="0";
				}else {
					brfValidation.setCur_status("N");
					brfValidation.setRemarks2("Generate Treasury Data for Current Report");
					brfValidationsRepo.save(brfValidation);
					status="2";
				}
				break;
			case "14":
				//obj=brfValidationsRepo.getCheckSrlNo1(report_date);
			
				if(brfValidationsRepo.getCheckSrlNo14(convertDate)>0){
					brfValidation.setCur_status("N");
					brfValidation.setRemarks2("Unmapped Accounts Available");
					brfValidationsRepo.save(brfValidation);	
					status="1";
				}else {
					brfValidation.setCur_status("Y");
					brfValidation.setRemarks2("No Unmapped Accounts");
					brfValidationsRepo.save(brfValidation);
					status="0";
				}
				break;
			case "15":
				//obj=brfValidationsRepo.getCheckSrlNo1(report_date);
			
				if(brfValidationsRepo.getCheckSrlNo15(convertDate)>0){
					brfValidation.setCur_status("Y");
					brfValidation.setRemarks2("Data Available for Current Report");
					brfValidationsRepo.save(brfValidation);	
					status="0";
				}else {
					brfValidation.setCur_status("N");
					brfValidation.setRemarks2("Generate Summary for Current Report");
					brfValidationsRepo.save(brfValidation);
					status="2";
				}
				break;
			case "16":
                List<Object[]> result3 = brfValidationsRepo.getCheckSrlNo16(convertDate);
                if (!result3.isEmpty()) {
                    brfValidation.setCur_status("Y");
                    brfValidation.setRemarks2("PROFIT AND LOSS ARE EQUAL");
                    status = "0";
                } else {
                    brfValidation.setCur_status("N");
                    brfValidation.setRemarks2("PROFIT AND LOSS ARE NOT EQUAL");
                    status = "2";
                }
                brfValidationsRepo.save(brfValidation);
                break;
			case "17":
				//obj=brfValidationsRepo.getCheckSrlNo1(report_date);
			
				if(brfValidationsRepo.getCheckSrlNo17(convertDate)>0){
					brfValidation.setCur_status("Y");
					brfValidation.setRemarks2("Data Available for Current Report");
					brfValidationsRepo.save(brfValidation);	
					status="0";
				}else {
					brfValidation.setCur_status("N");
					brfValidation.setRemarks2("Generate Treasury Data for Current Report");
					brfValidationsRepo.save(brfValidation);
					status="2";
				}
				break;
			case "18":
				//obj=brfValidationsRepo.getCheckSrlNo1(report_date);
			
				if(brfValidationsRepo.getCheckSrlNo18(convertDate)>0){
					brfValidation.setCur_status("N");
					brfValidation.setRemarks2("Unmapped Accounts Available");
					brfValidationsRepo.save(brfValidation);	
					status="1";
				}else {
					brfValidation.setCur_status("Y");
					brfValidation.setRemarks2("No Unmapped Accounts");
					brfValidationsRepo.save(brfValidation);
					status="0";
				}
				break;
			case "19":
				//obj=brfValidationsRepo.getCheckSrlNo1(report_date);
			
				if(brfValidationsRepo.getCheckSrlNo19(convertDate)>0){
					brfValidation.setCur_status("Y");
					brfValidation.setRemarks2("Data Available for Current Report");
					brfValidationsRepo.save(brfValidation);	
					status="0";
				}else {
					brfValidation.setCur_status("N");
					brfValidation.setRemarks2("Generate Summary for Current Report");
					brfValidationsRepo.save(brfValidation);
					status="2";
				}
				break;
			case "20":
				//obj=brfValidationsRepo.getCheckSrlNo1(report_date);
			
				if(brfValidationsRepo.getCheckSrlNo20(convertDate)>0){
					brfValidation.setCur_status("Y");
					brfValidation.setRemarks2("Data Available for Current Report");
					brfValidationsRepo.save(brfValidation);	
					status="0";
				}else {
					brfValidation.setCur_status("N");
					brfValidation.setRemarks2("Generate Treasury Data for Current Report");
					brfValidationsRepo.save(brfValidation);
					status="2";
				}
				break;
			case "21":
				//obj=brfValidationsRepo.getCheckSrlNo1(report_date);
			
				if(brfValidationsRepo.getCheckSrlNo21(convertDate)>0){
					brfValidation.setCur_status("N");
					brfValidation.setRemarks2("Unmapped Accounts Available");
					brfValidationsRepo.save(brfValidation);	
					status="1";
				}else {
					brfValidation.setCur_status("Y");
					brfValidation.setRemarks2("No Unmapped Accounts");
					brfValidationsRepo.save(brfValidation);
					status="0";
				}
				break;
			case "22":
				//obj=brfValidationsRepo.getCheckSrlNo1(report_date);
			
				if(brfValidationsRepo.getCheckSrlNo22(convertDate)>0){
					brfValidation.setCur_status("Y");
					brfValidation.setRemarks2("Data Available for Current Report");
					brfValidationsRepo.save(brfValidation);	
					status="0";
				}else {
					brfValidation.setCur_status("N");
					brfValidation.setRemarks2("Generate Summary for Current Report");
					brfValidationsRepo.save(brfValidation);
					status="2";
				}
				break;
			case "23":
                List<Object[]> result4 = brfValidationsRepo.getCheckSrlNo23(convertDate);
                if (!result4.isEmpty()) {
                    brfValidation.setCur_status("Y");
                    brfValidation.setRemarks2("NET LENDING ARE EQUAL");
                    status = "0";
                } else {
                    brfValidation.setCur_status("N");
                    brfValidation.setRemarks2("NET LENDING ARE NOT EQUAL");
                    status = "2";
                }
                brfValidationsRepo.save(brfValidation);
                break;
			case "24":
                List<Object[]> result5 = brfValidationsRepo.getCheckSrlNo24(convertDate);
                if (!result5.isEmpty()) {
                    brfValidation.setCur_status("Y");
                    brfValidation.setRemarks2("LENDING TO NBFI ARE EQUAL");
                    status = "0";
                } else {
                    brfValidation.setCur_status("N");
                    brfValidation.setRemarks2("LENDING TO NBFI ARE NOT EQUAL");
                    status = "2";
                }
                brfValidationsRepo.save(brfValidation);
                break;
			case "25":
                List<Object[]> result6 = brfValidationsRepo.getCheckSrlNo25(convertDate);
                if (!result6.isEmpty()) {
                    brfValidation.setCur_status("Y");
                    brfValidation.setRemarks2("INTERBANK PLACEMENTS ARE EQUAL");
                    status = "0";
                } else {
                    brfValidation.setCur_status("N");
                    brfValidation.setRemarks2("INTERBANK PLACEMENTS ARE NOT EQUAL");
                    status = "2";
                }
                brfValidationsRepo.save(brfValidation);
                break;
			case "26":
                List<Object[]> result7 = brfValidationsRepo.getCheckSrlNo26(convertDate);
                if (!result7.isEmpty()) {
                    brfValidation.setCur_status("Y");
                    brfValidation.setRemarks2("TOTAL OWN FUNDS ARE EQUAL");
                    status = "0";
                } else {
                    brfValidation.setCur_status("N");
                    brfValidation.setRemarks2("TOTAL OWN FUNDS ARE NOT EQUAL");
                    status = "2";
                }
                brfValidationsRepo.save(brfValidation);
                break;
			case "27":
                List<Object[]> result8 = brfValidationsRepo.getCheckSrlNo27(convertDate);
                if (!result8.isEmpty()) {
                    brfValidation.setCur_status("Y");
                    brfValidation.setRemarks2("GOODWILL AND OTHER INTANGIBLE ASSETS ARE EQUAL");
                    status = "0";
                } else {
                    brfValidation.setCur_status("N");
                    brfValidation.setRemarks2("GOODWILL AND OTHER INTANGIBLE ASSETS ARE NOT EQUAL");
                    status = "2";
                }
                brfValidationsRepo.save(brfValidation);
                break;
			case "28":
                List<Object[]> result9 = brfValidationsRepo.getCheckSrlNo28(convertDate);
                if (!result9.isEmpty()) {
                    brfValidation.setCur_status("Y");
                    brfValidation.setRemarks2("NET FIXED ASSETS ARE EQUAL");
                    status = "0";
                } else {
                    brfValidation.setCur_status("N");
                    brfValidation.setRemarks2("NET FIXED ASSETS ARE NOT EQUAL");
                    status = "2";
                }
                brfValidationsRepo.save(brfValidation);
                break;
			case "29":
                List<Object[]> result10 = brfValidationsRepo.getCheckSrlNo29(convertDate);
                if (!result10.isEmpty()) {
                    brfValidation.setCur_status("Y");
                    brfValidation.setRemarks2("FUNDS ALLOCATED TO BRANCHES ABROAD ARE EQUAL");
                    status = "0";
                } else {
                    brfValidation.setCur_status("N");
                    brfValidation.setRemarks2("FUNDS ALLOCATED TO BRANCHES ABROAD ARE NOT EQUAL");
                    status = "2";
                }
                brfValidationsRepo.save(brfValidation);
                break;
			case "30":
                List<Object[]> result11 = brfValidationsRepo.getCheckSrlNo30(convertDate);
                if (!result11.isEmpty()) {
                    brfValidation.setCur_status("Y");
                    brfValidation.setRemarks2("NON REPAYABLE HEAD OFFICE FUNDS ARE EQUAL");
                    status = "0";
                } else {
                    brfValidation.setCur_status("N");
                    brfValidation.setRemarks2("NON REPAYABLE HEAD OFFICE FUNDS ARE NOT EQUAL");
                    status = "2";
                }
                brfValidationsRepo.save(brfValidation);
                break;
			case "31":
                List<Object[]> result12 = brfValidationsRepo.getCheckSrlNo31(convertDate);
                if (!result12.isEmpty()) {
                    brfValidation.setCur_status("Y");
                    brfValidation.setRemarks2("INTERBANK DEPOSITS ARE EQUAL");
                    status = "0";
                } else {
                    brfValidation.setCur_status("N");
                    brfValidation.setRemarks2("INTERBANK DEPOSITS ARE NOT EQUAL");
                    status = "2";
                }
                brfValidationsRepo.save(brfValidation);
                break;
			case "32":
                List<Object[]> result13 = brfValidationsRepo.getCheckSrlNo32(convertDate);
                if (!result13.isEmpty()) {
                    brfValidation.setCur_status("Y");
                    brfValidation.setRemarks2("NON BANKING FINANCIAL INSTITUTIONS ARE EQUAL");
                    status = "0";
                } else {
                    brfValidation.setCur_status("N");
                    brfValidation.setRemarks2("NON BANKING FINANCIAL INSTITUTIONS ARE NOT EQUAL");
                    status = "2";
                }
                brfValidationsRepo.save(brfValidation);
                break;
			case "33":
                List<Object[]> result14 = brfValidationsRepo.getCheckSrlNo33(convertDate);
                if (!result14.isEmpty()) {
                    brfValidation.setCur_status("Y");
                    brfValidation.setRemarks2("NBFI DEPOSITS ARE EQUAL");
                    status = "0";
                } else {
                    brfValidation.setCur_status("N");
                    brfValidation.setRemarks2("NBFI DEPOSITS ARE NOT EQUAL");
                    status = "2";
                }
                brfValidationsRepo.save(brfValidation);
                break;
			case "34":
                List<Object[]> result15 = brfValidationsRepo.getCheckSrlNo34(convertDate);
                if (!result15.isEmpty()) {
                    brfValidation.setCur_status("Y");
                    brfValidation.setRemarks2("CUSTOMER DEPOSITS ARE EQUAL");
                    status = "0";
                } else {
                    brfValidation.setCur_status("N");
                    brfValidation.setRemarks2("CUSTOMER DEPOSITS ARE NOT EQUAL");
                    status = "2";
                }
                brfValidationsRepo.save(brfValidation);
                break;
			case "35":
                List<Object[]> result16 = brfValidationsRepo.getCheckSrlNo35(convertDate);
                if (!result16.isEmpty()) {
                    brfValidation.setCur_status("Y");
                    brfValidation.setRemarks2("85% OF THE REST OF CUSTOMER DEPOSITS ARE EQUAL");
                    status = "0";
                } else {
                    brfValidation.setCur_status("N");
                    brfValidation.setRemarks2("85% OF THE REST OF CUSTOMER DEPOSITS ARE NOT EQUAL");
                    status = "2";
                }
                brfValidationsRepo.save(brfValidation);
                break;
			case "36":
                List<Object[]> result17 = brfValidationsRepo.getCheckSrlNo36(convertDate);
                if (!result17.isEmpty()) {
                    brfValidation.setCur_status("Y");
                    brfValidation.setRemarks2("CAPITAL MARKET FUNDING ARE EQUAL");
                    status = "0";
                } else {
                    brfValidation.setCur_status("N");
                    brfValidation.setRemarks2("CAPITAL MARKET FUNDING ARE NOT EQUAL");
                    status = "2";
                }
                brfValidationsRepo.save(brfValidation);
                break;
			case "37":
                List<Object[]> result18 = brfValidationsRepo.getCheckSrlNo37(convertDate);
                if (!result18.isEmpty()) {
                    brfValidation.setCur_status("Y");
                    brfValidation.setRemarks2("HEAD OFFICE LOANS ARE EQUAL");
                    status = "0";
                } else {
                    brfValidation.setCur_status("N");
                    brfValidation.setRemarks2("HEAD OFFICE LOANS ARE NOT EQUAL");
                    status = "2";
                }
                brfValidationsRepo.save(brfValidation);
                break;
			case "38":
				//obj=brfValidationsRepo.getCheckSrlNo1(report_date);
			
				if(brfValidationsRepo.getCheckSrlNo38(convertDate)>0){
					brfValidation.setCur_status("Y");
					brfValidation.setRemarks2("Data Available for Current Report");
					brfValidationsRepo.save(brfValidation);	
					status="0";
				}else {
					brfValidation.setCur_status("N");
					brfValidation.setRemarks2("Generate Treasury Data for Current Report");
					brfValidationsRepo.save(brfValidation);
					status="2";
				}
				break;
			case "39":
				//obj=brfValidationsRepo.getCheckSrlNo1(report_date);
			
				if(brfValidationsRepo.getCheckSrlNo39(convertDate)>0){
					brfValidation.setCur_status("N");
					brfValidation.setRemarks2("Unmapped Accounts Available");
					brfValidationsRepo.save(brfValidation);	
					status="1";
				}else {
					brfValidation.setCur_status("Y");
					brfValidation.setRemarks2("No Unmapped Accounts");
					brfValidationsRepo.save(brfValidation);
					status="0";
				}
				break;
			case "40":
				//obj=brfValidationsRepo.getCheckSrlNo1(report_date);
			
				if(brfValidationsRepo.getCheckSrlNo40(convertDate)>0){
					brfValidation.setCur_status("Y");
					brfValidation.setRemarks2("Data Available for Current Report");
					brfValidationsRepo.save(brfValidation);	
					status="0";
				}else {
					brfValidation.setCur_status("N");
					brfValidation.setRemarks2("Generate Summary for Current Report");
					brfValidationsRepo.save(brfValidation);
					status="2";
				}
				break;
			case "41":
                List<Object[]> result19 = brfValidationsRepo.getCheckSrlNo41(convertDate);
                if (!result19.isEmpty()) {
                    brfValidation.setCur_status("Y");
                    brfValidation.setRemarks2("TOTAL LIABILITIES ARE EQUAL");
                    status = "0";
                } else {
                    brfValidation.setCur_status("N");
                    brfValidation.setRemarks2("TOTAL LIABILITIES ARE NOT EQUAL");
                    status = "2";
                }
                brfValidationsRepo.save(brfValidation);
                break;
			case "45":
                List<Object[]> result20 = brfValidationsRepo.getCheckSrlNo45(convertDate);
                if (!result20.isEmpty()) {
                    brfValidation.setCur_status("Y");
                    brfValidation.setRemarks2("PHYSICAL CASH IN HAND ARE EQUAL");
                    status = "0";
                } else {
                    brfValidation.setCur_status("N");
                    brfValidation.setRemarks2("PHYSICAL CASH IN HAND ARE  NOT EQUAL");
                    status = "2";
                }
                brfValidationsRepo.save(brfValidation);
                break;
			case "46":
                List<Object[]> result21 = brfValidationsRepo.getCheckSrlNo46(convertDate);
                if (!result21.isEmpty()) {
                    brfValidation.setCur_status("Y");
                    brfValidation.setRemarks2("STATUTORY RESERVES WITH CENTRAL BANK ARE EQUAL");
                    status = "0";
                } else {
                    brfValidation.setCur_status("N");
                    brfValidation.setRemarks2("STATUTORY RESERVES WITH CENTRAL BANK ARE NOT EQUAL");
                    status = "2";
                }
                brfValidationsRepo.save(brfValidation);
                break; 
			case "47":
                List<Object[]> result22 = brfValidationsRepo.getCheckSrlNo47(convertDate);
                if (!result22.isEmpty()) {
                    brfValidation.setCur_status("Y");
                    brfValidation.setRemarks2("FREE AND OTHER ACCOUNT BALANCES AT THE CENTRAL BANK ARE EQUAL");
                    status = "0";
                } else {
                    brfValidation.setCur_status("N");
                    brfValidation.setRemarks2("FREE AND OTHER ACCOUNT BALANCES AT THE CENTRAL BANK ARE NOT EQUAL");
                    status = "2";
                }
                brfValidationsRepo.save(brfValidation);
                break;
			case "48":
                List<Object[]> result23 = brfValidationsRepo.getCheckSrlNo48(convertDate);
                if (!result23.isEmpty()) {
                    brfValidation.setCur_status("Y");
                    brfValidation.setRemarks2("CENTRAL BANK CDS ARE EQUAL");
                    status = "0";
                } else {
                    brfValidation.setCur_status("N");
                    brfValidation.setRemarks2("CENTRAL BANK CDS ARE NOT EQUAL");
                    status = "2";
                }
                brfValidationsRepo.save(brfValidation);
                break;
			case "49":
                List<Object[]> result24 = brfValidationsRepo.getCheckSrlNo49(convertDate);
                if (!result24.isEmpty()) {
                    brfValidation.setCur_status("Y");
                    brfValidation.setRemarks2("UAE FEDERAL GOVERNMENT BONDS ARE EQUAL");
                    status = "0";
                } else {
                    brfValidation.setCur_status("N");
                    brfValidation.setRemarks2("UAE FEDERAL GOVERNMENT BONDS ARE NOT EQUAL");
                    status = "2";
                }
                brfValidationsRepo.save(brfValidation);
                break;    
			case "42":
				//obj=brfValidationsRepo.getCheckSrlNo1(report_date);
			
				if(brfValidationsRepo.getCheckSrlNo42(convertDate)>0){
					brfValidation.setCur_status("Y");
					brfValidation.setRemarks2("Data Available for Current Report");
					brfValidationsRepo.save(brfValidation);	
					status="0";
				}else {
					brfValidation.setCur_status("N");
					brfValidation.setRemarks2("Generate Treasury Data for Current Report");
					brfValidationsRepo.save(brfValidation);
					status="2";
				}
				break;
			case "43":
				//obj=brfValidationsRepo.getCheckSrlNo1(report_date);
			
				if(brfValidationsRepo.getCheckSrlNo43(convertDate)>0){
					brfValidation.setCur_status("N");
					brfValidation.setRemarks2("Unmapped Accounts Available");
					brfValidationsRepo.save(brfValidation);	
					status="1";
				}else {
					brfValidation.setCur_status("Y");
					brfValidation.setRemarks2("No Unmapped Accounts");
					brfValidationsRepo.save(brfValidation);
					status="0";
				}
				break;
			case "44":
				//obj=brfValidationsRepo.getCheckSrlNo1(report_date);
			
				if(brfValidationsRepo.getCheckSrlNo44(convertDate)>0){
					brfValidation.setCur_status("Y");
					brfValidation.setRemarks2("Data Available for Current Report");
					brfValidationsRepo.save(brfValidation);	
					status="0";
				}else {
					brfValidation.setCur_status("N");
					brfValidation.setRemarks2("Generate Summary for Current Report");
					brfValidationsRepo.save(brfValidation);
					status="2";
				}
				break;
			case "50":
                List<Object[]> result25 = brfValidationsRepo.getCheckSrlNo50(convertDate);
                if (!result25.isEmpty()) {
                    brfValidation.setCur_status("Y");
                    brfValidation.setRemarks2("CASH, RESERVES AND BALANCES WITH CENTRAL BANK - 0 - 7 DAYS ARE EQUAL");
                    status = "0";
                } else {
                    brfValidation.setCur_status("N");
                    brfValidation.setRemarks2("CASH, RESERVES AND BALANCES WITH CENTRAL BANK - 0 - 7 DAYS ARE NOT EQUAL");
                    status = "2";
                }
                brfValidationsRepo.save(brfValidation);
                break; 
			case "51":
                List<Object[]> result26 = brfValidationsRepo.getCheckSrlNo51(convertDate);
                if (!result26.isEmpty()) {
                    brfValidation.setCur_status("Y");
                    brfValidation.setRemarks2("CASH, RESERVES AND BALANCES WITH CENTRAL BANK - 8-14 DAYS ARE EQUAL");
                    status = "0";
                } else {
                    brfValidation.setCur_status("N");
                    brfValidation.setRemarks2("CASH, RESERVES AND BALANCES WITH CENTRAL BANK - 8-14 DAYS ARE NOT EQUAL");
                    status = "2";
                }
                brfValidationsRepo.save(brfValidation);
                break; 
			case "52":
                List<Object[]> result27 = brfValidationsRepo.getCheckSrlNo52(convertDate);
                if (!result27.isEmpty()) {
                    brfValidation.setCur_status("Y");
                    brfValidation.setRemarks2("NET FIXED ASSETS ARE EQUAL");
                    status = "0";
                } else {
                    brfValidation.setCur_status("N");
                    brfValidation.setRemarks2("NET FIXED ASSETS ARE NOT EQUAL");
                    status = "2";
                }
                brfValidationsRepo.save(brfValidation);
                break;
			case "53":
                List<Object[]> result28 = brfValidationsRepo.getCheckSrlNo53(convertDate);
                if (!result28.isEmpty()) {
                    brfValidation.setCur_status("Y");
                    brfValidation.setRemarks2("GOVERNMENT AND PUBLIC SECTOR ARE EQUAL");
                    status = "0";
                } else {
                    brfValidation.setCur_status("N");
                    brfValidation.setRemarks2("GOVERNMENT AND PUBLIC SECTOR ARE NOT EQUAL");
                    status = "2";
                }
                brfValidationsRepo.save(brfValidation);
                break;
			case "54":
                List<Object[]> result29 = brfValidationsRepo.getCheckSrlNo54(convertDate);
                if (!result29.isEmpty()) {
                    brfValidation.setCur_status("Y");
                    brfValidation.setRemarks2("OTHER ASSETS1 - 0 - 7 DAYS ARE EQUAL");
                    status = "0";
                } else {
                    brfValidation.setCur_status("N");
                    brfValidation.setRemarks2("OTHER ASSETS1 - 0 - 7 DAYS ARE NOT EQUAL");
                    status = "2";
                }
                brfValidationsRepo.save(brfValidation);
                break;
			case "55":
                List<Object[]> result30 = brfValidationsRepo.getCheckSrlNo55(convertDate);
                if (!result30.isEmpty()) {
                    brfValidation.setCur_status("Y");
                    brfValidation.setRemarks2("OTHER ASSETS1 - 15 DAYS - 1 MONTH ARE EQUAL");
                    status = "0";
                } else {
                    brfValidation.setCur_status("N");
                    brfValidation.setRemarks2("OTHER ASSETS1 - 15 DAYS - 1 MONTH ARE NOT EQUAL");
                    status = "2";
                }
                brfValidationsRepo.save(brfValidation);
                break;
			case "56":
                List<Object[]> result31 = brfValidationsRepo.getCheckSrlNo56(convertDate);
                if (!result31.isEmpty()) {
                    brfValidation.setCur_status("Y");
                    brfValidation.setRemarks2("OTHER ASSETS1 - 3 - 6 MONTHS ARE EQUAL");
                    status = "0";
                } else {
                    brfValidation.setCur_status("N");
                    brfValidation.setRemarks2("OTHER ASSETS1 - 3 - 6 MONTHS ARE NOT EQUAL");
                    status = "2";
                }
                brfValidationsRepo.save(brfValidation);
                break;
			case "57":
                List<Object[]> result32 = brfValidationsRepo.getCheckSrlNo57(convertDate);
                if (!result32.isEmpty()) {
                    brfValidation.setCur_status("Y");
                    brfValidation.setRemarks2("OTHER ASSETS1 - 6 - 12 MONTHS ARE EQUAL");
                    status = "0";
                } else {
                    brfValidation.setCur_status("N");
                    brfValidation.setRemarks2("OTHER ASSETS1 - 6 - 12 MONTHS ARE NOT EQUAL");
                    status = "2";
                }
                brfValidationsRepo.save(brfValidation);
                break;
			case "58":
                List<Object[]> result33 = brfValidationsRepo.getCheckSrlNo58(convertDate);
                if (!result33.isEmpty()) {
                    brfValidation.setCur_status("Y");
                    brfValidation.setRemarks2("OTHER LIABILITIES - 1 - 3 MONTHS ARE EQUAL");
                    status = "0";
                } else {
                    brfValidation.setCur_status("N");
                    brfValidation.setRemarks2("OTHER LIABILITIES - 1 - 3 MONTHS ARE NOT EQUAL");
                    status = "2";
                }
                brfValidationsRepo.save(brfValidation);
                break;
			case "59":
                List<Object[]> result34 = brfValidationsRepo.getCheckSrlNo59(convertDate);
                if (!result34.isEmpty()) {
                    brfValidation.setCur_status("Y");
                    brfValidation.setRemarks2("OTHER LIABILITIES - 3 - 6 MONTHS ARE EQUAL");
                    status = "0";
                } else {
                    brfValidation.setCur_status("N");
                    brfValidation.setRemarks2("OTHER LIABILITIES - 3 - 6 MONTHS ARE NOT EQUAL");
                    status = "2";
                }
                brfValidationsRepo.save(brfValidation);
                break;
			case "60":
                List<Object[]> result35 = brfValidationsRepo.getCheckSrlNo60(convertDate);
                if (!result35.isEmpty()) {
                    brfValidation.setCur_status("Y");
                    brfValidation.setRemarks2("SPECIFIC, INTEREST IN SUSPENSE, COLLECTIVE IMPAIRMENT PROVISIONS ARE EQUAL");
                    status = "0";
                } else {
                    brfValidation.setCur_status("N");
                    brfValidation.setRemarks2("SPECIFIC, INTEREST IN SUSPENSE, COLLECTIVE IMPAIRMENT PROVISIONS ARE NOT EQUAL");
                    status = "2";
                }
                brfValidationsRepo.save(brfValidation);
                break;
			case "61":
                List<Object[]> result36 = brfValidationsRepo.getCheckSrlNo61(convertDate);
                if (!result36.isEmpty()) {
                    brfValidation.setCur_status("Y");
                    brfValidation.setRemarks2("CAPITAL AND RESERVES ARE EQUAL");
                    status = "0";
                } else {
                    brfValidation.setCur_status("N");
                    brfValidation.setRemarks2("CAPITAL AND RESERVES ARE NOT EQUAL");
                    status = "2";
                }
                brfValidationsRepo.save(brfValidation);
                break;
			case "62":
                List<Object[]> result37 = brfValidationsRepo.getCheckSrlNo62(convertDate);
                if (!result37.isEmpty()) {
                    brfValidation.setCur_status("Y");
                    brfValidation.setRemarks2("CASH, RESERVES AND BALANCES WITH CENTRAL BANK ARE EQUAL");
                    status = "0";
                } else {
                    brfValidation.setCur_status("N");
                    brfValidation.setRemarks2("CASH, RESERVES AND BALANCES WITH CENTRAL BANK ARE NOT EQUAL");
                    status = "2";
                }
                brfValidationsRepo.save(brfValidation);
                break;
			case "63":
                List<Object[]> result38 = brfValidationsRepo.getCheckSrlNo63(convertDate);
                if (!result38.isEmpty()) {
                    brfValidation.setCur_status("Y");
                    brfValidation.setRemarks2("CENTRAL BANK CDS - 0 - 7 DAYS ARE EQUAL");
                    status = "0";
                } else {
                    brfValidation.setCur_status("N");
                    brfValidation.setRemarks2("CENTRAL BANK CDS - 0 - 7 DAYS ARE NOT EQUAL");
                    status = "2";
                }
                brfValidationsRepo.save(brfValidation);
                break;
			case "64":
                List<Object[]> result39 = brfValidationsRepo.getCheckSrlNo64(convertDate);
                if (!result39.isEmpty()) {
                    brfValidation.setCur_status("Y");
                    brfValidation.setRemarks2("CENTRAL BANK CDS - 8-14 DAYS ARE EQUAL");
                    status = "0";
                } else {
                    brfValidation.setCur_status("N");
                    brfValidation.setRemarks2("CENTRAL BANK CDS - 8-14 DAYS ARE NOT EQUAL");
                    status = "2";
                }
                brfValidationsRepo.save(brfValidation);
                break;
			case "65":
                List<Object[]> result40 = brfValidationsRepo.getCheckSrlNo65(convertDate);
                if (!result40.isEmpty()) {
                    brfValidation.setCur_status("Y");
                    brfValidation.setRemarks2("CENTRAL BANK CDS - 15 DAYS ARE EQUAL");
                    status = "0";
                } else {
                    brfValidation.setCur_status("N");
                    brfValidation.setRemarks2("CENTRAL BANK CDS - 15 DAYS ARE NOT EQUAL");
                    status = "2";
                }
                brfValidationsRepo.save(brfValidation);
                break;
			case "66":
                List<Object[]> result41 = brfValidationsRepo.getCheckSrlNo66(convertDate);
                if (!result41.isEmpty()) {
                    brfValidation.setCur_status("Y");
                    brfValidation.setRemarks2("CENTRAL BANK CDS - 1 - 3 MONTHS ARE EQUAL");
                    status = "0";
                } else {
                    brfValidation.setCur_status("N");
                    brfValidation.setRemarks2("CENTRAL BANK CDS - 1 - 3 MONTHS ARE NOT EQUAL");
                    status = "2";
                }
                brfValidationsRepo.save(brfValidation);
                break;
			case "67":
                List<Object[]> result42 = brfValidationsRepo.getCheckSrlNo67(convertDate);
                if (!result42.isEmpty()) {
                    brfValidation.setCur_status("Y");
                    brfValidation.setRemarks2("CENTRAL BANK CDS - 3 - 6 MONTHS ARE EQUAL");
                    status = "0";
                } else {
                    brfValidation.setCur_status("N");
                    brfValidation.setRemarks2("CENTRAL BANK CDS - 3 - 6 MONTHS ARE NOT EQUAL");
                    status = "2";
                }
                brfValidationsRepo.save(brfValidation);
                break;
			case "68":
                List<Object[]> result43 = brfValidationsRepo.getCheckSrlNo68(convertDate);
                if (!result43.isEmpty()) {
                    brfValidation.setCur_status("Y");
                    brfValidation.setRemarks2("CENTRAL BANK CDS - 6 - 12 MONTHS ARE EQUAL");
                    status = "0";
                } else {
                    brfValidation.setCur_status("N");
                    brfValidation.setRemarks2("CENTRAL BANK CDS - 6 - 12 MONTHS ARE NOT EQUAL");
                    status = "2";
                }
                brfValidationsRepo.save(brfValidation);
                break;
			case "69":
                List<Object[]> result44 = brfValidationsRepo.getCheckSrlNo69(convertDate);
                if (!result44.isEmpty()) {
                    brfValidation.setCur_status("Y");
                    brfValidation.setRemarks2("UAE FEDERAL AND EMIRATE GOVERNMENTS DEBT SECURITIES - 0 - 7 days ARE EQUAL");
                    status = "0";
                } else {
                    brfValidation.setCur_status("N");
                    brfValidation.setRemarks2("UAE FEDERAL AND EMIRATE GOVERNMENTS DEBT SECURITIES - 0 - 7 days ARE NOT EQUAL");
                    status = "2";
                }
                brfValidationsRepo.save(brfValidation);
                break;
			case "70":
                List<Object[]> result45 = brfValidationsRepo.getCheckSrlNo70(convertDate);
                if (!result45.isEmpty()) {
                    brfValidation.setCur_status("Y");
                    brfValidation.setRemarks2("UAE FEDERAL AND EMIRATE GOVERNMENTS DEBT SECURITIES - 8-14 days ARE EQUAL");
                    status = "0";
                } else {
                    brfValidation.setCur_status("N");
                    brfValidation.setRemarks2("UAE FEDERAL AND EMIRATE GOVERNMENTS DEBT SECURITIES - 8-14 days ARE NOT EQUAL");
                    status = "2";
                }
                brfValidationsRepo.save(brfValidation);
                break;
			case "71":
                List<Object[]> result46 = brfValidationsRepo.getCheckSrlNo71(convertDate);
                if (!result46.isEmpty()) {
                    brfValidation.setCur_status("Y");
                    brfValidation.setRemarks2("UAE FEDERAL AND EMIRATE GOVERNMENTS DEBT SECURITIES - 15 days - 1 month ARE EQUAL");
                    status = "0";
                } else {
                    brfValidation.setCur_status("N");
                    brfValidation.setRemarks2("UAE FEDERAL AND EMIRATE GOVERNMENTS DEBT SECURITIES - 15 days - 1 month ARE NOT EQUAL");
                    status = "2";
                }
                brfValidationsRepo.save(brfValidation);
                break;
			case "72":
                List<Object[]> result47 = brfValidationsRepo.getCheckSrlNo72(convertDate);
                if (!result47.isEmpty()) {
                    brfValidation.setCur_status("Y");
                    brfValidation.setRemarks2("UAE FEDERAL AND EMIRATE GOVERNMENTS DEBT SECURITIES - 1 - 3 months ARE EQUAL");
                    status = "0";
                } else {
                    brfValidation.setCur_status("N");
                    brfValidation.setRemarks2("UAE FEDERAL AND EMIRATE GOVERNMENTS DEBT SECURITIES - 1 - 3 months ARE NOT EQUAL");
                    status = "2";
                }
                brfValidationsRepo.save(brfValidation);
                break;
			case "73":
                List<Object[]> result48 = brfValidationsRepo.getCheckSrlNo73(convertDate);
                if (!result48.isEmpty()) {
                    brfValidation.setCur_status("Y");
                    brfValidation.setRemarks2("UAE FEDERAL AND EMIRATE GOVERNMENTS DEBT SECURITIES - 3 -  6 months ARE EQUAL");
                    status = "0";
                } else {
                    brfValidation.setCur_status("N");
                    brfValidation.setRemarks2("UAE FEDERAL AND EMIRATE GOVERNMENTS DEBT SECURITIES - 3 -  6 months ARE NOT EQUAL");
                    status = "2";
                }
                brfValidationsRepo.save(brfValidation);
                break;
			case "74":
                List<Object[]> result49 = brfValidationsRepo.getCheckSrlNo74(convertDate);
                if (!result49.isEmpty()) {
                    brfValidation.setCur_status("Y");
                    brfValidation.setRemarks2("UAE FEDERAL AND EMIRATE GOVERNMENTS DEBT SECURITIES - 6 -12 months ARE EQUAL");
                    status = "0";
                } else {
                    brfValidation.setCur_status("N");
                    brfValidation.setRemarks2("UAE FEDERAL AND EMIRATE GOVERNMENTS DEBT SECURITIES - 6 -12 months ARE NOT EQUAL");
                    status = "2";
                }
                brfValidationsRepo.save(brfValidation);
                break;
			case "75":
                List<Object[]> result50 = brfValidationsRepo.getCheckSrlNo75(convertDate);
                if (!result50.isEmpty()) {
                    brfValidation.setCur_status("Y");
                    brfValidation.setRemarks2("UAE FEDERAL AND EMIRATE GOVERNMENTS DEBT SECURITIES - 1 - 2 years ARE EQUAL");
                    status = "0";
                } else {
                    brfValidation.setCur_status("N");
                    brfValidation.setRemarks2("UAE FEDERAL AND EMIRATE GOVERNMENTS DEBT SECURITIES - 1 - 2 years ARE NOT EQUAL");
                    status = "2";
                }
                brfValidationsRepo.save(brfValidation);
                break;
			case "76":
                List<Object[]> result51 = brfValidationsRepo.getCheckSrlNo76(convertDate);
                if (!result51.isEmpty()) {
                    brfValidation.setCur_status("Y");
                    brfValidation.setRemarks2("PLACEMENTS/ LOANS WITH AND BALANCES DUE FROM RESIDENT BANKS - 0 - 7 days ARE EQUAL");
                    status = "0";
                } else {
                    brfValidation.setCur_status("N");
                    brfValidation.setRemarks2("PLACEMENTS/ LOANS WITH AND BALANCES DUE FROM RESIDENT BANKS - 0 - 7 days ARE NOT EQUAL");
                    status = "2";
                }
                brfValidationsRepo.save(brfValidation);
                break;
			case "77":
                List<Object[]> result52 = brfValidationsRepo.getCheckSrlNo77(convertDate);
                if (!result52.isEmpty()) {
                    brfValidation.setCur_status("Y");
                    brfValidation.setRemarks2("PLACEMENTS/ LOANS WITH AND BALANCES DUE FROM RESIDENT BANKS - 8-14 days ARE EQUAL");
                    status = "0";
                } else {
                    brfValidation.setCur_status("N");
                    brfValidation.setRemarks2("PLACEMENTS/ LOANS WITH AND BALANCES DUE FROM RESIDENT BANKS - 8-14 days ARE NOT EQUAL");
                    status = "2";
                }
                brfValidationsRepo.save(brfValidation);
                break;
			case "78":
                List<Object[]> result53 = brfValidationsRepo.getCheckSrlNo78(convertDate);
                if (!result53.isEmpty()) {
                    brfValidation.setCur_status("Y");
                    brfValidation.setRemarks2("PLACEMENTS/ LOANS WITH AND BALANCES DUE FROM RESIDENT BANKS - 15 days - 1 month ARE EQUAL");
                    status = "0";
                } else {
                    brfValidation.setCur_status("N");
                    brfValidation.setRemarks2("PLACEMENTS/ LOANS WITH AND BALANCES DUE FROM RESIDENT BANKS - 15 days - 1 month ARE NOT EQUAL");
                    status = "2";
                }
                brfValidationsRepo.save(brfValidation);
                break;
			case "79":
                List<Object[]> result54 = brfValidationsRepo.getCheckSrlNo79(convertDate);
                if (!result54.isEmpty()) {
                    brfValidation.setCur_status("Y");
                    brfValidation.setRemarks2("PLACEMENTS/ LOANS WITH AND BALANCES DUE FROM RESIDENT BANKS - 1 - 3 months ARE EQUAL");
                    status = "0";
                } else {
                    brfValidation.setCur_status("N");
                    brfValidation.setRemarks2("PLACEMENTS/ LOANS WITH AND BALANCES DUE FROM RESIDENT BANKS - 1 - 3 months ARE NOT EQUAL");
                    status = "2";
                }
                brfValidationsRepo.save(brfValidation);
                break;
			case "80":
                List<Object[]> result55 = brfValidationsRepo.getCheckSrlNo80(convertDate);
                if (!result55.isEmpty()) {
                    brfValidation.setCur_status("Y");
                    brfValidation.setRemarks2("PLACEMENTS/ LOANS WITH AND BALANCES DUE FROM RESIDENT BANKS - 3 -  6 months ARE EQUAL");
                    status = "0";
                } else {
                    brfValidation.setCur_status("N");
                    brfValidation.setRemarks2("PLACEMENTS/ LOANS WITH AND BALANCES DUE FROM RESIDENT BANKS - 3 -  6 months ARE NOT EQUAL");
                    status = "2";
                }
                brfValidationsRepo.save(brfValidation);
                break;
			case "81":
                List<Object[]> result56 = brfValidationsRepo.getCheckSrlNo81(convertDate);
                if (!result56.isEmpty()) {
                    brfValidation.setCur_status("Y");
                    brfValidation.setRemarks2("PLACEMENTS/ LOANS WITH AND BALANCES DUE FROM RESIDENT BANKS - 6 -12 months ARE EQUAL");
                    status = "0";
                } else {
                    brfValidation.setCur_status("N");
                    brfValidation.setRemarks2("PLACEMENTS/ LOANS WITH AND BALANCES DUE FROM RESIDENT BANKS - 6 -12 months ARE NOT EQUAL");
                    status = "2";
                }
                brfValidationsRepo.save(brfValidation);
                break;
			case "82":
                List<Object[]> result57 = brfValidationsRepo.getCheckSrlNo82(convertDate);
                if (!result57.isEmpty()) {
                    brfValidation.setCur_status("Y");
                    brfValidation.setRemarks2("PLACEMENTS/ LOANS WITH AND BALANCES DUE FROM OVERSEAS BANKS - 0 - 7 days ARE EQUAL");
                    status = "0";
                } else {
                    brfValidation.setCur_status("N");
                    brfValidation.setRemarks2("PLACEMENTS/ LOANS WITH AND BALANCES DUE FROM OVERSEAS BANKS - 0 - 7 days ARE NOT EQUAL");
                    status = "2";
                }
                brfValidationsRepo.save(brfValidation);
                break;
			case "83":
                List<Object[]> result58 = brfValidationsRepo.getCheckSrlNo83(convertDate);
                if (!result58.isEmpty()) {
                    brfValidation.setCur_status("Y");
                    brfValidation.setRemarks2("PLACEMENTS/ LOANS WITH AND BALANCES DUE FROM OVERSEAS BANKS - 8-14 days ARE EQUAL");
                    status = "0";
                } else {
                    brfValidation.setCur_status("N");
                    brfValidation.setRemarks2("PLACEMENTS/ LOANS WITH AND BALANCES DUE FROM OVERSEAS BANKS - 8-14 days ARE NOT EQUAL");
                    status = "2";
                }
                brfValidationsRepo.save(brfValidation);
                break;
			case "84":
                List<Object[]> result59 = brfValidationsRepo.getCheckSrlNo84(convertDate);
                if (!result59.isEmpty()) {
                    brfValidation.setCur_status("Y");
                    brfValidation.setRemarks2("PLACEMENTS/ LOANS WITH AND BALANCES DUE FROM OVERSEAS BANKS - 15 days - 1 month ARE EQUAL");
                    status = "0";
                } else {
                    brfValidation.setCur_status("N");
                    brfValidation.setRemarks2("PLACEMENTS/ LOANS WITH AND BALANCES DUE FROM OVERSEAS BANKS - 15 days - 1 month ARE NOT EQUAL");
                    status = "2";
                }
                brfValidationsRepo.save(brfValidation);
                break;
			case "85":
                List<Object[]> result60 = brfValidationsRepo.getCheckSrlNo85(convertDate);
                if (!result60.isEmpty()) {
                    brfValidation.setCur_status("Y");
                    brfValidation.setRemarks2("PLACEMENTS/ LOANS WITH AND BALANCES DUE FROM OVERSEAS BANKS - 1 - 3 months ARE EQUAL");
                    status = "0";
                } else {
                    brfValidation.setCur_status("N");
                    brfValidation.setRemarks2("PLACEMENTS/ LOANS WITH AND BALANCES DUE FROM OVERSEAS BANKS - 1 - 3 months ARE NOT EQUAL");
                    status = "2";
                }
                brfValidationsRepo.save(brfValidation);
                break;
			case "86":
                List<Object[]> result61 = brfValidationsRepo.getCheckSrlNo86(convertDate);
                if (!result61.isEmpty()) {
                    brfValidation.setCur_status("Y");
                    brfValidation.setRemarks2("PLACEMENTS/ LOANS WITH AND BALANCES DUE FROM OVERSEAS BANKS - 3 -  6 months ARE EQUAL");
                    status = "0";
                } else {
                    brfValidation.setCur_status("N");
                    brfValidation.setRemarks2("PLACEMENTS/ LOANS WITH AND BALANCES DUE FROM OVERSEAS BANKS - 3 -  6 months ARE NOT EQUAL");
                    status = "2";
                }
                brfValidationsRepo.save(brfValidation);
                break;
			case "87":
                List<Object[]> result62 = brfValidationsRepo.getCheckSrlNo87(convertDate);
                if (!result62.isEmpty()) {
                    brfValidation.setCur_status("Y");
                    brfValidation.setRemarks2("PLACEMENTS/ LOANS WITH AND BALANCES DUE FROM OVERSEAS BANKS - 6 -12 months ARE EQUAL");
                    status = "0";
                } else {
                    brfValidation.setCur_status("N");
                    brfValidation.setRemarks2("PLACEMENTS/ LOANS WITH AND BALANCES DUE FROM OVERSEAS BANKS - 6 -12 months ARE NOT EQUAL");
                    status = "2";
                }
                brfValidationsRepo.save(brfValidation);
                break;
			case "88":
                List<Object[]> result63 = brfValidationsRepo.getCheckSrlNo88(convertDate);
                if (!result63.isEmpty()) {
                    brfValidation.setCur_status("Y");
                    brfValidation.setRemarks2("PLACEMENTS/ LOANS WITH AND BALANCES DUE FROM OVERSEAS BANKS - 1 - 2 years ARE EQUAL");
                    status = "0";
                } else {
                    brfValidation.setCur_status("N");
                    brfValidation.setRemarks2("PLACEMENTS/ LOANS WITH AND BALANCES DUE FROM OVERSEAS BANKS - 1 - 2 years ARE NOT EQUAL");
                    status = "2";
                }
                brfValidationsRepo.save(brfValidation);
                break;
			case "89":
                List<Object[]> result64 = brfValidationsRepo.getCheckSrlNo89(convertDate);
                if (!result64.isEmpty()) {
                    brfValidation.setCur_status("Y");
                    brfValidation.setRemarks2("PLACEMENTS/ LOANS WITH AND BALANCES DUE FROM OVERSEAS BANKS - 2 - 3 years ARE EQUAL");
                    status = "0";
                } else {
                    brfValidation.setCur_status("N");
                    brfValidation.setRemarks2("PLACEMENTS/ LOANS WITH AND BALANCES DUE FROM OVERSEAS BANKS - 2 - 3 years ARE NOT EQUAL");
                    status = "2";
                }
                brfValidationsRepo.save(brfValidation);
                break;
			case "90":
                List<Object[]> result65 = brfValidationsRepo.getCheckSrlNo90(convertDate);
                if (!result65.isEmpty()) {
                    brfValidation.setCur_status("Y");
                    brfValidation.setRemarks2("FOREIGN SOVEREIGN DEBT (RATED AA- OR HIGHER) - 0 - 7 days ARE EQUAL");
                    status = "0";
                } else {
                    brfValidation.setCur_status("N");
                    brfValidation.setRemarks2("FOREIGN SOVEREIGN DEBT (RATED AA- OR HIGHER) - 0 - 7 days ARE NOT EQUAL");
                    status = "2";
                }
                brfValidationsRepo.save(brfValidation);
                break;
			case "91":
                List<Object[]> result66 = brfValidationsRepo.getCheckSrlNo91(convertDate);
                if (!result66.isEmpty()) {
                    brfValidation.setCur_status("Y");
                    brfValidation.setRemarks2("FOREIGN SOVEREIGN DEBT (RATED AA- OR HIGHER) - 8-14 days ARE EQUAL");
                    status = "0";
                } else {
                    brfValidation.setCur_status("N");
                    brfValidation.setRemarks2("FOREIGN SOVEREIGN DEBT (RATED AA- OR HIGHER) - 8-14 days ARE NOT EQUAL");
                    status = "2";
                }
                brfValidationsRepo.save(brfValidation);
                break;
			case "92":
                List<Object[]> result67 = brfValidationsRepo.getCheckSrlNo92(convertDate);
                if (!result67.isEmpty()) {
                    brfValidation.setCur_status("Y");
                    brfValidation.setRemarks2("FOREIGN SOVEREIGN DEBT (RATED AA- OR HIGHER) - 15 days - 1 month ARE EQUAL");
                    status = "0";
                } else {
                    brfValidation.setCur_status("N");
                    brfValidation.setRemarks2("FOREIGN SOVEREIGN DEBT (RATED AA- OR HIGHER) - 15 days - 1 month ARE NOT EQUAL");
                    status = "2";
                }
                brfValidationsRepo.save(brfValidation);
                break;
			case "93":
                List<Object[]> result68 = brfValidationsRepo.getCheckSrlNo93(convertDate);
                if (!result68.isEmpty()) {
                    brfValidation.setCur_status("Y");
                    brfValidation.setRemarks2("FOREIGN SOVEREIGN DEBT (RATED AA- OR HIGHER) - 1 - 3 months ARE EQUAL");
                    status = "0";
                } else {
                    brfValidation.setCur_status("N");
                    brfValidation.setRemarks2("FOREIGN SOVEREIGN DEBT (RATED AA- OR HIGHER) - 1 - 3 months ARE NOT EQUAL");
                    status = "2";
                }
                brfValidationsRepo.save(brfValidation);
                break;
			case "94":
                List<Object[]> result69 = brfValidationsRepo.getCheckSrlNo94(convertDate);
                if (!result69.isEmpty()) {
                    brfValidation.setCur_status("Y");
                    brfValidation.setRemarks2("FOREIGN SOVEREIGN DEBT (RATED AA- OR HIGHER) - 3 -  6 months ARE EQUAL");
                    status = "0";
                } else {
                    brfValidation.setCur_status("N");
                    brfValidation.setRemarks2("FOREIGN SOVEREIGN DEBT (RATED AA- OR HIGHER) - 3 -  6 months ARE NOT EQUAL");
                    status = "2";
                }
                brfValidationsRepo.save(brfValidation);
                break;
			case "95":
                List<Object[]> result70 = brfValidationsRepo.getCheckSrlNo95(convertDate);
                if (!result70.isEmpty()) {
                    brfValidation.setCur_status("Y");
                    brfValidation.setRemarks2("NON-UAE PUBLIC SECTOR ENTERPRISES DEBT/ SUKUKS - OVERDRAFT ARE EQUAL");
                    status = "0";
                } else {
                    brfValidation.setCur_status("N");
                    brfValidation.setRemarks2("NON-UAE PUBLIC SECTOR ENTERPRISES DEBT/ SUKUKS - OVERDRAFT ARE NOT EQUAL");
                    status = "2";
                }
                brfValidationsRepo.save(brfValidation);
                break;
			case "96":
                List<Object[]> result71 = brfValidationsRepo.getCheckSrlNo96(convertDate);
                if (!result71.isEmpty()) {
                    brfValidation.setCur_status("Y");
                    brfValidation.setRemarks2("NON-UAE PUBLIC SECTOR ENTERPRISES DEBT/ SUKUKS - NON-INTEREST RATE SENSITIVE ARE EQUAL");
                    status = "0";
                } else {
                    brfValidation.setCur_status("N");
                    brfValidation.setRemarks2("NON-UAE PUBLIC SECTOR ENTERPRISES DEBT/ SUKUKS - NON-INTEREST RATE SENSITIVE ARE NOT EQUAL");
                    status = "2";
                }
                brfValidationsRepo.save(brfValidation);
                break;
			case "97":
                List<Object[]> result72 = brfValidationsRepo.getCheckSrlNo97(convertDate);
                if (!result72.isEmpty()) {
                    brfValidation.setCur_status("Y");
                    brfValidation.setRemarks2("INVESTMENT IN EQUITIES - UNQUOTED - 0 - 7 days ARE EQUAL");
                    status = "0";
                } else {
                    brfValidation.setCur_status("N");
                    brfValidation.setRemarks2("INVESTMENT IN EQUITIES - UNQUOTED - 0 - 7 days ARE NOT EQUAL");
                    status = "2";
                }
                brfValidationsRepo.save(brfValidation);
                break;
			case "98":
                List<Object[]> result73 = brfValidationsRepo.getCheckSrlNo98(convertDate);
                if (!result73.isEmpty()) {
                    brfValidation.setCur_status("Y");
                    brfValidation.setRemarks2("INVESTMENT IN EQUITIES - UNQUOTED - NON-INTEREST RATE SENSITIVE ARE EQUAL");
                    status = "0";
                } else {
                    brfValidation.setCur_status("N");
                    brfValidation.setRemarks2("INVESTMENT IN EQUITIES - UNQUOTED - NON-INTEREST RATE SENSITIVE ARE NOT EQUAL");
                    status = "2";
                }
                brfValidationsRepo.save(brfValidation);
                break;
			case "99":
                List<Object[]> result74 = brfValidationsRepo.getCheckSrlNo99(convertDate);
                if (!result74.isEmpty()) {
                    brfValidation.setCur_status("Y");
                    brfValidation.setRemarks2("NET FIXED ASSETS ARE EQUAL");
                    status = "0";
                } else {
                    brfValidation.setCur_status("N");
                    brfValidation.setRemarks2("NET FIXED ASSETS ARE NOT EQUAL");
                    status = "2";
                }
                brfValidationsRepo.save(brfValidation);
                break;
			case "100":
                List<Object[]> result75 = brfValidationsRepo.getCheckSrlNo100(convertDate);
                if (!result75.isEmpty()) {
                    brfValidation.setCur_status("Y");
                    brfValidation.setRemarks2("GOVERNMENT AND PUBLIC SECTOR ARE EQUAL");
                    status = "0";
                } else {
                    brfValidation.setCur_status("N");
                    brfValidation.setRemarks2("GOVERNMENT AND PUBLIC SECTOR ARE NOT EQUAL");
                    status = "2";
                }
                brfValidationsRepo.save(brfValidation);
                break;
			case "101":
                List<Object[]> result76 = brfValidationsRepo.getCheckSrlNo101(convertDate);
                if (!result76.isEmpty()) {
                    brfValidation.setCur_status("Y");
                    brfValidation.setRemarks2("OTHER ASSETS1 - Overdraft ARE EQUAL");
                    status = "0";
                } else {
                    brfValidation.setCur_status("N");
                    brfValidation.setRemarks2("OTHER ASSETS1 - Overdraft ARE NOT EQUAL");
                    status = "2";
                }
                brfValidationsRepo.save(brfValidation);
                break;
			case "102":
                List<Object[]> result77 = brfValidationsRepo.getCheckSrlNo102(convertDate);
                if (!result77.isEmpty()) {
                    brfValidation.setCur_status("Y");
                    brfValidation.setRemarks2("OTHER ASSETS1 - 0 - 7 days ARE EQUAL");
                    status = "0";
                } else {
                    brfValidation.setCur_status("N");
                    brfValidation.setRemarks2("OTHER ASSETS1 - 0 - 7 days ARE NOT EQUAL");
                    status = "2";
                }
                brfValidationsRepo.save(brfValidation);
                break;
			case "103":
                List<Object[]> result78 = brfValidationsRepo.getCheckSrlNo103(convertDate);
                if (!result78.isEmpty()) {
                    brfValidation.setCur_status("Y");
                    brfValidation.setRemarks2("OTHER ASSETS1 - 8-14 days ARE EQUAL");
                    status = "0";
                } else {
                    brfValidation.setCur_status("N");
                    brfValidation.setRemarks2("OTHER ASSETS1 - 8-14 days ARE NOT EQUAL");
                    status = "2";
                }
                brfValidationsRepo.save(brfValidation);
                break;
			case "104":
                List<Object[]> result79 = brfValidationsRepo.getCheckSrlNo104(convertDate);
                if (!result79.isEmpty()) {
                    brfValidation.setCur_status("Y");
                    brfValidation.setRemarks2("OTHER ASSETS1 - 15 days - 1 month ARE EQUAL");
                    status = "0";
                } else {
                    brfValidation.setCur_status("N");
                    brfValidation.setRemarks2("OTHER ASSETS1 - 15 days - 1 month ARE NOT EQUAL");
                    status = "2";
                }
                brfValidationsRepo.save(brfValidation);
                break;
			case "105":
                List<Object[]> result80 = brfValidationsRepo.getCheckSrlNo105(convertDate);
                if (!result80.isEmpty()) {
                    brfValidation.setCur_status("Y");
                    brfValidation.setRemarks2("OTHER ASSETS1 - 1 - 3 months ARE EQUAL");
                    status = "0";
                } else {
                    brfValidation.setCur_status("N");
                    brfValidation.setRemarks2("OTHER ASSETS1 - 1 - 3 months ARE NOT EQUAL");
                    status = "2";
                }
                brfValidationsRepo.save(brfValidation);
                break;
			case "106":
                List<Object[]> result81 = brfValidationsRepo.getCheckSrlNo106(convertDate);
                if (!result81.isEmpty()) {
                    brfValidation.setCur_status("Y");
                    brfValidation.setRemarks2("OTHER ASSETS1 - 3 -  6 months ARE EQUAL");
                    status = "0";
                } else {
                    brfValidation.setCur_status("N");
                    brfValidation.setRemarks2("OTHER ASSETS1 - 3 -  6 months ARE NOT EQUAL");
                    status = "2";
                }
                brfValidationsRepo.save(brfValidation);
                break;
			case "107":
                List<Object[]> result82 = brfValidationsRepo.getCheckSrlNo107(convertDate);
                if (!result82.isEmpty()) {
                    brfValidation.setCur_status("Y");
                    brfValidation.setRemarks2("OTHER ASSETS1 - 6 -12 months ARE EQUAL");
                    status = "0";
                } else {
                    brfValidation.setCur_status("N");
                    brfValidation.setRemarks2("OTHER ASSETS1 - 6 -12 months ARE NOT EQUAL");
                    status = "2";
                }
                brfValidationsRepo.save(brfValidation);
                break;
			case "108":
                List<Object[]> result83 = brfValidationsRepo.getCheckSrlNo108(convertDate);
                if (!result83.isEmpty()) {
                    brfValidation.setCur_status("Y");
                    brfValidation.setRemarks2("OTHER ASSETS1 - 1 - 2 years ARE EQUAL");
                    status = "0";
                } else {
                    brfValidation.setCur_status("N");
                    brfValidation.setRemarks2("OTHER ASSETS1 - 1 - 2 years ARE NOT EQUAL");
                    status = "2";
                }
                brfValidationsRepo.save(brfValidation);
                break;
			case "109":
                List<Object[]> result84 = brfValidationsRepo.getCheckSrlNo109(convertDate);
                if (!result84.isEmpty()) {
                    brfValidation.setCur_status("Y");
                    brfValidation.setRemarks2("OTHER ASSETS1 - 2 - 3 years ARE EQUAL");
                    status = "0";
                } else {
                    brfValidation.setCur_status("N");
                    brfValidation.setRemarks2("OTHER ASSETS1 - 2 - 3 years ARE NOT EQUAL");
                    status = "2";
                }
                brfValidationsRepo.save(brfValidation);
                break;
			case "110":
                List<Object[]> result85 = brfValidationsRepo.getCheckSrlNo110(convertDate);
                if (!result85.isEmpty()) {
                    brfValidation.setCur_status("Y");
                    brfValidation.setRemarks2("DEPOSITS FROM AND BALANCES DUE TO RESIDENT BANKS - 0 - 7 days ARE EQUAL");
                    status = "0";
                } else {
                    brfValidation.setCur_status("N");
                    brfValidation.setRemarks2("DEPOSITS FROM AND BALANCES DUE TO RESIDENT BANKS - 0 - 7 days ARE NOT EQUAL");
                    status = "2";
                }
                brfValidationsRepo.save(brfValidation);
                break;
			case "111":
                List<Object[]> result86 = brfValidationsRepo.getCheckSrlNo111(convertDate);
                if (!result86.isEmpty()) {
                    brfValidation.setCur_status("Y");
                    brfValidation.setRemarks2("DEPOSITS FROM AND BALANCES DUE TO RESIDENT BANKS - 8-14 days ARE EQUAL");
                    status = "0";
                } else {
                    brfValidation.setCur_status("N");
                    brfValidation.setRemarks2("DEPOSITS FROM AND BALANCES DUE TO RESIDENT BANKS - 8-14 days ARE NOT EQUAL");
                    status = "2";
                }
                brfValidationsRepo.save(brfValidation);
                break;
			case "112":
                List<Object[]> result87 = brfValidationsRepo.getCheckSrlNo112(convertDate);
                if (!result87.isEmpty()) {
                    brfValidation.setCur_status("Y");
                    brfValidation.setRemarks2("DEPOSITS FROM AND BALANCES DUE TO RESIDENT BANKS - 15 days - 1 month ARE EQUAL");
                    status = "0";
                } else {
                    brfValidation.setCur_status("N");
                    brfValidation.setRemarks2("DEPOSITS FROM AND BALANCES DUE TO RESIDENT BANKS - 15 days - 1 month ARE NOT EQUAL");
                    status = "2";
                }
                brfValidationsRepo.save(brfValidation);
                break;
			case "113":
                List<Object[]> result88 = brfValidationsRepo.getCheckSrlNo113(convertDate);
                if (!result88.isEmpty()) {
                    brfValidation.setCur_status("Y");
                    brfValidation.setRemarks2("DEPOSITS FROM AND BALANCES DUE TO RESIDENT BANKS - 1 - 3 months ARE EQUAL");
                    status = "0";
                } else {
                    brfValidation.setCur_status("N");
                    brfValidation.setRemarks2("DEPOSITS FROM AND BALANCES DUE TO RESIDENT BANKS - 1 - 3 months ARE NOT EQUAL");
                    status = "2";
                }
                brfValidationsRepo.save(brfValidation);
                break;
			case "114":
                List<Object[]> result89 = brfValidationsRepo.getCheckSrlNo114(convertDate);
                if (!result89.isEmpty()) {
                    brfValidation.setCur_status("Y");
                    brfValidation.setRemarks2("DEPOSITS FROM AND BALANCES DUE TO RESIDENT BANKS - 3 -  6 months ARE EQUAL");
                    status = "0";
                } else {
                    brfValidation.setCur_status("N");
                    brfValidation.setRemarks2("DEPOSITS FROM AND BALANCES DUE TO RESIDENT BANKS - 3 -  6 months ARE NOT EQUAL");
                    status = "2";
                }
                brfValidationsRepo.save(brfValidation);
                break;
			case "115":
                List<Object[]> result90 = brfValidationsRepo.getCheckSrlNo115(convertDate);
                if (!result90.isEmpty()) {
                    brfValidation.setCur_status("Y");
                    brfValidation.setRemarks2("DEPOSITS FROM AND BALANCES DUE TO RESIDENT BANKS - 6 -12 months ARE EQUAL");
                    status = "0";
                } else {
                    brfValidation.setCur_status("N");
                    brfValidation.setRemarks2("DEPOSITS FROM AND BALANCES DUE TO RESIDENT BANKS - 6 -12 months ARE NOT EQUAL");
                    status = "2";
                }
                brfValidationsRepo.save(brfValidation);
                break;
			case "116":
                List<Object[]> result91 = brfValidationsRepo.getCheckSrlNo116(convertDate);
                if (!result91.isEmpty()) {
                    brfValidation.setCur_status("Y");
                    brfValidation.setRemarks2("DEPOSITS FROM AND BALANCES DUE TO RESIDENT BANKS - 1 - 2 years ARE EQUAL");
                    status = "0";
                } else {
                    brfValidation.setCur_status("N");
                    brfValidation.setRemarks2("DEPOSITS FROM AND BALANCES DUE TO RESIDENT BANKS - 1 - 2 years ARE NOT EQUAL");
                    status = "2";
                }
                brfValidationsRepo.save(brfValidation);
                break;
			case "117":
                List<Object[]> result92 = brfValidationsRepo.getCheckSrlNo117(convertDate);
                if (!result92.isEmpty()) {
                    brfValidation.setCur_status("Y");
                    brfValidation.setRemarks2("DEPOSITS FROM AND BALANCES DUE TO RESIDENT BANKS - 2 - 3 years ARE EQUAL");
                    status = "0";
                } else {
                    brfValidation.setCur_status("N");
                    brfValidation.setRemarks2("DEPOSITS FROM AND BALANCES DUE TO RESIDENT BANKS - 2 - 3 years ARE NOT EQUAL");
                    status = "2";
                }
                brfValidationsRepo.save(brfValidation);
                break;
			case "118":
                List<Object[]> result93 = brfValidationsRepo.getCheckSrlNo118(convertDate);
                if (!result93.isEmpty()) {
                    brfValidation.setCur_status("Y");
                    brfValidation.setRemarks2("INTERBANK CDS ISSUED - 0 - 7 days ARE EQUAL");
                    status = "0";
                } else {
                    brfValidation.setCur_status("N");
                    brfValidation.setRemarks2("INTERBANK CDS ISSUED - 0 - 7 days ARE NOT EQUAL");
                    status = "2";
                }
                brfValidationsRepo.save(brfValidation);
                break;
			case "119":
                List<Object[]> result94 = brfValidationsRepo.getCheckSrlNo119(convertDate);
                if (!result94.isEmpty()) {
                    brfValidation.setCur_status("Y");
                    brfValidation.setRemarks2("INTERBANK CDS ISSUED - 8-14 days ARE EQUAL");
                    status = "0";
                } else {
                    brfValidation.setCur_status("N");
                    brfValidation.setRemarks2("INTERBANK CDS ISSUED - 8-14 days ARE NOT EQUAL");
                    status = "2";
                }
                brfValidationsRepo.save(brfValidation);
                break;
			case "120":
                List<Object[]> result95 = brfValidationsRepo.getCheckSrlNo120(convertDate);
                if (!result95.isEmpty()) {
                    brfValidation.setCur_status("Y");
                    brfValidation.setRemarks2("INTERBANK CDS ISSUED - 15 days - 1 month ARE EQUAL");
                    status = "0";
                } else {
                    brfValidation.setCur_status("N");
                    brfValidation.setRemarks2("INTERBANK CDS ISSUED - 15 days - 1 month ARE NOT EQUAL");
                    status = "2";
                }
                brfValidationsRepo.save(brfValidation);
                break;
			case "121":
                List<Object[]> result96 = brfValidationsRepo.getCheckSrlNo121(convertDate);
                if (!result96.isEmpty()) {
                    brfValidation.setCur_status("Y");
                    brfValidation.setRemarks2("INTERBANK CDS ISSUED - 1 - 3 months ARE EQUAL");
                    status = "0";
                } else {
                    brfValidation.setCur_status("N");
                    brfValidation.setRemarks2("INTERBANK CDS ISSUED - 1 - 3 months ARE NOT EQUAL");
                    status = "2";
                }
                brfValidationsRepo.save(brfValidation);
                break;
			case "122":
                List<Object[]> result97 = brfValidationsRepo.getCheckSrlNo122(convertDate);
                if (!result97.isEmpty()) {
                    brfValidation.setCur_status("Y");
                    brfValidation.setRemarks2("INTERBANK CDS ISSUED - 3 -  6 months ARE EQUAL");
                    status = "0";
                } else {
                    brfValidation.setCur_status("N");
                    brfValidation.setRemarks2("INTERBANK CDS ISSUED - 3 -  6 months ARE NOT EQUAL");
                    status = "2";
                }
                brfValidationsRepo.save(brfValidation);
                break;
			case "123":
                List<Object[]> result98 = brfValidationsRepo.getCheckSrlNo123(convertDate);
                if (!result98.isEmpty()) {
                    brfValidation.setCur_status("Y");
                    brfValidation.setRemarks2("INTERBANK CDS ISSUED - 6 -12 months ARE EQUAL");
                    status = "0";
                } else {
                    brfValidation.setCur_status("N");
                    brfValidation.setRemarks2("INTERBANK CDS ISSUED - 6 -12 months ARE NOT EQUAL");
                    status = "2";
                }
                brfValidationsRepo.save(brfValidation);
                break;
			case "124":
                List<Object[]> result99 = brfValidationsRepo.getCheckSrlNo124(convertDate);
                if (!result99.isEmpty()) {
                    brfValidation.setCur_status("Y");
                    brfValidation.setRemarks2("INTERBANK CDS ISSUED - 1 - 2 years ARE EQUAL");
                    status = "0";
                } else {
                    brfValidation.setCur_status("N");
                    brfValidation.setRemarks2("INTERBANK CDS ISSUED - 1 - 2 years ARE NOT EQUAL");
                    status = "2";
                }
                brfValidationsRepo.save(brfValidation);
                break;
			case "125":
                List<Object[]> result100 = brfValidationsRepo.getCheckSrlNo125(convertDate);
                if (!result100.isEmpty()) {
                    brfValidation.setCur_status("Y");
                    brfValidation.setRemarks2("INTERBANK CDS ISSUED - 2 - 3 years ARE EQUAL");
                    status = "0";
                } else {
                    brfValidation.setCur_status("N");
                    brfValidation.setRemarks2("INTERBANK CDS ISSUED - 2 - 3 years ARE NOT EQUAL");
                    status = "2";
                }
                brfValidationsRepo.save(brfValidation);
                break;
			case "126":
                List<Object[]> result101 = brfValidationsRepo.getCheckSrlNo126(convertDate);
                if (!result101.isEmpty()) {
                    brfValidation.setCur_status("Y");
                    brfValidation.setRemarks2("DEPOSITS FROM AND BALANCES DUE TO OVERSEAS BANKS - 0 - 7 days ARE EQUAL");
                    status = "0";
                } else {
                    brfValidation.setCur_status("N");
                    brfValidation.setRemarks2("DEPOSITS FROM AND BALANCES DUE TO OVERSEAS BANKS - 0 - 7 days ARE NOT EQUAL");
                    status = "2";
                }
                brfValidationsRepo.save(brfValidation);
                break;
			case "127":
                List<Object[]> result102 = brfValidationsRepo.getCheckSrlNo127(convertDate);
                if (!result102.isEmpty()) {
                    brfValidation.setCur_status("Y");
                    brfValidation.setRemarks2("DEPOSITS FROM AND BALANCES DUE TO OVERSEAS BANKS - 8-14 days ARE EQUAL");
                    status = "0";
                } else {
                    brfValidation.setCur_status("N");
                    brfValidation.setRemarks2("DEPOSITS FROM AND BALANCES DUE TO OVERSEAS BANKS - 8-14 days ARE NOT EQUAL");
                    status = "2";
                }
                brfValidationsRepo.save(brfValidation);
                break;
			case "128":
                List<Object[]> result103 = brfValidationsRepo.getCheckSrlNo128(convertDate);
                if (!result103.isEmpty()) {
                    brfValidation.setCur_status("Y");
                    brfValidation.setRemarks2("DEPOSITS FROM AND BALANCES DUE TO OVERSEAS BANKS - 15 days - 1 month ARE EQUAL");
                    status = "0";
                } else {
                    brfValidation.setCur_status("N");
                    brfValidation.setRemarks2("DEPOSITS FROM AND BALANCES DUE TO OVERSEAS BANKS - 15 days - 1 month ARE NOT EQUAL");
                    status = "2";
                }
                brfValidationsRepo.save(brfValidation);
                break;
			case "129":
                List<Object[]> result104 = brfValidationsRepo.getCheckSrlNo129(convertDate);
                if (!result104.isEmpty()) {
                    brfValidation.setCur_status("Y");
                    brfValidation.setRemarks2("DEPOSITS FROM AND BALANCES DUE TO OVERSEAS BANKS - 1 - 3 months ARE EQUAL");
                    status = "0";
                } else {
                    brfValidation.setCur_status("N");
                    brfValidation.setRemarks2("DEPOSITS FROM AND BALANCES DUE TO OVERSEAS BANKS - 1 - 3 months ARE NOT EQUAL");
                    status = "2";
                }
                brfValidationsRepo.save(brfValidation);
                break;
			case "130":
                List<Object[]> result105 = brfValidationsRepo.getCheckSrlNo130(convertDate);
                if (!result105.isEmpty()) {
                    brfValidation.setCur_status("Y");
                    brfValidation.setRemarks2("DEPOSITS FROM AND BALANCES DUE TO OVERSEAS BANKS - 3 -  6 months ARE EQUAL");
                    status = "0";
                } else {
                    brfValidation.setCur_status("N");
                    brfValidation.setRemarks2("DEPOSITS FROM AND BALANCES DUE TO OVERSEAS BANKS - 3 -  6 months ARE NOT EQUAL");
                    status = "2";
                }
                brfValidationsRepo.save(brfValidation);
                break;
			case "131":
                List<Object[]> result106 = brfValidationsRepo.getCheckSrlNo131(convertDate);
                if (!result106.isEmpty()) {
                    brfValidation.setCur_status("Y");
                    brfValidation.setRemarks2("DEPOSITS FROM AND BALANCES DUE TO OVERSEAS BANKS - 6 -12 months ARE EQUAL");
                    status = "0";
                } else {
                    brfValidation.setCur_status("N");
                    brfValidation.setRemarks2("DEPOSITS FROM AND BALANCES DUE TO OVERSEAS BANKS - 6 -12 months ARE NOT EQUAL");
                    status = "2";
                }
                brfValidationsRepo.save(brfValidation);
                break;
			case "132":
                List<Object[]> result107 = brfValidationsRepo.getCheckSrlNo132(convertDate);
                if (!result107.isEmpty()) {
                    brfValidation.setCur_status("Y");
                    brfValidation.setRemarks2("DEPOSITS FROM AND BALANCES DUE TO OVERSEAS BANKS - 1 - 2 years ARE EQUAL");
                    status = "0";
                } else {
                    brfValidation.setCur_status("N");
                    brfValidation.setRemarks2("DEPOSITS FROM AND BALANCES DUE TO OVERSEAS BANKS - 1 - 2 years ARE NOT EQUAL");
                    status = "2";
                }
                brfValidationsRepo.save(brfValidation);
                break;
			case "133":
                List<Object[]> result108 = brfValidationsRepo.getCheckSrlNo133(convertDate);
                if (!result108.isEmpty()) {
                    brfValidation.setCur_status("Y");
                    brfValidation.setRemarks2("DEPOSITS FROM AND BALANCES DUE TO OVERSEAS BANKS - 2 - 3 years ARE EQUAL");
                    status = "0";
                } else {
                    brfValidation.setCur_status("N");
                    brfValidation.setRemarks2("DEPOSITS FROM AND BALANCES DUE TO OVERSEAS BANKS - 2 - 3 years ARE NOT EQUAL");
                    status = "2";
                }
                brfValidationsRepo.save(brfValidation);
                break;
			case "134":
                List<Object[]> result109 = brfValidationsRepo.getCheckSrlNo134(convertDate);
                if (!result109.isEmpty()) {
                    brfValidation.setCur_status("Y");
                    brfValidation.setRemarks2("REFINANCING UNDER GOVT. HOUSING SCHEME - 0 - 7 days ARE EQUAL");
                    status = "0";
                } else {
                    brfValidation.setCur_status("N");
                    brfValidation.setRemarks2("REFINANCING UNDER GOVT. HOUSING SCHEME - 0 - 7 days ARE NOT EQUAL");
                    status = "2";
                }
                brfValidationsRepo.save(brfValidation);
                break;
			case "135":
                List<Object[]> result110 = brfValidationsRepo.getCheckSrlNo135(convertDate);
                if (!result110.isEmpty()) {
                    brfValidation.setCur_status("Y");
                    brfValidation.setRemarks2("REFINANCING UNDER GOVT. HOUSING SCHEME - 8-14 days ARE EQUAL");
                    status = "0";
                } else {
                    brfValidation.setCur_status("N");
                    brfValidation.setRemarks2("REFINANCING UNDER GOVT. HOUSING SCHEME - 8-14 days ARE NOT EQUAL");
                    status = "2";
                }
                brfValidationsRepo.save(brfValidation);
                break;
			case "136":
                List<Object[]> result111 = brfValidationsRepo.getCheckSrlNo136(convertDate);
                if (!result111.isEmpty()) {
                    brfValidation.setCur_status("Y");
                    brfValidation.setRemarks2("REFINANCING UNDER GOVT. HOUSING SCHEME - 15 days - 1 month ARE EQUAL");
                    status = "0";
                } else {
                    brfValidation.setCur_status("N");
                    brfValidation.setRemarks2("REFINANCING UNDER GOVT. HOUSING SCHEME - 15 days - 1 month ARE NOT EQUAL");
                    status = "2";
                }
                brfValidationsRepo.save(brfValidation);
                break;
			case "137":
                List<Object[]> result112 = brfValidationsRepo.getCheckSrlNo137(convertDate);
                if (!result112.isEmpty()) {
                    brfValidation.setCur_status("Y");
                    brfValidation.setRemarks2("REFINANCING UNDER GOVT. HOUSING SCHEME - 1 - 3 months ARE EQUAL");
                    status = "0";
                } else {
                    brfValidation.setCur_status("N");
                    brfValidation.setRemarks2("REFINANCING UNDER GOVT. HOUSING SCHEME - 1 - 3 months ARE NOT EQUAL");
                    status = "2";
                }
                brfValidationsRepo.save(brfValidation);
                break;
			case "138":
                List<Object[]> result113 = brfValidationsRepo.getCheckSrlNo138(convertDate);
                if (!result113.isEmpty()) {
                    brfValidation.setCur_status("Y");
                    brfValidation.setRemarks2("REFINANCING UNDER GOVT. HOUSING SCHEME - 3 -  6 months ARE EQUAL");
                    status = "0";
                } else {
                    brfValidation.setCur_status("N");
                    brfValidation.setRemarks2("REFINANCING UNDER GOVT. HOUSING SCHEME - 3 -  6 months ARE NOT EQUAL");
                    status = "2";
                }
                brfValidationsRepo.save(brfValidation);
                break;
			case "139":
                List<Object[]> result114 = brfValidationsRepo.getCheckSrlNo139(convertDate);
                if (!result114.isEmpty()) {
                    brfValidation.setCur_status("Y");
                    brfValidation.setRemarks2("REFINANCING UNDER GOVT. HOUSING SCHEME - 6 -12 months ARE EQUAL");
                    status = "0";
                } else {
                    brfValidation.setCur_status("N");
                    brfValidation.setRemarks2("REFINANCING UNDER GOVT. HOUSING SCHEME - 6 -12 months ARE NOT EQUAL");
                    status = "2";
                }
                brfValidationsRepo.save(brfValidation);
                break;
			case "140":
                List<Object[]> result115 = brfValidationsRepo.getCheckSrlNo140(convertDate);
                if (!result115.isEmpty()) {
                    brfValidation.setCur_status("Y");
                    brfValidation.setRemarks2("REFINANCING UNDER GOVT. HOUSING SCHEME - 1 - 2 years ARE EQUAL");
                    status = "0";
                } else {
                    brfValidation.setCur_status("N");
                    brfValidation.setRemarks2("REFINANCING UNDER GOVT. HOUSING SCHEME - 1 - 2 years ARE NOT EQUAL");
                    status = "2";
                }
                brfValidationsRepo.save(brfValidation);
                break;
			case "141":
                List<Object[]> result116 = brfValidationsRepo.getCheckSrlNo141(convertDate);
                if (!result116.isEmpty()) {
                    brfValidation.setCur_status("Y");
                    brfValidation.setRemarks2("REFINANCING UNDER GOVT. HOUSING SCHEME - 2 - 3 years ARE EQUAL");
                    status = "0";
                } else {
                    brfValidation.setCur_status("N");
                    brfValidation.setRemarks2("REFINANCING UNDER GOVT. HOUSING SCHEME - 2 - 3 years ARE NOT EQUAL");
                    status = "2";
                }
                brfValidationsRepo.save(brfValidation);
                break;
			case "142":
                List<Object[]> result117 = brfValidationsRepo.getCheckSrlNo142(convertDate);
                if (!result117.isEmpty()) {
                    brfValidation.setCur_status("Y");
                    brfValidation.setRemarks2("DUE TO CENTRAL BANK - 0 - 7 days ARE EQUAL");
                    status = "0";
                } else {
                    brfValidation.setCur_status("N");
                    brfValidation.setRemarks2("DUE TO CENTRAL BANK - 0 - 7 days ARE NOT EQUAL");
                    status = "2";
                }
                brfValidationsRepo.save(brfValidation);
                break;
			case "143":
                List<Object[]> result118 = brfValidationsRepo.getCheckSrlNo143(convertDate);
                if (!result118.isEmpty()) {
                    brfValidation.setCur_status("Y");
                    brfValidation.setRemarks2("DUE TO CENTRAL BANK - 8-14 days ARE EQUAL");
                    status = "0";
                } else {
                    brfValidation.setCur_status("N");
                    brfValidation.setRemarks2("DUE TO CENTRAL BANK - 8-14 days ARE NOT EQUAL");
                    status = "2";
                }
                brfValidationsRepo.save(brfValidation);
                break;
			case "144":
                List<Object[]> result119 = brfValidationsRepo.getCheckSrlNo144(convertDate);
                if (!result119.isEmpty()) {
                    brfValidation.setCur_status("Y");
                    brfValidation.setRemarks2("DUE TO CENTRAL BANK - 15 days - 1 month ARE EQUAL");
                    status = "0";
                } else {
                    brfValidation.setCur_status("N");
                    brfValidation.setRemarks2("DUE TO CENTRAL BANK - 15 days - 1 month ARE NOT EQUAL");
                    status = "2";
                }
                brfValidationsRepo.save(brfValidation);
                break;
			case "145":
                List<Object[]> result120 = brfValidationsRepo.getCheckSrlNo145(convertDate);
                if (!result120.isEmpty()) {
                    brfValidation.setCur_status("Y");
                    brfValidation.setRemarks2("DUE TO CENTRAL BANK - 1 - 3 months ARE EQUAL");
                    status = "0";
                } else {
                    brfValidation.setCur_status("N");
                    brfValidation.setRemarks2("DUE TO CENTRAL BANK - 1 - 3 months ARE NOT EQUAL");
                    status = "2";
                }
                brfValidationsRepo.save(brfValidation);
                break;
			case "146":
                List<Object[]> result121 = brfValidationsRepo.getCheckSrlNo146(convertDate);
                if (!result121.isEmpty()) {
                    brfValidation.setCur_status("Y");
                    brfValidation.setRemarks2("DUE TO CENTRAL BANK - 3 -  6 months ARE EQUAL");
                    status = "0";
                } else {
                    brfValidation.setCur_status("N");
                    brfValidation.setRemarks2("DUE TO CENTRAL BANK - 3 -  6 months ARE NOT EQUAL");
                    status = "2";
                }
                brfValidationsRepo.save(brfValidation);
                break;
			case "147":
                List<Object[]> result122 = brfValidationsRepo.getCheckSrlNo147(convertDate);
                if (!result122.isEmpty()) {
                    brfValidation.setCur_status("Y");
                    brfValidation.setRemarks2("DUE TO CENTRAL BANK - 6 -12 months ARE EQUAL");
                    status = "0";
                } else {
                    brfValidation.setCur_status("N");
                    brfValidation.setRemarks2("DUE TO CENTRAL BANK - 6 -12 months ARE NOT EQUAL");
                    status = "2";
                }
                brfValidationsRepo.save(brfValidation);
                break;
			case "148":
                List<Object[]> result123 = brfValidationsRepo.getCheckSrlNo148(convertDate);
                if (!result123.isEmpty()) {
                    brfValidation.setCur_status("Y");
                    brfValidation.setRemarks2("DUE TO CENTRAL BANK - 1 - 2 years ARE EQUAL");
                    status = "0";
                } else {
                    brfValidation.setCur_status("N");
                    brfValidation.setRemarks2("DUE TO CENTRAL BANK - 1 - 2 years ARE NOT EQUAL");
                    status = "2";
                }
                brfValidationsRepo.save(brfValidation);
                break;
			case "149":
                List<Object[]> result124 = brfValidationsRepo.getCheckSrlNo149(convertDate);
                if (!result124.isEmpty()) {
                    brfValidation.setCur_status("Y");
                    brfValidation.setRemarks2("DUE TO CENTRAL BANK - 2 - 3 years ARE EQUAL");
                    status = "0";
                } else {
                    brfValidation.setCur_status("N");
                    brfValidation.setRemarks2("DUE TO CENTRAL BANK - 2 - 3 years ARE NOT EQUAL");
                    status = "2";
                }
                brfValidationsRepo.save(brfValidation);
                break;
			case "150":
                List<Object[]> result125 = brfValidationsRepo.getCheckSrlNo150(convertDate);
                if (!result125.isEmpty()) {
                    brfValidation.setCur_status("Y");
                    brfValidation.setRemarks2("GOVERNMENT AND PUBLIC SECTOR - 8-14 days ARE EQUAL");
                    status = "0";
                } else {
                    brfValidation.setCur_status("N");
                    brfValidation.setRemarks2("GOVERNMENT AND PUBLIC SECTOR - 8-14 days ARE NOT EQUAL");
                    status = "2";
                }
                brfValidationsRepo.save(brfValidation);
                break;
			case "151":
                List<Object[]> result126 = brfValidationsRepo.getCheckSrlNo151(convertDate);
                if (!result126.isEmpty()) {
                    brfValidation.setCur_status("Y");
                    brfValidation.setRemarks2("GOVERNMENT AND PUBLIC SECTOR - 15 days - 1 month ARE EQUAL");
                    status = "0";
                } else {
                    brfValidation.setCur_status("N");
                    brfValidation.setRemarks2("GOVERNMENT AND PUBLIC SECTOR - 15 days - 1 month ARE NOT EQUAL");
                    status = "2";
                }
                brfValidationsRepo.save(brfValidation);
                break;
			case "152":
                List<Object[]> result127 = brfValidationsRepo.getCheckSrlNo152(convertDate);
                if (!result127.isEmpty()) {
                    brfValidation.setCur_status("Y");
                    brfValidation.setRemarks2("GOVERNMENT AND PUBLIC SECTOR - 1 - 3 months ARE EQUAL");
                    status = "0";
                } else {
                    brfValidation.setCur_status("N");
                    brfValidation.setRemarks2("GOVERNMENT AND PUBLIC SECTOR - 1 - 3 months ARE NOT EQUAL");
                    status = "2";
                }
                brfValidationsRepo.save(brfValidation);
                break;
			case "153":
                List<Object[]> result128 = brfValidationsRepo.getCheckSrlNo153(convertDate);
                if (!result128.isEmpty()) {
                    brfValidation.setCur_status("Y");
                    brfValidation.setRemarks2("GOVERNMENT AND PUBLIC SECTOR - 3 -  6 months ARE EQUAL");
                    status = "0";
                } else {
                    brfValidation.setCur_status("N");
                    brfValidation.setRemarks2("GOVERNMENT AND PUBLIC SECTOR - 3 -  6 months ARE NOT EQUAL");
                    status = "2";
                }
                brfValidationsRepo.save(brfValidation);
                break;
			case "154":
                List<Object[]> result129 = brfValidationsRepo.getCheckSrlNo154(convertDate);
                if (!result129.isEmpty()) {
                    brfValidation.setCur_status("Y");
                    brfValidation.setRemarks2("GOVERNMENT AND PUBLIC SECTOR - 6 -12 months ARE EQUAL");
                    status = "0";
                } else {
                    brfValidation.setCur_status("N");
                    brfValidation.setRemarks2("GOVERNMENT AND PUBLIC SECTOR - 6 -12 months ARE NOT EQUAL");
                    status = "2";
                }
                brfValidationsRepo.save(brfValidation);
                break;
			case "155":
                List<Object[]> result130 = brfValidationsRepo.getCheckSrlNo155(convertDate);
                if (!result130.isEmpty()) {
                    brfValidation.setCur_status("Y");
                    brfValidation.setRemarks2("GOVERNMENT AND PUBLIC SECTOR - 1 - 2 years ARE EQUAL");
                    status = "0";
                } else {
                    brfValidation.setCur_status("N");
                    brfValidation.setRemarks2("GOVERNMENT AND PUBLIC SECTOR - 1 - 2 years ARE NOT EQUAL");
                    status = "2";
                }
                brfValidationsRepo.save(brfValidation);
                break;
			case "156":
                List<Object[]> result131 = brfValidationsRepo.getCheckSrlNo156(convertDate);
                if (!result131.isEmpty()) {
                    brfValidation.setCur_status("Y");
                    brfValidation.setRemarks2("GOVERNMENT AND PUBLIC SECTOR - 2 - 3 years ARE EQUAL");
                    status = "0";
                } else {
                    brfValidation.setCur_status("N");
                    brfValidation.setRemarks2("GOVERNMENT AND PUBLIC SECTOR - 2 - 3 years ARE NOT EQUAL");
                    status = "2";
                }
                brfValidationsRepo.save(brfValidation);
                break;
			case "157":
                List<Object[]> result132 = brfValidationsRepo.getCheckSrlNo157(convertDate);
                if (!result132.isEmpty()) {
                    brfValidation.setCur_status("Y");
                    brfValidation.setRemarks2("GOVT OWNERSHIP OF MORE THAN 50%) - 0 - 7 days ARE EQUAL");
                    status = "0";
                } else {
                    brfValidation.setCur_status("N");
                    brfValidation.setRemarks2("GOVT OWNERSHIP OF MORE THAN 50%) - 0 - 7 days ARE NOT EQUAL");
                    status = "2";
                }
                brfValidationsRepo.save(brfValidation);
                break;
			case "158":
                List<Object[]> result133 = brfValidationsRepo.getCheckSrlNo158(convertDate);
                if (!result133.isEmpty()) {
                    brfValidation.setCur_status("Y");
                    brfValidation.setRemarks2("GOVT OWNERSHIP OF MORE THAN 50%) - 8-14 days ARE EQUAL");
                    status = "0";
                } else {
                    brfValidation.setCur_status("N");
                    brfValidation.setRemarks2("GOVT OWNERSHIP OF MORE THAN 50%) - 8-14 days ARE NOT EQUAL");
                    status = "2";
                }
                brfValidationsRepo.save(brfValidation);
                break;
			case "159":
                List<Object[]> result134 = brfValidationsRepo.getCheckSrlNo159(convertDate);
                if (!result134.isEmpty()) {
                    brfValidation.setCur_status("Y");
                    brfValidation.setRemarks2("GOVT OWNERSHIP OF MORE THAN 50%) - 15 days - 1 month ARE EQUAL");
                    status = "0";
                } else {
                    brfValidation.setCur_status("N");
                    brfValidation.setRemarks2("GOVT OWNERSHIP OF MORE THAN 50%) - 15 days - 1 month ARE NOT EQUAL");
                    status = "2";
                }
                brfValidationsRepo.save(brfValidation);
                break;
			case "160":
                List<Object[]> result135 = brfValidationsRepo.getCheckSrlNo160(convertDate);
                if (!result135.isEmpty()) {
                    brfValidation.setCur_status("Y");
                    brfValidation.setRemarks2("GOVT OWNERSHIP OF MORE THAN 50%) - 1 - 3 months ARE EQUAL");
                    status = "0";
                } else {
                    brfValidation.setCur_status("N");
                    brfValidation.setRemarks2("GOVT OWNERSHIP OF MORE THAN 50%) - 1 - 3 months ARE NOT EQUAL");
                    status = "2";
                }
                brfValidationsRepo.save(brfValidation);
                break;
			case "161":
                List<Object[]> result136 = brfValidationsRepo.getCheckSrlNo161(convertDate);
                if (!result136.isEmpty()) {
                    brfValidation.setCur_status("Y");
                    brfValidation.setRemarks2("GOVT OWNERSHIP OF MORE THAN 50%) - 3 -  6 months ARE EQUAL");
                    status = "0";
                } else {
                    brfValidation.setCur_status("N");
                    brfValidation.setRemarks2("GOVT OWNERSHIP OF MORE THAN 50%) - 3 -  6 months ARE NOT EQUAL");
                    status = "2";
                }
                brfValidationsRepo.save(brfValidation);
                break;
			case "162":
                List<Object[]> result137 = brfValidationsRepo.getCheckSrlNo162(convertDate);
                if (!result137.isEmpty()) {
                    brfValidation.setCur_status("Y");
                    brfValidation.setRemarks2("GOVT OWNERSHIP OF MORE THAN 50%) - 6 -12 months ARE EQUAL");
                    status = "0";
                } else {
                    brfValidation.setCur_status("N");
                    brfValidation.setRemarks2("GOVT OWNERSHIP OF MORE THAN 50%) - 6 -12 months ARE NOT EQUAL");
                    status = "2";
                }
                brfValidationsRepo.save(brfValidation);
                break;
			case "163":
                List<Object[]> result138 = brfValidationsRepo.getCheckSrlNo163(convertDate);
                if (!result138.isEmpty()) {
                    brfValidation.setCur_status("Y");
                    brfValidation.setRemarks2("GRES (GOVT OWNERSHIP OF MORE THAN 50%) - 1 - 2 years ARE EQUAL");
                    status = "0";
                } else {
                    brfValidation.setCur_status("N");
                    brfValidation.setRemarks2("GRES (GOVT OWNERSHIP OF MORE THAN 50%) - 1 - 2 years ARE NOT EQUAL");
                    status = "2";
                }
                brfValidationsRepo.save(brfValidation);
                break;
			case "164":
                List<Object[]> result139 = brfValidationsRepo.getCheckSrlNo164(convertDate);
                if (!result139.isEmpty()) {
                    brfValidation.setCur_status("Y");
                    brfValidation.setRemarks2("GOVT OWNERSHIP OF MORE THAN 50%) - 2 - 3 years ARE EQUAL");
                    status = "0";
                } else {
                    brfValidation.setCur_status("N");
                    brfValidation.setRemarks2("GOVT OWNERSHIP OF MORE THAN 50%) - 2 - 3 years ARE NOT EQUAL");
                    status = "2";
                }
                brfValidationsRepo.save(brfValidation);
                break;
			case "165":
                List<Object[]> result140 = brfValidationsRepo.getCheckSrlNo165(convertDate);
                if (!result140.isEmpty()) {
                    brfValidation.setCur_status("Y");
                    brfValidation.setRemarks2("CAPITAL MARKET INSTRUMENTS - 0 - 7 days ARE EQUAL");
                    status = "0";
                } else {
                    brfValidation.setCur_status("N");
                    brfValidation.setRemarks2("CAPITAL MARKET INSTRUMENTS - 0 - 7 days ARE NOT EQUAL");
                    status = "2";
                }
                brfValidationsRepo.save(brfValidation);
                break;
			case "166":
                List<Object[]> result141 = brfValidationsRepo.getCheckSrlNo166(convertDate);
                if (!result141.isEmpty()) {
                    brfValidation.setCur_status("Y");
                    brfValidation.setRemarks2("CAPITAL MARKET INSTRUMENTS - 8-14 days ARE EQUAL");
                    status = "0";
                } else {
                    brfValidation.setCur_status("N");
                    brfValidation.setRemarks2("CAPITAL MARKET INSTRUMENTS - 8-14 days ARE NOT EQUAL");
                    status = "2";
                }
                brfValidationsRepo.save(brfValidation);
                break;
			case "167":
                List<Object[]> result142 = brfValidationsRepo.getCheckSrlNo167(convertDate);
                if (!result142.isEmpty()) {
                    brfValidation.setCur_status("Y");
                    brfValidation.setRemarks2("CAPITAL MARKET INSTRUMENTS - 15 days - 1 month ARE EQUAL");
                    status = "0";
                } else {
                    brfValidation.setCur_status("N");
                    brfValidation.setRemarks2("CAPITAL MARKET INSTRUMENTS - 15 days - 1 month ARE NOT EQUAL");
                    status = "2";
                }
                brfValidationsRepo.save(brfValidation);
                break;
			case "168":
                List<Object[]> result143 = brfValidationsRepo.getCheckSrlNo168(convertDate);
                if (!result143.isEmpty()) {
                    brfValidation.setCur_status("Y");
                    brfValidation.setRemarks2("CAPITAL MARKET INSTRUMENTS - 1 - 3 months ARE EQUAL");
                    status = "0";
                } else {
                    brfValidation.setCur_status("N");
                    brfValidation.setRemarks2("CAPITAL MARKET INSTRUMENTS - 1 - 3 months ARE NOT EQUAL");
                    status = "2";
                }
                brfValidationsRepo.save(brfValidation);
                break;
			case "169":
                List<Object[]> result144 = brfValidationsRepo.getCheckSrlNo169(convertDate);
                if (!result144.isEmpty()) {
                    brfValidation.setCur_status("Y");
                    brfValidation.setRemarks2("CAPITAL MARKET INSTRUMENTS - 3 -  6 months ARE EQUAL");
                    status = "0";
                } else {
                    brfValidation.setCur_status("N");
                    brfValidation.setRemarks2("CAPITAL MARKET INSTRUMENTS - 3 -  6 months ARE NOT EQUAL");
                    status = "2";
                }
                brfValidationsRepo.save(brfValidation);
                break;
			case "170":
                List<Object[]> result145 = brfValidationsRepo.getCheckSrlNo170(convertDate);
                if (!result145.isEmpty()) {
                    brfValidation.setCur_status("Y");
                    brfValidation.setRemarks2("CAPITAL MARKET INSTRUMENTS - 6 -12 months ARE EQUAL");
                    status = "0";
                } else {
                    brfValidation.setCur_status("N");
                    brfValidation.setRemarks2("CAPITAL MARKET INSTRUMENTS - 6 -12 months ARE NOT EQUAL");
                    status = "2";
                }
                brfValidationsRepo.save(brfValidation);
                break;
			case "171":
                List<Object[]> result146 = brfValidationsRepo.getCheckSrlNo171(convertDate);
                if (!result146.isEmpty()) {
                    brfValidation.setCur_status("Y");
                    brfValidation.setRemarks2("CAPITAL MARKET INSTRUMENTS - 2 - 3 years ARE EQUAL");
                    status = "0";
                } else {
                    brfValidation.setCur_status("N");
                    brfValidation.setRemarks2("CAPITAL MARKET INSTRUMENTS - 2 - 3 years ARE NOT EQUAL");
                    status = "2";
                }
                brfValidationsRepo.save(brfValidation);
                break;
			case "172":
                List<Object[]> result147 = brfValidationsRepo.getCheckSrlNo172(convertDate);
                if (!result147.isEmpty()) {
                    brfValidation.setCur_status("Y");
                    brfValidation.setRemarks2("OTHER LIABILITIES - 0 - 7 days ARE EQUAL");
                    status = "0";
                } else {
                    brfValidation.setCur_status("N");
                    brfValidation.setRemarks2("OTHER LIABILITIES - 0 - 7 days ARE NOT EQUAL");
                    status = "2";
                }
                brfValidationsRepo.save(brfValidation);
                break;
			case "173":
                List<Object[]> result148 = brfValidationsRepo.getCheckSrlNo173(convertDate);
                if (!result148.isEmpty()) {
                    brfValidation.setCur_status("Y");
                    brfValidation.setRemarks2("OTHER LIABILITIES - 8-14 days ARE EQUAL");
                    status = "0";
                } else {
                    brfValidation.setCur_status("N");
                    brfValidation.setRemarks2("OTHER LIABILITIES - 8-14 days ARE NOT EQUAL");
                    status = "2";
                }
                brfValidationsRepo.save(brfValidation);
                break;
			case "174":
                List<Object[]> result149 = brfValidationsRepo.getCheckSrlNo174(convertDate);
                if (!result149.isEmpty()) {
                    brfValidation.setCur_status("Y");
                    brfValidation.setRemarks2("OTHER LIABILITIES - 15 days - 1 month ARE EQUAL");
                    status = "0";
                } else {
                    brfValidation.setCur_status("N");
                    brfValidation.setRemarks2("OTHER LIABILITIES - 15 days - 1 month ARE NOT EQUAL");
                    status = "2";
                }
                brfValidationsRepo.save(brfValidation);
                break;
			case "175":
                List<Object[]> result150 = brfValidationsRepo.getCheckSrlNo175(convertDate);
                if (!result150.isEmpty()) {
                    brfValidation.setCur_status("Y");
                    brfValidation.setRemarks2("OTHER LIABILITIES - 1 - 3 months ARE EQUAL");
                    status = "0";
                } else {
                    brfValidation.setCur_status("N");
                    brfValidation.setRemarks2("OTHER LIABILITIES - 1 - 3 months ARE NOT EQUAL");
                    status = "2";
                }
                brfValidationsRepo.save(brfValidation);
                break;
			case "176":
                List<Object[]> result151 = brfValidationsRepo.getCheckSrlNo176(convertDate);
                if (!result151.isEmpty()) {
                    brfValidation.setCur_status("Y");
                    brfValidation.setRemarks2("OTHER LIABILITIES - 3 -  6 months ARE EQUAL");
                    status = "0";
                } else {
                    brfValidation.setCur_status("N");
                    brfValidation.setRemarks2("OTHER LIABILITIES - 3 -  6 months ARE NOT EQUAL");
                    status = "2";
                }
                brfValidationsRepo.save(brfValidation);
                break;
			case "177":
                List<Object[]> result152 = brfValidationsRepo.getCheckSrlNo177(convertDate);
                if (!result152.isEmpty()) {
                    brfValidation.setCur_status("Y");
                    brfValidation.setRemarks2("OTHER LIABILITIES - 6 -12 months ARE EQUAL");
                    status = "0";
                } else {
                    brfValidation.setCur_status("N");
                    brfValidation.setRemarks2("OTHER LIABILITIES - 6 -12 months ARE NOT EQUAL");
                    status = "2";
                }
                brfValidationsRepo.save(brfValidation);
                break;
			case "178":
                List<Object[]> result153 = brfValidationsRepo.getCheckSrlNo178(convertDate);
                if (!result153.isEmpty()) {
                    brfValidation.setCur_status("Y");
                    brfValidation.setRemarks2("OTHER LIABILITIES - 1 - 2 years ARE EQUAL");
                    status = "0";
                } else {
                    brfValidation.setCur_status("N");
                    brfValidation.setRemarks2("OTHER LIABILITIES - 1 - 2 years ARE NOT EQUAL");
                    status = "2";
                }
                brfValidationsRepo.save(brfValidation);
                break;
			case "179":
                List<Object[]> result154 = brfValidationsRepo.getCheckSrlNo179(convertDate);
                if (!result154.isEmpty()) {
                    brfValidation.setCur_status("Y");
                    brfValidation.setRemarks2("OTHER LIABILITIES - 2 - 3 years ARE EQUAL");
                    status = "0";
                } else {
                    brfValidation.setCur_status("N");
                    brfValidation.setRemarks2("OTHER LIABILITIES - 2 - 3 years ARE NOT EQUAL");
                    status = "2";
                }
                brfValidationsRepo.save(brfValidation);
                break;
			case "180":
                List<Object[]> result155 = brfValidationsRepo.getCheckSrlNo180(convertDate);
                if (!result155.isEmpty()) {
                    brfValidation.setCur_status("Y");
                    brfValidation.setRemarks2("PROVISIONS - 0 - 7 days ARE EQUAL");
                    status = "0";
                } else {
                    brfValidation.setCur_status("N");
                    brfValidation.setRemarks2("PROVISIONS - 0 - 7 days ARE NOT EQUAL");
                    status = "2";
                }
                brfValidationsRepo.save(brfValidation);
                break;
			case "181":
                List<Object[]> result156 = brfValidationsRepo.getCheckSrlNo181(convertDate);
                if (!result156.isEmpty()) {
                    brfValidation.setCur_status("Y");
                    brfValidation.setRemarks2("PROVISIONS - 8-14 days ARE EQUAL");
                    status = "0";
                } else {
                    brfValidation.setCur_status("N");
                    brfValidation.setRemarks2("PROVISIONS - 8-14 days ARE NOT EQUAL");
                    status = "2";
                }
                brfValidationsRepo.save(brfValidation);
                break;
			case "182":
                List<Object[]> result157 = brfValidationsRepo.getCheckSrlNo182(convertDate);
                if (!result157.isEmpty()) {
                    brfValidation.setCur_status("Y");
                    brfValidation.setRemarks2("PROVISIONS - 15 days - 1 month ARE EQUAL");
                    status = "0";
                } else {
                    brfValidation.setCur_status("N");
                    brfValidation.setRemarks2("PROVISIONS - 15 days - 1 month ARE NOT EQUAL");
                    status = "2";
                }
                brfValidationsRepo.save(brfValidation);
                break;
			case "183":
                List<Object[]> result158 = brfValidationsRepo.getCheckSrlNo183(convertDate);
                if (!result158.isEmpty()) {
                    brfValidation.setCur_status("Y");
                    brfValidation.setRemarks2("PROVISIONS - 3 -  6 months ARE EQUAL");
                    status = "0";
                } else {
                    brfValidation.setCur_status("N");
                    brfValidation.setRemarks2("PROVISIONS - 3 -  6 months ARE NOT EQUAL");
                    status = "2";
                }
                brfValidationsRepo.save(brfValidation);
                break;
			case "184":
                List<Object[]> result159 = brfValidationsRepo.getCheckSrlNo184(convertDate);
                if (!result159.isEmpty()) {
                    brfValidation.setCur_status("Y");
                    brfValidation.setRemarks2("PROVISIONS - 6 -12 months ARE EQUAL");
                    status = "0";
                } else {
                    brfValidation.setCur_status("N");
                    brfValidation.setRemarks2("PROVISIONS - 6 -12 months ARE NOT EQUAL");
                    status = "2";
                }
                brfValidationsRepo.save(brfValidation);
                break;
			case "185":
                List<Object[]> result160 = brfValidationsRepo.getCheckSrlNo185(convertDate);
                if (!result160.isEmpty()) {
                    brfValidation.setCur_status("Y");
                    brfValidation.setRemarks2("PROVISIONS - 1 - 2 years ARE EQUAL");
                    status = "0";
                } else {
                    brfValidation.setCur_status("N");
                    brfValidation.setRemarks2("PROVISIONS - 1 - 2 years ARE NOT EQUAL");
                    status = "2";
                }
                brfValidationsRepo.save(brfValidation);
                break;
			case "186":
                List<Object[]> result161 = brfValidationsRepo.getCheckSrlNo186(convertDate);
                if (!result161.isEmpty()) {
                    brfValidation.setCur_status("Y");
                    brfValidation.setRemarks2("PROVISIONS - 2 - 3 years ARE EQUAL");
                    status = "0";
                } else {
                    brfValidation.setCur_status("N");
                    brfValidation.setRemarks2("PROVISIONS - 2 - 3 years ARE NOT EQUAL");
                    status = "2";
                }
                brfValidationsRepo.save(brfValidation);
                break;
			case "187":
                List<Object[]> result162 = brfValidationsRepo.getCheckSrlNo187(convertDate);
                if (!result162.isEmpty()) {
                    brfValidation.setCur_status("Y");
                    brfValidation.setRemarks2("PROVISIONS - NON-INTEREST RATE SENSITIVE ARE EQUAL");
                    status = "0";
                } else {
                    brfValidation.setCur_status("N");
                    brfValidation.setRemarks2("PROVISIONS - NON-INTEREST RATE SENSITIVE ARE NOT EQUAL");
                    status = "2";
                }
                brfValidationsRepo.save(brfValidation);
                break;
			case "188":
                List<Object[]> result163 = brfValidationsRepo.getCheckSrlNo188(convertDate);
                if (!result163.isEmpty()) {
                    brfValidation.setCur_status("Y");
                    brfValidation.setRemarks2("CAPITAL AND RESERVES - 0 - 7 days ARE EQUAL");
                    status = "0";
                } else {
                    brfValidation.setCur_status("N");
                    brfValidation.setRemarks2("CAPITAL AND RESERVES - 0 - 7 days ARE NOT EQUAL");
                    status = "2";
                }
                brfValidationsRepo.save(brfValidation);
                break;
			case "189":
                List<Object[]> result164 = brfValidationsRepo.getCheckSrlNo189(convertDate);
                if (!result164.isEmpty()) {
                    brfValidation.setCur_status("Y");
                    brfValidation.setRemarks2("CAPITAL AND RESERVES - 8-14 days ARE EQUAL");
                    status = "0";
                } else {
                    brfValidation.setCur_status("N");
                    brfValidation.setRemarks2("CAPITAL AND RESERVES - 8-14 days ARE NOT EQUAL");
                    status = "2";
                }
                brfValidationsRepo.save(brfValidation);
                break;
			case "190":
                List<Object[]> result165 = brfValidationsRepo.getCheckSrlNo190(convertDate);
                if (!result165.isEmpty()) {
                    brfValidation.setCur_status("Y");
                    brfValidation.setRemarks2("CAPITAL AND RESERVES - 15 days - 1 month ARE EQUAL");
                    status = "0";
                } else {
                    brfValidation.setCur_status("N");
                    brfValidation.setRemarks2("CAPITAL AND RESERVES - 15 days - 1 month ARE NOT EQUAL");
                    status = "2";
                }
                brfValidationsRepo.save(brfValidation);
                break;
			case "191":
                List<Object[]> result166 = brfValidationsRepo.getCheckSrlNo191(convertDate);
                if (!result166.isEmpty()) {
                    brfValidation.setCur_status("Y");
                    brfValidation.setRemarks2("CAPITAL AND RESERVES - 1 - 3 months ARE EQUAL");
                    status = "0";
                } else {
                    brfValidation.setCur_status("N");
                    brfValidation.setRemarks2("CAPITAL AND RESERVES - 1 - 3 months ARE NOT EQUAL");
                    status = "2";
                }
                brfValidationsRepo.save(brfValidation);
                break;
			case "192":
                List<Object[]> result167 = brfValidationsRepo.getCheckSrlNo192(convertDate);
                if (!result167.isEmpty()) {
                    brfValidation.setCur_status("Y");
                    brfValidation.setRemarks2("CAPITAL AND RESERVES - 3 -  6 months ARE EQUAL");
                    status = "0";
                } else {
                    brfValidation.setCur_status("N");
                    brfValidation.setRemarks2("CAPITAL AND RESERVES - 3 -  6 months ARE NOT EQUAL");
                    status = "2";
                }
                brfValidationsRepo.save(brfValidation);
                break;
			case "193":
                List<Object[]> result168 = brfValidationsRepo.getCheckSrlNo193(convertDate);
                if (!result168.isEmpty()) {
                    brfValidation.setCur_status("Y");
                    brfValidation.setRemarks2("CAPITAL AND RESERVES - 6 -12 months ARE EQUAL");
                    status = "0";
                } else {
                    brfValidation.setCur_status("N");
                    brfValidation.setRemarks2("CAPITAL AND RESERVES - 6 -12 months ARE NOT EQUAL");
                    status = "2";
                }
                brfValidationsRepo.save(brfValidation);
                break;
			case "194":
                List<Object[]> result169 = brfValidationsRepo.getCheckSrlNo194(convertDate);
                if (!result169.isEmpty()) {
                    brfValidation.setCur_status("Y");
                    brfValidation.setRemarks2("CAPITAL AND RESERVES - 1 - 2 years ARE EQUAL");
                    status = "0";
                } else {
                    brfValidation.setCur_status("N");
                    brfValidation.setRemarks2("CAPITAL AND RESERVES - 1 - 2 years ARE NOT EQUAL");
                    status = "2";
                }
                brfValidationsRepo.save(brfValidation);
                break;
			case "195":
                List<Object[]> result170 = brfValidationsRepo.getCheckSrlNo195(convertDate);
                if (!result170.isEmpty()) {
                    brfValidation.setCur_status("Y");
                    brfValidation.setRemarks2("CAPITAL AND RESERVES - NON-INTEREST RATE SENSITIVE ARE EQUAL");
                    status = "0";
                } else {
                    brfValidation.setCur_status("N");
                    brfValidation.setRemarks2("CAPITAL AND RESERVES - NON-INTEREST RATE SENSITIVE ARE NOT EQUAL");
                    status = "2";
                }
                brfValidationsRepo.save(brfValidation);
                break;
			case "196":
				//obj=brfValidationsRepo.getCheckSrlNo1(report_date);
			
				if(brfValidationsRepo.getCheckSrlNo196(convertDate)>0){
					brfValidation.setCur_status("Y");
					brfValidation.setRemarks2("Data Available for Current Report");
					brfValidationsRepo.save(brfValidation);	
					status="0";
				}else {
					brfValidation.setCur_status("N");
					brfValidation.setRemarks2("Generate Treasury Data for Current Report");
					brfValidationsRepo.save(brfValidation);
					status="2";
				}
				break;
			case "197":
				//obj=brfValidationsRepo.getCheckSrlNo1(report_date);
			
				if(brfValidationsRepo.getCheckSrlNo197(convertDate)>0){
					brfValidation.setCur_status("N");
					brfValidation.setRemarks2("Unmapped Accounts Available");
					brfValidationsRepo.save(brfValidation);	
					status="1";
				}else {
					brfValidation.setCur_status("Y");
					brfValidation.setRemarks2("No Unmapped Accounts");
					brfValidationsRepo.save(brfValidation);
					status="0";
				}
				break;
			case "198":
				//obj=brfValidationsRepo.getCheckSrlNo1(report_date);
			
				if(brfValidationsRepo.getCheckSrlNo198(convertDate)>0){
					brfValidation.setCur_status("Y");
					brfValidation.setRemarks2("Data Available for Current Report");
					brfValidationsRepo.save(brfValidation);	
					status="0";
				}else {
					brfValidation.setCur_status("N");
					brfValidation.setRemarks2("Generate Summary for Current Report");
					brfValidationsRepo.save(brfValidation);
					status="2";
				}
				break;
			case "199":
				//obj=brfValidationsRepo.getCheckSrlNo1(report_date);
			
				if(brfValidationsRepo.getCheckSrlNo199(convertDate)>0){
					brfValidation.setCur_status("Y");
					brfValidation.setRemarks2("Data Available for Current Report");
					brfValidationsRepo.save(brfValidation);	
					status="0";
				}else {
					brfValidation.setCur_status("N");
					brfValidation.setRemarks2("Generate Treasury Data for Current Report");
					brfValidationsRepo.save(brfValidation);
					status="2";
				}
				break;
			case "200":
				//obj=brfValidationsRepo.getCheckSrlNo1(report_date);
			
				if(brfValidationsRepo.getCheckSrlNo200(convertDate)>0){
					brfValidation.setCur_status("N");
					brfValidation.setRemarks2("Unmapped Accounts Available");
					brfValidationsRepo.save(brfValidation);	
					status="1";
				}else {
					brfValidation.setCur_status("Y");
					brfValidation.setRemarks2("No Unmapped Accounts");
					brfValidationsRepo.save(brfValidation);
					status="0";
				}
				break;
			case "201":
				//obj=brfValidationsRepo.getCheckSrlNo1(report_date);
			
				if(brfValidationsRepo.getCheckSrlNo201(convertDate)>0){
					brfValidation.setCur_status("Y");
					brfValidation.setRemarks2("Data Available for Current Report");
					brfValidationsRepo.save(brfValidation);	
					status="0";
				}else {
					brfValidation.setCur_status("N");
					brfValidation.setRemarks2("Generate Summary for Current Report");
					brfValidationsRepo.save(brfValidation);
					status="2";
				}
				break;
			case "202":
				//obj=brfValidationsRepo.getCheckSrlNo1(report_date);
			
				if(brfValidationsRepo.getCheckSrlNo202(convertDate)>0){
					brfValidation.setCur_status("Y");
					brfValidation.setRemarks2("Data Available for Current Report");
					brfValidationsRepo.save(brfValidation);	
					status="0";
				}else {
					brfValidation.setCur_status("N");
					brfValidation.setRemarks2("Generate Treasury Data for Current Report");
					brfValidationsRepo.save(brfValidation);
					status="2";
				}
				break;
			case "203":
				//obj=brfValidationsRepo.getCheckSrlNo1(report_date);
			
				if(brfValidationsRepo.getCheckSrlNo203(convertDate)>0){
					brfValidation.setCur_status("N");
					brfValidation.setRemarks2("Unmapped Accounts Available");
					brfValidationsRepo.save(brfValidation);	
					status="1";
				}else {
					brfValidation.setCur_status("Y");
					brfValidation.setRemarks2("No Unmapped Accounts");
					brfValidationsRepo.save(brfValidation);
					status="0";
				}
				break;
			case "204":
				//obj=brfValidationsRepo.getCheckSrlNo1(report_date);
			
				if(brfValidationsRepo.getCheckSrlNo204(convertDate)>0){
					brfValidation.setCur_status("Y");
					brfValidation.setRemarks2("Data Available for Current Report");
					brfValidationsRepo.save(brfValidation);	
					status="0";
				}else {
					brfValidation.setCur_status("N");
					brfValidation.setRemarks2("Generate Summary for Current Report");
					brfValidationsRepo.save(brfValidation);
					status="2";
				}
				break;
			case "205":
				//obj=brfValidationsRepo.getCheckSrlNo1(report_date);
			
				if(brfValidationsRepo.getCheckSrlNo205(convertDate)>0){
					brfValidation.setCur_status("Y");
					brfValidation.setRemarks2("Data Available for Current Report");
					brfValidationsRepo.save(brfValidation);	
					status="0";
				}else {
					brfValidation.setCur_status("N");
					brfValidation.setRemarks2("Generate Treasury Data for Current Report");
					brfValidationsRepo.save(brfValidation);
					status="2";
				}
				break;
			case "206":
				//obj=brfValidationsRepo.getCheckSrlNo1(report_date);
			
				if(brfValidationsRepo.getCheckSrlNo206(convertDate)>0){
					brfValidation.setCur_status("N");
					brfValidation.setRemarks2("Unmapped Accounts Available");
					brfValidationsRepo.save(brfValidation);	
					status="1";
				}else {
					brfValidation.setCur_status("Y");
					brfValidation.setRemarks2("No Unmapped Accounts");
					brfValidationsRepo.save(brfValidation);
					status="0";
				}
				break;
			case "207":
				//obj=brfValidationsRepo.getCheckSrlNo1(report_date);
			
				if(brfValidationsRepo.getCheckSrlNo207(convertDate)>0){
					brfValidation.setCur_status("Y");
					brfValidation.setRemarks2("Data Available for Current Report");
					brfValidationsRepo.save(brfValidation);	
					status="0";
				}else {
					brfValidation.setCur_status("N");
					brfValidation.setRemarks2("Generate Summary for Current Report");
					brfValidationsRepo.save(brfValidation);
					status="2";
				}
				break;
			case "208":
                List<Object[]> result171 = brfValidationsRepo.getCheckSrlNo208(convertDate);
                if (!result171.isEmpty()) {
                    brfValidation.setCur_status("Y");
                    brfValidation.setRemarks2("PLACEMENTS/ LOANS WITH AND BALANCES DUE FROM OVERSEAS BANKS - OVERDUE ARE EQUAL");
                    status = "0";
                } else {
                    brfValidation.setCur_status("N");
                    brfValidation.setRemarks2("PLACEMENTS/ LOANS WITH AND BALANCES DUE FROM OVERSEAS BANKS - OVERDUE ARE NOT EQUAL");
                    status = "2";
                }
                brfValidationsRepo.save(brfValidation);
                break;
			case "209":
                List<Object[]> result172 = brfValidationsRepo.getCheckSrlNo209(convertDate);
                if (!result172.isEmpty()) {
                    brfValidation.setCur_status("Y");
                    brfValidation.setRemarks2("PLACEMENTS/ LOANS WITH AND BALANCES DUE FROM OVERSEAS BANKS - 0 - 7 DAYS ARE EQUAL");
                    status = "0";
                } else {
                    brfValidation.setCur_status("N");
                    brfValidation.setRemarks2("PLACEMENTS/ LOANS WITH AND BALANCES DUE FROM OVERSEAS BANKS - 0 - 7 DAYS ARE NOT EQUAL");
                    status = "2";
                }
                brfValidationsRepo.save(brfValidation);
                break;
			case "210":
                List<Object[]> result173 = brfValidationsRepo.getCheckSrlNo210(convertDate);
                if (!result173.isEmpty()) {
                    brfValidation.setCur_status("Y");
                    brfValidation.setRemarks2("PLACEMENTS/ LOANS WITH AND BALANCES DUE FROM OVERSEAS BANKS - 8 - 14 DAYS ARE EQUAL");
                    status = "0";
                } else {
                    brfValidation.setCur_status("N");
                    brfValidation.setRemarks2("PLACEMENTS/ LOANS WITH AND BALANCES DUE FROM OVERSEAS BANKS - 8 - 14 DAYS ARE NOT EQUAL");
                    status = "2";
                }
                brfValidationsRepo.save(brfValidation);
                break;
			case "211":
                List<Object[]> result174 = brfValidationsRepo.getCheckSrlNo211(convertDate);
                if (!result174.isEmpty()) {
                    brfValidation.setCur_status("Y");
                    brfValidation.setRemarks2("PLACEMENTS/ LOANS WITH AND BALANCES DUE FROM OVERSEAS BANKS - 15 DAYS - 1 MONTH ARE EQUAL");
                    status = "0";
                } else {
                    brfValidation.setCur_status("N");
                    brfValidation.setRemarks2("PLACEMENTS/ LOANS WITH AND BALANCES DUE FROM OVERSEAS BANKS - 15 DAYS - 1 MONTH ARE NOT EQUAL");
                    status = "2";
                }
                brfValidationsRepo.save(brfValidation);
                break;
			case "212":
                List<Object[]> result175 = brfValidationsRepo.getCheckSrlNo212(convertDate);
                if (!result175.isEmpty()) {
                    brfValidation.setCur_status("Y");
                    brfValidation.setRemarks2("PLACEMENTS/ LOANS WITH AND BALANCES DUE FROM OVERSEAS BANKS - 1 - 3 MONTHS ARE EQUAL");
                    status = "0";
                } else {
                    brfValidation.setCur_status("N");
                    brfValidation.setRemarks2("PLACEMENTS/ LOANS WITH AND BALANCES DUE FROM OVERSEAS BANKS - 1 - 3 MONTHS ARE NOT EQUAL");
                    status = "2";
                }
                brfValidationsRepo.save(brfValidation);
                break;
			case "213":
                List<Object[]> result176 = brfValidationsRepo.getCheckSrlNo213(convertDate);
                if (!result176.isEmpty()) {
                    brfValidation.setCur_status("Y");
                    brfValidation.setRemarks2("PLACEMENTS/ LOANS WITH AND BALANCES DUE FROM OVERSEAS BANKS - 3 - 6 MONTHS ARE EQUAL");
                    status = "0";
                } else {
                    brfValidation.setCur_status("N");
                    brfValidation.setRemarks2("PLACEMENTS/ LOANS WITH AND BALANCES DUE FROM OVERSEAS BANKS - 3 - 6 MONTHS ARE NOT EQUAL");
                    status = "2";
                }
                brfValidationsRepo.save(brfValidation);
                break;
			case "214":
                List<Object[]> result177 = brfValidationsRepo.getCheckSrlNo214(convertDate);
                if (!result177.isEmpty()) {
                    brfValidation.setCur_status("Y");
                    brfValidation.setRemarks2("PLACEMENTS/ LOANS WITH AND BALANCES DUE FROM OVERSEAS BANKS - 6 - 12 MONTHS ARE EQUAL");
                    status = "0";
                } else {
                    brfValidation.setCur_status("N");
                    brfValidation.setRemarks2("PLACEMENTS/ LOANS WITH AND BALANCES DUE FROM OVERSEAS BANKS - 6 - 12 MONTHS ARE NOT EQUAL");
                    status = "2";
                }
                brfValidationsRepo.save(brfValidation);
                break;
			case "215":
                List<Object[]> result178 = brfValidationsRepo.getCheckSrlNo215(convertDate);
                if (!result178.isEmpty()) {
                    brfValidation.setCur_status("Y");
                    brfValidation.setRemarks2("PLACEMENTS/ LOANS WITH AND BALANCES DUE FROM OVERSEAS BANKS - 1 - 3 YEARS ARE EQUAL");
                    status = "0";
                } else {
                    brfValidation.setCur_status("N");
                    brfValidation.setRemarks2("PLACEMENTS/ LOANS WITH AND BALANCES DUE FROM OVERSEAS BANKS - 1 - 3 YEARS ARE NOT EQUAL");
                    status = "2";
                }
                brfValidationsRepo.save(brfValidation);
                break;
			case "216":
                List<Object[]> result179 = brfValidationsRepo.getCheckSrlNo216(convertDate);
                if (!result179.isEmpty()) {
                    brfValidation.setCur_status("Y");
                    brfValidation.setRemarks2("PLACEMENTS/ LOANS WITH AND BALANCES DUE FROM OVERSEAS BANKS - > 3 YEARS ARE EQUAL");
                    status = "0";
                } else {
                    brfValidation.setCur_status("N");
                    brfValidation.setRemarks2("PLACEMENTS/ LOANS WITH AND BALANCES DUE FROM OVERSEAS BANKS - > 3 YEARS ARE NOT EQUAL");
                    status = "2";
                }
                brfValidationsRepo.save(brfValidation);
                break;
			case "217":
                List<Object[]> result180 = brfValidationsRepo.getCheckSrlNo217(convertDate);
                if (!result180.isEmpty()) {
                    brfValidation.setCur_status("Y");
                    brfValidation.setRemarks2("NON-UAE PUBLIC SECTOR ENTERPRISES DEBT/ SUKUKS - OVERDUE ARE EQUAL");
                    status = "0";
                } else {
                    brfValidation.setCur_status("N");
                    brfValidation.setRemarks2("NON-UAE PUBLIC SECTOR ENTERPRISES DEBT/ SUKUKS - OVERDUE ARE NOT EQUAL");
                    status = "2";
                }
                brfValidationsRepo.save(brfValidation);
                break;
			case "218":
                List<Object[]> result181 = brfValidationsRepo.getCheckSrlNo218(convertDate);
                if (!result181.isEmpty()) {
                    brfValidation.setCur_status("Y");
                    brfValidation.setRemarks2("NON-UAE PUBLIC SECTOR ENTERPRISES DEBT/ SUKUKS - OVERDRAFT ARE EQUAL");
                    status = "0";
                } else {
                    brfValidation.setCur_status("N");
                    brfValidation.setRemarks2("NON-UAE PUBLIC SECTOR ENTERPRISES DEBT/ SUKUKS - OVERDRAFT ARE NOT EQUAL");
                    status = "2";
                }
                brfValidationsRepo.save(brfValidation);
                break;
			case "219":
                List<Object[]> result182 = brfValidationsRepo.getCheckSrlNo219(convertDate);
                if (!result182.isEmpty()) {
                    brfValidation.setCur_status("Y");
                    brfValidation.setRemarks2("NON-UAE PUBLIC SECTOR ENTERPRISES DEBT/ SUKUKS - 0 - 7 DAYS ARE EQUAL");
                    status = "0";
                } else {
                    brfValidation.setCur_status("N");
                    brfValidation.setRemarks2("NON-UAE PUBLIC SECTOR ENTERPRISES DEBT/ SUKUKS - 0 - 7 DAYS ARE NOT EQUAL");
                    status = "2";
                }
                brfValidationsRepo.save(brfValidation);
                break;
			case "220":
                List<Object[]> result183 = brfValidationsRepo.getCheckSrlNo220(convertDate);
                if (!result183.isEmpty()) {
                    brfValidation.setCur_status("Y");
                    brfValidation.setRemarks2("NON-UAE PUBLIC SECTOR ENTERPRISES DEBT/ SUKUKS - 8 - 14 DAYS ARE EQUAL");
                    status = "0";
                } else {
                    brfValidation.setCur_status("N");
                    brfValidation.setRemarks2("NON-UAE PUBLIC SECTOR ENTERPRISES DEBT/ SUKUKS - 8 - 14 DAYS ARE NOT EQUAL");
                    status = "2";
                }
                brfValidationsRepo.save(brfValidation);
                break;
			case "221":
                List<Object[]> result184 = brfValidationsRepo.getCheckSrlNo221(convertDate);
                if (!result184.isEmpty()) {
                    brfValidation.setCur_status("Y");
                    brfValidation.setRemarks2("NON-UAE PUBLIC SECTOR ENTERPRISES DEBT/ SUKUKS - 15 DAYS - 1 MONTH ARE EQUAL");
                    status = "0";
                } else {
                    brfValidation.setCur_status("N");
                    brfValidation.setRemarks2("NON-UAE PUBLIC SECTOR ENTERPRISES DEBT/ SUKUKS - 15 DAYS - 1 MONTH ARE NOT EQUAL");
                    status = "2";
                }
                brfValidationsRepo.save(brfValidation);
                break;
			case "222":
                List<Object[]> result185 = brfValidationsRepo.getCheckSrlNo222(convertDate);
                if (!result185.isEmpty()) {
                    brfValidation.setCur_status("Y");
                    brfValidation.setRemarks2("NON-UAE PUBLIC SECTOR ENTERPRISES DEBT/ SUKUKS - 1 - 3 MONTHS ARE EQUAL");
                    status = "0";
                } else {
                    brfValidation.setCur_status("N");
                    brfValidation.setRemarks2("NON-UAE PUBLIC SECTOR ENTERPRISES DEBT/ SUKUKS - 1 - 3 MONTHS NOT EQUAL");
                    status = "2";
                }
                brfValidationsRepo.save(brfValidation);
                break;
			case "223":
                List<Object[]> result186 = brfValidationsRepo.getCheckSrlNo223(convertDate);
                if (!result186.isEmpty()) {
                    brfValidation.setCur_status("Y");
                    brfValidation.setRemarks2("NON-UAE PUBLIC SECTOR ENTERPRISES DEBT/ SUKUKS - 3 - 6 MONTHS ARE EQUAL");
                    status = "0";
                } else {
                    brfValidation.setCur_status("N");
                    brfValidation.setRemarks2("NON-UAE PUBLIC SECTOR ENTERPRISES DEBT/ SUKUKS - 3 - 6 MONTHS ARE NOT EQUAL");
                    status = "2";
                }
                brfValidationsRepo.save(brfValidation);
                break;
			case "224":
                List<Object[]> result187 = brfValidationsRepo.getCheckSrlNo224(convertDate);
                if (!result187.isEmpty()) {
                    brfValidation.setCur_status("Y");
                    brfValidation.setRemarks2("NON-UAE PUBLIC SECTOR ENTERPRISES DEBT/ SUKUKS - 6 - 12 MONTHS ARE EQUAL");
                    status = "0";
                } else {
                    brfValidation.setCur_status("N");
                    brfValidation.setRemarks2("NON-UAE PUBLIC SECTOR ENTERPRISES DEBT/ SUKUKS - 6 - 12 MONTHS ARE NOT EQUAL");
                    status = "2";
                }
                brfValidationsRepo.save(brfValidation);
                break;
			case "225":
                List<Object[]> result188 = brfValidationsRepo.getCheckSrlNo225(convertDate);
                if (!result188.isEmpty()) {
                    brfValidation.setCur_status("Y");
                    brfValidation.setRemarks2("NON-UAE PUBLIC SECTOR ENTERPRISES DEBT/ SUKUKS - 1 - 3 YEARS ARE EQUAL");
                    status = "0";
                } else {
                    brfValidation.setCur_status("N");
                    brfValidation.setRemarks2("NON-UAE PUBLIC SECTOR ENTERPRISES DEBT/ SUKUKS - 1 - 3 YEARS ARE NOT EQUAL");
                    status = "2";
                }
                brfValidationsRepo.save(brfValidation);
                break;
			case "226":
                List<Object[]> result189 = brfValidationsRepo.getCheckSrlNo226(convertDate);
                if (!result189.isEmpty()) {
                    brfValidation.setCur_status("Y");
                    brfValidation.setRemarks2("NON-UAE PUBLIC SECTOR ENTERPRISES DEBT/ SUKUKS - > 3 YEARS ARE EQUAL");
                    status = "0";
                } else {
                    brfValidation.setCur_status("N");
                    brfValidation.setRemarks2("NON-UAE PUBLIC SECTOR ENTERPRISES DEBT/ SUKUKS - > 3 YEARS ARE NOT EQUAL");
                    status = "2";
                }
                brfValidationsRepo.save(brfValidation);
                break;
			case "227":
                List<Object[]> result190 = brfValidationsRepo.getCheckSrlNo227(convertDate);
                if (!result190.isEmpty()) {
                    brfValidation.setCur_status("Y");
                    brfValidation.setRemarks2("CORPORATE BONDS/ SUKUKS  - > 3 YEARS ARE EQUAL");
                    status = "0";
                } else {
                    brfValidation.setCur_status("N");
                    brfValidation.setRemarks2("CORPORATE BONDS/ SUKUKS  - > 3 YEARS ARE NOT EQUAL");
                    status = "2";
                }
                brfValidationsRepo.save(brfValidation);
                break;
			case "228":
                List<Object[]> result191 = brfValidationsRepo.getCheckSrlNo228(convertDate);
                if (!result191.isEmpty()) {
                    brfValidation.setCur_status("Y");
                    brfValidation.setRemarks2("INVESTMENT IN EQUITIES - UNQUOTED  - > 3 YEARS ARE EQUAL");
                    status = "0";
                } else {
                    brfValidation.setCur_status("N");
                    brfValidation.setRemarks2("INVESTMENT IN EQUITIES - UNQUOTED  - > 3 YEARS ARE NOT EQUAL");
                    status = "2";
                }
                brfValidationsRepo.save(brfValidation);
                break;
			case "229":
                List<Object[]> result192 = brfValidationsRepo.getCheckSrlNo229(convertDate);
                if (!result192.isEmpty()) {
                    brfValidation.setCur_status("Y");
                    brfValidation.setRemarks2("GOVERNMENT AND PUBLIC SECTOR  - > 3 YEARS ARE EQUAL");
                    status = "0";
                } else {
                    brfValidation.setCur_status("N");
                    brfValidation.setRemarks2("GOVERNMENT AND PUBLIC SECTOR  - > 3 YEARS ARE NOT EQUAL");
                    status = "2";
                }
                brfValidationsRepo.save(brfValidation);
                break;
			case "230":
                List<Object[]> result193 = brfValidationsRepo.getCheckSrlNo230(convertDate);
                if (!result193.isEmpty()) {
                    brfValidation.setCur_status("Y");
                    brfValidation.setRemarks2("OTHER ASSETS1 - 15 DAYS - 1 MONTH ARE EQUAL");
                    status = "0";
                } else {
                    brfValidation.setCur_status("N");
                    brfValidation.setRemarks2("OTHER ASSETS1 - 15 DAYS - 1 MONTH ARE NOT EQUAL");
                    status = "2";
                }
                brfValidationsRepo.save(brfValidation);
                break;
			case "231":
                List<Object[]> result194 = brfValidationsRepo.getCheckSrlNo231(convertDate);
                if (!result194.isEmpty()) {
                    brfValidation.setCur_status("Y");
                    brfValidation.setRemarks2("OTHER ASSETS1 - 1 - 3 MONTHS ARE EQUAL");
                    status = "0";
                } else {
                    brfValidation.setCur_status("N");
                    brfValidation.setRemarks2("OTHER ASSETS1 - 1 - 3 MONTHS ARE NOT EQUAL");
                    status = "2";
                }
                brfValidationsRepo.save(brfValidation);
                break;
			case "232":
                List<Object[]> result195 = brfValidationsRepo.getCheckSrlNo232(convertDate);
                if (!result195.isEmpty()) {
                    brfValidation.setCur_status("Y");
                    brfValidation.setRemarks2("OTHER ASSETS1 - 3 - 6 MONTHS ARE EQUAL");
                    status = "0";
                } else {
                    brfValidation.setCur_status("N");
                    brfValidation.setRemarks2("OTHER ASSETS1 - 3 - 6 MONTHS ARE NOT EQUAL");
                    status = "2";
                }
                brfValidationsRepo.save(brfValidation);
                break;
			case "233":
                List<Object[]> result196 = brfValidationsRepo.getCheckSrlNo233(convertDate);
                if (!result196.isEmpty()) {
                    brfValidation.setCur_status("Y");
                    brfValidation.setRemarks2("OTHER ASSETS1  - 6 - 12 MONTHS ARE EQUAL");
                    status = "0";
                } else {
                    brfValidation.setCur_status("N");
                    brfValidation.setRemarks2("OTHER ASSETS1  - 6 - 12 MONTHS ARE NOT EQUAL");
                    status = "2";
                }
                brfValidationsRepo.save(brfValidation);
                break;
			case "234":
                List<Object[]> result197 = brfValidationsRepo.getCheckSrlNo234(convertDate);
                if (!result197.isEmpty()) {
                    brfValidation.setCur_status("Y");
                    brfValidation.setRemarks2("DEPOSITS FROM AND BALANCES DUE TO OVERSEAS BANKS - 0 - 7 DAYS ARE EQUAL");
                    status = "0";
                } else {
                    brfValidation.setCur_status("N");
                    brfValidation.setRemarks2("DEPOSITS FROM AND BALANCES DUE TO OVERSEAS BANKS - 0 - 7 DAYS ARE NOT EQUAL");
                    status = "2";
                }
                brfValidationsRepo.save(brfValidation);
                break;
			case "235":
                List<Object[]> result198 = brfValidationsRepo.getCheckSrlNo235(convertDate);
                if (!result198.isEmpty()) {
                    brfValidation.setCur_status("Y");
                    brfValidation.setRemarks2("DEPOSITS FROM AND BALANCES DUE TO OVERSEAS BANKS - 8 - 14 DAYS ARE EQUAL");
                    status = "0";
                } else {
                    brfValidation.setCur_status("N");
                    brfValidation.setRemarks2("DEPOSITS FROM AND BALANCES DUE TO OVERSEAS BANKS - 8 - 14 DAYS ARE NOT EQUAL");
                    status = "2";
                }
                brfValidationsRepo.save(brfValidation);
                break;
			case "236":
                List<Object[]> result199 = brfValidationsRepo.getCheckSrlNo236(convertDate);
                if (!result199.isEmpty()) {
                    brfValidation.setCur_status("Y");
                    brfValidation.setRemarks2("DEPOSITS FROM AND BALANCES DUE TO OVERSEAS BANKS - 15 DAYS - 1 MONTH ARE EQUAL");
                    status = "0";
                } else {
                    brfValidation.setCur_status("N");
                    brfValidation.setRemarks2("DEPOSITS FROM AND BALANCES DUE TO OVERSEAS BANKS - 15 DAYS - 1 MONTH ARE NOT EQUAL");
                    status = "2";
                }
                brfValidationsRepo.save(brfValidation);
                break;
			case "237":
                List<Object[]> result200 = brfValidationsRepo.getCheckSrlNo237(convertDate);
                if (!result200.isEmpty()) {
                    brfValidation.setCur_status("Y");
                    brfValidation.setRemarks2("DEPOSITS FROM AND BALANCES DUE TO OVERSEAS BANKS - 1 - 3 MONTHS ARE EQUAL");
                    status = "0";
                } else {
                    brfValidation.setCur_status("N");
                    brfValidation.setRemarks2("DEPOSITS FROM AND BALANCES DUE TO OVERSEAS BANKS - 1 - 3 MONTHS ARE NOT EQUAL");
                    status = "2";
                }
                brfValidationsRepo.save(brfValidation);
                break;
			case "238":
                List<Object[]> result201 = brfValidationsRepo.getCheckSrlNo238(convertDate);
                if (!result201.isEmpty()) {
                    brfValidation.setCur_status("Y");
                    brfValidation.setRemarks2("DEPOSITS FROM AND BALANCES DUE TO OVERSEAS BANKS - 3 - 6 MONTHS  ARE EQUAL");
                    status = "0";
                } else {
                    brfValidation.setCur_status("N");
                    brfValidation.setRemarks2("DEPOSITS FROM AND BALANCES DUE TO OVERSEAS BANKS - 3 - 6 MONTHS  ARE NOT EQUAL");
                    status = "2";
                }
                brfValidationsRepo.save(brfValidation);
                break;
			case "239":
                List<Object[]> result202 = brfValidationsRepo.getCheckSrlNo239(convertDate);
                if (!result202.isEmpty()) {
                    brfValidation.setCur_status("Y");
                    brfValidation.setRemarks2("DEPOSITS FROM AND BALANCES DUE TO OVERSEAS BANKS - 6 - 12 MONTHS  ARE EQUAL");
                    status = "0";
                } else {
                    brfValidation.setCur_status("N");
                    brfValidation.setRemarks2("DEPOSITS FROM AND BALANCES DUE TO OVERSEAS BANKS - 6 - 12 MONTHS  ARE NOT EQUAL");
                    status = "2";
                }
                brfValidationsRepo.save(brfValidation);
                break;
			case "240":
                List<Object[]> result203 = brfValidationsRepo.getCheckSrlNo240(convertDate);
                if (!result203.isEmpty()) {
                    brfValidation.setCur_status("Y");
                    brfValidation.setRemarks2("CAPITAL MARKET INSTRUMENTS - 0 - 7 DAYS ARE EQUAL");
                    status = "0";
                } else {
                    brfValidation.setCur_status("N");
                    brfValidation.setRemarks2("CAPITAL MARKET INSTRUMENTS - 0 - 7 DAYS  ARE NOT EQUAL");
                    status = "2";
                }
                brfValidationsRepo.save(brfValidation);
                break;
			case "241":
                List<Object[]> result204 = brfValidationsRepo.getCheckSrlNo241(convertDate);
                if (!result204.isEmpty()) {
                    brfValidation.setCur_status("Y");
                    brfValidation.setRemarks2("OTHER LIABILITIES - 3 - 6 MONTHS ARE EQUAL");
                    status = "0";
                } else {
                    brfValidation.setCur_status("N");
                    brfValidation.setRemarks2("OTHER LIABILITIES - 3 - 6 MONTHS  ARE NOT EQUAL");
                    status = "2";
                }
                brfValidationsRepo.save(brfValidation);
                break;
			case "242":
                List<Object[]> result205 = brfValidationsRepo.getCheckSrlNo242(convertDate);
                if (!result205.isEmpty()) {
                    brfValidation.setCur_status("Y");
                    brfValidation.setRemarks2("PROVISIONS - 0 - 7 DAYS ARE EQUAL");
                    status = "0";
                } else {
                    brfValidation.setCur_status("N");
                    brfValidation.setRemarks2("PROVISIONS - 0 - 7 DAYS  ARE NOT EQUAL");
                    status = "2";
                }
                brfValidationsRepo.save(brfValidation);
                break;
			case "243":
				//obj=brfValidationsRepo.getCheckSrlNo1(report_date);
			
				if(brfValidationsRepo.getCheckSrlNo243(convertDate)>0){
					brfValidation.setCur_status("Y");
					brfValidation.setRemarks2("Data Available for Current Report");
					brfValidationsRepo.save(brfValidation);	
					status="0";
				}else {
					brfValidation.setCur_status("N");
					brfValidation.setRemarks2("Generate Treasury Data for Current Report");
					brfValidationsRepo.save(brfValidation);
					status="2";
				}
				break;
			case "244":
				//obj=brfValidationsRepo.getCheckSrlNo1(report_date);
			
				if(brfValidationsRepo.getCheckSrlNo244(convertDate)>0){
					brfValidation.setCur_status("N");
					brfValidation.setRemarks2("Unmapped Accounts Available");
					brfValidationsRepo.save(brfValidation);	
					status="1";
				}else {
					brfValidation.setCur_status("Y");
					brfValidation.setRemarks2("No Unmapped Accounts");
					brfValidationsRepo.save(brfValidation);
					status="0";
				}
				break;
			case "245":
				//obj=brfValidationsRepo.getCheckSrlNo1(report_date);
			
				if(brfValidationsRepo.getCheckSrlNo245(convertDate)>0){
					brfValidation.setCur_status("Y");
					brfValidation.setRemarks2("Data Available for Current Report");
					brfValidationsRepo.save(brfValidation);	
					status="0";
				}else {
					brfValidation.setCur_status("N");
					brfValidation.setRemarks2("Generate Summary for Current Report");
					brfValidationsRepo.save(brfValidation);
					status="2";
				}
				break;
            default:
                logger.warn("Unhandled srl_no: {}", srl_no);
                msg.setGenID("0");
                msg.setStatus("Unhandled validation type");
                return msg;
        }

        if (status.equals("0")) {
            msg.setGenID("1");
            msg.setStatus("Validation Success");
        } else if (status.equals("2")) {
            msg.setGenID("1");
            msg.setStatus("Validation Failed");
        }
    } catch (Exception e) {
        logger.error("Exception occurred: {}", e.getMessage(), e);
        msg.setGenID("0");
        msg.setStatus("Validation error");
    }

    return msg;
}

};