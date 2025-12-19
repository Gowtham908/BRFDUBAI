package com.bornfire.xbrl.entities.BRBS;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;



@Repository
public interface BRF7_ENTITY_REP extends JpaRepository<BRF7_ENTITY,Date>{
	
	@Query(value = "select * from BRF7_SUMMARYTABLE where report_date=?1", nativeQuery = true)
	List<BRF7_ENTITY> findAllData(String date);

}
