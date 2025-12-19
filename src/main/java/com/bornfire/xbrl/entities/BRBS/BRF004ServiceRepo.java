package com.bornfire.xbrl.entities.BRBS;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BRF004ServiceRepo extends JpaRepository<BRF4_ENTITY   , Date>{
	@Query(value = "select * from BRF4_SUMMARYTABLE where report_code =?1 and repdesc =?2", nativeQuery = true)
	List<BRF4_ENTITY> getBRF004REPORTSERVICE(String reportid,String repdesc);

}
