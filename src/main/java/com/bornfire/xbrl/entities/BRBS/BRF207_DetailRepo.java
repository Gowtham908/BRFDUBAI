

package com.bornfire.xbrl.entities.BRBS;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
public interface BRF207_DetailRepo extends JpaRepository<BRF207_DETAIL_ENTITY, String> {
	@Query(value = "SELECT * FROM  BRF207_DETAILTABLE WHERE foracid =?1", nativeQuery = true)
	BRF207_DETAIL_ENTITY getallDetails(String foracid);

}