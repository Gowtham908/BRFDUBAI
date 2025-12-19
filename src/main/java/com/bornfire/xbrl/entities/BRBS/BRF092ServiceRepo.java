package com.bornfire.xbrl.entities.BRBS;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BRF092ServiceRepo  extends JpaRepository<BRF92_TABLE, Date>{
	@Query(value = "select * from BRF92_SUMMARYTABLE where report_code =?1 and repdesc =?2", nativeQuery = true)
	List<BRF92_TABLE> getBRF092REPORTSERVICE(String reportid,String repdesc);

}

