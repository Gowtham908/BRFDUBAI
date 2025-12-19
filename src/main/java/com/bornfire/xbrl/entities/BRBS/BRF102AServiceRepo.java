package com.bornfire.xbrl.entities.BRBS;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;



public interface BRF102AServiceRepo extends JpaRepository<BRF102_Entity, Date> {
	
	
	
	@Query(value = "select * from BRF102_SUMMARYTABLE where REPORT_DATE=?1", nativeQuery = true)
	List<BRF102_Entity> getBRF102AReportService(Date d1);
	
//	@Query(value = "select * from BRF102_SUMMARYTABLE where REPORT_DATE=?1", nativeQuery = true)
//	Optional<BRF102_Entity> getBRF102AReport(Date d1);
//	

}