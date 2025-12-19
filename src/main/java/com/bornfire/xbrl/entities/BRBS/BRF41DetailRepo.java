package com.bornfire.xbrl.entities.BRBS;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BRF41DetailRepo   extends JpaRepository<BRF41_DETAILENTITY, String> {
	@Query(value = "SELECT * FROM  BRF41_DETAILTABLE WHERE foracid =?1", nativeQuery = true)
	BRF41_DETAILENTITY getallDetails(String foracid);


}

