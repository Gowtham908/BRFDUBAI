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
@Table(name = "BRF35_SUMMARYTABLE")
public class BRF35_ENTITY {
	private String country_party;
	private String branch;
	private String head_office;
	private BigDecimal due_from_placements;
	private BigDecimal due_to_borrowing;
	private BigDecimal due_from_remaining;
	private BigDecimal due_to_bremaining;
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

	public String getCountry_party() {
		return country_party;
	}

	public void setCountry_party(String country_party) {
		this.country_party = country_party;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public String getHead_office() {
		return head_office;
	}

	public void setHead_office(String head_office) {
		this.head_office = head_office;
	}

	public BigDecimal getDue_from_placements() {
		return due_from_placements;
	}

	public void setDue_from_placements(BigDecimal due_from_placements) {
		this.due_from_placements = due_from_placements;
	}

	public BigDecimal getDue_to_borrowing() {
		return due_to_borrowing;
	}

	public void setDue_to_borrowing(BigDecimal due_to_borrowing) {
		this.due_to_borrowing = due_to_borrowing;
	}

	public BigDecimal getDue_from_remaining() {
		return due_from_remaining;
	}

	public void setDue_from_remaining(BigDecimal due_from_remaining) {
		this.due_from_remaining = due_from_remaining;
	}

	public BigDecimal getDue_to_bremaining() {
		return due_to_bremaining;
	}

	public void setDue_to_bremaining(BigDecimal due_to_bremaining) {
		this.due_to_bremaining = due_to_bremaining;
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
		return "BRF35_ENTITY [country_party=" + country_party + ", branch=" + branch + ", head_office=" + head_office
				+ ", due_from_placements=" + due_from_placements + ", due_to_borrowing=" + due_to_borrowing
				+ ", due_from_remaining=" + due_from_remaining + ", due_to_bremaining=" + due_to_bremaining
				+ ", report_date=" + report_date + ", report_from_date=" + report_from_date + ", report_to_date="
				+ report_to_date + ", entity_flg=" + entity_flg + ", modify_flg=" + modify_flg + ", del_flg=" + del_flg
				+ ", report_code=" + report_code + ", report_submit_date=" + report_submit_date + ", repdesc=" + repdesc
				+ ", frequency=" + frequency + ", getCountry_party()=" + getCountry_party() + ", getBranch()="
				+ getBranch() + ", getHead_office()=" + getHead_office() + ", getDue_from_placements()="
				+ getDue_from_placements() + ", getDue_to_borrowing()=" + getDue_to_borrowing()
				+ ", getDue_from_remaining()=" + getDue_from_remaining() + ", getDue_to_bremaining()="
				+ getDue_to_bremaining() + ", getReport_date()=" + getReport_date() + ", getReport_from_date()="
				+ getReport_from_date() + ", getReport_to_date()=" + getReport_to_date() + ", getEntity_flg()="
				+ getEntity_flg() + ", getModify_flg()=" + getModify_flg() + ", getDel_flg()=" + getDel_flg()
				+ ", getReport_code()=" + getReport_code() + ", getReport_submit_date()=" + getReport_submit_date()
				+ ", getRepdesc()=" + getRepdesc() + ", getFrequency()=" + getFrequency() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

	public BRF35_ENTITY(String country_party, String branch, String head_office, BigDecimal due_from_placements,
			BigDecimal due_to_borrowing, BigDecimal due_from_remaining, BigDecimal due_to_bremaining, Date report_date,
			Date report_from_date, Date report_to_date, String entity_flg, String modify_flg, String del_flg,
			String report_code, Date report_submit_date, String repdesc, String frequency) {
		super();
		this.country_party = country_party;
		this.branch = branch;
		this.head_office = head_office;
		this.due_from_placements = due_from_placements;
		this.due_to_borrowing = due_to_borrowing;
		this.due_from_remaining = due_from_remaining;
		this.due_to_bremaining = due_to_bremaining;
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

	public BRF35_ENTITY() {
		super();
		// TODO Auto-generated constructor stub
	}
}
