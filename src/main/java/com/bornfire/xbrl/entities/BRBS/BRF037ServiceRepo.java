package com.bornfire.xbrl.entities.BRBS;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BRF037ServiceRepo extends JpaRepository<BRF37, Date>{
	@Query(value = "select * from BRF37_SUMMARYTABLE where report_code =?1 and repdesc =?2", nativeQuery = true)
	List<BRF37> getBRF037REPORTSERVICE(String reportid,String repdesc);
}