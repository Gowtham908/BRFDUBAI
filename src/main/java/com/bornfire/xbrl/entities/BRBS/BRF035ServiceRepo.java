package com.bornfire.xbrl.entities.BRBS;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BRF035ServiceRepo extends JpaRepository<BRF35_ENTITY, Date> {
	
	@Query(value = "Select distinct FREQUENCY,REPORT_DATE,REPORT_CODE from BRF35_SUMMARYTABLE where report_code =?1 and repdesc =?2", nativeQuery = true)
	List<Object[]> getBRF035EPORTSERVICE(String reportid,String repdesc);
	
	

}



