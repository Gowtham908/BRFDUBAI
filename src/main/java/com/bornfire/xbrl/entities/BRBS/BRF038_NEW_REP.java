package com.bornfire.xbrl.entities.BRBS;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BRF038_NEW_REP extends JpaRepository<BRF38_ENTITY2, Date>{

	@Query(value="select * from BRF38B_SUMMARYTABLE  where report_date =?1",nativeQuery=true)
	List<Object[]> findentity2(String report_date);
	
	@Query(value="select COUNTRY_BREAK_DOWN,\r\n" + 
			"REMAINING_COUNTRIES,\r\n" + 
			"outward_family1,\r\n" + 
			"outward_investment1,\r\n" + 
			"outward_trade1,\r\n" + 
			"outward_other1, (nvl(outward_family1,0) + nvl(outward_investment1,0) + nvl(outward_trade1,0) + nvl(outward_other1,0)) as OUTWARD_TOTAL,\r\n" + 
			"inward_family1,\r\n" + 
			"inward_investment1,\r\n" + 
			"inward_trade1,\r\n" + 
			"inward_other1, (nvl(inward_family1,0) + nvl(inward_investment1,0) + nvl(inward_trade1,0) + nvl(inward_other1,0)) as INWARD_TOTAL,\r\n" + 
			"ROW_LABEL from  BRF38B_SUMMARYTABLE a where a.report_date = ?1",nativeQuery=true)
	List<Object[]> findallvalues(String to_date);
	
	
	  @Query(
	  value="SELECT nvl(sum(outward_family1),0)+nvl(sum(outward_investment1),0)+nvl(sum(outward_other1),0)+nvl(sum(outward_trade1),0) from BRF38B_SUMMARYTABLE  where report_date =?1"
	  ,nativeQuery=true) String getreaminingamouttotal(String value);
	  
	  @Query(
	  value="select nvl(sum(inward_family1),0)+nvl(sum(inward_investment1),0)+nvl(sum(inward_other1),0)+nvl(sum(inward_trade1),0) from BRF38B_SUMMARYTABLE  where report_date =?1"
	  ,nativeQuery=true) String getreaminingamintotal(String value);
	  
	  //REMAINING
	  
	  @Query(
	  value="select nvl(sum(outward_family1),0) from BRF38B_SUMMARYTABLE  where report_date =?1"
	  ,nativeQuery=true) String getremainoutwardfam(String value);
	  
	  @Query(
	  value="select nvl(sum(inward_family1),0) from BRF38B_SUMMARYTABLE  where report_date =?1"
	  ,nativeQuery=true) String getremaininwardfam(String value);
	  
	  @Query(
	  value="select nvl(sum(outward_investment1),0) from BRF38B_SUMMARYTABLE  where report_date =?1"
	  ,nativeQuery=true) String getremainoutwardinvest(String value);
	  
	  @Query(
	  value="select nvl(sum(inward_investment1),0) from BRF38B_SUMMARYTABLE  where report_date =?1"
	  ,nativeQuery=true) String getremaininwardinvest(String value);
	  
	  @Query(
	  value="select nvl(sum(outward_trade1),0) from BRF38B_SUMMARYTABLE  where report_date =?1"
	  ,nativeQuery=true) String getremainoutwardtrade(String value);
	  
	  @Query(
	  value="select nvl(sum(inward_trade1),0) from BRF38B_SUMMARYTABLE  where report_date =?1"
	  ,nativeQuery=true) String getremaininwardtrade(String value);
	  
	  @Query(
	  value="select nvl(sum(outward_other1),0) from BRF38B_SUMMARYTABLE  where report_date =?1"
	  ,nativeQuery=true) String getremainoutwardother(String value);
	  
	  @Query(
	  value="select nvl(sum(inward_other1),0) from BRF38B_SUMMARYTABLE  where report_date =?1"
	  ,nativeQuery=true) String getremaininwardother(String value);
	 
	  
	
}
	