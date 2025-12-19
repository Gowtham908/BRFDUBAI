package com.bornfire.xbrl.entities.BRBS;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BRF044ServiceRepo extends JpaRepository<BRF44_ENTITY, Date>{
	@Query(value = "select * from BRF44_SUMMARYTABLE where report_code =?1 and repdesc =?2", nativeQuery = true)
	List<BRF44_ENTITY> getBRF044REPORTSERVICE(String reportid,String repdesc);

}