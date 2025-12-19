package com.bornfire.xbrl.entities.BRBS;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BRF65ServiceRepo extends JpaRepository< BRF65_Entity, Date>{
	/*
	 * @Query(value =
	 * "select * from BANKING_AND_MONETARY_STATISTICS_RESCHEDULED_LOANS_BRF65_TABLE where REPORT_DATE=?1"
	 * , nativeQuery = true) List< BRF65_Entity> getBRF65reportService(Date d1);
	 */
	@Query(value = "select * from BRF65_SUMMARYTABLE where report_code =?1 and repdesc =?2", nativeQuery = true)
	List<BRF65_Entity> getBRF065REPORTSERVICE(String reportid,String repdesc);
}
