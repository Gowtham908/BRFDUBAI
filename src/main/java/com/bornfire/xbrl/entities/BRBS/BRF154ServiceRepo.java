package com.bornfire.xbrl.entities.BRBS;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BRF154ServiceRepo extends JpaRepository<BRF154_ENTITY, Date> {
	@Query(value = "select * from BRF_154_TABLE where REPORT_DATE=?1", nativeQuery = true)
	List<BRF154reportentity> getBRF154reportService(Date d1);

	@Query(value = "Select distinct FREQUENCY,REPORT_DATE,REPORT_CODE from BRF154_SUMMARYTABLE where report_code =?1 and repdesc =?2", nativeQuery = true)
	List<Object[]> getBRF154REPORTSERVICE(String reportid,String repdesc);
	
	

}



