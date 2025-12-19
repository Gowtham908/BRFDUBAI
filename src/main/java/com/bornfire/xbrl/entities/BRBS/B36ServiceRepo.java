package com.bornfire.xbrl.entities.BRBS;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface B36ServiceRepo extends JpaRepository<BRF36_ENTITY , Date>{
	@Query(value =  "SELECT *FROM ( SELECT t.*, ROWNUM AS rn FROM BRF_36 t) WHERE rn = 2", nativeQuery = true)
	List<BRF36_ENTITY  > getBRF_36Del();
	
	@Query(value =  "SELECT *FROM ( SELECT t.*, ROWNUM AS rn FROM BRF_36 t) WHERE aed_equivalent = ?1 AND DEL_FLG = 'N'", nativeQuery = true)
	BRF36_ENTITY   getSALARY_CODE(String  aed_equivalent);
}
 
