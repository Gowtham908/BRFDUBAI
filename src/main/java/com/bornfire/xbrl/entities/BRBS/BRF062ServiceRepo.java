package com.bornfire.xbrl.entities.BRBS;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BRF062ServiceRepo extends JpaRepository< BRF62_Entity, Date>{
	 
	@Query(value = "select * from BRF62_SUMMARYTABLE where report_code =?1 and repdesc =?2", nativeQuery = true)
	List<BRF62_Entity> getBRF062REPORTSERVICE(String reportid,String repdesc);
}
