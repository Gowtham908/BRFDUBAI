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
@Table(name = "BRF50_SUMMARYTABLE")
public class BRF50_Entity {

	private String r9_product;
	private BigDecimal r9_amount_outstainding;
	private BigDecimal r9_interest_expense;
	private String r10_product;
	private BigDecimal r10_amount_outstainding;
	private BigDecimal r10_interest_expense;
	private String r11_product;
	private BigDecimal r11_amount_outstainding;
	private BigDecimal r11_interest_expense;
	private String r12_product;
	private BigDecimal r12_amount_outstainding;
	private BigDecimal r12_interest_expense;
	private String r13_product;
	private BigDecimal r13_amount_outstainding;
	private BigDecimal r13_interest_expense;
	private String r14_product;
	private BigDecimal r14_amount_outstainding;
	private BigDecimal r14_interest_expense;
	private String r15_product;
	private BigDecimal r15_amount_outstainding;
	private BigDecimal r15_interest_expense;
	private String r16_product;
	private BigDecimal r16_amount_outstainding;
	private BigDecimal r16_interest_expense;
	private String r17_product;
	private BigDecimal r17_amount_outstainding;
	private BigDecimal r17_interest_expense;
	private String r18_product;
	private BigDecimal r18_amount_outstainding;
	private BigDecimal r18_interest_expense;
	private String r19_product;
	private BigDecimal r19_amount_outstainding;
	private BigDecimal r19_interest_expense;
	private String r20_product;
	private BigDecimal r20_amount_outstainding;
	private BigDecimal r20_interest_expense;
	private String r21_product;
	private BigDecimal r21_amount_outstainding;
	private BigDecimal r21_interest_expense;
	private String r22_product;
	private BigDecimal r22_amount_outstainding;
	private BigDecimal r22_interest_expense;
	private String r23_product;
	private BigDecimal r23_amount_outstainding;
	private BigDecimal r23_interest_expense;
	private String r24_product;
	private BigDecimal r24_amount_outstainding;
	private BigDecimal r24_interest_expense;
	private String r25_product;
	private BigDecimal r25_amount_outstainding;
	private BigDecimal r25_interest_expense;
	private String r26_product;
	private BigDecimal r26_amount_outstainding;
	private BigDecimal r26_interest_expense;
	private String r27_product;
	private BigDecimal r27_amount_outstainding;
	private BigDecimal r27_interest_expense;
	private String r28_product;
	private BigDecimal r28_amount_outstainding;
	private BigDecimal r28_interest_expense;
	private String r29_product;
	private BigDecimal r29_amount_outstainding;
	private BigDecimal r29_interest_expense;
	private String r30_product;
	private BigDecimal r30_amount_outstainding;
	private BigDecimal r30_interest_expense;
	private String r31_product;
	private BigDecimal r31_amount_outstainding;
	private BigDecimal r31_interest_expense;
	private String r32_product;
	private BigDecimal r32_amount_outstainding;
	private BigDecimal r32_interest_expense;
	private String r33_product;
	private BigDecimal r33_amount_outstainding;
	private BigDecimal r33_interest_expense;
	private String r34_product;
	private BigDecimal r34_amount_outstainding;
	private BigDecimal r34_interest_expense;
	private String r35_product;
	private BigDecimal r35_amount_outstainding;
	private BigDecimal r35_interest_expense;
	private String r36_product;
	private BigDecimal r36_amount_outstainding;
	private BigDecimal r36_interest_expense;
	private String r37_product;
	private BigDecimal r37_amount_outstainding;
	private BigDecimal r37_interest_expense;
	private String r38_product;
	private BigDecimal r38_amount_outstainding;
	private BigDecimal r38_interest_expense;
	private String r39_product;
	private BigDecimal r39_amount_outstainding;
	private BigDecimal r39_interest_expense;
	private String r40_product;
	private BigDecimal r40_amount_outstainding;
	private BigDecimal r40_interest_expense;
	private String r41_product;
	private BigDecimal r41_amount_outstainding;
	private BigDecimal r41_interest_expense;
	private String r42_product;
	private BigDecimal r42_amount_outstainding;
	private BigDecimal r42_interest_expense;
	private String r43_product;
	private BigDecimal r43_amount_outstainding;
	private BigDecimal r43_interest_expense;
	private String r44_product;
	private BigDecimal r44_amount_outstainding;
	private BigDecimal r44_interest_expense;
	private String r45_product;
	private BigDecimal r45_amount_outstainding;
	private BigDecimal r45_interest_expense;
	private String r46_product;
	private BigDecimal r46_amount_outstainding;
	private BigDecimal r46_interest_expense;
	private String r47_product;
	private BigDecimal r47_amount_outstainding;
	private BigDecimal r47_interest_expense;
	private String r48_product;
	private BigDecimal r48_amount_outstainding;
	private BigDecimal r48_interest_expense;
	private String r49_product;
	private BigDecimal r49_amount_outstainding;
	private BigDecimal r49_interest_expense;
	private String r50_product;
	private BigDecimal r50_amount_outstainding;
	private BigDecimal r50_interest_expense;
	private String r51_product;
	private BigDecimal r51_amount_outstainding;
	private BigDecimal r51_interest_expense;
	private String r52_product;
	private BigDecimal r52_amount_outstainding;
	private BigDecimal r52_interest_expense;
	private String r53_product;
	private BigDecimal r53_amount_outstainding;
	private BigDecimal r53_interest_expense;

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
	private String	repdesc;
	private String	frequency;
	public String getR9_product() {
		return r9_product;
	}
	public void setR9_product(String r9_product) {
		this.r9_product = r9_product;
	}
	public BigDecimal getR9_amount_outstainding() {
		return r9_amount_outstainding;
	}
	public void setR9_amount_outstainding(BigDecimal r9_amount_outstainding) {
		this.r9_amount_outstainding = r9_amount_outstainding;
	}
	public BigDecimal getR9_interest_expense() {
		return r9_interest_expense;
	}
	public void setR9_interest_expense(BigDecimal r9_interest_expense) {
		this.r9_interest_expense = r9_interest_expense;
	}
	public String getR10_product() {
		return r10_product;
	}
	public void setR10_product(String r10_product) {
		this.r10_product = r10_product;
	}
	public BigDecimal getR10_amount_outstainding() {
		return r10_amount_outstainding;
	}
	public void setR10_amount_outstainding(BigDecimal r10_amount_outstainding) {
		this.r10_amount_outstainding = r10_amount_outstainding;
	}
	public BigDecimal getR10_interest_expense() {
		return r10_interest_expense;
	}
	public void setR10_interest_expense(BigDecimal r10_interest_expense) {
		this.r10_interest_expense = r10_interest_expense;
	}
	public String getR11_product() {
		return r11_product;
	}
	public void setR11_product(String r11_product) {
		this.r11_product = r11_product;
	}
	public BigDecimal getR11_amount_outstainding() {
		return r11_amount_outstainding;
	}
	public void setR11_amount_outstainding(BigDecimal r11_amount_outstainding) {
		this.r11_amount_outstainding = r11_amount_outstainding;
	}
	public BigDecimal getR11_interest_expense() {
		return r11_interest_expense;
	}
	public void setR11_interest_expense(BigDecimal r11_interest_expense) {
		this.r11_interest_expense = r11_interest_expense;
	}
	public String getR12_product() {
		return r12_product;
	}
	public void setR12_product(String r12_product) {
		this.r12_product = r12_product;
	}
	public BigDecimal getR12_amount_outstainding() {
		return r12_amount_outstainding;
	}
	public void setR12_amount_outstainding(BigDecimal r12_amount_outstainding) {
		this.r12_amount_outstainding = r12_amount_outstainding;
	}
	public BigDecimal getR12_interest_expense() {
		return r12_interest_expense;
	}
	public void setR12_interest_expense(BigDecimal r12_interest_expense) {
		this.r12_interest_expense = r12_interest_expense;
	}
	public String getR13_product() {
		return r13_product;
	}
	public void setR13_product(String r13_product) {
		this.r13_product = r13_product;
	}
	public BigDecimal getR13_amount_outstainding() {
		return r13_amount_outstainding;
	}
	public void setR13_amount_outstainding(BigDecimal r13_amount_outstainding) {
		this.r13_amount_outstainding = r13_amount_outstainding;
	}
	public BigDecimal getR13_interest_expense() {
		return r13_interest_expense;
	}
	public void setR13_interest_expense(BigDecimal r13_interest_expense) {
		this.r13_interest_expense = r13_interest_expense;
	}
	public String getR14_product() {
		return r14_product;
	}
	public void setR14_product(String r14_product) {
		this.r14_product = r14_product;
	}
	public BigDecimal getR14_amount_outstainding() {
		return r14_amount_outstainding;
	}
	public void setR14_amount_outstainding(BigDecimal r14_amount_outstainding) {
		this.r14_amount_outstainding = r14_amount_outstainding;
	}
	public BigDecimal getR14_interest_expense() {
		return r14_interest_expense;
	}
	public void setR14_interest_expense(BigDecimal r14_interest_expense) {
		this.r14_interest_expense = r14_interest_expense;
	}
	public String getR15_product() {
		return r15_product;
	}
	public void setR15_product(String r15_product) {
		this.r15_product = r15_product;
	}
	public BigDecimal getR15_amount_outstainding() {
		return r15_amount_outstainding;
	}
	public void setR15_amount_outstainding(BigDecimal r15_amount_outstainding) {
		this.r15_amount_outstainding = r15_amount_outstainding;
	}
	public BigDecimal getR15_interest_expense() {
		return r15_interest_expense;
	}
	public void setR15_interest_expense(BigDecimal r15_interest_expense) {
		this.r15_interest_expense = r15_interest_expense;
	}
	public String getR16_product() {
		return r16_product;
	}
	public void setR16_product(String r16_product) {
		this.r16_product = r16_product;
	}
	public BigDecimal getR16_amount_outstainding() {
		return r16_amount_outstainding;
	}
	public void setR16_amount_outstainding(BigDecimal r16_amount_outstainding) {
		this.r16_amount_outstainding = r16_amount_outstainding;
	}
	public BigDecimal getR16_interest_expense() {
		return r16_interest_expense;
	}
	public void setR16_interest_expense(BigDecimal r16_interest_expense) {
		this.r16_interest_expense = r16_interest_expense;
	}
	public String getR17_product() {
		return r17_product;
	}
	public void setR17_product(String r17_product) {
		this.r17_product = r17_product;
	}
	public BigDecimal getR17_amount_outstainding() {
		return r17_amount_outstainding;
	}
	public void setR17_amount_outstainding(BigDecimal r17_amount_outstainding) {
		this.r17_amount_outstainding = r17_amount_outstainding;
	}
	public BigDecimal getR17_interest_expense() {
		return r17_interest_expense;
	}
	public void setR17_interest_expense(BigDecimal r17_interest_expense) {
		this.r17_interest_expense = r17_interest_expense;
	}
	public String getR18_product() {
		return r18_product;
	}
	public void setR18_product(String r18_product) {
		this.r18_product = r18_product;
	}
	public BigDecimal getR18_amount_outstainding() {
		return r18_amount_outstainding;
	}
	public void setR18_amount_outstainding(BigDecimal r18_amount_outstainding) {
		this.r18_amount_outstainding = r18_amount_outstainding;
	}
	public BigDecimal getR18_interest_expense() {
		return r18_interest_expense;
	}
	public void setR18_interest_expense(BigDecimal r18_interest_expense) {
		this.r18_interest_expense = r18_interest_expense;
	}
	public String getR19_product() {
		return r19_product;
	}
	public void setR19_product(String r19_product) {
		this.r19_product = r19_product;
	}
	public BigDecimal getR19_amount_outstainding() {
		return r19_amount_outstainding;
	}
	public void setR19_amount_outstainding(BigDecimal r19_amount_outstainding) {
		this.r19_amount_outstainding = r19_amount_outstainding;
	}
	public BigDecimal getR19_interest_expense() {
		return r19_interest_expense;
	}
	public void setR19_interest_expense(BigDecimal r19_interest_expense) {
		this.r19_interest_expense = r19_interest_expense;
	}
	public String getR20_product() {
		return r20_product;
	}
	public void setR20_product(String r20_product) {
		this.r20_product = r20_product;
	}
	public BigDecimal getR20_amount_outstainding() {
		return r20_amount_outstainding;
	}
	public void setR20_amount_outstainding(BigDecimal r20_amount_outstainding) {
		this.r20_amount_outstainding = r20_amount_outstainding;
	}
	public BigDecimal getR20_interest_expense() {
		return r20_interest_expense;
	}
	public void setR20_interest_expense(BigDecimal r20_interest_expense) {
		this.r20_interest_expense = r20_interest_expense;
	}
	public String getR21_product() {
		return r21_product;
	}
	public void setR21_product(String r21_product) {
		this.r21_product = r21_product;
	}
	public BigDecimal getR21_amount_outstainding() {
		return r21_amount_outstainding;
	}
	public void setR21_amount_outstainding(BigDecimal r21_amount_outstainding) {
		this.r21_amount_outstainding = r21_amount_outstainding;
	}
	public BigDecimal getR21_interest_expense() {
		return r21_interest_expense;
	}
	public void setR21_interest_expense(BigDecimal r21_interest_expense) {
		this.r21_interest_expense = r21_interest_expense;
	}
	public String getR22_product() {
		return r22_product;
	}
	public void setR22_product(String r22_product) {
		this.r22_product = r22_product;
	}
	public BigDecimal getR22_amount_outstainding() {
		return r22_amount_outstainding;
	}
	public void setR22_amount_outstainding(BigDecimal r22_amount_outstainding) {
		this.r22_amount_outstainding = r22_amount_outstainding;
	}
	public BigDecimal getR22_interest_expense() {
		return r22_interest_expense;
	}
	public void setR22_interest_expense(BigDecimal r22_interest_expense) {
		this.r22_interest_expense = r22_interest_expense;
	}
	public String getR23_product() {
		return r23_product;
	}
	public void setR23_product(String r23_product) {
		this.r23_product = r23_product;
	}
	public BigDecimal getR23_amount_outstainding() {
		return r23_amount_outstainding;
	}
	public void setR23_amount_outstainding(BigDecimal r23_amount_outstainding) {
		this.r23_amount_outstainding = r23_amount_outstainding;
	}
	public BigDecimal getR23_interest_expense() {
		return r23_interest_expense;
	}
	public void setR23_interest_expense(BigDecimal r23_interest_expense) {
		this.r23_interest_expense = r23_interest_expense;
	}
	public String getR24_product() {
		return r24_product;
	}
	public void setR24_product(String r24_product) {
		this.r24_product = r24_product;
	}
	public BigDecimal getR24_amount_outstainding() {
		return r24_amount_outstainding;
	}
	public void setR24_amount_outstainding(BigDecimal r24_amount_outstainding) {
		this.r24_amount_outstainding = r24_amount_outstainding;
	}
	public BigDecimal getR24_interest_expense() {
		return r24_interest_expense;
	}
	public void setR24_interest_expense(BigDecimal r24_interest_expense) {
		this.r24_interest_expense = r24_interest_expense;
	}
	public String getR25_product() {
		return r25_product;
	}
	public void setR25_product(String r25_product) {
		this.r25_product = r25_product;
	}
	public BigDecimal getR25_amount_outstainding() {
		return r25_amount_outstainding;
	}
	public void setR25_amount_outstainding(BigDecimal r25_amount_outstainding) {
		this.r25_amount_outstainding = r25_amount_outstainding;
	}
	public BigDecimal getR25_interest_expense() {
		return r25_interest_expense;
	}
	public void setR25_interest_expense(BigDecimal r25_interest_expense) {
		this.r25_interest_expense = r25_interest_expense;
	}
	public String getR26_product() {
		return r26_product;
	}
	public void setR26_product(String r26_product) {
		this.r26_product = r26_product;
	}
	public BigDecimal getR26_amount_outstainding() {
		return r26_amount_outstainding;
	}
	public void setR26_amount_outstainding(BigDecimal r26_amount_outstainding) {
		this.r26_amount_outstainding = r26_amount_outstainding;
	}
	public BigDecimal getR26_interest_expense() {
		return r26_interest_expense;
	}
	public void setR26_interest_expense(BigDecimal r26_interest_expense) {
		this.r26_interest_expense = r26_interest_expense;
	}
	public String getR27_product() {
		return r27_product;
	}
	public void setR27_product(String r27_product) {
		this.r27_product = r27_product;
	}
	public BigDecimal getR27_amount_outstainding() {
		return r27_amount_outstainding;
	}
	public void setR27_amount_outstainding(BigDecimal r27_amount_outstainding) {
		this.r27_amount_outstainding = r27_amount_outstainding;
	}
	public BigDecimal getR27_interest_expense() {
		return r27_interest_expense;
	}
	public void setR27_interest_expense(BigDecimal r27_interest_expense) {
		this.r27_interest_expense = r27_interest_expense;
	}
	public String getR28_product() {
		return r28_product;
	}
	public void setR28_product(String r28_product) {
		this.r28_product = r28_product;
	}
	public BigDecimal getR28_amount_outstainding() {
		return r28_amount_outstainding;
	}
	public void setR28_amount_outstainding(BigDecimal r28_amount_outstainding) {
		this.r28_amount_outstainding = r28_amount_outstainding;
	}
	public BigDecimal getR28_interest_expense() {
		return r28_interest_expense;
	}
	public void setR28_interest_expense(BigDecimal r28_interest_expense) {
		this.r28_interest_expense = r28_interest_expense;
	}
	public String getR29_product() {
		return r29_product;
	}
	public void setR29_product(String r29_product) {
		this.r29_product = r29_product;
	}
	public BigDecimal getR29_amount_outstainding() {
		return r29_amount_outstainding;
	}
	public void setR29_amount_outstainding(BigDecimal r29_amount_outstainding) {
		this.r29_amount_outstainding = r29_amount_outstainding;
	}
	public BigDecimal getR29_interest_expense() {
		return r29_interest_expense;
	}
	public void setR29_interest_expense(BigDecimal r29_interest_expense) {
		this.r29_interest_expense = r29_interest_expense;
	}
	public String getR30_product() {
		return r30_product;
	}
	public void setR30_product(String r30_product) {
		this.r30_product = r30_product;
	}
	public BigDecimal getR30_amount_outstainding() {
		return r30_amount_outstainding;
	}
	public void setR30_amount_outstainding(BigDecimal r30_amount_outstainding) {
		this.r30_amount_outstainding = r30_amount_outstainding;
	}
	public BigDecimal getR30_interest_expense() {
		return r30_interest_expense;
	}
	public void setR30_interest_expense(BigDecimal r30_interest_expense) {
		this.r30_interest_expense = r30_interest_expense;
	}
	public String getR31_product() {
		return r31_product;
	}
	public void setR31_product(String r31_product) {
		this.r31_product = r31_product;
	}
	public BigDecimal getR31_amount_outstainding() {
		return r31_amount_outstainding;
	}
	public void setR31_amount_outstainding(BigDecimal r31_amount_outstainding) {
		this.r31_amount_outstainding = r31_amount_outstainding;
	}
	public BigDecimal getR31_interest_expense() {
		return r31_interest_expense;
	}
	public void setR31_interest_expense(BigDecimal r31_interest_expense) {
		this.r31_interest_expense = r31_interest_expense;
	}
	public String getR32_product() {
		return r32_product;
	}
	public void setR32_product(String r32_product) {
		this.r32_product = r32_product;
	}
	public BigDecimal getR32_amount_outstainding() {
		return r32_amount_outstainding;
	}
	public void setR32_amount_outstainding(BigDecimal r32_amount_outstainding) {
		this.r32_amount_outstainding = r32_amount_outstainding;
	}
	public BigDecimal getR32_interest_expense() {
		return r32_interest_expense;
	}
	public void setR32_interest_expense(BigDecimal r32_interest_expense) {
		this.r32_interest_expense = r32_interest_expense;
	}
	public String getR33_product() {
		return r33_product;
	}
	public void setR33_product(String r33_product) {
		this.r33_product = r33_product;
	}
	public BigDecimal getR33_amount_outstainding() {
		return r33_amount_outstainding;
	}
	public void setR33_amount_outstainding(BigDecimal r33_amount_outstainding) {
		this.r33_amount_outstainding = r33_amount_outstainding;
	}
	public BigDecimal getR33_interest_expense() {
		return r33_interest_expense;
	}
	public void setR33_interest_expense(BigDecimal r33_interest_expense) {
		this.r33_interest_expense = r33_interest_expense;
	}
	public String getR34_product() {
		return r34_product;
	}
	public void setR34_product(String r34_product) {
		this.r34_product = r34_product;
	}
	public BigDecimal getR34_amount_outstainding() {
		return r34_amount_outstainding;
	}
	public void setR34_amount_outstainding(BigDecimal r34_amount_outstainding) {
		this.r34_amount_outstainding = r34_amount_outstainding;
	}
	public BigDecimal getR34_interest_expense() {
		return r34_interest_expense;
	}
	public void setR34_interest_expense(BigDecimal r34_interest_expense) {
		this.r34_interest_expense = r34_interest_expense;
	}
	public String getR35_product() {
		return r35_product;
	}
	public void setR35_product(String r35_product) {
		this.r35_product = r35_product;
	}
	public BigDecimal getR35_amount_outstainding() {
		return r35_amount_outstainding;
	}
	public void setR35_amount_outstainding(BigDecimal r35_amount_outstainding) {
		this.r35_amount_outstainding = r35_amount_outstainding;
	}
	public BigDecimal getR35_interest_expense() {
		return r35_interest_expense;
	}
	public void setR35_interest_expense(BigDecimal r35_interest_expense) {
		this.r35_interest_expense = r35_interest_expense;
	}
	public String getR36_product() {
		return r36_product;
	}
	public void setR36_product(String r36_product) {
		this.r36_product = r36_product;
	}
	public BigDecimal getR36_amount_outstainding() {
		return r36_amount_outstainding;
	}
	public void setR36_amount_outstainding(BigDecimal r36_amount_outstainding) {
		this.r36_amount_outstainding = r36_amount_outstainding;
	}
	public BigDecimal getR36_interest_expense() {
		return r36_interest_expense;
	}
	public void setR36_interest_expense(BigDecimal r36_interest_expense) {
		this.r36_interest_expense = r36_interest_expense;
	}
	public String getR37_product() {
		return r37_product;
	}
	public void setR37_product(String r37_product) {
		this.r37_product = r37_product;
	}
	public BigDecimal getR37_amount_outstainding() {
		return r37_amount_outstainding;
	}
	public void setR37_amount_outstainding(BigDecimal r37_amount_outstainding) {
		this.r37_amount_outstainding = r37_amount_outstainding;
	}
	public BigDecimal getR37_interest_expense() {
		return r37_interest_expense;
	}
	public void setR37_interest_expense(BigDecimal r37_interest_expense) {
		this.r37_interest_expense = r37_interest_expense;
	}
	public String getR38_product() {
		return r38_product;
	}
	public void setR38_product(String r38_product) {
		this.r38_product = r38_product;
	}
	public BigDecimal getR38_amount_outstainding() {
		return r38_amount_outstainding;
	}
	public void setR38_amount_outstainding(BigDecimal r38_amount_outstainding) {
		this.r38_amount_outstainding = r38_amount_outstainding;
	}
	public BigDecimal getR38_interest_expense() {
		return r38_interest_expense;
	}
	public void setR38_interest_expense(BigDecimal r38_interest_expense) {
		this.r38_interest_expense = r38_interest_expense;
	}
	public String getR39_product() {
		return r39_product;
	}
	public void setR39_product(String r39_product) {
		this.r39_product = r39_product;
	}
	public BigDecimal getR39_amount_outstainding() {
		return r39_amount_outstainding;
	}
	public void setR39_amount_outstainding(BigDecimal r39_amount_outstainding) {
		this.r39_amount_outstainding = r39_amount_outstainding;
	}
	public BigDecimal getR39_interest_expense() {
		return r39_interest_expense;
	}
	public void setR39_interest_expense(BigDecimal r39_interest_expense) {
		this.r39_interest_expense = r39_interest_expense;
	}
	public String getR40_product() {
		return r40_product;
	}
	public void setR40_product(String r40_product) {
		this.r40_product = r40_product;
	}
	public BigDecimal getR40_amount_outstainding() {
		return r40_amount_outstainding;
	}
	public void setR40_amount_outstainding(BigDecimal r40_amount_outstainding) {
		this.r40_amount_outstainding = r40_amount_outstainding;
	}
	public BigDecimal getR40_interest_expense() {
		return r40_interest_expense;
	}
	public void setR40_interest_expense(BigDecimal r40_interest_expense) {
		this.r40_interest_expense = r40_interest_expense;
	}
	public String getR41_product() {
		return r41_product;
	}
	public void setR41_product(String r41_product) {
		this.r41_product = r41_product;
	}
	public BigDecimal getR41_amount_outstainding() {
		return r41_amount_outstainding;
	}
	public void setR41_amount_outstainding(BigDecimal r41_amount_outstainding) {
		this.r41_amount_outstainding = r41_amount_outstainding;
	}
	public BigDecimal getR41_interest_expense() {
		return r41_interest_expense;
	}
	public void setR41_interest_expense(BigDecimal r41_interest_expense) {
		this.r41_interest_expense = r41_interest_expense;
	}
	public String getR42_product() {
		return r42_product;
	}
	public void setR42_product(String r42_product) {
		this.r42_product = r42_product;
	}
	public BigDecimal getR42_amount_outstainding() {
		return r42_amount_outstainding;
	}
	public void setR42_amount_outstainding(BigDecimal r42_amount_outstainding) {
		this.r42_amount_outstainding = r42_amount_outstainding;
	}
	public BigDecimal getR42_interest_expense() {
		return r42_interest_expense;
	}
	public void setR42_interest_expense(BigDecimal r42_interest_expense) {
		this.r42_interest_expense = r42_interest_expense;
	}
	public String getR43_product() {
		return r43_product;
	}
	public void setR43_product(String r43_product) {
		this.r43_product = r43_product;
	}
	public BigDecimal getR43_amount_outstainding() {
		return r43_amount_outstainding;
	}
	public void setR43_amount_outstainding(BigDecimal r43_amount_outstainding) {
		this.r43_amount_outstainding = r43_amount_outstainding;
	}
	public BigDecimal getR43_interest_expense() {
		return r43_interest_expense;
	}
	public void setR43_interest_expense(BigDecimal r43_interest_expense) {
		this.r43_interest_expense = r43_interest_expense;
	}
	public String getR44_product() {
		return r44_product;
	}
	public void setR44_product(String r44_product) {
		this.r44_product = r44_product;
	}
	public BigDecimal getR44_amount_outstainding() {
		return r44_amount_outstainding;
	}
	public void setR44_amount_outstainding(BigDecimal r44_amount_outstainding) {
		this.r44_amount_outstainding = r44_amount_outstainding;
	}
	public BigDecimal getR44_interest_expense() {
		return r44_interest_expense;
	}
	public void setR44_interest_expense(BigDecimal r44_interest_expense) {
		this.r44_interest_expense = r44_interest_expense;
	}
	public String getR45_product() {
		return r45_product;
	}
	public void setR45_product(String r45_product) {
		this.r45_product = r45_product;
	}
	public BigDecimal getR45_amount_outstainding() {
		return r45_amount_outstainding;
	}
	public void setR45_amount_outstainding(BigDecimal r45_amount_outstainding) {
		this.r45_amount_outstainding = r45_amount_outstainding;
	}
	public BigDecimal getR45_interest_expense() {
		return r45_interest_expense;
	}
	public void setR45_interest_expense(BigDecimal r45_interest_expense) {
		this.r45_interest_expense = r45_interest_expense;
	}
	public String getR46_product() {
		return r46_product;
	}
	public void setR46_product(String r46_product) {
		this.r46_product = r46_product;
	}
	public BigDecimal getR46_amount_outstainding() {
		return r46_amount_outstainding;
	}
	public void setR46_amount_outstainding(BigDecimal r46_amount_outstainding) {
		this.r46_amount_outstainding = r46_amount_outstainding;
	}
	public BigDecimal getR46_interest_expense() {
		return r46_interest_expense;
	}
	public void setR46_interest_expense(BigDecimal r46_interest_expense) {
		this.r46_interest_expense = r46_interest_expense;
	}
	public String getR47_product() {
		return r47_product;
	}
	public void setR47_product(String r47_product) {
		this.r47_product = r47_product;
	}
	public BigDecimal getR47_amount_outstainding() {
		return r47_amount_outstainding;
	}
	public void setR47_amount_outstainding(BigDecimal r47_amount_outstainding) {
		this.r47_amount_outstainding = r47_amount_outstainding;
	}
	public BigDecimal getR47_interest_expense() {
		return r47_interest_expense;
	}
	public void setR47_interest_expense(BigDecimal r47_interest_expense) {
		this.r47_interest_expense = r47_interest_expense;
	}
	public String getR48_product() {
		return r48_product;
	}
	public void setR48_product(String r48_product) {
		this.r48_product = r48_product;
	}
	public BigDecimal getR48_amount_outstainding() {
		return r48_amount_outstainding;
	}
	public void setR48_amount_outstainding(BigDecimal r48_amount_outstainding) {
		this.r48_amount_outstainding = r48_amount_outstainding;
	}
	public BigDecimal getR48_interest_expense() {
		return r48_interest_expense;
	}
	public void setR48_interest_expense(BigDecimal r48_interest_expense) {
		this.r48_interest_expense = r48_interest_expense;
	}
	public String getR49_product() {
		return r49_product;
	}
	public void setR49_product(String r49_product) {
		this.r49_product = r49_product;
	}
	public BigDecimal getR49_amount_outstainding() {
		return r49_amount_outstainding;
	}
	public void setR49_amount_outstainding(BigDecimal r49_amount_outstainding) {
		this.r49_amount_outstainding = r49_amount_outstainding;
	}
	public BigDecimal getR49_interest_expense() {
		return r49_interest_expense;
	}
	public void setR49_interest_expense(BigDecimal r49_interest_expense) {
		this.r49_interest_expense = r49_interest_expense;
	}
	public String getR50_product() {
		return r50_product;
	}
	public void setR50_product(String r50_product) {
		this.r50_product = r50_product;
	}
	public BigDecimal getR50_amount_outstainding() {
		return r50_amount_outstainding;
	}
	public void setR50_amount_outstainding(BigDecimal r50_amount_outstainding) {
		this.r50_amount_outstainding = r50_amount_outstainding;
	}
	public BigDecimal getR50_interest_expense() {
		return r50_interest_expense;
	}
	public void setR50_interest_expense(BigDecimal r50_interest_expense) {
		this.r50_interest_expense = r50_interest_expense;
	}
	public String getR51_product() {
		return r51_product;
	}
	public void setR51_product(String r51_product) {
		this.r51_product = r51_product;
	}
	public BigDecimal getR51_amount_outstainding() {
		return r51_amount_outstainding;
	}
	public void setR51_amount_outstainding(BigDecimal r51_amount_outstainding) {
		this.r51_amount_outstainding = r51_amount_outstainding;
	}
	public BigDecimal getR51_interest_expense() {
		return r51_interest_expense;
	}
	public void setR51_interest_expense(BigDecimal r51_interest_expense) {
		this.r51_interest_expense = r51_interest_expense;
	}
	public String getR52_product() {
		return r52_product;
	}
	public void setR52_product(String r52_product) {
		this.r52_product = r52_product;
	}
	public BigDecimal getR52_amount_outstainding() {
		return r52_amount_outstainding;
	}
	public void setR52_amount_outstainding(BigDecimal r52_amount_outstainding) {
		this.r52_amount_outstainding = r52_amount_outstainding;
	}
	public BigDecimal getR52_interest_expense() {
		return r52_interest_expense;
	}
	public void setR52_interest_expense(BigDecimal r52_interest_expense) {
		this.r52_interest_expense = r52_interest_expense;
	}
	public String getR53_product() {
		return r53_product;
	}
	public void setR53_product(String r53_product) {
		this.r53_product = r53_product;
	}
	public BigDecimal getR53_amount_outstainding() {
		return r53_amount_outstainding;
	}
	public void setR53_amount_outstainding(BigDecimal r53_amount_outstainding) {
		this.r53_amount_outstainding = r53_amount_outstainding;
	}
	public BigDecimal getR53_interest_expense() {
		return r53_interest_expense;
	}
	public void setR53_interest_expense(BigDecimal r53_interest_expense) {
		this.r53_interest_expense = r53_interest_expense;
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
	public BRF50_Entity() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	

}
