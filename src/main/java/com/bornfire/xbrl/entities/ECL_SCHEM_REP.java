package com.bornfire.xbrl.entities;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ECL_SCHEM_REP extends JpaRepository<ECL_SCHEM_CODE, String> { 
    @Query(value = "select * from ECL_RETAIL_SEGMENT_CODE_MAPPING WHERE scheme_code IS NOT NULL", nativeQuery = true)
    List<ECL_SCHEM_CODE> getSCHEM();
} 


