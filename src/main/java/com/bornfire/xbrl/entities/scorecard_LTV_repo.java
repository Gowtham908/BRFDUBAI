package com.bornfire.xbrl.entities;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface scorecard_LTV_repo  extends JpaRepository<scorecard_LTV_Entity, BigDecimal> {
	
	@Query(value = "select * from scorecard_LIT ", nativeQuery = true)
	List<scorecard_LTV_Entity> getLTD();
}
