package com.bornfire.xbrl.entities.BRBS;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BRF92_DetailRepo extends JpaRepository<BRF92_DETAIL_ENTITY, String> {
	@Query(value = "SELECT * FROM  BRF92_DETAILTABLE WHERE foracid =?1", nativeQuery = true)
	BRF92_DETAIL_ENTITY getallDetails(String foracid);

}
