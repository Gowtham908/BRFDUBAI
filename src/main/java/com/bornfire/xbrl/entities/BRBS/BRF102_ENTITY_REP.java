package com.bornfire.xbrl.entities.BRBS;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BRF102_ENTITY_REP extends JpaRepository<BRF102_Entity, BigDecimal>{
	
	@Query(value="select * from BRF102_SUMMARYTABLE where trunc(report_date)=?1",nativeQuery=true)
	List<Object[]> findllvalues(String reportdate);
}