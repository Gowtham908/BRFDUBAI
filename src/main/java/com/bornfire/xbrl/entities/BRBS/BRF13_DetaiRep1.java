package com.bornfire.xbrl.entities.BRBS;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BRF13_DetaiRep1 extends JpaRepository<BRF13_DETAIL_ENTITY, String> {
	@Query(value = "SELECT * FROM  BRF3_DETAILTABLE WHERE foracid =?1", nativeQuery = true)
	BRF13_DETAIL_ENTITY getallDetails(String foracid);
}
