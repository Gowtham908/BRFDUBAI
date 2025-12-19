package com.bornfire.xbrl.entities.BRBS;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface BRF56ServiceRepo  extends JpaRepository<BRF56_ENTITY1   , Date>{
	@Query(value = "select * from BRF_056_A1 where REPORT_DATE=?1", nativeQuery = true)
	List<BRF56_ENTITY1   > getBRF56reportService(Date d1);
	
	@Query(value = "SELECT t1.*, t2.* " +
            "FROM BRF56A_SUMMARYTABLE t1 " +
            "JOIN BRF56B_SUMMARYTABLE t2 " +
            "ON t1.REPORT_DATE = t2.REPORT_DATE " +
            "WHERE t1.report_code = ?1 AND t1.repdesc = ?2", 
    nativeQuery = true)
	List<BRF56_ENTITY1> getBRF056REPORTSERVICE(String reportid, String repdesc);
}
