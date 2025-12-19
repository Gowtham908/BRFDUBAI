package com.bornfire.xbrl.entities.BRBS;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BASELMR9ServiceRepo {
	@Query(value = "select * from MR9_OPTIONSRISK_TABLE where REPORT_DATE=?1", nativeQuery = true)
	List< BASEL_MR9_REPORT_ENTITY> getBASELMR9ReportService(Date d1);

}
