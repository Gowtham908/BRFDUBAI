



package com.bornfire.xbrl.entities.BRBS;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BRF181DETAIL_Repo extends JpaRepository<BRF181_DETAIL_ENTITY, String> {
	@Query(value = "SELECT * FROM  BRF181_DETAILTABLE WHERE foracid =?1", nativeQuery = true)
	BRF181_DETAIL_ENTITY getallDetails(String foracid);
}