package com.bornfire.xbrl.entities.BRBS;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BRF32C_DetailRepo  extends JpaRepository<BRF32C_DETAIL_ENTITY, String> {
	@Query(value = "SELECT * FROM  BRF32C_DETAILTABLE WHERE foracid =?1", nativeQuery = true)
	BRF32C_DETAIL_ENTITY getallDetails(String foracid);
}
