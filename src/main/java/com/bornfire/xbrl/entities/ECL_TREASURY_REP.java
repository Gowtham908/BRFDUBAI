package com.bornfire.xbrl.entities;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ECL_TREASURY_REP extends JpaRepository<ECL_TREASURY_DATA, String> { 
    @Query(value = "select * from ECL_TREASURY_DATA", nativeQuery = true)
    List<ECL_TREASURY_DATA> gettreasurydata();
} 
