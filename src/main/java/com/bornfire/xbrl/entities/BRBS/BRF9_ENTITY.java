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
@Table(name = "BRF9_SUMMARYTABLE")
public class BRF9_ENTITY {
	private String rh_product;
	private BigDecimal rh_overdue;
	private BigDecimal rh_overdraft;
	private BigDecimal rh_0_7_days;
	private BigDecimal rh_8_14_days;
	private BigDecimal rh_15_days_1_month;
	private BigDecimal rh_1_3_months;
	private BigDecimal rh_3_6_months;
	private BigDecimal rh_6_12_months;
	private BigDecimal rh_1_3_years;
	private BigDecimal rh_3_years;
	private BigDecimal rh_total;
	private String r1_product;
	private BigDecimal r1_overdue;
	private BigDecimal r1_overdraft;
	private BigDecimal r1_0_7_days;
	private BigDecimal r1_8_14_days;
	private BigDecimal r1_15_days_1_month;
	private BigDecimal r1_1_3_months;
	private BigDecimal r1_3_6_months;
	private BigDecimal r1_6_12_months;
	private BigDecimal r1_1_3_years;
	private BigDecimal r1_3_years;
	private BigDecimal r1_total;
	private String r2_product;
	private BigDecimal r2_overdue;
	private BigDecimal r2_overdraft;
	private BigDecimal r2_0_7_days;
	private BigDecimal r2_8_14_days;
	private BigDecimal r2_15_days_1_month;
	private BigDecimal r2_1_3_months;
	private BigDecimal r2_3_6_months;
	private BigDecimal r2_6_12_months;
	private BigDecimal r2_1_3_years;
	private BigDecimal r2_3_years;
	private BigDecimal r2_total;
	private String r3_product;
	private BigDecimal r3_overdue;
	private BigDecimal r3_overdraft;
	private BigDecimal r3_0_7_days;
	private BigDecimal r3_8_14_days;
	private BigDecimal r3_15_days_1_month;
	private BigDecimal r3_1_3_months;
	private BigDecimal r3_3_6_months;
	private BigDecimal r3_6_12_months;
	private BigDecimal r3_1_3_years;
	private BigDecimal r3_3_years;
	private BigDecimal r3_total;
	private String rh2_product;
	private BigDecimal rh2_overdue;
	private BigDecimal rh2_overdraft;
	private BigDecimal rh2_0_7_days;
	private BigDecimal rh2_8_14_days;
	private BigDecimal rh2_15_days_1_month;
	private BigDecimal rh2_1_3_months;
	private BigDecimal rh2_3_6_months;
	private BigDecimal rh2_6_12_months;
	private BigDecimal rh2_1_3_years;
	private BigDecimal rh2_3_years;
	private BigDecimal rh2_total;
	private String r4_product;
	private BigDecimal r4_overdue;
	private BigDecimal r4_overdraft;
	private BigDecimal r4_0_7_days;
	private BigDecimal r4_8_14_days;
	private BigDecimal r4_15_days_1_month;
	private BigDecimal r4_1_3_months;
	private BigDecimal r4_3_6_months;
	private BigDecimal r4_6_12_months;
	private BigDecimal r4_1_3_years;
	private BigDecimal r4_3_years;
	private BigDecimal r4_total;
	private String r5_product;
	private BigDecimal r5_overdue;
	private BigDecimal r5_overdraft;
	private BigDecimal r5_0_7_days;
	private BigDecimal r5_8_14_days;
	private BigDecimal r5_15_days_1_month;
	private BigDecimal r5_1_3_months;
	private BigDecimal r5_3_6_months;
	private BigDecimal r5_6_12_months;
	private BigDecimal r5_1_3_years;
	private BigDecimal r5_3_years;
	private BigDecimal r5_total;
	private String r6_product;
	private BigDecimal r6_overdue;
	private BigDecimal r6_overdraft;
	private BigDecimal r6_0_7_days;
	private BigDecimal r6_8_14_days;
	private BigDecimal r6_15_days_1_month;
	private BigDecimal r6_1_3_months;
	private BigDecimal r6_3_6_months;
	private BigDecimal r6_6_12_months;
	private BigDecimal r6_1_3_years;
	private BigDecimal r6_3_years;
	private BigDecimal r6_total;
	private String rh3_product;
	private BigDecimal rh3_overdue;
	private BigDecimal rh3_overdraft;
	private BigDecimal rh3_0_7_days;
	private BigDecimal rh3_8_14_days;
	private BigDecimal rh3_15_days_1_month;
	private BigDecimal rh3_1_3_months;
	private BigDecimal rh3_3_6_months;
	private BigDecimal rh3_6_12_months;
	private BigDecimal rh3_1_3_years;
	private BigDecimal rh3_3_years;
	private BigDecimal rh3_total;
	private String r7_product;
	private BigDecimal r7_overdue;
	private BigDecimal r7_overdraft;
	private BigDecimal r7_0_7_days;
	private BigDecimal r7_8_14_days;
	private BigDecimal r7_15_days_1_month;
	private BigDecimal r7_1_3_months;
	private BigDecimal r7_3_6_months;
	private BigDecimal r7_6_12_months;
	private BigDecimal r7_1_3_years;
	private BigDecimal r7_3_years;
	private BigDecimal r7_total;
	private String r8_product;
	private BigDecimal r8_overdue;
	private BigDecimal r8_overdraft;
	private BigDecimal r8_0_7_days;
	private BigDecimal r8_8_14_days;
	private BigDecimal r8_15_days_1_month;
	private BigDecimal r8_1_3_months;
	private BigDecimal r8_3_6_months;
	private BigDecimal r8_6_12_months;
	private BigDecimal r8_1_3_years;
	private BigDecimal r8_3_years;
	private BigDecimal r8_total;
	private String r9_product;
	private BigDecimal r9_overdue;
	private BigDecimal r9_overdraft;
	private BigDecimal r9_0_7_days;
	private BigDecimal r9_8_14_days;
	private BigDecimal r9_15_days_1_month;
	private BigDecimal r9_1_3_months;
	private BigDecimal r9_3_6_months;
	private BigDecimal r9_6_12_months;
	private BigDecimal r9_1_3_years;
	private BigDecimal r9_3_years;
	private BigDecimal r9_total;
	private String r10_product;
	private BigDecimal r10_overdue;
	private BigDecimal r10_overdraft;
	private BigDecimal r10_0_7_days;
	private BigDecimal r10_8_14_days;
	private BigDecimal r10_15_days_1_month;
	private BigDecimal r10_1_3_months;
	private BigDecimal r10_3_6_months;
	private BigDecimal r10_6_12_months;
	private BigDecimal r10_1_3_years;
	private BigDecimal r10_3_years;
	private BigDecimal r10_total;
	private String r11_product;
	private BigDecimal r11_overdue;
	private BigDecimal r11_overdraft;
	private BigDecimal r11_0_7_days;
	private BigDecimal r11_8_14_days;
	private BigDecimal r11_15_days_1_month;
	private BigDecimal r11_1_3_months;
	private BigDecimal r11_3_6_months;
	private BigDecimal r11_6_12_months;
	private BigDecimal r11_1_3_years;
	private BigDecimal r11_3_years;
	private BigDecimal r11_total;
	private String r12_product;
	private BigDecimal r12_overdue;
	private BigDecimal r12_overdraft;
	private BigDecimal r12_0_7_days;
	private BigDecimal r12_8_14_days;
	private BigDecimal r12_15_days_1_month;
	private BigDecimal r12_1_3_months;
	private BigDecimal r12_3_6_months;
	private BigDecimal r12_6_12_months;
	private BigDecimal r12_1_3_years;
	private BigDecimal r12_3_years;
	private BigDecimal r12_total;
	private String r13_product;
	private BigDecimal r13_overdue;
	private BigDecimal r13_overdraft;
	private BigDecimal r13_0_7_days;
	private BigDecimal r13_8_14_days;
	private BigDecimal r13_15_days_1_month;
	private BigDecimal r13_1_3_months;
	private BigDecimal r13_3_6_months;
	private BigDecimal r13_6_12_months;
	private BigDecimal r13_1_3_years;
	private BigDecimal r13_3_years;
	private BigDecimal r13_total;
	private String r14_product;
	private BigDecimal r14_overdue;
	private BigDecimal r14_overdraft;
	private BigDecimal r14_0_7_days;
	private BigDecimal r14_8_14_days;
	private BigDecimal r14_15_days_1_month;
	private BigDecimal r14_1_3_months;
	private BigDecimal r14_3_6_months;
	private BigDecimal r14_6_12_months;
	private BigDecimal r14_1_3_years;
	private BigDecimal r14_3_years;
	private BigDecimal r14_total;
	private String r15_product;
	private BigDecimal r15_overdue;
	private BigDecimal r15_overdraft;
	private BigDecimal r15_0_7_days;
	private BigDecimal r15_8_14_days;
	private BigDecimal r15_15_days_1_month;
	private BigDecimal r15_1_3_months;
	private BigDecimal r15_3_6_months;
	private BigDecimal r15_6_12_months;
	private BigDecimal r15_1_3_years;
	private BigDecimal r15_3_years;
	private BigDecimal r15_total;
	private String r16_product;
	private BigDecimal r16_overdue;
	private BigDecimal r16_overdraft;
	private BigDecimal r16_0_7_days;
	private BigDecimal r16_8_14_days;
	private BigDecimal r16_15_days_1_month;
	private BigDecimal r16_1_3_months;
	private BigDecimal r16_3_6_months;
	private BigDecimal r16_6_12_months;
	private BigDecimal r16_1_3_years;
	private BigDecimal r16_3_years;
	private BigDecimal r16_total;
	private String rh4_product;
	private BigDecimal rh4_overdue;
	private BigDecimal rh4_overdraft;
	private BigDecimal rh4_0_7_days;
	private BigDecimal rh4_8_14_days;
	private BigDecimal rh4_15_days_1_month;
	private BigDecimal rh4_1_3_months;
	private BigDecimal rh4_3_6_months;
	private BigDecimal rh4_6_12_months;
	private BigDecimal rh4_1_3_years;
	private BigDecimal rh4_3_years;
	private BigDecimal rh4_total;
	private String r17_product;
	private BigDecimal r17_overdue;
	private BigDecimal r17_overdraft;
	private BigDecimal r17_0_7_days;
	private BigDecimal r17_8_14_days;
	private BigDecimal r17_15_days_1_month;
	private BigDecimal r17_1_3_months;
	private BigDecimal r17_3_6_months;
	private BigDecimal r17_6_12_months;
	private BigDecimal r17_1_3_years;
	private BigDecimal r17_3_years;
	private BigDecimal r17_total;
	private String r18_product;
	private BigDecimal r18_overdue;
	private BigDecimal r18_overdraft;
	private BigDecimal r18_0_7_days;
	private BigDecimal r18_8_14_days;
	private BigDecimal r18_15_days_1_month;
	private BigDecimal r18_1_3_months;
	private BigDecimal r18_3_6_months;
	private BigDecimal r18_6_12_months;
	private BigDecimal r18_1_3_years;
	private BigDecimal r18_3_years;
	private BigDecimal r18_total;
	private String r_18_product;
	private BigDecimal r_18_overdue;
	private BigDecimal r_18_overdraft;
	private BigDecimal r_18_0_7_days;
	private BigDecimal r_18_8_14_days;
	private BigDecimal r_18_15_days_1_month;
	private BigDecimal r_18_1_3_months;
	private BigDecimal r_18_3_6_months;
	private BigDecimal r_18_6_12_months;
	private BigDecimal r_18_1_3_years;
	private BigDecimal r_18_3_years;
	private BigDecimal r_18_total;
	private String r19_product;
	private BigDecimal r19_overdue;
	private BigDecimal r19_overdraft;
	private BigDecimal r19_0_7_days;
	private BigDecimal r19_8_14_days;
	private BigDecimal r19_15_days_1_month;
	private BigDecimal r19_1_3_months;
	private BigDecimal r19_3_6_months;
	private BigDecimal r19_6_12_months;
	private BigDecimal r19_1_3_years;
	private BigDecimal r19_3_years;
	private BigDecimal r19_total;
	private String r20_product;
	private BigDecimal r20_overdue;
	private BigDecimal r20_overdraft;
	private BigDecimal r20_0_7_days;
	private BigDecimal r20_8_14_days;
	private BigDecimal r20_15_days_1_month;
	private BigDecimal r20_1_3_months;
	private BigDecimal r20_3_6_months;
	private BigDecimal r20_6_12_months;
	private BigDecimal r20_1_3_years;
	private BigDecimal r20_3_years;
	private BigDecimal r20_total;
	private String r21_product;
	private BigDecimal r21_overdue;
	private BigDecimal r21_overdraft;
	private BigDecimal r21_0_7_days;
	private BigDecimal r21_8_14_days;
	private BigDecimal r21_15_days_1_month;
	private BigDecimal r21_1_3_months;
	private BigDecimal r21_3_6_months;
	private BigDecimal r21_6_12_months;
	private BigDecimal r21_1_3_years;
	private BigDecimal r21_3_years;
	private BigDecimal r21_total;
	private String rh5_product;
	private BigDecimal rh5_overdue;
	private BigDecimal rh5_overdraft;
	private BigDecimal rh5_0_7_days;
	private BigDecimal rh5_8_14_days;
	private BigDecimal rh5_15_days_1_month;
	private BigDecimal rh5_1_3_months;
	private BigDecimal rh5_3_6_months;
	private BigDecimal rh5_6_12_months;
	private BigDecimal rh5_1_3_years;
	private BigDecimal rh5_3_years;
	private BigDecimal rh5_total;
	private String r22_product;
	private BigDecimal r22_overdue;
	private BigDecimal r22_overdraft;
	private BigDecimal r22_0_7_days;
	private BigDecimal r22_8_14_days;
	private BigDecimal r22_15_days_1_month;
	private BigDecimal r22_1_3_months;
	private BigDecimal r22_3_6_months;
	private BigDecimal r22_6_12_months;
	private BigDecimal r22_1_3_years;
	private BigDecimal r22_3_years;
	private BigDecimal r22_total;
	private String r23_product;
	private BigDecimal r23_overdue;
	private BigDecimal r23_overdraft;
	private BigDecimal r23_0_7_days;
	private BigDecimal r23_8_14_days;
	private BigDecimal r23_15_days_1_month;
	private BigDecimal r23_1_3_months;
	private BigDecimal r23_3_6_months;
	private BigDecimal r23_6_12_months;
	private BigDecimal r23_1_3_years;
	private BigDecimal r23_3_years;
	private BigDecimal r23_total;
	private String r24_product;
	private BigDecimal r24_overdue;
	private BigDecimal r24_overdraft;
	private BigDecimal r24_0_7_days;
	private BigDecimal r24_8_14_days;
	private BigDecimal r24_15_days_1_month;
	private BigDecimal r24_1_3_months;
	private BigDecimal r24_3_6_months;
	private BigDecimal r24_6_12_months;
	private BigDecimal r24_1_3_years;
	private BigDecimal r24_3_years;
	private BigDecimal r24_total;
	private String r25_product;
	private BigDecimal r25_overdue;
	private BigDecimal r25_overdraft;
	private BigDecimal r25_0_7_days;
	private BigDecimal r25_8_14_days;
	private BigDecimal r25_15_days_1_month;
	private BigDecimal r25_1_3_months;
	private BigDecimal r25_3_6_months;
	private BigDecimal r25_6_12_months;
	private BigDecimal r25_1_3_years;
	private BigDecimal r25_3_years;
	private BigDecimal r25_total;
	private String r26_product;
	private BigDecimal r26_overdue;
	private BigDecimal r26_overdraft;
	private BigDecimal r26_0_7_days;
	private BigDecimal r26_8_14_days;
	private BigDecimal r26_15_days_1_month;
	private BigDecimal r26_1_3_months;
	private BigDecimal r26_3_6_months;
	private BigDecimal r26_6_12_months;
	private BigDecimal r26_1_3_years;
	private BigDecimal r26_3_years;
	private BigDecimal r26_total;
	private String r27_product;
	private BigDecimal r27_overdue;
	private BigDecimal r27_overdraft;
	private BigDecimal r27_0_7_days;
	private BigDecimal r27_8_14_days;
	private BigDecimal r27_15_days_1_month;
	private BigDecimal r27_1_3_months;
	private BigDecimal r27_3_6_months;
	private BigDecimal r27_6_12_months;
	private BigDecimal r27_1_3_years;
	private BigDecimal r27_3_years;
	private BigDecimal r27_total;
	private String r28_product;
	private BigDecimal r28_overdue;
	private BigDecimal r28_overdraft;
	private BigDecimal r28_0_7_days;
	private BigDecimal r28_8_14_days;
	private BigDecimal r28_15_days_1_month;
	private BigDecimal r28_1_3_months;
	private BigDecimal r28_3_6_months;
	private BigDecimal r28_6_12_months;
	private BigDecimal r28_1_3_years;
	private BigDecimal r28_3_years;
	private BigDecimal r28_total;
	private String r29_product;
	private BigDecimal r29_overdue;
	private BigDecimal r29_overdraft;
	private BigDecimal r29_0_7_days;
	private BigDecimal r29_8_14_days;
	private BigDecimal r29_15_days_1_month;
	private BigDecimal r29_1_3_months;
	private BigDecimal r29_3_6_months;
	private BigDecimal r29_6_12_months;
	private BigDecimal r29_1_3_years;
	private BigDecimal r29_3_years;
	private BigDecimal r29_total;
	private String r30_product;
	private BigDecimal r30_overdue;
	private BigDecimal r30_overdraft;
	private BigDecimal r30_0_7_days;
	private BigDecimal r30_8_14_days;
	private BigDecimal r30_15_days_1_month;
	private BigDecimal r30_1_3_months;
	private BigDecimal r30_3_6_months;
	private BigDecimal r30_6_12_months;
	private BigDecimal r30_1_3_years;
	private BigDecimal r30_3_years;
	private BigDecimal r30_total;
	private String r31_product;
	private BigDecimal r31_overdue;
	private BigDecimal r31_overdraft;
	private BigDecimal r31_0_7_days;
	private BigDecimal r31_8_14_days;
	private BigDecimal r31_15_days_1_month;
	private BigDecimal r31_1_3_months;
	private BigDecimal r31_3_6_months;
	private BigDecimal r31_6_12_months;
	private BigDecimal r31_1_3_years;
	private BigDecimal r31_3_years;
	private BigDecimal r31_total;
	private String rta_product;
	private BigDecimal rta_overdue;
	private BigDecimal rta_overdraft;
	private BigDecimal rta_0_7_days;
	private BigDecimal rta_8_14_days;
	private BigDecimal rta_15_days_1_month;
	private BigDecimal rta_1_3_months;
	private BigDecimal rta_3_6_months;
	private BigDecimal rta_6_12_months;
	private BigDecimal rta_1_3_years;
	private BigDecimal rta_3_years;
	private BigDecimal rta_total;
	private String rh6_product;
	private BigDecimal rh6_overdue;
	private BigDecimal rh6_overdraft;
	private BigDecimal rh6_0_7_days;
	private BigDecimal rh6_8_14_days;
	private BigDecimal rh6_15_days_1_month;
	private BigDecimal rh6_1_3_months;
	private BigDecimal rh6_3_6_months;
	private BigDecimal rh6_6_12_months;
	private BigDecimal rh6_1_3_years;
	private BigDecimal rh6_3_years;
	private BigDecimal rh6_total;
	private String r32_product;
	private BigDecimal r32_overdue;
	private BigDecimal r32_overdraft;
	private BigDecimal r32_0_7_days;
	private BigDecimal r32_8_14_days;
	private BigDecimal r32_15_days_1_month;
	private BigDecimal r32_1_3_months;
	private BigDecimal r32_3_6_months;
	private BigDecimal r32_6_12_months;
	private BigDecimal r32_1_3_years;
	private BigDecimal r32_3_years;
	private BigDecimal r32_total;
	private String r33_product;
	private BigDecimal r33_overdue;
	private BigDecimal r33_overdraft;
	private BigDecimal r33_0_7_days;
	private BigDecimal r33_8_14_days;
	private BigDecimal r33_15_days_1_month;
	private BigDecimal r33_1_3_months;
	private BigDecimal r33_3_6_months;
	private BigDecimal r33_6_12_months;
	private BigDecimal r33_1_3_years;
	private BigDecimal r33_3_years;
	private BigDecimal r33_total;
	private String r34_product;
	private BigDecimal r34_overdue;
	private BigDecimal r34_overdraft;
	private BigDecimal r34_0_7_days;
	private BigDecimal r34_8_14_days;
	private BigDecimal r34_15_days_1_month;
	private BigDecimal r34_1_3_months;
	private BigDecimal r34_3_6_months;
	private BigDecimal r34_6_12_months;
	private BigDecimal r34_1_3_years;
	private BigDecimal r34_3_years;
	private BigDecimal r34_total;
	private String r35_product;
	private BigDecimal r35_overdue;
	private BigDecimal r35_overdraft;
	private BigDecimal r35_0_7_days;
	private BigDecimal r35_8_14_days;
	private BigDecimal r35_15_days_1_month;
	private BigDecimal r35_1_3_months;
	private BigDecimal r35_3_6_months;
	private BigDecimal r35_6_12_months;
	private BigDecimal r35_1_3_years;
	private BigDecimal r35_3_years;
	private BigDecimal r35_total;
	private String r36_product;
	private BigDecimal r36_overdue;
	private BigDecimal r36_overdraft;
	private BigDecimal r36_0_7_days;
	private BigDecimal r36_8_14_days;
	private BigDecimal r36_15_days_1_month;
	private BigDecimal r36_1_3_months;
	private BigDecimal r36_3_6_months;
	private BigDecimal r36_6_12_months;
	private BigDecimal r36_1_3_years;
	private BigDecimal r36_3_years;
	private BigDecimal r36_total;
	private String rh7_product;
	private BigDecimal rh7_overdue;
	private BigDecimal rh7_overdraft;
	private BigDecimal rh7_0_7_days;
	private BigDecimal rh7_8_14_days;
	private BigDecimal rh7_15_days_1_month;
	private BigDecimal rh7_1_3_months;
	private BigDecimal rh7_3_6_months;
	private BigDecimal rh7_6_12_months;
	private BigDecimal rh7_1_3_years;
	private BigDecimal rh7_3_years;
	private BigDecimal rh7_total;
	private String r37_product;
	private BigDecimal r37_overdue;
	private BigDecimal r37_overdraft;
	private BigDecimal r37_0_7_days;
	private BigDecimal r37_8_14_days;
	private BigDecimal r37_15_days_1_month;
	private BigDecimal r37_1_3_months;
	private BigDecimal r37_3_6_months;
	private BigDecimal r37_6_12_months;
	private BigDecimal r37_1_3_years;
	private BigDecimal r37_3_years;
	private BigDecimal r37_total;
	private String r38_product;
	private BigDecimal r38_overdue;
	private BigDecimal r38_overdraft;
	private BigDecimal r38_0_7_days;
	private BigDecimal r38_8_14_days;
	private BigDecimal r38_15_days_1_month;
	private BigDecimal r38_1_3_months;
	private BigDecimal r38_3_6_months;
	private BigDecimal r38_6_12_months;
	private BigDecimal r38_1_3_years;
	private BigDecimal r38_3_years;
	private BigDecimal r38_total;
	private String r39_product;
	private BigDecimal r39_overdue;
	private BigDecimal r39_overdraft;
	private BigDecimal r39_0_7_days;
	private BigDecimal r39_8_14_days;
	private BigDecimal r39_15_days_1_month;
	private BigDecimal r39_1_3_months;
	private BigDecimal r39_3_6_months;
	private BigDecimal r39_6_12_months;
	private BigDecimal r39_1_3_years;
	private BigDecimal r39_3_years;
	private BigDecimal r39_total;
	private String r40_product;
	private BigDecimal r40_overdue;
	private BigDecimal r40_overdraft;
	private BigDecimal r40_0_7_days;
	private BigDecimal r40_8_14_days;
	private BigDecimal r40_15_days_1_month;
	private BigDecimal r40_1_3_months;
	private BigDecimal r40_3_6_months;
	private BigDecimal r40_6_12_months;
	private BigDecimal r40_1_3_years;
	private BigDecimal r40_3_years;
	private BigDecimal r40_total;
	private String r41_product;
	private BigDecimal r41_overdue;
	private BigDecimal r41_overdraft;
	private BigDecimal r41_0_7_days;
	private BigDecimal r41_8_14_days;
	private BigDecimal r41_15_days_1_month;
	private BigDecimal r41_1_3_months;
	private BigDecimal r41_3_6_months;
	private BigDecimal r41_6_12_months;
	private BigDecimal r41_1_3_years;
	private BigDecimal r41_3_years;
	private BigDecimal r41_total;
	private String r42_product;
	private BigDecimal r42_overdue;
	private BigDecimal r42_overdraft;
	private BigDecimal r42_0_7_days;
	private BigDecimal r42_8_14_days;
	private BigDecimal r42_15_days_1_month;
	private BigDecimal r42_1_3_months;
	private BigDecimal r42_3_6_months;
	private BigDecimal r42_6_12_months;
	private BigDecimal r42_1_3_years;
	private BigDecimal r42_3_years;
	private BigDecimal r42_total;
	private String rh8_product;
	private BigDecimal rh8_overdue;
	private BigDecimal rh8_overdraft;
	private BigDecimal rh8_0_7_days;
	private BigDecimal rh8_8_14_days;
	private BigDecimal rh8_15_days_1_month;
	private BigDecimal rh8_1_3_months;
	private BigDecimal rh8_3_6_months;
	private BigDecimal rh8_6_12_months;
	private BigDecimal rh8_1_3_years;
	private BigDecimal rh8_3_years;
	private BigDecimal rh8_total;
	private String r43_product;
	private BigDecimal r43_overdue;
	private BigDecimal r43_overdraft;
	private BigDecimal r43_0_7_days;
	private BigDecimal r43_8_14_days;
	private BigDecimal r43_15_days_1_month;
	private BigDecimal r43_1_3_months;
	private BigDecimal r43_3_6_months;
	private BigDecimal r43_6_12_months;
	private BigDecimal r43_1_3_years;
	private BigDecimal r43_3_years;
	private BigDecimal r43_total;
	private String r44_product;
	private BigDecimal r44_overdue;
	private BigDecimal r44_overdraft;
	private BigDecimal r44_0_7_days;
	private BigDecimal r44_8_14_days;
	private BigDecimal r44_15_days_1_month;
	private BigDecimal r44_1_3_months;
	private BigDecimal r44_3_6_months;
	private BigDecimal r44_6_12_months;
	private BigDecimal r44_1_3_years;
	private BigDecimal r44_3_years;
	private BigDecimal r44_total;
	private String r45_product;
	private BigDecimal r45_overdue;
	private BigDecimal r45_overdraft;
	private BigDecimal r45_0_7_days;
	private BigDecimal r45_8_14_days;
	private BigDecimal r45_15_days_1_month;
	private BigDecimal r45_1_3_months;
	private BigDecimal r45_3_6_months;
	private BigDecimal r45_6_12_months;
	private BigDecimal r45_1_3_years;
	private BigDecimal r45_3_years;
	private BigDecimal r45_total;
	private String r46_product;
	private BigDecimal r46_overdue;
	private BigDecimal r46_overdraft;
	private BigDecimal r46_0_7_days;
	private BigDecimal r46_8_14_days;
	private BigDecimal r46_15_days_1_month;
	private BigDecimal r46_1_3_months;
	private BigDecimal r46_3_6_months;
	private BigDecimal r46_6_12_months;
	private BigDecimal r46_1_3_years;
	private BigDecimal r46_3_years;
	private BigDecimal r46_total;
	private String rtl_product;
	private BigDecimal rtl_overdue;
	private BigDecimal rtl_overdraft;
	private BigDecimal rtl_0_7_days;
	private BigDecimal rtl_8_14_days;
	private BigDecimal rtl_15_days_1_month;
	private BigDecimal rtl_1_3_months;
	private BigDecimal rtl_3_6_months;
	private BigDecimal rtl_6_12_months;
	private BigDecimal rtl_1_3_years;
	private BigDecimal rtl_3_years;
	private BigDecimal rtl_total;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Id
	private Date report_date;
	private Date report_from_date;
	private Date report_to_date;
	private String entity_flg;
	private String modify_flg;
	private String del_flg;
	private String report_code;
	private Date report_submit_date;
	private String repdesc;
	private String frequency;
	public String getRh_product() {
		return rh_product;
	}
	public BigDecimal getRh_overdue() {
		return rh_overdue;
	}
	public BigDecimal getRh_overdraft() {
		return rh_overdraft;
	}
	public BigDecimal getRh_0_7_days() {
		return rh_0_7_days;
	}
	public BigDecimal getRh_8_14_days() {
		return rh_8_14_days;
	}
	public BigDecimal getRh_15_days_1_month() {
		return rh_15_days_1_month;
	}
	public BigDecimal getRh_1_3_months() {
		return rh_1_3_months;
	}
	public BigDecimal getRh_3_6_months() {
		return rh_3_6_months;
	}
	public BigDecimal getRh_6_12_months() {
		return rh_6_12_months;
	}
	public BigDecimal getRh_1_3_years() {
		return rh_1_3_years;
	}
	public BigDecimal getRh_3_years() {
		return rh_3_years;
	}
	public BigDecimal getRh_total() {
		return rh_total;
	}
	public String getR1_product() {
		return r1_product;
	}
	public BigDecimal getR1_overdue() {
		return r1_overdue;
	}
	public BigDecimal getR1_overdraft() {
		return r1_overdraft;
	}
	public BigDecimal getR1_0_7_days() {
		return r1_0_7_days;
	}
	public BigDecimal getR1_8_14_days() {
		return r1_8_14_days;
	}
	public BigDecimal getR1_15_days_1_month() {
		return r1_15_days_1_month;
	}
	public BigDecimal getR1_1_3_months() {
		return r1_1_3_months;
	}
	public BigDecimal getR1_3_6_months() {
		return r1_3_6_months;
	}
	public BigDecimal getR1_6_12_months() {
		return r1_6_12_months;
	}
	public BigDecimal getR1_1_3_years() {
		return r1_1_3_years;
	}
	public BigDecimal getR1_3_years() {
		return r1_3_years;
	}
	public BigDecimal getR1_total() {
		return r1_total;
	}
	public String getR2_product() {
		return r2_product;
	}
	public BigDecimal getR2_overdue() {
		return r2_overdue;
	}
	public BigDecimal getR2_overdraft() {
		return r2_overdraft;
	}
	public BigDecimal getR2_0_7_days() {
		return r2_0_7_days;
	}
	public BigDecimal getR2_8_14_days() {
		return r2_8_14_days;
	}
	public BigDecimal getR2_15_days_1_month() {
		return r2_15_days_1_month;
	}
	public BigDecimal getR2_1_3_months() {
		return r2_1_3_months;
	}
	public BigDecimal getR2_3_6_months() {
		return r2_3_6_months;
	}
	public BigDecimal getR2_6_12_months() {
		return r2_6_12_months;
	}
	public BigDecimal getR2_1_3_years() {
		return r2_1_3_years;
	}
	public BigDecimal getR2_3_years() {
		return r2_3_years;
	}
	public BigDecimal getR2_total() {
		return r2_total;
	}
	public String getR3_product() {
		return r3_product;
	}
	public BigDecimal getR3_overdue() {
		return r3_overdue;
	}
	public BigDecimal getR3_overdraft() {
		return r3_overdraft;
	}
	public BigDecimal getR3_0_7_days() {
		return r3_0_7_days;
	}
	public BigDecimal getR3_8_14_days() {
		return r3_8_14_days;
	}
	public BigDecimal getR3_15_days_1_month() {
		return r3_15_days_1_month;
	}
	public BigDecimal getR3_1_3_months() {
		return r3_1_3_months;
	}
	public BigDecimal getR3_3_6_months() {
		return r3_3_6_months;
	}
	public BigDecimal getR3_6_12_months() {
		return r3_6_12_months;
	}
	public BigDecimal getR3_1_3_years() {
		return r3_1_3_years;
	}
	public BigDecimal getR3_3_years() {
		return r3_3_years;
	}
	public BigDecimal getR3_total() {
		return r3_total;
	}
	public String getRh2_product() {
		return rh2_product;
	}
	public BigDecimal getRh2_overdue() {
		return rh2_overdue;
	}
	public BigDecimal getRh2_overdraft() {
		return rh2_overdraft;
	}
	public BigDecimal getRh2_0_7_days() {
		return rh2_0_7_days;
	}
	public BigDecimal getRh2_8_14_days() {
		return rh2_8_14_days;
	}
	public BigDecimal getRh2_15_days_1_month() {
		return rh2_15_days_1_month;
	}
	public BigDecimal getRh2_1_3_months() {
		return rh2_1_3_months;
	}
	public BigDecimal getRh2_3_6_months() {
		return rh2_3_6_months;
	}
	public BigDecimal getRh2_6_12_months() {
		return rh2_6_12_months;
	}
	public BigDecimal getRh2_1_3_years() {
		return rh2_1_3_years;
	}
	public BigDecimal getRh2_3_years() {
		return rh2_3_years;
	}
	public BigDecimal getRh2_total() {
		return rh2_total;
	}
	public String getR4_product() {
		return r4_product;
	}
	public BigDecimal getR4_overdue() {
		return r4_overdue;
	}
	public BigDecimal getR4_overdraft() {
		return r4_overdraft;
	}
	public BigDecimal getR4_0_7_days() {
		return r4_0_7_days;
	}
	public BigDecimal getR4_8_14_days() {
		return r4_8_14_days;
	}
	public BigDecimal getR4_15_days_1_month() {
		return r4_15_days_1_month;
	}
	public BigDecimal getR4_1_3_months() {
		return r4_1_3_months;
	}
	public BigDecimal getR4_3_6_months() {
		return r4_3_6_months;
	}
	public BigDecimal getR4_6_12_months() {
		return r4_6_12_months;
	}
	public BigDecimal getR4_1_3_years() {
		return r4_1_3_years;
	}
	public BigDecimal getR4_3_years() {
		return r4_3_years;
	}
	public BigDecimal getR4_total() {
		return r4_total;
	}
	public String getR5_product() {
		return r5_product;
	}
	public BigDecimal getR5_overdue() {
		return r5_overdue;
	}
	public BigDecimal getR5_overdraft() {
		return r5_overdraft;
	}
	public BigDecimal getR5_0_7_days() {
		return r5_0_7_days;
	}
	public BigDecimal getR5_8_14_days() {
		return r5_8_14_days;
	}
	public BigDecimal getR5_15_days_1_month() {
		return r5_15_days_1_month;
	}
	public BigDecimal getR5_1_3_months() {
		return r5_1_3_months;
	}
	public BigDecimal getR5_3_6_months() {
		return r5_3_6_months;
	}
	public BigDecimal getR5_6_12_months() {
		return r5_6_12_months;
	}
	public BigDecimal getR5_1_3_years() {
		return r5_1_3_years;
	}
	public BigDecimal getR5_3_years() {
		return r5_3_years;
	}
	public BigDecimal getR5_total() {
		return r5_total;
	}
	public String getR6_product() {
		return r6_product;
	}
	public BigDecimal getR6_overdue() {
		return r6_overdue;
	}
	public BigDecimal getR6_overdraft() {
		return r6_overdraft;
	}
	public BigDecimal getR6_0_7_days() {
		return r6_0_7_days;
	}
	public BigDecimal getR6_8_14_days() {
		return r6_8_14_days;
	}
	public BigDecimal getR6_15_days_1_month() {
		return r6_15_days_1_month;
	}
	public BigDecimal getR6_1_3_months() {
		return r6_1_3_months;
	}
	public BigDecimal getR6_3_6_months() {
		return r6_3_6_months;
	}
	public BigDecimal getR6_6_12_months() {
		return r6_6_12_months;
	}
	public BigDecimal getR6_1_3_years() {
		return r6_1_3_years;
	}
	public BigDecimal getR6_3_years() {
		return r6_3_years;
	}
	public BigDecimal getR6_total() {
		return r6_total;
	}
	public String getRh3_product() {
		return rh3_product;
	}
	public BigDecimal getRh3_overdue() {
		return rh3_overdue;
	}
	public BigDecimal getRh3_overdraft() {
		return rh3_overdraft;
	}
	public BigDecimal getRh3_0_7_days() {
		return rh3_0_7_days;
	}
	public BigDecimal getRh3_8_14_days() {
		return rh3_8_14_days;
	}
	public BigDecimal getRh3_15_days_1_month() {
		return rh3_15_days_1_month;
	}
	public BigDecimal getRh3_1_3_months() {
		return rh3_1_3_months;
	}
	public BigDecimal getRh3_3_6_months() {
		return rh3_3_6_months;
	}
	public BigDecimal getRh3_6_12_months() {
		return rh3_6_12_months;
	}
	public BigDecimal getRh3_1_3_years() {
		return rh3_1_3_years;
	}
	public BigDecimal getRh3_3_years() {
		return rh3_3_years;
	}
	public BigDecimal getRh3_total() {
		return rh3_total;
	}
	public String getR7_product() {
		return r7_product;
	}
	public BigDecimal getR7_overdue() {
		return r7_overdue;
	}
	public BigDecimal getR7_overdraft() {
		return r7_overdraft;
	}
	public BigDecimal getR7_0_7_days() {
		return r7_0_7_days;
	}
	public BigDecimal getR7_8_14_days() {
		return r7_8_14_days;
	}
	public BigDecimal getR7_15_days_1_month() {
		return r7_15_days_1_month;
	}
	public BigDecimal getR7_1_3_months() {
		return r7_1_3_months;
	}
	public BigDecimal getR7_3_6_months() {
		return r7_3_6_months;
	}
	public BigDecimal getR7_6_12_months() {
		return r7_6_12_months;
	}
	public BigDecimal getR7_1_3_years() {
		return r7_1_3_years;
	}
	public BigDecimal getR7_3_years() {
		return r7_3_years;
	}
	public BigDecimal getR7_total() {
		return r7_total;
	}
	public String getR8_product() {
		return r8_product;
	}
	public BigDecimal getR8_overdue() {
		return r8_overdue;
	}
	public BigDecimal getR8_overdraft() {
		return r8_overdraft;
	}
	public BigDecimal getR8_0_7_days() {
		return r8_0_7_days;
	}
	public BigDecimal getR8_8_14_days() {
		return r8_8_14_days;
	}
	public BigDecimal getR8_15_days_1_month() {
		return r8_15_days_1_month;
	}
	public BigDecimal getR8_1_3_months() {
		return r8_1_3_months;
	}
	public BigDecimal getR8_3_6_months() {
		return r8_3_6_months;
	}
	public BigDecimal getR8_6_12_months() {
		return r8_6_12_months;
	}
	public BigDecimal getR8_1_3_years() {
		return r8_1_3_years;
	}
	public BigDecimal getR8_3_years() {
		return r8_3_years;
	}
	public BigDecimal getR8_total() {
		return r8_total;
	}
	public String getR9_product() {
		return r9_product;
	}
	public BigDecimal getR9_overdue() {
		return r9_overdue;
	}
	public BigDecimal getR9_overdraft() {
		return r9_overdraft;
	}
	public BigDecimal getR9_0_7_days() {
		return r9_0_7_days;
	}
	public BigDecimal getR9_8_14_days() {
		return r9_8_14_days;
	}
	public BigDecimal getR9_15_days_1_month() {
		return r9_15_days_1_month;
	}
	public BigDecimal getR9_1_3_months() {
		return r9_1_3_months;
	}
	public BigDecimal getR9_3_6_months() {
		return r9_3_6_months;
	}
	public BigDecimal getR9_6_12_months() {
		return r9_6_12_months;
	}
	public BigDecimal getR9_1_3_years() {
		return r9_1_3_years;
	}
	public BigDecimal getR9_3_years() {
		return r9_3_years;
	}
	public BigDecimal getR9_total() {
		return r9_total;
	}
	public String getR10_product() {
		return r10_product;
	}
	public BigDecimal getR10_overdue() {
		return r10_overdue;
	}
	public BigDecimal getR10_overdraft() {
		return r10_overdraft;
	}
	public BigDecimal getR10_0_7_days() {
		return r10_0_7_days;
	}
	public BigDecimal getR10_8_14_days() {
		return r10_8_14_days;
	}
	public BigDecimal getR10_15_days_1_month() {
		return r10_15_days_1_month;
	}
	public BigDecimal getR10_1_3_months() {
		return r10_1_3_months;
	}
	public BigDecimal getR10_3_6_months() {
		return r10_3_6_months;
	}
	public BigDecimal getR10_6_12_months() {
		return r10_6_12_months;
	}
	public BigDecimal getR10_1_3_years() {
		return r10_1_3_years;
	}
	public BigDecimal getR10_3_years() {
		return r10_3_years;
	}
	public BigDecimal getR10_total() {
		return r10_total;
	}
	public String getR11_product() {
		return r11_product;
	}
	public BigDecimal getR11_overdue() {
		return r11_overdue;
	}
	public BigDecimal getR11_overdraft() {
		return r11_overdraft;
	}
	public BigDecimal getR11_0_7_days() {
		return r11_0_7_days;
	}
	public BigDecimal getR11_8_14_days() {
		return r11_8_14_days;
	}
	public BigDecimal getR11_15_days_1_month() {
		return r11_15_days_1_month;
	}
	public BigDecimal getR11_1_3_months() {
		return r11_1_3_months;
	}
	public BigDecimal getR11_3_6_months() {
		return r11_3_6_months;
	}
	public BigDecimal getR11_6_12_months() {
		return r11_6_12_months;
	}
	public BigDecimal getR11_1_3_years() {
		return r11_1_3_years;
	}
	public BigDecimal getR11_3_years() {
		return r11_3_years;
	}
	public BigDecimal getR11_total() {
		return r11_total;
	}
	public String getR12_product() {
		return r12_product;
	}
	public BigDecimal getR12_overdue() {
		return r12_overdue;
	}
	public BigDecimal getR12_overdraft() {
		return r12_overdraft;
	}
	public BigDecimal getR12_0_7_days() {
		return r12_0_7_days;
	}
	public BigDecimal getR12_8_14_days() {
		return r12_8_14_days;
	}
	public BigDecimal getR12_15_days_1_month() {
		return r12_15_days_1_month;
	}
	public BigDecimal getR12_1_3_months() {
		return r12_1_3_months;
	}
	public BigDecimal getR12_3_6_months() {
		return r12_3_6_months;
	}
	public BigDecimal getR12_6_12_months() {
		return r12_6_12_months;
	}
	public BigDecimal getR12_1_3_years() {
		return r12_1_3_years;
	}
	public BigDecimal getR12_3_years() {
		return r12_3_years;
	}
	public BigDecimal getR12_total() {
		return r12_total;
	}
	public String getR13_product() {
		return r13_product;
	}
	public BigDecimal getR13_overdue() {
		return r13_overdue;
	}
	public BigDecimal getR13_overdraft() {
		return r13_overdraft;
	}
	public BigDecimal getR13_0_7_days() {
		return r13_0_7_days;
	}
	public BigDecimal getR13_8_14_days() {
		return r13_8_14_days;
	}
	public BigDecimal getR13_15_days_1_month() {
		return r13_15_days_1_month;
	}
	public BigDecimal getR13_1_3_months() {
		return r13_1_3_months;
	}
	public BigDecimal getR13_3_6_months() {
		return r13_3_6_months;
	}
	public BigDecimal getR13_6_12_months() {
		return r13_6_12_months;
	}
	public BigDecimal getR13_1_3_years() {
		return r13_1_3_years;
	}
	public BigDecimal getR13_3_years() {
		return r13_3_years;
	}
	public BigDecimal getR13_total() {
		return r13_total;
	}
	public String getR14_product() {
		return r14_product;
	}
	public BigDecimal getR14_overdue() {
		return r14_overdue;
	}
	public BigDecimal getR14_overdraft() {
		return r14_overdraft;
	}
	public BigDecimal getR14_0_7_days() {
		return r14_0_7_days;
	}
	public BigDecimal getR14_8_14_days() {
		return r14_8_14_days;
	}
	public BigDecimal getR14_15_days_1_month() {
		return r14_15_days_1_month;
	}
	public BigDecimal getR14_1_3_months() {
		return r14_1_3_months;
	}
	public BigDecimal getR14_3_6_months() {
		return r14_3_6_months;
	}
	public BigDecimal getR14_6_12_months() {
		return r14_6_12_months;
	}
	public BigDecimal getR14_1_3_years() {
		return r14_1_3_years;
	}
	public BigDecimal getR14_3_years() {
		return r14_3_years;
	}
	public BigDecimal getR14_total() {
		return r14_total;
	}
	public String getR15_product() {
		return r15_product;
	}
	public BigDecimal getR15_overdue() {
		return r15_overdue;
	}
	public BigDecimal getR15_overdraft() {
		return r15_overdraft;
	}
	public BigDecimal getR15_0_7_days() {
		return r15_0_7_days;
	}
	public BigDecimal getR15_8_14_days() {
		return r15_8_14_days;
	}
	public BigDecimal getR15_15_days_1_month() {
		return r15_15_days_1_month;
	}
	public BigDecimal getR15_1_3_months() {
		return r15_1_3_months;
	}
	public BigDecimal getR15_3_6_months() {
		return r15_3_6_months;
	}
	public BigDecimal getR15_6_12_months() {
		return r15_6_12_months;
	}
	public BigDecimal getR15_1_3_years() {
		return r15_1_3_years;
	}
	public BigDecimal getR15_3_years() {
		return r15_3_years;
	}
	public BigDecimal getR15_total() {
		return r15_total;
	}
	public String getR16_product() {
		return r16_product;
	}
	public BigDecimal getR16_overdue() {
		return r16_overdue;
	}
	public BigDecimal getR16_overdraft() {
		return r16_overdraft;
	}
	public BigDecimal getR16_0_7_days() {
		return r16_0_7_days;
	}
	public BigDecimal getR16_8_14_days() {
		return r16_8_14_days;
	}
	public BigDecimal getR16_15_days_1_month() {
		return r16_15_days_1_month;
	}
	public BigDecimal getR16_1_3_months() {
		return r16_1_3_months;
	}
	public BigDecimal getR16_3_6_months() {
		return r16_3_6_months;
	}
	public BigDecimal getR16_6_12_months() {
		return r16_6_12_months;
	}
	public BigDecimal getR16_1_3_years() {
		return r16_1_3_years;
	}
	public BigDecimal getR16_3_years() {
		return r16_3_years;
	}
	public BigDecimal getR16_total() {
		return r16_total;
	}
	public String getRh4_product() {
		return rh4_product;
	}
	public BigDecimal getRh4_overdue() {
		return rh4_overdue;
	}
	public BigDecimal getRh4_overdraft() {
		return rh4_overdraft;
	}
	public BigDecimal getRh4_0_7_days() {
		return rh4_0_7_days;
	}
	public BigDecimal getRh4_8_14_days() {
		return rh4_8_14_days;
	}
	public BigDecimal getRh4_15_days_1_month() {
		return rh4_15_days_1_month;
	}
	public BigDecimal getRh4_1_3_months() {
		return rh4_1_3_months;
	}
	public BigDecimal getRh4_3_6_months() {
		return rh4_3_6_months;
	}
	public BigDecimal getRh4_6_12_months() {
		return rh4_6_12_months;
	}
	public BigDecimal getRh4_1_3_years() {
		return rh4_1_3_years;
	}
	public BigDecimal getRh4_3_years() {
		return rh4_3_years;
	}
	public BigDecimal getRh4_total() {
		return rh4_total;
	}
	public String getR17_product() {
		return r17_product;
	}
	public BigDecimal getR17_overdue() {
		return r17_overdue;
	}
	public BigDecimal getR17_overdraft() {
		return r17_overdraft;
	}
	public BigDecimal getR17_0_7_days() {
		return r17_0_7_days;
	}
	public BigDecimal getR17_8_14_days() {
		return r17_8_14_days;
	}
	public BigDecimal getR17_15_days_1_month() {
		return r17_15_days_1_month;
	}
	public BigDecimal getR17_1_3_months() {
		return r17_1_3_months;
	}
	public BigDecimal getR17_3_6_months() {
		return r17_3_6_months;
	}
	public BigDecimal getR17_6_12_months() {
		return r17_6_12_months;
	}
	public BigDecimal getR17_1_3_years() {
		return r17_1_3_years;
	}
	public BigDecimal getR17_3_years() {
		return r17_3_years;
	}
	public BigDecimal getR17_total() {
		return r17_total;
	}
	public String getR18_product() {
		return r18_product;
	}
	public BigDecimal getR18_overdue() {
		return r18_overdue;
	}
	public BigDecimal getR18_overdraft() {
		return r18_overdraft;
	}
	public BigDecimal getR18_0_7_days() {
		return r18_0_7_days;
	}
	public BigDecimal getR18_8_14_days() {
		return r18_8_14_days;
	}
	public BigDecimal getR18_15_days_1_month() {
		return r18_15_days_1_month;
	}
	public BigDecimal getR18_1_3_months() {
		return r18_1_3_months;
	}
	public BigDecimal getR18_3_6_months() {
		return r18_3_6_months;
	}
	public BigDecimal getR18_6_12_months() {
		return r18_6_12_months;
	}
	public BigDecimal getR18_1_3_years() {
		return r18_1_3_years;
	}
	public BigDecimal getR18_3_years() {
		return r18_3_years;
	}
	public BigDecimal getR18_total() {
		return r18_total;
	}
	public String getR_18_product() {
		return r_18_product;
	}
	public BigDecimal getR_18_overdue() {
		return r_18_overdue;
	}
	public BigDecimal getR_18_overdraft() {
		return r_18_overdraft;
	}
	public BigDecimal getR_18_0_7_days() {
		return r_18_0_7_days;
	}
	public BigDecimal getR_18_8_14_days() {
		return r_18_8_14_days;
	}
	public BigDecimal getR_18_15_days_1_month() {
		return r_18_15_days_1_month;
	}
	public BigDecimal getR_18_1_3_months() {
		return r_18_1_3_months;
	}
	public BigDecimal getR_18_3_6_months() {
		return r_18_3_6_months;
	}
	public BigDecimal getR_18_6_12_months() {
		return r_18_6_12_months;
	}
	public BigDecimal getR_18_1_3_years() {
		return r_18_1_3_years;
	}
	public BigDecimal getR_18_3_years() {
		return r_18_3_years;
	}
	public BigDecimal getR_18_total() {
		return r_18_total;
	}
	public String getR19_product() {
		return r19_product;
	}
	public BigDecimal getR19_overdue() {
		return r19_overdue;
	}
	public BigDecimal getR19_overdraft() {
		return r19_overdraft;
	}
	public BigDecimal getR19_0_7_days() {
		return r19_0_7_days;
	}
	public BigDecimal getR19_8_14_days() {
		return r19_8_14_days;
	}
	public BigDecimal getR19_15_days_1_month() {
		return r19_15_days_1_month;
	}
	public BigDecimal getR19_1_3_months() {
		return r19_1_3_months;
	}
	public BigDecimal getR19_3_6_months() {
		return r19_3_6_months;
	}
	public BigDecimal getR19_6_12_months() {
		return r19_6_12_months;
	}
	public BigDecimal getR19_1_3_years() {
		return r19_1_3_years;
	}
	public BigDecimal getR19_3_years() {
		return r19_3_years;
	}
	public BigDecimal getR19_total() {
		return r19_total;
	}
	public String getR20_product() {
		return r20_product;
	}
	public BigDecimal getR20_overdue() {
		return r20_overdue;
	}
	public BigDecimal getR20_overdraft() {
		return r20_overdraft;
	}
	public BigDecimal getR20_0_7_days() {
		return r20_0_7_days;
	}
	public BigDecimal getR20_8_14_days() {
		return r20_8_14_days;
	}
	public BigDecimal getR20_15_days_1_month() {
		return r20_15_days_1_month;
	}
	public BigDecimal getR20_1_3_months() {
		return r20_1_3_months;
	}
	public BigDecimal getR20_3_6_months() {
		return r20_3_6_months;
	}
	public BigDecimal getR20_6_12_months() {
		return r20_6_12_months;
	}
	public BigDecimal getR20_1_3_years() {
		return r20_1_3_years;
	}
	public BigDecimal getR20_3_years() {
		return r20_3_years;
	}
	public BigDecimal getR20_total() {
		return r20_total;
	}
	public String getR21_product() {
		return r21_product;
	}
	public BigDecimal getR21_overdue() {
		return r21_overdue;
	}
	public BigDecimal getR21_overdraft() {
		return r21_overdraft;
	}
	public BigDecimal getR21_0_7_days() {
		return r21_0_7_days;
	}
	public BigDecimal getR21_8_14_days() {
		return r21_8_14_days;
	}
	public BigDecimal getR21_15_days_1_month() {
		return r21_15_days_1_month;
	}
	public BigDecimal getR21_1_3_months() {
		return r21_1_3_months;
	}
	public BigDecimal getR21_3_6_months() {
		return r21_3_6_months;
	}
	public BigDecimal getR21_6_12_months() {
		return r21_6_12_months;
	}
	public BigDecimal getR21_1_3_years() {
		return r21_1_3_years;
	}
	public BigDecimal getR21_3_years() {
		return r21_3_years;
	}
	public BigDecimal getR21_total() {
		return r21_total;
	}
	public String getRh5_product() {
		return rh5_product;
	}
	public BigDecimal getRh5_overdue() {
		return rh5_overdue;
	}
	public BigDecimal getRh5_overdraft() {
		return rh5_overdraft;
	}
	public BigDecimal getRh5_0_7_days() {
		return rh5_0_7_days;
	}
	public BigDecimal getRh5_8_14_days() {
		return rh5_8_14_days;
	}
	public BigDecimal getRh5_15_days_1_month() {
		return rh5_15_days_1_month;
	}
	public BigDecimal getRh5_1_3_months() {
		return rh5_1_3_months;
	}
	public BigDecimal getRh5_3_6_months() {
		return rh5_3_6_months;
	}
	public BigDecimal getRh5_6_12_months() {
		return rh5_6_12_months;
	}
	public BigDecimal getRh5_1_3_years() {
		return rh5_1_3_years;
	}
	public BigDecimal getRh5_3_years() {
		return rh5_3_years;
	}
	public BigDecimal getRh5_total() {
		return rh5_total;
	}
	public String getR22_product() {
		return r22_product;
	}
	public BigDecimal getR22_overdue() {
		return r22_overdue;
	}
	public BigDecimal getR22_overdraft() {
		return r22_overdraft;
	}
	public BigDecimal getR22_0_7_days() {
		return r22_0_7_days;
	}
	public BigDecimal getR22_8_14_days() {
		return r22_8_14_days;
	}
	public BigDecimal getR22_15_days_1_month() {
		return r22_15_days_1_month;
	}
	public BigDecimal getR22_1_3_months() {
		return r22_1_3_months;
	}
	public BigDecimal getR22_3_6_months() {
		return r22_3_6_months;
	}
	public BigDecimal getR22_6_12_months() {
		return r22_6_12_months;
	}
	public BigDecimal getR22_1_3_years() {
		return r22_1_3_years;
	}
	public BigDecimal getR22_3_years() {
		return r22_3_years;
	}
	public BigDecimal getR22_total() {
		return r22_total;
	}
	public String getR23_product() {
		return r23_product;
	}
	public BigDecimal getR23_overdue() {
		return r23_overdue;
	}
	public BigDecimal getR23_overdraft() {
		return r23_overdraft;
	}
	public BigDecimal getR23_0_7_days() {
		return r23_0_7_days;
	}
	public BigDecimal getR23_8_14_days() {
		return r23_8_14_days;
	}
	public BigDecimal getR23_15_days_1_month() {
		return r23_15_days_1_month;
	}
	public BigDecimal getR23_1_3_months() {
		return r23_1_3_months;
	}
	public BigDecimal getR23_3_6_months() {
		return r23_3_6_months;
	}
	public BigDecimal getR23_6_12_months() {
		return r23_6_12_months;
	}
	public BigDecimal getR23_1_3_years() {
		return r23_1_3_years;
	}
	public BigDecimal getR23_3_years() {
		return r23_3_years;
	}
	public BigDecimal getR23_total() {
		return r23_total;
	}
	public String getR24_product() {
		return r24_product;
	}
	public BigDecimal getR24_overdue() {
		return r24_overdue;
	}
	public BigDecimal getR24_overdraft() {
		return r24_overdraft;
	}
	public BigDecimal getR24_0_7_days() {
		return r24_0_7_days;
	}
	public BigDecimal getR24_8_14_days() {
		return r24_8_14_days;
	}
	public BigDecimal getR24_15_days_1_month() {
		return r24_15_days_1_month;
	}
	public BigDecimal getR24_1_3_months() {
		return r24_1_3_months;
	}
	public BigDecimal getR24_3_6_months() {
		return r24_3_6_months;
	}
	public BigDecimal getR24_6_12_months() {
		return r24_6_12_months;
	}
	public BigDecimal getR24_1_3_years() {
		return r24_1_3_years;
	}
	public BigDecimal getR24_3_years() {
		return r24_3_years;
	}
	public BigDecimal getR24_total() {
		return r24_total;
	}
	public String getR25_product() {
		return r25_product;
	}
	public BigDecimal getR25_overdue() {
		return r25_overdue;
	}
	public BigDecimal getR25_overdraft() {
		return r25_overdraft;
	}
	public BigDecimal getR25_0_7_days() {
		return r25_0_7_days;
	}
	public BigDecimal getR25_8_14_days() {
		return r25_8_14_days;
	}
	public BigDecimal getR25_15_days_1_month() {
		return r25_15_days_1_month;
	}
	public BigDecimal getR25_1_3_months() {
		return r25_1_3_months;
	}
	public BigDecimal getR25_3_6_months() {
		return r25_3_6_months;
	}
	public BigDecimal getR25_6_12_months() {
		return r25_6_12_months;
	}
	public BigDecimal getR25_1_3_years() {
		return r25_1_3_years;
	}
	public BigDecimal getR25_3_years() {
		return r25_3_years;
	}
	public BigDecimal getR25_total() {
		return r25_total;
	}
	public String getR26_product() {
		return r26_product;
	}
	public BigDecimal getR26_overdue() {
		return r26_overdue;
	}
	public BigDecimal getR26_overdraft() {
		return r26_overdraft;
	}
	public BigDecimal getR26_0_7_days() {
		return r26_0_7_days;
	}
	public BigDecimal getR26_8_14_days() {
		return r26_8_14_days;
	}
	public BigDecimal getR26_15_days_1_month() {
		return r26_15_days_1_month;
	}
	public BigDecimal getR26_1_3_months() {
		return r26_1_3_months;
	}
	public BigDecimal getR26_3_6_months() {
		return r26_3_6_months;
	}
	public BigDecimal getR26_6_12_months() {
		return r26_6_12_months;
	}
	public BigDecimal getR26_1_3_years() {
		return r26_1_3_years;
	}
	public BigDecimal getR26_3_years() {
		return r26_3_years;
	}
	public BigDecimal getR26_total() {
		return r26_total;
	}
	public String getR27_product() {
		return r27_product;
	}
	public BigDecimal getR27_overdue() {
		return r27_overdue;
	}
	public BigDecimal getR27_overdraft() {
		return r27_overdraft;
	}
	public BigDecimal getR27_0_7_days() {
		return r27_0_7_days;
	}
	public BigDecimal getR27_8_14_days() {
		return r27_8_14_days;
	}
	public BigDecimal getR27_15_days_1_month() {
		return r27_15_days_1_month;
	}
	public BigDecimal getR27_1_3_months() {
		return r27_1_3_months;
	}
	public BigDecimal getR27_3_6_months() {
		return r27_3_6_months;
	}
	public BigDecimal getR27_6_12_months() {
		return r27_6_12_months;
	}
	public BigDecimal getR27_1_3_years() {
		return r27_1_3_years;
	}
	public BigDecimal getR27_3_years() {
		return r27_3_years;
	}
	public BigDecimal getR27_total() {
		return r27_total;
	}
	public String getR28_product() {
		return r28_product;
	}
	public BigDecimal getR28_overdue() {
		return r28_overdue;
	}
	public BigDecimal getR28_overdraft() {
		return r28_overdraft;
	}
	public BigDecimal getR28_0_7_days() {
		return r28_0_7_days;
	}
	public BigDecimal getR28_8_14_days() {
		return r28_8_14_days;
	}
	public BigDecimal getR28_15_days_1_month() {
		return r28_15_days_1_month;
	}
	public BigDecimal getR28_1_3_months() {
		return r28_1_3_months;
	}
	public BigDecimal getR28_3_6_months() {
		return r28_3_6_months;
	}
	public BigDecimal getR28_6_12_months() {
		return r28_6_12_months;
	}
	public BigDecimal getR28_1_3_years() {
		return r28_1_3_years;
	}
	public BigDecimal getR28_3_years() {
		return r28_3_years;
	}
	public BigDecimal getR28_total() {
		return r28_total;
	}
	public String getR29_product() {
		return r29_product;
	}
	public BigDecimal getR29_overdue() {
		return r29_overdue;
	}
	public BigDecimal getR29_overdraft() {
		return r29_overdraft;
	}
	public BigDecimal getR29_0_7_days() {
		return r29_0_7_days;
	}
	public BigDecimal getR29_8_14_days() {
		return r29_8_14_days;
	}
	public BigDecimal getR29_15_days_1_month() {
		return r29_15_days_1_month;
	}
	public BigDecimal getR29_1_3_months() {
		return r29_1_3_months;
	}
	public BigDecimal getR29_3_6_months() {
		return r29_3_6_months;
	}
	public BigDecimal getR29_6_12_months() {
		return r29_6_12_months;
	}
	public BigDecimal getR29_1_3_years() {
		return r29_1_3_years;
	}
	public BigDecimal getR29_3_years() {
		return r29_3_years;
	}
	public BigDecimal getR29_total() {
		return r29_total;
	}
	public String getR30_product() {
		return r30_product;
	}
	public BigDecimal getR30_overdue() {
		return r30_overdue;
	}
	public BigDecimal getR30_overdraft() {
		return r30_overdraft;
	}
	public BigDecimal getR30_0_7_days() {
		return r30_0_7_days;
	}
	public BigDecimal getR30_8_14_days() {
		return r30_8_14_days;
	}
	public BigDecimal getR30_15_days_1_month() {
		return r30_15_days_1_month;
	}
	public BigDecimal getR30_1_3_months() {
		return r30_1_3_months;
	}
	public BigDecimal getR30_3_6_months() {
		return r30_3_6_months;
	}
	public BigDecimal getR30_6_12_months() {
		return r30_6_12_months;
	}
	public BigDecimal getR30_1_3_years() {
		return r30_1_3_years;
	}
	public BigDecimal getR30_3_years() {
		return r30_3_years;
	}
	public BigDecimal getR30_total() {
		return r30_total;
	}
	public String getR31_product() {
		return r31_product;
	}
	public BigDecimal getR31_overdue() {
		return r31_overdue;
	}
	public BigDecimal getR31_overdraft() {
		return r31_overdraft;
	}
	public BigDecimal getR31_0_7_days() {
		return r31_0_7_days;
	}
	public BigDecimal getR31_8_14_days() {
		return r31_8_14_days;
	}
	public BigDecimal getR31_15_days_1_month() {
		return r31_15_days_1_month;
	}
	public BigDecimal getR31_1_3_months() {
		return r31_1_3_months;
	}
	public BigDecimal getR31_3_6_months() {
		return r31_3_6_months;
	}
	public BigDecimal getR31_6_12_months() {
		return r31_6_12_months;
	}
	public BigDecimal getR31_1_3_years() {
		return r31_1_3_years;
	}
	public BigDecimal getR31_3_years() {
		return r31_3_years;
	}
	public BigDecimal getR31_total() {
		return r31_total;
	}
	public String getRta_product() {
		return rta_product;
	}
	public BigDecimal getRta_overdue() {
		return rta_overdue;
	}
	public BigDecimal getRta_overdraft() {
		return rta_overdraft;
	}
	public BigDecimal getRta_0_7_days() {
		return rta_0_7_days;
	}
	public BigDecimal getRta_8_14_days() {
		return rta_8_14_days;
	}
	public BigDecimal getRta_15_days_1_month() {
		return rta_15_days_1_month;
	}
	public BigDecimal getRta_1_3_months() {
		return rta_1_3_months;
	}
	public BigDecimal getRta_3_6_months() {
		return rta_3_6_months;
	}
	public BigDecimal getRta_6_12_months() {
		return rta_6_12_months;
	}
	public BigDecimal getRta_1_3_years() {
		return rta_1_3_years;
	}
	public BigDecimal getRta_3_years() {
		return rta_3_years;
	}
	public BigDecimal getRta_total() {
		return rta_total;
	}
	public String getRh6_product() {
		return rh6_product;
	}
	public BigDecimal getRh6_overdue() {
		return rh6_overdue;
	}
	public BigDecimal getRh6_overdraft() {
		return rh6_overdraft;
	}
	public BigDecimal getRh6_0_7_days() {
		return rh6_0_7_days;
	}
	public BigDecimal getRh6_8_14_days() {
		return rh6_8_14_days;
	}
	public BigDecimal getRh6_15_days_1_month() {
		return rh6_15_days_1_month;
	}
	public BigDecimal getRh6_1_3_months() {
		return rh6_1_3_months;
	}
	public BigDecimal getRh6_3_6_months() {
		return rh6_3_6_months;
	}
	public BigDecimal getRh6_6_12_months() {
		return rh6_6_12_months;
	}
	public BigDecimal getRh6_1_3_years() {
		return rh6_1_3_years;
	}
	public BigDecimal getRh6_3_years() {
		return rh6_3_years;
	}
	public BigDecimal getRh6_total() {
		return rh6_total;
	}
	public String getR32_product() {
		return r32_product;
	}
	public BigDecimal getR32_overdue() {
		return r32_overdue;
	}
	public BigDecimal getR32_overdraft() {
		return r32_overdraft;
	}
	public BigDecimal getR32_0_7_days() {
		return r32_0_7_days;
	}
	public BigDecimal getR32_8_14_days() {
		return r32_8_14_days;
	}
	public BigDecimal getR32_15_days_1_month() {
		return r32_15_days_1_month;
	}
	public BigDecimal getR32_1_3_months() {
		return r32_1_3_months;
	}
	public BigDecimal getR32_3_6_months() {
		return r32_3_6_months;
	}
	public BigDecimal getR32_6_12_months() {
		return r32_6_12_months;
	}
	public BigDecimal getR32_1_3_years() {
		return r32_1_3_years;
	}
	public BigDecimal getR32_3_years() {
		return r32_3_years;
	}
	public BigDecimal getR32_total() {
		return r32_total;
	}
	public String getR33_product() {
		return r33_product;
	}
	public BigDecimal getR33_overdue() {
		return r33_overdue;
	}
	public BigDecimal getR33_overdraft() {
		return r33_overdraft;
	}
	public BigDecimal getR33_0_7_days() {
		return r33_0_7_days;
	}
	public BigDecimal getR33_8_14_days() {
		return r33_8_14_days;
	}
	public BigDecimal getR33_15_days_1_month() {
		return r33_15_days_1_month;
	}
	public BigDecimal getR33_1_3_months() {
		return r33_1_3_months;
	}
	public BigDecimal getR33_3_6_months() {
		return r33_3_6_months;
	}
	public BigDecimal getR33_6_12_months() {
		return r33_6_12_months;
	}
	public BigDecimal getR33_1_3_years() {
		return r33_1_3_years;
	}
	public BigDecimal getR33_3_years() {
		return r33_3_years;
	}
	public BigDecimal getR33_total() {
		return r33_total;
	}
	public String getR34_product() {
		return r34_product;
	}
	public BigDecimal getR34_overdue() {
		return r34_overdue;
	}
	public BigDecimal getR34_overdraft() {
		return r34_overdraft;
	}
	public BigDecimal getR34_0_7_days() {
		return r34_0_7_days;
	}
	public BigDecimal getR34_8_14_days() {
		return r34_8_14_days;
	}
	public BigDecimal getR34_15_days_1_month() {
		return r34_15_days_1_month;
	}
	public BigDecimal getR34_1_3_months() {
		return r34_1_3_months;
	}
	public BigDecimal getR34_3_6_months() {
		return r34_3_6_months;
	}
	public BigDecimal getR34_6_12_months() {
		return r34_6_12_months;
	}
	public BigDecimal getR34_1_3_years() {
		return r34_1_3_years;
	}
	public BigDecimal getR34_3_years() {
		return r34_3_years;
	}
	public BigDecimal getR34_total() {
		return r34_total;
	}
	public String getR35_product() {
		return r35_product;
	}
	public BigDecimal getR35_overdue() {
		return r35_overdue;
	}
	public BigDecimal getR35_overdraft() {
		return r35_overdraft;
	}
	public BigDecimal getR35_0_7_days() {
		return r35_0_7_days;
	}
	public BigDecimal getR35_8_14_days() {
		return r35_8_14_days;
	}
	public BigDecimal getR35_15_days_1_month() {
		return r35_15_days_1_month;
	}
	public BigDecimal getR35_1_3_months() {
		return r35_1_3_months;
	}
	public BigDecimal getR35_3_6_months() {
		return r35_3_6_months;
	}
	public BigDecimal getR35_6_12_months() {
		return r35_6_12_months;
	}
	public BigDecimal getR35_1_3_years() {
		return r35_1_3_years;
	}
	public BigDecimal getR35_3_years() {
		return r35_3_years;
	}
	public BigDecimal getR35_total() {
		return r35_total;
	}
	public String getR36_product() {
		return r36_product;
	}
	public BigDecimal getR36_overdue() {
		return r36_overdue;
	}
	public BigDecimal getR36_overdraft() {
		return r36_overdraft;
	}
	public BigDecimal getR36_0_7_days() {
		return r36_0_7_days;
	}
	public BigDecimal getR36_8_14_days() {
		return r36_8_14_days;
	}
	public BigDecimal getR36_15_days_1_month() {
		return r36_15_days_1_month;
	}
	public BigDecimal getR36_1_3_months() {
		return r36_1_3_months;
	}
	public BigDecimal getR36_3_6_months() {
		return r36_3_6_months;
	}
	public BigDecimal getR36_6_12_months() {
		return r36_6_12_months;
	}
	public BigDecimal getR36_1_3_years() {
		return r36_1_3_years;
	}
	public BigDecimal getR36_3_years() {
		return r36_3_years;
	}
	public BigDecimal getR36_total() {
		return r36_total;
	}
	public String getRh7_product() {
		return rh7_product;
	}
	public BigDecimal getRh7_overdue() {
		return rh7_overdue;
	}
	public BigDecimal getRh7_overdraft() {
		return rh7_overdraft;
	}
	public BigDecimal getRh7_0_7_days() {
		return rh7_0_7_days;
	}
	public BigDecimal getRh7_8_14_days() {
		return rh7_8_14_days;
	}
	public BigDecimal getRh7_15_days_1_month() {
		return rh7_15_days_1_month;
	}
	public BigDecimal getRh7_1_3_months() {
		return rh7_1_3_months;
	}
	public BigDecimal getRh7_3_6_months() {
		return rh7_3_6_months;
	}
	public BigDecimal getRh7_6_12_months() {
		return rh7_6_12_months;
	}
	public BigDecimal getRh7_1_3_years() {
		return rh7_1_3_years;
	}
	public BigDecimal getRh7_3_years() {
		return rh7_3_years;
	}
	public BigDecimal getRh7_total() {
		return rh7_total;
	}
	public String getR37_product() {
		return r37_product;
	}
	public BigDecimal getR37_overdue() {
		return r37_overdue;
	}
	public BigDecimal getR37_overdraft() {
		return r37_overdraft;
	}
	public BigDecimal getR37_0_7_days() {
		return r37_0_7_days;
	}
	public BigDecimal getR37_8_14_days() {
		return r37_8_14_days;
	}
	public BigDecimal getR37_15_days_1_month() {
		return r37_15_days_1_month;
	}
	public BigDecimal getR37_1_3_months() {
		return r37_1_3_months;
	}
	public BigDecimal getR37_3_6_months() {
		return r37_3_6_months;
	}
	public BigDecimal getR37_6_12_months() {
		return r37_6_12_months;
	}
	public BigDecimal getR37_1_3_years() {
		return r37_1_3_years;
	}
	public BigDecimal getR37_3_years() {
		return r37_3_years;
	}
	public BigDecimal getR37_total() {
		return r37_total;
	}
	public String getR38_product() {
		return r38_product;
	}
	public BigDecimal getR38_overdue() {
		return r38_overdue;
	}
	public BigDecimal getR38_overdraft() {
		return r38_overdraft;
	}
	public BigDecimal getR38_0_7_days() {
		return r38_0_7_days;
	}
	public BigDecimal getR38_8_14_days() {
		return r38_8_14_days;
	}
	public BigDecimal getR38_15_days_1_month() {
		return r38_15_days_1_month;
	}
	public BigDecimal getR38_1_3_months() {
		return r38_1_3_months;
	}
	public BigDecimal getR38_3_6_months() {
		return r38_3_6_months;
	}
	public BigDecimal getR38_6_12_months() {
		return r38_6_12_months;
	}
	public BigDecimal getR38_1_3_years() {
		return r38_1_3_years;
	}
	public BigDecimal getR38_3_years() {
		return r38_3_years;
	}
	public BigDecimal getR38_total() {
		return r38_total;
	}
	public String getR39_product() {
		return r39_product;
	}
	public BigDecimal getR39_overdue() {
		return r39_overdue;
	}
	public BigDecimal getR39_overdraft() {
		return r39_overdraft;
	}
	public BigDecimal getR39_0_7_days() {
		return r39_0_7_days;
	}
	public BigDecimal getR39_8_14_days() {
		return r39_8_14_days;
	}
	public BigDecimal getR39_15_days_1_month() {
		return r39_15_days_1_month;
	}
	public BigDecimal getR39_1_3_months() {
		return r39_1_3_months;
	}
	public BigDecimal getR39_3_6_months() {
		return r39_3_6_months;
	}
	public BigDecimal getR39_6_12_months() {
		return r39_6_12_months;
	}
	public BigDecimal getR39_1_3_years() {
		return r39_1_3_years;
	}
	public BigDecimal getR39_3_years() {
		return r39_3_years;
	}
	public BigDecimal getR39_total() {
		return r39_total;
	}
	public String getR40_product() {
		return r40_product;
	}
	public BigDecimal getR40_overdue() {
		return r40_overdue;
	}
	public BigDecimal getR40_overdraft() {
		return r40_overdraft;
	}
	public BigDecimal getR40_0_7_days() {
		return r40_0_7_days;
	}
	public BigDecimal getR40_8_14_days() {
		return r40_8_14_days;
	}
	public BigDecimal getR40_15_days_1_month() {
		return r40_15_days_1_month;
	}
	public BigDecimal getR40_1_3_months() {
		return r40_1_3_months;
	}
	public BigDecimal getR40_3_6_months() {
		return r40_3_6_months;
	}
	public BigDecimal getR40_6_12_months() {
		return r40_6_12_months;
	}
	public BigDecimal getR40_1_3_years() {
		return r40_1_3_years;
	}
	public BigDecimal getR40_3_years() {
		return r40_3_years;
	}
	public BigDecimal getR40_total() {
		return r40_total;
	}
	public String getR41_product() {
		return r41_product;
	}
	public BigDecimal getR41_overdue() {
		return r41_overdue;
	}
	public BigDecimal getR41_overdraft() {
		return r41_overdraft;
	}
	public BigDecimal getR41_0_7_days() {
		return r41_0_7_days;
	}
	public BigDecimal getR41_8_14_days() {
		return r41_8_14_days;
	}
	public BigDecimal getR41_15_days_1_month() {
		return r41_15_days_1_month;
	}
	public BigDecimal getR41_1_3_months() {
		return r41_1_3_months;
	}
	public BigDecimal getR41_3_6_months() {
		return r41_3_6_months;
	}
	public BigDecimal getR41_6_12_months() {
		return r41_6_12_months;
	}
	public BigDecimal getR41_1_3_years() {
		return r41_1_3_years;
	}
	public BigDecimal getR41_3_years() {
		return r41_3_years;
	}
	public BigDecimal getR41_total() {
		return r41_total;
	}
	public String getR42_product() {
		return r42_product;
	}
	public BigDecimal getR42_overdue() {
		return r42_overdue;
	}
	public BigDecimal getR42_overdraft() {
		return r42_overdraft;
	}
	public BigDecimal getR42_0_7_days() {
		return r42_0_7_days;
	}
	public BigDecimal getR42_8_14_days() {
		return r42_8_14_days;
	}
	public BigDecimal getR42_15_days_1_month() {
		return r42_15_days_1_month;
	}
	public BigDecimal getR42_1_3_months() {
		return r42_1_3_months;
	}
	public BigDecimal getR42_3_6_months() {
		return r42_3_6_months;
	}
	public BigDecimal getR42_6_12_months() {
		return r42_6_12_months;
	}
	public BigDecimal getR42_1_3_years() {
		return r42_1_3_years;
	}
	public BigDecimal getR42_3_years() {
		return r42_3_years;
	}
	public BigDecimal getR42_total() {
		return r42_total;
	}
	public String getRh8_product() {
		return rh8_product;
	}
	public BigDecimal getRh8_overdue() {
		return rh8_overdue;
	}
	public BigDecimal getRh8_overdraft() {
		return rh8_overdraft;
	}
	public BigDecimal getRh8_0_7_days() {
		return rh8_0_7_days;
	}
	public BigDecimal getRh8_8_14_days() {
		return rh8_8_14_days;
	}
	public BigDecimal getRh8_15_days_1_month() {
		return rh8_15_days_1_month;
	}
	public BigDecimal getRh8_1_3_months() {
		return rh8_1_3_months;
	}
	public BigDecimal getRh8_3_6_months() {
		return rh8_3_6_months;
	}
	public BigDecimal getRh8_6_12_months() {
		return rh8_6_12_months;
	}
	public BigDecimal getRh8_1_3_years() {
		return rh8_1_3_years;
	}
	public BigDecimal getRh8_3_years() {
		return rh8_3_years;
	}
	public BigDecimal getRh8_total() {
		return rh8_total;
	}
	public String getR43_product() {
		return r43_product;
	}
	public BigDecimal getR43_overdue() {
		return r43_overdue;
	}
	public BigDecimal getR43_overdraft() {
		return r43_overdraft;
	}
	public BigDecimal getR43_0_7_days() {
		return r43_0_7_days;
	}
	public BigDecimal getR43_8_14_days() {
		return r43_8_14_days;
	}
	public BigDecimal getR43_15_days_1_month() {
		return r43_15_days_1_month;
	}
	public BigDecimal getR43_1_3_months() {
		return r43_1_3_months;
	}
	public BigDecimal getR43_3_6_months() {
		return r43_3_6_months;
	}
	public BigDecimal getR43_6_12_months() {
		return r43_6_12_months;
	}
	public BigDecimal getR43_1_3_years() {
		return r43_1_3_years;
	}
	public BigDecimal getR43_3_years() {
		return r43_3_years;
	}
	public BigDecimal getR43_total() {
		return r43_total;
	}
	public String getR44_product() {
		return r44_product;
	}
	public BigDecimal getR44_overdue() {
		return r44_overdue;
	}
	public BigDecimal getR44_overdraft() {
		return r44_overdraft;
	}
	public BigDecimal getR44_0_7_days() {
		return r44_0_7_days;
	}
	public BigDecimal getR44_8_14_days() {
		return r44_8_14_days;
	}
	public BigDecimal getR44_15_days_1_month() {
		return r44_15_days_1_month;
	}
	public BigDecimal getR44_1_3_months() {
		return r44_1_3_months;
	}
	public BigDecimal getR44_3_6_months() {
		return r44_3_6_months;
	}
	public BigDecimal getR44_6_12_months() {
		return r44_6_12_months;
	}
	public BigDecimal getR44_1_3_years() {
		return r44_1_3_years;
	}
	public BigDecimal getR44_3_years() {
		return r44_3_years;
	}
	public BigDecimal getR44_total() {
		return r44_total;
	}
	public String getR45_product() {
		return r45_product;
	}
	public BigDecimal getR45_overdue() {
		return r45_overdue;
	}
	public BigDecimal getR45_overdraft() {
		return r45_overdraft;
	}
	public BigDecimal getR45_0_7_days() {
		return r45_0_7_days;
	}
	public BigDecimal getR45_8_14_days() {
		return r45_8_14_days;
	}
	public BigDecimal getR45_15_days_1_month() {
		return r45_15_days_1_month;
	}
	public BigDecimal getR45_1_3_months() {
		return r45_1_3_months;
	}
	public BigDecimal getR45_3_6_months() {
		return r45_3_6_months;
	}
	public BigDecimal getR45_6_12_months() {
		return r45_6_12_months;
	}
	public BigDecimal getR45_1_3_years() {
		return r45_1_3_years;
	}
	public BigDecimal getR45_3_years() {
		return r45_3_years;
	}
	public BigDecimal getR45_total() {
		return r45_total;
	}
	public String getR46_product() {
		return r46_product;
	}
	public BigDecimal getR46_overdue() {
		return r46_overdue;
	}
	public BigDecimal getR46_overdraft() {
		return r46_overdraft;
	}
	public BigDecimal getR46_0_7_days() {
		return r46_0_7_days;
	}
	public BigDecimal getR46_8_14_days() {
		return r46_8_14_days;
	}
	public BigDecimal getR46_15_days_1_month() {
		return r46_15_days_1_month;
	}
	public BigDecimal getR46_1_3_months() {
		return r46_1_3_months;
	}
	public BigDecimal getR46_3_6_months() {
		return r46_3_6_months;
	}
	public BigDecimal getR46_6_12_months() {
		return r46_6_12_months;
	}
	public BigDecimal getR46_1_3_years() {
		return r46_1_3_years;
	}
	public BigDecimal getR46_3_years() {
		return r46_3_years;
	}
	public BigDecimal getR46_total() {
		return r46_total;
	}
	public String getRtl_product() {
		return rtl_product;
	}
	public BigDecimal getRtl_overdue() {
		return rtl_overdue;
	}
	public BigDecimal getRtl_overdraft() {
		return rtl_overdraft;
	}
	public BigDecimal getRtl_0_7_days() {
		return rtl_0_7_days;
	}
	public BigDecimal getRtl_8_14_days() {
		return rtl_8_14_days;
	}
	public BigDecimal getRtl_15_days_1_month() {
		return rtl_15_days_1_month;
	}
	public BigDecimal getRtl_1_3_months() {
		return rtl_1_3_months;
	}
	public BigDecimal getRtl_3_6_months() {
		return rtl_3_6_months;
	}
	public BigDecimal getRtl_6_12_months() {
		return rtl_6_12_months;
	}
	public BigDecimal getRtl_1_3_years() {
		return rtl_1_3_years;
	}
	public BigDecimal getRtl_3_years() {
		return rtl_3_years;
	}
	public BigDecimal getRtl_total() {
		return rtl_total;
	}
	public Date getReport_date() {
		return report_date;
	}
	public Date getReport_from_date() {
		return report_from_date;
	}
	public Date getReport_to_date() {
		return report_to_date;
	}
	public String getEntity_flg() {
		return entity_flg;
	}
	public String getModify_flg() {
		return modify_flg;
	}
	public String getDel_flg() {
		return del_flg;
	}
	public String getReport_code() {
		return report_code;
	}
	public Date getReport_submit_date() {
		return report_submit_date;
	}
	public String getRepdesc() {
		return repdesc;
	}
	public String getFrequency() {
		return frequency;
	}
	public void setRh_product(String rh_product) {
		this.rh_product = rh_product;
	}
	public void setRh_overdue(BigDecimal rh_overdue) {
		this.rh_overdue = rh_overdue;
	}
	public void setRh_overdraft(BigDecimal rh_overdraft) {
		this.rh_overdraft = rh_overdraft;
	}
	public void setRh_0_7_days(BigDecimal rh_0_7_days) {
		this.rh_0_7_days = rh_0_7_days;
	}
	public void setRh_8_14_days(BigDecimal rh_8_14_days) {
		this.rh_8_14_days = rh_8_14_days;
	}
	public void setRh_15_days_1_month(BigDecimal rh_15_days_1_month) {
		this.rh_15_days_1_month = rh_15_days_1_month;
	}
	public void setRh_1_3_months(BigDecimal rh_1_3_months) {
		this.rh_1_3_months = rh_1_3_months;
	}
	public void setRh_3_6_months(BigDecimal rh_3_6_months) {
		this.rh_3_6_months = rh_3_6_months;
	}
	public void setRh_6_12_months(BigDecimal rh_6_12_months) {
		this.rh_6_12_months = rh_6_12_months;
	}
	public void setRh_1_3_years(BigDecimal rh_1_3_years) {
		this.rh_1_3_years = rh_1_3_years;
	}
	public void setRh_3_years(BigDecimal rh_3_years) {
		this.rh_3_years = rh_3_years;
	}
	public void setRh_total(BigDecimal rh_total) {
		this.rh_total = rh_total;
	}
	public void setR1_product(String r1_product) {
		this.r1_product = r1_product;
	}
	public void setR1_overdue(BigDecimal r1_overdue) {
		this.r1_overdue = r1_overdue;
	}
	public void setR1_overdraft(BigDecimal r1_overdraft) {
		this.r1_overdraft = r1_overdraft;
	}
	public void setR1_0_7_days(BigDecimal r1_0_7_days) {
		this.r1_0_7_days = r1_0_7_days;
	}
	public void setR1_8_14_days(BigDecimal r1_8_14_days) {
		this.r1_8_14_days = r1_8_14_days;
	}
	public void setR1_15_days_1_month(BigDecimal r1_15_days_1_month) {
		this.r1_15_days_1_month = r1_15_days_1_month;
	}
	public void setR1_1_3_months(BigDecimal r1_1_3_months) {
		this.r1_1_3_months = r1_1_3_months;
	}
	public void setR1_3_6_months(BigDecimal r1_3_6_months) {
		this.r1_3_6_months = r1_3_6_months;
	}
	public void setR1_6_12_months(BigDecimal r1_6_12_months) {
		this.r1_6_12_months = r1_6_12_months;
	}
	public void setR1_1_3_years(BigDecimal r1_1_3_years) {
		this.r1_1_3_years = r1_1_3_years;
	}
	public void setR1_3_years(BigDecimal r1_3_years) {
		this.r1_3_years = r1_3_years;
	}
	public void setR1_total(BigDecimal r1_total) {
		this.r1_total = r1_total;
	}
	public void setR2_product(String r2_product) {
		this.r2_product = r2_product;
	}
	public void setR2_overdue(BigDecimal r2_overdue) {
		this.r2_overdue = r2_overdue;
	}
	public void setR2_overdraft(BigDecimal r2_overdraft) {
		this.r2_overdraft = r2_overdraft;
	}
	public void setR2_0_7_days(BigDecimal r2_0_7_days) {
		this.r2_0_7_days = r2_0_7_days;
	}
	public void setR2_8_14_days(BigDecimal r2_8_14_days) {
		this.r2_8_14_days = r2_8_14_days;
	}
	public void setR2_15_days_1_month(BigDecimal r2_15_days_1_month) {
		this.r2_15_days_1_month = r2_15_days_1_month;
	}
	public void setR2_1_3_months(BigDecimal r2_1_3_months) {
		this.r2_1_3_months = r2_1_3_months;
	}
	public void setR2_3_6_months(BigDecimal r2_3_6_months) {
		this.r2_3_6_months = r2_3_6_months;
	}
	public void setR2_6_12_months(BigDecimal r2_6_12_months) {
		this.r2_6_12_months = r2_6_12_months;
	}
	public void setR2_1_3_years(BigDecimal r2_1_3_years) {
		this.r2_1_3_years = r2_1_3_years;
	}
	public void setR2_3_years(BigDecimal r2_3_years) {
		this.r2_3_years = r2_3_years;
	}
	public void setR2_total(BigDecimal r2_total) {
		this.r2_total = r2_total;
	}
	public void setR3_product(String r3_product) {
		this.r3_product = r3_product;
	}
	public void setR3_overdue(BigDecimal r3_overdue) {
		this.r3_overdue = r3_overdue;
	}
	public void setR3_overdraft(BigDecimal r3_overdraft) {
		this.r3_overdraft = r3_overdraft;
	}
	public void setR3_0_7_days(BigDecimal r3_0_7_days) {
		this.r3_0_7_days = r3_0_7_days;
	}
	public void setR3_8_14_days(BigDecimal r3_8_14_days) {
		this.r3_8_14_days = r3_8_14_days;
	}
	public void setR3_15_days_1_month(BigDecimal r3_15_days_1_month) {
		this.r3_15_days_1_month = r3_15_days_1_month;
	}
	public void setR3_1_3_months(BigDecimal r3_1_3_months) {
		this.r3_1_3_months = r3_1_3_months;
	}
	public void setR3_3_6_months(BigDecimal r3_3_6_months) {
		this.r3_3_6_months = r3_3_6_months;
	}
	public void setR3_6_12_months(BigDecimal r3_6_12_months) {
		this.r3_6_12_months = r3_6_12_months;
	}
	public void setR3_1_3_years(BigDecimal r3_1_3_years) {
		this.r3_1_3_years = r3_1_3_years;
	}
	public void setR3_3_years(BigDecimal r3_3_years) {
		this.r3_3_years = r3_3_years;
	}
	public void setR3_total(BigDecimal r3_total) {
		this.r3_total = r3_total;
	}
	public void setRh2_product(String rh2_product) {
		this.rh2_product = rh2_product;
	}
	public void setRh2_overdue(BigDecimal rh2_overdue) {
		this.rh2_overdue = rh2_overdue;
	}
	public void setRh2_overdraft(BigDecimal rh2_overdraft) {
		this.rh2_overdraft = rh2_overdraft;
	}
	public void setRh2_0_7_days(BigDecimal rh2_0_7_days) {
		this.rh2_0_7_days = rh2_0_7_days;
	}
	public void setRh2_8_14_days(BigDecimal rh2_8_14_days) {
		this.rh2_8_14_days = rh2_8_14_days;
	}
	public void setRh2_15_days_1_month(BigDecimal rh2_15_days_1_month) {
		this.rh2_15_days_1_month = rh2_15_days_1_month;
	}
	public void setRh2_1_3_months(BigDecimal rh2_1_3_months) {
		this.rh2_1_3_months = rh2_1_3_months;
	}
	public void setRh2_3_6_months(BigDecimal rh2_3_6_months) {
		this.rh2_3_6_months = rh2_3_6_months;
	}
	public void setRh2_6_12_months(BigDecimal rh2_6_12_months) {
		this.rh2_6_12_months = rh2_6_12_months;
	}
	public void setRh2_1_3_years(BigDecimal rh2_1_3_years) {
		this.rh2_1_3_years = rh2_1_3_years;
	}
	public void setRh2_3_years(BigDecimal rh2_3_years) {
		this.rh2_3_years = rh2_3_years;
	}
	public void setRh2_total(BigDecimal rh2_total) {
		this.rh2_total = rh2_total;
	}
	public void setR4_product(String r4_product) {
		this.r4_product = r4_product;
	}
	public void setR4_overdue(BigDecimal r4_overdue) {
		this.r4_overdue = r4_overdue;
	}
	public void setR4_overdraft(BigDecimal r4_overdraft) {
		this.r4_overdraft = r4_overdraft;
	}
	public void setR4_0_7_days(BigDecimal r4_0_7_days) {
		this.r4_0_7_days = r4_0_7_days;
	}
	public void setR4_8_14_days(BigDecimal r4_8_14_days) {
		this.r4_8_14_days = r4_8_14_days;
	}
	public void setR4_15_days_1_month(BigDecimal r4_15_days_1_month) {
		this.r4_15_days_1_month = r4_15_days_1_month;
	}
	public void setR4_1_3_months(BigDecimal r4_1_3_months) {
		this.r4_1_3_months = r4_1_3_months;
	}
	public void setR4_3_6_months(BigDecimal r4_3_6_months) {
		this.r4_3_6_months = r4_3_6_months;
	}
	public void setR4_6_12_months(BigDecimal r4_6_12_months) {
		this.r4_6_12_months = r4_6_12_months;
	}
	public void setR4_1_3_years(BigDecimal r4_1_3_years) {
		this.r4_1_3_years = r4_1_3_years;
	}
	public void setR4_3_years(BigDecimal r4_3_years) {
		this.r4_3_years = r4_3_years;
	}
	public void setR4_total(BigDecimal r4_total) {
		this.r4_total = r4_total;
	}
	public void setR5_product(String r5_product) {
		this.r5_product = r5_product;
	}
	public void setR5_overdue(BigDecimal r5_overdue) {
		this.r5_overdue = r5_overdue;
	}
	public void setR5_overdraft(BigDecimal r5_overdraft) {
		this.r5_overdraft = r5_overdraft;
	}
	public void setR5_0_7_days(BigDecimal r5_0_7_days) {
		this.r5_0_7_days = r5_0_7_days;
	}
	public void setR5_8_14_days(BigDecimal r5_8_14_days) {
		this.r5_8_14_days = r5_8_14_days;
	}
	public void setR5_15_days_1_month(BigDecimal r5_15_days_1_month) {
		this.r5_15_days_1_month = r5_15_days_1_month;
	}
	public void setR5_1_3_months(BigDecimal r5_1_3_months) {
		this.r5_1_3_months = r5_1_3_months;
	}
	public void setR5_3_6_months(BigDecimal r5_3_6_months) {
		this.r5_3_6_months = r5_3_6_months;
	}
	public void setR5_6_12_months(BigDecimal r5_6_12_months) {
		this.r5_6_12_months = r5_6_12_months;
	}
	public void setR5_1_3_years(BigDecimal r5_1_3_years) {
		this.r5_1_3_years = r5_1_3_years;
	}
	public void setR5_3_years(BigDecimal r5_3_years) {
		this.r5_3_years = r5_3_years;
	}
	public void setR5_total(BigDecimal r5_total) {
		this.r5_total = r5_total;
	}
	public void setR6_product(String r6_product) {
		this.r6_product = r6_product;
	}
	public void setR6_overdue(BigDecimal r6_overdue) {
		this.r6_overdue = r6_overdue;
	}
	public void setR6_overdraft(BigDecimal r6_overdraft) {
		this.r6_overdraft = r6_overdraft;
	}
	public void setR6_0_7_days(BigDecimal r6_0_7_days) {
		this.r6_0_7_days = r6_0_7_days;
	}
	public void setR6_8_14_days(BigDecimal r6_8_14_days) {
		this.r6_8_14_days = r6_8_14_days;
	}
	public void setR6_15_days_1_month(BigDecimal r6_15_days_1_month) {
		this.r6_15_days_1_month = r6_15_days_1_month;
	}
	public void setR6_1_3_months(BigDecimal r6_1_3_months) {
		this.r6_1_3_months = r6_1_3_months;
	}
	public void setR6_3_6_months(BigDecimal r6_3_6_months) {
		this.r6_3_6_months = r6_3_6_months;
	}
	public void setR6_6_12_months(BigDecimal r6_6_12_months) {
		this.r6_6_12_months = r6_6_12_months;
	}
	public void setR6_1_3_years(BigDecimal r6_1_3_years) {
		this.r6_1_3_years = r6_1_3_years;
	}
	public void setR6_3_years(BigDecimal r6_3_years) {
		this.r6_3_years = r6_3_years;
	}
	public void setR6_total(BigDecimal r6_total) {
		this.r6_total = r6_total;
	}
	public void setRh3_product(String rh3_product) {
		this.rh3_product = rh3_product;
	}
	public void setRh3_overdue(BigDecimal rh3_overdue) {
		this.rh3_overdue = rh3_overdue;
	}
	public void setRh3_overdraft(BigDecimal rh3_overdraft) {
		this.rh3_overdraft = rh3_overdraft;
	}
	public void setRh3_0_7_days(BigDecimal rh3_0_7_days) {
		this.rh3_0_7_days = rh3_0_7_days;
	}
	public void setRh3_8_14_days(BigDecimal rh3_8_14_days) {
		this.rh3_8_14_days = rh3_8_14_days;
	}
	public void setRh3_15_days_1_month(BigDecimal rh3_15_days_1_month) {
		this.rh3_15_days_1_month = rh3_15_days_1_month;
	}
	public void setRh3_1_3_months(BigDecimal rh3_1_3_months) {
		this.rh3_1_3_months = rh3_1_3_months;
	}
	public void setRh3_3_6_months(BigDecimal rh3_3_6_months) {
		this.rh3_3_6_months = rh3_3_6_months;
	}
	public void setRh3_6_12_months(BigDecimal rh3_6_12_months) {
		this.rh3_6_12_months = rh3_6_12_months;
	}
	public void setRh3_1_3_years(BigDecimal rh3_1_3_years) {
		this.rh3_1_3_years = rh3_1_3_years;
	}
	public void setRh3_3_years(BigDecimal rh3_3_years) {
		this.rh3_3_years = rh3_3_years;
	}
	public void setRh3_total(BigDecimal rh3_total) {
		this.rh3_total = rh3_total;
	}
	public void setR7_product(String r7_product) {
		this.r7_product = r7_product;
	}
	public void setR7_overdue(BigDecimal r7_overdue) {
		this.r7_overdue = r7_overdue;
	}
	public void setR7_overdraft(BigDecimal r7_overdraft) {
		this.r7_overdraft = r7_overdraft;
	}
	public void setR7_0_7_days(BigDecimal r7_0_7_days) {
		this.r7_0_7_days = r7_0_7_days;
	}
	public void setR7_8_14_days(BigDecimal r7_8_14_days) {
		this.r7_8_14_days = r7_8_14_days;
	}
	public void setR7_15_days_1_month(BigDecimal r7_15_days_1_month) {
		this.r7_15_days_1_month = r7_15_days_1_month;
	}
	public void setR7_1_3_months(BigDecimal r7_1_3_months) {
		this.r7_1_3_months = r7_1_3_months;
	}
	public void setR7_3_6_months(BigDecimal r7_3_6_months) {
		this.r7_3_6_months = r7_3_6_months;
	}
	public void setR7_6_12_months(BigDecimal r7_6_12_months) {
		this.r7_6_12_months = r7_6_12_months;
	}
	public void setR7_1_3_years(BigDecimal r7_1_3_years) {
		this.r7_1_3_years = r7_1_3_years;
	}
	public void setR7_3_years(BigDecimal r7_3_years) {
		this.r7_3_years = r7_3_years;
	}
	public void setR7_total(BigDecimal r7_total) {
		this.r7_total = r7_total;
	}
	public void setR8_product(String r8_product) {
		this.r8_product = r8_product;
	}
	public void setR8_overdue(BigDecimal r8_overdue) {
		this.r8_overdue = r8_overdue;
	}
	public void setR8_overdraft(BigDecimal r8_overdraft) {
		this.r8_overdraft = r8_overdraft;
	}
	public void setR8_0_7_days(BigDecimal r8_0_7_days) {
		this.r8_0_7_days = r8_0_7_days;
	}
	public void setR8_8_14_days(BigDecimal r8_8_14_days) {
		this.r8_8_14_days = r8_8_14_days;
	}
	public void setR8_15_days_1_month(BigDecimal r8_15_days_1_month) {
		this.r8_15_days_1_month = r8_15_days_1_month;
	}
	public void setR8_1_3_months(BigDecimal r8_1_3_months) {
		this.r8_1_3_months = r8_1_3_months;
	}
	public void setR8_3_6_months(BigDecimal r8_3_6_months) {
		this.r8_3_6_months = r8_3_6_months;
	}
	public void setR8_6_12_months(BigDecimal r8_6_12_months) {
		this.r8_6_12_months = r8_6_12_months;
	}
	public void setR8_1_3_years(BigDecimal r8_1_3_years) {
		this.r8_1_3_years = r8_1_3_years;
	}
	public void setR8_3_years(BigDecimal r8_3_years) {
		this.r8_3_years = r8_3_years;
	}
	public void setR8_total(BigDecimal r8_total) {
		this.r8_total = r8_total;
	}
	public void setR9_product(String r9_product) {
		this.r9_product = r9_product;
	}
	public void setR9_overdue(BigDecimal r9_overdue) {
		this.r9_overdue = r9_overdue;
	}
	public void setR9_overdraft(BigDecimal r9_overdraft) {
		this.r9_overdraft = r9_overdraft;
	}
	public void setR9_0_7_days(BigDecimal r9_0_7_days) {
		this.r9_0_7_days = r9_0_7_days;
	}
	public void setR9_8_14_days(BigDecimal r9_8_14_days) {
		this.r9_8_14_days = r9_8_14_days;
	}
	public void setR9_15_days_1_month(BigDecimal r9_15_days_1_month) {
		this.r9_15_days_1_month = r9_15_days_1_month;
	}
	public void setR9_1_3_months(BigDecimal r9_1_3_months) {
		this.r9_1_3_months = r9_1_3_months;
	}
	public void setR9_3_6_months(BigDecimal r9_3_6_months) {
		this.r9_3_6_months = r9_3_6_months;
	}
	public void setR9_6_12_months(BigDecimal r9_6_12_months) {
		this.r9_6_12_months = r9_6_12_months;
	}
	public void setR9_1_3_years(BigDecimal r9_1_3_years) {
		this.r9_1_3_years = r9_1_3_years;
	}
	public void setR9_3_years(BigDecimal r9_3_years) {
		this.r9_3_years = r9_3_years;
	}
	public void setR9_total(BigDecimal r9_total) {
		this.r9_total = r9_total;
	}
	public void setR10_product(String r10_product) {
		this.r10_product = r10_product;
	}
	public void setR10_overdue(BigDecimal r10_overdue) {
		this.r10_overdue = r10_overdue;
	}
	public void setR10_overdraft(BigDecimal r10_overdraft) {
		this.r10_overdraft = r10_overdraft;
	}
	public void setR10_0_7_days(BigDecimal r10_0_7_days) {
		this.r10_0_7_days = r10_0_7_days;
	}
	public void setR10_8_14_days(BigDecimal r10_8_14_days) {
		this.r10_8_14_days = r10_8_14_days;
	}
	public void setR10_15_days_1_month(BigDecimal r10_15_days_1_month) {
		this.r10_15_days_1_month = r10_15_days_1_month;
	}
	public void setR10_1_3_months(BigDecimal r10_1_3_months) {
		this.r10_1_3_months = r10_1_3_months;
	}
	public void setR10_3_6_months(BigDecimal r10_3_6_months) {
		this.r10_3_6_months = r10_3_6_months;
	}
	public void setR10_6_12_months(BigDecimal r10_6_12_months) {
		this.r10_6_12_months = r10_6_12_months;
	}
	public void setR10_1_3_years(BigDecimal r10_1_3_years) {
		this.r10_1_3_years = r10_1_3_years;
	}
	public void setR10_3_years(BigDecimal r10_3_years) {
		this.r10_3_years = r10_3_years;
	}
	public void setR10_total(BigDecimal r10_total) {
		this.r10_total = r10_total;
	}
	public void setR11_product(String r11_product) {
		this.r11_product = r11_product;
	}
	public void setR11_overdue(BigDecimal r11_overdue) {
		this.r11_overdue = r11_overdue;
	}
	public void setR11_overdraft(BigDecimal r11_overdraft) {
		this.r11_overdraft = r11_overdraft;
	}
	public void setR11_0_7_days(BigDecimal r11_0_7_days) {
		this.r11_0_7_days = r11_0_7_days;
	}
	public void setR11_8_14_days(BigDecimal r11_8_14_days) {
		this.r11_8_14_days = r11_8_14_days;
	}
	public void setR11_15_days_1_month(BigDecimal r11_15_days_1_month) {
		this.r11_15_days_1_month = r11_15_days_1_month;
	}
	public void setR11_1_3_months(BigDecimal r11_1_3_months) {
		this.r11_1_3_months = r11_1_3_months;
	}
	public void setR11_3_6_months(BigDecimal r11_3_6_months) {
		this.r11_3_6_months = r11_3_6_months;
	}
	public void setR11_6_12_months(BigDecimal r11_6_12_months) {
		this.r11_6_12_months = r11_6_12_months;
	}
	public void setR11_1_3_years(BigDecimal r11_1_3_years) {
		this.r11_1_3_years = r11_1_3_years;
	}
	public void setR11_3_years(BigDecimal r11_3_years) {
		this.r11_3_years = r11_3_years;
	}
	public void setR11_total(BigDecimal r11_total) {
		this.r11_total = r11_total;
	}
	public void setR12_product(String r12_product) {
		this.r12_product = r12_product;
	}
	public void setR12_overdue(BigDecimal r12_overdue) {
		this.r12_overdue = r12_overdue;
	}
	public void setR12_overdraft(BigDecimal r12_overdraft) {
		this.r12_overdraft = r12_overdraft;
	}
	public void setR12_0_7_days(BigDecimal r12_0_7_days) {
		this.r12_0_7_days = r12_0_7_days;
	}
	public void setR12_8_14_days(BigDecimal r12_8_14_days) {
		this.r12_8_14_days = r12_8_14_days;
	}
	public void setR12_15_days_1_month(BigDecimal r12_15_days_1_month) {
		this.r12_15_days_1_month = r12_15_days_1_month;
	}
	public void setR12_1_3_months(BigDecimal r12_1_3_months) {
		this.r12_1_3_months = r12_1_3_months;
	}
	public void setR12_3_6_months(BigDecimal r12_3_6_months) {
		this.r12_3_6_months = r12_3_6_months;
	}
	public void setR12_6_12_months(BigDecimal r12_6_12_months) {
		this.r12_6_12_months = r12_6_12_months;
	}
	public void setR12_1_3_years(BigDecimal r12_1_3_years) {
		this.r12_1_3_years = r12_1_3_years;
	}
	public void setR12_3_years(BigDecimal r12_3_years) {
		this.r12_3_years = r12_3_years;
	}
	public void setR12_total(BigDecimal r12_total) {
		this.r12_total = r12_total;
	}
	public void setR13_product(String r13_product) {
		this.r13_product = r13_product;
	}
	public void setR13_overdue(BigDecimal r13_overdue) {
		this.r13_overdue = r13_overdue;
	}
	public void setR13_overdraft(BigDecimal r13_overdraft) {
		this.r13_overdraft = r13_overdraft;
	}
	public void setR13_0_7_days(BigDecimal r13_0_7_days) {
		this.r13_0_7_days = r13_0_7_days;
	}
	public void setR13_8_14_days(BigDecimal r13_8_14_days) {
		this.r13_8_14_days = r13_8_14_days;
	}
	public void setR13_15_days_1_month(BigDecimal r13_15_days_1_month) {
		this.r13_15_days_1_month = r13_15_days_1_month;
	}
	public void setR13_1_3_months(BigDecimal r13_1_3_months) {
		this.r13_1_3_months = r13_1_3_months;
	}
	public void setR13_3_6_months(BigDecimal r13_3_6_months) {
		this.r13_3_6_months = r13_3_6_months;
	}
	public void setR13_6_12_months(BigDecimal r13_6_12_months) {
		this.r13_6_12_months = r13_6_12_months;
	}
	public void setR13_1_3_years(BigDecimal r13_1_3_years) {
		this.r13_1_3_years = r13_1_3_years;
	}
	public void setR13_3_years(BigDecimal r13_3_years) {
		this.r13_3_years = r13_3_years;
	}
	public void setR13_total(BigDecimal r13_total) {
		this.r13_total = r13_total;
	}
	public void setR14_product(String r14_product) {
		this.r14_product = r14_product;
	}
	public void setR14_overdue(BigDecimal r14_overdue) {
		this.r14_overdue = r14_overdue;
	}
	public void setR14_overdraft(BigDecimal r14_overdraft) {
		this.r14_overdraft = r14_overdraft;
	}
	public void setR14_0_7_days(BigDecimal r14_0_7_days) {
		this.r14_0_7_days = r14_0_7_days;
	}
	public void setR14_8_14_days(BigDecimal r14_8_14_days) {
		this.r14_8_14_days = r14_8_14_days;
	}
	public void setR14_15_days_1_month(BigDecimal r14_15_days_1_month) {
		this.r14_15_days_1_month = r14_15_days_1_month;
	}
	public void setR14_1_3_months(BigDecimal r14_1_3_months) {
		this.r14_1_3_months = r14_1_3_months;
	}
	public void setR14_3_6_months(BigDecimal r14_3_6_months) {
		this.r14_3_6_months = r14_3_6_months;
	}
	public void setR14_6_12_months(BigDecimal r14_6_12_months) {
		this.r14_6_12_months = r14_6_12_months;
	}
	public void setR14_1_3_years(BigDecimal r14_1_3_years) {
		this.r14_1_3_years = r14_1_3_years;
	}
	public void setR14_3_years(BigDecimal r14_3_years) {
		this.r14_3_years = r14_3_years;
	}
	public void setR14_total(BigDecimal r14_total) {
		this.r14_total = r14_total;
	}
	public void setR15_product(String r15_product) {
		this.r15_product = r15_product;
	}
	public void setR15_overdue(BigDecimal r15_overdue) {
		this.r15_overdue = r15_overdue;
	}
	public void setR15_overdraft(BigDecimal r15_overdraft) {
		this.r15_overdraft = r15_overdraft;
	}
	public void setR15_0_7_days(BigDecimal r15_0_7_days) {
		this.r15_0_7_days = r15_0_7_days;
	}
	public void setR15_8_14_days(BigDecimal r15_8_14_days) {
		this.r15_8_14_days = r15_8_14_days;
	}
	public void setR15_15_days_1_month(BigDecimal r15_15_days_1_month) {
		this.r15_15_days_1_month = r15_15_days_1_month;
	}
	public void setR15_1_3_months(BigDecimal r15_1_3_months) {
		this.r15_1_3_months = r15_1_3_months;
	}
	public void setR15_3_6_months(BigDecimal r15_3_6_months) {
		this.r15_3_6_months = r15_3_6_months;
	}
	public void setR15_6_12_months(BigDecimal r15_6_12_months) {
		this.r15_6_12_months = r15_6_12_months;
	}
	public void setR15_1_3_years(BigDecimal r15_1_3_years) {
		this.r15_1_3_years = r15_1_3_years;
	}
	public void setR15_3_years(BigDecimal r15_3_years) {
		this.r15_3_years = r15_3_years;
	}
	public void setR15_total(BigDecimal r15_total) {
		this.r15_total = r15_total;
	}
	public void setR16_product(String r16_product) {
		this.r16_product = r16_product;
	}
	public void setR16_overdue(BigDecimal r16_overdue) {
		this.r16_overdue = r16_overdue;
	}
	public void setR16_overdraft(BigDecimal r16_overdraft) {
		this.r16_overdraft = r16_overdraft;
	}
	public void setR16_0_7_days(BigDecimal r16_0_7_days) {
		this.r16_0_7_days = r16_0_7_days;
	}
	public void setR16_8_14_days(BigDecimal r16_8_14_days) {
		this.r16_8_14_days = r16_8_14_days;
	}
	public void setR16_15_days_1_month(BigDecimal r16_15_days_1_month) {
		this.r16_15_days_1_month = r16_15_days_1_month;
	}
	public void setR16_1_3_months(BigDecimal r16_1_3_months) {
		this.r16_1_3_months = r16_1_3_months;
	}
	public void setR16_3_6_months(BigDecimal r16_3_6_months) {
		this.r16_3_6_months = r16_3_6_months;
	}
	public void setR16_6_12_months(BigDecimal r16_6_12_months) {
		this.r16_6_12_months = r16_6_12_months;
	}
	public void setR16_1_3_years(BigDecimal r16_1_3_years) {
		this.r16_1_3_years = r16_1_3_years;
	}
	public void setR16_3_years(BigDecimal r16_3_years) {
		this.r16_3_years = r16_3_years;
	}
	public void setR16_total(BigDecimal r16_total) {
		this.r16_total = r16_total;
	}
	public void setRh4_product(String rh4_product) {
		this.rh4_product = rh4_product;
	}
	public void setRh4_overdue(BigDecimal rh4_overdue) {
		this.rh4_overdue = rh4_overdue;
	}
	public void setRh4_overdraft(BigDecimal rh4_overdraft) {
		this.rh4_overdraft = rh4_overdraft;
	}
	public void setRh4_0_7_days(BigDecimal rh4_0_7_days) {
		this.rh4_0_7_days = rh4_0_7_days;
	}
	public void setRh4_8_14_days(BigDecimal rh4_8_14_days) {
		this.rh4_8_14_days = rh4_8_14_days;
	}
	public void setRh4_15_days_1_month(BigDecimal rh4_15_days_1_month) {
		this.rh4_15_days_1_month = rh4_15_days_1_month;
	}
	public void setRh4_1_3_months(BigDecimal rh4_1_3_months) {
		this.rh4_1_3_months = rh4_1_3_months;
	}
	public void setRh4_3_6_months(BigDecimal rh4_3_6_months) {
		this.rh4_3_6_months = rh4_3_6_months;
	}
	public void setRh4_6_12_months(BigDecimal rh4_6_12_months) {
		this.rh4_6_12_months = rh4_6_12_months;
	}
	public void setRh4_1_3_years(BigDecimal rh4_1_3_years) {
		this.rh4_1_3_years = rh4_1_3_years;
	}
	public void setRh4_3_years(BigDecimal rh4_3_years) {
		this.rh4_3_years = rh4_3_years;
	}
	public void setRh4_total(BigDecimal rh4_total) {
		this.rh4_total = rh4_total;
	}
	public void setR17_product(String r17_product) {
		this.r17_product = r17_product;
	}
	public void setR17_overdue(BigDecimal r17_overdue) {
		this.r17_overdue = r17_overdue;
	}
	public void setR17_overdraft(BigDecimal r17_overdraft) {
		this.r17_overdraft = r17_overdraft;
	}
	public void setR17_0_7_days(BigDecimal r17_0_7_days) {
		this.r17_0_7_days = r17_0_7_days;
	}
	public void setR17_8_14_days(BigDecimal r17_8_14_days) {
		this.r17_8_14_days = r17_8_14_days;
	}
	public void setR17_15_days_1_month(BigDecimal r17_15_days_1_month) {
		this.r17_15_days_1_month = r17_15_days_1_month;
	}
	public void setR17_1_3_months(BigDecimal r17_1_3_months) {
		this.r17_1_3_months = r17_1_3_months;
	}
	public void setR17_3_6_months(BigDecimal r17_3_6_months) {
		this.r17_3_6_months = r17_3_6_months;
	}
	public void setR17_6_12_months(BigDecimal r17_6_12_months) {
		this.r17_6_12_months = r17_6_12_months;
	}
	public void setR17_1_3_years(BigDecimal r17_1_3_years) {
		this.r17_1_3_years = r17_1_3_years;
	}
	public void setR17_3_years(BigDecimal r17_3_years) {
		this.r17_3_years = r17_3_years;
	}
	public void setR17_total(BigDecimal r17_total) {
		this.r17_total = r17_total;
	}
	public void setR18_product(String r18_product) {
		this.r18_product = r18_product;
	}
	public void setR18_overdue(BigDecimal r18_overdue) {
		this.r18_overdue = r18_overdue;
	}
	public void setR18_overdraft(BigDecimal r18_overdraft) {
		this.r18_overdraft = r18_overdraft;
	}
	public void setR18_0_7_days(BigDecimal r18_0_7_days) {
		this.r18_0_7_days = r18_0_7_days;
	}
	public void setR18_8_14_days(BigDecimal r18_8_14_days) {
		this.r18_8_14_days = r18_8_14_days;
	}
	public void setR18_15_days_1_month(BigDecimal r18_15_days_1_month) {
		this.r18_15_days_1_month = r18_15_days_1_month;
	}
	public void setR18_1_3_months(BigDecimal r18_1_3_months) {
		this.r18_1_3_months = r18_1_3_months;
	}
	public void setR18_3_6_months(BigDecimal r18_3_6_months) {
		this.r18_3_6_months = r18_3_6_months;
	}
	public void setR18_6_12_months(BigDecimal r18_6_12_months) {
		this.r18_6_12_months = r18_6_12_months;
	}
	public void setR18_1_3_years(BigDecimal r18_1_3_years) {
		this.r18_1_3_years = r18_1_3_years;
	}
	public void setR18_3_years(BigDecimal r18_3_years) {
		this.r18_3_years = r18_3_years;
	}
	public void setR18_total(BigDecimal r18_total) {
		this.r18_total = r18_total;
	}
	public void setR_18_product(String r_18_product) {
		this.r_18_product = r_18_product;
	}
	public void setR_18_overdue(BigDecimal r_18_overdue) {
		this.r_18_overdue = r_18_overdue;
	}
	public void setR_18_overdraft(BigDecimal r_18_overdraft) {
		this.r_18_overdraft = r_18_overdraft;
	}
	public void setR_18_0_7_days(BigDecimal r_18_0_7_days) {
		this.r_18_0_7_days = r_18_0_7_days;
	}
	public void setR_18_8_14_days(BigDecimal r_18_8_14_days) {
		this.r_18_8_14_days = r_18_8_14_days;
	}
	public void setR_18_15_days_1_month(BigDecimal r_18_15_days_1_month) {
		this.r_18_15_days_1_month = r_18_15_days_1_month;
	}
	public void setR_18_1_3_months(BigDecimal r_18_1_3_months) {
		this.r_18_1_3_months = r_18_1_3_months;
	}
	public void setR_18_3_6_months(BigDecimal r_18_3_6_months) {
		this.r_18_3_6_months = r_18_3_6_months;
	}
	public void setR_18_6_12_months(BigDecimal r_18_6_12_months) {
		this.r_18_6_12_months = r_18_6_12_months;
	}
	public void setR_18_1_3_years(BigDecimal r_18_1_3_years) {
		this.r_18_1_3_years = r_18_1_3_years;
	}
	public void setR_18_3_years(BigDecimal r_18_3_years) {
		this.r_18_3_years = r_18_3_years;
	}
	public void setR_18_total(BigDecimal r_18_total) {
		this.r_18_total = r_18_total;
	}
	public void setR19_product(String r19_product) {
		this.r19_product = r19_product;
	}
	public void setR19_overdue(BigDecimal r19_overdue) {
		this.r19_overdue = r19_overdue;
	}
	public void setR19_overdraft(BigDecimal r19_overdraft) {
		this.r19_overdraft = r19_overdraft;
	}
	public void setR19_0_7_days(BigDecimal r19_0_7_days) {
		this.r19_0_7_days = r19_0_7_days;
	}
	public void setR19_8_14_days(BigDecimal r19_8_14_days) {
		this.r19_8_14_days = r19_8_14_days;
	}
	public void setR19_15_days_1_month(BigDecimal r19_15_days_1_month) {
		this.r19_15_days_1_month = r19_15_days_1_month;
	}
	public void setR19_1_3_months(BigDecimal r19_1_3_months) {
		this.r19_1_3_months = r19_1_3_months;
	}
	public void setR19_3_6_months(BigDecimal r19_3_6_months) {
		this.r19_3_6_months = r19_3_6_months;
	}
	public void setR19_6_12_months(BigDecimal r19_6_12_months) {
		this.r19_6_12_months = r19_6_12_months;
	}
	public void setR19_1_3_years(BigDecimal r19_1_3_years) {
		this.r19_1_3_years = r19_1_3_years;
	}
	public void setR19_3_years(BigDecimal r19_3_years) {
		this.r19_3_years = r19_3_years;
	}
	public void setR19_total(BigDecimal r19_total) {
		this.r19_total = r19_total;
	}
	public void setR20_product(String r20_product) {
		this.r20_product = r20_product;
	}
	public void setR20_overdue(BigDecimal r20_overdue) {
		this.r20_overdue = r20_overdue;
	}
	public void setR20_overdraft(BigDecimal r20_overdraft) {
		this.r20_overdraft = r20_overdraft;
	}
	public void setR20_0_7_days(BigDecimal r20_0_7_days) {
		this.r20_0_7_days = r20_0_7_days;
	}
	public void setR20_8_14_days(BigDecimal r20_8_14_days) {
		this.r20_8_14_days = r20_8_14_days;
	}
	public void setR20_15_days_1_month(BigDecimal r20_15_days_1_month) {
		this.r20_15_days_1_month = r20_15_days_1_month;
	}
	public void setR20_1_3_months(BigDecimal r20_1_3_months) {
		this.r20_1_3_months = r20_1_3_months;
	}
	public void setR20_3_6_months(BigDecimal r20_3_6_months) {
		this.r20_3_6_months = r20_3_6_months;
	}
	public void setR20_6_12_months(BigDecimal r20_6_12_months) {
		this.r20_6_12_months = r20_6_12_months;
	}
	public void setR20_1_3_years(BigDecimal r20_1_3_years) {
		this.r20_1_3_years = r20_1_3_years;
	}
	public void setR20_3_years(BigDecimal r20_3_years) {
		this.r20_3_years = r20_3_years;
	}
	public void setR20_total(BigDecimal r20_total) {
		this.r20_total = r20_total;
	}
	public void setR21_product(String r21_product) {
		this.r21_product = r21_product;
	}
	public void setR21_overdue(BigDecimal r21_overdue) {
		this.r21_overdue = r21_overdue;
	}
	public void setR21_overdraft(BigDecimal r21_overdraft) {
		this.r21_overdraft = r21_overdraft;
	}
	public void setR21_0_7_days(BigDecimal r21_0_7_days) {
		this.r21_0_7_days = r21_0_7_days;
	}
	public void setR21_8_14_days(BigDecimal r21_8_14_days) {
		this.r21_8_14_days = r21_8_14_days;
	}
	public void setR21_15_days_1_month(BigDecimal r21_15_days_1_month) {
		this.r21_15_days_1_month = r21_15_days_1_month;
	}
	public void setR21_1_3_months(BigDecimal r21_1_3_months) {
		this.r21_1_3_months = r21_1_3_months;
	}
	public void setR21_3_6_months(BigDecimal r21_3_6_months) {
		this.r21_3_6_months = r21_3_6_months;
	}
	public void setR21_6_12_months(BigDecimal r21_6_12_months) {
		this.r21_6_12_months = r21_6_12_months;
	}
	public void setR21_1_3_years(BigDecimal r21_1_3_years) {
		this.r21_1_3_years = r21_1_3_years;
	}
	public void setR21_3_years(BigDecimal r21_3_years) {
		this.r21_3_years = r21_3_years;
	}
	public void setR21_total(BigDecimal r21_total) {
		this.r21_total = r21_total;
	}
	public void setRh5_product(String rh5_product) {
		this.rh5_product = rh5_product;
	}
	public void setRh5_overdue(BigDecimal rh5_overdue) {
		this.rh5_overdue = rh5_overdue;
	}
	public void setRh5_overdraft(BigDecimal rh5_overdraft) {
		this.rh5_overdraft = rh5_overdraft;
	}
	public void setRh5_0_7_days(BigDecimal rh5_0_7_days) {
		this.rh5_0_7_days = rh5_0_7_days;
	}
	public void setRh5_8_14_days(BigDecimal rh5_8_14_days) {
		this.rh5_8_14_days = rh5_8_14_days;
	}
	public void setRh5_15_days_1_month(BigDecimal rh5_15_days_1_month) {
		this.rh5_15_days_1_month = rh5_15_days_1_month;
	}
	public void setRh5_1_3_months(BigDecimal rh5_1_3_months) {
		this.rh5_1_3_months = rh5_1_3_months;
	}
	public void setRh5_3_6_months(BigDecimal rh5_3_6_months) {
		this.rh5_3_6_months = rh5_3_6_months;
	}
	public void setRh5_6_12_months(BigDecimal rh5_6_12_months) {
		this.rh5_6_12_months = rh5_6_12_months;
	}
	public void setRh5_1_3_years(BigDecimal rh5_1_3_years) {
		this.rh5_1_3_years = rh5_1_3_years;
	}
	public void setRh5_3_years(BigDecimal rh5_3_years) {
		this.rh5_3_years = rh5_3_years;
	}
	public void setRh5_total(BigDecimal rh5_total) {
		this.rh5_total = rh5_total;
	}
	public void setR22_product(String r22_product) {
		this.r22_product = r22_product;
	}
	public void setR22_overdue(BigDecimal r22_overdue) {
		this.r22_overdue = r22_overdue;
	}
	public void setR22_overdraft(BigDecimal r22_overdraft) {
		this.r22_overdraft = r22_overdraft;
	}
	public void setR22_0_7_days(BigDecimal r22_0_7_days) {
		this.r22_0_7_days = r22_0_7_days;
	}
	public void setR22_8_14_days(BigDecimal r22_8_14_days) {
		this.r22_8_14_days = r22_8_14_days;
	}
	public void setR22_15_days_1_month(BigDecimal r22_15_days_1_month) {
		this.r22_15_days_1_month = r22_15_days_1_month;
	}
	public void setR22_1_3_months(BigDecimal r22_1_3_months) {
		this.r22_1_3_months = r22_1_3_months;
	}
	public void setR22_3_6_months(BigDecimal r22_3_6_months) {
		this.r22_3_6_months = r22_3_6_months;
	}
	public void setR22_6_12_months(BigDecimal r22_6_12_months) {
		this.r22_6_12_months = r22_6_12_months;
	}
	public void setR22_1_3_years(BigDecimal r22_1_3_years) {
		this.r22_1_3_years = r22_1_3_years;
	}
	public void setR22_3_years(BigDecimal r22_3_years) {
		this.r22_3_years = r22_3_years;
	}
	public void setR22_total(BigDecimal r22_total) {
		this.r22_total = r22_total;
	}
	public void setR23_product(String r23_product) {
		this.r23_product = r23_product;
	}
	public void setR23_overdue(BigDecimal r23_overdue) {
		this.r23_overdue = r23_overdue;
	}
	public void setR23_overdraft(BigDecimal r23_overdraft) {
		this.r23_overdraft = r23_overdraft;
	}
	public void setR23_0_7_days(BigDecimal r23_0_7_days) {
		this.r23_0_7_days = r23_0_7_days;
	}
	public void setR23_8_14_days(BigDecimal r23_8_14_days) {
		this.r23_8_14_days = r23_8_14_days;
	}
	public void setR23_15_days_1_month(BigDecimal r23_15_days_1_month) {
		this.r23_15_days_1_month = r23_15_days_1_month;
	}
	public void setR23_1_3_months(BigDecimal r23_1_3_months) {
		this.r23_1_3_months = r23_1_3_months;
	}
	public void setR23_3_6_months(BigDecimal r23_3_6_months) {
		this.r23_3_6_months = r23_3_6_months;
	}
	public void setR23_6_12_months(BigDecimal r23_6_12_months) {
		this.r23_6_12_months = r23_6_12_months;
	}
	public void setR23_1_3_years(BigDecimal r23_1_3_years) {
		this.r23_1_3_years = r23_1_3_years;
	}
	public void setR23_3_years(BigDecimal r23_3_years) {
		this.r23_3_years = r23_3_years;
	}
	public void setR23_total(BigDecimal r23_total) {
		this.r23_total = r23_total;
	}
	public void setR24_product(String r24_product) {
		this.r24_product = r24_product;
	}
	public void setR24_overdue(BigDecimal r24_overdue) {
		this.r24_overdue = r24_overdue;
	}
	public void setR24_overdraft(BigDecimal r24_overdraft) {
		this.r24_overdraft = r24_overdraft;
	}
	public void setR24_0_7_days(BigDecimal r24_0_7_days) {
		this.r24_0_7_days = r24_0_7_days;
	}
	public void setR24_8_14_days(BigDecimal r24_8_14_days) {
		this.r24_8_14_days = r24_8_14_days;
	}
	public void setR24_15_days_1_month(BigDecimal r24_15_days_1_month) {
		this.r24_15_days_1_month = r24_15_days_1_month;
	}
	public void setR24_1_3_months(BigDecimal r24_1_3_months) {
		this.r24_1_3_months = r24_1_3_months;
	}
	public void setR24_3_6_months(BigDecimal r24_3_6_months) {
		this.r24_3_6_months = r24_3_6_months;
	}
	public void setR24_6_12_months(BigDecimal r24_6_12_months) {
		this.r24_6_12_months = r24_6_12_months;
	}
	public void setR24_1_3_years(BigDecimal r24_1_3_years) {
		this.r24_1_3_years = r24_1_3_years;
	}
	public void setR24_3_years(BigDecimal r24_3_years) {
		this.r24_3_years = r24_3_years;
	}
	public void setR24_total(BigDecimal r24_total) {
		this.r24_total = r24_total;
	}
	public void setR25_product(String r25_product) {
		this.r25_product = r25_product;
	}
	public void setR25_overdue(BigDecimal r25_overdue) {
		this.r25_overdue = r25_overdue;
	}
	public void setR25_overdraft(BigDecimal r25_overdraft) {
		this.r25_overdraft = r25_overdraft;
	}
	public void setR25_0_7_days(BigDecimal r25_0_7_days) {
		this.r25_0_7_days = r25_0_7_days;
	}
	public void setR25_8_14_days(BigDecimal r25_8_14_days) {
		this.r25_8_14_days = r25_8_14_days;
	}
	public void setR25_15_days_1_month(BigDecimal r25_15_days_1_month) {
		this.r25_15_days_1_month = r25_15_days_1_month;
	}
	public void setR25_1_3_months(BigDecimal r25_1_3_months) {
		this.r25_1_3_months = r25_1_3_months;
	}
	public void setR25_3_6_months(BigDecimal r25_3_6_months) {
		this.r25_3_6_months = r25_3_6_months;
	}
	public void setR25_6_12_months(BigDecimal r25_6_12_months) {
		this.r25_6_12_months = r25_6_12_months;
	}
	public void setR25_1_3_years(BigDecimal r25_1_3_years) {
		this.r25_1_3_years = r25_1_3_years;
	}
	public void setR25_3_years(BigDecimal r25_3_years) {
		this.r25_3_years = r25_3_years;
	}
	public void setR25_total(BigDecimal r25_total) {
		this.r25_total = r25_total;
	}
	public void setR26_product(String r26_product) {
		this.r26_product = r26_product;
	}
	public void setR26_overdue(BigDecimal r26_overdue) {
		this.r26_overdue = r26_overdue;
	}
	public void setR26_overdraft(BigDecimal r26_overdraft) {
		this.r26_overdraft = r26_overdraft;
	}
	public void setR26_0_7_days(BigDecimal r26_0_7_days) {
		this.r26_0_7_days = r26_0_7_days;
	}
	public void setR26_8_14_days(BigDecimal r26_8_14_days) {
		this.r26_8_14_days = r26_8_14_days;
	}
	public void setR26_15_days_1_month(BigDecimal r26_15_days_1_month) {
		this.r26_15_days_1_month = r26_15_days_1_month;
	}
	public void setR26_1_3_months(BigDecimal r26_1_3_months) {
		this.r26_1_3_months = r26_1_3_months;
	}
	public void setR26_3_6_months(BigDecimal r26_3_6_months) {
		this.r26_3_6_months = r26_3_6_months;
	}
	public void setR26_6_12_months(BigDecimal r26_6_12_months) {
		this.r26_6_12_months = r26_6_12_months;
	}
	public void setR26_1_3_years(BigDecimal r26_1_3_years) {
		this.r26_1_3_years = r26_1_3_years;
	}
	public void setR26_3_years(BigDecimal r26_3_years) {
		this.r26_3_years = r26_3_years;
	}
	public void setR26_total(BigDecimal r26_total) {
		this.r26_total = r26_total;
	}
	public void setR27_product(String r27_product) {
		this.r27_product = r27_product;
	}
	public void setR27_overdue(BigDecimal r27_overdue) {
		this.r27_overdue = r27_overdue;
	}
	public void setR27_overdraft(BigDecimal r27_overdraft) {
		this.r27_overdraft = r27_overdraft;
	}
	public void setR27_0_7_days(BigDecimal r27_0_7_days) {
		this.r27_0_7_days = r27_0_7_days;
	}
	public void setR27_8_14_days(BigDecimal r27_8_14_days) {
		this.r27_8_14_days = r27_8_14_days;
	}
	public void setR27_15_days_1_month(BigDecimal r27_15_days_1_month) {
		this.r27_15_days_1_month = r27_15_days_1_month;
	}
	public void setR27_1_3_months(BigDecimal r27_1_3_months) {
		this.r27_1_3_months = r27_1_3_months;
	}
	public void setR27_3_6_months(BigDecimal r27_3_6_months) {
		this.r27_3_6_months = r27_3_6_months;
	}
	public void setR27_6_12_months(BigDecimal r27_6_12_months) {
		this.r27_6_12_months = r27_6_12_months;
	}
	public void setR27_1_3_years(BigDecimal r27_1_3_years) {
		this.r27_1_3_years = r27_1_3_years;
	}
	public void setR27_3_years(BigDecimal r27_3_years) {
		this.r27_3_years = r27_3_years;
	}
	public void setR27_total(BigDecimal r27_total) {
		this.r27_total = r27_total;
	}
	public void setR28_product(String r28_product) {
		this.r28_product = r28_product;
	}
	public void setR28_overdue(BigDecimal r28_overdue) {
		this.r28_overdue = r28_overdue;
	}
	public void setR28_overdraft(BigDecimal r28_overdraft) {
		this.r28_overdraft = r28_overdraft;
	}
	public void setR28_0_7_days(BigDecimal r28_0_7_days) {
		this.r28_0_7_days = r28_0_7_days;
	}
	public void setR28_8_14_days(BigDecimal r28_8_14_days) {
		this.r28_8_14_days = r28_8_14_days;
	}
	public void setR28_15_days_1_month(BigDecimal r28_15_days_1_month) {
		this.r28_15_days_1_month = r28_15_days_1_month;
	}
	public void setR28_1_3_months(BigDecimal r28_1_3_months) {
		this.r28_1_3_months = r28_1_3_months;
	}
	public void setR28_3_6_months(BigDecimal r28_3_6_months) {
		this.r28_3_6_months = r28_3_6_months;
	}
	public void setR28_6_12_months(BigDecimal r28_6_12_months) {
		this.r28_6_12_months = r28_6_12_months;
	}
	public void setR28_1_3_years(BigDecimal r28_1_3_years) {
		this.r28_1_3_years = r28_1_3_years;
	}
	public void setR28_3_years(BigDecimal r28_3_years) {
		this.r28_3_years = r28_3_years;
	}
	public void setR28_total(BigDecimal r28_total) {
		this.r28_total = r28_total;
	}
	public void setR29_product(String r29_product) {
		this.r29_product = r29_product;
	}
	public void setR29_overdue(BigDecimal r29_overdue) {
		this.r29_overdue = r29_overdue;
	}
	public void setR29_overdraft(BigDecimal r29_overdraft) {
		this.r29_overdraft = r29_overdraft;
	}
	public void setR29_0_7_days(BigDecimal r29_0_7_days) {
		this.r29_0_7_days = r29_0_7_days;
	}
	public void setR29_8_14_days(BigDecimal r29_8_14_days) {
		this.r29_8_14_days = r29_8_14_days;
	}
	public void setR29_15_days_1_month(BigDecimal r29_15_days_1_month) {
		this.r29_15_days_1_month = r29_15_days_1_month;
	}
	public void setR29_1_3_months(BigDecimal r29_1_3_months) {
		this.r29_1_3_months = r29_1_3_months;
	}
	public void setR29_3_6_months(BigDecimal r29_3_6_months) {
		this.r29_3_6_months = r29_3_6_months;
	}
	public void setR29_6_12_months(BigDecimal r29_6_12_months) {
		this.r29_6_12_months = r29_6_12_months;
	}
	public void setR29_1_3_years(BigDecimal r29_1_3_years) {
		this.r29_1_3_years = r29_1_3_years;
	}
	public void setR29_3_years(BigDecimal r29_3_years) {
		this.r29_3_years = r29_3_years;
	}
	public void setR29_total(BigDecimal r29_total) {
		this.r29_total = r29_total;
	}
	public void setR30_product(String r30_product) {
		this.r30_product = r30_product;
	}
	public void setR30_overdue(BigDecimal r30_overdue) {
		this.r30_overdue = r30_overdue;
	}
	public void setR30_overdraft(BigDecimal r30_overdraft) {
		this.r30_overdraft = r30_overdraft;
	}
	public void setR30_0_7_days(BigDecimal r30_0_7_days) {
		this.r30_0_7_days = r30_0_7_days;
	}
	public void setR30_8_14_days(BigDecimal r30_8_14_days) {
		this.r30_8_14_days = r30_8_14_days;
	}
	public void setR30_15_days_1_month(BigDecimal r30_15_days_1_month) {
		this.r30_15_days_1_month = r30_15_days_1_month;
	}
	public void setR30_1_3_months(BigDecimal r30_1_3_months) {
		this.r30_1_3_months = r30_1_3_months;
	}
	public void setR30_3_6_months(BigDecimal r30_3_6_months) {
		this.r30_3_6_months = r30_3_6_months;
	}
	public void setR30_6_12_months(BigDecimal r30_6_12_months) {
		this.r30_6_12_months = r30_6_12_months;
	}
	public void setR30_1_3_years(BigDecimal r30_1_3_years) {
		this.r30_1_3_years = r30_1_3_years;
	}
	public void setR30_3_years(BigDecimal r30_3_years) {
		this.r30_3_years = r30_3_years;
	}
	public void setR30_total(BigDecimal r30_total) {
		this.r30_total = r30_total;
	}
	public void setR31_product(String r31_product) {
		this.r31_product = r31_product;
	}
	public void setR31_overdue(BigDecimal r31_overdue) {
		this.r31_overdue = r31_overdue;
	}
	public void setR31_overdraft(BigDecimal r31_overdraft) {
		this.r31_overdraft = r31_overdraft;
	}
	public void setR31_0_7_days(BigDecimal r31_0_7_days) {
		this.r31_0_7_days = r31_0_7_days;
	}
	public void setR31_8_14_days(BigDecimal r31_8_14_days) {
		this.r31_8_14_days = r31_8_14_days;
	}
	public void setR31_15_days_1_month(BigDecimal r31_15_days_1_month) {
		this.r31_15_days_1_month = r31_15_days_1_month;
	}
	public void setR31_1_3_months(BigDecimal r31_1_3_months) {
		this.r31_1_3_months = r31_1_3_months;
	}
	public void setR31_3_6_months(BigDecimal r31_3_6_months) {
		this.r31_3_6_months = r31_3_6_months;
	}
	public void setR31_6_12_months(BigDecimal r31_6_12_months) {
		this.r31_6_12_months = r31_6_12_months;
	}
	public void setR31_1_3_years(BigDecimal r31_1_3_years) {
		this.r31_1_3_years = r31_1_3_years;
	}
	public void setR31_3_years(BigDecimal r31_3_years) {
		this.r31_3_years = r31_3_years;
	}
	public void setR31_total(BigDecimal r31_total) {
		this.r31_total = r31_total;
	}
	public void setRta_product(String rta_product) {
		this.rta_product = rta_product;
	}
	public void setRta_overdue(BigDecimal rta_overdue) {
		this.rta_overdue = rta_overdue;
	}
	public void setRta_overdraft(BigDecimal rta_overdraft) {
		this.rta_overdraft = rta_overdraft;
	}
	public void setRta_0_7_days(BigDecimal rta_0_7_days) {
		this.rta_0_7_days = rta_0_7_days;
	}
	public void setRta_8_14_days(BigDecimal rta_8_14_days) {
		this.rta_8_14_days = rta_8_14_days;
	}
	public void setRta_15_days_1_month(BigDecimal rta_15_days_1_month) {
		this.rta_15_days_1_month = rta_15_days_1_month;
	}
	public void setRta_1_3_months(BigDecimal rta_1_3_months) {
		this.rta_1_3_months = rta_1_3_months;
	}
	public void setRta_3_6_months(BigDecimal rta_3_6_months) {
		this.rta_3_6_months = rta_3_6_months;
	}
	public void setRta_6_12_months(BigDecimal rta_6_12_months) {
		this.rta_6_12_months = rta_6_12_months;
	}
	public void setRta_1_3_years(BigDecimal rta_1_3_years) {
		this.rta_1_3_years = rta_1_3_years;
	}
	public void setRta_3_years(BigDecimal rta_3_years) {
		this.rta_3_years = rta_3_years;
	}
	public void setRta_total(BigDecimal rta_total) {
		this.rta_total = rta_total;
	}
	public void setRh6_product(String rh6_product) {
		this.rh6_product = rh6_product;
	}
	public void setRh6_overdue(BigDecimal rh6_overdue) {
		this.rh6_overdue = rh6_overdue;
	}
	public void setRh6_overdraft(BigDecimal rh6_overdraft) {
		this.rh6_overdraft = rh6_overdraft;
	}
	public void setRh6_0_7_days(BigDecimal rh6_0_7_days) {
		this.rh6_0_7_days = rh6_0_7_days;
	}
	public void setRh6_8_14_days(BigDecimal rh6_8_14_days) {
		this.rh6_8_14_days = rh6_8_14_days;
	}
	public void setRh6_15_days_1_month(BigDecimal rh6_15_days_1_month) {
		this.rh6_15_days_1_month = rh6_15_days_1_month;
	}
	public void setRh6_1_3_months(BigDecimal rh6_1_3_months) {
		this.rh6_1_3_months = rh6_1_3_months;
	}
	public void setRh6_3_6_months(BigDecimal rh6_3_6_months) {
		this.rh6_3_6_months = rh6_3_6_months;
	}
	public void setRh6_6_12_months(BigDecimal rh6_6_12_months) {
		this.rh6_6_12_months = rh6_6_12_months;
	}
	public void setRh6_1_3_years(BigDecimal rh6_1_3_years) {
		this.rh6_1_3_years = rh6_1_3_years;
	}
	public void setRh6_3_years(BigDecimal rh6_3_years) {
		this.rh6_3_years = rh6_3_years;
	}
	public void setRh6_total(BigDecimal rh6_total) {
		this.rh6_total = rh6_total;
	}
	public void setR32_product(String r32_product) {
		this.r32_product = r32_product;
	}
	public void setR32_overdue(BigDecimal r32_overdue) {
		this.r32_overdue = r32_overdue;
	}
	public void setR32_overdraft(BigDecimal r32_overdraft) {
		this.r32_overdraft = r32_overdraft;
	}
	public void setR32_0_7_days(BigDecimal r32_0_7_days) {
		this.r32_0_7_days = r32_0_7_days;
	}
	public void setR32_8_14_days(BigDecimal r32_8_14_days) {
		this.r32_8_14_days = r32_8_14_days;
	}
	public void setR32_15_days_1_month(BigDecimal r32_15_days_1_month) {
		this.r32_15_days_1_month = r32_15_days_1_month;
	}
	public void setR32_1_3_months(BigDecimal r32_1_3_months) {
		this.r32_1_3_months = r32_1_3_months;
	}
	public void setR32_3_6_months(BigDecimal r32_3_6_months) {
		this.r32_3_6_months = r32_3_6_months;
	}
	public void setR32_6_12_months(BigDecimal r32_6_12_months) {
		this.r32_6_12_months = r32_6_12_months;
	}
	public void setR32_1_3_years(BigDecimal r32_1_3_years) {
		this.r32_1_3_years = r32_1_3_years;
	}
	public void setR32_3_years(BigDecimal r32_3_years) {
		this.r32_3_years = r32_3_years;
	}
	public void setR32_total(BigDecimal r32_total) {
		this.r32_total = r32_total;
	}
	public void setR33_product(String r33_product) {
		this.r33_product = r33_product;
	}
	public void setR33_overdue(BigDecimal r33_overdue) {
		this.r33_overdue = r33_overdue;
	}
	public void setR33_overdraft(BigDecimal r33_overdraft) {
		this.r33_overdraft = r33_overdraft;
	}
	public void setR33_0_7_days(BigDecimal r33_0_7_days) {
		this.r33_0_7_days = r33_0_7_days;
	}
	public void setR33_8_14_days(BigDecimal r33_8_14_days) {
		this.r33_8_14_days = r33_8_14_days;
	}
	public void setR33_15_days_1_month(BigDecimal r33_15_days_1_month) {
		this.r33_15_days_1_month = r33_15_days_1_month;
	}
	public void setR33_1_3_months(BigDecimal r33_1_3_months) {
		this.r33_1_3_months = r33_1_3_months;
	}
	public void setR33_3_6_months(BigDecimal r33_3_6_months) {
		this.r33_3_6_months = r33_3_6_months;
	}
	public void setR33_6_12_months(BigDecimal r33_6_12_months) {
		this.r33_6_12_months = r33_6_12_months;
	}
	public void setR33_1_3_years(BigDecimal r33_1_3_years) {
		this.r33_1_3_years = r33_1_3_years;
	}
	public void setR33_3_years(BigDecimal r33_3_years) {
		this.r33_3_years = r33_3_years;
	}
	public void setR33_total(BigDecimal r33_total) {
		this.r33_total = r33_total;
	}
	public void setR34_product(String r34_product) {
		this.r34_product = r34_product;
	}
	public void setR34_overdue(BigDecimal r34_overdue) {
		this.r34_overdue = r34_overdue;
	}
	public void setR34_overdraft(BigDecimal r34_overdraft) {
		this.r34_overdraft = r34_overdraft;
	}
	public void setR34_0_7_days(BigDecimal r34_0_7_days) {
		this.r34_0_7_days = r34_0_7_days;
	}
	public void setR34_8_14_days(BigDecimal r34_8_14_days) {
		this.r34_8_14_days = r34_8_14_days;
	}
	public void setR34_15_days_1_month(BigDecimal r34_15_days_1_month) {
		this.r34_15_days_1_month = r34_15_days_1_month;
	}
	public void setR34_1_3_months(BigDecimal r34_1_3_months) {
		this.r34_1_3_months = r34_1_3_months;
	}
	public void setR34_3_6_months(BigDecimal r34_3_6_months) {
		this.r34_3_6_months = r34_3_6_months;
	}
	public void setR34_6_12_months(BigDecimal r34_6_12_months) {
		this.r34_6_12_months = r34_6_12_months;
	}
	public void setR34_1_3_years(BigDecimal r34_1_3_years) {
		this.r34_1_3_years = r34_1_3_years;
	}
	public void setR34_3_years(BigDecimal r34_3_years) {
		this.r34_3_years = r34_3_years;
	}
	public void setR34_total(BigDecimal r34_total) {
		this.r34_total = r34_total;
	}
	public void setR35_product(String r35_product) {
		this.r35_product = r35_product;
	}
	public void setR35_overdue(BigDecimal r35_overdue) {
		this.r35_overdue = r35_overdue;
	}
	public void setR35_overdraft(BigDecimal r35_overdraft) {
		this.r35_overdraft = r35_overdraft;
	}
	public void setR35_0_7_days(BigDecimal r35_0_7_days) {
		this.r35_0_7_days = r35_0_7_days;
	}
	public void setR35_8_14_days(BigDecimal r35_8_14_days) {
		this.r35_8_14_days = r35_8_14_days;
	}
	public void setR35_15_days_1_month(BigDecimal r35_15_days_1_month) {
		this.r35_15_days_1_month = r35_15_days_1_month;
	}
	public void setR35_1_3_months(BigDecimal r35_1_3_months) {
		this.r35_1_3_months = r35_1_3_months;
	}
	public void setR35_3_6_months(BigDecimal r35_3_6_months) {
		this.r35_3_6_months = r35_3_6_months;
	}
	public void setR35_6_12_months(BigDecimal r35_6_12_months) {
		this.r35_6_12_months = r35_6_12_months;
	}
	public void setR35_1_3_years(BigDecimal r35_1_3_years) {
		this.r35_1_3_years = r35_1_3_years;
	}
	public void setR35_3_years(BigDecimal r35_3_years) {
		this.r35_3_years = r35_3_years;
	}
	public void setR35_total(BigDecimal r35_total) {
		this.r35_total = r35_total;
	}
	public void setR36_product(String r36_product) {
		this.r36_product = r36_product;
	}
	public void setR36_overdue(BigDecimal r36_overdue) {
		this.r36_overdue = r36_overdue;
	}
	public void setR36_overdraft(BigDecimal r36_overdraft) {
		this.r36_overdraft = r36_overdraft;
	}
	public void setR36_0_7_days(BigDecimal r36_0_7_days) {
		this.r36_0_7_days = r36_0_7_days;
	}
	public void setR36_8_14_days(BigDecimal r36_8_14_days) {
		this.r36_8_14_days = r36_8_14_days;
	}
	public void setR36_15_days_1_month(BigDecimal r36_15_days_1_month) {
		this.r36_15_days_1_month = r36_15_days_1_month;
	}
	public void setR36_1_3_months(BigDecimal r36_1_3_months) {
		this.r36_1_3_months = r36_1_3_months;
	}
	public void setR36_3_6_months(BigDecimal r36_3_6_months) {
		this.r36_3_6_months = r36_3_6_months;
	}
	public void setR36_6_12_months(BigDecimal r36_6_12_months) {
		this.r36_6_12_months = r36_6_12_months;
	}
	public void setR36_1_3_years(BigDecimal r36_1_3_years) {
		this.r36_1_3_years = r36_1_3_years;
	}
	public void setR36_3_years(BigDecimal r36_3_years) {
		this.r36_3_years = r36_3_years;
	}
	public void setR36_total(BigDecimal r36_total) {
		this.r36_total = r36_total;
	}
	public void setRh7_product(String rh7_product) {
		this.rh7_product = rh7_product;
	}
	public void setRh7_overdue(BigDecimal rh7_overdue) {
		this.rh7_overdue = rh7_overdue;
	}
	public void setRh7_overdraft(BigDecimal rh7_overdraft) {
		this.rh7_overdraft = rh7_overdraft;
	}
	public void setRh7_0_7_days(BigDecimal rh7_0_7_days) {
		this.rh7_0_7_days = rh7_0_7_days;
	}
	public void setRh7_8_14_days(BigDecimal rh7_8_14_days) {
		this.rh7_8_14_days = rh7_8_14_days;
	}
	public void setRh7_15_days_1_month(BigDecimal rh7_15_days_1_month) {
		this.rh7_15_days_1_month = rh7_15_days_1_month;
	}
	public void setRh7_1_3_months(BigDecimal rh7_1_3_months) {
		this.rh7_1_3_months = rh7_1_3_months;
	}
	public void setRh7_3_6_months(BigDecimal rh7_3_6_months) {
		this.rh7_3_6_months = rh7_3_6_months;
	}
	public void setRh7_6_12_months(BigDecimal rh7_6_12_months) {
		this.rh7_6_12_months = rh7_6_12_months;
	}
	public void setRh7_1_3_years(BigDecimal rh7_1_3_years) {
		this.rh7_1_3_years = rh7_1_3_years;
	}
	public void setRh7_3_years(BigDecimal rh7_3_years) {
		this.rh7_3_years = rh7_3_years;
	}
	public void setRh7_total(BigDecimal rh7_total) {
		this.rh7_total = rh7_total;
	}
	public void setR37_product(String r37_product) {
		this.r37_product = r37_product;
	}
	public void setR37_overdue(BigDecimal r37_overdue) {
		this.r37_overdue = r37_overdue;
	}
	public void setR37_overdraft(BigDecimal r37_overdraft) {
		this.r37_overdraft = r37_overdraft;
	}
	public void setR37_0_7_days(BigDecimal r37_0_7_days) {
		this.r37_0_7_days = r37_0_7_days;
	}
	public void setR37_8_14_days(BigDecimal r37_8_14_days) {
		this.r37_8_14_days = r37_8_14_days;
	}
	public void setR37_15_days_1_month(BigDecimal r37_15_days_1_month) {
		this.r37_15_days_1_month = r37_15_days_1_month;
	}
	public void setR37_1_3_months(BigDecimal r37_1_3_months) {
		this.r37_1_3_months = r37_1_3_months;
	}
	public void setR37_3_6_months(BigDecimal r37_3_6_months) {
		this.r37_3_6_months = r37_3_6_months;
	}
	public void setR37_6_12_months(BigDecimal r37_6_12_months) {
		this.r37_6_12_months = r37_6_12_months;
	}
	public void setR37_1_3_years(BigDecimal r37_1_3_years) {
		this.r37_1_3_years = r37_1_3_years;
	}
	public void setR37_3_years(BigDecimal r37_3_years) {
		this.r37_3_years = r37_3_years;
	}
	public void setR37_total(BigDecimal r37_total) {
		this.r37_total = r37_total;
	}
	public void setR38_product(String r38_product) {
		this.r38_product = r38_product;
	}
	public void setR38_overdue(BigDecimal r38_overdue) {
		this.r38_overdue = r38_overdue;
	}
	public void setR38_overdraft(BigDecimal r38_overdraft) {
		this.r38_overdraft = r38_overdraft;
	}
	public void setR38_0_7_days(BigDecimal r38_0_7_days) {
		this.r38_0_7_days = r38_0_7_days;
	}
	public void setR38_8_14_days(BigDecimal r38_8_14_days) {
		this.r38_8_14_days = r38_8_14_days;
	}
	public void setR38_15_days_1_month(BigDecimal r38_15_days_1_month) {
		this.r38_15_days_1_month = r38_15_days_1_month;
	}
	public void setR38_1_3_months(BigDecimal r38_1_3_months) {
		this.r38_1_3_months = r38_1_3_months;
	}
	public void setR38_3_6_months(BigDecimal r38_3_6_months) {
		this.r38_3_6_months = r38_3_6_months;
	}
	public void setR38_6_12_months(BigDecimal r38_6_12_months) {
		this.r38_6_12_months = r38_6_12_months;
	}
	public void setR38_1_3_years(BigDecimal r38_1_3_years) {
		this.r38_1_3_years = r38_1_3_years;
	}
	public void setR38_3_years(BigDecimal r38_3_years) {
		this.r38_3_years = r38_3_years;
	}
	public void setR38_total(BigDecimal r38_total) {
		this.r38_total = r38_total;
	}
	public void setR39_product(String r39_product) {
		this.r39_product = r39_product;
	}
	public void setR39_overdue(BigDecimal r39_overdue) {
		this.r39_overdue = r39_overdue;
	}
	public void setR39_overdraft(BigDecimal r39_overdraft) {
		this.r39_overdraft = r39_overdraft;
	}
	public void setR39_0_7_days(BigDecimal r39_0_7_days) {
		this.r39_0_7_days = r39_0_7_days;
	}
	public void setR39_8_14_days(BigDecimal r39_8_14_days) {
		this.r39_8_14_days = r39_8_14_days;
	}
	public void setR39_15_days_1_month(BigDecimal r39_15_days_1_month) {
		this.r39_15_days_1_month = r39_15_days_1_month;
	}
	public void setR39_1_3_months(BigDecimal r39_1_3_months) {
		this.r39_1_3_months = r39_1_3_months;
	}
	public void setR39_3_6_months(BigDecimal r39_3_6_months) {
		this.r39_3_6_months = r39_3_6_months;
	}
	public void setR39_6_12_months(BigDecimal r39_6_12_months) {
		this.r39_6_12_months = r39_6_12_months;
	}
	public void setR39_1_3_years(BigDecimal r39_1_3_years) {
		this.r39_1_3_years = r39_1_3_years;
	}
	public void setR39_3_years(BigDecimal r39_3_years) {
		this.r39_3_years = r39_3_years;
	}
	public void setR39_total(BigDecimal r39_total) {
		this.r39_total = r39_total;
	}
	public void setR40_product(String r40_product) {
		this.r40_product = r40_product;
	}
	public void setR40_overdue(BigDecimal r40_overdue) {
		this.r40_overdue = r40_overdue;
	}
	public void setR40_overdraft(BigDecimal r40_overdraft) {
		this.r40_overdraft = r40_overdraft;
	}
	public void setR40_0_7_days(BigDecimal r40_0_7_days) {
		this.r40_0_7_days = r40_0_7_days;
	}
	public void setR40_8_14_days(BigDecimal r40_8_14_days) {
		this.r40_8_14_days = r40_8_14_days;
	}
	public void setR40_15_days_1_month(BigDecimal r40_15_days_1_month) {
		this.r40_15_days_1_month = r40_15_days_1_month;
	}
	public void setR40_1_3_months(BigDecimal r40_1_3_months) {
		this.r40_1_3_months = r40_1_3_months;
	}
	public void setR40_3_6_months(BigDecimal r40_3_6_months) {
		this.r40_3_6_months = r40_3_6_months;
	}
	public void setR40_6_12_months(BigDecimal r40_6_12_months) {
		this.r40_6_12_months = r40_6_12_months;
	}
	public void setR40_1_3_years(BigDecimal r40_1_3_years) {
		this.r40_1_3_years = r40_1_3_years;
	}
	public void setR40_3_years(BigDecimal r40_3_years) {
		this.r40_3_years = r40_3_years;
	}
	public void setR40_total(BigDecimal r40_total) {
		this.r40_total = r40_total;
	}
	public void setR41_product(String r41_product) {
		this.r41_product = r41_product;
	}
	public void setR41_overdue(BigDecimal r41_overdue) {
		this.r41_overdue = r41_overdue;
	}
	public void setR41_overdraft(BigDecimal r41_overdraft) {
		this.r41_overdraft = r41_overdraft;
	}
	public void setR41_0_7_days(BigDecimal r41_0_7_days) {
		this.r41_0_7_days = r41_0_7_days;
	}
	public void setR41_8_14_days(BigDecimal r41_8_14_days) {
		this.r41_8_14_days = r41_8_14_days;
	}
	public void setR41_15_days_1_month(BigDecimal r41_15_days_1_month) {
		this.r41_15_days_1_month = r41_15_days_1_month;
	}
	public void setR41_1_3_months(BigDecimal r41_1_3_months) {
		this.r41_1_3_months = r41_1_3_months;
	}
	public void setR41_3_6_months(BigDecimal r41_3_6_months) {
		this.r41_3_6_months = r41_3_6_months;
	}
	public void setR41_6_12_months(BigDecimal r41_6_12_months) {
		this.r41_6_12_months = r41_6_12_months;
	}
	public void setR41_1_3_years(BigDecimal r41_1_3_years) {
		this.r41_1_3_years = r41_1_3_years;
	}
	public void setR41_3_years(BigDecimal r41_3_years) {
		this.r41_3_years = r41_3_years;
	}
	public void setR41_total(BigDecimal r41_total) {
		this.r41_total = r41_total;
	}
	public void setR42_product(String r42_product) {
		this.r42_product = r42_product;
	}
	public void setR42_overdue(BigDecimal r42_overdue) {
		this.r42_overdue = r42_overdue;
	}
	public void setR42_overdraft(BigDecimal r42_overdraft) {
		this.r42_overdraft = r42_overdraft;
	}
	public void setR42_0_7_days(BigDecimal r42_0_7_days) {
		this.r42_0_7_days = r42_0_7_days;
	}
	public void setR42_8_14_days(BigDecimal r42_8_14_days) {
		this.r42_8_14_days = r42_8_14_days;
	}
	public void setR42_15_days_1_month(BigDecimal r42_15_days_1_month) {
		this.r42_15_days_1_month = r42_15_days_1_month;
	}
	public void setR42_1_3_months(BigDecimal r42_1_3_months) {
		this.r42_1_3_months = r42_1_3_months;
	}
	public void setR42_3_6_months(BigDecimal r42_3_6_months) {
		this.r42_3_6_months = r42_3_6_months;
	}
	public void setR42_6_12_months(BigDecimal r42_6_12_months) {
		this.r42_6_12_months = r42_6_12_months;
	}
	public void setR42_1_3_years(BigDecimal r42_1_3_years) {
		this.r42_1_3_years = r42_1_3_years;
	}
	public void setR42_3_years(BigDecimal r42_3_years) {
		this.r42_3_years = r42_3_years;
	}
	public void setR42_total(BigDecimal r42_total) {
		this.r42_total = r42_total;
	}
	public void setRh8_product(String rh8_product) {
		this.rh8_product = rh8_product;
	}
	public void setRh8_overdue(BigDecimal rh8_overdue) {
		this.rh8_overdue = rh8_overdue;
	}
	public void setRh8_overdraft(BigDecimal rh8_overdraft) {
		this.rh8_overdraft = rh8_overdraft;
	}
	public void setRh8_0_7_days(BigDecimal rh8_0_7_days) {
		this.rh8_0_7_days = rh8_0_7_days;
	}
	public void setRh8_8_14_days(BigDecimal rh8_8_14_days) {
		this.rh8_8_14_days = rh8_8_14_days;
	}
	public void setRh8_15_days_1_month(BigDecimal rh8_15_days_1_month) {
		this.rh8_15_days_1_month = rh8_15_days_1_month;
	}
	public void setRh8_1_3_months(BigDecimal rh8_1_3_months) {
		this.rh8_1_3_months = rh8_1_3_months;
	}
	public void setRh8_3_6_months(BigDecimal rh8_3_6_months) {
		this.rh8_3_6_months = rh8_3_6_months;
	}
	public void setRh8_6_12_months(BigDecimal rh8_6_12_months) {
		this.rh8_6_12_months = rh8_6_12_months;
	}
	public void setRh8_1_3_years(BigDecimal rh8_1_3_years) {
		this.rh8_1_3_years = rh8_1_3_years;
	}
	public void setRh8_3_years(BigDecimal rh8_3_years) {
		this.rh8_3_years = rh8_3_years;
	}
	public void setRh8_total(BigDecimal rh8_total) {
		this.rh8_total = rh8_total;
	}
	public void setR43_product(String r43_product) {
		this.r43_product = r43_product;
	}
	public void setR43_overdue(BigDecimal r43_overdue) {
		this.r43_overdue = r43_overdue;
	}
	public void setR43_overdraft(BigDecimal r43_overdraft) {
		this.r43_overdraft = r43_overdraft;
	}
	public void setR43_0_7_days(BigDecimal r43_0_7_days) {
		this.r43_0_7_days = r43_0_7_days;
	}
	public void setR43_8_14_days(BigDecimal r43_8_14_days) {
		this.r43_8_14_days = r43_8_14_days;
	}
	public void setR43_15_days_1_month(BigDecimal r43_15_days_1_month) {
		this.r43_15_days_1_month = r43_15_days_1_month;
	}
	public void setR43_1_3_months(BigDecimal r43_1_3_months) {
		this.r43_1_3_months = r43_1_3_months;
	}
	public void setR43_3_6_months(BigDecimal r43_3_6_months) {
		this.r43_3_6_months = r43_3_6_months;
	}
	public void setR43_6_12_months(BigDecimal r43_6_12_months) {
		this.r43_6_12_months = r43_6_12_months;
	}
	public void setR43_1_3_years(BigDecimal r43_1_3_years) {
		this.r43_1_3_years = r43_1_3_years;
	}
	public void setR43_3_years(BigDecimal r43_3_years) {
		this.r43_3_years = r43_3_years;
	}
	public void setR43_total(BigDecimal r43_total) {
		this.r43_total = r43_total;
	}
	public void setR44_product(String r44_product) {
		this.r44_product = r44_product;
	}
	public void setR44_overdue(BigDecimal r44_overdue) {
		this.r44_overdue = r44_overdue;
	}
	public void setR44_overdraft(BigDecimal r44_overdraft) {
		this.r44_overdraft = r44_overdraft;
	}
	public void setR44_0_7_days(BigDecimal r44_0_7_days) {
		this.r44_0_7_days = r44_0_7_days;
	}
	public void setR44_8_14_days(BigDecimal r44_8_14_days) {
		this.r44_8_14_days = r44_8_14_days;
	}
	public void setR44_15_days_1_month(BigDecimal r44_15_days_1_month) {
		this.r44_15_days_1_month = r44_15_days_1_month;
	}
	public void setR44_1_3_months(BigDecimal r44_1_3_months) {
		this.r44_1_3_months = r44_1_3_months;
	}
	public void setR44_3_6_months(BigDecimal r44_3_6_months) {
		this.r44_3_6_months = r44_3_6_months;
	}
	public void setR44_6_12_months(BigDecimal r44_6_12_months) {
		this.r44_6_12_months = r44_6_12_months;
	}
	public void setR44_1_3_years(BigDecimal r44_1_3_years) {
		this.r44_1_3_years = r44_1_3_years;
	}
	public void setR44_3_years(BigDecimal r44_3_years) {
		this.r44_3_years = r44_3_years;
	}
	public void setR44_total(BigDecimal r44_total) {
		this.r44_total = r44_total;
	}
	public void setR45_product(String r45_product) {
		this.r45_product = r45_product;
	}
	public void setR45_overdue(BigDecimal r45_overdue) {
		this.r45_overdue = r45_overdue;
	}
	public void setR45_overdraft(BigDecimal r45_overdraft) {
		this.r45_overdraft = r45_overdraft;
	}
	public void setR45_0_7_days(BigDecimal r45_0_7_days) {
		this.r45_0_7_days = r45_0_7_days;
	}
	public void setR45_8_14_days(BigDecimal r45_8_14_days) {
		this.r45_8_14_days = r45_8_14_days;
	}
	public void setR45_15_days_1_month(BigDecimal r45_15_days_1_month) {
		this.r45_15_days_1_month = r45_15_days_1_month;
	}
	public void setR45_1_3_months(BigDecimal r45_1_3_months) {
		this.r45_1_3_months = r45_1_3_months;
	}
	public void setR45_3_6_months(BigDecimal r45_3_6_months) {
		this.r45_3_6_months = r45_3_6_months;
	}
	public void setR45_6_12_months(BigDecimal r45_6_12_months) {
		this.r45_6_12_months = r45_6_12_months;
	}
	public void setR45_1_3_years(BigDecimal r45_1_3_years) {
		this.r45_1_3_years = r45_1_3_years;
	}
	public void setR45_3_years(BigDecimal r45_3_years) {
		this.r45_3_years = r45_3_years;
	}
	public void setR45_total(BigDecimal r45_total) {
		this.r45_total = r45_total;
	}
	public void setR46_product(String r46_product) {
		this.r46_product = r46_product;
	}
	public void setR46_overdue(BigDecimal r46_overdue) {
		this.r46_overdue = r46_overdue;
	}
	public void setR46_overdraft(BigDecimal r46_overdraft) {
		this.r46_overdraft = r46_overdraft;
	}
	public void setR46_0_7_days(BigDecimal r46_0_7_days) {
		this.r46_0_7_days = r46_0_7_days;
	}
	public void setR46_8_14_days(BigDecimal r46_8_14_days) {
		this.r46_8_14_days = r46_8_14_days;
	}
	public void setR46_15_days_1_month(BigDecimal r46_15_days_1_month) {
		this.r46_15_days_1_month = r46_15_days_1_month;
	}
	public void setR46_1_3_months(BigDecimal r46_1_3_months) {
		this.r46_1_3_months = r46_1_3_months;
	}
	public void setR46_3_6_months(BigDecimal r46_3_6_months) {
		this.r46_3_6_months = r46_3_6_months;
	}
	public void setR46_6_12_months(BigDecimal r46_6_12_months) {
		this.r46_6_12_months = r46_6_12_months;
	}
	public void setR46_1_3_years(BigDecimal r46_1_3_years) {
		this.r46_1_3_years = r46_1_3_years;
	}
	public void setR46_3_years(BigDecimal r46_3_years) {
		this.r46_3_years = r46_3_years;
	}
	public void setR46_total(BigDecimal r46_total) {
		this.r46_total = r46_total;
	}
	public void setRtl_product(String rtl_product) {
		this.rtl_product = rtl_product;
	}
	public void setRtl_overdue(BigDecimal rtl_overdue) {
		this.rtl_overdue = rtl_overdue;
	}
	public void setRtl_overdraft(BigDecimal rtl_overdraft) {
		this.rtl_overdraft = rtl_overdraft;
	}
	public void setRtl_0_7_days(BigDecimal rtl_0_7_days) {
		this.rtl_0_7_days = rtl_0_7_days;
	}
	public void setRtl_8_14_days(BigDecimal rtl_8_14_days) {
		this.rtl_8_14_days = rtl_8_14_days;
	}
	public void setRtl_15_days_1_month(BigDecimal rtl_15_days_1_month) {
		this.rtl_15_days_1_month = rtl_15_days_1_month;
	}
	public void setRtl_1_3_months(BigDecimal rtl_1_3_months) {
		this.rtl_1_3_months = rtl_1_3_months;
	}
	public void setRtl_3_6_months(BigDecimal rtl_3_6_months) {
		this.rtl_3_6_months = rtl_3_6_months;
	}
	public void setRtl_6_12_months(BigDecimal rtl_6_12_months) {
		this.rtl_6_12_months = rtl_6_12_months;
	}
	public void setRtl_1_3_years(BigDecimal rtl_1_3_years) {
		this.rtl_1_3_years = rtl_1_3_years;
	}
	public void setRtl_3_years(BigDecimal rtl_3_years) {
		this.rtl_3_years = rtl_3_years;
	}
	public void setRtl_total(BigDecimal rtl_total) {
		this.rtl_total = rtl_total;
	}
	public void setReport_date(Date report_date) {
		this.report_date = report_date;
	}
	public void setReport_from_date(Date report_from_date) {
		this.report_from_date = report_from_date;
	}
	public void setReport_to_date(Date report_to_date) {
		this.report_to_date = report_to_date;
	}
	public void setEntity_flg(String entity_flg) {
		this.entity_flg = entity_flg;
	}
	public void setModify_flg(String modify_flg) {
		this.modify_flg = modify_flg;
	}
	public void setDel_flg(String del_flg) {
		this.del_flg = del_flg;
	}
	public void setReport_code(String report_code) {
		this.report_code = report_code;
	}
	public void setReport_submit_date(Date report_submit_date) {
		this.report_submit_date = report_submit_date;
	}
	public void setRepdesc(String repdesc) {
		this.repdesc = repdesc;
	}
	public void setFrequency(String frequency) {
		this.frequency = frequency;
	}
	public BRF9_ENTITY() {
		super();
		// TODO Auto-generated constructor stub
	}
}