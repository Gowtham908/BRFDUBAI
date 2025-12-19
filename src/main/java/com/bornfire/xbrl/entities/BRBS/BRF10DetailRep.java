package com.bornfire.xbrl.entities.BRBS;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BRF10DetailRep extends JpaRepository<BRF10_DETAIL_ENTITY, String> {
	@Query(value = "SELECT * FROM  BRF10_DETAILTABLE WHERE foracid =?1", nativeQuery = true)
	BRF10_DETAIL_ENTITY getallDetails(String foracid);
}