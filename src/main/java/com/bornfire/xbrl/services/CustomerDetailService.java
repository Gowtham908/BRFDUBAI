package com.bornfire.xbrl.services;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Query;
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

import com.bornfire.xbrl.entities.BRBS.AUD_SERVICES_ENTITY;
import com.bornfire.xbrl.entities.BRBS.RBSTransactionMasterEntity;
import com.bornfire.xbrl.entities.BRBS.RBSTransactionMasterRep;

@Service
@Transactional
@ConfigurationProperties("output")
public class CustomerDetailService {
	private static final Logger logger = LoggerFactory.getLogger(CustomerDetailService.class);

	@Autowired
	SessionFactory sessionFactory;

	@Autowired
	DataSource srcdataSource;
	
	@Autowired
	Environment env;
	
	@Autowired
	com.bornfire.xbrl.entities.BRBS.AUD_SERVICE_REPO AUD_SERVICE_REPO;
	
	@Autowired
	RBSTransactionMasterRep rbsTransactionMasterRep;
	
	public String detailChanges(RBSTransactionMasterEntity detail, Character changeType, String userid,Date todate,
			String username,String MOB,String ROLE,String custid,String userid1 ) {
		String msg = "";
				try {
			
			Session hs = sessionFactory.getCurrentSession();
			Query qr = hs.createNativeQuery("select RBSTRANSACTIONMASTER_SRL_NUM.NEXTVAL from DUAL");
			if (changeType.equals('A')) {
				
			
				detail.setTran_date(new Date());
				detail.setDel_flg('N'); 
				//Date d="31-MAR-23";
			
				AUD_SERVICES_ENTITY auds = new AUD_SERVICES_ENTITY();	
				auds.setEntryid_add(userid);
				auds.setEntry_name_add(userid);
				auds.setCreate_cust_id(detail.getCust_id());
				auds.setDate_add(new Date());
				auds.setDesignation_add(detail.getCust_type());
				auds.setRemarks_add("");
				detail.setReport_date(todate);
				
				AUD_SERVICE_REPO.save(auds);
				BigDecimal srlNum = (BigDecimal) qr.getSingleResult(); 
				detail.setSrl_num(srlNum);
				hs.save(detail);
				
				logger.info("Added Record");
				msg = "Added Successfully";
				
				
			} else if (changeType.equals('E')) {
				hs.update(detail);
				
				logger.info("Edited Record");
				msg = "Edited Successfully";
				System.out.println("edit start");
               AUD_SERVICES_ENTITY auds = new AUD_SERVICES_ENTITY();
               BigDecimal jj = new BigDecimal(9090);
               auds.setSl_no(jj);
				Date currentDate = new Date();
				auds.setDate_edit(currentDate);
				auds.setEntryid_edit(userid1);
				auds.setEntry_name_edit(username);
                BigDecimal srl_num =detail.getSrl_num();
				RBSTransactionMasterEntity up = rbsTransactionMasterRep.getallDetails(srl_num);

				if(!detail.getCust_id().equals(up.getCust_id())) {
					auds.setNEW_VALUE_EDIT(detail.getCust_id());
					auds.setOLD_VALUE_EDIT(up.getCust_id());
				}
				else if(!detail.getCust_name().equals(up.getCust_name())) {
					auds.setNEW_VALUE_EDIT(detail.getCust_name());
					auds.setOLD_VALUE_EDIT(up.getCust_name());
				}
				else if(!detail.getCust_type().equals(up.getCust_type())) {
					auds.setNEW_VALUE_EDIT(detail.getCust_type());
					auds.setOLD_VALUE_EDIT(up.getCust_type());
				}
				else if(!detail.getCust_rating().equals(up.getCust_rating())) {
					auds.setNEW_VALUE_EDIT(detail.getCust_rating());
					auds.setOLD_VALUE_EDIT(up.getCust_rating());
				}
				else if(!detail.getAcct_no().equals(up.getAcct_no())) {
					auds.setNEW_VALUE_EDIT(detail.getAcct_no());
					auds.setOLD_VALUE_EDIT(up.getAcct_no());
				}
				else if(!detail.getAcct_name().equals(up.getAcct_name())) {
					auds.setNEW_VALUE_EDIT(detail.getAcct_name());
					auds.setOLD_VALUE_EDIT(up.getAcct_name());
				}
				else if(!detail.getTran_type().equals(up.getTran_type())) {
					auds.setNEW_VALUE_EDIT(detail.getTran_type());
					auds.setOLD_VALUE_EDIT(up.getTran_type());
				}
				else if(!detail.getTran_sub_type().equals(up.getTran_sub_type())) {
					auds.setNEW_VALUE_EDIT(detail.getTran_sub_type());
					auds.setOLD_VALUE_EDIT(up.getTran_sub_type());
				}
				else if(!detail.getTran_date().equals(up.getTran_date())) {
					auds.setNEW_VALUE_EDIT(detail.getTran_date().toString());
					auds.setOLD_VALUE_EDIT(up.getTran_date().toString());
				}
				else if(!detail.getTran_id().equals(up.getTran_id())) {
					auds.setNEW_VALUE_EDIT(detail.getTran_id());
					auds.setOLD_VALUE_EDIT(up.getTran_id());
				}
				else if(!detail.getPart_tran_id().equals(up.getPart_tran_id())) {
					auds.setNEW_VALUE_EDIT(detail.getPart_tran_id().toString());
					auds.setOLD_VALUE_EDIT(up.getPart_tran_id().toString());
				}
				else if(!detail.getPart_tran_type().equals(up.getPart_tran_type())) {
					auds.setNEW_VALUE_EDIT(detail.getPart_tran_type());
					auds.setOLD_VALUE_EDIT(up.getPart_tran_type());
				}
				else if(!detail.getTran_crncy().equals(up.getTran_crncy())) {
					auds.setNEW_VALUE_EDIT(detail.getTran_crncy());
					auds.setOLD_VALUE_EDIT(up.getTran_crncy());
				}
				else if(!detail.getTran_amt().equals(up.getTran_amt())) {
					auds.setNEW_VALUE_EDIT(detail.getTran_amt().toString());
					auds.setOLD_VALUE_EDIT(up.getTran_amt().toString());
				}
				else if(!detail.getTran_category().equals(up.getTran_category())) {
					auds.setNEW_VALUE_EDIT(detail.getTran_category());
					auds.setOLD_VALUE_EDIT(up.getTran_category());
				}
				else
				{
					System.out.println("not edited");
				}
				AUD_SERVICE_REPO.save(auds);
				
			} else if (changeType.equals('D')) {
				
				//detail.setCust_id(userid);
				//detail.setTran_date(new Date());
				detail.setDel_flg('Y'); 
				AUD_SERVICES_ENTITY auds = new AUD_SERVICES_ENTITY();
				
				auds.setDelete_cust_id(detail.getCust_id());
				auds.setDelete_cust_name(detail.getCust_name());
				auds.setDesignation_delete(detail.getCust_type());
			//	Date currentDate = new Date();
				auds.setDate_delete(detail.getTran_date());
				auds.setEntryid_delete(userid);
				auds.setEntry_name_delete(username);
				auds.setRemarks_delete("Deleted Successfully");
				
				auds.setAudit_date(auds.getDate_delete());
				auds.setEntry_id(auds.getEntryid_delete());
				auds.setEntry_name(auds.getEntry_name_delete());
				auds.setFunction("DELETE");
				auds.setAuthorizer("-");
				auds.setFeild_name("-");
				auds.setOld_value("-");
				auds.setNew_value("-");;
				auds.setRemarks(auds.getDelete_cust_id()+"(Deleted Successfully)");
                System.out.println("completed");				
               // BigDecimal srl_num =detail.getSrl_num();
				//RBSTransactionMasterEntity up = rbsTransactionMasterRep.getallDetails(srl_num);
	
				AUD_SERVICE_REPO.save(auds);
				hs.delete(detail);

				logger.info("Deleted Record");
				msg = "Deleted Successfully";				
				
			}

		} catch (Exception e) {

			msg = "error occured. Please contact Administrator";
			e.printStackTrace();
		}

		return msg;
	}


}
