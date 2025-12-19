package com.bornfire.xbrl.entities;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ECL_MDT_AED_Rep extends JpaRepository<ECL_MDT_AED_Entity,String> {

	@Query(value = "select * from ECL_MASTER_DATA_AED order by cust_id", nativeQuery = true)
	List<ECL_MDT_AED_Entity> getList();
	
	@Query(value = "select * from ECL_MASTER_DATA_AED where cust_id=?1", nativeQuery = true)
	ECL_MDT_AED_Entity getSingleId(String cust_id);
}
