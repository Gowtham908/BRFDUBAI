package com.bornfire.xbrl.entities;
 
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bornfire.xbrl.entities.BRBS.BRF_MAPPING_TABLE;

import java.util.List;
 
 
 
@Repository
public interface BRFmappingRepo extends JpaRepository<BRF_MAPPING_TABLE, String>{
	@Query(value = "select * from BRF_MAPPING_TABLE", nativeQuery = true)
	List<BRF_MAPPING_TABLE> getbrfmapping();
	@Query(value = "select * from BRF_MAPPING_TABLE where foracid= ?1", nativeQuery = true)
	BRF_MAPPING_TABLE findByforacid(String foracid);
 
}