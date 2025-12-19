package com.bornfire.xbrl.entities.BRBS;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BRF93_Detailrep  extends JpaRepository<BRF93_DETAIL_ENTITY, String> {
	@Query(value = "SELECT * FROM BRF93A_DETAILTABLE WHERE foracid = ?1 AND report_addl_criteria_2 = ?2 AND purpose_of_rem = ?3", nativeQuery = true)
    BRF93_DETAIL_ENTITY findByCustomCriteria(
       String foracid,
       String report_addl_criteria_2,
       String purpose_of_rem
    );
 


}
