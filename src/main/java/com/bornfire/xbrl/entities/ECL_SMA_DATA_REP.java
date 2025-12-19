package com.bornfire.xbrl.entities;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ECL_SMA_DATA_REP extends JpaRepository<ECL_SMA_DATA_ENTITY, String> { 
    @Query(value = "select * from ECL_SMA_DATA_TABLE", nativeQuery = true)
    List<ECL_SMA_DATA_ENTITY> getsmadata();
} 
