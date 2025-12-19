package com.bornfire.xbrl.entities.BRBS;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BRF8DetailRep extends  JpaRepository<BRF8_DETAIL_ENTITY, String> {
	@Query(value = "SELECT * FROM  BRF8_DETAILTABLE WHERE acct_no =?1", nativeQuery = true)
	BRF8_DETAIL_ENTITY getallDetails(String acct_no);
}