package com.bornfire.xbrl.entities.BRBS;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BASELB3ServiceRepo extends JpaRepository<BASEL_B3_1_REPORT_ENTITY, Date> {
	
	
	
	@Query(value = "select * from BASEL_CREDIT_SUMMARY_6  where REPORT_DATE=?1", nativeQuery = true)
	List<BASEL_B3_1_REPORT_ENTITY> getBASELB3ReportService(Date d1);

}
