package com.bornfire.xbrl.entities.BRBS;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BRF65_DetailRepo extends JpaRepository<BRF65_DETAIL_ENTITY, String> {
	@Query(value = "SELECT * FROM  BRF65A_DETAILTABLE WHERE foracid =?1", nativeQuery = true)
	BRF65_DETAIL_ENTITY getallDetails(String foracid);

}
