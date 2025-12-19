package com.bornfire.xbrl.entities.BRBS;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/*public interface BRF060ServiceRepo extends JpaRepository<BRF060Reportentity   , Date>{
	@Query(value = "select * from BRF_060 where REPORT_DATE=?1", nativeQuery = true)
	List<BRF060Reportentity   > getBRF060reportService(Date d1);*/


public interface BRF060ServiceRepo extends JpaRepository<BRF060Reportentity, Date>{
	@Query(value = "select * from BRF60_SUMMARYTABLE where report_code =?1 and repdesc =?2", nativeQuery = true)
	List<BRF060Reportentity> getBRF060REPORTSERVICE(String reportid,String repdesc);


}
