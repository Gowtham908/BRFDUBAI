package com.bornfire.xbrl.entities.BRBS;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BRF300AServiceRepo extends JpaRepository<BRF300_ENTITY, Date> {

	@Query(value = "select * from BRF300_SUMMARYTABLE where REPORT_DATE=?1", nativeQuery = true)
	List<BRF300_ENTITY> getBRF300AReportService(Date d1);

	@Query(value = "select * from BRF300_SUMMARYTABLE where REPORT_DATE=?1", nativeQuery = true)
	BRF300_ENTITY getBRF300AReport(Date d1);

}
