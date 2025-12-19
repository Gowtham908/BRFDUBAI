package com.bornfire.xbrl.entities.BRBS;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BRF206DETAIL_Repo extends JpaRepository<BRF206_DETAIL_ENTITY, String> {
	@Query(value = "SELECT * FROM  BRF206_DETAILTABLE WHERE foracid =?1", nativeQuery = true)
	BRF206_DETAIL_ENTITY getallDetails(String foracid);
}