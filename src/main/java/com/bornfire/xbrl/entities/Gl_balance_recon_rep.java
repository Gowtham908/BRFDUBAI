package com.bornfire.xbrl.entities;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface Gl_balance_recon_rep extends JpaRepository<Gl_balance_recon_entity, String> {
	
	@Query(value = "Select * from GL_BALANCE_RECONCILIATION_TABLE where report_date = ?1", nativeQuery = true)
	List<Gl_balance_recon_entity> GlGetGlbalancebydate(Date date);

}
