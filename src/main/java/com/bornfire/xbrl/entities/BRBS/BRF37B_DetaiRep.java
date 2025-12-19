package com.bornfire.xbrl.entities.BRBS;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface BRF37B_DetaiRep extends JpaRepository<BRF37B_DETAIL_ENTITY, String> {
@Query(value = "SELECT * FROM  BRF37B_DETAIL_ENTITY  WHERE foracid =?1", nativeQuery = true)
BRF37B_DETAIL_ENTITY getallDetails(String foracid);
}
