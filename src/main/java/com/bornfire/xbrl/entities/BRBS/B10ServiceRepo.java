package com.bornfire.xbrl.entities.BRBS;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface B10ServiceRepo extends JpaRepository<B10Reportentity , Date>{
	@Query(value = "select * from B10 where REPORT_DATE=?1", nativeQuery = true)
	List<B10Reportentity > getB10reportService(Date d1);

}
