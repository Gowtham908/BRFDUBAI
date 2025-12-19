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
@Table(name="BRF81_SUMMARYTABLE")
public class BRF81_ENTITY {
	private BigDecimal	tier1_capital;
	private BigDecimal	entity_level;
	private String	name_of_borrower;
	private String	cin_figi_gleiid;
	private String	borrower_type;
	private String	group_name;
	private String	resident;
	private String	country_incorporate;
	private String	credit_rating;
	private String	credit_rating_type;
	private String	economic_sector;
	private String	currency;
	private BigDecimal	funded_os;
	private BigDecimal	debit;
	private BigDecimal	equities;
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
	@Id
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date	report_date;
	private Date	report_from_date;
	private Date	report_to_date;
	private String	entity_flg;
	private String	modify_flg;
	private String	del_flg;
	private String	report_code;
	private Date	report_submit_date;
	private String	repdesc;
	private String	frequency;
	public BigDecimal getTier1_capital() {
		return tier1_capital;
	}
	public void setTier1_capital(BigDecimal tier1_capital) {
		this.tier1_capital = tier1_capital;
	}
	public BigDecimal getEntity_level() {
		return entity_level;
	}
	public void setEntity_level(BigDecimal entity_level) {
		this.entity_level = entity_level;
	}
	public String getName_of_borrower() {
		return name_of_borrower;
	}
	public void setName_of_borrower(String name_of_borrower) {
		this.name_of_borrower = name_of_borrower;
	}
	public String getCin_figi_gleiid() {
		return cin_figi_gleiid;
	}
	public void setCin_figi_gleiid(String cin_figi_gleiid) {
		this.cin_figi_gleiid = cin_figi_gleiid;
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
	public String getResident() {
		return resident;
	}
	public void setResident(String resident) {
		this.resident = resident;
	}
	public String getCountry_incorporate() {
		return country_incorporate;
	}
	public void setCountry_incorporate(String country_incorporate) {
		this.country_incorporate = country_incorporate;
	}
	public String getCredit_rating() {
		return credit_rating;
	}
	public void setCredit_rating(String credit_rating) {
		this.credit_rating = credit_rating;
	}
	public String getCredit_rating_type() {
		return credit_rating_type;
	}
	public void setCredit_rating_type(String credit_rating_type) {
		this.credit_rating_type = credit_rating_type;
	}
	public String getEconomic_sector() {
		return economic_sector;
	}
	public void setEconomic_sector(String economic_sector) {
		this.economic_sector = economic_sector;
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
	public BigDecimal getDebit() {
		return debit;
	}
	public void setDebit(BigDecimal debit) {
		this.debit = debit;
	}
	public BigDecimal getEquities() {
		return equities;
	}
	public void setEquities(BigDecimal equities) {
		this.equities = equities;
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
	public String getRepdesc() {
		return repdesc;
	}
	public void setRepdesc(String repdesc) {
		this.repdesc = repdesc;
	}
	public String getFrequency() {
		return frequency;
	}
	public void setFrequency(String frequency) {
		this.frequency = frequency;
	}
	public BRF81_ENTITY() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}