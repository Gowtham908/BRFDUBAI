package com.bornfire.xbrl.entities.BRBS;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BRF045ServiceRepo extends JpaRepository<BRF45_Entity1, Date> {
    
    @Query(value = "SELECT FREQUENCY, REPORT_DATE, REPORT_CODE " +
                   "FROM BRF45A_SUMMARYTABLE " +
                   "WHERE REPORT_CODE = ?1 AND REPDESC = ?2 " +
                   "UNION " +
                   "SELECT FREQUENCY, REPORT_DATE, REPORT_CODE " +
                   "FROM BRF45B_SUMMARYTABLE " +
                   "WHERE REPORT_CODE = ?1 AND REPDESC = ?2 " +
                   "UNION " +
                   "SELECT FREQUENCY, REPORT_DATE, REPORT_CODE " +
                   "FROM BRF45C_SUMMARYTABLE " +
                   "WHERE REPORT_CODE = ?1 AND REPDESC = ?2", nativeQuery = true)
    List<Object[]> getBRF045EPORTSERVICE(String reportId, String repDesc);
}
