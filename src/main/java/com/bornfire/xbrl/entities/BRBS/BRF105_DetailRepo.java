package com.bornfire.xbrl.entities.BRBS;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BRF105_DetailRepo extends JpaRepository<BRF105_DETAIL_ENTITY, String> {
	@Query(value = "SELECT * FROM  BRF105_DETAILTABLE WHERE foracid =?1", nativeQuery = true)
	BRF105_DETAIL_ENTITY getallDetails(String foracid);

}
