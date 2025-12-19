package com.bornfire.xbrl.entities.BRBS;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BRF67ServiceRepo extends JpaRepository< BRF67_ENTITY, Date>{
	/*
	 * @Query(value =
	 * "select * from BRF_67_BANKING_AND_MONETARY_STATISTICS_TABLE where REPORT_DATE=?1"
	 * , nativeQuery = true) List< BRF67_ENTITY> getBRF67reportService(Date d1);
	 */

	@Query(value = "select * from BRF67_SUMMARYTABLE where report_code =?1 and repdesc =?2", nativeQuery = true)
	List<BRF67_ENTITY> getBRF067REPORTSERVICE(String reportid,String repdesc);
}
