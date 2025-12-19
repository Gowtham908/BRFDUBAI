package com.bornfire.xbrl.entities.BRBS;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BRF106AServiceRepo extends JpaRepository<BRF_106_A_REPORT_ENTITY, Date> {
	
	
	
	@Query(value = "select * from BRF_106_A where REPORT_DATE=?1", nativeQuery = true)
	List<BRF_106_A_REPORT_ENTITY> getBRF106AReportService(Date d1);

	@Query(value = "select * from BRF106_SUMMARYTABLE where report_code =?1 and repdesc =?2", nativeQuery = true)
	List<BRF_106_A_REPORT_ENTITY> getBRF106REPORTSERVICE(String reportid, String repdesc);
}