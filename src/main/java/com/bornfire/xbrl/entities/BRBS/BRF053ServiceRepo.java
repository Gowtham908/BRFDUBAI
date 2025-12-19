package com.bornfire.xbrl.entities.BRBS;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


	
public interface BRF053ServiceRepo extends JpaRepository<BRF53_ENTITY, Date>{
	@Query(value = "select * from BRF53_SUMMARYTABLE where report_code =?1 and repdesc =?2", nativeQuery = true)
	List<BRF53_ENTITY> getBRF053REPORTSERVICE(String reportid,String repdesc);
	


}
