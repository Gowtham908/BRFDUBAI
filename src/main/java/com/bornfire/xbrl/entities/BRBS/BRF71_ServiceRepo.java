package com.bornfire.xbrl.entities.BRBS;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import org.springframework.stereotype.Repository;
@Repository
public interface BRF71_ServiceRepo extends JpaRepository<BRF71_ENTITY, Date>{

	@Query(value="SELECT * FROM brf71_summarytable WHERE REPORT_DATE= ?1",nativeQuery = true)
    BRF71_ENTITY findByReportDate( String REPORT_DATE);
	
	@Query(value = "select * from brf71_summarytable where REPORT_DATE=?1", nativeQuery = true)
	BRF71_ENTITY getBRF71AReport(Date d1);
	
    @Query(value = "select * from BRF71_SUMMARYTABLE where report_code =?1 and repdesc =?2", nativeQuery = true)
	List<BRF71_ENTITY> getBRF071REPORTSERVICE(String reportid,String repdesc);
	
}