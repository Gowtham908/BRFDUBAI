package com.bornfire.xbrl.entities.BRBS;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BRF103AServiceRepo extends JpaRepository<BRF103_ENTITY, Date> {
	
	
	
	@Query(value = "select * from BRF103_SUMMARYTABLE where REPORT_DATE=?1", nativeQuery = true)
	Optional<BRF103_ENTITY> getBRF103AReport(Date d1);

	@Query(value = "select * from BRF103_SUMMARYTABLE where report_code =?1 and repdesc =?2", nativeQuery = true)
	List<BRF103_ENTITY> getBRF103REPORTSERVICE(String reportid, String repdesc);
}