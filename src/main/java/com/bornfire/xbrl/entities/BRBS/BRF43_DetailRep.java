package com.bornfire.xbrl.entities.BRBS;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BRF43_DetailRep extends JpaRepository<BRF43_DETAIL_ENTITY, String> {
@Query(value = "SELECT * FROM BRF43B_DETAILTABLE  WHERE foracid =?1", nativeQuery = true)
		BRF43_DETAIL_ENTITY getallDetails(String foracid);
}
