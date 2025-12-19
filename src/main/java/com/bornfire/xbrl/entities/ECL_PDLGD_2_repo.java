package com.bornfire.xbrl.entities;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ECL_PDLGD_2_repo extends JpaRepository<ECL_PDLGD_ENTITY2, Date> {

    @Query(value = "SELECT * FROM PD_LGD_TABLE2", nativeQuery = true)
    List<ECL_PDLGD_ENTITY2> getECLpdlgd(); 
}
