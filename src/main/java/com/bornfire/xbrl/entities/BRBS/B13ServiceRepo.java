package com.bornfire.xbrl.entities.BRBS;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface B13ServiceRepo extends JpaRepository<B13Reportentity , Date>{
	@Query(value = "select * from B13 where REPORT_DATE=?1", nativeQuery = true)
	List<B13Reportentity > getB13reportService(Date d1);

}