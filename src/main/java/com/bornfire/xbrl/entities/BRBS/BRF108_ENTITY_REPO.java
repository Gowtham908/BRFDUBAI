package com.bornfire.xbrl.entities.BRBS;	

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface BRF108_ENTITY_REPO extends JpaRepository<BRF108_ENTITY, BRF108IDCLASS> {
	
	@Query(value = "SELECT * FROM  BRF108_SUMMARYTABLE WHERE report_date =?1 AND del_flg = 'N' ORDER BY r1_s_no", nativeQuery = true)
	List<BRF108_ENTITY> getallDetails(Date report_date); 
	
	@Query(value = "select * from BRF108_SUMMARYTABLE where report_date=?1", nativeQuery = true)
	BRF108_ENTITY getBRF108Report(Date d1);
	
	@Query(value =  "select * from BRF108_SUMMARYTABLE WHERE  r1_s_no = ?1 ", nativeQuery = true)
	BRF108_ENTITY   getsrl_no(String  r1_s_no);
	
	
	@Query(value="select * from BRF108_SUMMARYTABLE where trunc(report_date)=?1",nativeQuery=true)
	List<Object[]> findllvalues(String todate);
	
	//modify
	@Query(value = "SELECT * FROM  BRF108_SUMMARYTABLE WHERE trunc(report_date)=?1 ORDER BY r1_s_no", nativeQuery = true)
	List<BRF108_ENTITY> getBRF108reportService(Date asondate);
}
