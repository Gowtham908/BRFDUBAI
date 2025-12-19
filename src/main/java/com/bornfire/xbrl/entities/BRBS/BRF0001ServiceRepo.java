package com.bornfire.xbrl.entities.BRBS;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BRF0001ServiceRepo extends JpaRepository<BRF001_FORT_ENTITY   , Date>{
	@Query(value = "select * from BRF001_SUMMARYTABLE where report_code =?1 and repdesc =?2", nativeQuery = true)
	List<BRF001_FORT_ENTITY> getBRF001FORTSERVICE(String reportid,String repdesc);

}
