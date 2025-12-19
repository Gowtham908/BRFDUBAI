package com.bornfire.xbrl.entities.BRBS;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BRF79_Detailrepo extends JpaRepository<BRF79_DETAIL_ENTITY, String> {
	@Query(value = "SELECT * FROM  BRF79_DETAILTABLE WHERE foracid =?1", nativeQuery = true)
	BRF79_DETAIL_ENTITY getallDetails(String foracid);


}
