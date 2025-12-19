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
@Table(name = "BRF85_SUMMARYTABLE")
public class BRF85_ENTITY {
	private BigDecimal capital_case;
	private BigDecimal aggregate_limit;
	private String r1_name_group;
	private String r1_cin_figi;
	private String r1_share_capital;
	private String r1_borrower_type;
	private String r1_currency;
	private BigDecimal r1_fund_os;
	private BigDecimal r1_debt_securities;
	private BigDecimal r1_equities;
	private BigDecimal r1_unfund_os;
	private BigDecimal r1_unfund_ccf;
	private BigDecimal r1_unused_unfund_ccf;
	private BigDecimal r1_total_exposure_ccf;
	private BigDecimal r1_tier1_capital;
	private String r1_risk_type;
	private BigDecimal r1_risk_haircut;
	private BigDecimal r1_collateral;
	private String r1_cbuae;
	private BigDecimal r1_provision;
	private String r1_remarks;
	private String r2_name_group;
	private String r2_cin_figi;
	private String r2_share_capital;
	private String r2_borrower_type;
	private String r2_currency;
	private BigDecimal r2_fund_os;
	private BigDecimal r2_debt_securities;
	private BigDecimal r2_equities;
	private BigDecimal r2_unfund_os;
	private BigDecimal r2_unfund_ccf;
	private BigDecimal r2_unused_unfund_ccf;
	private BigDecimal r2_total_exposure_ccf;
	private BigDecimal r2_tier2_capital;
	private String r2_risk_type;
	private BigDecimal r2_risk_haircut;
	private BigDecimal r2_collateral;
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
	private Date report_submit_date;
	private String repdesc;
	private String frequency;

	public BigDecimal getCapital_case() {
		return capital_case;
	}

	public BigDecimal getAggregate_limit() {
		return aggregate_limit;
	}

	public String getR1_name_group() {
		return r1_name_group;
	}

	public String getR1_cin_figi() {
		return r1_cin_figi;
	}

	public String getR1_share_capital() {
		return r1_share_capital;
	}

	public String getR1_borrower_type() {
		return r1_borrower_type;
	}

	public String getR1_currency() {
		return r1_currency;
	}

	public BigDecimal getR1_fund_os() {
		return r1_fund_os;
	}

	public BigDecimal getR1_debt_securities() {
		return r1_debt_securities;
	}

	public BigDecimal getR1_equities() {
		return r1_equities;
	}

	public BigDecimal getR1_unfund_os() {
		return r1_unfund_os;
	}

	public BigDecimal getR1_unfund_ccf() {
		return r1_unfund_ccf;
	}

	public BigDecimal getR1_unused_unfund_ccf() {
		return r1_unused_unfund_ccf;
	}

	public BigDecimal getR1_total_exposure_ccf() {
		return r1_total_exposure_ccf;
	}

	public BigDecimal getR1_tier1_capital() {
		return r1_tier1_capital;
	}

	public String getR1_risk_type() {
		return r1_risk_type;
	}

	public BigDecimal getR1_risk_haircut() {
		return r1_risk_haircut;
	}

	public BigDecimal getR1_collateral() {
		return r1_collateral;
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

	public String getR2_name_group() {
		return r2_name_group;
	}

	public String getR2_cin_figi() {
		return r2_cin_figi;
	}

	public String getR2_share_capital() {
		return r2_share_capital;
	}

	public String getR2_borrower_type() {
		return r2_borrower_type;
	}

	public String getR2_currency() {
		return r2_currency;
	}

	public BigDecimal getR2_fund_os() {
		return r2_fund_os;
	}

	public BigDecimal getR2_debt_securities() {
		return r2_debt_securities;
	}

	public BigDecimal getR2_equities() {
		return r2_equities;
	}

	public BigDecimal getR2_unfund_os() {
		return r2_unfund_os;
	}

	public BigDecimal getR2_unfund_ccf() {
		return r2_unfund_ccf;
	}

	public BigDecimal getR2_unused_unfund_ccf() {
		return r2_unused_unfund_ccf;
	}

	public BigDecimal getR2_total_exposure_ccf() {
		return r2_total_exposure_ccf;
	}

	public BigDecimal getR2_tier2_capital() {
		return r2_tier2_capital;
	}

	public String getR2_risk_type() {
		return r2_risk_type;
	}

	public BigDecimal getR2_risk_haircut() {
		return r2_risk_haircut;
	}

	public BigDecimal getR2_collateral() {
		return r2_collateral;
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

	public Date getReport_submit_date() {
		return report_submit_date;
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

	public void setAggregate_limit(BigDecimal aggregate_limit) {
		this.aggregate_limit = aggregate_limit;
	}

	public void setR1_name_group(String r1_name_group) {
		this.r1_name_group = r1_name_group;
	}

	public void setR1_cin_figi(String r1_cin_figi) {
		this.r1_cin_figi = r1_cin_figi;
	}

	public void setR1_share_capital(String r1_share_capital) {
		this.r1_share_capital = r1_share_capital;
	}

	public void setR1_borrower_type(String r1_borrower_type) {
		this.r1_borrower_type = r1_borrower_type;
	}

	public void setR1_currency(String r1_currency) {
		this.r1_currency = r1_currency;
	}

	public void setR1_fund_os(BigDecimal r1_fund_os) {
		this.r1_fund_os = r1_fund_os;
	}

	public void setR1_debt_securities(BigDecimal r1_debt_securities) {
		this.r1_debt_securities = r1_debt_securities;
	}

	public void setR1_equities(BigDecimal r1_equities) {
		this.r1_equities = r1_equities;
	}

	public void setR1_unfund_os(BigDecimal r1_unfund_os) {
		this.r1_unfund_os = r1_unfund_os;
	}

	public void setR1_unfund_ccf(BigDecimal r1_unfund_ccf) {
		this.r1_unfund_ccf = r1_unfund_ccf;
	}

	public void setR1_unused_unfund_ccf(BigDecimal r1_unused_unfund_ccf) {
		this.r1_unused_unfund_ccf = r1_unused_unfund_ccf;
	}

	public void setR1_total_exposure_ccf(BigDecimal r1_total_exposure_ccf) {
		this.r1_total_exposure_ccf = r1_total_exposure_ccf;
	}

	public void setR1_tier1_capital(BigDecimal r1_tier1_capital) {
		this.r1_tier1_capital = r1_tier1_capital;
	}

	public void setR1_risk_type(String r1_risk_type) {
		this.r1_risk_type = r1_risk_type;
	}

	public void setR1_risk_haircut(BigDecimal r1_risk_haircut) {
		this.r1_risk_haircut = r1_risk_haircut;
	}

	public void setR1_collateral(BigDecimal r1_collateral) {
		this.r1_collateral = r1_collateral;
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

	public void setR2_name_group(String r2_name_group) {
		this.r2_name_group = r2_name_group;
	}

	public void setR2_cin_figi(String r2_cin_figi) {
		this.r2_cin_figi = r2_cin_figi;
	}

	public void setR2_share_capital(String r2_share_capital) {
		this.r2_share_capital = r2_share_capital;
	}

	public void setR2_borrower_type(String r2_borrower_type) {
		this.r2_borrower_type = r2_borrower_type;
	}

	public void setR2_currency(String r2_currency) {
		this.r2_currency = r2_currency;
	}

	public void setR2_fund_os(BigDecimal r2_fund_os) {
		this.r2_fund_os = r2_fund_os;
	}

	public void setR2_debt_securities(BigDecimal r2_debt_securities) {
		this.r2_debt_securities = r2_debt_securities;
	}

	public void setR2_equities(BigDecimal r2_equities) {
		this.r2_equities = r2_equities;
	}

	public void setR2_unfund_os(BigDecimal r2_unfund_os) {
		this.r2_unfund_os = r2_unfund_os;
	}

	public void setR2_unfund_ccf(BigDecimal r2_unfund_ccf) {
		this.r2_unfund_ccf = r2_unfund_ccf;
	}

	public void setR2_unused_unfund_ccf(BigDecimal r2_unused_unfund_ccf) {
		this.r2_unused_unfund_ccf = r2_unused_unfund_ccf;
	}

	public void setR2_total_exposure_ccf(BigDecimal r2_total_exposure_ccf) {
		this.r2_total_exposure_ccf = r2_total_exposure_ccf;
	}

	public void setR2_tier2_capital(BigDecimal r2_tier2_capital) {
		this.r2_tier2_capital = r2_tier2_capital;
	}

	public void setR2_risk_type(String r2_risk_type) {
		this.r2_risk_type = r2_risk_type;
	}

	public void setR2_risk_haircut(BigDecimal r2_risk_haircut) {
		this.r2_risk_haircut = r2_risk_haircut;
	}

	public void setR2_collateral(BigDecimal r2_collateral) {
		this.r2_collateral = r2_collateral;
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

	public void setReport_submit_date(Date report_submit_date) {
		this.report_submit_date = report_submit_date;
	}

	public void setRepdesc(String repdesc) {
		this.repdesc = repdesc;
	}

	public void setFrequency(String frequency) {
		this.frequency = frequency;
	}

	public BRF85_ENTITY() {
		super();
		// TODO Auto-generated constructor stub
	}
}
