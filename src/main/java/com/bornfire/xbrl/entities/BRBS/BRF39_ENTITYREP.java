package com.bornfire.xbrl.entities.BRBS;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BRF39_ENTITYREP extends JpaRepository<BRF39_ENTITY, Date> {

	@Query(value = "select * from BRF39_SUMMARYTABLE where trunc(report_date)=?1", nativeQuery = true)
	List<Object[]> findllvalues(String reportdate);

	// CAPITAL CASE
	@Query(value = "select DISTINCT capital_case  from BRF39_SUMMARYTABLE where trunc(report_date)=?1 ", nativeQuery = true)
	String getcapitalcase(String value);
	
	

//SUM TOTAL
	@Query(value = " select nvl(sum(funded_os),0)  from BRF39_SUMMARYTABLE where trunc(report_date)=?1 ", nativeQuery = true)
	String getFunded_os(String value);

	@Query(value = " select nvl(sum(credit_risk),0)  from BRF39_SUMMARYTABLE where trunc(report_date)=?1 ", nativeQuery = true)
	String getCredit_risk(String value);

	@Query(value = " select nvl(sum(debt_securities),0)  from BRF39_SUMMARYTABLE where trunc(report_date)=?1 ", nativeQuery = true)
	String getDebt_securities(String value);

	@Query(value = " select nvl(sum(equities),0)  from BRF39_SUMMARYTABLE where trunc(report_date)=?1 ", nativeQuery = true)
	String getEquities(String value);

	@Query(value = " select nvl(sum(unfunded_os),0)  from BRF39_SUMMARYTABLE where trunc(report_date)=?1 ", nativeQuery = true)
	String getUnfunded_os(String value);

	@Query(value = " select nvl(sum(ccf_equivalent_of_unfunded_os),0)  from BRF39_SUMMARYTABLE where trunc(report_date)=?1 ", nativeQuery = true)
	String getCcf_equivalent_of_unfunded_os(String value);

	@Query(value = " select nvl(sum(ccf_equivalent_limits),0)  from BRF39_SUMMARYTABLE where trunc(report_date)=?1 ", nativeQuery = true)
	String getCcf_equivalent_limits(String value);

	@Query(value = "  select (nvl(sum(funded_os),0)+ nvl(sum(debt_securities),0)+nvl(sum(equities),0)+nvl(sum(ccf_equivalent_of_unfunded_os),0)+nvl(sum(ccf_equivalent_limits),0)) as total_exposure_without_credit_risk from BRF39_SUMMARYTABLE WHERE trunc(report_date) =?1", nativeQuery = true)
	String gettotalexposurewithout_creditrisk(String value);

	@Query(value = "  select (nvl(sum(funded_os),0)- nvl(sum(credit_risk),0)+nvl(sum(debt_securities),0)+nvl(sum(equities),0)+nvl(sum(ccf_equivalent_of_unfunded_os),0)+nvl(sum(ccf_equivalent_limits),0)) as total_exposure_net from BRF39_SUMMARYTABLE WHERE trunc(report_date) =?1", nativeQuery = true)
	String gettotal_exposure_net(String value);
//ISSUE
	/*
	 * @Query(value =
	 * "SELECT DISTINCT capital_case, CASE WHEN capital_case = 0 THEN 0 ELSE total_exposure_without_credit_risk / capital_case END AS tier_1_capital_without_credit_risk FROM BRF39_SUMMARYTABLE WHERE trunc(report_date) =?1"
	 * , nativeQuery = true) String getResult(String value);
	 * 
	 * @Query(value =
	 * "SELECT DISTINCT capital_case, CASE WHEN capital_case = 0 THEN 0 ELSE total_exposure_net / capital_case END AS tier_1_capital_without_net FROM BRF39_SUMMARYTABLE WHERE trunc(report_date) =?1"
	 * , nativeQuery = true) String getResult1(String value);
	 */

	
	

	/*
	 * @Query(value =
	 * "SELECT nvl((funded_os),0)+nvl((debt_securities),0)+nvl((equities),0)+nvl((ccf_equivalent_of_unfunded_os),0)+nvl((ccf_equivalent_limits),0)from BRF39_SUMMARYTABLE  WHERE trunc(report_date) =?1"
	 * , nativeQuery = true) BigDecimal gettotal_exposure_without_credit_risk(String
	 * value);
	 * 
	 * @Query(value =
	 * " select nvl(sum(total_exposure_without_credit_risk),0)  from BRF39_SUMMARYTABLE where trunc(report_date)=?1 "
	 * , nativeQuery = true) String getTotal_exposure_without_credit_risk(String
	 * value);
	 * 
	 * @Query(value =
	 * " select nvl(sum(total_exposure_net),0)  from BRF39_SUMMARYTABLE where trunc(report_date)=?1 "
	 * , nativeQuery = true) String getTotal_exposure_net(String value);
	 * 
	 * @Query(value =
	 * " select nvl(sum(tier_1_capital_without_credit_risk),0)  from BRF39_SUMMARYTABLE where trunc(report_date)=?1 "
	 * , nativeQuery = true) String getTier_1_capital_without_credit_risk(String
	 * value);
	 * 
	 * @Query(value =
	 * " select nvl(sum(tier_1_capital_without_net),0)  from BRF39_SUMMARYTABLE where trunc(report_date)=?1 "
	 * , nativeQuery = true) String getTier_1_capital_without_net(String value);
	 */
}
