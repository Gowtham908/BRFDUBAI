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
@Table(name="BRF151_SUMMARYTABLE")
public class BRF151reportentity {

	private String	r1_particulars;
	private BigDecimal	r1_resident_individual;
	private BigDecimal	r1_nonresident_individual;
	private BigDecimal	r1_resident_retail;
	private BigDecimal	r1_nonresident_retail;
	private BigDecimal	r1_resident_sme;
	private BigDecimal	r1_nonresident_sme;
	private BigDecimal	r1_resident_hni;
	private BigDecimal	r1_nonresident_hni;
	private BigDecimal	r1_resident_gres;
	private BigDecimal	r1_nonresident_gres;
	private BigDecimal	r1_resident_corporate;
	private BigDecimal	r1_nonresident_corporate;
	private BigDecimal	r1_resident_nbfi;
	private BigDecimal	r1_nonresident_nbfi;
	private BigDecimal	r1_resident_banks;
	private BigDecimal	r1_nonresident_banks;
	private BigDecimal	r1_resident_gov_nces;
	private BigDecimal	r1_nonresident_gov_nces;
	private String	r2_particulars;
	private BigDecimal	r2_resident_individual;
	private BigDecimal	r2_nonresident_individual;
	private BigDecimal	r2_resident_retail;
	private BigDecimal	r2_nonresident_retail;
	private BigDecimal	r2_resident_sme;
	private BigDecimal	r2_nonresident_sme;
	private BigDecimal	r2_resident_hni;
	private BigDecimal	r2_nonresident_hni;
	private BigDecimal	r2_resident_gres;
	private BigDecimal	r2_nonresident_gres;
	private BigDecimal	r2_resident_corporate;
	private BigDecimal	r2_nonresident_corporate;
	private BigDecimal	r2_resident_nbfi;
	private BigDecimal	r2_nonresident_nbfi;
	private BigDecimal	r2_resident_banks;
	private BigDecimal	r2_nonresident_banks;
	private BigDecimal	r2_resident_gov_nces;
	private BigDecimal	r2_nonresident_gov_nces;
	private String	r3_particulars;
	private BigDecimal	r3_resident_individual;
	private BigDecimal	r3_nonresident_individual;
	private BigDecimal	r3_resident_retail;
	private BigDecimal	r3_nonresident_retail;
	private BigDecimal	r3_resident_sme;
	private BigDecimal	r3_nonresident_sme;
	private BigDecimal	r3_resident_hni;
	private BigDecimal	r3_nonresident_hni;
	private BigDecimal	r3_resident_gres;
	private BigDecimal	r3_nonresident_gres;
	private BigDecimal	r3_resident_corporate;
	private BigDecimal	r3_nonresident_corporate;
	private BigDecimal	r3_resident_nbfi;
	private BigDecimal	r3_nonresident_nbfi;
	private BigDecimal	r3_resident_banks;
	private BigDecimal	r3_nonresident_banks;
	private BigDecimal	r3_resident_gov_nces;
	private BigDecimal	r3_nonresident_gov_nces;
	private String	r4_particulars;
	private BigDecimal	r4_resident_individual;
	private BigDecimal	r4_nonresident_individual;
	private BigDecimal	r4_resident_retail;
	private BigDecimal	r4_nonresident_retail;
	private BigDecimal	r4_resident_sme;
	private BigDecimal	r4_nonresident_sme;
	private BigDecimal	r4_resident_hni;
	private BigDecimal	r4_nonresident_hni;
	private BigDecimal	r4_resident_gres;
	private BigDecimal	r4_nonresident_gres;
	private BigDecimal	r4_resident_corporate;
	private BigDecimal	r4_nonresident_corporate;
	private BigDecimal	r4_resident_nbfi;
	private BigDecimal	r4_nonresident_nbfi;
	private BigDecimal	r4_resident_banks;
	private BigDecimal	r4_nonresident_banks;
	private BigDecimal	r4_resident_gov_nces;
	private BigDecimal	r4_nonresident_gov_nces;
	private String	r5_particulars;
	private BigDecimal	r5_resident_individual;
	private BigDecimal	r5_nonresident_individual;
	private BigDecimal	r5_resident_retail;
	private BigDecimal	r5_nonresident_retail;
	private BigDecimal	r5_resident_sme;
	private BigDecimal	r5_nonresident_sme;
	private BigDecimal	r5_resident_hni;
	private BigDecimal	r5_nonresident_hni;
	private BigDecimal	r5_resident_gres;
	private BigDecimal	r5_nonresident_gres;
	private BigDecimal	r5_resident_corporate;
	private BigDecimal	r5_nonresident_corporate;
	private BigDecimal	r5_resident_nbfi;
	private BigDecimal	r5_nonresident_nbfi;
	private BigDecimal	r5_resident_banks;
	private BigDecimal	r5_nonresident_banks;
	private BigDecimal	r5_resident_gov_nces;
	private BigDecimal	r5_nonresident_gov_nces;
	private String	r6_particulars;
	private BigDecimal	r6_resident_individual;
	private BigDecimal	r6_nonresident_individual;
	private BigDecimal	r6_resident_retail;
	private BigDecimal	r6_nonresident_retail;
	private BigDecimal	r6_resident_sme;
	private BigDecimal	r6_nonresident_sme;
	private BigDecimal	r6_resident_hni;
	private BigDecimal	r6_nonresident_hni;
	private BigDecimal	r6_resident_gres;
	private BigDecimal	r6_nonresident_gres;
	private BigDecimal	r6_resident_corporate;
	private BigDecimal	r6_nonresident_corporate;
	private BigDecimal	r6_resident_nbfi;
	private BigDecimal	r6_nonresident_nbfi;
	private BigDecimal	r6_resident_banks;
	private BigDecimal	r6_nonresident_banks;
	private BigDecimal	r6_resident_gov_nces;
	private BigDecimal	r6_nonresident_gov_nces;
	private String	r7_particulars;
	private BigDecimal	r7_resident_individual;
	private BigDecimal	r7_nonresident_individual;
	private BigDecimal	r7_resident_retail;
	private BigDecimal	r7_nonresident_retail;
	private BigDecimal	r7_resident_sme;
	private BigDecimal	r7_nonresident_sme;
	private BigDecimal	r7_resident_hni;
	private BigDecimal	r7_nonresident_hni;
	private BigDecimal	r7_resident_gres;
	private BigDecimal	r7_nonresident_gres;
	private BigDecimal	r7_resident_corporate;
	private BigDecimal	r7_nonresident_corporate;
	private BigDecimal	r7_resident_nbfi;
	private BigDecimal	r7_nonresident_nbfi;
	private BigDecimal	r7_resident_banks;
	private BigDecimal	r7_nonresident_banks;
	private BigDecimal	r7_resident_gov_nces;
	private BigDecimal	r7_nonresident_gov_nces;
	private String	r8_particulars;
	private BigDecimal	r8_resident_individual;
	private BigDecimal	r8_nonresident_individual;
	private BigDecimal	r8_resident_retail;
	private BigDecimal	r8_nonresident_retail;
	private BigDecimal	r8_resident_sme;
	private BigDecimal	r8_nonresident_sme;
	private BigDecimal	r8_resident_hni;
	private BigDecimal	r8_nonresident_hni;
	private BigDecimal	r8_resident_gres;
	private BigDecimal	r8_nonresident_gres;
	private BigDecimal	r8_resident_corporate;
	private BigDecimal	r8_nonresident_corporate;
	private BigDecimal	r8_resident_nbfi;
	private BigDecimal	r8_nonresident_nbfi;
	private BigDecimal	r8_resident_banks;
	private BigDecimal	r8_nonresident_banks;
	private BigDecimal	r8_resident_gov_nces;
	private BigDecimal	r8_nonresident_gov_nces;
	private String	r9_particulars;
	private BigDecimal	r9_resident_individual;
	private BigDecimal	r9_nonresident_individual;
	private BigDecimal	r9_resident_retail;
	private BigDecimal	r9_nonresident_retail;
	private BigDecimal	r9_resident_sme;
	private BigDecimal	r9_nonresident_sme;
	private BigDecimal	r9_resident_hni;
	private BigDecimal	r9_nonresident_hni;
	private BigDecimal	r9_resident_gres;
	private BigDecimal	r9_nonresident_gres;
	private BigDecimal	r9_resident_corporate;
	private BigDecimal	r9_nonresident_corporate;
	private BigDecimal	r9_resident_nbfi;
	private BigDecimal	r9_nonresident_nbfi;
	private BigDecimal	r9_resident_banks;
	private BigDecimal	r9_nonresident_banks;
	private BigDecimal	r9_resident_gov_nces;
	private BigDecimal	r9_nonresident_gov_nces;
	private String	r10_particulars;
	private BigDecimal	r10_resident_individual;
	private BigDecimal	r10_nonresident_individual;
	private BigDecimal	r10_resident_retail;
	private BigDecimal	r10_nonresident_retail;
	private BigDecimal	r10_resident_sme;
	private BigDecimal	r10_nonresident_sme;
	private BigDecimal	r10_resident_hni;
	private BigDecimal	r10_nonresident_hni;
	private BigDecimal	r10_resident_gres;
	private BigDecimal	r10_nonresident_gres;
	private BigDecimal	r10_resident_corporate;
	private BigDecimal	r10_nonresident_corporate;
	private BigDecimal	r10_resident_nbfi;
	private BigDecimal	r10_nonresident_nbfi;
	private BigDecimal	r10_resident_banks;
	private BigDecimal	r10_nonresident_banks;
	private BigDecimal	r10_resident_gov_nces;
	private BigDecimal	r10_nonresident_gov_nces;
	private String	r11_particulars;
	private BigDecimal	r11_resident_individual;
	private BigDecimal	r11_nonresident_individual;
	private BigDecimal	r11_resident_retail;
	private BigDecimal	r11_nonresident_retail;
	private BigDecimal	r11_resident_sme;
	private BigDecimal	r11_nonresident_sme;
	private BigDecimal	r11_resident_hni;
	private BigDecimal	r11_nonresident_hni;
	private BigDecimal	r11_resident_gres;
	private BigDecimal	r11_nonresident_gres;
	private BigDecimal	r11_resident_corporate;
	private BigDecimal	r11_nonresident_corporate;
	private BigDecimal	r11_resident_nbfi;
	private BigDecimal	r11_nonresident_nbfi;
	private BigDecimal	r11_resident_banks;
	private BigDecimal	r11_nonresident_banks;
	private BigDecimal	r11_resident_gov_nces;
	private BigDecimal	r11_nonresident_gov_nces;
	private String	r12_particulars;
	private BigDecimal	r12_resident_individual;
	private BigDecimal	r12_nonresident_individual;
	private BigDecimal	r12_resident_retail;
	private BigDecimal	r12_nonresident_retail;
	private BigDecimal	r12_resident_sme;
	private BigDecimal	r12_nonresident_sme;
	private BigDecimal	r12_resident_hni;
	private BigDecimal	r12_nonresident_hni;
	private BigDecimal	r12_resident_gres;
	private BigDecimal	r12_nonresident_gres;
	private BigDecimal	r12_resident_corporate;
	private BigDecimal	r12_nonresident_corporate;
	private BigDecimal	r12_resident_nbfi;
	private BigDecimal	r12_nonresident_nbfi;
	private BigDecimal	r12_resident_banks;
	private BigDecimal	r12_nonresident_banks;
	private BigDecimal	r12_resident_gov_nces;
	private BigDecimal	r12_nonresident_gov_nces;
	private String	r13_particulars;
	private BigDecimal	r13_resident_individual;
	private BigDecimal	r13_nonresident_individual;
	private BigDecimal	r13_resident_retail;
	private BigDecimal	r13_nonresident_retail;
	private BigDecimal	r13_resident_sme;
	private BigDecimal	r13_nonresident_sme;
	private BigDecimal	r13_resident_hni;
	private BigDecimal	r13_nonresident_hni;
	private BigDecimal	r13_resident_gres;
	private BigDecimal	r13_nonresident_gres;
	private BigDecimal	r13_resident_corporate;
	private BigDecimal	r13_nonresident_corporate;
	private BigDecimal	r13_resident_nbfi;
	private BigDecimal	r13_nonresident_nbfi;
	private BigDecimal	r13_resident_banks;
	private BigDecimal	r13_nonresident_banks;
	private BigDecimal	r13_resident_gov_nces;
	private BigDecimal	r13_nonresident_gov_nces;
	private String	r14_particulars;
	private BigDecimal	r14_resident_individual;
	private BigDecimal	r14_nonresident_individual;
	private BigDecimal	r14_resident_retail;
	private BigDecimal	r14_nonresident_retail;
	private BigDecimal	r14_resident_sme;
	private BigDecimal	r14_nonresident_sme;
	private BigDecimal	r14_resident_hni;
	private BigDecimal	r14_nonresident_hni;
	private BigDecimal	r14_resident_gres;
	private BigDecimal	r14_nonresident_gres;
	private BigDecimal	r14_resident_corporate;
	private BigDecimal	r14_nonresident_corporate;
	private BigDecimal	r14_resident_nbfi;
	private BigDecimal	r14_nonresident_nbfi;
	private BigDecimal	r14_resident_banks;
	private BigDecimal	r14_nonresident_banks;
	private BigDecimal	r14_resident_gov_nces;
	private BigDecimal	r14_nonresident_gov_nces;
	private String	r15_particulars;
	private BigDecimal	r15_resident_individual;
	private BigDecimal	r15_nonresident_individual;
	private BigDecimal	r15_resident_retail;
	private BigDecimal	r15_nonresident_retail;
	private BigDecimal	r15_resident_sme;
	private BigDecimal	r15_nonresident_sme;
	private BigDecimal	r15_resident_hni;
	private BigDecimal	r15_nonresident_hni;
	private BigDecimal	r15_resident_gres;
	private BigDecimal	r15_nonresident_gres;
	private BigDecimal	r15_resident_corporate;
	private BigDecimal	r15_nonresident_corporate;
	private BigDecimal	r15_resident_nbfi;
	private BigDecimal	r15_nonresident_nbfi;
	private BigDecimal	r15_resident_banks;
	private BigDecimal	r15_nonresident_banks;
	private BigDecimal	r15_resident_gov_nces;
	private BigDecimal	r15_nonresident_gov_nces;
	private String	r16_particulars;
	private BigDecimal	r16_resident_individual;
	private BigDecimal	r16_nonresident_individual;
	private BigDecimal	r16_resident_retail;
	private BigDecimal	r16_nonresident_retail;
	private BigDecimal	r16_resident_sme;
	private BigDecimal	r16_nonresident_sme;
	private BigDecimal	r16_resident_hni;
	private BigDecimal	r16_nonresident_hni;
	private BigDecimal	r16_resident_gres;
	private BigDecimal	r16_nonresident_gres;
	private BigDecimal	r16_resident_corporate;
	private BigDecimal	r16_nonresident_corporate;
	private BigDecimal	r16_resident_nbfi;
	private BigDecimal	r16_nonresident_nbfi;
	private BigDecimal	r16_resident_banks;
	private BigDecimal	r16_nonresident_banks;
	private BigDecimal	r16_resident_gov_nces;
	private BigDecimal	r16_nonresident_gov_nces;
	private String	r17_particulars;
	private BigDecimal	r17_resident_individual;
	private BigDecimal	r17_nonresident_individual;
	private BigDecimal	r17_resident_retail;
	private BigDecimal	r17_nonresident_retail;
	private BigDecimal	r17_resident_sme;
	private BigDecimal	r17_nonresident_sme;
	private BigDecimal	r17_resident_hni;
	private BigDecimal	r17_nonresident_hni;
	private BigDecimal	r17_resident_gres;
	private BigDecimal	r17_nonresident_gres;
	private BigDecimal	r17_resident_corporate;
	private BigDecimal	r17_nonresident_corporate;
	private BigDecimal	r17_resident_nbfi;
	private BigDecimal	r17_nonresident_nbfi;
	private BigDecimal	r17_resident_banks;
	private BigDecimal	r17_nonresident_banks;
	private BigDecimal	r17_resident_gov_nces;
	private BigDecimal	r17_nonresident_gov_nces;
	private String	r18_particulars;
	private BigDecimal	r18_resident_individual;
	private BigDecimal	r18_nonresident_individual;
	private BigDecimal	r18_resident_retail;
	private BigDecimal	r18_nonresident_retail;
	private BigDecimal	r18_resident_sme;
	private BigDecimal	r18_nonresident_sme;
	private BigDecimal	r18_resident_hni;
	private BigDecimal	r18_nonresident_hni;
	private BigDecimal	r18_resident_gres;
	private BigDecimal	r18_nonresident_gres;
	private BigDecimal	r18_resident_corporate;
	private BigDecimal	r18_nonresident_corporate;
	private BigDecimal	r18_resident_nbfi;
	private BigDecimal	r18_nonresident_nbfi;
	private BigDecimal	r18_resident_banks;
	private BigDecimal	r18_nonresident_banks;
	private BigDecimal	r18_resident_gov_nces;
	private BigDecimal	r18_nonresident_gov_nces;
	private String	r19_particulars;
	private BigDecimal	r19_resident_individual;
	private BigDecimal	r19_nonresident_individual;
	private BigDecimal	r19_resident_retail;
	private BigDecimal	r19_nonresident_retail;
	private BigDecimal	r19_resident_sme;
	private BigDecimal	r19_nonresident_sme;
	private BigDecimal	r19_resident_hni;
	private BigDecimal	r19_nonresident_hni;
	private BigDecimal	r19_resident_gres;
	private BigDecimal	r19_nonresident_gres;
	private BigDecimal	r19_resident_corporate;
	private BigDecimal	r19_nonresident_corporate;
	private BigDecimal	r19_resident_nbfi;
	private BigDecimal	r19_nonresident_nbfi;
	private BigDecimal	r19_resident_banks;
	private BigDecimal	r19_nonresident_banks;
	private BigDecimal	r19_resident_gov_nces;
	private BigDecimal	r19_nonresident_gov_nces;
	private String	r20_particulars;
	private BigDecimal	r20_resident_individual;
	private BigDecimal	r20_nonresident_individual;
	private BigDecimal	r20_resident_retail;
	private BigDecimal	r20_nonresident_retail;
	private BigDecimal	r20_resident_sme;
	private BigDecimal	r20_nonresident_sme;
	private BigDecimal	r20_resident_hni;
	private BigDecimal	r20_nonresident_hni;
	private BigDecimal	r20_resident_gres;
	private BigDecimal	r20_nonresident_gres;
	private BigDecimal	r20_resident_corporate;
	private BigDecimal	r20_nonresident_corporate;
	private BigDecimal	r20_resident_nbfi;
	private BigDecimal	r20_nonresident_nbfi;
	private BigDecimal	r20_resident_banks;
	private BigDecimal	r20_nonresident_banks;
	private BigDecimal	r20_resident_gov_nces;
	private BigDecimal	r20_nonresident_gov_nces;
	private String	r21_particulars;
	private BigDecimal	r21_resident_individual;
	private BigDecimal	r21_nonresident_individual;
	private BigDecimal	r21_resident_retail;
	private BigDecimal	r21_nonresident_retail;
	private BigDecimal	r21_resident_sme;
	private BigDecimal	r21_nonresident_sme;
	private BigDecimal	r21_resident_hni;
	private BigDecimal	r21_nonresident_hni;
	private BigDecimal	r21_resident_gres;
	private BigDecimal	r21_nonresident_gres;
	private BigDecimal	r21_resident_corporate;
	private BigDecimal	r21_nonresident_corporate;
	private BigDecimal	r21_resident_nbfi;
	private BigDecimal	r21_nonresident_nbfi;
	private BigDecimal	r21_resident_banks;
	private BigDecimal	r21_nonresident_banks;
	private BigDecimal	r21_resident_gov_nces;
	private BigDecimal	r21_nonresident_gov_nces;
	@Id
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date	report_date;
	private Date	report_from_date;
	private Date	report_to_date;
	private String	entity_flg;
	private String	modify_flg;
	private String	del_flg;
	private String	report_code;
	private Date	report_submit_date;
	private String	repdesc;
	private String	frequency;
	public String getR1_particulars() {
		return r1_particulars;
	}
	public void setR1_particulars(String r1_particulars) {
		this.r1_particulars = r1_particulars;
	}
	public BigDecimal getR1_resident_individual() {
		return r1_resident_individual;
	}
	public void setR1_resident_individual(BigDecimal r1_resident_individual) {
		this.r1_resident_individual = r1_resident_individual;
	}
	public BigDecimal getR1_nonresident_individual() {
		return r1_nonresident_individual;
	}
	public void setR1_nonresident_individual(BigDecimal r1_nonresident_individual) {
		this.r1_nonresident_individual = r1_nonresident_individual;
	}
	public BigDecimal getR1_resident_retail() {
		return r1_resident_retail;
	}
	public void setR1_resident_retail(BigDecimal r1_resident_retail) {
		this.r1_resident_retail = r1_resident_retail;
	}
	public BigDecimal getR1_nonresident_retail() {
		return r1_nonresident_retail;
	}
	public void setR1_nonresident_retail(BigDecimal r1_nonresident_retail) {
		this.r1_nonresident_retail = r1_nonresident_retail;
	}
	public BigDecimal getR1_resident_sme() {
		return r1_resident_sme;
	}
	public void setR1_resident_sme(BigDecimal r1_resident_sme) {
		this.r1_resident_sme = r1_resident_sme;
	}
	public BigDecimal getR1_nonresident_sme() {
		return r1_nonresident_sme;
	}
	public void setR1_nonresident_sme(BigDecimal r1_nonresident_sme) {
		this.r1_nonresident_sme = r1_nonresident_sme;
	}
	public BigDecimal getR1_resident_hni() {
		return r1_resident_hni;
	}
	public void setR1_resident_hni(BigDecimal r1_resident_hni) {
		this.r1_resident_hni = r1_resident_hni;
	}
	public BigDecimal getR1_nonresident_hni() {
		return r1_nonresident_hni;
	}
	public void setR1_nonresident_hni(BigDecimal r1_nonresident_hni) {
		this.r1_nonresident_hni = r1_nonresident_hni;
	}
	public BigDecimal getR1_resident_gres() {
		return r1_resident_gres;
	}
	public void setR1_resident_gres(BigDecimal r1_resident_gres) {
		this.r1_resident_gres = r1_resident_gres;
	}
	public BigDecimal getR1_nonresident_gres() {
		return r1_nonresident_gres;
	}
	public void setR1_nonresident_gres(BigDecimal r1_nonresident_gres) {
		this.r1_nonresident_gres = r1_nonresident_gres;
	}
	public BigDecimal getR1_resident_corporate() {
		return r1_resident_corporate;
	}
	public void setR1_resident_corporate(BigDecimal r1_resident_corporate) {
		this.r1_resident_corporate = r1_resident_corporate;
	}
	public BigDecimal getR1_nonresident_corporate() {
		return r1_nonresident_corporate;
	}
	public void setR1_nonresident_corporate(BigDecimal r1_nonresident_corporate) {
		this.r1_nonresident_corporate = r1_nonresident_corporate;
	}
	public BigDecimal getR1_resident_nbfi() {
		return r1_resident_nbfi;
	}
	public void setR1_resident_nbfi(BigDecimal r1_resident_nbfi) {
		this.r1_resident_nbfi = r1_resident_nbfi;
	}
	public BigDecimal getR1_nonresident_nbfi() {
		return r1_nonresident_nbfi;
	}
	public void setR1_nonresident_nbfi(BigDecimal r1_nonresident_nbfi) {
		this.r1_nonresident_nbfi = r1_nonresident_nbfi;
	}
	public BigDecimal getR1_resident_banks() {
		return r1_resident_banks;
	}
	public void setR1_resident_banks(BigDecimal r1_resident_banks) {
		this.r1_resident_banks = r1_resident_banks;
	}
	public BigDecimal getR1_nonresident_banks() {
		return r1_nonresident_banks;
	}
	public void setR1_nonresident_banks(BigDecimal r1_nonresident_banks) {
		this.r1_nonresident_banks = r1_nonresident_banks;
	}
	public BigDecimal getR1_resident_gov_nces() {
		return r1_resident_gov_nces;
	}
	public void setR1_resident_gov_nces(BigDecimal r1_resident_gov_nces) {
		this.r1_resident_gov_nces = r1_resident_gov_nces;
	}
	public BigDecimal getR1_nonresident_gov_nces() {
		return r1_nonresident_gov_nces;
	}
	public void setR1_nonresident_gov_nces(BigDecimal r1_nonresident_gov_nces) {
		this.r1_nonresident_gov_nces = r1_nonresident_gov_nces;
	}
	public String getR2_particulars() {
		return r2_particulars;
	}
	public void setR2_particulars(String r2_particulars) {
		this.r2_particulars = r2_particulars;
	}
	public BigDecimal getR2_resident_individual() {
		return r2_resident_individual;
	}
	public void setR2_resident_individual(BigDecimal r2_resident_individual) {
		this.r2_resident_individual = r2_resident_individual;
	}
	public BigDecimal getR2_nonresident_individual() {
		return r2_nonresident_individual;
	}
	public void setR2_nonresident_individual(BigDecimal r2_nonresident_individual) {
		this.r2_nonresident_individual = r2_nonresident_individual;
	}
	public BigDecimal getR2_resident_retail() {
		return r2_resident_retail;
	}
	public void setR2_resident_retail(BigDecimal r2_resident_retail) {
		this.r2_resident_retail = r2_resident_retail;
	}
	public BigDecimal getR2_nonresident_retail() {
		return r2_nonresident_retail;
	}
	public void setR2_nonresident_retail(BigDecimal r2_nonresident_retail) {
		this.r2_nonresident_retail = r2_nonresident_retail;
	}
	public BigDecimal getR2_resident_sme() {
		return r2_resident_sme;
	}
	public void setR2_resident_sme(BigDecimal r2_resident_sme) {
		this.r2_resident_sme = r2_resident_sme;
	}
	public BigDecimal getR2_nonresident_sme() {
		return r2_nonresident_sme;
	}
	public void setR2_nonresident_sme(BigDecimal r2_nonresident_sme) {
		this.r2_nonresident_sme = r2_nonresident_sme;
	}
	public BigDecimal getR2_resident_hni() {
		return r2_resident_hni;
	}
	public void setR2_resident_hni(BigDecimal r2_resident_hni) {
		this.r2_resident_hni = r2_resident_hni;
	}
	public BigDecimal getR2_nonresident_hni() {
		return r2_nonresident_hni;
	}
	public void setR2_nonresident_hni(BigDecimal r2_nonresident_hni) {
		this.r2_nonresident_hni = r2_nonresident_hni;
	}
	public BigDecimal getR2_resident_gres() {
		return r2_resident_gres;
	}
	public void setR2_resident_gres(BigDecimal r2_resident_gres) {
		this.r2_resident_gres = r2_resident_gres;
	}
	public BigDecimal getR2_nonresident_gres() {
		return r2_nonresident_gres;
	}
	public void setR2_nonresident_gres(BigDecimal r2_nonresident_gres) {
		this.r2_nonresident_gres = r2_nonresident_gres;
	}
	public BigDecimal getR2_resident_corporate() {
		return r2_resident_corporate;
	}
	public void setR2_resident_corporate(BigDecimal r2_resident_corporate) {
		this.r2_resident_corporate = r2_resident_corporate;
	}
	public BigDecimal getR2_nonresident_corporate() {
		return r2_nonresident_corporate;
	}
	public void setR2_nonresident_corporate(BigDecimal r2_nonresident_corporate) {
		this.r2_nonresident_corporate = r2_nonresident_corporate;
	}
	public BigDecimal getR2_resident_nbfi() {
		return r2_resident_nbfi;
	}
	public void setR2_resident_nbfi(BigDecimal r2_resident_nbfi) {
		this.r2_resident_nbfi = r2_resident_nbfi;
	}
	public BigDecimal getR2_nonresident_nbfi() {
		return r2_nonresident_nbfi;
	}
	public void setR2_nonresident_nbfi(BigDecimal r2_nonresident_nbfi) {
		this.r2_nonresident_nbfi = r2_nonresident_nbfi;
	}
	public BigDecimal getR2_resident_banks() {
		return r2_resident_banks;
	}
	public void setR2_resident_banks(BigDecimal r2_resident_banks) {
		this.r2_resident_banks = r2_resident_banks;
	}
	public BigDecimal getR2_nonresident_banks() {
		return r2_nonresident_banks;
	}
	public void setR2_nonresident_banks(BigDecimal r2_nonresident_banks) {
		this.r2_nonresident_banks = r2_nonresident_banks;
	}
	public BigDecimal getR2_resident_gov_nces() {
		return r2_resident_gov_nces;
	}
	public void setR2_resident_gov_nces(BigDecimal r2_resident_gov_nces) {
		this.r2_resident_gov_nces = r2_resident_gov_nces;
	}
	public BigDecimal getR2_nonresident_gov_nces() {
		return r2_nonresident_gov_nces;
	}
	public void setR2_nonresident_gov_nces(BigDecimal r2_nonresident_gov_nces) {
		this.r2_nonresident_gov_nces = r2_nonresident_gov_nces;
	}
	public String getR3_particulars() {
		return r3_particulars;
	}
	public void setR3_particulars(String r3_particulars) {
		this.r3_particulars = r3_particulars;
	}
	public BigDecimal getR3_resident_individual() {
		return r3_resident_individual;
	}
	public void setR3_resident_individual(BigDecimal r3_resident_individual) {
		this.r3_resident_individual = r3_resident_individual;
	}
	public BigDecimal getR3_nonresident_individual() {
		return r3_nonresident_individual;
	}
	public void setR3_nonresident_individual(BigDecimal r3_nonresident_individual) {
		this.r3_nonresident_individual = r3_nonresident_individual;
	}
	public BigDecimal getR3_resident_retail() {
		return r3_resident_retail;
	}
	public void setR3_resident_retail(BigDecimal r3_resident_retail) {
		this.r3_resident_retail = r3_resident_retail;
	}
	public BigDecimal getR3_nonresident_retail() {
		return r3_nonresident_retail;
	}
	public void setR3_nonresident_retail(BigDecimal r3_nonresident_retail) {
		this.r3_nonresident_retail = r3_nonresident_retail;
	}
	public BigDecimal getR3_resident_sme() {
		return r3_resident_sme;
	}
	public void setR3_resident_sme(BigDecimal r3_resident_sme) {
		this.r3_resident_sme = r3_resident_sme;
	}
	public BigDecimal getR3_nonresident_sme() {
		return r3_nonresident_sme;
	}
	public void setR3_nonresident_sme(BigDecimal r3_nonresident_sme) {
		this.r3_nonresident_sme = r3_nonresident_sme;
	}
	public BigDecimal getR3_resident_hni() {
		return r3_resident_hni;
	}
	public void setR3_resident_hni(BigDecimal r3_resident_hni) {
		this.r3_resident_hni = r3_resident_hni;
	}
	public BigDecimal getR3_nonresident_hni() {
		return r3_nonresident_hni;
	}
	public void setR3_nonresident_hni(BigDecimal r3_nonresident_hni) {
		this.r3_nonresident_hni = r3_nonresident_hni;
	}
	public BigDecimal getR3_resident_gres() {
		return r3_resident_gres;
	}
	public void setR3_resident_gres(BigDecimal r3_resident_gres) {
		this.r3_resident_gres = r3_resident_gres;
	}
	public BigDecimal getR3_nonresident_gres() {
		return r3_nonresident_gres;
	}
	public void setR3_nonresident_gres(BigDecimal r3_nonresident_gres) {
		this.r3_nonresident_gres = r3_nonresident_gres;
	}
	public BigDecimal getR3_resident_corporate() {
		return r3_resident_corporate;
	}
	public void setR3_resident_corporate(BigDecimal r3_resident_corporate) {
		this.r3_resident_corporate = r3_resident_corporate;
	}
	public BigDecimal getR3_nonresident_corporate() {
		return r3_nonresident_corporate;
	}
	public void setR3_nonresident_corporate(BigDecimal r3_nonresident_corporate) {
		this.r3_nonresident_corporate = r3_nonresident_corporate;
	}
	public BigDecimal getR3_resident_nbfi() {
		return r3_resident_nbfi;
	}
	public void setR3_resident_nbfi(BigDecimal r3_resident_nbfi) {
		this.r3_resident_nbfi = r3_resident_nbfi;
	}
	public BigDecimal getR3_nonresident_nbfi() {
		return r3_nonresident_nbfi;
	}
	public void setR3_nonresident_nbfi(BigDecimal r3_nonresident_nbfi) {
		this.r3_nonresident_nbfi = r3_nonresident_nbfi;
	}
	public BigDecimal getR3_resident_banks() {
		return r3_resident_banks;
	}
	public void setR3_resident_banks(BigDecimal r3_resident_banks) {
		this.r3_resident_banks = r3_resident_banks;
	}
	public BigDecimal getR3_nonresident_banks() {
		return r3_nonresident_banks;
	}
	public void setR3_nonresident_banks(BigDecimal r3_nonresident_banks) {
		this.r3_nonresident_banks = r3_nonresident_banks;
	}
	public BigDecimal getR3_resident_gov_nces() {
		return r3_resident_gov_nces;
	}
	public void setR3_resident_gov_nces(BigDecimal r3_resident_gov_nces) {
		this.r3_resident_gov_nces = r3_resident_gov_nces;
	}
	public BigDecimal getR3_nonresident_gov_nces() {
		return r3_nonresident_gov_nces;
	}
	public void setR3_nonresident_gov_nces(BigDecimal r3_nonresident_gov_nces) {
		this.r3_nonresident_gov_nces = r3_nonresident_gov_nces;
	}
	public String getR4_particulars() {
		return r4_particulars;
	}
	public void setR4_particulars(String r4_particulars) {
		this.r4_particulars = r4_particulars;
	}
	public BigDecimal getR4_resident_individual() {
		return r4_resident_individual;
	}
	public void setR4_resident_individual(BigDecimal r4_resident_individual) {
		this.r4_resident_individual = r4_resident_individual;
	}
	public BigDecimal getR4_nonresident_individual() {
		return r4_nonresident_individual;
	}
	public void setR4_nonresident_individual(BigDecimal r4_nonresident_individual) {
		this.r4_nonresident_individual = r4_nonresident_individual;
	}
	public BigDecimal getR4_resident_retail() {
		return r4_resident_retail;
	}
	public void setR4_resident_retail(BigDecimal r4_resident_retail) {
		this.r4_resident_retail = r4_resident_retail;
	}
	public BigDecimal getR4_nonresident_retail() {
		return r4_nonresident_retail;
	}
	public void setR4_nonresident_retail(BigDecimal r4_nonresident_retail) {
		this.r4_nonresident_retail = r4_nonresident_retail;
	}
	public BigDecimal getR4_resident_sme() {
		return r4_resident_sme;
	}
	public void setR4_resident_sme(BigDecimal r4_resident_sme) {
		this.r4_resident_sme = r4_resident_sme;
	}
	public BigDecimal getR4_nonresident_sme() {
		return r4_nonresident_sme;
	}
	public void setR4_nonresident_sme(BigDecimal r4_nonresident_sme) {
		this.r4_nonresident_sme = r4_nonresident_sme;
	}
	public BigDecimal getR4_resident_hni() {
		return r4_resident_hni;
	}
	public void setR4_resident_hni(BigDecimal r4_resident_hni) {
		this.r4_resident_hni = r4_resident_hni;
	}
	public BigDecimal getR4_nonresident_hni() {
		return r4_nonresident_hni;
	}
	public void setR4_nonresident_hni(BigDecimal r4_nonresident_hni) {
		this.r4_nonresident_hni = r4_nonresident_hni;
	}
	public BigDecimal getR4_resident_gres() {
		return r4_resident_gres;
	}
	public void setR4_resident_gres(BigDecimal r4_resident_gres) {
		this.r4_resident_gres = r4_resident_gres;
	}
	public BigDecimal getR4_nonresident_gres() {
		return r4_nonresident_gres;
	}
	public void setR4_nonresident_gres(BigDecimal r4_nonresident_gres) {
		this.r4_nonresident_gres = r4_nonresident_gres;
	}
	public BigDecimal getR4_resident_corporate() {
		return r4_resident_corporate;
	}
	public void setR4_resident_corporate(BigDecimal r4_resident_corporate) {
		this.r4_resident_corporate = r4_resident_corporate;
	}
	public BigDecimal getR4_nonresident_corporate() {
		return r4_nonresident_corporate;
	}
	public void setR4_nonresident_corporate(BigDecimal r4_nonresident_corporate) {
		this.r4_nonresident_corporate = r4_nonresident_corporate;
	}
	public BigDecimal getR4_resident_nbfi() {
		return r4_resident_nbfi;
	}
	public void setR4_resident_nbfi(BigDecimal r4_resident_nbfi) {
		this.r4_resident_nbfi = r4_resident_nbfi;
	}
	public BigDecimal getR4_nonresident_nbfi() {
		return r4_nonresident_nbfi;
	}
	public void setR4_nonresident_nbfi(BigDecimal r4_nonresident_nbfi) {
		this.r4_nonresident_nbfi = r4_nonresident_nbfi;
	}
	public BigDecimal getR4_resident_banks() {
		return r4_resident_banks;
	}
	public void setR4_resident_banks(BigDecimal r4_resident_banks) {
		this.r4_resident_banks = r4_resident_banks;
	}
	public BigDecimal getR4_nonresident_banks() {
		return r4_nonresident_banks;
	}
	public void setR4_nonresident_banks(BigDecimal r4_nonresident_banks) {
		this.r4_nonresident_banks = r4_nonresident_banks;
	}
	public BigDecimal getR4_resident_gov_nces() {
		return r4_resident_gov_nces;
	}
	public void setR4_resident_gov_nces(BigDecimal r4_resident_gov_nces) {
		this.r4_resident_gov_nces = r4_resident_gov_nces;
	}
	public BigDecimal getR4_nonresident_gov_nces() {
		return r4_nonresident_gov_nces;
	}
	public void setR4_nonresident_gov_nces(BigDecimal r4_nonresident_gov_nces) {
		this.r4_nonresident_gov_nces = r4_nonresident_gov_nces;
	}
	public String getR5_particulars() {
		return r5_particulars;
	}
	public void setR5_particulars(String r5_particulars) {
		this.r5_particulars = r5_particulars;
	}
	public BigDecimal getR5_resident_individual() {
		return r5_resident_individual;
	}
	public void setR5_resident_individual(BigDecimal r5_resident_individual) {
		this.r5_resident_individual = r5_resident_individual;
	}
	public BigDecimal getR5_nonresident_individual() {
		return r5_nonresident_individual;
	}
	public void setR5_nonresident_individual(BigDecimal r5_nonresident_individual) {
		this.r5_nonresident_individual = r5_nonresident_individual;
	}
	public BigDecimal getR5_resident_retail() {
		return r5_resident_retail;
	}
	public void setR5_resident_retail(BigDecimal r5_resident_retail) {
		this.r5_resident_retail = r5_resident_retail;
	}
	public BigDecimal getR5_nonresident_retail() {
		return r5_nonresident_retail;
	}
	public void setR5_nonresident_retail(BigDecimal r5_nonresident_retail) {
		this.r5_nonresident_retail = r5_nonresident_retail;
	}
	public BigDecimal getR5_resident_sme() {
		return r5_resident_sme;
	}
	public void setR5_resident_sme(BigDecimal r5_resident_sme) {
		this.r5_resident_sme = r5_resident_sme;
	}
	public BigDecimal getR5_nonresident_sme() {
		return r5_nonresident_sme;
	}
	public void setR5_nonresident_sme(BigDecimal r5_nonresident_sme) {
		this.r5_nonresident_sme = r5_nonresident_sme;
	}
	public BigDecimal getR5_resident_hni() {
		return r5_resident_hni;
	}
	public void setR5_resident_hni(BigDecimal r5_resident_hni) {
		this.r5_resident_hni = r5_resident_hni;
	}
	public BigDecimal getR5_nonresident_hni() {
		return r5_nonresident_hni;
	}
	public void setR5_nonresident_hni(BigDecimal r5_nonresident_hni) {
		this.r5_nonresident_hni = r5_nonresident_hni;
	}
	public BigDecimal getR5_resident_gres() {
		return r5_resident_gres;
	}
	public void setR5_resident_gres(BigDecimal r5_resident_gres) {
		this.r5_resident_gres = r5_resident_gres;
	}
	public BigDecimal getR5_nonresident_gres() {
		return r5_nonresident_gres;
	}
	public void setR5_nonresident_gres(BigDecimal r5_nonresident_gres) {
		this.r5_nonresident_gres = r5_nonresident_gres;
	}
	public BigDecimal getR5_resident_corporate() {
		return r5_resident_corporate;
	}
	public void setR5_resident_corporate(BigDecimal r5_resident_corporate) {
		this.r5_resident_corporate = r5_resident_corporate;
	}
	public BigDecimal getR5_nonresident_corporate() {
		return r5_nonresident_corporate;
	}
	public void setR5_nonresident_corporate(BigDecimal r5_nonresident_corporate) {
		this.r5_nonresident_corporate = r5_nonresident_corporate;
	}
	public BigDecimal getR5_resident_nbfi() {
		return r5_resident_nbfi;
	}
	public void setR5_resident_nbfi(BigDecimal r5_resident_nbfi) {
		this.r5_resident_nbfi = r5_resident_nbfi;
	}
	public BigDecimal getR5_nonresident_nbfi() {
		return r5_nonresident_nbfi;
	}
	public void setR5_nonresident_nbfi(BigDecimal r5_nonresident_nbfi) {
		this.r5_nonresident_nbfi = r5_nonresident_nbfi;
	}
	public BigDecimal getR5_resident_banks() {
		return r5_resident_banks;
	}
	public void setR5_resident_banks(BigDecimal r5_resident_banks) {
		this.r5_resident_banks = r5_resident_banks;
	}
	public BigDecimal getR5_nonresident_banks() {
		return r5_nonresident_banks;
	}
	public void setR5_nonresident_banks(BigDecimal r5_nonresident_banks) {
		this.r5_nonresident_banks = r5_nonresident_banks;
	}
	public BigDecimal getR5_resident_gov_nces() {
		return r5_resident_gov_nces;
	}
	public void setR5_resident_gov_nces(BigDecimal r5_resident_gov_nces) {
		this.r5_resident_gov_nces = r5_resident_gov_nces;
	}
	public BigDecimal getR5_nonresident_gov_nces() {
		return r5_nonresident_gov_nces;
	}
	public void setR5_nonresident_gov_nces(BigDecimal r5_nonresident_gov_nces) {
		this.r5_nonresident_gov_nces = r5_nonresident_gov_nces;
	}
	public String getR6_particulars() {
		return r6_particulars;
	}
	public void setR6_particulars(String r6_particulars) {
		this.r6_particulars = r6_particulars;
	}
	public BigDecimal getR6_resident_individual() {
		return r6_resident_individual;
	}
	public void setR6_resident_individual(BigDecimal r6_resident_individual) {
		this.r6_resident_individual = r6_resident_individual;
	}
	public BigDecimal getR6_nonresident_individual() {
		return r6_nonresident_individual;
	}
	public void setR6_nonresident_individual(BigDecimal r6_nonresident_individual) {
		this.r6_nonresident_individual = r6_nonresident_individual;
	}
	public BigDecimal getR6_resident_retail() {
		return r6_resident_retail;
	}
	public void setR6_resident_retail(BigDecimal r6_resident_retail) {
		this.r6_resident_retail = r6_resident_retail;
	}
	public BigDecimal getR6_nonresident_retail() {
		return r6_nonresident_retail;
	}
	public void setR6_nonresident_retail(BigDecimal r6_nonresident_retail) {
		this.r6_nonresident_retail = r6_nonresident_retail;
	}
	public BigDecimal getR6_resident_sme() {
		return r6_resident_sme;
	}
	public void setR6_resident_sme(BigDecimal r6_resident_sme) {
		this.r6_resident_sme = r6_resident_sme;
	}
	public BigDecimal getR6_nonresident_sme() {
		return r6_nonresident_sme;
	}
	public void setR6_nonresident_sme(BigDecimal r6_nonresident_sme) {
		this.r6_nonresident_sme = r6_nonresident_sme;
	}
	public BigDecimal getR6_resident_hni() {
		return r6_resident_hni;
	}
	public void setR6_resident_hni(BigDecimal r6_resident_hni) {
		this.r6_resident_hni = r6_resident_hni;
	}
	public BigDecimal getR6_nonresident_hni() {
		return r6_nonresident_hni;
	}
	public void setR6_nonresident_hni(BigDecimal r6_nonresident_hni) {
		this.r6_nonresident_hni = r6_nonresident_hni;
	}
	public BigDecimal getR6_resident_gres() {
		return r6_resident_gres;
	}
	public void setR6_resident_gres(BigDecimal r6_resident_gres) {
		this.r6_resident_gres = r6_resident_gres;
	}
	public BigDecimal getR6_nonresident_gres() {
		return r6_nonresident_gres;
	}
	public void setR6_nonresident_gres(BigDecimal r6_nonresident_gres) {
		this.r6_nonresident_gres = r6_nonresident_gres;
	}
	public BigDecimal getR6_resident_corporate() {
		return r6_resident_corporate;
	}
	public void setR6_resident_corporate(BigDecimal r6_resident_corporate) {
		this.r6_resident_corporate = r6_resident_corporate;
	}
	public BigDecimal getR6_nonresident_corporate() {
		return r6_nonresident_corporate;
	}
	public void setR6_nonresident_corporate(BigDecimal r6_nonresident_corporate) {
		this.r6_nonresident_corporate = r6_nonresident_corporate;
	}
	public BigDecimal getR6_resident_nbfi() {
		return r6_resident_nbfi;
	}
	public void setR6_resident_nbfi(BigDecimal r6_resident_nbfi) {
		this.r6_resident_nbfi = r6_resident_nbfi;
	}
	public BigDecimal getR6_nonresident_nbfi() {
		return r6_nonresident_nbfi;
	}
	public void setR6_nonresident_nbfi(BigDecimal r6_nonresident_nbfi) {
		this.r6_nonresident_nbfi = r6_nonresident_nbfi;
	}
	public BigDecimal getR6_resident_banks() {
		return r6_resident_banks;
	}
	public void setR6_resident_banks(BigDecimal r6_resident_banks) {
		this.r6_resident_banks = r6_resident_banks;
	}
	public BigDecimal getR6_nonresident_banks() {
		return r6_nonresident_banks;
	}
	public void setR6_nonresident_banks(BigDecimal r6_nonresident_banks) {
		this.r6_nonresident_banks = r6_nonresident_banks;
	}
	public BigDecimal getR6_resident_gov_nces() {
		return r6_resident_gov_nces;
	}
	public void setR6_resident_gov_nces(BigDecimal r6_resident_gov_nces) {
		this.r6_resident_gov_nces = r6_resident_gov_nces;
	}
	public BigDecimal getR6_nonresident_gov_nces() {
		return r6_nonresident_gov_nces;
	}
	public void setR6_nonresident_gov_nces(BigDecimal r6_nonresident_gov_nces) {
		this.r6_nonresident_gov_nces = r6_nonresident_gov_nces;
	}
	public String getR7_particulars() {
		return r7_particulars;
	}
	public void setR7_particulars(String r7_particulars) {
		this.r7_particulars = r7_particulars;
	}
	public BigDecimal getR7_resident_individual() {
		return r7_resident_individual;
	}
	public void setR7_resident_individual(BigDecimal r7_resident_individual) {
		this.r7_resident_individual = r7_resident_individual;
	}
	public BigDecimal getR7_nonresident_individual() {
		return r7_nonresident_individual;
	}
	public void setR7_nonresident_individual(BigDecimal r7_nonresident_individual) {
		this.r7_nonresident_individual = r7_nonresident_individual;
	}
	public BigDecimal getR7_resident_retail() {
		return r7_resident_retail;
	}
	public void setR7_resident_retail(BigDecimal r7_resident_retail) {
		this.r7_resident_retail = r7_resident_retail;
	}
	public BigDecimal getR7_nonresident_retail() {
		return r7_nonresident_retail;
	}
	public void setR7_nonresident_retail(BigDecimal r7_nonresident_retail) {
		this.r7_nonresident_retail = r7_nonresident_retail;
	}
	public BigDecimal getR7_resident_sme() {
		return r7_resident_sme;
	}
	public void setR7_resident_sme(BigDecimal r7_resident_sme) {
		this.r7_resident_sme = r7_resident_sme;
	}
	public BigDecimal getR7_nonresident_sme() {
		return r7_nonresident_sme;
	}
	public void setR7_nonresident_sme(BigDecimal r7_nonresident_sme) {
		this.r7_nonresident_sme = r7_nonresident_sme;
	}
	public BigDecimal getR7_resident_hni() {
		return r7_resident_hni;
	}
	public void setR7_resident_hni(BigDecimal r7_resident_hni) {
		this.r7_resident_hni = r7_resident_hni;
	}
	public BigDecimal getR7_nonresident_hni() {
		return r7_nonresident_hni;
	}
	public void setR7_nonresident_hni(BigDecimal r7_nonresident_hni) {
		this.r7_nonresident_hni = r7_nonresident_hni;
	}
	public BigDecimal getR7_resident_gres() {
		return r7_resident_gres;
	}
	public void setR7_resident_gres(BigDecimal r7_resident_gres) {
		this.r7_resident_gres = r7_resident_gres;
	}
	public BigDecimal getR7_nonresident_gres() {
		return r7_nonresident_gres;
	}
	public void setR7_nonresident_gres(BigDecimal r7_nonresident_gres) {
		this.r7_nonresident_gres = r7_nonresident_gres;
	}
	public BigDecimal getR7_resident_corporate() {
		return r7_resident_corporate;
	}
	public void setR7_resident_corporate(BigDecimal r7_resident_corporate) {
		this.r7_resident_corporate = r7_resident_corporate;
	}
	public BigDecimal getR7_nonresident_corporate() {
		return r7_nonresident_corporate;
	}
	public void setR7_nonresident_corporate(BigDecimal r7_nonresident_corporate) {
		this.r7_nonresident_corporate = r7_nonresident_corporate;
	}
	public BigDecimal getR7_resident_nbfi() {
		return r7_resident_nbfi;
	}
	public void setR7_resident_nbfi(BigDecimal r7_resident_nbfi) {
		this.r7_resident_nbfi = r7_resident_nbfi;
	}
	public BigDecimal getR7_nonresident_nbfi() {
		return r7_nonresident_nbfi;
	}
	public void setR7_nonresident_nbfi(BigDecimal r7_nonresident_nbfi) {
		this.r7_nonresident_nbfi = r7_nonresident_nbfi;
	}
	public BigDecimal getR7_resident_banks() {
		return r7_resident_banks;
	}
	public void setR7_resident_banks(BigDecimal r7_resident_banks) {
		this.r7_resident_banks = r7_resident_banks;
	}
	public BigDecimal getR7_nonresident_banks() {
		return r7_nonresident_banks;
	}
	public void setR7_nonresident_banks(BigDecimal r7_nonresident_banks) {
		this.r7_nonresident_banks = r7_nonresident_banks;
	}
	public BigDecimal getR7_resident_gov_nces() {
		return r7_resident_gov_nces;
	}
	public void setR7_resident_gov_nces(BigDecimal r7_resident_gov_nces) {
		this.r7_resident_gov_nces = r7_resident_gov_nces;
	}
	public BigDecimal getR7_nonresident_gov_nces() {
		return r7_nonresident_gov_nces;
	}
	public void setR7_nonresident_gov_nces(BigDecimal r7_nonresident_gov_nces) {
		this.r7_nonresident_gov_nces = r7_nonresident_gov_nces;
	}
	public String getR8_particulars() {
		return r8_particulars;
	}
	public void setR8_particulars(String r8_particulars) {
		this.r8_particulars = r8_particulars;
	}
	public BigDecimal getR8_resident_individual() {
		return r8_resident_individual;
	}
	public void setR8_resident_individual(BigDecimal r8_resident_individual) {
		this.r8_resident_individual = r8_resident_individual;
	}
	public BigDecimal getR8_nonresident_individual() {
		return r8_nonresident_individual;
	}
	public void setR8_nonresident_individual(BigDecimal r8_nonresident_individual) {
		this.r8_nonresident_individual = r8_nonresident_individual;
	}
	public BigDecimal getR8_resident_retail() {
		return r8_resident_retail;
	}
	public void setR8_resident_retail(BigDecimal r8_resident_retail) {
		this.r8_resident_retail = r8_resident_retail;
	}
	public BigDecimal getR8_nonresident_retail() {
		return r8_nonresident_retail;
	}
	public void setR8_nonresident_retail(BigDecimal r8_nonresident_retail) {
		this.r8_nonresident_retail = r8_nonresident_retail;
	}
	public BigDecimal getR8_resident_sme() {
		return r8_resident_sme;
	}
	public void setR8_resident_sme(BigDecimal r8_resident_sme) {
		this.r8_resident_sme = r8_resident_sme;
	}
	public BigDecimal getR8_nonresident_sme() {
		return r8_nonresident_sme;
	}
	public void setR8_nonresident_sme(BigDecimal r8_nonresident_sme) {
		this.r8_nonresident_sme = r8_nonresident_sme;
	}
	public BigDecimal getR8_resident_hni() {
		return r8_resident_hni;
	}
	public void setR8_resident_hni(BigDecimal r8_resident_hni) {
		this.r8_resident_hni = r8_resident_hni;
	}
	public BigDecimal getR8_nonresident_hni() {
		return r8_nonresident_hni;
	}
	public void setR8_nonresident_hni(BigDecimal r8_nonresident_hni) {
		this.r8_nonresident_hni = r8_nonresident_hni;
	}
	public BigDecimal getR8_resident_gres() {
		return r8_resident_gres;
	}
	public void setR8_resident_gres(BigDecimal r8_resident_gres) {
		this.r8_resident_gres = r8_resident_gres;
	}
	public BigDecimal getR8_nonresident_gres() {
		return r8_nonresident_gres;
	}
	public void setR8_nonresident_gres(BigDecimal r8_nonresident_gres) {
		this.r8_nonresident_gres = r8_nonresident_gres;
	}
	public BigDecimal getR8_resident_corporate() {
		return r8_resident_corporate;
	}
	public void setR8_resident_corporate(BigDecimal r8_resident_corporate) {
		this.r8_resident_corporate = r8_resident_corporate;
	}
	public BigDecimal getR8_nonresident_corporate() {
		return r8_nonresident_corporate;
	}
	public void setR8_nonresident_corporate(BigDecimal r8_nonresident_corporate) {
		this.r8_nonresident_corporate = r8_nonresident_corporate;
	}
	public BigDecimal getR8_resident_nbfi() {
		return r8_resident_nbfi;
	}
	public void setR8_resident_nbfi(BigDecimal r8_resident_nbfi) {
		this.r8_resident_nbfi = r8_resident_nbfi;
	}
	public BigDecimal getR8_nonresident_nbfi() {
		return r8_nonresident_nbfi;
	}
	public void setR8_nonresident_nbfi(BigDecimal r8_nonresident_nbfi) {
		this.r8_nonresident_nbfi = r8_nonresident_nbfi;
	}
	public BigDecimal getR8_resident_banks() {
		return r8_resident_banks;
	}
	public void setR8_resident_banks(BigDecimal r8_resident_banks) {
		this.r8_resident_banks = r8_resident_banks;
	}
	public BigDecimal getR8_nonresident_banks() {
		return r8_nonresident_banks;
	}
	public void setR8_nonresident_banks(BigDecimal r8_nonresident_banks) {
		this.r8_nonresident_banks = r8_nonresident_banks;
	}
	public BigDecimal getR8_resident_gov_nces() {
		return r8_resident_gov_nces;
	}
	public void setR8_resident_gov_nces(BigDecimal r8_resident_gov_nces) {
		this.r8_resident_gov_nces = r8_resident_gov_nces;
	}
	public BigDecimal getR8_nonresident_gov_nces() {
		return r8_nonresident_gov_nces;
	}
	public void setR8_nonresident_gov_nces(BigDecimal r8_nonresident_gov_nces) {
		this.r8_nonresident_gov_nces = r8_nonresident_gov_nces;
	}
	public String getR9_particulars() {
		return r9_particulars;
	}
	public void setR9_particulars(String r9_particulars) {
		this.r9_particulars = r9_particulars;
	}
	public BigDecimal getR9_resident_individual() {
		return r9_resident_individual;
	}
	public void setR9_resident_individual(BigDecimal r9_resident_individual) {
		this.r9_resident_individual = r9_resident_individual;
	}
	public BigDecimal getR9_nonresident_individual() {
		return r9_nonresident_individual;
	}
	public void setR9_nonresident_individual(BigDecimal r9_nonresident_individual) {
		this.r9_nonresident_individual = r9_nonresident_individual;
	}
	public BigDecimal getR9_resident_retail() {
		return r9_resident_retail;
	}
	public void setR9_resident_retail(BigDecimal r9_resident_retail) {
		this.r9_resident_retail = r9_resident_retail;
	}
	public BigDecimal getR9_nonresident_retail() {
		return r9_nonresident_retail;
	}
	public void setR9_nonresident_retail(BigDecimal r9_nonresident_retail) {
		this.r9_nonresident_retail = r9_nonresident_retail;
	}
	public BigDecimal getR9_resident_sme() {
		return r9_resident_sme;
	}
	public void setR9_resident_sme(BigDecimal r9_resident_sme) {
		this.r9_resident_sme = r9_resident_sme;
	}
	public BigDecimal getR9_nonresident_sme() {
		return r9_nonresident_sme;
	}
	public void setR9_nonresident_sme(BigDecimal r9_nonresident_sme) {
		this.r9_nonresident_sme = r9_nonresident_sme;
	}
	public BigDecimal getR9_resident_hni() {
		return r9_resident_hni;
	}
	public void setR9_resident_hni(BigDecimal r9_resident_hni) {
		this.r9_resident_hni = r9_resident_hni;
	}
	public BigDecimal getR9_nonresident_hni() {
		return r9_nonresident_hni;
	}
	public void setR9_nonresident_hni(BigDecimal r9_nonresident_hni) {
		this.r9_nonresident_hni = r9_nonresident_hni;
	}
	public BigDecimal getR9_resident_gres() {
		return r9_resident_gres;
	}
	public void setR9_resident_gres(BigDecimal r9_resident_gres) {
		this.r9_resident_gres = r9_resident_gres;
	}
	public BigDecimal getR9_nonresident_gres() {
		return r9_nonresident_gres;
	}
	public void setR9_nonresident_gres(BigDecimal r9_nonresident_gres) {
		this.r9_nonresident_gres = r9_nonresident_gres;
	}
	public BigDecimal getR9_resident_corporate() {
		return r9_resident_corporate;
	}
	public void setR9_resident_corporate(BigDecimal r9_resident_corporate) {
		this.r9_resident_corporate = r9_resident_corporate;
	}
	public BigDecimal getR9_nonresident_corporate() {
		return r9_nonresident_corporate;
	}
	public void setR9_nonresident_corporate(BigDecimal r9_nonresident_corporate) {
		this.r9_nonresident_corporate = r9_nonresident_corporate;
	}
	public BigDecimal getR9_resident_nbfi() {
		return r9_resident_nbfi;
	}
	public void setR9_resident_nbfi(BigDecimal r9_resident_nbfi) {
		this.r9_resident_nbfi = r9_resident_nbfi;
	}
	public BigDecimal getR9_nonresident_nbfi() {
		return r9_nonresident_nbfi;
	}
	public void setR9_nonresident_nbfi(BigDecimal r9_nonresident_nbfi) {
		this.r9_nonresident_nbfi = r9_nonresident_nbfi;
	}
	public BigDecimal getR9_resident_banks() {
		return r9_resident_banks;
	}
	public void setR9_resident_banks(BigDecimal r9_resident_banks) {
		this.r9_resident_banks = r9_resident_banks;
	}
	public BigDecimal getR9_nonresident_banks() {
		return r9_nonresident_banks;
	}
	public void setR9_nonresident_banks(BigDecimal r9_nonresident_banks) {
		this.r9_nonresident_banks = r9_nonresident_banks;
	}
	public BigDecimal getR9_resident_gov_nces() {
		return r9_resident_gov_nces;
	}
	public void setR9_resident_gov_nces(BigDecimal r9_resident_gov_nces) {
		this.r9_resident_gov_nces = r9_resident_gov_nces;
	}
	public BigDecimal getR9_nonresident_gov_nces() {
		return r9_nonresident_gov_nces;
	}
	public void setR9_nonresident_gov_nces(BigDecimal r9_nonresident_gov_nces) {
		this.r9_nonresident_gov_nces = r9_nonresident_gov_nces;
	}
	public String getR10_particulars() {
		return r10_particulars;
	}
	public void setR10_particulars(String r10_particulars) {
		this.r10_particulars = r10_particulars;
	}
	public BigDecimal getR10_resident_individual() {
		return r10_resident_individual;
	}
	public void setR10_resident_individual(BigDecimal r10_resident_individual) {
		this.r10_resident_individual = r10_resident_individual;
	}
	public BigDecimal getR10_nonresident_individual() {
		return r10_nonresident_individual;
	}
	public void setR10_nonresident_individual(BigDecimal r10_nonresident_individual) {
		this.r10_nonresident_individual = r10_nonresident_individual;
	}
	public BigDecimal getR10_resident_retail() {
		return r10_resident_retail;
	}
	public void setR10_resident_retail(BigDecimal r10_resident_retail) {
		this.r10_resident_retail = r10_resident_retail;
	}
	public BigDecimal getR10_nonresident_retail() {
		return r10_nonresident_retail;
	}
	public void setR10_nonresident_retail(BigDecimal r10_nonresident_retail) {
		this.r10_nonresident_retail = r10_nonresident_retail;
	}
	public BigDecimal getR10_resident_sme() {
		return r10_resident_sme;
	}
	public void setR10_resident_sme(BigDecimal r10_resident_sme) {
		this.r10_resident_sme = r10_resident_sme;
	}
	public BigDecimal getR10_nonresident_sme() {
		return r10_nonresident_sme;
	}
	public void setR10_nonresident_sme(BigDecimal r10_nonresident_sme) {
		this.r10_nonresident_sme = r10_nonresident_sme;
	}
	public BigDecimal getR10_resident_hni() {
		return r10_resident_hni;
	}
	public void setR10_resident_hni(BigDecimal r10_resident_hni) {
		this.r10_resident_hni = r10_resident_hni;
	}
	public BigDecimal getR10_nonresident_hni() {
		return r10_nonresident_hni;
	}
	public void setR10_nonresident_hni(BigDecimal r10_nonresident_hni) {
		this.r10_nonresident_hni = r10_nonresident_hni;
	}
	public BigDecimal getR10_resident_gres() {
		return r10_resident_gres;
	}
	public void setR10_resident_gres(BigDecimal r10_resident_gres) {
		this.r10_resident_gres = r10_resident_gres;
	}
	public BigDecimal getR10_nonresident_gres() {
		return r10_nonresident_gres;
	}
	public void setR10_nonresident_gres(BigDecimal r10_nonresident_gres) {
		this.r10_nonresident_gres = r10_nonresident_gres;
	}
	public BigDecimal getR10_resident_corporate() {
		return r10_resident_corporate;
	}
	public void setR10_resident_corporate(BigDecimal r10_resident_corporate) {
		this.r10_resident_corporate = r10_resident_corporate;
	}
	public BigDecimal getR10_nonresident_corporate() {
		return r10_nonresident_corporate;
	}
	public void setR10_nonresident_corporate(BigDecimal r10_nonresident_corporate) {
		this.r10_nonresident_corporate = r10_nonresident_corporate;
	}
	public BigDecimal getR10_resident_nbfi() {
		return r10_resident_nbfi;
	}
	public void setR10_resident_nbfi(BigDecimal r10_resident_nbfi) {
		this.r10_resident_nbfi = r10_resident_nbfi;
	}
	public BigDecimal getR10_nonresident_nbfi() {
		return r10_nonresident_nbfi;
	}
	public void setR10_nonresident_nbfi(BigDecimal r10_nonresident_nbfi) {
		this.r10_nonresident_nbfi = r10_nonresident_nbfi;
	}
	public BigDecimal getR10_resident_banks() {
		return r10_resident_banks;
	}
	public void setR10_resident_banks(BigDecimal r10_resident_banks) {
		this.r10_resident_banks = r10_resident_banks;
	}
	public BigDecimal getR10_nonresident_banks() {
		return r10_nonresident_banks;
	}
	public void setR10_nonresident_banks(BigDecimal r10_nonresident_banks) {
		this.r10_nonresident_banks = r10_nonresident_banks;
	}
	public BigDecimal getR10_resident_gov_nces() {
		return r10_resident_gov_nces;
	}
	public void setR10_resident_gov_nces(BigDecimal r10_resident_gov_nces) {
		this.r10_resident_gov_nces = r10_resident_gov_nces;
	}
	public BigDecimal getR10_nonresident_gov_nces() {
		return r10_nonresident_gov_nces;
	}
	public void setR10_nonresident_gov_nces(BigDecimal r10_nonresident_gov_nces) {
		this.r10_nonresident_gov_nces = r10_nonresident_gov_nces;
	}
	public String getR11_particulars() {
		return r11_particulars;
	}
	public void setR11_particulars(String r11_particulars) {
		this.r11_particulars = r11_particulars;
	}
	public BigDecimal getR11_resident_individual() {
		return r11_resident_individual;
	}
	public void setR11_resident_individual(BigDecimal r11_resident_individual) {
		this.r11_resident_individual = r11_resident_individual;
	}
	public BigDecimal getR11_nonresident_individual() {
		return r11_nonresident_individual;
	}
	public void setR11_nonresident_individual(BigDecimal r11_nonresident_individual) {
		this.r11_nonresident_individual = r11_nonresident_individual;
	}
	public BigDecimal getR11_resident_retail() {
		return r11_resident_retail;
	}
	public void setR11_resident_retail(BigDecimal r11_resident_retail) {
		this.r11_resident_retail = r11_resident_retail;
	}
	public BigDecimal getR11_nonresident_retail() {
		return r11_nonresident_retail;
	}
	public void setR11_nonresident_retail(BigDecimal r11_nonresident_retail) {
		this.r11_nonresident_retail = r11_nonresident_retail;
	}
	public BigDecimal getR11_resident_sme() {
		return r11_resident_sme;
	}
	public void setR11_resident_sme(BigDecimal r11_resident_sme) {
		this.r11_resident_sme = r11_resident_sme;
	}
	public BigDecimal getR11_nonresident_sme() {
		return r11_nonresident_sme;
	}
	public void setR11_nonresident_sme(BigDecimal r11_nonresident_sme) {
		this.r11_nonresident_sme = r11_nonresident_sme;
	}
	public BigDecimal getR11_resident_hni() {
		return r11_resident_hni;
	}
	public void setR11_resident_hni(BigDecimal r11_resident_hni) {
		this.r11_resident_hni = r11_resident_hni;
	}
	public BigDecimal getR11_nonresident_hni() {
		return r11_nonresident_hni;
	}
	public void setR11_nonresident_hni(BigDecimal r11_nonresident_hni) {
		this.r11_nonresident_hni = r11_nonresident_hni;
	}
	public BigDecimal getR11_resident_gres() {
		return r11_resident_gres;
	}
	public void setR11_resident_gres(BigDecimal r11_resident_gres) {
		this.r11_resident_gres = r11_resident_gres;
	}
	public BigDecimal getR11_nonresident_gres() {
		return r11_nonresident_gres;
	}
	public void setR11_nonresident_gres(BigDecimal r11_nonresident_gres) {
		this.r11_nonresident_gres = r11_nonresident_gres;
	}
	public BigDecimal getR11_resident_corporate() {
		return r11_resident_corporate;
	}
	public void setR11_resident_corporate(BigDecimal r11_resident_corporate) {
		this.r11_resident_corporate = r11_resident_corporate;
	}
	public BigDecimal getR11_nonresident_corporate() {
		return r11_nonresident_corporate;
	}
	public void setR11_nonresident_corporate(BigDecimal r11_nonresident_corporate) {
		this.r11_nonresident_corporate = r11_nonresident_corporate;
	}
	public BigDecimal getR11_resident_nbfi() {
		return r11_resident_nbfi;
	}
	public void setR11_resident_nbfi(BigDecimal r11_resident_nbfi) {
		this.r11_resident_nbfi = r11_resident_nbfi;
	}
	public BigDecimal getR11_nonresident_nbfi() {
		return r11_nonresident_nbfi;
	}
	public void setR11_nonresident_nbfi(BigDecimal r11_nonresident_nbfi) {
		this.r11_nonresident_nbfi = r11_nonresident_nbfi;
	}
	public BigDecimal getR11_resident_banks() {
		return r11_resident_banks;
	}
	public void setR11_resident_banks(BigDecimal r11_resident_banks) {
		this.r11_resident_banks = r11_resident_banks;
	}
	public BigDecimal getR11_nonresident_banks() {
		return r11_nonresident_banks;
	}
	public void setR11_nonresident_banks(BigDecimal r11_nonresident_banks) {
		this.r11_nonresident_banks = r11_nonresident_banks;
	}
	public BigDecimal getR11_resident_gov_nces() {
		return r11_resident_gov_nces;
	}
	public void setR11_resident_gov_nces(BigDecimal r11_resident_gov_nces) {
		this.r11_resident_gov_nces = r11_resident_gov_nces;
	}
	public BigDecimal getR11_nonresident_gov_nces() {
		return r11_nonresident_gov_nces;
	}
	public void setR11_nonresident_gov_nces(BigDecimal r11_nonresident_gov_nces) {
		this.r11_nonresident_gov_nces = r11_nonresident_gov_nces;
	}
	public String getR12_particulars() {
		return r12_particulars;
	}
	public void setR12_particulars(String r12_particulars) {
		this.r12_particulars = r12_particulars;
	}
	public BigDecimal getR12_resident_individual() {
		return r12_resident_individual;
	}
	public void setR12_resident_individual(BigDecimal r12_resident_individual) {
		this.r12_resident_individual = r12_resident_individual;
	}
	public BigDecimal getR12_nonresident_individual() {
		return r12_nonresident_individual;
	}
	public void setR12_nonresident_individual(BigDecimal r12_nonresident_individual) {
		this.r12_nonresident_individual = r12_nonresident_individual;
	}
	public BigDecimal getR12_resident_retail() {
		return r12_resident_retail;
	}
	public void setR12_resident_retail(BigDecimal r12_resident_retail) {
		this.r12_resident_retail = r12_resident_retail;
	}
	public BigDecimal getR12_nonresident_retail() {
		return r12_nonresident_retail;
	}
	public void setR12_nonresident_retail(BigDecimal r12_nonresident_retail) {
		this.r12_nonresident_retail = r12_nonresident_retail;
	}
	public BigDecimal getR12_resident_sme() {
		return r12_resident_sme;
	}
	public void setR12_resident_sme(BigDecimal r12_resident_sme) {
		this.r12_resident_sme = r12_resident_sme;
	}
	public BigDecimal getR12_nonresident_sme() {
		return r12_nonresident_sme;
	}
	public void setR12_nonresident_sme(BigDecimal r12_nonresident_sme) {
		this.r12_nonresident_sme = r12_nonresident_sme;
	}
	public BigDecimal getR12_resident_hni() {
		return r12_resident_hni;
	}
	public void setR12_resident_hni(BigDecimal r12_resident_hni) {
		this.r12_resident_hni = r12_resident_hni;
	}
	public BigDecimal getR12_nonresident_hni() {
		return r12_nonresident_hni;
	}
	public void setR12_nonresident_hni(BigDecimal r12_nonresident_hni) {
		this.r12_nonresident_hni = r12_nonresident_hni;
	}
	public BigDecimal getR12_resident_gres() {
		return r12_resident_gres;
	}
	public void setR12_resident_gres(BigDecimal r12_resident_gres) {
		this.r12_resident_gres = r12_resident_gres;
	}
	public BigDecimal getR12_nonresident_gres() {
		return r12_nonresident_gres;
	}
	public void setR12_nonresident_gres(BigDecimal r12_nonresident_gres) {
		this.r12_nonresident_gres = r12_nonresident_gres;
	}
	public BigDecimal getR12_resident_corporate() {
		return r12_resident_corporate;
	}
	public void setR12_resident_corporate(BigDecimal r12_resident_corporate) {
		this.r12_resident_corporate = r12_resident_corporate;
	}
	public BigDecimal getR12_nonresident_corporate() {
		return r12_nonresident_corporate;
	}
	public void setR12_nonresident_corporate(BigDecimal r12_nonresident_corporate) {
		this.r12_nonresident_corporate = r12_nonresident_corporate;
	}
	public BigDecimal getR12_resident_nbfi() {
		return r12_resident_nbfi;
	}
	public void setR12_resident_nbfi(BigDecimal r12_resident_nbfi) {
		this.r12_resident_nbfi = r12_resident_nbfi;
	}
	public BigDecimal getR12_nonresident_nbfi() {
		return r12_nonresident_nbfi;
	}
	public void setR12_nonresident_nbfi(BigDecimal r12_nonresident_nbfi) {
		this.r12_nonresident_nbfi = r12_nonresident_nbfi;
	}
	public BigDecimal getR12_resident_banks() {
		return r12_resident_banks;
	}
	public void setR12_resident_banks(BigDecimal r12_resident_banks) {
		this.r12_resident_banks = r12_resident_banks;
	}
	public BigDecimal getR12_nonresident_banks() {
		return r12_nonresident_banks;
	}
	public void setR12_nonresident_banks(BigDecimal r12_nonresident_banks) {
		this.r12_nonresident_banks = r12_nonresident_banks;
	}
	public BigDecimal getR12_resident_gov_nces() {
		return r12_resident_gov_nces;
	}
	public void setR12_resident_gov_nces(BigDecimal r12_resident_gov_nces) {
		this.r12_resident_gov_nces = r12_resident_gov_nces;
	}
	public BigDecimal getR12_nonresident_gov_nces() {
		return r12_nonresident_gov_nces;
	}
	public void setR12_nonresident_gov_nces(BigDecimal r12_nonresident_gov_nces) {
		this.r12_nonresident_gov_nces = r12_nonresident_gov_nces;
	}
	public String getR13_particulars() {
		return r13_particulars;
	}
	public void setR13_particulars(String r13_particulars) {
		this.r13_particulars = r13_particulars;
	}
	public BigDecimal getR13_resident_individual() {
		return r13_resident_individual;
	}
	public void setR13_resident_individual(BigDecimal r13_resident_individual) {
		this.r13_resident_individual = r13_resident_individual;
	}
	public BigDecimal getR13_nonresident_individual() {
		return r13_nonresident_individual;
	}
	public void setR13_nonresident_individual(BigDecimal r13_nonresident_individual) {
		this.r13_nonresident_individual = r13_nonresident_individual;
	}
	public BigDecimal getR13_resident_retail() {
		return r13_resident_retail;
	}
	public void setR13_resident_retail(BigDecimal r13_resident_retail) {
		this.r13_resident_retail = r13_resident_retail;
	}
	public BigDecimal getR13_nonresident_retail() {
		return r13_nonresident_retail;
	}
	public void setR13_nonresident_retail(BigDecimal r13_nonresident_retail) {
		this.r13_nonresident_retail = r13_nonresident_retail;
	}
	public BigDecimal getR13_resident_sme() {
		return r13_resident_sme;
	}
	public void setR13_resident_sme(BigDecimal r13_resident_sme) {
		this.r13_resident_sme = r13_resident_sme;
	}
	public BigDecimal getR13_nonresident_sme() {
		return r13_nonresident_sme;
	}
	public void setR13_nonresident_sme(BigDecimal r13_nonresident_sme) {
		this.r13_nonresident_sme = r13_nonresident_sme;
	}
	public BigDecimal getR13_resident_hni() {
		return r13_resident_hni;
	}
	public void setR13_resident_hni(BigDecimal r13_resident_hni) {
		this.r13_resident_hni = r13_resident_hni;
	}
	public BigDecimal getR13_nonresident_hni() {
		return r13_nonresident_hni;
	}
	public void setR13_nonresident_hni(BigDecimal r13_nonresident_hni) {
		this.r13_nonresident_hni = r13_nonresident_hni;
	}
	public BigDecimal getR13_resident_gres() {
		return r13_resident_gres;
	}
	public void setR13_resident_gres(BigDecimal r13_resident_gres) {
		this.r13_resident_gres = r13_resident_gres;
	}
	public BigDecimal getR13_nonresident_gres() {
		return r13_nonresident_gres;
	}
	public void setR13_nonresident_gres(BigDecimal r13_nonresident_gres) {
		this.r13_nonresident_gres = r13_nonresident_gres;
	}
	public BigDecimal getR13_resident_corporate() {
		return r13_resident_corporate;
	}
	public void setR13_resident_corporate(BigDecimal r13_resident_corporate) {
		this.r13_resident_corporate = r13_resident_corporate;
	}
	public BigDecimal getR13_nonresident_corporate() {
		return r13_nonresident_corporate;
	}
	public void setR13_nonresident_corporate(BigDecimal r13_nonresident_corporate) {
		this.r13_nonresident_corporate = r13_nonresident_corporate;
	}
	public BigDecimal getR13_resident_nbfi() {
		return r13_resident_nbfi;
	}
	public void setR13_resident_nbfi(BigDecimal r13_resident_nbfi) {
		this.r13_resident_nbfi = r13_resident_nbfi;
	}
	public BigDecimal getR13_nonresident_nbfi() {
		return r13_nonresident_nbfi;
	}
	public void setR13_nonresident_nbfi(BigDecimal r13_nonresident_nbfi) {
		this.r13_nonresident_nbfi = r13_nonresident_nbfi;
	}
	public BigDecimal getR13_resident_banks() {
		return r13_resident_banks;
	}
	public void setR13_resident_banks(BigDecimal r13_resident_banks) {
		this.r13_resident_banks = r13_resident_banks;
	}
	public BigDecimal getR13_nonresident_banks() {
		return r13_nonresident_banks;
	}
	public void setR13_nonresident_banks(BigDecimal r13_nonresident_banks) {
		this.r13_nonresident_banks = r13_nonresident_banks;
	}
	public BigDecimal getR13_resident_gov_nces() {
		return r13_resident_gov_nces;
	}
	public void setR13_resident_gov_nces(BigDecimal r13_resident_gov_nces) {
		this.r13_resident_gov_nces = r13_resident_gov_nces;
	}
	public BigDecimal getR13_nonresident_gov_nces() {
		return r13_nonresident_gov_nces;
	}
	public void setR13_nonresident_gov_nces(BigDecimal r13_nonresident_gov_nces) {
		this.r13_nonresident_gov_nces = r13_nonresident_gov_nces;
	}
	public String getR14_particulars() {
		return r14_particulars;
	}
	public void setR14_particulars(String r14_particulars) {
		this.r14_particulars = r14_particulars;
	}
	public BigDecimal getR14_resident_individual() {
		return r14_resident_individual;
	}
	public void setR14_resident_individual(BigDecimal r14_resident_individual) {
		this.r14_resident_individual = r14_resident_individual;
	}
	public BigDecimal getR14_nonresident_individual() {
		return r14_nonresident_individual;
	}
	public void setR14_nonresident_individual(BigDecimal r14_nonresident_individual) {
		this.r14_nonresident_individual = r14_nonresident_individual;
	}
	public BigDecimal getR14_resident_retail() {
		return r14_resident_retail;
	}
	public void setR14_resident_retail(BigDecimal r14_resident_retail) {
		this.r14_resident_retail = r14_resident_retail;
	}
	public BigDecimal getR14_nonresident_retail() {
		return r14_nonresident_retail;
	}
	public void setR14_nonresident_retail(BigDecimal r14_nonresident_retail) {
		this.r14_nonresident_retail = r14_nonresident_retail;
	}
	public BigDecimal getR14_resident_sme() {
		return r14_resident_sme;
	}
	public void setR14_resident_sme(BigDecimal r14_resident_sme) {
		this.r14_resident_sme = r14_resident_sme;
	}
	public BigDecimal getR14_nonresident_sme() {
		return r14_nonresident_sme;
	}
	public void setR14_nonresident_sme(BigDecimal r14_nonresident_sme) {
		this.r14_nonresident_sme = r14_nonresident_sme;
	}
	public BigDecimal getR14_resident_hni() {
		return r14_resident_hni;
	}
	public void setR14_resident_hni(BigDecimal r14_resident_hni) {
		this.r14_resident_hni = r14_resident_hni;
	}
	public BigDecimal getR14_nonresident_hni() {
		return r14_nonresident_hni;
	}
	public void setR14_nonresident_hni(BigDecimal r14_nonresident_hni) {
		this.r14_nonresident_hni = r14_nonresident_hni;
	}
	public BigDecimal getR14_resident_gres() {
		return r14_resident_gres;
	}
	public void setR14_resident_gres(BigDecimal r14_resident_gres) {
		this.r14_resident_gres = r14_resident_gres;
	}
	public BigDecimal getR14_nonresident_gres() {
		return r14_nonresident_gres;
	}
	public void setR14_nonresident_gres(BigDecimal r14_nonresident_gres) {
		this.r14_nonresident_gres = r14_nonresident_gres;
	}
	public BigDecimal getR14_resident_corporate() {
		return r14_resident_corporate;
	}
	public void setR14_resident_corporate(BigDecimal r14_resident_corporate) {
		this.r14_resident_corporate = r14_resident_corporate;
	}
	public BigDecimal getR14_nonresident_corporate() {
		return r14_nonresident_corporate;
	}
	public void setR14_nonresident_corporate(BigDecimal r14_nonresident_corporate) {
		this.r14_nonresident_corporate = r14_nonresident_corporate;
	}
	public BigDecimal getR14_resident_nbfi() {
		return r14_resident_nbfi;
	}
	public void setR14_resident_nbfi(BigDecimal r14_resident_nbfi) {
		this.r14_resident_nbfi = r14_resident_nbfi;
	}
	public BigDecimal getR14_nonresident_nbfi() {
		return r14_nonresident_nbfi;
	}
	public void setR14_nonresident_nbfi(BigDecimal r14_nonresident_nbfi) {
		this.r14_nonresident_nbfi = r14_nonresident_nbfi;
	}
	public BigDecimal getR14_resident_banks() {
		return r14_resident_banks;
	}
	public void setR14_resident_banks(BigDecimal r14_resident_banks) {
		this.r14_resident_banks = r14_resident_banks;
	}
	public BigDecimal getR14_nonresident_banks() {
		return r14_nonresident_banks;
	}
	public void setR14_nonresident_banks(BigDecimal r14_nonresident_banks) {
		this.r14_nonresident_banks = r14_nonresident_banks;
	}
	public BigDecimal getR14_resident_gov_nces() {
		return r14_resident_gov_nces;
	}
	public void setR14_resident_gov_nces(BigDecimal r14_resident_gov_nces) {
		this.r14_resident_gov_nces = r14_resident_gov_nces;
	}
	public BigDecimal getR14_nonresident_gov_nces() {
		return r14_nonresident_gov_nces;
	}
	public void setR14_nonresident_gov_nces(BigDecimal r14_nonresident_gov_nces) {
		this.r14_nonresident_gov_nces = r14_nonresident_gov_nces;
	}
	public String getR15_particulars() {
		return r15_particulars;
	}
	public void setR15_particulars(String r15_particulars) {
		this.r15_particulars = r15_particulars;
	}
	public BigDecimal getR15_resident_individual() {
		return r15_resident_individual;
	}
	public void setR15_resident_individual(BigDecimal r15_resident_individual) {
		this.r15_resident_individual = r15_resident_individual;
	}
	public BigDecimal getR15_nonresident_individual() {
		return r15_nonresident_individual;
	}
	public void setR15_nonresident_individual(BigDecimal r15_nonresident_individual) {
		this.r15_nonresident_individual = r15_nonresident_individual;
	}
	public BigDecimal getR15_resident_retail() {
		return r15_resident_retail;
	}
	public void setR15_resident_retail(BigDecimal r15_resident_retail) {
		this.r15_resident_retail = r15_resident_retail;
	}
	public BigDecimal getR15_nonresident_retail() {
		return r15_nonresident_retail;
	}
	public void setR15_nonresident_retail(BigDecimal r15_nonresident_retail) {
		this.r15_nonresident_retail = r15_nonresident_retail;
	}
	public BigDecimal getR15_resident_sme() {
		return r15_resident_sme;
	}
	public void setR15_resident_sme(BigDecimal r15_resident_sme) {
		this.r15_resident_sme = r15_resident_sme;
	}
	public BigDecimal getR15_nonresident_sme() {
		return r15_nonresident_sme;
	}
	public void setR15_nonresident_sme(BigDecimal r15_nonresident_sme) {
		this.r15_nonresident_sme = r15_nonresident_sme;
	}
	public BigDecimal getR15_resident_hni() {
		return r15_resident_hni;
	}
	public void setR15_resident_hni(BigDecimal r15_resident_hni) {
		this.r15_resident_hni = r15_resident_hni;
	}
	public BigDecimal getR15_nonresident_hni() {
		return r15_nonresident_hni;
	}
	public void setR15_nonresident_hni(BigDecimal r15_nonresident_hni) {
		this.r15_nonresident_hni = r15_nonresident_hni;
	}
	public BigDecimal getR15_resident_gres() {
		return r15_resident_gres;
	}
	public void setR15_resident_gres(BigDecimal r15_resident_gres) {
		this.r15_resident_gres = r15_resident_gres;
	}
	public BigDecimal getR15_nonresident_gres() {
		return r15_nonresident_gres;
	}
	public void setR15_nonresident_gres(BigDecimal r15_nonresident_gres) {
		this.r15_nonresident_gres = r15_nonresident_gres;
	}
	public BigDecimal getR15_resident_corporate() {
		return r15_resident_corporate;
	}
	public void setR15_resident_corporate(BigDecimal r15_resident_corporate) {
		this.r15_resident_corporate = r15_resident_corporate;
	}
	public BigDecimal getR15_nonresident_corporate() {
		return r15_nonresident_corporate;
	}
	public void setR15_nonresident_corporate(BigDecimal r15_nonresident_corporate) {
		this.r15_nonresident_corporate = r15_nonresident_corporate;
	}
	public BigDecimal getR15_resident_nbfi() {
		return r15_resident_nbfi;
	}
	public void setR15_resident_nbfi(BigDecimal r15_resident_nbfi) {
		this.r15_resident_nbfi = r15_resident_nbfi;
	}
	public BigDecimal getR15_nonresident_nbfi() {
		return r15_nonresident_nbfi;
	}
	public void setR15_nonresident_nbfi(BigDecimal r15_nonresident_nbfi) {
		this.r15_nonresident_nbfi = r15_nonresident_nbfi;
	}
	public BigDecimal getR15_resident_banks() {
		return r15_resident_banks;
	}
	public void setR15_resident_banks(BigDecimal r15_resident_banks) {
		this.r15_resident_banks = r15_resident_banks;
	}
	public BigDecimal getR15_nonresident_banks() {
		return r15_nonresident_banks;
	}
	public void setR15_nonresident_banks(BigDecimal r15_nonresident_banks) {
		this.r15_nonresident_banks = r15_nonresident_banks;
	}
	public BigDecimal getR15_resident_gov_nces() {
		return r15_resident_gov_nces;
	}
	public void setR15_resident_gov_nces(BigDecimal r15_resident_gov_nces) {
		this.r15_resident_gov_nces = r15_resident_gov_nces;
	}
	public BigDecimal getR15_nonresident_gov_nces() {
		return r15_nonresident_gov_nces;
	}
	public void setR15_nonresident_gov_nces(BigDecimal r15_nonresident_gov_nces) {
		this.r15_nonresident_gov_nces = r15_nonresident_gov_nces;
	}
	public String getR16_particulars() {
		return r16_particulars;
	}
	public void setR16_particulars(String r16_particulars) {
		this.r16_particulars = r16_particulars;
	}
	public BigDecimal getR16_resident_individual() {
		return r16_resident_individual;
	}
	public void setR16_resident_individual(BigDecimal r16_resident_individual) {
		this.r16_resident_individual = r16_resident_individual;
	}
	public BigDecimal getR16_nonresident_individual() {
		return r16_nonresident_individual;
	}
	public void setR16_nonresident_individual(BigDecimal r16_nonresident_individual) {
		this.r16_nonresident_individual = r16_nonresident_individual;
	}
	public BigDecimal getR16_resident_retail() {
		return r16_resident_retail;
	}
	public void setR16_resident_retail(BigDecimal r16_resident_retail) {
		this.r16_resident_retail = r16_resident_retail;
	}
	public BigDecimal getR16_nonresident_retail() {
		return r16_nonresident_retail;
	}
	public void setR16_nonresident_retail(BigDecimal r16_nonresident_retail) {
		this.r16_nonresident_retail = r16_nonresident_retail;
	}
	public BigDecimal getR16_resident_sme() {
		return r16_resident_sme;
	}
	public void setR16_resident_sme(BigDecimal r16_resident_sme) {
		this.r16_resident_sme = r16_resident_sme;
	}
	public BigDecimal getR16_nonresident_sme() {
		return r16_nonresident_sme;
	}
	public void setR16_nonresident_sme(BigDecimal r16_nonresident_sme) {
		this.r16_nonresident_sme = r16_nonresident_sme;
	}
	public BigDecimal getR16_resident_hni() {
		return r16_resident_hni;
	}
	public void setR16_resident_hni(BigDecimal r16_resident_hni) {
		this.r16_resident_hni = r16_resident_hni;
	}
	public BigDecimal getR16_nonresident_hni() {
		return r16_nonresident_hni;
	}
	public void setR16_nonresident_hni(BigDecimal r16_nonresident_hni) {
		this.r16_nonresident_hni = r16_nonresident_hni;
	}
	public BigDecimal getR16_resident_gres() {
		return r16_resident_gres;
	}
	public void setR16_resident_gres(BigDecimal r16_resident_gres) {
		this.r16_resident_gres = r16_resident_gres;
	}
	public BigDecimal getR16_nonresident_gres() {
		return r16_nonresident_gres;
	}
	public void setR16_nonresident_gres(BigDecimal r16_nonresident_gres) {
		this.r16_nonresident_gres = r16_nonresident_gres;
	}
	public BigDecimal getR16_resident_corporate() {
		return r16_resident_corporate;
	}
	public void setR16_resident_corporate(BigDecimal r16_resident_corporate) {
		this.r16_resident_corporate = r16_resident_corporate;
	}
	public BigDecimal getR16_nonresident_corporate() {
		return r16_nonresident_corporate;
	}
	public void setR16_nonresident_corporate(BigDecimal r16_nonresident_corporate) {
		this.r16_nonresident_corporate = r16_nonresident_corporate;
	}
	public BigDecimal getR16_resident_nbfi() {
		return r16_resident_nbfi;
	}
	public void setR16_resident_nbfi(BigDecimal r16_resident_nbfi) {
		this.r16_resident_nbfi = r16_resident_nbfi;
	}
	public BigDecimal getR16_nonresident_nbfi() {
		return r16_nonresident_nbfi;
	}
	public void setR16_nonresident_nbfi(BigDecimal r16_nonresident_nbfi) {
		this.r16_nonresident_nbfi = r16_nonresident_nbfi;
	}
	public BigDecimal getR16_resident_banks() {
		return r16_resident_banks;
	}
	public void setR16_resident_banks(BigDecimal r16_resident_banks) {
		this.r16_resident_banks = r16_resident_banks;
	}
	public BigDecimal getR16_nonresident_banks() {
		return r16_nonresident_banks;
	}
	public void setR16_nonresident_banks(BigDecimal r16_nonresident_banks) {
		this.r16_nonresident_banks = r16_nonresident_banks;
	}
	public BigDecimal getR16_resident_gov_nces() {
		return r16_resident_gov_nces;
	}
	public void setR16_resident_gov_nces(BigDecimal r16_resident_gov_nces) {
		this.r16_resident_gov_nces = r16_resident_gov_nces;
	}
	public BigDecimal getR16_nonresident_gov_nces() {
		return r16_nonresident_gov_nces;
	}
	public void setR16_nonresident_gov_nces(BigDecimal r16_nonresident_gov_nces) {
		this.r16_nonresident_gov_nces = r16_nonresident_gov_nces;
	}
	public String getR17_particulars() {
		return r17_particulars;
	}
	public void setR17_particulars(String r17_particulars) {
		this.r17_particulars = r17_particulars;
	}
	public BigDecimal getR17_resident_individual() {
		return r17_resident_individual;
	}
	public void setR17_resident_individual(BigDecimal r17_resident_individual) {
		this.r17_resident_individual = r17_resident_individual;
	}
	public BigDecimal getR17_nonresident_individual() {
		return r17_nonresident_individual;
	}
	public void setR17_nonresident_individual(BigDecimal r17_nonresident_individual) {
		this.r17_nonresident_individual = r17_nonresident_individual;
	}
	public BigDecimal getR17_resident_retail() {
		return r17_resident_retail;
	}
	public void setR17_resident_retail(BigDecimal r17_resident_retail) {
		this.r17_resident_retail = r17_resident_retail;
	}
	public BigDecimal getR17_nonresident_retail() {
		return r17_nonresident_retail;
	}
	public void setR17_nonresident_retail(BigDecimal r17_nonresident_retail) {
		this.r17_nonresident_retail = r17_nonresident_retail;
	}
	public BigDecimal getR17_resident_sme() {
		return r17_resident_sme;
	}
	public void setR17_resident_sme(BigDecimal r17_resident_sme) {
		this.r17_resident_sme = r17_resident_sme;
	}
	public BigDecimal getR17_nonresident_sme() {
		return r17_nonresident_sme;
	}
	public void setR17_nonresident_sme(BigDecimal r17_nonresident_sme) {
		this.r17_nonresident_sme = r17_nonresident_sme;
	}
	public BigDecimal getR17_resident_hni() {
		return r17_resident_hni;
	}
	public void setR17_resident_hni(BigDecimal r17_resident_hni) {
		this.r17_resident_hni = r17_resident_hni;
	}
	public BigDecimal getR17_nonresident_hni() {
		return r17_nonresident_hni;
	}
	public void setR17_nonresident_hni(BigDecimal r17_nonresident_hni) {
		this.r17_nonresident_hni = r17_nonresident_hni;
	}
	public BigDecimal getR17_resident_gres() {
		return r17_resident_gres;
	}
	public void setR17_resident_gres(BigDecimal r17_resident_gres) {
		this.r17_resident_gres = r17_resident_gres;
	}
	public BigDecimal getR17_nonresident_gres() {
		return r17_nonresident_gres;
	}
	public void setR17_nonresident_gres(BigDecimal r17_nonresident_gres) {
		this.r17_nonresident_gres = r17_nonresident_gres;
	}
	public BigDecimal getR17_resident_corporate() {
		return r17_resident_corporate;
	}
	public void setR17_resident_corporate(BigDecimal r17_resident_corporate) {
		this.r17_resident_corporate = r17_resident_corporate;
	}
	public BigDecimal getR17_nonresident_corporate() {
		return r17_nonresident_corporate;
	}
	public void setR17_nonresident_corporate(BigDecimal r17_nonresident_corporate) {
		this.r17_nonresident_corporate = r17_nonresident_corporate;
	}
	public BigDecimal getR17_resident_nbfi() {
		return r17_resident_nbfi;
	}
	public void setR17_resident_nbfi(BigDecimal r17_resident_nbfi) {
		this.r17_resident_nbfi = r17_resident_nbfi;
	}
	public BigDecimal getR17_nonresident_nbfi() {
		return r17_nonresident_nbfi;
	}
	public void setR17_nonresident_nbfi(BigDecimal r17_nonresident_nbfi) {
		this.r17_nonresident_nbfi = r17_nonresident_nbfi;
	}
	public BigDecimal getR17_resident_banks() {
		return r17_resident_banks;
	}
	public void setR17_resident_banks(BigDecimal r17_resident_banks) {
		this.r17_resident_banks = r17_resident_banks;
	}
	public BigDecimal getR17_nonresident_banks() {
		return r17_nonresident_banks;
	}
	public void setR17_nonresident_banks(BigDecimal r17_nonresident_banks) {
		this.r17_nonresident_banks = r17_nonresident_banks;
	}
	public BigDecimal getR17_resident_gov_nces() {
		return r17_resident_gov_nces;
	}
	public void setR17_resident_gov_nces(BigDecimal r17_resident_gov_nces) {
		this.r17_resident_gov_nces = r17_resident_gov_nces;
	}
	public BigDecimal getR17_nonresident_gov_nces() {
		return r17_nonresident_gov_nces;
	}
	public void setR17_nonresident_gov_nces(BigDecimal r17_nonresident_gov_nces) {
		this.r17_nonresident_gov_nces = r17_nonresident_gov_nces;
	}
	public String getR18_particulars() {
		return r18_particulars;
	}
	public void setR18_particulars(String r18_particulars) {
		this.r18_particulars = r18_particulars;
	}
	public BigDecimal getR18_resident_individual() {
		return r18_resident_individual;
	}
	public void setR18_resident_individual(BigDecimal r18_resident_individual) {
		this.r18_resident_individual = r18_resident_individual;
	}
	public BigDecimal getR18_nonresident_individual() {
		return r18_nonresident_individual;
	}
	public void setR18_nonresident_individual(BigDecimal r18_nonresident_individual) {
		this.r18_nonresident_individual = r18_nonresident_individual;
	}
	public BigDecimal getR18_resident_retail() {
		return r18_resident_retail;
	}
	public void setR18_resident_retail(BigDecimal r18_resident_retail) {
		this.r18_resident_retail = r18_resident_retail;
	}
	public BigDecimal getR18_nonresident_retail() {
		return r18_nonresident_retail;
	}
	public void setR18_nonresident_retail(BigDecimal r18_nonresident_retail) {
		this.r18_nonresident_retail = r18_nonresident_retail;
	}
	public BigDecimal getR18_resident_sme() {
		return r18_resident_sme;
	}
	public void setR18_resident_sme(BigDecimal r18_resident_sme) {
		this.r18_resident_sme = r18_resident_sme;
	}
	public BigDecimal getR18_nonresident_sme() {
		return r18_nonresident_sme;
	}
	public void setR18_nonresident_sme(BigDecimal r18_nonresident_sme) {
		this.r18_nonresident_sme = r18_nonresident_sme;
	}
	public BigDecimal getR18_resident_hni() {
		return r18_resident_hni;
	}
	public void setR18_resident_hni(BigDecimal r18_resident_hni) {
		this.r18_resident_hni = r18_resident_hni;
	}
	public BigDecimal getR18_nonresident_hni() {
		return r18_nonresident_hni;
	}
	public void setR18_nonresident_hni(BigDecimal r18_nonresident_hni) {
		this.r18_nonresident_hni = r18_nonresident_hni;
	}
	public BigDecimal getR18_resident_gres() {
		return r18_resident_gres;
	}
	public void setR18_resident_gres(BigDecimal r18_resident_gres) {
		this.r18_resident_gres = r18_resident_gres;
	}
	public BigDecimal getR18_nonresident_gres() {
		return r18_nonresident_gres;
	}
	public void setR18_nonresident_gres(BigDecimal r18_nonresident_gres) {
		this.r18_nonresident_gres = r18_nonresident_gres;
	}
	public BigDecimal getR18_resident_corporate() {
		return r18_resident_corporate;
	}
	public void setR18_resident_corporate(BigDecimal r18_resident_corporate) {
		this.r18_resident_corporate = r18_resident_corporate;
	}
	public BigDecimal getR18_nonresident_corporate() {
		return r18_nonresident_corporate;
	}
	public void setR18_nonresident_corporate(BigDecimal r18_nonresident_corporate) {
		this.r18_nonresident_corporate = r18_nonresident_corporate;
	}
	public BigDecimal getR18_resident_nbfi() {
		return r18_resident_nbfi;
	}
	public void setR18_resident_nbfi(BigDecimal r18_resident_nbfi) {
		this.r18_resident_nbfi = r18_resident_nbfi;
	}
	public BigDecimal getR18_nonresident_nbfi() {
		return r18_nonresident_nbfi;
	}
	public void setR18_nonresident_nbfi(BigDecimal r18_nonresident_nbfi) {
		this.r18_nonresident_nbfi = r18_nonresident_nbfi;
	}
	public BigDecimal getR18_resident_banks() {
		return r18_resident_banks;
	}
	public void setR18_resident_banks(BigDecimal r18_resident_banks) {
		this.r18_resident_banks = r18_resident_banks;
	}
	public BigDecimal getR18_nonresident_banks() {
		return r18_nonresident_banks;
	}
	public void setR18_nonresident_banks(BigDecimal r18_nonresident_banks) {
		this.r18_nonresident_banks = r18_nonresident_banks;
	}
	public BigDecimal getR18_resident_gov_nces() {
		return r18_resident_gov_nces;
	}
	public void setR18_resident_gov_nces(BigDecimal r18_resident_gov_nces) {
		this.r18_resident_gov_nces = r18_resident_gov_nces;
	}
	public BigDecimal getR18_nonresident_gov_nces() {
		return r18_nonresident_gov_nces;
	}
	public void setR18_nonresident_gov_nces(BigDecimal r18_nonresident_gov_nces) {
		this.r18_nonresident_gov_nces = r18_nonresident_gov_nces;
	}
	public String getR19_particulars() {
		return r19_particulars;
	}
	public void setR19_particulars(String r19_particulars) {
		this.r19_particulars = r19_particulars;
	}
	public BigDecimal getR19_resident_individual() {
		return r19_resident_individual;
	}
	public void setR19_resident_individual(BigDecimal r19_resident_individual) {
		this.r19_resident_individual = r19_resident_individual;
	}
	public BigDecimal getR19_nonresident_individual() {
		return r19_nonresident_individual;
	}
	public void setR19_nonresident_individual(BigDecimal r19_nonresident_individual) {
		this.r19_nonresident_individual = r19_nonresident_individual;
	}
	public BigDecimal getR19_resident_retail() {
		return r19_resident_retail;
	}
	public void setR19_resident_retail(BigDecimal r19_resident_retail) {
		this.r19_resident_retail = r19_resident_retail;
	}
	public BigDecimal getR19_nonresident_retail() {
		return r19_nonresident_retail;
	}
	public void setR19_nonresident_retail(BigDecimal r19_nonresident_retail) {
		this.r19_nonresident_retail = r19_nonresident_retail;
	}
	public BigDecimal getR19_resident_sme() {
		return r19_resident_sme;
	}
	public void setR19_resident_sme(BigDecimal r19_resident_sme) {
		this.r19_resident_sme = r19_resident_sme;
	}
	public BigDecimal getR19_nonresident_sme() {
		return r19_nonresident_sme;
	}
	public void setR19_nonresident_sme(BigDecimal r19_nonresident_sme) {
		this.r19_nonresident_sme = r19_nonresident_sme;
	}
	public BigDecimal getR19_resident_hni() {
		return r19_resident_hni;
	}
	public void setR19_resident_hni(BigDecimal r19_resident_hni) {
		this.r19_resident_hni = r19_resident_hni;
	}
	public BigDecimal getR19_nonresident_hni() {
		return r19_nonresident_hni;
	}
	public void setR19_nonresident_hni(BigDecimal r19_nonresident_hni) {
		this.r19_nonresident_hni = r19_nonresident_hni;
	}
	public BigDecimal getR19_resident_gres() {
		return r19_resident_gres;
	}
	public void setR19_resident_gres(BigDecimal r19_resident_gres) {
		this.r19_resident_gres = r19_resident_gres;
	}
	public BigDecimal getR19_nonresident_gres() {
		return r19_nonresident_gres;
	}
	public void setR19_nonresident_gres(BigDecimal r19_nonresident_gres) {
		this.r19_nonresident_gres = r19_nonresident_gres;
	}
	public BigDecimal getR19_resident_corporate() {
		return r19_resident_corporate;
	}
	public void setR19_resident_corporate(BigDecimal r19_resident_corporate) {
		this.r19_resident_corporate = r19_resident_corporate;
	}
	public BigDecimal getR19_nonresident_corporate() {
		return r19_nonresident_corporate;
	}
	public void setR19_nonresident_corporate(BigDecimal r19_nonresident_corporate) {
		this.r19_nonresident_corporate = r19_nonresident_corporate;
	}
	public BigDecimal getR19_resident_nbfi() {
		return r19_resident_nbfi;
	}
	public void setR19_resident_nbfi(BigDecimal r19_resident_nbfi) {
		this.r19_resident_nbfi = r19_resident_nbfi;
	}
	public BigDecimal getR19_nonresident_nbfi() {
		return r19_nonresident_nbfi;
	}
	public void setR19_nonresident_nbfi(BigDecimal r19_nonresident_nbfi) {
		this.r19_nonresident_nbfi = r19_nonresident_nbfi;
	}
	public BigDecimal getR19_resident_banks() {
		return r19_resident_banks;
	}
	public void setR19_resident_banks(BigDecimal r19_resident_banks) {
		this.r19_resident_banks = r19_resident_banks;
	}
	public BigDecimal getR19_nonresident_banks() {
		return r19_nonresident_banks;
	}
	public void setR19_nonresident_banks(BigDecimal r19_nonresident_banks) {
		this.r19_nonresident_banks = r19_nonresident_banks;
	}
	public BigDecimal getR19_resident_gov_nces() {
		return r19_resident_gov_nces;
	}
	public void setR19_resident_gov_nces(BigDecimal r19_resident_gov_nces) {
		this.r19_resident_gov_nces = r19_resident_gov_nces;
	}
	public BigDecimal getR19_nonresident_gov_nces() {
		return r19_nonresident_gov_nces;
	}
	public void setR19_nonresident_gov_nces(BigDecimal r19_nonresident_gov_nces) {
		this.r19_nonresident_gov_nces = r19_nonresident_gov_nces;
	}
	public String getR20_particulars() {
		return r20_particulars;
	}
	public void setR20_particulars(String r20_particulars) {
		this.r20_particulars = r20_particulars;
	}
	public BigDecimal getR20_resident_individual() {
		return r20_resident_individual;
	}
	public void setR20_resident_individual(BigDecimal r20_resident_individual) {
		this.r20_resident_individual = r20_resident_individual;
	}
	public BigDecimal getR20_nonresident_individual() {
		return r20_nonresident_individual;
	}
	public void setR20_nonresident_individual(BigDecimal r20_nonresident_individual) {
		this.r20_nonresident_individual = r20_nonresident_individual;
	}
	public BigDecimal getR20_resident_retail() {
		return r20_resident_retail;
	}
	public void setR20_resident_retail(BigDecimal r20_resident_retail) {
		this.r20_resident_retail = r20_resident_retail;
	}
	public BigDecimal getR20_nonresident_retail() {
		return r20_nonresident_retail;
	}
	public void setR20_nonresident_retail(BigDecimal r20_nonresident_retail) {
		this.r20_nonresident_retail = r20_nonresident_retail;
	}
	public BigDecimal getR20_resident_sme() {
		return r20_resident_sme;
	}
	public void setR20_resident_sme(BigDecimal r20_resident_sme) {
		this.r20_resident_sme = r20_resident_sme;
	}
	public BigDecimal getR20_nonresident_sme() {
		return r20_nonresident_sme;
	}
	public void setR20_nonresident_sme(BigDecimal r20_nonresident_sme) {
		this.r20_nonresident_sme = r20_nonresident_sme;
	}
	public BigDecimal getR20_resident_hni() {
		return r20_resident_hni;
	}
	public void setR20_resident_hni(BigDecimal r20_resident_hni) {
		this.r20_resident_hni = r20_resident_hni;
	}
	public BigDecimal getR20_nonresident_hni() {
		return r20_nonresident_hni;
	}
	public void setR20_nonresident_hni(BigDecimal r20_nonresident_hni) {
		this.r20_nonresident_hni = r20_nonresident_hni;
	}
	public BigDecimal getR20_resident_gres() {
		return r20_resident_gres;
	}
	public void setR20_resident_gres(BigDecimal r20_resident_gres) {
		this.r20_resident_gres = r20_resident_gres;
	}
	public BigDecimal getR20_nonresident_gres() {
		return r20_nonresident_gres;
	}
	public void setR20_nonresident_gres(BigDecimal r20_nonresident_gres) {
		this.r20_nonresident_gres = r20_nonresident_gres;
	}
	public BigDecimal getR20_resident_corporate() {
		return r20_resident_corporate;
	}
	public void setR20_resident_corporate(BigDecimal r20_resident_corporate) {
		this.r20_resident_corporate = r20_resident_corporate;
	}
	public BigDecimal getR20_nonresident_corporate() {
		return r20_nonresident_corporate;
	}
	public void setR20_nonresident_corporate(BigDecimal r20_nonresident_corporate) {
		this.r20_nonresident_corporate = r20_nonresident_corporate;
	}
	public BigDecimal getR20_resident_nbfi() {
		return r20_resident_nbfi;
	}
	public void setR20_resident_nbfi(BigDecimal r20_resident_nbfi) {
		this.r20_resident_nbfi = r20_resident_nbfi;
	}
	public BigDecimal getR20_nonresident_nbfi() {
		return r20_nonresident_nbfi;
	}
	public void setR20_nonresident_nbfi(BigDecimal r20_nonresident_nbfi) {
		this.r20_nonresident_nbfi = r20_nonresident_nbfi;
	}
	public BigDecimal getR20_resident_banks() {
		return r20_resident_banks;
	}
	public void setR20_resident_banks(BigDecimal r20_resident_banks) {
		this.r20_resident_banks = r20_resident_banks;
	}
	public BigDecimal getR20_nonresident_banks() {
		return r20_nonresident_banks;
	}
	public void setR20_nonresident_banks(BigDecimal r20_nonresident_banks) {
		this.r20_nonresident_banks = r20_nonresident_banks;
	}
	public BigDecimal getR20_resident_gov_nces() {
		return r20_resident_gov_nces;
	}
	public void setR20_resident_gov_nces(BigDecimal r20_resident_gov_nces) {
		this.r20_resident_gov_nces = r20_resident_gov_nces;
	}
	public BigDecimal getR20_nonresident_gov_nces() {
		return r20_nonresident_gov_nces;
	}
	public void setR20_nonresident_gov_nces(BigDecimal r20_nonresident_gov_nces) {
		this.r20_nonresident_gov_nces = r20_nonresident_gov_nces;
	}
	public String getR21_particulars() {
		return r21_particulars;
	}
	public void setR21_particulars(String r21_particulars) {
		this.r21_particulars = r21_particulars;
	}
	public BigDecimal getR21_resident_individual() {
		return r21_resident_individual;
	}
	public void setR21_resident_individual(BigDecimal r21_resident_individual) {
		this.r21_resident_individual = r21_resident_individual;
	}
	public BigDecimal getR21_nonresident_individual() {
		return r21_nonresident_individual;
	}
	public void setR21_nonresident_individual(BigDecimal r21_nonresident_individual) {
		this.r21_nonresident_individual = r21_nonresident_individual;
	}
	public BigDecimal getR21_resident_retail() {
		return r21_resident_retail;
	}
	public void setR21_resident_retail(BigDecimal r21_resident_retail) {
		this.r21_resident_retail = r21_resident_retail;
	}
	public BigDecimal getR21_nonresident_retail() {
		return r21_nonresident_retail;
	}
	public void setR21_nonresident_retail(BigDecimal r21_nonresident_retail) {
		this.r21_nonresident_retail = r21_nonresident_retail;
	}
	public BigDecimal getR21_resident_sme() {
		return r21_resident_sme;
	}
	public void setR21_resident_sme(BigDecimal r21_resident_sme) {
		this.r21_resident_sme = r21_resident_sme;
	}
	public BigDecimal getR21_nonresident_sme() {
		return r21_nonresident_sme;
	}
	public void setR21_nonresident_sme(BigDecimal r21_nonresident_sme) {
		this.r21_nonresident_sme = r21_nonresident_sme;
	}
	public BigDecimal getR21_resident_hni() {
		return r21_resident_hni;
	}
	public void setR21_resident_hni(BigDecimal r21_resident_hni) {
		this.r21_resident_hni = r21_resident_hni;
	}
	public BigDecimal getR21_nonresident_hni() {
		return r21_nonresident_hni;
	}
	public void setR21_nonresident_hni(BigDecimal r21_nonresident_hni) {
		this.r21_nonresident_hni = r21_nonresident_hni;
	}
	public BigDecimal getR21_resident_gres() {
		return r21_resident_gres;
	}
	public void setR21_resident_gres(BigDecimal r21_resident_gres) {
		this.r21_resident_gres = r21_resident_gres;
	}
	public BigDecimal getR21_nonresident_gres() {
		return r21_nonresident_gres;
	}
	public void setR21_nonresident_gres(BigDecimal r21_nonresident_gres) {
		this.r21_nonresident_gres = r21_nonresident_gres;
	}
	public BigDecimal getR21_resident_corporate() {
		return r21_resident_corporate;
	}
	public void setR21_resident_corporate(BigDecimal r21_resident_corporate) {
		this.r21_resident_corporate = r21_resident_corporate;
	}
	public BigDecimal getR21_nonresident_corporate() {
		return r21_nonresident_corporate;
	}
	public void setR21_nonresident_corporate(BigDecimal r21_nonresident_corporate) {
		this.r21_nonresident_corporate = r21_nonresident_corporate;
	}
	public BigDecimal getR21_resident_nbfi() {
		return r21_resident_nbfi;
	}
	public void setR21_resident_nbfi(BigDecimal r21_resident_nbfi) {
		this.r21_resident_nbfi = r21_resident_nbfi;
	}
	public BigDecimal getR21_nonresident_nbfi() {
		return r21_nonresident_nbfi;
	}
	public void setR21_nonresident_nbfi(BigDecimal r21_nonresident_nbfi) {
		this.r21_nonresident_nbfi = r21_nonresident_nbfi;
	}
	public BigDecimal getR21_resident_banks() {
		return r21_resident_banks;
	}
	public void setR21_resident_banks(BigDecimal r21_resident_banks) {
		this.r21_resident_banks = r21_resident_banks;
	}
	public BigDecimal getR21_nonresident_banks() {
		return r21_nonresident_banks;
	}
	public void setR21_nonresident_banks(BigDecimal r21_nonresident_banks) {
		this.r21_nonresident_banks = r21_nonresident_banks;
	}
	public BigDecimal getR21_resident_gov_nces() {
		return r21_resident_gov_nces;
	}
	public void setR21_resident_gov_nces(BigDecimal r21_resident_gov_nces) {
		this.r21_resident_gov_nces = r21_resident_gov_nces;
	}
	public BigDecimal getR21_nonresident_gov_nces() {
		return r21_nonresident_gov_nces;
	}
	public void setR21_nonresident_gov_nces(BigDecimal r21_nonresident_gov_nces) {
		this.r21_nonresident_gov_nces = r21_nonresident_gov_nces;
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
	public BRF151reportentity() {
		super();
		// TODO Auto-generated constructor stub
	}
}