package com.bornfire.xbrl.entities.services;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bornfire.xbrl.entities.BRBS.BRF36_ENTITY;
//import com.bornfire.xbrl.entities.BRBS.BRF5_ENTITY;

@Repository
public interface BRF36_Repo extends JpaRepository<BRF36_ENTITY  , Date>{
	@Query(value =  "SELECT *FROM ( SELECT t.*, ROWNUM AS rn FROM BRF_36 t) WHERE rn = 2", nativeQuery = true)
	List<BRF36_ENTITY  > getBRF_36Del();
	
	@Query(value =  "SELECT *FROM ( SELECT t.*, ROWNUM AS rn FROM BRF_36 t) WHERE srl_no = ?1 AND DEL_FLG = 'N'", nativeQuery = true)
	BRF36_ENTITY   getSALARY_CODE(BigDecimal  srl_no);
	
	@Query(value = "select BRF_36_SRL_NO.nextval from dual", nativeQuery = true)
	BigDecimal srl_no();

	
	@Query(value =  "SELECT * FROM  BRF_36 where  del_flg = 'N' AND srl_no = ?1 ", nativeQuery = true)
	List<BRF36_ENTITY  > getDel(BigDecimal srl_no);
	
	@Query(value = "SELECT progarm_instrument_name,currency_of_issue,size_of_prgoam,aed_equivalent,aed_iss_total,month_upto3,month3to6,month6to9,month9to12,year1to2,year2to3,year3to4,year4to5,year_upto5,srl_no FROM  BRF_36 where  del_flg = 'N'",nativeQuery = true) 
	List<Object[]> findByCIFID(BigDecimal srl_no); 

	@Query(value = "SELECT * FROM BRF_36 WHERE del_flg = 'N' AND srl_no = ?1 ORDER BY timestamp_column DESC LIMIT 1", nativeQuery = true)
	List<BRF36_ENTITY> getLatestData(BigDecimal srl_no);



}