package com.bornfire.xbrl.entities.BRBS;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="BRF001_SUMMARYTABLE")
public class BRF001_FORT_ENTITY {
	private String	r8_product1;
	private BigDecimal	r8_average_qualify;
	private BigDecimal	r8_requirement_ratios;
	private BigDecimal	r8_requirement_applied;
	private String	r9_demand1;
	private BigDecimal	r9_average_qualify;
	private BigDecimal	r9_requirement_ratios;
	private BigDecimal	r9_requirement_applied;
	private String	r10_time1;
	private BigDecimal	r10_average_qualify;
	private BigDecimal	r10_requirement_ratios;
	private BigDecimal	r10_requirement_applied;
	private String	r11_saving1;
	private BigDecimal	r11_average_qualify;
	private BigDecimal	r11_requirement_ratios;
	private BigDecimal	r11_requirement_applied;
	private String	r12_commerical_demand1;
	private BigDecimal	r12_average_qualify;
	private BigDecimal	r12_requirement_ratios;
	private BigDecimal	r12_requirement_applied;
	private String	r13_commerical_time1;
	private BigDecimal	r13_average_qualify;
	private BigDecimal	r13_requirement_ratios;
	private BigDecimal	r13_requirement_applied;
	private String	r14_product2;
	private BigDecimal	r14_average_qualify;
	private BigDecimal	r14_requirement_ratios;
	private BigDecimal	r14_requirement_applied;
	private String	r15_demand2;
	private BigDecimal	r15_average_qualify;
	private BigDecimal	r15_requirement_ratios;
	private BigDecimal	r15_requirement_applied;
	private String	r16_time2;
	private BigDecimal	r16_average_qualify;
	private BigDecimal	r16_requirement_ratios;
	private BigDecimal	r16_requirement_applied;
	private String	r17_saving2;
	private BigDecimal	r17_average_qualify;
	private BigDecimal	r17_requirement_ratios;
	private BigDecimal	r17_requirement_applied;
	private String	r18_commerical_demand2;
	private BigDecimal	r18_average_qualify;
	private BigDecimal	r18_requirement_ratios;
	private BigDecimal	r18_requirement_applied;
	private String	r19_commerical_time2;
	private BigDecimal	r19_average_qualify;
	private BigDecimal	r19_requirement_ratios;
	private BigDecimal	r19_requirement_applied;
	private String	r20_product3;
	private BigDecimal	r20_average_qualify;
	private BigDecimal	r20_requirement_ratios;
	private BigDecimal	r20_requirement_applied;
	private String	r21_demand3;
	private BigDecimal	r21_average_qualify;
	private BigDecimal	r21_requirement_ratios;
	private BigDecimal	r21_requirement_applied;
	private String	r22_time3;
	private BigDecimal	r22_average_qualify;
	private BigDecimal	r22_requirement_ratios;
	private BigDecimal	r22_requirement_applied;
	private String	r23_saving3;
	private BigDecimal	r23_average_qualify;
	private BigDecimal	r23_requirement_ratios;
	private BigDecimal	r23_requirement_applied;
	private String	r24_commerical_demand3;
	private BigDecimal	r24_average_qualify;
	private BigDecimal	r24_requirement_ratios;
	private BigDecimal	r24_requirement_applied;
	private String	r25_commerical_time3;
	private BigDecimal	r25_average_qualify;
	private BigDecimal	r25_requirement_ratios;
	private BigDecimal	r25_requirement_applied;
	private String	r26_product4;
	private BigDecimal	r26_average_qualify;
	private BigDecimal	r26_requirement_ratios;
	private BigDecimal	r26_requirement_applied;
	private String	r27_demand4;
	private BigDecimal	r27_average_qualify;
	private BigDecimal	r27_requirement_ratios;
	private BigDecimal	r27_requirement_applied;
	private String	r28_time4;
	private BigDecimal	r28_average_qualify;
	private BigDecimal	r28_requirement_ratios;
	private BigDecimal	r28_requirement_applied;
	private String	r29_saving4;
	private BigDecimal	r29_average_qualify;
	private BigDecimal	r29_requirement_ratios;
	private BigDecimal	r29_requirement_applied;
	private String	r30_commerical_demand4;
	private BigDecimal	r30_average_qualify;
	private BigDecimal	r30_requirement_ratios;
	private BigDecimal	r30_requirement_applied;
	private String	r31_commerical_time4;
	private BigDecimal	r31_average_qualify;
	private BigDecimal	r31_requirement_ratios;
	private BigDecimal	r31_requirement_applied;
	private String	r32_qualify;
	private BigDecimal	r32_average_qualify;
	private BigDecimal	r32_requirement_ratios;
	private BigDecimal	r32_requirement_applied;
	private String	r33_time_deposit;
	private BigDecimal	r33_average_qualify;
	private BigDecimal	r33_requirement_ratios;
	private BigDecimal	r33_requirement_applied;
	private String	r34_demand_deposit;
	private BigDecimal	r34_average_qualify;
	private BigDecimal	r34_requirement_ratios;
	private BigDecimal	r34_requirement_applied;
	private String	r35_total;
	private BigDecimal	r35_average_qualify;
	private BigDecimal	r35_requirement_ratios;
	private BigDecimal	r35_requirement_applied;
	private Date	report_submit_date;
	@Id
	private Date	report_date;
	private Date	report_from_date;
	private Date	report_to_date;
	private String	report_code;
	private String	entity_flg;
	private String	modify_flg;
	private String	del_flg;
	private String	repdesc;
	private String	frequency;
	public String getR8_product1() {
		return r8_product1;
	}
	public void setR8_product1(String r8_product1) {
		this.r8_product1 = r8_product1;
	}
	public BigDecimal getR8_average_qualify() {
		return r8_average_qualify;
	}
	public void setR8_average_qualify(BigDecimal r8_average_qualify) {
		this.r8_average_qualify = r8_average_qualify;
	}
	public BigDecimal getR8_requirement_ratios() {
		return r8_requirement_ratios;
	}
	public void setR8_requirement_ratios(BigDecimal r8_requirement_ratios) {
		this.r8_requirement_ratios = r8_requirement_ratios;
	}
	public BigDecimal getR8_requirement_applied() {
		return r8_requirement_applied;
	}
	public void setR8_requirement_applied(BigDecimal r8_requirement_applied) {
		this.r8_requirement_applied = r8_requirement_applied;
	}
	public String getR9_demand1() {
		return r9_demand1;
	}
	public void setR9_demand1(String r9_demand1) {
		this.r9_demand1 = r9_demand1;
	}
	public BigDecimal getR9_average_qualify() {
		return r9_average_qualify;
	}
	public void setR9_average_qualify(BigDecimal r9_average_qualify) {
		this.r9_average_qualify = r9_average_qualify;
	}
	public BigDecimal getR9_requirement_ratios() {
		return r9_requirement_ratios;
	}
	public void setR9_requirement_ratios(BigDecimal r9_requirement_ratios) {
		this.r9_requirement_ratios = r9_requirement_ratios;
	}
	public BigDecimal getR9_requirement_applied() {
		return r9_requirement_applied;
	}
	public void setR9_requirement_applied(BigDecimal r9_requirement_applied) {
		this.r9_requirement_applied = r9_requirement_applied;
	}
	public String getR10_time1() {
		return r10_time1;
	}
	public void setR10_time1(String r10_time1) {
		this.r10_time1 = r10_time1;
	}
	public BigDecimal getR10_average_qualify() {
		return r10_average_qualify;
	}
	public void setR10_average_qualify(BigDecimal r10_average_qualify) {
		this.r10_average_qualify = r10_average_qualify;
	}
	public BigDecimal getR10_requirement_ratios() {
		return r10_requirement_ratios;
	}
	public void setR10_requirement_ratios(BigDecimal r10_requirement_ratios) {
		this.r10_requirement_ratios = r10_requirement_ratios;
	}
	public BigDecimal getR10_requirement_applied() {
		return r10_requirement_applied;
	}
	public void setR10_requirement_applied(BigDecimal r10_requirement_applied) {
		this.r10_requirement_applied = r10_requirement_applied;
	}
	public String getR11_saving1() {
		return r11_saving1;
	}
	public void setR11_saving1(String r11_saving1) {
		this.r11_saving1 = r11_saving1;
	}
	public BigDecimal getR11_average_qualify() {
		return r11_average_qualify;
	}
	public void setR11_average_qualify(BigDecimal r11_average_qualify) {
		this.r11_average_qualify = r11_average_qualify;
	}
	public BigDecimal getR11_requirement_ratios() {
		return r11_requirement_ratios;
	}
	public void setR11_requirement_ratios(BigDecimal r11_requirement_ratios) {
		this.r11_requirement_ratios = r11_requirement_ratios;
	}
	public BigDecimal getR11_requirement_applied() {
		return r11_requirement_applied;
	}
	public void setR11_requirement_applied(BigDecimal r11_requirement_applied) {
		this.r11_requirement_applied = r11_requirement_applied;
	}
	public String getR12_commerical_demand1() {
		return r12_commerical_demand1;
	}
	public void setR12_commerical_demand1(String r12_commerical_demand1) {
		this.r12_commerical_demand1 = r12_commerical_demand1;
	}
	public BigDecimal getR12_average_qualify() {
		return r12_average_qualify;
	}
	public void setR12_average_qualify(BigDecimal r12_average_qualify) {
		this.r12_average_qualify = r12_average_qualify;
	}
	public BigDecimal getR12_requirement_ratios() {
		return r12_requirement_ratios;
	}
	public void setR12_requirement_ratios(BigDecimal r12_requirement_ratios) {
		this.r12_requirement_ratios = r12_requirement_ratios;
	}
	public BigDecimal getR12_requirement_applied() {
		return r12_requirement_applied;
	}
	public void setR12_requirement_applied(BigDecimal r12_requirement_applied) {
		this.r12_requirement_applied = r12_requirement_applied;
	}
	public String getR13_commerical_time1() {
		return r13_commerical_time1;
	}
	public void setR13_commerical_time1(String r13_commerical_time1) {
		this.r13_commerical_time1 = r13_commerical_time1;
	}
	public BigDecimal getR13_average_qualify() {
		return r13_average_qualify;
	}
	public void setR13_average_qualify(BigDecimal r13_average_qualify) {
		this.r13_average_qualify = r13_average_qualify;
	}
	public BigDecimal getR13_requirement_ratios() {
		return r13_requirement_ratios;
	}
	public void setR13_requirement_ratios(BigDecimal r13_requirement_ratios) {
		this.r13_requirement_ratios = r13_requirement_ratios;
	}
	public BigDecimal getR13_requirement_applied() {
		return r13_requirement_applied;
	}
	public void setR13_requirement_applied(BigDecimal r13_requirement_applied) {
		this.r13_requirement_applied = r13_requirement_applied;
	}
	public String getR14_product2() {
		return r14_product2;
	}
	public void setR14_product2(String r14_product2) {
		this.r14_product2 = r14_product2;
	}
	public BigDecimal getR14_average_qualify() {
		return r14_average_qualify;
	}
	public void setR14_average_qualify(BigDecimal r14_average_qualify) {
		this.r14_average_qualify = r14_average_qualify;
	}
	public BigDecimal getR14_requirement_ratios() {
		return r14_requirement_ratios;
	}
	public void setR14_requirement_ratios(BigDecimal r14_requirement_ratios) {
		this.r14_requirement_ratios = r14_requirement_ratios;
	}
	public BigDecimal getR14_requirement_applied() {
		return r14_requirement_applied;
	}
	public void setR14_requirement_applied(BigDecimal r14_requirement_applied) {
		this.r14_requirement_applied = r14_requirement_applied;
	}
	public String getR15_demand2() {
		return r15_demand2;
	}
	public void setR15_demand2(String r15_demand2) {
		this.r15_demand2 = r15_demand2;
	}
	public BigDecimal getR15_average_qualify() {
		return r15_average_qualify;
	}
	public void setR15_average_qualify(BigDecimal r15_average_qualify) {
		this.r15_average_qualify = r15_average_qualify;
	}
	public BigDecimal getR15_requirement_ratios() {
		return r15_requirement_ratios;
	}
	public void setR15_requirement_ratios(BigDecimal r15_requirement_ratios) {
		this.r15_requirement_ratios = r15_requirement_ratios;
	}
	public BigDecimal getR15_requirement_applied() {
		return r15_requirement_applied;
	}
	public void setR15_requirement_applied(BigDecimal r15_requirement_applied) {
		this.r15_requirement_applied = r15_requirement_applied;
	}
	public String getR16_time2() {
		return r16_time2;
	}
	public void setR16_time2(String r16_time2) {
		this.r16_time2 = r16_time2;
	}
	public BigDecimal getR16_average_qualify() {
		return r16_average_qualify;
	}
	public void setR16_average_qualify(BigDecimal r16_average_qualify) {
		this.r16_average_qualify = r16_average_qualify;
	}
	public BigDecimal getR16_requirement_ratios() {
		return r16_requirement_ratios;
	}
	public void setR16_requirement_ratios(BigDecimal r16_requirement_ratios) {
		this.r16_requirement_ratios = r16_requirement_ratios;
	}
	public BigDecimal getR16_requirement_applied() {
		return r16_requirement_applied;
	}
	public void setR16_requirement_applied(BigDecimal r16_requirement_applied) {
		this.r16_requirement_applied = r16_requirement_applied;
	}
	public String getR17_saving2() {
		return r17_saving2;
	}
	public void setR17_saving2(String r17_saving2) {
		this.r17_saving2 = r17_saving2;
	}
	public BigDecimal getR17_average_qualify() {
		return r17_average_qualify;
	}
	public void setR17_average_qualify(BigDecimal r17_average_qualify) {
		this.r17_average_qualify = r17_average_qualify;
	}
	public BigDecimal getR17_requirement_ratios() {
		return r17_requirement_ratios;
	}
	public void setR17_requirement_ratios(BigDecimal r17_requirement_ratios) {
		this.r17_requirement_ratios = r17_requirement_ratios;
	}
	public BigDecimal getR17_requirement_applied() {
		return r17_requirement_applied;
	}
	public void setR17_requirement_applied(BigDecimal r17_requirement_applied) {
		this.r17_requirement_applied = r17_requirement_applied;
	}
	public String getR18_commerical_demand2() {
		return r18_commerical_demand2;
	}
	public void setR18_commerical_demand2(String r18_commerical_demand2) {
		this.r18_commerical_demand2 = r18_commerical_demand2;
	}
	public BigDecimal getR18_average_qualify() {
		return r18_average_qualify;
	}
	public void setR18_average_qualify(BigDecimal r18_average_qualify) {
		this.r18_average_qualify = r18_average_qualify;
	}
	public BigDecimal getR18_requirement_ratios() {
		return r18_requirement_ratios;
	}
	public void setR18_requirement_ratios(BigDecimal r18_requirement_ratios) {
		this.r18_requirement_ratios = r18_requirement_ratios;
	}
	public BigDecimal getR18_requirement_applied() {
		return r18_requirement_applied;
	}
	public void setR18_requirement_applied(BigDecimal r18_requirement_applied) {
		this.r18_requirement_applied = r18_requirement_applied;
	}
	public String getR19_commerical_time2() {
		return r19_commerical_time2;
	}
	public void setR19_commerical_time2(String r19_commerical_time2) {
		this.r19_commerical_time2 = r19_commerical_time2;
	}
	public BigDecimal getR19_average_qualify() {
		return r19_average_qualify;
	}
	public void setR19_average_qualify(BigDecimal r19_average_qualify) {
		this.r19_average_qualify = r19_average_qualify;
	}
	public BigDecimal getR19_requirement_ratios() {
		return r19_requirement_ratios;
	}
	public void setR19_requirement_ratios(BigDecimal r19_requirement_ratios) {
		this.r19_requirement_ratios = r19_requirement_ratios;
	}
	public BigDecimal getR19_requirement_applied() {
		return r19_requirement_applied;
	}
	public void setR19_requirement_applied(BigDecimal r19_requirement_applied) {
		this.r19_requirement_applied = r19_requirement_applied;
	}
	public String getR20_product3() {
		return r20_product3;
	}
	public void setR20_product3(String r20_product3) {
		this.r20_product3 = r20_product3;
	}
	public BigDecimal getR20_average_qualify() {
		return r20_average_qualify;
	}
	public void setR20_average_qualify(BigDecimal r20_average_qualify) {
		this.r20_average_qualify = r20_average_qualify;
	}
	public BigDecimal getR20_requirement_ratios() {
		return r20_requirement_ratios;
	}
	public void setR20_requirement_ratios(BigDecimal r20_requirement_ratios) {
		this.r20_requirement_ratios = r20_requirement_ratios;
	}
	public BigDecimal getR20_requirement_applied() {
		return r20_requirement_applied;
	}
	public void setR20_requirement_applied(BigDecimal r20_requirement_applied) {
		this.r20_requirement_applied = r20_requirement_applied;
	}
	public String getR21_demand3() {
		return r21_demand3;
	}
	public void setR21_demand3(String r21_demand3) {
		this.r21_demand3 = r21_demand3;
	}
	public BigDecimal getR21_average_qualify() {
		return r21_average_qualify;
	}
	public void setR21_average_qualify(BigDecimal r21_average_qualify) {
		this.r21_average_qualify = r21_average_qualify;
	}
	public BigDecimal getR21_requirement_ratios() {
		return r21_requirement_ratios;
	}
	public void setR21_requirement_ratios(BigDecimal r21_requirement_ratios) {
		this.r21_requirement_ratios = r21_requirement_ratios;
	}
	public BigDecimal getR21_requirement_applied() {
		return r21_requirement_applied;
	}
	public void setR21_requirement_applied(BigDecimal r21_requirement_applied) {
		this.r21_requirement_applied = r21_requirement_applied;
	}
	public String getR22_time3() {
		return r22_time3;
	}
	public void setR22_time3(String r22_time3) {
		this.r22_time3 = r22_time3;
	}
	public BigDecimal getR22_average_qualify() {
		return r22_average_qualify;
	}
	public void setR22_average_qualify(BigDecimal r22_average_qualify) {
		this.r22_average_qualify = r22_average_qualify;
	}
	public BigDecimal getR22_requirement_ratios() {
		return r22_requirement_ratios;
	}
	public void setR22_requirement_ratios(BigDecimal r22_requirement_ratios) {
		this.r22_requirement_ratios = r22_requirement_ratios;
	}
	public BigDecimal getR22_requirement_applied() {
		return r22_requirement_applied;
	}
	public void setR22_requirement_applied(BigDecimal r22_requirement_applied) {
		this.r22_requirement_applied = r22_requirement_applied;
	}
	public String getR23_saving3() {
		return r23_saving3;
	}
	public void setR23_saving3(String r23_saving3) {
		this.r23_saving3 = r23_saving3;
	}
	public BigDecimal getR23_average_qualify() {
		return r23_average_qualify;
	}
	public void setR23_average_qualify(BigDecimal r23_average_qualify) {
		this.r23_average_qualify = r23_average_qualify;
	}
	public BigDecimal getR23_requirement_ratios() {
		return r23_requirement_ratios;
	}
	public void setR23_requirement_ratios(BigDecimal r23_requirement_ratios) {
		this.r23_requirement_ratios = r23_requirement_ratios;
	}
	public BigDecimal getR23_requirement_applied() {
		return r23_requirement_applied;
	}
	public void setR23_requirement_applied(BigDecimal r23_requirement_applied) {
		this.r23_requirement_applied = r23_requirement_applied;
	}
	public String getR24_commerical_demand3() {
		return r24_commerical_demand3;
	}
	public void setR24_commerical_demand3(String r24_commerical_demand3) {
		this.r24_commerical_demand3 = r24_commerical_demand3;
	}
	public BigDecimal getR24_average_qualify() {
		return r24_average_qualify;
	}
	public void setR24_average_qualify(BigDecimal r24_average_qualify) {
		this.r24_average_qualify = r24_average_qualify;
	}
	public BigDecimal getR24_requirement_ratios() {
		return r24_requirement_ratios;
	}
	public void setR24_requirement_ratios(BigDecimal r24_requirement_ratios) {
		this.r24_requirement_ratios = r24_requirement_ratios;
	}
	public BigDecimal getR24_requirement_applied() {
		return r24_requirement_applied;
	}
	public void setR24_requirement_applied(BigDecimal r24_requirement_applied) {
		this.r24_requirement_applied = r24_requirement_applied;
	}
	public String getR25_commerical_time3() {
		return r25_commerical_time3;
	}
	public void setR25_commerical_time3(String r25_commerical_time3) {
		this.r25_commerical_time3 = r25_commerical_time3;
	}
	public BigDecimal getR25_average_qualify() {
		return r25_average_qualify;
	}
	public void setR25_average_qualify(BigDecimal r25_average_qualify) {
		this.r25_average_qualify = r25_average_qualify;
	}
	public BigDecimal getR25_requirement_ratios() {
		return r25_requirement_ratios;
	}
	public void setR25_requirement_ratios(BigDecimal r25_requirement_ratios) {
		this.r25_requirement_ratios = r25_requirement_ratios;
	}
	public BigDecimal getR25_requirement_applied() {
		return r25_requirement_applied;
	}
	public void setR25_requirement_applied(BigDecimal r25_requirement_applied) {
		this.r25_requirement_applied = r25_requirement_applied;
	}
	public String getR26_product4() {
		return r26_product4;
	}
	public void setR26_product4(String r26_product4) {
		this.r26_product4 = r26_product4;
	}
	public BigDecimal getR26_average_qualify() {
		return r26_average_qualify;
	}
	public void setR26_average_qualify(BigDecimal r26_average_qualify) {
		this.r26_average_qualify = r26_average_qualify;
	}
	public BigDecimal getR26_requirement_ratios() {
		return r26_requirement_ratios;
	}
	public void setR26_requirement_ratios(BigDecimal r26_requirement_ratios) {
		this.r26_requirement_ratios = r26_requirement_ratios;
	}
	public BigDecimal getR26_requirement_applied() {
		return r26_requirement_applied;
	}
	public void setR26_requirement_applied(BigDecimal r26_requirement_applied) {
		this.r26_requirement_applied = r26_requirement_applied;
	}
	public String getR27_demand4() {
		return r27_demand4;
	}
	public void setR27_demand4(String r27_demand4) {
		this.r27_demand4 = r27_demand4;
	}
	public BigDecimal getR27_average_qualify() {
		return r27_average_qualify;
	}
	public void setR27_average_qualify(BigDecimal r27_average_qualify) {
		this.r27_average_qualify = r27_average_qualify;
	}
	public BigDecimal getR27_requirement_ratios() {
		return r27_requirement_ratios;
	}
	public void setR27_requirement_ratios(BigDecimal r27_requirement_ratios) {
		this.r27_requirement_ratios = r27_requirement_ratios;
	}
	public BigDecimal getR27_requirement_applied() {
		return r27_requirement_applied;
	}
	public void setR27_requirement_applied(BigDecimal r27_requirement_applied) {
		this.r27_requirement_applied = r27_requirement_applied;
	}
	public String getR28_time4() {
		return r28_time4;
	}
	public void setR28_time4(String r28_time4) {
		this.r28_time4 = r28_time4;
	}
	public BigDecimal getR28_average_qualify() {
		return r28_average_qualify;
	}
	public void setR28_average_qualify(BigDecimal r28_average_qualify) {
		this.r28_average_qualify = r28_average_qualify;
	}
	public BigDecimal getR28_requirement_ratios() {
		return r28_requirement_ratios;
	}
	public void setR28_requirement_ratios(BigDecimal r28_requirement_ratios) {
		this.r28_requirement_ratios = r28_requirement_ratios;
	}
	public BigDecimal getR28_requirement_applied() {
		return r28_requirement_applied;
	}
	public void setR28_requirement_applied(BigDecimal r28_requirement_applied) {
		this.r28_requirement_applied = r28_requirement_applied;
	}
	public String getR29_saving4() {
		return r29_saving4;
	}
	public void setR29_saving4(String r29_saving4) {
		this.r29_saving4 = r29_saving4;
	}
	public BigDecimal getR29_average_qualify() {
		return r29_average_qualify;
	}
	public void setR29_average_qualify(BigDecimal r29_average_qualify) {
		this.r29_average_qualify = r29_average_qualify;
	}
	public BigDecimal getR29_requirement_ratios() {
		return r29_requirement_ratios;
	}
	public void setR29_requirement_ratios(BigDecimal r29_requirement_ratios) {
		this.r29_requirement_ratios = r29_requirement_ratios;
	}
	public BigDecimal getR29_requirement_applied() {
		return r29_requirement_applied;
	}
	public void setR29_requirement_applied(BigDecimal r29_requirement_applied) {
		this.r29_requirement_applied = r29_requirement_applied;
	}
	public String getR30_commerical_demand4() {
		return r30_commerical_demand4;
	}
	public void setR30_commerical_demand4(String r30_commerical_demand4) {
		this.r30_commerical_demand4 = r30_commerical_demand4;
	}
	public BigDecimal getR30_average_qualify() {
		return r30_average_qualify;
	}
	public void setR30_average_qualify(BigDecimal r30_average_qualify) {
		this.r30_average_qualify = r30_average_qualify;
	}
	public BigDecimal getR30_requirement_ratios() {
		return r30_requirement_ratios;
	}
	public void setR30_requirement_ratios(BigDecimal r30_requirement_ratios) {
		this.r30_requirement_ratios = r30_requirement_ratios;
	}
	public BigDecimal getR30_requirement_applied() {
		return r30_requirement_applied;
	}
	public void setR30_requirement_applied(BigDecimal r30_requirement_applied) {
		this.r30_requirement_applied = r30_requirement_applied;
	}
	public String getR31_commerical_time4() {
		return r31_commerical_time4;
	}
	public void setR31_commerical_time4(String r31_commerical_time4) {
		this.r31_commerical_time4 = r31_commerical_time4;
	}
	public BigDecimal getR31_average_qualify() {
		return r31_average_qualify;
	}
	public void setR31_average_qualify(BigDecimal r31_average_qualify) {
		this.r31_average_qualify = r31_average_qualify;
	}
	public BigDecimal getR31_requirement_ratios() {
		return r31_requirement_ratios;
	}
	public void setR31_requirement_ratios(BigDecimal r31_requirement_ratios) {
		this.r31_requirement_ratios = r31_requirement_ratios;
	}
	public BigDecimal getR31_requirement_applied() {
		return r31_requirement_applied;
	}
	public void setR31_requirement_applied(BigDecimal r31_requirement_applied) {
		this.r31_requirement_applied = r31_requirement_applied;
	}
	public String getR32_qualify() {
		return r32_qualify;
	}
	public void setR32_qualify(String r32_qualify) {
		this.r32_qualify = r32_qualify;
	}
	public BigDecimal getR32_average_qualify() {
		return r32_average_qualify;
	}
	public void setR32_average_qualify(BigDecimal r32_average_qualify) {
		this.r32_average_qualify = r32_average_qualify;
	}
	public BigDecimal getR32_requirement_ratios() {
		return r32_requirement_ratios;
	}
	public void setR32_requirement_ratios(BigDecimal r32_requirement_ratios) {
		this.r32_requirement_ratios = r32_requirement_ratios;
	}
	public BigDecimal getR32_requirement_applied() {
		return r32_requirement_applied;
	}
	public void setR32_requirement_applied(BigDecimal r32_requirement_applied) {
		this.r32_requirement_applied = r32_requirement_applied;
	}
	public String getR33_time_deposit() {
		return r33_time_deposit;
	}
	public void setR33_time_deposit(String r33_time_deposit) {
		this.r33_time_deposit = r33_time_deposit;
	}
	public BigDecimal getR33_average_qualify() {
		return r33_average_qualify;
	}
	public void setR33_average_qualify(BigDecimal r33_average_qualify) {
		this.r33_average_qualify = r33_average_qualify;
	}
	public BigDecimal getR33_requirement_ratios() {
		return r33_requirement_ratios;
	}
	public void setR33_requirement_ratios(BigDecimal r33_requirement_ratios) {
		this.r33_requirement_ratios = r33_requirement_ratios;
	}
	public BigDecimal getR33_requirement_applied() {
		return r33_requirement_applied;
	}
	public void setR33_requirement_applied(BigDecimal r33_requirement_applied) {
		this.r33_requirement_applied = r33_requirement_applied;
	}
	public String getR34_demand_deposit() {
		return r34_demand_deposit;
	}
	public void setR34_demand_deposit(String r34_demand_deposit) {
		this.r34_demand_deposit = r34_demand_deposit;
	}
	public BigDecimal getR34_average_qualify() {
		return r34_average_qualify;
	}
	public void setR34_average_qualify(BigDecimal r34_average_qualify) {
		this.r34_average_qualify = r34_average_qualify;
	}
	public BigDecimal getR34_requirement_ratios() {
		return r34_requirement_ratios;
	}
	public void setR34_requirement_ratios(BigDecimal r34_requirement_ratios) {
		this.r34_requirement_ratios = r34_requirement_ratios;
	}
	public BigDecimal getR34_requirement_applied() {
		return r34_requirement_applied;
	}
	public void setR34_requirement_applied(BigDecimal r34_requirement_applied) {
		this.r34_requirement_applied = r34_requirement_applied;
	}
	public String getR35_total() {
		return r35_total;
	}
	public void setR35_total(String r35_total) {
		this.r35_total = r35_total;
	}
	public BigDecimal getR35_average_qualify() {
		return r35_average_qualify;
	}
	public void setR35_average_qualify(BigDecimal r35_average_qualify) {
		this.r35_average_qualify = r35_average_qualify;
	}
	public BigDecimal getR35_requirement_ratios() {
		return r35_requirement_ratios;
	}
	public void setR35_requirement_ratios(BigDecimal r35_requirement_ratios) {
		this.r35_requirement_ratios = r35_requirement_ratios;
	}
	public BigDecimal getR35_requirement_applied() {
		return r35_requirement_applied;
	}
	public void setR35_requirement_applied(BigDecimal r35_requirement_applied) {
		this.r35_requirement_applied = r35_requirement_applied;
	}
	public Date getReport_submit_date() {
		return report_submit_date;
	}
	public void setReport_submit_date(Date report_submit_date) {
		this.report_submit_date = report_submit_date;
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
	public String getReport_code() {
		return report_code;
	}
	public void setReport_code(String report_code) {
		this.report_code = report_code;
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
	public BRF001_FORT_ENTITY() {
		super();
		// TODO Auto-generated constructor stub
	}
}