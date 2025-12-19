package com.bornfire.xbrl.entities.BRBS;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BRF66_DetailRepo  extends JpaRepository<BRF66_DETAIL_ENTITY, String> {
	@Query(value = "SELECT * FROM  BRF66A_DETAILTABLE WHERE foracid =?1", nativeQuery = true)
	BRF66_DETAIL_ENTITY getallDetails(String foracid);

}