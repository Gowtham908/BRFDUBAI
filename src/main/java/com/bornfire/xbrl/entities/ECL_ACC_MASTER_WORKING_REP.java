package com.bornfire.xbrl.entities;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ECL_ACC_MASTER_WORKING_REP extends JpaRepository<ECL_ACC_MASTER_WORKING_ENTITY, String> { 
    @Query(value = "select * from ECL_ACC_MASTER_WORKING", nativeQuery = true)
    List<ECL_ACC_MASTER_WORKING_ENTITY> getaccmasterworking();
} 