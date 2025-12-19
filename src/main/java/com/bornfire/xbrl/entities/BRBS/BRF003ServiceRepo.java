package com.bornfire.xbrl.entities.BRBS;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BRF003ServiceRepo extends JpaRepository<BRF003_ENTITY   , Date>{
	@Query(value = "select * from BRF3_SUMMARYTABLE where report_code =?1 and repdesc =?2", nativeQuery = true)
	List<BRF003_ENTITY> getBRF003REPORTSERVICE(String reportid,String repdesc);

}
