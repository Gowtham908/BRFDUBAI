package com.bornfire.xbrl.entities;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ECL_GLCODE_MAPPING")
public class ECL_GLCODE_DESC {
	
	@Id
	private String	gl_code;
	private String	glcode_desc;
	private String	ifrs_product_mapping;
	private BigDecimal	payment_frequency;
	public String getGl_code() {
		return gl_code;
	}
	public void setGl_code(String gl_code) {
		this.gl_code = gl_code;
	}
	public String getGlcode_desc() {
		return glcode_desc;
	}
	public void setGlcode_desc(String glcode_desc) {
		this.glcode_desc = glcode_desc;
	}
	public String getIfrs_product_mapping() {
		return ifrs_product_mapping;
	}
	public void setIfrs_product_mapping(String ifrs_product_mapping) {
		this.ifrs_product_mapping = ifrs_product_mapping;
	}
	public BigDecimal getPayment_frequency() {
		return payment_frequency;
	}
	public void setPayment_frequency(BigDecimal payment_frequency) {
		this.payment_frequency = payment_frequency;
	}
	public ECL_GLCODE_DESC(String gl_code, String glcode_desc, String ifrs_product_mapping,
			BigDecimal payment_frequency) {
		super();
		this.gl_code = gl_code;
		this.glcode_desc = glcode_desc;
		this.ifrs_product_mapping = ifrs_product_mapping;
		this.payment_frequency = payment_frequency;
	}
	public ECL_GLCODE_DESC() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	


}
