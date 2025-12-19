package com.bornfire.xbrl.entities.BRBS;


	import org.springframework.data.jpa.repository.JpaRepository;
	import org.springframework.data.jpa.repository.Query;

	public interface BRF60_DetailRep extends JpaRepository<BRF60_DETAIL_ENTITY, String> {
	@Query(value = "SELECT * FROM  BRF60_DETAILTABLE WHERE foracid =?1", nativeQuery = true)
			BRF60_DETAIL_ENTITY getallDetails(String foracid);
	}
