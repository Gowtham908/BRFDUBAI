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
@Table(name="BANKING_BOOK1")

public class Banking_Book1
{
	private String	r7_product;
	private BigDecimal	r7_1_to_28days;
	private BigDecimal	r7_29days_to_3months;
	private BigDecimal	r7_3months_6months;
	private BigDecimal	r7_6months_upto1year;
	private BigDecimal	r7_1year_upto3years;
	private BigDecimal	r7_3year_upto5years;
	private BigDecimal	r7_5year_upto7years;
	private BigDecimal	r7_7year_upto10years;
	private BigDecimal	r7_10year_upto15years;
	private BigDecimal	r7_15years;
	private BigDecimal	r7_nonsensitive;
	private BigDecimal	r7_total_rsl;
	private BigDecimal	r7_total;
	private String	r8_product;
	private BigDecimal	r8_1_to_28days;
	private BigDecimal	r8_29days_to_3months;
	private BigDecimal	r8_3months_6months;
	private BigDecimal	r8_6months_upto1year;
	private BigDecimal	r8_1year_upto3years;
	private BigDecimal	r8_3year_upto5years;
	private BigDecimal	r8_5year_upto7years;
	private BigDecimal	r8_7year_upto10years;
	private BigDecimal	r8_10year_upto15years;
	private BigDecimal	r8_15years;
	private BigDecimal	r8_nonsensitive;
	private BigDecimal	r8_total_rsl;
	private BigDecimal	r8_total;
	private String	r9_product;
	private BigDecimal	r9_1_to_28days;
	private BigDecimal	r9_29days_to_3months;
	private BigDecimal	r9_3months_6months;
	private BigDecimal	r9_6months_upto1year;
	private BigDecimal	r9_1year_upto3years;
	private BigDecimal	r9_3year_upto5years;
	private BigDecimal	r9_5year_upto7years;
	private BigDecimal	r9_7year_upto10years;
	private BigDecimal	r9_10year_upto15years;
	private BigDecimal	r9_15years;
	private BigDecimal	r9_nonsensitive;
	private BigDecimal	r9_total_rsl;
	private BigDecimal	r9_total;
	private String	r10_product;
	private BigDecimal	r10_1_to_28days;
	private BigDecimal	r10_29days_to_3months;
	private BigDecimal	r10_3months_6months;
	private BigDecimal	r10_6months_upto1year;
	private BigDecimal	r10_1year_upto3years;
	private BigDecimal	r10_3year_upto5years;
	private BigDecimal	r10_5year_upto7years;
	private BigDecimal	r10_7year_upto10years;
	private BigDecimal	r10_10year_upto15years;
	private BigDecimal	r10_15years;
	private BigDecimal	r10_nonsensitive;
	private BigDecimal	r10_total_rsl;
	private BigDecimal	r10_total;
	private String	r11_product;
	private BigDecimal	r11_1_to_28days;
	private BigDecimal	r11_29days_to_3months;
	private BigDecimal	r11_3months_6months;
	private BigDecimal	r11_6months_upto1year;
	private BigDecimal	r11_1year_upto3years;
	private BigDecimal	r11_3year_upto5years;
	private BigDecimal	r11_5year_upto7years;
	private BigDecimal	r11_7year_upto10years;
	private BigDecimal	r11_10year_upto15years;
	private BigDecimal	r11_15years;
	private BigDecimal	r11_nonsensitive;
	private BigDecimal	r11_total_rsl;
	private BigDecimal	r11_total;
	private String	r12_product;
	private BigDecimal	r12_1_to_28days;
	private BigDecimal	r12_29days_to_3months;
	private BigDecimal	r12_3months_6months;
	private BigDecimal	r12_6months_upto1year;
	private BigDecimal	r12_1year_upto3years;
	private BigDecimal	r12_3year_upto5years;
	private BigDecimal	r12_5year_upto7years;
	private BigDecimal	r12_7year_upto10years;
	private BigDecimal	r12_10year_upto15years;
	private BigDecimal	r12_15years;
	private BigDecimal	r12_nonsensitive;
	private BigDecimal	r12_total_rsl;
	private BigDecimal	r12_total;
	private String	r13_product;
	private BigDecimal	r13_1_to_28days;
	private BigDecimal	r13_29days_to_3months;
	private BigDecimal	r13_3months_6months;
	private BigDecimal	r13_6months_upto1year;
	private BigDecimal	r13_1year_upto3years;
	private BigDecimal	r13_3year_upto5years;
	private BigDecimal	r13_5year_upto7years;
	private BigDecimal	r13_7year_upto10years;
	private BigDecimal	r13_10year_upto15years;
	private BigDecimal	r13_15years;
	private BigDecimal	r13_nonsensitive;
	private BigDecimal	r13_total_rsl;
	private BigDecimal	r13_total;
	private String	r14_product;
	private BigDecimal	r14_1_to_28days;
	private BigDecimal	r14_29days_to_3months;
	private BigDecimal	r14_3months_6months;
	private BigDecimal	r14_6months_upto1year;
	private BigDecimal	r14_1year_upto3years;
	private BigDecimal	r14_3year_upto5years;
	private BigDecimal	r14_5year_upto7years;
	private BigDecimal	r14_7year_upto10years;
	private BigDecimal	r14_10year_upto15years;
	private BigDecimal	r14_15years;
	private BigDecimal	r14_nonsensitive;
	private BigDecimal	r14_total_rsl;
	private BigDecimal	r14_total;
	private String	r15_product;
	private BigDecimal	r15_1_to_28days;
	private BigDecimal	r15_29days_to_3months;
	private BigDecimal	r15_3months_6months;
	private BigDecimal	r15_6months_upto1year;
	private BigDecimal	r15_1year_upto3years;
	private BigDecimal	r15_3year_upto5years;
	private BigDecimal	r15_5year_upto7years;
	private BigDecimal	r15_7year_upto10years;
	private BigDecimal	r15_10year_upto15years;
	private BigDecimal	r15_15years;
	private BigDecimal	r15_nonsensitive;
	private BigDecimal	r15_total_rsl;
	private BigDecimal	r15_total;
	private String	r16_product;
	private BigDecimal	r16_1_to_28days;
	private BigDecimal	r16_29days_to_3months;
	private BigDecimal	r16_3months_6months;
	private BigDecimal	r16_6months_upto1year;
	private BigDecimal	r16_1year_upto3years;
	private BigDecimal	r16_3year_upto5years;
	private BigDecimal	r16_5year_upto7years;
	private BigDecimal	r16_7year_upto10years;
	private BigDecimal	r16_10year_upto15years;
	private BigDecimal	r16_15years;
	private BigDecimal	r16_nonsensitive;
	private BigDecimal	r16_total_rsl;
	private BigDecimal	r16_total;
	private String	r17_product;
	private BigDecimal	r17_1_to_28days;
	private BigDecimal	r17_29days_to_3months;
	private BigDecimal	r17_3months_6months;
	private BigDecimal	r17_6months_upto1year;
	private BigDecimal	r17_1year_upto3years;
	private BigDecimal	r17_3year_upto5years;
	private BigDecimal	r17_5year_upto7years;
	private BigDecimal	r17_7year_upto10years;
	private BigDecimal	r17_10year_upto15years;
	private BigDecimal	r17_15years;
	private BigDecimal	r17_nonsensitive;
	private BigDecimal	r17_total_rsl;
	private BigDecimal	r17_total;
	private String	r18_product;
	private BigDecimal	r18_1_to_28days;
	private BigDecimal	r18_29days_to_3months;
	private BigDecimal	r18_3months_6months;
	private BigDecimal	r18_6months_upto1year;
	private BigDecimal	r18_1year_upto3years;
	private BigDecimal	r18_3year_upto5years;
	private BigDecimal	r18_5year_upto7years;
	private BigDecimal	r18_7year_upto10years;
	private BigDecimal	r18_10year_upto15years;
	private BigDecimal	r18_15years;
	private BigDecimal	r18_nonsensitive;
	private BigDecimal	r18_total_rsl;
	private BigDecimal	r18_total;
	private String	r19_product;
	private BigDecimal	r19_1_to_28days;
	private BigDecimal	r19_29days_to_3months;
	private BigDecimal	r19_3months_6months;
	private BigDecimal	r19_6months_upto1year;
	private BigDecimal	r19_1year_upto3years;
	private BigDecimal	r19_3year_upto5years;
	private BigDecimal	r19_5year_upto7years;
	private BigDecimal	r19_7year_upto10years;
	private BigDecimal	r19_10year_upto15years;
	private BigDecimal	r19_15years;
	private BigDecimal	r19_nonsensitive;
	private BigDecimal	r19_total_rsl;
	private BigDecimal	r19_total;
	private String	r20_product;
	private BigDecimal	r20_1_to_28days;
	private BigDecimal	r20_29days_to_3months;
	private BigDecimal	r20_3months_6months;
	private BigDecimal	r20_6months_upto1year;
	private BigDecimal	r20_1year_upto3years;
	private BigDecimal	r20_3year_upto5years;
	private BigDecimal	r20_5year_upto7years;
	private BigDecimal	r20_7year_upto10years;
	private BigDecimal	r20_10year_upto15years;
	private BigDecimal	r20_15years;
	private BigDecimal	r20_nonsensitive;
	private BigDecimal	r20_total_rsl;
	private BigDecimal	r20_total;
	private String	r21_product;
	private BigDecimal	r21_1_to_28days;
	private BigDecimal	r21_29days_to_3months;
	private BigDecimal	r21_3months_6months;
	private BigDecimal	r21_6months_upto1year;
	private BigDecimal	r21_1year_upto3years;
	private BigDecimal	r21_3year_upto5years;
	private BigDecimal	r21_5year_upto7years;
	private BigDecimal	r21_7year_upto10years;
	private BigDecimal	r21_10year_upto15years;
	private BigDecimal	r21_15years;
	private BigDecimal	r21_nonsensitive;
	private BigDecimal	r21_total_rsl;
	private BigDecimal	r21_total;
	private String	r22_product;
	private BigDecimal	r22_1_to_28days;
	private BigDecimal	r22_29days_to_3months;
	private BigDecimal	r22_3months_6months;
	private BigDecimal	r22_6months_upto1year;
	private BigDecimal	r22_1year_upto3years;
	private BigDecimal	r22_3year_upto5years;
	private BigDecimal	r22_5year_upto7years;
	private BigDecimal	r22_7year_upto10years;
	private BigDecimal	r22_10year_upto15years;
	private BigDecimal	r22_15years;
	private BigDecimal	r22_nonsensitive;
	private BigDecimal	r22_total_rsl;
	private BigDecimal	r22_total;
	private String	r23_product;
	private BigDecimal	r23_1_to_28days;
	private BigDecimal	r23_29days_to_3months;
	private BigDecimal	r23_3months_6months;
	private BigDecimal	r23_6months_upto1year;
	private BigDecimal	r23_1year_upto3years;
	private BigDecimal	r23_3year_upto5years;
	private BigDecimal	r23_5year_upto7years;
	private BigDecimal	r23_7year_upto10years;
	private BigDecimal	r23_10year_upto15years;
	private BigDecimal	r23_15years;
	private BigDecimal	r23_nonsensitive;
	private BigDecimal	r23_total_rsl;
	private BigDecimal	r23_total;
	private String	r24_product;
	private BigDecimal	r24_1_to_28days;
	private BigDecimal	r24_29days_to_3months;
	private BigDecimal	r24_3months_6months;
	private BigDecimal	r24_6months_upto1year;
	private BigDecimal	r24_1year_upto3years;
	private BigDecimal	r24_3year_upto5years;
	private BigDecimal	r24_5year_upto7years;
	private BigDecimal	r24_7year_upto10years;
	private BigDecimal	r24_10year_upto15years;
	private BigDecimal	r24_15years;
	private BigDecimal	r24_nonsensitive;
	private BigDecimal	r24_total_rsl;
	private BigDecimal	r24_total;
	private String	r25_product;
	private BigDecimal	r25_1_to_28days;
	private BigDecimal	r25_29days_to_3months;
	private BigDecimal	r25_3months_6months;
	private BigDecimal	r25_6months_upto1year;
	private BigDecimal	r25_1year_upto3years;
	private BigDecimal	r25_3year_upto5years;
	private BigDecimal	r25_5year_upto7years;
	private BigDecimal	r25_7year_upto10years;
	private BigDecimal	r25_10year_upto15years;
	private BigDecimal	r25_15years;
	private BigDecimal	r25_nonsensitive;
	private BigDecimal	r25_total_rsl;
	private BigDecimal	r25_total;
	private String	r26_product;
	private BigDecimal	r26_1_to_28days;
	private BigDecimal	r26_29days_to_3months;
	private BigDecimal	r26_3months_6months;
	private BigDecimal	r26_6months_upto1year;
	private BigDecimal	r26_1year_upto3years;
	private BigDecimal	r26_3year_upto5years;
	private BigDecimal	r26_5year_upto7years;
	private BigDecimal	r26_7year_upto10years;
	private BigDecimal	r26_10year_upto15years;
	private BigDecimal	r26_15years;
	private BigDecimal	r26_nonsensitive;
	private BigDecimal	r26_total_rsl;
	private BigDecimal	r26_total;
	private String	r27_product;
	private BigDecimal	r27_1_to_28days;
	private BigDecimal	r27_29days_to_3months;
	private BigDecimal	r27_3months_6months;
	private BigDecimal	r27_6months_upto1year;
	private BigDecimal	r27_1year_upto3years;
	private BigDecimal	r27_3year_upto5years;
	private BigDecimal	r27_5year_upto7years;
	private BigDecimal	r27_7year_upto10years;
	private BigDecimal	r27_10year_upto15years;
	private BigDecimal	r27_15years;
	private BigDecimal	r27_nonsensitive;
	private BigDecimal	r27_total_rsl;
	private BigDecimal	r27_total;
	private String	r28_product;
	private BigDecimal	r28_1_to_28days;
	private BigDecimal	r28_29days_to_3months;
	private BigDecimal	r28_3months_6months;
	private BigDecimal	r28_6months_upto1year;
	private BigDecimal	r28_1year_upto3years;
	private BigDecimal	r28_3year_upto5years;
	private BigDecimal	r28_5year_upto7years;
	private BigDecimal	r28_7year_upto10years;
	private BigDecimal	r28_10year_upto15years;
	private BigDecimal	r28_15years;
	private BigDecimal	r28_nonsensitive;
	private BigDecimal	r28_total_rsl;
	private BigDecimal	r28_total;
	private String	r29_product;
	private BigDecimal	r29_1_to_28days;
	private BigDecimal	r29_29days_to_3months;
	private BigDecimal	r29_3months_6months;
	private BigDecimal	r29_6months_upto1year;
	private BigDecimal	r29_1year_upto3years;
	private BigDecimal	r29_3year_upto5years;
	private BigDecimal	r29_5year_upto7years;
	private BigDecimal	r29_7year_upto10years;
	private BigDecimal	r29_10year_upto15years;
	private BigDecimal	r29_15years;
	private BigDecimal	r29_nonsensitive;
	private BigDecimal	r29_total_rsl;
	private BigDecimal	r29_total;
	private String	r30_product;
	private BigDecimal	r30_1_to_28days;
	private BigDecimal	r30_29days_to_3months;
	private BigDecimal	r30_3months_6months;
	private BigDecimal	r30_6months_upto1year;
	private BigDecimal	r30_1year_upto3years;
	private BigDecimal	r30_3year_upto5years;
	private BigDecimal	r30_5year_upto7years;
	private BigDecimal	r30_7year_upto10years;
	private BigDecimal	r30_10year_upto15years;
	private BigDecimal	r30_15years;
	private BigDecimal	r30_nonsensitive;
	private BigDecimal	r30_total_rsl;
	private BigDecimal	r30_total;
	private String	r31_product;
	private BigDecimal	r31_1_to_28days;
	private BigDecimal	r31_29days_to_3months;
	private BigDecimal	r31_3months_6months;
	private BigDecimal	r31_6months_upto1year;
	private BigDecimal	r31_1year_upto3years;
	private BigDecimal	r31_3year_upto5years;
	private BigDecimal	r31_5year_upto7years;
	private BigDecimal	r31_7year_upto10years;
	private BigDecimal	r31_10year_upto15years;
	private BigDecimal	r31_15years;
	private BigDecimal	r31_nonsensitive;
	private BigDecimal	r31_total_rsl;
	private BigDecimal	r31_total;
	private String	r32_product;
	private BigDecimal	r32_1_to_28days;
	private BigDecimal	r32_29days_to_3months;
	private BigDecimal	r32_3months_6months;
	private BigDecimal	r32_6months_upto1year;
	private BigDecimal	r32_1year_upto3years;
	private BigDecimal	r32_3year_upto5years;
	private BigDecimal	r32_5year_upto7years;
	private BigDecimal	r32_7year_upto10years;
	private BigDecimal	r32_10year_upto15years;
	private BigDecimal	r32_15years;
	private BigDecimal	r32_nonsensitive;
	private BigDecimal	r32_total_rsl;
	private BigDecimal	r32_total;
	private String	r33_product;
	private BigDecimal	r33_1_to_28days;
	private BigDecimal	r33_29days_to_3months;
	private BigDecimal	r33_3months_6months;
	private BigDecimal	r33_6months_upto1year;
	private BigDecimal	r33_1year_upto3years;
	private BigDecimal	r33_3year_upto5years;
	private BigDecimal	r33_5year_upto7years;
	private BigDecimal	r33_7year_upto10years;
	private BigDecimal	r33_10year_upto15years;
	private BigDecimal	r33_15years;
	private BigDecimal	r33_nonsensitive;
	private BigDecimal	r33_total_rsl;
	private BigDecimal	r33_total;
	private String	r34_product;
	private BigDecimal	r34_1_to_28days;
	private BigDecimal	r34_29days_to_3months;
	private BigDecimal	r34_3months_6months;
	private BigDecimal	r34_6months_upto1year;
	private BigDecimal	r34_1year_upto3years;
	private BigDecimal	r34_3year_upto5years;
	private BigDecimal	r34_5year_upto7years;
	private BigDecimal	r34_7year_upto10years;
	private BigDecimal	r34_10year_upto15years;
	private BigDecimal	r34_15years;
	private BigDecimal	r34_nonsensitive;
	private BigDecimal	r34_total_rsl;
	private BigDecimal	r34_total;
	private String	r35_product;
	private BigDecimal	r35_1_to_28days;
	private BigDecimal	r35_29days_to_3months;
	private BigDecimal	r35_3months_6months;
	private BigDecimal	r35_6months_upto1year;
	private BigDecimal	r35_1year_upto3years;
	private BigDecimal	r35_3year_upto5years;
	private BigDecimal	r35_5year_upto7years;
	private BigDecimal	r35_7year_upto10years;
	private BigDecimal	r35_10year_upto15years;
	private BigDecimal	r35_15years;
	private BigDecimal	r35_nonsensitive;
	private BigDecimal	r35_total_rsl;
	private BigDecimal	r35_total;
	private String	r36_product;
	private BigDecimal	r36_1_to_28days;
	private BigDecimal	r36_29days_to_3months;
	private BigDecimal	r36_3months_6months;
	private BigDecimal	r36_6months_upto1year;
	private BigDecimal	r36_1year_upto3years;
	private BigDecimal	r36_3year_upto5years;
	private BigDecimal	r36_5year_upto7years;
	private BigDecimal	r36_7year_upto10years;
	private BigDecimal	r36_10year_upto15years;
	private BigDecimal	r36_15years;
	private BigDecimal	r36_nonsensitive;
	private BigDecimal	r36_total_rsl;
	private BigDecimal	r36_total;
	private String	r37_product;
	private BigDecimal	r37_1_to_28days;
	private BigDecimal	r37_29days_to_3months;
	private BigDecimal	r37_3months_6months;
	private BigDecimal	r37_6months_upto1year;
	private BigDecimal	r37_1year_upto3years;
	private BigDecimal	r37_3year_upto5years;
	private BigDecimal	r37_5year_upto7years;
	private BigDecimal	r37_7year_upto10years;
	private BigDecimal	r37_10year_upto15years;
	private BigDecimal	r37_15years;
	private BigDecimal	r37_nonsensitive;
	private BigDecimal	r37_total_rsl;
	private BigDecimal	r37_total;
	private String	r38_product;
	private BigDecimal	r38_1_to_28days;
	private BigDecimal	r38_29days_to_3months;
	private BigDecimal	r38_3months_6months;
	private BigDecimal	r38_6months_upto1year;
	private BigDecimal	r38_1year_upto3years;
	private BigDecimal	r38_3year_upto5years;
	private BigDecimal	r38_5year_upto7years;
	private BigDecimal	r38_7year_upto10years;
	private BigDecimal	r38_10year_upto15years;
	private BigDecimal	r38_15years;
	private BigDecimal	r38_nonsensitive;
	private BigDecimal	r38_total_rsl;
	private BigDecimal	r38_total;
	private String	r39_product;
	private BigDecimal	r39_1_to_28days;
	private BigDecimal	r39_29days_to_3months;
	private BigDecimal	r39_3months_6months;
	private BigDecimal	r39_6months_upto1year;
	private BigDecimal	r39_1year_upto3years;
	private BigDecimal	r39_3year_upto5years;
	private BigDecimal	r39_5year_upto7years;
	private BigDecimal	r39_7year_upto10years;
	private BigDecimal	r39_10year_upto15years;
	private BigDecimal	r39_15years;
	private BigDecimal	r39_nonsensitive;
	private BigDecimal	r39_total_rsl;
	private BigDecimal	r39_total;
	private String	r40_product;
	private BigDecimal	r40_1_to_28days;
	private BigDecimal	r40_29days_to_3months;
	private BigDecimal	r40_3months_6months;
	private BigDecimal	r40_6months_upto1year;
	private BigDecimal	r40_1year_upto3years;
	private BigDecimal	r40_3year_upto5years;
	private BigDecimal	r40_5year_upto7years;
	private BigDecimal	r40_7year_upto10years;
	private BigDecimal	r40_10year_upto15years;
	private BigDecimal	r40_15years;
	private BigDecimal	r40_nonsensitive;
	private BigDecimal	r40_total_rsl;
	private BigDecimal	r40_total;
	private String	r41_product;
	private BigDecimal	r41_1_to_28days;
	private BigDecimal	r41_29days_to_3months;
	private BigDecimal	r41_3months_6months;
	private BigDecimal	r41_6months_upto1year;
	private BigDecimal	r41_1year_upto3years;
	private BigDecimal	r41_3year_upto5years;
	private BigDecimal	r41_5year_upto7years;
	private BigDecimal	r41_7year_upto10years;
	private BigDecimal	r41_10year_upto15years;
	private BigDecimal	r41_15years;
	private BigDecimal	r41_nonsensitive;
	private BigDecimal	r41_total_rsl;
	private BigDecimal	r41_total;
	private String	r42_product;
	private BigDecimal	r42_1_to_28days;
	private BigDecimal	r42_29days_to_3months;
	private BigDecimal	r42_3months_6months;
	private BigDecimal	r42_6months_upto1year;
	private BigDecimal	r42_1year_upto3years;
	private BigDecimal	r42_3year_upto5years;
	private BigDecimal	r42_5year_upto7years;
	private BigDecimal	r42_7year_upto10years;
	private BigDecimal	r42_10year_upto15years;
	private BigDecimal	r42_15years;
	private BigDecimal	r42_nonsensitive;
	private BigDecimal	r42_total_rsl;
	private BigDecimal	r42_total;
	private String	r43_product;
	private BigDecimal	r43_1_to_28days;
	private BigDecimal	r43_29days_to_3months;
	private BigDecimal	r43_3months_6months;
	private BigDecimal	r43_6months_upto1year;
	private BigDecimal	r43_1year_upto3years;
	private BigDecimal	r43_3year_upto5years;
	private BigDecimal	r43_5year_upto7years;
	private BigDecimal	r43_7year_upto10years;
	private BigDecimal	r43_10year_upto15years;
	private BigDecimal	r43_15years;
	private BigDecimal	r43_nonsensitive;
	private BigDecimal	r43_total_rsl;
	private BigDecimal	r43_total;
	private String	r44_product;
	private BigDecimal	r44_1_to_28days;
	private BigDecimal	r44_29days_to_3months;
	private BigDecimal	r44_3months_6months;
	private BigDecimal	r44_6months_upto1year;
	private BigDecimal	r44_1year_upto3years;
	private BigDecimal	r44_3year_upto5years;
	private BigDecimal	r44_5year_upto7years;
	private BigDecimal	r44_7year_upto10years;
	private BigDecimal	r44_10year_upto15years;
	private BigDecimal	r44_15years;
	private BigDecimal	r44_nonsensitive;
	private BigDecimal	r44_total_rsl;
	private BigDecimal	r44_total;
	private String	r45_product;
	private BigDecimal	r45_1_to_28days;
	private BigDecimal	r45_29days_to_3months;
	private BigDecimal	r45_3months_6months;
	private BigDecimal	r45_6months_upto1year;
	private BigDecimal	r45_1year_upto3years;
	private BigDecimal	r45_3year_upto5years;
	private BigDecimal	r45_5year_upto7years;
	private BigDecimal	r45_7year_upto10years;
	private BigDecimal	r45_10year_upto15years;
	private BigDecimal	r45_15years;
	private BigDecimal	r45_nonsensitive;
	private BigDecimal	r45_total_rsl;
	private BigDecimal	r45_total;
	private String	r46_product;
	private BigDecimal	r46_1_to_28days;
	private BigDecimal	r46_29days_to_3months;
	private BigDecimal	r46_3months_6months;
	private BigDecimal	r46_6months_upto1year;
	private BigDecimal	r46_1year_upto3years;
	private BigDecimal	r46_3year_upto5years;
	private BigDecimal	r46_5year_upto7years;
	private BigDecimal	r46_7year_upto10years;
	private BigDecimal	r46_10year_upto15years;
	private BigDecimal	r46_15years;
	private BigDecimal	r46_nonsensitive;
	private BigDecimal	r46_total_rsl;
	private BigDecimal	r46_total;
	private String	r47_product;
	private BigDecimal	r47_1_to_28days;
	private BigDecimal	r47_29days_to_3months;
	private BigDecimal	r47_3months_6months;
	private BigDecimal	r47_6months_upto1year;
	private BigDecimal	r47_1year_upto3years;
	private BigDecimal	r47_3year_upto5years;
	private BigDecimal	r47_5year_upto7years;
	private BigDecimal	r47_7year_upto10years;
	private BigDecimal	r47_10year_upto15years;
	private BigDecimal	r47_15years;
	private BigDecimal	r47_nonsensitive;
	private BigDecimal	r47_total_rsl;
	private BigDecimal	r47_total;
	private String	r48_product;
	private BigDecimal	r48_1_to_28days;
	private BigDecimal	r48_29days_to_3months;
	private BigDecimal	r48_3months_6months;
	private BigDecimal	r48_6months_upto1year;
	private BigDecimal	r48_1year_upto3years;
	private BigDecimal	r48_3year_upto5years;
	private BigDecimal	r48_5year_upto7years;
	private BigDecimal	r48_7year_upto10years;
	private BigDecimal	r48_10year_upto15years;
	private BigDecimal	r48_15years;
	private BigDecimal	r48_nonsensitive;
	private BigDecimal	r48_total_rsl;
	private BigDecimal	r48_total;
	private String	r49_product;
	private BigDecimal	r49_1_to_28days;
	private BigDecimal	r49_29days_to_3months;
	private BigDecimal	r49_3months_6months;
	private BigDecimal	r49_6months_upto1year;
	private BigDecimal	r49_1year_upto3years;
	private BigDecimal	r49_3year_upto5years;
	private BigDecimal	r49_5year_upto7years;
	private BigDecimal	r49_7year_upto10years;
	private BigDecimal	r49_10year_upto15years;
	private BigDecimal	r49_15years;
	private BigDecimal	r49_nonsensitive;
	private BigDecimal	r49_total_rsl;
	private BigDecimal	r49_total;
	private String	r50_product;
	private BigDecimal	r50_1_to_28days;
	private BigDecimal	r50_29days_to_3months;
	private BigDecimal	r50_3months_6months;
	private BigDecimal	r50_6months_upto1year;
	private BigDecimal	r50_1year_upto3years;
	private BigDecimal	r50_3year_upto5years;
	private BigDecimal	r50_5year_upto7years;
	private BigDecimal	r50_7year_upto10years;
	private BigDecimal	r50_10year_upto15years;
	private BigDecimal	r50_15years;
	private BigDecimal	r50_nonsensitive;
	private BigDecimal	r50_total_rsl;
	private BigDecimal	r50_total;
	private String	r51_product;
	private BigDecimal	r51_1_to_28days;
	private BigDecimal	r51_29days_to_3months;
	private BigDecimal	r51_3months_6months;
	private BigDecimal	r51_6months_upto1year;
	private BigDecimal	r51_1year_upto3years;
	private BigDecimal	r51_3year_upto5years;
	private BigDecimal	r51_5year_upto7years;
	private BigDecimal	r51_7year_upto10years;
	private BigDecimal	r51_10year_upto15years;
	private BigDecimal	r51_15years;
	private BigDecimal	r51_nonsensitive;
	private BigDecimal	r51_total_rsl;
	private BigDecimal	r51_total;
	private String	r52_product;
	private BigDecimal	r52_1_to_28days;
	private BigDecimal	r52_29days_to_3months;
	private BigDecimal	r52_3months_6months;
	private BigDecimal	r52_6months_upto1year;
	private BigDecimal	r52_1year_upto3years;
	private BigDecimal	r52_3year_upto5years;
	private BigDecimal	r52_5year_upto7years;
	private BigDecimal	r52_7year_upto10years;
	private BigDecimal	r52_10year_upto15years;
	private BigDecimal	r52_15years;
	private BigDecimal	r52_nonsensitive;
	private BigDecimal	r52_total_rsl;
	private BigDecimal	r52_total;
	private String	r53_product;
	private BigDecimal	r53_1_to_28days;
	private BigDecimal	r53_29days_to_3months;
	private BigDecimal	r53_3months_6months;
	private BigDecimal	r53_6months_upto1year;
	private BigDecimal	r53_1year_upto3years;
	private BigDecimal	r53_3year_upto5years;
	private BigDecimal	r53_5year_upto7years;
	private BigDecimal	r53_7year_upto10years;
	private BigDecimal	r53_10year_upto15years;
	private BigDecimal	r53_15years;
	private BigDecimal	r53_nonsensitive;
	private BigDecimal	r53_total_rsl;
	private BigDecimal	r53_total;
	private String	r54_product;
	private BigDecimal	r54_1_to_28days;
	private BigDecimal	r54_29days_to_3months;
	private BigDecimal	r54_3months_6months;
	private BigDecimal	r54_6months_upto1year;
	private BigDecimal	r54_1year_upto3years;
	private BigDecimal	r54_3year_upto5years;
	private BigDecimal	r54_5year_upto7years;
	private BigDecimal	r54_7year_upto10years;
	private BigDecimal	r54_10year_upto15years;
	private BigDecimal	r54_15years;
	private BigDecimal	r54_nonsensitive;
	private BigDecimal	r54_total_rsl;
	private BigDecimal	r54_total;
	private String	r55_product;
	private BigDecimal	r55_1_to_28days;
	private BigDecimal	r55_29days_to_3months;
	private BigDecimal	r55_3months_6months;
	private BigDecimal	r55_6months_upto1year;
	private BigDecimal	r55_1year_upto3years;
	private BigDecimal	r55_3year_upto5years;
	private BigDecimal	r55_5year_upto7years;
	private BigDecimal	r55_7year_upto10years;
	private BigDecimal	r55_10year_upto15years;
	private BigDecimal	r55_15years;
	private BigDecimal	r55_nonsensitive;
	private BigDecimal	r55_total_rsl;
	private BigDecimal	r55_total;
	private String	r56_product;
	private BigDecimal	r56_1_to_28days;
	private BigDecimal	r56_29days_to_3months;
	private BigDecimal	r56_3months_6months;
	private BigDecimal	r56_6months_upto1year;
	private BigDecimal	r56_1year_upto3years;
	private BigDecimal	r56_3year_upto5years;
	private BigDecimal	r56_5year_upto7years;
	private BigDecimal	r56_7year_upto10years;
	private BigDecimal	r56_10year_upto15years;
	private BigDecimal	r56_15years;
	private BigDecimal	r56_nonsensitive;
	private BigDecimal	r56_total_rsl;
	private BigDecimal	r56_total;
	private String	r57_product;
	private BigDecimal	r57_1_to_28days;
	private BigDecimal	r57_29days_to_3months;
	private BigDecimal	r57_3months_6months;
	private BigDecimal	r57_6months_upto1year;
	private BigDecimal	r57_1year_upto3years;
	private BigDecimal	r57_3year_upto5years;
	private BigDecimal	r57_5year_upto7years;
	private BigDecimal	r57_7year_upto10years;
	private BigDecimal	r57_10year_upto15years;
	private BigDecimal	r57_15years;
	private BigDecimal	r57_nonsensitive;
	private BigDecimal	r57_total_rsl;
	private BigDecimal	r57_total;
	private String	r58_product;
	private BigDecimal	r58_1_to_28days;
	private BigDecimal	r58_29days_to_3months;
	private BigDecimal	r58_3months_6months;
	private BigDecimal	r58_6months_upto1year;
	private BigDecimal	r58_1year_upto3years;
	private BigDecimal	r58_3year_upto5years;
	private BigDecimal	r58_5year_upto7years;
	private BigDecimal	r58_7year_upto10years;
	private BigDecimal	r58_10year_upto15years;
	private BigDecimal	r58_15years;
	private BigDecimal	r58_nonsensitive;
	private BigDecimal	r58_total_rsl;
	private BigDecimal	r58_total;
	private String	r59_product;
	private BigDecimal	r59_1_to_28days;
	private BigDecimal	r59_29days_to_3months;
	private BigDecimal	r59_3months_6months;
	private BigDecimal	r59_6months_upto1year;
	private BigDecimal	r59_1year_upto3years;
	private BigDecimal	r59_3year_upto5years;
	private BigDecimal	r59_5year_upto7years;
	private BigDecimal	r59_7year_upto10years;
	private BigDecimal	r59_10year_upto15years;
	private BigDecimal	r59_15years;
	private BigDecimal	r59_nonsensitive;
	private BigDecimal	r59_total_rsl;
	private BigDecimal	r59_total;
	private String	r60_product;
	private BigDecimal	r60_1_to_28days;
	private BigDecimal	r60_29days_to_3months;
	private BigDecimal	r60_3months_6months;
	private BigDecimal	r60_6months_upto1year;
	private BigDecimal	r60_1year_upto3years;
	private BigDecimal	r60_3year_upto5years;
	private BigDecimal	r60_5year_upto7years;
	private BigDecimal	r60_7year_upto10years;
	private BigDecimal	r60_10year_upto15years;
	private BigDecimal	r60_15years;
	private BigDecimal	r60_nonsensitive;
	private BigDecimal	r60_total_rsl;
	private BigDecimal	r60_total;
	@Id
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date	report_date;

	private Date	report_from_date;
	private Date	report_to_date;
	private String	entity_flg;
	private String	modify_flg;
	private String	del_flg;
	private String	report_code;
	private Date	report_submit_date;
	public String getR7_product() {
		return r7_product;
	}
	public void setR7_product(String r7_product) {
		this.r7_product = r7_product;
	}
	public BigDecimal getR7_1_to_28days() {
		return r7_1_to_28days;
	}
	public void setR7_1_to_28days(BigDecimal r7_1_to_28days) {
		this.r7_1_to_28days = r7_1_to_28days;
	}
	public BigDecimal getR7_29days_to_3months() {
		return r7_29days_to_3months;
	}
	public void setR7_29days_to_3months(BigDecimal r7_29days_to_3months) {
		this.r7_29days_to_3months = r7_29days_to_3months;
	}
	public BigDecimal getR7_3months_6months() {
		return r7_3months_6months;
	}
	public void setR7_3months_6months(BigDecimal r7_3months_6months) {
		this.r7_3months_6months = r7_3months_6months;
	}
	public BigDecimal getR7_6months_upto1year() {
		return r7_6months_upto1year;
	}
	public void setR7_6months_upto1year(BigDecimal r7_6months_upto1year) {
		this.r7_6months_upto1year = r7_6months_upto1year;
	}
	public BigDecimal getR7_1year_upto3years() {
		return r7_1year_upto3years;
	}
	public void setR7_1year_upto3years(BigDecimal r7_1year_upto3years) {
		this.r7_1year_upto3years = r7_1year_upto3years;
	}
	public BigDecimal getR7_3year_upto5years() {
		return r7_3year_upto5years;
	}
	public void setR7_3year_upto5years(BigDecimal r7_3year_upto5years) {
		this.r7_3year_upto5years = r7_3year_upto5years;
	}
	public BigDecimal getR7_5year_upto7years() {
		return r7_5year_upto7years;
	}
	public void setR7_5year_upto7years(BigDecimal r7_5year_upto7years) {
		this.r7_5year_upto7years = r7_5year_upto7years;
	}
	public BigDecimal getR7_7year_upto10years() {
		return r7_7year_upto10years;
	}
	public void setR7_7year_upto10years(BigDecimal r7_7year_upto10years) {
		this.r7_7year_upto10years = r7_7year_upto10years;
	}
	public BigDecimal getR7_10year_upto15years() {
		return r7_10year_upto15years;
	}
	public void setR7_10year_upto15years(BigDecimal r7_10year_upto15years) {
		this.r7_10year_upto15years = r7_10year_upto15years;
	}
	public BigDecimal getR7_15years() {
		return r7_15years;
	}
	public void setR7_15years(BigDecimal r7_15years) {
		this.r7_15years = r7_15years;
	}
	public BigDecimal getR7_nonsensitive() {
		return r7_nonsensitive;
	}
	public void setR7_nonsensitive(BigDecimal r7_nonsensitive) {
		this.r7_nonsensitive = r7_nonsensitive;
	}
	public BigDecimal getR7_total_rsl() {
		return r7_total_rsl;
	}
	public void setR7_total_rsl(BigDecimal r7_total_rsl) {
		this.r7_total_rsl = r7_total_rsl;
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
	public BigDecimal getR8_1_to_28days() {
		return r8_1_to_28days;
	}
	public void setR8_1_to_28days(BigDecimal r8_1_to_28days) {
		this.r8_1_to_28days = r8_1_to_28days;
	}
	public BigDecimal getR8_29days_to_3months() {
		return r8_29days_to_3months;
	}
	public void setR8_29days_to_3months(BigDecimal r8_29days_to_3months) {
		this.r8_29days_to_3months = r8_29days_to_3months;
	}
	public BigDecimal getR8_3months_6months() {
		return r8_3months_6months;
	}
	public void setR8_3months_6months(BigDecimal r8_3months_6months) {
		this.r8_3months_6months = r8_3months_6months;
	}
	public BigDecimal getR8_6months_upto1year() {
		return r8_6months_upto1year;
	}
	public void setR8_6months_upto1year(BigDecimal r8_6months_upto1year) {
		this.r8_6months_upto1year = r8_6months_upto1year;
	}
	public BigDecimal getR8_1year_upto3years() {
		return r8_1year_upto3years;
	}
	public void setR8_1year_upto3years(BigDecimal r8_1year_upto3years) {
		this.r8_1year_upto3years = r8_1year_upto3years;
	}
	public BigDecimal getR8_3year_upto5years() {
		return r8_3year_upto5years;
	}
	public void setR8_3year_upto5years(BigDecimal r8_3year_upto5years) {
		this.r8_3year_upto5years = r8_3year_upto5years;
	}
	public BigDecimal getR8_5year_upto7years() {
		return r8_5year_upto7years;
	}
	public void setR8_5year_upto7years(BigDecimal r8_5year_upto7years) {
		this.r8_5year_upto7years = r8_5year_upto7years;
	}
	public BigDecimal getR8_7year_upto10years() {
		return r8_7year_upto10years;
	}
	public void setR8_7year_upto10years(BigDecimal r8_7year_upto10years) {
		this.r8_7year_upto10years = r8_7year_upto10years;
	}
	public BigDecimal getR8_10year_upto15years() {
		return r8_10year_upto15years;
	}
	public void setR8_10year_upto15years(BigDecimal r8_10year_upto15years) {
		this.r8_10year_upto15years = r8_10year_upto15years;
	}
	public BigDecimal getR8_15years() {
		return r8_15years;
	}
	public void setR8_15years(BigDecimal r8_15years) {
		this.r8_15years = r8_15years;
	}
	public BigDecimal getR8_nonsensitive() {
		return r8_nonsensitive;
	}
	public void setR8_nonsensitive(BigDecimal r8_nonsensitive) {
		this.r8_nonsensitive = r8_nonsensitive;
	}
	public BigDecimal getR8_total_rsl() {
		return r8_total_rsl;
	}
	public void setR8_total_rsl(BigDecimal r8_total_rsl) {
		this.r8_total_rsl = r8_total_rsl;
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
	public BigDecimal getR9_1_to_28days() {
		return r9_1_to_28days;
	}
	public void setR9_1_to_28days(BigDecimal r9_1_to_28days) {
		this.r9_1_to_28days = r9_1_to_28days;
	}
	public BigDecimal getR9_29days_to_3months() {
		return r9_29days_to_3months;
	}
	public void setR9_29days_to_3months(BigDecimal r9_29days_to_3months) {
		this.r9_29days_to_3months = r9_29days_to_3months;
	}
	public BigDecimal getR9_3months_6months() {
		return r9_3months_6months;
	}
	public void setR9_3months_6months(BigDecimal r9_3months_6months) {
		this.r9_3months_6months = r9_3months_6months;
	}
	public BigDecimal getR9_6months_upto1year() {
		return r9_6months_upto1year;
	}
	public void setR9_6months_upto1year(BigDecimal r9_6months_upto1year) {
		this.r9_6months_upto1year = r9_6months_upto1year;
	}
	public BigDecimal getR9_1year_upto3years() {
		return r9_1year_upto3years;
	}
	public void setR9_1year_upto3years(BigDecimal r9_1year_upto3years) {
		this.r9_1year_upto3years = r9_1year_upto3years;
	}
	public BigDecimal getR9_3year_upto5years() {
		return r9_3year_upto5years;
	}
	public void setR9_3year_upto5years(BigDecimal r9_3year_upto5years) {
		this.r9_3year_upto5years = r9_3year_upto5years;
	}
	public BigDecimal getR9_5year_upto7years() {
		return r9_5year_upto7years;
	}
	public void setR9_5year_upto7years(BigDecimal r9_5year_upto7years) {
		this.r9_5year_upto7years = r9_5year_upto7years;
	}
	public BigDecimal getR9_7year_upto10years() {
		return r9_7year_upto10years;
	}
	public void setR9_7year_upto10years(BigDecimal r9_7year_upto10years) {
		this.r9_7year_upto10years = r9_7year_upto10years;
	}
	public BigDecimal getR9_10year_upto15years() {
		return r9_10year_upto15years;
	}
	public void setR9_10year_upto15years(BigDecimal r9_10year_upto15years) {
		this.r9_10year_upto15years = r9_10year_upto15years;
	}
	public BigDecimal getR9_15years() {
		return r9_15years;
	}
	public void setR9_15years(BigDecimal r9_15years) {
		this.r9_15years = r9_15years;
	}
	public BigDecimal getR9_nonsensitive() {
		return r9_nonsensitive;
	}
	public void setR9_nonsensitive(BigDecimal r9_nonsensitive) {
		this.r9_nonsensitive = r9_nonsensitive;
	}
	public BigDecimal getR9_total_rsl() {
		return r9_total_rsl;
	}
	public void setR9_total_rsl(BigDecimal r9_total_rsl) {
		this.r9_total_rsl = r9_total_rsl;
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
	public BigDecimal getR10_1_to_28days() {
		return r10_1_to_28days;
	}
	public void setR10_1_to_28days(BigDecimal r10_1_to_28days) {
		this.r10_1_to_28days = r10_1_to_28days;
	}
	public BigDecimal getR10_29days_to_3months() {
		return r10_29days_to_3months;
	}
	public void setR10_29days_to_3months(BigDecimal r10_29days_to_3months) {
		this.r10_29days_to_3months = r10_29days_to_3months;
	}
	public BigDecimal getR10_3months_6months() {
		return r10_3months_6months;
	}
	public void setR10_3months_6months(BigDecimal r10_3months_6months) {
		this.r10_3months_6months = r10_3months_6months;
	}
	public BigDecimal getR10_6months_upto1year() {
		return r10_6months_upto1year;
	}
	public void setR10_6months_upto1year(BigDecimal r10_6months_upto1year) {
		this.r10_6months_upto1year = r10_6months_upto1year;
	}
	public BigDecimal getR10_1year_upto3years() {
		return r10_1year_upto3years;
	}
	public void setR10_1year_upto3years(BigDecimal r10_1year_upto3years) {
		this.r10_1year_upto3years = r10_1year_upto3years;
	}
	public BigDecimal getR10_3year_upto5years() {
		return r10_3year_upto5years;
	}
	public void setR10_3year_upto5years(BigDecimal r10_3year_upto5years) {
		this.r10_3year_upto5years = r10_3year_upto5years;
	}
	public BigDecimal getR10_5year_upto7years() {
		return r10_5year_upto7years;
	}
	public void setR10_5year_upto7years(BigDecimal r10_5year_upto7years) {
		this.r10_5year_upto7years = r10_5year_upto7years;
	}
	public BigDecimal getR10_7year_upto10years() {
		return r10_7year_upto10years;
	}
	public void setR10_7year_upto10years(BigDecimal r10_7year_upto10years) {
		this.r10_7year_upto10years = r10_7year_upto10years;
	}
	public BigDecimal getR10_10year_upto15years() {
		return r10_10year_upto15years;
	}
	public void setR10_10year_upto15years(BigDecimal r10_10year_upto15years) {
		this.r10_10year_upto15years = r10_10year_upto15years;
	}
	public BigDecimal getR10_15years() {
		return r10_15years;
	}
	public void setR10_15years(BigDecimal r10_15years) {
		this.r10_15years = r10_15years;
	}
	public BigDecimal getR10_nonsensitive() {
		return r10_nonsensitive;
	}
	public void setR10_nonsensitive(BigDecimal r10_nonsensitive) {
		this.r10_nonsensitive = r10_nonsensitive;
	}
	public BigDecimal getR10_total_rsl() {
		return r10_total_rsl;
	}
	public void setR10_total_rsl(BigDecimal r10_total_rsl) {
		this.r10_total_rsl = r10_total_rsl;
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
	public BigDecimal getR11_1_to_28days() {
		return r11_1_to_28days;
	}
	public void setR11_1_to_28days(BigDecimal r11_1_to_28days) {
		this.r11_1_to_28days = r11_1_to_28days;
	}
	public BigDecimal getR11_29days_to_3months() {
		return r11_29days_to_3months;
	}
	public void setR11_29days_to_3months(BigDecimal r11_29days_to_3months) {
		this.r11_29days_to_3months = r11_29days_to_3months;
	}
	public BigDecimal getR11_3months_6months() {
		return r11_3months_6months;
	}
	public void setR11_3months_6months(BigDecimal r11_3months_6months) {
		this.r11_3months_6months = r11_3months_6months;
	}
	public BigDecimal getR11_6months_upto1year() {
		return r11_6months_upto1year;
	}
	public void setR11_6months_upto1year(BigDecimal r11_6months_upto1year) {
		this.r11_6months_upto1year = r11_6months_upto1year;
	}
	public BigDecimal getR11_1year_upto3years() {
		return r11_1year_upto3years;
	}
	public void setR11_1year_upto3years(BigDecimal r11_1year_upto3years) {
		this.r11_1year_upto3years = r11_1year_upto3years;
	}
	public BigDecimal getR11_3year_upto5years() {
		return r11_3year_upto5years;
	}
	public void setR11_3year_upto5years(BigDecimal r11_3year_upto5years) {
		this.r11_3year_upto5years = r11_3year_upto5years;
	}
	public BigDecimal getR11_5year_upto7years() {
		return r11_5year_upto7years;
	}
	public void setR11_5year_upto7years(BigDecimal r11_5year_upto7years) {
		this.r11_5year_upto7years = r11_5year_upto7years;
	}
	public BigDecimal getR11_7year_upto10years() {
		return r11_7year_upto10years;
	}
	public void setR11_7year_upto10years(BigDecimal r11_7year_upto10years) {
		this.r11_7year_upto10years = r11_7year_upto10years;
	}
	public BigDecimal getR11_10year_upto15years() {
		return r11_10year_upto15years;
	}
	public void setR11_10year_upto15years(BigDecimal r11_10year_upto15years) {
		this.r11_10year_upto15years = r11_10year_upto15years;
	}
	public BigDecimal getR11_15years() {
		return r11_15years;
	}
	public void setR11_15years(BigDecimal r11_15years) {
		this.r11_15years = r11_15years;
	}
	public BigDecimal getR11_nonsensitive() {
		return r11_nonsensitive;
	}
	public void setR11_nonsensitive(BigDecimal r11_nonsensitive) {
		this.r11_nonsensitive = r11_nonsensitive;
	}
	public BigDecimal getR11_total_rsl() {
		return r11_total_rsl;
	}
	public void setR11_total_rsl(BigDecimal r11_total_rsl) {
		this.r11_total_rsl = r11_total_rsl;
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
	public BigDecimal getR12_1_to_28days() {
		return r12_1_to_28days;
	}
	public void setR12_1_to_28days(BigDecimal r12_1_to_28days) {
		this.r12_1_to_28days = r12_1_to_28days;
	}
	public BigDecimal getR12_29days_to_3months() {
		return r12_29days_to_3months;
	}
	public void setR12_29days_to_3months(BigDecimal r12_29days_to_3months) {
		this.r12_29days_to_3months = r12_29days_to_3months;
	}
	public BigDecimal getR12_3months_6months() {
		return r12_3months_6months;
	}
	public void setR12_3months_6months(BigDecimal r12_3months_6months) {
		this.r12_3months_6months = r12_3months_6months;
	}
	public BigDecimal getR12_6months_upto1year() {
		return r12_6months_upto1year;
	}
	public void setR12_6months_upto1year(BigDecimal r12_6months_upto1year) {
		this.r12_6months_upto1year = r12_6months_upto1year;
	}
	public BigDecimal getR12_1year_upto3years() {
		return r12_1year_upto3years;
	}
	public void setR12_1year_upto3years(BigDecimal r12_1year_upto3years) {
		this.r12_1year_upto3years = r12_1year_upto3years;
	}
	public BigDecimal getR12_3year_upto5years() {
		return r12_3year_upto5years;
	}
	public void setR12_3year_upto5years(BigDecimal r12_3year_upto5years) {
		this.r12_3year_upto5years = r12_3year_upto5years;
	}
	public BigDecimal getR12_5year_upto7years() {
		return r12_5year_upto7years;
	}
	public void setR12_5year_upto7years(BigDecimal r12_5year_upto7years) {
		this.r12_5year_upto7years = r12_5year_upto7years;
	}
	public BigDecimal getR12_7year_upto10years() {
		return r12_7year_upto10years;
	}
	public void setR12_7year_upto10years(BigDecimal r12_7year_upto10years) {
		this.r12_7year_upto10years = r12_7year_upto10years;
	}
	public BigDecimal getR12_10year_upto15years() {
		return r12_10year_upto15years;
	}
	public void setR12_10year_upto15years(BigDecimal r12_10year_upto15years) {
		this.r12_10year_upto15years = r12_10year_upto15years;
	}
	public BigDecimal getR12_15years() {
		return r12_15years;
	}
	public void setR12_15years(BigDecimal r12_15years) {
		this.r12_15years = r12_15years;
	}
	public BigDecimal getR12_nonsensitive() {
		return r12_nonsensitive;
	}
	public void setR12_nonsensitive(BigDecimal r12_nonsensitive) {
		this.r12_nonsensitive = r12_nonsensitive;
	}
	public BigDecimal getR12_total_rsl() {
		return r12_total_rsl;
	}
	public void setR12_total_rsl(BigDecimal r12_total_rsl) {
		this.r12_total_rsl = r12_total_rsl;
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
	public BigDecimal getR13_1_to_28days() {
		return r13_1_to_28days;
	}
	public void setR13_1_to_28days(BigDecimal r13_1_to_28days) {
		this.r13_1_to_28days = r13_1_to_28days;
	}
	public BigDecimal getR13_29days_to_3months() {
		return r13_29days_to_3months;
	}
	public void setR13_29days_to_3months(BigDecimal r13_29days_to_3months) {
		this.r13_29days_to_3months = r13_29days_to_3months;
	}
	public BigDecimal getR13_3months_6months() {
		return r13_3months_6months;
	}
	public void setR13_3months_6months(BigDecimal r13_3months_6months) {
		this.r13_3months_6months = r13_3months_6months;
	}
	public BigDecimal getR13_6months_upto1year() {
		return r13_6months_upto1year;
	}
	public void setR13_6months_upto1year(BigDecimal r13_6months_upto1year) {
		this.r13_6months_upto1year = r13_6months_upto1year;
	}
	public BigDecimal getR13_1year_upto3years() {
		return r13_1year_upto3years;
	}
	public void setR13_1year_upto3years(BigDecimal r13_1year_upto3years) {
		this.r13_1year_upto3years = r13_1year_upto3years;
	}
	public BigDecimal getR13_3year_upto5years() {
		return r13_3year_upto5years;
	}
	public void setR13_3year_upto5years(BigDecimal r13_3year_upto5years) {
		this.r13_3year_upto5years = r13_3year_upto5years;
	}
	public BigDecimal getR13_5year_upto7years() {
		return r13_5year_upto7years;
	}
	public void setR13_5year_upto7years(BigDecimal r13_5year_upto7years) {
		this.r13_5year_upto7years = r13_5year_upto7years;
	}
	public BigDecimal getR13_7year_upto10years() {
		return r13_7year_upto10years;
	}
	public void setR13_7year_upto10years(BigDecimal r13_7year_upto10years) {
		this.r13_7year_upto10years = r13_7year_upto10years;
	}
	public BigDecimal getR13_10year_upto15years() {
		return r13_10year_upto15years;
	}
	public void setR13_10year_upto15years(BigDecimal r13_10year_upto15years) {
		this.r13_10year_upto15years = r13_10year_upto15years;
	}
	public BigDecimal getR13_15years() {
		return r13_15years;
	}
	public void setR13_15years(BigDecimal r13_15years) {
		this.r13_15years = r13_15years;
	}
	public BigDecimal getR13_nonsensitive() {
		return r13_nonsensitive;
	}
	public void setR13_nonsensitive(BigDecimal r13_nonsensitive) {
		this.r13_nonsensitive = r13_nonsensitive;
	}
	public BigDecimal getR13_total_rsl() {
		return r13_total_rsl;
	}
	public void setR13_total_rsl(BigDecimal r13_total_rsl) {
		this.r13_total_rsl = r13_total_rsl;
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
	public BigDecimal getR14_1_to_28days() {
		return r14_1_to_28days;
	}
	public void setR14_1_to_28days(BigDecimal r14_1_to_28days) {
		this.r14_1_to_28days = r14_1_to_28days;
	}
	public BigDecimal getR14_29days_to_3months() {
		return r14_29days_to_3months;
	}
	public void setR14_29days_to_3months(BigDecimal r14_29days_to_3months) {
		this.r14_29days_to_3months = r14_29days_to_3months;
	}
	public BigDecimal getR14_3months_6months() {
		return r14_3months_6months;
	}
	public void setR14_3months_6months(BigDecimal r14_3months_6months) {
		this.r14_3months_6months = r14_3months_6months;
	}
	public BigDecimal getR14_6months_upto1year() {
		return r14_6months_upto1year;
	}
	public void setR14_6months_upto1year(BigDecimal r14_6months_upto1year) {
		this.r14_6months_upto1year = r14_6months_upto1year;
	}
	public BigDecimal getR14_1year_upto3years() {
		return r14_1year_upto3years;
	}
	public void setR14_1year_upto3years(BigDecimal r14_1year_upto3years) {
		this.r14_1year_upto3years = r14_1year_upto3years;
	}
	public BigDecimal getR14_3year_upto5years() {
		return r14_3year_upto5years;
	}
	public void setR14_3year_upto5years(BigDecimal r14_3year_upto5years) {
		this.r14_3year_upto5years = r14_3year_upto5years;
	}
	public BigDecimal getR14_5year_upto7years() {
		return r14_5year_upto7years;
	}
	public void setR14_5year_upto7years(BigDecimal r14_5year_upto7years) {
		this.r14_5year_upto7years = r14_5year_upto7years;
	}
	public BigDecimal getR14_7year_upto10years() {
		return r14_7year_upto10years;
	}
	public void setR14_7year_upto10years(BigDecimal r14_7year_upto10years) {
		this.r14_7year_upto10years = r14_7year_upto10years;
	}
	public BigDecimal getR14_10year_upto15years() {
		return r14_10year_upto15years;
	}
	public void setR14_10year_upto15years(BigDecimal r14_10year_upto15years) {
		this.r14_10year_upto15years = r14_10year_upto15years;
	}
	public BigDecimal getR14_15years() {
		return r14_15years;
	}
	public void setR14_15years(BigDecimal r14_15years) {
		this.r14_15years = r14_15years;
	}
	public BigDecimal getR14_nonsensitive() {
		return r14_nonsensitive;
	}
	public void setR14_nonsensitive(BigDecimal r14_nonsensitive) {
		this.r14_nonsensitive = r14_nonsensitive;
	}
	public BigDecimal getR14_total_rsl() {
		return r14_total_rsl;
	}
	public void setR14_total_rsl(BigDecimal r14_total_rsl) {
		this.r14_total_rsl = r14_total_rsl;
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
	public BigDecimal getR15_1_to_28days() {
		return r15_1_to_28days;
	}
	public void setR15_1_to_28days(BigDecimal r15_1_to_28days) {
		this.r15_1_to_28days = r15_1_to_28days;
	}
	public BigDecimal getR15_29days_to_3months() {
		return r15_29days_to_3months;
	}
	public void setR15_29days_to_3months(BigDecimal r15_29days_to_3months) {
		this.r15_29days_to_3months = r15_29days_to_3months;
	}
	public BigDecimal getR15_3months_6months() {
		return r15_3months_6months;
	}
	public void setR15_3months_6months(BigDecimal r15_3months_6months) {
		this.r15_3months_6months = r15_3months_6months;
	}
	public BigDecimal getR15_6months_upto1year() {
		return r15_6months_upto1year;
	}
	public void setR15_6months_upto1year(BigDecimal r15_6months_upto1year) {
		this.r15_6months_upto1year = r15_6months_upto1year;
	}
	public BigDecimal getR15_1year_upto3years() {
		return r15_1year_upto3years;
	}
	public void setR15_1year_upto3years(BigDecimal r15_1year_upto3years) {
		this.r15_1year_upto3years = r15_1year_upto3years;
	}
	public BigDecimal getR15_3year_upto5years() {
		return r15_3year_upto5years;
	}
	public void setR15_3year_upto5years(BigDecimal r15_3year_upto5years) {
		this.r15_3year_upto5years = r15_3year_upto5years;
	}
	public BigDecimal getR15_5year_upto7years() {
		return r15_5year_upto7years;
	}
	public void setR15_5year_upto7years(BigDecimal r15_5year_upto7years) {
		this.r15_5year_upto7years = r15_5year_upto7years;
	}
	public BigDecimal getR15_7year_upto10years() {
		return r15_7year_upto10years;
	}
	public void setR15_7year_upto10years(BigDecimal r15_7year_upto10years) {
		this.r15_7year_upto10years = r15_7year_upto10years;
	}
	public BigDecimal getR15_10year_upto15years() {
		return r15_10year_upto15years;
	}
	public void setR15_10year_upto15years(BigDecimal r15_10year_upto15years) {
		this.r15_10year_upto15years = r15_10year_upto15years;
	}
	public BigDecimal getR15_15years() {
		return r15_15years;
	}
	public void setR15_15years(BigDecimal r15_15years) {
		this.r15_15years = r15_15years;
	}
	public BigDecimal getR15_nonsensitive() {
		return r15_nonsensitive;
	}
	public void setR15_nonsensitive(BigDecimal r15_nonsensitive) {
		this.r15_nonsensitive = r15_nonsensitive;
	}
	public BigDecimal getR15_total_rsl() {
		return r15_total_rsl;
	}
	public void setR15_total_rsl(BigDecimal r15_total_rsl) {
		this.r15_total_rsl = r15_total_rsl;
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
	public BigDecimal getR16_1_to_28days() {
		return r16_1_to_28days;
	}
	public void setR16_1_to_28days(BigDecimal r16_1_to_28days) {
		this.r16_1_to_28days = r16_1_to_28days;
	}
	public BigDecimal getR16_29days_to_3months() {
		return r16_29days_to_3months;
	}
	public void setR16_29days_to_3months(BigDecimal r16_29days_to_3months) {
		this.r16_29days_to_3months = r16_29days_to_3months;
	}
	public BigDecimal getR16_3months_6months() {
		return r16_3months_6months;
	}
	public void setR16_3months_6months(BigDecimal r16_3months_6months) {
		this.r16_3months_6months = r16_3months_6months;
	}
	public BigDecimal getR16_6months_upto1year() {
		return r16_6months_upto1year;
	}
	public void setR16_6months_upto1year(BigDecimal r16_6months_upto1year) {
		this.r16_6months_upto1year = r16_6months_upto1year;
	}
	public BigDecimal getR16_1year_upto3years() {
		return r16_1year_upto3years;
	}
	public void setR16_1year_upto3years(BigDecimal r16_1year_upto3years) {
		this.r16_1year_upto3years = r16_1year_upto3years;
	}
	public BigDecimal getR16_3year_upto5years() {
		return r16_3year_upto5years;
	}
	public void setR16_3year_upto5years(BigDecimal r16_3year_upto5years) {
		this.r16_3year_upto5years = r16_3year_upto5years;
	}
	public BigDecimal getR16_5year_upto7years() {
		return r16_5year_upto7years;
	}
	public void setR16_5year_upto7years(BigDecimal r16_5year_upto7years) {
		this.r16_5year_upto7years = r16_5year_upto7years;
	}
	public BigDecimal getR16_7year_upto10years() {
		return r16_7year_upto10years;
	}
	public void setR16_7year_upto10years(BigDecimal r16_7year_upto10years) {
		this.r16_7year_upto10years = r16_7year_upto10years;
	}
	public BigDecimal getR16_10year_upto15years() {
		return r16_10year_upto15years;
	}
	public void setR16_10year_upto15years(BigDecimal r16_10year_upto15years) {
		this.r16_10year_upto15years = r16_10year_upto15years;
	}
	public BigDecimal getR16_15years() {
		return r16_15years;
	}
	public void setR16_15years(BigDecimal r16_15years) {
		this.r16_15years = r16_15years;
	}
	public BigDecimal getR16_nonsensitive() {
		return r16_nonsensitive;
	}
	public void setR16_nonsensitive(BigDecimal r16_nonsensitive) {
		this.r16_nonsensitive = r16_nonsensitive;
	}
	public BigDecimal getR16_total_rsl() {
		return r16_total_rsl;
	}
	public void setR16_total_rsl(BigDecimal r16_total_rsl) {
		this.r16_total_rsl = r16_total_rsl;
	}
	public BigDecimal getR16_total() {
		return r16_total;
	}
	public void setR16_total(BigDecimal r16_total) {
		this.r16_total = r16_total;
	}
	public String getR17_product() {
		return r17_product;
	}
	public void setR17_product(String r17_product) {
		this.r17_product = r17_product;
	}
	public BigDecimal getR17_1_to_28days() {
		return r17_1_to_28days;
	}
	public void setR17_1_to_28days(BigDecimal r17_1_to_28days) {
		this.r17_1_to_28days = r17_1_to_28days;
	}
	public BigDecimal getR17_29days_to_3months() {
		return r17_29days_to_3months;
	}
	public void setR17_29days_to_3months(BigDecimal r17_29days_to_3months) {
		this.r17_29days_to_3months = r17_29days_to_3months;
	}
	public BigDecimal getR17_3months_6months() {
		return r17_3months_6months;
	}
	public void setR17_3months_6months(BigDecimal r17_3months_6months) {
		this.r17_3months_6months = r17_3months_6months;
	}
	public BigDecimal getR17_6months_upto1year() {
		return r17_6months_upto1year;
	}
	public void setR17_6months_upto1year(BigDecimal r17_6months_upto1year) {
		this.r17_6months_upto1year = r17_6months_upto1year;
	}
	public BigDecimal getR17_1year_upto3years() {
		return r17_1year_upto3years;
	}
	public void setR17_1year_upto3years(BigDecimal r17_1year_upto3years) {
		this.r17_1year_upto3years = r17_1year_upto3years;
	}
	public BigDecimal getR17_3year_upto5years() {
		return r17_3year_upto5years;
	}
	public void setR17_3year_upto5years(BigDecimal r17_3year_upto5years) {
		this.r17_3year_upto5years = r17_3year_upto5years;
	}
	public BigDecimal getR17_5year_upto7years() {
		return r17_5year_upto7years;
	}
	public void setR17_5year_upto7years(BigDecimal r17_5year_upto7years) {
		this.r17_5year_upto7years = r17_5year_upto7years;
	}
	public BigDecimal getR17_7year_upto10years() {
		return r17_7year_upto10years;
	}
	public void setR17_7year_upto10years(BigDecimal r17_7year_upto10years) {
		this.r17_7year_upto10years = r17_7year_upto10years;
	}
	public BigDecimal getR17_10year_upto15years() {
		return r17_10year_upto15years;
	}
	public void setR17_10year_upto15years(BigDecimal r17_10year_upto15years) {
		this.r17_10year_upto15years = r17_10year_upto15years;
	}
	public BigDecimal getR17_15years() {
		return r17_15years;
	}
	public void setR17_15years(BigDecimal r17_15years) {
		this.r17_15years = r17_15years;
	}
	public BigDecimal getR17_nonsensitive() {
		return r17_nonsensitive;
	}
	public void setR17_nonsensitive(BigDecimal r17_nonsensitive) {
		this.r17_nonsensitive = r17_nonsensitive;
	}
	public BigDecimal getR17_total_rsl() {
		return r17_total_rsl;
	}
	public void setR17_total_rsl(BigDecimal r17_total_rsl) {
		this.r17_total_rsl = r17_total_rsl;
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
	public BigDecimal getR18_1_to_28days() {
		return r18_1_to_28days;
	}
	public void setR18_1_to_28days(BigDecimal r18_1_to_28days) {
		this.r18_1_to_28days = r18_1_to_28days;
	}
	public BigDecimal getR18_29days_to_3months() {
		return r18_29days_to_3months;
	}
	public void setR18_29days_to_3months(BigDecimal r18_29days_to_3months) {
		this.r18_29days_to_3months = r18_29days_to_3months;
	}
	public BigDecimal getR18_3months_6months() {
		return r18_3months_6months;
	}
	public void setR18_3months_6months(BigDecimal r18_3months_6months) {
		this.r18_3months_6months = r18_3months_6months;
	}
	public BigDecimal getR18_6months_upto1year() {
		return r18_6months_upto1year;
	}
	public void setR18_6months_upto1year(BigDecimal r18_6months_upto1year) {
		this.r18_6months_upto1year = r18_6months_upto1year;
	}
	public BigDecimal getR18_1year_upto3years() {
		return r18_1year_upto3years;
	}
	public void setR18_1year_upto3years(BigDecimal r18_1year_upto3years) {
		this.r18_1year_upto3years = r18_1year_upto3years;
	}
	public BigDecimal getR18_3year_upto5years() {
		return r18_3year_upto5years;
	}
	public void setR18_3year_upto5years(BigDecimal r18_3year_upto5years) {
		this.r18_3year_upto5years = r18_3year_upto5years;
	}
	public BigDecimal getR18_5year_upto7years() {
		return r18_5year_upto7years;
	}
	public void setR18_5year_upto7years(BigDecimal r18_5year_upto7years) {
		this.r18_5year_upto7years = r18_5year_upto7years;
	}
	public BigDecimal getR18_7year_upto10years() {
		return r18_7year_upto10years;
	}
	public void setR18_7year_upto10years(BigDecimal r18_7year_upto10years) {
		this.r18_7year_upto10years = r18_7year_upto10years;
	}
	public BigDecimal getR18_10year_upto15years() {
		return r18_10year_upto15years;
	}
	public void setR18_10year_upto15years(BigDecimal r18_10year_upto15years) {
		this.r18_10year_upto15years = r18_10year_upto15years;
	}
	public BigDecimal getR18_15years() {
		return r18_15years;
	}
	public void setR18_15years(BigDecimal r18_15years) {
		this.r18_15years = r18_15years;
	}
	public BigDecimal getR18_nonsensitive() {
		return r18_nonsensitive;
	}
	public void setR18_nonsensitive(BigDecimal r18_nonsensitive) {
		this.r18_nonsensitive = r18_nonsensitive;
	}
	public BigDecimal getR18_total_rsl() {
		return r18_total_rsl;
	}
	public void setR18_total_rsl(BigDecimal r18_total_rsl) {
		this.r18_total_rsl = r18_total_rsl;
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
	public BigDecimal getR19_1_to_28days() {
		return r19_1_to_28days;
	}
	public void setR19_1_to_28days(BigDecimal r19_1_to_28days) {
		this.r19_1_to_28days = r19_1_to_28days;
	}
	public BigDecimal getR19_29days_to_3months() {
		return r19_29days_to_3months;
	}
	public void setR19_29days_to_3months(BigDecimal r19_29days_to_3months) {
		this.r19_29days_to_3months = r19_29days_to_3months;
	}
	public BigDecimal getR19_3months_6months() {
		return r19_3months_6months;
	}
	public void setR19_3months_6months(BigDecimal r19_3months_6months) {
		this.r19_3months_6months = r19_3months_6months;
	}
	public BigDecimal getR19_6months_upto1year() {
		return r19_6months_upto1year;
	}
	public void setR19_6months_upto1year(BigDecimal r19_6months_upto1year) {
		this.r19_6months_upto1year = r19_6months_upto1year;
	}
	public BigDecimal getR19_1year_upto3years() {
		return r19_1year_upto3years;
	}
	public void setR19_1year_upto3years(BigDecimal r19_1year_upto3years) {
		this.r19_1year_upto3years = r19_1year_upto3years;
	}
	public BigDecimal getR19_3year_upto5years() {
		return r19_3year_upto5years;
	}
	public void setR19_3year_upto5years(BigDecimal r19_3year_upto5years) {
		this.r19_3year_upto5years = r19_3year_upto5years;
	}
	public BigDecimal getR19_5year_upto7years() {
		return r19_5year_upto7years;
	}
	public void setR19_5year_upto7years(BigDecimal r19_5year_upto7years) {
		this.r19_5year_upto7years = r19_5year_upto7years;
	}
	public BigDecimal getR19_7year_upto10years() {
		return r19_7year_upto10years;
	}
	public void setR19_7year_upto10years(BigDecimal r19_7year_upto10years) {
		this.r19_7year_upto10years = r19_7year_upto10years;
	}
	public BigDecimal getR19_10year_upto15years() {
		return r19_10year_upto15years;
	}
	public void setR19_10year_upto15years(BigDecimal r19_10year_upto15years) {
		this.r19_10year_upto15years = r19_10year_upto15years;
	}
	public BigDecimal getR19_15years() {
		return r19_15years;
	}
	public void setR19_15years(BigDecimal r19_15years) {
		this.r19_15years = r19_15years;
	}
	public BigDecimal getR19_nonsensitive() {
		return r19_nonsensitive;
	}
	public void setR19_nonsensitive(BigDecimal r19_nonsensitive) {
		this.r19_nonsensitive = r19_nonsensitive;
	}
	public BigDecimal getR19_total_rsl() {
		return r19_total_rsl;
	}
	public void setR19_total_rsl(BigDecimal r19_total_rsl) {
		this.r19_total_rsl = r19_total_rsl;
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
	public BigDecimal getR20_1_to_28days() {
		return r20_1_to_28days;
	}
	public void setR20_1_to_28days(BigDecimal r20_1_to_28days) {
		this.r20_1_to_28days = r20_1_to_28days;
	}
	public BigDecimal getR20_29days_to_3months() {
		return r20_29days_to_3months;
	}
	public void setR20_29days_to_3months(BigDecimal r20_29days_to_3months) {
		this.r20_29days_to_3months = r20_29days_to_3months;
	}
	public BigDecimal getR20_3months_6months() {
		return r20_3months_6months;
	}
	public void setR20_3months_6months(BigDecimal r20_3months_6months) {
		this.r20_3months_6months = r20_3months_6months;
	}
	public BigDecimal getR20_6months_upto1year() {
		return r20_6months_upto1year;
	}
	public void setR20_6months_upto1year(BigDecimal r20_6months_upto1year) {
		this.r20_6months_upto1year = r20_6months_upto1year;
	}
	public BigDecimal getR20_1year_upto3years() {
		return r20_1year_upto3years;
	}
	public void setR20_1year_upto3years(BigDecimal r20_1year_upto3years) {
		this.r20_1year_upto3years = r20_1year_upto3years;
	}
	public BigDecimal getR20_3year_upto5years() {
		return r20_3year_upto5years;
	}
	public void setR20_3year_upto5years(BigDecimal r20_3year_upto5years) {
		this.r20_3year_upto5years = r20_3year_upto5years;
	}
	public BigDecimal getR20_5year_upto7years() {
		return r20_5year_upto7years;
	}
	public void setR20_5year_upto7years(BigDecimal r20_5year_upto7years) {
		this.r20_5year_upto7years = r20_5year_upto7years;
	}
	public BigDecimal getR20_7year_upto10years() {
		return r20_7year_upto10years;
	}
	public void setR20_7year_upto10years(BigDecimal r20_7year_upto10years) {
		this.r20_7year_upto10years = r20_7year_upto10years;
	}
	public BigDecimal getR20_10year_upto15years() {
		return r20_10year_upto15years;
	}
	public void setR20_10year_upto15years(BigDecimal r20_10year_upto15years) {
		this.r20_10year_upto15years = r20_10year_upto15years;
	}
	public BigDecimal getR20_15years() {
		return r20_15years;
	}
	public void setR20_15years(BigDecimal r20_15years) {
		this.r20_15years = r20_15years;
	}
	public BigDecimal getR20_nonsensitive() {
		return r20_nonsensitive;
	}
	public void setR20_nonsensitive(BigDecimal r20_nonsensitive) {
		this.r20_nonsensitive = r20_nonsensitive;
	}
	public BigDecimal getR20_total_rsl() {
		return r20_total_rsl;
	}
	public void setR20_total_rsl(BigDecimal r20_total_rsl) {
		this.r20_total_rsl = r20_total_rsl;
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
	public BigDecimal getR21_1_to_28days() {
		return r21_1_to_28days;
	}
	public void setR21_1_to_28days(BigDecimal r21_1_to_28days) {
		this.r21_1_to_28days = r21_1_to_28days;
	}
	public BigDecimal getR21_29days_to_3months() {
		return r21_29days_to_3months;
	}
	public void setR21_29days_to_3months(BigDecimal r21_29days_to_3months) {
		this.r21_29days_to_3months = r21_29days_to_3months;
	}
	public BigDecimal getR21_3months_6months() {
		return r21_3months_6months;
	}
	public void setR21_3months_6months(BigDecimal r21_3months_6months) {
		this.r21_3months_6months = r21_3months_6months;
	}
	public BigDecimal getR21_6months_upto1year() {
		return r21_6months_upto1year;
	}
	public void setR21_6months_upto1year(BigDecimal r21_6months_upto1year) {
		this.r21_6months_upto1year = r21_6months_upto1year;
	}
	public BigDecimal getR21_1year_upto3years() {
		return r21_1year_upto3years;
	}
	public void setR21_1year_upto3years(BigDecimal r21_1year_upto3years) {
		this.r21_1year_upto3years = r21_1year_upto3years;
	}
	public BigDecimal getR21_3year_upto5years() {
		return r21_3year_upto5years;
	}
	public void setR21_3year_upto5years(BigDecimal r21_3year_upto5years) {
		this.r21_3year_upto5years = r21_3year_upto5years;
	}
	public BigDecimal getR21_5year_upto7years() {
		return r21_5year_upto7years;
	}
	public void setR21_5year_upto7years(BigDecimal r21_5year_upto7years) {
		this.r21_5year_upto7years = r21_5year_upto7years;
	}
	public BigDecimal getR21_7year_upto10years() {
		return r21_7year_upto10years;
	}
	public void setR21_7year_upto10years(BigDecimal r21_7year_upto10years) {
		this.r21_7year_upto10years = r21_7year_upto10years;
	}
	public BigDecimal getR21_10year_upto15years() {
		return r21_10year_upto15years;
	}
	public void setR21_10year_upto15years(BigDecimal r21_10year_upto15years) {
		this.r21_10year_upto15years = r21_10year_upto15years;
	}
	public BigDecimal getR21_15years() {
		return r21_15years;
	}
	public void setR21_15years(BigDecimal r21_15years) {
		this.r21_15years = r21_15years;
	}
	public BigDecimal getR21_nonsensitive() {
		return r21_nonsensitive;
	}
	public void setR21_nonsensitive(BigDecimal r21_nonsensitive) {
		this.r21_nonsensitive = r21_nonsensitive;
	}
	public BigDecimal getR21_total_rsl() {
		return r21_total_rsl;
	}
	public void setR21_total_rsl(BigDecimal r21_total_rsl) {
		this.r21_total_rsl = r21_total_rsl;
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
	public BigDecimal getR22_1_to_28days() {
		return r22_1_to_28days;
	}
	public void setR22_1_to_28days(BigDecimal r22_1_to_28days) {
		this.r22_1_to_28days = r22_1_to_28days;
	}
	public BigDecimal getR22_29days_to_3months() {
		return r22_29days_to_3months;
	}
	public void setR22_29days_to_3months(BigDecimal r22_29days_to_3months) {
		this.r22_29days_to_3months = r22_29days_to_3months;
	}
	public BigDecimal getR22_3months_6months() {
		return r22_3months_6months;
	}
	public void setR22_3months_6months(BigDecimal r22_3months_6months) {
		this.r22_3months_6months = r22_3months_6months;
	}
	public BigDecimal getR22_6months_upto1year() {
		return r22_6months_upto1year;
	}
	public void setR22_6months_upto1year(BigDecimal r22_6months_upto1year) {
		this.r22_6months_upto1year = r22_6months_upto1year;
	}
	public BigDecimal getR22_1year_upto3years() {
		return r22_1year_upto3years;
	}
	public void setR22_1year_upto3years(BigDecimal r22_1year_upto3years) {
		this.r22_1year_upto3years = r22_1year_upto3years;
	}
	public BigDecimal getR22_3year_upto5years() {
		return r22_3year_upto5years;
	}
	public void setR22_3year_upto5years(BigDecimal r22_3year_upto5years) {
		this.r22_3year_upto5years = r22_3year_upto5years;
	}
	public BigDecimal getR22_5year_upto7years() {
		return r22_5year_upto7years;
	}
	public void setR22_5year_upto7years(BigDecimal r22_5year_upto7years) {
		this.r22_5year_upto7years = r22_5year_upto7years;
	}
	public BigDecimal getR22_7year_upto10years() {
		return r22_7year_upto10years;
	}
	public void setR22_7year_upto10years(BigDecimal r22_7year_upto10years) {
		this.r22_7year_upto10years = r22_7year_upto10years;
	}
	public BigDecimal getR22_10year_upto15years() {
		return r22_10year_upto15years;
	}
	public void setR22_10year_upto15years(BigDecimal r22_10year_upto15years) {
		this.r22_10year_upto15years = r22_10year_upto15years;
	}
	public BigDecimal getR22_15years() {
		return r22_15years;
	}
	public void setR22_15years(BigDecimal r22_15years) {
		this.r22_15years = r22_15years;
	}
	public BigDecimal getR22_nonsensitive() {
		return r22_nonsensitive;
	}
	public void setR22_nonsensitive(BigDecimal r22_nonsensitive) {
		this.r22_nonsensitive = r22_nonsensitive;
	}
	public BigDecimal getR22_total_rsl() {
		return r22_total_rsl;
	}
	public void setR22_total_rsl(BigDecimal r22_total_rsl) {
		this.r22_total_rsl = r22_total_rsl;
	}
	public BigDecimal getR22_total() {
		return r22_total;
	}
	public void setR22_total(BigDecimal r22_total) {
		this.r22_total = r22_total;
	}
	public String getR23_product() {
		return r23_product;
	}
	public void setR23_product(String r23_product) {
		this.r23_product = r23_product;
	}
	public BigDecimal getR23_1_to_28days() {
		return r23_1_to_28days;
	}
	public void setR23_1_to_28days(BigDecimal r23_1_to_28days) {
		this.r23_1_to_28days = r23_1_to_28days;
	}
	public BigDecimal getR23_29days_to_3months() {
		return r23_29days_to_3months;
	}
	public void setR23_29days_to_3months(BigDecimal r23_29days_to_3months) {
		this.r23_29days_to_3months = r23_29days_to_3months;
	}
	public BigDecimal getR23_3months_6months() {
		return r23_3months_6months;
	}
	public void setR23_3months_6months(BigDecimal r23_3months_6months) {
		this.r23_3months_6months = r23_3months_6months;
	}
	public BigDecimal getR23_6months_upto1year() {
		return r23_6months_upto1year;
	}
	public void setR23_6months_upto1year(BigDecimal r23_6months_upto1year) {
		this.r23_6months_upto1year = r23_6months_upto1year;
	}
	public BigDecimal getR23_1year_upto3years() {
		return r23_1year_upto3years;
	}
	public void setR23_1year_upto3years(BigDecimal r23_1year_upto3years) {
		this.r23_1year_upto3years = r23_1year_upto3years;
	}
	public BigDecimal getR23_3year_upto5years() {
		return r23_3year_upto5years;
	}
	public void setR23_3year_upto5years(BigDecimal r23_3year_upto5years) {
		this.r23_3year_upto5years = r23_3year_upto5years;
	}
	public BigDecimal getR23_5year_upto7years() {
		return r23_5year_upto7years;
	}
	public void setR23_5year_upto7years(BigDecimal r23_5year_upto7years) {
		this.r23_5year_upto7years = r23_5year_upto7years;
	}
	public BigDecimal getR23_7year_upto10years() {
		return r23_7year_upto10years;
	}
	public void setR23_7year_upto10years(BigDecimal r23_7year_upto10years) {
		this.r23_7year_upto10years = r23_7year_upto10years;
	}
	public BigDecimal getR23_10year_upto15years() {
		return r23_10year_upto15years;
	}
	public void setR23_10year_upto15years(BigDecimal r23_10year_upto15years) {
		this.r23_10year_upto15years = r23_10year_upto15years;
	}
	public BigDecimal getR23_15years() {
		return r23_15years;
	}
	public void setR23_15years(BigDecimal r23_15years) {
		this.r23_15years = r23_15years;
	}
	public BigDecimal getR23_nonsensitive() {
		return r23_nonsensitive;
	}
	public void setR23_nonsensitive(BigDecimal r23_nonsensitive) {
		this.r23_nonsensitive = r23_nonsensitive;
	}
	public BigDecimal getR23_total_rsl() {
		return r23_total_rsl;
	}
	public void setR23_total_rsl(BigDecimal r23_total_rsl) {
		this.r23_total_rsl = r23_total_rsl;
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
	public BigDecimal getR24_1_to_28days() {
		return r24_1_to_28days;
	}
	public void setR24_1_to_28days(BigDecimal r24_1_to_28days) {
		this.r24_1_to_28days = r24_1_to_28days;
	}
	public BigDecimal getR24_29days_to_3months() {
		return r24_29days_to_3months;
	}
	public void setR24_29days_to_3months(BigDecimal r24_29days_to_3months) {
		this.r24_29days_to_3months = r24_29days_to_3months;
	}
	public BigDecimal getR24_3months_6months() {
		return r24_3months_6months;
	}
	public void setR24_3months_6months(BigDecimal r24_3months_6months) {
		this.r24_3months_6months = r24_3months_6months;
	}
	public BigDecimal getR24_6months_upto1year() {
		return r24_6months_upto1year;
	}
	public void setR24_6months_upto1year(BigDecimal r24_6months_upto1year) {
		this.r24_6months_upto1year = r24_6months_upto1year;
	}
	public BigDecimal getR24_1year_upto3years() {
		return r24_1year_upto3years;
	}
	public void setR24_1year_upto3years(BigDecimal r24_1year_upto3years) {
		this.r24_1year_upto3years = r24_1year_upto3years;
	}
	public BigDecimal getR24_3year_upto5years() {
		return r24_3year_upto5years;
	}
	public void setR24_3year_upto5years(BigDecimal r24_3year_upto5years) {
		this.r24_3year_upto5years = r24_3year_upto5years;
	}
	public BigDecimal getR24_5year_upto7years() {
		return r24_5year_upto7years;
	}
	public void setR24_5year_upto7years(BigDecimal r24_5year_upto7years) {
		this.r24_5year_upto7years = r24_5year_upto7years;
	}
	public BigDecimal getR24_7year_upto10years() {
		return r24_7year_upto10years;
	}
	public void setR24_7year_upto10years(BigDecimal r24_7year_upto10years) {
		this.r24_7year_upto10years = r24_7year_upto10years;
	}
	public BigDecimal getR24_10year_upto15years() {
		return r24_10year_upto15years;
	}
	public void setR24_10year_upto15years(BigDecimal r24_10year_upto15years) {
		this.r24_10year_upto15years = r24_10year_upto15years;
	}
	public BigDecimal getR24_15years() {
		return r24_15years;
	}
	public void setR24_15years(BigDecimal r24_15years) {
		this.r24_15years = r24_15years;
	}
	public BigDecimal getR24_nonsensitive() {
		return r24_nonsensitive;
	}
	public void setR24_nonsensitive(BigDecimal r24_nonsensitive) {
		this.r24_nonsensitive = r24_nonsensitive;
	}
	public BigDecimal getR24_total_rsl() {
		return r24_total_rsl;
	}
	public void setR24_total_rsl(BigDecimal r24_total_rsl) {
		this.r24_total_rsl = r24_total_rsl;
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
	public BigDecimal getR25_1_to_28days() {
		return r25_1_to_28days;
	}
	public void setR25_1_to_28days(BigDecimal r25_1_to_28days) {
		this.r25_1_to_28days = r25_1_to_28days;
	}
	public BigDecimal getR25_29days_to_3months() {
		return r25_29days_to_3months;
	}
	public void setR25_29days_to_3months(BigDecimal r25_29days_to_3months) {
		this.r25_29days_to_3months = r25_29days_to_3months;
	}
	public BigDecimal getR25_3months_6months() {
		return r25_3months_6months;
	}
	public void setR25_3months_6months(BigDecimal r25_3months_6months) {
		this.r25_3months_6months = r25_3months_6months;
	}
	public BigDecimal getR25_6months_upto1year() {
		return r25_6months_upto1year;
	}
	public void setR25_6months_upto1year(BigDecimal r25_6months_upto1year) {
		this.r25_6months_upto1year = r25_6months_upto1year;
	}
	public BigDecimal getR25_1year_upto3years() {
		return r25_1year_upto3years;
	}
	public void setR25_1year_upto3years(BigDecimal r25_1year_upto3years) {
		this.r25_1year_upto3years = r25_1year_upto3years;
	}
	public BigDecimal getR25_3year_upto5years() {
		return r25_3year_upto5years;
	}
	public void setR25_3year_upto5years(BigDecimal r25_3year_upto5years) {
		this.r25_3year_upto5years = r25_3year_upto5years;
	}
	public BigDecimal getR25_5year_upto7years() {
		return r25_5year_upto7years;
	}
	public void setR25_5year_upto7years(BigDecimal r25_5year_upto7years) {
		this.r25_5year_upto7years = r25_5year_upto7years;
	}
	public BigDecimal getR25_7year_upto10years() {
		return r25_7year_upto10years;
	}
	public void setR25_7year_upto10years(BigDecimal r25_7year_upto10years) {
		this.r25_7year_upto10years = r25_7year_upto10years;
	}
	public BigDecimal getR25_10year_upto15years() {
		return r25_10year_upto15years;
	}
	public void setR25_10year_upto15years(BigDecimal r25_10year_upto15years) {
		this.r25_10year_upto15years = r25_10year_upto15years;
	}
	public BigDecimal getR25_15years() {
		return r25_15years;
	}
	public void setR25_15years(BigDecimal r25_15years) {
		this.r25_15years = r25_15years;
	}
	public BigDecimal getR25_nonsensitive() {
		return r25_nonsensitive;
	}
	public void setR25_nonsensitive(BigDecimal r25_nonsensitive) {
		this.r25_nonsensitive = r25_nonsensitive;
	}
	public BigDecimal getR25_total_rsl() {
		return r25_total_rsl;
	}
	public void setR25_total_rsl(BigDecimal r25_total_rsl) {
		this.r25_total_rsl = r25_total_rsl;
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
	public BigDecimal getR26_1_to_28days() {
		return r26_1_to_28days;
	}
	public void setR26_1_to_28days(BigDecimal r26_1_to_28days) {
		this.r26_1_to_28days = r26_1_to_28days;
	}
	public BigDecimal getR26_29days_to_3months() {
		return r26_29days_to_3months;
	}
	public void setR26_29days_to_3months(BigDecimal r26_29days_to_3months) {
		this.r26_29days_to_3months = r26_29days_to_3months;
	}
	public BigDecimal getR26_3months_6months() {
		return r26_3months_6months;
	}
	public void setR26_3months_6months(BigDecimal r26_3months_6months) {
		this.r26_3months_6months = r26_3months_6months;
	}
	public BigDecimal getR26_6months_upto1year() {
		return r26_6months_upto1year;
	}
	public void setR26_6months_upto1year(BigDecimal r26_6months_upto1year) {
		this.r26_6months_upto1year = r26_6months_upto1year;
	}
	public BigDecimal getR26_1year_upto3years() {
		return r26_1year_upto3years;
	}
	public void setR26_1year_upto3years(BigDecimal r26_1year_upto3years) {
		this.r26_1year_upto3years = r26_1year_upto3years;
	}
	public BigDecimal getR26_3year_upto5years() {
		return r26_3year_upto5years;
	}
	public void setR26_3year_upto5years(BigDecimal r26_3year_upto5years) {
		this.r26_3year_upto5years = r26_3year_upto5years;
	}
	public BigDecimal getR26_5year_upto7years() {
		return r26_5year_upto7years;
	}
	public void setR26_5year_upto7years(BigDecimal r26_5year_upto7years) {
		this.r26_5year_upto7years = r26_5year_upto7years;
	}
	public BigDecimal getR26_7year_upto10years() {
		return r26_7year_upto10years;
	}
	public void setR26_7year_upto10years(BigDecimal r26_7year_upto10years) {
		this.r26_7year_upto10years = r26_7year_upto10years;
	}
	public BigDecimal getR26_10year_upto15years() {
		return r26_10year_upto15years;
	}
	public void setR26_10year_upto15years(BigDecimal r26_10year_upto15years) {
		this.r26_10year_upto15years = r26_10year_upto15years;
	}
	public BigDecimal getR26_15years() {
		return r26_15years;
	}
	public void setR26_15years(BigDecimal r26_15years) {
		this.r26_15years = r26_15years;
	}
	public BigDecimal getR26_nonsensitive() {
		return r26_nonsensitive;
	}
	public void setR26_nonsensitive(BigDecimal r26_nonsensitive) {
		this.r26_nonsensitive = r26_nonsensitive;
	}
	public BigDecimal getR26_total_rsl() {
		return r26_total_rsl;
	}
	public void setR26_total_rsl(BigDecimal r26_total_rsl) {
		this.r26_total_rsl = r26_total_rsl;
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
	public BigDecimal getR27_1_to_28days() {
		return r27_1_to_28days;
	}
	public void setR27_1_to_28days(BigDecimal r27_1_to_28days) {
		this.r27_1_to_28days = r27_1_to_28days;
	}
	public BigDecimal getR27_29days_to_3months() {
		return r27_29days_to_3months;
	}
	public void setR27_29days_to_3months(BigDecimal r27_29days_to_3months) {
		this.r27_29days_to_3months = r27_29days_to_3months;
	}
	public BigDecimal getR27_3months_6months() {
		return r27_3months_6months;
	}
	public void setR27_3months_6months(BigDecimal r27_3months_6months) {
		this.r27_3months_6months = r27_3months_6months;
	}
	public BigDecimal getR27_6months_upto1year() {
		return r27_6months_upto1year;
	}
	public void setR27_6months_upto1year(BigDecimal r27_6months_upto1year) {
		this.r27_6months_upto1year = r27_6months_upto1year;
	}
	public BigDecimal getR27_1year_upto3years() {
		return r27_1year_upto3years;
	}
	public void setR27_1year_upto3years(BigDecimal r27_1year_upto3years) {
		this.r27_1year_upto3years = r27_1year_upto3years;
	}
	public BigDecimal getR27_3year_upto5years() {
		return r27_3year_upto5years;
	}
	public void setR27_3year_upto5years(BigDecimal r27_3year_upto5years) {
		this.r27_3year_upto5years = r27_3year_upto5years;
	}
	public BigDecimal getR27_5year_upto7years() {
		return r27_5year_upto7years;
	}
	public void setR27_5year_upto7years(BigDecimal r27_5year_upto7years) {
		this.r27_5year_upto7years = r27_5year_upto7years;
	}
	public BigDecimal getR27_7year_upto10years() {
		return r27_7year_upto10years;
	}
	public void setR27_7year_upto10years(BigDecimal r27_7year_upto10years) {
		this.r27_7year_upto10years = r27_7year_upto10years;
	}
	public BigDecimal getR27_10year_upto15years() {
		return r27_10year_upto15years;
	}
	public void setR27_10year_upto15years(BigDecimal r27_10year_upto15years) {
		this.r27_10year_upto15years = r27_10year_upto15years;
	}
	public BigDecimal getR27_15years() {
		return r27_15years;
	}
	public void setR27_15years(BigDecimal r27_15years) {
		this.r27_15years = r27_15years;
	}
	public BigDecimal getR27_nonsensitive() {
		return r27_nonsensitive;
	}
	public void setR27_nonsensitive(BigDecimal r27_nonsensitive) {
		this.r27_nonsensitive = r27_nonsensitive;
	}
	public BigDecimal getR27_total_rsl() {
		return r27_total_rsl;
	}
	public void setR27_total_rsl(BigDecimal r27_total_rsl) {
		this.r27_total_rsl = r27_total_rsl;
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
	public BigDecimal getR28_1_to_28days() {
		return r28_1_to_28days;
	}
	public void setR28_1_to_28days(BigDecimal r28_1_to_28days) {
		this.r28_1_to_28days = r28_1_to_28days;
	}
	public BigDecimal getR28_29days_to_3months() {
		return r28_29days_to_3months;
	}
	public void setR28_29days_to_3months(BigDecimal r28_29days_to_3months) {
		this.r28_29days_to_3months = r28_29days_to_3months;
	}
	public BigDecimal getR28_3months_6months() {
		return r28_3months_6months;
	}
	public void setR28_3months_6months(BigDecimal r28_3months_6months) {
		this.r28_3months_6months = r28_3months_6months;
	}
	public BigDecimal getR28_6months_upto1year() {
		return r28_6months_upto1year;
	}
	public void setR28_6months_upto1year(BigDecimal r28_6months_upto1year) {
		this.r28_6months_upto1year = r28_6months_upto1year;
	}
	public BigDecimal getR28_1year_upto3years() {
		return r28_1year_upto3years;
	}
	public void setR28_1year_upto3years(BigDecimal r28_1year_upto3years) {
		this.r28_1year_upto3years = r28_1year_upto3years;
	}
	public BigDecimal getR28_3year_upto5years() {
		return r28_3year_upto5years;
	}
	public void setR28_3year_upto5years(BigDecimal r28_3year_upto5years) {
		this.r28_3year_upto5years = r28_3year_upto5years;
	}
	public BigDecimal getR28_5year_upto7years() {
		return r28_5year_upto7years;
	}
	public void setR28_5year_upto7years(BigDecimal r28_5year_upto7years) {
		this.r28_5year_upto7years = r28_5year_upto7years;
	}
	public BigDecimal getR28_7year_upto10years() {
		return r28_7year_upto10years;
	}
	public void setR28_7year_upto10years(BigDecimal r28_7year_upto10years) {
		this.r28_7year_upto10years = r28_7year_upto10years;
	}
	public BigDecimal getR28_10year_upto15years() {
		return r28_10year_upto15years;
	}
	public void setR28_10year_upto15years(BigDecimal r28_10year_upto15years) {
		this.r28_10year_upto15years = r28_10year_upto15years;
	}
	public BigDecimal getR28_15years() {
		return r28_15years;
	}
	public void setR28_15years(BigDecimal r28_15years) {
		this.r28_15years = r28_15years;
	}
	public BigDecimal getR28_nonsensitive() {
		return r28_nonsensitive;
	}
	public void setR28_nonsensitive(BigDecimal r28_nonsensitive) {
		this.r28_nonsensitive = r28_nonsensitive;
	}
	public BigDecimal getR28_total_rsl() {
		return r28_total_rsl;
	}
	public void setR28_total_rsl(BigDecimal r28_total_rsl) {
		this.r28_total_rsl = r28_total_rsl;
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
	public BigDecimal getR29_1_to_28days() {
		return r29_1_to_28days;
	}
	public void setR29_1_to_28days(BigDecimal r29_1_to_28days) {
		this.r29_1_to_28days = r29_1_to_28days;
	}
	public BigDecimal getR29_29days_to_3months() {
		return r29_29days_to_3months;
	}
	public void setR29_29days_to_3months(BigDecimal r29_29days_to_3months) {
		this.r29_29days_to_3months = r29_29days_to_3months;
	}
	public BigDecimal getR29_3months_6months() {
		return r29_3months_6months;
	}
	public void setR29_3months_6months(BigDecimal r29_3months_6months) {
		this.r29_3months_6months = r29_3months_6months;
	}
	public BigDecimal getR29_6months_upto1year() {
		return r29_6months_upto1year;
	}
	public void setR29_6months_upto1year(BigDecimal r29_6months_upto1year) {
		this.r29_6months_upto1year = r29_6months_upto1year;
	}
	public BigDecimal getR29_1year_upto3years() {
		return r29_1year_upto3years;
	}
	public void setR29_1year_upto3years(BigDecimal r29_1year_upto3years) {
		this.r29_1year_upto3years = r29_1year_upto3years;
	}
	public BigDecimal getR29_3year_upto5years() {
		return r29_3year_upto5years;
	}
	public void setR29_3year_upto5years(BigDecimal r29_3year_upto5years) {
		this.r29_3year_upto5years = r29_3year_upto5years;
	}
	public BigDecimal getR29_5year_upto7years() {
		return r29_5year_upto7years;
	}
	public void setR29_5year_upto7years(BigDecimal r29_5year_upto7years) {
		this.r29_5year_upto7years = r29_5year_upto7years;
	}
	public BigDecimal getR29_7year_upto10years() {
		return r29_7year_upto10years;
	}
	public void setR29_7year_upto10years(BigDecimal r29_7year_upto10years) {
		this.r29_7year_upto10years = r29_7year_upto10years;
	}
	public BigDecimal getR29_10year_upto15years() {
		return r29_10year_upto15years;
	}
	public void setR29_10year_upto15years(BigDecimal r29_10year_upto15years) {
		this.r29_10year_upto15years = r29_10year_upto15years;
	}
	public BigDecimal getR29_15years() {
		return r29_15years;
	}
	public void setR29_15years(BigDecimal r29_15years) {
		this.r29_15years = r29_15years;
	}
	public BigDecimal getR29_nonsensitive() {
		return r29_nonsensitive;
	}
	public void setR29_nonsensitive(BigDecimal r29_nonsensitive) {
		this.r29_nonsensitive = r29_nonsensitive;
	}
	public BigDecimal getR29_total_rsl() {
		return r29_total_rsl;
	}
	public void setR29_total_rsl(BigDecimal r29_total_rsl) {
		this.r29_total_rsl = r29_total_rsl;
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
	public BigDecimal getR30_1_to_28days() {
		return r30_1_to_28days;
	}
	public void setR30_1_to_28days(BigDecimal r30_1_to_28days) {
		this.r30_1_to_28days = r30_1_to_28days;
	}
	public BigDecimal getR30_29days_to_3months() {
		return r30_29days_to_3months;
	}
	public void setR30_29days_to_3months(BigDecimal r30_29days_to_3months) {
		this.r30_29days_to_3months = r30_29days_to_3months;
	}
	public BigDecimal getR30_3months_6months() {
		return r30_3months_6months;
	}
	public void setR30_3months_6months(BigDecimal r30_3months_6months) {
		this.r30_3months_6months = r30_3months_6months;
	}
	public BigDecimal getR30_6months_upto1year() {
		return r30_6months_upto1year;
	}
	public void setR30_6months_upto1year(BigDecimal r30_6months_upto1year) {
		this.r30_6months_upto1year = r30_6months_upto1year;
	}
	public BigDecimal getR30_1year_upto3years() {
		return r30_1year_upto3years;
	}
	public void setR30_1year_upto3years(BigDecimal r30_1year_upto3years) {
		this.r30_1year_upto3years = r30_1year_upto3years;
	}
	public BigDecimal getR30_3year_upto5years() {
		return r30_3year_upto5years;
	}
	public void setR30_3year_upto5years(BigDecimal r30_3year_upto5years) {
		this.r30_3year_upto5years = r30_3year_upto5years;
	}
	public BigDecimal getR30_5year_upto7years() {
		return r30_5year_upto7years;
	}
	public void setR30_5year_upto7years(BigDecimal r30_5year_upto7years) {
		this.r30_5year_upto7years = r30_5year_upto7years;
	}
	public BigDecimal getR30_7year_upto10years() {
		return r30_7year_upto10years;
	}
	public void setR30_7year_upto10years(BigDecimal r30_7year_upto10years) {
		this.r30_7year_upto10years = r30_7year_upto10years;
	}
	public BigDecimal getR30_10year_upto15years() {
		return r30_10year_upto15years;
	}
	public void setR30_10year_upto15years(BigDecimal r30_10year_upto15years) {
		this.r30_10year_upto15years = r30_10year_upto15years;
	}
	public BigDecimal getR30_15years() {
		return r30_15years;
	}
	public void setR30_15years(BigDecimal r30_15years) {
		this.r30_15years = r30_15years;
	}
	public BigDecimal getR30_nonsensitive() {
		return r30_nonsensitive;
	}
	public void setR30_nonsensitive(BigDecimal r30_nonsensitive) {
		this.r30_nonsensitive = r30_nonsensitive;
	}
	public BigDecimal getR30_total_rsl() {
		return r30_total_rsl;
	}
	public void setR30_total_rsl(BigDecimal r30_total_rsl) {
		this.r30_total_rsl = r30_total_rsl;
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
	public BigDecimal getR31_1_to_28days() {
		return r31_1_to_28days;
	}
	public void setR31_1_to_28days(BigDecimal r31_1_to_28days) {
		this.r31_1_to_28days = r31_1_to_28days;
	}
	public BigDecimal getR31_29days_to_3months() {
		return r31_29days_to_3months;
	}
	public void setR31_29days_to_3months(BigDecimal r31_29days_to_3months) {
		this.r31_29days_to_3months = r31_29days_to_3months;
	}
	public BigDecimal getR31_3months_6months() {
		return r31_3months_6months;
	}
	public void setR31_3months_6months(BigDecimal r31_3months_6months) {
		this.r31_3months_6months = r31_3months_6months;
	}
	public BigDecimal getR31_6months_upto1year() {
		return r31_6months_upto1year;
	}
	public void setR31_6months_upto1year(BigDecimal r31_6months_upto1year) {
		this.r31_6months_upto1year = r31_6months_upto1year;
	}
	public BigDecimal getR31_1year_upto3years() {
		return r31_1year_upto3years;
	}
	public void setR31_1year_upto3years(BigDecimal r31_1year_upto3years) {
		this.r31_1year_upto3years = r31_1year_upto3years;
	}
	public BigDecimal getR31_3year_upto5years() {
		return r31_3year_upto5years;
	}
	public void setR31_3year_upto5years(BigDecimal r31_3year_upto5years) {
		this.r31_3year_upto5years = r31_3year_upto5years;
	}
	public BigDecimal getR31_5year_upto7years() {
		return r31_5year_upto7years;
	}
	public void setR31_5year_upto7years(BigDecimal r31_5year_upto7years) {
		this.r31_5year_upto7years = r31_5year_upto7years;
	}
	public BigDecimal getR31_7year_upto10years() {
		return r31_7year_upto10years;
	}
	public void setR31_7year_upto10years(BigDecimal r31_7year_upto10years) {
		this.r31_7year_upto10years = r31_7year_upto10years;
	}
	public BigDecimal getR31_10year_upto15years() {
		return r31_10year_upto15years;
	}
	public void setR31_10year_upto15years(BigDecimal r31_10year_upto15years) {
		this.r31_10year_upto15years = r31_10year_upto15years;
	}
	public BigDecimal getR31_15years() {
		return r31_15years;
	}
	public void setR31_15years(BigDecimal r31_15years) {
		this.r31_15years = r31_15years;
	}
	public BigDecimal getR31_nonsensitive() {
		return r31_nonsensitive;
	}
	public void setR31_nonsensitive(BigDecimal r31_nonsensitive) {
		this.r31_nonsensitive = r31_nonsensitive;
	}
	public BigDecimal getR31_total_rsl() {
		return r31_total_rsl;
	}
	public void setR31_total_rsl(BigDecimal r31_total_rsl) {
		this.r31_total_rsl = r31_total_rsl;
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
	public BigDecimal getR32_1_to_28days() {
		return r32_1_to_28days;
	}
	public void setR32_1_to_28days(BigDecimal r32_1_to_28days) {
		this.r32_1_to_28days = r32_1_to_28days;
	}
	public BigDecimal getR32_29days_to_3months() {
		return r32_29days_to_3months;
	}
	public void setR32_29days_to_3months(BigDecimal r32_29days_to_3months) {
		this.r32_29days_to_3months = r32_29days_to_3months;
	}
	public BigDecimal getR32_3months_6months() {
		return r32_3months_6months;
	}
	public void setR32_3months_6months(BigDecimal r32_3months_6months) {
		this.r32_3months_6months = r32_3months_6months;
	}
	public BigDecimal getR32_6months_upto1year() {
		return r32_6months_upto1year;
	}
	public void setR32_6months_upto1year(BigDecimal r32_6months_upto1year) {
		this.r32_6months_upto1year = r32_6months_upto1year;
	}
	public BigDecimal getR32_1year_upto3years() {
		return r32_1year_upto3years;
	}
	public void setR32_1year_upto3years(BigDecimal r32_1year_upto3years) {
		this.r32_1year_upto3years = r32_1year_upto3years;
	}
	public BigDecimal getR32_3year_upto5years() {
		return r32_3year_upto5years;
	}
	public void setR32_3year_upto5years(BigDecimal r32_3year_upto5years) {
		this.r32_3year_upto5years = r32_3year_upto5years;
	}
	public BigDecimal getR32_5year_upto7years() {
		return r32_5year_upto7years;
	}
	public void setR32_5year_upto7years(BigDecimal r32_5year_upto7years) {
		this.r32_5year_upto7years = r32_5year_upto7years;
	}
	public BigDecimal getR32_7year_upto10years() {
		return r32_7year_upto10years;
	}
	public void setR32_7year_upto10years(BigDecimal r32_7year_upto10years) {
		this.r32_7year_upto10years = r32_7year_upto10years;
	}
	public BigDecimal getR32_10year_upto15years() {
		return r32_10year_upto15years;
	}
	public void setR32_10year_upto15years(BigDecimal r32_10year_upto15years) {
		this.r32_10year_upto15years = r32_10year_upto15years;
	}
	public BigDecimal getR32_15years() {
		return r32_15years;
	}
	public void setR32_15years(BigDecimal r32_15years) {
		this.r32_15years = r32_15years;
	}
	public BigDecimal getR32_nonsensitive() {
		return r32_nonsensitive;
	}
	public void setR32_nonsensitive(BigDecimal r32_nonsensitive) {
		this.r32_nonsensitive = r32_nonsensitive;
	}
	public BigDecimal getR32_total_rsl() {
		return r32_total_rsl;
	}
	public void setR32_total_rsl(BigDecimal r32_total_rsl) {
		this.r32_total_rsl = r32_total_rsl;
	}
	public BigDecimal getR32_total() {
		return r32_total;
	}
	public void setR32_total(BigDecimal r32_total) {
		this.r32_total = r32_total;
	}
	public String getR33_product() {
		return r33_product;
	}
	public void setR33_product(String r33_product) {
		this.r33_product = r33_product;
	}
	public BigDecimal getR33_1_to_28days() {
		return r33_1_to_28days;
	}
	public void setR33_1_to_28days(BigDecimal r33_1_to_28days) {
		this.r33_1_to_28days = r33_1_to_28days;
	}
	public BigDecimal getR33_29days_to_3months() {
		return r33_29days_to_3months;
	}
	public void setR33_29days_to_3months(BigDecimal r33_29days_to_3months) {
		this.r33_29days_to_3months = r33_29days_to_3months;
	}
	public BigDecimal getR33_3months_6months() {
		return r33_3months_6months;
	}
	public void setR33_3months_6months(BigDecimal r33_3months_6months) {
		this.r33_3months_6months = r33_3months_6months;
	}
	public BigDecimal getR33_6months_upto1year() {
		return r33_6months_upto1year;
	}
	public void setR33_6months_upto1year(BigDecimal r33_6months_upto1year) {
		this.r33_6months_upto1year = r33_6months_upto1year;
	}
	public BigDecimal getR33_1year_upto3years() {
		return r33_1year_upto3years;
	}
	public void setR33_1year_upto3years(BigDecimal r33_1year_upto3years) {
		this.r33_1year_upto3years = r33_1year_upto3years;
	}
	public BigDecimal getR33_3year_upto5years() {
		return r33_3year_upto5years;
	}
	public void setR33_3year_upto5years(BigDecimal r33_3year_upto5years) {
		this.r33_3year_upto5years = r33_3year_upto5years;
	}
	public BigDecimal getR33_5year_upto7years() {
		return r33_5year_upto7years;
	}
	public void setR33_5year_upto7years(BigDecimal r33_5year_upto7years) {
		this.r33_5year_upto7years = r33_5year_upto7years;
	}
	public BigDecimal getR33_7year_upto10years() {
		return r33_7year_upto10years;
	}
	public void setR33_7year_upto10years(BigDecimal r33_7year_upto10years) {
		this.r33_7year_upto10years = r33_7year_upto10years;
	}
	public BigDecimal getR33_10year_upto15years() {
		return r33_10year_upto15years;
	}
	public void setR33_10year_upto15years(BigDecimal r33_10year_upto15years) {
		this.r33_10year_upto15years = r33_10year_upto15years;
	}
	public BigDecimal getR33_15years() {
		return r33_15years;
	}
	public void setR33_15years(BigDecimal r33_15years) {
		this.r33_15years = r33_15years;
	}
	public BigDecimal getR33_nonsensitive() {
		return r33_nonsensitive;
	}
	public void setR33_nonsensitive(BigDecimal r33_nonsensitive) {
		this.r33_nonsensitive = r33_nonsensitive;
	}
	public BigDecimal getR33_total_rsl() {
		return r33_total_rsl;
	}
	public void setR33_total_rsl(BigDecimal r33_total_rsl) {
		this.r33_total_rsl = r33_total_rsl;
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
	public BigDecimal getR34_1_to_28days() {
		return r34_1_to_28days;
	}
	public void setR34_1_to_28days(BigDecimal r34_1_to_28days) {
		this.r34_1_to_28days = r34_1_to_28days;
	}
	public BigDecimal getR34_29days_to_3months() {
		return r34_29days_to_3months;
	}
	public void setR34_29days_to_3months(BigDecimal r34_29days_to_3months) {
		this.r34_29days_to_3months = r34_29days_to_3months;
	}
	public BigDecimal getR34_3months_6months() {
		return r34_3months_6months;
	}
	public void setR34_3months_6months(BigDecimal r34_3months_6months) {
		this.r34_3months_6months = r34_3months_6months;
	}
	public BigDecimal getR34_6months_upto1year() {
		return r34_6months_upto1year;
	}
	public void setR34_6months_upto1year(BigDecimal r34_6months_upto1year) {
		this.r34_6months_upto1year = r34_6months_upto1year;
	}
	public BigDecimal getR34_1year_upto3years() {
		return r34_1year_upto3years;
	}
	public void setR34_1year_upto3years(BigDecimal r34_1year_upto3years) {
		this.r34_1year_upto3years = r34_1year_upto3years;
	}
	public BigDecimal getR34_3year_upto5years() {
		return r34_3year_upto5years;
	}
	public void setR34_3year_upto5years(BigDecimal r34_3year_upto5years) {
		this.r34_3year_upto5years = r34_3year_upto5years;
	}
	public BigDecimal getR34_5year_upto7years() {
		return r34_5year_upto7years;
	}
	public void setR34_5year_upto7years(BigDecimal r34_5year_upto7years) {
		this.r34_5year_upto7years = r34_5year_upto7years;
	}
	public BigDecimal getR34_7year_upto10years() {
		return r34_7year_upto10years;
	}
	public void setR34_7year_upto10years(BigDecimal r34_7year_upto10years) {
		this.r34_7year_upto10years = r34_7year_upto10years;
	}
	public BigDecimal getR34_10year_upto15years() {
		return r34_10year_upto15years;
	}
	public void setR34_10year_upto15years(BigDecimal r34_10year_upto15years) {
		this.r34_10year_upto15years = r34_10year_upto15years;
	}
	public BigDecimal getR34_15years() {
		return r34_15years;
	}
	public void setR34_15years(BigDecimal r34_15years) {
		this.r34_15years = r34_15years;
	}
	public BigDecimal getR34_nonsensitive() {
		return r34_nonsensitive;
	}
	public void setR34_nonsensitive(BigDecimal r34_nonsensitive) {
		this.r34_nonsensitive = r34_nonsensitive;
	}
	public BigDecimal getR34_total_rsl() {
		return r34_total_rsl;
	}
	public void setR34_total_rsl(BigDecimal r34_total_rsl) {
		this.r34_total_rsl = r34_total_rsl;
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
	public BigDecimal getR35_1_to_28days() {
		return r35_1_to_28days;
	}
	public void setR35_1_to_28days(BigDecimal r35_1_to_28days) {
		this.r35_1_to_28days = r35_1_to_28days;
	}
	public BigDecimal getR35_29days_to_3months() {
		return r35_29days_to_3months;
	}
	public void setR35_29days_to_3months(BigDecimal r35_29days_to_3months) {
		this.r35_29days_to_3months = r35_29days_to_3months;
	}
	public BigDecimal getR35_3months_6months() {
		return r35_3months_6months;
	}
	public void setR35_3months_6months(BigDecimal r35_3months_6months) {
		this.r35_3months_6months = r35_3months_6months;
	}
	public BigDecimal getR35_6months_upto1year() {
		return r35_6months_upto1year;
	}
	public void setR35_6months_upto1year(BigDecimal r35_6months_upto1year) {
		this.r35_6months_upto1year = r35_6months_upto1year;
	}
	public BigDecimal getR35_1year_upto3years() {
		return r35_1year_upto3years;
	}
	public void setR35_1year_upto3years(BigDecimal r35_1year_upto3years) {
		this.r35_1year_upto3years = r35_1year_upto3years;
	}
	public BigDecimal getR35_3year_upto5years() {
		return r35_3year_upto5years;
	}
	public void setR35_3year_upto5years(BigDecimal r35_3year_upto5years) {
		this.r35_3year_upto5years = r35_3year_upto5years;
	}
	public BigDecimal getR35_5year_upto7years() {
		return r35_5year_upto7years;
	}
	public void setR35_5year_upto7years(BigDecimal r35_5year_upto7years) {
		this.r35_5year_upto7years = r35_5year_upto7years;
	}
	public BigDecimal getR35_7year_upto10years() {
		return r35_7year_upto10years;
	}
	public void setR35_7year_upto10years(BigDecimal r35_7year_upto10years) {
		this.r35_7year_upto10years = r35_7year_upto10years;
	}
	public BigDecimal getR35_10year_upto15years() {
		return r35_10year_upto15years;
	}
	public void setR35_10year_upto15years(BigDecimal r35_10year_upto15years) {
		this.r35_10year_upto15years = r35_10year_upto15years;
	}
	public BigDecimal getR35_15years() {
		return r35_15years;
	}
	public void setR35_15years(BigDecimal r35_15years) {
		this.r35_15years = r35_15years;
	}
	public BigDecimal getR35_nonsensitive() {
		return r35_nonsensitive;
	}
	public void setR35_nonsensitive(BigDecimal r35_nonsensitive) {
		this.r35_nonsensitive = r35_nonsensitive;
	}
	public BigDecimal getR35_total_rsl() {
		return r35_total_rsl;
	}
	public void setR35_total_rsl(BigDecimal r35_total_rsl) {
		this.r35_total_rsl = r35_total_rsl;
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
	public BigDecimal getR36_1_to_28days() {
		return r36_1_to_28days;
	}
	public void setR36_1_to_28days(BigDecimal r36_1_to_28days) {
		this.r36_1_to_28days = r36_1_to_28days;
	}
	public BigDecimal getR36_29days_to_3months() {
		return r36_29days_to_3months;
	}
	public void setR36_29days_to_3months(BigDecimal r36_29days_to_3months) {
		this.r36_29days_to_3months = r36_29days_to_3months;
	}
	public BigDecimal getR36_3months_6months() {
		return r36_3months_6months;
	}
	public void setR36_3months_6months(BigDecimal r36_3months_6months) {
		this.r36_3months_6months = r36_3months_6months;
	}
	public BigDecimal getR36_6months_upto1year() {
		return r36_6months_upto1year;
	}
	public void setR36_6months_upto1year(BigDecimal r36_6months_upto1year) {
		this.r36_6months_upto1year = r36_6months_upto1year;
	}
	public BigDecimal getR36_1year_upto3years() {
		return r36_1year_upto3years;
	}
	public void setR36_1year_upto3years(BigDecimal r36_1year_upto3years) {
		this.r36_1year_upto3years = r36_1year_upto3years;
	}
	public BigDecimal getR36_3year_upto5years() {
		return r36_3year_upto5years;
	}
	public void setR36_3year_upto5years(BigDecimal r36_3year_upto5years) {
		this.r36_3year_upto5years = r36_3year_upto5years;
	}
	public BigDecimal getR36_5year_upto7years() {
		return r36_5year_upto7years;
	}
	public void setR36_5year_upto7years(BigDecimal r36_5year_upto7years) {
		this.r36_5year_upto7years = r36_5year_upto7years;
	}
	public BigDecimal getR36_7year_upto10years() {
		return r36_7year_upto10years;
	}
	public void setR36_7year_upto10years(BigDecimal r36_7year_upto10years) {
		this.r36_7year_upto10years = r36_7year_upto10years;
	}
	public BigDecimal getR36_10year_upto15years() {
		return r36_10year_upto15years;
	}
	public void setR36_10year_upto15years(BigDecimal r36_10year_upto15years) {
		this.r36_10year_upto15years = r36_10year_upto15years;
	}
	public BigDecimal getR36_15years() {
		return r36_15years;
	}
	public void setR36_15years(BigDecimal r36_15years) {
		this.r36_15years = r36_15years;
	}
	public BigDecimal getR36_nonsensitive() {
		return r36_nonsensitive;
	}
	public void setR36_nonsensitive(BigDecimal r36_nonsensitive) {
		this.r36_nonsensitive = r36_nonsensitive;
	}
	public BigDecimal getR36_total_rsl() {
		return r36_total_rsl;
	}
	public void setR36_total_rsl(BigDecimal r36_total_rsl) {
		this.r36_total_rsl = r36_total_rsl;
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
	public BigDecimal getR37_1_to_28days() {
		return r37_1_to_28days;
	}
	public void setR37_1_to_28days(BigDecimal r37_1_to_28days) {
		this.r37_1_to_28days = r37_1_to_28days;
	}
	public BigDecimal getR37_29days_to_3months() {
		return r37_29days_to_3months;
	}
	public void setR37_29days_to_3months(BigDecimal r37_29days_to_3months) {
		this.r37_29days_to_3months = r37_29days_to_3months;
	}
	public BigDecimal getR37_3months_6months() {
		return r37_3months_6months;
	}
	public void setR37_3months_6months(BigDecimal r37_3months_6months) {
		this.r37_3months_6months = r37_3months_6months;
	}
	public BigDecimal getR37_6months_upto1year() {
		return r37_6months_upto1year;
	}
	public void setR37_6months_upto1year(BigDecimal r37_6months_upto1year) {
		this.r37_6months_upto1year = r37_6months_upto1year;
	}
	public BigDecimal getR37_1year_upto3years() {
		return r37_1year_upto3years;
	}
	public void setR37_1year_upto3years(BigDecimal r37_1year_upto3years) {
		this.r37_1year_upto3years = r37_1year_upto3years;
	}
	public BigDecimal getR37_3year_upto5years() {
		return r37_3year_upto5years;
	}
	public void setR37_3year_upto5years(BigDecimal r37_3year_upto5years) {
		this.r37_3year_upto5years = r37_3year_upto5years;
	}
	public BigDecimal getR37_5year_upto7years() {
		return r37_5year_upto7years;
	}
	public void setR37_5year_upto7years(BigDecimal r37_5year_upto7years) {
		this.r37_5year_upto7years = r37_5year_upto7years;
	}
	public BigDecimal getR37_7year_upto10years() {
		return r37_7year_upto10years;
	}
	public void setR37_7year_upto10years(BigDecimal r37_7year_upto10years) {
		this.r37_7year_upto10years = r37_7year_upto10years;
	}
	public BigDecimal getR37_10year_upto15years() {
		return r37_10year_upto15years;
	}
	public void setR37_10year_upto15years(BigDecimal r37_10year_upto15years) {
		this.r37_10year_upto15years = r37_10year_upto15years;
	}
	public BigDecimal getR37_15years() {
		return r37_15years;
	}
	public void setR37_15years(BigDecimal r37_15years) {
		this.r37_15years = r37_15years;
	}
	public BigDecimal getR37_nonsensitive() {
		return r37_nonsensitive;
	}
	public void setR37_nonsensitive(BigDecimal r37_nonsensitive) {
		this.r37_nonsensitive = r37_nonsensitive;
	}
	public BigDecimal getR37_total_rsl() {
		return r37_total_rsl;
	}
	public void setR37_total_rsl(BigDecimal r37_total_rsl) {
		this.r37_total_rsl = r37_total_rsl;
	}
	public BigDecimal getR37_total() {
		return r37_total;
	}
	public void setR37_total(BigDecimal r37_total) {
		this.r37_total = r37_total;
	}
	public String getR38_product() {
		return r38_product;
	}
	public void setR38_product(String r38_product) {
		this.r38_product = r38_product;
	}
	public BigDecimal getR38_1_to_28days() {
		return r38_1_to_28days;
	}
	public void setR38_1_to_28days(BigDecimal r38_1_to_28days) {
		this.r38_1_to_28days = r38_1_to_28days;
	}
	public BigDecimal getR38_29days_to_3months() {
		return r38_29days_to_3months;
	}
	public void setR38_29days_to_3months(BigDecimal r38_29days_to_3months) {
		this.r38_29days_to_3months = r38_29days_to_3months;
	}
	public BigDecimal getR38_3months_6months() {
		return r38_3months_6months;
	}
	public void setR38_3months_6months(BigDecimal r38_3months_6months) {
		this.r38_3months_6months = r38_3months_6months;
	}
	public BigDecimal getR38_6months_upto1year() {
		return r38_6months_upto1year;
	}
	public void setR38_6months_upto1year(BigDecimal r38_6months_upto1year) {
		this.r38_6months_upto1year = r38_6months_upto1year;
	}
	public BigDecimal getR38_1year_upto3years() {
		return r38_1year_upto3years;
	}
	public void setR38_1year_upto3years(BigDecimal r38_1year_upto3years) {
		this.r38_1year_upto3years = r38_1year_upto3years;
	}
	public BigDecimal getR38_3year_upto5years() {
		return r38_3year_upto5years;
	}
	public void setR38_3year_upto5years(BigDecimal r38_3year_upto5years) {
		this.r38_3year_upto5years = r38_3year_upto5years;
	}
	public BigDecimal getR38_5year_upto7years() {
		return r38_5year_upto7years;
	}
	public void setR38_5year_upto7years(BigDecimal r38_5year_upto7years) {
		this.r38_5year_upto7years = r38_5year_upto7years;
	}
	public BigDecimal getR38_7year_upto10years() {
		return r38_7year_upto10years;
	}
	public void setR38_7year_upto10years(BigDecimal r38_7year_upto10years) {
		this.r38_7year_upto10years = r38_7year_upto10years;
	}
	public BigDecimal getR38_10year_upto15years() {
		return r38_10year_upto15years;
	}
	public void setR38_10year_upto15years(BigDecimal r38_10year_upto15years) {
		this.r38_10year_upto15years = r38_10year_upto15years;
	}
	public BigDecimal getR38_15years() {
		return r38_15years;
	}
	public void setR38_15years(BigDecimal r38_15years) {
		this.r38_15years = r38_15years;
	}
	public BigDecimal getR38_nonsensitive() {
		return r38_nonsensitive;
	}
	public void setR38_nonsensitive(BigDecimal r38_nonsensitive) {
		this.r38_nonsensitive = r38_nonsensitive;
	}
	public BigDecimal getR38_total_rsl() {
		return r38_total_rsl;
	}
	public void setR38_total_rsl(BigDecimal r38_total_rsl) {
		this.r38_total_rsl = r38_total_rsl;
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
	public BigDecimal getR39_1_to_28days() {
		return r39_1_to_28days;
	}
	public void setR39_1_to_28days(BigDecimal r39_1_to_28days) {
		this.r39_1_to_28days = r39_1_to_28days;
	}
	public BigDecimal getR39_29days_to_3months() {
		return r39_29days_to_3months;
	}
	public void setR39_29days_to_3months(BigDecimal r39_29days_to_3months) {
		this.r39_29days_to_3months = r39_29days_to_3months;
	}
	public BigDecimal getR39_3months_6months() {
		return r39_3months_6months;
	}
	public void setR39_3months_6months(BigDecimal r39_3months_6months) {
		this.r39_3months_6months = r39_3months_6months;
	}
	public BigDecimal getR39_6months_upto1year() {
		return r39_6months_upto1year;
	}
	public void setR39_6months_upto1year(BigDecimal r39_6months_upto1year) {
		this.r39_6months_upto1year = r39_6months_upto1year;
	}
	public BigDecimal getR39_1year_upto3years() {
		return r39_1year_upto3years;
	}
	public void setR39_1year_upto3years(BigDecimal r39_1year_upto3years) {
		this.r39_1year_upto3years = r39_1year_upto3years;
	}
	public BigDecimal getR39_3year_upto5years() {
		return r39_3year_upto5years;
	}
	public void setR39_3year_upto5years(BigDecimal r39_3year_upto5years) {
		this.r39_3year_upto5years = r39_3year_upto5years;
	}
	public BigDecimal getR39_5year_upto7years() {
		return r39_5year_upto7years;
	}
	public void setR39_5year_upto7years(BigDecimal r39_5year_upto7years) {
		this.r39_5year_upto7years = r39_5year_upto7years;
	}
	public BigDecimal getR39_7year_upto10years() {
		return r39_7year_upto10years;
	}
	public void setR39_7year_upto10years(BigDecimal r39_7year_upto10years) {
		this.r39_7year_upto10years = r39_7year_upto10years;
	}
	public BigDecimal getR39_10year_upto15years() {
		return r39_10year_upto15years;
	}
	public void setR39_10year_upto15years(BigDecimal r39_10year_upto15years) {
		this.r39_10year_upto15years = r39_10year_upto15years;
	}
	public BigDecimal getR39_15years() {
		return r39_15years;
	}
	public void setR39_15years(BigDecimal r39_15years) {
		this.r39_15years = r39_15years;
	}
	public BigDecimal getR39_nonsensitive() {
		return r39_nonsensitive;
	}
	public void setR39_nonsensitive(BigDecimal r39_nonsensitive) {
		this.r39_nonsensitive = r39_nonsensitive;
	}
	public BigDecimal getR39_total_rsl() {
		return r39_total_rsl;
	}
	public void setR39_total_rsl(BigDecimal r39_total_rsl) {
		this.r39_total_rsl = r39_total_rsl;
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
	public BigDecimal getR40_1_to_28days() {
		return r40_1_to_28days;
	}
	public void setR40_1_to_28days(BigDecimal r40_1_to_28days) {
		this.r40_1_to_28days = r40_1_to_28days;
	}
	public BigDecimal getR40_29days_to_3months() {
		return r40_29days_to_3months;
	}
	public void setR40_29days_to_3months(BigDecimal r40_29days_to_3months) {
		this.r40_29days_to_3months = r40_29days_to_3months;
	}
	public BigDecimal getR40_3months_6months() {
		return r40_3months_6months;
	}
	public void setR40_3months_6months(BigDecimal r40_3months_6months) {
		this.r40_3months_6months = r40_3months_6months;
	}
	public BigDecimal getR40_6months_upto1year() {
		return r40_6months_upto1year;
	}
	public void setR40_6months_upto1year(BigDecimal r40_6months_upto1year) {
		this.r40_6months_upto1year = r40_6months_upto1year;
	}
	public BigDecimal getR40_1year_upto3years() {
		return r40_1year_upto3years;
	}
	public void setR40_1year_upto3years(BigDecimal r40_1year_upto3years) {
		this.r40_1year_upto3years = r40_1year_upto3years;
	}
	public BigDecimal getR40_3year_upto5years() {
		return r40_3year_upto5years;
	}
	public void setR40_3year_upto5years(BigDecimal r40_3year_upto5years) {
		this.r40_3year_upto5years = r40_3year_upto5years;
	}
	public BigDecimal getR40_5year_upto7years() {
		return r40_5year_upto7years;
	}
	public void setR40_5year_upto7years(BigDecimal r40_5year_upto7years) {
		this.r40_5year_upto7years = r40_5year_upto7years;
	}
	public BigDecimal getR40_7year_upto10years() {
		return r40_7year_upto10years;
	}
	public void setR40_7year_upto10years(BigDecimal r40_7year_upto10years) {
		this.r40_7year_upto10years = r40_7year_upto10years;
	}
	public BigDecimal getR40_10year_upto15years() {
		return r40_10year_upto15years;
	}
	public void setR40_10year_upto15years(BigDecimal r40_10year_upto15years) {
		this.r40_10year_upto15years = r40_10year_upto15years;
	}
	public BigDecimal getR40_15years() {
		return r40_15years;
	}
	public void setR40_15years(BigDecimal r40_15years) {
		this.r40_15years = r40_15years;
	}
	public BigDecimal getR40_nonsensitive() {
		return r40_nonsensitive;
	}
	public void setR40_nonsensitive(BigDecimal r40_nonsensitive) {
		this.r40_nonsensitive = r40_nonsensitive;
	}
	public BigDecimal getR40_total_rsl() {
		return r40_total_rsl;
	}
	public void setR40_total_rsl(BigDecimal r40_total_rsl) {
		this.r40_total_rsl = r40_total_rsl;
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
	public BigDecimal getR41_1_to_28days() {
		return r41_1_to_28days;
	}
	public void setR41_1_to_28days(BigDecimal r41_1_to_28days) {
		this.r41_1_to_28days = r41_1_to_28days;
	}
	public BigDecimal getR41_29days_to_3months() {
		return r41_29days_to_3months;
	}
	public void setR41_29days_to_3months(BigDecimal r41_29days_to_3months) {
		this.r41_29days_to_3months = r41_29days_to_3months;
	}
	public BigDecimal getR41_3months_6months() {
		return r41_3months_6months;
	}
	public void setR41_3months_6months(BigDecimal r41_3months_6months) {
		this.r41_3months_6months = r41_3months_6months;
	}
	public BigDecimal getR41_6months_upto1year() {
		return r41_6months_upto1year;
	}
	public void setR41_6months_upto1year(BigDecimal r41_6months_upto1year) {
		this.r41_6months_upto1year = r41_6months_upto1year;
	}
	public BigDecimal getR41_1year_upto3years() {
		return r41_1year_upto3years;
	}
	public void setR41_1year_upto3years(BigDecimal r41_1year_upto3years) {
		this.r41_1year_upto3years = r41_1year_upto3years;
	}
	public BigDecimal getR41_3year_upto5years() {
		return r41_3year_upto5years;
	}
	public void setR41_3year_upto5years(BigDecimal r41_3year_upto5years) {
		this.r41_3year_upto5years = r41_3year_upto5years;
	}
	public BigDecimal getR41_5year_upto7years() {
		return r41_5year_upto7years;
	}
	public void setR41_5year_upto7years(BigDecimal r41_5year_upto7years) {
		this.r41_5year_upto7years = r41_5year_upto7years;
	}
	public BigDecimal getR41_7year_upto10years() {
		return r41_7year_upto10years;
	}
	public void setR41_7year_upto10years(BigDecimal r41_7year_upto10years) {
		this.r41_7year_upto10years = r41_7year_upto10years;
	}
	public BigDecimal getR41_10year_upto15years() {
		return r41_10year_upto15years;
	}
	public void setR41_10year_upto15years(BigDecimal r41_10year_upto15years) {
		this.r41_10year_upto15years = r41_10year_upto15years;
	}
	public BigDecimal getR41_15years() {
		return r41_15years;
	}
	public void setR41_15years(BigDecimal r41_15years) {
		this.r41_15years = r41_15years;
	}
	public BigDecimal getR41_nonsensitive() {
		return r41_nonsensitive;
	}
	public void setR41_nonsensitive(BigDecimal r41_nonsensitive) {
		this.r41_nonsensitive = r41_nonsensitive;
	}
	public BigDecimal getR41_total_rsl() {
		return r41_total_rsl;
	}
	public void setR41_total_rsl(BigDecimal r41_total_rsl) {
		this.r41_total_rsl = r41_total_rsl;
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
	public BigDecimal getR42_1_to_28days() {
		return r42_1_to_28days;
	}
	public void setR42_1_to_28days(BigDecimal r42_1_to_28days) {
		this.r42_1_to_28days = r42_1_to_28days;
	}
	public BigDecimal getR42_29days_to_3months() {
		return r42_29days_to_3months;
	}
	public void setR42_29days_to_3months(BigDecimal r42_29days_to_3months) {
		this.r42_29days_to_3months = r42_29days_to_3months;
	}
	public BigDecimal getR42_3months_6months() {
		return r42_3months_6months;
	}
	public void setR42_3months_6months(BigDecimal r42_3months_6months) {
		this.r42_3months_6months = r42_3months_6months;
	}
	public BigDecimal getR42_6months_upto1year() {
		return r42_6months_upto1year;
	}
	public void setR42_6months_upto1year(BigDecimal r42_6months_upto1year) {
		this.r42_6months_upto1year = r42_6months_upto1year;
	}
	public BigDecimal getR42_1year_upto3years() {
		return r42_1year_upto3years;
	}
	public void setR42_1year_upto3years(BigDecimal r42_1year_upto3years) {
		this.r42_1year_upto3years = r42_1year_upto3years;
	}
	public BigDecimal getR42_3year_upto5years() {
		return r42_3year_upto5years;
	}
	public void setR42_3year_upto5years(BigDecimal r42_3year_upto5years) {
		this.r42_3year_upto5years = r42_3year_upto5years;
	}
	public BigDecimal getR42_5year_upto7years() {
		return r42_5year_upto7years;
	}
	public void setR42_5year_upto7years(BigDecimal r42_5year_upto7years) {
		this.r42_5year_upto7years = r42_5year_upto7years;
	}
	public BigDecimal getR42_7year_upto10years() {
		return r42_7year_upto10years;
	}
	public void setR42_7year_upto10years(BigDecimal r42_7year_upto10years) {
		this.r42_7year_upto10years = r42_7year_upto10years;
	}
	public BigDecimal getR42_10year_upto15years() {
		return r42_10year_upto15years;
	}
	public void setR42_10year_upto15years(BigDecimal r42_10year_upto15years) {
		this.r42_10year_upto15years = r42_10year_upto15years;
	}
	public BigDecimal getR42_15years() {
		return r42_15years;
	}
	public void setR42_15years(BigDecimal r42_15years) {
		this.r42_15years = r42_15years;
	}
	public BigDecimal getR42_nonsensitive() {
		return r42_nonsensitive;
	}
	public void setR42_nonsensitive(BigDecimal r42_nonsensitive) {
		this.r42_nonsensitive = r42_nonsensitive;
	}
	public BigDecimal getR42_total_rsl() {
		return r42_total_rsl;
	}
	public void setR42_total_rsl(BigDecimal r42_total_rsl) {
		this.r42_total_rsl = r42_total_rsl;
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
	public BigDecimal getR43_1_to_28days() {
		return r43_1_to_28days;
	}
	public void setR43_1_to_28days(BigDecimal r43_1_to_28days) {
		this.r43_1_to_28days = r43_1_to_28days;
	}
	public BigDecimal getR43_29days_to_3months() {
		return r43_29days_to_3months;
	}
	public void setR43_29days_to_3months(BigDecimal r43_29days_to_3months) {
		this.r43_29days_to_3months = r43_29days_to_3months;
	}
	public BigDecimal getR43_3months_6months() {
		return r43_3months_6months;
	}
	public void setR43_3months_6months(BigDecimal r43_3months_6months) {
		this.r43_3months_6months = r43_3months_6months;
	}
	public BigDecimal getR43_6months_upto1year() {
		return r43_6months_upto1year;
	}
	public void setR43_6months_upto1year(BigDecimal r43_6months_upto1year) {
		this.r43_6months_upto1year = r43_6months_upto1year;
	}
	public BigDecimal getR43_1year_upto3years() {
		return r43_1year_upto3years;
	}
	public void setR43_1year_upto3years(BigDecimal r43_1year_upto3years) {
		this.r43_1year_upto3years = r43_1year_upto3years;
	}
	public BigDecimal getR43_3year_upto5years() {
		return r43_3year_upto5years;
	}
	public void setR43_3year_upto5years(BigDecimal r43_3year_upto5years) {
		this.r43_3year_upto5years = r43_3year_upto5years;
	}
	public BigDecimal getR43_5year_upto7years() {
		return r43_5year_upto7years;
	}
	public void setR43_5year_upto7years(BigDecimal r43_5year_upto7years) {
		this.r43_5year_upto7years = r43_5year_upto7years;
	}
	public BigDecimal getR43_7year_upto10years() {
		return r43_7year_upto10years;
	}
	public void setR43_7year_upto10years(BigDecimal r43_7year_upto10years) {
		this.r43_7year_upto10years = r43_7year_upto10years;
	}
	public BigDecimal getR43_10year_upto15years() {
		return r43_10year_upto15years;
	}
	public void setR43_10year_upto15years(BigDecimal r43_10year_upto15years) {
		this.r43_10year_upto15years = r43_10year_upto15years;
	}
	public BigDecimal getR43_15years() {
		return r43_15years;
	}
	public void setR43_15years(BigDecimal r43_15years) {
		this.r43_15years = r43_15years;
	}
	public BigDecimal getR43_nonsensitive() {
		return r43_nonsensitive;
	}
	public void setR43_nonsensitive(BigDecimal r43_nonsensitive) {
		this.r43_nonsensitive = r43_nonsensitive;
	}
	public BigDecimal getR43_total_rsl() {
		return r43_total_rsl;
	}
	public void setR43_total_rsl(BigDecimal r43_total_rsl) {
		this.r43_total_rsl = r43_total_rsl;
	}
	public BigDecimal getR43_total() {
		return r43_total;
	}
	public void setR43_total(BigDecimal r43_total) {
		this.r43_total = r43_total;
	}
	public String getR44_product() {
		return r44_product;
	}
	public void setR44_product(String r44_product) {
		this.r44_product = r44_product;
	}
	public BigDecimal getR44_1_to_28days() {
		return r44_1_to_28days;
	}
	public void setR44_1_to_28days(BigDecimal r44_1_to_28days) {
		this.r44_1_to_28days = r44_1_to_28days;
	}
	public BigDecimal getR44_29days_to_3months() {
		return r44_29days_to_3months;
	}
	public void setR44_29days_to_3months(BigDecimal r44_29days_to_3months) {
		this.r44_29days_to_3months = r44_29days_to_3months;
	}
	public BigDecimal getR44_3months_6months() {
		return r44_3months_6months;
	}
	public void setR44_3months_6months(BigDecimal r44_3months_6months) {
		this.r44_3months_6months = r44_3months_6months;
	}
	public BigDecimal getR44_6months_upto1year() {
		return r44_6months_upto1year;
	}
	public void setR44_6months_upto1year(BigDecimal r44_6months_upto1year) {
		this.r44_6months_upto1year = r44_6months_upto1year;
	}
	public BigDecimal getR44_1year_upto3years() {
		return r44_1year_upto3years;
	}
	public void setR44_1year_upto3years(BigDecimal r44_1year_upto3years) {
		this.r44_1year_upto3years = r44_1year_upto3years;
	}
	public BigDecimal getR44_3year_upto5years() {
		return r44_3year_upto5years;
	}
	public void setR44_3year_upto5years(BigDecimal r44_3year_upto5years) {
		this.r44_3year_upto5years = r44_3year_upto5years;
	}
	public BigDecimal getR44_5year_upto7years() {
		return r44_5year_upto7years;
	}
	public void setR44_5year_upto7years(BigDecimal r44_5year_upto7years) {
		this.r44_5year_upto7years = r44_5year_upto7years;
	}
	public BigDecimal getR44_7year_upto10years() {
		return r44_7year_upto10years;
	}
	public void setR44_7year_upto10years(BigDecimal r44_7year_upto10years) {
		this.r44_7year_upto10years = r44_7year_upto10years;
	}
	public BigDecimal getR44_10year_upto15years() {
		return r44_10year_upto15years;
	}
	public void setR44_10year_upto15years(BigDecimal r44_10year_upto15years) {
		this.r44_10year_upto15years = r44_10year_upto15years;
	}
	public BigDecimal getR44_15years() {
		return r44_15years;
	}
	public void setR44_15years(BigDecimal r44_15years) {
		this.r44_15years = r44_15years;
	}
	public BigDecimal getR44_nonsensitive() {
		return r44_nonsensitive;
	}
	public void setR44_nonsensitive(BigDecimal r44_nonsensitive) {
		this.r44_nonsensitive = r44_nonsensitive;
	}
	public BigDecimal getR44_total_rsl() {
		return r44_total_rsl;
	}
	public void setR44_total_rsl(BigDecimal r44_total_rsl) {
		this.r44_total_rsl = r44_total_rsl;
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
	public BigDecimal getR45_1_to_28days() {
		return r45_1_to_28days;
	}
	public void setR45_1_to_28days(BigDecimal r45_1_to_28days) {
		this.r45_1_to_28days = r45_1_to_28days;
	}
	public BigDecimal getR45_29days_to_3months() {
		return r45_29days_to_3months;
	}
	public void setR45_29days_to_3months(BigDecimal r45_29days_to_3months) {
		this.r45_29days_to_3months = r45_29days_to_3months;
	}
	public BigDecimal getR45_3months_6months() {
		return r45_3months_6months;
	}
	public void setR45_3months_6months(BigDecimal r45_3months_6months) {
		this.r45_3months_6months = r45_3months_6months;
	}
	public BigDecimal getR45_6months_upto1year() {
		return r45_6months_upto1year;
	}
	public void setR45_6months_upto1year(BigDecimal r45_6months_upto1year) {
		this.r45_6months_upto1year = r45_6months_upto1year;
	}
	public BigDecimal getR45_1year_upto3years() {
		return r45_1year_upto3years;
	}
	public void setR45_1year_upto3years(BigDecimal r45_1year_upto3years) {
		this.r45_1year_upto3years = r45_1year_upto3years;
	}
	public BigDecimal getR45_3year_upto5years() {
		return r45_3year_upto5years;
	}
	public void setR45_3year_upto5years(BigDecimal r45_3year_upto5years) {
		this.r45_3year_upto5years = r45_3year_upto5years;
	}
	public BigDecimal getR45_5year_upto7years() {
		return r45_5year_upto7years;
	}
	public void setR45_5year_upto7years(BigDecimal r45_5year_upto7years) {
		this.r45_5year_upto7years = r45_5year_upto7years;
	}
	public BigDecimal getR45_7year_upto10years() {
		return r45_7year_upto10years;
	}
	public void setR45_7year_upto10years(BigDecimal r45_7year_upto10years) {
		this.r45_7year_upto10years = r45_7year_upto10years;
	}
	public BigDecimal getR45_10year_upto15years() {
		return r45_10year_upto15years;
	}
	public void setR45_10year_upto15years(BigDecimal r45_10year_upto15years) {
		this.r45_10year_upto15years = r45_10year_upto15years;
	}
	public BigDecimal getR45_15years() {
		return r45_15years;
	}
	public void setR45_15years(BigDecimal r45_15years) {
		this.r45_15years = r45_15years;
	}
	public BigDecimal getR45_nonsensitive() {
		return r45_nonsensitive;
	}
	public void setR45_nonsensitive(BigDecimal r45_nonsensitive) {
		this.r45_nonsensitive = r45_nonsensitive;
	}
	public BigDecimal getR45_total_rsl() {
		return r45_total_rsl;
	}
	public void setR45_total_rsl(BigDecimal r45_total_rsl) {
		this.r45_total_rsl = r45_total_rsl;
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
	public BigDecimal getR46_1_to_28days() {
		return r46_1_to_28days;
	}
	public void setR46_1_to_28days(BigDecimal r46_1_to_28days) {
		this.r46_1_to_28days = r46_1_to_28days;
	}
	public BigDecimal getR46_29days_to_3months() {
		return r46_29days_to_3months;
	}
	public void setR46_29days_to_3months(BigDecimal r46_29days_to_3months) {
		this.r46_29days_to_3months = r46_29days_to_3months;
	}
	public BigDecimal getR46_3months_6months() {
		return r46_3months_6months;
	}
	public void setR46_3months_6months(BigDecimal r46_3months_6months) {
		this.r46_3months_6months = r46_3months_6months;
	}
	public BigDecimal getR46_6months_upto1year() {
		return r46_6months_upto1year;
	}
	public void setR46_6months_upto1year(BigDecimal r46_6months_upto1year) {
		this.r46_6months_upto1year = r46_6months_upto1year;
	}
	public BigDecimal getR46_1year_upto3years() {
		return r46_1year_upto3years;
	}
	public void setR46_1year_upto3years(BigDecimal r46_1year_upto3years) {
		this.r46_1year_upto3years = r46_1year_upto3years;
	}
	public BigDecimal getR46_3year_upto5years() {
		return r46_3year_upto5years;
	}
	public void setR46_3year_upto5years(BigDecimal r46_3year_upto5years) {
		this.r46_3year_upto5years = r46_3year_upto5years;
	}
	public BigDecimal getR46_5year_upto7years() {
		return r46_5year_upto7years;
	}
	public void setR46_5year_upto7years(BigDecimal r46_5year_upto7years) {
		this.r46_5year_upto7years = r46_5year_upto7years;
	}
	public BigDecimal getR46_7year_upto10years() {
		return r46_7year_upto10years;
	}
	public void setR46_7year_upto10years(BigDecimal r46_7year_upto10years) {
		this.r46_7year_upto10years = r46_7year_upto10years;
	}
	public BigDecimal getR46_10year_upto15years() {
		return r46_10year_upto15years;
	}
	public void setR46_10year_upto15years(BigDecimal r46_10year_upto15years) {
		this.r46_10year_upto15years = r46_10year_upto15years;
	}
	public BigDecimal getR46_15years() {
		return r46_15years;
	}
	public void setR46_15years(BigDecimal r46_15years) {
		this.r46_15years = r46_15years;
	}
	public BigDecimal getR46_nonsensitive() {
		return r46_nonsensitive;
	}
	public void setR46_nonsensitive(BigDecimal r46_nonsensitive) {
		this.r46_nonsensitive = r46_nonsensitive;
	}
	public BigDecimal getR46_total_rsl() {
		return r46_total_rsl;
	}
	public void setR46_total_rsl(BigDecimal r46_total_rsl) {
		this.r46_total_rsl = r46_total_rsl;
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
	public BigDecimal getR47_1_to_28days() {
		return r47_1_to_28days;
	}
	public void setR47_1_to_28days(BigDecimal r47_1_to_28days) {
		this.r47_1_to_28days = r47_1_to_28days;
	}
	public BigDecimal getR47_29days_to_3months() {
		return r47_29days_to_3months;
	}
	public void setR47_29days_to_3months(BigDecimal r47_29days_to_3months) {
		this.r47_29days_to_3months = r47_29days_to_3months;
	}
	public BigDecimal getR47_3months_6months() {
		return r47_3months_6months;
	}
	public void setR47_3months_6months(BigDecimal r47_3months_6months) {
		this.r47_3months_6months = r47_3months_6months;
	}
	public BigDecimal getR47_6months_upto1year() {
		return r47_6months_upto1year;
	}
	public void setR47_6months_upto1year(BigDecimal r47_6months_upto1year) {
		this.r47_6months_upto1year = r47_6months_upto1year;
	}
	public BigDecimal getR47_1year_upto3years() {
		return r47_1year_upto3years;
	}
	public void setR47_1year_upto3years(BigDecimal r47_1year_upto3years) {
		this.r47_1year_upto3years = r47_1year_upto3years;
	}
	public BigDecimal getR47_3year_upto5years() {
		return r47_3year_upto5years;
	}
	public void setR47_3year_upto5years(BigDecimal r47_3year_upto5years) {
		this.r47_3year_upto5years = r47_3year_upto5years;
	}
	public BigDecimal getR47_5year_upto7years() {
		return r47_5year_upto7years;
	}
	public void setR47_5year_upto7years(BigDecimal r47_5year_upto7years) {
		this.r47_5year_upto7years = r47_5year_upto7years;
	}
	public BigDecimal getR47_7year_upto10years() {
		return r47_7year_upto10years;
	}
	public void setR47_7year_upto10years(BigDecimal r47_7year_upto10years) {
		this.r47_7year_upto10years = r47_7year_upto10years;
	}
	public BigDecimal getR47_10year_upto15years() {
		return r47_10year_upto15years;
	}
	public void setR47_10year_upto15years(BigDecimal r47_10year_upto15years) {
		this.r47_10year_upto15years = r47_10year_upto15years;
	}
	public BigDecimal getR47_15years() {
		return r47_15years;
	}
	public void setR47_15years(BigDecimal r47_15years) {
		this.r47_15years = r47_15years;
	}
	public BigDecimal getR47_nonsensitive() {
		return r47_nonsensitive;
	}
	public void setR47_nonsensitive(BigDecimal r47_nonsensitive) {
		this.r47_nonsensitive = r47_nonsensitive;
	}
	public BigDecimal getR47_total_rsl() {
		return r47_total_rsl;
	}
	public void setR47_total_rsl(BigDecimal r47_total_rsl) {
		this.r47_total_rsl = r47_total_rsl;
	}
	public BigDecimal getR47_total() {
		return r47_total;
	}
	public void setR47_total(BigDecimal r47_total) {
		this.r47_total = r47_total;
	}
	public String getR48_product() {
		return r48_product;
	}
	public void setR48_product(String r48_product) {
		this.r48_product = r48_product;
	}
	public BigDecimal getR48_1_to_28days() {
		return r48_1_to_28days;
	}
	public void setR48_1_to_28days(BigDecimal r48_1_to_28days) {
		this.r48_1_to_28days = r48_1_to_28days;
	}
	public BigDecimal getR48_29days_to_3months() {
		return r48_29days_to_3months;
	}
	public void setR48_29days_to_3months(BigDecimal r48_29days_to_3months) {
		this.r48_29days_to_3months = r48_29days_to_3months;
	}
	public BigDecimal getR48_3months_6months() {
		return r48_3months_6months;
	}
	public void setR48_3months_6months(BigDecimal r48_3months_6months) {
		this.r48_3months_6months = r48_3months_6months;
	}
	public BigDecimal getR48_6months_upto1year() {
		return r48_6months_upto1year;
	}
	public void setR48_6months_upto1year(BigDecimal r48_6months_upto1year) {
		this.r48_6months_upto1year = r48_6months_upto1year;
	}
	public BigDecimal getR48_1year_upto3years() {
		return r48_1year_upto3years;
	}
	public void setR48_1year_upto3years(BigDecimal r48_1year_upto3years) {
		this.r48_1year_upto3years = r48_1year_upto3years;
	}
	public BigDecimal getR48_3year_upto5years() {
		return r48_3year_upto5years;
	}
	public void setR48_3year_upto5years(BigDecimal r48_3year_upto5years) {
		this.r48_3year_upto5years = r48_3year_upto5years;
	}
	public BigDecimal getR48_5year_upto7years() {
		return r48_5year_upto7years;
	}
	public void setR48_5year_upto7years(BigDecimal r48_5year_upto7years) {
		this.r48_5year_upto7years = r48_5year_upto7years;
	}
	public BigDecimal getR48_7year_upto10years() {
		return r48_7year_upto10years;
	}
	public void setR48_7year_upto10years(BigDecimal r48_7year_upto10years) {
		this.r48_7year_upto10years = r48_7year_upto10years;
	}
	public BigDecimal getR48_10year_upto15years() {
		return r48_10year_upto15years;
	}
	public void setR48_10year_upto15years(BigDecimal r48_10year_upto15years) {
		this.r48_10year_upto15years = r48_10year_upto15years;
	}
	public BigDecimal getR48_15years() {
		return r48_15years;
	}
	public void setR48_15years(BigDecimal r48_15years) {
		this.r48_15years = r48_15years;
	}
	public BigDecimal getR48_nonsensitive() {
		return r48_nonsensitive;
	}
	public void setR48_nonsensitive(BigDecimal r48_nonsensitive) {
		this.r48_nonsensitive = r48_nonsensitive;
	}
	public BigDecimal getR48_total_rsl() {
		return r48_total_rsl;
	}
	public void setR48_total_rsl(BigDecimal r48_total_rsl) {
		this.r48_total_rsl = r48_total_rsl;
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
	public BigDecimal getR49_1_to_28days() {
		return r49_1_to_28days;
	}
	public void setR49_1_to_28days(BigDecimal r49_1_to_28days) {
		this.r49_1_to_28days = r49_1_to_28days;
	}
	public BigDecimal getR49_29days_to_3months() {
		return r49_29days_to_3months;
	}
	public void setR49_29days_to_3months(BigDecimal r49_29days_to_3months) {
		this.r49_29days_to_3months = r49_29days_to_3months;
	}
	public BigDecimal getR49_3months_6months() {
		return r49_3months_6months;
	}
	public void setR49_3months_6months(BigDecimal r49_3months_6months) {
		this.r49_3months_6months = r49_3months_6months;
	}
	public BigDecimal getR49_6months_upto1year() {
		return r49_6months_upto1year;
	}
	public void setR49_6months_upto1year(BigDecimal r49_6months_upto1year) {
		this.r49_6months_upto1year = r49_6months_upto1year;
	}
	public BigDecimal getR49_1year_upto3years() {
		return r49_1year_upto3years;
	}
	public void setR49_1year_upto3years(BigDecimal r49_1year_upto3years) {
		this.r49_1year_upto3years = r49_1year_upto3years;
	}
	public BigDecimal getR49_3year_upto5years() {
		return r49_3year_upto5years;
	}
	public void setR49_3year_upto5years(BigDecimal r49_3year_upto5years) {
		this.r49_3year_upto5years = r49_3year_upto5years;
	}
	public BigDecimal getR49_5year_upto7years() {
		return r49_5year_upto7years;
	}
	public void setR49_5year_upto7years(BigDecimal r49_5year_upto7years) {
		this.r49_5year_upto7years = r49_5year_upto7years;
	}
	public BigDecimal getR49_7year_upto10years() {
		return r49_7year_upto10years;
	}
	public void setR49_7year_upto10years(BigDecimal r49_7year_upto10years) {
		this.r49_7year_upto10years = r49_7year_upto10years;
	}
	public BigDecimal getR49_10year_upto15years() {
		return r49_10year_upto15years;
	}
	public void setR49_10year_upto15years(BigDecimal r49_10year_upto15years) {
		this.r49_10year_upto15years = r49_10year_upto15years;
	}
	public BigDecimal getR49_15years() {
		return r49_15years;
	}
	public void setR49_15years(BigDecimal r49_15years) {
		this.r49_15years = r49_15years;
	}
	public BigDecimal getR49_nonsensitive() {
		return r49_nonsensitive;
	}
	public void setR49_nonsensitive(BigDecimal r49_nonsensitive) {
		this.r49_nonsensitive = r49_nonsensitive;
	}
	public BigDecimal getR49_total_rsl() {
		return r49_total_rsl;
	}
	public void setR49_total_rsl(BigDecimal r49_total_rsl) {
		this.r49_total_rsl = r49_total_rsl;
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
	public BigDecimal getR50_1_to_28days() {
		return r50_1_to_28days;
	}
	public void setR50_1_to_28days(BigDecimal r50_1_to_28days) {
		this.r50_1_to_28days = r50_1_to_28days;
	}
	public BigDecimal getR50_29days_to_3months() {
		return r50_29days_to_3months;
	}
	public void setR50_29days_to_3months(BigDecimal r50_29days_to_3months) {
		this.r50_29days_to_3months = r50_29days_to_3months;
	}
	public BigDecimal getR50_3months_6months() {
		return r50_3months_6months;
	}
	public void setR50_3months_6months(BigDecimal r50_3months_6months) {
		this.r50_3months_6months = r50_3months_6months;
	}
	public BigDecimal getR50_6months_upto1year() {
		return r50_6months_upto1year;
	}
	public void setR50_6months_upto1year(BigDecimal r50_6months_upto1year) {
		this.r50_6months_upto1year = r50_6months_upto1year;
	}
	public BigDecimal getR50_1year_upto3years() {
		return r50_1year_upto3years;
	}
	public void setR50_1year_upto3years(BigDecimal r50_1year_upto3years) {
		this.r50_1year_upto3years = r50_1year_upto3years;
	}
	public BigDecimal getR50_3year_upto5years() {
		return r50_3year_upto5years;
	}
	public void setR50_3year_upto5years(BigDecimal r50_3year_upto5years) {
		this.r50_3year_upto5years = r50_3year_upto5years;
	}
	public BigDecimal getR50_5year_upto7years() {
		return r50_5year_upto7years;
	}
	public void setR50_5year_upto7years(BigDecimal r50_5year_upto7years) {
		this.r50_5year_upto7years = r50_5year_upto7years;
	}
	public BigDecimal getR50_7year_upto10years() {
		return r50_7year_upto10years;
	}
	public void setR50_7year_upto10years(BigDecimal r50_7year_upto10years) {
		this.r50_7year_upto10years = r50_7year_upto10years;
	}
	public BigDecimal getR50_10year_upto15years() {
		return r50_10year_upto15years;
	}
	public void setR50_10year_upto15years(BigDecimal r50_10year_upto15years) {
		this.r50_10year_upto15years = r50_10year_upto15years;
	}
	public BigDecimal getR50_15years() {
		return r50_15years;
	}
	public void setR50_15years(BigDecimal r50_15years) {
		this.r50_15years = r50_15years;
	}
	public BigDecimal getR50_nonsensitive() {
		return r50_nonsensitive;
	}
	public void setR50_nonsensitive(BigDecimal r50_nonsensitive) {
		this.r50_nonsensitive = r50_nonsensitive;
	}
	public BigDecimal getR50_total_rsl() {
		return r50_total_rsl;
	}
	public void setR50_total_rsl(BigDecimal r50_total_rsl) {
		this.r50_total_rsl = r50_total_rsl;
	}
	public BigDecimal getR50_total() {
		return r50_total;
	}
	public void setR50_total(BigDecimal r50_total) {
		this.r50_total = r50_total;
	}
	public String getR51_product() {
		return r51_product;
	}
	public void setR51_product(String r51_product) {
		this.r51_product = r51_product;
	}
	public BigDecimal getR51_1_to_28days() {
		return r51_1_to_28days;
	}
	public void setR51_1_to_28days(BigDecimal r51_1_to_28days) {
		this.r51_1_to_28days = r51_1_to_28days;
	}
	public BigDecimal getR51_29days_to_3months() {
		return r51_29days_to_3months;
	}
	public void setR51_29days_to_3months(BigDecimal r51_29days_to_3months) {
		this.r51_29days_to_3months = r51_29days_to_3months;
	}
	public BigDecimal getR51_3months_6months() {
		return r51_3months_6months;
	}
	public void setR51_3months_6months(BigDecimal r51_3months_6months) {
		this.r51_3months_6months = r51_3months_6months;
	}
	public BigDecimal getR51_6months_upto1year() {
		return r51_6months_upto1year;
	}
	public void setR51_6months_upto1year(BigDecimal r51_6months_upto1year) {
		this.r51_6months_upto1year = r51_6months_upto1year;
	}
	public BigDecimal getR51_1year_upto3years() {
		return r51_1year_upto3years;
	}
	public void setR51_1year_upto3years(BigDecimal r51_1year_upto3years) {
		this.r51_1year_upto3years = r51_1year_upto3years;
	}
	public BigDecimal getR51_3year_upto5years() {
		return r51_3year_upto5years;
	}
	public void setR51_3year_upto5years(BigDecimal r51_3year_upto5years) {
		this.r51_3year_upto5years = r51_3year_upto5years;
	}
	public BigDecimal getR51_5year_upto7years() {
		return r51_5year_upto7years;
	}
	public void setR51_5year_upto7years(BigDecimal r51_5year_upto7years) {
		this.r51_5year_upto7years = r51_5year_upto7years;
	}
	public BigDecimal getR51_7year_upto10years() {
		return r51_7year_upto10years;
	}
	public void setR51_7year_upto10years(BigDecimal r51_7year_upto10years) {
		this.r51_7year_upto10years = r51_7year_upto10years;
	}
	public BigDecimal getR51_10year_upto15years() {
		return r51_10year_upto15years;
	}
	public void setR51_10year_upto15years(BigDecimal r51_10year_upto15years) {
		this.r51_10year_upto15years = r51_10year_upto15years;
	}
	public BigDecimal getR51_15years() {
		return r51_15years;
	}
	public void setR51_15years(BigDecimal r51_15years) {
		this.r51_15years = r51_15years;
	}
	public BigDecimal getR51_nonsensitive() {
		return r51_nonsensitive;
	}
	public void setR51_nonsensitive(BigDecimal r51_nonsensitive) {
		this.r51_nonsensitive = r51_nonsensitive;
	}
	public BigDecimal getR51_total_rsl() {
		return r51_total_rsl;
	}
	public void setR51_total_rsl(BigDecimal r51_total_rsl) {
		this.r51_total_rsl = r51_total_rsl;
	}
	public BigDecimal getR51_total() {
		return r51_total;
	}
	public void setR51_total(BigDecimal r51_total) {
		this.r51_total = r51_total;
	}
	public String getR52_product() {
		return r52_product;
	}
	public void setR52_product(String r52_product) {
		this.r52_product = r52_product;
	}
	public BigDecimal getR52_1_to_28days() {
		return r52_1_to_28days;
	}
	public void setR52_1_to_28days(BigDecimal r52_1_to_28days) {
		this.r52_1_to_28days = r52_1_to_28days;
	}
	public BigDecimal getR52_29days_to_3months() {
		return r52_29days_to_3months;
	}
	public void setR52_29days_to_3months(BigDecimal r52_29days_to_3months) {
		this.r52_29days_to_3months = r52_29days_to_3months;
	}
	public BigDecimal getR52_3months_6months() {
		return r52_3months_6months;
	}
	public void setR52_3months_6months(BigDecimal r52_3months_6months) {
		this.r52_3months_6months = r52_3months_6months;
	}
	public BigDecimal getR52_6months_upto1year() {
		return r52_6months_upto1year;
	}
	public void setR52_6months_upto1year(BigDecimal r52_6months_upto1year) {
		this.r52_6months_upto1year = r52_6months_upto1year;
	}
	public BigDecimal getR52_1year_upto3years() {
		return r52_1year_upto3years;
	}
	public void setR52_1year_upto3years(BigDecimal r52_1year_upto3years) {
		this.r52_1year_upto3years = r52_1year_upto3years;
	}
	public BigDecimal getR52_3year_upto5years() {
		return r52_3year_upto5years;
	}
	public void setR52_3year_upto5years(BigDecimal r52_3year_upto5years) {
		this.r52_3year_upto5years = r52_3year_upto5years;
	}
	public BigDecimal getR52_5year_upto7years() {
		return r52_5year_upto7years;
	}
	public void setR52_5year_upto7years(BigDecimal r52_5year_upto7years) {
		this.r52_5year_upto7years = r52_5year_upto7years;
	}
	public BigDecimal getR52_7year_upto10years() {
		return r52_7year_upto10years;
	}
	public void setR52_7year_upto10years(BigDecimal r52_7year_upto10years) {
		this.r52_7year_upto10years = r52_7year_upto10years;
	}
	public BigDecimal getR52_10year_upto15years() {
		return r52_10year_upto15years;
	}
	public void setR52_10year_upto15years(BigDecimal r52_10year_upto15years) {
		this.r52_10year_upto15years = r52_10year_upto15years;
	}
	public BigDecimal getR52_15years() {
		return r52_15years;
	}
	public void setR52_15years(BigDecimal r52_15years) {
		this.r52_15years = r52_15years;
	}
	public BigDecimal getR52_nonsensitive() {
		return r52_nonsensitive;
	}
	public void setR52_nonsensitive(BigDecimal r52_nonsensitive) {
		this.r52_nonsensitive = r52_nonsensitive;
	}
	public BigDecimal getR52_total_rsl() {
		return r52_total_rsl;
	}
	public void setR52_total_rsl(BigDecimal r52_total_rsl) {
		this.r52_total_rsl = r52_total_rsl;
	}
	public BigDecimal getR52_total() {
		return r52_total;
	}
	public void setR52_total(BigDecimal r52_total) {
		this.r52_total = r52_total;
	}
	public String getR53_product() {
		return r53_product;
	}
	public void setR53_product(String r53_product) {
		this.r53_product = r53_product;
	}
	public BigDecimal getR53_1_to_28days() {
		return r53_1_to_28days;
	}
	public void setR53_1_to_28days(BigDecimal r53_1_to_28days) {
		this.r53_1_to_28days = r53_1_to_28days;
	}
	public BigDecimal getR53_29days_to_3months() {
		return r53_29days_to_3months;
	}
	public void setR53_29days_to_3months(BigDecimal r53_29days_to_3months) {
		this.r53_29days_to_3months = r53_29days_to_3months;
	}
	public BigDecimal getR53_3months_6months() {
		return r53_3months_6months;
	}
	public void setR53_3months_6months(BigDecimal r53_3months_6months) {
		this.r53_3months_6months = r53_3months_6months;
	}
	public BigDecimal getR53_6months_upto1year() {
		return r53_6months_upto1year;
	}
	public void setR53_6months_upto1year(BigDecimal r53_6months_upto1year) {
		this.r53_6months_upto1year = r53_6months_upto1year;
	}
	public BigDecimal getR53_1year_upto3years() {
		return r53_1year_upto3years;
	}
	public void setR53_1year_upto3years(BigDecimal r53_1year_upto3years) {
		this.r53_1year_upto3years = r53_1year_upto3years;
	}
	public BigDecimal getR53_3year_upto5years() {
		return r53_3year_upto5years;
	}
	public void setR53_3year_upto5years(BigDecimal r53_3year_upto5years) {
		this.r53_3year_upto5years = r53_3year_upto5years;
	}
	public BigDecimal getR53_5year_upto7years() {
		return r53_5year_upto7years;
	}
	public void setR53_5year_upto7years(BigDecimal r53_5year_upto7years) {
		this.r53_5year_upto7years = r53_5year_upto7years;
	}
	public BigDecimal getR53_7year_upto10years() {
		return r53_7year_upto10years;
	}
	public void setR53_7year_upto10years(BigDecimal r53_7year_upto10years) {
		this.r53_7year_upto10years = r53_7year_upto10years;
	}
	public BigDecimal getR53_10year_upto15years() {
		return r53_10year_upto15years;
	}
	public void setR53_10year_upto15years(BigDecimal r53_10year_upto15years) {
		this.r53_10year_upto15years = r53_10year_upto15years;
	}
	public BigDecimal getR53_15years() {
		return r53_15years;
	}
	public void setR53_15years(BigDecimal r53_15years) {
		this.r53_15years = r53_15years;
	}
	public BigDecimal getR53_nonsensitive() {
		return r53_nonsensitive;
	}
	public void setR53_nonsensitive(BigDecimal r53_nonsensitive) {
		this.r53_nonsensitive = r53_nonsensitive;
	}
	public BigDecimal getR53_total_rsl() {
		return r53_total_rsl;
	}
	public void setR53_total_rsl(BigDecimal r53_total_rsl) {
		this.r53_total_rsl = r53_total_rsl;
	}
	public BigDecimal getR53_total() {
		return r53_total;
	}
	public void setR53_total(BigDecimal r53_total) {
		this.r53_total = r53_total;
	}
	public String getR54_product() {
		return r54_product;
	}
	public void setR54_product(String r54_product) {
		this.r54_product = r54_product;
	}
	public BigDecimal getR54_1_to_28days() {
		return r54_1_to_28days;
	}
	public void setR54_1_to_28days(BigDecimal r54_1_to_28days) {
		this.r54_1_to_28days = r54_1_to_28days;
	}
	public BigDecimal getR54_29days_to_3months() {
		return r54_29days_to_3months;
	}
	public void setR54_29days_to_3months(BigDecimal r54_29days_to_3months) {
		this.r54_29days_to_3months = r54_29days_to_3months;
	}
	public BigDecimal getR54_3months_6months() {
		return r54_3months_6months;
	}
	public void setR54_3months_6months(BigDecimal r54_3months_6months) {
		this.r54_3months_6months = r54_3months_6months;
	}
	public BigDecimal getR54_6months_upto1year() {
		return r54_6months_upto1year;
	}
	public void setR54_6months_upto1year(BigDecimal r54_6months_upto1year) {
		this.r54_6months_upto1year = r54_6months_upto1year;
	}
	public BigDecimal getR54_1year_upto3years() {
		return r54_1year_upto3years;
	}
	public void setR54_1year_upto3years(BigDecimal r54_1year_upto3years) {
		this.r54_1year_upto3years = r54_1year_upto3years;
	}
	public BigDecimal getR54_3year_upto5years() {
		return r54_3year_upto5years;
	}
	public void setR54_3year_upto5years(BigDecimal r54_3year_upto5years) {
		this.r54_3year_upto5years = r54_3year_upto5years;
	}
	public BigDecimal getR54_5year_upto7years() {
		return r54_5year_upto7years;
	}
	public void setR54_5year_upto7years(BigDecimal r54_5year_upto7years) {
		this.r54_5year_upto7years = r54_5year_upto7years;
	}
	public BigDecimal getR54_7year_upto10years() {
		return r54_7year_upto10years;
	}
	public void setR54_7year_upto10years(BigDecimal r54_7year_upto10years) {
		this.r54_7year_upto10years = r54_7year_upto10years;
	}
	public BigDecimal getR54_10year_upto15years() {
		return r54_10year_upto15years;
	}
	public void setR54_10year_upto15years(BigDecimal r54_10year_upto15years) {
		this.r54_10year_upto15years = r54_10year_upto15years;
	}
	public BigDecimal getR54_15years() {
		return r54_15years;
	}
	public void setR54_15years(BigDecimal r54_15years) {
		this.r54_15years = r54_15years;
	}
	public BigDecimal getR54_nonsensitive() {
		return r54_nonsensitive;
	}
	public void setR54_nonsensitive(BigDecimal r54_nonsensitive) {
		this.r54_nonsensitive = r54_nonsensitive;
	}
	public BigDecimal getR54_total_rsl() {
		return r54_total_rsl;
	}
	public void setR54_total_rsl(BigDecimal r54_total_rsl) {
		this.r54_total_rsl = r54_total_rsl;
	}
	public BigDecimal getR54_total() {
		return r54_total;
	}
	public void setR54_total(BigDecimal r54_total) {
		this.r54_total = r54_total;
	}
	public String getR55_product() {
		return r55_product;
	}
	public void setR55_product(String r55_product) {
		this.r55_product = r55_product;
	}
	public BigDecimal getR55_1_to_28days() {
		return r55_1_to_28days;
	}
	public void setR55_1_to_28days(BigDecimal r55_1_to_28days) {
		this.r55_1_to_28days = r55_1_to_28days;
	}
	public BigDecimal getR55_29days_to_3months() {
		return r55_29days_to_3months;
	}
	public void setR55_29days_to_3months(BigDecimal r55_29days_to_3months) {
		this.r55_29days_to_3months = r55_29days_to_3months;
	}
	public BigDecimal getR55_3months_6months() {
		return r55_3months_6months;
	}
	public void setR55_3months_6months(BigDecimal r55_3months_6months) {
		this.r55_3months_6months = r55_3months_6months;
	}
	public BigDecimal getR55_6months_upto1year() {
		return r55_6months_upto1year;
	}
	public void setR55_6months_upto1year(BigDecimal r55_6months_upto1year) {
		this.r55_6months_upto1year = r55_6months_upto1year;
	}
	public BigDecimal getR55_1year_upto3years() {
		return r55_1year_upto3years;
	}
	public void setR55_1year_upto3years(BigDecimal r55_1year_upto3years) {
		this.r55_1year_upto3years = r55_1year_upto3years;
	}
	public BigDecimal getR55_3year_upto5years() {
		return r55_3year_upto5years;
	}
	public void setR55_3year_upto5years(BigDecimal r55_3year_upto5years) {
		this.r55_3year_upto5years = r55_3year_upto5years;
	}
	public BigDecimal getR55_5year_upto7years() {
		return r55_5year_upto7years;
	}
	public void setR55_5year_upto7years(BigDecimal r55_5year_upto7years) {
		this.r55_5year_upto7years = r55_5year_upto7years;
	}
	public BigDecimal getR55_7year_upto10years() {
		return r55_7year_upto10years;
	}
	public void setR55_7year_upto10years(BigDecimal r55_7year_upto10years) {
		this.r55_7year_upto10years = r55_7year_upto10years;
	}
	public BigDecimal getR55_10year_upto15years() {
		return r55_10year_upto15years;
	}
	public void setR55_10year_upto15years(BigDecimal r55_10year_upto15years) {
		this.r55_10year_upto15years = r55_10year_upto15years;
	}
	public BigDecimal getR55_15years() {
		return r55_15years;
	}
	public void setR55_15years(BigDecimal r55_15years) {
		this.r55_15years = r55_15years;
	}
	public BigDecimal getR55_nonsensitive() {
		return r55_nonsensitive;
	}
	public void setR55_nonsensitive(BigDecimal r55_nonsensitive) {
		this.r55_nonsensitive = r55_nonsensitive;
	}
	public BigDecimal getR55_total_rsl() {
		return r55_total_rsl;
	}
	public void setR55_total_rsl(BigDecimal r55_total_rsl) {
		this.r55_total_rsl = r55_total_rsl;
	}
	public BigDecimal getR55_total() {
		return r55_total;
	}
	public void setR55_total(BigDecimal r55_total) {
		this.r55_total = r55_total;
	}
	public String getR56_product() {
		return r56_product;
	}
	public void setR56_product(String r56_product) {
		this.r56_product = r56_product;
	}
	public BigDecimal getR56_1_to_28days() {
		return r56_1_to_28days;
	}
	public void setR56_1_to_28days(BigDecimal r56_1_to_28days) {
		this.r56_1_to_28days = r56_1_to_28days;
	}
	public BigDecimal getR56_29days_to_3months() {
		return r56_29days_to_3months;
	}
	public void setR56_29days_to_3months(BigDecimal r56_29days_to_3months) {
		this.r56_29days_to_3months = r56_29days_to_3months;
	}
	public BigDecimal getR56_3months_6months() {
		return r56_3months_6months;
	}
	public void setR56_3months_6months(BigDecimal r56_3months_6months) {
		this.r56_3months_6months = r56_3months_6months;
	}
	public BigDecimal getR56_6months_upto1year() {
		return r56_6months_upto1year;
	}
	public void setR56_6months_upto1year(BigDecimal r56_6months_upto1year) {
		this.r56_6months_upto1year = r56_6months_upto1year;
	}
	public BigDecimal getR56_1year_upto3years() {
		return r56_1year_upto3years;
	}
	public void setR56_1year_upto3years(BigDecimal r56_1year_upto3years) {
		this.r56_1year_upto3years = r56_1year_upto3years;
	}
	public BigDecimal getR56_3year_upto5years() {
		return r56_3year_upto5years;
	}
	public void setR56_3year_upto5years(BigDecimal r56_3year_upto5years) {
		this.r56_3year_upto5years = r56_3year_upto5years;
	}
	public BigDecimal getR56_5year_upto7years() {
		return r56_5year_upto7years;
	}
	public void setR56_5year_upto7years(BigDecimal r56_5year_upto7years) {
		this.r56_5year_upto7years = r56_5year_upto7years;
	}
	public BigDecimal getR56_7year_upto10years() {
		return r56_7year_upto10years;
	}
	public void setR56_7year_upto10years(BigDecimal r56_7year_upto10years) {
		this.r56_7year_upto10years = r56_7year_upto10years;
	}
	public BigDecimal getR56_10year_upto15years() {
		return r56_10year_upto15years;
	}
	public void setR56_10year_upto15years(BigDecimal r56_10year_upto15years) {
		this.r56_10year_upto15years = r56_10year_upto15years;
	}
	public BigDecimal getR56_15years() {
		return r56_15years;
	}
	public void setR56_15years(BigDecimal r56_15years) {
		this.r56_15years = r56_15years;
	}
	public BigDecimal getR56_nonsensitive() {
		return r56_nonsensitive;
	}
	public void setR56_nonsensitive(BigDecimal r56_nonsensitive) {
		this.r56_nonsensitive = r56_nonsensitive;
	}
	public BigDecimal getR56_total_rsl() {
		return r56_total_rsl;
	}
	public void setR56_total_rsl(BigDecimal r56_total_rsl) {
		this.r56_total_rsl = r56_total_rsl;
	}
	public BigDecimal getR56_total() {
		return r56_total;
	}
	public void setR56_total(BigDecimal r56_total) {
		this.r56_total = r56_total;
	}
	public String getR57_product() {
		return r57_product;
	}
	public void setR57_product(String r57_product) {
		this.r57_product = r57_product;
	}
	public BigDecimal getR57_1_to_28days() {
		return r57_1_to_28days;
	}
	public void setR57_1_to_28days(BigDecimal r57_1_to_28days) {
		this.r57_1_to_28days = r57_1_to_28days;
	}
	public BigDecimal getR57_29days_to_3months() {
		return r57_29days_to_3months;
	}
	public void setR57_29days_to_3months(BigDecimal r57_29days_to_3months) {
		this.r57_29days_to_3months = r57_29days_to_3months;
	}
	public BigDecimal getR57_3months_6months() {
		return r57_3months_6months;
	}
	public void setR57_3months_6months(BigDecimal r57_3months_6months) {
		this.r57_3months_6months = r57_3months_6months;
	}
	public BigDecimal getR57_6months_upto1year() {
		return r57_6months_upto1year;
	}
	public void setR57_6months_upto1year(BigDecimal r57_6months_upto1year) {
		this.r57_6months_upto1year = r57_6months_upto1year;
	}
	public BigDecimal getR57_1year_upto3years() {
		return r57_1year_upto3years;
	}
	public void setR57_1year_upto3years(BigDecimal r57_1year_upto3years) {
		this.r57_1year_upto3years = r57_1year_upto3years;
	}
	public BigDecimal getR57_3year_upto5years() {
		return r57_3year_upto5years;
	}
	public void setR57_3year_upto5years(BigDecimal r57_3year_upto5years) {
		this.r57_3year_upto5years = r57_3year_upto5years;
	}
	public BigDecimal getR57_5year_upto7years() {
		return r57_5year_upto7years;
	}
	public void setR57_5year_upto7years(BigDecimal r57_5year_upto7years) {
		this.r57_5year_upto7years = r57_5year_upto7years;
	}
	public BigDecimal getR57_7year_upto10years() {
		return r57_7year_upto10years;
	}
	public void setR57_7year_upto10years(BigDecimal r57_7year_upto10years) {
		this.r57_7year_upto10years = r57_7year_upto10years;
	}
	public BigDecimal getR57_10year_upto15years() {
		return r57_10year_upto15years;
	}
	public void setR57_10year_upto15years(BigDecimal r57_10year_upto15years) {
		this.r57_10year_upto15years = r57_10year_upto15years;
	}
	public BigDecimal getR57_15years() {
		return r57_15years;
	}
	public void setR57_15years(BigDecimal r57_15years) {
		this.r57_15years = r57_15years;
	}
	public BigDecimal getR57_nonsensitive() {
		return r57_nonsensitive;
	}
	public void setR57_nonsensitive(BigDecimal r57_nonsensitive) {
		this.r57_nonsensitive = r57_nonsensitive;
	}
	public BigDecimal getR57_total_rsl() {
		return r57_total_rsl;
	}
	public void setR57_total_rsl(BigDecimal r57_total_rsl) {
		this.r57_total_rsl = r57_total_rsl;
	}
	public BigDecimal getR57_total() {
		return r57_total;
	}
	public void setR57_total(BigDecimal r57_total) {
		this.r57_total = r57_total;
	}
	public String getR58_product() {
		return r58_product;
	}
	public void setR58_product(String r58_product) {
		this.r58_product = r58_product;
	}
	public BigDecimal getR58_1_to_28days() {
		return r58_1_to_28days;
	}
	public void setR58_1_to_28days(BigDecimal r58_1_to_28days) {
		this.r58_1_to_28days = r58_1_to_28days;
	}
	public BigDecimal getR58_29days_to_3months() {
		return r58_29days_to_3months;
	}
	public void setR58_29days_to_3months(BigDecimal r58_29days_to_3months) {
		this.r58_29days_to_3months = r58_29days_to_3months;
	}
	public BigDecimal getR58_3months_6months() {
		return r58_3months_6months;
	}
	public void setR58_3months_6months(BigDecimal r58_3months_6months) {
		this.r58_3months_6months = r58_3months_6months;
	}
	public BigDecimal getR58_6months_upto1year() {
		return r58_6months_upto1year;
	}
	public void setR58_6months_upto1year(BigDecimal r58_6months_upto1year) {
		this.r58_6months_upto1year = r58_6months_upto1year;
	}
	public BigDecimal getR58_1year_upto3years() {
		return r58_1year_upto3years;
	}
	public void setR58_1year_upto3years(BigDecimal r58_1year_upto3years) {
		this.r58_1year_upto3years = r58_1year_upto3years;
	}
	public BigDecimal getR58_3year_upto5years() {
		return r58_3year_upto5years;
	}
	public void setR58_3year_upto5years(BigDecimal r58_3year_upto5years) {
		this.r58_3year_upto5years = r58_3year_upto5years;
	}
	public BigDecimal getR58_5year_upto7years() {
		return r58_5year_upto7years;
	}
	public void setR58_5year_upto7years(BigDecimal r58_5year_upto7years) {
		this.r58_5year_upto7years = r58_5year_upto7years;
	}
	public BigDecimal getR58_7year_upto10years() {
		return r58_7year_upto10years;
	}
	public void setR58_7year_upto10years(BigDecimal r58_7year_upto10years) {
		this.r58_7year_upto10years = r58_7year_upto10years;
	}
	public BigDecimal getR58_10year_upto15years() {
		return r58_10year_upto15years;
	}
	public void setR58_10year_upto15years(BigDecimal r58_10year_upto15years) {
		this.r58_10year_upto15years = r58_10year_upto15years;
	}
	public BigDecimal getR58_15years() {
		return r58_15years;
	}
	public void setR58_15years(BigDecimal r58_15years) {
		this.r58_15years = r58_15years;
	}
	public BigDecimal getR58_nonsensitive() {
		return r58_nonsensitive;
	}
	public void setR58_nonsensitive(BigDecimal r58_nonsensitive) {
		this.r58_nonsensitive = r58_nonsensitive;
	}
	public BigDecimal getR58_total_rsl() {
		return r58_total_rsl;
	}
	public void setR58_total_rsl(BigDecimal r58_total_rsl) {
		this.r58_total_rsl = r58_total_rsl;
	}
	public BigDecimal getR58_total() {
		return r58_total;
	}
	public void setR58_total(BigDecimal r58_total) {
		this.r58_total = r58_total;
	}
	public String getR59_product() {
		return r59_product;
	}
	public void setR59_product(String r59_product) {
		this.r59_product = r59_product;
	}
	public BigDecimal getR59_1_to_28days() {
		return r59_1_to_28days;
	}
	public void setR59_1_to_28days(BigDecimal r59_1_to_28days) {
		this.r59_1_to_28days = r59_1_to_28days;
	}
	public BigDecimal getR59_29days_to_3months() {
		return r59_29days_to_3months;
	}
	public void setR59_29days_to_3months(BigDecimal r59_29days_to_3months) {
		this.r59_29days_to_3months = r59_29days_to_3months;
	}
	public BigDecimal getR59_3months_6months() {
		return r59_3months_6months;
	}
	public void setR59_3months_6months(BigDecimal r59_3months_6months) {
		this.r59_3months_6months = r59_3months_6months;
	}
	public BigDecimal getR59_6months_upto1year() {
		return r59_6months_upto1year;
	}
	public void setR59_6months_upto1year(BigDecimal r59_6months_upto1year) {
		this.r59_6months_upto1year = r59_6months_upto1year;
	}
	public BigDecimal getR59_1year_upto3years() {
		return r59_1year_upto3years;
	}
	public void setR59_1year_upto3years(BigDecimal r59_1year_upto3years) {
		this.r59_1year_upto3years = r59_1year_upto3years;
	}
	public BigDecimal getR59_3year_upto5years() {
		return r59_3year_upto5years;
	}
	public void setR59_3year_upto5years(BigDecimal r59_3year_upto5years) {
		this.r59_3year_upto5years = r59_3year_upto5years;
	}
	public BigDecimal getR59_5year_upto7years() {
		return r59_5year_upto7years;
	}
	public void setR59_5year_upto7years(BigDecimal r59_5year_upto7years) {
		this.r59_5year_upto7years = r59_5year_upto7years;
	}
	public BigDecimal getR59_7year_upto10years() {
		return r59_7year_upto10years;
	}
	public void setR59_7year_upto10years(BigDecimal r59_7year_upto10years) {
		this.r59_7year_upto10years = r59_7year_upto10years;
	}
	public BigDecimal getR59_10year_upto15years() {
		return r59_10year_upto15years;
	}
	public void setR59_10year_upto15years(BigDecimal r59_10year_upto15years) {
		this.r59_10year_upto15years = r59_10year_upto15years;
	}
	public BigDecimal getR59_15years() {
		return r59_15years;
	}
	public void setR59_15years(BigDecimal r59_15years) {
		this.r59_15years = r59_15years;
	}
	public BigDecimal getR59_nonsensitive() {
		return r59_nonsensitive;
	}
	public void setR59_nonsensitive(BigDecimal r59_nonsensitive) {
		this.r59_nonsensitive = r59_nonsensitive;
	}
	public BigDecimal getR59_total_rsl() {
		return r59_total_rsl;
	}
	public void setR59_total_rsl(BigDecimal r59_total_rsl) {
		this.r59_total_rsl = r59_total_rsl;
	}
	public BigDecimal getR59_total() {
		return r59_total;
	}
	public void setR59_total(BigDecimal r59_total) {
		this.r59_total = r59_total;
	}
	public String getR60_product() {
		return r60_product;
	}
	public void setR60_product(String r60_product) {
		this.r60_product = r60_product;
	}
	public BigDecimal getR60_1_to_28days() {
		return r60_1_to_28days;
	}
	public void setR60_1_to_28days(BigDecimal r60_1_to_28days) {
		this.r60_1_to_28days = r60_1_to_28days;
	}
	public BigDecimal getR60_29days_to_3months() {
		return r60_29days_to_3months;
	}
	public void setR60_29days_to_3months(BigDecimal r60_29days_to_3months) {
		this.r60_29days_to_3months = r60_29days_to_3months;
	}
	public BigDecimal getR60_3months_6months() {
		return r60_3months_6months;
	}
	public void setR60_3months_6months(BigDecimal r60_3months_6months) {
		this.r60_3months_6months = r60_3months_6months;
	}
	public BigDecimal getR60_6months_upto1year() {
		return r60_6months_upto1year;
	}
	public void setR60_6months_upto1year(BigDecimal r60_6months_upto1year) {
		this.r60_6months_upto1year = r60_6months_upto1year;
	}
	public BigDecimal getR60_1year_upto3years() {
		return r60_1year_upto3years;
	}
	public void setR60_1year_upto3years(BigDecimal r60_1year_upto3years) {
		this.r60_1year_upto3years = r60_1year_upto3years;
	}
	public BigDecimal getR60_3year_upto5years() {
		return r60_3year_upto5years;
	}
	public void setR60_3year_upto5years(BigDecimal r60_3year_upto5years) {
		this.r60_3year_upto5years = r60_3year_upto5years;
	}
	public BigDecimal getR60_5year_upto7years() {
		return r60_5year_upto7years;
	}
	public void setR60_5year_upto7years(BigDecimal r60_5year_upto7years) {
		this.r60_5year_upto7years = r60_5year_upto7years;
	}
	public BigDecimal getR60_7year_upto10years() {
		return r60_7year_upto10years;
	}
	public void setR60_7year_upto10years(BigDecimal r60_7year_upto10years) {
		this.r60_7year_upto10years = r60_7year_upto10years;
	}
	public BigDecimal getR60_10year_upto15years() {
		return r60_10year_upto15years;
	}
	public void setR60_10year_upto15years(BigDecimal r60_10year_upto15years) {
		this.r60_10year_upto15years = r60_10year_upto15years;
	}
	public BigDecimal getR60_15years() {
		return r60_15years;
	}
	public void setR60_15years(BigDecimal r60_15years) {
		this.r60_15years = r60_15years;
	}
	public BigDecimal getR60_nonsensitive() {
		return r60_nonsensitive;
	}
	public void setR60_nonsensitive(BigDecimal r60_nonsensitive) {
		this.r60_nonsensitive = r60_nonsensitive;
	}
	public BigDecimal getR60_total_rsl() {
		return r60_total_rsl;
	}
	public void setR60_total_rsl(BigDecimal r60_total_rsl) {
		this.r60_total_rsl = r60_total_rsl;
	}
	public BigDecimal getR60_total() {
		return r60_total;
	}
	public void setR60_total(BigDecimal r60_total) {
		this.r60_total = r60_total;
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
	public Banking_Book1() {
		super();
		// TODO Auto-generated constructor stub
	}
}