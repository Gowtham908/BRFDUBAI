package com.bornfire.xbrl.entities.BRBS;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BRF3_DetaiRep extends JpaRepository<BRF3_DETAILTABLE, String> {
	@Query(value = "SELECT * FROM  BRF3_DETAILTABLE WHERE foracid =?1", nativeQuery = true)
	BRF3_DETAILTABLE getallDetails(String foracid);

}
