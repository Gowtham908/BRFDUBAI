package com.bornfire.xbrl.entities.BRBS;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface BRF42_DetailRepo extends JpaRepository<BRF42_DETAIL_ENTITY, String> {
	@Query(value = "SELECT * FROM  BRF42_DETAILTABLE WHERE foracid =?1", nativeQuery = true)
	BRF42_DETAIL_ENTITY getallDetails(String foracid);

}

