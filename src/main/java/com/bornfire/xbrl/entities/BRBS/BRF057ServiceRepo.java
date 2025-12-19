package com.bornfire.xbrl.entities.BRBS;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BRF057ServiceRepo extends JpaRepository<BRF57_ENTITY, Date>{
	@Query(value = "select * from BRF_057 where REPORT_DATE=?1", nativeQuery = true)
	List<BRF57_ENTITY> getBRF057reportService(Date d1);


		@Query(value = "Select distinct FREQUENCY,REPORT_DATE,REPORT_CODE from BRF57_SUMMARYTABLE where report_code =?1 and repdesc =?2", nativeQuery = true)
		List<Object[]> getBRF057REPORTSERVICE(String reportid,String repdesc);

	}
