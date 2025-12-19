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
@Table(name = "BRF31_SUMMARYTABLE")
public class BRF31_Entity {
	private String r10_uae_nationals;
	private BigDecimal r10_nos_aed_resident;
	private BigDecimal r10_amount_aed_resident;
	private BigDecimal r10_nos_ccy_resident;
	private BigDecimal r10_amount_ccy_resident;
	private BigDecimal r10_nos_aed_non_resident;
	private BigDecimal r10_amount_aed_non_resident;
	private BigDecimal r10_nos_ccy_non_resident;
	private BigDecimal r10_amount_ccy_non_resident;
	private String r11_uae_nationals1;
	private BigDecimal r11_nos_aed_resident;
	private BigDecimal r11_amount_aed_resident;
	private BigDecimal r11_nos_ccy_resident;
	private BigDecimal r11_amount_ccy_resident;
	private BigDecimal r11_nos_aed_non_resident;
	private BigDecimal r11_amount_aed_non_resident;
	private BigDecimal r11_nos_ccy_non_resident;
	private BigDecimal r11_amount_ccy_non_resident;
	private String r12_uae_nationals;
	private BigDecimal r12_nos_aed_resident;
	private BigDecimal r12_amount_aed_resident;
	private BigDecimal r12_nos_ccy_resident;
	private BigDecimal r12_amount_ccy_resident;
	private BigDecimal r12_nos_aed_non_resident;
	private BigDecimal r12_amount_aed_non_resident;
	private BigDecimal r12_nos_ccy_non_resident;
	private BigDecimal r12_amount_ccy_non_resident;
	private String r13_uae_nationals3;
	private BigDecimal r13_nos_aed_resident;
	private BigDecimal r13_amount_aed_resident;
	private BigDecimal r13_nos_ccy_resident;
	private BigDecimal r13_amount_ccy_resident;
	private BigDecimal r13_nos_aed_non_resident;
	private BigDecimal r13_amount_aed_non_resident;
	private BigDecimal r13_nos_ccy_non_resident;
	private BigDecimal r13_amount_ccy_non_resident;
	private String r14_uae_nationals4;
	private BigDecimal r14_nos_aed_resident;
	private BigDecimal r14_amount_aed_resident;
	private BigDecimal r14_nos_ccy_resident;
	private BigDecimal r14_amount_ccy_resident;
	private BigDecimal r14_nos_aed_non_resident;
	private BigDecimal r14_amount_aed_non_resident;
	private BigDecimal r14_nos_ccy_non_resident;
	private BigDecimal r14_amount_ccy_non_resident;
	private String r15_uae_nationals5;
	private BigDecimal r15_nos_aed_resident;
	private BigDecimal r15_amount_aed_resident;
	private BigDecimal r15_nos_ccy_resident;
	private BigDecimal r15_amount_ccy_resident;
	private BigDecimal r15_nos_aed_non_resident;
	private BigDecimal r15_amount_aed_non_resident;
	private BigDecimal r15_nos_ccy_non_resident;
	private BigDecimal r15_amount_ccy_non_resident;
	private String r16_uae_nationals6;
	private BigDecimal r16_nos_aed_resident;
	private BigDecimal r16_amount_aed_resident;
	private BigDecimal r16_nos_ccy_resident;
	private BigDecimal r16_amount_ccy_resident;
	private BigDecimal r16_nos_aed_non_resident;
	private BigDecimal r16_amount_aed_non_resident;
	private BigDecimal r16_nos_ccy_non_resident;
	private BigDecimal r16_amount_ccy_non_resident;
	private String r17_uae_nationals7;
	private BigDecimal r17_nos_aed_resident;
	private BigDecimal r17_amount_aed_resident;
	private BigDecimal r17_nos_ccy_resident;
	private BigDecimal r17_amount_ccy_resident;
	private BigDecimal r17_nos_aed_non_resident;
	private BigDecimal r17_amount_aed_non_resident;
	private BigDecimal r17_nos_ccy_non_resident;
	private BigDecimal r17_amount_ccy_non_resident;
	private String r18_uae_nationals8;
	private BigDecimal r18_nos_aed_resident;
	private BigDecimal r18_amount_aed_resident;
	private BigDecimal r18_nos_ccy_resident;
	private BigDecimal r18_amount_ccy_resident;
	private BigDecimal r18_nos_aed_non_resident;
	private BigDecimal r18_amount_aed_non_resident;
	private BigDecimal r18_nos_ccy_non_resident;
	private BigDecimal r18_amount_ccy_non_resident;
	private String r19_uae_nationals9;
	private BigDecimal r19_nos_aed_resident;
	private BigDecimal r19_amount_aed_resident;
	private BigDecimal r19_nos_ccy_resident;
	private BigDecimal r19_amount_ccy_resident;
	private BigDecimal r19_nos_aed_non_resident;
	private BigDecimal r19_amount_aed_non_resident;
	private BigDecimal r19_nos_ccy_non_resident;
	private BigDecimal r19_amount_ccy_non_resident;
	private String r20_non_uae_nationals;
	private BigDecimal r20_nos_aed_resident;
	private BigDecimal r20_amount_aed_resident;
	private BigDecimal r20_nos_ccy_resident;
	private BigDecimal r20_amount_ccy_resident;
	private BigDecimal r20_nos_aed_non_resident;
	private BigDecimal r20_amount_aed_non_resident;
	private BigDecimal r20_nos_ccy_non_resident;
	private BigDecimal r20_amount_ccy_non_resident;
	private String r21_non_uae_nationals1;
	private BigDecimal r21_nos_aed_resident;
	private BigDecimal r21_amount_aed_resident;
	private BigDecimal r21_nos_ccy_resident;
	private BigDecimal r21_amount_ccy_resident;
	private BigDecimal r21_nos_aed_non_resident;
	private BigDecimal r21_amount_aed_non_resident;
	private BigDecimal r21_nos_ccy_non_resident;
	private BigDecimal r21_amount_ccy_non_resident;
	private String r22_non_uae_nationals2;
	private BigDecimal r22_nos_aed_resident;
	private BigDecimal r22_amount_aed_resident;
	private BigDecimal r22_nos_ccy_resident;
	private BigDecimal r22_amount_ccy_resident;
	private BigDecimal r22_nos_aed_non_resident;
	private BigDecimal r22_amount_aed_non_resident;
	private BigDecimal r22_nos_ccy_non_resident;
	private BigDecimal r22_amount_ccy_non_resident;
	private String r23_non_uae_nationals3;
	private BigDecimal r23_nos_aed_resident;
	private BigDecimal r23_amount_aed_resident;
	private BigDecimal r23_nos_ccy_resident;
	private BigDecimal r23_amount_ccy_resident;
	private BigDecimal r23_nos_aed_non_resident;
	private BigDecimal r23_amount_aed_non_resident;
	private BigDecimal r23_nos_ccy_non_resident;
	private BigDecimal r23_amount_ccy_non_resident;
	private String r24_non_uae_nationals4;
	private BigDecimal r24_nos_aed_resident;
	private BigDecimal r24_amount_aed_resident;
	private BigDecimal r24_nos_ccy_resident;
	private BigDecimal r24_amount_ccy_resident;
	private BigDecimal r24_nos_aed_non_resident;
	private BigDecimal r24_amount_aed_non_resident;
	private BigDecimal r24_nos_ccy_non_resident;
	private BigDecimal r24_amount_ccy_non_resident;
	private String r25_non_uae_nationals5;
	private BigDecimal r25_nos_aed_resident;
	private BigDecimal r25_amount_aed_resident;
	private BigDecimal r25_nos_ccy_resident;
	private BigDecimal r25_amount_ccy_resident;
	private BigDecimal r25_nos_aed_non_resident;
	private BigDecimal r25_amount_aed_non_resident;
	private BigDecimal r25_nos_ccy_non_resident;
	private BigDecimal r25_amount_ccy_non_resident;
	private String r26_non_uae_nationals6;
	private BigDecimal r26_nos_aed_resident;
	private BigDecimal r26_amount_aed_resident;
	private BigDecimal r26_nos_ccy_resident;
	private BigDecimal r26_amount_ccy_resident;
	private BigDecimal r26_nos_aed_non_resident;
	private BigDecimal r26_amount_aed_non_resident;
	private BigDecimal r26_nos_ccy_non_resident;
	private BigDecimal r26_amount_ccy_non_resident;
	private String r27_non_uae_nationals7;
	private BigDecimal r27_nos_aed_resident;
	private BigDecimal r27_amount_aed_resident;
	private BigDecimal r27_nos_ccy_resident;
	private BigDecimal r27_amount_ccy_resident;
	private BigDecimal r27_nos_aed_non_resident;
	private BigDecimal r27_amount_aed_non_resident;
	private BigDecimal r27_nos_ccy_non_resident;
	private BigDecimal r27_amount_ccy_non_resident;
	private String r28_non_uae_nationals8;
	private BigDecimal r28_nos_aed_resident;
	private BigDecimal r28_amount_aed_resident;
	private BigDecimal r28_nos_ccy_resident;
	private BigDecimal r28_amount_ccy_resident;
	private BigDecimal r28_nos_aed_non_resident;
	private BigDecimal r28_amount_aed_non_resident;
	private BigDecimal r28_nos_ccy_non_resident;
	private BigDecimal r28_amount_ccy_non_resident;
	private String r29_grand_total;
	private BigDecimal r29_nos_aed_resident;
	private BigDecimal r29_amount_aed_resident;
	private BigDecimal r29_nos_ccy_resident;
	private BigDecimal r29_amount_ccy_resident;
	private BigDecimal r29_nos_aed_non_resident;
	private BigDecimal r29_amount_aed_non_resident;
	private BigDecimal r29_nos_ccy_non_resident;
	private BigDecimal r29_amount_ccy_non_resident;
	@Id
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date report_date;
	private Date report_from_date;
	private String report_to_date;
	private String entity_flg;
	private String modify_flg;
	private String del_flg;
	private String report_code;
	private Date report_submit_date;
	private String uae_nationals;
	private String nos_aed_resident;
	private String amount_aed_resident;
	private String nos_ccy_resident;
	private String amount_ccy_resident;
	private String nos_aed_non_resident;
	private String amount_aed_non_resident;
	private String nos_ccy_non_resident;
	private String amount_ccy_non_resident;
	private String	repdesc;
	private String	frequency;
	public String getR10_uae_nationals() {
		return r10_uae_nationals;
	}
	public void setR10_uae_nationals(String r10_uae_nationals) {
		this.r10_uae_nationals = r10_uae_nationals;
	}
	public BigDecimal getR10_nos_aed_resident() {
		return r10_nos_aed_resident;
	}
	public void setR10_nos_aed_resident(BigDecimal r10_nos_aed_resident) {
		this.r10_nos_aed_resident = r10_nos_aed_resident;
	}
	public BigDecimal getR10_amount_aed_resident() {
		return r10_amount_aed_resident;
	}
	public void setR10_amount_aed_resident(BigDecimal r10_amount_aed_resident) {
		this.r10_amount_aed_resident = r10_amount_aed_resident;
	}
	public BigDecimal getR10_nos_ccy_resident() {
		return r10_nos_ccy_resident;
	}
	public void setR10_nos_ccy_resident(BigDecimal r10_nos_ccy_resident) {
		this.r10_nos_ccy_resident = r10_nos_ccy_resident;
	}
	public BigDecimal getR10_amount_ccy_resident() {
		return r10_amount_ccy_resident;
	}
	public void setR10_amount_ccy_resident(BigDecimal r10_amount_ccy_resident) {
		this.r10_amount_ccy_resident = r10_amount_ccy_resident;
	}
	public BigDecimal getR10_nos_aed_non_resident() {
		return r10_nos_aed_non_resident;
	}
	public void setR10_nos_aed_non_resident(BigDecimal r10_nos_aed_non_resident) {
		this.r10_nos_aed_non_resident = r10_nos_aed_non_resident;
	}
	public BigDecimal getR10_amount_aed_non_resident() {
		return r10_amount_aed_non_resident;
	}
	public void setR10_amount_aed_non_resident(BigDecimal r10_amount_aed_non_resident) {
		this.r10_amount_aed_non_resident = r10_amount_aed_non_resident;
	}
	public BigDecimal getR10_nos_ccy_non_resident() {
		return r10_nos_ccy_non_resident;
	}
	public void setR10_nos_ccy_non_resident(BigDecimal r10_nos_ccy_non_resident) {
		this.r10_nos_ccy_non_resident = r10_nos_ccy_non_resident;
	}
	public BigDecimal getR10_amount_ccy_non_resident() {
		return r10_amount_ccy_non_resident;
	}
	public void setR10_amount_ccy_non_resident(BigDecimal r10_amount_ccy_non_resident) {
		this.r10_amount_ccy_non_resident = r10_amount_ccy_non_resident;
	}
	public String getR11_uae_nationals1() {
		return r11_uae_nationals1;
	}
	public void setR11_uae_nationals1(String r11_uae_nationals1) {
		this.r11_uae_nationals1 = r11_uae_nationals1;
	}
	public BigDecimal getR11_nos_aed_resident() {
		return r11_nos_aed_resident;
	}
	public void setR11_nos_aed_resident(BigDecimal r11_nos_aed_resident) {
		this.r11_nos_aed_resident = r11_nos_aed_resident;
	}
	public BigDecimal getR11_amount_aed_resident() {
		return r11_amount_aed_resident;
	}
	public void setR11_amount_aed_resident(BigDecimal r11_amount_aed_resident) {
		this.r11_amount_aed_resident = r11_amount_aed_resident;
	}
	public BigDecimal getR11_nos_ccy_resident() {
		return r11_nos_ccy_resident;
	}
	public void setR11_nos_ccy_resident(BigDecimal r11_nos_ccy_resident) {
		this.r11_nos_ccy_resident = r11_nos_ccy_resident;
	}
	public BigDecimal getR11_amount_ccy_resident() {
		return r11_amount_ccy_resident;
	}
	public void setR11_amount_ccy_resident(BigDecimal r11_amount_ccy_resident) {
		this.r11_amount_ccy_resident = r11_amount_ccy_resident;
	}
	public BigDecimal getR11_nos_aed_non_resident() {
		return r11_nos_aed_non_resident;
	}
	public void setR11_nos_aed_non_resident(BigDecimal r11_nos_aed_non_resident) {
		this.r11_nos_aed_non_resident = r11_nos_aed_non_resident;
	}
	public BigDecimal getR11_amount_aed_non_resident() {
		return r11_amount_aed_non_resident;
	}
	public void setR11_amount_aed_non_resident(BigDecimal r11_amount_aed_non_resident) {
		this.r11_amount_aed_non_resident = r11_amount_aed_non_resident;
	}
	public BigDecimal getR11_nos_ccy_non_resident() {
		return r11_nos_ccy_non_resident;
	}
	public void setR11_nos_ccy_non_resident(BigDecimal r11_nos_ccy_non_resident) {
		this.r11_nos_ccy_non_resident = r11_nos_ccy_non_resident;
	}
	public BigDecimal getR11_amount_ccy_non_resident() {
		return r11_amount_ccy_non_resident;
	}
	public void setR11_amount_ccy_non_resident(BigDecimal r11_amount_ccy_non_resident) {
		this.r11_amount_ccy_non_resident = r11_amount_ccy_non_resident;
	}
	public String getR12_uae_nationals() {
		return r12_uae_nationals;
	}
	public void setR12_uae_nationals(String r12_uae_nationals) {
		this.r12_uae_nationals = r12_uae_nationals;
	}
	public BigDecimal getR12_nos_aed_resident() {
		return r12_nos_aed_resident;
	}
	public void setR12_nos_aed_resident(BigDecimal r12_nos_aed_resident) {
		this.r12_nos_aed_resident = r12_nos_aed_resident;
	}
	public BigDecimal getR12_amount_aed_resident() {
		return r12_amount_aed_resident;
	}
	public void setR12_amount_aed_resident(BigDecimal r12_amount_aed_resident) {
		this.r12_amount_aed_resident = r12_amount_aed_resident;
	}
	public BigDecimal getR12_nos_ccy_resident() {
		return r12_nos_ccy_resident;
	}
	public void setR12_nos_ccy_resident(BigDecimal r12_nos_ccy_resident) {
		this.r12_nos_ccy_resident = r12_nos_ccy_resident;
	}
	public BigDecimal getR12_amount_ccy_resident() {
		return r12_amount_ccy_resident;
	}
	public void setR12_amount_ccy_resident(BigDecimal r12_amount_ccy_resident) {
		this.r12_amount_ccy_resident = r12_amount_ccy_resident;
	}
	public BigDecimal getR12_nos_aed_non_resident() {
		return r12_nos_aed_non_resident;
	}
	public void setR12_nos_aed_non_resident(BigDecimal r12_nos_aed_non_resident) {
		this.r12_nos_aed_non_resident = r12_nos_aed_non_resident;
	}
	public BigDecimal getR12_amount_aed_non_resident() {
		return r12_amount_aed_non_resident;
	}
	public void setR12_amount_aed_non_resident(BigDecimal r12_amount_aed_non_resident) {
		this.r12_amount_aed_non_resident = r12_amount_aed_non_resident;
	}
	public BigDecimal getR12_nos_ccy_non_resident() {
		return r12_nos_ccy_non_resident;
	}
	public void setR12_nos_ccy_non_resident(BigDecimal r12_nos_ccy_non_resident) {
		this.r12_nos_ccy_non_resident = r12_nos_ccy_non_resident;
	}
	public BigDecimal getR12_amount_ccy_non_resident() {
		return r12_amount_ccy_non_resident;
	}
	public void setR12_amount_ccy_non_resident(BigDecimal r12_amount_ccy_non_resident) {
		this.r12_amount_ccy_non_resident = r12_amount_ccy_non_resident;
	}
	public String getR13_uae_nationals3() {
		return r13_uae_nationals3;
	}
	public void setR13_uae_nationals3(String r13_uae_nationals3) {
		this.r13_uae_nationals3 = r13_uae_nationals3;
	}
	public BigDecimal getR13_nos_aed_resident() {
		return r13_nos_aed_resident;
	}
	public void setR13_nos_aed_resident(BigDecimal r13_nos_aed_resident) {
		this.r13_nos_aed_resident = r13_nos_aed_resident;
	}
	public BigDecimal getR13_amount_aed_resident() {
		return r13_amount_aed_resident;
	}
	public void setR13_amount_aed_resident(BigDecimal r13_amount_aed_resident) {
		this.r13_amount_aed_resident = r13_amount_aed_resident;
	}
	public BigDecimal getR13_nos_ccy_resident() {
		return r13_nos_ccy_resident;
	}
	public void setR13_nos_ccy_resident(BigDecimal r13_nos_ccy_resident) {
		this.r13_nos_ccy_resident = r13_nos_ccy_resident;
	}
	public BigDecimal getR13_amount_ccy_resident() {
		return r13_amount_ccy_resident;
	}
	public void setR13_amount_ccy_resident(BigDecimal r13_amount_ccy_resident) {
		this.r13_amount_ccy_resident = r13_amount_ccy_resident;
	}
	public BigDecimal getR13_nos_aed_non_resident() {
		return r13_nos_aed_non_resident;
	}
	public void setR13_nos_aed_non_resident(BigDecimal r13_nos_aed_non_resident) {
		this.r13_nos_aed_non_resident = r13_nos_aed_non_resident;
	}
	public BigDecimal getR13_amount_aed_non_resident() {
		return r13_amount_aed_non_resident;
	}
	public void setR13_amount_aed_non_resident(BigDecimal r13_amount_aed_non_resident) {
		this.r13_amount_aed_non_resident = r13_amount_aed_non_resident;
	}
	public BigDecimal getR13_nos_ccy_non_resident() {
		return r13_nos_ccy_non_resident;
	}
	public void setR13_nos_ccy_non_resident(BigDecimal r13_nos_ccy_non_resident) {
		this.r13_nos_ccy_non_resident = r13_nos_ccy_non_resident;
	}
	public BigDecimal getR13_amount_ccy_non_resident() {
		return r13_amount_ccy_non_resident;
	}
	public void setR13_amount_ccy_non_resident(BigDecimal r13_amount_ccy_non_resident) {
		this.r13_amount_ccy_non_resident = r13_amount_ccy_non_resident;
	}
	public String getR14_uae_nationals4() {
		return r14_uae_nationals4;
	}
	public void setR14_uae_nationals4(String r14_uae_nationals4) {
		this.r14_uae_nationals4 = r14_uae_nationals4;
	}
	public BigDecimal getR14_nos_aed_resident() {
		return r14_nos_aed_resident;
	}
	public void setR14_nos_aed_resident(BigDecimal r14_nos_aed_resident) {
		this.r14_nos_aed_resident = r14_nos_aed_resident;
	}
	public BigDecimal getR14_amount_aed_resident() {
		return r14_amount_aed_resident;
	}
	public void setR14_amount_aed_resident(BigDecimal r14_amount_aed_resident) {
		this.r14_amount_aed_resident = r14_amount_aed_resident;
	}
	public BigDecimal getR14_nos_ccy_resident() {
		return r14_nos_ccy_resident;
	}
	public void setR14_nos_ccy_resident(BigDecimal r14_nos_ccy_resident) {
		this.r14_nos_ccy_resident = r14_nos_ccy_resident;
	}
	public BigDecimal getR14_amount_ccy_resident() {
		return r14_amount_ccy_resident;
	}
	public void setR14_amount_ccy_resident(BigDecimal r14_amount_ccy_resident) {
		this.r14_amount_ccy_resident = r14_amount_ccy_resident;
	}
	public BigDecimal getR14_nos_aed_non_resident() {
		return r14_nos_aed_non_resident;
	}
	public void setR14_nos_aed_non_resident(BigDecimal r14_nos_aed_non_resident) {
		this.r14_nos_aed_non_resident = r14_nos_aed_non_resident;
	}
	public BigDecimal getR14_amount_aed_non_resident() {
		return r14_amount_aed_non_resident;
	}
	public void setR14_amount_aed_non_resident(BigDecimal r14_amount_aed_non_resident) {
		this.r14_amount_aed_non_resident = r14_amount_aed_non_resident;
	}
	public BigDecimal getR14_nos_ccy_non_resident() {
		return r14_nos_ccy_non_resident;
	}
	public void setR14_nos_ccy_non_resident(BigDecimal r14_nos_ccy_non_resident) {
		this.r14_nos_ccy_non_resident = r14_nos_ccy_non_resident;
	}
	public BigDecimal getR14_amount_ccy_non_resident() {
		return r14_amount_ccy_non_resident;
	}
	public void setR14_amount_ccy_non_resident(BigDecimal r14_amount_ccy_non_resident) {
		this.r14_amount_ccy_non_resident = r14_amount_ccy_non_resident;
	}
	public String getR15_uae_nationals5() {
		return r15_uae_nationals5;
	}
	public void setR15_uae_nationals5(String r15_uae_nationals5) {
		this.r15_uae_nationals5 = r15_uae_nationals5;
	}
	public BigDecimal getR15_nos_aed_resident() {
		return r15_nos_aed_resident;
	}
	public void setR15_nos_aed_resident(BigDecimal r15_nos_aed_resident) {
		this.r15_nos_aed_resident = r15_nos_aed_resident;
	}
	public BigDecimal getR15_amount_aed_resident() {
		return r15_amount_aed_resident;
	}
	public void setR15_amount_aed_resident(BigDecimal r15_amount_aed_resident) {
		this.r15_amount_aed_resident = r15_amount_aed_resident;
	}
	public BigDecimal getR15_nos_ccy_resident() {
		return r15_nos_ccy_resident;
	}
	public void setR15_nos_ccy_resident(BigDecimal r15_nos_ccy_resident) {
		this.r15_nos_ccy_resident = r15_nos_ccy_resident;
	}
	public BigDecimal getR15_amount_ccy_resident() {
		return r15_amount_ccy_resident;
	}
	public void setR15_amount_ccy_resident(BigDecimal r15_amount_ccy_resident) {
		this.r15_amount_ccy_resident = r15_amount_ccy_resident;
	}
	public BigDecimal getR15_nos_aed_non_resident() {
		return r15_nos_aed_non_resident;
	}
	public void setR15_nos_aed_non_resident(BigDecimal r15_nos_aed_non_resident) {
		this.r15_nos_aed_non_resident = r15_nos_aed_non_resident;
	}
	public BigDecimal getR15_amount_aed_non_resident() {
		return r15_amount_aed_non_resident;
	}
	public void setR15_amount_aed_non_resident(BigDecimal r15_amount_aed_non_resident) {
		this.r15_amount_aed_non_resident = r15_amount_aed_non_resident;
	}
	public BigDecimal getR15_nos_ccy_non_resident() {
		return r15_nos_ccy_non_resident;
	}
	public void setR15_nos_ccy_non_resident(BigDecimal r15_nos_ccy_non_resident) {
		this.r15_nos_ccy_non_resident = r15_nos_ccy_non_resident;
	}
	public BigDecimal getR15_amount_ccy_non_resident() {
		return r15_amount_ccy_non_resident;
	}
	public void setR15_amount_ccy_non_resident(BigDecimal r15_amount_ccy_non_resident) {
		this.r15_amount_ccy_non_resident = r15_amount_ccy_non_resident;
	}
	public String getR16_uae_nationals6() {
		return r16_uae_nationals6;
	}
	public void setR16_uae_nationals6(String r16_uae_nationals6) {
		this.r16_uae_nationals6 = r16_uae_nationals6;
	}
	public BigDecimal getR16_nos_aed_resident() {
		return r16_nos_aed_resident;
	}
	public void setR16_nos_aed_resident(BigDecimal r16_nos_aed_resident) {
		this.r16_nos_aed_resident = r16_nos_aed_resident;
	}
	public BigDecimal getR16_amount_aed_resident() {
		return r16_amount_aed_resident;
	}
	public void setR16_amount_aed_resident(BigDecimal r16_amount_aed_resident) {
		this.r16_amount_aed_resident = r16_amount_aed_resident;
	}
	public BigDecimal getR16_nos_ccy_resident() {
		return r16_nos_ccy_resident;
	}
	public void setR16_nos_ccy_resident(BigDecimal r16_nos_ccy_resident) {
		this.r16_nos_ccy_resident = r16_nos_ccy_resident;
	}
	public BigDecimal getR16_amount_ccy_resident() {
		return r16_amount_ccy_resident;
	}
	public void setR16_amount_ccy_resident(BigDecimal r16_amount_ccy_resident) {
		this.r16_amount_ccy_resident = r16_amount_ccy_resident;
	}
	public BigDecimal getR16_nos_aed_non_resident() {
		return r16_nos_aed_non_resident;
	}
	public void setR16_nos_aed_non_resident(BigDecimal r16_nos_aed_non_resident) {
		this.r16_nos_aed_non_resident = r16_nos_aed_non_resident;
	}
	public BigDecimal getR16_amount_aed_non_resident() {
		return r16_amount_aed_non_resident;
	}
	public void setR16_amount_aed_non_resident(BigDecimal r16_amount_aed_non_resident) {
		this.r16_amount_aed_non_resident = r16_amount_aed_non_resident;
	}
	public BigDecimal getR16_nos_ccy_non_resident() {
		return r16_nos_ccy_non_resident;
	}
	public void setR16_nos_ccy_non_resident(BigDecimal r16_nos_ccy_non_resident) {
		this.r16_nos_ccy_non_resident = r16_nos_ccy_non_resident;
	}
	public BigDecimal getR16_amount_ccy_non_resident() {
		return r16_amount_ccy_non_resident;
	}
	public void setR16_amount_ccy_non_resident(BigDecimal r16_amount_ccy_non_resident) {
		this.r16_amount_ccy_non_resident = r16_amount_ccy_non_resident;
	}
	public String getR17_uae_nationals7() {
		return r17_uae_nationals7;
	}
	public void setR17_uae_nationals7(String r17_uae_nationals7) {
		this.r17_uae_nationals7 = r17_uae_nationals7;
	}
	public BigDecimal getR17_nos_aed_resident() {
		return r17_nos_aed_resident;
	}
	public void setR17_nos_aed_resident(BigDecimal r17_nos_aed_resident) {
		this.r17_nos_aed_resident = r17_nos_aed_resident;
	}
	public BigDecimal getR17_amount_aed_resident() {
		return r17_amount_aed_resident;
	}
	public void setR17_amount_aed_resident(BigDecimal r17_amount_aed_resident) {
		this.r17_amount_aed_resident = r17_amount_aed_resident;
	}
	public BigDecimal getR17_nos_ccy_resident() {
		return r17_nos_ccy_resident;
	}
	public void setR17_nos_ccy_resident(BigDecimal r17_nos_ccy_resident) {
		this.r17_nos_ccy_resident = r17_nos_ccy_resident;
	}
	public BigDecimal getR17_amount_ccy_resident() {
		return r17_amount_ccy_resident;
	}
	public void setR17_amount_ccy_resident(BigDecimal r17_amount_ccy_resident) {
		this.r17_amount_ccy_resident = r17_amount_ccy_resident;
	}
	public BigDecimal getR17_nos_aed_non_resident() {
		return r17_nos_aed_non_resident;
	}
	public void setR17_nos_aed_non_resident(BigDecimal r17_nos_aed_non_resident) {
		this.r17_nos_aed_non_resident = r17_nos_aed_non_resident;
	}
	public BigDecimal getR17_amount_aed_non_resident() {
		return r17_amount_aed_non_resident;
	}
	public void setR17_amount_aed_non_resident(BigDecimal r17_amount_aed_non_resident) {
		this.r17_amount_aed_non_resident = r17_amount_aed_non_resident;
	}
	public BigDecimal getR17_nos_ccy_non_resident() {
		return r17_nos_ccy_non_resident;
	}
	public void setR17_nos_ccy_non_resident(BigDecimal r17_nos_ccy_non_resident) {
		this.r17_nos_ccy_non_resident = r17_nos_ccy_non_resident;
	}
	public BigDecimal getR17_amount_ccy_non_resident() {
		return r17_amount_ccy_non_resident;
	}
	public void setR17_amount_ccy_non_resident(BigDecimal r17_amount_ccy_non_resident) {
		this.r17_amount_ccy_non_resident = r17_amount_ccy_non_resident;
	}
	public String getR18_uae_nationals8() {
		return r18_uae_nationals8;
	}
	public void setR18_uae_nationals8(String r18_uae_nationals8) {
		this.r18_uae_nationals8 = r18_uae_nationals8;
	}
	public BigDecimal getR18_nos_aed_resident() {
		return r18_nos_aed_resident;
	}
	public void setR18_nos_aed_resident(BigDecimal r18_nos_aed_resident) {
		this.r18_nos_aed_resident = r18_nos_aed_resident;
	}
	public BigDecimal getR18_amount_aed_resident() {
		return r18_amount_aed_resident;
	}
	public void setR18_amount_aed_resident(BigDecimal r18_amount_aed_resident) {
		this.r18_amount_aed_resident = r18_amount_aed_resident;
	}
	public BigDecimal getR18_nos_ccy_resident() {
		return r18_nos_ccy_resident;
	}
	public void setR18_nos_ccy_resident(BigDecimal r18_nos_ccy_resident) {
		this.r18_nos_ccy_resident = r18_nos_ccy_resident;
	}
	public BigDecimal getR18_amount_ccy_resident() {
		return r18_amount_ccy_resident;
	}
	public void setR18_amount_ccy_resident(BigDecimal r18_amount_ccy_resident) {
		this.r18_amount_ccy_resident = r18_amount_ccy_resident;
	}
	public BigDecimal getR18_nos_aed_non_resident() {
		return r18_nos_aed_non_resident;
	}
	public void setR18_nos_aed_non_resident(BigDecimal r18_nos_aed_non_resident) {
		this.r18_nos_aed_non_resident = r18_nos_aed_non_resident;
	}
	public BigDecimal getR18_amount_aed_non_resident() {
		return r18_amount_aed_non_resident;
	}
	public void setR18_amount_aed_non_resident(BigDecimal r18_amount_aed_non_resident) {
		this.r18_amount_aed_non_resident = r18_amount_aed_non_resident;
	}
	public BigDecimal getR18_nos_ccy_non_resident() {
		return r18_nos_ccy_non_resident;
	}
	public void setR18_nos_ccy_non_resident(BigDecimal r18_nos_ccy_non_resident) {
		this.r18_nos_ccy_non_resident = r18_nos_ccy_non_resident;
	}
	public BigDecimal getR18_amount_ccy_non_resident() {
		return r18_amount_ccy_non_resident;
	}
	public void setR18_amount_ccy_non_resident(BigDecimal r18_amount_ccy_non_resident) {
		this.r18_amount_ccy_non_resident = r18_amount_ccy_non_resident;
	}
	public String getR19_uae_nationals9() {
		return r19_uae_nationals9;
	}
	public void setR19_uae_nationals9(String r19_uae_nationals9) {
		this.r19_uae_nationals9 = r19_uae_nationals9;
	}
	public BigDecimal getR19_nos_aed_resident() {
		return r19_nos_aed_resident;
	}
	public void setR19_nos_aed_resident(BigDecimal r19_nos_aed_resident) {
		this.r19_nos_aed_resident = r19_nos_aed_resident;
	}
	public BigDecimal getR19_amount_aed_resident() {
		return r19_amount_aed_resident;
	}
	public void setR19_amount_aed_resident(BigDecimal r19_amount_aed_resident) {
		this.r19_amount_aed_resident = r19_amount_aed_resident;
	}
	public BigDecimal getR19_nos_ccy_resident() {
		return r19_nos_ccy_resident;
	}
	public void setR19_nos_ccy_resident(BigDecimal r19_nos_ccy_resident) {
		this.r19_nos_ccy_resident = r19_nos_ccy_resident;
	}
	public BigDecimal getR19_amount_ccy_resident() {
		return r19_amount_ccy_resident;
	}
	public void setR19_amount_ccy_resident(BigDecimal r19_amount_ccy_resident) {
		this.r19_amount_ccy_resident = r19_amount_ccy_resident;
	}
	public BigDecimal getR19_nos_aed_non_resident() {
		return r19_nos_aed_non_resident;
	}
	public void setR19_nos_aed_non_resident(BigDecimal r19_nos_aed_non_resident) {
		this.r19_nos_aed_non_resident = r19_nos_aed_non_resident;
	}
	public BigDecimal getR19_amount_aed_non_resident() {
		return r19_amount_aed_non_resident;
	}
	public void setR19_amount_aed_non_resident(BigDecimal r19_amount_aed_non_resident) {
		this.r19_amount_aed_non_resident = r19_amount_aed_non_resident;
	}
	public BigDecimal getR19_nos_ccy_non_resident() {
		return r19_nos_ccy_non_resident;
	}
	public void setR19_nos_ccy_non_resident(BigDecimal r19_nos_ccy_non_resident) {
		this.r19_nos_ccy_non_resident = r19_nos_ccy_non_resident;
	}
	public BigDecimal getR19_amount_ccy_non_resident() {
		return r19_amount_ccy_non_resident;
	}
	public void setR19_amount_ccy_non_resident(BigDecimal r19_amount_ccy_non_resident) {
		this.r19_amount_ccy_non_resident = r19_amount_ccy_non_resident;
	}
	public String getR20_non_uae_nationals() {
		return r20_non_uae_nationals;
	}
	public void setR20_non_uae_nationals(String r20_non_uae_nationals) {
		this.r20_non_uae_nationals = r20_non_uae_nationals;
	}
	public BigDecimal getR20_nos_aed_resident() {
		return r20_nos_aed_resident;
	}
	public void setR20_nos_aed_resident(BigDecimal r20_nos_aed_resident) {
		this.r20_nos_aed_resident = r20_nos_aed_resident;
	}
	public BigDecimal getR20_amount_aed_resident() {
		return r20_amount_aed_resident;
	}
	public void setR20_amount_aed_resident(BigDecimal r20_amount_aed_resident) {
		this.r20_amount_aed_resident = r20_amount_aed_resident;
	}
	public BigDecimal getR20_nos_ccy_resident() {
		return r20_nos_ccy_resident;
	}
	public void setR20_nos_ccy_resident(BigDecimal r20_nos_ccy_resident) {
		this.r20_nos_ccy_resident = r20_nos_ccy_resident;
	}
	public BigDecimal getR20_amount_ccy_resident() {
		return r20_amount_ccy_resident;
	}
	public void setR20_amount_ccy_resident(BigDecimal r20_amount_ccy_resident) {
		this.r20_amount_ccy_resident = r20_amount_ccy_resident;
	}
	public BigDecimal getR20_nos_aed_non_resident() {
		return r20_nos_aed_non_resident;
	}
	public void setR20_nos_aed_non_resident(BigDecimal r20_nos_aed_non_resident) {
		this.r20_nos_aed_non_resident = r20_nos_aed_non_resident;
	}
	public BigDecimal getR20_amount_aed_non_resident() {
		return r20_amount_aed_non_resident;
	}
	public void setR20_amount_aed_non_resident(BigDecimal r20_amount_aed_non_resident) {
		this.r20_amount_aed_non_resident = r20_amount_aed_non_resident;
	}
	public BigDecimal getR20_nos_ccy_non_resident() {
		return r20_nos_ccy_non_resident;
	}
	public void setR20_nos_ccy_non_resident(BigDecimal r20_nos_ccy_non_resident) {
		this.r20_nos_ccy_non_resident = r20_nos_ccy_non_resident;
	}
	public BigDecimal getR20_amount_ccy_non_resident() {
		return r20_amount_ccy_non_resident;
	}
	public void setR20_amount_ccy_non_resident(BigDecimal r20_amount_ccy_non_resident) {
		this.r20_amount_ccy_non_resident = r20_amount_ccy_non_resident;
	}
	public String getR21_non_uae_nationals1() {
		return r21_non_uae_nationals1;
	}
	public void setR21_non_uae_nationals1(String r21_non_uae_nationals1) {
		this.r21_non_uae_nationals1 = r21_non_uae_nationals1;
	}
	public BigDecimal getR21_nos_aed_resident() {
		return r21_nos_aed_resident;
	}
	public void setR21_nos_aed_resident(BigDecimal r21_nos_aed_resident) {
		this.r21_nos_aed_resident = r21_nos_aed_resident;
	}
	public BigDecimal getR21_amount_aed_resident() {
		return r21_amount_aed_resident;
	}
	public void setR21_amount_aed_resident(BigDecimal r21_amount_aed_resident) {
		this.r21_amount_aed_resident = r21_amount_aed_resident;
	}
	public BigDecimal getR21_nos_ccy_resident() {
		return r21_nos_ccy_resident;
	}
	public void setR21_nos_ccy_resident(BigDecimal r21_nos_ccy_resident) {
		this.r21_nos_ccy_resident = r21_nos_ccy_resident;
	}
	public BigDecimal getR21_amount_ccy_resident() {
		return r21_amount_ccy_resident;
	}
	public void setR21_amount_ccy_resident(BigDecimal r21_amount_ccy_resident) {
		this.r21_amount_ccy_resident = r21_amount_ccy_resident;
	}
	public BigDecimal getR21_nos_aed_non_resident() {
		return r21_nos_aed_non_resident;
	}
	public void setR21_nos_aed_non_resident(BigDecimal r21_nos_aed_non_resident) {
		this.r21_nos_aed_non_resident = r21_nos_aed_non_resident;
	}
	public BigDecimal getR21_amount_aed_non_resident() {
		return r21_amount_aed_non_resident;
	}
	public void setR21_amount_aed_non_resident(BigDecimal r21_amount_aed_non_resident) {
		this.r21_amount_aed_non_resident = r21_amount_aed_non_resident;
	}
	public BigDecimal getR21_nos_ccy_non_resident() {
		return r21_nos_ccy_non_resident;
	}
	public void setR21_nos_ccy_non_resident(BigDecimal r21_nos_ccy_non_resident) {
		this.r21_nos_ccy_non_resident = r21_nos_ccy_non_resident;
	}
	public BigDecimal getR21_amount_ccy_non_resident() {
		return r21_amount_ccy_non_resident;
	}
	public void setR21_amount_ccy_non_resident(BigDecimal r21_amount_ccy_non_resident) {
		this.r21_amount_ccy_non_resident = r21_amount_ccy_non_resident;
	}
	public String getR22_non_uae_nationals2() {
		return r22_non_uae_nationals2;
	}
	public void setR22_non_uae_nationals2(String r22_non_uae_nationals2) {
		this.r22_non_uae_nationals2 = r22_non_uae_nationals2;
	}
	public BigDecimal getR22_nos_aed_resident() {
		return r22_nos_aed_resident;
	}
	public void setR22_nos_aed_resident(BigDecimal r22_nos_aed_resident) {
		this.r22_nos_aed_resident = r22_nos_aed_resident;
	}
	public BigDecimal getR22_amount_aed_resident() {
		return r22_amount_aed_resident;
	}
	public void setR22_amount_aed_resident(BigDecimal r22_amount_aed_resident) {
		this.r22_amount_aed_resident = r22_amount_aed_resident;
	}
	public BigDecimal getR22_nos_ccy_resident() {
		return r22_nos_ccy_resident;
	}
	public void setR22_nos_ccy_resident(BigDecimal r22_nos_ccy_resident) {
		this.r22_nos_ccy_resident = r22_nos_ccy_resident;
	}
	public BigDecimal getR22_amount_ccy_resident() {
		return r22_amount_ccy_resident;
	}
	public void setR22_amount_ccy_resident(BigDecimal r22_amount_ccy_resident) {
		this.r22_amount_ccy_resident = r22_amount_ccy_resident;
	}
	public BigDecimal getR22_nos_aed_non_resident() {
		return r22_nos_aed_non_resident;
	}
	public void setR22_nos_aed_non_resident(BigDecimal r22_nos_aed_non_resident) {
		this.r22_nos_aed_non_resident = r22_nos_aed_non_resident;
	}
	public BigDecimal getR22_amount_aed_non_resident() {
		return r22_amount_aed_non_resident;
	}
	public void setR22_amount_aed_non_resident(BigDecimal r22_amount_aed_non_resident) {
		this.r22_amount_aed_non_resident = r22_amount_aed_non_resident;
	}
	public BigDecimal getR22_nos_ccy_non_resident() {
		return r22_nos_ccy_non_resident;
	}
	public void setR22_nos_ccy_non_resident(BigDecimal r22_nos_ccy_non_resident) {
		this.r22_nos_ccy_non_resident = r22_nos_ccy_non_resident;
	}
	public BigDecimal getR22_amount_ccy_non_resident() {
		return r22_amount_ccy_non_resident;
	}
	public void setR22_amount_ccy_non_resident(BigDecimal r22_amount_ccy_non_resident) {
		this.r22_amount_ccy_non_resident = r22_amount_ccy_non_resident;
	}
	public String getR23_non_uae_nationals3() {
		return r23_non_uae_nationals3;
	}
	public void setR23_non_uae_nationals3(String r23_non_uae_nationals3) {
		this.r23_non_uae_nationals3 = r23_non_uae_nationals3;
	}
	public BigDecimal getR23_nos_aed_resident() {
		return r23_nos_aed_resident;
	}
	public void setR23_nos_aed_resident(BigDecimal r23_nos_aed_resident) {
		this.r23_nos_aed_resident = r23_nos_aed_resident;
	}
	public BigDecimal getR23_amount_aed_resident() {
		return r23_amount_aed_resident;
	}
	public void setR23_amount_aed_resident(BigDecimal r23_amount_aed_resident) {
		this.r23_amount_aed_resident = r23_amount_aed_resident;
	}
	public BigDecimal getR23_nos_ccy_resident() {
		return r23_nos_ccy_resident;
	}
	public void setR23_nos_ccy_resident(BigDecimal r23_nos_ccy_resident) {
		this.r23_nos_ccy_resident = r23_nos_ccy_resident;
	}
	public BigDecimal getR23_amount_ccy_resident() {
		return r23_amount_ccy_resident;
	}
	public void setR23_amount_ccy_resident(BigDecimal r23_amount_ccy_resident) {
		this.r23_amount_ccy_resident = r23_amount_ccy_resident;
	}
	public BigDecimal getR23_nos_aed_non_resident() {
		return r23_nos_aed_non_resident;
	}
	public void setR23_nos_aed_non_resident(BigDecimal r23_nos_aed_non_resident) {
		this.r23_nos_aed_non_resident = r23_nos_aed_non_resident;
	}
	public BigDecimal getR23_amount_aed_non_resident() {
		return r23_amount_aed_non_resident;
	}
	public void setR23_amount_aed_non_resident(BigDecimal r23_amount_aed_non_resident) {
		this.r23_amount_aed_non_resident = r23_amount_aed_non_resident;
	}
	public BigDecimal getR23_nos_ccy_non_resident() {
		return r23_nos_ccy_non_resident;
	}
	public void setR23_nos_ccy_non_resident(BigDecimal r23_nos_ccy_non_resident) {
		this.r23_nos_ccy_non_resident = r23_nos_ccy_non_resident;
	}
	public BigDecimal getR23_amount_ccy_non_resident() {
		return r23_amount_ccy_non_resident;
	}
	public void setR23_amount_ccy_non_resident(BigDecimal r23_amount_ccy_non_resident) {
		this.r23_amount_ccy_non_resident = r23_amount_ccy_non_resident;
	}
	public String getR24_non_uae_nationals4() {
		return r24_non_uae_nationals4;
	}
	public void setR24_non_uae_nationals4(String r24_non_uae_nationals4) {
		this.r24_non_uae_nationals4 = r24_non_uae_nationals4;
	}
	public BigDecimal getR24_nos_aed_resident() {
		return r24_nos_aed_resident;
	}
	public void setR24_nos_aed_resident(BigDecimal r24_nos_aed_resident) {
		this.r24_nos_aed_resident = r24_nos_aed_resident;
	}
	public BigDecimal getR24_amount_aed_resident() {
		return r24_amount_aed_resident;
	}
	public void setR24_amount_aed_resident(BigDecimal r24_amount_aed_resident) {
		this.r24_amount_aed_resident = r24_amount_aed_resident;
	}
	public BigDecimal getR24_nos_ccy_resident() {
		return r24_nos_ccy_resident;
	}
	public void setR24_nos_ccy_resident(BigDecimal r24_nos_ccy_resident) {
		this.r24_nos_ccy_resident = r24_nos_ccy_resident;
	}
	public BigDecimal getR24_amount_ccy_resident() {
		return r24_amount_ccy_resident;
	}
	public void setR24_amount_ccy_resident(BigDecimal r24_amount_ccy_resident) {
		this.r24_amount_ccy_resident = r24_amount_ccy_resident;
	}
	public BigDecimal getR24_nos_aed_non_resident() {
		return r24_nos_aed_non_resident;
	}
	public void setR24_nos_aed_non_resident(BigDecimal r24_nos_aed_non_resident) {
		this.r24_nos_aed_non_resident = r24_nos_aed_non_resident;
	}
	public BigDecimal getR24_amount_aed_non_resident() {
		return r24_amount_aed_non_resident;
	}
	public void setR24_amount_aed_non_resident(BigDecimal r24_amount_aed_non_resident) {
		this.r24_amount_aed_non_resident = r24_amount_aed_non_resident;
	}
	public BigDecimal getR24_nos_ccy_non_resident() {
		return r24_nos_ccy_non_resident;
	}
	public void setR24_nos_ccy_non_resident(BigDecimal r24_nos_ccy_non_resident) {
		this.r24_nos_ccy_non_resident = r24_nos_ccy_non_resident;
	}
	public BigDecimal getR24_amount_ccy_non_resident() {
		return r24_amount_ccy_non_resident;
	}
	public void setR24_amount_ccy_non_resident(BigDecimal r24_amount_ccy_non_resident) {
		this.r24_amount_ccy_non_resident = r24_amount_ccy_non_resident;
	}
	public String getR25_non_uae_nationals5() {
		return r25_non_uae_nationals5;
	}
	public void setR25_non_uae_nationals5(String r25_non_uae_nationals5) {
		this.r25_non_uae_nationals5 = r25_non_uae_nationals5;
	}
	public BigDecimal getR25_nos_aed_resident() {
		return r25_nos_aed_resident;
	}
	public void setR25_nos_aed_resident(BigDecimal r25_nos_aed_resident) {
		this.r25_nos_aed_resident = r25_nos_aed_resident;
	}
	public BigDecimal getR25_amount_aed_resident() {
		return r25_amount_aed_resident;
	}
	public void setR25_amount_aed_resident(BigDecimal r25_amount_aed_resident) {
		this.r25_amount_aed_resident = r25_amount_aed_resident;
	}
	public BigDecimal getR25_nos_ccy_resident() {
		return r25_nos_ccy_resident;
	}
	public void setR25_nos_ccy_resident(BigDecimal r25_nos_ccy_resident) {
		this.r25_nos_ccy_resident = r25_nos_ccy_resident;
	}
	public BigDecimal getR25_amount_ccy_resident() {
		return r25_amount_ccy_resident;
	}
	public void setR25_amount_ccy_resident(BigDecimal r25_amount_ccy_resident) {
		this.r25_amount_ccy_resident = r25_amount_ccy_resident;
	}
	public BigDecimal getR25_nos_aed_non_resident() {
		return r25_nos_aed_non_resident;
	}
	public void setR25_nos_aed_non_resident(BigDecimal r25_nos_aed_non_resident) {
		this.r25_nos_aed_non_resident = r25_nos_aed_non_resident;
	}
	public BigDecimal getR25_amount_aed_non_resident() {
		return r25_amount_aed_non_resident;
	}
	public void setR25_amount_aed_non_resident(BigDecimal r25_amount_aed_non_resident) {
		this.r25_amount_aed_non_resident = r25_amount_aed_non_resident;
	}
	public BigDecimal getR25_nos_ccy_non_resident() {
		return r25_nos_ccy_non_resident;
	}
	public void setR25_nos_ccy_non_resident(BigDecimal r25_nos_ccy_non_resident) {
		this.r25_nos_ccy_non_resident = r25_nos_ccy_non_resident;
	}
	public BigDecimal getR25_amount_ccy_non_resident() {
		return r25_amount_ccy_non_resident;
	}
	public void setR25_amount_ccy_non_resident(BigDecimal r25_amount_ccy_non_resident) {
		this.r25_amount_ccy_non_resident = r25_amount_ccy_non_resident;
	}
	public String getR26_non_uae_nationals6() {
		return r26_non_uae_nationals6;
	}
	public void setR26_non_uae_nationals6(String r26_non_uae_nationals6) {
		this.r26_non_uae_nationals6 = r26_non_uae_nationals6;
	}
	public BigDecimal getR26_nos_aed_resident() {
		return r26_nos_aed_resident;
	}
	public void setR26_nos_aed_resident(BigDecimal r26_nos_aed_resident) {
		this.r26_nos_aed_resident = r26_nos_aed_resident;
	}
	public BigDecimal getR26_amount_aed_resident() {
		return r26_amount_aed_resident;
	}
	public void setR26_amount_aed_resident(BigDecimal r26_amount_aed_resident) {
		this.r26_amount_aed_resident = r26_amount_aed_resident;
	}
	public BigDecimal getR26_nos_ccy_resident() {
		return r26_nos_ccy_resident;
	}
	public void setR26_nos_ccy_resident(BigDecimal r26_nos_ccy_resident) {
		this.r26_nos_ccy_resident = r26_nos_ccy_resident;
	}
	public BigDecimal getR26_amount_ccy_resident() {
		return r26_amount_ccy_resident;
	}
	public void setR26_amount_ccy_resident(BigDecimal r26_amount_ccy_resident) {
		this.r26_amount_ccy_resident = r26_amount_ccy_resident;
	}
	public BigDecimal getR26_nos_aed_non_resident() {
		return r26_nos_aed_non_resident;
	}
	public void setR26_nos_aed_non_resident(BigDecimal r26_nos_aed_non_resident) {
		this.r26_nos_aed_non_resident = r26_nos_aed_non_resident;
	}
	public BigDecimal getR26_amount_aed_non_resident() {
		return r26_amount_aed_non_resident;
	}
	public void setR26_amount_aed_non_resident(BigDecimal r26_amount_aed_non_resident) {
		this.r26_amount_aed_non_resident = r26_amount_aed_non_resident;
	}
	public BigDecimal getR26_nos_ccy_non_resident() {
		return r26_nos_ccy_non_resident;
	}
	public void setR26_nos_ccy_non_resident(BigDecimal r26_nos_ccy_non_resident) {
		this.r26_nos_ccy_non_resident = r26_nos_ccy_non_resident;
	}
	public BigDecimal getR26_amount_ccy_non_resident() {
		return r26_amount_ccy_non_resident;
	}
	public void setR26_amount_ccy_non_resident(BigDecimal r26_amount_ccy_non_resident) {
		this.r26_amount_ccy_non_resident = r26_amount_ccy_non_resident;
	}
	public String getR27_non_uae_nationals7() {
		return r27_non_uae_nationals7;
	}
	public void setR27_non_uae_nationals7(String r27_non_uae_nationals7) {
		this.r27_non_uae_nationals7 = r27_non_uae_nationals7;
	}
	public BigDecimal getR27_nos_aed_resident() {
		return r27_nos_aed_resident;
	}
	public void setR27_nos_aed_resident(BigDecimal r27_nos_aed_resident) {
		this.r27_nos_aed_resident = r27_nos_aed_resident;
	}
	public BigDecimal getR27_amount_aed_resident() {
		return r27_amount_aed_resident;
	}
	public void setR27_amount_aed_resident(BigDecimal r27_amount_aed_resident) {
		this.r27_amount_aed_resident = r27_amount_aed_resident;
	}
	public BigDecimal getR27_nos_ccy_resident() {
		return r27_nos_ccy_resident;
	}
	public void setR27_nos_ccy_resident(BigDecimal r27_nos_ccy_resident) {
		this.r27_nos_ccy_resident = r27_nos_ccy_resident;
	}
	public BigDecimal getR27_amount_ccy_resident() {
		return r27_amount_ccy_resident;
	}
	public void setR27_amount_ccy_resident(BigDecimal r27_amount_ccy_resident) {
		this.r27_amount_ccy_resident = r27_amount_ccy_resident;
	}
	public BigDecimal getR27_nos_aed_non_resident() {
		return r27_nos_aed_non_resident;
	}
	public void setR27_nos_aed_non_resident(BigDecimal r27_nos_aed_non_resident) {
		this.r27_nos_aed_non_resident = r27_nos_aed_non_resident;
	}
	public BigDecimal getR27_amount_aed_non_resident() {
		return r27_amount_aed_non_resident;
	}
	public void setR27_amount_aed_non_resident(BigDecimal r27_amount_aed_non_resident) {
		this.r27_amount_aed_non_resident = r27_amount_aed_non_resident;
	}
	public BigDecimal getR27_nos_ccy_non_resident() {
		return r27_nos_ccy_non_resident;
	}
	public void setR27_nos_ccy_non_resident(BigDecimal r27_nos_ccy_non_resident) {
		this.r27_nos_ccy_non_resident = r27_nos_ccy_non_resident;
	}
	public BigDecimal getR27_amount_ccy_non_resident() {
		return r27_amount_ccy_non_resident;
	}
	public void setR27_amount_ccy_non_resident(BigDecimal r27_amount_ccy_non_resident) {
		this.r27_amount_ccy_non_resident = r27_amount_ccy_non_resident;
	}
	public String getR28_non_uae_nationals8() {
		return r28_non_uae_nationals8;
	}
	public void setR28_non_uae_nationals8(String r28_non_uae_nationals8) {
		this.r28_non_uae_nationals8 = r28_non_uae_nationals8;
	}
	public BigDecimal getR28_nos_aed_resident() {
		return r28_nos_aed_resident;
	}
	public void setR28_nos_aed_resident(BigDecimal r28_nos_aed_resident) {
		this.r28_nos_aed_resident = r28_nos_aed_resident;
	}
	public BigDecimal getR28_amount_aed_resident() {
		return r28_amount_aed_resident;
	}
	public void setR28_amount_aed_resident(BigDecimal r28_amount_aed_resident) {
		this.r28_amount_aed_resident = r28_amount_aed_resident;
	}
	public BigDecimal getR28_nos_ccy_resident() {
		return r28_nos_ccy_resident;
	}
	public void setR28_nos_ccy_resident(BigDecimal r28_nos_ccy_resident) {
		this.r28_nos_ccy_resident = r28_nos_ccy_resident;
	}
	public BigDecimal getR28_amount_ccy_resident() {
		return r28_amount_ccy_resident;
	}
	public void setR28_amount_ccy_resident(BigDecimal r28_amount_ccy_resident) {
		this.r28_amount_ccy_resident = r28_amount_ccy_resident;
	}
	public BigDecimal getR28_nos_aed_non_resident() {
		return r28_nos_aed_non_resident;
	}
	public void setR28_nos_aed_non_resident(BigDecimal r28_nos_aed_non_resident) {
		this.r28_nos_aed_non_resident = r28_nos_aed_non_resident;
	}
	public BigDecimal getR28_amount_aed_non_resident() {
		return r28_amount_aed_non_resident;
	}
	public void setR28_amount_aed_non_resident(BigDecimal r28_amount_aed_non_resident) {
		this.r28_amount_aed_non_resident = r28_amount_aed_non_resident;
	}
	public BigDecimal getR28_nos_ccy_non_resident() {
		return r28_nos_ccy_non_resident;
	}
	public void setR28_nos_ccy_non_resident(BigDecimal r28_nos_ccy_non_resident) {
		this.r28_nos_ccy_non_resident = r28_nos_ccy_non_resident;
	}
	public BigDecimal getR28_amount_ccy_non_resident() {
		return r28_amount_ccy_non_resident;
	}
	public void setR28_amount_ccy_non_resident(BigDecimal r28_amount_ccy_non_resident) {
		this.r28_amount_ccy_non_resident = r28_amount_ccy_non_resident;
	}
	public String getR29_grand_total() {
		return r29_grand_total;
	}
	public void setR29_grand_total(String r29_grand_total) {
		this.r29_grand_total = r29_grand_total;
	}
	public BigDecimal getR29_nos_aed_resident() {
		return r29_nos_aed_resident;
	}
	public void setR29_nos_aed_resident(BigDecimal r29_nos_aed_resident) {
		this.r29_nos_aed_resident = r29_nos_aed_resident;
	}
	public BigDecimal getR29_amount_aed_resident() {
		return r29_amount_aed_resident;
	}
	public void setR29_amount_aed_resident(BigDecimal r29_amount_aed_resident) {
		this.r29_amount_aed_resident = r29_amount_aed_resident;
	}
	public BigDecimal getR29_nos_ccy_resident() {
		return r29_nos_ccy_resident;
	}
	public void setR29_nos_ccy_resident(BigDecimal r29_nos_ccy_resident) {
		this.r29_nos_ccy_resident = r29_nos_ccy_resident;
	}
	public BigDecimal getR29_amount_ccy_resident() {
		return r29_amount_ccy_resident;
	}
	public void setR29_amount_ccy_resident(BigDecimal r29_amount_ccy_resident) {
		this.r29_amount_ccy_resident = r29_amount_ccy_resident;
	}
	public BigDecimal getR29_nos_aed_non_resident() {
		return r29_nos_aed_non_resident;
	}
	public void setR29_nos_aed_non_resident(BigDecimal r29_nos_aed_non_resident) {
		this.r29_nos_aed_non_resident = r29_nos_aed_non_resident;
	}
	public BigDecimal getR29_amount_aed_non_resident() {
		return r29_amount_aed_non_resident;
	}
	public void setR29_amount_aed_non_resident(BigDecimal r29_amount_aed_non_resident) {
		this.r29_amount_aed_non_resident = r29_amount_aed_non_resident;
	}
	public BigDecimal getR29_nos_ccy_non_resident() {
		return r29_nos_ccy_non_resident;
	}
	public void setR29_nos_ccy_non_resident(BigDecimal r29_nos_ccy_non_resident) {
		this.r29_nos_ccy_non_resident = r29_nos_ccy_non_resident;
	}
	public BigDecimal getR29_amount_ccy_non_resident() {
		return r29_amount_ccy_non_resident;
	}
	public void setR29_amount_ccy_non_resident(BigDecimal r29_amount_ccy_non_resident) {
		this.r29_amount_ccy_non_resident = r29_amount_ccy_non_resident;
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
	public String getReport_to_date() {
		return report_to_date;
	}
	public void setReport_to_date(String report_to_date) {
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
	public String getUae_nationals() {
		return uae_nationals;
	}
	public void setUae_nationals(String uae_nationals) {
		this.uae_nationals = uae_nationals;
	}
	public String getNos_aed_resident() {
		return nos_aed_resident;
	}
	public void setNos_aed_resident(String nos_aed_resident) {
		this.nos_aed_resident = nos_aed_resident;
	}
	public String getAmount_aed_resident() {
		return amount_aed_resident;
	}
	public void setAmount_aed_resident(String amount_aed_resident) {
		this.amount_aed_resident = amount_aed_resident;
	}
	public String getNos_ccy_resident() {
		return nos_ccy_resident;
	}
	public void setNos_ccy_resident(String nos_ccy_resident) {
		this.nos_ccy_resident = nos_ccy_resident;
	}
	public String getAmount_ccy_resident() {
		return amount_ccy_resident;
	}
	public void setAmount_ccy_resident(String amount_ccy_resident) {
		this.amount_ccy_resident = amount_ccy_resident;
	}
	public String getNos_aed_non_resident() {
		return nos_aed_non_resident;
	}
	public void setNos_aed_non_resident(String nos_aed_non_resident) {
		this.nos_aed_non_resident = nos_aed_non_resident;
	}
	public String getAmount_aed_non_resident() {
		return amount_aed_non_resident;
	}
	public void setAmount_aed_non_resident(String amount_aed_non_resident) {
		this.amount_aed_non_resident = amount_aed_non_resident;
	}
	public String getNos_ccy_non_resident() {
		return nos_ccy_non_resident;
	}
	public void setNos_ccy_non_resident(String nos_ccy_non_resident) {
		this.nos_ccy_non_resident = nos_ccy_non_resident;
	}
	public String getAmount_ccy_non_resident() {
		return amount_ccy_non_resident;
	}
	public void setAmount_ccy_non_resident(String amount_ccy_non_resident) {
		this.amount_ccy_non_resident = amount_ccy_non_resident;
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
	public BRF31_Entity() {
		super();
		// TODO Auto-generated constructor stub
	}
}