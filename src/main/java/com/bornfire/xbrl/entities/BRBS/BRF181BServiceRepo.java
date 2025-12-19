package com.bornfire.xbrl.entities.BRBS;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BRF181BServiceRepo extends JpaRepository<BRF_181_A2_REPORT_ENTITY, Date> {
	
	
	
	
	  @Query(value = "select * from BRF181B_SUMMARYTABLE where REPORT_DATE=?1", nativeQuery =
	  true) List<BRF_181_A2_REPORT_ENTITY> getBRF181AReportService(Date d1);
	 

	@Query(value = "select * from BRF181B_SUMMARYTABLE where REPORT_DATE=?1", nativeQuery = true)
	BRF_181_A2_REPORT_ENTITY getBRF181Report(Date d1);
}
