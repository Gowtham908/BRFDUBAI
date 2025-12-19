package com.bornfire.xbrl.entities.BRBS;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BRF62DetailRepo   extends JpaRepository<BRF62_DETAILENTITY, String> {
	@Query(value = "SELECT * FROM  BRF62_DETAILTABLE WHERE foracid =?1", nativeQuery = true)
	BRF62_DETAILENTITY getallDetails(String foracid);


}

