package com.bornfire.xbrl.entities.BRBS;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bornfire.xbrl.entities.FWD_REVEAL.SensUploadOSEntries;


@Repository
public interface SensManUploadRepo extends JpaRepository<SensUploadOSEntries, String> {
	
	
	Optional<SensUploadOSEntries> findById(String directorId);

	
	
	@Query(value = "select * from OUTSTD_ENTRIES_TABLE where upl_date=?1", nativeQuery = true)
	List<SensUploadOSEntries> ByHeadCtry(String foracid);
	
	@Query(value = "select * from OUTSTD_ENTRIES_TABLE where upl_date=?1 AND SOL_ID=?2", nativeQuery = true)
	List<SensUploadOSEntries> ByHeadCtry_SOL(String date,String sol_id);


}
