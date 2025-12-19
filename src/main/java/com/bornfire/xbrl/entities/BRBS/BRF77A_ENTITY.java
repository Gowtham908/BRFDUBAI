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
@Table(name="BRF77A_SUMMARYTABLE")
public class BRF77A_ENTITY {
	
	private String	name_of_borrow_entity;
	private String	cin_figi_gleiid;
	private String	resi_non_resi;
	private String	country_incorp;
	private String	credit_rating_borrower;
	private String	credit_rating_type;
	private String	currency;
	private BigDecimal	funded_os;
	private BigDecimal	debit_securities;
	private BigDecimal	unfunded_os;
	private BigDecimal	ccf_equi_unfuned_os;
	private BigDecimal	ccf_equi_funded_n_unfuned_limits;
	private BigDecimal	total_exposer;
	private BigDecimal	as_of_tier1_capital;
	private String	credit_risk_miti_type;
	private BigDecimal	credit_risk_miti_hair_cut;
	private BigDecimal	collateral_hair_cut;
	private String	cbuae_class;
	private BigDecimal	provision;
	private String	remarks;
	private String	row_label;
	private BigDecimal	capital_case;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Id
	private Date	report_date;
	private Date	report_from_date;
	private Date	report_to_date;
	private String	entity_flg;
	private String	modify_flg;
	private String	del_flg;
	private String	report_code;
	private Date	report_submit_date;
	public BigDecimal getCapital_case() {
		return capital_case;
	}
	public void setCapital_case(BigDecimal capital_case) {
		this.capital_case = capital_case;
	}
	public String getName_of_borrow_entity() {
		return name_of_borrow_entity;
	}
	public void setName_of_borrow_entity(String name_of_borrow_entity) {
		this.name_of_borrow_entity = name_of_borrow_entity;
	}
	public String getCin_figi_gleiid() {
		return cin_figi_gleiid;
	}
	public void setCin_figi_gleiid(String cin_figi_gleiid) {
		this.cin_figi_gleiid = cin_figi_gleiid;
	}
	public String getResi_non_resi() {
		return resi_non_resi;
	}
	public void setResi_non_resi(String resi_non_resi) {
		this.resi_non_resi = resi_non_resi;
	}
	public String getCountry_incorp() {
		return country_incorp;
	}
	public void setCountry_incorp(String country_incorp) {
		this.country_incorp = country_incorp;
	}
	public String getCredit_rating_borrower() {
		return credit_rating_borrower;
	}
	public void setCredit_rating_borrower(String credit_rating_borrower) {
		this.credit_rating_borrower = credit_rating_borrower;
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
	public BigDecimal getDebit_securities() {
		return debit_securities;
	}
	public void setDebit_securities(BigDecimal debit_securities) {
		this.debit_securities = debit_securities;
	}
	public BigDecimal getUnfunded_os() {
		return unfunded_os;
	}
	public void setUnfunded_os(BigDecimal unfunded_os) {
		this.unfunded_os = unfunded_os;
	}
	public BigDecimal getCcf_equi_unfuned_os() {
		return ccf_equi_unfuned_os;
	}
	public void setCcf_equi_unfuned_os(BigDecimal ccf_equi_unfuned_os) {
		this.ccf_equi_unfuned_os = ccf_equi_unfuned_os;
	}
	public BigDecimal getCcf_equi_funded_n_unfuned_limits() {
		return ccf_equi_funded_n_unfuned_limits;
	}
	public void setCcf_equi_funded_n_unfuned_limits(BigDecimal ccf_equi_funded_n_unfuned_limits) {
		this.ccf_equi_funded_n_unfuned_limits = ccf_equi_funded_n_unfuned_limits;
	}
	public BigDecimal getTotal_exposer() {
		return total_exposer;
	}
	public void setTotal_exposer(BigDecimal total_exposer) {
		this.total_exposer = total_exposer;
	}
	public BigDecimal getAs_of_tier1_capital() {
		return as_of_tier1_capital;
	}
	public void setAs_of_tier1_capital(BigDecimal as_of_tier1_capital) {
		this.as_of_tier1_capital = as_of_tier1_capital;
	}
	public String getCredit_risk_miti_type() {
		return credit_risk_miti_type;
	}
	public void setCredit_risk_miti_type(String credit_risk_miti_type) {
		this.credit_risk_miti_type = credit_risk_miti_type;
	}
	public BigDecimal getCredit_risk_miti_hair_cut() {
		return credit_risk_miti_hair_cut;
	}
	public void setCredit_risk_miti_hair_cut(BigDecimal credit_risk_miti_hair_cut) {
		this.credit_risk_miti_hair_cut = credit_risk_miti_hair_cut;
	}
	public BigDecimal getCollateral_hair_cut() {
		return collateral_hair_cut;
	}
	public void setCollateral_hair_cut(BigDecimal collateral_hair_cut) {
		this.collateral_hair_cut = collateral_hair_cut;
	}
	public String getCbuae_class() {
		return cbuae_class;
	}
	public void setCbuae_class(String cbuae_class) {
		this.cbuae_class = cbuae_class;
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
	@Override
	public String toString() {
		return "BRF77A_ENTITY [capital_case=" + capital_case + ", name_of_borrow_entity=" + name_of_borrow_entity
				+ ", cin_figi_gleiid=" + cin_figi_gleiid + ", resi_non_resi=" + resi_non_resi + ", country_incorp="
				+ country_incorp + ", credit_rating_borrower=" + credit_rating_borrower + ", credit_rating_type="
				+ credit_rating_type + ", currency=" + currency + ", funded_os=" + funded_os + ", debit_securities="
				+ debit_securities + ", unfunded_os=" + unfunded_os + ", ccf_equi_unfuned_os=" + ccf_equi_unfuned_os
				+ ", ccf_equi_funded_n_unfuned_limits=" + ccf_equi_funded_n_unfuned_limits + ", total_exposer="
				+ total_exposer + ", as_of_tier1_capital=" + as_of_tier1_capital + ", credit_risk_miti_type="
				+ credit_risk_miti_type + ", credit_risk_miti_hair_cut=" + credit_risk_miti_hair_cut
				+ ", collateral_hair_cut=" + collateral_hair_cut + ", cbuae_class=" + cbuae_class + ", provision="
				+ provision + ", remarks=" + remarks + ", row_label=" + row_label + ", report_date=" + report_date
				+ ", report_from_date=" + report_from_date + ", report_to_date=" + report_to_date + ", entity_flg="
				+ entity_flg + ", modify_flg=" + modify_flg + ", del_flg=" + del_flg + ", report_code=" + report_code
				+ ", report_submit_date=" + report_submit_date + ", getCapital_case()=" + getCapital_case()
				+ ", getName_of_borrow_entity()=" + getName_of_borrow_entity() + ", getCin_figi_gleiid()="
				+ getCin_figi_gleiid() + ", getResi_non_resi()=" + getResi_non_resi() + ", getCountry_incorp()="
				+ getCountry_incorp() + ", getCredit_rating_borrower()=" + getCredit_rating_borrower()
				+ ", getCredit_rating_type()=" + getCredit_rating_type() + ", getCurrency()=" + getCurrency()
				+ ", getFunded_os()=" + getFunded_os() + ", getDebit_securities()=" + getDebit_securities()
				+ ", getUnfunded_os()=" + getUnfunded_os() + ", getCcf_equi_unfuned_os()=" + getCcf_equi_unfuned_os()
				+ ", getCcf_equi_funded_n_unfuned_limits()=" + getCcf_equi_funded_n_unfuned_limits()
				+ ", getTotal_exposer()=" + getTotal_exposer() + ", getAs_of_tier1_capital()="
				+ getAs_of_tier1_capital() + ", getCredit_risk_miti_type()=" + getCredit_risk_miti_type()
				+ ", getCredit_risk_miti_hair_cut()=" + getCredit_risk_miti_hair_cut() + ", getCollateral_hair_cut()="
				+ getCollateral_hair_cut() + ", getCbuae_class()=" + getCbuae_class() + ", getProvision()="
				+ getProvision() + ", getRemarks()=" + getRemarks() + ", getRow_label()=" + getRow_label()
				+ ", getReport_date()=" + getReport_date() + ", getReport_from_date()=" + getReport_from_date()
				+ ", getReport_to_date()=" + getReport_to_date() + ", getEntity_flg()=" + getEntity_flg()
				+ ", getModify_flg()=" + getModify_flg() + ", getDel_flg()=" + getDel_flg() + ", getReport_code()="
				+ getReport_code() + ", getReport_submit_date()=" + getReport_submit_date() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	public BRF77A_ENTITY(BigDecimal capital_case, String name_of_borrow_entity, String cin_figi_gleiid,
			String resi_non_resi, String country_incorp, String credit_rating_borrower, String credit_rating_type,
			String currency, BigDecimal funded_os, BigDecimal debit_securities, BigDecimal unfunded_os,
			BigDecimal ccf_equi_unfuned_os, BigDecimal ccf_equi_funded_n_unfuned_limits, BigDecimal total_exposer,
			BigDecimal as_of_tier1_capital, String credit_risk_miti_type, BigDecimal credit_risk_miti_hair_cut,
			BigDecimal collateral_hair_cut, String cbuae_class, BigDecimal provision, String remarks, String row_label,
			Date report_date, Date report_from_date, Date report_to_date, String entity_flg, String modify_flg,
			String del_flg, String report_code, Date report_submit_date) {
		super();
		this.capital_case = capital_case;
		this.name_of_borrow_entity = name_of_borrow_entity;
		this.cin_figi_gleiid = cin_figi_gleiid;
		this.resi_non_resi = resi_non_resi;
		this.country_incorp = country_incorp;
		this.credit_rating_borrower = credit_rating_borrower;
		this.credit_rating_type = credit_rating_type;
		this.currency = currency;
		this.funded_os = funded_os;
		this.debit_securities = debit_securities;
		this.unfunded_os = unfunded_os;
		this.ccf_equi_unfuned_os = ccf_equi_unfuned_os;
		this.ccf_equi_funded_n_unfuned_limits = ccf_equi_funded_n_unfuned_limits;
		this.total_exposer = total_exposer;
		this.as_of_tier1_capital = as_of_tier1_capital;
		this.credit_risk_miti_type = credit_risk_miti_type;
		this.credit_risk_miti_hair_cut = credit_risk_miti_hair_cut;
		this.collateral_hair_cut = collateral_hair_cut;
		this.cbuae_class = cbuae_class;
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
	public BRF77A_ENTITY() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
