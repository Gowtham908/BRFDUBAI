package com.bornfire.xbrl.entities;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SCORE_CARD_PERSONAL_LOAN_REPO extends JpaRepository<SCORE_CARD_PERSONAL_LOAN_ENTITY, BigDecimal> {
	@Query(value = "select * from SCORE_CARD_PERSONAL_LOAN ", nativeQuery = true)
	List<SCORE_CARD_PERSONAL_LOAN_ENTITY> getCUSIDlist();
	
	@Query(value = "select * from SCORE_CARD_PERSONAL_LOAN where customer_id=?1 ", nativeQuery = true)
	List<SCORE_CARD_PERSONAL_LOAN_ENTITY> getDBR(String customer_id);
	
}