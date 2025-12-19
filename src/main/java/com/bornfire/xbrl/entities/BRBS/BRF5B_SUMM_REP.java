package com.bornfire.xbrl.entities.BRBS;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
@Repository
@Transactional
public interface BRF5B_SUMM_REP extends JpaRepository<BRF5B_SUMMARY_ENTITY,BigDecimal> {

	@Query(value="select * from BRF5B_SUMMARYTABLE where report_date=?1 and security_identifier=?2",nativeQuery=true)
	List<BRF5B_SUMMARY_ENTITY> EditBRF5data(String todate,String Sec_id);
	
	@Query(value = "select * from BRF5B_SUMMARYTABLE where REPORT_DATE=?1", nativeQuery = true)
	BRF5B_SUMMARY_ENTITY getBRF05BReport(Date d1);
	
	@Query(value = "select * from BRF5B_SUMMARYTABLE where REPORT_DATE=?1", nativeQuery = true)
    List<BRF5B_SUMMARY_ENTITY> findByAsondate(Date asondate);
}
