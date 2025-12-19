package com.bornfire.xbrl.entities.BRBS;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BRF47A_DetailRep extends JpaRepository<BRF47A_DETAIL_ENTITY, String> {
	
    @Query(value = "SELECT * FROM BRF47A_DETAILTABLE WHERE foracid = ?1", nativeQuery = true)
    BRF47A_DETAIL_ENTITY getDetailsA(String foracid);

//    @Query(value = "SELECT * FROM BRF47B_DETAILTABLE WHERE foracid = ?1", nativeQuery = true)
//    BRF47B_DETAIL_ENTITY getDetailsB(String foracid);
}
