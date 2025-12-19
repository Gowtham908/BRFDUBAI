package com.bornfire.xbrl.entities.BRBS;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BRF76_DetailRepo extends JpaRepository<BRF76_DETAIL_ENTITY, String> {
	@Query(value = "SELECT * FROM  BRF76_DETAILTABLE WHERE foracid =?1", nativeQuery = true)
	BRF76_DETAIL_ENTITY getallDetails(String foracid);

}
