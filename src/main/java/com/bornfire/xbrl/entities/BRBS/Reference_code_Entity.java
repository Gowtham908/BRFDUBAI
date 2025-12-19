package com.bornfire.xbrl.entities.BRBS;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="CUSTOMER_MASTER_TABLE")
public class Reference_code_Entity {

	private String	cust_id;
	@Id
	private String	acct_number;
	private String	acct_name;
	private String	bacid;
	private String	country_of_incorp;
	private BigDecimal	hni_networth;
	private BigDecimal	purpose_of_advn;
	private BigDecimal	turnover;
	private String	reference_type;
	private String	reference_code;
	private String	description;
	private String	remarks;
	public String getCust_id() {
		return cust_id;
	}
	public void setCust_id(String cust_id) {
		this.cust_id = cust_id;
	}
	public String getAcct_number() {
		return acct_number;
	}
	public void setAcct_number(String acct_number) {
		this.acct_number = acct_number;
	}
	public String getAcct_name() {
		return acct_name;
	}
	public void setAcct_name(String acct_name) {
		this.acct_name = acct_name;
	}
	public String getBacid() {
		return bacid;
	}
	public void setBacid(String bacid) {
		this.bacid = bacid;
	}
	public String getCountry_of_incorp() {
		return country_of_incorp;
	}
	public void setCountry_of_incorp(String country_of_incorp) {
		this.country_of_incorp = country_of_incorp;
	}
	public BigDecimal getHni_networth() {
		return hni_networth;
	}
	public void setHni_networth(BigDecimal hni_networth) {
		this.hni_networth = hni_networth;
	}
	public BigDecimal getPurpose_of_advn() {
		return purpose_of_advn;
	}
	public void setPurpose_of_advn(BigDecimal purpose_of_advn) {
		this.purpose_of_advn = purpose_of_advn;
	}
	public BigDecimal getTurnover() {
		return turnover;
	}
	public void setTurnover(BigDecimal turnover) {
		this.turnover = turnover;
	}
	public String getReference_type() {
		return reference_type;
	}
	public void setReference_type(String reference_type) {
		this.reference_type = reference_type;
	}
	public String getReference_code() {
		return reference_code;
	}
	public void setReference_code(String reference_code) {
		this.reference_code = reference_code;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public Reference_code_Entity(String cust_id, String acct_number, String acct_name, String bacid,
			String country_of_incorp, BigDecimal hni_networth, BigDecimal purpose_of_advn, BigDecimal turnover,
			String reference_type, String reference_code, String description, String remarks) {
		super();
		this.cust_id = cust_id;
		this.acct_number = acct_number;
		this.acct_name = acct_name;
		this.bacid = bacid;
		this.country_of_incorp = country_of_incorp;
		this.hni_networth = hni_networth;
		this.purpose_of_advn = purpose_of_advn;
		this.turnover = turnover;
		this.reference_type = reference_type;
		this.reference_code = reference_code;
		this.description = description;
		this.remarks = remarks;
	}
	public Reference_code_Entity() {
		super();
	}
}
