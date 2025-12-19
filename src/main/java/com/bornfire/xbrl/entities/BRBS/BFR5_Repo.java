package com.bornfire.xbrl.entities.BRBS;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface BFR5_Repo extends JpaRepository<BRF5_ENTIITY  , Date>{
	@Query(value =  "SELECT *FROM ( SELECT t.*, ROWNUM AS rn FROM BRF_5 t) WHERE rn = 2", nativeQuery = true)
	List<BRF5_ENTIITY  > getBRF_5Del();
	
	@Query(value =  "SELECT *FROM ( SELECT t.*, ROWNUM AS rn FROM BRF_5 t) WHERE srl_no = ?1 AND DEL_FLG = 'N'", nativeQuery = true)
	BRF5_ENTIITY   getSALARY_CODE(BigDecimal  srl_no);
	
	@Query(value = "select BRF_5_SRL_NO.nextval from dual", nativeQuery = true)
	BigDecimal srl_no();

	
	@Query(value =  "SELECT * FROM  BRF_5 where  del_flg = 'N' AND srl_no = ?1 ", nativeQuery = true)
	List<BRF5_ENTIITY  > getDel(BigDecimal srl_no);
	
	@Query(value = "SELECT Investment,Security_missing,Nominal_value,Units,country,ccy,amount,aed,rating,rating_type,market_value,country_party,srl_no FROM  BRF_5 where  del_flg = 'N'",nativeQuery = true) 
	List<Object[]> findByCIFID(BigDecimal srl_no); 

	@Query(value = "SELECT * FROM BRF_5 WHERE del_flg = 'N' AND srl_no = ?1 ORDER BY timestamp_column DESC LIMIT 1", nativeQuery = true)
	List<BRF5_ENTIITY> getLatestData(BigDecimal srl_no);



}
 