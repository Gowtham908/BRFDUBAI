package com.bornfire.xbrl.entities;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="ECL_CUST_MASTER")

public class ECL_CUSTMASTER_ENTITY {
	@Id
	private String	customer_id;
	private String	portfolio_code;
	private String	sub_portfolio_code;
	private String	country;
	private String	customer_name;
	private BigDecimal	limit;
	private String	rating;
	private String	individual_assessment;
	private String	dataimport_id;
	private String	rating_type;
	private BigDecimal	base_pd;
	private BigDecimal	positive_pd;
	private BigDecimal	negative_pd;
	private String	dataimportentity_id;
	private String	row_id;
	private Date	recordinput_date;
	private Date	report_date;
	public String getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(String customer_id) {
		this.customer_id = customer_id;
	}
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
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getCustomer_name() {
		return customer_name;
	}
	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}
	public BigDecimal getLimit() {
		return limit;
	}
	public void setLimit(BigDecimal limit) {
		this.limit = limit;
	}
	public String getRating() {
		return rating;
	}
	public void setRating(String rating) {
		this.rating = rating;
	}
	public String getIndividual_assessment() {
		return individual_assessment;
	}
	public void setIndividual_assessment(String individual_assessment) {
		this.individual_assessment = individual_assessment;
	}
	public String getDataimport_id() {
		return dataimport_id;
	}
	public void setDataimport_id(String dataimport_id) {
		this.dataimport_id = dataimport_id;
	}
	public String getRating_type() {
		return rating_type;
	}
	public void setRating_type(String rating_type) {
		this.rating_type = rating_type;
	}
	public BigDecimal getBase_pd() {
		return base_pd;
	}
	public void setBase_pd(BigDecimal base_pd) {
		this.base_pd = base_pd;
	}
	public BigDecimal getPositive_pd() {
		return positive_pd;
	}
	public void setPositive_pd(BigDecimal positive_pd) {
		this.positive_pd = positive_pd;
	}
	public BigDecimal getNegative_pd() {
		return negative_pd;
	}
	public void setNegative_pd(BigDecimal negative_pd) {
		this.negative_pd = negative_pd;
	}
	public String getDataimportentity_id() {
		return dataimportentity_id;
	}
	public void setDataimportentity_id(String dataimportentity_id) {
		this.dataimportentity_id = dataimportentity_id;
	}
	public String getRow_id() {
		return row_id;
	}
	public void setRow_id(String row_id) {
		this.row_id = row_id;
	}
	public Date getRecordinput_date() {
		return recordinput_date;
	}
	public void setRecordinput_date(Date recordinput_date) {
		this.recordinput_date = recordinput_date;
	}
	public Date getReport_date() {
		return report_date;
	}
	public void setReport_date(Date report_date) {
		this.report_date = report_date;
	}
	public ECL_CUSTMASTER_ENTITY(String customer_id, String portfolio_code, String sub_portfolio_code, String country,
			String customer_name, BigDecimal limit, String rating, String individual_assessment, String dataimport_id,
			String rating_type, BigDecimal base_pd, BigDecimal positive_pd, BigDecimal negative_pd,
			String dataimportentity_id, String row_id, Date recordinput_date, Date report_date) {
		super();
		this.customer_id = customer_id;
		this.portfolio_code = portfolio_code;
		this.sub_portfolio_code = sub_portfolio_code;
		this.country = country;
		this.customer_name = customer_name;
		this.limit = limit;
		this.rating = rating;
		this.individual_assessment = individual_assessment;
		this.dataimport_id = dataimport_id;
		this.rating_type = rating_type;
		this.base_pd = base_pd;
		this.positive_pd = positive_pd;
		this.negative_pd = negative_pd;
		this.dataimportentity_id = dataimportentity_id;
		this.row_id = row_id;
		this.recordinput_date = recordinput_date;
		this.report_date = report_date;
	}
	public ECL_CUSTMASTER_ENTITY() {
		super();
		// TODO Auto-generated constructor stub
	}
}