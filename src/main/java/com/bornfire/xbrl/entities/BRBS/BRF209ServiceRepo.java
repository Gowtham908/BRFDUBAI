package com.bornfire.xbrl.entities.BRBS;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BRF209ServiceRepo extends JpaRepository<BRF209_Entity1, Date>{
	

    ///// Query for BRF209_SUMMARYTABLE1 AND BRF209_SUMMARYTABLE2
    @Query(value = "SELECT t1.*, t2.* " +
            "FROM BRF209_SUMMARYTABLE1 t1 " +
            "JOIN BRF209_SUMMARYTABLE2 t2 " +
            "ON t1.REPORT_DATE = t2.REPORT_DATE " +
            "WHERE t1.report_code = ?1 AND t1.repdesc = ?2", 
    nativeQuery = true)
List<BRF209_Entity1> getBRF209REPORTSERVICE(String reportid, String repdesc);

}