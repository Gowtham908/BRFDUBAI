package com.bornfire.xbrl.entities.BRBS;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BRF068ServiceRepo extends JpaRepository<BRF68_Entity1   , Date>{
	@Query(value = "select * from BRF_068_A1 where REPORT_DATE=?1", nativeQuery = true)
	List<BRF68_Entity1   > getBRF068reportService(Date d1);
	
	
	@Query(value = "SELECT t1.*, t2.* " +
            "FROM BRF68A_SUMMARYTABLE t1 " +
            "JOIN BRF68B_SUMMARYTABLE t2 " +
            "ON t1.REPORT_DATE = t2.REPORT_DATE " +
            "WHERE t1.report_code = ?1 AND t1.repdesc = ?2", 
    nativeQuery = true)
	List<BRF68_Entity1> getBRF068REPORTSERVICE(String reportid, String repdesc);
}


