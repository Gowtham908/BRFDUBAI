package com.bornfire.xbrl.entities.BRBS;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface Ecl_upload_Repo extends JpaRepository<Ecl_upload_Entity, Integer> {

	@Query(value = "select * from ECL_UPLOAD where customerid=?1", nativeQuery = true)
	Optional<Ecl_upload_Entity> getById(String cid);
	
}
