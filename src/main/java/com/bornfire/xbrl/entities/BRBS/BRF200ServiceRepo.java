package com.bornfire.xbrl.entities.BRBS;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BRF200ServiceRepo  extends JpaRepository<BRF200A_A1_RPT, Date> {
		
		
		
		@Query(value = "select * from BRF200A_A1_RPT where REPORT_DATE=?1", nativeQuery = true)
		List<BRF200A_A1_RPT> getBRF200ReportService(Date d1);

		
		@Query(value = "SELECT t1.*, t2.*, t3.*, t4.* " +
	               "FROM BRF200A_SUMMARYTABLE t1 " +
	               "JOIN BRF200B_SUMMARYTABLE t2 ON t1.REPORT_DATE = t2.REPORT_DATE " +
	               "JOIN BRF200C_SUMMARYTABLE t3 ON t1.REPORT_DATE = t3.REPORT_DATE " +
	               "JOIN BRF200D_SUMMARYTABLE t4 ON t1.REPORT_DATE = t4.REPORT_DATE " +
	               "WHERE t1.report_code = ?1 AND t1.repdesc = ?2", 
	       nativeQuery = true)
	List<BRF200A_A1_RPT> getBRF200REPORTSERVICE(String reportid, String repdesc);

}
