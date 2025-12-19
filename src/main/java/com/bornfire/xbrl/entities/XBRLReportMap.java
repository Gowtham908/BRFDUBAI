

package com.bornfire.xbrl.entities;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bornfire.xbrl.entities.BRBS.AuditServicesEntity;
import com.bornfire.xbrl.entities.BRBS.BRF_MAPPING_TABLE;
@Repository
public interface XBRLReportMap extends JpaRepository<BRF_REF_CODE_ENTITY , Integer>{
	@Query(value = "select * from BRF_REF_CODE_TABLE where REPORT_SRL=?1 ", nativeQuery = true)
	List<BRF_REF_CODE_ENTITY> genRefCodeDescList1();
	
	@Query(value = "select * from BRF_REF_CODE_TABLE", nativeQuery = true)
	List<BRF_REF_CODE_ENTITY> genRefCodeDescList2();
	

	
	 
	/*
	 * @Query(value = "select * from BRF_REF_CODE_TABLE", nativeQuery = true)
	 * List<BRF_REF_CODE_ENTITY> getLiist1();
	 * 
	 * 
	 */
	
	
	
	
}
