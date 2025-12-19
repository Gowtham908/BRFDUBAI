package com.bornfire.xbrl.entities;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ECL_COOLOFF_1_repo extends JpaRepository<ECL_COOLOFF_1, Date> {

    @Query(value = "SELECT * FROM ECL_COOLOFF_1", nativeQuery = true)
    List<ECL_COOLOFF_1> getECLCoolOff(); 
}
