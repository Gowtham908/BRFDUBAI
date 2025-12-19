package com.bornfire.xbrl.entities.BRBS;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BRF208ServiceRepo extends JpaRepository<BRF208_Entity1, Date>{
	

    ///// Query for BRF204A_SUMMARYTABLE AND BRF204B_SUMMARYTABLE
    @Query(value = "SELECT t1.*, t2.* " +
            "FROM BRF208_SUMMARYTABLE1 t1 " +
            "JOIN BRF208_SUMMARYTABLE2 t2 " +
            "ON t1.REPORT_DATE = t2.REPORT_DATE " +
            "WHERE t1.report_code = ?1 AND t1.repdesc = ?2", 
    nativeQuery = true)
List<BRF208_Entity1> getBRF208REPORTSERVICE(String reportid, String repdesc);

}

