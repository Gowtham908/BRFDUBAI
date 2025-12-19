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
@Table(name = "BRF84B_SUMMARYTABLE")
public class BRF84B_ENTITY {
	private String part;
	private String description;
	private String country;
	private BigDecimal no_of_officies;
	private BigDecimal funded_os;
	private BigDecimal debit_securities;
	private BigDecimal unfunded_os;
	private BigDecimal ccf_equi_unfuned_os;
	private BigDecimal ccf_equi_funded_n_unfuned_limits;
	private BigDecimal total_exposer;
	private BigDecimal as_of_tier1_capital;
	private String credit_risk_miti_type;
	private BigDecimal credit_risk_miti_hair_cut;
	private BigDecimal collateral_hair_cut;
	private String cbuae_class;
	private BigDecimal provision;
	private String remarks;
	private BigDecimal fundedos_total;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Id
	private Date report_date;
	private Date report_from_date;
	private Date report_to_date;
	private String entity_flg;
	private String modify_flg;
	private String del_flg;
	private String report_code;
	private Date report_submit_date;
	private String row_label;
	private BigDecimal debtsecurity_total;
	private BigDecimal unfunded_total;
	private BigDecimal ccfeqi_unfund_total;
	private BigDecimal ccf_eqi_limit_total;
	private BigDecimal total_exposure_total;
	private BigDecimal as_tier_total;
	private BigDecimal credit_risk_haircut_total;
	private BigDecimal collateralvalue_total;
	private BigDecimal provision_total;
	private String repdesc;
	private String frequency;

	public String getPart() {
		return part;
	}

	public String getDescription() {
		return description;
	}

	public String getCountry() {
		return country;
	}

	public BigDecimal getNo_of_officies() {
		return no_of_officies;
	}

	public BigDecimal getFunded_os() {
		return funded_os;
	}

	public BigDecimal getDebit_securities() {
		return debit_securities;
	}

	public BigDecimal getUnfunded_os() {
		return unfunded_os;
	}

	public BigDecimal getCcf_equi_unfuned_os() {
		return ccf_equi_unfuned_os;
	}

	public BigDecimal getCcf_equi_funded_n_unfuned_limits() {
		return ccf_equi_funded_n_unfuned_limits;
	}

	public BigDecimal getTotal_exposer() {
		return total_exposer;
	}

	public BigDecimal getAs_of_tier1_capital() {
		return as_of_tier1_capital;
	}

	public String getCredit_risk_miti_type() {
		return credit_risk_miti_type;
	}

	public BigDecimal getCredit_risk_miti_hair_cut() {
		return credit_risk_miti_hair_cut;
	}

	public BigDecimal getCollateral_hair_cut() {
		return collateral_hair_cut;
	}

	public String getCbuae_class() {
		return cbuae_class;
	}

	public BigDecimal getProvision() {
		return provision;
	}

	public String getRemarks() {
		return remarks;
	}

	public BigDecimal getFundedos_total() {
		return fundedos_total;
	}

	public Date getReport_date() {
		return report_date;
	}

	public Date getReport_from_date() {
		return report_from_date;
	}

	public Date getReport_to_date() {
		return report_to_date;
	}

	public String getEntity_flg() {
		return entity_flg;
	}

	public String getModify_flg() {
		return modify_flg;
	}

	public String getDel_flg() {
		return del_flg;
	}

	public String getReport_code() {
		return report_code;
	}

	public Date getReport_submit_date() {
		return report_submit_date;
	}

	public String getRow_label() {
		return row_label;
	}

	public BigDecimal getDebtsecurity_total() {
		return debtsecurity_total;
	}

	public BigDecimal getUnfunded_total() {
		return unfunded_total;
	}

	public BigDecimal getCcfeqi_unfund_total() {
		return ccfeqi_unfund_total;
	}

	public BigDecimal getCcf_eqi_limit_total() {
		return ccf_eqi_limit_total;
	}

	public BigDecimal getTotal_exposure_total() {
		return total_exposure_total;
	}

	public BigDecimal getAs_tier_total() {
		return as_tier_total;
	}

	public BigDecimal getCredit_risk_haircut_total() {
		return credit_risk_haircut_total;
	}

	public BigDecimal getCollateralvalue_total() {
		return collateralvalue_total;
	}

	public BigDecimal getProvision_total() {
		return provision_total;
	}

	public String getRepdesc() {
		return repdesc;
	}

	public String getFrequency() {
		return frequency;
	}

	public void setPart(String part) {
		this.part = part;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public void setNo_of_officies(BigDecimal no_of_officies) {
		this.no_of_officies = no_of_officies;
	}

	public void setFunded_os(BigDecimal funded_os) {
		this.funded_os = funded_os;
	}

	public void setDebit_securities(BigDecimal debit_securities) {
		this.debit_securities = debit_securities;
	}

	public void setUnfunded_os(BigDecimal unfunded_os) {
		this.unfunded_os = unfunded_os;
	}

	public void setCcf_equi_unfuned_os(BigDecimal ccf_equi_unfuned_os) {
		this.ccf_equi_unfuned_os = ccf_equi_unfuned_os;
	}

	public void setCcf_equi_funded_n_unfuned_limits(BigDecimal ccf_equi_funded_n_unfuned_limits) {
		this.ccf_equi_funded_n_unfuned_limits = ccf_equi_funded_n_unfuned_limits;
	}

	public void setTotal_exposer(BigDecimal total_exposer) {
		this.total_exposer = total_exposer;
	}

	public void setAs_of_tier1_capital(BigDecimal as_of_tier1_capital) {
		this.as_of_tier1_capital = as_of_tier1_capital;
	}

	public void setCredit_risk_miti_type(String credit_risk_miti_type) {
		this.credit_risk_miti_type = credit_risk_miti_type;
	}

	public void setCredit_risk_miti_hair_cut(BigDecimal credit_risk_miti_hair_cut) {
		this.credit_risk_miti_hair_cut = credit_risk_miti_hair_cut;
	}

	public void setCollateral_hair_cut(BigDecimal collateral_hair_cut) {
		this.collateral_hair_cut = collateral_hair_cut;
	}

	public void setCbuae_class(String cbuae_class) {
		this.cbuae_class = cbuae_class;
	}

	public void setProvision(BigDecimal provision) {
		this.provision = provision;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public void setFundedos_total(BigDecimal fundedos_total) {
		this.fundedos_total = fundedos_total;
	}

	public void setReport_date(Date report_date) {
		this.report_date = report_date;
	}

	public void setReport_from_date(Date report_from_date) {
		this.report_from_date = report_from_date;
	}

	public void setReport_to_date(Date report_to_date) {
		this.report_to_date = report_to_date;
	}

	public void setEntity_flg(String entity_flg) {
		this.entity_flg = entity_flg;
	}

	public void setModify_flg(String modify_flg) {
		this.modify_flg = modify_flg;
	}

	public void setDel_flg(String del_flg) {
		this.del_flg = del_flg;
	}

	public void setReport_code(String report_code) {
		this.report_code = report_code;
	}

	public void setReport_submit_date(Date report_submit_date) {
		this.report_submit_date = report_submit_date;
	}

	public void setRow_label(String row_label) {
		this.row_label = row_label;
	}

	public void setDebtsecurity_total(BigDecimal debtsecurity_total) {
		this.debtsecurity_total = debtsecurity_total;
	}

	public void setUnfunded_total(BigDecimal unfunded_total) {
		this.unfunded_total = unfunded_total;
	}

	public void setCcfeqi_unfund_total(BigDecimal ccfeqi_unfund_total) {
		this.ccfeqi_unfund_total = ccfeqi_unfund_total;
	}

	public void setCcf_eqi_limit_total(BigDecimal ccf_eqi_limit_total) {
		this.ccf_eqi_limit_total = ccf_eqi_limit_total;
	}

	public void setTotal_exposure_total(BigDecimal total_exposure_total) {
		this.total_exposure_total = total_exposure_total;
	}

	public void setAs_tier_total(BigDecimal as_tier_total) {
		this.as_tier_total = as_tier_total;
	}

	public void setCredit_risk_haircut_total(BigDecimal credit_risk_haircut_total) {
		this.credit_risk_haircut_total = credit_risk_haircut_total;
	}

	public void setCollateralvalue_total(BigDecimal collateralvalue_total) {
		this.collateralvalue_total = collateralvalue_total;
	}

	public void setProvision_total(BigDecimal provision_total) {
		this.provision_total = provision_total;
	}

	public void setRepdesc(String repdesc) {
		this.repdesc = repdesc;
	}

	public void setFrequency(String frequency) {
		this.frequency = frequency;
	}

	public BRF84B_ENTITY(String part, String description, String country, BigDecimal no_of_officies,
			BigDecimal funded_os, BigDecimal debit_securities, BigDecimal unfunded_os, BigDecimal ccf_equi_unfuned_os,
			BigDecimal ccf_equi_funded_n_unfuned_limits, BigDecimal total_exposer, BigDecimal as_of_tier1_capital,
			String credit_risk_miti_type, BigDecimal credit_risk_miti_hair_cut, BigDecimal collateral_hair_cut,
			String cbuae_class, BigDecimal provision, String remarks, BigDecimal fundedos_total, Date report_date,
			Date report_from_date, Date report_to_date, String entity_flg, String modify_flg, String del_flg,
			String report_code, Date report_submit_date, String row_label, BigDecimal debtsecurity_total,
			BigDecimal unfunded_total, BigDecimal ccfeqi_unfund_total, BigDecimal ccf_eqi_limit_total,
			BigDecimal total_exposure_total, BigDecimal as_tier_total, BigDecimal credit_risk_haircut_total,
			BigDecimal collateralvalue_total, BigDecimal provision_total, String repdesc, String frequency) {
		super();
		this.part = part;
		this.description = description;
		this.country = country;
		this.no_of_officies = no_of_officies;
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
		this.fundedos_total = fundedos_total;
		this.report_date = report_date;
		this.report_from_date = report_from_date;
		this.report_to_date = report_to_date;
		this.entity_flg = entity_flg;
		this.modify_flg = modify_flg;
		this.del_flg = del_flg;
		this.report_code = report_code;
		this.report_submit_date = report_submit_date;
		this.row_label = row_label;
		this.debtsecurity_total = debtsecurity_total;
		this.unfunded_total = unfunded_total;
		this.ccfeqi_unfund_total = ccfeqi_unfund_total;
		this.ccf_eqi_limit_total = ccf_eqi_limit_total;
		this.total_exposure_total = total_exposure_total;
		this.as_tier_total = as_tier_total;
		this.credit_risk_haircut_total = credit_risk_haircut_total;
		this.collateralvalue_total = collateralvalue_total;
		this.provision_total = provision_total;
		this.repdesc = repdesc;
		this.frequency = frequency;
	}

	public BRF84B_ENTITY() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "BRF84B_ENTITY [part=" + part + ", description=" + description + ", country=" + country
				+ ", no_of_officies=" + no_of_officies + ", funded_os=" + funded_os + ", debit_securities="
				+ debit_securities + ", unfunded_os=" + unfunded_os + ", ccf_equi_unfuned_os=" + ccf_equi_unfuned_os
				+ ", ccf_equi_funded_n_unfuned_limits=" + ccf_equi_funded_n_unfuned_limits + ", total_exposer="
				+ total_exposer + ", as_of_tier1_capital=" + as_of_tier1_capital + ", credit_risk_miti_type="
				+ credit_risk_miti_type + ", credit_risk_miti_hair_cut=" + credit_risk_miti_hair_cut
				+ ", collateral_hair_cut=" + collateral_hair_cut + ", cbuae_class=" + cbuae_class + ", provision="
				+ provision + ", remarks=" + remarks + ", fundedos_total=" + fundedos_total + ", report_date="
				+ report_date + ", report_from_date=" + report_from_date + ", report_to_date=" + report_to_date
				+ ", entity_flg=" + entity_flg + ", modify_flg=" + modify_flg + ", del_flg=" + del_flg
				+ ", report_code=" + report_code + ", report_submit_date=" + report_submit_date + ", row_label="
				+ row_label + ", debtsecurity_total=" + debtsecurity_total + ", unfunded_total=" + unfunded_total
				+ ", ccfeqi_unfund_total=" + ccfeqi_unfund_total + ", ccf_eqi_limit_total=" + ccf_eqi_limit_total
				+ ", total_exposure_total=" + total_exposure_total + ", as_tier_total=" + as_tier_total
				+ ", credit_risk_haircut_total=" + credit_risk_haircut_total + ", collateralvalue_total="
				+ collateralvalue_total + ", provision_total=" + provision_total + ", repdesc=" + repdesc
				+ ", frequency=" + frequency + ", getPart()=" + getPart() + ", getDescription()=" + getDescription()
				+ ", getCountry()=" + getCountry() + ", getNo_of_officies()=" + getNo_of_officies()
				+ ", getFunded_os()=" + getFunded_os() + ", getDebit_securities()=" + getDebit_securities()
				+ ", getUnfunded_os()=" + getUnfunded_os() + ", getCcf_equi_unfuned_os()=" + getCcf_equi_unfuned_os()
				+ ", getCcf_equi_funded_n_unfuned_limits()=" + getCcf_equi_funded_n_unfuned_limits()
				+ ", getTotal_exposer()=" + getTotal_exposer() + ", getAs_of_tier1_capital()="
				+ getAs_of_tier1_capital() + ", getCredit_risk_miti_type()=" + getCredit_risk_miti_type()
				+ ", getCredit_risk_miti_hair_cut()=" + getCredit_risk_miti_hair_cut() + ", getCollateral_hair_cut()="
				+ getCollateral_hair_cut() + ", getCbuae_class()=" + getCbuae_class() + ", getProvision()="
				+ getProvision() + ", getRemarks()=" + getRemarks() + ", getFundedos_total()=" + getFundedos_total()
				+ ", getReport_date()=" + getReport_date() + ", getReport_from_date()=" + getReport_from_date()
				+ ", getReport_to_date()=" + getReport_to_date() + ", getEntity_flg()=" + getEntity_flg()
				+ ", getModify_flg()=" + getModify_flg() + ", getDel_flg()=" + getDel_flg() + ", getReport_code()="
				+ getReport_code() + ", getReport_submit_date()=" + getReport_submit_date() + ", getRow_label()="
				+ getRow_label() + ", getDebtsecurity_total()=" + getDebtsecurity_total() + ", getUnfunded_total()="
				+ getUnfunded_total() + ", getCcfeqi_unfund_total()=" + getCcfeqi_unfund_total()
				+ ", getCcf_eqi_limit_total()=" + getCcf_eqi_limit_total() + ", getTotal_exposure_total()="
				+ getTotal_exposure_total() + ", getAs_tier_total()=" + getAs_tier_total()
				+ ", getCredit_risk_haircut_total()=" + getCredit_risk_haircut_total() + ", getCollateralvalue_total()="
				+ getCollateralvalue_total() + ", getProvision_total()=" + getProvision_total() + ", getRepdesc()="
				+ getRepdesc() + ", getFrequency()=" + getFrequency() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}
}