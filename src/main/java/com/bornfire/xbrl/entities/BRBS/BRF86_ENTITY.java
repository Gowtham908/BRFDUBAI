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
@Table(name = "BRF86_SUMMARYTABLE")
public class BRF86_ENTITY {
	private BigDecimal capital_case;
	private String r1_product;
	private String r1_cin_figi_gleiid;
	private String r1_borrower_type;
	private String r1_currency;
	private BigDecimal r1_funded_os;
	private BigDecimal r1_unfunded_os;
	private BigDecimal r1_ccf_unfunded_os;
	private BigDecimal r1_ccf_unused_unfunded;
	private BigDecimal r1_total_exposure_ccf;
	private BigDecimal r1_tier_capital;
	private String r1_credit_risk_type;
	private BigDecimal r1_credit_cut;
	private BigDecimal r1_collateral_cut;
	private String r1_cbuae;
	private BigDecimal r1_provision;
	private String r1_remarks;
	private String r2_product;
	private String r2_cin_figi_gleiid;
	private String r2_borrower_type;
	private String r2_currency;
	private BigDecimal r2_funded_os;
	private BigDecimal r2_unfunded_os;
	private BigDecimal r2_ccf_unfunded_os;
	private BigDecimal r2_ccf_unused_unfunded;
	private BigDecimal r2_total_exposure_ccf;
	private BigDecimal r2_tier_capital;
	private String r2_credit_risk_type;
	private BigDecimal r2_credit_cut;
	private BigDecimal r2_collateral_cut;
	private String r2_cbuae;
	private BigDecimal r2_provision;
	private String r2_remarks;
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
	private String repdesc;
	private String frequency;

	public BigDecimal getCapital_case() {
		return capital_case;
	}

	public String getR1_product() {
		return r1_product;
	}

	public String getR1_cin_figi_gleiid() {
		return r1_cin_figi_gleiid;
	}

	public String getR1_borrower_type() {
		return r1_borrower_type;
	}

	public String getR1_currency() {
		return r1_currency;
	}

	public BigDecimal getR1_funded_os() {
		return r1_funded_os;
	}

	public BigDecimal getR1_unfunded_os() {
		return r1_unfunded_os;
	}

	public BigDecimal getR1_ccf_unfunded_os() {
		return r1_ccf_unfunded_os;
	}

	public BigDecimal getR1_ccf_unused_unfunded() {
		return r1_ccf_unused_unfunded;
	}

	public BigDecimal getR1_total_exposure_ccf() {
		return r1_total_exposure_ccf;
	}

	public BigDecimal getR1_tier_capital() {
		return r1_tier_capital;
	}

	public String getR1_credit_risk_type() {
		return r1_credit_risk_type;
	}

	public BigDecimal getR1_credit_cut() {
		return r1_credit_cut;
	}

	public BigDecimal getR1_collateral_cut() {
		return r1_collateral_cut;
	}

	public String getR1_cbuae() {
		return r1_cbuae;
	}

	public BigDecimal getR1_provision() {
		return r1_provision;
	}

	public String getR1_remarks() {
		return r1_remarks;
	}

	public String getR2_product() {
		return r2_product;
	}

	public String getR2_cin_figi_gleiid() {
		return r2_cin_figi_gleiid;
	}

	public String getR2_borrower_type() {
		return r2_borrower_type;
	}

	public String getR2_currency() {
		return r2_currency;
	}

	public BigDecimal getR2_funded_os() {
		return r2_funded_os;
	}

	public BigDecimal getR2_unfunded_os() {
		return r2_unfunded_os;
	}

	public BigDecimal getR2_ccf_unfunded_os() {
		return r2_ccf_unfunded_os;
	}

	public BigDecimal getR2_ccf_unused_unfunded() {
		return r2_ccf_unused_unfunded;
	}

	public BigDecimal getR2_total_exposure_ccf() {
		return r2_total_exposure_ccf;
	}

	public BigDecimal getR2_tier_capital() {
		return r2_tier_capital;
	}

	public String getR2_credit_risk_type() {
		return r2_credit_risk_type;
	}

	public BigDecimal getR2_credit_cut() {
		return r2_credit_cut;
	}

	public BigDecimal getR2_collateral_cut() {
		return r2_collateral_cut;
	}

	public String getR2_cbuae() {
		return r2_cbuae;
	}

	public BigDecimal getR2_provision() {
		return r2_provision;
	}

	public String getR2_remarks() {
		return r2_remarks;
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

	public String getRepdesc() {
		return repdesc;
	}

	public String getFrequency() {
		return frequency;
	}

	public void setCapital_case(BigDecimal capital_case) {
		this.capital_case = capital_case;
	}

	public void setR1_product(String r1_product) {
		this.r1_product = r1_product;
	}

	public void setR1_cin_figi_gleiid(String r1_cin_figi_gleiid) {
		this.r1_cin_figi_gleiid = r1_cin_figi_gleiid;
	}

	public void setR1_borrower_type(String r1_borrower_type) {
		this.r1_borrower_type = r1_borrower_type;
	}

	public void setR1_currency(String r1_currency) {
		this.r1_currency = r1_currency;
	}

	public void setR1_funded_os(BigDecimal r1_funded_os) {
		this.r1_funded_os = r1_funded_os;
	}

	public void setR1_unfunded_os(BigDecimal r1_unfunded_os) {
		this.r1_unfunded_os = r1_unfunded_os;
	}

	public void setR1_ccf_unfunded_os(BigDecimal r1_ccf_unfunded_os) {
		this.r1_ccf_unfunded_os = r1_ccf_unfunded_os;
	}

	public void setR1_ccf_unused_unfunded(BigDecimal r1_ccf_unused_unfunded) {
		this.r1_ccf_unused_unfunded = r1_ccf_unused_unfunded;
	}

	public void setR1_total_exposure_ccf(BigDecimal r1_total_exposure_ccf) {
		this.r1_total_exposure_ccf = r1_total_exposure_ccf;
	}

	public void setR1_tier_capital(BigDecimal r1_tier_capital) {
		this.r1_tier_capital = r1_tier_capital;
	}

	public void setR1_credit_risk_type(String r1_credit_risk_type) {
		this.r1_credit_risk_type = r1_credit_risk_type;
	}

	public void setR1_credit_cut(BigDecimal r1_credit_cut) {
		this.r1_credit_cut = r1_credit_cut;
	}

	public void setR1_collateral_cut(BigDecimal r1_collateral_cut) {
		this.r1_collateral_cut = r1_collateral_cut;
	}

	public void setR1_cbuae(String r1_cbuae) {
		this.r1_cbuae = r1_cbuae;
	}

	public void setR1_provision(BigDecimal r1_provision) {
		this.r1_provision = r1_provision;
	}

	public void setR1_remarks(String r1_remarks) {
		this.r1_remarks = r1_remarks;
	}

	public void setR2_product(String r2_product) {
		this.r2_product = r2_product;
	}

	public void setR2_cin_figi_gleiid(String r2_cin_figi_gleiid) {
		this.r2_cin_figi_gleiid = r2_cin_figi_gleiid;
	}

	public void setR2_borrower_type(String r2_borrower_type) {
		this.r2_borrower_type = r2_borrower_type;
	}

	public void setR2_currency(String r2_currency) {
		this.r2_currency = r2_currency;
	}

	public void setR2_funded_os(BigDecimal r2_funded_os) {
		this.r2_funded_os = r2_funded_os;
	}

	public void setR2_unfunded_os(BigDecimal r2_unfunded_os) {
		this.r2_unfunded_os = r2_unfunded_os;
	}

	public void setR2_ccf_unfunded_os(BigDecimal r2_ccf_unfunded_os) {
		this.r2_ccf_unfunded_os = r2_ccf_unfunded_os;
	}

	public void setR2_ccf_unused_unfunded(BigDecimal r2_ccf_unused_unfunded) {
		this.r2_ccf_unused_unfunded = r2_ccf_unused_unfunded;
	}

	public void setR2_total_exposure_ccf(BigDecimal r2_total_exposure_ccf) {
		this.r2_total_exposure_ccf = r2_total_exposure_ccf;
	}

	public void setR2_tier_capital(BigDecimal r2_tier_capital) {
		this.r2_tier_capital = r2_tier_capital;
	}

	public void setR2_credit_risk_type(String r2_credit_risk_type) {
		this.r2_credit_risk_type = r2_credit_risk_type;
	}

	public void setR2_credit_cut(BigDecimal r2_credit_cut) {
		this.r2_credit_cut = r2_credit_cut;
	}

	public void setR2_collateral_cut(BigDecimal r2_collateral_cut) {
		this.r2_collateral_cut = r2_collateral_cut;
	}

	public void setR2_cbuae(String r2_cbuae) {
		this.r2_cbuae = r2_cbuae;
	}

	public void setR2_provision(BigDecimal r2_provision) {
		this.r2_provision = r2_provision;
	}

	public void setR2_remarks(String r2_remarks) {
		this.r2_remarks = r2_remarks;
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

	public void setRepdesc(String repdesc) {
		this.repdesc = repdesc;
	}

	public void setFrequency(String frequency) {
		this.frequency = frequency;
	}

	public BRF86_ENTITY(BigDecimal capital_case, String r1_product, String r1_cin_figi_gleiid, String r1_borrower_type,
			String r1_currency, BigDecimal r1_funded_os, BigDecimal r1_unfunded_os, BigDecimal r1_ccf_unfunded_os,
			BigDecimal r1_ccf_unused_unfunded, BigDecimal r1_total_exposure_ccf, BigDecimal r1_tier_capital,
			String r1_credit_risk_type, BigDecimal r1_credit_cut, BigDecimal r1_collateral_cut, String r1_cbuae,
			BigDecimal r1_provision, String r1_remarks, String r2_product, String r2_cin_figi_gleiid,
			String r2_borrower_type, String r2_currency, BigDecimal r2_funded_os, BigDecimal r2_unfunded_os,
			BigDecimal r2_ccf_unfunded_os, BigDecimal r2_ccf_unused_unfunded, BigDecimal r2_total_exposure_ccf,
			BigDecimal r2_tier_capital, String r2_credit_risk_type, BigDecimal r2_credit_cut,
			BigDecimal r2_collateral_cut, String r2_cbuae, BigDecimal r2_provision, String r2_remarks, Date report_date,
			Date report_from_date, Date report_to_date, String entity_flg, String modify_flg, String del_flg,
			String report_code, String repdesc, String frequency) {
		super();
		this.capital_case = capital_case;
		this.r1_product = r1_product;
		this.r1_cin_figi_gleiid = r1_cin_figi_gleiid;
		this.r1_borrower_type = r1_borrower_type;
		this.r1_currency = r1_currency;
		this.r1_funded_os = r1_funded_os;
		this.r1_unfunded_os = r1_unfunded_os;
		this.r1_ccf_unfunded_os = r1_ccf_unfunded_os;
		this.r1_ccf_unused_unfunded = r1_ccf_unused_unfunded;
		this.r1_total_exposure_ccf = r1_total_exposure_ccf;
		this.r1_tier_capital = r1_tier_capital;
		this.r1_credit_risk_type = r1_credit_risk_type;
		this.r1_credit_cut = r1_credit_cut;
		this.r1_collateral_cut = r1_collateral_cut;
		this.r1_cbuae = r1_cbuae;
		this.r1_provision = r1_provision;
		this.r1_remarks = r1_remarks;
		this.r2_product = r2_product;
		this.r2_cin_figi_gleiid = r2_cin_figi_gleiid;
		this.r2_borrower_type = r2_borrower_type;
		this.r2_currency = r2_currency;
		this.r2_funded_os = r2_funded_os;
		this.r2_unfunded_os = r2_unfunded_os;
		this.r2_ccf_unfunded_os = r2_ccf_unfunded_os;
		this.r2_ccf_unused_unfunded = r2_ccf_unused_unfunded;
		this.r2_total_exposure_ccf = r2_total_exposure_ccf;
		this.r2_tier_capital = r2_tier_capital;
		this.r2_credit_risk_type = r2_credit_risk_type;
		this.r2_credit_cut = r2_credit_cut;
		this.r2_collateral_cut = r2_collateral_cut;
		this.r2_cbuae = r2_cbuae;
		this.r2_provision = r2_provision;
		this.r2_remarks = r2_remarks;
		this.report_date = report_date;
		this.report_from_date = report_from_date;
		this.report_to_date = report_to_date;
		this.entity_flg = entity_flg;
		this.modify_flg = modify_flg;
		this.del_flg = del_flg;
		this.report_code = report_code;
		this.repdesc = repdesc;
		this.frequency = frequency;
	}

	public BRF86_ENTITY() {
		super();
		// TODO Auto-generated constructor stub
	}
}
