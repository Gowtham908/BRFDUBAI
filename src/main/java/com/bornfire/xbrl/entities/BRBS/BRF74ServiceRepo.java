package com.bornfire.xbrl.entities.BRBS;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BRF74ServiceRepo extends JpaRepository<BRF74_ENTITY, Date> {
	
	
	@Query(value = "select * from BRF74_SUMMARYTABLE where report_code =?1 and repdesc =?2", nativeQuery = true)
	List<BRF74_ENTITY> getBRF074REPORTSERVICE(String reportid,String repdesc);
	
}
