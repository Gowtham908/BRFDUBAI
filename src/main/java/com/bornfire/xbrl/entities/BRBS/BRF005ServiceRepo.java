package com.bornfire.xbrl.entities.BRBS;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BRF005ServiceRepo extends JpaRepository<BRF05_ENTITY1   , BRF05IDCLASS>{
	@Query(value = "SELECT FREQUENCY, REPORT_DATE, REPORT_CODE " +
            "FROM BRF5A_SUMMARYTABLE " +
            "WHERE REPORT_CODE = ?1 AND REPDESC = ?2 " +
            "UNION " +
            "SELECT FREQUENCY, REPORT_DATE, REPORT_CODE " +
            "FROM BRF5B_SUMMARYTABLE " +
            "WHERE REPORT_CODE = ?1 AND REPDESC = ?2 " +
            "UNION " +
            "SELECT FREQUENCY, REPORT_DATE, REPORT_CODE " +
            "FROM BRF5C_SUMMARYTABLE " +
            "WHERE REPORT_CODE = ?1 AND REPDESC = ?2", nativeQuery = true)
List<Object[]> getBRF005REPORTSERVICE(String reportId, String repDesc);




}
