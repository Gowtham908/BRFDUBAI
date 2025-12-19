package com.bornfire.xbrl.entities.BRBS;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BRF002ServiceRepo extends JpaRepository<BRF2_ENTITY   , Date>{
	@Query(value = "select * from BRF2_SUMMARYTABLE where report_code =?1 and repdesc =?2", nativeQuery = true)
	List<BRF2_ENTITY> getBRF002REPORTSERVICE(String reportid,String repdesc);

}
