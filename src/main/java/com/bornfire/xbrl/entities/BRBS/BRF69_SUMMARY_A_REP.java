package com.bornfire.xbrl.entities.BRBS;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BRF69_SUMMARY_A_REP extends JpaRepository<BRF69_SUMMARY_A_ENTITY, BRF069IDCLASS> {
	
	@Query(value = "select * from BRF69_SUMMARYTABLE_A where REPORT_DATE=?1 order by srl_no", nativeQuery = true)
	List<BRF69_SUMMARY_A_ENTITY> getBRF069reportService(Date asondate);
	
	@Query(value =  "select * from BRF69_SUMMARYTABLE_A WHERE srl_no = ?1 ", nativeQuery = true)
	BRF69_SUMMARY_A_ENTITY   getsrl_no(String  srl_no);

	@Query(value = "select * from BRF69_SUMMARYTABLE_A", nativeQuery = true)
	List<BRF69_SUMMARY_A_ENTITY> getBRF069reportServicedata();
}
