package com.bornfire.xbrl.entities.BRBS;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
public interface BRF49_DetailRepo extends JpaRepository<BRF49_DETAIL_ENTITY, String> {
	@Query(value = "SELECT * FROM  BRF49_DETAILTABLE WHERE foracid =?1", nativeQuery = true)
	BRF49_DETAIL_ENTITY getallDetails(String foracid);

}