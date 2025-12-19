package com.bornfire.xbrl.entities.BRBS;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BRF059ServiceRepo extends JpaRepository<BRF59A_ENTITY, Date>{
	
	@Query(value = "SELECT FREQUENCY, REPORT_DATE, REPORT_CODE " +
            "FROM BRF59A_SUMMARYTABLE " +
            "WHERE REPORT_CODE = ?1 AND REPDESC = ?2 " +
            "UNION " +
            "SELECT FREQUENCY, REPORT_DATE, REPORT_CODE " +
            "FROM BRF59B_SUMMARYTABLE " +
            "WHERE REPORT_CODE = ?1 AND REPDESC = ?2 " +
            "UNION " +
            "SELECT FREQUENCY, REPORT_DATE, REPORT_CODE " +
            "FROM BRF59C_SUMMARYTABLE " +
            "WHERE REPORT_CODE = ?1 AND REPDESC = ?2 " +
            "UNION " +
            "SELECT FREQUENCY, REPORT_DATE, REPORT_CODE " +
            "FROM BRF59D_SUMMARYTABLE " +
            "WHERE REPORT_CODE = ?1 AND REPDESC = ?2 " +
            "UNION " +
            "SELECT FREQUENCY, REPORT_DATE, REPORT_CODE " +
            "FROM BRF59E_SUMMARYTABLE " +
            "WHERE REPORT_CODE = ?1 AND REPDESC = ?2", nativeQuery = true)
List<Object[]> getBRF059REPORTSERVICE(String reportId, String repDesc);

}
