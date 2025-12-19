package com.bornfire.xbrl.entities;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ECL_INFO_REP extends JpaRepository<ECL_INFOFLG, String> { 
    @Query(value = "select * from ECL_MAPPING_INFOFLG", nativeQuery = true)
    List<ECL_INFOFLG> getINFO();
}
