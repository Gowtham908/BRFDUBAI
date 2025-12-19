package com.bornfire.xbrl.entities.BRBS;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BRF99AServiceRepo extends JpaRepository<BRF_99_A_REPORT_ENTITY, Date> {
	
	
	
	@Query(value = "select * from BRF_99_A where REPORT_DATE=?1", nativeQuery = true)
	List<BRF_99_A_REPORT_ENTITY> getBRF101AReportService(Date d1);

}



