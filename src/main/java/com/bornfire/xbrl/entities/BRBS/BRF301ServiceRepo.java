package com.bornfire.xbrl.entities.BRBS;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BRF301ServiceRepo extends JpaRepository<BRF301_entity, BRF301IDCLASS> {

	@Query(value = "Select distinct FREQUENCY,REPORT_DATE,REPORT_CODE from BRF301_SUMMARYTABLE where report_code =?1 and repdesc =?2", nativeQuery = true)
	List<Object[]> getBRF301EPORTSERVICE(String reportid, String repdesc);
}