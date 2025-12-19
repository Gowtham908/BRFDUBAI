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
@Table(name = "MR6")
public class BASEL_EUQTITYMR6_Entity { 
	private String r11_product;
	private BigDecimal r11_euquityposition_long;
	private BigDecimal r11_euquityposition_short;
	private BigDecimal r11_euquityderivatives_long;
	private BigDecimal r11_euquityderivatives_short;
	private BigDecimal r11_deltaposition_long;
	private BigDecimal r11_deltaposition_short;
	private BigDecimal r11_netposition_long;
	private BigDecimal r11_netposition_short;
	private BigDecimal r11_net_to_capital;
	private BigDecimal r11_risk_capital;
	private BigDecimal r11_capital_require;
	private String r13_product;
	private BigDecimal r13_euquityposition_long;
	private BigDecimal r13_euquityposition_short;
	private BigDecimal r13_euquityderivatives_long;
	private BigDecimal r13_euquityderivatives_short;
	private BigDecimal r13_deltaposition_long;
	private BigDecimal r13_deltaposition_short;
	private BigDecimal r13_netposition_long;
	private BigDecimal r13_netposition_short;
	private BigDecimal r13_net_to_capital;
	private BigDecimal r13_risk_capital;
	private BigDecimal r13_capital_require;
	private BigDecimal r14_capital_require;
	private String r15_product;
	private BigDecimal r15_capital_require;
	private String r17_product;
	private BigDecimal r17_capital_require;
	@Id
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date report_date;
	private Date report_from_date;
	private Date report_to_date;
	private String entity_flg;
	private String modify_flg;
	private String del_flg;
	private String report_code;
	private Date report_submit_date;
	private String bank_name;
	private String reporting_date;

	public String getR11_product() {
		return r11_product;
	}

	public void setR11_product(String r11_product) {
		this.r11_product = r11_product;
	}

	public BigDecimal getR11_euquityposition_long() {
		return r11_euquityposition_long;
	}

	public void setR11_euquityposition_long(BigDecimal r11_euquityposition_long) {
		this.r11_euquityposition_long = r11_euquityposition_long;
	}

	public BigDecimal getR11_euquityposition_short() {
		return r11_euquityposition_short;
	}

	public void setR11_euquityposition_short(BigDecimal r11_euquityposition_short) {
		this.r11_euquityposition_short = r11_euquityposition_short;
	}

	public BigDecimal getR11_euquityderivatives_long() {
		return r11_euquityderivatives_long;
	}

	public void setR11_euquityderivatives_long(BigDecimal r11_euquityderivatives_long) {
		this.r11_euquityderivatives_long = r11_euquityderivatives_long;
	}

	public BigDecimal getR11_euquityderivatives_short() {
		return r11_euquityderivatives_short;
	}

	public void setR11_euquityderivatives_short(BigDecimal r11_euquityderivatives_short) {
		this.r11_euquityderivatives_short = r11_euquityderivatives_short;
	}

	public BigDecimal getR11_deltaposition_long() {
		return r11_deltaposition_long;
	}

	public void setR11_deltaposition_long(BigDecimal r11_deltaposition_long) {
		this.r11_deltaposition_long = r11_deltaposition_long;
	}

	public BigDecimal getR11_deltaposition_short() {
		return r11_deltaposition_short;
	}

	public void setR11_deltaposition_short(BigDecimal r11_deltaposition_short) {
		this.r11_deltaposition_short = r11_deltaposition_short;
	}

	public BigDecimal getR11_netposition_long() {
		return r11_netposition_long;
	}

	public void setR11_netposition_long(BigDecimal r11_netposition_long) {
		this.r11_netposition_long = r11_netposition_long;
	}

	public BigDecimal getR11_netposition_short() {
		return r11_netposition_short;
	}

	public void setR11_netposition_short(BigDecimal r11_netposition_short) {
		this.r11_netposition_short = r11_netposition_short;
	}

	public BigDecimal getR11_net_to_capital() {
		return r11_net_to_capital;
	}

	public void setR11_net_to_capital(BigDecimal r11_net_to_capital) {
		this.r11_net_to_capital = r11_net_to_capital;
	}

	public BigDecimal getR11_risk_capital() {
		return r11_risk_capital;
	}

	public void setR11_risk_capital(BigDecimal r11_risk_capital) {
		this.r11_risk_capital = r11_risk_capital;
	}

	public BigDecimal getR11_capital_require() {
		return r11_capital_require;
	}

	public void setR11_capital_require(BigDecimal r11_capital_require) {
		this.r11_capital_require = r11_capital_require;
	}

	public String getR13_product() {
		return r13_product;
	}

	public void setR13_product(String r13_product) {
		this.r13_product = r13_product;
	}

	public BigDecimal getR13_euquityposition_long() {
		return r13_euquityposition_long;
	}

	public void setR13_euquityposition_long(BigDecimal r13_euquityposition_long) {
		this.r13_euquityposition_long = r13_euquityposition_long;
	}

	public BigDecimal getR13_euquityposition_short() {
		return r13_euquityposition_short;
	}

	public void setR13_euquityposition_short(BigDecimal r13_euquityposition_short) {
		this.r13_euquityposition_short = r13_euquityposition_short;
	}

	public BigDecimal getR13_euquityderivatives_long() {
		return r13_euquityderivatives_long;
	}

	public void setR13_euquityderivatives_long(BigDecimal r13_euquityderivatives_long) {
		this.r13_euquityderivatives_long = r13_euquityderivatives_long;
	}

	public BigDecimal getR13_euquityderivatives_short() {
		return r13_euquityderivatives_short;
	}

	public void setR13_euquityderivatives_short(BigDecimal r13_euquityderivatives_short) {
		this.r13_euquityderivatives_short = r13_euquityderivatives_short;
	}

	public BigDecimal getR13_deltaposition_long() {
		return r13_deltaposition_long;
	}

	public void setR13_deltaposition_long(BigDecimal r13_deltaposition_long) {
		this.r13_deltaposition_long = r13_deltaposition_long;
	}

	public BigDecimal getR13_deltaposition_short() {
		return r13_deltaposition_short;
	}

	public void setR13_deltaposition_short(BigDecimal r13_deltaposition_short) {
		this.r13_deltaposition_short = r13_deltaposition_short;
	}

	public BigDecimal getR13_netposition_long() {
		return r13_netposition_long;
	}

	public void setR13_netposition_long(BigDecimal r13_netposition_long) {
		this.r13_netposition_long = r13_netposition_long;
	}

	public BigDecimal getR13_netposition_short() {
		return r13_netposition_short;
	}

	public void setR13_netposition_short(BigDecimal r13_netposition_short) {
		this.r13_netposition_short = r13_netposition_short;
	}

	public BigDecimal getR13_net_to_capital() {
		return r13_net_to_capital;
	}

	public void setR13_net_to_capital(BigDecimal r13_net_to_capital) {
		this.r13_net_to_capital = r13_net_to_capital;
	}

	public BigDecimal getR13_risk_capital() {
		return r13_risk_capital;
	}

	public void setR13_risk_capital(BigDecimal r13_risk_capital) {
		this.r13_risk_capital = r13_risk_capital;
	}

	public BigDecimal getR13_capital_require() {
		return r13_capital_require;
	}

	public void setR13_capital_require(BigDecimal r13_capital_require) {
		this.r13_capital_require = r13_capital_require;
	}

	public BigDecimal getR14_capital_require() {
		return r14_capital_require;
	}

	public void setR14_capital_require(BigDecimal r14_capital_require) {
		this.r14_capital_require = r14_capital_require;
	}

	public String getR15_product() {
		return r15_product;
	}

	public void setR15_product(String r15_product) {
		this.r15_product = r15_product;
	}

	public BigDecimal getR15_capital_require() {
		return r15_capital_require;
	}

	public void setR15_capital_require(BigDecimal r15_capital_require) {
		this.r15_capital_require = r15_capital_require;
	}

	public String getR17_product() {
		return r17_product;
	}

	public void setR17_product(String r17_product) {
		this.r17_product = r17_product;
	}

	public BigDecimal getR17_capital_require() {
		return r17_capital_require;
	}

	public void setR17_capital_require(BigDecimal r17_capital_require) {
		this.r17_capital_require = r17_capital_require;
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

	public String getBank_name() {
		return bank_name;
	}

	public void setBank_name(String bank_name) {
		this.bank_name = bank_name;
	}

	public String getReporting_date() {
		return reporting_date;
	}

	public void setReporting_date(String reporting_date) {
		this.reporting_date = reporting_date;
	}

	public BASEL_EUQTITYMR6_Entity(String r11_product, BigDecimal r11_euquityposition_long,
			BigDecimal r11_euquityposition_short, BigDecimal r11_euquityderivatives_long,
			BigDecimal r11_euquityderivatives_short, BigDecimal r11_deltaposition_long,
			BigDecimal r11_deltaposition_short, BigDecimal r11_netposition_long, BigDecimal r11_netposition_short,
			BigDecimal r11_net_to_capital, BigDecimal r11_risk_capital, BigDecimal r11_capital_require,
			String r13_product, BigDecimal r13_euquityposition_long, BigDecimal r13_euquityposition_short,
			BigDecimal r13_euquityderivatives_long, BigDecimal r13_euquityderivatives_short,
			BigDecimal r13_deltaposition_long, BigDecimal r13_deltaposition_short, BigDecimal r13_netposition_long,
			BigDecimal r13_netposition_short, BigDecimal r13_net_to_capital, BigDecimal r13_risk_capital,
			BigDecimal r13_capital_require, BigDecimal r14_capital_require, String r15_product,
			BigDecimal r15_capital_require, String r17_product, BigDecimal r17_capital_require, Date report_date,
			Date report_from_date, Date report_to_date, String entity_flg, String modify_flg, String del_flg,
			String report_code, Date report_submit_date, String bank_name, String reporting_date) {
		super();
		this.r11_product = r11_product;
		this.r11_euquityposition_long = r11_euquityposition_long;
		this.r11_euquityposition_short = r11_euquityposition_short;
		this.r11_euquityderivatives_long = r11_euquityderivatives_long;
		this.r11_euquityderivatives_short = r11_euquityderivatives_short;
		this.r11_deltaposition_long = r11_deltaposition_long;
		this.r11_deltaposition_short = r11_deltaposition_short;
		this.r11_netposition_long = r11_netposition_long;
		this.r11_netposition_short = r11_netposition_short;
		this.r11_net_to_capital = r11_net_to_capital;
		this.r11_risk_capital = r11_risk_capital;
		this.r11_capital_require = r11_capital_require;
		this.r13_product = r13_product;
		this.r13_euquityposition_long = r13_euquityposition_long;
		this.r13_euquityposition_short = r13_euquityposition_short;
		this.r13_euquityderivatives_long = r13_euquityderivatives_long;
		this.r13_euquityderivatives_short = r13_euquityderivatives_short;
		this.r13_deltaposition_long = r13_deltaposition_long;
		this.r13_deltaposition_short = r13_deltaposition_short;
		this.r13_netposition_long = r13_netposition_long;
		this.r13_netposition_short = r13_netposition_short;
		this.r13_net_to_capital = r13_net_to_capital;
		this.r13_risk_capital = r13_risk_capital;
		this.r13_capital_require = r13_capital_require;
		this.r14_capital_require = r14_capital_require;
		this.r15_product = r15_product;
		this.r15_capital_require = r15_capital_require;
		this.r17_product = r17_product;
		this.r17_capital_require = r17_capital_require;
		this.report_date = report_date;
		this.report_from_date = report_from_date;
		this.report_to_date = report_to_date;
		this.entity_flg = entity_flg;
		this.modify_flg = modify_flg;
		this.del_flg = del_flg;
		this.report_code = report_code;
		this.report_submit_date = report_submit_date;
		this.bank_name = bank_name;
		this.reporting_date = reporting_date;
	}

	public BASEL_EUQTITYMR6_Entity() {
		super();
		// TODO Auto-generated constructor stub
	}

}
