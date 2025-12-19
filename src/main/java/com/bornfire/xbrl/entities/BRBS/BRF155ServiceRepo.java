package com.bornfire.xbrl.entities.BRBS;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface BRF155ServiceRepo extends JpaRepository<BRF155reportentity  , Date>{
	@Query(value =  "SELECT *FROM ( SELECT t.*, ROWNUM AS rn FROM BRF_155 t) WHERE rn = 2", nativeQuery = true)
	List<BRF155reportentity  > getBRF155Del();
	
	@Query(value =  "SELECT *FROM ( SELECT t.*, ROWNUM AS rn FROM BRF_155 t) WHERE srl_no = ?1 AND DEL_FLG = 'N'", nativeQuery = true)
	BRF155reportentity   getSALARY_CODE(BigDecimal  srl_no);
	
	@Query(value = "select BRF_155_SRL_NO.nextval from dual", nativeQuery = true)
	BigDecimal srl_no();
	
	@Query(value =  "SELECT * FROM  BRF_155 where  del_flg = 'N' AND srl_no = ?1 ", nativeQuery = true)
	List<BRF155reportentity  > getDel(BigDecimal srl_no);
	
	@Query(value = "SELECT deal_date,buy_aed,buy_usd,ddm,sell_aed,sell_usd,srl_no FROM  BRF_155 where  del_flg = 'N'",nativeQuery = true) 
	List<Object[]> findByCIFID(BigDecimal srl_no); 
	
	@Query(value = "Select distinct FREQUENCY,REPORT_DATE,REPORT_CODE from BRF155_SUMMARYTABLE where report_code =?1 and repdesc =?2", nativeQuery = true)
	List<Object[]> getBRF155REPORTSERVICE(String reportid,String repdesc);
}
 