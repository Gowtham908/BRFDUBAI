package com.bornfire.xbrl.entities.BRBS;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "BRF154_SUMMARYTABLE")
public class BRF154_ENTITY {
	private String cin_num;
	private String legal_entity_identifier;
	private String customer_name;
	private String counter_party;
	private String country;
	private String ccy1;
	private BigDecimal os_funded;
	private String ccy2;
	private BigDecimal os_unfunded;
	private String ccy3;
	private BigDecimal amount;
	private String type_of_collaterals;
	@Id
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Column(name = "REPORT_DATE")
	private Date report_date;
	private Date report_from_date;
	private Date report_to_date;
	private String entity_flg;
	private String modify_flg;
	private String del_flg;
	private String report_code;
	private Date report_submit_date;
	private String row_label;
	private String row_criteria;
	private String repdesc;
	@Column(name = "FREQUENCY")
	private String frequency;

	public String getCin_num() {
		return cin_num;
	}

	public void setCin_num(String cin_num) {
		this.cin_num = cin_num;
	}

	public String getLegal_entity_identifier() {
		return legal_entity_identifier;
	}

	public void setLegal_entity_identifier(String legal_entity_identifier) {
		this.legal_entity_identifier = legal_entity_identifier;
	}

	public String getCustomer_name() {
		return customer_name;
	}

	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}

	public String getCounter_party() {
		return counter_party;
	}

	public void setCounter_party(String counter_party) {
		this.counter_party = counter_party;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCcy1() {
		return ccy1;
	}

	public void setCcy1(String ccy1) {
		this.ccy1 = ccy1;
	}

	public BigDecimal getOs_funded() {
		return os_funded;
	}

	public void setOs_funded(BigDecimal os_funded) {
		this.os_funded = os_funded;
	}

	public String getCcy2() {
		return ccy2;
	}

	public void setCcy2(String ccy2) {
		this.ccy2 = ccy2;
	}

	public BigDecimal getOs_unfunded() {
		return os_unfunded;
	}

	public void setOs_unfunded(BigDecimal os_unfunded) {
		this.os_unfunded = os_unfunded;
	}

	public String getCcy3() {
		return ccy3;
	}

	public void setCcy3(String ccy3) {
		this.ccy3 = ccy3;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public String getType_of_collaterals() {
		return type_of_collaterals;
	}

	public void setType_of_collaterals(String type_of_collaterals) {
		this.type_of_collaterals = type_of_collaterals;
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

	public String getRow_criteria() {
		return row_criteria;
	}

	public void setRow_criteria(String row_criteria) {
		this.row_criteria = row_criteria;
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

	@Override
	public String toString() {
		return "BRF154_ENTITY [cin_num=" + cin_num + ", legal_entity_identifier=" + legal_entity_identifier
				+ ", customer_name=" + customer_name + ", counter_party=" + counter_party + ", country=" + country
				+ ", ccy1=" + ccy1 + ", os_funded=" + os_funded + ", ccy2=" + ccy2 + ", os_unfunded=" + os_unfunded
				+ ", ccy3=" + ccy3 + ", amount=" + amount + ", type_of_collaterals=" + type_of_collaterals
				+ ", report_date=" + report_date + ", report_from_date=" + report_from_date + ", report_to_date="
				+ report_to_date + ", entity_flg=" + entity_flg + ", modify_flg=" + modify_flg + ", del_flg=" + del_flg
				+ ", report_code=" + report_code + ", report_submit_date=" + report_submit_date + ", row_label="
				+ row_label + ", row_criteria=" + row_criteria + ", repdesc=" + repdesc + ", frequency=" + frequency
				+ ", getCin_num()=" + getCin_num() + ", getLegal_entity_identifier()=" + getLegal_entity_identifier()
				+ ", getCustomer_name()=" + getCustomer_name() + ", getCounter_party()=" + getCounter_party()
				+ ", getCountry()=" + getCountry() + ", getCcy1()=" + getCcy1() + ", getOs_funded()=" + getOs_funded()
				+ ", getCcy2()=" + getCcy2() + ", getOs_unfunded()=" + getOs_unfunded() + ", getCcy3()=" + getCcy3()
				+ ", getAmount()=" + getAmount() + ", getType_of_collaterals()=" + getType_of_collaterals()
				+ ", getReport_date()=" + getReport_date() + ", getReport_from_date()=" + getReport_from_date()
				+ ", getReport_to_date()=" + getReport_to_date() + ", getEntity_flg()=" + getEntity_flg()
				+ ", getModify_flg()=" + getModify_flg() + ", getDel_flg()=" + getDel_flg() + ", getReport_code()="
				+ getReport_code() + ", getReport_submit_date()=" + getReport_submit_date() + ", getRow_label()="
				+ getRow_label() + ", getRow_criteria()=" + getRow_criteria() + ", getRepdesc()=" + getRepdesc()
				+ ", getFrequency()=" + getFrequency() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}

	public BRF154_ENTITY(String cin_num, String legal_entity_identifier, String customer_name, String counter_party,
			String country, String ccy1, BigDecimal os_funded, String ccy2, BigDecimal os_unfunded, String ccy3,
			BigDecimal amount, String type_of_collaterals, Date report_date, Date report_from_date, Date report_to_date,
			String entity_flg, String modify_flg, String del_flg, String report_code, Date report_submit_date,
			String row_label, String row_criteria, String repdesc, String frequency) {
		super();
		this.cin_num = cin_num;
		this.legal_entity_identifier = legal_entity_identifier;
		this.customer_name = customer_name;
		this.counter_party = counter_party;
		this.country = country;
		this.ccy1 = ccy1;
		this.os_funded = os_funded;
		this.ccy2 = ccy2;
		this.os_unfunded = os_unfunded;
		this.ccy3 = ccy3;
		this.amount = amount;
		this.type_of_collaterals = type_of_collaterals;
		this.report_date = report_date;
		this.report_from_date = report_from_date;
		this.report_to_date = report_to_date;
		this.entity_flg = entity_flg;
		this.modify_flg = modify_flg;
		this.del_flg = del_flg;
		this.report_code = report_code;
		this.report_submit_date = report_submit_date;
		this.row_label = row_label;
		this.row_criteria = row_criteria;
		this.repdesc = repdesc;
		this.frequency = frequency;
	}

	public BRF154_ENTITY() {
		super();
		// TODO Auto-generated constructor stub
	}

}
