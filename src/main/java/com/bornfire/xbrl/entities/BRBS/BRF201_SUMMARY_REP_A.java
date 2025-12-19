package com.bornfire.xbrl.entities.BRBS;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BRF201_SUMMARY_REP_A extends JpaRepository<BRF201_SUMMARY_ENTITY_A, BRF201IDCLASS>{
	@Query(value = "select * from BRF201_SUMMARYTABLE_A where REPORT_DATE=?1 order by srl_no", nativeQuery = true)
	List<BRF201_SUMMARY_ENTITY_A> getBRF201reportService(Date asondate);
	
	@Query(value =  "select * from BRF201_SUMMARYTABLE_A WHERE   srl_no = ?1 ", nativeQuery = true)
	BRF201_SUMMARY_ENTITY_A   getsrl_no(String  srl_no);
}
