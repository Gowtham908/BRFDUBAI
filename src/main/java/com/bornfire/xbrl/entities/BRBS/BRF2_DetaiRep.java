package com.bornfire.xbrl.entities.BRBS;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BRF2_DetaiRep extends JpaRepository<BRF2_DETAIL_ENTITY, String> {
@Query(value = "SELECT * FROM  brf2_detail_table WHERE acct_no =?1", nativeQuery = true)
		BRF2_DETAIL_ENTITY getallDetails(String acct_no);
}
