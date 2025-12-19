package com.bornfire.xbrl.entities.BRBS;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface BRF78_DetailRepo  extends JpaRepository<BRF78_DETAIL_ENTITY, String> {
	@Query(value = "SELECT * FROM  BRF78_DETAILTABLE WHERE foracid =?1", nativeQuery = true)
	BRF78_DETAIL_ENTITY getallDetails(String foracid);

}
