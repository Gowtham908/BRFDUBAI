package com.bornfire.xbrl.entities.BRBS;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bornfire.xbrl.entities.TransactionMasterTable;
import com.bornfire.xbrl.entities.UserProfile;
@Repository
public interface RBSTransactionMasterRepo extends JpaRepository<RBSTransactionMasterEntity, BigDecimal> {
	
	//public Optional<RBSTransactionMasterEntity> findBycusid(String cus_id);
	/*
	 * @Query(value = "select * from  TRAN_MASTER_DETAIL", nativeQuery = true)
	 * List<TransactionMasterTable> findbyid(String cust_id);
	 */
	
	@Query(value = "select * from  TRAN_MASTER_DETAIL where srl_num=?1 ", nativeQuery = true)
	RBSTransactionMasterEntity getCusidDetail(BigDecimal srl_num);	
}
