package com.bornfire.xbrl.entities.BRBS;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BRF107AServiceRepo extends JpaRepository<BRF_107_A_REPORT_ENTITY, Date> {
	
	
	
	@Query(value = "select * from BRF_107_A where REPORT_DATE=?1", nativeQuery = true)
	List<BRF_107_A_REPORT_ENTITY> getBRF107AReportService(Date d1);

	@Query(value = "select * from BRF107_SUMMARYTABLE where report_code =?1 and repdesc =?2", nativeQuery = true)
	List<BRF_107_A_REPORT_ENTITY> getBRF107REPORTSERVICE(String reportid, String repdesc);
}