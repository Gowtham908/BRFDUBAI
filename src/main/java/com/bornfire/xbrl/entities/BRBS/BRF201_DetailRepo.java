package com.bornfire.xbrl.entities.BRBS;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface BRF201_DetailRepo extends JpaRepository<BRF201_DETAIL_ENTITY, String>  {
	
		@Query(value = "SELECT * FROM  BRF201_DETAILTABLE WHERE foracid =?1", nativeQuery = true)
		BRF201_DETAIL_ENTITY getallDetails(String foracid);
	}