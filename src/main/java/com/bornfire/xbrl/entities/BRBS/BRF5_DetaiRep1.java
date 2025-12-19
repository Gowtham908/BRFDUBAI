

package com.bornfire.xbrl.entities.BRBS;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BRF5_DetaiRep1 extends JpaRepository<BRF5_Detail_Entity, String> {
	@Query(value = "SELECT * FROM  BRF5_DETAILTABLE WHERE foracid =?1", nativeQuery = true)
	BRF5_Detail_Entity getallDetails(String foracid);
	@Query(value = "SELECT * FROM BRF5_DETAILTABLE WHERE foracid = ?1 AND report_addl_criteria_2 = ?2 ", nativeQuery = true)
	BRF5_Detail_Entity findByCustomCriteria(
       String foracid,
       String report_addl_criteria_2
    );

}
