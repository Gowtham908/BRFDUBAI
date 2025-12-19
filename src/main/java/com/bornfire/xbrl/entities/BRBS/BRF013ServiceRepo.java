package com.bornfire.xbrl.entities.BRBS;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BRF013ServiceRepo extends JpaRepository<BRF13_ENTITY, Date>{
	@Query(value = "select * from BRF13_SUMMARYTABLE where report_code =?1 and repdesc =?2", nativeQuery = true)
	List<BRF13_ENTITY> getBRF013REPORTSERVICE(String reportid,String repdesc);

}