package com.bornfire.xbrl.entities.BRBS;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BRF108ServiceRepo extends JpaRepository<BRF108_ENTITY, BRF108IDCLASS> {

	@Query(value = "Select distinct FREQUENCY,REPORT_DATE,REPORT_CODE from BRF108_SUMMARYTABLE where report_code =?1 and repdesc =?2", nativeQuery = true)
	List<Object[]> getBRF108EPORTSERVICE(String reportid, String repdesc);
}