package com.bornfire.xbrl.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ECL_PORTFOLIO_MAPPING")

public class ECL_MAPPING_SUBPORT {
	
	private String	portfolio_code;
	@Id
	private String	sub_portfolio_code;
	private String	rating_type;
	public String getPortfolio_code() {
		return portfolio_code;
	}
	public void setPortfolio_code(String portfolio_code) {
		this.portfolio_code = portfolio_code;
	}
	public String getSub_portfolio_code() {
		return sub_portfolio_code;
	}
	public void setSub_portfolio_code(String sub_portfolio_code) {
		this.sub_portfolio_code = sub_portfolio_code;
	}
	public String getRating_type() {
		return rating_type;
	}
	public void setRating_type(String rating_type) {
		this.rating_type = rating_type;
	}
	public ECL_MAPPING_SUBPORT(String portfolio_code, String sub_portfolio_code, String rating_type) {
		super();
		this.portfolio_code = portfolio_code;
		this.sub_portfolio_code = sub_portfolio_code;
		this.rating_type = rating_type;
	}
	public ECL_MAPPING_SUBPORT() {
		super();
		// TODO Auto-generated constructor stub
	}


}
