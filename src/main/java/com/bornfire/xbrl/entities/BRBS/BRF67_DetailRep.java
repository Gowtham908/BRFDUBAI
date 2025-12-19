package com.bornfire.xbrl.entities.BRBS;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BRF67_DetailRep extends JpaRepository<BRF67_DETAIL_ENTITY, String> {
	@Query(value = "SELECT * FROM  BRF67_DETAILTABLE WHERE foracid =?1", nativeQuery = true)
	BRF67_DETAIL_ENTITY getallDetails(String foracid);

}
