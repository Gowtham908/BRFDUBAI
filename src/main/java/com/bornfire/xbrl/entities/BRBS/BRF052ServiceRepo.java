package com.bornfire.xbrl.entities.BRBS;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface BRF052ServiceRepo extends JpaRepository<BRF52_ENTITY1, Date> {
	@Query(value = "select * from BRF_052_A1 where REPORT_DATE=?1", nativeQuery = true)
	List<BRF52_ENTITY1> getBRF052reportService(Date d1);

	
	  
	  ///// Query for BRF52_SUMMARYTABLE1 AND BRF52_SUMMARYTABLE2 AND BRF52_SUMMARYTABLE3
	  
	@Query(value = "SELECT t1.*, t2.*, t3.* " +
            "FROM BRF52_SUMMARYTABLE1 t1 " +
            "JOIN BRF52_SUMMARYTABLE2 t2 ON t1.REPORT_DATE = t2.REPORT_DATE " +
            "JOIN BRF52_SUMMARYTABLE3 t3 ON t1.REPORT_DATE = t3.REPORT_DATE " +
            "WHERE t1.report_code = ?1 AND t1.repdesc = ?2", nativeQuery = true)
List<BRF52_ENTITY1> getBRF052REPORTSERVICE(String reportid, String repdesc);

	/*
	 * @Query(value = "SELECT t1.*, t2.*, t3.* " + "FROM BRF52_SUMMARYTABLE1 t1 " +
	 * "JOIN BRF52_SUMMARYTABLE2 t2 ON t1.REPORT_DATE = t2.REPORT_DATE " +
	 * "JOIN BRF52_SUMMARYTABLE3 t3 ON t1.REPORT_DATE = t3.REPORT_DATE " +
	 * "WHERE t1.report_code = :reportid " + "AND t1.repdesc = :repdesc",
	 * nativeQuery = true) List<BRF52_ENTITY1>
	 * getBRF052REPORTSERVICE(@Param("reportid") String reportid,
	 * 
	 * @Param("repdesc") String repdesc);
	 */
}
