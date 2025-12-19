package com.bornfire.xbrl.entities;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ECL_CUSTMASTER_REP extends JpaRepository<ECL_CUSTMASTER_ENTITY, String> { 
    @Query(value = "select * from ECL_CUST_MASTER", nativeQuery = true)
    List<ECL_CUSTMASTER_ENTITY> getcustmaster();
} 