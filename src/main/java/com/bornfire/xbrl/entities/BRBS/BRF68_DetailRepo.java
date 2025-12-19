package com.bornfire.xbrl.entities.BRBS;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface BRF68_DetailRepo  extends JpaRepository<BRF68_DETAIL_ENTITY, String> {
	@Query(value = "SELECT * FROM  BRF68_DETAILTABLE WHERE foracid =?1", nativeQuery = true)
	BRF68_DETAIL_ENTITY getallDetails(String foracid);

}