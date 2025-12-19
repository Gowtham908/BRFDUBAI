package com.bornfire.xbrl.entities.BRBS;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface BRF32ServiceRepo  extends JpaRepository<BRF32_ENTITY, Date>{
	 
	@Query(value = "select * from BRF32_SUMMARYTABLE where report_date=?1", nativeQuery = true)
	List<BRF32_ENTITY> findAllData(String date);
	@Query(value = "select * from BRF32_SUMMARYTABLE where REPORT_DATE=?1", nativeQuery = true)
	Optional<BRF32_ENTITY> getBRF32Report(Date d1);
	
	//ARCHIVAL
	@Query(value = "select * from BRF32_SUMMARYTABLE where report_code =?1 and repdesc =?2", nativeQuery = true)
	List<BRF32_ENTITY> getBRF032REPORTSERVICE(String reportid,String repdesc);

}
