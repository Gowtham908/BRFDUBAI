package com.bornfire.xbrl.entities.BRBS;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BRF77_ENTITY_REP extends JpaRepository<BRF77A_ENTITY, Date>{
	
	@Query(value="select * from BRF77A_SUMMARYTABLE where trunc(report_date)=?1",nativeQuery=true)
	List<Object[]> findllvalues(String reportdate);
	
	@Query(value = " select nvl(sum(funded_os),0)  from BRF77A_SUMMARYTABLE where trunc(report_date)=?1 ", nativeQuery = true)
	String getfundos(String value);

	@Query(value = " select nvl(sum(debit_securities),0)  from BRF77A_SUMMARYTABLE where trunc(report_date)=?1 ", nativeQuery = true)
	String getdebtsecurities(String value);

	@Query(value = " select nvl(sum(unfunded_os),0)  from BRF77A_SUMMARYTABLE where trunc(report_date)=?1 ", nativeQuery = true)
	String getunfundos(String value);

	@Query(value = " select nvl(sum(ccf_equi_unfuned_os),0)  from BRF77A_SUMMARYTABLE where trunc(report_date)=?1 ", nativeQuery = true)
	String getunfundccf(String value);

	@Query(value = " select nvl(sum(ccf_equi_funded_n_unfuned_limits),0)  from BRF77A_SUMMARYTABLE where trunc(report_date)=?1 ", nativeQuery = true)
	String getunusedunfundccf(String value);

	@Query(value = " select nvl(sum(as_of_tier1_capital),0)  from BRF77A_SUMMARYTABLE where trunc(report_date)=?1 ", nativeQuery = true)
	String gettier1(String value);

	@Query(value = " select nvl(sum(credit_risk_miti_hair_cut),0)  from BRF77A_SUMMARYTABLE where trunc(report_date)=?1 ", nativeQuery = true)
	String getcrmafterhaircut(String value);

	@Query(value = " select nvl(sum(collateral_hair_cut),0)  from BRF77A_SUMMARYTABLE where trunc(report_date)=?1 ", nativeQuery = true)
	String getcollateralafterhaircut(String value);

	@Query(value = " select nvl(sum(provision),0)  from BRF77A_SUMMARYTABLE where trunc(report_date)=?1 ", nativeQuery = true)
	String getprovision(String value);

	/*
	 * @Query(value =
	 * " select nvl(sum(total_exposure_reporting),0)  from BRF77A_SUMMARYTABLE where trunc(report_date)=?1 "
	 * , nativeQuery = true) String gettotalexposureafterhaircut(String value);
	 */
	// @Query(value=" select nvl(sum(total_exposure_ccf),0) from BRF77A_SUMMARYTABLE
	// where trunc(report_date)=?1 " ,nativeQuery=true) String gettotal(String
	// value);

	@Query(value = "  select (nvl(sum(funded_os),0)+ nvl(sum(debit_securities),0)+nvl(sum(ccf_equi_unfuned_os),0)+nvl(sum(ccf_equi_funded_n_unfuned_limits),0)) as total_exposure from BRF77A_SUMMARYTABLE WHERE trunc(report_date) =?1", nativeQuery = true)
	String gettotal(String value);
	@Query(value = "  select (nvl(sum(funded_os),0)+ nvl(sum(debit_securities),0)+nvl(sum(ccf_equi_unfuned_os),0)+nvl(sum(ccf_equi_funded_n_unfuned_limits),0)) as total_exposure1 from BRF77A_SUMMARYTABLE WHERE trunc(report_date) =?1", nativeQuery = true)
	String gettotal1(String value);
	
	@Query(value = "select DISTINCT capital_case  from BRF77A_SUMMARYTABLE where trunc(report_date)=?1 ", nativeQuery = true)
	String getcapitalcase(String value);

}

