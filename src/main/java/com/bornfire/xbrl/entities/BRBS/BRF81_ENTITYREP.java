package com.bornfire.xbrl.entities.BRBS;

import java.util.List;
import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BRF81_ENTITYREP extends JpaRepository<BRF81_ENTITY, Date>  {

    @Query(value = "SELECT * FROM BRF81_SUMMARYTABLE WHERE trunc(report_date) = ?1", nativeQuery = true)
    List<Object[]> findllvalues(String reportDate);

    // CAPITAL CASE
    @Query(value = "SELECT DISTINCT tier1_capital FROM BRF81_SUMMARYTABLE WHERE trunc(report_date) = ?1", nativeQuery = true)
    String getTier1_capital(String value);
    
    
    @Query(value = "SELECT DISTINCT NVL(entity_level, '0') FROM BRF81_SUMMARYTABLE WHERE trunc(report_date) = ?1", nativeQuery = true)
    String getEntity_level(String value);



    // GRAND TOTAL
    @Query(value = "SELECT NVL(SUM(funded_os), 0) FROM BRF81_SUMMARYTABLE WHERE trunc(report_date) = ?1", nativeQuery = true)
    String getFundedOs(String value);

    @Query(value = "SELECT NVL(SUM(debit), 0) FROM BRF81_SUMMARYTABLE WHERE trunc(report_date) = ?1", nativeQuery = true)
    String getDebit(String value);

    @Query(value = "SELECT NVL(SUM(equities), 0) FROM BRF81_SUMMARYTABLE WHERE trunc(report_date) = ?1", nativeQuery = true)
    String getEquities(String value);

    @Query(value = "SELECT NVL(SUM(unfunded_os), 0) FROM BRF81_SUMMARYTABLE WHERE trunc(report_date) = ?1", nativeQuery = true)
    String getUnfundedOs(String value);

    @Query(value = "SELECT NVL(SUM(ccf_equi_unfuned_os), 0) FROM BRF81_SUMMARYTABLE WHERE trunc(report_date) = ?1", nativeQuery = true)
    String getCcfEquiUnfundedOs(String value);

    @Query(value = "SELECT NVL(SUM(ccf_equi_funded_n_unfuned_limits), 0) FROM BRF81_SUMMARYTABLE WHERE trunc(report_date) = ?1", nativeQuery = true)
    String getCcfEquiFundedAndUnfundedLimits(String value);

    @Query(value = "SELECT NVL(SUM(credit_risk_miti_hair_cut), 0) FROM BRF81_SUMMARYTABLE WHERE trunc(report_date) = ?1", nativeQuery = true)
    String getCredit_risk_miti_hair_cut(String value);
    
    @Query(value = "SELECT NVL(SUM(collateral_hair_cut), 0) FROM BRF81_SUMMARYTABLE WHERE trunc(report_date) = ?1", nativeQuery = true)
    String getCollateral_hair_cut(String value);
    
    @Query(value = "SELECT NVL(SUM(provision), 0) FROM BRF81_SUMMARYTABLE WHERE trunc(report_date) = ?1", nativeQuery = true)
    String getProvision(String value);

	
   
}
