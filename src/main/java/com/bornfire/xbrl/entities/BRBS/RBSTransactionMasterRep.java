package com.bornfire.xbrl.entities.BRBS;

import java.math.BigDecimal;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface   RBSTransactionMasterRep extends JpaRepository< RBSTransactionMasterEntity,  BigDecimal> {	

	
	@Query(value = "SELECT * FROM  TRAN_MASTER_DETAIL1 WHERE srl_num ='44'", nativeQuery = true)
	RBSTransactionMasterEntity getallDetails(BigDecimal srl_num);
	
	 @Query(value = "select RBSTRANSACTIONMASTER_SRL_NUM.nextval from dual", nativeQuery = true)
		String SrlNo();

	
	}
