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
@Table(name = "BRF47_SUMMARYTABLE")
public class BRF47_Entity {
	private BigDecimal indentifcation_number;
	private String issue_name;
	private BigDecimal issue_tracker;
	private String country;
	private String country_party;
	private BigDecimal amount;
	private BigDecimal grant_total;
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
	private String repdesc;
	private String frequency;

	public BigDecimal getIndentifcation_number() {
		return indentifcation_number;
	}

	public void setIndentifcation_number(BigDecimal indentifcation_number) {
		this.indentifcation_number = indentifcation_number;
	}

	public String getIssue_name() {
		return issue_name;
	}

	public void setIssue_name(String issue_name) {
		this.issue_name = issue_name;
	}

	public BigDecimal getIssue_tracker() {
		return issue_tracker;
	}

	public void setIssue_tracker(BigDecimal issue_tracker) {
		this.issue_tracker = issue_tracker;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCountry_party() {
		return country_party;
	}

	public void setCountry_party(String country_party) {
		this.country_party = country_party;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public BigDecimal getGrant_total() {
		return grant_total;
	}

	public void setGrant_total(BigDecimal grant_total) {
		this.grant_total = grant_total;
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

	@Override
	public String toString() {
		return "BRF47_Entity [indentifcation_number=" + indentifcation_number + ", issue_name=" + issue_name
				+ ", issue_tracker=" + issue_tracker + ", country=" + country + ", country_party=" + country_party
				+ ", amount=" + amount + ", grant_total=" + grant_total + ", report_date=" + report_date
				+ ", report_from_date=" + report_from_date + ", report_to_date=" + report_to_date + ", entity_flg="
				+ entity_flg + ", modify_flg=" + modify_flg + ", del_flg=" + del_flg + ", report_code=" + report_code
				+ ", report_submit_date=" + report_submit_date + ", repdesc=" + repdesc + ", frequency=" + frequency
				+ ", getIndentifcation_number()=" + getIndentifcation_number() + ", getIssue_name()=" + getIssue_name()
				+ ", getIssue_tracker()=" + getIssue_tracker() + ", getCountry()=" + getCountry()
				+ ", getCountry_party()=" + getCountry_party() + ", getAmount()=" + getAmount() + ", getGrant_total()="
				+ getGrant_total() + ", getReport_date()=" + getReport_date() + ", getReport_from_date()="
				+ getReport_from_date() + ", getReport_to_date()=" + getReport_to_date() + ", getEntity_flg()="
				+ getEntity_flg() + ", getModify_flg()=" + getModify_flg() + ", getDel_flg()=" + getDel_flg()
				+ ", getReport_code()=" + getReport_code() + ", getReport_submit_date()=" + getReport_submit_date()
				+ ", getRepdesc()=" + getRepdesc() + ", getFrequency()=" + getFrequency() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

	public BRF47_Entity(BigDecimal indentifcation_number, String issue_name, BigDecimal issue_tracker, String country,
			String country_party, BigDecimal amount, BigDecimal grant_total, Date report_date, Date report_from_date,
			Date report_to_date, String entity_flg, String modify_flg, String del_flg, String report_code,
			Date report_submit_date, String repdesc, String frequency) {
		super();
		this.indentifcation_number = indentifcation_number;
		this.issue_name = issue_name;
		this.issue_tracker = issue_tracker;
		this.country = country;
		this.country_party = country_party;
		this.amount = amount;
		this.grant_total = grant_total;
		this.report_date = report_date;
		this.report_from_date = report_from_date;
		this.report_to_date = report_to_date;
		this.entity_flg = entity_flg;
		this.modify_flg = modify_flg;
		this.del_flg = del_flg;
		this.report_code = report_code;
		this.report_submit_date = report_submit_date;
		this.repdesc = repdesc;
		this.frequency = frequency;
	}

	public BRF47_Entity() {
		super();
		// TODO Auto-generated constructor stub
	}
}