package com.bornfire.xbrl.entities.BRBS;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BRF014ServiceRepo extends JpaRepository<BRF14_ENTITY, Date>{
	@Query(value = "select * from BRF14_SUMMARYTABLE where report_code =?1 and repdesc =?2", nativeQuery = true)
	List<BRF14_ENTITY> getBRF014REPORTSERVICE(String reportid,String repdesc);

}
