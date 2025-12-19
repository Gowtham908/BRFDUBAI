package com.bornfire.xbrl.entities.BRBS;

import java.math.BigDecimal;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="OR1")
public class BASEL_OPRISK_OR1 {

	private String	r1_product;
	private BigDecimal	r1_1_net_int_inc_y3_grs_inc;
	private BigDecimal	r1_2_net_non_int_inc_y3_grs_inc;
	private BigDecimal	r1_3_grs_inc_y3_grs_inc;
	private BigDecimal	r1_4_net_int_inc_y2_grs_inc;
	private BigDecimal	r1_5_net_non_int_inc_y2_grs_inc;
	private BigDecimal	r1_6_grs_inc_y2_grs_inc;
	private BigDecimal	r1_7_net_int_inc_last_grs_inc;
	private BigDecimal	r1_8_net_non_int_inc_last_grs_inc;
	private BigDecimal	r1_9_grs_inc_last_grs_inc;
	private String	r1_1o_y3_loan_advs;
	private String	r1_11_y2_loan_advs;
	private String	r1_12_last_loan_advs;
	private String	r1_13_m_fac_loan_advs;
	private BigDecimal	r1_14_3y_avg;
	private BigDecimal	r1_15_beta_fac;
	private BigDecimal	r1_16_cap_chrg_basel;
	private BigDecimal	r1_16_cap_chrg_uae;
	private String	r2_product;
	private String	r3_product;
	private BigDecimal	r3_1_net_int_inc_y3_grs_inc;
	private BigDecimal	r3_2_net_non_int_inc_y3_grs_inc;
	private BigDecimal	r3_3_grs_inc_y3_grs_inc;
	private BigDecimal	r3_4_net_int_inc_y2_grs_inc;
	private BigDecimal	r3_5_net_non_int_inc_y2_grs_inc;
	private BigDecimal	r3_6_grs_inc_y2_grs_inc;
	private BigDecimal	r3_7_net_int_inc_last_grs_inc;
	private BigDecimal	r3_8_net_non_int_inc_last_grs_inc;
	private BigDecimal	r3_9_grs_inc_last_grs_inc;
	private String	r3_1o_y3_loan_advs;
	private String	r3_11_y2_loan_advs;
	private String	r3_12_last_loan_advs;
	private String	r3_13_m_fac_loan_advs;
	private BigDecimal	r3_14_3y_avg;
	private BigDecimal	r3_15_beta_fac;
	private BigDecimal	r3_16_cap_chrg_basel;
	private BigDecimal	r3_16_cap_chrg_uae;
	private String	r4_product;
	private BigDecimal	r4_1_net_int_inc_y3_grs_inc;
	private BigDecimal	r4_2_net_non_int_inc_y3_grs_inc;
	private BigDecimal	r4_3_grs_inc_y3_grs_inc;
	private BigDecimal	r4_4_net_int_inc_y2_grs_inc;
	private BigDecimal	r4_5_net_non_int_inc_y2_grs_inc;
	private BigDecimal	r4_6_grs_inc_y2_grs_inc;
	private BigDecimal	r4_7_net_int_inc_last_grs_inc;
	private BigDecimal	r4_8_net_non_int_inc_last_grs_inc;
	private BigDecimal	r4_9_grs_inc_last_grs_inc;
	private String	r4_1o_y3_loan_advs;
	private String	r4_11_y2_loan_advs;
	private String	r4_12_last_loan_advs;
	private String	r4_13_m_fac_loan_advs;
	private BigDecimal	r4_14_3y_avg;
	private BigDecimal	r4_15_beta_fac;
	private BigDecimal	r4_16_cap_chrg_basel;
	private BigDecimal	r4_16_cap_chrg_uae;
	private String	r5_product;
	private BigDecimal	r5_1_net_int_inc_y3_grs_inc;
	private BigDecimal	r5_2_net_non_int_inc_y3_grs_inc;
	private BigDecimal	r5_3_grs_inc_y3_grs_inc;
	private BigDecimal	r5_4_net_int_inc_y2_grs_inc;
	private BigDecimal	r5_5_net_non_int_inc_y2_grs_inc;
	private BigDecimal	r5_6_grs_inc_y2_grs_inc;
	private BigDecimal	r5_7_net_int_inc_last_grs_inc;
	private BigDecimal	r5_8_net_non_int_inc_last_grs_inc;
	private BigDecimal	r5_9_grs_inc_last_grs_inc;
	private String	r5_1o_y3_loan_advs;
	private String	r5_11_y2_loan_advs;
	private String	r5_12_last_loan_advs;
	private String	r5_13_m_fac_loan_advs;
	private BigDecimal	r5_14_3y_avg;
	private BigDecimal	r5_15_beta_fac;
	private BigDecimal	r5_16_cap_chrg_basel;
	private BigDecimal	r5_16_cap_chrg_uae;
	private String	r6_product;
	private BigDecimal	r6_1_net_int_inc_y3_grs_inc;
	private BigDecimal	r6_2_net_non_int_inc_y3_grs_inc;
	private BigDecimal	r6_3_grs_inc_y3_grs_inc;
	private BigDecimal	r6_4_net_int_inc_y2_grs_inc;
	private BigDecimal	r6_5_net_non_int_inc_y2_grs_inc;
	private BigDecimal	r6_6_grs_inc_y2_grs_inc;
	private BigDecimal	r6_7_net_int_inc_last_grs_inc;
	private BigDecimal	r6_8_net_non_int_inc_last_grs_inc;
	private BigDecimal	r6_9_grs_inc_last_grs_inc;
	private String	r6_1o_y3_loan_advs;
	private String	r6_11_y2_loan_advs;
	private String	r6_12_last_loan_advs;
	private String	r6_13_m_fac_loan_advs;
	private BigDecimal	r6_14_3y_avg;
	private BigDecimal	r6_15_beta_fac;
	private BigDecimal	r6_16_cap_chrg_basel;
	private BigDecimal	r6_16_cap_chrg_uae;
	private String	r7_product;
	private BigDecimal	r7_1_net_int_inc_y3_grs_inc;
	private BigDecimal	r7_2_net_non_int_inc_y3_grs_inc;
	private BigDecimal	r7_3_grs_inc_y3_grs_inc;
	private BigDecimal	r7_4_net_int_inc_y2_grs_inc;
	private BigDecimal	r7_5_net_non_int_inc_y2_grs_inc;
	private BigDecimal	r7_6_grs_inc_y2_grs_inc;
	private BigDecimal	r7_7_net_int_inc_last_grs_inc;
	private BigDecimal	r7_8_net_non_int_inc_last_grs_inc;
	private BigDecimal	r7_9_grs_inc_last_grs_inc;
	private String	r7_1o_y3_loan_advs;
	private String	r7_11_y2_loan_advs;
	private String	r7_12_last_loan_advs;
	private String	r7_13_m_fac_loan_advs;
	private BigDecimal	r7_14_3y_avg;
	private BigDecimal	r7_15_beta_fac;
	private BigDecimal	r7_16_cap_chrg_basel;
	private BigDecimal	r7_16_cap_chrg_uae;
	private String	r8_product;
	private BigDecimal	r8_1_net_int_inc_y3_grs_inc;
	private BigDecimal	r8_2_net_non_int_inc_y3_grs_inc;
	private BigDecimal	r8_3_grs_inc_y3_grs_inc;
	private BigDecimal	r8_4_net_int_inc_y2_grs_inc;
	private BigDecimal	r8_5_net_non_int_inc_y2_grs_inc;
	private BigDecimal	r8_6_grs_inc_y2_grs_inc;
	private BigDecimal	r8_7_net_int_inc_last_grs_inc;
	private BigDecimal	r8_8_net_non_int_inc_last_grs_inc;
	private BigDecimal	r8_9_grs_inc_last_grs_inc;
	private String	r8_1o_y3_loan_advs;
	private String	r8_11_y2_loan_advs;
	private String	r8_12_last_loan_advs;
	private String	r8_13_m_fac_loan_advs;
	private BigDecimal	r8_14_3y_avg;
	private BigDecimal	r8_15_beta_fac;
	private BigDecimal	r8_16_cap_chrg_basel;
	private BigDecimal	r8_16_cap_chrg_uae;
	private String	r9_product;
	private BigDecimal	r9_1_net_int_inc_y3_grs_inc;
	private BigDecimal	r9_2_net_non_int_inc_y3_grs_inc;
	private BigDecimal	r9_3_grs_inc_y3_grs_inc;
	private BigDecimal	r9_4_net_int_inc_y2_grs_inc;
	private BigDecimal	r9_5_net_non_int_inc_y2_grs_inc;
	private BigDecimal	r9_6_grs_inc_y2_grs_inc;
	private BigDecimal	r9_7_net_int_inc_last_grs_inc;
	private BigDecimal	r9_8_net_non_int_inc_last_grs_inc;
	private BigDecimal	r9_9_grs_inc_last_grs_inc;
	private String	r9_1o_y3_loan_advs;
	private String	r9_11_y2_loan_advs;
	private String	r9_12_last_loan_advs;
	private String	r9_13_m_fac_loan_advs;
	private BigDecimal	r9_14_3y_avg;
	private BigDecimal	r9_15_beta_fac;
	private BigDecimal	r9_16_cap_chrg_basel;
	private BigDecimal	r9_16_cap_chrg_uae;
	private String	r10_product;
	private BigDecimal	r10_1_net_int_inc_y3_grs_inc;
	private BigDecimal	r10_2_net_non_int_inc_y3_grs_inc;
	private BigDecimal	r10_3_grs_inc_y3_grs_inc;
	private BigDecimal	r10_4_net_int_inc_y2_grs_inc;
	private BigDecimal	r10_5_net_non_int_inc_y2_grs_inc;
	private BigDecimal	r10_6_grs_inc_y2_grs_inc;
	private BigDecimal	r10_7_net_int_inc_last_grs_inc;
	private BigDecimal	r10_8_net_non_int_inc_last_grs_inc;
	private BigDecimal	r10_9_grs_inc_last_grs_inc;
	private String	r10_1o_y3_loan_advs;
	private String	r10_11_y2_loan_advs;
	private String	r10_12_last_loan_advs;
	private String	r10_13_m_fac_loan_advs;
	private BigDecimal	r10_14_3y_avg;
	private BigDecimal	r10_15_beta_fac;
	private BigDecimal	r10_16_cap_chrg_basel;
	private BigDecimal	r10_16_cap_chrg_uae;
	private String	r11_product;
	private BigDecimal	r11_1_net_int_inc_y3_grs_inc;
	private BigDecimal	r11_2_net_non_int_inc_y3_grs_inc;
	private BigDecimal	r11_3_grs_inc_y3_grs_inc;
	private BigDecimal	r11_4_net_int_inc_y2_grs_inc;
	private BigDecimal	r11_5_net_non_int_inc_y2_grs_inc;
	private BigDecimal	r11_6_grs_inc_y2_grs_inc;
	private BigDecimal	r11_7_net_int_inc_last_grs_inc;
	private BigDecimal	r11_8_net_non_int_inc_last_grs_inc;
	private BigDecimal	r11_9_grs_inc_last_grs_inc;
	private String	r11_1o_y3_loan_advs;
	private String	r11_11_y2_loan_advs;
	private String	r11_12_last_loan_advs;
	private String	r11_13_m_fac_loan_advs;
	private BigDecimal	r11_14_3y_avg;
	private BigDecimal	r11_15_beta_fac;
	private BigDecimal	r11_16_cap_chrg_basel;
	private BigDecimal	r11_16_cap_chrg_uae;
	
	@Id
	private Date	report_date;
	private Date	report_from_date;
	private Date	report_to_date;
	private String	entity_flg;
	private String	modify_flg;
	private String	del_flg;
	private String	report_code;
	public String getR1_product() {
		return r1_product;
	}
	public void setR1_product(String r1_product) {
		this.r1_product = r1_product;
	}
	public BigDecimal getR1_1_net_int_inc_y3_grs_inc() {
		return r1_1_net_int_inc_y3_grs_inc;
	}
	public void setR1_1_net_int_inc_y3_grs_inc(BigDecimal r1_1_net_int_inc_y3_grs_inc) {
		this.r1_1_net_int_inc_y3_grs_inc = r1_1_net_int_inc_y3_grs_inc;
	}
	public BigDecimal getR1_2_net_non_int_inc_y3_grs_inc() {
		return r1_2_net_non_int_inc_y3_grs_inc;
	}
	public void setR1_2_net_non_int_inc_y3_grs_inc(BigDecimal r1_2_net_non_int_inc_y3_grs_inc) {
		this.r1_2_net_non_int_inc_y3_grs_inc = r1_2_net_non_int_inc_y3_grs_inc;
	}
	public BigDecimal getR1_3_grs_inc_y3_grs_inc() {
		return r1_3_grs_inc_y3_grs_inc;
	}
	public void setR1_3_grs_inc_y3_grs_inc(BigDecimal r1_3_grs_inc_y3_grs_inc) {
		this.r1_3_grs_inc_y3_grs_inc = r1_3_grs_inc_y3_grs_inc;
	}
	public BigDecimal getR1_4_net_int_inc_y2_grs_inc() {
		return r1_4_net_int_inc_y2_grs_inc;
	}
	public void setR1_4_net_int_inc_y2_grs_inc(BigDecimal r1_4_net_int_inc_y2_grs_inc) {
		this.r1_4_net_int_inc_y2_grs_inc = r1_4_net_int_inc_y2_grs_inc;
	}
	public BigDecimal getR1_5_net_non_int_inc_y2_grs_inc() {
		return r1_5_net_non_int_inc_y2_grs_inc;
	}
	public void setR1_5_net_non_int_inc_y2_grs_inc(BigDecimal r1_5_net_non_int_inc_y2_grs_inc) {
		this.r1_5_net_non_int_inc_y2_grs_inc = r1_5_net_non_int_inc_y2_grs_inc;
	}
	public BigDecimal getR1_6_grs_inc_y2_grs_inc() {
		return r1_6_grs_inc_y2_grs_inc;
	}
	public void setR1_6_grs_inc_y2_grs_inc(BigDecimal r1_6_grs_inc_y2_grs_inc) {
		this.r1_6_grs_inc_y2_grs_inc = r1_6_grs_inc_y2_grs_inc;
	}
	public BigDecimal getR1_7_net_int_inc_last_grs_inc() {
		return r1_7_net_int_inc_last_grs_inc;
	}
	public void setR1_7_net_int_inc_last_grs_inc(BigDecimal r1_7_net_int_inc_last_grs_inc) {
		this.r1_7_net_int_inc_last_grs_inc = r1_7_net_int_inc_last_grs_inc;
	}
	public BigDecimal getR1_8_net_non_int_inc_last_grs_inc() {
		return r1_8_net_non_int_inc_last_grs_inc;
	}
	public void setR1_8_net_non_int_inc_last_grs_inc(BigDecimal r1_8_net_non_int_inc_last_grs_inc) {
		this.r1_8_net_non_int_inc_last_grs_inc = r1_8_net_non_int_inc_last_grs_inc;
	}
	public BigDecimal getR1_9_grs_inc_last_grs_inc() {
		return r1_9_grs_inc_last_grs_inc;
	}
	public void setR1_9_grs_inc_last_grs_inc(BigDecimal r1_9_grs_inc_last_grs_inc) {
		this.r1_9_grs_inc_last_grs_inc = r1_9_grs_inc_last_grs_inc;
	}
	public String getR1_1o_y3_loan_advs() {
		return r1_1o_y3_loan_advs;
	}
	public void setR1_1o_y3_loan_advs(String r1_1o_y3_loan_advs) {
		this.r1_1o_y3_loan_advs = r1_1o_y3_loan_advs;
	}
	public String getR1_11_y2_loan_advs() {
		return r1_11_y2_loan_advs;
	}
	public void setR1_11_y2_loan_advs(String r1_11_y2_loan_advs) {
		this.r1_11_y2_loan_advs = r1_11_y2_loan_advs;
	}
	public String getR1_12_last_loan_advs() {
		return r1_12_last_loan_advs;
	}
	public void setR1_12_last_loan_advs(String r1_12_last_loan_advs) {
		this.r1_12_last_loan_advs = r1_12_last_loan_advs;
	}
	public String getR1_13_m_fac_loan_advs() {
		return r1_13_m_fac_loan_advs;
	}
	public void setR1_13_m_fac_loan_advs(String r1_13_m_fac_loan_advs) {
		this.r1_13_m_fac_loan_advs = r1_13_m_fac_loan_advs;
	}
	public BigDecimal getR1_14_3y_avg() {
		return r1_14_3y_avg;
	}
	public void setR1_14_3y_avg(BigDecimal r1_14_3y_avg) {
		this.r1_14_3y_avg = r1_14_3y_avg;
	}
	public BigDecimal getR1_15_beta_fac() {
		return r1_15_beta_fac;
	}
	public void setR1_15_beta_fac(BigDecimal r1_15_beta_fac) {
		this.r1_15_beta_fac = r1_15_beta_fac;
	}
	public BigDecimal getR1_16_cap_chrg_basel() {
		return r1_16_cap_chrg_basel;
	}
	public void setR1_16_cap_chrg_basel(BigDecimal r1_16_cap_chrg_basel) {
		this.r1_16_cap_chrg_basel = r1_16_cap_chrg_basel;
	}
	public BigDecimal getR1_16_cap_chrg_uae() {
		return r1_16_cap_chrg_uae;
	}
	public void setR1_16_cap_chrg_uae(BigDecimal r1_16_cap_chrg_uae) {
		this.r1_16_cap_chrg_uae = r1_16_cap_chrg_uae;
	}
	public String getR2_product() {
		return r2_product;
	}
	public void setR2_product(String r2_product) {
		this.r2_product = r2_product;
	}
	public String getR3_product() {
		return r3_product;
	}
	public void setR3_product(String r3_product) {
		this.r3_product = r3_product;
	}
	public BigDecimal getR3_1_net_int_inc_y3_grs_inc() {
		return r3_1_net_int_inc_y3_grs_inc;
	}
	public void setR3_1_net_int_inc_y3_grs_inc(BigDecimal r3_1_net_int_inc_y3_grs_inc) {
		this.r3_1_net_int_inc_y3_grs_inc = r3_1_net_int_inc_y3_grs_inc;
	}
	public BigDecimal getR3_2_net_non_int_inc_y3_grs_inc() {
		return r3_2_net_non_int_inc_y3_grs_inc;
	}
	public void setR3_2_net_non_int_inc_y3_grs_inc(BigDecimal r3_2_net_non_int_inc_y3_grs_inc) {
		this.r3_2_net_non_int_inc_y3_grs_inc = r3_2_net_non_int_inc_y3_grs_inc;
	}
	public BigDecimal getR3_3_grs_inc_y3_grs_inc() {
		return r3_3_grs_inc_y3_grs_inc;
	}
	public void setR3_3_grs_inc_y3_grs_inc(BigDecimal r3_3_grs_inc_y3_grs_inc) {
		this.r3_3_grs_inc_y3_grs_inc = r3_3_grs_inc_y3_grs_inc;
	}
	public BigDecimal getR3_4_net_int_inc_y2_grs_inc() {
		return r3_4_net_int_inc_y2_grs_inc;
	}
	public void setR3_4_net_int_inc_y2_grs_inc(BigDecimal r3_4_net_int_inc_y2_grs_inc) {
		this.r3_4_net_int_inc_y2_grs_inc = r3_4_net_int_inc_y2_grs_inc;
	}
	public BigDecimal getR3_5_net_non_int_inc_y2_grs_inc() {
		return r3_5_net_non_int_inc_y2_grs_inc;
	}
	public void setR3_5_net_non_int_inc_y2_grs_inc(BigDecimal r3_5_net_non_int_inc_y2_grs_inc) {
		this.r3_5_net_non_int_inc_y2_grs_inc = r3_5_net_non_int_inc_y2_grs_inc;
	}
	public BigDecimal getR3_6_grs_inc_y2_grs_inc() {
		return r3_6_grs_inc_y2_grs_inc;
	}
	public void setR3_6_grs_inc_y2_grs_inc(BigDecimal r3_6_grs_inc_y2_grs_inc) {
		this.r3_6_grs_inc_y2_grs_inc = r3_6_grs_inc_y2_grs_inc;
	}
	public BigDecimal getR3_7_net_int_inc_last_grs_inc() {
		return r3_7_net_int_inc_last_grs_inc;
	}
	public void setR3_7_net_int_inc_last_grs_inc(BigDecimal r3_7_net_int_inc_last_grs_inc) {
		this.r3_7_net_int_inc_last_grs_inc = r3_7_net_int_inc_last_grs_inc;
	}
	public BigDecimal getR3_8_net_non_int_inc_last_grs_inc() {
		return r3_8_net_non_int_inc_last_grs_inc;
	}
	public void setR3_8_net_non_int_inc_last_grs_inc(BigDecimal r3_8_net_non_int_inc_last_grs_inc) {
		this.r3_8_net_non_int_inc_last_grs_inc = r3_8_net_non_int_inc_last_grs_inc;
	}
	public BigDecimal getR3_9_grs_inc_last_grs_inc() {
		return r3_9_grs_inc_last_grs_inc;
	}
	public void setR3_9_grs_inc_last_grs_inc(BigDecimal r3_9_grs_inc_last_grs_inc) {
		this.r3_9_grs_inc_last_grs_inc = r3_9_grs_inc_last_grs_inc;
	}
	public String getR3_1o_y3_loan_advs() {
		return r3_1o_y3_loan_advs;
	}
	public void setR3_1o_y3_loan_advs(String r3_1o_y3_loan_advs) {
		this.r3_1o_y3_loan_advs = r3_1o_y3_loan_advs;
	}
	public String getR3_11_y2_loan_advs() {
		return r3_11_y2_loan_advs;
	}
	public void setR3_11_y2_loan_advs(String r3_11_y2_loan_advs) {
		this.r3_11_y2_loan_advs = r3_11_y2_loan_advs;
	}
	public String getR3_12_last_loan_advs() {
		return r3_12_last_loan_advs;
	}
	public void setR3_12_last_loan_advs(String r3_12_last_loan_advs) {
		this.r3_12_last_loan_advs = r3_12_last_loan_advs;
	}
	public String getR3_13_m_fac_loan_advs() {
		return r3_13_m_fac_loan_advs;
	}
	public void setR3_13_m_fac_loan_advs(String r3_13_m_fac_loan_advs) {
		this.r3_13_m_fac_loan_advs = r3_13_m_fac_loan_advs;
	}
	public BigDecimal getR3_14_3y_avg() {
		return r3_14_3y_avg;
	}
	public void setR3_14_3y_avg(BigDecimal r3_14_3y_avg) {
		this.r3_14_3y_avg = r3_14_3y_avg;
	}
	public BigDecimal getR3_15_beta_fac() {
		return r3_15_beta_fac;
	}
	public void setR3_15_beta_fac(BigDecimal r3_15_beta_fac) {
		this.r3_15_beta_fac = r3_15_beta_fac;
	}
	public BigDecimal getR3_16_cap_chrg_basel() {
		return r3_16_cap_chrg_basel;
	}
	public void setR3_16_cap_chrg_basel(BigDecimal r3_16_cap_chrg_basel) {
		this.r3_16_cap_chrg_basel = r3_16_cap_chrg_basel;
	}
	public BigDecimal getR3_16_cap_chrg_uae() {
		return r3_16_cap_chrg_uae;
	}
	public void setR3_16_cap_chrg_uae(BigDecimal r3_16_cap_chrg_uae) {
		this.r3_16_cap_chrg_uae = r3_16_cap_chrg_uae;
	}
	public String getR4_product() {
		return r4_product;
	}
	public void setR4_product(String r4_product) {
		this.r4_product = r4_product;
	}
	public BigDecimal getR4_1_net_int_inc_y3_grs_inc() {
		return r4_1_net_int_inc_y3_grs_inc;
	}
	public void setR4_1_net_int_inc_y3_grs_inc(BigDecimal r4_1_net_int_inc_y3_grs_inc) {
		this.r4_1_net_int_inc_y3_grs_inc = r4_1_net_int_inc_y3_grs_inc;
	}
	public BigDecimal getR4_2_net_non_int_inc_y3_grs_inc() {
		return r4_2_net_non_int_inc_y3_grs_inc;
	}
	public void setR4_2_net_non_int_inc_y3_grs_inc(BigDecimal r4_2_net_non_int_inc_y3_grs_inc) {
		this.r4_2_net_non_int_inc_y3_grs_inc = r4_2_net_non_int_inc_y3_grs_inc;
	}
	public BigDecimal getR4_3_grs_inc_y3_grs_inc() {
		return r4_3_grs_inc_y3_grs_inc;
	}
	public void setR4_3_grs_inc_y3_grs_inc(BigDecimal r4_3_grs_inc_y3_grs_inc) {
		this.r4_3_grs_inc_y3_grs_inc = r4_3_grs_inc_y3_grs_inc;
	}
	public BigDecimal getR4_4_net_int_inc_y2_grs_inc() {
		return r4_4_net_int_inc_y2_grs_inc;
	}
	public void setR4_4_net_int_inc_y2_grs_inc(BigDecimal r4_4_net_int_inc_y2_grs_inc) {
		this.r4_4_net_int_inc_y2_grs_inc = r4_4_net_int_inc_y2_grs_inc;
	}
	public BigDecimal getR4_5_net_non_int_inc_y2_grs_inc() {
		return r4_5_net_non_int_inc_y2_grs_inc;
	}
	public void setR4_5_net_non_int_inc_y2_grs_inc(BigDecimal r4_5_net_non_int_inc_y2_grs_inc) {
		this.r4_5_net_non_int_inc_y2_grs_inc = r4_5_net_non_int_inc_y2_grs_inc;
	}
	public BigDecimal getR4_6_grs_inc_y2_grs_inc() {
		return r4_6_grs_inc_y2_grs_inc;
	}
	public void setR4_6_grs_inc_y2_grs_inc(BigDecimal r4_6_grs_inc_y2_grs_inc) {
		this.r4_6_grs_inc_y2_grs_inc = r4_6_grs_inc_y2_grs_inc;
	}
	public BigDecimal getR4_7_net_int_inc_last_grs_inc() {
		return r4_7_net_int_inc_last_grs_inc;
	}
	public void setR4_7_net_int_inc_last_grs_inc(BigDecimal r4_7_net_int_inc_last_grs_inc) {
		this.r4_7_net_int_inc_last_grs_inc = r4_7_net_int_inc_last_grs_inc;
	}
	public BigDecimal getR4_8_net_non_int_inc_last_grs_inc() {
		return r4_8_net_non_int_inc_last_grs_inc;
	}
	public void setR4_8_net_non_int_inc_last_grs_inc(BigDecimal r4_8_net_non_int_inc_last_grs_inc) {
		this.r4_8_net_non_int_inc_last_grs_inc = r4_8_net_non_int_inc_last_grs_inc;
	}
	public BigDecimal getR4_9_grs_inc_last_grs_inc() {
		return r4_9_grs_inc_last_grs_inc;
	}
	public void setR4_9_grs_inc_last_grs_inc(BigDecimal r4_9_grs_inc_last_grs_inc) {
		this.r4_9_grs_inc_last_grs_inc = r4_9_grs_inc_last_grs_inc;
	}
	public String getR4_1o_y3_loan_advs() {
		return r4_1o_y3_loan_advs;
	}
	public void setR4_1o_y3_loan_advs(String r4_1o_y3_loan_advs) {
		this.r4_1o_y3_loan_advs = r4_1o_y3_loan_advs;
	}
	public String getR4_11_y2_loan_advs() {
		return r4_11_y2_loan_advs;
	}
	public void setR4_11_y2_loan_advs(String r4_11_y2_loan_advs) {
		this.r4_11_y2_loan_advs = r4_11_y2_loan_advs;
	}
	public String getR4_12_last_loan_advs() {
		return r4_12_last_loan_advs;
	}
	public void setR4_12_last_loan_advs(String r4_12_last_loan_advs) {
		this.r4_12_last_loan_advs = r4_12_last_loan_advs;
	}
	public String getR4_13_m_fac_loan_advs() {
		return r4_13_m_fac_loan_advs;
	}
	public void setR4_13_m_fac_loan_advs(String r4_13_m_fac_loan_advs) {
		this.r4_13_m_fac_loan_advs = r4_13_m_fac_loan_advs;
	}
	public BigDecimal getR4_14_3y_avg() {
		return r4_14_3y_avg;
	}
	public void setR4_14_3y_avg(BigDecimal r4_14_3y_avg) {
		this.r4_14_3y_avg = r4_14_3y_avg;
	}
	public BigDecimal getR4_15_beta_fac() {
		return r4_15_beta_fac;
	}
	public void setR4_15_beta_fac(BigDecimal r4_15_beta_fac) {
		this.r4_15_beta_fac = r4_15_beta_fac;
	}
	public BigDecimal getR4_16_cap_chrg_basel() {
		return r4_16_cap_chrg_basel;
	}
	public void setR4_16_cap_chrg_basel(BigDecimal r4_16_cap_chrg_basel) {
		this.r4_16_cap_chrg_basel = r4_16_cap_chrg_basel;
	}
	public BigDecimal getR4_16_cap_chrg_uae() {
		return r4_16_cap_chrg_uae;
	}
	public void setR4_16_cap_chrg_uae(BigDecimal r4_16_cap_chrg_uae) {
		this.r4_16_cap_chrg_uae = r4_16_cap_chrg_uae;
	}
	public String getR5_product() {
		return r5_product;
	}
	public void setR5_product(String r5_product) {
		this.r5_product = r5_product;
	}
	public BigDecimal getR5_1_net_int_inc_y3_grs_inc() {
		return r5_1_net_int_inc_y3_grs_inc;
	}
	public void setR5_1_net_int_inc_y3_grs_inc(BigDecimal r5_1_net_int_inc_y3_grs_inc) {
		this.r5_1_net_int_inc_y3_grs_inc = r5_1_net_int_inc_y3_grs_inc;
	}
	public BigDecimal getR5_2_net_non_int_inc_y3_grs_inc() {
		return r5_2_net_non_int_inc_y3_grs_inc;
	}
	public void setR5_2_net_non_int_inc_y3_grs_inc(BigDecimal r5_2_net_non_int_inc_y3_grs_inc) {
		this.r5_2_net_non_int_inc_y3_grs_inc = r5_2_net_non_int_inc_y3_grs_inc;
	}
	public BigDecimal getR5_3_grs_inc_y3_grs_inc() {
		return r5_3_grs_inc_y3_grs_inc;
	}
	public void setR5_3_grs_inc_y3_grs_inc(BigDecimal r5_3_grs_inc_y3_grs_inc) {
		this.r5_3_grs_inc_y3_grs_inc = r5_3_grs_inc_y3_grs_inc;
	}
	public BigDecimal getR5_4_net_int_inc_y2_grs_inc() {
		return r5_4_net_int_inc_y2_grs_inc;
	}
	public void setR5_4_net_int_inc_y2_grs_inc(BigDecimal r5_4_net_int_inc_y2_grs_inc) {
		this.r5_4_net_int_inc_y2_grs_inc = r5_4_net_int_inc_y2_grs_inc;
	}
	public BigDecimal getR5_5_net_non_int_inc_y2_grs_inc() {
		return r5_5_net_non_int_inc_y2_grs_inc;
	}
	public void setR5_5_net_non_int_inc_y2_grs_inc(BigDecimal r5_5_net_non_int_inc_y2_grs_inc) {
		this.r5_5_net_non_int_inc_y2_grs_inc = r5_5_net_non_int_inc_y2_grs_inc;
	}
	public BigDecimal getR5_6_grs_inc_y2_grs_inc() {
		return r5_6_grs_inc_y2_grs_inc;
	}
	public void setR5_6_grs_inc_y2_grs_inc(BigDecimal r5_6_grs_inc_y2_grs_inc) {
		this.r5_6_grs_inc_y2_grs_inc = r5_6_grs_inc_y2_grs_inc;
	}
	public BigDecimal getR5_7_net_int_inc_last_grs_inc() {
		return r5_7_net_int_inc_last_grs_inc;
	}
	public void setR5_7_net_int_inc_last_grs_inc(BigDecimal r5_7_net_int_inc_last_grs_inc) {
		this.r5_7_net_int_inc_last_grs_inc = r5_7_net_int_inc_last_grs_inc;
	}
	public BigDecimal getR5_8_net_non_int_inc_last_grs_inc() {
		return r5_8_net_non_int_inc_last_grs_inc;
	}
	public void setR5_8_net_non_int_inc_last_grs_inc(BigDecimal r5_8_net_non_int_inc_last_grs_inc) {
		this.r5_8_net_non_int_inc_last_grs_inc = r5_8_net_non_int_inc_last_grs_inc;
	}
	public BigDecimal getR5_9_grs_inc_last_grs_inc() {
		return r5_9_grs_inc_last_grs_inc;
	}
	public void setR5_9_grs_inc_last_grs_inc(BigDecimal r5_9_grs_inc_last_grs_inc) {
		this.r5_9_grs_inc_last_grs_inc = r5_9_grs_inc_last_grs_inc;
	}
	public String getR5_1o_y3_loan_advs() {
		return r5_1o_y3_loan_advs;
	}
	public void setR5_1o_y3_loan_advs(String r5_1o_y3_loan_advs) {
		this.r5_1o_y3_loan_advs = r5_1o_y3_loan_advs;
	}
	public String getR5_11_y2_loan_advs() {
		return r5_11_y2_loan_advs;
	}
	public void setR5_11_y2_loan_advs(String r5_11_y2_loan_advs) {
		this.r5_11_y2_loan_advs = r5_11_y2_loan_advs;
	}
	public String getR5_12_last_loan_advs() {
		return r5_12_last_loan_advs;
	}
	public void setR5_12_last_loan_advs(String r5_12_last_loan_advs) {
		this.r5_12_last_loan_advs = r5_12_last_loan_advs;
	}
	public String getR5_13_m_fac_loan_advs() {
		return r5_13_m_fac_loan_advs;
	}
	public void setR5_13_m_fac_loan_advs(String r5_13_m_fac_loan_advs) {
		this.r5_13_m_fac_loan_advs = r5_13_m_fac_loan_advs;
	}
	public BigDecimal getR5_14_3y_avg() {
		return r5_14_3y_avg;
	}
	public void setR5_14_3y_avg(BigDecimal r5_14_3y_avg) {
		this.r5_14_3y_avg = r5_14_3y_avg;
	}
	public BigDecimal getR5_15_beta_fac() {
		return r5_15_beta_fac;
	}
	public void setR5_15_beta_fac(BigDecimal r5_15_beta_fac) {
		this.r5_15_beta_fac = r5_15_beta_fac;
	}
	public BigDecimal getR5_16_cap_chrg_basel() {
		return r5_16_cap_chrg_basel;
	}
	public void setR5_16_cap_chrg_basel(BigDecimal r5_16_cap_chrg_basel) {
		this.r5_16_cap_chrg_basel = r5_16_cap_chrg_basel;
	}
	public BigDecimal getR5_16_cap_chrg_uae() {
		return r5_16_cap_chrg_uae;
	}
	public void setR5_16_cap_chrg_uae(BigDecimal r5_16_cap_chrg_uae) {
		this.r5_16_cap_chrg_uae = r5_16_cap_chrg_uae;
	}
	public String getR6_product() {
		return r6_product;
	}
	public void setR6_product(String r6_product) {
		this.r6_product = r6_product;
	}
	public BigDecimal getR6_1_net_int_inc_y3_grs_inc() {
		return r6_1_net_int_inc_y3_grs_inc;
	}
	public void setR6_1_net_int_inc_y3_grs_inc(BigDecimal r6_1_net_int_inc_y3_grs_inc) {
		this.r6_1_net_int_inc_y3_grs_inc = r6_1_net_int_inc_y3_grs_inc;
	}
	public BigDecimal getR6_2_net_non_int_inc_y3_grs_inc() {
		return r6_2_net_non_int_inc_y3_grs_inc;
	}
	public void setR6_2_net_non_int_inc_y3_grs_inc(BigDecimal r6_2_net_non_int_inc_y3_grs_inc) {
		this.r6_2_net_non_int_inc_y3_grs_inc = r6_2_net_non_int_inc_y3_grs_inc;
	}
	public BigDecimal getR6_3_grs_inc_y3_grs_inc() {
		return r6_3_grs_inc_y3_grs_inc;
	}
	public void setR6_3_grs_inc_y3_grs_inc(BigDecimal r6_3_grs_inc_y3_grs_inc) {
		this.r6_3_grs_inc_y3_grs_inc = r6_3_grs_inc_y3_grs_inc;
	}
	public BigDecimal getR6_4_net_int_inc_y2_grs_inc() {
		return r6_4_net_int_inc_y2_grs_inc;
	}
	public void setR6_4_net_int_inc_y2_grs_inc(BigDecimal r6_4_net_int_inc_y2_grs_inc) {
		this.r6_4_net_int_inc_y2_grs_inc = r6_4_net_int_inc_y2_grs_inc;
	}
	public BigDecimal getR6_5_net_non_int_inc_y2_grs_inc() {
		return r6_5_net_non_int_inc_y2_grs_inc;
	}
	public void setR6_5_net_non_int_inc_y2_grs_inc(BigDecimal r6_5_net_non_int_inc_y2_grs_inc) {
		this.r6_5_net_non_int_inc_y2_grs_inc = r6_5_net_non_int_inc_y2_grs_inc;
	}
	public BigDecimal getR6_6_grs_inc_y2_grs_inc() {
		return r6_6_grs_inc_y2_grs_inc;
	}
	public void setR6_6_grs_inc_y2_grs_inc(BigDecimal r6_6_grs_inc_y2_grs_inc) {
		this.r6_6_grs_inc_y2_grs_inc = r6_6_grs_inc_y2_grs_inc;
	}
	public BigDecimal getR6_7_net_int_inc_last_grs_inc() {
		return r6_7_net_int_inc_last_grs_inc;
	}
	public void setR6_7_net_int_inc_last_grs_inc(BigDecimal r6_7_net_int_inc_last_grs_inc) {
		this.r6_7_net_int_inc_last_grs_inc = r6_7_net_int_inc_last_grs_inc;
	}
	public BigDecimal getR6_8_net_non_int_inc_last_grs_inc() {
		return r6_8_net_non_int_inc_last_grs_inc;
	}
	public void setR6_8_net_non_int_inc_last_grs_inc(BigDecimal r6_8_net_non_int_inc_last_grs_inc) {
		this.r6_8_net_non_int_inc_last_grs_inc = r6_8_net_non_int_inc_last_grs_inc;
	}
	public BigDecimal getR6_9_grs_inc_last_grs_inc() {
		return r6_9_grs_inc_last_grs_inc;
	}
	public void setR6_9_grs_inc_last_grs_inc(BigDecimal r6_9_grs_inc_last_grs_inc) {
		this.r6_9_grs_inc_last_grs_inc = r6_9_grs_inc_last_grs_inc;
	}
	public String getR6_1o_y3_loan_advs() {
		return r6_1o_y3_loan_advs;
	}
	public void setR6_1o_y3_loan_advs(String r6_1o_y3_loan_advs) {
		this.r6_1o_y3_loan_advs = r6_1o_y3_loan_advs;
	}
	public String getR6_11_y2_loan_advs() {
		return r6_11_y2_loan_advs;
	}
	public void setR6_11_y2_loan_advs(String r6_11_y2_loan_advs) {
		this.r6_11_y2_loan_advs = r6_11_y2_loan_advs;
	}
	public String getR6_12_last_loan_advs() {
		return r6_12_last_loan_advs;
	}
	public void setR6_12_last_loan_advs(String r6_12_last_loan_advs) {
		this.r6_12_last_loan_advs = r6_12_last_loan_advs;
	}
	public String getR6_13_m_fac_loan_advs() {
		return r6_13_m_fac_loan_advs;
	}
	public void setR6_13_m_fac_loan_advs(String r6_13_m_fac_loan_advs) {
		this.r6_13_m_fac_loan_advs = r6_13_m_fac_loan_advs;
	}
	public BigDecimal getR6_14_3y_avg() {
		return r6_14_3y_avg;
	}
	public void setR6_14_3y_avg(BigDecimal r6_14_3y_avg) {
		this.r6_14_3y_avg = r6_14_3y_avg;
	}
	public BigDecimal getR6_15_beta_fac() {
		return r6_15_beta_fac;
	}
	public void setR6_15_beta_fac(BigDecimal r6_15_beta_fac) {
		this.r6_15_beta_fac = r6_15_beta_fac;
	}
	public BigDecimal getR6_16_cap_chrg_basel() {
		return r6_16_cap_chrg_basel;
	}
	public void setR6_16_cap_chrg_basel(BigDecimal r6_16_cap_chrg_basel) {
		this.r6_16_cap_chrg_basel = r6_16_cap_chrg_basel;
	}
	public BigDecimal getR6_16_cap_chrg_uae() {
		return r6_16_cap_chrg_uae;
	}
	public void setR6_16_cap_chrg_uae(BigDecimal r6_16_cap_chrg_uae) {
		this.r6_16_cap_chrg_uae = r6_16_cap_chrg_uae;
	}
	public String getR7_product() {
		return r7_product;
	}
	public void setR7_product(String r7_product) {
		this.r7_product = r7_product;
	}
	public BigDecimal getR7_1_net_int_inc_y3_grs_inc() {
		return r7_1_net_int_inc_y3_grs_inc;
	}
	public void setR7_1_net_int_inc_y3_grs_inc(BigDecimal r7_1_net_int_inc_y3_grs_inc) {
		this.r7_1_net_int_inc_y3_grs_inc = r7_1_net_int_inc_y3_grs_inc;
	}
	public BigDecimal getR7_2_net_non_int_inc_y3_grs_inc() {
		return r7_2_net_non_int_inc_y3_grs_inc;
	}
	public void setR7_2_net_non_int_inc_y3_grs_inc(BigDecimal r7_2_net_non_int_inc_y3_grs_inc) {
		this.r7_2_net_non_int_inc_y3_grs_inc = r7_2_net_non_int_inc_y3_grs_inc;
	}
	public BigDecimal getR7_3_grs_inc_y3_grs_inc() {
		return r7_3_grs_inc_y3_grs_inc;
	}
	public void setR7_3_grs_inc_y3_grs_inc(BigDecimal r7_3_grs_inc_y3_grs_inc) {
		this.r7_3_grs_inc_y3_grs_inc = r7_3_grs_inc_y3_grs_inc;
	}
	public BigDecimal getR7_4_net_int_inc_y2_grs_inc() {
		return r7_4_net_int_inc_y2_grs_inc;
	}
	public void setR7_4_net_int_inc_y2_grs_inc(BigDecimal r7_4_net_int_inc_y2_grs_inc) {
		this.r7_4_net_int_inc_y2_grs_inc = r7_4_net_int_inc_y2_grs_inc;
	}
	public BigDecimal getR7_5_net_non_int_inc_y2_grs_inc() {
		return r7_5_net_non_int_inc_y2_grs_inc;
	}
	public void setR7_5_net_non_int_inc_y2_grs_inc(BigDecimal r7_5_net_non_int_inc_y2_grs_inc) {
		this.r7_5_net_non_int_inc_y2_grs_inc = r7_5_net_non_int_inc_y2_grs_inc;
	}
	public BigDecimal getR7_6_grs_inc_y2_grs_inc() {
		return r7_6_grs_inc_y2_grs_inc;
	}
	public void setR7_6_grs_inc_y2_grs_inc(BigDecimal r7_6_grs_inc_y2_grs_inc) {
		this.r7_6_grs_inc_y2_grs_inc = r7_6_grs_inc_y2_grs_inc;
	}
	public BigDecimal getR7_7_net_int_inc_last_grs_inc() {
		return r7_7_net_int_inc_last_grs_inc;
	}
	public void setR7_7_net_int_inc_last_grs_inc(BigDecimal r7_7_net_int_inc_last_grs_inc) {
		this.r7_7_net_int_inc_last_grs_inc = r7_7_net_int_inc_last_grs_inc;
	}
	public BigDecimal getR7_8_net_non_int_inc_last_grs_inc() {
		return r7_8_net_non_int_inc_last_grs_inc;
	}
	public void setR7_8_net_non_int_inc_last_grs_inc(BigDecimal r7_8_net_non_int_inc_last_grs_inc) {
		this.r7_8_net_non_int_inc_last_grs_inc = r7_8_net_non_int_inc_last_grs_inc;
	}
	public BigDecimal getR7_9_grs_inc_last_grs_inc() {
		return r7_9_grs_inc_last_grs_inc;
	}
	public void setR7_9_grs_inc_last_grs_inc(BigDecimal r7_9_grs_inc_last_grs_inc) {
		this.r7_9_grs_inc_last_grs_inc = r7_9_grs_inc_last_grs_inc;
	}
	public String getR7_1o_y3_loan_advs() {
		return r7_1o_y3_loan_advs;
	}
	public void setR7_1o_y3_loan_advs(String r7_1o_y3_loan_advs) {
		this.r7_1o_y3_loan_advs = r7_1o_y3_loan_advs;
	}
	public String getR7_11_y2_loan_advs() {
		return r7_11_y2_loan_advs;
	}
	public void setR7_11_y2_loan_advs(String r7_11_y2_loan_advs) {
		this.r7_11_y2_loan_advs = r7_11_y2_loan_advs;
	}
	public String getR7_12_last_loan_advs() {
		return r7_12_last_loan_advs;
	}
	public void setR7_12_last_loan_advs(String r7_12_last_loan_advs) {
		this.r7_12_last_loan_advs = r7_12_last_loan_advs;
	}
	public String getR7_13_m_fac_loan_advs() {
		return r7_13_m_fac_loan_advs;
	}
	public void setR7_13_m_fac_loan_advs(String r7_13_m_fac_loan_advs) {
		this.r7_13_m_fac_loan_advs = r7_13_m_fac_loan_advs;
	}
	public BigDecimal getR7_14_3y_avg() {
		return r7_14_3y_avg;
	}
	public void setR7_14_3y_avg(BigDecimal r7_14_3y_avg) {
		this.r7_14_3y_avg = r7_14_3y_avg;
	}
	public BigDecimal getR7_15_beta_fac() {
		return r7_15_beta_fac;
	}
	public void setR7_15_beta_fac(BigDecimal r7_15_beta_fac) {
		this.r7_15_beta_fac = r7_15_beta_fac;
	}
	public BigDecimal getR7_16_cap_chrg_basel() {
		return r7_16_cap_chrg_basel;
	}
	public void setR7_16_cap_chrg_basel(BigDecimal r7_16_cap_chrg_basel) {
		this.r7_16_cap_chrg_basel = r7_16_cap_chrg_basel;
	}
	public BigDecimal getR7_16_cap_chrg_uae() {
		return r7_16_cap_chrg_uae;
	}
	public void setR7_16_cap_chrg_uae(BigDecimal r7_16_cap_chrg_uae) {
		this.r7_16_cap_chrg_uae = r7_16_cap_chrg_uae;
	}
	public String getR8_product() {
		return r8_product;
	}
	public void setR8_product(String r8_product) {
		this.r8_product = r8_product;
	}
	public BigDecimal getR8_1_net_int_inc_y3_grs_inc() {
		return r8_1_net_int_inc_y3_grs_inc;
	}
	public void setR8_1_net_int_inc_y3_grs_inc(BigDecimal r8_1_net_int_inc_y3_grs_inc) {
		this.r8_1_net_int_inc_y3_grs_inc = r8_1_net_int_inc_y3_grs_inc;
	}
	public BigDecimal getR8_2_net_non_int_inc_y3_grs_inc() {
		return r8_2_net_non_int_inc_y3_grs_inc;
	}
	public void setR8_2_net_non_int_inc_y3_grs_inc(BigDecimal r8_2_net_non_int_inc_y3_grs_inc) {
		this.r8_2_net_non_int_inc_y3_grs_inc = r8_2_net_non_int_inc_y3_grs_inc;
	}
	public BigDecimal getR8_3_grs_inc_y3_grs_inc() {
		return r8_3_grs_inc_y3_grs_inc;
	}
	public void setR8_3_grs_inc_y3_grs_inc(BigDecimal r8_3_grs_inc_y3_grs_inc) {
		this.r8_3_grs_inc_y3_grs_inc = r8_3_grs_inc_y3_grs_inc;
	}
	public BigDecimal getR8_4_net_int_inc_y2_grs_inc() {
		return r8_4_net_int_inc_y2_grs_inc;
	}
	public void setR8_4_net_int_inc_y2_grs_inc(BigDecimal r8_4_net_int_inc_y2_grs_inc) {
		this.r8_4_net_int_inc_y2_grs_inc = r8_4_net_int_inc_y2_grs_inc;
	}
	public BigDecimal getR8_5_net_non_int_inc_y2_grs_inc() {
		return r8_5_net_non_int_inc_y2_grs_inc;
	}
	public void setR8_5_net_non_int_inc_y2_grs_inc(BigDecimal r8_5_net_non_int_inc_y2_grs_inc) {
		this.r8_5_net_non_int_inc_y2_grs_inc = r8_5_net_non_int_inc_y2_grs_inc;
	}
	public BigDecimal getR8_6_grs_inc_y2_grs_inc() {
		return r8_6_grs_inc_y2_grs_inc;
	}
	public void setR8_6_grs_inc_y2_grs_inc(BigDecimal r8_6_grs_inc_y2_grs_inc) {
		this.r8_6_grs_inc_y2_grs_inc = r8_6_grs_inc_y2_grs_inc;
	}
	public BigDecimal getR8_7_net_int_inc_last_grs_inc() {
		return r8_7_net_int_inc_last_grs_inc;
	}
	public void setR8_7_net_int_inc_last_grs_inc(BigDecimal r8_7_net_int_inc_last_grs_inc) {
		this.r8_7_net_int_inc_last_grs_inc = r8_7_net_int_inc_last_grs_inc;
	}
	public BigDecimal getR8_8_net_non_int_inc_last_grs_inc() {
		return r8_8_net_non_int_inc_last_grs_inc;
	}
	public void setR8_8_net_non_int_inc_last_grs_inc(BigDecimal r8_8_net_non_int_inc_last_grs_inc) {
		this.r8_8_net_non_int_inc_last_grs_inc = r8_8_net_non_int_inc_last_grs_inc;
	}
	public BigDecimal getR8_9_grs_inc_last_grs_inc() {
		return r8_9_grs_inc_last_grs_inc;
	}
	public void setR8_9_grs_inc_last_grs_inc(BigDecimal r8_9_grs_inc_last_grs_inc) {
		this.r8_9_grs_inc_last_grs_inc = r8_9_grs_inc_last_grs_inc;
	}
	public String getR8_1o_y3_loan_advs() {
		return r8_1o_y3_loan_advs;
	}
	public void setR8_1o_y3_loan_advs(String r8_1o_y3_loan_advs) {
		this.r8_1o_y3_loan_advs = r8_1o_y3_loan_advs;
	}
	public String getR8_11_y2_loan_advs() {
		return r8_11_y2_loan_advs;
	}
	public void setR8_11_y2_loan_advs(String r8_11_y2_loan_advs) {
		this.r8_11_y2_loan_advs = r8_11_y2_loan_advs;
	}
	public String getR8_12_last_loan_advs() {
		return r8_12_last_loan_advs;
	}
	public void setR8_12_last_loan_advs(String r8_12_last_loan_advs) {
		this.r8_12_last_loan_advs = r8_12_last_loan_advs;
	}
	public String getR8_13_m_fac_loan_advs() {
		return r8_13_m_fac_loan_advs;
	}
	public void setR8_13_m_fac_loan_advs(String r8_13_m_fac_loan_advs) {
		this.r8_13_m_fac_loan_advs = r8_13_m_fac_loan_advs;
	}
	public BigDecimal getR8_14_3y_avg() {
		return r8_14_3y_avg;
	}
	public void setR8_14_3y_avg(BigDecimal r8_14_3y_avg) {
		this.r8_14_3y_avg = r8_14_3y_avg;
	}
	public BigDecimal getR8_15_beta_fac() {
		return r8_15_beta_fac;
	}
	public void setR8_15_beta_fac(BigDecimal r8_15_beta_fac) {
		this.r8_15_beta_fac = r8_15_beta_fac;
	}
	public BigDecimal getR8_16_cap_chrg_basel() {
		return r8_16_cap_chrg_basel;
	}
	public void setR8_16_cap_chrg_basel(BigDecimal r8_16_cap_chrg_basel) {
		this.r8_16_cap_chrg_basel = r8_16_cap_chrg_basel;
	}
	public BigDecimal getR8_16_cap_chrg_uae() {
		return r8_16_cap_chrg_uae;
	}
	public void setR8_16_cap_chrg_uae(BigDecimal r8_16_cap_chrg_uae) {
		this.r8_16_cap_chrg_uae = r8_16_cap_chrg_uae;
	}
	public String getR9_product() {
		return r9_product;
	}
	public void setR9_product(String r9_product) {
		this.r9_product = r9_product;
	}
	public BigDecimal getR9_1_net_int_inc_y3_grs_inc() {
		return r9_1_net_int_inc_y3_grs_inc;
	}
	public void setR9_1_net_int_inc_y3_grs_inc(BigDecimal r9_1_net_int_inc_y3_grs_inc) {
		this.r9_1_net_int_inc_y3_grs_inc = r9_1_net_int_inc_y3_grs_inc;
	}
	public BigDecimal getR9_2_net_non_int_inc_y3_grs_inc() {
		return r9_2_net_non_int_inc_y3_grs_inc;
	}
	public void setR9_2_net_non_int_inc_y3_grs_inc(BigDecimal r9_2_net_non_int_inc_y3_grs_inc) {
		this.r9_2_net_non_int_inc_y3_grs_inc = r9_2_net_non_int_inc_y3_grs_inc;
	}
	public BigDecimal getR9_3_grs_inc_y3_grs_inc() {
		return r9_3_grs_inc_y3_grs_inc;
	}
	public void setR9_3_grs_inc_y3_grs_inc(BigDecimal r9_3_grs_inc_y3_grs_inc) {
		this.r9_3_grs_inc_y3_grs_inc = r9_3_grs_inc_y3_grs_inc;
	}
	public BigDecimal getR9_4_net_int_inc_y2_grs_inc() {
		return r9_4_net_int_inc_y2_grs_inc;
	}
	public void setR9_4_net_int_inc_y2_grs_inc(BigDecimal r9_4_net_int_inc_y2_grs_inc) {
		this.r9_4_net_int_inc_y2_grs_inc = r9_4_net_int_inc_y2_grs_inc;
	}
	public BigDecimal getR9_5_net_non_int_inc_y2_grs_inc() {
		return r9_5_net_non_int_inc_y2_grs_inc;
	}
	public void setR9_5_net_non_int_inc_y2_grs_inc(BigDecimal r9_5_net_non_int_inc_y2_grs_inc) {
		this.r9_5_net_non_int_inc_y2_grs_inc = r9_5_net_non_int_inc_y2_grs_inc;
	}
	public BigDecimal getR9_6_grs_inc_y2_grs_inc() {
		return r9_6_grs_inc_y2_grs_inc;
	}
	public void setR9_6_grs_inc_y2_grs_inc(BigDecimal r9_6_grs_inc_y2_grs_inc) {
		this.r9_6_grs_inc_y2_grs_inc = r9_6_grs_inc_y2_grs_inc;
	}
	public BigDecimal getR9_7_net_int_inc_last_grs_inc() {
		return r9_7_net_int_inc_last_grs_inc;
	}
	public void setR9_7_net_int_inc_last_grs_inc(BigDecimal r9_7_net_int_inc_last_grs_inc) {
		this.r9_7_net_int_inc_last_grs_inc = r9_7_net_int_inc_last_grs_inc;
	}
	public BigDecimal getR9_8_net_non_int_inc_last_grs_inc() {
		return r9_8_net_non_int_inc_last_grs_inc;
	}
	public void setR9_8_net_non_int_inc_last_grs_inc(BigDecimal r9_8_net_non_int_inc_last_grs_inc) {
		this.r9_8_net_non_int_inc_last_grs_inc = r9_8_net_non_int_inc_last_grs_inc;
	}
	public BigDecimal getR9_9_grs_inc_last_grs_inc() {
		return r9_9_grs_inc_last_grs_inc;
	}
	public void setR9_9_grs_inc_last_grs_inc(BigDecimal r9_9_grs_inc_last_grs_inc) {
		this.r9_9_grs_inc_last_grs_inc = r9_9_grs_inc_last_grs_inc;
	}
	public String getR9_1o_y3_loan_advs() {
		return r9_1o_y3_loan_advs;
	}
	public void setR9_1o_y3_loan_advs(String r9_1o_y3_loan_advs) {
		this.r9_1o_y3_loan_advs = r9_1o_y3_loan_advs;
	}
	public String getR9_11_y2_loan_advs() {
		return r9_11_y2_loan_advs;
	}
	public void setR9_11_y2_loan_advs(String r9_11_y2_loan_advs) {
		this.r9_11_y2_loan_advs = r9_11_y2_loan_advs;
	}
	public String getR9_12_last_loan_advs() {
		return r9_12_last_loan_advs;
	}
	public void setR9_12_last_loan_advs(String r9_12_last_loan_advs) {
		this.r9_12_last_loan_advs = r9_12_last_loan_advs;
	}
	public String getR9_13_m_fac_loan_advs() {
		return r9_13_m_fac_loan_advs;
	}
	public void setR9_13_m_fac_loan_advs(String r9_13_m_fac_loan_advs) {
		this.r9_13_m_fac_loan_advs = r9_13_m_fac_loan_advs;
	}
	public BigDecimal getR9_14_3y_avg() {
		return r9_14_3y_avg;
	}
	public void setR9_14_3y_avg(BigDecimal r9_14_3y_avg) {
		this.r9_14_3y_avg = r9_14_3y_avg;
	}
	public BigDecimal getR9_15_beta_fac() {
		return r9_15_beta_fac;
	}
	public void setR9_15_beta_fac(BigDecimal r9_15_beta_fac) {
		this.r9_15_beta_fac = r9_15_beta_fac;
	}
	public BigDecimal getR9_16_cap_chrg_basel() {
		return r9_16_cap_chrg_basel;
	}
	public void setR9_16_cap_chrg_basel(BigDecimal r9_16_cap_chrg_basel) {
		this.r9_16_cap_chrg_basel = r9_16_cap_chrg_basel;
	}
	public BigDecimal getR9_16_cap_chrg_uae() {
		return r9_16_cap_chrg_uae;
	}
	public void setR9_16_cap_chrg_uae(BigDecimal r9_16_cap_chrg_uae) {
		this.r9_16_cap_chrg_uae = r9_16_cap_chrg_uae;
	}
	public String getR10_product() {
		return r10_product;
	}
	public void setR10_product(String r10_product) {
		this.r10_product = r10_product;
	}
	public BigDecimal getR10_1_net_int_inc_y3_grs_inc() {
		return r10_1_net_int_inc_y3_grs_inc;
	}
	public void setR10_1_net_int_inc_y3_grs_inc(BigDecimal r10_1_net_int_inc_y3_grs_inc) {
		this.r10_1_net_int_inc_y3_grs_inc = r10_1_net_int_inc_y3_grs_inc;
	}
	public BigDecimal getR10_2_net_non_int_inc_y3_grs_inc() {
		return r10_2_net_non_int_inc_y3_grs_inc;
	}
	public void setR10_2_net_non_int_inc_y3_grs_inc(BigDecimal r10_2_net_non_int_inc_y3_grs_inc) {
		this.r10_2_net_non_int_inc_y3_grs_inc = r10_2_net_non_int_inc_y3_grs_inc;
	}
	public BigDecimal getR10_3_grs_inc_y3_grs_inc() {
		return r10_3_grs_inc_y3_grs_inc;
	}
	public void setR10_3_grs_inc_y3_grs_inc(BigDecimal r10_3_grs_inc_y3_grs_inc) {
		this.r10_3_grs_inc_y3_grs_inc = r10_3_grs_inc_y3_grs_inc;
	}
	public BigDecimal getR10_4_net_int_inc_y2_grs_inc() {
		return r10_4_net_int_inc_y2_grs_inc;
	}
	public void setR10_4_net_int_inc_y2_grs_inc(BigDecimal r10_4_net_int_inc_y2_grs_inc) {
		this.r10_4_net_int_inc_y2_grs_inc = r10_4_net_int_inc_y2_grs_inc;
	}
	public BigDecimal getR10_5_net_non_int_inc_y2_grs_inc() {
		return r10_5_net_non_int_inc_y2_grs_inc;
	}
	public void setR10_5_net_non_int_inc_y2_grs_inc(BigDecimal r10_5_net_non_int_inc_y2_grs_inc) {
		this.r10_5_net_non_int_inc_y2_grs_inc = r10_5_net_non_int_inc_y2_grs_inc;
	}
	public BigDecimal getR10_6_grs_inc_y2_grs_inc() {
		return r10_6_grs_inc_y2_grs_inc;
	}
	public void setR10_6_grs_inc_y2_grs_inc(BigDecimal r10_6_grs_inc_y2_grs_inc) {
		this.r10_6_grs_inc_y2_grs_inc = r10_6_grs_inc_y2_grs_inc;
	}
	public BigDecimal getR10_7_net_int_inc_last_grs_inc() {
		return r10_7_net_int_inc_last_grs_inc;
	}
	public void setR10_7_net_int_inc_last_grs_inc(BigDecimal r10_7_net_int_inc_last_grs_inc) {
		this.r10_7_net_int_inc_last_grs_inc = r10_7_net_int_inc_last_grs_inc;
	}
	public BigDecimal getR10_8_net_non_int_inc_last_grs_inc() {
		return r10_8_net_non_int_inc_last_grs_inc;
	}
	public void setR10_8_net_non_int_inc_last_grs_inc(BigDecimal r10_8_net_non_int_inc_last_grs_inc) {
		this.r10_8_net_non_int_inc_last_grs_inc = r10_8_net_non_int_inc_last_grs_inc;
	}
	public BigDecimal getR10_9_grs_inc_last_grs_inc() {
		return r10_9_grs_inc_last_grs_inc;
	}
	public void setR10_9_grs_inc_last_grs_inc(BigDecimal r10_9_grs_inc_last_grs_inc) {
		this.r10_9_grs_inc_last_grs_inc = r10_9_grs_inc_last_grs_inc;
	}
	public String getR10_1o_y3_loan_advs() {
		return r10_1o_y3_loan_advs;
	}
	public void setR10_1o_y3_loan_advs(String r10_1o_y3_loan_advs) {
		this.r10_1o_y3_loan_advs = r10_1o_y3_loan_advs;
	}
	public String getR10_11_y2_loan_advs() {
		return r10_11_y2_loan_advs;
	}
	public void setR10_11_y2_loan_advs(String r10_11_y2_loan_advs) {
		this.r10_11_y2_loan_advs = r10_11_y2_loan_advs;
	}
	public String getR10_12_last_loan_advs() {
		return r10_12_last_loan_advs;
	}
	public void setR10_12_last_loan_advs(String r10_12_last_loan_advs) {
		this.r10_12_last_loan_advs = r10_12_last_loan_advs;
	}
	public String getR10_13_m_fac_loan_advs() {
		return r10_13_m_fac_loan_advs;
	}
	public void setR10_13_m_fac_loan_advs(String r10_13_m_fac_loan_advs) {
		this.r10_13_m_fac_loan_advs = r10_13_m_fac_loan_advs;
	}
	public BigDecimal getR10_14_3y_avg() {
		return r10_14_3y_avg;
	}
	public void setR10_14_3y_avg(BigDecimal r10_14_3y_avg) {
		this.r10_14_3y_avg = r10_14_3y_avg;
	}
	public BigDecimal getR10_15_beta_fac() {
		return r10_15_beta_fac;
	}
	public void setR10_15_beta_fac(BigDecimal r10_15_beta_fac) {
		this.r10_15_beta_fac = r10_15_beta_fac;
	}
	public BigDecimal getR10_16_cap_chrg_basel() {
		return r10_16_cap_chrg_basel;
	}
	public void setR10_16_cap_chrg_basel(BigDecimal r10_16_cap_chrg_basel) {
		this.r10_16_cap_chrg_basel = r10_16_cap_chrg_basel;
	}
	public BigDecimal getR10_16_cap_chrg_uae() {
		return r10_16_cap_chrg_uae;
	}
	public void setR10_16_cap_chrg_uae(BigDecimal r10_16_cap_chrg_uae) {
		this.r10_16_cap_chrg_uae = r10_16_cap_chrg_uae;
	}
	public String getR11_product() {
		return r11_product;
	}
	public void setR11_product(String r11_product) {
		this.r11_product = r11_product;
	}
	public BigDecimal getR11_1_net_int_inc_y3_grs_inc() {
		return r11_1_net_int_inc_y3_grs_inc;
	}
	public void setR11_1_net_int_inc_y3_grs_inc(BigDecimal r11_1_net_int_inc_y3_grs_inc) {
		this.r11_1_net_int_inc_y3_grs_inc = r11_1_net_int_inc_y3_grs_inc;
	}
	public BigDecimal getR11_2_net_non_int_inc_y3_grs_inc() {
		return r11_2_net_non_int_inc_y3_grs_inc;
	}
	public void setR11_2_net_non_int_inc_y3_grs_inc(BigDecimal r11_2_net_non_int_inc_y3_grs_inc) {
		this.r11_2_net_non_int_inc_y3_grs_inc = r11_2_net_non_int_inc_y3_grs_inc;
	}
	public BigDecimal getR11_3_grs_inc_y3_grs_inc() {
		return r11_3_grs_inc_y3_grs_inc;
	}
	public void setR11_3_grs_inc_y3_grs_inc(BigDecimal r11_3_grs_inc_y3_grs_inc) {
		this.r11_3_grs_inc_y3_grs_inc = r11_3_grs_inc_y3_grs_inc;
	}
	public BigDecimal getR11_4_net_int_inc_y2_grs_inc() {
		return r11_4_net_int_inc_y2_grs_inc;
	}
	public void setR11_4_net_int_inc_y2_grs_inc(BigDecimal r11_4_net_int_inc_y2_grs_inc) {
		this.r11_4_net_int_inc_y2_grs_inc = r11_4_net_int_inc_y2_grs_inc;
	}
	public BigDecimal getR11_5_net_non_int_inc_y2_grs_inc() {
		return r11_5_net_non_int_inc_y2_grs_inc;
	}
	public void setR11_5_net_non_int_inc_y2_grs_inc(BigDecimal r11_5_net_non_int_inc_y2_grs_inc) {
		this.r11_5_net_non_int_inc_y2_grs_inc = r11_5_net_non_int_inc_y2_grs_inc;
	}
	public BigDecimal getR11_6_grs_inc_y2_grs_inc() {
		return r11_6_grs_inc_y2_grs_inc;
	}
	public void setR11_6_grs_inc_y2_grs_inc(BigDecimal r11_6_grs_inc_y2_grs_inc) {
		this.r11_6_grs_inc_y2_grs_inc = r11_6_grs_inc_y2_grs_inc;
	}
	public BigDecimal getR11_7_net_int_inc_last_grs_inc() {
		return r11_7_net_int_inc_last_grs_inc;
	}
	public void setR11_7_net_int_inc_last_grs_inc(BigDecimal r11_7_net_int_inc_last_grs_inc) {
		this.r11_7_net_int_inc_last_grs_inc = r11_7_net_int_inc_last_grs_inc;
	}
	public BigDecimal getR11_8_net_non_int_inc_last_grs_inc() {
		return r11_8_net_non_int_inc_last_grs_inc;
	}
	public void setR11_8_net_non_int_inc_last_grs_inc(BigDecimal r11_8_net_non_int_inc_last_grs_inc) {
		this.r11_8_net_non_int_inc_last_grs_inc = r11_8_net_non_int_inc_last_grs_inc;
	}
	public BigDecimal getR11_9_grs_inc_last_grs_inc() {
		return r11_9_grs_inc_last_grs_inc;
	}
	public void setR11_9_grs_inc_last_grs_inc(BigDecimal r11_9_grs_inc_last_grs_inc) {
		this.r11_9_grs_inc_last_grs_inc = r11_9_grs_inc_last_grs_inc;
	}
	public String getR11_1o_y3_loan_advs() {
		return r11_1o_y3_loan_advs;
	}
	public void setR11_1o_y3_loan_advs(String r11_1o_y3_loan_advs) {
		this.r11_1o_y3_loan_advs = r11_1o_y3_loan_advs;
	}
	public String getR11_11_y2_loan_advs() {
		return r11_11_y2_loan_advs;
	}
	public void setR11_11_y2_loan_advs(String r11_11_y2_loan_advs) {
		this.r11_11_y2_loan_advs = r11_11_y2_loan_advs;
	}
	public String getR11_12_last_loan_advs() {
		return r11_12_last_loan_advs;
	}
	public void setR11_12_last_loan_advs(String r11_12_last_loan_advs) {
		this.r11_12_last_loan_advs = r11_12_last_loan_advs;
	}
	public String getR11_13_m_fac_loan_advs() {
		return r11_13_m_fac_loan_advs;
	}
	public void setR11_13_m_fac_loan_advs(String r11_13_m_fac_loan_advs) {
		this.r11_13_m_fac_loan_advs = r11_13_m_fac_loan_advs;
	}
	public BigDecimal getR11_14_3y_avg() {
		return r11_14_3y_avg;
	}
	public void setR11_14_3y_avg(BigDecimal r11_14_3y_avg) {
		this.r11_14_3y_avg = r11_14_3y_avg;
	}
	public BigDecimal getR11_15_beta_fac() {
		return r11_15_beta_fac;
	}
	public void setR11_15_beta_fac(BigDecimal r11_15_beta_fac) {
		this.r11_15_beta_fac = r11_15_beta_fac;
	}
	public BigDecimal getR11_16_cap_chrg_basel() {
		return r11_16_cap_chrg_basel;
	}
	public void setR11_16_cap_chrg_basel(BigDecimal r11_16_cap_chrg_basel) {
		this.r11_16_cap_chrg_basel = r11_16_cap_chrg_basel;
	}
	public BigDecimal getR11_16_cap_chrg_uae() {
		return r11_16_cap_chrg_uae;
	}
	public void setR11_16_cap_chrg_uae(BigDecimal r11_16_cap_chrg_uae) {
		this.r11_16_cap_chrg_uae = r11_16_cap_chrg_uae;
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
	public BASEL_OPRISK_OR1(String r1_product, BigDecimal r1_1_net_int_inc_y3_grs_inc,
			BigDecimal r1_2_net_non_int_inc_y3_grs_inc, BigDecimal r1_3_grs_inc_y3_grs_inc,
			BigDecimal r1_4_net_int_inc_y2_grs_inc, BigDecimal r1_5_net_non_int_inc_y2_grs_inc,
			BigDecimal r1_6_grs_inc_y2_grs_inc, BigDecimal r1_7_net_int_inc_last_grs_inc,
			BigDecimal r1_8_net_non_int_inc_last_grs_inc, BigDecimal r1_9_grs_inc_last_grs_inc,
			String r1_1o_y3_loan_advs, String r1_11_y2_loan_advs, String r1_12_last_loan_advs,
			String r1_13_m_fac_loan_advs, BigDecimal r1_14_3y_avg, BigDecimal r1_15_beta_fac,
			BigDecimal r1_16_cap_chrg_basel, BigDecimal r1_16_cap_chrg_uae, String r2_product, String r3_product,
			BigDecimal r3_1_net_int_inc_y3_grs_inc, BigDecimal r3_2_net_non_int_inc_y3_grs_inc,
			BigDecimal r3_3_grs_inc_y3_grs_inc, BigDecimal r3_4_net_int_inc_y2_grs_inc,
			BigDecimal r3_5_net_non_int_inc_y2_grs_inc, BigDecimal r3_6_grs_inc_y2_grs_inc,
			BigDecimal r3_7_net_int_inc_last_grs_inc, BigDecimal r3_8_net_non_int_inc_last_grs_inc,
			BigDecimal r3_9_grs_inc_last_grs_inc, String r3_1o_y3_loan_advs, String r3_11_y2_loan_advs,
			String r3_12_last_loan_advs, String r3_13_m_fac_loan_advs, BigDecimal r3_14_3y_avg,
			BigDecimal r3_15_beta_fac, BigDecimal r3_16_cap_chrg_basel, BigDecimal r3_16_cap_chrg_uae,
			String r4_product, BigDecimal r4_1_net_int_inc_y3_grs_inc, BigDecimal r4_2_net_non_int_inc_y3_grs_inc,
			BigDecimal r4_3_grs_inc_y3_grs_inc, BigDecimal r4_4_net_int_inc_y2_grs_inc,
			BigDecimal r4_5_net_non_int_inc_y2_grs_inc, BigDecimal r4_6_grs_inc_y2_grs_inc,
			BigDecimal r4_7_net_int_inc_last_grs_inc, BigDecimal r4_8_net_non_int_inc_last_grs_inc,
			BigDecimal r4_9_grs_inc_last_grs_inc, String r4_1o_y3_loan_advs, String r4_11_y2_loan_advs,
			String r4_12_last_loan_advs, String r4_13_m_fac_loan_advs, BigDecimal r4_14_3y_avg,
			BigDecimal r4_15_beta_fac, BigDecimal r4_16_cap_chrg_basel, BigDecimal r4_16_cap_chrg_uae,
			String r5_product, BigDecimal r5_1_net_int_inc_y3_grs_inc, BigDecimal r5_2_net_non_int_inc_y3_grs_inc,
			BigDecimal r5_3_grs_inc_y3_grs_inc, BigDecimal r5_4_net_int_inc_y2_grs_inc,
			BigDecimal r5_5_net_non_int_inc_y2_grs_inc, BigDecimal r5_6_grs_inc_y2_grs_inc,
			BigDecimal r5_7_net_int_inc_last_grs_inc, BigDecimal r5_8_net_non_int_inc_last_grs_inc,
			BigDecimal r5_9_grs_inc_last_grs_inc, String r5_1o_y3_loan_advs, String r5_11_y2_loan_advs,
			String r5_12_last_loan_advs, String r5_13_m_fac_loan_advs, BigDecimal r5_14_3y_avg,
			BigDecimal r5_15_beta_fac, BigDecimal r5_16_cap_chrg_basel, BigDecimal r5_16_cap_chrg_uae,
			String r6_product, BigDecimal r6_1_net_int_inc_y3_grs_inc, BigDecimal r6_2_net_non_int_inc_y3_grs_inc,
			BigDecimal r6_3_grs_inc_y3_grs_inc, BigDecimal r6_4_net_int_inc_y2_grs_inc,
			BigDecimal r6_5_net_non_int_inc_y2_grs_inc, BigDecimal r6_6_grs_inc_y2_grs_inc,
			BigDecimal r6_7_net_int_inc_last_grs_inc, BigDecimal r6_8_net_non_int_inc_last_grs_inc,
			BigDecimal r6_9_grs_inc_last_grs_inc, String r6_1o_y3_loan_advs, String r6_11_y2_loan_advs,
			String r6_12_last_loan_advs, String r6_13_m_fac_loan_advs, BigDecimal r6_14_3y_avg,
			BigDecimal r6_15_beta_fac, BigDecimal r6_16_cap_chrg_basel, BigDecimal r6_16_cap_chrg_uae,
			String r7_product, BigDecimal r7_1_net_int_inc_y3_grs_inc, BigDecimal r7_2_net_non_int_inc_y3_grs_inc,
			BigDecimal r7_3_grs_inc_y3_grs_inc, BigDecimal r7_4_net_int_inc_y2_grs_inc,
			BigDecimal r7_5_net_non_int_inc_y2_grs_inc, BigDecimal r7_6_grs_inc_y2_grs_inc,
			BigDecimal r7_7_net_int_inc_last_grs_inc, BigDecimal r7_8_net_non_int_inc_last_grs_inc,
			BigDecimal r7_9_grs_inc_last_grs_inc, String r7_1o_y3_loan_advs, String r7_11_y2_loan_advs,
			String r7_12_last_loan_advs, String r7_13_m_fac_loan_advs, BigDecimal r7_14_3y_avg,
			BigDecimal r7_15_beta_fac, BigDecimal r7_16_cap_chrg_basel, BigDecimal r7_16_cap_chrg_uae,
			String r8_product, BigDecimal r8_1_net_int_inc_y3_grs_inc, BigDecimal r8_2_net_non_int_inc_y3_grs_inc,
			BigDecimal r8_3_grs_inc_y3_grs_inc, BigDecimal r8_4_net_int_inc_y2_grs_inc,
			BigDecimal r8_5_net_non_int_inc_y2_grs_inc, BigDecimal r8_6_grs_inc_y2_grs_inc,
			BigDecimal r8_7_net_int_inc_last_grs_inc, BigDecimal r8_8_net_non_int_inc_last_grs_inc,
			BigDecimal r8_9_grs_inc_last_grs_inc, String r8_1o_y3_loan_advs, String r8_11_y2_loan_advs,
			String r8_12_last_loan_advs, String r8_13_m_fac_loan_advs, BigDecimal r8_14_3y_avg,
			BigDecimal r8_15_beta_fac, BigDecimal r8_16_cap_chrg_basel, BigDecimal r8_16_cap_chrg_uae,
			String r9_product, BigDecimal r9_1_net_int_inc_y3_grs_inc, BigDecimal r9_2_net_non_int_inc_y3_grs_inc,
			BigDecimal r9_3_grs_inc_y3_grs_inc, BigDecimal r9_4_net_int_inc_y2_grs_inc,
			BigDecimal r9_5_net_non_int_inc_y2_grs_inc, BigDecimal r9_6_grs_inc_y2_grs_inc,
			BigDecimal r9_7_net_int_inc_last_grs_inc, BigDecimal r9_8_net_non_int_inc_last_grs_inc,
			BigDecimal r9_9_grs_inc_last_grs_inc, String r9_1o_y3_loan_advs, String r9_11_y2_loan_advs,
			String r9_12_last_loan_advs, String r9_13_m_fac_loan_advs, BigDecimal r9_14_3y_avg,
			BigDecimal r9_15_beta_fac, BigDecimal r9_16_cap_chrg_basel, BigDecimal r9_16_cap_chrg_uae,
			String r10_product, BigDecimal r10_1_net_int_inc_y3_grs_inc, BigDecimal r10_2_net_non_int_inc_y3_grs_inc,
			BigDecimal r10_3_grs_inc_y3_grs_inc, BigDecimal r10_4_net_int_inc_y2_grs_inc,
			BigDecimal r10_5_net_non_int_inc_y2_grs_inc, BigDecimal r10_6_grs_inc_y2_grs_inc,
			BigDecimal r10_7_net_int_inc_last_grs_inc, BigDecimal r10_8_net_non_int_inc_last_grs_inc,
			BigDecimal r10_9_grs_inc_last_grs_inc, String r10_1o_y3_loan_advs, String r10_11_y2_loan_advs,
			String r10_12_last_loan_advs, String r10_13_m_fac_loan_advs, BigDecimal r10_14_3y_avg,
			BigDecimal r10_15_beta_fac, BigDecimal r10_16_cap_chrg_basel, BigDecimal r10_16_cap_chrg_uae,
			String r11_product, BigDecimal r11_1_net_int_inc_y3_grs_inc, BigDecimal r11_2_net_non_int_inc_y3_grs_inc,
			BigDecimal r11_3_grs_inc_y3_grs_inc, BigDecimal r11_4_net_int_inc_y2_grs_inc,
			BigDecimal r11_5_net_non_int_inc_y2_grs_inc, BigDecimal r11_6_grs_inc_y2_grs_inc,
			BigDecimal r11_7_net_int_inc_last_grs_inc, BigDecimal r11_8_net_non_int_inc_last_grs_inc,
			BigDecimal r11_9_grs_inc_last_grs_inc, String r11_1o_y3_loan_advs, String r11_11_y2_loan_advs,
			String r11_12_last_loan_advs, String r11_13_m_fac_loan_advs, BigDecimal r11_14_3y_avg,
			BigDecimal r11_15_beta_fac, BigDecimal r11_16_cap_chrg_basel, BigDecimal r11_16_cap_chrg_uae,
			Date report_date, Date report_from_date, Date report_to_date, String entity_flg, String modify_flg,
			String del_flg, String report_code) {
		super();
		this.r1_product = r1_product;
		this.r1_1_net_int_inc_y3_grs_inc = r1_1_net_int_inc_y3_grs_inc;
		this.r1_2_net_non_int_inc_y3_grs_inc = r1_2_net_non_int_inc_y3_grs_inc;
		this.r1_3_grs_inc_y3_grs_inc = r1_3_grs_inc_y3_grs_inc;
		this.r1_4_net_int_inc_y2_grs_inc = r1_4_net_int_inc_y2_grs_inc;
		this.r1_5_net_non_int_inc_y2_grs_inc = r1_5_net_non_int_inc_y2_grs_inc;
		this.r1_6_grs_inc_y2_grs_inc = r1_6_grs_inc_y2_grs_inc;
		this.r1_7_net_int_inc_last_grs_inc = r1_7_net_int_inc_last_grs_inc;
		this.r1_8_net_non_int_inc_last_grs_inc = r1_8_net_non_int_inc_last_grs_inc;
		this.r1_9_grs_inc_last_grs_inc = r1_9_grs_inc_last_grs_inc;
		this.r1_1o_y3_loan_advs = r1_1o_y3_loan_advs;
		this.r1_11_y2_loan_advs = r1_11_y2_loan_advs;
		this.r1_12_last_loan_advs = r1_12_last_loan_advs;
		this.r1_13_m_fac_loan_advs = r1_13_m_fac_loan_advs;
		this.r1_14_3y_avg = r1_14_3y_avg;
		this.r1_15_beta_fac = r1_15_beta_fac;
		this.r1_16_cap_chrg_basel = r1_16_cap_chrg_basel;
		this.r1_16_cap_chrg_uae = r1_16_cap_chrg_uae;
		this.r2_product = r2_product;
		this.r3_product = r3_product;
		this.r3_1_net_int_inc_y3_grs_inc = r3_1_net_int_inc_y3_grs_inc;
		this.r3_2_net_non_int_inc_y3_grs_inc = r3_2_net_non_int_inc_y3_grs_inc;
		this.r3_3_grs_inc_y3_grs_inc = r3_3_grs_inc_y3_grs_inc;
		this.r3_4_net_int_inc_y2_grs_inc = r3_4_net_int_inc_y2_grs_inc;
		this.r3_5_net_non_int_inc_y2_grs_inc = r3_5_net_non_int_inc_y2_grs_inc;
		this.r3_6_grs_inc_y2_grs_inc = r3_6_grs_inc_y2_grs_inc;
		this.r3_7_net_int_inc_last_grs_inc = r3_7_net_int_inc_last_grs_inc;
		this.r3_8_net_non_int_inc_last_grs_inc = r3_8_net_non_int_inc_last_grs_inc;
		this.r3_9_grs_inc_last_grs_inc = r3_9_grs_inc_last_grs_inc;
		this.r3_1o_y3_loan_advs = r3_1o_y3_loan_advs;
		this.r3_11_y2_loan_advs = r3_11_y2_loan_advs;
		this.r3_12_last_loan_advs = r3_12_last_loan_advs;
		this.r3_13_m_fac_loan_advs = r3_13_m_fac_loan_advs;
		this.r3_14_3y_avg = r3_14_3y_avg;
		this.r3_15_beta_fac = r3_15_beta_fac;
		this.r3_16_cap_chrg_basel = r3_16_cap_chrg_basel;
		this.r3_16_cap_chrg_uae = r3_16_cap_chrg_uae;
		this.r4_product = r4_product;
		this.r4_1_net_int_inc_y3_grs_inc = r4_1_net_int_inc_y3_grs_inc;
		this.r4_2_net_non_int_inc_y3_grs_inc = r4_2_net_non_int_inc_y3_grs_inc;
		this.r4_3_grs_inc_y3_grs_inc = r4_3_grs_inc_y3_grs_inc;
		this.r4_4_net_int_inc_y2_grs_inc = r4_4_net_int_inc_y2_grs_inc;
		this.r4_5_net_non_int_inc_y2_grs_inc = r4_5_net_non_int_inc_y2_grs_inc;
		this.r4_6_grs_inc_y2_grs_inc = r4_6_grs_inc_y2_grs_inc;
		this.r4_7_net_int_inc_last_grs_inc = r4_7_net_int_inc_last_grs_inc;
		this.r4_8_net_non_int_inc_last_grs_inc = r4_8_net_non_int_inc_last_grs_inc;
		this.r4_9_grs_inc_last_grs_inc = r4_9_grs_inc_last_grs_inc;
		this.r4_1o_y3_loan_advs = r4_1o_y3_loan_advs;
		this.r4_11_y2_loan_advs = r4_11_y2_loan_advs;
		this.r4_12_last_loan_advs = r4_12_last_loan_advs;
		this.r4_13_m_fac_loan_advs = r4_13_m_fac_loan_advs;
		this.r4_14_3y_avg = r4_14_3y_avg;
		this.r4_15_beta_fac = r4_15_beta_fac;
		this.r4_16_cap_chrg_basel = r4_16_cap_chrg_basel;
		this.r4_16_cap_chrg_uae = r4_16_cap_chrg_uae;
		this.r5_product = r5_product;
		this.r5_1_net_int_inc_y3_grs_inc = r5_1_net_int_inc_y3_grs_inc;
		this.r5_2_net_non_int_inc_y3_grs_inc = r5_2_net_non_int_inc_y3_grs_inc;
		this.r5_3_grs_inc_y3_grs_inc = r5_3_grs_inc_y3_grs_inc;
		this.r5_4_net_int_inc_y2_grs_inc = r5_4_net_int_inc_y2_grs_inc;
		this.r5_5_net_non_int_inc_y2_grs_inc = r5_5_net_non_int_inc_y2_grs_inc;
		this.r5_6_grs_inc_y2_grs_inc = r5_6_grs_inc_y2_grs_inc;
		this.r5_7_net_int_inc_last_grs_inc = r5_7_net_int_inc_last_grs_inc;
		this.r5_8_net_non_int_inc_last_grs_inc = r5_8_net_non_int_inc_last_grs_inc;
		this.r5_9_grs_inc_last_grs_inc = r5_9_grs_inc_last_grs_inc;
		this.r5_1o_y3_loan_advs = r5_1o_y3_loan_advs;
		this.r5_11_y2_loan_advs = r5_11_y2_loan_advs;
		this.r5_12_last_loan_advs = r5_12_last_loan_advs;
		this.r5_13_m_fac_loan_advs = r5_13_m_fac_loan_advs;
		this.r5_14_3y_avg = r5_14_3y_avg;
		this.r5_15_beta_fac = r5_15_beta_fac;
		this.r5_16_cap_chrg_basel = r5_16_cap_chrg_basel;
		this.r5_16_cap_chrg_uae = r5_16_cap_chrg_uae;
		this.r6_product = r6_product;
		this.r6_1_net_int_inc_y3_grs_inc = r6_1_net_int_inc_y3_grs_inc;
		this.r6_2_net_non_int_inc_y3_grs_inc = r6_2_net_non_int_inc_y3_grs_inc;
		this.r6_3_grs_inc_y3_grs_inc = r6_3_grs_inc_y3_grs_inc;
		this.r6_4_net_int_inc_y2_grs_inc = r6_4_net_int_inc_y2_grs_inc;
		this.r6_5_net_non_int_inc_y2_grs_inc = r6_5_net_non_int_inc_y2_grs_inc;
		this.r6_6_grs_inc_y2_grs_inc = r6_6_grs_inc_y2_grs_inc;
		this.r6_7_net_int_inc_last_grs_inc = r6_7_net_int_inc_last_grs_inc;
		this.r6_8_net_non_int_inc_last_grs_inc = r6_8_net_non_int_inc_last_grs_inc;
		this.r6_9_grs_inc_last_grs_inc = r6_9_grs_inc_last_grs_inc;
		this.r6_1o_y3_loan_advs = r6_1o_y3_loan_advs;
		this.r6_11_y2_loan_advs = r6_11_y2_loan_advs;
		this.r6_12_last_loan_advs = r6_12_last_loan_advs;
		this.r6_13_m_fac_loan_advs = r6_13_m_fac_loan_advs;
		this.r6_14_3y_avg = r6_14_3y_avg;
		this.r6_15_beta_fac = r6_15_beta_fac;
		this.r6_16_cap_chrg_basel = r6_16_cap_chrg_basel;
		this.r6_16_cap_chrg_uae = r6_16_cap_chrg_uae;
		this.r7_product = r7_product;
		this.r7_1_net_int_inc_y3_grs_inc = r7_1_net_int_inc_y3_grs_inc;
		this.r7_2_net_non_int_inc_y3_grs_inc = r7_2_net_non_int_inc_y3_grs_inc;
		this.r7_3_grs_inc_y3_grs_inc = r7_3_grs_inc_y3_grs_inc;
		this.r7_4_net_int_inc_y2_grs_inc = r7_4_net_int_inc_y2_grs_inc;
		this.r7_5_net_non_int_inc_y2_grs_inc = r7_5_net_non_int_inc_y2_grs_inc;
		this.r7_6_grs_inc_y2_grs_inc = r7_6_grs_inc_y2_grs_inc;
		this.r7_7_net_int_inc_last_grs_inc = r7_7_net_int_inc_last_grs_inc;
		this.r7_8_net_non_int_inc_last_grs_inc = r7_8_net_non_int_inc_last_grs_inc;
		this.r7_9_grs_inc_last_grs_inc = r7_9_grs_inc_last_grs_inc;
		this.r7_1o_y3_loan_advs = r7_1o_y3_loan_advs;
		this.r7_11_y2_loan_advs = r7_11_y2_loan_advs;
		this.r7_12_last_loan_advs = r7_12_last_loan_advs;
		this.r7_13_m_fac_loan_advs = r7_13_m_fac_loan_advs;
		this.r7_14_3y_avg = r7_14_3y_avg;
		this.r7_15_beta_fac = r7_15_beta_fac;
		this.r7_16_cap_chrg_basel = r7_16_cap_chrg_basel;
		this.r7_16_cap_chrg_uae = r7_16_cap_chrg_uae;
		this.r8_product = r8_product;
		this.r8_1_net_int_inc_y3_grs_inc = r8_1_net_int_inc_y3_grs_inc;
		this.r8_2_net_non_int_inc_y3_grs_inc = r8_2_net_non_int_inc_y3_grs_inc;
		this.r8_3_grs_inc_y3_grs_inc = r8_3_grs_inc_y3_grs_inc;
		this.r8_4_net_int_inc_y2_grs_inc = r8_4_net_int_inc_y2_grs_inc;
		this.r8_5_net_non_int_inc_y2_grs_inc = r8_5_net_non_int_inc_y2_grs_inc;
		this.r8_6_grs_inc_y2_grs_inc = r8_6_grs_inc_y2_grs_inc;
		this.r8_7_net_int_inc_last_grs_inc = r8_7_net_int_inc_last_grs_inc;
		this.r8_8_net_non_int_inc_last_grs_inc = r8_8_net_non_int_inc_last_grs_inc;
		this.r8_9_grs_inc_last_grs_inc = r8_9_grs_inc_last_grs_inc;
		this.r8_1o_y3_loan_advs = r8_1o_y3_loan_advs;
		this.r8_11_y2_loan_advs = r8_11_y2_loan_advs;
		this.r8_12_last_loan_advs = r8_12_last_loan_advs;
		this.r8_13_m_fac_loan_advs = r8_13_m_fac_loan_advs;
		this.r8_14_3y_avg = r8_14_3y_avg;
		this.r8_15_beta_fac = r8_15_beta_fac;
		this.r8_16_cap_chrg_basel = r8_16_cap_chrg_basel;
		this.r8_16_cap_chrg_uae = r8_16_cap_chrg_uae;
		this.r9_product = r9_product;
		this.r9_1_net_int_inc_y3_grs_inc = r9_1_net_int_inc_y3_grs_inc;
		this.r9_2_net_non_int_inc_y3_grs_inc = r9_2_net_non_int_inc_y3_grs_inc;
		this.r9_3_grs_inc_y3_grs_inc = r9_3_grs_inc_y3_grs_inc;
		this.r9_4_net_int_inc_y2_grs_inc = r9_4_net_int_inc_y2_grs_inc;
		this.r9_5_net_non_int_inc_y2_grs_inc = r9_5_net_non_int_inc_y2_grs_inc;
		this.r9_6_grs_inc_y2_grs_inc = r9_6_grs_inc_y2_grs_inc;
		this.r9_7_net_int_inc_last_grs_inc = r9_7_net_int_inc_last_grs_inc;
		this.r9_8_net_non_int_inc_last_grs_inc = r9_8_net_non_int_inc_last_grs_inc;
		this.r9_9_grs_inc_last_grs_inc = r9_9_grs_inc_last_grs_inc;
		this.r9_1o_y3_loan_advs = r9_1o_y3_loan_advs;
		this.r9_11_y2_loan_advs = r9_11_y2_loan_advs;
		this.r9_12_last_loan_advs = r9_12_last_loan_advs;
		this.r9_13_m_fac_loan_advs = r9_13_m_fac_loan_advs;
		this.r9_14_3y_avg = r9_14_3y_avg;
		this.r9_15_beta_fac = r9_15_beta_fac;
		this.r9_16_cap_chrg_basel = r9_16_cap_chrg_basel;
		this.r9_16_cap_chrg_uae = r9_16_cap_chrg_uae;
		this.r10_product = r10_product;
		this.r10_1_net_int_inc_y3_grs_inc = r10_1_net_int_inc_y3_grs_inc;
		this.r10_2_net_non_int_inc_y3_grs_inc = r10_2_net_non_int_inc_y3_grs_inc;
		this.r10_3_grs_inc_y3_grs_inc = r10_3_grs_inc_y3_grs_inc;
		this.r10_4_net_int_inc_y2_grs_inc = r10_4_net_int_inc_y2_grs_inc;
		this.r10_5_net_non_int_inc_y2_grs_inc = r10_5_net_non_int_inc_y2_grs_inc;
		this.r10_6_grs_inc_y2_grs_inc = r10_6_grs_inc_y2_grs_inc;
		this.r10_7_net_int_inc_last_grs_inc = r10_7_net_int_inc_last_grs_inc;
		this.r10_8_net_non_int_inc_last_grs_inc = r10_8_net_non_int_inc_last_grs_inc;
		this.r10_9_grs_inc_last_grs_inc = r10_9_grs_inc_last_grs_inc;
		this.r10_1o_y3_loan_advs = r10_1o_y3_loan_advs;
		this.r10_11_y2_loan_advs = r10_11_y2_loan_advs;
		this.r10_12_last_loan_advs = r10_12_last_loan_advs;
		this.r10_13_m_fac_loan_advs = r10_13_m_fac_loan_advs;
		this.r10_14_3y_avg = r10_14_3y_avg;
		this.r10_15_beta_fac = r10_15_beta_fac;
		this.r10_16_cap_chrg_basel = r10_16_cap_chrg_basel;
		this.r10_16_cap_chrg_uae = r10_16_cap_chrg_uae;
		this.r11_product = r11_product;
		this.r11_1_net_int_inc_y3_grs_inc = r11_1_net_int_inc_y3_grs_inc;
		this.r11_2_net_non_int_inc_y3_grs_inc = r11_2_net_non_int_inc_y3_grs_inc;
		this.r11_3_grs_inc_y3_grs_inc = r11_3_grs_inc_y3_grs_inc;
		this.r11_4_net_int_inc_y2_grs_inc = r11_4_net_int_inc_y2_grs_inc;
		this.r11_5_net_non_int_inc_y2_grs_inc = r11_5_net_non_int_inc_y2_grs_inc;
		this.r11_6_grs_inc_y2_grs_inc = r11_6_grs_inc_y2_grs_inc;
		this.r11_7_net_int_inc_last_grs_inc = r11_7_net_int_inc_last_grs_inc;
		this.r11_8_net_non_int_inc_last_grs_inc = r11_8_net_non_int_inc_last_grs_inc;
		this.r11_9_grs_inc_last_grs_inc = r11_9_grs_inc_last_grs_inc;
		this.r11_1o_y3_loan_advs = r11_1o_y3_loan_advs;
		this.r11_11_y2_loan_advs = r11_11_y2_loan_advs;
		this.r11_12_last_loan_advs = r11_12_last_loan_advs;
		this.r11_13_m_fac_loan_advs = r11_13_m_fac_loan_advs;
		this.r11_14_3y_avg = r11_14_3y_avg;
		this.r11_15_beta_fac = r11_15_beta_fac;
		this.r11_16_cap_chrg_basel = r11_16_cap_chrg_basel;
		this.r11_16_cap_chrg_uae = r11_16_cap_chrg_uae;
		this.report_date = report_date;
		this.report_from_date = report_from_date;
		this.report_to_date = report_to_date;
		this.entity_flg = entity_flg;
		this.modify_flg = modify_flg;
		this.del_flg = del_flg;
		this.report_code = report_code;
	}
	public BASEL_OPRISK_OR1() {
		super();
		// TODO Auto-generated constructor stub
	}

}
