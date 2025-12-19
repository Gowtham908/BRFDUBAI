package com.bornfire.xbrl.entities.BRBS;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
public interface BRF48_DetailRepo extends JpaRepository<BRF48_DETAIL_ENTITY, String> {
	@Query(value = "SELECT * FROM  BRF48_DETAILTABLE WHERE foracid =?1", nativeQuery = true)
	BRF48_DETAIL_ENTITY getallDetails(String foracid);

}