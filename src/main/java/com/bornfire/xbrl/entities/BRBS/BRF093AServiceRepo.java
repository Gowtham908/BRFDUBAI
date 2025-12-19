package com.bornfire.xbrl.entities.BRBS;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BRF093AServiceRepo extends JpaRepository<BRF93_SUMMARYENTITY2, Date> {
	
	
	
	@Query(value = "select * from BRF93A_SUMMARYTABLE where REPORT_DATE=?1", nativeQuery = true)
	List<BRF93_SUMMARYENTITY2> getBRF093AReportService(Date d1);

}
