package com.bornfire.xbrl.entities.BRBS;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BRF069_SUMMARY_C_REP extends JpaRepository<BRF069_SUMMARY_C_ENTITY, BRF069IDCLASS>{
	@Query(value = "select * from BRF69_SUMMARYTABLE_C where REPORT_DATE=?1 order by srl_no", nativeQuery = true)
	List<BRF069_SUMMARY_C_ENTITY> getBRF069reportService(Date asondate);
	
	@Query(value =  "select * from BRF69_SUMMARYTABLE_C WHERE srl_no = ?1 ", nativeQuery = true)
	BRF069_SUMMARY_C_ENTITY   getsrl_no(String  srl_no);
	
	@Query(value = "select * from BRF69_SUMMARYTABLE_C", nativeQuery = true)
	List<BRF069_SUMMARY_C_ENTITY> getBRF069reportServicedata();
}
