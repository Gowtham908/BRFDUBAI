package com.bornfire.xbrl.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ECL_COUNTRY_CODE_MAPPING")
public class ECL_MAPPING_COUNTRY_CODE {
	
	@Id
	private String	country_code;
	private String	country_code_desc;
	public String getCountry_code() {
		return country_code;
	}
	public void setCountry_code(String country_code) {
		this.country_code = country_code;
	}
	public String getCountry_code_desc() {
		return country_code_desc;
	}
	public void setCountry_code_desc(String country_code_desc) {
		this.country_code_desc = country_code_desc;
	}
	public ECL_MAPPING_COUNTRY_CODE(String country_code, String country_code_desc) {
		super();
		this.country_code = country_code;
		this.country_code_desc = country_code_desc;
	}
	public ECL_MAPPING_COUNTRY_CODE() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	

	
}
