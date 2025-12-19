
package com.bornfire.xbrl.entities.BRBS;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BRF205_DetailRep extends JpaRepository<BRF205_DETAIL_ENTITY, String> {
	@Query(value = "SELECT * FROM  BRF205_DETAILTABLE WHERE foracid =?1", nativeQuery = true)
	BRF205_DETAIL_ENTITY getallDetails(String foracid);

}
