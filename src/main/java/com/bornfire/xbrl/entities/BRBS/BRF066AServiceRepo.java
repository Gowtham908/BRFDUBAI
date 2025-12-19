package com.bornfire.xbrl.entities.BRBS;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BRF066AServiceRepo extends JpaRepository<BRF66_Entity, Date> {
	
	@Query(value = "select * from BRF66_SUMMARYTABLE where report_date=?1", nativeQuery = true)
	List<BRF66_Entity> findAllData(String date);

	@Query(value = "select * from BRF66_SUMMARYTABLE where REPORT_DATE=?1", nativeQuery = true)
	Optional<BRF66_Entity> getBRF66AReport(Date d1);
	
	@Query(value = "select * from BRF66_SUMMARYTABLE where report_code =?1 and repdesc =?2", nativeQuery = true)
	List<BRF66_Entity> getBRF066REPORTSERVICE(String reportid,String repdesc);

}
