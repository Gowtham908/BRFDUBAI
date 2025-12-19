package com.bornfire.xbrl.entities;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface Rompop_repo  extends JpaRepository<Rampop_Entity, String> {
	
	@Query(value = "SELECT * "
	        + "FROM ( "
	        + "    SELECT status_start, status_end, transition_count "
	        + "    FROM TABLE(calculate_transition_counts_func(:parameters)) "
	        + ") "
	        + "PIVOT ( "
	        + "    SUM(transition_count) "
	        + "    FOR status_end IN ('BOB 1' AS BOB1, 'BOB 2' AS BOB2, 'BOB 3' AS BOB3, 'BOB 4' AS BOB4, 'BOB 5' AS BOB5, 'BOB 6' AS BOB6, 'BOB 7' AS BOB7, 'BOB 10' AS BOB10) "
	        + ") "
	        + "ORDER BY TO_NUMBER(REGEXP_SUBSTR(status_start, '\\d+$'))", nativeQuery = true)
	List<Rampop_Entity> getstatusList(String parameters);

	
	
}
