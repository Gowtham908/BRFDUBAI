package com.bornfire.xbrl.entities.BRBS;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BRF202_DetailRep extends JpaRepository<BRF202_DETAIL_ENTITY, String> {
	@Query(value = "SELECT * FROM  BRF202_DETAILTABLE WHERE foracid =?1", nativeQuery = true)
	BRF202_DETAIL_ENTITY getallDetails(String foracid);

}