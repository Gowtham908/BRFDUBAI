package com.bornfire.xbrl.entities.BRBS;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BRF86_Detailrepo extends JpaRepository<BRF86_DETAIL_ENTITY, String> {
	@Query(value = "SELECT * FROM  BRF86_DETAILTABLE WHERE foracid =?1", nativeQuery = true)
	BRF86_DETAIL_ENTITY getallDetails(String foracid);
}
