package com.bornfire.xbrl.entities;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;



public interface ECL_FUNDED_REP  extends JpaRepository<ECL_FUNDED, String>{
	@Query(value = "select * from ECL_FB_NFB_TABLE", nativeQuery = true)
	List<ECL_FUNDED> getfunded();
}
