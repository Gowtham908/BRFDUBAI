package com.bornfire.xbrl.entities.M_BILL;

import java.util.List;


import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

 
@Repository
@Transactional
public interface  BrfMBillRep  extends JpaRepository<BRF_M_BILL_ENTITY,BRF_M_BILL_ID> {

 

   @Query(value = "SELECT * FROM   BRF_MATURITY_BILL_MANUAL_TABLE" , nativeQuery = true)
    List<BRF_M_BILL_ENTITY>  getassetcategory();
    




}
