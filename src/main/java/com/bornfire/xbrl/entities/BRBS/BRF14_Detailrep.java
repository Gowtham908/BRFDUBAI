package com.bornfire.xbrl.entities.BRBS;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BRF14_Detailrep extends JpaRepository<BRF14_DETAIL_ENTITY, String> {
	@Query(value = "SELECT * FROM  BRF14_DETAILTABLE WHERE foracid =?1", nativeQuery = true)
	BRF14_DETAIL_ENTITY getallDetails(String foracid);
}
