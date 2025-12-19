package com.bornfire.xbrl.entities.BRBS;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BRF204ServiceRepo extends JpaRepository<BRF204A_ENTITY, Date>{
	

    ///// Query for BRF204A_SUMMARYTABLE AND BRF204B_SUMMARYTABLE
    @Query(value = "SELECT t1.*, t2.* " +
            "FROM BRF204A_SUMMARYTABLE t1 " +
            "JOIN BRF204B_SUMMARYTABLE t2 " +
            "ON t1.REPORT_DATE = t2.REPORT_DATE " +
            "WHERE t1.report_code = ?1 AND t1.repdesc = ?2", 
    nativeQuery = true)
List<BRF204A_ENTITY> getBRF204REPORTSERVICE(String reportid, String repdesc);

}
