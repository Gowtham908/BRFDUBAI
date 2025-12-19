package com.bornfire.xbrl.entities;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bornfire.xbrl.entities.BRF_REF_CODE_ENTITY;

@Repository
public interface BRF_REF_CODE_REP extends JpaRepository<BRF_REF_CODE_ENTITY, String> {

	@Query(value = "SELECT * FROM BRF_REF_CODE_TABLE ORDER BY REGEXP_SUBSTR(report_code, '[[:alpha:]]+'),TO_NUMBER(REGEXP_SUBSTR(report_code, '[[:digit:]]+'))", nativeQuery = true)

	List<BRF_REF_CODE_ENTITY> getLiist();

	@Query(value = "select * from BRF_REF_CODE_TABLE where report_code=?1", nativeQuery = true)

	List<BRF_REF_CODE_ENTITY> getLiist1(String report_code);

	@Query(value = "select * from BRF_REF_CODE_TABLE where report_code=?1", nativeQuery = true)
	List<Object> getLiist3(String report_code);

	@Query(value = "select * from BRF_REF_CODE_TABLE where report_code=?1", nativeQuery = true)
	List<BRF_REF_CODE_ENTITY> getLiist2(String report_code);
	
	

	
	
	
}
