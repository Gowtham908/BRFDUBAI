package com.bornfire.xbrl.entities.BRBS;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "BRF5C_SUMMARYTABLE")
@IdClass(BRF05IDCLASS.class)
public class BRF05_ENTITY3 {
	private String investment_types1;
	private String security_identifier1;
	private BigDecimal units_held1;
	private String country1;
	private String ccy1;
	private BigDecimal amount1;
	private BigDecimal aed_equivalent1;
	private BigDecimal rating1;
	private String rating_type1;
	private BigDecimal market_value1;
	private String counterparty_type1;
	private String security_identifier_validation1;
	private String country_validation1;
	private String rating_validation1;
	private String counterparty_type_validation1;
	private String row_valid1;
	private String row_label1;
	@Id
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date report_date;
	private String report_addl_criteria_11;
	private String nominal1;
	private Date report_submit_date;
	private Date report_from_date;
	private Date report_to_date;
	private String report_code;
	private String entity_flg;
	private String modify_flg;
	private String del_flg;
	private String entry_user;
	private String modify_user;
	private String verify_user;
	private Date entry_time;
	private Date modify_time;
	private Date verify_time;
	@Id
	private BigDecimal srl_no;
	private String repdesc;
	private String frequency;

	public String getInvestment_types1() {
		return investment_types1;
	}

	public void setInvestment_types1(String investment_types1) {
		this.investment_types1 = investment_types1;
	}

	public String getSecurity_identifier1() {
		return security_identifier1;
	}

	public void setSecurity_identifier1(String security_identifier1) {
		this.security_identifier1 = security_identifier1;
	}

	public BigDecimal getUnits_held1() {
		return units_held1;
	}

	public void setUnits_held1(BigDecimal units_held1) {
		this.units_held1 = units_held1;
	}

	public String getCountry1() {
		return country1;
	}

	public void setCountry1(String country1) {
		this.country1 = country1;
	}

	public String getCcy1() {
		return ccy1;
	}

	public void setCcy1(String ccy1) {
		this.ccy1 = ccy1;
	}

	public BigDecimal getAmount1() {
		return amount1;
	}

	public void setAmount1(BigDecimal amount1) {
		this.amount1 = amount1;
	}

	public BigDecimal getAed_equivalent1() {
		return aed_equivalent1;
	}

	public void setAed_equivalent1(BigDecimal aed_equivalent1) {
		this.aed_equivalent1 = aed_equivalent1;
	}

	public BigDecimal getRating1() {
		return rating1;
	}

	public void setRating1(BigDecimal rating1) {
		this.rating1 = rating1;
	}

	public String getRating_type1() {
		return rating_type1;
	}

	public void setRating_type1(String rating_type1) {
		this.rating_type1 = rating_type1;
	}

	public BigDecimal getMarket_value1() {
		return market_value1;
	}

	public void setMarket_value1(BigDecimal market_value1) {
		this.market_value1 = market_value1;
	}

	public String getCounterparty_type1() {
		return counterparty_type1;
	}

	public void setCounterparty_type1(String counterparty_type1) {
		this.counterparty_type1 = counterparty_type1;
	}

	public String getSecurity_identifier_validation1() {
		return security_identifier_validation1;
	}

	public void setSecurity_identifier_validation1(String security_identifier_validation1) {
		this.security_identifier_validation1 = security_identifier_validation1;
	}

	public String getCountry_validation1() {
		return country_validation1;
	}

	public void setCountry_validation1(String country_validation1) {
		this.country_validation1 = country_validation1;
	}

	public String getRating_validation1() {
		return rating_validation1;
	}

	public void setRating_validation1(String rating_validation1) {
		this.rating_validation1 = rating_validation1;
	}

	public String getCounterparty_type_validation1() {
		return counterparty_type_validation1;
	}

	public void setCounterparty_type_validation1(String counterparty_type_validation1) {
		this.counterparty_type_validation1 = counterparty_type_validation1;
	}

	public String getRow_valid1() {
		return row_valid1;
	}

	public void setRow_valid1(String row_valid1) {
		this.row_valid1 = row_valid1;
	}

	public String getRow_label1() {
		return row_label1;
	}

	public void setRow_label1(String row_label1) {
		this.row_label1 = row_label1;
	}

	public Date getReport_date() {
		return report_date;
	}

	public void setReport_date(Date report_date) {
		this.report_date = report_date;
	}

	public String getReport_addl_criteria_11() {
		return report_addl_criteria_11;
	}

	public void setReport_addl_criteria_11(String report_addl_criteria_11) {
		this.report_addl_criteria_11 = report_addl_criteria_11;
	}

	public String getNominal1() {
		return nominal1;
	}

	public void setNominal1(String nominal1) {
		this.nominal1 = nominal1;
	}

	public Date getReport_submit_date() {
		return report_submit_date;
	}

	public void setReport_submit_date(Date report_submit_date) {
		this.report_submit_date = report_submit_date;
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

	public String getReport_code() {
		return report_code;
	}

	public void setReport_code(String report_code) {
		this.report_code = report_code;
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

	public String getEntry_user() {
		return entry_user;
	}

	public void setEntry_user(String entry_user) {
		this.entry_user = entry_user;
	}

	public String getModify_user() {
		return modify_user;
	}

	public void setModify_user(String modify_user) {
		this.modify_user = modify_user;
	}

	public String getVerify_user() {
		return verify_user;
	}

	public void setVerify_user(String verify_user) {
		this.verify_user = verify_user;
	}

	public Date getEntry_time() {
		return entry_time;
	}

	public void setEntry_time(Date entry_time) {
		this.entry_time = entry_time;
	}

	public Date getModify_time() {
		return modify_time;
	}

	public void setModify_time(Date modify_time) {
		this.modify_time = modify_time;
	}

	public Date getVerify_time() {
		return verify_time;
	}

	public void setVerify_time(Date verify_time) {
		this.verify_time = verify_time;
	}

	public BigDecimal getSrl_no() {
		return srl_no;
	}

	public void setSrl_no(BigDecimal srl_no) {
		this.srl_no = srl_no;
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

	public BRF05_ENTITY3(String investment_types1, String security_identifier1, BigDecimal units_held1, String country1,
			String ccy1, BigDecimal amount1, BigDecimal aed_equivalent1, BigDecimal rating1, String rating_type1,
			BigDecimal market_value1, String counterparty_type1, String security_identifier_validation1,
			String country_validation1, String rating_validation1, String counterparty_type_validation1,
			String row_valid1, String row_label1, Date report_date, String report_addl_criteria_11, String nominal1,
			Date report_submit_date, Date report_from_date, Date report_to_date, String report_code, String entity_flg,
			String modify_flg, String del_flg, String entry_user, String modify_user, String verify_user,
			Date entry_time, Date modify_time, Date verify_time, BigDecimal srl_no, String repdesc, String frequency) {
		super();
		this.investment_types1 = investment_types1;
		this.security_identifier1 = security_identifier1;
		this.units_held1 = units_held1;
		this.country1 = country1;
		this.ccy1 = ccy1;
		this.amount1 = amount1;
		this.aed_equivalent1 = aed_equivalent1;
		this.rating1 = rating1;
		this.rating_type1 = rating_type1;
		this.market_value1 = market_value1;
		this.counterparty_type1 = counterparty_type1;
		this.security_identifier_validation1 = security_identifier_validation1;
		this.country_validation1 = country_validation1;
		this.rating_validation1 = rating_validation1;
		this.counterparty_type_validation1 = counterparty_type_validation1;
		this.row_valid1 = row_valid1;
		this.row_label1 = row_label1;
		this.report_date = report_date;
		this.report_addl_criteria_11 = report_addl_criteria_11;
		this.nominal1 = nominal1;
		this.report_submit_date = report_submit_date;
		this.report_from_date = report_from_date;
		this.report_to_date = report_to_date;
		this.report_code = report_code;
		this.entity_flg = entity_flg;
		this.modify_flg = modify_flg;
		this.del_flg = del_flg;
		this.entry_user = entry_user;
		this.modify_user = modify_user;
		this.verify_user = verify_user;
		this.entry_time = entry_time;
		this.modify_time = modify_time;
		this.verify_time = verify_time;
		this.srl_no = srl_no;
		this.repdesc = repdesc;
		this.frequency = frequency;
	}

	public BRF05_ENTITY3() {
		super();
		// TODO Auto-generated constructor stub
	}
}