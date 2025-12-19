package com.bornfire.xbrl.entities.BRBS;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BRF049ServiceRepo extends JpaRepository<BRF49_Entity, Date>{
	@Query(value = "select * from BRF49_SUMMARYTABLE where report_code =?1 and repdesc =?2", nativeQuery = true)
	List<BRF49_Entity> getBRF049REPORTSERVICE(String reportid,String repdesc);

}