package com.bornfire.xbrl.entities.BRBS;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BRF109AServiceRepo extends JpaRepository<BRF109_ENTITY, Date> {
	

	@Query(value = "select * from BRF109_SUMMARYTABLE where report_code =?1 and repdesc =?2", nativeQuery = true)
	List<BRF109_ENTITY> getBRF109REPORTSERVICE(String reportid, String repdesc);
}
