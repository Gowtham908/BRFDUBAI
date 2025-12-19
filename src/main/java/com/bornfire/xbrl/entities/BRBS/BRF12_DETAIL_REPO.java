package com.bornfire.xbrl.entities.BRBS;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BRF12_DETAIL_REPO extends JpaRepository<BRF12_DETAIL_ENTITY, String> {
	@Query(value = "SELECT * FROM  brf1_detail_table WHERE acct_no =?1", nativeQuery = true)
	BRF12_DETAIL_ENTITY getallDetails(String acct_no);
}