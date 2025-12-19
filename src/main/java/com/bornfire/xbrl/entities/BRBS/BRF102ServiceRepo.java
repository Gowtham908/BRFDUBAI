package com.bornfire.xbrl.entities.BRBS;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BRF102ServiceRepo extends JpaRepository<BRF102_Entity, BigDecimal> {

	@Query(value = "Select distinct FREQUENCY,REPORT_DATE,REPORT_CODE from BRF102_SUMMARYTABLE where report_code =?1 and repdesc =?2", nativeQuery = true)
	List<Object[]> getBRF102EPORTSERVICE(String reportid, String repdesc);
}