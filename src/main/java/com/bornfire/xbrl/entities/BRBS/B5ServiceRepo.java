package com.bornfire.xbrl.entities.BRBS;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface B5ServiceRepo extends JpaRepository<BRF5_ENTITY , Date>{
	@Query(value =  "SELECT *FROM ( SELECT t.*, ROWNUM AS rn FROM BRF5_SUMMARYTABLE t) WHERE rn = 2", nativeQuery = true)
	List<BRF5_ENTITY  > getBRF_5Del();
	
	@Query(value =  "SELECT *FROM ( SELECT t.*, ROWNUM AS rn FROM BRF5_SUMMARYTABLE t) WHERE aed = ?1 AND DEL_FLG = 'N'", nativeQuery = true)
	BRF5_ENTITY   getSALARY_CODE(String  aed);
}
 
 