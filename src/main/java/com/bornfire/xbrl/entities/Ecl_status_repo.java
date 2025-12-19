package com.bornfire.xbrl.entities;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface Ecl_status_repo  extends JpaRepository<ECL_STATUS_ENTITY, String> {
	
	@Query(value = "select * from ECL_STATUS_TABLE", nativeQuery = true)
	List<ECL_STATUS_ENTITY> getEclstatus();
	
	@Query(value = "select * from ECL_STATUS_TABLE where cust_id=?1", nativeQuery = true)
	ECL_STATUS_ENTITY getEclstatus1(String cust_id);
}
