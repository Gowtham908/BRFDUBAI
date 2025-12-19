package com.bornfire.xbrl.entities.BRBS;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BRF094Servicerepo extends JpaRepository<BRF094_SUMMARYENTITY1, Date> {
	@Query(value = "SELECT FREQUENCY, REPORT_DATE, REPORT_CODE " + "FROM BRF094A_SUMMARYTABLE "
			+ "WHERE REPORT_CODE = ?1 AND REPDESC = ?2 " + "UNION " + "SELECT FREQUENCY, REPORT_DATE, REPORT_CODE "
			+ "FROM BRF094B_SUMMARYTABLE " + "WHERE REPORT_CODE = ?1 AND REPDESC = ?2 " + "UNION "
			+ "SELECT FREQUENCY, REPORT_DATE, REPORT_CODE " + "FROM BRF094C_SUMMARYTABLE "
			+ "WHERE REPORT_CODE = ?1 AND REPDESC = ?2 " + "UNION " + "SELECT FREQUENCY, REPORT_DATE, REPORT_CODE "
			+ "FROM BRF094D_SUMMARYTABLE " + "WHERE REPORT_CODE = ?1 AND REPDESC = ?2 " + "UNION "
			+ "SELECT FREQUENCY, REPORT_DATE, REPORT_CODE " + "FROM BRF094E_SUMMARYTABLE "
			+ "WHERE REPORT_CODE = ?1 AND REPDESC = ?2 " + "UNION " + "SELECT FREQUENCY, REPORT_DATE, REPORT_CODE "
			+ "FROM BRF094F_SUMMARYTABLE " + "WHERE REPORT_CODE = ?1 AND REPDESC = ?2", nativeQuery = true)
	List<Object[]> getBRF094REPORTSERVICE(String reportId, String repDesc);
}
