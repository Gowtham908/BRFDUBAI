package com.bornfire.xbrl.entities.BRBS;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BRF007ServiceRepo extends JpaRepository<BRF7_ENTITY, Date>{
	@Query(value = "select * from BRF7_SUMMARYTABLE where report_code =?1 and repdesc =?2", nativeQuery = true)
	List<BRF7_ENTITY> getBRF007REPORTSERVICE(String reportid,String repdesc);

}