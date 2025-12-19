package com.bornfire.xbrl.entities.BRBS;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "BRF5B_SUMMARYTABLE")
public class BRF5B_SUMMARY_ENTITY {
	
	
	private BigDecimal	aed_equivalent;
	private BigDecimal	amount;
	private String	ccy;
	private String	counterparty_type;
	private String	counterparty_type_validation;
	private String	country;
	private String	country_validation;
	private String	del_flg;
	private String	entity_flg;
	private Date	entry_time;
	private String	entry_user;
	private String	investment_types;
	private BigDecimal	market_value;
	private String	modify_flg;
	private Date	modify_time;
	private String	modify_user;
	private String	nominal;
	private BigDecimal	rating;
	private String	rating_type;
	private String	rating_validation;
	private String	report_addl_criteria_1;
	private String	report_code;
	
	private Date	report_date;
	private Date	report_from_date;
	private Date	report_submit_date;
	private Date	report_to_date;
	private String	row_label;
	private String	row_valid;
	
	private String	security_identifier;
	private String	security_identifier_validation;
	@Id
	private BigDecimal	srl_no;
	private BigDecimal	units_held;
	private Date	verify_time;
	private String	verify_user;
	public BigDecimal getAed_equivalent() {
		return aed_equivalent;
	}
	public void setAed_equivalent(BigDecimal aed_equivalent) {
		this.aed_equivalent = aed_equivalent;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	public String getCcy() {
		return ccy;
	}
	public void setCcy(String ccy) {
		this.ccy = ccy;
	}
	public String getCounterparty_type() {
		return counterparty_type;
	}
	public void setCounterparty_type(String counterparty_type) {
		this.counterparty_type = counterparty_type;
	}
	public String getCounterparty_type_validation() {
		return counterparty_type_validation;
	}
	public void setCounterparty_type_validation(String counterparty_type_validation) {
		this.counterparty_type_validation = counterparty_type_validation;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getCountry_validation() {
		return country_validation;
	}
	public void setCountry_validation(String country_validation) {
		this.country_validation = country_validation;
	}
	public String getDel_flg() {
		return del_flg;
	}
	public void setDel_flg(String del_flg) {
		this.del_flg = del_flg;
	}
	public String getEntity_flg() {
		return entity_flg;
	}
	public void setEntity_flg(String entity_flg) {
		this.entity_flg = entity_flg;
	}
	public Date getEntry_time() {
		return entry_time;
	}
	public void setEntry_time(Date entry_time) {
		this.entry_time = entry_time;
	}
	public String getEntry_user() {
		return entry_user;
	}
	public void setEntry_user(String entry_user) {
		this.entry_user = entry_user;
	}
	public String getInvestment_types() {
		return investment_types;
	}
	public void setInvestment_types(String investment_types) {
		this.investment_types = investment_types;
	}
	public BigDecimal getMarket_value() {
		return market_value;
	}
	public void setMarket_value(BigDecimal market_value) {
		this.market_value = market_value;
	}
	public String getModify_flg() {
		return modify_flg;
	}
	public void setModify_flg(String modify_flg) {
		this.modify_flg = modify_flg;
	}
	public Date getModify_time() {
		return modify_time;
	}
	public void setModify_time(Date modify_time) {
		this.modify_time = modify_time;
	}
	public String getModify_user() {
		return modify_user;
	}
	public void setModify_user(String modify_user) {
		this.modify_user = modify_user;
	}
	public String getNominal() {
		return nominal;
	}
	public void setNominal(String nominal) {
		this.nominal = nominal;
	}
	public BigDecimal getRating() {
		return rating;
	}
	public void setRating(BigDecimal rating) {
		this.rating = rating;
	}
	public String getRating_type() {
		return rating_type;
	}
	public void setRating_type(String rating_type) {
		this.rating_type = rating_type;
	}
	public String getRating_validation() {
		return rating_validation;
	}
	public void setRating_validation(String rating_validation) {
		this.rating_validation = rating_validation;
	}
	public String getReport_addl_criteria_1() {
		return report_addl_criteria_1;
	}
	public void setReport_addl_criteria_1(String report_addl_criteria_1) {
		this.report_addl_criteria_1 = report_addl_criteria_1;
	}
	public String getReport_code() {
		return report_code;
	}
	public void setReport_code(String report_code) {
		this.report_code = report_code;
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
	public Date getReport_submit_date() {
		return report_submit_date;
	}
	public void setReport_submit_date(Date report_submit_date) {
		this.report_submit_date = report_submit_date;
	}
	public Date getReport_to_date() {
		return report_to_date;
	}
	public void setReport_to_date(Date report_to_date) {
		this.report_to_date = report_to_date;
	}
	public String getRow_label() {
		return row_label;
	}
	public void setRow_label(String row_label) {
		this.row_label = row_label;
	}
	public String getRow_valid() {
		return row_valid;
	}
	public void setRow_valid(String row_valid) {
		this.row_valid = row_valid;
	}
	public String getSecurity_identifier() {
		return security_identifier;
	}
	public void setSecurity_identifier(String security_identifier) {
		this.security_identifier = security_identifier;
	}
	public String getSecurity_identifier_validation() {
		return security_identifier_validation;
	}
	public void setSecurity_identifier_validation(String security_identifier_validation) {
		this.security_identifier_validation = security_identifier_validation;
	}
	public BigDecimal getSrl_no() {
		return srl_no;
	}
	public void setSrl_no(BigDecimal srl_no) {
		this.srl_no = srl_no;
	}
	public BigDecimal getUnits_held() {
		return units_held;
	}
	public void setUnits_held(BigDecimal units_held) {
		this.units_held = units_held;
	}
	public Date getVerify_time() {
		return verify_time;
	}
	public void setVerify_time(Date verify_time) {
		this.verify_time = verify_time;
	}
	public String getVerify_user() {
		return verify_user;
	}
	public void setVerify_user(String verify_user) {
		this.verify_user = verify_user;
	}
	public BRF5B_SUMMARY_ENTITY(BigDecimal aed_equivalent, BigDecimal amount, String ccy, String counterparty_type,
			String counterparty_type_validation, String country, String country_validation, String del_flg,
			String entity_flg, Date entry_time, String entry_user, String investment_types, BigDecimal market_value,
			String modify_flg, Date modify_time, String modify_user, String nominal, BigDecimal rating,
			String rating_type, String rating_validation, String report_addl_criteria_1, String report_code,
			Date report_date, Date report_from_date, Date report_submit_date, Date report_to_date, String row_label,
			String row_valid, String security_identifier, String security_identifier_validation, BigDecimal srl_no,
			BigDecimal units_held, Date verify_time, String verify_user) {
		super();
		this.aed_equivalent = aed_equivalent;
		this.amount = amount;
		this.ccy = ccy;
		this.counterparty_type = counterparty_type;
		this.counterparty_type_validation = counterparty_type_validation;
		this.country = country;
		this.country_validation = country_validation;
		this.del_flg = del_flg;
		this.entity_flg = entity_flg;
		this.entry_time = entry_time;
		this.entry_user = entry_user;
		this.investment_types = investment_types;
		this.market_value = market_value;
		this.modify_flg = modify_flg;
		this.modify_time = modify_time;
		this.modify_user = modify_user;
		this.nominal = nominal;
		this.rating = rating;
		this.rating_type = rating_type;
		this.rating_validation = rating_validation;
		this.report_addl_criteria_1 = report_addl_criteria_1;
		this.report_code = report_code;
		this.report_date = report_date;
		this.report_from_date = report_from_date;
		this.report_submit_date = report_submit_date;
		this.report_to_date = report_to_date;
		this.row_label = row_label;
		this.row_valid = row_valid;
		this.security_identifier = security_identifier;
		this.security_identifier_validation = security_identifier_validation;
		this.srl_no = srl_no;
		this.units_held = units_held;
		this.verify_time = verify_time;
		this.verify_user = verify_user;
	}
	@Override
	public String toString() {
		return "BRF5B_SUMMARY_ENTITY [aed_equivalent=" + aed_equivalent + ", amount=" + amount + ", ccy=" + ccy
				+ ", counterparty_type=" + counterparty_type + ", counterparty_type_validation="
				+ counterparty_type_validation + ", country=" + country + ", country_validation=" + country_validation
				+ ", del_flg=" + del_flg + ", entity_flg=" + entity_flg + ", entry_time=" + entry_time + ", entry_user="
				+ entry_user + ", investment_types=" + investment_types + ", market_value=" + market_value
				+ ", modify_flg=" + modify_flg + ", modify_time=" + modify_time + ", modify_user=" + modify_user
				+ ", nominal=" + nominal + ", rating=" + rating + ", rating_type=" + rating_type
				+ ", rating_validation=" + rating_validation + ", report_addl_criteria_1=" + report_addl_criteria_1
				+ ", report_code=" + report_code + ", report_date=" + report_date + ", report_from_date="
				+ report_from_date + ", report_submit_date=" + report_submit_date + ", report_to_date=" + report_to_date
				+ ", row_label=" + row_label + ", row_valid=" + row_valid + ", security_identifier="
				+ security_identifier + ", security_identifier_validation=" + security_identifier_validation
				+ ", srl_no=" + srl_no + ", units_held=" + units_held + ", verify_time=" + verify_time
				+ ", verify_user=" + verify_user + "]";
	}
	public BRF5B_SUMMARY_ENTITY() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	


}

