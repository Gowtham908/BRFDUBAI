package com.bornfire.xbrl.entities.BRBS;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BRF80_Detailrepo extends JpaRepository<BRF80_DETAIL_ENTITY, String> {
	@Query(value = "SELECT * FROM  BRF80_DETAILTABLE WHERE foracid =?1", nativeQuery = true)
	BRF80_DETAIL_ENTITY getallDetails(String foracid);


}
