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
@Table(name="BRF83_SUMMARYTABLE")
public class BRF83_ENTITY {
	private String	exposure;
	private Date	from_date;
	private Date	to_date;
	private BigDecimal	fund_os;
	private BigDecimal	debt_securities;
	private BigDecimal	unfund_os;
	private BigDecimal	unfund_ccf;
	private BigDecimal	unused_unfund_ccf;
	private BigDecimal	total_exposure_ccf;
	private BigDecimal	tier1_capital;
	private String	risk_type;
	private BigDecimal	risk_haircut;
	private BigDecimal	collateral;
	private String	cbuae;
	private BigDecimal	provision;
	private BigDecimal	total_exposure_reporting;
	private String	remarks;
	private BigDecimal	capital_case;
	private BigDecimal	entity_level;
	@Id
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd-MM-yyyy")

	private Date	report_date;
	private Date	report_from_date;
	private Date	report_to_date;
	private String	entity_flg;
	private String	modify_flg;
	private String	del_flg;
	private String	report_code;
	private Date	report_submit_date;
	private String	row_label;
	private String	repdesc;
	private String	frequency;
	public String getExposure() {
		return exposure;
	}
	public void setExposure(String exposure) {
		this.exposure = exposure;
	}
	public Date getFrom_date() {
		return from_date;
	}
	public void setFrom_date(Date from_date) {
		this.from_date = from_date;
	}
	public Date getTo_date() {
		return to_date;
	}
	public void setTo_date(Date to_date) {
		this.to_date = to_date;
	}
	public BigDecimal getFund_os() {
		return fund_os;
	}
	public void setFund_os(BigDecimal fund_os) {
		this.fund_os = fund_os;
	}
	public BigDecimal getDebt_securities() {
		return debt_securities;
	}
	public void setDebt_securities(BigDecimal debt_securities) {
		this.debt_securities = debt_securities;
	}
	public BigDecimal getUnfund_os() {
		return unfund_os;
	}
	public void setUnfund_os(BigDecimal unfund_os) {
		this.unfund_os = unfund_os;
	}
	public BigDecimal getUnfund_ccf() {
		return unfund_ccf;
	}
	public void setUnfund_ccf(BigDecimal unfund_ccf) {
		this.unfund_ccf = unfund_ccf;
	}
	public BigDecimal getUnused_unfund_ccf() {
		return unused_unfund_ccf;
	}
	public void setUnused_unfund_ccf(BigDecimal unused_unfund_ccf) {
		this.unused_unfund_ccf = unused_unfund_ccf;
	}
	public BigDecimal getTotal_exposure_ccf() {
		return total_exposure_ccf;
	}
	public void setTotal_exposure_ccf(BigDecimal total_exposure_ccf) {
		this.total_exposure_ccf = total_exposure_ccf;
	}
	public BigDecimal getTier1_capital() {
		return tier1_capital;
	}
	public void setTier1_capital(BigDecimal tier1_capital) {
		this.tier1_capital = tier1_capital;
	}
	public String getRisk_type() {
		return risk_type;
	}
	public void setRisk_type(String risk_type) {
		this.risk_type = risk_type;
	}
	public BigDecimal getRisk_haircut() {
		return risk_haircut;
	}
	public void setRisk_haircut(BigDecimal risk_haircut) {
		this.risk_haircut = risk_haircut;
	}
	public BigDecimal getCollateral() {
		return collateral;
	}
	public void setCollateral(BigDecimal collateral) {
		this.collateral = collateral;
	}
	public String getCbuae() {
		return cbuae;
	}
	public void setCbuae(String cbuae) {
		this.cbuae = cbuae;
	}
	public BigDecimal getProvision() {
		return provision;
	}
	public void setProvision(BigDecimal provision) {
		this.provision = provision;
	}
	public BigDecimal getTotal_exposure_reporting() {
		return total_exposure_reporting;
	}
	public void setTotal_exposure_reporting(BigDecimal total_exposure_reporting) {
		this.total_exposure_reporting = total_exposure_reporting;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public BigDecimal getCapital_case() {
		return capital_case;
	}
	public void setCapital_case(BigDecimal capital_case) {
		this.capital_case = capital_case;
	}
	public BigDecimal getEntity_level() {
		return entity_level;
	}
	public void setEntity_level(BigDecimal entity_level) {
		this.entity_level = entity_level;
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
	public String getRow_label() {
		return row_label;
	}
	public void setRow_label(String row_label) {
		this.row_label = row_label;
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
	public BRF83_ENTITY() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}