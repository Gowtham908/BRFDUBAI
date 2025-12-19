package com.bornfire.xbrl.entities.BRBS;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BRF300ServiceRepo extends JpaRepository<BRF300_ENTITY , Date>{
	

	@Query(value = "select * from BRF300_SUMMARYTABLE where report_code =?1 and repdesc =?2", nativeQuery = true)
	List<BRF300_ENTITY> getBRF300REPORTSERVICE(String reportid,String repdesc);
	
}