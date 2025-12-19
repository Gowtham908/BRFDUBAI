package com.bornfire.xbrl.entities.BRBS;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BRF43_ENTITY_REP extends JpaRepository<BRF43B_ENTITY, Date>{
	
	@Query(value="select name,categorya,categoryb,funded,unfunded,unused_limit,total_exposure,security_provided from BRF43B_SUMMARYTABLE where trunc(report_date)=?1",nativeQuery=true)
	List<Object[]> findllvalues(String todate);
	
	/*
	 * @Query(value="select * from BRF43B_SUMMARY_TABLE where name=?1",nativeQuery=
	 * true) List<BRF043_ENTITY> findllname(String name);
	 */
	//CAT A
	/*
	 * @Query(
	 * value="SELECT NVL(SUM(funded), 0) FROM BRF43B_SUMMARY_TABLE WHERE name = 'Category A (Share broker) '"
	 * , nativeQuery=true) String getcatafun(String value);
	 * 
	 * @Query(
	 * value="SELECT NVL(SUM(unfunded), 0) FROM BRF43B_SUMMARY_TABLE WHERE name = 'Category A (Share broker) '"
	 * , nativeQuery=true) String getcataunfun(String value);
	 * 
	 * @Query(
	 * value="SELECT NVL(SUM(unused_linmit), 0) FROM BRF43B_SUMMARY_TABLE WHERE name = 'Category A (Share broker) '"
	 * , nativeQuery=true) String getcataunlimit(String value);
	 */

	 
	/*
	 * //SUBTOTAL A
	 * 
	 * @Query(
	 * value="SELECT NVL(SUM(funded), 0) + NVL(SUM(unfunded), 0) + NVL(SUM(unused_linmit), 0) FROM BRF43B_SUMMARY_TABLE WHERE name = 'Category A (Share broker) '"
	 * , nativeQuery=true)
	 * 
	 * String getcatasubtotal(String value);
	 */
	
	//CAT B
	@Query(value="SELECT NVL(SUM(funded), 0) FROM BRF43B_SUMMARYTABLE WHERE name = 'CATEGORYB'", nativeQuery=true)
	String getcatbfun(String value);

	@Query(value="SELECT NVL(SUM(unfunded), 0) FROM BRF43B_SUMMARYTABLE WHERE name = 'CATEGORYB'", nativeQuery=true)
	String getcatbunfun(String value);

	@Query(value="SELECT NVL(SUM(unused_limit), 0) FROM BRF43B_SUMMARYTABLE WHERE name = 'CATEGORYB'", nativeQuery=true)
	String getcatbunlimit(String value);

	 
	
	//SUBTOTAL B
	@Query(value="SELECT NVL(SUM(funded), 0) + NVL(SUM(unfunded), 0) + NVL(SUM(unused_limit), 0) FROM BRF43B_SUMMARYTABLE WHERE name = 'CATEGORYB'", nativeQuery=true)
	String getcatbsubtotal(String value);
	
	//GRANT TOTAL
	@Query(value="SELECT NVL(SUM(funded), 0) FROM BRF43B_SUMMARYTABLE WHERE name IN ('Category A (Share broker) ', 'CATEGORYB')", nativeQuery=true)
	String getgrandtotalfun(String value);

	@Query(value="SELECT NVL(SUM(unfunded), 0) FROM BRF43B_SUMMARYTABLE WHERE name IN ('Category A (Share broker) ', 'CATEGORYB')", nativeQuery=true)
	String getgrandtotalunfun(String value);

	@Query(value="SELECT NVL(SUM(unused_limit), 0) FROM BRF43B_SUMMARYTABLE WHERE name IN ('Category A (Share broker) ', 'CATEGORYB')", nativeQuery=true)
	String getgrandtotalunlimit(String value);

	 
	///
	@Query(value="SELECT NVL(SUM(funded), 0) + NVL(SUM(unfunded), 0) + NVL(SUM(unused_limit), 0) FROM BRF43B_SUMMARYTABLE WHERE name IN ('Category A (Share broker) ', 'CATEGORYB')", nativeQuery=true)
	String getgrandtotal (String value);

	 
}