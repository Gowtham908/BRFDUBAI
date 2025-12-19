package com.bornfire.xbrl.entities.BRBS;

import java.math.BigDecimal;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="BRF74_SUMMARYTABLE")
public class BRF74_ENTITY {
	@Id
	private Date	report_date;
	private String	r1_product;
	private BigDecimal	r1_acc_fund_national;
	private BigDecimal	r1_amt_fund_national;
	private BigDecimal	r1_avg_fund_national;
	private BigDecimal	r1_acc_unfund_national;
	private BigDecimal	r1_amt_unfund_national;
	private BigDecimal	r1_ccf_unfund_national;
	private BigDecimal	r1_stage3_acc_national;
	private BigDecimal	r1_amt_stage3_national;
	private BigDecimal	r1_acc_fund_non_national;
	private BigDecimal	r1_amt_fund_non_national;
	private BigDecimal	r1_avg_fund_non_national;
	private BigDecimal	r1_acc_unfund_non_national;
	private BigDecimal	r1_amt_unfund_non_national;
	private BigDecimal	r1_ccf_unfund_non_national;
	private BigDecimal	r1_stage3_acc_non_national;
	private BigDecimal	r1_amt_stage3_non_national;
	private BigDecimal	r1_acc_total;
	private BigDecimal	r1_fund_amt_total;
	private BigDecimal	r1_avg_total;
	private BigDecimal	r1_fund_ccf_total;
	private BigDecimal	r1_stage3_acc_total;
	private BigDecimal	r1_amt_stage3_total;
	private BigDecimal	r1_stage3_acc_quater;
	private BigDecimal	r1_amt_stage3_acc_quater;
	private String	r2_product;
	private BigDecimal	r2_acc_fund_national;
	private BigDecimal	r2_amt_fund_national;
	private BigDecimal	r2_avg_fund_national;
	private BigDecimal	r2_acc_unfund_national;
	private BigDecimal	r2_amt_unfund_national;
	private BigDecimal	r2_ccf_unfund_national;
	private BigDecimal	r2_stage3_acc_national;
	private BigDecimal	r2_amt_stage3_national;
	private BigDecimal	r2_acc_fund_non_national;
	private BigDecimal	r2_amt_fund_non_national;
	private BigDecimal	r2_avg_fund_non_national;
	private BigDecimal	r2_acc_unfund_non_national;
	private BigDecimal	r2_amt_unfund_non_national;
	private BigDecimal	r2_ccf_unfund_non_national;
	private BigDecimal	r2_stage3_acc_non_national;
	private BigDecimal	r2_amt_stage3_non_national;
	private BigDecimal	r2_acc_total;
	private BigDecimal	r2_fund_amt_total;
	private BigDecimal	r2_avg_total;
	private BigDecimal	r2_fund_ccf_total;
	private BigDecimal	r2_stage3_acc_total;
	private BigDecimal	r2_amt_stage3_total;
	private BigDecimal	r2_stage3_acc_quater;
	private BigDecimal	r2_amt_stage3_acc_quater;
	private String	r3_product;
	private BigDecimal	r3_acc_fund_national;
	private BigDecimal	r3_amt_fund_national;
	private BigDecimal	r3_avg_fund_national;
	private BigDecimal	r3_acc_unfund_national;
	private BigDecimal	r3_amt_unfund_national;
	private BigDecimal	r3_ccf_unfund_national;
	private BigDecimal	r3_stage3_acc_national;
	private BigDecimal	r3_amt_stage3_national;
	private BigDecimal	r3_acc_fund_non_national;
	private BigDecimal	r3_amt_fund_non_national;
	private BigDecimal	r3_avg_fund_non_national;
	private BigDecimal	r3_acc_unfund_non_national;
	private BigDecimal	r3_amt_unfund_non_national;
	private BigDecimal	r3_ccf_unfund_non_national;
	private BigDecimal	r3_stage3_acc_non_national;
	private BigDecimal	r3_amt_stage3_non_national;
	private BigDecimal	r3_acc_total;
	private BigDecimal	r3_fund_amt_total;
	private BigDecimal	r3_avg_total;
	private BigDecimal	r3_fund_ccf_total;
	private BigDecimal	r3_stage3_acc_total;
	private BigDecimal	r3_amt_stage3_total;
	private BigDecimal	r3_stage3_acc_quater;
	private BigDecimal	r3_amt_stage3_acc_quater;
	private String	r4_product;
	private BigDecimal	r4_acc_fund_national;
	private BigDecimal	r4_amt_fund_national;
	private BigDecimal	r4_avg_fund_national;
	private BigDecimal	r4_acc_unfund_national;
	private BigDecimal	r4_amt_unfund_national;
	private BigDecimal	r4_ccf_unfund_national;
	private BigDecimal	r4_stage3_acc_national;
	private BigDecimal	r4_amt_stage3_national;
	private BigDecimal	r4_acc_fund_non_national;
	private BigDecimal	r4_amt_fund_non_national;
	private BigDecimal	r4_avg_fund_non_national;
	private BigDecimal	r4_acc_unfund_non_national;
	private BigDecimal	r4_amt_unfund_non_national;
	private BigDecimal	r4_ccf_unfund_non_national;
	private BigDecimal	r4_stage3_acc_non_national;
	private BigDecimal	r4_amt_stage3_non_national;
	private BigDecimal	r4_acc_total;
	private BigDecimal	r4_fund_amt_total;
	private BigDecimal	r4_avg_total;
	private BigDecimal	r4_fund_ccf_total;
	private BigDecimal	r4_stage3_acc_total;
	private BigDecimal	r4_amt_stage3_total;
	private BigDecimal	r4_stage3_acc_quater;
	private BigDecimal	r4_amt_stage3_acc_quater;
	private String	r5_product;
	private BigDecimal	r5_acc_fund_national;
	private BigDecimal	r5_amt_fund_national;
	private BigDecimal	r5_avg_fund_national;
	private BigDecimal	r5_acc_unfund_national;
	private BigDecimal	r5_amt_unfund_national;
	private BigDecimal	r5_ccf_unfund_national;
	private BigDecimal	r5_stage3_acc_national;
	private BigDecimal	r5_amt_stage3_national;
	private BigDecimal	r5_acc_fund_non_national;
	private BigDecimal	r5_amt_fund_non_national;
	private BigDecimal	r5_avg_fund_non_national;
	private BigDecimal	r5_acc_unfund_non_national;
	private BigDecimal	r5_amt_unfund_non_national;
	private BigDecimal	r5_ccf_unfund_non_national;
	private BigDecimal	r5_stage3_acc_non_national;
	private BigDecimal	r5_amt_stage3_non_national;
	private BigDecimal	r5_acc_total;
	private BigDecimal	r5_fund_amt_total;
	private BigDecimal	r5_avg_total;
	private BigDecimal	r5_fund_ccf_total;
	private BigDecimal	r5_stage3_acc_total;
	private BigDecimal	r5_amt_stage3_total;
	private BigDecimal	r5_stage3_acc_quater;
	private BigDecimal	r5_amt_stage3_acc_quater;
	private String	r6_product;
	private BigDecimal	r6_acc_fund_national;
	private BigDecimal	r6_amt_fund_national;
	private BigDecimal	r6_avg_fund_national;
	private BigDecimal	r6_acc_unfund_national;
	private BigDecimal	r6_amt_unfund_national;
	private BigDecimal	r6_ccf_unfund_national;
	private BigDecimal	r6_stage3_acc_national;
	private BigDecimal	r6_amt_stage3_national;
	private BigDecimal	r6_acc_fund_non_national;
	private BigDecimal	r6_amt_fund_non_national;
	private BigDecimal	r6_avg_fund_non_national;
	private BigDecimal	r6_acc_unfund_non_national;
	private BigDecimal	r6_amt_unfund_non_national;
	private BigDecimal	r6_ccf_unfund_non_national;
	private BigDecimal	r6_stage3_acc_non_national;
	private BigDecimal	r6_amt_stage3_non_national;
	private BigDecimal	r6_acc_total;
	private BigDecimal	r6_fund_amt_total;
	private BigDecimal	r6_avg_total;
	private BigDecimal	r6_fund_ccf_total;
	private BigDecimal	r6_stage3_acc_total;
	private BigDecimal	r6_amt_stage3_total;
	private BigDecimal	r6_stage3_acc_quater;
	private BigDecimal	r6_amt_stage3_acc_quater;
	private String	r7_product;
	private BigDecimal	r7_acc_fund_national;
	private BigDecimal	r7_amt_fund_national;
	private BigDecimal	r7_avg_fund_national;
	private BigDecimal	r7_acc_unfund_national;
	private BigDecimal	r7_amt_unfund_national;
	private BigDecimal	r7_ccf_unfund_national;
	private BigDecimal	r7_stage3_acc_national;
	private BigDecimal	r7_amt_stage3_national;
	private BigDecimal	r7_acc_fund_non_national;
	private BigDecimal	r7_amt_fund_non_national;
	private BigDecimal	r7_avg_fund_non_national;
	private BigDecimal	r7_acc_unfund_non_national;
	private BigDecimal	r7_amt_unfund_non_national;
	private BigDecimal	r7_ccf_unfund_non_national;
	private BigDecimal	r7_stage3_acc_non_national;
	private BigDecimal	r7_amt_stage3_non_national;
	private BigDecimal	r7_acc_total;
	private BigDecimal	r7_fund_amt_total;
	private BigDecimal	r7_avg_total;
	private BigDecimal	r7_fund_ccf_total;
	private BigDecimal	r7_stage3_acc_total;
	private BigDecimal	r7_amt_stage3_total;
	private BigDecimal	r7_stage3_acc_quater;
	private BigDecimal	r7_amt_stage3_acc_quater;
	private String	r8_product;
	private BigDecimal	r8_acc_fund_national;
	private BigDecimal	r8_amt_fund_national;
	private BigDecimal	r8_avg_fund_national;
	private BigDecimal	r8_acc_unfund_national;
	private BigDecimal	r8_amt_unfund_national;
	private BigDecimal	r8_ccf_unfund_national;
	private BigDecimal	r8_stage3_acc_national;
	private BigDecimal	r8_amt_stage3_national;
	private BigDecimal	r8_acc_fund_non_national;
	private BigDecimal	r8_amt_fund_non_national;
	private BigDecimal	r8_avg_fund_non_national;
	private BigDecimal	r8_acc_unfund_non_national;
	private BigDecimal	r8_amt_unfund_non_national;
	private BigDecimal	r8_ccf_unfund_non_national;
	private BigDecimal	r8_stage3_acc_non_national;
	private BigDecimal	r8_amt_stage3_non_national;
	private BigDecimal	r8_acc_total;
	private BigDecimal	r8_fund_amt_total;
	private BigDecimal	r8_avg_total;
	private BigDecimal	r8_fund_ccf_total;
	private BigDecimal	r8_stage3_acc_total;
	private BigDecimal	r8_amt_stage3_total;
	private BigDecimal	r8_stage3_acc_quater;
	private BigDecimal	r8_amt_stage3_acc_quater;
	private String	r9_product;
	private BigDecimal	r9_acc_fund_national;
	private BigDecimal	r9_amt_fund_national;
	private BigDecimal	r9_avg_fund_national;
	private BigDecimal	r9_acc_unfund_national;
	private BigDecimal	r9_amt_unfund_national;
	private BigDecimal	r9_ccf_unfund_national;
	private BigDecimal	r9_stage3_acc_national;
	private BigDecimal	r9_amt_stage3_national;
	private BigDecimal	r9_acc_fund_non_national;
	private BigDecimal	r9_amt_fund_non_national;
	private BigDecimal	r9_avg_fund_non_national;
	private BigDecimal	r9_acc_unfund_non_national;
	private BigDecimal	r9_amt_unfund_non_national;
	private BigDecimal	r9_ccf_unfund_non_national;
	private BigDecimal	r9_stage3_acc_non_national;
	private BigDecimal	r9_amt_stage3_non_national;
	private BigDecimal	r9_acc_total;
	private BigDecimal	r9_fund_amt_total;
	private BigDecimal	r9_avg_total;
	private BigDecimal	r9_fund_ccf_total;
	private BigDecimal	r9_stage3_acc_total;
	private BigDecimal	r9_amt_stage3_total;
	private BigDecimal	r9_stage3_acc_quater;
	private BigDecimal	r9_amt_stage3_acc_quater;
	private String	r10_product;
	private BigDecimal	r10_acc_fund_national;
	private BigDecimal	r10_amt_fund_national;
	private BigDecimal	r10_avg_fund_national;
	private BigDecimal	r10_acc_unfund_national;
	private BigDecimal	r10_amt_unfund_national;
	private BigDecimal	r10_ccf_unfund_national;
	private BigDecimal	r10_stage3_acc_national;
	private BigDecimal	r10_amt_stage3_national;
	private BigDecimal	r10_acc_fund_non_national;
	private BigDecimal	r10_amt_fund_non_national;
	private BigDecimal	r10_avg_fund_non_national;
	private BigDecimal	r10_acc_unfund_non_national;
	private BigDecimal	r10_amt_unfund_non_national;
	private BigDecimal	r10_ccf_unfund_non_national;
	private BigDecimal	r10_stage3_acc_non_national;
	private BigDecimal	r10_amt_stage3_non_national;
	private BigDecimal	r10_acc_total;
	private BigDecimal	r10_fund_amt_total;
	private BigDecimal	r10_avg_total;
	private BigDecimal	r10_fund_ccf_total;
	private BigDecimal	r10_stage3_acc_total;
	private BigDecimal	r10_amt_stage3_total;
	private BigDecimal	r10_stage3_acc_quater;
	private BigDecimal	r10_amt_stage3_acc_quater;
	private String	r11_product;
	private BigDecimal	r11_acc_fund_national;
	private BigDecimal	r11_amt_fund_national;
	private BigDecimal	r11_avg_fund_national;
	private BigDecimal	r11_acc_unfund_national;
	private BigDecimal	r11_amt_unfund_national;
	private BigDecimal	r11_ccf_unfund_national;
	private BigDecimal	r11_stage3_acc_national;
	private BigDecimal	r11_amt_stage3_national;
	private BigDecimal	r11_acc_fund_non_national;
	private BigDecimal	r11_amt_fund_non_national;
	private BigDecimal	r11_avg_fund_non_national;
	private BigDecimal	r11_acc_unfund_non_national;
	private BigDecimal	r11_amt_unfund_non_national;
	private BigDecimal	r11_ccf_unfund_non_national;
	private BigDecimal	r11_stage3_acc_non_national;
	private BigDecimal	r11_amt_stage3_non_national;
	private BigDecimal	r11_acc_total;
	private BigDecimal	r11_fund_amt_total;
	private BigDecimal	r11_avg_total;
	private BigDecimal	r11_fund_ccf_total;
	private BigDecimal	r11_stage3_acc_total;
	private BigDecimal	r11_amt_stage3_total;
	private BigDecimal	r11_stage3_acc_quater;
	private BigDecimal	r11_amt_stage3_acc_quater;
	private String	r12_product;
	private BigDecimal	r12_acc_fund_national;
	private BigDecimal	r12_amt_fund_national;
	private BigDecimal	r12_avg_fund_national;
	private BigDecimal	r12_acc_unfund_national;
	private BigDecimal	r12_amt_unfund_national;
	private BigDecimal	r12_ccf_unfund_national;
	private BigDecimal	r12_stage3_acc_national;
	private BigDecimal	r12_amt_stage3_national;
	private BigDecimal	r12_acc_fund_non_national;
	private BigDecimal	r12_amt_fund_non_national;
	private BigDecimal	r12_avg_fund_non_national;
	private BigDecimal	r12_acc_unfund_non_national;
	private BigDecimal	r12_amt_unfund_non_national;
	private BigDecimal	r12_ccf_unfund_non_national;
	private BigDecimal	r12_stage3_acc_non_national;
	private BigDecimal	r12_amt_stage3_non_national;
	private BigDecimal	r12_acc_total;
	private BigDecimal	r12_fund_amt_total;
	private BigDecimal	r12_avg_total;
	private BigDecimal	r12_fund_ccf_total;
	private BigDecimal	r12_stage3_acc_total;
	private BigDecimal	r12_amt_stage3_total;
	private BigDecimal	r12_stage3_acc_quater;
	private BigDecimal	r12_amt_stage3_acc_quater;
	private String	r13_product;
	private BigDecimal	r13_acc_fund_national;
	private BigDecimal	r13_amt_fund_national;
	private BigDecimal	r13_avg_fund_national;
	private BigDecimal	r13_acc_unfund_national;
	private BigDecimal	r13_amt_unfund_national;
	private BigDecimal	r13_ccf_unfund_national;
	private BigDecimal	r13_stage3_acc_national;
	private BigDecimal	r13_amt_stage3_national;
	private BigDecimal	r13_acc_fund_non_national;
	private BigDecimal	r13_amt_fund_non_national;
	private BigDecimal	r13_avg_fund_non_national;
	private BigDecimal	r13_acc_unfund_non_national;
	private BigDecimal	r13_amt_unfund_non_national;
	private BigDecimal	r13_ccf_unfund_non_national;
	private BigDecimal	r13_stage3_acc_non_national;
	private BigDecimal	r13_amt_stage3_non_national;
	private BigDecimal	r13_acc_total;
	private BigDecimal	r13_fund_amt_total;
	private BigDecimal	r13_avg_total;
	private BigDecimal	r13_fund_ccf_total;
	private BigDecimal	r13_stage3_acc_total;
	private BigDecimal	r13_amt_stage3_total;
	private BigDecimal	r13_stage3_acc_quater;
	private BigDecimal	r13_amt_stage3_acc_quater;
	private Date	report_from_date;
	private Date	report_to_date;
	private Date	report_submit_date;
	private String	entity_flg;
	private String	modify_flg;
	private String	del_flg ;
	private String	repdesc;
	private String	frequency;
	private String	report_code;
	public Date getReport_date() {
		return report_date;
	}
	public void setReport_date(Date report_date) {
		this.report_date = report_date;
	}
	public String getR1_product() {
		return r1_product;
	}
	public void setR1_product(String r1_product) {
		this.r1_product = r1_product;
	}
	public BigDecimal getR1_acc_fund_national() {
		return r1_acc_fund_national;
	}
	public void setR1_acc_fund_national(BigDecimal r1_acc_fund_national) {
		this.r1_acc_fund_national = r1_acc_fund_national;
	}
	public BigDecimal getR1_amt_fund_national() {
		return r1_amt_fund_national;
	}
	public void setR1_amt_fund_national(BigDecimal r1_amt_fund_national) {
		this.r1_amt_fund_national = r1_amt_fund_national;
	}
	public BigDecimal getR1_avg_fund_national() {
		return r1_avg_fund_national;
	}
	public void setR1_avg_fund_national(BigDecimal r1_avg_fund_national) {
		this.r1_avg_fund_national = r1_avg_fund_national;
	}
	public BigDecimal getR1_acc_unfund_national() {
		return r1_acc_unfund_national;
	}
	public void setR1_acc_unfund_national(BigDecimal r1_acc_unfund_national) {
		this.r1_acc_unfund_national = r1_acc_unfund_national;
	}
	public BigDecimal getR1_amt_unfund_national() {
		return r1_amt_unfund_national;
	}
	public void setR1_amt_unfund_national(BigDecimal r1_amt_unfund_national) {
		this.r1_amt_unfund_national = r1_amt_unfund_national;
	}
	public BigDecimal getR1_ccf_unfund_national() {
		return r1_ccf_unfund_national;
	}
	public void setR1_ccf_unfund_national(BigDecimal r1_ccf_unfund_national) {
		this.r1_ccf_unfund_national = r1_ccf_unfund_national;
	}
	public BigDecimal getR1_stage3_acc_national() {
		return r1_stage3_acc_national;
	}
	public void setR1_stage3_acc_national(BigDecimal r1_stage3_acc_national) {
		this.r1_stage3_acc_national = r1_stage3_acc_national;
	}
	public BigDecimal getR1_amt_stage3_national() {
		return r1_amt_stage3_national;
	}
	public void setR1_amt_stage3_national(BigDecimal r1_amt_stage3_national) {
		this.r1_amt_stage3_national = r1_amt_stage3_national;
	}
	public BigDecimal getR1_acc_fund_non_national() {
		return r1_acc_fund_non_national;
	}
	public void setR1_acc_fund_non_national(BigDecimal r1_acc_fund_non_national) {
		this.r1_acc_fund_non_national = r1_acc_fund_non_national;
	}
	public BigDecimal getR1_amt_fund_non_national() {
		return r1_amt_fund_non_national;
	}
	public void setR1_amt_fund_non_national(BigDecimal r1_amt_fund_non_national) {
		this.r1_amt_fund_non_national = r1_amt_fund_non_national;
	}
	public BigDecimal getR1_avg_fund_non_national() {
		return r1_avg_fund_non_national;
	}
	public void setR1_avg_fund_non_national(BigDecimal r1_avg_fund_non_national) {
		this.r1_avg_fund_non_national = r1_avg_fund_non_national;
	}
	public BigDecimal getR1_acc_unfund_non_national() {
		return r1_acc_unfund_non_national;
	}
	public void setR1_acc_unfund_non_national(BigDecimal r1_acc_unfund_non_national) {
		this.r1_acc_unfund_non_national = r1_acc_unfund_non_national;
	}
	public BigDecimal getR1_amt_unfund_non_national() {
		return r1_amt_unfund_non_national;
	}
	public void setR1_amt_unfund_non_national(BigDecimal r1_amt_unfund_non_national) {
		this.r1_amt_unfund_non_national = r1_amt_unfund_non_national;
	}
	public BigDecimal getR1_ccf_unfund_non_national() {
		return r1_ccf_unfund_non_national;
	}
	public void setR1_ccf_unfund_non_national(BigDecimal r1_ccf_unfund_non_national) {
		this.r1_ccf_unfund_non_national = r1_ccf_unfund_non_national;
	}
	public BigDecimal getR1_stage3_acc_non_national() {
		return r1_stage3_acc_non_national;
	}
	public void setR1_stage3_acc_non_national(BigDecimal r1_stage3_acc_non_national) {
		this.r1_stage3_acc_non_national = r1_stage3_acc_non_national;
	}
	public BigDecimal getR1_amt_stage3_non_national() {
		return r1_amt_stage3_non_national;
	}
	public void setR1_amt_stage3_non_national(BigDecimal r1_amt_stage3_non_national) {
		this.r1_amt_stage3_non_national = r1_amt_stage3_non_national;
	}
	public BigDecimal getR1_acc_total() {
		return r1_acc_total;
	}
	public void setR1_acc_total(BigDecimal r1_acc_total) {
		this.r1_acc_total = r1_acc_total;
	}
	public BigDecimal getR1_fund_amt_total() {
		return r1_fund_amt_total;
	}
	public void setR1_fund_amt_total(BigDecimal r1_fund_amt_total) {
		this.r1_fund_amt_total = r1_fund_amt_total;
	}
	public BigDecimal getR1_avg_total() {
		return r1_avg_total;
	}
	public void setR1_avg_total(BigDecimal r1_avg_total) {
		this.r1_avg_total = r1_avg_total;
	}
	public BigDecimal getR1_fund_ccf_total() {
		return r1_fund_ccf_total;
	}
	public void setR1_fund_ccf_total(BigDecimal r1_fund_ccf_total) {
		this.r1_fund_ccf_total = r1_fund_ccf_total;
	}
	public BigDecimal getR1_stage3_acc_total() {
		return r1_stage3_acc_total;
	}
	public void setR1_stage3_acc_total(BigDecimal r1_stage3_acc_total) {
		this.r1_stage3_acc_total = r1_stage3_acc_total;
	}
	public BigDecimal getR1_amt_stage3_total() {
		return r1_amt_stage3_total;
	}
	public void setR1_amt_stage3_total(BigDecimal r1_amt_stage3_total) {
		this.r1_amt_stage3_total = r1_amt_stage3_total;
	}
	public BigDecimal getR1_stage3_acc_quater() {
		return r1_stage3_acc_quater;
	}
	public void setR1_stage3_acc_quater(BigDecimal r1_stage3_acc_quater) {
		this.r1_stage3_acc_quater = r1_stage3_acc_quater;
	}
	public BigDecimal getR1_amt_stage3_acc_quater() {
		return r1_amt_stage3_acc_quater;
	}
	public void setR1_amt_stage3_acc_quater(BigDecimal r1_amt_stage3_acc_quater) {
		this.r1_amt_stage3_acc_quater = r1_amt_stage3_acc_quater;
	}
	public String getR2_product() {
		return r2_product;
	}
	public void setR2_product(String r2_product) {
		this.r2_product = r2_product;
	}
	public BigDecimal getR2_acc_fund_national() {
		return r2_acc_fund_national;
	}
	public void setR2_acc_fund_national(BigDecimal r2_acc_fund_national) {
		this.r2_acc_fund_national = r2_acc_fund_national;
	}
	public BigDecimal getR2_amt_fund_national() {
		return r2_amt_fund_national;
	}
	public void setR2_amt_fund_national(BigDecimal r2_amt_fund_national) {
		this.r2_amt_fund_national = r2_amt_fund_national;
	}
	public BigDecimal getR2_avg_fund_national() {
		return r2_avg_fund_national;
	}
	public void setR2_avg_fund_national(BigDecimal r2_avg_fund_national) {
		this.r2_avg_fund_national = r2_avg_fund_national;
	}
	public BigDecimal getR2_acc_unfund_national() {
		return r2_acc_unfund_national;
	}
	public void setR2_acc_unfund_national(BigDecimal r2_acc_unfund_national) {
		this.r2_acc_unfund_national = r2_acc_unfund_national;
	}
	public BigDecimal getR2_amt_unfund_national() {
		return r2_amt_unfund_national;
	}
	public void setR2_amt_unfund_national(BigDecimal r2_amt_unfund_national) {
		this.r2_amt_unfund_national = r2_amt_unfund_national;
	}
	public BigDecimal getR2_ccf_unfund_national() {
		return r2_ccf_unfund_national;
	}
	public void setR2_ccf_unfund_national(BigDecimal r2_ccf_unfund_national) {
		this.r2_ccf_unfund_national = r2_ccf_unfund_national;
	}
	public BigDecimal getR2_stage3_acc_national() {
		return r2_stage3_acc_national;
	}
	public void setR2_stage3_acc_national(BigDecimal r2_stage3_acc_national) {
		this.r2_stage3_acc_national = r2_stage3_acc_national;
	}
	public BigDecimal getR2_amt_stage3_national() {
		return r2_amt_stage3_national;
	}
	public void setR2_amt_stage3_national(BigDecimal r2_amt_stage3_national) {
		this.r2_amt_stage3_national = r2_amt_stage3_national;
	}
	public BigDecimal getR2_acc_fund_non_national() {
		return r2_acc_fund_non_national;
	}
	public void setR2_acc_fund_non_national(BigDecimal r2_acc_fund_non_national) {
		this.r2_acc_fund_non_national = r2_acc_fund_non_national;
	}
	public BigDecimal getR2_amt_fund_non_national() {
		return r2_amt_fund_non_national;
	}
	public void setR2_amt_fund_non_national(BigDecimal r2_amt_fund_non_national) {
		this.r2_amt_fund_non_national = r2_amt_fund_non_national;
	}
	public BigDecimal getR2_avg_fund_non_national() {
		return r2_avg_fund_non_national;
	}
	public void setR2_avg_fund_non_national(BigDecimal r2_avg_fund_non_national) {
		this.r2_avg_fund_non_national = r2_avg_fund_non_national;
	}
	public BigDecimal getR2_acc_unfund_non_national() {
		return r2_acc_unfund_non_national;
	}
	public void setR2_acc_unfund_non_national(BigDecimal r2_acc_unfund_non_national) {
		this.r2_acc_unfund_non_national = r2_acc_unfund_non_national;
	}
	public BigDecimal getR2_amt_unfund_non_national() {
		return r2_amt_unfund_non_national;
	}
	public void setR2_amt_unfund_non_national(BigDecimal r2_amt_unfund_non_national) {
		this.r2_amt_unfund_non_national = r2_amt_unfund_non_national;
	}
	public BigDecimal getR2_ccf_unfund_non_national() {
		return r2_ccf_unfund_non_national;
	}
	public void setR2_ccf_unfund_non_national(BigDecimal r2_ccf_unfund_non_national) {
		this.r2_ccf_unfund_non_national = r2_ccf_unfund_non_national;
	}
	public BigDecimal getR2_stage3_acc_non_national() {
		return r2_stage3_acc_non_national;
	}
	public void setR2_stage3_acc_non_national(BigDecimal r2_stage3_acc_non_national) {
		this.r2_stage3_acc_non_national = r2_stage3_acc_non_national;
	}
	public BigDecimal getR2_amt_stage3_non_national() {
		return r2_amt_stage3_non_national;
	}
	public void setR2_amt_stage3_non_national(BigDecimal r2_amt_stage3_non_national) {
		this.r2_amt_stage3_non_national = r2_amt_stage3_non_national;
	}
	public BigDecimal getR2_acc_total() {
		return r2_acc_total;
	}
	public void setR2_acc_total(BigDecimal r2_acc_total) {
		this.r2_acc_total = r2_acc_total;
	}
	public BigDecimal getR2_fund_amt_total() {
		return r2_fund_amt_total;
	}
	public void setR2_fund_amt_total(BigDecimal r2_fund_amt_total) {
		this.r2_fund_amt_total = r2_fund_amt_total;
	}
	public BigDecimal getR2_avg_total() {
		return r2_avg_total;
	}
	public void setR2_avg_total(BigDecimal r2_avg_total) {
		this.r2_avg_total = r2_avg_total;
	}
	public BigDecimal getR2_fund_ccf_total() {
		return r2_fund_ccf_total;
	}
	public void setR2_fund_ccf_total(BigDecimal r2_fund_ccf_total) {
		this.r2_fund_ccf_total = r2_fund_ccf_total;
	}
	public BigDecimal getR2_stage3_acc_total() {
		return r2_stage3_acc_total;
	}
	public void setR2_stage3_acc_total(BigDecimal r2_stage3_acc_total) {
		this.r2_stage3_acc_total = r2_stage3_acc_total;
	}
	public BigDecimal getR2_amt_stage3_total() {
		return r2_amt_stage3_total;
	}
	public void setR2_amt_stage3_total(BigDecimal r2_amt_stage3_total) {
		this.r2_amt_stage3_total = r2_amt_stage3_total;
	}
	public BigDecimal getR2_stage3_acc_quater() {
		return r2_stage3_acc_quater;
	}
	public void setR2_stage3_acc_quater(BigDecimal r2_stage3_acc_quater) {
		this.r2_stage3_acc_quater = r2_stage3_acc_quater;
	}
	public BigDecimal getR2_amt_stage3_acc_quater() {
		return r2_amt_stage3_acc_quater;
	}
	public void setR2_amt_stage3_acc_quater(BigDecimal r2_amt_stage3_acc_quater) {
		this.r2_amt_stage3_acc_quater = r2_amt_stage3_acc_quater;
	}
	public String getR3_product() {
		return r3_product;
	}
	public void setR3_product(String r3_product) {
		this.r3_product = r3_product;
	}
	public BigDecimal getR3_acc_fund_national() {
		return r3_acc_fund_national;
	}
	public void setR3_acc_fund_national(BigDecimal r3_acc_fund_national) {
		this.r3_acc_fund_national = r3_acc_fund_national;
	}
	public BigDecimal getR3_amt_fund_national() {
		return r3_amt_fund_national;
	}
	public void setR3_amt_fund_national(BigDecimal r3_amt_fund_national) {
		this.r3_amt_fund_national = r3_amt_fund_national;
	}
	public BigDecimal getR3_avg_fund_national() {
		return r3_avg_fund_national;
	}
	public void setR3_avg_fund_national(BigDecimal r3_avg_fund_national) {
		this.r3_avg_fund_national = r3_avg_fund_national;
	}
	public BigDecimal getR3_acc_unfund_national() {
		return r3_acc_unfund_national;
	}
	public void setR3_acc_unfund_national(BigDecimal r3_acc_unfund_national) {
		this.r3_acc_unfund_national = r3_acc_unfund_national;
	}
	public BigDecimal getR3_amt_unfund_national() {
		return r3_amt_unfund_national;
	}
	public void setR3_amt_unfund_national(BigDecimal r3_amt_unfund_national) {
		this.r3_amt_unfund_national = r3_amt_unfund_national;
	}
	public BigDecimal getR3_ccf_unfund_national() {
		return r3_ccf_unfund_national;
	}
	public void setR3_ccf_unfund_national(BigDecimal r3_ccf_unfund_national) {
		this.r3_ccf_unfund_national = r3_ccf_unfund_national;
	}
	public BigDecimal getR3_stage3_acc_national() {
		return r3_stage3_acc_national;
	}
	public void setR3_stage3_acc_national(BigDecimal r3_stage3_acc_national) {
		this.r3_stage3_acc_national = r3_stage3_acc_national;
	}
	public BigDecimal getR3_amt_stage3_national() {
		return r3_amt_stage3_national;
	}
	public void setR3_amt_stage3_national(BigDecimal r3_amt_stage3_national) {
		this.r3_amt_stage3_national = r3_amt_stage3_national;
	}
	public BigDecimal getR3_acc_fund_non_national() {
		return r3_acc_fund_non_national;
	}
	public void setR3_acc_fund_non_national(BigDecimal r3_acc_fund_non_national) {
		this.r3_acc_fund_non_national = r3_acc_fund_non_national;
	}
	public BigDecimal getR3_amt_fund_non_national() {
		return r3_amt_fund_non_national;
	}
	public void setR3_amt_fund_non_national(BigDecimal r3_amt_fund_non_national) {
		this.r3_amt_fund_non_national = r3_amt_fund_non_national;
	}
	public BigDecimal getR3_avg_fund_non_national() {
		return r3_avg_fund_non_national;
	}
	public void setR3_avg_fund_non_national(BigDecimal r3_avg_fund_non_national) {
		this.r3_avg_fund_non_national = r3_avg_fund_non_national;
	}
	public BigDecimal getR3_acc_unfund_non_national() {
		return r3_acc_unfund_non_national;
	}
	public void setR3_acc_unfund_non_national(BigDecimal r3_acc_unfund_non_national) {
		this.r3_acc_unfund_non_national = r3_acc_unfund_non_national;
	}
	public BigDecimal getR3_amt_unfund_non_national() {
		return r3_amt_unfund_non_national;
	}
	public void setR3_amt_unfund_non_national(BigDecimal r3_amt_unfund_non_national) {
		this.r3_amt_unfund_non_national = r3_amt_unfund_non_national;
	}
	public BigDecimal getR3_ccf_unfund_non_national() {
		return r3_ccf_unfund_non_national;
	}
	public void setR3_ccf_unfund_non_national(BigDecimal r3_ccf_unfund_non_national) {
		this.r3_ccf_unfund_non_national = r3_ccf_unfund_non_national;
	}
	public BigDecimal getR3_stage3_acc_non_national() {
		return r3_stage3_acc_non_national;
	}
	public void setR3_stage3_acc_non_national(BigDecimal r3_stage3_acc_non_national) {
		this.r3_stage3_acc_non_national = r3_stage3_acc_non_national;
	}
	public BigDecimal getR3_amt_stage3_non_national() {
		return r3_amt_stage3_non_national;
	}
	public void setR3_amt_stage3_non_national(BigDecimal r3_amt_stage3_non_national) {
		this.r3_amt_stage3_non_national = r3_amt_stage3_non_national;
	}
	public BigDecimal getR3_acc_total() {
		return r3_acc_total;
	}
	public void setR3_acc_total(BigDecimal r3_acc_total) {
		this.r3_acc_total = r3_acc_total;
	}
	public BigDecimal getR3_fund_amt_total() {
		return r3_fund_amt_total;
	}
	public void setR3_fund_amt_total(BigDecimal r3_fund_amt_total) {
		this.r3_fund_amt_total = r3_fund_amt_total;
	}
	public BigDecimal getR3_avg_total() {
		return r3_avg_total;
	}
	public void setR3_avg_total(BigDecimal r3_avg_total) {
		this.r3_avg_total = r3_avg_total;
	}
	public BigDecimal getR3_fund_ccf_total() {
		return r3_fund_ccf_total;
	}
	public void setR3_fund_ccf_total(BigDecimal r3_fund_ccf_total) {
		this.r3_fund_ccf_total = r3_fund_ccf_total;
	}
	public BigDecimal getR3_stage3_acc_total() {
		return r3_stage3_acc_total;
	}
	public void setR3_stage3_acc_total(BigDecimal r3_stage3_acc_total) {
		this.r3_stage3_acc_total = r3_stage3_acc_total;
	}
	public BigDecimal getR3_amt_stage3_total() {
		return r3_amt_stage3_total;
	}
	public void setR3_amt_stage3_total(BigDecimal r3_amt_stage3_total) {
		this.r3_amt_stage3_total = r3_amt_stage3_total;
	}
	public BigDecimal getR3_stage3_acc_quater() {
		return r3_stage3_acc_quater;
	}
	public void setR3_stage3_acc_quater(BigDecimal r3_stage3_acc_quater) {
		this.r3_stage3_acc_quater = r3_stage3_acc_quater;
	}
	public BigDecimal getR3_amt_stage3_acc_quater() {
		return r3_amt_stage3_acc_quater;
	}
	public void setR3_amt_stage3_acc_quater(BigDecimal r3_amt_stage3_acc_quater) {
		this.r3_amt_stage3_acc_quater = r3_amt_stage3_acc_quater;
	}
	public String getR4_product() {
		return r4_product;
	}
	public void setR4_product(String r4_product) {
		this.r4_product = r4_product;
	}
	public BigDecimal getR4_acc_fund_national() {
		return r4_acc_fund_national;
	}
	public void setR4_acc_fund_national(BigDecimal r4_acc_fund_national) {
		this.r4_acc_fund_national = r4_acc_fund_national;
	}
	public BigDecimal getR4_amt_fund_national() {
		return r4_amt_fund_national;
	}
	public void setR4_amt_fund_national(BigDecimal r4_amt_fund_national) {
		this.r4_amt_fund_national = r4_amt_fund_national;
	}
	public BigDecimal getR4_avg_fund_national() {
		return r4_avg_fund_national;
	}
	public void setR4_avg_fund_national(BigDecimal r4_avg_fund_national) {
		this.r4_avg_fund_national = r4_avg_fund_national;
	}
	public BigDecimal getR4_acc_unfund_national() {
		return r4_acc_unfund_national;
	}
	public void setR4_acc_unfund_national(BigDecimal r4_acc_unfund_national) {
		this.r4_acc_unfund_national = r4_acc_unfund_national;
	}
	public BigDecimal getR4_amt_unfund_national() {
		return r4_amt_unfund_national;
	}
	public void setR4_amt_unfund_national(BigDecimal r4_amt_unfund_national) {
		this.r4_amt_unfund_national = r4_amt_unfund_national;
	}
	public BigDecimal getR4_ccf_unfund_national() {
		return r4_ccf_unfund_national;
	}
	public void setR4_ccf_unfund_national(BigDecimal r4_ccf_unfund_national) {
		this.r4_ccf_unfund_national = r4_ccf_unfund_national;
	}
	public BigDecimal getR4_stage3_acc_national() {
		return r4_stage3_acc_national;
	}
	public void setR4_stage3_acc_national(BigDecimal r4_stage3_acc_national) {
		this.r4_stage3_acc_national = r4_stage3_acc_national;
	}
	public BigDecimal getR4_amt_stage3_national() {
		return r4_amt_stage3_national;
	}
	public void setR4_amt_stage3_national(BigDecimal r4_amt_stage3_national) {
		this.r4_amt_stage3_national = r4_amt_stage3_national;
	}
	public BigDecimal getR4_acc_fund_non_national() {
		return r4_acc_fund_non_national;
	}
	public void setR4_acc_fund_non_national(BigDecimal r4_acc_fund_non_national) {
		this.r4_acc_fund_non_national = r4_acc_fund_non_national;
	}
	public BigDecimal getR4_amt_fund_non_national() {
		return r4_amt_fund_non_national;
	}
	public void setR4_amt_fund_non_national(BigDecimal r4_amt_fund_non_national) {
		this.r4_amt_fund_non_national = r4_amt_fund_non_national;
	}
	public BigDecimal getR4_avg_fund_non_national() {
		return r4_avg_fund_non_national;
	}
	public void setR4_avg_fund_non_national(BigDecimal r4_avg_fund_non_national) {
		this.r4_avg_fund_non_national = r4_avg_fund_non_national;
	}
	public BigDecimal getR4_acc_unfund_non_national() {
		return r4_acc_unfund_non_national;
	}
	public void setR4_acc_unfund_non_national(BigDecimal r4_acc_unfund_non_national) {
		this.r4_acc_unfund_non_national = r4_acc_unfund_non_national;
	}
	public BigDecimal getR4_amt_unfund_non_national() {
		return r4_amt_unfund_non_national;
	}
	public void setR4_amt_unfund_non_national(BigDecimal r4_amt_unfund_non_national) {
		this.r4_amt_unfund_non_national = r4_amt_unfund_non_national;
	}
	public BigDecimal getR4_ccf_unfund_non_national() {
		return r4_ccf_unfund_non_national;
	}
	public void setR4_ccf_unfund_non_national(BigDecimal r4_ccf_unfund_non_national) {
		this.r4_ccf_unfund_non_national = r4_ccf_unfund_non_national;
	}
	public BigDecimal getR4_stage3_acc_non_national() {
		return r4_stage3_acc_non_national;
	}
	public void setR4_stage3_acc_non_national(BigDecimal r4_stage3_acc_non_national) {
		this.r4_stage3_acc_non_national = r4_stage3_acc_non_national;
	}
	public BigDecimal getR4_amt_stage3_non_national() {
		return r4_amt_stage3_non_national;
	}
	public void setR4_amt_stage3_non_national(BigDecimal r4_amt_stage3_non_national) {
		this.r4_amt_stage3_non_national = r4_amt_stage3_non_national;
	}
	public BigDecimal getR4_acc_total() {
		return r4_acc_total;
	}
	public void setR4_acc_total(BigDecimal r4_acc_total) {
		this.r4_acc_total = r4_acc_total;
	}
	public BigDecimal getR4_fund_amt_total() {
		return r4_fund_amt_total;
	}
	public void setR4_fund_amt_total(BigDecimal r4_fund_amt_total) {
		this.r4_fund_amt_total = r4_fund_amt_total;
	}
	public BigDecimal getR4_avg_total() {
		return r4_avg_total;
	}
	public void setR4_avg_total(BigDecimal r4_avg_total) {
		this.r4_avg_total = r4_avg_total;
	}
	public BigDecimal getR4_fund_ccf_total() {
		return r4_fund_ccf_total;
	}
	public void setR4_fund_ccf_total(BigDecimal r4_fund_ccf_total) {
		this.r4_fund_ccf_total = r4_fund_ccf_total;
	}
	public BigDecimal getR4_stage3_acc_total() {
		return r4_stage3_acc_total;
	}
	public void setR4_stage3_acc_total(BigDecimal r4_stage3_acc_total) {
		this.r4_stage3_acc_total = r4_stage3_acc_total;
	}
	public BigDecimal getR4_amt_stage3_total() {
		return r4_amt_stage3_total;
	}
	public void setR4_amt_stage3_total(BigDecimal r4_amt_stage3_total) {
		this.r4_amt_stage3_total = r4_amt_stage3_total;
	}
	public BigDecimal getR4_stage3_acc_quater() {
		return r4_stage3_acc_quater;
	}
	public void setR4_stage3_acc_quater(BigDecimal r4_stage3_acc_quater) {
		this.r4_stage3_acc_quater = r4_stage3_acc_quater;
	}
	public BigDecimal getR4_amt_stage3_acc_quater() {
		return r4_amt_stage3_acc_quater;
	}
	public void setR4_amt_stage3_acc_quater(BigDecimal r4_amt_stage3_acc_quater) {
		this.r4_amt_stage3_acc_quater = r4_amt_stage3_acc_quater;
	}
	public String getR5_product() {
		return r5_product;
	}
	public void setR5_product(String r5_product) {
		this.r5_product = r5_product;
	}
	public BigDecimal getR5_acc_fund_national() {
		return r5_acc_fund_national;
	}
	public void setR5_acc_fund_national(BigDecimal r5_acc_fund_national) {
		this.r5_acc_fund_national = r5_acc_fund_national;
	}
	public BigDecimal getR5_amt_fund_national() {
		return r5_amt_fund_national;
	}
	public void setR5_amt_fund_national(BigDecimal r5_amt_fund_national) {
		this.r5_amt_fund_national = r5_amt_fund_national;
	}
	public BigDecimal getR5_avg_fund_national() {
		return r5_avg_fund_national;
	}
	public void setR5_avg_fund_national(BigDecimal r5_avg_fund_national) {
		this.r5_avg_fund_national = r5_avg_fund_national;
	}
	public BigDecimal getR5_acc_unfund_national() {
		return r5_acc_unfund_national;
	}
	public void setR5_acc_unfund_national(BigDecimal r5_acc_unfund_national) {
		this.r5_acc_unfund_national = r5_acc_unfund_national;
	}
	public BigDecimal getR5_amt_unfund_national() {
		return r5_amt_unfund_national;
	}
	public void setR5_amt_unfund_national(BigDecimal r5_amt_unfund_national) {
		this.r5_amt_unfund_national = r5_amt_unfund_national;
	}
	public BigDecimal getR5_ccf_unfund_national() {
		return r5_ccf_unfund_national;
	}
	public void setR5_ccf_unfund_national(BigDecimal r5_ccf_unfund_national) {
		this.r5_ccf_unfund_national = r5_ccf_unfund_national;
	}
	public BigDecimal getR5_stage3_acc_national() {
		return r5_stage3_acc_national;
	}
	public void setR5_stage3_acc_national(BigDecimal r5_stage3_acc_national) {
		this.r5_stage3_acc_national = r5_stage3_acc_national;
	}
	public BigDecimal getR5_amt_stage3_national() {
		return r5_amt_stage3_national;
	}
	public void setR5_amt_stage3_national(BigDecimal r5_amt_stage3_national) {
		this.r5_amt_stage3_national = r5_amt_stage3_national;
	}
	public BigDecimal getR5_acc_fund_non_national() {
		return r5_acc_fund_non_national;
	}
	public void setR5_acc_fund_non_national(BigDecimal r5_acc_fund_non_national) {
		this.r5_acc_fund_non_national = r5_acc_fund_non_national;
	}
	public BigDecimal getR5_amt_fund_non_national() {
		return r5_amt_fund_non_national;
	}
	public void setR5_amt_fund_non_national(BigDecimal r5_amt_fund_non_national) {
		this.r5_amt_fund_non_national = r5_amt_fund_non_national;
	}
	public BigDecimal getR5_avg_fund_non_national() {
		return r5_avg_fund_non_national;
	}
	public void setR5_avg_fund_non_national(BigDecimal r5_avg_fund_non_national) {
		this.r5_avg_fund_non_national = r5_avg_fund_non_national;
	}
	public BigDecimal getR5_acc_unfund_non_national() {
		return r5_acc_unfund_non_national;
	}
	public void setR5_acc_unfund_non_national(BigDecimal r5_acc_unfund_non_national) {
		this.r5_acc_unfund_non_national = r5_acc_unfund_non_national;
	}
	public BigDecimal getR5_amt_unfund_non_national() {
		return r5_amt_unfund_non_national;
	}
	public void setR5_amt_unfund_non_national(BigDecimal r5_amt_unfund_non_national) {
		this.r5_amt_unfund_non_national = r5_amt_unfund_non_national;
	}
	public BigDecimal getR5_ccf_unfund_non_national() {
		return r5_ccf_unfund_non_national;
	}
	public void setR5_ccf_unfund_non_national(BigDecimal r5_ccf_unfund_non_national) {
		this.r5_ccf_unfund_non_national = r5_ccf_unfund_non_national;
	}
	public BigDecimal getR5_stage3_acc_non_national() {
		return r5_stage3_acc_non_national;
	}
	public void setR5_stage3_acc_non_national(BigDecimal r5_stage3_acc_non_national) {
		this.r5_stage3_acc_non_national = r5_stage3_acc_non_national;
	}
	public BigDecimal getR5_amt_stage3_non_national() {
		return r5_amt_stage3_non_national;
	}
	public void setR5_amt_stage3_non_national(BigDecimal r5_amt_stage3_non_national) {
		this.r5_amt_stage3_non_national = r5_amt_stage3_non_national;
	}
	public BigDecimal getR5_acc_total() {
		return r5_acc_total;
	}
	public void setR5_acc_total(BigDecimal r5_acc_total) {
		this.r5_acc_total = r5_acc_total;
	}
	public BigDecimal getR5_fund_amt_total() {
		return r5_fund_amt_total;
	}
	public void setR5_fund_amt_total(BigDecimal r5_fund_amt_total) {
		this.r5_fund_amt_total = r5_fund_amt_total;
	}
	public BigDecimal getR5_avg_total() {
		return r5_avg_total;
	}
	public void setR5_avg_total(BigDecimal r5_avg_total) {
		this.r5_avg_total = r5_avg_total;
	}
	public BigDecimal getR5_fund_ccf_total() {
		return r5_fund_ccf_total;
	}
	public void setR5_fund_ccf_total(BigDecimal r5_fund_ccf_total) {
		this.r5_fund_ccf_total = r5_fund_ccf_total;
	}
	public BigDecimal getR5_stage3_acc_total() {
		return r5_stage3_acc_total;
	}
	public void setR5_stage3_acc_total(BigDecimal r5_stage3_acc_total) {
		this.r5_stage3_acc_total = r5_stage3_acc_total;
	}
	public BigDecimal getR5_amt_stage3_total() {
		return r5_amt_stage3_total;
	}
	public void setR5_amt_stage3_total(BigDecimal r5_amt_stage3_total) {
		this.r5_amt_stage3_total = r5_amt_stage3_total;
	}
	public BigDecimal getR5_stage3_acc_quater() {
		return r5_stage3_acc_quater;
	}
	public void setR5_stage3_acc_quater(BigDecimal r5_stage3_acc_quater) {
		this.r5_stage3_acc_quater = r5_stage3_acc_quater;
	}
	public BigDecimal getR5_amt_stage3_acc_quater() {
		return r5_amt_stage3_acc_quater;
	}
	public void setR5_amt_stage3_acc_quater(BigDecimal r5_amt_stage3_acc_quater) {
		this.r5_amt_stage3_acc_quater = r5_amt_stage3_acc_quater;
	}
	public String getR6_product() {
		return r6_product;
	}
	public void setR6_product(String r6_product) {
		this.r6_product = r6_product;
	}
	public BigDecimal getR6_acc_fund_national() {
		return r6_acc_fund_national;
	}
	public void setR6_acc_fund_national(BigDecimal r6_acc_fund_national) {
		this.r6_acc_fund_national = r6_acc_fund_national;
	}
	public BigDecimal getR6_amt_fund_national() {
		return r6_amt_fund_national;
	}
	public void setR6_amt_fund_national(BigDecimal r6_amt_fund_national) {
		this.r6_amt_fund_national = r6_amt_fund_national;
	}
	public BigDecimal getR6_avg_fund_national() {
		return r6_avg_fund_national;
	}
	public void setR6_avg_fund_national(BigDecimal r6_avg_fund_national) {
		this.r6_avg_fund_national = r6_avg_fund_national;
	}
	public BigDecimal getR6_acc_unfund_national() {
		return r6_acc_unfund_national;
	}
	public void setR6_acc_unfund_national(BigDecimal r6_acc_unfund_national) {
		this.r6_acc_unfund_national = r6_acc_unfund_national;
	}
	public BigDecimal getR6_amt_unfund_national() {
		return r6_amt_unfund_national;
	}
	public void setR6_amt_unfund_national(BigDecimal r6_amt_unfund_national) {
		this.r6_amt_unfund_national = r6_amt_unfund_national;
	}
	public BigDecimal getR6_ccf_unfund_national() {
		return r6_ccf_unfund_national;
	}
	public void setR6_ccf_unfund_national(BigDecimal r6_ccf_unfund_national) {
		this.r6_ccf_unfund_national = r6_ccf_unfund_national;
	}
	public BigDecimal getR6_stage3_acc_national() {
		return r6_stage3_acc_national;
	}
	public void setR6_stage3_acc_national(BigDecimal r6_stage3_acc_national) {
		this.r6_stage3_acc_national = r6_stage3_acc_national;
	}
	public BigDecimal getR6_amt_stage3_national() {
		return r6_amt_stage3_national;
	}
	public void setR6_amt_stage3_national(BigDecimal r6_amt_stage3_national) {
		this.r6_amt_stage3_national = r6_amt_stage3_national;
	}
	public BigDecimal getR6_acc_fund_non_national() {
		return r6_acc_fund_non_national;
	}
	public void setR6_acc_fund_non_national(BigDecimal r6_acc_fund_non_national) {
		this.r6_acc_fund_non_national = r6_acc_fund_non_national;
	}
	public BigDecimal getR6_amt_fund_non_national() {
		return r6_amt_fund_non_national;
	}
	public void setR6_amt_fund_non_national(BigDecimal r6_amt_fund_non_national) {
		this.r6_amt_fund_non_national = r6_amt_fund_non_national;
	}
	public BigDecimal getR6_avg_fund_non_national() {
		return r6_avg_fund_non_national;
	}
	public void setR6_avg_fund_non_national(BigDecimal r6_avg_fund_non_national) {
		this.r6_avg_fund_non_national = r6_avg_fund_non_national;
	}
	public BigDecimal getR6_acc_unfund_non_national() {
		return r6_acc_unfund_non_national;
	}
	public void setR6_acc_unfund_non_national(BigDecimal r6_acc_unfund_non_national) {
		this.r6_acc_unfund_non_national = r6_acc_unfund_non_national;
	}
	public BigDecimal getR6_amt_unfund_non_national() {
		return r6_amt_unfund_non_national;
	}
	public void setR6_amt_unfund_non_national(BigDecimal r6_amt_unfund_non_national) {
		this.r6_amt_unfund_non_national = r6_amt_unfund_non_national;
	}
	public BigDecimal getR6_ccf_unfund_non_national() {
		return r6_ccf_unfund_non_national;
	}
	public void setR6_ccf_unfund_non_national(BigDecimal r6_ccf_unfund_non_national) {
		this.r6_ccf_unfund_non_national = r6_ccf_unfund_non_national;
	}
	public BigDecimal getR6_stage3_acc_non_national() {
		return r6_stage3_acc_non_national;
	}
	public void setR6_stage3_acc_non_national(BigDecimal r6_stage3_acc_non_national) {
		this.r6_stage3_acc_non_national = r6_stage3_acc_non_national;
	}
	public BigDecimal getR6_amt_stage3_non_national() {
		return r6_amt_stage3_non_national;
	}
	public void setR6_amt_stage3_non_national(BigDecimal r6_amt_stage3_non_national) {
		this.r6_amt_stage3_non_national = r6_amt_stage3_non_national;
	}
	public BigDecimal getR6_acc_total() {
		return r6_acc_total;
	}
	public void setR6_acc_total(BigDecimal r6_acc_total) {
		this.r6_acc_total = r6_acc_total;
	}
	public BigDecimal getR6_fund_amt_total() {
		return r6_fund_amt_total;
	}
	public void setR6_fund_amt_total(BigDecimal r6_fund_amt_total) {
		this.r6_fund_amt_total = r6_fund_amt_total;
	}
	public BigDecimal getR6_avg_total() {
		return r6_avg_total;
	}
	public void setR6_avg_total(BigDecimal r6_avg_total) {
		this.r6_avg_total = r6_avg_total;
	}
	public BigDecimal getR6_fund_ccf_total() {
		return r6_fund_ccf_total;
	}
	public void setR6_fund_ccf_total(BigDecimal r6_fund_ccf_total) {
		this.r6_fund_ccf_total = r6_fund_ccf_total;
	}
	public BigDecimal getR6_stage3_acc_total() {
		return r6_stage3_acc_total;
	}
	public void setR6_stage3_acc_total(BigDecimal r6_stage3_acc_total) {
		this.r6_stage3_acc_total = r6_stage3_acc_total;
	}
	public BigDecimal getR6_amt_stage3_total() {
		return r6_amt_stage3_total;
	}
	public void setR6_amt_stage3_total(BigDecimal r6_amt_stage3_total) {
		this.r6_amt_stage3_total = r6_amt_stage3_total;
	}
	public BigDecimal getR6_stage3_acc_quater() {
		return r6_stage3_acc_quater;
	}
	public void setR6_stage3_acc_quater(BigDecimal r6_stage3_acc_quater) {
		this.r6_stage3_acc_quater = r6_stage3_acc_quater;
	}
	public BigDecimal getR6_amt_stage3_acc_quater() {
		return r6_amt_stage3_acc_quater;
	}
	public void setR6_amt_stage3_acc_quater(BigDecimal r6_amt_stage3_acc_quater) {
		this.r6_amt_stage3_acc_quater = r6_amt_stage3_acc_quater;
	}
	public String getR7_product() {
		return r7_product;
	}
	public void setR7_product(String r7_product) {
		this.r7_product = r7_product;
	}
	public BigDecimal getR7_acc_fund_national() {
		return r7_acc_fund_national;
	}
	public void setR7_acc_fund_national(BigDecimal r7_acc_fund_national) {
		this.r7_acc_fund_national = r7_acc_fund_national;
	}
	public BigDecimal getR7_amt_fund_national() {
		return r7_amt_fund_national;
	}
	public void setR7_amt_fund_national(BigDecimal r7_amt_fund_national) {
		this.r7_amt_fund_national = r7_amt_fund_national;
	}
	public BigDecimal getR7_avg_fund_national() {
		return r7_avg_fund_national;
	}
	public void setR7_avg_fund_national(BigDecimal r7_avg_fund_national) {
		this.r7_avg_fund_national = r7_avg_fund_national;
	}
	public BigDecimal getR7_acc_unfund_national() {
		return r7_acc_unfund_national;
	}
	public void setR7_acc_unfund_national(BigDecimal r7_acc_unfund_national) {
		this.r7_acc_unfund_national = r7_acc_unfund_national;
	}
	public BigDecimal getR7_amt_unfund_national() {
		return r7_amt_unfund_national;
	}
	public void setR7_amt_unfund_national(BigDecimal r7_amt_unfund_national) {
		this.r7_amt_unfund_national = r7_amt_unfund_national;
	}
	public BigDecimal getR7_ccf_unfund_national() {
		return r7_ccf_unfund_national;
	}
	public void setR7_ccf_unfund_national(BigDecimal r7_ccf_unfund_national) {
		this.r7_ccf_unfund_national = r7_ccf_unfund_national;
	}
	public BigDecimal getR7_stage3_acc_national() {
		return r7_stage3_acc_national;
	}
	public void setR7_stage3_acc_national(BigDecimal r7_stage3_acc_national) {
		this.r7_stage3_acc_national = r7_stage3_acc_national;
	}
	public BigDecimal getR7_amt_stage3_national() {
		return r7_amt_stage3_national;
	}
	public void setR7_amt_stage3_national(BigDecimal r7_amt_stage3_national) {
		this.r7_amt_stage3_national = r7_amt_stage3_national;
	}
	public BigDecimal getR7_acc_fund_non_national() {
		return r7_acc_fund_non_national;
	}
	public void setR7_acc_fund_non_national(BigDecimal r7_acc_fund_non_national) {
		this.r7_acc_fund_non_national = r7_acc_fund_non_national;
	}
	public BigDecimal getR7_amt_fund_non_national() {
		return r7_amt_fund_non_national;
	}
	public void setR7_amt_fund_non_national(BigDecimal r7_amt_fund_non_national) {
		this.r7_amt_fund_non_national = r7_amt_fund_non_national;
	}
	public BigDecimal getR7_avg_fund_non_national() {
		return r7_avg_fund_non_national;
	}
	public void setR7_avg_fund_non_national(BigDecimal r7_avg_fund_non_national) {
		this.r7_avg_fund_non_national = r7_avg_fund_non_national;
	}
	public BigDecimal getR7_acc_unfund_non_national() {
		return r7_acc_unfund_non_national;
	}
	public void setR7_acc_unfund_non_national(BigDecimal r7_acc_unfund_non_national) {
		this.r7_acc_unfund_non_national = r7_acc_unfund_non_national;
	}
	public BigDecimal getR7_amt_unfund_non_national() {
		return r7_amt_unfund_non_national;
	}
	public void setR7_amt_unfund_non_national(BigDecimal r7_amt_unfund_non_national) {
		this.r7_amt_unfund_non_national = r7_amt_unfund_non_national;
	}
	public BigDecimal getR7_ccf_unfund_non_national() {
		return r7_ccf_unfund_non_national;
	}
	public void setR7_ccf_unfund_non_national(BigDecimal r7_ccf_unfund_non_national) {
		this.r7_ccf_unfund_non_national = r7_ccf_unfund_non_national;
	}
	public BigDecimal getR7_stage3_acc_non_national() {
		return r7_stage3_acc_non_national;
	}
	public void setR7_stage3_acc_non_national(BigDecimal r7_stage3_acc_non_national) {
		this.r7_stage3_acc_non_national = r7_stage3_acc_non_national;
	}
	public BigDecimal getR7_amt_stage3_non_national() {
		return r7_amt_stage3_non_national;
	}
	public void setR7_amt_stage3_non_national(BigDecimal r7_amt_stage3_non_national) {
		this.r7_amt_stage3_non_national = r7_amt_stage3_non_national;
	}
	public BigDecimal getR7_acc_total() {
		return r7_acc_total;
	}
	public void setR7_acc_total(BigDecimal r7_acc_total) {
		this.r7_acc_total = r7_acc_total;
	}
	public BigDecimal getR7_fund_amt_total() {
		return r7_fund_amt_total;
	}
	public void setR7_fund_amt_total(BigDecimal r7_fund_amt_total) {
		this.r7_fund_amt_total = r7_fund_amt_total;
	}
	public BigDecimal getR7_avg_total() {
		return r7_avg_total;
	}
	public void setR7_avg_total(BigDecimal r7_avg_total) {
		this.r7_avg_total = r7_avg_total;
	}
	public BigDecimal getR7_fund_ccf_total() {
		return r7_fund_ccf_total;
	}
	public void setR7_fund_ccf_total(BigDecimal r7_fund_ccf_total) {
		this.r7_fund_ccf_total = r7_fund_ccf_total;
	}
	public BigDecimal getR7_stage3_acc_total() {
		return r7_stage3_acc_total;
	}
	public void setR7_stage3_acc_total(BigDecimal r7_stage3_acc_total) {
		this.r7_stage3_acc_total = r7_stage3_acc_total;
	}
	public BigDecimal getR7_amt_stage3_total() {
		return r7_amt_stage3_total;
	}
	public void setR7_amt_stage3_total(BigDecimal r7_amt_stage3_total) {
		this.r7_amt_stage3_total = r7_amt_stage3_total;
	}
	public BigDecimal getR7_stage3_acc_quater() {
		return r7_stage3_acc_quater;
	}
	public void setR7_stage3_acc_quater(BigDecimal r7_stage3_acc_quater) {
		this.r7_stage3_acc_quater = r7_stage3_acc_quater;
	}
	public BigDecimal getR7_amt_stage3_acc_quater() {
		return r7_amt_stage3_acc_quater;
	}
	public void setR7_amt_stage3_acc_quater(BigDecimal r7_amt_stage3_acc_quater) {
		this.r7_amt_stage3_acc_quater = r7_amt_stage3_acc_quater;
	}
	public String getR8_product() {
		return r8_product;
	}
	public void setR8_product(String r8_product) {
		this.r8_product = r8_product;
	}
	public BigDecimal getR8_acc_fund_national() {
		return r8_acc_fund_national;
	}
	public void setR8_acc_fund_national(BigDecimal r8_acc_fund_national) {
		this.r8_acc_fund_national = r8_acc_fund_national;
	}
	public BigDecimal getR8_amt_fund_national() {
		return r8_amt_fund_national;
	}
	public void setR8_amt_fund_national(BigDecimal r8_amt_fund_national) {
		this.r8_amt_fund_national = r8_amt_fund_national;
	}
	public BigDecimal getR8_avg_fund_national() {
		return r8_avg_fund_national;
	}
	public void setR8_avg_fund_national(BigDecimal r8_avg_fund_national) {
		this.r8_avg_fund_national = r8_avg_fund_national;
	}
	public BigDecimal getR8_acc_unfund_national() {
		return r8_acc_unfund_national;
	}
	public void setR8_acc_unfund_national(BigDecimal r8_acc_unfund_national) {
		this.r8_acc_unfund_national = r8_acc_unfund_national;
	}
	public BigDecimal getR8_amt_unfund_national() {
		return r8_amt_unfund_national;
	}
	public void setR8_amt_unfund_national(BigDecimal r8_amt_unfund_national) {
		this.r8_amt_unfund_national = r8_amt_unfund_national;
	}
	public BigDecimal getR8_ccf_unfund_national() {
		return r8_ccf_unfund_national;
	}
	public void setR8_ccf_unfund_national(BigDecimal r8_ccf_unfund_national) {
		this.r8_ccf_unfund_national = r8_ccf_unfund_national;
	}
	public BigDecimal getR8_stage3_acc_national() {
		return r8_stage3_acc_national;
	}
	public void setR8_stage3_acc_national(BigDecimal r8_stage3_acc_national) {
		this.r8_stage3_acc_national = r8_stage3_acc_national;
	}
	public BigDecimal getR8_amt_stage3_national() {
		return r8_amt_stage3_national;
	}
	public void setR8_amt_stage3_national(BigDecimal r8_amt_stage3_national) {
		this.r8_amt_stage3_national = r8_amt_stage3_national;
	}
	public BigDecimal getR8_acc_fund_non_national() {
		return r8_acc_fund_non_national;
	}
	public void setR8_acc_fund_non_national(BigDecimal r8_acc_fund_non_national) {
		this.r8_acc_fund_non_national = r8_acc_fund_non_national;
	}
	public BigDecimal getR8_amt_fund_non_national() {
		return r8_amt_fund_non_national;
	}
	public void setR8_amt_fund_non_national(BigDecimal r8_amt_fund_non_national) {
		this.r8_amt_fund_non_national = r8_amt_fund_non_national;
	}
	public BigDecimal getR8_avg_fund_non_national() {
		return r8_avg_fund_non_national;
	}
	public void setR8_avg_fund_non_national(BigDecimal r8_avg_fund_non_national) {
		this.r8_avg_fund_non_national = r8_avg_fund_non_national;
	}
	public BigDecimal getR8_acc_unfund_non_national() {
		return r8_acc_unfund_non_national;
	}
	public void setR8_acc_unfund_non_national(BigDecimal r8_acc_unfund_non_national) {
		this.r8_acc_unfund_non_national = r8_acc_unfund_non_national;
	}
	public BigDecimal getR8_amt_unfund_non_national() {
		return r8_amt_unfund_non_national;
	}
	public void setR8_amt_unfund_non_national(BigDecimal r8_amt_unfund_non_national) {
		this.r8_amt_unfund_non_national = r8_amt_unfund_non_national;
	}
	public BigDecimal getR8_ccf_unfund_non_national() {
		return r8_ccf_unfund_non_national;
	}
	public void setR8_ccf_unfund_non_national(BigDecimal r8_ccf_unfund_non_national) {
		this.r8_ccf_unfund_non_national = r8_ccf_unfund_non_national;
	}
	public BigDecimal getR8_stage3_acc_non_national() {
		return r8_stage3_acc_non_national;
	}
	public void setR8_stage3_acc_non_national(BigDecimal r8_stage3_acc_non_national) {
		this.r8_stage3_acc_non_national = r8_stage3_acc_non_national;
	}
	public BigDecimal getR8_amt_stage3_non_national() {
		return r8_amt_stage3_non_national;
	}
	public void setR8_amt_stage3_non_national(BigDecimal r8_amt_stage3_non_national) {
		this.r8_amt_stage3_non_national = r8_amt_stage3_non_national;
	}
	public BigDecimal getR8_acc_total() {
		return r8_acc_total;
	}
	public void setR8_acc_total(BigDecimal r8_acc_total) {
		this.r8_acc_total = r8_acc_total;
	}
	public BigDecimal getR8_fund_amt_total() {
		return r8_fund_amt_total;
	}
	public void setR8_fund_amt_total(BigDecimal r8_fund_amt_total) {
		this.r8_fund_amt_total = r8_fund_amt_total;
	}
	public BigDecimal getR8_avg_total() {
		return r8_avg_total;
	}
	public void setR8_avg_total(BigDecimal r8_avg_total) {
		this.r8_avg_total = r8_avg_total;
	}
	public BigDecimal getR8_fund_ccf_total() {
		return r8_fund_ccf_total;
	}
	public void setR8_fund_ccf_total(BigDecimal r8_fund_ccf_total) {
		this.r8_fund_ccf_total = r8_fund_ccf_total;
	}
	public BigDecimal getR8_stage3_acc_total() {
		return r8_stage3_acc_total;
	}
	public void setR8_stage3_acc_total(BigDecimal r8_stage3_acc_total) {
		this.r8_stage3_acc_total = r8_stage3_acc_total;
	}
	public BigDecimal getR8_amt_stage3_total() {
		return r8_amt_stage3_total;
	}
	public void setR8_amt_stage3_total(BigDecimal r8_amt_stage3_total) {
		this.r8_amt_stage3_total = r8_amt_stage3_total;
	}
	public BigDecimal getR8_stage3_acc_quater() {
		return r8_stage3_acc_quater;
	}
	public void setR8_stage3_acc_quater(BigDecimal r8_stage3_acc_quater) {
		this.r8_stage3_acc_quater = r8_stage3_acc_quater;
	}
	public BigDecimal getR8_amt_stage3_acc_quater() {
		return r8_amt_stage3_acc_quater;
	}
	public void setR8_amt_stage3_acc_quater(BigDecimal r8_amt_stage3_acc_quater) {
		this.r8_amt_stage3_acc_quater = r8_amt_stage3_acc_quater;
	}
	public String getR9_product() {
		return r9_product;
	}
	public void setR9_product(String r9_product) {
		this.r9_product = r9_product;
	}
	public BigDecimal getR9_acc_fund_national() {
		return r9_acc_fund_national;
	}
	public void setR9_acc_fund_national(BigDecimal r9_acc_fund_national) {
		this.r9_acc_fund_national = r9_acc_fund_national;
	}
	public BigDecimal getR9_amt_fund_national() {
		return r9_amt_fund_national;
	}
	public void setR9_amt_fund_national(BigDecimal r9_amt_fund_national) {
		this.r9_amt_fund_national = r9_amt_fund_national;
	}
	public BigDecimal getR9_avg_fund_national() {
		return r9_avg_fund_national;
	}
	public void setR9_avg_fund_national(BigDecimal r9_avg_fund_national) {
		this.r9_avg_fund_national = r9_avg_fund_national;
	}
	public BigDecimal getR9_acc_unfund_national() {
		return r9_acc_unfund_national;
	}
	public void setR9_acc_unfund_national(BigDecimal r9_acc_unfund_national) {
		this.r9_acc_unfund_national = r9_acc_unfund_national;
	}
	public BigDecimal getR9_amt_unfund_national() {
		return r9_amt_unfund_national;
	}
	public void setR9_amt_unfund_national(BigDecimal r9_amt_unfund_national) {
		this.r9_amt_unfund_national = r9_amt_unfund_national;
	}
	public BigDecimal getR9_ccf_unfund_national() {
		return r9_ccf_unfund_national;
	}
	public void setR9_ccf_unfund_national(BigDecimal r9_ccf_unfund_national) {
		this.r9_ccf_unfund_national = r9_ccf_unfund_national;
	}
	public BigDecimal getR9_stage3_acc_national() {
		return r9_stage3_acc_national;
	}
	public void setR9_stage3_acc_national(BigDecimal r9_stage3_acc_national) {
		this.r9_stage3_acc_national = r9_stage3_acc_national;
	}
	public BigDecimal getR9_amt_stage3_national() {
		return r9_amt_stage3_national;
	}
	public void setR9_amt_stage3_national(BigDecimal r9_amt_stage3_national) {
		this.r9_amt_stage3_national = r9_amt_stage3_national;
	}
	public BigDecimal getR9_acc_fund_non_national() {
		return r9_acc_fund_non_national;
	}
	public void setR9_acc_fund_non_national(BigDecimal r9_acc_fund_non_national) {
		this.r9_acc_fund_non_national = r9_acc_fund_non_national;
	}
	public BigDecimal getR9_amt_fund_non_national() {
		return r9_amt_fund_non_national;
	}
	public void setR9_amt_fund_non_national(BigDecimal r9_amt_fund_non_national) {
		this.r9_amt_fund_non_national = r9_amt_fund_non_national;
	}
	public BigDecimal getR9_avg_fund_non_national() {
		return r9_avg_fund_non_national;
	}
	public void setR9_avg_fund_non_national(BigDecimal r9_avg_fund_non_national) {
		this.r9_avg_fund_non_national = r9_avg_fund_non_national;
	}
	public BigDecimal getR9_acc_unfund_non_national() {
		return r9_acc_unfund_non_national;
	}
	public void setR9_acc_unfund_non_national(BigDecimal r9_acc_unfund_non_national) {
		this.r9_acc_unfund_non_national = r9_acc_unfund_non_national;
	}
	public BigDecimal getR9_amt_unfund_non_national() {
		return r9_amt_unfund_non_national;
	}
	public void setR9_amt_unfund_non_national(BigDecimal r9_amt_unfund_non_national) {
		this.r9_amt_unfund_non_national = r9_amt_unfund_non_national;
	}
	public BigDecimal getR9_ccf_unfund_non_national() {
		return r9_ccf_unfund_non_national;
	}
	public void setR9_ccf_unfund_non_national(BigDecimal r9_ccf_unfund_non_national) {
		this.r9_ccf_unfund_non_national = r9_ccf_unfund_non_national;
	}
	public BigDecimal getR9_stage3_acc_non_national() {
		return r9_stage3_acc_non_national;
	}
	public void setR9_stage3_acc_non_national(BigDecimal r9_stage3_acc_non_national) {
		this.r9_stage3_acc_non_national = r9_stage3_acc_non_national;
	}
	public BigDecimal getR9_amt_stage3_non_national() {
		return r9_amt_stage3_non_national;
	}
	public void setR9_amt_stage3_non_national(BigDecimal r9_amt_stage3_non_national) {
		this.r9_amt_stage3_non_national = r9_amt_stage3_non_national;
	}
	public BigDecimal getR9_acc_total() {
		return r9_acc_total;
	}
	public void setR9_acc_total(BigDecimal r9_acc_total) {
		this.r9_acc_total = r9_acc_total;
	}
	public BigDecimal getR9_fund_amt_total() {
		return r9_fund_amt_total;
	}
	public void setR9_fund_amt_total(BigDecimal r9_fund_amt_total) {
		this.r9_fund_amt_total = r9_fund_amt_total;
	}
	public BigDecimal getR9_avg_total() {
		return r9_avg_total;
	}
	public void setR9_avg_total(BigDecimal r9_avg_total) {
		this.r9_avg_total = r9_avg_total;
	}
	public BigDecimal getR9_fund_ccf_total() {
		return r9_fund_ccf_total;
	}
	public void setR9_fund_ccf_total(BigDecimal r9_fund_ccf_total) {
		this.r9_fund_ccf_total = r9_fund_ccf_total;
	}
	public BigDecimal getR9_stage3_acc_total() {
		return r9_stage3_acc_total;
	}
	public void setR9_stage3_acc_total(BigDecimal r9_stage3_acc_total) {
		this.r9_stage3_acc_total = r9_stage3_acc_total;
	}
	public BigDecimal getR9_amt_stage3_total() {
		return r9_amt_stage3_total;
	}
	public void setR9_amt_stage3_total(BigDecimal r9_amt_stage3_total) {
		this.r9_amt_stage3_total = r9_amt_stage3_total;
	}
	public BigDecimal getR9_stage3_acc_quater() {
		return r9_stage3_acc_quater;
	}
	public void setR9_stage3_acc_quater(BigDecimal r9_stage3_acc_quater) {
		this.r9_stage3_acc_quater = r9_stage3_acc_quater;
	}
	public BigDecimal getR9_amt_stage3_acc_quater() {
		return r9_amt_stage3_acc_quater;
	}
	public void setR9_amt_stage3_acc_quater(BigDecimal r9_amt_stage3_acc_quater) {
		this.r9_amt_stage3_acc_quater = r9_amt_stage3_acc_quater;
	}
	public String getR10_product() {
		return r10_product;
	}
	public void setR10_product(String r10_product) {
		this.r10_product = r10_product;
	}
	public BigDecimal getR10_acc_fund_national() {
		return r10_acc_fund_national;
	}
	public void setR10_acc_fund_national(BigDecimal r10_acc_fund_national) {
		this.r10_acc_fund_national = r10_acc_fund_national;
	}
	public BigDecimal getR10_amt_fund_national() {
		return r10_amt_fund_national;
	}
	public void setR10_amt_fund_national(BigDecimal r10_amt_fund_national) {
		this.r10_amt_fund_national = r10_amt_fund_national;
	}
	public BigDecimal getR10_avg_fund_national() {
		return r10_avg_fund_national;
	}
	public void setR10_avg_fund_national(BigDecimal r10_avg_fund_national) {
		this.r10_avg_fund_national = r10_avg_fund_national;
	}
	public BigDecimal getR10_acc_unfund_national() {
		return r10_acc_unfund_national;
	}
	public void setR10_acc_unfund_national(BigDecimal r10_acc_unfund_national) {
		this.r10_acc_unfund_national = r10_acc_unfund_national;
	}
	public BigDecimal getR10_amt_unfund_national() {
		return r10_amt_unfund_national;
	}
	public void setR10_amt_unfund_national(BigDecimal r10_amt_unfund_national) {
		this.r10_amt_unfund_national = r10_amt_unfund_national;
	}
	public BigDecimal getR10_ccf_unfund_national() {
		return r10_ccf_unfund_national;
	}
	public void setR10_ccf_unfund_national(BigDecimal r10_ccf_unfund_national) {
		this.r10_ccf_unfund_national = r10_ccf_unfund_national;
	}
	public BigDecimal getR10_stage3_acc_national() {
		return r10_stage3_acc_national;
	}
	public void setR10_stage3_acc_national(BigDecimal r10_stage3_acc_national) {
		this.r10_stage3_acc_national = r10_stage3_acc_national;
	}
	public BigDecimal getR10_amt_stage3_national() {
		return r10_amt_stage3_national;
	}
	public void setR10_amt_stage3_national(BigDecimal r10_amt_stage3_national) {
		this.r10_amt_stage3_national = r10_amt_stage3_national;
	}
	public BigDecimal getR10_acc_fund_non_national() {
		return r10_acc_fund_non_national;
	}
	public void setR10_acc_fund_non_national(BigDecimal r10_acc_fund_non_national) {
		this.r10_acc_fund_non_national = r10_acc_fund_non_national;
	}
	public BigDecimal getR10_amt_fund_non_national() {
		return r10_amt_fund_non_national;
	}
	public void setR10_amt_fund_non_national(BigDecimal r10_amt_fund_non_national) {
		this.r10_amt_fund_non_national = r10_amt_fund_non_national;
	}
	public BigDecimal getR10_avg_fund_non_national() {
		return r10_avg_fund_non_national;
	}
	public void setR10_avg_fund_non_national(BigDecimal r10_avg_fund_non_national) {
		this.r10_avg_fund_non_national = r10_avg_fund_non_national;
	}
	public BigDecimal getR10_acc_unfund_non_national() {
		return r10_acc_unfund_non_national;
	}
	public void setR10_acc_unfund_non_national(BigDecimal r10_acc_unfund_non_national) {
		this.r10_acc_unfund_non_national = r10_acc_unfund_non_national;
	}
	public BigDecimal getR10_amt_unfund_non_national() {
		return r10_amt_unfund_non_national;
	}
	public void setR10_amt_unfund_non_national(BigDecimal r10_amt_unfund_non_national) {
		this.r10_amt_unfund_non_national = r10_amt_unfund_non_national;
	}
	public BigDecimal getR10_ccf_unfund_non_national() {
		return r10_ccf_unfund_non_national;
	}
	public void setR10_ccf_unfund_non_national(BigDecimal r10_ccf_unfund_non_national) {
		this.r10_ccf_unfund_non_national = r10_ccf_unfund_non_national;
	}
	public BigDecimal getR10_stage3_acc_non_national() {
		return r10_stage3_acc_non_national;
	}
	public void setR10_stage3_acc_non_national(BigDecimal r10_stage3_acc_non_national) {
		this.r10_stage3_acc_non_national = r10_stage3_acc_non_national;
	}
	public BigDecimal getR10_amt_stage3_non_national() {
		return r10_amt_stage3_non_national;
	}
	public void setR10_amt_stage3_non_national(BigDecimal r10_amt_stage3_non_national) {
		this.r10_amt_stage3_non_national = r10_amt_stage3_non_national;
	}
	public BigDecimal getR10_acc_total() {
		return r10_acc_total;
	}
	public void setR10_acc_total(BigDecimal r10_acc_total) {
		this.r10_acc_total = r10_acc_total;
	}
	public BigDecimal getR10_fund_amt_total() {
		return r10_fund_amt_total;
	}
	public void setR10_fund_amt_total(BigDecimal r10_fund_amt_total) {
		this.r10_fund_amt_total = r10_fund_amt_total;
	}
	public BigDecimal getR10_avg_total() {
		return r10_avg_total;
	}
	public void setR10_avg_total(BigDecimal r10_avg_total) {
		this.r10_avg_total = r10_avg_total;
	}
	public BigDecimal getR10_fund_ccf_total() {
		return r10_fund_ccf_total;
	}
	public void setR10_fund_ccf_total(BigDecimal r10_fund_ccf_total) {
		this.r10_fund_ccf_total = r10_fund_ccf_total;
	}
	public BigDecimal getR10_stage3_acc_total() {
		return r10_stage3_acc_total;
	}
	public void setR10_stage3_acc_total(BigDecimal r10_stage3_acc_total) {
		this.r10_stage3_acc_total = r10_stage3_acc_total;
	}
	public BigDecimal getR10_amt_stage3_total() {
		return r10_amt_stage3_total;
	}
	public void setR10_amt_stage3_total(BigDecimal r10_amt_stage3_total) {
		this.r10_amt_stage3_total = r10_amt_stage3_total;
	}
	public BigDecimal getR10_stage3_acc_quater() {
		return r10_stage3_acc_quater;
	}
	public void setR10_stage3_acc_quater(BigDecimal r10_stage3_acc_quater) {
		this.r10_stage3_acc_quater = r10_stage3_acc_quater;
	}
	public BigDecimal getR10_amt_stage3_acc_quater() {
		return r10_amt_stage3_acc_quater;
	}
	public void setR10_amt_stage3_acc_quater(BigDecimal r10_amt_stage3_acc_quater) {
		this.r10_amt_stage3_acc_quater = r10_amt_stage3_acc_quater;
	}
	public String getR11_product() {
		return r11_product;
	}
	public void setR11_product(String r11_product) {
		this.r11_product = r11_product;
	}
	public BigDecimal getR11_acc_fund_national() {
		return r11_acc_fund_national;
	}
	public void setR11_acc_fund_national(BigDecimal r11_acc_fund_national) {
		this.r11_acc_fund_national = r11_acc_fund_national;
	}
	public BigDecimal getR11_amt_fund_national() {
		return r11_amt_fund_national;
	}
	public void setR11_amt_fund_national(BigDecimal r11_amt_fund_national) {
		this.r11_amt_fund_national = r11_amt_fund_national;
	}
	public BigDecimal getR11_avg_fund_national() {
		return r11_avg_fund_national;
	}
	public void setR11_avg_fund_national(BigDecimal r11_avg_fund_national) {
		this.r11_avg_fund_national = r11_avg_fund_national;
	}
	public BigDecimal getR11_acc_unfund_national() {
		return r11_acc_unfund_national;
	}
	public void setR11_acc_unfund_national(BigDecimal r11_acc_unfund_national) {
		this.r11_acc_unfund_national = r11_acc_unfund_national;
	}
	public BigDecimal getR11_amt_unfund_national() {
		return r11_amt_unfund_national;
	}
	public void setR11_amt_unfund_national(BigDecimal r11_amt_unfund_national) {
		this.r11_amt_unfund_national = r11_amt_unfund_national;
	}
	public BigDecimal getR11_ccf_unfund_national() {
		return r11_ccf_unfund_national;
	}
	public void setR11_ccf_unfund_national(BigDecimal r11_ccf_unfund_national) {
		this.r11_ccf_unfund_national = r11_ccf_unfund_national;
	}
	public BigDecimal getR11_stage3_acc_national() {
		return r11_stage3_acc_national;
	}
	public void setR11_stage3_acc_national(BigDecimal r11_stage3_acc_national) {
		this.r11_stage3_acc_national = r11_stage3_acc_national;
	}
	public BigDecimal getR11_amt_stage3_national() {
		return r11_amt_stage3_national;
	}
	public void setR11_amt_stage3_national(BigDecimal r11_amt_stage3_national) {
		this.r11_amt_stage3_national = r11_amt_stage3_national;
	}
	public BigDecimal getR11_acc_fund_non_national() {
		return r11_acc_fund_non_national;
	}
	public void setR11_acc_fund_non_national(BigDecimal r11_acc_fund_non_national) {
		this.r11_acc_fund_non_national = r11_acc_fund_non_national;
	}
	public BigDecimal getR11_amt_fund_non_national() {
		return r11_amt_fund_non_national;
	}
	public void setR11_amt_fund_non_national(BigDecimal r11_amt_fund_non_national) {
		this.r11_amt_fund_non_national = r11_amt_fund_non_national;
	}
	public BigDecimal getR11_avg_fund_non_national() {
		return r11_avg_fund_non_national;
	}
	public void setR11_avg_fund_non_national(BigDecimal r11_avg_fund_non_national) {
		this.r11_avg_fund_non_national = r11_avg_fund_non_national;
	}
	public BigDecimal getR11_acc_unfund_non_national() {
		return r11_acc_unfund_non_national;
	}
	public void setR11_acc_unfund_non_national(BigDecimal r11_acc_unfund_non_national) {
		this.r11_acc_unfund_non_national = r11_acc_unfund_non_national;
	}
	public BigDecimal getR11_amt_unfund_non_national() {
		return r11_amt_unfund_non_national;
	}
	public void setR11_amt_unfund_non_national(BigDecimal r11_amt_unfund_non_national) {
		this.r11_amt_unfund_non_national = r11_amt_unfund_non_national;
	}
	public BigDecimal getR11_ccf_unfund_non_national() {
		return r11_ccf_unfund_non_national;
	}
	public void setR11_ccf_unfund_non_national(BigDecimal r11_ccf_unfund_non_national) {
		this.r11_ccf_unfund_non_national = r11_ccf_unfund_non_national;
	}
	public BigDecimal getR11_stage3_acc_non_national() {
		return r11_stage3_acc_non_national;
	}
	public void setR11_stage3_acc_non_national(BigDecimal r11_stage3_acc_non_national) {
		this.r11_stage3_acc_non_national = r11_stage3_acc_non_national;
	}
	public BigDecimal getR11_amt_stage3_non_national() {
		return r11_amt_stage3_non_national;
	}
	public void setR11_amt_stage3_non_national(BigDecimal r11_amt_stage3_non_national) {
		this.r11_amt_stage3_non_national = r11_amt_stage3_non_national;
	}
	public BigDecimal getR11_acc_total() {
		return r11_acc_total;
	}
	public void setR11_acc_total(BigDecimal r11_acc_total) {
		this.r11_acc_total = r11_acc_total;
	}
	public BigDecimal getR11_fund_amt_total() {
		return r11_fund_amt_total;
	}
	public void setR11_fund_amt_total(BigDecimal r11_fund_amt_total) {
		this.r11_fund_amt_total = r11_fund_amt_total;
	}
	public BigDecimal getR11_avg_total() {
		return r11_avg_total;
	}
	public void setR11_avg_total(BigDecimal r11_avg_total) {
		this.r11_avg_total = r11_avg_total;
	}
	public BigDecimal getR11_fund_ccf_total() {
		return r11_fund_ccf_total;
	}
	public void setR11_fund_ccf_total(BigDecimal r11_fund_ccf_total) {
		this.r11_fund_ccf_total = r11_fund_ccf_total;
	}
	public BigDecimal getR11_stage3_acc_total() {
		return r11_stage3_acc_total;
	}
	public void setR11_stage3_acc_total(BigDecimal r11_stage3_acc_total) {
		this.r11_stage3_acc_total = r11_stage3_acc_total;
	}
	public BigDecimal getR11_amt_stage3_total() {
		return r11_amt_stage3_total;
	}
	public void setR11_amt_stage3_total(BigDecimal r11_amt_stage3_total) {
		this.r11_amt_stage3_total = r11_amt_stage3_total;
	}
	public BigDecimal getR11_stage3_acc_quater() {
		return r11_stage3_acc_quater;
	}
	public void setR11_stage3_acc_quater(BigDecimal r11_stage3_acc_quater) {
		this.r11_stage3_acc_quater = r11_stage3_acc_quater;
	}
	public BigDecimal getR11_amt_stage3_acc_quater() {
		return r11_amt_stage3_acc_quater;
	}
	public void setR11_amt_stage3_acc_quater(BigDecimal r11_amt_stage3_acc_quater) {
		this.r11_amt_stage3_acc_quater = r11_amt_stage3_acc_quater;
	}
	public String getR12_product() {
		return r12_product;
	}
	public void setR12_product(String r12_product) {
		this.r12_product = r12_product;
	}
	public BigDecimal getR12_acc_fund_national() {
		return r12_acc_fund_national;
	}
	public void setR12_acc_fund_national(BigDecimal r12_acc_fund_national) {
		this.r12_acc_fund_national = r12_acc_fund_national;
	}
	public BigDecimal getR12_amt_fund_national() {
		return r12_amt_fund_national;
	}
	public void setR12_amt_fund_national(BigDecimal r12_amt_fund_national) {
		this.r12_amt_fund_national = r12_amt_fund_national;
	}
	public BigDecimal getR12_avg_fund_national() {
		return r12_avg_fund_national;
	}
	public void setR12_avg_fund_national(BigDecimal r12_avg_fund_national) {
		this.r12_avg_fund_national = r12_avg_fund_national;
	}
	public BigDecimal getR12_acc_unfund_national() {
		return r12_acc_unfund_national;
	}
	public void setR12_acc_unfund_national(BigDecimal r12_acc_unfund_national) {
		this.r12_acc_unfund_national = r12_acc_unfund_national;
	}
	public BigDecimal getR12_amt_unfund_national() {
		return r12_amt_unfund_national;
	}
	public void setR12_amt_unfund_national(BigDecimal r12_amt_unfund_national) {
		this.r12_amt_unfund_national = r12_amt_unfund_national;
	}
	public BigDecimal getR12_ccf_unfund_national() {
		return r12_ccf_unfund_national;
	}
	public void setR12_ccf_unfund_national(BigDecimal r12_ccf_unfund_national) {
		this.r12_ccf_unfund_national = r12_ccf_unfund_national;
	}
	public BigDecimal getR12_stage3_acc_national() {
		return r12_stage3_acc_national;
	}
	public void setR12_stage3_acc_national(BigDecimal r12_stage3_acc_national) {
		this.r12_stage3_acc_national = r12_stage3_acc_national;
	}
	public BigDecimal getR12_amt_stage3_national() {
		return r12_amt_stage3_national;
	}
	public void setR12_amt_stage3_national(BigDecimal r12_amt_stage3_national) {
		this.r12_amt_stage3_national = r12_amt_stage3_national;
	}
	public BigDecimal getR12_acc_fund_non_national() {
		return r12_acc_fund_non_national;
	}
	public void setR12_acc_fund_non_national(BigDecimal r12_acc_fund_non_national) {
		this.r12_acc_fund_non_national = r12_acc_fund_non_national;
	}
	public BigDecimal getR12_amt_fund_non_national() {
		return r12_amt_fund_non_national;
	}
	public void setR12_amt_fund_non_national(BigDecimal r12_amt_fund_non_national) {
		this.r12_amt_fund_non_national = r12_amt_fund_non_national;
	}
	public BigDecimal getR12_avg_fund_non_national() {
		return r12_avg_fund_non_national;
	}
	public void setR12_avg_fund_non_national(BigDecimal r12_avg_fund_non_national) {
		this.r12_avg_fund_non_national = r12_avg_fund_non_national;
	}
	public BigDecimal getR12_acc_unfund_non_national() {
		return r12_acc_unfund_non_national;
	}
	public void setR12_acc_unfund_non_national(BigDecimal r12_acc_unfund_non_national) {
		this.r12_acc_unfund_non_national = r12_acc_unfund_non_national;
	}
	public BigDecimal getR12_amt_unfund_non_national() {
		return r12_amt_unfund_non_national;
	}
	public void setR12_amt_unfund_non_national(BigDecimal r12_amt_unfund_non_national) {
		this.r12_amt_unfund_non_national = r12_amt_unfund_non_national;
	}
	public BigDecimal getR12_ccf_unfund_non_national() {
		return r12_ccf_unfund_non_national;
	}
	public void setR12_ccf_unfund_non_national(BigDecimal r12_ccf_unfund_non_national) {
		this.r12_ccf_unfund_non_national = r12_ccf_unfund_non_national;
	}
	public BigDecimal getR12_stage3_acc_non_national() {
		return r12_stage3_acc_non_national;
	}
	public void setR12_stage3_acc_non_national(BigDecimal r12_stage3_acc_non_national) {
		this.r12_stage3_acc_non_national = r12_stage3_acc_non_national;
	}
	public BigDecimal getR12_amt_stage3_non_national() {
		return r12_amt_stage3_non_national;
	}
	public void setR12_amt_stage3_non_national(BigDecimal r12_amt_stage3_non_national) {
		this.r12_amt_stage3_non_national = r12_amt_stage3_non_national;
	}
	public BigDecimal getR12_acc_total() {
		return r12_acc_total;
	}
	public void setR12_acc_total(BigDecimal r12_acc_total) {
		this.r12_acc_total = r12_acc_total;
	}
	public BigDecimal getR12_fund_amt_total() {
		return r12_fund_amt_total;
	}
	public void setR12_fund_amt_total(BigDecimal r12_fund_amt_total) {
		this.r12_fund_amt_total = r12_fund_amt_total;
	}
	public BigDecimal getR12_avg_total() {
		return r12_avg_total;
	}
	public void setR12_avg_total(BigDecimal r12_avg_total) {
		this.r12_avg_total = r12_avg_total;
	}
	public BigDecimal getR12_fund_ccf_total() {
		return r12_fund_ccf_total;
	}
	public void setR12_fund_ccf_total(BigDecimal r12_fund_ccf_total) {
		this.r12_fund_ccf_total = r12_fund_ccf_total;
	}
	public BigDecimal getR12_stage3_acc_total() {
		return r12_stage3_acc_total;
	}
	public void setR12_stage3_acc_total(BigDecimal r12_stage3_acc_total) {
		this.r12_stage3_acc_total = r12_stage3_acc_total;
	}
	public BigDecimal getR12_amt_stage3_total() {
		return r12_amt_stage3_total;
	}
	public void setR12_amt_stage3_total(BigDecimal r12_amt_stage3_total) {
		this.r12_amt_stage3_total = r12_amt_stage3_total;
	}
	public BigDecimal getR12_stage3_acc_quater() {
		return r12_stage3_acc_quater;
	}
	public void setR12_stage3_acc_quater(BigDecimal r12_stage3_acc_quater) {
		this.r12_stage3_acc_quater = r12_stage3_acc_quater;
	}
	public BigDecimal getR12_amt_stage3_acc_quater() {
		return r12_amt_stage3_acc_quater;
	}
	public void setR12_amt_stage3_acc_quater(BigDecimal r12_amt_stage3_acc_quater) {
		this.r12_amt_stage3_acc_quater = r12_amt_stage3_acc_quater;
	}
	public String getR13_product() {
		return r13_product;
	}
	public void setR13_product(String r13_product) {
		this.r13_product = r13_product;
	}
	public BigDecimal getR13_acc_fund_national() {
		return r13_acc_fund_national;
	}
	public void setR13_acc_fund_national(BigDecimal r13_acc_fund_national) {
		this.r13_acc_fund_national = r13_acc_fund_national;
	}
	public BigDecimal getR13_amt_fund_national() {
		return r13_amt_fund_national;
	}
	public void setR13_amt_fund_national(BigDecimal r13_amt_fund_national) {
		this.r13_amt_fund_national = r13_amt_fund_national;
	}
	public BigDecimal getR13_avg_fund_national() {
		return r13_avg_fund_national;
	}
	public void setR13_avg_fund_national(BigDecimal r13_avg_fund_national) {
		this.r13_avg_fund_national = r13_avg_fund_national;
	}
	public BigDecimal getR13_acc_unfund_national() {
		return r13_acc_unfund_national;
	}
	public void setR13_acc_unfund_national(BigDecimal r13_acc_unfund_national) {
		this.r13_acc_unfund_national = r13_acc_unfund_national;
	}
	public BigDecimal getR13_amt_unfund_national() {
		return r13_amt_unfund_national;
	}
	public void setR13_amt_unfund_national(BigDecimal r13_amt_unfund_national) {
		this.r13_amt_unfund_national = r13_amt_unfund_national;
	}
	public BigDecimal getR13_ccf_unfund_national() {
		return r13_ccf_unfund_national;
	}
	public void setR13_ccf_unfund_national(BigDecimal r13_ccf_unfund_national) {
		this.r13_ccf_unfund_national = r13_ccf_unfund_national;
	}
	public BigDecimal getR13_stage3_acc_national() {
		return r13_stage3_acc_national;
	}
	public void setR13_stage3_acc_national(BigDecimal r13_stage3_acc_national) {
		this.r13_stage3_acc_national = r13_stage3_acc_national;
	}
	public BigDecimal getR13_amt_stage3_national() {
		return r13_amt_stage3_national;
	}
	public void setR13_amt_stage3_national(BigDecimal r13_amt_stage3_national) {
		this.r13_amt_stage3_national = r13_amt_stage3_national;
	}
	public BigDecimal getR13_acc_fund_non_national() {
		return r13_acc_fund_non_national;
	}
	public void setR13_acc_fund_non_national(BigDecimal r13_acc_fund_non_national) {
		this.r13_acc_fund_non_national = r13_acc_fund_non_national;
	}
	public BigDecimal getR13_amt_fund_non_national() {
		return r13_amt_fund_non_national;
	}
	public void setR13_amt_fund_non_national(BigDecimal r13_amt_fund_non_national) {
		this.r13_amt_fund_non_national = r13_amt_fund_non_national;
	}
	public BigDecimal getR13_avg_fund_non_national() {
		return r13_avg_fund_non_national;
	}
	public void setR13_avg_fund_non_national(BigDecimal r13_avg_fund_non_national) {
		this.r13_avg_fund_non_national = r13_avg_fund_non_national;
	}
	public BigDecimal getR13_acc_unfund_non_national() {
		return r13_acc_unfund_non_national;
	}
	public void setR13_acc_unfund_non_national(BigDecimal r13_acc_unfund_non_national) {
		this.r13_acc_unfund_non_national = r13_acc_unfund_non_national;
	}
	public BigDecimal getR13_amt_unfund_non_national() {
		return r13_amt_unfund_non_national;
	}
	public void setR13_amt_unfund_non_national(BigDecimal r13_amt_unfund_non_national) {
		this.r13_amt_unfund_non_national = r13_amt_unfund_non_national;
	}
	public BigDecimal getR13_ccf_unfund_non_national() {
		return r13_ccf_unfund_non_national;
	}
	public void setR13_ccf_unfund_non_national(BigDecimal r13_ccf_unfund_non_national) {
		this.r13_ccf_unfund_non_national = r13_ccf_unfund_non_national;
	}
	public BigDecimal getR13_stage3_acc_non_national() {
		return r13_stage3_acc_non_national;
	}
	public void setR13_stage3_acc_non_national(BigDecimal r13_stage3_acc_non_national) {
		this.r13_stage3_acc_non_national = r13_stage3_acc_non_national;
	}
	public BigDecimal getR13_amt_stage3_non_national() {
		return r13_amt_stage3_non_national;
	}
	public void setR13_amt_stage3_non_national(BigDecimal r13_amt_stage3_non_national) {
		this.r13_amt_stage3_non_national = r13_amt_stage3_non_national;
	}
	public BigDecimal getR13_acc_total() {
		return r13_acc_total;
	}
	public void setR13_acc_total(BigDecimal r13_acc_total) {
		this.r13_acc_total = r13_acc_total;
	}
	public BigDecimal getR13_fund_amt_total() {
		return r13_fund_amt_total;
	}
	public void setR13_fund_amt_total(BigDecimal r13_fund_amt_total) {
		this.r13_fund_amt_total = r13_fund_amt_total;
	}
	public BigDecimal getR13_avg_total() {
		return r13_avg_total;
	}
	public void setR13_avg_total(BigDecimal r13_avg_total) {
		this.r13_avg_total = r13_avg_total;
	}
	public BigDecimal getR13_fund_ccf_total() {
		return r13_fund_ccf_total;
	}
	public void setR13_fund_ccf_total(BigDecimal r13_fund_ccf_total) {
		this.r13_fund_ccf_total = r13_fund_ccf_total;
	}
	public BigDecimal getR13_stage3_acc_total() {
		return r13_stage3_acc_total;
	}
	public void setR13_stage3_acc_total(BigDecimal r13_stage3_acc_total) {
		this.r13_stage3_acc_total = r13_stage3_acc_total;
	}
	public BigDecimal getR13_amt_stage3_total() {
		return r13_amt_stage3_total;
	}
	public void setR13_amt_stage3_total(BigDecimal r13_amt_stage3_total) {
		this.r13_amt_stage3_total = r13_amt_stage3_total;
	}
	public BigDecimal getR13_stage3_acc_quater() {
		return r13_stage3_acc_quater;
	}
	public void setR13_stage3_acc_quater(BigDecimal r13_stage3_acc_quater) {
		this.r13_stage3_acc_quater = r13_stage3_acc_quater;
	}
	public BigDecimal getR13_amt_stage3_acc_quater() {
		return r13_amt_stage3_acc_quater;
	}
	public void setR13_amt_stage3_acc_quater(BigDecimal r13_amt_stage3_acc_quater) {
		this.r13_amt_stage3_acc_quater = r13_amt_stage3_acc_quater;
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
	public Date getReport_submit_date() {
		return report_submit_date;
	}
	public void setReport_submit_date(Date report_submit_date) {
		this.report_submit_date = report_submit_date;
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
	public String getReport_code() {
		return report_code;
	}
	public void setReport_code(String report_code) {
		this.report_code = report_code;
	}
	public BRF74_ENTITY() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}