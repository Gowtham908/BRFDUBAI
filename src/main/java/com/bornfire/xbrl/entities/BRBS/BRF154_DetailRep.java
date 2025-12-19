package com.bornfire.xbrl.entities.BRBS;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BRF154_DetailRep extends JpaRepository<BRF154_DETAIL_ENTITY, String> {
@Query(value = "SELECT * FROM BRF154B_DETAILTABLE  WHERE foracid =?1", nativeQuery = true)
		BRF154_DETAIL_ENTITY getallDetails(String foracid);
}
