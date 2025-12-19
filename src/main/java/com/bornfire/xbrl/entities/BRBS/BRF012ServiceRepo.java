package com.bornfire.xbrl.entities.BRBS;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BRF012ServiceRepo extends JpaRepository<BRF12_ENTITY, Date>{
	@Query(value = "select * from BRF12_SUMMARYTABLE where report_code =?1 and repdesc =?2", nativeQuery = true)
	List<BRF12_ENTITY> getBRF012REPORTSERVICE(String reportid,String repdesc);

}