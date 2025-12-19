package com.bornfire.xbrl.entities;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ECL_MAPPING_COUNTRY_CODE_REP extends JpaRepository<ECL_MAPPING_COUNTRY_CODE, String> { 
    @Query(value = "select * from ECL_COUNTRY_CODE_MAPPING", nativeQuery = true)
    List<ECL_MAPPING_COUNTRY_CODE> getcode();
}
