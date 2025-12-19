package com.bornfire.xbrl.entities.BRBS;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BRF155_ENTITY_REP extends JpaRepository<BRF155_ENTITY, Date>{
	
	@Query(value="select * from BRF155_SUMMARYTABLE where trunc(report_date)=?1 order by deal_date asc",nativeQuery=true)
	List<Object[]> findllvalues(String reportdate);
}
	