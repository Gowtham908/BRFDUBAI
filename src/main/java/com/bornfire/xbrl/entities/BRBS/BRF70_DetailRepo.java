package com.bornfire.xbrl.entities.BRBS;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BRF70_DetailRepo  extends JpaRepository<BRF70_DETAIL_ENTITY, String>  {
	
	@Query(value = "SELECT * FROM  BRF70_DETAILTABLE WHERE foracid =?1", nativeQuery = true)
	BRF70_DETAIL_ENTITY getallDetails(String foracid);

}
