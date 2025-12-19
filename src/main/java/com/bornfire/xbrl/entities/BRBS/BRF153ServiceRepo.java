package com.bornfire.xbrl.entities.BRBS;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BRF153ServiceRepo extends JpaRepository<BRF153ReportEntity , Date>{
	@Query(value = "select * from BRF_153_TABLE where REPORT_DATE=?1", nativeQuery = true)
	List<BRF153ReportEntity > getBRF153reportService(Date d1);

	@Query(value = "select * from BRF153_SUMMARYTABLE where report_code =?1 and repdesc =?2", nativeQuery = true)
	List<BRF153ReportEntity> getBRF153REPORTSERVICE(String reportid,String repdesc);
	
}
