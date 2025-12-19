package com.bornfire.xbrl.entities.BRBS;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BRF104AServiceRepo extends JpaRepository<BRF104_REPORTENTITY, Date> {
	
	
	
	@Query(value = "select * from BRF_104_A where REPORT_DATE=?1", nativeQuery = true)
	List<BRF104_REPORTENTITY> getBRF104AReportService(Date d1);

	@Query(value = "select * from BRF104_SUMMARYTABLE where report_code =?1 and repdesc =?2", nativeQuery = true)
	List<BRF104_REPORTENTITY> getBRF104REPORTSERVICE(String reportid, String repdesc);
}