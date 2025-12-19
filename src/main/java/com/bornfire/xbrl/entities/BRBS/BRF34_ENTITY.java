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
@Table(name="BRF34_SUMMARYTABLE")

public class BRF34_ENTITY{

	private String	rh_product;
	private BigDecimal	rh_inter_bank_place;
	private BigDecimal	rh_inter_bank_borrow;
	private BigDecimal	rh_other_placement;
	private BigDecimal	rh_other_borrow;
	private BigDecimal	rh_remani_balance_from;
	private BigDecimal	rh_remani_balance_to;
	private String	r1_product;
	private BigDecimal	r1_inter_bank_place;
	private BigDecimal	r1_inter_bank_borrow;
	private BigDecimal	r1_other_placement;
	private BigDecimal	r1_other_borrow;
	private BigDecimal	r1_remani_balance_from;
	private BigDecimal	r1_remani_balance_to;
	private String	r2_product;
	private BigDecimal	r2_inter_bank_place;
	private BigDecimal	r2_inter_bank_borrow;
	private BigDecimal	r2_other_placement;
	private BigDecimal	r2_other_borrow;
	private BigDecimal	r2_remani_balance_from;
	private BigDecimal	r2_remani_balance_to;
	private String	r3_product;
	private BigDecimal	r3_inter_bank_place;
	private BigDecimal	r3_inter_bank_borrow;
	private BigDecimal	r3_other_placement;
	private BigDecimal	r3_other_borrow;
	private BigDecimal	r3_remani_balance_from;
	private BigDecimal	r3_remani_balance_to;
	private String	r4_product;
	private BigDecimal	r4_inter_bank_place;
	private BigDecimal	r4_inter_bank_borrow;
	private BigDecimal	r4_other_placement;
	private BigDecimal	r4_other_borrow;
	private BigDecimal	r4_remani_balance_from;
	private BigDecimal	r4_remani_balance_to;
	private String	r5_product;
	private BigDecimal	r5_inter_bank_place;
	private BigDecimal	r5_inter_bank_borrow;
	private BigDecimal	r5_other_placement;
	private BigDecimal	r5_other_borrow;
	private BigDecimal	r5_remani_balance_from;
	private BigDecimal	r5_remani_balance_to;
	private String	r6_product;
	private BigDecimal	r6_inter_bank_place;
	private BigDecimal	r6_inter_bank_borrow;
	private BigDecimal	r6_other_placement;
	private BigDecimal	r6_other_borrow;
	private BigDecimal	r6_remani_balance_from;
	private BigDecimal	r6_remani_balance_to;
	private String	r7_product;
	private BigDecimal	r7_inter_bank_place;
	private BigDecimal	r7_inter_bank_borrow;
	private BigDecimal	r7_other_placement;
	private BigDecimal	r7_other_borrow;
	private BigDecimal	r7_remani_balance_from;
	private BigDecimal	r7_remani_balance_to;
	private String	r8_product;
	private BigDecimal	r8_inter_bank_place;
	private BigDecimal	r8_inter_bank_borrow;
	private BigDecimal	r8_other_placement;
	private BigDecimal	r8_other_borrow;
	private BigDecimal	r8_remani_balance_from;
	private BigDecimal	r8_remani_balance_to;
	private String	r9_product;
	private BigDecimal	r9_inter_bank_place;
	private BigDecimal	r9_inter_bank_borrow;
	private BigDecimal	r9_other_placement;
	private BigDecimal	r9_other_borrow;
	private BigDecimal	r9_remani_balance_from;
	private BigDecimal	r9_remani_balance_to;
	private String	r10_product;
	private BigDecimal	r10_inter_bank_place;
	private BigDecimal	r10_inter_bank_borrow;
	private BigDecimal	r10_other_placement;
	private BigDecimal	r10_other_borrow;
	private BigDecimal	r10_remani_balance_from;
	private BigDecimal	r10_remani_balance_to;
	private String	r11_product;
	private BigDecimal	r11_inter_bank_place;
	private BigDecimal	r11_inter_bank_borrow;
	private BigDecimal	r11_other_placement;
	private BigDecimal	r11_other_borrow;
	private BigDecimal	r11_remani_balance_from;
	private BigDecimal	r11_remani_balance_to;
	private String	r12_product;
	private BigDecimal	r12_inter_bank_place;
	private BigDecimal	r12_inter_bank_borrow;
	private BigDecimal	r12_other_placement;
	private BigDecimal	r12_other_borrow;
	private BigDecimal	r12_remani_balance_from;
	private BigDecimal	r12_remani_balance_to;
	private String	r13_product;
	private BigDecimal	r13_inter_bank_place;
	private BigDecimal	r13_inter_bank_borrow;
	private BigDecimal	r13_other_placement;
	private BigDecimal	r13_other_borrow;
	private BigDecimal	r13_remani_balance_from;
	private BigDecimal	r13_remani_balance_to;
	private String	r14_product;
	private BigDecimal	r14_inter_bank_place;
	private BigDecimal	r14_inter_bank_borrow;
	private BigDecimal	r14_other_placement;
	private BigDecimal	r14_other_borrow;
	private BigDecimal	r14_remani_balance_from;
	private BigDecimal	r14_remani_balance_to;
	private String	r15_product;
	private BigDecimal	r15_inter_bank_place;
	private BigDecimal	r15_inter_bank_borrow;
	private BigDecimal	r15_other_placement;
	private BigDecimal	r15_other_borrow;
	private BigDecimal	r15_remani_balance_from;
	private BigDecimal	r15_remani_balance_to;
	private String	r16_product;
	private BigDecimal	r16_inter_bank_place;
	private BigDecimal	r16_inter_bank_borrow;
	private BigDecimal	r16_other_placement;
	private BigDecimal	r16_other_borrow;
	private BigDecimal	r16_remani_balance_from;
	private BigDecimal	r16_remani_balance_to;
	private String	r17_product;
	private BigDecimal	r17_inter_bank_place;
	private BigDecimal	r17_inter_bank_borrow;
	private BigDecimal	r17_other_placement;
	private BigDecimal	r17_other_borrow;
	private BigDecimal	r17_remani_balance_from;
	private BigDecimal	r17_remani_balance_to;
	private String	r18_product;
	private BigDecimal	r18_inter_bank_place;
	private BigDecimal	r18_inter_bank_borrow;
	private BigDecimal	r18_other_placement;
	private BigDecimal	r18_other_borrow;
	private BigDecimal	r18_remani_balance_from;
	private BigDecimal	r18_remani_balance_to;
	private String	r19_product;
	private BigDecimal	r19_inter_bank_place;
	private BigDecimal	r19_inter_bank_borrow;
	private BigDecimal	r19_other_placement;
	private BigDecimal	r19_other_borrow;
	private BigDecimal	r19_remani_balance_from;
	private BigDecimal	r19_remani_balance_to;
	private String	r20_product;
	private BigDecimal	r20_inter_bank_place;
	private BigDecimal	r20_inter_bank_borrow;
	private BigDecimal	r20_other_placement;
	private BigDecimal	r20_other_borrow;
	private BigDecimal	r20_remani_balance_from;
	private BigDecimal	r20_remani_balance_to;
	private String	r21_product;
	private BigDecimal	r21_inter_bank_place;
	private BigDecimal	r21_inter_bank_borrow;
	private BigDecimal	r21_other_placement;
	private BigDecimal	r21_other_borrow;
	private BigDecimal	r21_remani_balance_from;
	private BigDecimal	r21_remani_balance_to;
	private String	r22_product;
	private BigDecimal	r22_inter_bank_place;
	private BigDecimal	r22_inter_bank_borrow;
	private BigDecimal	r22_other_placement;
	private BigDecimal	r22_other_borrow;
	private BigDecimal	r22_remani_balance_from;
	private BigDecimal	r22_remani_balance_to;
	private String	r23_product;
	private BigDecimal	r23_inter_bank_place;
	private BigDecimal	r23_inter_bank_borrow;
	private BigDecimal	r23_other_placement;
	private BigDecimal	r23_other_borrow;
	private BigDecimal	r23_remani_balance_from;
	private BigDecimal	r23_remani_balance_to;
	private String	r24_product;
	private BigDecimal	r24_inter_bank_place;
	private BigDecimal	r24_inter_bank_borrow;
	private BigDecimal	r24_other_placement;
	private BigDecimal	r24_other_borrow;
	private BigDecimal	r24_remani_balance_from;
	private BigDecimal	r24_remani_balance_to;
	private String	r25_product;
	private BigDecimal	r25_inter_bank_place;
	private BigDecimal	r25_inter_bank_borrow;
	private BigDecimal	r25_other_placement;
	private BigDecimal	r25_other_borrow;
	private BigDecimal	r25_remani_balance_from;
	private BigDecimal	r25_remani_balance_to;
	private String	r26_product;
	private BigDecimal	r26_inter_bank_place;
	private BigDecimal	r26_inter_bank_borrow;
	private BigDecimal	r26_other_placement;
	private BigDecimal	r26_other_borrow;
	private BigDecimal	r26_remani_balance_from;
	private BigDecimal	r26_remani_balance_to;
	private String	r27_product;
	private BigDecimal	r27_inter_bank_place;
	private BigDecimal	r27_inter_bank_borrow;
	private BigDecimal	r27_other_placement;
	private BigDecimal	r27_other_borrow;
	private BigDecimal	r27_remani_balance_from;
	private BigDecimal	r27_remani_balance_to;
	private String	r28_product;
	private BigDecimal	r28_inter_bank_place;
	private BigDecimal	r28_inter_bank_borrow;
	private BigDecimal	r28_other_placement;
	private BigDecimal	r28_other_borrow;
	private BigDecimal	r28_remani_balance_from;
	private BigDecimal	r28_remani_balance_to;
	private String	r29_product;
	private BigDecimal	r29_inter_bank_place;
	private BigDecimal	r29_inter_bank_borrow;
	private BigDecimal	r29_other_placement;
	private BigDecimal	r29_other_borrow;
	private BigDecimal	r29_remani_balance_from;
	private BigDecimal	r29_remani_balance_to;
	private String	r30_product;
	private BigDecimal	r30_inter_bank_place;
	private BigDecimal	r30_inter_bank_borrow;
	private BigDecimal	r30_other_placement;
	private BigDecimal	r30_other_borrow;
	private BigDecimal	r30_remani_balance_from;
	private BigDecimal	r30_remani_balance_to;
	private String	r31_product;
	private BigDecimal	r31_inter_bank_place;
	private BigDecimal	r31_inter_bank_borrow;
	private BigDecimal	r31_other_placement;
	private BigDecimal	r31_other_borrow;
	private BigDecimal	r31_remani_balance_from;
	private BigDecimal	r31_remani_balance_to;
	private String	r32_product;
	private BigDecimal	r32_inter_bank_place;
	private BigDecimal	r32_inter_bank_borrow;
	private BigDecimal	r32_other_placement;
	private BigDecimal	r32_other_borrow;
	private BigDecimal	r32_remani_balance_from;
	private BigDecimal	r32_remani_balance_to;
	private String	r33_product;
	private BigDecimal	r33_inter_bank_place;
	private BigDecimal	r33_inter_bank_borrow;
	private BigDecimal	r33_other_placement;
	private BigDecimal	r33_other_borrow;
	private BigDecimal	r33_remani_balance_from;
	private BigDecimal	r33_remani_balance_to;
	private String	r34_product;
	private BigDecimal	r34_inter_bank_place;
	private BigDecimal	r34_inter_bank_borrow;
	private BigDecimal	r34_other_placement;
	private BigDecimal	r34_other_borrow;
	private BigDecimal	r34_remani_balance_from;
	private BigDecimal	r34_remani_balance_to;
	private String	r35_product;
	private BigDecimal	r35_inter_bank_place;
	private BigDecimal	r35_inter_bank_borrow;
	private BigDecimal	r35_other_placement;
	private BigDecimal	r35_other_borrow;
	private BigDecimal	r35_remani_balance_from;
	private BigDecimal	r35_remani_balance_to;
	private String	r36_product;
	private BigDecimal	r36_inter_bank_place;
	private BigDecimal	r36_inter_bank_borrow;
	private BigDecimal	r36_other_placement;
	private BigDecimal	r36_other_borrow;
	private BigDecimal	r36_remani_balance_from;
	private BigDecimal	r36_remani_balance_to;
	private String	rh2_product;
	private BigDecimal	rh2_inter_bank_place;
	private BigDecimal	rh2_inter_bank_borrow;
	private BigDecimal	rh2_other_placement;
	private BigDecimal	rh2_other_borrow;
	private BigDecimal	rh2_remani_balance_from;
	private BigDecimal	rh2_remani_balance_to;
	private String	r37_product;
	private BigDecimal	r37_inter_bank_place;
	private BigDecimal	r37_inter_bank_borrow;
	private BigDecimal	r37_other_placement;
	private BigDecimal	r37_other_borrow;
	private BigDecimal	r37_remani_balance_from;
	private BigDecimal	r37_remani_balance_to;
	private String	r38_product;
	private BigDecimal	r38_inter_bank_place;
	private BigDecimal	r38_inter_bank_borrow;
	private BigDecimal	r38_other_placement;
	private BigDecimal	r38_other_borrow;
	private BigDecimal	r38_remani_balance_from;
	private BigDecimal	r38_remani_balance_to;
	private String	r39_product;
	private BigDecimal	r39_inter_bank_place;
	private BigDecimal	r39_inter_bank_borrow;
	private BigDecimal	r39_other_placement;
	private BigDecimal	r39_other_borrow;
	private BigDecimal	r39_remani_balance_from;
	private BigDecimal	r39_remani_balance_to;
	private String	r40_product;
	private BigDecimal	r40_inter_bank_place;
	private BigDecimal	r40_inter_bank_borrow;
	private BigDecimal	r40_other_placement;
	private BigDecimal	r40_other_borrow;
	private BigDecimal	r40_remani_balance_from;
	private BigDecimal	r40_remani_balance_to;
	private String	r41_product;
	private BigDecimal	r41_inter_bank_place;
	private BigDecimal	r41_inter_bank_borrow;
	private BigDecimal	r41_other_placement;
	private BigDecimal	r41_other_borrow;
	private BigDecimal	r41_remani_balance_from;
	private BigDecimal	r41_remani_balance_to;
	private String	r42_product;
	private BigDecimal	r42_inter_bank_place;
	private BigDecimal	r42_inter_bank_borrow;
	private BigDecimal	r42_other_placement;
	private BigDecimal	r42_other_borrow;
	private BigDecimal	r42_remani_balance_from;
	private BigDecimal	r42_remani_balance_to;
	private String	r43_product;
	private BigDecimal	r43_inter_bank_place;
	private BigDecimal	r43_inter_bank_borrow;
	private BigDecimal	r43_other_placement;
	private BigDecimal	r43_other_borrow;
	private BigDecimal	r43_remani_balance_from;
	private BigDecimal	r43_remani_balance_to;
	private String	rh3_product;
	private BigDecimal	rh3_inter_bank_place;
	private BigDecimal	rh3_inter_bank_borrow;
	private BigDecimal	rh3_other_placement;
	private BigDecimal	rh3_other_borrow;
	private BigDecimal	rh3_remani_balance_from;
	private BigDecimal	rh3_remani_balance_to;
	private String	r44_product;
	private BigDecimal	r44_inter_bank_place;
	private BigDecimal	r44_inter_bank_borrow;
	private BigDecimal	r44_other_placement;
	private BigDecimal	r44_other_borrow;
	private BigDecimal	r44_remani_balance_from;
	private BigDecimal	r44_remani_balance_to;
	private String	r45_product;
	private BigDecimal	r45_inter_bank_place;
	private BigDecimal	r45_inter_bank_borrow;
	private BigDecimal	r45_other_placement;
	private BigDecimal	r45_other_borrow;
	private BigDecimal	r45_remani_balance_from;
	private BigDecimal	r45_remani_balance_to;
	private String	r46_product;
	private BigDecimal	r46_inter_bank_place;
	private BigDecimal	r46_inter_bank_borrow;
	private BigDecimal	r46_other_placement;
	private BigDecimal	r46_other_borrow;
	private BigDecimal	r46_remani_balance_from;
	private BigDecimal	r46_remani_balance_to;
	private String	r47_product;
	private BigDecimal	r47_inter_bank_place;
	private BigDecimal	r47_inter_bank_borrow;
	private BigDecimal	r47_other_placement;
	private BigDecimal	r47_other_borrow;
	private BigDecimal	r47_remani_balance_from;
	private BigDecimal	r47_remani_balance_to;
	private String	r48_product;
	private BigDecimal	r48_inter_bank_place;
	private BigDecimal	r48_inter_bank_borrow;
	private BigDecimal	r48_other_placement;
	private BigDecimal	r48_other_borrow;
	private BigDecimal	r48_remani_balance_from;
	private BigDecimal	r48_remani_balance_to;
	private String	r49_product;
	private BigDecimal	r49_inter_bank_place;
	private BigDecimal	r49_inter_bank_borrow;
	private BigDecimal	r49_other_placement;
	private BigDecimal	r49_other_borrow;
	private BigDecimal	r49_remani_balance_from;
	private BigDecimal	r49_remani_balance_to;
	private String	r50_product;
	private BigDecimal	r50_inter_bank_place;
	private BigDecimal	r50_inter_bank_borrow;
	private BigDecimal	r50_other_placement;
	private BigDecimal	r50_other_borrow;
	private BigDecimal	r50_remani_balance_from;
	private BigDecimal	r50_remani_balance_to;
	private String	r51_product;
	private BigDecimal	r51_inter_bank_place;
	private BigDecimal	r51_inter_bank_borrow;
	private BigDecimal	r51_other_placement;
	private BigDecimal	r51_other_borrow;
	private BigDecimal	r51_remani_balance_from;
	private BigDecimal	r51_remani_balance_to;
	private String	r52_product;
	private BigDecimal	r52_inter_bank_place;
	private BigDecimal	r52_inter_bank_borrow;
	private BigDecimal	r52_other_placement;
	private BigDecimal	r52_other_borrow;
	private BigDecimal	r52_remani_balance_from;
	private BigDecimal	r52_remani_balance_to;
	private String	r53_product;
	private BigDecimal	r53_inter_bank_place;
	private BigDecimal	r53_inter_bank_borrow;
	private BigDecimal	r53_other_placement;
	private BigDecimal	r53_other_borrow;
	private BigDecimal	r53_remani_balance_from;
	private BigDecimal	r53_remani_balance_to;
	private String	r54_product;
	private BigDecimal	r54_inter_bank_place;
	private BigDecimal	r54_inter_bank_borrow;
	private BigDecimal	r54_other_placement;
	private BigDecimal	r54_other_borrow;
	private BigDecimal	r54_remani_balance_from;
	private BigDecimal	r54_remani_balance_to;
	private String	r55_product;
	private BigDecimal	r55_inter_bank_place;
	private BigDecimal	r55_inter_bank_borrow;
	private BigDecimal	r55_other_placement;
	private BigDecimal	r55_other_borrow;
	private BigDecimal	r55_remani_balance_from;
	private BigDecimal	r55_remani_balance_to;
	private String	r56_product;
	private BigDecimal	r56_inter_bank_place;
	private BigDecimal	r56_inter_bank_borrow;
	private BigDecimal	r56_other_placement;
	private BigDecimal	r56_other_borrow;
	private BigDecimal	r56_remani_balance_from;
	private BigDecimal	r56_remani_balance_to;
	private String	r57_product;
	private BigDecimal	r57_inter_bank_place;
	private BigDecimal	r57_inter_bank_borrow;
	private BigDecimal	r57_other_placement;
	private BigDecimal	r57_other_borrow;
	private BigDecimal	r57_remani_balance_from;
	private BigDecimal	r57_remani_balance_to;
	private String	r58_product;
	private BigDecimal	r58_inter_bank_place;
	private BigDecimal	r58_inter_bank_borrow;
	private BigDecimal	r58_other_placement;
	private BigDecimal	r58_other_borrow;
	private BigDecimal	r58_remani_balance_from;
	private BigDecimal	r58_remani_balance_to;
	private String	r59_product;
	private BigDecimal	r59_inter_bank_place;
	private BigDecimal	r59_inter_bank_borrow;
	private BigDecimal	r59_other_placement;
	private BigDecimal	r59_other_borrow;
	private BigDecimal	r59_remani_balance_from;
	private BigDecimal	r59_remani_balance_to;
	private String	r60_product;
	private BigDecimal	r60_inter_bank_place;
	private BigDecimal	r60_inter_bank_borrow;
	private BigDecimal	r60_other_placement;
	private BigDecimal	r60_other_borrow;
	private BigDecimal	r60_remani_balance_from;
	private BigDecimal	r60_remani_balance_to;
	private String	r61_product;
	private BigDecimal	r61_inter_bank_place;
	private BigDecimal	r61_inter_bank_borrow;
	private BigDecimal	r61_other_placement;
	private BigDecimal	r61_other_borrow;
	private BigDecimal	r61_remani_balance_from;
	private BigDecimal	r61_remani_balance_to;
	private String	r62_product;
	private BigDecimal	r62_inter_bank_place;
	private BigDecimal	r62_inter_bank_borrow;
	private BigDecimal	r62_other_placement;
	private BigDecimal	r62_other_borrow;
	private BigDecimal	r62_remani_balance_from;
	private BigDecimal	r62_remani_balance_to;
	private String	r63_product;
	private BigDecimal	r63_inter_bank_place;
	private BigDecimal	r63_inter_bank_borrow;
	private BigDecimal	r63_other_placement;
	private BigDecimal	r63_other_borrow;
	private BigDecimal	r63_remani_balance_from;
	private BigDecimal	r63_remani_balance_to;
	private String	r64_product;
	private BigDecimal	r64_inter_bank_place;
	private BigDecimal	r64_inter_bank_borrow;
	private BigDecimal	r64_other_placement;
	private BigDecimal	r64_other_borrow;
	private BigDecimal	r64_remani_balance_from;
	private BigDecimal	r64_remani_balance_to;
	private String	r65_product;
	private BigDecimal	r65_inter_bank_place;
	private BigDecimal	r65_inter_bank_borrow;
	private BigDecimal	r65_other_placement;
	private BigDecimal	r65_other_borrow;
	private BigDecimal	r65_remani_balance_from;
	private BigDecimal	r65_remani_balance_to;
	private String	r66_product;
	private BigDecimal	r66_inter_bank_place;
	private BigDecimal	r66_inter_bank_borrow;
	private BigDecimal	r66_other_placement;
	private BigDecimal	r66_other_borrow;
	private BigDecimal	r66_remani_balance_from;
	private BigDecimal	r66_remani_balance_to;
	private String	r67_product;
	private BigDecimal	r67_inter_bank_place;
	private BigDecimal	r67_inter_bank_borrow;
	private BigDecimal	r67_other_placement;
	private BigDecimal	r67_other_borrow;
	private BigDecimal	r67_remani_balance_from;
	private BigDecimal	r67_remani_balance_to;
	private String	r68_product;
	private BigDecimal	r68_inter_bank_place;
	private BigDecimal	r68_inter_bank_borrow;
	private BigDecimal	r68_other_placement;
	private BigDecimal	r68_other_borrow;
	private BigDecimal	r68_remani_balance_from;
	private BigDecimal	r68_remani_balance_to;
	private String	r69_product;
	private BigDecimal	r69_inter_bank_place;
	private BigDecimal	r69_inter_bank_borrow;
	private BigDecimal	r69_other_placement;
	private BigDecimal	r69_other_borrow;
	private BigDecimal	r69_remani_balance_from;
	private BigDecimal	r69_remani_balance_to;
	private String	r70_product;
	private BigDecimal	r70_inter_bank_place;
	private BigDecimal	r70_inter_bank_borrow;
	private BigDecimal	r70_other_placement;
	private BigDecimal	r70_other_borrow;
	private BigDecimal	r70_remani_balance_from;
	private BigDecimal	r70_remani_balance_to;
	private String	r71_product;
	private BigDecimal	r71_inter_bank_place;
	private BigDecimal	r71_inter_bank_borrow;
	private BigDecimal	r71_other_placement;
	private BigDecimal	r71_other_borrow;
	private BigDecimal	r71_remani_balance_from;
	private BigDecimal	r71_remani_balance_to;
	private String	r72_product;
	private BigDecimal	r72_inter_bank_place;
	private BigDecimal	r72_inter_bank_borrow;
	private BigDecimal	r72_other_placement;
	private BigDecimal	r72_other_borrow;
	private BigDecimal	r72_remani_balance_from;
	private BigDecimal	r72_remani_balance_to;
	private String	r73_product;
	private BigDecimal	r73_inter_bank_place;
	private BigDecimal	r73_inter_bank_borrow;
	private BigDecimal	r73_other_placement;
	private BigDecimal	r73_other_borrow;
	private BigDecimal	r73_remani_balance_from;
	private BigDecimal	r73_remani_balance_to;
	private String	r74_product;
	private BigDecimal	r74_inter_bank_place;
	private BigDecimal	r74_inter_bank_borrow;
	private BigDecimal	r74_other_placement;
	private BigDecimal	r74_other_borrow;
	private BigDecimal	r74_remani_balance_from;
	private BigDecimal	r74_remani_balance_to;
	private String	r75_product;
	private BigDecimal	r75_inter_bank_place;
	private BigDecimal	r75_inter_bank_borrow;
	private BigDecimal	r75_other_placement;
	private BigDecimal	r75_other_borrow;
	private BigDecimal	r75_remani_balance_from;
	private BigDecimal	r75_remani_balance_to;
	private String	r76_product;
	private BigDecimal	r76_inter_bank_place;
	private BigDecimal	r76_inter_bank_borrow;
	private BigDecimal	r76_other_placement;
	private BigDecimal	r76_other_borrow;
	private BigDecimal	r76_remani_balance_from;
	private BigDecimal	r76_remani_balance_to;
	private String	r77_product;
	private BigDecimal	r77_inter_bank_place;
	private BigDecimal	r77_inter_bank_borrow;
	private BigDecimal	r77_other_placement;
	private BigDecimal	r77_other_borrow;
	private BigDecimal	r77_remani_balance_from;
	private BigDecimal	r77_remani_balance_to;
	private String	r78_product;
	private BigDecimal	r78_inter_bank_place;
	private BigDecimal	r78_inter_bank_borrow;
	private BigDecimal	r78_other_placement;
	private BigDecimal	r78_other_borrow;
	private BigDecimal	r78_remani_balance_from;
	private BigDecimal	r78_remani_balance_to;
	private String	r79_product;
	private BigDecimal	r79_inter_bank_place;
	private BigDecimal	r79_inter_bank_borrow;
	private BigDecimal	r79_other_placement;
	private BigDecimal	r79_other_borrow;
	private BigDecimal	r79_remani_balance_from;
	private BigDecimal	r79_remani_balance_to;
	private String	r80_product;
	private BigDecimal	r80_inter_bank_place;
	private BigDecimal	r80_inter_bank_borrow;
	private BigDecimal	r80_other_placement;
	private BigDecimal	r80_other_borrow;
	private BigDecimal	r80_remani_balance_from;
	private BigDecimal	r80_remani_balance_to;
	private String	r81_product;
	private BigDecimal	r81_inter_bank_place;
	private BigDecimal	r81_inter_bank_borrow;
	private BigDecimal	r81_other_placement;
	private BigDecimal	r81_other_borrow;
	private BigDecimal	r81_remani_balance_from;
	private BigDecimal	r81_remani_balance_to;
	private String	rh4_product;
	private BigDecimal	rh4_inter_bank_place;
	private BigDecimal	rh4_inter_bank_borrow;
	private BigDecimal	rh4_other_placement;
	private BigDecimal	rh4_other_borrow;
	private BigDecimal	rh4_remani_balance_from;
	private BigDecimal	rh4_remani_balance_to;
	private String	r82_product;
	private BigDecimal	r82_inter_bank_place;
	private BigDecimal	r82_inter_bank_borrow;
	private BigDecimal	r82_other_placement;
	private BigDecimal	r82_other_borrow;
	private BigDecimal	r82_remani_balance_from;
	private BigDecimal	r82_remani_balance_to;
	private String	r83_product;
	private BigDecimal	r83_inter_bank_place;
	private BigDecimal	r83_inter_bank_borrow;
	private BigDecimal	r83_other_placement;
	private BigDecimal	r83_other_borrow;
	private BigDecimal	r83_remani_balance_from;
	private BigDecimal	r83_remani_balance_to;
	private String	r84_product;
	private BigDecimal	r84_inter_bank_place;
	private BigDecimal	r84_inter_bank_borrow;
	private BigDecimal	r84_other_placement;
	private BigDecimal	r84_other_borrow;
	private BigDecimal	r84_remani_balance_from;
	private BigDecimal	r84_remani_balance_to;
	private String	r85_product;
	private BigDecimal	r85_inter_bank_place;
	private BigDecimal	r85_inter_bank_borrow;
	private BigDecimal	r85_other_placement;
	private BigDecimal	r85_other_borrow;
	private BigDecimal	r85_remani_balance_from;
	private BigDecimal	r85_remani_balance_to;
	private String	r86_product;
	private BigDecimal	r86_inter_bank_place;
	private BigDecimal	r86_inter_bank_borrow;
	private BigDecimal	r86_other_placement;
	private BigDecimal	r86_other_borrow;
	private BigDecimal	r86_remani_balance_from;
	private BigDecimal	r86_remani_balance_to;
	private String	r87_product;
	private BigDecimal	r87_inter_bank_place;
	private BigDecimal	r87_inter_bank_borrow;
	private BigDecimal	r87_other_placement;
	private BigDecimal	r87_other_borrow;
	private BigDecimal	r87_remani_balance_from;
	private BigDecimal	r87_remani_balance_to;
	private String	r88_product;
	private BigDecimal	r88_inter_bank_place;
	private BigDecimal	r88_inter_bank_borrow;
	private BigDecimal	r88_other_placement;
	private BigDecimal	r88_other_borrow;
	private BigDecimal	r88_remani_balance_from;
	private BigDecimal	r88_remani_balance_to;
	private String	r89_product;
	private BigDecimal	r89_inter_bank_place;
	private BigDecimal	r89_inter_bank_borrow;
	private BigDecimal	r89_other_placement;
	private BigDecimal	r89_other_borrow;
	private BigDecimal	r89_remani_balance_from;
	private BigDecimal	r89_remani_balance_to;
	private String	r90_product;
	private BigDecimal	r90_inter_bank_place;
	private BigDecimal	r90_inter_bank_borrow;
	private BigDecimal	r90_other_placement;
	private BigDecimal	r90_other_borrow;
	private BigDecimal	r90_remani_balance_from;
	private BigDecimal	r90_remani_balance_to;
	private String	r91_product;
	private BigDecimal	r91_inter_bank_place;
	private BigDecimal	r91_inter_bank_borrow;
	private BigDecimal	r91_other_placement;
	private BigDecimal	r91_other_borrow;
	private BigDecimal	r91_remani_balance_from;
	private BigDecimal	r91_remani_balance_to;
	private String	r92_product;
	private BigDecimal	r92_inter_bank_place;
	private BigDecimal	r92_inter_bank_borrow;
	private BigDecimal	r92_other_placement;
	private BigDecimal	r92_other_borrow;
	private BigDecimal	r92_remani_balance_from;
	private BigDecimal	r92_remani_balance_to;
	private String	r93_product;
	private BigDecimal	r93_inter_bank_place;
	private BigDecimal	r93_inter_bank_borrow;
	private BigDecimal	r93_other_placement;
	private BigDecimal	r93_other_borrow;
	private BigDecimal	r93_remani_balance_from;
	private BigDecimal	r93_remani_balance_to;
	private String	r94_product;
	private BigDecimal	r94_inter_bank_place;
	private BigDecimal	r94_inter_bank_borrow;
	private BigDecimal	r94_other_placement;
	private BigDecimal	r94_other_borrow;
	private BigDecimal	r94_remani_balance_from;
	private BigDecimal	r94_remani_balance_to;
	private String	r95_product;
	private BigDecimal	r95_inter_bank_place;
	private BigDecimal	r95_inter_bank_borrow;
	private BigDecimal	r95_other_placement;
	private BigDecimal	r95_other_borrow;
	private BigDecimal	r95_remani_balance_from;
	private BigDecimal	r95_remani_balance_to;
	private String	r96_product;
	private BigDecimal	r96_inter_bank_place;
	private BigDecimal	r96_inter_bank_borrow;
	private BigDecimal	r96_other_placement;
	private BigDecimal	r96_other_borrow;
	private BigDecimal	r96_remani_balance_from;
	private BigDecimal	r96_remani_balance_to;
	private String	r97_product;
	private BigDecimal	r97_inter_bank_place;
	private BigDecimal	r97_inter_bank_borrow;
	private BigDecimal	r97_other_placement;
	private BigDecimal	r97_other_borrow;
	private BigDecimal	r97_remani_balance_from;
	private BigDecimal	r97_remani_balance_to;
	private String	r98_product;
	private BigDecimal	r98_inter_bank_place;
	private BigDecimal	r98_inter_bank_borrow;
	private BigDecimal	r98_other_placement;
	private BigDecimal	r98_other_borrow;
	private BigDecimal	r98_remani_balance_from;
	private BigDecimal	r98_remani_balance_to;
	private String	r99_product;
	private BigDecimal	r99_inter_bank_place;
	private BigDecimal	r99_inter_bank_borrow;
	private BigDecimal	r99_other_placement;
	private BigDecimal	r99_other_borrow;
	private BigDecimal	r99_remani_balance_from;
	private BigDecimal	r99_remani_balance_to;
	private String	r100_product;
	private BigDecimal	r100_inter_bank_place;
	private BigDecimal	r100_inter_bank_borrow;
	private BigDecimal	r100_other_placement;
	private BigDecimal	r100_other_borrow;
	private BigDecimal	r100_remani_balance_from;
	private BigDecimal	r100_remani_balance_to;
	private String	r101_product;
	private BigDecimal	r101_inter_bank_place;
	private BigDecimal	r101_inter_bank_borrow;
	private BigDecimal	r101_other_placement;
	private BigDecimal	r101_other_borrow;
	private BigDecimal	r101_remani_balance_from;
	private BigDecimal	r101_remani_balance_to;
	private String	r102_product;
	private BigDecimal	r102_inter_bank_place;
	private BigDecimal	r102_inter_bank_borrow;
	private BigDecimal	r102_other_placement;
	private BigDecimal	r102_other_borrow;
	private BigDecimal	r102_remani_balance_from;
	private BigDecimal	r102_remani_balance_to;
	private String	r103_product;
	private BigDecimal	r103_inter_bank_place;
	private BigDecimal	r103_inter_bank_borrow;
	private BigDecimal	r103_other_placement;
	private BigDecimal	r103_other_borrow;
	private BigDecimal	r103_remani_balance_from;
	private BigDecimal	r103_remani_balance_to;
	private String	rtot_product;
	private BigDecimal	rtot_inter_bank_place;
	private BigDecimal	rtot_inter_bank_borrow;
	private BigDecimal	rtot_other_placement;
	private BigDecimal	rtot_other_borrow;
	private BigDecimal	rtot_remani_balance_from;
	private BigDecimal	rtot_remani_balance_to;

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
	public BigDecimal getRh_inter_bank_place() {
		return rh_inter_bank_place;
	}
	public void setRh_inter_bank_place(BigDecimal rh_inter_bank_place) {
		this.rh_inter_bank_place = rh_inter_bank_place;
	}
	public BigDecimal getRh_inter_bank_borrow() {
		return rh_inter_bank_borrow;
	}
	public void setRh_inter_bank_borrow(BigDecimal rh_inter_bank_borrow) {
		this.rh_inter_bank_borrow = rh_inter_bank_borrow;
	}
	public BigDecimal getRh_other_placement() {
		return rh_other_placement;
	}
	public void setRh_other_placement(BigDecimal rh_other_placement) {
		this.rh_other_placement = rh_other_placement;
	}
	public BigDecimal getRh_other_borrow() {
		return rh_other_borrow;
	}
	public void setRh_other_borrow(BigDecimal rh_other_borrow) {
		this.rh_other_borrow = rh_other_borrow;
	}
	public BigDecimal getRh_remani_balance_from() {
		return rh_remani_balance_from;
	}
	public void setRh_remani_balance_from(BigDecimal rh_remani_balance_from) {
		this.rh_remani_balance_from = rh_remani_balance_from;
	}
	public BigDecimal getRh_remani_balance_to() {
		return rh_remani_balance_to;
	}
	public void setRh_remani_balance_to(BigDecimal rh_remani_balance_to) {
		this.rh_remani_balance_to = rh_remani_balance_to;
	}
	public String getR1_product() {
		return r1_product;
	}
	public void setR1_product(String r1_product) {
		this.r1_product = r1_product;
	}
	public BigDecimal getR1_inter_bank_place() {
		return r1_inter_bank_place;
	}
	public void setR1_inter_bank_place(BigDecimal r1_inter_bank_place) {
		this.r1_inter_bank_place = r1_inter_bank_place;
	}
	public BigDecimal getR1_inter_bank_borrow() {
		return r1_inter_bank_borrow;
	}
	public void setR1_inter_bank_borrow(BigDecimal r1_inter_bank_borrow) {
		this.r1_inter_bank_borrow = r1_inter_bank_borrow;
	}
	public BigDecimal getR1_other_placement() {
		return r1_other_placement;
	}
	public void setR1_other_placement(BigDecimal r1_other_placement) {
		this.r1_other_placement = r1_other_placement;
	}
	public BigDecimal getR1_other_borrow() {
		return r1_other_borrow;
	}
	public void setR1_other_borrow(BigDecimal r1_other_borrow) {
		this.r1_other_borrow = r1_other_borrow;
	}
	public BigDecimal getR1_remani_balance_from() {
		return r1_remani_balance_from;
	}
	public void setR1_remani_balance_from(BigDecimal r1_remani_balance_from) {
		this.r1_remani_balance_from = r1_remani_balance_from;
	}
	public BigDecimal getR1_remani_balance_to() {
		return r1_remani_balance_to;
	}
	public void setR1_remani_balance_to(BigDecimal r1_remani_balance_to) {
		this.r1_remani_balance_to = r1_remani_balance_to;
	}
	public String getR2_product() {
		return r2_product;
	}
	public void setR2_product(String r2_product) {
		this.r2_product = r2_product;
	}
	public BigDecimal getR2_inter_bank_place() {
		return r2_inter_bank_place;
	}
	public void setR2_inter_bank_place(BigDecimal r2_inter_bank_place) {
		this.r2_inter_bank_place = r2_inter_bank_place;
	}
	public BigDecimal getR2_inter_bank_borrow() {
		return r2_inter_bank_borrow;
	}
	public void setR2_inter_bank_borrow(BigDecimal r2_inter_bank_borrow) {
		this.r2_inter_bank_borrow = r2_inter_bank_borrow;
	}
	public BigDecimal getR2_other_placement() {
		return r2_other_placement;
	}
	public void setR2_other_placement(BigDecimal r2_other_placement) {
		this.r2_other_placement = r2_other_placement;
	}
	public BigDecimal getR2_other_borrow() {
		return r2_other_borrow;
	}
	public void setR2_other_borrow(BigDecimal r2_other_borrow) {
		this.r2_other_borrow = r2_other_borrow;
	}
	public BigDecimal getR2_remani_balance_from() {
		return r2_remani_balance_from;
	}
	public void setR2_remani_balance_from(BigDecimal r2_remani_balance_from) {
		this.r2_remani_balance_from = r2_remani_balance_from;
	}
	public BigDecimal getR2_remani_balance_to() {
		return r2_remani_balance_to;
	}
	public void setR2_remani_balance_to(BigDecimal r2_remani_balance_to) {
		this.r2_remani_balance_to = r2_remani_balance_to;
	}
	public String getR3_product() {
		return r3_product;
	}
	public void setR3_product(String r3_product) {
		this.r3_product = r3_product;
	}
	public BigDecimal getR3_inter_bank_place() {
		return r3_inter_bank_place;
	}
	public void setR3_inter_bank_place(BigDecimal r3_inter_bank_place) {
		this.r3_inter_bank_place = r3_inter_bank_place;
	}
	public BigDecimal getR3_inter_bank_borrow() {
		return r3_inter_bank_borrow;
	}
	public void setR3_inter_bank_borrow(BigDecimal r3_inter_bank_borrow) {
		this.r3_inter_bank_borrow = r3_inter_bank_borrow;
	}
	public BigDecimal getR3_other_placement() {
		return r3_other_placement;
	}
	public void setR3_other_placement(BigDecimal r3_other_placement) {
		this.r3_other_placement = r3_other_placement;
	}
	public BigDecimal getR3_other_borrow() {
		return r3_other_borrow;
	}
	public void setR3_other_borrow(BigDecimal r3_other_borrow) {
		this.r3_other_borrow = r3_other_borrow;
	}
	public BigDecimal getR3_remani_balance_from() {
		return r3_remani_balance_from;
	}
	public void setR3_remani_balance_from(BigDecimal r3_remani_balance_from) {
		this.r3_remani_balance_from = r3_remani_balance_from;
	}
	public BigDecimal getR3_remani_balance_to() {
		return r3_remani_balance_to;
	}
	public void setR3_remani_balance_to(BigDecimal r3_remani_balance_to) {
		this.r3_remani_balance_to = r3_remani_balance_to;
	}
	public String getR4_product() {
		return r4_product;
	}
	public void setR4_product(String r4_product) {
		this.r4_product = r4_product;
	}
	public BigDecimal getR4_inter_bank_place() {
		return r4_inter_bank_place;
	}
	public void setR4_inter_bank_place(BigDecimal r4_inter_bank_place) {
		this.r4_inter_bank_place = r4_inter_bank_place;
	}
	public BigDecimal getR4_inter_bank_borrow() {
		return r4_inter_bank_borrow;
	}
	public void setR4_inter_bank_borrow(BigDecimal r4_inter_bank_borrow) {
		this.r4_inter_bank_borrow = r4_inter_bank_borrow;
	}
	public BigDecimal getR4_other_placement() {
		return r4_other_placement;
	}
	public void setR4_other_placement(BigDecimal r4_other_placement) {
		this.r4_other_placement = r4_other_placement;
	}
	public BigDecimal getR4_other_borrow() {
		return r4_other_borrow;
	}
	public void setR4_other_borrow(BigDecimal r4_other_borrow) {
		this.r4_other_borrow = r4_other_borrow;
	}
	public BigDecimal getR4_remani_balance_from() {
		return r4_remani_balance_from;
	}
	public void setR4_remani_balance_from(BigDecimal r4_remani_balance_from) {
		this.r4_remani_balance_from = r4_remani_balance_from;
	}
	public BigDecimal getR4_remani_balance_to() {
		return r4_remani_balance_to;
	}
	public void setR4_remani_balance_to(BigDecimal r4_remani_balance_to) {
		this.r4_remani_balance_to = r4_remani_balance_to;
	}
	public String getR5_product() {
		return r5_product;
	}
	public void setR5_product(String r5_product) {
		this.r5_product = r5_product;
	}
	public BigDecimal getR5_inter_bank_place() {
		return r5_inter_bank_place;
	}
	public void setR5_inter_bank_place(BigDecimal r5_inter_bank_place) {
		this.r5_inter_bank_place = r5_inter_bank_place;
	}
	public BigDecimal getR5_inter_bank_borrow() {
		return r5_inter_bank_borrow;
	}
	public void setR5_inter_bank_borrow(BigDecimal r5_inter_bank_borrow) {
		this.r5_inter_bank_borrow = r5_inter_bank_borrow;
	}
	public BigDecimal getR5_other_placement() {
		return r5_other_placement;
	}
	public void setR5_other_placement(BigDecimal r5_other_placement) {
		this.r5_other_placement = r5_other_placement;
	}
	public BigDecimal getR5_other_borrow() {
		return r5_other_borrow;
	}
	public void setR5_other_borrow(BigDecimal r5_other_borrow) {
		this.r5_other_borrow = r5_other_borrow;
	}
	public BigDecimal getR5_remani_balance_from() {
		return r5_remani_balance_from;
	}
	public void setR5_remani_balance_from(BigDecimal r5_remani_balance_from) {
		this.r5_remani_balance_from = r5_remani_balance_from;
	}
	public BigDecimal getR5_remani_balance_to() {
		return r5_remani_balance_to;
	}
	public void setR5_remani_balance_to(BigDecimal r5_remani_balance_to) {
		this.r5_remani_balance_to = r5_remani_balance_to;
	}
	public String getR6_product() {
		return r6_product;
	}
	public void setR6_product(String r6_product) {
		this.r6_product = r6_product;
	}
	public BigDecimal getR6_inter_bank_place() {
		return r6_inter_bank_place;
	}
	public void setR6_inter_bank_place(BigDecimal r6_inter_bank_place) {
		this.r6_inter_bank_place = r6_inter_bank_place;
	}
	public BigDecimal getR6_inter_bank_borrow() {
		return r6_inter_bank_borrow;
	}
	public void setR6_inter_bank_borrow(BigDecimal r6_inter_bank_borrow) {
		this.r6_inter_bank_borrow = r6_inter_bank_borrow;
	}
	public BigDecimal getR6_other_placement() {
		return r6_other_placement;
	}
	public void setR6_other_placement(BigDecimal r6_other_placement) {
		this.r6_other_placement = r6_other_placement;
	}
	public BigDecimal getR6_other_borrow() {
		return r6_other_borrow;
	}
	public void setR6_other_borrow(BigDecimal r6_other_borrow) {
		this.r6_other_borrow = r6_other_borrow;
	}
	public BigDecimal getR6_remani_balance_from() {
		return r6_remani_balance_from;
	}
	public void setR6_remani_balance_from(BigDecimal r6_remani_balance_from) {
		this.r6_remani_balance_from = r6_remani_balance_from;
	}
	public BigDecimal getR6_remani_balance_to() {
		return r6_remani_balance_to;
	}
	public void setR6_remani_balance_to(BigDecimal r6_remani_balance_to) {
		this.r6_remani_balance_to = r6_remani_balance_to;
	}
	public String getR7_product() {
		return r7_product;
	}
	public void setR7_product(String r7_product) {
		this.r7_product = r7_product;
	}
	public BigDecimal getR7_inter_bank_place() {
		return r7_inter_bank_place;
	}
	public void setR7_inter_bank_place(BigDecimal r7_inter_bank_place) {
		this.r7_inter_bank_place = r7_inter_bank_place;
	}
	public BigDecimal getR7_inter_bank_borrow() {
		return r7_inter_bank_borrow;
	}
	public void setR7_inter_bank_borrow(BigDecimal r7_inter_bank_borrow) {
		this.r7_inter_bank_borrow = r7_inter_bank_borrow;
	}
	public BigDecimal getR7_other_placement() {
		return r7_other_placement;
	}
	public void setR7_other_placement(BigDecimal r7_other_placement) {
		this.r7_other_placement = r7_other_placement;
	}
	public BigDecimal getR7_other_borrow() {
		return r7_other_borrow;
	}
	public void setR7_other_borrow(BigDecimal r7_other_borrow) {
		this.r7_other_borrow = r7_other_borrow;
	}
	public BigDecimal getR7_remani_balance_from() {
		return r7_remani_balance_from;
	}
	public void setR7_remani_balance_from(BigDecimal r7_remani_balance_from) {
		this.r7_remani_balance_from = r7_remani_balance_from;
	}
	public BigDecimal getR7_remani_balance_to() {
		return r7_remani_balance_to;
	}
	public void setR7_remani_balance_to(BigDecimal r7_remani_balance_to) {
		this.r7_remani_balance_to = r7_remani_balance_to;
	}
	public String getR8_product() {
		return r8_product;
	}
	public void setR8_product(String r8_product) {
		this.r8_product = r8_product;
	}
	public BigDecimal getR8_inter_bank_place() {
		return r8_inter_bank_place;
	}
	public void setR8_inter_bank_place(BigDecimal r8_inter_bank_place) {
		this.r8_inter_bank_place = r8_inter_bank_place;
	}
	public BigDecimal getR8_inter_bank_borrow() {
		return r8_inter_bank_borrow;
	}
	public void setR8_inter_bank_borrow(BigDecimal r8_inter_bank_borrow) {
		this.r8_inter_bank_borrow = r8_inter_bank_borrow;
	}
	public BigDecimal getR8_other_placement() {
		return r8_other_placement;
	}
	public void setR8_other_placement(BigDecimal r8_other_placement) {
		this.r8_other_placement = r8_other_placement;
	}
	public BigDecimal getR8_other_borrow() {
		return r8_other_borrow;
	}
	public void setR8_other_borrow(BigDecimal r8_other_borrow) {
		this.r8_other_borrow = r8_other_borrow;
	}
	public BigDecimal getR8_remani_balance_from() {
		return r8_remani_balance_from;
	}
	public void setR8_remani_balance_from(BigDecimal r8_remani_balance_from) {
		this.r8_remani_balance_from = r8_remani_balance_from;
	}
	public BigDecimal getR8_remani_balance_to() {
		return r8_remani_balance_to;
	}
	public void setR8_remani_balance_to(BigDecimal r8_remani_balance_to) {
		this.r8_remani_balance_to = r8_remani_balance_to;
	}
	public String getR9_product() {
		return r9_product;
	}
	public void setR9_product(String r9_product) {
		this.r9_product = r9_product;
	}
	public BigDecimal getR9_inter_bank_place() {
		return r9_inter_bank_place;
	}
	public void setR9_inter_bank_place(BigDecimal r9_inter_bank_place) {
		this.r9_inter_bank_place = r9_inter_bank_place;
	}
	public BigDecimal getR9_inter_bank_borrow() {
		return r9_inter_bank_borrow;
	}
	public void setR9_inter_bank_borrow(BigDecimal r9_inter_bank_borrow) {
		this.r9_inter_bank_borrow = r9_inter_bank_borrow;
	}
	public BigDecimal getR9_other_placement() {
		return r9_other_placement;
	}
	public void setR9_other_placement(BigDecimal r9_other_placement) {
		this.r9_other_placement = r9_other_placement;
	}
	public BigDecimal getR9_other_borrow() {
		return r9_other_borrow;
	}
	public void setR9_other_borrow(BigDecimal r9_other_borrow) {
		this.r9_other_borrow = r9_other_borrow;
	}
	public BigDecimal getR9_remani_balance_from() {
		return r9_remani_balance_from;
	}
	public void setR9_remani_balance_from(BigDecimal r9_remani_balance_from) {
		this.r9_remani_balance_from = r9_remani_balance_from;
	}
	public BigDecimal getR9_remani_balance_to() {
		return r9_remani_balance_to;
	}
	public void setR9_remani_balance_to(BigDecimal r9_remani_balance_to) {
		this.r9_remani_balance_to = r9_remani_balance_to;
	}
	public String getR10_product() {
		return r10_product;
	}
	public void setR10_product(String r10_product) {
		this.r10_product = r10_product;
	}
	public BigDecimal getR10_inter_bank_place() {
		return r10_inter_bank_place;
	}
	public void setR10_inter_bank_place(BigDecimal r10_inter_bank_place) {
		this.r10_inter_bank_place = r10_inter_bank_place;
	}
	public BigDecimal getR10_inter_bank_borrow() {
		return r10_inter_bank_borrow;
	}
	public void setR10_inter_bank_borrow(BigDecimal r10_inter_bank_borrow) {
		this.r10_inter_bank_borrow = r10_inter_bank_borrow;
	}
	public BigDecimal getR10_other_placement() {
		return r10_other_placement;
	}
	public void setR10_other_placement(BigDecimal r10_other_placement) {
		this.r10_other_placement = r10_other_placement;
	}
	public BigDecimal getR10_other_borrow() {
		return r10_other_borrow;
	}
	public void setR10_other_borrow(BigDecimal r10_other_borrow) {
		this.r10_other_borrow = r10_other_borrow;
	}
	public BigDecimal getR10_remani_balance_from() {
		return r10_remani_balance_from;
	}
	public void setR10_remani_balance_from(BigDecimal r10_remani_balance_from) {
		this.r10_remani_balance_from = r10_remani_balance_from;
	}
	public BigDecimal getR10_remani_balance_to() {
		return r10_remani_balance_to;
	}
	public void setR10_remani_balance_to(BigDecimal r10_remani_balance_to) {
		this.r10_remani_balance_to = r10_remani_balance_to;
	}
	public String getR11_product() {
		return r11_product;
	}
	public void setR11_product(String r11_product) {
		this.r11_product = r11_product;
	}
	public BigDecimal getR11_inter_bank_place() {
		return r11_inter_bank_place;
	}
	public void setR11_inter_bank_place(BigDecimal r11_inter_bank_place) {
		this.r11_inter_bank_place = r11_inter_bank_place;
	}
	public BigDecimal getR11_inter_bank_borrow() {
		return r11_inter_bank_borrow;
	}
	public void setR11_inter_bank_borrow(BigDecimal r11_inter_bank_borrow) {
		this.r11_inter_bank_borrow = r11_inter_bank_borrow;
	}
	public BigDecimal getR11_other_placement() {
		return r11_other_placement;
	}
	public void setR11_other_placement(BigDecimal r11_other_placement) {
		this.r11_other_placement = r11_other_placement;
	}
	public BigDecimal getR11_other_borrow() {
		return r11_other_borrow;
	}
	public void setR11_other_borrow(BigDecimal r11_other_borrow) {
		this.r11_other_borrow = r11_other_borrow;
	}
	public BigDecimal getR11_remani_balance_from() {
		return r11_remani_balance_from;
	}
	public void setR11_remani_balance_from(BigDecimal r11_remani_balance_from) {
		this.r11_remani_balance_from = r11_remani_balance_from;
	}
	public BigDecimal getR11_remani_balance_to() {
		return r11_remani_balance_to;
	}
	public void setR11_remani_balance_to(BigDecimal r11_remani_balance_to) {
		this.r11_remani_balance_to = r11_remani_balance_to;
	}
	public String getR12_product() {
		return r12_product;
	}
	public void setR12_product(String r12_product) {
		this.r12_product = r12_product;
	}
	public BigDecimal getR12_inter_bank_place() {
		return r12_inter_bank_place;
	}
	public void setR12_inter_bank_place(BigDecimal r12_inter_bank_place) {
		this.r12_inter_bank_place = r12_inter_bank_place;
	}
	public BigDecimal getR12_inter_bank_borrow() {
		return r12_inter_bank_borrow;
	}
	public void setR12_inter_bank_borrow(BigDecimal r12_inter_bank_borrow) {
		this.r12_inter_bank_borrow = r12_inter_bank_borrow;
	}
	public BigDecimal getR12_other_placement() {
		return r12_other_placement;
	}
	public void setR12_other_placement(BigDecimal r12_other_placement) {
		this.r12_other_placement = r12_other_placement;
	}
	public BigDecimal getR12_other_borrow() {
		return r12_other_borrow;
	}
	public void setR12_other_borrow(BigDecimal r12_other_borrow) {
		this.r12_other_borrow = r12_other_borrow;
	}
	public BigDecimal getR12_remani_balance_from() {
		return r12_remani_balance_from;
	}
	public void setR12_remani_balance_from(BigDecimal r12_remani_balance_from) {
		this.r12_remani_balance_from = r12_remani_balance_from;
	}
	public BigDecimal getR12_remani_balance_to() {
		return r12_remani_balance_to;
	}
	public void setR12_remani_balance_to(BigDecimal r12_remani_balance_to) {
		this.r12_remani_balance_to = r12_remani_balance_to;
	}
	public String getR13_product() {
		return r13_product;
	}
	public void setR13_product(String r13_product) {
		this.r13_product = r13_product;
	}
	public BigDecimal getR13_inter_bank_place() {
		return r13_inter_bank_place;
	}
	public void setR13_inter_bank_place(BigDecimal r13_inter_bank_place) {
		this.r13_inter_bank_place = r13_inter_bank_place;
	}
	public BigDecimal getR13_inter_bank_borrow() {
		return r13_inter_bank_borrow;
	}
	public void setR13_inter_bank_borrow(BigDecimal r13_inter_bank_borrow) {
		this.r13_inter_bank_borrow = r13_inter_bank_borrow;
	}
	public BigDecimal getR13_other_placement() {
		return r13_other_placement;
	}
	public void setR13_other_placement(BigDecimal r13_other_placement) {
		this.r13_other_placement = r13_other_placement;
	}
	public BigDecimal getR13_other_borrow() {
		return r13_other_borrow;
	}
	public void setR13_other_borrow(BigDecimal r13_other_borrow) {
		this.r13_other_borrow = r13_other_borrow;
	}
	public BigDecimal getR13_remani_balance_from() {
		return r13_remani_balance_from;
	}
	public void setR13_remani_balance_from(BigDecimal r13_remani_balance_from) {
		this.r13_remani_balance_from = r13_remani_balance_from;
	}
	public BigDecimal getR13_remani_balance_to() {
		return r13_remani_balance_to;
	}
	public void setR13_remani_balance_to(BigDecimal r13_remani_balance_to) {
		this.r13_remani_balance_to = r13_remani_balance_to;
	}
	public String getR14_product() {
		return r14_product;
	}
	public void setR14_product(String r14_product) {
		this.r14_product = r14_product;
	}
	public BigDecimal getR14_inter_bank_place() {
		return r14_inter_bank_place;
	}
	public void setR14_inter_bank_place(BigDecimal r14_inter_bank_place) {
		this.r14_inter_bank_place = r14_inter_bank_place;
	}
	public BigDecimal getR14_inter_bank_borrow() {
		return r14_inter_bank_borrow;
	}
	public void setR14_inter_bank_borrow(BigDecimal r14_inter_bank_borrow) {
		this.r14_inter_bank_borrow = r14_inter_bank_borrow;
	}
	public BigDecimal getR14_other_placement() {
		return r14_other_placement;
	}
	public void setR14_other_placement(BigDecimal r14_other_placement) {
		this.r14_other_placement = r14_other_placement;
	}
	public BigDecimal getR14_other_borrow() {
		return r14_other_borrow;
	}
	public void setR14_other_borrow(BigDecimal r14_other_borrow) {
		this.r14_other_borrow = r14_other_borrow;
	}
	public BigDecimal getR14_remani_balance_from() {
		return r14_remani_balance_from;
	}
	public void setR14_remani_balance_from(BigDecimal r14_remani_balance_from) {
		this.r14_remani_balance_from = r14_remani_balance_from;
	}
	public BigDecimal getR14_remani_balance_to() {
		return r14_remani_balance_to;
	}
	public void setR14_remani_balance_to(BigDecimal r14_remani_balance_to) {
		this.r14_remani_balance_to = r14_remani_balance_to;
	}
	public String getR15_product() {
		return r15_product;
	}
	public void setR15_product(String r15_product) {
		this.r15_product = r15_product;
	}
	public BigDecimal getR15_inter_bank_place() {
		return r15_inter_bank_place;
	}
	public void setR15_inter_bank_place(BigDecimal r15_inter_bank_place) {
		this.r15_inter_bank_place = r15_inter_bank_place;
	}
	public BigDecimal getR15_inter_bank_borrow() {
		return r15_inter_bank_borrow;
	}
	public void setR15_inter_bank_borrow(BigDecimal r15_inter_bank_borrow) {
		this.r15_inter_bank_borrow = r15_inter_bank_borrow;
	}
	public BigDecimal getR15_other_placement() {
		return r15_other_placement;
	}
	public void setR15_other_placement(BigDecimal r15_other_placement) {
		this.r15_other_placement = r15_other_placement;
	}
	public BigDecimal getR15_other_borrow() {
		return r15_other_borrow;
	}
	public void setR15_other_borrow(BigDecimal r15_other_borrow) {
		this.r15_other_borrow = r15_other_borrow;
	}
	public BigDecimal getR15_remani_balance_from() {
		return r15_remani_balance_from;
	}
	public void setR15_remani_balance_from(BigDecimal r15_remani_balance_from) {
		this.r15_remani_balance_from = r15_remani_balance_from;
	}
	public BigDecimal getR15_remani_balance_to() {
		return r15_remani_balance_to;
	}
	public void setR15_remani_balance_to(BigDecimal r15_remani_balance_to) {
		this.r15_remani_balance_to = r15_remani_balance_to;
	}
	public String getR16_product() {
		return r16_product;
	}
	public void setR16_product(String r16_product) {
		this.r16_product = r16_product;
	}
	public BigDecimal getR16_inter_bank_place() {
		return r16_inter_bank_place;
	}
	public void setR16_inter_bank_place(BigDecimal r16_inter_bank_place) {
		this.r16_inter_bank_place = r16_inter_bank_place;
	}
	public BigDecimal getR16_inter_bank_borrow() {
		return r16_inter_bank_borrow;
	}
	public void setR16_inter_bank_borrow(BigDecimal r16_inter_bank_borrow) {
		this.r16_inter_bank_borrow = r16_inter_bank_borrow;
	}
	public BigDecimal getR16_other_placement() {
		return r16_other_placement;
	}
	public void setR16_other_placement(BigDecimal r16_other_placement) {
		this.r16_other_placement = r16_other_placement;
	}
	public BigDecimal getR16_other_borrow() {
		return r16_other_borrow;
	}
	public void setR16_other_borrow(BigDecimal r16_other_borrow) {
		this.r16_other_borrow = r16_other_borrow;
	}
	public BigDecimal getR16_remani_balance_from() {
		return r16_remani_balance_from;
	}
	public void setR16_remani_balance_from(BigDecimal r16_remani_balance_from) {
		this.r16_remani_balance_from = r16_remani_balance_from;
	}
	public BigDecimal getR16_remani_balance_to() {
		return r16_remani_balance_to;
	}
	public void setR16_remani_balance_to(BigDecimal r16_remani_balance_to) {
		this.r16_remani_balance_to = r16_remani_balance_to;
	}
	public String getR17_product() {
		return r17_product;
	}
	public void setR17_product(String r17_product) {
		this.r17_product = r17_product;
	}
	public BigDecimal getR17_inter_bank_place() {
		return r17_inter_bank_place;
	}
	public void setR17_inter_bank_place(BigDecimal r17_inter_bank_place) {
		this.r17_inter_bank_place = r17_inter_bank_place;
	}
	public BigDecimal getR17_inter_bank_borrow() {
		return r17_inter_bank_borrow;
	}
	public void setR17_inter_bank_borrow(BigDecimal r17_inter_bank_borrow) {
		this.r17_inter_bank_borrow = r17_inter_bank_borrow;
	}
	public BigDecimal getR17_other_placement() {
		return r17_other_placement;
	}
	public void setR17_other_placement(BigDecimal r17_other_placement) {
		this.r17_other_placement = r17_other_placement;
	}
	public BigDecimal getR17_other_borrow() {
		return r17_other_borrow;
	}
	public void setR17_other_borrow(BigDecimal r17_other_borrow) {
		this.r17_other_borrow = r17_other_borrow;
	}
	public BigDecimal getR17_remani_balance_from() {
		return r17_remani_balance_from;
	}
	public void setR17_remani_balance_from(BigDecimal r17_remani_balance_from) {
		this.r17_remani_balance_from = r17_remani_balance_from;
	}
	public BigDecimal getR17_remani_balance_to() {
		return r17_remani_balance_to;
	}
	public void setR17_remani_balance_to(BigDecimal r17_remani_balance_to) {
		this.r17_remani_balance_to = r17_remani_balance_to;
	}
	public String getR18_product() {
		return r18_product;
	}
	public void setR18_product(String r18_product) {
		this.r18_product = r18_product;
	}
	public BigDecimal getR18_inter_bank_place() {
		return r18_inter_bank_place;
	}
	public void setR18_inter_bank_place(BigDecimal r18_inter_bank_place) {
		this.r18_inter_bank_place = r18_inter_bank_place;
	}
	public BigDecimal getR18_inter_bank_borrow() {
		return r18_inter_bank_borrow;
	}
	public void setR18_inter_bank_borrow(BigDecimal r18_inter_bank_borrow) {
		this.r18_inter_bank_borrow = r18_inter_bank_borrow;
	}
	public BigDecimal getR18_other_placement() {
		return r18_other_placement;
	}
	public void setR18_other_placement(BigDecimal r18_other_placement) {
		this.r18_other_placement = r18_other_placement;
	}
	public BigDecimal getR18_other_borrow() {
		return r18_other_borrow;
	}
	public void setR18_other_borrow(BigDecimal r18_other_borrow) {
		this.r18_other_borrow = r18_other_borrow;
	}
	public BigDecimal getR18_remani_balance_from() {
		return r18_remani_balance_from;
	}
	public void setR18_remani_balance_from(BigDecimal r18_remani_balance_from) {
		this.r18_remani_balance_from = r18_remani_balance_from;
	}
	public BigDecimal getR18_remani_balance_to() {
		return r18_remani_balance_to;
	}
	public void setR18_remani_balance_to(BigDecimal r18_remani_balance_to) {
		this.r18_remani_balance_to = r18_remani_balance_to;
	}
	public String getR19_product() {
		return r19_product;
	}
	public void setR19_product(String r19_product) {
		this.r19_product = r19_product;
	}
	public BigDecimal getR19_inter_bank_place() {
		return r19_inter_bank_place;
	}
	public void setR19_inter_bank_place(BigDecimal r19_inter_bank_place) {
		this.r19_inter_bank_place = r19_inter_bank_place;
	}
	public BigDecimal getR19_inter_bank_borrow() {
		return r19_inter_bank_borrow;
	}
	public void setR19_inter_bank_borrow(BigDecimal r19_inter_bank_borrow) {
		this.r19_inter_bank_borrow = r19_inter_bank_borrow;
	}
	public BigDecimal getR19_other_placement() {
		return r19_other_placement;
	}
	public void setR19_other_placement(BigDecimal r19_other_placement) {
		this.r19_other_placement = r19_other_placement;
	}
	public BigDecimal getR19_other_borrow() {
		return r19_other_borrow;
	}
	public void setR19_other_borrow(BigDecimal r19_other_borrow) {
		this.r19_other_borrow = r19_other_borrow;
	}
	public BigDecimal getR19_remani_balance_from() {
		return r19_remani_balance_from;
	}
	public void setR19_remani_balance_from(BigDecimal r19_remani_balance_from) {
		this.r19_remani_balance_from = r19_remani_balance_from;
	}
	public BigDecimal getR19_remani_balance_to() {
		return r19_remani_balance_to;
	}
	public void setR19_remani_balance_to(BigDecimal r19_remani_balance_to) {
		this.r19_remani_balance_to = r19_remani_balance_to;
	}
	public String getR20_product() {
		return r20_product;
	}
	public void setR20_product(String r20_product) {
		this.r20_product = r20_product;
	}
	public BigDecimal getR20_inter_bank_place() {
		return r20_inter_bank_place;
	}
	public void setR20_inter_bank_place(BigDecimal r20_inter_bank_place) {
		this.r20_inter_bank_place = r20_inter_bank_place;
	}
	public BigDecimal getR20_inter_bank_borrow() {
		return r20_inter_bank_borrow;
	}
	public void setR20_inter_bank_borrow(BigDecimal r20_inter_bank_borrow) {
		this.r20_inter_bank_borrow = r20_inter_bank_borrow;
	}
	public BigDecimal getR20_other_placement() {
		return r20_other_placement;
	}
	public void setR20_other_placement(BigDecimal r20_other_placement) {
		this.r20_other_placement = r20_other_placement;
	}
	public BigDecimal getR20_other_borrow() {
		return r20_other_borrow;
	}
	public void setR20_other_borrow(BigDecimal r20_other_borrow) {
		this.r20_other_borrow = r20_other_borrow;
	}
	public BigDecimal getR20_remani_balance_from() {
		return r20_remani_balance_from;
	}
	public void setR20_remani_balance_from(BigDecimal r20_remani_balance_from) {
		this.r20_remani_balance_from = r20_remani_balance_from;
	}
	public BigDecimal getR20_remani_balance_to() {
		return r20_remani_balance_to;
	}
	public void setR20_remani_balance_to(BigDecimal r20_remani_balance_to) {
		this.r20_remani_balance_to = r20_remani_balance_to;
	}
	public String getR21_product() {
		return r21_product;
	}
	public void setR21_product(String r21_product) {
		this.r21_product = r21_product;
	}
	public BigDecimal getR21_inter_bank_place() {
		return r21_inter_bank_place;
	}
	public void setR21_inter_bank_place(BigDecimal r21_inter_bank_place) {
		this.r21_inter_bank_place = r21_inter_bank_place;
	}
	public BigDecimal getR21_inter_bank_borrow() {
		return r21_inter_bank_borrow;
	}
	public void setR21_inter_bank_borrow(BigDecimal r21_inter_bank_borrow) {
		this.r21_inter_bank_borrow = r21_inter_bank_borrow;
	}
	public BigDecimal getR21_other_placement() {
		return r21_other_placement;
	}
	public void setR21_other_placement(BigDecimal r21_other_placement) {
		this.r21_other_placement = r21_other_placement;
	}
	public BigDecimal getR21_other_borrow() {
		return r21_other_borrow;
	}
	public void setR21_other_borrow(BigDecimal r21_other_borrow) {
		this.r21_other_borrow = r21_other_borrow;
	}
	public BigDecimal getR21_remani_balance_from() {
		return r21_remani_balance_from;
	}
	public void setR21_remani_balance_from(BigDecimal r21_remani_balance_from) {
		this.r21_remani_balance_from = r21_remani_balance_from;
	}
	public BigDecimal getR21_remani_balance_to() {
		return r21_remani_balance_to;
	}
	public void setR21_remani_balance_to(BigDecimal r21_remani_balance_to) {
		this.r21_remani_balance_to = r21_remani_balance_to;
	}
	public String getR22_product() {
		return r22_product;
	}
	public void setR22_product(String r22_product) {
		this.r22_product = r22_product;
	}
	public BigDecimal getR22_inter_bank_place() {
		return r22_inter_bank_place;
	}
	public void setR22_inter_bank_place(BigDecimal r22_inter_bank_place) {
		this.r22_inter_bank_place = r22_inter_bank_place;
	}
	public BigDecimal getR22_inter_bank_borrow() {
		return r22_inter_bank_borrow;
	}
	public void setR22_inter_bank_borrow(BigDecimal r22_inter_bank_borrow) {
		this.r22_inter_bank_borrow = r22_inter_bank_borrow;
	}
	public BigDecimal getR22_other_placement() {
		return r22_other_placement;
	}
	public void setR22_other_placement(BigDecimal r22_other_placement) {
		this.r22_other_placement = r22_other_placement;
	}
	public BigDecimal getR22_other_borrow() {
		return r22_other_borrow;
	}
	public void setR22_other_borrow(BigDecimal r22_other_borrow) {
		this.r22_other_borrow = r22_other_borrow;
	}
	public BigDecimal getR22_remani_balance_from() {
		return r22_remani_balance_from;
	}
	public void setR22_remani_balance_from(BigDecimal r22_remani_balance_from) {
		this.r22_remani_balance_from = r22_remani_balance_from;
	}
	public BigDecimal getR22_remani_balance_to() {
		return r22_remani_balance_to;
	}
	public void setR22_remani_balance_to(BigDecimal r22_remani_balance_to) {
		this.r22_remani_balance_to = r22_remani_balance_to;
	}
	public String getR23_product() {
		return r23_product;
	}
	public void setR23_product(String r23_product) {
		this.r23_product = r23_product;
	}
	public BigDecimal getR23_inter_bank_place() {
		return r23_inter_bank_place;
	}
	public void setR23_inter_bank_place(BigDecimal r23_inter_bank_place) {
		this.r23_inter_bank_place = r23_inter_bank_place;
	}
	public BigDecimal getR23_inter_bank_borrow() {
		return r23_inter_bank_borrow;
	}
	public void setR23_inter_bank_borrow(BigDecimal r23_inter_bank_borrow) {
		this.r23_inter_bank_borrow = r23_inter_bank_borrow;
	}
	public BigDecimal getR23_other_placement() {
		return r23_other_placement;
	}
	public void setR23_other_placement(BigDecimal r23_other_placement) {
		this.r23_other_placement = r23_other_placement;
	}
	public BigDecimal getR23_other_borrow() {
		return r23_other_borrow;
	}
	public void setR23_other_borrow(BigDecimal r23_other_borrow) {
		this.r23_other_borrow = r23_other_borrow;
	}
	public BigDecimal getR23_remani_balance_from() {
		return r23_remani_balance_from;
	}
	public void setR23_remani_balance_from(BigDecimal r23_remani_balance_from) {
		this.r23_remani_balance_from = r23_remani_balance_from;
	}
	public BigDecimal getR23_remani_balance_to() {
		return r23_remani_balance_to;
	}
	public void setR23_remani_balance_to(BigDecimal r23_remani_balance_to) {
		this.r23_remani_balance_to = r23_remani_balance_to;
	}
	public String getR24_product() {
		return r24_product;
	}
	public void setR24_product(String r24_product) {
		this.r24_product = r24_product;
	}
	public BigDecimal getR24_inter_bank_place() {
		return r24_inter_bank_place;
	}
	public void setR24_inter_bank_place(BigDecimal r24_inter_bank_place) {
		this.r24_inter_bank_place = r24_inter_bank_place;
	}
	public BigDecimal getR24_inter_bank_borrow() {
		return r24_inter_bank_borrow;
	}
	public void setR24_inter_bank_borrow(BigDecimal r24_inter_bank_borrow) {
		this.r24_inter_bank_borrow = r24_inter_bank_borrow;
	}
	public BigDecimal getR24_other_placement() {
		return r24_other_placement;
	}
	public void setR24_other_placement(BigDecimal r24_other_placement) {
		this.r24_other_placement = r24_other_placement;
	}
	public BigDecimal getR24_other_borrow() {
		return r24_other_borrow;
	}
	public void setR24_other_borrow(BigDecimal r24_other_borrow) {
		this.r24_other_borrow = r24_other_borrow;
	}
	public BigDecimal getR24_remani_balance_from() {
		return r24_remani_balance_from;
	}
	public void setR24_remani_balance_from(BigDecimal r24_remani_balance_from) {
		this.r24_remani_balance_from = r24_remani_balance_from;
	}
	public BigDecimal getR24_remani_balance_to() {
		return r24_remani_balance_to;
	}
	public void setR24_remani_balance_to(BigDecimal r24_remani_balance_to) {
		this.r24_remani_balance_to = r24_remani_balance_to;
	}
	public String getR25_product() {
		return r25_product;
	}
	public void setR25_product(String r25_product) {
		this.r25_product = r25_product;
	}
	public BigDecimal getR25_inter_bank_place() {
		return r25_inter_bank_place;
	}
	public void setR25_inter_bank_place(BigDecimal r25_inter_bank_place) {
		this.r25_inter_bank_place = r25_inter_bank_place;
	}
	public BigDecimal getR25_inter_bank_borrow() {
		return r25_inter_bank_borrow;
	}
	public void setR25_inter_bank_borrow(BigDecimal r25_inter_bank_borrow) {
		this.r25_inter_bank_borrow = r25_inter_bank_borrow;
	}
	public BigDecimal getR25_other_placement() {
		return r25_other_placement;
	}
	public void setR25_other_placement(BigDecimal r25_other_placement) {
		this.r25_other_placement = r25_other_placement;
	}
	public BigDecimal getR25_other_borrow() {
		return r25_other_borrow;
	}
	public void setR25_other_borrow(BigDecimal r25_other_borrow) {
		this.r25_other_borrow = r25_other_borrow;
	}
	public BigDecimal getR25_remani_balance_from() {
		return r25_remani_balance_from;
	}
	public void setR25_remani_balance_from(BigDecimal r25_remani_balance_from) {
		this.r25_remani_balance_from = r25_remani_balance_from;
	}
	public BigDecimal getR25_remani_balance_to() {
		return r25_remani_balance_to;
	}
	public void setR25_remani_balance_to(BigDecimal r25_remani_balance_to) {
		this.r25_remani_balance_to = r25_remani_balance_to;
	}
	public String getR26_product() {
		return r26_product;
	}
	public void setR26_product(String r26_product) {
		this.r26_product = r26_product;
	}
	public BigDecimal getR26_inter_bank_place() {
		return r26_inter_bank_place;
	}
	public void setR26_inter_bank_place(BigDecimal r26_inter_bank_place) {
		this.r26_inter_bank_place = r26_inter_bank_place;
	}
	public BigDecimal getR26_inter_bank_borrow() {
		return r26_inter_bank_borrow;
	}
	public void setR26_inter_bank_borrow(BigDecimal r26_inter_bank_borrow) {
		this.r26_inter_bank_borrow = r26_inter_bank_borrow;
	}
	public BigDecimal getR26_other_placement() {
		return r26_other_placement;
	}
	public void setR26_other_placement(BigDecimal r26_other_placement) {
		this.r26_other_placement = r26_other_placement;
	}
	public BigDecimal getR26_other_borrow() {
		return r26_other_borrow;
	}
	public void setR26_other_borrow(BigDecimal r26_other_borrow) {
		this.r26_other_borrow = r26_other_borrow;
	}
	public BigDecimal getR26_remani_balance_from() {
		return r26_remani_balance_from;
	}
	public void setR26_remani_balance_from(BigDecimal r26_remani_balance_from) {
		this.r26_remani_balance_from = r26_remani_balance_from;
	}
	public BigDecimal getR26_remani_balance_to() {
		return r26_remani_balance_to;
	}
	public void setR26_remani_balance_to(BigDecimal r26_remani_balance_to) {
		this.r26_remani_balance_to = r26_remani_balance_to;
	}
	public String getR27_product() {
		return r27_product;
	}
	public void setR27_product(String r27_product) {
		this.r27_product = r27_product;
	}
	public BigDecimal getR27_inter_bank_place() {
		return r27_inter_bank_place;
	}
	public void setR27_inter_bank_place(BigDecimal r27_inter_bank_place) {
		this.r27_inter_bank_place = r27_inter_bank_place;
	}
	public BigDecimal getR27_inter_bank_borrow() {
		return r27_inter_bank_borrow;
	}
	public void setR27_inter_bank_borrow(BigDecimal r27_inter_bank_borrow) {
		this.r27_inter_bank_borrow = r27_inter_bank_borrow;
	}
	public BigDecimal getR27_other_placement() {
		return r27_other_placement;
	}
	public void setR27_other_placement(BigDecimal r27_other_placement) {
		this.r27_other_placement = r27_other_placement;
	}
	public BigDecimal getR27_other_borrow() {
		return r27_other_borrow;
	}
	public void setR27_other_borrow(BigDecimal r27_other_borrow) {
		this.r27_other_borrow = r27_other_borrow;
	}
	public BigDecimal getR27_remani_balance_from() {
		return r27_remani_balance_from;
	}
	public void setR27_remani_balance_from(BigDecimal r27_remani_balance_from) {
		this.r27_remani_balance_from = r27_remani_balance_from;
	}
	public BigDecimal getR27_remani_balance_to() {
		return r27_remani_balance_to;
	}
	public void setR27_remani_balance_to(BigDecimal r27_remani_balance_to) {
		this.r27_remani_balance_to = r27_remani_balance_to;
	}
	public String getR28_product() {
		return r28_product;
	}
	public void setR28_product(String r28_product) {
		this.r28_product = r28_product;
	}
	public BigDecimal getR28_inter_bank_place() {
		return r28_inter_bank_place;
	}
	public void setR28_inter_bank_place(BigDecimal r28_inter_bank_place) {
		this.r28_inter_bank_place = r28_inter_bank_place;
	}
	public BigDecimal getR28_inter_bank_borrow() {
		return r28_inter_bank_borrow;
	}
	public void setR28_inter_bank_borrow(BigDecimal r28_inter_bank_borrow) {
		this.r28_inter_bank_borrow = r28_inter_bank_borrow;
	}
	public BigDecimal getR28_other_placement() {
		return r28_other_placement;
	}
	public void setR28_other_placement(BigDecimal r28_other_placement) {
		this.r28_other_placement = r28_other_placement;
	}
	public BigDecimal getR28_other_borrow() {
		return r28_other_borrow;
	}
	public void setR28_other_borrow(BigDecimal r28_other_borrow) {
		this.r28_other_borrow = r28_other_borrow;
	}
	public BigDecimal getR28_remani_balance_from() {
		return r28_remani_balance_from;
	}
	public void setR28_remani_balance_from(BigDecimal r28_remani_balance_from) {
		this.r28_remani_balance_from = r28_remani_balance_from;
	}
	public BigDecimal getR28_remani_balance_to() {
		return r28_remani_balance_to;
	}
	public void setR28_remani_balance_to(BigDecimal r28_remani_balance_to) {
		this.r28_remani_balance_to = r28_remani_balance_to;
	}
	public String getR29_product() {
		return r29_product;
	}
	public void setR29_product(String r29_product) {
		this.r29_product = r29_product;
	}
	public BigDecimal getR29_inter_bank_place() {
		return r29_inter_bank_place;
	}
	public void setR29_inter_bank_place(BigDecimal r29_inter_bank_place) {
		this.r29_inter_bank_place = r29_inter_bank_place;
	}
	public BigDecimal getR29_inter_bank_borrow() {
		return r29_inter_bank_borrow;
	}
	public void setR29_inter_bank_borrow(BigDecimal r29_inter_bank_borrow) {
		this.r29_inter_bank_borrow = r29_inter_bank_borrow;
	}
	public BigDecimal getR29_other_placement() {
		return r29_other_placement;
	}
	public void setR29_other_placement(BigDecimal r29_other_placement) {
		this.r29_other_placement = r29_other_placement;
	}
	public BigDecimal getR29_other_borrow() {
		return r29_other_borrow;
	}
	public void setR29_other_borrow(BigDecimal r29_other_borrow) {
		this.r29_other_borrow = r29_other_borrow;
	}
	public BigDecimal getR29_remani_balance_from() {
		return r29_remani_balance_from;
	}
	public void setR29_remani_balance_from(BigDecimal r29_remani_balance_from) {
		this.r29_remani_balance_from = r29_remani_balance_from;
	}
	public BigDecimal getR29_remani_balance_to() {
		return r29_remani_balance_to;
	}
	public void setR29_remani_balance_to(BigDecimal r29_remani_balance_to) {
		this.r29_remani_balance_to = r29_remani_balance_to;
	}
	public String getR30_product() {
		return r30_product;
	}
	public void setR30_product(String r30_product) {
		this.r30_product = r30_product;
	}
	public BigDecimal getR30_inter_bank_place() {
		return r30_inter_bank_place;
	}
	public void setR30_inter_bank_place(BigDecimal r30_inter_bank_place) {
		this.r30_inter_bank_place = r30_inter_bank_place;
	}
	public BigDecimal getR30_inter_bank_borrow() {
		return r30_inter_bank_borrow;
	}
	public void setR30_inter_bank_borrow(BigDecimal r30_inter_bank_borrow) {
		this.r30_inter_bank_borrow = r30_inter_bank_borrow;
	}
	public BigDecimal getR30_other_placement() {
		return r30_other_placement;
	}
	public void setR30_other_placement(BigDecimal r30_other_placement) {
		this.r30_other_placement = r30_other_placement;
	}
	public BigDecimal getR30_other_borrow() {
		return r30_other_borrow;
	}
	public void setR30_other_borrow(BigDecimal r30_other_borrow) {
		this.r30_other_borrow = r30_other_borrow;
	}
	public BigDecimal getR30_remani_balance_from() {
		return r30_remani_balance_from;
	}
	public void setR30_remani_balance_from(BigDecimal r30_remani_balance_from) {
		this.r30_remani_balance_from = r30_remani_balance_from;
	}
	public BigDecimal getR30_remani_balance_to() {
		return r30_remani_balance_to;
	}
	public void setR30_remani_balance_to(BigDecimal r30_remani_balance_to) {
		this.r30_remani_balance_to = r30_remani_balance_to;
	}
	public String getR31_product() {
		return r31_product;
	}
	public void setR31_product(String r31_product) {
		this.r31_product = r31_product;
	}
	public BigDecimal getR31_inter_bank_place() {
		return r31_inter_bank_place;
	}
	public void setR31_inter_bank_place(BigDecimal r31_inter_bank_place) {
		this.r31_inter_bank_place = r31_inter_bank_place;
	}
	public BigDecimal getR31_inter_bank_borrow() {
		return r31_inter_bank_borrow;
	}
	public void setR31_inter_bank_borrow(BigDecimal r31_inter_bank_borrow) {
		this.r31_inter_bank_borrow = r31_inter_bank_borrow;
	}
	public BigDecimal getR31_other_placement() {
		return r31_other_placement;
	}
	public void setR31_other_placement(BigDecimal r31_other_placement) {
		this.r31_other_placement = r31_other_placement;
	}
	public BigDecimal getR31_other_borrow() {
		return r31_other_borrow;
	}
	public void setR31_other_borrow(BigDecimal r31_other_borrow) {
		this.r31_other_borrow = r31_other_borrow;
	}
	public BigDecimal getR31_remani_balance_from() {
		return r31_remani_balance_from;
	}
	public void setR31_remani_balance_from(BigDecimal r31_remani_balance_from) {
		this.r31_remani_balance_from = r31_remani_balance_from;
	}
	public BigDecimal getR31_remani_balance_to() {
		return r31_remani_balance_to;
	}
	public void setR31_remani_balance_to(BigDecimal r31_remani_balance_to) {
		this.r31_remani_balance_to = r31_remani_balance_to;
	}
	public String getR32_product() {
		return r32_product;
	}
	public void setR32_product(String r32_product) {
		this.r32_product = r32_product;
	}
	public BigDecimal getR32_inter_bank_place() {
		return r32_inter_bank_place;
	}
	public void setR32_inter_bank_place(BigDecimal r32_inter_bank_place) {
		this.r32_inter_bank_place = r32_inter_bank_place;
	}
	public BigDecimal getR32_inter_bank_borrow() {
		return r32_inter_bank_borrow;
	}
	public void setR32_inter_bank_borrow(BigDecimal r32_inter_bank_borrow) {
		this.r32_inter_bank_borrow = r32_inter_bank_borrow;
	}
	public BigDecimal getR32_other_placement() {
		return r32_other_placement;
	}
	public void setR32_other_placement(BigDecimal r32_other_placement) {
		this.r32_other_placement = r32_other_placement;
	}
	public BigDecimal getR32_other_borrow() {
		return r32_other_borrow;
	}
	public void setR32_other_borrow(BigDecimal r32_other_borrow) {
		this.r32_other_borrow = r32_other_borrow;
	}
	public BigDecimal getR32_remani_balance_from() {
		return r32_remani_balance_from;
	}
	public void setR32_remani_balance_from(BigDecimal r32_remani_balance_from) {
		this.r32_remani_balance_from = r32_remani_balance_from;
	}
	public BigDecimal getR32_remani_balance_to() {
		return r32_remani_balance_to;
	}
	public void setR32_remani_balance_to(BigDecimal r32_remani_balance_to) {
		this.r32_remani_balance_to = r32_remani_balance_to;
	}
	public String getR33_product() {
		return r33_product;
	}
	public void setR33_product(String r33_product) {
		this.r33_product = r33_product;
	}
	public BigDecimal getR33_inter_bank_place() {
		return r33_inter_bank_place;
	}
	public void setR33_inter_bank_place(BigDecimal r33_inter_bank_place) {
		this.r33_inter_bank_place = r33_inter_bank_place;
	}
	public BigDecimal getR33_inter_bank_borrow() {
		return r33_inter_bank_borrow;
	}
	public void setR33_inter_bank_borrow(BigDecimal r33_inter_bank_borrow) {
		this.r33_inter_bank_borrow = r33_inter_bank_borrow;
	}
	public BigDecimal getR33_other_placement() {
		return r33_other_placement;
	}
	public void setR33_other_placement(BigDecimal r33_other_placement) {
		this.r33_other_placement = r33_other_placement;
	}
	public BigDecimal getR33_other_borrow() {
		return r33_other_borrow;
	}
	public void setR33_other_borrow(BigDecimal r33_other_borrow) {
		this.r33_other_borrow = r33_other_borrow;
	}
	public BigDecimal getR33_remani_balance_from() {
		return r33_remani_balance_from;
	}
	public void setR33_remani_balance_from(BigDecimal r33_remani_balance_from) {
		this.r33_remani_balance_from = r33_remani_balance_from;
	}
	public BigDecimal getR33_remani_balance_to() {
		return r33_remani_balance_to;
	}
	public void setR33_remani_balance_to(BigDecimal r33_remani_balance_to) {
		this.r33_remani_balance_to = r33_remani_balance_to;
	}
	public String getR34_product() {
		return r34_product;
	}
	public void setR34_product(String r34_product) {
		this.r34_product = r34_product;
	}
	public BigDecimal getR34_inter_bank_place() {
		return r34_inter_bank_place;
	}
	public void setR34_inter_bank_place(BigDecimal r34_inter_bank_place) {
		this.r34_inter_bank_place = r34_inter_bank_place;
	}
	public BigDecimal getR34_inter_bank_borrow() {
		return r34_inter_bank_borrow;
	}
	public void setR34_inter_bank_borrow(BigDecimal r34_inter_bank_borrow) {
		this.r34_inter_bank_borrow = r34_inter_bank_borrow;
	}
	public BigDecimal getR34_other_placement() {
		return r34_other_placement;
	}
	public void setR34_other_placement(BigDecimal r34_other_placement) {
		this.r34_other_placement = r34_other_placement;
	}
	public BigDecimal getR34_other_borrow() {
		return r34_other_borrow;
	}
	public void setR34_other_borrow(BigDecimal r34_other_borrow) {
		this.r34_other_borrow = r34_other_borrow;
	}
	public BigDecimal getR34_remani_balance_from() {
		return r34_remani_balance_from;
	}
	public void setR34_remani_balance_from(BigDecimal r34_remani_balance_from) {
		this.r34_remani_balance_from = r34_remani_balance_from;
	}
	public BigDecimal getR34_remani_balance_to() {
		return r34_remani_balance_to;
	}
	public void setR34_remani_balance_to(BigDecimal r34_remani_balance_to) {
		this.r34_remani_balance_to = r34_remani_balance_to;
	}
	public String getR35_product() {
		return r35_product;
	}
	public void setR35_product(String r35_product) {
		this.r35_product = r35_product;
	}
	public BigDecimal getR35_inter_bank_place() {
		return r35_inter_bank_place;
	}
	public void setR35_inter_bank_place(BigDecimal r35_inter_bank_place) {
		this.r35_inter_bank_place = r35_inter_bank_place;
	}
	public BigDecimal getR35_inter_bank_borrow() {
		return r35_inter_bank_borrow;
	}
	public void setR35_inter_bank_borrow(BigDecimal r35_inter_bank_borrow) {
		this.r35_inter_bank_borrow = r35_inter_bank_borrow;
	}
	public BigDecimal getR35_other_placement() {
		return r35_other_placement;
	}
	public void setR35_other_placement(BigDecimal r35_other_placement) {
		this.r35_other_placement = r35_other_placement;
	}
	public BigDecimal getR35_other_borrow() {
		return r35_other_borrow;
	}
	public void setR35_other_borrow(BigDecimal r35_other_borrow) {
		this.r35_other_borrow = r35_other_borrow;
	}
	public BigDecimal getR35_remani_balance_from() {
		return r35_remani_balance_from;
	}
	public void setR35_remani_balance_from(BigDecimal r35_remani_balance_from) {
		this.r35_remani_balance_from = r35_remani_balance_from;
	}
	public BigDecimal getR35_remani_balance_to() {
		return r35_remani_balance_to;
	}
	public void setR35_remani_balance_to(BigDecimal r35_remani_balance_to) {
		this.r35_remani_balance_to = r35_remani_balance_to;
	}
	public String getR36_product() {
		return r36_product;
	}
	public void setR36_product(String r36_product) {
		this.r36_product = r36_product;
	}
	public BigDecimal getR36_inter_bank_place() {
		return r36_inter_bank_place;
	}
	public void setR36_inter_bank_place(BigDecimal r36_inter_bank_place) {
		this.r36_inter_bank_place = r36_inter_bank_place;
	}
	public BigDecimal getR36_inter_bank_borrow() {
		return r36_inter_bank_borrow;
	}
	public void setR36_inter_bank_borrow(BigDecimal r36_inter_bank_borrow) {
		this.r36_inter_bank_borrow = r36_inter_bank_borrow;
	}
	public BigDecimal getR36_other_placement() {
		return r36_other_placement;
	}
	public void setR36_other_placement(BigDecimal r36_other_placement) {
		this.r36_other_placement = r36_other_placement;
	}
	public BigDecimal getR36_other_borrow() {
		return r36_other_borrow;
	}
	public void setR36_other_borrow(BigDecimal r36_other_borrow) {
		this.r36_other_borrow = r36_other_borrow;
	}
	public BigDecimal getR36_remani_balance_from() {
		return r36_remani_balance_from;
	}
	public void setR36_remani_balance_from(BigDecimal r36_remani_balance_from) {
		this.r36_remani_balance_from = r36_remani_balance_from;
	}
	public BigDecimal getR36_remani_balance_to() {
		return r36_remani_balance_to;
	}
	public void setR36_remani_balance_to(BigDecimal r36_remani_balance_to) {
		this.r36_remani_balance_to = r36_remani_balance_to;
	}
	public String getRh2_product() {
		return rh2_product;
	}
	public void setRh2_product(String rh2_product) {
		this.rh2_product = rh2_product;
	}
	public BigDecimal getRh2_inter_bank_place() {
		return rh2_inter_bank_place;
	}
	public void setRh2_inter_bank_place(BigDecimal rh2_inter_bank_place) {
		this.rh2_inter_bank_place = rh2_inter_bank_place;
	}
	public BigDecimal getRh2_inter_bank_borrow() {
		return rh2_inter_bank_borrow;
	}
	public void setRh2_inter_bank_borrow(BigDecimal rh2_inter_bank_borrow) {
		this.rh2_inter_bank_borrow = rh2_inter_bank_borrow;
	}
	public BigDecimal getRh2_other_placement() {
		return rh2_other_placement;
	}
	public void setRh2_other_placement(BigDecimal rh2_other_placement) {
		this.rh2_other_placement = rh2_other_placement;
	}
	public BigDecimal getRh2_other_borrow() {
		return rh2_other_borrow;
	}
	public void setRh2_other_borrow(BigDecimal rh2_other_borrow) {
		this.rh2_other_borrow = rh2_other_borrow;
	}
	public BigDecimal getRh2_remani_balance_from() {
		return rh2_remani_balance_from;
	}
	public void setRh2_remani_balance_from(BigDecimal rh2_remani_balance_from) {
		this.rh2_remani_balance_from = rh2_remani_balance_from;
	}
	public BigDecimal getRh2_remani_balance_to() {
		return rh2_remani_balance_to;
	}
	public void setRh2_remani_balance_to(BigDecimal rh2_remani_balance_to) {
		this.rh2_remani_balance_to = rh2_remani_balance_to;
	}
	public String getR37_product() {
		return r37_product;
	}
	public void setR37_product(String r37_product) {
		this.r37_product = r37_product;
	}
	public BigDecimal getR37_inter_bank_place() {
		return r37_inter_bank_place;
	}
	public void setR37_inter_bank_place(BigDecimal r37_inter_bank_place) {
		this.r37_inter_bank_place = r37_inter_bank_place;
	}
	public BigDecimal getR37_inter_bank_borrow() {
		return r37_inter_bank_borrow;
	}
	public void setR37_inter_bank_borrow(BigDecimal r37_inter_bank_borrow) {
		this.r37_inter_bank_borrow = r37_inter_bank_borrow;
	}
	public BigDecimal getR37_other_placement() {
		return r37_other_placement;
	}
	public void setR37_other_placement(BigDecimal r37_other_placement) {
		this.r37_other_placement = r37_other_placement;
	}
	public BigDecimal getR37_other_borrow() {
		return r37_other_borrow;
	}
	public void setR37_other_borrow(BigDecimal r37_other_borrow) {
		this.r37_other_borrow = r37_other_borrow;
	}
	public BigDecimal getR37_remani_balance_from() {
		return r37_remani_balance_from;
	}
	public void setR37_remani_balance_from(BigDecimal r37_remani_balance_from) {
		this.r37_remani_balance_from = r37_remani_balance_from;
	}
	public BigDecimal getR37_remani_balance_to() {
		return r37_remani_balance_to;
	}
	public void setR37_remani_balance_to(BigDecimal r37_remani_balance_to) {
		this.r37_remani_balance_to = r37_remani_balance_to;
	}
	public String getR38_product() {
		return r38_product;
	}
	public void setR38_product(String r38_product) {
		this.r38_product = r38_product;
	}
	public BigDecimal getR38_inter_bank_place() {
		return r38_inter_bank_place;
	}
	public void setR38_inter_bank_place(BigDecimal r38_inter_bank_place) {
		this.r38_inter_bank_place = r38_inter_bank_place;
	}
	public BigDecimal getR38_inter_bank_borrow() {
		return r38_inter_bank_borrow;
	}
	public void setR38_inter_bank_borrow(BigDecimal r38_inter_bank_borrow) {
		this.r38_inter_bank_borrow = r38_inter_bank_borrow;
	}
	public BigDecimal getR38_other_placement() {
		return r38_other_placement;
	}
	public void setR38_other_placement(BigDecimal r38_other_placement) {
		this.r38_other_placement = r38_other_placement;
	}
	public BigDecimal getR38_other_borrow() {
		return r38_other_borrow;
	}
	public void setR38_other_borrow(BigDecimal r38_other_borrow) {
		this.r38_other_borrow = r38_other_borrow;
	}
	public BigDecimal getR38_remani_balance_from() {
		return r38_remani_balance_from;
	}
	public void setR38_remani_balance_from(BigDecimal r38_remani_balance_from) {
		this.r38_remani_balance_from = r38_remani_balance_from;
	}
	public BigDecimal getR38_remani_balance_to() {
		return r38_remani_balance_to;
	}
	public void setR38_remani_balance_to(BigDecimal r38_remani_balance_to) {
		this.r38_remani_balance_to = r38_remani_balance_to;
	}
	public String getR39_product() {
		return r39_product;
	}
	public void setR39_product(String r39_product) {
		this.r39_product = r39_product;
	}
	public BigDecimal getR39_inter_bank_place() {
		return r39_inter_bank_place;
	}
	public void setR39_inter_bank_place(BigDecimal r39_inter_bank_place) {
		this.r39_inter_bank_place = r39_inter_bank_place;
	}
	public BigDecimal getR39_inter_bank_borrow() {
		return r39_inter_bank_borrow;
	}
	public void setR39_inter_bank_borrow(BigDecimal r39_inter_bank_borrow) {
		this.r39_inter_bank_borrow = r39_inter_bank_borrow;
	}
	public BigDecimal getR39_other_placement() {
		return r39_other_placement;
	}
	public void setR39_other_placement(BigDecimal r39_other_placement) {
		this.r39_other_placement = r39_other_placement;
	}
	public BigDecimal getR39_other_borrow() {
		return r39_other_borrow;
	}
	public void setR39_other_borrow(BigDecimal r39_other_borrow) {
		this.r39_other_borrow = r39_other_borrow;
	}
	public BigDecimal getR39_remani_balance_from() {
		return r39_remani_balance_from;
	}
	public void setR39_remani_balance_from(BigDecimal r39_remani_balance_from) {
		this.r39_remani_balance_from = r39_remani_balance_from;
	}
	public BigDecimal getR39_remani_balance_to() {
		return r39_remani_balance_to;
	}
	public void setR39_remani_balance_to(BigDecimal r39_remani_balance_to) {
		this.r39_remani_balance_to = r39_remani_balance_to;
	}
	public String getR40_product() {
		return r40_product;
	}
	public void setR40_product(String r40_product) {
		this.r40_product = r40_product;
	}
	public BigDecimal getR40_inter_bank_place() {
		return r40_inter_bank_place;
	}
	public void setR40_inter_bank_place(BigDecimal r40_inter_bank_place) {
		this.r40_inter_bank_place = r40_inter_bank_place;
	}
	public BigDecimal getR40_inter_bank_borrow() {
		return r40_inter_bank_borrow;
	}
	public void setR40_inter_bank_borrow(BigDecimal r40_inter_bank_borrow) {
		this.r40_inter_bank_borrow = r40_inter_bank_borrow;
	}
	public BigDecimal getR40_other_placement() {
		return r40_other_placement;
	}
	public void setR40_other_placement(BigDecimal r40_other_placement) {
		this.r40_other_placement = r40_other_placement;
	}
	public BigDecimal getR40_other_borrow() {
		return r40_other_borrow;
	}
	public void setR40_other_borrow(BigDecimal r40_other_borrow) {
		this.r40_other_borrow = r40_other_borrow;
	}
	public BigDecimal getR40_remani_balance_from() {
		return r40_remani_balance_from;
	}
	public void setR40_remani_balance_from(BigDecimal r40_remani_balance_from) {
		this.r40_remani_balance_from = r40_remani_balance_from;
	}
	public BigDecimal getR40_remani_balance_to() {
		return r40_remani_balance_to;
	}
	public void setR40_remani_balance_to(BigDecimal r40_remani_balance_to) {
		this.r40_remani_balance_to = r40_remani_balance_to;
	}
	public String getR41_product() {
		return r41_product;
	}
	public void setR41_product(String r41_product) {
		this.r41_product = r41_product;
	}
	public BigDecimal getR41_inter_bank_place() {
		return r41_inter_bank_place;
	}
	public void setR41_inter_bank_place(BigDecimal r41_inter_bank_place) {
		this.r41_inter_bank_place = r41_inter_bank_place;
	}
	public BigDecimal getR41_inter_bank_borrow() {
		return r41_inter_bank_borrow;
	}
	public void setR41_inter_bank_borrow(BigDecimal r41_inter_bank_borrow) {
		this.r41_inter_bank_borrow = r41_inter_bank_borrow;
	}
	public BigDecimal getR41_other_placement() {
		return r41_other_placement;
	}
	public void setR41_other_placement(BigDecimal r41_other_placement) {
		this.r41_other_placement = r41_other_placement;
	}
	public BigDecimal getR41_other_borrow() {
		return r41_other_borrow;
	}
	public void setR41_other_borrow(BigDecimal r41_other_borrow) {
		this.r41_other_borrow = r41_other_borrow;
	}
	public BigDecimal getR41_remani_balance_from() {
		return r41_remani_balance_from;
	}
	public void setR41_remani_balance_from(BigDecimal r41_remani_balance_from) {
		this.r41_remani_balance_from = r41_remani_balance_from;
	}
	public BigDecimal getR41_remani_balance_to() {
		return r41_remani_balance_to;
	}
	public void setR41_remani_balance_to(BigDecimal r41_remani_balance_to) {
		this.r41_remani_balance_to = r41_remani_balance_to;
	}
	public String getR42_product() {
		return r42_product;
	}
	public void setR42_product(String r42_product) {
		this.r42_product = r42_product;
	}
	public BigDecimal getR42_inter_bank_place() {
		return r42_inter_bank_place;
	}
	public void setR42_inter_bank_place(BigDecimal r42_inter_bank_place) {
		this.r42_inter_bank_place = r42_inter_bank_place;
	}
	public BigDecimal getR42_inter_bank_borrow() {
		return r42_inter_bank_borrow;
	}
	public void setR42_inter_bank_borrow(BigDecimal r42_inter_bank_borrow) {
		this.r42_inter_bank_borrow = r42_inter_bank_borrow;
	}
	public BigDecimal getR42_other_placement() {
		return r42_other_placement;
	}
	public void setR42_other_placement(BigDecimal r42_other_placement) {
		this.r42_other_placement = r42_other_placement;
	}
	public BigDecimal getR42_other_borrow() {
		return r42_other_borrow;
	}
	public void setR42_other_borrow(BigDecimal r42_other_borrow) {
		this.r42_other_borrow = r42_other_borrow;
	}
	public BigDecimal getR42_remani_balance_from() {
		return r42_remani_balance_from;
	}
	public void setR42_remani_balance_from(BigDecimal r42_remani_balance_from) {
		this.r42_remani_balance_from = r42_remani_balance_from;
	}
	public BigDecimal getR42_remani_balance_to() {
		return r42_remani_balance_to;
	}
	public void setR42_remani_balance_to(BigDecimal r42_remani_balance_to) {
		this.r42_remani_balance_to = r42_remani_balance_to;
	}
	public String getR43_product() {
		return r43_product;
	}
	public void setR43_product(String r43_product) {
		this.r43_product = r43_product;
	}
	public BigDecimal getR43_inter_bank_place() {
		return r43_inter_bank_place;
	}
	public void setR43_inter_bank_place(BigDecimal r43_inter_bank_place) {
		this.r43_inter_bank_place = r43_inter_bank_place;
	}
	public BigDecimal getR43_inter_bank_borrow() {
		return r43_inter_bank_borrow;
	}
	public void setR43_inter_bank_borrow(BigDecimal r43_inter_bank_borrow) {
		this.r43_inter_bank_borrow = r43_inter_bank_borrow;
	}
	public BigDecimal getR43_other_placement() {
		return r43_other_placement;
	}
	public void setR43_other_placement(BigDecimal r43_other_placement) {
		this.r43_other_placement = r43_other_placement;
	}
	public BigDecimal getR43_other_borrow() {
		return r43_other_borrow;
	}
	public void setR43_other_borrow(BigDecimal r43_other_borrow) {
		this.r43_other_borrow = r43_other_borrow;
	}
	public BigDecimal getR43_remani_balance_from() {
		return r43_remani_balance_from;
	}
	public void setR43_remani_balance_from(BigDecimal r43_remani_balance_from) {
		this.r43_remani_balance_from = r43_remani_balance_from;
	}
	public BigDecimal getR43_remani_balance_to() {
		return r43_remani_balance_to;
	}
	public void setR43_remani_balance_to(BigDecimal r43_remani_balance_to) {
		this.r43_remani_balance_to = r43_remani_balance_to;
	}
	public String getRh3_product() {
		return rh3_product;
	}
	public void setRh3_product(String rh3_product) {
		this.rh3_product = rh3_product;
	}
	public BigDecimal getRh3_inter_bank_place() {
		return rh3_inter_bank_place;
	}
	public void setRh3_inter_bank_place(BigDecimal rh3_inter_bank_place) {
		this.rh3_inter_bank_place = rh3_inter_bank_place;
	}
	public BigDecimal getRh3_inter_bank_borrow() {
		return rh3_inter_bank_borrow;
	}
	public void setRh3_inter_bank_borrow(BigDecimal rh3_inter_bank_borrow) {
		this.rh3_inter_bank_borrow = rh3_inter_bank_borrow;
	}
	public BigDecimal getRh3_other_placement() {
		return rh3_other_placement;
	}
	public void setRh3_other_placement(BigDecimal rh3_other_placement) {
		this.rh3_other_placement = rh3_other_placement;
	}
	public BigDecimal getRh3_other_borrow() {
		return rh3_other_borrow;
	}
	public void setRh3_other_borrow(BigDecimal rh3_other_borrow) {
		this.rh3_other_borrow = rh3_other_borrow;
	}
	public BigDecimal getRh3_remani_balance_from() {
		return rh3_remani_balance_from;
	}
	public void setRh3_remani_balance_from(BigDecimal rh3_remani_balance_from) {
		this.rh3_remani_balance_from = rh3_remani_balance_from;
	}
	public BigDecimal getRh3_remani_balance_to() {
		return rh3_remani_balance_to;
	}
	public void setRh3_remani_balance_to(BigDecimal rh3_remani_balance_to) {
		this.rh3_remani_balance_to = rh3_remani_balance_to;
	}
	public String getR44_product() {
		return r44_product;
	}
	public void setR44_product(String r44_product) {
		this.r44_product = r44_product;
	}
	public BigDecimal getR44_inter_bank_place() {
		return r44_inter_bank_place;
	}
	public void setR44_inter_bank_place(BigDecimal r44_inter_bank_place) {
		this.r44_inter_bank_place = r44_inter_bank_place;
	}
	public BigDecimal getR44_inter_bank_borrow() {
		return r44_inter_bank_borrow;
	}
	public void setR44_inter_bank_borrow(BigDecimal r44_inter_bank_borrow) {
		this.r44_inter_bank_borrow = r44_inter_bank_borrow;
	}
	public BigDecimal getR44_other_placement() {
		return r44_other_placement;
	}
	public void setR44_other_placement(BigDecimal r44_other_placement) {
		this.r44_other_placement = r44_other_placement;
	}
	public BigDecimal getR44_other_borrow() {
		return r44_other_borrow;
	}
	public void setR44_other_borrow(BigDecimal r44_other_borrow) {
		this.r44_other_borrow = r44_other_borrow;
	}
	public BigDecimal getR44_remani_balance_from() {
		return r44_remani_balance_from;
	}
	public void setR44_remani_balance_from(BigDecimal r44_remani_balance_from) {
		this.r44_remani_balance_from = r44_remani_balance_from;
	}
	public BigDecimal getR44_remani_balance_to() {
		return r44_remani_balance_to;
	}
	public void setR44_remani_balance_to(BigDecimal r44_remani_balance_to) {
		this.r44_remani_balance_to = r44_remani_balance_to;
	}
	public String getR45_product() {
		return r45_product;
	}
	public void setR45_product(String r45_product) {
		this.r45_product = r45_product;
	}
	public BigDecimal getR45_inter_bank_place() {
		return r45_inter_bank_place;
	}
	public void setR45_inter_bank_place(BigDecimal r45_inter_bank_place) {
		this.r45_inter_bank_place = r45_inter_bank_place;
	}
	public BigDecimal getR45_inter_bank_borrow() {
		return r45_inter_bank_borrow;
	}
	public void setR45_inter_bank_borrow(BigDecimal r45_inter_bank_borrow) {
		this.r45_inter_bank_borrow = r45_inter_bank_borrow;
	}
	public BigDecimal getR45_other_placement() {
		return r45_other_placement;
	}
	public void setR45_other_placement(BigDecimal r45_other_placement) {
		this.r45_other_placement = r45_other_placement;
	}
	public BigDecimal getR45_other_borrow() {
		return r45_other_borrow;
	}
	public void setR45_other_borrow(BigDecimal r45_other_borrow) {
		this.r45_other_borrow = r45_other_borrow;
	}
	public BigDecimal getR45_remani_balance_from() {
		return r45_remani_balance_from;
	}
	public void setR45_remani_balance_from(BigDecimal r45_remani_balance_from) {
		this.r45_remani_balance_from = r45_remani_balance_from;
	}
	public BigDecimal getR45_remani_balance_to() {
		return r45_remani_balance_to;
	}
	public void setR45_remani_balance_to(BigDecimal r45_remani_balance_to) {
		this.r45_remani_balance_to = r45_remani_balance_to;
	}
	public String getR46_product() {
		return r46_product;
	}
	public void setR46_product(String r46_product) {
		this.r46_product = r46_product;
	}
	public BigDecimal getR46_inter_bank_place() {
		return r46_inter_bank_place;
	}
	public void setR46_inter_bank_place(BigDecimal r46_inter_bank_place) {
		this.r46_inter_bank_place = r46_inter_bank_place;
	}
	public BigDecimal getR46_inter_bank_borrow() {
		return r46_inter_bank_borrow;
	}
	public void setR46_inter_bank_borrow(BigDecimal r46_inter_bank_borrow) {
		this.r46_inter_bank_borrow = r46_inter_bank_borrow;
	}
	public BigDecimal getR46_other_placement() {
		return r46_other_placement;
	}
	public void setR46_other_placement(BigDecimal r46_other_placement) {
		this.r46_other_placement = r46_other_placement;
	}
	public BigDecimal getR46_other_borrow() {
		return r46_other_borrow;
	}
	public void setR46_other_borrow(BigDecimal r46_other_borrow) {
		this.r46_other_borrow = r46_other_borrow;
	}
	public BigDecimal getR46_remani_balance_from() {
		return r46_remani_balance_from;
	}
	public void setR46_remani_balance_from(BigDecimal r46_remani_balance_from) {
		this.r46_remani_balance_from = r46_remani_balance_from;
	}
	public BigDecimal getR46_remani_balance_to() {
		return r46_remani_balance_to;
	}
	public void setR46_remani_balance_to(BigDecimal r46_remani_balance_to) {
		this.r46_remani_balance_to = r46_remani_balance_to;
	}
	public String getR47_product() {
		return r47_product;
	}
	public void setR47_product(String r47_product) {
		this.r47_product = r47_product;
	}
	public BigDecimal getR47_inter_bank_place() {
		return r47_inter_bank_place;
	}
	public void setR47_inter_bank_place(BigDecimal r47_inter_bank_place) {
		this.r47_inter_bank_place = r47_inter_bank_place;
	}
	public BigDecimal getR47_inter_bank_borrow() {
		return r47_inter_bank_borrow;
	}
	public void setR47_inter_bank_borrow(BigDecimal r47_inter_bank_borrow) {
		this.r47_inter_bank_borrow = r47_inter_bank_borrow;
	}
	public BigDecimal getR47_other_placement() {
		return r47_other_placement;
	}
	public void setR47_other_placement(BigDecimal r47_other_placement) {
		this.r47_other_placement = r47_other_placement;
	}
	public BigDecimal getR47_other_borrow() {
		return r47_other_borrow;
	}
	public void setR47_other_borrow(BigDecimal r47_other_borrow) {
		this.r47_other_borrow = r47_other_borrow;
	}
	public BigDecimal getR47_remani_balance_from() {
		return r47_remani_balance_from;
	}
	public void setR47_remani_balance_from(BigDecimal r47_remani_balance_from) {
		this.r47_remani_balance_from = r47_remani_balance_from;
	}
	public BigDecimal getR47_remani_balance_to() {
		return r47_remani_balance_to;
	}
	public void setR47_remani_balance_to(BigDecimal r47_remani_balance_to) {
		this.r47_remani_balance_to = r47_remani_balance_to;
	}
	public String getR48_product() {
		return r48_product;
	}
	public void setR48_product(String r48_product) {
		this.r48_product = r48_product;
	}
	public BigDecimal getR48_inter_bank_place() {
		return r48_inter_bank_place;
	}
	public void setR48_inter_bank_place(BigDecimal r48_inter_bank_place) {
		this.r48_inter_bank_place = r48_inter_bank_place;
	}
	public BigDecimal getR48_inter_bank_borrow() {
		return r48_inter_bank_borrow;
	}
	public void setR48_inter_bank_borrow(BigDecimal r48_inter_bank_borrow) {
		this.r48_inter_bank_borrow = r48_inter_bank_borrow;
	}
	public BigDecimal getR48_other_placement() {
		return r48_other_placement;
	}
	public void setR48_other_placement(BigDecimal r48_other_placement) {
		this.r48_other_placement = r48_other_placement;
	}
	public BigDecimal getR48_other_borrow() {
		return r48_other_borrow;
	}
	public void setR48_other_borrow(BigDecimal r48_other_borrow) {
		this.r48_other_borrow = r48_other_borrow;
	}
	public BigDecimal getR48_remani_balance_from() {
		return r48_remani_balance_from;
	}
	public void setR48_remani_balance_from(BigDecimal r48_remani_balance_from) {
		this.r48_remani_balance_from = r48_remani_balance_from;
	}
	public BigDecimal getR48_remani_balance_to() {
		return r48_remani_balance_to;
	}
	public void setR48_remani_balance_to(BigDecimal r48_remani_balance_to) {
		this.r48_remani_balance_to = r48_remani_balance_to;
	}
	public String getR49_product() {
		return r49_product;
	}
	public void setR49_product(String r49_product) {
		this.r49_product = r49_product;
	}
	public BigDecimal getR49_inter_bank_place() {
		return r49_inter_bank_place;
	}
	public void setR49_inter_bank_place(BigDecimal r49_inter_bank_place) {
		this.r49_inter_bank_place = r49_inter_bank_place;
	}
	public BigDecimal getR49_inter_bank_borrow() {
		return r49_inter_bank_borrow;
	}
	public void setR49_inter_bank_borrow(BigDecimal r49_inter_bank_borrow) {
		this.r49_inter_bank_borrow = r49_inter_bank_borrow;
	}
	public BigDecimal getR49_other_placement() {
		return r49_other_placement;
	}
	public void setR49_other_placement(BigDecimal r49_other_placement) {
		this.r49_other_placement = r49_other_placement;
	}
	public BigDecimal getR49_other_borrow() {
		return r49_other_borrow;
	}
	public void setR49_other_borrow(BigDecimal r49_other_borrow) {
		this.r49_other_borrow = r49_other_borrow;
	}
	public BigDecimal getR49_remani_balance_from() {
		return r49_remani_balance_from;
	}
	public void setR49_remani_balance_from(BigDecimal r49_remani_balance_from) {
		this.r49_remani_balance_from = r49_remani_balance_from;
	}
	public BigDecimal getR49_remani_balance_to() {
		return r49_remani_balance_to;
	}
	public void setR49_remani_balance_to(BigDecimal r49_remani_balance_to) {
		this.r49_remani_balance_to = r49_remani_balance_to;
	}
	public String getR50_product() {
		return r50_product;
	}
	public void setR50_product(String r50_product) {
		this.r50_product = r50_product;
	}
	public BigDecimal getR50_inter_bank_place() {
		return r50_inter_bank_place;
	}
	public void setR50_inter_bank_place(BigDecimal r50_inter_bank_place) {
		this.r50_inter_bank_place = r50_inter_bank_place;
	}
	public BigDecimal getR50_inter_bank_borrow() {
		return r50_inter_bank_borrow;
	}
	public void setR50_inter_bank_borrow(BigDecimal r50_inter_bank_borrow) {
		this.r50_inter_bank_borrow = r50_inter_bank_borrow;
	}
	public BigDecimal getR50_other_placement() {
		return r50_other_placement;
	}
	public void setR50_other_placement(BigDecimal r50_other_placement) {
		this.r50_other_placement = r50_other_placement;
	}
	public BigDecimal getR50_other_borrow() {
		return r50_other_borrow;
	}
	public void setR50_other_borrow(BigDecimal r50_other_borrow) {
		this.r50_other_borrow = r50_other_borrow;
	}
	public BigDecimal getR50_remani_balance_from() {
		return r50_remani_balance_from;
	}
	public void setR50_remani_balance_from(BigDecimal r50_remani_balance_from) {
		this.r50_remani_balance_from = r50_remani_balance_from;
	}
	public BigDecimal getR50_remani_balance_to() {
		return r50_remani_balance_to;
	}
	public void setR50_remani_balance_to(BigDecimal r50_remani_balance_to) {
		this.r50_remani_balance_to = r50_remani_balance_to;
	}
	public String getR51_product() {
		return r51_product;
	}
	public void setR51_product(String r51_product) {
		this.r51_product = r51_product;
	}
	public BigDecimal getR51_inter_bank_place() {
		return r51_inter_bank_place;
	}
	public void setR51_inter_bank_place(BigDecimal r51_inter_bank_place) {
		this.r51_inter_bank_place = r51_inter_bank_place;
	}
	public BigDecimal getR51_inter_bank_borrow() {
		return r51_inter_bank_borrow;
	}
	public void setR51_inter_bank_borrow(BigDecimal r51_inter_bank_borrow) {
		this.r51_inter_bank_borrow = r51_inter_bank_borrow;
	}
	public BigDecimal getR51_other_placement() {
		return r51_other_placement;
	}
	public void setR51_other_placement(BigDecimal r51_other_placement) {
		this.r51_other_placement = r51_other_placement;
	}
	public BigDecimal getR51_other_borrow() {
		return r51_other_borrow;
	}
	public void setR51_other_borrow(BigDecimal r51_other_borrow) {
		this.r51_other_borrow = r51_other_borrow;
	}
	public BigDecimal getR51_remani_balance_from() {
		return r51_remani_balance_from;
	}
	public void setR51_remani_balance_from(BigDecimal r51_remani_balance_from) {
		this.r51_remani_balance_from = r51_remani_balance_from;
	}
	public BigDecimal getR51_remani_balance_to() {
		return r51_remani_balance_to;
	}
	public void setR51_remani_balance_to(BigDecimal r51_remani_balance_to) {
		this.r51_remani_balance_to = r51_remani_balance_to;
	}
	public String getR52_product() {
		return r52_product;
	}
	public void setR52_product(String r52_product) {
		this.r52_product = r52_product;
	}
	public BigDecimal getR52_inter_bank_place() {
		return r52_inter_bank_place;
	}
	public void setR52_inter_bank_place(BigDecimal r52_inter_bank_place) {
		this.r52_inter_bank_place = r52_inter_bank_place;
	}
	public BigDecimal getR52_inter_bank_borrow() {
		return r52_inter_bank_borrow;
	}
	public void setR52_inter_bank_borrow(BigDecimal r52_inter_bank_borrow) {
		this.r52_inter_bank_borrow = r52_inter_bank_borrow;
	}
	public BigDecimal getR52_other_placement() {
		return r52_other_placement;
	}
	public void setR52_other_placement(BigDecimal r52_other_placement) {
		this.r52_other_placement = r52_other_placement;
	}
	public BigDecimal getR52_other_borrow() {
		return r52_other_borrow;
	}
	public void setR52_other_borrow(BigDecimal r52_other_borrow) {
		this.r52_other_borrow = r52_other_borrow;
	}
	public BigDecimal getR52_remani_balance_from() {
		return r52_remani_balance_from;
	}
	public void setR52_remani_balance_from(BigDecimal r52_remani_balance_from) {
		this.r52_remani_balance_from = r52_remani_balance_from;
	}
	public BigDecimal getR52_remani_balance_to() {
		return r52_remani_balance_to;
	}
	public void setR52_remani_balance_to(BigDecimal r52_remani_balance_to) {
		this.r52_remani_balance_to = r52_remani_balance_to;
	}
	public String getR53_product() {
		return r53_product;
	}
	public void setR53_product(String r53_product) {
		this.r53_product = r53_product;
	}
	public BigDecimal getR53_inter_bank_place() {
		return r53_inter_bank_place;
	}
	public void setR53_inter_bank_place(BigDecimal r53_inter_bank_place) {
		this.r53_inter_bank_place = r53_inter_bank_place;
	}
	public BigDecimal getR53_inter_bank_borrow() {
		return r53_inter_bank_borrow;
	}
	public void setR53_inter_bank_borrow(BigDecimal r53_inter_bank_borrow) {
		this.r53_inter_bank_borrow = r53_inter_bank_borrow;
	}
	public BigDecimal getR53_other_placement() {
		return r53_other_placement;
	}
	public void setR53_other_placement(BigDecimal r53_other_placement) {
		this.r53_other_placement = r53_other_placement;
	}
	public BigDecimal getR53_other_borrow() {
		return r53_other_borrow;
	}
	public void setR53_other_borrow(BigDecimal r53_other_borrow) {
		this.r53_other_borrow = r53_other_borrow;
	}
	public BigDecimal getR53_remani_balance_from() {
		return r53_remani_balance_from;
	}
	public void setR53_remani_balance_from(BigDecimal r53_remani_balance_from) {
		this.r53_remani_balance_from = r53_remani_balance_from;
	}
	public BigDecimal getR53_remani_balance_to() {
		return r53_remani_balance_to;
	}
	public void setR53_remani_balance_to(BigDecimal r53_remani_balance_to) {
		this.r53_remani_balance_to = r53_remani_balance_to;
	}
	public String getR54_product() {
		return r54_product;
	}
	public void setR54_product(String r54_product) {
		this.r54_product = r54_product;
	}
	public BigDecimal getR54_inter_bank_place() {
		return r54_inter_bank_place;
	}
	public void setR54_inter_bank_place(BigDecimal r54_inter_bank_place) {
		this.r54_inter_bank_place = r54_inter_bank_place;
	}
	public BigDecimal getR54_inter_bank_borrow() {
		return r54_inter_bank_borrow;
	}
	public void setR54_inter_bank_borrow(BigDecimal r54_inter_bank_borrow) {
		this.r54_inter_bank_borrow = r54_inter_bank_borrow;
	}
	public BigDecimal getR54_other_placement() {
		return r54_other_placement;
	}
	public void setR54_other_placement(BigDecimal r54_other_placement) {
		this.r54_other_placement = r54_other_placement;
	}
	public BigDecimal getR54_other_borrow() {
		return r54_other_borrow;
	}
	public void setR54_other_borrow(BigDecimal r54_other_borrow) {
		this.r54_other_borrow = r54_other_borrow;
	}
	public BigDecimal getR54_remani_balance_from() {
		return r54_remani_balance_from;
	}
	public void setR54_remani_balance_from(BigDecimal r54_remani_balance_from) {
		this.r54_remani_balance_from = r54_remani_balance_from;
	}
	public BigDecimal getR54_remani_balance_to() {
		return r54_remani_balance_to;
	}
	public void setR54_remani_balance_to(BigDecimal r54_remani_balance_to) {
		this.r54_remani_balance_to = r54_remani_balance_to;
	}
	public String getR55_product() {
		return r55_product;
	}
	public void setR55_product(String r55_product) {
		this.r55_product = r55_product;
	}
	public BigDecimal getR55_inter_bank_place() {
		return r55_inter_bank_place;
	}
	public void setR55_inter_bank_place(BigDecimal r55_inter_bank_place) {
		this.r55_inter_bank_place = r55_inter_bank_place;
	}
	public BigDecimal getR55_inter_bank_borrow() {
		return r55_inter_bank_borrow;
	}
	public void setR55_inter_bank_borrow(BigDecimal r55_inter_bank_borrow) {
		this.r55_inter_bank_borrow = r55_inter_bank_borrow;
	}
	public BigDecimal getR55_other_placement() {
		return r55_other_placement;
	}
	public void setR55_other_placement(BigDecimal r55_other_placement) {
		this.r55_other_placement = r55_other_placement;
	}
	public BigDecimal getR55_other_borrow() {
		return r55_other_borrow;
	}
	public void setR55_other_borrow(BigDecimal r55_other_borrow) {
		this.r55_other_borrow = r55_other_borrow;
	}
	public BigDecimal getR55_remani_balance_from() {
		return r55_remani_balance_from;
	}
	public void setR55_remani_balance_from(BigDecimal r55_remani_balance_from) {
		this.r55_remani_balance_from = r55_remani_balance_from;
	}
	public BigDecimal getR55_remani_balance_to() {
		return r55_remani_balance_to;
	}
	public void setR55_remani_balance_to(BigDecimal r55_remani_balance_to) {
		this.r55_remani_balance_to = r55_remani_balance_to;
	}
	public String getR56_product() {
		return r56_product;
	}
	public void setR56_product(String r56_product) {
		this.r56_product = r56_product;
	}
	public BigDecimal getR56_inter_bank_place() {
		return r56_inter_bank_place;
	}
	public void setR56_inter_bank_place(BigDecimal r56_inter_bank_place) {
		this.r56_inter_bank_place = r56_inter_bank_place;
	}
	public BigDecimal getR56_inter_bank_borrow() {
		return r56_inter_bank_borrow;
	}
	public void setR56_inter_bank_borrow(BigDecimal r56_inter_bank_borrow) {
		this.r56_inter_bank_borrow = r56_inter_bank_borrow;
	}
	public BigDecimal getR56_other_placement() {
		return r56_other_placement;
	}
	public void setR56_other_placement(BigDecimal r56_other_placement) {
		this.r56_other_placement = r56_other_placement;
	}
	public BigDecimal getR56_other_borrow() {
		return r56_other_borrow;
	}
	public void setR56_other_borrow(BigDecimal r56_other_borrow) {
		this.r56_other_borrow = r56_other_borrow;
	}
	public BigDecimal getR56_remani_balance_from() {
		return r56_remani_balance_from;
	}
	public void setR56_remani_balance_from(BigDecimal r56_remani_balance_from) {
		this.r56_remani_balance_from = r56_remani_balance_from;
	}
	public BigDecimal getR56_remani_balance_to() {
		return r56_remani_balance_to;
	}
	public void setR56_remani_balance_to(BigDecimal r56_remani_balance_to) {
		this.r56_remani_balance_to = r56_remani_balance_to;
	}
	public String getR57_product() {
		return r57_product;
	}
	public void setR57_product(String r57_product) {
		this.r57_product = r57_product;
	}
	public BigDecimal getR57_inter_bank_place() {
		return r57_inter_bank_place;
	}
	public void setR57_inter_bank_place(BigDecimal r57_inter_bank_place) {
		this.r57_inter_bank_place = r57_inter_bank_place;
	}
	public BigDecimal getR57_inter_bank_borrow() {
		return r57_inter_bank_borrow;
	}
	public void setR57_inter_bank_borrow(BigDecimal r57_inter_bank_borrow) {
		this.r57_inter_bank_borrow = r57_inter_bank_borrow;
	}
	public BigDecimal getR57_other_placement() {
		return r57_other_placement;
	}
	public void setR57_other_placement(BigDecimal r57_other_placement) {
		this.r57_other_placement = r57_other_placement;
	}
	public BigDecimal getR57_other_borrow() {
		return r57_other_borrow;
	}
	public void setR57_other_borrow(BigDecimal r57_other_borrow) {
		this.r57_other_borrow = r57_other_borrow;
	}
	public BigDecimal getR57_remani_balance_from() {
		return r57_remani_balance_from;
	}
	public void setR57_remani_balance_from(BigDecimal r57_remani_balance_from) {
		this.r57_remani_balance_from = r57_remani_balance_from;
	}
	public BigDecimal getR57_remani_balance_to() {
		return r57_remani_balance_to;
	}
	public void setR57_remani_balance_to(BigDecimal r57_remani_balance_to) {
		this.r57_remani_balance_to = r57_remani_balance_to;
	}
	public String getR58_product() {
		return r58_product;
	}
	public void setR58_product(String r58_product) {
		this.r58_product = r58_product;
	}
	public BigDecimal getR58_inter_bank_place() {
		return r58_inter_bank_place;
	}
	public void setR58_inter_bank_place(BigDecimal r58_inter_bank_place) {
		this.r58_inter_bank_place = r58_inter_bank_place;
	}
	public BigDecimal getR58_inter_bank_borrow() {
		return r58_inter_bank_borrow;
	}
	public void setR58_inter_bank_borrow(BigDecimal r58_inter_bank_borrow) {
		this.r58_inter_bank_borrow = r58_inter_bank_borrow;
	}
	public BigDecimal getR58_other_placement() {
		return r58_other_placement;
	}
	public void setR58_other_placement(BigDecimal r58_other_placement) {
		this.r58_other_placement = r58_other_placement;
	}
	public BigDecimal getR58_other_borrow() {
		return r58_other_borrow;
	}
	public void setR58_other_borrow(BigDecimal r58_other_borrow) {
		this.r58_other_borrow = r58_other_borrow;
	}
	public BigDecimal getR58_remani_balance_from() {
		return r58_remani_balance_from;
	}
	public void setR58_remani_balance_from(BigDecimal r58_remani_balance_from) {
		this.r58_remani_balance_from = r58_remani_balance_from;
	}
	public BigDecimal getR58_remani_balance_to() {
		return r58_remani_balance_to;
	}
	public void setR58_remani_balance_to(BigDecimal r58_remani_balance_to) {
		this.r58_remani_balance_to = r58_remani_balance_to;
	}
	public String getR59_product() {
		return r59_product;
	}
	public void setR59_product(String r59_product) {
		this.r59_product = r59_product;
	}
	public BigDecimal getR59_inter_bank_place() {
		return r59_inter_bank_place;
	}
	public void setR59_inter_bank_place(BigDecimal r59_inter_bank_place) {
		this.r59_inter_bank_place = r59_inter_bank_place;
	}
	public BigDecimal getR59_inter_bank_borrow() {
		return r59_inter_bank_borrow;
	}
	public void setR59_inter_bank_borrow(BigDecimal r59_inter_bank_borrow) {
		this.r59_inter_bank_borrow = r59_inter_bank_borrow;
	}
	public BigDecimal getR59_other_placement() {
		return r59_other_placement;
	}
	public void setR59_other_placement(BigDecimal r59_other_placement) {
		this.r59_other_placement = r59_other_placement;
	}
	public BigDecimal getR59_other_borrow() {
		return r59_other_borrow;
	}
	public void setR59_other_borrow(BigDecimal r59_other_borrow) {
		this.r59_other_borrow = r59_other_borrow;
	}
	public BigDecimal getR59_remani_balance_from() {
		return r59_remani_balance_from;
	}
	public void setR59_remani_balance_from(BigDecimal r59_remani_balance_from) {
		this.r59_remani_balance_from = r59_remani_balance_from;
	}
	public BigDecimal getR59_remani_balance_to() {
		return r59_remani_balance_to;
	}
	public void setR59_remani_balance_to(BigDecimal r59_remani_balance_to) {
		this.r59_remani_balance_to = r59_remani_balance_to;
	}
	public String getR60_product() {
		return r60_product;
	}
	public void setR60_product(String r60_product) {
		this.r60_product = r60_product;
	}
	public BigDecimal getR60_inter_bank_place() {
		return r60_inter_bank_place;
	}
	public void setR60_inter_bank_place(BigDecimal r60_inter_bank_place) {
		this.r60_inter_bank_place = r60_inter_bank_place;
	}
	public BigDecimal getR60_inter_bank_borrow() {
		return r60_inter_bank_borrow;
	}
	public void setR60_inter_bank_borrow(BigDecimal r60_inter_bank_borrow) {
		this.r60_inter_bank_borrow = r60_inter_bank_borrow;
	}
	public BigDecimal getR60_other_placement() {
		return r60_other_placement;
	}
	public void setR60_other_placement(BigDecimal r60_other_placement) {
		this.r60_other_placement = r60_other_placement;
	}
	public BigDecimal getR60_other_borrow() {
		return r60_other_borrow;
	}
	public void setR60_other_borrow(BigDecimal r60_other_borrow) {
		this.r60_other_borrow = r60_other_borrow;
	}
	public BigDecimal getR60_remani_balance_from() {
		return r60_remani_balance_from;
	}
	public void setR60_remani_balance_from(BigDecimal r60_remani_balance_from) {
		this.r60_remani_balance_from = r60_remani_balance_from;
	}
	public BigDecimal getR60_remani_balance_to() {
		return r60_remani_balance_to;
	}
	public void setR60_remani_balance_to(BigDecimal r60_remani_balance_to) {
		this.r60_remani_balance_to = r60_remani_balance_to;
	}
	public String getR61_product() {
		return r61_product;
	}
	public void setR61_product(String r61_product) {
		this.r61_product = r61_product;
	}
	public BigDecimal getR61_inter_bank_place() {
		return r61_inter_bank_place;
	}
	public void setR61_inter_bank_place(BigDecimal r61_inter_bank_place) {
		this.r61_inter_bank_place = r61_inter_bank_place;
	}
	public BigDecimal getR61_inter_bank_borrow() {
		return r61_inter_bank_borrow;
	}
	public void setR61_inter_bank_borrow(BigDecimal r61_inter_bank_borrow) {
		this.r61_inter_bank_borrow = r61_inter_bank_borrow;
	}
	public BigDecimal getR61_other_placement() {
		return r61_other_placement;
	}
	public void setR61_other_placement(BigDecimal r61_other_placement) {
		this.r61_other_placement = r61_other_placement;
	}
	public BigDecimal getR61_other_borrow() {
		return r61_other_borrow;
	}
	public void setR61_other_borrow(BigDecimal r61_other_borrow) {
		this.r61_other_borrow = r61_other_borrow;
	}
	public BigDecimal getR61_remani_balance_from() {
		return r61_remani_balance_from;
	}
	public void setR61_remani_balance_from(BigDecimal r61_remani_balance_from) {
		this.r61_remani_balance_from = r61_remani_balance_from;
	}
	public BigDecimal getR61_remani_balance_to() {
		return r61_remani_balance_to;
	}
	public void setR61_remani_balance_to(BigDecimal r61_remani_balance_to) {
		this.r61_remani_balance_to = r61_remani_balance_to;
	}
	public String getR62_product() {
		return r62_product;
	}
	public void setR62_product(String r62_product) {
		this.r62_product = r62_product;
	}
	public BigDecimal getR62_inter_bank_place() {
		return r62_inter_bank_place;
	}
	public void setR62_inter_bank_place(BigDecimal r62_inter_bank_place) {
		this.r62_inter_bank_place = r62_inter_bank_place;
	}
	public BigDecimal getR62_inter_bank_borrow() {
		return r62_inter_bank_borrow;
	}
	public void setR62_inter_bank_borrow(BigDecimal r62_inter_bank_borrow) {
		this.r62_inter_bank_borrow = r62_inter_bank_borrow;
	}
	public BigDecimal getR62_other_placement() {
		return r62_other_placement;
	}
	public void setR62_other_placement(BigDecimal r62_other_placement) {
		this.r62_other_placement = r62_other_placement;
	}
	public BigDecimal getR62_other_borrow() {
		return r62_other_borrow;
	}
	public void setR62_other_borrow(BigDecimal r62_other_borrow) {
		this.r62_other_borrow = r62_other_borrow;
	}
	public BigDecimal getR62_remani_balance_from() {
		return r62_remani_balance_from;
	}
	public void setR62_remani_balance_from(BigDecimal r62_remani_balance_from) {
		this.r62_remani_balance_from = r62_remani_balance_from;
	}
	public BigDecimal getR62_remani_balance_to() {
		return r62_remani_balance_to;
	}
	public void setR62_remani_balance_to(BigDecimal r62_remani_balance_to) {
		this.r62_remani_balance_to = r62_remani_balance_to;
	}
	public String getR63_product() {
		return r63_product;
	}
	public void setR63_product(String r63_product) {
		this.r63_product = r63_product;
	}
	public BigDecimal getR63_inter_bank_place() {
		return r63_inter_bank_place;
	}
	public void setR63_inter_bank_place(BigDecimal r63_inter_bank_place) {
		this.r63_inter_bank_place = r63_inter_bank_place;
	}
	public BigDecimal getR63_inter_bank_borrow() {
		return r63_inter_bank_borrow;
	}
	public void setR63_inter_bank_borrow(BigDecimal r63_inter_bank_borrow) {
		this.r63_inter_bank_borrow = r63_inter_bank_borrow;
	}
	public BigDecimal getR63_other_placement() {
		return r63_other_placement;
	}
	public void setR63_other_placement(BigDecimal r63_other_placement) {
		this.r63_other_placement = r63_other_placement;
	}
	public BigDecimal getR63_other_borrow() {
		return r63_other_borrow;
	}
	public void setR63_other_borrow(BigDecimal r63_other_borrow) {
		this.r63_other_borrow = r63_other_borrow;
	}
	public BigDecimal getR63_remani_balance_from() {
		return r63_remani_balance_from;
	}
	public void setR63_remani_balance_from(BigDecimal r63_remani_balance_from) {
		this.r63_remani_balance_from = r63_remani_balance_from;
	}
	public BigDecimal getR63_remani_balance_to() {
		return r63_remani_balance_to;
	}
	public void setR63_remani_balance_to(BigDecimal r63_remani_balance_to) {
		this.r63_remani_balance_to = r63_remani_balance_to;
	}
	public String getR64_product() {
		return r64_product;
	}
	public void setR64_product(String r64_product) {
		this.r64_product = r64_product;
	}
	public BigDecimal getR64_inter_bank_place() {
		return r64_inter_bank_place;
	}
	public void setR64_inter_bank_place(BigDecimal r64_inter_bank_place) {
		this.r64_inter_bank_place = r64_inter_bank_place;
	}
	public BigDecimal getR64_inter_bank_borrow() {
		return r64_inter_bank_borrow;
	}
	public void setR64_inter_bank_borrow(BigDecimal r64_inter_bank_borrow) {
		this.r64_inter_bank_borrow = r64_inter_bank_borrow;
	}
	public BigDecimal getR64_other_placement() {
		return r64_other_placement;
	}
	public void setR64_other_placement(BigDecimal r64_other_placement) {
		this.r64_other_placement = r64_other_placement;
	}
	public BigDecimal getR64_other_borrow() {
		return r64_other_borrow;
	}
	public void setR64_other_borrow(BigDecimal r64_other_borrow) {
		this.r64_other_borrow = r64_other_borrow;
	}
	public BigDecimal getR64_remani_balance_from() {
		return r64_remani_balance_from;
	}
	public void setR64_remani_balance_from(BigDecimal r64_remani_balance_from) {
		this.r64_remani_balance_from = r64_remani_balance_from;
	}
	public BigDecimal getR64_remani_balance_to() {
		return r64_remani_balance_to;
	}
	public void setR64_remani_balance_to(BigDecimal r64_remani_balance_to) {
		this.r64_remani_balance_to = r64_remani_balance_to;
	}
	public String getR65_product() {
		return r65_product;
	}
	public void setR65_product(String r65_product) {
		this.r65_product = r65_product;
	}
	public BigDecimal getR65_inter_bank_place() {
		return r65_inter_bank_place;
	}
	public void setR65_inter_bank_place(BigDecimal r65_inter_bank_place) {
		this.r65_inter_bank_place = r65_inter_bank_place;
	}
	public BigDecimal getR65_inter_bank_borrow() {
		return r65_inter_bank_borrow;
	}
	public void setR65_inter_bank_borrow(BigDecimal r65_inter_bank_borrow) {
		this.r65_inter_bank_borrow = r65_inter_bank_borrow;
	}
	public BigDecimal getR65_other_placement() {
		return r65_other_placement;
	}
	public void setR65_other_placement(BigDecimal r65_other_placement) {
		this.r65_other_placement = r65_other_placement;
	}
	public BigDecimal getR65_other_borrow() {
		return r65_other_borrow;
	}
	public void setR65_other_borrow(BigDecimal r65_other_borrow) {
		this.r65_other_borrow = r65_other_borrow;
	}
	public BigDecimal getR65_remani_balance_from() {
		return r65_remani_balance_from;
	}
	public void setR65_remani_balance_from(BigDecimal r65_remani_balance_from) {
		this.r65_remani_balance_from = r65_remani_balance_from;
	}
	public BigDecimal getR65_remani_balance_to() {
		return r65_remani_balance_to;
	}
	public void setR65_remani_balance_to(BigDecimal r65_remani_balance_to) {
		this.r65_remani_balance_to = r65_remani_balance_to;
	}
	public String getR66_product() {
		return r66_product;
	}
	public void setR66_product(String r66_product) {
		this.r66_product = r66_product;
	}
	public BigDecimal getR66_inter_bank_place() {
		return r66_inter_bank_place;
	}
	public void setR66_inter_bank_place(BigDecimal r66_inter_bank_place) {
		this.r66_inter_bank_place = r66_inter_bank_place;
	}
	public BigDecimal getR66_inter_bank_borrow() {
		return r66_inter_bank_borrow;
	}
	public void setR66_inter_bank_borrow(BigDecimal r66_inter_bank_borrow) {
		this.r66_inter_bank_borrow = r66_inter_bank_borrow;
	}
	public BigDecimal getR66_other_placement() {
		return r66_other_placement;
	}
	public void setR66_other_placement(BigDecimal r66_other_placement) {
		this.r66_other_placement = r66_other_placement;
	}
	public BigDecimal getR66_other_borrow() {
		return r66_other_borrow;
	}
	public void setR66_other_borrow(BigDecimal r66_other_borrow) {
		this.r66_other_borrow = r66_other_borrow;
	}
	public BigDecimal getR66_remani_balance_from() {
		return r66_remani_balance_from;
	}
	public void setR66_remani_balance_from(BigDecimal r66_remani_balance_from) {
		this.r66_remani_balance_from = r66_remani_balance_from;
	}
	public BigDecimal getR66_remani_balance_to() {
		return r66_remani_balance_to;
	}
	public void setR66_remani_balance_to(BigDecimal r66_remani_balance_to) {
		this.r66_remani_balance_to = r66_remani_balance_to;
	}
	public String getR67_product() {
		return r67_product;
	}
	public void setR67_product(String r67_product) {
		this.r67_product = r67_product;
	}
	public BigDecimal getR67_inter_bank_place() {
		return r67_inter_bank_place;
	}
	public void setR67_inter_bank_place(BigDecimal r67_inter_bank_place) {
		this.r67_inter_bank_place = r67_inter_bank_place;
	}
	public BigDecimal getR67_inter_bank_borrow() {
		return r67_inter_bank_borrow;
	}
	public void setR67_inter_bank_borrow(BigDecimal r67_inter_bank_borrow) {
		this.r67_inter_bank_borrow = r67_inter_bank_borrow;
	}
	public BigDecimal getR67_other_placement() {
		return r67_other_placement;
	}
	public void setR67_other_placement(BigDecimal r67_other_placement) {
		this.r67_other_placement = r67_other_placement;
	}
	public BigDecimal getR67_other_borrow() {
		return r67_other_borrow;
	}
	public void setR67_other_borrow(BigDecimal r67_other_borrow) {
		this.r67_other_borrow = r67_other_borrow;
	}
	public BigDecimal getR67_remani_balance_from() {
		return r67_remani_balance_from;
	}
	public void setR67_remani_balance_from(BigDecimal r67_remani_balance_from) {
		this.r67_remani_balance_from = r67_remani_balance_from;
	}
	public BigDecimal getR67_remani_balance_to() {
		return r67_remani_balance_to;
	}
	public void setR67_remani_balance_to(BigDecimal r67_remani_balance_to) {
		this.r67_remani_balance_to = r67_remani_balance_to;
	}
	public String getR68_product() {
		return r68_product;
	}
	public void setR68_product(String r68_product) {
		this.r68_product = r68_product;
	}
	public BigDecimal getR68_inter_bank_place() {
		return r68_inter_bank_place;
	}
	public void setR68_inter_bank_place(BigDecimal r68_inter_bank_place) {
		this.r68_inter_bank_place = r68_inter_bank_place;
	}
	public BigDecimal getR68_inter_bank_borrow() {
		return r68_inter_bank_borrow;
	}
	public void setR68_inter_bank_borrow(BigDecimal r68_inter_bank_borrow) {
		this.r68_inter_bank_borrow = r68_inter_bank_borrow;
	}
	public BigDecimal getR68_other_placement() {
		return r68_other_placement;
	}
	public void setR68_other_placement(BigDecimal r68_other_placement) {
		this.r68_other_placement = r68_other_placement;
	}
	public BigDecimal getR68_other_borrow() {
		return r68_other_borrow;
	}
	public void setR68_other_borrow(BigDecimal r68_other_borrow) {
		this.r68_other_borrow = r68_other_borrow;
	}
	public BigDecimal getR68_remani_balance_from() {
		return r68_remani_balance_from;
	}
	public void setR68_remani_balance_from(BigDecimal r68_remani_balance_from) {
		this.r68_remani_balance_from = r68_remani_balance_from;
	}
	public BigDecimal getR68_remani_balance_to() {
		return r68_remani_balance_to;
	}
	public void setR68_remani_balance_to(BigDecimal r68_remani_balance_to) {
		this.r68_remani_balance_to = r68_remani_balance_to;
	}
	public String getR69_product() {
		return r69_product;
	}
	public void setR69_product(String r69_product) {
		this.r69_product = r69_product;
	}
	public BigDecimal getR69_inter_bank_place() {
		return r69_inter_bank_place;
	}
	public void setR69_inter_bank_place(BigDecimal r69_inter_bank_place) {
		this.r69_inter_bank_place = r69_inter_bank_place;
	}
	public BigDecimal getR69_inter_bank_borrow() {
		return r69_inter_bank_borrow;
	}
	public void setR69_inter_bank_borrow(BigDecimal r69_inter_bank_borrow) {
		this.r69_inter_bank_borrow = r69_inter_bank_borrow;
	}
	public BigDecimal getR69_other_placement() {
		return r69_other_placement;
	}
	public void setR69_other_placement(BigDecimal r69_other_placement) {
		this.r69_other_placement = r69_other_placement;
	}
	public BigDecimal getR69_other_borrow() {
		return r69_other_borrow;
	}
	public void setR69_other_borrow(BigDecimal r69_other_borrow) {
		this.r69_other_borrow = r69_other_borrow;
	}
	public BigDecimal getR69_remani_balance_from() {
		return r69_remani_balance_from;
	}
	public void setR69_remani_balance_from(BigDecimal r69_remani_balance_from) {
		this.r69_remani_balance_from = r69_remani_balance_from;
	}
	public BigDecimal getR69_remani_balance_to() {
		return r69_remani_balance_to;
	}
	public void setR69_remani_balance_to(BigDecimal r69_remani_balance_to) {
		this.r69_remani_balance_to = r69_remani_balance_to;
	}
	public String getR70_product() {
		return r70_product;
	}
	public void setR70_product(String r70_product) {
		this.r70_product = r70_product;
	}
	public BigDecimal getR70_inter_bank_place() {
		return r70_inter_bank_place;
	}
	public void setR70_inter_bank_place(BigDecimal r70_inter_bank_place) {
		this.r70_inter_bank_place = r70_inter_bank_place;
	}
	public BigDecimal getR70_inter_bank_borrow() {
		return r70_inter_bank_borrow;
	}
	public void setR70_inter_bank_borrow(BigDecimal r70_inter_bank_borrow) {
		this.r70_inter_bank_borrow = r70_inter_bank_borrow;
	}
	public BigDecimal getR70_other_placement() {
		return r70_other_placement;
	}
	public void setR70_other_placement(BigDecimal r70_other_placement) {
		this.r70_other_placement = r70_other_placement;
	}
	public BigDecimal getR70_other_borrow() {
		return r70_other_borrow;
	}
	public void setR70_other_borrow(BigDecimal r70_other_borrow) {
		this.r70_other_borrow = r70_other_borrow;
	}
	public BigDecimal getR70_remani_balance_from() {
		return r70_remani_balance_from;
	}
	public void setR70_remani_balance_from(BigDecimal r70_remani_balance_from) {
		this.r70_remani_balance_from = r70_remani_balance_from;
	}
	public BigDecimal getR70_remani_balance_to() {
		return r70_remani_balance_to;
	}
	public void setR70_remani_balance_to(BigDecimal r70_remani_balance_to) {
		this.r70_remani_balance_to = r70_remani_balance_to;
	}
	public String getR71_product() {
		return r71_product;
	}
	public void setR71_product(String r71_product) {
		this.r71_product = r71_product;
	}
	public BigDecimal getR71_inter_bank_place() {
		return r71_inter_bank_place;
	}
	public void setR71_inter_bank_place(BigDecimal r71_inter_bank_place) {
		this.r71_inter_bank_place = r71_inter_bank_place;
	}
	public BigDecimal getR71_inter_bank_borrow() {
		return r71_inter_bank_borrow;
	}
	public void setR71_inter_bank_borrow(BigDecimal r71_inter_bank_borrow) {
		this.r71_inter_bank_borrow = r71_inter_bank_borrow;
	}
	public BigDecimal getR71_other_placement() {
		return r71_other_placement;
	}
	public void setR71_other_placement(BigDecimal r71_other_placement) {
		this.r71_other_placement = r71_other_placement;
	}
	public BigDecimal getR71_other_borrow() {
		return r71_other_borrow;
	}
	public void setR71_other_borrow(BigDecimal r71_other_borrow) {
		this.r71_other_borrow = r71_other_borrow;
	}
	public BigDecimal getR71_remani_balance_from() {
		return r71_remani_balance_from;
	}
	public void setR71_remani_balance_from(BigDecimal r71_remani_balance_from) {
		this.r71_remani_balance_from = r71_remani_balance_from;
	}
	public BigDecimal getR71_remani_balance_to() {
		return r71_remani_balance_to;
	}
	public void setR71_remani_balance_to(BigDecimal r71_remani_balance_to) {
		this.r71_remani_balance_to = r71_remani_balance_to;
	}
	public String getR72_product() {
		return r72_product;
	}
	public void setR72_product(String r72_product) {
		this.r72_product = r72_product;
	}
	public BigDecimal getR72_inter_bank_place() {
		return r72_inter_bank_place;
	}
	public void setR72_inter_bank_place(BigDecimal r72_inter_bank_place) {
		this.r72_inter_bank_place = r72_inter_bank_place;
	}
	public BigDecimal getR72_inter_bank_borrow() {
		return r72_inter_bank_borrow;
	}
	public void setR72_inter_bank_borrow(BigDecimal r72_inter_bank_borrow) {
		this.r72_inter_bank_borrow = r72_inter_bank_borrow;
	}
	public BigDecimal getR72_other_placement() {
		return r72_other_placement;
	}
	public void setR72_other_placement(BigDecimal r72_other_placement) {
		this.r72_other_placement = r72_other_placement;
	}
	public BigDecimal getR72_other_borrow() {
		return r72_other_borrow;
	}
	public void setR72_other_borrow(BigDecimal r72_other_borrow) {
		this.r72_other_borrow = r72_other_borrow;
	}
	public BigDecimal getR72_remani_balance_from() {
		return r72_remani_balance_from;
	}
	public void setR72_remani_balance_from(BigDecimal r72_remani_balance_from) {
		this.r72_remani_balance_from = r72_remani_balance_from;
	}
	public BigDecimal getR72_remani_balance_to() {
		return r72_remani_balance_to;
	}
	public void setR72_remani_balance_to(BigDecimal r72_remani_balance_to) {
		this.r72_remani_balance_to = r72_remani_balance_to;
	}
	public String getR73_product() {
		return r73_product;
	}
	public void setR73_product(String r73_product) {
		this.r73_product = r73_product;
	}
	public BigDecimal getR73_inter_bank_place() {
		return r73_inter_bank_place;
	}
	public void setR73_inter_bank_place(BigDecimal r73_inter_bank_place) {
		this.r73_inter_bank_place = r73_inter_bank_place;
	}
	public BigDecimal getR73_inter_bank_borrow() {
		return r73_inter_bank_borrow;
	}
	public void setR73_inter_bank_borrow(BigDecimal r73_inter_bank_borrow) {
		this.r73_inter_bank_borrow = r73_inter_bank_borrow;
	}
	public BigDecimal getR73_other_placement() {
		return r73_other_placement;
	}
	public void setR73_other_placement(BigDecimal r73_other_placement) {
		this.r73_other_placement = r73_other_placement;
	}
	public BigDecimal getR73_other_borrow() {
		return r73_other_borrow;
	}
	public void setR73_other_borrow(BigDecimal r73_other_borrow) {
		this.r73_other_borrow = r73_other_borrow;
	}
	public BigDecimal getR73_remani_balance_from() {
		return r73_remani_balance_from;
	}
	public void setR73_remani_balance_from(BigDecimal r73_remani_balance_from) {
		this.r73_remani_balance_from = r73_remani_balance_from;
	}
	public BigDecimal getR73_remani_balance_to() {
		return r73_remani_balance_to;
	}
	public void setR73_remani_balance_to(BigDecimal r73_remani_balance_to) {
		this.r73_remani_balance_to = r73_remani_balance_to;
	}
	public String getR74_product() {
		return r74_product;
	}
	public void setR74_product(String r74_product) {
		this.r74_product = r74_product;
	}
	public BigDecimal getR74_inter_bank_place() {
		return r74_inter_bank_place;
	}
	public void setR74_inter_bank_place(BigDecimal r74_inter_bank_place) {
		this.r74_inter_bank_place = r74_inter_bank_place;
	}
	public BigDecimal getR74_inter_bank_borrow() {
		return r74_inter_bank_borrow;
	}
	public void setR74_inter_bank_borrow(BigDecimal r74_inter_bank_borrow) {
		this.r74_inter_bank_borrow = r74_inter_bank_borrow;
	}
	public BigDecimal getR74_other_placement() {
		return r74_other_placement;
	}
	public void setR74_other_placement(BigDecimal r74_other_placement) {
		this.r74_other_placement = r74_other_placement;
	}
	public BigDecimal getR74_other_borrow() {
		return r74_other_borrow;
	}
	public void setR74_other_borrow(BigDecimal r74_other_borrow) {
		this.r74_other_borrow = r74_other_borrow;
	}
	public BigDecimal getR74_remani_balance_from() {
		return r74_remani_balance_from;
	}
	public void setR74_remani_balance_from(BigDecimal r74_remani_balance_from) {
		this.r74_remani_balance_from = r74_remani_balance_from;
	}
	public BigDecimal getR74_remani_balance_to() {
		return r74_remani_balance_to;
	}
	public void setR74_remani_balance_to(BigDecimal r74_remani_balance_to) {
		this.r74_remani_balance_to = r74_remani_balance_to;
	}
	public String getR75_product() {
		return r75_product;
	}
	public void setR75_product(String r75_product) {
		this.r75_product = r75_product;
	}
	public BigDecimal getR75_inter_bank_place() {
		return r75_inter_bank_place;
	}
	public void setR75_inter_bank_place(BigDecimal r75_inter_bank_place) {
		this.r75_inter_bank_place = r75_inter_bank_place;
	}
	public BigDecimal getR75_inter_bank_borrow() {
		return r75_inter_bank_borrow;
	}
	public void setR75_inter_bank_borrow(BigDecimal r75_inter_bank_borrow) {
		this.r75_inter_bank_borrow = r75_inter_bank_borrow;
	}
	public BigDecimal getR75_other_placement() {
		return r75_other_placement;
	}
	public void setR75_other_placement(BigDecimal r75_other_placement) {
		this.r75_other_placement = r75_other_placement;
	}
	public BigDecimal getR75_other_borrow() {
		return r75_other_borrow;
	}
	public void setR75_other_borrow(BigDecimal r75_other_borrow) {
		this.r75_other_borrow = r75_other_borrow;
	}
	public BigDecimal getR75_remani_balance_from() {
		return r75_remani_balance_from;
	}
	public void setR75_remani_balance_from(BigDecimal r75_remani_balance_from) {
		this.r75_remani_balance_from = r75_remani_balance_from;
	}
	public BigDecimal getR75_remani_balance_to() {
		return r75_remani_balance_to;
	}
	public void setR75_remani_balance_to(BigDecimal r75_remani_balance_to) {
		this.r75_remani_balance_to = r75_remani_balance_to;
	}
	public String getR76_product() {
		return r76_product;
	}
	public void setR76_product(String r76_product) {
		this.r76_product = r76_product;
	}
	public BigDecimal getR76_inter_bank_place() {
		return r76_inter_bank_place;
	}
	public void setR76_inter_bank_place(BigDecimal r76_inter_bank_place) {
		this.r76_inter_bank_place = r76_inter_bank_place;
	}
	public BigDecimal getR76_inter_bank_borrow() {
		return r76_inter_bank_borrow;
	}
	public void setR76_inter_bank_borrow(BigDecimal r76_inter_bank_borrow) {
		this.r76_inter_bank_borrow = r76_inter_bank_borrow;
	}
	public BigDecimal getR76_other_placement() {
		return r76_other_placement;
	}
	public void setR76_other_placement(BigDecimal r76_other_placement) {
		this.r76_other_placement = r76_other_placement;
	}
	public BigDecimal getR76_other_borrow() {
		return r76_other_borrow;
	}
	public void setR76_other_borrow(BigDecimal r76_other_borrow) {
		this.r76_other_borrow = r76_other_borrow;
	}
	public BigDecimal getR76_remani_balance_from() {
		return r76_remani_balance_from;
	}
	public void setR76_remani_balance_from(BigDecimal r76_remani_balance_from) {
		this.r76_remani_balance_from = r76_remani_balance_from;
	}
	public BigDecimal getR76_remani_balance_to() {
		return r76_remani_balance_to;
	}
	public void setR76_remani_balance_to(BigDecimal r76_remani_balance_to) {
		this.r76_remani_balance_to = r76_remani_balance_to;
	}
	public String getR77_product() {
		return r77_product;
	}
	public void setR77_product(String r77_product) {
		this.r77_product = r77_product;
	}
	public BigDecimal getR77_inter_bank_place() {
		return r77_inter_bank_place;
	}
	public void setR77_inter_bank_place(BigDecimal r77_inter_bank_place) {
		this.r77_inter_bank_place = r77_inter_bank_place;
	}
	public BigDecimal getR77_inter_bank_borrow() {
		return r77_inter_bank_borrow;
	}
	public void setR77_inter_bank_borrow(BigDecimal r77_inter_bank_borrow) {
		this.r77_inter_bank_borrow = r77_inter_bank_borrow;
	}
	public BigDecimal getR77_other_placement() {
		return r77_other_placement;
	}
	public void setR77_other_placement(BigDecimal r77_other_placement) {
		this.r77_other_placement = r77_other_placement;
	}
	public BigDecimal getR77_other_borrow() {
		return r77_other_borrow;
	}
	public void setR77_other_borrow(BigDecimal r77_other_borrow) {
		this.r77_other_borrow = r77_other_borrow;
	}
	public BigDecimal getR77_remani_balance_from() {
		return r77_remani_balance_from;
	}
	public void setR77_remani_balance_from(BigDecimal r77_remani_balance_from) {
		this.r77_remani_balance_from = r77_remani_balance_from;
	}
	public BigDecimal getR77_remani_balance_to() {
		return r77_remani_balance_to;
	}
	public void setR77_remani_balance_to(BigDecimal r77_remani_balance_to) {
		this.r77_remani_balance_to = r77_remani_balance_to;
	}
	public String getR78_product() {
		return r78_product;
	}
	public void setR78_product(String r78_product) {
		this.r78_product = r78_product;
	}
	public BigDecimal getR78_inter_bank_place() {
		return r78_inter_bank_place;
	}
	public void setR78_inter_bank_place(BigDecimal r78_inter_bank_place) {
		this.r78_inter_bank_place = r78_inter_bank_place;
	}
	public BigDecimal getR78_inter_bank_borrow() {
		return r78_inter_bank_borrow;
	}
	public void setR78_inter_bank_borrow(BigDecimal r78_inter_bank_borrow) {
		this.r78_inter_bank_borrow = r78_inter_bank_borrow;
	}
	public BigDecimal getR78_other_placement() {
		return r78_other_placement;
	}
	public void setR78_other_placement(BigDecimal r78_other_placement) {
		this.r78_other_placement = r78_other_placement;
	}
	public BigDecimal getR78_other_borrow() {
		return r78_other_borrow;
	}
	public void setR78_other_borrow(BigDecimal r78_other_borrow) {
		this.r78_other_borrow = r78_other_borrow;
	}
	public BigDecimal getR78_remani_balance_from() {
		return r78_remani_balance_from;
	}
	public void setR78_remani_balance_from(BigDecimal r78_remani_balance_from) {
		this.r78_remani_balance_from = r78_remani_balance_from;
	}
	public BigDecimal getR78_remani_balance_to() {
		return r78_remani_balance_to;
	}
	public void setR78_remani_balance_to(BigDecimal r78_remani_balance_to) {
		this.r78_remani_balance_to = r78_remani_balance_to;
	}
	public String getR79_product() {
		return r79_product;
	}
	public void setR79_product(String r79_product) {
		this.r79_product = r79_product;
	}
	public BigDecimal getR79_inter_bank_place() {
		return r79_inter_bank_place;
	}
	public void setR79_inter_bank_place(BigDecimal r79_inter_bank_place) {
		this.r79_inter_bank_place = r79_inter_bank_place;
	}
	public BigDecimal getR79_inter_bank_borrow() {
		return r79_inter_bank_borrow;
	}
	public void setR79_inter_bank_borrow(BigDecimal r79_inter_bank_borrow) {
		this.r79_inter_bank_borrow = r79_inter_bank_borrow;
	}
	public BigDecimal getR79_other_placement() {
		return r79_other_placement;
	}
	public void setR79_other_placement(BigDecimal r79_other_placement) {
		this.r79_other_placement = r79_other_placement;
	}
	public BigDecimal getR79_other_borrow() {
		return r79_other_borrow;
	}
	public void setR79_other_borrow(BigDecimal r79_other_borrow) {
		this.r79_other_borrow = r79_other_borrow;
	}
	public BigDecimal getR79_remani_balance_from() {
		return r79_remani_balance_from;
	}
	public void setR79_remani_balance_from(BigDecimal r79_remani_balance_from) {
		this.r79_remani_balance_from = r79_remani_balance_from;
	}
	public BigDecimal getR79_remani_balance_to() {
		return r79_remani_balance_to;
	}
	public void setR79_remani_balance_to(BigDecimal r79_remani_balance_to) {
		this.r79_remani_balance_to = r79_remani_balance_to;
	}
	public String getR80_product() {
		return r80_product;
	}
	public void setR80_product(String r80_product) {
		this.r80_product = r80_product;
	}
	public BigDecimal getR80_inter_bank_place() {
		return r80_inter_bank_place;
	}
	public void setR80_inter_bank_place(BigDecimal r80_inter_bank_place) {
		this.r80_inter_bank_place = r80_inter_bank_place;
	}
	public BigDecimal getR80_inter_bank_borrow() {
		return r80_inter_bank_borrow;
	}
	public void setR80_inter_bank_borrow(BigDecimal r80_inter_bank_borrow) {
		this.r80_inter_bank_borrow = r80_inter_bank_borrow;
	}
	public BigDecimal getR80_other_placement() {
		return r80_other_placement;
	}
	public void setR80_other_placement(BigDecimal r80_other_placement) {
		this.r80_other_placement = r80_other_placement;
	}
	public BigDecimal getR80_other_borrow() {
		return r80_other_borrow;
	}
	public void setR80_other_borrow(BigDecimal r80_other_borrow) {
		this.r80_other_borrow = r80_other_borrow;
	}
	public BigDecimal getR80_remani_balance_from() {
		return r80_remani_balance_from;
	}
	public void setR80_remani_balance_from(BigDecimal r80_remani_balance_from) {
		this.r80_remani_balance_from = r80_remani_balance_from;
	}
	public BigDecimal getR80_remani_balance_to() {
		return r80_remani_balance_to;
	}
	public void setR80_remani_balance_to(BigDecimal r80_remani_balance_to) {
		this.r80_remani_balance_to = r80_remani_balance_to;
	}
	public String getR81_product() {
		return r81_product;
	}
	public void setR81_product(String r81_product) {
		this.r81_product = r81_product;
	}
	public BigDecimal getR81_inter_bank_place() {
		return r81_inter_bank_place;
	}
	public void setR81_inter_bank_place(BigDecimal r81_inter_bank_place) {
		this.r81_inter_bank_place = r81_inter_bank_place;
	}
	public BigDecimal getR81_inter_bank_borrow() {
		return r81_inter_bank_borrow;
	}
	public void setR81_inter_bank_borrow(BigDecimal r81_inter_bank_borrow) {
		this.r81_inter_bank_borrow = r81_inter_bank_borrow;
	}
	public BigDecimal getR81_other_placement() {
		return r81_other_placement;
	}
	public void setR81_other_placement(BigDecimal r81_other_placement) {
		this.r81_other_placement = r81_other_placement;
	}
	public BigDecimal getR81_other_borrow() {
		return r81_other_borrow;
	}
	public void setR81_other_borrow(BigDecimal r81_other_borrow) {
		this.r81_other_borrow = r81_other_borrow;
	}
	public BigDecimal getR81_remani_balance_from() {
		return r81_remani_balance_from;
	}
	public void setR81_remani_balance_from(BigDecimal r81_remani_balance_from) {
		this.r81_remani_balance_from = r81_remani_balance_from;
	}
	public BigDecimal getR81_remani_balance_to() {
		return r81_remani_balance_to;
	}
	public void setR81_remani_balance_to(BigDecimal r81_remani_balance_to) {
		this.r81_remani_balance_to = r81_remani_balance_to;
	}
	public String getRh4_product() {
		return rh4_product;
	}
	public void setRh4_product(String rh4_product) {
		this.rh4_product = rh4_product;
	}
	public BigDecimal getRh4_inter_bank_place() {
		return rh4_inter_bank_place;
	}
	public void setRh4_inter_bank_place(BigDecimal rh4_inter_bank_place) {
		this.rh4_inter_bank_place = rh4_inter_bank_place;
	}
	public BigDecimal getRh4_inter_bank_borrow() {
		return rh4_inter_bank_borrow;
	}
	public void setRh4_inter_bank_borrow(BigDecimal rh4_inter_bank_borrow) {
		this.rh4_inter_bank_borrow = rh4_inter_bank_borrow;
	}
	public BigDecimal getRh4_other_placement() {
		return rh4_other_placement;
	}
	public void setRh4_other_placement(BigDecimal rh4_other_placement) {
		this.rh4_other_placement = rh4_other_placement;
	}
	public BigDecimal getRh4_other_borrow() {
		return rh4_other_borrow;
	}
	public void setRh4_other_borrow(BigDecimal rh4_other_borrow) {
		this.rh4_other_borrow = rh4_other_borrow;
	}
	public BigDecimal getRh4_remani_balance_from() {
		return rh4_remani_balance_from;
	}
	public void setRh4_remani_balance_from(BigDecimal rh4_remani_balance_from) {
		this.rh4_remani_balance_from = rh4_remani_balance_from;
	}
	public BigDecimal getRh4_remani_balance_to() {
		return rh4_remani_balance_to;
	}
	public void setRh4_remani_balance_to(BigDecimal rh4_remani_balance_to) {
		this.rh4_remani_balance_to = rh4_remani_balance_to;
	}
	public String getR82_product() {
		return r82_product;
	}
	public void setR82_product(String r82_product) {
		this.r82_product = r82_product;
	}
	public BigDecimal getR82_inter_bank_place() {
		return r82_inter_bank_place;
	}
	public void setR82_inter_bank_place(BigDecimal r82_inter_bank_place) {
		this.r82_inter_bank_place = r82_inter_bank_place;
	}
	public BigDecimal getR82_inter_bank_borrow() {
		return r82_inter_bank_borrow;
	}
	public void setR82_inter_bank_borrow(BigDecimal r82_inter_bank_borrow) {
		this.r82_inter_bank_borrow = r82_inter_bank_borrow;
	}
	public BigDecimal getR82_other_placement() {
		return r82_other_placement;
	}
	public void setR82_other_placement(BigDecimal r82_other_placement) {
		this.r82_other_placement = r82_other_placement;
	}
	public BigDecimal getR82_other_borrow() {
		return r82_other_borrow;
	}
	public void setR82_other_borrow(BigDecimal r82_other_borrow) {
		this.r82_other_borrow = r82_other_borrow;
	}
	public BigDecimal getR82_remani_balance_from() {
		return r82_remani_balance_from;
	}
	public void setR82_remani_balance_from(BigDecimal r82_remani_balance_from) {
		this.r82_remani_balance_from = r82_remani_balance_from;
	}
	public BigDecimal getR82_remani_balance_to() {
		return r82_remani_balance_to;
	}
	public void setR82_remani_balance_to(BigDecimal r82_remani_balance_to) {
		this.r82_remani_balance_to = r82_remani_balance_to;
	}
	public String getR83_product() {
		return r83_product;
	}
	public void setR83_product(String r83_product) {
		this.r83_product = r83_product;
	}
	public BigDecimal getR83_inter_bank_place() {
		return r83_inter_bank_place;
	}
	public void setR83_inter_bank_place(BigDecimal r83_inter_bank_place) {
		this.r83_inter_bank_place = r83_inter_bank_place;
	}
	public BigDecimal getR83_inter_bank_borrow() {
		return r83_inter_bank_borrow;
	}
	public void setR83_inter_bank_borrow(BigDecimal r83_inter_bank_borrow) {
		this.r83_inter_bank_borrow = r83_inter_bank_borrow;
	}
	public BigDecimal getR83_other_placement() {
		return r83_other_placement;
	}
	public void setR83_other_placement(BigDecimal r83_other_placement) {
		this.r83_other_placement = r83_other_placement;
	}
	public BigDecimal getR83_other_borrow() {
		return r83_other_borrow;
	}
	public void setR83_other_borrow(BigDecimal r83_other_borrow) {
		this.r83_other_borrow = r83_other_borrow;
	}
	public BigDecimal getR83_remani_balance_from() {
		return r83_remani_balance_from;
	}
	public void setR83_remani_balance_from(BigDecimal r83_remani_balance_from) {
		this.r83_remani_balance_from = r83_remani_balance_from;
	}
	public BigDecimal getR83_remani_balance_to() {
		return r83_remani_balance_to;
	}
	public void setR83_remani_balance_to(BigDecimal r83_remani_balance_to) {
		this.r83_remani_balance_to = r83_remani_balance_to;
	}
	public String getR84_product() {
		return r84_product;
	}
	public void setR84_product(String r84_product) {
		this.r84_product = r84_product;
	}
	public BigDecimal getR84_inter_bank_place() {
		return r84_inter_bank_place;
	}
	public void setR84_inter_bank_place(BigDecimal r84_inter_bank_place) {
		this.r84_inter_bank_place = r84_inter_bank_place;
	}
	public BigDecimal getR84_inter_bank_borrow() {
		return r84_inter_bank_borrow;
	}
	public void setR84_inter_bank_borrow(BigDecimal r84_inter_bank_borrow) {
		this.r84_inter_bank_borrow = r84_inter_bank_borrow;
	}
	public BigDecimal getR84_other_placement() {
		return r84_other_placement;
	}
	public void setR84_other_placement(BigDecimal r84_other_placement) {
		this.r84_other_placement = r84_other_placement;
	}
	public BigDecimal getR84_other_borrow() {
		return r84_other_borrow;
	}
	public void setR84_other_borrow(BigDecimal r84_other_borrow) {
		this.r84_other_borrow = r84_other_borrow;
	}
	public BigDecimal getR84_remani_balance_from() {
		return r84_remani_balance_from;
	}
	public void setR84_remani_balance_from(BigDecimal r84_remani_balance_from) {
		this.r84_remani_balance_from = r84_remani_balance_from;
	}
	public BigDecimal getR84_remani_balance_to() {
		return r84_remani_balance_to;
	}
	public void setR84_remani_balance_to(BigDecimal r84_remani_balance_to) {
		this.r84_remani_balance_to = r84_remani_balance_to;
	}
	public String getR85_product() {
		return r85_product;
	}
	public void setR85_product(String r85_product) {
		this.r85_product = r85_product;
	}
	public BigDecimal getR85_inter_bank_place() {
		return r85_inter_bank_place;
	}
	public void setR85_inter_bank_place(BigDecimal r85_inter_bank_place) {
		this.r85_inter_bank_place = r85_inter_bank_place;
	}
	public BigDecimal getR85_inter_bank_borrow() {
		return r85_inter_bank_borrow;
	}
	public void setR85_inter_bank_borrow(BigDecimal r85_inter_bank_borrow) {
		this.r85_inter_bank_borrow = r85_inter_bank_borrow;
	}
	public BigDecimal getR85_other_placement() {
		return r85_other_placement;
	}
	public void setR85_other_placement(BigDecimal r85_other_placement) {
		this.r85_other_placement = r85_other_placement;
	}
	public BigDecimal getR85_other_borrow() {
		return r85_other_borrow;
	}
	public void setR85_other_borrow(BigDecimal r85_other_borrow) {
		this.r85_other_borrow = r85_other_borrow;
	}
	public BigDecimal getR85_remani_balance_from() {
		return r85_remani_balance_from;
	}
	public void setR85_remani_balance_from(BigDecimal r85_remani_balance_from) {
		this.r85_remani_balance_from = r85_remani_balance_from;
	}
	public BigDecimal getR85_remani_balance_to() {
		return r85_remani_balance_to;
	}
	public void setR85_remani_balance_to(BigDecimal r85_remani_balance_to) {
		this.r85_remani_balance_to = r85_remani_balance_to;
	}
	public String getR86_product() {
		return r86_product;
	}
	public void setR86_product(String r86_product) {
		this.r86_product = r86_product;
	}
	public BigDecimal getR86_inter_bank_place() {
		return r86_inter_bank_place;
	}
	public void setR86_inter_bank_place(BigDecimal r86_inter_bank_place) {
		this.r86_inter_bank_place = r86_inter_bank_place;
	}
	public BigDecimal getR86_inter_bank_borrow() {
		return r86_inter_bank_borrow;
	}
	public void setR86_inter_bank_borrow(BigDecimal r86_inter_bank_borrow) {
		this.r86_inter_bank_borrow = r86_inter_bank_borrow;
	}
	public BigDecimal getR86_other_placement() {
		return r86_other_placement;
	}
	public void setR86_other_placement(BigDecimal r86_other_placement) {
		this.r86_other_placement = r86_other_placement;
	}
	public BigDecimal getR86_other_borrow() {
		return r86_other_borrow;
	}
	public void setR86_other_borrow(BigDecimal r86_other_borrow) {
		this.r86_other_borrow = r86_other_borrow;
	}
	public BigDecimal getR86_remani_balance_from() {
		return r86_remani_balance_from;
	}
	public void setR86_remani_balance_from(BigDecimal r86_remani_balance_from) {
		this.r86_remani_balance_from = r86_remani_balance_from;
	}
	public BigDecimal getR86_remani_balance_to() {
		return r86_remani_balance_to;
	}
	public void setR86_remani_balance_to(BigDecimal r86_remani_balance_to) {
		this.r86_remani_balance_to = r86_remani_balance_to;
	}
	public String getR87_product() {
		return r87_product;
	}
	public void setR87_product(String r87_product) {
		this.r87_product = r87_product;
	}
	public BigDecimal getR87_inter_bank_place() {
		return r87_inter_bank_place;
	}
	public void setR87_inter_bank_place(BigDecimal r87_inter_bank_place) {
		this.r87_inter_bank_place = r87_inter_bank_place;
	}
	public BigDecimal getR87_inter_bank_borrow() {
		return r87_inter_bank_borrow;
	}
	public void setR87_inter_bank_borrow(BigDecimal r87_inter_bank_borrow) {
		this.r87_inter_bank_borrow = r87_inter_bank_borrow;
	}
	public BigDecimal getR87_other_placement() {
		return r87_other_placement;
	}
	public void setR87_other_placement(BigDecimal r87_other_placement) {
		this.r87_other_placement = r87_other_placement;
	}
	public BigDecimal getR87_other_borrow() {
		return r87_other_borrow;
	}
	public void setR87_other_borrow(BigDecimal r87_other_borrow) {
		this.r87_other_borrow = r87_other_borrow;
	}
	public BigDecimal getR87_remani_balance_from() {
		return r87_remani_balance_from;
	}
	public void setR87_remani_balance_from(BigDecimal r87_remani_balance_from) {
		this.r87_remani_balance_from = r87_remani_balance_from;
	}
	public BigDecimal getR87_remani_balance_to() {
		return r87_remani_balance_to;
	}
	public void setR87_remani_balance_to(BigDecimal r87_remani_balance_to) {
		this.r87_remani_balance_to = r87_remani_balance_to;
	}
	public String getR88_product() {
		return r88_product;
	}
	public void setR88_product(String r88_product) {
		this.r88_product = r88_product;
	}
	public BigDecimal getR88_inter_bank_place() {
		return r88_inter_bank_place;
	}
	public void setR88_inter_bank_place(BigDecimal r88_inter_bank_place) {
		this.r88_inter_bank_place = r88_inter_bank_place;
	}
	public BigDecimal getR88_inter_bank_borrow() {
		return r88_inter_bank_borrow;
	}
	public void setR88_inter_bank_borrow(BigDecimal r88_inter_bank_borrow) {
		this.r88_inter_bank_borrow = r88_inter_bank_borrow;
	}
	public BigDecimal getR88_other_placement() {
		return r88_other_placement;
	}
	public void setR88_other_placement(BigDecimal r88_other_placement) {
		this.r88_other_placement = r88_other_placement;
	}
	public BigDecimal getR88_other_borrow() {
		return r88_other_borrow;
	}
	public void setR88_other_borrow(BigDecimal r88_other_borrow) {
		this.r88_other_borrow = r88_other_borrow;
	}
	public BigDecimal getR88_remani_balance_from() {
		return r88_remani_balance_from;
	}
	public void setR88_remani_balance_from(BigDecimal r88_remani_balance_from) {
		this.r88_remani_balance_from = r88_remani_balance_from;
	}
	public BigDecimal getR88_remani_balance_to() {
		return r88_remani_balance_to;
	}
	public void setR88_remani_balance_to(BigDecimal r88_remani_balance_to) {
		this.r88_remani_balance_to = r88_remani_balance_to;
	}
	public String getR89_product() {
		return r89_product;
	}
	public void setR89_product(String r89_product) {
		this.r89_product = r89_product;
	}
	public BigDecimal getR89_inter_bank_place() {
		return r89_inter_bank_place;
	}
	public void setR89_inter_bank_place(BigDecimal r89_inter_bank_place) {
		this.r89_inter_bank_place = r89_inter_bank_place;
	}
	public BigDecimal getR89_inter_bank_borrow() {
		return r89_inter_bank_borrow;
	}
	public void setR89_inter_bank_borrow(BigDecimal r89_inter_bank_borrow) {
		this.r89_inter_bank_borrow = r89_inter_bank_borrow;
	}
	public BigDecimal getR89_other_placement() {
		return r89_other_placement;
	}
	public void setR89_other_placement(BigDecimal r89_other_placement) {
		this.r89_other_placement = r89_other_placement;
	}
	public BigDecimal getR89_other_borrow() {
		return r89_other_borrow;
	}
	public void setR89_other_borrow(BigDecimal r89_other_borrow) {
		this.r89_other_borrow = r89_other_borrow;
	}
	public BigDecimal getR89_remani_balance_from() {
		return r89_remani_balance_from;
	}
	public void setR89_remani_balance_from(BigDecimal r89_remani_balance_from) {
		this.r89_remani_balance_from = r89_remani_balance_from;
	}
	public BigDecimal getR89_remani_balance_to() {
		return r89_remani_balance_to;
	}
	public void setR89_remani_balance_to(BigDecimal r89_remani_balance_to) {
		this.r89_remani_balance_to = r89_remani_balance_to;
	}
	public String getR90_product() {
		return r90_product;
	}
	public void setR90_product(String r90_product) {
		this.r90_product = r90_product;
	}
	public BigDecimal getR90_inter_bank_place() {
		return r90_inter_bank_place;
	}
	public void setR90_inter_bank_place(BigDecimal r90_inter_bank_place) {
		this.r90_inter_bank_place = r90_inter_bank_place;
	}
	public BigDecimal getR90_inter_bank_borrow() {
		return r90_inter_bank_borrow;
	}
	public void setR90_inter_bank_borrow(BigDecimal r90_inter_bank_borrow) {
		this.r90_inter_bank_borrow = r90_inter_bank_borrow;
	}
	public BigDecimal getR90_other_placement() {
		return r90_other_placement;
	}
	public void setR90_other_placement(BigDecimal r90_other_placement) {
		this.r90_other_placement = r90_other_placement;
	}
	public BigDecimal getR90_other_borrow() {
		return r90_other_borrow;
	}
	public void setR90_other_borrow(BigDecimal r90_other_borrow) {
		this.r90_other_borrow = r90_other_borrow;
	}
	public BigDecimal getR90_remani_balance_from() {
		return r90_remani_balance_from;
	}
	public void setR90_remani_balance_from(BigDecimal r90_remani_balance_from) {
		this.r90_remani_balance_from = r90_remani_balance_from;
	}
	public BigDecimal getR90_remani_balance_to() {
		return r90_remani_balance_to;
	}
	public void setR90_remani_balance_to(BigDecimal r90_remani_balance_to) {
		this.r90_remani_balance_to = r90_remani_balance_to;
	}
	public String getR91_product() {
		return r91_product;
	}
	public void setR91_product(String r91_product) {
		this.r91_product = r91_product;
	}
	public BigDecimal getR91_inter_bank_place() {
		return r91_inter_bank_place;
	}
	public void setR91_inter_bank_place(BigDecimal r91_inter_bank_place) {
		this.r91_inter_bank_place = r91_inter_bank_place;
	}
	public BigDecimal getR91_inter_bank_borrow() {
		return r91_inter_bank_borrow;
	}
	public void setR91_inter_bank_borrow(BigDecimal r91_inter_bank_borrow) {
		this.r91_inter_bank_borrow = r91_inter_bank_borrow;
	}
	public BigDecimal getR91_other_placement() {
		return r91_other_placement;
	}
	public void setR91_other_placement(BigDecimal r91_other_placement) {
		this.r91_other_placement = r91_other_placement;
	}
	public BigDecimal getR91_other_borrow() {
		return r91_other_borrow;
	}
	public void setR91_other_borrow(BigDecimal r91_other_borrow) {
		this.r91_other_borrow = r91_other_borrow;
	}
	public BigDecimal getR91_remani_balance_from() {
		return r91_remani_balance_from;
	}
	public void setR91_remani_balance_from(BigDecimal r91_remani_balance_from) {
		this.r91_remani_balance_from = r91_remani_balance_from;
	}
	public BigDecimal getR91_remani_balance_to() {
		return r91_remani_balance_to;
	}
	public void setR91_remani_balance_to(BigDecimal r91_remani_balance_to) {
		this.r91_remani_balance_to = r91_remani_balance_to;
	}
	public String getR92_product() {
		return r92_product;
	}
	public void setR92_product(String r92_product) {
		this.r92_product = r92_product;
	}
	public BigDecimal getR92_inter_bank_place() {
		return r92_inter_bank_place;
	}
	public void setR92_inter_bank_place(BigDecimal r92_inter_bank_place) {
		this.r92_inter_bank_place = r92_inter_bank_place;
	}
	public BigDecimal getR92_inter_bank_borrow() {
		return r92_inter_bank_borrow;
	}
	public void setR92_inter_bank_borrow(BigDecimal r92_inter_bank_borrow) {
		this.r92_inter_bank_borrow = r92_inter_bank_borrow;
	}
	public BigDecimal getR92_other_placement() {
		return r92_other_placement;
	}
	public void setR92_other_placement(BigDecimal r92_other_placement) {
		this.r92_other_placement = r92_other_placement;
	}
	public BigDecimal getR92_other_borrow() {
		return r92_other_borrow;
	}
	public void setR92_other_borrow(BigDecimal r92_other_borrow) {
		this.r92_other_borrow = r92_other_borrow;
	}
	public BigDecimal getR92_remani_balance_from() {
		return r92_remani_balance_from;
	}
	public void setR92_remani_balance_from(BigDecimal r92_remani_balance_from) {
		this.r92_remani_balance_from = r92_remani_balance_from;
	}
	public BigDecimal getR92_remani_balance_to() {
		return r92_remani_balance_to;
	}
	public void setR92_remani_balance_to(BigDecimal r92_remani_balance_to) {
		this.r92_remani_balance_to = r92_remani_balance_to;
	}
	public String getR93_product() {
		return r93_product;
	}
	public void setR93_product(String r93_product) {
		this.r93_product = r93_product;
	}
	public BigDecimal getR93_inter_bank_place() {
		return r93_inter_bank_place;
	}
	public void setR93_inter_bank_place(BigDecimal r93_inter_bank_place) {
		this.r93_inter_bank_place = r93_inter_bank_place;
	}
	public BigDecimal getR93_inter_bank_borrow() {
		return r93_inter_bank_borrow;
	}
	public void setR93_inter_bank_borrow(BigDecimal r93_inter_bank_borrow) {
		this.r93_inter_bank_borrow = r93_inter_bank_borrow;
	}
	public BigDecimal getR93_other_placement() {
		return r93_other_placement;
	}
	public void setR93_other_placement(BigDecimal r93_other_placement) {
		this.r93_other_placement = r93_other_placement;
	}
	public BigDecimal getR93_other_borrow() {
		return r93_other_borrow;
	}
	public void setR93_other_borrow(BigDecimal r93_other_borrow) {
		this.r93_other_borrow = r93_other_borrow;
	}
	public BigDecimal getR93_remani_balance_from() {
		return r93_remani_balance_from;
	}
	public void setR93_remani_balance_from(BigDecimal r93_remani_balance_from) {
		this.r93_remani_balance_from = r93_remani_balance_from;
	}
	public BigDecimal getR93_remani_balance_to() {
		return r93_remani_balance_to;
	}
	public void setR93_remani_balance_to(BigDecimal r93_remani_balance_to) {
		this.r93_remani_balance_to = r93_remani_balance_to;
	}
	public String getR94_product() {
		return r94_product;
	}
	public void setR94_product(String r94_product) {
		this.r94_product = r94_product;
	}
	public BigDecimal getR94_inter_bank_place() {
		return r94_inter_bank_place;
	}
	public void setR94_inter_bank_place(BigDecimal r94_inter_bank_place) {
		this.r94_inter_bank_place = r94_inter_bank_place;
	}
	public BigDecimal getR94_inter_bank_borrow() {
		return r94_inter_bank_borrow;
	}
	public void setR94_inter_bank_borrow(BigDecimal r94_inter_bank_borrow) {
		this.r94_inter_bank_borrow = r94_inter_bank_borrow;
	}
	public BigDecimal getR94_other_placement() {
		return r94_other_placement;
	}
	public void setR94_other_placement(BigDecimal r94_other_placement) {
		this.r94_other_placement = r94_other_placement;
	}
	public BigDecimal getR94_other_borrow() {
		return r94_other_borrow;
	}
	public void setR94_other_borrow(BigDecimal r94_other_borrow) {
		this.r94_other_borrow = r94_other_borrow;
	}
	public BigDecimal getR94_remani_balance_from() {
		return r94_remani_balance_from;
	}
	public void setR94_remani_balance_from(BigDecimal r94_remani_balance_from) {
		this.r94_remani_balance_from = r94_remani_balance_from;
	}
	public BigDecimal getR94_remani_balance_to() {
		return r94_remani_balance_to;
	}
	public void setR94_remani_balance_to(BigDecimal r94_remani_balance_to) {
		this.r94_remani_balance_to = r94_remani_balance_to;
	}
	public String getR95_product() {
		return r95_product;
	}
	public void setR95_product(String r95_product) {
		this.r95_product = r95_product;
	}
	public BigDecimal getR95_inter_bank_place() {
		return r95_inter_bank_place;
	}
	public void setR95_inter_bank_place(BigDecimal r95_inter_bank_place) {
		this.r95_inter_bank_place = r95_inter_bank_place;
	}
	public BigDecimal getR95_inter_bank_borrow() {
		return r95_inter_bank_borrow;
	}
	public void setR95_inter_bank_borrow(BigDecimal r95_inter_bank_borrow) {
		this.r95_inter_bank_borrow = r95_inter_bank_borrow;
	}
	public BigDecimal getR95_other_placement() {
		return r95_other_placement;
	}
	public void setR95_other_placement(BigDecimal r95_other_placement) {
		this.r95_other_placement = r95_other_placement;
	}
	public BigDecimal getR95_other_borrow() {
		return r95_other_borrow;
	}
	public void setR95_other_borrow(BigDecimal r95_other_borrow) {
		this.r95_other_borrow = r95_other_borrow;
	}
	public BigDecimal getR95_remani_balance_from() {
		return r95_remani_balance_from;
	}
	public void setR95_remani_balance_from(BigDecimal r95_remani_balance_from) {
		this.r95_remani_balance_from = r95_remani_balance_from;
	}
	public BigDecimal getR95_remani_balance_to() {
		return r95_remani_balance_to;
	}
	public void setR95_remani_balance_to(BigDecimal r95_remani_balance_to) {
		this.r95_remani_balance_to = r95_remani_balance_to;
	}
	public String getR96_product() {
		return r96_product;
	}
	public void setR96_product(String r96_product) {
		this.r96_product = r96_product;
	}
	public BigDecimal getR96_inter_bank_place() {
		return r96_inter_bank_place;
	}
	public void setR96_inter_bank_place(BigDecimal r96_inter_bank_place) {
		this.r96_inter_bank_place = r96_inter_bank_place;
	}
	public BigDecimal getR96_inter_bank_borrow() {
		return r96_inter_bank_borrow;
	}
	public void setR96_inter_bank_borrow(BigDecimal r96_inter_bank_borrow) {
		this.r96_inter_bank_borrow = r96_inter_bank_borrow;
	}
	public BigDecimal getR96_other_placement() {
		return r96_other_placement;
	}
	public void setR96_other_placement(BigDecimal r96_other_placement) {
		this.r96_other_placement = r96_other_placement;
	}
	public BigDecimal getR96_other_borrow() {
		return r96_other_borrow;
	}
	public void setR96_other_borrow(BigDecimal r96_other_borrow) {
		this.r96_other_borrow = r96_other_borrow;
	}
	public BigDecimal getR96_remani_balance_from() {
		return r96_remani_balance_from;
	}
	public void setR96_remani_balance_from(BigDecimal r96_remani_balance_from) {
		this.r96_remani_balance_from = r96_remani_balance_from;
	}
	public BigDecimal getR96_remani_balance_to() {
		return r96_remani_balance_to;
	}
	public void setR96_remani_balance_to(BigDecimal r96_remani_balance_to) {
		this.r96_remani_balance_to = r96_remani_balance_to;
	}
	public String getR97_product() {
		return r97_product;
	}
	public void setR97_product(String r97_product) {
		this.r97_product = r97_product;
	}
	public BigDecimal getR97_inter_bank_place() {
		return r97_inter_bank_place;
	}
	public void setR97_inter_bank_place(BigDecimal r97_inter_bank_place) {
		this.r97_inter_bank_place = r97_inter_bank_place;
	}
	public BigDecimal getR97_inter_bank_borrow() {
		return r97_inter_bank_borrow;
	}
	public void setR97_inter_bank_borrow(BigDecimal r97_inter_bank_borrow) {
		this.r97_inter_bank_borrow = r97_inter_bank_borrow;
	}
	public BigDecimal getR97_other_placement() {
		return r97_other_placement;
	}
	public void setR97_other_placement(BigDecimal r97_other_placement) {
		this.r97_other_placement = r97_other_placement;
	}
	public BigDecimal getR97_other_borrow() {
		return r97_other_borrow;
	}
	public void setR97_other_borrow(BigDecimal r97_other_borrow) {
		this.r97_other_borrow = r97_other_borrow;
	}
	public BigDecimal getR97_remani_balance_from() {
		return r97_remani_balance_from;
	}
	public void setR97_remani_balance_from(BigDecimal r97_remani_balance_from) {
		this.r97_remani_balance_from = r97_remani_balance_from;
	}
	public BigDecimal getR97_remani_balance_to() {
		return r97_remani_balance_to;
	}
	public void setR97_remani_balance_to(BigDecimal r97_remani_balance_to) {
		this.r97_remani_balance_to = r97_remani_balance_to;
	}
	public String getR98_product() {
		return r98_product;
	}
	public void setR98_product(String r98_product) {
		this.r98_product = r98_product;
	}
	public BigDecimal getR98_inter_bank_place() {
		return r98_inter_bank_place;
	}
	public void setR98_inter_bank_place(BigDecimal r98_inter_bank_place) {
		this.r98_inter_bank_place = r98_inter_bank_place;
	}
	public BigDecimal getR98_inter_bank_borrow() {
		return r98_inter_bank_borrow;
	}
	public void setR98_inter_bank_borrow(BigDecimal r98_inter_bank_borrow) {
		this.r98_inter_bank_borrow = r98_inter_bank_borrow;
	}
	public BigDecimal getR98_other_placement() {
		return r98_other_placement;
	}
	public void setR98_other_placement(BigDecimal r98_other_placement) {
		this.r98_other_placement = r98_other_placement;
	}
	public BigDecimal getR98_other_borrow() {
		return r98_other_borrow;
	}
	public void setR98_other_borrow(BigDecimal r98_other_borrow) {
		this.r98_other_borrow = r98_other_borrow;
	}
	public BigDecimal getR98_remani_balance_from() {
		return r98_remani_balance_from;
	}
	public void setR98_remani_balance_from(BigDecimal r98_remani_balance_from) {
		this.r98_remani_balance_from = r98_remani_balance_from;
	}
	public BigDecimal getR98_remani_balance_to() {
		return r98_remani_balance_to;
	}
	public void setR98_remani_balance_to(BigDecimal r98_remani_balance_to) {
		this.r98_remani_balance_to = r98_remani_balance_to;
	}
	public String getR99_product() {
		return r99_product;
	}
	public void setR99_product(String r99_product) {
		this.r99_product = r99_product;
	}
	public BigDecimal getR99_inter_bank_place() {
		return r99_inter_bank_place;
	}
	public void setR99_inter_bank_place(BigDecimal r99_inter_bank_place) {
		this.r99_inter_bank_place = r99_inter_bank_place;
	}
	public BigDecimal getR99_inter_bank_borrow() {
		return r99_inter_bank_borrow;
	}
	public void setR99_inter_bank_borrow(BigDecimal r99_inter_bank_borrow) {
		this.r99_inter_bank_borrow = r99_inter_bank_borrow;
	}
	public BigDecimal getR99_other_placement() {
		return r99_other_placement;
	}
	public void setR99_other_placement(BigDecimal r99_other_placement) {
		this.r99_other_placement = r99_other_placement;
	}
	public BigDecimal getR99_other_borrow() {
		return r99_other_borrow;
	}
	public void setR99_other_borrow(BigDecimal r99_other_borrow) {
		this.r99_other_borrow = r99_other_borrow;
	}
	public BigDecimal getR99_remani_balance_from() {
		return r99_remani_balance_from;
	}
	public void setR99_remani_balance_from(BigDecimal r99_remani_balance_from) {
		this.r99_remani_balance_from = r99_remani_balance_from;
	}
	public BigDecimal getR99_remani_balance_to() {
		return r99_remani_balance_to;
	}
	public void setR99_remani_balance_to(BigDecimal r99_remani_balance_to) {
		this.r99_remani_balance_to = r99_remani_balance_to;
	}
	public String getR100_product() {
		return r100_product;
	}
	public void setR100_product(String r100_product) {
		this.r100_product = r100_product;
	}
	public BigDecimal getR100_inter_bank_place() {
		return r100_inter_bank_place;
	}
	public void setR100_inter_bank_place(BigDecimal r100_inter_bank_place) {
		this.r100_inter_bank_place = r100_inter_bank_place;
	}
	public BigDecimal getR100_inter_bank_borrow() {
		return r100_inter_bank_borrow;
	}
	public void setR100_inter_bank_borrow(BigDecimal r100_inter_bank_borrow) {
		this.r100_inter_bank_borrow = r100_inter_bank_borrow;
	}
	public BigDecimal getR100_other_placement() {
		return r100_other_placement;
	}
	public void setR100_other_placement(BigDecimal r100_other_placement) {
		this.r100_other_placement = r100_other_placement;
	}
	public BigDecimal getR100_other_borrow() {
		return r100_other_borrow;
	}
	public void setR100_other_borrow(BigDecimal r100_other_borrow) {
		this.r100_other_borrow = r100_other_borrow;
	}
	public BigDecimal getR100_remani_balance_from() {
		return r100_remani_balance_from;
	}
	public void setR100_remani_balance_from(BigDecimal r100_remani_balance_from) {
		this.r100_remani_balance_from = r100_remani_balance_from;
	}
	public BigDecimal getR100_remani_balance_to() {
		return r100_remani_balance_to;
	}
	public void setR100_remani_balance_to(BigDecimal r100_remani_balance_to) {
		this.r100_remani_balance_to = r100_remani_balance_to;
	}
	public String getR101_product() {
		return r101_product;
	}
	public void setR101_product(String r101_product) {
		this.r101_product = r101_product;
	}
	public BigDecimal getR101_inter_bank_place() {
		return r101_inter_bank_place;
	}
	public void setR101_inter_bank_place(BigDecimal r101_inter_bank_place) {
		this.r101_inter_bank_place = r101_inter_bank_place;
	}
	public BigDecimal getR101_inter_bank_borrow() {
		return r101_inter_bank_borrow;
	}
	public void setR101_inter_bank_borrow(BigDecimal r101_inter_bank_borrow) {
		this.r101_inter_bank_borrow = r101_inter_bank_borrow;
	}
	public BigDecimal getR101_other_placement() {
		return r101_other_placement;
	}
	public void setR101_other_placement(BigDecimal r101_other_placement) {
		this.r101_other_placement = r101_other_placement;
	}
	public BigDecimal getR101_other_borrow() {
		return r101_other_borrow;
	}
	public void setR101_other_borrow(BigDecimal r101_other_borrow) {
		this.r101_other_borrow = r101_other_borrow;
	}
	public BigDecimal getR101_remani_balance_from() {
		return r101_remani_balance_from;
	}
	public void setR101_remani_balance_from(BigDecimal r101_remani_balance_from) {
		this.r101_remani_balance_from = r101_remani_balance_from;
	}
	public BigDecimal getR101_remani_balance_to() {
		return r101_remani_balance_to;
	}
	public void setR101_remani_balance_to(BigDecimal r101_remani_balance_to) {
		this.r101_remani_balance_to = r101_remani_balance_to;
	}
	public String getR102_product() {
		return r102_product;
	}
	public void setR102_product(String r102_product) {
		this.r102_product = r102_product;
	}
	public BigDecimal getR102_inter_bank_place() {
		return r102_inter_bank_place;
	}
	public void setR102_inter_bank_place(BigDecimal r102_inter_bank_place) {
		this.r102_inter_bank_place = r102_inter_bank_place;
	}
	public BigDecimal getR102_inter_bank_borrow() {
		return r102_inter_bank_borrow;
	}
	public void setR102_inter_bank_borrow(BigDecimal r102_inter_bank_borrow) {
		this.r102_inter_bank_borrow = r102_inter_bank_borrow;
	}
	public BigDecimal getR102_other_placement() {
		return r102_other_placement;
	}
	public void setR102_other_placement(BigDecimal r102_other_placement) {
		this.r102_other_placement = r102_other_placement;
	}
	public BigDecimal getR102_other_borrow() {
		return r102_other_borrow;
	}
	public void setR102_other_borrow(BigDecimal r102_other_borrow) {
		this.r102_other_borrow = r102_other_borrow;
	}
	public BigDecimal getR102_remani_balance_from() {
		return r102_remani_balance_from;
	}
	public void setR102_remani_balance_from(BigDecimal r102_remani_balance_from) {
		this.r102_remani_balance_from = r102_remani_balance_from;
	}
	public BigDecimal getR102_remani_balance_to() {
		return r102_remani_balance_to;
	}
	public void setR102_remani_balance_to(BigDecimal r102_remani_balance_to) {
		this.r102_remani_balance_to = r102_remani_balance_to;
	}
	public String getR103_product() {
		return r103_product;
	}
	public void setR103_product(String r103_product) {
		this.r103_product = r103_product;
	}
	public BigDecimal getR103_inter_bank_place() {
		return r103_inter_bank_place;
	}
	public void setR103_inter_bank_place(BigDecimal r103_inter_bank_place) {
		this.r103_inter_bank_place = r103_inter_bank_place;
	}
	public BigDecimal getR103_inter_bank_borrow() {
		return r103_inter_bank_borrow;
	}
	public void setR103_inter_bank_borrow(BigDecimal r103_inter_bank_borrow) {
		this.r103_inter_bank_borrow = r103_inter_bank_borrow;
	}
	public BigDecimal getR103_other_placement() {
		return r103_other_placement;
	}
	public void setR103_other_placement(BigDecimal r103_other_placement) {
		this.r103_other_placement = r103_other_placement;
	}
	public BigDecimal getR103_other_borrow() {
		return r103_other_borrow;
	}
	public void setR103_other_borrow(BigDecimal r103_other_borrow) {
		this.r103_other_borrow = r103_other_borrow;
	}
	public BigDecimal getR103_remani_balance_from() {
		return r103_remani_balance_from;
	}
	public void setR103_remani_balance_from(BigDecimal r103_remani_balance_from) {
		this.r103_remani_balance_from = r103_remani_balance_from;
	}
	public BigDecimal getR103_remani_balance_to() {
		return r103_remani_balance_to;
	}
	public void setR103_remani_balance_to(BigDecimal r103_remani_balance_to) {
		this.r103_remani_balance_to = r103_remani_balance_to;
	}
	public String getRtot_product() {
		return rtot_product;
	}
	public void setRtot_product(String rtot_product) {
		this.rtot_product = rtot_product;
	}
	public BigDecimal getRtot_inter_bank_place() {
		return rtot_inter_bank_place;
	}
	public void setRtot_inter_bank_place(BigDecimal rtot_inter_bank_place) {
		this.rtot_inter_bank_place = rtot_inter_bank_place;
	}
	public BigDecimal getRtot_inter_bank_borrow() {
		return rtot_inter_bank_borrow;
	}
	public void setRtot_inter_bank_borrow(BigDecimal rtot_inter_bank_borrow) {
		this.rtot_inter_bank_borrow = rtot_inter_bank_borrow;
	}
	public BigDecimal getRtot_other_placement() {
		return rtot_other_placement;
	}
	public void setRtot_other_placement(BigDecimal rtot_other_placement) {
		this.rtot_other_placement = rtot_other_placement;
	}
	public BigDecimal getRtot_other_borrow() {
		return rtot_other_borrow;
	}
	public void setRtot_other_borrow(BigDecimal rtot_other_borrow) {
		this.rtot_other_borrow = rtot_other_borrow;
	}
	public BigDecimal getRtot_remani_balance_from() {
		return rtot_remani_balance_from;
	}
	public void setRtot_remani_balance_from(BigDecimal rtot_remani_balance_from) {
		this.rtot_remani_balance_from = rtot_remani_balance_from;
	}
	public BigDecimal getRtot_remani_balance_to() {
		return rtot_remani_balance_to;
	}
	public void setRtot_remani_balance_to(BigDecimal rtot_remani_balance_to) {
		this.rtot_remani_balance_to = rtot_remani_balance_to;
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
	public BRF34_ENTITY() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}