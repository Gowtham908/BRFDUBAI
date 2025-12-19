package com.bornfire.xbrl.entities.BRBS;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface BRF37_DetaiRep extends JpaRepository<BRF37_DETAIL_ENTITY, String> {
@Query(value = "SELECT * FROM  BRF37_DETAILTABLE  WHERE foracid =?1", nativeQuery = true)
		BRF37_DETAIL_ENTITY getallDetails(String foracid);
}
