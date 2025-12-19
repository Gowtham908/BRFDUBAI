package com.bornfire.xbrl.entities.BRBS;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface BRF33_DetailRep extends JpaRepository<BRF33_DETAIL_ENTITY, String> {
@Query(value = "SELECT * FROM  BRF33_DETAILTABLE  WHERE foracid =?1", nativeQuery = true)
		BRF33_DETAIL_ENTITY getallDetails(String foracid);
}

