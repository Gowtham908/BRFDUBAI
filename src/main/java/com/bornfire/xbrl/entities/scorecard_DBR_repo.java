package com.bornfire.xbrl.entities;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
@Repository
public interface scorecard_DBR_repo extends JpaRepository<Scorecard_DBR_Entity, BigDecimal> {
	@Query(value = "select * from SCORECARD_DBR ", nativeQuery = true)
	List<Scorecard_DBR_Entity> getDBRlist();
	
	@Query(value = "select * from SCORECARD_DBR where group_dbr=?1 ", nativeQuery = true)
	List<Scorecard_DBR_Entity> getDBR(String group);
	

}

