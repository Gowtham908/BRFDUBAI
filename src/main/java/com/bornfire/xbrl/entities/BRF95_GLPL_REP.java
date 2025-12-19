package com.bornfire.xbrl.entities;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface BRF95_GLPL_REP extends JpaRepository<BRF95_GL_PL_DATA_ENTITY, String> {
	
	@Query(value = "select NVL(MAX(TO_NUMBER(SCH)),0) from BRF95_GL_PL_DATA_TABLE", nativeQuery = true)
	Double getsrlno();
	
	

}
