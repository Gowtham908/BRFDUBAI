package com.bornfire.xbrl.entities.BRBS;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "BRF71_SUMMARYTABLE")
public class BRF71_ENTITY {
	private String r1_product;
	private BigDecimal r1_visa;
	private BigDecimal r1_mastercard;
	private BigDecimal r1_amex;
	private BigDecimal r1_jcb;
	private BigDecimal r1_diners;
	private BigDecimal r1_unionpay;
	private BigDecimal r1_total;
	private String r2_product;
	private BigDecimal r2_visa;
	private BigDecimal r2_mastercard;
	private BigDecimal r2_amex;
	private BigDecimal r2_jcb;
	private BigDecimal r2_diners;
	private BigDecimal r2_unionpay;
	private BigDecimal r2_total;
	private String r3_product;
	private BigDecimal r3_visa;
	private BigDecimal r3_mastercard;
	private BigDecimal r3_amex;
	private BigDecimal r3_jcb;
	private BigDecimal r3_diners;
	private BigDecimal r3_unionpay;
	private BigDecimal r3_total;
	private String r4_product;
	private BigDecimal r4_visa;
	private BigDecimal r4_mastercard;
	private BigDecimal r4_amex;
	private BigDecimal r4_jcb;
	private BigDecimal r4_diners;
	private BigDecimal r4_unionpay;
	private BigDecimal r4_total;
	private String r5_product;
	private BigDecimal r5_visa;
	private BigDecimal r5_mastercard;
	private BigDecimal r5_amex;
	private BigDecimal r5_jcb;
	private BigDecimal r5_diners;
	private BigDecimal r5_unionpay;
	private BigDecimal r5_total;
	private String r6_product;
	private BigDecimal r6_visa;
	private BigDecimal r6_mastercard;
	private BigDecimal r6_amex;
	private BigDecimal r6_jcb;
	private BigDecimal r6_diners;
	private BigDecimal r6_unionpay;
	private BigDecimal r6_total;
	private String r7_product;
	private BigDecimal r7_visa;
	private BigDecimal r7_mastercard;
	private BigDecimal r7_amex;
	private BigDecimal r7_jcb;
	private BigDecimal r7_diners;
	private BigDecimal r7_unionpay;
	private BigDecimal r7_total;
	private String r8_product;
	private BigDecimal r8_visa;
	private BigDecimal r8_mastercard;
	private BigDecimal r8_amex;
	private BigDecimal r8_jcb;
	private BigDecimal r8_diners;
	private BigDecimal r8_unionpay;
	private BigDecimal r8_total;
	private String r9_product;
	private BigDecimal r9_visa;
	private BigDecimal r9_mastercard;
	private BigDecimal r9_amex;
	private BigDecimal r9_jcb;
	private BigDecimal r9_diners;
	private BigDecimal r9_unionpay;
	private BigDecimal r9_total;
	private String r10_product;
	private BigDecimal r10_visa;
	private BigDecimal r10_mastercard;
	private BigDecimal r10_amex;
	private BigDecimal r10_jcb;
	private BigDecimal r10_diners;
	private BigDecimal r10_unionpay;
	private BigDecimal r10_total;
	private String r11_product;
	private BigDecimal r11_visa;
	private BigDecimal r11_mastercard;
	private BigDecimal r11_amex;
	private BigDecimal r11_jcb;
	private BigDecimal r11_diners;
	private BigDecimal r11_unionpay;
	private BigDecimal r11_total;
	private String r12_product;
	private BigDecimal r12_visa;
	private BigDecimal r12_mastercard;
	private BigDecimal r12_amex;
	private BigDecimal r12_jcb;
	private BigDecimal r12_diners;
	private BigDecimal r12_unionpay;
	private BigDecimal r12_total;
	private String r15_product;
	private String r16_product;
	private String r16_jcb;
	private String r17_product;
	private String r17_jcb;

	@Id
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date report_date;
	private Date report_from_date;
	private Date report_to_date;
	private String entity_flg;
	private String modify_flg;
	private String del_flg;
	private String report_code;
	private Date report_submit_date;
	private String entry_user;
	private String modify_user;
	private String verify_user;
	private Date entry_time;
	private Date modify_time;
	private Date verify_time;
	private String repdesc;
	private String frequency;
	public String getR1_product() {
		return r1_product;
	}
	public void setR1_product(String r1_product) {
		this.r1_product = r1_product;
	}
	public BigDecimal getR1_visa() {
		return r1_visa;
	}
	public void setR1_visa(BigDecimal r1_visa) {
		this.r1_visa = r1_visa;
	}
	public BigDecimal getR1_mastercard() {
		return r1_mastercard;
	}
	public void setR1_mastercard(BigDecimal r1_mastercard) {
		this.r1_mastercard = r1_mastercard;
	}
	public BigDecimal getR1_amex() {
		return r1_amex;
	}
	public void setR1_amex(BigDecimal r1_amex) {
		this.r1_amex = r1_amex;
	}
	public BigDecimal getR1_jcb() {
		return r1_jcb;
	}
	public void setR1_jcb(BigDecimal r1_jcb) {
		this.r1_jcb = r1_jcb;
	}
	public BigDecimal getR1_diners() {
		return r1_diners;
	}
	public void setR1_diners(BigDecimal r1_diners) {
		this.r1_diners = r1_diners;
	}
	public BigDecimal getR1_unionpay() {
		return r1_unionpay;
	}
	public void setR1_unionpay(BigDecimal r1_unionpay) {
		this.r1_unionpay = r1_unionpay;
	}
	public BigDecimal getR1_total() {
		return r1_total;
	}
	public void setR1_total(BigDecimal r1_total) {
		this.r1_total = r1_total;
	}
	public String getR2_product() {
		return r2_product;
	}
	public void setR2_product(String r2_product) {
		this.r2_product = r2_product;
	}
	public BigDecimal getR2_visa() {
		return r2_visa;
	}
	public void setR2_visa(BigDecimal r2_visa) {
		this.r2_visa = r2_visa;
	}
	public BigDecimal getR2_mastercard() {
		return r2_mastercard;
	}
	public void setR2_mastercard(BigDecimal r2_mastercard) {
		this.r2_mastercard = r2_mastercard;
	}
	public BigDecimal getR2_amex() {
		return r2_amex;
	}
	public void setR2_amex(BigDecimal r2_amex) {
		this.r2_amex = r2_amex;
	}
	public BigDecimal getR2_jcb() {
		return r2_jcb;
	}
	public void setR2_jcb(BigDecimal r2_jcb) {
		this.r2_jcb = r2_jcb;
	}
	public BigDecimal getR2_diners() {
		return r2_diners;
	}
	public void setR2_diners(BigDecimal r2_diners) {
		this.r2_diners = r2_diners;
	}
	public BigDecimal getR2_unionpay() {
		return r2_unionpay;
	}
	public void setR2_unionpay(BigDecimal r2_unionpay) {
		this.r2_unionpay = r2_unionpay;
	}
	public BigDecimal getR2_total() {
		return r2_total;
	}
	public void setR2_total(BigDecimal r2_total) {
		this.r2_total = r2_total;
	}
	public String getR3_product() {
		return r3_product;
	}
	public void setR3_product(String r3_product) {
		this.r3_product = r3_product;
	}
	public BigDecimal getR3_visa() {
		return r3_visa;
	}
	public void setR3_visa(BigDecimal r3_visa) {
		this.r3_visa = r3_visa;
	}
	public BigDecimal getR3_mastercard() {
		return r3_mastercard;
	}
	public void setR3_mastercard(BigDecimal r3_mastercard) {
		this.r3_mastercard = r3_mastercard;
	}
	public BigDecimal getR3_amex() {
		return r3_amex;
	}
	public void setR3_amex(BigDecimal r3_amex) {
		this.r3_amex = r3_amex;
	}
	public BigDecimal getR3_jcb() {
		return r3_jcb;
	}
	public void setR3_jcb(BigDecimal r3_jcb) {
		this.r3_jcb = r3_jcb;
	}
	public BigDecimal getR3_diners() {
		return r3_diners;
	}
	public void setR3_diners(BigDecimal r3_diners) {
		this.r3_diners = r3_diners;
	}
	public BigDecimal getR3_unionpay() {
		return r3_unionpay;
	}
	public void setR3_unionpay(BigDecimal r3_unionpay) {
		this.r3_unionpay = r3_unionpay;
	}
	public BigDecimal getR3_total() {
		return r3_total;
	}
	public void setR3_total(BigDecimal r3_total) {
		this.r3_total = r3_total;
	}
	public String getR4_product() {
		return r4_product;
	}
	public void setR4_product(String r4_product) {
		this.r4_product = r4_product;
	}
	public BigDecimal getR4_visa() {
		return r4_visa;
	}
	public void setR4_visa(BigDecimal r4_visa) {
		this.r4_visa = r4_visa;
	}
	public BigDecimal getR4_mastercard() {
		return r4_mastercard;
	}
	public void setR4_mastercard(BigDecimal r4_mastercard) {
		this.r4_mastercard = r4_mastercard;
	}
	public BigDecimal getR4_amex() {
		return r4_amex;
	}
	public void setR4_amex(BigDecimal r4_amex) {
		this.r4_amex = r4_amex;
	}
	public BigDecimal getR4_jcb() {
		return r4_jcb;
	}
	public void setR4_jcb(BigDecimal r4_jcb) {
		this.r4_jcb = r4_jcb;
	}
	public BigDecimal getR4_diners() {
		return r4_diners;
	}
	public void setR4_diners(BigDecimal r4_diners) {
		this.r4_diners = r4_diners;
	}
	public BigDecimal getR4_unionpay() {
		return r4_unionpay;
	}
	public void setR4_unionpay(BigDecimal r4_unionpay) {
		this.r4_unionpay = r4_unionpay;
	}
	public BigDecimal getR4_total() {
		return r4_total;
	}
	public void setR4_total(BigDecimal r4_total) {
		this.r4_total = r4_total;
	}
	public String getR5_product() {
		return r5_product;
	}
	public void setR5_product(String r5_product) {
		this.r5_product = r5_product;
	}
	public BigDecimal getR5_visa() {
		return r5_visa;
	}
	public void setR5_visa(BigDecimal r5_visa) {
		this.r5_visa = r5_visa;
	}
	public BigDecimal getR5_mastercard() {
		return r5_mastercard;
	}
	public void setR5_mastercard(BigDecimal r5_mastercard) {
		this.r5_mastercard = r5_mastercard;
	}
	public BigDecimal getR5_amex() {
		return r5_amex;
	}
	public void setR5_amex(BigDecimal r5_amex) {
		this.r5_amex = r5_amex;
	}
	public BigDecimal getR5_jcb() {
		return r5_jcb;
	}
	public void setR5_jcb(BigDecimal r5_jcb) {
		this.r5_jcb = r5_jcb;
	}
	public BigDecimal getR5_diners() {
		return r5_diners;
	}
	public void setR5_diners(BigDecimal r5_diners) {
		this.r5_diners = r5_diners;
	}
	public BigDecimal getR5_unionpay() {
		return r5_unionpay;
	}
	public void setR5_unionpay(BigDecimal r5_unionpay) {
		this.r5_unionpay = r5_unionpay;
	}
	public BigDecimal getR5_total() {
		return r5_total;
	}
	public void setR5_total(BigDecimal r5_total) {
		this.r5_total = r5_total;
	}
	public String getR6_product() {
		return r6_product;
	}
	public void setR6_product(String r6_product) {
		this.r6_product = r6_product;
	}
	public BigDecimal getR6_visa() {
		return r6_visa;
	}
	public void setR6_visa(BigDecimal r6_visa) {
		this.r6_visa = r6_visa;
	}
	public BigDecimal getR6_mastercard() {
		return r6_mastercard;
	}
	public void setR6_mastercard(BigDecimal r6_mastercard) {
		this.r6_mastercard = r6_mastercard;
	}
	public BigDecimal getR6_amex() {
		return r6_amex;
	}
	public void setR6_amex(BigDecimal r6_amex) {
		this.r6_amex = r6_amex;
	}
	public BigDecimal getR6_jcb() {
		return r6_jcb;
	}
	public void setR6_jcb(BigDecimal r6_jcb) {
		this.r6_jcb = r6_jcb;
	}
	public BigDecimal getR6_diners() {
		return r6_diners;
	}
	public void setR6_diners(BigDecimal r6_diners) {
		this.r6_diners = r6_diners;
	}
	public BigDecimal getR6_unionpay() {
		return r6_unionpay;
	}
	public void setR6_unionpay(BigDecimal r6_unionpay) {
		this.r6_unionpay = r6_unionpay;
	}
	public BigDecimal getR6_total() {
		return r6_total;
	}
	public void setR6_total(BigDecimal r6_total) {
		this.r6_total = r6_total;
	}
	public String getR7_product() {
		return r7_product;
	}
	public void setR7_product(String r7_product) {
		this.r7_product = r7_product;
	}
	public BigDecimal getR7_visa() {
		return r7_visa;
	}
	public void setR7_visa(BigDecimal r7_visa) {
		this.r7_visa = r7_visa;
	}
	public BigDecimal getR7_mastercard() {
		return r7_mastercard;
	}
	public void setR7_mastercard(BigDecimal r7_mastercard) {
		this.r7_mastercard = r7_mastercard;
	}
	public BigDecimal getR7_amex() {
		return r7_amex;
	}
	public void setR7_amex(BigDecimal r7_amex) {
		this.r7_amex = r7_amex;
	}
	public BigDecimal getR7_jcb() {
		return r7_jcb;
	}
	public void setR7_jcb(BigDecimal r7_jcb) {
		this.r7_jcb = r7_jcb;
	}
	public BigDecimal getR7_diners() {
		return r7_diners;
	}
	public void setR7_diners(BigDecimal r7_diners) {
		this.r7_diners = r7_diners;
	}
	public BigDecimal getR7_unionpay() {
		return r7_unionpay;
	}
	public void setR7_unionpay(BigDecimal r7_unionpay) {
		this.r7_unionpay = r7_unionpay;
	}
	public BigDecimal getR7_total() {
		return r7_total;
	}
	public void setR7_total(BigDecimal r7_total) {
		this.r7_total = r7_total;
	}
	public String getR8_product() {
		return r8_product;
	}
	public void setR8_product(String r8_product) {
		this.r8_product = r8_product;
	}
	public BigDecimal getR8_visa() {
		return r8_visa;
	}
	public void setR8_visa(BigDecimal r8_visa) {
		this.r8_visa = r8_visa;
	}
	public BigDecimal getR8_mastercard() {
		return r8_mastercard;
	}
	public void setR8_mastercard(BigDecimal r8_mastercard) {
		this.r8_mastercard = r8_mastercard;
	}
	public BigDecimal getR8_amex() {
		return r8_amex;
	}
	public void setR8_amex(BigDecimal r8_amex) {
		this.r8_amex = r8_amex;
	}
	public BigDecimal getR8_jcb() {
		return r8_jcb;
	}
	public void setR8_jcb(BigDecimal r8_jcb) {
		this.r8_jcb = r8_jcb;
	}
	public BigDecimal getR8_diners() {
		return r8_diners;
	}
	public void setR8_diners(BigDecimal r8_diners) {
		this.r8_diners = r8_diners;
	}
	public BigDecimal getR8_unionpay() {
		return r8_unionpay;
	}
	public void setR8_unionpay(BigDecimal r8_unionpay) {
		this.r8_unionpay = r8_unionpay;
	}
	public BigDecimal getR8_total() {
		return r8_total;
	}
	public void setR8_total(BigDecimal r8_total) {
		this.r8_total = r8_total;
	}
	public String getR9_product() {
		return r9_product;
	}
	public void setR9_product(String r9_product) {
		this.r9_product = r9_product;
	}
	public BigDecimal getR9_visa() {
		return r9_visa;
	}
	public void setR9_visa(BigDecimal r9_visa) {
		this.r9_visa = r9_visa;
	}
	public BigDecimal getR9_mastercard() {
		return r9_mastercard;
	}
	public void setR9_mastercard(BigDecimal r9_mastercard) {
		this.r9_mastercard = r9_mastercard;
	}
	public BigDecimal getR9_amex() {
		return r9_amex;
	}
	public void setR9_amex(BigDecimal r9_amex) {
		this.r9_amex = r9_amex;
	}
	public BigDecimal getR9_jcb() {
		return r9_jcb;
	}
	public void setR9_jcb(BigDecimal r9_jcb) {
		this.r9_jcb = r9_jcb;
	}
	public BigDecimal getR9_diners() {
		return r9_diners;
	}
	public void setR9_diners(BigDecimal r9_diners) {
		this.r9_diners = r9_diners;
	}
	public BigDecimal getR9_unionpay() {
		return r9_unionpay;
	}
	public void setR9_unionpay(BigDecimal r9_unionpay) {
		this.r9_unionpay = r9_unionpay;
	}
	public BigDecimal getR9_total() {
		return r9_total;
	}
	public void setR9_total(BigDecimal r9_total) {
		this.r9_total = r9_total;
	}
	public String getR10_product() {
		return r10_product;
	}
	public void setR10_product(String r10_product) {
		this.r10_product = r10_product;
	}
	public BigDecimal getR10_visa() {
		return r10_visa;
	}
	public void setR10_visa(BigDecimal r10_visa) {
		this.r10_visa = r10_visa;
	}
	public BigDecimal getR10_mastercard() {
		return r10_mastercard;
	}
	public void setR10_mastercard(BigDecimal r10_mastercard) {
		this.r10_mastercard = r10_mastercard;
	}
	public BigDecimal getR10_amex() {
		return r10_amex;
	}
	public void setR10_amex(BigDecimal r10_amex) {
		this.r10_amex = r10_amex;
	}
	public BigDecimal getR10_jcb() {
		return r10_jcb;
	}
	public void setR10_jcb(BigDecimal r10_jcb) {
		this.r10_jcb = r10_jcb;
	}
	public BigDecimal getR10_diners() {
		return r10_diners;
	}
	public void setR10_diners(BigDecimal r10_diners) {
		this.r10_diners = r10_diners;
	}
	public BigDecimal getR10_unionpay() {
		return r10_unionpay;
	}
	public void setR10_unionpay(BigDecimal r10_unionpay) {
		this.r10_unionpay = r10_unionpay;
	}
	public BigDecimal getR10_total() {
		return r10_total;
	}
	public void setR10_total(BigDecimal r10_total) {
		this.r10_total = r10_total;
	}
	public String getR11_product() {
		return r11_product;
	}
	public void setR11_product(String r11_product) {
		this.r11_product = r11_product;
	}
	public BigDecimal getR11_visa() {
		return r11_visa;
	}
	public void setR11_visa(BigDecimal r11_visa) {
		this.r11_visa = r11_visa;
	}
	public BigDecimal getR11_mastercard() {
		return r11_mastercard;
	}
	public void setR11_mastercard(BigDecimal r11_mastercard) {
		this.r11_mastercard = r11_mastercard;
	}
	public BigDecimal getR11_amex() {
		return r11_amex;
	}
	public void setR11_amex(BigDecimal r11_amex) {
		this.r11_amex = r11_amex;
	}
	public BigDecimal getR11_jcb() {
		return r11_jcb;
	}
	public void setR11_jcb(BigDecimal r11_jcb) {
		this.r11_jcb = r11_jcb;
	}
	public BigDecimal getR11_diners() {
		return r11_diners;
	}
	public void setR11_diners(BigDecimal r11_diners) {
		this.r11_diners = r11_diners;
	}
	public BigDecimal getR11_unionpay() {
		return r11_unionpay;
	}
	public void setR11_unionpay(BigDecimal r11_unionpay) {
		this.r11_unionpay = r11_unionpay;
	}
	public BigDecimal getR11_total() {
		return r11_total;
	}
	public void setR11_total(BigDecimal r11_total) {
		this.r11_total = r11_total;
	}
	public String getR12_product() {
		return r12_product;
	}
	public void setR12_product(String r12_product) {
		this.r12_product = r12_product;
	}
	public BigDecimal getR12_visa() {
		return r12_visa;
	}
	public void setR12_visa(BigDecimal r12_visa) {
		this.r12_visa = r12_visa;
	}
	public BigDecimal getR12_mastercard() {
		return r12_mastercard;
	}
	public void setR12_mastercard(BigDecimal r12_mastercard) {
		this.r12_mastercard = r12_mastercard;
	}
	public BigDecimal getR12_amex() {
		return r12_amex;
	}
	public void setR12_amex(BigDecimal r12_amex) {
		this.r12_amex = r12_amex;
	}
	public BigDecimal getR12_jcb() {
		return r12_jcb;
	}
	public void setR12_jcb(BigDecimal r12_jcb) {
		this.r12_jcb = r12_jcb;
	}
	public BigDecimal getR12_diners() {
		return r12_diners;
	}
	public void setR12_diners(BigDecimal r12_diners) {
		this.r12_diners = r12_diners;
	}
	public BigDecimal getR12_unionpay() {
		return r12_unionpay;
	}
	public void setR12_unionpay(BigDecimal r12_unionpay) {
		this.r12_unionpay = r12_unionpay;
	}
	public BigDecimal getR12_total() {
		return r12_total;
	}
	public void setR12_total(BigDecimal r12_total) {
		this.r12_total = r12_total;
	}
	public String getR15_product() {
		return r15_product;
	}
	public void setR15_product(String r15_product) {
		this.r15_product = r15_product;
	}
	public String getR16_product() {
		return r16_product;
	}
	public void setR16_product(String r16_product) {
		this.r16_product = r16_product;
	}
	public String getR16_jcb() {
		return r16_jcb;
	}
	public void setR16_jcb(String r16_jcb) {
		this.r16_jcb = r16_jcb;
	}
	public String getR17_product() {
		return r17_product;
	}
	public void setR17_product(String r17_product) {
		this.r17_product = r17_product;
	}
	public String getR17_jcb() {
		return r17_jcb;
	}
	public void setR17_jcb(String r17_jcb) {
		this.r17_jcb = r17_jcb;
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
		return "BRF71_ENTITY [r1_product=" + r1_product + ", r1_visa=" + r1_visa + ", r1_mastercard=" + r1_mastercard
				+ ", r1_amex=" + r1_amex + ", r1_jcb=" + r1_jcb + ", r1_diners=" + r1_diners + ", r1_unionpay="
				+ r1_unionpay + ", r1_total=" + r1_total + ", r2_product=" + r2_product + ", r2_visa=" + r2_visa
				+ ", r2_mastercard=" + r2_mastercard + ", r2_amex=" + r2_amex + ", r2_jcb=" + r2_jcb + ", r2_diners="
				+ r2_diners + ", r2_unionpay=" + r2_unionpay + ", r2_total=" + r2_total + ", r3_product=" + r3_product
				+ ", r3_visa=" + r3_visa + ", r3_mastercard=" + r3_mastercard + ", r3_amex=" + r3_amex + ", r3_jcb="
				+ r3_jcb + ", r3_diners=" + r3_diners + ", r3_unionpay=" + r3_unionpay + ", r3_total=" + r3_total
				+ ", r4_product=" + r4_product + ", r4_visa=" + r4_visa + ", r4_mastercard=" + r4_mastercard
				+ ", r4_amex=" + r4_amex + ", r4_jcb=" + r4_jcb + ", r4_diners=" + r4_diners + ", r4_unionpay="
				+ r4_unionpay + ", r4_total=" + r4_total + ", r5_product=" + r5_product + ", r5_visa=" + r5_visa
				+ ", r5_mastercard=" + r5_mastercard + ", r5_amex=" + r5_amex + ", r5_jcb=" + r5_jcb + ", r5_diners="
				+ r5_diners + ", r5_unionpay=" + r5_unionpay + ", r5_total=" + r5_total + ", r6_product=" + r6_product
				+ ", r6_visa=" + r6_visa + ", r6_mastercard=" + r6_mastercard + ", r6_amex=" + r6_amex + ", r6_jcb="
				+ r6_jcb + ", r6_diners=" + r6_diners + ", r6_unionpay=" + r6_unionpay + ", r6_total=" + r6_total
				+ ", r7_product=" + r7_product + ", r7_visa=" + r7_visa + ", r7_mastercard=" + r7_mastercard
				+ ", r7_amex=" + r7_amex + ", r7_jcb=" + r7_jcb + ", r7_diners=" + r7_diners + ", r7_unionpay="
				+ r7_unionpay + ", r7_total=" + r7_total + ", r8_product=" + r8_product + ", r8_visa=" + r8_visa
				+ ", r8_mastercard=" + r8_mastercard + ", r8_amex=" + r8_amex + ", r8_jcb=" + r8_jcb + ", r8_diners="
				+ r8_diners + ", r8_unionpay=" + r8_unionpay + ", r8_total=" + r8_total + ", r9_product=" + r9_product
				+ ", r9_visa=" + r9_visa + ", r9_mastercard=" + r9_mastercard + ", r9_amex=" + r9_amex + ", r9_jcb="
				+ r9_jcb + ", r9_diners=" + r9_diners + ", r9_unionpay=" + r9_unionpay + ", r9_total=" + r9_total
				+ ", r10_product=" + r10_product + ", r10_visa=" + r10_visa + ", r10_mastercard=" + r10_mastercard
				+ ", r10_amex=" + r10_amex + ", r10_jcb=" + r10_jcb + ", r10_diners=" + r10_diners + ", r10_unionpay="
				+ r10_unionpay + ", r10_total=" + r10_total + ", r11_product=" + r11_product + ", r11_visa=" + r11_visa
				+ ", r11_mastercard=" + r11_mastercard + ", r11_amex=" + r11_amex + ", r11_jcb=" + r11_jcb
				+ ", r11_diners=" + r11_diners + ", r11_unionpay=" + r11_unionpay + ", r11_total=" + r11_total
				+ ", r12_product=" + r12_product + ", r12_visa=" + r12_visa + ", r12_mastercard=" + r12_mastercard
				+ ", r12_amex=" + r12_amex + ", r12_jcb=" + r12_jcb + ", r12_diners=" + r12_diners + ", r12_unionpay="
				+ r12_unionpay + ", r12_total=" + r12_total + ", r15_product=" + r15_product + ", r16_product="
				+ r16_product + ", r16_jcb=" + r16_jcb + ", r17_product=" + r17_product + ", r17_jcb=" + r17_jcb
				+ ", repdesc=" + repdesc + ", frequency=" + frequency + "]";
	}
	public BRF71_ENTITY() {
		super();
		// TODO Auto-generated constructor stub
	}

}