package com.bornfire.xbrl.entities;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SCORE_CALCULATION_REPO extends JpaRepository<SCORE_CALCULATION_ENTITY, BigDecimal> {
	@Query(value = "select * from SCORE_CALCULATION_TABLE ", nativeQuery = true)
	List<SCORE_CALCULATION_ENTITY> getDBRlist();
	
	@Query(value = "select * from SCORE_CALCULATION_TABLE where slno=?1 ", nativeQuery = true)
	List<SCORE_CALCULATION_ENTITY> getDBR(String slno);
	
}