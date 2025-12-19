package com.bornfire.xbrl.entities.BRBS;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BRF32B_DetailRepo   extends JpaRepository<BRF32B_DETAIL_ENTITY, String>{
	@Query(value = "SELECT * FROM  BRF32B_DETAILTABLE WHERE foracid =?1", nativeQuery = true)
	BRF32B_DETAIL_ENTITY getallDetails(String foracid);

}
