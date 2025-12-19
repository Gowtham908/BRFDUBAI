package com.bornfire.xbrl.entities.BRBS;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BRF034ServiceRepo  extends JpaRepository<BRF34_ENTITY, Date>{
	@Query(value = "select * from BRF34_SUMMARYTABLE where report_code =?1 and repdesc =?2", nativeQuery = true)
	List<BRF34_ENTITY> getBRF034REPORTSERVICE(String reportid,String repdesc);
}