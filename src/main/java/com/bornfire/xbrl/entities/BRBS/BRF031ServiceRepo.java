package com.bornfire.xbrl.entities.BRBS;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BRF031ServiceRepo extends JpaRepository<BRF31_Entity, Date>{
	@Query(value = "select * from BRF31_SUMMARYTABLE where report_code =?1 and repdesc =?2", nativeQuery = true)
	List<BRF31_Entity> getBRF031REPORTSERVICE(String reportid,String repdesc);

}