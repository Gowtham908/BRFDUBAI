package com.bornfire.xbrl.entities.BRBS;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BRF033ServiceRepo  extends JpaRepository<BRF33_ENTITY, Date>{
	@Query(value = "select * from BRF33_SUMMARYTABLE where report_code =?1 and repdesc =?2", nativeQuery = true)
	List<BRF33_ENTITY> getBRF033REPORTSERVICE(String reportid,String repdesc);
}
