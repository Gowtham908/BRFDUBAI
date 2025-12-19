package com.bornfire.xbrl.entities;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ECL_PAYMENT_FREQUENCY_rep extends JpaRepository<ECL_PAYMENT_FREQUENCY, String> { 
    @Query(value = "select * from ECL_PAYMENT_FREQUENCY", nativeQuery = true)
    List<ECL_PAYMENT_FREQUENCY> getpayfreq();
}