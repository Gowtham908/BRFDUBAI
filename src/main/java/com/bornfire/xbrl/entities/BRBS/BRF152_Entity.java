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
@Table(name="BRF152_SUMMARYTABLE")
public class BRF152_Entity {
	@Id
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date	report_date;
	private BigDecimal	r1_national_amount;
	private BigDecimal	r1_gross_value;
	private BigDecimal	r1_residual_oneyear;
	private BigDecimal	r1_residual_onetothree_year;
	private BigDecimal	r1_residual_threeyear;
	private BigDecimal	r1_tenper_oneyear;
	private BigDecimal	r1_minustenper_oneyear;
	private BigDecimal	r1_tenper_onetothree_year;
	private BigDecimal	r1_minustenper_onetothree_year;
	private BigDecimal	r1_tenper_threeyear;
	private BigDecimal	r1_zero_threeyear;
	private BigDecimal	r2_national_amount;
	private BigDecimal	r2_gross_value;
	private BigDecimal	r2_residual_oneyear;
	private BigDecimal	r2_residual_onetothree_year;
	private BigDecimal	r2_residual_threeyear;
	private BigDecimal	r2_tenper_oneyear;
	private BigDecimal	r2_minustenper_oneyear;
	private BigDecimal	r2_tenper_onetothree_year;
	private BigDecimal	r2_minustenper_onetothree_year;
	private BigDecimal	r2_tenper_threeyear;
	private BigDecimal	r2_zero_threeyear;
	private BigDecimal	r3_national_amount;
	private BigDecimal	r3_gross_value;
	private BigDecimal	r3_residual_oneyear;
	private BigDecimal	r3_residual_onetothree_year;
	private BigDecimal	r3_residual_threeyear;
	private BigDecimal	r3_tenper_oneyear;
	private BigDecimal	r3_minustenper_oneyear;
	private BigDecimal	r3_tenper_onetothree_year;
	private BigDecimal	r3_minustenper_onetothree_year;
	private BigDecimal	r3_tenper_threeyear;
	private BigDecimal	r3_zero_threeyear;
	private BigDecimal	r4_national_amount;
	private BigDecimal	r4_gross_value;
	private BigDecimal	r4_residual_oneyear;
	private BigDecimal	r4_residual_onetothree_year;
	private BigDecimal	r4_residual_threeyear;
	private BigDecimal	r4_tenper_oneyear;
	private BigDecimal	r4_minustenper_oneyear;
	private BigDecimal	r4_tenper_onetothree_year;
	private BigDecimal	r4_minustenper_onetothree_year;
	private BigDecimal	r4_tenper_threeyear;
	private BigDecimal	r4_zero_threeyear;
	private BigDecimal	r5_national_amount;
	private BigDecimal	r5_gross_value;
	private BigDecimal	r5_residual_oneyear;
	private BigDecimal	r5_residual_onetothree_year;
	private BigDecimal	r5_residual_threeyear;
	private BigDecimal	r5_tenper_oneyear;
	private BigDecimal	r5_minustenper_oneyear;
	private BigDecimal	r5_tenper_onetothree_year;
	private BigDecimal	r5_minustenper_onetothree_year;
	private BigDecimal	r5_tenper_threeyear;
	private BigDecimal	r5_zero_threeyear;
	private BigDecimal	r6_national_amount;
	private BigDecimal	r6_gross_value;
	private BigDecimal	r6_residual_oneyear;
	private BigDecimal	r6_residual_onetothree_year;
	private BigDecimal	r6_residual_threeyear;
	private BigDecimal	r6_tenper_oneyear;
	private BigDecimal	r6_minustenper_oneyear;
	private BigDecimal	r6_tenper_onetothree_year;
	private BigDecimal	r6_minustenper_onetothree_year;
	private BigDecimal	r6_tenper_threeyear;
	private BigDecimal	r6_zero_threeyear;
	private BigDecimal	r7_national_amount;
	private BigDecimal	r7_gross_value;
	private BigDecimal	r7_residual_oneyear;
	private BigDecimal	r7_residual_onetothree_year;
	private BigDecimal	r7_residual_threeyear;
	private BigDecimal	r7_tenper_oneyear;
	private BigDecimal	r7_minustenper_oneyear;
	private BigDecimal	r7_tenper_onetothree_year;
	private BigDecimal	r7_minustenper_onetothree_year;
	private BigDecimal	r7_tenper_threeyear;
	private BigDecimal	r7_zero_threeyear;
	private BigDecimal	r8_national_amount;
	private BigDecimal	r8_gross_value;
	private BigDecimal	r8_residual_oneyear;
	private BigDecimal	r8_residual_onetothree_year;
	private BigDecimal	r8_residual_threeyear;
	private BigDecimal	r8_tenper_oneyear;
	private BigDecimal	r8_minustenper_oneyear;
	private BigDecimal	r8_tenper_onetothree_year;
	private BigDecimal	r8_minustenper_onetothree_year;
	private BigDecimal	r8_tenper_threeyear;
	private BigDecimal	r8_zero_threeyear;
	private BigDecimal	r9_national_amount;
	private BigDecimal	r9_gross_value;
	private BigDecimal	r9_residual_oneyear;
	private BigDecimal	r9_residual_onetothree_year;
	private BigDecimal	r9_residual_threeyear;
	private BigDecimal	r9_tenper_oneyear;
	private BigDecimal	r9_minustenper_oneyear;
	private BigDecimal	r9_tenper_onetothree_year;
	private BigDecimal	r9_minustenper_onetothree_year;
	private BigDecimal	r9_tenper_threeyear;
	private BigDecimal	r9_zero_threeyear;
	private BigDecimal	r10_national_amount;
	private BigDecimal	r10_gross_value;
	private BigDecimal	r10_residual_oneyear;
	private BigDecimal	r10_residual_onetothree_year;
	private BigDecimal	r10_residual_threeyear;
	private BigDecimal	r10_tenper_oneyear;
	private BigDecimal	r10_minustenper_oneyear;
	private BigDecimal	r10_tenper_onetothree_year;
	private BigDecimal	r10_minustenper_onetothree_year;
	private BigDecimal	r10_tenper_threeyear;
	private BigDecimal	r10_zero_threeyear;
	private BigDecimal	r11_national_amount;
	private BigDecimal	r11_gross_value;
	private BigDecimal	r11_residual_oneyear;
	private BigDecimal	r11_residual_onetothree_year;
	private BigDecimal	r11_residual_threeyear;
	private BigDecimal	r11_tenper_oneyear;
	private BigDecimal	r11_minustenper_oneyear;
	private BigDecimal	r11_tenper_onetothree_year;
	private BigDecimal	r11_minustenper_onetothree_year;
	private BigDecimal	r11_tenper_threeyear;
	private BigDecimal	r11_zero_threeyear;
	private BigDecimal	r12_national_amount;
	private BigDecimal	r12_gross_value;
	private BigDecimal	r12_residual_oneyear;
	private BigDecimal	r12_residual_onetothree_year;
	private BigDecimal	r12_residual_threeyear;
	private BigDecimal	r12_tenper_oneyear;
	private BigDecimal	r12_minustenper_oneyear;
	private BigDecimal	r12_tenper_onetothree_year;
	private BigDecimal	r12_minustenper_onetothree_year;
	private BigDecimal	r12_tenper_threeyear;
	private BigDecimal	r12_zero_threeyear;
	private BigDecimal	r13_national_amount;
	private BigDecimal	r13_gross_value;
	private BigDecimal	r13_residual_oneyear;
	private BigDecimal	r13_residual_onetothree_year;
	private BigDecimal	r13_residual_threeyear;
	private BigDecimal	r13_tenper_oneyear;
	private BigDecimal	r13_minustenper_oneyear;
	private BigDecimal	r13_tenper_onetothree_year;
	private BigDecimal	r13_minustenper_onetothree_year;
	private BigDecimal	r13_tenper_threeyear;
	private BigDecimal	r13_zero_threeyear;
	private BigDecimal	r14_national_amount;
	private BigDecimal	r14_gross_value;
	private BigDecimal	r14_residual_oneyear;
	private BigDecimal	r14_residual_onetothree_year;
	private BigDecimal	r14_residual_threeyear;
	private BigDecimal	r14_tenper_oneyear;
	private BigDecimal	r14_minustenper_oneyear;
	private BigDecimal	r14_tenper_onetothree_year;
	private BigDecimal	r14_minustenper_onetothree_year;
	private BigDecimal	r14_tenper_threeyear;
	private BigDecimal	r14_zero_threeyear;
	private BigDecimal	r15_national_amount;
	private BigDecimal	r15_gross_value;
	private BigDecimal	r15_residual_oneyear;
	private BigDecimal	r15_residual_onetothree_year;
	private BigDecimal	r15_residual_threeyear;
	private BigDecimal	r15_tenper_oneyear;
	private BigDecimal	r15_minustenper_oneyear;
	private BigDecimal	r15_tenper_onetothree_year;
	private BigDecimal	r15_minustenper_onetothree_year;
	private BigDecimal	r15_tenper_threeyear;
	private BigDecimal	r15_zero_threeyear;
	private BigDecimal	r16_national_amount;
	private BigDecimal	r16_gross_value;
	private BigDecimal	r16_residual_oneyear;
	private BigDecimal	r16_residual_onetothree_year;
	private BigDecimal	r16_residual_threeyear;
	private BigDecimal	r16_tenper_oneyear;
	private BigDecimal	r16_minustenper_oneyear;
	private BigDecimal	r16_tenper_onetothree_year;
	private BigDecimal	r16_minustenper_onetothree_year;
	private BigDecimal	r16_tenper_threeyear;
	private BigDecimal	r16_zero_threeyear;
	private BigDecimal	r17_national_amount;
	private BigDecimal	r17_gross_value;
	private BigDecimal	r17_residual_oneyear;
	private BigDecimal	r17_residual_onetothree_year;
	private BigDecimal	r17_residual_threeyear;
	private BigDecimal	r17_tenper_oneyear;
	private BigDecimal	r17_minustenper_oneyear;
	private BigDecimal	r17_tenper_onetothree_year;
	private BigDecimal	r17_minustenper_onetothree_year;
	private BigDecimal	r17_tenper_threeyear;
	private BigDecimal	r17_zero_threeyear;
	private BigDecimal	r18_national_amount;
	private BigDecimal	r18_gross_value;
	private BigDecimal	r18_residual_oneyear;
	private BigDecimal	r18_residual_onetothree_year;
	private BigDecimal	r18_residual_threeyear;
	private BigDecimal	r18_tenper_oneyear;
	private BigDecimal	r18_minustenper_oneyear;
	private BigDecimal	r18_tenper_onetothree_year;
	private BigDecimal	r18_minustenper_onetothree_year;
	private BigDecimal	r18_tenper_threeyear;
	private BigDecimal	r18_zero_threeyear;
	private BigDecimal	r19_national_amount;
	private BigDecimal	r19_gross_value;
	private BigDecimal	r19_residual_oneyear;
	private BigDecimal	r19_residual_onetothree_year;
	private BigDecimal	r19_residual_threeyear;
	private BigDecimal	r19_tenper_oneyear;
	private BigDecimal	r19_minustenper_oneyear;
	private BigDecimal	r19_tenper_onetothree_year;
	private BigDecimal	r19_minustenper_onetothree_year;
	private BigDecimal	r19_tenper_threeyear;
	private BigDecimal	r19_zero_threeyear;
	private BigDecimal	r20_national_amount;
	private BigDecimal	r20_gross_value;
	private BigDecimal	r20_residual_oneyear;
	private BigDecimal	r20_residual_onetothree_year;
	private BigDecimal	r20_residual_threeyear;
	private BigDecimal	r20_tenper_oneyear;
	private BigDecimal	r20_minustenper_oneyear;
	private BigDecimal	r20_tenper_onetothree_year;
	private BigDecimal	r20_minustenper_onetothree_year;
	private BigDecimal	r20_tenper_threeyear;
	private BigDecimal	r20_zero_threeyear;
	private BigDecimal	r21_national_amount;
	private BigDecimal	r21_gross_value;
	private BigDecimal	r21_residual_oneyear;
	private BigDecimal	r21_residual_onetothree_year;
	private BigDecimal	r21_residual_threeyear;
	private BigDecimal	r21_tenper_oneyear;
	private BigDecimal	r21_minustenper_oneyear;
	private BigDecimal	r21_tenper_onetothree_year;
	private BigDecimal	r21_minustenper_onetothree_year;
	private BigDecimal	r21_tenper_threeyear;
	private BigDecimal	r21_zero_threeyear;
	private BigDecimal	r22_national_amount;
	private BigDecimal	r22_gross_value;
	private BigDecimal	r22_residual_oneyear;
	private BigDecimal	r22_residual_onetothree_year;
	private BigDecimal	r22_residual_threeyear;
	private BigDecimal	r22_tenper_oneyear;
	private BigDecimal	r22_minustenper_oneyear;
	private BigDecimal	r22_tenper_onetothree_year;
	private BigDecimal	r22_minustenper_onetothree_year;
	private BigDecimal	r22_tenper_threeyear;
	private BigDecimal	r22_zero_threeyear;
	
	private Date	report_from_date;
	private Date	report_to_date;
	private String	entity_flg;
	private String	modify_flg;
	private String	del_flg;
	private String	report_code;
	private Date	report_submit_date;
	private String	repdesc;
	private String	frequency;
	public Date getReport_date() {
		return report_date;
	}
	public void setReport_date(Date report_date) {
		this.report_date = report_date;
	}
	public BigDecimal getR1_national_amount() {
		return r1_national_amount;
	}
	public void setR1_national_amount(BigDecimal r1_national_amount) {
		this.r1_national_amount = r1_national_amount;
	}
	public BigDecimal getR1_gross_value() {
		return r1_gross_value;
	}
	public void setR1_gross_value(BigDecimal r1_gross_value) {
		this.r1_gross_value = r1_gross_value;
	}
	public BigDecimal getR1_residual_oneyear() {
		return r1_residual_oneyear;
	}
	public void setR1_residual_oneyear(BigDecimal r1_residual_oneyear) {
		this.r1_residual_oneyear = r1_residual_oneyear;
	}
	public BigDecimal getR1_residual_onetothree_year() {
		return r1_residual_onetothree_year;
	}
	public void setR1_residual_onetothree_year(BigDecimal r1_residual_onetothree_year) {
		this.r1_residual_onetothree_year = r1_residual_onetothree_year;
	}
	public BigDecimal getR1_residual_threeyear() {
		return r1_residual_threeyear;
	}
	public void setR1_residual_threeyear(BigDecimal r1_residual_threeyear) {
		this.r1_residual_threeyear = r1_residual_threeyear;
	}
	public BigDecimal getR1_tenper_oneyear() {
		return r1_tenper_oneyear;
	}
	public void setR1_tenper_oneyear(BigDecimal r1_tenper_oneyear) {
		this.r1_tenper_oneyear = r1_tenper_oneyear;
	}
	public BigDecimal getR1_minustenper_oneyear() {
		return r1_minustenper_oneyear;
	}
	public void setR1_minustenper_oneyear(BigDecimal r1_minustenper_oneyear) {
		this.r1_minustenper_oneyear = r1_minustenper_oneyear;
	}
	public BigDecimal getR1_tenper_onetothree_year() {
		return r1_tenper_onetothree_year;
	}
	public void setR1_tenper_onetothree_year(BigDecimal r1_tenper_onetothree_year) {
		this.r1_tenper_onetothree_year = r1_tenper_onetothree_year;
	}
	public BigDecimal getR1_minustenper_onetothree_year() {
		return r1_minustenper_onetothree_year;
	}
	public void setR1_minustenper_onetothree_year(BigDecimal r1_minustenper_onetothree_year) {
		this.r1_minustenper_onetothree_year = r1_minustenper_onetothree_year;
	}
	public BigDecimal getR1_tenper_threeyear() {
		return r1_tenper_threeyear;
	}
	public void setR1_tenper_threeyear(BigDecimal r1_tenper_threeyear) {
		this.r1_tenper_threeyear = r1_tenper_threeyear;
	}
	public BigDecimal getR1_zero_threeyear() {
		return r1_zero_threeyear;
	}
	public void setR1_zero_threeyear(BigDecimal r1_zero_threeyear) {
		this.r1_zero_threeyear = r1_zero_threeyear;
	}
	public BigDecimal getR2_national_amount() {
		return r2_national_amount;
	}
	public void setR2_national_amount(BigDecimal r2_national_amount) {
		this.r2_national_amount = r2_national_amount;
	}
	public BigDecimal getR2_gross_value() {
		return r2_gross_value;
	}
	public void setR2_gross_value(BigDecimal r2_gross_value) {
		this.r2_gross_value = r2_gross_value;
	}
	public BigDecimal getR2_residual_oneyear() {
		return r2_residual_oneyear;
	}
	public void setR2_residual_oneyear(BigDecimal r2_residual_oneyear) {
		this.r2_residual_oneyear = r2_residual_oneyear;
	}
	public BigDecimal getR2_residual_onetothree_year() {
		return r2_residual_onetothree_year;
	}
	public void setR2_residual_onetothree_year(BigDecimal r2_residual_onetothree_year) {
		this.r2_residual_onetothree_year = r2_residual_onetothree_year;
	}
	public BigDecimal getR2_residual_threeyear() {
		return r2_residual_threeyear;
	}
	public void setR2_residual_threeyear(BigDecimal r2_residual_threeyear) {
		this.r2_residual_threeyear = r2_residual_threeyear;
	}
	public BigDecimal getR2_tenper_oneyear() {
		return r2_tenper_oneyear;
	}
	public void setR2_tenper_oneyear(BigDecimal r2_tenper_oneyear) {
		this.r2_tenper_oneyear = r2_tenper_oneyear;
	}
	public BigDecimal getR2_minustenper_oneyear() {
		return r2_minustenper_oneyear;
	}
	public void setR2_minustenper_oneyear(BigDecimal r2_minustenper_oneyear) {
		this.r2_minustenper_oneyear = r2_minustenper_oneyear;
	}
	public BigDecimal getR2_tenper_onetothree_year() {
		return r2_tenper_onetothree_year;
	}
	public void setR2_tenper_onetothree_year(BigDecimal r2_tenper_onetothree_year) {
		this.r2_tenper_onetothree_year = r2_tenper_onetothree_year;
	}
	public BigDecimal getR2_minustenper_onetothree_year() {
		return r2_minustenper_onetothree_year;
	}
	public void setR2_minustenper_onetothree_year(BigDecimal r2_minustenper_onetothree_year) {
		this.r2_minustenper_onetothree_year = r2_minustenper_onetothree_year;
	}
	public BigDecimal getR2_tenper_threeyear() {
		return r2_tenper_threeyear;
	}
	public void setR2_tenper_threeyear(BigDecimal r2_tenper_threeyear) {
		this.r2_tenper_threeyear = r2_tenper_threeyear;
	}
	public BigDecimal getR2_zero_threeyear() {
		return r2_zero_threeyear;
	}
	public void setR2_zero_threeyear(BigDecimal r2_zero_threeyear) {
		this.r2_zero_threeyear = r2_zero_threeyear;
	}
	public BigDecimal getR3_national_amount() {
		return r3_national_amount;
	}
	public void setR3_national_amount(BigDecimal r3_national_amount) {
		this.r3_national_amount = r3_national_amount;
	}
	public BigDecimal getR3_gross_value() {
		return r3_gross_value;
	}
	public void setR3_gross_value(BigDecimal r3_gross_value) {
		this.r3_gross_value = r3_gross_value;
	}
	public BigDecimal getR3_residual_oneyear() {
		return r3_residual_oneyear;
	}
	public void setR3_residual_oneyear(BigDecimal r3_residual_oneyear) {
		this.r3_residual_oneyear = r3_residual_oneyear;
	}
	public BigDecimal getR3_residual_onetothree_year() {
		return r3_residual_onetothree_year;
	}
	public void setR3_residual_onetothree_year(BigDecimal r3_residual_onetothree_year) {
		this.r3_residual_onetothree_year = r3_residual_onetothree_year;
	}
	public BigDecimal getR3_residual_threeyear() {
		return r3_residual_threeyear;
	}
	public void setR3_residual_threeyear(BigDecimal r3_residual_threeyear) {
		this.r3_residual_threeyear = r3_residual_threeyear;
	}
	public BigDecimal getR3_tenper_oneyear() {
		return r3_tenper_oneyear;
	}
	public void setR3_tenper_oneyear(BigDecimal r3_tenper_oneyear) {
		this.r3_tenper_oneyear = r3_tenper_oneyear;
	}
	public BigDecimal getR3_minustenper_oneyear() {
		return r3_minustenper_oneyear;
	}
	public void setR3_minustenper_oneyear(BigDecimal r3_minustenper_oneyear) {
		this.r3_minustenper_oneyear = r3_minustenper_oneyear;
	}
	public BigDecimal getR3_tenper_onetothree_year() {
		return r3_tenper_onetothree_year;
	}
	public void setR3_tenper_onetothree_year(BigDecimal r3_tenper_onetothree_year) {
		this.r3_tenper_onetothree_year = r3_tenper_onetothree_year;
	}
	public BigDecimal getR3_minustenper_onetothree_year() {
		return r3_minustenper_onetothree_year;
	}
	public void setR3_minustenper_onetothree_year(BigDecimal r3_minustenper_onetothree_year) {
		this.r3_minustenper_onetothree_year = r3_minustenper_onetothree_year;
	}
	public BigDecimal getR3_tenper_threeyear() {
		return r3_tenper_threeyear;
	}
	public void setR3_tenper_threeyear(BigDecimal r3_tenper_threeyear) {
		this.r3_tenper_threeyear = r3_tenper_threeyear;
	}
	public BigDecimal getR3_zero_threeyear() {
		return r3_zero_threeyear;
	}
	public void setR3_zero_threeyear(BigDecimal r3_zero_threeyear) {
		this.r3_zero_threeyear = r3_zero_threeyear;
	}
	public BigDecimal getR4_national_amount() {
		return r4_national_amount;
	}
	public void setR4_national_amount(BigDecimal r4_national_amount) {
		this.r4_national_amount = r4_national_amount;
	}
	public BigDecimal getR4_gross_value() {
		return r4_gross_value;
	}
	public void setR4_gross_value(BigDecimal r4_gross_value) {
		this.r4_gross_value = r4_gross_value;
	}
	public BigDecimal getR4_residual_oneyear() {
		return r4_residual_oneyear;
	}
	public void setR4_residual_oneyear(BigDecimal r4_residual_oneyear) {
		this.r4_residual_oneyear = r4_residual_oneyear;
	}
	public BigDecimal getR4_residual_onetothree_year() {
		return r4_residual_onetothree_year;
	}
	public void setR4_residual_onetothree_year(BigDecimal r4_residual_onetothree_year) {
		this.r4_residual_onetothree_year = r4_residual_onetothree_year;
	}
	public BigDecimal getR4_residual_threeyear() {
		return r4_residual_threeyear;
	}
	public void setR4_residual_threeyear(BigDecimal r4_residual_threeyear) {
		this.r4_residual_threeyear = r4_residual_threeyear;
	}
	public BigDecimal getR4_tenper_oneyear() {
		return r4_tenper_oneyear;
	}
	public void setR4_tenper_oneyear(BigDecimal r4_tenper_oneyear) {
		this.r4_tenper_oneyear = r4_tenper_oneyear;
	}
	public BigDecimal getR4_minustenper_oneyear() {
		return r4_minustenper_oneyear;
	}
	public void setR4_minustenper_oneyear(BigDecimal r4_minustenper_oneyear) {
		this.r4_minustenper_oneyear = r4_minustenper_oneyear;
	}
	public BigDecimal getR4_tenper_onetothree_year() {
		return r4_tenper_onetothree_year;
	}
	public void setR4_tenper_onetothree_year(BigDecimal r4_tenper_onetothree_year) {
		this.r4_tenper_onetothree_year = r4_tenper_onetothree_year;
	}
	public BigDecimal getR4_minustenper_onetothree_year() {
		return r4_minustenper_onetothree_year;
	}
	public void setR4_minustenper_onetothree_year(BigDecimal r4_minustenper_onetothree_year) {
		this.r4_minustenper_onetothree_year = r4_minustenper_onetothree_year;
	}
	public BigDecimal getR4_tenper_threeyear() {
		return r4_tenper_threeyear;
	}
	public void setR4_tenper_threeyear(BigDecimal r4_tenper_threeyear) {
		this.r4_tenper_threeyear = r4_tenper_threeyear;
	}
	public BigDecimal getR4_zero_threeyear() {
		return r4_zero_threeyear;
	}
	public void setR4_zero_threeyear(BigDecimal r4_zero_threeyear) {
		this.r4_zero_threeyear = r4_zero_threeyear;
	}
	public BigDecimal getR5_national_amount() {
		return r5_national_amount;
	}
	public void setR5_national_amount(BigDecimal r5_national_amount) {
		this.r5_national_amount = r5_national_amount;
	}
	public BigDecimal getR5_gross_value() {
		return r5_gross_value;
	}
	public void setR5_gross_value(BigDecimal r5_gross_value) {
		this.r5_gross_value = r5_gross_value;
	}
	public BigDecimal getR5_residual_oneyear() {
		return r5_residual_oneyear;
	}
	public void setR5_residual_oneyear(BigDecimal r5_residual_oneyear) {
		this.r5_residual_oneyear = r5_residual_oneyear;
	}
	public BigDecimal getR5_residual_onetothree_year() {
		return r5_residual_onetothree_year;
	}
	public void setR5_residual_onetothree_year(BigDecimal r5_residual_onetothree_year) {
		this.r5_residual_onetothree_year = r5_residual_onetothree_year;
	}
	public BigDecimal getR5_residual_threeyear() {
		return r5_residual_threeyear;
	}
	public void setR5_residual_threeyear(BigDecimal r5_residual_threeyear) {
		this.r5_residual_threeyear = r5_residual_threeyear;
	}
	public BigDecimal getR5_tenper_oneyear() {
		return r5_tenper_oneyear;
	}
	public void setR5_tenper_oneyear(BigDecimal r5_tenper_oneyear) {
		this.r5_tenper_oneyear = r5_tenper_oneyear;
	}
	public BigDecimal getR5_minustenper_oneyear() {
		return r5_minustenper_oneyear;
	}
	public void setR5_minustenper_oneyear(BigDecimal r5_minustenper_oneyear) {
		this.r5_minustenper_oneyear = r5_minustenper_oneyear;
	}
	public BigDecimal getR5_tenper_onetothree_year() {
		return r5_tenper_onetothree_year;
	}
	public void setR5_tenper_onetothree_year(BigDecimal r5_tenper_onetothree_year) {
		this.r5_tenper_onetothree_year = r5_tenper_onetothree_year;
	}
	public BigDecimal getR5_minustenper_onetothree_year() {
		return r5_minustenper_onetothree_year;
	}
	public void setR5_minustenper_onetothree_year(BigDecimal r5_minustenper_onetothree_year) {
		this.r5_minustenper_onetothree_year = r5_minustenper_onetothree_year;
	}
	public BigDecimal getR5_tenper_threeyear() {
		return r5_tenper_threeyear;
	}
	public void setR5_tenper_threeyear(BigDecimal r5_tenper_threeyear) {
		this.r5_tenper_threeyear = r5_tenper_threeyear;
	}
	public BigDecimal getR5_zero_threeyear() {
		return r5_zero_threeyear;
	}
	public void setR5_zero_threeyear(BigDecimal r5_zero_threeyear) {
		this.r5_zero_threeyear = r5_zero_threeyear;
	}
	public BigDecimal getR6_national_amount() {
		return r6_national_amount;
	}
	public void setR6_national_amount(BigDecimal r6_national_amount) {
		this.r6_national_amount = r6_national_amount;
	}
	public BigDecimal getR6_gross_value() {
		return r6_gross_value;
	}
	public void setR6_gross_value(BigDecimal r6_gross_value) {
		this.r6_gross_value = r6_gross_value;
	}
	public BigDecimal getR6_residual_oneyear() {
		return r6_residual_oneyear;
	}
	public void setR6_residual_oneyear(BigDecimal r6_residual_oneyear) {
		this.r6_residual_oneyear = r6_residual_oneyear;
	}
	public BigDecimal getR6_residual_onetothree_year() {
		return r6_residual_onetothree_year;
	}
	public void setR6_residual_onetothree_year(BigDecimal r6_residual_onetothree_year) {
		this.r6_residual_onetothree_year = r6_residual_onetothree_year;
	}
	public BigDecimal getR6_residual_threeyear() {
		return r6_residual_threeyear;
	}
	public void setR6_residual_threeyear(BigDecimal r6_residual_threeyear) {
		this.r6_residual_threeyear = r6_residual_threeyear;
	}
	public BigDecimal getR6_tenper_oneyear() {
		return r6_tenper_oneyear;
	}
	public void setR6_tenper_oneyear(BigDecimal r6_tenper_oneyear) {
		this.r6_tenper_oneyear = r6_tenper_oneyear;
	}
	public BigDecimal getR6_minustenper_oneyear() {
		return r6_minustenper_oneyear;
	}
	public void setR6_minustenper_oneyear(BigDecimal r6_minustenper_oneyear) {
		this.r6_minustenper_oneyear = r6_minustenper_oneyear;
	}
	public BigDecimal getR6_tenper_onetothree_year() {
		return r6_tenper_onetothree_year;
	}
	public void setR6_tenper_onetothree_year(BigDecimal r6_tenper_onetothree_year) {
		this.r6_tenper_onetothree_year = r6_tenper_onetothree_year;
	}
	public BigDecimal getR6_minustenper_onetothree_year() {
		return r6_minustenper_onetothree_year;
	}
	public void setR6_minustenper_onetothree_year(BigDecimal r6_minustenper_onetothree_year) {
		this.r6_minustenper_onetothree_year = r6_minustenper_onetothree_year;
	}
	public BigDecimal getR6_tenper_threeyear() {
		return r6_tenper_threeyear;
	}
	public void setR6_tenper_threeyear(BigDecimal r6_tenper_threeyear) {
		this.r6_tenper_threeyear = r6_tenper_threeyear;
	}
	public BigDecimal getR6_zero_threeyear() {
		return r6_zero_threeyear;
	}
	public void setR6_zero_threeyear(BigDecimal r6_zero_threeyear) {
		this.r6_zero_threeyear = r6_zero_threeyear;
	}
	public BigDecimal getR7_national_amount() {
		return r7_national_amount;
	}
	public void setR7_national_amount(BigDecimal r7_national_amount) {
		this.r7_national_amount = r7_national_amount;
	}
	public BigDecimal getR7_gross_value() {
		return r7_gross_value;
	}
	public void setR7_gross_value(BigDecimal r7_gross_value) {
		this.r7_gross_value = r7_gross_value;
	}
	public BigDecimal getR7_residual_oneyear() {
		return r7_residual_oneyear;
	}
	public void setR7_residual_oneyear(BigDecimal r7_residual_oneyear) {
		this.r7_residual_oneyear = r7_residual_oneyear;
	}
	public BigDecimal getR7_residual_onetothree_year() {
		return r7_residual_onetothree_year;
	}
	public void setR7_residual_onetothree_year(BigDecimal r7_residual_onetothree_year) {
		this.r7_residual_onetothree_year = r7_residual_onetothree_year;
	}
	public BigDecimal getR7_residual_threeyear() {
		return r7_residual_threeyear;
	}
	public void setR7_residual_threeyear(BigDecimal r7_residual_threeyear) {
		this.r7_residual_threeyear = r7_residual_threeyear;
	}
	public BigDecimal getR7_tenper_oneyear() {
		return r7_tenper_oneyear;
	}
	public void setR7_tenper_oneyear(BigDecimal r7_tenper_oneyear) {
		this.r7_tenper_oneyear = r7_tenper_oneyear;
	}
	public BigDecimal getR7_minustenper_oneyear() {
		return r7_minustenper_oneyear;
	}
	public void setR7_minustenper_oneyear(BigDecimal r7_minustenper_oneyear) {
		this.r7_minustenper_oneyear = r7_minustenper_oneyear;
	}
	public BigDecimal getR7_tenper_onetothree_year() {
		return r7_tenper_onetothree_year;
	}
	public void setR7_tenper_onetothree_year(BigDecimal r7_tenper_onetothree_year) {
		this.r7_tenper_onetothree_year = r7_tenper_onetothree_year;
	}
	public BigDecimal getR7_minustenper_onetothree_year() {
		return r7_minustenper_onetothree_year;
	}
	public void setR7_minustenper_onetothree_year(BigDecimal r7_minustenper_onetothree_year) {
		this.r7_minustenper_onetothree_year = r7_minustenper_onetothree_year;
	}
	public BigDecimal getR7_tenper_threeyear() {
		return r7_tenper_threeyear;
	}
	public void setR7_tenper_threeyear(BigDecimal r7_tenper_threeyear) {
		this.r7_tenper_threeyear = r7_tenper_threeyear;
	}
	public BigDecimal getR7_zero_threeyear() {
		return r7_zero_threeyear;
	}
	public void setR7_zero_threeyear(BigDecimal r7_zero_threeyear) {
		this.r7_zero_threeyear = r7_zero_threeyear;
	}
	public BigDecimal getR8_national_amount() {
		return r8_national_amount;
	}
	public void setR8_national_amount(BigDecimal r8_national_amount) {
		this.r8_national_amount = r8_national_amount;
	}
	public BigDecimal getR8_gross_value() {
		return r8_gross_value;
	}
	public void setR8_gross_value(BigDecimal r8_gross_value) {
		this.r8_gross_value = r8_gross_value;
	}
	public BigDecimal getR8_residual_oneyear() {
		return r8_residual_oneyear;
	}
	public void setR8_residual_oneyear(BigDecimal r8_residual_oneyear) {
		this.r8_residual_oneyear = r8_residual_oneyear;
	}
	public BigDecimal getR8_residual_onetothree_year() {
		return r8_residual_onetothree_year;
	}
	public void setR8_residual_onetothree_year(BigDecimal r8_residual_onetothree_year) {
		this.r8_residual_onetothree_year = r8_residual_onetothree_year;
	}
	public BigDecimal getR8_residual_threeyear() {
		return r8_residual_threeyear;
	}
	public void setR8_residual_threeyear(BigDecimal r8_residual_threeyear) {
		this.r8_residual_threeyear = r8_residual_threeyear;
	}
	public BigDecimal getR8_tenper_oneyear() {
		return r8_tenper_oneyear;
	}
	public void setR8_tenper_oneyear(BigDecimal r8_tenper_oneyear) {
		this.r8_tenper_oneyear = r8_tenper_oneyear;
	}
	public BigDecimal getR8_minustenper_oneyear() {
		return r8_minustenper_oneyear;
	}
	public void setR8_minustenper_oneyear(BigDecimal r8_minustenper_oneyear) {
		this.r8_minustenper_oneyear = r8_minustenper_oneyear;
	}
	public BigDecimal getR8_tenper_onetothree_year() {
		return r8_tenper_onetothree_year;
	}
	public void setR8_tenper_onetothree_year(BigDecimal r8_tenper_onetothree_year) {
		this.r8_tenper_onetothree_year = r8_tenper_onetothree_year;
	}
	public BigDecimal getR8_minustenper_onetothree_year() {
		return r8_minustenper_onetothree_year;
	}
	public void setR8_minustenper_onetothree_year(BigDecimal r8_minustenper_onetothree_year) {
		this.r8_minustenper_onetothree_year = r8_minustenper_onetothree_year;
	}
	public BigDecimal getR8_tenper_threeyear() {
		return r8_tenper_threeyear;
	}
	public void setR8_tenper_threeyear(BigDecimal r8_tenper_threeyear) {
		this.r8_tenper_threeyear = r8_tenper_threeyear;
	}
	public BigDecimal getR8_zero_threeyear() {
		return r8_zero_threeyear;
	}
	public void setR8_zero_threeyear(BigDecimal r8_zero_threeyear) {
		this.r8_zero_threeyear = r8_zero_threeyear;
	}
	public BigDecimal getR9_national_amount() {
		return r9_national_amount;
	}
	public void setR9_national_amount(BigDecimal r9_national_amount) {
		this.r9_national_amount = r9_national_amount;
	}
	public BigDecimal getR9_gross_value() {
		return r9_gross_value;
	}
	public void setR9_gross_value(BigDecimal r9_gross_value) {
		this.r9_gross_value = r9_gross_value;
	}
	public BigDecimal getR9_residual_oneyear() {
		return r9_residual_oneyear;
	}
	public void setR9_residual_oneyear(BigDecimal r9_residual_oneyear) {
		this.r9_residual_oneyear = r9_residual_oneyear;
	}
	public BigDecimal getR9_residual_onetothree_year() {
		return r9_residual_onetothree_year;
	}
	public void setR9_residual_onetothree_year(BigDecimal r9_residual_onetothree_year) {
		this.r9_residual_onetothree_year = r9_residual_onetothree_year;
	}
	public BigDecimal getR9_residual_threeyear() {
		return r9_residual_threeyear;
	}
	public void setR9_residual_threeyear(BigDecimal r9_residual_threeyear) {
		this.r9_residual_threeyear = r9_residual_threeyear;
	}
	public BigDecimal getR9_tenper_oneyear() {
		return r9_tenper_oneyear;
	}
	public void setR9_tenper_oneyear(BigDecimal r9_tenper_oneyear) {
		this.r9_tenper_oneyear = r9_tenper_oneyear;
	}
	public BigDecimal getR9_minustenper_oneyear() {
		return r9_minustenper_oneyear;
	}
	public void setR9_minustenper_oneyear(BigDecimal r9_minustenper_oneyear) {
		this.r9_minustenper_oneyear = r9_minustenper_oneyear;
	}
	public BigDecimal getR9_tenper_onetothree_year() {
		return r9_tenper_onetothree_year;
	}
	public void setR9_tenper_onetothree_year(BigDecimal r9_tenper_onetothree_year) {
		this.r9_tenper_onetothree_year = r9_tenper_onetothree_year;
	}
	public BigDecimal getR9_minustenper_onetothree_year() {
		return r9_minustenper_onetothree_year;
	}
	public void setR9_minustenper_onetothree_year(BigDecimal r9_minustenper_onetothree_year) {
		this.r9_minustenper_onetothree_year = r9_minustenper_onetothree_year;
	}
	public BigDecimal getR9_tenper_threeyear() {
		return r9_tenper_threeyear;
	}
	public void setR9_tenper_threeyear(BigDecimal r9_tenper_threeyear) {
		this.r9_tenper_threeyear = r9_tenper_threeyear;
	}
	public BigDecimal getR9_zero_threeyear() {
		return r9_zero_threeyear;
	}
	public void setR9_zero_threeyear(BigDecimal r9_zero_threeyear) {
		this.r9_zero_threeyear = r9_zero_threeyear;
	}
	public BigDecimal getR10_national_amount() {
		return r10_national_amount;
	}
	public void setR10_national_amount(BigDecimal r10_national_amount) {
		this.r10_national_amount = r10_national_amount;
	}
	public BigDecimal getR10_gross_value() {
		return r10_gross_value;
	}
	public void setR10_gross_value(BigDecimal r10_gross_value) {
		this.r10_gross_value = r10_gross_value;
	}
	public BigDecimal getR10_residual_oneyear() {
		return r10_residual_oneyear;
	}
	public void setR10_residual_oneyear(BigDecimal r10_residual_oneyear) {
		this.r10_residual_oneyear = r10_residual_oneyear;
	}
	public BigDecimal getR10_residual_onetothree_year() {
		return r10_residual_onetothree_year;
	}
	public void setR10_residual_onetothree_year(BigDecimal r10_residual_onetothree_year) {
		this.r10_residual_onetothree_year = r10_residual_onetothree_year;
	}
	public BigDecimal getR10_residual_threeyear() {
		return r10_residual_threeyear;
	}
	public void setR10_residual_threeyear(BigDecimal r10_residual_threeyear) {
		this.r10_residual_threeyear = r10_residual_threeyear;
	}
	public BigDecimal getR10_tenper_oneyear() {
		return r10_tenper_oneyear;
	}
	public void setR10_tenper_oneyear(BigDecimal r10_tenper_oneyear) {
		this.r10_tenper_oneyear = r10_tenper_oneyear;
	}
	public BigDecimal getR10_minustenper_oneyear() {
		return r10_minustenper_oneyear;
	}
	public void setR10_minustenper_oneyear(BigDecimal r10_minustenper_oneyear) {
		this.r10_minustenper_oneyear = r10_minustenper_oneyear;
	}
	public BigDecimal getR10_tenper_onetothree_year() {
		return r10_tenper_onetothree_year;
	}
	public void setR10_tenper_onetothree_year(BigDecimal r10_tenper_onetothree_year) {
		this.r10_tenper_onetothree_year = r10_tenper_onetothree_year;
	}
	public BigDecimal getR10_minustenper_onetothree_year() {
		return r10_minustenper_onetothree_year;
	}
	public void setR10_minustenper_onetothree_year(BigDecimal r10_minustenper_onetothree_year) {
		this.r10_minustenper_onetothree_year = r10_minustenper_onetothree_year;
	}
	public BigDecimal getR10_tenper_threeyear() {
		return r10_tenper_threeyear;
	}
	public void setR10_tenper_threeyear(BigDecimal r10_tenper_threeyear) {
		this.r10_tenper_threeyear = r10_tenper_threeyear;
	}
	public BigDecimal getR10_zero_threeyear() {
		return r10_zero_threeyear;
	}
	public void setR10_zero_threeyear(BigDecimal r10_zero_threeyear) {
		this.r10_zero_threeyear = r10_zero_threeyear;
	}
	public BigDecimal getR11_national_amount() {
		return r11_national_amount;
	}
	public void setR11_national_amount(BigDecimal r11_national_amount) {
		this.r11_national_amount = r11_national_amount;
	}
	public BigDecimal getR11_gross_value() {
		return r11_gross_value;
	}
	public void setR11_gross_value(BigDecimal r11_gross_value) {
		this.r11_gross_value = r11_gross_value;
	}
	public BigDecimal getR11_residual_oneyear() {
		return r11_residual_oneyear;
	}
	public void setR11_residual_oneyear(BigDecimal r11_residual_oneyear) {
		this.r11_residual_oneyear = r11_residual_oneyear;
	}
	public BigDecimal getR11_residual_onetothree_year() {
		return r11_residual_onetothree_year;
	}
	public void setR11_residual_onetothree_year(BigDecimal r11_residual_onetothree_year) {
		this.r11_residual_onetothree_year = r11_residual_onetothree_year;
	}
	public BigDecimal getR11_residual_threeyear() {
		return r11_residual_threeyear;
	}
	public void setR11_residual_threeyear(BigDecimal r11_residual_threeyear) {
		this.r11_residual_threeyear = r11_residual_threeyear;
	}
	public BigDecimal getR11_tenper_oneyear() {
		return r11_tenper_oneyear;
	}
	public void setR11_tenper_oneyear(BigDecimal r11_tenper_oneyear) {
		this.r11_tenper_oneyear = r11_tenper_oneyear;
	}
	public BigDecimal getR11_minustenper_oneyear() {
		return r11_minustenper_oneyear;
	}
	public void setR11_minustenper_oneyear(BigDecimal r11_minustenper_oneyear) {
		this.r11_minustenper_oneyear = r11_minustenper_oneyear;
	}
	public BigDecimal getR11_tenper_onetothree_year() {
		return r11_tenper_onetothree_year;
	}
	public void setR11_tenper_onetothree_year(BigDecimal r11_tenper_onetothree_year) {
		this.r11_tenper_onetothree_year = r11_tenper_onetothree_year;
	}
	public BigDecimal getR11_minustenper_onetothree_year() {
		return r11_minustenper_onetothree_year;
	}
	public void setR11_minustenper_onetothree_year(BigDecimal r11_minustenper_onetothree_year) {
		this.r11_minustenper_onetothree_year = r11_minustenper_onetothree_year;
	}
	public BigDecimal getR11_tenper_threeyear() {
		return r11_tenper_threeyear;
	}
	public void setR11_tenper_threeyear(BigDecimal r11_tenper_threeyear) {
		this.r11_tenper_threeyear = r11_tenper_threeyear;
	}
	public BigDecimal getR11_zero_threeyear() {
		return r11_zero_threeyear;
	}
	public void setR11_zero_threeyear(BigDecimal r11_zero_threeyear) {
		this.r11_zero_threeyear = r11_zero_threeyear;
	}
	public BigDecimal getR12_national_amount() {
		return r12_national_amount;
	}
	public void setR12_national_amount(BigDecimal r12_national_amount) {
		this.r12_national_amount = r12_national_amount;
	}
	public BigDecimal getR12_gross_value() {
		return r12_gross_value;
	}
	public void setR12_gross_value(BigDecimal r12_gross_value) {
		this.r12_gross_value = r12_gross_value;
	}
	public BigDecimal getR12_residual_oneyear() {
		return r12_residual_oneyear;
	}
	public void setR12_residual_oneyear(BigDecimal r12_residual_oneyear) {
		this.r12_residual_oneyear = r12_residual_oneyear;
	}
	public BigDecimal getR12_residual_onetothree_year() {
		return r12_residual_onetothree_year;
	}
	public void setR12_residual_onetothree_year(BigDecimal r12_residual_onetothree_year) {
		this.r12_residual_onetothree_year = r12_residual_onetothree_year;
	}
	public BigDecimal getR12_residual_threeyear() {
		return r12_residual_threeyear;
	}
	public void setR12_residual_threeyear(BigDecimal r12_residual_threeyear) {
		this.r12_residual_threeyear = r12_residual_threeyear;
	}
	public BigDecimal getR12_tenper_oneyear() {
		return r12_tenper_oneyear;
	}
	public void setR12_tenper_oneyear(BigDecimal r12_tenper_oneyear) {
		this.r12_tenper_oneyear = r12_tenper_oneyear;
	}
	public BigDecimal getR12_minustenper_oneyear() {
		return r12_minustenper_oneyear;
	}
	public void setR12_minustenper_oneyear(BigDecimal r12_minustenper_oneyear) {
		this.r12_minustenper_oneyear = r12_minustenper_oneyear;
	}
	public BigDecimal getR12_tenper_onetothree_year() {
		return r12_tenper_onetothree_year;
	}
	public void setR12_tenper_onetothree_year(BigDecimal r12_tenper_onetothree_year) {
		this.r12_tenper_onetothree_year = r12_tenper_onetothree_year;
	}
	public BigDecimal getR12_minustenper_onetothree_year() {
		return r12_minustenper_onetothree_year;
	}
	public void setR12_minustenper_onetothree_year(BigDecimal r12_minustenper_onetothree_year) {
		this.r12_minustenper_onetothree_year = r12_minustenper_onetothree_year;
	}
	public BigDecimal getR12_tenper_threeyear() {
		return r12_tenper_threeyear;
	}
	public void setR12_tenper_threeyear(BigDecimal r12_tenper_threeyear) {
		this.r12_tenper_threeyear = r12_tenper_threeyear;
	}
	public BigDecimal getR12_zero_threeyear() {
		return r12_zero_threeyear;
	}
	public void setR12_zero_threeyear(BigDecimal r12_zero_threeyear) {
		this.r12_zero_threeyear = r12_zero_threeyear;
	}
	public BigDecimal getR13_national_amount() {
		return r13_national_amount;
	}
	public void setR13_national_amount(BigDecimal r13_national_amount) {
		this.r13_national_amount = r13_national_amount;
	}
	public BigDecimal getR13_gross_value() {
		return r13_gross_value;
	}
	public void setR13_gross_value(BigDecimal r13_gross_value) {
		this.r13_gross_value = r13_gross_value;
	}
	public BigDecimal getR13_residual_oneyear() {
		return r13_residual_oneyear;
	}
	public void setR13_residual_oneyear(BigDecimal r13_residual_oneyear) {
		this.r13_residual_oneyear = r13_residual_oneyear;
	}
	public BigDecimal getR13_residual_onetothree_year() {
		return r13_residual_onetothree_year;
	}
	public void setR13_residual_onetothree_year(BigDecimal r13_residual_onetothree_year) {
		this.r13_residual_onetothree_year = r13_residual_onetothree_year;
	}
	public BigDecimal getR13_residual_threeyear() {
		return r13_residual_threeyear;
	}
	public void setR13_residual_threeyear(BigDecimal r13_residual_threeyear) {
		this.r13_residual_threeyear = r13_residual_threeyear;
	}
	public BigDecimal getR13_tenper_oneyear() {
		return r13_tenper_oneyear;
	}
	public void setR13_tenper_oneyear(BigDecimal r13_tenper_oneyear) {
		this.r13_tenper_oneyear = r13_tenper_oneyear;
	}
	public BigDecimal getR13_minustenper_oneyear() {
		return r13_minustenper_oneyear;
	}
	public void setR13_minustenper_oneyear(BigDecimal r13_minustenper_oneyear) {
		this.r13_minustenper_oneyear = r13_minustenper_oneyear;
	}
	public BigDecimal getR13_tenper_onetothree_year() {
		return r13_tenper_onetothree_year;
	}
	public void setR13_tenper_onetothree_year(BigDecimal r13_tenper_onetothree_year) {
		this.r13_tenper_onetothree_year = r13_tenper_onetothree_year;
	}
	public BigDecimal getR13_minustenper_onetothree_year() {
		return r13_minustenper_onetothree_year;
	}
	public void setR13_minustenper_onetothree_year(BigDecimal r13_minustenper_onetothree_year) {
		this.r13_minustenper_onetothree_year = r13_minustenper_onetothree_year;
	}
	public BigDecimal getR13_tenper_threeyear() {
		return r13_tenper_threeyear;
	}
	public void setR13_tenper_threeyear(BigDecimal r13_tenper_threeyear) {
		this.r13_tenper_threeyear = r13_tenper_threeyear;
	}
	public BigDecimal getR13_zero_threeyear() {
		return r13_zero_threeyear;
	}
	public void setR13_zero_threeyear(BigDecimal r13_zero_threeyear) {
		this.r13_zero_threeyear = r13_zero_threeyear;
	}
	public BigDecimal getR14_national_amount() {
		return r14_national_amount;
	}
	public void setR14_national_amount(BigDecimal r14_national_amount) {
		this.r14_national_amount = r14_national_amount;
	}
	public BigDecimal getR14_gross_value() {
		return r14_gross_value;
	}
	public void setR14_gross_value(BigDecimal r14_gross_value) {
		this.r14_gross_value = r14_gross_value;
	}
	public BigDecimal getR14_residual_oneyear() {
		return r14_residual_oneyear;
	}
	public void setR14_residual_oneyear(BigDecimal r14_residual_oneyear) {
		this.r14_residual_oneyear = r14_residual_oneyear;
	}
	public BigDecimal getR14_residual_onetothree_year() {
		return r14_residual_onetothree_year;
	}
	public void setR14_residual_onetothree_year(BigDecimal r14_residual_onetothree_year) {
		this.r14_residual_onetothree_year = r14_residual_onetothree_year;
	}
	public BigDecimal getR14_residual_threeyear() {
		return r14_residual_threeyear;
	}
	public void setR14_residual_threeyear(BigDecimal r14_residual_threeyear) {
		this.r14_residual_threeyear = r14_residual_threeyear;
	}
	public BigDecimal getR14_tenper_oneyear() {
		return r14_tenper_oneyear;
	}
	public void setR14_tenper_oneyear(BigDecimal r14_tenper_oneyear) {
		this.r14_tenper_oneyear = r14_tenper_oneyear;
	}
	public BigDecimal getR14_minustenper_oneyear() {
		return r14_minustenper_oneyear;
	}
	public void setR14_minustenper_oneyear(BigDecimal r14_minustenper_oneyear) {
		this.r14_minustenper_oneyear = r14_minustenper_oneyear;
	}
	public BigDecimal getR14_tenper_onetothree_year() {
		return r14_tenper_onetothree_year;
	}
	public void setR14_tenper_onetothree_year(BigDecimal r14_tenper_onetothree_year) {
		this.r14_tenper_onetothree_year = r14_tenper_onetothree_year;
	}
	public BigDecimal getR14_minustenper_onetothree_year() {
		return r14_minustenper_onetothree_year;
	}
	public void setR14_minustenper_onetothree_year(BigDecimal r14_minustenper_onetothree_year) {
		this.r14_minustenper_onetothree_year = r14_minustenper_onetothree_year;
	}
	public BigDecimal getR14_tenper_threeyear() {
		return r14_tenper_threeyear;
	}
	public void setR14_tenper_threeyear(BigDecimal r14_tenper_threeyear) {
		this.r14_tenper_threeyear = r14_tenper_threeyear;
	}
	public BigDecimal getR14_zero_threeyear() {
		return r14_zero_threeyear;
	}
	public void setR14_zero_threeyear(BigDecimal r14_zero_threeyear) {
		this.r14_zero_threeyear = r14_zero_threeyear;
	}
	public BigDecimal getR15_national_amount() {
		return r15_national_amount;
	}
	public void setR15_national_amount(BigDecimal r15_national_amount) {
		this.r15_national_amount = r15_national_amount;
	}
	public BigDecimal getR15_gross_value() {
		return r15_gross_value;
	}
	public void setR15_gross_value(BigDecimal r15_gross_value) {
		this.r15_gross_value = r15_gross_value;
	}
	public BigDecimal getR15_residual_oneyear() {
		return r15_residual_oneyear;
	}
	public void setR15_residual_oneyear(BigDecimal r15_residual_oneyear) {
		this.r15_residual_oneyear = r15_residual_oneyear;
	}
	public BigDecimal getR15_residual_onetothree_year() {
		return r15_residual_onetothree_year;
	}
	public void setR15_residual_onetothree_year(BigDecimal r15_residual_onetothree_year) {
		this.r15_residual_onetothree_year = r15_residual_onetothree_year;
	}
	public BigDecimal getR15_residual_threeyear() {
		return r15_residual_threeyear;
	}
	public void setR15_residual_threeyear(BigDecimal r15_residual_threeyear) {
		this.r15_residual_threeyear = r15_residual_threeyear;
	}
	public BigDecimal getR15_tenper_oneyear() {
		return r15_tenper_oneyear;
	}
	public void setR15_tenper_oneyear(BigDecimal r15_tenper_oneyear) {
		this.r15_tenper_oneyear = r15_tenper_oneyear;
	}
	public BigDecimal getR15_minustenper_oneyear() {
		return r15_minustenper_oneyear;
	}
	public void setR15_minustenper_oneyear(BigDecimal r15_minustenper_oneyear) {
		this.r15_minustenper_oneyear = r15_minustenper_oneyear;
	}
	public BigDecimal getR15_tenper_onetothree_year() {
		return r15_tenper_onetothree_year;
	}
	public void setR15_tenper_onetothree_year(BigDecimal r15_tenper_onetothree_year) {
		this.r15_tenper_onetothree_year = r15_tenper_onetothree_year;
	}
	public BigDecimal getR15_minustenper_onetothree_year() {
		return r15_minustenper_onetothree_year;
	}
	public void setR15_minustenper_onetothree_year(BigDecimal r15_minustenper_onetothree_year) {
		this.r15_minustenper_onetothree_year = r15_minustenper_onetothree_year;
	}
	public BigDecimal getR15_tenper_threeyear() {
		return r15_tenper_threeyear;
	}
	public void setR15_tenper_threeyear(BigDecimal r15_tenper_threeyear) {
		this.r15_tenper_threeyear = r15_tenper_threeyear;
	}
	public BigDecimal getR15_zero_threeyear() {
		return r15_zero_threeyear;
	}
	public void setR15_zero_threeyear(BigDecimal r15_zero_threeyear) {
		this.r15_zero_threeyear = r15_zero_threeyear;
	}
	public BigDecimal getR16_national_amount() {
		return r16_national_amount;
	}
	public void setR16_national_amount(BigDecimal r16_national_amount) {
		this.r16_national_amount = r16_national_amount;
	}
	public BigDecimal getR16_gross_value() {
		return r16_gross_value;
	}
	public void setR16_gross_value(BigDecimal r16_gross_value) {
		this.r16_gross_value = r16_gross_value;
	}
	public BigDecimal getR16_residual_oneyear() {
		return r16_residual_oneyear;
	}
	public void setR16_residual_oneyear(BigDecimal r16_residual_oneyear) {
		this.r16_residual_oneyear = r16_residual_oneyear;
	}
	public BigDecimal getR16_residual_onetothree_year() {
		return r16_residual_onetothree_year;
	}
	public void setR16_residual_onetothree_year(BigDecimal r16_residual_onetothree_year) {
		this.r16_residual_onetothree_year = r16_residual_onetothree_year;
	}
	public BigDecimal getR16_residual_threeyear() {
		return r16_residual_threeyear;
	}
	public void setR16_residual_threeyear(BigDecimal r16_residual_threeyear) {
		this.r16_residual_threeyear = r16_residual_threeyear;
	}
	public BigDecimal getR16_tenper_oneyear() {
		return r16_tenper_oneyear;
	}
	public void setR16_tenper_oneyear(BigDecimal r16_tenper_oneyear) {
		this.r16_tenper_oneyear = r16_tenper_oneyear;
	}
	public BigDecimal getR16_minustenper_oneyear() {
		return r16_minustenper_oneyear;
	}
	public void setR16_minustenper_oneyear(BigDecimal r16_minustenper_oneyear) {
		this.r16_minustenper_oneyear = r16_minustenper_oneyear;
	}
	public BigDecimal getR16_tenper_onetothree_year() {
		return r16_tenper_onetothree_year;
	}
	public void setR16_tenper_onetothree_year(BigDecimal r16_tenper_onetothree_year) {
		this.r16_tenper_onetothree_year = r16_tenper_onetothree_year;
	}
	public BigDecimal getR16_minustenper_onetothree_year() {
		return r16_minustenper_onetothree_year;
	}
	public void setR16_minustenper_onetothree_year(BigDecimal r16_minustenper_onetothree_year) {
		this.r16_minustenper_onetothree_year = r16_minustenper_onetothree_year;
	}
	public BigDecimal getR16_tenper_threeyear() {
		return r16_tenper_threeyear;
	}
	public void setR16_tenper_threeyear(BigDecimal r16_tenper_threeyear) {
		this.r16_tenper_threeyear = r16_tenper_threeyear;
	}
	public BigDecimal getR16_zero_threeyear() {
		return r16_zero_threeyear;
	}
	public void setR16_zero_threeyear(BigDecimal r16_zero_threeyear) {
		this.r16_zero_threeyear = r16_zero_threeyear;
	}
	public BigDecimal getR17_national_amount() {
		return r17_national_amount;
	}
	public void setR17_national_amount(BigDecimal r17_national_amount) {
		this.r17_national_amount = r17_national_amount;
	}
	public BigDecimal getR17_gross_value() {
		return r17_gross_value;
	}
	public void setR17_gross_value(BigDecimal r17_gross_value) {
		this.r17_gross_value = r17_gross_value;
	}
	public BigDecimal getR17_residual_oneyear() {
		return r17_residual_oneyear;
	}
	public void setR17_residual_oneyear(BigDecimal r17_residual_oneyear) {
		this.r17_residual_oneyear = r17_residual_oneyear;
	}
	public BigDecimal getR17_residual_onetothree_year() {
		return r17_residual_onetothree_year;
	}
	public void setR17_residual_onetothree_year(BigDecimal r17_residual_onetothree_year) {
		this.r17_residual_onetothree_year = r17_residual_onetothree_year;
	}
	public BigDecimal getR17_residual_threeyear() {
		return r17_residual_threeyear;
	}
	public void setR17_residual_threeyear(BigDecimal r17_residual_threeyear) {
		this.r17_residual_threeyear = r17_residual_threeyear;
	}
	public BigDecimal getR17_tenper_oneyear() {
		return r17_tenper_oneyear;
	}
	public void setR17_tenper_oneyear(BigDecimal r17_tenper_oneyear) {
		this.r17_tenper_oneyear = r17_tenper_oneyear;
	}
	public BigDecimal getR17_minustenper_oneyear() {
		return r17_minustenper_oneyear;
	}
	public void setR17_minustenper_oneyear(BigDecimal r17_minustenper_oneyear) {
		this.r17_minustenper_oneyear = r17_minustenper_oneyear;
	}
	public BigDecimal getR17_tenper_onetothree_year() {
		return r17_tenper_onetothree_year;
	}
	public void setR17_tenper_onetothree_year(BigDecimal r17_tenper_onetothree_year) {
		this.r17_tenper_onetothree_year = r17_tenper_onetothree_year;
	}
	public BigDecimal getR17_minustenper_onetothree_year() {
		return r17_minustenper_onetothree_year;
	}
	public void setR17_minustenper_onetothree_year(BigDecimal r17_minustenper_onetothree_year) {
		this.r17_minustenper_onetothree_year = r17_minustenper_onetothree_year;
	}
	public BigDecimal getR17_tenper_threeyear() {
		return r17_tenper_threeyear;
	}
	public void setR17_tenper_threeyear(BigDecimal r17_tenper_threeyear) {
		this.r17_tenper_threeyear = r17_tenper_threeyear;
	}
	public BigDecimal getR17_zero_threeyear() {
		return r17_zero_threeyear;
	}
	public void setR17_zero_threeyear(BigDecimal r17_zero_threeyear) {
		this.r17_zero_threeyear = r17_zero_threeyear;
	}
	public BigDecimal getR18_national_amount() {
		return r18_national_amount;
	}
	public void setR18_national_amount(BigDecimal r18_national_amount) {
		this.r18_national_amount = r18_national_amount;
	}
	public BigDecimal getR18_gross_value() {
		return r18_gross_value;
	}
	public void setR18_gross_value(BigDecimal r18_gross_value) {
		this.r18_gross_value = r18_gross_value;
	}
	public BigDecimal getR18_residual_oneyear() {
		return r18_residual_oneyear;
	}
	public void setR18_residual_oneyear(BigDecimal r18_residual_oneyear) {
		this.r18_residual_oneyear = r18_residual_oneyear;
	}
	public BigDecimal getR18_residual_onetothree_year() {
		return r18_residual_onetothree_year;
	}
	public void setR18_residual_onetothree_year(BigDecimal r18_residual_onetothree_year) {
		this.r18_residual_onetothree_year = r18_residual_onetothree_year;
	}
	public BigDecimal getR18_residual_threeyear() {
		return r18_residual_threeyear;
	}
	public void setR18_residual_threeyear(BigDecimal r18_residual_threeyear) {
		this.r18_residual_threeyear = r18_residual_threeyear;
	}
	public BigDecimal getR18_tenper_oneyear() {
		return r18_tenper_oneyear;
	}
	public void setR18_tenper_oneyear(BigDecimal r18_tenper_oneyear) {
		this.r18_tenper_oneyear = r18_tenper_oneyear;
	}
	public BigDecimal getR18_minustenper_oneyear() {
		return r18_minustenper_oneyear;
	}
	public void setR18_minustenper_oneyear(BigDecimal r18_minustenper_oneyear) {
		this.r18_minustenper_oneyear = r18_minustenper_oneyear;
	}
	public BigDecimal getR18_tenper_onetothree_year() {
		return r18_tenper_onetothree_year;
	}
	public void setR18_tenper_onetothree_year(BigDecimal r18_tenper_onetothree_year) {
		this.r18_tenper_onetothree_year = r18_tenper_onetothree_year;
	}
	public BigDecimal getR18_minustenper_onetothree_year() {
		return r18_minustenper_onetothree_year;
	}
	public void setR18_minustenper_onetothree_year(BigDecimal r18_minustenper_onetothree_year) {
		this.r18_minustenper_onetothree_year = r18_minustenper_onetothree_year;
	}
	public BigDecimal getR18_tenper_threeyear() {
		return r18_tenper_threeyear;
	}
	public void setR18_tenper_threeyear(BigDecimal r18_tenper_threeyear) {
		this.r18_tenper_threeyear = r18_tenper_threeyear;
	}
	public BigDecimal getR18_zero_threeyear() {
		return r18_zero_threeyear;
	}
	public void setR18_zero_threeyear(BigDecimal r18_zero_threeyear) {
		this.r18_zero_threeyear = r18_zero_threeyear;
	}
	public BigDecimal getR19_national_amount() {
		return r19_national_amount;
	}
	public void setR19_national_amount(BigDecimal r19_national_amount) {
		this.r19_national_amount = r19_national_amount;
	}
	public BigDecimal getR19_gross_value() {
		return r19_gross_value;
	}
	public void setR19_gross_value(BigDecimal r19_gross_value) {
		this.r19_gross_value = r19_gross_value;
	}
	public BigDecimal getR19_residual_oneyear() {
		return r19_residual_oneyear;
	}
	public void setR19_residual_oneyear(BigDecimal r19_residual_oneyear) {
		this.r19_residual_oneyear = r19_residual_oneyear;
	}
	public BigDecimal getR19_residual_onetothree_year() {
		return r19_residual_onetothree_year;
	}
	public void setR19_residual_onetothree_year(BigDecimal r19_residual_onetothree_year) {
		this.r19_residual_onetothree_year = r19_residual_onetothree_year;
	}
	public BigDecimal getR19_residual_threeyear() {
		return r19_residual_threeyear;
	}
	public void setR19_residual_threeyear(BigDecimal r19_residual_threeyear) {
		this.r19_residual_threeyear = r19_residual_threeyear;
	}
	public BigDecimal getR19_tenper_oneyear() {
		return r19_tenper_oneyear;
	}
	public void setR19_tenper_oneyear(BigDecimal r19_tenper_oneyear) {
		this.r19_tenper_oneyear = r19_tenper_oneyear;
	}
	public BigDecimal getR19_minustenper_oneyear() {
		return r19_minustenper_oneyear;
	}
	public void setR19_minustenper_oneyear(BigDecimal r19_minustenper_oneyear) {
		this.r19_minustenper_oneyear = r19_minustenper_oneyear;
	}
	public BigDecimal getR19_tenper_onetothree_year() {
		return r19_tenper_onetothree_year;
	}
	public void setR19_tenper_onetothree_year(BigDecimal r19_tenper_onetothree_year) {
		this.r19_tenper_onetothree_year = r19_tenper_onetothree_year;
	}
	public BigDecimal getR19_minustenper_onetothree_year() {
		return r19_minustenper_onetothree_year;
	}
	public void setR19_minustenper_onetothree_year(BigDecimal r19_minustenper_onetothree_year) {
		this.r19_minustenper_onetothree_year = r19_minustenper_onetothree_year;
	}
	public BigDecimal getR19_tenper_threeyear() {
		return r19_tenper_threeyear;
	}
	public void setR19_tenper_threeyear(BigDecimal r19_tenper_threeyear) {
		this.r19_tenper_threeyear = r19_tenper_threeyear;
	}
	public BigDecimal getR19_zero_threeyear() {
		return r19_zero_threeyear;
	}
	public void setR19_zero_threeyear(BigDecimal r19_zero_threeyear) {
		this.r19_zero_threeyear = r19_zero_threeyear;
	}
	public BigDecimal getR20_national_amount() {
		return r20_national_amount;
	}
	public void setR20_national_amount(BigDecimal r20_national_amount) {
		this.r20_national_amount = r20_national_amount;
	}
	public BigDecimal getR20_gross_value() {
		return r20_gross_value;
	}
	public void setR20_gross_value(BigDecimal r20_gross_value) {
		this.r20_gross_value = r20_gross_value;
	}
	public BigDecimal getR20_residual_oneyear() {
		return r20_residual_oneyear;
	}
	public void setR20_residual_oneyear(BigDecimal r20_residual_oneyear) {
		this.r20_residual_oneyear = r20_residual_oneyear;
	}
	public BigDecimal getR20_residual_onetothree_year() {
		return r20_residual_onetothree_year;
	}
	public void setR20_residual_onetothree_year(BigDecimal r20_residual_onetothree_year) {
		this.r20_residual_onetothree_year = r20_residual_onetothree_year;
	}
	public BigDecimal getR20_residual_threeyear() {
		return r20_residual_threeyear;
	}
	public void setR20_residual_threeyear(BigDecimal r20_residual_threeyear) {
		this.r20_residual_threeyear = r20_residual_threeyear;
	}
	public BigDecimal getR20_tenper_oneyear() {
		return r20_tenper_oneyear;
	}
	public void setR20_tenper_oneyear(BigDecimal r20_tenper_oneyear) {
		this.r20_tenper_oneyear = r20_tenper_oneyear;
	}
	public BigDecimal getR20_minustenper_oneyear() {
		return r20_minustenper_oneyear;
	}
	public void setR20_minustenper_oneyear(BigDecimal r20_minustenper_oneyear) {
		this.r20_minustenper_oneyear = r20_minustenper_oneyear;
	}
	public BigDecimal getR20_tenper_onetothree_year() {
		return r20_tenper_onetothree_year;
	}
	public void setR20_tenper_onetothree_year(BigDecimal r20_tenper_onetothree_year) {
		this.r20_tenper_onetothree_year = r20_tenper_onetothree_year;
	}
	public BigDecimal getR20_minustenper_onetothree_year() {
		return r20_minustenper_onetothree_year;
	}
	public void setR20_minustenper_onetothree_year(BigDecimal r20_minustenper_onetothree_year) {
		this.r20_minustenper_onetothree_year = r20_minustenper_onetothree_year;
	}
	public BigDecimal getR20_tenper_threeyear() {
		return r20_tenper_threeyear;
	}
	public void setR20_tenper_threeyear(BigDecimal r20_tenper_threeyear) {
		this.r20_tenper_threeyear = r20_tenper_threeyear;
	}
	public BigDecimal getR20_zero_threeyear() {
		return r20_zero_threeyear;
	}
	public void setR20_zero_threeyear(BigDecimal r20_zero_threeyear) {
		this.r20_zero_threeyear = r20_zero_threeyear;
	}
	public BigDecimal getR21_national_amount() {
		return r21_national_amount;
	}
	public void setR21_national_amount(BigDecimal r21_national_amount) {
		this.r21_national_amount = r21_national_amount;
	}
	public BigDecimal getR21_gross_value() {
		return r21_gross_value;
	}
	public void setR21_gross_value(BigDecimal r21_gross_value) {
		this.r21_gross_value = r21_gross_value;
	}
	public BigDecimal getR21_residual_oneyear() {
		return r21_residual_oneyear;
	}
	public void setR21_residual_oneyear(BigDecimal r21_residual_oneyear) {
		this.r21_residual_oneyear = r21_residual_oneyear;
	}
	public BigDecimal getR21_residual_onetothree_year() {
		return r21_residual_onetothree_year;
	}
	public void setR21_residual_onetothree_year(BigDecimal r21_residual_onetothree_year) {
		this.r21_residual_onetothree_year = r21_residual_onetothree_year;
	}
	public BigDecimal getR21_residual_threeyear() {
		return r21_residual_threeyear;
	}
	public void setR21_residual_threeyear(BigDecimal r21_residual_threeyear) {
		this.r21_residual_threeyear = r21_residual_threeyear;
	}
	public BigDecimal getR21_tenper_oneyear() {
		return r21_tenper_oneyear;
	}
	public void setR21_tenper_oneyear(BigDecimal r21_tenper_oneyear) {
		this.r21_tenper_oneyear = r21_tenper_oneyear;
	}
	public BigDecimal getR21_minustenper_oneyear() {
		return r21_minustenper_oneyear;
	}
	public void setR21_minustenper_oneyear(BigDecimal r21_minustenper_oneyear) {
		this.r21_minustenper_oneyear = r21_minustenper_oneyear;
	}
	public BigDecimal getR21_tenper_onetothree_year() {
		return r21_tenper_onetothree_year;
	}
	public void setR21_tenper_onetothree_year(BigDecimal r21_tenper_onetothree_year) {
		this.r21_tenper_onetothree_year = r21_tenper_onetothree_year;
	}
	public BigDecimal getR21_minustenper_onetothree_year() {
		return r21_minustenper_onetothree_year;
	}
	public void setR21_minustenper_onetothree_year(BigDecimal r21_minustenper_onetothree_year) {
		this.r21_minustenper_onetothree_year = r21_minustenper_onetothree_year;
	}
	public BigDecimal getR21_tenper_threeyear() {
		return r21_tenper_threeyear;
	}
	public void setR21_tenper_threeyear(BigDecimal r21_tenper_threeyear) {
		this.r21_tenper_threeyear = r21_tenper_threeyear;
	}
	public BigDecimal getR21_zero_threeyear() {
		return r21_zero_threeyear;
	}
	public void setR21_zero_threeyear(BigDecimal r21_zero_threeyear) {
		this.r21_zero_threeyear = r21_zero_threeyear;
	}
	public BigDecimal getR22_national_amount() {
		return r22_national_amount;
	}
	public void setR22_national_amount(BigDecimal r22_national_amount) {
		this.r22_national_amount = r22_national_amount;
	}
	public BigDecimal getR22_gross_value() {
		return r22_gross_value;
	}
	public void setR22_gross_value(BigDecimal r22_gross_value) {
		this.r22_gross_value = r22_gross_value;
	}
	public BigDecimal getR22_residual_oneyear() {
		return r22_residual_oneyear;
	}
	public void setR22_residual_oneyear(BigDecimal r22_residual_oneyear) {
		this.r22_residual_oneyear = r22_residual_oneyear;
	}
	public BigDecimal getR22_residual_onetothree_year() {
		return r22_residual_onetothree_year;
	}
	public void setR22_residual_onetothree_year(BigDecimal r22_residual_onetothree_year) {
		this.r22_residual_onetothree_year = r22_residual_onetothree_year;
	}
	public BigDecimal getR22_residual_threeyear() {
		return r22_residual_threeyear;
	}
	public void setR22_residual_threeyear(BigDecimal r22_residual_threeyear) {
		this.r22_residual_threeyear = r22_residual_threeyear;
	}
	public BigDecimal getR22_tenper_oneyear() {
		return r22_tenper_oneyear;
	}
	public void setR22_tenper_oneyear(BigDecimal r22_tenper_oneyear) {
		this.r22_tenper_oneyear = r22_tenper_oneyear;
	}
	public BigDecimal getR22_minustenper_oneyear() {
		return r22_minustenper_oneyear;
	}
	public void setR22_minustenper_oneyear(BigDecimal r22_minustenper_oneyear) {
		this.r22_minustenper_oneyear = r22_minustenper_oneyear;
	}
	public BigDecimal getR22_tenper_onetothree_year() {
		return r22_tenper_onetothree_year;
	}
	public void setR22_tenper_onetothree_year(BigDecimal r22_tenper_onetothree_year) {
		this.r22_tenper_onetothree_year = r22_tenper_onetothree_year;
	}
	public BigDecimal getR22_minustenper_onetothree_year() {
		return r22_minustenper_onetothree_year;
	}
	public void setR22_minustenper_onetothree_year(BigDecimal r22_minustenper_onetothree_year) {
		this.r22_minustenper_onetothree_year = r22_minustenper_onetothree_year;
	}
	public BigDecimal getR22_tenper_threeyear() {
		return r22_tenper_threeyear;
	}
	public void setR22_tenper_threeyear(BigDecimal r22_tenper_threeyear) {
		this.r22_tenper_threeyear = r22_tenper_threeyear;
	}
	public BigDecimal getR22_zero_threeyear() {
		return r22_zero_threeyear;
	}
	public void setR22_zero_threeyear(BigDecimal r22_zero_threeyear) {
		this.r22_zero_threeyear = r22_zero_threeyear;
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
	public BRF152_Entity() {
		super();
		// TODO Auto-generated constructor stub
	}
}