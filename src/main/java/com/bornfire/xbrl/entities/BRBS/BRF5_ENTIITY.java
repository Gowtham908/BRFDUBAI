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
@Table(name="BRF_5")
public class BRF5_ENTIITY{
	
	private BigDecimal	r1_amt_total_security;
	private BigDecimal	r1_aed_equivalent;
	private BigDecimal	r1_market_value;
	private BigDecimal	r2_amt_total_security;
	private BigDecimal	r2_aed_equivalent;
	private BigDecimal	r2_market_value;
	private String	r2_security_id;
	private String	r2_country;
	private String	r2_rating;
	private String	r2_counter_party;
	private String	r2_row_valid;
	private BigDecimal	r3_amt_total_security;
	private BigDecimal	r3_aed_equivalent;
	private BigDecimal	r3_market_value;
	private BigDecimal	r4_amt_total_security;
	private BigDecimal	r4_aed_equivalent;
	private BigDecimal	r4_market_value;
	private String	r4_security_id;
	private String	r4_country;
	private String	r4_counter_party;
	private String	r4_row_valid;
	private BigDecimal	r5_amt_total_security;
	private BigDecimal	r5_aed_equivalent;
	private BigDecimal	r5_market_value;
	private BigDecimal	r6_amt_total_security;
	private BigDecimal	r6_aed_equivalent;
	private BigDecimal	r6_market_value;
	private String	r6_security_id;
	private String	r6_country;
	private String	r6_counter_party;
	private String	r6_row_valid;
	private BigDecimal	r7_amt_total_security;
	private BigDecimal	r7_aed_equivalent;
	private BigDecimal	r7_market_value;
	private BigDecimal	r8_amt_total_security;
	private BigDecimal	r8_aed_equivalent;
	private BigDecimal	r8_market_value;
	private BigDecimal	r9_amt_total_security;
	private BigDecimal	r9_aed_equivalent;
	private BigDecimal	r9_market_value;
	private BigDecimal	r10_amt_total_security;
	private BigDecimal	r10_aed_equivalent;
	private BigDecimal	r10_market_value;
	private String	r10_security_id;
	private String	r10_country;
	private String	r10_rating;
	private String	r10_counter_party;
	private String	r10_row_valid;
	private BigDecimal	r11_amt_total_security;
	private BigDecimal	r11_aed_equivalent;
	private BigDecimal	r11_market_value;
	private BigDecimal	r12_amt_total_security;
	private BigDecimal	r12_aed_equivalent;
	private BigDecimal	r12_market_value;
	private String	r12_security_id;
	private String	r12_country;
	private String	r12_counter_party;
	private String	r12_row_valid;
	private BigDecimal	r13_amt_total_security;
	private BigDecimal	r13_aed_equivalent;
	private BigDecimal	r13_market_value;
	private BigDecimal	r14_amt_total_security;
	private BigDecimal	r14_aed_equivalent;
	private BigDecimal	r14_market_value;
	private String	r14_security_id;
	private String	r14_country;
	private String	r14_rating;
	private String	r14_counter_party;
	private String	r14_row_valid;
	private BigDecimal	r15_amt_total_security;
	private BigDecimal	r15_aed_equivalent;
	private BigDecimal	r15_market_value;
	private BigDecimal	r16_amt_total_security;
	private BigDecimal	r16_aed_equivalent;
	private BigDecimal	r16_market_value;
	private String	r16_country;
	private String	r16_counter_party;
	private String	r16_row_valid;
	private BigDecimal	r17_amt_total_security;
	private BigDecimal	r17_aed_equivalent;
	private BigDecimal	r17_market_value;
	private BigDecimal	r18_amt_total_security;
	private BigDecimal	r18_aed_equivalent;
	private BigDecimal	r18_market_value;
	private String	r18_country;
	private String	r18_counter_party;
	private String	r18_row_valid;
	private BigDecimal	r19_amt_total_security;
	private BigDecimal	r19_aed_equivalent;
	private BigDecimal	r19_market_value;
	private BigDecimal	r20_amt_total_security;
	private BigDecimal	r20_aed_equivalent;
	private BigDecimal	r20_market_value;
	@Id
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date	report_date;
	private Date	report_from_date;
	private Date	report_to_date;
	private Date	report_submit_date;
	private String	entity_flg;
	private String	modify_flg;
	private String	del_flg;
	private String	r2_sec_identifier;
	private String	r2_country_security;
	private BigDecimal	r2_rating_aed;
	private String	r2_counter_type_aed;
	private String	r4_sec_identifier;
	private String	r4_country_security;
	private String	r4_counter_type_aed;
	private String	r6_sec_identifier;
	private String	r6_country_security;
	private String	r6_counter_type_aed;
	private String	r10_sec_identifier;
	private String	r10_country_security;
	private BigDecimal	r10_rating_aed;
	private String	r10_counter_type_aed;
	private String	r12_sec_identifier;
	private String	r12_country_security;
	private String	r12_counter_type_aed;
	private String	r14_sec_identifier;
	private String	r14_country_security;
	private BigDecimal	r14_rating_aed;
	private String	r14_counter_type_aed;
	private String	r16_country_security;
	private String	r16_counter_type_aed;
	private String	r18_country_security;
	private String	r18_counter_type_aed;
	private String	investment;
	private String	security_missing;
	private String	nominal_value;
	private String	units;
	private String	country;
	private String	ccy;
	private String	amount;
	private String	aed;
	private String	rating;
	private String	rating_type;
	private String	market_value;
	private String	country_party;	
	private BigDecimal srl_no;
	
	
	
	public BigDecimal getSrl_no() {
		return srl_no;
	}
	public void setSrl_no(BigDecimal srl_no) {
		this.srl_no = srl_no;
	}
	public BigDecimal getR1_amt_total_security() {
		return r1_amt_total_security;
	}
	public void setR1_amt_total_security(BigDecimal r1_amt_total_security) {
		this.r1_amt_total_security = r1_amt_total_security;
	}
	public BigDecimal getR1_aed_equivalent() {
		return r1_aed_equivalent;
	}
	public void setR1_aed_equivalent(BigDecimal r1_aed_equivalent) {
		this.r1_aed_equivalent = r1_aed_equivalent;
	}
	public BigDecimal getR1_market_value() {
		return r1_market_value;
	}
	public void setR1_market_value(BigDecimal r1_market_value) {
		this.r1_market_value = r1_market_value;
	}
	public BigDecimal getR2_amt_total_security() {
		return r2_amt_total_security;
	}
	public void setR2_amt_total_security(BigDecimal r2_amt_total_security) {
		this.r2_amt_total_security = r2_amt_total_security;
	}
	public BigDecimal getR2_aed_equivalent() {
		return r2_aed_equivalent;
	}
	public void setR2_aed_equivalent(BigDecimal r2_aed_equivalent) {
		this.r2_aed_equivalent = r2_aed_equivalent;
	}
	public BigDecimal getR2_market_value() {
		return r2_market_value;
	}
	public void setR2_market_value(BigDecimal r2_market_value) {
		this.r2_market_value = r2_market_value;
	}
	public String getR2_security_id() {
		return r2_security_id;
	}
	public void setR2_security_id(String r2_security_id) {
		this.r2_security_id = r2_security_id;
	}
	public String getR2_country() {
		return r2_country;
	}
	public void setR2_country(String r2_country) {
		this.r2_country = r2_country;
	}
	public String getR2_rating() {
		return r2_rating;
	}
	public void setR2_rating(String r2_rating) {
		this.r2_rating = r2_rating;
	}
	public String getR2_counter_party() {
		return r2_counter_party;
	}
	public void setR2_counter_party(String r2_counter_party) {
		this.r2_counter_party = r2_counter_party;
	}
	public String getR2_row_valid() {
		return r2_row_valid;
	}
	public void setR2_row_valid(String r2_row_valid) {
		this.r2_row_valid = r2_row_valid;
	}
	public BigDecimal getR3_amt_total_security() {
		return r3_amt_total_security;
	}
	public void setR3_amt_total_security(BigDecimal r3_amt_total_security) {
		this.r3_amt_total_security = r3_amt_total_security;
	}
	public BigDecimal getR3_aed_equivalent() {
		return r3_aed_equivalent;
	}
	public void setR3_aed_equivalent(BigDecimal r3_aed_equivalent) {
		this.r3_aed_equivalent = r3_aed_equivalent;
	}
	public BigDecimal getR3_market_value() {
		return r3_market_value;
	}
	public void setR3_market_value(BigDecimal r3_market_value) {
		this.r3_market_value = r3_market_value;
	}
	public BigDecimal getR4_amt_total_security() {
		return r4_amt_total_security;
	}
	public void setR4_amt_total_security(BigDecimal r4_amt_total_security) {
		this.r4_amt_total_security = r4_amt_total_security;
	}
	public BigDecimal getR4_aed_equivalent() {
		return r4_aed_equivalent;
	}
	public void setR4_aed_equivalent(BigDecimal r4_aed_equivalent) {
		this.r4_aed_equivalent = r4_aed_equivalent;
	}
	public BigDecimal getR4_market_value() {
		return r4_market_value;
	}
	public void setR4_market_value(BigDecimal r4_market_value) {
		this.r4_market_value = r4_market_value;
	}
	public String getR4_security_id() {
		return r4_security_id;
	}
	public void setR4_security_id(String r4_security_id) {
		this.r4_security_id = r4_security_id;
	}
	public String getR4_country() {
		return r4_country;
	}
	public void setR4_country(String r4_country) {
		this.r4_country = r4_country;
	}
	public String getR4_counter_party() {
		return r4_counter_party;
	}
	public void setR4_counter_party(String r4_counter_party) {
		this.r4_counter_party = r4_counter_party;
	}
	public String getR4_row_valid() {
		return r4_row_valid;
	}
	public void setR4_row_valid(String r4_row_valid) {
		this.r4_row_valid = r4_row_valid;
	}
	public BigDecimal getR5_amt_total_security() {
		return r5_amt_total_security;
	}
	public void setR5_amt_total_security(BigDecimal r5_amt_total_security) {
		this.r5_amt_total_security = r5_amt_total_security;
	}
	public BigDecimal getR5_aed_equivalent() {
		return r5_aed_equivalent;
	}
	public void setR5_aed_equivalent(BigDecimal r5_aed_equivalent) {
		this.r5_aed_equivalent = r5_aed_equivalent;
	}
	public BigDecimal getR5_market_value() {
		return r5_market_value;
	}
	public void setR5_market_value(BigDecimal r5_market_value) {
		this.r5_market_value = r5_market_value;
	}
	public BigDecimal getR6_amt_total_security() {
		return r6_amt_total_security;
	}
	public void setR6_amt_total_security(BigDecimal r6_amt_total_security) {
		this.r6_amt_total_security = r6_amt_total_security;
	}
	public BigDecimal getR6_aed_equivalent() {
		return r6_aed_equivalent;
	}
	public void setR6_aed_equivalent(BigDecimal r6_aed_equivalent) {
		this.r6_aed_equivalent = r6_aed_equivalent;
	}
	public BigDecimal getR6_market_value() {
		return r6_market_value;
	}
	public void setR6_market_value(BigDecimal r6_market_value) {
		this.r6_market_value = r6_market_value;
	}
	public String getR6_security_id() {
		return r6_security_id;
	}
	public void setR6_security_id(String r6_security_id) {
		this.r6_security_id = r6_security_id;
	}
	public String getR6_country() {
		return r6_country;
	}
	public void setR6_country(String r6_country) {
		this.r6_country = r6_country;
	}
	public String getR6_counter_party() {
		return r6_counter_party;
	}
	public void setR6_counter_party(String r6_counter_party) {
		this.r6_counter_party = r6_counter_party;
	}
	public String getR6_row_valid() {
		return r6_row_valid;
	}
	public void setR6_row_valid(String r6_row_valid) {
		this.r6_row_valid = r6_row_valid;
	}
	public BigDecimal getR7_amt_total_security() {
		return r7_amt_total_security;
	}
	public void setR7_amt_total_security(BigDecimal r7_amt_total_security) {
		this.r7_amt_total_security = r7_amt_total_security;
	}
	public BigDecimal getR7_aed_equivalent() {
		return r7_aed_equivalent;
	}
	public void setR7_aed_equivalent(BigDecimal r7_aed_equivalent) {
		this.r7_aed_equivalent = r7_aed_equivalent;
	}
	public BigDecimal getR7_market_value() {
		return r7_market_value;
	}
	public void setR7_market_value(BigDecimal r7_market_value) {
		this.r7_market_value = r7_market_value;
	}
	public BigDecimal getR8_amt_total_security() {
		return r8_amt_total_security;
	}
	public void setR8_amt_total_security(BigDecimal r8_amt_total_security) {
		this.r8_amt_total_security = r8_amt_total_security;
	}
	public BigDecimal getR8_aed_equivalent() {
		return r8_aed_equivalent;
	}
	public void setR8_aed_equivalent(BigDecimal r8_aed_equivalent) {
		this.r8_aed_equivalent = r8_aed_equivalent;
	}
	public BigDecimal getR8_market_value() {
		return r8_market_value;
	}
	public void setR8_market_value(BigDecimal r8_market_value) {
		this.r8_market_value = r8_market_value;
	}
	public BigDecimal getR9_amt_total_security() {
		return r9_amt_total_security;
	}
	public void setR9_amt_total_security(BigDecimal r9_amt_total_security) {
		this.r9_amt_total_security = r9_amt_total_security;
	}
	public BigDecimal getR9_aed_equivalent() {
		return r9_aed_equivalent;
	}
	public void setR9_aed_equivalent(BigDecimal r9_aed_equivalent) {
		this.r9_aed_equivalent = r9_aed_equivalent;
	}
	public BigDecimal getR9_market_value() {
		return r9_market_value;
	}
	public void setR9_market_value(BigDecimal r9_market_value) {
		this.r9_market_value = r9_market_value;
	}
	public BigDecimal getR10_amt_total_security() {
		return r10_amt_total_security;
	}
	public void setR10_amt_total_security(BigDecimal r10_amt_total_security) {
		this.r10_amt_total_security = r10_amt_total_security;
	}
	public BigDecimal getR10_aed_equivalent() {
		return r10_aed_equivalent;
	}
	public void setR10_aed_equivalent(BigDecimal r10_aed_equivalent) {
		this.r10_aed_equivalent = r10_aed_equivalent;
	}
	public BigDecimal getR10_market_value() {
		return r10_market_value;
	}
	public void setR10_market_value(BigDecimal r10_market_value) {
		this.r10_market_value = r10_market_value;
	}
	public String getR10_security_id() {
		return r10_security_id;
	}
	public void setR10_security_id(String r10_security_id) {
		this.r10_security_id = r10_security_id;
	}
	public String getR10_country() {
		return r10_country;
	}
	public void setR10_country(String r10_country) {
		this.r10_country = r10_country;
	}
	public String getR10_rating() {
		return r10_rating;
	}
	public void setR10_rating(String r10_rating) {
		this.r10_rating = r10_rating;
	}
	public String getR10_counter_party() {
		return r10_counter_party;
	}
	public void setR10_counter_party(String r10_counter_party) {
		this.r10_counter_party = r10_counter_party;
	}
	public String getR10_row_valid() {
		return r10_row_valid;
	}
	public void setR10_row_valid(String r10_row_valid) {
		this.r10_row_valid = r10_row_valid;
	}
	public BigDecimal getR11_amt_total_security() {
		return r11_amt_total_security;
	}
	public void setR11_amt_total_security(BigDecimal r11_amt_total_security) {
		this.r11_amt_total_security = r11_amt_total_security;
	}
	public BigDecimal getR11_aed_equivalent() {
		return r11_aed_equivalent;
	}
	public void setR11_aed_equivalent(BigDecimal r11_aed_equivalent) {
		this.r11_aed_equivalent = r11_aed_equivalent;
	}
	public BigDecimal getR11_market_value() {
		return r11_market_value;
	}
	public void setR11_market_value(BigDecimal r11_market_value) {
		this.r11_market_value = r11_market_value;
	}
	public BigDecimal getR12_amt_total_security() {
		return r12_amt_total_security;
	}
	public void setR12_amt_total_security(BigDecimal r12_amt_total_security) {
		this.r12_amt_total_security = r12_amt_total_security;
	}
	public BigDecimal getR12_aed_equivalent() {
		return r12_aed_equivalent;
	}
	public void setR12_aed_equivalent(BigDecimal r12_aed_equivalent) {
		this.r12_aed_equivalent = r12_aed_equivalent;
	}
	public BigDecimal getR12_market_value() {
		return r12_market_value;
	}
	public void setR12_market_value(BigDecimal r12_market_value) {
		this.r12_market_value = r12_market_value;
	}
	public String getR12_security_id() {
		return r12_security_id;
	}
	public void setR12_security_id(String r12_security_id) {
		this.r12_security_id = r12_security_id;
	}
	public String getR12_country() {
		return r12_country;
	}
	public void setR12_country(String r12_country) {
		this.r12_country = r12_country;
	}
	public String getR12_counter_party() {
		return r12_counter_party;
	}
	public void setR12_counter_party(String r12_counter_party) {
		this.r12_counter_party = r12_counter_party;
	}
	public String getR12_row_valid() {
		return r12_row_valid;
	}
	public void setR12_row_valid(String r12_row_valid) {
		this.r12_row_valid = r12_row_valid;
	}
	public BigDecimal getR13_amt_total_security() {
		return r13_amt_total_security;
	}
	public void setR13_amt_total_security(BigDecimal r13_amt_total_security) {
		this.r13_amt_total_security = r13_amt_total_security;
	}
	public BigDecimal getR13_aed_equivalent() {
		return r13_aed_equivalent;
	}
	public void setR13_aed_equivalent(BigDecimal r13_aed_equivalent) {
		this.r13_aed_equivalent = r13_aed_equivalent;
	}
	public BigDecimal getR13_market_value() {
		return r13_market_value;
	}
	public void setR13_market_value(BigDecimal r13_market_value) {
		this.r13_market_value = r13_market_value;
	}
	public BigDecimal getR14_amt_total_security() {
		return r14_amt_total_security;
	}
	public void setR14_amt_total_security(BigDecimal r14_amt_total_security) {
		this.r14_amt_total_security = r14_amt_total_security;
	}
	public BigDecimal getR14_aed_equivalent() {
		return r14_aed_equivalent;
	}
	public void setR14_aed_equivalent(BigDecimal r14_aed_equivalent) {
		this.r14_aed_equivalent = r14_aed_equivalent;
	}
	public BigDecimal getR14_market_value() {
		return r14_market_value;
	}
	public void setR14_market_value(BigDecimal r14_market_value) {
		this.r14_market_value = r14_market_value;
	}
	public String getR14_security_id() {
		return r14_security_id;
	}
	public void setR14_security_id(String r14_security_id) {
		this.r14_security_id = r14_security_id;
	}
	public String getR14_country() {
		return r14_country;
	}
	public void setR14_country(String r14_country) {
		this.r14_country = r14_country;
	}
	public String getR14_rating() {
		return r14_rating;
	}
	public void setR14_rating(String r14_rating) {
		this.r14_rating = r14_rating;
	}
	public String getR14_counter_party() {
		return r14_counter_party;
	}
	public void setR14_counter_party(String r14_counter_party) {
		this.r14_counter_party = r14_counter_party;
	}
	public String getR14_row_valid() {
		return r14_row_valid;
	}
	public void setR14_row_valid(String r14_row_valid) {
		this.r14_row_valid = r14_row_valid;
	}
	public BigDecimal getR15_amt_total_security() {
		return r15_amt_total_security;
	}
	public void setR15_amt_total_security(BigDecimal r15_amt_total_security) {
		this.r15_amt_total_security = r15_amt_total_security;
	}
	public BigDecimal getR15_aed_equivalent() {
		return r15_aed_equivalent;
	}
	public void setR15_aed_equivalent(BigDecimal r15_aed_equivalent) {
		this.r15_aed_equivalent = r15_aed_equivalent;
	}
	public BigDecimal getR15_market_value() {
		return r15_market_value;
	}
	public void setR15_market_value(BigDecimal r15_market_value) {
		this.r15_market_value = r15_market_value;
	}
	public BigDecimal getR16_amt_total_security() {
		return r16_amt_total_security;
	}
	public void setR16_amt_total_security(BigDecimal r16_amt_total_security) {
		this.r16_amt_total_security = r16_amt_total_security;
	}
	public BigDecimal getR16_aed_equivalent() {
		return r16_aed_equivalent;
	}
	public void setR16_aed_equivalent(BigDecimal r16_aed_equivalent) {
		this.r16_aed_equivalent = r16_aed_equivalent;
	}
	public BigDecimal getR16_market_value() {
		return r16_market_value;
	}
	public void setR16_market_value(BigDecimal r16_market_value) {
		this.r16_market_value = r16_market_value;
	}
	public String getR16_country() {
		return r16_country;
	}
	public void setR16_country(String r16_country) {
		this.r16_country = r16_country;
	}
	public String getR16_counter_party() {
		return r16_counter_party;
	}
	public void setR16_counter_party(String r16_counter_party) {
		this.r16_counter_party = r16_counter_party;
	}
	public String getR16_row_valid() {
		return r16_row_valid;
	}
	public void setR16_row_valid(String r16_row_valid) {
		this.r16_row_valid = r16_row_valid;
	}
	public BigDecimal getR17_amt_total_security() {
		return r17_amt_total_security;
	}
	public void setR17_amt_total_security(BigDecimal r17_amt_total_security) {
		this.r17_amt_total_security = r17_amt_total_security;
	}
	public BigDecimal getR17_aed_equivalent() {
		return r17_aed_equivalent;
	}
	public void setR17_aed_equivalent(BigDecimal r17_aed_equivalent) {
		this.r17_aed_equivalent = r17_aed_equivalent;
	}
	public BigDecimal getR17_market_value() {
		return r17_market_value;
	}
	public void setR17_market_value(BigDecimal r17_market_value) {
		this.r17_market_value = r17_market_value;
	}
	public BigDecimal getR18_amt_total_security() {
		return r18_amt_total_security;
	}
	public void setR18_amt_total_security(BigDecimal r18_amt_total_security) {
		this.r18_amt_total_security = r18_amt_total_security;
	}
	public BigDecimal getR18_aed_equivalent() {
		return r18_aed_equivalent;
	}
	public void setR18_aed_equivalent(BigDecimal r18_aed_equivalent) {
		this.r18_aed_equivalent = r18_aed_equivalent;
	}
	public BigDecimal getR18_market_value() {
		return r18_market_value;
	}
	public void setR18_market_value(BigDecimal r18_market_value) {
		this.r18_market_value = r18_market_value;
	}
	public String getR18_country() {
		return r18_country;
	}
	public void setR18_country(String r18_country) {
		this.r18_country = r18_country;
	}
	public String getR18_counter_party() {
		return r18_counter_party;
	}
	public void setR18_counter_party(String r18_counter_party) {
		this.r18_counter_party = r18_counter_party;
	}
	public String getR18_row_valid() {
		return r18_row_valid;
	}
	public void setR18_row_valid(String r18_row_valid) {
		this.r18_row_valid = r18_row_valid;
	}
	public BigDecimal getR19_amt_total_security() {
		return r19_amt_total_security;
	}
	public void setR19_amt_total_security(BigDecimal r19_amt_total_security) {
		this.r19_amt_total_security = r19_amt_total_security;
	}
	public BigDecimal getR19_aed_equivalent() {
		return r19_aed_equivalent;
	}
	public void setR19_aed_equivalent(BigDecimal r19_aed_equivalent) {
		this.r19_aed_equivalent = r19_aed_equivalent;
	}
	public BigDecimal getR19_market_value() {
		return r19_market_value;
	}
	public void setR19_market_value(BigDecimal r19_market_value) {
		this.r19_market_value = r19_market_value;
	}
	public BigDecimal getR20_amt_total_security() {
		return r20_amt_total_security;
	}
	public void setR20_amt_total_security(BigDecimal r20_amt_total_security) {
		this.r20_amt_total_security = r20_amt_total_security;
	}
	public BigDecimal getR20_aed_equivalent() {
		return r20_aed_equivalent;
	}
	public void setR20_aed_equivalent(BigDecimal r20_aed_equivalent) {
		this.r20_aed_equivalent = r20_aed_equivalent;
	}
	public BigDecimal getR20_market_value() {
		return r20_market_value;
	}
	public void setR20_market_value(BigDecimal r20_market_value) {
		this.r20_market_value = r20_market_value;
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
	public String getR2_sec_identifier() {
		return r2_sec_identifier;
	}
	public void setR2_sec_identifier(String r2_sec_identifier) {
		this.r2_sec_identifier = r2_sec_identifier;
	}
	public String getR2_country_security() {
		return r2_country_security;
	}
	public void setR2_country_security(String r2_country_security) {
		this.r2_country_security = r2_country_security;
	}
	public BigDecimal getR2_rating_aed() {
		return r2_rating_aed;
	}
	public void setR2_rating_aed(BigDecimal r2_rating_aed) {
		this.r2_rating_aed = r2_rating_aed;
	}
	public String getR2_counter_type_aed() {
		return r2_counter_type_aed;
	}
	public void setR2_counter_type_aed(String r2_counter_type_aed) {
		this.r2_counter_type_aed = r2_counter_type_aed;
	}
	public String getR4_sec_identifier() {
		return r4_sec_identifier;
	}
	public void setR4_sec_identifier(String r4_sec_identifier) {
		this.r4_sec_identifier = r4_sec_identifier;
	}
	public String getR4_country_security() {
		return r4_country_security;
	}
	public void setR4_country_security(String r4_country_security) {
		this.r4_country_security = r4_country_security;
	}
	public String getR4_counter_type_aed() {
		return r4_counter_type_aed;
	}
	public void setR4_counter_type_aed(String r4_counter_type_aed) {
		this.r4_counter_type_aed = r4_counter_type_aed;
	}
	public String getR6_sec_identifier() {
		return r6_sec_identifier;
	}
	public void setR6_sec_identifier(String r6_sec_identifier) {
		this.r6_sec_identifier = r6_sec_identifier;
	}
	public String getR6_country_security() {
		return r6_country_security;
	}
	public void setR6_country_security(String r6_country_security) {
		this.r6_country_security = r6_country_security;
	}
	public String getR6_counter_type_aed() {
		return r6_counter_type_aed;
	}
	public void setR6_counter_type_aed(String r6_counter_type_aed) {
		this.r6_counter_type_aed = r6_counter_type_aed;
	}
	public String getR10_sec_identifier() {
		return r10_sec_identifier;
	}
	public void setR10_sec_identifier(String r10_sec_identifier) {
		this.r10_sec_identifier = r10_sec_identifier;
	}
	public String getR10_country_security() {
		return r10_country_security;
	}
	public void setR10_country_security(String r10_country_security) {
		this.r10_country_security = r10_country_security;
	}
	public BigDecimal getR10_rating_aed() {
		return r10_rating_aed;
	}
	public void setR10_rating_aed(BigDecimal r10_rating_aed) {
		this.r10_rating_aed = r10_rating_aed;
	}
	public String getR10_counter_type_aed() {
		return r10_counter_type_aed;
	}
	public void setR10_counter_type_aed(String r10_counter_type_aed) {
		this.r10_counter_type_aed = r10_counter_type_aed;
	}
	public String getR12_sec_identifier() {
		return r12_sec_identifier;
	}
	public void setR12_sec_identifier(String r12_sec_identifier) {
		this.r12_sec_identifier = r12_sec_identifier;
	}
	public String getR12_country_security() {
		return r12_country_security;
	}
	public void setR12_country_security(String r12_country_security) {
		this.r12_country_security = r12_country_security;
	}
	public String getR12_counter_type_aed() {
		return r12_counter_type_aed;
	}
	public void setR12_counter_type_aed(String r12_counter_type_aed) {
		this.r12_counter_type_aed = r12_counter_type_aed;
	}
	public String getR14_sec_identifier() {
		return r14_sec_identifier;
	}
	public void setR14_sec_identifier(String r14_sec_identifier) {
		this.r14_sec_identifier = r14_sec_identifier;
	}
	public String getR14_country_security() {
		return r14_country_security;
	}
	public void setR14_country_security(String r14_country_security) {
		this.r14_country_security = r14_country_security;
	}
	public BigDecimal getR14_rating_aed() {
		return r14_rating_aed;
	}
	public void setR14_rating_aed(BigDecimal r14_rating_aed) {
		this.r14_rating_aed = r14_rating_aed;
	}
	public String getR14_counter_type_aed() {
		return r14_counter_type_aed;
	}
	public void setR14_counter_type_aed(String r14_counter_type_aed) {
		this.r14_counter_type_aed = r14_counter_type_aed;
	}
	public String getR16_country_security() {
		return r16_country_security;
	}
	public void setR16_country_security(String r16_country_security) {
		this.r16_country_security = r16_country_security;
	}
	public String getR16_counter_type_aed() {
		return r16_counter_type_aed;
	}
	public void setR16_counter_type_aed(String r16_counter_type_aed) {
		this.r16_counter_type_aed = r16_counter_type_aed;
	}
	public String getR18_country_security() {
		return r18_country_security;
	}
	public void setR18_country_security(String r18_country_security) {
		this.r18_country_security = r18_country_security;
	}
	public String getR18_counter_type_aed() {
		return r18_counter_type_aed;
	}
	public void setR18_counter_type_aed(String r18_counter_type_aed) {
		this.r18_counter_type_aed = r18_counter_type_aed;
	}
	public String getInvestment() {
		return investment;
	}
	public void setInvestment(String investment) {
		this.investment = investment;
	}
	public String getSecurity_missing() {
		return security_missing;
	}
	public void setSecurity_missing(String security_missing) {
		this.security_missing = security_missing;
	}
	public String getNominal_value() {
		return nominal_value;
	}
	public void setNominal_value(String nominal_value) {
		this.nominal_value = nominal_value;
	}
	public String getUnits() {
		return units;
	}
	public void setUnits(String units) {
		this.units = units;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getCcy() {
		return ccy;
	}
	public void setCcy(String ccy) {
		this.ccy = ccy;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getAed() {
		return aed;
	}
	public void setAed(String aed) {
		this.aed = aed;
	}
	public String getRating() {
		return rating;
	}
	public void setRating(String rating) {
		this.rating = rating;
	}
	public String getRating_type() {
		return rating_type;
	}
	public void setRating_type(String rating_type) {
		this.rating_type = rating_type;
	}
	public String getMarket_value() {
		return market_value;
	}
	public void setMarket_value(String market_value) {
		this.market_value = market_value;
	}
	public String getCountry_party() {
		return country_party;
	}
	public void setCountry_party(String country_party) {
		this.country_party = country_party;
	}
	public BRF5_ENTIITY() {
		super();
	
	}



}
