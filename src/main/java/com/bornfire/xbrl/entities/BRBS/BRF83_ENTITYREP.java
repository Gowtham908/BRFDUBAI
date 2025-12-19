package com.bornfire.xbrl.entities.BRBS;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BRF83_ENTITYREP extends JpaRepository<BRF83_ENTITY, Date>{
	
	
	@Query(value="select * from BRF83_SUMMARYTABLE where trunc(report_date)=?1",nativeQuery=true)
	List<Object[]> findllvalues(String reportdate);
	 
	
	
	/*
	 * @Query(value="select * from BRF83_SUMMARYTABLE where row_label=?1"
	 * ,nativeQuery=true) List<Object[]> findllvalues(String row_label);
	 */
	 
	  
	  
	 
	
	@Query(value = "select DISTINCT capital_case  from BRF83_SUMMARYTABLE where trunc(report_date)=?1 ", nativeQuery = true)
	String getcapitalcase(String value);
	
	@Query(value = "select DISTINCT entity_level  from BRF83_SUMMARYTABLE where trunc(report_date)=?1 ", nativeQuery = true)
	String getetity(String value);
	
	
	
	
 @Query(value=" select nvl(sum(fund_os),0)  from BRF83_SUMMARYTABLE where trunc(report_date)=?1 ",nativeQuery=true) String getfundos(String value);
	  
 @Query(value=" select nvl(sum(debt_securities),0)  from BRF83_SUMMARYTABLE where trunc(report_date)=?1 " ,nativeQuery=true) String getdebtsecurities(String value);
	 
 @Query(  value=" select nvl(sum(unfund_os),0)  from BRF83_SUMMARYTABLE where trunc(report_date)=?1 " ,nativeQuery=true) String getunfundos(String value);
	  
@Query( value=" select nvl(sum(unfund_ccf),0)  from BRF83_SUMMARYTABLE where trunc(report_date)=?1 ",nativeQuery=true) String getunfundccf(String value);
	  
@Query( value=" select nvl(sum(unused_unfund_ccf),0)  from BRF83_SUMMARYTABLE where trunc(report_date)=?1 " ,nativeQuery=true) String getunusedunfundccf(String value);
	  
@Query( value=" select nvl(sum(tier1_capital),0)  from BRF83_SUMMARYTABLE where trunc(report_date)=?1 ",nativeQuery=true) String gettier1(String value);

@Query( value=" select nvl(sum(risk_haircut),0)  from BRF83_SUMMARYTABLE where trunc(report_date)=?1 ",nativeQuery=true) String getcrmafterhaircut(String value);

@Query( value=" select nvl(sum(collateral),0)  from BRF83_SUMMARYTABLE where trunc(report_date)=?1 ",nativeQuery=true) String getcollateralafterhaircut(String value);

@Query( value=" select nvl(sum(provision),0)  from BRF83_SUMMARYTABLE where trunc(report_date)=?1 ",nativeQuery=true) String getprovision(String value);

@Query( value=" select nvl(sum(total_exposure_reporting),0)  from BRF83_SUMMARYTABLE where trunc(report_date)=?1 ",nativeQuery=true) String gettotalexposureafterhaircut(String value);
	  
	  
	  
	  
	//  @Query(value=" select nvl(sum(total_exposure_ccf),0)  from BRF83_SUMMARYTABLE where trunc(report_date)=?1 " ,nativeQuery=true) String gettotal(String value);
	 
	  @Query(value="  select (nvl(sum(fund_os),0)+ nvl(sum(debt_securities),0)+nvl(sum(unfund_ccf),0)+nvl(sum(unused_unfund_ccf),0)) as total_exposure from BRF83_SUMMARYTABLE WHERE trunc(report_date) =?1" ,nativeQuery = true)
	String gettotal(String value); 
	
}