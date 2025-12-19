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
@Table(name = "BRF42_SUMMARYTABLE")
public class BRF42_ENTITY {
	private String r10_group1;
	private BigDecimal r10_market_value;
	private BigDecimal r10_drawing_power;
	private BigDecimal r10_present;
	private BigDecimal r10_as_drawing_power;
	private BigDecimal r10_excess_over_drawing_power;
	private String r10_bank_gtee;
	private BigDecimal r10_mortage;
	private String r10_remarks;
	private String r11_group2;
	private BigDecimal r11_market_value;
	private BigDecimal r11_drawing_power;
	private BigDecimal r11_present;
	private BigDecimal r11_as_drawing_power;
	private BigDecimal r11_excess_over_drawing_power;
	private String r11_bank_gtee;
	private BigDecimal r11_mortage;
	private String r11_remarks;
	private String r12_group3;
	private BigDecimal r12_market_value;
	private BigDecimal r12_drawing_power;
	private BigDecimal r12_present;
	private BigDecimal r12_as_drawing_power;
	private BigDecimal r12_excess_over_drawing_power;
	private String r12_bank_gtee;
	private BigDecimal r12_mortage;
	private String r12_remarks;
	private String r13_group4;
	private BigDecimal r13_market_value;
	private BigDecimal r13_drawing_power;
	private BigDecimal r13_present;
	private BigDecimal r13_as_drawing_power;
	private BigDecimal r13_excess_over_drawing_power;
	private String r13_bank_gtee;
	private BigDecimal r13_mortage;
	private String r13_remarks;
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

	public String getR10_group1() {
		return r10_group1;
	}

	public void setR10_group1(String r10_group1) {
		this.r10_group1 = r10_group1;
	}

	public BigDecimal getR10_market_value() {
		return r10_market_value;
	}

	public void setR10_market_value(BigDecimal r10_market_value) {
		this.r10_market_value = r10_market_value;
	}

	public BigDecimal getR10_drawing_power() {
		return r10_drawing_power;
	}

	public void setR10_drawing_power(BigDecimal r10_drawing_power) {
		this.r10_drawing_power = r10_drawing_power;
	}

	public BigDecimal getR10_present() {
		return r10_present;
	}

	public void setR10_present(BigDecimal r10_present) {
		this.r10_present = r10_present;
	}

	public BigDecimal getR10_as_drawing_power() {
		return r10_as_drawing_power;
	}

	public void setR10_as_drawing_power(BigDecimal r10_as_drawing_power) {
		this.r10_as_drawing_power = r10_as_drawing_power;
	}

	public BigDecimal getR10_excess_over_drawing_power() {
		return r10_excess_over_drawing_power;
	}

	public void setR10_excess_over_drawing_power(BigDecimal r10_excess_over_drawing_power) {
		this.r10_excess_over_drawing_power = r10_excess_over_drawing_power;
	}

	public String getR10_bank_gtee() {
		return r10_bank_gtee;
	}

	public void setR10_bank_gtee(String r10_bank_gtee) {
		this.r10_bank_gtee = r10_bank_gtee;
	}

	public BigDecimal getR10_mortage() {
		return r10_mortage;
	}

	public void setR10_mortage(BigDecimal r10_mortage) {
		this.r10_mortage = r10_mortage;
	}

	public String getR10_remarks() {
		return r10_remarks;
	}

	public void setR10_remarks(String r10_remarks) {
		this.r10_remarks = r10_remarks;
	}

	public String getR11_group2() {
		return r11_group2;
	}

	public void setR11_group2(String r11_group2) {
		this.r11_group2 = r11_group2;
	}

	public BigDecimal getR11_market_value() {
		return r11_market_value;
	}

	public void setR11_market_value(BigDecimal r11_market_value) {
		this.r11_market_value = r11_market_value;
	}

	public BigDecimal getR11_drawing_power() {
		return r11_drawing_power;
	}

	public void setR11_drawing_power(BigDecimal r11_drawing_power) {
		this.r11_drawing_power = r11_drawing_power;
	}

	public BigDecimal getR11_present() {
		return r11_present;
	}

	public void setR11_present(BigDecimal r11_present) {
		this.r11_present = r11_present;
	}

	public BigDecimal getR11_as_drawing_power() {
		return r11_as_drawing_power;
	}

	public void setR11_as_drawing_power(BigDecimal r11_as_drawing_power) {
		this.r11_as_drawing_power = r11_as_drawing_power;
	}

	public BigDecimal getR11_excess_over_drawing_power() {
		return r11_excess_over_drawing_power;
	}

	public void setR11_excess_over_drawing_power(BigDecimal r11_excess_over_drawing_power) {
		this.r11_excess_over_drawing_power = r11_excess_over_drawing_power;
	}

	public String getR11_bank_gtee() {
		return r11_bank_gtee;
	}

	public void setR11_bank_gtee(String r11_bank_gtee) {
		this.r11_bank_gtee = r11_bank_gtee;
	}

	public BigDecimal getR11_mortage() {
		return r11_mortage;
	}

	public void setR11_mortage(BigDecimal r11_mortage) {
		this.r11_mortage = r11_mortage;
	}

	public String getR11_remarks() {
		return r11_remarks;
	}

	public void setR11_remarks(String r11_remarks) {
		this.r11_remarks = r11_remarks;
	}

	public String getR12_group3() {
		return r12_group3;
	}

	public void setR12_group3(String r12_group3) {
		this.r12_group3 = r12_group3;
	}

	public BigDecimal getR12_market_value() {
		return r12_market_value;
	}

	public void setR12_market_value(BigDecimal r12_market_value) {
		this.r12_market_value = r12_market_value;
	}

	public BigDecimal getR12_drawing_power() {
		return r12_drawing_power;
	}

	public void setR12_drawing_power(BigDecimal r12_drawing_power) {
		this.r12_drawing_power = r12_drawing_power;
	}

	public BigDecimal getR12_present() {
		return r12_present;
	}

	public void setR12_present(BigDecimal r12_present) {
		this.r12_present = r12_present;
	}

	public BigDecimal getR12_as_drawing_power() {
		return r12_as_drawing_power;
	}

	public void setR12_as_drawing_power(BigDecimal r12_as_drawing_power) {
		this.r12_as_drawing_power = r12_as_drawing_power;
	}

	public BigDecimal getR12_excess_over_drawing_power() {
		return r12_excess_over_drawing_power;
	}

	public void setR12_excess_over_drawing_power(BigDecimal r12_excess_over_drawing_power) {
		this.r12_excess_over_drawing_power = r12_excess_over_drawing_power;
	}

	public String getR12_bank_gtee() {
		return r12_bank_gtee;
	}

	public void setR12_bank_gtee(String r12_bank_gtee) {
		this.r12_bank_gtee = r12_bank_gtee;
	}

	public BigDecimal getR12_mortage() {
		return r12_mortage;
	}

	public void setR12_mortage(BigDecimal r12_mortage) {
		this.r12_mortage = r12_mortage;
	}

	public String getR12_remarks() {
		return r12_remarks;
	}

	public void setR12_remarks(String r12_remarks) {
		this.r12_remarks = r12_remarks;
	}

	public String getR13_group4() {
		return r13_group4;
	}

	public void setR13_group4(String r13_group4) {
		this.r13_group4 = r13_group4;
	}

	public BigDecimal getR13_market_value() {
		return r13_market_value;
	}

	public void setR13_market_value(BigDecimal r13_market_value) {
		this.r13_market_value = r13_market_value;
	}

	public BigDecimal getR13_drawing_power() {
		return r13_drawing_power;
	}

	public void setR13_drawing_power(BigDecimal r13_drawing_power) {
		this.r13_drawing_power = r13_drawing_power;
	}

	public BigDecimal getR13_present() {
		return r13_present;
	}

	public void setR13_present(BigDecimal r13_present) {
		this.r13_present = r13_present;
	}

	public BigDecimal getR13_as_drawing_power() {
		return r13_as_drawing_power;
	}

	public void setR13_as_drawing_power(BigDecimal r13_as_drawing_power) {
		this.r13_as_drawing_power = r13_as_drawing_power;
	}

	public BigDecimal getR13_excess_over_drawing_power() {
		return r13_excess_over_drawing_power;
	}

	public void setR13_excess_over_drawing_power(BigDecimal r13_excess_over_drawing_power) {
		this.r13_excess_over_drawing_power = r13_excess_over_drawing_power;
	}

	public String getR13_bank_gtee() {
		return r13_bank_gtee;
	}

	public void setR13_bank_gtee(String r13_bank_gtee) {
		this.r13_bank_gtee = r13_bank_gtee;
	}

	public BigDecimal getR13_mortage() {
		return r13_mortage;
	}

	public void setR13_mortage(BigDecimal r13_mortage) {
		this.r13_mortage = r13_mortage;
	}

	public String getR13_remarks() {
		return r13_remarks;
	}

	public void setR13_remarks(String r13_remarks) {
		this.r13_remarks = r13_remarks;
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

	public BRF42_ENTITY(String r10_group1, BigDecimal r10_market_value, BigDecimal r10_drawing_power,
			BigDecimal r10_present, BigDecimal r10_as_drawing_power, BigDecimal r10_excess_over_drawing_power,
			String r10_bank_gtee, BigDecimal r10_mortage, String r10_remarks, String r11_group2,
			BigDecimal r11_market_value, BigDecimal r11_drawing_power, BigDecimal r11_present,
			BigDecimal r11_as_drawing_power, BigDecimal r11_excess_over_drawing_power, String r11_bank_gtee,
			BigDecimal r11_mortage, String r11_remarks, String r12_group3, BigDecimal r12_market_value,
			BigDecimal r12_drawing_power, BigDecimal r12_present, BigDecimal r12_as_drawing_power,
			BigDecimal r12_excess_over_drawing_power, String r12_bank_gtee, BigDecimal r12_mortage, String r12_remarks,
			String r13_group4, BigDecimal r13_market_value, BigDecimal r13_drawing_power, BigDecimal r13_present,
			BigDecimal r13_as_drawing_power, BigDecimal r13_excess_over_drawing_power, String r13_bank_gtee,
			BigDecimal r13_mortage, String r13_remarks, Date report_date, Date report_from_date, Date report_to_date,
			String entity_flg, String modify_flg, String del_flg, String report_code, Date report_submit_date,
			String repdesc, String frequency) {
		super();
		this.r10_group1 = r10_group1;
		this.r10_market_value = r10_market_value;
		this.r10_drawing_power = r10_drawing_power;
		this.r10_present = r10_present;
		this.r10_as_drawing_power = r10_as_drawing_power;
		this.r10_excess_over_drawing_power = r10_excess_over_drawing_power;
		this.r10_bank_gtee = r10_bank_gtee;
		this.r10_mortage = r10_mortage;
		this.r10_remarks = r10_remarks;
		this.r11_group2 = r11_group2;
		this.r11_market_value = r11_market_value;
		this.r11_drawing_power = r11_drawing_power;
		this.r11_present = r11_present;
		this.r11_as_drawing_power = r11_as_drawing_power;
		this.r11_excess_over_drawing_power = r11_excess_over_drawing_power;
		this.r11_bank_gtee = r11_bank_gtee;
		this.r11_mortage = r11_mortage;
		this.r11_remarks = r11_remarks;
		this.r12_group3 = r12_group3;
		this.r12_market_value = r12_market_value;
		this.r12_drawing_power = r12_drawing_power;
		this.r12_present = r12_present;
		this.r12_as_drawing_power = r12_as_drawing_power;
		this.r12_excess_over_drawing_power = r12_excess_over_drawing_power;
		this.r12_bank_gtee = r12_bank_gtee;
		this.r12_mortage = r12_mortage;
		this.r12_remarks = r12_remarks;
		this.r13_group4 = r13_group4;
		this.r13_market_value = r13_market_value;
		this.r13_drawing_power = r13_drawing_power;
		this.r13_present = r13_present;
		this.r13_as_drawing_power = r13_as_drawing_power;
		this.r13_excess_over_drawing_power = r13_excess_over_drawing_power;
		this.r13_bank_gtee = r13_bank_gtee;
		this.r13_mortage = r13_mortage;
		this.r13_remarks = r13_remarks;
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

	public BRF42_ENTITY() {
		super();
		// TODO Auto-generated constructor stub
	}
}
