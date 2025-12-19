package com.bornfire.xbrl.entities.BRBS;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;



public interface BRF206ServiceRepo extends JpaRepository<BRF206A_RPT, Date>{
	@Query(value = "select * from BRF206_SUMMARYTABLE where report_code =?1 and repdesc =?2", nativeQuery = true)
	List<BRF206A_RPT> getBRF206REPORTSERVICE(String reportid,String repdesc);

}
