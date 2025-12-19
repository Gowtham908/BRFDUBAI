package com.bornfire.xbrl.entities.BRBS;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BRF64ServiceRepo extends JpaRepository< BRF64_Entity, Date> {
	@Query(value = "select * from BRF_64_BANKING_AND_MONETARY_STATISTICS_TABLE where REPORT_DATE=?1", nativeQuery = true)
	List< BRF64_Entity> getBRF64reportService(Date d1);

}




	

