package com.bornfire.xbrl.entities.BRBS;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BRF093Servicerepo extends JpaRepository<BRF93_SUMMARYENTITY1, Date> {
	@Query(value = "SELECT FREQUENCY, REPORT_DATE, REPORT_CODE " + "FROM BRF93A_SUMMARYTABLE "
			+ "WHERE REPORT_CODE = ?1 AND REPDESC = ?2 " + "UNION " + "SELECT FREQUENCY, REPORT_DATE, REPORT_CODE "
			+ "FROM BRF93B_SUMMARYTABLE " + "WHERE REPORT_CODE = ?1 AND REPDESC = ?2 " + "UNION "
			+ "SELECT FREQUENCY, REPORT_DATE, REPORT_CODE " + "FROM BRF93C_SUMMARYTABLE "
			+ "WHERE REPORT_CODE = ?1 AND REPDESC = ?2 " + "UNION " + "SELECT FREQUENCY, REPORT_DATE, REPORT_CODE "
			+ "FROM BRF93D_SUMMARYTABLE " + "WHERE REPORT_CODE = ?1 AND REPDESC = ?2 " + "UNION "
			+ "SELECT FREQUENCY, REPORT_DATE, REPORT_CODE " + "FROM BRF93E_SUMMARYTABLE "
			+ "WHERE REPORT_CODE = ?1 AND REPDESC = ?2 " + "UNION " + "SELECT FREQUENCY, REPORT_DATE, REPORT_CODE "
			+ "FROM BRF93F_SUMMARYTABLE " + "WHERE REPORT_CODE = ?1 AND REPDESC = ?2", nativeQuery = true)
	List<Object[]> getBRF093REPORTSERVICE(String reportId, String repDesc);
}
