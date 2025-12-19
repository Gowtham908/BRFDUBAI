package com.bornfire.xbrl.entities.BRBS;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BRF094_NEW_REP  extends JpaRepository<BRF094_SUMMARYENTITY6, String>{
	
	@Query(value="select * from BRF094F_SUMMARYTABLE where report_date =?1",nativeQuery=true)
	List<Object[]> findentity2(String report_date);
	
	@Query(value="select COUNTRY_BREAK_DOWN,(CASE\r\n" + 
			 
			"WHEN country_break_down in ('Remaining Countries') THEN remaining_countries\r\n" + 
			"END) as countries,GOVT_FINAN_INVEST_NO_OF_TRANSACTIONS,GOVT_FINAN_INVEST_AMOUNT,GOVT_DIRECT_INVEST_NO_OF_TRANSACTIONS,GOVT_DIRECT_INVEST_AMOUNT,\r\n" + 
			"GOVT_SERVICE_NO_OF_TRANSACTIONS,GOVT_SERVICE_INVEST_AMOUNT,GOVT_TRADE_NO_OF_TRANSACTIONS,GOVT_TRADE_INVEST_AMOUNT,RESERVE_FINAN_INVEST_NO_OF_TRANSACTIONS,RESERVE_FINAN_INVEST_AMOUNT,\r\n" + 
			"RESERVE_DIRECT_INVEST_NO_OF_TRANSACTIONS,RESERVE_DIRECT_INVEST_AMOUNT,RESERVE_SERVICE_NO_OF_TRANSACTIONS,RESERVE_SERVICE_INVEST_AMOUNT,RESERVE_TRADE_NO_OF_TRANSACTIONS,\r\n" + 
			"RESERVE_TRADE_INVEST_AMOUNT,GRE_FINAN_INVEST_NO_OF_TRANSACTIONS,GRE_FINAN_INVEST_AMOUNT,GRE_DIRECT_INVEST_NO_OF_TRANSACTIONS,GRE_DIRECT_INVEST_AMOUNT,GRE_SERVICE_NO_OF_TRANSACTIONS,\r\n" + 
			"GRE_SERVICE_INVEST_AMOUNT,GRE_TRADE_NO_OF_TRANSACTIONS,GRE_TRADE_INVEST_AMOUNT,CORPORATE_FINAN_INVEST_NO_OF_TRANSACTIONS,CORPORATE_FINAN_INVEST_AMOUNT,CORPORATE_DIRECT_INVEST_NO_OF_TRANSACTIONS,\r\n" + 
			"CORPORATE_DIRECT_INVEST_AMOUNT,CORPORATE_SERVICE_NO_OF_TRANSACTIONS,CORPORATE_SERVICE_INVEST_AMOUNT,CORPORATE_TRADE_NO_OF_TRANSACTIONS,CORPORATE_TRADE_INVEST_AMOUNT,\r\n" + 
			"SME_FINAN_INVEST_NO_OF_TRANSACTIONS,SME_FINAN_INVEST_AMOUNT,SME_DIRECT_INVEST_NO_OF_TRANSACTIONS,SME_DIRECT_INVEST_AMOUNT,SME_SERVICE_NO_OF_TRANSACTIONS,SME_SERVICE_INVEST_AMOUNT,\r\n" + 
			"SME_TRADE_NO_OF_TRANSACTIONS,SME_TRADE_INVEST_AMOUNT,INDVIDUAL_FINAN_INVEST_NO_OF_TRANSACTIONS,INDVIDUAL_FINAN_INVEST_AMOUNT,INDVIDUAL_DIRECT_INVEST_NO_OF_TRANSACTIONS,INDVIDUAL_DIRECT_INVEST_AMOUNT,\r\n" + 
			"INDVIDUAL_FAMILY_NO_OF_TRANSACTIONS,INDVIDUAL_FAMILY_INVEST_AMOUNT,INDVIDUAL_EDUCATE_NO_OF_TRANSACTIONS,INDVIDUAL_EDUCATE_INVEST_AMOUNT,INDVIDUAL_MEDICAL_NO_OF_TRANSACTIONS,\r\n" + 
			"INDVIDUAL_MEDICAL_INVEST_AMOUNT,INDVIDUAL_TOUR_NO_OF_TRANSACTIONS,INDVIDUAL_TOUR_INVEST_AMOUNT,INDVIDUAL_DEBT_NO_OF_TRANSACTIONS,INDVIDUAL_DEBT_INVEST_AMOUNT,INDVIDUAL_OTHER_NO_OF_TRANSACTIONS,\r\n" + 
			"INDVIDUAL_OTHER_INVEST_AMOUNT,(CASE\r\n" + 
			"WHEN TRANSACTIONS IS NULL THEN ((nvl(GOVT_FINAN_INVEST_NO_OF_TRANSACTIONS,0))+(nvl(GOVT_DIRECT_INVEST_NO_OF_TRANSACTIONS,0))+(nvl(GOVT_SERVICE_NO_OF_TRANSACTIONS,0))+(nvl(GOVT_TRADE_NO_OF_TRANSACTIONS,0))\r\n" + 
			"+(nvl(RESERVE_FINAN_INVEST_NO_OF_TRANSACTIONS,0))+(nvl(RESERVE_DIRECT_INVEST_NO_OF_TRANSACTIONS,0))+(nvl(RESERVE_SERVICE_NO_OF_TRANSACTIONS,0))+(nvl(RESERVE_TRADE_NO_OF_TRANSACTIONS,0))+(nvl(GRE_FINAN_INVEST_NO_OF_TRANSACTIONS,0))\r\n" + 
			"+(nvl(GRE_DIRECT_INVEST_NO_OF_TRANSACTIONS,0))+(nvl(GRE_SERVICE_NO_OF_TRANSACTIONS,0))+(nvl(GRE_TRADE_NO_OF_TRANSACTIONS,0))+(nvl(CORPORATE_FINAN_INVEST_NO_OF_TRANSACTIONS,0))+(nvl(CORPORATE_DIRECT_INVEST_NO_OF_TRANSACTIONS,0))\r\n" + 
			"+(nvl(CORPORATE_SERVICE_NO_OF_TRANSACTIONS,0))+(nvl(CORPORATE_TRADE_NO_OF_TRANSACTIONS,0))+(nvl(SME_FINAN_INVEST_NO_OF_TRANSACTIONS,0))+(nvl(SME_DIRECT_INVEST_NO_OF_TRANSACTIONS,0))+(nvl(SME_SERVICE_NO_OF_TRANSACTIONS,0))\r\n" + 
			"+(nvl(SME_TRADE_NO_OF_TRANSACTIONS,0))+(nvl(INDVIDUAL_FINAN_INVEST_NO_OF_TRANSACTIONS,0))+(nvl(INDVIDUAL_DIRECT_INVEST_NO_OF_TRANSACTIONS,0))+(nvl(INDVIDUAL_FAMILY_NO_OF_TRANSACTIONS,0))+(nvl(INDVIDUAL_EDUCATE_NO_OF_TRANSACTIONS,0))\r\n" + 
			"+(nvl(INDVIDUAL_MEDICAL_NO_OF_TRANSACTIONS,0))+(nvl(INDVIDUAL_TOUR_NO_OF_TRANSACTIONS,0))+(nvl(INDVIDUAL_DEBT_NO_OF_TRANSACTIONS,0))+(nvl(INDVIDUAL_OTHER_NO_OF_TRANSACTIONS,0)))\r\n" + 
			"ELSE TRANSACTIONS\r\n" + 
			"END) as TRANSACTIONS, (CASE\r\n" + 
			"WHEN AMOUNT IS NULL THEN ((nvl(GOVT_FINAN_INVEST_AMOUNT,0))+(nvl(GOVT_DIRECT_INVEST_AMOUNT,0))+(nvl(GOVT_SERVICE_INVEST_AMOUNT,0))+(nvl(GOVT_TRADE_INVEST_AMOUNT,0))+(nvl(RESERVE_FINAN_INVEST_AMOUNT,0))+(nvl(RESERVE_DIRECT_INVEST_AMOUNT,0))\r\n" + 
			"+(nvl(RESERVE_SERVICE_INVEST_AMOUNT,0))+(nvl(RESERVE_TRADE_INVEST_AMOUNT,0))+(nvl(GRE_FINAN_INVEST_AMOUNT,0))+(nvl(GRE_DIRECT_INVEST_AMOUNT,0))+(nvl(GRE_SERVICE_INVEST_AMOUNT,0))+(nvl(GRE_TRADE_INVEST_AMOUNT,0))+(nvl(CORPORATE_FINAN_INVEST_AMOUNT,0))\r\n" + 
			"+(nvl(CORPORATE_DIRECT_INVEST_AMOUNT,0))+(nvl(CORPORATE_SERVICE_INVEST_AMOUNT,0))+(nvl(CORPORATE_TRADE_INVEST_AMOUNT,0))+(nvl(SME_FINAN_INVEST_AMOUNT,0))+(nvl(SME_DIRECT_INVEST_AMOUNT,0))+(nvl(SME_SERVICE_INVEST_AMOUNT,0))+(nvl(SME_TRADE_INVEST_AMOUNT,0))\r\n" + 
			"+(nvl(INDVIDUAL_FINAN_INVEST_AMOUNT,0))+(nvl(INDVIDUAL_DIRECT_INVEST_AMOUNT,0))+(nvl(INDVIDUAL_FAMILY_INVEST_AMOUNT,0))+(nvl(INDVIDUAL_EDUCATE_INVEST_AMOUNT,0))+(nvl(INDVIDUAL_MEDICAL_INVEST_AMOUNT,0))+(nvl(INDVIDUAL_TOUR_INVEST_AMOUNT,0))\r\n" + 
			"+(nvl(INDVIDUAL_DEBT_INVEST_AMOUNT,0))+(nvl(INDVIDUAL_OTHER_INVEST_AMOUNT,0)))\r\n" + 
			"ELSE AMOUNT\r\n" + 
			"END) as AMOUNT, row_label\r\n" + 
			"from BRF094F_SUMMARYTABLE where report_date=?1",nativeQuery=true)
	List<Object[]> findallvalues(String to_date);
	
	
	///Remaining Countries
			//GOVT
			@Query(value="Select nvl(sum(govt_finan_invest_no_of_transactions),0) from BRF094F_SUMMARYTABLE where country_break_down='Remaining Countries'",nativeQuery=true)
			String getgovtfintranremain(String value);
			
			@Query(value="Select nvl(sum(govt_finan_invest_amount),0) from BRF094F_SUMMARYTABLE where country_break_down='Remaining Countries'",nativeQuery=true)
			String getgovtfinamountremain(String value);
			
			@Query(value="Select nvl(sum(govt_direct_invest_no_of_transactions),0) from BRF094F_SUMMARYTABLE where country_break_down='Remaining Countries'",nativeQuery=true)
			String getgovtdirtranremain(String value);
			
			@Query(value="Select nvl(sum(govt_direct_invest_amount),0) from BRF094F_SUMMARYTABLE where country_break_down='Remaining Countries'",nativeQuery=true)
			String getgovtdiramountremain(String value);
			
			@Query(value="Select nvl(sum(govt_service_no_of_transactions),0) from BRF094F_SUMMARYTABLE where country_break_down='Remaining Countries'",nativeQuery=true)
			String getgovtsertranremain(String value);
			
			@Query(value="Select nvl(sum(govt_service_invest_amount),0) from BRF094F_SUMMARYTABLE where country_break_down='Remaining Countries'",nativeQuery=true)
			String getgovtseramountremain(String value);
			
			@Query(value="Select nvl(sum(govt_trade_no_of_transactions),0) from BRF094F_SUMMARYTABLE where country_break_down='Remaining Countries'",nativeQuery=true)
			String getgovttradetranremain(String value);
			
			@Query(value="Select nvl(sum(govt_trade_invest_amount),0) from BRF094F_SUMMARYTABLE where country_break_down='Remaining Countries'",nativeQuery=true)
			String getgovttradeamountremain(String value);
			
			
			  //RESERVE
			  
			@Query(value = "Select nvl(sum(reserve_finan_invest_no_of_transactions),0) from BRF094F_SUMMARYTABLE where country_break_down='Remaining Countries'", nativeQuery = true)
			String getresfintranremain(String value);
			  
			@Query(value = "Select nvl(sum(reserve_finan_invest_amount),0) from BRF094F_SUMMARYTABLE where country_break_down='Remaining Countries'", nativeQuery = true)
			String getresfinamountremain(String value);

			@Query(value = "Select nvl(sum(reserve_direct_invest_no_of_transactions),0) from BRF094F_SUMMARYTABLE where country_break_down='Remaining Countries'", nativeQuery = true)
			String getresdirtranremain(String value);

			@Query(value = "Select nvl(sum(reserve_direct_invest_amount),0) from BRF094F_SUMMARYTABLE where country_break_down='Remaining Countries'", nativeQuery = true)
			String getresdiramountremain(String value);

			@Query(value = "Select nvl(sum(reserve_service_no_of_transactions),0) from BRF094F_SUMMARYTABLE where country_break_down='Remaining Countries'", nativeQuery = true)
			String getressertranremain(String value);

			@Query(value = "Select nvl(sum(reserve_service_invest_amount),0) from BRF094F_SUMMARYTABLE where country_break_down='Remaining Countries'", nativeQuery = true)
			String getresseramountremain(String value);

			@Query(value = "Select nvl(sum(reserve_trade_no_of_transactions),0) from BRF094F_SUMMARYTABLE where country_break_down='Remaining Countries'", nativeQuery = true)
			String getrestradetranremain(String value);

			@Query(value = "Select nvl(sum(reserve_trade_invest_amount),0) from BRF094F_SUMMARYTABLE where country_break_down='Remaining Countries'", nativeQuery = true)
			String getrestradeamountremain(String value);

			// GRE

			@Query(value = "Select nvl(sum(gre_finan_invest_no_of_transactions),0) from BRF094F_SUMMARYTABLE where country_break_down='Remaining Countries'", nativeQuery = true)
			String getgrefintranremain(String value);

			@Query(value = "Select nvl(sum(gre_finan_invest_amount),0) from BRF094F_SUMMARYTABLE where country_break_down='Remaining Countries'", nativeQuery = true)
			String getgrefinamountremain(String value);

			@Query(value = "Select nvl(sum(gre_direct_invest_no_of_transactions),0) from BRF094F_SUMMARYTABLE where country_break_down='Remaining Countries'", nativeQuery = true)
			String getgredirtranremain(String value);

			@Query(value = "Select nvl(sum(gre_direct_invest_amount),0) from BRF094F_SUMMARYTABLE where country_break_down='Remaining Countries'", nativeQuery = true)
			String getgrediramountremain(String value);

			@Query(value = "Select nvl(sum(gre_service_no_of_transactions),0) from BRF094F_SUMMARYTABLE where country_break_down='Remaining Countries'", nativeQuery = true)
			String getgresertranremain(String value);

			@Query(value = "Select nvl(sum(gre_service_invest_amount),0) from BRF094F_SUMMARYTABLE where country_break_down='Remaining Countries'", nativeQuery = true)
			String getgreseramountremain(String value);

			@Query(value = "Select nvl(sum(gre_trade_no_of_transactions),0) from BRF094F_SUMMARYTABLE where country_break_down='Remaining Countries'", nativeQuery = true)
			String getgretradetranremain(String value);

			@Query(value = "Select nvl(sum(gre_trade_invest_amount),0) from BRF094F_SUMMARYTABLE where country_break_down='Remaining Countries'", nativeQuery = true)
			String getgretradeamountremain(String value);
			//corporate
			
			@Query(value = "Select nvl(sum(corporate_finan_invest_no_of_transactions),0) from BRF094F_SUMMARYTABLE where country_break_down='Remaining Countries'", nativeQuery = true)
			String getcorfintranremain(String value);

			@Query(value = "Select nvl(sum(corporate_finan_invest_amount),0) from BRF094F_SUMMARYTABLE where country_break_down='Remaining Countries'", nativeQuery = true)
			String getcorfinamountremain(String value);

			@Query(value = "Select nvl(sum(corporate_direct_invest_no_of_transactions),0) from BRF094F_SUMMARYTABLE where country_break_down='Remaining Countries'", nativeQuery = true)
			String getcorpdirtranremain(String value);

			@Query(value = "Select nvl(sum(corporate_direct_invest_amount),0) from BRF094F_SUMMARYTABLE where country_break_down='Remaining Countries'", nativeQuery = true)
			String getcorpdiramountremain(String value);

			@Query(value = "Select nvl(sum(corporate_service_no_of_transactions),0) from BRF094F_SUMMARYTABLE where country_break_down='Remaining Countries'", nativeQuery = true)
			String getcorsertranremain(String value);

			@Query(value = "Select nvl(sum(corporate_service_invest_amount),0) from BRF094F_SUMMARYTABLE where country_break_down='Remaining Countries'", nativeQuery = true)
			String getcorseramountremain(String value);

			@Query(value = "Select nvl(sum(corporate_trade_no_of_transactions),0) from BRF094F_SUMMARYTABLE where country_break_down='Remaining Countries'", nativeQuery = true)
			String getcortradetranremain(String value);

			@Query(value = "Select nvl(sum(corporate_trade_invest_amount),0) from BRF094F_SUMMARYTABLE where country_break_down='Remaining Countries'", nativeQuery = true)
			String getcortradeamountremain(String value);
			
			//SME
			
			@Query(value = "Select nvl(sum(sme_finan_invest_no_of_transactions),0) from BRF094F_SUMMARYTABLE where country_break_down='Remaining Countries'", nativeQuery = true)
			String getsmefintranremain(String value);

			@Query(value = "Select nvl(sum(sme_finan_invest_amount),0) from BRF094F_SUMMARYTABLE where country_break_down='Remaining Countries'", nativeQuery = true)
			String getsmefinamountremain(String value);

			@Query(value = "Select nvl(sum(sme_direct_invest_no_of_transactions),0) from BRF094F_SUMMARYTABLE where country_break_down='Remaining Countries'", nativeQuery = true)
			String getsmedirtranremain(String value);

			@Query(value = "Select nvl(sum(sme_direct_invest_amount),0) from BRF094F_SUMMARYTABLE where country_break_down='Remaining Countries'", nativeQuery = true)
			String getsmediramountremain(String value);

			@Query(value = "Select nvl(sum(sme_service_no_of_transactions),0) from BRF094F_SUMMARYTABLE where country_break_down='Remaining Countries'", nativeQuery = true)
			String getsmesertranremain(String value);

			@Query(value = "Select nvl(sum(sme_service_invest_amount),0) from BRF094F_SUMMARYTABLE where country_break_down='Remaining Countries'", nativeQuery = true)
			String getsmeseramountremain(String value);

			@Query(value = "Select nvl(sum(sme_trade_no_of_transactions),0) from BRF094F_SUMMARYTABLE where country_break_down='Remaining Countries'", nativeQuery = true)
			String getsmetradetranremain(String value);

			@Query(value = "Select nvl(sum(sme_trade_invest_amount),0) from BRF094F_SUMMARYTABLE where country_break_down='Remaining Countries'", nativeQuery = true)
			String getsmetradeamountremain(String value);
			
			//INDIVIDUAL
			
			@Query(value = "Select nvl(sum(indvidual_finan_invest_no_of_transactions),0) from BRF094F_SUMMARYTABLE where country_break_down='Remaining Countries'", nativeQuery = true)
			String getindfintranremain(String value);

			@Query(value = "Select nvl(sum(indvidual_finan_invest_amount),0) from BRF094F_SUMMARYTABLE where country_break_down='Remaining Countries'", nativeQuery = true)
			String getindfinamountremain(String value);

			@Query(value = "Select nvl(sum(indvidual_direct_invest_no_of_transactions),0) from BRF094F_SUMMARYTABLE where country_break_down='Remaining Countries'", nativeQuery = true)
			String getinddirtranremain(String value);

			@Query(value = "Select nvl(sum(indvidual_direct_invest_amount),0) from BRF094F_SUMMARYTABLE where country_break_down='Remaining Countries'", nativeQuery = true)
			String getinddiramountremain(String value);

			@Query(value = "Select nvl(sum(indvidual_family_no_of_transactions),0) from BRF094F_SUMMARYTABLE where country_break_down='Remaining Countries'", nativeQuery = true)
			String getindfamtranremain(String value);

			@Query(value = "Select nvl(sum(indvidual_family_invest_amount),0) from BRF094F_SUMMARYTABLE where country_break_down='Remaining Countries'", nativeQuery = true)
			String getindfamamountremain(String value);

			@Query(value = "Select nvl(sum(indvidual_educate_no_of_transactions),0) from BRF094F_SUMMARYTABLE where country_break_down='Remaining Countries'", nativeQuery = true)
			String getindedutranremain(String value);

			@Query(value = "Select nvl(sum(indvidual_educate_invest_amount),0) from BRF094F_SUMMARYTABLE where country_break_down='Remaining Countries'", nativeQuery = true)
			String getindeduamountremain(String value);
			
			@Query(value = "Select nvl(sum(indvidual_medical_no_of_transactions),0) from BRF094F_SUMMARYTABLE where country_break_down='Remaining Countries'", nativeQuery = true)
			String getindmedtranremain(String value);

			@Query(value = "Select nvl(sum(indvidual_medical_invest_amount),0) from BRF094F_SUMMARYTABLE where country_break_down='Remaining Countries'", nativeQuery = true)
			String getindmedamountremain(String value);

			@Query(value = "Select nvl(sum(indvidual_tour_no_of_transactions),0) from BRF094F_SUMMARYTABLE where country_break_down='Remaining Countries'", nativeQuery = true)
			String getindtourtranremain(String value);

			@Query(value = "Select nvl(sum(indvidual_tour_invest_amount),0) from BRF094F_SUMMARYTABLE where country_break_down='Remaining Countries'", nativeQuery = true)
			String getindtourramountremain(String value);

			@Query(value = "Select nvl(sum(indvidual_debt_no_of_transactions),0) from BRF094F_SUMMARYTABLE where country_break_down='Remaining Countries'", nativeQuery = true)
			String getinddebttranremain(String value);

			@Query(value = "Select nvl(sum(indvidual_debt_invest_amount),0) from BRF094F_SUMMARYTABLE where country_break_down='Remaining Countries'", nativeQuery = true)
			String getinddebtamountremain(String value);

			@Query(value = "Select nvl(sum(indvidual_other_no_of_transactions),0) from BRF094F_SUMMARYTABLE where country_break_down='Remaining Countries'", nativeQuery = true)
			String getindothertranremain(String value);

			@Query(value = "Select nvl(sum(indvidual_other_invest_amount),0) from BRF094F_SUMMARYTABLE where country_break_down='Remaining Countries'", nativeQuery = true)
			String getindotheramountremain(String value);
			//ALL FEILDS(TRANSACTIONS) +COUNTRY
			////TOTAL.NO.OF.TRANSACTIONS
			@Query(value="SELECT nvl(sum(govt_finan_invest_no_of_transactions),0)+nvl(sum(govt_direct_invest_no_of_transactions),0)+nvl(sum(govt_service_no_of_transactions),0)+nvl(sum(govt_trade_no_of_transactions),0)+nvl(sum(reserve_finan_invest_no_of_transactions),0)+nvl(sum(reserve_direct_invest_no_of_transactions),0)+nvl(sum(reserve_service_no_of_transactions),0)+nvl(sum(reserve_trade_no_of_transactions),0)+nvl(sum(gre_finan_invest_no_of_transactions),0)+nvl(sum(gre_direct_invest_no_of_transactions),0)+nvl(sum(gre_service_no_of_transactions),0)+nvl(sum(gre_trade_no_of_transactions),0)+ nvl(sum(corporate_finan_invest_no_of_transactions),0)+nvl(sum(corporate_direct_invest_no_of_transactions),0)+nvl(sum(corporate_service_no_of_transactions),0)+nvl(sum(corporate_trade_no_of_transactions),0)+nvl(sum(sme_finan_invest_no_of_transactions),0)+nvl(sum(sme_direct_invest_no_of_transactions),0)+nvl(sum(sme_service_no_of_transactions),0)+nvl(sum(sme_trade_no_of_transactions),0)+nvl(sum(indvidual_finan_invest_no_of_transactions),0)+nvl(sum(indvidual_direct_invest_no_of_transactions),0)+nvl(sum(indvidual_family_no_of_transactions),0)+nvl(sum(indvidual_educate_no_of_transactions),0)+nvl(sum(indvidual_medical_no_of_transactions),0)+nvl(sum(indvidual_tour_no_of_transactions),0)+nvl(sum(indvidual_debt_no_of_transactions),0)+nvl(sum(indvidual_other_no_of_transactions),0) from BRF094F_SUMMARYTABLE where country_break_down='Remaining Countries'",nativeQuery=true)
		     String getremaintrantotal(String value);
			 ///ALL FEILD(AMOUNT)+country-amount

			 @Query(value="SELECT nvl(sum(govt_finan_invest_amount),0)+nvl(sum(govt_direct_invest_amount),0)+nvl(sum(govt_service_invest_amount),0)+nvl(sum(govt_trade_invest_amount),0)+nvl(sum(reserve_finan_invest_amount),0)+nvl(sum(reserve_direct_invest_amount),0)+nvl(sum(reserve_service_invest_amount),0)+nvl(sum(reserve_trade_invest_amount),0)+nvl(sum(gre_finan_invest_amount),0)+nvl(sum(gre_direct_invest_amount),0)+nvl(sum(gre_service_invest_amount),0)+nvl(sum(gre_trade_invest_amount),0)+ nvl(sum(corporate_finan_invest_amount),0)+nvl(sum(corporate_direct_invest_amount),0)+nvl(sum(corporate_service_invest_amount),0)+nvl(sum(corporate_trade_invest_amount),0)+nvl(sum(sme_finan_invest_amount),0)+nvl(sum(sme_direct_invest_amount),0)+nvl(sum(sme_service_invest_amount),0)+nvl(sum(sme_trade_invest_amount),0)+nvl(sum(indvidual_finan_invest_amount),0)+nvl(sum(indvidual_direct_invest_amount),0)+nvl(sum(indvidual_family_invest_amount),0)+nvl(sum(indvidual_educate_invest_amount),0)+nvl(sum(indvidual_medical_invest_amount),0)+nvl(sum(indvidual_tour_invest_amount),0)+nvl(sum(indvidual_debt_invest_amount),0)+nvl(sum(indvidual_other_invest_amount),0) from BRF094F_SUMMARYTABLE where country_break_down='Remaining Countries'",nativeQuery=true)
		     String getremainamounttotal(String value);
}
