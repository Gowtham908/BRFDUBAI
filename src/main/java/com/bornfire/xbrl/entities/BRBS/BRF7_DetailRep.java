package com.bornfire.xbrl.entities.BRBS;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BRF7_DetailRep extends JpaRepository<BRF7_DETAIL_ENTITY, String> {
	@Query(value = "SELECT * FROM  BRF7_DETAILTABLE WHERE acct_no =?1", nativeQuery = true)
	BRF7_DETAIL_ENTITY getallDetails(String acct_no);
}
