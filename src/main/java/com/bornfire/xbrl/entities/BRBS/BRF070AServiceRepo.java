package com.bornfire.xbrl.entities.BRBS;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BRF070AServiceRepo extends JpaRepository<BRF70_ENTITY, Date> {
	
	@Query(value = "select * from BRF70_SUMMARYTABLE where REPORT_DATE=?1", nativeQuery = true)
	List<BRF70_ENTITY> getBRF070AReportService(Date asondate);
	
	@Query(value = "select * from BRF70_SUMMARYTABLE where REPORT_DATE=?1", nativeQuery = true)
	BRF70_ENTITY getBRF070AReport(Date d1);
	
	@Query(value = "select * from BRF70_SUMMARYTABLE where report_code =?1 and repdesc =?2", nativeQuery = true)
	List<BRF70_ENTITY> getBRF070REPORTSERVICE(String reportid, String repdesc);
}
