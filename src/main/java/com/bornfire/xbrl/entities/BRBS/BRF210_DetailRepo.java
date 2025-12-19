

package com.bornfire.xbrl.entities.BRBS;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
public interface BRF210_DetailRepo extends JpaRepository<BRF210_DETAIL_ENTITY, String> {
	@Query(value = "SELECT * FROM  BRF210_DETAILTABLE WHERE foracid =?1", nativeQuery = true)
	BRF210_DETAIL_ENTITY getallDetails(String foracid);

}