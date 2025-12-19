package com.bornfire.xbrl.entities.BRBS;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BRF084ServiceRepo extends JpaRepository<BRF84A_ENTITY, Date> {
    
    @Query(value = "SELECT FREQUENCY, REPORT_DATE, REPORT_CODE " +
                   "FROM BRF84A_SUMMARYTABLE " +
                   "WHERE REPORT_CODE = ?1 AND REPDESC = ?2 " +
                   "UNION " +
                   "SELECT FREQUENCY, REPORT_DATE, REPORT_CODE " +
                   "FROM BRF84B_SUMMARYTABLE " +
                   "WHERE REPORT_CODE = ?1 AND REPDESC = ?2", nativeQuery = true)
    List<Object[]> getBRF084REPORTSERVICE(String reportId, String repDesc);
}
