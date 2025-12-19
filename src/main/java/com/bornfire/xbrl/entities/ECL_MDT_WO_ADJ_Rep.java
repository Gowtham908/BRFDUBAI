package com.bornfire.xbrl.entities;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ECL_MDT_WO_ADJ_Rep extends JpaRepository<ECL_MDT_WO_ADJ_Entity,String> {

	@Query(value = "select * from ECL_MASTER_DATA_WO_ADJ1 order by cust_id", nativeQuery = true)
	List<ECL_MDT_WO_ADJ_Entity> getList();
	
	@Query(value = "select * from ECL_MASTER_DATA_WO_ADJ1 where cust_id=?1", nativeQuery = true)
	ECL_MDT_WO_ADJ_Entity getSingleId(String cust_id);
}
