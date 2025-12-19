package com.bornfire.xbrl.entities.BRBS;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;



public interface BRF9_DetaiRep1  extends JpaRepository<BRF9_DETAIL_ENTITY, String> {
	@Query(value = "SELECT * FROM  brf9_detail_table WHERE foracid =?1", nativeQuery = true)
	BRF9_DETAIL_ENTITY getallDetails(String foracid);
}
