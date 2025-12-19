package com.bornfire.xbrl.entities.BRBS;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BRF040ServiceRepo extends JpaRepository<BRF40_Entity1, Date> {

    // Query for BRF40A_SUMMARYTABLE
    @Query(value = "select * from BRF40A_SUMMARYTABLE where report_code =?1 and repdesc =?2", nativeQuery = true)
    List<BRF40_Entity1> getBRF040AREPORTSERVICE(String reportid, String repdesc);

    // Query for BRF40B_SUMMARYTABLE
    @Query(value = "select * from BRF40B_SUMMARYTABLE where report_code =?1 and repdesc =?2", nativeQuery = true)
    List<BRF40_Entity2> getBRF040BREPORTSERVICE(String reportid, String repdesc);
}
