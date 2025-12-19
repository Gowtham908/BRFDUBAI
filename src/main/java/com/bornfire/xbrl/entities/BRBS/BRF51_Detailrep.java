package com.bornfire.xbrl.entities.BRBS;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BRF51_Detailrep extends JpaRepository<BRF51_DETAIL_ENTITY, String> {
	@Query(value = "SELECT * FROM  BRF51_DETAILTABLE WHERE foracid =?1", nativeQuery = true)
	BRF51_DETAIL_ENTITY getallDetails(String foracid);
}
