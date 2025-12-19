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
@Table(name="BRF33_SUMMARYTABLE")
public class BRF33_ENTITY{

	
	private String	r1_product_res;
	private String	r1_country;
	private BigDecimal	r1_amount;
	private String	r2_product_res;
	private String	r2_country;
	private BigDecimal	r2_amount;
	private String	r3_product_res;
	private String	r3_country;
	private BigDecimal	r3_amount;
	private String	r4_product_res;
	private String	r4_country;
	private BigDecimal	r4_amount;
	private String	r5_product_res;
	private String	r5_country;
	private BigDecimal	r5_amount;
	private String	r6_product_res;
	private String	r6_country;
	private BigDecimal	r6_amount;
	private String	r7_product_res;
	private String	r7_country;
	private BigDecimal	r7_amount;
	private String	r8_product_res;
	private String	r8_country;
	private BigDecimal	r8_amount;
	private String	r9_product_res;
	private String	r9_country;
	private BigDecimal	r9_amount;
	private String	r10_product_res;
	private String	r10_country;
	private BigDecimal	r10_amount;
	private String	r11_product_res;
	private String	r11_country;
	private BigDecimal	r11_amount;
	private String	r12_product_res;
	private String	r12_country;
	private BigDecimal	r12_amount;
	private String	r13_product_res;
	private String	r13_country;
	private BigDecimal	r13_amount;
	private String	r14_product_res;
	private String	r14_country;
	private BigDecimal	r14_amount;
	private String	r15_product_res;
	private String	r15_country;
	private BigDecimal	r15_amount;
	private String	rt_total1;
	private String	r16_product_nonres;
	private String	r16_country_dom;
	private BigDecimal	r16_amount;
	private String	r17_product_nonres;
	private String	r17_country_dom;
	private BigDecimal	r17_amount;
	private String	r18_product_nonres;
	private String	r18_country_dom;
	private BigDecimal	r18_amount;
	private String	r19_product_nonres;
	private String	r19_country_dom;
	private BigDecimal	r19_amount;
	private String	r20_product_nonres;
	private String	r20_country_dom;
	private BigDecimal	r20_amount;
	private String	r21_product_nonres;
	private String	r21_country_dom;
	private BigDecimal	r21_amount;
	private String	r22_product_nonres;
	private String	r22_country_dom;
	private BigDecimal	r22_amount;
	private String	r23_product_nonres;
	private String	r23_country_dom;
	private BigDecimal	r23_amount;
	private String	r24_product_nonres;
	private String	r24_country_dom;
	private BigDecimal	r24_amount;
	private String	r25_product_nonres;
	private String	r25_country_dom;
	private BigDecimal	r25_amount;
	private String	r26_product_nonres;
	private String	r26_country_dom;
	private BigDecimal	r26_amount;
	private String	r27_product_nonres;
	private String	r27_country_dom;
	private BigDecimal	r27_amount;
	private String	r28_product_nonres;
	private String	r28_country_dom;
	private BigDecimal	r28_amount;
	private String	r29_product_nonres;
	private String	r29_country_dom;
	private BigDecimal	r29_amount;
	private String	r30_product_nonres;
	private String	r30_country_dom;
	private BigDecimal	r30_amount;
	private BigDecimal	rt_total2;
	private String	r31_product_bor;
	private String	r31_country_ho;
	private BigDecimal	r31_amount;
	private String	r32_product_bor;
	private String	r32_country_ho;
	private BigDecimal	r32_amount;
	private String	r33_product_bor;
	private String	r33_country_ho;
	private BigDecimal	r33_amount;
	private String	r34_product_bor;
	private String	r34_country_ho;
	private BigDecimal	r34_amount;
	private String	r35_product_bor;
	private String	r35_country_ho;
	private BigDecimal	r35_amount;
	private String	r36_product_bor;
	private String	r36_country_ho;
	private BigDecimal	r36_amount;
	private String	r37_product_bor;
	private String	r37_country_ho;
	private BigDecimal	r37_amount;
	private String	r38_product_bor;
	private String	r38_country_ho;
	private BigDecimal	r38_amount;
	private String	r39_product_bor;
	private String	r39_country_ho;
	private BigDecimal	r39_amount;
	private String	r40_product_bor;
	private String	r40_country_ho;
	private BigDecimal	r40_amount;
	private String	r41_product_bor;
	private String	r41_country_ho;
	private BigDecimal	r41_amount;
	private String	r42_product_bor;
	private String	r42_country_ho;
	private BigDecimal	r42_amount;
	private String	r43_product_bor;
	private String	r43_country_ho;
	private BigDecimal	r43_amount;
	private String	r44_product_bor;
	private String	r44_country_ho;
	private BigDecimal	r44_amount;
	private String	r45_product_bor;
	private String	r45_country_ho;
	private BigDecimal	r45_amount;
	private BigDecimal	rt_total3;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Id
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
	public String getR1_product_res() {
		return r1_product_res;
	}
	public void setR1_product_res(String r1_product_res) {
		this.r1_product_res = r1_product_res;
	}
	public String getR1_country() {
		return r1_country;
	}
	public void setR1_country(String r1_country) {
		this.r1_country = r1_country;
	}
	public BigDecimal getR1_amount() {
		return r1_amount;
	}
	public void setR1_amount(BigDecimal r1_amount) {
		this.r1_amount = r1_amount;
	}
	public String getR2_product_res() {
		return r2_product_res;
	}
	public void setR2_product_res(String r2_product_res) {
		this.r2_product_res = r2_product_res;
	}
	public String getR2_country() {
		return r2_country;
	}
	public void setR2_country(String r2_country) {
		this.r2_country = r2_country;
	}
	public BigDecimal getR2_amount() {
		return r2_amount;
	}
	public void setR2_amount(BigDecimal r2_amount) {
		this.r2_amount = r2_amount;
	}
	public String getR3_product_res() {
		return r3_product_res;
	}
	public void setR3_product_res(String r3_product_res) {
		this.r3_product_res = r3_product_res;
	}
	public String getR3_country() {
		return r3_country;
	}
	public void setR3_country(String r3_country) {
		this.r3_country = r3_country;
	}
	public BigDecimal getR3_amount() {
		return r3_amount;
	}
	public void setR3_amount(BigDecimal r3_amount) {
		this.r3_amount = r3_amount;
	}
	public String getR4_product_res() {
		return r4_product_res;
	}
	public void setR4_product_res(String r4_product_res) {
		this.r4_product_res = r4_product_res;
	}
	public String getR4_country() {
		return r4_country;
	}
	public void setR4_country(String r4_country) {
		this.r4_country = r4_country;
	}
	public BigDecimal getR4_amount() {
		return r4_amount;
	}
	public void setR4_amount(BigDecimal r4_amount) {
		this.r4_amount = r4_amount;
	}
	public String getR5_product_res() {
		return r5_product_res;
	}
	public void setR5_product_res(String r5_product_res) {
		this.r5_product_res = r5_product_res;
	}
	public String getR5_country() {
		return r5_country;
	}
	public void setR5_country(String r5_country) {
		this.r5_country = r5_country;
	}
	public BigDecimal getR5_amount() {
		return r5_amount;
	}
	public void setR5_amount(BigDecimal r5_amount) {
		this.r5_amount = r5_amount;
	}
	public String getR6_product_res() {
		return r6_product_res;
	}
	public void setR6_product_res(String r6_product_res) {
		this.r6_product_res = r6_product_res;
	}
	public String getR6_country() {
		return r6_country;
	}
	public void setR6_country(String r6_country) {
		this.r6_country = r6_country;
	}
	public BigDecimal getR6_amount() {
		return r6_amount;
	}
	public void setR6_amount(BigDecimal r6_amount) {
		this.r6_amount = r6_amount;
	}
	public String getR7_product_res() {
		return r7_product_res;
	}
	public void setR7_product_res(String r7_product_res) {
		this.r7_product_res = r7_product_res;
	}
	public String getR7_country() {
		return r7_country;
	}
	public void setR7_country(String r7_country) {
		this.r7_country = r7_country;
	}
	public BigDecimal getR7_amount() {
		return r7_amount;
	}
	public void setR7_amount(BigDecimal r7_amount) {
		this.r7_amount = r7_amount;
	}
	public String getR8_product_res() {
		return r8_product_res;
	}
	public void setR8_product_res(String r8_product_res) {
		this.r8_product_res = r8_product_res;
	}
	public String getR8_country() {
		return r8_country;
	}
	public void setR8_country(String r8_country) {
		this.r8_country = r8_country;
	}
	public BigDecimal getR8_amount() {
		return r8_amount;
	}
	public void setR8_amount(BigDecimal r8_amount) {
		this.r8_amount = r8_amount;
	}
	public String getR9_product_res() {
		return r9_product_res;
	}
	public void setR9_product_res(String r9_product_res) {
		this.r9_product_res = r9_product_res;
	}
	public String getR9_country() {
		return r9_country;
	}
	public void setR9_country(String r9_country) {
		this.r9_country = r9_country;
	}
	public BigDecimal getR9_amount() {
		return r9_amount;
	}
	public void setR9_amount(BigDecimal r9_amount) {
		this.r9_amount = r9_amount;
	}
	public String getR10_product_res() {
		return r10_product_res;
	}
	public void setR10_product_res(String r10_product_res) {
		this.r10_product_res = r10_product_res;
	}
	public String getR10_country() {
		return r10_country;
	}
	public void setR10_country(String r10_country) {
		this.r10_country = r10_country;
	}
	public BigDecimal getR10_amount() {
		return r10_amount;
	}
	public void setR10_amount(BigDecimal r10_amount) {
		this.r10_amount = r10_amount;
	}
	public String getR11_product_res() {
		return r11_product_res;
	}
	public void setR11_product_res(String r11_product_res) {
		this.r11_product_res = r11_product_res;
	}
	public String getR11_country() {
		return r11_country;
	}
	public void setR11_country(String r11_country) {
		this.r11_country = r11_country;
	}
	public BigDecimal getR11_amount() {
		return r11_amount;
	}
	public void setR11_amount(BigDecimal r11_amount) {
		this.r11_amount = r11_amount;
	}
	public String getR12_product_res() {
		return r12_product_res;
	}
	public void setR12_product_res(String r12_product_res) {
		this.r12_product_res = r12_product_res;
	}
	public String getR12_country() {
		return r12_country;
	}
	public void setR12_country(String r12_country) {
		this.r12_country = r12_country;
	}
	public BigDecimal getR12_amount() {
		return r12_amount;
	}
	public void setR12_amount(BigDecimal r12_amount) {
		this.r12_amount = r12_amount;
	}
	public String getR13_product_res() {
		return r13_product_res;
	}
	public void setR13_product_res(String r13_product_res) {
		this.r13_product_res = r13_product_res;
	}
	public String getR13_country() {
		return r13_country;
	}
	public void setR13_country(String r13_country) {
		this.r13_country = r13_country;
	}
	public BigDecimal getR13_amount() {
		return r13_amount;
	}
	public void setR13_amount(BigDecimal r13_amount) {
		this.r13_amount = r13_amount;
	}
	public String getR14_product_res() {
		return r14_product_res;
	}
	public void setR14_product_res(String r14_product_res) {
		this.r14_product_res = r14_product_res;
	}
	public String getR14_country() {
		return r14_country;
	}
	public void setR14_country(String r14_country) {
		this.r14_country = r14_country;
	}
	public BigDecimal getR14_amount() {
		return r14_amount;
	}
	public void setR14_amount(BigDecimal r14_amount) {
		this.r14_amount = r14_amount;
	}
	public String getR15_product_res() {
		return r15_product_res;
	}
	public void setR15_product_res(String r15_product_res) {
		this.r15_product_res = r15_product_res;
	}
	public String getR15_country() {
		return r15_country;
	}
	public void setR15_country(String r15_country) {
		this.r15_country = r15_country;
	}
	public BigDecimal getR15_amount() {
		return r15_amount;
	}
	public void setR15_amount(BigDecimal r15_amount) {
		this.r15_amount = r15_amount;
	}
	public String getRt_total1() {
		return rt_total1;
	}
	public void setRt_total1(String rt_total1) {
		this.rt_total1 = rt_total1;
	}
	public String getR16_product_nonres() {
		return r16_product_nonres;
	}
	public void setR16_product_nonres(String r16_product_nonres) {
		this.r16_product_nonres = r16_product_nonres;
	}
	public String getR16_country_dom() {
		return r16_country_dom;
	}
	public void setR16_country_dom(String r16_country_dom) {
		this.r16_country_dom = r16_country_dom;
	}
	public BigDecimal getR16_amount() {
		return r16_amount;
	}
	public void setR16_amount(BigDecimal r16_amount) {
		this.r16_amount = r16_amount;
	}
	public String getR17_product_nonres() {
		return r17_product_nonres;
	}
	public void setR17_product_nonres(String r17_product_nonres) {
		this.r17_product_nonres = r17_product_nonres;
	}
	public String getR17_country_dom() {
		return r17_country_dom;
	}
	public void setR17_country_dom(String r17_country_dom) {
		this.r17_country_dom = r17_country_dom;
	}
	public BigDecimal getR17_amount() {
		return r17_amount;
	}
	public void setR17_amount(BigDecimal r17_amount) {
		this.r17_amount = r17_amount;
	}
	public String getR18_product_nonres() {
		return r18_product_nonres;
	}
	public void setR18_product_nonres(String r18_product_nonres) {
		this.r18_product_nonres = r18_product_nonres;
	}
	public String getR18_country_dom() {
		return r18_country_dom;
	}
	public void setR18_country_dom(String r18_country_dom) {
		this.r18_country_dom = r18_country_dom;
	}
	public BigDecimal getR18_amount() {
		return r18_amount;
	}
	public void setR18_amount(BigDecimal r18_amount) {
		this.r18_amount = r18_amount;
	}
	public String getR19_product_nonres() {
		return r19_product_nonres;
	}
	public void setR19_product_nonres(String r19_product_nonres) {
		this.r19_product_nonres = r19_product_nonres;
	}
	public String getR19_country_dom() {
		return r19_country_dom;
	}
	public void setR19_country_dom(String r19_country_dom) {
		this.r19_country_dom = r19_country_dom;
	}
	public BigDecimal getR19_amount() {
		return r19_amount;
	}
	public void setR19_amount(BigDecimal r19_amount) {
		this.r19_amount = r19_amount;
	}
	public String getR20_product_nonres() {
		return r20_product_nonres;
	}
	public void setR20_product_nonres(String r20_product_nonres) {
		this.r20_product_nonres = r20_product_nonres;
	}
	public String getR20_country_dom() {
		return r20_country_dom;
	}
	public void setR20_country_dom(String r20_country_dom) {
		this.r20_country_dom = r20_country_dom;
	}
	public BigDecimal getR20_amount() {
		return r20_amount;
	}
	public void setR20_amount(BigDecimal r20_amount) {
		this.r20_amount = r20_amount;
	}
	public String getR21_product_nonres() {
		return r21_product_nonres;
	}
	public void setR21_product_nonres(String r21_product_nonres) {
		this.r21_product_nonres = r21_product_nonres;
	}
	public String getR21_country_dom() {
		return r21_country_dom;
	}
	public void setR21_country_dom(String r21_country_dom) {
		this.r21_country_dom = r21_country_dom;
	}
	public BigDecimal getR21_amount() {
		return r21_amount;
	}
	public void setR21_amount(BigDecimal r21_amount) {
		this.r21_amount = r21_amount;
	}
	public String getR22_product_nonres() {
		return r22_product_nonres;
	}
	public void setR22_product_nonres(String r22_product_nonres) {
		this.r22_product_nonres = r22_product_nonres;
	}
	public String getR22_country_dom() {
		return r22_country_dom;
	}
	public void setR22_country_dom(String r22_country_dom) {
		this.r22_country_dom = r22_country_dom;
	}
	public BigDecimal getR22_amount() {
		return r22_amount;
	}
	public void setR22_amount(BigDecimal r22_amount) {
		this.r22_amount = r22_amount;
	}
	public String getR23_product_nonres() {
		return r23_product_nonres;
	}
	public void setR23_product_nonres(String r23_product_nonres) {
		this.r23_product_nonres = r23_product_nonres;
	}
	public String getR23_country_dom() {
		return r23_country_dom;
	}
	public void setR23_country_dom(String r23_country_dom) {
		this.r23_country_dom = r23_country_dom;
	}
	public BigDecimal getR23_amount() {
		return r23_amount;
	}
	public void setR23_amount(BigDecimal r23_amount) {
		this.r23_amount = r23_amount;
	}
	public String getR24_product_nonres() {
		return r24_product_nonres;
	}
	public void setR24_product_nonres(String r24_product_nonres) {
		this.r24_product_nonres = r24_product_nonres;
	}
	public String getR24_country_dom() {
		return r24_country_dom;
	}
	public void setR24_country_dom(String r24_country_dom) {
		this.r24_country_dom = r24_country_dom;
	}
	public BigDecimal getR24_amount() {
		return r24_amount;
	}
	public void setR24_amount(BigDecimal r24_amount) {
		this.r24_amount = r24_amount;
	}
	public String getR25_product_nonres() {
		return r25_product_nonres;
	}
	public void setR25_product_nonres(String r25_product_nonres) {
		this.r25_product_nonres = r25_product_nonres;
	}
	public String getR25_country_dom() {
		return r25_country_dom;
	}
	public void setR25_country_dom(String r25_country_dom) {
		this.r25_country_dom = r25_country_dom;
	}
	public BigDecimal getR25_amount() {
		return r25_amount;
	}
	public void setR25_amount(BigDecimal r25_amount) {
		this.r25_amount = r25_amount;
	}
	public String getR26_product_nonres() {
		return r26_product_nonres;
	}
	public void setR26_product_nonres(String r26_product_nonres) {
		this.r26_product_nonres = r26_product_nonres;
	}
	public String getR26_country_dom() {
		return r26_country_dom;
	}
	public void setR26_country_dom(String r26_country_dom) {
		this.r26_country_dom = r26_country_dom;
	}
	public BigDecimal getR26_amount() {
		return r26_amount;
	}
	public void setR26_amount(BigDecimal r26_amount) {
		this.r26_amount = r26_amount;
	}
	public String getR27_product_nonres() {
		return r27_product_nonres;
	}
	public void setR27_product_nonres(String r27_product_nonres) {
		this.r27_product_nonres = r27_product_nonres;
	}
	public String getR27_country_dom() {
		return r27_country_dom;
	}
	public void setR27_country_dom(String r27_country_dom) {
		this.r27_country_dom = r27_country_dom;
	}
	public BigDecimal getR27_amount() {
		return r27_amount;
	}
	public void setR27_amount(BigDecimal r27_amount) {
		this.r27_amount = r27_amount;
	}
	public String getR28_product_nonres() {
		return r28_product_nonres;
	}
	public void setR28_product_nonres(String r28_product_nonres) {
		this.r28_product_nonres = r28_product_nonres;
	}
	public String getR28_country_dom() {
		return r28_country_dom;
	}
	public void setR28_country_dom(String r28_country_dom) {
		this.r28_country_dom = r28_country_dom;
	}
	public BigDecimal getR28_amount() {
		return r28_amount;
	}
	public void setR28_amount(BigDecimal r28_amount) {
		this.r28_amount = r28_amount;
	}
	public String getR29_product_nonres() {
		return r29_product_nonres;
	}
	public void setR29_product_nonres(String r29_product_nonres) {
		this.r29_product_nonres = r29_product_nonres;
	}
	public String getR29_country_dom() {
		return r29_country_dom;
	}
	public void setR29_country_dom(String r29_country_dom) {
		this.r29_country_dom = r29_country_dom;
	}
	public BigDecimal getR29_amount() {
		return r29_amount;
	}
	public void setR29_amount(BigDecimal r29_amount) {
		this.r29_amount = r29_amount;
	}
	public String getR30_product_nonres() {
		return r30_product_nonres;
	}
	public void setR30_product_nonres(String r30_product_nonres) {
		this.r30_product_nonres = r30_product_nonres;
	}
	public String getR30_country_dom() {
		return r30_country_dom;
	}
	public void setR30_country_dom(String r30_country_dom) {
		this.r30_country_dom = r30_country_dom;
	}
	public BigDecimal getR30_amount() {
		return r30_amount;
	}
	public void setR30_amount(BigDecimal r30_amount) {
		this.r30_amount = r30_amount;
	}
	public BigDecimal getRt_total2() {
		return rt_total2;
	}
	public void setRt_total2(BigDecimal rt_total2) {
		this.rt_total2 = rt_total2;
	}
	public String getR31_product_bor() {
		return r31_product_bor;
	}
	public void setR31_product_bor(String r31_product_bor) {
		this.r31_product_bor = r31_product_bor;
	}
	public String getR31_country_ho() {
		return r31_country_ho;
	}
	public void setR31_country_ho(String r31_country_ho) {
		this.r31_country_ho = r31_country_ho;
	}
	public BigDecimal getR31_amount() {
		return r31_amount;
	}
	public void setR31_amount(BigDecimal r31_amount) {
		this.r31_amount = r31_amount;
	}
	public String getR32_product_bor() {
		return r32_product_bor;
	}
	public void setR32_product_bor(String r32_product_bor) {
		this.r32_product_bor = r32_product_bor;
	}
	public String getR32_country_ho() {
		return r32_country_ho;
	}
	public void setR32_country_ho(String r32_country_ho) {
		this.r32_country_ho = r32_country_ho;
	}
	public BigDecimal getR32_amount() {
		return r32_amount;
	}
	public void setR32_amount(BigDecimal r32_amount) {
		this.r32_amount = r32_amount;
	}
	public String getR33_product_bor() {
		return r33_product_bor;
	}
	public void setR33_product_bor(String r33_product_bor) {
		this.r33_product_bor = r33_product_bor;
	}
	public String getR33_country_ho() {
		return r33_country_ho;
	}
	public void setR33_country_ho(String r33_country_ho) {
		this.r33_country_ho = r33_country_ho;
	}
	public BigDecimal getR33_amount() {
		return r33_amount;
	}
	public void setR33_amount(BigDecimal r33_amount) {
		this.r33_amount = r33_amount;
	}
	public String getR34_product_bor() {
		return r34_product_bor;
	}
	public void setR34_product_bor(String r34_product_bor) {
		this.r34_product_bor = r34_product_bor;
	}
	public String getR34_country_ho() {
		return r34_country_ho;
	}
	public void setR34_country_ho(String r34_country_ho) {
		this.r34_country_ho = r34_country_ho;
	}
	public BigDecimal getR34_amount() {
		return r34_amount;
	}
	public void setR34_amount(BigDecimal r34_amount) {
		this.r34_amount = r34_amount;
	}
	public String getR35_product_bor() {
		return r35_product_bor;
	}
	public void setR35_product_bor(String r35_product_bor) {
		this.r35_product_bor = r35_product_bor;
	}
	public String getR35_country_ho() {
		return r35_country_ho;
	}
	public void setR35_country_ho(String r35_country_ho) {
		this.r35_country_ho = r35_country_ho;
	}
	public BigDecimal getR35_amount() {
		return r35_amount;
	}
	public void setR35_amount(BigDecimal r35_amount) {
		this.r35_amount = r35_amount;
	}
	public String getR36_product_bor() {
		return r36_product_bor;
	}
	public void setR36_product_bor(String r36_product_bor) {
		this.r36_product_bor = r36_product_bor;
	}
	public String getR36_country_ho() {
		return r36_country_ho;
	}
	public void setR36_country_ho(String r36_country_ho) {
		this.r36_country_ho = r36_country_ho;
	}
	public BigDecimal getR36_amount() {
		return r36_amount;
	}
	public void setR36_amount(BigDecimal r36_amount) {
		this.r36_amount = r36_amount;
	}
	public String getR37_product_bor() {
		return r37_product_bor;
	}
	public void setR37_product_bor(String r37_product_bor) {
		this.r37_product_bor = r37_product_bor;
	}
	public String getR37_country_ho() {
		return r37_country_ho;
	}
	public void setR37_country_ho(String r37_country_ho) {
		this.r37_country_ho = r37_country_ho;
	}
	public BigDecimal getR37_amount() {
		return r37_amount;
	}
	public void setR37_amount(BigDecimal r37_amount) {
		this.r37_amount = r37_amount;
	}
	public String getR38_product_bor() {
		return r38_product_bor;
	}
	public void setR38_product_bor(String r38_product_bor) {
		this.r38_product_bor = r38_product_bor;
	}
	public String getR38_country_ho() {
		return r38_country_ho;
	}
	public void setR38_country_ho(String r38_country_ho) {
		this.r38_country_ho = r38_country_ho;
	}
	public BigDecimal getR38_amount() {
		return r38_amount;
	}
	public void setR38_amount(BigDecimal r38_amount) {
		this.r38_amount = r38_amount;
	}
	public String getR39_product_bor() {
		return r39_product_bor;
	}
	public void setR39_product_bor(String r39_product_bor) {
		this.r39_product_bor = r39_product_bor;
	}
	public String getR39_country_ho() {
		return r39_country_ho;
	}
	public void setR39_country_ho(String r39_country_ho) {
		this.r39_country_ho = r39_country_ho;
	}
	public BigDecimal getR39_amount() {
		return r39_amount;
	}
	public void setR39_amount(BigDecimal r39_amount) {
		this.r39_amount = r39_amount;
	}
	public String getR40_product_bor() {
		return r40_product_bor;
	}
	public void setR40_product_bor(String r40_product_bor) {
		this.r40_product_bor = r40_product_bor;
	}
	public String getR40_country_ho() {
		return r40_country_ho;
	}
	public void setR40_country_ho(String r40_country_ho) {
		this.r40_country_ho = r40_country_ho;
	}
	public BigDecimal getR40_amount() {
		return r40_amount;
	}
	public void setR40_amount(BigDecimal r40_amount) {
		this.r40_amount = r40_amount;
	}
	public String getR41_product_bor() {
		return r41_product_bor;
	}
	public void setR41_product_bor(String r41_product_bor) {
		this.r41_product_bor = r41_product_bor;
	}
	public String getR41_country_ho() {
		return r41_country_ho;
	}
	public void setR41_country_ho(String r41_country_ho) {
		this.r41_country_ho = r41_country_ho;
	}
	public BigDecimal getR41_amount() {
		return r41_amount;
	}
	public void setR41_amount(BigDecimal r41_amount) {
		this.r41_amount = r41_amount;
	}
	public String getR42_product_bor() {
		return r42_product_bor;
	}
	public void setR42_product_bor(String r42_product_bor) {
		this.r42_product_bor = r42_product_bor;
	}
	public String getR42_country_ho() {
		return r42_country_ho;
	}
	public void setR42_country_ho(String r42_country_ho) {
		this.r42_country_ho = r42_country_ho;
	}
	public BigDecimal getR42_amount() {
		return r42_amount;
	}
	public void setR42_amount(BigDecimal r42_amount) {
		this.r42_amount = r42_amount;
	}
	public String getR43_product_bor() {
		return r43_product_bor;
	}
	public void setR43_product_bor(String r43_product_bor) {
		this.r43_product_bor = r43_product_bor;
	}
	public String getR43_country_ho() {
		return r43_country_ho;
	}
	public void setR43_country_ho(String r43_country_ho) {
		this.r43_country_ho = r43_country_ho;
	}
	public BigDecimal getR43_amount() {
		return r43_amount;
	}
	public void setR43_amount(BigDecimal r43_amount) {
		this.r43_amount = r43_amount;
	}
	public String getR44_product_bor() {
		return r44_product_bor;
	}
	public void setR44_product_bor(String r44_product_bor) {
		this.r44_product_bor = r44_product_bor;
	}
	public String getR44_country_ho() {
		return r44_country_ho;
	}
	public void setR44_country_ho(String r44_country_ho) {
		this.r44_country_ho = r44_country_ho;
	}
	public BigDecimal getR44_amount() {
		return r44_amount;
	}
	public void setR44_amount(BigDecimal r44_amount) {
		this.r44_amount = r44_amount;
	}
	public String getR45_product_bor() {
		return r45_product_bor;
	}
	public void setR45_product_bor(String r45_product_bor) {
		this.r45_product_bor = r45_product_bor;
	}
	public String getR45_country_ho() {
		return r45_country_ho;
	}
	public void setR45_country_ho(String r45_country_ho) {
		this.r45_country_ho = r45_country_ho;
	}
	public BigDecimal getR45_amount() {
		return r45_amount;
	}
	public void setR45_amount(BigDecimal r45_amount) {
		this.r45_amount = r45_amount;
	}
	public BigDecimal getRt_total3() {
		return rt_total3;
	}
	public void setRt_total3(BigDecimal rt_total3) {
		this.rt_total3 = rt_total3;
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
	public BRF33_ENTITY() {
		super();
		// TODO Auto-generated constructor stub
	}
}