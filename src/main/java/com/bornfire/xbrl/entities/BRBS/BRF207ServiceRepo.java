package com.bornfire.xbrl.entities.BRBS;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;



public interface BRF207ServiceRepo extends JpaRepository<BRF207_ENTITY, Date>{
	@Query(value = "select * from BRF207_SUMMARYTABLE where report_code =?1 and repdesc =?2", nativeQuery = true)
	List<BRF207_ENTITY> getBRF207REPORTSERVICE(String reportid,String repdesc);

}
