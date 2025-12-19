package com.bornfire.xbrl.entities.BRBS;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BRF59DetailRep extends JpaRepository<BRF59_DETAIL_ENTITY, String> {
	@Query(value = "SELECT * FROM BRF59A_DETAILTABLE WHERE foracid = ?1 AND report_addl_criteria_1 = ?2 AND country = ?3", nativeQuery = true)
	BRF59_DETAIL_ENTITY findByCustomCriteria(
       String foracid,
       String report_addl_criteria_1,
       String country
    );
 
}