package com.bornfire.xbrl.entities.BRBS;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BRF043ServiceRepo extends JpaRepository<BRF43A_ENTITY, Date> {

	@Query(value = "SELECT FREQUENCY, REPORT_DATE, REPORT_CODE " + "FROM BRF43A_SUMMARYTABLE "
			+ "WHERE REPORT_CODE = ?1 AND REPDESC = ?2 " + "UNION " + "SELECT FREQUENCY, REPORT_DATE, REPORT_CODE "
			+ "FROM BRF43B_SUMMARYTABLE " + "WHERE REPORT_CODE = ?1 AND REPDESC = ?2 " + "UNION "
			+ "SELECT FREQUENCY, REPORT_DATE, REPORT_CODE " + "FROM BRF5C_SUMMARYTABLE "
			+ "WHERE REPORT_CODE = ?1 AND REPDESC = ?2", nativeQuery = true)
	List<Object[]> getBRF043EPORTSERVICE(String reportId, String repDesc);
}
