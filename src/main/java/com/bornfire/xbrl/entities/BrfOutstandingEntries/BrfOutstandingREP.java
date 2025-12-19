package com.bornfire.xbrl.entities.BrfOutstandingEntries;


import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import com.bornfire.xbrl.entities.BrfOutstandingEntries.BrfOutstandingEntity;

@Repository
@Transactional
public interface BrfOutstandingREP extends JpaRepository<BrfOutstandingEntryManual, String> {
	

	@Query(value = "select * from BRF_OUTSTANDING_ENTRIES_MANUAL_TABLE  ", nativeQuery = true)
	List<BrfOutstandingEntryManual> getassetcategory();
	
	// @Query(value = "select * from CUSTOM_REPORT_QUEUE_TABLE where rpt_srl_no=?1 ", nativeQuery = true) 
	// CustomRepDownloadEntity findByIdcustom(String rpt_ref_no);
}

