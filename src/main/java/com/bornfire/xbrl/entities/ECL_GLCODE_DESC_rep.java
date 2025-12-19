package com.bornfire.xbrl.entities;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ECL_GLCODE_DESC_rep extends JpaRepository<ECL_GLCODE_DESC, String> { 
    @Query(value = "select * from ECL_GLCODE_MAPPING", nativeQuery = true)
    List<ECL_GLCODE_DESC> getglcode();
}
