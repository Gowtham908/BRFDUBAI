package com.bornfire.xbrl.entities.BRBS;

import java.math.BigDecimal;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="BRF67_SUMMARYTABLE")


public class BRF67_ENTITY {
	
	private String	r1_product;
	private BigDecimal	r1_noacct_uae;
	private BigDecimal	r1_balos_uae;
	private BigDecimal	r1_noacct_other;
	private BigDecimal	r1_balos_other;
	private BigDecimal	r1_noacct_totaldeposit;
	private BigDecimal	r1_balos_totaldeposit;
	private String	r2_product;
	private BigDecimal	r2_noacct_uae;
	private BigDecimal	r2_balos_uae;
	private BigDecimal	r2_noacct_other;
	private BigDecimal	r2_balos_other;
	private BigDecimal	r2_noacct_totaldeposit;
	private BigDecimal	r2_balos_totaldeposit;
	private String	r3_product;
	private BigDecimal	r3_noacct_uae;
	private BigDecimal	r3_balos_uae;
	private BigDecimal	r3_noacct_other;
	private BigDecimal	r3_balos_other;
	private BigDecimal	r3_noacct_totaldeposit;
	private BigDecimal	r3_balos_totaldeposit;
	private String	r4_product;
	private BigDecimal	r4_noacct_uae;
	private BigDecimal	r4_balos_uae;
	private BigDecimal	r4_noacct_other;
	private BigDecimal	r4_balos_other;
	private BigDecimal	r4_noacct_totaldeposit;
	private BigDecimal	r4_balos_totaldeposit;
	private String	r5_product;
	private BigDecimal	r5_noacct_uae;
	private BigDecimal	r5_balos_uae;
	private BigDecimal	r5_noacct_other;
	private BigDecimal	r5_balos_other;
	private BigDecimal	r5_noacct_totaldeposit;
	private BigDecimal	r5_balos_totaldeposit;
	private String	r6_product;
	private BigDecimal	r6_noacct_uae;
	private BigDecimal	r6_balos_uae;
	private BigDecimal	r6_noacct_other;
	private BigDecimal	r6_balos_other;
	private BigDecimal	r6_noacct_totaldeposit;
	private BigDecimal	r6_balos_totaldeposit;
	private String	r7_product;
	private BigDecimal	r7_noacct_uae;
	private BigDecimal	r7_balos_uae;
	private BigDecimal	r7_noacct_other;
	private BigDecimal	r7_balos_other;
	private BigDecimal	r7_noacct_totaldeposit;
	private BigDecimal	r7_balos_totaldeposit;
	private String	r8_product;
	private BigDecimal	r8_noacct_uae;
	private BigDecimal	r8_balos_uae;
	private BigDecimal	r8_noacct_other;
	private BigDecimal	r8_balos_other;
	private BigDecimal	r8_noacct_totaldeposit;
	private BigDecimal	r8_balos_totaldeposit;
	private String	s1_product;
	private BigDecimal	s1_noacct_uae;
	private BigDecimal	s1_balos_uae;
	private BigDecimal	s1_noacct_other;
	private BigDecimal	s1_balos_other;
	private BigDecimal	s1_noacct_totaldeposit;
	private BigDecimal	s1_balos_totaldeposit;
	private String	s2_product;
	private BigDecimal	s2_noacct_uae;
	private BigDecimal	s2_balos_uae;
	private BigDecimal	s2_noacct_other;
	private BigDecimal	s2_balos_other;
	private BigDecimal	s2_noacct_totaldeposit;
	private BigDecimal	s2_balos_totaldeposit;
	private String	s3_product;
	private BigDecimal	s3_noacct_uae;
	private BigDecimal	s3_balos_uae;
	private BigDecimal	s3_noacct_other;
	private BigDecimal	s3_balos_other;
	private BigDecimal	s3_noacct_totaldeposit;
	private BigDecimal	s3_balos_totaldeposit;
	private String	s4_product;
	private BigDecimal	s4_noacct_uae;
	private BigDecimal	s4_balos_uae;
	private BigDecimal	s4_noacct_other;
	private BigDecimal	s4_balos_other;
	private BigDecimal	s4_noacct_totaldeposit;
	private BigDecimal	s4_balos_totaldeposit;
	private String	s5_product;
	private BigDecimal	s5_noacct_uae;
	private BigDecimal	s5_balos_uae;
	private BigDecimal	s5_noacct_other;
	private BigDecimal	s5_balos_other;
	private BigDecimal	s5_noacct_totaldeposit;
	private BigDecimal	s5_balos_totaldeposit;
	private String	s6_product;
	private BigDecimal	s6_noacct_uae;
	private BigDecimal	s6_balos_uae;
	private BigDecimal	s6_noacct_other;
	private BigDecimal	s6_balos_other;
	private BigDecimal	s6_noacct_totaldeposit;
	private BigDecimal	s6_balos_totaldeposit;
	private String	s7_product;
	private BigDecimal	s7_noacct_uae;
	private BigDecimal	s7_balos_uae;
	private BigDecimal	s7_noacct_other;
	private BigDecimal	s7_balos_other;
	private BigDecimal	s7_noacct_totaldeposit;
	private BigDecimal	s7_balos_totaldeposit;
	private String	t1_product;
	private BigDecimal	t1_noacct_uae;
	private BigDecimal	t1_balos_uae;
	private BigDecimal	t1_noacct_other;
	private BigDecimal	t1_balos_other;
	private BigDecimal	t1_noacct_totaldeposit;
	private BigDecimal	t1_balos_totaldeposit;
	@Id
	private Date	report_date;
	private Date	report_from_date;
	private	Date report_to_date;
	private String	entity_flg;
	private String	modify_flg;
	private String	del_flg;
	private String	report_code;
	private Date	report_submit_date;
	private String	repdesc;
	private String	frequency;
	
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
	public String getR1_product() {
		return r1_product;
	}
	public void setR1_product(String r1_product) {
		this.r1_product = r1_product;
	}
	public BigDecimal getR1_noacct_uae() {
		return r1_noacct_uae;
	}
	public void setR1_noacct_uae(BigDecimal r1_noacct_uae) {
		this.r1_noacct_uae = r1_noacct_uae;
	}
	public BigDecimal getR1_balos_uae() {
		return r1_balos_uae;
	}
	public void setR1_balos_uae(BigDecimal r1_balos_uae) {
		this.r1_balos_uae = r1_balos_uae;
	}
	public BigDecimal getR1_noacct_other() {
		return r1_noacct_other;
	}
	public void setR1_noacct_other(BigDecimal r1_noacct_other) {
		this.r1_noacct_other = r1_noacct_other;
	}
	public BigDecimal getR1_balos_other() {
		return r1_balos_other;
	}
	public void setR1_balos_other(BigDecimal r1_balos_other) {
		this.r1_balos_other = r1_balos_other;
	}
	public BigDecimal getR1_noacct_totaldeposit() {
		return r1_noacct_totaldeposit;
	}
	public void setR1_noacct_totaldeposit(BigDecimal r1_noacct_totaldeposit) {
		this.r1_noacct_totaldeposit = r1_noacct_totaldeposit;
	}
	public BigDecimal getR1_balos_totaldeposit() {
		return r1_balos_totaldeposit;
	}
	public void setR1_balos_totaldeposit(BigDecimal r1_balos_totaldeposit) {
		this.r1_balos_totaldeposit = r1_balos_totaldeposit;
	}
	public String getR2_product() {
		return r2_product;
	}
	public void setR2_product(String r2_product) {
		this.r2_product = r2_product;
	}
	public BigDecimal getR2_noacct_uae() {
		return r2_noacct_uae;
	}
	public void setR2_noacct_uae(BigDecimal r2_noacct_uae) {
		this.r2_noacct_uae = r2_noacct_uae;
	}
	public BigDecimal getR2_balos_uae() {
		return r2_balos_uae;
	}
	public void setR2_balos_uae(BigDecimal r2_balos_uae) {
		this.r2_balos_uae = r2_balos_uae;
	}
	public BigDecimal getR2_noacct_other() {
		return r2_noacct_other;
	}
	public void setR2_noacct_other(BigDecimal r2_noacct_other) {
		this.r2_noacct_other = r2_noacct_other;
	}
	public BigDecimal getR2_balos_other() {
		return r2_balos_other;
	}
	public void setR2_balos_other(BigDecimal r2_balos_other) {
		this.r2_balos_other = r2_balos_other;
	}
	public BigDecimal getR2_noacct_totaldeposit() {
		return r2_noacct_totaldeposit;
	}
	public void setR2_noacct_totaldeposit(BigDecimal r2_noacct_totaldeposit) {
		this.r2_noacct_totaldeposit = r2_noacct_totaldeposit;
	}
	public BigDecimal getR2_balos_totaldeposit() {
		return r2_balos_totaldeposit;
	}
	public void setR2_balos_totaldeposit(BigDecimal r2_balos_totaldeposit) {
		this.r2_balos_totaldeposit = r2_balos_totaldeposit;
	}
	public String getR3_product() {
		return r3_product;
	}
	public void setR3_product(String r3_product) {
		this.r3_product = r3_product;
	}
	public BigDecimal getR3_noacct_uae() {
		return r3_noacct_uae;
	}
	public void setR3_noacct_uae(BigDecimal r3_noacct_uae) {
		this.r3_noacct_uae = r3_noacct_uae;
	}
	public BigDecimal getR3_balos_uae() {
		return r3_balos_uae;
	}
	public void setR3_balos_uae(BigDecimal r3_balos_uae) {
		this.r3_balos_uae = r3_balos_uae;
	}
	public BigDecimal getR3_noacct_other() {
		return r3_noacct_other;
	}
	public void setR3_noacct_other(BigDecimal r3_noacct_other) {
		this.r3_noacct_other = r3_noacct_other;
	}
	public BigDecimal getR3_balos_other() {
		return r3_balos_other;
	}
	public void setR3_balos_other(BigDecimal r3_balos_other) {
		this.r3_balos_other = r3_balos_other;
	}
	public BigDecimal getR3_noacct_totaldeposit() {
		return r3_noacct_totaldeposit;
	}
	public void setR3_noacct_totaldeposit(BigDecimal r3_noacct_totaldeposit) {
		this.r3_noacct_totaldeposit = r3_noacct_totaldeposit;
	}
	public BigDecimal getR3_balos_totaldeposit() {
		return r3_balos_totaldeposit;
	}
	public void setR3_balos_totaldeposit(BigDecimal r3_balos_totaldeposit) {
		this.r3_balos_totaldeposit = r3_balos_totaldeposit;
	}
	public String getR4_product() {
		return r4_product;
	}
	public void setR4_product(String r4_product) {
		this.r4_product = r4_product;
	}
	public BigDecimal getR4_noacct_uae() {
		return r4_noacct_uae;
	}
	public void setR4_noacct_uae(BigDecimal r4_noacct_uae) {
		this.r4_noacct_uae = r4_noacct_uae;
	}
	public BigDecimal getR4_balos_uae() {
		return r4_balos_uae;
	}
	public void setR4_balos_uae(BigDecimal r4_balos_uae) {
		this.r4_balos_uae = r4_balos_uae;
	}
	public BigDecimal getR4_noacct_other() {
		return r4_noacct_other;
	}
	public void setR4_noacct_other(BigDecimal r4_noacct_other) {
		this.r4_noacct_other = r4_noacct_other;
	}
	public BigDecimal getR4_balos_other() {
		return r4_balos_other;
	}
	public void setR4_balos_other(BigDecimal r4_balos_other) {
		this.r4_balos_other = r4_balos_other;
	}
	public BigDecimal getR4_noacct_totaldeposit() {
		return r4_noacct_totaldeposit;
	}
	public void setR4_noacct_totaldeposit(BigDecimal r4_noacct_totaldeposit) {
		this.r4_noacct_totaldeposit = r4_noacct_totaldeposit;
	}
	public BigDecimal getR4_balos_totaldeposit() {
		return r4_balos_totaldeposit;
	}
	public void setR4_balos_totaldeposit(BigDecimal r4_balos_totaldeposit) {
		this.r4_balos_totaldeposit = r4_balos_totaldeposit;
	}
	public String getR5_product() {
		return r5_product;
	}
	public void setR5_product(String r5_product) {
		this.r5_product = r5_product;
	}
	public BigDecimal getR5_noacct_uae() {
		return r5_noacct_uae;
	}
	public void setR5_noacct_uae(BigDecimal r5_noacct_uae) {
		this.r5_noacct_uae = r5_noacct_uae;
	}
	public BigDecimal getR5_balos_uae() {
		return r5_balos_uae;
	}
	public void setR5_balos_uae(BigDecimal r5_balos_uae) {
		this.r5_balos_uae = r5_balos_uae;
	}
	public BigDecimal getR5_noacct_other() {
		return r5_noacct_other;
	}
	public void setR5_noacct_other(BigDecimal r5_noacct_other) {
		this.r5_noacct_other = r5_noacct_other;
	}
	public BigDecimal getR5_balos_other() {
		return r5_balos_other;
	}
	public void setR5_balos_other(BigDecimal r5_balos_other) {
		this.r5_balos_other = r5_balos_other;
	}
	public BigDecimal getR5_noacct_totaldeposit() {
		return r5_noacct_totaldeposit;
	}
	public void setR5_noacct_totaldeposit(BigDecimal r5_noacct_totaldeposit) {
		this.r5_noacct_totaldeposit = r5_noacct_totaldeposit;
	}
	public BigDecimal getR5_balos_totaldeposit() {
		return r5_balos_totaldeposit;
	}
	public void setR5_balos_totaldeposit(BigDecimal r5_balos_totaldeposit) {
		this.r5_balos_totaldeposit = r5_balos_totaldeposit;
	}
	public String getR6_product() {
		return r6_product;
	}
	public void setR6_product(String r6_product) {
		this.r6_product = r6_product;
	}
	public BigDecimal getR6_noacct_uae() {
		return r6_noacct_uae;
	}
	public void setR6_noacct_uae(BigDecimal r6_noacct_uae) {
		this.r6_noacct_uae = r6_noacct_uae;
	}
	public BigDecimal getR6_balos_uae() {
		return r6_balos_uae;
	}
	public void setR6_balos_uae(BigDecimal r6_balos_uae) {
		this.r6_balos_uae = r6_balos_uae;
	}
	public BigDecimal getR6_noacct_other() {
		return r6_noacct_other;
	}
	public void setR6_noacct_other(BigDecimal r6_noacct_other) {
		this.r6_noacct_other = r6_noacct_other;
	}
	public BigDecimal getR6_balos_other() {
		return r6_balos_other;
	}
	public void setR6_balos_other(BigDecimal r6_balos_other) {
		this.r6_balos_other = r6_balos_other;
	}
	public BigDecimal getR6_noacct_totaldeposit() {
		return r6_noacct_totaldeposit;
	}
	public void setR6_noacct_totaldeposit(BigDecimal r6_noacct_totaldeposit) {
		this.r6_noacct_totaldeposit = r6_noacct_totaldeposit;
	}
	public BigDecimal getR6_balos_totaldeposit() {
		return r6_balos_totaldeposit;
	}
	public void setR6_balos_totaldeposit(BigDecimal r6_balos_totaldeposit) {
		this.r6_balos_totaldeposit = r6_balos_totaldeposit;
	}
	public String getR7_product() {
		return r7_product;
	}
	public void setR7_product(String r7_product) {
		this.r7_product = r7_product;
	}
	public BigDecimal getR7_noacct_uae() {
		return r7_noacct_uae;
	}
	public void setR7_noacct_uae(BigDecimal r7_noacct_uae) {
		this.r7_noacct_uae = r7_noacct_uae;
	}
	public BigDecimal getR7_balos_uae() {
		return r7_balos_uae;
	}
	public void setR7_balos_uae(BigDecimal r7_balos_uae) {
		this.r7_balos_uae = r7_balos_uae;
	}
	public BigDecimal getR7_noacct_other() {
		return r7_noacct_other;
	}
	public void setR7_noacct_other(BigDecimal r7_noacct_other) {
		this.r7_noacct_other = r7_noacct_other;
	}
	public BigDecimal getR7_balos_other() {
		return r7_balos_other;
	}
	public void setR7_balos_other(BigDecimal r7_balos_other) {
		this.r7_balos_other = r7_balos_other;
	}
	public BigDecimal getR7_noacct_totaldeposit() {
		return r7_noacct_totaldeposit;
	}
	public void setR7_noacct_totaldeposit(BigDecimal r7_noacct_totaldeposit) {
		this.r7_noacct_totaldeposit = r7_noacct_totaldeposit;
	}
	public BigDecimal getR7_balos_totaldeposit() {
		return r7_balos_totaldeposit;
	}
	public void setR7_balos_totaldeposit(BigDecimal r7_balos_totaldeposit) {
		this.r7_balos_totaldeposit = r7_balos_totaldeposit;
	}
	public String getR8_product() {
		return r8_product;
	}
	public void setR8_product(String r8_product) {
		this.r8_product = r8_product;
	}
	public BigDecimal getR8_noacct_uae() {
		return r8_noacct_uae;
	}
	public void setR8_noacct_uae(BigDecimal r8_noacct_uae) {
		this.r8_noacct_uae = r8_noacct_uae;
	}
	public BigDecimal getR8_balos_uae() {
		return r8_balos_uae;
	}
	public void setR8_balos_uae(BigDecimal r8_balos_uae) {
		this.r8_balos_uae = r8_balos_uae;
	}
	public BigDecimal getR8_noacct_other() {
		return r8_noacct_other;
	}
	public void setR8_noacct_other(BigDecimal r8_noacct_other) {
		this.r8_noacct_other = r8_noacct_other;
	}
	public BigDecimal getR8_balos_other() {
		return r8_balos_other;
	}
	public void setR8_balos_other(BigDecimal r8_balos_other) {
		this.r8_balos_other = r8_balos_other;
	}
	public BigDecimal getR8_noacct_totaldeposit() {
		return r8_noacct_totaldeposit;
	}
	public void setR8_noacct_totaldeposit(BigDecimal r8_noacct_totaldeposit) {
		this.r8_noacct_totaldeposit = r8_noacct_totaldeposit;
	}
	public BigDecimal getR8_balos_totaldeposit() {
		return r8_balos_totaldeposit;
	}
	public void setR8_balos_totaldeposit(BigDecimal r8_balos_totaldeposit) {
		this.r8_balos_totaldeposit = r8_balos_totaldeposit;
	}
	public String getS1_product() {
		return s1_product;
	}
	public void setS1_product(String s1_product) {
		this.s1_product = s1_product;
	}
	public BigDecimal getS1_noacct_uae() {
		return s1_noacct_uae;
	}
	public void setS1_noacct_uae(BigDecimal s1_noacct_uae) {
		this.s1_noacct_uae = s1_noacct_uae;
	}
	public BigDecimal getS1_balos_uae() {
		return s1_balos_uae;
	}
	public void setS1_balos_uae(BigDecimal s1_balos_uae) {
		this.s1_balos_uae = s1_balos_uae;
	}
	public BigDecimal getS1_noacct_other() {
		return s1_noacct_other;
	}
	public void setS1_noacct_other(BigDecimal s1_noacct_other) {
		this.s1_noacct_other = s1_noacct_other;
	}
	public BigDecimal getS1_balos_other() {
		return s1_balos_other;
	}
	public void setS1_balos_other(BigDecimal s1_balos_other) {
		this.s1_balos_other = s1_balos_other;
	}
	public BigDecimal getS1_noacct_totaldeposit() {
		return s1_noacct_totaldeposit;
	}
	public void setS1_noacct_totaldeposit(BigDecimal s1_noacct_totaldeposit) {
		this.s1_noacct_totaldeposit = s1_noacct_totaldeposit;
	}
	public BigDecimal getS1_balos_totaldeposit() {
		return s1_balos_totaldeposit;
	}
	public void setS1_balos_totaldeposit(BigDecimal s1_balos_totaldeposit) {
		this.s1_balos_totaldeposit = s1_balos_totaldeposit;
	}
	public String getS2_product() {
		return s2_product;
	}
	public void setS2_product(String s2_product) {
		this.s2_product = s2_product;
	}
	public BigDecimal getS2_noacct_uae() {
		return s2_noacct_uae;
	}
	public void setS2_noacct_uae(BigDecimal s2_noacct_uae) {
		this.s2_noacct_uae = s2_noacct_uae;
	}
	public BigDecimal getS2_balos_uae() {
		return s2_balos_uae;
	}
	public void setS2_balos_uae(BigDecimal s2_balos_uae) {
		this.s2_balos_uae = s2_balos_uae;
	}
	public BigDecimal getS2_noacct_other() {
		return s2_noacct_other;
	}
	public void setS2_noacct_other(BigDecimal s2_noacct_other) {
		this.s2_noacct_other = s2_noacct_other;
	}
	public BigDecimal getS2_balos_other() {
		return s2_balos_other;
	}
	public void setS2_balos_other(BigDecimal s2_balos_other) {
		this.s2_balos_other = s2_balos_other;
	}
	public BigDecimal getS2_noacct_totaldeposit() {
		return s2_noacct_totaldeposit;
	}
	public void setS2_noacct_totaldeposit(BigDecimal s2_noacct_totaldeposit) {
		this.s2_noacct_totaldeposit = s2_noacct_totaldeposit;
	}
	public BigDecimal getS2_balos_totaldeposit() {
		return s2_balos_totaldeposit;
	}
	public void setS2_balos_totaldeposit(BigDecimal s2_balos_totaldeposit) {
		this.s2_balos_totaldeposit = s2_balos_totaldeposit;
	}
	public String getS3_product() {
		return s3_product;
	}
	public void setS3_product(String s3_product) {
		this.s3_product = s3_product;
	}
	public BigDecimal getS3_noacct_uae() {
		return s3_noacct_uae;
	}
	public void setS3_noacct_uae(BigDecimal s3_noacct_uae) {
		this.s3_noacct_uae = s3_noacct_uae;
	}
	public BigDecimal getS3_balos_uae() {
		return s3_balos_uae;
	}
	public void setS3_balos_uae(BigDecimal s3_balos_uae) {
		this.s3_balos_uae = s3_balos_uae;
	}
	public BigDecimal getS3_noacct_other() {
		return s3_noacct_other;
	}
	public void setS3_noacct_other(BigDecimal s3_noacct_other) {
		this.s3_noacct_other = s3_noacct_other;
	}
	public BigDecimal getS3_balos_other() {
		return s3_balos_other;
	}
	public void setS3_balos_other(BigDecimal s3_balos_other) {
		this.s3_balos_other = s3_balos_other;
	}
	public BigDecimal getS3_noacct_totaldeposit() {
		return s3_noacct_totaldeposit;
	}
	public void setS3_noacct_totaldeposit(BigDecimal s3_noacct_totaldeposit) {
		this.s3_noacct_totaldeposit = s3_noacct_totaldeposit;
	}
	public BigDecimal getS3_balos_totaldeposit() {
		return s3_balos_totaldeposit;
	}
	public void setS3_balos_totaldeposit(BigDecimal s3_balos_totaldeposit) {
		this.s3_balos_totaldeposit = s3_balos_totaldeposit;
	}
	public String getS4_product() {
		return s4_product;
	}
	public void setS4_product(String s4_product) {
		this.s4_product = s4_product;
	}
	public BigDecimal getS4_noacct_uae() {
		return s4_noacct_uae;
	}
	public void setS4_noacct_uae(BigDecimal s4_noacct_uae) {
		this.s4_noacct_uae = s4_noacct_uae;
	}
	public BigDecimal getS4_balos_uae() {
		return s4_balos_uae;
	}
	public void setS4_balos_uae(BigDecimal s4_balos_uae) {
		this.s4_balos_uae = s4_balos_uae;
	}
	public BigDecimal getS4_noacct_other() {
		return s4_noacct_other;
	}
	public void setS4_noacct_other(BigDecimal s4_noacct_other) {
		this.s4_noacct_other = s4_noacct_other;
	}
	public BigDecimal getS4_balos_other() {
		return s4_balos_other;
	}
	public void setS4_balos_other(BigDecimal s4_balos_other) {
		this.s4_balos_other = s4_balos_other;
	}
	public BigDecimal getS4_noacct_totaldeposit() {
		return s4_noacct_totaldeposit;
	}
	public void setS4_noacct_totaldeposit(BigDecimal s4_noacct_totaldeposit) {
		this.s4_noacct_totaldeposit = s4_noacct_totaldeposit;
	}
	public BigDecimal getS4_balos_totaldeposit() {
		return s4_balos_totaldeposit;
	}
	public void setS4_balos_totaldeposit(BigDecimal s4_balos_totaldeposit) {
		this.s4_balos_totaldeposit = s4_balos_totaldeposit;
	}
	public String getS5_product() {
		return s5_product;
	}
	public void setS5_product(String s5_product) {
		this.s5_product = s5_product;
	}
	public BigDecimal getS5_noacct_uae() {
		return s5_noacct_uae;
	}
	public void setS5_noacct_uae(BigDecimal s5_noacct_uae) {
		this.s5_noacct_uae = s5_noacct_uae;
	}
	public BigDecimal getS5_balos_uae() {
		return s5_balos_uae;
	}
	public void setS5_balos_uae(BigDecimal s5_balos_uae) {
		this.s5_balos_uae = s5_balos_uae;
	}
	public BigDecimal getS5_noacct_other() {
		return s5_noacct_other;
	}
	public void setS5_noacct_other(BigDecimal s5_noacct_other) {
		this.s5_noacct_other = s5_noacct_other;
	}
	public BigDecimal getS5_balos_other() {
		return s5_balos_other;
	}
	public void setS5_balos_other(BigDecimal s5_balos_other) {
		this.s5_balos_other = s5_balos_other;
	}
	public BigDecimal getS5_noacct_totaldeposit() {
		return s5_noacct_totaldeposit;
	}
	public void setS5_noacct_totaldeposit(BigDecimal s5_noacct_totaldeposit) {
		this.s5_noacct_totaldeposit = s5_noacct_totaldeposit;
	}
	public BigDecimal getS5_balos_totaldeposit() {
		return s5_balos_totaldeposit;
	}
	public void setS5_balos_totaldeposit(BigDecimal s5_balos_totaldeposit) {
		this.s5_balos_totaldeposit = s5_balos_totaldeposit;
	}
	public String getS6_product() {
		return s6_product;
	}
	public void setS6_product(String s6_product) {
		this.s6_product = s6_product;
	}
	public BigDecimal getS6_noacct_uae() {
		return s6_noacct_uae;
	}
	public void setS6_noacct_uae(BigDecimal s6_noacct_uae) {
		this.s6_noacct_uae = s6_noacct_uae;
	}
	public BigDecimal getS6_balos_uae() {
		return s6_balos_uae;
	}
	public void setS6_balos_uae(BigDecimal s6_balos_uae) {
		this.s6_balos_uae = s6_balos_uae;
	}
	public BigDecimal getS6_noacct_other() {
		return s6_noacct_other;
	}
	public void setS6_noacct_other(BigDecimal s6_noacct_other) {
		this.s6_noacct_other = s6_noacct_other;
	}
	public BigDecimal getS6_balos_other() {
		return s6_balos_other;
	}
	public void setS6_balos_other(BigDecimal s6_balos_other) {
		this.s6_balos_other = s6_balos_other;
	}
	public BigDecimal getS6_noacct_totaldeposit() {
		return s6_noacct_totaldeposit;
	}
	public void setS6_noacct_totaldeposit(BigDecimal s6_noacct_totaldeposit) {
		this.s6_noacct_totaldeposit = s6_noacct_totaldeposit;
	}
	public BigDecimal getS6_balos_totaldeposit() {
		return s6_balos_totaldeposit;
	}
	public void setS6_balos_totaldeposit(BigDecimal s6_balos_totaldeposit) {
		this.s6_balos_totaldeposit = s6_balos_totaldeposit;
	}
	public String getS7_product() {
		return s7_product;
	}
	public void setS7_product(String s7_product) {
		this.s7_product = s7_product;
	}
	public BigDecimal getS7_noacct_uae() {
		return s7_noacct_uae;
	}
	public void setS7_noacct_uae(BigDecimal s7_noacct_uae) {
		this.s7_noacct_uae = s7_noacct_uae;
	}
	public BigDecimal getS7_balos_uae() {
		return s7_balos_uae;
	}
	public void setS7_balos_uae(BigDecimal s7_balos_uae) {
		this.s7_balos_uae = s7_balos_uae;
	}
	public BigDecimal getS7_noacct_other() {
		return s7_noacct_other;
	}
	public void setS7_noacct_other(BigDecimal s7_noacct_other) {
		this.s7_noacct_other = s7_noacct_other;
	}
	public BigDecimal getS7_balos_other() {
		return s7_balos_other;
	}
	public void setS7_balos_other(BigDecimal s7_balos_other) {
		this.s7_balos_other = s7_balos_other;
	}
	public BigDecimal getS7_noacct_totaldeposit() {
		return s7_noacct_totaldeposit;
	}
	public void setS7_noacct_totaldeposit(BigDecimal s7_noacct_totaldeposit) {
		this.s7_noacct_totaldeposit = s7_noacct_totaldeposit;
	}
	public BigDecimal getS7_balos_totaldeposit() {
		return s7_balos_totaldeposit;
	}
	public void setS7_balos_totaldeposit(BigDecimal s7_balos_totaldeposit) {
		this.s7_balos_totaldeposit = s7_balos_totaldeposit;
	}
	public String getT1_product() {
		return t1_product;
	}
	public void setT1_product(String t1_product) {
		this.t1_product = t1_product;
	}
	public BigDecimal getT1_noacct_uae() {
		return t1_noacct_uae;
	}
	public void setT1_noacct_uae(BigDecimal t1_noacct_uae) {
		this.t1_noacct_uae = t1_noacct_uae;
	}
	public BigDecimal getT1_balos_uae() {
		return t1_balos_uae;
	}
	public void setT1_balos_uae(BigDecimal t1_balos_uae) {
		this.t1_balos_uae = t1_balos_uae;
	}
	public BigDecimal getT1_noacct_other() {
		return t1_noacct_other;
	}
	public void setT1_noacct_other(BigDecimal t1_noacct_other) {
		this.t1_noacct_other = t1_noacct_other;
	}
	public BigDecimal getT1_balos_other() {
		return t1_balos_other;
	}
	public void setT1_balos_other(BigDecimal t1_balos_other) {
		this.t1_balos_other = t1_balos_other;
	}
	public BigDecimal getT1_noacct_totaldeposit() {
		return t1_noacct_totaldeposit;
	}
	public void setT1_noacct_totaldeposit(BigDecimal t1_noacct_totaldeposit) {
		this.t1_noacct_totaldeposit = t1_noacct_totaldeposit;
	}
	public BigDecimal getT1_balos_totaldeposit() {
		return t1_balos_totaldeposit;
	}
	public void setT1_balos_totaldeposit(BigDecimal t1_balos_totaldeposit) {
		this.t1_balos_totaldeposit = t1_balos_totaldeposit;
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
	public BRF67_ENTITY() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
