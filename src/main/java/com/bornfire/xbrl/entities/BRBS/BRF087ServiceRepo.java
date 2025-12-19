package com.bornfire.xbrl.entities.BRBS;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BRF087ServiceRepo  extends JpaRepository<BRF87_ENTITY, Date>{
	@Query(value = "select * from BRF87_SUMMARYTABLE where report_code =?1 and repdesc =?2", nativeQuery = true)
	List<BRF87_ENTITY> getBRF087REPORTSERVICE(String reportid,String repdesc);

}
