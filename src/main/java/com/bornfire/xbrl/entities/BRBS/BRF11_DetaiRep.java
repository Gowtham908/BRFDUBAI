package com.bornfire.xbrl.entities.BRBS;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BRF11_DetaiRep extends JpaRepository<BRF11_DETAIL_ENTITY, String> {
@Query(value = "SELECT * FROM  BRF11_DETAILTABLE WHERE foracid =?1", nativeQuery = true)
		BRF11_DETAIL_ENTITY getallDetails(String foracid);
}
