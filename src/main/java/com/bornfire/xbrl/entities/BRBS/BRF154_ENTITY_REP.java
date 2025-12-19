package com.bornfire.xbrl.entities.BRBS;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BRF154_ENTITY_REP extends JpaRepository<BRF154_ENTITY, Date>{
	
	@Query(value="select * from BRF154_SUMMARYTABLE where trunc(report_date)=?1",nativeQuery=true)
	List<Object[]> findllvalues(String reportdate);
}
	