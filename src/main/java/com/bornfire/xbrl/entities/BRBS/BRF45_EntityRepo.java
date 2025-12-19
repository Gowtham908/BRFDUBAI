package com.bornfire.xbrl.entities.BRBS;

import java.util.List;
import java.util.List;
import java.util.Date;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface BRF45_EntityRepo extends JpaRepository<BRF45_Entity3, String> {
	@Query(value = "select * from BRF45C_SUMMARYTABLE", nativeQuery = true)
	List<Object[]> getReportSummaryC(String to_date);
	
	@Query(value = "select * from BRF45C_SUMMARYTABLE where trunc(report_date)=?1", nativeQuery = true)
	List<Object[]> getReportSummaryC1(String todate);
}
