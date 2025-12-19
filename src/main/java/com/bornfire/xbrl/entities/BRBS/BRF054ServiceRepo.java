package com.bornfire.xbrl.entities.BRBS;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/*public interface BRF054ServiceRepo extends JpaRepository<BRF54_ENTITY   , Date>{
	@Query(value = "select * from BRF_054 where REPORT_DATE=?1", nativeQuery = true)
	List<BRF54_ENTITY   > getBRF054reportService(Date d1);*/

public interface BRF054ServiceRepo extends JpaRepository<BRF54_ENTITY, Date>{
	@Query(value = "select * from BRF54_SUMMARYTABLE where report_code =?1 and repdesc =?2", nativeQuery = true)
	List<BRF54_ENTITY> getBRF054REPORTSERVICE(String reportid,String repdesc);

}
