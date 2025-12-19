package com.bornfire.xbrl.entities;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ECL_MAPPING_CONST_DEC_REP extends JpaRepository<ECL_MAPPING_CONST_DEC, String> { 
	@Query(value = "select * from ECL_MAPPING_CUST_CONST_CODE", nativeQuery = true)
	List<ECL_MAPPING_CONST_DEC> getconstdes();
	
	

}
