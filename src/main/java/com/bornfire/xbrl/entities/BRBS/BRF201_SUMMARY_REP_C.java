package com.bornfire.xbrl.entities.BRBS;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BRF201_SUMMARY_REP_C extends JpaRepository<BRF201_SUMMARY_ENTITY_C, BRF201IDCLASS> {
	@Query(value = "select * from BRF201_SUMMARYTABLE_C where REPORT_DATE=?1 order by srl_no", nativeQuery = true)
	List<BRF201_SUMMARY_ENTITY_C> getBRF201reportService(Date asondate);

	@Query(value = "select * from BRF201_SUMMARYTABLE_C WHERE   srl_no = ?1 ", nativeQuery = true)
	BRF201_SUMMARY_ENTITY_C getsrl_no(String srl_no);
}
