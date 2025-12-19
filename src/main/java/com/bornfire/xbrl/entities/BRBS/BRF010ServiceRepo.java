package com.bornfire.xbrl.entities.BRBS;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BRF010ServiceRepo extends JpaRepository<BRF10_ENTITY, Date>{
	@Query(value = "select * from BRF10_SUMMARYTABLE where report_code =?1 and repdesc =?2", nativeQuery = true)
	List<BRF10_ENTITY> getBRF010REPORTSERVICE(String reportid,String repdesc);

}