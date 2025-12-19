package com.bornfire.xbrl.entities.BRBS;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BRF094AServiceRepo extends JpaRepository<BRF094_SUMMARYENTITY1, Date> {
	
	
	
	@Query(value = "select * from BRF094A_SUMMARYTABLE where REPORT_DATE=?1", nativeQuery = true)
	List<BRF094_SUMMARYENTITY1> getBRF094ReportService(Date d1);
	
	

}
