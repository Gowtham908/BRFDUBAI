package com.bornfire.xbrl.entities.BRBS;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BRF041ServiceRepo extends JpaRepository<BRF41_Entity1, Date>{
	@Query(value = "select * from BRF41A_SUMMARYTABLE where report_code =?1 and repdesc =?2", nativeQuery = true)
	List<BRF41_Entity1> getBRF041REPORTSERVICE(String reportid,String repdesc);

}