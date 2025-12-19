package com.bornfire.xbrl.entities.BRBS;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BRF038ServiceRepo extends JpaRepository<BRF38_ENTITY1, Date> {
    
    @Query(value = "SELECT FREQUENCY, REPORT_DATE, REPORT_CODE " +
                   "FROM BRF38A_SUMMARYTABLE " +
                   "WHERE REPORT_CODE = ?1 AND REPDESC = ?2 " +
                   "UNION " +
                   "SELECT FREQUENCY, REPORT_DATE, REPORT_CODE " +
                   "FROM BRF38B_SUMMARYTABLE " +
                   "WHERE REPORT_CODE = ?1 AND REPDESC = ?2", nativeQuery = true)
    List<Object[]> getBRF038EPORTSERVICE(String reportId, String repDesc);
}
