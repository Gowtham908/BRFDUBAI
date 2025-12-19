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
@Table(name="BRF153_SUMMARYTABLE")
public class BRF153ReportEntity {
	private String	r1_currencies;
	private BigDecimal	r1_notational_amount;
	private BigDecimal	r1_gross_market;
	private BigDecimal	r1_lessthan_oneyear;
	private BigDecimal	r1_onetothree_year;
	private BigDecimal	r1_morethan_threeyear;
	private BigDecimal	r1_plusten_oneyear;
	private BigDecimal	r1_minusten_oneyear;
	private BigDecimal	r1_plusten_onetothreeyear;
	private BigDecimal	r1_minusten_onetothreeyear;
	private BigDecimal	r1_plusten_threeyear;
	private BigDecimal	r1_minusten_threeyear;
	private String	r2_currencies;
	private BigDecimal	r2_notational_amount;
	private BigDecimal	r2_gross_market;
	private BigDecimal	r2_lessthan_oneyear;
	private BigDecimal	r2_onetothree_year;
	private BigDecimal	r2_morethan_threeyear;
	private BigDecimal	r2_plusten_oneyear;
	private BigDecimal	r2_minusten_oneyear;
	private BigDecimal	r2_plusten_onetothreeyear;
	private BigDecimal	r2_minusten_onetothreeyear;
	private BigDecimal	r2_plusten_threeyear;
	private BigDecimal	r2_minusten_threeyear;
	private String	r3_currencies;
	private BigDecimal	r3_notational_amount;
	private BigDecimal	r3_gross_market;
	private BigDecimal	r3_lessthan_oneyear;
	private BigDecimal	r3_onetothree_year;
	private BigDecimal	r3_morethan_threeyear;
	private BigDecimal	r3_plusten_oneyear;
	private BigDecimal	r3_minusten_oneyear;
	private BigDecimal	r3_plusten_onetothreeyear;
	private BigDecimal	r3_minusten_onetothreeyear;
	private BigDecimal	r3_plusten_threeyear;
	private BigDecimal	r3_minusten_threeyear;
	private String	r4_currencies;
	private BigDecimal	r4_notational_amount;
	private BigDecimal	r4_gross_market;
	private BigDecimal	r4_lessthan_oneyear;
	private BigDecimal	r4_onetothree_year;
	private BigDecimal	r4_morethan_threeyear;
	private BigDecimal	r4_plusten_oneyear;
	private BigDecimal	r4_minusten_oneyear;
	private BigDecimal	r4_plusten_onetothreeyear;
	private BigDecimal	r4_minusten_onetothreeyear;
	private BigDecimal	r4_plusten_threeyear;
	private BigDecimal	r4_minusten_threeyear;
	private String	r5_currencies;
	private BigDecimal	r5_notational_amount;
	private BigDecimal	r5_gross_market;
	private BigDecimal	r5_lessthan_oneyear;
	private BigDecimal	r5_onetothree_year;
	private BigDecimal	r5_morethan_threeyear;
	private BigDecimal	r5_plusten_oneyear;
	private BigDecimal	r5_minusten_oneyear;
	private BigDecimal	r5_plusten_onetothreeyear;
	private BigDecimal	r5_minusten_onetothreeyear;
	private BigDecimal	r5_plusten_threeyear;
	private BigDecimal	r5_minusten_threeyear;
	private String	r6_currencies;
	private BigDecimal	r6_notational_amount;
	private BigDecimal	r6_gross_market;
	private BigDecimal	r6_lessthan_oneyear;
	private BigDecimal	r6_onetothree_year;
	private BigDecimal	r6_morethan_threeyear;
	private BigDecimal	r6_plusten_oneyear;
	private BigDecimal	r6_minusten_oneyear;
	private BigDecimal	r6_plusten_onetothreeyear;
	private BigDecimal	r6_minusten_onetothreeyear;
	private BigDecimal	r6_plusten_threeyear;
	private BigDecimal	r6_minusten_threeyear;
	private String	r7_currencies;
	private BigDecimal	r7_notational_amount;
	private BigDecimal	r7_gross_market;
	private BigDecimal	r7_lessthan_oneyear;
	private BigDecimal	r7_onetothree_year;
	private BigDecimal	r7_morethan_threeyear;
	private BigDecimal	r7_plusten_oneyear;
	private BigDecimal	r7_minusten_oneyear;
	private BigDecimal	r7_plusten_onetothreeyear;
	private BigDecimal	r7_minusten_onetothreeyear;
	private BigDecimal	r7_plusten_threeyear;
	private BigDecimal	r7_minusten_threeyear;
	private String	r8_currencies;
	private BigDecimal	r8_notational_amount;
	private BigDecimal	r8_gross_market;
	private BigDecimal	r8_lessthan_oneyear;
	private BigDecimal	r8_onetothree_year;
	private BigDecimal	r8_morethan_threeyear;
	private BigDecimal	r8_plusten_oneyear;
	private BigDecimal	r8_minusten_oneyear;
	private BigDecimal	r8_plusten_onetothreeyear;
	private BigDecimal	r8_minusten_onetothreeyear;
	private BigDecimal	r8_plusten_threeyear;
	private BigDecimal	r8_minusten_threeyear;
	private String	r9_currencies;
	private BigDecimal	r9_notational_amount;
	private BigDecimal	r9_gross_market;
	private BigDecimal	r9_lessthan_oneyear;
	private BigDecimal	r9_onetothree_year;
	private BigDecimal	r9_morethan_threeyear;
	private BigDecimal	r9_plusten_oneyear;
	private BigDecimal	r9_minusten_oneyear;
	private BigDecimal	r9_plusten_onetothreeyear;
	private BigDecimal	r9_minusten_onetothreeyear;
	private BigDecimal	r9_plusten_threeyear;
	private BigDecimal	r9_minusten_threeyear;
	private String	r10_currencies;
	private BigDecimal	r10_notational_amount;
	private BigDecimal	r10_gross_market;
	private BigDecimal	r10_lessthan_oneyear;
	private BigDecimal	r10_onetothree_year;
	private BigDecimal	r10_morethan_threeyear;
	private BigDecimal	r10_plusten_oneyear;
	private BigDecimal	r10_minusten_oneyear;
	private BigDecimal	r10_plusten_onetothreeyear;
	private BigDecimal	r10_minusten_onetothreeyear;
	private BigDecimal	r10_plusten_threeyear;
	private BigDecimal	r10_minusten_threeyear;
	private String	r11_currencies;
	private BigDecimal	r11_notational_amount;
	private BigDecimal	r11_gross_market;
	private BigDecimal	r11_lessthan_oneyear;
	private BigDecimal	r11_onetothree_year;
	private BigDecimal	r11_morethan_threeyear;
	private BigDecimal	r11_plusten_oneyear;
	private BigDecimal	r11_minusten_oneyear;
	private BigDecimal	r11_plusten_onetothreeyear;
	private BigDecimal	r11_minusten_onetothreeyear;
	private BigDecimal	r11_plusten_threeyear;
	private BigDecimal	r11_minusten_threeyear;
	private String	r12_currencies;
	private BigDecimal	r12_notational_amount;
	private BigDecimal	r12_gross_market;
	private BigDecimal	r12_lessthan_oneyear;
	private BigDecimal	r12_onetothree_year;
	private BigDecimal	r12_morethan_threeyear;
	private BigDecimal	r12_plusten_oneyear;
	private BigDecimal	r12_minusten_oneyear;
	private BigDecimal	r12_plusten_onetothreeyear;
	private BigDecimal	r12_minusten_onetothreeyear;
	private BigDecimal	r12_plusten_threeyear;
	private BigDecimal	r12_minusten_threeyear;
	private String	r13_currencies;
	private BigDecimal	r13_notational_amount;
	private BigDecimal	r13_gross_market;
	private BigDecimal	r13_lessthan_oneyear;
	private BigDecimal	r13_onetothree_year;
	private BigDecimal	r13_morethan_threeyear;
	private BigDecimal	r13_plusten_oneyear;
	private BigDecimal	r13_minusten_oneyear;
	private BigDecimal	r13_plusten_onetothreeyear;
	private BigDecimal	r13_minusten_onetothreeyear;
	private BigDecimal	r13_plusten_threeyear;
	private BigDecimal	r13_minusten_threeyear;
	private String	r14_currencies;
	private BigDecimal	r14_notational_amount;
	private BigDecimal	r14_gross_market;
	private BigDecimal	r14_lessthan_oneyear;
	private BigDecimal	r14_onetothree_year;
	private BigDecimal	r14_morethan_threeyear;
	private BigDecimal	r14_plusten_oneyear;
	private BigDecimal	r14_minusten_oneyear;
	private BigDecimal	r14_plusten_onetothreeyear;
	private BigDecimal	r14_minusten_onetothreeyear;
	private BigDecimal	r14_plusten_threeyear;
	private BigDecimal	r14_minusten_threeyear;
	private String	r15_currencies;
	private BigDecimal	r15_notational_amount;
	private BigDecimal	r15_gross_market;
	private BigDecimal	r15_lessthan_oneyear;
	private BigDecimal	r15_onetothree_year;
	private BigDecimal	r15_morethan_threeyear;
	private BigDecimal	r15_plusten_oneyear;
	private BigDecimal	r15_minusten_oneyear;
	private BigDecimal	r15_plusten_onetothreeyear;
	private BigDecimal	r15_minusten_onetothreeyear;
	private BigDecimal	r15_plusten_threeyear;
	private BigDecimal	r15_minusten_threeyear;
	private String	r16_currencies;
	private BigDecimal	r16_notational_amount;
	private BigDecimal	r16_gross_market;
	private BigDecimal	r16_lessthan_oneyear;
	private BigDecimal	r16_onetothree_year;
	private BigDecimal	r16_morethan_threeyear;
	private BigDecimal	r16_plusten_oneyear;
	private BigDecimal	r16_minusten_oneyear;
	private BigDecimal	r16_plusten_onetothreeyear;
	private BigDecimal	r16_minusten_onetothreeyear;
	private BigDecimal	r16_plusten_threeyear;
	private BigDecimal	r16_minusten_threeyear;
	private String	r17_currencies;
	private BigDecimal	r17_notational_amount;
	private BigDecimal	r17_gross_market;
	private BigDecimal	r17_lessthan_oneyear;
	private BigDecimal	r17_onetothree_year;
	private BigDecimal	r17_morethan_threeyear;
	private BigDecimal	r17_plusten_oneyear;
	private BigDecimal	r17_minusten_oneyear;
	private BigDecimal	r17_plusten_onetothreeyear;
	private BigDecimal	r17_minusten_onetothreeyear;
	private BigDecimal	r17_plusten_threeyear;
	private BigDecimal	r17_minusten_threeyear;
	private String	r18_currencies;
	private BigDecimal	r18_notational_amount;
	private BigDecimal	r18_gross_market;
	private BigDecimal	r18_lessthan_oneyear;
	private BigDecimal	r18_onetothree_year;
	private BigDecimal	r18_morethan_threeyear;
	private BigDecimal	r18_plusten_oneyear;
	private BigDecimal	r18_minusten_oneyear;
	private BigDecimal	r18_plusten_onetothreeyear;
	private BigDecimal	r18_minusten_onetothreeyear;
	private BigDecimal	r18_plusten_threeyear;
	private BigDecimal	r18_minusten_threeyear;
	private String	r19_currencies;
	private BigDecimal	r19_notational_amount;
	private BigDecimal	r19_gross_market;
	private BigDecimal	r19_lessthan_oneyear;
	private BigDecimal	r19_onetothree_year;
	private BigDecimal	r19_morethan_threeyear;
	private BigDecimal	r19_plusten_oneyear;
	private BigDecimal	r19_minusten_oneyear;
	private BigDecimal	r19_plusten_onetothreeyear;
	private BigDecimal	r19_minusten_onetothreeyear;
	private BigDecimal	r19_plusten_threeyear;
	private BigDecimal	r19_minusten_threeyear;
	private String	r20_currencies;
	private BigDecimal	r20_notational_amount;
	private BigDecimal	r20_gross_market;
	private BigDecimal	r20_lessthan_oneyear;
	private BigDecimal	r20_onetothree_year;
	private BigDecimal	r20_morethan_threeyear;
	private BigDecimal	r20_plusten_oneyear;
	private BigDecimal	r20_minusten_oneyear;
	private BigDecimal	r20_plusten_onetothreeyear;
	private BigDecimal	r20_minusten_onetothreeyear;
	private BigDecimal	r20_plusten_threeyear;
	private BigDecimal	r20_minusten_threeyear;
	private String	r21_currencies;
	private BigDecimal	r21_notational_amount;
	private BigDecimal	r21_gross_market;
	private BigDecimal	r21_lessthan_oneyear;
	private BigDecimal	r21_onetothree_year;
	private BigDecimal	r21_morethan_threeyear;
	private BigDecimal	r21_plusten_oneyear;
	private BigDecimal	r21_minusten_oneyear;
	private BigDecimal	r21_plusten_onetothreeyear;
	private BigDecimal	r21_minusten_onetothreeyear;
	private BigDecimal	r21_plusten_threeyear;
	private BigDecimal	r21_minusten_threeyear;
	private String	r22_currencies;
	private BigDecimal	r22_notational_amount;
	private BigDecimal	r22_gross_market;
	private BigDecimal	r22_lessthan_oneyear;
	private BigDecimal	r22_onetothree_year;
	private BigDecimal	r22_morethan_threeyear;
	private BigDecimal	r22_plusten_oneyear;
	private BigDecimal	r22_minusten_oneyear;
	private BigDecimal	r22_plusten_onetothreeyear;
	private BigDecimal	r22_minusten_onetothreeyear;
	private BigDecimal	r22_plusten_threeyear;
	private BigDecimal	r22_minusten_threeyear;
	private String	r23_currencies;
	private BigDecimal	r23_notational_amount;
	private BigDecimal	r23_gross_market;
	private BigDecimal	r23_lessthan_oneyear;
	private BigDecimal	r23_onetothree_year;
	private BigDecimal	r23_morethan_threeyear;
	private BigDecimal	r23_plusten_oneyear;
	private BigDecimal	r23_minusten_oneyear;
	private BigDecimal	r23_plusten_onetothreeyear;
	private BigDecimal	r23_minusten_onetothreeyear;
	private BigDecimal	r23_plusten_threeyear;
	private BigDecimal	r23_minusten_threeyear;
	private String	r24_currencies;
	private BigDecimal	r24_notational_amount;
	private BigDecimal	r24_gross_market;
	private BigDecimal	r24_lessthan_oneyear;
	private BigDecimal	r24_onetothree_year;
	private BigDecimal	r24_morethan_threeyear;
	private BigDecimal	r24_plusten_oneyear;
	private BigDecimal	r24_minusten_oneyear;
	private BigDecimal	r24_plusten_onetothreeyear;
	private BigDecimal	r24_minusten_onetothreeyear;
	private BigDecimal	r24_plusten_threeyear;
	private BigDecimal	r24_minusten_threeyear;
	private String	r25_currencies;
	private BigDecimal	r25_notational_amount;
	private BigDecimal	r25_gross_market;
	private BigDecimal	r25_lessthan_oneyear;
	private BigDecimal	r25_onetothree_year;
	private BigDecimal	r25_morethan_threeyear;
	private BigDecimal	r25_plusten_oneyear;
	private BigDecimal	r25_minusten_oneyear;
	private BigDecimal	r25_plusten_onetothreeyear;
	private BigDecimal	r25_minusten_onetothreeyear;
	private BigDecimal	r25_plusten_threeyear;
	private BigDecimal	r25_minusten_threeyear;
	private String	r26_currencies;
	private BigDecimal	r26_notational_amount;
	private BigDecimal	r26_gross_market;
	private BigDecimal	r26_lessthan_oneyear;
	private BigDecimal	r26_onetothree_year;
	private BigDecimal	r26_morethan_threeyear;
	private BigDecimal	r26_plusten_oneyear;
	private BigDecimal	r26_minusten_oneyear;
	private BigDecimal	r26_plusten_onetothreeyear;
	private BigDecimal	r26_minusten_onetothreeyear;
	private BigDecimal	r26_plusten_threeyear;
	private BigDecimal	r26_minusten_threeyear;
	private String	r27_currencies;
	private BigDecimal	r27_notational_amount;
	private BigDecimal	r27_gross_market;
	private BigDecimal	r27_lessthan_oneyear;
	private BigDecimal	r27_onetothree_year;
	private BigDecimal	r27_morethan_threeyear;
	private BigDecimal	r27_plusten_oneyear;
	private BigDecimal	r27_minusten_oneyear;
	private BigDecimal	r27_plusten_onetothreeyear;
	private BigDecimal	r27_minusten_onetothreeyear;
	private BigDecimal	r27_plusten_threeyear;
	private BigDecimal	r27_minusten_threeyear;
	private String	r28_currencies;
	private BigDecimal	r28_notational_amount;
	private BigDecimal	r28_gross_market;
	private BigDecimal	r28_lessthan_oneyear;
	private BigDecimal	r28_onetothree_year;
	private BigDecimal	r28_morethan_threeyear;
	private BigDecimal	r28_plusten_oneyear;
	private BigDecimal	r28_minusten_oneyear;
	private BigDecimal	r28_plusten_onetothreeyear;
	private BigDecimal	r28_minusten_onetothreeyear;
	private BigDecimal	r28_plusten_threeyear;
	private BigDecimal	r28_minusten_threeyear;
	private String	r29_currencies;
	private BigDecimal	r29_notational_amount;
	private BigDecimal	r29_gross_market;
	private BigDecimal	r29_lessthan_oneyear;
	private BigDecimal	r29_onetothree_year;
	private BigDecimal	r29_morethan_threeyear;
	private BigDecimal	r29_plusten_oneyear;
	private BigDecimal	r29_minusten_oneyear;
	private BigDecimal	r29_plusten_onetothreeyear;
	private BigDecimal	r29_minusten_onetothreeyear;
	private BigDecimal	r29_plusten_threeyear;
	private BigDecimal	r29_minusten_threeyear;
	private String	r30_currencies;
	private BigDecimal	r30_notational_amount;
	private BigDecimal	r30_gross_market;
	private BigDecimal	r30_lessthan_oneyear;
	private BigDecimal	r30_onetothree_year;
	private BigDecimal	r30_morethan_threeyear;
	private BigDecimal	r30_plusten_oneyear;
	private BigDecimal	r30_minusten_oneyear;
	private BigDecimal	r30_plusten_onetothreeyear;
	private BigDecimal	r30_minusten_onetothreeyear;
	private BigDecimal	r30_plusten_threeyear;
	private BigDecimal	r30_minusten_threeyear;
	private String	r31_currencies;
	private BigDecimal	r31_notational_amount;
	private BigDecimal	r31_gross_market;
	private BigDecimal	r31_lessthan_oneyear;
	private BigDecimal	r31_onetothree_year;
	private BigDecimal	r31_morethan_threeyear;
	private BigDecimal	r31_plusten_oneyear;
	private BigDecimal	r31_minusten_oneyear;
	private BigDecimal	r31_plusten_onetothreeyear;
	private BigDecimal	r31_minusten_onetothreeyear;
	private BigDecimal	r31_plusten_threeyear;
	private BigDecimal	r31_minusten_threeyear;
	private String	r32_currencies;
	private BigDecimal	r32_notational_amount;
	private BigDecimal	r32_gross_market;
	private BigDecimal	r32_lessthan_oneyear;
	private BigDecimal	r32_onetothree_year;
	private BigDecimal	r32_morethan_threeyear;
	private BigDecimal	r32_plusten_oneyear;
	private BigDecimal	r32_minusten_oneyear;
	private BigDecimal	r32_plusten_onetothreeyear;
	private BigDecimal	r32_minusten_onetothreeyear;
	private BigDecimal	r32_plusten_threeyear;
	private BigDecimal	r32_minusten_threeyear;
	private String	r33_currencies;
	private BigDecimal	r33_notational_amount;
	private BigDecimal	r33_gross_market;
	private BigDecimal	r33_lessthan_oneyear;
	private BigDecimal	r33_onetothree_year;
	private BigDecimal	r33_morethan_threeyear;
	private BigDecimal	r33_plusten_oneyear;
	private BigDecimal	r33_minusten_oneyear;
	private BigDecimal	r33_plusten_onetothreeyear;
	private BigDecimal	r33_minusten_onetothreeyear;
	private BigDecimal	r33_plusten_threeyear;
	private BigDecimal	r33_minusten_threeyear;
	private String	r34_currencies;
	private BigDecimal	r34_notational_amount;
	private BigDecimal	r34_gross_market;
	private BigDecimal	r34_lessthan_oneyear;
	private BigDecimal	r34_onetothree_year;
	private BigDecimal	r34_morethan_threeyear;
	private BigDecimal	r34_plusten_oneyear;
	private BigDecimal	r34_minusten_oneyear;
	private BigDecimal	r34_plusten_onetothreeyear;
	private BigDecimal	r34_minusten_onetothreeyear;
	private BigDecimal	r34_plusten_threeyear;
	private BigDecimal	r34_minusten_threeyear;
	private String	r35_currencies;
	private BigDecimal	r35_notational_amount;
	private BigDecimal	r35_gross_market;
	private BigDecimal	r35_lessthan_oneyear;
	private BigDecimal	r35_onetothree_year;
	private BigDecimal	r35_morethan_threeyear;
	private BigDecimal	r35_plusten_oneyear;
	private BigDecimal	r35_minusten_oneyear;
	private BigDecimal	r35_plusten_onetothreeyear;
	private BigDecimal	r35_minusten_onetothreeyear;
	private BigDecimal	r35_plusten_threeyear;
	private BigDecimal	r35_minusten_threeyear;
	private String	r36_currencies;
	private BigDecimal	r36_notational_amount;
	private BigDecimal	r36_gross_market;
	private BigDecimal	r36_lessthan_oneyear;
	private BigDecimal	r36_onetothree_year;
	private BigDecimal	r36_morethan_threeyear;
	private BigDecimal	r36_plusten_oneyear;
	private BigDecimal	r36_minusten_oneyear;
	private BigDecimal	r36_plusten_onetothreeyear;
	private BigDecimal	r36_minusten_onetothreeyear;
	private BigDecimal	r36_plusten_threeyear;
	private BigDecimal	r36_minusten_threeyear;
	private String	r37_currencies;
	private BigDecimal	r37_notational_amount;
	private BigDecimal	r37_gross_market;
	private BigDecimal	r37_lessthan_oneyear;
	private BigDecimal	r37_onetothree_year;
	private BigDecimal	r37_morethan_threeyear;
	private BigDecimal	r37_plusten_oneyear;
	private BigDecimal	r37_minusten_oneyear;
	private BigDecimal	r37_plusten_onetothreeyear;
	private BigDecimal	r37_minusten_onetothreeyear;
	private BigDecimal	r37_plusten_threeyear;
	private BigDecimal	r37_minusten_threeyear;
	private String	r38_currencies;
	private BigDecimal	r38_notational_amount;
	private BigDecimal	r38_gross_market;
	private BigDecimal	r38_lessthan_oneyear;
	private BigDecimal	r38_onetothree_year;
	private BigDecimal	r38_morethan_threeyear;
	private BigDecimal	r38_plusten_oneyear;
	private BigDecimal	r38_minusten_oneyear;
	private BigDecimal	r38_plusten_onetothreeyear;
	private BigDecimal	r38_minusten_onetothreeyear;
	private BigDecimal	r38_plusten_threeyear;
	private BigDecimal	r38_minusten_threeyear;
	private String	r39_currencies;
	private BigDecimal	r39_notational_amount;
	private BigDecimal	r39_gross_market;
	private BigDecimal	r39_lessthan_oneyear;
	private BigDecimal	r39_onetothree_year;
	private BigDecimal	r39_morethan_threeyear;
	private BigDecimal	r39_plusten_oneyear;
	private BigDecimal	r39_minusten_oneyear;
	private BigDecimal	r39_plusten_onetothreeyear;
	private BigDecimal	r39_minusten_onetothreeyear;
	private BigDecimal	r39_plusten_threeyear;
	private BigDecimal	r39_minusten_threeyear;
	private String	r40_currencies;
	private BigDecimal	r40_notational_amount;
	private BigDecimal	r40_gross_market;
	private BigDecimal	r40_lessthan_oneyear;
	private BigDecimal	r40_onetothree_year;
	private BigDecimal	r40_morethan_threeyear;
	private BigDecimal	r40_plusten_oneyear;
	private BigDecimal	r40_minusten_oneyear;
	private BigDecimal	r40_plusten_onetothreeyear;
	private BigDecimal	r40_minusten_onetothreeyear;
	private BigDecimal	r40_plusten_threeyear;
	private BigDecimal	r40_minusten_threeyear;
	private String	r41_currencies;
	private BigDecimal	r41_notational_amount;
	private BigDecimal	r41_gross_market;
	private BigDecimal	r41_lessthan_oneyear;
	private BigDecimal	r41_onetothree_year;
	private BigDecimal	r41_morethan_threeyear;
	private BigDecimal	r41_plusten_oneyear;
	private BigDecimal	r41_minusten_oneyear;
	private BigDecimal	r41_plusten_onetothreeyear;
	private BigDecimal	r41_minusten_onetothreeyear;
	private BigDecimal	r41_plusten_threeyear;
	private BigDecimal	r41_minusten_threeyear;
	private String	r42_currencies;
	private BigDecimal	r42_notational_amount;
	private BigDecimal	r42_gross_market;
	private BigDecimal	r42_lessthan_oneyear;
	private BigDecimal	r42_onetothree_year;
	private BigDecimal	r42_morethan_threeyear;
	private BigDecimal	r42_plusten_oneyear;
	private BigDecimal	r42_minusten_oneyear;
	private BigDecimal	r42_plusten_onetothreeyear;
	private BigDecimal	r42_minusten_onetothreeyear;
	private BigDecimal	r42_plusten_threeyear;
	private BigDecimal	r42_minusten_threeyear;
	private String	r43_currencies;
	private BigDecimal	r43_notational_amount;
	private BigDecimal	r43_gross_market;
	private BigDecimal	r43_lessthan_oneyear;
	private BigDecimal	r43_onetothree_year;
	private BigDecimal	r43_morethan_threeyear;
	private BigDecimal	r43_plusten_oneyear;
	private BigDecimal	r43_minusten_oneyear;
	private BigDecimal	r43_plusten_onetothreeyear;
	private BigDecimal	r43_minusten_onetothreeyear;
	private BigDecimal	r43_plusten_threeyear;
	private BigDecimal	r43_minusten_threeyear;
	private String	r44_currencies;
	private BigDecimal	r44_notational_amount;
	private BigDecimal	r44_gross_market;
	private BigDecimal	r44_lessthan_oneyear;
	private BigDecimal	r44_onetothree_year;
	private BigDecimal	r44_morethan_threeyear;
	private BigDecimal	r44_plusten_oneyear;
	private BigDecimal	r44_minusten_oneyear;
	private BigDecimal	r44_plusten_onetothreeyear;
	private BigDecimal	r44_minusten_onetothreeyear;
	private BigDecimal	r44_plusten_threeyear;
	private BigDecimal	r44_minusten_threeyear;
	private String	r45_currencies;
	private BigDecimal	r45_notational_amount;
	private BigDecimal	r45_gross_market;
	private BigDecimal	r45_lessthan_oneyear;
	private BigDecimal	r45_onetothree_year;
	private BigDecimal	r45_morethan_threeyear;
	private BigDecimal	r45_plusten_oneyear;
	private BigDecimal	r45_minusten_oneyear;
	private BigDecimal	r45_plusten_onetothreeyear;
	private BigDecimal	r45_minusten_onetothreeyear;
	private BigDecimal	r45_plusten_threeyear;
	private BigDecimal	r45_minusten_threeyear;
	private String	r46_currencies;
	private BigDecimal	r46_notational_amount;
	private BigDecimal	r46_gross_market;
	private BigDecimal	r46_lessthan_oneyear;
	private BigDecimal	r46_onetothree_year;
	private BigDecimal	r46_morethan_threeyear;
	private BigDecimal	r46_plusten_oneyear;
	private BigDecimal	r46_minusten_oneyear;
	private BigDecimal	r46_plusten_onetothreeyear;
	private BigDecimal	r46_minusten_onetothreeyear;
	private BigDecimal	r46_plusten_threeyear;
	private BigDecimal	r46_minusten_threeyear;
	private String	r47_currencies;
	private BigDecimal	r47_notational_amount;
	private BigDecimal	r47_gross_market;
	private BigDecimal	r47_lessthan_oneyear;
	private BigDecimal	r47_onetothree_year;
	private BigDecimal	r47_morethan_threeyear;
	private BigDecimal	r47_plusten_oneyear;
	private BigDecimal	r47_minusten_oneyear;
	private BigDecimal	r47_plusten_onetothreeyear;
	private BigDecimal	r47_minusten_onetothreeyear;
	private BigDecimal	r47_plusten_threeyear;
	private BigDecimal	r47_minusten_threeyear;
	private String	r48_currencies;
	private BigDecimal	r48_notational_amount;
	private BigDecimal	r48_gross_market;
	private BigDecimal	r48_lessthan_oneyear;
	private BigDecimal	r48_onetothree_year;
	private BigDecimal	r48_morethan_threeyear;
	private BigDecimal	r48_plusten_oneyear;
	private BigDecimal	r48_minusten_oneyear;
	private BigDecimal	r48_plusten_onetothreeyear;
	private BigDecimal	r48_minusten_onetothreeyear;
	private BigDecimal	r48_plusten_threeyear;
	private BigDecimal	r48_minusten_threeyear;
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
	public String getR1_currencies() {
		return r1_currencies;
	}
	public void setR1_currencies(String r1_currencies) {
		this.r1_currencies = r1_currencies;
	}
	public BigDecimal getR1_notational_amount() {
		return r1_notational_amount;
	}
	public void setR1_notational_amount(BigDecimal r1_notational_amount) {
		this.r1_notational_amount = r1_notational_amount;
	}
	public BigDecimal getR1_gross_market() {
		return r1_gross_market;
	}
	public void setR1_gross_market(BigDecimal r1_gross_market) {
		this.r1_gross_market = r1_gross_market;
	}
	public BigDecimal getR1_lessthan_oneyear() {
		return r1_lessthan_oneyear;
	}
	public void setR1_lessthan_oneyear(BigDecimal r1_lessthan_oneyear) {
		this.r1_lessthan_oneyear = r1_lessthan_oneyear;
	}
	public BigDecimal getR1_onetothree_year() {
		return r1_onetothree_year;
	}
	public void setR1_onetothree_year(BigDecimal r1_onetothree_year) {
		this.r1_onetothree_year = r1_onetothree_year;
	}
	public BigDecimal getR1_morethan_threeyear() {
		return r1_morethan_threeyear;
	}
	public void setR1_morethan_threeyear(BigDecimal r1_morethan_threeyear) {
		this.r1_morethan_threeyear = r1_morethan_threeyear;
	}
	public BigDecimal getR1_plusten_oneyear() {
		return r1_plusten_oneyear;
	}
	public void setR1_plusten_oneyear(BigDecimal r1_plusten_oneyear) {
		this.r1_plusten_oneyear = r1_plusten_oneyear;
	}
	public BigDecimal getR1_minusten_oneyear() {
		return r1_minusten_oneyear;
	}
	public void setR1_minusten_oneyear(BigDecimal r1_minusten_oneyear) {
		this.r1_minusten_oneyear = r1_minusten_oneyear;
	}
	public BigDecimal getR1_plusten_onetothreeyear() {
		return r1_plusten_onetothreeyear;
	}
	public void setR1_plusten_onetothreeyear(BigDecimal r1_plusten_onetothreeyear) {
		this.r1_plusten_onetothreeyear = r1_plusten_onetothreeyear;
	}
	public BigDecimal getR1_minusten_onetothreeyear() {
		return r1_minusten_onetothreeyear;
	}
	public void setR1_minusten_onetothreeyear(BigDecimal r1_minusten_onetothreeyear) {
		this.r1_minusten_onetothreeyear = r1_minusten_onetothreeyear;
	}
	public BigDecimal getR1_plusten_threeyear() {
		return r1_plusten_threeyear;
	}
	public void setR1_plusten_threeyear(BigDecimal r1_plusten_threeyear) {
		this.r1_plusten_threeyear = r1_plusten_threeyear;
	}
	public BigDecimal getR1_minusten_threeyear() {
		return r1_minusten_threeyear;
	}
	public void setR1_minusten_threeyear(BigDecimal r1_minusten_threeyear) {
		this.r1_minusten_threeyear = r1_minusten_threeyear;
	}
	public String getR2_currencies() {
		return r2_currencies;
	}
	public void setR2_currencies(String r2_currencies) {
		this.r2_currencies = r2_currencies;
	}
	public BigDecimal getR2_notational_amount() {
		return r2_notational_amount;
	}
	public void setR2_notational_amount(BigDecimal r2_notational_amount) {
		this.r2_notational_amount = r2_notational_amount;
	}
	public BigDecimal getR2_gross_market() {
		return r2_gross_market;
	}
	public void setR2_gross_market(BigDecimal r2_gross_market) {
		this.r2_gross_market = r2_gross_market;
	}
	public BigDecimal getR2_lessthan_oneyear() {
		return r2_lessthan_oneyear;
	}
	public void setR2_lessthan_oneyear(BigDecimal r2_lessthan_oneyear) {
		this.r2_lessthan_oneyear = r2_lessthan_oneyear;
	}
	public BigDecimal getR2_onetothree_year() {
		return r2_onetothree_year;
	}
	public void setR2_onetothree_year(BigDecimal r2_onetothree_year) {
		this.r2_onetothree_year = r2_onetothree_year;
	}
	public BigDecimal getR2_morethan_threeyear() {
		return r2_morethan_threeyear;
	}
	public void setR2_morethan_threeyear(BigDecimal r2_morethan_threeyear) {
		this.r2_morethan_threeyear = r2_morethan_threeyear;
	}
	public BigDecimal getR2_plusten_oneyear() {
		return r2_plusten_oneyear;
	}
	public void setR2_plusten_oneyear(BigDecimal r2_plusten_oneyear) {
		this.r2_plusten_oneyear = r2_plusten_oneyear;
	}
	public BigDecimal getR2_minusten_oneyear() {
		return r2_minusten_oneyear;
	}
	public void setR2_minusten_oneyear(BigDecimal r2_minusten_oneyear) {
		this.r2_minusten_oneyear = r2_minusten_oneyear;
	}
	public BigDecimal getR2_plusten_onetothreeyear() {
		return r2_plusten_onetothreeyear;
	}
	public void setR2_plusten_onetothreeyear(BigDecimal r2_plusten_onetothreeyear) {
		this.r2_plusten_onetothreeyear = r2_plusten_onetothreeyear;
	}
	public BigDecimal getR2_minusten_onetothreeyear() {
		return r2_minusten_onetothreeyear;
	}
	public void setR2_minusten_onetothreeyear(BigDecimal r2_minusten_onetothreeyear) {
		this.r2_minusten_onetothreeyear = r2_minusten_onetothreeyear;
	}
	public BigDecimal getR2_plusten_threeyear() {
		return r2_plusten_threeyear;
	}
	public void setR2_plusten_threeyear(BigDecimal r2_plusten_threeyear) {
		this.r2_plusten_threeyear = r2_plusten_threeyear;
	}
	public BigDecimal getR2_minusten_threeyear() {
		return r2_minusten_threeyear;
	}
	public void setR2_minusten_threeyear(BigDecimal r2_minusten_threeyear) {
		this.r2_minusten_threeyear = r2_minusten_threeyear;
	}
	public String getR3_currencies() {
		return r3_currencies;
	}
	public void setR3_currencies(String r3_currencies) {
		this.r3_currencies = r3_currencies;
	}
	public BigDecimal getR3_notational_amount() {
		return r3_notational_amount;
	}
	public void setR3_notational_amount(BigDecimal r3_notational_amount) {
		this.r3_notational_amount = r3_notational_amount;
	}
	public BigDecimal getR3_gross_market() {
		return r3_gross_market;
	}
	public void setR3_gross_market(BigDecimal r3_gross_market) {
		this.r3_gross_market = r3_gross_market;
	}
	public BigDecimal getR3_lessthan_oneyear() {
		return r3_lessthan_oneyear;
	}
	public void setR3_lessthan_oneyear(BigDecimal r3_lessthan_oneyear) {
		this.r3_lessthan_oneyear = r3_lessthan_oneyear;
	}
	public BigDecimal getR3_onetothree_year() {
		return r3_onetothree_year;
	}
	public void setR3_onetothree_year(BigDecimal r3_onetothree_year) {
		this.r3_onetothree_year = r3_onetothree_year;
	}
	public BigDecimal getR3_morethan_threeyear() {
		return r3_morethan_threeyear;
	}
	public void setR3_morethan_threeyear(BigDecimal r3_morethan_threeyear) {
		this.r3_morethan_threeyear = r3_morethan_threeyear;
	}
	public BigDecimal getR3_plusten_oneyear() {
		return r3_plusten_oneyear;
	}
	public void setR3_plusten_oneyear(BigDecimal r3_plusten_oneyear) {
		this.r3_plusten_oneyear = r3_plusten_oneyear;
	}
	public BigDecimal getR3_minusten_oneyear() {
		return r3_minusten_oneyear;
	}
	public void setR3_minusten_oneyear(BigDecimal r3_minusten_oneyear) {
		this.r3_minusten_oneyear = r3_minusten_oneyear;
	}
	public BigDecimal getR3_plusten_onetothreeyear() {
		return r3_plusten_onetothreeyear;
	}
	public void setR3_plusten_onetothreeyear(BigDecimal r3_plusten_onetothreeyear) {
		this.r3_plusten_onetothreeyear = r3_plusten_onetothreeyear;
	}
	public BigDecimal getR3_minusten_onetothreeyear() {
		return r3_minusten_onetothreeyear;
	}
	public void setR3_minusten_onetothreeyear(BigDecimal r3_minusten_onetothreeyear) {
		this.r3_minusten_onetothreeyear = r3_minusten_onetothreeyear;
	}
	public BigDecimal getR3_plusten_threeyear() {
		return r3_plusten_threeyear;
	}
	public void setR3_plusten_threeyear(BigDecimal r3_plusten_threeyear) {
		this.r3_plusten_threeyear = r3_plusten_threeyear;
	}
	public BigDecimal getR3_minusten_threeyear() {
		return r3_minusten_threeyear;
	}
	public void setR3_minusten_threeyear(BigDecimal r3_minusten_threeyear) {
		this.r3_minusten_threeyear = r3_minusten_threeyear;
	}
	public String getR4_currencies() {
		return r4_currencies;
	}
	public void setR4_currencies(String r4_currencies) {
		this.r4_currencies = r4_currencies;
	}
	public BigDecimal getR4_notational_amount() {
		return r4_notational_amount;
	}
	public void setR4_notational_amount(BigDecimal r4_notational_amount) {
		this.r4_notational_amount = r4_notational_amount;
	}
	public BigDecimal getR4_gross_market() {
		return r4_gross_market;
	}
	public void setR4_gross_market(BigDecimal r4_gross_market) {
		this.r4_gross_market = r4_gross_market;
	}
	public BigDecimal getR4_lessthan_oneyear() {
		return r4_lessthan_oneyear;
	}
	public void setR4_lessthan_oneyear(BigDecimal r4_lessthan_oneyear) {
		this.r4_lessthan_oneyear = r4_lessthan_oneyear;
	}
	public BigDecimal getR4_onetothree_year() {
		return r4_onetothree_year;
	}
	public void setR4_onetothree_year(BigDecimal r4_onetothree_year) {
		this.r4_onetothree_year = r4_onetothree_year;
	}
	public BigDecimal getR4_morethan_threeyear() {
		return r4_morethan_threeyear;
	}
	public void setR4_morethan_threeyear(BigDecimal r4_morethan_threeyear) {
		this.r4_morethan_threeyear = r4_morethan_threeyear;
	}
	public BigDecimal getR4_plusten_oneyear() {
		return r4_plusten_oneyear;
	}
	public void setR4_plusten_oneyear(BigDecimal r4_plusten_oneyear) {
		this.r4_plusten_oneyear = r4_plusten_oneyear;
	}
	public BigDecimal getR4_minusten_oneyear() {
		return r4_minusten_oneyear;
	}
	public void setR4_minusten_oneyear(BigDecimal r4_minusten_oneyear) {
		this.r4_minusten_oneyear = r4_minusten_oneyear;
	}
	public BigDecimal getR4_plusten_onetothreeyear() {
		return r4_plusten_onetothreeyear;
	}
	public void setR4_plusten_onetothreeyear(BigDecimal r4_plusten_onetothreeyear) {
		this.r4_plusten_onetothreeyear = r4_plusten_onetothreeyear;
	}
	public BigDecimal getR4_minusten_onetothreeyear() {
		return r4_minusten_onetothreeyear;
	}
	public void setR4_minusten_onetothreeyear(BigDecimal r4_minusten_onetothreeyear) {
		this.r4_minusten_onetothreeyear = r4_minusten_onetothreeyear;
	}
	public BigDecimal getR4_plusten_threeyear() {
		return r4_plusten_threeyear;
	}
	public void setR4_plusten_threeyear(BigDecimal r4_plusten_threeyear) {
		this.r4_plusten_threeyear = r4_plusten_threeyear;
	}
	public BigDecimal getR4_minusten_threeyear() {
		return r4_minusten_threeyear;
	}
	public void setR4_minusten_threeyear(BigDecimal r4_minusten_threeyear) {
		this.r4_minusten_threeyear = r4_minusten_threeyear;
	}
	public String getR5_currencies() {
		return r5_currencies;
	}
	public void setR5_currencies(String r5_currencies) {
		this.r5_currencies = r5_currencies;
	}
	public BigDecimal getR5_notational_amount() {
		return r5_notational_amount;
	}
	public void setR5_notational_amount(BigDecimal r5_notational_amount) {
		this.r5_notational_amount = r5_notational_amount;
	}
	public BigDecimal getR5_gross_market() {
		return r5_gross_market;
	}
	public void setR5_gross_market(BigDecimal r5_gross_market) {
		this.r5_gross_market = r5_gross_market;
	}
	public BigDecimal getR5_lessthan_oneyear() {
		return r5_lessthan_oneyear;
	}
	public void setR5_lessthan_oneyear(BigDecimal r5_lessthan_oneyear) {
		this.r5_lessthan_oneyear = r5_lessthan_oneyear;
	}
	public BigDecimal getR5_onetothree_year() {
		return r5_onetothree_year;
	}
	public void setR5_onetothree_year(BigDecimal r5_onetothree_year) {
		this.r5_onetothree_year = r5_onetothree_year;
	}
	public BigDecimal getR5_morethan_threeyear() {
		return r5_morethan_threeyear;
	}
	public void setR5_morethan_threeyear(BigDecimal r5_morethan_threeyear) {
		this.r5_morethan_threeyear = r5_morethan_threeyear;
	}
	public BigDecimal getR5_plusten_oneyear() {
		return r5_plusten_oneyear;
	}
	public void setR5_plusten_oneyear(BigDecimal r5_plusten_oneyear) {
		this.r5_plusten_oneyear = r5_plusten_oneyear;
	}
	public BigDecimal getR5_minusten_oneyear() {
		return r5_minusten_oneyear;
	}
	public void setR5_minusten_oneyear(BigDecimal r5_minusten_oneyear) {
		this.r5_minusten_oneyear = r5_minusten_oneyear;
	}
	public BigDecimal getR5_plusten_onetothreeyear() {
		return r5_plusten_onetothreeyear;
	}
	public void setR5_plusten_onetothreeyear(BigDecimal r5_plusten_onetothreeyear) {
		this.r5_plusten_onetothreeyear = r5_plusten_onetothreeyear;
	}
	public BigDecimal getR5_minusten_onetothreeyear() {
		return r5_minusten_onetothreeyear;
	}
	public void setR5_minusten_onetothreeyear(BigDecimal r5_minusten_onetothreeyear) {
		this.r5_minusten_onetothreeyear = r5_minusten_onetothreeyear;
	}
	public BigDecimal getR5_plusten_threeyear() {
		return r5_plusten_threeyear;
	}
	public void setR5_plusten_threeyear(BigDecimal r5_plusten_threeyear) {
		this.r5_plusten_threeyear = r5_plusten_threeyear;
	}
	public BigDecimal getR5_minusten_threeyear() {
		return r5_minusten_threeyear;
	}
	public void setR5_minusten_threeyear(BigDecimal r5_minusten_threeyear) {
		this.r5_minusten_threeyear = r5_minusten_threeyear;
	}
	public String getR6_currencies() {
		return r6_currencies;
	}
	public void setR6_currencies(String r6_currencies) {
		this.r6_currencies = r6_currencies;
	}
	public BigDecimal getR6_notational_amount() {
		return r6_notational_amount;
	}
	public void setR6_notational_amount(BigDecimal r6_notational_amount) {
		this.r6_notational_amount = r6_notational_amount;
	}
	public BigDecimal getR6_gross_market() {
		return r6_gross_market;
	}
	public void setR6_gross_market(BigDecimal r6_gross_market) {
		this.r6_gross_market = r6_gross_market;
	}
	public BigDecimal getR6_lessthan_oneyear() {
		return r6_lessthan_oneyear;
	}
	public void setR6_lessthan_oneyear(BigDecimal r6_lessthan_oneyear) {
		this.r6_lessthan_oneyear = r6_lessthan_oneyear;
	}
	public BigDecimal getR6_onetothree_year() {
		return r6_onetothree_year;
	}
	public void setR6_onetothree_year(BigDecimal r6_onetothree_year) {
		this.r6_onetothree_year = r6_onetothree_year;
	}
	public BigDecimal getR6_morethan_threeyear() {
		return r6_morethan_threeyear;
	}
	public void setR6_morethan_threeyear(BigDecimal r6_morethan_threeyear) {
		this.r6_morethan_threeyear = r6_morethan_threeyear;
	}
	public BigDecimal getR6_plusten_oneyear() {
		return r6_plusten_oneyear;
	}
	public void setR6_plusten_oneyear(BigDecimal r6_plusten_oneyear) {
		this.r6_plusten_oneyear = r6_plusten_oneyear;
	}
	public BigDecimal getR6_minusten_oneyear() {
		return r6_minusten_oneyear;
	}
	public void setR6_minusten_oneyear(BigDecimal r6_minusten_oneyear) {
		this.r6_minusten_oneyear = r6_minusten_oneyear;
	}
	public BigDecimal getR6_plusten_onetothreeyear() {
		return r6_plusten_onetothreeyear;
	}
	public void setR6_plusten_onetothreeyear(BigDecimal r6_plusten_onetothreeyear) {
		this.r6_plusten_onetothreeyear = r6_plusten_onetothreeyear;
	}
	public BigDecimal getR6_minusten_onetothreeyear() {
		return r6_minusten_onetothreeyear;
	}
	public void setR6_minusten_onetothreeyear(BigDecimal r6_minusten_onetothreeyear) {
		this.r6_minusten_onetothreeyear = r6_minusten_onetothreeyear;
	}
	public BigDecimal getR6_plusten_threeyear() {
		return r6_plusten_threeyear;
	}
	public void setR6_plusten_threeyear(BigDecimal r6_plusten_threeyear) {
		this.r6_plusten_threeyear = r6_plusten_threeyear;
	}
	public BigDecimal getR6_minusten_threeyear() {
		return r6_minusten_threeyear;
	}
	public void setR6_minusten_threeyear(BigDecimal r6_minusten_threeyear) {
		this.r6_minusten_threeyear = r6_minusten_threeyear;
	}
	public String getR7_currencies() {
		return r7_currencies;
	}
	public void setR7_currencies(String r7_currencies) {
		this.r7_currencies = r7_currencies;
	}
	public BigDecimal getR7_notational_amount() {
		return r7_notational_amount;
	}
	public void setR7_notational_amount(BigDecimal r7_notational_amount) {
		this.r7_notational_amount = r7_notational_amount;
	}
	public BigDecimal getR7_gross_market() {
		return r7_gross_market;
	}
	public void setR7_gross_market(BigDecimal r7_gross_market) {
		this.r7_gross_market = r7_gross_market;
	}
	public BigDecimal getR7_lessthan_oneyear() {
		return r7_lessthan_oneyear;
	}
	public void setR7_lessthan_oneyear(BigDecimal r7_lessthan_oneyear) {
		this.r7_lessthan_oneyear = r7_lessthan_oneyear;
	}
	public BigDecimal getR7_onetothree_year() {
		return r7_onetothree_year;
	}
	public void setR7_onetothree_year(BigDecimal r7_onetothree_year) {
		this.r7_onetothree_year = r7_onetothree_year;
	}
	public BigDecimal getR7_morethan_threeyear() {
		return r7_morethan_threeyear;
	}
	public void setR7_morethan_threeyear(BigDecimal r7_morethan_threeyear) {
		this.r7_morethan_threeyear = r7_morethan_threeyear;
	}
	public BigDecimal getR7_plusten_oneyear() {
		return r7_plusten_oneyear;
	}
	public void setR7_plusten_oneyear(BigDecimal r7_plusten_oneyear) {
		this.r7_plusten_oneyear = r7_plusten_oneyear;
	}
	public BigDecimal getR7_minusten_oneyear() {
		return r7_minusten_oneyear;
	}
	public void setR7_minusten_oneyear(BigDecimal r7_minusten_oneyear) {
		this.r7_minusten_oneyear = r7_minusten_oneyear;
	}
	public BigDecimal getR7_plusten_onetothreeyear() {
		return r7_plusten_onetothreeyear;
	}
	public void setR7_plusten_onetothreeyear(BigDecimal r7_plusten_onetothreeyear) {
		this.r7_plusten_onetothreeyear = r7_plusten_onetothreeyear;
	}
	public BigDecimal getR7_minusten_onetothreeyear() {
		return r7_minusten_onetothreeyear;
	}
	public void setR7_minusten_onetothreeyear(BigDecimal r7_minusten_onetothreeyear) {
		this.r7_minusten_onetothreeyear = r7_minusten_onetothreeyear;
	}
	public BigDecimal getR7_plusten_threeyear() {
		return r7_plusten_threeyear;
	}
	public void setR7_plusten_threeyear(BigDecimal r7_plusten_threeyear) {
		this.r7_plusten_threeyear = r7_plusten_threeyear;
	}
	public BigDecimal getR7_minusten_threeyear() {
		return r7_minusten_threeyear;
	}
	public void setR7_minusten_threeyear(BigDecimal r7_minusten_threeyear) {
		this.r7_minusten_threeyear = r7_minusten_threeyear;
	}
	public String getR8_currencies() {
		return r8_currencies;
	}
	public void setR8_currencies(String r8_currencies) {
		this.r8_currencies = r8_currencies;
	}
	public BigDecimal getR8_notational_amount() {
		return r8_notational_amount;
	}
	public void setR8_notational_amount(BigDecimal r8_notational_amount) {
		this.r8_notational_amount = r8_notational_amount;
	}
	public BigDecimal getR8_gross_market() {
		return r8_gross_market;
	}
	public void setR8_gross_market(BigDecimal r8_gross_market) {
		this.r8_gross_market = r8_gross_market;
	}
	public BigDecimal getR8_lessthan_oneyear() {
		return r8_lessthan_oneyear;
	}
	public void setR8_lessthan_oneyear(BigDecimal r8_lessthan_oneyear) {
		this.r8_lessthan_oneyear = r8_lessthan_oneyear;
	}
	public BigDecimal getR8_onetothree_year() {
		return r8_onetothree_year;
	}
	public void setR8_onetothree_year(BigDecimal r8_onetothree_year) {
		this.r8_onetothree_year = r8_onetothree_year;
	}
	public BigDecimal getR8_morethan_threeyear() {
		return r8_morethan_threeyear;
	}
	public void setR8_morethan_threeyear(BigDecimal r8_morethan_threeyear) {
		this.r8_morethan_threeyear = r8_morethan_threeyear;
	}
	public BigDecimal getR8_plusten_oneyear() {
		return r8_plusten_oneyear;
	}
	public void setR8_plusten_oneyear(BigDecimal r8_plusten_oneyear) {
		this.r8_plusten_oneyear = r8_plusten_oneyear;
	}
	public BigDecimal getR8_minusten_oneyear() {
		return r8_minusten_oneyear;
	}
	public void setR8_minusten_oneyear(BigDecimal r8_minusten_oneyear) {
		this.r8_minusten_oneyear = r8_minusten_oneyear;
	}
	public BigDecimal getR8_plusten_onetothreeyear() {
		return r8_plusten_onetothreeyear;
	}
	public void setR8_plusten_onetothreeyear(BigDecimal r8_plusten_onetothreeyear) {
		this.r8_plusten_onetothreeyear = r8_plusten_onetothreeyear;
	}
	public BigDecimal getR8_minusten_onetothreeyear() {
		return r8_minusten_onetothreeyear;
	}
	public void setR8_minusten_onetothreeyear(BigDecimal r8_minusten_onetothreeyear) {
		this.r8_minusten_onetothreeyear = r8_minusten_onetothreeyear;
	}
	public BigDecimal getR8_plusten_threeyear() {
		return r8_plusten_threeyear;
	}
	public void setR8_plusten_threeyear(BigDecimal r8_plusten_threeyear) {
		this.r8_plusten_threeyear = r8_plusten_threeyear;
	}
	public BigDecimal getR8_minusten_threeyear() {
		return r8_minusten_threeyear;
	}
	public void setR8_minusten_threeyear(BigDecimal r8_minusten_threeyear) {
		this.r8_minusten_threeyear = r8_minusten_threeyear;
	}
	public String getR9_currencies() {
		return r9_currencies;
	}
	public void setR9_currencies(String r9_currencies) {
		this.r9_currencies = r9_currencies;
	}
	public BigDecimal getR9_notational_amount() {
		return r9_notational_amount;
	}
	public void setR9_notational_amount(BigDecimal r9_notational_amount) {
		this.r9_notational_amount = r9_notational_amount;
	}
	public BigDecimal getR9_gross_market() {
		return r9_gross_market;
	}
	public void setR9_gross_market(BigDecimal r9_gross_market) {
		this.r9_gross_market = r9_gross_market;
	}
	public BigDecimal getR9_lessthan_oneyear() {
		return r9_lessthan_oneyear;
	}
	public void setR9_lessthan_oneyear(BigDecimal r9_lessthan_oneyear) {
		this.r9_lessthan_oneyear = r9_lessthan_oneyear;
	}
	public BigDecimal getR9_onetothree_year() {
		return r9_onetothree_year;
	}
	public void setR9_onetothree_year(BigDecimal r9_onetothree_year) {
		this.r9_onetothree_year = r9_onetothree_year;
	}
	public BigDecimal getR9_morethan_threeyear() {
		return r9_morethan_threeyear;
	}
	public void setR9_morethan_threeyear(BigDecimal r9_morethan_threeyear) {
		this.r9_morethan_threeyear = r9_morethan_threeyear;
	}
	public BigDecimal getR9_plusten_oneyear() {
		return r9_plusten_oneyear;
	}
	public void setR9_plusten_oneyear(BigDecimal r9_plusten_oneyear) {
		this.r9_plusten_oneyear = r9_plusten_oneyear;
	}
	public BigDecimal getR9_minusten_oneyear() {
		return r9_minusten_oneyear;
	}
	public void setR9_minusten_oneyear(BigDecimal r9_minusten_oneyear) {
		this.r9_minusten_oneyear = r9_minusten_oneyear;
	}
	public BigDecimal getR9_plusten_onetothreeyear() {
		return r9_plusten_onetothreeyear;
	}
	public void setR9_plusten_onetothreeyear(BigDecimal r9_plusten_onetothreeyear) {
		this.r9_plusten_onetothreeyear = r9_plusten_onetothreeyear;
	}
	public BigDecimal getR9_minusten_onetothreeyear() {
		return r9_minusten_onetothreeyear;
	}
	public void setR9_minusten_onetothreeyear(BigDecimal r9_minusten_onetothreeyear) {
		this.r9_minusten_onetothreeyear = r9_minusten_onetothreeyear;
	}
	public BigDecimal getR9_plusten_threeyear() {
		return r9_plusten_threeyear;
	}
	public void setR9_plusten_threeyear(BigDecimal r9_plusten_threeyear) {
		this.r9_plusten_threeyear = r9_plusten_threeyear;
	}
	public BigDecimal getR9_minusten_threeyear() {
		return r9_minusten_threeyear;
	}
	public void setR9_minusten_threeyear(BigDecimal r9_minusten_threeyear) {
		this.r9_minusten_threeyear = r9_minusten_threeyear;
	}
	public String getR10_currencies() {
		return r10_currencies;
	}
	public void setR10_currencies(String r10_currencies) {
		this.r10_currencies = r10_currencies;
	}
	public BigDecimal getR10_notational_amount() {
		return r10_notational_amount;
	}
	public void setR10_notational_amount(BigDecimal r10_notational_amount) {
		this.r10_notational_amount = r10_notational_amount;
	}
	public BigDecimal getR10_gross_market() {
		return r10_gross_market;
	}
	public void setR10_gross_market(BigDecimal r10_gross_market) {
		this.r10_gross_market = r10_gross_market;
	}
	public BigDecimal getR10_lessthan_oneyear() {
		return r10_lessthan_oneyear;
	}
	public void setR10_lessthan_oneyear(BigDecimal r10_lessthan_oneyear) {
		this.r10_lessthan_oneyear = r10_lessthan_oneyear;
	}
	public BigDecimal getR10_onetothree_year() {
		return r10_onetothree_year;
	}
	public void setR10_onetothree_year(BigDecimal r10_onetothree_year) {
		this.r10_onetothree_year = r10_onetothree_year;
	}
	public BigDecimal getR10_morethan_threeyear() {
		return r10_morethan_threeyear;
	}
	public void setR10_morethan_threeyear(BigDecimal r10_morethan_threeyear) {
		this.r10_morethan_threeyear = r10_morethan_threeyear;
	}
	public BigDecimal getR10_plusten_oneyear() {
		return r10_plusten_oneyear;
	}
	public void setR10_plusten_oneyear(BigDecimal r10_plusten_oneyear) {
		this.r10_plusten_oneyear = r10_plusten_oneyear;
	}
	public BigDecimal getR10_minusten_oneyear() {
		return r10_minusten_oneyear;
	}
	public void setR10_minusten_oneyear(BigDecimal r10_minusten_oneyear) {
		this.r10_minusten_oneyear = r10_minusten_oneyear;
	}
	public BigDecimal getR10_plusten_onetothreeyear() {
		return r10_plusten_onetothreeyear;
	}
	public void setR10_plusten_onetothreeyear(BigDecimal r10_plusten_onetothreeyear) {
		this.r10_plusten_onetothreeyear = r10_plusten_onetothreeyear;
	}
	public BigDecimal getR10_minusten_onetothreeyear() {
		return r10_minusten_onetothreeyear;
	}
	public void setR10_minusten_onetothreeyear(BigDecimal r10_minusten_onetothreeyear) {
		this.r10_minusten_onetothreeyear = r10_minusten_onetothreeyear;
	}
	public BigDecimal getR10_plusten_threeyear() {
		return r10_plusten_threeyear;
	}
	public void setR10_plusten_threeyear(BigDecimal r10_plusten_threeyear) {
		this.r10_plusten_threeyear = r10_plusten_threeyear;
	}
	public BigDecimal getR10_minusten_threeyear() {
		return r10_minusten_threeyear;
	}
	public void setR10_minusten_threeyear(BigDecimal r10_minusten_threeyear) {
		this.r10_minusten_threeyear = r10_minusten_threeyear;
	}
	public String getR11_currencies() {
		return r11_currencies;
	}
	public void setR11_currencies(String r11_currencies) {
		this.r11_currencies = r11_currencies;
	}
	public BigDecimal getR11_notational_amount() {
		return r11_notational_amount;
	}
	public void setR11_notational_amount(BigDecimal r11_notational_amount) {
		this.r11_notational_amount = r11_notational_amount;
	}
	public BigDecimal getR11_gross_market() {
		return r11_gross_market;
	}
	public void setR11_gross_market(BigDecimal r11_gross_market) {
		this.r11_gross_market = r11_gross_market;
	}
	public BigDecimal getR11_lessthan_oneyear() {
		return r11_lessthan_oneyear;
	}
	public void setR11_lessthan_oneyear(BigDecimal r11_lessthan_oneyear) {
		this.r11_lessthan_oneyear = r11_lessthan_oneyear;
	}
	public BigDecimal getR11_onetothree_year() {
		return r11_onetothree_year;
	}
	public void setR11_onetothree_year(BigDecimal r11_onetothree_year) {
		this.r11_onetothree_year = r11_onetothree_year;
	}
	public BigDecimal getR11_morethan_threeyear() {
		return r11_morethan_threeyear;
	}
	public void setR11_morethan_threeyear(BigDecimal r11_morethan_threeyear) {
		this.r11_morethan_threeyear = r11_morethan_threeyear;
	}
	public BigDecimal getR11_plusten_oneyear() {
		return r11_plusten_oneyear;
	}
	public void setR11_plusten_oneyear(BigDecimal r11_plusten_oneyear) {
		this.r11_plusten_oneyear = r11_plusten_oneyear;
	}
	public BigDecimal getR11_minusten_oneyear() {
		return r11_minusten_oneyear;
	}
	public void setR11_minusten_oneyear(BigDecimal r11_minusten_oneyear) {
		this.r11_minusten_oneyear = r11_minusten_oneyear;
	}
	public BigDecimal getR11_plusten_onetothreeyear() {
		return r11_plusten_onetothreeyear;
	}
	public void setR11_plusten_onetothreeyear(BigDecimal r11_plusten_onetothreeyear) {
		this.r11_plusten_onetothreeyear = r11_plusten_onetothreeyear;
	}
	public BigDecimal getR11_minusten_onetothreeyear() {
		return r11_minusten_onetothreeyear;
	}
	public void setR11_minusten_onetothreeyear(BigDecimal r11_minusten_onetothreeyear) {
		this.r11_minusten_onetothreeyear = r11_minusten_onetothreeyear;
	}
	public BigDecimal getR11_plusten_threeyear() {
		return r11_plusten_threeyear;
	}
	public void setR11_plusten_threeyear(BigDecimal r11_plusten_threeyear) {
		this.r11_plusten_threeyear = r11_plusten_threeyear;
	}
	public BigDecimal getR11_minusten_threeyear() {
		return r11_minusten_threeyear;
	}
	public void setR11_minusten_threeyear(BigDecimal r11_minusten_threeyear) {
		this.r11_minusten_threeyear = r11_minusten_threeyear;
	}
	public String getR12_currencies() {
		return r12_currencies;
	}
	public void setR12_currencies(String r12_currencies) {
		this.r12_currencies = r12_currencies;
	}
	public BigDecimal getR12_notational_amount() {
		return r12_notational_amount;
	}
	public void setR12_notational_amount(BigDecimal r12_notational_amount) {
		this.r12_notational_amount = r12_notational_amount;
	}
	public BigDecimal getR12_gross_market() {
		return r12_gross_market;
	}
	public void setR12_gross_market(BigDecimal r12_gross_market) {
		this.r12_gross_market = r12_gross_market;
	}
	public BigDecimal getR12_lessthan_oneyear() {
		return r12_lessthan_oneyear;
	}
	public void setR12_lessthan_oneyear(BigDecimal r12_lessthan_oneyear) {
		this.r12_lessthan_oneyear = r12_lessthan_oneyear;
	}
	public BigDecimal getR12_onetothree_year() {
		return r12_onetothree_year;
	}
	public void setR12_onetothree_year(BigDecimal r12_onetothree_year) {
		this.r12_onetothree_year = r12_onetothree_year;
	}
	public BigDecimal getR12_morethan_threeyear() {
		return r12_morethan_threeyear;
	}
	public void setR12_morethan_threeyear(BigDecimal r12_morethan_threeyear) {
		this.r12_morethan_threeyear = r12_morethan_threeyear;
	}
	public BigDecimal getR12_plusten_oneyear() {
		return r12_plusten_oneyear;
	}
	public void setR12_plusten_oneyear(BigDecimal r12_plusten_oneyear) {
		this.r12_plusten_oneyear = r12_plusten_oneyear;
	}
	public BigDecimal getR12_minusten_oneyear() {
		return r12_minusten_oneyear;
	}
	public void setR12_minusten_oneyear(BigDecimal r12_minusten_oneyear) {
		this.r12_minusten_oneyear = r12_minusten_oneyear;
	}
	public BigDecimal getR12_plusten_onetothreeyear() {
		return r12_plusten_onetothreeyear;
	}
	public void setR12_plusten_onetothreeyear(BigDecimal r12_plusten_onetothreeyear) {
		this.r12_plusten_onetothreeyear = r12_plusten_onetothreeyear;
	}
	public BigDecimal getR12_minusten_onetothreeyear() {
		return r12_minusten_onetothreeyear;
	}
	public void setR12_minusten_onetothreeyear(BigDecimal r12_minusten_onetothreeyear) {
		this.r12_minusten_onetothreeyear = r12_minusten_onetothreeyear;
	}
	public BigDecimal getR12_plusten_threeyear() {
		return r12_plusten_threeyear;
	}
	public void setR12_plusten_threeyear(BigDecimal r12_plusten_threeyear) {
		this.r12_plusten_threeyear = r12_plusten_threeyear;
	}
	public BigDecimal getR12_minusten_threeyear() {
		return r12_minusten_threeyear;
	}
	public void setR12_minusten_threeyear(BigDecimal r12_minusten_threeyear) {
		this.r12_minusten_threeyear = r12_minusten_threeyear;
	}
	public String getR13_currencies() {
		return r13_currencies;
	}
	public void setR13_currencies(String r13_currencies) {
		this.r13_currencies = r13_currencies;
	}
	public BigDecimal getR13_notational_amount() {
		return r13_notational_amount;
	}
	public void setR13_notational_amount(BigDecimal r13_notational_amount) {
		this.r13_notational_amount = r13_notational_amount;
	}
	public BigDecimal getR13_gross_market() {
		return r13_gross_market;
	}
	public void setR13_gross_market(BigDecimal r13_gross_market) {
		this.r13_gross_market = r13_gross_market;
	}
	public BigDecimal getR13_lessthan_oneyear() {
		return r13_lessthan_oneyear;
	}
	public void setR13_lessthan_oneyear(BigDecimal r13_lessthan_oneyear) {
		this.r13_lessthan_oneyear = r13_lessthan_oneyear;
	}
	public BigDecimal getR13_onetothree_year() {
		return r13_onetothree_year;
	}
	public void setR13_onetothree_year(BigDecimal r13_onetothree_year) {
		this.r13_onetothree_year = r13_onetothree_year;
	}
	public BigDecimal getR13_morethan_threeyear() {
		return r13_morethan_threeyear;
	}
	public void setR13_morethan_threeyear(BigDecimal r13_morethan_threeyear) {
		this.r13_morethan_threeyear = r13_morethan_threeyear;
	}
	public BigDecimal getR13_plusten_oneyear() {
		return r13_plusten_oneyear;
	}
	public void setR13_plusten_oneyear(BigDecimal r13_plusten_oneyear) {
		this.r13_plusten_oneyear = r13_plusten_oneyear;
	}
	public BigDecimal getR13_minusten_oneyear() {
		return r13_minusten_oneyear;
	}
	public void setR13_minusten_oneyear(BigDecimal r13_minusten_oneyear) {
		this.r13_minusten_oneyear = r13_minusten_oneyear;
	}
	public BigDecimal getR13_plusten_onetothreeyear() {
		return r13_plusten_onetothreeyear;
	}
	public void setR13_plusten_onetothreeyear(BigDecimal r13_plusten_onetothreeyear) {
		this.r13_plusten_onetothreeyear = r13_plusten_onetothreeyear;
	}
	public BigDecimal getR13_minusten_onetothreeyear() {
		return r13_minusten_onetothreeyear;
	}
	public void setR13_minusten_onetothreeyear(BigDecimal r13_minusten_onetothreeyear) {
		this.r13_minusten_onetothreeyear = r13_minusten_onetothreeyear;
	}
	public BigDecimal getR13_plusten_threeyear() {
		return r13_plusten_threeyear;
	}
	public void setR13_plusten_threeyear(BigDecimal r13_plusten_threeyear) {
		this.r13_plusten_threeyear = r13_plusten_threeyear;
	}
	public BigDecimal getR13_minusten_threeyear() {
		return r13_minusten_threeyear;
	}
	public void setR13_minusten_threeyear(BigDecimal r13_minusten_threeyear) {
		this.r13_minusten_threeyear = r13_minusten_threeyear;
	}
	public String getR14_currencies() {
		return r14_currencies;
	}
	public void setR14_currencies(String r14_currencies) {
		this.r14_currencies = r14_currencies;
	}
	public BigDecimal getR14_notational_amount() {
		return r14_notational_amount;
	}
	public void setR14_notational_amount(BigDecimal r14_notational_amount) {
		this.r14_notational_amount = r14_notational_amount;
	}
	public BigDecimal getR14_gross_market() {
		return r14_gross_market;
	}
	public void setR14_gross_market(BigDecimal r14_gross_market) {
		this.r14_gross_market = r14_gross_market;
	}
	public BigDecimal getR14_lessthan_oneyear() {
		return r14_lessthan_oneyear;
	}
	public void setR14_lessthan_oneyear(BigDecimal r14_lessthan_oneyear) {
		this.r14_lessthan_oneyear = r14_lessthan_oneyear;
	}
	public BigDecimal getR14_onetothree_year() {
		return r14_onetothree_year;
	}
	public void setR14_onetothree_year(BigDecimal r14_onetothree_year) {
		this.r14_onetothree_year = r14_onetothree_year;
	}
	public BigDecimal getR14_morethan_threeyear() {
		return r14_morethan_threeyear;
	}
	public void setR14_morethan_threeyear(BigDecimal r14_morethan_threeyear) {
		this.r14_morethan_threeyear = r14_morethan_threeyear;
	}
	public BigDecimal getR14_plusten_oneyear() {
		return r14_plusten_oneyear;
	}
	public void setR14_plusten_oneyear(BigDecimal r14_plusten_oneyear) {
		this.r14_plusten_oneyear = r14_plusten_oneyear;
	}
	public BigDecimal getR14_minusten_oneyear() {
		return r14_minusten_oneyear;
	}
	public void setR14_minusten_oneyear(BigDecimal r14_minusten_oneyear) {
		this.r14_minusten_oneyear = r14_minusten_oneyear;
	}
	public BigDecimal getR14_plusten_onetothreeyear() {
		return r14_plusten_onetothreeyear;
	}
	public void setR14_plusten_onetothreeyear(BigDecimal r14_plusten_onetothreeyear) {
		this.r14_plusten_onetothreeyear = r14_plusten_onetothreeyear;
	}
	public BigDecimal getR14_minusten_onetothreeyear() {
		return r14_minusten_onetothreeyear;
	}
	public void setR14_minusten_onetothreeyear(BigDecimal r14_minusten_onetothreeyear) {
		this.r14_minusten_onetothreeyear = r14_minusten_onetothreeyear;
	}
	public BigDecimal getR14_plusten_threeyear() {
		return r14_plusten_threeyear;
	}
	public void setR14_plusten_threeyear(BigDecimal r14_plusten_threeyear) {
		this.r14_plusten_threeyear = r14_plusten_threeyear;
	}
	public BigDecimal getR14_minusten_threeyear() {
		return r14_minusten_threeyear;
	}
	public void setR14_minusten_threeyear(BigDecimal r14_minusten_threeyear) {
		this.r14_minusten_threeyear = r14_minusten_threeyear;
	}
	public String getR15_currencies() {
		return r15_currencies;
	}
	public void setR15_currencies(String r15_currencies) {
		this.r15_currencies = r15_currencies;
	}
	public BigDecimal getR15_notational_amount() {
		return r15_notational_amount;
	}
	public void setR15_notational_amount(BigDecimal r15_notational_amount) {
		this.r15_notational_amount = r15_notational_amount;
	}
	public BigDecimal getR15_gross_market() {
		return r15_gross_market;
	}
	public void setR15_gross_market(BigDecimal r15_gross_market) {
		this.r15_gross_market = r15_gross_market;
	}
	public BigDecimal getR15_lessthan_oneyear() {
		return r15_lessthan_oneyear;
	}
	public void setR15_lessthan_oneyear(BigDecimal r15_lessthan_oneyear) {
		this.r15_lessthan_oneyear = r15_lessthan_oneyear;
	}
	public BigDecimal getR15_onetothree_year() {
		return r15_onetothree_year;
	}
	public void setR15_onetothree_year(BigDecimal r15_onetothree_year) {
		this.r15_onetothree_year = r15_onetothree_year;
	}
	public BigDecimal getR15_morethan_threeyear() {
		return r15_morethan_threeyear;
	}
	public void setR15_morethan_threeyear(BigDecimal r15_morethan_threeyear) {
		this.r15_morethan_threeyear = r15_morethan_threeyear;
	}
	public BigDecimal getR15_plusten_oneyear() {
		return r15_plusten_oneyear;
	}
	public void setR15_plusten_oneyear(BigDecimal r15_plusten_oneyear) {
		this.r15_plusten_oneyear = r15_plusten_oneyear;
	}
	public BigDecimal getR15_minusten_oneyear() {
		return r15_minusten_oneyear;
	}
	public void setR15_minusten_oneyear(BigDecimal r15_minusten_oneyear) {
		this.r15_minusten_oneyear = r15_minusten_oneyear;
	}
	public BigDecimal getR15_plusten_onetothreeyear() {
		return r15_plusten_onetothreeyear;
	}
	public void setR15_plusten_onetothreeyear(BigDecimal r15_plusten_onetothreeyear) {
		this.r15_plusten_onetothreeyear = r15_plusten_onetothreeyear;
	}
	public BigDecimal getR15_minusten_onetothreeyear() {
		return r15_minusten_onetothreeyear;
	}
	public void setR15_minusten_onetothreeyear(BigDecimal r15_minusten_onetothreeyear) {
		this.r15_minusten_onetothreeyear = r15_minusten_onetothreeyear;
	}
	public BigDecimal getR15_plusten_threeyear() {
		return r15_plusten_threeyear;
	}
	public void setR15_plusten_threeyear(BigDecimal r15_plusten_threeyear) {
		this.r15_plusten_threeyear = r15_plusten_threeyear;
	}
	public BigDecimal getR15_minusten_threeyear() {
		return r15_minusten_threeyear;
	}
	public void setR15_minusten_threeyear(BigDecimal r15_minusten_threeyear) {
		this.r15_minusten_threeyear = r15_minusten_threeyear;
	}
	public String getR16_currencies() {
		return r16_currencies;
	}
	public void setR16_currencies(String r16_currencies) {
		this.r16_currencies = r16_currencies;
	}
	public BigDecimal getR16_notational_amount() {
		return r16_notational_amount;
	}
	public void setR16_notational_amount(BigDecimal r16_notational_amount) {
		this.r16_notational_amount = r16_notational_amount;
	}
	public BigDecimal getR16_gross_market() {
		return r16_gross_market;
	}
	public void setR16_gross_market(BigDecimal r16_gross_market) {
		this.r16_gross_market = r16_gross_market;
	}
	public BigDecimal getR16_lessthan_oneyear() {
		return r16_lessthan_oneyear;
	}
	public void setR16_lessthan_oneyear(BigDecimal r16_lessthan_oneyear) {
		this.r16_lessthan_oneyear = r16_lessthan_oneyear;
	}
	public BigDecimal getR16_onetothree_year() {
		return r16_onetothree_year;
	}
	public void setR16_onetothree_year(BigDecimal r16_onetothree_year) {
		this.r16_onetothree_year = r16_onetothree_year;
	}
	public BigDecimal getR16_morethan_threeyear() {
		return r16_morethan_threeyear;
	}
	public void setR16_morethan_threeyear(BigDecimal r16_morethan_threeyear) {
		this.r16_morethan_threeyear = r16_morethan_threeyear;
	}
	public BigDecimal getR16_plusten_oneyear() {
		return r16_plusten_oneyear;
	}
	public void setR16_plusten_oneyear(BigDecimal r16_plusten_oneyear) {
		this.r16_plusten_oneyear = r16_plusten_oneyear;
	}
	public BigDecimal getR16_minusten_oneyear() {
		return r16_minusten_oneyear;
	}
	public void setR16_minusten_oneyear(BigDecimal r16_minusten_oneyear) {
		this.r16_minusten_oneyear = r16_minusten_oneyear;
	}
	public BigDecimal getR16_plusten_onetothreeyear() {
		return r16_plusten_onetothreeyear;
	}
	public void setR16_plusten_onetothreeyear(BigDecimal r16_plusten_onetothreeyear) {
		this.r16_plusten_onetothreeyear = r16_plusten_onetothreeyear;
	}
	public BigDecimal getR16_minusten_onetothreeyear() {
		return r16_minusten_onetothreeyear;
	}
	public void setR16_minusten_onetothreeyear(BigDecimal r16_minusten_onetothreeyear) {
		this.r16_minusten_onetothreeyear = r16_minusten_onetothreeyear;
	}
	public BigDecimal getR16_plusten_threeyear() {
		return r16_plusten_threeyear;
	}
	public void setR16_plusten_threeyear(BigDecimal r16_plusten_threeyear) {
		this.r16_plusten_threeyear = r16_plusten_threeyear;
	}
	public BigDecimal getR16_minusten_threeyear() {
		return r16_minusten_threeyear;
	}
	public void setR16_minusten_threeyear(BigDecimal r16_minusten_threeyear) {
		this.r16_minusten_threeyear = r16_minusten_threeyear;
	}
	public String getR17_currencies() {
		return r17_currencies;
	}
	public void setR17_currencies(String r17_currencies) {
		this.r17_currencies = r17_currencies;
	}
	public BigDecimal getR17_notational_amount() {
		return r17_notational_amount;
	}
	public void setR17_notational_amount(BigDecimal r17_notational_amount) {
		this.r17_notational_amount = r17_notational_amount;
	}
	public BigDecimal getR17_gross_market() {
		return r17_gross_market;
	}
	public void setR17_gross_market(BigDecimal r17_gross_market) {
		this.r17_gross_market = r17_gross_market;
	}
	public BigDecimal getR17_lessthan_oneyear() {
		return r17_lessthan_oneyear;
	}
	public void setR17_lessthan_oneyear(BigDecimal r17_lessthan_oneyear) {
		this.r17_lessthan_oneyear = r17_lessthan_oneyear;
	}
	public BigDecimal getR17_onetothree_year() {
		return r17_onetothree_year;
	}
	public void setR17_onetothree_year(BigDecimal r17_onetothree_year) {
		this.r17_onetothree_year = r17_onetothree_year;
	}
	public BigDecimal getR17_morethan_threeyear() {
		return r17_morethan_threeyear;
	}
	public void setR17_morethan_threeyear(BigDecimal r17_morethan_threeyear) {
		this.r17_morethan_threeyear = r17_morethan_threeyear;
	}
	public BigDecimal getR17_plusten_oneyear() {
		return r17_plusten_oneyear;
	}
	public void setR17_plusten_oneyear(BigDecimal r17_plusten_oneyear) {
		this.r17_plusten_oneyear = r17_plusten_oneyear;
	}
	public BigDecimal getR17_minusten_oneyear() {
		return r17_minusten_oneyear;
	}
	public void setR17_minusten_oneyear(BigDecimal r17_minusten_oneyear) {
		this.r17_minusten_oneyear = r17_minusten_oneyear;
	}
	public BigDecimal getR17_plusten_onetothreeyear() {
		return r17_plusten_onetothreeyear;
	}
	public void setR17_plusten_onetothreeyear(BigDecimal r17_plusten_onetothreeyear) {
		this.r17_plusten_onetothreeyear = r17_plusten_onetothreeyear;
	}
	public BigDecimal getR17_minusten_onetothreeyear() {
		return r17_minusten_onetothreeyear;
	}
	public void setR17_minusten_onetothreeyear(BigDecimal r17_minusten_onetothreeyear) {
		this.r17_minusten_onetothreeyear = r17_minusten_onetothreeyear;
	}
	public BigDecimal getR17_plusten_threeyear() {
		return r17_plusten_threeyear;
	}
	public void setR17_plusten_threeyear(BigDecimal r17_plusten_threeyear) {
		this.r17_plusten_threeyear = r17_plusten_threeyear;
	}
	public BigDecimal getR17_minusten_threeyear() {
		return r17_minusten_threeyear;
	}
	public void setR17_minusten_threeyear(BigDecimal r17_minusten_threeyear) {
		this.r17_minusten_threeyear = r17_minusten_threeyear;
	}
	public String getR18_currencies() {
		return r18_currencies;
	}
	public void setR18_currencies(String r18_currencies) {
		this.r18_currencies = r18_currencies;
	}
	public BigDecimal getR18_notational_amount() {
		return r18_notational_amount;
	}
	public void setR18_notational_amount(BigDecimal r18_notational_amount) {
		this.r18_notational_amount = r18_notational_amount;
	}
	public BigDecimal getR18_gross_market() {
		return r18_gross_market;
	}
	public void setR18_gross_market(BigDecimal r18_gross_market) {
		this.r18_gross_market = r18_gross_market;
	}
	public BigDecimal getR18_lessthan_oneyear() {
		return r18_lessthan_oneyear;
	}
	public void setR18_lessthan_oneyear(BigDecimal r18_lessthan_oneyear) {
		this.r18_lessthan_oneyear = r18_lessthan_oneyear;
	}
	public BigDecimal getR18_onetothree_year() {
		return r18_onetothree_year;
	}
	public void setR18_onetothree_year(BigDecimal r18_onetothree_year) {
		this.r18_onetothree_year = r18_onetothree_year;
	}
	public BigDecimal getR18_morethan_threeyear() {
		return r18_morethan_threeyear;
	}
	public void setR18_morethan_threeyear(BigDecimal r18_morethan_threeyear) {
		this.r18_morethan_threeyear = r18_morethan_threeyear;
	}
	public BigDecimal getR18_plusten_oneyear() {
		return r18_plusten_oneyear;
	}
	public void setR18_plusten_oneyear(BigDecimal r18_plusten_oneyear) {
		this.r18_plusten_oneyear = r18_plusten_oneyear;
	}
	public BigDecimal getR18_minusten_oneyear() {
		return r18_minusten_oneyear;
	}
	public void setR18_minusten_oneyear(BigDecimal r18_minusten_oneyear) {
		this.r18_minusten_oneyear = r18_minusten_oneyear;
	}
	public BigDecimal getR18_plusten_onetothreeyear() {
		return r18_plusten_onetothreeyear;
	}
	public void setR18_plusten_onetothreeyear(BigDecimal r18_plusten_onetothreeyear) {
		this.r18_plusten_onetothreeyear = r18_plusten_onetothreeyear;
	}
	public BigDecimal getR18_minusten_onetothreeyear() {
		return r18_minusten_onetothreeyear;
	}
	public void setR18_minusten_onetothreeyear(BigDecimal r18_minusten_onetothreeyear) {
		this.r18_minusten_onetothreeyear = r18_minusten_onetothreeyear;
	}
	public BigDecimal getR18_plusten_threeyear() {
		return r18_plusten_threeyear;
	}
	public void setR18_plusten_threeyear(BigDecimal r18_plusten_threeyear) {
		this.r18_plusten_threeyear = r18_plusten_threeyear;
	}
	public BigDecimal getR18_minusten_threeyear() {
		return r18_minusten_threeyear;
	}
	public void setR18_minusten_threeyear(BigDecimal r18_minusten_threeyear) {
		this.r18_minusten_threeyear = r18_minusten_threeyear;
	}
	public String getR19_currencies() {
		return r19_currencies;
	}
	public void setR19_currencies(String r19_currencies) {
		this.r19_currencies = r19_currencies;
	}
	public BigDecimal getR19_notational_amount() {
		return r19_notational_amount;
	}
	public void setR19_notational_amount(BigDecimal r19_notational_amount) {
		this.r19_notational_amount = r19_notational_amount;
	}
	public BigDecimal getR19_gross_market() {
		return r19_gross_market;
	}
	public void setR19_gross_market(BigDecimal r19_gross_market) {
		this.r19_gross_market = r19_gross_market;
	}
	public BigDecimal getR19_lessthan_oneyear() {
		return r19_lessthan_oneyear;
	}
	public void setR19_lessthan_oneyear(BigDecimal r19_lessthan_oneyear) {
		this.r19_lessthan_oneyear = r19_lessthan_oneyear;
	}
	public BigDecimal getR19_onetothree_year() {
		return r19_onetothree_year;
	}
	public void setR19_onetothree_year(BigDecimal r19_onetothree_year) {
		this.r19_onetothree_year = r19_onetothree_year;
	}
	public BigDecimal getR19_morethan_threeyear() {
		return r19_morethan_threeyear;
	}
	public void setR19_morethan_threeyear(BigDecimal r19_morethan_threeyear) {
		this.r19_morethan_threeyear = r19_morethan_threeyear;
	}
	public BigDecimal getR19_plusten_oneyear() {
		return r19_plusten_oneyear;
	}
	public void setR19_plusten_oneyear(BigDecimal r19_plusten_oneyear) {
		this.r19_plusten_oneyear = r19_plusten_oneyear;
	}
	public BigDecimal getR19_minusten_oneyear() {
		return r19_minusten_oneyear;
	}
	public void setR19_minusten_oneyear(BigDecimal r19_minusten_oneyear) {
		this.r19_minusten_oneyear = r19_minusten_oneyear;
	}
	public BigDecimal getR19_plusten_onetothreeyear() {
		return r19_plusten_onetothreeyear;
	}
	public void setR19_plusten_onetothreeyear(BigDecimal r19_plusten_onetothreeyear) {
		this.r19_plusten_onetothreeyear = r19_plusten_onetothreeyear;
	}
	public BigDecimal getR19_minusten_onetothreeyear() {
		return r19_minusten_onetothreeyear;
	}
	public void setR19_minusten_onetothreeyear(BigDecimal r19_minusten_onetothreeyear) {
		this.r19_minusten_onetothreeyear = r19_minusten_onetothreeyear;
	}
	public BigDecimal getR19_plusten_threeyear() {
		return r19_plusten_threeyear;
	}
	public void setR19_plusten_threeyear(BigDecimal r19_plusten_threeyear) {
		this.r19_plusten_threeyear = r19_plusten_threeyear;
	}
	public BigDecimal getR19_minusten_threeyear() {
		return r19_minusten_threeyear;
	}
	public void setR19_minusten_threeyear(BigDecimal r19_minusten_threeyear) {
		this.r19_minusten_threeyear = r19_minusten_threeyear;
	}
	public String getR20_currencies() {
		return r20_currencies;
	}
	public void setR20_currencies(String r20_currencies) {
		this.r20_currencies = r20_currencies;
	}
	public BigDecimal getR20_notational_amount() {
		return r20_notational_amount;
	}
	public void setR20_notational_amount(BigDecimal r20_notational_amount) {
		this.r20_notational_amount = r20_notational_amount;
	}
	public BigDecimal getR20_gross_market() {
		return r20_gross_market;
	}
	public void setR20_gross_market(BigDecimal r20_gross_market) {
		this.r20_gross_market = r20_gross_market;
	}
	public BigDecimal getR20_lessthan_oneyear() {
		return r20_lessthan_oneyear;
	}
	public void setR20_lessthan_oneyear(BigDecimal r20_lessthan_oneyear) {
		this.r20_lessthan_oneyear = r20_lessthan_oneyear;
	}
	public BigDecimal getR20_onetothree_year() {
		return r20_onetothree_year;
	}
	public void setR20_onetothree_year(BigDecimal r20_onetothree_year) {
		this.r20_onetothree_year = r20_onetothree_year;
	}
	public BigDecimal getR20_morethan_threeyear() {
		return r20_morethan_threeyear;
	}
	public void setR20_morethan_threeyear(BigDecimal r20_morethan_threeyear) {
		this.r20_morethan_threeyear = r20_morethan_threeyear;
	}
	public BigDecimal getR20_plusten_oneyear() {
		return r20_plusten_oneyear;
	}
	public void setR20_plusten_oneyear(BigDecimal r20_plusten_oneyear) {
		this.r20_plusten_oneyear = r20_plusten_oneyear;
	}
	public BigDecimal getR20_minusten_oneyear() {
		return r20_minusten_oneyear;
	}
	public void setR20_minusten_oneyear(BigDecimal r20_minusten_oneyear) {
		this.r20_minusten_oneyear = r20_minusten_oneyear;
	}
	public BigDecimal getR20_plusten_onetothreeyear() {
		return r20_plusten_onetothreeyear;
	}
	public void setR20_plusten_onetothreeyear(BigDecimal r20_plusten_onetothreeyear) {
		this.r20_plusten_onetothreeyear = r20_plusten_onetothreeyear;
	}
	public BigDecimal getR20_minusten_onetothreeyear() {
		return r20_minusten_onetothreeyear;
	}
	public void setR20_minusten_onetothreeyear(BigDecimal r20_minusten_onetothreeyear) {
		this.r20_minusten_onetothreeyear = r20_minusten_onetothreeyear;
	}
	public BigDecimal getR20_plusten_threeyear() {
		return r20_plusten_threeyear;
	}
	public void setR20_plusten_threeyear(BigDecimal r20_plusten_threeyear) {
		this.r20_plusten_threeyear = r20_plusten_threeyear;
	}
	public BigDecimal getR20_minusten_threeyear() {
		return r20_minusten_threeyear;
	}
	public void setR20_minusten_threeyear(BigDecimal r20_minusten_threeyear) {
		this.r20_minusten_threeyear = r20_minusten_threeyear;
	}
	public String getR21_currencies() {
		return r21_currencies;
	}
	public void setR21_currencies(String r21_currencies) {
		this.r21_currencies = r21_currencies;
	}
	public BigDecimal getR21_notational_amount() {
		return r21_notational_amount;
	}
	public void setR21_notational_amount(BigDecimal r21_notational_amount) {
		this.r21_notational_amount = r21_notational_amount;
	}
	public BigDecimal getR21_gross_market() {
		return r21_gross_market;
	}
	public void setR21_gross_market(BigDecimal r21_gross_market) {
		this.r21_gross_market = r21_gross_market;
	}
	public BigDecimal getR21_lessthan_oneyear() {
		return r21_lessthan_oneyear;
	}
	public void setR21_lessthan_oneyear(BigDecimal r21_lessthan_oneyear) {
		this.r21_lessthan_oneyear = r21_lessthan_oneyear;
	}
	public BigDecimal getR21_onetothree_year() {
		return r21_onetothree_year;
	}
	public void setR21_onetothree_year(BigDecimal r21_onetothree_year) {
		this.r21_onetothree_year = r21_onetothree_year;
	}
	public BigDecimal getR21_morethan_threeyear() {
		return r21_morethan_threeyear;
	}
	public void setR21_morethan_threeyear(BigDecimal r21_morethan_threeyear) {
		this.r21_morethan_threeyear = r21_morethan_threeyear;
	}
	public BigDecimal getR21_plusten_oneyear() {
		return r21_plusten_oneyear;
	}
	public void setR21_plusten_oneyear(BigDecimal r21_plusten_oneyear) {
		this.r21_plusten_oneyear = r21_plusten_oneyear;
	}
	public BigDecimal getR21_minusten_oneyear() {
		return r21_minusten_oneyear;
	}
	public void setR21_minusten_oneyear(BigDecimal r21_minusten_oneyear) {
		this.r21_minusten_oneyear = r21_minusten_oneyear;
	}
	public BigDecimal getR21_plusten_onetothreeyear() {
		return r21_plusten_onetothreeyear;
	}
	public void setR21_plusten_onetothreeyear(BigDecimal r21_plusten_onetothreeyear) {
		this.r21_plusten_onetothreeyear = r21_plusten_onetothreeyear;
	}
	public BigDecimal getR21_minusten_onetothreeyear() {
		return r21_minusten_onetothreeyear;
	}
	public void setR21_minusten_onetothreeyear(BigDecimal r21_minusten_onetothreeyear) {
		this.r21_minusten_onetothreeyear = r21_minusten_onetothreeyear;
	}
	public BigDecimal getR21_plusten_threeyear() {
		return r21_plusten_threeyear;
	}
	public void setR21_plusten_threeyear(BigDecimal r21_plusten_threeyear) {
		this.r21_plusten_threeyear = r21_plusten_threeyear;
	}
	public BigDecimal getR21_minusten_threeyear() {
		return r21_minusten_threeyear;
	}
	public void setR21_minusten_threeyear(BigDecimal r21_minusten_threeyear) {
		this.r21_minusten_threeyear = r21_minusten_threeyear;
	}
	public String getR22_currencies() {
		return r22_currencies;
	}
	public void setR22_currencies(String r22_currencies) {
		this.r22_currencies = r22_currencies;
	}
	public BigDecimal getR22_notational_amount() {
		return r22_notational_amount;
	}
	public void setR22_notational_amount(BigDecimal r22_notational_amount) {
		this.r22_notational_amount = r22_notational_amount;
	}
	public BigDecimal getR22_gross_market() {
		return r22_gross_market;
	}
	public void setR22_gross_market(BigDecimal r22_gross_market) {
		this.r22_gross_market = r22_gross_market;
	}
	public BigDecimal getR22_lessthan_oneyear() {
		return r22_lessthan_oneyear;
	}
	public void setR22_lessthan_oneyear(BigDecimal r22_lessthan_oneyear) {
		this.r22_lessthan_oneyear = r22_lessthan_oneyear;
	}
	public BigDecimal getR22_onetothree_year() {
		return r22_onetothree_year;
	}
	public void setR22_onetothree_year(BigDecimal r22_onetothree_year) {
		this.r22_onetothree_year = r22_onetothree_year;
	}
	public BigDecimal getR22_morethan_threeyear() {
		return r22_morethan_threeyear;
	}
	public void setR22_morethan_threeyear(BigDecimal r22_morethan_threeyear) {
		this.r22_morethan_threeyear = r22_morethan_threeyear;
	}
	public BigDecimal getR22_plusten_oneyear() {
		return r22_plusten_oneyear;
	}
	public void setR22_plusten_oneyear(BigDecimal r22_plusten_oneyear) {
		this.r22_plusten_oneyear = r22_plusten_oneyear;
	}
	public BigDecimal getR22_minusten_oneyear() {
		return r22_minusten_oneyear;
	}
	public void setR22_minusten_oneyear(BigDecimal r22_minusten_oneyear) {
		this.r22_minusten_oneyear = r22_minusten_oneyear;
	}
	public BigDecimal getR22_plusten_onetothreeyear() {
		return r22_plusten_onetothreeyear;
	}
	public void setR22_plusten_onetothreeyear(BigDecimal r22_plusten_onetothreeyear) {
		this.r22_plusten_onetothreeyear = r22_plusten_onetothreeyear;
	}
	public BigDecimal getR22_minusten_onetothreeyear() {
		return r22_minusten_onetothreeyear;
	}
	public void setR22_minusten_onetothreeyear(BigDecimal r22_minusten_onetothreeyear) {
		this.r22_minusten_onetothreeyear = r22_minusten_onetothreeyear;
	}
	public BigDecimal getR22_plusten_threeyear() {
		return r22_plusten_threeyear;
	}
	public void setR22_plusten_threeyear(BigDecimal r22_plusten_threeyear) {
		this.r22_plusten_threeyear = r22_plusten_threeyear;
	}
	public BigDecimal getR22_minusten_threeyear() {
		return r22_minusten_threeyear;
	}
	public void setR22_minusten_threeyear(BigDecimal r22_minusten_threeyear) {
		this.r22_minusten_threeyear = r22_minusten_threeyear;
	}
	public String getR23_currencies() {
		return r23_currencies;
	}
	public void setR23_currencies(String r23_currencies) {
		this.r23_currencies = r23_currencies;
	}
	public BigDecimal getR23_notational_amount() {
		return r23_notational_amount;
	}
	public void setR23_notational_amount(BigDecimal r23_notational_amount) {
		this.r23_notational_amount = r23_notational_amount;
	}
	public BigDecimal getR23_gross_market() {
		return r23_gross_market;
	}
	public void setR23_gross_market(BigDecimal r23_gross_market) {
		this.r23_gross_market = r23_gross_market;
	}
	public BigDecimal getR23_lessthan_oneyear() {
		return r23_lessthan_oneyear;
	}
	public void setR23_lessthan_oneyear(BigDecimal r23_lessthan_oneyear) {
		this.r23_lessthan_oneyear = r23_lessthan_oneyear;
	}
	public BigDecimal getR23_onetothree_year() {
		return r23_onetothree_year;
	}
	public void setR23_onetothree_year(BigDecimal r23_onetothree_year) {
		this.r23_onetothree_year = r23_onetothree_year;
	}
	public BigDecimal getR23_morethan_threeyear() {
		return r23_morethan_threeyear;
	}
	public void setR23_morethan_threeyear(BigDecimal r23_morethan_threeyear) {
		this.r23_morethan_threeyear = r23_morethan_threeyear;
	}
	public BigDecimal getR23_plusten_oneyear() {
		return r23_plusten_oneyear;
	}
	public void setR23_plusten_oneyear(BigDecimal r23_plusten_oneyear) {
		this.r23_plusten_oneyear = r23_plusten_oneyear;
	}
	public BigDecimal getR23_minusten_oneyear() {
		return r23_minusten_oneyear;
	}
	public void setR23_minusten_oneyear(BigDecimal r23_minusten_oneyear) {
		this.r23_minusten_oneyear = r23_minusten_oneyear;
	}
	public BigDecimal getR23_plusten_onetothreeyear() {
		return r23_plusten_onetothreeyear;
	}
	public void setR23_plusten_onetothreeyear(BigDecimal r23_plusten_onetothreeyear) {
		this.r23_plusten_onetothreeyear = r23_plusten_onetothreeyear;
	}
	public BigDecimal getR23_minusten_onetothreeyear() {
		return r23_minusten_onetothreeyear;
	}
	public void setR23_minusten_onetothreeyear(BigDecimal r23_minusten_onetothreeyear) {
		this.r23_minusten_onetothreeyear = r23_minusten_onetothreeyear;
	}
	public BigDecimal getR23_plusten_threeyear() {
		return r23_plusten_threeyear;
	}
	public void setR23_plusten_threeyear(BigDecimal r23_plusten_threeyear) {
		this.r23_plusten_threeyear = r23_plusten_threeyear;
	}
	public BigDecimal getR23_minusten_threeyear() {
		return r23_minusten_threeyear;
	}
	public void setR23_minusten_threeyear(BigDecimal r23_minusten_threeyear) {
		this.r23_minusten_threeyear = r23_minusten_threeyear;
	}
	public String getR24_currencies() {
		return r24_currencies;
	}
	public void setR24_currencies(String r24_currencies) {
		this.r24_currencies = r24_currencies;
	}
	public BigDecimal getR24_notational_amount() {
		return r24_notational_amount;
	}
	public void setR24_notational_amount(BigDecimal r24_notational_amount) {
		this.r24_notational_amount = r24_notational_amount;
	}
	public BigDecimal getR24_gross_market() {
		return r24_gross_market;
	}
	public void setR24_gross_market(BigDecimal r24_gross_market) {
		this.r24_gross_market = r24_gross_market;
	}
	public BigDecimal getR24_lessthan_oneyear() {
		return r24_lessthan_oneyear;
	}
	public void setR24_lessthan_oneyear(BigDecimal r24_lessthan_oneyear) {
		this.r24_lessthan_oneyear = r24_lessthan_oneyear;
	}
	public BigDecimal getR24_onetothree_year() {
		return r24_onetothree_year;
	}
	public void setR24_onetothree_year(BigDecimal r24_onetothree_year) {
		this.r24_onetothree_year = r24_onetothree_year;
	}
	public BigDecimal getR24_morethan_threeyear() {
		return r24_morethan_threeyear;
	}
	public void setR24_morethan_threeyear(BigDecimal r24_morethan_threeyear) {
		this.r24_morethan_threeyear = r24_morethan_threeyear;
	}
	public BigDecimal getR24_plusten_oneyear() {
		return r24_plusten_oneyear;
	}
	public void setR24_plusten_oneyear(BigDecimal r24_plusten_oneyear) {
		this.r24_plusten_oneyear = r24_plusten_oneyear;
	}
	public BigDecimal getR24_minusten_oneyear() {
		return r24_minusten_oneyear;
	}
	public void setR24_minusten_oneyear(BigDecimal r24_minusten_oneyear) {
		this.r24_minusten_oneyear = r24_minusten_oneyear;
	}
	public BigDecimal getR24_plusten_onetothreeyear() {
		return r24_plusten_onetothreeyear;
	}
	public void setR24_plusten_onetothreeyear(BigDecimal r24_plusten_onetothreeyear) {
		this.r24_plusten_onetothreeyear = r24_plusten_onetothreeyear;
	}
	public BigDecimal getR24_minusten_onetothreeyear() {
		return r24_minusten_onetothreeyear;
	}
	public void setR24_minusten_onetothreeyear(BigDecimal r24_minusten_onetothreeyear) {
		this.r24_minusten_onetothreeyear = r24_minusten_onetothreeyear;
	}
	public BigDecimal getR24_plusten_threeyear() {
		return r24_plusten_threeyear;
	}
	public void setR24_plusten_threeyear(BigDecimal r24_plusten_threeyear) {
		this.r24_plusten_threeyear = r24_plusten_threeyear;
	}
	public BigDecimal getR24_minusten_threeyear() {
		return r24_minusten_threeyear;
	}
	public void setR24_minusten_threeyear(BigDecimal r24_minusten_threeyear) {
		this.r24_minusten_threeyear = r24_minusten_threeyear;
	}
	public String getR25_currencies() {
		return r25_currencies;
	}
	public void setR25_currencies(String r25_currencies) {
		this.r25_currencies = r25_currencies;
	}
	public BigDecimal getR25_notational_amount() {
		return r25_notational_amount;
	}
	public void setR25_notational_amount(BigDecimal r25_notational_amount) {
		this.r25_notational_amount = r25_notational_amount;
	}
	public BigDecimal getR25_gross_market() {
		return r25_gross_market;
	}
	public void setR25_gross_market(BigDecimal r25_gross_market) {
		this.r25_gross_market = r25_gross_market;
	}
	public BigDecimal getR25_lessthan_oneyear() {
		return r25_lessthan_oneyear;
	}
	public void setR25_lessthan_oneyear(BigDecimal r25_lessthan_oneyear) {
		this.r25_lessthan_oneyear = r25_lessthan_oneyear;
	}
	public BigDecimal getR25_onetothree_year() {
		return r25_onetothree_year;
	}
	public void setR25_onetothree_year(BigDecimal r25_onetothree_year) {
		this.r25_onetothree_year = r25_onetothree_year;
	}
	public BigDecimal getR25_morethan_threeyear() {
		return r25_morethan_threeyear;
	}
	public void setR25_morethan_threeyear(BigDecimal r25_morethan_threeyear) {
		this.r25_morethan_threeyear = r25_morethan_threeyear;
	}
	public BigDecimal getR25_plusten_oneyear() {
		return r25_plusten_oneyear;
	}
	public void setR25_plusten_oneyear(BigDecimal r25_plusten_oneyear) {
		this.r25_plusten_oneyear = r25_plusten_oneyear;
	}
	public BigDecimal getR25_minusten_oneyear() {
		return r25_minusten_oneyear;
	}
	public void setR25_minusten_oneyear(BigDecimal r25_minusten_oneyear) {
		this.r25_minusten_oneyear = r25_minusten_oneyear;
	}
	public BigDecimal getR25_plusten_onetothreeyear() {
		return r25_plusten_onetothreeyear;
	}
	public void setR25_plusten_onetothreeyear(BigDecimal r25_plusten_onetothreeyear) {
		this.r25_plusten_onetothreeyear = r25_plusten_onetothreeyear;
	}
	public BigDecimal getR25_minusten_onetothreeyear() {
		return r25_minusten_onetothreeyear;
	}
	public void setR25_minusten_onetothreeyear(BigDecimal r25_minusten_onetothreeyear) {
		this.r25_minusten_onetothreeyear = r25_minusten_onetothreeyear;
	}
	public BigDecimal getR25_plusten_threeyear() {
		return r25_plusten_threeyear;
	}
	public void setR25_plusten_threeyear(BigDecimal r25_plusten_threeyear) {
		this.r25_plusten_threeyear = r25_plusten_threeyear;
	}
	public BigDecimal getR25_minusten_threeyear() {
		return r25_minusten_threeyear;
	}
	public void setR25_minusten_threeyear(BigDecimal r25_minusten_threeyear) {
		this.r25_minusten_threeyear = r25_minusten_threeyear;
	}
	public String getR26_currencies() {
		return r26_currencies;
	}
	public void setR26_currencies(String r26_currencies) {
		this.r26_currencies = r26_currencies;
	}
	public BigDecimal getR26_notational_amount() {
		return r26_notational_amount;
	}
	public void setR26_notational_amount(BigDecimal r26_notational_amount) {
		this.r26_notational_amount = r26_notational_amount;
	}
	public BigDecimal getR26_gross_market() {
		return r26_gross_market;
	}
	public void setR26_gross_market(BigDecimal r26_gross_market) {
		this.r26_gross_market = r26_gross_market;
	}
	public BigDecimal getR26_lessthan_oneyear() {
		return r26_lessthan_oneyear;
	}
	public void setR26_lessthan_oneyear(BigDecimal r26_lessthan_oneyear) {
		this.r26_lessthan_oneyear = r26_lessthan_oneyear;
	}
	public BigDecimal getR26_onetothree_year() {
		return r26_onetothree_year;
	}
	public void setR26_onetothree_year(BigDecimal r26_onetothree_year) {
		this.r26_onetothree_year = r26_onetothree_year;
	}
	public BigDecimal getR26_morethan_threeyear() {
		return r26_morethan_threeyear;
	}
	public void setR26_morethan_threeyear(BigDecimal r26_morethan_threeyear) {
		this.r26_morethan_threeyear = r26_morethan_threeyear;
	}
	public BigDecimal getR26_plusten_oneyear() {
		return r26_plusten_oneyear;
	}
	public void setR26_plusten_oneyear(BigDecimal r26_plusten_oneyear) {
		this.r26_plusten_oneyear = r26_plusten_oneyear;
	}
	public BigDecimal getR26_minusten_oneyear() {
		return r26_minusten_oneyear;
	}
	public void setR26_minusten_oneyear(BigDecimal r26_minusten_oneyear) {
		this.r26_minusten_oneyear = r26_minusten_oneyear;
	}
	public BigDecimal getR26_plusten_onetothreeyear() {
		return r26_plusten_onetothreeyear;
	}
	public void setR26_plusten_onetothreeyear(BigDecimal r26_plusten_onetothreeyear) {
		this.r26_plusten_onetothreeyear = r26_plusten_onetothreeyear;
	}
	public BigDecimal getR26_minusten_onetothreeyear() {
		return r26_minusten_onetothreeyear;
	}
	public void setR26_minusten_onetothreeyear(BigDecimal r26_minusten_onetothreeyear) {
		this.r26_minusten_onetothreeyear = r26_minusten_onetothreeyear;
	}
	public BigDecimal getR26_plusten_threeyear() {
		return r26_plusten_threeyear;
	}
	public void setR26_plusten_threeyear(BigDecimal r26_plusten_threeyear) {
		this.r26_plusten_threeyear = r26_plusten_threeyear;
	}
	public BigDecimal getR26_minusten_threeyear() {
		return r26_minusten_threeyear;
	}
	public void setR26_minusten_threeyear(BigDecimal r26_minusten_threeyear) {
		this.r26_minusten_threeyear = r26_minusten_threeyear;
	}
	public String getR27_currencies() {
		return r27_currencies;
	}
	public void setR27_currencies(String r27_currencies) {
		this.r27_currencies = r27_currencies;
	}
	public BigDecimal getR27_notational_amount() {
		return r27_notational_amount;
	}
	public void setR27_notational_amount(BigDecimal r27_notational_amount) {
		this.r27_notational_amount = r27_notational_amount;
	}
	public BigDecimal getR27_gross_market() {
		return r27_gross_market;
	}
	public void setR27_gross_market(BigDecimal r27_gross_market) {
		this.r27_gross_market = r27_gross_market;
	}
	public BigDecimal getR27_lessthan_oneyear() {
		return r27_lessthan_oneyear;
	}
	public void setR27_lessthan_oneyear(BigDecimal r27_lessthan_oneyear) {
		this.r27_lessthan_oneyear = r27_lessthan_oneyear;
	}
	public BigDecimal getR27_onetothree_year() {
		return r27_onetothree_year;
	}
	public void setR27_onetothree_year(BigDecimal r27_onetothree_year) {
		this.r27_onetothree_year = r27_onetothree_year;
	}
	public BigDecimal getR27_morethan_threeyear() {
		return r27_morethan_threeyear;
	}
	public void setR27_morethan_threeyear(BigDecimal r27_morethan_threeyear) {
		this.r27_morethan_threeyear = r27_morethan_threeyear;
	}
	public BigDecimal getR27_plusten_oneyear() {
		return r27_plusten_oneyear;
	}
	public void setR27_plusten_oneyear(BigDecimal r27_plusten_oneyear) {
		this.r27_plusten_oneyear = r27_plusten_oneyear;
	}
	public BigDecimal getR27_minusten_oneyear() {
		return r27_minusten_oneyear;
	}
	public void setR27_minusten_oneyear(BigDecimal r27_minusten_oneyear) {
		this.r27_minusten_oneyear = r27_minusten_oneyear;
	}
	public BigDecimal getR27_plusten_onetothreeyear() {
		return r27_plusten_onetothreeyear;
	}
	public void setR27_plusten_onetothreeyear(BigDecimal r27_plusten_onetothreeyear) {
		this.r27_plusten_onetothreeyear = r27_plusten_onetothreeyear;
	}
	public BigDecimal getR27_minusten_onetothreeyear() {
		return r27_minusten_onetothreeyear;
	}
	public void setR27_minusten_onetothreeyear(BigDecimal r27_minusten_onetothreeyear) {
		this.r27_minusten_onetothreeyear = r27_minusten_onetothreeyear;
	}
	public BigDecimal getR27_plusten_threeyear() {
		return r27_plusten_threeyear;
	}
	public void setR27_plusten_threeyear(BigDecimal r27_plusten_threeyear) {
		this.r27_plusten_threeyear = r27_plusten_threeyear;
	}
	public BigDecimal getR27_minusten_threeyear() {
		return r27_minusten_threeyear;
	}
	public void setR27_minusten_threeyear(BigDecimal r27_minusten_threeyear) {
		this.r27_minusten_threeyear = r27_minusten_threeyear;
	}
	public String getR28_currencies() {
		return r28_currencies;
	}
	public void setR28_currencies(String r28_currencies) {
		this.r28_currencies = r28_currencies;
	}
	public BigDecimal getR28_notational_amount() {
		return r28_notational_amount;
	}
	public void setR28_notational_amount(BigDecimal r28_notational_amount) {
		this.r28_notational_amount = r28_notational_amount;
	}
	public BigDecimal getR28_gross_market() {
		return r28_gross_market;
	}
	public void setR28_gross_market(BigDecimal r28_gross_market) {
		this.r28_gross_market = r28_gross_market;
	}
	public BigDecimal getR28_lessthan_oneyear() {
		return r28_lessthan_oneyear;
	}
	public void setR28_lessthan_oneyear(BigDecimal r28_lessthan_oneyear) {
		this.r28_lessthan_oneyear = r28_lessthan_oneyear;
	}
	public BigDecimal getR28_onetothree_year() {
		return r28_onetothree_year;
	}
	public void setR28_onetothree_year(BigDecimal r28_onetothree_year) {
		this.r28_onetothree_year = r28_onetothree_year;
	}
	public BigDecimal getR28_morethan_threeyear() {
		return r28_morethan_threeyear;
	}
	public void setR28_morethan_threeyear(BigDecimal r28_morethan_threeyear) {
		this.r28_morethan_threeyear = r28_morethan_threeyear;
	}
	public BigDecimal getR28_plusten_oneyear() {
		return r28_plusten_oneyear;
	}
	public void setR28_plusten_oneyear(BigDecimal r28_plusten_oneyear) {
		this.r28_plusten_oneyear = r28_plusten_oneyear;
	}
	public BigDecimal getR28_minusten_oneyear() {
		return r28_minusten_oneyear;
	}
	public void setR28_minusten_oneyear(BigDecimal r28_minusten_oneyear) {
		this.r28_minusten_oneyear = r28_minusten_oneyear;
	}
	public BigDecimal getR28_plusten_onetothreeyear() {
		return r28_plusten_onetothreeyear;
	}
	public void setR28_plusten_onetothreeyear(BigDecimal r28_plusten_onetothreeyear) {
		this.r28_plusten_onetothreeyear = r28_plusten_onetothreeyear;
	}
	public BigDecimal getR28_minusten_onetothreeyear() {
		return r28_minusten_onetothreeyear;
	}
	public void setR28_minusten_onetothreeyear(BigDecimal r28_minusten_onetothreeyear) {
		this.r28_minusten_onetothreeyear = r28_minusten_onetothreeyear;
	}
	public BigDecimal getR28_plusten_threeyear() {
		return r28_plusten_threeyear;
	}
	public void setR28_plusten_threeyear(BigDecimal r28_plusten_threeyear) {
		this.r28_plusten_threeyear = r28_plusten_threeyear;
	}
	public BigDecimal getR28_minusten_threeyear() {
		return r28_minusten_threeyear;
	}
	public void setR28_minusten_threeyear(BigDecimal r28_minusten_threeyear) {
		this.r28_minusten_threeyear = r28_minusten_threeyear;
	}
	public String getR29_currencies() {
		return r29_currencies;
	}
	public void setR29_currencies(String r29_currencies) {
		this.r29_currencies = r29_currencies;
	}
	public BigDecimal getR29_notational_amount() {
		return r29_notational_amount;
	}
	public void setR29_notational_amount(BigDecimal r29_notational_amount) {
		this.r29_notational_amount = r29_notational_amount;
	}
	public BigDecimal getR29_gross_market() {
		return r29_gross_market;
	}
	public void setR29_gross_market(BigDecimal r29_gross_market) {
		this.r29_gross_market = r29_gross_market;
	}
	public BigDecimal getR29_lessthan_oneyear() {
		return r29_lessthan_oneyear;
	}
	public void setR29_lessthan_oneyear(BigDecimal r29_lessthan_oneyear) {
		this.r29_lessthan_oneyear = r29_lessthan_oneyear;
	}
	public BigDecimal getR29_onetothree_year() {
		return r29_onetothree_year;
	}
	public void setR29_onetothree_year(BigDecimal r29_onetothree_year) {
		this.r29_onetothree_year = r29_onetothree_year;
	}
	public BigDecimal getR29_morethan_threeyear() {
		return r29_morethan_threeyear;
	}
	public void setR29_morethan_threeyear(BigDecimal r29_morethan_threeyear) {
		this.r29_morethan_threeyear = r29_morethan_threeyear;
	}
	public BigDecimal getR29_plusten_oneyear() {
		return r29_plusten_oneyear;
	}
	public void setR29_plusten_oneyear(BigDecimal r29_plusten_oneyear) {
		this.r29_plusten_oneyear = r29_plusten_oneyear;
	}
	public BigDecimal getR29_minusten_oneyear() {
		return r29_minusten_oneyear;
	}
	public void setR29_minusten_oneyear(BigDecimal r29_minusten_oneyear) {
		this.r29_minusten_oneyear = r29_minusten_oneyear;
	}
	public BigDecimal getR29_plusten_onetothreeyear() {
		return r29_plusten_onetothreeyear;
	}
	public void setR29_plusten_onetothreeyear(BigDecimal r29_plusten_onetothreeyear) {
		this.r29_plusten_onetothreeyear = r29_plusten_onetothreeyear;
	}
	public BigDecimal getR29_minusten_onetothreeyear() {
		return r29_minusten_onetothreeyear;
	}
	public void setR29_minusten_onetothreeyear(BigDecimal r29_minusten_onetothreeyear) {
		this.r29_minusten_onetothreeyear = r29_minusten_onetothreeyear;
	}
	public BigDecimal getR29_plusten_threeyear() {
		return r29_plusten_threeyear;
	}
	public void setR29_plusten_threeyear(BigDecimal r29_plusten_threeyear) {
		this.r29_plusten_threeyear = r29_plusten_threeyear;
	}
	public BigDecimal getR29_minusten_threeyear() {
		return r29_minusten_threeyear;
	}
	public void setR29_minusten_threeyear(BigDecimal r29_minusten_threeyear) {
		this.r29_minusten_threeyear = r29_minusten_threeyear;
	}
	public String getR30_currencies() {
		return r30_currencies;
	}
	public void setR30_currencies(String r30_currencies) {
		this.r30_currencies = r30_currencies;
	}
	public BigDecimal getR30_notational_amount() {
		return r30_notational_amount;
	}
	public void setR30_notational_amount(BigDecimal r30_notational_amount) {
		this.r30_notational_amount = r30_notational_amount;
	}
	public BigDecimal getR30_gross_market() {
		return r30_gross_market;
	}
	public void setR30_gross_market(BigDecimal r30_gross_market) {
		this.r30_gross_market = r30_gross_market;
	}
	public BigDecimal getR30_lessthan_oneyear() {
		return r30_lessthan_oneyear;
	}
	public void setR30_lessthan_oneyear(BigDecimal r30_lessthan_oneyear) {
		this.r30_lessthan_oneyear = r30_lessthan_oneyear;
	}
	public BigDecimal getR30_onetothree_year() {
		return r30_onetothree_year;
	}
	public void setR30_onetothree_year(BigDecimal r30_onetothree_year) {
		this.r30_onetothree_year = r30_onetothree_year;
	}
	public BigDecimal getR30_morethan_threeyear() {
		return r30_morethan_threeyear;
	}
	public void setR30_morethan_threeyear(BigDecimal r30_morethan_threeyear) {
		this.r30_morethan_threeyear = r30_morethan_threeyear;
	}
	public BigDecimal getR30_plusten_oneyear() {
		return r30_plusten_oneyear;
	}
	public void setR30_plusten_oneyear(BigDecimal r30_plusten_oneyear) {
		this.r30_plusten_oneyear = r30_plusten_oneyear;
	}
	public BigDecimal getR30_minusten_oneyear() {
		return r30_minusten_oneyear;
	}
	public void setR30_minusten_oneyear(BigDecimal r30_minusten_oneyear) {
		this.r30_minusten_oneyear = r30_minusten_oneyear;
	}
	public BigDecimal getR30_plusten_onetothreeyear() {
		return r30_plusten_onetothreeyear;
	}
	public void setR30_plusten_onetothreeyear(BigDecimal r30_plusten_onetothreeyear) {
		this.r30_plusten_onetothreeyear = r30_plusten_onetothreeyear;
	}
	public BigDecimal getR30_minusten_onetothreeyear() {
		return r30_minusten_onetothreeyear;
	}
	public void setR30_minusten_onetothreeyear(BigDecimal r30_minusten_onetothreeyear) {
		this.r30_minusten_onetothreeyear = r30_minusten_onetothreeyear;
	}
	public BigDecimal getR30_plusten_threeyear() {
		return r30_plusten_threeyear;
	}
	public void setR30_plusten_threeyear(BigDecimal r30_plusten_threeyear) {
		this.r30_plusten_threeyear = r30_plusten_threeyear;
	}
	public BigDecimal getR30_minusten_threeyear() {
		return r30_minusten_threeyear;
	}
	public void setR30_minusten_threeyear(BigDecimal r30_minusten_threeyear) {
		this.r30_minusten_threeyear = r30_minusten_threeyear;
	}
	public String getR31_currencies() {
		return r31_currencies;
	}
	public void setR31_currencies(String r31_currencies) {
		this.r31_currencies = r31_currencies;
	}
	public BigDecimal getR31_notational_amount() {
		return r31_notational_amount;
	}
	public void setR31_notational_amount(BigDecimal r31_notational_amount) {
		this.r31_notational_amount = r31_notational_amount;
	}
	public BigDecimal getR31_gross_market() {
		return r31_gross_market;
	}
	public void setR31_gross_market(BigDecimal r31_gross_market) {
		this.r31_gross_market = r31_gross_market;
	}
	public BigDecimal getR31_lessthan_oneyear() {
		return r31_lessthan_oneyear;
	}
	public void setR31_lessthan_oneyear(BigDecimal r31_lessthan_oneyear) {
		this.r31_lessthan_oneyear = r31_lessthan_oneyear;
	}
	public BigDecimal getR31_onetothree_year() {
		return r31_onetothree_year;
	}
	public void setR31_onetothree_year(BigDecimal r31_onetothree_year) {
		this.r31_onetothree_year = r31_onetothree_year;
	}
	public BigDecimal getR31_morethan_threeyear() {
		return r31_morethan_threeyear;
	}
	public void setR31_morethan_threeyear(BigDecimal r31_morethan_threeyear) {
		this.r31_morethan_threeyear = r31_morethan_threeyear;
	}
	public BigDecimal getR31_plusten_oneyear() {
		return r31_plusten_oneyear;
	}
	public void setR31_plusten_oneyear(BigDecimal r31_plusten_oneyear) {
		this.r31_plusten_oneyear = r31_plusten_oneyear;
	}
	public BigDecimal getR31_minusten_oneyear() {
		return r31_minusten_oneyear;
	}
	public void setR31_minusten_oneyear(BigDecimal r31_minusten_oneyear) {
		this.r31_minusten_oneyear = r31_minusten_oneyear;
	}
	public BigDecimal getR31_plusten_onetothreeyear() {
		return r31_plusten_onetothreeyear;
	}
	public void setR31_plusten_onetothreeyear(BigDecimal r31_plusten_onetothreeyear) {
		this.r31_plusten_onetothreeyear = r31_plusten_onetothreeyear;
	}
	public BigDecimal getR31_minusten_onetothreeyear() {
		return r31_minusten_onetothreeyear;
	}
	public void setR31_minusten_onetothreeyear(BigDecimal r31_minusten_onetothreeyear) {
		this.r31_minusten_onetothreeyear = r31_minusten_onetothreeyear;
	}
	public BigDecimal getR31_plusten_threeyear() {
		return r31_plusten_threeyear;
	}
	public void setR31_plusten_threeyear(BigDecimal r31_plusten_threeyear) {
		this.r31_plusten_threeyear = r31_plusten_threeyear;
	}
	public BigDecimal getR31_minusten_threeyear() {
		return r31_minusten_threeyear;
	}
	public void setR31_minusten_threeyear(BigDecimal r31_minusten_threeyear) {
		this.r31_minusten_threeyear = r31_minusten_threeyear;
	}
	public String getR32_currencies() {
		return r32_currencies;
	}
	public void setR32_currencies(String r32_currencies) {
		this.r32_currencies = r32_currencies;
	}
	public BigDecimal getR32_notational_amount() {
		return r32_notational_amount;
	}
	public void setR32_notational_amount(BigDecimal r32_notational_amount) {
		this.r32_notational_amount = r32_notational_amount;
	}
	public BigDecimal getR32_gross_market() {
		return r32_gross_market;
	}
	public void setR32_gross_market(BigDecimal r32_gross_market) {
		this.r32_gross_market = r32_gross_market;
	}
	public BigDecimal getR32_lessthan_oneyear() {
		return r32_lessthan_oneyear;
	}
	public void setR32_lessthan_oneyear(BigDecimal r32_lessthan_oneyear) {
		this.r32_lessthan_oneyear = r32_lessthan_oneyear;
	}
	public BigDecimal getR32_onetothree_year() {
		return r32_onetothree_year;
	}
	public void setR32_onetothree_year(BigDecimal r32_onetothree_year) {
		this.r32_onetothree_year = r32_onetothree_year;
	}
	public BigDecimal getR32_morethan_threeyear() {
		return r32_morethan_threeyear;
	}
	public void setR32_morethan_threeyear(BigDecimal r32_morethan_threeyear) {
		this.r32_morethan_threeyear = r32_morethan_threeyear;
	}
	public BigDecimal getR32_plusten_oneyear() {
		return r32_plusten_oneyear;
	}
	public void setR32_plusten_oneyear(BigDecimal r32_plusten_oneyear) {
		this.r32_plusten_oneyear = r32_plusten_oneyear;
	}
	public BigDecimal getR32_minusten_oneyear() {
		return r32_minusten_oneyear;
	}
	public void setR32_minusten_oneyear(BigDecimal r32_minusten_oneyear) {
		this.r32_minusten_oneyear = r32_minusten_oneyear;
	}
	public BigDecimal getR32_plusten_onetothreeyear() {
		return r32_plusten_onetothreeyear;
	}
	public void setR32_plusten_onetothreeyear(BigDecimal r32_plusten_onetothreeyear) {
		this.r32_plusten_onetothreeyear = r32_plusten_onetothreeyear;
	}
	public BigDecimal getR32_minusten_onetothreeyear() {
		return r32_minusten_onetothreeyear;
	}
	public void setR32_minusten_onetothreeyear(BigDecimal r32_minusten_onetothreeyear) {
		this.r32_minusten_onetothreeyear = r32_minusten_onetothreeyear;
	}
	public BigDecimal getR32_plusten_threeyear() {
		return r32_plusten_threeyear;
	}
	public void setR32_plusten_threeyear(BigDecimal r32_plusten_threeyear) {
		this.r32_plusten_threeyear = r32_plusten_threeyear;
	}
	public BigDecimal getR32_minusten_threeyear() {
		return r32_minusten_threeyear;
	}
	public void setR32_minusten_threeyear(BigDecimal r32_minusten_threeyear) {
		this.r32_minusten_threeyear = r32_minusten_threeyear;
	}
	public String getR33_currencies() {
		return r33_currencies;
	}
	public void setR33_currencies(String r33_currencies) {
		this.r33_currencies = r33_currencies;
	}
	public BigDecimal getR33_notational_amount() {
		return r33_notational_amount;
	}
	public void setR33_notational_amount(BigDecimal r33_notational_amount) {
		this.r33_notational_amount = r33_notational_amount;
	}
	public BigDecimal getR33_gross_market() {
		return r33_gross_market;
	}
	public void setR33_gross_market(BigDecimal r33_gross_market) {
		this.r33_gross_market = r33_gross_market;
	}
	public BigDecimal getR33_lessthan_oneyear() {
		return r33_lessthan_oneyear;
	}
	public void setR33_lessthan_oneyear(BigDecimal r33_lessthan_oneyear) {
		this.r33_lessthan_oneyear = r33_lessthan_oneyear;
	}
	public BigDecimal getR33_onetothree_year() {
		return r33_onetothree_year;
	}
	public void setR33_onetothree_year(BigDecimal r33_onetothree_year) {
		this.r33_onetothree_year = r33_onetothree_year;
	}
	public BigDecimal getR33_morethan_threeyear() {
		return r33_morethan_threeyear;
	}
	public void setR33_morethan_threeyear(BigDecimal r33_morethan_threeyear) {
		this.r33_morethan_threeyear = r33_morethan_threeyear;
	}
	public BigDecimal getR33_plusten_oneyear() {
		return r33_plusten_oneyear;
	}
	public void setR33_plusten_oneyear(BigDecimal r33_plusten_oneyear) {
		this.r33_plusten_oneyear = r33_plusten_oneyear;
	}
	public BigDecimal getR33_minusten_oneyear() {
		return r33_minusten_oneyear;
	}
	public void setR33_minusten_oneyear(BigDecimal r33_minusten_oneyear) {
		this.r33_minusten_oneyear = r33_minusten_oneyear;
	}
	public BigDecimal getR33_plusten_onetothreeyear() {
		return r33_plusten_onetothreeyear;
	}
	public void setR33_plusten_onetothreeyear(BigDecimal r33_plusten_onetothreeyear) {
		this.r33_plusten_onetothreeyear = r33_plusten_onetothreeyear;
	}
	public BigDecimal getR33_minusten_onetothreeyear() {
		return r33_minusten_onetothreeyear;
	}
	public void setR33_minusten_onetothreeyear(BigDecimal r33_minusten_onetothreeyear) {
		this.r33_minusten_onetothreeyear = r33_minusten_onetothreeyear;
	}
	public BigDecimal getR33_plusten_threeyear() {
		return r33_plusten_threeyear;
	}
	public void setR33_plusten_threeyear(BigDecimal r33_plusten_threeyear) {
		this.r33_plusten_threeyear = r33_plusten_threeyear;
	}
	public BigDecimal getR33_minusten_threeyear() {
		return r33_minusten_threeyear;
	}
	public void setR33_minusten_threeyear(BigDecimal r33_minusten_threeyear) {
		this.r33_minusten_threeyear = r33_minusten_threeyear;
	}
	public String getR34_currencies() {
		return r34_currencies;
	}
	public void setR34_currencies(String r34_currencies) {
		this.r34_currencies = r34_currencies;
	}
	public BigDecimal getR34_notational_amount() {
		return r34_notational_amount;
	}
	public void setR34_notational_amount(BigDecimal r34_notational_amount) {
		this.r34_notational_amount = r34_notational_amount;
	}
	public BigDecimal getR34_gross_market() {
		return r34_gross_market;
	}
	public void setR34_gross_market(BigDecimal r34_gross_market) {
		this.r34_gross_market = r34_gross_market;
	}
	public BigDecimal getR34_lessthan_oneyear() {
		return r34_lessthan_oneyear;
	}
	public void setR34_lessthan_oneyear(BigDecimal r34_lessthan_oneyear) {
		this.r34_lessthan_oneyear = r34_lessthan_oneyear;
	}
	public BigDecimal getR34_onetothree_year() {
		return r34_onetothree_year;
	}
	public void setR34_onetothree_year(BigDecimal r34_onetothree_year) {
		this.r34_onetothree_year = r34_onetothree_year;
	}
	public BigDecimal getR34_morethan_threeyear() {
		return r34_morethan_threeyear;
	}
	public void setR34_morethan_threeyear(BigDecimal r34_morethan_threeyear) {
		this.r34_morethan_threeyear = r34_morethan_threeyear;
	}
	public BigDecimal getR34_plusten_oneyear() {
		return r34_plusten_oneyear;
	}
	public void setR34_plusten_oneyear(BigDecimal r34_plusten_oneyear) {
		this.r34_plusten_oneyear = r34_plusten_oneyear;
	}
	public BigDecimal getR34_minusten_oneyear() {
		return r34_minusten_oneyear;
	}
	public void setR34_minusten_oneyear(BigDecimal r34_minusten_oneyear) {
		this.r34_minusten_oneyear = r34_minusten_oneyear;
	}
	public BigDecimal getR34_plusten_onetothreeyear() {
		return r34_plusten_onetothreeyear;
	}
	public void setR34_plusten_onetothreeyear(BigDecimal r34_plusten_onetothreeyear) {
		this.r34_plusten_onetothreeyear = r34_plusten_onetothreeyear;
	}
	public BigDecimal getR34_minusten_onetothreeyear() {
		return r34_minusten_onetothreeyear;
	}
	public void setR34_minusten_onetothreeyear(BigDecimal r34_minusten_onetothreeyear) {
		this.r34_minusten_onetothreeyear = r34_minusten_onetothreeyear;
	}
	public BigDecimal getR34_plusten_threeyear() {
		return r34_plusten_threeyear;
	}
	public void setR34_plusten_threeyear(BigDecimal r34_plusten_threeyear) {
		this.r34_plusten_threeyear = r34_plusten_threeyear;
	}
	public BigDecimal getR34_minusten_threeyear() {
		return r34_minusten_threeyear;
	}
	public void setR34_minusten_threeyear(BigDecimal r34_minusten_threeyear) {
		this.r34_minusten_threeyear = r34_minusten_threeyear;
	}
	public String getR35_currencies() {
		return r35_currencies;
	}
	public void setR35_currencies(String r35_currencies) {
		this.r35_currencies = r35_currencies;
	}
	public BigDecimal getR35_notational_amount() {
		return r35_notational_amount;
	}
	public void setR35_notational_amount(BigDecimal r35_notational_amount) {
		this.r35_notational_amount = r35_notational_amount;
	}
	public BigDecimal getR35_gross_market() {
		return r35_gross_market;
	}
	public void setR35_gross_market(BigDecimal r35_gross_market) {
		this.r35_gross_market = r35_gross_market;
	}
	public BigDecimal getR35_lessthan_oneyear() {
		return r35_lessthan_oneyear;
	}
	public void setR35_lessthan_oneyear(BigDecimal r35_lessthan_oneyear) {
		this.r35_lessthan_oneyear = r35_lessthan_oneyear;
	}
	public BigDecimal getR35_onetothree_year() {
		return r35_onetothree_year;
	}
	public void setR35_onetothree_year(BigDecimal r35_onetothree_year) {
		this.r35_onetothree_year = r35_onetothree_year;
	}
	public BigDecimal getR35_morethan_threeyear() {
		return r35_morethan_threeyear;
	}
	public void setR35_morethan_threeyear(BigDecimal r35_morethan_threeyear) {
		this.r35_morethan_threeyear = r35_morethan_threeyear;
	}
	public BigDecimal getR35_plusten_oneyear() {
		return r35_plusten_oneyear;
	}
	public void setR35_plusten_oneyear(BigDecimal r35_plusten_oneyear) {
		this.r35_plusten_oneyear = r35_plusten_oneyear;
	}
	public BigDecimal getR35_minusten_oneyear() {
		return r35_minusten_oneyear;
	}
	public void setR35_minusten_oneyear(BigDecimal r35_minusten_oneyear) {
		this.r35_minusten_oneyear = r35_minusten_oneyear;
	}
	public BigDecimal getR35_plusten_onetothreeyear() {
		return r35_plusten_onetothreeyear;
	}
	public void setR35_plusten_onetothreeyear(BigDecimal r35_plusten_onetothreeyear) {
		this.r35_plusten_onetothreeyear = r35_plusten_onetothreeyear;
	}
	public BigDecimal getR35_minusten_onetothreeyear() {
		return r35_minusten_onetothreeyear;
	}
	public void setR35_minusten_onetothreeyear(BigDecimal r35_minusten_onetothreeyear) {
		this.r35_minusten_onetothreeyear = r35_minusten_onetothreeyear;
	}
	public BigDecimal getR35_plusten_threeyear() {
		return r35_plusten_threeyear;
	}
	public void setR35_plusten_threeyear(BigDecimal r35_plusten_threeyear) {
		this.r35_plusten_threeyear = r35_plusten_threeyear;
	}
	public BigDecimal getR35_minusten_threeyear() {
		return r35_minusten_threeyear;
	}
	public void setR35_minusten_threeyear(BigDecimal r35_minusten_threeyear) {
		this.r35_minusten_threeyear = r35_minusten_threeyear;
	}
	public String getR36_currencies() {
		return r36_currencies;
	}
	public void setR36_currencies(String r36_currencies) {
		this.r36_currencies = r36_currencies;
	}
	public BigDecimal getR36_notational_amount() {
		return r36_notational_amount;
	}
	public void setR36_notational_amount(BigDecimal r36_notational_amount) {
		this.r36_notational_amount = r36_notational_amount;
	}
	public BigDecimal getR36_gross_market() {
		return r36_gross_market;
	}
	public void setR36_gross_market(BigDecimal r36_gross_market) {
		this.r36_gross_market = r36_gross_market;
	}
	public BigDecimal getR36_lessthan_oneyear() {
		return r36_lessthan_oneyear;
	}
	public void setR36_lessthan_oneyear(BigDecimal r36_lessthan_oneyear) {
		this.r36_lessthan_oneyear = r36_lessthan_oneyear;
	}
	public BigDecimal getR36_onetothree_year() {
		return r36_onetothree_year;
	}
	public void setR36_onetothree_year(BigDecimal r36_onetothree_year) {
		this.r36_onetothree_year = r36_onetothree_year;
	}
	public BigDecimal getR36_morethan_threeyear() {
		return r36_morethan_threeyear;
	}
	public void setR36_morethan_threeyear(BigDecimal r36_morethan_threeyear) {
		this.r36_morethan_threeyear = r36_morethan_threeyear;
	}
	public BigDecimal getR36_plusten_oneyear() {
		return r36_plusten_oneyear;
	}
	public void setR36_plusten_oneyear(BigDecimal r36_plusten_oneyear) {
		this.r36_plusten_oneyear = r36_plusten_oneyear;
	}
	public BigDecimal getR36_minusten_oneyear() {
		return r36_minusten_oneyear;
	}
	public void setR36_minusten_oneyear(BigDecimal r36_minusten_oneyear) {
		this.r36_minusten_oneyear = r36_minusten_oneyear;
	}
	public BigDecimal getR36_plusten_onetothreeyear() {
		return r36_plusten_onetothreeyear;
	}
	public void setR36_plusten_onetothreeyear(BigDecimal r36_plusten_onetothreeyear) {
		this.r36_plusten_onetothreeyear = r36_plusten_onetothreeyear;
	}
	public BigDecimal getR36_minusten_onetothreeyear() {
		return r36_minusten_onetothreeyear;
	}
	public void setR36_minusten_onetothreeyear(BigDecimal r36_minusten_onetothreeyear) {
		this.r36_minusten_onetothreeyear = r36_minusten_onetothreeyear;
	}
	public BigDecimal getR36_plusten_threeyear() {
		return r36_plusten_threeyear;
	}
	public void setR36_plusten_threeyear(BigDecimal r36_plusten_threeyear) {
		this.r36_plusten_threeyear = r36_plusten_threeyear;
	}
	public BigDecimal getR36_minusten_threeyear() {
		return r36_minusten_threeyear;
	}
	public void setR36_minusten_threeyear(BigDecimal r36_minusten_threeyear) {
		this.r36_minusten_threeyear = r36_minusten_threeyear;
	}
	public String getR37_currencies() {
		return r37_currencies;
	}
	public void setR37_currencies(String r37_currencies) {
		this.r37_currencies = r37_currencies;
	}
	public BigDecimal getR37_notational_amount() {
		return r37_notational_amount;
	}
	public void setR37_notational_amount(BigDecimal r37_notational_amount) {
		this.r37_notational_amount = r37_notational_amount;
	}
	public BigDecimal getR37_gross_market() {
		return r37_gross_market;
	}
	public void setR37_gross_market(BigDecimal r37_gross_market) {
		this.r37_gross_market = r37_gross_market;
	}
	public BigDecimal getR37_lessthan_oneyear() {
		return r37_lessthan_oneyear;
	}
	public void setR37_lessthan_oneyear(BigDecimal r37_lessthan_oneyear) {
		this.r37_lessthan_oneyear = r37_lessthan_oneyear;
	}
	public BigDecimal getR37_onetothree_year() {
		return r37_onetothree_year;
	}
	public void setR37_onetothree_year(BigDecimal r37_onetothree_year) {
		this.r37_onetothree_year = r37_onetothree_year;
	}
	public BigDecimal getR37_morethan_threeyear() {
		return r37_morethan_threeyear;
	}
	public void setR37_morethan_threeyear(BigDecimal r37_morethan_threeyear) {
		this.r37_morethan_threeyear = r37_morethan_threeyear;
	}
	public BigDecimal getR37_plusten_oneyear() {
		return r37_plusten_oneyear;
	}
	public void setR37_plusten_oneyear(BigDecimal r37_plusten_oneyear) {
		this.r37_plusten_oneyear = r37_plusten_oneyear;
	}
	public BigDecimal getR37_minusten_oneyear() {
		return r37_minusten_oneyear;
	}
	public void setR37_minusten_oneyear(BigDecimal r37_minusten_oneyear) {
		this.r37_minusten_oneyear = r37_minusten_oneyear;
	}
	public BigDecimal getR37_plusten_onetothreeyear() {
		return r37_plusten_onetothreeyear;
	}
	public void setR37_plusten_onetothreeyear(BigDecimal r37_plusten_onetothreeyear) {
		this.r37_plusten_onetothreeyear = r37_plusten_onetothreeyear;
	}
	public BigDecimal getR37_minusten_onetothreeyear() {
		return r37_minusten_onetothreeyear;
	}
	public void setR37_minusten_onetothreeyear(BigDecimal r37_minusten_onetothreeyear) {
		this.r37_minusten_onetothreeyear = r37_minusten_onetothreeyear;
	}
	public BigDecimal getR37_plusten_threeyear() {
		return r37_plusten_threeyear;
	}
	public void setR37_plusten_threeyear(BigDecimal r37_plusten_threeyear) {
		this.r37_plusten_threeyear = r37_plusten_threeyear;
	}
	public BigDecimal getR37_minusten_threeyear() {
		return r37_minusten_threeyear;
	}
	public void setR37_minusten_threeyear(BigDecimal r37_minusten_threeyear) {
		this.r37_minusten_threeyear = r37_minusten_threeyear;
	}
	public String getR38_currencies() {
		return r38_currencies;
	}
	public void setR38_currencies(String r38_currencies) {
		this.r38_currencies = r38_currencies;
	}
	public BigDecimal getR38_notational_amount() {
		return r38_notational_amount;
	}
	public void setR38_notational_amount(BigDecimal r38_notational_amount) {
		this.r38_notational_amount = r38_notational_amount;
	}
	public BigDecimal getR38_gross_market() {
		return r38_gross_market;
	}
	public void setR38_gross_market(BigDecimal r38_gross_market) {
		this.r38_gross_market = r38_gross_market;
	}
	public BigDecimal getR38_lessthan_oneyear() {
		return r38_lessthan_oneyear;
	}
	public void setR38_lessthan_oneyear(BigDecimal r38_lessthan_oneyear) {
		this.r38_lessthan_oneyear = r38_lessthan_oneyear;
	}
	public BigDecimal getR38_onetothree_year() {
		return r38_onetothree_year;
	}
	public void setR38_onetothree_year(BigDecimal r38_onetothree_year) {
		this.r38_onetothree_year = r38_onetothree_year;
	}
	public BigDecimal getR38_morethan_threeyear() {
		return r38_morethan_threeyear;
	}
	public void setR38_morethan_threeyear(BigDecimal r38_morethan_threeyear) {
		this.r38_morethan_threeyear = r38_morethan_threeyear;
	}
	public BigDecimal getR38_plusten_oneyear() {
		return r38_plusten_oneyear;
	}
	public void setR38_plusten_oneyear(BigDecimal r38_plusten_oneyear) {
		this.r38_plusten_oneyear = r38_plusten_oneyear;
	}
	public BigDecimal getR38_minusten_oneyear() {
		return r38_minusten_oneyear;
	}
	public void setR38_minusten_oneyear(BigDecimal r38_minusten_oneyear) {
		this.r38_minusten_oneyear = r38_minusten_oneyear;
	}
	public BigDecimal getR38_plusten_onetothreeyear() {
		return r38_plusten_onetothreeyear;
	}
	public void setR38_plusten_onetothreeyear(BigDecimal r38_plusten_onetothreeyear) {
		this.r38_plusten_onetothreeyear = r38_plusten_onetothreeyear;
	}
	public BigDecimal getR38_minusten_onetothreeyear() {
		return r38_minusten_onetothreeyear;
	}
	public void setR38_minusten_onetothreeyear(BigDecimal r38_minusten_onetothreeyear) {
		this.r38_minusten_onetothreeyear = r38_minusten_onetothreeyear;
	}
	public BigDecimal getR38_plusten_threeyear() {
		return r38_plusten_threeyear;
	}
	public void setR38_plusten_threeyear(BigDecimal r38_plusten_threeyear) {
		this.r38_plusten_threeyear = r38_plusten_threeyear;
	}
	public BigDecimal getR38_minusten_threeyear() {
		return r38_minusten_threeyear;
	}
	public void setR38_minusten_threeyear(BigDecimal r38_minusten_threeyear) {
		this.r38_minusten_threeyear = r38_minusten_threeyear;
	}
	public String getR39_currencies() {
		return r39_currencies;
	}
	public void setR39_currencies(String r39_currencies) {
		this.r39_currencies = r39_currencies;
	}
	public BigDecimal getR39_notational_amount() {
		return r39_notational_amount;
	}
	public void setR39_notational_amount(BigDecimal r39_notational_amount) {
		this.r39_notational_amount = r39_notational_amount;
	}
	public BigDecimal getR39_gross_market() {
		return r39_gross_market;
	}
	public void setR39_gross_market(BigDecimal r39_gross_market) {
		this.r39_gross_market = r39_gross_market;
	}
	public BigDecimal getR39_lessthan_oneyear() {
		return r39_lessthan_oneyear;
	}
	public void setR39_lessthan_oneyear(BigDecimal r39_lessthan_oneyear) {
		this.r39_lessthan_oneyear = r39_lessthan_oneyear;
	}
	public BigDecimal getR39_onetothree_year() {
		return r39_onetothree_year;
	}
	public void setR39_onetothree_year(BigDecimal r39_onetothree_year) {
		this.r39_onetothree_year = r39_onetothree_year;
	}
	public BigDecimal getR39_morethan_threeyear() {
		return r39_morethan_threeyear;
	}
	public void setR39_morethan_threeyear(BigDecimal r39_morethan_threeyear) {
		this.r39_morethan_threeyear = r39_morethan_threeyear;
	}
	public BigDecimal getR39_plusten_oneyear() {
		return r39_plusten_oneyear;
	}
	public void setR39_plusten_oneyear(BigDecimal r39_plusten_oneyear) {
		this.r39_plusten_oneyear = r39_plusten_oneyear;
	}
	public BigDecimal getR39_minusten_oneyear() {
		return r39_minusten_oneyear;
	}
	public void setR39_minusten_oneyear(BigDecimal r39_minusten_oneyear) {
		this.r39_minusten_oneyear = r39_minusten_oneyear;
	}
	public BigDecimal getR39_plusten_onetothreeyear() {
		return r39_plusten_onetothreeyear;
	}
	public void setR39_plusten_onetothreeyear(BigDecimal r39_plusten_onetothreeyear) {
		this.r39_plusten_onetothreeyear = r39_plusten_onetothreeyear;
	}
	public BigDecimal getR39_minusten_onetothreeyear() {
		return r39_minusten_onetothreeyear;
	}
	public void setR39_minusten_onetothreeyear(BigDecimal r39_minusten_onetothreeyear) {
		this.r39_minusten_onetothreeyear = r39_minusten_onetothreeyear;
	}
	public BigDecimal getR39_plusten_threeyear() {
		return r39_plusten_threeyear;
	}
	public void setR39_plusten_threeyear(BigDecimal r39_plusten_threeyear) {
		this.r39_plusten_threeyear = r39_plusten_threeyear;
	}
	public BigDecimal getR39_minusten_threeyear() {
		return r39_minusten_threeyear;
	}
	public void setR39_minusten_threeyear(BigDecimal r39_minusten_threeyear) {
		this.r39_minusten_threeyear = r39_minusten_threeyear;
	}
	public String getR40_currencies() {
		return r40_currencies;
	}
	public void setR40_currencies(String r40_currencies) {
		this.r40_currencies = r40_currencies;
	}
	public BigDecimal getR40_notational_amount() {
		return r40_notational_amount;
	}
	public void setR40_notational_amount(BigDecimal r40_notational_amount) {
		this.r40_notational_amount = r40_notational_amount;
	}
	public BigDecimal getR40_gross_market() {
		return r40_gross_market;
	}
	public void setR40_gross_market(BigDecimal r40_gross_market) {
		this.r40_gross_market = r40_gross_market;
	}
	public BigDecimal getR40_lessthan_oneyear() {
		return r40_lessthan_oneyear;
	}
	public void setR40_lessthan_oneyear(BigDecimal r40_lessthan_oneyear) {
		this.r40_lessthan_oneyear = r40_lessthan_oneyear;
	}
	public BigDecimal getR40_onetothree_year() {
		return r40_onetothree_year;
	}
	public void setR40_onetothree_year(BigDecimal r40_onetothree_year) {
		this.r40_onetothree_year = r40_onetothree_year;
	}
	public BigDecimal getR40_morethan_threeyear() {
		return r40_morethan_threeyear;
	}
	public void setR40_morethan_threeyear(BigDecimal r40_morethan_threeyear) {
		this.r40_morethan_threeyear = r40_morethan_threeyear;
	}
	public BigDecimal getR40_plusten_oneyear() {
		return r40_plusten_oneyear;
	}
	public void setR40_plusten_oneyear(BigDecimal r40_plusten_oneyear) {
		this.r40_plusten_oneyear = r40_plusten_oneyear;
	}
	public BigDecimal getR40_minusten_oneyear() {
		return r40_minusten_oneyear;
	}
	public void setR40_minusten_oneyear(BigDecimal r40_minusten_oneyear) {
		this.r40_minusten_oneyear = r40_minusten_oneyear;
	}
	public BigDecimal getR40_plusten_onetothreeyear() {
		return r40_plusten_onetothreeyear;
	}
	public void setR40_plusten_onetothreeyear(BigDecimal r40_plusten_onetothreeyear) {
		this.r40_plusten_onetothreeyear = r40_plusten_onetothreeyear;
	}
	public BigDecimal getR40_minusten_onetothreeyear() {
		return r40_minusten_onetothreeyear;
	}
	public void setR40_minusten_onetothreeyear(BigDecimal r40_minusten_onetothreeyear) {
		this.r40_minusten_onetothreeyear = r40_minusten_onetothreeyear;
	}
	public BigDecimal getR40_plusten_threeyear() {
		return r40_plusten_threeyear;
	}
	public void setR40_plusten_threeyear(BigDecimal r40_plusten_threeyear) {
		this.r40_plusten_threeyear = r40_plusten_threeyear;
	}
	public BigDecimal getR40_minusten_threeyear() {
		return r40_minusten_threeyear;
	}
	public void setR40_minusten_threeyear(BigDecimal r40_minusten_threeyear) {
		this.r40_minusten_threeyear = r40_minusten_threeyear;
	}
	public String getR41_currencies() {
		return r41_currencies;
	}
	public void setR41_currencies(String r41_currencies) {
		this.r41_currencies = r41_currencies;
	}
	public BigDecimal getR41_notational_amount() {
		return r41_notational_amount;
	}
	public void setR41_notational_amount(BigDecimal r41_notational_amount) {
		this.r41_notational_amount = r41_notational_amount;
	}
	public BigDecimal getR41_gross_market() {
		return r41_gross_market;
	}
	public void setR41_gross_market(BigDecimal r41_gross_market) {
		this.r41_gross_market = r41_gross_market;
	}
	public BigDecimal getR41_lessthan_oneyear() {
		return r41_lessthan_oneyear;
	}
	public void setR41_lessthan_oneyear(BigDecimal r41_lessthan_oneyear) {
		this.r41_lessthan_oneyear = r41_lessthan_oneyear;
	}
	public BigDecimal getR41_onetothree_year() {
		return r41_onetothree_year;
	}
	public void setR41_onetothree_year(BigDecimal r41_onetothree_year) {
		this.r41_onetothree_year = r41_onetothree_year;
	}
	public BigDecimal getR41_morethan_threeyear() {
		return r41_morethan_threeyear;
	}
	public void setR41_morethan_threeyear(BigDecimal r41_morethan_threeyear) {
		this.r41_morethan_threeyear = r41_morethan_threeyear;
	}
	public BigDecimal getR41_plusten_oneyear() {
		return r41_plusten_oneyear;
	}
	public void setR41_plusten_oneyear(BigDecimal r41_plusten_oneyear) {
		this.r41_plusten_oneyear = r41_plusten_oneyear;
	}
	public BigDecimal getR41_minusten_oneyear() {
		return r41_minusten_oneyear;
	}
	public void setR41_minusten_oneyear(BigDecimal r41_minusten_oneyear) {
		this.r41_minusten_oneyear = r41_minusten_oneyear;
	}
	public BigDecimal getR41_plusten_onetothreeyear() {
		return r41_plusten_onetothreeyear;
	}
	public void setR41_plusten_onetothreeyear(BigDecimal r41_plusten_onetothreeyear) {
		this.r41_plusten_onetothreeyear = r41_plusten_onetothreeyear;
	}
	public BigDecimal getR41_minusten_onetothreeyear() {
		return r41_minusten_onetothreeyear;
	}
	public void setR41_minusten_onetothreeyear(BigDecimal r41_minusten_onetothreeyear) {
		this.r41_minusten_onetothreeyear = r41_minusten_onetothreeyear;
	}
	public BigDecimal getR41_plusten_threeyear() {
		return r41_plusten_threeyear;
	}
	public void setR41_plusten_threeyear(BigDecimal r41_plusten_threeyear) {
		this.r41_plusten_threeyear = r41_plusten_threeyear;
	}
	public BigDecimal getR41_minusten_threeyear() {
		return r41_minusten_threeyear;
	}
	public void setR41_minusten_threeyear(BigDecimal r41_minusten_threeyear) {
		this.r41_minusten_threeyear = r41_minusten_threeyear;
	}
	public String getR42_currencies() {
		return r42_currencies;
	}
	public void setR42_currencies(String r42_currencies) {
		this.r42_currencies = r42_currencies;
	}
	public BigDecimal getR42_notational_amount() {
		return r42_notational_amount;
	}
	public void setR42_notational_amount(BigDecimal r42_notational_amount) {
		this.r42_notational_amount = r42_notational_amount;
	}
	public BigDecimal getR42_gross_market() {
		return r42_gross_market;
	}
	public void setR42_gross_market(BigDecimal r42_gross_market) {
		this.r42_gross_market = r42_gross_market;
	}
	public BigDecimal getR42_lessthan_oneyear() {
		return r42_lessthan_oneyear;
	}
	public void setR42_lessthan_oneyear(BigDecimal r42_lessthan_oneyear) {
		this.r42_lessthan_oneyear = r42_lessthan_oneyear;
	}
	public BigDecimal getR42_onetothree_year() {
		return r42_onetothree_year;
	}
	public void setR42_onetothree_year(BigDecimal r42_onetothree_year) {
		this.r42_onetothree_year = r42_onetothree_year;
	}
	public BigDecimal getR42_morethan_threeyear() {
		return r42_morethan_threeyear;
	}
	public void setR42_morethan_threeyear(BigDecimal r42_morethan_threeyear) {
		this.r42_morethan_threeyear = r42_morethan_threeyear;
	}
	public BigDecimal getR42_plusten_oneyear() {
		return r42_plusten_oneyear;
	}
	public void setR42_plusten_oneyear(BigDecimal r42_plusten_oneyear) {
		this.r42_plusten_oneyear = r42_plusten_oneyear;
	}
	public BigDecimal getR42_minusten_oneyear() {
		return r42_minusten_oneyear;
	}
	public void setR42_minusten_oneyear(BigDecimal r42_minusten_oneyear) {
		this.r42_minusten_oneyear = r42_minusten_oneyear;
	}
	public BigDecimal getR42_plusten_onetothreeyear() {
		return r42_plusten_onetothreeyear;
	}
	public void setR42_plusten_onetothreeyear(BigDecimal r42_plusten_onetothreeyear) {
		this.r42_plusten_onetothreeyear = r42_plusten_onetothreeyear;
	}
	public BigDecimal getR42_minusten_onetothreeyear() {
		return r42_minusten_onetothreeyear;
	}
	public void setR42_minusten_onetothreeyear(BigDecimal r42_minusten_onetothreeyear) {
		this.r42_minusten_onetothreeyear = r42_minusten_onetothreeyear;
	}
	public BigDecimal getR42_plusten_threeyear() {
		return r42_plusten_threeyear;
	}
	public void setR42_plusten_threeyear(BigDecimal r42_plusten_threeyear) {
		this.r42_plusten_threeyear = r42_plusten_threeyear;
	}
	public BigDecimal getR42_minusten_threeyear() {
		return r42_minusten_threeyear;
	}
	public void setR42_minusten_threeyear(BigDecimal r42_minusten_threeyear) {
		this.r42_minusten_threeyear = r42_minusten_threeyear;
	}
	public String getR43_currencies() {
		return r43_currencies;
	}
	public void setR43_currencies(String r43_currencies) {
		this.r43_currencies = r43_currencies;
	}
	public BigDecimal getR43_notational_amount() {
		return r43_notational_amount;
	}
	public void setR43_notational_amount(BigDecimal r43_notational_amount) {
		this.r43_notational_amount = r43_notational_amount;
	}
	public BigDecimal getR43_gross_market() {
		return r43_gross_market;
	}
	public void setR43_gross_market(BigDecimal r43_gross_market) {
		this.r43_gross_market = r43_gross_market;
	}
	public BigDecimal getR43_lessthan_oneyear() {
		return r43_lessthan_oneyear;
	}
	public void setR43_lessthan_oneyear(BigDecimal r43_lessthan_oneyear) {
		this.r43_lessthan_oneyear = r43_lessthan_oneyear;
	}
	public BigDecimal getR43_onetothree_year() {
		return r43_onetothree_year;
	}
	public void setR43_onetothree_year(BigDecimal r43_onetothree_year) {
		this.r43_onetothree_year = r43_onetothree_year;
	}
	public BigDecimal getR43_morethan_threeyear() {
		return r43_morethan_threeyear;
	}
	public void setR43_morethan_threeyear(BigDecimal r43_morethan_threeyear) {
		this.r43_morethan_threeyear = r43_morethan_threeyear;
	}
	public BigDecimal getR43_plusten_oneyear() {
		return r43_plusten_oneyear;
	}
	public void setR43_plusten_oneyear(BigDecimal r43_plusten_oneyear) {
		this.r43_plusten_oneyear = r43_plusten_oneyear;
	}
	public BigDecimal getR43_minusten_oneyear() {
		return r43_minusten_oneyear;
	}
	public void setR43_minusten_oneyear(BigDecimal r43_minusten_oneyear) {
		this.r43_minusten_oneyear = r43_minusten_oneyear;
	}
	public BigDecimal getR43_plusten_onetothreeyear() {
		return r43_plusten_onetothreeyear;
	}
	public void setR43_plusten_onetothreeyear(BigDecimal r43_plusten_onetothreeyear) {
		this.r43_plusten_onetothreeyear = r43_plusten_onetothreeyear;
	}
	public BigDecimal getR43_minusten_onetothreeyear() {
		return r43_minusten_onetothreeyear;
	}
	public void setR43_minusten_onetothreeyear(BigDecimal r43_minusten_onetothreeyear) {
		this.r43_minusten_onetothreeyear = r43_minusten_onetothreeyear;
	}
	public BigDecimal getR43_plusten_threeyear() {
		return r43_plusten_threeyear;
	}
	public void setR43_plusten_threeyear(BigDecimal r43_plusten_threeyear) {
		this.r43_plusten_threeyear = r43_plusten_threeyear;
	}
	public BigDecimal getR43_minusten_threeyear() {
		return r43_minusten_threeyear;
	}
	public void setR43_minusten_threeyear(BigDecimal r43_minusten_threeyear) {
		this.r43_minusten_threeyear = r43_minusten_threeyear;
	}
	public String getR44_currencies() {
		return r44_currencies;
	}
	public void setR44_currencies(String r44_currencies) {
		this.r44_currencies = r44_currencies;
	}
	public BigDecimal getR44_notational_amount() {
		return r44_notational_amount;
	}
	public void setR44_notational_amount(BigDecimal r44_notational_amount) {
		this.r44_notational_amount = r44_notational_amount;
	}
	public BigDecimal getR44_gross_market() {
		return r44_gross_market;
	}
	public void setR44_gross_market(BigDecimal r44_gross_market) {
		this.r44_gross_market = r44_gross_market;
	}
	public BigDecimal getR44_lessthan_oneyear() {
		return r44_lessthan_oneyear;
	}
	public void setR44_lessthan_oneyear(BigDecimal r44_lessthan_oneyear) {
		this.r44_lessthan_oneyear = r44_lessthan_oneyear;
	}
	public BigDecimal getR44_onetothree_year() {
		return r44_onetothree_year;
	}
	public void setR44_onetothree_year(BigDecimal r44_onetothree_year) {
		this.r44_onetothree_year = r44_onetothree_year;
	}
	public BigDecimal getR44_morethan_threeyear() {
		return r44_morethan_threeyear;
	}
	public void setR44_morethan_threeyear(BigDecimal r44_morethan_threeyear) {
		this.r44_morethan_threeyear = r44_morethan_threeyear;
	}
	public BigDecimal getR44_plusten_oneyear() {
		return r44_plusten_oneyear;
	}
	public void setR44_plusten_oneyear(BigDecimal r44_plusten_oneyear) {
		this.r44_plusten_oneyear = r44_plusten_oneyear;
	}
	public BigDecimal getR44_minusten_oneyear() {
		return r44_minusten_oneyear;
	}
	public void setR44_minusten_oneyear(BigDecimal r44_minusten_oneyear) {
		this.r44_minusten_oneyear = r44_minusten_oneyear;
	}
	public BigDecimal getR44_plusten_onetothreeyear() {
		return r44_plusten_onetothreeyear;
	}
	public void setR44_plusten_onetothreeyear(BigDecimal r44_plusten_onetothreeyear) {
		this.r44_plusten_onetothreeyear = r44_plusten_onetothreeyear;
	}
	public BigDecimal getR44_minusten_onetothreeyear() {
		return r44_minusten_onetothreeyear;
	}
	public void setR44_minusten_onetothreeyear(BigDecimal r44_minusten_onetothreeyear) {
		this.r44_minusten_onetothreeyear = r44_minusten_onetothreeyear;
	}
	public BigDecimal getR44_plusten_threeyear() {
		return r44_plusten_threeyear;
	}
	public void setR44_plusten_threeyear(BigDecimal r44_plusten_threeyear) {
		this.r44_plusten_threeyear = r44_plusten_threeyear;
	}
	public BigDecimal getR44_minusten_threeyear() {
		return r44_minusten_threeyear;
	}
	public void setR44_minusten_threeyear(BigDecimal r44_minusten_threeyear) {
		this.r44_minusten_threeyear = r44_minusten_threeyear;
	}
	public String getR45_currencies() {
		return r45_currencies;
	}
	public void setR45_currencies(String r45_currencies) {
		this.r45_currencies = r45_currencies;
	}
	public BigDecimal getR45_notational_amount() {
		return r45_notational_amount;
	}
	public void setR45_notational_amount(BigDecimal r45_notational_amount) {
		this.r45_notational_amount = r45_notational_amount;
	}
	public BigDecimal getR45_gross_market() {
		return r45_gross_market;
	}
	public void setR45_gross_market(BigDecimal r45_gross_market) {
		this.r45_gross_market = r45_gross_market;
	}
	public BigDecimal getR45_lessthan_oneyear() {
		return r45_lessthan_oneyear;
	}
	public void setR45_lessthan_oneyear(BigDecimal r45_lessthan_oneyear) {
		this.r45_lessthan_oneyear = r45_lessthan_oneyear;
	}
	public BigDecimal getR45_onetothree_year() {
		return r45_onetothree_year;
	}
	public void setR45_onetothree_year(BigDecimal r45_onetothree_year) {
		this.r45_onetothree_year = r45_onetothree_year;
	}
	public BigDecimal getR45_morethan_threeyear() {
		return r45_morethan_threeyear;
	}
	public void setR45_morethan_threeyear(BigDecimal r45_morethan_threeyear) {
		this.r45_morethan_threeyear = r45_morethan_threeyear;
	}
	public BigDecimal getR45_plusten_oneyear() {
		return r45_plusten_oneyear;
	}
	public void setR45_plusten_oneyear(BigDecimal r45_plusten_oneyear) {
		this.r45_plusten_oneyear = r45_plusten_oneyear;
	}
	public BigDecimal getR45_minusten_oneyear() {
		return r45_minusten_oneyear;
	}
	public void setR45_minusten_oneyear(BigDecimal r45_minusten_oneyear) {
		this.r45_minusten_oneyear = r45_minusten_oneyear;
	}
	public BigDecimal getR45_plusten_onetothreeyear() {
		return r45_plusten_onetothreeyear;
	}
	public void setR45_plusten_onetothreeyear(BigDecimal r45_plusten_onetothreeyear) {
		this.r45_plusten_onetothreeyear = r45_plusten_onetothreeyear;
	}
	public BigDecimal getR45_minusten_onetothreeyear() {
		return r45_minusten_onetothreeyear;
	}
	public void setR45_minusten_onetothreeyear(BigDecimal r45_minusten_onetothreeyear) {
		this.r45_minusten_onetothreeyear = r45_minusten_onetothreeyear;
	}
	public BigDecimal getR45_plusten_threeyear() {
		return r45_plusten_threeyear;
	}
	public void setR45_plusten_threeyear(BigDecimal r45_plusten_threeyear) {
		this.r45_plusten_threeyear = r45_plusten_threeyear;
	}
	public BigDecimal getR45_minusten_threeyear() {
		return r45_minusten_threeyear;
	}
	public void setR45_minusten_threeyear(BigDecimal r45_minusten_threeyear) {
		this.r45_minusten_threeyear = r45_minusten_threeyear;
	}
	public String getR46_currencies() {
		return r46_currencies;
	}
	public void setR46_currencies(String r46_currencies) {
		this.r46_currencies = r46_currencies;
	}
	public BigDecimal getR46_notational_amount() {
		return r46_notational_amount;
	}
	public void setR46_notational_amount(BigDecimal r46_notational_amount) {
		this.r46_notational_amount = r46_notational_amount;
	}
	public BigDecimal getR46_gross_market() {
		return r46_gross_market;
	}
	public void setR46_gross_market(BigDecimal r46_gross_market) {
		this.r46_gross_market = r46_gross_market;
	}
	public BigDecimal getR46_lessthan_oneyear() {
		return r46_lessthan_oneyear;
	}
	public void setR46_lessthan_oneyear(BigDecimal r46_lessthan_oneyear) {
		this.r46_lessthan_oneyear = r46_lessthan_oneyear;
	}
	public BigDecimal getR46_onetothree_year() {
		return r46_onetothree_year;
	}
	public void setR46_onetothree_year(BigDecimal r46_onetothree_year) {
		this.r46_onetothree_year = r46_onetothree_year;
	}
	public BigDecimal getR46_morethan_threeyear() {
		return r46_morethan_threeyear;
	}
	public void setR46_morethan_threeyear(BigDecimal r46_morethan_threeyear) {
		this.r46_morethan_threeyear = r46_morethan_threeyear;
	}
	public BigDecimal getR46_plusten_oneyear() {
		return r46_plusten_oneyear;
	}
	public void setR46_plusten_oneyear(BigDecimal r46_plusten_oneyear) {
		this.r46_plusten_oneyear = r46_plusten_oneyear;
	}
	public BigDecimal getR46_minusten_oneyear() {
		return r46_minusten_oneyear;
	}
	public void setR46_minusten_oneyear(BigDecimal r46_minusten_oneyear) {
		this.r46_minusten_oneyear = r46_minusten_oneyear;
	}
	public BigDecimal getR46_plusten_onetothreeyear() {
		return r46_plusten_onetothreeyear;
	}
	public void setR46_plusten_onetothreeyear(BigDecimal r46_plusten_onetothreeyear) {
		this.r46_plusten_onetothreeyear = r46_plusten_onetothreeyear;
	}
	public BigDecimal getR46_minusten_onetothreeyear() {
		return r46_minusten_onetothreeyear;
	}
	public void setR46_minusten_onetothreeyear(BigDecimal r46_minusten_onetothreeyear) {
		this.r46_minusten_onetothreeyear = r46_minusten_onetothreeyear;
	}
	public BigDecimal getR46_plusten_threeyear() {
		return r46_plusten_threeyear;
	}
	public void setR46_plusten_threeyear(BigDecimal r46_plusten_threeyear) {
		this.r46_plusten_threeyear = r46_plusten_threeyear;
	}
	public BigDecimal getR46_minusten_threeyear() {
		return r46_minusten_threeyear;
	}
	public void setR46_minusten_threeyear(BigDecimal r46_minusten_threeyear) {
		this.r46_minusten_threeyear = r46_minusten_threeyear;
	}
	public String getR47_currencies() {
		return r47_currencies;
	}
	public void setR47_currencies(String r47_currencies) {
		this.r47_currencies = r47_currencies;
	}
	public BigDecimal getR47_notational_amount() {
		return r47_notational_amount;
	}
	public void setR47_notational_amount(BigDecimal r47_notational_amount) {
		this.r47_notational_amount = r47_notational_amount;
	}
	public BigDecimal getR47_gross_market() {
		return r47_gross_market;
	}
	public void setR47_gross_market(BigDecimal r47_gross_market) {
		this.r47_gross_market = r47_gross_market;
	}
	public BigDecimal getR47_lessthan_oneyear() {
		return r47_lessthan_oneyear;
	}
	public void setR47_lessthan_oneyear(BigDecimal r47_lessthan_oneyear) {
		this.r47_lessthan_oneyear = r47_lessthan_oneyear;
	}
	public BigDecimal getR47_onetothree_year() {
		return r47_onetothree_year;
	}
	public void setR47_onetothree_year(BigDecimal r47_onetothree_year) {
		this.r47_onetothree_year = r47_onetothree_year;
	}
	public BigDecimal getR47_morethan_threeyear() {
		return r47_morethan_threeyear;
	}
	public void setR47_morethan_threeyear(BigDecimal r47_morethan_threeyear) {
		this.r47_morethan_threeyear = r47_morethan_threeyear;
	}
	public BigDecimal getR47_plusten_oneyear() {
		return r47_plusten_oneyear;
	}
	public void setR47_plusten_oneyear(BigDecimal r47_plusten_oneyear) {
		this.r47_plusten_oneyear = r47_plusten_oneyear;
	}
	public BigDecimal getR47_minusten_oneyear() {
		return r47_minusten_oneyear;
	}
	public void setR47_minusten_oneyear(BigDecimal r47_minusten_oneyear) {
		this.r47_minusten_oneyear = r47_minusten_oneyear;
	}
	public BigDecimal getR47_plusten_onetothreeyear() {
		return r47_plusten_onetothreeyear;
	}
	public void setR47_plusten_onetothreeyear(BigDecimal r47_plusten_onetothreeyear) {
		this.r47_plusten_onetothreeyear = r47_plusten_onetothreeyear;
	}
	public BigDecimal getR47_minusten_onetothreeyear() {
		return r47_minusten_onetothreeyear;
	}
	public void setR47_minusten_onetothreeyear(BigDecimal r47_minusten_onetothreeyear) {
		this.r47_minusten_onetothreeyear = r47_minusten_onetothreeyear;
	}
	public BigDecimal getR47_plusten_threeyear() {
		return r47_plusten_threeyear;
	}
	public void setR47_plusten_threeyear(BigDecimal r47_plusten_threeyear) {
		this.r47_plusten_threeyear = r47_plusten_threeyear;
	}
	public BigDecimal getR47_minusten_threeyear() {
		return r47_minusten_threeyear;
	}
	public void setR47_minusten_threeyear(BigDecimal r47_minusten_threeyear) {
		this.r47_minusten_threeyear = r47_minusten_threeyear;
	}
	public String getR48_currencies() {
		return r48_currencies;
	}
	public void setR48_currencies(String r48_currencies) {
		this.r48_currencies = r48_currencies;
	}
	public BigDecimal getR48_notational_amount() {
		return r48_notational_amount;
	}
	public void setR48_notational_amount(BigDecimal r48_notational_amount) {
		this.r48_notational_amount = r48_notational_amount;
	}
	public BigDecimal getR48_gross_market() {
		return r48_gross_market;
	}
	public void setR48_gross_market(BigDecimal r48_gross_market) {
		this.r48_gross_market = r48_gross_market;
	}
	public BigDecimal getR48_lessthan_oneyear() {
		return r48_lessthan_oneyear;
	}
	public void setR48_lessthan_oneyear(BigDecimal r48_lessthan_oneyear) {
		this.r48_lessthan_oneyear = r48_lessthan_oneyear;
	}
	public BigDecimal getR48_onetothree_year() {
		return r48_onetothree_year;
	}
	public void setR48_onetothree_year(BigDecimal r48_onetothree_year) {
		this.r48_onetothree_year = r48_onetothree_year;
	}
	public BigDecimal getR48_morethan_threeyear() {
		return r48_morethan_threeyear;
	}
	public void setR48_morethan_threeyear(BigDecimal r48_morethan_threeyear) {
		this.r48_morethan_threeyear = r48_morethan_threeyear;
	}
	public BigDecimal getR48_plusten_oneyear() {
		return r48_plusten_oneyear;
	}
	public void setR48_plusten_oneyear(BigDecimal r48_plusten_oneyear) {
		this.r48_plusten_oneyear = r48_plusten_oneyear;
	}
	public BigDecimal getR48_minusten_oneyear() {
		return r48_minusten_oneyear;
	}
	public void setR48_minusten_oneyear(BigDecimal r48_minusten_oneyear) {
		this.r48_minusten_oneyear = r48_minusten_oneyear;
	}
	public BigDecimal getR48_plusten_onetothreeyear() {
		return r48_plusten_onetothreeyear;
	}
	public void setR48_plusten_onetothreeyear(BigDecimal r48_plusten_onetothreeyear) {
		this.r48_plusten_onetothreeyear = r48_plusten_onetothreeyear;
	}
	public BigDecimal getR48_minusten_onetothreeyear() {
		return r48_minusten_onetothreeyear;
	}
	public void setR48_minusten_onetothreeyear(BigDecimal r48_minusten_onetothreeyear) {
		this.r48_minusten_onetothreeyear = r48_minusten_onetothreeyear;
	}
	public BigDecimal getR48_plusten_threeyear() {
		return r48_plusten_threeyear;
	}
	public void setR48_plusten_threeyear(BigDecimal r48_plusten_threeyear) {
		this.r48_plusten_threeyear = r48_plusten_threeyear;
	}
	public BigDecimal getR48_minusten_threeyear() {
		return r48_minusten_threeyear;
	}
	public void setR48_minusten_threeyear(BigDecimal r48_minusten_threeyear) {
		this.r48_minusten_threeyear = r48_minusten_threeyear;
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
	public BRF153ReportEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}