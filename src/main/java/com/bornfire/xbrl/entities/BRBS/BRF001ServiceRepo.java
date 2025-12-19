package com.bornfire.xbrl.entities.BRBS;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BRF001ServiceRepo extends JpaRepository<BRF1_REPORT_ENTITY   , Date>{
	@Query(value = "select * from BRF1_SUMMARYTABLE where report_code =?1 and repdesc =?2", nativeQuery = true)
	List<BRF1_REPORT_ENTITY> getBRF001REPORTSERVICE(String reportid,String repdesc);

}
