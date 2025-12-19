package com.bornfire.xbrl.entities.BRBS;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BRF152ServiceRepo extends JpaRepository<BRF152_Entity , Date>{
	@Query(value = "select * from BRF_152_TABLE where REPORT_DATE=?1", nativeQuery = true)
	List<BRF152_Entity > getBRF152reportService(Date d1);

	@Query(value = "select * from BRF152_SUMMARYTABLE where report_code =?1 and repdesc =?2", nativeQuery = true)
	List<BRF152_Entity> getBRF152REPORTSERVICE(String reportid,String repdesc);
	
}
