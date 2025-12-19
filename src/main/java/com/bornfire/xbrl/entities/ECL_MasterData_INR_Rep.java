package com.bornfire.xbrl.entities;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ECL_MasterData_INR_Rep extends JpaRepository<ECL_MasterData_INR_Entity,String> {

	@Query(value = "select * from ECL_MASTER_DATA_INR order by cust_id", nativeQuery = true)
	List<ECL_MasterData_INR_Entity> getList();
	
	@Query(value = "select * from ECL_MASTER_DATA_INR where cust_id=?1", nativeQuery = true)
	ECL_MasterData_INR_Entity getSingleId(String cust_id);
}
