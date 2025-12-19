package com.bornfire.xbrl.entities.BRBS;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BRF59_ENTITY_REP  extends JpaRepository<BRF59E_ENTITY, String>{
	
	@Query(value="select * from BRF59E_SUMMARYTABLE where report_date =?1",nativeQuery=true)
	List<Object[]> findentity2(String report_date);
	
	@Query(value = "select * from BRF59E_SUMMARYTABLE where report_date =?1", nativeQuery = true)
	List<Object[]> findallvalues(String to_date);

	
	
	///REMAINING_COUNTRIES
			 
			@Query(value="Select nvl(sum(nbfi),0) from BRF59E_SUMMARYTABLE where country_break_down='REMAINING_COUNTRIES'",nativeQuery=true)
			String getnbfi(String value);
			
			@Query(value="Select nvl(sum(interbank),0) from BRF59E_SUMMARYTABLE where country_break_down='REMAINING_COUNTRIES'",nativeQuery=true)
			String getinterbank(String value);
			
			@Query(value="Select nvl(sum(gov),0) from BRF59E_SUMMARYTABLE where country_break_down='REMAINING_COUNTRIES'",nativeQuery=true)
			String getgov(String value);
			
			@Query(value="Select nvl(sum(corporate),0) from BRF59E_SUMMARYTABLE where country_break_down='REMAINING_COUNTRIES'",nativeQuery=true)
			String getcorporate(String value);
			
			@Query(value="Select nvl(sum(gre),0) from BRF59E_SUMMARYTABLE where country_break_down='REMAINING_COUNTRIES'",nativeQuery=true)
			String getgre(String value);
			
			@Query(value="Select nvl(sum(trade),0) from BRF59E_SUMMARYTABLE where country_break_down='REMAINING_COUNTRIES'",nativeQuery=true)
			String gettrade(String value);
			
			@Query(value="Select nvl(sum(individuals),0) from BRF59E_SUMMARYTABLE where country_break_down='REMAINING_COUNTRIES'",nativeQuery=true)
			String getindividuals(String value);
			
			@Query(value="Select nvl(sum(investment),0) from BRF59E_SUMMARYTABLE where country_break_down='REMAINING_COUNTRIES'",nativeQuery=true)
			String getinvestment(String value);
			
			
		//1	   
			  
			@Query(value = "Select nvl(sum(nbfi1),0) from BRF59E_SUMMARYTABLE where country_break_down='REMAINING_COUNTRIES'", nativeQuery = true)
			String getnbfi1(String value);
			  
			@Query(value = "Select nvl(sum(interbank1),0) from BRF59E_SUMMARYTABLE where country_break_down='REMAINING_COUNTRIES'", nativeQuery = true)
			String getinterbank1(String value);

			@Query(value = "Select nvl(sum(gov1),0) from BRF59E_SUMMARYTABLE where country_break_down='REMAINING_COUNTRIES'", nativeQuery = true)
			String getgov1(String value);

			@Query(value = "Select nvl(sum(corporate1),0) from BRF59E_SUMMARYTABLE where country_break_down='REMAINING_COUNTRIES'", nativeQuery = true)
			String getcorporate1(String value);

			@Query(value = "Select nvl(sum(gre1),0) from BRF59E_SUMMARYTABLE where country_break_down='REMAINING_COUNTRIES'", nativeQuery = true)
			String getgre1(String value);

			@Query(value = "Select nvl(sum(trade1),0) from BRF59E_SUMMARYTABLE where country_break_down='REMAINING_COUNTRIES'", nativeQuery = true)
			String gettrade1(String value);

			@Query(value = "Select nvl(sum(individuals1),0) from BRF59E_SUMMARYTABLE where country_break_down='REMAINING_COUNTRIES'", nativeQuery = true)
			String getindividuals1(String value);

			@Query(value = "Select nvl(sum(investment1),0) from BRF59E_SUMMARYTABLE where country_break_down='REMAINING_COUNTRIES'", nativeQuery = true)
			String getinvestment1(String value);

			 

			@Query(value = "Select nvl(sum(zer0),0) from BRF59E_SUMMARYTABLE where country_break_down='REMAINING_COUNTRIES'", nativeQuery = true)
			String getzer0(String value);

			@Query(value = "Select nvl(sum(three),0) from BRF59E_SUMMARYTABLE where country_break_down='REMAINING_COUNTRIES'", nativeQuery = true)
			String getthree(String value);

			@Query(value = "Select nvl(sum(six),0) from BRF59E_SUMMARYTABLE where country_break_down='REMAINING_COUNTRIES'", nativeQuery = true)
			String getsix(String value);

			@Query(value = "Select nvl(sum(oneyear),0) from BRF59E_SUMMARYTABLE where country_break_down='REMAINING_COUNTRIES'", nativeQuery = true)
			String getoneyear(String value);

			@Query(value = "Select nvl(sum(foreign),0) from BRF59E_SUMMARYTABLE where country_break_down='REMAINING_COUNTRIES'", nativeQuery = true)
			String getforeign(String value);

			@Query(value = "Select nvl(sum(banks),0) from BRF59E_SUMMARYTABLE where country_break_down='REMAINING_COUNTRIES'", nativeQuery = true)
			String getbanks(String value);

			@Query(value = "Select nvl(sum(gov2),0) from BRF59E_SUMMARYTABLE where country_break_down='REMAINING_COUNTRIES'", nativeQuery = true)
			String getgov2(String value);

			@Query(value = "Select nvl(sum(other),0) from BRF59E_SUMMARYTABLE where country_break_down='REMAINING_COUNTRIES'", nativeQuery = true)
			String getother(String value);
			 
			
			@Query(value = "Select nvl(sum(banks1),0) from BRF59E_SUMMARYTABLE where country_break_down='REMAINING_COUNTRIES'", nativeQuery = true)
			String getbanks1(String value);

			@Query(value = "Select nvl(sum(individuals2),0) from BRF59E_SUMMARYTABLE where country_break_down='REMAINING_COUNTRIES'", nativeQuery = true)
			String getindividuals2(String value);

			@Query(value = "Select nvl(sum(other1),0) from BRF59E_SUMMARYTABLE where country_break_down='REMAINING_COUNTRIES'", nativeQuery = true)
			String getother1(String value);

			@Query(value = "Select nvl(sum(banks2),0) from BRF59E_SUMMARYTABLE where country_break_down='REMAINING_COUNTRIES'", nativeQuery = true)
			String getbanks2(String value);

			@Query(value = "Select nvl(sum(gov3),0) from BRF59E_SUMMARYTABLE where country_break_down='REMAINING_COUNTRIES'", nativeQuery = true)
			String getgov3(String value);

			@Query(value = "Select nvl(sum(others2),0) from BRF59E_SUMMARYTABLE where country_break_down='REMAINING_COUNTRIES'", nativeQuery = true)
			String getothers2(String value);

			@Query(value = "Select nvl(sum(banks3),0) from BRF59E_SUMMARYTABLE where country_break_down='REMAINING_COUNTRIES'", nativeQuery = true)
			String getbanks3(String value);

			@Query(value = "Select nvl(sum(gov4),0) from BRF59E_SUMMARYTABLE where country_break_down='REMAINING_COUNTRIES'", nativeQuery = true)
			String getgov4(String value);
			
			 
			
			@Query(value = "Select nvl(sum(others3),0) from BRF59E_SUMMARYTABLE where country_break_down='REMAINING_COUNTRIES'", nativeQuery = true)
			String getothers3(String value);

			@Query(value = "Select nvl(sum(foreign1),0) from BRF59E_SUMMARYTABLE where country_break_down='REMAINING_COUNTRIES'", nativeQuery = true)
			String getforeign1(String value);

			@Query(value = "Select nvl(sum(guarantees),0) from BRF59E_SUMMARYTABLE where country_break_down='REMAINING_COUNTRIES'", nativeQuery = true)
			String getguarantees(String value);

			@Query(value = "Select nvl(sum(nbfi2),0) from BRF59E_SUMMARYTABLE where country_break_down='REMAINING_COUNTRIES'", nativeQuery = true)
			String getnbfi2(String value);

			@Query(value = "Select nvl(sum(interbank2),0) from BRF59E_SUMMARYTABLE where country_break_down='REMAINING_COUNTRIES'", nativeQuery = true)
			String getinterbank2(String value);

			@Query(value = "Select nvl(sum(gov5),0) from BRF59E_SUMMARYTABLE where country_break_down='REMAINING_COUNTRIES'", nativeQuery = true)
			String getgov5(String value);

			@Query(value = "Select nvl(sum(corporate2),0) from BRF59E_SUMMARYTABLE where country_break_down='REMAINING_COUNTRIES'", nativeQuery = true)
			String getcorporate2(String value);

			@Query(value = "Select nvl(sum(gre2),0) from BRF59E_SUMMARYTABLE where country_break_down='REMAINING_COUNTRIES'", nativeQuery = true)
			String getgre2(String value);
			
			 
			
			@Query(value = "Select nvl(sum(individuals3),0) from BRF59E_SUMMARYTABLE where country_break_down='REMAINING_COUNTRIES'", nativeQuery = true)
			String getindividuals3(String value);

			@Query(value = "Select nvl(sum(zero1),0) from BRF59E_SUMMARYTABLE where country_break_down='REMAINING_COUNTRIES'", nativeQuery = true)
			String getzero1(String value);

			@Query(value = "Select nvl(sum(three1),0) from BRF59E_SUMMARYTABLE where country_break_down='REMAINING_COUNTRIES'", nativeQuery = true)
			String getthree1(String value);

			@Query(value = "Select nvl(sum(six1),0) from BRF59E_SUMMARYTABLE where country_break_down='REMAINING_COUNTRIES'", nativeQuery = true)
			String getsix1(String value);

			@Query(value = "Select nvl(sum(oneyear1),0) from BRF59E_SUMMARYTABLE where country_break_down='REMAINING_COUNTRIES'", nativeQuery = true)
			String getoneyear1(String value);
}

			 
			 
