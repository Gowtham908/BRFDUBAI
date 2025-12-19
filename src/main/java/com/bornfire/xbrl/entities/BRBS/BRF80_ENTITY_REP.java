package com.bornfire.xbrl.entities.BRBS;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;



@Repository
public interface BRF80_ENTITY_REP extends JpaRepository<BRF80_ENTITY,Date>{
	
	@Query(value="select * from BRF80_SUMMARYTABLE where trunc(report_date)=?1",nativeQuery=true)
	List<Object[]> findllvalues(String reportdate);
	 
	
	
	/*
	 * @Query(value="select * from BRF80_SUMMARYTABLE where row_label=?1"
	 * ,nativeQuery=true) List<Object[]> findllvalues(String row_label);
	 */
	 
	  
	  
	 
	
	@Query(value = "select DISTINCT tier_1_capital  from BRF80_SUMMARYTABLE where trunc(report_date)=?1 ", nativeQuery = true)
	String getcapitalcase(String value);
	
	 
	
	
	
 @Query(value=" select nvl(sum(funded_os),0)  from BRF80_SUMMARYTABLE where trunc(report_date)=?1 ",nativeQuery=true) String getfundos(String value);
	  
 @Query(value=" select nvl(sum(debit_securities),0)  from BRF80_SUMMARYTABLE where trunc(report_date)=?1 " ,nativeQuery=true) String getdebtsecurities(String value);
	 
 @Query(  value=" select nvl(sum(equities),0)  from BRF80_SUMMARYTABLE where trunc(report_date)=?1 " ,nativeQuery=true) String getequities(String value);
	  
@Query( value=" select nvl(sum(unfunded_os),0)  from BRF80_SUMMARYTABLE where trunc(report_date)=?1 ",nativeQuery=true) String getunfund (String value);
	  
@Query( value=" select nvl(sum(ccf_equi_unfuned_os),0)  from BRF80_SUMMARYTABLE where trunc(report_date)=?1 " ,nativeQuery=true) String getccf_equi_unfuned_os(String value);
	  
@Query( value=" select nvl(sum(ccf_equi_funded_n_unfuned_limits),0)  from BRF80_SUMMARYTABLE where trunc(report_date)=?1 ",nativeQuery=true) String getccf_equi_funded_n_unfuned_limits(String value);

@Query( value=" select nvl(sum(credit_risk_miti_hair_cut),0)  from BRF80_SUMMARYTABLE where trunc(report_date)=?1 ",nativeQuery=true) String getcrmafterhaircut(String value);

@Query( value=" select nvl(sum(collateral_hair_cut),0)  from BRF80_SUMMARYTABLE where trunc(report_date)=?1 ",nativeQuery=true) String getcollateralafterhaircut(String value);

@Query( value=" select nvl(sum(provision),0)  from BRF80_SUMMARYTABLE where trunc(report_date)=?1 ",nativeQuery=true) String getprovision(String value);

@Query( value=" select nvl(sum(total_exposure_reporting),0)  from BRF80_SUMMARYTABLE where trunc(report_date)=?1 ",nativeQuery=true) String gettotalexposureafterhaircut(String value);
	  
	  
	  
	  
@Query(value = "SELECT (NVL(SUM(funded_os), 0) + NVL(SUM(debit_securities), 0) + NVL(SUM(equities), 0) + NVL(SUM(ccf_equi_unfuned_os), 0) + NVL(SUM(ccf_equi_funded_n_unfuned_limits), 0)) / tier_1_capital AS tier FROM BRF80_SUMMARYTABLE WHERE trunc(report_date) = ?1", nativeQuery = true)
String getastier(String value);

	 
@Query(value = "SELECT (NVL(SUM(funded_os), 0) + NVL(SUM(debit_securities), 0) + NVL(SUM(equities), 0) + NVL(SUM(ccf_equi_unfuned_os), 0) + NVL(SUM(ccf_equi_funded_n_unfuned_limits), 0)) AS total_exposer FROM BRF80_SUMMARYTABLE WHERE TRUNC(report_date) = ?1", nativeQuery = true)
String gettotal(String value);

}
