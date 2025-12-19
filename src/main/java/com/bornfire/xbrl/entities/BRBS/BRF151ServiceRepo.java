package com.bornfire.xbrl.entities.BRBS;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BRF151ServiceRepo extends JpaRepository<BRF151reportentity, Date>{
	@Query(value = "select * from BRF_151_OFF_BALANCE_SHEET_TABLE where REPORT_DATE=?1", nativeQuery = true)
	List<BRF151reportentity> getBRF151reportService(Date d1);
	
	@Query(value = "select * from BRF151_SUMMARYTABLE where report_code =?1 and repdesc =?2", nativeQuery = true)
	List<BRF151reportentity> getBRF151REPORTSERVICE(String reportid,String repdesc);
}
