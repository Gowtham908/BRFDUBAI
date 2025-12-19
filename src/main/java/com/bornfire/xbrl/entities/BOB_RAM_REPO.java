package com.bornfire.xbrl.entities;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BOB_RAM_REPO extends JpaRepository<BOB_RAM_ENTITY, String> {

	@Query(value = "select * from BOB_RAM", nativeQuery = true)
	List<BOB_RAM_ENTITY> getcountlist();

	@Query(value = "select * from BOB_RAM where STATUS_2013 =?1 and STATUS_2014=?2", nativeQuery = true)
	List<BOB_RAM_ENTITY> getEclpopup(String a,String b);
	
	@Query(value = "SELECT COUNT(*) FROM bob_ram WHERE status_2013  IS NOT NULL ", nativeQuery = true)
	 Integer getcount2013();
	@Query(value = "SELECT COUNT(*) FROM bob_ram WHERE status_2014='BOB 10' ", nativeQuery = true)
	 Integer getbob10count2014();
	
	@Query(value="select count(status_2014) from bob_ram where status_2014<>'BOB 10'  ", nativeQuery=true)
	Integer getcount2014();
	@Query(value="SELECT COUNT(*) FROM BOB_RAM WHERE STATUS_2015='BOB 10'  ", nativeQuery=true)
	Integer getbob10count2015();
	
	@Query(value=" select  count(status_2015) from bob_ram   where status_2015 <> 'BOB 10'  ", nativeQuery=true)
	Integer getcount2015();
	@Query(value=" select count(*) status_2016 from bob_ram where status_2016='BOB 10'  ", nativeQuery=true)
	Integer getbob10count2016();
	
	@Query(value=" SELECT COUNT(*) FROM bob_ram WHERE status_2016 IS NOT NULL AND status_2016 <> 'BOB 10' ", nativeQuery=true)
	Integer getNOTcount2016();
	@Query(value=" select count(*) from bob_ram where status_2017='BOB 10'  ", nativeQuery=true)
	Integer getbob10count2017();
	
	@Query(value=" select count(*) from bob_ram where status_2017 is not null AND  status_2017<>'BOB 10' ", nativeQuery=true)
	Integer getNOTcount2017();
	@Query(value="select count(*) from bob_ram where status_2018='BOB 10'  ", nativeQuery=true)
	Integer getbob10count2018();
	
	@Query(value=" select count(*) from bob_ram where status_2018 is not null AND STATUS_2018 <> 'BOB 10' ", nativeQuery=true)
	Integer getNOTcount2018();
	@Query(value="SELECT COUNT(*) FROM BOB_RAM WHERE STATUS_2019='BOB 10'  ", nativeQuery=true)
	Integer getbob10count2019();
	
	@Query(value="select count(*) from bob_ram where status_2019 is not null AND status_2019 <> 'BOB 10'", nativeQuery=true)
	Integer getNOTcount2019();
	@Query(value="SELECT COUNT(*) FROM BOB_RAM WHERE STATUS_2020='BOB 10'  ", nativeQuery=true)
	Integer getbob10count2020();
	
	@Query(value=" select count(*) from bob_ram where status_2020 is not null AND status_2020 <>'BOB 10' ", nativeQuery=true)
	Integer getNOTcount2020();
	@Query(value="SELECT COUNT(*) FROM BOB_RAM WHERE STATUS_2021 ='BOB 10'  ", nativeQuery=true)
	Integer getbob10count2021();
	
	@Query(value=" select count(*) from bob_ram where status_2021 is not null AND STATUS_2021 <> 'BOB 10' ", nativeQuery=true)
	Integer getNOTcount2021();
	@Query(value=" select count(*) from bob_ram where status_2022='BOB 10' ", nativeQuery=true)
	Integer getbob10count2022();
	
	

}
