package com.bornfire.xbrl.entities.BRBS;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BRF205ServiceRepo extends JpaRepository<BRF205A_A1_RPT, Date>{
	

    ///// Query for BRF204A_SUMMARYTABLE AND BRF204B_SUMMARYTABLE
    @Query(value = "SELECT t1.*, t2.* " +
            "FROM BRF205A_SUMMARYTABLE t1 " +
            "JOIN BRF205B_SUMMARYTABLE t2 " +
            "ON t1.REPORT_DATE = t2.REPORT_DATE " +
            "WHERE t1.report_code = ?1 AND t1.repdesc = ?2", 
    nativeQuery = true)
List<BRF205A_A1_RPT> getBRF205REPORTSERVICE(String reportid, String repdesc);

}
