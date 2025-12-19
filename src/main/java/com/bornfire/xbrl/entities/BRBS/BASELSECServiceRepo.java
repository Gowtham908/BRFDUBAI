package com.bornfire.xbrl.entities.BRBS;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BASELSECServiceRepo extends JpaRepository<BASEL_SEC_REPORT_ENTITY, Date> {
	
	@Query(value = "select * from BASEL_SECURITIZATION where REPORT_DATE=?1", nativeQuery = true)
	List<BASEL_SEC_REPORT_ENTITY> getBASELSECReportService(Date d1);

}
