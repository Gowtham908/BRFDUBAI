package com.bornfire.xbrl.entities.BRBS;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

 
@Repository
public interface BRF_MAPPING_REPO extends JpaRepository<BRF_MAPPING_TABLE, String> {


	@Query(value = "select * from BRF_MAPPING_TABLE", nativeQuery = true)

	List<BRF_MAPPING_TABLE> getreport();

	@Query(value = "select * from BRF_MAPPING_TABLE where report_name_1=?1", nativeQuery = true)

	List<BRF_MAPPING_TABLE> getdesc(String report_name_1);
	
	@Query(value = "select * from BRF_MAPPING_TABLE where report_addl_criteria_1=?1", nativeQuery = true)

	List<BRF_MAPPING_TABLE> getproduct(String report_addl_criteria_1);
	

	
	
	
}
