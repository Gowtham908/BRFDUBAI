package com.bornfire.xbrl.entities.BRBS;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BRF069Servicerepo extends JpaRepository<BRF69_SUMMARY_A_ENTITY, BRF069IDCLASS> {
	@Query(value = "SELECT FREQUENCY, REPORT_DATE, REPORT_CODE " + "FROM BRF69_SUMMARYTABLE_A "
			+ "WHERE REPORT_CODE = ?1 AND REPDESC = ?2 " + "UNION " + "SELECT FREQUENCY, REPORT_DATE, REPORT_CODE "
			+ "FROM BRF69_SUMMARYTABLE_B " + "WHERE REPORT_CODE = ?1 AND REPDESC = ?2 " + "UNION "
			+ "SELECT FREQUENCY, REPORT_DATE, REPORT_CODE " + "FROM BRF69_SUMMARYTABLE_C "
			+ "WHERE REPORT_CODE = ?1 AND REPDESC = ?2 " + "UNION " + "SELECT FREQUENCY, REPORT_DATE, REPORT_CODE "
			+ "FROM BRF69_SUMMARYTABLE_D " + "WHERE REPORT_CODE = ?1 AND REPDESC = ?2", nativeQuery = true)
	List<Object[]> getBRF069EPORTSERVICE(String reportId, String repDesc);

}
