package com.bornfire.xbrl.entities.BRBS;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BRF47_ENTITY_REP extends JpaRepository<BRF47_Entity, Date>{
	
	@Query(value="select * from BRF47_SUMMARYTABLE where trunc(report_date)=?1",nativeQuery=true)
	List<Object[]> findllvalues(String reportdate);
	
	
	  @Query(
	  value=" select nvl(sum(amount),0)  from BRF47_SUMMARYTABLE where trunc(report_date)=?1 " ,nativeQuery=true) 
	  String getgrandtotal(String value);
	 

//@Query(value = "UPDATE BRF47_SUMMARYTABLE SET GRANT_TOTAL = (SELECT NVL(SUM(AMOUNT), 0) FROM BRF47_SUMMARYTABLE)", nativeQuery = true)
//String getgrandtotal(String value);


}

