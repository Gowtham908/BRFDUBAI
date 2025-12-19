package com.bornfire.xbrl.entities;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="ECL_RETAIL_SEGMENT_CODE_MAPPING")
public class ECL_SCHEM_CODE {
	@Id
	private String	scheme_code;
	private String	scheme_code_des;
	private String	portfolio;
	public String getScheme_code() {
		return scheme_code;
	}
	public void setScheme_code(String scheme_code) {
		this.scheme_code = scheme_code;
	}
	public String getScheme_code_des() {
		return scheme_code_des;
	}
	public void setScheme_code_des(String scheme_code_des) {
		this.scheme_code_des = scheme_code_des;
	}
	public String getPortfolio() {
		return portfolio;
	}
	public void setPortfolio(String portfolio) {
		this.portfolio = portfolio;
	}
	public ECL_SCHEM_CODE(String scheme_code, String scheme_code_des, String portfolio) {
		super();
		this.scheme_code = scheme_code;
		this.scheme_code_des = scheme_code_des;
		this.portfolio = portfolio;
	}
	public ECL_SCHEM_CODE() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	


}
