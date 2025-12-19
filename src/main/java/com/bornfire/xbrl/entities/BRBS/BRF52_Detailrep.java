package com.bornfire.xbrl.entities.BRBS;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BRF52_Detailrep extends JpaRepository<BRF52_DETAIL_ENTITY, String> {
	@Query(value = "SELECT * FROM  BRF52_DETAILTABLE WHERE foracid =?1", nativeQuery = true)
	BRF52_DETAIL_ENTITY getallDetails(String foracid);
}
