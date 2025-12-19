package com.bornfire.xbrl.entities.BRBS;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BRF05_REP1 extends JpaRepository<BRF05_ENTITY1, BRF05IDCLASS>{
	@Query(value = "select * from BRF5A_SUMMARYTABLE where REPORT_DATE=?1 order by srl_no", nativeQuery = true)
	List<BRF05_ENTITY1> getBRF005reportService(Date asondate);
	
	@Query(value =  "select * from BRF5A_SUMMARYTABLE WHERE   srl_no = ?1 ", nativeQuery = true)
	BRF05_ENTITY1   getsrl_no(String  srl_no);

	
}
