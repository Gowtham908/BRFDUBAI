package com.bornfire.xbrl.entities.BRBS;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.bornfire.xbrl.entities.BRBS.BRF202A_entity;

@Repository
public interface BRF202A_entity_repo extends JpaRepository<BRF202A_entity, Date> {
	
	@Query(value = "SELECT * FROM  BRF202_SUMMARYTABLE WHERE report_date =?1 ORDER BY r1_s_no", nativeQuery = true)
	List<BRF202A_entity> getallDetails(Date report_date);
	@Query(value = "select * from BRF202_SUMMARYTABLE where report_date=?1", nativeQuery = true)
	BRF202A_entity getBRF202Report(Date d1);
	
	@Query(value =  "select * from BRF202_SUMMARYTABLE WHERE   r1_s_no = ?1 ", nativeQuery = true)
	BRF202A_entity   getsrl_no(String  r1_s_no);
	
	@Query(value =  "select * from BRF202_SUMMARYTABLEwhere trunc(report_date)=?1 ", nativeQuery = true)
	List<Object[]>   findllvalues(String  todate);
	
}
