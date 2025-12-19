
package com.bornfire.xbrl.entities.BRBS;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BRF56_DetailRepo extends JpaRepository<BRF56_DETAIL_ENTITY, String> {
	@Query(value = "SELECT * FROM  BRF46_DETAILTABLE WHERE foracid =?1", nativeQuery = true)
	BRF56_DETAIL_ENTITY getallDetails(String foracid);
}
