package com.bornfire.xbrl.entities.BRBS;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BRF155_DetailRep extends JpaRepository<BRF155_DETAIL_ENTITY, String> {
@Query(value = "SELECT * FROM BRF155_DETAILTABLE  WHERE foracid =?1", nativeQuery = true)
		BRF155_DETAIL_ENTITY getallDetails(String foracid);
}
