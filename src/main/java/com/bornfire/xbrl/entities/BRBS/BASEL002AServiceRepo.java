
package com.bornfire.xbrl.entities.BRBS;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BASEL002AServiceRepo extends JpaRepository<BASEL_002_A_REPORT_ENTITY, Date> {
	
	
	
	@Query(value = "select * from BASEL_002_A where REPORT_DATE=?1", nativeQuery = true)
	List<BASEL_002_A_REPORT_ENTITY> getBASEL002AReportService(Date d1);


}
