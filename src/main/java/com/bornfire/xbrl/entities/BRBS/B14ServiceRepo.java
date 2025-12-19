package com.bornfire.xbrl.entities.BRBS;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface B14ServiceRepo extends JpaRepository<B14Reportentity , Date>{
	@Query(value = "select * from B14 where REPORT_DATE=?1", nativeQuery = true)
	List<B14Reportentity > getB14reportService(Date d1);

}