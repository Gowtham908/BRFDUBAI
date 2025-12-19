package com.bornfire.xbrl.entities;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
@Repository
public interface Personal_INCOME_Repo extends JpaRepository<Personal_INCOME_Entity, BigDecimal> {
	@Query(value = "select * from PERSONAL_INCOME_TABLE ", nativeQuery = true)
	List<Personal_INCOME_Entity> getDBRlist();
	
	@Query(value = "select * from PERSONAL_INCOME_TABLE where group_dbr=?1 ", nativeQuery = true)
	List<Personal_INCOME_Entity> getDBR(String group);
	

}

