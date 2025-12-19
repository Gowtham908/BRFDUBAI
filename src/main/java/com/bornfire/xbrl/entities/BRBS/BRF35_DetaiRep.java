package com.bornfire.xbrl.entities.BRBS;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BRF35_DetaiRep extends JpaRepository<BRF35_DETAIL_ENTITY , String> {
	@Query(value = "SELECT * FROM  BRF35_DETAILTABLE WHERE foracid =?1", nativeQuery = true)
	BRF35_DETAIL_ENTITY getallDetails(String foracid);
	
}
