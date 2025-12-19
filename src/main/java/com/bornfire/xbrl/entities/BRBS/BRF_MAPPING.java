package com.bornfire.xbrl.entities.BRBS;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface BRF_MAPPING {
	
	List<BRF_MAPPING_PROPERTY> getBYGlHeadGlsubHeadAndSchemeCode1(@Param("gl_code") String gl_code,
			@Param("gl_sub_head_code") String gl_sub_head_code, @Param("scheme_code") String scheme_code,
			@Param("cust_id") String cust_id);
	
	List<BRF_MAPPING_PROPERTY> getByGlsubHeadAndSchemeCode2(@Param("gl_code") String gl_code, @Param("gl_sub_head_code") String gl_sub_head_code,
			@Param("scheme_code") String scheme_code);
	
	List<BRF_MAPPING_PROPERTY> getByGlsubHeadAndSchemeCode3(@Param("gl_code") String gl_code, @Param("cust_id") String cust_id,
			@Param("scheme_code") String scheme_code);
	
	
	
	List<BRF_MAPPING_PROPERTY> getByGlsubHeadAndSchemeCode4(@Param("gl_code") String gl_code, @Param("cust_id") String cust_id,
			@Param("gl_sub_head_code") String gl_sub_head_code);

	
	List<BRF_MAPPING_PROPERTY> getByGlsubHeadAndSchemeCode5(@Param("scheme_code") String scheme_code,
			@Param("cust_id") String cust_id, @Param("gl_sub_head_code") String gl_sub_head_code);

	
	List<BRF_MAPPING_PROPERTY> getByGlsubHeadAndSchemeCode6(@Param("scheme_code") String scheme_code,
			@Param("gl_code") String gl_code);

	
	List<BRF_MAPPING_PROPERTY> getByGlsubHeadAndSchemeCode7(@Param("gl_sub_head_code") String gl_sub_head_code, @Param("gl_code") String gl_code);

	
	List<BRF_MAPPING_PROPERTY> getByGlsubHeadAndSchemeCode8(@Param("cust_id") String cust_id, @Param("gl_code") String gl_code);

	
	List<BRF_MAPPING_PROPERTY> getByGlsubHeadAndSchemeCode9(@Param("gl_sub_head_code") String gl_sub_head_code,@Param("scheme_code") String scheme_code);

	
	List<BRF_MAPPING_PROPERTY> getByGlsubHeadAndSchemeCode10(@Param("gl_sub_head_code") String gl_sub_head_code,
			@Param("cust_id") String cust_id);

	
	List<BRF_MAPPING_PROPERTY> getByGlsubHeadAndSchemeCode11(@Param("gl_sub_head_code") String gl_sub_head_code,
			@Param("gl_code") String gl_code);

	
	List<BRF_MAPPING_PROPERTY> getByGlsubHeadAndSchemeCode12(@Param("scheme_code") String scheme_code,
			@Param("cust_id") String cust_id);

	
	List<BRF_MAPPING_PROPERTY> getByGlsubHeadAndSchemeCode13(@Param("gl_code") String gl_code);

	
	List<BRF_MAPPING_PROPERTY> getByGlsubHeadAndSchemeCode14(@Param("gl_sub_head_code") String gl_sub_head_code);

	
	List<BRF_MAPPING_PROPERTY> getByGlsubHeadAndSchemeCode15(@Param("scheme_code") String scheme_code);

	
	List<BRF_MAPPING_PROPERTY> getByGlsubHeadAndSchemeCode16(@Param("cust_id") String cust_id);
	
	
	List<BRF_MAPPING_PROPERTY> getBetweenAccountIds(@Param("start") String startRange, @Param("end") String endRange);

	
	
	List<BRF_PRODUCT_MAPPINGREPO> getproduct(String report_label_1);
	
	//BRF_MAPPING_TABLE findByID(String foracid);
	
	BRF_MAPPING_TABLE save(BRF_MAPPING_TABLE up1);
	



}
