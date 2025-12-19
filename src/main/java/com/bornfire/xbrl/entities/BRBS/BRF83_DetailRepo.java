package com.bornfire.xbrl.entities.BRBS;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BRF83_DetailRepo extends JpaRepository<BRF83_DETAIL_ENTITY, String> {
	@Query(value = "SELECT * FROM  BRF83_DETAILTABLE WHERE foracid =?1", nativeQuery = true)
	BRF83_DETAIL_ENTITY getallDetails(String foracid);

}
