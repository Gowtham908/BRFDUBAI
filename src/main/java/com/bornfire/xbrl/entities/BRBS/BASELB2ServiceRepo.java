package com.bornfire.xbrl.entities.BRBS;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BASELB2ServiceRepo extends JpaRepository<BASEL_B2_REPORT_ENTITY, Date> {
	
	
	
	@Query(value = "select * from BASEL_B2 where REPORT_DATE=?1", nativeQuery = true)
	List<BASEL_B2_REPORT_ENTITY> getBASEL002AReportService(Date d1);


}
