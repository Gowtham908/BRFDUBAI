package com.bornfire.xbrl.entities.BRBS;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BRF011ServiceRepo extends JpaRepository<BRF11_ENTITY, Date>{
	@Query(value = "select * from BRF11_SUMMARYTABLE where report_code =?1 and repdesc =?2", nativeQuery = true)
	List<BRF11_ENTITY> getBRF011REPORTSERVICE(String reportid,String repdesc);

}