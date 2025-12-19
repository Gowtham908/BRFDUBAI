package com.bornfire.xbrl.entities.BRBS;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.bornfire.xbrl.entities.BRBS.BRF156_DETAILENTITY;

public interface BRF156_DetailRepo extends JpaRepository<BRF156_DETAILENTITY, String>  {
	
	@Query(value = "SELECT * FROM  BRF156_DETAILTABLE WHERE foracid =?1", nativeQuery = true)
	BRF156_DETAILENTITY getallDetails(String foracid);

}