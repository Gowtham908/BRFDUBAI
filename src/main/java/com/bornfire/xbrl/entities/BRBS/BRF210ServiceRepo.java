package com.bornfire.xbrl.entities.BRBS;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;



public interface BRF210ServiceRepo extends JpaRepository<BRF210_ENTITY, Date>{
	@Query(value = "select * from BRF210_SUMMARYTABLE where report_code =?1 and repdesc =?2", nativeQuery = true)
	List<BRF210_ENTITY> getBRF210REPORTSERVICE(String reportid,String repdesc);

}
