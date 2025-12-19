package com.bornfire.xbrl.entities.BRBS;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;



@Repository
public interface BRF78_ENTITY_REP extends JpaRepository<BRF78_ENTITY1,Date>{
	
	@Query(value="select * from BRF78_SUMMARYTABLE_1 where trunc(report_date)=?1",nativeQuery=true)
	List<Object[]> findllvalues(String reportdate);
	
	// CAPITAL CASE
    @Query(value = "SELECT DISTINCT tier_1_capital FROM BRF78_SUMMARYTABLE WHERE trunc(report_date) = ?1", nativeQuery = true)
    String getTier1_capital(String value);
	 
	
	
	/*
	 * @Query(value="select * from BRF78_SUMMARYTABLE_1 where row_label=?1"
	 * ,nativeQuery=true) List<Object[]> findllvalues(String row_label);
	 */
	
	@Query(value = " select nvl(sum(funded_os),0)  from BRF78_SUMMARYTABLE_1 where trunc(report_date)=?1 ", nativeQuery = true)
	String getfunded_os(String value);

	@Query(value = " select nvl(sum(debt_securities),0)  from BRF78_SUMMARYTABLE_1 where trunc(report_date)=?1 ", nativeQuery = true)
	String getdebt_securities(String value);

	@Query(value = " select nvl(sum(unfunded_os),0)  from BRF78_SUMMARYTABLE_1 where trunc(report_date)=?1 ", nativeQuery = true)
	String getunfunded_os(String value);

	@Query(value = " select nvl(sum(ccf_equ_unfunded_os),0)  from BRF78_SUMMARYTABLE_1 where trunc(report_date)=?1 ", nativeQuery = true)
	String getccf_equ_unfunded_os(String value);

	@Query(value = " select nvl(sum(ccf_equ_comm_unused_unfund),0)  from BRF78_SUMMARYTABLE_1 where trunc(report_date)=?1 ", nativeQuery = true)
	String getccf_equ_comm_unused_unfund(String value);

	@Query(value = " select nvl(sum(credit_risk_mitigation_after_haircut),0)  from BRF78_SUMMARYTABLE_1 where trunc(report_date)=?1 ", nativeQuery = true)
	String getcredit_risk_mitigation_after_haircut(String value);

	@Query(value = " select nvl(sum(collateral_value_after_haircut),0)  from BRF78_SUMMARYTABLE_1 where trunc(report_date)=?1 ", nativeQuery = true)
	String getcollateral_value_after_haircut(String value);

	@Query(value = " select nvl(sum(provision),0)  from BRF78_SUMMARYTABLE_1 where trunc(report_date)=?1 ", nativeQuery = true)
	String getprovision(String value);
	
	  
	 
	@Query(value = "SELECT NVL(SUM(funded_os), 0) + NVL(SUM(debt_securities), 0) + NVL(SUM(ccf_equ_unfunded_os), 0) + NVL(SUM(ccf_equ_comm_unused_unfund), 0) AS total_exposer FROM BRF78_SUMMARYTABLE_1 WHERE TRUNC(report_date) = ?1", nativeQuery = true)
	String gettotal(String value);

}
