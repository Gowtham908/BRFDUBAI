package com.bornfire.xbrl.entities.BRBS;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BRF156_ENTITY1REP extends JpaRepository<BRF156_ENTITY1, String>{
	
	@Query(value="select * from BRF156_SUMMARYTABLE1 where trunc(report_date)=?1",nativeQuery=true)
	List<Object[]> findllvalues(String reportdate);
	
}
