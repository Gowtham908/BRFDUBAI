package com.bornfire.xbrl.entities;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface Vat_Ledger_Repo extends JpaRepository<Vat_Ledger_Entity, String> {

	@Query(value = "select * from VAT_LEDGER_DAILY_DATA where REPORT_DATE=?1 ", nativeQuery = true)
	List<Vat_Ledger_Entity> getVATdata(String reportdate);
	
	@Query(value = "select Distinct REPORT_DATE from VAT_LEDGER_DAILY_DATA order by report_date Asc", nativeQuery = true)
	List<String> Getvatdates();
	
}
