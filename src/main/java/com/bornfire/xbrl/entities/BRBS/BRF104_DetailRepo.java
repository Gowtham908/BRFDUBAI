

package com.bornfire.xbrl.entities.BRBS;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.bornfire.xbrl.entities.BRBS.BRF104_DETAIL_ENTITY;
public interface BRF104_DetailRepo extends JpaRepository<BRF104_DETAIL_ENTITY, String> {
	@Query(value = "SELECT * FROM  BRF104A_DETAILTABLE WHERE foracid =?1", nativeQuery = true)
	BRF104_DETAIL_ENTITY getallDetails(String foracid);

}