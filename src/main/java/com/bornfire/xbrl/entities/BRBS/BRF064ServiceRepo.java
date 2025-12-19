package com.bornfire.xbrl.entities.BRBS;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BRF064ServiceRepo extends JpaRepository< BRF64_Entity, Date>{
	 
	@Query(value = "select * from BRF64_SUMMARYTABLE where report_code =?1 and repdesc =?2", nativeQuery = true)
	List<BRF64_Entity> getBRF064REPORTSERVICE(String reportid,String repdesc);
}
