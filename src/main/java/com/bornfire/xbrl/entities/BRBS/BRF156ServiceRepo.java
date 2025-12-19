package com.bornfire.xbrl.entities.BRBS;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BRF156ServiceRepo extends JpaRepository<BRF156reportentity  , Date>{
	@Query(value = "select * from BRF156_TABLE where REPORT_DATE=?1", nativeQuery = true)
	List<BRF156reportentity  > getBRF156reportService(Date d1);

	@Query(value = "Select distinct FREQUENCY,REPORT_DATE,REPORT_CODE from BRF156_SUMMARYTABLE1 where report_code =?1 and repdesc =?2", nativeQuery = true)
	List<Object[]> getBRF156REPORTSERVICE(String reportid,String repdesc);

}
