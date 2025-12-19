package com.bornfire.xbrl.entities.BRBS;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface BRF36_DetailRepo extends JpaRepository<BRF36_DETAIL_ENTITY, String> {
	@Query(value = "SELECT * FROM  BRF36_DETAILTABLE WHERE foracid =?1", nativeQuery = true)
	BRF36_DETAIL_ENTITY getallDetails(String foracid);

}

