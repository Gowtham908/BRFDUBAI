package com.bornfire.xbrl.entities.BRBS;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BRF35_ENTITY_REP extends JpaRepository<BRF35_ENTITY, Date>{
	
	@Query(value="select * from BRF35_SUMMARYTABLE where trunc(report_date)=?1",nativeQuery=true)
	List<Object[]> findllvalues(String reportdate);
	
	 @Query(
			  value=" select nvl(sum(due_from_placements),0)  from BRF35_SUMMARYTABLE where trunc(report_date)=?1 " ,nativeQuery=true) 
			  String getduefrmplace(String value);
	 @Query(
			  value=" select nvl(sum(due_to_borrowing),0)  from BRF35_SUMMARYTABLE where trunc(report_date)=?1 " ,nativeQuery=true) 
			  String getduetobrorow(String value);
	 @Query(
			  value=" select nvl(sum(due_from_remaining),0)  from BRF35_SUMMARYTABLE where trunc(report_date)=?1 " ,nativeQuery=true) 
			  String getduefrmremain(String value);
	 @Query(
			  value=" select nvl(sum(due_to_bremaining),0)  from BRF35_SUMMARYTABLE where trunc(report_date)=?1 " ,nativeQuery=true) 
			  String getduetoremain(String value);

}

