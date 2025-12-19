package com.bornfire.xbrl.entities.BRBS;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface BRF40_MAPPING_REPO extends JpaRepository<BRF40_MAPPING_ENTITY, String>, BRF_MAPPING {
	@Query(value = "select * from BRF40_MAPPING_TABLE", nativeQuery = true)
	List<BRF40_MAPPING_ENTITY> getreport();

	@Query(value = "select * from BRF40_MAPPING_TABLE where report_name_1=?1", nativeQuery = true)
	List<BRF40_MAPPING_ENTITY> getdesc(String report_name_1);

	//Product_Mapping
	@Query(value = "select s.cust_id as custid, s.foracid as foracid, s.acct_name as acctname, s.report_name_1 as reportname1, "
	        + "s.report_label_1 as reportlabel1, s.gl_sub_head_code as glsubheadcode, s.schm_code as schmcode, "
	        + "s.report_addl_criteria_1 as reportaddlcriteria1, s.report_addl_criteria_2 as reportaddlcriteria2, "
	        + "s.report_addl_criteria_3 as reportaddlcriteria3 "
	        + "from BRF40_MAPPING_TABLE s where s.report_label_1=?1", nativeQuery = true)
	List<BRF_PRODUCT_MAPPINGREPO> getproduct(String report_label_1);


	@Query(value = "select * from BRF40_MAPPING_TABLE", nativeQuery = true)
	List<BRF40_MAPPING_ENTITY> Mapping1();

	@Query(value = "select * from BRF40_MAPPING_TABLE where foracid=?1", nativeQuery = true)
	BRF40_MAPPING_ENTITY findByIDoo(String foracid);

	@Query(value = "SELECT * FROM BRF40_MAPPING_TABLE", nativeQuery = true)
	List<BRF40_MAPPING_ENTITY> getLiist2();

	@Query(value = "SELECT * FROM BRF40_MAPPING_TABLE WHERE REPORT_NAME_1=?1", nativeQuery = true)
	List<BRF40_MAPPING_ENTITY> getLiist(String REPORT_NAME_1);

	//Mapped Query
	@Query(value = "select s.cust_id as custid,s.foracid as foracid , s.acct_name as acctname , s.report_name_1 as reportname1 , "
			+ " s.report_label_1 as reportlabel1 , s.gl_sub_head_code as glsubheadcode , s.schm_code as schmcode,"
			+ " s.report_addl_criteria_1 as reportaddlcriteria1,s.report_addl_criteria_2 as reportaddlcriteria2,s.report_addl_criteria_3 as reportaddlcriteria3"
			+ " from BRF40_MAPPING_TABLE s  WHERE s.report_label_1 is not null AND s.report_addl_criteria_1 IS NOT NULL"
			+ " and s.report_name_1=?1", nativeQuery = true)
	List<BRF_MAPPING_PROPERTY> genMapped(String report_code);

	//Unmapped Query
	@Query(value = "SELECT  s.cust_id as custid,s.foracid as foracid , s.acct_name as acctname , s.report_name_1 as reportname1 ,"
			+ " s.report_label_1 as reportlabel1 , s.gl_sub_head_code as glsubheadcode , s.schm_code as schmcode,"
			+ " s.report_addl_criteria_1 as reportaddlcriteria1,s.report_addl_criteria_2 as reportaddlcriteria2,s.report_addl_criteria_3 as reportaddlcriteria3"
			+ " FROM BRF40_MAPPING_TABLE s WHERE s.report_label_1 IS  NULL OR s.report_addl_criteria_1 IS NULL", nativeQuery = true)
	List<BRF_MAPPING_PROPERTY> genUnMapped();

	
	@Query(value = "SELECT * FROM BRF40_MAPPING_TABLE WHERE SCHM_CODE = :scheme_code and GL_SUB_HEAD_CODE = :GL_SUB_HEAD_CODE", nativeQuery = true)
	List<Object[]> getListByCustomerId(@Param("scheme_code") String scheme_code,
			@Param("GL_SUB_HEAD_CODE") String GL_SUB_HEAD_CODE);

	
//	Query For Filter 
	@Query(value = "SELECT s.cust_id as custid, s.foracid as foracid, s.acct_name as acctname, s.report_label_1 as reportlabel1, "
			+ "s.gl_sub_head_code as glsubheadcode, s.schm_code as schmcode "
			+ "FROM BRF40_MAPPING_TABLE s WHERE s.SCHM_CODE = :scheme_code and s.GL_SUB_HEAD_CODE = :GL_SUB_HEAD_CODE and "
			+ "s.GL_CODE = :gl_code and s.CUST_ID = :cust_id", nativeQuery = true)
	List<BRF_MAPPING_PROPERTY> getBYGlHeadGlsubHeadAndSchemeCode1(@Param("gl_code") String gl_code,
			@Param("GL_SUB_HEAD_CODE") String GL_SUB_HEAD_CODE, @Param("scheme_code") String scheme_code,
			@Param("cust_id") String cust_id);

	@Query(value = "SELECT s.cust_id as custid, s.foracid as foracid, s.acct_name as acctname, s.report_label_1 as reportlabel1, "
			+ "s.gl_sub_head_code as glsubheadcode, s.schm_code as schmcode " + "FROM BRF40_MAPPING_TABLE s WHERE "
			+ "s.SCHM_CODE = :scheme_code and s.GL_SUB_HEAD_CODE = :GL_SUB_HEAD_CODE and s.GL_CODE = :gl_code", nativeQuery = true)
	List<BRF_MAPPING_PROPERTY> getByGlsubHeadAndSchemeCode2(@Param("gl_code") String gl_code,
			@Param("GL_SUB_HEAD_CODE") String GL_SUB_HEAD_CODE, @Param("scheme_code") String scheme_code);

	// gl_code,scheme_code,cust_id

	@Query(value = "SELECT s.cust_id as custid, s.foracid as foracid, s.acct_name as acctname, s.report_label_1 as reportlabel1, "
			+ "s.gl_sub_head_code as glsubheadcode, s.schm_code as schmcode " + "FROM BRF40_MAPPING_TABLE s WHERE "
			+ "s.SCHM_CODE = :scheme_code and s.CUST_ID = :cust_id and s.GL_CODE = :gl_code", nativeQuery = true)
	List<BRF_MAPPING_PROPERTY> getByGlsubHeadAndSchemeCode3(@Param("gl_code") String gl_code,
			@Param("cust_id") String cust_id, @Param("scheme_code") String scheme_code);

	// gl_code,GL_SUB_HEAD_CODE,cust_id
	@Query(value = "SELECT s.cust_id as custid, s.foracid as foracid, s.acct_name as acctname, s.report_label_1 as reportlabel1, "
			+ "s.gl_sub_head_code as glsubheadcode, s.schm_code as schmcode " + "FROM BRF40_MAPPING_TABLE s WHERE "
			+ "s.GL_SUB_HEAD_CODE = :GL_SUB_HEAD_CODE and s.CUST_ID = :cust_id and s.GL_CODE = :gl_code", nativeQuery = true)
	List<BRF_MAPPING_PROPERTY> getByGlsubHeadAndSchemeCode4(@Param("gl_code") String gl_code,
			@Param("cust_id") String cust_id, @Param("GL_SUB_HEAD_CODE") String GL_SUB_HEAD_CODE);

	// scheme_code,GL_SUB_HEAD_CODE,cust_id
	@Query(value = "SELECT s.cust_id as custid, s.foracid as foracid, s.acct_name as acctname, s.report_label_1 as reportlabel1, "
			+ "s.gl_sub_head_code as glsubheadcode, s.schm_code as schmcode " + "FROM BRF40_MAPPING_TABLE s WHERE "
			+ "s.GL_SUB_HEAD_CODE = :GL_SUB_HEAD_CODE and s.CUST_ID = :cust_id and s.SCHM_CODE = :scheme_code", nativeQuery = true)
	List<BRF_MAPPING_PROPERTY> getByGlsubHeadAndSchemeCode5(@Param("scheme_code") String scheme_code,
			@Param("cust_id") String cust_id, @Param("GL_SUB_HEAD_CODE") String GL_SUB_HEAD_CODE);

	// gl_code,scheme_code
	@Query(value = "SELECT s.cust_id as custid, s.foracid as foracid, s.acct_name as acctname, s.report_label_1 as reportlabel1, "
			+ "s.gl_sub_head_code as glsubheadcode, s.schm_code as schmcode " + "FROM BRF40_MAPPING_TABLE s WHERE "
			+ "s.GL_CODE = :gl_code and s.SCHM_CODE = :scheme_code", nativeQuery = true)
	List<BRF_MAPPING_PROPERTY> getByGlsubHeadAndSchemeCode6(@Param("scheme_code") String scheme_code,
			@Param("gl_code") String gl_code);

	// gl_code,GL_SUB_HEAD_CODE
	@Query(value = "SELECT s.cust_id as custid, s.foracid as foracid, s.acct_name as acctname, s.report_label_1 as reportlabel1, "
			+ "s.gl_sub_head_code as glsubheadcode, s.schm_code as schmcode " + "FROM BRF40_MAPPING_TABLE s WHERE "
			+ "s.GL_CODE = :gl_code and s.GL_SUB_HEAD_CODE = :GL_SUB_HEAD_CODE", nativeQuery = true)
	List<BRF_MAPPING_PROPERTY> getByGlsubHeadAndSchemeCode7(@Param("GL_SUB_HEAD_CODE") String GL_SUB_HEAD_CODE,
			@Param("gl_code") String gl_code);

	// gl_code,cust_id
	@Query(value = "SELECT s.cust_id as custid, s.foracid as foracid, s.acct_name as acctname, s.report_label_1 as reportlabel1, "
			+ "s.gl_sub_head_code as glsubheadcode, s.schm_code as schmcode " + "FROM BRF40_MAPPING_TABLE s WHERE "
			+ "s.GL_CODE = :gl_code and s.CUST_ID = :cust_id", nativeQuery = true)
	List<BRF_MAPPING_PROPERTY> getByGlsubHeadAndSchemeCode8(@Param("cust_id") String cust_id,
			@Param("gl_code") String gl_code);

	// GL_SUB_HEAD_CODE,scheme_code
	@Query(value = "SELECT s.cust_id as custid, s.foracid as foracid, s.acct_name as acctname, s.report_label_1 as reportlabel1, "
			+ "s.gl_sub_head_code as glsubheadcode, s.schm_code as schmcode " + "FROM BRF40_MAPPING_TABLE s WHERE "
			+ "s.SCHM_CODE = :scheme_code and s.GL_SUB_HEAD_CODE = :GL_SUB_HEAD_CODE", nativeQuery = true)
	List<BRF_MAPPING_PROPERTY> getByGlsubHeadAndSchemeCode9(@Param("GL_SUB_HEAD_CODE") String GL_SUB_HEAD_CODE,
			@Param("scheme_code") String scheme_code);

	// GL_SUB_HEAD_CODE,cust_id
	@Query(value = "SELECT s.cust_id as custid, s.foracid as foracid, s.acct_name as acctname, s.report_label_1 as reportlabel1, "
			+ "s.gl_sub_head_code as glsubheadcode, s.schm_code as schmcode " + "FROM BRF40_MAPPING_TABLE s WHERE "
			+ "s.GL_SUB_HEAD_CODE = :GL_SUB_HEAD_CODE and s.CUST_ID = :cust_id", nativeQuery = true)
	List<BRF_MAPPING_PROPERTY> getByGlsubHeadAndSchemeCode10(@Param("GL_SUB_HEAD_CODE") String GL_SUB_HEAD_CODE,
			@Param("cust_id") String cust_id);

	// GL_SUB_HEAD_CODE,gl_code
	@Query(value = "SELECT s.cust_id as custid, s.foracid as foracid, s.acct_name as acctname, s.report_label_1 as reportlabel1, "
			+ "s.gl_sub_head_code as glsubheadcode, s.schm_code as schmcode " + "FROM BRF40_MAPPING_TABLE s WHERE "
			+ "s.GL_SUB_HEAD_CODE = :GL_SUB_HEAD_CODE and s.GL_CODE = :gl_code", nativeQuery = true)
	List<BRF_MAPPING_PROPERTY> getByGlsubHeadAndSchemeCode11(@Param("GL_SUB_HEAD_CODE") String GL_SUB_HEAD_CODE,
			@Param("gl_code") String gl_code);

	// scheme_code,cust_id
	@Query(value = "SELECT s.cust_id as custid, s.foracid as foracid, s.acct_name as acctname, s.report_label_1 as reportlabel1, "
			+ "s.gl_sub_head_code as glsubheadcode, s.schm_code as schmcode " + "FROM BRF40_MAPPING_TABLE s WHERE "
			+ "s.SCHM_CODE = :scheme_code and s.CUST_ID = :cust_id", nativeQuery = true)
	List<BRF_MAPPING_PROPERTY> getByGlsubHeadAndSchemeCode12(@Param("scheme_code") String scheme_code,
			@Param("cust_id") String cust_id);

	// gl_code
	@Query(value = "SELECT s.cust_id as custid, s.foracid as foracid, s.acct_name as acctname, s.report_label_1 as reportlabel1, "
			+ "s.gl_sub_head_code as glsubheadcode, s.schm_code as schmcode " + "FROM BRF40_MAPPING_TABLE s WHERE "
			+ "s.GL_CODE = :gl_code", nativeQuery = true)
	List<BRF_MAPPING_PROPERTY> getByGlsubHeadAndSchemeCode13(@Param("gl_code") String gl_code);

	// GL_SUB_HEAD_CODE
	@Query(value = "SELECT s.cust_id as custid, s.foracid as foracid, s.acct_name as acctname, s.report_label_1 as reportlabel1, "
			+ "s.gl_sub_head_code as glsubheadcode, s.schm_code as schmcode " + "FROM BRF40_MAPPING_TABLE s WHERE "
			+ "s.GL_SUB_HEAD_CODE = :GL_SUB_HEAD_CODE", nativeQuery = true)
	List<BRF_MAPPING_PROPERTY> getByGlsubHeadAndSchemeCode14(@Param("GL_SUB_HEAD_CODE") String GL_SUB_HEAD_CODE);

	// scheme_code
	@Query(value = "SELECT s.cust_id as custid, s.foracid as foracid, s.acct_name as acctname, s.report_label_1 as reportlabel1, "
			+ "s.gl_sub_head_code as glsubheadcode, s.schm_code as schmcode " + "FROM BRF40_MAPPING_TABLE s WHERE "
			+ "s.SCHM_CODE = :scheme_code", nativeQuery = true)
	List<BRF_MAPPING_PROPERTY> getByGlsubHeadAndSchemeCode15(@Param("scheme_code") String scheme_code);

	// CUST_ID
	@Query(value = "SELECT s.cust_id as custid, s.foracid as foracid, s.acct_name as acctname, s.report_label_1 as reportlabel1, "
			+ "s.gl_sub_head_code as glsubheadcode, s.schm_code as schmcode " + "FROM BRF40_MAPPING_TABLE s WHERE "
			+ "s.CUST_ID = :cust_id", nativeQuery = true)
	List<BRF_MAPPING_PROPERTY> getByGlsubHeadAndSchemeCode16(@Param("cust_id") String cust_id);

	@Query(value = "SELECT s.cust_id as custid, s.foracid as foracid, s.acct_name as acctname, s.report_label_1 as reportlabel1, "
			+ "s.gl_sub_head_code as glsubheadcode, s.schm_code as schmcode " + "FROM BRF40_MAPPING_TABLE s WHERE "
			+ "s.FORACID BETWEEN :start AND :end", nativeQuery = true)
	List<BRF_MAPPING_PROPERTY> getBetweenAccountIds(@Param("start") String startRange, @Param("end") String endRange);

	@Query(value = "SELECT DISTINCT GL_CODE FROM BRF40_MAPPING_TABLE ORDER BY GL_CODE", nativeQuery = true)
	List<String> detail1();

	@Query(value = "SELECT DISTINCT CUST_ID, FORACID FROM BRF40_MAPPING_TABLE ORDER BY CUST_ID ASC,FORACID ASC", nativeQuery = true)
	List<String[]> getListDropDown(String cust_id, String foracid);

	@Query(value = "SELECT DISTINCT SCHM_CODE FROM BRF40_MAPPING_TABLE ORDER BY SCHM_CODE", nativeQuery = true)
	List<String> detail5();

	@Query(value = "SELECT DISTINCT GL_SUB_HEAD_CODE FROM BRF40_MAPPING_TABLE ORDER BY GL_SUB_HEAD_CODE", nativeQuery = true)
	List<String> detail6();

}
