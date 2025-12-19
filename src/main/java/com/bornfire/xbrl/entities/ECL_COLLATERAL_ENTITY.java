package com.bornfire.xbrl.entities;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="ECL_COLLATERAL")

public class ECL_COLLATERAL_ENTITY {
	private String	cash_collateral_value;
	private String	collateral_currency;
	private BigDecimal	collateral_id;
	private BigDecimal	collateral_type_id;
	private BigDecimal	collateral_value;

	@Id
	private String	customer_id;
	private String	dataimport_id;
	private String	description;
	private String	facility_id;
	private BigDecimal	haircut;
	private Date	report_date;
	public String getCash_collateral_value() {
		return cash_collateral_value;
	}
	public void setCash_collateral_value(String cash_collateral_value) {
		this.cash_collateral_value = cash_collateral_value;
	}
	public String getCollateral_currency() {
		return collateral_currency;
	}
	public void setCollateral_currency(String collateral_currency) {
		this.collateral_currency = collateral_currency;
	}
	public BigDecimal getCollateral_id() {
		return collateral_id;
	}
	public void setCollateral_id(BigDecimal collateral_id) {
		this.collateral_id = collateral_id;
	}
	public BigDecimal getCollateral_type_id() {
		return collateral_type_id;
	}
	public void setCollateral_type_id(BigDecimal collateral_type_id) {
		this.collateral_type_id = collateral_type_id;
	}
	public BigDecimal getCollateral_value() {
		return collateral_value;
	}
	public void setCollateral_value(BigDecimal collateral_value) {
		this.collateral_value = collateral_value;
	}
	public String getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(String customer_id) {
		this.customer_id = customer_id;
	}
	public String getDataimport_id() {
		return dataimport_id;
	}
	public void setDataimport_id(String dataimport_id) {
		this.dataimport_id = dataimport_id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getFacility_id() {
		return facility_id;
	}
	public void setFacility_id(String facility_id) {
		this.facility_id = facility_id;
	}
	public BigDecimal getHaircut() {
		return haircut;
	}
	public void setHaircut(BigDecimal haircut) {
		this.haircut = haircut;
	}
	public Date getReport_date() {
		return report_date;
	}
	public void setReport_date(Date report_date) {
		this.report_date = report_date;
	}

	
}