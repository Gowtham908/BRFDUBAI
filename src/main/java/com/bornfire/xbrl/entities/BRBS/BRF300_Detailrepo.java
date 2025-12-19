package com.bornfire.xbrl.entities.BRBS;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BRF300_Detailrepo extends JpaRepository<BRF300_DETAIL_ENTITY, String> {
	@Query(value = "SELECT * FROM  BRF300_DETAILTABLE WHERE foracid =?1", nativeQuery = true)
	BRF300_DETAIL_ENTITY getallDetails(String foracid);
	}