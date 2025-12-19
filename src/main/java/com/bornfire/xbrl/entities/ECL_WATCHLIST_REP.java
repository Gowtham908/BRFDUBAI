package com.bornfire.xbrl.entities;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ECL_WATCHLIST_REP extends JpaRepository<ECL_WATCHLIST_ENTITY, BigDecimal> { 
    @Query(value = "select * from ECL_WATCHLIST_TABLE", nativeQuery = true)
    List<ECL_WATCHLIST_ENTITY> getwatchlistdata();
} 
