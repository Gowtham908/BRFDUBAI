package com.bornfire.xbrl.entities.BRBS;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BRF106DETAIL_Repo extends JpaRepository<BRF106_DETAIL_ENTITY, String> {
	@Query(value = "SELECT * FROM  BRF106_DETAIL_ENTITY WHERE foracid =?1", nativeQuery = true)
	BRF106_DETAIL_ENTITY getallDetails(String foracid);
}