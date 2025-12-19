package com.bornfire.xbrl.entities.BRBS;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BRF44_DetailRep extends JpaRepository<BRF44_DETAIL_ENTITY, String> {
	@Query(value = "SELECT * FROM  BRF44_DETAILTABLE WHERE foracid =?1", nativeQuery = true)
	BRF44_DETAIL_ENTITY getallDetails(String foracid);

}