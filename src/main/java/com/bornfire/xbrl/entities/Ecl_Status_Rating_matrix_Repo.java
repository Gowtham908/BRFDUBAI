package com.bornfire.xbrl.entities;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface Ecl_Status_Rating_matrix_Repo extends JpaRepository<Ecl_Status_Rating_matrix,String> {
	
	@Query(value = "select * from ECL_RATING_TRAN_MATRIX", nativeQuery = true)
	List<Ecl_Status_Rating_matrix> getallcount();

}
