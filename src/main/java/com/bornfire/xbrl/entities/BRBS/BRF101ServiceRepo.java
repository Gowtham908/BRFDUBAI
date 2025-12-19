package com.bornfire.xbrl.entities.BRBS;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BRF101ServiceRepo extends JpaRepository<BRF101_ENTITY, Date> {
	
	
	
	@Query(value = "select * from BRF101_SUMMARY_TABLE where REPORT_DATE=?1", nativeQuery = true)
	List<BRF101_ENTITY> getBRF101AReportService(Date d1);
	
	@Query(value = "select * from BRF101_SUMMARY_TABLE where report_code =?1 and repdesc =?2", nativeQuery = true)
	List<BRF101_ENTITY> getBRF101REPORTSERVICE(String reportid,String repdesc);

}

