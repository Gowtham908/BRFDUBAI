package com.bornfire.xbrl.entities.BRBS;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

	
public interface BRF78_ENTITYREPO extends JpaRepository<BRF78_ENTITY, Date>{
		
		@Query(value="select * from BRF78_SUMMARYTABLE where trunc(report_date)=?1",nativeQuery=true)
		List<BRF78_ENTITY> findllvalues(String todate);
		
		
		
	}
	