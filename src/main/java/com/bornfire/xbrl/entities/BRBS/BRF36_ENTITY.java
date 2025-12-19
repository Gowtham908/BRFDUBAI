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
@Table(name = "BRF36_SUMMARYTABLE")
public class BRF36_ENTITY {
	private String r9_section_a;
	private BigDecimal r9_section_a_size;
	private BigDecimal r9_section_a_aed;
	private BigDecimal r9_section_a_total;
	private BigDecimal r9_section_a_upto3;
	private BigDecimal r9_section_a_upto_36;
	private BigDecimal r9_section_a_upto_69;
	private BigDecimal r9_section_a_upto_912;
	private BigDecimal r9_section_a_upto_12;
	private BigDecimal r9_section_a_upto_23;
	private BigDecimal r9_section_a_upto_34;
	private BigDecimal r9_section_a_upto_45;
	private BigDecimal r9_section_a_upto_5;
	private String r10_section_a_na;
	private String r10_section_a_na_currency;
	private BigDecimal r10_section_a_na_size;
	private BigDecimal r10_section_a_na_aed;
	private BigDecimal r10_section_a_na_total;
	private BigDecimal r10_section_a_na_upto3;
	private BigDecimal r10_section_a_na_upto_36;
	private BigDecimal r10_section_a_na_upto_69;
	private BigDecimal r10_section_a_na_upto_912;
	private BigDecimal r10_section_a_na_upto_12;
	private BigDecimal r10_section_a_na_upto_23;
	private BigDecimal r10_section_a_na_upto_34;
	private BigDecimal r10_section_a_na_upto_45;
	private BigDecimal r10_section_a_na_upto_5;
	private String r11_section_b;
	private BigDecimal r11_section_b_size;
	private BigDecimal r11_section_b_aed;
	private BigDecimal r11_section_b_total;
	private BigDecimal r11_section_b_upto3;
	private BigDecimal r11_section_b_upto_36;
	private BigDecimal r11_section_b_upto_69;
	private BigDecimal r11_section_b_upto_912;
	private BigDecimal r11_section_b_upto_12;
	private BigDecimal r11_section_b_upto_23;
	private BigDecimal r11_section_b_upto_34;
	private BigDecimal r11_section_b_upto_45;
	private BigDecimal r11_section_b_upto_5;
	private String r12_federal_govn;
	private BigDecimal r12_federal_govn_size;
	private BigDecimal r12_federal_govn_aed;
	private BigDecimal r12_federal_govn_total;
	private BigDecimal r12_federal_govn_upto3;
	private BigDecimal r12_federal_govn_upto_36;
	private BigDecimal r12_federal_govn_upto_69;
	private BigDecimal r12_federal_govn_uptp_912;
	private BigDecimal r12_federal_govn_upto_12;
	private BigDecimal r12_federal_govn_upto_23;
	private BigDecimal r12_federal_govn_upto_34;
	private BigDecimal r12_federal_govn_upto_45;
	private BigDecimal r12_federal_govn_upto_5;
	private String r13_federal_govn_na;
	private String r13_federal_govn_na_currency;
	private BigDecimal r13_federal_govn_na_size;
	private BigDecimal r13_federal_govn_na_aed;
	private BigDecimal r13_federal_govn_na_total;
	private BigDecimal r13_federal_govn_na_upto3;
	private BigDecimal r13_federal_govn_na_upto_36;
	private BigDecimal r13_federal_govn_na_upto_69;
	private BigDecimal r13_federal_govn_na_uptp_912;
	private BigDecimal r13_federal_govn_na_upto_12;
	private BigDecimal r13_federal_govn_na_upto_23;
	private BigDecimal r13_federal_govn_na_upto_34;
	private BigDecimal r13_federal_govn_na_upto_45;
	private BigDecimal r13_federal_govn_na_upto_5;
	private String r14_emirates;
	private BigDecimal r14_emirates_size;
	private BigDecimal r14_emirates_aed;
	private BigDecimal r14_emirates_total;
	private BigDecimal r14_emirates_upto3;
	private BigDecimal r14_emirates_upto_36;
	private BigDecimal r14_emirates_upto_69;
	private BigDecimal r14_emirates_upto_912;
	private BigDecimal r14_emirates_upto_12;
	private BigDecimal r14_emirates_upto_23;
	private BigDecimal r14_emirates_upto_34;
	private BigDecimal r14_emirates_upto_45;
	private BigDecimal r14_emirates_upto_5;
	private String r15_emirates_na;
	private String r15_emirates_na_currency;
	private BigDecimal r15_emirates_na_size;
	private BigDecimal r15_emirates_na_aed;
	private BigDecimal r15_emirates_na_total;
	private BigDecimal r15_emirates_na_upto3;
	private BigDecimal r15_emirates_na_upto_36;
	private BigDecimal r15_emirates_na_upto_69;
	private BigDecimal r15_emirates_na_upto_912;
	private BigDecimal r15_emirates_na_upto_12;
	private BigDecimal r15_emirates_na_upto_23;
	private BigDecimal r15_emirates_na_upto_34;
	private BigDecimal r15_emirates_na_upto_45;
	private BigDecimal r15_emirates_na_upto_5;
	private String r16_bank;
	private BigDecimal r16_bank_size;
	private BigDecimal r16_bank_aed;
	private BigDecimal r16_bank_total;
	private BigDecimal r16_bank_upto3;
	private BigDecimal r16_bank_upto_36;
	private BigDecimal r16_bank_upto_69;
	private BigDecimal r16_bank_upto_912;
	private BigDecimal r16_bank_upto_12;
	private BigDecimal r16_bank_upto_23;
	private BigDecimal r16_bank_upto_34;
	private BigDecimal r16_bank_upto_45;
	private BigDecimal r16_bank_upto_5;
	private String r17_bank_na;
	private String r17_bank_na_currency;
	private BigDecimal r17_bank_na_size;
	private BigDecimal r17_bank_na_aed;
	private BigDecimal r17_bank_na_total;
	private BigDecimal r17_bank_na_upto3;
	private BigDecimal r17_bank_na_upto_36;
	private BigDecimal r17_bank_na_upto_69;
	private BigDecimal r17_bank_na_upto_912;
	private BigDecimal r17_bank_na_upto_12;
	private BigDecimal r17_bank_na_upto_23;
	private BigDecimal r17_bank_na_upto_34;
	private BigDecimal r17_bank_na_upto_45;
	private BigDecimal r17_bank_na_upto_5;
	private String r18_nbfi;
	private BigDecimal r18_nbfi_size;
	private BigDecimal r18_nbfi_aed;
	private BigDecimal r18_nbfi_total;
	private BigDecimal r18_nbfi_upto3;
	private BigDecimal r18_nbfi_upto_36;
	private BigDecimal r18_nbfi_upto_69;
	private BigDecimal r18_nbfi_upto_912;
	private BigDecimal r18_nbfi_upto_12;
	private BigDecimal r18_nbfi_upto_23;
	private BigDecimal r18_nbfi_upto_34;
	private BigDecimal r18_nbfi_upto_45;
	private BigDecimal r18_nbfi_upto_5;
	private String r19_nbfi_na;
	private String r19_nbfi_na_currency;
	private BigDecimal r19_nbfi_na_size;
	private BigDecimal r19_nbfi_na_aed;
	private BigDecimal r19_nbfi_na_total;
	private BigDecimal r19_nbfi_na_upto3;
	private BigDecimal r19_nbfi_na_upto_36;
	private BigDecimal r19_nbfi_na_upto_69;
	private BigDecimal r19_nbfi_na_upto_912;
	private BigDecimal r19_nbfi_na_upto_12;
	private BigDecimal r19_nbfi_na_upto_23;
	private BigDecimal r19_nbfi_na_upto_34;
	private BigDecimal r19_nbfi_na_upto_45;
	private BigDecimal r19_nbfi_na_upto_5;
	private String r20_other;
	private BigDecimal r20_other_size;
	private BigDecimal r20_other_aed;
	private BigDecimal r20_other_total;
	private BigDecimal r20_other_upto3;
	private BigDecimal r20_other_upto_36;
	private BigDecimal r20_other_upto_69;
	private BigDecimal r20_other_upto_912;
	private BigDecimal r20_other_upto_12;
	private BigDecimal r20_other_upto_23;
	private BigDecimal r20_other_upto_34;
	private BigDecimal r20_other_upto_45;
	private BigDecimal r20_other_upto_5;
	private String r21_other_na;
	private String r21_other_na_currency;
	private BigDecimal r21_other_na_size;
	private BigDecimal r21_other_na_aed;
	private BigDecimal r21_other_na_total;
	private BigDecimal r21_other_na_upto3;
	private BigDecimal r21_other_na_upto_36;
	private BigDecimal r21_other_na_upto_69;
	private BigDecimal r21_other_na_upto_912;
	private BigDecimal r21_other_na_upto_12;
	private BigDecimal r21_other_na_upto_23;
	private BigDecimal r21_other_na_upto_34;
	private BigDecimal r21_other_na_upto_45;
	private BigDecimal r21_other_na_upto_5;
	private String r22_total;
	private BigDecimal r22_total_size;
	private BigDecimal r22_total_aed;
	private BigDecimal r22_total_total;
	private BigDecimal r22_total_upto3;
	private BigDecimal r22_total_upto_36;
	private BigDecimal r22_total_upto_69;
	private BigDecimal r22_total_upto_912;
	private BigDecimal r22_total_upto_12;
	private BigDecimal r22_total_upto_23;
	private BigDecimal r22_total_upto_34;
	private BigDecimal r22_total_upto_45;
	private BigDecimal r22_total_upto_5;
	private String r23_total;
	private String r23_total_na_currency;
	private BigDecimal r23_total_na_size;
	private BigDecimal r23_total_na_aed;
	private BigDecimal r23_total_na_total;
	private BigDecimal r23_total_na_upto3;
	private BigDecimal r23_total_na_upto_36;
	private BigDecimal r23_total_na_upto_69;
	private BigDecimal r23_total_na_upto_912;
	private BigDecimal r23_total_na_upto_12;
	private BigDecimal r23_total_na_upto_23;
	private BigDecimal r23_total_na_upto_34;
	private BigDecimal r23_total_na_upto_45;
	private BigDecimal r23_total_na_upto_5;
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
	private String progarm_instrument_name;
	private String currency_of_issue;
	private String size_of_prgoam;
	private String aed_equivalent;
	private String aed_iss_total;
	private String month_upto3;
	private String month3to6;
	private String month6to9;
	private String month9to12;
	private String year1to2;
	private String year2to3;
	private String year3to4;
	private String year4to5;
	private String year_upto5;
	private BigDecimal srl_no;
	private String repdesc;
	private String frequency;

	public String getR9_section_a() {
		return r9_section_a;
	}

	public void setR9_section_a(String r9_section_a) {
		this.r9_section_a = r9_section_a;
	}

	public BigDecimal getR9_section_a_size() {
		return r9_section_a_size;
	}

	public void setR9_section_a_size(BigDecimal r9_section_a_size) {
		this.r9_section_a_size = r9_section_a_size;
	}

	public BigDecimal getR9_section_a_aed() {
		return r9_section_a_aed;
	}

	public void setR9_section_a_aed(BigDecimal r9_section_a_aed) {
		this.r9_section_a_aed = r9_section_a_aed;
	}

	public BigDecimal getR9_section_a_total() {
		return r9_section_a_total;
	}

	public void setR9_section_a_total(BigDecimal r9_section_a_total) {
		this.r9_section_a_total = r9_section_a_total;
	}

	public BigDecimal getR9_section_a_upto3() {
		return r9_section_a_upto3;
	}

	public void setR9_section_a_upto3(BigDecimal r9_section_a_upto3) {
		this.r9_section_a_upto3 = r9_section_a_upto3;
	}

	public BigDecimal getR9_section_a_upto_36() {
		return r9_section_a_upto_36;
	}

	public void setR9_section_a_upto_36(BigDecimal r9_section_a_upto_36) {
		this.r9_section_a_upto_36 = r9_section_a_upto_36;
	}

	public BigDecimal getR9_section_a_upto_69() {
		return r9_section_a_upto_69;
	}

	public void setR9_section_a_upto_69(BigDecimal r9_section_a_upto_69) {
		this.r9_section_a_upto_69 = r9_section_a_upto_69;
	}

	public BigDecimal getR9_section_a_upto_912() {
		return r9_section_a_upto_912;
	}

	public void setR9_section_a_upto_912(BigDecimal r9_section_a_upto_912) {
		this.r9_section_a_upto_912 = r9_section_a_upto_912;
	}

	public BigDecimal getR9_section_a_upto_12() {
		return r9_section_a_upto_12;
	}

	public void setR9_section_a_upto_12(BigDecimal r9_section_a_upto_12) {
		this.r9_section_a_upto_12 = r9_section_a_upto_12;
	}

	public BigDecimal getR9_section_a_upto_23() {
		return r9_section_a_upto_23;
	}

	public void setR9_section_a_upto_23(BigDecimal r9_section_a_upto_23) {
		this.r9_section_a_upto_23 = r9_section_a_upto_23;
	}

	public BigDecimal getR9_section_a_upto_34() {
		return r9_section_a_upto_34;
	}

	public void setR9_section_a_upto_34(BigDecimal r9_section_a_upto_34) {
		this.r9_section_a_upto_34 = r9_section_a_upto_34;
	}

	public BigDecimal getR9_section_a_upto_45() {
		return r9_section_a_upto_45;
	}

	public void setR9_section_a_upto_45(BigDecimal r9_section_a_upto_45) {
		this.r9_section_a_upto_45 = r9_section_a_upto_45;
	}

	public BigDecimal getR9_section_a_upto_5() {
		return r9_section_a_upto_5;
	}

	public void setR9_section_a_upto_5(BigDecimal r9_section_a_upto_5) {
		this.r9_section_a_upto_5 = r9_section_a_upto_5;
	}

	public String getR10_section_a_na() {
		return r10_section_a_na;
	}

	public void setR10_section_a_na(String r10_section_a_na) {
		this.r10_section_a_na = r10_section_a_na;
	}

	public String getR10_section_a_na_currency() {
		return r10_section_a_na_currency;
	}

	public void setR10_section_a_na_currency(String r10_section_a_na_currency) {
		this.r10_section_a_na_currency = r10_section_a_na_currency;
	}

	public BigDecimal getR10_section_a_na_size() {
		return r10_section_a_na_size;
	}

	public void setR10_section_a_na_size(BigDecimal r10_section_a_na_size) {
		this.r10_section_a_na_size = r10_section_a_na_size;
	}

	public BigDecimal getR10_section_a_na_aed() {
		return r10_section_a_na_aed;
	}

	public void setR10_section_a_na_aed(BigDecimal r10_section_a_na_aed) {
		this.r10_section_a_na_aed = r10_section_a_na_aed;
	}

	public BigDecimal getR10_section_a_na_total() {
		return r10_section_a_na_total;
	}

	public void setR10_section_a_na_total(BigDecimal r10_section_a_na_total) {
		this.r10_section_a_na_total = r10_section_a_na_total;
	}

	public BigDecimal getR10_section_a_na_upto3() {
		return r10_section_a_na_upto3;
	}

	public void setR10_section_a_na_upto3(BigDecimal r10_section_a_na_upto3) {
		this.r10_section_a_na_upto3 = r10_section_a_na_upto3;
	}

	public BigDecimal getR10_section_a_na_upto_36() {
		return r10_section_a_na_upto_36;
	}

	public void setR10_section_a_na_upto_36(BigDecimal r10_section_a_na_upto_36) {
		this.r10_section_a_na_upto_36 = r10_section_a_na_upto_36;
	}

	public BigDecimal getR10_section_a_na_upto_69() {
		return r10_section_a_na_upto_69;
	}

	public void setR10_section_a_na_upto_69(BigDecimal r10_section_a_na_upto_69) {
		this.r10_section_a_na_upto_69 = r10_section_a_na_upto_69;
	}

	public BigDecimal getR10_section_a_na_upto_912() {
		return r10_section_a_na_upto_912;
	}

	public void setR10_section_a_na_upto_912(BigDecimal r10_section_a_na_upto_912) {
		this.r10_section_a_na_upto_912 = r10_section_a_na_upto_912;
	}

	public BigDecimal getR10_section_a_na_upto_12() {
		return r10_section_a_na_upto_12;
	}

	public void setR10_section_a_na_upto_12(BigDecimal r10_section_a_na_upto_12) {
		this.r10_section_a_na_upto_12 = r10_section_a_na_upto_12;
	}

	public BigDecimal getR10_section_a_na_upto_23() {
		return r10_section_a_na_upto_23;
	}

	public void setR10_section_a_na_upto_23(BigDecimal r10_section_a_na_upto_23) {
		this.r10_section_a_na_upto_23 = r10_section_a_na_upto_23;
	}

	public BigDecimal getR10_section_a_na_upto_34() {
		return r10_section_a_na_upto_34;
	}

	public void setR10_section_a_na_upto_34(BigDecimal r10_section_a_na_upto_34) {
		this.r10_section_a_na_upto_34 = r10_section_a_na_upto_34;
	}

	public BigDecimal getR10_section_a_na_upto_45() {
		return r10_section_a_na_upto_45;
	}

	public void setR10_section_a_na_upto_45(BigDecimal r10_section_a_na_upto_45) {
		this.r10_section_a_na_upto_45 = r10_section_a_na_upto_45;
	}

	public BigDecimal getR10_section_a_na_upto_5() {
		return r10_section_a_na_upto_5;
	}

	public void setR10_section_a_na_upto_5(BigDecimal r10_section_a_na_upto_5) {
		this.r10_section_a_na_upto_5 = r10_section_a_na_upto_5;
	}

	public String getR11_section_b() {
		return r11_section_b;
	}

	public void setR11_section_b(String r11_section_b) {
		this.r11_section_b = r11_section_b;
	}

	public BigDecimal getR11_section_b_size() {
		return r11_section_b_size;
	}

	public void setR11_section_b_size(BigDecimal r11_section_b_size) {
		this.r11_section_b_size = r11_section_b_size;
	}

	public BigDecimal getR11_section_b_aed() {
		return r11_section_b_aed;
	}

	public void setR11_section_b_aed(BigDecimal r11_section_b_aed) {
		this.r11_section_b_aed = r11_section_b_aed;
	}

	public BigDecimal getR11_section_b_total() {
		return r11_section_b_total;
	}

	public void setR11_section_b_total(BigDecimal r11_section_b_total) {
		this.r11_section_b_total = r11_section_b_total;
	}

	public BigDecimal getR11_section_b_upto3() {
		return r11_section_b_upto3;
	}

	public void setR11_section_b_upto3(BigDecimal r11_section_b_upto3) {
		this.r11_section_b_upto3 = r11_section_b_upto3;
	}

	public BigDecimal getR11_section_b_upto_36() {
		return r11_section_b_upto_36;
	}

	public void setR11_section_b_upto_36(BigDecimal r11_section_b_upto_36) {
		this.r11_section_b_upto_36 = r11_section_b_upto_36;
	}

	public BigDecimal getR11_section_b_upto_69() {
		return r11_section_b_upto_69;
	}

	public void setR11_section_b_upto_69(BigDecimal r11_section_b_upto_69) {
		this.r11_section_b_upto_69 = r11_section_b_upto_69;
	}

	public BigDecimal getR11_section_b_upto_912() {
		return r11_section_b_upto_912;
	}

	public void setR11_section_b_upto_912(BigDecimal r11_section_b_upto_912) {
		this.r11_section_b_upto_912 = r11_section_b_upto_912;
	}

	public BigDecimal getR11_section_b_upto_12() {
		return r11_section_b_upto_12;
	}

	public void setR11_section_b_upto_12(BigDecimal r11_section_b_upto_12) {
		this.r11_section_b_upto_12 = r11_section_b_upto_12;
	}

	public BigDecimal getR11_section_b_upto_23() {
		return r11_section_b_upto_23;
	}

	public void setR11_section_b_upto_23(BigDecimal r11_section_b_upto_23) {
		this.r11_section_b_upto_23 = r11_section_b_upto_23;
	}

	public BigDecimal getR11_section_b_upto_34() {
		return r11_section_b_upto_34;
	}

	public void setR11_section_b_upto_34(BigDecimal r11_section_b_upto_34) {
		this.r11_section_b_upto_34 = r11_section_b_upto_34;
	}

	public BigDecimal getR11_section_b_upto_45() {
		return r11_section_b_upto_45;
	}

	public void setR11_section_b_upto_45(BigDecimal r11_section_b_upto_45) {
		this.r11_section_b_upto_45 = r11_section_b_upto_45;
	}

	public BigDecimal getR11_section_b_upto_5() {
		return r11_section_b_upto_5;
	}

	public void setR11_section_b_upto_5(BigDecimal r11_section_b_upto_5) {
		this.r11_section_b_upto_5 = r11_section_b_upto_5;
	}

	public String getR12_federal_govn() {
		return r12_federal_govn;
	}

	public void setR12_federal_govn(String r12_federal_govn) {
		this.r12_federal_govn = r12_federal_govn;
	}

	public BigDecimal getR12_federal_govn_size() {
		return r12_federal_govn_size;
	}

	public void setR12_federal_govn_size(BigDecimal r12_federal_govn_size) {
		this.r12_federal_govn_size = r12_federal_govn_size;
	}

	public BigDecimal getR12_federal_govn_aed() {
		return r12_federal_govn_aed;
	}

	public void setR12_federal_govn_aed(BigDecimal r12_federal_govn_aed) {
		this.r12_federal_govn_aed = r12_federal_govn_aed;
	}

	public BigDecimal getR12_federal_govn_total() {
		return r12_federal_govn_total;
	}

	public void setR12_federal_govn_total(BigDecimal r12_federal_govn_total) {
		this.r12_federal_govn_total = r12_federal_govn_total;
	}

	public BigDecimal getR12_federal_govn_upto3() {
		return r12_federal_govn_upto3;
	}

	public void setR12_federal_govn_upto3(BigDecimal r12_federal_govn_upto3) {
		this.r12_federal_govn_upto3 = r12_federal_govn_upto3;
	}

	public BigDecimal getR12_federal_govn_upto_36() {
		return r12_federal_govn_upto_36;
	}

	public void setR12_federal_govn_upto_36(BigDecimal r12_federal_govn_upto_36) {
		this.r12_federal_govn_upto_36 = r12_federal_govn_upto_36;
	}

	public BigDecimal getR12_federal_govn_upto_69() {
		return r12_federal_govn_upto_69;
	}

	public void setR12_federal_govn_upto_69(BigDecimal r12_federal_govn_upto_69) {
		this.r12_federal_govn_upto_69 = r12_federal_govn_upto_69;
	}

	public BigDecimal getR12_federal_govn_uptp_912() {
		return r12_federal_govn_uptp_912;
	}

	public void setR12_federal_govn_uptp_912(BigDecimal r12_federal_govn_uptp_912) {
		this.r12_federal_govn_uptp_912 = r12_federal_govn_uptp_912;
	}

	public BigDecimal getR12_federal_govn_upto_12() {
		return r12_federal_govn_upto_12;
	}

	public void setR12_federal_govn_upto_12(BigDecimal r12_federal_govn_upto_12) {
		this.r12_federal_govn_upto_12 = r12_federal_govn_upto_12;
	}

	public BigDecimal getR12_federal_govn_upto_23() {
		return r12_federal_govn_upto_23;
	}

	public void setR12_federal_govn_upto_23(BigDecimal r12_federal_govn_upto_23) {
		this.r12_federal_govn_upto_23 = r12_federal_govn_upto_23;
	}

	public BigDecimal getR12_federal_govn_upto_34() {
		return r12_federal_govn_upto_34;
	}

	public void setR12_federal_govn_upto_34(BigDecimal r12_federal_govn_upto_34) {
		this.r12_federal_govn_upto_34 = r12_federal_govn_upto_34;
	}

	public BigDecimal getR12_federal_govn_upto_45() {
		return r12_federal_govn_upto_45;
	}

	public void setR12_federal_govn_upto_45(BigDecimal r12_federal_govn_upto_45) {
		this.r12_federal_govn_upto_45 = r12_federal_govn_upto_45;
	}

	public BigDecimal getR12_federal_govn_upto_5() {
		return r12_federal_govn_upto_5;
	}

	public void setR12_federal_govn_upto_5(BigDecimal r12_federal_govn_upto_5) {
		this.r12_federal_govn_upto_5 = r12_federal_govn_upto_5;
	}

	public String getR13_federal_govn_na() {
		return r13_federal_govn_na;
	}

	public void setR13_federal_govn_na(String r13_federal_govn_na) {
		this.r13_federal_govn_na = r13_federal_govn_na;
	}

	public String getR13_federal_govn_na_currency() {
		return r13_federal_govn_na_currency;
	}

	public void setR13_federal_govn_na_currency(String r13_federal_govn_na_currency) {
		this.r13_federal_govn_na_currency = r13_federal_govn_na_currency;
	}

	public BigDecimal getR13_federal_govn_na_size() {
		return r13_federal_govn_na_size;
	}

	public void setR13_federal_govn_na_size(BigDecimal r13_federal_govn_na_size) {
		this.r13_federal_govn_na_size = r13_federal_govn_na_size;
	}

	public BigDecimal getR13_federal_govn_na_aed() {
		return r13_federal_govn_na_aed;
	}

	public void setR13_federal_govn_na_aed(BigDecimal r13_federal_govn_na_aed) {
		this.r13_federal_govn_na_aed = r13_federal_govn_na_aed;
	}

	public BigDecimal getR13_federal_govn_na_total() {
		return r13_federal_govn_na_total;
	}

	public void setR13_federal_govn_na_total(BigDecimal r13_federal_govn_na_total) {
		this.r13_federal_govn_na_total = r13_federal_govn_na_total;
	}

	public BigDecimal getR13_federal_govn_na_upto3() {
		return r13_federal_govn_na_upto3;
	}

	public void setR13_federal_govn_na_upto3(BigDecimal r13_federal_govn_na_upto3) {
		this.r13_federal_govn_na_upto3 = r13_federal_govn_na_upto3;
	}

	public BigDecimal getR13_federal_govn_na_upto_36() {
		return r13_federal_govn_na_upto_36;
	}

	public void setR13_federal_govn_na_upto_36(BigDecimal r13_federal_govn_na_upto_36) {
		this.r13_federal_govn_na_upto_36 = r13_federal_govn_na_upto_36;
	}

	public BigDecimal getR13_federal_govn_na_upto_69() {
		return r13_federal_govn_na_upto_69;
	}

	public void setR13_federal_govn_na_upto_69(BigDecimal r13_federal_govn_na_upto_69) {
		this.r13_federal_govn_na_upto_69 = r13_federal_govn_na_upto_69;
	}

	public BigDecimal getR13_federal_govn_na_uptp_912() {
		return r13_federal_govn_na_uptp_912;
	}

	public void setR13_federal_govn_na_uptp_912(BigDecimal r13_federal_govn_na_uptp_912) {
		this.r13_federal_govn_na_uptp_912 = r13_federal_govn_na_uptp_912;
	}

	public BigDecimal getR13_federal_govn_na_upto_12() {
		return r13_federal_govn_na_upto_12;
	}

	public void setR13_federal_govn_na_upto_12(BigDecimal r13_federal_govn_na_upto_12) {
		this.r13_federal_govn_na_upto_12 = r13_federal_govn_na_upto_12;
	}

	public BigDecimal getR13_federal_govn_na_upto_23() {
		return r13_federal_govn_na_upto_23;
	}

	public void setR13_federal_govn_na_upto_23(BigDecimal r13_federal_govn_na_upto_23) {
		this.r13_federal_govn_na_upto_23 = r13_federal_govn_na_upto_23;
	}

	public BigDecimal getR13_federal_govn_na_upto_34() {
		return r13_federal_govn_na_upto_34;
	}

	public void setR13_federal_govn_na_upto_34(BigDecimal r13_federal_govn_na_upto_34) {
		this.r13_federal_govn_na_upto_34 = r13_federal_govn_na_upto_34;
	}

	public BigDecimal getR13_federal_govn_na_upto_45() {
		return r13_federal_govn_na_upto_45;
	}

	public void setR13_federal_govn_na_upto_45(BigDecimal r13_federal_govn_na_upto_45) {
		this.r13_federal_govn_na_upto_45 = r13_federal_govn_na_upto_45;
	}

	public BigDecimal getR13_federal_govn_na_upto_5() {
		return r13_federal_govn_na_upto_5;
	}

	public void setR13_federal_govn_na_upto_5(BigDecimal r13_federal_govn_na_upto_5) {
		this.r13_federal_govn_na_upto_5 = r13_federal_govn_na_upto_5;
	}

	public String getR14_emirates() {
		return r14_emirates;
	}

	public void setR14_emirates(String r14_emirates) {
		this.r14_emirates = r14_emirates;
	}

	public BigDecimal getR14_emirates_size() {
		return r14_emirates_size;
	}

	public void setR14_emirates_size(BigDecimal r14_emirates_size) {
		this.r14_emirates_size = r14_emirates_size;
	}

	public BigDecimal getR14_emirates_aed() {
		return r14_emirates_aed;
	}

	public void setR14_emirates_aed(BigDecimal r14_emirates_aed) {
		this.r14_emirates_aed = r14_emirates_aed;
	}

	public BigDecimal getR14_emirates_total() {
		return r14_emirates_total;
	}

	public void setR14_emirates_total(BigDecimal r14_emirates_total) {
		this.r14_emirates_total = r14_emirates_total;
	}

	public BigDecimal getR14_emirates_upto3() {
		return r14_emirates_upto3;
	}

	public void setR14_emirates_upto3(BigDecimal r14_emirates_upto3) {
		this.r14_emirates_upto3 = r14_emirates_upto3;
	}

	public BigDecimal getR14_emirates_upto_36() {
		return r14_emirates_upto_36;
	}

	public void setR14_emirates_upto_36(BigDecimal r14_emirates_upto_36) {
		this.r14_emirates_upto_36 = r14_emirates_upto_36;
	}

	public BigDecimal getR14_emirates_upto_69() {
		return r14_emirates_upto_69;
	}

	public void setR14_emirates_upto_69(BigDecimal r14_emirates_upto_69) {
		this.r14_emirates_upto_69 = r14_emirates_upto_69;
	}

	public BigDecimal getR14_emirates_upto_912() {
		return r14_emirates_upto_912;
	}

	public void setR14_emirates_upto_912(BigDecimal r14_emirates_upto_912) {
		this.r14_emirates_upto_912 = r14_emirates_upto_912;
	}

	public BigDecimal getR14_emirates_upto_12() {
		return r14_emirates_upto_12;
	}

	public void setR14_emirates_upto_12(BigDecimal r14_emirates_upto_12) {
		this.r14_emirates_upto_12 = r14_emirates_upto_12;
	}

	public BigDecimal getR14_emirates_upto_23() {
		return r14_emirates_upto_23;
	}

	public void setR14_emirates_upto_23(BigDecimal r14_emirates_upto_23) {
		this.r14_emirates_upto_23 = r14_emirates_upto_23;
	}

	public BigDecimal getR14_emirates_upto_34() {
		return r14_emirates_upto_34;
	}

	public void setR14_emirates_upto_34(BigDecimal r14_emirates_upto_34) {
		this.r14_emirates_upto_34 = r14_emirates_upto_34;
	}

	public BigDecimal getR14_emirates_upto_45() {
		return r14_emirates_upto_45;
	}

	public void setR14_emirates_upto_45(BigDecimal r14_emirates_upto_45) {
		this.r14_emirates_upto_45 = r14_emirates_upto_45;
	}

	public BigDecimal getR14_emirates_upto_5() {
		return r14_emirates_upto_5;
	}

	public void setR14_emirates_upto_5(BigDecimal r14_emirates_upto_5) {
		this.r14_emirates_upto_5 = r14_emirates_upto_5;
	}

	public String getR15_emirates_na() {
		return r15_emirates_na;
	}

	public void setR15_emirates_na(String r15_emirates_na) {
		this.r15_emirates_na = r15_emirates_na;
	}

	public String getR15_emirates_na_currency() {
		return r15_emirates_na_currency;
	}

	public void setR15_emirates_na_currency(String r15_emirates_na_currency) {
		this.r15_emirates_na_currency = r15_emirates_na_currency;
	}

	public BigDecimal getR15_emirates_na_size() {
		return r15_emirates_na_size;
	}

	public void setR15_emirates_na_size(BigDecimal r15_emirates_na_size) {
		this.r15_emirates_na_size = r15_emirates_na_size;
	}

	public BigDecimal getR15_emirates_na_aed() {
		return r15_emirates_na_aed;
	}

	public void setR15_emirates_na_aed(BigDecimal r15_emirates_na_aed) {
		this.r15_emirates_na_aed = r15_emirates_na_aed;
	}

	public BigDecimal getR15_emirates_na_total() {
		return r15_emirates_na_total;
	}

	public void setR15_emirates_na_total(BigDecimal r15_emirates_na_total) {
		this.r15_emirates_na_total = r15_emirates_na_total;
	}

	public BigDecimal getR15_emirates_na_upto3() {
		return r15_emirates_na_upto3;
	}

	public void setR15_emirates_na_upto3(BigDecimal r15_emirates_na_upto3) {
		this.r15_emirates_na_upto3 = r15_emirates_na_upto3;
	}

	public BigDecimal getR15_emirates_na_upto_36() {
		return r15_emirates_na_upto_36;
	}

	public void setR15_emirates_na_upto_36(BigDecimal r15_emirates_na_upto_36) {
		this.r15_emirates_na_upto_36 = r15_emirates_na_upto_36;
	}

	public BigDecimal getR15_emirates_na_upto_69() {
		return r15_emirates_na_upto_69;
	}

	public void setR15_emirates_na_upto_69(BigDecimal r15_emirates_na_upto_69) {
		this.r15_emirates_na_upto_69 = r15_emirates_na_upto_69;
	}

	public BigDecimal getR15_emirates_na_upto_912() {
		return r15_emirates_na_upto_912;
	}

	public void setR15_emirates_na_upto_912(BigDecimal r15_emirates_na_upto_912) {
		this.r15_emirates_na_upto_912 = r15_emirates_na_upto_912;
	}

	public BigDecimal getR15_emirates_na_upto_12() {
		return r15_emirates_na_upto_12;
	}

	public void setR15_emirates_na_upto_12(BigDecimal r15_emirates_na_upto_12) {
		this.r15_emirates_na_upto_12 = r15_emirates_na_upto_12;
	}

	public BigDecimal getR15_emirates_na_upto_23() {
		return r15_emirates_na_upto_23;
	}

	public void setR15_emirates_na_upto_23(BigDecimal r15_emirates_na_upto_23) {
		this.r15_emirates_na_upto_23 = r15_emirates_na_upto_23;
	}

	public BigDecimal getR15_emirates_na_upto_34() {
		return r15_emirates_na_upto_34;
	}

	public void setR15_emirates_na_upto_34(BigDecimal r15_emirates_na_upto_34) {
		this.r15_emirates_na_upto_34 = r15_emirates_na_upto_34;
	}

	public BigDecimal getR15_emirates_na_upto_45() {
		return r15_emirates_na_upto_45;
	}

	public void setR15_emirates_na_upto_45(BigDecimal r15_emirates_na_upto_45) {
		this.r15_emirates_na_upto_45 = r15_emirates_na_upto_45;
	}

	public BigDecimal getR15_emirates_na_upto_5() {
		return r15_emirates_na_upto_5;
	}

	public void setR15_emirates_na_upto_5(BigDecimal r15_emirates_na_upto_5) {
		this.r15_emirates_na_upto_5 = r15_emirates_na_upto_5;
	}

	public String getR16_bank() {
		return r16_bank;
	}

	public void setR16_bank(String r16_bank) {
		this.r16_bank = r16_bank;
	}

	public BigDecimal getR16_bank_size() {
		return r16_bank_size;
	}

	public void setR16_bank_size(BigDecimal r16_bank_size) {
		this.r16_bank_size = r16_bank_size;
	}

	public BigDecimal getR16_bank_aed() {
		return r16_bank_aed;
	}

	public void setR16_bank_aed(BigDecimal r16_bank_aed) {
		this.r16_bank_aed = r16_bank_aed;
	}

	public BigDecimal getR16_bank_total() {
		return r16_bank_total;
	}

	public void setR16_bank_total(BigDecimal r16_bank_total) {
		this.r16_bank_total = r16_bank_total;
	}

	public BigDecimal getR16_bank_upto3() {
		return r16_bank_upto3;
	}

	public void setR16_bank_upto3(BigDecimal r16_bank_upto3) {
		this.r16_bank_upto3 = r16_bank_upto3;
	}

	public BigDecimal getR16_bank_upto_36() {
		return r16_bank_upto_36;
	}

	public void setR16_bank_upto_36(BigDecimal r16_bank_upto_36) {
		this.r16_bank_upto_36 = r16_bank_upto_36;
	}

	public BigDecimal getR16_bank_upto_69() {
		return r16_bank_upto_69;
	}

	public void setR16_bank_upto_69(BigDecimal r16_bank_upto_69) {
		this.r16_bank_upto_69 = r16_bank_upto_69;
	}

	public BigDecimal getR16_bank_upto_912() {
		return r16_bank_upto_912;
	}

	public void setR16_bank_upto_912(BigDecimal r16_bank_upto_912) {
		this.r16_bank_upto_912 = r16_bank_upto_912;
	}

	public BigDecimal getR16_bank_upto_12() {
		return r16_bank_upto_12;
	}

	public void setR16_bank_upto_12(BigDecimal r16_bank_upto_12) {
		this.r16_bank_upto_12 = r16_bank_upto_12;
	}

	public BigDecimal getR16_bank_upto_23() {
		return r16_bank_upto_23;
	}

	public void setR16_bank_upto_23(BigDecimal r16_bank_upto_23) {
		this.r16_bank_upto_23 = r16_bank_upto_23;
	}

	public BigDecimal getR16_bank_upto_34() {
		return r16_bank_upto_34;
	}

	public void setR16_bank_upto_34(BigDecimal r16_bank_upto_34) {
		this.r16_bank_upto_34 = r16_bank_upto_34;
	}

	public BigDecimal getR16_bank_upto_45() {
		return r16_bank_upto_45;
	}

	public void setR16_bank_upto_45(BigDecimal r16_bank_upto_45) {
		this.r16_bank_upto_45 = r16_bank_upto_45;
	}

	public BigDecimal getR16_bank_upto_5() {
		return r16_bank_upto_5;
	}

	public void setR16_bank_upto_5(BigDecimal r16_bank_upto_5) {
		this.r16_bank_upto_5 = r16_bank_upto_5;
	}

	public String getR17_bank_na() {
		return r17_bank_na;
	}

	public void setR17_bank_na(String r17_bank_na) {
		this.r17_bank_na = r17_bank_na;
	}

	public String getR17_bank_na_currency() {
		return r17_bank_na_currency;
	}

	public void setR17_bank_na_currency(String r17_bank_na_currency) {
		this.r17_bank_na_currency = r17_bank_na_currency;
	}

	public BigDecimal getR17_bank_na_size() {
		return r17_bank_na_size;
	}

	public void setR17_bank_na_size(BigDecimal r17_bank_na_size) {
		this.r17_bank_na_size = r17_bank_na_size;
	}

	public BigDecimal getR17_bank_na_aed() {
		return r17_bank_na_aed;
	}

	public void setR17_bank_na_aed(BigDecimal r17_bank_na_aed) {
		this.r17_bank_na_aed = r17_bank_na_aed;
	}

	public BigDecimal getR17_bank_na_total() {
		return r17_bank_na_total;
	}

	public void setR17_bank_na_total(BigDecimal r17_bank_na_total) {
		this.r17_bank_na_total = r17_bank_na_total;
	}

	public BigDecimal getR17_bank_na_upto3() {
		return r17_bank_na_upto3;
	}

	public void setR17_bank_na_upto3(BigDecimal r17_bank_na_upto3) {
		this.r17_bank_na_upto3 = r17_bank_na_upto3;
	}

	public BigDecimal getR17_bank_na_upto_36() {
		return r17_bank_na_upto_36;
	}

	public void setR17_bank_na_upto_36(BigDecimal r17_bank_na_upto_36) {
		this.r17_bank_na_upto_36 = r17_bank_na_upto_36;
	}

	public BigDecimal getR17_bank_na_upto_69() {
		return r17_bank_na_upto_69;
	}

	public void setR17_bank_na_upto_69(BigDecimal r17_bank_na_upto_69) {
		this.r17_bank_na_upto_69 = r17_bank_na_upto_69;
	}

	public BigDecimal getR17_bank_na_upto_912() {
		return r17_bank_na_upto_912;
	}

	public void setR17_bank_na_upto_912(BigDecimal r17_bank_na_upto_912) {
		this.r17_bank_na_upto_912 = r17_bank_na_upto_912;
	}

	public BigDecimal getR17_bank_na_upto_12() {
		return r17_bank_na_upto_12;
	}

	public void setR17_bank_na_upto_12(BigDecimal r17_bank_na_upto_12) {
		this.r17_bank_na_upto_12 = r17_bank_na_upto_12;
	}

	public BigDecimal getR17_bank_na_upto_23() {
		return r17_bank_na_upto_23;
	}

	public void setR17_bank_na_upto_23(BigDecimal r17_bank_na_upto_23) {
		this.r17_bank_na_upto_23 = r17_bank_na_upto_23;
	}

	public BigDecimal getR17_bank_na_upto_34() {
		return r17_bank_na_upto_34;
	}

	public void setR17_bank_na_upto_34(BigDecimal r17_bank_na_upto_34) {
		this.r17_bank_na_upto_34 = r17_bank_na_upto_34;
	}

	public BigDecimal getR17_bank_na_upto_45() {
		return r17_bank_na_upto_45;
	}

	public void setR17_bank_na_upto_45(BigDecimal r17_bank_na_upto_45) {
		this.r17_bank_na_upto_45 = r17_bank_na_upto_45;
	}

	public BigDecimal getR17_bank_na_upto_5() {
		return r17_bank_na_upto_5;
	}

	public void setR17_bank_na_upto_5(BigDecimal r17_bank_na_upto_5) {
		this.r17_bank_na_upto_5 = r17_bank_na_upto_5;
	}

	public String getR18_nbfi() {
		return r18_nbfi;
	}

	public void setR18_nbfi(String r18_nbfi) {
		this.r18_nbfi = r18_nbfi;
	}

	public BigDecimal getR18_nbfi_size() {
		return r18_nbfi_size;
	}

	public void setR18_nbfi_size(BigDecimal r18_nbfi_size) {
		this.r18_nbfi_size = r18_nbfi_size;
	}

	public BigDecimal getR18_nbfi_aed() {
		return r18_nbfi_aed;
	}

	public void setR18_nbfi_aed(BigDecimal r18_nbfi_aed) {
		this.r18_nbfi_aed = r18_nbfi_aed;
	}

	public BigDecimal getR18_nbfi_total() {
		return r18_nbfi_total;
	}

	public void setR18_nbfi_total(BigDecimal r18_nbfi_total) {
		this.r18_nbfi_total = r18_nbfi_total;
	}

	public BigDecimal getR18_nbfi_upto3() {
		return r18_nbfi_upto3;
	}

	public void setR18_nbfi_upto3(BigDecimal r18_nbfi_upto3) {
		this.r18_nbfi_upto3 = r18_nbfi_upto3;
	}

	public BigDecimal getR18_nbfi_upto_36() {
		return r18_nbfi_upto_36;
	}

	public void setR18_nbfi_upto_36(BigDecimal r18_nbfi_upto_36) {
		this.r18_nbfi_upto_36 = r18_nbfi_upto_36;
	}

	public BigDecimal getR18_nbfi_upto_69() {
		return r18_nbfi_upto_69;
	}

	public void setR18_nbfi_upto_69(BigDecimal r18_nbfi_upto_69) {
		this.r18_nbfi_upto_69 = r18_nbfi_upto_69;
	}

	public BigDecimal getR18_nbfi_upto_912() {
		return r18_nbfi_upto_912;
	}

	public void setR18_nbfi_upto_912(BigDecimal r18_nbfi_upto_912) {
		this.r18_nbfi_upto_912 = r18_nbfi_upto_912;
	}

	public BigDecimal getR18_nbfi_upto_12() {
		return r18_nbfi_upto_12;
	}

	public void setR18_nbfi_upto_12(BigDecimal r18_nbfi_upto_12) {
		this.r18_nbfi_upto_12 = r18_nbfi_upto_12;
	}

	public BigDecimal getR18_nbfi_upto_23() {
		return r18_nbfi_upto_23;
	}

	public void setR18_nbfi_upto_23(BigDecimal r18_nbfi_upto_23) {
		this.r18_nbfi_upto_23 = r18_nbfi_upto_23;
	}

	public BigDecimal getR18_nbfi_upto_34() {
		return r18_nbfi_upto_34;
	}

	public void setR18_nbfi_upto_34(BigDecimal r18_nbfi_upto_34) {
		this.r18_nbfi_upto_34 = r18_nbfi_upto_34;
	}

	public BigDecimal getR18_nbfi_upto_45() {
		return r18_nbfi_upto_45;
	}

	public void setR18_nbfi_upto_45(BigDecimal r18_nbfi_upto_45) {
		this.r18_nbfi_upto_45 = r18_nbfi_upto_45;
	}

	public BigDecimal getR18_nbfi_upto_5() {
		return r18_nbfi_upto_5;
	}

	public void setR18_nbfi_upto_5(BigDecimal r18_nbfi_upto_5) {
		this.r18_nbfi_upto_5 = r18_nbfi_upto_5;
	}

	public String getR19_nbfi_na() {
		return r19_nbfi_na;
	}

	public void setR19_nbfi_na(String r19_nbfi_na) {
		this.r19_nbfi_na = r19_nbfi_na;
	}

	public String getR19_nbfi_na_currency() {
		return r19_nbfi_na_currency;
	}

	public void setR19_nbfi_na_currency(String r19_nbfi_na_currency) {
		this.r19_nbfi_na_currency = r19_nbfi_na_currency;
	}

	public BigDecimal getR19_nbfi_na_size() {
		return r19_nbfi_na_size;
	}

	public void setR19_nbfi_na_size(BigDecimal r19_nbfi_na_size) {
		this.r19_nbfi_na_size = r19_nbfi_na_size;
	}

	public BigDecimal getR19_nbfi_na_aed() {
		return r19_nbfi_na_aed;
	}

	public void setR19_nbfi_na_aed(BigDecimal r19_nbfi_na_aed) {
		this.r19_nbfi_na_aed = r19_nbfi_na_aed;
	}

	public BigDecimal getR19_nbfi_na_total() {
		return r19_nbfi_na_total;
	}

	public void setR19_nbfi_na_total(BigDecimal r19_nbfi_na_total) {
		this.r19_nbfi_na_total = r19_nbfi_na_total;
	}

	public BigDecimal getR19_nbfi_na_upto3() {
		return r19_nbfi_na_upto3;
	}

	public void setR19_nbfi_na_upto3(BigDecimal r19_nbfi_na_upto3) {
		this.r19_nbfi_na_upto3 = r19_nbfi_na_upto3;
	}

	public BigDecimal getR19_nbfi_na_upto_36() {
		return r19_nbfi_na_upto_36;
	}

	public void setR19_nbfi_na_upto_36(BigDecimal r19_nbfi_na_upto_36) {
		this.r19_nbfi_na_upto_36 = r19_nbfi_na_upto_36;
	}

	public BigDecimal getR19_nbfi_na_upto_69() {
		return r19_nbfi_na_upto_69;
	}

	public void setR19_nbfi_na_upto_69(BigDecimal r19_nbfi_na_upto_69) {
		this.r19_nbfi_na_upto_69 = r19_nbfi_na_upto_69;
	}

	public BigDecimal getR19_nbfi_na_upto_912() {
		return r19_nbfi_na_upto_912;
	}

	public void setR19_nbfi_na_upto_912(BigDecimal r19_nbfi_na_upto_912) {
		this.r19_nbfi_na_upto_912 = r19_nbfi_na_upto_912;
	}

	public BigDecimal getR19_nbfi_na_upto_12() {
		return r19_nbfi_na_upto_12;
	}

	public void setR19_nbfi_na_upto_12(BigDecimal r19_nbfi_na_upto_12) {
		this.r19_nbfi_na_upto_12 = r19_nbfi_na_upto_12;
	}

	public BigDecimal getR19_nbfi_na_upto_23() {
		return r19_nbfi_na_upto_23;
	}

	public void setR19_nbfi_na_upto_23(BigDecimal r19_nbfi_na_upto_23) {
		this.r19_nbfi_na_upto_23 = r19_nbfi_na_upto_23;
	}

	public BigDecimal getR19_nbfi_na_upto_34() {
		return r19_nbfi_na_upto_34;
	}

	public void setR19_nbfi_na_upto_34(BigDecimal r19_nbfi_na_upto_34) {
		this.r19_nbfi_na_upto_34 = r19_nbfi_na_upto_34;
	}

	public BigDecimal getR19_nbfi_na_upto_45() {
		return r19_nbfi_na_upto_45;
	}

	public void setR19_nbfi_na_upto_45(BigDecimal r19_nbfi_na_upto_45) {
		this.r19_nbfi_na_upto_45 = r19_nbfi_na_upto_45;
	}

	public BigDecimal getR19_nbfi_na_upto_5() {
		return r19_nbfi_na_upto_5;
	}

	public void setR19_nbfi_na_upto_5(BigDecimal r19_nbfi_na_upto_5) {
		this.r19_nbfi_na_upto_5 = r19_nbfi_na_upto_5;
	}

	public String getR20_other() {
		return r20_other;
	}

	public void setR20_other(String r20_other) {
		this.r20_other = r20_other;
	}

	public BigDecimal getR20_other_size() {
		return r20_other_size;
	}

	public void setR20_other_size(BigDecimal r20_other_size) {
		this.r20_other_size = r20_other_size;
	}

	public BigDecimal getR20_other_aed() {
		return r20_other_aed;
	}

	public void setR20_other_aed(BigDecimal r20_other_aed) {
		this.r20_other_aed = r20_other_aed;
	}

	public BigDecimal getR20_other_total() {
		return r20_other_total;
	}

	public void setR20_other_total(BigDecimal r20_other_total) {
		this.r20_other_total = r20_other_total;
	}

	public BigDecimal getR20_other_upto3() {
		return r20_other_upto3;
	}

	public void setR20_other_upto3(BigDecimal r20_other_upto3) {
		this.r20_other_upto3 = r20_other_upto3;
	}

	public BigDecimal getR20_other_upto_36() {
		return r20_other_upto_36;
	}

	public void setR20_other_upto_36(BigDecimal r20_other_upto_36) {
		this.r20_other_upto_36 = r20_other_upto_36;
	}

	public BigDecimal getR20_other_upto_69() {
		return r20_other_upto_69;
	}

	public void setR20_other_upto_69(BigDecimal r20_other_upto_69) {
		this.r20_other_upto_69 = r20_other_upto_69;
	}

	public BigDecimal getR20_other_upto_912() {
		return r20_other_upto_912;
	}

	public void setR20_other_upto_912(BigDecimal r20_other_upto_912) {
		this.r20_other_upto_912 = r20_other_upto_912;
	}

	public BigDecimal getR20_other_upto_12() {
		return r20_other_upto_12;
	}

	public void setR20_other_upto_12(BigDecimal r20_other_upto_12) {
		this.r20_other_upto_12 = r20_other_upto_12;
	}

	public BigDecimal getR20_other_upto_23() {
		return r20_other_upto_23;
	}

	public void setR20_other_upto_23(BigDecimal r20_other_upto_23) {
		this.r20_other_upto_23 = r20_other_upto_23;
	}

	public BigDecimal getR20_other_upto_34() {
		return r20_other_upto_34;
	}

	public void setR20_other_upto_34(BigDecimal r20_other_upto_34) {
		this.r20_other_upto_34 = r20_other_upto_34;
	}

	public BigDecimal getR20_other_upto_45() {
		return r20_other_upto_45;
	}

	public void setR20_other_upto_45(BigDecimal r20_other_upto_45) {
		this.r20_other_upto_45 = r20_other_upto_45;
	}

	public BigDecimal getR20_other_upto_5() {
		return r20_other_upto_5;
	}

	public void setR20_other_upto_5(BigDecimal r20_other_upto_5) {
		this.r20_other_upto_5 = r20_other_upto_5;
	}

	public String getR21_other_na() {
		return r21_other_na;
	}

	public void setR21_other_na(String r21_other_na) {
		this.r21_other_na = r21_other_na;
	}

	public String getR21_other_na_currency() {
		return r21_other_na_currency;
	}

	public void setR21_other_na_currency(String r21_other_na_currency) {
		this.r21_other_na_currency = r21_other_na_currency;
	}

	public BigDecimal getR21_other_na_size() {
		return r21_other_na_size;
	}

	public void setR21_other_na_size(BigDecimal r21_other_na_size) {
		this.r21_other_na_size = r21_other_na_size;
	}

	public BigDecimal getR21_other_na_aed() {
		return r21_other_na_aed;
	}

	public void setR21_other_na_aed(BigDecimal r21_other_na_aed) {
		this.r21_other_na_aed = r21_other_na_aed;
	}

	public BigDecimal getR21_other_na_total() {
		return r21_other_na_total;
	}

	public void setR21_other_na_total(BigDecimal r21_other_na_total) {
		this.r21_other_na_total = r21_other_na_total;
	}

	public BigDecimal getR21_other_na_upto3() {
		return r21_other_na_upto3;
	}

	public void setR21_other_na_upto3(BigDecimal r21_other_na_upto3) {
		this.r21_other_na_upto3 = r21_other_na_upto3;
	}

	public BigDecimal getR21_other_na_upto_36() {
		return r21_other_na_upto_36;
	}

	public void setR21_other_na_upto_36(BigDecimal r21_other_na_upto_36) {
		this.r21_other_na_upto_36 = r21_other_na_upto_36;
	}

	public BigDecimal getR21_other_na_upto_69() {
		return r21_other_na_upto_69;
	}

	public void setR21_other_na_upto_69(BigDecimal r21_other_na_upto_69) {
		this.r21_other_na_upto_69 = r21_other_na_upto_69;
	}

	public BigDecimal getR21_other_na_upto_912() {
		return r21_other_na_upto_912;
	}

	public void setR21_other_na_upto_912(BigDecimal r21_other_na_upto_912) {
		this.r21_other_na_upto_912 = r21_other_na_upto_912;
	}

	public BigDecimal getR21_other_na_upto_12() {
		return r21_other_na_upto_12;
	}

	public void setR21_other_na_upto_12(BigDecimal r21_other_na_upto_12) {
		this.r21_other_na_upto_12 = r21_other_na_upto_12;
	}

	public BigDecimal getR21_other_na_upto_23() {
		return r21_other_na_upto_23;
	}

	public void setR21_other_na_upto_23(BigDecimal r21_other_na_upto_23) {
		this.r21_other_na_upto_23 = r21_other_na_upto_23;
	}

	public BigDecimal getR21_other_na_upto_34() {
		return r21_other_na_upto_34;
	}

	public void setR21_other_na_upto_34(BigDecimal r21_other_na_upto_34) {
		this.r21_other_na_upto_34 = r21_other_na_upto_34;
	}

	public BigDecimal getR21_other_na_upto_45() {
		return r21_other_na_upto_45;
	}

	public void setR21_other_na_upto_45(BigDecimal r21_other_na_upto_45) {
		this.r21_other_na_upto_45 = r21_other_na_upto_45;
	}

	public BigDecimal getR21_other_na_upto_5() {
		return r21_other_na_upto_5;
	}

	public void setR21_other_na_upto_5(BigDecimal r21_other_na_upto_5) {
		this.r21_other_na_upto_5 = r21_other_na_upto_5;
	}

	public String getR22_total() {
		return r22_total;
	}

	public void setR22_total(String r22_total) {
		this.r22_total = r22_total;
	}

	public BigDecimal getR22_total_size() {
		return r22_total_size;
	}

	public void setR22_total_size(BigDecimal r22_total_size) {
		this.r22_total_size = r22_total_size;
	}

	public BigDecimal getR22_total_aed() {
		return r22_total_aed;
	}

	public void setR22_total_aed(BigDecimal r22_total_aed) {
		this.r22_total_aed = r22_total_aed;
	}

	public BigDecimal getR22_total_total() {
		return r22_total_total;
	}

	public void setR22_total_total(BigDecimal r22_total_total) {
		this.r22_total_total = r22_total_total;
	}

	public BigDecimal getR22_total_upto3() {
		return r22_total_upto3;
	}

	public void setR22_total_upto3(BigDecimal r22_total_upto3) {
		this.r22_total_upto3 = r22_total_upto3;
	}

	public BigDecimal getR22_total_upto_36() {
		return r22_total_upto_36;
	}

	public void setR22_total_upto_36(BigDecimal r22_total_upto_36) {
		this.r22_total_upto_36 = r22_total_upto_36;
	}

	public BigDecimal getR22_total_upto_69() {
		return r22_total_upto_69;
	}

	public void setR22_total_upto_69(BigDecimal r22_total_upto_69) {
		this.r22_total_upto_69 = r22_total_upto_69;
	}

	public BigDecimal getR22_total_upto_912() {
		return r22_total_upto_912;
	}

	public void setR22_total_upto_912(BigDecimal r22_total_upto_912) {
		this.r22_total_upto_912 = r22_total_upto_912;
	}

	public BigDecimal getR22_total_upto_12() {
		return r22_total_upto_12;
	}

	public void setR22_total_upto_12(BigDecimal r22_total_upto_12) {
		this.r22_total_upto_12 = r22_total_upto_12;
	}

	public BigDecimal getR22_total_upto_23() {
		return r22_total_upto_23;
	}

	public void setR22_total_upto_23(BigDecimal r22_total_upto_23) {
		this.r22_total_upto_23 = r22_total_upto_23;
	}

	public BigDecimal getR22_total_upto_34() {
		return r22_total_upto_34;
	}

	public void setR22_total_upto_34(BigDecimal r22_total_upto_34) {
		this.r22_total_upto_34 = r22_total_upto_34;
	}

	public BigDecimal getR22_total_upto_45() {
		return r22_total_upto_45;
	}

	public void setR22_total_upto_45(BigDecimal r22_total_upto_45) {
		this.r22_total_upto_45 = r22_total_upto_45;
	}

	public BigDecimal getR22_total_upto_5() {
		return r22_total_upto_5;
	}

	public void setR22_total_upto_5(BigDecimal r22_total_upto_5) {
		this.r22_total_upto_5 = r22_total_upto_5;
	}

	public String getR23_total() {
		return r23_total;
	}

	public void setR23_total(String r23_total) {
		this.r23_total = r23_total;
	}

	public String getR23_total_na_currency() {
		return r23_total_na_currency;
	}

	public void setR23_total_na_currency(String r23_total_na_currency) {
		this.r23_total_na_currency = r23_total_na_currency;
	}

	public BigDecimal getR23_total_na_size() {
		return r23_total_na_size;
	}

	public void setR23_total_na_size(BigDecimal r23_total_na_size) {
		this.r23_total_na_size = r23_total_na_size;
	}

	public BigDecimal getR23_total_na_aed() {
		return r23_total_na_aed;
	}

	public void setR23_total_na_aed(BigDecimal r23_total_na_aed) {
		this.r23_total_na_aed = r23_total_na_aed;
	}

	public BigDecimal getR23_total_na_total() {
		return r23_total_na_total;
	}

	public void setR23_total_na_total(BigDecimal r23_total_na_total) {
		this.r23_total_na_total = r23_total_na_total;
	}

	public BigDecimal getR23_total_na_upto3() {
		return r23_total_na_upto3;
	}

	public void setR23_total_na_upto3(BigDecimal r23_total_na_upto3) {
		this.r23_total_na_upto3 = r23_total_na_upto3;
	}

	public BigDecimal getR23_total_na_upto_36() {
		return r23_total_na_upto_36;
	}

	public void setR23_total_na_upto_36(BigDecimal r23_total_na_upto_36) {
		this.r23_total_na_upto_36 = r23_total_na_upto_36;
	}

	public BigDecimal getR23_total_na_upto_69() {
		return r23_total_na_upto_69;
	}

	public void setR23_total_na_upto_69(BigDecimal r23_total_na_upto_69) {
		this.r23_total_na_upto_69 = r23_total_na_upto_69;
	}

	public BigDecimal getR23_total_na_upto_912() {
		return r23_total_na_upto_912;
	}

	public void setR23_total_na_upto_912(BigDecimal r23_total_na_upto_912) {
		this.r23_total_na_upto_912 = r23_total_na_upto_912;
	}

	public BigDecimal getR23_total_na_upto_12() {
		return r23_total_na_upto_12;
	}

	public void setR23_total_na_upto_12(BigDecimal r23_total_na_upto_12) {
		this.r23_total_na_upto_12 = r23_total_na_upto_12;
	}

	public BigDecimal getR23_total_na_upto_23() {
		return r23_total_na_upto_23;
	}

	public void setR23_total_na_upto_23(BigDecimal r23_total_na_upto_23) {
		this.r23_total_na_upto_23 = r23_total_na_upto_23;
	}

	public BigDecimal getR23_total_na_upto_34() {
		return r23_total_na_upto_34;
	}

	public void setR23_total_na_upto_34(BigDecimal r23_total_na_upto_34) {
		this.r23_total_na_upto_34 = r23_total_na_upto_34;
	}

	public BigDecimal getR23_total_na_upto_45() {
		return r23_total_na_upto_45;
	}

	public void setR23_total_na_upto_45(BigDecimal r23_total_na_upto_45) {
		this.r23_total_na_upto_45 = r23_total_na_upto_45;
	}

	public BigDecimal getR23_total_na_upto_5() {
		return r23_total_na_upto_5;
	}

	public void setR23_total_na_upto_5(BigDecimal r23_total_na_upto_5) {
		this.r23_total_na_upto_5 = r23_total_na_upto_5;
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

	public String getProgarm_instrument_name() {
		return progarm_instrument_name;
	}

	public void setProgarm_instrument_name(String progarm_instrument_name) {
		this.progarm_instrument_name = progarm_instrument_name;
	}

	public String getCurrency_of_issue() {
		return currency_of_issue;
	}

	public void setCurrency_of_issue(String currency_of_issue) {
		this.currency_of_issue = currency_of_issue;
	}

	public String getSize_of_prgoam() {
		return size_of_prgoam;
	}

	public void setSize_of_prgoam(String size_of_prgoam) {
		this.size_of_prgoam = size_of_prgoam;
	}

	public String getAed_equivalent() {
		return aed_equivalent;
	}

	public void setAed_equivalent(String aed_equivalent) {
		this.aed_equivalent = aed_equivalent;
	}

	public String getAed_iss_total() {
		return aed_iss_total;
	}

	public void setAed_iss_total(String aed_iss_total) {
		this.aed_iss_total = aed_iss_total;
	}

	public String getMonth_upto3() {
		return month_upto3;
	}

	public void setMonth_upto3(String month_upto3) {
		this.month_upto3 = month_upto3;
	}

	public String getMonth3to6() {
		return month3to6;
	}

	public void setMonth3to6(String month3to6) {
		this.month3to6 = month3to6;
	}

	public String getMonth6to9() {
		return month6to9;
	}

	public void setMonth6to9(String month6to9) {
		this.month6to9 = month6to9;
	}

	public String getMonth9to12() {
		return month9to12;
	}

	public void setMonth9to12(String month9to12) {
		this.month9to12 = month9to12;
	}

	public String getYear1to2() {
		return year1to2;
	}

	public void setYear1to2(String year1to2) {
		this.year1to2 = year1to2;
	}

	public String getYear2to3() {
		return year2to3;
	}

	public void setYear2to3(String year2to3) {
		this.year2to3 = year2to3;
	}

	public String getYear3to4() {
		return year3to4;
	}

	public void setYear3to4(String year3to4) {
		this.year3to4 = year3to4;
	}

	public String getYear4to5() {
		return year4to5;
	}

	public void setYear4to5(String year4to5) {
		this.year4to5 = year4to5;
	}

	public String getYear_upto5() {
		return year_upto5;
	}

	public void setYear_upto5(String year_upto5) {
		this.year_upto5 = year_upto5;
	}

	public BigDecimal getSrl_no() {
		return srl_no;
	}

	public void setSrl_no(BigDecimal srl_no) {
		this.srl_no = srl_no;
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

	public BRF36_ENTITY(String r9_section_a, BigDecimal r9_section_a_size, BigDecimal r9_section_a_aed,
			BigDecimal r9_section_a_total, BigDecimal r9_section_a_upto3, BigDecimal r9_section_a_upto_36,
			BigDecimal r9_section_a_upto_69, BigDecimal r9_section_a_upto_912, BigDecimal r9_section_a_upto_12,
			BigDecimal r9_section_a_upto_23, BigDecimal r9_section_a_upto_34, BigDecimal r9_section_a_upto_45,
			BigDecimal r9_section_a_upto_5, String r10_section_a_na, String r10_section_a_na_currency,
			BigDecimal r10_section_a_na_size, BigDecimal r10_section_a_na_aed, BigDecimal r10_section_a_na_total,
			BigDecimal r10_section_a_na_upto3, BigDecimal r10_section_a_na_upto_36, BigDecimal r10_section_a_na_upto_69,
			BigDecimal r10_section_a_na_upto_912, BigDecimal r10_section_a_na_upto_12,
			BigDecimal r10_section_a_na_upto_23, BigDecimal r10_section_a_na_upto_34,
			BigDecimal r10_section_a_na_upto_45, BigDecimal r10_section_a_na_upto_5, String r11_section_b,
			BigDecimal r11_section_b_size, BigDecimal r11_section_b_aed, BigDecimal r11_section_b_total,
			BigDecimal r11_section_b_upto3, BigDecimal r11_section_b_upto_36, BigDecimal r11_section_b_upto_69,
			BigDecimal r11_section_b_upto_912, BigDecimal r11_section_b_upto_12, BigDecimal r11_section_b_upto_23,
			BigDecimal r11_section_b_upto_34, BigDecimal r11_section_b_upto_45, BigDecimal r11_section_b_upto_5,
			String r12_federal_govn, BigDecimal r12_federal_govn_size, BigDecimal r12_federal_govn_aed,
			BigDecimal r12_federal_govn_total, BigDecimal r12_federal_govn_upto3, BigDecimal r12_federal_govn_upto_36,
			BigDecimal r12_federal_govn_upto_69, BigDecimal r12_federal_govn_uptp_912,
			BigDecimal r12_federal_govn_upto_12, BigDecimal r12_federal_govn_upto_23,
			BigDecimal r12_federal_govn_upto_34, BigDecimal r12_federal_govn_upto_45,
			BigDecimal r12_federal_govn_upto_5, String r13_federal_govn_na, String r13_federal_govn_na_currency,
			BigDecimal r13_federal_govn_na_size, BigDecimal r13_federal_govn_na_aed,
			BigDecimal r13_federal_govn_na_total, BigDecimal r13_federal_govn_na_upto3,
			BigDecimal r13_federal_govn_na_upto_36, BigDecimal r13_federal_govn_na_upto_69,
			BigDecimal r13_federal_govn_na_uptp_912, BigDecimal r13_federal_govn_na_upto_12,
			BigDecimal r13_federal_govn_na_upto_23, BigDecimal r13_federal_govn_na_upto_34,
			BigDecimal r13_federal_govn_na_upto_45, BigDecimal r13_federal_govn_na_upto_5, String r14_emirates,
			BigDecimal r14_emirates_size, BigDecimal r14_emirates_aed, BigDecimal r14_emirates_total,
			BigDecimal r14_emirates_upto3, BigDecimal r14_emirates_upto_36, BigDecimal r14_emirates_upto_69,
			BigDecimal r14_emirates_upto_912, BigDecimal r14_emirates_upto_12, BigDecimal r14_emirates_upto_23,
			BigDecimal r14_emirates_upto_34, BigDecimal r14_emirates_upto_45, BigDecimal r14_emirates_upto_5,
			String r15_emirates_na, String r15_emirates_na_currency, BigDecimal r15_emirates_na_size,
			BigDecimal r15_emirates_na_aed, BigDecimal r15_emirates_na_total, BigDecimal r15_emirates_na_upto3,
			BigDecimal r15_emirates_na_upto_36, BigDecimal r15_emirates_na_upto_69, BigDecimal r15_emirates_na_upto_912,
			BigDecimal r15_emirates_na_upto_12, BigDecimal r15_emirates_na_upto_23, BigDecimal r15_emirates_na_upto_34,
			BigDecimal r15_emirates_na_upto_45, BigDecimal r15_emirates_na_upto_5, String r16_bank,
			BigDecimal r16_bank_size, BigDecimal r16_bank_aed, BigDecimal r16_bank_total, BigDecimal r16_bank_upto3,
			BigDecimal r16_bank_upto_36, BigDecimal r16_bank_upto_69, BigDecimal r16_bank_upto_912,
			BigDecimal r16_bank_upto_12, BigDecimal r16_bank_upto_23, BigDecimal r16_bank_upto_34,
			BigDecimal r16_bank_upto_45, BigDecimal r16_bank_upto_5, String r17_bank_na, String r17_bank_na_currency,
			BigDecimal r17_bank_na_size, BigDecimal r17_bank_na_aed, BigDecimal r17_bank_na_total,
			BigDecimal r17_bank_na_upto3, BigDecimal r17_bank_na_upto_36, BigDecimal r17_bank_na_upto_69,
			BigDecimal r17_bank_na_upto_912, BigDecimal r17_bank_na_upto_12, BigDecimal r17_bank_na_upto_23,
			BigDecimal r17_bank_na_upto_34, BigDecimal r17_bank_na_upto_45, BigDecimal r17_bank_na_upto_5,
			String r18_nbfi, BigDecimal r18_nbfi_size, BigDecimal r18_nbfi_aed, BigDecimal r18_nbfi_total,
			BigDecimal r18_nbfi_upto3, BigDecimal r18_nbfi_upto_36, BigDecimal r18_nbfi_upto_69,
			BigDecimal r18_nbfi_upto_912, BigDecimal r18_nbfi_upto_12, BigDecimal r18_nbfi_upto_23,
			BigDecimal r18_nbfi_upto_34, BigDecimal r18_nbfi_upto_45, BigDecimal r18_nbfi_upto_5, String r19_nbfi_na,
			String r19_nbfi_na_currency, BigDecimal r19_nbfi_na_size, BigDecimal r19_nbfi_na_aed,
			BigDecimal r19_nbfi_na_total, BigDecimal r19_nbfi_na_upto3, BigDecimal r19_nbfi_na_upto_36,
			BigDecimal r19_nbfi_na_upto_69, BigDecimal r19_nbfi_na_upto_912, BigDecimal r19_nbfi_na_upto_12,
			BigDecimal r19_nbfi_na_upto_23, BigDecimal r19_nbfi_na_upto_34, BigDecimal r19_nbfi_na_upto_45,
			BigDecimal r19_nbfi_na_upto_5, String r20_other, BigDecimal r20_other_size, BigDecimal r20_other_aed,
			BigDecimal r20_other_total, BigDecimal r20_other_upto3, BigDecimal r20_other_upto_36,
			BigDecimal r20_other_upto_69, BigDecimal r20_other_upto_912, BigDecimal r20_other_upto_12,
			BigDecimal r20_other_upto_23, BigDecimal r20_other_upto_34, BigDecimal r20_other_upto_45,
			BigDecimal r20_other_upto_5, String r21_other_na, String r21_other_na_currency,
			BigDecimal r21_other_na_size, BigDecimal r21_other_na_aed, BigDecimal r21_other_na_total,
			BigDecimal r21_other_na_upto3, BigDecimal r21_other_na_upto_36, BigDecimal r21_other_na_upto_69,
			BigDecimal r21_other_na_upto_912, BigDecimal r21_other_na_upto_12, BigDecimal r21_other_na_upto_23,
			BigDecimal r21_other_na_upto_34, BigDecimal r21_other_na_upto_45, BigDecimal r21_other_na_upto_5,
			String r22_total, BigDecimal r22_total_size, BigDecimal r22_total_aed, BigDecimal r22_total_total,
			BigDecimal r22_total_upto3, BigDecimal r22_total_upto_36, BigDecimal r22_total_upto_69,
			BigDecimal r22_total_upto_912, BigDecimal r22_total_upto_12, BigDecimal r22_total_upto_23,
			BigDecimal r22_total_upto_34, BigDecimal r22_total_upto_45, BigDecimal r22_total_upto_5, String r23_total,
			String r23_total_na_currency, BigDecimal r23_total_na_size, BigDecimal r23_total_na_aed,
			BigDecimal r23_total_na_total, BigDecimal r23_total_na_upto3, BigDecimal r23_total_na_upto_36,
			BigDecimal r23_total_na_upto_69, BigDecimal r23_total_na_upto_912, BigDecimal r23_total_na_upto_12,
			BigDecimal r23_total_na_upto_23, BigDecimal r23_total_na_upto_34, BigDecimal r23_total_na_upto_45,
			BigDecimal r23_total_na_upto_5, Date report_date, Date report_from_date, Date report_to_date,
			String entity_flg, String modify_flg, String del_flg, String report_code, Date report_submit_date,
			String progarm_instrument_name, String currency_of_issue, String size_of_prgoam, String aed_equivalent,
			String aed_iss_total, String month_upto3, String month3to6, String month6to9, String month9to12,
			String year1to2, String year2to3, String year3to4, String year4to5, String year_upto5, BigDecimal srl_no,
			String repdesc, String frequency) {
		super();
		this.r9_section_a = r9_section_a;
		this.r9_section_a_size = r9_section_a_size;
		this.r9_section_a_aed = r9_section_a_aed;
		this.r9_section_a_total = r9_section_a_total;
		this.r9_section_a_upto3 = r9_section_a_upto3;
		this.r9_section_a_upto_36 = r9_section_a_upto_36;
		this.r9_section_a_upto_69 = r9_section_a_upto_69;
		this.r9_section_a_upto_912 = r9_section_a_upto_912;
		this.r9_section_a_upto_12 = r9_section_a_upto_12;
		this.r9_section_a_upto_23 = r9_section_a_upto_23;
		this.r9_section_a_upto_34 = r9_section_a_upto_34;
		this.r9_section_a_upto_45 = r9_section_a_upto_45;
		this.r9_section_a_upto_5 = r9_section_a_upto_5;
		this.r10_section_a_na = r10_section_a_na;
		this.r10_section_a_na_currency = r10_section_a_na_currency;
		this.r10_section_a_na_size = r10_section_a_na_size;
		this.r10_section_a_na_aed = r10_section_a_na_aed;
		this.r10_section_a_na_total = r10_section_a_na_total;
		this.r10_section_a_na_upto3 = r10_section_a_na_upto3;
		this.r10_section_a_na_upto_36 = r10_section_a_na_upto_36;
		this.r10_section_a_na_upto_69 = r10_section_a_na_upto_69;
		this.r10_section_a_na_upto_912 = r10_section_a_na_upto_912;
		this.r10_section_a_na_upto_12 = r10_section_a_na_upto_12;
		this.r10_section_a_na_upto_23 = r10_section_a_na_upto_23;
		this.r10_section_a_na_upto_34 = r10_section_a_na_upto_34;
		this.r10_section_a_na_upto_45 = r10_section_a_na_upto_45;
		this.r10_section_a_na_upto_5 = r10_section_a_na_upto_5;
		this.r11_section_b = r11_section_b;
		this.r11_section_b_size = r11_section_b_size;
		this.r11_section_b_aed = r11_section_b_aed;
		this.r11_section_b_total = r11_section_b_total;
		this.r11_section_b_upto3 = r11_section_b_upto3;
		this.r11_section_b_upto_36 = r11_section_b_upto_36;
		this.r11_section_b_upto_69 = r11_section_b_upto_69;
		this.r11_section_b_upto_912 = r11_section_b_upto_912;
		this.r11_section_b_upto_12 = r11_section_b_upto_12;
		this.r11_section_b_upto_23 = r11_section_b_upto_23;
		this.r11_section_b_upto_34 = r11_section_b_upto_34;
		this.r11_section_b_upto_45 = r11_section_b_upto_45;
		this.r11_section_b_upto_5 = r11_section_b_upto_5;
		this.r12_federal_govn = r12_federal_govn;
		this.r12_federal_govn_size = r12_federal_govn_size;
		this.r12_federal_govn_aed = r12_federal_govn_aed;
		this.r12_federal_govn_total = r12_federal_govn_total;
		this.r12_federal_govn_upto3 = r12_federal_govn_upto3;
		this.r12_federal_govn_upto_36 = r12_federal_govn_upto_36;
		this.r12_federal_govn_upto_69 = r12_federal_govn_upto_69;
		this.r12_federal_govn_uptp_912 = r12_federal_govn_uptp_912;
		this.r12_federal_govn_upto_12 = r12_federal_govn_upto_12;
		this.r12_federal_govn_upto_23 = r12_federal_govn_upto_23;
		this.r12_federal_govn_upto_34 = r12_federal_govn_upto_34;
		this.r12_federal_govn_upto_45 = r12_federal_govn_upto_45;
		this.r12_federal_govn_upto_5 = r12_federal_govn_upto_5;
		this.r13_federal_govn_na = r13_federal_govn_na;
		this.r13_federal_govn_na_currency = r13_federal_govn_na_currency;
		this.r13_federal_govn_na_size = r13_federal_govn_na_size;
		this.r13_federal_govn_na_aed = r13_federal_govn_na_aed;
		this.r13_federal_govn_na_total = r13_federal_govn_na_total;
		this.r13_federal_govn_na_upto3 = r13_federal_govn_na_upto3;
		this.r13_federal_govn_na_upto_36 = r13_federal_govn_na_upto_36;
		this.r13_federal_govn_na_upto_69 = r13_federal_govn_na_upto_69;
		this.r13_federal_govn_na_uptp_912 = r13_federal_govn_na_uptp_912;
		this.r13_federal_govn_na_upto_12 = r13_federal_govn_na_upto_12;
		this.r13_federal_govn_na_upto_23 = r13_federal_govn_na_upto_23;
		this.r13_federal_govn_na_upto_34 = r13_federal_govn_na_upto_34;
		this.r13_federal_govn_na_upto_45 = r13_federal_govn_na_upto_45;
		this.r13_federal_govn_na_upto_5 = r13_federal_govn_na_upto_5;
		this.r14_emirates = r14_emirates;
		this.r14_emirates_size = r14_emirates_size;
		this.r14_emirates_aed = r14_emirates_aed;
		this.r14_emirates_total = r14_emirates_total;
		this.r14_emirates_upto3 = r14_emirates_upto3;
		this.r14_emirates_upto_36 = r14_emirates_upto_36;
		this.r14_emirates_upto_69 = r14_emirates_upto_69;
		this.r14_emirates_upto_912 = r14_emirates_upto_912;
		this.r14_emirates_upto_12 = r14_emirates_upto_12;
		this.r14_emirates_upto_23 = r14_emirates_upto_23;
		this.r14_emirates_upto_34 = r14_emirates_upto_34;
		this.r14_emirates_upto_45 = r14_emirates_upto_45;
		this.r14_emirates_upto_5 = r14_emirates_upto_5;
		this.r15_emirates_na = r15_emirates_na;
		this.r15_emirates_na_currency = r15_emirates_na_currency;
		this.r15_emirates_na_size = r15_emirates_na_size;
		this.r15_emirates_na_aed = r15_emirates_na_aed;
		this.r15_emirates_na_total = r15_emirates_na_total;
		this.r15_emirates_na_upto3 = r15_emirates_na_upto3;
		this.r15_emirates_na_upto_36 = r15_emirates_na_upto_36;
		this.r15_emirates_na_upto_69 = r15_emirates_na_upto_69;
		this.r15_emirates_na_upto_912 = r15_emirates_na_upto_912;
		this.r15_emirates_na_upto_12 = r15_emirates_na_upto_12;
		this.r15_emirates_na_upto_23 = r15_emirates_na_upto_23;
		this.r15_emirates_na_upto_34 = r15_emirates_na_upto_34;
		this.r15_emirates_na_upto_45 = r15_emirates_na_upto_45;
		this.r15_emirates_na_upto_5 = r15_emirates_na_upto_5;
		this.r16_bank = r16_bank;
		this.r16_bank_size = r16_bank_size;
		this.r16_bank_aed = r16_bank_aed;
		this.r16_bank_total = r16_bank_total;
		this.r16_bank_upto3 = r16_bank_upto3;
		this.r16_bank_upto_36 = r16_bank_upto_36;
		this.r16_bank_upto_69 = r16_bank_upto_69;
		this.r16_bank_upto_912 = r16_bank_upto_912;
		this.r16_bank_upto_12 = r16_bank_upto_12;
		this.r16_bank_upto_23 = r16_bank_upto_23;
		this.r16_bank_upto_34 = r16_bank_upto_34;
		this.r16_bank_upto_45 = r16_bank_upto_45;
		this.r16_bank_upto_5 = r16_bank_upto_5;
		this.r17_bank_na = r17_bank_na;
		this.r17_bank_na_currency = r17_bank_na_currency;
		this.r17_bank_na_size = r17_bank_na_size;
		this.r17_bank_na_aed = r17_bank_na_aed;
		this.r17_bank_na_total = r17_bank_na_total;
		this.r17_bank_na_upto3 = r17_bank_na_upto3;
		this.r17_bank_na_upto_36 = r17_bank_na_upto_36;
		this.r17_bank_na_upto_69 = r17_bank_na_upto_69;
		this.r17_bank_na_upto_912 = r17_bank_na_upto_912;
		this.r17_bank_na_upto_12 = r17_bank_na_upto_12;
		this.r17_bank_na_upto_23 = r17_bank_na_upto_23;
		this.r17_bank_na_upto_34 = r17_bank_na_upto_34;
		this.r17_bank_na_upto_45 = r17_bank_na_upto_45;
		this.r17_bank_na_upto_5 = r17_bank_na_upto_5;
		this.r18_nbfi = r18_nbfi;
		this.r18_nbfi_size = r18_nbfi_size;
		this.r18_nbfi_aed = r18_nbfi_aed;
		this.r18_nbfi_total = r18_nbfi_total;
		this.r18_nbfi_upto3 = r18_nbfi_upto3;
		this.r18_nbfi_upto_36 = r18_nbfi_upto_36;
		this.r18_nbfi_upto_69 = r18_nbfi_upto_69;
		this.r18_nbfi_upto_912 = r18_nbfi_upto_912;
		this.r18_nbfi_upto_12 = r18_nbfi_upto_12;
		this.r18_nbfi_upto_23 = r18_nbfi_upto_23;
		this.r18_nbfi_upto_34 = r18_nbfi_upto_34;
		this.r18_nbfi_upto_45 = r18_nbfi_upto_45;
		this.r18_nbfi_upto_5 = r18_nbfi_upto_5;
		this.r19_nbfi_na = r19_nbfi_na;
		this.r19_nbfi_na_currency = r19_nbfi_na_currency;
		this.r19_nbfi_na_size = r19_nbfi_na_size;
		this.r19_nbfi_na_aed = r19_nbfi_na_aed;
		this.r19_nbfi_na_total = r19_nbfi_na_total;
		this.r19_nbfi_na_upto3 = r19_nbfi_na_upto3;
		this.r19_nbfi_na_upto_36 = r19_nbfi_na_upto_36;
		this.r19_nbfi_na_upto_69 = r19_nbfi_na_upto_69;
		this.r19_nbfi_na_upto_912 = r19_nbfi_na_upto_912;
		this.r19_nbfi_na_upto_12 = r19_nbfi_na_upto_12;
		this.r19_nbfi_na_upto_23 = r19_nbfi_na_upto_23;
		this.r19_nbfi_na_upto_34 = r19_nbfi_na_upto_34;
		this.r19_nbfi_na_upto_45 = r19_nbfi_na_upto_45;
		this.r19_nbfi_na_upto_5 = r19_nbfi_na_upto_5;
		this.r20_other = r20_other;
		this.r20_other_size = r20_other_size;
		this.r20_other_aed = r20_other_aed;
		this.r20_other_total = r20_other_total;
		this.r20_other_upto3 = r20_other_upto3;
		this.r20_other_upto_36 = r20_other_upto_36;
		this.r20_other_upto_69 = r20_other_upto_69;
		this.r20_other_upto_912 = r20_other_upto_912;
		this.r20_other_upto_12 = r20_other_upto_12;
		this.r20_other_upto_23 = r20_other_upto_23;
		this.r20_other_upto_34 = r20_other_upto_34;
		this.r20_other_upto_45 = r20_other_upto_45;
		this.r20_other_upto_5 = r20_other_upto_5;
		this.r21_other_na = r21_other_na;
		this.r21_other_na_currency = r21_other_na_currency;
		this.r21_other_na_size = r21_other_na_size;
		this.r21_other_na_aed = r21_other_na_aed;
		this.r21_other_na_total = r21_other_na_total;
		this.r21_other_na_upto3 = r21_other_na_upto3;
		this.r21_other_na_upto_36 = r21_other_na_upto_36;
		this.r21_other_na_upto_69 = r21_other_na_upto_69;
		this.r21_other_na_upto_912 = r21_other_na_upto_912;
		this.r21_other_na_upto_12 = r21_other_na_upto_12;
		this.r21_other_na_upto_23 = r21_other_na_upto_23;
		this.r21_other_na_upto_34 = r21_other_na_upto_34;
		this.r21_other_na_upto_45 = r21_other_na_upto_45;
		this.r21_other_na_upto_5 = r21_other_na_upto_5;
		this.r22_total = r22_total;
		this.r22_total_size = r22_total_size;
		this.r22_total_aed = r22_total_aed;
		this.r22_total_total = r22_total_total;
		this.r22_total_upto3 = r22_total_upto3;
		this.r22_total_upto_36 = r22_total_upto_36;
		this.r22_total_upto_69 = r22_total_upto_69;
		this.r22_total_upto_912 = r22_total_upto_912;
		this.r22_total_upto_12 = r22_total_upto_12;
		this.r22_total_upto_23 = r22_total_upto_23;
		this.r22_total_upto_34 = r22_total_upto_34;
		this.r22_total_upto_45 = r22_total_upto_45;
		this.r22_total_upto_5 = r22_total_upto_5;
		this.r23_total = r23_total;
		this.r23_total_na_currency = r23_total_na_currency;
		this.r23_total_na_size = r23_total_na_size;
		this.r23_total_na_aed = r23_total_na_aed;
		this.r23_total_na_total = r23_total_na_total;
		this.r23_total_na_upto3 = r23_total_na_upto3;
		this.r23_total_na_upto_36 = r23_total_na_upto_36;
		this.r23_total_na_upto_69 = r23_total_na_upto_69;
		this.r23_total_na_upto_912 = r23_total_na_upto_912;
		this.r23_total_na_upto_12 = r23_total_na_upto_12;
		this.r23_total_na_upto_23 = r23_total_na_upto_23;
		this.r23_total_na_upto_34 = r23_total_na_upto_34;
		this.r23_total_na_upto_45 = r23_total_na_upto_45;
		this.r23_total_na_upto_5 = r23_total_na_upto_5;
		this.report_date = report_date;
		this.report_from_date = report_from_date;
		this.report_to_date = report_to_date;
		this.entity_flg = entity_flg;
		this.modify_flg = modify_flg;
		this.del_flg = del_flg;
		this.report_code = report_code;
		this.report_submit_date = report_submit_date;
		this.progarm_instrument_name = progarm_instrument_name;
		this.currency_of_issue = currency_of_issue;
		this.size_of_prgoam = size_of_prgoam;
		this.aed_equivalent = aed_equivalent;
		this.aed_iss_total = aed_iss_total;
		this.month_upto3 = month_upto3;
		this.month3to6 = month3to6;
		this.month6to9 = month6to9;
		this.month9to12 = month9to12;
		this.year1to2 = year1to2;
		this.year2to3 = year2to3;
		this.year3to4 = year3to4;
		this.year4to5 = year4to5;
		this.year_upto5 = year_upto5;
		this.srl_no = srl_no;
		this.repdesc = repdesc;
		this.frequency = frequency;
	}

	public BRF36_ENTITY() {
		super();
		// TODO Auto-generated constructor stub
	}
}
