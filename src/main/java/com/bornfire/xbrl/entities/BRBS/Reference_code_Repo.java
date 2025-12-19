package com.bornfire.xbrl.entities.BRBS;


import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface Reference_code_Repo extends JpaRepository<Reference_code_Entity,String >{
	
	@Query(value = "SELECT * FROM CUSTOMER_MASTER_TABLE FETCH FIRST 50 ROWS ONLY", nativeQuery = true)
	List<Reference_code_Entity> getreferencedetails();
	
	@Query(value = "select * from CUSTOMER_MASTER_TABLE where acct_number!=null", nativeQuery = true)
	List<Reference_code_Entity> getreferencedetails1();
	
	@Query(value = "select * from CUSTOMER_MASTER_TABLE where cust_id is not null  FETCH FIRST 50 ROWS ONLY", nativeQuery = true)
	List<Reference_code_Entity> finduserlistcustomer();
	
	@Query(value = "select * from CUSTOMER_MASTER_TABLE where acct_number is not null  FETCH FIRST 50 ROWS ONLY", nativeQuery = true)
	List<Reference_code_Entity> finduserlistcustomer1();

	@Query(value = "select * from CUSTOMER_MASTER_TABLE where cust_id=?1 ", nativeQuery = true)
	Reference_code_Entity geteditcustomer(String cust_id);

	@Query(value = "select * from CUSTOMER_MASTER_TABLE where cust_id=?1 ", nativeQuery = true)
	Reference_code_Entity findByTran(String cust_id);

	
}
