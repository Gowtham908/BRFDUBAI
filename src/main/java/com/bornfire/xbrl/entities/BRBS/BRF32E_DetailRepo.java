package com.bornfire.xbrl.entities.BRBS;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BRF32E_DetailRepo   extends JpaRepository<BRF32E_DETAIL_ENTITY, String>{

	@Query(value = "SELECT * FROM  BRF32E_DETAILTABLE WHERE foracid =?1", nativeQuery = true)
	BRF32E_DETAIL_ENTITY getallDetails(String foracid);
}