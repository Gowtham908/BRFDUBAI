package com.bornfire.xbrl.entities.BRBS;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BRF96_DetailRepo extends JpaRepository<BRF96_DETAIL_ENTITY, String> {
	@Query(value = "SELECT * FROM  BRF96_DETAILTABLE WHERE foracid =?1", nativeQuery = true)
	BRF96_DETAIL_ENTITY getallDetails(String foracid);

}
