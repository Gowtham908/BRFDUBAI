package com.bornfire.xbrl.entities.BRBS;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BRF100AServiceRepo extends JpaRepository<BRF_100_A_REPORT_ENTITY, Date> {
	
	
	
	@Query(value = "select * from BRF_100_A where REPORT_DATE=?1", nativeQuery = true)
	List<BRF_100_A_REPORT_ENTITY> getBRF100AReportService(Date d1);
	
	@Query(value = "select * from BRF100_SUMMARYTABLE where report_code =?1 and repdesc =?2", nativeQuery = true)
	List<BRF_100_A_REPORT_ENTITY> getBRF100REPORTSERVICE(String reportid,String repdesc);

}
