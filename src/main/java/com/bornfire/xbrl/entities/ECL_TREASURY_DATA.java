package com.bornfire.xbrl.entities;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="ECL_TREASURY_DATA")

public class ECL_TREASURY_DATA {
	@Id
	private String	customerid;
	private String	subportfoliocode;
	private Date	open_date;
	private String	customername;
	private BigDecimal	limit;
	private Date	maturity_date;
	private String	rating;
	private String	country;
	private BigDecimal	interest_rate;
	private String	gl_code;
	private Date	report_date;
	public String getCustomerid() {
		return customerid;
	}
	public void setCustomerid(String customerid) {
		this.customerid = customerid;
	}
	public String getSubportfoliocode() {
		return subportfoliocode;
	}
	public void setSubportfoliocode(String subportfoliocode) {
		this.subportfoliocode = subportfoliocode;
	}
	public Date getOpen_date() {
		return open_date;
	}
	public void setOpen_date(Date open_date) {
		this.open_date = open_date;
	}
	public String getCustomername() {
		return customername;
	}
	public void setCustomername(String customername) {
		this.customername = customername;
	}
	public BigDecimal getLimit() {
		return limit;
	}
	public void setLimit(BigDecimal limit) {
		this.limit = limit;
	}
	public Date getMaturity_date() {
		return maturity_date;
	}
	public void setMaturity_date(Date maturity_date) {
		this.maturity_date = maturity_date;
	}
	public String getRating() {
		return rating;
	}
	public void setRating(String rating) {
		this.rating = rating;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public BigDecimal getInterest_rate() {
		return interest_rate;
	}
	public void setInterest_rate(BigDecimal interest_rate) {
		this.interest_rate = interest_rate;
	}
	public String getGl_code() {
		return gl_code;
	}
	public void setGl_code(String gl_code) {
		this.gl_code = gl_code;
	}
	public Date getReport_date() {
		return report_date;
	}
	public void setReport_date(Date report_date) {
		this.report_date = report_date;
	}
	public ECL_TREASURY_DATA(String customerid, String subportfoliocode, Date open_date, String customername,
			BigDecimal limit, Date maturity_date, String rating, String country, BigDecimal interest_rate,
			String gl_code, Date report_date) {
		super();
		this.customerid = customerid;
		this.subportfoliocode = subportfoliocode;
		this.open_date = open_date;
		this.customername = customername;
		this.limit = limit;
		this.maturity_date = maturity_date;
		this.rating = rating;
		this.country = country;
		this.interest_rate = interest_rate;
		this.gl_code = gl_code;
		this.report_date = report_date;
	}
	public ECL_TREASURY_DATA() {
		super();
		// TODO Auto-generated constructor stub
	}
}