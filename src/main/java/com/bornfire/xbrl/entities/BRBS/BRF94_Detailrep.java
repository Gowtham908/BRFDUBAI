package com.bornfire.xbrl.entities.BRBS;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;



public interface BRF94_Detailrep extends JpaRepository<BRF094_DETAIL_ENTITY, String> {
	@Query(value = "SELECT * FROM BRF094A_DETAILTABLE  WHERE foracid = ?1 AND report_addl_criteria_2 = ?2 AND purpose_of_rem = ?3", nativeQuery = true)
	BRF094_DETAIL_ENTITY findByCustomCriteria(
       String foracid,
       String report_addl_criteria_2,
       String purpose_of_rem
    );
}
