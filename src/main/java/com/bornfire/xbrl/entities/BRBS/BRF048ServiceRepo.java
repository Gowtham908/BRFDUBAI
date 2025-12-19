package com.bornfire.xbrl.entities.BRBS;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BRF048ServiceRepo extends JpaRepository<BRF48_Entity, Date>{
	@Query(value = "select * from BRF48_SUMMARYTABLE where report_code =?1 and repdesc =?2", nativeQuery = true)
	List<BRF48_Entity> getBRF048REPORTSERVICE(String reportid,String repdesc);

}