package com.bornfire.xbrl.entities.BRBS;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BRF73ServiceRepo extends JpaRepository<BRF73A_ENTITY, Date> {
	
	
	
	@Query(value = "select * from BRF73A_ENTITY where REPORT_DATE=?1", nativeQuery = true)
	List<BRF73A_ENTITY> getBRF73ReportService(Date d1);
	
	@Query(value = "select * from BRF73A_SUMMARYTABLE where report_code =?1 and repdesc =?2", nativeQuery = true)
	List<BRF73A_ENTITY> getBRF073REPORTSERVICE(String reportid,String repdesc);
	
	
}
	
	   
