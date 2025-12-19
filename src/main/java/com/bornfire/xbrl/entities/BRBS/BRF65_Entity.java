package com.bornfire.xbrl.entities.BRBS;

import java.math.BigDecimal;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "BRF65_SUMMARYTABLE")
public class BRF65_Entity {
	@Id
	private Date report_date;
	private String r1_product;
	private BigDecimal r1_rescheduled_amt;
	private BigDecimal r1_rescheduled_once;
	private BigDecimal r1_rescheduled_twice;
	private BigDecimal r1_rescheduled_more_than_twice;
	private BigDecimal r1_principal_regularly_amortized_period;
	private BigDecimal r1_repayment_after_grace_period_exceed_oneyr;
	private BigDecimal r1_bullet_repayment;
	private BigDecimal r1_interest_profit_overdue_pl;
	private BigDecimal r1_interest_profit_overdue_intsus;
	private BigDecimal r1_specific_provisions;
	private String s1_product;
	private BigDecimal s1_rescheduled_amt;
	private BigDecimal s1_rescheduled_once;
	private BigDecimal s1_rescheduled_twice;
	private BigDecimal s1_rescheduled_more_than_twice;
	private BigDecimal s1_principal_regularly_amortized_period;
	private BigDecimal s1_repayment_after_grace_period_exceed_oneyr;
	private BigDecimal s1_bullet_repayment;
	private BigDecimal s1_interest_profit_overdue_pl;
	private BigDecimal s1_interest_profit_overdue_intsus;
	private BigDecimal s1_specific_provisions;
	private String s2_product;
	private BigDecimal s2_rescheduled_amt;
	private BigDecimal s2_rescheduled_once;
	private BigDecimal s2_rescheduled_twice;
	private BigDecimal s2_rescheduled_more_than_twice;
	private BigDecimal s2_principal_regularly_amortized_period;
	private BigDecimal s2_repayment_after_grace_period_exceed_oneyr;
	private BigDecimal s2_bullet_repayment;
	private BigDecimal s2_interest_profit_overdue_pl;
	private BigDecimal s2_interest_profit_overdue_intsus;
	private BigDecimal s2_specific_provisions;
	private String s3_product;
	private BigDecimal s3_rescheduled_amt;
	private BigDecimal s3_rescheduled_once;
	private BigDecimal s3_rescheduled_twice;
	private BigDecimal s3_rescheduled_more_than_twice;
	private BigDecimal s3_principal_regularly_amortized_period;
	private BigDecimal s3_repayment_after_grace_period_exceed_oneyr;
	private BigDecimal s3_bullet_repayment;
	private BigDecimal s3_interest_profit_overdue_pl;
	private BigDecimal s3_interest_profit_overdue_intsus;
	private BigDecimal s3_specific_provisions;
	private String s4_product;
	private BigDecimal s4_rescheduled_amt;
	private BigDecimal s4_rescheduled_once;
	private BigDecimal s4_rescheduled_twice;
	private BigDecimal s4_rescheduled_more_than_twice;
	private BigDecimal s4_principal_regularly_amortized_period;
	private BigDecimal s4_repayment_after_grace_period_exceed_oneyr;
	private BigDecimal s4_bullet_repayment;
	private BigDecimal s4_interest_profit_overdue_pl;
	private BigDecimal s4_interest_profit_overdue_intsus;
	private BigDecimal s4_specific_provisions;
	private String t1_product;
	private BigDecimal t1_rescheduled_amt;
	private BigDecimal t1_rescheduled_once;
	private BigDecimal t1_rescheduled_twice;
	private BigDecimal t1_rescheduled_more_than_twice;
	private BigDecimal t1_principal_regularly_amortized_period;
	private BigDecimal t1_repayment_after_grace_period_exceed_oneyr;
	private BigDecimal t1_bullet_repayment;
	private BigDecimal t1_interest_profit_overdue_pl;
	private BigDecimal t1_interest_profit_overdue_intsus;
	private BigDecimal t1_specific_provisions;
	private String t2_product;
	private BigDecimal t2_rescheduled_amt;
	private BigDecimal t2_rescheduled_once;
	private BigDecimal t2_rescheduled_twice;
	private BigDecimal t2_rescheduled_more_than_twice;
	private BigDecimal t2_principal_regularly_amortized_period;
	private BigDecimal t2_repayment_after_grace_period_exceed_oneyr;
	private BigDecimal t2_bullet_repayment;
	private BigDecimal t2_interest_profit_overdue_pl;
	private BigDecimal t2_interest_profit_overdue_intsus;
	private BigDecimal t2_specific_provisions;
	private String t3_product;
	private BigDecimal t3_rescheduled_amt;
	private BigDecimal t3_rescheduled_once;
	private BigDecimal t3_rescheduled_twice;
	private BigDecimal t3_rescheduled_more_than_twice;
	private BigDecimal t3_principal_regularly_amortized_period;
	private BigDecimal t3_repayment_after_grace_period_exceed_oneyr;
	private BigDecimal t3_bullet_repayment;
	private BigDecimal t3_interest_profit_overdue_pl;
	private BigDecimal t3_interest_profit_overdue_intsus;
	private BigDecimal t3_specific_provisions;
	private String t4_product;
	private BigDecimal t4_rescheduled_amt;
	private BigDecimal t4_rescheduled_once;
	private BigDecimal t4_rescheduled_twice;
	private BigDecimal t4_rescheduled_more_than_twice;
	private BigDecimal t4_principal_regularly_amortized_period;
	private BigDecimal t4_repayment_after_grace_period_exceed_oneyr;
	private BigDecimal t4_bullet_repayment;
	private BigDecimal t4_interest_profit_overdue_pl;
	private BigDecimal t4_interest_profit_overdue_intsus;
	private BigDecimal t4_specific_provisions;
	private String t5_product;
	private BigDecimal t5_rescheduled_amt;
	private BigDecimal t5_rescheduled_once;
	private BigDecimal t5_rescheduled_twice;
	private BigDecimal t5_rescheduled_more_than_twice;
	private BigDecimal t5_principal_regularly_amortized_period;
	private BigDecimal t5_repayment_after_grace_period_exceed_oneyr;
	private BigDecimal t5_bullet_repayment;
	private BigDecimal t5_interest_profit_overdue_pl;
	private BigDecimal t5_interest_profit_overdue_intsus;
	private BigDecimal t5_specific_provisions;
	private String v1_product;
	private BigDecimal v1_rescheduled_amt;
	private BigDecimal v1_rescheduled_once;
	private BigDecimal v1_rescheduled_twice;
	private BigDecimal v1_rescheduled_more_than_twice;
	private BigDecimal v1_principal_regularly_amortized_period;
	private BigDecimal v1_repayment_after_grace_period_exceed_oneyr;
	private BigDecimal v1_bullet_repayment;
	private BigDecimal v1_interest_profit_overdue_pl;
	private BigDecimal v1_interest_profit_overdue_intsus;
	private BigDecimal v1_specific_provisions;
	private String v2_product;
	private BigDecimal v2_rescheduled_amt;
	private BigDecimal v2_rescheduled_once;
	private BigDecimal v2_rescheduled_twice;
	private BigDecimal v2_rescheduled_more_than_twice;
	private BigDecimal v2_principal_regularly_amortized_period;
	private BigDecimal v2_repayment_after_grace_period_exceed_oneyr;
	private BigDecimal v2_bullet_repayment;
	private BigDecimal v2_interest_profit_overdue_pl;
	private BigDecimal v2_interest_profit_overdue_intsus;
	private BigDecimal v2_specific_provisions;
	private String v3_product;
	private BigDecimal v3_rescheduled_amt;
	private BigDecimal v3_rescheduled_once;
	private BigDecimal v3_rescheduled_twice;
	private BigDecimal v3_rescheduled_more_than_twice;
	private BigDecimal v3_principal_regularly_amortized_period;
	private BigDecimal v3_repayment_after_grace_period_exceed_oneyr;
	private BigDecimal v3_bullet_repayment;
	private BigDecimal v3_interest_profit_overdue_pl;
	private BigDecimal v3_interest_profit_overdue_intsus;
	private BigDecimal v3_specific_provisions;
	private String v4_product;
	private BigDecimal v4_rescheduled_amt;
	private BigDecimal v4_rescheduled_once;
	private BigDecimal v4_rescheduled_twice;
	private BigDecimal v4_rescheduled_more_than_twice;
	private BigDecimal v4_principal_regularly_amortized_period;
	private BigDecimal v4_repayment_after_grace_period_exceed_oneyr;
	private BigDecimal v4_bullet_repayment;
	private BigDecimal v4_interest_profit_overdue_pl;
	private BigDecimal v4_interest_profit_overdue_intsus;
	private BigDecimal v4_specific_provisions;
	private String v5_product;
	private BigDecimal v5_rescheduled_amt;
	private BigDecimal v5_rescheduled_once;
	private BigDecimal v5_rescheduled_twice;
	private BigDecimal v5_rescheduled_more_than_twice;
	private BigDecimal v5_principal_regularly_amortized_period;
	private BigDecimal v5_repayment_after_grace_period_exceed_oneyr;
	private BigDecimal v5_bullet_repayment;
	private BigDecimal v5_interest_profit_overdue_pl;
	private BigDecimal v5_interest_profit_overdue_intsus;
	private BigDecimal v5_specific_provisions;
	private String v6_product;
	private BigDecimal v6_rescheduled_amt;
	private BigDecimal v6_rescheduled_once;
	private BigDecimal v6_rescheduled_twice;
	private BigDecimal v6_rescheduled_more_than_twice;
	private BigDecimal v6_principal_regularly_amortized_period;
	private BigDecimal v6_repayment_after_grace_period_exceed_oneyr;
	private BigDecimal v6_bullet_repayment;
	private BigDecimal v6_interest_profit_overdue_pl;
	private BigDecimal v6_interest_profit_overdue_intsus;
	private BigDecimal v6_specific_provisions;
	private String v7_product;
	private BigDecimal v7_rescheduled_amt;
	private BigDecimal v7_rescheduled_once;
	private BigDecimal v7_rescheduled_twice;
	private BigDecimal v7_rescheduled_more_than_twice;
	private BigDecimal v7_principal_regularly_amortized_period;
	private BigDecimal v7_repayment_after_grace_period_exceed_oneyr;
	private BigDecimal v7_bullet_repayment;
	private BigDecimal v7_interest_profit_overdue_pl;
	private BigDecimal v7_interest_profit_overdue_intsus;
	private BigDecimal v7_specific_provisions;
	private String w1_product;
	private BigDecimal w1_rescheduled_amt;
	private BigDecimal w1_rescheduled_once;
	private BigDecimal w1_rescheduled_twice;
	private BigDecimal w1_rescheduled_more_than_twice;
	private BigDecimal w1_principal_regularly_amortized_period;
	private BigDecimal w1_repayment_after_grace_period_exceed_oneyr;
	private BigDecimal w1_bullet_repayment;
	private BigDecimal w1_interest_profit_overdue_pl;
	private BigDecimal w1_interest_profit_overdue_intsus;
	private BigDecimal w1_specific_provisions;
	private String x1_product;
	private BigDecimal x1_rescheduled_amt;
	private BigDecimal x1_rescheduled_once;
	private BigDecimal x1_rescheduled_twice;
	private BigDecimal x1_rescheduled_more_than_twice;
	private BigDecimal x1_principal_regularly_amortized_period;
	private BigDecimal x1_repayment_after_grace_period_exceed_oneyr;
	private BigDecimal x1_bullet_repayment;
	private BigDecimal x1_interest_profit_overdue_pl;
	private BigDecimal x1_interest_profit_overdue_intsus;
	private BigDecimal x1_specific_provisions;
	private Date report_from_date;
	private Date report_to_date;
	private String entity_flg;
	private String modify_flg;
	private String del_flg;
	private String report_code;
	private Date report_submit_date;
	private String repdesc;
	private String frequency;

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

	public BigDecimal getR1_rescheduled_amt() {
		return r1_rescheduled_amt;
	}

	public void setR1_rescheduled_amt(BigDecimal r1_rescheduled_amt) {
		this.r1_rescheduled_amt = r1_rescheduled_amt;
	}

	public BigDecimal getR1_rescheduled_once() {
		return r1_rescheduled_once;
	}

	public void setR1_rescheduled_once(BigDecimal r1_rescheduled_once) {
		this.r1_rescheduled_once = r1_rescheduled_once;
	}

	public BigDecimal getR1_rescheduled_twice() {
		return r1_rescheduled_twice;
	}

	public void setR1_rescheduled_twice(BigDecimal r1_rescheduled_twice) {
		this.r1_rescheduled_twice = r1_rescheduled_twice;
	}

	public BigDecimal getR1_rescheduled_more_than_twice() {
		return r1_rescheduled_more_than_twice;
	}

	public void setR1_rescheduled_more_than_twice(BigDecimal r1_rescheduled_more_than_twice) {
		this.r1_rescheduled_more_than_twice = r1_rescheduled_more_than_twice;
	}

	public BigDecimal getR1_principal_regularly_amortized_period() {
		return r1_principal_regularly_amortized_period;
	}

	public void setR1_principal_regularly_amortized_period(BigDecimal r1_principal_regularly_amortized_period) {
		this.r1_principal_regularly_amortized_period = r1_principal_regularly_amortized_period;
	}

	public BigDecimal getR1_repayment_after_grace_period_exceed_oneyr() {
		return r1_repayment_after_grace_period_exceed_oneyr;
	}

	public void setR1_repayment_after_grace_period_exceed_oneyr(
			BigDecimal r1_repayment_after_grace_period_exceed_oneyr) {
		this.r1_repayment_after_grace_period_exceed_oneyr = r1_repayment_after_grace_period_exceed_oneyr;
	}

	public BigDecimal getR1_bullet_repayment() {
		return r1_bullet_repayment;
	}

	public void setR1_bullet_repayment(BigDecimal r1_bullet_repayment) {
		this.r1_bullet_repayment = r1_bullet_repayment;
	}

	public BigDecimal getR1_interest_profit_overdue_pl() {
		return r1_interest_profit_overdue_pl;
	}

	public void setR1_interest_profit_overdue_pl(BigDecimal r1_interest_profit_overdue_pl) {
		this.r1_interest_profit_overdue_pl = r1_interest_profit_overdue_pl;
	}

	public BigDecimal getR1_interest_profit_overdue_intsus() {
		return r1_interest_profit_overdue_intsus;
	}

	public void setR1_interest_profit_overdue_intsus(BigDecimal r1_interest_profit_overdue_intsus) {
		this.r1_interest_profit_overdue_intsus = r1_interest_profit_overdue_intsus;
	}

	public BigDecimal getR1_specific_provisions() {
		return r1_specific_provisions;
	}

	public void setR1_specific_provisions(BigDecimal r1_specific_provisions) {
		this.r1_specific_provisions = r1_specific_provisions;
	}

	public String getS1_product() {
		return s1_product;
	}

	public void setS1_product(String s1_product) {
		this.s1_product = s1_product;
	}

	public BigDecimal getS1_rescheduled_amt() {
		return s1_rescheduled_amt;
	}

	public void setS1_rescheduled_amt(BigDecimal s1_rescheduled_amt) {
		this.s1_rescheduled_amt = s1_rescheduled_amt;
	}

	public BigDecimal getS1_rescheduled_once() {
		return s1_rescheduled_once;
	}

	public void setS1_rescheduled_once(BigDecimal s1_rescheduled_once) {
		this.s1_rescheduled_once = s1_rescheduled_once;
	}

	public BigDecimal getS1_rescheduled_twice() {
		return s1_rescheduled_twice;
	}

	public void setS1_rescheduled_twice(BigDecimal s1_rescheduled_twice) {
		this.s1_rescheduled_twice = s1_rescheduled_twice;
	}

	public BigDecimal getS1_rescheduled_more_than_twice() {
		return s1_rescheduled_more_than_twice;
	}

	public void setS1_rescheduled_more_than_twice(BigDecimal s1_rescheduled_more_than_twice) {
		this.s1_rescheduled_more_than_twice = s1_rescheduled_more_than_twice;
	}

	public BigDecimal getS1_principal_regularly_amortized_period() {
		return s1_principal_regularly_amortized_period;
	}

	public void setS1_principal_regularly_amortized_period(BigDecimal s1_principal_regularly_amortized_period) {
		this.s1_principal_regularly_amortized_period = s1_principal_regularly_amortized_period;
	}

	public BigDecimal getS1_repayment_after_grace_period_exceed_oneyr() {
		return s1_repayment_after_grace_period_exceed_oneyr;
	}

	public void setS1_repayment_after_grace_period_exceed_oneyr(
			BigDecimal s1_repayment_after_grace_period_exceed_oneyr) {
		this.s1_repayment_after_grace_period_exceed_oneyr = s1_repayment_after_grace_period_exceed_oneyr;
	}

	public BigDecimal getS1_bullet_repayment() {
		return s1_bullet_repayment;
	}

	public void setS1_bullet_repayment(BigDecimal s1_bullet_repayment) {
		this.s1_bullet_repayment = s1_bullet_repayment;
	}

	public BigDecimal getS1_interest_profit_overdue_pl() {
		return s1_interest_profit_overdue_pl;
	}

	public void setS1_interest_profit_overdue_pl(BigDecimal s1_interest_profit_overdue_pl) {
		this.s1_interest_profit_overdue_pl = s1_interest_profit_overdue_pl;
	}

	public BigDecimal getS1_interest_profit_overdue_intsus() {
		return s1_interest_profit_overdue_intsus;
	}

	public void setS1_interest_profit_overdue_intsus(BigDecimal s1_interest_profit_overdue_intsus) {
		this.s1_interest_profit_overdue_intsus = s1_interest_profit_overdue_intsus;
	}

	public BigDecimal getS1_specific_provisions() {
		return s1_specific_provisions;
	}

	public void setS1_specific_provisions(BigDecimal s1_specific_provisions) {
		this.s1_specific_provisions = s1_specific_provisions;
	}

	public String getS2_product() {
		return s2_product;
	}

	public void setS2_product(String s2_product) {
		this.s2_product = s2_product;
	}

	public BigDecimal getS2_rescheduled_amt() {
		return s2_rescheduled_amt;
	}

	public void setS2_rescheduled_amt(BigDecimal s2_rescheduled_amt) {
		this.s2_rescheduled_amt = s2_rescheduled_amt;
	}

	public BigDecimal getS2_rescheduled_once() {
		return s2_rescheduled_once;
	}

	public void setS2_rescheduled_once(BigDecimal s2_rescheduled_once) {
		this.s2_rescheduled_once = s2_rescheduled_once;
	}

	public BigDecimal getS2_rescheduled_twice() {
		return s2_rescheduled_twice;
	}

	public void setS2_rescheduled_twice(BigDecimal s2_rescheduled_twice) {
		this.s2_rescheduled_twice = s2_rescheduled_twice;
	}

	public BigDecimal getS2_rescheduled_more_than_twice() {
		return s2_rescheduled_more_than_twice;
	}

	public void setS2_rescheduled_more_than_twice(BigDecimal s2_rescheduled_more_than_twice) {
		this.s2_rescheduled_more_than_twice = s2_rescheduled_more_than_twice;
	}

	public BigDecimal getS2_principal_regularly_amortized_period() {
		return s2_principal_regularly_amortized_period;
	}

	public void setS2_principal_regularly_amortized_period(BigDecimal s2_principal_regularly_amortized_period) {
		this.s2_principal_regularly_amortized_period = s2_principal_regularly_amortized_period;
	}

	public BigDecimal getS2_repayment_after_grace_period_exceed_oneyr() {
		return s2_repayment_after_grace_period_exceed_oneyr;
	}

	public void setS2_repayment_after_grace_period_exceed_oneyr(
			BigDecimal s2_repayment_after_grace_period_exceed_oneyr) {
		this.s2_repayment_after_grace_period_exceed_oneyr = s2_repayment_after_grace_period_exceed_oneyr;
	}

	public BigDecimal getS2_bullet_repayment() {
		return s2_bullet_repayment;
	}

	public void setS2_bullet_repayment(BigDecimal s2_bullet_repayment) {
		this.s2_bullet_repayment = s2_bullet_repayment;
	}

	public BigDecimal getS2_interest_profit_overdue_pl() {
		return s2_interest_profit_overdue_pl;
	}

	public void setS2_interest_profit_overdue_pl(BigDecimal s2_interest_profit_overdue_pl) {
		this.s2_interest_profit_overdue_pl = s2_interest_profit_overdue_pl;
	}

	public BigDecimal getS2_interest_profit_overdue_intsus() {
		return s2_interest_profit_overdue_intsus;
	}

	public void setS2_interest_profit_overdue_intsus(BigDecimal s2_interest_profit_overdue_intsus) {
		this.s2_interest_profit_overdue_intsus = s2_interest_profit_overdue_intsus;
	}

	public BigDecimal getS2_specific_provisions() {
		return s2_specific_provisions;
	}

	public void setS2_specific_provisions(BigDecimal s2_specific_provisions) {
		this.s2_specific_provisions = s2_specific_provisions;
	}

	public String getS3_product() {
		return s3_product;
	}

	public void setS3_product(String s3_product) {
		this.s3_product = s3_product;
	}

	public BigDecimal getS3_rescheduled_amt() {
		return s3_rescheduled_amt;
	}

	public void setS3_rescheduled_amt(BigDecimal s3_rescheduled_amt) {
		this.s3_rescheduled_amt = s3_rescheduled_amt;
	}

	public BigDecimal getS3_rescheduled_once() {
		return s3_rescheduled_once;
	}

	public void setS3_rescheduled_once(BigDecimal s3_rescheduled_once) {
		this.s3_rescheduled_once = s3_rescheduled_once;
	}

	public BigDecimal getS3_rescheduled_twice() {
		return s3_rescheduled_twice;
	}

	public void setS3_rescheduled_twice(BigDecimal s3_rescheduled_twice) {
		this.s3_rescheduled_twice = s3_rescheduled_twice;
	}

	public BigDecimal getS3_rescheduled_more_than_twice() {
		return s3_rescheduled_more_than_twice;
	}

	public void setS3_rescheduled_more_than_twice(BigDecimal s3_rescheduled_more_than_twice) {
		this.s3_rescheduled_more_than_twice = s3_rescheduled_more_than_twice;
	}

	public BigDecimal getS3_principal_regularly_amortized_period() {
		return s3_principal_regularly_amortized_period;
	}

	public void setS3_principal_regularly_amortized_period(BigDecimal s3_principal_regularly_amortized_period) {
		this.s3_principal_regularly_amortized_period = s3_principal_regularly_amortized_period;
	}

	public BigDecimal getS3_repayment_after_grace_period_exceed_oneyr() {
		return s3_repayment_after_grace_period_exceed_oneyr;
	}

	public void setS3_repayment_after_grace_period_exceed_oneyr(
			BigDecimal s3_repayment_after_grace_period_exceed_oneyr) {
		this.s3_repayment_after_grace_period_exceed_oneyr = s3_repayment_after_grace_period_exceed_oneyr;
	}

	public BigDecimal getS3_bullet_repayment() {
		return s3_bullet_repayment;
	}

	public void setS3_bullet_repayment(BigDecimal s3_bullet_repayment) {
		this.s3_bullet_repayment = s3_bullet_repayment;
	}

	public BigDecimal getS3_interest_profit_overdue_pl() {
		return s3_interest_profit_overdue_pl;
	}

	public void setS3_interest_profit_overdue_pl(BigDecimal s3_interest_profit_overdue_pl) {
		this.s3_interest_profit_overdue_pl = s3_interest_profit_overdue_pl;
	}

	public BigDecimal getS3_interest_profit_overdue_intsus() {
		return s3_interest_profit_overdue_intsus;
	}

	public void setS3_interest_profit_overdue_intsus(BigDecimal s3_interest_profit_overdue_intsus) {
		this.s3_interest_profit_overdue_intsus = s3_interest_profit_overdue_intsus;
	}

	public BigDecimal getS3_specific_provisions() {
		return s3_specific_provisions;
	}

	public void setS3_specific_provisions(BigDecimal s3_specific_provisions) {
		this.s3_specific_provisions = s3_specific_provisions;
	}

	public String getS4_product() {
		return s4_product;
	}

	public void setS4_product(String s4_product) {
		this.s4_product = s4_product;
	}

	public BigDecimal getS4_rescheduled_amt() {
		return s4_rescheduled_amt;
	}

	public void setS4_rescheduled_amt(BigDecimal s4_rescheduled_amt) {
		this.s4_rescheduled_amt = s4_rescheduled_amt;
	}

	public BigDecimal getS4_rescheduled_once() {
		return s4_rescheduled_once;
	}

	public void setS4_rescheduled_once(BigDecimal s4_rescheduled_once) {
		this.s4_rescheduled_once = s4_rescheduled_once;
	}

	public BigDecimal getS4_rescheduled_twice() {
		return s4_rescheduled_twice;
	}

	public void setS4_rescheduled_twice(BigDecimal s4_rescheduled_twice) {
		this.s4_rescheduled_twice = s4_rescheduled_twice;
	}

	public BigDecimal getS4_rescheduled_more_than_twice() {
		return s4_rescheduled_more_than_twice;
	}

	public void setS4_rescheduled_more_than_twice(BigDecimal s4_rescheduled_more_than_twice) {
		this.s4_rescheduled_more_than_twice = s4_rescheduled_more_than_twice;
	}

	public BigDecimal getS4_principal_regularly_amortized_period() {
		return s4_principal_regularly_amortized_period;
	}

	public void setS4_principal_regularly_amortized_period(BigDecimal s4_principal_regularly_amortized_period) {
		this.s4_principal_regularly_amortized_period = s4_principal_regularly_amortized_period;
	}

	public BigDecimal getS4_repayment_after_grace_period_exceed_oneyr() {
		return s4_repayment_after_grace_period_exceed_oneyr;
	}

	public void setS4_repayment_after_grace_period_exceed_oneyr(
			BigDecimal s4_repayment_after_grace_period_exceed_oneyr) {
		this.s4_repayment_after_grace_period_exceed_oneyr = s4_repayment_after_grace_period_exceed_oneyr;
	}

	public BigDecimal getS4_bullet_repayment() {
		return s4_bullet_repayment;
	}

	public void setS4_bullet_repayment(BigDecimal s4_bullet_repayment) {
		this.s4_bullet_repayment = s4_bullet_repayment;
	}

	public BigDecimal getS4_interest_profit_overdue_pl() {
		return s4_interest_profit_overdue_pl;
	}

	public void setS4_interest_profit_overdue_pl(BigDecimal s4_interest_profit_overdue_pl) {
		this.s4_interest_profit_overdue_pl = s4_interest_profit_overdue_pl;
	}

	public BigDecimal getS4_interest_profit_overdue_intsus() {
		return s4_interest_profit_overdue_intsus;
	}

	public void setS4_interest_profit_overdue_intsus(BigDecimal s4_interest_profit_overdue_intsus) {
		this.s4_interest_profit_overdue_intsus = s4_interest_profit_overdue_intsus;
	}

	public BigDecimal getS4_specific_provisions() {
		return s4_specific_provisions;
	}

	public void setS4_specific_provisions(BigDecimal s4_specific_provisions) {
		this.s4_specific_provisions = s4_specific_provisions;
	}

	public String getT1_product() {
		return t1_product;
	}

	public void setT1_product(String t1_product) {
		this.t1_product = t1_product;
	}

	public BigDecimal getT1_rescheduled_amt() {
		return t1_rescheduled_amt;
	}

	public void setT1_rescheduled_amt(BigDecimal t1_rescheduled_amt) {
		this.t1_rescheduled_amt = t1_rescheduled_amt;
	}

	public BigDecimal getT1_rescheduled_once() {
		return t1_rescheduled_once;
	}

	public void setT1_rescheduled_once(BigDecimal t1_rescheduled_once) {
		this.t1_rescheduled_once = t1_rescheduled_once;
	}

	public BigDecimal getT1_rescheduled_twice() {
		return t1_rescheduled_twice;
	}

	public void setT1_rescheduled_twice(BigDecimal t1_rescheduled_twice) {
		this.t1_rescheduled_twice = t1_rescheduled_twice;
	}

	public BigDecimal getT1_rescheduled_more_than_twice() {
		return t1_rescheduled_more_than_twice;
	}

	public void setT1_rescheduled_more_than_twice(BigDecimal t1_rescheduled_more_than_twice) {
		this.t1_rescheduled_more_than_twice = t1_rescheduled_more_than_twice;
	}

	public BigDecimal getT1_principal_regularly_amortized_period() {
		return t1_principal_regularly_amortized_period;
	}

	public void setT1_principal_regularly_amortized_period(BigDecimal t1_principal_regularly_amortized_period) {
		this.t1_principal_regularly_amortized_period = t1_principal_regularly_amortized_period;
	}

	public BigDecimal getT1_repayment_after_grace_period_exceed_oneyr() {
		return t1_repayment_after_grace_period_exceed_oneyr;
	}

	public void setT1_repayment_after_grace_period_exceed_oneyr(
			BigDecimal t1_repayment_after_grace_period_exceed_oneyr) {
		this.t1_repayment_after_grace_period_exceed_oneyr = t1_repayment_after_grace_period_exceed_oneyr;
	}

	public BigDecimal getT1_bullet_repayment() {
		return t1_bullet_repayment;
	}

	public void setT1_bullet_repayment(BigDecimal t1_bullet_repayment) {
		this.t1_bullet_repayment = t1_bullet_repayment;
	}

	public BigDecimal getT1_interest_profit_overdue_pl() {
		return t1_interest_profit_overdue_pl;
	}

	public void setT1_interest_profit_overdue_pl(BigDecimal t1_interest_profit_overdue_pl) {
		this.t1_interest_profit_overdue_pl = t1_interest_profit_overdue_pl;
	}

	public BigDecimal getT1_interest_profit_overdue_intsus() {
		return t1_interest_profit_overdue_intsus;
	}

	public void setT1_interest_profit_overdue_intsus(BigDecimal t1_interest_profit_overdue_intsus) {
		this.t1_interest_profit_overdue_intsus = t1_interest_profit_overdue_intsus;
	}

	public BigDecimal getT1_specific_provisions() {
		return t1_specific_provisions;
	}

	public void setT1_specific_provisions(BigDecimal t1_specific_provisions) {
		this.t1_specific_provisions = t1_specific_provisions;
	}

	public String getT2_product() {
		return t2_product;
	}

	public void setT2_product(String t2_product) {
		this.t2_product = t2_product;
	}

	public BigDecimal getT2_rescheduled_amt() {
		return t2_rescheduled_amt;
	}

	public void setT2_rescheduled_amt(BigDecimal t2_rescheduled_amt) {
		this.t2_rescheduled_amt = t2_rescheduled_amt;
	}

	public BigDecimal getT2_rescheduled_once() {
		return t2_rescheduled_once;
	}

	public void setT2_rescheduled_once(BigDecimal t2_rescheduled_once) {
		this.t2_rescheduled_once = t2_rescheduled_once;
	}

	public BigDecimal getT2_rescheduled_twice() {
		return t2_rescheduled_twice;
	}

	public void setT2_rescheduled_twice(BigDecimal t2_rescheduled_twice) {
		this.t2_rescheduled_twice = t2_rescheduled_twice;
	}

	public BigDecimal getT2_rescheduled_more_than_twice() {
		return t2_rescheduled_more_than_twice;
	}

	public void setT2_rescheduled_more_than_twice(BigDecimal t2_rescheduled_more_than_twice) {
		this.t2_rescheduled_more_than_twice = t2_rescheduled_more_than_twice;
	}

	public BigDecimal getT2_principal_regularly_amortized_period() {
		return t2_principal_regularly_amortized_period;
	}

	public void setT2_principal_regularly_amortized_period(BigDecimal t2_principal_regularly_amortized_period) {
		this.t2_principal_regularly_amortized_period = t2_principal_regularly_amortized_period;
	}

	public BigDecimal getT2_repayment_after_grace_period_exceed_oneyr() {
		return t2_repayment_after_grace_period_exceed_oneyr;
	}

	public void setT2_repayment_after_grace_period_exceed_oneyr(
			BigDecimal t2_repayment_after_grace_period_exceed_oneyr) {
		this.t2_repayment_after_grace_period_exceed_oneyr = t2_repayment_after_grace_period_exceed_oneyr;
	}

	public BigDecimal getT2_bullet_repayment() {
		return t2_bullet_repayment;
	}

	public void setT2_bullet_repayment(BigDecimal t2_bullet_repayment) {
		this.t2_bullet_repayment = t2_bullet_repayment;
	}

	public BigDecimal getT2_interest_profit_overdue_pl() {
		return t2_interest_profit_overdue_pl;
	}

	public void setT2_interest_profit_overdue_pl(BigDecimal t2_interest_profit_overdue_pl) {
		this.t2_interest_profit_overdue_pl = t2_interest_profit_overdue_pl;
	}

	public BigDecimal getT2_interest_profit_overdue_intsus() {
		return t2_interest_profit_overdue_intsus;
	}

	public void setT2_interest_profit_overdue_intsus(BigDecimal t2_interest_profit_overdue_intsus) {
		this.t2_interest_profit_overdue_intsus = t2_interest_profit_overdue_intsus;
	}

	public BigDecimal getT2_specific_provisions() {
		return t2_specific_provisions;
	}

	public void setT2_specific_provisions(BigDecimal t2_specific_provisions) {
		this.t2_specific_provisions = t2_specific_provisions;
	}

	public String getT3_product() {
		return t3_product;
	}

	public void setT3_product(String t3_product) {
		this.t3_product = t3_product;
	}

	public BigDecimal getT3_rescheduled_amt() {
		return t3_rescheduled_amt;
	}

	public void setT3_rescheduled_amt(BigDecimal t3_rescheduled_amt) {
		this.t3_rescheduled_amt = t3_rescheduled_amt;
	}

	public BigDecimal getT3_rescheduled_once() {
		return t3_rescheduled_once;
	}

	public void setT3_rescheduled_once(BigDecimal t3_rescheduled_once) {
		this.t3_rescheduled_once = t3_rescheduled_once;
	}

	public BigDecimal getT3_rescheduled_twice() {
		return t3_rescheduled_twice;
	}

	public void setT3_rescheduled_twice(BigDecimal t3_rescheduled_twice) {
		this.t3_rescheduled_twice = t3_rescheduled_twice;
	}

	public BigDecimal getT3_rescheduled_more_than_twice() {
		return t3_rescheduled_more_than_twice;
	}

	public void setT3_rescheduled_more_than_twice(BigDecimal t3_rescheduled_more_than_twice) {
		this.t3_rescheduled_more_than_twice = t3_rescheduled_more_than_twice;
	}

	public BigDecimal getT3_principal_regularly_amortized_period() {
		return t3_principal_regularly_amortized_period;
	}

	public void setT3_principal_regularly_amortized_period(BigDecimal t3_principal_regularly_amortized_period) {
		this.t3_principal_regularly_amortized_period = t3_principal_regularly_amortized_period;
	}

	public BigDecimal getT3_repayment_after_grace_period_exceed_oneyr() {
		return t3_repayment_after_grace_period_exceed_oneyr;
	}

	public void setT3_repayment_after_grace_period_exceed_oneyr(
			BigDecimal t3_repayment_after_grace_period_exceed_oneyr) {
		this.t3_repayment_after_grace_period_exceed_oneyr = t3_repayment_after_grace_period_exceed_oneyr;
	}

	public BigDecimal getT3_bullet_repayment() {
		return t3_bullet_repayment;
	}

	public void setT3_bullet_repayment(BigDecimal t3_bullet_repayment) {
		this.t3_bullet_repayment = t3_bullet_repayment;
	}

	public BigDecimal getT3_interest_profit_overdue_pl() {
		return t3_interest_profit_overdue_pl;
	}

	public void setT3_interest_profit_overdue_pl(BigDecimal t3_interest_profit_overdue_pl) {
		this.t3_interest_profit_overdue_pl = t3_interest_profit_overdue_pl;
	}

	public BigDecimal getT3_interest_profit_overdue_intsus() {
		return t3_interest_profit_overdue_intsus;
	}

	public void setT3_interest_profit_overdue_intsus(BigDecimal t3_interest_profit_overdue_intsus) {
		this.t3_interest_profit_overdue_intsus = t3_interest_profit_overdue_intsus;
	}

	public BigDecimal getT3_specific_provisions() {
		return t3_specific_provisions;
	}

	public void setT3_specific_provisions(BigDecimal t3_specific_provisions) {
		this.t3_specific_provisions = t3_specific_provisions;
	}

	public String getT4_product() {
		return t4_product;
	}

	public void setT4_product(String t4_product) {
		this.t4_product = t4_product;
	}

	public BigDecimal getT4_rescheduled_amt() {
		return t4_rescheduled_amt;
	}

	public void setT4_rescheduled_amt(BigDecimal t4_rescheduled_amt) {
		this.t4_rescheduled_amt = t4_rescheduled_amt;
	}

	public BigDecimal getT4_rescheduled_once() {
		return t4_rescheduled_once;
	}

	public void setT4_rescheduled_once(BigDecimal t4_rescheduled_once) {
		this.t4_rescheduled_once = t4_rescheduled_once;
	}

	public BigDecimal getT4_rescheduled_twice() {
		return t4_rescheduled_twice;
	}

	public void setT4_rescheduled_twice(BigDecimal t4_rescheduled_twice) {
		this.t4_rescheduled_twice = t4_rescheduled_twice;
	}

	public BigDecimal getT4_rescheduled_more_than_twice() {
		return t4_rescheduled_more_than_twice;
	}

	public void setT4_rescheduled_more_than_twice(BigDecimal t4_rescheduled_more_than_twice) {
		this.t4_rescheduled_more_than_twice = t4_rescheduled_more_than_twice;
	}

	public BigDecimal getT4_principal_regularly_amortized_period() {
		return t4_principal_regularly_amortized_period;
	}

	public void setT4_principal_regularly_amortized_period(BigDecimal t4_principal_regularly_amortized_period) {
		this.t4_principal_regularly_amortized_period = t4_principal_regularly_amortized_period;
	}

	public BigDecimal getT4_repayment_after_grace_period_exceed_oneyr() {
		return t4_repayment_after_grace_period_exceed_oneyr;
	}

	public void setT4_repayment_after_grace_period_exceed_oneyr(
			BigDecimal t4_repayment_after_grace_period_exceed_oneyr) {
		this.t4_repayment_after_grace_period_exceed_oneyr = t4_repayment_after_grace_period_exceed_oneyr;
	}

	public BigDecimal getT4_bullet_repayment() {
		return t4_bullet_repayment;
	}

	public void setT4_bullet_repayment(BigDecimal t4_bullet_repayment) {
		this.t4_bullet_repayment = t4_bullet_repayment;
	}

	public BigDecimal getT4_interest_profit_overdue_pl() {
		return t4_interest_profit_overdue_pl;
	}

	public void setT4_interest_profit_overdue_pl(BigDecimal t4_interest_profit_overdue_pl) {
		this.t4_interest_profit_overdue_pl = t4_interest_profit_overdue_pl;
	}

	public BigDecimal getT4_interest_profit_overdue_intsus() {
		return t4_interest_profit_overdue_intsus;
	}

	public void setT4_interest_profit_overdue_intsus(BigDecimal t4_interest_profit_overdue_intsus) {
		this.t4_interest_profit_overdue_intsus = t4_interest_profit_overdue_intsus;
	}

	public BigDecimal getT4_specific_provisions() {
		return t4_specific_provisions;
	}

	public void setT4_specific_provisions(BigDecimal t4_specific_provisions) {
		this.t4_specific_provisions = t4_specific_provisions;
	}

	public String getT5_product() {
		return t5_product;
	}

	public void setT5_product(String t5_product) {
		this.t5_product = t5_product;
	}

	public BigDecimal getT5_rescheduled_amt() {
		return t5_rescheduled_amt;
	}

	public void setT5_rescheduled_amt(BigDecimal t5_rescheduled_amt) {
		this.t5_rescheduled_amt = t5_rescheduled_amt;
	}

	public BigDecimal getT5_rescheduled_once() {
		return t5_rescheduled_once;
	}

	public void setT5_rescheduled_once(BigDecimal t5_rescheduled_once) {
		this.t5_rescheduled_once = t5_rescheduled_once;
	}

	public BigDecimal getT5_rescheduled_twice() {
		return t5_rescheduled_twice;
	}

	public void setT5_rescheduled_twice(BigDecimal t5_rescheduled_twice) {
		this.t5_rescheduled_twice = t5_rescheduled_twice;
	}

	public BigDecimal getT5_rescheduled_more_than_twice() {
		return t5_rescheduled_more_than_twice;
	}

	public void setT5_rescheduled_more_than_twice(BigDecimal t5_rescheduled_more_than_twice) {
		this.t5_rescheduled_more_than_twice = t5_rescheduled_more_than_twice;
	}

	public BigDecimal getT5_principal_regularly_amortized_period() {
		return t5_principal_regularly_amortized_period;
	}

	public void setT5_principal_regularly_amortized_period(BigDecimal t5_principal_regularly_amortized_period) {
		this.t5_principal_regularly_amortized_period = t5_principal_regularly_amortized_period;
	}

	public BigDecimal getT5_repayment_after_grace_period_exceed_oneyr() {
		return t5_repayment_after_grace_period_exceed_oneyr;
	}

	public void setT5_repayment_after_grace_period_exceed_oneyr(
			BigDecimal t5_repayment_after_grace_period_exceed_oneyr) {
		this.t5_repayment_after_grace_period_exceed_oneyr = t5_repayment_after_grace_period_exceed_oneyr;
	}

	public BigDecimal getT5_bullet_repayment() {
		return t5_bullet_repayment;
	}

	public void setT5_bullet_repayment(BigDecimal t5_bullet_repayment) {
		this.t5_bullet_repayment = t5_bullet_repayment;
	}

	public BigDecimal getT5_interest_profit_overdue_pl() {
		return t5_interest_profit_overdue_pl;
	}

	public void setT5_interest_profit_overdue_pl(BigDecimal t5_interest_profit_overdue_pl) {
		this.t5_interest_profit_overdue_pl = t5_interest_profit_overdue_pl;
	}

	public BigDecimal getT5_interest_profit_overdue_intsus() {
		return t5_interest_profit_overdue_intsus;
	}

	public void setT5_interest_profit_overdue_intsus(BigDecimal t5_interest_profit_overdue_intsus) {
		this.t5_interest_profit_overdue_intsus = t5_interest_profit_overdue_intsus;
	}

	public BigDecimal getT5_specific_provisions() {
		return t5_specific_provisions;
	}

	public void setT5_specific_provisions(BigDecimal t5_specific_provisions) {
		this.t5_specific_provisions = t5_specific_provisions;
	}

	public String getV1_product() {
		return v1_product;
	}

	public void setV1_product(String v1_product) {
		this.v1_product = v1_product;
	}

	public BigDecimal getV1_rescheduled_amt() {
		return v1_rescheduled_amt;
	}

	public void setV1_rescheduled_amt(BigDecimal v1_rescheduled_amt) {
		this.v1_rescheduled_amt = v1_rescheduled_amt;
	}

	public BigDecimal getV1_rescheduled_once() {
		return v1_rescheduled_once;
	}

	public void setV1_rescheduled_once(BigDecimal v1_rescheduled_once) {
		this.v1_rescheduled_once = v1_rescheduled_once;
	}

	public BigDecimal getV1_rescheduled_twice() {
		return v1_rescheduled_twice;
	}

	public void setV1_rescheduled_twice(BigDecimal v1_rescheduled_twice) {
		this.v1_rescheduled_twice = v1_rescheduled_twice;
	}

	public BigDecimal getV1_rescheduled_more_than_twice() {
		return v1_rescheduled_more_than_twice;
	}

	public void setV1_rescheduled_more_than_twice(BigDecimal v1_rescheduled_more_than_twice) {
		this.v1_rescheduled_more_than_twice = v1_rescheduled_more_than_twice;
	}

	public BigDecimal getV1_principal_regularly_amortized_period() {
		return v1_principal_regularly_amortized_period;
	}

	public void setV1_principal_regularly_amortized_period(BigDecimal v1_principal_regularly_amortized_period) {
		this.v1_principal_regularly_amortized_period = v1_principal_regularly_amortized_period;
	}

	public BigDecimal getV1_repayment_after_grace_period_exceed_oneyr() {
		return v1_repayment_after_grace_period_exceed_oneyr;
	}

	public void setV1_repayment_after_grace_period_exceed_oneyr(
			BigDecimal v1_repayment_after_grace_period_exceed_oneyr) {
		this.v1_repayment_after_grace_period_exceed_oneyr = v1_repayment_after_grace_period_exceed_oneyr;
	}

	public BigDecimal getV1_bullet_repayment() {
		return v1_bullet_repayment;
	}

	public void setV1_bullet_repayment(BigDecimal v1_bullet_repayment) {
		this.v1_bullet_repayment = v1_bullet_repayment;
	}

	public BigDecimal getV1_interest_profit_overdue_pl() {
		return v1_interest_profit_overdue_pl;
	}

	public void setV1_interest_profit_overdue_pl(BigDecimal v1_interest_profit_overdue_pl) {
		this.v1_interest_profit_overdue_pl = v1_interest_profit_overdue_pl;
	}

	public BigDecimal getV1_interest_profit_overdue_intsus() {
		return v1_interest_profit_overdue_intsus;
	}

	public void setV1_interest_profit_overdue_intsus(BigDecimal v1_interest_profit_overdue_intsus) {
		this.v1_interest_profit_overdue_intsus = v1_interest_profit_overdue_intsus;
	}

	public BigDecimal getV1_specific_provisions() {
		return v1_specific_provisions;
	}

	public void setV1_specific_provisions(BigDecimal v1_specific_provisions) {
		this.v1_specific_provisions = v1_specific_provisions;
	}

	public String getV2_product() {
		return v2_product;
	}

	public void setV2_product(String v2_product) {
		this.v2_product = v2_product;
	}

	public BigDecimal getV2_rescheduled_amt() {
		return v2_rescheduled_amt;
	}

	public void setV2_rescheduled_amt(BigDecimal v2_rescheduled_amt) {
		this.v2_rescheduled_amt = v2_rescheduled_amt;
	}

	public BigDecimal getV2_rescheduled_once() {
		return v2_rescheduled_once;
	}

	public void setV2_rescheduled_once(BigDecimal v2_rescheduled_once) {
		this.v2_rescheduled_once = v2_rescheduled_once;
	}

	public BigDecimal getV2_rescheduled_twice() {
		return v2_rescheduled_twice;
	}

	public void setV2_rescheduled_twice(BigDecimal v2_rescheduled_twice) {
		this.v2_rescheduled_twice = v2_rescheduled_twice;
	}

	public BigDecimal getV2_rescheduled_more_than_twice() {
		return v2_rescheduled_more_than_twice;
	}

	public void setV2_rescheduled_more_than_twice(BigDecimal v2_rescheduled_more_than_twice) {
		this.v2_rescheduled_more_than_twice = v2_rescheduled_more_than_twice;
	}

	public BigDecimal getV2_principal_regularly_amortized_period() {
		return v2_principal_regularly_amortized_period;
	}

	public void setV2_principal_regularly_amortized_period(BigDecimal v2_principal_regularly_amortized_period) {
		this.v2_principal_regularly_amortized_period = v2_principal_regularly_amortized_period;
	}

	public BigDecimal getV2_repayment_after_grace_period_exceed_oneyr() {
		return v2_repayment_after_grace_period_exceed_oneyr;
	}

	public void setV2_repayment_after_grace_period_exceed_oneyr(
			BigDecimal v2_repayment_after_grace_period_exceed_oneyr) {
		this.v2_repayment_after_grace_period_exceed_oneyr = v2_repayment_after_grace_period_exceed_oneyr;
	}

	public BigDecimal getV2_bullet_repayment() {
		return v2_bullet_repayment;
	}

	public void setV2_bullet_repayment(BigDecimal v2_bullet_repayment) {
		this.v2_bullet_repayment = v2_bullet_repayment;
	}

	public BigDecimal getV2_interest_profit_overdue_pl() {
		return v2_interest_profit_overdue_pl;
	}

	public void setV2_interest_profit_overdue_pl(BigDecimal v2_interest_profit_overdue_pl) {
		this.v2_interest_profit_overdue_pl = v2_interest_profit_overdue_pl;
	}

	public BigDecimal getV2_interest_profit_overdue_intsus() {
		return v2_interest_profit_overdue_intsus;
	}

	public void setV2_interest_profit_overdue_intsus(BigDecimal v2_interest_profit_overdue_intsus) {
		this.v2_interest_profit_overdue_intsus = v2_interest_profit_overdue_intsus;
	}

	public BigDecimal getV2_specific_provisions() {
		return v2_specific_provisions;
	}

	public void setV2_specific_provisions(BigDecimal v2_specific_provisions) {
		this.v2_specific_provisions = v2_specific_provisions;
	}

	public String getV3_product() {
		return v3_product;
	}

	public void setV3_product(String v3_product) {
		this.v3_product = v3_product;
	}

	public BigDecimal getV3_rescheduled_amt() {
		return v3_rescheduled_amt;
	}

	public void setV3_rescheduled_amt(BigDecimal v3_rescheduled_amt) {
		this.v3_rescheduled_amt = v3_rescheduled_amt;
	}

	public BigDecimal getV3_rescheduled_once() {
		return v3_rescheduled_once;
	}

	public void setV3_rescheduled_once(BigDecimal v3_rescheduled_once) {
		this.v3_rescheduled_once = v3_rescheduled_once;
	}

	public BigDecimal getV3_rescheduled_twice() {
		return v3_rescheduled_twice;
	}

	public void setV3_rescheduled_twice(BigDecimal v3_rescheduled_twice) {
		this.v3_rescheduled_twice = v3_rescheduled_twice;
	}

	public BigDecimal getV3_rescheduled_more_than_twice() {
		return v3_rescheduled_more_than_twice;
	}

	public void setV3_rescheduled_more_than_twice(BigDecimal v3_rescheduled_more_than_twice) {
		this.v3_rescheduled_more_than_twice = v3_rescheduled_more_than_twice;
	}

	public BigDecimal getV3_principal_regularly_amortized_period() {
		return v3_principal_regularly_amortized_period;
	}

	public void setV3_principal_regularly_amortized_period(BigDecimal v3_principal_regularly_amortized_period) {
		this.v3_principal_regularly_amortized_period = v3_principal_regularly_amortized_period;
	}

	public BigDecimal getV3_repayment_after_grace_period_exceed_oneyr() {
		return v3_repayment_after_grace_period_exceed_oneyr;
	}

	public void setV3_repayment_after_grace_period_exceed_oneyr(
			BigDecimal v3_repayment_after_grace_period_exceed_oneyr) {
		this.v3_repayment_after_grace_period_exceed_oneyr = v3_repayment_after_grace_period_exceed_oneyr;
	}

	public BigDecimal getV3_bullet_repayment() {
		return v3_bullet_repayment;
	}

	public void setV3_bullet_repayment(BigDecimal v3_bullet_repayment) {
		this.v3_bullet_repayment = v3_bullet_repayment;
	}

	public BigDecimal getV3_interest_profit_overdue_pl() {
		return v3_interest_profit_overdue_pl;
	}

	public void setV3_interest_profit_overdue_pl(BigDecimal v3_interest_profit_overdue_pl) {
		this.v3_interest_profit_overdue_pl = v3_interest_profit_overdue_pl;
	}

	public BigDecimal getV3_interest_profit_overdue_intsus() {
		return v3_interest_profit_overdue_intsus;
	}

	public void setV3_interest_profit_overdue_intsus(BigDecimal v3_interest_profit_overdue_intsus) {
		this.v3_interest_profit_overdue_intsus = v3_interest_profit_overdue_intsus;
	}

	public BigDecimal getV3_specific_provisions() {
		return v3_specific_provisions;
	}

	public void setV3_specific_provisions(BigDecimal v3_specific_provisions) {
		this.v3_specific_provisions = v3_specific_provisions;
	}

	public String getV4_product() {
		return v4_product;
	}

	public void setV4_product(String v4_product) {
		this.v4_product = v4_product;
	}

	public BigDecimal getV4_rescheduled_amt() {
		return v4_rescheduled_amt;
	}

	public void setV4_rescheduled_amt(BigDecimal v4_rescheduled_amt) {
		this.v4_rescheduled_amt = v4_rescheduled_amt;
	}

	public BigDecimal getV4_rescheduled_once() {
		return v4_rescheduled_once;
	}

	public void setV4_rescheduled_once(BigDecimal v4_rescheduled_once) {
		this.v4_rescheduled_once = v4_rescheduled_once;
	}

	public BigDecimal getV4_rescheduled_twice() {
		return v4_rescheduled_twice;
	}

	public void setV4_rescheduled_twice(BigDecimal v4_rescheduled_twice) {
		this.v4_rescheduled_twice = v4_rescheduled_twice;
	}

	public BigDecimal getV4_rescheduled_more_than_twice() {
		return v4_rescheduled_more_than_twice;
	}

	public void setV4_rescheduled_more_than_twice(BigDecimal v4_rescheduled_more_than_twice) {
		this.v4_rescheduled_more_than_twice = v4_rescheduled_more_than_twice;
	}

	public BigDecimal getV4_principal_regularly_amortized_period() {
		return v4_principal_regularly_amortized_period;
	}

	public void setV4_principal_regularly_amortized_period(BigDecimal v4_principal_regularly_amortized_period) {
		this.v4_principal_regularly_amortized_period = v4_principal_regularly_amortized_period;
	}

	public BigDecimal getV4_repayment_after_grace_period_exceed_oneyr() {
		return v4_repayment_after_grace_period_exceed_oneyr;
	}

	public void setV4_repayment_after_grace_period_exceed_oneyr(
			BigDecimal v4_repayment_after_grace_period_exceed_oneyr) {
		this.v4_repayment_after_grace_period_exceed_oneyr = v4_repayment_after_grace_period_exceed_oneyr;
	}

	public BigDecimal getV4_bullet_repayment() {
		return v4_bullet_repayment;
	}

	public void setV4_bullet_repayment(BigDecimal v4_bullet_repayment) {
		this.v4_bullet_repayment = v4_bullet_repayment;
	}

	public BigDecimal getV4_interest_profit_overdue_pl() {
		return v4_interest_profit_overdue_pl;
	}

	public void setV4_interest_profit_overdue_pl(BigDecimal v4_interest_profit_overdue_pl) {
		this.v4_interest_profit_overdue_pl = v4_interest_profit_overdue_pl;
	}

	public BigDecimal getV4_interest_profit_overdue_intsus() {
		return v4_interest_profit_overdue_intsus;
	}

	public void setV4_interest_profit_overdue_intsus(BigDecimal v4_interest_profit_overdue_intsus) {
		this.v4_interest_profit_overdue_intsus = v4_interest_profit_overdue_intsus;
	}

	public BigDecimal getV4_specific_provisions() {
		return v4_specific_provisions;
	}

	public void setV4_specific_provisions(BigDecimal v4_specific_provisions) {
		this.v4_specific_provisions = v4_specific_provisions;
	}

	public String getV5_product() {
		return v5_product;
	}

	public void setV5_product(String v5_product) {
		this.v5_product = v5_product;
	}

	public BigDecimal getV5_rescheduled_amt() {
		return v5_rescheduled_amt;
	}

	public void setV5_rescheduled_amt(BigDecimal v5_rescheduled_amt) {
		this.v5_rescheduled_amt = v5_rescheduled_amt;
	}

	public BigDecimal getV5_rescheduled_once() {
		return v5_rescheduled_once;
	}

	public void setV5_rescheduled_once(BigDecimal v5_rescheduled_once) {
		this.v5_rescheduled_once = v5_rescheduled_once;
	}

	public BigDecimal getV5_rescheduled_twice() {
		return v5_rescheduled_twice;
	}

	public void setV5_rescheduled_twice(BigDecimal v5_rescheduled_twice) {
		this.v5_rescheduled_twice = v5_rescheduled_twice;
	}

	public BigDecimal getV5_rescheduled_more_than_twice() {
		return v5_rescheduled_more_than_twice;
	}

	public void setV5_rescheduled_more_than_twice(BigDecimal v5_rescheduled_more_than_twice) {
		this.v5_rescheduled_more_than_twice = v5_rescheduled_more_than_twice;
	}

	public BigDecimal getV5_principal_regularly_amortized_period() {
		return v5_principal_regularly_amortized_period;
	}

	public void setV5_principal_regularly_amortized_period(BigDecimal v5_principal_regularly_amortized_period) {
		this.v5_principal_regularly_amortized_period = v5_principal_regularly_amortized_period;
	}

	public BigDecimal getV5_repayment_after_grace_period_exceed_oneyr() {
		return v5_repayment_after_grace_period_exceed_oneyr;
	}

	public void setV5_repayment_after_grace_period_exceed_oneyr(
			BigDecimal v5_repayment_after_grace_period_exceed_oneyr) {
		this.v5_repayment_after_grace_period_exceed_oneyr = v5_repayment_after_grace_period_exceed_oneyr;
	}

	public BigDecimal getV5_bullet_repayment() {
		return v5_bullet_repayment;
	}

	public void setV5_bullet_repayment(BigDecimal v5_bullet_repayment) {
		this.v5_bullet_repayment = v5_bullet_repayment;
	}

	public BigDecimal getV5_interest_profit_overdue_pl() {
		return v5_interest_profit_overdue_pl;
	}

	public void setV5_interest_profit_overdue_pl(BigDecimal v5_interest_profit_overdue_pl) {
		this.v5_interest_profit_overdue_pl = v5_interest_profit_overdue_pl;
	}

	public BigDecimal getV5_interest_profit_overdue_intsus() {
		return v5_interest_profit_overdue_intsus;
	}

	public void setV5_interest_profit_overdue_intsus(BigDecimal v5_interest_profit_overdue_intsus) {
		this.v5_interest_profit_overdue_intsus = v5_interest_profit_overdue_intsus;
	}

	public BigDecimal getV5_specific_provisions() {
		return v5_specific_provisions;
	}

	public void setV5_specific_provisions(BigDecimal v5_specific_provisions) {
		this.v5_specific_provisions = v5_specific_provisions;
	}

	public String getV6_product() {
		return v6_product;
	}

	public void setV6_product(String v6_product) {
		this.v6_product = v6_product;
	}

	public BigDecimal getV6_rescheduled_amt() {
		return v6_rescheduled_amt;
	}

	public void setV6_rescheduled_amt(BigDecimal v6_rescheduled_amt) {
		this.v6_rescheduled_amt = v6_rescheduled_amt;
	}

	public BigDecimal getV6_rescheduled_once() {
		return v6_rescheduled_once;
	}

	public void setV6_rescheduled_once(BigDecimal v6_rescheduled_once) {
		this.v6_rescheduled_once = v6_rescheduled_once;
	}

	public BigDecimal getV6_rescheduled_twice() {
		return v6_rescheduled_twice;
	}

	public void setV6_rescheduled_twice(BigDecimal v6_rescheduled_twice) {
		this.v6_rescheduled_twice = v6_rescheduled_twice;
	}

	public BigDecimal getV6_rescheduled_more_than_twice() {
		return v6_rescheduled_more_than_twice;
	}

	public void setV6_rescheduled_more_than_twice(BigDecimal v6_rescheduled_more_than_twice) {
		this.v6_rescheduled_more_than_twice = v6_rescheduled_more_than_twice;
	}

	public BigDecimal getV6_principal_regularly_amortized_period() {
		return v6_principal_regularly_amortized_period;
	}

	public void setV6_principal_regularly_amortized_period(BigDecimal v6_principal_regularly_amortized_period) {
		this.v6_principal_regularly_amortized_period = v6_principal_regularly_amortized_period;
	}

	public BigDecimal getV6_repayment_after_grace_period_exceed_oneyr() {
		return v6_repayment_after_grace_period_exceed_oneyr;
	}

	public void setV6_repayment_after_grace_period_exceed_oneyr(
			BigDecimal v6_repayment_after_grace_period_exceed_oneyr) {
		this.v6_repayment_after_grace_period_exceed_oneyr = v6_repayment_after_grace_period_exceed_oneyr;
	}

	public BigDecimal getV6_bullet_repayment() {
		return v6_bullet_repayment;
	}

	public void setV6_bullet_repayment(BigDecimal v6_bullet_repayment) {
		this.v6_bullet_repayment = v6_bullet_repayment;
	}

	public BigDecimal getV6_interest_profit_overdue_pl() {
		return v6_interest_profit_overdue_pl;
	}

	public void setV6_interest_profit_overdue_pl(BigDecimal v6_interest_profit_overdue_pl) {
		this.v6_interest_profit_overdue_pl = v6_interest_profit_overdue_pl;
	}

	public BigDecimal getV6_interest_profit_overdue_intsus() {
		return v6_interest_profit_overdue_intsus;
	}

	public void setV6_interest_profit_overdue_intsus(BigDecimal v6_interest_profit_overdue_intsus) {
		this.v6_interest_profit_overdue_intsus = v6_interest_profit_overdue_intsus;
	}

	public BigDecimal getV6_specific_provisions() {
		return v6_specific_provisions;
	}

	public void setV6_specific_provisions(BigDecimal v6_specific_provisions) {
		this.v6_specific_provisions = v6_specific_provisions;
	}

	public String getV7_product() {
		return v7_product;
	}

	public void setV7_product(String v7_product) {
		this.v7_product = v7_product;
	}

	public BigDecimal getV7_rescheduled_amt() {
		return v7_rescheduled_amt;
	}

	public void setV7_rescheduled_amt(BigDecimal v7_rescheduled_amt) {
		this.v7_rescheduled_amt = v7_rescheduled_amt;
	}

	public BigDecimal getV7_rescheduled_once() {
		return v7_rescheduled_once;
	}

	public void setV7_rescheduled_once(BigDecimal v7_rescheduled_once) {
		this.v7_rescheduled_once = v7_rescheduled_once;
	}

	public BigDecimal getV7_rescheduled_twice() {
		return v7_rescheduled_twice;
	}

	public void setV7_rescheduled_twice(BigDecimal v7_rescheduled_twice) {
		this.v7_rescheduled_twice = v7_rescheduled_twice;
	}

	public BigDecimal getV7_rescheduled_more_than_twice() {
		return v7_rescheduled_more_than_twice;
	}

	public void setV7_rescheduled_more_than_twice(BigDecimal v7_rescheduled_more_than_twice) {
		this.v7_rescheduled_more_than_twice = v7_rescheduled_more_than_twice;
	}

	public BigDecimal getV7_principal_regularly_amortized_period() {
		return v7_principal_regularly_amortized_period;
	}

	public void setV7_principal_regularly_amortized_period(BigDecimal v7_principal_regularly_amortized_period) {
		this.v7_principal_regularly_amortized_period = v7_principal_regularly_amortized_period;
	}

	public BigDecimal getV7_repayment_after_grace_period_exceed_oneyr() {
		return v7_repayment_after_grace_period_exceed_oneyr;
	}

	public void setV7_repayment_after_grace_period_exceed_oneyr(
			BigDecimal v7_repayment_after_grace_period_exceed_oneyr) {
		this.v7_repayment_after_grace_period_exceed_oneyr = v7_repayment_after_grace_period_exceed_oneyr;
	}

	public BigDecimal getV7_bullet_repayment() {
		return v7_bullet_repayment;
	}

	public void setV7_bullet_repayment(BigDecimal v7_bullet_repayment) {
		this.v7_bullet_repayment = v7_bullet_repayment;
	}

	public BigDecimal getV7_interest_profit_overdue_pl() {
		return v7_interest_profit_overdue_pl;
	}

	public void setV7_interest_profit_overdue_pl(BigDecimal v7_interest_profit_overdue_pl) {
		this.v7_interest_profit_overdue_pl = v7_interest_profit_overdue_pl;
	}

	public BigDecimal getV7_interest_profit_overdue_intsus() {
		return v7_interest_profit_overdue_intsus;
	}

	public void setV7_interest_profit_overdue_intsus(BigDecimal v7_interest_profit_overdue_intsus) {
		this.v7_interest_profit_overdue_intsus = v7_interest_profit_overdue_intsus;
	}

	public BigDecimal getV7_specific_provisions() {
		return v7_specific_provisions;
	}

	public void setV7_specific_provisions(BigDecimal v7_specific_provisions) {
		this.v7_specific_provisions = v7_specific_provisions;
	}

	public String getW1_product() {
		return w1_product;
	}

	public void setW1_product(String w1_product) {
		this.w1_product = w1_product;
	}

	public BigDecimal getW1_rescheduled_amt() {
		return w1_rescheduled_amt;
	}

	public void setW1_rescheduled_amt(BigDecimal w1_rescheduled_amt) {
		this.w1_rescheduled_amt = w1_rescheduled_amt;
	}

	public BigDecimal getW1_rescheduled_once() {
		return w1_rescheduled_once;
	}

	public void setW1_rescheduled_once(BigDecimal w1_rescheduled_once) {
		this.w1_rescheduled_once = w1_rescheduled_once;
	}

	public BigDecimal getW1_rescheduled_twice() {
		return w1_rescheduled_twice;
	}

	public void setW1_rescheduled_twice(BigDecimal w1_rescheduled_twice) {
		this.w1_rescheduled_twice = w1_rescheduled_twice;
	}

	public BigDecimal getW1_rescheduled_more_than_twice() {
		return w1_rescheduled_more_than_twice;
	}

	public void setW1_rescheduled_more_than_twice(BigDecimal w1_rescheduled_more_than_twice) {
		this.w1_rescheduled_more_than_twice = w1_rescheduled_more_than_twice;
	}

	public BigDecimal getW1_principal_regularly_amortized_period() {
		return w1_principal_regularly_amortized_period;
	}

	public void setW1_principal_regularly_amortized_period(BigDecimal w1_principal_regularly_amortized_period) {
		this.w1_principal_regularly_amortized_period = w1_principal_regularly_amortized_period;
	}

	public BigDecimal getW1_repayment_after_grace_period_exceed_oneyr() {
		return w1_repayment_after_grace_period_exceed_oneyr;
	}

	public void setW1_repayment_after_grace_period_exceed_oneyr(
			BigDecimal w1_repayment_after_grace_period_exceed_oneyr) {
		this.w1_repayment_after_grace_period_exceed_oneyr = w1_repayment_after_grace_period_exceed_oneyr;
	}

	public BigDecimal getW1_bullet_repayment() {
		return w1_bullet_repayment;
	}

	public void setW1_bullet_repayment(BigDecimal w1_bullet_repayment) {
		this.w1_bullet_repayment = w1_bullet_repayment;
	}

	public BigDecimal getW1_interest_profit_overdue_pl() {
		return w1_interest_profit_overdue_pl;
	}

	public void setW1_interest_profit_overdue_pl(BigDecimal w1_interest_profit_overdue_pl) {
		this.w1_interest_profit_overdue_pl = w1_interest_profit_overdue_pl;
	}

	public BigDecimal getW1_interest_profit_overdue_intsus() {
		return w1_interest_profit_overdue_intsus;
	}

	public void setW1_interest_profit_overdue_intsus(BigDecimal w1_interest_profit_overdue_intsus) {
		this.w1_interest_profit_overdue_intsus = w1_interest_profit_overdue_intsus;
	}

	public BigDecimal getW1_specific_provisions() {
		return w1_specific_provisions;
	}

	public void setW1_specific_provisions(BigDecimal w1_specific_provisions) {
		this.w1_specific_provisions = w1_specific_provisions;
	}

	public String getX1_product() {
		return x1_product;
	}

	public void setX1_product(String x1_product) {
		this.x1_product = x1_product;
	}

	public BigDecimal getX1_rescheduled_amt() {
		return x1_rescheduled_amt;
	}

	public void setX1_rescheduled_amt(BigDecimal x1_rescheduled_amt) {
		this.x1_rescheduled_amt = x1_rescheduled_amt;
	}

	public BigDecimal getX1_rescheduled_once() {
		return x1_rescheduled_once;
	}

	public void setX1_rescheduled_once(BigDecimal x1_rescheduled_once) {
		this.x1_rescheduled_once = x1_rescheduled_once;
	}

	public BigDecimal getX1_rescheduled_twice() {
		return x1_rescheduled_twice;
	}

	public void setX1_rescheduled_twice(BigDecimal x1_rescheduled_twice) {
		this.x1_rescheduled_twice = x1_rescheduled_twice;
	}

	public BigDecimal getX1_rescheduled_more_than_twice() {
		return x1_rescheduled_more_than_twice;
	}

	public void setX1_rescheduled_more_than_twice(BigDecimal x1_rescheduled_more_than_twice) {
		this.x1_rescheduled_more_than_twice = x1_rescheduled_more_than_twice;
	}

	public BigDecimal getX1_principal_regularly_amortized_period() {
		return x1_principal_regularly_amortized_period;
	}

	public void setX1_principal_regularly_amortized_period(BigDecimal x1_principal_regularly_amortized_period) {
		this.x1_principal_regularly_amortized_period = x1_principal_regularly_amortized_period;
	}

	public BigDecimal getX1_repayment_after_grace_period_exceed_oneyr() {
		return x1_repayment_after_grace_period_exceed_oneyr;
	}

	public void setX1_repayment_after_grace_period_exceed_oneyr(
			BigDecimal x1_repayment_after_grace_period_exceed_oneyr) {
		this.x1_repayment_after_grace_period_exceed_oneyr = x1_repayment_after_grace_period_exceed_oneyr;
	}

	public BigDecimal getX1_bullet_repayment() {
		return x1_bullet_repayment;
	}

	public void setX1_bullet_repayment(BigDecimal x1_bullet_repayment) {
		this.x1_bullet_repayment = x1_bullet_repayment;
	}

	public BigDecimal getX1_interest_profit_overdue_pl() {
		return x1_interest_profit_overdue_pl;
	}

	public void setX1_interest_profit_overdue_pl(BigDecimal x1_interest_profit_overdue_pl) {
		this.x1_interest_profit_overdue_pl = x1_interest_profit_overdue_pl;
	}

	public BigDecimal getX1_interest_profit_overdue_intsus() {
		return x1_interest_profit_overdue_intsus;
	}

	public void setX1_interest_profit_overdue_intsus(BigDecimal x1_interest_profit_overdue_intsus) {
		this.x1_interest_profit_overdue_intsus = x1_interest_profit_overdue_intsus;
	}

	public BigDecimal getX1_specific_provisions() {
		return x1_specific_provisions;
	}

	public void setX1_specific_provisions(BigDecimal x1_specific_provisions) {
		this.x1_specific_provisions = x1_specific_provisions;
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
	

	public BRF65_Entity(Date report_date, String r1_product, BigDecimal r1_rescheduled_amt,
			BigDecimal r1_rescheduled_once, BigDecimal r1_rescheduled_twice, BigDecimal r1_rescheduled_more_than_twice,
			BigDecimal r1_principal_regularly_amortized_period, BigDecimal r1_repayment_after_grace_period_exceed_oneyr,
			BigDecimal r1_bullet_repayment, BigDecimal r1_interest_profit_overdue_pl,
			BigDecimal r1_interest_profit_overdue_intsus, BigDecimal r1_specific_provisions, String s1_product,
			BigDecimal s1_rescheduled_amt, BigDecimal s1_rescheduled_once, BigDecimal s1_rescheduled_twice,
			BigDecimal s1_rescheduled_more_than_twice, BigDecimal s1_principal_regularly_amortized_period,
			BigDecimal s1_repayment_after_grace_period_exceed_oneyr, BigDecimal s1_bullet_repayment,
			BigDecimal s1_interest_profit_overdue_pl, BigDecimal s1_interest_profit_overdue_intsus,
			BigDecimal s1_specific_provisions, String s2_product, BigDecimal s2_rescheduled_amt,
			BigDecimal s2_rescheduled_once, BigDecimal s2_rescheduled_twice, BigDecimal s2_rescheduled_more_than_twice,
			BigDecimal s2_principal_regularly_amortized_period, BigDecimal s2_repayment_after_grace_period_exceed_oneyr,
			BigDecimal s2_bullet_repayment, BigDecimal s2_interest_profit_overdue_pl,
			BigDecimal s2_interest_profit_overdue_intsus, BigDecimal s2_specific_provisions, String s3_product,
			BigDecimal s3_rescheduled_amt, BigDecimal s3_rescheduled_once, BigDecimal s3_rescheduled_twice,
			BigDecimal s3_rescheduled_more_than_twice, BigDecimal s3_principal_regularly_amortized_period,
			BigDecimal s3_repayment_after_grace_period_exceed_oneyr, BigDecimal s3_bullet_repayment,
			BigDecimal s3_interest_profit_overdue_pl, BigDecimal s3_interest_profit_overdue_intsus,
			BigDecimal s3_specific_provisions, String s4_product, BigDecimal s4_rescheduled_amt,
			BigDecimal s4_rescheduled_once, BigDecimal s4_rescheduled_twice, BigDecimal s4_rescheduled_more_than_twice,
			BigDecimal s4_principal_regularly_amortized_period, BigDecimal s4_repayment_after_grace_period_exceed_oneyr,
			BigDecimal s4_bullet_repayment, BigDecimal s4_interest_profit_overdue_pl,
			BigDecimal s4_interest_profit_overdue_intsus, BigDecimal s4_specific_provisions, String t1_product,
			BigDecimal t1_rescheduled_amt, BigDecimal t1_rescheduled_once, BigDecimal t1_rescheduled_twice,
			BigDecimal t1_rescheduled_more_than_twice, BigDecimal t1_principal_regularly_amortized_period,
			BigDecimal t1_repayment_after_grace_period_exceed_oneyr, BigDecimal t1_bullet_repayment,
			BigDecimal t1_interest_profit_overdue_pl, BigDecimal t1_interest_profit_overdue_intsus,
			BigDecimal t1_specific_provisions, String t2_product, BigDecimal t2_rescheduled_amt,
			BigDecimal t2_rescheduled_once, BigDecimal t2_rescheduled_twice, BigDecimal t2_rescheduled_more_than_twice,
			BigDecimal t2_principal_regularly_amortized_period, BigDecimal t2_repayment_after_grace_period_exceed_oneyr,
			BigDecimal t2_bullet_repayment, BigDecimal t2_interest_profit_overdue_pl,
			BigDecimal t2_interest_profit_overdue_intsus, BigDecimal t2_specific_provisions, String t3_product,
			BigDecimal t3_rescheduled_amt, BigDecimal t3_rescheduled_once, BigDecimal t3_rescheduled_twice,
			BigDecimal t3_rescheduled_more_than_twice, BigDecimal t3_principal_regularly_amortized_period,
			BigDecimal t3_repayment_after_grace_period_exceed_oneyr, BigDecimal t3_bullet_repayment,
			BigDecimal t3_interest_profit_overdue_pl, BigDecimal t3_interest_profit_overdue_intsus,
			BigDecimal t3_specific_provisions, String t4_product, BigDecimal t4_rescheduled_amt,
			BigDecimal t4_rescheduled_once, BigDecimal t4_rescheduled_twice, BigDecimal t4_rescheduled_more_than_twice,
			BigDecimal t4_principal_regularly_amortized_period, BigDecimal t4_repayment_after_grace_period_exceed_oneyr,
			BigDecimal t4_bullet_repayment, BigDecimal t4_interest_profit_overdue_pl,
			BigDecimal t4_interest_profit_overdue_intsus, BigDecimal t4_specific_provisions, String t5_product,
			BigDecimal t5_rescheduled_amt, BigDecimal t5_rescheduled_once, BigDecimal t5_rescheduled_twice,
			BigDecimal t5_rescheduled_more_than_twice, BigDecimal t5_principal_regularly_amortized_period,
			BigDecimal t5_repayment_after_grace_period_exceed_oneyr, BigDecimal t5_bullet_repayment,
			BigDecimal t5_interest_profit_overdue_pl, BigDecimal t5_interest_profit_overdue_intsus,
			BigDecimal t5_specific_provisions, String v1_product, BigDecimal v1_rescheduled_amt,
			BigDecimal v1_rescheduled_once, BigDecimal v1_rescheduled_twice, BigDecimal v1_rescheduled_more_than_twice,
			BigDecimal v1_principal_regularly_amortized_period, BigDecimal v1_repayment_after_grace_period_exceed_oneyr,
			BigDecimal v1_bullet_repayment, BigDecimal v1_interest_profit_overdue_pl,
			BigDecimal v1_interest_profit_overdue_intsus, BigDecimal v1_specific_provisions, String v2_product,
			BigDecimal v2_rescheduled_amt, BigDecimal v2_rescheduled_once, BigDecimal v2_rescheduled_twice,
			BigDecimal v2_rescheduled_more_than_twice, BigDecimal v2_principal_regularly_amortized_period,
			BigDecimal v2_repayment_after_grace_period_exceed_oneyr, BigDecimal v2_bullet_repayment,
			BigDecimal v2_interest_profit_overdue_pl, BigDecimal v2_interest_profit_overdue_intsus,
			BigDecimal v2_specific_provisions, String v3_product, BigDecimal v3_rescheduled_amt,
			BigDecimal v3_rescheduled_once, BigDecimal v3_rescheduled_twice, BigDecimal v3_rescheduled_more_than_twice,
			BigDecimal v3_principal_regularly_amortized_period, BigDecimal v3_repayment_after_grace_period_exceed_oneyr,
			BigDecimal v3_bullet_repayment, BigDecimal v3_interest_profit_overdue_pl,
			BigDecimal v3_interest_profit_overdue_intsus, BigDecimal v3_specific_provisions, String v4_product,
			BigDecimal v4_rescheduled_amt, BigDecimal v4_rescheduled_once, BigDecimal v4_rescheduled_twice,
			BigDecimal v4_rescheduled_more_than_twice, BigDecimal v4_principal_regularly_amortized_period,
			BigDecimal v4_repayment_after_grace_period_exceed_oneyr, BigDecimal v4_bullet_repayment,
			BigDecimal v4_interest_profit_overdue_pl, BigDecimal v4_interest_profit_overdue_intsus,
			BigDecimal v4_specific_provisions, String v5_product, BigDecimal v5_rescheduled_amt,
			BigDecimal v5_rescheduled_once, BigDecimal v5_rescheduled_twice, BigDecimal v5_rescheduled_more_than_twice,
			BigDecimal v5_principal_regularly_amortized_period, BigDecimal v5_repayment_after_grace_period_exceed_oneyr,
			BigDecimal v5_bullet_repayment, BigDecimal v5_interest_profit_overdue_pl,
			BigDecimal v5_interest_profit_overdue_intsus, BigDecimal v5_specific_provisions, String v6_product,
			BigDecimal v6_rescheduled_amt, BigDecimal v6_rescheduled_once, BigDecimal v6_rescheduled_twice,
			BigDecimal v6_rescheduled_more_than_twice, BigDecimal v6_principal_regularly_amortized_period,
			BigDecimal v6_repayment_after_grace_period_exceed_oneyr, BigDecimal v6_bullet_repayment,
			BigDecimal v6_interest_profit_overdue_pl, BigDecimal v6_interest_profit_overdue_intsus,
			BigDecimal v6_specific_provisions, String v7_product, BigDecimal v7_rescheduled_amt,
			BigDecimal v7_rescheduled_once, BigDecimal v7_rescheduled_twice, BigDecimal v7_rescheduled_more_than_twice,
			BigDecimal v7_principal_regularly_amortized_period, BigDecimal v7_repayment_after_grace_period_exceed_oneyr,
			BigDecimal v7_bullet_repayment, BigDecimal v7_interest_profit_overdue_pl,
			BigDecimal v7_interest_profit_overdue_intsus, BigDecimal v7_specific_provisions, String w1_product,
			BigDecimal w1_rescheduled_amt, BigDecimal w1_rescheduled_once, BigDecimal w1_rescheduled_twice,
			BigDecimal w1_rescheduled_more_than_twice, BigDecimal w1_principal_regularly_amortized_period,
			BigDecimal w1_repayment_after_grace_period_exceed_oneyr, BigDecimal w1_bullet_repayment,
			BigDecimal w1_interest_profit_overdue_pl, BigDecimal w1_interest_profit_overdue_intsus,
			BigDecimal w1_specific_provisions, String x1_product, BigDecimal x1_rescheduled_amt,
			BigDecimal x1_rescheduled_once, BigDecimal x1_rescheduled_twice, BigDecimal x1_rescheduled_more_than_twice,
			BigDecimal x1_principal_regularly_amortized_period, BigDecimal x1_repayment_after_grace_period_exceed_oneyr,
			BigDecimal x1_bullet_repayment, BigDecimal x1_interest_profit_overdue_pl,
			BigDecimal x1_interest_profit_overdue_intsus, BigDecimal x1_specific_provisions, Date report_from_date,
			Date report_to_date, String entity_flg, String modify_flg, String del_flg, String report_code,
			Date report_submit_date, String repdesc, String frequency) {
		super();
		this.report_date = report_date;
		this.r1_product = r1_product;
		this.r1_rescheduled_amt = r1_rescheduled_amt;
		this.r1_rescheduled_once = r1_rescheduled_once;
		this.r1_rescheduled_twice = r1_rescheduled_twice;
		this.r1_rescheduled_more_than_twice = r1_rescheduled_more_than_twice;
		this.r1_principal_regularly_amortized_period = r1_principal_regularly_amortized_period;
		this.r1_repayment_after_grace_period_exceed_oneyr = r1_repayment_after_grace_period_exceed_oneyr;
		this.r1_bullet_repayment = r1_bullet_repayment;
		this.r1_interest_profit_overdue_pl = r1_interest_profit_overdue_pl;
		this.r1_interest_profit_overdue_intsus = r1_interest_profit_overdue_intsus;
		this.r1_specific_provisions = r1_specific_provisions;
		this.s1_product = s1_product;
		this.s1_rescheduled_amt = s1_rescheduled_amt;
		this.s1_rescheduled_once = s1_rescheduled_once;
		this.s1_rescheduled_twice = s1_rescheduled_twice;
		this.s1_rescheduled_more_than_twice = s1_rescheduled_more_than_twice;
		this.s1_principal_regularly_amortized_period = s1_principal_regularly_amortized_period;
		this.s1_repayment_after_grace_period_exceed_oneyr = s1_repayment_after_grace_period_exceed_oneyr;
		this.s1_bullet_repayment = s1_bullet_repayment;
		this.s1_interest_profit_overdue_pl = s1_interest_profit_overdue_pl;
		this.s1_interest_profit_overdue_intsus = s1_interest_profit_overdue_intsus;
		this.s1_specific_provisions = s1_specific_provisions;
		this.s2_product = s2_product;
		this.s2_rescheduled_amt = s2_rescheduled_amt;
		this.s2_rescheduled_once = s2_rescheduled_once;
		this.s2_rescheduled_twice = s2_rescheduled_twice;
		this.s2_rescheduled_more_than_twice = s2_rescheduled_more_than_twice;
		this.s2_principal_regularly_amortized_period = s2_principal_regularly_amortized_period;
		this.s2_repayment_after_grace_period_exceed_oneyr = s2_repayment_after_grace_period_exceed_oneyr;
		this.s2_bullet_repayment = s2_bullet_repayment;
		this.s2_interest_profit_overdue_pl = s2_interest_profit_overdue_pl;
		this.s2_interest_profit_overdue_intsus = s2_interest_profit_overdue_intsus;
		this.s2_specific_provisions = s2_specific_provisions;
		this.s3_product = s3_product;
		this.s3_rescheduled_amt = s3_rescheduled_amt;
		this.s3_rescheduled_once = s3_rescheduled_once;
		this.s3_rescheduled_twice = s3_rescheduled_twice;
		this.s3_rescheduled_more_than_twice = s3_rescheduled_more_than_twice;
		this.s3_principal_regularly_amortized_period = s3_principal_regularly_amortized_period;
		this.s3_repayment_after_grace_period_exceed_oneyr = s3_repayment_after_grace_period_exceed_oneyr;
		this.s3_bullet_repayment = s3_bullet_repayment;
		this.s3_interest_profit_overdue_pl = s3_interest_profit_overdue_pl;
		this.s3_interest_profit_overdue_intsus = s3_interest_profit_overdue_intsus;
		this.s3_specific_provisions = s3_specific_provisions;
		this.s4_product = s4_product;
		this.s4_rescheduled_amt = s4_rescheduled_amt;
		this.s4_rescheduled_once = s4_rescheduled_once;
		this.s4_rescheduled_twice = s4_rescheduled_twice;
		this.s4_rescheduled_more_than_twice = s4_rescheduled_more_than_twice;
		this.s4_principal_regularly_amortized_period = s4_principal_regularly_amortized_period;
		this.s4_repayment_after_grace_period_exceed_oneyr = s4_repayment_after_grace_period_exceed_oneyr;
		this.s4_bullet_repayment = s4_bullet_repayment;
		this.s4_interest_profit_overdue_pl = s4_interest_profit_overdue_pl;
		this.s4_interest_profit_overdue_intsus = s4_interest_profit_overdue_intsus;
		this.s4_specific_provisions = s4_specific_provisions;
		this.t1_product = t1_product;
		this.t1_rescheduled_amt = t1_rescheduled_amt;
		this.t1_rescheduled_once = t1_rescheduled_once;
		this.t1_rescheduled_twice = t1_rescheduled_twice;
		this.t1_rescheduled_more_than_twice = t1_rescheduled_more_than_twice;
		this.t1_principal_regularly_amortized_period = t1_principal_regularly_amortized_period;
		this.t1_repayment_after_grace_period_exceed_oneyr = t1_repayment_after_grace_period_exceed_oneyr;
		this.t1_bullet_repayment = t1_bullet_repayment;
		this.t1_interest_profit_overdue_pl = t1_interest_profit_overdue_pl;
		this.t1_interest_profit_overdue_intsus = t1_interest_profit_overdue_intsus;
		this.t1_specific_provisions = t1_specific_provisions;
		this.t2_product = t2_product;
		this.t2_rescheduled_amt = t2_rescheduled_amt;
		this.t2_rescheduled_once = t2_rescheduled_once;
		this.t2_rescheduled_twice = t2_rescheduled_twice;
		this.t2_rescheduled_more_than_twice = t2_rescheduled_more_than_twice;
		this.t2_principal_regularly_amortized_period = t2_principal_regularly_amortized_period;
		this.t2_repayment_after_grace_period_exceed_oneyr = t2_repayment_after_grace_period_exceed_oneyr;
		this.t2_bullet_repayment = t2_bullet_repayment;
		this.t2_interest_profit_overdue_pl = t2_interest_profit_overdue_pl;
		this.t2_interest_profit_overdue_intsus = t2_interest_profit_overdue_intsus;
		this.t2_specific_provisions = t2_specific_provisions;
		this.t3_product = t3_product;
		this.t3_rescheduled_amt = t3_rescheduled_amt;
		this.t3_rescheduled_once = t3_rescheduled_once;
		this.t3_rescheduled_twice = t3_rescheduled_twice;
		this.t3_rescheduled_more_than_twice = t3_rescheduled_more_than_twice;
		this.t3_principal_regularly_amortized_period = t3_principal_regularly_amortized_period;
		this.t3_repayment_after_grace_period_exceed_oneyr = t3_repayment_after_grace_period_exceed_oneyr;
		this.t3_bullet_repayment = t3_bullet_repayment;
		this.t3_interest_profit_overdue_pl = t3_interest_profit_overdue_pl;
		this.t3_interest_profit_overdue_intsus = t3_interest_profit_overdue_intsus;
		this.t3_specific_provisions = t3_specific_provisions;
		this.t4_product = t4_product;
		this.t4_rescheduled_amt = t4_rescheduled_amt;
		this.t4_rescheduled_once = t4_rescheduled_once;
		this.t4_rescheduled_twice = t4_rescheduled_twice;
		this.t4_rescheduled_more_than_twice = t4_rescheduled_more_than_twice;
		this.t4_principal_regularly_amortized_period = t4_principal_regularly_amortized_period;
		this.t4_repayment_after_grace_period_exceed_oneyr = t4_repayment_after_grace_period_exceed_oneyr;
		this.t4_bullet_repayment = t4_bullet_repayment;
		this.t4_interest_profit_overdue_pl = t4_interest_profit_overdue_pl;
		this.t4_interest_profit_overdue_intsus = t4_interest_profit_overdue_intsus;
		this.t4_specific_provisions = t4_specific_provisions;
		this.t5_product = t5_product;
		this.t5_rescheduled_amt = t5_rescheduled_amt;
		this.t5_rescheduled_once = t5_rescheduled_once;
		this.t5_rescheduled_twice = t5_rescheduled_twice;
		this.t5_rescheduled_more_than_twice = t5_rescheduled_more_than_twice;
		this.t5_principal_regularly_amortized_period = t5_principal_regularly_amortized_period;
		this.t5_repayment_after_grace_period_exceed_oneyr = t5_repayment_after_grace_period_exceed_oneyr;
		this.t5_bullet_repayment = t5_bullet_repayment;
		this.t5_interest_profit_overdue_pl = t5_interest_profit_overdue_pl;
		this.t5_interest_profit_overdue_intsus = t5_interest_profit_overdue_intsus;
		this.t5_specific_provisions = t5_specific_provisions;
		this.v1_product = v1_product;
		this.v1_rescheduled_amt = v1_rescheduled_amt;
		this.v1_rescheduled_once = v1_rescheduled_once;
		this.v1_rescheduled_twice = v1_rescheduled_twice;
		this.v1_rescheduled_more_than_twice = v1_rescheduled_more_than_twice;
		this.v1_principal_regularly_amortized_period = v1_principal_regularly_amortized_period;
		this.v1_repayment_after_grace_period_exceed_oneyr = v1_repayment_after_grace_period_exceed_oneyr;
		this.v1_bullet_repayment = v1_bullet_repayment;
		this.v1_interest_profit_overdue_pl = v1_interest_profit_overdue_pl;
		this.v1_interest_profit_overdue_intsus = v1_interest_profit_overdue_intsus;
		this.v1_specific_provisions = v1_specific_provisions;
		this.v2_product = v2_product;
		this.v2_rescheduled_amt = v2_rescheduled_amt;
		this.v2_rescheduled_once = v2_rescheduled_once;
		this.v2_rescheduled_twice = v2_rescheduled_twice;
		this.v2_rescheduled_more_than_twice = v2_rescheduled_more_than_twice;
		this.v2_principal_regularly_amortized_period = v2_principal_regularly_amortized_period;
		this.v2_repayment_after_grace_period_exceed_oneyr = v2_repayment_after_grace_period_exceed_oneyr;
		this.v2_bullet_repayment = v2_bullet_repayment;
		this.v2_interest_profit_overdue_pl = v2_interest_profit_overdue_pl;
		this.v2_interest_profit_overdue_intsus = v2_interest_profit_overdue_intsus;
		this.v2_specific_provisions = v2_specific_provisions;
		this.v3_product = v3_product;
		this.v3_rescheduled_amt = v3_rescheduled_amt;
		this.v3_rescheduled_once = v3_rescheduled_once;
		this.v3_rescheduled_twice = v3_rescheduled_twice;
		this.v3_rescheduled_more_than_twice = v3_rescheduled_more_than_twice;
		this.v3_principal_regularly_amortized_period = v3_principal_regularly_amortized_period;
		this.v3_repayment_after_grace_period_exceed_oneyr = v3_repayment_after_grace_period_exceed_oneyr;
		this.v3_bullet_repayment = v3_bullet_repayment;
		this.v3_interest_profit_overdue_pl = v3_interest_profit_overdue_pl;
		this.v3_interest_profit_overdue_intsus = v3_interest_profit_overdue_intsus;
		this.v3_specific_provisions = v3_specific_provisions;
		this.v4_product = v4_product;
		this.v4_rescheduled_amt = v4_rescheduled_amt;
		this.v4_rescheduled_once = v4_rescheduled_once;
		this.v4_rescheduled_twice = v4_rescheduled_twice;
		this.v4_rescheduled_more_than_twice = v4_rescheduled_more_than_twice;
		this.v4_principal_regularly_amortized_period = v4_principal_regularly_amortized_period;
		this.v4_repayment_after_grace_period_exceed_oneyr = v4_repayment_after_grace_period_exceed_oneyr;
		this.v4_bullet_repayment = v4_bullet_repayment;
		this.v4_interest_profit_overdue_pl = v4_interest_profit_overdue_pl;
		this.v4_interest_profit_overdue_intsus = v4_interest_profit_overdue_intsus;
		this.v4_specific_provisions = v4_specific_provisions;
		this.v5_product = v5_product;
		this.v5_rescheduled_amt = v5_rescheduled_amt;
		this.v5_rescheduled_once = v5_rescheduled_once;
		this.v5_rescheduled_twice = v5_rescheduled_twice;
		this.v5_rescheduled_more_than_twice = v5_rescheduled_more_than_twice;
		this.v5_principal_regularly_amortized_period = v5_principal_regularly_amortized_period;
		this.v5_repayment_after_grace_period_exceed_oneyr = v5_repayment_after_grace_period_exceed_oneyr;
		this.v5_bullet_repayment = v5_bullet_repayment;
		this.v5_interest_profit_overdue_pl = v5_interest_profit_overdue_pl;
		this.v5_interest_profit_overdue_intsus = v5_interest_profit_overdue_intsus;
		this.v5_specific_provisions = v5_specific_provisions;
		this.v6_product = v6_product;
		this.v6_rescheduled_amt = v6_rescheduled_amt;
		this.v6_rescheduled_once = v6_rescheduled_once;
		this.v6_rescheduled_twice = v6_rescheduled_twice;
		this.v6_rescheduled_more_than_twice = v6_rescheduled_more_than_twice;
		this.v6_principal_regularly_amortized_period = v6_principal_regularly_amortized_period;
		this.v6_repayment_after_grace_period_exceed_oneyr = v6_repayment_after_grace_period_exceed_oneyr;
		this.v6_bullet_repayment = v6_bullet_repayment;
		this.v6_interest_profit_overdue_pl = v6_interest_profit_overdue_pl;
		this.v6_interest_profit_overdue_intsus = v6_interest_profit_overdue_intsus;
		this.v6_specific_provisions = v6_specific_provisions;
		this.v7_product = v7_product;
		this.v7_rescheduled_amt = v7_rescheduled_amt;
		this.v7_rescheduled_once = v7_rescheduled_once;
		this.v7_rescheduled_twice = v7_rescheduled_twice;
		this.v7_rescheduled_more_than_twice = v7_rescheduled_more_than_twice;
		this.v7_principal_regularly_amortized_period = v7_principal_regularly_amortized_period;
		this.v7_repayment_after_grace_period_exceed_oneyr = v7_repayment_after_grace_period_exceed_oneyr;
		this.v7_bullet_repayment = v7_bullet_repayment;
		this.v7_interest_profit_overdue_pl = v7_interest_profit_overdue_pl;
		this.v7_interest_profit_overdue_intsus = v7_interest_profit_overdue_intsus;
		this.v7_specific_provisions = v7_specific_provisions;
		this.w1_product = w1_product;
		this.w1_rescheduled_amt = w1_rescheduled_amt;
		this.w1_rescheduled_once = w1_rescheduled_once;
		this.w1_rescheduled_twice = w1_rescheduled_twice;
		this.w1_rescheduled_more_than_twice = w1_rescheduled_more_than_twice;
		this.w1_principal_regularly_amortized_period = w1_principal_regularly_amortized_period;
		this.w1_repayment_after_grace_period_exceed_oneyr = w1_repayment_after_grace_period_exceed_oneyr;
		this.w1_bullet_repayment = w1_bullet_repayment;
		this.w1_interest_profit_overdue_pl = w1_interest_profit_overdue_pl;
		this.w1_interest_profit_overdue_intsus = w1_interest_profit_overdue_intsus;
		this.w1_specific_provisions = w1_specific_provisions;
		this.x1_product = x1_product;
		this.x1_rescheduled_amt = x1_rescheduled_amt;
		this.x1_rescheduled_once = x1_rescheduled_once;
		this.x1_rescheduled_twice = x1_rescheduled_twice;
		this.x1_rescheduled_more_than_twice = x1_rescheduled_more_than_twice;
		this.x1_principal_regularly_amortized_period = x1_principal_regularly_amortized_period;
		this.x1_repayment_after_grace_period_exceed_oneyr = x1_repayment_after_grace_period_exceed_oneyr;
		this.x1_bullet_repayment = x1_bullet_repayment;
		this.x1_interest_profit_overdue_pl = x1_interest_profit_overdue_pl;
		this.x1_interest_profit_overdue_intsus = x1_interest_profit_overdue_intsus;
		this.x1_specific_provisions = x1_specific_provisions;
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

	public BRF65_Entity() {
		super();
		// TODO Auto-generated constructor stub
	}

}
