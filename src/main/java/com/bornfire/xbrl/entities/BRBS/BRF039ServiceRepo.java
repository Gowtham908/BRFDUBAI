package com.bornfire.xbrl.entities.BRBS;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BRF039ServiceRepo extends JpaRepository<BRF39_ENTITY, String> {
    
	@Query(value = "Select distinct FREQUENCY,REPORT_DATE,REPORT_CODE from BRF39_SUMMARYTABLE where report_code =?1 and repdesc =?2", nativeQuery = true)
	List<Object[]> getBRF039EPORTSERVICE(String reportid,String repdesc);
}
