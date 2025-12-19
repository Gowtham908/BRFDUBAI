package com.bornfire.xbrl.entities.BRBS;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BRF0001_DETAIL_REP extends JpaRepository<BRF0001_DETAIL_ENTITY, String>{
	@Query(value = "SELECT * FROM  BRF001_DETAILTABLE WHERE foracid =?1", nativeQuery = true)
	BRF0001_DETAIL_ENTITY getallDetails(String foracid);

	
}
