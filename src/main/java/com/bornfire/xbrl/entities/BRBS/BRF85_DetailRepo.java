package com.bornfire.xbrl.entities.BRBS;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BRF85_DetailRepo extends JpaRepository<BRF85_DETAIL_ENTITY, String> {
	@Query(value = "SELECT * FROM  BRF85_DETAILTABLE WHERE foracid =?1", nativeQuery = true)
	BRF85_DETAIL_ENTITY getallDetails(String foracid);

}
