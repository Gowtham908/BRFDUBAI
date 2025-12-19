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
@Table(name="BRF79_SUMMARYTABLE")
public class BRF79_ENTITY {
	private BigDecimal	capital_case;
	private String	r1_product;
	private String	r1_emirates;
	private String	r1_cin_figi_glei;
	private String	r1_specify_as;
	private String	r1_borrower_type;
	private String	r1_group_name;
	private String	r1_credit_rating;
	private String	r1_credit_type;
	private String	r1_economic_sec;
	private String	r1_currency;
	private BigDecimal	r1_fund_os;
	private BigDecimal	r1_debt_security;
	private BigDecimal	r1_equities;
	private BigDecimal	r1_unfunded_os;
	private BigDecimal	r1_unfunded_ccf;
	private BigDecimal	r1_unused_unfunded_ccf;
	private BigDecimal	r1_total_exposure_ccf;
	private BigDecimal	r1_tier_capital;
	private String	r1_credit_risk_type;
	private BigDecimal	r1_credit_cut;
	private BigDecimal	r1_collateral_cut;
	private String	r1_cbuae;
	private BigDecimal	r1_provision;
	private String	r1_remarks;
	private String	r2_product;
	private String	r2_emirates;
	private String	r2_cin_figi_glei;
	private String	r2_specify_as;
	private String	r2_borrower_type;
	private String	r2_group_name;
	private String	r2_credit_rating;
	private String	r2_credit_type;
	private String	r2_economic_sec;
	private String	r2_currency;
	private BigDecimal	r2_fund_os;
	private BigDecimal	r2_debt_security;
	private BigDecimal	r2_equities;
	private BigDecimal	r2_unfunded_os;
	private BigDecimal	r2_unfunded_ccf;
	private BigDecimal	r2_unused_unfunded_ccf;
	private BigDecimal	r2_total_exposure_ccf;
	private BigDecimal	r2_tier_capital;
	private String	r2_credit_risk_type;
	private BigDecimal	r2_credit_cut;
	private BigDecimal	r2_collateral_cut;
	private String	r2_cbuae;
	private BigDecimal	r2_provision;
	private String	r2_remarks;
	
	private String	r3_product;
	private String	r3_emirates;
	private String	r3_cin_figi_glei;
	private String	r3_specify_as;
	private String	r3_borrower_type;
	private String	r3_group_name;
	private String	r3_credit_rating;
	private String	r3_credit_type;
	private String	r3_economic_sec;
	private String	r3_currency;
	private BigDecimal	r3_fund_os;
	private BigDecimal	r3_debt_security;
	private BigDecimal	r3_equities;
	private BigDecimal	r3_unfunded_os;
	private BigDecimal	r3_unfunded_ccf;
	private BigDecimal	r3_unused_unfunded_ccf;
	private BigDecimal	r3_total_exposure_ccf;
	private BigDecimal	r3_tier_capital;
	private String	r3_credit_risk_type;
	private BigDecimal	r3_credit_cut;
	private BigDecimal	r3_collateral_cut;
	private String	r3_cbuae;
	private BigDecimal	r3_provision;
	private String	r3_remarks;
	
	
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
	private String	repdesc;
	private String	frequency;
	public BigDecimal getCapital_case() {
		return capital_case;
	}
	public void setCapital_case(BigDecimal capital_case) {
		this.capital_case = capital_case;
	}
	public String getR1_product() {
		return r1_product;
	}
	public void setR1_product(String r1_product) {
		this.r1_product = r1_product;
	}
	public String getR1_emirates() {
		return r1_emirates;
	}
	public void setR1_emirates(String r1_emirates) {
		this.r1_emirates = r1_emirates;
	}
	public String getR1_cin_figi_glei() {
		return r1_cin_figi_glei;
	}
	public void setR1_cin_figi_glei(String r1_cin_figi_glei) {
		this.r1_cin_figi_glei = r1_cin_figi_glei;
	}
	public String getR1_specify_as() {
		return r1_specify_as;
	}
	public void setR1_specify_as(String r1_specify_as) {
		this.r1_specify_as = r1_specify_as;
	}
	public String getR1_borrower_type() {
		return r1_borrower_type;
	}
	public void setR1_borrower_type(String r1_borrower_type) {
		this.r1_borrower_type = r1_borrower_type;
	}
	public String getR1_group_name() {
		return r1_group_name;
	}
	public void setR1_group_name(String r1_group_name) {
		this.r1_group_name = r1_group_name;
	}
	public String getR1_credit_rating() {
		return r1_credit_rating;
	}
	public void setR1_credit_rating(String r1_credit_rating) {
		this.r1_credit_rating = r1_credit_rating;
	}
	public String getR1_credit_type() {
		return r1_credit_type;
	}
	public void setR1_credit_type(String r1_credit_type) {
		this.r1_credit_type = r1_credit_type;
	}
	public String getR1_economic_sec() {
		return r1_economic_sec;
	}
	public void setR1_economic_sec(String r1_economic_sec) {
		this.r1_economic_sec = r1_economic_sec;
	}
	public String getR1_currency() {
		return r1_currency;
	}
	public void setR1_currency(String r1_currency) {
		this.r1_currency = r1_currency;
	}
	public BigDecimal getR1_fund_os() {
		return r1_fund_os;
	}
	public void setR1_fund_os(BigDecimal r1_fund_os) {
		this.r1_fund_os = r1_fund_os;
	}
	public BigDecimal getR1_debt_security() {
		return r1_debt_security;
	}
	public void setR1_debt_security(BigDecimal r1_debt_security) {
		this.r1_debt_security = r1_debt_security;
	}
	public BigDecimal getR1_equities() {
		return r1_equities;
	}
	public void setR1_equities(BigDecimal r1_equities) {
		this.r1_equities = r1_equities;
	}
	public BigDecimal getR1_unfunded_os() {
		return r1_unfunded_os;
	}
	public void setR1_unfunded_os(BigDecimal r1_unfunded_os) {
		this.r1_unfunded_os = r1_unfunded_os;
	}
	public BigDecimal getR1_unfunded_ccf() {
		return r1_unfunded_ccf;
	}
	public void setR1_unfunded_ccf(BigDecimal r1_unfunded_ccf) {
		this.r1_unfunded_ccf = r1_unfunded_ccf;
	}
	public BigDecimal getR1_unused_unfunded_ccf() {
		return r1_unused_unfunded_ccf;
	}
	public void setR1_unused_unfunded_ccf(BigDecimal r1_unused_unfunded_ccf) {
		this.r1_unused_unfunded_ccf = r1_unused_unfunded_ccf;
	}
	public BigDecimal getR1_total_exposure_ccf() {
		return r1_total_exposure_ccf;
	}
	public void setR1_total_exposure_ccf(BigDecimal r1_total_exposure_ccf) {
		this.r1_total_exposure_ccf = r1_total_exposure_ccf;
	}
	public BigDecimal getR1_tier_capital() {
		return r1_tier_capital;
	}
	public void setR1_tier_capital(BigDecimal r1_tier_capital) {
		this.r1_tier_capital = r1_tier_capital;
	}
	public String getR1_credit_risk_type() {
		return r1_credit_risk_type;
	}
	public void setR1_credit_risk_type(String r1_credit_risk_type) {
		this.r1_credit_risk_type = r1_credit_risk_type;
	}
	public BigDecimal getR1_credit_cut() {
		return r1_credit_cut;
	}
	public void setR1_credit_cut(BigDecimal r1_credit_cut) {
		this.r1_credit_cut = r1_credit_cut;
	}
	public BigDecimal getR1_collateral_cut() {
		return r1_collateral_cut;
	}
	public void setR1_collateral_cut(BigDecimal r1_collateral_cut) {
		this.r1_collateral_cut = r1_collateral_cut;
	}
	public String getR1_cbuae() {
		return r1_cbuae;
	}
	public void setR1_cbuae(String r1_cbuae) {
		this.r1_cbuae = r1_cbuae;
	}
	public BigDecimal getR1_provision() {
		return r1_provision;
	}
	public void setR1_provision(BigDecimal r1_provision) {
		this.r1_provision = r1_provision;
	}
	public String getR1_remarks() {
		return r1_remarks;
	}
	public void setR1_remarks(String r1_remarks) {
		this.r1_remarks = r1_remarks;
	}
	public String getR2_product() {
		return r2_product;
	}
	public void setR2_product(String r2_product) {
		this.r2_product = r2_product;
	}
	public String getR2_emirates() {
		return r2_emirates;
	}
	public void setR2_emirates(String r2_emirates) {
		this.r2_emirates = r2_emirates;
	}
	public String getR2_cin_figi_glei() {
		return r2_cin_figi_glei;
	}
	public void setR2_cin_figi_glei(String r2_cin_figi_glei) {
		this.r2_cin_figi_glei = r2_cin_figi_glei;
	}
	public String getR2_specify_as() {
		return r2_specify_as;
	}
	public void setR2_specify_as(String r2_specify_as) {
		this.r2_specify_as = r2_specify_as;
	}
	public String getR2_borrower_type() {
		return r2_borrower_type;
	}
	public void setR2_borrower_type(String r2_borrower_type) {
		this.r2_borrower_type = r2_borrower_type;
	}
	public String getR2_group_name() {
		return r2_group_name;
	}
	public void setR2_group_name(String r2_group_name) {
		this.r2_group_name = r2_group_name;
	}
	public String getR2_credit_rating() {
		return r2_credit_rating;
	}
	public void setR2_credit_rating(String r2_credit_rating) {
		this.r2_credit_rating = r2_credit_rating;
	}
	public String getR2_credit_type() {
		return r2_credit_type;
	}
	public void setR2_credit_type(String r2_credit_type) {
		this.r2_credit_type = r2_credit_type;
	}
	public String getR2_economic_sec() {
		return r2_economic_sec;
	}
	public void setR2_economic_sec(String r2_economic_sec) {
		this.r2_economic_sec = r2_economic_sec;
	}
	public String getR2_currency() {
		return r2_currency;
	}
	public void setR2_currency(String r2_currency) {
		this.r2_currency = r2_currency;
	}
	public BigDecimal getR2_fund_os() {
		return r2_fund_os;
	}
	public void setR2_fund_os(BigDecimal r2_fund_os) {
		this.r2_fund_os = r2_fund_os;
	}
	public BigDecimal getR2_debt_security() {
		return r2_debt_security;
	}
	public void setR2_debt_security(BigDecimal r2_debt_security) {
		this.r2_debt_security = r2_debt_security;
	}
	public BigDecimal getR2_equities() {
		return r2_equities;
	}
	public void setR2_equities(BigDecimal r2_equities) {
		this.r2_equities = r2_equities;
	}
	public BigDecimal getR2_unfunded_os() {
		return r2_unfunded_os;
	}
	public void setR2_unfunded_os(BigDecimal r2_unfunded_os) {
		this.r2_unfunded_os = r2_unfunded_os;
	}
	public BigDecimal getR2_unfunded_ccf() {
		return r2_unfunded_ccf;
	}
	public void setR2_unfunded_ccf(BigDecimal r2_unfunded_ccf) {
		this.r2_unfunded_ccf = r2_unfunded_ccf;
	}
	public BigDecimal getR2_unused_unfunded_ccf() {
		return r2_unused_unfunded_ccf;
	}
	public void setR2_unused_unfunded_ccf(BigDecimal r2_unused_unfunded_ccf) {
		this.r2_unused_unfunded_ccf = r2_unused_unfunded_ccf;
	}
	public BigDecimal getR2_total_exposure_ccf() {
		return r2_total_exposure_ccf;
	}
	public void setR2_total_exposure_ccf(BigDecimal r2_total_exposure_ccf) {
		this.r2_total_exposure_ccf = r2_total_exposure_ccf;
	}
	public BigDecimal getR2_tier_capital() {
		return r2_tier_capital;
	}
	public void setR2_tier_capital(BigDecimal r2_tier_capital) {
		this.r2_tier_capital = r2_tier_capital;
	}
	public String getR2_credit_risk_type() {
		return r2_credit_risk_type;
	}
	public void setR2_credit_risk_type(String r2_credit_risk_type) {
		this.r2_credit_risk_type = r2_credit_risk_type;
	}
	public BigDecimal getR2_credit_cut() {
		return r2_credit_cut;
	}
	public void setR2_credit_cut(BigDecimal r2_credit_cut) {
		this.r2_credit_cut = r2_credit_cut;
	}
	public BigDecimal getR2_collateral_cut() {
		return r2_collateral_cut;
	}
	public void setR2_collateral_cut(BigDecimal r2_collateral_cut) {
		this.r2_collateral_cut = r2_collateral_cut;
	}
	public String getR2_cbuae() {
		return r2_cbuae;
	}
	public void setR2_cbuae(String r2_cbuae) {
		this.r2_cbuae = r2_cbuae;
	}
	public BigDecimal getR2_provision() {
		return r2_provision;
	}
	public void setR2_provision(BigDecimal r2_provision) {
		this.r2_provision = r2_provision;
	}
	public String getR2_remarks() {
		return r2_remarks;
	}
	public void setR2_remarks(String r2_remarks) {
		this.r2_remarks = r2_remarks;
	}
	public String getR3_product() {
		return r3_product;
	}
	public void setR3_product(String r3_product) {
		this.r3_product = r3_product;
	}
	public String getR3_emirates() {
		return r3_emirates;
	}
	public void setR3_emirates(String r3_emirates) {
		this.r3_emirates = r3_emirates;
	}
	public String getR3_cin_figi_glei() {
		return r3_cin_figi_glei;
	}
	public void setR3_cin_figi_glei(String r3_cin_figi_glei) {
		this.r3_cin_figi_glei = r3_cin_figi_glei;
	}
	public String getR3_specify_as() {
		return r3_specify_as;
	}
	public void setR3_specify_as(String r3_specify_as) {
		this.r3_specify_as = r3_specify_as;
	}
	public String getR3_borrower_type() {
		return r3_borrower_type;
	}
	public void setR3_borrower_type(String r3_borrower_type) {
		this.r3_borrower_type = r3_borrower_type;
	}
	public String getR3_group_name() {
		return r3_group_name;
	}
	public void setR3_group_name(String r3_group_name) {
		this.r3_group_name = r3_group_name;
	}
	public String getR3_credit_rating() {
		return r3_credit_rating;
	}
	public void setR3_credit_rating(String r3_credit_rating) {
		this.r3_credit_rating = r3_credit_rating;
	}
	public String getR3_credit_type() {
		return r3_credit_type;
	}
	public void setR3_credit_type(String r3_credit_type) {
		this.r3_credit_type = r3_credit_type;
	}
	public String getR3_economic_sec() {
		return r3_economic_sec;
	}
	public void setR3_economic_sec(String r3_economic_sec) {
		this.r3_economic_sec = r3_economic_sec;
	}
	public String getR3_currency() {
		return r3_currency;
	}
	public void setR3_currency(String r3_currency) {
		this.r3_currency = r3_currency;
	}
	public BigDecimal getR3_fund_os() {
		return r3_fund_os;
	}
	public void setR3_fund_os(BigDecimal r3_fund_os) {
		this.r3_fund_os = r3_fund_os;
	}
	public BigDecimal getR3_debt_security() {
		return r3_debt_security;
	}
	public void setR3_debt_security(BigDecimal r3_debt_security) {
		this.r3_debt_security = r3_debt_security;
	}
	public BigDecimal getR3_equities() {
		return r3_equities;
	}
	public void setR3_equities(BigDecimal r3_equities) {
		this.r3_equities = r3_equities;
	}
	public BigDecimal getR3_unfunded_os() {
		return r3_unfunded_os;
	}
	public void setR3_unfunded_os(BigDecimal r3_unfunded_os) {
		this.r3_unfunded_os = r3_unfunded_os;
	}
	public BigDecimal getR3_unfunded_ccf() {
		return r3_unfunded_ccf;
	}
	public void setR3_unfunded_ccf(BigDecimal r3_unfunded_ccf) {
		this.r3_unfunded_ccf = r3_unfunded_ccf;
	}
	public BigDecimal getR3_unused_unfunded_ccf() {
		return r3_unused_unfunded_ccf;
	}
	public void setR3_unused_unfunded_ccf(BigDecimal r3_unused_unfunded_ccf) {
		this.r3_unused_unfunded_ccf = r3_unused_unfunded_ccf;
	}
	public BigDecimal getR3_total_exposure_ccf() {
		return r3_total_exposure_ccf;
	}
	public void setR3_total_exposure_ccf(BigDecimal r3_total_exposure_ccf) {
		this.r3_total_exposure_ccf = r3_total_exposure_ccf;
	}
	public BigDecimal getR3_tier_capital() {
		return r3_tier_capital;
	}
	public void setR3_tier_capital(BigDecimal r3_tier_capital) {
		this.r3_tier_capital = r3_tier_capital;
	}
	public String getR3_credit_risk_type() {
		return r3_credit_risk_type;
	}
	public void setR3_credit_risk_type(String r3_credit_risk_type) {
		this.r3_credit_risk_type = r3_credit_risk_type;
	}
	public BigDecimal getR3_credit_cut() {
		return r3_credit_cut;
	}
	public void setR3_credit_cut(BigDecimal r3_credit_cut) {
		this.r3_credit_cut = r3_credit_cut;
	}
	public BigDecimal getR3_collateral_cut() {
		return r3_collateral_cut;
	}
	public void setR3_collateral_cut(BigDecimal r3_collateral_cut) {
		this.r3_collateral_cut = r3_collateral_cut;
	}
	public String getR3_cbuae() {
		return r3_cbuae;
	}
	public void setR3_cbuae(String r3_cbuae) {
		this.r3_cbuae = r3_cbuae;
	}
	public BigDecimal getR3_provision() {
		return r3_provision;
	}
	public void setR3_provision(BigDecimal r3_provision) {
		this.r3_provision = r3_provision;
	}
	public String getR3_remarks() {
		return r3_remarks;
	}
	public void setR3_remarks(String r3_remarks) {
		this.r3_remarks = r3_remarks;
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
	public BRF79_ENTITY() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}