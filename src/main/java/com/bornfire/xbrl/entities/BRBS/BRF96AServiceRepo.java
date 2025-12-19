
package com.bornfire.xbrl.entities.BRBS;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BRF96AServiceRepo extends JpaRepository<BRF_96_REPORT_ENTITY, Date> {
	
	
	
	@Query(value = "select * from BRF_96 where REPORT_DATE=?1", nativeQuery = true)
	List<BRF_96_REPORT_ENTITY> getBRF96AReportService(Date d1);
	@Query(value = "select * from BRF96_SUMMARYTABLE where report_code =?1 and repdesc =?2", nativeQuery = true)
	List<BRF_96_REPORT_ENTITY> getBRF096REPORTSERVICE(String reportid,String repdesc);
}