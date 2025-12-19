package com.bornfire.xbrl.entities.BRBS;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BRF84_DetailRepo extends JpaRepository<BRF84_DETAIL_ENTITY, String> {
	@Query(value = "SELECT * FROM  BRF84_DETAILTABLE WHERE foracid =?1", nativeQuery = true)
	BRF84_DETAIL_ENTITY getallDetails(String foracid);

}

