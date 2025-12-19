package com.bornfire.xbrl.entities.BRBS;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BRF099ServiceRepo extends JpaRepository<BRF_99_A_REPORT_ENTITY, Date> {
	
	
	
	 
	
	@Query(value = "select * from BRF99_SUMMARYTABLE where report_code =?1 and repdesc =?2", nativeQuery = true)
	List<BRF_99_A_REPORT_ENTITY> getBRF099REPORTSERVICE(String reportid,String repdesc);

}

