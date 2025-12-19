package com.bornfire.xbrl.entities.BRBS;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BRF009ServiceRepo extends JpaRepository<BRF9_ENTITY, Date>{
	@Query(value = "select * from BRF9_SUMMARYTABLE where report_code =?1 and repdesc =?2", nativeQuery = true)
	List<BRF9_ENTITY> getBRF009REPORTSERVICE(String reportid,String repdesc);

}
