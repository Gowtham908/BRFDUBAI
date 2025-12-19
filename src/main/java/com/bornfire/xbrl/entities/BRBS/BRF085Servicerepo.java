package com.bornfire.xbrl.entities.BRBS;


import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BRF085Servicerepo extends JpaRepository<BRF85_ENTITY, Date> {

	@Query(value = "Select distinct FREQUENCY,REPORT_DATE,REPORT_CODE from BRF85_SUMMARYTABLE where report_code =?1 and repdesc =?2", nativeQuery = true)
	List<Object[]> getBRF085REPORTSERVICE(String reportid, String repdesc);
}