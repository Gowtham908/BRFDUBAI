package com.bornfire.xbrl.entities.BRBS;


import java.math.BigDecimal;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface BRF102_REP extends JpaRepository<BRF102_Entity,BigDecimal> {
    @Query(value = "SELECT * FROM BRF102_SUMMARYTABLE WHERE report_date =?1 and account_number=?2", nativeQuery = true)
    List<BRF102_Entity> EditBRF102data(String todate,String account_number);
}
