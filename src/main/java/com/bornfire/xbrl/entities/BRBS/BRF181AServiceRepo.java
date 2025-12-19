package com.bornfire.xbrl.entities.BRBS;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BRF181AServiceRepo extends JpaRepository<BRF_181_A1_REPORT_ENTITY, Date> {
	
	
	
	@Query(value = "select * from BRF_181_A1 where REPORT_DATE=?1", nativeQuery = true)
	List<BRF_181_A1_REPORT_ENTITY> getBRF181AReportService(Date d1);

	@Query(value = "select * from BRF_181_A1 where REPORT_DATE=?1", nativeQuery = true)
	BRF_181_A1_REPORT_ENTITY getBRF181Report(Date d1);
	
///// Query for BRF181A_SUMMARYTABLE AND BRF181B_SUMMARYTABLE
    @Query(value = "SELECT t1.*, t2.* " +
            "FROM BRF181A_SUMMARYTABLE t1 " +
            "JOIN BRF181B_SUMMARYTABLE t2 " +
            "ON t1.REPORT_DATE = t2.REPORT_DATE " +
            "WHERE t1.report_code = ?1 AND t1.repdesc = ?2", 
    nativeQuery = true)
List<BRF_181_A1_REPORT_ENTITY> getBRF181REPORTSERVICE(String reportid, String repdesc);
}
