package com.bornfire.xbrl.entities.BRBS;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BRF105AServiceRepo extends JpaRepository<BRF105_ENTITY1, Date> {
	
	
	
	@Query(value = "select * from BRF_105_A1 where REPORT_DATE=?1", nativeQuery = true)
	List<BRF105_ENTITY1> getBRF105ReportService(Date d1);

	 ///// Query for BRF50A_SUMMARYTABLE AND BRF50B_SUMMARYTABLE
    @Query(value = "SELECT t1.*, t2.* " +
            "FROM BRF105A_SUMMARYTABLE t1 " +
            "JOIN BRF105B_SUMMARYTABLE t2 " +
            "ON t1.REPORT_DATE = t2.REPORT_DATE " +
            "WHERE t1.report_code = ?1 AND t1.repdesc = ?2", 
    nativeQuery = true)
List<BRF105_ENTITY1> getBRF105REPORTSERVICE(String reportid, String repdesc);

}

