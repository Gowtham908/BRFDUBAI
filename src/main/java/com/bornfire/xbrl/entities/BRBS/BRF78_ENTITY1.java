package com.bornfire.xbrl.entities.BRBS;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "BRF78_SUMMARYTABLE_1")
public class BRF78_ENTITY1 {
	private String	borrowing_entity;
	private String	emirate;
	private String	cin;
	private String	borrower_type;
	private String	group_name;
	private String	credit_rating_of_the_borrower;
	private String	credit_rating_type;
	private String	currency;
	private BigDecimal	funded_os;
	private BigDecimal	debt_securities;
	private BigDecimal	unfunded_os;
	private BigDecimal	ccf_equ_unfunded_os;
	private BigDecimal	ccf_equ_comm_unused_unfund;
	private BigDecimal	total_exposure;
	private BigDecimal	tier_1_capital;
	private String	credit_risk_mitigation_type;
	private BigDecimal	credit_risk_mitigation_after_haircut;
	private BigDecimal	collateral_value_after_haircut;
	private String	cbuae_classification;
	private BigDecimal	provision;
	private String	remarks;
	private String	row_label;
	@Id
	private Date	report_date;
	private Date	report_from_date;
	private Date	report_to_date;
	private String	entity_flg;
	private String	modify_flg;
	private String	del_flg;
	private String	report_code;
	private Date	report_submit_date;
	public String getBorrowing_entity() {
		return borrowing_entity;
	}
	public void setBorrowing_entity(String borrowing_entity) {
		this.borrowing_entity = borrowing_entity;
	}
	public String getEmirate() {
		return emirate;
	}
	public void setEmirate(String emirate) {
		this.emirate = emirate;
	}
	public String getCin() {
		return cin;
	}
	public void setCin(String cin) {
		this.cin = cin;
	}
	public String getBorrower_type() {
		return borrower_type;
	}
	public void setBorrower_type(String borrower_type) {
		this.borrower_type = borrower_type;
	}
	public String getGroup_name() {
		return group_name;
	}
	public void setGroup_name(String group_name) {
		this.group_name = group_name;
	}
	public String getCredit_rating_of_the_borrower() {
		return credit_rating_of_the_borrower;
	}
	public void setCredit_rating_of_the_borrower(String credit_rating_of_the_borrower) {
		this.credit_rating_of_the_borrower = credit_rating_of_the_borrower;
	}
	public String getCredit_rating_type() {
		return credit_rating_type;
	}
	public void setCredit_rating_type(String credit_rating_type) {
		this.credit_rating_type = credit_rating_type;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public BigDecimal getFunded_os() {
		return funded_os;
	}
	public void setFunded_os(BigDecimal funded_os) {
		this.funded_os = funded_os;
	}
	public BigDecimal getDebt_securities() {
		return debt_securities;
	}
	public void setDebt_securities(BigDecimal debt_securities) {
		this.debt_securities = debt_securities;
	}
	public BigDecimal getUnfunded_os() {
		return unfunded_os;
	}
	public void setUnfunded_os(BigDecimal unfunded_os) {
		this.unfunded_os = unfunded_os;
	}
	public BigDecimal getCcf_equ_unfunded_os() {
		return ccf_equ_unfunded_os;
	}
	public void setCcf_equ_unfunded_os(BigDecimal ccf_equ_unfunded_os) {
		this.ccf_equ_unfunded_os = ccf_equ_unfunded_os;
	}
	public BigDecimal getCcf_equ_comm_unused_unfund() {
		return ccf_equ_comm_unused_unfund;
	}
	public void setCcf_equ_comm_unused_unfund(BigDecimal ccf_equ_comm_unused_unfund) {
		this.ccf_equ_comm_unused_unfund = ccf_equ_comm_unused_unfund;
	}
	public BigDecimal getTotal_exposure() {
		return total_exposure;
	}
	public void setTotal_exposure(BigDecimal total_exposure) {
		this.total_exposure = total_exposure;
	}
	public BigDecimal getTier_1_capital() {
		return tier_1_capital;
	}
	public void setTier_1_capital(BigDecimal tier_1_capital) {
		this.tier_1_capital = tier_1_capital;
	}
	public String getCredit_risk_mitigation_type() {
		return credit_risk_mitigation_type;
	}
	public void setCredit_risk_mitigation_type(String credit_risk_mitigation_type) {
		this.credit_risk_mitigation_type = credit_risk_mitigation_type;
	}
	public BigDecimal getCredit_risk_mitigation_after_haircut() {
		return credit_risk_mitigation_after_haircut;
	}
	public void setCredit_risk_mitigation_after_haircut(BigDecimal credit_risk_mitigation_after_haircut) {
		this.credit_risk_mitigation_after_haircut = credit_risk_mitigation_after_haircut;
	}
	public BigDecimal getCollateral_value_after_haircut() {
		return collateral_value_after_haircut;
	}
	public void setCollateral_value_after_haircut(BigDecimal collateral_value_after_haircut) {
		this.collateral_value_after_haircut = collateral_value_after_haircut;
	}
	public String getCbuae_classification() {
		return cbuae_classification;
	}
	public void setCbuae_classification(String cbuae_classification) {
		this.cbuae_classification = cbuae_classification;
	}
	public BigDecimal getProvision() {
		return provision;
	}
	public void setProvision(BigDecimal provision) {
		this.provision = provision;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public String getRow_label() {
		return row_label;
	}
	public void setRow_label(String row_label) {
		this.row_label = row_label;
	}
	public Date getReport_date() {
		return report_date;
	}
	public void setReport_date(Date report_date) {
		this.report_date = report_date;
	}
	public Date getReport_from_date() {
		return report_from_date;
	}
	public void setReport_from_date(Date report_from_date) {
		this.report_from_date = report_from_date;
	}
	public Date getReport_to_date() {
		return report_to_date;
	}
	public void setReport_to_date(Date report_to_date) {
		this.report_to_date = report_to_date;
	}
	public String getEntity_flg() {
		return entity_flg;
	}
	public void setEntity_flg(String entity_flg) {
		this.entity_flg = entity_flg;
	}
	public String getModify_flg() {
		return modify_flg;
	}
	public void setModify_flg(String modify_flg) {
		this.modify_flg = modify_flg;
	}
	public String getDel_flg() {
		return del_flg;
	}
	public void setDel_flg(String del_flg) {
		this.del_flg = del_flg;
	}
	public String getReport_code() {
		return report_code;
	}
	public void setReport_code(String report_code) {
		this.report_code = report_code;
	}
	public Date getReport_submit_date() {
		return report_submit_date;
	}
	public void setReport_submit_date(Date report_submit_date) {
		this.report_submit_date = report_submit_date;
	}
	public BRF78_ENTITY1(String borrowing_entity, String emirate, String cin, String borrower_type, String group_name,
			String credit_rating_of_the_borrower, String credit_rating_type, String currency, BigDecimal funded_os,
			BigDecimal debt_securities, BigDecimal unfunded_os, BigDecimal ccf_equ_unfunded_os,
			BigDecimal ccf_equ_comm_unused_unfund, BigDecimal total_exposure, BigDecimal tier_1_capital,
			String credit_risk_mitigation_type, BigDecimal credit_risk_mitigation_after_haircut,
			BigDecimal collateral_value_after_haircut, String cbuae_classification, BigDecimal provision,
			String remarks, String row_label, Date report_date, Date report_from_date, Date report_to_date,
			String entity_flg, String modify_flg, String del_flg, String report_code, Date report_submit_date) {
		super();
		this.borrowing_entity = borrowing_entity;
		this.emirate = emirate;
		this.cin = cin;
		this.borrower_type = borrower_type;
		this.group_name = group_name;
		this.credit_rating_of_the_borrower = credit_rating_of_the_borrower;
		this.credit_rating_type = credit_rating_type;
		this.currency = currency;
		this.funded_os = funded_os;
		this.debt_securities = debt_securities;
		this.unfunded_os = unfunded_os;
		this.ccf_equ_unfunded_os = ccf_equ_unfunded_os;
		this.ccf_equ_comm_unused_unfund = ccf_equ_comm_unused_unfund;
		this.total_exposure = total_exposure;
		this.tier_1_capital = tier_1_capital;
		this.credit_risk_mitigation_type = credit_risk_mitigation_type;
		this.credit_risk_mitigation_after_haircut = credit_risk_mitigation_after_haircut;
		this.collateral_value_after_haircut = collateral_value_after_haircut;
		this.cbuae_classification = cbuae_classification;
		this.provision = provision;
		this.remarks = remarks;
		this.row_label = row_label;
		this.report_date = report_date;
		this.report_from_date = report_from_date;
		this.report_to_date = report_to_date;
		this.entity_flg = entity_flg;
		this.modify_flg = modify_flg;
		this.del_flg = del_flg;
		this.report_code = report_code;
		this.report_submit_date = report_submit_date;
	}
	public BRF78_ENTITY1() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

}
