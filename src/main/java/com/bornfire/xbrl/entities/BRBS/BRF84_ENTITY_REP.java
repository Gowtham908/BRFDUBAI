package com.bornfire.xbrl.entities.BRBS;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BRF84_ENTITY_REP  extends JpaRepository<BRF84B_ENTITY, Date>{
	
	@Query(value="select * from BRF84B_SUMMARYTABLE where report_date =?1",nativeQuery=true)
	List<Object[]> findentity2(String report_date);
	@Query(value="select * from BRF84B_SUMMARYTABLE where report_date =?1",nativeQuery=true)
	List<Object[]> findallvalues(String to_date);
	
	// CAPITAL CASE
    @Query(value = "SELECT DISTINCT tier_1_capital FROM BRF84A_SUMMARYTABLE WHERE trunc(report_date) = ?1", nativeQuery = true)
    String getTier1_capital(String value);
    
    
    @Query(value = "SELECT DISTINCT NVL(entity_level, '0') FROM BRF84A_SUMMARYTABLE WHERE trunc(report_date) = ?1", nativeQuery = true)
    String getEntity_level(String value);
	//FUNDED_OS
	@Query(value="Select nvl(sum(funded_os),0) from BRF84B_SUMMARYTABLE where part='PART C'",nativeQuery=true)
	String getfundc(String value);
	@Query(value="Select nvl(sum(funded_os),0) from BRF84B_SUMMARYTABLE where part='PART D'",nativeQuery=true)
	String getfundd(String value);
	//DEBT SECURITIES
	@Query(value="Select nvl(sum(debit_securities),0) from BRF84B_SUMMARYTABLE where part='PART C'",nativeQuery=true)
	String getdebtc(String value);
	@Query(value="Select nvl(sum(debit_securities),0) from BRF84B_SUMMARYTABLE where part='PART D'",nativeQuery=true)
	String getdebtd(String value);
	//UNFUNDED OS
	@Query(value="Select nvl(sum(unfunded_os),0) from BRF84B_SUMMARYTABLE where part='PART C'",nativeQuery=true)
	String getunfundc(String value);
	@Query(value="Select nvl(sum(unfunded_os),0) from BRF84B_SUMMARYTABLE where part='PART D'",nativeQuery=true)
	String getunfundd(String value);
	//CCF UNFUNDED OS
		@Query(value="Select nvl(sum(CCF_EQUI_UNFUNED_OS),0) from BRF84B_SUMMARYTABLE where part='PART C'",nativeQuery=true)
		String getccfundc(String value);
		@Query(value="Select nvl(sum(CCF_EQUI_UNFUNED_OS),0) from BRF84B_SUMMARYTABLE where part='PART D'",nativeQuery=true)
		String getccfundd(String value);
		//CCF UNFUND LIMITS
		@Query(value="Select nvl(sum(ccf_equi_funded_n_unfuned_limits),0) from BRF84B_SUMMARYTABLE where part='PART C'",nativeQuery=true)
		String getccfundlimitc(String value);
		@Query(value="Select nvl(sum(ccf_equi_funded_n_unfuned_limits),0) from BRF84B_SUMMARYTABLE where part='PART D'",nativeQuery=true)
		String getccfundlimitd(String value);
		//total exposure
		//@Query(value = "SELECT SUM(NVL(funded_os, 0) + NVL(debit_securities, 0) + NVL(CCF_EQUI_UNFUNED_OS, 0) + NVL(ccf_equi_funded_n_unfuned_limits, 0)) " +
            //    "FROM BRF84B_SUMMARYTABLE WHERE part = 'PART C'", nativeQuery = true)
		//String gettotexpoc(String value);

		//@Query(value = "SELECT SUM(NVL(funded_os, 0) + NVL(debit_securities, 0) + NVL(CCF_EQUI_UNFUNED_OS, 0) + NVL(ccf_equi_funded_n_unfuned_limits, 0)) " +
               // "FROM BRF84B_SUMMARYTABLE WHERE part = 'PART D'", nativeQuery = true)
		//String gettotexpod(String value);

				//Credit risk haircut
				@Query(value="Select nvl(sum(credit_risk_miti_hair_cut),0) from BRF84B_SUMMARYTABLE where part='PART C'",nativeQuery=true)
				String getcredithaircutc(String value);
				@Query(value="Select nvl(sum(credit_risk_miti_hair_cut),0) from BRF84B_SUMMARYTABLE where part='PART D'",nativeQuery=true)
				String getcredithaircutd(String value);
				//COLLATERAL VALUE
				@Query(value="Select nvl(sum(collateral_hair_cut),0) from BRF84B_SUMMARYTABLE where part='PART C'",nativeQuery=true)
				String getcollatralc(String value);
				@Query(value="Select nvl(sum(collateral_hair_cut),0) from BRF84B_SUMMARYTABLE where part='PART D'",nativeQuery=true)
				String getcollaterald(String value);
				//PROVISION
				@Query(value="Select nvl(sum(provision),0) from BRF84B_SUMMARYTABLE where part='PART C'",nativeQuery=true)
				String getprovisionc(String value);
				@Query(value="Select nvl(sum(provision),0) from BRF84B_SUMMARYTABLE where part='PART D'",nativeQuery=true)
				String getprovisiond(String value);
}