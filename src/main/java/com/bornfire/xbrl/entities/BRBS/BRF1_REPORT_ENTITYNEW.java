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
@Table(name = "BRF1_NEW")
public class BRF1_REPORT_ENTITYNEW {

	private String r1_product;
	private BigDecimal r1_no_acct_aed_resident;
	private BigDecimal r1_amount_aed_resident;
	private BigDecimal r1_no_acct_fcy_resident;
	private BigDecimal r1_amount_fcy_resident;
	private BigDecimal r1_no_acct_aed_non_resident;
	private BigDecimal r1_amount_aed_non_resident;
	private BigDecimal r1_no_acct_fcy_non_resident;
	private BigDecimal r1_amount_fcy_non_resident;
	private BigDecimal r1_total_amount;
	private String r2_product;
	private BigDecimal r2_no_acct_aed_resident;
	private BigDecimal r2_amount_aed_resident;
	private BigDecimal r2_no_acct_fcy_resident;
	private BigDecimal r2_amount_fcy_resident;
	private BigDecimal r2_no_acct_aed_non_resident;
	private BigDecimal r2_amount_aed_non_resident;
	private BigDecimal r2_no_acct_fcy_non_resident;
	private BigDecimal r2_amount_fcy_non_resident;
	private BigDecimal r2_total_amount;
	private String r3_product;
	private BigDecimal r3_no_acct_aed_resident;
	private BigDecimal r3_amount_aed_resident;
	private BigDecimal r3_no_acct_fcy_resident;
	private BigDecimal r3_amount_fcy_resident;
	private BigDecimal r3_no_acct_aed_non_resident;
	private BigDecimal r3_amount_aed_non_resident;
	private BigDecimal r3_no_acct_fcy_non_resident;
	private BigDecimal r3_amount_fcy_non_resident;
	private BigDecimal r3_total_amount;
	private String r4_product;
	private BigDecimal r4_no_acct_aed_resident;
	private BigDecimal r4_amount_aed_resident;
	private BigDecimal r4_no_acct_fcy_resident;
	private BigDecimal r4_amount_fcy_resident;
	private BigDecimal r4_no_acct_aed_non_resident;
	private BigDecimal r4_amount_aed_non_resident;
	private BigDecimal r4_no_acct_fcy_non_resident;
	private BigDecimal r4_amount_fcy_non_resident;
	private BigDecimal r4_total_amount;
	private String r5_product;
	private BigDecimal r5_no_acct_aed_resident;
	private BigDecimal r5_amount_aed_resident;
	private BigDecimal r5_no_acct_fcy_resident;
	private BigDecimal r5_amount_fcy_resident;
	private BigDecimal r5_no_acct_aed_non_resident;
	private BigDecimal r5_amount_aed_non_resident;
	private BigDecimal r5_no_acct_fcy_non_resident;
	private BigDecimal r5_amount_fcy_non_resident;
	private BigDecimal r5_total_amount;
	private String r6_product;
	private BigDecimal r6_no_acct_aed_resident;
	private BigDecimal r6_amount_aed_resident;
	private BigDecimal r6_no_acct_fcy_resident;
	private BigDecimal r6_amount_fcy_resident;
	private BigDecimal r6_no_acct_aed_non_resident;
	private BigDecimal r6_amount_aed_non_resident;
	private BigDecimal r6_no_acct_fcy_non_resident;
	private BigDecimal r6_amount_fcy_non_resident;
	private BigDecimal r6_total_amount;
	private String r7_product;
	private BigDecimal r7_no_acct_aed_resident;
	private BigDecimal r7_amount_aed_resident;
	private BigDecimal r7_no_acct_fcy_resident;
	private BigDecimal r7_amount_fcy_resident;
	private BigDecimal r7_no_acct_aed_non_resident;
	private BigDecimal r7_amount_aed_non_resident;
	private BigDecimal r7_no_acct_fcy_non_resident;
	private BigDecimal r7_amount_fcy_non_resident;
	private BigDecimal r7_total_amount;
	private String r8_product;
	private BigDecimal r8_no_acct_aed_resident;
	private BigDecimal r8_amount_aed_resident;
	private BigDecimal r8_no_acct_fcy_resident;
	private BigDecimal r8_amount_fcy_resident;
	private BigDecimal r8_no_acct_aed_non_resident;
	private BigDecimal r8_amount_aed_non_resident;
	private BigDecimal r8_no_acct_fcy_non_resident;
	private BigDecimal r8_amount_fcy_non_resident;
	private BigDecimal r8_total_amount;
	private String r9_product;
	private BigDecimal r9_no_acct_aed_resident;
	private BigDecimal r9_amount_aed_resident;
	private BigDecimal r9_no_acct_fcy_resident;
	private BigDecimal r9_amount_fcy_resident;
	private BigDecimal r9_no_acct_aed_non_resident;
	private BigDecimal r9_amount_aed_non_resident;
	private BigDecimal r9_no_acct_fcy_non_resident;
	private BigDecimal r9_amount_fcy_non_resident;
	private BigDecimal r9_total_amount;
	private String r10_product;
	private BigDecimal r10_no_acct_aed_resident;
	private BigDecimal r10_amount_aed_resident;
	private BigDecimal r10_no_acct_fcy_resident;
	private BigDecimal r10_amount_fcy_resident;
	private BigDecimal r10_no_acct_aed_non_resident;
	private BigDecimal r10_amount_aed_non_resident;
	private BigDecimal r10_no_acct_fcy_non_resident;
	private BigDecimal r10_amount_fcy_non_resident;
	private BigDecimal r10_total_amount;
	private String r11_product;
	private BigDecimal r11_no_acct_aed_resident;
	private BigDecimal r11_amount_aed_resident;
	private BigDecimal r11_no_acct_fcy_resident;
	private BigDecimal r11_amount_fcy_resident;
	private BigDecimal r11_no_acct_aed_non_resident;
	private BigDecimal r11_amount_aed_non_resident;
	private BigDecimal r11_no_acct_fcy_non_resident;
	private BigDecimal r11_amount_fcy_non_resident;
	private BigDecimal r11_total_amount;
	private String r12_product;
	private BigDecimal r12_no_acct_aed_resident;
	private BigDecimal r12_amount_aed_resident;
	private BigDecimal r12_no_acct_fcy_resident;
	private BigDecimal r12_amount_fcy_resident;
	private BigDecimal r12_no_acct_aed_non_resident;
	private BigDecimal r12_amount_aed_non_resident;
	private BigDecimal r12_no_acct_fcy_non_resident;
	private BigDecimal r12_amount_fcy_non_resident;
	private BigDecimal r12_total_amount;
	private String r13_product;
	private BigDecimal r13_no_acct_aed_resident;
	private BigDecimal r13_amount_aed_resident;
	private BigDecimal r13_no_acct_fcy_resident;
	private BigDecimal r13_amount_fcy_resident;
	private BigDecimal r13_no_acct_aed_non_resident;
	private BigDecimal r13_amount_aed_non_resident;
	private BigDecimal r13_no_acct_fcy_non_resident;
	private BigDecimal r13_amount_fcy_non_resident;
	private BigDecimal r13_total_amount;
	private String r14_product;
	private BigDecimal r14_no_acct_aed_resident;
	private BigDecimal r14_amount_aed_resident;
	private BigDecimal r14_no_acct_fcy_resident;
	private BigDecimal r14_amount_fcy_resident;
	private BigDecimal r14_no_acct_aed_non_resident;
	private BigDecimal r14_amount_aed_non_resident;
	private BigDecimal r14_no_acct_fcy_non_resident;
	private BigDecimal r14_amount_fcy_non_resident;
	private BigDecimal r14_total_amount;
	private String r15_product;
	private BigDecimal r15_no_acct_aed_resident;
	private BigDecimal r15_amount_aed_resident;
	private BigDecimal r15_no_acct_fcy_resident;
	private BigDecimal r15_amount_fcy_resident;
	private BigDecimal r15_no_acct_aed_non_resident;
	private BigDecimal r15_amount_aed_non_resident;
	private BigDecimal r15_no_acct_fcy_non_resident;
	private BigDecimal r15_amount_fcy_non_resident;
	private BigDecimal r15_total_amount;
	private String r16_product;
	private BigDecimal r16_no_acct_aed_resident;
	private BigDecimal r16_amount_aed_resident;
	private BigDecimal r16_no_acct_fcy_resident;
	private BigDecimal r16_amount_fcy_resident;
	private BigDecimal r16_no_acct_aed_non_resident;
	private BigDecimal r16_amount_aed_non_resident;
	private BigDecimal r16_no_acct_fcy_non_resident;
	private BigDecimal r16_amount_fcy_non_resident;
	private BigDecimal r16_total_amount;
	private String r17_product;
	private BigDecimal r17_no_acct_aed_resident;
	private BigDecimal r17_amount_aed_resident;
	private BigDecimal r17_no_acct_fcy_resident;
	private BigDecimal r17_amount_fcy_resident;
	private BigDecimal r17_no_acct_aed_non_resident;
	private BigDecimal r17_amount_aed_non_resident;
	private BigDecimal r17_no_acct_fcy_non_resident;
	private BigDecimal r17_amount_fcy_non_resident;
	private BigDecimal r17_total_amount;
	private String r18_product;
	private BigDecimal r18_no_acct_aed_resident;
	private BigDecimal r18_amount_aed_resident;
	private BigDecimal r18_no_acct_fcy_resident;
	private BigDecimal r18_amount_fcy_resident;
	private BigDecimal r18_no_acct_aed_non_resident;
	private BigDecimal r18_amount_aed_non_resident;
	private BigDecimal r18_no_acct_fcy_non_resident;
	private BigDecimal r18_amount_fcy_non_resident;
	private BigDecimal r18_total_amount;
	private String r19_product;
	private BigDecimal r19_no_acct_aed_resident;
	private BigDecimal r19_amount_aed_resident;
	private BigDecimal r19_no_acct_fcy_resident;
	private BigDecimal r19_amount_fcy_resident;
	private BigDecimal r19_no_acct_aed_non_resident;
	private BigDecimal r19_amount_aed_non_resident;
	private BigDecimal r19_no_acct_fcy_non_resident;
	private BigDecimal r19_amount_fcy_non_resident;
	private BigDecimal r19_total_amount;
	private String r20_product;
	private BigDecimal r20_no_acct_aed_resident;
	private BigDecimal r20_amount_aed_resident;
	private BigDecimal r20_no_acct_fcy_resident;
	private BigDecimal r20_amount_fcy_resident;
	private BigDecimal r20_no_acct_aed_non_resident;
	private BigDecimal r20_amount_aed_non_resident;
	private BigDecimal r20_no_acct_fcy_non_resident;
	private BigDecimal r20_amount_fcy_non_resident;
	private BigDecimal r20_total_amount;
	private String r21_product;
	private BigDecimal r21_no_acct_aed_resident;
	private BigDecimal r21_amount_aed_resident;
	private BigDecimal r21_no_acct_fcy_resident;
	private BigDecimal r21_amount_fcy_resident;
	private BigDecimal r21_no_acct_aed_non_resident;
	private BigDecimal r21_amount_aed_non_resident;
	private BigDecimal r21_no_acct_fcy_non_resident;
	private BigDecimal r21_amount_fcy_non_resident;
	private BigDecimal r21_total_amount;
	private String r22_product;
	private BigDecimal r22_no_acct_aed_resident;
	private BigDecimal r22_amount_aed_resident;
	private BigDecimal r22_no_acct_fcy_resident;
	private BigDecimal r22_amount_fcy_resident;
	private BigDecimal r22_no_acct_aed_non_resident;
	private BigDecimal r22_amount_aed_non_resident;
	private BigDecimal r22_no_acct_fcy_non_resident;
	private BigDecimal r22_amount_fcy_non_resident;
	private BigDecimal r22_total_amount;
	private String r23_product;
	private BigDecimal r23_no_acct_aed_resident;
	private BigDecimal r23_amount_aed_resident;
	private BigDecimal r23_no_acct_fcy_resident;
	private BigDecimal r23_amount_fcy_resident;
	private BigDecimal r23_no_acct_aed_non_resident;
	private BigDecimal r23_amount_aed_non_resident;
	private BigDecimal r23_no_acct_fcy_non_resident;
	private BigDecimal r23_amount_fcy_non_resident;
	private BigDecimal r23_total_amount;
	private String r24_product;
	private BigDecimal r24_no_acct_aed_resident;
	private BigDecimal r24_amount_aed_resident;
	private BigDecimal r24_no_acct_fcy_resident;
	private BigDecimal r24_amount_fcy_resident;
	private BigDecimal r24_no_acct_aed_non_resident;
	private BigDecimal r24_amount_aed_non_resident;
	private BigDecimal r24_no_acct_fcy_non_resident;
	private BigDecimal r24_amount_fcy_non_resident;
	private BigDecimal r24_total_amount;
	private String r25_product;
	private BigDecimal r25_no_acct_aed_resident;
	private BigDecimal r25_amount_aed_resident;
	private BigDecimal r25_no_acct_fcy_resident;
	private BigDecimal r25_amount_fcy_resident;
	private BigDecimal r25_no_acct_aed_non_resident;
	private BigDecimal r25_amount_aed_non_resident;
	private BigDecimal r25_no_acct_fcy_non_resident;
	private BigDecimal r25_amount_fcy_non_resident;
	private BigDecimal r25_total_amount;
	private String r26_product;
	private BigDecimal r26_no_acct_aed_resident;
	private BigDecimal r26_amount_aed_resident;
	private BigDecimal r26_no_acct_fcy_resident;
	private BigDecimal r26_amount_fcy_resident;
	private BigDecimal r26_no_acct_aed_non_resident;
	private BigDecimal r26_amount_aed_non_resident;
	private BigDecimal r26_no_acct_fcy_non_resident;
	private BigDecimal r26_amount_fcy_non_resident;
	private BigDecimal r26_total_amount;
	private String r27_product;
	private BigDecimal r27_no_acct_aed_resident;
	private BigDecimal r27_amount_aed_resident;
	private BigDecimal r27_no_acct_fcy_resident;
	private BigDecimal r27_amount_fcy_resident;
	private BigDecimal r27_no_acct_aed_non_resident;
	private BigDecimal r27_amount_aed_non_resident;
	private BigDecimal r27_no_acct_fcy_non_resident;
	private BigDecimal r27_amount_fcy_non_resident;
	private BigDecimal r27_total_amount;
	private String r28_product;
	private BigDecimal r28_no_acct_aed_resident;
	private BigDecimal r28_amount_aed_resident;
	private BigDecimal r28_no_acct_fcy_resident;
	private BigDecimal r28_amount_fcy_resident;
	private BigDecimal r28_no_acct_aed_non_resident;
	private BigDecimal r28_amount_aed_non_resident;
	private BigDecimal r28_no_acct_fcy_non_resident;
	private BigDecimal r28_amount_fcy_non_resident;
	private BigDecimal r28_total_amount;
	private String r29_product;
	private BigDecimal r29_no_acct_aed_resident;
	private BigDecimal r29_amount_aed_resident;
	private BigDecimal r29_no_acct_fcy_resident;
	private BigDecimal r29_amount_fcy_resident;
	private BigDecimal r29_no_acct_aed_non_resident;
	private BigDecimal r29_amount_aed_non_resident;
	private BigDecimal r29_no_acct_fcy_non_resident;
	private BigDecimal r29_amount_fcy_non_resident;
	private BigDecimal r29_total_amount;
	private String r30_product;
	private BigDecimal r30_no_acct_aed_resident;
	private BigDecimal r30_amount_aed_resident;
	private BigDecimal r30_no_acct_fcy_resident;
	private BigDecimal r30_amount_fcy_resident;
	private BigDecimal r30_no_acct_aed_non_resident;
	private BigDecimal r30_amount_aed_non_resident;
	private BigDecimal r30_no_acct_fcy_non_resident;
	private BigDecimal r30_amount_fcy_non_resident;
	private BigDecimal r30_total_amount;
	private String r31_product;
	private BigDecimal r31_no_acct_aed_resident;
	private BigDecimal r31_amount_aed_resident;
	private BigDecimal r31_no_acct_fcy_resident;
	private BigDecimal r31_amount_fcy_resident;
	private BigDecimal r31_no_acct_aed_non_resident;
	private BigDecimal r31_amount_aed_non_resident;
	private BigDecimal r31_no_acct_fcy_non_resident;
	private BigDecimal r31_amount_fcy_non_resident;
	private BigDecimal r31_total_amount;
	private String r32_product;
	private BigDecimal r32_no_acct_aed_resident;
	private BigDecimal r32_amount_aed_resident;
	private BigDecimal r32_no_acct_fcy_resident;
	private BigDecimal r32_amount_fcy_resident;
	private BigDecimal r32_no_acct_aed_non_resident;
	private BigDecimal r32_amount_aed_non_resident;
	private BigDecimal r32_no_acct_fcy_non_resident;
	private BigDecimal r32_amount_fcy_non_resident;
	private BigDecimal r32_total_amount;
	private String r33_product;
	private BigDecimal r33_no_acct_aed_resident;
	private BigDecimal r33_amount_aed_resident;
	private BigDecimal r33_no_acct_fcy_resident;
	private BigDecimal r33_amount_fcy_resident;
	private BigDecimal r33_no_acct_aed_non_resident;
	private BigDecimal r33_amount_aed_non_resident;
	private BigDecimal r33_no_acct_fcy_non_resident;
	private BigDecimal r33_amount_fcy_non_resident;
	private BigDecimal r33_total_amount;
	private String r34_product;
	private BigDecimal r34_no_acct_aed_resident;
	private BigDecimal r34_amount_aed_resident;
	private BigDecimal r34_no_acct_fcy_resident;
	private BigDecimal r34_amount_fcy_resident;
	private BigDecimal r34_no_acct_aed_non_resident;
	private BigDecimal r34_amount_aed_non_resident;
	private BigDecimal r34_no_acct_fcy_non_resident;
	private BigDecimal r34_amount_fcy_non_resident;
	private BigDecimal r34_total_amount;
	private String r35_product;
	private BigDecimal r35_no_acct_aed_resident;
	private BigDecimal r35_amount_aed_resident;
	private BigDecimal r35_no_acct_fcy_resident;
	private BigDecimal r35_amount_fcy_resident;
	private BigDecimal r35_no_acct_aed_non_resident;
	private BigDecimal r35_amount_aed_non_resident;
	private BigDecimal r35_no_acct_fcy_non_resident;
	private BigDecimal r35_amount_fcy_non_resident;
	private BigDecimal r35_total_amount;
	private String r36_product;
	private BigDecimal r36_no_acct_aed_resident;
	private BigDecimal r36_amount_aed_resident;
	private BigDecimal r36_no_acct_fcy_resident;
	private BigDecimal r36_amount_fcy_resident;
	private BigDecimal r36_no_acct_aed_non_resident;
	private BigDecimal r36_amount_aed_non_resident;
	private BigDecimal r36_no_acct_fcy_non_resident;
	private BigDecimal r36_amount_fcy_non_resident;
	private BigDecimal r36_total_amount;
	private String r37_product;
	private BigDecimal r37_no_acct_aed_resident;
	private BigDecimal r37_amount_aed_resident;
	private BigDecimal r37_no_acct_fcy_resident;
	private BigDecimal r37_amount_fcy_resident;
	private BigDecimal r37_no_acct_aed_non_resident;
	private BigDecimal r37_amount_aed_non_resident;
	private BigDecimal r37_no_acct_fcy_non_resident;
	private BigDecimal r37_amount_fcy_non_resident;
	private BigDecimal r37_total_amount;
	private String r38_product;
	private BigDecimal r38_no_acct_aed_resident;
	private BigDecimal r38_amount_aed_resident;
	private BigDecimal r38_no_acct_fcy_resident;
	private BigDecimal r38_amount_fcy_resident;
	private BigDecimal r38_no_acct_aed_non_resident;
	private BigDecimal r38_amount_aed_non_resident;
	private BigDecimal r38_no_acct_fcy_non_resident;
	private BigDecimal r38_amount_fcy_non_resident;
	private BigDecimal r38_total_amount;
	private String r39_product;
	private BigDecimal r39_no_acct_aed_resident;
	private BigDecimal r39_amount_aed_resident;
	private BigDecimal r39_no_acct_fcy_resident;
	private BigDecimal r39_amount_fcy_resident;
	private BigDecimal r39_no_acct_aed_non_resident;
	private BigDecimal r39_amount_aed_non_resident;
	private BigDecimal r39_no_acct_fcy_non_resident;
	private BigDecimal r39_amount_fcy_non_resident;
	private BigDecimal r39_total_amount;
	private String r40_product;
	private BigDecimal r40_no_acct_aed_resident;
	private BigDecimal r40_amount_aed_resident;
	private BigDecimal r40_no_acct_fcy_resident;
	private BigDecimal r40_amount_fcy_resident;
	private BigDecimal r40_no_acct_aed_non_resident;
	private BigDecimal r40_amount_aed_non_resident;
	private BigDecimal r40_no_acct_fcy_non_resident;
	private BigDecimal r40_amount_fcy_non_resident;
	private BigDecimal r40_total_amount;
	private String r41_product;
	private BigDecimal r41_no_acct_aed_resident;
	private BigDecimal r41_amount_aed_resident;
	private BigDecimal r41_no_acct_fcy_resident;
	private BigDecimal r41_amount_fcy_resident;
	private BigDecimal r41_no_acct_aed_non_resident;
	private BigDecimal r41_amount_aed_non_resident;
	private BigDecimal r41_no_acct_fcy_non_resident;
	private BigDecimal r41_amount_fcy_non_resident;
	private BigDecimal r41_total_amount;
	private String r42_product;
	private BigDecimal r42_no_acct_aed_resident;
	private BigDecimal r42_amount_aed_resident;
	private BigDecimal r42_no_acct_fcy_resident;
	private BigDecimal r42_amount_fcy_resident;
	private BigDecimal r42_no_acct_aed_non_resident;
	private BigDecimal r42_amount_aed_non_resident;
	private BigDecimal r42_no_acct_fcy_non_resident;
	private BigDecimal r42_amount_fcy_non_resident;
	private BigDecimal r42_total_amount;
	private String r43_product;
	private BigDecimal r43_no_acct_aed_resident;
	private BigDecimal r43_amount_aed_resident;
	private BigDecimal r43_no_acct_fcy_resident;
	private BigDecimal r43_amount_fcy_resident;
	private BigDecimal r43_no_acct_aed_non_resident;
	private BigDecimal r43_amount_aed_non_resident;
	private BigDecimal r43_no_acct_fcy_non_resident;
	private BigDecimal r43_amount_fcy_non_resident;
	private BigDecimal r43_total_amount;
	private String r44_product;
	private BigDecimal r44_no_acct_aed_resident;
	private BigDecimal r44_amount_aed_resident;
	private BigDecimal r44_no_acct_fcy_resident;
	private BigDecimal r44_amount_fcy_resident;
	private BigDecimal r44_no_acct_aed_non_resident;
	private BigDecimal r44_amount_aed_non_resident;
	private BigDecimal r44_no_acct_fcy_non_resident;
	private BigDecimal r44_amount_fcy_non_resident;
	private BigDecimal r44_total_amount;
	private String r45_product;
	private BigDecimal r45_no_acct_aed_resident;
	private BigDecimal r45_amount_aed_resident;
	private BigDecimal r45_no_acct_fcy_resident;
	private BigDecimal r45_amount_fcy_resident;
	private BigDecimal r45_no_acct_aed_non_resident;
	private BigDecimal r45_amount_aed_non_resident;
	private BigDecimal r45_no_acct_fcy_non_resident;
	private BigDecimal r45_amount_fcy_non_resident;
	private BigDecimal r45_total_amount;
	private String r46_product;
	private BigDecimal r46_no_acct_aed_resident;
	private BigDecimal r46_amount_aed_resident;
	private BigDecimal r46_no_acct_fcy_resident;
	private BigDecimal r46_amount_fcy_resident;
	private BigDecimal r46_no_acct_aed_non_resident;
	private BigDecimal r46_amount_aed_non_resident;
	private BigDecimal r46_no_acct_fcy_non_resident;
	private BigDecimal r46_amount_fcy_non_resident;
	private BigDecimal r46_total_amount;
	private String r47_product;
	private BigDecimal r47_no_acct_aed_resident;
	private BigDecimal r47_amount_aed_resident;
	private BigDecimal r47_no_acct_fcy_resident;
	private BigDecimal r47_amount_fcy_resident;
	private BigDecimal r47_no_acct_aed_non_resident;
	private BigDecimal r47_amount_aed_non_resident;
	private BigDecimal r47_no_acct_fcy_non_resident;
	private BigDecimal r47_amount_fcy_non_resident;
	private BigDecimal r47_total_amount;
	private String r48_product;
	private BigDecimal r48_no_acct_aed_resident;
	private BigDecimal r48_amount_aed_resident;
	private BigDecimal r48_no_acct_fcy_resident;
	private BigDecimal r48_amount_fcy_resident;
	private BigDecimal r48_no_acct_aed_non_resident;
	private BigDecimal r48_amount_aed_non_resident;
	private BigDecimal r48_no_acct_fcy_non_resident;
	private BigDecimal r48_amount_fcy_non_resident;
	private BigDecimal r48_total_amount;
	private String r49_product;
	private BigDecimal r49_no_acct_aed_resident;
	private BigDecimal r49_amount_aed_resident;
	private BigDecimal r49_no_acct_fcy_resident;
	private BigDecimal r49_amount_fcy_resident;
	private BigDecimal r49_no_acct_aed_non_resident;
	private BigDecimal r49_amount_aed_non_resident;
	private BigDecimal r49_no_acct_fcy_non_resident;
	private BigDecimal r49_amount_fcy_non_resident;
	private BigDecimal r49_total_amount;
	private String r50_product;
	private BigDecimal r50_no_acct_aed_resident;
	private BigDecimal r50_amount_aed_resident;
	private BigDecimal r50_no_acct_fcy_resident;
	private BigDecimal r50_amount_fcy_resident;
	private BigDecimal r50_no_acct_aed_non_resident;
	private BigDecimal r50_amount_aed_non_resident;
	private BigDecimal r50_no_acct_fcy_non_resident;
	private BigDecimal r50_amount_fcy_non_resident;
	private BigDecimal r50_total_amount;
	private String r51_product;
	private BigDecimal r51_no_acct_aed_resident;
	private BigDecimal r51_amount_aed_resident;
	private BigDecimal r51_no_acct_fcy_resident;
	private BigDecimal r51_amount_fcy_resident;
	private BigDecimal r51_no_acct_aed_non_resident;
	private BigDecimal r51_amount_aed_non_resident;
	private BigDecimal r51_no_acct_fcy_non_resident;
	private BigDecimal r51_amount_fcy_non_resident;
	private BigDecimal r51_total_amount;
	private String r52_product;
	private BigDecimal r52_no_acct_aed_resident;
	private BigDecimal r52_amount_aed_resident;
	private BigDecimal r52_no_acct_fcy_resident;
	private BigDecimal r52_amount_fcy_resident;
	private BigDecimal r52_no_acct_aed_non_resident;
	private BigDecimal r52_amount_aed_non_resident;
	private BigDecimal r52_no_acct_fcy_non_resident;
	private BigDecimal r52_amount_fcy_non_resident;
	private BigDecimal r52_total_amount;
	private String r53_product;
	private BigDecimal r53_no_acct_aed_resident;
	private BigDecimal r53_amount_aed_resident;
	private BigDecimal r53_no_acct_fcy_resident;
	private BigDecimal r53_amount_fcy_resident;
	private BigDecimal r53_no_acct_aed_non_resident;
	private BigDecimal r53_amount_aed_non_resident;
	private BigDecimal r53_no_acct_fcy_non_resident;
	private BigDecimal r53_amount_fcy_non_resident;
	private BigDecimal r53_total_amount;
	private String r54_product;
	private BigDecimal r54_no_acct_aed_resident;
	private BigDecimal r54_amount_aed_resident;
	private BigDecimal r54_no_acct_fcy_resident;
	private BigDecimal r54_amount_fcy_resident;
	private BigDecimal r54_no_acct_aed_non_resident;
	private BigDecimal r54_amount_aed_non_resident;
	private BigDecimal r54_no_acct_fcy_non_resident;
	private BigDecimal r54_amount_fcy_non_resident;
	private BigDecimal r54_total_amount;
	private String r55_product;
	private BigDecimal r55_no_acct_aed_resident;
	private BigDecimal r55_amount_aed_resident;
	private BigDecimal r55_no_acct_fcy_resident;
	private BigDecimal r55_amount_fcy_resident;
	private BigDecimal r55_no_acct_aed_non_resident;
	private BigDecimal r55_amount_aed_non_resident;
	private BigDecimal r55_no_acct_fcy_non_resident;
	private BigDecimal r55_amount_fcy_non_resident;
	private BigDecimal r55_total_amount;
	private String r56_product;
	private BigDecimal r56_no_acct_aed_resident;
	private BigDecimal r56_amount_aed_resident;
	private BigDecimal r56_no_acct_fcy_resident;
	private BigDecimal r56_amount_fcy_resident;
	private BigDecimal r56_no_acct_aed_non_resident;
	private BigDecimal r56_amount_aed_non_resident;
	private BigDecimal r56_no_acct_fcy_non_resident;
	private BigDecimal r56_amount_fcy_non_resident;
	private BigDecimal r56_total_amount;
	private String r57_product;
	private BigDecimal r57_no_acct_aed_resident;
	private BigDecimal r57_amount_aed_resident;
	private BigDecimal r57_no_acct_fcy_resident;
	private BigDecimal r57_amount_fcy_resident;
	private BigDecimal r57_no_acct_aed_non_resident;
	private BigDecimal r57_amount_aed_non_resident;
	private BigDecimal r57_no_acct_fcy_non_resident;
	private BigDecimal r57_amount_fcy_non_resident;
	private BigDecimal r57_total_amount;
	private String r58_product;
	private BigDecimal r58_no_acct_aed_resident;
	private BigDecimal r58_amount_aed_resident;
	private BigDecimal r58_no_acct_fcy_resident;
	private BigDecimal r58_amount_fcy_resident;
	private BigDecimal r58_no_acct_aed_non_resident;
	private BigDecimal r58_amount_aed_non_resident;
	private BigDecimal r58_no_acct_fcy_non_resident;
	private BigDecimal r58_amount_fcy_non_resident;
	private BigDecimal r58_total_amount;
	private String r59_product;
	private BigDecimal r59_no_acct_aed_resident;
	private BigDecimal r59_amount_aed_resident;
	private BigDecimal r59_no_acct_fcy_resident;
	private BigDecimal r59_amount_fcy_resident;
	private BigDecimal r59_no_acct_aed_non_resident;
	private BigDecimal r59_amount_aed_non_resident;
	private BigDecimal r59_no_acct_fcy_non_resident;
	private BigDecimal r59_amount_fcy_non_resident;
	private BigDecimal r59_total_amount;
	private String r60_product;
	private BigDecimal r60_no_acct_aed_resident;
	private BigDecimal r60_amount_aed_resident;
	private BigDecimal r60_no_acct_fcy_resident;
	private BigDecimal r60_amount_fcy_resident;
	private BigDecimal r60_no_acct_aed_non_resident;
	private BigDecimal r60_amount_aed_non_resident;
	private BigDecimal r60_no_acct_fcy_non_resident;
	private BigDecimal r60_amount_fcy_non_resident;
	private BigDecimal r60_total_amount;
	private String r61_product;
	private BigDecimal r61_no_acct_aed_resident;
	private BigDecimal r61_amount_aed_resident;
	private BigDecimal r61_no_acct_fcy_resident;
	private BigDecimal r61_amount_fcy_resident;
	private BigDecimal r61_no_acct_aed_non_resident;
	private BigDecimal r61_amount_aed_non_resident;
	private BigDecimal r61_no_acct_fcy_non_resident;
	private BigDecimal r61_amount_fcy_non_resident;
	private BigDecimal r61_total_amount;
	private String r62_product;
	private BigDecimal r62_no_acct_aed_resident;
	private BigDecimal r62_amount_aed_resident;
	private BigDecimal r62_no_acct_fcy_resident;
	private BigDecimal r62_amount_fcy_resident;
	private BigDecimal r62_no_acct_aed_non_resident;
	private BigDecimal r62_amount_aed_non_resident;
	private BigDecimal r62_no_acct_fcy_non_resident;
	private BigDecimal r62_amount_fcy_non_resident;
	private BigDecimal r62_total_amount;
	private String r63_product;
	private BigDecimal r63_no_acct_aed_resident;
	private BigDecimal r63_amount_aed_resident;
	private BigDecimal r63_no_acct_fcy_resident;
	private BigDecimal r63_amount_fcy_resident;
	private BigDecimal r63_no_acct_aed_non_resident;
	private BigDecimal r63_amount_aed_non_resident;
	private BigDecimal r63_no_acct_fcy_non_resident;
	private BigDecimal r63_amount_fcy_non_resident;
	private BigDecimal r63_total_amount;
	private String r64_product;
	private BigDecimal r64_no_acct_aed_resident;
	private BigDecimal r64_amount_aed_resident;
	private BigDecimal r64_no_acct_fcy_resident;
	private BigDecimal r64_amount_fcy_resident;
	private BigDecimal r64_no_acct_aed_non_resident;
	private BigDecimal r64_amount_aed_non_resident;
	private BigDecimal r64_no_acct_fcy_non_resident;
	private BigDecimal r64_amount_fcy_non_resident;
	private BigDecimal r64_total_amount;
	private String r65_product;
	private BigDecimal r65_no_acct_aed_resident;
	private BigDecimal r65_amount_aed_resident;
	private BigDecimal r65_no_acct_fcy_resident;
	private BigDecimal r65_amount_fcy_resident;
	private BigDecimal r65_no_acct_aed_non_resident;
	private BigDecimal r65_amount_aed_non_resident;
	private BigDecimal r65_no_acct_fcy_non_resident;
	private BigDecimal r65_amount_fcy_non_resident;
	private BigDecimal r65_total_amount;
	private String r66_product;
	private BigDecimal r66_no_acct_aed_resident;
	private BigDecimal r66_amount_aed_resident;
	private BigDecimal r66_no_acct_fcy_resident;
	private BigDecimal r66_amount_fcy_resident;
	private BigDecimal r66_no_acct_aed_non_resident;
	private BigDecimal r66_amount_aed_non_resident;
	private BigDecimal r66_no_acct_fcy_non_resident;
	private BigDecimal r66_amount_fcy_non_resident;
	private BigDecimal r66_total_amount;
	private String r67_product;
	private BigDecimal r67_no_acct_aed_resident;
	private BigDecimal r67_amount_aed_resident;
	private BigDecimal r67_no_acct_fcy_resident;
	private BigDecimal r67_amount_fcy_resident;
	private BigDecimal r67_no_acct_aed_non_resident;
	private BigDecimal r67_amount_aed_non_resident;
	private BigDecimal r67_no_acct_fcy_non_resident;
	private BigDecimal r67_amount_fcy_non_resident;
	private BigDecimal r67_total_amount;
	private String r68_product;
	private BigDecimal r68_no_acct_aed_resident;
	private BigDecimal r68_amount_aed_resident;
	private BigDecimal r68_no_acct_fcy_resident;
	private BigDecimal r68_amount_fcy_resident;
	private BigDecimal r68_no_acct_aed_non_resident;
	private BigDecimal r68_amount_aed_non_resident;
	private BigDecimal r68_no_acct_fcy_non_resident;
	private BigDecimal r68_amount_fcy_non_resident;
	private BigDecimal r68_total_amount;
	private String r69_product;
	private BigDecimal r69_no_acct_aed_resident;
	private BigDecimal r69_amount_aed_resident;
	private BigDecimal r69_no_acct_fcy_resident;
	private BigDecimal r69_amount_fcy_resident;
	private BigDecimal r69_no_acct_aed_non_resident;
	private BigDecimal r69_amount_aed_non_resident;
	private BigDecimal r69_no_acct_fcy_non_resident;
	private BigDecimal r69_amount_fcy_non_resident;
	private BigDecimal r69_total_amount;
	private String r70_product;
	private BigDecimal r70_no_acct_aed_resident;
	private BigDecimal r70_amount_aed_resident;
	private BigDecimal r70_no_acct_fcy_resident;
	private BigDecimal r70_amount_fcy_resident;
	private BigDecimal r70_no_acct_aed_non_resident;
	private BigDecimal r70_amount_aed_non_resident;
	private BigDecimal r70_no_acct_fcy_non_resident;
	private BigDecimal r70_amount_fcy_non_resident;
	private BigDecimal r70_total_amount;
	private String r71_product;
	private BigDecimal r71_no_acct_aed_resident;
	private BigDecimal r71_amount_aed_resident;
	private BigDecimal r71_no_acct_fcy_resident;
	private BigDecimal r71_amount_fcy_resident;
	private BigDecimal r71_no_acct_aed_non_resident;
	private BigDecimal r71_amount_aed_non_resident;
	private BigDecimal r71_no_acct_fcy_non_resident;
	private BigDecimal r71_amount_fcy_non_resident;
	private BigDecimal r71_total_amount;
	private String r72_product;
	private BigDecimal r72_no_acct_aed_resident;
	private BigDecimal r72_amount_aed_resident;
	private BigDecimal r72_no_acct_fcy_resident;
	private BigDecimal r72_amount_fcy_resident;
	private BigDecimal r72_no_acct_aed_non_resident;
	private BigDecimal r72_amount_aed_non_resident;
	private BigDecimal r72_no_acct_fcy_non_resident;
	private BigDecimal r72_amount_fcy_non_resident;
	private BigDecimal r72_total_amount;
	private String r73_product;
	private BigDecimal r73_no_acct_aed_resident;
	private BigDecimal r73_amount_aed_resident;
	private BigDecimal r73_no_acct_fcy_resident;
	private BigDecimal r73_amount_fcy_resident;
	private BigDecimal r73_no_acct_aed_non_resident;
	private BigDecimal r73_amount_aed_non_resident;
	private BigDecimal r73_no_acct_fcy_non_resident;
	private BigDecimal r73_amount_fcy_non_resident;
	private BigDecimal r73_total_amount;
	private String r74_product;
	private BigDecimal r74_no_acct_aed_resident;
	private BigDecimal r74_amount_aed_resident;
	private BigDecimal r74_no_acct_fcy_resident;
	private BigDecimal r74_amount_fcy_resident;
	private BigDecimal r74_no_acct_aed_non_resident;
	private BigDecimal r74_amount_aed_non_resident;
	private BigDecimal r74_no_acct_fcy_non_resident;
	private BigDecimal r74_amount_fcy_non_resident;
	private BigDecimal r74_total_amount;
	private String r75_product;
	private BigDecimal r75_no_acct_aed_resident;
	private BigDecimal r75_amount_aed_resident;
	private BigDecimal r75_no_acct_fcy_resident;
	private BigDecimal r75_amount_fcy_resident;
	private BigDecimal r75_no_acct_aed_non_resident;
	private BigDecimal r75_amount_aed_non_resident;
	private BigDecimal r75_no_acct_fcy_non_resident;
	private BigDecimal r75_amount_fcy_non_resident;
	private BigDecimal r75_total_amount;
	private String r76_product;
	private BigDecimal r76_no_acct_aed_resident;
	private BigDecimal r76_amount_aed_resident;
	private BigDecimal r76_no_acct_fcy_resident;
	private BigDecimal r76_amount_fcy_resident;
	private BigDecimal r76_no_acct_aed_non_resident;
	private BigDecimal r76_amount_aed_non_resident;
	private BigDecimal r76_no_acct_fcy_non_resident;
	private BigDecimal r76_amount_fcy_non_resident;
	private BigDecimal r76_total_amount;
	private String r77_product;
	private BigDecimal r77_no_acct_aed_resident;
	private BigDecimal r77_amount_aed_resident;
	private BigDecimal r77_no_acct_fcy_resident;
	private BigDecimal r77_amount_fcy_resident;
	private BigDecimal r77_no_acct_aed_non_resident;
	private BigDecimal r77_amount_aed_non_resident;
	private BigDecimal r77_no_acct_fcy_non_resident;
	private BigDecimal r77_amount_fcy_non_resident;
	private BigDecimal r77_total_amount;
	private String r78_product;
	private BigDecimal r78_no_acct_aed_resident;
	private BigDecimal r78_amount_aed_resident;
	private BigDecimal r78_no_acct_fcy_resident;
	private BigDecimal r78_amount_fcy_resident;
	private BigDecimal r78_no_acct_aed_non_resident;
	private BigDecimal r78_amount_aed_non_resident;
	private BigDecimal r78_no_acct_fcy_non_resident;
	private BigDecimal r78_amount_fcy_non_resident;
	private BigDecimal r78_total_amount;
	private String r79_product;
	private BigDecimal r79_no_acct_aed_resident;
	private BigDecimal r79_amount_aed_resident;
	private BigDecimal r79_no_acct_fcy_resident;
	private BigDecimal r79_amount_fcy_resident;
	private BigDecimal r79_no_acct_aed_non_resident;
	private BigDecimal r79_amount_aed_non_resident;
	private BigDecimal r79_no_acct_fcy_non_resident;
	private BigDecimal r79_amount_fcy_non_resident;
	private BigDecimal r79_total_amount;
	private String r80_product;
	private BigDecimal r80_no_acct_aed_resident;
	private BigDecimal r80_amount_aed_resident;
	private BigDecimal r80_no_acct_fcy_resident;
	private BigDecimal r80_amount_fcy_resident;
	private BigDecimal r80_no_acct_aed_non_resident;
	private BigDecimal r80_amount_aed_non_resident;
	private BigDecimal r80_no_acct_fcy_non_resident;
	private BigDecimal r80_amount_fcy_non_resident;
	private BigDecimal r80_total_amount;

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

	private String r81_product;
	private BigDecimal r81_no_acct_aed_resident;
	private BigDecimal r81_amount_aed_resident;
	private BigDecimal r81_no_acct_fcy_resident;
	private BigDecimal r81_amount_fcy_resident;
	private BigDecimal r81_no_acct_aed_non_resident;
	private BigDecimal r81_amount_aed_non_resident;
	private BigDecimal r81_no_acct_fcy_non_resident;
	private BigDecimal r81_amount_fcy_non_resident;
	private BigDecimal r81_total_amount;

	public String getR1_product() {
		return r1_product;
	}

	public void setR1_product(String r1_product) {
		this.r1_product = r1_product;
	}

	public BigDecimal getR1_no_acct_aed_resident() {
		return r1_no_acct_aed_resident;
	}

	public void setR1_no_acct_aed_resident(BigDecimal r1_no_acct_aed_resident) {
		this.r1_no_acct_aed_resident = r1_no_acct_aed_resident;
	}

	public BigDecimal getR1_amount_aed_resident() {
		return r1_amount_aed_resident;
	}

	public void setR1_amount_aed_resident(BigDecimal r1_amount_aed_resident) {
		this.r1_amount_aed_resident = r1_amount_aed_resident;
	}

	public BigDecimal getR1_no_acct_fcy_resident() {
		return r1_no_acct_fcy_resident;
	}

	public void setR1_no_acct_fcy_resident(BigDecimal r1_no_acct_fcy_resident) {
		this.r1_no_acct_fcy_resident = r1_no_acct_fcy_resident;
	}

	public BigDecimal getR1_amount_fcy_resident() {
		return r1_amount_fcy_resident;
	}

	public void setR1_amount_fcy_resident(BigDecimal r1_amount_fcy_resident) {
		this.r1_amount_fcy_resident = r1_amount_fcy_resident;
	}

	public BigDecimal getR1_no_acct_aed_non_resident() {
		return r1_no_acct_aed_non_resident;
	}

	public void setR1_no_acct_aed_non_resident(BigDecimal r1_no_acct_aed_non_resident) {
		this.r1_no_acct_aed_non_resident = r1_no_acct_aed_non_resident;
	}

	public BigDecimal getR1_amount_aed_non_resident() {
		return r1_amount_aed_non_resident;
	}

	public void setR1_amount_aed_non_resident(BigDecimal r1_amount_aed_non_resident) {
		this.r1_amount_aed_non_resident = r1_amount_aed_non_resident;
	}

	public BigDecimal getR1_no_acct_fcy_non_resident() {
		return r1_no_acct_fcy_non_resident;
	}

	public void setR1_no_acct_fcy_non_resident(BigDecimal r1_no_acct_fcy_non_resident) {
		this.r1_no_acct_fcy_non_resident = r1_no_acct_fcy_non_resident;
	}

	public BigDecimal getR1_amount_fcy_non_resident() {
		return r1_amount_fcy_non_resident;
	}

	public void setR1_amount_fcy_non_resident(BigDecimal r1_amount_fcy_non_resident) {
		this.r1_amount_fcy_non_resident = r1_amount_fcy_non_resident;
	}

	public BigDecimal getR1_total_amount() {
		return r1_total_amount;
	}

	public void setR1_total_amount(BigDecimal r1_total_amount) {
		this.r1_total_amount = r1_total_amount;
	}

	public String getR2_product() {
		return r2_product;
	}

	public void setR2_product(String r2_product) {
		this.r2_product = r2_product;
	}

	public BigDecimal getR2_no_acct_aed_resident() {
		return r2_no_acct_aed_resident;
	}

	public void setR2_no_acct_aed_resident(BigDecimal r2_no_acct_aed_resident) {
		this.r2_no_acct_aed_resident = r2_no_acct_aed_resident;
	}

	public BigDecimal getR2_amount_aed_resident() {
		return r2_amount_aed_resident;
	}

	public void setR2_amount_aed_resident(BigDecimal r2_amount_aed_resident) {
		this.r2_amount_aed_resident = r2_amount_aed_resident;
	}

	public BigDecimal getR2_no_acct_fcy_resident() {
		return r2_no_acct_fcy_resident;
	}

	public void setR2_no_acct_fcy_resident(BigDecimal r2_no_acct_fcy_resident) {
		this.r2_no_acct_fcy_resident = r2_no_acct_fcy_resident;
	}

	public BigDecimal getR2_amount_fcy_resident() {
		return r2_amount_fcy_resident;
	}

	public void setR2_amount_fcy_resident(BigDecimal r2_amount_fcy_resident) {
		this.r2_amount_fcy_resident = r2_amount_fcy_resident;
	}

	public BigDecimal getR2_no_acct_aed_non_resident() {
		return r2_no_acct_aed_non_resident;
	}

	public void setR2_no_acct_aed_non_resident(BigDecimal r2_no_acct_aed_non_resident) {
		this.r2_no_acct_aed_non_resident = r2_no_acct_aed_non_resident;
	}

	public BigDecimal getR2_amount_aed_non_resident() {
		return r2_amount_aed_non_resident;
	}

	public void setR2_amount_aed_non_resident(BigDecimal r2_amount_aed_non_resident) {
		this.r2_amount_aed_non_resident = r2_amount_aed_non_resident;
	}

	public BigDecimal getR2_no_acct_fcy_non_resident() {
		return r2_no_acct_fcy_non_resident;
	}

	public void setR2_no_acct_fcy_non_resident(BigDecimal r2_no_acct_fcy_non_resident) {
		this.r2_no_acct_fcy_non_resident = r2_no_acct_fcy_non_resident;
	}

	public BigDecimal getR2_amount_fcy_non_resident() {
		return r2_amount_fcy_non_resident;
	}

	public void setR2_amount_fcy_non_resident(BigDecimal r2_amount_fcy_non_resident) {
		this.r2_amount_fcy_non_resident = r2_amount_fcy_non_resident;
	}

	public BigDecimal getR2_total_amount() {
		return r2_total_amount;
	}

	public void setR2_total_amount(BigDecimal r2_total_amount) {
		this.r2_total_amount = r2_total_amount;
	}

	public String getR3_product() {
		return r3_product;
	}

	public void setR3_product(String r3_product) {
		this.r3_product = r3_product;
	}

	public BigDecimal getR3_no_acct_aed_resident() {
		return r3_no_acct_aed_resident;
	}

	public void setR3_no_acct_aed_resident(BigDecimal r3_no_acct_aed_resident) {
		this.r3_no_acct_aed_resident = r3_no_acct_aed_resident;
	}

	public BigDecimal getR3_amount_aed_resident() {
		return r3_amount_aed_resident;
	}

	public void setR3_amount_aed_resident(BigDecimal r3_amount_aed_resident) {
		this.r3_amount_aed_resident = r3_amount_aed_resident;
	}

	public BigDecimal getR3_no_acct_fcy_resident() {
		return r3_no_acct_fcy_resident;
	}

	public void setR3_no_acct_fcy_resident(BigDecimal r3_no_acct_fcy_resident) {
		this.r3_no_acct_fcy_resident = r3_no_acct_fcy_resident;
	}

	public BigDecimal getR3_amount_fcy_resident() {
		return r3_amount_fcy_resident;
	}

	public void setR3_amount_fcy_resident(BigDecimal r3_amount_fcy_resident) {
		this.r3_amount_fcy_resident = r3_amount_fcy_resident;
	}

	public BigDecimal getR3_no_acct_aed_non_resident() {
		return r3_no_acct_aed_non_resident;
	}

	public void setR3_no_acct_aed_non_resident(BigDecimal r3_no_acct_aed_non_resident) {
		this.r3_no_acct_aed_non_resident = r3_no_acct_aed_non_resident;
	}

	public BigDecimal getR3_amount_aed_non_resident() {
		return r3_amount_aed_non_resident;
	}

	public void setR3_amount_aed_non_resident(BigDecimal r3_amount_aed_non_resident) {
		this.r3_amount_aed_non_resident = r3_amount_aed_non_resident;
	}

	public BigDecimal getR3_no_acct_fcy_non_resident() {
		return r3_no_acct_fcy_non_resident;
	}

	public void setR3_no_acct_fcy_non_resident(BigDecimal r3_no_acct_fcy_non_resident) {
		this.r3_no_acct_fcy_non_resident = r3_no_acct_fcy_non_resident;
	}

	public BigDecimal getR3_amount_fcy_non_resident() {
		return r3_amount_fcy_non_resident;
	}

	public void setR3_amount_fcy_non_resident(BigDecimal r3_amount_fcy_non_resident) {
		this.r3_amount_fcy_non_resident = r3_amount_fcy_non_resident;
	}

	public BigDecimal getR3_total_amount() {
		return r3_total_amount;
	}

	public void setR3_total_amount(BigDecimal r3_total_amount) {
		this.r3_total_amount = r3_total_amount;
	}

	public String getR4_product() {
		return r4_product;
	}

	public void setR4_product(String r4_product) {
		this.r4_product = r4_product;
	}

	public BigDecimal getR4_no_acct_aed_resident() {
		return r4_no_acct_aed_resident;
	}

	public void setR4_no_acct_aed_resident(BigDecimal r4_no_acct_aed_resident) {
		this.r4_no_acct_aed_resident = r4_no_acct_aed_resident;
	}

	public BigDecimal getR4_amount_aed_resident() {
		return r4_amount_aed_resident;
	}

	public void setR4_amount_aed_resident(BigDecimal r4_amount_aed_resident) {
		this.r4_amount_aed_resident = r4_amount_aed_resident;
	}

	public BigDecimal getR4_no_acct_fcy_resident() {
		return r4_no_acct_fcy_resident;
	}

	public void setR4_no_acct_fcy_resident(BigDecimal r4_no_acct_fcy_resident) {
		this.r4_no_acct_fcy_resident = r4_no_acct_fcy_resident;
	}

	public BigDecimal getR4_amount_fcy_resident() {
		return r4_amount_fcy_resident;
	}

	public void setR4_amount_fcy_resident(BigDecimal r4_amount_fcy_resident) {
		this.r4_amount_fcy_resident = r4_amount_fcy_resident;
	}

	public BigDecimal getR4_no_acct_aed_non_resident() {
		return r4_no_acct_aed_non_resident;
	}

	public void setR4_no_acct_aed_non_resident(BigDecimal r4_no_acct_aed_non_resident) {
		this.r4_no_acct_aed_non_resident = r4_no_acct_aed_non_resident;
	}

	public BigDecimal getR4_amount_aed_non_resident() {
		return r4_amount_aed_non_resident;
	}

	public void setR4_amount_aed_non_resident(BigDecimal r4_amount_aed_non_resident) {
		this.r4_amount_aed_non_resident = r4_amount_aed_non_resident;
	}

	public BigDecimal getR4_no_acct_fcy_non_resident() {
		return r4_no_acct_fcy_non_resident;
	}

	public void setR4_no_acct_fcy_non_resident(BigDecimal r4_no_acct_fcy_non_resident) {
		this.r4_no_acct_fcy_non_resident = r4_no_acct_fcy_non_resident;
	}

	public BigDecimal getR4_amount_fcy_non_resident() {
		return r4_amount_fcy_non_resident;
	}

	public void setR4_amount_fcy_non_resident(BigDecimal r4_amount_fcy_non_resident) {
		this.r4_amount_fcy_non_resident = r4_amount_fcy_non_resident;
	}

	public BigDecimal getR4_total_amount() {
		return r4_total_amount;
	}

	public void setR4_total_amount(BigDecimal r4_total_amount) {
		this.r4_total_amount = r4_total_amount;
	}

	public String getR5_product() {
		return r5_product;
	}

	public void setR5_product(String r5_product) {
		this.r5_product = r5_product;
	}

	public BigDecimal getR5_no_acct_aed_resident() {
		return r5_no_acct_aed_resident;
	}

	public void setR5_no_acct_aed_resident(BigDecimal r5_no_acct_aed_resident) {
		this.r5_no_acct_aed_resident = r5_no_acct_aed_resident;
	}

	public BigDecimal getR5_amount_aed_resident() {
		return r5_amount_aed_resident;
	}

	public void setR5_amount_aed_resident(BigDecimal r5_amount_aed_resident) {
		this.r5_amount_aed_resident = r5_amount_aed_resident;
	}

	public BigDecimal getR5_no_acct_fcy_resident() {
		return r5_no_acct_fcy_resident;
	}

	public void setR5_no_acct_fcy_resident(BigDecimal r5_no_acct_fcy_resident) {
		this.r5_no_acct_fcy_resident = r5_no_acct_fcy_resident;
	}

	public BigDecimal getR5_amount_fcy_resident() {
		return r5_amount_fcy_resident;
	}

	public void setR5_amount_fcy_resident(BigDecimal r5_amount_fcy_resident) {
		this.r5_amount_fcy_resident = r5_amount_fcy_resident;
	}

	public BigDecimal getR5_no_acct_aed_non_resident() {
		return r5_no_acct_aed_non_resident;
	}

	public void setR5_no_acct_aed_non_resident(BigDecimal r5_no_acct_aed_non_resident) {
		this.r5_no_acct_aed_non_resident = r5_no_acct_aed_non_resident;
	}

	public BigDecimal getR5_amount_aed_non_resident() {
		return r5_amount_aed_non_resident;
	}

	public void setR5_amount_aed_non_resident(BigDecimal r5_amount_aed_non_resident) {
		this.r5_amount_aed_non_resident = r5_amount_aed_non_resident;
	}

	public BigDecimal getR5_no_acct_fcy_non_resident() {
		return r5_no_acct_fcy_non_resident;
	}

	public void setR5_no_acct_fcy_non_resident(BigDecimal r5_no_acct_fcy_non_resident) {
		this.r5_no_acct_fcy_non_resident = r5_no_acct_fcy_non_resident;
	}

	public BigDecimal getR5_amount_fcy_non_resident() {
		return r5_amount_fcy_non_resident;
	}

	public void setR5_amount_fcy_non_resident(BigDecimal r5_amount_fcy_non_resident) {
		this.r5_amount_fcy_non_resident = r5_amount_fcy_non_resident;
	}

	public BigDecimal getR5_total_amount() {
		return r5_total_amount;
	}

	public void setR5_total_amount(BigDecimal r5_total_amount) {
		this.r5_total_amount = r5_total_amount;
	}

	public String getR6_product() {
		return r6_product;
	}

	public void setR6_product(String r6_product) {
		this.r6_product = r6_product;
	}

	public BigDecimal getR6_no_acct_aed_resident() {
		return r6_no_acct_aed_resident;
	}

	public void setR6_no_acct_aed_resident(BigDecimal r6_no_acct_aed_resident) {
		this.r6_no_acct_aed_resident = r6_no_acct_aed_resident;
	}

	public BigDecimal getR6_amount_aed_resident() {
		return r6_amount_aed_resident;
	}

	public void setR6_amount_aed_resident(BigDecimal r6_amount_aed_resident) {
		this.r6_amount_aed_resident = r6_amount_aed_resident;
	}

	public BigDecimal getR6_no_acct_fcy_resident() {
		return r6_no_acct_fcy_resident;
	}

	public void setR6_no_acct_fcy_resident(BigDecimal r6_no_acct_fcy_resident) {
		this.r6_no_acct_fcy_resident = r6_no_acct_fcy_resident;
	}

	public BigDecimal getR6_amount_fcy_resident() {
		return r6_amount_fcy_resident;
	}

	public void setR6_amount_fcy_resident(BigDecimal r6_amount_fcy_resident) {
		this.r6_amount_fcy_resident = r6_amount_fcy_resident;
	}

	public BigDecimal getR6_no_acct_aed_non_resident() {
		return r6_no_acct_aed_non_resident;
	}

	public void setR6_no_acct_aed_non_resident(BigDecimal r6_no_acct_aed_non_resident) {
		this.r6_no_acct_aed_non_resident = r6_no_acct_aed_non_resident;
	}

	public BigDecimal getR6_amount_aed_non_resident() {
		return r6_amount_aed_non_resident;
	}

	public void setR6_amount_aed_non_resident(BigDecimal r6_amount_aed_non_resident) {
		this.r6_amount_aed_non_resident = r6_amount_aed_non_resident;
	}

	public BigDecimal getR6_no_acct_fcy_non_resident() {
		return r6_no_acct_fcy_non_resident;
	}

	public void setR6_no_acct_fcy_non_resident(BigDecimal r6_no_acct_fcy_non_resident) {
		this.r6_no_acct_fcy_non_resident = r6_no_acct_fcy_non_resident;
	}

	public BigDecimal getR6_amount_fcy_non_resident() {
		return r6_amount_fcy_non_resident;
	}

	public void setR6_amount_fcy_non_resident(BigDecimal r6_amount_fcy_non_resident) {
		this.r6_amount_fcy_non_resident = r6_amount_fcy_non_resident;
	}

	public BigDecimal getR6_total_amount() {
		return r6_total_amount;
	}

	public void setR6_total_amount(BigDecimal r6_total_amount) {
		this.r6_total_amount = r6_total_amount;
	}

	public String getR7_product() {
		return r7_product;
	}

	public void setR7_product(String r7_product) {
		this.r7_product = r7_product;
	}

	public BigDecimal getR7_no_acct_aed_resident() {
		return r7_no_acct_aed_resident;
	}

	public void setR7_no_acct_aed_resident(BigDecimal r7_no_acct_aed_resident) {
		this.r7_no_acct_aed_resident = r7_no_acct_aed_resident;
	}

	public BigDecimal getR7_amount_aed_resident() {
		return r7_amount_aed_resident;
	}

	public void setR7_amount_aed_resident(BigDecimal r7_amount_aed_resident) {
		this.r7_amount_aed_resident = r7_amount_aed_resident;
	}

	public BigDecimal getR7_no_acct_fcy_resident() {
		return r7_no_acct_fcy_resident;
	}

	public void setR7_no_acct_fcy_resident(BigDecimal r7_no_acct_fcy_resident) {
		this.r7_no_acct_fcy_resident = r7_no_acct_fcy_resident;
	}

	public BigDecimal getR7_amount_fcy_resident() {
		return r7_amount_fcy_resident;
	}

	public void setR7_amount_fcy_resident(BigDecimal r7_amount_fcy_resident) {
		this.r7_amount_fcy_resident = r7_amount_fcy_resident;
	}

	public BigDecimal getR7_no_acct_aed_non_resident() {
		return r7_no_acct_aed_non_resident;
	}

	public void setR7_no_acct_aed_non_resident(BigDecimal r7_no_acct_aed_non_resident) {
		this.r7_no_acct_aed_non_resident = r7_no_acct_aed_non_resident;
	}

	public BigDecimal getR7_amount_aed_non_resident() {
		return r7_amount_aed_non_resident;
	}

	public void setR7_amount_aed_non_resident(BigDecimal r7_amount_aed_non_resident) {
		this.r7_amount_aed_non_resident = r7_amount_aed_non_resident;
	}

	public BigDecimal getR7_no_acct_fcy_non_resident() {
		return r7_no_acct_fcy_non_resident;
	}

	public void setR7_no_acct_fcy_non_resident(BigDecimal r7_no_acct_fcy_non_resident) {
		this.r7_no_acct_fcy_non_resident = r7_no_acct_fcy_non_resident;
	}

	public BigDecimal getR7_amount_fcy_non_resident() {
		return r7_amount_fcy_non_resident;
	}

	public void setR7_amount_fcy_non_resident(BigDecimal r7_amount_fcy_non_resident) {
		this.r7_amount_fcy_non_resident = r7_amount_fcy_non_resident;
	}

	public BigDecimal getR7_total_amount() {
		return r7_total_amount;
	}

	public void setR7_total_amount(BigDecimal r7_total_amount) {
		this.r7_total_amount = r7_total_amount;
	}

	public String getR8_product() {
		return r8_product;
	}

	public void setR8_product(String r8_product) {
		this.r8_product = r8_product;
	}

	public BigDecimal getR8_no_acct_aed_resident() {
		return r8_no_acct_aed_resident;
	}

	public void setR8_no_acct_aed_resident(BigDecimal r8_no_acct_aed_resident) {
		this.r8_no_acct_aed_resident = r8_no_acct_aed_resident;
	}

	public BigDecimal getR8_amount_aed_resident() {
		return r8_amount_aed_resident;
	}

	public void setR8_amount_aed_resident(BigDecimal r8_amount_aed_resident) {
		this.r8_amount_aed_resident = r8_amount_aed_resident;
	}

	public BigDecimal getR8_no_acct_fcy_resident() {
		return r8_no_acct_fcy_resident;
	}

	public void setR8_no_acct_fcy_resident(BigDecimal r8_no_acct_fcy_resident) {
		this.r8_no_acct_fcy_resident = r8_no_acct_fcy_resident;
	}

	public BigDecimal getR8_amount_fcy_resident() {
		return r8_amount_fcy_resident;
	}

	public void setR8_amount_fcy_resident(BigDecimal r8_amount_fcy_resident) {
		this.r8_amount_fcy_resident = r8_amount_fcy_resident;
	}

	public BigDecimal getR8_no_acct_aed_non_resident() {
		return r8_no_acct_aed_non_resident;
	}

	public void setR8_no_acct_aed_non_resident(BigDecimal r8_no_acct_aed_non_resident) {
		this.r8_no_acct_aed_non_resident = r8_no_acct_aed_non_resident;
	}

	public BigDecimal getR8_amount_aed_non_resident() {
		return r8_amount_aed_non_resident;
	}

	public void setR8_amount_aed_non_resident(BigDecimal r8_amount_aed_non_resident) {
		this.r8_amount_aed_non_resident = r8_amount_aed_non_resident;
	}

	public BigDecimal getR8_no_acct_fcy_non_resident() {
		return r8_no_acct_fcy_non_resident;
	}

	public void setR8_no_acct_fcy_non_resident(BigDecimal r8_no_acct_fcy_non_resident) {
		this.r8_no_acct_fcy_non_resident = r8_no_acct_fcy_non_resident;
	}

	public BigDecimal getR8_amount_fcy_non_resident() {
		return r8_amount_fcy_non_resident;
	}

	public void setR8_amount_fcy_non_resident(BigDecimal r8_amount_fcy_non_resident) {
		this.r8_amount_fcy_non_resident = r8_amount_fcy_non_resident;
	}

	public BigDecimal getR8_total_amount() {
		return r8_total_amount;
	}

	public void setR8_total_amount(BigDecimal r8_total_amount) {
		this.r8_total_amount = r8_total_amount;
	}

	public String getR9_product() {
		return r9_product;
	}

	public void setR9_product(String r9_product) {
		this.r9_product = r9_product;
	}

	public BigDecimal getR9_no_acct_aed_resident() {
		return r9_no_acct_aed_resident;
	}

	public void setR9_no_acct_aed_resident(BigDecimal r9_no_acct_aed_resident) {
		this.r9_no_acct_aed_resident = r9_no_acct_aed_resident;
	}

	public BigDecimal getR9_amount_aed_resident() {
		return r9_amount_aed_resident;
	}

	public void setR9_amount_aed_resident(BigDecimal r9_amount_aed_resident) {
		this.r9_amount_aed_resident = r9_amount_aed_resident;
	}

	public BigDecimal getR9_no_acct_fcy_resident() {
		return r9_no_acct_fcy_resident;
	}

	public void setR9_no_acct_fcy_resident(BigDecimal r9_no_acct_fcy_resident) {
		this.r9_no_acct_fcy_resident = r9_no_acct_fcy_resident;
	}

	public BigDecimal getR9_amount_fcy_resident() {
		return r9_amount_fcy_resident;
	}

	public void setR9_amount_fcy_resident(BigDecimal r9_amount_fcy_resident) {
		this.r9_amount_fcy_resident = r9_amount_fcy_resident;
	}

	public BigDecimal getR9_no_acct_aed_non_resident() {
		return r9_no_acct_aed_non_resident;
	}

	public void setR9_no_acct_aed_non_resident(BigDecimal r9_no_acct_aed_non_resident) {
		this.r9_no_acct_aed_non_resident = r9_no_acct_aed_non_resident;
	}

	public BigDecimal getR9_amount_aed_non_resident() {
		return r9_amount_aed_non_resident;
	}

	public void setR9_amount_aed_non_resident(BigDecimal r9_amount_aed_non_resident) {
		this.r9_amount_aed_non_resident = r9_amount_aed_non_resident;
	}

	public BigDecimal getR9_no_acct_fcy_non_resident() {
		return r9_no_acct_fcy_non_resident;
	}

	public void setR9_no_acct_fcy_non_resident(BigDecimal r9_no_acct_fcy_non_resident) {
		this.r9_no_acct_fcy_non_resident = r9_no_acct_fcy_non_resident;
	}

	public BigDecimal getR9_amount_fcy_non_resident() {
		return r9_amount_fcy_non_resident;
	}

	public void setR9_amount_fcy_non_resident(BigDecimal r9_amount_fcy_non_resident) {
		this.r9_amount_fcy_non_resident = r9_amount_fcy_non_resident;
	}

	public BigDecimal getR9_total_amount() {
		return r9_total_amount;
	}

	public void setR9_total_amount(BigDecimal r9_total_amount) {
		this.r9_total_amount = r9_total_amount;
	}

	public String getR10_product() {
		return r10_product;
	}

	public void setR10_product(String r10_product) {
		this.r10_product = r10_product;
	}

	public BigDecimal getR10_no_acct_aed_resident() {
		return r10_no_acct_aed_resident;
	}

	public void setR10_no_acct_aed_resident(BigDecimal r10_no_acct_aed_resident) {
		this.r10_no_acct_aed_resident = r10_no_acct_aed_resident;
	}

	public BigDecimal getR10_amount_aed_resident() {
		return r10_amount_aed_resident;
	}

	public void setR10_amount_aed_resident(BigDecimal r10_amount_aed_resident) {
		this.r10_amount_aed_resident = r10_amount_aed_resident;
	}

	public BigDecimal getR10_no_acct_fcy_resident() {
		return r10_no_acct_fcy_resident;
	}

	public void setR10_no_acct_fcy_resident(BigDecimal r10_no_acct_fcy_resident) {
		this.r10_no_acct_fcy_resident = r10_no_acct_fcy_resident;
	}

	public BigDecimal getR10_amount_fcy_resident() {
		return r10_amount_fcy_resident;
	}

	public void setR10_amount_fcy_resident(BigDecimal r10_amount_fcy_resident) {
		this.r10_amount_fcy_resident = r10_amount_fcy_resident;
	}

	public BigDecimal getR10_no_acct_aed_non_resident() {
		return r10_no_acct_aed_non_resident;
	}

	public void setR10_no_acct_aed_non_resident(BigDecimal r10_no_acct_aed_non_resident) {
		this.r10_no_acct_aed_non_resident = r10_no_acct_aed_non_resident;
	}

	public BigDecimal getR10_amount_aed_non_resident() {
		return r10_amount_aed_non_resident;
	}

	public void setR10_amount_aed_non_resident(BigDecimal r10_amount_aed_non_resident) {
		this.r10_amount_aed_non_resident = r10_amount_aed_non_resident;
	}

	public BigDecimal getR10_no_acct_fcy_non_resident() {
		return r10_no_acct_fcy_non_resident;
	}

	public void setR10_no_acct_fcy_non_resident(BigDecimal r10_no_acct_fcy_non_resident) {
		this.r10_no_acct_fcy_non_resident = r10_no_acct_fcy_non_resident;
	}

	public BigDecimal getR10_amount_fcy_non_resident() {
		return r10_amount_fcy_non_resident;
	}

	public void setR10_amount_fcy_non_resident(BigDecimal r10_amount_fcy_non_resident) {
		this.r10_amount_fcy_non_resident = r10_amount_fcy_non_resident;
	}

	public BigDecimal getR10_total_amount() {
		return r10_total_amount;
	}

	public void setR10_total_amount(BigDecimal r10_total_amount) {
		this.r10_total_amount = r10_total_amount;
	}

	public String getR11_product() {
		return r11_product;
	}

	public void setR11_product(String r11_product) {
		this.r11_product = r11_product;
	}

	public BigDecimal getR11_no_acct_aed_resident() {
		return r11_no_acct_aed_resident;
	}

	public void setR11_no_acct_aed_resident(BigDecimal r11_no_acct_aed_resident) {
		this.r11_no_acct_aed_resident = r11_no_acct_aed_resident;
	}

	public BigDecimal getR11_amount_aed_resident() {
		return r11_amount_aed_resident;
	}

	public void setR11_amount_aed_resident(BigDecimal r11_amount_aed_resident) {
		this.r11_amount_aed_resident = r11_amount_aed_resident;
	}

	public BigDecimal getR11_no_acct_fcy_resident() {
		return r11_no_acct_fcy_resident;
	}

	public void setR11_no_acct_fcy_resident(BigDecimal r11_no_acct_fcy_resident) {
		this.r11_no_acct_fcy_resident = r11_no_acct_fcy_resident;
	}

	public BigDecimal getR11_amount_fcy_resident() {
		return r11_amount_fcy_resident;
	}

	public void setR11_amount_fcy_resident(BigDecimal r11_amount_fcy_resident) {
		this.r11_amount_fcy_resident = r11_amount_fcy_resident;
	}

	public BigDecimal getR11_no_acct_aed_non_resident() {
		return r11_no_acct_aed_non_resident;
	}

	public void setR11_no_acct_aed_non_resident(BigDecimal r11_no_acct_aed_non_resident) {
		this.r11_no_acct_aed_non_resident = r11_no_acct_aed_non_resident;
	}

	public BigDecimal getR11_amount_aed_non_resident() {
		return r11_amount_aed_non_resident;
	}

	public void setR11_amount_aed_non_resident(BigDecimal r11_amount_aed_non_resident) {
		this.r11_amount_aed_non_resident = r11_amount_aed_non_resident;
	}

	public BigDecimal getR11_no_acct_fcy_non_resident() {
		return r11_no_acct_fcy_non_resident;
	}

	public void setR11_no_acct_fcy_non_resident(BigDecimal r11_no_acct_fcy_non_resident) {
		this.r11_no_acct_fcy_non_resident = r11_no_acct_fcy_non_resident;
	}

	public BigDecimal getR11_amount_fcy_non_resident() {
		return r11_amount_fcy_non_resident;
	}

	public void setR11_amount_fcy_non_resident(BigDecimal r11_amount_fcy_non_resident) {
		this.r11_amount_fcy_non_resident = r11_amount_fcy_non_resident;
	}

	public BigDecimal getR11_total_amount() {
		return r11_total_amount;
	}

	public void setR11_total_amount(BigDecimal r11_total_amount) {
		this.r11_total_amount = r11_total_amount;
	}

	public String getR12_product() {
		return r12_product;
	}

	public void setR12_product(String r12_product) {
		this.r12_product = r12_product;
	}

	public BigDecimal getR12_no_acct_aed_resident() {
		return r12_no_acct_aed_resident;
	}

	public void setR12_no_acct_aed_resident(BigDecimal r12_no_acct_aed_resident) {
		this.r12_no_acct_aed_resident = r12_no_acct_aed_resident;
	}

	public BigDecimal getR12_amount_aed_resident() {
		return r12_amount_aed_resident;
	}

	public void setR12_amount_aed_resident(BigDecimal r12_amount_aed_resident) {
		this.r12_amount_aed_resident = r12_amount_aed_resident;
	}

	public BigDecimal getR12_no_acct_fcy_resident() {
		return r12_no_acct_fcy_resident;
	}

	public void setR12_no_acct_fcy_resident(BigDecimal r12_no_acct_fcy_resident) {
		this.r12_no_acct_fcy_resident = r12_no_acct_fcy_resident;
	}

	public BigDecimal getR12_amount_fcy_resident() {
		return r12_amount_fcy_resident;
	}

	public void setR12_amount_fcy_resident(BigDecimal r12_amount_fcy_resident) {
		this.r12_amount_fcy_resident = r12_amount_fcy_resident;
	}

	public BigDecimal getR12_no_acct_aed_non_resident() {
		return r12_no_acct_aed_non_resident;
	}

	public void setR12_no_acct_aed_non_resident(BigDecimal r12_no_acct_aed_non_resident) {
		this.r12_no_acct_aed_non_resident = r12_no_acct_aed_non_resident;
	}

	public BigDecimal getR12_amount_aed_non_resident() {
		return r12_amount_aed_non_resident;
	}

	public void setR12_amount_aed_non_resident(BigDecimal r12_amount_aed_non_resident) {
		this.r12_amount_aed_non_resident = r12_amount_aed_non_resident;
	}

	public BigDecimal getR12_no_acct_fcy_non_resident() {
		return r12_no_acct_fcy_non_resident;
	}

	public void setR12_no_acct_fcy_non_resident(BigDecimal r12_no_acct_fcy_non_resident) {
		this.r12_no_acct_fcy_non_resident = r12_no_acct_fcy_non_resident;
	}

	public BigDecimal getR12_amount_fcy_non_resident() {
		return r12_amount_fcy_non_resident;
	}

	public void setR12_amount_fcy_non_resident(BigDecimal r12_amount_fcy_non_resident) {
		this.r12_amount_fcy_non_resident = r12_amount_fcy_non_resident;
	}

	public BigDecimal getR12_total_amount() {
		return r12_total_amount;
	}

	public void setR12_total_amount(BigDecimal r12_total_amount) {
		this.r12_total_amount = r12_total_amount;
	}

	public String getR13_product() {
		return r13_product;
	}

	public void setR13_product(String r13_product) {
		this.r13_product = r13_product;
	}

	public BigDecimal getR13_no_acct_aed_resident() {
		return r13_no_acct_aed_resident;
	}

	public void setR13_no_acct_aed_resident(BigDecimal r13_no_acct_aed_resident) {
		this.r13_no_acct_aed_resident = r13_no_acct_aed_resident;
	}

	public BigDecimal getR13_amount_aed_resident() {
		return r13_amount_aed_resident;
	}

	public void setR13_amount_aed_resident(BigDecimal r13_amount_aed_resident) {
		this.r13_amount_aed_resident = r13_amount_aed_resident;
	}

	public BigDecimal getR13_no_acct_fcy_resident() {
		return r13_no_acct_fcy_resident;
	}

	public void setR13_no_acct_fcy_resident(BigDecimal r13_no_acct_fcy_resident) {
		this.r13_no_acct_fcy_resident = r13_no_acct_fcy_resident;
	}

	public BigDecimal getR13_amount_fcy_resident() {
		return r13_amount_fcy_resident;
	}

	public void setR13_amount_fcy_resident(BigDecimal r13_amount_fcy_resident) {
		this.r13_amount_fcy_resident = r13_amount_fcy_resident;
	}

	public BigDecimal getR13_no_acct_aed_non_resident() {
		return r13_no_acct_aed_non_resident;
	}

	public void setR13_no_acct_aed_non_resident(BigDecimal r13_no_acct_aed_non_resident) {
		this.r13_no_acct_aed_non_resident = r13_no_acct_aed_non_resident;
	}

	public BigDecimal getR13_amount_aed_non_resident() {
		return r13_amount_aed_non_resident;
	}

	public void setR13_amount_aed_non_resident(BigDecimal r13_amount_aed_non_resident) {
		this.r13_amount_aed_non_resident = r13_amount_aed_non_resident;
	}

	public BigDecimal getR13_no_acct_fcy_non_resident() {
		return r13_no_acct_fcy_non_resident;
	}

	public void setR13_no_acct_fcy_non_resident(BigDecimal r13_no_acct_fcy_non_resident) {
		this.r13_no_acct_fcy_non_resident = r13_no_acct_fcy_non_resident;
	}

	public BigDecimal getR13_amount_fcy_non_resident() {
		return r13_amount_fcy_non_resident;
	}

	public void setR13_amount_fcy_non_resident(BigDecimal r13_amount_fcy_non_resident) {
		this.r13_amount_fcy_non_resident = r13_amount_fcy_non_resident;
	}

	public BigDecimal getR13_total_amount() {
		return r13_total_amount;
	}

	public void setR13_total_amount(BigDecimal r13_total_amount) {
		this.r13_total_amount = r13_total_amount;
	}

	public String getR14_product() {
		return r14_product;
	}

	public void setR14_product(String r14_product) {
		this.r14_product = r14_product;
	}

	public BigDecimal getR14_no_acct_aed_resident() {
		return r14_no_acct_aed_resident;
	}

	public void setR14_no_acct_aed_resident(BigDecimal r14_no_acct_aed_resident) {
		this.r14_no_acct_aed_resident = r14_no_acct_aed_resident;
	}

	public BigDecimal getR14_amount_aed_resident() {
		return r14_amount_aed_resident;
	}

	public void setR14_amount_aed_resident(BigDecimal r14_amount_aed_resident) {
		this.r14_amount_aed_resident = r14_amount_aed_resident;
	}

	public BigDecimal getR14_no_acct_fcy_resident() {
		return r14_no_acct_fcy_resident;
	}

	public void setR14_no_acct_fcy_resident(BigDecimal r14_no_acct_fcy_resident) {
		this.r14_no_acct_fcy_resident = r14_no_acct_fcy_resident;
	}

	public BigDecimal getR14_amount_fcy_resident() {
		return r14_amount_fcy_resident;
	}

	public void setR14_amount_fcy_resident(BigDecimal r14_amount_fcy_resident) {
		this.r14_amount_fcy_resident = r14_amount_fcy_resident;
	}

	public BigDecimal getR14_no_acct_aed_non_resident() {
		return r14_no_acct_aed_non_resident;
	}

	public void setR14_no_acct_aed_non_resident(BigDecimal r14_no_acct_aed_non_resident) {
		this.r14_no_acct_aed_non_resident = r14_no_acct_aed_non_resident;
	}

	public BigDecimal getR14_amount_aed_non_resident() {
		return r14_amount_aed_non_resident;
	}

	public void setR14_amount_aed_non_resident(BigDecimal r14_amount_aed_non_resident) {
		this.r14_amount_aed_non_resident = r14_amount_aed_non_resident;
	}

	public BigDecimal getR14_no_acct_fcy_non_resident() {
		return r14_no_acct_fcy_non_resident;
	}

	public void setR14_no_acct_fcy_non_resident(BigDecimal r14_no_acct_fcy_non_resident) {
		this.r14_no_acct_fcy_non_resident = r14_no_acct_fcy_non_resident;
	}

	public BigDecimal getR14_amount_fcy_non_resident() {
		return r14_amount_fcy_non_resident;
	}

	public void setR14_amount_fcy_non_resident(BigDecimal r14_amount_fcy_non_resident) {
		this.r14_amount_fcy_non_resident = r14_amount_fcy_non_resident;
	}

	public BigDecimal getR14_total_amount() {
		return r14_total_amount;
	}

	public void setR14_total_amount(BigDecimal r14_total_amount) {
		this.r14_total_amount = r14_total_amount;
	}

	public String getR15_product() {
		return r15_product;
	}

	public void setR15_product(String r15_product) {
		this.r15_product = r15_product;
	}

	public BigDecimal getR15_no_acct_aed_resident() {
		return r15_no_acct_aed_resident;
	}

	public void setR15_no_acct_aed_resident(BigDecimal r15_no_acct_aed_resident) {
		this.r15_no_acct_aed_resident = r15_no_acct_aed_resident;
	}

	public BigDecimal getR15_amount_aed_resident() {
		return r15_amount_aed_resident;
	}

	public void setR15_amount_aed_resident(BigDecimal r15_amount_aed_resident) {
		this.r15_amount_aed_resident = r15_amount_aed_resident;
	}

	public BigDecimal getR15_no_acct_fcy_resident() {
		return r15_no_acct_fcy_resident;
	}

	public void setR15_no_acct_fcy_resident(BigDecimal r15_no_acct_fcy_resident) {
		this.r15_no_acct_fcy_resident = r15_no_acct_fcy_resident;
	}

	public BigDecimal getR15_amount_fcy_resident() {
		return r15_amount_fcy_resident;
	}

	public void setR15_amount_fcy_resident(BigDecimal r15_amount_fcy_resident) {
		this.r15_amount_fcy_resident = r15_amount_fcy_resident;
	}

	public BigDecimal getR15_no_acct_aed_non_resident() {
		return r15_no_acct_aed_non_resident;
	}

	public void setR15_no_acct_aed_non_resident(BigDecimal r15_no_acct_aed_non_resident) {
		this.r15_no_acct_aed_non_resident = r15_no_acct_aed_non_resident;
	}

	public BigDecimal getR15_amount_aed_non_resident() {
		return r15_amount_aed_non_resident;
	}

	public void setR15_amount_aed_non_resident(BigDecimal r15_amount_aed_non_resident) {
		this.r15_amount_aed_non_resident = r15_amount_aed_non_resident;
	}

	public BigDecimal getR15_no_acct_fcy_non_resident() {
		return r15_no_acct_fcy_non_resident;
	}

	public void setR15_no_acct_fcy_non_resident(BigDecimal r15_no_acct_fcy_non_resident) {
		this.r15_no_acct_fcy_non_resident = r15_no_acct_fcy_non_resident;
	}

	public BigDecimal getR15_amount_fcy_non_resident() {
		return r15_amount_fcy_non_resident;
	}

	public void setR15_amount_fcy_non_resident(BigDecimal r15_amount_fcy_non_resident) {
		this.r15_amount_fcy_non_resident = r15_amount_fcy_non_resident;
	}

	public BigDecimal getR15_total_amount() {
		return r15_total_amount;
	}

	public void setR15_total_amount(BigDecimal r15_total_amount) {
		this.r15_total_amount = r15_total_amount;
	}

	public String getR16_product() {
		return r16_product;
	}

	public void setR16_product(String r16_product) {
		this.r16_product = r16_product;
	}

	public BigDecimal getR16_no_acct_aed_resident() {
		return r16_no_acct_aed_resident;
	}

	public void setR16_no_acct_aed_resident(BigDecimal r16_no_acct_aed_resident) {
		this.r16_no_acct_aed_resident = r16_no_acct_aed_resident;
	}

	public BigDecimal getR16_amount_aed_resident() {
		return r16_amount_aed_resident;
	}

	public void setR16_amount_aed_resident(BigDecimal r16_amount_aed_resident) {
		this.r16_amount_aed_resident = r16_amount_aed_resident;
	}

	public BigDecimal getR16_no_acct_fcy_resident() {
		return r16_no_acct_fcy_resident;
	}

	public void setR16_no_acct_fcy_resident(BigDecimal r16_no_acct_fcy_resident) {
		this.r16_no_acct_fcy_resident = r16_no_acct_fcy_resident;
	}

	public BigDecimal getR16_amount_fcy_resident() {
		return r16_amount_fcy_resident;
	}

	public void setR16_amount_fcy_resident(BigDecimal r16_amount_fcy_resident) {
		this.r16_amount_fcy_resident = r16_amount_fcy_resident;
	}

	public BigDecimal getR16_no_acct_aed_non_resident() {
		return r16_no_acct_aed_non_resident;
	}

	public void setR16_no_acct_aed_non_resident(BigDecimal r16_no_acct_aed_non_resident) {
		this.r16_no_acct_aed_non_resident = r16_no_acct_aed_non_resident;
	}

	public BigDecimal getR16_amount_aed_non_resident() {
		return r16_amount_aed_non_resident;
	}

	public void setR16_amount_aed_non_resident(BigDecimal r16_amount_aed_non_resident) {
		this.r16_amount_aed_non_resident = r16_amount_aed_non_resident;
	}

	public BigDecimal getR16_no_acct_fcy_non_resident() {
		return r16_no_acct_fcy_non_resident;
	}

	public void setR16_no_acct_fcy_non_resident(BigDecimal r16_no_acct_fcy_non_resident) {
		this.r16_no_acct_fcy_non_resident = r16_no_acct_fcy_non_resident;
	}

	public BigDecimal getR16_amount_fcy_non_resident() {
		return r16_amount_fcy_non_resident;
	}

	public void setR16_amount_fcy_non_resident(BigDecimal r16_amount_fcy_non_resident) {
		this.r16_amount_fcy_non_resident = r16_amount_fcy_non_resident;
	}

	public BigDecimal getR16_total_amount() {
		return r16_total_amount;
	}

	public void setR16_total_amount(BigDecimal r16_total_amount) {
		this.r16_total_amount = r16_total_amount;
	}

	public String getR17_product() {
		return r17_product;
	}

	public void setR17_product(String r17_product) {
		this.r17_product = r17_product;
	}

	public BigDecimal getR17_no_acct_aed_resident() {
		return r17_no_acct_aed_resident;
	}

	public void setR17_no_acct_aed_resident(BigDecimal r17_no_acct_aed_resident) {
		this.r17_no_acct_aed_resident = r17_no_acct_aed_resident;
	}

	public BigDecimal getR17_amount_aed_resident() {
		return r17_amount_aed_resident;
	}

	public void setR17_amount_aed_resident(BigDecimal r17_amount_aed_resident) {
		this.r17_amount_aed_resident = r17_amount_aed_resident;
	}

	public BigDecimal getR17_no_acct_fcy_resident() {
		return r17_no_acct_fcy_resident;
	}

	public void setR17_no_acct_fcy_resident(BigDecimal r17_no_acct_fcy_resident) {
		this.r17_no_acct_fcy_resident = r17_no_acct_fcy_resident;
	}

	public BigDecimal getR17_amount_fcy_resident() {
		return r17_amount_fcy_resident;
	}

	public void setR17_amount_fcy_resident(BigDecimal r17_amount_fcy_resident) {
		this.r17_amount_fcy_resident = r17_amount_fcy_resident;
	}

	public BigDecimal getR17_no_acct_aed_non_resident() {
		return r17_no_acct_aed_non_resident;
	}

	public void setR17_no_acct_aed_non_resident(BigDecimal r17_no_acct_aed_non_resident) {
		this.r17_no_acct_aed_non_resident = r17_no_acct_aed_non_resident;
	}

	public BigDecimal getR17_amount_aed_non_resident() {
		return r17_amount_aed_non_resident;
	}

	public void setR17_amount_aed_non_resident(BigDecimal r17_amount_aed_non_resident) {
		this.r17_amount_aed_non_resident = r17_amount_aed_non_resident;
	}

	public BigDecimal getR17_no_acct_fcy_non_resident() {
		return r17_no_acct_fcy_non_resident;
	}

	public void setR17_no_acct_fcy_non_resident(BigDecimal r17_no_acct_fcy_non_resident) {
		this.r17_no_acct_fcy_non_resident = r17_no_acct_fcy_non_resident;
	}

	public BigDecimal getR17_amount_fcy_non_resident() {
		return r17_amount_fcy_non_resident;
	}

	public void setR17_amount_fcy_non_resident(BigDecimal r17_amount_fcy_non_resident) {
		this.r17_amount_fcy_non_resident = r17_amount_fcy_non_resident;
	}

	public BigDecimal getR17_total_amount() {
		return r17_total_amount;
	}

	public void setR17_total_amount(BigDecimal r17_total_amount) {
		this.r17_total_amount = r17_total_amount;
	}

	public String getR18_product() {
		return r18_product;
	}

	public void setR18_product(String r18_product) {
		this.r18_product = r18_product;
	}

	public BigDecimal getR18_no_acct_aed_resident() {
		return r18_no_acct_aed_resident;
	}

	public void setR18_no_acct_aed_resident(BigDecimal r18_no_acct_aed_resident) {
		this.r18_no_acct_aed_resident = r18_no_acct_aed_resident;
	}

	public BigDecimal getR18_amount_aed_resident() {
		return r18_amount_aed_resident;
	}

	public void setR18_amount_aed_resident(BigDecimal r18_amount_aed_resident) {
		this.r18_amount_aed_resident = r18_amount_aed_resident;
	}

	public BigDecimal getR18_no_acct_fcy_resident() {
		return r18_no_acct_fcy_resident;
	}

	public void setR18_no_acct_fcy_resident(BigDecimal r18_no_acct_fcy_resident) {
		this.r18_no_acct_fcy_resident = r18_no_acct_fcy_resident;
	}

	public BigDecimal getR18_amount_fcy_resident() {
		return r18_amount_fcy_resident;
	}

	public void setR18_amount_fcy_resident(BigDecimal r18_amount_fcy_resident) {
		this.r18_amount_fcy_resident = r18_amount_fcy_resident;
	}

	public BigDecimal getR18_no_acct_aed_non_resident() {
		return r18_no_acct_aed_non_resident;
	}

	public void setR18_no_acct_aed_non_resident(BigDecimal r18_no_acct_aed_non_resident) {
		this.r18_no_acct_aed_non_resident = r18_no_acct_aed_non_resident;
	}

	public BigDecimal getR18_amount_aed_non_resident() {
		return r18_amount_aed_non_resident;
	}

	public void setR18_amount_aed_non_resident(BigDecimal r18_amount_aed_non_resident) {
		this.r18_amount_aed_non_resident = r18_amount_aed_non_resident;
	}

	public BigDecimal getR18_no_acct_fcy_non_resident() {
		return r18_no_acct_fcy_non_resident;
	}

	public void setR18_no_acct_fcy_non_resident(BigDecimal r18_no_acct_fcy_non_resident) {
		this.r18_no_acct_fcy_non_resident = r18_no_acct_fcy_non_resident;
	}

	public BigDecimal getR18_amount_fcy_non_resident() {
		return r18_amount_fcy_non_resident;
	}

	public void setR18_amount_fcy_non_resident(BigDecimal r18_amount_fcy_non_resident) {
		this.r18_amount_fcy_non_resident = r18_amount_fcy_non_resident;
	}

	public BigDecimal getR18_total_amount() {
		return r18_total_amount;
	}

	public void setR18_total_amount(BigDecimal r18_total_amount) {
		this.r18_total_amount = r18_total_amount;
	}

	public String getR19_product() {
		return r19_product;
	}

	public void setR19_product(String r19_product) {
		this.r19_product = r19_product;
	}

	public BigDecimal getR19_no_acct_aed_resident() {
		return r19_no_acct_aed_resident;
	}

	public void setR19_no_acct_aed_resident(BigDecimal r19_no_acct_aed_resident) {
		this.r19_no_acct_aed_resident = r19_no_acct_aed_resident;
	}

	public BigDecimal getR19_amount_aed_resident() {
		return r19_amount_aed_resident;
	}

	public void setR19_amount_aed_resident(BigDecimal r19_amount_aed_resident) {
		this.r19_amount_aed_resident = r19_amount_aed_resident;
	}

	public BigDecimal getR19_no_acct_fcy_resident() {
		return r19_no_acct_fcy_resident;
	}

	public void setR19_no_acct_fcy_resident(BigDecimal r19_no_acct_fcy_resident) {
		this.r19_no_acct_fcy_resident = r19_no_acct_fcy_resident;
	}

	public BigDecimal getR19_amount_fcy_resident() {
		return r19_amount_fcy_resident;
	}

	public void setR19_amount_fcy_resident(BigDecimal r19_amount_fcy_resident) {
		this.r19_amount_fcy_resident = r19_amount_fcy_resident;
	}

	public BigDecimal getR19_no_acct_aed_non_resident() {
		return r19_no_acct_aed_non_resident;
	}

	public void setR19_no_acct_aed_non_resident(BigDecimal r19_no_acct_aed_non_resident) {
		this.r19_no_acct_aed_non_resident = r19_no_acct_aed_non_resident;
	}

	public BigDecimal getR19_amount_aed_non_resident() {
		return r19_amount_aed_non_resident;
	}

	public void setR19_amount_aed_non_resident(BigDecimal r19_amount_aed_non_resident) {
		this.r19_amount_aed_non_resident = r19_amount_aed_non_resident;
	}

	public BigDecimal getR19_no_acct_fcy_non_resident() {
		return r19_no_acct_fcy_non_resident;
	}

	public void setR19_no_acct_fcy_non_resident(BigDecimal r19_no_acct_fcy_non_resident) {
		this.r19_no_acct_fcy_non_resident = r19_no_acct_fcy_non_resident;
	}

	public BigDecimal getR19_amount_fcy_non_resident() {
		return r19_amount_fcy_non_resident;
	}

	public void setR19_amount_fcy_non_resident(BigDecimal r19_amount_fcy_non_resident) {
		this.r19_amount_fcy_non_resident = r19_amount_fcy_non_resident;
	}

	public BigDecimal getR19_total_amount() {
		return r19_total_amount;
	}

	public void setR19_total_amount(BigDecimal r19_total_amount) {
		this.r19_total_amount = r19_total_amount;
	}

	public String getR20_product() {
		return r20_product;
	}

	public void setR20_product(String r20_product) {
		this.r20_product = r20_product;
	}

	public BigDecimal getR20_no_acct_aed_resident() {
		return r20_no_acct_aed_resident;
	}

	public void setR20_no_acct_aed_resident(BigDecimal r20_no_acct_aed_resident) {
		this.r20_no_acct_aed_resident = r20_no_acct_aed_resident;
	}

	public BigDecimal getR20_amount_aed_resident() {
		return r20_amount_aed_resident;
	}

	public void setR20_amount_aed_resident(BigDecimal r20_amount_aed_resident) {
		this.r20_amount_aed_resident = r20_amount_aed_resident;
	}

	public BigDecimal getR20_no_acct_fcy_resident() {
		return r20_no_acct_fcy_resident;
	}

	public void setR20_no_acct_fcy_resident(BigDecimal r20_no_acct_fcy_resident) {
		this.r20_no_acct_fcy_resident = r20_no_acct_fcy_resident;
	}

	public BigDecimal getR20_amount_fcy_resident() {
		return r20_amount_fcy_resident;
	}

	public void setR20_amount_fcy_resident(BigDecimal r20_amount_fcy_resident) {
		this.r20_amount_fcy_resident = r20_amount_fcy_resident;
	}

	public BigDecimal getR20_no_acct_aed_non_resident() {
		return r20_no_acct_aed_non_resident;
	}

	public void setR20_no_acct_aed_non_resident(BigDecimal r20_no_acct_aed_non_resident) {
		this.r20_no_acct_aed_non_resident = r20_no_acct_aed_non_resident;
	}

	public BigDecimal getR20_amount_aed_non_resident() {
		return r20_amount_aed_non_resident;
	}

	public void setR20_amount_aed_non_resident(BigDecimal r20_amount_aed_non_resident) {
		this.r20_amount_aed_non_resident = r20_amount_aed_non_resident;
	}

	public BigDecimal getR20_no_acct_fcy_non_resident() {
		return r20_no_acct_fcy_non_resident;
	}

	public void setR20_no_acct_fcy_non_resident(BigDecimal r20_no_acct_fcy_non_resident) {
		this.r20_no_acct_fcy_non_resident = r20_no_acct_fcy_non_resident;
	}

	public BigDecimal getR20_amount_fcy_non_resident() {
		return r20_amount_fcy_non_resident;
	}

	public void setR20_amount_fcy_non_resident(BigDecimal r20_amount_fcy_non_resident) {
		this.r20_amount_fcy_non_resident = r20_amount_fcy_non_resident;
	}

	public BigDecimal getR20_total_amount() {
		return r20_total_amount;
	}

	public void setR20_total_amount(BigDecimal r20_total_amount) {
		this.r20_total_amount = r20_total_amount;
	}

	public String getR21_product() {
		return r21_product;
	}

	public void setR21_product(String r21_product) {
		this.r21_product = r21_product;
	}

	public BigDecimal getR21_no_acct_aed_resident() {
		return r21_no_acct_aed_resident;
	}

	public void setR21_no_acct_aed_resident(BigDecimal r21_no_acct_aed_resident) {
		this.r21_no_acct_aed_resident = r21_no_acct_aed_resident;
	}

	public BigDecimal getR21_amount_aed_resident() {
		return r21_amount_aed_resident;
	}

	public void setR21_amount_aed_resident(BigDecimal r21_amount_aed_resident) {
		this.r21_amount_aed_resident = r21_amount_aed_resident;
	}

	public BigDecimal getR21_no_acct_fcy_resident() {
		return r21_no_acct_fcy_resident;
	}

	public void setR21_no_acct_fcy_resident(BigDecimal r21_no_acct_fcy_resident) {
		this.r21_no_acct_fcy_resident = r21_no_acct_fcy_resident;
	}

	public BigDecimal getR21_amount_fcy_resident() {
		return r21_amount_fcy_resident;
	}

	public void setR21_amount_fcy_resident(BigDecimal r21_amount_fcy_resident) {
		this.r21_amount_fcy_resident = r21_amount_fcy_resident;
	}

	public BigDecimal getR21_no_acct_aed_non_resident() {
		return r21_no_acct_aed_non_resident;
	}

	public void setR21_no_acct_aed_non_resident(BigDecimal r21_no_acct_aed_non_resident) {
		this.r21_no_acct_aed_non_resident = r21_no_acct_aed_non_resident;
	}

	public BigDecimal getR21_amount_aed_non_resident() {
		return r21_amount_aed_non_resident;
	}

	public void setR21_amount_aed_non_resident(BigDecimal r21_amount_aed_non_resident) {
		this.r21_amount_aed_non_resident = r21_amount_aed_non_resident;
	}

	public BigDecimal getR21_no_acct_fcy_non_resident() {
		return r21_no_acct_fcy_non_resident;
	}

	public void setR21_no_acct_fcy_non_resident(BigDecimal r21_no_acct_fcy_non_resident) {
		this.r21_no_acct_fcy_non_resident = r21_no_acct_fcy_non_resident;
	}

	public BigDecimal getR21_amount_fcy_non_resident() {
		return r21_amount_fcy_non_resident;
	}

	public void setR21_amount_fcy_non_resident(BigDecimal r21_amount_fcy_non_resident) {
		this.r21_amount_fcy_non_resident = r21_amount_fcy_non_resident;
	}

	public BigDecimal getR21_total_amount() {
		return r21_total_amount;
	}

	public void setR21_total_amount(BigDecimal r21_total_amount) {
		this.r21_total_amount = r21_total_amount;
	}

	public String getR22_product() {
		return r22_product;
	}

	public void setR22_product(String r22_product) {
		this.r22_product = r22_product;
	}

	public BigDecimal getR22_no_acct_aed_resident() {
		return r22_no_acct_aed_resident;
	}

	public void setR22_no_acct_aed_resident(BigDecimal r22_no_acct_aed_resident) {
		this.r22_no_acct_aed_resident = r22_no_acct_aed_resident;
	}

	public BigDecimal getR22_amount_aed_resident() {
		return r22_amount_aed_resident;
	}

	public void setR22_amount_aed_resident(BigDecimal r22_amount_aed_resident) {
		this.r22_amount_aed_resident = r22_amount_aed_resident;
	}

	public BigDecimal getR22_no_acct_fcy_resident() {
		return r22_no_acct_fcy_resident;
	}

	public void setR22_no_acct_fcy_resident(BigDecimal r22_no_acct_fcy_resident) {
		this.r22_no_acct_fcy_resident = r22_no_acct_fcy_resident;
	}

	public BigDecimal getR22_amount_fcy_resident() {
		return r22_amount_fcy_resident;
	}

	public void setR22_amount_fcy_resident(BigDecimal r22_amount_fcy_resident) {
		this.r22_amount_fcy_resident = r22_amount_fcy_resident;
	}

	public BigDecimal getR22_no_acct_aed_non_resident() {
		return r22_no_acct_aed_non_resident;
	}

	public void setR22_no_acct_aed_non_resident(BigDecimal r22_no_acct_aed_non_resident) {
		this.r22_no_acct_aed_non_resident = r22_no_acct_aed_non_resident;
	}

	public BigDecimal getR22_amount_aed_non_resident() {
		return r22_amount_aed_non_resident;
	}

	public void setR22_amount_aed_non_resident(BigDecimal r22_amount_aed_non_resident) {
		this.r22_amount_aed_non_resident = r22_amount_aed_non_resident;
	}

	public BigDecimal getR22_no_acct_fcy_non_resident() {
		return r22_no_acct_fcy_non_resident;
	}

	public void setR22_no_acct_fcy_non_resident(BigDecimal r22_no_acct_fcy_non_resident) {
		this.r22_no_acct_fcy_non_resident = r22_no_acct_fcy_non_resident;
	}

	public BigDecimal getR22_amount_fcy_non_resident() {
		return r22_amount_fcy_non_resident;
	}

	public void setR22_amount_fcy_non_resident(BigDecimal r22_amount_fcy_non_resident) {
		this.r22_amount_fcy_non_resident = r22_amount_fcy_non_resident;
	}

	public BigDecimal getR22_total_amount() {
		return r22_total_amount;
	}

	public void setR22_total_amount(BigDecimal r22_total_amount) {
		this.r22_total_amount = r22_total_amount;
	}

	public String getR23_product() {
		return r23_product;
	}

	public void setR23_product(String r23_product) {
		this.r23_product = r23_product;
	}

	public BigDecimal getR23_no_acct_aed_resident() {
		return r23_no_acct_aed_resident;
	}

	public void setR23_no_acct_aed_resident(BigDecimal r23_no_acct_aed_resident) {
		this.r23_no_acct_aed_resident = r23_no_acct_aed_resident;
	}

	public BigDecimal getR23_amount_aed_resident() {
		return r23_amount_aed_resident;
	}

	public void setR23_amount_aed_resident(BigDecimal r23_amount_aed_resident) {
		this.r23_amount_aed_resident = r23_amount_aed_resident;
	}

	public BigDecimal getR23_no_acct_fcy_resident() {
		return r23_no_acct_fcy_resident;
	}

	public void setR23_no_acct_fcy_resident(BigDecimal r23_no_acct_fcy_resident) {
		this.r23_no_acct_fcy_resident = r23_no_acct_fcy_resident;
	}

	public BigDecimal getR23_amount_fcy_resident() {
		return r23_amount_fcy_resident;
	}

	public void setR23_amount_fcy_resident(BigDecimal r23_amount_fcy_resident) {
		this.r23_amount_fcy_resident = r23_amount_fcy_resident;
	}

	public BigDecimal getR23_no_acct_aed_non_resident() {
		return r23_no_acct_aed_non_resident;
	}

	public void setR23_no_acct_aed_non_resident(BigDecimal r23_no_acct_aed_non_resident) {
		this.r23_no_acct_aed_non_resident = r23_no_acct_aed_non_resident;
	}

	public BigDecimal getR23_amount_aed_non_resident() {
		return r23_amount_aed_non_resident;
	}

	public void setR23_amount_aed_non_resident(BigDecimal r23_amount_aed_non_resident) {
		this.r23_amount_aed_non_resident = r23_amount_aed_non_resident;
	}

	public BigDecimal getR23_no_acct_fcy_non_resident() {
		return r23_no_acct_fcy_non_resident;
	}

	public void setR23_no_acct_fcy_non_resident(BigDecimal r23_no_acct_fcy_non_resident) {
		this.r23_no_acct_fcy_non_resident = r23_no_acct_fcy_non_resident;
	}

	public BigDecimal getR23_amount_fcy_non_resident() {
		return r23_amount_fcy_non_resident;
	}

	public void setR23_amount_fcy_non_resident(BigDecimal r23_amount_fcy_non_resident) {
		this.r23_amount_fcy_non_resident = r23_amount_fcy_non_resident;
	}

	public BigDecimal getR23_total_amount() {
		return r23_total_amount;
	}

	public void setR23_total_amount(BigDecimal r23_total_amount) {
		this.r23_total_amount = r23_total_amount;
	}

	public String getR24_product() {
		return r24_product;
	}

	public void setR24_product(String r24_product) {
		this.r24_product = r24_product;
	}

	public BigDecimal getR24_no_acct_aed_resident() {
		return r24_no_acct_aed_resident;
	}

	public void setR24_no_acct_aed_resident(BigDecimal r24_no_acct_aed_resident) {
		this.r24_no_acct_aed_resident = r24_no_acct_aed_resident;
	}

	public BigDecimal getR24_amount_aed_resident() {
		return r24_amount_aed_resident;
	}

	public void setR24_amount_aed_resident(BigDecimal r24_amount_aed_resident) {
		this.r24_amount_aed_resident = r24_amount_aed_resident;
	}

	public BigDecimal getR24_no_acct_fcy_resident() {
		return r24_no_acct_fcy_resident;
	}

	public void setR24_no_acct_fcy_resident(BigDecimal r24_no_acct_fcy_resident) {
		this.r24_no_acct_fcy_resident = r24_no_acct_fcy_resident;
	}

	public BigDecimal getR24_amount_fcy_resident() {
		return r24_amount_fcy_resident;
	}

	public void setR24_amount_fcy_resident(BigDecimal r24_amount_fcy_resident) {
		this.r24_amount_fcy_resident = r24_amount_fcy_resident;
	}

	public BigDecimal getR24_no_acct_aed_non_resident() {
		return r24_no_acct_aed_non_resident;
	}

	public void setR24_no_acct_aed_non_resident(BigDecimal r24_no_acct_aed_non_resident) {
		this.r24_no_acct_aed_non_resident = r24_no_acct_aed_non_resident;
	}

	public BigDecimal getR24_amount_aed_non_resident() {
		return r24_amount_aed_non_resident;
	}

	public void setR24_amount_aed_non_resident(BigDecimal r24_amount_aed_non_resident) {
		this.r24_amount_aed_non_resident = r24_amount_aed_non_resident;
	}

	public BigDecimal getR24_no_acct_fcy_non_resident() {
		return r24_no_acct_fcy_non_resident;
	}

	public void setR24_no_acct_fcy_non_resident(BigDecimal r24_no_acct_fcy_non_resident) {
		this.r24_no_acct_fcy_non_resident = r24_no_acct_fcy_non_resident;
	}

	public BigDecimal getR24_amount_fcy_non_resident() {
		return r24_amount_fcy_non_resident;
	}

	public void setR24_amount_fcy_non_resident(BigDecimal r24_amount_fcy_non_resident) {
		this.r24_amount_fcy_non_resident = r24_amount_fcy_non_resident;
	}

	public BigDecimal getR24_total_amount() {
		return r24_total_amount;
	}

	public void setR24_total_amount(BigDecimal r24_total_amount) {
		this.r24_total_amount = r24_total_amount;
	}

	public String getR25_product() {
		return r25_product;
	}

	public void setR25_product(String r25_product) {
		this.r25_product = r25_product;
	}

	public BigDecimal getR25_no_acct_aed_resident() {
		return r25_no_acct_aed_resident;
	}

	public void setR25_no_acct_aed_resident(BigDecimal r25_no_acct_aed_resident) {
		this.r25_no_acct_aed_resident = r25_no_acct_aed_resident;
	}

	public BigDecimal getR25_amount_aed_resident() {
		return r25_amount_aed_resident;
	}

	public void setR25_amount_aed_resident(BigDecimal r25_amount_aed_resident) {
		this.r25_amount_aed_resident = r25_amount_aed_resident;
	}

	public BigDecimal getR25_no_acct_fcy_resident() {
		return r25_no_acct_fcy_resident;
	}

	public void setR25_no_acct_fcy_resident(BigDecimal r25_no_acct_fcy_resident) {
		this.r25_no_acct_fcy_resident = r25_no_acct_fcy_resident;
	}

	public BigDecimal getR25_amount_fcy_resident() {
		return r25_amount_fcy_resident;
	}

	public void setR25_amount_fcy_resident(BigDecimal r25_amount_fcy_resident) {
		this.r25_amount_fcy_resident = r25_amount_fcy_resident;
	}

	public BigDecimal getR25_no_acct_aed_non_resident() {
		return r25_no_acct_aed_non_resident;
	}

	public void setR25_no_acct_aed_non_resident(BigDecimal r25_no_acct_aed_non_resident) {
		this.r25_no_acct_aed_non_resident = r25_no_acct_aed_non_resident;
	}

	public BigDecimal getR25_amount_aed_non_resident() {
		return r25_amount_aed_non_resident;
	}

	public void setR25_amount_aed_non_resident(BigDecimal r25_amount_aed_non_resident) {
		this.r25_amount_aed_non_resident = r25_amount_aed_non_resident;
	}

	public BigDecimal getR25_no_acct_fcy_non_resident() {
		return r25_no_acct_fcy_non_resident;
	}

	public void setR25_no_acct_fcy_non_resident(BigDecimal r25_no_acct_fcy_non_resident) {
		this.r25_no_acct_fcy_non_resident = r25_no_acct_fcy_non_resident;
	}

	public BigDecimal getR25_amount_fcy_non_resident() {
		return r25_amount_fcy_non_resident;
	}

	public void setR25_amount_fcy_non_resident(BigDecimal r25_amount_fcy_non_resident) {
		this.r25_amount_fcy_non_resident = r25_amount_fcy_non_resident;
	}

	public BigDecimal getR25_total_amount() {
		return r25_total_amount;
	}

	public void setR25_total_amount(BigDecimal r25_total_amount) {
		this.r25_total_amount = r25_total_amount;
	}

	public String getR26_product() {
		return r26_product;
	}

	public void setR26_product(String r26_product) {
		this.r26_product = r26_product;
	}

	public BigDecimal getR26_no_acct_aed_resident() {
		return r26_no_acct_aed_resident;
	}

	public void setR26_no_acct_aed_resident(BigDecimal r26_no_acct_aed_resident) {
		this.r26_no_acct_aed_resident = r26_no_acct_aed_resident;
	}

	public BigDecimal getR26_amount_aed_resident() {
		return r26_amount_aed_resident;
	}

	public void setR26_amount_aed_resident(BigDecimal r26_amount_aed_resident) {
		this.r26_amount_aed_resident = r26_amount_aed_resident;
	}

	public BigDecimal getR26_no_acct_fcy_resident() {
		return r26_no_acct_fcy_resident;
	}

	public void setR26_no_acct_fcy_resident(BigDecimal r26_no_acct_fcy_resident) {
		this.r26_no_acct_fcy_resident = r26_no_acct_fcy_resident;
	}

	public BigDecimal getR26_amount_fcy_resident() {
		return r26_amount_fcy_resident;
	}

	public void setR26_amount_fcy_resident(BigDecimal r26_amount_fcy_resident) {
		this.r26_amount_fcy_resident = r26_amount_fcy_resident;
	}

	public BigDecimal getR26_no_acct_aed_non_resident() {
		return r26_no_acct_aed_non_resident;
	}

	public void setR26_no_acct_aed_non_resident(BigDecimal r26_no_acct_aed_non_resident) {
		this.r26_no_acct_aed_non_resident = r26_no_acct_aed_non_resident;
	}

	public BigDecimal getR26_amount_aed_non_resident() {
		return r26_amount_aed_non_resident;
	}

	public void setR26_amount_aed_non_resident(BigDecimal r26_amount_aed_non_resident) {
		this.r26_amount_aed_non_resident = r26_amount_aed_non_resident;
	}

	public BigDecimal getR26_no_acct_fcy_non_resident() {
		return r26_no_acct_fcy_non_resident;
	}

	public void setR26_no_acct_fcy_non_resident(BigDecimal r26_no_acct_fcy_non_resident) {
		this.r26_no_acct_fcy_non_resident = r26_no_acct_fcy_non_resident;
	}

	public BigDecimal getR26_amount_fcy_non_resident() {
		return r26_amount_fcy_non_resident;
	}

	public void setR26_amount_fcy_non_resident(BigDecimal r26_amount_fcy_non_resident) {
		this.r26_amount_fcy_non_resident = r26_amount_fcy_non_resident;
	}

	public BigDecimal getR26_total_amount() {
		return r26_total_amount;
	}

	public void setR26_total_amount(BigDecimal r26_total_amount) {
		this.r26_total_amount = r26_total_amount;
	}

	public String getR27_product() {
		return r27_product;
	}

	public void setR27_product(String r27_product) {
		this.r27_product = r27_product;
	}

	public BigDecimal getR27_no_acct_aed_resident() {
		return r27_no_acct_aed_resident;
	}

	public void setR27_no_acct_aed_resident(BigDecimal r27_no_acct_aed_resident) {
		this.r27_no_acct_aed_resident = r27_no_acct_aed_resident;
	}

	public BigDecimal getR27_amount_aed_resident() {
		return r27_amount_aed_resident;
	}

	public void setR27_amount_aed_resident(BigDecimal r27_amount_aed_resident) {
		this.r27_amount_aed_resident = r27_amount_aed_resident;
	}

	public BigDecimal getR27_no_acct_fcy_resident() {
		return r27_no_acct_fcy_resident;
	}

	public void setR27_no_acct_fcy_resident(BigDecimal r27_no_acct_fcy_resident) {
		this.r27_no_acct_fcy_resident = r27_no_acct_fcy_resident;
	}

	public BigDecimal getR27_amount_fcy_resident() {
		return r27_amount_fcy_resident;
	}

	public void setR27_amount_fcy_resident(BigDecimal r27_amount_fcy_resident) {
		this.r27_amount_fcy_resident = r27_amount_fcy_resident;
	}

	public BigDecimal getR27_no_acct_aed_non_resident() {
		return r27_no_acct_aed_non_resident;
	}

	public void setR27_no_acct_aed_non_resident(BigDecimal r27_no_acct_aed_non_resident) {
		this.r27_no_acct_aed_non_resident = r27_no_acct_aed_non_resident;
	}

	public BigDecimal getR27_amount_aed_non_resident() {
		return r27_amount_aed_non_resident;
	}

	public void setR27_amount_aed_non_resident(BigDecimal r27_amount_aed_non_resident) {
		this.r27_amount_aed_non_resident = r27_amount_aed_non_resident;
	}

	public BigDecimal getR27_no_acct_fcy_non_resident() {
		return r27_no_acct_fcy_non_resident;
	}

	public void setR27_no_acct_fcy_non_resident(BigDecimal r27_no_acct_fcy_non_resident) {
		this.r27_no_acct_fcy_non_resident = r27_no_acct_fcy_non_resident;
	}

	public BigDecimal getR27_amount_fcy_non_resident() {
		return r27_amount_fcy_non_resident;
	}

	public void setR27_amount_fcy_non_resident(BigDecimal r27_amount_fcy_non_resident) {
		this.r27_amount_fcy_non_resident = r27_amount_fcy_non_resident;
	}

	public BigDecimal getR27_total_amount() {
		return r27_total_amount;
	}

	public void setR27_total_amount(BigDecimal r27_total_amount) {
		this.r27_total_amount = r27_total_amount;
	}

	public String getR28_product() {
		return r28_product;
	}

	public void setR28_product(String r28_product) {
		this.r28_product = r28_product;
	}

	public BigDecimal getR28_no_acct_aed_resident() {
		return r28_no_acct_aed_resident;
	}

	public void setR28_no_acct_aed_resident(BigDecimal r28_no_acct_aed_resident) {
		this.r28_no_acct_aed_resident = r28_no_acct_aed_resident;
	}

	public BigDecimal getR28_amount_aed_resident() {
		return r28_amount_aed_resident;
	}

	public void setR28_amount_aed_resident(BigDecimal r28_amount_aed_resident) {
		this.r28_amount_aed_resident = r28_amount_aed_resident;
	}

	public BigDecimal getR28_no_acct_fcy_resident() {
		return r28_no_acct_fcy_resident;
	}

	public void setR28_no_acct_fcy_resident(BigDecimal r28_no_acct_fcy_resident) {
		this.r28_no_acct_fcy_resident = r28_no_acct_fcy_resident;
	}

	public BigDecimal getR28_amount_fcy_resident() {
		return r28_amount_fcy_resident;
	}

	public void setR28_amount_fcy_resident(BigDecimal r28_amount_fcy_resident) {
		this.r28_amount_fcy_resident = r28_amount_fcy_resident;
	}

	public BigDecimal getR28_no_acct_aed_non_resident() {
		return r28_no_acct_aed_non_resident;
	}

	public void setR28_no_acct_aed_non_resident(BigDecimal r28_no_acct_aed_non_resident) {
		this.r28_no_acct_aed_non_resident = r28_no_acct_aed_non_resident;
	}

	public BigDecimal getR28_amount_aed_non_resident() {
		return r28_amount_aed_non_resident;
	}

	public void setR28_amount_aed_non_resident(BigDecimal r28_amount_aed_non_resident) {
		this.r28_amount_aed_non_resident = r28_amount_aed_non_resident;
	}

	public BigDecimal getR28_no_acct_fcy_non_resident() {
		return r28_no_acct_fcy_non_resident;
	}

	public void setR28_no_acct_fcy_non_resident(BigDecimal r28_no_acct_fcy_non_resident) {
		this.r28_no_acct_fcy_non_resident = r28_no_acct_fcy_non_resident;
	}

	public BigDecimal getR28_amount_fcy_non_resident() {
		return r28_amount_fcy_non_resident;
	}

	public void setR28_amount_fcy_non_resident(BigDecimal r28_amount_fcy_non_resident) {
		this.r28_amount_fcy_non_resident = r28_amount_fcy_non_resident;
	}

	public BigDecimal getR28_total_amount() {
		return r28_total_amount;
	}

	public void setR28_total_amount(BigDecimal r28_total_amount) {
		this.r28_total_amount = r28_total_amount;
	}

	public String getR29_product() {
		return r29_product;
	}

	public void setR29_product(String r29_product) {
		this.r29_product = r29_product;
	}

	public BigDecimal getR29_no_acct_aed_resident() {
		return r29_no_acct_aed_resident;
	}

	public void setR29_no_acct_aed_resident(BigDecimal r29_no_acct_aed_resident) {
		this.r29_no_acct_aed_resident = r29_no_acct_aed_resident;
	}

	public BigDecimal getR29_amount_aed_resident() {
		return r29_amount_aed_resident;
	}

	public void setR29_amount_aed_resident(BigDecimal r29_amount_aed_resident) {
		this.r29_amount_aed_resident = r29_amount_aed_resident;
	}

	public BigDecimal getR29_no_acct_fcy_resident() {
		return r29_no_acct_fcy_resident;
	}

	public void setR29_no_acct_fcy_resident(BigDecimal r29_no_acct_fcy_resident) {
		this.r29_no_acct_fcy_resident = r29_no_acct_fcy_resident;
	}

	public BigDecimal getR29_amount_fcy_resident() {
		return r29_amount_fcy_resident;
	}

	public void setR29_amount_fcy_resident(BigDecimal r29_amount_fcy_resident) {
		this.r29_amount_fcy_resident = r29_amount_fcy_resident;
	}

	public BigDecimal getR29_no_acct_aed_non_resident() {
		return r29_no_acct_aed_non_resident;
	}

	public void setR29_no_acct_aed_non_resident(BigDecimal r29_no_acct_aed_non_resident) {
		this.r29_no_acct_aed_non_resident = r29_no_acct_aed_non_resident;
	}

	public BigDecimal getR29_amount_aed_non_resident() {
		return r29_amount_aed_non_resident;
	}

	public void setR29_amount_aed_non_resident(BigDecimal r29_amount_aed_non_resident) {
		this.r29_amount_aed_non_resident = r29_amount_aed_non_resident;
	}

	public BigDecimal getR29_no_acct_fcy_non_resident() {
		return r29_no_acct_fcy_non_resident;
	}

	public void setR29_no_acct_fcy_non_resident(BigDecimal r29_no_acct_fcy_non_resident) {
		this.r29_no_acct_fcy_non_resident = r29_no_acct_fcy_non_resident;
	}

	public BigDecimal getR29_amount_fcy_non_resident() {
		return r29_amount_fcy_non_resident;
	}

	public void setR29_amount_fcy_non_resident(BigDecimal r29_amount_fcy_non_resident) {
		this.r29_amount_fcy_non_resident = r29_amount_fcy_non_resident;
	}

	public BigDecimal getR29_total_amount() {
		return r29_total_amount;
	}

	public void setR29_total_amount(BigDecimal r29_total_amount) {
		this.r29_total_amount = r29_total_amount;
	}

	public String getR30_product() {
		return r30_product;
	}

	public void setR30_product(String r30_product) {
		this.r30_product = r30_product;
	}

	public BigDecimal getR30_no_acct_aed_resident() {
		return r30_no_acct_aed_resident;
	}

	public void setR30_no_acct_aed_resident(BigDecimal r30_no_acct_aed_resident) {
		this.r30_no_acct_aed_resident = r30_no_acct_aed_resident;
	}

	public BigDecimal getR30_amount_aed_resident() {
		return r30_amount_aed_resident;
	}

	public void setR30_amount_aed_resident(BigDecimal r30_amount_aed_resident) {
		this.r30_amount_aed_resident = r30_amount_aed_resident;
	}

	public BigDecimal getR30_no_acct_fcy_resident() {
		return r30_no_acct_fcy_resident;
	}

	public void setR30_no_acct_fcy_resident(BigDecimal r30_no_acct_fcy_resident) {
		this.r30_no_acct_fcy_resident = r30_no_acct_fcy_resident;
	}

	public BigDecimal getR30_amount_fcy_resident() {
		return r30_amount_fcy_resident;
	}

	public void setR30_amount_fcy_resident(BigDecimal r30_amount_fcy_resident) {
		this.r30_amount_fcy_resident = r30_amount_fcy_resident;
	}

	public BigDecimal getR30_no_acct_aed_non_resident() {
		return r30_no_acct_aed_non_resident;
	}

	public void setR30_no_acct_aed_non_resident(BigDecimal r30_no_acct_aed_non_resident) {
		this.r30_no_acct_aed_non_resident = r30_no_acct_aed_non_resident;
	}

	public BigDecimal getR30_amount_aed_non_resident() {
		return r30_amount_aed_non_resident;
	}

	public void setR30_amount_aed_non_resident(BigDecimal r30_amount_aed_non_resident) {
		this.r30_amount_aed_non_resident = r30_amount_aed_non_resident;
	}

	public BigDecimal getR30_no_acct_fcy_non_resident() {
		return r30_no_acct_fcy_non_resident;
	}

	public void setR30_no_acct_fcy_non_resident(BigDecimal r30_no_acct_fcy_non_resident) {
		this.r30_no_acct_fcy_non_resident = r30_no_acct_fcy_non_resident;
	}

	public BigDecimal getR30_amount_fcy_non_resident() {
		return r30_amount_fcy_non_resident;
	}

	public void setR30_amount_fcy_non_resident(BigDecimal r30_amount_fcy_non_resident) {
		this.r30_amount_fcy_non_resident = r30_amount_fcy_non_resident;
	}

	public BigDecimal getR30_total_amount() {
		return r30_total_amount;
	}

	public void setR30_total_amount(BigDecimal r30_total_amount) {
		this.r30_total_amount = r30_total_amount;
	}

	public String getR31_product() {
		return r31_product;
	}

	public void setR31_product(String r31_product) {
		this.r31_product = r31_product;
	}

	public BigDecimal getR31_no_acct_aed_resident() {
		return r31_no_acct_aed_resident;
	}

	public void setR31_no_acct_aed_resident(BigDecimal r31_no_acct_aed_resident) {
		this.r31_no_acct_aed_resident = r31_no_acct_aed_resident;
	}

	public BigDecimal getR31_amount_aed_resident() {
		return r31_amount_aed_resident;
	}

	public void setR31_amount_aed_resident(BigDecimal r31_amount_aed_resident) {
		this.r31_amount_aed_resident = r31_amount_aed_resident;
	}

	public BigDecimal getR31_no_acct_fcy_resident() {
		return r31_no_acct_fcy_resident;
	}

	public void setR31_no_acct_fcy_resident(BigDecimal r31_no_acct_fcy_resident) {
		this.r31_no_acct_fcy_resident = r31_no_acct_fcy_resident;
	}

	public BigDecimal getR31_amount_fcy_resident() {
		return r31_amount_fcy_resident;
	}

	public void setR31_amount_fcy_resident(BigDecimal r31_amount_fcy_resident) {
		this.r31_amount_fcy_resident = r31_amount_fcy_resident;
	}

	public BigDecimal getR31_no_acct_aed_non_resident() {
		return r31_no_acct_aed_non_resident;
	}

	public void setR31_no_acct_aed_non_resident(BigDecimal r31_no_acct_aed_non_resident) {
		this.r31_no_acct_aed_non_resident = r31_no_acct_aed_non_resident;
	}

	public BigDecimal getR31_amount_aed_non_resident() {
		return r31_amount_aed_non_resident;
	}

	public void setR31_amount_aed_non_resident(BigDecimal r31_amount_aed_non_resident) {
		this.r31_amount_aed_non_resident = r31_amount_aed_non_resident;
	}

	public BigDecimal getR31_no_acct_fcy_non_resident() {
		return r31_no_acct_fcy_non_resident;
	}

	public void setR31_no_acct_fcy_non_resident(BigDecimal r31_no_acct_fcy_non_resident) {
		this.r31_no_acct_fcy_non_resident = r31_no_acct_fcy_non_resident;
	}

	public BigDecimal getR31_amount_fcy_non_resident() {
		return r31_amount_fcy_non_resident;
	}

	public void setR31_amount_fcy_non_resident(BigDecimal r31_amount_fcy_non_resident) {
		this.r31_amount_fcy_non_resident = r31_amount_fcy_non_resident;
	}

	public BigDecimal getR31_total_amount() {
		return r31_total_amount;
	}

	public void setR31_total_amount(BigDecimal r31_total_amount) {
		this.r31_total_amount = r31_total_amount;
	}

	public String getR32_product() {
		return r32_product;
	}

	public void setR32_product(String r32_product) {
		this.r32_product = r32_product;
	}

	public BigDecimal getR32_no_acct_aed_resident() {
		return r32_no_acct_aed_resident;
	}

	public void setR32_no_acct_aed_resident(BigDecimal r32_no_acct_aed_resident) {
		this.r32_no_acct_aed_resident = r32_no_acct_aed_resident;
	}

	public BigDecimal getR32_amount_aed_resident() {
		return r32_amount_aed_resident;
	}

	public void setR32_amount_aed_resident(BigDecimal r32_amount_aed_resident) {
		this.r32_amount_aed_resident = r32_amount_aed_resident;
	}

	public BigDecimal getR32_no_acct_fcy_resident() {
		return r32_no_acct_fcy_resident;
	}

	public void setR32_no_acct_fcy_resident(BigDecimal r32_no_acct_fcy_resident) {
		this.r32_no_acct_fcy_resident = r32_no_acct_fcy_resident;
	}

	public BigDecimal getR32_amount_fcy_resident() {
		return r32_amount_fcy_resident;
	}

	public void setR32_amount_fcy_resident(BigDecimal r32_amount_fcy_resident) {
		this.r32_amount_fcy_resident = r32_amount_fcy_resident;
	}

	public BigDecimal getR32_no_acct_aed_non_resident() {
		return r32_no_acct_aed_non_resident;
	}

	public void setR32_no_acct_aed_non_resident(BigDecimal r32_no_acct_aed_non_resident) {
		this.r32_no_acct_aed_non_resident = r32_no_acct_aed_non_resident;
	}

	public BigDecimal getR32_amount_aed_non_resident() {
		return r32_amount_aed_non_resident;
	}

	public void setR32_amount_aed_non_resident(BigDecimal r32_amount_aed_non_resident) {
		this.r32_amount_aed_non_resident = r32_amount_aed_non_resident;
	}

	public BigDecimal getR32_no_acct_fcy_non_resident() {
		return r32_no_acct_fcy_non_resident;
	}

	public void setR32_no_acct_fcy_non_resident(BigDecimal r32_no_acct_fcy_non_resident) {
		this.r32_no_acct_fcy_non_resident = r32_no_acct_fcy_non_resident;
	}

	public BigDecimal getR32_amount_fcy_non_resident() {
		return r32_amount_fcy_non_resident;
	}

	public void setR32_amount_fcy_non_resident(BigDecimal r32_amount_fcy_non_resident) {
		this.r32_amount_fcy_non_resident = r32_amount_fcy_non_resident;
	}

	public BigDecimal getR32_total_amount() {
		return r32_total_amount;
	}

	public void setR32_total_amount(BigDecimal r32_total_amount) {
		this.r32_total_amount = r32_total_amount;
	}

	public String getR33_product() {
		return r33_product;
	}

	public void setR33_product(String r33_product) {
		this.r33_product = r33_product;
	}

	public BigDecimal getR33_no_acct_aed_resident() {
		return r33_no_acct_aed_resident;
	}

	public void setR33_no_acct_aed_resident(BigDecimal r33_no_acct_aed_resident) {
		this.r33_no_acct_aed_resident = r33_no_acct_aed_resident;
	}

	public BigDecimal getR33_amount_aed_resident() {
		return r33_amount_aed_resident;
	}

	public void setR33_amount_aed_resident(BigDecimal r33_amount_aed_resident) {
		this.r33_amount_aed_resident = r33_amount_aed_resident;
	}

	public BigDecimal getR33_no_acct_fcy_resident() {
		return r33_no_acct_fcy_resident;
	}

	public void setR33_no_acct_fcy_resident(BigDecimal r33_no_acct_fcy_resident) {
		this.r33_no_acct_fcy_resident = r33_no_acct_fcy_resident;
	}

	public BigDecimal getR33_amount_fcy_resident() {
		return r33_amount_fcy_resident;
	}

	public void setR33_amount_fcy_resident(BigDecimal r33_amount_fcy_resident) {
		this.r33_amount_fcy_resident = r33_amount_fcy_resident;
	}

	public BigDecimal getR33_no_acct_aed_non_resident() {
		return r33_no_acct_aed_non_resident;
	}

	public void setR33_no_acct_aed_non_resident(BigDecimal r33_no_acct_aed_non_resident) {
		this.r33_no_acct_aed_non_resident = r33_no_acct_aed_non_resident;
	}

	public BigDecimal getR33_amount_aed_non_resident() {
		return r33_amount_aed_non_resident;
	}

	public void setR33_amount_aed_non_resident(BigDecimal r33_amount_aed_non_resident) {
		this.r33_amount_aed_non_resident = r33_amount_aed_non_resident;
	}

	public BigDecimal getR33_no_acct_fcy_non_resident() {
		return r33_no_acct_fcy_non_resident;
	}

	public void setR33_no_acct_fcy_non_resident(BigDecimal r33_no_acct_fcy_non_resident) {
		this.r33_no_acct_fcy_non_resident = r33_no_acct_fcy_non_resident;
	}

	public BigDecimal getR33_amount_fcy_non_resident() {
		return r33_amount_fcy_non_resident;
	}

	public void setR33_amount_fcy_non_resident(BigDecimal r33_amount_fcy_non_resident) {
		this.r33_amount_fcy_non_resident = r33_amount_fcy_non_resident;
	}

	public BigDecimal getR33_total_amount() {
		return r33_total_amount;
	}

	public void setR33_total_amount(BigDecimal r33_total_amount) {
		this.r33_total_amount = r33_total_amount;
	}

	public String getR34_product() {
		return r34_product;
	}

	public void setR34_product(String r34_product) {
		this.r34_product = r34_product;
	}

	public BigDecimal getR34_no_acct_aed_resident() {
		return r34_no_acct_aed_resident;
	}

	public void setR34_no_acct_aed_resident(BigDecimal r34_no_acct_aed_resident) {
		this.r34_no_acct_aed_resident = r34_no_acct_aed_resident;
	}

	public BigDecimal getR34_amount_aed_resident() {
		return r34_amount_aed_resident;
	}

	public void setR34_amount_aed_resident(BigDecimal r34_amount_aed_resident) {
		this.r34_amount_aed_resident = r34_amount_aed_resident;
	}

	public BigDecimal getR34_no_acct_fcy_resident() {
		return r34_no_acct_fcy_resident;
	}

	public void setR34_no_acct_fcy_resident(BigDecimal r34_no_acct_fcy_resident) {
		this.r34_no_acct_fcy_resident = r34_no_acct_fcy_resident;
	}

	public BigDecimal getR34_amount_fcy_resident() {
		return r34_amount_fcy_resident;
	}

	public void setR34_amount_fcy_resident(BigDecimal r34_amount_fcy_resident) {
		this.r34_amount_fcy_resident = r34_amount_fcy_resident;
	}

	public BigDecimal getR34_no_acct_aed_non_resident() {
		return r34_no_acct_aed_non_resident;
	}

	public void setR34_no_acct_aed_non_resident(BigDecimal r34_no_acct_aed_non_resident) {
		this.r34_no_acct_aed_non_resident = r34_no_acct_aed_non_resident;
	}

	public BigDecimal getR34_amount_aed_non_resident() {
		return r34_amount_aed_non_resident;
	}

	public void setR34_amount_aed_non_resident(BigDecimal r34_amount_aed_non_resident) {
		this.r34_amount_aed_non_resident = r34_amount_aed_non_resident;
	}

	public BigDecimal getR34_no_acct_fcy_non_resident() {
		return r34_no_acct_fcy_non_resident;
	}

	public void setR34_no_acct_fcy_non_resident(BigDecimal r34_no_acct_fcy_non_resident) {
		this.r34_no_acct_fcy_non_resident = r34_no_acct_fcy_non_resident;
	}

	public BigDecimal getR34_amount_fcy_non_resident() {
		return r34_amount_fcy_non_resident;
	}

	public void setR34_amount_fcy_non_resident(BigDecimal r34_amount_fcy_non_resident) {
		this.r34_amount_fcy_non_resident = r34_amount_fcy_non_resident;
	}

	public BigDecimal getR34_total_amount() {
		return r34_total_amount;
	}

	public void setR34_total_amount(BigDecimal r34_total_amount) {
		this.r34_total_amount = r34_total_amount;
	}

	public String getR35_product() {
		return r35_product;
	}

	public void setR35_product(String r35_product) {
		this.r35_product = r35_product;
	}

	public BigDecimal getR35_no_acct_aed_resident() {
		return r35_no_acct_aed_resident;
	}

	public void setR35_no_acct_aed_resident(BigDecimal r35_no_acct_aed_resident) {
		this.r35_no_acct_aed_resident = r35_no_acct_aed_resident;
	}

	public BigDecimal getR35_amount_aed_resident() {
		return r35_amount_aed_resident;
	}

	public void setR35_amount_aed_resident(BigDecimal r35_amount_aed_resident) {
		this.r35_amount_aed_resident = r35_amount_aed_resident;
	}

	public BigDecimal getR35_no_acct_fcy_resident() {
		return r35_no_acct_fcy_resident;
	}

	public void setR35_no_acct_fcy_resident(BigDecimal r35_no_acct_fcy_resident) {
		this.r35_no_acct_fcy_resident = r35_no_acct_fcy_resident;
	}

	public BigDecimal getR35_amount_fcy_resident() {
		return r35_amount_fcy_resident;
	}

	public void setR35_amount_fcy_resident(BigDecimal r35_amount_fcy_resident) {
		this.r35_amount_fcy_resident = r35_amount_fcy_resident;
	}

	public BigDecimal getR35_no_acct_aed_non_resident() {
		return r35_no_acct_aed_non_resident;
	}

	public void setR35_no_acct_aed_non_resident(BigDecimal r35_no_acct_aed_non_resident) {
		this.r35_no_acct_aed_non_resident = r35_no_acct_aed_non_resident;
	}

	public BigDecimal getR35_amount_aed_non_resident() {
		return r35_amount_aed_non_resident;
	}

	public void setR35_amount_aed_non_resident(BigDecimal r35_amount_aed_non_resident) {
		this.r35_amount_aed_non_resident = r35_amount_aed_non_resident;
	}

	public BigDecimal getR35_no_acct_fcy_non_resident() {
		return r35_no_acct_fcy_non_resident;
	}

	public void setR35_no_acct_fcy_non_resident(BigDecimal r35_no_acct_fcy_non_resident) {
		this.r35_no_acct_fcy_non_resident = r35_no_acct_fcy_non_resident;
	}

	public BigDecimal getR35_amount_fcy_non_resident() {
		return r35_amount_fcy_non_resident;
	}

	public void setR35_amount_fcy_non_resident(BigDecimal r35_amount_fcy_non_resident) {
		this.r35_amount_fcy_non_resident = r35_amount_fcy_non_resident;
	}

	public BigDecimal getR35_total_amount() {
		return r35_total_amount;
	}

	public void setR35_total_amount(BigDecimal r35_total_amount) {
		this.r35_total_amount = r35_total_amount;
	}

	public String getR36_product() {
		return r36_product;
	}

	public void setR36_product(String r36_product) {
		this.r36_product = r36_product;
	}

	public BigDecimal getR36_no_acct_aed_resident() {
		return r36_no_acct_aed_resident;
	}

	public void setR36_no_acct_aed_resident(BigDecimal r36_no_acct_aed_resident) {
		this.r36_no_acct_aed_resident = r36_no_acct_aed_resident;
	}

	public BigDecimal getR36_amount_aed_resident() {
		return r36_amount_aed_resident;
	}

	public void setR36_amount_aed_resident(BigDecimal r36_amount_aed_resident) {
		this.r36_amount_aed_resident = r36_amount_aed_resident;
	}

	public BigDecimal getR36_no_acct_fcy_resident() {
		return r36_no_acct_fcy_resident;
	}

	public void setR36_no_acct_fcy_resident(BigDecimal r36_no_acct_fcy_resident) {
		this.r36_no_acct_fcy_resident = r36_no_acct_fcy_resident;
	}

	public BigDecimal getR36_amount_fcy_resident() {
		return r36_amount_fcy_resident;
	}

	public void setR36_amount_fcy_resident(BigDecimal r36_amount_fcy_resident) {
		this.r36_amount_fcy_resident = r36_amount_fcy_resident;
	}

	public BigDecimal getR36_no_acct_aed_non_resident() {
		return r36_no_acct_aed_non_resident;
	}

	public void setR36_no_acct_aed_non_resident(BigDecimal r36_no_acct_aed_non_resident) {
		this.r36_no_acct_aed_non_resident = r36_no_acct_aed_non_resident;
	}

	public BigDecimal getR36_amount_aed_non_resident() {
		return r36_amount_aed_non_resident;
	}

	public void setR36_amount_aed_non_resident(BigDecimal r36_amount_aed_non_resident) {
		this.r36_amount_aed_non_resident = r36_amount_aed_non_resident;
	}

	public BigDecimal getR36_no_acct_fcy_non_resident() {
		return r36_no_acct_fcy_non_resident;
	}

	public void setR36_no_acct_fcy_non_resident(BigDecimal r36_no_acct_fcy_non_resident) {
		this.r36_no_acct_fcy_non_resident = r36_no_acct_fcy_non_resident;
	}

	public BigDecimal getR36_amount_fcy_non_resident() {
		return r36_amount_fcy_non_resident;
	}

	public void setR36_amount_fcy_non_resident(BigDecimal r36_amount_fcy_non_resident) {
		this.r36_amount_fcy_non_resident = r36_amount_fcy_non_resident;
	}

	public BigDecimal getR36_total_amount() {
		return r36_total_amount;
	}

	public void setR36_total_amount(BigDecimal r36_total_amount) {
		this.r36_total_amount = r36_total_amount;
	}

	public String getR37_product() {
		return r37_product;
	}

	public void setR37_product(String r37_product) {
		this.r37_product = r37_product;
	}

	public BigDecimal getR37_no_acct_aed_resident() {
		return r37_no_acct_aed_resident;
	}

	public void setR37_no_acct_aed_resident(BigDecimal r37_no_acct_aed_resident) {
		this.r37_no_acct_aed_resident = r37_no_acct_aed_resident;
	}

	public BigDecimal getR37_amount_aed_resident() {
		return r37_amount_aed_resident;
	}

	public void setR37_amount_aed_resident(BigDecimal r37_amount_aed_resident) {
		this.r37_amount_aed_resident = r37_amount_aed_resident;
	}

	public BigDecimal getR37_no_acct_fcy_resident() {
		return r37_no_acct_fcy_resident;
	}

	public void setR37_no_acct_fcy_resident(BigDecimal r37_no_acct_fcy_resident) {
		this.r37_no_acct_fcy_resident = r37_no_acct_fcy_resident;
	}

	public BigDecimal getR37_amount_fcy_resident() {
		return r37_amount_fcy_resident;
	}

	public void setR37_amount_fcy_resident(BigDecimal r37_amount_fcy_resident) {
		this.r37_amount_fcy_resident = r37_amount_fcy_resident;
	}

	public BigDecimal getR37_no_acct_aed_non_resident() {
		return r37_no_acct_aed_non_resident;
	}

	public void setR37_no_acct_aed_non_resident(BigDecimal r37_no_acct_aed_non_resident) {
		this.r37_no_acct_aed_non_resident = r37_no_acct_aed_non_resident;
	}

	public BigDecimal getR37_amount_aed_non_resident() {
		return r37_amount_aed_non_resident;
	}

	public void setR37_amount_aed_non_resident(BigDecimal r37_amount_aed_non_resident) {
		this.r37_amount_aed_non_resident = r37_amount_aed_non_resident;
	}

	public BigDecimal getR37_no_acct_fcy_non_resident() {
		return r37_no_acct_fcy_non_resident;
	}

	public void setR37_no_acct_fcy_non_resident(BigDecimal r37_no_acct_fcy_non_resident) {
		this.r37_no_acct_fcy_non_resident = r37_no_acct_fcy_non_resident;
	}

	public BigDecimal getR37_amount_fcy_non_resident() {
		return r37_amount_fcy_non_resident;
	}

	public void setR37_amount_fcy_non_resident(BigDecimal r37_amount_fcy_non_resident) {
		this.r37_amount_fcy_non_resident = r37_amount_fcy_non_resident;
	}

	public BigDecimal getR37_total_amount() {
		return r37_total_amount;
	}

	public void setR37_total_amount(BigDecimal r37_total_amount) {
		this.r37_total_amount = r37_total_amount;
	}

	public String getR38_product() {
		return r38_product;
	}

	public void setR38_product(String r38_product) {
		this.r38_product = r38_product;
	}

	public BigDecimal getR38_no_acct_aed_resident() {
		return r38_no_acct_aed_resident;
	}

	public void setR38_no_acct_aed_resident(BigDecimal r38_no_acct_aed_resident) {
		this.r38_no_acct_aed_resident = r38_no_acct_aed_resident;
	}

	public BigDecimal getR38_amount_aed_resident() {
		return r38_amount_aed_resident;
	}

	public void setR38_amount_aed_resident(BigDecimal r38_amount_aed_resident) {
		this.r38_amount_aed_resident = r38_amount_aed_resident;
	}

	public BigDecimal getR38_no_acct_fcy_resident() {
		return r38_no_acct_fcy_resident;
	}

	public void setR38_no_acct_fcy_resident(BigDecimal r38_no_acct_fcy_resident) {
		this.r38_no_acct_fcy_resident = r38_no_acct_fcy_resident;
	}

	public BigDecimal getR38_amount_fcy_resident() {
		return r38_amount_fcy_resident;
	}

	public void setR38_amount_fcy_resident(BigDecimal r38_amount_fcy_resident) {
		this.r38_amount_fcy_resident = r38_amount_fcy_resident;
	}

	public BigDecimal getR38_no_acct_aed_non_resident() {
		return r38_no_acct_aed_non_resident;
	}

	public void setR38_no_acct_aed_non_resident(BigDecimal r38_no_acct_aed_non_resident) {
		this.r38_no_acct_aed_non_resident = r38_no_acct_aed_non_resident;
	}

	public BigDecimal getR38_amount_aed_non_resident() {
		return r38_amount_aed_non_resident;
	}

	public void setR38_amount_aed_non_resident(BigDecimal r38_amount_aed_non_resident) {
		this.r38_amount_aed_non_resident = r38_amount_aed_non_resident;
	}

	public BigDecimal getR38_no_acct_fcy_non_resident() {
		return r38_no_acct_fcy_non_resident;
	}

	public void setR38_no_acct_fcy_non_resident(BigDecimal r38_no_acct_fcy_non_resident) {
		this.r38_no_acct_fcy_non_resident = r38_no_acct_fcy_non_resident;
	}

	public BigDecimal getR38_amount_fcy_non_resident() {
		return r38_amount_fcy_non_resident;
	}

	public void setR38_amount_fcy_non_resident(BigDecimal r38_amount_fcy_non_resident) {
		this.r38_amount_fcy_non_resident = r38_amount_fcy_non_resident;
	}

	public BigDecimal getR38_total_amount() {
		return r38_total_amount;
	}

	public void setR38_total_amount(BigDecimal r38_total_amount) {
		this.r38_total_amount = r38_total_amount;
	}

	public String getR39_product() {
		return r39_product;
	}

	public void setR39_product(String r39_product) {
		this.r39_product = r39_product;
	}

	public BigDecimal getR39_no_acct_aed_resident() {
		return r39_no_acct_aed_resident;
	}

	public void setR39_no_acct_aed_resident(BigDecimal r39_no_acct_aed_resident) {
		this.r39_no_acct_aed_resident = r39_no_acct_aed_resident;
	}

	public BigDecimal getR39_amount_aed_resident() {
		return r39_amount_aed_resident;
	}

	public void setR39_amount_aed_resident(BigDecimal r39_amount_aed_resident) {
		this.r39_amount_aed_resident = r39_amount_aed_resident;
	}

	public BigDecimal getR39_no_acct_fcy_resident() {
		return r39_no_acct_fcy_resident;
	}

	public void setR39_no_acct_fcy_resident(BigDecimal r39_no_acct_fcy_resident) {
		this.r39_no_acct_fcy_resident = r39_no_acct_fcy_resident;
	}

	public BigDecimal getR39_amount_fcy_resident() {
		return r39_amount_fcy_resident;
	}

	public void setR39_amount_fcy_resident(BigDecimal r39_amount_fcy_resident) {
		this.r39_amount_fcy_resident = r39_amount_fcy_resident;
	}

	public BigDecimal getR39_no_acct_aed_non_resident() {
		return r39_no_acct_aed_non_resident;
	}

	public void setR39_no_acct_aed_non_resident(BigDecimal r39_no_acct_aed_non_resident) {
		this.r39_no_acct_aed_non_resident = r39_no_acct_aed_non_resident;
	}

	public BigDecimal getR39_amount_aed_non_resident() {
		return r39_amount_aed_non_resident;
	}

	public void setR39_amount_aed_non_resident(BigDecimal r39_amount_aed_non_resident) {
		this.r39_amount_aed_non_resident = r39_amount_aed_non_resident;
	}

	public BigDecimal getR39_no_acct_fcy_non_resident() {
		return r39_no_acct_fcy_non_resident;
	}

	public void setR39_no_acct_fcy_non_resident(BigDecimal r39_no_acct_fcy_non_resident) {
		this.r39_no_acct_fcy_non_resident = r39_no_acct_fcy_non_resident;
	}

	public BigDecimal getR39_amount_fcy_non_resident() {
		return r39_amount_fcy_non_resident;
	}

	public void setR39_amount_fcy_non_resident(BigDecimal r39_amount_fcy_non_resident) {
		this.r39_amount_fcy_non_resident = r39_amount_fcy_non_resident;
	}

	public BigDecimal getR39_total_amount() {
		return r39_total_amount;
	}

	public void setR39_total_amount(BigDecimal r39_total_amount) {
		this.r39_total_amount = r39_total_amount;
	}

	public String getR40_product() {
		return r40_product;
	}

	public void setR40_product(String r40_product) {
		this.r40_product = r40_product;
	}

	public BigDecimal getR40_no_acct_aed_resident() {
		return r40_no_acct_aed_resident;
	}

	public void setR40_no_acct_aed_resident(BigDecimal r40_no_acct_aed_resident) {
		this.r40_no_acct_aed_resident = r40_no_acct_aed_resident;
	}

	public BigDecimal getR40_amount_aed_resident() {
		return r40_amount_aed_resident;
	}

	public void setR40_amount_aed_resident(BigDecimal r40_amount_aed_resident) {
		this.r40_amount_aed_resident = r40_amount_aed_resident;
	}

	public BigDecimal getR40_no_acct_fcy_resident() {
		return r40_no_acct_fcy_resident;
	}

	public void setR40_no_acct_fcy_resident(BigDecimal r40_no_acct_fcy_resident) {
		this.r40_no_acct_fcy_resident = r40_no_acct_fcy_resident;
	}

	public BigDecimal getR40_amount_fcy_resident() {
		return r40_amount_fcy_resident;
	}

	public void setR40_amount_fcy_resident(BigDecimal r40_amount_fcy_resident) {
		this.r40_amount_fcy_resident = r40_amount_fcy_resident;
	}

	public BigDecimal getR40_no_acct_aed_non_resident() {
		return r40_no_acct_aed_non_resident;
	}

	public void setR40_no_acct_aed_non_resident(BigDecimal r40_no_acct_aed_non_resident) {
		this.r40_no_acct_aed_non_resident = r40_no_acct_aed_non_resident;
	}

	public BigDecimal getR40_amount_aed_non_resident() {
		return r40_amount_aed_non_resident;
	}

	public void setR40_amount_aed_non_resident(BigDecimal r40_amount_aed_non_resident) {
		this.r40_amount_aed_non_resident = r40_amount_aed_non_resident;
	}

	public BigDecimal getR40_no_acct_fcy_non_resident() {
		return r40_no_acct_fcy_non_resident;
	}

	public void setR40_no_acct_fcy_non_resident(BigDecimal r40_no_acct_fcy_non_resident) {
		this.r40_no_acct_fcy_non_resident = r40_no_acct_fcy_non_resident;
	}

	public BigDecimal getR40_amount_fcy_non_resident() {
		return r40_amount_fcy_non_resident;
	}

	public void setR40_amount_fcy_non_resident(BigDecimal r40_amount_fcy_non_resident) {
		this.r40_amount_fcy_non_resident = r40_amount_fcy_non_resident;
	}

	public BigDecimal getR40_total_amount() {
		return r40_total_amount;
	}

	public void setR40_total_amount(BigDecimal r40_total_amount) {
		this.r40_total_amount = r40_total_amount;
	}

	public String getR41_product() {
		return r41_product;
	}

	public void setR41_product(String r41_product) {
		this.r41_product = r41_product;
	}

	public BigDecimal getR41_no_acct_aed_resident() {
		return r41_no_acct_aed_resident;
	}

	public void setR41_no_acct_aed_resident(BigDecimal r41_no_acct_aed_resident) {
		this.r41_no_acct_aed_resident = r41_no_acct_aed_resident;
	}

	public BigDecimal getR41_amount_aed_resident() {
		return r41_amount_aed_resident;
	}

	public void setR41_amount_aed_resident(BigDecimal r41_amount_aed_resident) {
		this.r41_amount_aed_resident = r41_amount_aed_resident;
	}

	public BigDecimal getR41_no_acct_fcy_resident() {
		return r41_no_acct_fcy_resident;
	}

	public void setR41_no_acct_fcy_resident(BigDecimal r41_no_acct_fcy_resident) {
		this.r41_no_acct_fcy_resident = r41_no_acct_fcy_resident;
	}

	public BigDecimal getR41_amount_fcy_resident() {
		return r41_amount_fcy_resident;
	}

	public void setR41_amount_fcy_resident(BigDecimal r41_amount_fcy_resident) {
		this.r41_amount_fcy_resident = r41_amount_fcy_resident;
	}

	public BigDecimal getR41_no_acct_aed_non_resident() {
		return r41_no_acct_aed_non_resident;
	}

	public void setR41_no_acct_aed_non_resident(BigDecimal r41_no_acct_aed_non_resident) {
		this.r41_no_acct_aed_non_resident = r41_no_acct_aed_non_resident;
	}

	public BigDecimal getR41_amount_aed_non_resident() {
		return r41_amount_aed_non_resident;
	}

	public void setR41_amount_aed_non_resident(BigDecimal r41_amount_aed_non_resident) {
		this.r41_amount_aed_non_resident = r41_amount_aed_non_resident;
	}

	public BigDecimal getR41_no_acct_fcy_non_resident() {
		return r41_no_acct_fcy_non_resident;
	}

	public void setR41_no_acct_fcy_non_resident(BigDecimal r41_no_acct_fcy_non_resident) {
		this.r41_no_acct_fcy_non_resident = r41_no_acct_fcy_non_resident;
	}

	public BigDecimal getR41_amount_fcy_non_resident() {
		return r41_amount_fcy_non_resident;
	}

	public void setR41_amount_fcy_non_resident(BigDecimal r41_amount_fcy_non_resident) {
		this.r41_amount_fcy_non_resident = r41_amount_fcy_non_resident;
	}

	public BigDecimal getR41_total_amount() {
		return r41_total_amount;
	}

	public void setR41_total_amount(BigDecimal r41_total_amount) {
		this.r41_total_amount = r41_total_amount;
	}

	public String getR42_product() {
		return r42_product;
	}

	public void setR42_product(String r42_product) {
		this.r42_product = r42_product;
	}

	public BigDecimal getR42_no_acct_aed_resident() {
		return r42_no_acct_aed_resident;
	}

	public void setR42_no_acct_aed_resident(BigDecimal r42_no_acct_aed_resident) {
		this.r42_no_acct_aed_resident = r42_no_acct_aed_resident;
	}

	public BigDecimal getR42_amount_aed_resident() {
		return r42_amount_aed_resident;
	}

	public void setR42_amount_aed_resident(BigDecimal r42_amount_aed_resident) {
		this.r42_amount_aed_resident = r42_amount_aed_resident;
	}

	public BigDecimal getR42_no_acct_fcy_resident() {
		return r42_no_acct_fcy_resident;
	}

	public void setR42_no_acct_fcy_resident(BigDecimal r42_no_acct_fcy_resident) {
		this.r42_no_acct_fcy_resident = r42_no_acct_fcy_resident;
	}

	public BigDecimal getR42_amount_fcy_resident() {
		return r42_amount_fcy_resident;
	}

	public void setR42_amount_fcy_resident(BigDecimal r42_amount_fcy_resident) {
		this.r42_amount_fcy_resident = r42_amount_fcy_resident;
	}

	public BigDecimal getR42_no_acct_aed_non_resident() {
		return r42_no_acct_aed_non_resident;
	}

	public void setR42_no_acct_aed_non_resident(BigDecimal r42_no_acct_aed_non_resident) {
		this.r42_no_acct_aed_non_resident = r42_no_acct_aed_non_resident;
	}

	public BigDecimal getR42_amount_aed_non_resident() {
		return r42_amount_aed_non_resident;
	}

	public void setR42_amount_aed_non_resident(BigDecimal r42_amount_aed_non_resident) {
		this.r42_amount_aed_non_resident = r42_amount_aed_non_resident;
	}

	public BigDecimal getR42_no_acct_fcy_non_resident() {
		return r42_no_acct_fcy_non_resident;
	}

	public void setR42_no_acct_fcy_non_resident(BigDecimal r42_no_acct_fcy_non_resident) {
		this.r42_no_acct_fcy_non_resident = r42_no_acct_fcy_non_resident;
	}

	public BigDecimal getR42_amount_fcy_non_resident() {
		return r42_amount_fcy_non_resident;
	}

	public void setR42_amount_fcy_non_resident(BigDecimal r42_amount_fcy_non_resident) {
		this.r42_amount_fcy_non_resident = r42_amount_fcy_non_resident;
	}

	public BigDecimal getR42_total_amount() {
		return r42_total_amount;
	}

	public void setR42_total_amount(BigDecimal r42_total_amount) {
		this.r42_total_amount = r42_total_amount;
	}

	public String getR43_product() {
		return r43_product;
	}

	public void setR43_product(String r43_product) {
		this.r43_product = r43_product;
	}

	public BigDecimal getR43_no_acct_aed_resident() {
		return r43_no_acct_aed_resident;
	}

	public void setR43_no_acct_aed_resident(BigDecimal r43_no_acct_aed_resident) {
		this.r43_no_acct_aed_resident = r43_no_acct_aed_resident;
	}

	public BigDecimal getR43_amount_aed_resident() {
		return r43_amount_aed_resident;
	}

	public void setR43_amount_aed_resident(BigDecimal r43_amount_aed_resident) {
		this.r43_amount_aed_resident = r43_amount_aed_resident;
	}

	public BigDecimal getR43_no_acct_fcy_resident() {
		return r43_no_acct_fcy_resident;
	}

	public void setR43_no_acct_fcy_resident(BigDecimal r43_no_acct_fcy_resident) {
		this.r43_no_acct_fcy_resident = r43_no_acct_fcy_resident;
	}

	public BigDecimal getR43_amount_fcy_resident() {
		return r43_amount_fcy_resident;
	}

	public void setR43_amount_fcy_resident(BigDecimal r43_amount_fcy_resident) {
		this.r43_amount_fcy_resident = r43_amount_fcy_resident;
	}

	public BigDecimal getR43_no_acct_aed_non_resident() {
		return r43_no_acct_aed_non_resident;
	}

	public void setR43_no_acct_aed_non_resident(BigDecimal r43_no_acct_aed_non_resident) {
		this.r43_no_acct_aed_non_resident = r43_no_acct_aed_non_resident;
	}

	public BigDecimal getR43_amount_aed_non_resident() {
		return r43_amount_aed_non_resident;
	}

	public void setR43_amount_aed_non_resident(BigDecimal r43_amount_aed_non_resident) {
		this.r43_amount_aed_non_resident = r43_amount_aed_non_resident;
	}

	public BigDecimal getR43_no_acct_fcy_non_resident() {
		return r43_no_acct_fcy_non_resident;
	}

	public void setR43_no_acct_fcy_non_resident(BigDecimal r43_no_acct_fcy_non_resident) {
		this.r43_no_acct_fcy_non_resident = r43_no_acct_fcy_non_resident;
	}

	public BigDecimal getR43_amount_fcy_non_resident() {
		return r43_amount_fcy_non_resident;
	}

	public void setR43_amount_fcy_non_resident(BigDecimal r43_amount_fcy_non_resident) {
		this.r43_amount_fcy_non_resident = r43_amount_fcy_non_resident;
	}

	public BigDecimal getR43_total_amount() {
		return r43_total_amount;
	}

	public void setR43_total_amount(BigDecimal r43_total_amount) {
		this.r43_total_amount = r43_total_amount;
	}

	public String getR44_product() {
		return r44_product;
	}

	public void setR44_product(String r44_product) {
		this.r44_product = r44_product;
	}

	public BigDecimal getR44_no_acct_aed_resident() {
		return r44_no_acct_aed_resident;
	}

	public void setR44_no_acct_aed_resident(BigDecimal r44_no_acct_aed_resident) {
		this.r44_no_acct_aed_resident = r44_no_acct_aed_resident;
	}

	public BigDecimal getR44_amount_aed_resident() {
		return r44_amount_aed_resident;
	}

	public void setR44_amount_aed_resident(BigDecimal r44_amount_aed_resident) {
		this.r44_amount_aed_resident = r44_amount_aed_resident;
	}

	public BigDecimal getR44_no_acct_fcy_resident() {
		return r44_no_acct_fcy_resident;
	}

	public void setR44_no_acct_fcy_resident(BigDecimal r44_no_acct_fcy_resident) {
		this.r44_no_acct_fcy_resident = r44_no_acct_fcy_resident;
	}

	public BigDecimal getR44_amount_fcy_resident() {
		return r44_amount_fcy_resident;
	}

	public void setR44_amount_fcy_resident(BigDecimal r44_amount_fcy_resident) {
		this.r44_amount_fcy_resident = r44_amount_fcy_resident;
	}

	public BigDecimal getR44_no_acct_aed_non_resident() {
		return r44_no_acct_aed_non_resident;
	}

	public void setR44_no_acct_aed_non_resident(BigDecimal r44_no_acct_aed_non_resident) {
		this.r44_no_acct_aed_non_resident = r44_no_acct_aed_non_resident;
	}

	public BigDecimal getR44_amount_aed_non_resident() {
		return r44_amount_aed_non_resident;
	}

	public void setR44_amount_aed_non_resident(BigDecimal r44_amount_aed_non_resident) {
		this.r44_amount_aed_non_resident = r44_amount_aed_non_resident;
	}

	public BigDecimal getR44_no_acct_fcy_non_resident() {
		return r44_no_acct_fcy_non_resident;
	}

	public void setR44_no_acct_fcy_non_resident(BigDecimal r44_no_acct_fcy_non_resident) {
		this.r44_no_acct_fcy_non_resident = r44_no_acct_fcy_non_resident;
	}

	public BigDecimal getR44_amount_fcy_non_resident() {
		return r44_amount_fcy_non_resident;
	}

	public void setR44_amount_fcy_non_resident(BigDecimal r44_amount_fcy_non_resident) {
		this.r44_amount_fcy_non_resident = r44_amount_fcy_non_resident;
	}

	public BigDecimal getR44_total_amount() {
		return r44_total_amount;
	}

	public void setR44_total_amount(BigDecimal r44_total_amount) {
		this.r44_total_amount = r44_total_amount;
	}

	public String getR45_product() {
		return r45_product;
	}

	public void setR45_product(String r45_product) {
		this.r45_product = r45_product;
	}

	public BigDecimal getR45_no_acct_aed_resident() {
		return r45_no_acct_aed_resident;
	}

	public void setR45_no_acct_aed_resident(BigDecimal r45_no_acct_aed_resident) {
		this.r45_no_acct_aed_resident = r45_no_acct_aed_resident;
	}

	public BigDecimal getR45_amount_aed_resident() {
		return r45_amount_aed_resident;
	}

	public void setR45_amount_aed_resident(BigDecimal r45_amount_aed_resident) {
		this.r45_amount_aed_resident = r45_amount_aed_resident;
	}

	public BigDecimal getR45_no_acct_fcy_resident() {
		return r45_no_acct_fcy_resident;
	}

	public void setR45_no_acct_fcy_resident(BigDecimal r45_no_acct_fcy_resident) {
		this.r45_no_acct_fcy_resident = r45_no_acct_fcy_resident;
	}

	public BigDecimal getR45_amount_fcy_resident() {
		return r45_amount_fcy_resident;
	}

	public void setR45_amount_fcy_resident(BigDecimal r45_amount_fcy_resident) {
		this.r45_amount_fcy_resident = r45_amount_fcy_resident;
	}

	public BigDecimal getR45_no_acct_aed_non_resident() {
		return r45_no_acct_aed_non_resident;
	}

	public void setR45_no_acct_aed_non_resident(BigDecimal r45_no_acct_aed_non_resident) {
		this.r45_no_acct_aed_non_resident = r45_no_acct_aed_non_resident;
	}

	public BigDecimal getR45_amount_aed_non_resident() {
		return r45_amount_aed_non_resident;
	}

	public void setR45_amount_aed_non_resident(BigDecimal r45_amount_aed_non_resident) {
		this.r45_amount_aed_non_resident = r45_amount_aed_non_resident;
	}

	public BigDecimal getR45_no_acct_fcy_non_resident() {
		return r45_no_acct_fcy_non_resident;
	}

	public void setR45_no_acct_fcy_non_resident(BigDecimal r45_no_acct_fcy_non_resident) {
		this.r45_no_acct_fcy_non_resident = r45_no_acct_fcy_non_resident;
	}

	public BigDecimal getR45_amount_fcy_non_resident() {
		return r45_amount_fcy_non_resident;
	}

	public void setR45_amount_fcy_non_resident(BigDecimal r45_amount_fcy_non_resident) {
		this.r45_amount_fcy_non_resident = r45_amount_fcy_non_resident;
	}

	public BigDecimal getR45_total_amount() {
		return r45_total_amount;
	}

	public void setR45_total_amount(BigDecimal r45_total_amount) {
		this.r45_total_amount = r45_total_amount;
	}

	public String getR46_product() {
		return r46_product;
	}

	public void setR46_product(String r46_product) {
		this.r46_product = r46_product;
	}

	public BigDecimal getR46_no_acct_aed_resident() {
		return r46_no_acct_aed_resident;
	}

	public void setR46_no_acct_aed_resident(BigDecimal r46_no_acct_aed_resident) {
		this.r46_no_acct_aed_resident = r46_no_acct_aed_resident;
	}

	public BigDecimal getR46_amount_aed_resident() {
		return r46_amount_aed_resident;
	}

	public void setR46_amount_aed_resident(BigDecimal r46_amount_aed_resident) {
		this.r46_amount_aed_resident = r46_amount_aed_resident;
	}

	public BigDecimal getR46_no_acct_fcy_resident() {
		return r46_no_acct_fcy_resident;
	}

	public void setR46_no_acct_fcy_resident(BigDecimal r46_no_acct_fcy_resident) {
		this.r46_no_acct_fcy_resident = r46_no_acct_fcy_resident;
	}

	public BigDecimal getR46_amount_fcy_resident() {
		return r46_amount_fcy_resident;
	}

	public void setR46_amount_fcy_resident(BigDecimal r46_amount_fcy_resident) {
		this.r46_amount_fcy_resident = r46_amount_fcy_resident;
	}

	public BigDecimal getR46_no_acct_aed_non_resident() {
		return r46_no_acct_aed_non_resident;
	}

	public void setR46_no_acct_aed_non_resident(BigDecimal r46_no_acct_aed_non_resident) {
		this.r46_no_acct_aed_non_resident = r46_no_acct_aed_non_resident;
	}

	public BigDecimal getR46_amount_aed_non_resident() {
		return r46_amount_aed_non_resident;
	}

	public void setR46_amount_aed_non_resident(BigDecimal r46_amount_aed_non_resident) {
		this.r46_amount_aed_non_resident = r46_amount_aed_non_resident;
	}

	public BigDecimal getR46_no_acct_fcy_non_resident() {
		return r46_no_acct_fcy_non_resident;
	}

	public void setR46_no_acct_fcy_non_resident(BigDecimal r46_no_acct_fcy_non_resident) {
		this.r46_no_acct_fcy_non_resident = r46_no_acct_fcy_non_resident;
	}

	public BigDecimal getR46_amount_fcy_non_resident() {
		return r46_amount_fcy_non_resident;
	}

	public void setR46_amount_fcy_non_resident(BigDecimal r46_amount_fcy_non_resident) {
		this.r46_amount_fcy_non_resident = r46_amount_fcy_non_resident;
	}

	public BigDecimal getR46_total_amount() {
		return r46_total_amount;
	}

	public void setR46_total_amount(BigDecimal r46_total_amount) {
		this.r46_total_amount = r46_total_amount;
	}

	public String getR47_product() {
		return r47_product;
	}

	public void setR47_product(String r47_product) {
		this.r47_product = r47_product;
	}

	public BigDecimal getR47_no_acct_aed_resident() {
		return r47_no_acct_aed_resident;
	}

	public void setR47_no_acct_aed_resident(BigDecimal r47_no_acct_aed_resident) {
		this.r47_no_acct_aed_resident = r47_no_acct_aed_resident;
	}

	public BigDecimal getR47_amount_aed_resident() {
		return r47_amount_aed_resident;
	}

	public void setR47_amount_aed_resident(BigDecimal r47_amount_aed_resident) {
		this.r47_amount_aed_resident = r47_amount_aed_resident;
	}

	public BigDecimal getR47_no_acct_fcy_resident() {
		return r47_no_acct_fcy_resident;
	}

	public void setR47_no_acct_fcy_resident(BigDecimal r47_no_acct_fcy_resident) {
		this.r47_no_acct_fcy_resident = r47_no_acct_fcy_resident;
	}

	public BigDecimal getR47_amount_fcy_resident() {
		return r47_amount_fcy_resident;
	}

	public void setR47_amount_fcy_resident(BigDecimal r47_amount_fcy_resident) {
		this.r47_amount_fcy_resident = r47_amount_fcy_resident;
	}

	public BigDecimal getR47_no_acct_aed_non_resident() {
		return r47_no_acct_aed_non_resident;
	}

	public void setR47_no_acct_aed_non_resident(BigDecimal r47_no_acct_aed_non_resident) {
		this.r47_no_acct_aed_non_resident = r47_no_acct_aed_non_resident;
	}

	public BigDecimal getR47_amount_aed_non_resident() {
		return r47_amount_aed_non_resident;
	}

	public void setR47_amount_aed_non_resident(BigDecimal r47_amount_aed_non_resident) {
		this.r47_amount_aed_non_resident = r47_amount_aed_non_resident;
	}

	public BigDecimal getR47_no_acct_fcy_non_resident() {
		return r47_no_acct_fcy_non_resident;
	}

	public void setR47_no_acct_fcy_non_resident(BigDecimal r47_no_acct_fcy_non_resident) {
		this.r47_no_acct_fcy_non_resident = r47_no_acct_fcy_non_resident;
	}

	public BigDecimal getR47_amount_fcy_non_resident() {
		return r47_amount_fcy_non_resident;
	}

	public void setR47_amount_fcy_non_resident(BigDecimal r47_amount_fcy_non_resident) {
		this.r47_amount_fcy_non_resident = r47_amount_fcy_non_resident;
	}

	public BigDecimal getR47_total_amount() {
		return r47_total_amount;
	}

	public void setR47_total_amount(BigDecimal r47_total_amount) {
		this.r47_total_amount = r47_total_amount;
	}

	public String getR48_product() {
		return r48_product;
	}

	public void setR48_product(String r48_product) {
		this.r48_product = r48_product;
	}

	public BigDecimal getR48_no_acct_aed_resident() {
		return r48_no_acct_aed_resident;
	}

	public void setR48_no_acct_aed_resident(BigDecimal r48_no_acct_aed_resident) {
		this.r48_no_acct_aed_resident = r48_no_acct_aed_resident;
	}

	public BigDecimal getR48_amount_aed_resident() {
		return r48_amount_aed_resident;
	}

	public void setR48_amount_aed_resident(BigDecimal r48_amount_aed_resident) {
		this.r48_amount_aed_resident = r48_amount_aed_resident;
	}

	public BigDecimal getR48_no_acct_fcy_resident() {
		return r48_no_acct_fcy_resident;
	}

	public void setR48_no_acct_fcy_resident(BigDecimal r48_no_acct_fcy_resident) {
		this.r48_no_acct_fcy_resident = r48_no_acct_fcy_resident;
	}

	public BigDecimal getR48_amount_fcy_resident() {
		return r48_amount_fcy_resident;
	}

	public void setR48_amount_fcy_resident(BigDecimal r48_amount_fcy_resident) {
		this.r48_amount_fcy_resident = r48_amount_fcy_resident;
	}

	public BigDecimal getR48_no_acct_aed_non_resident() {
		return r48_no_acct_aed_non_resident;
	}

	public void setR48_no_acct_aed_non_resident(BigDecimal r48_no_acct_aed_non_resident) {
		this.r48_no_acct_aed_non_resident = r48_no_acct_aed_non_resident;
	}

	public BigDecimal getR48_amount_aed_non_resident() {
		return r48_amount_aed_non_resident;
	}

	public void setR48_amount_aed_non_resident(BigDecimal r48_amount_aed_non_resident) {
		this.r48_amount_aed_non_resident = r48_amount_aed_non_resident;
	}

	public BigDecimal getR48_no_acct_fcy_non_resident() {
		return r48_no_acct_fcy_non_resident;
	}

	public void setR48_no_acct_fcy_non_resident(BigDecimal r48_no_acct_fcy_non_resident) {
		this.r48_no_acct_fcy_non_resident = r48_no_acct_fcy_non_resident;
	}

	public BigDecimal getR48_amount_fcy_non_resident() {
		return r48_amount_fcy_non_resident;
	}

	public void setR48_amount_fcy_non_resident(BigDecimal r48_amount_fcy_non_resident) {
		this.r48_amount_fcy_non_resident = r48_amount_fcy_non_resident;
	}

	public BigDecimal getR48_total_amount() {
		return r48_total_amount;
	}

	public void setR48_total_amount(BigDecimal r48_total_amount) {
		this.r48_total_amount = r48_total_amount;
	}

	public String getR49_product() {
		return r49_product;
	}

	public void setR49_product(String r49_product) {
		this.r49_product = r49_product;
	}

	public BigDecimal getR49_no_acct_aed_resident() {
		return r49_no_acct_aed_resident;
	}

	public void setR49_no_acct_aed_resident(BigDecimal r49_no_acct_aed_resident) {
		this.r49_no_acct_aed_resident = r49_no_acct_aed_resident;
	}

	public BigDecimal getR49_amount_aed_resident() {
		return r49_amount_aed_resident;
	}

	public void setR49_amount_aed_resident(BigDecimal r49_amount_aed_resident) {
		this.r49_amount_aed_resident = r49_amount_aed_resident;
	}

	public BigDecimal getR49_no_acct_fcy_resident() {
		return r49_no_acct_fcy_resident;
	}

	public void setR49_no_acct_fcy_resident(BigDecimal r49_no_acct_fcy_resident) {
		this.r49_no_acct_fcy_resident = r49_no_acct_fcy_resident;
	}

	public BigDecimal getR49_amount_fcy_resident() {
		return r49_amount_fcy_resident;
	}

	public void setR49_amount_fcy_resident(BigDecimal r49_amount_fcy_resident) {
		this.r49_amount_fcy_resident = r49_amount_fcy_resident;
	}

	public BigDecimal getR49_no_acct_aed_non_resident() {
		return r49_no_acct_aed_non_resident;
	}

	public void setR49_no_acct_aed_non_resident(BigDecimal r49_no_acct_aed_non_resident) {
		this.r49_no_acct_aed_non_resident = r49_no_acct_aed_non_resident;
	}

	public BigDecimal getR49_amount_aed_non_resident() {
		return r49_amount_aed_non_resident;
	}

	public void setR49_amount_aed_non_resident(BigDecimal r49_amount_aed_non_resident) {
		this.r49_amount_aed_non_resident = r49_amount_aed_non_resident;
	}

	public BigDecimal getR49_no_acct_fcy_non_resident() {
		return r49_no_acct_fcy_non_resident;
	}

	public void setR49_no_acct_fcy_non_resident(BigDecimal r49_no_acct_fcy_non_resident) {
		this.r49_no_acct_fcy_non_resident = r49_no_acct_fcy_non_resident;
	}

	public BigDecimal getR49_amount_fcy_non_resident() {
		return r49_amount_fcy_non_resident;
	}

	public void setR49_amount_fcy_non_resident(BigDecimal r49_amount_fcy_non_resident) {
		this.r49_amount_fcy_non_resident = r49_amount_fcy_non_resident;
	}

	public BigDecimal getR49_total_amount() {
		return r49_total_amount;
	}

	public void setR49_total_amount(BigDecimal r49_total_amount) {
		this.r49_total_amount = r49_total_amount;
	}

	public String getR50_product() {
		return r50_product;
	}

	public void setR50_product(String r50_product) {
		this.r50_product = r50_product;
	}

	public BigDecimal getR50_no_acct_aed_resident() {
		return r50_no_acct_aed_resident;
	}

	public void setR50_no_acct_aed_resident(BigDecimal r50_no_acct_aed_resident) {
		this.r50_no_acct_aed_resident = r50_no_acct_aed_resident;
	}

	public BigDecimal getR50_amount_aed_resident() {
		return r50_amount_aed_resident;
	}

	public void setR50_amount_aed_resident(BigDecimal r50_amount_aed_resident) {
		this.r50_amount_aed_resident = r50_amount_aed_resident;
	}

	public BigDecimal getR50_no_acct_fcy_resident() {
		return r50_no_acct_fcy_resident;
	}

	public void setR50_no_acct_fcy_resident(BigDecimal r50_no_acct_fcy_resident) {
		this.r50_no_acct_fcy_resident = r50_no_acct_fcy_resident;
	}

	public BigDecimal getR50_amount_fcy_resident() {
		return r50_amount_fcy_resident;
	}

	public void setR50_amount_fcy_resident(BigDecimal r50_amount_fcy_resident) {
		this.r50_amount_fcy_resident = r50_amount_fcy_resident;
	}

	public BigDecimal getR50_no_acct_aed_non_resident() {
		return r50_no_acct_aed_non_resident;
	}

	public void setR50_no_acct_aed_non_resident(BigDecimal r50_no_acct_aed_non_resident) {
		this.r50_no_acct_aed_non_resident = r50_no_acct_aed_non_resident;
	}

	public BigDecimal getR50_amount_aed_non_resident() {
		return r50_amount_aed_non_resident;
	}

	public void setR50_amount_aed_non_resident(BigDecimal r50_amount_aed_non_resident) {
		this.r50_amount_aed_non_resident = r50_amount_aed_non_resident;
	}

	public BigDecimal getR50_no_acct_fcy_non_resident() {
		return r50_no_acct_fcy_non_resident;
	}

	public void setR50_no_acct_fcy_non_resident(BigDecimal r50_no_acct_fcy_non_resident) {
		this.r50_no_acct_fcy_non_resident = r50_no_acct_fcy_non_resident;
	}

	public BigDecimal getR50_amount_fcy_non_resident() {
		return r50_amount_fcy_non_resident;
	}

	public void setR50_amount_fcy_non_resident(BigDecimal r50_amount_fcy_non_resident) {
		this.r50_amount_fcy_non_resident = r50_amount_fcy_non_resident;
	}

	public BigDecimal getR50_total_amount() {
		return r50_total_amount;
	}

	public void setR50_total_amount(BigDecimal r50_total_amount) {
		this.r50_total_amount = r50_total_amount;
	}

	public String getR51_product() {
		return r51_product;
	}

	public void setR51_product(String r51_product) {
		this.r51_product = r51_product;
	}

	public BigDecimal getR51_no_acct_aed_resident() {
		return r51_no_acct_aed_resident;
	}

	public void setR51_no_acct_aed_resident(BigDecimal r51_no_acct_aed_resident) {
		this.r51_no_acct_aed_resident = r51_no_acct_aed_resident;
	}

	public BigDecimal getR51_amount_aed_resident() {
		return r51_amount_aed_resident;
	}

	public void setR51_amount_aed_resident(BigDecimal r51_amount_aed_resident) {
		this.r51_amount_aed_resident = r51_amount_aed_resident;
	}

	public BigDecimal getR51_no_acct_fcy_resident() {
		return r51_no_acct_fcy_resident;
	}

	public void setR51_no_acct_fcy_resident(BigDecimal r51_no_acct_fcy_resident) {
		this.r51_no_acct_fcy_resident = r51_no_acct_fcy_resident;
	}

	public BigDecimal getR51_amount_fcy_resident() {
		return r51_amount_fcy_resident;
	}

	public void setR51_amount_fcy_resident(BigDecimal r51_amount_fcy_resident) {
		this.r51_amount_fcy_resident = r51_amount_fcy_resident;
	}

	public BigDecimal getR51_no_acct_aed_non_resident() {
		return r51_no_acct_aed_non_resident;
	}

	public void setR51_no_acct_aed_non_resident(BigDecimal r51_no_acct_aed_non_resident) {
		this.r51_no_acct_aed_non_resident = r51_no_acct_aed_non_resident;
	}

	public BigDecimal getR51_amount_aed_non_resident() {
		return r51_amount_aed_non_resident;
	}

	public void setR51_amount_aed_non_resident(BigDecimal r51_amount_aed_non_resident) {
		this.r51_amount_aed_non_resident = r51_amount_aed_non_resident;
	}

	public BigDecimal getR51_no_acct_fcy_non_resident() {
		return r51_no_acct_fcy_non_resident;
	}

	public void setR51_no_acct_fcy_non_resident(BigDecimal r51_no_acct_fcy_non_resident) {
		this.r51_no_acct_fcy_non_resident = r51_no_acct_fcy_non_resident;
	}

	public BigDecimal getR51_amount_fcy_non_resident() {
		return r51_amount_fcy_non_resident;
	}

	public void setR51_amount_fcy_non_resident(BigDecimal r51_amount_fcy_non_resident) {
		this.r51_amount_fcy_non_resident = r51_amount_fcy_non_resident;
	}

	public BigDecimal getR51_total_amount() {
		return r51_total_amount;
	}

	public void setR51_total_amount(BigDecimal r51_total_amount) {
		this.r51_total_amount = r51_total_amount;
	}

	public String getR52_product() {
		return r52_product;
	}

	public void setR52_product(String r52_product) {
		this.r52_product = r52_product;
	}

	public BigDecimal getR52_no_acct_aed_resident() {
		return r52_no_acct_aed_resident;
	}

	public void setR52_no_acct_aed_resident(BigDecimal r52_no_acct_aed_resident) {
		this.r52_no_acct_aed_resident = r52_no_acct_aed_resident;
	}

	public BigDecimal getR52_amount_aed_resident() {
		return r52_amount_aed_resident;
	}

	public void setR52_amount_aed_resident(BigDecimal r52_amount_aed_resident) {
		this.r52_amount_aed_resident = r52_amount_aed_resident;
	}

	public BigDecimal getR52_no_acct_fcy_resident() {
		return r52_no_acct_fcy_resident;
	}

	public void setR52_no_acct_fcy_resident(BigDecimal r52_no_acct_fcy_resident) {
		this.r52_no_acct_fcy_resident = r52_no_acct_fcy_resident;
	}

	public BigDecimal getR52_amount_fcy_resident() {
		return r52_amount_fcy_resident;
	}

	public void setR52_amount_fcy_resident(BigDecimal r52_amount_fcy_resident) {
		this.r52_amount_fcy_resident = r52_amount_fcy_resident;
	}

	public BigDecimal getR52_no_acct_aed_non_resident() {
		return r52_no_acct_aed_non_resident;
	}

	public void setR52_no_acct_aed_non_resident(BigDecimal r52_no_acct_aed_non_resident) {
		this.r52_no_acct_aed_non_resident = r52_no_acct_aed_non_resident;
	}

	public BigDecimal getR52_amount_aed_non_resident() {
		return r52_amount_aed_non_resident;
	}

	public void setR52_amount_aed_non_resident(BigDecimal r52_amount_aed_non_resident) {
		this.r52_amount_aed_non_resident = r52_amount_aed_non_resident;
	}

	public BigDecimal getR52_no_acct_fcy_non_resident() {
		return r52_no_acct_fcy_non_resident;
	}

	public void setR52_no_acct_fcy_non_resident(BigDecimal r52_no_acct_fcy_non_resident) {
		this.r52_no_acct_fcy_non_resident = r52_no_acct_fcy_non_resident;
	}

	public BigDecimal getR52_amount_fcy_non_resident() {
		return r52_amount_fcy_non_resident;
	}

	public void setR52_amount_fcy_non_resident(BigDecimal r52_amount_fcy_non_resident) {
		this.r52_amount_fcy_non_resident = r52_amount_fcy_non_resident;
	}

	public BigDecimal getR52_total_amount() {
		return r52_total_amount;
	}

	public void setR52_total_amount(BigDecimal r52_total_amount) {
		this.r52_total_amount = r52_total_amount;
	}

	public String getR53_product() {
		return r53_product;
	}

	public void setR53_product(String r53_product) {
		this.r53_product = r53_product;
	}

	public BigDecimal getR53_no_acct_aed_resident() {
		return r53_no_acct_aed_resident;
	}

	public void setR53_no_acct_aed_resident(BigDecimal r53_no_acct_aed_resident) {
		this.r53_no_acct_aed_resident = r53_no_acct_aed_resident;
	}

	public BigDecimal getR53_amount_aed_resident() {
		return r53_amount_aed_resident;
	}

	public void setR53_amount_aed_resident(BigDecimal r53_amount_aed_resident) {
		this.r53_amount_aed_resident = r53_amount_aed_resident;
	}

	public BigDecimal getR53_no_acct_fcy_resident() {
		return r53_no_acct_fcy_resident;
	}

	public void setR53_no_acct_fcy_resident(BigDecimal r53_no_acct_fcy_resident) {
		this.r53_no_acct_fcy_resident = r53_no_acct_fcy_resident;
	}

	public BigDecimal getR53_amount_fcy_resident() {
		return r53_amount_fcy_resident;
	}

	public void setR53_amount_fcy_resident(BigDecimal r53_amount_fcy_resident) {
		this.r53_amount_fcy_resident = r53_amount_fcy_resident;
	}

	public BigDecimal getR53_no_acct_aed_non_resident() {
		return r53_no_acct_aed_non_resident;
	}

	public void setR53_no_acct_aed_non_resident(BigDecimal r53_no_acct_aed_non_resident) {
		this.r53_no_acct_aed_non_resident = r53_no_acct_aed_non_resident;
	}

	public BigDecimal getR53_amount_aed_non_resident() {
		return r53_amount_aed_non_resident;
	}

	public void setR53_amount_aed_non_resident(BigDecimal r53_amount_aed_non_resident) {
		this.r53_amount_aed_non_resident = r53_amount_aed_non_resident;
	}

	public BigDecimal getR53_no_acct_fcy_non_resident() {
		return r53_no_acct_fcy_non_resident;
	}

	public void setR53_no_acct_fcy_non_resident(BigDecimal r53_no_acct_fcy_non_resident) {
		this.r53_no_acct_fcy_non_resident = r53_no_acct_fcy_non_resident;
	}

	public BigDecimal getR53_amount_fcy_non_resident() {
		return r53_amount_fcy_non_resident;
	}

	public void setR53_amount_fcy_non_resident(BigDecimal r53_amount_fcy_non_resident) {
		this.r53_amount_fcy_non_resident = r53_amount_fcy_non_resident;
	}

	public BigDecimal getR53_total_amount() {
		return r53_total_amount;
	}

	public void setR53_total_amount(BigDecimal r53_total_amount) {
		this.r53_total_amount = r53_total_amount;
	}

	public String getR54_product() {
		return r54_product;
	}

	public void setR54_product(String r54_product) {
		this.r54_product = r54_product;
	}

	public BigDecimal getR54_no_acct_aed_resident() {
		return r54_no_acct_aed_resident;
	}

	public void setR54_no_acct_aed_resident(BigDecimal r54_no_acct_aed_resident) {
		this.r54_no_acct_aed_resident = r54_no_acct_aed_resident;
	}

	public BigDecimal getR54_amount_aed_resident() {
		return r54_amount_aed_resident;
	}

	public void setR54_amount_aed_resident(BigDecimal r54_amount_aed_resident) {
		this.r54_amount_aed_resident = r54_amount_aed_resident;
	}

	public BigDecimal getR54_no_acct_fcy_resident() {
		return r54_no_acct_fcy_resident;
	}

	public void setR54_no_acct_fcy_resident(BigDecimal r54_no_acct_fcy_resident) {
		this.r54_no_acct_fcy_resident = r54_no_acct_fcy_resident;
	}

	public BigDecimal getR54_amount_fcy_resident() {
		return r54_amount_fcy_resident;
	}

	public void setR54_amount_fcy_resident(BigDecimal r54_amount_fcy_resident) {
		this.r54_amount_fcy_resident = r54_amount_fcy_resident;
	}

	public BigDecimal getR54_no_acct_aed_non_resident() {
		return r54_no_acct_aed_non_resident;
	}

	public void setR54_no_acct_aed_non_resident(BigDecimal r54_no_acct_aed_non_resident) {
		this.r54_no_acct_aed_non_resident = r54_no_acct_aed_non_resident;
	}

	public BigDecimal getR54_amount_aed_non_resident() {
		return r54_amount_aed_non_resident;
	}

	public void setR54_amount_aed_non_resident(BigDecimal r54_amount_aed_non_resident) {
		this.r54_amount_aed_non_resident = r54_amount_aed_non_resident;
	}

	public BigDecimal getR54_no_acct_fcy_non_resident() {
		return r54_no_acct_fcy_non_resident;
	}

	public void setR54_no_acct_fcy_non_resident(BigDecimal r54_no_acct_fcy_non_resident) {
		this.r54_no_acct_fcy_non_resident = r54_no_acct_fcy_non_resident;
	}

	public BigDecimal getR54_amount_fcy_non_resident() {
		return r54_amount_fcy_non_resident;
	}

	public void setR54_amount_fcy_non_resident(BigDecimal r54_amount_fcy_non_resident) {
		this.r54_amount_fcy_non_resident = r54_amount_fcy_non_resident;
	}

	public BigDecimal getR54_total_amount() {
		return r54_total_amount;
	}

	public void setR54_total_amount(BigDecimal r54_total_amount) {
		this.r54_total_amount = r54_total_amount;
	}

	public String getR55_product() {
		return r55_product;
	}

	public void setR55_product(String r55_product) {
		this.r55_product = r55_product;
	}

	public BigDecimal getR55_no_acct_aed_resident() {
		return r55_no_acct_aed_resident;
	}

	public void setR55_no_acct_aed_resident(BigDecimal r55_no_acct_aed_resident) {
		this.r55_no_acct_aed_resident = r55_no_acct_aed_resident;
	}

	public BigDecimal getR55_amount_aed_resident() {
		return r55_amount_aed_resident;
	}

	public void setR55_amount_aed_resident(BigDecimal r55_amount_aed_resident) {
		this.r55_amount_aed_resident = r55_amount_aed_resident;
	}

	public BigDecimal getR55_no_acct_fcy_resident() {
		return r55_no_acct_fcy_resident;
	}

	public void setR55_no_acct_fcy_resident(BigDecimal r55_no_acct_fcy_resident) {
		this.r55_no_acct_fcy_resident = r55_no_acct_fcy_resident;
	}

	public BigDecimal getR55_amount_fcy_resident() {
		return r55_amount_fcy_resident;
	}

	public void setR55_amount_fcy_resident(BigDecimal r55_amount_fcy_resident) {
		this.r55_amount_fcy_resident = r55_amount_fcy_resident;
	}

	public BigDecimal getR55_no_acct_aed_non_resident() {
		return r55_no_acct_aed_non_resident;
	}

	public void setR55_no_acct_aed_non_resident(BigDecimal r55_no_acct_aed_non_resident) {
		this.r55_no_acct_aed_non_resident = r55_no_acct_aed_non_resident;
	}

	public BigDecimal getR55_amount_aed_non_resident() {
		return r55_amount_aed_non_resident;
	}

	public void setR55_amount_aed_non_resident(BigDecimal r55_amount_aed_non_resident) {
		this.r55_amount_aed_non_resident = r55_amount_aed_non_resident;
	}

	public BigDecimal getR55_no_acct_fcy_non_resident() {
		return r55_no_acct_fcy_non_resident;
	}

	public void setR55_no_acct_fcy_non_resident(BigDecimal r55_no_acct_fcy_non_resident) {
		this.r55_no_acct_fcy_non_resident = r55_no_acct_fcy_non_resident;
	}

	public BigDecimal getR55_amount_fcy_non_resident() {
		return r55_amount_fcy_non_resident;
	}

	public void setR55_amount_fcy_non_resident(BigDecimal r55_amount_fcy_non_resident) {
		this.r55_amount_fcy_non_resident = r55_amount_fcy_non_resident;
	}

	public BigDecimal getR55_total_amount() {
		return r55_total_amount;
	}

	public void setR55_total_amount(BigDecimal r55_total_amount) {
		this.r55_total_amount = r55_total_amount;
	}

	public String getR56_product() {
		return r56_product;
	}

	public void setR56_product(String r56_product) {
		this.r56_product = r56_product;
	}

	public BigDecimal getR56_no_acct_aed_resident() {
		return r56_no_acct_aed_resident;
	}

	public void setR56_no_acct_aed_resident(BigDecimal r56_no_acct_aed_resident) {
		this.r56_no_acct_aed_resident = r56_no_acct_aed_resident;
	}

	public BigDecimal getR56_amount_aed_resident() {
		return r56_amount_aed_resident;
	}

	public void setR56_amount_aed_resident(BigDecimal r56_amount_aed_resident) {
		this.r56_amount_aed_resident = r56_amount_aed_resident;
	}

	public BigDecimal getR56_no_acct_fcy_resident() {
		return r56_no_acct_fcy_resident;
	}

	public void setR56_no_acct_fcy_resident(BigDecimal r56_no_acct_fcy_resident) {
		this.r56_no_acct_fcy_resident = r56_no_acct_fcy_resident;
	}

	public BigDecimal getR56_amount_fcy_resident() {
		return r56_amount_fcy_resident;
	}

	public void setR56_amount_fcy_resident(BigDecimal r56_amount_fcy_resident) {
		this.r56_amount_fcy_resident = r56_amount_fcy_resident;
	}

	public BigDecimal getR56_no_acct_aed_non_resident() {
		return r56_no_acct_aed_non_resident;
	}

	public void setR56_no_acct_aed_non_resident(BigDecimal r56_no_acct_aed_non_resident) {
		this.r56_no_acct_aed_non_resident = r56_no_acct_aed_non_resident;
	}

	public BigDecimal getR56_amount_aed_non_resident() {
		return r56_amount_aed_non_resident;
	}

	public void setR56_amount_aed_non_resident(BigDecimal r56_amount_aed_non_resident) {
		this.r56_amount_aed_non_resident = r56_amount_aed_non_resident;
	}

	public BigDecimal getR56_no_acct_fcy_non_resident() {
		return r56_no_acct_fcy_non_resident;
	}

	public void setR56_no_acct_fcy_non_resident(BigDecimal r56_no_acct_fcy_non_resident) {
		this.r56_no_acct_fcy_non_resident = r56_no_acct_fcy_non_resident;
	}

	public BigDecimal getR56_amount_fcy_non_resident() {
		return r56_amount_fcy_non_resident;
	}

	public void setR56_amount_fcy_non_resident(BigDecimal r56_amount_fcy_non_resident) {
		this.r56_amount_fcy_non_resident = r56_amount_fcy_non_resident;
	}

	public BigDecimal getR56_total_amount() {
		return r56_total_amount;
	}

	public void setR56_total_amount(BigDecimal r56_total_amount) {
		this.r56_total_amount = r56_total_amount;
	}

	public String getR57_product() {
		return r57_product;
	}

	public void setR57_product(String r57_product) {
		this.r57_product = r57_product;
	}

	public BigDecimal getR57_no_acct_aed_resident() {
		return r57_no_acct_aed_resident;
	}

	public void setR57_no_acct_aed_resident(BigDecimal r57_no_acct_aed_resident) {
		this.r57_no_acct_aed_resident = r57_no_acct_aed_resident;
	}

	public BigDecimal getR57_amount_aed_resident() {
		return r57_amount_aed_resident;
	}

	public void setR57_amount_aed_resident(BigDecimal r57_amount_aed_resident) {
		this.r57_amount_aed_resident = r57_amount_aed_resident;
	}

	public BigDecimal getR57_no_acct_fcy_resident() {
		return r57_no_acct_fcy_resident;
	}

	public void setR57_no_acct_fcy_resident(BigDecimal r57_no_acct_fcy_resident) {
		this.r57_no_acct_fcy_resident = r57_no_acct_fcy_resident;
	}

	public BigDecimal getR57_amount_fcy_resident() {
		return r57_amount_fcy_resident;
	}

	public void setR57_amount_fcy_resident(BigDecimal r57_amount_fcy_resident) {
		this.r57_amount_fcy_resident = r57_amount_fcy_resident;
	}

	public BigDecimal getR57_no_acct_aed_non_resident() {
		return r57_no_acct_aed_non_resident;
	}

	public void setR57_no_acct_aed_non_resident(BigDecimal r57_no_acct_aed_non_resident) {
		this.r57_no_acct_aed_non_resident = r57_no_acct_aed_non_resident;
	}

	public BigDecimal getR57_amount_aed_non_resident() {
		return r57_amount_aed_non_resident;
	}

	public void setR57_amount_aed_non_resident(BigDecimal r57_amount_aed_non_resident) {
		this.r57_amount_aed_non_resident = r57_amount_aed_non_resident;
	}

	public BigDecimal getR57_no_acct_fcy_non_resident() {
		return r57_no_acct_fcy_non_resident;
	}

	public void setR57_no_acct_fcy_non_resident(BigDecimal r57_no_acct_fcy_non_resident) {
		this.r57_no_acct_fcy_non_resident = r57_no_acct_fcy_non_resident;
	}

	public BigDecimal getR57_amount_fcy_non_resident() {
		return r57_amount_fcy_non_resident;
	}

	public void setR57_amount_fcy_non_resident(BigDecimal r57_amount_fcy_non_resident) {
		this.r57_amount_fcy_non_resident = r57_amount_fcy_non_resident;
	}

	public BigDecimal getR57_total_amount() {
		return r57_total_amount;
	}

	public void setR57_total_amount(BigDecimal r57_total_amount) {
		this.r57_total_amount = r57_total_amount;
	}

	public String getR58_product() {
		return r58_product;
	}

	public void setR58_product(String r58_product) {
		this.r58_product = r58_product;
	}

	public BigDecimal getR58_no_acct_aed_resident() {
		return r58_no_acct_aed_resident;
	}

	public void setR58_no_acct_aed_resident(BigDecimal r58_no_acct_aed_resident) {
		this.r58_no_acct_aed_resident = r58_no_acct_aed_resident;
	}

	public BigDecimal getR58_amount_aed_resident() {
		return r58_amount_aed_resident;
	}

	public void setR58_amount_aed_resident(BigDecimal r58_amount_aed_resident) {
		this.r58_amount_aed_resident = r58_amount_aed_resident;
	}

	public BigDecimal getR58_no_acct_fcy_resident() {
		return r58_no_acct_fcy_resident;
	}

	public void setR58_no_acct_fcy_resident(BigDecimal r58_no_acct_fcy_resident) {
		this.r58_no_acct_fcy_resident = r58_no_acct_fcy_resident;
	}

	public BigDecimal getR58_amount_fcy_resident() {
		return r58_amount_fcy_resident;
	}

	public void setR58_amount_fcy_resident(BigDecimal r58_amount_fcy_resident) {
		this.r58_amount_fcy_resident = r58_amount_fcy_resident;
	}

	public BigDecimal getR58_no_acct_aed_non_resident() {
		return r58_no_acct_aed_non_resident;
	}

	public void setR58_no_acct_aed_non_resident(BigDecimal r58_no_acct_aed_non_resident) {
		this.r58_no_acct_aed_non_resident = r58_no_acct_aed_non_resident;
	}

	public BigDecimal getR58_amount_aed_non_resident() {
		return r58_amount_aed_non_resident;
	}

	public void setR58_amount_aed_non_resident(BigDecimal r58_amount_aed_non_resident) {
		this.r58_amount_aed_non_resident = r58_amount_aed_non_resident;
	}

	public BigDecimal getR58_no_acct_fcy_non_resident() {
		return r58_no_acct_fcy_non_resident;
	}

	public void setR58_no_acct_fcy_non_resident(BigDecimal r58_no_acct_fcy_non_resident) {
		this.r58_no_acct_fcy_non_resident = r58_no_acct_fcy_non_resident;
	}

	public BigDecimal getR58_amount_fcy_non_resident() {
		return r58_amount_fcy_non_resident;
	}

	public void setR58_amount_fcy_non_resident(BigDecimal r58_amount_fcy_non_resident) {
		this.r58_amount_fcy_non_resident = r58_amount_fcy_non_resident;
	}

	public BigDecimal getR58_total_amount() {
		return r58_total_amount;
	}

	public void setR58_total_amount(BigDecimal r58_total_amount) {
		this.r58_total_amount = r58_total_amount;
	}

	public String getR59_product() {
		return r59_product;
	}

	public void setR59_product(String r59_product) {
		this.r59_product = r59_product;
	}

	public BigDecimal getR59_no_acct_aed_resident() {
		return r59_no_acct_aed_resident;
	}

	public void setR59_no_acct_aed_resident(BigDecimal r59_no_acct_aed_resident) {
		this.r59_no_acct_aed_resident = r59_no_acct_aed_resident;
	}

	public BigDecimal getR59_amount_aed_resident() {
		return r59_amount_aed_resident;
	}

	public void setR59_amount_aed_resident(BigDecimal r59_amount_aed_resident) {
		this.r59_amount_aed_resident = r59_amount_aed_resident;
	}

	public BigDecimal getR59_no_acct_fcy_resident() {
		return r59_no_acct_fcy_resident;
	}

	public void setR59_no_acct_fcy_resident(BigDecimal r59_no_acct_fcy_resident) {
		this.r59_no_acct_fcy_resident = r59_no_acct_fcy_resident;
	}

	public BigDecimal getR59_amount_fcy_resident() {
		return r59_amount_fcy_resident;
	}

	public void setR59_amount_fcy_resident(BigDecimal r59_amount_fcy_resident) {
		this.r59_amount_fcy_resident = r59_amount_fcy_resident;
	}

	public BigDecimal getR59_no_acct_aed_non_resident() {
		return r59_no_acct_aed_non_resident;
	}

	public void setR59_no_acct_aed_non_resident(BigDecimal r59_no_acct_aed_non_resident) {
		this.r59_no_acct_aed_non_resident = r59_no_acct_aed_non_resident;
	}

	public BigDecimal getR59_amount_aed_non_resident() {
		return r59_amount_aed_non_resident;
	}

	public void setR59_amount_aed_non_resident(BigDecimal r59_amount_aed_non_resident) {
		this.r59_amount_aed_non_resident = r59_amount_aed_non_resident;
	}

	public BigDecimal getR59_no_acct_fcy_non_resident() {
		return r59_no_acct_fcy_non_resident;
	}

	public void setR59_no_acct_fcy_non_resident(BigDecimal r59_no_acct_fcy_non_resident) {
		this.r59_no_acct_fcy_non_resident = r59_no_acct_fcy_non_resident;
	}

	public BigDecimal getR59_amount_fcy_non_resident() {
		return r59_amount_fcy_non_resident;
	}

	public void setR59_amount_fcy_non_resident(BigDecimal r59_amount_fcy_non_resident) {
		this.r59_amount_fcy_non_resident = r59_amount_fcy_non_resident;
	}

	public BigDecimal getR59_total_amount() {
		return r59_total_amount;
	}

	public void setR59_total_amount(BigDecimal r59_total_amount) {
		this.r59_total_amount = r59_total_amount;
	}

	public String getR60_product() {
		return r60_product;
	}

	public void setR60_product(String r60_product) {
		this.r60_product = r60_product;
	}

	public BigDecimal getR60_no_acct_aed_resident() {
		return r60_no_acct_aed_resident;
	}

	public void setR60_no_acct_aed_resident(BigDecimal r60_no_acct_aed_resident) {
		this.r60_no_acct_aed_resident = r60_no_acct_aed_resident;
	}

	public BigDecimal getR60_amount_aed_resident() {
		return r60_amount_aed_resident;
	}

	public void setR60_amount_aed_resident(BigDecimal r60_amount_aed_resident) {
		this.r60_amount_aed_resident = r60_amount_aed_resident;
	}

	public BigDecimal getR60_no_acct_fcy_resident() {
		return r60_no_acct_fcy_resident;
	}

	public void setR60_no_acct_fcy_resident(BigDecimal r60_no_acct_fcy_resident) {
		this.r60_no_acct_fcy_resident = r60_no_acct_fcy_resident;
	}

	public BigDecimal getR60_amount_fcy_resident() {
		return r60_amount_fcy_resident;
	}

	public void setR60_amount_fcy_resident(BigDecimal r60_amount_fcy_resident) {
		this.r60_amount_fcy_resident = r60_amount_fcy_resident;
	}

	public BigDecimal getR60_no_acct_aed_non_resident() {
		return r60_no_acct_aed_non_resident;
	}

	public void setR60_no_acct_aed_non_resident(BigDecimal r60_no_acct_aed_non_resident) {
		this.r60_no_acct_aed_non_resident = r60_no_acct_aed_non_resident;
	}

	public BigDecimal getR60_amount_aed_non_resident() {
		return r60_amount_aed_non_resident;
	}

	public void setR60_amount_aed_non_resident(BigDecimal r60_amount_aed_non_resident) {
		this.r60_amount_aed_non_resident = r60_amount_aed_non_resident;
	}

	public BigDecimal getR60_no_acct_fcy_non_resident() {
		return r60_no_acct_fcy_non_resident;
	}

	public void setR60_no_acct_fcy_non_resident(BigDecimal r60_no_acct_fcy_non_resident) {
		this.r60_no_acct_fcy_non_resident = r60_no_acct_fcy_non_resident;
	}

	public BigDecimal getR60_amount_fcy_non_resident() {
		return r60_amount_fcy_non_resident;
	}

	public void setR60_amount_fcy_non_resident(BigDecimal r60_amount_fcy_non_resident) {
		this.r60_amount_fcy_non_resident = r60_amount_fcy_non_resident;
	}

	public BigDecimal getR60_total_amount() {
		return r60_total_amount;
	}

	public void setR60_total_amount(BigDecimal r60_total_amount) {
		this.r60_total_amount = r60_total_amount;
	}

	public String getR61_product() {
		return r61_product;
	}

	public void setR61_product(String r61_product) {
		this.r61_product = r61_product;
	}

	public BigDecimal getR61_no_acct_aed_resident() {
		return r61_no_acct_aed_resident;
	}

	public void setR61_no_acct_aed_resident(BigDecimal r61_no_acct_aed_resident) {
		this.r61_no_acct_aed_resident = r61_no_acct_aed_resident;
	}

	public BigDecimal getR61_amount_aed_resident() {
		return r61_amount_aed_resident;
	}

	public void setR61_amount_aed_resident(BigDecimal r61_amount_aed_resident) {
		this.r61_amount_aed_resident = r61_amount_aed_resident;
	}

	public BigDecimal getR61_no_acct_fcy_resident() {
		return r61_no_acct_fcy_resident;
	}

	public void setR61_no_acct_fcy_resident(BigDecimal r61_no_acct_fcy_resident) {
		this.r61_no_acct_fcy_resident = r61_no_acct_fcy_resident;
	}

	public BigDecimal getR61_amount_fcy_resident() {
		return r61_amount_fcy_resident;
	}

	public void setR61_amount_fcy_resident(BigDecimal r61_amount_fcy_resident) {
		this.r61_amount_fcy_resident = r61_amount_fcy_resident;
	}

	public BigDecimal getR61_no_acct_aed_non_resident() {
		return r61_no_acct_aed_non_resident;
	}

	public void setR61_no_acct_aed_non_resident(BigDecimal r61_no_acct_aed_non_resident) {
		this.r61_no_acct_aed_non_resident = r61_no_acct_aed_non_resident;
	}

	public BigDecimal getR61_amount_aed_non_resident() {
		return r61_amount_aed_non_resident;
	}

	public void setR61_amount_aed_non_resident(BigDecimal r61_amount_aed_non_resident) {
		this.r61_amount_aed_non_resident = r61_amount_aed_non_resident;
	}

	public BigDecimal getR61_no_acct_fcy_non_resident() {
		return r61_no_acct_fcy_non_resident;
	}

	public void setR61_no_acct_fcy_non_resident(BigDecimal r61_no_acct_fcy_non_resident) {
		this.r61_no_acct_fcy_non_resident = r61_no_acct_fcy_non_resident;
	}

	public BigDecimal getR61_amount_fcy_non_resident() {
		return r61_amount_fcy_non_resident;
	}

	public void setR61_amount_fcy_non_resident(BigDecimal r61_amount_fcy_non_resident) {
		this.r61_amount_fcy_non_resident = r61_amount_fcy_non_resident;
	}

	public BigDecimal getR61_total_amount() {
		return r61_total_amount;
	}

	public void setR61_total_amount(BigDecimal r61_total_amount) {
		this.r61_total_amount = r61_total_amount;
	}

	public String getR62_product() {
		return r62_product;
	}

	public void setR62_product(String r62_product) {
		this.r62_product = r62_product;
	}

	public BigDecimal getR62_no_acct_aed_resident() {
		return r62_no_acct_aed_resident;
	}

	public void setR62_no_acct_aed_resident(BigDecimal r62_no_acct_aed_resident) {
		this.r62_no_acct_aed_resident = r62_no_acct_aed_resident;
	}

	public BigDecimal getR62_amount_aed_resident() {
		return r62_amount_aed_resident;
	}

	public void setR62_amount_aed_resident(BigDecimal r62_amount_aed_resident) {
		this.r62_amount_aed_resident = r62_amount_aed_resident;
	}

	public BigDecimal getR62_no_acct_fcy_resident() {
		return r62_no_acct_fcy_resident;
	}

	public void setR62_no_acct_fcy_resident(BigDecimal r62_no_acct_fcy_resident) {
		this.r62_no_acct_fcy_resident = r62_no_acct_fcy_resident;
	}

	public BigDecimal getR62_amount_fcy_resident() {
		return r62_amount_fcy_resident;
	}

	public void setR62_amount_fcy_resident(BigDecimal r62_amount_fcy_resident) {
		this.r62_amount_fcy_resident = r62_amount_fcy_resident;
	}

	public BigDecimal getR62_no_acct_aed_non_resident() {
		return r62_no_acct_aed_non_resident;
	}

	public void setR62_no_acct_aed_non_resident(BigDecimal r62_no_acct_aed_non_resident) {
		this.r62_no_acct_aed_non_resident = r62_no_acct_aed_non_resident;
	}

	public BigDecimal getR62_amount_aed_non_resident() {
		return r62_amount_aed_non_resident;
	}

	public void setR62_amount_aed_non_resident(BigDecimal r62_amount_aed_non_resident) {
		this.r62_amount_aed_non_resident = r62_amount_aed_non_resident;
	}

	public BigDecimal getR62_no_acct_fcy_non_resident() {
		return r62_no_acct_fcy_non_resident;
	}

	public void setR62_no_acct_fcy_non_resident(BigDecimal r62_no_acct_fcy_non_resident) {
		this.r62_no_acct_fcy_non_resident = r62_no_acct_fcy_non_resident;
	}

	public BigDecimal getR62_amount_fcy_non_resident() {
		return r62_amount_fcy_non_resident;
	}

	public void setR62_amount_fcy_non_resident(BigDecimal r62_amount_fcy_non_resident) {
		this.r62_amount_fcy_non_resident = r62_amount_fcy_non_resident;
	}

	public BigDecimal getR62_total_amount() {
		return r62_total_amount;
	}

	public void setR62_total_amount(BigDecimal r62_total_amount) {
		this.r62_total_amount = r62_total_amount;
	}

	public String getR63_product() {
		return r63_product;
	}

	public void setR63_product(String r63_product) {
		this.r63_product = r63_product;
	}

	public BigDecimal getR63_no_acct_aed_resident() {
		return r63_no_acct_aed_resident;
	}

	public void setR63_no_acct_aed_resident(BigDecimal r63_no_acct_aed_resident) {
		this.r63_no_acct_aed_resident = r63_no_acct_aed_resident;
	}

	public BigDecimal getR63_amount_aed_resident() {
		return r63_amount_aed_resident;
	}

	public void setR63_amount_aed_resident(BigDecimal r63_amount_aed_resident) {
		this.r63_amount_aed_resident = r63_amount_aed_resident;
	}

	public BigDecimal getR63_no_acct_fcy_resident() {
		return r63_no_acct_fcy_resident;
	}

	public void setR63_no_acct_fcy_resident(BigDecimal r63_no_acct_fcy_resident) {
		this.r63_no_acct_fcy_resident = r63_no_acct_fcy_resident;
	}

	public BigDecimal getR63_amount_fcy_resident() {
		return r63_amount_fcy_resident;
	}

	public void setR63_amount_fcy_resident(BigDecimal r63_amount_fcy_resident) {
		this.r63_amount_fcy_resident = r63_amount_fcy_resident;
	}

	public BigDecimal getR63_no_acct_aed_non_resident() {
		return r63_no_acct_aed_non_resident;
	}

	public void setR63_no_acct_aed_non_resident(BigDecimal r63_no_acct_aed_non_resident) {
		this.r63_no_acct_aed_non_resident = r63_no_acct_aed_non_resident;
	}

	public BigDecimal getR63_amount_aed_non_resident() {
		return r63_amount_aed_non_resident;
	}

	public void setR63_amount_aed_non_resident(BigDecimal r63_amount_aed_non_resident) {
		this.r63_amount_aed_non_resident = r63_amount_aed_non_resident;
	}

	public BigDecimal getR63_no_acct_fcy_non_resident() {
		return r63_no_acct_fcy_non_resident;
	}

	public void setR63_no_acct_fcy_non_resident(BigDecimal r63_no_acct_fcy_non_resident) {
		this.r63_no_acct_fcy_non_resident = r63_no_acct_fcy_non_resident;
	}

	public BigDecimal getR63_amount_fcy_non_resident() {
		return r63_amount_fcy_non_resident;
	}

	public void setR63_amount_fcy_non_resident(BigDecimal r63_amount_fcy_non_resident) {
		this.r63_amount_fcy_non_resident = r63_amount_fcy_non_resident;
	}

	public BigDecimal getR63_total_amount() {
		return r63_total_amount;
	}

	public void setR63_total_amount(BigDecimal r63_total_amount) {
		this.r63_total_amount = r63_total_amount;
	}

	public String getR64_product() {
		return r64_product;
	}

	public void setR64_product(String r64_product) {
		this.r64_product = r64_product;
	}

	public BigDecimal getR64_no_acct_aed_resident() {
		return r64_no_acct_aed_resident;
	}

	public void setR64_no_acct_aed_resident(BigDecimal r64_no_acct_aed_resident) {
		this.r64_no_acct_aed_resident = r64_no_acct_aed_resident;
	}

	public BigDecimal getR64_amount_aed_resident() {
		return r64_amount_aed_resident;
	}

	public void setR64_amount_aed_resident(BigDecimal r64_amount_aed_resident) {
		this.r64_amount_aed_resident = r64_amount_aed_resident;
	}

	public BigDecimal getR64_no_acct_fcy_resident() {
		return r64_no_acct_fcy_resident;
	}

	public void setR64_no_acct_fcy_resident(BigDecimal r64_no_acct_fcy_resident) {
		this.r64_no_acct_fcy_resident = r64_no_acct_fcy_resident;
	}

	public BigDecimal getR64_amount_fcy_resident() {
		return r64_amount_fcy_resident;
	}

	public void setR64_amount_fcy_resident(BigDecimal r64_amount_fcy_resident) {
		this.r64_amount_fcy_resident = r64_amount_fcy_resident;
	}

	public BigDecimal getR64_no_acct_aed_non_resident() {
		return r64_no_acct_aed_non_resident;
	}

	public void setR64_no_acct_aed_non_resident(BigDecimal r64_no_acct_aed_non_resident) {
		this.r64_no_acct_aed_non_resident = r64_no_acct_aed_non_resident;
	}

	public BigDecimal getR64_amount_aed_non_resident() {
		return r64_amount_aed_non_resident;
	}

	public void setR64_amount_aed_non_resident(BigDecimal r64_amount_aed_non_resident) {
		this.r64_amount_aed_non_resident = r64_amount_aed_non_resident;
	}

	public BigDecimal getR64_no_acct_fcy_non_resident() {
		return r64_no_acct_fcy_non_resident;
	}

	public void setR64_no_acct_fcy_non_resident(BigDecimal r64_no_acct_fcy_non_resident) {
		this.r64_no_acct_fcy_non_resident = r64_no_acct_fcy_non_resident;
	}

	public BigDecimal getR64_amount_fcy_non_resident() {
		return r64_amount_fcy_non_resident;
	}

	public void setR64_amount_fcy_non_resident(BigDecimal r64_amount_fcy_non_resident) {
		this.r64_amount_fcy_non_resident = r64_amount_fcy_non_resident;
	}

	public BigDecimal getR64_total_amount() {
		return r64_total_amount;
	}

	public void setR64_total_amount(BigDecimal r64_total_amount) {
		this.r64_total_amount = r64_total_amount;
	}

	public String getR65_product() {
		return r65_product;
	}

	public void setR65_product(String r65_product) {
		this.r65_product = r65_product;
	}

	public BigDecimal getR65_no_acct_aed_resident() {
		return r65_no_acct_aed_resident;
	}

	public void setR65_no_acct_aed_resident(BigDecimal r65_no_acct_aed_resident) {
		this.r65_no_acct_aed_resident = r65_no_acct_aed_resident;
	}

	public BigDecimal getR65_amount_aed_resident() {
		return r65_amount_aed_resident;
	}

	public void setR65_amount_aed_resident(BigDecimal r65_amount_aed_resident) {
		this.r65_amount_aed_resident = r65_amount_aed_resident;
	}

	public BigDecimal getR65_no_acct_fcy_resident() {
		return r65_no_acct_fcy_resident;
	}

	public void setR65_no_acct_fcy_resident(BigDecimal r65_no_acct_fcy_resident) {
		this.r65_no_acct_fcy_resident = r65_no_acct_fcy_resident;
	}

	public BigDecimal getR65_amount_fcy_resident() {
		return r65_amount_fcy_resident;
	}

	public void setR65_amount_fcy_resident(BigDecimal r65_amount_fcy_resident) {
		this.r65_amount_fcy_resident = r65_amount_fcy_resident;
	}

	public BigDecimal getR65_no_acct_aed_non_resident() {
		return r65_no_acct_aed_non_resident;
	}

	public void setR65_no_acct_aed_non_resident(BigDecimal r65_no_acct_aed_non_resident) {
		this.r65_no_acct_aed_non_resident = r65_no_acct_aed_non_resident;
	}

	public BigDecimal getR65_amount_aed_non_resident() {
		return r65_amount_aed_non_resident;
	}

	public void setR65_amount_aed_non_resident(BigDecimal r65_amount_aed_non_resident) {
		this.r65_amount_aed_non_resident = r65_amount_aed_non_resident;
	}

	public BigDecimal getR65_no_acct_fcy_non_resident() {
		return r65_no_acct_fcy_non_resident;
	}

	public void setR65_no_acct_fcy_non_resident(BigDecimal r65_no_acct_fcy_non_resident) {
		this.r65_no_acct_fcy_non_resident = r65_no_acct_fcy_non_resident;
	}

	public BigDecimal getR65_amount_fcy_non_resident() {
		return r65_amount_fcy_non_resident;
	}

	public void setR65_amount_fcy_non_resident(BigDecimal r65_amount_fcy_non_resident) {
		this.r65_amount_fcy_non_resident = r65_amount_fcy_non_resident;
	}

	public BigDecimal getR65_total_amount() {
		return r65_total_amount;
	}

	public void setR65_total_amount(BigDecimal r65_total_amount) {
		this.r65_total_amount = r65_total_amount;
	}

	public String getR66_product() {
		return r66_product;
	}

	public void setR66_product(String r66_product) {
		this.r66_product = r66_product;
	}

	public BigDecimal getR66_no_acct_aed_resident() {
		return r66_no_acct_aed_resident;
	}

	public void setR66_no_acct_aed_resident(BigDecimal r66_no_acct_aed_resident) {
		this.r66_no_acct_aed_resident = r66_no_acct_aed_resident;
	}

	public BigDecimal getR66_amount_aed_resident() {
		return r66_amount_aed_resident;
	}

	public void setR66_amount_aed_resident(BigDecimal r66_amount_aed_resident) {
		this.r66_amount_aed_resident = r66_amount_aed_resident;
	}

	public BigDecimal getR66_no_acct_fcy_resident() {
		return r66_no_acct_fcy_resident;
	}

	public void setR66_no_acct_fcy_resident(BigDecimal r66_no_acct_fcy_resident) {
		this.r66_no_acct_fcy_resident = r66_no_acct_fcy_resident;
	}

	public BigDecimal getR66_amount_fcy_resident() {
		return r66_amount_fcy_resident;
	}

	public void setR66_amount_fcy_resident(BigDecimal r66_amount_fcy_resident) {
		this.r66_amount_fcy_resident = r66_amount_fcy_resident;
	}

	public BigDecimal getR66_no_acct_aed_non_resident() {
		return r66_no_acct_aed_non_resident;
	}

	public void setR66_no_acct_aed_non_resident(BigDecimal r66_no_acct_aed_non_resident) {
		this.r66_no_acct_aed_non_resident = r66_no_acct_aed_non_resident;
	}

	public BigDecimal getR66_amount_aed_non_resident() {
		return r66_amount_aed_non_resident;
	}

	public void setR66_amount_aed_non_resident(BigDecimal r66_amount_aed_non_resident) {
		this.r66_amount_aed_non_resident = r66_amount_aed_non_resident;
	}

	public BigDecimal getR66_no_acct_fcy_non_resident() {
		return r66_no_acct_fcy_non_resident;
	}

	public void setR66_no_acct_fcy_non_resident(BigDecimal r66_no_acct_fcy_non_resident) {
		this.r66_no_acct_fcy_non_resident = r66_no_acct_fcy_non_resident;
	}

	public BigDecimal getR66_amount_fcy_non_resident() {
		return r66_amount_fcy_non_resident;
	}

	public void setR66_amount_fcy_non_resident(BigDecimal r66_amount_fcy_non_resident) {
		this.r66_amount_fcy_non_resident = r66_amount_fcy_non_resident;
	}

	public BigDecimal getR66_total_amount() {
		return r66_total_amount;
	}

	public void setR66_total_amount(BigDecimal r66_total_amount) {
		this.r66_total_amount = r66_total_amount;
	}

	public String getR67_product() {
		return r67_product;
	}

	public void setR67_product(String r67_product) {
		this.r67_product = r67_product;
	}

	public BigDecimal getR67_no_acct_aed_resident() {
		return r67_no_acct_aed_resident;
	}

	public void setR67_no_acct_aed_resident(BigDecimal r67_no_acct_aed_resident) {
		this.r67_no_acct_aed_resident = r67_no_acct_aed_resident;
	}

	public BigDecimal getR67_amount_aed_resident() {
		return r67_amount_aed_resident;
	}

	public void setR67_amount_aed_resident(BigDecimal r67_amount_aed_resident) {
		this.r67_amount_aed_resident = r67_amount_aed_resident;
	}

	public BigDecimal getR67_no_acct_fcy_resident() {
		return r67_no_acct_fcy_resident;
	}

	public void setR67_no_acct_fcy_resident(BigDecimal r67_no_acct_fcy_resident) {
		this.r67_no_acct_fcy_resident = r67_no_acct_fcy_resident;
	}

	public BigDecimal getR67_amount_fcy_resident() {
		return r67_amount_fcy_resident;
	}

	public void setR67_amount_fcy_resident(BigDecimal r67_amount_fcy_resident) {
		this.r67_amount_fcy_resident = r67_amount_fcy_resident;
	}

	public BigDecimal getR67_no_acct_aed_non_resident() {
		return r67_no_acct_aed_non_resident;
	}

	public void setR67_no_acct_aed_non_resident(BigDecimal r67_no_acct_aed_non_resident) {
		this.r67_no_acct_aed_non_resident = r67_no_acct_aed_non_resident;
	}

	public BigDecimal getR67_amount_aed_non_resident() {
		return r67_amount_aed_non_resident;
	}

	public void setR67_amount_aed_non_resident(BigDecimal r67_amount_aed_non_resident) {
		this.r67_amount_aed_non_resident = r67_amount_aed_non_resident;
	}

	public BigDecimal getR67_no_acct_fcy_non_resident() {
		return r67_no_acct_fcy_non_resident;
	}

	public void setR67_no_acct_fcy_non_resident(BigDecimal r67_no_acct_fcy_non_resident) {
		this.r67_no_acct_fcy_non_resident = r67_no_acct_fcy_non_resident;
	}

	public BigDecimal getR67_amount_fcy_non_resident() {
		return r67_amount_fcy_non_resident;
	}

	public void setR67_amount_fcy_non_resident(BigDecimal r67_amount_fcy_non_resident) {
		this.r67_amount_fcy_non_resident = r67_amount_fcy_non_resident;
	}

	public BigDecimal getR67_total_amount() {
		return r67_total_amount;
	}

	public void setR67_total_amount(BigDecimal r67_total_amount) {
		this.r67_total_amount = r67_total_amount;
	}

	public String getR68_product() {
		return r68_product;
	}

	public void setR68_product(String r68_product) {
		this.r68_product = r68_product;
	}

	public BigDecimal getR68_no_acct_aed_resident() {
		return r68_no_acct_aed_resident;
	}

	public void setR68_no_acct_aed_resident(BigDecimal r68_no_acct_aed_resident) {
		this.r68_no_acct_aed_resident = r68_no_acct_aed_resident;
	}

	public BigDecimal getR68_amount_aed_resident() {
		return r68_amount_aed_resident;
	}

	public void setR68_amount_aed_resident(BigDecimal r68_amount_aed_resident) {
		this.r68_amount_aed_resident = r68_amount_aed_resident;
	}

	public BigDecimal getR68_no_acct_fcy_resident() {
		return r68_no_acct_fcy_resident;
	}

	public void setR68_no_acct_fcy_resident(BigDecimal r68_no_acct_fcy_resident) {
		this.r68_no_acct_fcy_resident = r68_no_acct_fcy_resident;
	}

	public BigDecimal getR68_amount_fcy_resident() {
		return r68_amount_fcy_resident;
	}

	public void setR68_amount_fcy_resident(BigDecimal r68_amount_fcy_resident) {
		this.r68_amount_fcy_resident = r68_amount_fcy_resident;
	}

	public BigDecimal getR68_no_acct_aed_non_resident() {
		return r68_no_acct_aed_non_resident;
	}

	public void setR68_no_acct_aed_non_resident(BigDecimal r68_no_acct_aed_non_resident) {
		this.r68_no_acct_aed_non_resident = r68_no_acct_aed_non_resident;
	}

	public BigDecimal getR68_amount_aed_non_resident() {
		return r68_amount_aed_non_resident;
	}

	public void setR68_amount_aed_non_resident(BigDecimal r68_amount_aed_non_resident) {
		this.r68_amount_aed_non_resident = r68_amount_aed_non_resident;
	}

	public BigDecimal getR68_no_acct_fcy_non_resident() {
		return r68_no_acct_fcy_non_resident;
	}

	public void setR68_no_acct_fcy_non_resident(BigDecimal r68_no_acct_fcy_non_resident) {
		this.r68_no_acct_fcy_non_resident = r68_no_acct_fcy_non_resident;
	}

	public BigDecimal getR68_amount_fcy_non_resident() {
		return r68_amount_fcy_non_resident;
	}

	public void setR68_amount_fcy_non_resident(BigDecimal r68_amount_fcy_non_resident) {
		this.r68_amount_fcy_non_resident = r68_amount_fcy_non_resident;
	}

	public BigDecimal getR68_total_amount() {
		return r68_total_amount;
	}

	public void setR68_total_amount(BigDecimal r68_total_amount) {
		this.r68_total_amount = r68_total_amount;
	}

	public String getR69_product() {
		return r69_product;
	}

	public void setR69_product(String r69_product) {
		this.r69_product = r69_product;
	}

	public BigDecimal getR69_no_acct_aed_resident() {
		return r69_no_acct_aed_resident;
	}

	public void setR69_no_acct_aed_resident(BigDecimal r69_no_acct_aed_resident) {
		this.r69_no_acct_aed_resident = r69_no_acct_aed_resident;
	}

	public BigDecimal getR69_amount_aed_resident() {
		return r69_amount_aed_resident;
	}

	public void setR69_amount_aed_resident(BigDecimal r69_amount_aed_resident) {
		this.r69_amount_aed_resident = r69_amount_aed_resident;
	}

	public BigDecimal getR69_no_acct_fcy_resident() {
		return r69_no_acct_fcy_resident;
	}

	public void setR69_no_acct_fcy_resident(BigDecimal r69_no_acct_fcy_resident) {
		this.r69_no_acct_fcy_resident = r69_no_acct_fcy_resident;
	}

	public BigDecimal getR69_amount_fcy_resident() {
		return r69_amount_fcy_resident;
	}

	public void setR69_amount_fcy_resident(BigDecimal r69_amount_fcy_resident) {
		this.r69_amount_fcy_resident = r69_amount_fcy_resident;
	}

	public BigDecimal getR69_no_acct_aed_non_resident() {
		return r69_no_acct_aed_non_resident;
	}

	public void setR69_no_acct_aed_non_resident(BigDecimal r69_no_acct_aed_non_resident) {
		this.r69_no_acct_aed_non_resident = r69_no_acct_aed_non_resident;
	}

	public BigDecimal getR69_amount_aed_non_resident() {
		return r69_amount_aed_non_resident;
	}

	public void setR69_amount_aed_non_resident(BigDecimal r69_amount_aed_non_resident) {
		this.r69_amount_aed_non_resident = r69_amount_aed_non_resident;
	}

	public BigDecimal getR69_no_acct_fcy_non_resident() {
		return r69_no_acct_fcy_non_resident;
	}

	public void setR69_no_acct_fcy_non_resident(BigDecimal r69_no_acct_fcy_non_resident) {
		this.r69_no_acct_fcy_non_resident = r69_no_acct_fcy_non_resident;
	}

	public BigDecimal getR69_amount_fcy_non_resident() {
		return r69_amount_fcy_non_resident;
	}

	public void setR69_amount_fcy_non_resident(BigDecimal r69_amount_fcy_non_resident) {
		this.r69_amount_fcy_non_resident = r69_amount_fcy_non_resident;
	}

	public BigDecimal getR69_total_amount() {
		return r69_total_amount;
	}

	public void setR69_total_amount(BigDecimal r69_total_amount) {
		this.r69_total_amount = r69_total_amount;
	}

	public String getR70_product() {
		return r70_product;
	}

	public void setR70_product(String r70_product) {
		this.r70_product = r70_product;
	}

	public BigDecimal getR70_no_acct_aed_resident() {
		return r70_no_acct_aed_resident;
	}

	public void setR70_no_acct_aed_resident(BigDecimal r70_no_acct_aed_resident) {
		this.r70_no_acct_aed_resident = r70_no_acct_aed_resident;
	}

	public BigDecimal getR70_amount_aed_resident() {
		return r70_amount_aed_resident;
	}

	public void setR70_amount_aed_resident(BigDecimal r70_amount_aed_resident) {
		this.r70_amount_aed_resident = r70_amount_aed_resident;
	}

	public BigDecimal getR70_no_acct_fcy_resident() {
		return r70_no_acct_fcy_resident;
	}

	public void setR70_no_acct_fcy_resident(BigDecimal r70_no_acct_fcy_resident) {
		this.r70_no_acct_fcy_resident = r70_no_acct_fcy_resident;
	}

	public BigDecimal getR70_amount_fcy_resident() {
		return r70_amount_fcy_resident;
	}

	public void setR70_amount_fcy_resident(BigDecimal r70_amount_fcy_resident) {
		this.r70_amount_fcy_resident = r70_amount_fcy_resident;
	}

	public BigDecimal getR70_no_acct_aed_non_resident() {
		return r70_no_acct_aed_non_resident;
	}

	public void setR70_no_acct_aed_non_resident(BigDecimal r70_no_acct_aed_non_resident) {
		this.r70_no_acct_aed_non_resident = r70_no_acct_aed_non_resident;
	}

	public BigDecimal getR70_amount_aed_non_resident() {
		return r70_amount_aed_non_resident;
	}

	public void setR70_amount_aed_non_resident(BigDecimal r70_amount_aed_non_resident) {
		this.r70_amount_aed_non_resident = r70_amount_aed_non_resident;
	}

	public BigDecimal getR70_no_acct_fcy_non_resident() {
		return r70_no_acct_fcy_non_resident;
	}

	public void setR70_no_acct_fcy_non_resident(BigDecimal r70_no_acct_fcy_non_resident) {
		this.r70_no_acct_fcy_non_resident = r70_no_acct_fcy_non_resident;
	}

	public BigDecimal getR70_amount_fcy_non_resident() {
		return r70_amount_fcy_non_resident;
	}

	public void setR70_amount_fcy_non_resident(BigDecimal r70_amount_fcy_non_resident) {
		this.r70_amount_fcy_non_resident = r70_amount_fcy_non_resident;
	}

	public BigDecimal getR70_total_amount() {
		return r70_total_amount;
	}

	public void setR70_total_amount(BigDecimal r70_total_amount) {
		this.r70_total_amount = r70_total_amount;
	}

	public String getR71_product() {
		return r71_product;
	}

	public void setR71_product(String r71_product) {
		this.r71_product = r71_product;
	}

	public BigDecimal getR71_no_acct_aed_resident() {
		return r71_no_acct_aed_resident;
	}

	public void setR71_no_acct_aed_resident(BigDecimal r71_no_acct_aed_resident) {
		this.r71_no_acct_aed_resident = r71_no_acct_aed_resident;
	}

	public BigDecimal getR71_amount_aed_resident() {
		return r71_amount_aed_resident;
	}

	public void setR71_amount_aed_resident(BigDecimal r71_amount_aed_resident) {
		this.r71_amount_aed_resident = r71_amount_aed_resident;
	}

	public BigDecimal getR71_no_acct_fcy_resident() {
		return r71_no_acct_fcy_resident;
	}

	public void setR71_no_acct_fcy_resident(BigDecimal r71_no_acct_fcy_resident) {
		this.r71_no_acct_fcy_resident = r71_no_acct_fcy_resident;
	}

	public BigDecimal getR71_amount_fcy_resident() {
		return r71_amount_fcy_resident;
	}

	public void setR71_amount_fcy_resident(BigDecimal r71_amount_fcy_resident) {
		this.r71_amount_fcy_resident = r71_amount_fcy_resident;
	}

	public BigDecimal getR71_no_acct_aed_non_resident() {
		return r71_no_acct_aed_non_resident;
	}

	public void setR71_no_acct_aed_non_resident(BigDecimal r71_no_acct_aed_non_resident) {
		this.r71_no_acct_aed_non_resident = r71_no_acct_aed_non_resident;
	}

	public BigDecimal getR71_amount_aed_non_resident() {
		return r71_amount_aed_non_resident;
	}

	public void setR71_amount_aed_non_resident(BigDecimal r71_amount_aed_non_resident) {
		this.r71_amount_aed_non_resident = r71_amount_aed_non_resident;
	}

	public BigDecimal getR71_no_acct_fcy_non_resident() {
		return r71_no_acct_fcy_non_resident;
	}

	public void setR71_no_acct_fcy_non_resident(BigDecimal r71_no_acct_fcy_non_resident) {
		this.r71_no_acct_fcy_non_resident = r71_no_acct_fcy_non_resident;
	}

	public BigDecimal getR71_amount_fcy_non_resident() {
		return r71_amount_fcy_non_resident;
	}

	public void setR71_amount_fcy_non_resident(BigDecimal r71_amount_fcy_non_resident) {
		this.r71_amount_fcy_non_resident = r71_amount_fcy_non_resident;
	}

	public BigDecimal getR71_total_amount() {
		return r71_total_amount;
	}

	public void setR71_total_amount(BigDecimal r71_total_amount) {
		this.r71_total_amount = r71_total_amount;
	}

	public String getR72_product() {
		return r72_product;
	}

	public void setR72_product(String r72_product) {
		this.r72_product = r72_product;
	}

	public BigDecimal getR72_no_acct_aed_resident() {
		return r72_no_acct_aed_resident;
	}

	public void setR72_no_acct_aed_resident(BigDecimal r72_no_acct_aed_resident) {
		this.r72_no_acct_aed_resident = r72_no_acct_aed_resident;
	}

	public BigDecimal getR72_amount_aed_resident() {
		return r72_amount_aed_resident;
	}

	public void setR72_amount_aed_resident(BigDecimal r72_amount_aed_resident) {
		this.r72_amount_aed_resident = r72_amount_aed_resident;
	}

	public BigDecimal getR72_no_acct_fcy_resident() {
		return r72_no_acct_fcy_resident;
	}

	public void setR72_no_acct_fcy_resident(BigDecimal r72_no_acct_fcy_resident) {
		this.r72_no_acct_fcy_resident = r72_no_acct_fcy_resident;
	}

	public BigDecimal getR72_amount_fcy_resident() {
		return r72_amount_fcy_resident;
	}

	public void setR72_amount_fcy_resident(BigDecimal r72_amount_fcy_resident) {
		this.r72_amount_fcy_resident = r72_amount_fcy_resident;
	}

	public BigDecimal getR72_no_acct_aed_non_resident() {
		return r72_no_acct_aed_non_resident;
	}

	public void setR72_no_acct_aed_non_resident(BigDecimal r72_no_acct_aed_non_resident) {
		this.r72_no_acct_aed_non_resident = r72_no_acct_aed_non_resident;
	}

	public BigDecimal getR72_amount_aed_non_resident() {
		return r72_amount_aed_non_resident;
	}

	public void setR72_amount_aed_non_resident(BigDecimal r72_amount_aed_non_resident) {
		this.r72_amount_aed_non_resident = r72_amount_aed_non_resident;
	}

	public BigDecimal getR72_no_acct_fcy_non_resident() {
		return r72_no_acct_fcy_non_resident;
	}

	public void setR72_no_acct_fcy_non_resident(BigDecimal r72_no_acct_fcy_non_resident) {
		this.r72_no_acct_fcy_non_resident = r72_no_acct_fcy_non_resident;
	}

	public BigDecimal getR72_amount_fcy_non_resident() {
		return r72_amount_fcy_non_resident;
	}

	public void setR72_amount_fcy_non_resident(BigDecimal r72_amount_fcy_non_resident) {
		this.r72_amount_fcy_non_resident = r72_amount_fcy_non_resident;
	}

	public BigDecimal getR72_total_amount() {
		return r72_total_amount;
	}

	public void setR72_total_amount(BigDecimal r72_total_amount) {
		this.r72_total_amount = r72_total_amount;
	}

	public String getR73_product() {
		return r73_product;
	}

	public void setR73_product(String r73_product) {
		this.r73_product = r73_product;
	}

	public BigDecimal getR73_no_acct_aed_resident() {
		return r73_no_acct_aed_resident;
	}

	public void setR73_no_acct_aed_resident(BigDecimal r73_no_acct_aed_resident) {
		this.r73_no_acct_aed_resident = r73_no_acct_aed_resident;
	}

	public BigDecimal getR73_amount_aed_resident() {
		return r73_amount_aed_resident;
	}

	public void setR73_amount_aed_resident(BigDecimal r73_amount_aed_resident) {
		this.r73_amount_aed_resident = r73_amount_aed_resident;
	}

	public BigDecimal getR73_no_acct_fcy_resident() {
		return r73_no_acct_fcy_resident;
	}

	public void setR73_no_acct_fcy_resident(BigDecimal r73_no_acct_fcy_resident) {
		this.r73_no_acct_fcy_resident = r73_no_acct_fcy_resident;
	}

	public BigDecimal getR73_amount_fcy_resident() {
		return r73_amount_fcy_resident;
	}

	public void setR73_amount_fcy_resident(BigDecimal r73_amount_fcy_resident) {
		this.r73_amount_fcy_resident = r73_amount_fcy_resident;
	}

	public BigDecimal getR73_no_acct_aed_non_resident() {
		return r73_no_acct_aed_non_resident;
	}

	public void setR73_no_acct_aed_non_resident(BigDecimal r73_no_acct_aed_non_resident) {
		this.r73_no_acct_aed_non_resident = r73_no_acct_aed_non_resident;
	}

	public BigDecimal getR73_amount_aed_non_resident() {
		return r73_amount_aed_non_resident;
	}

	public void setR73_amount_aed_non_resident(BigDecimal r73_amount_aed_non_resident) {
		this.r73_amount_aed_non_resident = r73_amount_aed_non_resident;
	}

	public BigDecimal getR73_no_acct_fcy_non_resident() {
		return r73_no_acct_fcy_non_resident;
	}

	public void setR73_no_acct_fcy_non_resident(BigDecimal r73_no_acct_fcy_non_resident) {
		this.r73_no_acct_fcy_non_resident = r73_no_acct_fcy_non_resident;
	}

	public BigDecimal getR73_amount_fcy_non_resident() {
		return r73_amount_fcy_non_resident;
	}

	public void setR73_amount_fcy_non_resident(BigDecimal r73_amount_fcy_non_resident) {
		this.r73_amount_fcy_non_resident = r73_amount_fcy_non_resident;
	}

	public BigDecimal getR73_total_amount() {
		return r73_total_amount;
	}

	public void setR73_total_amount(BigDecimal r73_total_amount) {
		this.r73_total_amount = r73_total_amount;
	}

	public String getR74_product() {
		return r74_product;
	}

	public void setR74_product(String r74_product) {
		this.r74_product = r74_product;
	}

	public BigDecimal getR74_no_acct_aed_resident() {
		return r74_no_acct_aed_resident;
	}

	public void setR74_no_acct_aed_resident(BigDecimal r74_no_acct_aed_resident) {
		this.r74_no_acct_aed_resident = r74_no_acct_aed_resident;
	}

	public BigDecimal getR74_amount_aed_resident() {
		return r74_amount_aed_resident;
	}

	public void setR74_amount_aed_resident(BigDecimal r74_amount_aed_resident) {
		this.r74_amount_aed_resident = r74_amount_aed_resident;
	}

	public BigDecimal getR74_no_acct_fcy_resident() {
		return r74_no_acct_fcy_resident;
	}

	public void setR74_no_acct_fcy_resident(BigDecimal r74_no_acct_fcy_resident) {
		this.r74_no_acct_fcy_resident = r74_no_acct_fcy_resident;
	}

	public BigDecimal getR74_amount_fcy_resident() {
		return r74_amount_fcy_resident;
	}

	public void setR74_amount_fcy_resident(BigDecimal r74_amount_fcy_resident) {
		this.r74_amount_fcy_resident = r74_amount_fcy_resident;
	}

	public BigDecimal getR74_no_acct_aed_non_resident() {
		return r74_no_acct_aed_non_resident;
	}

	public void setR74_no_acct_aed_non_resident(BigDecimal r74_no_acct_aed_non_resident) {
		this.r74_no_acct_aed_non_resident = r74_no_acct_aed_non_resident;
	}

	public BigDecimal getR74_amount_aed_non_resident() {
		return r74_amount_aed_non_resident;
	}

	public void setR74_amount_aed_non_resident(BigDecimal r74_amount_aed_non_resident) {
		this.r74_amount_aed_non_resident = r74_amount_aed_non_resident;
	}

	public BigDecimal getR74_no_acct_fcy_non_resident() {
		return r74_no_acct_fcy_non_resident;
	}

	public void setR74_no_acct_fcy_non_resident(BigDecimal r74_no_acct_fcy_non_resident) {
		this.r74_no_acct_fcy_non_resident = r74_no_acct_fcy_non_resident;
	}

	public BigDecimal getR74_amount_fcy_non_resident() {
		return r74_amount_fcy_non_resident;
	}

	public void setR74_amount_fcy_non_resident(BigDecimal r74_amount_fcy_non_resident) {
		this.r74_amount_fcy_non_resident = r74_amount_fcy_non_resident;
	}

	public BigDecimal getR74_total_amount() {
		return r74_total_amount;
	}

	public void setR74_total_amount(BigDecimal r74_total_amount) {
		this.r74_total_amount = r74_total_amount;
	}

	public String getR75_product() {
		return r75_product;
	}

	public void setR75_product(String r75_product) {
		this.r75_product = r75_product;
	}

	public BigDecimal getR75_no_acct_aed_resident() {
		return r75_no_acct_aed_resident;
	}

	public void setR75_no_acct_aed_resident(BigDecimal r75_no_acct_aed_resident) {
		this.r75_no_acct_aed_resident = r75_no_acct_aed_resident;
	}

	public BigDecimal getR75_amount_aed_resident() {
		return r75_amount_aed_resident;
	}

	public void setR75_amount_aed_resident(BigDecimal r75_amount_aed_resident) {
		this.r75_amount_aed_resident = r75_amount_aed_resident;
	}

	public BigDecimal getR75_no_acct_fcy_resident() {
		return r75_no_acct_fcy_resident;
	}

	public void setR75_no_acct_fcy_resident(BigDecimal r75_no_acct_fcy_resident) {
		this.r75_no_acct_fcy_resident = r75_no_acct_fcy_resident;
	}

	public BigDecimal getR75_amount_fcy_resident() {
		return r75_amount_fcy_resident;
	}

	public void setR75_amount_fcy_resident(BigDecimal r75_amount_fcy_resident) {
		this.r75_amount_fcy_resident = r75_amount_fcy_resident;
	}

	public BigDecimal getR75_no_acct_aed_non_resident() {
		return r75_no_acct_aed_non_resident;
	}

	public void setR75_no_acct_aed_non_resident(BigDecimal r75_no_acct_aed_non_resident) {
		this.r75_no_acct_aed_non_resident = r75_no_acct_aed_non_resident;
	}

	public BigDecimal getR75_amount_aed_non_resident() {
		return r75_amount_aed_non_resident;
	}

	public void setR75_amount_aed_non_resident(BigDecimal r75_amount_aed_non_resident) {
		this.r75_amount_aed_non_resident = r75_amount_aed_non_resident;
	}

	public BigDecimal getR75_no_acct_fcy_non_resident() {
		return r75_no_acct_fcy_non_resident;
	}

	public void setR75_no_acct_fcy_non_resident(BigDecimal r75_no_acct_fcy_non_resident) {
		this.r75_no_acct_fcy_non_resident = r75_no_acct_fcy_non_resident;
	}

	public BigDecimal getR75_amount_fcy_non_resident() {
		return r75_amount_fcy_non_resident;
	}

	public void setR75_amount_fcy_non_resident(BigDecimal r75_amount_fcy_non_resident) {
		this.r75_amount_fcy_non_resident = r75_amount_fcy_non_resident;
	}

	public BigDecimal getR75_total_amount() {
		return r75_total_amount;
	}

	public void setR75_total_amount(BigDecimal r75_total_amount) {
		this.r75_total_amount = r75_total_amount;
	}

	public String getR76_product() {
		return r76_product;
	}

	public void setR76_product(String r76_product) {
		this.r76_product = r76_product;
	}

	public BigDecimal getR76_no_acct_aed_resident() {
		return r76_no_acct_aed_resident;
	}

	public void setR76_no_acct_aed_resident(BigDecimal r76_no_acct_aed_resident) {
		this.r76_no_acct_aed_resident = r76_no_acct_aed_resident;
	}

	public BigDecimal getR76_amount_aed_resident() {
		return r76_amount_aed_resident;
	}

	public void setR76_amount_aed_resident(BigDecimal r76_amount_aed_resident) {
		this.r76_amount_aed_resident = r76_amount_aed_resident;
	}

	public BigDecimal getR76_no_acct_fcy_resident() {
		return r76_no_acct_fcy_resident;
	}

	public void setR76_no_acct_fcy_resident(BigDecimal r76_no_acct_fcy_resident) {
		this.r76_no_acct_fcy_resident = r76_no_acct_fcy_resident;
	}

	public BigDecimal getR76_amount_fcy_resident() {
		return r76_amount_fcy_resident;
	}

	public void setR76_amount_fcy_resident(BigDecimal r76_amount_fcy_resident) {
		this.r76_amount_fcy_resident = r76_amount_fcy_resident;
	}

	public BigDecimal getR76_no_acct_aed_non_resident() {
		return r76_no_acct_aed_non_resident;
	}

	public void setR76_no_acct_aed_non_resident(BigDecimal r76_no_acct_aed_non_resident) {
		this.r76_no_acct_aed_non_resident = r76_no_acct_aed_non_resident;
	}

	public BigDecimal getR76_amount_aed_non_resident() {
		return r76_amount_aed_non_resident;
	}

	public void setR76_amount_aed_non_resident(BigDecimal r76_amount_aed_non_resident) {
		this.r76_amount_aed_non_resident = r76_amount_aed_non_resident;
	}

	public BigDecimal getR76_no_acct_fcy_non_resident() {
		return r76_no_acct_fcy_non_resident;
	}

	public void setR76_no_acct_fcy_non_resident(BigDecimal r76_no_acct_fcy_non_resident) {
		this.r76_no_acct_fcy_non_resident = r76_no_acct_fcy_non_resident;
	}

	public BigDecimal getR76_amount_fcy_non_resident() {
		return r76_amount_fcy_non_resident;
	}

	public void setR76_amount_fcy_non_resident(BigDecimal r76_amount_fcy_non_resident) {
		this.r76_amount_fcy_non_resident = r76_amount_fcy_non_resident;
	}

	public BigDecimal getR76_total_amount() {
		return r76_total_amount;
	}

	public void setR76_total_amount(BigDecimal r76_total_amount) {
		this.r76_total_amount = r76_total_amount;
	}

	public String getR77_product() {
		return r77_product;
	}

	public void setR77_product(String r77_product) {
		this.r77_product = r77_product;
	}

	public BigDecimal getR77_no_acct_aed_resident() {
		return r77_no_acct_aed_resident;
	}

	public void setR77_no_acct_aed_resident(BigDecimal r77_no_acct_aed_resident) {
		this.r77_no_acct_aed_resident = r77_no_acct_aed_resident;
	}

	public BigDecimal getR77_amount_aed_resident() {
		return r77_amount_aed_resident;
	}

	public void setR77_amount_aed_resident(BigDecimal r77_amount_aed_resident) {
		this.r77_amount_aed_resident = r77_amount_aed_resident;
	}

	public BigDecimal getR77_no_acct_fcy_resident() {
		return r77_no_acct_fcy_resident;
	}

	public void setR77_no_acct_fcy_resident(BigDecimal r77_no_acct_fcy_resident) {
		this.r77_no_acct_fcy_resident = r77_no_acct_fcy_resident;
	}

	public BigDecimal getR77_amount_fcy_resident() {
		return r77_amount_fcy_resident;
	}

	public void setR77_amount_fcy_resident(BigDecimal r77_amount_fcy_resident) {
		this.r77_amount_fcy_resident = r77_amount_fcy_resident;
	}

	public BigDecimal getR77_no_acct_aed_non_resident() {
		return r77_no_acct_aed_non_resident;
	}

	public void setR77_no_acct_aed_non_resident(BigDecimal r77_no_acct_aed_non_resident) {
		this.r77_no_acct_aed_non_resident = r77_no_acct_aed_non_resident;
	}

	public BigDecimal getR77_amount_aed_non_resident() {
		return r77_amount_aed_non_resident;
	}

	public void setR77_amount_aed_non_resident(BigDecimal r77_amount_aed_non_resident) {
		this.r77_amount_aed_non_resident = r77_amount_aed_non_resident;
	}

	public BigDecimal getR77_no_acct_fcy_non_resident() {
		return r77_no_acct_fcy_non_resident;
	}

	public void setR77_no_acct_fcy_non_resident(BigDecimal r77_no_acct_fcy_non_resident) {
		this.r77_no_acct_fcy_non_resident = r77_no_acct_fcy_non_resident;
	}

	public BigDecimal getR77_amount_fcy_non_resident() {
		return r77_amount_fcy_non_resident;
	}

	public void setR77_amount_fcy_non_resident(BigDecimal r77_amount_fcy_non_resident) {
		this.r77_amount_fcy_non_resident = r77_amount_fcy_non_resident;
	}

	public BigDecimal getR77_total_amount() {
		return r77_total_amount;
	}

	public void setR77_total_amount(BigDecimal r77_total_amount) {
		this.r77_total_amount = r77_total_amount;
	}

	public String getR78_product() {
		return r78_product;
	}

	public void setR78_product(String r78_product) {
		this.r78_product = r78_product;
	}

	public BigDecimal getR78_no_acct_aed_resident() {
		return r78_no_acct_aed_resident;
	}

	public void setR78_no_acct_aed_resident(BigDecimal r78_no_acct_aed_resident) {
		this.r78_no_acct_aed_resident = r78_no_acct_aed_resident;
	}

	public BigDecimal getR78_amount_aed_resident() {
		return r78_amount_aed_resident;
	}

	public void setR78_amount_aed_resident(BigDecimal r78_amount_aed_resident) {
		this.r78_amount_aed_resident = r78_amount_aed_resident;
	}

	public BigDecimal getR78_no_acct_fcy_resident() {
		return r78_no_acct_fcy_resident;
	}

	public void setR78_no_acct_fcy_resident(BigDecimal r78_no_acct_fcy_resident) {
		this.r78_no_acct_fcy_resident = r78_no_acct_fcy_resident;
	}

	public BigDecimal getR78_amount_fcy_resident() {
		return r78_amount_fcy_resident;
	}

	public void setR78_amount_fcy_resident(BigDecimal r78_amount_fcy_resident) {
		this.r78_amount_fcy_resident = r78_amount_fcy_resident;
	}

	public BigDecimal getR78_no_acct_aed_non_resident() {
		return r78_no_acct_aed_non_resident;
	}

	public void setR78_no_acct_aed_non_resident(BigDecimal r78_no_acct_aed_non_resident) {
		this.r78_no_acct_aed_non_resident = r78_no_acct_aed_non_resident;
	}

	public BigDecimal getR78_amount_aed_non_resident() {
		return r78_amount_aed_non_resident;
	}

	public void setR78_amount_aed_non_resident(BigDecimal r78_amount_aed_non_resident) {
		this.r78_amount_aed_non_resident = r78_amount_aed_non_resident;
	}

	public BigDecimal getR78_no_acct_fcy_non_resident() {
		return r78_no_acct_fcy_non_resident;
	}

	public void setR78_no_acct_fcy_non_resident(BigDecimal r78_no_acct_fcy_non_resident) {
		this.r78_no_acct_fcy_non_resident = r78_no_acct_fcy_non_resident;
	}

	public BigDecimal getR78_amount_fcy_non_resident() {
		return r78_amount_fcy_non_resident;
	}

	public void setR78_amount_fcy_non_resident(BigDecimal r78_amount_fcy_non_resident) {
		this.r78_amount_fcy_non_resident = r78_amount_fcy_non_resident;
	}

	public BigDecimal getR78_total_amount() {
		return r78_total_amount;
	}

	public void setR78_total_amount(BigDecimal r78_total_amount) {
		this.r78_total_amount = r78_total_amount;
	}

	public String getR79_product() {
		return r79_product;
	}

	public void setR79_product(String r79_product) {
		this.r79_product = r79_product;
	}

	public BigDecimal getR79_no_acct_aed_resident() {
		return r79_no_acct_aed_resident;
	}

	public void setR79_no_acct_aed_resident(BigDecimal r79_no_acct_aed_resident) {
		this.r79_no_acct_aed_resident = r79_no_acct_aed_resident;
	}

	public BigDecimal getR79_amount_aed_resident() {
		return r79_amount_aed_resident;
	}

	public void setR79_amount_aed_resident(BigDecimal r79_amount_aed_resident) {
		this.r79_amount_aed_resident = r79_amount_aed_resident;
	}

	public BigDecimal getR79_no_acct_fcy_resident() {
		return r79_no_acct_fcy_resident;
	}

	public void setR79_no_acct_fcy_resident(BigDecimal r79_no_acct_fcy_resident) {
		this.r79_no_acct_fcy_resident = r79_no_acct_fcy_resident;
	}

	public BigDecimal getR79_amount_fcy_resident() {
		return r79_amount_fcy_resident;
	}

	public void setR79_amount_fcy_resident(BigDecimal r79_amount_fcy_resident) {
		this.r79_amount_fcy_resident = r79_amount_fcy_resident;
	}

	public BigDecimal getR79_no_acct_aed_non_resident() {
		return r79_no_acct_aed_non_resident;
	}

	public void setR79_no_acct_aed_non_resident(BigDecimal r79_no_acct_aed_non_resident) {
		this.r79_no_acct_aed_non_resident = r79_no_acct_aed_non_resident;
	}

	public BigDecimal getR79_amount_aed_non_resident() {
		return r79_amount_aed_non_resident;
	}

	public void setR79_amount_aed_non_resident(BigDecimal r79_amount_aed_non_resident) {
		this.r79_amount_aed_non_resident = r79_amount_aed_non_resident;
	}

	public BigDecimal getR79_no_acct_fcy_non_resident() {
		return r79_no_acct_fcy_non_resident;
	}

	public void setR79_no_acct_fcy_non_resident(BigDecimal r79_no_acct_fcy_non_resident) {
		this.r79_no_acct_fcy_non_resident = r79_no_acct_fcy_non_resident;
	}

	public BigDecimal getR79_amount_fcy_non_resident() {
		return r79_amount_fcy_non_resident;
	}

	public void setR79_amount_fcy_non_resident(BigDecimal r79_amount_fcy_non_resident) {
		this.r79_amount_fcy_non_resident = r79_amount_fcy_non_resident;
	}

	public BigDecimal getR79_total_amount() {
		return r79_total_amount;
	}

	public void setR79_total_amount(BigDecimal r79_total_amount) {
		this.r79_total_amount = r79_total_amount;
	}

	public String getR80_product() {
		return r80_product;
	}

	public void setR80_product(String r80_product) {
		this.r80_product = r80_product;
	}

	public BigDecimal getR80_no_acct_aed_resident() {
		return r80_no_acct_aed_resident;
	}

	public void setR80_no_acct_aed_resident(BigDecimal r80_no_acct_aed_resident) {
		this.r80_no_acct_aed_resident = r80_no_acct_aed_resident;
	}

	public BigDecimal getR80_amount_aed_resident() {
		return r80_amount_aed_resident;
	}

	public void setR80_amount_aed_resident(BigDecimal r80_amount_aed_resident) {
		this.r80_amount_aed_resident = r80_amount_aed_resident;
	}

	public BigDecimal getR80_no_acct_fcy_resident() {
		return r80_no_acct_fcy_resident;
	}

	public void setR80_no_acct_fcy_resident(BigDecimal r80_no_acct_fcy_resident) {
		this.r80_no_acct_fcy_resident = r80_no_acct_fcy_resident;
	}

	public BigDecimal getR80_amount_fcy_resident() {
		return r80_amount_fcy_resident;
	}

	public void setR80_amount_fcy_resident(BigDecimal r80_amount_fcy_resident) {
		this.r80_amount_fcy_resident = r80_amount_fcy_resident;
	}

	public BigDecimal getR80_no_acct_aed_non_resident() {
		return r80_no_acct_aed_non_resident;
	}

	public void setR80_no_acct_aed_non_resident(BigDecimal r80_no_acct_aed_non_resident) {
		this.r80_no_acct_aed_non_resident = r80_no_acct_aed_non_resident;
	}

	public BigDecimal getR80_amount_aed_non_resident() {
		return r80_amount_aed_non_resident;
	}

	public void setR80_amount_aed_non_resident(BigDecimal r80_amount_aed_non_resident) {
		this.r80_amount_aed_non_resident = r80_amount_aed_non_resident;
	}

	public BigDecimal getR80_no_acct_fcy_non_resident() {
		return r80_no_acct_fcy_non_resident;
	}

	public void setR80_no_acct_fcy_non_resident(BigDecimal r80_no_acct_fcy_non_resident) {
		this.r80_no_acct_fcy_non_resident = r80_no_acct_fcy_non_resident;
	}

	public BigDecimal getR80_amount_fcy_non_resident() {
		return r80_amount_fcy_non_resident;
	}

	public void setR80_amount_fcy_non_resident(BigDecimal r80_amount_fcy_non_resident) {
		this.r80_amount_fcy_non_resident = r80_amount_fcy_non_resident;
	}

	public BigDecimal getR80_total_amount() {
		return r80_total_amount;
	}

	public void setR80_total_amount(BigDecimal r80_total_amount) {
		this.r80_total_amount = r80_total_amount;
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

	public String getR81_product() {
		return r81_product;
	}

	public void setR81_product(String r81_product) {
		this.r81_product = r81_product;
	}

	public BigDecimal getR81_no_acct_aed_resident() {
		return r81_no_acct_aed_resident;
	}

	public void setR81_no_acct_aed_resident(BigDecimal r81_no_acct_aed_resident) {
		this.r81_no_acct_aed_resident = r81_no_acct_aed_resident;
	}

	public BigDecimal getR81_amount_aed_resident() {
		return r81_amount_aed_resident;
	}

	public void setR81_amount_aed_resident(BigDecimal r81_amount_aed_resident) {
		this.r81_amount_aed_resident = r81_amount_aed_resident;
	}

	public BigDecimal getR81_no_acct_fcy_resident() {
		return r81_no_acct_fcy_resident;
	}

	public void setR81_no_acct_fcy_resident(BigDecimal r81_no_acct_fcy_resident) {
		this.r81_no_acct_fcy_resident = r81_no_acct_fcy_resident;
	}

	public BigDecimal getR81_amount_fcy_resident() {
		return r81_amount_fcy_resident;
	}

	public void setR81_amount_fcy_resident(BigDecimal r81_amount_fcy_resident) {
		this.r81_amount_fcy_resident = r81_amount_fcy_resident;
	}

	public BigDecimal getR81_no_acct_aed_non_resident() {
		return r81_no_acct_aed_non_resident;
	}

	public void setR81_no_acct_aed_non_resident(BigDecimal r81_no_acct_aed_non_resident) {
		this.r81_no_acct_aed_non_resident = r81_no_acct_aed_non_resident;
	}

	public BigDecimal getR81_amount_aed_non_resident() {
		return r81_amount_aed_non_resident;
	}

	public void setR81_amount_aed_non_resident(BigDecimal r81_amount_aed_non_resident) {
		this.r81_amount_aed_non_resident = r81_amount_aed_non_resident;
	}

	public BigDecimal getR81_no_acct_fcy_non_resident() {
		return r81_no_acct_fcy_non_resident;
	}

	public void setR81_no_acct_fcy_non_resident(BigDecimal r81_no_acct_fcy_non_resident) {
		this.r81_no_acct_fcy_non_resident = r81_no_acct_fcy_non_resident;
	}

	public BigDecimal getR81_amount_fcy_non_resident() {
		return r81_amount_fcy_non_resident;
	}

	public void setR81_amount_fcy_non_resident(BigDecimal r81_amount_fcy_non_resident) {
		this.r81_amount_fcy_non_resident = r81_amount_fcy_non_resident;
	}

	public BigDecimal getR81_total_amount() {
		return r81_total_amount;
	}

	public void setR81_total_amount(BigDecimal r81_total_amount) {
		this.r81_total_amount = r81_total_amount;
	}

	public BRF1_REPORT_ENTITYNEW() {
		super();
		
	}

	
}
