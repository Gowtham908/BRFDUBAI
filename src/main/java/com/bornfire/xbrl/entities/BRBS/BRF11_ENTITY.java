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
@Table(name="BRF11_SUMMARYTABLE")
public class BRF11_ENTITY{

	private String	rh_product;
	private BigDecimal	rh_overdraft;
	private BigDecimal	rh_0_7_days;
	private BigDecimal	rh_8_14_days;
	private BigDecimal	rh_15_days_1_month;
	private BigDecimal	rh_1_3_months;
	private BigDecimal	rh_3_6_months;
	private BigDecimal	rh_6_12_months;
	private BigDecimal	rh_1_2_years;
	private BigDecimal	rh_2_3_years;
	private BigDecimal	rh_3_4_years;
	private BigDecimal	rh_4_5_years;
	private BigDecimal	rh_5_years;
	private BigDecimal	rh_non_interest;
	private BigDecimal	rh_total;
	private String	r1_product;
	private BigDecimal	r1_overdraft;
	private BigDecimal	r1_0_7_days;
	private BigDecimal	r1_8_14_days;
	private BigDecimal	r1_15_days_1_month;
	private BigDecimal	r1_1_3_months;
	private BigDecimal	r1_3_6_months;
	private BigDecimal	r1_6_12_months;
	private BigDecimal	r1_1_2_years;
	private BigDecimal	r1_2_3_years;
	private BigDecimal	r1_3_4_years;
	private BigDecimal	r1_4_5_years;
	private BigDecimal	r1_5_years;
	private BigDecimal	r1_non_interest;
	private BigDecimal	r1_total;
	private String	r2_product;
	private BigDecimal	r2_overdraft;
	private BigDecimal	r2_0_7_days;
	private BigDecimal	r2_8_14_days;
	private BigDecimal	r2_15_days_1_month;
	private BigDecimal	r2_1_3_months;
	private BigDecimal	r2_3_6_months;
	private BigDecimal	r2_6_12_months;
	private BigDecimal	r2_1_2_years;
	private BigDecimal	r2_2_3_years;
	private BigDecimal	r2_3_4_years;
	private BigDecimal	r2_4_5_years;
	private BigDecimal	r2_5_years;
	private BigDecimal	r2_non_interest;
	private BigDecimal	r2_total;
	private String	r3_product;
	private BigDecimal	r3_overdraft;
	private BigDecimal	r3_0_7_days;
	private BigDecimal	r3_8_14_days;
	private BigDecimal	r3_15_days_1_month;
	private BigDecimal	r3_1_3_months;
	private BigDecimal	r3_3_6_months;
	private BigDecimal	r3_6_12_months;
	private BigDecimal	r3_1_2_years;
	private BigDecimal	r3_2_3_years;
	private BigDecimal	r3_3_4_years;
	private BigDecimal	r3_4_5_years;
	private BigDecimal	r3_5_years;
	private BigDecimal	r3_non_interest;
	private BigDecimal	r3_total;
	private String	rh2_product;
	private BigDecimal	rh2_overdraft;
	private BigDecimal	rh2_0_7_days;
	private BigDecimal	rh2_8_14_days;
	private BigDecimal	rh2_15_days_1_month;
	private BigDecimal	rh2_1_3_months;
	private BigDecimal	rh2_3_6_months;
	private BigDecimal	rh2_6_12_months;
	private BigDecimal	rh2_1_2_years;
	private BigDecimal	rh2_2_3_years;
	private BigDecimal	rh2_3_4_years;
	private BigDecimal	rh2_4_5_years;
	private BigDecimal	rh2_5_years;
	private BigDecimal	rh2_non_interest;
	private BigDecimal	rh2_total;
	private String	r4_product;
	private BigDecimal	r4_overdraft;
	private BigDecimal	r4_0_7_days;
	private BigDecimal	r4_8_14_days;
	private BigDecimal	r4_15_days_1_month;
	private BigDecimal	r4_1_3_months;
	private BigDecimal	r4_3_6_months;
	private BigDecimal	r4_6_12_months;
	private BigDecimal	r4_1_2_years;
	private BigDecimal	r4_2_3_years;
	private BigDecimal	r4_3_4_years;
	private BigDecimal	r4_4_5_years;
	private BigDecimal	r4_5_years;
	private BigDecimal	r4_non_interest;
	private BigDecimal	r4_total;
	private String	r5_product;
	private BigDecimal	r5_overdraft;
	private BigDecimal	r5_0_7_days;
	private BigDecimal	r5_8_14_days;
	private BigDecimal	r5_15_days_1_month;
	private BigDecimal	r5_1_3_months;
	private BigDecimal	r5_3_6_months;
	private BigDecimal	r5_6_12_months;
	private BigDecimal	r5_1_2_years;
	private BigDecimal	r5_2_3_years;
	private BigDecimal	r5_3_4_years;
	private BigDecimal	r5_4_5_years;
	private BigDecimal	r5_5_years;
	private BigDecimal	r5_non_interest;
	private BigDecimal	r5_total;
	private String	r6_product;
	private BigDecimal	r6_overdraft;
	private BigDecimal	r6_0_7_days;
	private BigDecimal	r6_8_14_days;
	private BigDecimal	r6_15_days_1_month;
	private BigDecimal	r6_1_3_months;
	private BigDecimal	r6_3_6_months;
	private BigDecimal	r6_6_12_months;
	private BigDecimal	r6_1_2_years;
	private BigDecimal	r6_2_3_years;
	private BigDecimal	r6_3_4_years;
	private BigDecimal	r6_4_5_years;
	private BigDecimal	r6_5_years;
	private BigDecimal	r6_non_interest;
	private BigDecimal	r6_total;
	private String	rh3_product;
	private BigDecimal	rh3_overdraft;
	private BigDecimal	rh3_0_7_days;
	private BigDecimal	rh3_8_14_days;
	private BigDecimal	rh3_15_days_1_month;
	private BigDecimal	rh3_1_3_months;
	private BigDecimal	rh3_3_6_months;
	private BigDecimal	rh3_6_12_months;
	private BigDecimal	rh3_1_2_years;
	private BigDecimal	rh3_2_3_years;
	private BigDecimal	rh3_3_4_years;
	private BigDecimal	rh3_4_5_years;
	private BigDecimal	rh3_5_years;
	private BigDecimal	rh3_non_interest;
	private BigDecimal	rh3_total;
	private String	r7_product;
	private BigDecimal	r7_overdraft;
	private BigDecimal	r7_0_7_days;
	private BigDecimal	r7_8_14_days;
	private BigDecimal	r7_15_days_1_month;
	private BigDecimal	r7_1_3_months;
	private BigDecimal	r7_3_6_months;
	private BigDecimal	r7_6_12_months;
	private BigDecimal	r7_1_2_years;
	private BigDecimal	r7_2_3_years;
	private BigDecimal	r7_3_4_years;
	private BigDecimal	r7_4_5_years;
	private BigDecimal	r7_5_years;
	private BigDecimal	r7_non_interest;
	private BigDecimal	r7_total;
	private String	r8_product;
	private BigDecimal	r8_overdraft;
	private BigDecimal	r8_0_7_days;
	private BigDecimal	r8_8_14_days;
	private BigDecimal	r8_15_days_1_month;
	private BigDecimal	r8_1_3_months;
	private BigDecimal	r8_3_6_months;
	private BigDecimal	r8_6_12_months;
	private BigDecimal	r8_1_2_years;
	private BigDecimal	r8_2_3_years;
	private BigDecimal	r8_3_4_years;
	private BigDecimal	r8_4_5_years;
	private BigDecimal	r8_5_years;
	private BigDecimal	r8_non_interest;
	private BigDecimal	r8_total;
	private String	r9_product;
	private BigDecimal	r9_overdraft;
	private BigDecimal	r9_0_7_days;
	private BigDecimal	r9_8_14_days;
	private BigDecimal	r9_15_days_1_month;
	private BigDecimal	r9_1_3_months;
	private BigDecimal	r9_3_6_months;
	private BigDecimal	r9_6_12_months;
	private BigDecimal	r9_1_2_years;
	private BigDecimal	r9_2_3_years;
	private BigDecimal	r9_3_4_years;
	private BigDecimal	r9_4_5_years;
	private BigDecimal	r9_5_years;
	private BigDecimal	r9_non_interest;
	private BigDecimal	r9_total;
	private String	r10_product;
	private BigDecimal	r10_overdraft;
	private BigDecimal	r10_0_7_days;
	private BigDecimal	r10_8_14_days;
	private BigDecimal	r10_15_days_1_month;
	private BigDecimal	r10_1_3_months;
	private BigDecimal	r10_3_6_months;
	private BigDecimal	r10_6_12_months;
	private BigDecimal	r10_1_2_years;
	private BigDecimal	r10_2_3_years;
	private BigDecimal	r10_3_4_years;
	private BigDecimal	r10_4_5_years;
	private BigDecimal	r10_5_years;
	private BigDecimal	r10_non_interest;
	private BigDecimal	r10_total;
	private String	r11_product;
	private BigDecimal	r11_overdraft;
	private BigDecimal	r11_0_7_days;
	private BigDecimal	r11_8_14_days;
	private BigDecimal	r11_15_days_1_month;
	private BigDecimal	r11_1_3_months;
	private BigDecimal	r11_3_6_months;
	private BigDecimal	r11_6_12_months;
	private BigDecimal	r11_1_2_years;
	private BigDecimal	r11_2_3_years;
	private BigDecimal	r11_3_4_years;
	private BigDecimal	r11_4_5_years;
	private BigDecimal	r11_5_years;
	private BigDecimal	r11_non_interest;
	private BigDecimal	r11_total;
	private String	r12_product;
	private BigDecimal	r12_overdraft;
	private BigDecimal	r12_0_7_days;
	private BigDecimal	r12_8_14_days;
	private BigDecimal	r12_15_days_1_month;
	private BigDecimal	r12_1_3_months;
	private BigDecimal	r12_3_6_months;
	private BigDecimal	r12_6_12_months;
	private BigDecimal	r12_1_2_years;
	private BigDecimal	r12_2_3_years;
	private BigDecimal	r12_3_4_years;
	private BigDecimal	r12_4_5_years;
	private BigDecimal	r12_5_years;
	private BigDecimal	r12_non_interest;
	private BigDecimal	r12_total;
	private String	r13_product;
	private BigDecimal	r13_overdraft;
	private BigDecimal	r13_0_7_days;
	private BigDecimal	r13_8_14_days;
	private BigDecimal	r13_15_days_1_month;
	private BigDecimal	r13_1_3_months;
	private BigDecimal	r13_3_6_months;
	private BigDecimal	r13_6_12_months;
	private BigDecimal	r13_1_2_years;
	private BigDecimal	r13_2_3_years;
	private BigDecimal	r13_3_4_years;
	private BigDecimal	r13_4_5_years;
	private BigDecimal	r13_5_years;
	private BigDecimal	r13_non_interest;
	private BigDecimal	r13_total;
	private String	r14_product;
	private BigDecimal	r14_overdraft;
	private BigDecimal	r14_0_7_days;
	private BigDecimal	r14_8_14_days;
	private BigDecimal	r14_15_days_1_month;
	private BigDecimal	r14_1_3_months;
	private BigDecimal	r14_3_6_months;
	private BigDecimal	r14_6_12_months;
	private BigDecimal	r14_1_2_years;
	private BigDecimal	r14_2_3_years;
	private BigDecimal	r14_3_4_years;
	private BigDecimal	r14_4_5_years;
	private BigDecimal	r14_5_years;
	private BigDecimal	r14_non_interest;
	private BigDecimal	r14_total;
	private String	r15_product;
	private BigDecimal	r15_overdraft;
	private BigDecimal	r15_0_7_days;
	private BigDecimal	r15_8_14_days;
	private BigDecimal	r15_15_days_1_month;
	private BigDecimal	r15_1_3_months;
	private BigDecimal	r15_3_6_months;
	private BigDecimal	r15_6_12_months;
	private BigDecimal	r15_1_2_years;
	private BigDecimal	r15_2_3_years;
	private BigDecimal	r15_3_4_years;
	private BigDecimal	r15_4_5_years;
	private BigDecimal	r15_5_years;
	private BigDecimal	r15_non_interest;
	private BigDecimal	r15_total;
	private String	r16_product;
	private BigDecimal	r16_overdraft;
	private BigDecimal	r16_0_7_days;
	private BigDecimal	r16_8_14_days;
	private BigDecimal	r16_15_days_1_month;
	private BigDecimal	r16_1_3_months;
	private BigDecimal	r16_3_6_months;
	private BigDecimal	r16_6_12_months;
	private BigDecimal	r16_1_2_years;
	private BigDecimal	r16_2_3_years;
	private BigDecimal	r16_3_4_years;
	private BigDecimal	r16_4_5_years;
	private BigDecimal	r16_5_years;
	private BigDecimal	r16_non_interest;
	private BigDecimal	r16_total;
	private String	rh4_product;
	private BigDecimal	rh4_overdraft;
	private BigDecimal	rh4_0_7_days;
	private BigDecimal	rh4_8_14_days;
	private BigDecimal	rh4_15_days_1_month;
	private BigDecimal	rh4_1_3_months;
	private BigDecimal	rh4_3_6_months;
	private BigDecimal	rh4_6_12_months;
	private BigDecimal	rh4_1_2_years;
	private BigDecimal	rh4_2_3_years;
	private BigDecimal	rh4_3_4_years;
	private BigDecimal	rh4_4_5_years;
	private BigDecimal	rh4_5_years;
	private BigDecimal	rh4_non_interest;
	private BigDecimal	rh4_total;
	private String	r17_product;
	private BigDecimal	r17_overdraft;
	private BigDecimal	r17_0_7_days;
	private BigDecimal	r17_8_14_days;
	private BigDecimal	r17_15_days_1_month;
	private BigDecimal	r17_1_3_months;
	private BigDecimal	r17_3_6_months;
	private BigDecimal	r17_6_12_months;
	private BigDecimal	r17_1_2_years;
	private BigDecimal	r17_2_3_years;
	private BigDecimal	r17_3_4_years;
	private BigDecimal	r17_4_5_years;
	private BigDecimal	r17_5_years;
	private BigDecimal	r17_non_interest;
	private BigDecimal	r17_total;
	private String	r18_product;
	private BigDecimal	r18_overdraft;
	private BigDecimal	r18_0_7_days;
	private BigDecimal	r18_8_14_days;
	private BigDecimal	r18_15_days_1_month;
	private BigDecimal	r18_1_3_months;
	private BigDecimal	r18_3_6_months;
	private BigDecimal	r18_6_12_months;
	private BigDecimal	r18_1_2_years;
	private BigDecimal	r18_2_3_years;
	private BigDecimal	r18_3_4_years;
	private BigDecimal	r18_4_5_years;
	private BigDecimal	r18_5_years;
	private BigDecimal	r18_non_interest;
	private BigDecimal	r18_total;
	private String	r19_product;
	private BigDecimal	r19_overdraft;
	private BigDecimal	r19_0_7_days;
	private BigDecimal	r19_8_14_days;
	private BigDecimal	r19_15_days_1_month;
	private BigDecimal	r19_1_3_months;
	private BigDecimal	r19_3_6_months;
	private BigDecimal	r19_6_12_months;
	private BigDecimal	r19_1_2_years;
	private BigDecimal	r19_2_3_years;
	private BigDecimal	r19_3_4_years;
	private BigDecimal	r19_4_5_years;
	private BigDecimal	r19_5_years;
	private BigDecimal	r19_non_interest;
	private BigDecimal	r19_total;
	private String	r20_product;
	private BigDecimal	r20_overdraft;
	private BigDecimal	r20_0_7_days;
	private BigDecimal	r20_8_14_days;
	private BigDecimal	r20_15_days_1_month;
	private BigDecimal	r20_1_3_months;
	private BigDecimal	r20_3_6_months;
	private BigDecimal	r20_6_12_months;
	private BigDecimal	r20_1_2_years;
	private BigDecimal	r20_2_3_years;
	private BigDecimal	r20_3_4_years;
	private BigDecimal	r20_4_5_years;
	private BigDecimal	r20_5_years;
	private BigDecimal	r20_non_interest;
	private BigDecimal	r20_total;
	private String	r21_product;
	private BigDecimal	r21_overdraft;
	private BigDecimal	r21_0_7_days;
	private BigDecimal	r21_8_14_days;
	private BigDecimal	r21_15_days_1_month;
	private BigDecimal	r21_1_3_months;
	private BigDecimal	r21_3_6_months;
	private BigDecimal	r21_6_12_months;
	private BigDecimal	r21_1_2_years;
	private BigDecimal	r21_2_3_years;
	private BigDecimal	r21_3_4_years;
	private BigDecimal	r21_4_5_years;
	private BigDecimal	r21_5_years;
	private BigDecimal	r21_non_interest;
	private BigDecimal	r21_total;
	private String	r22_product;
	private BigDecimal	r22_overdraft;
	private BigDecimal	r22_0_7_days;
	private BigDecimal	r22_8_14_days;
	private BigDecimal	r22_15_days_1_month;
	private BigDecimal	r22_1_3_months;
	private BigDecimal	r22_3_6_months;
	private BigDecimal	r22_6_12_months;
	private BigDecimal	r22_1_2_years;
	private BigDecimal	r22_2_3_years;
	private BigDecimal	r22_3_4_years;
	private BigDecimal	r22_4_5_years;
	private BigDecimal	r22_5_years;
	private BigDecimal	r22_non_interest;
	private BigDecimal	r22_total;
	private String	rh5_product;
	private BigDecimal	rh5_overdraft;
	private BigDecimal	rh5_0_7_days;
	private BigDecimal	rh5_8_14_days;
	private BigDecimal	rh5_15_days_1_month;
	private BigDecimal	rh5_1_3_months;
	private BigDecimal	rh5_3_6_months;
	private BigDecimal	rh5_6_12_months;
	private BigDecimal	rh5_1_2_years;
	private BigDecimal	rh5_2_3_years;
	private BigDecimal	rh5_3_4_years;
	private BigDecimal	rh5_4_5_years;
	private BigDecimal	rh5_5_years;
	private BigDecimal	rh5_non_interest;
	private BigDecimal	rh5_total;
	private String	r23_product;
	private BigDecimal	r23_overdraft;
	private BigDecimal	r23_0_7_days;
	private BigDecimal	r23_8_14_days;
	private BigDecimal	r23_15_days_1_month;
	private BigDecimal	r23_1_3_months;
	private BigDecimal	r23_3_6_months;
	private BigDecimal	r23_6_12_months;
	private BigDecimal	r23_1_2_years;
	private BigDecimal	r23_2_3_years;
	private BigDecimal	r23_3_4_years;
	private BigDecimal	r23_4_5_years;
	private BigDecimal	r23_5_years;
	private BigDecimal	r23_non_interest;
	private BigDecimal	r23_total;
	private String	r24_product;
	private BigDecimal	r24_overdraft;
	private BigDecimal	r24_0_7_days;
	private BigDecimal	r24_8_14_days;
	private BigDecimal	r24_15_days_1_month;
	private BigDecimal	r24_1_3_months;
	private BigDecimal	r24_3_6_months;
	private BigDecimal	r24_6_12_months;
	private BigDecimal	r24_1_2_years;
	private BigDecimal	r24_2_3_years;
	private BigDecimal	r24_3_4_years;
	private BigDecimal	r24_4_5_years;
	private BigDecimal	r24_5_years;
	private BigDecimal	r24_non_interest;
	private BigDecimal	r24_total;
	private String	r25_product;
	private BigDecimal	r25_overdraft;
	private BigDecimal	r25_0_7_days;
	private BigDecimal	r25_8_14_days;
	private BigDecimal	r25_15_days_1_month;
	private BigDecimal	r25_1_3_months;
	private BigDecimal	r25_3_6_months;
	private BigDecimal	r25_6_12_months;
	private BigDecimal	r25_1_2_years;
	private BigDecimal	r25_2_3_years;
	private BigDecimal	r25_3_4_years;
	private BigDecimal	r25_4_5_years;
	private BigDecimal	r25_5_years;
	private BigDecimal	r25_non_interest;
	private BigDecimal	r25_total;
	private String	r26_product;
	private BigDecimal	r26_overdraft;
	private BigDecimal	r26_0_7_days;
	private BigDecimal	r26_8_14_days;
	private BigDecimal	r26_15_days_1_month;
	private BigDecimal	r26_1_3_months;
	private BigDecimal	r26_3_6_months;
	private BigDecimal	r26_6_12_months;
	private BigDecimal	r26_1_2_years;
	private BigDecimal	r26_2_3_years;
	private BigDecimal	r26_3_4_years;
	private BigDecimal	r26_4_5_years;
	private BigDecimal	r26_5_years;
	private BigDecimal	r26_non_interest;
	private BigDecimal	r26_total;
	private String	r27_product;
	private BigDecimal	r27_overdraft;
	private BigDecimal	r27_0_7_days;
	private BigDecimal	r27_8_14_days;
	private BigDecimal	r27_15_days_1_month;
	private BigDecimal	r27_1_3_months;
	private BigDecimal	r27_3_6_months;
	private BigDecimal	r27_6_12_months;
	private BigDecimal	r27_1_2_years;
	private BigDecimal	r27_2_3_years;
	private BigDecimal	r27_3_4_years;
	private BigDecimal	r27_4_5_years;
	private BigDecimal	r27_5_years;
	private BigDecimal	r27_non_interest;
	private BigDecimal	r27_total;
	private String	r28_product;
	private BigDecimal	r28_overdraft;
	private BigDecimal	r28_0_7_days;
	private BigDecimal	r28_8_14_days;
	private BigDecimal	r28_15_days_1_month;
	private BigDecimal	r28_1_3_months;
	private BigDecimal	r28_3_6_months;
	private BigDecimal	r28_6_12_months;
	private BigDecimal	r28_1_2_years;
	private BigDecimal	r28_2_3_years;
	private BigDecimal	r28_3_4_years;
	private BigDecimal	r28_4_5_years;
	private BigDecimal	r28_5_years;
	private BigDecimal	r28_non_interest;
	private BigDecimal	r28_total;
	private String	r29_product;
	private BigDecimal	r29_overdraft;
	private BigDecimal	r29_0_7_days;
	private BigDecimal	r29_8_14_days;
	private BigDecimal	r29_15_days_1_month;
	private BigDecimal	r29_1_3_months;
	private BigDecimal	r29_3_6_months;
	private BigDecimal	r29_6_12_months;
	private BigDecimal	r29_1_2_years;
	private BigDecimal	r29_2_3_years;
	private BigDecimal	r29_3_4_years;
	private BigDecimal	r29_4_5_years;
	private BigDecimal	r29_5_years;
	private BigDecimal	r29_non_interest;
	private BigDecimal	r29_total;
	private String	r30_product;
	private BigDecimal	r30_overdraft;
	private BigDecimal	r30_0_7_days;
	private BigDecimal	r30_8_14_days;
	private BigDecimal	r30_15_days_1_month;
	private BigDecimal	r30_1_3_months;
	private BigDecimal	r30_3_6_months;
	private BigDecimal	r30_6_12_months;
	private BigDecimal	r30_1_2_years;
	private BigDecimal	r30_2_3_years;
	private BigDecimal	r30_3_4_years;
	private BigDecimal	r30_4_5_years;
	private BigDecimal	r30_5_years;
	private BigDecimal	r30_non_interest;
	private BigDecimal	r30_total;
	private String	r31_product;
	private BigDecimal	r31_overdraft;
	private BigDecimal	r31_0_7_days;
	private BigDecimal	r31_8_14_days;
	private BigDecimal	r31_15_days_1_month;
	private BigDecimal	r31_1_3_months;
	private BigDecimal	r31_3_6_months;
	private BigDecimal	r31_6_12_months;
	private BigDecimal	r31_1_2_years;
	private BigDecimal	r31_2_3_years;
	private BigDecimal	r31_3_4_years;
	private BigDecimal	r31_4_5_years;
	private BigDecimal	r31_5_years;
	private BigDecimal	r31_non_interest;
	private BigDecimal	r31_total;
	private String	r32_product;
	private BigDecimal	r32_overdraft;
	private BigDecimal	r32_0_7_days;
	private BigDecimal	r32_8_14_days;
	private BigDecimal	r32_15_days_1_month;
	private BigDecimal	r32_1_3_months;
	private BigDecimal	r32_3_6_months;
	private BigDecimal	r32_6_12_months;
	private BigDecimal	r32_1_2_years;
	private BigDecimal	r32_2_3_years;
	private BigDecimal	r32_3_4_years;
	private BigDecimal	r32_4_5_years;
	private BigDecimal	r32_5_years;
	private BigDecimal	r32_non_interest;
	private BigDecimal	r32_total;
	private String	rta_product;
	private BigDecimal	rta_overdraft;
	private BigDecimal	rta_0_7_days;
	private BigDecimal	rta_8_14_days;
	private BigDecimal	rta_15_days_1_month;
	private BigDecimal	rta_1_3_months;
	private BigDecimal	rta_3_6_months;
	private BigDecimal	rta_6_12_months;
	private BigDecimal	rta_1_2_years;
	private BigDecimal	rta_2_3_years;
	private BigDecimal	rta_3_4_years;
	private BigDecimal	rta_4_5_years;
	private BigDecimal	rta_5_years;
	private BigDecimal	rta_non_interest;
	private BigDecimal	rta_total;
	private String	rh6_product;
	private BigDecimal	rh6_overdraft;
	private BigDecimal	rh6_0_7_days;
	private BigDecimal	rh6_8_14_days;
	private BigDecimal	rh6_15_days_1_month;
	private BigDecimal	rh6_1_3_months;
	private BigDecimal	rh6_3_6_months;
	private BigDecimal	rh6_6_12_months;
	private BigDecimal	rh6_1_2_years;
	private BigDecimal	rh6_2_3_years;
	private BigDecimal	rh6_3_4_years;
	private BigDecimal	rh6_4_5_years;
	private BigDecimal	rh6_5_years;
	private BigDecimal	rh6_non_interest;
	private BigDecimal	rh6_total;
	private String	r33_product;
	private BigDecimal	r33_overdraft;
	private BigDecimal	r33_0_7_days;
	private BigDecimal	r33_8_14_days;
	private BigDecimal	r33_15_days_1_month;
	private BigDecimal	r33_1_3_months;
	private BigDecimal	r33_3_6_months;
	private BigDecimal	r33_6_12_months;
	private BigDecimal	r33_1_2_years;
	private BigDecimal	r33_2_3_years;
	private BigDecimal	r33_3_4_years;
	private BigDecimal	r33_4_5_years;
	private BigDecimal	r33_5_years;
	private BigDecimal	r33_non_interest;
	private BigDecimal	r33_total;
	private String	r34_product;
	private BigDecimal	r34_overdraft;
	private BigDecimal	r34_0_7_days;
	private BigDecimal	r34_8_14_days;
	private BigDecimal	r34_15_days_1_month;
	private BigDecimal	r34_1_3_months;
	private BigDecimal	r34_3_6_months;
	private BigDecimal	r34_6_12_months;
	private BigDecimal	r34_1_2_years;
	private BigDecimal	r34_2_3_years;
	private BigDecimal	r34_3_4_years;
	private BigDecimal	r34_4_5_years;
	private BigDecimal	r34_5_years;
	private BigDecimal	r34_non_interest;
	private BigDecimal	r34_total;
	private String	r35_product;
	private BigDecimal	r35_overdraft;
	private BigDecimal	r35_0_7_days;
	private BigDecimal	r35_8_14_days;
	private BigDecimal	r35_15_days_1_month;
	private BigDecimal	r35_1_3_months;
	private BigDecimal	r35_3_6_months;
	private BigDecimal	r35_6_12_months;
	private BigDecimal	r35_1_2_years;
	private BigDecimal	r35_2_3_years;
	private BigDecimal	r35_3_4_years;
	private BigDecimal	r35_4_5_years;
	private BigDecimal	r35_5_years;
	private BigDecimal	r35_non_interest;
	private BigDecimal	r35_total;
	private String	r36_product;
	private BigDecimal	r36_overdraft;
	private BigDecimal	r36_0_7_days;
	private BigDecimal	r36_8_14_days;
	private BigDecimal	r36_15_days_1_month;
	private BigDecimal	r36_1_3_months;
	private BigDecimal	r36_3_6_months;
	private BigDecimal	r36_6_12_months;
	private BigDecimal	r36_1_2_years;
	private BigDecimal	r36_2_3_years;
	private BigDecimal	r36_3_4_years;
	private BigDecimal	r36_4_5_years;
	private BigDecimal	r36_5_years;
	private BigDecimal	r36_non_interest;
	private BigDecimal	r36_total;
	private String	r37_product;
	private BigDecimal	r37_overdraft;
	private BigDecimal	r37_0_7_days;
	private BigDecimal	r37_8_14_days;
	private BigDecimal	r37_15_days_1_month;
	private BigDecimal	r37_1_3_months;
	private BigDecimal	r37_3_6_months;
	private BigDecimal	r37_6_12_months;
	private BigDecimal	r37_1_2_years;
	private BigDecimal	r37_2_3_years;
	private BigDecimal	r37_3_4_years;
	private BigDecimal	r37_4_5_years;
	private BigDecimal	r37_5_years;
	private BigDecimal	r37_non_interest;
	private BigDecimal	r37_total;
	private String	rh7_product;
	private BigDecimal	rh7_overdraft;
	private BigDecimal	rh7_0_7_days;
	private BigDecimal	rh7_8_14_days;
	private BigDecimal	rh7_15_days_1_month;
	private BigDecimal	rh7_1_3_months;
	private BigDecimal	rh7_3_6_months;
	private BigDecimal	rh7_6_12_months;
	private BigDecimal	rh7_1_2_years;
	private BigDecimal	rh7_2_3_years;
	private BigDecimal	rh7_3_4_years;
	private BigDecimal	rh7_4_5_years;
	private BigDecimal	rh7_5_years;
	private BigDecimal	rh7_non_interest;
	private BigDecimal	rh7_total;
	private String	r38_product;
	private BigDecimal	r38_overdraft;
	private BigDecimal	r38_0_7_days;
	private BigDecimal	r38_8_14_days;
	private BigDecimal	r38_15_days_1_month;
	private BigDecimal	r38_1_3_months;
	private BigDecimal	r38_3_6_months;
	private BigDecimal	r38_6_12_months;
	private BigDecimal	r38_1_2_years;
	private BigDecimal	r38_2_3_years;
	private BigDecimal	r38_3_4_years;
	private BigDecimal	r38_4_5_years;
	private BigDecimal	r38_5_years;
	private BigDecimal	r38_non_interest;
	private BigDecimal	r38_total;
	private String	r39_product;
	private BigDecimal	r39_overdraft;
	private BigDecimal	r39_0_7_days;
	private BigDecimal	r39_8_14_days;
	private BigDecimal	r39_15_days_1_month;
	private BigDecimal	r39_1_3_months;
	private BigDecimal	r39_3_6_months;
	private BigDecimal	r39_6_12_months;
	private BigDecimal	r39_1_2_years;
	private BigDecimal	r39_2_3_years;
	private BigDecimal	r39_3_4_years;
	private BigDecimal	r39_4_5_years;
	private BigDecimal	r39_5_years;
	private BigDecimal	r39_non_interest;
	private BigDecimal	r39_total;
	private String	r40_product;
	private BigDecimal	r40_overdraft;
	private BigDecimal	r40_0_7_days;
	private BigDecimal	r40_8_14_days;
	private BigDecimal	r40_15_days_1_month;
	private BigDecimal	r40_1_3_months;
	private BigDecimal	r40_3_6_months;
	private BigDecimal	r40_6_12_months;
	private BigDecimal	r40_1_2_years;
	private BigDecimal	r40_2_3_years;
	private BigDecimal	r40_3_4_years;
	private BigDecimal	r40_4_5_years;
	private BigDecimal	r40_5_years;
	private BigDecimal	r40_non_interest;
	private BigDecimal	r40_total;
	private String	r41_product;
	private BigDecimal	r41_overdraft;
	private BigDecimal	r41_0_7_days;
	private BigDecimal	r41_8_14_days;
	private BigDecimal	r41_15_days_1_month;
	private BigDecimal	r41_1_3_months;
	private BigDecimal	r41_3_6_months;
	private BigDecimal	r41_6_12_months;
	private BigDecimal	r41_1_2_years;
	private BigDecimal	r41_2_3_years;
	private BigDecimal	r41_3_4_years;
	private BigDecimal	r41_4_5_years;
	private BigDecimal	r41_5_years;
	private BigDecimal	r41_non_interest;
	private BigDecimal	r41_total;
	private String	r42_product;
	private BigDecimal	r42_overdraft;
	private BigDecimal	r42_0_7_days;
	private BigDecimal	r42_8_14_days;
	private BigDecimal	r42_15_days_1_month;
	private BigDecimal	r42_1_3_months;
	private BigDecimal	r42_3_6_months;
	private BigDecimal	r42_6_12_months;
	private BigDecimal	r42_1_2_years;
	private BigDecimal	r42_2_3_years;
	private BigDecimal	r42_3_4_years;
	private BigDecimal	r42_4_5_years;
	private BigDecimal	r42_5_years;
	private BigDecimal	r42_non_interest;
	private BigDecimal	r42_total;
	private String	r43_product;
	private BigDecimal	r43_overdraft;
	private BigDecimal	r43_0_7_days;
	private BigDecimal	r43_8_14_days;
	private BigDecimal	r43_15_days_1_month;
	private BigDecimal	r43_1_3_months;
	private BigDecimal	r43_3_6_months;
	private BigDecimal	r43_6_12_months;
	private BigDecimal	r43_1_2_years;
	private BigDecimal	r43_2_3_years;
	private BigDecimal	r43_3_4_years;
	private BigDecimal	r43_4_5_years;
	private BigDecimal	r43_5_years;
	private BigDecimal	r43_non_interest;
	private BigDecimal	r43_total;
	private String	rh8_product;
	private BigDecimal	rh8_overdraft;
	private BigDecimal	rh8_0_7_days;
	private BigDecimal	rh8_8_14_days;
	private BigDecimal	rh8_15_days_1_month;
	private BigDecimal	rh8_1_3_months;
	private BigDecimal	rh8_3_6_months;
	private BigDecimal	rh8_6_12_months;
	private BigDecimal	rh8_1_2_years;
	private BigDecimal	rh8_2_3_years;
	private BigDecimal	rh8_3_4_years;
	private BigDecimal	rh8_4_5_years;
	private BigDecimal	rh8_5_years;
	private BigDecimal	rh8_non_interest;
	private BigDecimal	rh8_total;
	private String	r44_product;
	private BigDecimal	r44_overdraft;
	private BigDecimal	r44_0_7_days;
	private BigDecimal	r44_8_14_days;
	private BigDecimal	r44_15_days_1_month;
	private BigDecimal	r44_1_3_months;
	private BigDecimal	r44_3_6_months;
	private BigDecimal	r44_6_12_months;
	private BigDecimal	r44_1_2_years;
	private BigDecimal	r44_2_3_years;
	private BigDecimal	r44_3_4_years;
	private BigDecimal	r44_4_5_years;
	private BigDecimal	r44_5_years;
	private BigDecimal	r44_non_interest;
	private BigDecimal	r44_total;
	private String	r45_product;
	private BigDecimal	r45_overdraft;
	private BigDecimal	r45_0_7_days;
	private BigDecimal	r45_8_14_days;
	private BigDecimal	r45_15_days_1_month;
	private BigDecimal	r45_1_3_months;
	private BigDecimal	r45_3_6_months;
	private BigDecimal	r45_6_12_months;
	private BigDecimal	r45_1_2_years;
	private BigDecimal	r45_2_3_years;
	private BigDecimal	r45_3_4_years;
	private BigDecimal	r45_4_5_years;
	private BigDecimal	r45_5_years;
	private BigDecimal	r45_non_interest;
	private BigDecimal	r45_total;
	private String	r46_product;
	private BigDecimal	r46_overdraft;
	private BigDecimal	r46_0_7_days;
	private BigDecimal	r46_8_14_days;
	private BigDecimal	r46_15_days_1_month;
	private BigDecimal	r46_1_3_months;
	private BigDecimal	r46_3_6_months;
	private BigDecimal	r46_6_12_months;
	private BigDecimal	r46_1_2_years;
	private BigDecimal	r46_2_3_years;
	private BigDecimal	r46_3_4_years;
	private BigDecimal	r46_4_5_years;
	private BigDecimal	r46_5_years;
	private BigDecimal	r46_non_interest;
	private BigDecimal	r46_total;
	private String	r47_product;
	private BigDecimal	r47_overdraft;
	private BigDecimal	r47_0_7_days;
	private BigDecimal	r47_8_14_days;
	private BigDecimal	r47_15_days_1_month;
	private BigDecimal	r47_1_3_months;
	private BigDecimal	r47_3_6_months;
	private BigDecimal	r47_6_12_months;
	private BigDecimal	r47_1_2_years;
	private BigDecimal	r47_2_3_years;
	private BigDecimal	r47_3_4_years;
	private BigDecimal	r47_4_5_years;
	private BigDecimal	r47_5_years;
	private BigDecimal	r47_non_interest;
	private BigDecimal	r47_total;
	private String	rtle_product;
	private BigDecimal	rtle_overdraft;
	private BigDecimal	rtle_0_7_days;
	private BigDecimal	rtle_8_14_days;
	private BigDecimal	rtle_15_days_1_month;
	private BigDecimal	rtle_1_3_months;
	private BigDecimal	rtle_3_6_months;
	private BigDecimal	rtle_6_12_months;
	private BigDecimal	rtle_1_2_years;
	private BigDecimal	rtle_2_3_years;
	private BigDecimal	rtle_3_4_years;
	private BigDecimal	rtle_4_5_years;
	private BigDecimal	rtle_5_years;
	private BigDecimal	rtle_non_interest;
	private BigDecimal	rtle_total;
	private String	r48_product;
	private BigDecimal	r48_overdraft;
	private BigDecimal	r48_0_7_days;
	private BigDecimal	r48_8_14_days;
	private BigDecimal	r48_15_days_1_month;
	private BigDecimal	r48_1_3_months;
	private BigDecimal	r48_3_6_months;
	private BigDecimal	r48_6_12_months;
	private BigDecimal	r48_1_2_years;
	private BigDecimal	r48_2_3_years;
	private BigDecimal	r48_3_4_years;
	private BigDecimal	r48_4_5_years;
	private BigDecimal	r48_5_years;
	private BigDecimal	r48_non_interest;
	private BigDecimal	r48_total;
	private String	r49_product;
	private BigDecimal	r49_overdraft;
	private BigDecimal	r49_0_7_days;
	private BigDecimal	r49_8_14_days;
	private BigDecimal	r49_15_days_1_month;
	private BigDecimal	r49_1_3_months;
	private BigDecimal	r49_3_6_months;
	private BigDecimal	r49_6_12_months;
	private BigDecimal	r49_1_2_years;
	private BigDecimal	r49_2_3_years;
	private BigDecimal	r49_3_4_years;
	private BigDecimal	r49_4_5_years;
	private BigDecimal	r49_5_years;
	private BigDecimal	r49_non_interest;
	private BigDecimal	r49_total;
	private String	r50_product;
	private BigDecimal	r50_overdraft;
	private BigDecimal	r50_0_7_days;
	private BigDecimal	r50_8_14_days;
	private BigDecimal	r50_15_days_1_month;
	private BigDecimal	r50_1_3_months;
	private BigDecimal	r50_3_6_months;
	private BigDecimal	r50_6_12_months;
	private BigDecimal	r50_1_2_years;
	private BigDecimal	r50_2_3_years;
	private BigDecimal	r50_3_4_years;
	private BigDecimal	r50_4_5_years;
	private BigDecimal	r50_5_years;
	private BigDecimal	r50_non_interest;
	private BigDecimal	r50_total;
	private String	rtob_product;
	private BigDecimal	rtob_overdraft;
	private BigDecimal	rtob_0_7_days;
	private BigDecimal	rtob_8_14_days;
	private BigDecimal	rtob_15_days_1_month;
	private BigDecimal	rtob_1_3_months;
	private BigDecimal	rtob_3_6_months;
	private BigDecimal	rtob_6_12_months;
	private BigDecimal	rtob_1_2_years;
	private BigDecimal	rtob_2_3_years;
	private BigDecimal	rtob_3_4_years;
	private BigDecimal	rtob_4_5_years;
	private BigDecimal	rtob_5_years;
	private BigDecimal	rtob_non_interest;
	private BigDecimal	rtob_total;
	private String	rnrm_product;
	private BigDecimal	rnrm_overdraft;
	private BigDecimal	rnrm_0_7_days;
	private BigDecimal	rnrm_8_14_days;
	private BigDecimal	rnrm_15_days_1_month;
	private BigDecimal	rnrm_1_3_months;
	private BigDecimal	rnrm_3_6_months;
	private BigDecimal	rnrm_6_12_months;
	private BigDecimal	rnrm_1_2_years;
	private BigDecimal	rnrm_2_3_years;
	private BigDecimal	rnrm_3_4_years;
	private BigDecimal	rnrm_4_5_years;
	private BigDecimal	rnrm_5_years;
	private BigDecimal	rnrm_non_interest;
	private BigDecimal	rnrm_total;
	
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
	public String getRh_product() {
		return rh_product;
	}
	public void setRh_product(String rh_product) {
		this.rh_product = rh_product;
	}
	public BigDecimal getRh_overdraft() {
		return rh_overdraft;
	}
	public void setRh_overdraft(BigDecimal rh_overdraft) {
		this.rh_overdraft = rh_overdraft;
	}
	public BigDecimal getRh_0_7_days() {
		return rh_0_7_days;
	}
	public void setRh_0_7_days(BigDecimal rh_0_7_days) {
		this.rh_0_7_days = rh_0_7_days;
	}
	public BigDecimal getRh_8_14_days() {
		return rh_8_14_days;
	}
	public void setRh_8_14_days(BigDecimal rh_8_14_days) {
		this.rh_8_14_days = rh_8_14_days;
	}
	public BigDecimal getRh_15_days_1_month() {
		return rh_15_days_1_month;
	}
	public void setRh_15_days_1_month(BigDecimal rh_15_days_1_month) {
		this.rh_15_days_1_month = rh_15_days_1_month;
	}
	public BigDecimal getRh_1_3_months() {
		return rh_1_3_months;
	}
	public void setRh_1_3_months(BigDecimal rh_1_3_months) {
		this.rh_1_3_months = rh_1_3_months;
	}
	public BigDecimal getRh_3_6_months() {
		return rh_3_6_months;
	}
	public void setRh_3_6_months(BigDecimal rh_3_6_months) {
		this.rh_3_6_months = rh_3_6_months;
	}
	public BigDecimal getRh_6_12_months() {
		return rh_6_12_months;
	}
	public void setRh_6_12_months(BigDecimal rh_6_12_months) {
		this.rh_6_12_months = rh_6_12_months;
	}
	public BigDecimal getRh_1_2_years() {
		return rh_1_2_years;
	}
	public void setRh_1_2_years(BigDecimal rh_1_2_years) {
		this.rh_1_2_years = rh_1_2_years;
	}
	public BigDecimal getRh_2_3_years() {
		return rh_2_3_years;
	}
	public void setRh_2_3_years(BigDecimal rh_2_3_years) {
		this.rh_2_3_years = rh_2_3_years;
	}
	public BigDecimal getRh_3_4_years() {
		return rh_3_4_years;
	}
	public void setRh_3_4_years(BigDecimal rh_3_4_years) {
		this.rh_3_4_years = rh_3_4_years;
	}
	public BigDecimal getRh_4_5_years() {
		return rh_4_5_years;
	}
	public void setRh_4_5_years(BigDecimal rh_4_5_years) {
		this.rh_4_5_years = rh_4_5_years;
	}
	public BigDecimal getRh_5_years() {
		return rh_5_years;
	}
	public void setRh_5_years(BigDecimal rh_5_years) {
		this.rh_5_years = rh_5_years;
	}
	public BigDecimal getRh_non_interest() {
		return rh_non_interest;
	}
	public void setRh_non_interest(BigDecimal rh_non_interest) {
		this.rh_non_interest = rh_non_interest;
	}
	public BigDecimal getRh_total() {
		return rh_total;
	}
	public void setRh_total(BigDecimal rh_total) {
		this.rh_total = rh_total;
	}
	public String getR1_product() {
		return r1_product;
	}
	public void setR1_product(String r1_product) {
		this.r1_product = r1_product;
	}
	public BigDecimal getR1_overdraft() {
		return r1_overdraft;
	}
	public void setR1_overdraft(BigDecimal r1_overdraft) {
		this.r1_overdraft = r1_overdraft;
	}
	public BigDecimal getR1_0_7_days() {
		return r1_0_7_days;
	}
	public void setR1_0_7_days(BigDecimal r1_0_7_days) {
		this.r1_0_7_days = r1_0_7_days;
	}
	public BigDecimal getR1_8_14_days() {
		return r1_8_14_days;
	}
	public void setR1_8_14_days(BigDecimal r1_8_14_days) {
		this.r1_8_14_days = r1_8_14_days;
	}
	public BigDecimal getR1_15_days_1_month() {
		return r1_15_days_1_month;
	}
	public void setR1_15_days_1_month(BigDecimal r1_15_days_1_month) {
		this.r1_15_days_1_month = r1_15_days_1_month;
	}
	public BigDecimal getR1_1_3_months() {
		return r1_1_3_months;
	}
	public void setR1_1_3_months(BigDecimal r1_1_3_months) {
		this.r1_1_3_months = r1_1_3_months;
	}
	public BigDecimal getR1_3_6_months() {
		return r1_3_6_months;
	}
	public void setR1_3_6_months(BigDecimal r1_3_6_months) {
		this.r1_3_6_months = r1_3_6_months;
	}
	public BigDecimal getR1_6_12_months() {
		return r1_6_12_months;
	}
	public void setR1_6_12_months(BigDecimal r1_6_12_months) {
		this.r1_6_12_months = r1_6_12_months;
	}
	public BigDecimal getR1_1_2_years() {
		return r1_1_2_years;
	}
	public void setR1_1_2_years(BigDecimal r1_1_2_years) {
		this.r1_1_2_years = r1_1_2_years;
	}
	public BigDecimal getR1_2_3_years() {
		return r1_2_3_years;
	}
	public void setR1_2_3_years(BigDecimal r1_2_3_years) {
		this.r1_2_3_years = r1_2_3_years;
	}
	public BigDecimal getR1_3_4_years() {
		return r1_3_4_years;
	}
	public void setR1_3_4_years(BigDecimal r1_3_4_years) {
		this.r1_3_4_years = r1_3_4_years;
	}
	public BigDecimal getR1_4_5_years() {
		return r1_4_5_years;
	}
	public void setR1_4_5_years(BigDecimal r1_4_5_years) {
		this.r1_4_5_years = r1_4_5_years;
	}
	public BigDecimal getR1_5_years() {
		return r1_5_years;
	}
	public void setR1_5_years(BigDecimal r1_5_years) {
		this.r1_5_years = r1_5_years;
	}
	public BigDecimal getR1_non_interest() {
		return r1_non_interest;
	}
	public void setR1_non_interest(BigDecimal r1_non_interest) {
		this.r1_non_interest = r1_non_interest;
	}
	public BigDecimal getR1_total() {
		return r1_total;
	}
	public void setR1_total(BigDecimal r1_total) {
		this.r1_total = r1_total;
	}
	public String getR2_product() {
		return r2_product;
	}
	public void setR2_product(String r2_product) {
		this.r2_product = r2_product;
	}
	public BigDecimal getR2_overdraft() {
		return r2_overdraft;
	}
	public void setR2_overdraft(BigDecimal r2_overdraft) {
		this.r2_overdraft = r2_overdraft;
	}
	public BigDecimal getR2_0_7_days() {
		return r2_0_7_days;
	}
	public void setR2_0_7_days(BigDecimal r2_0_7_days) {
		this.r2_0_7_days = r2_0_7_days;
	}
	public BigDecimal getR2_8_14_days() {
		return r2_8_14_days;
	}
	public void setR2_8_14_days(BigDecimal r2_8_14_days) {
		this.r2_8_14_days = r2_8_14_days;
	}
	public BigDecimal getR2_15_days_1_month() {
		return r2_15_days_1_month;
	}
	public void setR2_15_days_1_month(BigDecimal r2_15_days_1_month) {
		this.r2_15_days_1_month = r2_15_days_1_month;
	}
	public BigDecimal getR2_1_3_months() {
		return r2_1_3_months;
	}
	public void setR2_1_3_months(BigDecimal r2_1_3_months) {
		this.r2_1_3_months = r2_1_3_months;
	}
	public BigDecimal getR2_3_6_months() {
		return r2_3_6_months;
	}
	public void setR2_3_6_months(BigDecimal r2_3_6_months) {
		this.r2_3_6_months = r2_3_6_months;
	}
	public BigDecimal getR2_6_12_months() {
		return r2_6_12_months;
	}
	public void setR2_6_12_months(BigDecimal r2_6_12_months) {
		this.r2_6_12_months = r2_6_12_months;
	}
	public BigDecimal getR2_1_2_years() {
		return r2_1_2_years;
	}
	public void setR2_1_2_years(BigDecimal r2_1_2_years) {
		this.r2_1_2_years = r2_1_2_years;
	}
	public BigDecimal getR2_2_3_years() {
		return r2_2_3_years;
	}
	public void setR2_2_3_years(BigDecimal r2_2_3_years) {
		this.r2_2_3_years = r2_2_3_years;
	}
	public BigDecimal getR2_3_4_years() {
		return r2_3_4_years;
	}
	public void setR2_3_4_years(BigDecimal r2_3_4_years) {
		this.r2_3_4_years = r2_3_4_years;
	}
	public BigDecimal getR2_4_5_years() {
		return r2_4_5_years;
	}
	public void setR2_4_5_years(BigDecimal r2_4_5_years) {
		this.r2_4_5_years = r2_4_5_years;
	}
	public BigDecimal getR2_5_years() {
		return r2_5_years;
	}
	public void setR2_5_years(BigDecimal r2_5_years) {
		this.r2_5_years = r2_5_years;
	}
	public BigDecimal getR2_non_interest() {
		return r2_non_interest;
	}
	public void setR2_non_interest(BigDecimal r2_non_interest) {
		this.r2_non_interest = r2_non_interest;
	}
	public BigDecimal getR2_total() {
		return r2_total;
	}
	public void setR2_total(BigDecimal r2_total) {
		this.r2_total = r2_total;
	}
	public String getR3_product() {
		return r3_product;
	}
	public void setR3_product(String r3_product) {
		this.r3_product = r3_product;
	}
	public BigDecimal getR3_overdraft() {
		return r3_overdraft;
	}
	public void setR3_overdraft(BigDecimal r3_overdraft) {
		this.r3_overdraft = r3_overdraft;
	}
	public BigDecimal getR3_0_7_days() {
		return r3_0_7_days;
	}
	public void setR3_0_7_days(BigDecimal r3_0_7_days) {
		this.r3_0_7_days = r3_0_7_days;
	}
	public BigDecimal getR3_8_14_days() {
		return r3_8_14_days;
	}
	public void setR3_8_14_days(BigDecimal r3_8_14_days) {
		this.r3_8_14_days = r3_8_14_days;
	}
	public BigDecimal getR3_15_days_1_month() {
		return r3_15_days_1_month;
	}
	public void setR3_15_days_1_month(BigDecimal r3_15_days_1_month) {
		this.r3_15_days_1_month = r3_15_days_1_month;
	}
	public BigDecimal getR3_1_3_months() {
		return r3_1_3_months;
	}
	public void setR3_1_3_months(BigDecimal r3_1_3_months) {
		this.r3_1_3_months = r3_1_3_months;
	}
	public BigDecimal getR3_3_6_months() {
		return r3_3_6_months;
	}
	public void setR3_3_6_months(BigDecimal r3_3_6_months) {
		this.r3_3_6_months = r3_3_6_months;
	}
	public BigDecimal getR3_6_12_months() {
		return r3_6_12_months;
	}
	public void setR3_6_12_months(BigDecimal r3_6_12_months) {
		this.r3_6_12_months = r3_6_12_months;
	}
	public BigDecimal getR3_1_2_years() {
		return r3_1_2_years;
	}
	public void setR3_1_2_years(BigDecimal r3_1_2_years) {
		this.r3_1_2_years = r3_1_2_years;
	}
	public BigDecimal getR3_2_3_years() {
		return r3_2_3_years;
	}
	public void setR3_2_3_years(BigDecimal r3_2_3_years) {
		this.r3_2_3_years = r3_2_3_years;
	}
	public BigDecimal getR3_3_4_years() {
		return r3_3_4_years;
	}
	public void setR3_3_4_years(BigDecimal r3_3_4_years) {
		this.r3_3_4_years = r3_3_4_years;
	}
	public BigDecimal getR3_4_5_years() {
		return r3_4_5_years;
	}
	public void setR3_4_5_years(BigDecimal r3_4_5_years) {
		this.r3_4_5_years = r3_4_5_years;
	}
	public BigDecimal getR3_5_years() {
		return r3_5_years;
	}
	public void setR3_5_years(BigDecimal r3_5_years) {
		this.r3_5_years = r3_5_years;
	}
	public BigDecimal getR3_non_interest() {
		return r3_non_interest;
	}
	public void setR3_non_interest(BigDecimal r3_non_interest) {
		this.r3_non_interest = r3_non_interest;
	}
	public BigDecimal getR3_total() {
		return r3_total;
	}
	public void setR3_total(BigDecimal r3_total) {
		this.r3_total = r3_total;
	}
	public String getRh2_product() {
		return rh2_product;
	}
	public void setRh2_product(String rh2_product) {
		this.rh2_product = rh2_product;
	}
	public BigDecimal getRh2_overdraft() {
		return rh2_overdraft;
	}
	public void setRh2_overdraft(BigDecimal rh2_overdraft) {
		this.rh2_overdraft = rh2_overdraft;
	}
	public BigDecimal getRh2_0_7_days() {
		return rh2_0_7_days;
	}
	public void setRh2_0_7_days(BigDecimal rh2_0_7_days) {
		this.rh2_0_7_days = rh2_0_7_days;
	}
	public BigDecimal getRh2_8_14_days() {
		return rh2_8_14_days;
	}
	public void setRh2_8_14_days(BigDecimal rh2_8_14_days) {
		this.rh2_8_14_days = rh2_8_14_days;
	}
	public BigDecimal getRh2_15_days_1_month() {
		return rh2_15_days_1_month;
	}
	public void setRh2_15_days_1_month(BigDecimal rh2_15_days_1_month) {
		this.rh2_15_days_1_month = rh2_15_days_1_month;
	}
	public BigDecimal getRh2_1_3_months() {
		return rh2_1_3_months;
	}
	public void setRh2_1_3_months(BigDecimal rh2_1_3_months) {
		this.rh2_1_3_months = rh2_1_3_months;
	}
	public BigDecimal getRh2_3_6_months() {
		return rh2_3_6_months;
	}
	public void setRh2_3_6_months(BigDecimal rh2_3_6_months) {
		this.rh2_3_6_months = rh2_3_6_months;
	}
	public BigDecimal getRh2_6_12_months() {
		return rh2_6_12_months;
	}
	public void setRh2_6_12_months(BigDecimal rh2_6_12_months) {
		this.rh2_6_12_months = rh2_6_12_months;
	}
	public BigDecimal getRh2_1_2_years() {
		return rh2_1_2_years;
	}
	public void setRh2_1_2_years(BigDecimal rh2_1_2_years) {
		this.rh2_1_2_years = rh2_1_2_years;
	}
	public BigDecimal getRh2_2_3_years() {
		return rh2_2_3_years;
	}
	public void setRh2_2_3_years(BigDecimal rh2_2_3_years) {
		this.rh2_2_3_years = rh2_2_3_years;
	}
	public BigDecimal getRh2_3_4_years() {
		return rh2_3_4_years;
	}
	public void setRh2_3_4_years(BigDecimal rh2_3_4_years) {
		this.rh2_3_4_years = rh2_3_4_years;
	}
	public BigDecimal getRh2_4_5_years() {
		return rh2_4_5_years;
	}
	public void setRh2_4_5_years(BigDecimal rh2_4_5_years) {
		this.rh2_4_5_years = rh2_4_5_years;
	}
	public BigDecimal getRh2_5_years() {
		return rh2_5_years;
	}
	public void setRh2_5_years(BigDecimal rh2_5_years) {
		this.rh2_5_years = rh2_5_years;
	}
	public BigDecimal getRh2_non_interest() {
		return rh2_non_interest;
	}
	public void setRh2_non_interest(BigDecimal rh2_non_interest) {
		this.rh2_non_interest = rh2_non_interest;
	}
	public BigDecimal getRh2_total() {
		return rh2_total;
	}
	public void setRh2_total(BigDecimal rh2_total) {
		this.rh2_total = rh2_total;
	}
	public String getR4_product() {
		return r4_product;
	}
	public void setR4_product(String r4_product) {
		this.r4_product = r4_product;
	}
	public BigDecimal getR4_overdraft() {
		return r4_overdraft;
	}
	public void setR4_overdraft(BigDecimal r4_overdraft) {
		this.r4_overdraft = r4_overdraft;
	}
	public BigDecimal getR4_0_7_days() {
		return r4_0_7_days;
	}
	public void setR4_0_7_days(BigDecimal r4_0_7_days) {
		this.r4_0_7_days = r4_0_7_days;
	}
	public BigDecimal getR4_8_14_days() {
		return r4_8_14_days;
	}
	public void setR4_8_14_days(BigDecimal r4_8_14_days) {
		this.r4_8_14_days = r4_8_14_days;
	}
	public BigDecimal getR4_15_days_1_month() {
		return r4_15_days_1_month;
	}
	public void setR4_15_days_1_month(BigDecimal r4_15_days_1_month) {
		this.r4_15_days_1_month = r4_15_days_1_month;
	}
	public BigDecimal getR4_1_3_months() {
		return r4_1_3_months;
	}
	public void setR4_1_3_months(BigDecimal r4_1_3_months) {
		this.r4_1_3_months = r4_1_3_months;
	}
	public BigDecimal getR4_3_6_months() {
		return r4_3_6_months;
	}
	public void setR4_3_6_months(BigDecimal r4_3_6_months) {
		this.r4_3_6_months = r4_3_6_months;
	}
	public BigDecimal getR4_6_12_months() {
		return r4_6_12_months;
	}
	public void setR4_6_12_months(BigDecimal r4_6_12_months) {
		this.r4_6_12_months = r4_6_12_months;
	}
	public BigDecimal getR4_1_2_years() {
		return r4_1_2_years;
	}
	public void setR4_1_2_years(BigDecimal r4_1_2_years) {
		this.r4_1_2_years = r4_1_2_years;
	}
	public BigDecimal getR4_2_3_years() {
		return r4_2_3_years;
	}
	public void setR4_2_3_years(BigDecimal r4_2_3_years) {
		this.r4_2_3_years = r4_2_3_years;
	}
	public BigDecimal getR4_3_4_years() {
		return r4_3_4_years;
	}
	public void setR4_3_4_years(BigDecimal r4_3_4_years) {
		this.r4_3_4_years = r4_3_4_years;
	}
	public BigDecimal getR4_4_5_years() {
		return r4_4_5_years;
	}
	public void setR4_4_5_years(BigDecimal r4_4_5_years) {
		this.r4_4_5_years = r4_4_5_years;
	}
	public BigDecimal getR4_5_years() {
		return r4_5_years;
	}
	public void setR4_5_years(BigDecimal r4_5_years) {
		this.r4_5_years = r4_5_years;
	}
	public BigDecimal getR4_non_interest() {
		return r4_non_interest;
	}
	public void setR4_non_interest(BigDecimal r4_non_interest) {
		this.r4_non_interest = r4_non_interest;
	}
	public BigDecimal getR4_total() {
		return r4_total;
	}
	public void setR4_total(BigDecimal r4_total) {
		this.r4_total = r4_total;
	}
	public String getR5_product() {
		return r5_product;
	}
	public void setR5_product(String r5_product) {
		this.r5_product = r5_product;
	}
	public BigDecimal getR5_overdraft() {
		return r5_overdraft;
	}
	public void setR5_overdraft(BigDecimal r5_overdraft) {
		this.r5_overdraft = r5_overdraft;
	}
	public BigDecimal getR5_0_7_days() {
		return r5_0_7_days;
	}
	public void setR5_0_7_days(BigDecimal r5_0_7_days) {
		this.r5_0_7_days = r5_0_7_days;
	}
	public BigDecimal getR5_8_14_days() {
		return r5_8_14_days;
	}
	public void setR5_8_14_days(BigDecimal r5_8_14_days) {
		this.r5_8_14_days = r5_8_14_days;
	}
	public BigDecimal getR5_15_days_1_month() {
		return r5_15_days_1_month;
	}
	public void setR5_15_days_1_month(BigDecimal r5_15_days_1_month) {
		this.r5_15_days_1_month = r5_15_days_1_month;
	}
	public BigDecimal getR5_1_3_months() {
		return r5_1_3_months;
	}
	public void setR5_1_3_months(BigDecimal r5_1_3_months) {
		this.r5_1_3_months = r5_1_3_months;
	}
	public BigDecimal getR5_3_6_months() {
		return r5_3_6_months;
	}
	public void setR5_3_6_months(BigDecimal r5_3_6_months) {
		this.r5_3_6_months = r5_3_6_months;
	}
	public BigDecimal getR5_6_12_months() {
		return r5_6_12_months;
	}
	public void setR5_6_12_months(BigDecimal r5_6_12_months) {
		this.r5_6_12_months = r5_6_12_months;
	}
	public BigDecimal getR5_1_2_years() {
		return r5_1_2_years;
	}
	public void setR5_1_2_years(BigDecimal r5_1_2_years) {
		this.r5_1_2_years = r5_1_2_years;
	}
	public BigDecimal getR5_2_3_years() {
		return r5_2_3_years;
	}
	public void setR5_2_3_years(BigDecimal r5_2_3_years) {
		this.r5_2_3_years = r5_2_3_years;
	}
	public BigDecimal getR5_3_4_years() {
		return r5_3_4_years;
	}
	public void setR5_3_4_years(BigDecimal r5_3_4_years) {
		this.r5_3_4_years = r5_3_4_years;
	}
	public BigDecimal getR5_4_5_years() {
		return r5_4_5_years;
	}
	public void setR5_4_5_years(BigDecimal r5_4_5_years) {
		this.r5_4_5_years = r5_4_5_years;
	}
	public BigDecimal getR5_5_years() {
		return r5_5_years;
	}
	public void setR5_5_years(BigDecimal r5_5_years) {
		this.r5_5_years = r5_5_years;
	}
	public BigDecimal getR5_non_interest() {
		return r5_non_interest;
	}
	public void setR5_non_interest(BigDecimal r5_non_interest) {
		this.r5_non_interest = r5_non_interest;
	}
	public BigDecimal getR5_total() {
		return r5_total;
	}
	public void setR5_total(BigDecimal r5_total) {
		this.r5_total = r5_total;
	}
	public String getR6_product() {
		return r6_product;
	}
	public void setR6_product(String r6_product) {
		this.r6_product = r6_product;
	}
	public BigDecimal getR6_overdraft() {
		return r6_overdraft;
	}
	public void setR6_overdraft(BigDecimal r6_overdraft) {
		this.r6_overdraft = r6_overdraft;
	}
	public BigDecimal getR6_0_7_days() {
		return r6_0_7_days;
	}
	public void setR6_0_7_days(BigDecimal r6_0_7_days) {
		this.r6_0_7_days = r6_0_7_days;
	}
	public BigDecimal getR6_8_14_days() {
		return r6_8_14_days;
	}
	public void setR6_8_14_days(BigDecimal r6_8_14_days) {
		this.r6_8_14_days = r6_8_14_days;
	}
	public BigDecimal getR6_15_days_1_month() {
		return r6_15_days_1_month;
	}
	public void setR6_15_days_1_month(BigDecimal r6_15_days_1_month) {
		this.r6_15_days_1_month = r6_15_days_1_month;
	}
	public BigDecimal getR6_1_3_months() {
		return r6_1_3_months;
	}
	public void setR6_1_3_months(BigDecimal r6_1_3_months) {
		this.r6_1_3_months = r6_1_3_months;
	}
	public BigDecimal getR6_3_6_months() {
		return r6_3_6_months;
	}
	public void setR6_3_6_months(BigDecimal r6_3_6_months) {
		this.r6_3_6_months = r6_3_6_months;
	}
	public BigDecimal getR6_6_12_months() {
		return r6_6_12_months;
	}
	public void setR6_6_12_months(BigDecimal r6_6_12_months) {
		this.r6_6_12_months = r6_6_12_months;
	}
	public BigDecimal getR6_1_2_years() {
		return r6_1_2_years;
	}
	public void setR6_1_2_years(BigDecimal r6_1_2_years) {
		this.r6_1_2_years = r6_1_2_years;
	}
	public BigDecimal getR6_2_3_years() {
		return r6_2_3_years;
	}
	public void setR6_2_3_years(BigDecimal r6_2_3_years) {
		this.r6_2_3_years = r6_2_3_years;
	}
	public BigDecimal getR6_3_4_years() {
		return r6_3_4_years;
	}
	public void setR6_3_4_years(BigDecimal r6_3_4_years) {
		this.r6_3_4_years = r6_3_4_years;
	}
	public BigDecimal getR6_4_5_years() {
		return r6_4_5_years;
	}
	public void setR6_4_5_years(BigDecimal r6_4_5_years) {
		this.r6_4_5_years = r6_4_5_years;
	}
	public BigDecimal getR6_5_years() {
		return r6_5_years;
	}
	public void setR6_5_years(BigDecimal r6_5_years) {
		this.r6_5_years = r6_5_years;
	}
	public BigDecimal getR6_non_interest() {
		return r6_non_interest;
	}
	public void setR6_non_interest(BigDecimal r6_non_interest) {
		this.r6_non_interest = r6_non_interest;
	}
	public BigDecimal getR6_total() {
		return r6_total;
	}
	public void setR6_total(BigDecimal r6_total) {
		this.r6_total = r6_total;
	}
	public String getRh3_product() {
		return rh3_product;
	}
	public void setRh3_product(String rh3_product) {
		this.rh3_product = rh3_product;
	}
	public BigDecimal getRh3_overdraft() {
		return rh3_overdraft;
	}
	public void setRh3_overdraft(BigDecimal rh3_overdraft) {
		this.rh3_overdraft = rh3_overdraft;
	}
	public BigDecimal getRh3_0_7_days() {
		return rh3_0_7_days;
	}
	public void setRh3_0_7_days(BigDecimal rh3_0_7_days) {
		this.rh3_0_7_days = rh3_0_7_days;
	}
	public BigDecimal getRh3_8_14_days() {
		return rh3_8_14_days;
	}
	public void setRh3_8_14_days(BigDecimal rh3_8_14_days) {
		this.rh3_8_14_days = rh3_8_14_days;
	}
	public BigDecimal getRh3_15_days_1_month() {
		return rh3_15_days_1_month;
	}
	public void setRh3_15_days_1_month(BigDecimal rh3_15_days_1_month) {
		this.rh3_15_days_1_month = rh3_15_days_1_month;
	}
	public BigDecimal getRh3_1_3_months() {
		return rh3_1_3_months;
	}
	public void setRh3_1_3_months(BigDecimal rh3_1_3_months) {
		this.rh3_1_3_months = rh3_1_3_months;
	}
	public BigDecimal getRh3_3_6_months() {
		return rh3_3_6_months;
	}
	public void setRh3_3_6_months(BigDecimal rh3_3_6_months) {
		this.rh3_3_6_months = rh3_3_6_months;
	}
	public BigDecimal getRh3_6_12_months() {
		return rh3_6_12_months;
	}
	public void setRh3_6_12_months(BigDecimal rh3_6_12_months) {
		this.rh3_6_12_months = rh3_6_12_months;
	}
	public BigDecimal getRh3_1_2_years() {
		return rh3_1_2_years;
	}
	public void setRh3_1_2_years(BigDecimal rh3_1_2_years) {
		this.rh3_1_2_years = rh3_1_2_years;
	}
	public BigDecimal getRh3_2_3_years() {
		return rh3_2_3_years;
	}
	public void setRh3_2_3_years(BigDecimal rh3_2_3_years) {
		this.rh3_2_3_years = rh3_2_3_years;
	}
	public BigDecimal getRh3_3_4_years() {
		return rh3_3_4_years;
	}
	public void setRh3_3_4_years(BigDecimal rh3_3_4_years) {
		this.rh3_3_4_years = rh3_3_4_years;
	}
	public BigDecimal getRh3_4_5_years() {
		return rh3_4_5_years;
	}
	public void setRh3_4_5_years(BigDecimal rh3_4_5_years) {
		this.rh3_4_5_years = rh3_4_5_years;
	}
	public BigDecimal getRh3_5_years() {
		return rh3_5_years;
	}
	public void setRh3_5_years(BigDecimal rh3_5_years) {
		this.rh3_5_years = rh3_5_years;
	}
	public BigDecimal getRh3_non_interest() {
		return rh3_non_interest;
	}
	public void setRh3_non_interest(BigDecimal rh3_non_interest) {
		this.rh3_non_interest = rh3_non_interest;
	}
	public BigDecimal getRh3_total() {
		return rh3_total;
	}
	public void setRh3_total(BigDecimal rh3_total) {
		this.rh3_total = rh3_total;
	}
	public String getR7_product() {
		return r7_product;
	}
	public void setR7_product(String r7_product) {
		this.r7_product = r7_product;
	}
	public BigDecimal getR7_overdraft() {
		return r7_overdraft;
	}
	public void setR7_overdraft(BigDecimal r7_overdraft) {
		this.r7_overdraft = r7_overdraft;
	}
	public BigDecimal getR7_0_7_days() {
		return r7_0_7_days;
	}
	public void setR7_0_7_days(BigDecimal r7_0_7_days) {
		this.r7_0_7_days = r7_0_7_days;
	}
	public BigDecimal getR7_8_14_days() {
		return r7_8_14_days;
	}
	public void setR7_8_14_days(BigDecimal r7_8_14_days) {
		this.r7_8_14_days = r7_8_14_days;
	}
	public BigDecimal getR7_15_days_1_month() {
		return r7_15_days_1_month;
	}
	public void setR7_15_days_1_month(BigDecimal r7_15_days_1_month) {
		this.r7_15_days_1_month = r7_15_days_1_month;
	}
	public BigDecimal getR7_1_3_months() {
		return r7_1_3_months;
	}
	public void setR7_1_3_months(BigDecimal r7_1_3_months) {
		this.r7_1_3_months = r7_1_3_months;
	}
	public BigDecimal getR7_3_6_months() {
		return r7_3_6_months;
	}
	public void setR7_3_6_months(BigDecimal r7_3_6_months) {
		this.r7_3_6_months = r7_3_6_months;
	}
	public BigDecimal getR7_6_12_months() {
		return r7_6_12_months;
	}
	public void setR7_6_12_months(BigDecimal r7_6_12_months) {
		this.r7_6_12_months = r7_6_12_months;
	}
	public BigDecimal getR7_1_2_years() {
		return r7_1_2_years;
	}
	public void setR7_1_2_years(BigDecimal r7_1_2_years) {
		this.r7_1_2_years = r7_1_2_years;
	}
	public BigDecimal getR7_2_3_years() {
		return r7_2_3_years;
	}
	public void setR7_2_3_years(BigDecimal r7_2_3_years) {
		this.r7_2_3_years = r7_2_3_years;
	}
	public BigDecimal getR7_3_4_years() {
		return r7_3_4_years;
	}
	public void setR7_3_4_years(BigDecimal r7_3_4_years) {
		this.r7_3_4_years = r7_3_4_years;
	}
	public BigDecimal getR7_4_5_years() {
		return r7_4_5_years;
	}
	public void setR7_4_5_years(BigDecimal r7_4_5_years) {
		this.r7_4_5_years = r7_4_5_years;
	}
	public BigDecimal getR7_5_years() {
		return r7_5_years;
	}
	public void setR7_5_years(BigDecimal r7_5_years) {
		this.r7_5_years = r7_5_years;
	}
	public BigDecimal getR7_non_interest() {
		return r7_non_interest;
	}
	public void setR7_non_interest(BigDecimal r7_non_interest) {
		this.r7_non_interest = r7_non_interest;
	}
	public BigDecimal getR7_total() {
		return r7_total;
	}
	public void setR7_total(BigDecimal r7_total) {
		this.r7_total = r7_total;
	}
	public String getR8_product() {
		return r8_product;
	}
	public void setR8_product(String r8_product) {
		this.r8_product = r8_product;
	}
	public BigDecimal getR8_overdraft() {
		return r8_overdraft;
	}
	public void setR8_overdraft(BigDecimal r8_overdraft) {
		this.r8_overdraft = r8_overdraft;
	}
	public BigDecimal getR8_0_7_days() {
		return r8_0_7_days;
	}
	public void setR8_0_7_days(BigDecimal r8_0_7_days) {
		this.r8_0_7_days = r8_0_7_days;
	}
	public BigDecimal getR8_8_14_days() {
		return r8_8_14_days;
	}
	public void setR8_8_14_days(BigDecimal r8_8_14_days) {
		this.r8_8_14_days = r8_8_14_days;
	}
	public BigDecimal getR8_15_days_1_month() {
		return r8_15_days_1_month;
	}
	public void setR8_15_days_1_month(BigDecimal r8_15_days_1_month) {
		this.r8_15_days_1_month = r8_15_days_1_month;
	}
	public BigDecimal getR8_1_3_months() {
		return r8_1_3_months;
	}
	public void setR8_1_3_months(BigDecimal r8_1_3_months) {
		this.r8_1_3_months = r8_1_3_months;
	}
	public BigDecimal getR8_3_6_months() {
		return r8_3_6_months;
	}
	public void setR8_3_6_months(BigDecimal r8_3_6_months) {
		this.r8_3_6_months = r8_3_6_months;
	}
	public BigDecimal getR8_6_12_months() {
		return r8_6_12_months;
	}
	public void setR8_6_12_months(BigDecimal r8_6_12_months) {
		this.r8_6_12_months = r8_6_12_months;
	}
	public BigDecimal getR8_1_2_years() {
		return r8_1_2_years;
	}
	public void setR8_1_2_years(BigDecimal r8_1_2_years) {
		this.r8_1_2_years = r8_1_2_years;
	}
	public BigDecimal getR8_2_3_years() {
		return r8_2_3_years;
	}
	public void setR8_2_3_years(BigDecimal r8_2_3_years) {
		this.r8_2_3_years = r8_2_3_years;
	}
	public BigDecimal getR8_3_4_years() {
		return r8_3_4_years;
	}
	public void setR8_3_4_years(BigDecimal r8_3_4_years) {
		this.r8_3_4_years = r8_3_4_years;
	}
	public BigDecimal getR8_4_5_years() {
		return r8_4_5_years;
	}
	public void setR8_4_5_years(BigDecimal r8_4_5_years) {
		this.r8_4_5_years = r8_4_5_years;
	}
	public BigDecimal getR8_5_years() {
		return r8_5_years;
	}
	public void setR8_5_years(BigDecimal r8_5_years) {
		this.r8_5_years = r8_5_years;
	}
	public BigDecimal getR8_non_interest() {
		return r8_non_interest;
	}
	public void setR8_non_interest(BigDecimal r8_non_interest) {
		this.r8_non_interest = r8_non_interest;
	}
	public BigDecimal getR8_total() {
		return r8_total;
	}
	public void setR8_total(BigDecimal r8_total) {
		this.r8_total = r8_total;
	}
	public String getR9_product() {
		return r9_product;
	}
	public void setR9_product(String r9_product) {
		this.r9_product = r9_product;
	}
	public BigDecimal getR9_overdraft() {
		return r9_overdraft;
	}
	public void setR9_overdraft(BigDecimal r9_overdraft) {
		this.r9_overdraft = r9_overdraft;
	}
	public BigDecimal getR9_0_7_days() {
		return r9_0_7_days;
	}
	public void setR9_0_7_days(BigDecimal r9_0_7_days) {
		this.r9_0_7_days = r9_0_7_days;
	}
	public BigDecimal getR9_8_14_days() {
		return r9_8_14_days;
	}
	public void setR9_8_14_days(BigDecimal r9_8_14_days) {
		this.r9_8_14_days = r9_8_14_days;
	}
	public BigDecimal getR9_15_days_1_month() {
		return r9_15_days_1_month;
	}
	public void setR9_15_days_1_month(BigDecimal r9_15_days_1_month) {
		this.r9_15_days_1_month = r9_15_days_1_month;
	}
	public BigDecimal getR9_1_3_months() {
		return r9_1_3_months;
	}
	public void setR9_1_3_months(BigDecimal r9_1_3_months) {
		this.r9_1_3_months = r9_1_3_months;
	}
	public BigDecimal getR9_3_6_months() {
		return r9_3_6_months;
	}
	public void setR9_3_6_months(BigDecimal r9_3_6_months) {
		this.r9_3_6_months = r9_3_6_months;
	}
	public BigDecimal getR9_6_12_months() {
		return r9_6_12_months;
	}
	public void setR9_6_12_months(BigDecimal r9_6_12_months) {
		this.r9_6_12_months = r9_6_12_months;
	}
	public BigDecimal getR9_1_2_years() {
		return r9_1_2_years;
	}
	public void setR9_1_2_years(BigDecimal r9_1_2_years) {
		this.r9_1_2_years = r9_1_2_years;
	}
	public BigDecimal getR9_2_3_years() {
		return r9_2_3_years;
	}
	public void setR9_2_3_years(BigDecimal r9_2_3_years) {
		this.r9_2_3_years = r9_2_3_years;
	}
	public BigDecimal getR9_3_4_years() {
		return r9_3_4_years;
	}
	public void setR9_3_4_years(BigDecimal r9_3_4_years) {
		this.r9_3_4_years = r9_3_4_years;
	}
	public BigDecimal getR9_4_5_years() {
		return r9_4_5_years;
	}
	public void setR9_4_5_years(BigDecimal r9_4_5_years) {
		this.r9_4_5_years = r9_4_5_years;
	}
	public BigDecimal getR9_5_years() {
		return r9_5_years;
	}
	public void setR9_5_years(BigDecimal r9_5_years) {
		this.r9_5_years = r9_5_years;
	}
	public BigDecimal getR9_non_interest() {
		return r9_non_interest;
	}
	public void setR9_non_interest(BigDecimal r9_non_interest) {
		this.r9_non_interest = r9_non_interest;
	}
	public BigDecimal getR9_total() {
		return r9_total;
	}
	public void setR9_total(BigDecimal r9_total) {
		this.r9_total = r9_total;
	}
	public String getR10_product() {
		return r10_product;
	}
	public void setR10_product(String r10_product) {
		this.r10_product = r10_product;
	}
	public BigDecimal getR10_overdraft() {
		return r10_overdraft;
	}
	public void setR10_overdraft(BigDecimal r10_overdraft) {
		this.r10_overdraft = r10_overdraft;
	}
	public BigDecimal getR10_0_7_days() {
		return r10_0_7_days;
	}
	public void setR10_0_7_days(BigDecimal r10_0_7_days) {
		this.r10_0_7_days = r10_0_7_days;
	}
	public BigDecimal getR10_8_14_days() {
		return r10_8_14_days;
	}
	public void setR10_8_14_days(BigDecimal r10_8_14_days) {
		this.r10_8_14_days = r10_8_14_days;
	}
	public BigDecimal getR10_15_days_1_month() {
		return r10_15_days_1_month;
	}
	public void setR10_15_days_1_month(BigDecimal r10_15_days_1_month) {
		this.r10_15_days_1_month = r10_15_days_1_month;
	}
	public BigDecimal getR10_1_3_months() {
		return r10_1_3_months;
	}
	public void setR10_1_3_months(BigDecimal r10_1_3_months) {
		this.r10_1_3_months = r10_1_3_months;
	}
	public BigDecimal getR10_3_6_months() {
		return r10_3_6_months;
	}
	public void setR10_3_6_months(BigDecimal r10_3_6_months) {
		this.r10_3_6_months = r10_3_6_months;
	}
	public BigDecimal getR10_6_12_months() {
		return r10_6_12_months;
	}
	public void setR10_6_12_months(BigDecimal r10_6_12_months) {
		this.r10_6_12_months = r10_6_12_months;
	}
	public BigDecimal getR10_1_2_years() {
		return r10_1_2_years;
	}
	public void setR10_1_2_years(BigDecimal r10_1_2_years) {
		this.r10_1_2_years = r10_1_2_years;
	}
	public BigDecimal getR10_2_3_years() {
		return r10_2_3_years;
	}
	public void setR10_2_3_years(BigDecimal r10_2_3_years) {
		this.r10_2_3_years = r10_2_3_years;
	}
	public BigDecimal getR10_3_4_years() {
		return r10_3_4_years;
	}
	public void setR10_3_4_years(BigDecimal r10_3_4_years) {
		this.r10_3_4_years = r10_3_4_years;
	}
	public BigDecimal getR10_4_5_years() {
		return r10_4_5_years;
	}
	public void setR10_4_5_years(BigDecimal r10_4_5_years) {
		this.r10_4_5_years = r10_4_5_years;
	}
	public BigDecimal getR10_5_years() {
		return r10_5_years;
	}
	public void setR10_5_years(BigDecimal r10_5_years) {
		this.r10_5_years = r10_5_years;
	}
	public BigDecimal getR10_non_interest() {
		return r10_non_interest;
	}
	public void setR10_non_interest(BigDecimal r10_non_interest) {
		this.r10_non_interest = r10_non_interest;
	}
	public BigDecimal getR10_total() {
		return r10_total;
	}
	public void setR10_total(BigDecimal r10_total) {
		this.r10_total = r10_total;
	}
	public String getR11_product() {
		return r11_product;
	}
	public void setR11_product(String r11_product) {
		this.r11_product = r11_product;
	}
	public BigDecimal getR11_overdraft() {
		return r11_overdraft;
	}
	public void setR11_overdraft(BigDecimal r11_overdraft) {
		this.r11_overdraft = r11_overdraft;
	}
	public BigDecimal getR11_0_7_days() {
		return r11_0_7_days;
	}
	public void setR11_0_7_days(BigDecimal r11_0_7_days) {
		this.r11_0_7_days = r11_0_7_days;
	}
	public BigDecimal getR11_8_14_days() {
		return r11_8_14_days;
	}
	public void setR11_8_14_days(BigDecimal r11_8_14_days) {
		this.r11_8_14_days = r11_8_14_days;
	}
	public BigDecimal getR11_15_days_1_month() {
		return r11_15_days_1_month;
	}
	public void setR11_15_days_1_month(BigDecimal r11_15_days_1_month) {
		this.r11_15_days_1_month = r11_15_days_1_month;
	}
	public BigDecimal getR11_1_3_months() {
		return r11_1_3_months;
	}
	public void setR11_1_3_months(BigDecimal r11_1_3_months) {
		this.r11_1_3_months = r11_1_3_months;
	}
	public BigDecimal getR11_3_6_months() {
		return r11_3_6_months;
	}
	public void setR11_3_6_months(BigDecimal r11_3_6_months) {
		this.r11_3_6_months = r11_3_6_months;
	}
	public BigDecimal getR11_6_12_months() {
		return r11_6_12_months;
	}
	public void setR11_6_12_months(BigDecimal r11_6_12_months) {
		this.r11_6_12_months = r11_6_12_months;
	}
	public BigDecimal getR11_1_2_years() {
		return r11_1_2_years;
	}
	public void setR11_1_2_years(BigDecimal r11_1_2_years) {
		this.r11_1_2_years = r11_1_2_years;
	}
	public BigDecimal getR11_2_3_years() {
		return r11_2_3_years;
	}
	public void setR11_2_3_years(BigDecimal r11_2_3_years) {
		this.r11_2_3_years = r11_2_3_years;
	}
	public BigDecimal getR11_3_4_years() {
		return r11_3_4_years;
	}
	public void setR11_3_4_years(BigDecimal r11_3_4_years) {
		this.r11_3_4_years = r11_3_4_years;
	}
	public BigDecimal getR11_4_5_years() {
		return r11_4_5_years;
	}
	public void setR11_4_5_years(BigDecimal r11_4_5_years) {
		this.r11_4_5_years = r11_4_5_years;
	}
	public BigDecimal getR11_5_years() {
		return r11_5_years;
	}
	public void setR11_5_years(BigDecimal r11_5_years) {
		this.r11_5_years = r11_5_years;
	}
	public BigDecimal getR11_non_interest() {
		return r11_non_interest;
	}
	public void setR11_non_interest(BigDecimal r11_non_interest) {
		this.r11_non_interest = r11_non_interest;
	}
	public BigDecimal getR11_total() {
		return r11_total;
	}
	public void setR11_total(BigDecimal r11_total) {
		this.r11_total = r11_total;
	}
	public String getR12_product() {
		return r12_product;
	}
	public void setR12_product(String r12_product) {
		this.r12_product = r12_product;
	}
	public BigDecimal getR12_overdraft() {
		return r12_overdraft;
	}
	public void setR12_overdraft(BigDecimal r12_overdraft) {
		this.r12_overdraft = r12_overdraft;
	}
	public BigDecimal getR12_0_7_days() {
		return r12_0_7_days;
	}
	public void setR12_0_7_days(BigDecimal r12_0_7_days) {
		this.r12_0_7_days = r12_0_7_days;
	}
	public BigDecimal getR12_8_14_days() {
		return r12_8_14_days;
	}
	public void setR12_8_14_days(BigDecimal r12_8_14_days) {
		this.r12_8_14_days = r12_8_14_days;
	}
	public BigDecimal getR12_15_days_1_month() {
		return r12_15_days_1_month;
	}
	public void setR12_15_days_1_month(BigDecimal r12_15_days_1_month) {
		this.r12_15_days_1_month = r12_15_days_1_month;
	}
	public BigDecimal getR12_1_3_months() {
		return r12_1_3_months;
	}
	public void setR12_1_3_months(BigDecimal r12_1_3_months) {
		this.r12_1_3_months = r12_1_3_months;
	}
	public BigDecimal getR12_3_6_months() {
		return r12_3_6_months;
	}
	public void setR12_3_6_months(BigDecimal r12_3_6_months) {
		this.r12_3_6_months = r12_3_6_months;
	}
	public BigDecimal getR12_6_12_months() {
		return r12_6_12_months;
	}
	public void setR12_6_12_months(BigDecimal r12_6_12_months) {
		this.r12_6_12_months = r12_6_12_months;
	}
	public BigDecimal getR12_1_2_years() {
		return r12_1_2_years;
	}
	public void setR12_1_2_years(BigDecimal r12_1_2_years) {
		this.r12_1_2_years = r12_1_2_years;
	}
	public BigDecimal getR12_2_3_years() {
		return r12_2_3_years;
	}
	public void setR12_2_3_years(BigDecimal r12_2_3_years) {
		this.r12_2_3_years = r12_2_3_years;
	}
	public BigDecimal getR12_3_4_years() {
		return r12_3_4_years;
	}
	public void setR12_3_4_years(BigDecimal r12_3_4_years) {
		this.r12_3_4_years = r12_3_4_years;
	}
	public BigDecimal getR12_4_5_years() {
		return r12_4_5_years;
	}
	public void setR12_4_5_years(BigDecimal r12_4_5_years) {
		this.r12_4_5_years = r12_4_5_years;
	}
	public BigDecimal getR12_5_years() {
		return r12_5_years;
	}
	public void setR12_5_years(BigDecimal r12_5_years) {
		this.r12_5_years = r12_5_years;
	}
	public BigDecimal getR12_non_interest() {
		return r12_non_interest;
	}
	public void setR12_non_interest(BigDecimal r12_non_interest) {
		this.r12_non_interest = r12_non_interest;
	}
	public BigDecimal getR12_total() {
		return r12_total;
	}
	public void setR12_total(BigDecimal r12_total) {
		this.r12_total = r12_total;
	}
	public String getR13_product() {
		return r13_product;
	}
	public void setR13_product(String r13_product) {
		this.r13_product = r13_product;
	}
	public BigDecimal getR13_overdraft() {
		return r13_overdraft;
	}
	public void setR13_overdraft(BigDecimal r13_overdraft) {
		this.r13_overdraft = r13_overdraft;
	}
	public BigDecimal getR13_0_7_days() {
		return r13_0_7_days;
	}
	public void setR13_0_7_days(BigDecimal r13_0_7_days) {
		this.r13_0_7_days = r13_0_7_days;
	}
	public BigDecimal getR13_8_14_days() {
		return r13_8_14_days;
	}
	public void setR13_8_14_days(BigDecimal r13_8_14_days) {
		this.r13_8_14_days = r13_8_14_days;
	}
	public BigDecimal getR13_15_days_1_month() {
		return r13_15_days_1_month;
	}
	public void setR13_15_days_1_month(BigDecimal r13_15_days_1_month) {
		this.r13_15_days_1_month = r13_15_days_1_month;
	}
	public BigDecimal getR13_1_3_months() {
		return r13_1_3_months;
	}
	public void setR13_1_3_months(BigDecimal r13_1_3_months) {
		this.r13_1_3_months = r13_1_3_months;
	}
	public BigDecimal getR13_3_6_months() {
		return r13_3_6_months;
	}
	public void setR13_3_6_months(BigDecimal r13_3_6_months) {
		this.r13_3_6_months = r13_3_6_months;
	}
	public BigDecimal getR13_6_12_months() {
		return r13_6_12_months;
	}
	public void setR13_6_12_months(BigDecimal r13_6_12_months) {
		this.r13_6_12_months = r13_6_12_months;
	}
	public BigDecimal getR13_1_2_years() {
		return r13_1_2_years;
	}
	public void setR13_1_2_years(BigDecimal r13_1_2_years) {
		this.r13_1_2_years = r13_1_2_years;
	}
	public BigDecimal getR13_2_3_years() {
		return r13_2_3_years;
	}
	public void setR13_2_3_years(BigDecimal r13_2_3_years) {
		this.r13_2_3_years = r13_2_3_years;
	}
	public BigDecimal getR13_3_4_years() {
		return r13_3_4_years;
	}
	public void setR13_3_4_years(BigDecimal r13_3_4_years) {
		this.r13_3_4_years = r13_3_4_years;
	}
	public BigDecimal getR13_4_5_years() {
		return r13_4_5_years;
	}
	public void setR13_4_5_years(BigDecimal r13_4_5_years) {
		this.r13_4_5_years = r13_4_5_years;
	}
	public BigDecimal getR13_5_years() {
		return r13_5_years;
	}
	public void setR13_5_years(BigDecimal r13_5_years) {
		this.r13_5_years = r13_5_years;
	}
	public BigDecimal getR13_non_interest() {
		return r13_non_interest;
	}
	public void setR13_non_interest(BigDecimal r13_non_interest) {
		this.r13_non_interest = r13_non_interest;
	}
	public BigDecimal getR13_total() {
		return r13_total;
	}
	public void setR13_total(BigDecimal r13_total) {
		this.r13_total = r13_total;
	}
	public String getR14_product() {
		return r14_product;
	}
	public void setR14_product(String r14_product) {
		this.r14_product = r14_product;
	}
	public BigDecimal getR14_overdraft() {
		return r14_overdraft;
	}
	public void setR14_overdraft(BigDecimal r14_overdraft) {
		this.r14_overdraft = r14_overdraft;
	}
	public BigDecimal getR14_0_7_days() {
		return r14_0_7_days;
	}
	public void setR14_0_7_days(BigDecimal r14_0_7_days) {
		this.r14_0_7_days = r14_0_7_days;
	}
	public BigDecimal getR14_8_14_days() {
		return r14_8_14_days;
	}
	public void setR14_8_14_days(BigDecimal r14_8_14_days) {
		this.r14_8_14_days = r14_8_14_days;
	}
	public BigDecimal getR14_15_days_1_month() {
		return r14_15_days_1_month;
	}
	public void setR14_15_days_1_month(BigDecimal r14_15_days_1_month) {
		this.r14_15_days_1_month = r14_15_days_1_month;
	}
	public BigDecimal getR14_1_3_months() {
		return r14_1_3_months;
	}
	public void setR14_1_3_months(BigDecimal r14_1_3_months) {
		this.r14_1_3_months = r14_1_3_months;
	}
	public BigDecimal getR14_3_6_months() {
		return r14_3_6_months;
	}
	public void setR14_3_6_months(BigDecimal r14_3_6_months) {
		this.r14_3_6_months = r14_3_6_months;
	}
	public BigDecimal getR14_6_12_months() {
		return r14_6_12_months;
	}
	public void setR14_6_12_months(BigDecimal r14_6_12_months) {
		this.r14_6_12_months = r14_6_12_months;
	}
	public BigDecimal getR14_1_2_years() {
		return r14_1_2_years;
	}
	public void setR14_1_2_years(BigDecimal r14_1_2_years) {
		this.r14_1_2_years = r14_1_2_years;
	}
	public BigDecimal getR14_2_3_years() {
		return r14_2_3_years;
	}
	public void setR14_2_3_years(BigDecimal r14_2_3_years) {
		this.r14_2_3_years = r14_2_3_years;
	}
	public BigDecimal getR14_3_4_years() {
		return r14_3_4_years;
	}
	public void setR14_3_4_years(BigDecimal r14_3_4_years) {
		this.r14_3_4_years = r14_3_4_years;
	}
	public BigDecimal getR14_4_5_years() {
		return r14_4_5_years;
	}
	public void setR14_4_5_years(BigDecimal r14_4_5_years) {
		this.r14_4_5_years = r14_4_5_years;
	}
	public BigDecimal getR14_5_years() {
		return r14_5_years;
	}
	public void setR14_5_years(BigDecimal r14_5_years) {
		this.r14_5_years = r14_5_years;
	}
	public BigDecimal getR14_non_interest() {
		return r14_non_interest;
	}
	public void setR14_non_interest(BigDecimal r14_non_interest) {
		this.r14_non_interest = r14_non_interest;
	}
	public BigDecimal getR14_total() {
		return r14_total;
	}
	public void setR14_total(BigDecimal r14_total) {
		this.r14_total = r14_total;
	}
	public String getR15_product() {
		return r15_product;
	}
	public void setR15_product(String r15_product) {
		this.r15_product = r15_product;
	}
	public BigDecimal getR15_overdraft() {
		return r15_overdraft;
	}
	public void setR15_overdraft(BigDecimal r15_overdraft) {
		this.r15_overdraft = r15_overdraft;
	}
	public BigDecimal getR15_0_7_days() {
		return r15_0_7_days;
	}
	public void setR15_0_7_days(BigDecimal r15_0_7_days) {
		this.r15_0_7_days = r15_0_7_days;
	}
	public BigDecimal getR15_8_14_days() {
		return r15_8_14_days;
	}
	public void setR15_8_14_days(BigDecimal r15_8_14_days) {
		this.r15_8_14_days = r15_8_14_days;
	}
	public BigDecimal getR15_15_days_1_month() {
		return r15_15_days_1_month;
	}
	public void setR15_15_days_1_month(BigDecimal r15_15_days_1_month) {
		this.r15_15_days_1_month = r15_15_days_1_month;
	}
	public BigDecimal getR15_1_3_months() {
		return r15_1_3_months;
	}
	public void setR15_1_3_months(BigDecimal r15_1_3_months) {
		this.r15_1_3_months = r15_1_3_months;
	}
	public BigDecimal getR15_3_6_months() {
		return r15_3_6_months;
	}
	public void setR15_3_6_months(BigDecimal r15_3_6_months) {
		this.r15_3_6_months = r15_3_6_months;
	}
	public BigDecimal getR15_6_12_months() {
		return r15_6_12_months;
	}
	public void setR15_6_12_months(BigDecimal r15_6_12_months) {
		this.r15_6_12_months = r15_6_12_months;
	}
	public BigDecimal getR15_1_2_years() {
		return r15_1_2_years;
	}
	public void setR15_1_2_years(BigDecimal r15_1_2_years) {
		this.r15_1_2_years = r15_1_2_years;
	}
	public BigDecimal getR15_2_3_years() {
		return r15_2_3_years;
	}
	public void setR15_2_3_years(BigDecimal r15_2_3_years) {
		this.r15_2_3_years = r15_2_3_years;
	}
	public BigDecimal getR15_3_4_years() {
		return r15_3_4_years;
	}
	public void setR15_3_4_years(BigDecimal r15_3_4_years) {
		this.r15_3_4_years = r15_3_4_years;
	}
	public BigDecimal getR15_4_5_years() {
		return r15_4_5_years;
	}
	public void setR15_4_5_years(BigDecimal r15_4_5_years) {
		this.r15_4_5_years = r15_4_5_years;
	}
	public BigDecimal getR15_5_years() {
		return r15_5_years;
	}
	public void setR15_5_years(BigDecimal r15_5_years) {
		this.r15_5_years = r15_5_years;
	}
	public BigDecimal getR15_non_interest() {
		return r15_non_interest;
	}
	public void setR15_non_interest(BigDecimal r15_non_interest) {
		this.r15_non_interest = r15_non_interest;
	}
	public BigDecimal getR15_total() {
		return r15_total;
	}
	public void setR15_total(BigDecimal r15_total) {
		this.r15_total = r15_total;
	}
	public String getR16_product() {
		return r16_product;
	}
	public void setR16_product(String r16_product) {
		this.r16_product = r16_product;
	}
	public BigDecimal getR16_overdraft() {
		return r16_overdraft;
	}
	public void setR16_overdraft(BigDecimal r16_overdraft) {
		this.r16_overdraft = r16_overdraft;
	}
	public BigDecimal getR16_0_7_days() {
		return r16_0_7_days;
	}
	public void setR16_0_7_days(BigDecimal r16_0_7_days) {
		this.r16_0_7_days = r16_0_7_days;
	}
	public BigDecimal getR16_8_14_days() {
		return r16_8_14_days;
	}
	public void setR16_8_14_days(BigDecimal r16_8_14_days) {
		this.r16_8_14_days = r16_8_14_days;
	}
	public BigDecimal getR16_15_days_1_month() {
		return r16_15_days_1_month;
	}
	public void setR16_15_days_1_month(BigDecimal r16_15_days_1_month) {
		this.r16_15_days_1_month = r16_15_days_1_month;
	}
	public BigDecimal getR16_1_3_months() {
		return r16_1_3_months;
	}
	public void setR16_1_3_months(BigDecimal r16_1_3_months) {
		this.r16_1_3_months = r16_1_3_months;
	}
	public BigDecimal getR16_3_6_months() {
		return r16_3_6_months;
	}
	public void setR16_3_6_months(BigDecimal r16_3_6_months) {
		this.r16_3_6_months = r16_3_6_months;
	}
	public BigDecimal getR16_6_12_months() {
		return r16_6_12_months;
	}
	public void setR16_6_12_months(BigDecimal r16_6_12_months) {
		this.r16_6_12_months = r16_6_12_months;
	}
	public BigDecimal getR16_1_2_years() {
		return r16_1_2_years;
	}
	public void setR16_1_2_years(BigDecimal r16_1_2_years) {
		this.r16_1_2_years = r16_1_2_years;
	}
	public BigDecimal getR16_2_3_years() {
		return r16_2_3_years;
	}
	public void setR16_2_3_years(BigDecimal r16_2_3_years) {
		this.r16_2_3_years = r16_2_3_years;
	}
	public BigDecimal getR16_3_4_years() {
		return r16_3_4_years;
	}
	public void setR16_3_4_years(BigDecimal r16_3_4_years) {
		this.r16_3_4_years = r16_3_4_years;
	}
	public BigDecimal getR16_4_5_years() {
		return r16_4_5_years;
	}
	public void setR16_4_5_years(BigDecimal r16_4_5_years) {
		this.r16_4_5_years = r16_4_5_years;
	}
	public BigDecimal getR16_5_years() {
		return r16_5_years;
	}
	public void setR16_5_years(BigDecimal r16_5_years) {
		this.r16_5_years = r16_5_years;
	}
	public BigDecimal getR16_non_interest() {
		return r16_non_interest;
	}
	public void setR16_non_interest(BigDecimal r16_non_interest) {
		this.r16_non_interest = r16_non_interest;
	}
	public BigDecimal getR16_total() {
		return r16_total;
	}
	public void setR16_total(BigDecimal r16_total) {
		this.r16_total = r16_total;
	}
	public String getRh4_product() {
		return rh4_product;
	}
	public void setRh4_product(String rh4_product) {
		this.rh4_product = rh4_product;
	}
	public BigDecimal getRh4_overdraft() {
		return rh4_overdraft;
	}
	public void setRh4_overdraft(BigDecimal rh4_overdraft) {
		this.rh4_overdraft = rh4_overdraft;
	}
	public BigDecimal getRh4_0_7_days() {
		return rh4_0_7_days;
	}
	public void setRh4_0_7_days(BigDecimal rh4_0_7_days) {
		this.rh4_0_7_days = rh4_0_7_days;
	}
	public BigDecimal getRh4_8_14_days() {
		return rh4_8_14_days;
	}
	public void setRh4_8_14_days(BigDecimal rh4_8_14_days) {
		this.rh4_8_14_days = rh4_8_14_days;
	}
	public BigDecimal getRh4_15_days_1_month() {
		return rh4_15_days_1_month;
	}
	public void setRh4_15_days_1_month(BigDecimal rh4_15_days_1_month) {
		this.rh4_15_days_1_month = rh4_15_days_1_month;
	}
	public BigDecimal getRh4_1_3_months() {
		return rh4_1_3_months;
	}
	public void setRh4_1_3_months(BigDecimal rh4_1_3_months) {
		this.rh4_1_3_months = rh4_1_3_months;
	}
	public BigDecimal getRh4_3_6_months() {
		return rh4_3_6_months;
	}
	public void setRh4_3_6_months(BigDecimal rh4_3_6_months) {
		this.rh4_3_6_months = rh4_3_6_months;
	}
	public BigDecimal getRh4_6_12_months() {
		return rh4_6_12_months;
	}
	public void setRh4_6_12_months(BigDecimal rh4_6_12_months) {
		this.rh4_6_12_months = rh4_6_12_months;
	}
	public BigDecimal getRh4_1_2_years() {
		return rh4_1_2_years;
	}
	public void setRh4_1_2_years(BigDecimal rh4_1_2_years) {
		this.rh4_1_2_years = rh4_1_2_years;
	}
	public BigDecimal getRh4_2_3_years() {
		return rh4_2_3_years;
	}
	public void setRh4_2_3_years(BigDecimal rh4_2_3_years) {
		this.rh4_2_3_years = rh4_2_3_years;
	}
	public BigDecimal getRh4_3_4_years() {
		return rh4_3_4_years;
	}
	public void setRh4_3_4_years(BigDecimal rh4_3_4_years) {
		this.rh4_3_4_years = rh4_3_4_years;
	}
	public BigDecimal getRh4_4_5_years() {
		return rh4_4_5_years;
	}
	public void setRh4_4_5_years(BigDecimal rh4_4_5_years) {
		this.rh4_4_5_years = rh4_4_5_years;
	}
	public BigDecimal getRh4_5_years() {
		return rh4_5_years;
	}
	public void setRh4_5_years(BigDecimal rh4_5_years) {
		this.rh4_5_years = rh4_5_years;
	}
	public BigDecimal getRh4_non_interest() {
		return rh4_non_interest;
	}
	public void setRh4_non_interest(BigDecimal rh4_non_interest) {
		this.rh4_non_interest = rh4_non_interest;
	}
	public BigDecimal getRh4_total() {
		return rh4_total;
	}
	public void setRh4_total(BigDecimal rh4_total) {
		this.rh4_total = rh4_total;
	}
	public String getR17_product() {
		return r17_product;
	}
	public void setR17_product(String r17_product) {
		this.r17_product = r17_product;
	}
	public BigDecimal getR17_overdraft() {
		return r17_overdraft;
	}
	public void setR17_overdraft(BigDecimal r17_overdraft) {
		this.r17_overdraft = r17_overdraft;
	}
	public BigDecimal getR17_0_7_days() {
		return r17_0_7_days;
	}
	public void setR17_0_7_days(BigDecimal r17_0_7_days) {
		this.r17_0_7_days = r17_0_7_days;
	}
	public BigDecimal getR17_8_14_days() {
		return r17_8_14_days;
	}
	public void setR17_8_14_days(BigDecimal r17_8_14_days) {
		this.r17_8_14_days = r17_8_14_days;
	}
	public BigDecimal getR17_15_days_1_month() {
		return r17_15_days_1_month;
	}
	public void setR17_15_days_1_month(BigDecimal r17_15_days_1_month) {
		this.r17_15_days_1_month = r17_15_days_1_month;
	}
	public BigDecimal getR17_1_3_months() {
		return r17_1_3_months;
	}
	public void setR17_1_3_months(BigDecimal r17_1_3_months) {
		this.r17_1_3_months = r17_1_3_months;
	}
	public BigDecimal getR17_3_6_months() {
		return r17_3_6_months;
	}
	public void setR17_3_6_months(BigDecimal r17_3_6_months) {
		this.r17_3_6_months = r17_3_6_months;
	}
	public BigDecimal getR17_6_12_months() {
		return r17_6_12_months;
	}
	public void setR17_6_12_months(BigDecimal r17_6_12_months) {
		this.r17_6_12_months = r17_6_12_months;
	}
	public BigDecimal getR17_1_2_years() {
		return r17_1_2_years;
	}
	public void setR17_1_2_years(BigDecimal r17_1_2_years) {
		this.r17_1_2_years = r17_1_2_years;
	}
	public BigDecimal getR17_2_3_years() {
		return r17_2_3_years;
	}
	public void setR17_2_3_years(BigDecimal r17_2_3_years) {
		this.r17_2_3_years = r17_2_3_years;
	}
	public BigDecimal getR17_3_4_years() {
		return r17_3_4_years;
	}
	public void setR17_3_4_years(BigDecimal r17_3_4_years) {
		this.r17_3_4_years = r17_3_4_years;
	}
	public BigDecimal getR17_4_5_years() {
		return r17_4_5_years;
	}
	public void setR17_4_5_years(BigDecimal r17_4_5_years) {
		this.r17_4_5_years = r17_4_5_years;
	}
	public BigDecimal getR17_5_years() {
		return r17_5_years;
	}
	public void setR17_5_years(BigDecimal r17_5_years) {
		this.r17_5_years = r17_5_years;
	}
	public BigDecimal getR17_non_interest() {
		return r17_non_interest;
	}
	public void setR17_non_interest(BigDecimal r17_non_interest) {
		this.r17_non_interest = r17_non_interest;
	}
	public BigDecimal getR17_total() {
		return r17_total;
	}
	public void setR17_total(BigDecimal r17_total) {
		this.r17_total = r17_total;
	}
	public String getR18_product() {
		return r18_product;
	}
	public void setR18_product(String r18_product) {
		this.r18_product = r18_product;
	}
	public BigDecimal getR18_overdraft() {
		return r18_overdraft;
	}
	public void setR18_overdraft(BigDecimal r18_overdraft) {
		this.r18_overdraft = r18_overdraft;
	}
	public BigDecimal getR18_0_7_days() {
		return r18_0_7_days;
	}
	public void setR18_0_7_days(BigDecimal r18_0_7_days) {
		this.r18_0_7_days = r18_0_7_days;
	}
	public BigDecimal getR18_8_14_days() {
		return r18_8_14_days;
	}
	public void setR18_8_14_days(BigDecimal r18_8_14_days) {
		this.r18_8_14_days = r18_8_14_days;
	}
	public BigDecimal getR18_15_days_1_month() {
		return r18_15_days_1_month;
	}
	public void setR18_15_days_1_month(BigDecimal r18_15_days_1_month) {
		this.r18_15_days_1_month = r18_15_days_1_month;
	}
	public BigDecimal getR18_1_3_months() {
		return r18_1_3_months;
	}
	public void setR18_1_3_months(BigDecimal r18_1_3_months) {
		this.r18_1_3_months = r18_1_3_months;
	}
	public BigDecimal getR18_3_6_months() {
		return r18_3_6_months;
	}
	public void setR18_3_6_months(BigDecimal r18_3_6_months) {
		this.r18_3_6_months = r18_3_6_months;
	}
	public BigDecimal getR18_6_12_months() {
		return r18_6_12_months;
	}
	public void setR18_6_12_months(BigDecimal r18_6_12_months) {
		this.r18_6_12_months = r18_6_12_months;
	}
	public BigDecimal getR18_1_2_years() {
		return r18_1_2_years;
	}
	public void setR18_1_2_years(BigDecimal r18_1_2_years) {
		this.r18_1_2_years = r18_1_2_years;
	}
	public BigDecimal getR18_2_3_years() {
		return r18_2_3_years;
	}
	public void setR18_2_3_years(BigDecimal r18_2_3_years) {
		this.r18_2_3_years = r18_2_3_years;
	}
	public BigDecimal getR18_3_4_years() {
		return r18_3_4_years;
	}
	public void setR18_3_4_years(BigDecimal r18_3_4_years) {
		this.r18_3_4_years = r18_3_4_years;
	}
	public BigDecimal getR18_4_5_years() {
		return r18_4_5_years;
	}
	public void setR18_4_5_years(BigDecimal r18_4_5_years) {
		this.r18_4_5_years = r18_4_5_years;
	}
	public BigDecimal getR18_5_years() {
		return r18_5_years;
	}
	public void setR18_5_years(BigDecimal r18_5_years) {
		this.r18_5_years = r18_5_years;
	}
	public BigDecimal getR18_non_interest() {
		return r18_non_interest;
	}
	public void setR18_non_interest(BigDecimal r18_non_interest) {
		this.r18_non_interest = r18_non_interest;
	}
	public BigDecimal getR18_total() {
		return r18_total;
	}
	public void setR18_total(BigDecimal r18_total) {
		this.r18_total = r18_total;
	}
	public String getR19_product() {
		return r19_product;
	}
	public void setR19_product(String r19_product) {
		this.r19_product = r19_product;
	}
	public BigDecimal getR19_overdraft() {
		return r19_overdraft;
	}
	public void setR19_overdraft(BigDecimal r19_overdraft) {
		this.r19_overdraft = r19_overdraft;
	}
	public BigDecimal getR19_0_7_days() {
		return r19_0_7_days;
	}
	public void setR19_0_7_days(BigDecimal r19_0_7_days) {
		this.r19_0_7_days = r19_0_7_days;
	}
	public BigDecimal getR19_8_14_days() {
		return r19_8_14_days;
	}
	public void setR19_8_14_days(BigDecimal r19_8_14_days) {
		this.r19_8_14_days = r19_8_14_days;
	}
	public BigDecimal getR19_15_days_1_month() {
		return r19_15_days_1_month;
	}
	public void setR19_15_days_1_month(BigDecimal r19_15_days_1_month) {
		this.r19_15_days_1_month = r19_15_days_1_month;
	}
	public BigDecimal getR19_1_3_months() {
		return r19_1_3_months;
	}
	public void setR19_1_3_months(BigDecimal r19_1_3_months) {
		this.r19_1_3_months = r19_1_3_months;
	}
	public BigDecimal getR19_3_6_months() {
		return r19_3_6_months;
	}
	public void setR19_3_6_months(BigDecimal r19_3_6_months) {
		this.r19_3_6_months = r19_3_6_months;
	}
	public BigDecimal getR19_6_12_months() {
		return r19_6_12_months;
	}
	public void setR19_6_12_months(BigDecimal r19_6_12_months) {
		this.r19_6_12_months = r19_6_12_months;
	}
	public BigDecimal getR19_1_2_years() {
		return r19_1_2_years;
	}
	public void setR19_1_2_years(BigDecimal r19_1_2_years) {
		this.r19_1_2_years = r19_1_2_years;
	}
	public BigDecimal getR19_2_3_years() {
		return r19_2_3_years;
	}
	public void setR19_2_3_years(BigDecimal r19_2_3_years) {
		this.r19_2_3_years = r19_2_3_years;
	}
	public BigDecimal getR19_3_4_years() {
		return r19_3_4_years;
	}
	public void setR19_3_4_years(BigDecimal r19_3_4_years) {
		this.r19_3_4_years = r19_3_4_years;
	}
	public BigDecimal getR19_4_5_years() {
		return r19_4_5_years;
	}
	public void setR19_4_5_years(BigDecimal r19_4_5_years) {
		this.r19_4_5_years = r19_4_5_years;
	}
	public BigDecimal getR19_5_years() {
		return r19_5_years;
	}
	public void setR19_5_years(BigDecimal r19_5_years) {
		this.r19_5_years = r19_5_years;
	}
	public BigDecimal getR19_non_interest() {
		return r19_non_interest;
	}
	public void setR19_non_interest(BigDecimal r19_non_interest) {
		this.r19_non_interest = r19_non_interest;
	}
	public BigDecimal getR19_total() {
		return r19_total;
	}
	public void setR19_total(BigDecimal r19_total) {
		this.r19_total = r19_total;
	}
	public String getR20_product() {
		return r20_product;
	}
	public void setR20_product(String r20_product) {
		this.r20_product = r20_product;
	}
	public BigDecimal getR20_overdraft() {
		return r20_overdraft;
	}
	public void setR20_overdraft(BigDecimal r20_overdraft) {
		this.r20_overdraft = r20_overdraft;
	}
	public BigDecimal getR20_0_7_days() {
		return r20_0_7_days;
	}
	public void setR20_0_7_days(BigDecimal r20_0_7_days) {
		this.r20_0_7_days = r20_0_7_days;
	}
	public BigDecimal getR20_8_14_days() {
		return r20_8_14_days;
	}
	public void setR20_8_14_days(BigDecimal r20_8_14_days) {
		this.r20_8_14_days = r20_8_14_days;
	}
	public BigDecimal getR20_15_days_1_month() {
		return r20_15_days_1_month;
	}
	public void setR20_15_days_1_month(BigDecimal r20_15_days_1_month) {
		this.r20_15_days_1_month = r20_15_days_1_month;
	}
	public BigDecimal getR20_1_3_months() {
		return r20_1_3_months;
	}
	public void setR20_1_3_months(BigDecimal r20_1_3_months) {
		this.r20_1_3_months = r20_1_3_months;
	}
	public BigDecimal getR20_3_6_months() {
		return r20_3_6_months;
	}
	public void setR20_3_6_months(BigDecimal r20_3_6_months) {
		this.r20_3_6_months = r20_3_6_months;
	}
	public BigDecimal getR20_6_12_months() {
		return r20_6_12_months;
	}
	public void setR20_6_12_months(BigDecimal r20_6_12_months) {
		this.r20_6_12_months = r20_6_12_months;
	}
	public BigDecimal getR20_1_2_years() {
		return r20_1_2_years;
	}
	public void setR20_1_2_years(BigDecimal r20_1_2_years) {
		this.r20_1_2_years = r20_1_2_years;
	}
	public BigDecimal getR20_2_3_years() {
		return r20_2_3_years;
	}
	public void setR20_2_3_years(BigDecimal r20_2_3_years) {
		this.r20_2_3_years = r20_2_3_years;
	}
	public BigDecimal getR20_3_4_years() {
		return r20_3_4_years;
	}
	public void setR20_3_4_years(BigDecimal r20_3_4_years) {
		this.r20_3_4_years = r20_3_4_years;
	}
	public BigDecimal getR20_4_5_years() {
		return r20_4_5_years;
	}
	public void setR20_4_5_years(BigDecimal r20_4_5_years) {
		this.r20_4_5_years = r20_4_5_years;
	}
	public BigDecimal getR20_5_years() {
		return r20_5_years;
	}
	public void setR20_5_years(BigDecimal r20_5_years) {
		this.r20_5_years = r20_5_years;
	}
	public BigDecimal getR20_non_interest() {
		return r20_non_interest;
	}
	public void setR20_non_interest(BigDecimal r20_non_interest) {
		this.r20_non_interest = r20_non_interest;
	}
	public BigDecimal getR20_total() {
		return r20_total;
	}
	public void setR20_total(BigDecimal r20_total) {
		this.r20_total = r20_total;
	}
	public String getR21_product() {
		return r21_product;
	}
	public void setR21_product(String r21_product) {
		this.r21_product = r21_product;
	}
	public BigDecimal getR21_overdraft() {
		return r21_overdraft;
	}
	public void setR21_overdraft(BigDecimal r21_overdraft) {
		this.r21_overdraft = r21_overdraft;
	}
	public BigDecimal getR21_0_7_days() {
		return r21_0_7_days;
	}
	public void setR21_0_7_days(BigDecimal r21_0_7_days) {
		this.r21_0_7_days = r21_0_7_days;
	}
	public BigDecimal getR21_8_14_days() {
		return r21_8_14_days;
	}
	public void setR21_8_14_days(BigDecimal r21_8_14_days) {
		this.r21_8_14_days = r21_8_14_days;
	}
	public BigDecimal getR21_15_days_1_month() {
		return r21_15_days_1_month;
	}
	public void setR21_15_days_1_month(BigDecimal r21_15_days_1_month) {
		this.r21_15_days_1_month = r21_15_days_1_month;
	}
	public BigDecimal getR21_1_3_months() {
		return r21_1_3_months;
	}
	public void setR21_1_3_months(BigDecimal r21_1_3_months) {
		this.r21_1_3_months = r21_1_3_months;
	}
	public BigDecimal getR21_3_6_months() {
		return r21_3_6_months;
	}
	public void setR21_3_6_months(BigDecimal r21_3_6_months) {
		this.r21_3_6_months = r21_3_6_months;
	}
	public BigDecimal getR21_6_12_months() {
		return r21_6_12_months;
	}
	public void setR21_6_12_months(BigDecimal r21_6_12_months) {
		this.r21_6_12_months = r21_6_12_months;
	}
	public BigDecimal getR21_1_2_years() {
		return r21_1_2_years;
	}
	public void setR21_1_2_years(BigDecimal r21_1_2_years) {
		this.r21_1_2_years = r21_1_2_years;
	}
	public BigDecimal getR21_2_3_years() {
		return r21_2_3_years;
	}
	public void setR21_2_3_years(BigDecimal r21_2_3_years) {
		this.r21_2_3_years = r21_2_3_years;
	}
	public BigDecimal getR21_3_4_years() {
		return r21_3_4_years;
	}
	public void setR21_3_4_years(BigDecimal r21_3_4_years) {
		this.r21_3_4_years = r21_3_4_years;
	}
	public BigDecimal getR21_4_5_years() {
		return r21_4_5_years;
	}
	public void setR21_4_5_years(BigDecimal r21_4_5_years) {
		this.r21_4_5_years = r21_4_5_years;
	}
	public BigDecimal getR21_5_years() {
		return r21_5_years;
	}
	public void setR21_5_years(BigDecimal r21_5_years) {
		this.r21_5_years = r21_5_years;
	}
	public BigDecimal getR21_non_interest() {
		return r21_non_interest;
	}
	public void setR21_non_interest(BigDecimal r21_non_interest) {
		this.r21_non_interest = r21_non_interest;
	}
	public BigDecimal getR21_total() {
		return r21_total;
	}
	public void setR21_total(BigDecimal r21_total) {
		this.r21_total = r21_total;
	}
	public String getR22_product() {
		return r22_product;
	}
	public void setR22_product(String r22_product) {
		this.r22_product = r22_product;
	}
	public BigDecimal getR22_overdraft() {
		return r22_overdraft;
	}
	public void setR22_overdraft(BigDecimal r22_overdraft) {
		this.r22_overdraft = r22_overdraft;
	}
	public BigDecimal getR22_0_7_days() {
		return r22_0_7_days;
	}
	public void setR22_0_7_days(BigDecimal r22_0_7_days) {
		this.r22_0_7_days = r22_0_7_days;
	}
	public BigDecimal getR22_8_14_days() {
		return r22_8_14_days;
	}
	public void setR22_8_14_days(BigDecimal r22_8_14_days) {
		this.r22_8_14_days = r22_8_14_days;
	}
	public BigDecimal getR22_15_days_1_month() {
		return r22_15_days_1_month;
	}
	public void setR22_15_days_1_month(BigDecimal r22_15_days_1_month) {
		this.r22_15_days_1_month = r22_15_days_1_month;
	}
	public BigDecimal getR22_1_3_months() {
		return r22_1_3_months;
	}
	public void setR22_1_3_months(BigDecimal r22_1_3_months) {
		this.r22_1_3_months = r22_1_3_months;
	}
	public BigDecimal getR22_3_6_months() {
		return r22_3_6_months;
	}
	public void setR22_3_6_months(BigDecimal r22_3_6_months) {
		this.r22_3_6_months = r22_3_6_months;
	}
	public BigDecimal getR22_6_12_months() {
		return r22_6_12_months;
	}
	public void setR22_6_12_months(BigDecimal r22_6_12_months) {
		this.r22_6_12_months = r22_6_12_months;
	}
	public BigDecimal getR22_1_2_years() {
		return r22_1_2_years;
	}
	public void setR22_1_2_years(BigDecimal r22_1_2_years) {
		this.r22_1_2_years = r22_1_2_years;
	}
	public BigDecimal getR22_2_3_years() {
		return r22_2_3_years;
	}
	public void setR22_2_3_years(BigDecimal r22_2_3_years) {
		this.r22_2_3_years = r22_2_3_years;
	}
	public BigDecimal getR22_3_4_years() {
		return r22_3_4_years;
	}
	public void setR22_3_4_years(BigDecimal r22_3_4_years) {
		this.r22_3_4_years = r22_3_4_years;
	}
	public BigDecimal getR22_4_5_years() {
		return r22_4_5_years;
	}
	public void setR22_4_5_years(BigDecimal r22_4_5_years) {
		this.r22_4_5_years = r22_4_5_years;
	}
	public BigDecimal getR22_5_years() {
		return r22_5_years;
	}
	public void setR22_5_years(BigDecimal r22_5_years) {
		this.r22_5_years = r22_5_years;
	}
	public BigDecimal getR22_non_interest() {
		return r22_non_interest;
	}
	public void setR22_non_interest(BigDecimal r22_non_interest) {
		this.r22_non_interest = r22_non_interest;
	}
	public BigDecimal getR22_total() {
		return r22_total;
	}
	public void setR22_total(BigDecimal r22_total) {
		this.r22_total = r22_total;
	}
	public String getRh5_product() {
		return rh5_product;
	}
	public void setRh5_product(String rh5_product) {
		this.rh5_product = rh5_product;
	}
	public BigDecimal getRh5_overdraft() {
		return rh5_overdraft;
	}
	public void setRh5_overdraft(BigDecimal rh5_overdraft) {
		this.rh5_overdraft = rh5_overdraft;
	}
	public BigDecimal getRh5_0_7_days() {
		return rh5_0_7_days;
	}
	public void setRh5_0_7_days(BigDecimal rh5_0_7_days) {
		this.rh5_0_7_days = rh5_0_7_days;
	}
	public BigDecimal getRh5_8_14_days() {
		return rh5_8_14_days;
	}
	public void setRh5_8_14_days(BigDecimal rh5_8_14_days) {
		this.rh5_8_14_days = rh5_8_14_days;
	}
	public BigDecimal getRh5_15_days_1_month() {
		return rh5_15_days_1_month;
	}
	public void setRh5_15_days_1_month(BigDecimal rh5_15_days_1_month) {
		this.rh5_15_days_1_month = rh5_15_days_1_month;
	}
	public BigDecimal getRh5_1_3_months() {
		return rh5_1_3_months;
	}
	public void setRh5_1_3_months(BigDecimal rh5_1_3_months) {
		this.rh5_1_3_months = rh5_1_3_months;
	}
	public BigDecimal getRh5_3_6_months() {
		return rh5_3_6_months;
	}
	public void setRh5_3_6_months(BigDecimal rh5_3_6_months) {
		this.rh5_3_6_months = rh5_3_6_months;
	}
	public BigDecimal getRh5_6_12_months() {
		return rh5_6_12_months;
	}
	public void setRh5_6_12_months(BigDecimal rh5_6_12_months) {
		this.rh5_6_12_months = rh5_6_12_months;
	}
	public BigDecimal getRh5_1_2_years() {
		return rh5_1_2_years;
	}
	public void setRh5_1_2_years(BigDecimal rh5_1_2_years) {
		this.rh5_1_2_years = rh5_1_2_years;
	}
	public BigDecimal getRh5_2_3_years() {
		return rh5_2_3_years;
	}
	public void setRh5_2_3_years(BigDecimal rh5_2_3_years) {
		this.rh5_2_3_years = rh5_2_3_years;
	}
	public BigDecimal getRh5_3_4_years() {
		return rh5_3_4_years;
	}
	public void setRh5_3_4_years(BigDecimal rh5_3_4_years) {
		this.rh5_3_4_years = rh5_3_4_years;
	}
	public BigDecimal getRh5_4_5_years() {
		return rh5_4_5_years;
	}
	public void setRh5_4_5_years(BigDecimal rh5_4_5_years) {
		this.rh5_4_5_years = rh5_4_5_years;
	}
	public BigDecimal getRh5_5_years() {
		return rh5_5_years;
	}
	public void setRh5_5_years(BigDecimal rh5_5_years) {
		this.rh5_5_years = rh5_5_years;
	}
	public BigDecimal getRh5_non_interest() {
		return rh5_non_interest;
	}
	public void setRh5_non_interest(BigDecimal rh5_non_interest) {
		this.rh5_non_interest = rh5_non_interest;
	}
	public BigDecimal getRh5_total() {
		return rh5_total;
	}
	public void setRh5_total(BigDecimal rh5_total) {
		this.rh5_total = rh5_total;
	}
	public String getR23_product() {
		return r23_product;
	}
	public void setR23_product(String r23_product) {
		this.r23_product = r23_product;
	}
	public BigDecimal getR23_overdraft() {
		return r23_overdraft;
	}
	public void setR23_overdraft(BigDecimal r23_overdraft) {
		this.r23_overdraft = r23_overdraft;
	}
	public BigDecimal getR23_0_7_days() {
		return r23_0_7_days;
	}
	public void setR23_0_7_days(BigDecimal r23_0_7_days) {
		this.r23_0_7_days = r23_0_7_days;
	}
	public BigDecimal getR23_8_14_days() {
		return r23_8_14_days;
	}
	public void setR23_8_14_days(BigDecimal r23_8_14_days) {
		this.r23_8_14_days = r23_8_14_days;
	}
	public BigDecimal getR23_15_days_1_month() {
		return r23_15_days_1_month;
	}
	public void setR23_15_days_1_month(BigDecimal r23_15_days_1_month) {
		this.r23_15_days_1_month = r23_15_days_1_month;
	}
	public BigDecimal getR23_1_3_months() {
		return r23_1_3_months;
	}
	public void setR23_1_3_months(BigDecimal r23_1_3_months) {
		this.r23_1_3_months = r23_1_3_months;
	}
	public BigDecimal getR23_3_6_months() {
		return r23_3_6_months;
	}
	public void setR23_3_6_months(BigDecimal r23_3_6_months) {
		this.r23_3_6_months = r23_3_6_months;
	}
	public BigDecimal getR23_6_12_months() {
		return r23_6_12_months;
	}
	public void setR23_6_12_months(BigDecimal r23_6_12_months) {
		this.r23_6_12_months = r23_6_12_months;
	}
	public BigDecimal getR23_1_2_years() {
		return r23_1_2_years;
	}
	public void setR23_1_2_years(BigDecimal r23_1_2_years) {
		this.r23_1_2_years = r23_1_2_years;
	}
	public BigDecimal getR23_2_3_years() {
		return r23_2_3_years;
	}
	public void setR23_2_3_years(BigDecimal r23_2_3_years) {
		this.r23_2_3_years = r23_2_3_years;
	}
	public BigDecimal getR23_3_4_years() {
		return r23_3_4_years;
	}
	public void setR23_3_4_years(BigDecimal r23_3_4_years) {
		this.r23_3_4_years = r23_3_4_years;
	}
	public BigDecimal getR23_4_5_years() {
		return r23_4_5_years;
	}
	public void setR23_4_5_years(BigDecimal r23_4_5_years) {
		this.r23_4_5_years = r23_4_5_years;
	}
	public BigDecimal getR23_5_years() {
		return r23_5_years;
	}
	public void setR23_5_years(BigDecimal r23_5_years) {
		this.r23_5_years = r23_5_years;
	}
	public BigDecimal getR23_non_interest() {
		return r23_non_interest;
	}
	public void setR23_non_interest(BigDecimal r23_non_interest) {
		this.r23_non_interest = r23_non_interest;
	}
	public BigDecimal getR23_total() {
		return r23_total;
	}
	public void setR23_total(BigDecimal r23_total) {
		this.r23_total = r23_total;
	}
	public String getR24_product() {
		return r24_product;
	}
	public void setR24_product(String r24_product) {
		this.r24_product = r24_product;
	}
	public BigDecimal getR24_overdraft() {
		return r24_overdraft;
	}
	public void setR24_overdraft(BigDecimal r24_overdraft) {
		this.r24_overdraft = r24_overdraft;
	}
	public BigDecimal getR24_0_7_days() {
		return r24_0_7_days;
	}
	public void setR24_0_7_days(BigDecimal r24_0_7_days) {
		this.r24_0_7_days = r24_0_7_days;
	}
	public BigDecimal getR24_8_14_days() {
		return r24_8_14_days;
	}
	public void setR24_8_14_days(BigDecimal r24_8_14_days) {
		this.r24_8_14_days = r24_8_14_days;
	}
	public BigDecimal getR24_15_days_1_month() {
		return r24_15_days_1_month;
	}
	public void setR24_15_days_1_month(BigDecimal r24_15_days_1_month) {
		this.r24_15_days_1_month = r24_15_days_1_month;
	}
	public BigDecimal getR24_1_3_months() {
		return r24_1_3_months;
	}
	public void setR24_1_3_months(BigDecimal r24_1_3_months) {
		this.r24_1_3_months = r24_1_3_months;
	}
	public BigDecimal getR24_3_6_months() {
		return r24_3_6_months;
	}
	public void setR24_3_6_months(BigDecimal r24_3_6_months) {
		this.r24_3_6_months = r24_3_6_months;
	}
	public BigDecimal getR24_6_12_months() {
		return r24_6_12_months;
	}
	public void setR24_6_12_months(BigDecimal r24_6_12_months) {
		this.r24_6_12_months = r24_6_12_months;
	}
	public BigDecimal getR24_1_2_years() {
		return r24_1_2_years;
	}
	public void setR24_1_2_years(BigDecimal r24_1_2_years) {
		this.r24_1_2_years = r24_1_2_years;
	}
	public BigDecimal getR24_2_3_years() {
		return r24_2_3_years;
	}
	public void setR24_2_3_years(BigDecimal r24_2_3_years) {
		this.r24_2_3_years = r24_2_3_years;
	}
	public BigDecimal getR24_3_4_years() {
		return r24_3_4_years;
	}
	public void setR24_3_4_years(BigDecimal r24_3_4_years) {
		this.r24_3_4_years = r24_3_4_years;
	}
	public BigDecimal getR24_4_5_years() {
		return r24_4_5_years;
	}
	public void setR24_4_5_years(BigDecimal r24_4_5_years) {
		this.r24_4_5_years = r24_4_5_years;
	}
	public BigDecimal getR24_5_years() {
		return r24_5_years;
	}
	public void setR24_5_years(BigDecimal r24_5_years) {
		this.r24_5_years = r24_5_years;
	}
	public BigDecimal getR24_non_interest() {
		return r24_non_interest;
	}
	public void setR24_non_interest(BigDecimal r24_non_interest) {
		this.r24_non_interest = r24_non_interest;
	}
	public BigDecimal getR24_total() {
		return r24_total;
	}
	public void setR24_total(BigDecimal r24_total) {
		this.r24_total = r24_total;
	}
	public String getR25_product() {
		return r25_product;
	}
	public void setR25_product(String r25_product) {
		this.r25_product = r25_product;
	}
	public BigDecimal getR25_overdraft() {
		return r25_overdraft;
	}
	public void setR25_overdraft(BigDecimal r25_overdraft) {
		this.r25_overdraft = r25_overdraft;
	}
	public BigDecimal getR25_0_7_days() {
		return r25_0_7_days;
	}
	public void setR25_0_7_days(BigDecimal r25_0_7_days) {
		this.r25_0_7_days = r25_0_7_days;
	}
	public BigDecimal getR25_8_14_days() {
		return r25_8_14_days;
	}
	public void setR25_8_14_days(BigDecimal r25_8_14_days) {
		this.r25_8_14_days = r25_8_14_days;
	}
	public BigDecimal getR25_15_days_1_month() {
		return r25_15_days_1_month;
	}
	public void setR25_15_days_1_month(BigDecimal r25_15_days_1_month) {
		this.r25_15_days_1_month = r25_15_days_1_month;
	}
	public BigDecimal getR25_1_3_months() {
		return r25_1_3_months;
	}
	public void setR25_1_3_months(BigDecimal r25_1_3_months) {
		this.r25_1_3_months = r25_1_3_months;
	}
	public BigDecimal getR25_3_6_months() {
		return r25_3_6_months;
	}
	public void setR25_3_6_months(BigDecimal r25_3_6_months) {
		this.r25_3_6_months = r25_3_6_months;
	}
	public BigDecimal getR25_6_12_months() {
		return r25_6_12_months;
	}
	public void setR25_6_12_months(BigDecimal r25_6_12_months) {
		this.r25_6_12_months = r25_6_12_months;
	}
	public BigDecimal getR25_1_2_years() {
		return r25_1_2_years;
	}
	public void setR25_1_2_years(BigDecimal r25_1_2_years) {
		this.r25_1_2_years = r25_1_2_years;
	}
	public BigDecimal getR25_2_3_years() {
		return r25_2_3_years;
	}
	public void setR25_2_3_years(BigDecimal r25_2_3_years) {
		this.r25_2_3_years = r25_2_3_years;
	}
	public BigDecimal getR25_3_4_years() {
		return r25_3_4_years;
	}
	public void setR25_3_4_years(BigDecimal r25_3_4_years) {
		this.r25_3_4_years = r25_3_4_years;
	}
	public BigDecimal getR25_4_5_years() {
		return r25_4_5_years;
	}
	public void setR25_4_5_years(BigDecimal r25_4_5_years) {
		this.r25_4_5_years = r25_4_5_years;
	}
	public BigDecimal getR25_5_years() {
		return r25_5_years;
	}
	public void setR25_5_years(BigDecimal r25_5_years) {
		this.r25_5_years = r25_5_years;
	}
	public BigDecimal getR25_non_interest() {
		return r25_non_interest;
	}
	public void setR25_non_interest(BigDecimal r25_non_interest) {
		this.r25_non_interest = r25_non_interest;
	}
	public BigDecimal getR25_total() {
		return r25_total;
	}
	public void setR25_total(BigDecimal r25_total) {
		this.r25_total = r25_total;
	}
	public String getR26_product() {
		return r26_product;
	}
	public void setR26_product(String r26_product) {
		this.r26_product = r26_product;
	}
	public BigDecimal getR26_overdraft() {
		return r26_overdraft;
	}
	public void setR26_overdraft(BigDecimal r26_overdraft) {
		this.r26_overdraft = r26_overdraft;
	}
	public BigDecimal getR26_0_7_days() {
		return r26_0_7_days;
	}
	public void setR26_0_7_days(BigDecimal r26_0_7_days) {
		this.r26_0_7_days = r26_0_7_days;
	}
	public BigDecimal getR26_8_14_days() {
		return r26_8_14_days;
	}
	public void setR26_8_14_days(BigDecimal r26_8_14_days) {
		this.r26_8_14_days = r26_8_14_days;
	}
	public BigDecimal getR26_15_days_1_month() {
		return r26_15_days_1_month;
	}
	public void setR26_15_days_1_month(BigDecimal r26_15_days_1_month) {
		this.r26_15_days_1_month = r26_15_days_1_month;
	}
	public BigDecimal getR26_1_3_months() {
		return r26_1_3_months;
	}
	public void setR26_1_3_months(BigDecimal r26_1_3_months) {
		this.r26_1_3_months = r26_1_3_months;
	}
	public BigDecimal getR26_3_6_months() {
		return r26_3_6_months;
	}
	public void setR26_3_6_months(BigDecimal r26_3_6_months) {
		this.r26_3_6_months = r26_3_6_months;
	}
	public BigDecimal getR26_6_12_months() {
		return r26_6_12_months;
	}
	public void setR26_6_12_months(BigDecimal r26_6_12_months) {
		this.r26_6_12_months = r26_6_12_months;
	}
	public BigDecimal getR26_1_2_years() {
		return r26_1_2_years;
	}
	public void setR26_1_2_years(BigDecimal r26_1_2_years) {
		this.r26_1_2_years = r26_1_2_years;
	}
	public BigDecimal getR26_2_3_years() {
		return r26_2_3_years;
	}
	public void setR26_2_3_years(BigDecimal r26_2_3_years) {
		this.r26_2_3_years = r26_2_3_years;
	}
	public BigDecimal getR26_3_4_years() {
		return r26_3_4_years;
	}
	public void setR26_3_4_years(BigDecimal r26_3_4_years) {
		this.r26_3_4_years = r26_3_4_years;
	}
	public BigDecimal getR26_4_5_years() {
		return r26_4_5_years;
	}
	public void setR26_4_5_years(BigDecimal r26_4_5_years) {
		this.r26_4_5_years = r26_4_5_years;
	}
	public BigDecimal getR26_5_years() {
		return r26_5_years;
	}
	public void setR26_5_years(BigDecimal r26_5_years) {
		this.r26_5_years = r26_5_years;
	}
	public BigDecimal getR26_non_interest() {
		return r26_non_interest;
	}
	public void setR26_non_interest(BigDecimal r26_non_interest) {
		this.r26_non_interest = r26_non_interest;
	}
	public BigDecimal getR26_total() {
		return r26_total;
	}
	public void setR26_total(BigDecimal r26_total) {
		this.r26_total = r26_total;
	}
	public String getR27_product() {
		return r27_product;
	}
	public void setR27_product(String r27_product) {
		this.r27_product = r27_product;
	}
	public BigDecimal getR27_overdraft() {
		return r27_overdraft;
	}
	public void setR27_overdraft(BigDecimal r27_overdraft) {
		this.r27_overdraft = r27_overdraft;
	}
	public BigDecimal getR27_0_7_days() {
		return r27_0_7_days;
	}
	public void setR27_0_7_days(BigDecimal r27_0_7_days) {
		this.r27_0_7_days = r27_0_7_days;
	}
	public BigDecimal getR27_8_14_days() {
		return r27_8_14_days;
	}
	public void setR27_8_14_days(BigDecimal r27_8_14_days) {
		this.r27_8_14_days = r27_8_14_days;
	}
	public BigDecimal getR27_15_days_1_month() {
		return r27_15_days_1_month;
	}
	public void setR27_15_days_1_month(BigDecimal r27_15_days_1_month) {
		this.r27_15_days_1_month = r27_15_days_1_month;
	}
	public BigDecimal getR27_1_3_months() {
		return r27_1_3_months;
	}
	public void setR27_1_3_months(BigDecimal r27_1_3_months) {
		this.r27_1_3_months = r27_1_3_months;
	}
	public BigDecimal getR27_3_6_months() {
		return r27_3_6_months;
	}
	public void setR27_3_6_months(BigDecimal r27_3_6_months) {
		this.r27_3_6_months = r27_3_6_months;
	}
	public BigDecimal getR27_6_12_months() {
		return r27_6_12_months;
	}
	public void setR27_6_12_months(BigDecimal r27_6_12_months) {
		this.r27_6_12_months = r27_6_12_months;
	}
	public BigDecimal getR27_1_2_years() {
		return r27_1_2_years;
	}
	public void setR27_1_2_years(BigDecimal r27_1_2_years) {
		this.r27_1_2_years = r27_1_2_years;
	}
	public BigDecimal getR27_2_3_years() {
		return r27_2_3_years;
	}
	public void setR27_2_3_years(BigDecimal r27_2_3_years) {
		this.r27_2_3_years = r27_2_3_years;
	}
	public BigDecimal getR27_3_4_years() {
		return r27_3_4_years;
	}
	public void setR27_3_4_years(BigDecimal r27_3_4_years) {
		this.r27_3_4_years = r27_3_4_years;
	}
	public BigDecimal getR27_4_5_years() {
		return r27_4_5_years;
	}
	public void setR27_4_5_years(BigDecimal r27_4_5_years) {
		this.r27_4_5_years = r27_4_5_years;
	}
	public BigDecimal getR27_5_years() {
		return r27_5_years;
	}
	public void setR27_5_years(BigDecimal r27_5_years) {
		this.r27_5_years = r27_5_years;
	}
	public BigDecimal getR27_non_interest() {
		return r27_non_interest;
	}
	public void setR27_non_interest(BigDecimal r27_non_interest) {
		this.r27_non_interest = r27_non_interest;
	}
	public BigDecimal getR27_total() {
		return r27_total;
	}
	public void setR27_total(BigDecimal r27_total) {
		this.r27_total = r27_total;
	}
	public String getR28_product() {
		return r28_product;
	}
	public void setR28_product(String r28_product) {
		this.r28_product = r28_product;
	}
	public BigDecimal getR28_overdraft() {
		return r28_overdraft;
	}
	public void setR28_overdraft(BigDecimal r28_overdraft) {
		this.r28_overdraft = r28_overdraft;
	}
	public BigDecimal getR28_0_7_days() {
		return r28_0_7_days;
	}
	public void setR28_0_7_days(BigDecimal r28_0_7_days) {
		this.r28_0_7_days = r28_0_7_days;
	}
	public BigDecimal getR28_8_14_days() {
		return r28_8_14_days;
	}
	public void setR28_8_14_days(BigDecimal r28_8_14_days) {
		this.r28_8_14_days = r28_8_14_days;
	}
	public BigDecimal getR28_15_days_1_month() {
		return r28_15_days_1_month;
	}
	public void setR28_15_days_1_month(BigDecimal r28_15_days_1_month) {
		this.r28_15_days_1_month = r28_15_days_1_month;
	}
	public BigDecimal getR28_1_3_months() {
		return r28_1_3_months;
	}
	public void setR28_1_3_months(BigDecimal r28_1_3_months) {
		this.r28_1_3_months = r28_1_3_months;
	}
	public BigDecimal getR28_3_6_months() {
		return r28_3_6_months;
	}
	public void setR28_3_6_months(BigDecimal r28_3_6_months) {
		this.r28_3_6_months = r28_3_6_months;
	}
	public BigDecimal getR28_6_12_months() {
		return r28_6_12_months;
	}
	public void setR28_6_12_months(BigDecimal r28_6_12_months) {
		this.r28_6_12_months = r28_6_12_months;
	}
	public BigDecimal getR28_1_2_years() {
		return r28_1_2_years;
	}
	public void setR28_1_2_years(BigDecimal r28_1_2_years) {
		this.r28_1_2_years = r28_1_2_years;
	}
	public BigDecimal getR28_2_3_years() {
		return r28_2_3_years;
	}
	public void setR28_2_3_years(BigDecimal r28_2_3_years) {
		this.r28_2_3_years = r28_2_3_years;
	}
	public BigDecimal getR28_3_4_years() {
		return r28_3_4_years;
	}
	public void setR28_3_4_years(BigDecimal r28_3_4_years) {
		this.r28_3_4_years = r28_3_4_years;
	}
	public BigDecimal getR28_4_5_years() {
		return r28_4_5_years;
	}
	public void setR28_4_5_years(BigDecimal r28_4_5_years) {
		this.r28_4_5_years = r28_4_5_years;
	}
	public BigDecimal getR28_5_years() {
		return r28_5_years;
	}
	public void setR28_5_years(BigDecimal r28_5_years) {
		this.r28_5_years = r28_5_years;
	}
	public BigDecimal getR28_non_interest() {
		return r28_non_interest;
	}
	public void setR28_non_interest(BigDecimal r28_non_interest) {
		this.r28_non_interest = r28_non_interest;
	}
	public BigDecimal getR28_total() {
		return r28_total;
	}
	public void setR28_total(BigDecimal r28_total) {
		this.r28_total = r28_total;
	}
	public String getR29_product() {
		return r29_product;
	}
	public void setR29_product(String r29_product) {
		this.r29_product = r29_product;
	}
	public BigDecimal getR29_overdraft() {
		return r29_overdraft;
	}
	public void setR29_overdraft(BigDecimal r29_overdraft) {
		this.r29_overdraft = r29_overdraft;
	}
	public BigDecimal getR29_0_7_days() {
		return r29_0_7_days;
	}
	public void setR29_0_7_days(BigDecimal r29_0_7_days) {
		this.r29_0_7_days = r29_0_7_days;
	}
	public BigDecimal getR29_8_14_days() {
		return r29_8_14_days;
	}
	public void setR29_8_14_days(BigDecimal r29_8_14_days) {
		this.r29_8_14_days = r29_8_14_days;
	}
	public BigDecimal getR29_15_days_1_month() {
		return r29_15_days_1_month;
	}
	public void setR29_15_days_1_month(BigDecimal r29_15_days_1_month) {
		this.r29_15_days_1_month = r29_15_days_1_month;
	}
	public BigDecimal getR29_1_3_months() {
		return r29_1_3_months;
	}
	public void setR29_1_3_months(BigDecimal r29_1_3_months) {
		this.r29_1_3_months = r29_1_3_months;
	}
	public BigDecimal getR29_3_6_months() {
		return r29_3_6_months;
	}
	public void setR29_3_6_months(BigDecimal r29_3_6_months) {
		this.r29_3_6_months = r29_3_6_months;
	}
	public BigDecimal getR29_6_12_months() {
		return r29_6_12_months;
	}
	public void setR29_6_12_months(BigDecimal r29_6_12_months) {
		this.r29_6_12_months = r29_6_12_months;
	}
	public BigDecimal getR29_1_2_years() {
		return r29_1_2_years;
	}
	public void setR29_1_2_years(BigDecimal r29_1_2_years) {
		this.r29_1_2_years = r29_1_2_years;
	}
	public BigDecimal getR29_2_3_years() {
		return r29_2_3_years;
	}
	public void setR29_2_3_years(BigDecimal r29_2_3_years) {
		this.r29_2_3_years = r29_2_3_years;
	}
	public BigDecimal getR29_3_4_years() {
		return r29_3_4_years;
	}
	public void setR29_3_4_years(BigDecimal r29_3_4_years) {
		this.r29_3_4_years = r29_3_4_years;
	}
	public BigDecimal getR29_4_5_years() {
		return r29_4_5_years;
	}
	public void setR29_4_5_years(BigDecimal r29_4_5_years) {
		this.r29_4_5_years = r29_4_5_years;
	}
	public BigDecimal getR29_5_years() {
		return r29_5_years;
	}
	public void setR29_5_years(BigDecimal r29_5_years) {
		this.r29_5_years = r29_5_years;
	}
	public BigDecimal getR29_non_interest() {
		return r29_non_interest;
	}
	public void setR29_non_interest(BigDecimal r29_non_interest) {
		this.r29_non_interest = r29_non_interest;
	}
	public BigDecimal getR29_total() {
		return r29_total;
	}
	public void setR29_total(BigDecimal r29_total) {
		this.r29_total = r29_total;
	}
	public String getR30_product() {
		return r30_product;
	}
	public void setR30_product(String r30_product) {
		this.r30_product = r30_product;
	}
	public BigDecimal getR30_overdraft() {
		return r30_overdraft;
	}
	public void setR30_overdraft(BigDecimal r30_overdraft) {
		this.r30_overdraft = r30_overdraft;
	}
	public BigDecimal getR30_0_7_days() {
		return r30_0_7_days;
	}
	public void setR30_0_7_days(BigDecimal r30_0_7_days) {
		this.r30_0_7_days = r30_0_7_days;
	}
	public BigDecimal getR30_8_14_days() {
		return r30_8_14_days;
	}
	public void setR30_8_14_days(BigDecimal r30_8_14_days) {
		this.r30_8_14_days = r30_8_14_days;
	}
	public BigDecimal getR30_15_days_1_month() {
		return r30_15_days_1_month;
	}
	public void setR30_15_days_1_month(BigDecimal r30_15_days_1_month) {
		this.r30_15_days_1_month = r30_15_days_1_month;
	}
	public BigDecimal getR30_1_3_months() {
		return r30_1_3_months;
	}
	public void setR30_1_3_months(BigDecimal r30_1_3_months) {
		this.r30_1_3_months = r30_1_3_months;
	}
	public BigDecimal getR30_3_6_months() {
		return r30_3_6_months;
	}
	public void setR30_3_6_months(BigDecimal r30_3_6_months) {
		this.r30_3_6_months = r30_3_6_months;
	}
	public BigDecimal getR30_6_12_months() {
		return r30_6_12_months;
	}
	public void setR30_6_12_months(BigDecimal r30_6_12_months) {
		this.r30_6_12_months = r30_6_12_months;
	}
	public BigDecimal getR30_1_2_years() {
		return r30_1_2_years;
	}
	public void setR30_1_2_years(BigDecimal r30_1_2_years) {
		this.r30_1_2_years = r30_1_2_years;
	}
	public BigDecimal getR30_2_3_years() {
		return r30_2_3_years;
	}
	public void setR30_2_3_years(BigDecimal r30_2_3_years) {
		this.r30_2_3_years = r30_2_3_years;
	}
	public BigDecimal getR30_3_4_years() {
		return r30_3_4_years;
	}
	public void setR30_3_4_years(BigDecimal r30_3_4_years) {
		this.r30_3_4_years = r30_3_4_years;
	}
	public BigDecimal getR30_4_5_years() {
		return r30_4_5_years;
	}
	public void setR30_4_5_years(BigDecimal r30_4_5_years) {
		this.r30_4_5_years = r30_4_5_years;
	}
	public BigDecimal getR30_5_years() {
		return r30_5_years;
	}
	public void setR30_5_years(BigDecimal r30_5_years) {
		this.r30_5_years = r30_5_years;
	}
	public BigDecimal getR30_non_interest() {
		return r30_non_interest;
	}
	public void setR30_non_interest(BigDecimal r30_non_interest) {
		this.r30_non_interest = r30_non_interest;
	}
	public BigDecimal getR30_total() {
		return r30_total;
	}
	public void setR30_total(BigDecimal r30_total) {
		this.r30_total = r30_total;
	}
	public String getR31_product() {
		return r31_product;
	}
	public void setR31_product(String r31_product) {
		this.r31_product = r31_product;
	}
	public BigDecimal getR31_overdraft() {
		return r31_overdraft;
	}
	public void setR31_overdraft(BigDecimal r31_overdraft) {
		this.r31_overdraft = r31_overdraft;
	}
	public BigDecimal getR31_0_7_days() {
		return r31_0_7_days;
	}
	public void setR31_0_7_days(BigDecimal r31_0_7_days) {
		this.r31_0_7_days = r31_0_7_days;
	}
	public BigDecimal getR31_8_14_days() {
		return r31_8_14_days;
	}
	public void setR31_8_14_days(BigDecimal r31_8_14_days) {
		this.r31_8_14_days = r31_8_14_days;
	}
	public BigDecimal getR31_15_days_1_month() {
		return r31_15_days_1_month;
	}
	public void setR31_15_days_1_month(BigDecimal r31_15_days_1_month) {
		this.r31_15_days_1_month = r31_15_days_1_month;
	}
	public BigDecimal getR31_1_3_months() {
		return r31_1_3_months;
	}
	public void setR31_1_3_months(BigDecimal r31_1_3_months) {
		this.r31_1_3_months = r31_1_3_months;
	}
	public BigDecimal getR31_3_6_months() {
		return r31_3_6_months;
	}
	public void setR31_3_6_months(BigDecimal r31_3_6_months) {
		this.r31_3_6_months = r31_3_6_months;
	}
	public BigDecimal getR31_6_12_months() {
		return r31_6_12_months;
	}
	public void setR31_6_12_months(BigDecimal r31_6_12_months) {
		this.r31_6_12_months = r31_6_12_months;
	}
	public BigDecimal getR31_1_2_years() {
		return r31_1_2_years;
	}
	public void setR31_1_2_years(BigDecimal r31_1_2_years) {
		this.r31_1_2_years = r31_1_2_years;
	}
	public BigDecimal getR31_2_3_years() {
		return r31_2_3_years;
	}
	public void setR31_2_3_years(BigDecimal r31_2_3_years) {
		this.r31_2_3_years = r31_2_3_years;
	}
	public BigDecimal getR31_3_4_years() {
		return r31_3_4_years;
	}
	public void setR31_3_4_years(BigDecimal r31_3_4_years) {
		this.r31_3_4_years = r31_3_4_years;
	}
	public BigDecimal getR31_4_5_years() {
		return r31_4_5_years;
	}
	public void setR31_4_5_years(BigDecimal r31_4_5_years) {
		this.r31_4_5_years = r31_4_5_years;
	}
	public BigDecimal getR31_5_years() {
		return r31_5_years;
	}
	public void setR31_5_years(BigDecimal r31_5_years) {
		this.r31_5_years = r31_5_years;
	}
	public BigDecimal getR31_non_interest() {
		return r31_non_interest;
	}
	public void setR31_non_interest(BigDecimal r31_non_interest) {
		this.r31_non_interest = r31_non_interest;
	}
	public BigDecimal getR31_total() {
		return r31_total;
	}
	public void setR31_total(BigDecimal r31_total) {
		this.r31_total = r31_total;
	}
	public String getR32_product() {
		return r32_product;
	}
	public void setR32_product(String r32_product) {
		this.r32_product = r32_product;
	}
	public BigDecimal getR32_overdraft() {
		return r32_overdraft;
	}
	public void setR32_overdraft(BigDecimal r32_overdraft) {
		this.r32_overdraft = r32_overdraft;
	}
	public BigDecimal getR32_0_7_days() {
		return r32_0_7_days;
	}
	public void setR32_0_7_days(BigDecimal r32_0_7_days) {
		this.r32_0_7_days = r32_0_7_days;
	}
	public BigDecimal getR32_8_14_days() {
		return r32_8_14_days;
	}
	public void setR32_8_14_days(BigDecimal r32_8_14_days) {
		this.r32_8_14_days = r32_8_14_days;
	}
	public BigDecimal getR32_15_days_1_month() {
		return r32_15_days_1_month;
	}
	public void setR32_15_days_1_month(BigDecimal r32_15_days_1_month) {
		this.r32_15_days_1_month = r32_15_days_1_month;
	}
	public BigDecimal getR32_1_3_months() {
		return r32_1_3_months;
	}
	public void setR32_1_3_months(BigDecimal r32_1_3_months) {
		this.r32_1_3_months = r32_1_3_months;
	}
	public BigDecimal getR32_3_6_months() {
		return r32_3_6_months;
	}
	public void setR32_3_6_months(BigDecimal r32_3_6_months) {
		this.r32_3_6_months = r32_3_6_months;
	}
	public BigDecimal getR32_6_12_months() {
		return r32_6_12_months;
	}
	public void setR32_6_12_months(BigDecimal r32_6_12_months) {
		this.r32_6_12_months = r32_6_12_months;
	}
	public BigDecimal getR32_1_2_years() {
		return r32_1_2_years;
	}
	public void setR32_1_2_years(BigDecimal r32_1_2_years) {
		this.r32_1_2_years = r32_1_2_years;
	}
	public BigDecimal getR32_2_3_years() {
		return r32_2_3_years;
	}
	public void setR32_2_3_years(BigDecimal r32_2_3_years) {
		this.r32_2_3_years = r32_2_3_years;
	}
	public BigDecimal getR32_3_4_years() {
		return r32_3_4_years;
	}
	public void setR32_3_4_years(BigDecimal r32_3_4_years) {
		this.r32_3_4_years = r32_3_4_years;
	}
	public BigDecimal getR32_4_5_years() {
		return r32_4_5_years;
	}
	public void setR32_4_5_years(BigDecimal r32_4_5_years) {
		this.r32_4_5_years = r32_4_5_years;
	}
	public BigDecimal getR32_5_years() {
		return r32_5_years;
	}
	public void setR32_5_years(BigDecimal r32_5_years) {
		this.r32_5_years = r32_5_years;
	}
	public BigDecimal getR32_non_interest() {
		return r32_non_interest;
	}
	public void setR32_non_interest(BigDecimal r32_non_interest) {
		this.r32_non_interest = r32_non_interest;
	}
	public BigDecimal getR32_total() {
		return r32_total;
	}
	public void setR32_total(BigDecimal r32_total) {
		this.r32_total = r32_total;
	}
	public String getRta_product() {
		return rta_product;
	}
	public void setRta_product(String rta_product) {
		this.rta_product = rta_product;
	}
	public BigDecimal getRta_overdraft() {
		return rta_overdraft;
	}
	public void setRta_overdraft(BigDecimal rta_overdraft) {
		this.rta_overdraft = rta_overdraft;
	}
	public BigDecimal getRta_0_7_days() {
		return rta_0_7_days;
	}
	public void setRta_0_7_days(BigDecimal rta_0_7_days) {
		this.rta_0_7_days = rta_0_7_days;
	}
	public BigDecimal getRta_8_14_days() {
		return rta_8_14_days;
	}
	public void setRta_8_14_days(BigDecimal rta_8_14_days) {
		this.rta_8_14_days = rta_8_14_days;
	}
	public BigDecimal getRta_15_days_1_month() {
		return rta_15_days_1_month;
	}
	public void setRta_15_days_1_month(BigDecimal rta_15_days_1_month) {
		this.rta_15_days_1_month = rta_15_days_1_month;
	}
	public BigDecimal getRta_1_3_months() {
		return rta_1_3_months;
	}
	public void setRta_1_3_months(BigDecimal rta_1_3_months) {
		this.rta_1_3_months = rta_1_3_months;
	}
	public BigDecimal getRta_3_6_months() {
		return rta_3_6_months;
	}
	public void setRta_3_6_months(BigDecimal rta_3_6_months) {
		this.rta_3_6_months = rta_3_6_months;
	}
	public BigDecimal getRta_6_12_months() {
		return rta_6_12_months;
	}
	public void setRta_6_12_months(BigDecimal rta_6_12_months) {
		this.rta_6_12_months = rta_6_12_months;
	}
	public BigDecimal getRta_1_2_years() {
		return rta_1_2_years;
	}
	public void setRta_1_2_years(BigDecimal rta_1_2_years) {
		this.rta_1_2_years = rta_1_2_years;
	}
	public BigDecimal getRta_2_3_years() {
		return rta_2_3_years;
	}
	public void setRta_2_3_years(BigDecimal rta_2_3_years) {
		this.rta_2_3_years = rta_2_3_years;
	}
	public BigDecimal getRta_3_4_years() {
		return rta_3_4_years;
	}
	public void setRta_3_4_years(BigDecimal rta_3_4_years) {
		this.rta_3_4_years = rta_3_4_years;
	}
	public BigDecimal getRta_4_5_years() {
		return rta_4_5_years;
	}
	public void setRta_4_5_years(BigDecimal rta_4_5_years) {
		this.rta_4_5_years = rta_4_5_years;
	}
	public BigDecimal getRta_5_years() {
		return rta_5_years;
	}
	public void setRta_5_years(BigDecimal rta_5_years) {
		this.rta_5_years = rta_5_years;
	}
	public BigDecimal getRta_non_interest() {
		return rta_non_interest;
	}
	public void setRta_non_interest(BigDecimal rta_non_interest) {
		this.rta_non_interest = rta_non_interest;
	}
	public BigDecimal getRta_total() {
		return rta_total;
	}
	public void setRta_total(BigDecimal rta_total) {
		this.rta_total = rta_total;
	}
	public String getRh6_product() {
		return rh6_product;
	}
	public void setRh6_product(String rh6_product) {
		this.rh6_product = rh6_product;
	}
	public BigDecimal getRh6_overdraft() {
		return rh6_overdraft;
	}
	public void setRh6_overdraft(BigDecimal rh6_overdraft) {
		this.rh6_overdraft = rh6_overdraft;
	}
	public BigDecimal getRh6_0_7_days() {
		return rh6_0_7_days;
	}
	public void setRh6_0_7_days(BigDecimal rh6_0_7_days) {
		this.rh6_0_7_days = rh6_0_7_days;
	}
	public BigDecimal getRh6_8_14_days() {
		return rh6_8_14_days;
	}
	public void setRh6_8_14_days(BigDecimal rh6_8_14_days) {
		this.rh6_8_14_days = rh6_8_14_days;
	}
	public BigDecimal getRh6_15_days_1_month() {
		return rh6_15_days_1_month;
	}
	public void setRh6_15_days_1_month(BigDecimal rh6_15_days_1_month) {
		this.rh6_15_days_1_month = rh6_15_days_1_month;
	}
	public BigDecimal getRh6_1_3_months() {
		return rh6_1_3_months;
	}
	public void setRh6_1_3_months(BigDecimal rh6_1_3_months) {
		this.rh6_1_3_months = rh6_1_3_months;
	}
	public BigDecimal getRh6_3_6_months() {
		return rh6_3_6_months;
	}
	public void setRh6_3_6_months(BigDecimal rh6_3_6_months) {
		this.rh6_3_6_months = rh6_3_6_months;
	}
	public BigDecimal getRh6_6_12_months() {
		return rh6_6_12_months;
	}
	public void setRh6_6_12_months(BigDecimal rh6_6_12_months) {
		this.rh6_6_12_months = rh6_6_12_months;
	}
	public BigDecimal getRh6_1_2_years() {
		return rh6_1_2_years;
	}
	public void setRh6_1_2_years(BigDecimal rh6_1_2_years) {
		this.rh6_1_2_years = rh6_1_2_years;
	}
	public BigDecimal getRh6_2_3_years() {
		return rh6_2_3_years;
	}
	public void setRh6_2_3_years(BigDecimal rh6_2_3_years) {
		this.rh6_2_3_years = rh6_2_3_years;
	}
	public BigDecimal getRh6_3_4_years() {
		return rh6_3_4_years;
	}
	public void setRh6_3_4_years(BigDecimal rh6_3_4_years) {
		this.rh6_3_4_years = rh6_3_4_years;
	}
	public BigDecimal getRh6_4_5_years() {
		return rh6_4_5_years;
	}
	public void setRh6_4_5_years(BigDecimal rh6_4_5_years) {
		this.rh6_4_5_years = rh6_4_5_years;
	}
	public BigDecimal getRh6_5_years() {
		return rh6_5_years;
	}
	public void setRh6_5_years(BigDecimal rh6_5_years) {
		this.rh6_5_years = rh6_5_years;
	}
	public BigDecimal getRh6_non_interest() {
		return rh6_non_interest;
	}
	public void setRh6_non_interest(BigDecimal rh6_non_interest) {
		this.rh6_non_interest = rh6_non_interest;
	}
	public BigDecimal getRh6_total() {
		return rh6_total;
	}
	public void setRh6_total(BigDecimal rh6_total) {
		this.rh6_total = rh6_total;
	}
	public String getR33_product() {
		return r33_product;
	}
	public void setR33_product(String r33_product) {
		this.r33_product = r33_product;
	}
	public BigDecimal getR33_overdraft() {
		return r33_overdraft;
	}
	public void setR33_overdraft(BigDecimal r33_overdraft) {
		this.r33_overdraft = r33_overdraft;
	}
	public BigDecimal getR33_0_7_days() {
		return r33_0_7_days;
	}
	public void setR33_0_7_days(BigDecimal r33_0_7_days) {
		this.r33_0_7_days = r33_0_7_days;
	}
	public BigDecimal getR33_8_14_days() {
		return r33_8_14_days;
	}
	public void setR33_8_14_days(BigDecimal r33_8_14_days) {
		this.r33_8_14_days = r33_8_14_days;
	}
	public BigDecimal getR33_15_days_1_month() {
		return r33_15_days_1_month;
	}
	public void setR33_15_days_1_month(BigDecimal r33_15_days_1_month) {
		this.r33_15_days_1_month = r33_15_days_1_month;
	}
	public BigDecimal getR33_1_3_months() {
		return r33_1_3_months;
	}
	public void setR33_1_3_months(BigDecimal r33_1_3_months) {
		this.r33_1_3_months = r33_1_3_months;
	}
	public BigDecimal getR33_3_6_months() {
		return r33_3_6_months;
	}
	public void setR33_3_6_months(BigDecimal r33_3_6_months) {
		this.r33_3_6_months = r33_3_6_months;
	}
	public BigDecimal getR33_6_12_months() {
		return r33_6_12_months;
	}
	public void setR33_6_12_months(BigDecimal r33_6_12_months) {
		this.r33_6_12_months = r33_6_12_months;
	}
	public BigDecimal getR33_1_2_years() {
		return r33_1_2_years;
	}
	public void setR33_1_2_years(BigDecimal r33_1_2_years) {
		this.r33_1_2_years = r33_1_2_years;
	}
	public BigDecimal getR33_2_3_years() {
		return r33_2_3_years;
	}
	public void setR33_2_3_years(BigDecimal r33_2_3_years) {
		this.r33_2_3_years = r33_2_3_years;
	}
	public BigDecimal getR33_3_4_years() {
		return r33_3_4_years;
	}
	public void setR33_3_4_years(BigDecimal r33_3_4_years) {
		this.r33_3_4_years = r33_3_4_years;
	}
	public BigDecimal getR33_4_5_years() {
		return r33_4_5_years;
	}
	public void setR33_4_5_years(BigDecimal r33_4_5_years) {
		this.r33_4_5_years = r33_4_5_years;
	}
	public BigDecimal getR33_5_years() {
		return r33_5_years;
	}
	public void setR33_5_years(BigDecimal r33_5_years) {
		this.r33_5_years = r33_5_years;
	}
	public BigDecimal getR33_non_interest() {
		return r33_non_interest;
	}
	public void setR33_non_interest(BigDecimal r33_non_interest) {
		this.r33_non_interest = r33_non_interest;
	}
	public BigDecimal getR33_total() {
		return r33_total;
	}
	public void setR33_total(BigDecimal r33_total) {
		this.r33_total = r33_total;
	}
	public String getR34_product() {
		return r34_product;
	}
	public void setR34_product(String r34_product) {
		this.r34_product = r34_product;
	}
	public BigDecimal getR34_overdraft() {
		return r34_overdraft;
	}
	public void setR34_overdraft(BigDecimal r34_overdraft) {
		this.r34_overdraft = r34_overdraft;
	}
	public BigDecimal getR34_0_7_days() {
		return r34_0_7_days;
	}
	public void setR34_0_7_days(BigDecimal r34_0_7_days) {
		this.r34_0_7_days = r34_0_7_days;
	}
	public BigDecimal getR34_8_14_days() {
		return r34_8_14_days;
	}
	public void setR34_8_14_days(BigDecimal r34_8_14_days) {
		this.r34_8_14_days = r34_8_14_days;
	}
	public BigDecimal getR34_15_days_1_month() {
		return r34_15_days_1_month;
	}
	public void setR34_15_days_1_month(BigDecimal r34_15_days_1_month) {
		this.r34_15_days_1_month = r34_15_days_1_month;
	}
	public BigDecimal getR34_1_3_months() {
		return r34_1_3_months;
	}
	public void setR34_1_3_months(BigDecimal r34_1_3_months) {
		this.r34_1_3_months = r34_1_3_months;
	}
	public BigDecimal getR34_3_6_months() {
		return r34_3_6_months;
	}
	public void setR34_3_6_months(BigDecimal r34_3_6_months) {
		this.r34_3_6_months = r34_3_6_months;
	}
	public BigDecimal getR34_6_12_months() {
		return r34_6_12_months;
	}
	public void setR34_6_12_months(BigDecimal r34_6_12_months) {
		this.r34_6_12_months = r34_6_12_months;
	}
	public BigDecimal getR34_1_2_years() {
		return r34_1_2_years;
	}
	public void setR34_1_2_years(BigDecimal r34_1_2_years) {
		this.r34_1_2_years = r34_1_2_years;
	}
	public BigDecimal getR34_2_3_years() {
		return r34_2_3_years;
	}
	public void setR34_2_3_years(BigDecimal r34_2_3_years) {
		this.r34_2_3_years = r34_2_3_years;
	}
	public BigDecimal getR34_3_4_years() {
		return r34_3_4_years;
	}
	public void setR34_3_4_years(BigDecimal r34_3_4_years) {
		this.r34_3_4_years = r34_3_4_years;
	}
	public BigDecimal getR34_4_5_years() {
		return r34_4_5_years;
	}
	public void setR34_4_5_years(BigDecimal r34_4_5_years) {
		this.r34_4_5_years = r34_4_5_years;
	}
	public BigDecimal getR34_5_years() {
		return r34_5_years;
	}
	public void setR34_5_years(BigDecimal r34_5_years) {
		this.r34_5_years = r34_5_years;
	}
	public BigDecimal getR34_non_interest() {
		return r34_non_interest;
	}
	public void setR34_non_interest(BigDecimal r34_non_interest) {
		this.r34_non_interest = r34_non_interest;
	}
	public BigDecimal getR34_total() {
		return r34_total;
	}
	public void setR34_total(BigDecimal r34_total) {
		this.r34_total = r34_total;
	}
	public String getR35_product() {
		return r35_product;
	}
	public void setR35_product(String r35_product) {
		this.r35_product = r35_product;
	}
	public BigDecimal getR35_overdraft() {
		return r35_overdraft;
	}
	public void setR35_overdraft(BigDecimal r35_overdraft) {
		this.r35_overdraft = r35_overdraft;
	}
	public BigDecimal getR35_0_7_days() {
		return r35_0_7_days;
	}
	public void setR35_0_7_days(BigDecimal r35_0_7_days) {
		this.r35_0_7_days = r35_0_7_days;
	}
	public BigDecimal getR35_8_14_days() {
		return r35_8_14_days;
	}
	public void setR35_8_14_days(BigDecimal r35_8_14_days) {
		this.r35_8_14_days = r35_8_14_days;
	}
	public BigDecimal getR35_15_days_1_month() {
		return r35_15_days_1_month;
	}
	public void setR35_15_days_1_month(BigDecimal r35_15_days_1_month) {
		this.r35_15_days_1_month = r35_15_days_1_month;
	}
	public BigDecimal getR35_1_3_months() {
		return r35_1_3_months;
	}
	public void setR35_1_3_months(BigDecimal r35_1_3_months) {
		this.r35_1_3_months = r35_1_3_months;
	}
	public BigDecimal getR35_3_6_months() {
		return r35_3_6_months;
	}
	public void setR35_3_6_months(BigDecimal r35_3_6_months) {
		this.r35_3_6_months = r35_3_6_months;
	}
	public BigDecimal getR35_6_12_months() {
		return r35_6_12_months;
	}
	public void setR35_6_12_months(BigDecimal r35_6_12_months) {
		this.r35_6_12_months = r35_6_12_months;
	}
	public BigDecimal getR35_1_2_years() {
		return r35_1_2_years;
	}
	public void setR35_1_2_years(BigDecimal r35_1_2_years) {
		this.r35_1_2_years = r35_1_2_years;
	}
	public BigDecimal getR35_2_3_years() {
		return r35_2_3_years;
	}
	public void setR35_2_3_years(BigDecimal r35_2_3_years) {
		this.r35_2_3_years = r35_2_3_years;
	}
	public BigDecimal getR35_3_4_years() {
		return r35_3_4_years;
	}
	public void setR35_3_4_years(BigDecimal r35_3_4_years) {
		this.r35_3_4_years = r35_3_4_years;
	}
	public BigDecimal getR35_4_5_years() {
		return r35_4_5_years;
	}
	public void setR35_4_5_years(BigDecimal r35_4_5_years) {
		this.r35_4_5_years = r35_4_5_years;
	}
	public BigDecimal getR35_5_years() {
		return r35_5_years;
	}
	public void setR35_5_years(BigDecimal r35_5_years) {
		this.r35_5_years = r35_5_years;
	}
	public BigDecimal getR35_non_interest() {
		return r35_non_interest;
	}
	public void setR35_non_interest(BigDecimal r35_non_interest) {
		this.r35_non_interest = r35_non_interest;
	}
	public BigDecimal getR35_total() {
		return r35_total;
	}
	public void setR35_total(BigDecimal r35_total) {
		this.r35_total = r35_total;
	}
	public String getR36_product() {
		return r36_product;
	}
	public void setR36_product(String r36_product) {
		this.r36_product = r36_product;
	}
	public BigDecimal getR36_overdraft() {
		return r36_overdraft;
	}
	public void setR36_overdraft(BigDecimal r36_overdraft) {
		this.r36_overdraft = r36_overdraft;
	}
	public BigDecimal getR36_0_7_days() {
		return r36_0_7_days;
	}
	public void setR36_0_7_days(BigDecimal r36_0_7_days) {
		this.r36_0_7_days = r36_0_7_days;
	}
	public BigDecimal getR36_8_14_days() {
		return r36_8_14_days;
	}
	public void setR36_8_14_days(BigDecimal r36_8_14_days) {
		this.r36_8_14_days = r36_8_14_days;
	}
	public BigDecimal getR36_15_days_1_month() {
		return r36_15_days_1_month;
	}
	public void setR36_15_days_1_month(BigDecimal r36_15_days_1_month) {
		this.r36_15_days_1_month = r36_15_days_1_month;
	}
	public BigDecimal getR36_1_3_months() {
		return r36_1_3_months;
	}
	public void setR36_1_3_months(BigDecimal r36_1_3_months) {
		this.r36_1_3_months = r36_1_3_months;
	}
	public BigDecimal getR36_3_6_months() {
		return r36_3_6_months;
	}
	public void setR36_3_6_months(BigDecimal r36_3_6_months) {
		this.r36_3_6_months = r36_3_6_months;
	}
	public BigDecimal getR36_6_12_months() {
		return r36_6_12_months;
	}
	public void setR36_6_12_months(BigDecimal r36_6_12_months) {
		this.r36_6_12_months = r36_6_12_months;
	}
	public BigDecimal getR36_1_2_years() {
		return r36_1_2_years;
	}
	public void setR36_1_2_years(BigDecimal r36_1_2_years) {
		this.r36_1_2_years = r36_1_2_years;
	}
	public BigDecimal getR36_2_3_years() {
		return r36_2_3_years;
	}
	public void setR36_2_3_years(BigDecimal r36_2_3_years) {
		this.r36_2_3_years = r36_2_3_years;
	}
	public BigDecimal getR36_3_4_years() {
		return r36_3_4_years;
	}
	public void setR36_3_4_years(BigDecimal r36_3_4_years) {
		this.r36_3_4_years = r36_3_4_years;
	}
	public BigDecimal getR36_4_5_years() {
		return r36_4_5_years;
	}
	public void setR36_4_5_years(BigDecimal r36_4_5_years) {
		this.r36_4_5_years = r36_4_5_years;
	}
	public BigDecimal getR36_5_years() {
		return r36_5_years;
	}
	public void setR36_5_years(BigDecimal r36_5_years) {
		this.r36_5_years = r36_5_years;
	}
	public BigDecimal getR36_non_interest() {
		return r36_non_interest;
	}
	public void setR36_non_interest(BigDecimal r36_non_interest) {
		this.r36_non_interest = r36_non_interest;
	}
	public BigDecimal getR36_total() {
		return r36_total;
	}
	public void setR36_total(BigDecimal r36_total) {
		this.r36_total = r36_total;
	}
	public String getR37_product() {
		return r37_product;
	}
	public void setR37_product(String r37_product) {
		this.r37_product = r37_product;
	}
	public BigDecimal getR37_overdraft() {
		return r37_overdraft;
	}
	public void setR37_overdraft(BigDecimal r37_overdraft) {
		this.r37_overdraft = r37_overdraft;
	}
	public BigDecimal getR37_0_7_days() {
		return r37_0_7_days;
	}
	public void setR37_0_7_days(BigDecimal r37_0_7_days) {
		this.r37_0_7_days = r37_0_7_days;
	}
	public BigDecimal getR37_8_14_days() {
		return r37_8_14_days;
	}
	public void setR37_8_14_days(BigDecimal r37_8_14_days) {
		this.r37_8_14_days = r37_8_14_days;
	}
	public BigDecimal getR37_15_days_1_month() {
		return r37_15_days_1_month;
	}
	public void setR37_15_days_1_month(BigDecimal r37_15_days_1_month) {
		this.r37_15_days_1_month = r37_15_days_1_month;
	}
	public BigDecimal getR37_1_3_months() {
		return r37_1_3_months;
	}
	public void setR37_1_3_months(BigDecimal r37_1_3_months) {
		this.r37_1_3_months = r37_1_3_months;
	}
	public BigDecimal getR37_3_6_months() {
		return r37_3_6_months;
	}
	public void setR37_3_6_months(BigDecimal r37_3_6_months) {
		this.r37_3_6_months = r37_3_6_months;
	}
	public BigDecimal getR37_6_12_months() {
		return r37_6_12_months;
	}
	public void setR37_6_12_months(BigDecimal r37_6_12_months) {
		this.r37_6_12_months = r37_6_12_months;
	}
	public BigDecimal getR37_1_2_years() {
		return r37_1_2_years;
	}
	public void setR37_1_2_years(BigDecimal r37_1_2_years) {
		this.r37_1_2_years = r37_1_2_years;
	}
	public BigDecimal getR37_2_3_years() {
		return r37_2_3_years;
	}
	public void setR37_2_3_years(BigDecimal r37_2_3_years) {
		this.r37_2_3_years = r37_2_3_years;
	}
	public BigDecimal getR37_3_4_years() {
		return r37_3_4_years;
	}
	public void setR37_3_4_years(BigDecimal r37_3_4_years) {
		this.r37_3_4_years = r37_3_4_years;
	}
	public BigDecimal getR37_4_5_years() {
		return r37_4_5_years;
	}
	public void setR37_4_5_years(BigDecimal r37_4_5_years) {
		this.r37_4_5_years = r37_4_5_years;
	}
	public BigDecimal getR37_5_years() {
		return r37_5_years;
	}
	public void setR37_5_years(BigDecimal r37_5_years) {
		this.r37_5_years = r37_5_years;
	}
	public BigDecimal getR37_non_interest() {
		return r37_non_interest;
	}
	public void setR37_non_interest(BigDecimal r37_non_interest) {
		this.r37_non_interest = r37_non_interest;
	}
	public BigDecimal getR37_total() {
		return r37_total;
	}
	public void setR37_total(BigDecimal r37_total) {
		this.r37_total = r37_total;
	}
	public String getRh7_product() {
		return rh7_product;
	}
	public void setRh7_product(String rh7_product) {
		this.rh7_product = rh7_product;
	}
	public BigDecimal getRh7_overdraft() {
		return rh7_overdraft;
	}
	public void setRh7_overdraft(BigDecimal rh7_overdraft) {
		this.rh7_overdraft = rh7_overdraft;
	}
	public BigDecimal getRh7_0_7_days() {
		return rh7_0_7_days;
	}
	public void setRh7_0_7_days(BigDecimal rh7_0_7_days) {
		this.rh7_0_7_days = rh7_0_7_days;
	}
	public BigDecimal getRh7_8_14_days() {
		return rh7_8_14_days;
	}
	public void setRh7_8_14_days(BigDecimal rh7_8_14_days) {
		this.rh7_8_14_days = rh7_8_14_days;
	}
	public BigDecimal getRh7_15_days_1_month() {
		return rh7_15_days_1_month;
	}
	public void setRh7_15_days_1_month(BigDecimal rh7_15_days_1_month) {
		this.rh7_15_days_1_month = rh7_15_days_1_month;
	}
	public BigDecimal getRh7_1_3_months() {
		return rh7_1_3_months;
	}
	public void setRh7_1_3_months(BigDecimal rh7_1_3_months) {
		this.rh7_1_3_months = rh7_1_3_months;
	}
	public BigDecimal getRh7_3_6_months() {
		return rh7_3_6_months;
	}
	public void setRh7_3_6_months(BigDecimal rh7_3_6_months) {
		this.rh7_3_6_months = rh7_3_6_months;
	}
	public BigDecimal getRh7_6_12_months() {
		return rh7_6_12_months;
	}
	public void setRh7_6_12_months(BigDecimal rh7_6_12_months) {
		this.rh7_6_12_months = rh7_6_12_months;
	}
	public BigDecimal getRh7_1_2_years() {
		return rh7_1_2_years;
	}
	public void setRh7_1_2_years(BigDecimal rh7_1_2_years) {
		this.rh7_1_2_years = rh7_1_2_years;
	}
	public BigDecimal getRh7_2_3_years() {
		return rh7_2_3_years;
	}
	public void setRh7_2_3_years(BigDecimal rh7_2_3_years) {
		this.rh7_2_3_years = rh7_2_3_years;
	}
	public BigDecimal getRh7_3_4_years() {
		return rh7_3_4_years;
	}
	public void setRh7_3_4_years(BigDecimal rh7_3_4_years) {
		this.rh7_3_4_years = rh7_3_4_years;
	}
	public BigDecimal getRh7_4_5_years() {
		return rh7_4_5_years;
	}
	public void setRh7_4_5_years(BigDecimal rh7_4_5_years) {
		this.rh7_4_5_years = rh7_4_5_years;
	}
	public BigDecimal getRh7_5_years() {
		return rh7_5_years;
	}
	public void setRh7_5_years(BigDecimal rh7_5_years) {
		this.rh7_5_years = rh7_5_years;
	}
	public BigDecimal getRh7_non_interest() {
		return rh7_non_interest;
	}
	public void setRh7_non_interest(BigDecimal rh7_non_interest) {
		this.rh7_non_interest = rh7_non_interest;
	}
	public BigDecimal getRh7_total() {
		return rh7_total;
	}
	public void setRh7_total(BigDecimal rh7_total) {
		this.rh7_total = rh7_total;
	}
	public String getR38_product() {
		return r38_product;
	}
	public void setR38_product(String r38_product) {
		this.r38_product = r38_product;
	}
	public BigDecimal getR38_overdraft() {
		return r38_overdraft;
	}
	public void setR38_overdraft(BigDecimal r38_overdraft) {
		this.r38_overdraft = r38_overdraft;
	}
	public BigDecimal getR38_0_7_days() {
		return r38_0_7_days;
	}
	public void setR38_0_7_days(BigDecimal r38_0_7_days) {
		this.r38_0_7_days = r38_0_7_days;
	}
	public BigDecimal getR38_8_14_days() {
		return r38_8_14_days;
	}
	public void setR38_8_14_days(BigDecimal r38_8_14_days) {
		this.r38_8_14_days = r38_8_14_days;
	}
	public BigDecimal getR38_15_days_1_month() {
		return r38_15_days_1_month;
	}
	public void setR38_15_days_1_month(BigDecimal r38_15_days_1_month) {
		this.r38_15_days_1_month = r38_15_days_1_month;
	}
	public BigDecimal getR38_1_3_months() {
		return r38_1_3_months;
	}
	public void setR38_1_3_months(BigDecimal r38_1_3_months) {
		this.r38_1_3_months = r38_1_3_months;
	}
	public BigDecimal getR38_3_6_months() {
		return r38_3_6_months;
	}
	public void setR38_3_6_months(BigDecimal r38_3_6_months) {
		this.r38_3_6_months = r38_3_6_months;
	}
	public BigDecimal getR38_6_12_months() {
		return r38_6_12_months;
	}
	public void setR38_6_12_months(BigDecimal r38_6_12_months) {
		this.r38_6_12_months = r38_6_12_months;
	}
	public BigDecimal getR38_1_2_years() {
		return r38_1_2_years;
	}
	public void setR38_1_2_years(BigDecimal r38_1_2_years) {
		this.r38_1_2_years = r38_1_2_years;
	}
	public BigDecimal getR38_2_3_years() {
		return r38_2_3_years;
	}
	public void setR38_2_3_years(BigDecimal r38_2_3_years) {
		this.r38_2_3_years = r38_2_3_years;
	}
	public BigDecimal getR38_3_4_years() {
		return r38_3_4_years;
	}
	public void setR38_3_4_years(BigDecimal r38_3_4_years) {
		this.r38_3_4_years = r38_3_4_years;
	}
	public BigDecimal getR38_4_5_years() {
		return r38_4_5_years;
	}
	public void setR38_4_5_years(BigDecimal r38_4_5_years) {
		this.r38_4_5_years = r38_4_5_years;
	}
	public BigDecimal getR38_5_years() {
		return r38_5_years;
	}
	public void setR38_5_years(BigDecimal r38_5_years) {
		this.r38_5_years = r38_5_years;
	}
	public BigDecimal getR38_non_interest() {
		return r38_non_interest;
	}
	public void setR38_non_interest(BigDecimal r38_non_interest) {
		this.r38_non_interest = r38_non_interest;
	}
	public BigDecimal getR38_total() {
		return r38_total;
	}
	public void setR38_total(BigDecimal r38_total) {
		this.r38_total = r38_total;
	}
	public String getR39_product() {
		return r39_product;
	}
	public void setR39_product(String r39_product) {
		this.r39_product = r39_product;
	}
	public BigDecimal getR39_overdraft() {
		return r39_overdraft;
	}
	public void setR39_overdraft(BigDecimal r39_overdraft) {
		this.r39_overdraft = r39_overdraft;
	}
	public BigDecimal getR39_0_7_days() {
		return r39_0_7_days;
	}
	public void setR39_0_7_days(BigDecimal r39_0_7_days) {
		this.r39_0_7_days = r39_0_7_days;
	}
	public BigDecimal getR39_8_14_days() {
		return r39_8_14_days;
	}
	public void setR39_8_14_days(BigDecimal r39_8_14_days) {
		this.r39_8_14_days = r39_8_14_days;
	}
	public BigDecimal getR39_15_days_1_month() {
		return r39_15_days_1_month;
	}
	public void setR39_15_days_1_month(BigDecimal r39_15_days_1_month) {
		this.r39_15_days_1_month = r39_15_days_1_month;
	}
	public BigDecimal getR39_1_3_months() {
		return r39_1_3_months;
	}
	public void setR39_1_3_months(BigDecimal r39_1_3_months) {
		this.r39_1_3_months = r39_1_3_months;
	}
	public BigDecimal getR39_3_6_months() {
		return r39_3_6_months;
	}
	public void setR39_3_6_months(BigDecimal r39_3_6_months) {
		this.r39_3_6_months = r39_3_6_months;
	}
	public BigDecimal getR39_6_12_months() {
		return r39_6_12_months;
	}
	public void setR39_6_12_months(BigDecimal r39_6_12_months) {
		this.r39_6_12_months = r39_6_12_months;
	}
	public BigDecimal getR39_1_2_years() {
		return r39_1_2_years;
	}
	public void setR39_1_2_years(BigDecimal r39_1_2_years) {
		this.r39_1_2_years = r39_1_2_years;
	}
	public BigDecimal getR39_2_3_years() {
		return r39_2_3_years;
	}
	public void setR39_2_3_years(BigDecimal r39_2_3_years) {
		this.r39_2_3_years = r39_2_3_years;
	}
	public BigDecimal getR39_3_4_years() {
		return r39_3_4_years;
	}
	public void setR39_3_4_years(BigDecimal r39_3_4_years) {
		this.r39_3_4_years = r39_3_4_years;
	}
	public BigDecimal getR39_4_5_years() {
		return r39_4_5_years;
	}
	public void setR39_4_5_years(BigDecimal r39_4_5_years) {
		this.r39_4_5_years = r39_4_5_years;
	}
	public BigDecimal getR39_5_years() {
		return r39_5_years;
	}
	public void setR39_5_years(BigDecimal r39_5_years) {
		this.r39_5_years = r39_5_years;
	}
	public BigDecimal getR39_non_interest() {
		return r39_non_interest;
	}
	public void setR39_non_interest(BigDecimal r39_non_interest) {
		this.r39_non_interest = r39_non_interest;
	}
	public BigDecimal getR39_total() {
		return r39_total;
	}
	public void setR39_total(BigDecimal r39_total) {
		this.r39_total = r39_total;
	}
	public String getR40_product() {
		return r40_product;
	}
	public void setR40_product(String r40_product) {
		this.r40_product = r40_product;
	}
	public BigDecimal getR40_overdraft() {
		return r40_overdraft;
	}
	public void setR40_overdraft(BigDecimal r40_overdraft) {
		this.r40_overdraft = r40_overdraft;
	}
	public BigDecimal getR40_0_7_days() {
		return r40_0_7_days;
	}
	public void setR40_0_7_days(BigDecimal r40_0_7_days) {
		this.r40_0_7_days = r40_0_7_days;
	}
	public BigDecimal getR40_8_14_days() {
		return r40_8_14_days;
	}
	public void setR40_8_14_days(BigDecimal r40_8_14_days) {
		this.r40_8_14_days = r40_8_14_days;
	}
	public BigDecimal getR40_15_days_1_month() {
		return r40_15_days_1_month;
	}
	public void setR40_15_days_1_month(BigDecimal r40_15_days_1_month) {
		this.r40_15_days_1_month = r40_15_days_1_month;
	}
	public BigDecimal getR40_1_3_months() {
		return r40_1_3_months;
	}
	public void setR40_1_3_months(BigDecimal r40_1_3_months) {
		this.r40_1_3_months = r40_1_3_months;
	}
	public BigDecimal getR40_3_6_months() {
		return r40_3_6_months;
	}
	public void setR40_3_6_months(BigDecimal r40_3_6_months) {
		this.r40_3_6_months = r40_3_6_months;
	}
	public BigDecimal getR40_6_12_months() {
		return r40_6_12_months;
	}
	public void setR40_6_12_months(BigDecimal r40_6_12_months) {
		this.r40_6_12_months = r40_6_12_months;
	}
	public BigDecimal getR40_1_2_years() {
		return r40_1_2_years;
	}
	public void setR40_1_2_years(BigDecimal r40_1_2_years) {
		this.r40_1_2_years = r40_1_2_years;
	}
	public BigDecimal getR40_2_3_years() {
		return r40_2_3_years;
	}
	public void setR40_2_3_years(BigDecimal r40_2_3_years) {
		this.r40_2_3_years = r40_2_3_years;
	}
	public BigDecimal getR40_3_4_years() {
		return r40_3_4_years;
	}
	public void setR40_3_4_years(BigDecimal r40_3_4_years) {
		this.r40_3_4_years = r40_3_4_years;
	}
	public BigDecimal getR40_4_5_years() {
		return r40_4_5_years;
	}
	public void setR40_4_5_years(BigDecimal r40_4_5_years) {
		this.r40_4_5_years = r40_4_5_years;
	}
	public BigDecimal getR40_5_years() {
		return r40_5_years;
	}
	public void setR40_5_years(BigDecimal r40_5_years) {
		this.r40_5_years = r40_5_years;
	}
	public BigDecimal getR40_non_interest() {
		return r40_non_interest;
	}
	public void setR40_non_interest(BigDecimal r40_non_interest) {
		this.r40_non_interest = r40_non_interest;
	}
	public BigDecimal getR40_total() {
		return r40_total;
	}
	public void setR40_total(BigDecimal r40_total) {
		this.r40_total = r40_total;
	}
	public String getR41_product() {
		return r41_product;
	}
	public void setR41_product(String r41_product) {
		this.r41_product = r41_product;
	}
	public BigDecimal getR41_overdraft() {
		return r41_overdraft;
	}
	public void setR41_overdraft(BigDecimal r41_overdraft) {
		this.r41_overdraft = r41_overdraft;
	}
	public BigDecimal getR41_0_7_days() {
		return r41_0_7_days;
	}
	public void setR41_0_7_days(BigDecimal r41_0_7_days) {
		this.r41_0_7_days = r41_0_7_days;
	}
	public BigDecimal getR41_8_14_days() {
		return r41_8_14_days;
	}
	public void setR41_8_14_days(BigDecimal r41_8_14_days) {
		this.r41_8_14_days = r41_8_14_days;
	}
	public BigDecimal getR41_15_days_1_month() {
		return r41_15_days_1_month;
	}
	public void setR41_15_days_1_month(BigDecimal r41_15_days_1_month) {
		this.r41_15_days_1_month = r41_15_days_1_month;
	}
	public BigDecimal getR41_1_3_months() {
		return r41_1_3_months;
	}
	public void setR41_1_3_months(BigDecimal r41_1_3_months) {
		this.r41_1_3_months = r41_1_3_months;
	}
	public BigDecimal getR41_3_6_months() {
		return r41_3_6_months;
	}
	public void setR41_3_6_months(BigDecimal r41_3_6_months) {
		this.r41_3_6_months = r41_3_6_months;
	}
	public BigDecimal getR41_6_12_months() {
		return r41_6_12_months;
	}
	public void setR41_6_12_months(BigDecimal r41_6_12_months) {
		this.r41_6_12_months = r41_6_12_months;
	}
	public BigDecimal getR41_1_2_years() {
		return r41_1_2_years;
	}
	public void setR41_1_2_years(BigDecimal r41_1_2_years) {
		this.r41_1_2_years = r41_1_2_years;
	}
	public BigDecimal getR41_2_3_years() {
		return r41_2_3_years;
	}
	public void setR41_2_3_years(BigDecimal r41_2_3_years) {
		this.r41_2_3_years = r41_2_3_years;
	}
	public BigDecimal getR41_3_4_years() {
		return r41_3_4_years;
	}
	public void setR41_3_4_years(BigDecimal r41_3_4_years) {
		this.r41_3_4_years = r41_3_4_years;
	}
	public BigDecimal getR41_4_5_years() {
		return r41_4_5_years;
	}
	public void setR41_4_5_years(BigDecimal r41_4_5_years) {
		this.r41_4_5_years = r41_4_5_years;
	}
	public BigDecimal getR41_5_years() {
		return r41_5_years;
	}
	public void setR41_5_years(BigDecimal r41_5_years) {
		this.r41_5_years = r41_5_years;
	}
	public BigDecimal getR41_non_interest() {
		return r41_non_interest;
	}
	public void setR41_non_interest(BigDecimal r41_non_interest) {
		this.r41_non_interest = r41_non_interest;
	}
	public BigDecimal getR41_total() {
		return r41_total;
	}
	public void setR41_total(BigDecimal r41_total) {
		this.r41_total = r41_total;
	}
	public String getR42_product() {
		return r42_product;
	}
	public void setR42_product(String r42_product) {
		this.r42_product = r42_product;
	}
	public BigDecimal getR42_overdraft() {
		return r42_overdraft;
	}
	public void setR42_overdraft(BigDecimal r42_overdraft) {
		this.r42_overdraft = r42_overdraft;
	}
	public BigDecimal getR42_0_7_days() {
		return r42_0_7_days;
	}
	public void setR42_0_7_days(BigDecimal r42_0_7_days) {
		this.r42_0_7_days = r42_0_7_days;
	}
	public BigDecimal getR42_8_14_days() {
		return r42_8_14_days;
	}
	public void setR42_8_14_days(BigDecimal r42_8_14_days) {
		this.r42_8_14_days = r42_8_14_days;
	}
	public BigDecimal getR42_15_days_1_month() {
		return r42_15_days_1_month;
	}
	public void setR42_15_days_1_month(BigDecimal r42_15_days_1_month) {
		this.r42_15_days_1_month = r42_15_days_1_month;
	}
	public BigDecimal getR42_1_3_months() {
		return r42_1_3_months;
	}
	public void setR42_1_3_months(BigDecimal r42_1_3_months) {
		this.r42_1_3_months = r42_1_3_months;
	}
	public BigDecimal getR42_3_6_months() {
		return r42_3_6_months;
	}
	public void setR42_3_6_months(BigDecimal r42_3_6_months) {
		this.r42_3_6_months = r42_3_6_months;
	}
	public BigDecimal getR42_6_12_months() {
		return r42_6_12_months;
	}
	public void setR42_6_12_months(BigDecimal r42_6_12_months) {
		this.r42_6_12_months = r42_6_12_months;
	}
	public BigDecimal getR42_1_2_years() {
		return r42_1_2_years;
	}
	public void setR42_1_2_years(BigDecimal r42_1_2_years) {
		this.r42_1_2_years = r42_1_2_years;
	}
	public BigDecimal getR42_2_3_years() {
		return r42_2_3_years;
	}
	public void setR42_2_3_years(BigDecimal r42_2_3_years) {
		this.r42_2_3_years = r42_2_3_years;
	}
	public BigDecimal getR42_3_4_years() {
		return r42_3_4_years;
	}
	public void setR42_3_4_years(BigDecimal r42_3_4_years) {
		this.r42_3_4_years = r42_3_4_years;
	}
	public BigDecimal getR42_4_5_years() {
		return r42_4_5_years;
	}
	public void setR42_4_5_years(BigDecimal r42_4_5_years) {
		this.r42_4_5_years = r42_4_5_years;
	}
	public BigDecimal getR42_5_years() {
		return r42_5_years;
	}
	public void setR42_5_years(BigDecimal r42_5_years) {
		this.r42_5_years = r42_5_years;
	}
	public BigDecimal getR42_non_interest() {
		return r42_non_interest;
	}
	public void setR42_non_interest(BigDecimal r42_non_interest) {
		this.r42_non_interest = r42_non_interest;
	}
	public BigDecimal getR42_total() {
		return r42_total;
	}
	public void setR42_total(BigDecimal r42_total) {
		this.r42_total = r42_total;
	}
	public String getR43_product() {
		return r43_product;
	}
	public void setR43_product(String r43_product) {
		this.r43_product = r43_product;
	}
	public BigDecimal getR43_overdraft() {
		return r43_overdraft;
	}
	public void setR43_overdraft(BigDecimal r43_overdraft) {
		this.r43_overdraft = r43_overdraft;
	}
	public BigDecimal getR43_0_7_days() {
		return r43_0_7_days;
	}
	public void setR43_0_7_days(BigDecimal r43_0_7_days) {
		this.r43_0_7_days = r43_0_7_days;
	}
	public BigDecimal getR43_8_14_days() {
		return r43_8_14_days;
	}
	public void setR43_8_14_days(BigDecimal r43_8_14_days) {
		this.r43_8_14_days = r43_8_14_days;
	}
	public BigDecimal getR43_15_days_1_month() {
		return r43_15_days_1_month;
	}
	public void setR43_15_days_1_month(BigDecimal r43_15_days_1_month) {
		this.r43_15_days_1_month = r43_15_days_1_month;
	}
	public BigDecimal getR43_1_3_months() {
		return r43_1_3_months;
	}
	public void setR43_1_3_months(BigDecimal r43_1_3_months) {
		this.r43_1_3_months = r43_1_3_months;
	}
	public BigDecimal getR43_3_6_months() {
		return r43_3_6_months;
	}
	public void setR43_3_6_months(BigDecimal r43_3_6_months) {
		this.r43_3_6_months = r43_3_6_months;
	}
	public BigDecimal getR43_6_12_months() {
		return r43_6_12_months;
	}
	public void setR43_6_12_months(BigDecimal r43_6_12_months) {
		this.r43_6_12_months = r43_6_12_months;
	}
	public BigDecimal getR43_1_2_years() {
		return r43_1_2_years;
	}
	public void setR43_1_2_years(BigDecimal r43_1_2_years) {
		this.r43_1_2_years = r43_1_2_years;
	}
	public BigDecimal getR43_2_3_years() {
		return r43_2_3_years;
	}
	public void setR43_2_3_years(BigDecimal r43_2_3_years) {
		this.r43_2_3_years = r43_2_3_years;
	}
	public BigDecimal getR43_3_4_years() {
		return r43_3_4_years;
	}
	public void setR43_3_4_years(BigDecimal r43_3_4_years) {
		this.r43_3_4_years = r43_3_4_years;
	}
	public BigDecimal getR43_4_5_years() {
		return r43_4_5_years;
	}
	public void setR43_4_5_years(BigDecimal r43_4_5_years) {
		this.r43_4_5_years = r43_4_5_years;
	}
	public BigDecimal getR43_5_years() {
		return r43_5_years;
	}
	public void setR43_5_years(BigDecimal r43_5_years) {
		this.r43_5_years = r43_5_years;
	}
	public BigDecimal getR43_non_interest() {
		return r43_non_interest;
	}
	public void setR43_non_interest(BigDecimal r43_non_interest) {
		this.r43_non_interest = r43_non_interest;
	}
	public BigDecimal getR43_total() {
		return r43_total;
	}
	public void setR43_total(BigDecimal r43_total) {
		this.r43_total = r43_total;
	}
	public String getRh8_product() {
		return rh8_product;
	}
	public void setRh8_product(String rh8_product) {
		this.rh8_product = rh8_product;
	}
	public BigDecimal getRh8_overdraft() {
		return rh8_overdraft;
	}
	public void setRh8_overdraft(BigDecimal rh8_overdraft) {
		this.rh8_overdraft = rh8_overdraft;
	}
	public BigDecimal getRh8_0_7_days() {
		return rh8_0_7_days;
	}
	public void setRh8_0_7_days(BigDecimal rh8_0_7_days) {
		this.rh8_0_7_days = rh8_0_7_days;
	}
	public BigDecimal getRh8_8_14_days() {
		return rh8_8_14_days;
	}
	public void setRh8_8_14_days(BigDecimal rh8_8_14_days) {
		this.rh8_8_14_days = rh8_8_14_days;
	}
	public BigDecimal getRh8_15_days_1_month() {
		return rh8_15_days_1_month;
	}
	public void setRh8_15_days_1_month(BigDecimal rh8_15_days_1_month) {
		this.rh8_15_days_1_month = rh8_15_days_1_month;
	}
	public BigDecimal getRh8_1_3_months() {
		return rh8_1_3_months;
	}
	public void setRh8_1_3_months(BigDecimal rh8_1_3_months) {
		this.rh8_1_3_months = rh8_1_3_months;
	}
	public BigDecimal getRh8_3_6_months() {
		return rh8_3_6_months;
	}
	public void setRh8_3_6_months(BigDecimal rh8_3_6_months) {
		this.rh8_3_6_months = rh8_3_6_months;
	}
	public BigDecimal getRh8_6_12_months() {
		return rh8_6_12_months;
	}
	public void setRh8_6_12_months(BigDecimal rh8_6_12_months) {
		this.rh8_6_12_months = rh8_6_12_months;
	}
	public BigDecimal getRh8_1_2_years() {
		return rh8_1_2_years;
	}
	public void setRh8_1_2_years(BigDecimal rh8_1_2_years) {
		this.rh8_1_2_years = rh8_1_2_years;
	}
	public BigDecimal getRh8_2_3_years() {
		return rh8_2_3_years;
	}
	public void setRh8_2_3_years(BigDecimal rh8_2_3_years) {
		this.rh8_2_3_years = rh8_2_3_years;
	}
	public BigDecimal getRh8_3_4_years() {
		return rh8_3_4_years;
	}
	public void setRh8_3_4_years(BigDecimal rh8_3_4_years) {
		this.rh8_3_4_years = rh8_3_4_years;
	}
	public BigDecimal getRh8_4_5_years() {
		return rh8_4_5_years;
	}
	public void setRh8_4_5_years(BigDecimal rh8_4_5_years) {
		this.rh8_4_5_years = rh8_4_5_years;
	}
	public BigDecimal getRh8_5_years() {
		return rh8_5_years;
	}
	public void setRh8_5_years(BigDecimal rh8_5_years) {
		this.rh8_5_years = rh8_5_years;
	}
	public BigDecimal getRh8_non_interest() {
		return rh8_non_interest;
	}
	public void setRh8_non_interest(BigDecimal rh8_non_interest) {
		this.rh8_non_interest = rh8_non_interest;
	}
	public BigDecimal getRh8_total() {
		return rh8_total;
	}
	public void setRh8_total(BigDecimal rh8_total) {
		this.rh8_total = rh8_total;
	}
	public String getR44_product() {
		return r44_product;
	}
	public void setR44_product(String r44_product) {
		this.r44_product = r44_product;
	}
	public BigDecimal getR44_overdraft() {
		return r44_overdraft;
	}
	public void setR44_overdraft(BigDecimal r44_overdraft) {
		this.r44_overdraft = r44_overdraft;
	}
	public BigDecimal getR44_0_7_days() {
		return r44_0_7_days;
	}
	public void setR44_0_7_days(BigDecimal r44_0_7_days) {
		this.r44_0_7_days = r44_0_7_days;
	}
	public BigDecimal getR44_8_14_days() {
		return r44_8_14_days;
	}
	public void setR44_8_14_days(BigDecimal r44_8_14_days) {
		this.r44_8_14_days = r44_8_14_days;
	}
	public BigDecimal getR44_15_days_1_month() {
		return r44_15_days_1_month;
	}
	public void setR44_15_days_1_month(BigDecimal r44_15_days_1_month) {
		this.r44_15_days_1_month = r44_15_days_1_month;
	}
	public BigDecimal getR44_1_3_months() {
		return r44_1_3_months;
	}
	public void setR44_1_3_months(BigDecimal r44_1_3_months) {
		this.r44_1_3_months = r44_1_3_months;
	}
	public BigDecimal getR44_3_6_months() {
		return r44_3_6_months;
	}
	public void setR44_3_6_months(BigDecimal r44_3_6_months) {
		this.r44_3_6_months = r44_3_6_months;
	}
	public BigDecimal getR44_6_12_months() {
		return r44_6_12_months;
	}
	public void setR44_6_12_months(BigDecimal r44_6_12_months) {
		this.r44_6_12_months = r44_6_12_months;
	}
	public BigDecimal getR44_1_2_years() {
		return r44_1_2_years;
	}
	public void setR44_1_2_years(BigDecimal r44_1_2_years) {
		this.r44_1_2_years = r44_1_2_years;
	}
	public BigDecimal getR44_2_3_years() {
		return r44_2_3_years;
	}
	public void setR44_2_3_years(BigDecimal r44_2_3_years) {
		this.r44_2_3_years = r44_2_3_years;
	}
	public BigDecimal getR44_3_4_years() {
		return r44_3_4_years;
	}
	public void setR44_3_4_years(BigDecimal r44_3_4_years) {
		this.r44_3_4_years = r44_3_4_years;
	}
	public BigDecimal getR44_4_5_years() {
		return r44_4_5_years;
	}
	public void setR44_4_5_years(BigDecimal r44_4_5_years) {
		this.r44_4_5_years = r44_4_5_years;
	}
	public BigDecimal getR44_5_years() {
		return r44_5_years;
	}
	public void setR44_5_years(BigDecimal r44_5_years) {
		this.r44_5_years = r44_5_years;
	}
	public BigDecimal getR44_non_interest() {
		return r44_non_interest;
	}
	public void setR44_non_interest(BigDecimal r44_non_interest) {
		this.r44_non_interest = r44_non_interest;
	}
	public BigDecimal getR44_total() {
		return r44_total;
	}
	public void setR44_total(BigDecimal r44_total) {
		this.r44_total = r44_total;
	}
	public String getR45_product() {
		return r45_product;
	}
	public void setR45_product(String r45_product) {
		this.r45_product = r45_product;
	}
	public BigDecimal getR45_overdraft() {
		return r45_overdraft;
	}
	public void setR45_overdraft(BigDecimal r45_overdraft) {
		this.r45_overdraft = r45_overdraft;
	}
	public BigDecimal getR45_0_7_days() {
		return r45_0_7_days;
	}
	public void setR45_0_7_days(BigDecimal r45_0_7_days) {
		this.r45_0_7_days = r45_0_7_days;
	}
	public BigDecimal getR45_8_14_days() {
		return r45_8_14_days;
	}
	public void setR45_8_14_days(BigDecimal r45_8_14_days) {
		this.r45_8_14_days = r45_8_14_days;
	}
	public BigDecimal getR45_15_days_1_month() {
		return r45_15_days_1_month;
	}
	public void setR45_15_days_1_month(BigDecimal r45_15_days_1_month) {
		this.r45_15_days_1_month = r45_15_days_1_month;
	}
	public BigDecimal getR45_1_3_months() {
		return r45_1_3_months;
	}
	public void setR45_1_3_months(BigDecimal r45_1_3_months) {
		this.r45_1_3_months = r45_1_3_months;
	}
	public BigDecimal getR45_3_6_months() {
		return r45_3_6_months;
	}
	public void setR45_3_6_months(BigDecimal r45_3_6_months) {
		this.r45_3_6_months = r45_3_6_months;
	}
	public BigDecimal getR45_6_12_months() {
		return r45_6_12_months;
	}
	public void setR45_6_12_months(BigDecimal r45_6_12_months) {
		this.r45_6_12_months = r45_6_12_months;
	}
	public BigDecimal getR45_1_2_years() {
		return r45_1_2_years;
	}
	public void setR45_1_2_years(BigDecimal r45_1_2_years) {
		this.r45_1_2_years = r45_1_2_years;
	}
	public BigDecimal getR45_2_3_years() {
		return r45_2_3_years;
	}
	public void setR45_2_3_years(BigDecimal r45_2_3_years) {
		this.r45_2_3_years = r45_2_3_years;
	}
	public BigDecimal getR45_3_4_years() {
		return r45_3_4_years;
	}
	public void setR45_3_4_years(BigDecimal r45_3_4_years) {
		this.r45_3_4_years = r45_3_4_years;
	}
	public BigDecimal getR45_4_5_years() {
		return r45_4_5_years;
	}
	public void setR45_4_5_years(BigDecimal r45_4_5_years) {
		this.r45_4_5_years = r45_4_5_years;
	}
	public BigDecimal getR45_5_years() {
		return r45_5_years;
	}
	public void setR45_5_years(BigDecimal r45_5_years) {
		this.r45_5_years = r45_5_years;
	}
	public BigDecimal getR45_non_interest() {
		return r45_non_interest;
	}
	public void setR45_non_interest(BigDecimal r45_non_interest) {
		this.r45_non_interest = r45_non_interest;
	}
	public BigDecimal getR45_total() {
		return r45_total;
	}
	public void setR45_total(BigDecimal r45_total) {
		this.r45_total = r45_total;
	}
	public String getR46_product() {
		return r46_product;
	}
	public void setR46_product(String r46_product) {
		this.r46_product = r46_product;
	}
	public BigDecimal getR46_overdraft() {
		return r46_overdraft;
	}
	public void setR46_overdraft(BigDecimal r46_overdraft) {
		this.r46_overdraft = r46_overdraft;
	}
	public BigDecimal getR46_0_7_days() {
		return r46_0_7_days;
	}
	public void setR46_0_7_days(BigDecimal r46_0_7_days) {
		this.r46_0_7_days = r46_0_7_days;
	}
	public BigDecimal getR46_8_14_days() {
		return r46_8_14_days;
	}
	public void setR46_8_14_days(BigDecimal r46_8_14_days) {
		this.r46_8_14_days = r46_8_14_days;
	}
	public BigDecimal getR46_15_days_1_month() {
		return r46_15_days_1_month;
	}
	public void setR46_15_days_1_month(BigDecimal r46_15_days_1_month) {
		this.r46_15_days_1_month = r46_15_days_1_month;
	}
	public BigDecimal getR46_1_3_months() {
		return r46_1_3_months;
	}
	public void setR46_1_3_months(BigDecimal r46_1_3_months) {
		this.r46_1_3_months = r46_1_3_months;
	}
	public BigDecimal getR46_3_6_months() {
		return r46_3_6_months;
	}
	public void setR46_3_6_months(BigDecimal r46_3_6_months) {
		this.r46_3_6_months = r46_3_6_months;
	}
	public BigDecimal getR46_6_12_months() {
		return r46_6_12_months;
	}
	public void setR46_6_12_months(BigDecimal r46_6_12_months) {
		this.r46_6_12_months = r46_6_12_months;
	}
	public BigDecimal getR46_1_2_years() {
		return r46_1_2_years;
	}
	public void setR46_1_2_years(BigDecimal r46_1_2_years) {
		this.r46_1_2_years = r46_1_2_years;
	}
	public BigDecimal getR46_2_3_years() {
		return r46_2_3_years;
	}
	public void setR46_2_3_years(BigDecimal r46_2_3_years) {
		this.r46_2_3_years = r46_2_3_years;
	}
	public BigDecimal getR46_3_4_years() {
		return r46_3_4_years;
	}
	public void setR46_3_4_years(BigDecimal r46_3_4_years) {
		this.r46_3_4_years = r46_3_4_years;
	}
	public BigDecimal getR46_4_5_years() {
		return r46_4_5_years;
	}
	public void setR46_4_5_years(BigDecimal r46_4_5_years) {
		this.r46_4_5_years = r46_4_5_years;
	}
	public BigDecimal getR46_5_years() {
		return r46_5_years;
	}
	public void setR46_5_years(BigDecimal r46_5_years) {
		this.r46_5_years = r46_5_years;
	}
	public BigDecimal getR46_non_interest() {
		return r46_non_interest;
	}
	public void setR46_non_interest(BigDecimal r46_non_interest) {
		this.r46_non_interest = r46_non_interest;
	}
	public BigDecimal getR46_total() {
		return r46_total;
	}
	public void setR46_total(BigDecimal r46_total) {
		this.r46_total = r46_total;
	}
	public String getR47_product() {
		return r47_product;
	}
	public void setR47_product(String r47_product) {
		this.r47_product = r47_product;
	}
	public BigDecimal getR47_overdraft() {
		return r47_overdraft;
	}
	public void setR47_overdraft(BigDecimal r47_overdraft) {
		this.r47_overdraft = r47_overdraft;
	}
	public BigDecimal getR47_0_7_days() {
		return r47_0_7_days;
	}
	public void setR47_0_7_days(BigDecimal r47_0_7_days) {
		this.r47_0_7_days = r47_0_7_days;
	}
	public BigDecimal getR47_8_14_days() {
		return r47_8_14_days;
	}
	public void setR47_8_14_days(BigDecimal r47_8_14_days) {
		this.r47_8_14_days = r47_8_14_days;
	}
	public BigDecimal getR47_15_days_1_month() {
		return r47_15_days_1_month;
	}
	public void setR47_15_days_1_month(BigDecimal r47_15_days_1_month) {
		this.r47_15_days_1_month = r47_15_days_1_month;
	}
	public BigDecimal getR47_1_3_months() {
		return r47_1_3_months;
	}
	public void setR47_1_3_months(BigDecimal r47_1_3_months) {
		this.r47_1_3_months = r47_1_3_months;
	}
	public BigDecimal getR47_3_6_months() {
		return r47_3_6_months;
	}
	public void setR47_3_6_months(BigDecimal r47_3_6_months) {
		this.r47_3_6_months = r47_3_6_months;
	}
	public BigDecimal getR47_6_12_months() {
		return r47_6_12_months;
	}
	public void setR47_6_12_months(BigDecimal r47_6_12_months) {
		this.r47_6_12_months = r47_6_12_months;
	}
	public BigDecimal getR47_1_2_years() {
		return r47_1_2_years;
	}
	public void setR47_1_2_years(BigDecimal r47_1_2_years) {
		this.r47_1_2_years = r47_1_2_years;
	}
	public BigDecimal getR47_2_3_years() {
		return r47_2_3_years;
	}
	public void setR47_2_3_years(BigDecimal r47_2_3_years) {
		this.r47_2_3_years = r47_2_3_years;
	}
	public BigDecimal getR47_3_4_years() {
		return r47_3_4_years;
	}
	public void setR47_3_4_years(BigDecimal r47_3_4_years) {
		this.r47_3_4_years = r47_3_4_years;
	}
	public BigDecimal getR47_4_5_years() {
		return r47_4_5_years;
	}
	public void setR47_4_5_years(BigDecimal r47_4_5_years) {
		this.r47_4_5_years = r47_4_5_years;
	}
	public BigDecimal getR47_5_years() {
		return r47_5_years;
	}
	public void setR47_5_years(BigDecimal r47_5_years) {
		this.r47_5_years = r47_5_years;
	}
	public BigDecimal getR47_non_interest() {
		return r47_non_interest;
	}
	public void setR47_non_interest(BigDecimal r47_non_interest) {
		this.r47_non_interest = r47_non_interest;
	}
	public BigDecimal getR47_total() {
		return r47_total;
	}
	public void setR47_total(BigDecimal r47_total) {
		this.r47_total = r47_total;
	}
	public String getRtle_product() {
		return rtle_product;
	}
	public void setRtle_product(String rtle_product) {
		this.rtle_product = rtle_product;
	}
	public BigDecimal getRtle_overdraft() {
		return rtle_overdraft;
	}
	public void setRtle_overdraft(BigDecimal rtle_overdraft) {
		this.rtle_overdraft = rtle_overdraft;
	}
	public BigDecimal getRtle_0_7_days() {
		return rtle_0_7_days;
	}
	public void setRtle_0_7_days(BigDecimal rtle_0_7_days) {
		this.rtle_0_7_days = rtle_0_7_days;
	}
	public BigDecimal getRtle_8_14_days() {
		return rtle_8_14_days;
	}
	public void setRtle_8_14_days(BigDecimal rtle_8_14_days) {
		this.rtle_8_14_days = rtle_8_14_days;
	}
	public BigDecimal getRtle_15_days_1_month() {
		return rtle_15_days_1_month;
	}
	public void setRtle_15_days_1_month(BigDecimal rtle_15_days_1_month) {
		this.rtle_15_days_1_month = rtle_15_days_1_month;
	}
	public BigDecimal getRtle_1_3_months() {
		return rtle_1_3_months;
	}
	public void setRtle_1_3_months(BigDecimal rtle_1_3_months) {
		this.rtle_1_3_months = rtle_1_3_months;
	}
	public BigDecimal getRtle_3_6_months() {
		return rtle_3_6_months;
	}
	public void setRtle_3_6_months(BigDecimal rtle_3_6_months) {
		this.rtle_3_6_months = rtle_3_6_months;
	}
	public BigDecimal getRtle_6_12_months() {
		return rtle_6_12_months;
	}
	public void setRtle_6_12_months(BigDecimal rtle_6_12_months) {
		this.rtle_6_12_months = rtle_6_12_months;
	}
	public BigDecimal getRtle_1_2_years() {
		return rtle_1_2_years;
	}
	public void setRtle_1_2_years(BigDecimal rtle_1_2_years) {
		this.rtle_1_2_years = rtle_1_2_years;
	}
	public BigDecimal getRtle_2_3_years() {
		return rtle_2_3_years;
	}
	public void setRtle_2_3_years(BigDecimal rtle_2_3_years) {
		this.rtle_2_3_years = rtle_2_3_years;
	}
	public BigDecimal getRtle_3_4_years() {
		return rtle_3_4_years;
	}
	public void setRtle_3_4_years(BigDecimal rtle_3_4_years) {
		this.rtle_3_4_years = rtle_3_4_years;
	}
	public BigDecimal getRtle_4_5_years() {
		return rtle_4_5_years;
	}
	public void setRtle_4_5_years(BigDecimal rtle_4_5_years) {
		this.rtle_4_5_years = rtle_4_5_years;
	}
	public BigDecimal getRtle_5_years() {
		return rtle_5_years;
	}
	public void setRtle_5_years(BigDecimal rtle_5_years) {
		this.rtle_5_years = rtle_5_years;
	}
	public BigDecimal getRtle_non_interest() {
		return rtle_non_interest;
	}
	public void setRtle_non_interest(BigDecimal rtle_non_interest) {
		this.rtle_non_interest = rtle_non_interest;
	}
	public BigDecimal getRtle_total() {
		return rtle_total;
	}
	public void setRtle_total(BigDecimal rtle_total) {
		this.rtle_total = rtle_total;
	}
	public String getR48_product() {
		return r48_product;
	}
	public void setR48_product(String r48_product) {
		this.r48_product = r48_product;
	}
	public BigDecimal getR48_overdraft() {
		return r48_overdraft;
	}
	public void setR48_overdraft(BigDecimal r48_overdraft) {
		this.r48_overdraft = r48_overdraft;
	}
	public BigDecimal getR48_0_7_days() {
		return r48_0_7_days;
	}
	public void setR48_0_7_days(BigDecimal r48_0_7_days) {
		this.r48_0_7_days = r48_0_7_days;
	}
	public BigDecimal getR48_8_14_days() {
		return r48_8_14_days;
	}
	public void setR48_8_14_days(BigDecimal r48_8_14_days) {
		this.r48_8_14_days = r48_8_14_days;
	}
	public BigDecimal getR48_15_days_1_month() {
		return r48_15_days_1_month;
	}
	public void setR48_15_days_1_month(BigDecimal r48_15_days_1_month) {
		this.r48_15_days_1_month = r48_15_days_1_month;
	}
	public BigDecimal getR48_1_3_months() {
		return r48_1_3_months;
	}
	public void setR48_1_3_months(BigDecimal r48_1_3_months) {
		this.r48_1_3_months = r48_1_3_months;
	}
	public BigDecimal getR48_3_6_months() {
		return r48_3_6_months;
	}
	public void setR48_3_6_months(BigDecimal r48_3_6_months) {
		this.r48_3_6_months = r48_3_6_months;
	}
	public BigDecimal getR48_6_12_months() {
		return r48_6_12_months;
	}
	public void setR48_6_12_months(BigDecimal r48_6_12_months) {
		this.r48_6_12_months = r48_6_12_months;
	}
	public BigDecimal getR48_1_2_years() {
		return r48_1_2_years;
	}
	public void setR48_1_2_years(BigDecimal r48_1_2_years) {
		this.r48_1_2_years = r48_1_2_years;
	}
	public BigDecimal getR48_2_3_years() {
		return r48_2_3_years;
	}
	public void setR48_2_3_years(BigDecimal r48_2_3_years) {
		this.r48_2_3_years = r48_2_3_years;
	}
	public BigDecimal getR48_3_4_years() {
		return r48_3_4_years;
	}
	public void setR48_3_4_years(BigDecimal r48_3_4_years) {
		this.r48_3_4_years = r48_3_4_years;
	}
	public BigDecimal getR48_4_5_years() {
		return r48_4_5_years;
	}
	public void setR48_4_5_years(BigDecimal r48_4_5_years) {
		this.r48_4_5_years = r48_4_5_years;
	}
	public BigDecimal getR48_5_years() {
		return r48_5_years;
	}
	public void setR48_5_years(BigDecimal r48_5_years) {
		this.r48_5_years = r48_5_years;
	}
	public BigDecimal getR48_non_interest() {
		return r48_non_interest;
	}
	public void setR48_non_interest(BigDecimal r48_non_interest) {
		this.r48_non_interest = r48_non_interest;
	}
	public BigDecimal getR48_total() {
		return r48_total;
	}
	public void setR48_total(BigDecimal r48_total) {
		this.r48_total = r48_total;
	}
	public String getR49_product() {
		return r49_product;
	}
	public void setR49_product(String r49_product) {
		this.r49_product = r49_product;
	}
	public BigDecimal getR49_overdraft() {
		return r49_overdraft;
	}
	public void setR49_overdraft(BigDecimal r49_overdraft) {
		this.r49_overdraft = r49_overdraft;
	}
	public BigDecimal getR49_0_7_days() {
		return r49_0_7_days;
	}
	public void setR49_0_7_days(BigDecimal r49_0_7_days) {
		this.r49_0_7_days = r49_0_7_days;
	}
	public BigDecimal getR49_8_14_days() {
		return r49_8_14_days;
	}
	public void setR49_8_14_days(BigDecimal r49_8_14_days) {
		this.r49_8_14_days = r49_8_14_days;
	}
	public BigDecimal getR49_15_days_1_month() {
		return r49_15_days_1_month;
	}
	public void setR49_15_days_1_month(BigDecimal r49_15_days_1_month) {
		this.r49_15_days_1_month = r49_15_days_1_month;
	}
	public BigDecimal getR49_1_3_months() {
		return r49_1_3_months;
	}
	public void setR49_1_3_months(BigDecimal r49_1_3_months) {
		this.r49_1_3_months = r49_1_3_months;
	}
	public BigDecimal getR49_3_6_months() {
		return r49_3_6_months;
	}
	public void setR49_3_6_months(BigDecimal r49_3_6_months) {
		this.r49_3_6_months = r49_3_6_months;
	}
	public BigDecimal getR49_6_12_months() {
		return r49_6_12_months;
	}
	public void setR49_6_12_months(BigDecimal r49_6_12_months) {
		this.r49_6_12_months = r49_6_12_months;
	}
	public BigDecimal getR49_1_2_years() {
		return r49_1_2_years;
	}
	public void setR49_1_2_years(BigDecimal r49_1_2_years) {
		this.r49_1_2_years = r49_1_2_years;
	}
	public BigDecimal getR49_2_3_years() {
		return r49_2_3_years;
	}
	public void setR49_2_3_years(BigDecimal r49_2_3_years) {
		this.r49_2_3_years = r49_2_3_years;
	}
	public BigDecimal getR49_3_4_years() {
		return r49_3_4_years;
	}
	public void setR49_3_4_years(BigDecimal r49_3_4_years) {
		this.r49_3_4_years = r49_3_4_years;
	}
	public BigDecimal getR49_4_5_years() {
		return r49_4_5_years;
	}
	public void setR49_4_5_years(BigDecimal r49_4_5_years) {
		this.r49_4_5_years = r49_4_5_years;
	}
	public BigDecimal getR49_5_years() {
		return r49_5_years;
	}
	public void setR49_5_years(BigDecimal r49_5_years) {
		this.r49_5_years = r49_5_years;
	}
	public BigDecimal getR49_non_interest() {
		return r49_non_interest;
	}
	public void setR49_non_interest(BigDecimal r49_non_interest) {
		this.r49_non_interest = r49_non_interest;
	}
	public BigDecimal getR49_total() {
		return r49_total;
	}
	public void setR49_total(BigDecimal r49_total) {
		this.r49_total = r49_total;
	}
	public String getR50_product() {
		return r50_product;
	}
	public void setR50_product(String r50_product) {
		this.r50_product = r50_product;
	}
	public BigDecimal getR50_overdraft() {
		return r50_overdraft;
	}
	public void setR50_overdraft(BigDecimal r50_overdraft) {
		this.r50_overdraft = r50_overdraft;
	}
	public BigDecimal getR50_0_7_days() {
		return r50_0_7_days;
	}
	public void setR50_0_7_days(BigDecimal r50_0_7_days) {
		this.r50_0_7_days = r50_0_7_days;
	}
	public BigDecimal getR50_8_14_days() {
		return r50_8_14_days;
	}
	public void setR50_8_14_days(BigDecimal r50_8_14_days) {
		this.r50_8_14_days = r50_8_14_days;
	}
	public BigDecimal getR50_15_days_1_month() {
		return r50_15_days_1_month;
	}
	public void setR50_15_days_1_month(BigDecimal r50_15_days_1_month) {
		this.r50_15_days_1_month = r50_15_days_1_month;
	}
	public BigDecimal getR50_1_3_months() {
		return r50_1_3_months;
	}
	public void setR50_1_3_months(BigDecimal r50_1_3_months) {
		this.r50_1_3_months = r50_1_3_months;
	}
	public BigDecimal getR50_3_6_months() {
		return r50_3_6_months;
	}
	public void setR50_3_6_months(BigDecimal r50_3_6_months) {
		this.r50_3_6_months = r50_3_6_months;
	}
	public BigDecimal getR50_6_12_months() {
		return r50_6_12_months;
	}
	public void setR50_6_12_months(BigDecimal r50_6_12_months) {
		this.r50_6_12_months = r50_6_12_months;
	}
	public BigDecimal getR50_1_2_years() {
		return r50_1_2_years;
	}
	public void setR50_1_2_years(BigDecimal r50_1_2_years) {
		this.r50_1_2_years = r50_1_2_years;
	}
	public BigDecimal getR50_2_3_years() {
		return r50_2_3_years;
	}
	public void setR50_2_3_years(BigDecimal r50_2_3_years) {
		this.r50_2_3_years = r50_2_3_years;
	}
	public BigDecimal getR50_3_4_years() {
		return r50_3_4_years;
	}
	public void setR50_3_4_years(BigDecimal r50_3_4_years) {
		this.r50_3_4_years = r50_3_4_years;
	}
	public BigDecimal getR50_4_5_years() {
		return r50_4_5_years;
	}
	public void setR50_4_5_years(BigDecimal r50_4_5_years) {
		this.r50_4_5_years = r50_4_5_years;
	}
	public BigDecimal getR50_5_years() {
		return r50_5_years;
	}
	public void setR50_5_years(BigDecimal r50_5_years) {
		this.r50_5_years = r50_5_years;
	}
	public BigDecimal getR50_non_interest() {
		return r50_non_interest;
	}
	public void setR50_non_interest(BigDecimal r50_non_interest) {
		this.r50_non_interest = r50_non_interest;
	}
	public BigDecimal getR50_total() {
		return r50_total;
	}
	public void setR50_total(BigDecimal r50_total) {
		this.r50_total = r50_total;
	}
	public String getRtob_product() {
		return rtob_product;
	}
	public void setRtob_product(String rtob_product) {
		this.rtob_product = rtob_product;
	}
	public BigDecimal getRtob_overdraft() {
		return rtob_overdraft;
	}
	public void setRtob_overdraft(BigDecimal rtob_overdraft) {
		this.rtob_overdraft = rtob_overdraft;
	}
	public BigDecimal getRtob_0_7_days() {
		return rtob_0_7_days;
	}
	public void setRtob_0_7_days(BigDecimal rtob_0_7_days) {
		this.rtob_0_7_days = rtob_0_7_days;
	}
	public BigDecimal getRtob_8_14_days() {
		return rtob_8_14_days;
	}
	public void setRtob_8_14_days(BigDecimal rtob_8_14_days) {
		this.rtob_8_14_days = rtob_8_14_days;
	}
	public BigDecimal getRtob_15_days_1_month() {
		return rtob_15_days_1_month;
	}
	public void setRtob_15_days_1_month(BigDecimal rtob_15_days_1_month) {
		this.rtob_15_days_1_month = rtob_15_days_1_month;
	}
	public BigDecimal getRtob_1_3_months() {
		return rtob_1_3_months;
	}
	public void setRtob_1_3_months(BigDecimal rtob_1_3_months) {
		this.rtob_1_3_months = rtob_1_3_months;
	}
	public BigDecimal getRtob_3_6_months() {
		return rtob_3_6_months;
	}
	public void setRtob_3_6_months(BigDecimal rtob_3_6_months) {
		this.rtob_3_6_months = rtob_3_6_months;
	}
	public BigDecimal getRtob_6_12_months() {
		return rtob_6_12_months;
	}
	public void setRtob_6_12_months(BigDecimal rtob_6_12_months) {
		this.rtob_6_12_months = rtob_6_12_months;
	}
	public BigDecimal getRtob_1_2_years() {
		return rtob_1_2_years;
	}
	public void setRtob_1_2_years(BigDecimal rtob_1_2_years) {
		this.rtob_1_2_years = rtob_1_2_years;
	}
	public BigDecimal getRtob_2_3_years() {
		return rtob_2_3_years;
	}
	public void setRtob_2_3_years(BigDecimal rtob_2_3_years) {
		this.rtob_2_3_years = rtob_2_3_years;
	}
	public BigDecimal getRtob_3_4_years() {
		return rtob_3_4_years;
	}
	public void setRtob_3_4_years(BigDecimal rtob_3_4_years) {
		this.rtob_3_4_years = rtob_3_4_years;
	}
	public BigDecimal getRtob_4_5_years() {
		return rtob_4_5_years;
	}
	public void setRtob_4_5_years(BigDecimal rtob_4_5_years) {
		this.rtob_4_5_years = rtob_4_5_years;
	}
	public BigDecimal getRtob_5_years() {
		return rtob_5_years;
	}
	public void setRtob_5_years(BigDecimal rtob_5_years) {
		this.rtob_5_years = rtob_5_years;
	}
	public BigDecimal getRtob_non_interest() {
		return rtob_non_interest;
	}
	public void setRtob_non_interest(BigDecimal rtob_non_interest) {
		this.rtob_non_interest = rtob_non_interest;
	}
	public BigDecimal getRtob_total() {
		return rtob_total;
	}
	public void setRtob_total(BigDecimal rtob_total) {
		this.rtob_total = rtob_total;
	}
	public String getRnrm_product() {
		return rnrm_product;
	}
	public void setRnrm_product(String rnrm_product) {
		this.rnrm_product = rnrm_product;
	}
	public BigDecimal getRnrm_overdraft() {
		return rnrm_overdraft;
	}
	public void setRnrm_overdraft(BigDecimal rnrm_overdraft) {
		this.rnrm_overdraft = rnrm_overdraft;
	}
	public BigDecimal getRnrm_0_7_days() {
		return rnrm_0_7_days;
	}
	public void setRnrm_0_7_days(BigDecimal rnrm_0_7_days) {
		this.rnrm_0_7_days = rnrm_0_7_days;
	}
	public BigDecimal getRnrm_8_14_days() {
		return rnrm_8_14_days;
	}
	public void setRnrm_8_14_days(BigDecimal rnrm_8_14_days) {
		this.rnrm_8_14_days = rnrm_8_14_days;
	}
	public BigDecimal getRnrm_15_days_1_month() {
		return rnrm_15_days_1_month;
	}
	public void setRnrm_15_days_1_month(BigDecimal rnrm_15_days_1_month) {
		this.rnrm_15_days_1_month = rnrm_15_days_1_month;
	}
	public BigDecimal getRnrm_1_3_months() {
		return rnrm_1_3_months;
	}
	public void setRnrm_1_3_months(BigDecimal rnrm_1_3_months) {
		this.rnrm_1_3_months = rnrm_1_3_months;
	}
	public BigDecimal getRnrm_3_6_months() {
		return rnrm_3_6_months;
	}
	public void setRnrm_3_6_months(BigDecimal rnrm_3_6_months) {
		this.rnrm_3_6_months = rnrm_3_6_months;
	}
	public BigDecimal getRnrm_6_12_months() {
		return rnrm_6_12_months;
	}
	public void setRnrm_6_12_months(BigDecimal rnrm_6_12_months) {
		this.rnrm_6_12_months = rnrm_6_12_months;
	}
	public BigDecimal getRnrm_1_2_years() {
		return rnrm_1_2_years;
	}
	public void setRnrm_1_2_years(BigDecimal rnrm_1_2_years) {
		this.rnrm_1_2_years = rnrm_1_2_years;
	}
	public BigDecimal getRnrm_2_3_years() {
		return rnrm_2_3_years;
	}
	public void setRnrm_2_3_years(BigDecimal rnrm_2_3_years) {
		this.rnrm_2_3_years = rnrm_2_3_years;
	}
	public BigDecimal getRnrm_3_4_years() {
		return rnrm_3_4_years;
	}
	public void setRnrm_3_4_years(BigDecimal rnrm_3_4_years) {
		this.rnrm_3_4_years = rnrm_3_4_years;
	}
	public BigDecimal getRnrm_4_5_years() {
		return rnrm_4_5_years;
	}
	public void setRnrm_4_5_years(BigDecimal rnrm_4_5_years) {
		this.rnrm_4_5_years = rnrm_4_5_years;
	}
	public BigDecimal getRnrm_5_years() {
		return rnrm_5_years;
	}
	public void setRnrm_5_years(BigDecimal rnrm_5_years) {
		this.rnrm_5_years = rnrm_5_years;
	}
	public BigDecimal getRnrm_non_interest() {
		return rnrm_non_interest;
	}
	public void setRnrm_non_interest(BigDecimal rnrm_non_interest) {
		this.rnrm_non_interest = rnrm_non_interest;
	}
	public BigDecimal getRnrm_total() {
		return rnrm_total;
	}
	public void setRnrm_total(BigDecimal rnrm_total) {
		this.rnrm_total = rnrm_total;
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
	public BRF11_ENTITY() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}