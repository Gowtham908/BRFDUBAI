

package com.bornfire.xbrl.entities.BRBS;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BRF101_DetaiRep extends JpaRepository<BRF101_DETAIL_ENTITY, String> {
@Query(value = "SELECT * FROM  BRF101_detail_table WHERE acct_no =?1", nativeQuery = true)
		BRF101_DETAIL_ENTITY getallDetails(String acct_no);
}
