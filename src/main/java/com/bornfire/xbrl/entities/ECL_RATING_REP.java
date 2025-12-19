package com.bornfire.xbrl.entities;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ECL_RATING_REP extends JpaRepository<ECL_RATING_ENTITY, String> { 
    @Query(value = "select * from ECL_RATING_DATA", nativeQuery = true)
    List<ECL_RATING_ENTITY> getrating();
}
