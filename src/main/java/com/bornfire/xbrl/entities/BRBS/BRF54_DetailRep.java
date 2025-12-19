
package com.bornfire.xbrl.entities.BRBS;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BRF54_DetailRep extends JpaRepository<BRF54_DETAIL_ENTITY, String> {
	@Query(value = "SELECT * FROM  BRF54_DETAILTABLE WHERE foracid =?1", nativeQuery = true)
	BRF54_DETAIL_ENTITY getallDetails(String foracid);

}
