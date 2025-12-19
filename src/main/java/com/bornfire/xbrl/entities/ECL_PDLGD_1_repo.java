package com.bornfire.xbrl.entities;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ECL_PDLGD_1_repo extends JpaRepository<ECL_PDLGD_ENTITY1, Date> {

    @Query(value = "SELECT * FROM PD_LGD_TABLE1", nativeQuery = true)
    List<ECL_PDLGD_ENTITY1> getECLpdlgd(); 
}
