package com.bornfire.xbrl.entities.BRBS;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BRF05_REP3 extends JpaRepository<BRF05_ENTITY3,BRF05IDCLASS> {
	@Query(value = "select * from BRF5C_SUMMARYTABLE where REPORT_DATE=?1 order by srl_no", nativeQuery = true)
	List<BRF05_ENTITY3> getBRF005reportService(Date asondate);

	@Query(value = "select * from BRF5C_SUMMARYTABLE WHERE   srl_no = ?1 ", nativeQuery = true)
	BRF05_ENTITY3 getsrl_no(String srl_no);
	
	@Query(value="SELECT * from  BRF5C_SUMMARYTABLE a where a.report_date = ?1",nativeQuery=true)
	List<Object[]> findallvalues(String to_date);
}