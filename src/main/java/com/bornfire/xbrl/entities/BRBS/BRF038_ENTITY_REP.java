package com.bornfire.xbrl.entities.BRBS;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BRF038_ENTITY_REP extends JpaRepository<BRF38_ENTITY, String>{
	
	@Query(value="select * from BRF38_SUMMARYTABLE where row_label =?1",nativeQuery=true)
	List<Object[]> findllvalues(String row_label);
	
	@Query(value="select * from BRF38_SUMMARYTABLE where country_break_down =?1",nativeQuery=true)
	List<BRF38_ENTITY> findllNorthAmericanCountries(String row_label);
	
	@Query(value="select * from BRF38_SUMMARYTABLE where country_break_down =?1",nativeQuery=true)
	List<BRF38_ENTITY> findllvaluesEuropean(String row_label);
	
	@Query(value="select nvl(sum(outward_family),0)+nvl(sum(outward_investment),0)+nvl(sum(outward_other),0)+nvl(sum(outward_trade),0) from brf38_summarytable where country_break_down='North American Countries'",nativeQuery=true)
	String getnorthamouttotal(String value);
	
	@Query(value="SELECT nvl(sum(outward_family),0)+nvl(sum(outward_investment),0)+nvl(sum(outward_other),0)+nvl(sum(outward_trade),0) from brf38_summarytable where country_break_down='European Countries'",nativeQuery=true)
	String geteurohamouttotal(String value);
	
	@Query(value="SELECT nvl(sum(outward_family),0)+nvl(sum(outward_investment),0)+nvl(sum(outward_other),0)+nvl(sum(outward_trade),0) from brf38_summarytable where country_break_down='GCC Countries'",nativeQuery=true)
	String getgccamouttotal(String value);
	
	@Query(value="SELECT nvl(sum(outward_family),0)+nvl(sum(outward_investment),0)+nvl(sum(outward_other),0)+nvl(sum(outward_trade),0) from brf38_summarytable where country_break_down='Mena Countries'",nativeQuery=true)
	String getmenamouttotal(String value);
	
	@Query(value="SELECT nvl(sum(outward_family),0)+nvl(sum(outward_investment),0)+nvl(sum(outward_other),0)+nvl(sum(outward_trade),0) from brf38_summarytable where country_break_down='Sub-Saharan Countries'",nativeQuery=true)
	String getsubsharanouttotal(String value);
	
	@Query(value="SELECT nvl(sum(outward_family),0)+nvl(sum(outward_investment),0)+nvl(sum(outward_other),0)+nvl(sum(outward_trade),0) from brf38_summarytable where country_break_down='Asian Countries'",nativeQuery=true)
	String getasianamouttotal(String value);
	
	@Query(value="SELECT nvl(sum(outward_family),0)+nvl(sum(outward_investment),0)+nvl(sum(outward_other),0)+nvl(sum(outward_trade),0) from brf38_summarytable where country_break_down='Oceania Countries'",nativeQuery=true)
	String getoceianamouttotal(String value);
	
	@Query(value="SELECT nvl(sum(outward_family),0)+nvl(sum(outward_investment),0)+nvl(sum(outward_other),0)+nvl(sum(outward_trade),0) from brf38_summarytable where country_break_down='Latin American Countries'",nativeQuery=true)
	String getlatinamouttotal(String value);
	
	@Query(value="SELECT nvl(sum(outward_family),0)+nvl(sum(outward_investment),0)+nvl(sum(outward_other),0)+nvl(sum(outward_trade),0) from brf38_summarytable where country_break_down='Remaining Countries'",nativeQuery=true)
	String getreaminingamouttotal(String value);
	/*
	 * @Query(
	 * value="SELECT nvl(sum(outward_family),0)+nvl(sum(outward_investment),0)+nvl(sum(outward_other),0)+nvl(sum(outward_trade),0) from brf38_summarytable where country_break_down='GRAND TOTAL'"
	 * ,nativeQuery=true) String getgrandtotoutwardtotal(String value);
	 */
	
	
	@Query(value="SELECT nvl(sum(INWARD_family),0)+nvl(sum(INWARD_investment),0)+nvl(sum(INWARD_other),0)+nvl(sum(INWARD_trade),0) from brf38_summarytable where country_break_down='North American Countries'",nativeQuery=true)
	String getnorthamintotal(String value);
	
	@Query(value="SELECT nvl(sum(INWARD_family),0)+nvl(sum(INWARD_investment),0)+nvl(sum(INWARD_other),0)+nvl(sum(INWARD_trade),0) from brf38_summarytable where country_break_down='European Countries'",nativeQuery=true)
	String geteurohamintotal(String value);
	
	@Query(value="SELECT nvl(sum(INWARD_family),0)+nvl(sum(INWARD_investment),0)+nvl(sum(INWARD_other),0)+nvl(sum(INWARD_trade),0) from brf38_summarytable where country_break_down='GCC Countries'",nativeQuery=true)
	String getgccamintotal(String value);
	
	@Query(value="SELECT nvl(sum(INWARD_family),0)+nvl(sum(INWARD_investment),0)+nvl(sum(INWARD_other),0)+nvl(sum(INWARD_trade),0) from brf38_summarytable where country_break_down='Mena Countries'",nativeQuery=true)
	String getmenamintotal(String value);
	
	@Query(value="SELECT nvl(sum(INWARD_family),0)+nvl(sum(INWARD_investment),0)+nvl(sum(INWARD_other),0)+nvl(sum(INWARD_trade),0) from brf38_summarytable where country_break_down='Sub-Saharan Countries'",nativeQuery=true)
	String getsubsharanintotal(String value);
	
	@Query(value="SELECT nvl(sum(INWARD_family),0)+nvl(sum(INWARD_investment),0)+nvl(sum(INWARD_other),0)+nvl(sum(INWARD_trade),0) from brf38_summarytable where country_break_down='Asian Countries'",nativeQuery=true)
	String getasianamintotal(String value);
	
	@Query(value="select nvl(sum(INWARD_family),0)+nvl(sum(INWARD_investment),0)+nvl(sum(INWARD_other),0)+nvl(sum(INWARD_trade),0) from brf38_summarytable where country_break_down='Oceania Countries'",nativeQuery=true)
	String getoceianamintotal(String value);
	
	@Query(value="SELECT nvl(sum(INWARD_family),0)+nvl(sum(INWARD_investment),0)+nvl(sum(INWARD_other),0)+nvl(sum(INWARD_trade),0) from brf38_summarytable where country_break_down='Latin American Countries'",nativeQuery=true)
	String getlatinamintotal(String value);
	
	@Query(value="select nvl(sum(INWARD_family),0)+nvl(sum(INWARD_investment),0)+nvl(sum(INWARD_other),0)+nvl(sum(INWARD_trade),0) from brf38_summarytable where country_break_down='Remaining Countries'",nativeQuery=true)
	String getreaminingamintotal(String value);
	
	/*
	 * @Query(
	 * value="select nvl(sum(INWARD_family),0)+nvl(sum(INWARD_investment),0)+nvl(sum(INWARD_other),0)+nvl(sum(INWARD_trade),0) from brf38_summarytable where country_break_down='GRAND TOTAL'"
	 * ,nativeQuery=true) String getgrandtotinwardtotal(String value);
	 */
	
	
	
	
//North American Countries	
	@Query(value="Select nvl(sum(OUTWARD_FAMILY),0) from brf38_summarytable where country_break_down='North American Countries'",nativeQuery=true)
	String getnorthoutwardfam(String value);
	
	@Query(value="Select nvl(sum(INWARD_FAMILY),0) from brf38_summarytable where country_break_down='North American Countries'",nativeQuery=true)
	String getnorthinwardfam(String value);
	
	@Query(value="Select nvl(sum(OUTWARD_INVESTMENT),0) from brf38_summarytable where country_break_down='North American Countries'",nativeQuery=true)
	String getnorthoutwardinvest(String value);
	
	@Query(value="Select nvl(sum(INWARD_INVESTMENT),0) from brf38_summarytable where country_break_down='North American Countries'",nativeQuery=true)
	String getnorthinwardinvest(String value);
	
	@Query(value="Select nvl(sum(OUTWARD_TRADE),0) from brf38_summarytable where country_break_down='North American Countries'",nativeQuery=true)
	String getnorthoutwardtrade(String value);
	
	@Query(value="Select nvl(sum(INWARD_TRADE),0) from brf38_summarytable where country_break_down='North American Countries'",nativeQuery=true)
	String getnorthinwardtrade(String value);
	
	@Query(value="Select nvl(sum(OUTWARD_OTHER),0) from brf38_summarytable where country_break_down='North American Countries'",nativeQuery=true)
	String getnorthoutwardother(String value);
	
	@Query(value="Select nvl(sum(INWARD_OTHER),0) from brf38_summarytable where country_break_down='North American Countries'",nativeQuery=true)
	String getnorthinwardother(String value);

//EUROPEAN
	@Query(value="Select nvl(sum(OUTWARD_FAMILY),0) from brf38_summarytable where country_break_down='European Countries'",nativeQuery=true)
	String geteurooutwardfam(String value);
	
	@Query(value="Select nvl(sum(INWARD_FAMILY),0) from brf38_summarytable where country_break_down='European Countries'",nativeQuery=true)
	String geteuroinwardfam(String value);
	
	@Query(value="Select nvl(sum(OUTWARD_INVESTMENT),0) from brf38_summarytable where country_break_down='European Countries'",nativeQuery=true)
	String geteurooutwardinvest(String value);
	
	@Query(value="Select nvl(sum(INWARD_INVESTMENT),0) from brf38_summarytable where country_break_down='European Countries'",nativeQuery=true)
	String geteuroinwardinvest(String value);
	
	@Query(value="Select nvl(sum(OUTWARD_TRADE),0) from brf38_summarytable where country_break_down='European Countries'",nativeQuery=true)
	String geteurooutwardtrade(String value);
	
	@Query(value="Select nvl(sum(INWARD_TRADE),0) from brf38_summarytable where country_break_down='European Countries'",nativeQuery=true)
	String geteuroinwardtrade(String value);

	
	@Query(value="Select nvl(sum(OUTWARD_OTHER),0) from brf38_summarytable where country_break_down='European Countries'",nativeQuery=true)
	String geteurooutwardother(String value);
	
	@Query(value="Select nvl(sum(INWARD_OTHER),0) from brf38_summarytable where country_break_down='European Countries'",nativeQuery=true)
	String geteuroinwardother(String value);
	
//GCC

	@Query(value="Select nvl(sum(OUTWARD_FAMILY),0) from brf38_summarytable where country_break_down='GCC Countries'",nativeQuery=true)
	String getgccoutwardfam(String value);
	
	@Query(value="Select nvl(sum(INWARD_FAMILY),0) from brf38_summarytable where country_break_down='GCC Countries'",nativeQuery=true)
	String getgccinwardfam(String value);
	
	@Query(value="Select nvl(sum(OUTWARD_INVESTMENT),0) from brf38_summarytable where country_break_down='GCC Countries'",nativeQuery=true)
	String getgccoutwardinvest(String value);
	
	@Query(value="Select nvl(sum(INWARD_INVESTMENT),0) from brf38_summarytable where country_break_down='GCC Countries'",nativeQuery=true)
	String getgccinwardinvest(String value);
	
	@Query(value="Select nvl(sum(OUTWARD_TRADE),0) from brf38_summarytable where country_break_down='GCC Countries'",nativeQuery=true)
	String getgccoutwardtrade(String value);
	
	@Query(value="Select nvl(sum(INWARD_TRADE),0) from brf38_summarytable where country_break_down='GCC Countries'",nativeQuery=true)
	String getgccinwardtrade(String value);
	
	@Query(value="Select nvl(sum(OUTWARD_OTHER),0) from brf38_summarytable where country_break_down='GCC Countries'",nativeQuery=true)
	String getgccoutwardother(String value);
	
	@Query(value="Select nvl(sum(INWARD_OTHER),0) from brf38_summarytable where country_break_down='GCC Countries'",nativeQuery=true)
	String getgccinwardother(String value);

	
//MENA
	@Query(value="Select nvl(sum(OUTWARD_FAMILY),0) from brf38_summarytable where country_break_down='Mena Countries'",nativeQuery=true)
	String getmenaoutwardfam(String value);
	
	@Query(value="Select nvl(sum(INWARD_FAMILY),0) from brf38_summarytable where country_break_down='Mena Countries'",nativeQuery=true)
	String getmenainwardfam(String value);
	
	@Query(value="Select nvl(sum(OUTWARD_INVESTMENT),0) from brf38_summarytable where country_break_down='Mena Countries'",nativeQuery=true)
	String getmenaoutwardinvest(String value);

	@Query(value="Select nvl(sum(INWARD_INVESTMENT),0) from brf38_summarytable where country_break_down='Mena Countries'",nativeQuery=true)
	String getmenainwardinvest(String value);
	
	@Query(value="Select nvl(sum(OUTWARD_TRADE),0) from brf38_summarytable where country_break_down='Mena Countries'",nativeQuery=true)
	String getmenaoutwardtrade(String value);
	
	@Query(value="Select nvl(sum(INWARD_TRADE),0) from brf38_summarytable where country_break_down='Mena Countries'",nativeQuery=true)
	String getmenainwardtrade(String value);
	
	@Query(value="Select nvl(sum(OUTWARD_OTHER),0) from brf38_summarytable where country_break_down='Mena Countries'",nativeQuery=true)
	String getmenaoutwardother(String value);
	
	@Query(value="Select nvl(sum(INWARD_OTHER),0) from brf38_summarytable where country_break_down='Mena Countries'",nativeQuery=true)
	String getmenainwardother(String value);

	
//SAHARAN

	@Query(value="Select nvl(sum(OUTWARD_FAMILY),0) from brf38_summarytable where country_break_down='Sub-Saharan Countries'",nativeQuery=true)
	String getsaharanoutwardfam(String value);	
	
	@Query(value="Select nvl(sum(INWARD_FAMILY),0) from brf38_summarytable where country_break_down='Sub-Saharan Countries'",nativeQuery=true)
	String getsaharaninwardfam(String value);
	
	@Query(value="Select nvl(sum(OUTWARD_INVESTMENT),0) from brf38_summarytable where country_break_down='Sub-Saharan Countries'",nativeQuery=true)
	String getsaharanoutwardinvest(String value);
	
	@Query(value="Select nvl(sum(INWARD_INVESTMENT),0) from brf38_summarytable where country_break_down='Sub-Saharan Countries'",nativeQuery=true)
	String getsaharaninwardinvest(String value);
	
	@Query(value="Select nvl(sum(OUTWARD_TRADE),0) from brf38_summarytable where country_break_down='Sub-Saharan Countries'",nativeQuery=true)
	String getsaharanoutwardtrade(String value);
	
	@Query(value="Select nvl(sum(INWARD_TRADE),0) from brf38_summarytable where country_break_down='Sub-Saharan Countries'",nativeQuery=true)
	String getsaharaninwardtrade(String value);
	
	@Query(value="Select nvl(sum(OUTWARD_OTHER),0) from brf38_summarytable where country_break_down='Sub-Saharan Countries'",nativeQuery=true)
	String getsaharanoutwardother(String value);
	
	@Query(value="Select nvl(sum(INWARD_OTHER),0) from brf38_summarytable where country_break_down='Sub-Saharan Countries'",nativeQuery=true)
	String getsaharaninwardother(String value);


 //ASIAN COUNTRIES
@Query(value="select nvl(sum(outward_family),0) from brf38_summarytable where country_break_down='Asian Countries'",nativeQuery=true)
String getasiaoutwardfam(String value);

@Query(value="select nvl(sum(inward_family),0) from brf38_summarytable where country_break_down='Asian Countries'",nativeQuery=true)
String getasiainwardfam(String value);

@Query(value="select nvl(sum(outward_investment),0) from brf38_summarytable where country_break_down='Asian Countries'",nativeQuery=true)
String getasiaoutwardinvest(String value);

@Query(value="select nvl(sum(inward_investment),0) from brf38_summarytable where country_break_down='Asian Countries'",nativeQuery=true)
String getasiainwardinvest(String value);

@Query(value="select nvl(sum(outward_trade),0) from brf38_summarytable where country_break_down='Asian Countries'",nativeQuery=true)
String getasiaoutwardtrade(String value);

@Query(value="select nvl(sum(inward_trade),0) from brf38_summarytable where country_break_down='Asian Countries'",nativeQuery=true)
String getasiainwardtrade(String value);

@Query(value="select nvl(sum(outward_other),0) from brf38_summarytable where country_break_down='Asian Countries'",nativeQuery=true)
String getasiaoutwardother(String value);

@Query(value=" Select nvl(sum(inward_other),0) from brf38_summarytable where country_break_down='Asian Countries'",nativeQuery=true)
String getasiainwardother(String value);


//latin
@Query(value="select nvl(sum(outward_family),0) from brf38_summarytable where country_break_down='Latin American Countries'",nativeQuery=true)
String getlatinoutwardfam(String value);

@Query(value="select nvl(sum(inward_family),0) from brf38_summarytable where country_break_down='Latin American Countries'",nativeQuery=true)
String getlatininwardfam(String value);

@Query(value="select nvl(sum(outward_investment),0) from brf38_summarytable where country_break_down='Latin American Countries'",nativeQuery=true)
String getlatinoutwardinvest(String value);

@Query(value="select nvl(sum(inward_investment),0) from brf38_summarytable where country_break_down='Latin American Countries'",nativeQuery=true)
String getlatininwardinvest(String value);

@Query(value="select nvl(sum(outward_trade),0) from brf38_summarytable where country_break_down='Latin American Countries'",nativeQuery=true)
String getlatinoutwardtrade(String value);

@Query(value="select nvl(sum(inward_trade),0) from brf38_summarytable where country_break_down='Latin American Countries'",nativeQuery=true)
String getlatininwardtrade(String value);

@Query(value="select nvl(sum(outward_other),0) from brf38_summarytable where country_break_down='Latin American Countries'",nativeQuery=true)
String getlatinoutwardother(String value);

@Query(value="select nvl(sum(inward_other),0) from brf38_summarytable where country_break_down='Latin American Countries'",nativeQuery=true)
String getlatininwardother(String value);


//OCEAN
@Query(value="select nvl(sum(outward_family),0) from brf38_summarytable where country_break_down='Oceania Countries'",nativeQuery=true)
String getoceaoutwardfam(String value);

@Query(value="select nvl(sum(inward_family),0) from brf38_summarytable where country_break_down='Oceania Countries'",nativeQuery=true)
String getoceainwardfam(String value);

@Query(value="select nvl(sum(outward_investment),0) from brf38_summarytable where country_break_down='Oceania Countries'",nativeQuery=true)
String getoceaoutwardinvest(String value);

@Query(value="select nvl(sum(inward_investment),0) from brf38_summarytable where country_break_down='Oceania Countries'",nativeQuery=true)
String getoceainwardinvest(String value);

@Query(value="select nvl(sum(outward_trade),0) from brf38_summarytable where country_break_down='Oceania Countries'",nativeQuery=true)
String getoceaoutwardtrade(String value);

@Query(value="select nvl(sum(inward_trade),0) from brf38_summarytable where country_break_down='Oceania Countries'",nativeQuery=true)
String getoceainwardtrade(String value);

@Query(value="select nvl(sum(outward_other),0) from brf38_summarytable where country_break_down='Oceania Countries'",nativeQuery=true)
String getoceaoutwardother(String value);

@Query(value="select nvl(sum(inward_other),0) from brf38_summarytable where country_break_down='Oceania Countries'",nativeQuery=true)
String getoceainwardother(String value);



//REMAINING

@Query(value="select nvl(sum(outward_family),0) from brf38_summarytable where country_break_down='Remaining Countries'",nativeQuery=true)
String getremainoutwardfam(String value);

@Query(value="select nvl(sum(inward_family),0) from brf38_summarytable where country_break_down='Remaining Countries'",nativeQuery=true)
String getremaininwardfam(String value);
 
@Query(value="select nvl(sum(outward_investment),0) from brf38_summarytable where country_break_down='Remaining Countries'",nativeQuery=true)
String getremainoutwardinvest(String value);

@Query(value="select nvl(sum(inward_investment),0) from brf38_summarytable where country_break_down='Remaining Countries'",nativeQuery=true)
String getremaininwardinvest(String value);

@Query(value="select nvl(sum(outward_trade),0) from brf38_summarytable where country_break_down='Remaining Countries'",nativeQuery=true)
String getremainoutwardtrade(String value);

@Query(value="select nvl(sum(inward_trade),0) from brf38_summarytable where country_break_down='Remaining Countries'",nativeQuery=true)
String getremaininwardtrade(String value);

@Query(value="select nvl(sum(outward_other),0) from brf38_summarytable where country_break_down='Remaining Countries'",nativeQuery=true)
String getremainoutwardother(String value);

@Query(value="select nvl(sum(inward_other),0) from brf38_summarytable where country_break_down='Remaining Countries'",nativeQuery=true)
String getremaininwardother(String value);

//GRAND TOTAL
@Query(value=" select nvl(sum(outward_family),0)  from brf38_summarytable where country_break_down IN ('North American Countries','European Countries','GCC Countries','Mena Countries','Sub-Saharan Countries','Asian Countries','Latin American Countries','Oceania Countries','Remaining Countries')",nativeQuery=true)
String getgrandtotaloutwardfam(String value);

@Query(value=" select nvl(sum(outward_investment),0)  from brf38_summarytable where country_break_down IN ('North American Countries','European Countries','GCC Countries','Mena Countries','Sub-Saharan Countries','Asian Countries','Latin American Countries','Oceania Countries','Remaining Countries')",nativeQuery=true)
String getgrandtotaloutwardinvest(String value);

@Query(value=" select nvl(sum(outward_trade),0)  from brf38_summarytable where country_break_down IN ('North American Countries','European Countries','GCC Countries','Mena Countries','Sub-Saharan Countries','Asian Countries','Latin American Countries','Oceania Countries','Remaining Countries')",nativeQuery=true)
String getgrandtotaloutwardtrade(String value);

@Query(value=" select nvl(sum(outward_other),0)  from brf38_summarytable where country_break_down IN ('North American Countries','European Countries','GCC Countries','Mena Countries','Sub-Saharan Countries','Asian Countries','Latin American Countries','Oceania Countries','Remaining Countries')",nativeQuery=true)
String getgrandtotaloutwardother(String value);

@Query(value=" select nvl(sum(inward_family),0)  from brf38_summarytable where country_break_down IN ('North American Countries','European Countries','GCC Countries','Mena Countries','Sub-Saharan Countries','Asian Countries','Latin American Countries','Oceania Countries','Remaining Countries')",nativeQuery=true)
String getgrandtotalinwardfam(String value);

@Query(value=" select nvl(sum(inward_investment),0)  from brf38_summarytable where country_break_down IN ('North American Countries','European Countries','GCC Countries','Mena Countries','Sub-Saharan Countries','Asian Countries','Latin American Countries','Oceania Countries','Remaining Countries')",nativeQuery=true)
String getgrandtotalinwardinvest(String value);

@Query(value=" select nvl(sum(inward_trade),0)  from brf38_summarytable where country_break_down IN ('North American Countries','European Countries','GCC Countries','Mena Countries','Sub-Saharan Countries','Asian Countries','Latin American Countries','Oceania Countries','Remaining Countries')",nativeQuery=true)
String getgrandtotalinwardtrade(String value);

@Query(value=" select nvl(sum(inward_other),0)  from brf38_summarytable where country_break_down IN ('North American Countries','European Countries','GCC Countries','Mena Countries','Sub-Saharan Countries','Asian Countries','Latin American Countries','Oceania Countries','Remaining Countries')",nativeQuery=true)
String getgrandtotalinwardother(String value);

/*
 * @Query(
 * value=" select nvl(sum(inward_trade),0)  from brf38_summarytable where country_break_down IN ('North American Countries','European Countries','GCC Countries','Mena Countries','Sub-Saharan Countries','Asian Countries','Latin American Countries','Oceania Countries','Remaining Countries')"
 * ,nativeQuery=true) String getgrandtotoutwardtotal(String value);
 * 
 * @Query(
 * value=" select nvl(sum(inward_other),0)  from brf38_summarytable where country_break_down IN ('North American Countries','European Countries','GCC Countries','Mena Countries','Sub-Saharan Countries','Asian Countries','Latin American Countries','Oceania Countries','Remaining Countries')"
 * ,nativeQuery=true) String getgrandtotinwardtotal(String value);
 */



@Query(value="select nvl(sum(outward_family),0)+nvl(sum(outward_investment),0)+nvl(sum(outward_other),0)+nvl(sum(outward_trade),0) from brf38_summarytable where country_break_down IN('North American Countries','European Countries','GCC Countries','Mena Countries','Sub-Saharan Countries','Asian Countries','Latin American Countries','Oceania Countries','Remaining Countries')",nativeQuery=true)
String getgrandtotoutwardtotal(String value);

@Query(value="SELECT nvl(sum(INWARD_family),0)+nvl(sum(INWARD_investment),0)+nvl(sum(INWARD_other),0)+nvl(sum(INWARD_trade),0) from brf38_summarytable where country_break_down IN('North American Countries','European Countries','GCC Countries','Mena Countries','Sub-Saharan Countries','Asian Countries','Latin American Countries','Oceania Countries','Remaining Countries')",nativeQuery=true)
String getgrandtotinwardtotal(String value);




}

