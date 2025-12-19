package com.bornfire.xbrl.entities.FWD_REVEAL;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

 
@Repository
@Transactional
public interface  Brf_FORWARD_REVEAL_MANUAL_REP  extends JpaRepository<  BRF_FORWARD_REVEAL_MANUAL_ENTITY, String> {

 

   @Query(value = "SELECT * FROM   BRF_FORWARD_REVEAL_MANUAL_TABLE" , nativeQuery = true)
    List<  BRF_FORWARD_REVEAL_MANUAL_ENTITY>  getassetcategory();
}
