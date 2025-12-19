package com.bornfire.xbrl.entities.BRBS;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BRF81DetailRep extends JpaRepository<BRF81_DETAIL_ENTITY, String> {
	@Query(value = "SELECT * FROM  BRF81_DETAILTABLE WHERE foracid =?1", nativeQuery = true)
	BRF81_DETAIL_ENTITY getallDetails(String foracid);

}
