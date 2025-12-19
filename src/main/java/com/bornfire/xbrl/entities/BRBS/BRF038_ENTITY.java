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
@Table(name="BRF38_SUMMARYTABLE")
public class BRF038_ENTITY {
	
	private String	r10_north_american_countries;
	private BigDecimal	r10_outward_family;
	private BigDecimal	r10_outward_investment;
	private BigDecimal	r10_outward_trade;
	private BigDecimal	r10_outward_other;
	private BigDecimal	r10_outward_total;
	private BigDecimal	r10_inward_family;
	private BigDecimal	r10_inward_investment;
	private BigDecimal	r10_inward_trade;
	private BigDecimal	r10_inward_other;
	private BigDecimal	r10_inward_total;
	private String	r11_north_american_countries1;
	private BigDecimal	r11_outward_family;
	private BigDecimal	r11_outward_investment;
	private BigDecimal	r11_outward_trade;
	private BigDecimal	r11_outward_other;
	private BigDecimal	r11_outward_total;
	private BigDecimal	r11_inward_family;
	private BigDecimal	r11_inward_investment;
	private BigDecimal	r11_inward_trade;
	private BigDecimal	r11_inward_other;
	private BigDecimal	r11_inward_total;
	private String	r12_north_american_countries2;
	private BigDecimal	r12_outward_family;
	private BigDecimal	r12_outward_investment;
	private BigDecimal	r12_outward_trade;
	private BigDecimal	r12_outward_other;
	private BigDecimal	r12_outward_total;
	private BigDecimal	r12_inward_family;
	private BigDecimal	r12_inward_investment;
	private BigDecimal	r12_inward_trade;
	private BigDecimal	r12_inward_other;
	private BigDecimal	r12_inward_total;
	private String	r13_european_countries;
	private BigDecimal	r13_outward_family;
	private BigDecimal	r13_outward_investment;
	private BigDecimal	r13_outward_trade;
	private BigDecimal	r13_outward_other;
	private BigDecimal	r13_outward_total;
	private BigDecimal	r13_inward_family;
	private BigDecimal	r13_inward_investment;
	private BigDecimal	r13_inward_trade;
	private BigDecimal	r13_inward_other;
	private BigDecimal	r13_inward_total;
	private String	r14_european_countries1;
	private BigDecimal	r14_outward_family;
	private BigDecimal	r14_outward_investment;
	private BigDecimal	r14_outward_trade;
	private BigDecimal	r14_outward_other;
	private BigDecimal	r14_outward_total;
	private BigDecimal	r14_inward_family;
	private BigDecimal	r14_inward_investment;
	private BigDecimal	r14_inward_trade;
	private BigDecimal	r14_inward_other;
	private BigDecimal	r14_inward_total;
	private String	r15_european_countries2;
	private BigDecimal	r15_outward_family;
	private BigDecimal	r15_outward_investment;
	private BigDecimal	r15_outward_trade;
	private BigDecimal	r15_outward_other;
	private BigDecimal	r15_outward_total;
	private BigDecimal	r15_inward_family;
	private BigDecimal	r15_inward_investment;
	private BigDecimal	r15_inward_trade;
	private BigDecimal	r15_inward_other;
	private BigDecimal	r15_inward_total;
	private String	r16_european_countries3;
	private BigDecimal	r16_outward_family;
	private BigDecimal	r16_outward_investment;
	private BigDecimal	r16_outward_trade;
	private BigDecimal	r16_outward_other;
	private BigDecimal	r16_outward_total;
	private BigDecimal	r16_inward_family;
	private BigDecimal	r16_inward_investment;
	private BigDecimal	r16_inward_trade;
	private BigDecimal	r16_inward_other;
	private BigDecimal	r16_inward_total;
	private String	r17_european_countries4;
	private BigDecimal	r17_outward_family;
	private BigDecimal	r17_outward_investment;
	private BigDecimal	r17_outward_trade;
	private BigDecimal	r17_outward_other;
	private BigDecimal	r17_outward_total;
	private BigDecimal	r17_inward_family;
	private BigDecimal	r17_inward_investment;
	private BigDecimal	r17_inward_trade;
	private BigDecimal	r17_inward_other;
	private BigDecimal	r17_inward_total;
	private String	r18_european_countries5;
	private BigDecimal	r18_outward_family;
	private BigDecimal	r18_outward_investment;
	private BigDecimal	r18_outward_trade;
	private BigDecimal	r18_outward_other;
	private BigDecimal	r18_outward_total;
	private BigDecimal	r18_inward_family;
	private BigDecimal	r18_inward_investment;
	private BigDecimal	r18_inward_trade;
	private BigDecimal	r18_inward_other;
	private BigDecimal	r18_inward_total;
	private String	r19_european_countries6;
	private BigDecimal	r19_outward_family;
	private BigDecimal	r19_outward_investment;
	private BigDecimal	r19_outward_trade;
	private BigDecimal	r19_outward_other;
	private BigDecimal	r19_outward_total;
	private BigDecimal	r19_inward_family;
	private BigDecimal	r19_inward_investment;
	private BigDecimal	r19_inward_trade;
	private BigDecimal	r19_inward_other;
	private BigDecimal	r19_inward_total;
	private String	r20_european_countries7;
	private BigDecimal	r20_outward_family;
	private BigDecimal	r20_outward_investment;
	private BigDecimal	r20_outward_trade;
	private BigDecimal	r20_outward_other;
	private BigDecimal	r20_outward_total;
	private BigDecimal	r20_inward_family;
	private BigDecimal	r20_inward_investment;
	private BigDecimal	r20_inward_trade;
	private BigDecimal	r20_inward_other;
	private BigDecimal	r20_inward_total;
	private String	r21_european_countries8;
	private BigDecimal	r21_outward_family;
	private BigDecimal	r21_outward_investment;
	private BigDecimal	r21_outward_trade;
	private BigDecimal	r21_outward_other;
	private BigDecimal	r21_outward_total;
	private BigDecimal	r21_inward_family;
	private BigDecimal	r21_inward_investment;
	private BigDecimal	r21_inward_trade;
	private BigDecimal	r21_inward_other;
	private BigDecimal	r21_inward_total;
	private String	r22_european_countries9;
	private BigDecimal	r22_outward_family;
	private BigDecimal	r22_outward_investment;
	private BigDecimal	r22_outward_trade;
	private BigDecimal	r22_outward_other;
	private BigDecimal	r22_outward_total;
	private BigDecimal	r22_inward_family;
	private BigDecimal	r22_inward_investment;
	private BigDecimal	r22_inward_trade;
	private BigDecimal	r22_inward_other;
	private BigDecimal	r22_inward_total;
	private String	r23_european_countries10;
	private BigDecimal	r23_outward_family;
	private BigDecimal	r23_outward_investment;
	private BigDecimal	r23_outward_trade;
	private BigDecimal	r23_outward_other;
	private BigDecimal	r23_outward_total;
	private BigDecimal	r23_inward_family;
	private BigDecimal	r23_inward_investment;
	private BigDecimal	r23_inward_trade;
	private BigDecimal	r23_inward_other;
	private BigDecimal	r23_inward_total;
	private String	r24_european_countries11;
	private BigDecimal	r24_outward_family;
	private BigDecimal	r24_outward_investment;
	private BigDecimal	r24_outward_trade;
	private BigDecimal	r24_outward_other;
	private BigDecimal	r24_outward_total;
	private BigDecimal	r24_inward_family;
	private BigDecimal	r24_inward_investment;
	private BigDecimal	r24_inward_trade;
	private BigDecimal	r24_inward_other;
	private BigDecimal	r24_inward_total;
	private String	r25_european_countries12;
	private BigDecimal	r25_outward_family;
	private BigDecimal	r25_outward_investment;
	private BigDecimal	r25_outward_trade;
	private BigDecimal	r25_outward_other;
	private BigDecimal	r25_outward_total;
	private BigDecimal	r25_inward_family;
	private BigDecimal	r25_inward_investment;
	private BigDecimal	r25_inward_trade;
	private BigDecimal	r25_inward_other;
	private BigDecimal	r25_inward_total;
	private String	r26_european_countries13;
	private BigDecimal	r26_outward_family;
	private BigDecimal	r26_outward_investment;
	private BigDecimal	r26_outward_trade;
	private BigDecimal	r26_outward_other;
	private BigDecimal	r26_outward_total;
	private BigDecimal	r26_inward_family;
	private BigDecimal	r26_inward_investment;
	private BigDecimal	r26_inward_trade;
	private BigDecimal	r26_inward_other;
	private BigDecimal	r26_inward_total;
	private String	r27_european_countries14;
	private BigDecimal	r27_outward_family;
	private BigDecimal	r27_outward_investment;
	private BigDecimal	r27_outward_trade;
	private BigDecimal	r27_outward_other;
	private BigDecimal	r27_outward_total;
	private BigDecimal	r27_inward_family;
	private BigDecimal	r27_inward_investment;
	private BigDecimal	r27_inward_trade;
	private BigDecimal	r27_inward_other;
	private BigDecimal	r27_inward_total;
	private String	r28_european_countries15;
	private BigDecimal	r28_outward_family;
	private BigDecimal	r28_outward_investment;
	private BigDecimal	r28_outward_trade;
	private BigDecimal	r28_outward_other;
	private BigDecimal	r28_outward_total;
	private BigDecimal	r28_inward_family;
	private BigDecimal	r28_inward_investment;
	private BigDecimal	r28_inward_trade;
	private BigDecimal	r28_inward_other;
	private BigDecimal	r28_inward_total;
	private String	r29_european_countries16;
	private BigDecimal	r29_outward_family;
	private BigDecimal	r29_outward_investment;
	private BigDecimal	r29_outward_trade;
	private BigDecimal	r29_outward_other;
	private BigDecimal	r29_outward_total;
	private BigDecimal	r29_inward_family;
	private BigDecimal	r29_inward_investment;
	private BigDecimal	r29_inward_trade;
	private BigDecimal	r29_inward_other;
	private BigDecimal	r29_inward_total;
	private String	r30_european_countries17;
	private BigDecimal	r30_outward_family;
	private BigDecimal	r30_outward_investment;
	private BigDecimal	r30_outward_trade;
	private BigDecimal	r30_outward_other;
	private BigDecimal	r30_outward_total;
	private BigDecimal	r30_inward_family;
	private BigDecimal	r30_inward_investment;
	private BigDecimal	r30_inward_trade;
	private BigDecimal	r30_inward_other;
	private BigDecimal	r30_inward_total;
	private String	r31_european_countries18;
	private BigDecimal	r31_outward_family;
	private BigDecimal	r31_outward_investment;
	private BigDecimal	r31_outward_trade;
	private BigDecimal	r31_outward_other;
	private BigDecimal	r31_outward_total;
	private BigDecimal	r31_inward_family;
	private BigDecimal	r31_inward_investment;
	private BigDecimal	r31_inward_trade;
	private BigDecimal	r31_inward_other;
	private BigDecimal	r31_inward_total;
	private String	r32_european_countries19;
	private BigDecimal	r32_outward_family;
	private BigDecimal	r32_outward_investment;
	private BigDecimal	r32_outward_trade;
	private BigDecimal	r32_outward_other;
	private BigDecimal	r32_outward_total;
	private BigDecimal	r32_inward_family;
	private BigDecimal	r32_inward_investment;
	private BigDecimal	r32_inward_trade;
	private BigDecimal	r32_inward_other;
	private BigDecimal	r32_inward_total;
	private String	r33_european_countries20;
	private BigDecimal	r33_outward_family;
	private BigDecimal	r33_outward_investment;
	private BigDecimal	r33_outward_trade;
	private BigDecimal	r33_outward_other;
	private BigDecimal	r33_outward_total;
	private BigDecimal	r33_inward_family;
	private BigDecimal	r33_inward_investment;
	private BigDecimal	r33_inward_trade;
	private BigDecimal	r33_inward_other;
	private BigDecimal	r33_inward_total;
	private String	r34_european_countries21;
	private BigDecimal	r34_outward_family;
	private BigDecimal	r34_outward_investment;
	private BigDecimal	r34_outward_trade;
	private BigDecimal	r34_outward_other;
	private BigDecimal	r34_outward_total;
	private BigDecimal	r34_inward_family;
	private BigDecimal	r34_inward_investment;
	private BigDecimal	r34_inward_trade;
	private BigDecimal	r34_inward_other;
	private BigDecimal	r34_inward_total;
	private String	r35_gcc_countries;
	private BigDecimal	r35_outward_family;
	private BigDecimal	r35_outward_investment;
	private BigDecimal	r35_outward_trade;
	private BigDecimal	r35_outward_other;
	private BigDecimal	r35_outward_total;
	private BigDecimal	r35_inward_family;
	private BigDecimal	r35_inward_investment;
	private BigDecimal	r35_inward_trade;
	private BigDecimal	r35_inward_other;
	private BigDecimal	r35_inward_total;
	private String	r36_gcc_countries1;
	private BigDecimal	r36_outward_family;
	private BigDecimal	r36_outward_investment;
	private BigDecimal	r36_outward_trade;
	private BigDecimal	r36_outward_other;
	private BigDecimal	r36_outward_total;
	private BigDecimal	r36_inward_family;
	private BigDecimal	r36_inward_investment;
	private BigDecimal	r36_inward_trade;
	private BigDecimal	r36_inward_other;
	private BigDecimal	r36_inward_total;
	private String	r37_gcc_countries2;
	private BigDecimal	r37_outward_family;
	private BigDecimal	r37_outward_investment;
	private BigDecimal	r37_outward_trade;
	private BigDecimal	r37_outward_other;
	private BigDecimal	r37_outward_total;
	private BigDecimal	r37_inward_family;
	private BigDecimal	r37_inward_investment;
	private BigDecimal	r37_inward_trade;
	private BigDecimal	r37_inward_other;
	private BigDecimal	r37_inward_total;
	private String	r38_gcc_countries3;
	private BigDecimal	r38_outward_family;
	private BigDecimal	r38_outward_investment;
	private BigDecimal	r38_outward_trade;
	private BigDecimal	r38_outward_other;
	private BigDecimal	r38_outward_total;
	private BigDecimal	r38_inward_family;
	private BigDecimal	r38_inward_investment;
	private BigDecimal	r38_inward_trade;
	private BigDecimal	r38_inward_other;
	private BigDecimal	r38_inward_total;
	private String	r39_gcc_countries4;
	private BigDecimal	r39_outward_family;
	private BigDecimal	r39_outward_investment;
	private BigDecimal	r39_outward_trade;
	private BigDecimal	r39_outward_other;
	private BigDecimal	r39_outward_total;
	private BigDecimal	r39_inward_family;
	private BigDecimal	r39_inward_investment;
	private BigDecimal	r39_inward_trade;
	private BigDecimal	r39_inward_other;
	private BigDecimal	r39_inward_total;
	private String	r40_gcc_countries5;
	private BigDecimal	r40_outward_family;
	private BigDecimal	r40_outward_investment;
	private BigDecimal	r40_outward_trade;
	private BigDecimal	r40_outward_other;
	private BigDecimal	r40_outward_total;
	private BigDecimal	r40_inward_family;
	private BigDecimal	r40_inward_investment;
	private BigDecimal	r40_inward_trade;
	private BigDecimal	r40_inward_other;
	private BigDecimal	r40_inward_total;
	private String	r41_mena_countries;
	private BigDecimal	r41_outward_family;
	private BigDecimal	r41_outward_investment;
	private BigDecimal	r41_outward_trade;
	private BigDecimal	r41_outward_other;
	private BigDecimal	r41_outward_total;
	private BigDecimal	r41_inward_family;
	private BigDecimal	r41_inward_investment;
	private BigDecimal	r41_inward_trade;
	private BigDecimal	r41_inward_other;
	private BigDecimal	r41_inward_total;
	private String	r42_mena_countries1;
	private BigDecimal	r42_outward_family;
	private BigDecimal	r42_outward_investment;
	private BigDecimal	r42_outward_trade;
	private BigDecimal	r42_outward_other;
	private BigDecimal	r42_outward_total;
	private BigDecimal	r42_inward_family;
	private BigDecimal	r42_inward_investment;
	private BigDecimal	r42_inward_trade;
	private BigDecimal	r42_inward_other;
	private BigDecimal	r42_inward_total;
	private String	r43_mena_countries2;
	private BigDecimal	r43_outward_family;
	private BigDecimal	r43_outward_investment;
	private BigDecimal	r43_outward_trade;
	private BigDecimal	r43_outward_other;
	private BigDecimal	r43_outward_total;
	private BigDecimal	r43_inward_family;
	private BigDecimal	r43_inward_investment;
	private BigDecimal	r43_inward_trade;
	private BigDecimal	r43_inward_other;
	private BigDecimal	r43_inward_total;
	private String	r44_mena_countries3;
	private BigDecimal	r44_outward_family;
	private BigDecimal	r44_outward_investment;
	private BigDecimal	r44_outward_trade;
	private BigDecimal	r44_outward_other;
	private BigDecimal	r44_outward_total;
	private BigDecimal	r44_inward_family;
	private BigDecimal	r44_inward_investment;
	private BigDecimal	r44_inward_trade;
	private BigDecimal	r44_inward_other;
	private BigDecimal	r44_inward_total;
	private String	r45_mena_countries4;
	private BigDecimal	r45_outward_family;
	private BigDecimal	r45_outward_investment;
	private BigDecimal	r45_outward_trade;
	private BigDecimal	r45_outward_other;
	private BigDecimal	r45_outward_total;
	private BigDecimal	r45_inward_family;
	private BigDecimal	r45_inward_investment;
	private BigDecimal	r45_inward_trade;
	private BigDecimal	r45_inward_other;
	private BigDecimal	r45_inward_total;
	private String	r46_mena_countries5;
	private BigDecimal	r46_outward_family;
	private BigDecimal	r46_outward_investment;
	private BigDecimal	r46_outward_trade;
	private BigDecimal	r46_outward_other;
	private BigDecimal	r46_outward_total;
	private BigDecimal	r46_inward_family;
	private BigDecimal	r46_inward_investment;
	private BigDecimal	r46_inward_trade;
	private BigDecimal	r46_inward_other;
	private BigDecimal	r46_inward_total;
	private String	r47_mena_countries6;
	private BigDecimal	r47_outward_family;
	private BigDecimal	r47_outward_investment;
	private BigDecimal	r47_outward_trade;
	private BigDecimal	r47_outward_other;
	private BigDecimal	r47_outward_total;
	private BigDecimal	r47_inward_family;
	private BigDecimal	r47_inward_investment;
	private BigDecimal	r47_inward_trade;
	private BigDecimal	r47_inward_other;
	private BigDecimal	r47_inward_total;
	private String	r48_mena_countries7;
	private BigDecimal	r48_outward_family;
	private BigDecimal	r48_outward_investment;
	private BigDecimal	r48_outward_trade;
	private BigDecimal	r48_outward_other;
	private BigDecimal	r48_outward_total;
	private BigDecimal	r48_inward_family;
	private BigDecimal	r48_inward_investment;
	private BigDecimal	r48_inward_trade;
	private BigDecimal	r48_inward_other;
	private BigDecimal	r48_inward_total;
	private String	r49_mena_countries8;
	private BigDecimal	r49_outward_family;
	private BigDecimal	r49_outward_investment;
	private BigDecimal	r49_outward_trade;
	private BigDecimal	r49_outward_other;
	private BigDecimal	r49_outward_total;
	private BigDecimal	r49_inward_family;
	private BigDecimal	r49_inward_investment;
	private BigDecimal	r49_inward_trade;
	private BigDecimal	r49_inward_other;
	private BigDecimal	r49_inward_total;
	private String	r50_mena_countries9;
	private BigDecimal	r50_outward_family;
	private BigDecimal	r50_outward_investment;
	private BigDecimal	r50_outward_trade;
	private BigDecimal	r50_outward_other;
	private BigDecimal	r50_outward_total;
	private BigDecimal	r50_inward_family;
	private BigDecimal	r50_inward_investment;
	private BigDecimal	r50_inward_trade;
	private BigDecimal	r50_inward_other;
	private BigDecimal	r50_inward_total;
	private String	r51_mena_countries10;
	private BigDecimal	r51_outward_family;
	private BigDecimal	r51_outward_investment;
	private BigDecimal	r51_outward_trade;
	private BigDecimal	r51_outward_other;
	private BigDecimal	r51_outward_total;
	private BigDecimal	r51_inward_family;
	private BigDecimal	r51_inward_investment;
	private BigDecimal	r51_inward_trade;
	private BigDecimal	r51_inward_other;
	private BigDecimal	r51_inward_total;
	private String	r52_sub_saharan_countries;
	private BigDecimal	r52_outward_family;
	private BigDecimal	r52_outward_investment;
	private BigDecimal	r52_outward_trade;
	private BigDecimal	r52_outward_other;
	private BigDecimal	r52_outward_total;
	private BigDecimal	r52_inward_family;
	private BigDecimal	r52_inward_investment;
	private BigDecimal	r52_inward_trade;
	private BigDecimal	r52_inward_other;
	private BigDecimal	r52_inward_total;
	private String	r53_sub_saharan_countries1;
	private BigDecimal	r53_outward_family;
	private BigDecimal	r53_outward_investment;
	private BigDecimal	r53_outward_trade;
	private BigDecimal	r53_outward_other;
	private BigDecimal	r53_outward_total;
	private BigDecimal	r53_inward_family;
	private BigDecimal	r53_inward_investment;
	private BigDecimal	r53_inward_trade;
	private BigDecimal	r53_inward_other;
	private BigDecimal	r53_inward_total;
	private String	r54_sub_saharan_countries2;
	private BigDecimal	r54_outward_family;
	private BigDecimal	r54_outward_investment;
	private BigDecimal	r54_outward_trade;
	private BigDecimal	r54_outward_other;
	private BigDecimal	r54_outward_total;
	private BigDecimal	r54_inward_family;
	private BigDecimal	r54_inward_investment;
	private BigDecimal	r54_inward_trade;
	private BigDecimal	r54_inward_other;
	private BigDecimal	r54_inward_total;
	private String	r55_sub_saharan_countries3;
	private BigDecimal	r55_outward_family;
	private BigDecimal	r55_outward_investment;
	private BigDecimal	r55_outward_trade;
	private BigDecimal	r55_outward_other;
	private BigDecimal	r55_outward_total;
	private BigDecimal	r55_inward_family;
	private BigDecimal	r55_inward_investment;
	private BigDecimal	r55_inward_trade;
	private BigDecimal	r55_inward_other;
	private BigDecimal	r55_inward_total;
	private String	r56_sub_saharan_countries4;
	private BigDecimal	r56_outward_family;
	private BigDecimal	r56_outward_investment;
	private BigDecimal	r56_outward_trade;
	private BigDecimal	r56_outward_other;
	private BigDecimal	r56_outward_total;
	private BigDecimal	r56_inward_family;
	private BigDecimal	r56_inward_investment;
	private BigDecimal	r56_inward_trade;
	private BigDecimal	r56_inward_other;
	private BigDecimal	r56_inward_total;
	private String	r57_sub_saharan_countries5;
	private BigDecimal	r57_outward_family;
	private BigDecimal	r57_outward_investment;
	private BigDecimal	r57_outward_trade;
	private BigDecimal	r57_outward_other;
	private BigDecimal	r57_outward_total;
	private BigDecimal	r57_inward_family;
	private BigDecimal	r57_inward_investment;
	private BigDecimal	r57_inward_trade;
	private BigDecimal	r57_inward_other;
	private BigDecimal	r57_inward_total;
	private String	r58_asian_countries;
	private BigDecimal	r58_outward_family;
	private BigDecimal	r58_outward_investment;
	private BigDecimal	r58_outward_trade;
	private BigDecimal	r58_outward_other;
	private BigDecimal	r58_outward_total;
	private BigDecimal	r58_inward_family;
	private BigDecimal	r58_inward_investment;
	private BigDecimal	r58_inward_trade;
	private BigDecimal	r58_inward_other;
	private BigDecimal	r58_inward_total;
	private String	r59_asian_countries1;
	private BigDecimal	r59_outward_family;
	private BigDecimal	r59_outward_investment;
	private BigDecimal	r59_outward_trade;
	private BigDecimal	r59_outward_other;
	private BigDecimal	r59_outward_total;
	private BigDecimal	r59_inward_family;
	private BigDecimal	r59_inward_investment;
	private BigDecimal	r59_inward_trade;
	private BigDecimal	r59_inward_other;
	private BigDecimal	r59_inward_total;
	private String	r60_asian_countries2;
	private BigDecimal	r60_outward_family;
	private BigDecimal	r60_outward_investment;
	private BigDecimal	r60_outward_trade;
	private BigDecimal	r60_outward_other;
	private BigDecimal	r60_outward_total;
	private BigDecimal	r60_inward_family;
	private BigDecimal	r60_inward_investment;
	private BigDecimal	r60_inward_trade;
	private BigDecimal	r60_inward_other;
	private BigDecimal	r60_inward_total;
	private String	r61_asian_countries3;
	private BigDecimal	r61_outward_family;
	private BigDecimal	r61_outward_investment;
	private BigDecimal	r61_outward_trade;
	private BigDecimal	r61_outward_other;
	private BigDecimal	r61_outward_total;
	private BigDecimal	r61_inward_family;
	private BigDecimal	r61_inward_investment;
	private BigDecimal	r61_inward_trade;
	private BigDecimal	r61_inward_other;
	private BigDecimal	r61_inward_total;
	private String	r62_asian_countries4;
	private BigDecimal	r62_outward_family;
	private BigDecimal	r62_outward_investment;
	private BigDecimal	r62_outward_trade;
	private BigDecimal	r62_outward_other;
	private BigDecimal	r62_outward_total;
	private BigDecimal	r62_inward_family;
	private BigDecimal	r62_inward_investment;
	private BigDecimal	r62_inward_trade;
	private BigDecimal	r62_inward_other;
	private BigDecimal	r62_inward_total;
	private String	r63_asian_countries5;
	private BigDecimal	r63_outward_family;
	private BigDecimal	r63_outward_investment;
	private BigDecimal	r63_outward_trade;
	private BigDecimal	r63_outward_other;
	private BigDecimal	r63_outward_total;
	private BigDecimal	r63_inward_family;
	private BigDecimal	r63_inward_investment;
	private BigDecimal	r63_inward_trade;
	private BigDecimal	r63_inward_other;
	private BigDecimal	r63_inward_total;
	private String	r64_asian_countries6;
	private BigDecimal	r64_outward_family;
	private BigDecimal	r64_outward_investment;
	private BigDecimal	r64_outward_trade;
	private BigDecimal	r64_outward_other;
	private BigDecimal	r64_outward_total;
	private BigDecimal	r64_inward_family;
	private BigDecimal	r64_inward_investment;
	private BigDecimal	r64_inward_trade;
	private BigDecimal	r64_inward_other;
	private BigDecimal	r64_inward_total;
	private String	r65_asian_countries7;
	private BigDecimal	r65_outward_family;
	private BigDecimal	r65_outward_investment;
	private BigDecimal	r65_outward_trade;
	private BigDecimal	r65_outward_other;
	private BigDecimal	r65_outward_total;
	private BigDecimal	r65_inward_family;
	private BigDecimal	r65_inward_investment;
	private BigDecimal	r65_inward_trade;
	private BigDecimal	r65_inward_other;
	private BigDecimal	r65_inward_total;
	private String	r66_asian_countries8;
	private BigDecimal	r66_outward_family;
	private BigDecimal	r66_outward_investment;
	private BigDecimal	r66_outward_trade;
	private BigDecimal	r66_outward_other;
	private BigDecimal	r66_outward_total;
	private BigDecimal	r66_inward_family;
	private BigDecimal	r66_inward_investment;
	private BigDecimal	r66_inward_trade;
	private BigDecimal	r66_inward_other;
	private BigDecimal	r66_inward_total;
	private String	r67_asian_countries9;
	private BigDecimal	r67_outward_family;
	private BigDecimal	r67_outward_investment;
	private BigDecimal	r67_outward_trade;
	private BigDecimal	r67_outward_other;
	private BigDecimal	r67_outward_total;
	private BigDecimal	r67_inward_family;
	private BigDecimal	r67_inward_investment;
	private BigDecimal	r67_inward_trade;
	private BigDecimal	r67_inward_other;
	private BigDecimal	r67_inward_total;
	private String	r68_asian_countries10;
	private BigDecimal	r68_outward_family;
	private BigDecimal	r68_outward_investment;
	private BigDecimal	r68_outward_trade;
	private BigDecimal	r68_outward_other;
	private BigDecimal	r68_outward_total;
	private BigDecimal	r68_inward_family;
	private BigDecimal	r68_inward_investment;
	private BigDecimal	r68_inward_trade;
	private BigDecimal	r68_inward_other;
	private BigDecimal	r68_inward_total;
	private String	r69_asian_countries11;
	private BigDecimal	r69_outward_family;
	private BigDecimal	r69_outward_investment;
	private BigDecimal	r69_outward_trade;
	private BigDecimal	r69_outward_other;
	private BigDecimal	r69_outward_total;
	private BigDecimal	r69_inward_family;
	private BigDecimal	r69_inward_investment;
	private BigDecimal	r69_inward_trade;
	private BigDecimal	r69_inward_other;
	private BigDecimal	r69_inward_total;
	private String	r70_asian_countries12;
	private BigDecimal	r70_outward_family;
	private BigDecimal	r70_outward_investment;
	private BigDecimal	r70_outward_trade;
	private BigDecimal	r70_outward_other;
	private BigDecimal	r70_outward_total;
	private BigDecimal	r70_inward_family;
	private BigDecimal	r70_inward_investment;
	private BigDecimal	r70_inward_trade;
	private BigDecimal	r70_inward_other;
	private BigDecimal	r70_inward_total;
	private String	r71_asian_countries13;
	private BigDecimal	r71_outward_family;
	private BigDecimal	r71_outward_investment;
	private BigDecimal	r71_outward_trade;
	private BigDecimal	r71_outward_other;
	private BigDecimal	r71_outward_total;
	private BigDecimal	r71_inward_family;
	private BigDecimal	r71_inward_investment;
	private BigDecimal	r71_inward_trade;
	private BigDecimal	r71_inward_other;
	private BigDecimal	r71_inward_total;
	private String	r72_asian_countries14;
	private BigDecimal	r72_outward_family;
	private BigDecimal	r72_outward_investment;
	private BigDecimal	r72_outward_trade;
	private BigDecimal	r72_outward_other;
	private BigDecimal	r72_outward_total;
	private BigDecimal	r72_inward_family;
	private BigDecimal	r72_inward_investment;
	private BigDecimal	r72_inward_trade;
	private BigDecimal	r72_inward_other;
	private BigDecimal	r72_inward_total;
	private String	r73_asian_countries15;
	private BigDecimal	r73_outward_family;
	private BigDecimal	r73_outward_investment;
	private BigDecimal	r73_outward_trade;
	private BigDecimal	r73_outward_other;
	private BigDecimal	r73_outward_total;
	private BigDecimal	r73_inward_family;
	private BigDecimal	r73_inward_investment;
	private BigDecimal	r73_inward_trade;
	private BigDecimal	r73_inward_other;
	private BigDecimal	r73_inward_total;
	private String	r74_asian_countries16;
	private BigDecimal	r74_outward_family;
	private BigDecimal	r74_outward_investment;
	private BigDecimal	r74_outward_trade;
	private BigDecimal	r74_outward_other;
	private BigDecimal	r74_outward_total;
	private BigDecimal	r74_inward_family;
	private BigDecimal	r74_inward_investment;
	private BigDecimal	r74_inward_trade;
	private BigDecimal	r74_inward_other;
	private BigDecimal	r74_inward_total;
	private String	r75_asian_countries17;
	private BigDecimal	r75_outward_family;
	private BigDecimal	r75_outward_investment;
	private BigDecimal	r75_outward_trade;
	private BigDecimal	r75_outward_other;
	private BigDecimal	r75_outward_total;
	private BigDecimal	r75_inward_family;
	private BigDecimal	r75_inward_investment;
	private BigDecimal	r75_inward_trade;
	private BigDecimal	r75_inward_other;
	private BigDecimal	r75_inward_total;
	private String	r76_asian_countries18;
	private BigDecimal	r76_outward_family;
	private BigDecimal	r76_outward_investment;
	private BigDecimal	r76_outward_trade;
	private BigDecimal	r76_outward_other;
	private BigDecimal	r76_outward_total;
	private BigDecimal	r76_inward_family;
	private BigDecimal	r76_inward_investment;
	private BigDecimal	r76_inward_trade;
	private BigDecimal	r76_inward_other;
	private BigDecimal	r76_inward_total;
	private String	r77_latin_american_countries;
	private BigDecimal	r77_outward_family;
	private BigDecimal	r77_outward_investment;
	private BigDecimal	r77_outward_trade;
	private BigDecimal	r77_outward_other;
	private BigDecimal	r77_outward_total;
	private BigDecimal	r77_inward_family;
	private BigDecimal	r77_inward_investment;
	private BigDecimal	r77_inward_trade;
	private BigDecimal	r77_inward_other;
	private BigDecimal	r77_inward_total;
	private String	r78_latin_american_countries1;
	private BigDecimal	r78_outward_family;
	private BigDecimal	r78_outward_investment;
	private BigDecimal	r78_outward_trade;
	private BigDecimal	r78_outward_other;
	private BigDecimal	r78_outward_total;
	private BigDecimal	r78_inward_family;
	private BigDecimal	r78_inward_investment;
	private BigDecimal	r78_inward_trade;
	private BigDecimal	r78_inward_other;
	private BigDecimal	r78_inward_total;
	private String	r79_latin_american_countries2;
	private BigDecimal	r79_outward_family;
	private BigDecimal	r79_outward_investment;
	private BigDecimal	r79_outward_trade;
	private BigDecimal	r79_outward_other;
	private BigDecimal	r79_outward_total;
	private BigDecimal	r79_inward_family;
	private BigDecimal	r79_inward_investment;
	private BigDecimal	r79_inward_trade;
	private BigDecimal	r79_inward_other;
	private BigDecimal	r79_inward_total;
	private String	r80_latin_american_countries3;
	private BigDecimal	r80_outward_family;
	private BigDecimal	r80_outward_investment;
	private BigDecimal	r80_outward_trade;
	private BigDecimal	r80_outward_other;
	private BigDecimal	r80_outward_total;
	private BigDecimal	r80_inward_family;
	private BigDecimal	r80_inward_investment;
	private BigDecimal	r80_inward_trade;
	private BigDecimal	r80_inward_other;
	private BigDecimal	r80_inward_total;
	private String	r81_latin_american_countries4;
	private BigDecimal	r81_outward_family;
	private BigDecimal	r81_outward_investment;
	private BigDecimal	r81_outward_trade;
	private BigDecimal	r81_outward_other;
	private BigDecimal	r81_outward_total;
	private BigDecimal	r81_inward_family;
	private BigDecimal	r81_inward_investment;
	private BigDecimal	r81_inward_trade;
	private BigDecimal	r81_inward_other;
	private BigDecimal	r81_inward_total;
	private String	r82_latin_american_countries5;
	private BigDecimal	r82_outward_family;
	private BigDecimal	r82_outward_investment;
	private BigDecimal	r82_outward_trade;
	private BigDecimal	r82_outward_other;
	private BigDecimal	r82_outward_total;
	private BigDecimal	r82_inward_family;
	private BigDecimal	r82_inward_investment;
	private BigDecimal	r82_inward_trade;
	private BigDecimal	r82_inward_other;
	private BigDecimal	r82_inward_total;
	private String	r83_latin_american_countries6;
	private BigDecimal	r83_outward_family;
	private BigDecimal	r83_outward_investment;
	private BigDecimal	r83_outward_trade;
	private BigDecimal	r83_outward_other;
	private BigDecimal	r83_outward_total;
	private BigDecimal	r83_inward_family;
	private BigDecimal	r83_inward_investment;
	private BigDecimal	r83_inward_trade;
	private BigDecimal	r83_inward_other;
	private BigDecimal	r83_inward_total;
	private String	r84_oceania_countries;
	private BigDecimal	r84_outward_family;
	private BigDecimal	r84_outward_investment;
	private BigDecimal	r84_outward_trade;
	private BigDecimal	r84_outward_other;
	private BigDecimal	r84_outward_total;
	private BigDecimal	r84_inward_family;
	private BigDecimal	r84_inward_investment;
	private BigDecimal	r84_inward_trade;
	private BigDecimal	r84_inward_other;
	private BigDecimal	r84_inward_total;
	private String	r85_oceania_countries1;
	private BigDecimal	r85_outward_family;
	private BigDecimal	r85_outward_investment;
	private BigDecimal	r85_outward_trade;
	private BigDecimal	r85_outward_other;
	private BigDecimal	r85_outward_total;
	private BigDecimal	r85_inward_family;
	private BigDecimal	r85_inward_investment;
	private BigDecimal	r85_inward_trade;
	private BigDecimal	r85_inward_other;
	private BigDecimal	r85_inward_total;
	private String	r86_oceania_countries2;
	private BigDecimal	r86_outward_family;
	private BigDecimal	r86_outward_investment;
	private BigDecimal	r86_outward_trade;
	private BigDecimal	r86_outward_other;
	private BigDecimal	r86_outward_total;
	private BigDecimal	r86_inward_family;
	private BigDecimal	r86_inward_investment;
	private BigDecimal	r86_inward_trade;
	private BigDecimal	r86_inward_other;
	private BigDecimal	r86_inward_total;
	private String	r87_remaining_countries;
	private BigDecimal	r87_outward_family;
	private BigDecimal	r87_outward_investment;
	private BigDecimal	r87_outward_trade;
	private BigDecimal	r87_outward_other;
	private BigDecimal	r87_outward_total;
	private BigDecimal	r87_inward_family;
	private BigDecimal	r87_inward_investment;
	private BigDecimal	r87_inward_trade;
	private BigDecimal	r87_inward_other;
	private BigDecimal	r87_inward_total;
	private String	r88_remaining_countries1;
	private BigDecimal	r88_outward_family;
	private BigDecimal	r88_outward_investment;
	private BigDecimal	r88_outward_trade;
	private BigDecimal	r88_outward_other;
	private BigDecimal	r88_outward_total;
	private BigDecimal	r88_inward_family;
	private BigDecimal	r88_inward_investment;
	private BigDecimal	r88_inward_trade;
	private BigDecimal	r88_inward_other;
	private BigDecimal	r88_inward_total;
	private String	r89_other_countries;
	private BigDecimal	r89_outward_family;
	private BigDecimal	r89_outward_investment;
	private BigDecimal	r89_outward_trade;
	private BigDecimal	r89_outward_other;
	private BigDecimal	r89_outward_total;
	private BigDecimal	r89_inward_family;
	private BigDecimal	r89_inward_investment;
	private BigDecimal	r89_inward_trade;
	private BigDecimal	r89_inward_other;
	private BigDecimal	r89_inward_total;
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
	public String getR10_north_american_countries() {
		return r10_north_american_countries;
	}
	public void setR10_north_american_countries(String r10_north_american_countries) {
		this.r10_north_american_countries = r10_north_american_countries;
	}
	public BigDecimal getR10_outward_family() {
		return r10_outward_family;
	}
	public void setR10_outward_family(BigDecimal r10_outward_family) {
		this.r10_outward_family = r10_outward_family;
	}
	public BigDecimal getR10_outward_investment() {
		return r10_outward_investment;
	}
	public void setR10_outward_investment(BigDecimal r10_outward_investment) {
		this.r10_outward_investment = r10_outward_investment;
	}
	public BigDecimal getR10_outward_trade() {
		return r10_outward_trade;
	}
	public void setR10_outward_trade(BigDecimal r10_outward_trade) {
		this.r10_outward_trade = r10_outward_trade;
	}
	public BigDecimal getR10_outward_other() {
		return r10_outward_other;
	}
	public void setR10_outward_other(BigDecimal r10_outward_other) {
		this.r10_outward_other = r10_outward_other;
	}
	public BigDecimal getR10_outward_total() {
		return r10_outward_total;
	}
	public void setR10_outward_total(BigDecimal r10_outward_total) {
		this.r10_outward_total = r10_outward_total;
	}
	public BigDecimal getR10_inward_family() {
		return r10_inward_family;
	}
	public void setR10_inward_family(BigDecimal r10_inward_family) {
		this.r10_inward_family = r10_inward_family;
	}
	public BigDecimal getR10_inward_investment() {
		return r10_inward_investment;
	}
	public void setR10_inward_investment(BigDecimal r10_inward_investment) {
		this.r10_inward_investment = r10_inward_investment;
	}
	public BigDecimal getR10_inward_trade() {
		return r10_inward_trade;
	}
	public void setR10_inward_trade(BigDecimal r10_inward_trade) {
		this.r10_inward_trade = r10_inward_trade;
	}
	public BigDecimal getR10_inward_other() {
		return r10_inward_other;
	}
	public void setR10_inward_other(BigDecimal r10_inward_other) {
		this.r10_inward_other = r10_inward_other;
	}
	public BigDecimal getR10_inward_total() {
		return r10_inward_total;
	}
	public void setR10_inward_total(BigDecimal r10_inward_total) {
		this.r10_inward_total = r10_inward_total;
	}
	public String getR11_north_american_countries1() {
		return r11_north_american_countries1;
	}
	public void setR11_north_american_countries1(String r11_north_american_countries1) {
		this.r11_north_american_countries1 = r11_north_american_countries1;
	}
	public BigDecimal getR11_outward_family() {
		return r11_outward_family;
	}
	public void setR11_outward_family(BigDecimal r11_outward_family) {
		this.r11_outward_family = r11_outward_family;
	}
	public BigDecimal getR11_outward_investment() {
		return r11_outward_investment;
	}
	public void setR11_outward_investment(BigDecimal r11_outward_investment) {
		this.r11_outward_investment = r11_outward_investment;
	}
	public BigDecimal getR11_outward_trade() {
		return r11_outward_trade;
	}
	public void setR11_outward_trade(BigDecimal r11_outward_trade) {
		this.r11_outward_trade = r11_outward_trade;
	}
	public BigDecimal getR11_outward_other() {
		return r11_outward_other;
	}
	public void setR11_outward_other(BigDecimal r11_outward_other) {
		this.r11_outward_other = r11_outward_other;
	}
	public BigDecimal getR11_outward_total() {
		return r11_outward_total;
	}
	public void setR11_outward_total(BigDecimal r11_outward_total) {
		this.r11_outward_total = r11_outward_total;
	}
	public BigDecimal getR11_inward_family() {
		return r11_inward_family;
	}
	public void setR11_inward_family(BigDecimal r11_inward_family) {
		this.r11_inward_family = r11_inward_family;
	}
	public BigDecimal getR11_inward_investment() {
		return r11_inward_investment;
	}
	public void setR11_inward_investment(BigDecimal r11_inward_investment) {
		this.r11_inward_investment = r11_inward_investment;
	}
	public BigDecimal getR11_inward_trade() {
		return r11_inward_trade;
	}
	public void setR11_inward_trade(BigDecimal r11_inward_trade) {
		this.r11_inward_trade = r11_inward_trade;
	}
	public BigDecimal getR11_inward_other() {
		return r11_inward_other;
	}
	public void setR11_inward_other(BigDecimal r11_inward_other) {
		this.r11_inward_other = r11_inward_other;
	}
	public BigDecimal getR11_inward_total() {
		return r11_inward_total;
	}
	public void setR11_inward_total(BigDecimal r11_inward_total) {
		this.r11_inward_total = r11_inward_total;
	}
	public String getR12_north_american_countries2() {
		return r12_north_american_countries2;
	}
	public void setR12_north_american_countries2(String r12_north_american_countries2) {
		this.r12_north_american_countries2 = r12_north_american_countries2;
	}
	public BigDecimal getR12_outward_family() {
		return r12_outward_family;
	}
	public void setR12_outward_family(BigDecimal r12_outward_family) {
		this.r12_outward_family = r12_outward_family;
	}
	public BigDecimal getR12_outward_investment() {
		return r12_outward_investment;
	}
	public void setR12_outward_investment(BigDecimal r12_outward_investment) {
		this.r12_outward_investment = r12_outward_investment;
	}
	public BigDecimal getR12_outward_trade() {
		return r12_outward_trade;
	}
	public void setR12_outward_trade(BigDecimal r12_outward_trade) {
		this.r12_outward_trade = r12_outward_trade;
	}
	public BigDecimal getR12_outward_other() {
		return r12_outward_other;
	}
	public void setR12_outward_other(BigDecimal r12_outward_other) {
		this.r12_outward_other = r12_outward_other;
	}
	public BigDecimal getR12_outward_total() {
		return r12_outward_total;
	}
	public void setR12_outward_total(BigDecimal r12_outward_total) {
		this.r12_outward_total = r12_outward_total;
	}
	public BigDecimal getR12_inward_family() {
		return r12_inward_family;
	}
	public void setR12_inward_family(BigDecimal r12_inward_family) {
		this.r12_inward_family = r12_inward_family;
	}
	public BigDecimal getR12_inward_investment() {
		return r12_inward_investment;
	}
	public void setR12_inward_investment(BigDecimal r12_inward_investment) {
		this.r12_inward_investment = r12_inward_investment;
	}
	public BigDecimal getR12_inward_trade() {
		return r12_inward_trade;
	}
	public void setR12_inward_trade(BigDecimal r12_inward_trade) {
		this.r12_inward_trade = r12_inward_trade;
	}
	public BigDecimal getR12_inward_other() {
		return r12_inward_other;
	}
	public void setR12_inward_other(BigDecimal r12_inward_other) {
		this.r12_inward_other = r12_inward_other;
	}
	public BigDecimal getR12_inward_total() {
		return r12_inward_total;
	}
	public void setR12_inward_total(BigDecimal r12_inward_total) {
		this.r12_inward_total = r12_inward_total;
	}
	public String getR13_european_countries() {
		return r13_european_countries;
	}
	public void setR13_european_countries(String r13_european_countries) {
		this.r13_european_countries = r13_european_countries;
	}
	public BigDecimal getR13_outward_family() {
		return r13_outward_family;
	}
	public void setR13_outward_family(BigDecimal r13_outward_family) {
		this.r13_outward_family = r13_outward_family;
	}
	public BigDecimal getR13_outward_investment() {
		return r13_outward_investment;
	}
	public void setR13_outward_investment(BigDecimal r13_outward_investment) {
		this.r13_outward_investment = r13_outward_investment;
	}
	public BigDecimal getR13_outward_trade() {
		return r13_outward_trade;
	}
	public void setR13_outward_trade(BigDecimal r13_outward_trade) {
		this.r13_outward_trade = r13_outward_trade;
	}
	public BigDecimal getR13_outward_other() {
		return r13_outward_other;
	}
	public void setR13_outward_other(BigDecimal r13_outward_other) {
		this.r13_outward_other = r13_outward_other;
	}
	public BigDecimal getR13_outward_total() {
		return r13_outward_total;
	}
	public void setR13_outward_total(BigDecimal r13_outward_total) {
		this.r13_outward_total = r13_outward_total;
	}
	public BigDecimal getR13_inward_family() {
		return r13_inward_family;
	}
	public void setR13_inward_family(BigDecimal r13_inward_family) {
		this.r13_inward_family = r13_inward_family;
	}
	public BigDecimal getR13_inward_investment() {
		return r13_inward_investment;
	}
	public void setR13_inward_investment(BigDecimal r13_inward_investment) {
		this.r13_inward_investment = r13_inward_investment;
	}
	public BigDecimal getR13_inward_trade() {
		return r13_inward_trade;
	}
	public void setR13_inward_trade(BigDecimal r13_inward_trade) {
		this.r13_inward_trade = r13_inward_trade;
	}
	public BigDecimal getR13_inward_other() {
		return r13_inward_other;
	}
	public void setR13_inward_other(BigDecimal r13_inward_other) {
		this.r13_inward_other = r13_inward_other;
	}
	public BigDecimal getR13_inward_total() {
		return r13_inward_total;
	}
	public void setR13_inward_total(BigDecimal r13_inward_total) {
		this.r13_inward_total = r13_inward_total;
	}
	public String getR14_european_countries1() {
		return r14_european_countries1;
	}
	public void setR14_european_countries1(String r14_european_countries1) {
		this.r14_european_countries1 = r14_european_countries1;
	}
	public BigDecimal getR14_outward_family() {
		return r14_outward_family;
	}
	public void setR14_outward_family(BigDecimal r14_outward_family) {
		this.r14_outward_family = r14_outward_family;
	}
	public BigDecimal getR14_outward_investment() {
		return r14_outward_investment;
	}
	public void setR14_outward_investment(BigDecimal r14_outward_investment) {
		this.r14_outward_investment = r14_outward_investment;
	}
	public BigDecimal getR14_outward_trade() {
		return r14_outward_trade;
	}
	public void setR14_outward_trade(BigDecimal r14_outward_trade) {
		this.r14_outward_trade = r14_outward_trade;
	}
	public BigDecimal getR14_outward_other() {
		return r14_outward_other;
	}
	public void setR14_outward_other(BigDecimal r14_outward_other) {
		this.r14_outward_other = r14_outward_other;
	}
	public BigDecimal getR14_outward_total() {
		return r14_outward_total;
	}
	public void setR14_outward_total(BigDecimal r14_outward_total) {
		this.r14_outward_total = r14_outward_total;
	}
	public BigDecimal getR14_inward_family() {
		return r14_inward_family;
	}
	public void setR14_inward_family(BigDecimal r14_inward_family) {
		this.r14_inward_family = r14_inward_family;
	}
	public BigDecimal getR14_inward_investment() {
		return r14_inward_investment;
	}
	public void setR14_inward_investment(BigDecimal r14_inward_investment) {
		this.r14_inward_investment = r14_inward_investment;
	}
	public BigDecimal getR14_inward_trade() {
		return r14_inward_trade;
	}
	public void setR14_inward_trade(BigDecimal r14_inward_trade) {
		this.r14_inward_trade = r14_inward_trade;
	}
	public BigDecimal getR14_inward_other() {
		return r14_inward_other;
	}
	public void setR14_inward_other(BigDecimal r14_inward_other) {
		this.r14_inward_other = r14_inward_other;
	}
	public BigDecimal getR14_inward_total() {
		return r14_inward_total;
	}
	public void setR14_inward_total(BigDecimal r14_inward_total) {
		this.r14_inward_total = r14_inward_total;
	}
	public String getR15_european_countries2() {
		return r15_european_countries2;
	}
	public void setR15_european_countries2(String r15_european_countries2) {
		this.r15_european_countries2 = r15_european_countries2;
	}
	public BigDecimal getR15_outward_family() {
		return r15_outward_family;
	}
	public void setR15_outward_family(BigDecimal r15_outward_family) {
		this.r15_outward_family = r15_outward_family;
	}
	public BigDecimal getR15_outward_investment() {
		return r15_outward_investment;
	}
	public void setR15_outward_investment(BigDecimal r15_outward_investment) {
		this.r15_outward_investment = r15_outward_investment;
	}
	public BigDecimal getR15_outward_trade() {
		return r15_outward_trade;
	}
	public void setR15_outward_trade(BigDecimal r15_outward_trade) {
		this.r15_outward_trade = r15_outward_trade;
	}
	public BigDecimal getR15_outward_other() {
		return r15_outward_other;
	}
	public void setR15_outward_other(BigDecimal r15_outward_other) {
		this.r15_outward_other = r15_outward_other;
	}
	public BigDecimal getR15_outward_total() {
		return r15_outward_total;
	}
	public void setR15_outward_total(BigDecimal r15_outward_total) {
		this.r15_outward_total = r15_outward_total;
	}
	public BigDecimal getR15_inward_family() {
		return r15_inward_family;
	}
	public void setR15_inward_family(BigDecimal r15_inward_family) {
		this.r15_inward_family = r15_inward_family;
	}
	public BigDecimal getR15_inward_investment() {
		return r15_inward_investment;
	}
	public void setR15_inward_investment(BigDecimal r15_inward_investment) {
		this.r15_inward_investment = r15_inward_investment;
	}
	public BigDecimal getR15_inward_trade() {
		return r15_inward_trade;
	}
	public void setR15_inward_trade(BigDecimal r15_inward_trade) {
		this.r15_inward_trade = r15_inward_trade;
	}
	public BigDecimal getR15_inward_other() {
		return r15_inward_other;
	}
	public void setR15_inward_other(BigDecimal r15_inward_other) {
		this.r15_inward_other = r15_inward_other;
	}
	public BigDecimal getR15_inward_total() {
		return r15_inward_total;
	}
	public void setR15_inward_total(BigDecimal r15_inward_total) {
		this.r15_inward_total = r15_inward_total;
	}
	public String getR16_european_countries3() {
		return r16_european_countries3;
	}
	public void setR16_european_countries3(String r16_european_countries3) {
		this.r16_european_countries3 = r16_european_countries3;
	}
	public BigDecimal getR16_outward_family() {
		return r16_outward_family;
	}
	public void setR16_outward_family(BigDecimal r16_outward_family) {
		this.r16_outward_family = r16_outward_family;
	}
	public BigDecimal getR16_outward_investment() {
		return r16_outward_investment;
	}
	public void setR16_outward_investment(BigDecimal r16_outward_investment) {
		this.r16_outward_investment = r16_outward_investment;
	}
	public BigDecimal getR16_outward_trade() {
		return r16_outward_trade;
	}
	public void setR16_outward_trade(BigDecimal r16_outward_trade) {
		this.r16_outward_trade = r16_outward_trade;
	}
	public BigDecimal getR16_outward_other() {
		return r16_outward_other;
	}
	public void setR16_outward_other(BigDecimal r16_outward_other) {
		this.r16_outward_other = r16_outward_other;
	}
	public BigDecimal getR16_outward_total() {
		return r16_outward_total;
	}
	public void setR16_outward_total(BigDecimal r16_outward_total) {
		this.r16_outward_total = r16_outward_total;
	}
	public BigDecimal getR16_inward_family() {
		return r16_inward_family;
	}
	public void setR16_inward_family(BigDecimal r16_inward_family) {
		this.r16_inward_family = r16_inward_family;
	}
	public BigDecimal getR16_inward_investment() {
		return r16_inward_investment;
	}
	public void setR16_inward_investment(BigDecimal r16_inward_investment) {
		this.r16_inward_investment = r16_inward_investment;
	}
	public BigDecimal getR16_inward_trade() {
		return r16_inward_trade;
	}
	public void setR16_inward_trade(BigDecimal r16_inward_trade) {
		this.r16_inward_trade = r16_inward_trade;
	}
	public BigDecimal getR16_inward_other() {
		return r16_inward_other;
	}
	public void setR16_inward_other(BigDecimal r16_inward_other) {
		this.r16_inward_other = r16_inward_other;
	}
	public BigDecimal getR16_inward_total() {
		return r16_inward_total;
	}
	public void setR16_inward_total(BigDecimal r16_inward_total) {
		this.r16_inward_total = r16_inward_total;
	}
	public String getR17_european_countries4() {
		return r17_european_countries4;
	}
	public void setR17_european_countries4(String r17_european_countries4) {
		this.r17_european_countries4 = r17_european_countries4;
	}
	public BigDecimal getR17_outward_family() {
		return r17_outward_family;
	}
	public void setR17_outward_family(BigDecimal r17_outward_family) {
		this.r17_outward_family = r17_outward_family;
	}
	public BigDecimal getR17_outward_investment() {
		return r17_outward_investment;
	}
	public void setR17_outward_investment(BigDecimal r17_outward_investment) {
		this.r17_outward_investment = r17_outward_investment;
	}
	public BigDecimal getR17_outward_trade() {
		return r17_outward_trade;
	}
	public void setR17_outward_trade(BigDecimal r17_outward_trade) {
		this.r17_outward_trade = r17_outward_trade;
	}
	public BigDecimal getR17_outward_other() {
		return r17_outward_other;
	}
	public void setR17_outward_other(BigDecimal r17_outward_other) {
		this.r17_outward_other = r17_outward_other;
	}
	public BigDecimal getR17_outward_total() {
		return r17_outward_total;
	}
	public void setR17_outward_total(BigDecimal r17_outward_total) {
		this.r17_outward_total = r17_outward_total;
	}
	public BigDecimal getR17_inward_family() {
		return r17_inward_family;
	}
	public void setR17_inward_family(BigDecimal r17_inward_family) {
		this.r17_inward_family = r17_inward_family;
	}
	public BigDecimal getR17_inward_investment() {
		return r17_inward_investment;
	}
	public void setR17_inward_investment(BigDecimal r17_inward_investment) {
		this.r17_inward_investment = r17_inward_investment;
	}
	public BigDecimal getR17_inward_trade() {
		return r17_inward_trade;
	}
	public void setR17_inward_trade(BigDecimal r17_inward_trade) {
		this.r17_inward_trade = r17_inward_trade;
	}
	public BigDecimal getR17_inward_other() {
		return r17_inward_other;
	}
	public void setR17_inward_other(BigDecimal r17_inward_other) {
		this.r17_inward_other = r17_inward_other;
	}
	public BigDecimal getR17_inward_total() {
		return r17_inward_total;
	}
	public void setR17_inward_total(BigDecimal r17_inward_total) {
		this.r17_inward_total = r17_inward_total;
	}
	public String getR18_european_countries5() {
		return r18_european_countries5;
	}
	public void setR18_european_countries5(String r18_european_countries5) {
		this.r18_european_countries5 = r18_european_countries5;
	}
	public BigDecimal getR18_outward_family() {
		return r18_outward_family;
	}
	public void setR18_outward_family(BigDecimal r18_outward_family) {
		this.r18_outward_family = r18_outward_family;
	}
	public BigDecimal getR18_outward_investment() {
		return r18_outward_investment;
	}
	public void setR18_outward_investment(BigDecimal r18_outward_investment) {
		this.r18_outward_investment = r18_outward_investment;
	}
	public BigDecimal getR18_outward_trade() {
		return r18_outward_trade;
	}
	public void setR18_outward_trade(BigDecimal r18_outward_trade) {
		this.r18_outward_trade = r18_outward_trade;
	}
	public BigDecimal getR18_outward_other() {
		return r18_outward_other;
	}
	public void setR18_outward_other(BigDecimal r18_outward_other) {
		this.r18_outward_other = r18_outward_other;
	}
	public BigDecimal getR18_outward_total() {
		return r18_outward_total;
	}
	public void setR18_outward_total(BigDecimal r18_outward_total) {
		this.r18_outward_total = r18_outward_total;
	}
	public BigDecimal getR18_inward_family() {
		return r18_inward_family;
	}
	public void setR18_inward_family(BigDecimal r18_inward_family) {
		this.r18_inward_family = r18_inward_family;
	}
	public BigDecimal getR18_inward_investment() {
		return r18_inward_investment;
	}
	public void setR18_inward_investment(BigDecimal r18_inward_investment) {
		this.r18_inward_investment = r18_inward_investment;
	}
	public BigDecimal getR18_inward_trade() {
		return r18_inward_trade;
	}
	public void setR18_inward_trade(BigDecimal r18_inward_trade) {
		this.r18_inward_trade = r18_inward_trade;
	}
	public BigDecimal getR18_inward_other() {
		return r18_inward_other;
	}
	public void setR18_inward_other(BigDecimal r18_inward_other) {
		this.r18_inward_other = r18_inward_other;
	}
	public BigDecimal getR18_inward_total() {
		return r18_inward_total;
	}
	public void setR18_inward_total(BigDecimal r18_inward_total) {
		this.r18_inward_total = r18_inward_total;
	}
	public String getR19_european_countries6() {
		return r19_european_countries6;
	}
	public void setR19_european_countries6(String r19_european_countries6) {
		this.r19_european_countries6 = r19_european_countries6;
	}
	public BigDecimal getR19_outward_family() {
		return r19_outward_family;
	}
	public void setR19_outward_family(BigDecimal r19_outward_family) {
		this.r19_outward_family = r19_outward_family;
	}
	public BigDecimal getR19_outward_investment() {
		return r19_outward_investment;
	}
	public void setR19_outward_investment(BigDecimal r19_outward_investment) {
		this.r19_outward_investment = r19_outward_investment;
	}
	public BigDecimal getR19_outward_trade() {
		return r19_outward_trade;
	}
	public void setR19_outward_trade(BigDecimal r19_outward_trade) {
		this.r19_outward_trade = r19_outward_trade;
	}
	public BigDecimal getR19_outward_other() {
		return r19_outward_other;
	}
	public void setR19_outward_other(BigDecimal r19_outward_other) {
		this.r19_outward_other = r19_outward_other;
	}
	public BigDecimal getR19_outward_total() {
		return r19_outward_total;
	}
	public void setR19_outward_total(BigDecimal r19_outward_total) {
		this.r19_outward_total = r19_outward_total;
	}
	public BigDecimal getR19_inward_family() {
		return r19_inward_family;
	}
	public void setR19_inward_family(BigDecimal r19_inward_family) {
		this.r19_inward_family = r19_inward_family;
	}
	public BigDecimal getR19_inward_investment() {
		return r19_inward_investment;
	}
	public void setR19_inward_investment(BigDecimal r19_inward_investment) {
		this.r19_inward_investment = r19_inward_investment;
	}
	public BigDecimal getR19_inward_trade() {
		return r19_inward_trade;
	}
	public void setR19_inward_trade(BigDecimal r19_inward_trade) {
		this.r19_inward_trade = r19_inward_trade;
	}
	public BigDecimal getR19_inward_other() {
		return r19_inward_other;
	}
	public void setR19_inward_other(BigDecimal r19_inward_other) {
		this.r19_inward_other = r19_inward_other;
	}
	public BigDecimal getR19_inward_total() {
		return r19_inward_total;
	}
	public void setR19_inward_total(BigDecimal r19_inward_total) {
		this.r19_inward_total = r19_inward_total;
	}
	public String getR20_european_countries7() {
		return r20_european_countries7;
	}
	public void setR20_european_countries7(String r20_european_countries7) {
		this.r20_european_countries7 = r20_european_countries7;
	}
	public BigDecimal getR20_outward_family() {
		return r20_outward_family;
	}
	public void setR20_outward_family(BigDecimal r20_outward_family) {
		this.r20_outward_family = r20_outward_family;
	}
	public BigDecimal getR20_outward_investment() {
		return r20_outward_investment;
	}
	public void setR20_outward_investment(BigDecimal r20_outward_investment) {
		this.r20_outward_investment = r20_outward_investment;
	}
	public BigDecimal getR20_outward_trade() {
		return r20_outward_trade;
	}
	public void setR20_outward_trade(BigDecimal r20_outward_trade) {
		this.r20_outward_trade = r20_outward_trade;
	}
	public BigDecimal getR20_outward_other() {
		return r20_outward_other;
	}
	public void setR20_outward_other(BigDecimal r20_outward_other) {
		this.r20_outward_other = r20_outward_other;
	}
	public BigDecimal getR20_outward_total() {
		return r20_outward_total;
	}
	public void setR20_outward_total(BigDecimal r20_outward_total) {
		this.r20_outward_total = r20_outward_total;
	}
	public BigDecimal getR20_inward_family() {
		return r20_inward_family;
	}
	public void setR20_inward_family(BigDecimal r20_inward_family) {
		this.r20_inward_family = r20_inward_family;
	}
	public BigDecimal getR20_inward_investment() {
		return r20_inward_investment;
	}
	public void setR20_inward_investment(BigDecimal r20_inward_investment) {
		this.r20_inward_investment = r20_inward_investment;
	}
	public BigDecimal getR20_inward_trade() {
		return r20_inward_trade;
	}
	public void setR20_inward_trade(BigDecimal r20_inward_trade) {
		this.r20_inward_trade = r20_inward_trade;
	}
	public BigDecimal getR20_inward_other() {
		return r20_inward_other;
	}
	public void setR20_inward_other(BigDecimal r20_inward_other) {
		this.r20_inward_other = r20_inward_other;
	}
	public BigDecimal getR20_inward_total() {
		return r20_inward_total;
	}
	public void setR20_inward_total(BigDecimal r20_inward_total) {
		this.r20_inward_total = r20_inward_total;
	}
	public String getR21_european_countries8() {
		return r21_european_countries8;
	}
	public void setR21_european_countries8(String r21_european_countries8) {
		this.r21_european_countries8 = r21_european_countries8;
	}
	public BigDecimal getR21_outward_family() {
		return r21_outward_family;
	}
	public void setR21_outward_family(BigDecimal r21_outward_family) {
		this.r21_outward_family = r21_outward_family;
	}
	public BigDecimal getR21_outward_investment() {
		return r21_outward_investment;
	}
	public void setR21_outward_investment(BigDecimal r21_outward_investment) {
		this.r21_outward_investment = r21_outward_investment;
	}
	public BigDecimal getR21_outward_trade() {
		return r21_outward_trade;
	}
	public void setR21_outward_trade(BigDecimal r21_outward_trade) {
		this.r21_outward_trade = r21_outward_trade;
	}
	public BigDecimal getR21_outward_other() {
		return r21_outward_other;
	}
	public void setR21_outward_other(BigDecimal r21_outward_other) {
		this.r21_outward_other = r21_outward_other;
	}
	public BigDecimal getR21_outward_total() {
		return r21_outward_total;
	}
	public void setR21_outward_total(BigDecimal r21_outward_total) {
		this.r21_outward_total = r21_outward_total;
	}
	public BigDecimal getR21_inward_family() {
		return r21_inward_family;
	}
	public void setR21_inward_family(BigDecimal r21_inward_family) {
		this.r21_inward_family = r21_inward_family;
	}
	public BigDecimal getR21_inward_investment() {
		return r21_inward_investment;
	}
	public void setR21_inward_investment(BigDecimal r21_inward_investment) {
		this.r21_inward_investment = r21_inward_investment;
	}
	public BigDecimal getR21_inward_trade() {
		return r21_inward_trade;
	}
	public void setR21_inward_trade(BigDecimal r21_inward_trade) {
		this.r21_inward_trade = r21_inward_trade;
	}
	public BigDecimal getR21_inward_other() {
		return r21_inward_other;
	}
	public void setR21_inward_other(BigDecimal r21_inward_other) {
		this.r21_inward_other = r21_inward_other;
	}
	public BigDecimal getR21_inward_total() {
		return r21_inward_total;
	}
	public void setR21_inward_total(BigDecimal r21_inward_total) {
		this.r21_inward_total = r21_inward_total;
	}
	public String getR22_european_countries9() {
		return r22_european_countries9;
	}
	public void setR22_european_countries9(String r22_european_countries9) {
		this.r22_european_countries9 = r22_european_countries9;
	}
	public BigDecimal getR22_outward_family() {
		return r22_outward_family;
	}
	public void setR22_outward_family(BigDecimal r22_outward_family) {
		this.r22_outward_family = r22_outward_family;
	}
	public BigDecimal getR22_outward_investment() {
		return r22_outward_investment;
	}
	public void setR22_outward_investment(BigDecimal r22_outward_investment) {
		this.r22_outward_investment = r22_outward_investment;
	}
	public BigDecimal getR22_outward_trade() {
		return r22_outward_trade;
	}
	public void setR22_outward_trade(BigDecimal r22_outward_trade) {
		this.r22_outward_trade = r22_outward_trade;
	}
	public BigDecimal getR22_outward_other() {
		return r22_outward_other;
	}
	public void setR22_outward_other(BigDecimal r22_outward_other) {
		this.r22_outward_other = r22_outward_other;
	}
	public BigDecimal getR22_outward_total() {
		return r22_outward_total;
	}
	public void setR22_outward_total(BigDecimal r22_outward_total) {
		this.r22_outward_total = r22_outward_total;
	}
	public BigDecimal getR22_inward_family() {
		return r22_inward_family;
	}
	public void setR22_inward_family(BigDecimal r22_inward_family) {
		this.r22_inward_family = r22_inward_family;
	}
	public BigDecimal getR22_inward_investment() {
		return r22_inward_investment;
	}
	public void setR22_inward_investment(BigDecimal r22_inward_investment) {
		this.r22_inward_investment = r22_inward_investment;
	}
	public BigDecimal getR22_inward_trade() {
		return r22_inward_trade;
	}
	public void setR22_inward_trade(BigDecimal r22_inward_trade) {
		this.r22_inward_trade = r22_inward_trade;
	}
	public BigDecimal getR22_inward_other() {
		return r22_inward_other;
	}
	public void setR22_inward_other(BigDecimal r22_inward_other) {
		this.r22_inward_other = r22_inward_other;
	}
	public BigDecimal getR22_inward_total() {
		return r22_inward_total;
	}
	public void setR22_inward_total(BigDecimal r22_inward_total) {
		this.r22_inward_total = r22_inward_total;
	}
	public String getR23_european_countries10() {
		return r23_european_countries10;
	}
	public void setR23_european_countries10(String r23_european_countries10) {
		this.r23_european_countries10 = r23_european_countries10;
	}
	public BigDecimal getR23_outward_family() {
		return r23_outward_family;
	}
	public void setR23_outward_family(BigDecimal r23_outward_family) {
		this.r23_outward_family = r23_outward_family;
	}
	public BigDecimal getR23_outward_investment() {
		return r23_outward_investment;
	}
	public void setR23_outward_investment(BigDecimal r23_outward_investment) {
		this.r23_outward_investment = r23_outward_investment;
	}
	public BigDecimal getR23_outward_trade() {
		return r23_outward_trade;
	}
	public void setR23_outward_trade(BigDecimal r23_outward_trade) {
		this.r23_outward_trade = r23_outward_trade;
	}
	public BigDecimal getR23_outward_other() {
		return r23_outward_other;
	}
	public void setR23_outward_other(BigDecimal r23_outward_other) {
		this.r23_outward_other = r23_outward_other;
	}
	public BigDecimal getR23_outward_total() {
		return r23_outward_total;
	}
	public void setR23_outward_total(BigDecimal r23_outward_total) {
		this.r23_outward_total = r23_outward_total;
	}
	public BigDecimal getR23_inward_family() {
		return r23_inward_family;
	}
	public void setR23_inward_family(BigDecimal r23_inward_family) {
		this.r23_inward_family = r23_inward_family;
	}
	public BigDecimal getR23_inward_investment() {
		return r23_inward_investment;
	}
	public void setR23_inward_investment(BigDecimal r23_inward_investment) {
		this.r23_inward_investment = r23_inward_investment;
	}
	public BigDecimal getR23_inward_trade() {
		return r23_inward_trade;
	}
	public void setR23_inward_trade(BigDecimal r23_inward_trade) {
		this.r23_inward_trade = r23_inward_trade;
	}
	public BigDecimal getR23_inward_other() {
		return r23_inward_other;
	}
	public void setR23_inward_other(BigDecimal r23_inward_other) {
		this.r23_inward_other = r23_inward_other;
	}
	public BigDecimal getR23_inward_total() {
		return r23_inward_total;
	}
	public void setR23_inward_total(BigDecimal r23_inward_total) {
		this.r23_inward_total = r23_inward_total;
	}
	public String getR24_european_countries11() {
		return r24_european_countries11;
	}
	public void setR24_european_countries11(String r24_european_countries11) {
		this.r24_european_countries11 = r24_european_countries11;
	}
	public BigDecimal getR24_outward_family() {
		return r24_outward_family;
	}
	public void setR24_outward_family(BigDecimal r24_outward_family) {
		this.r24_outward_family = r24_outward_family;
	}
	public BigDecimal getR24_outward_investment() {
		return r24_outward_investment;
	}
	public void setR24_outward_investment(BigDecimal r24_outward_investment) {
		this.r24_outward_investment = r24_outward_investment;
	}
	public BigDecimal getR24_outward_trade() {
		return r24_outward_trade;
	}
	public void setR24_outward_trade(BigDecimal r24_outward_trade) {
		this.r24_outward_trade = r24_outward_trade;
	}
	public BigDecimal getR24_outward_other() {
		return r24_outward_other;
	}
	public void setR24_outward_other(BigDecimal r24_outward_other) {
		this.r24_outward_other = r24_outward_other;
	}
	public BigDecimal getR24_outward_total() {
		return r24_outward_total;
	}
	public void setR24_outward_total(BigDecimal r24_outward_total) {
		this.r24_outward_total = r24_outward_total;
	}
	public BigDecimal getR24_inward_family() {
		return r24_inward_family;
	}
	public void setR24_inward_family(BigDecimal r24_inward_family) {
		this.r24_inward_family = r24_inward_family;
	}
	public BigDecimal getR24_inward_investment() {
		return r24_inward_investment;
	}
	public void setR24_inward_investment(BigDecimal r24_inward_investment) {
		this.r24_inward_investment = r24_inward_investment;
	}
	public BigDecimal getR24_inward_trade() {
		return r24_inward_trade;
	}
	public void setR24_inward_trade(BigDecimal r24_inward_trade) {
		this.r24_inward_trade = r24_inward_trade;
	}
	public BigDecimal getR24_inward_other() {
		return r24_inward_other;
	}
	public void setR24_inward_other(BigDecimal r24_inward_other) {
		this.r24_inward_other = r24_inward_other;
	}
	public BigDecimal getR24_inward_total() {
		return r24_inward_total;
	}
	public void setR24_inward_total(BigDecimal r24_inward_total) {
		this.r24_inward_total = r24_inward_total;
	}
	public String getR25_european_countries12() {
		return r25_european_countries12;
	}
	public void setR25_european_countries12(String r25_european_countries12) {
		this.r25_european_countries12 = r25_european_countries12;
	}
	public BigDecimal getR25_outward_family() {
		return r25_outward_family;
	}
	public void setR25_outward_family(BigDecimal r25_outward_family) {
		this.r25_outward_family = r25_outward_family;
	}
	public BigDecimal getR25_outward_investment() {
		return r25_outward_investment;
	}
	public void setR25_outward_investment(BigDecimal r25_outward_investment) {
		this.r25_outward_investment = r25_outward_investment;
	}
	public BigDecimal getR25_outward_trade() {
		return r25_outward_trade;
	}
	public void setR25_outward_trade(BigDecimal r25_outward_trade) {
		this.r25_outward_trade = r25_outward_trade;
	}
	public BigDecimal getR25_outward_other() {
		return r25_outward_other;
	}
	public void setR25_outward_other(BigDecimal r25_outward_other) {
		this.r25_outward_other = r25_outward_other;
	}
	public BigDecimal getR25_outward_total() {
		return r25_outward_total;
	}
	public void setR25_outward_total(BigDecimal r25_outward_total) {
		this.r25_outward_total = r25_outward_total;
	}
	public BigDecimal getR25_inward_family() {
		return r25_inward_family;
	}
	public void setR25_inward_family(BigDecimal r25_inward_family) {
		this.r25_inward_family = r25_inward_family;
	}
	public BigDecimal getR25_inward_investment() {
		return r25_inward_investment;
	}
	public void setR25_inward_investment(BigDecimal r25_inward_investment) {
		this.r25_inward_investment = r25_inward_investment;
	}
	public BigDecimal getR25_inward_trade() {
		return r25_inward_trade;
	}
	public void setR25_inward_trade(BigDecimal r25_inward_trade) {
		this.r25_inward_trade = r25_inward_trade;
	}
	public BigDecimal getR25_inward_other() {
		return r25_inward_other;
	}
	public void setR25_inward_other(BigDecimal r25_inward_other) {
		this.r25_inward_other = r25_inward_other;
	}
	public BigDecimal getR25_inward_total() {
		return r25_inward_total;
	}
	public void setR25_inward_total(BigDecimal r25_inward_total) {
		this.r25_inward_total = r25_inward_total;
	}
	public String getR26_european_countries13() {
		return r26_european_countries13;
	}
	public void setR26_european_countries13(String r26_european_countries13) {
		this.r26_european_countries13 = r26_european_countries13;
	}
	public BigDecimal getR26_outward_family() {
		return r26_outward_family;
	}
	public void setR26_outward_family(BigDecimal r26_outward_family) {
		this.r26_outward_family = r26_outward_family;
	}
	public BigDecimal getR26_outward_investment() {
		return r26_outward_investment;
	}
	public void setR26_outward_investment(BigDecimal r26_outward_investment) {
		this.r26_outward_investment = r26_outward_investment;
	}
	public BigDecimal getR26_outward_trade() {
		return r26_outward_trade;
	}
	public void setR26_outward_trade(BigDecimal r26_outward_trade) {
		this.r26_outward_trade = r26_outward_trade;
	}
	public BigDecimal getR26_outward_other() {
		return r26_outward_other;
	}
	public void setR26_outward_other(BigDecimal r26_outward_other) {
		this.r26_outward_other = r26_outward_other;
	}
	public BigDecimal getR26_outward_total() {
		return r26_outward_total;
	}
	public void setR26_outward_total(BigDecimal r26_outward_total) {
		this.r26_outward_total = r26_outward_total;
	}
	public BigDecimal getR26_inward_family() {
		return r26_inward_family;
	}
	public void setR26_inward_family(BigDecimal r26_inward_family) {
		this.r26_inward_family = r26_inward_family;
	}
	public BigDecimal getR26_inward_investment() {
		return r26_inward_investment;
	}
	public void setR26_inward_investment(BigDecimal r26_inward_investment) {
		this.r26_inward_investment = r26_inward_investment;
	}
	public BigDecimal getR26_inward_trade() {
		return r26_inward_trade;
	}
	public void setR26_inward_trade(BigDecimal r26_inward_trade) {
		this.r26_inward_trade = r26_inward_trade;
	}
	public BigDecimal getR26_inward_other() {
		return r26_inward_other;
	}
	public void setR26_inward_other(BigDecimal r26_inward_other) {
		this.r26_inward_other = r26_inward_other;
	}
	public BigDecimal getR26_inward_total() {
		return r26_inward_total;
	}
	public void setR26_inward_total(BigDecimal r26_inward_total) {
		this.r26_inward_total = r26_inward_total;
	}
	public String getR27_european_countries14() {
		return r27_european_countries14;
	}
	public void setR27_european_countries14(String r27_european_countries14) {
		this.r27_european_countries14 = r27_european_countries14;
	}
	public BigDecimal getR27_outward_family() {
		return r27_outward_family;
	}
	public void setR27_outward_family(BigDecimal r27_outward_family) {
		this.r27_outward_family = r27_outward_family;
	}
	public BigDecimal getR27_outward_investment() {
		return r27_outward_investment;
	}
	public void setR27_outward_investment(BigDecimal r27_outward_investment) {
		this.r27_outward_investment = r27_outward_investment;
	}
	public BigDecimal getR27_outward_trade() {
		return r27_outward_trade;
	}
	public void setR27_outward_trade(BigDecimal r27_outward_trade) {
		this.r27_outward_trade = r27_outward_trade;
	}
	public BigDecimal getR27_outward_other() {
		return r27_outward_other;
	}
	public void setR27_outward_other(BigDecimal r27_outward_other) {
		this.r27_outward_other = r27_outward_other;
	}
	public BigDecimal getR27_outward_total() {
		return r27_outward_total;
	}
	public void setR27_outward_total(BigDecimal r27_outward_total) {
		this.r27_outward_total = r27_outward_total;
	}
	public BigDecimal getR27_inward_family() {
		return r27_inward_family;
	}
	public void setR27_inward_family(BigDecimal r27_inward_family) {
		this.r27_inward_family = r27_inward_family;
	}
	public BigDecimal getR27_inward_investment() {
		return r27_inward_investment;
	}
	public void setR27_inward_investment(BigDecimal r27_inward_investment) {
		this.r27_inward_investment = r27_inward_investment;
	}
	public BigDecimal getR27_inward_trade() {
		return r27_inward_trade;
	}
	public void setR27_inward_trade(BigDecimal r27_inward_trade) {
		this.r27_inward_trade = r27_inward_trade;
	}
	public BigDecimal getR27_inward_other() {
		return r27_inward_other;
	}
	public void setR27_inward_other(BigDecimal r27_inward_other) {
		this.r27_inward_other = r27_inward_other;
	}
	public BigDecimal getR27_inward_total() {
		return r27_inward_total;
	}
	public void setR27_inward_total(BigDecimal r27_inward_total) {
		this.r27_inward_total = r27_inward_total;
	}
	public String getR28_european_countries15() {
		return r28_european_countries15;
	}
	public void setR28_european_countries15(String r28_european_countries15) {
		this.r28_european_countries15 = r28_european_countries15;
	}
	public BigDecimal getR28_outward_family() {
		return r28_outward_family;
	}
	public void setR28_outward_family(BigDecimal r28_outward_family) {
		this.r28_outward_family = r28_outward_family;
	}
	public BigDecimal getR28_outward_investment() {
		return r28_outward_investment;
	}
	public void setR28_outward_investment(BigDecimal r28_outward_investment) {
		this.r28_outward_investment = r28_outward_investment;
	}
	public BigDecimal getR28_outward_trade() {
		return r28_outward_trade;
	}
	public void setR28_outward_trade(BigDecimal r28_outward_trade) {
		this.r28_outward_trade = r28_outward_trade;
	}
	public BigDecimal getR28_outward_other() {
		return r28_outward_other;
	}
	public void setR28_outward_other(BigDecimal r28_outward_other) {
		this.r28_outward_other = r28_outward_other;
	}
	public BigDecimal getR28_outward_total() {
		return r28_outward_total;
	}
	public void setR28_outward_total(BigDecimal r28_outward_total) {
		this.r28_outward_total = r28_outward_total;
	}
	public BigDecimal getR28_inward_family() {
		return r28_inward_family;
	}
	public void setR28_inward_family(BigDecimal r28_inward_family) {
		this.r28_inward_family = r28_inward_family;
	}
	public BigDecimal getR28_inward_investment() {
		return r28_inward_investment;
	}
	public void setR28_inward_investment(BigDecimal r28_inward_investment) {
		this.r28_inward_investment = r28_inward_investment;
	}
	public BigDecimal getR28_inward_trade() {
		return r28_inward_trade;
	}
	public void setR28_inward_trade(BigDecimal r28_inward_trade) {
		this.r28_inward_trade = r28_inward_trade;
	}
	public BigDecimal getR28_inward_other() {
		return r28_inward_other;
	}
	public void setR28_inward_other(BigDecimal r28_inward_other) {
		this.r28_inward_other = r28_inward_other;
	}
	public BigDecimal getR28_inward_total() {
		return r28_inward_total;
	}
	public void setR28_inward_total(BigDecimal r28_inward_total) {
		this.r28_inward_total = r28_inward_total;
	}
	public String getR29_european_countries16() {
		return r29_european_countries16;
	}
	public void setR29_european_countries16(String r29_european_countries16) {
		this.r29_european_countries16 = r29_european_countries16;
	}
	public BigDecimal getR29_outward_family() {
		return r29_outward_family;
	}
	public void setR29_outward_family(BigDecimal r29_outward_family) {
		this.r29_outward_family = r29_outward_family;
	}
	public BigDecimal getR29_outward_investment() {
		return r29_outward_investment;
	}
	public void setR29_outward_investment(BigDecimal r29_outward_investment) {
		this.r29_outward_investment = r29_outward_investment;
	}
	public BigDecimal getR29_outward_trade() {
		return r29_outward_trade;
	}
	public void setR29_outward_trade(BigDecimal r29_outward_trade) {
		this.r29_outward_trade = r29_outward_trade;
	}
	public BigDecimal getR29_outward_other() {
		return r29_outward_other;
	}
	public void setR29_outward_other(BigDecimal r29_outward_other) {
		this.r29_outward_other = r29_outward_other;
	}
	public BigDecimal getR29_outward_total() {
		return r29_outward_total;
	}
	public void setR29_outward_total(BigDecimal r29_outward_total) {
		this.r29_outward_total = r29_outward_total;
	}
	public BigDecimal getR29_inward_family() {
		return r29_inward_family;
	}
	public void setR29_inward_family(BigDecimal r29_inward_family) {
		this.r29_inward_family = r29_inward_family;
	}
	public BigDecimal getR29_inward_investment() {
		return r29_inward_investment;
	}
	public void setR29_inward_investment(BigDecimal r29_inward_investment) {
		this.r29_inward_investment = r29_inward_investment;
	}
	public BigDecimal getR29_inward_trade() {
		return r29_inward_trade;
	}
	public void setR29_inward_trade(BigDecimal r29_inward_trade) {
		this.r29_inward_trade = r29_inward_trade;
	}
	public BigDecimal getR29_inward_other() {
		return r29_inward_other;
	}
	public void setR29_inward_other(BigDecimal r29_inward_other) {
		this.r29_inward_other = r29_inward_other;
	}
	public BigDecimal getR29_inward_total() {
		return r29_inward_total;
	}
	public void setR29_inward_total(BigDecimal r29_inward_total) {
		this.r29_inward_total = r29_inward_total;
	}
	public String getR30_european_countries17() {
		return r30_european_countries17;
	}
	public void setR30_european_countries17(String r30_european_countries17) {
		this.r30_european_countries17 = r30_european_countries17;
	}
	public BigDecimal getR30_outward_family() {
		return r30_outward_family;
	}
	public void setR30_outward_family(BigDecimal r30_outward_family) {
		this.r30_outward_family = r30_outward_family;
	}
	public BigDecimal getR30_outward_investment() {
		return r30_outward_investment;
	}
	public void setR30_outward_investment(BigDecimal r30_outward_investment) {
		this.r30_outward_investment = r30_outward_investment;
	}
	public BigDecimal getR30_outward_trade() {
		return r30_outward_trade;
	}
	public void setR30_outward_trade(BigDecimal r30_outward_trade) {
		this.r30_outward_trade = r30_outward_trade;
	}
	public BigDecimal getR30_outward_other() {
		return r30_outward_other;
	}
	public void setR30_outward_other(BigDecimal r30_outward_other) {
		this.r30_outward_other = r30_outward_other;
	}
	public BigDecimal getR30_outward_total() {
		return r30_outward_total;
	}
	public void setR30_outward_total(BigDecimal r30_outward_total) {
		this.r30_outward_total = r30_outward_total;
	}
	public BigDecimal getR30_inward_family() {
		return r30_inward_family;
	}
	public void setR30_inward_family(BigDecimal r30_inward_family) {
		this.r30_inward_family = r30_inward_family;
	}
	public BigDecimal getR30_inward_investment() {
		return r30_inward_investment;
	}
	public void setR30_inward_investment(BigDecimal r30_inward_investment) {
		this.r30_inward_investment = r30_inward_investment;
	}
	public BigDecimal getR30_inward_trade() {
		return r30_inward_trade;
	}
	public void setR30_inward_trade(BigDecimal r30_inward_trade) {
		this.r30_inward_trade = r30_inward_trade;
	}
	public BigDecimal getR30_inward_other() {
		return r30_inward_other;
	}
	public void setR30_inward_other(BigDecimal r30_inward_other) {
		this.r30_inward_other = r30_inward_other;
	}
	public BigDecimal getR30_inward_total() {
		return r30_inward_total;
	}
	public void setR30_inward_total(BigDecimal r30_inward_total) {
		this.r30_inward_total = r30_inward_total;
	}
	public String getR31_european_countries18() {
		return r31_european_countries18;
	}
	public void setR31_european_countries18(String r31_european_countries18) {
		this.r31_european_countries18 = r31_european_countries18;
	}
	public BigDecimal getR31_outward_family() {
		return r31_outward_family;
	}
	public void setR31_outward_family(BigDecimal r31_outward_family) {
		this.r31_outward_family = r31_outward_family;
	}
	public BigDecimal getR31_outward_investment() {
		return r31_outward_investment;
	}
	public void setR31_outward_investment(BigDecimal r31_outward_investment) {
		this.r31_outward_investment = r31_outward_investment;
	}
	public BigDecimal getR31_outward_trade() {
		return r31_outward_trade;
	}
	public void setR31_outward_trade(BigDecimal r31_outward_trade) {
		this.r31_outward_trade = r31_outward_trade;
	}
	public BigDecimal getR31_outward_other() {
		return r31_outward_other;
	}
	public void setR31_outward_other(BigDecimal r31_outward_other) {
		this.r31_outward_other = r31_outward_other;
	}
	public BigDecimal getR31_outward_total() {
		return r31_outward_total;
	}
	public void setR31_outward_total(BigDecimal r31_outward_total) {
		this.r31_outward_total = r31_outward_total;
	}
	public BigDecimal getR31_inward_family() {
		return r31_inward_family;
	}
	public void setR31_inward_family(BigDecimal r31_inward_family) {
		this.r31_inward_family = r31_inward_family;
	}
	public BigDecimal getR31_inward_investment() {
		return r31_inward_investment;
	}
	public void setR31_inward_investment(BigDecimal r31_inward_investment) {
		this.r31_inward_investment = r31_inward_investment;
	}
	public BigDecimal getR31_inward_trade() {
		return r31_inward_trade;
	}
	public void setR31_inward_trade(BigDecimal r31_inward_trade) {
		this.r31_inward_trade = r31_inward_trade;
	}
	public BigDecimal getR31_inward_other() {
		return r31_inward_other;
	}
	public void setR31_inward_other(BigDecimal r31_inward_other) {
		this.r31_inward_other = r31_inward_other;
	}
	public BigDecimal getR31_inward_total() {
		return r31_inward_total;
	}
	public void setR31_inward_total(BigDecimal r31_inward_total) {
		this.r31_inward_total = r31_inward_total;
	}
	public String getR32_european_countries19() {
		return r32_european_countries19;
	}
	public void setR32_european_countries19(String r32_european_countries19) {
		this.r32_european_countries19 = r32_european_countries19;
	}
	public BigDecimal getR32_outward_family() {
		return r32_outward_family;
	}
	public void setR32_outward_family(BigDecimal r32_outward_family) {
		this.r32_outward_family = r32_outward_family;
	}
	public BigDecimal getR32_outward_investment() {
		return r32_outward_investment;
	}
	public void setR32_outward_investment(BigDecimal r32_outward_investment) {
		this.r32_outward_investment = r32_outward_investment;
	}
	public BigDecimal getR32_outward_trade() {
		return r32_outward_trade;
	}
	public void setR32_outward_trade(BigDecimal r32_outward_trade) {
		this.r32_outward_trade = r32_outward_trade;
	}
	public BigDecimal getR32_outward_other() {
		return r32_outward_other;
	}
	public void setR32_outward_other(BigDecimal r32_outward_other) {
		this.r32_outward_other = r32_outward_other;
	}
	public BigDecimal getR32_outward_total() {
		return r32_outward_total;
	}
	public void setR32_outward_total(BigDecimal r32_outward_total) {
		this.r32_outward_total = r32_outward_total;
	}
	public BigDecimal getR32_inward_family() {
		return r32_inward_family;
	}
	public void setR32_inward_family(BigDecimal r32_inward_family) {
		this.r32_inward_family = r32_inward_family;
	}
	public BigDecimal getR32_inward_investment() {
		return r32_inward_investment;
	}
	public void setR32_inward_investment(BigDecimal r32_inward_investment) {
		this.r32_inward_investment = r32_inward_investment;
	}
	public BigDecimal getR32_inward_trade() {
		return r32_inward_trade;
	}
	public void setR32_inward_trade(BigDecimal r32_inward_trade) {
		this.r32_inward_trade = r32_inward_trade;
	}
	public BigDecimal getR32_inward_other() {
		return r32_inward_other;
	}
	public void setR32_inward_other(BigDecimal r32_inward_other) {
		this.r32_inward_other = r32_inward_other;
	}
	public BigDecimal getR32_inward_total() {
		return r32_inward_total;
	}
	public void setR32_inward_total(BigDecimal r32_inward_total) {
		this.r32_inward_total = r32_inward_total;
	}
	public String getR33_european_countries20() {
		return r33_european_countries20;
	}
	public void setR33_european_countries20(String r33_european_countries20) {
		this.r33_european_countries20 = r33_european_countries20;
	}
	public BigDecimal getR33_outward_family() {
		return r33_outward_family;
	}
	public void setR33_outward_family(BigDecimal r33_outward_family) {
		this.r33_outward_family = r33_outward_family;
	}
	public BigDecimal getR33_outward_investment() {
		return r33_outward_investment;
	}
	public void setR33_outward_investment(BigDecimal r33_outward_investment) {
		this.r33_outward_investment = r33_outward_investment;
	}
	public BigDecimal getR33_outward_trade() {
		return r33_outward_trade;
	}
	public void setR33_outward_trade(BigDecimal r33_outward_trade) {
		this.r33_outward_trade = r33_outward_trade;
	}
	public BigDecimal getR33_outward_other() {
		return r33_outward_other;
	}
	public void setR33_outward_other(BigDecimal r33_outward_other) {
		this.r33_outward_other = r33_outward_other;
	}
	public BigDecimal getR33_outward_total() {
		return r33_outward_total;
	}
	public void setR33_outward_total(BigDecimal r33_outward_total) {
		this.r33_outward_total = r33_outward_total;
	}
	public BigDecimal getR33_inward_family() {
		return r33_inward_family;
	}
	public void setR33_inward_family(BigDecimal r33_inward_family) {
		this.r33_inward_family = r33_inward_family;
	}
	public BigDecimal getR33_inward_investment() {
		return r33_inward_investment;
	}
	public void setR33_inward_investment(BigDecimal r33_inward_investment) {
		this.r33_inward_investment = r33_inward_investment;
	}
	public BigDecimal getR33_inward_trade() {
		return r33_inward_trade;
	}
	public void setR33_inward_trade(BigDecimal r33_inward_trade) {
		this.r33_inward_trade = r33_inward_trade;
	}
	public BigDecimal getR33_inward_other() {
		return r33_inward_other;
	}
	public void setR33_inward_other(BigDecimal r33_inward_other) {
		this.r33_inward_other = r33_inward_other;
	}
	public BigDecimal getR33_inward_total() {
		return r33_inward_total;
	}
	public void setR33_inward_total(BigDecimal r33_inward_total) {
		this.r33_inward_total = r33_inward_total;
	}
	public String getR34_european_countries21() {
		return r34_european_countries21;
	}
	public void setR34_european_countries21(String r34_european_countries21) {
		this.r34_european_countries21 = r34_european_countries21;
	}
	public BigDecimal getR34_outward_family() {
		return r34_outward_family;
	}
	public void setR34_outward_family(BigDecimal r34_outward_family) {
		this.r34_outward_family = r34_outward_family;
	}
	public BigDecimal getR34_outward_investment() {
		return r34_outward_investment;
	}
	public void setR34_outward_investment(BigDecimal r34_outward_investment) {
		this.r34_outward_investment = r34_outward_investment;
	}
	public BigDecimal getR34_outward_trade() {
		return r34_outward_trade;
	}
	public void setR34_outward_trade(BigDecimal r34_outward_trade) {
		this.r34_outward_trade = r34_outward_trade;
	}
	public BigDecimal getR34_outward_other() {
		return r34_outward_other;
	}
	public void setR34_outward_other(BigDecimal r34_outward_other) {
		this.r34_outward_other = r34_outward_other;
	}
	public BigDecimal getR34_outward_total() {
		return r34_outward_total;
	}
	public void setR34_outward_total(BigDecimal r34_outward_total) {
		this.r34_outward_total = r34_outward_total;
	}
	public BigDecimal getR34_inward_family() {
		return r34_inward_family;
	}
	public void setR34_inward_family(BigDecimal r34_inward_family) {
		this.r34_inward_family = r34_inward_family;
	}
	public BigDecimal getR34_inward_investment() {
		return r34_inward_investment;
	}
	public void setR34_inward_investment(BigDecimal r34_inward_investment) {
		this.r34_inward_investment = r34_inward_investment;
	}
	public BigDecimal getR34_inward_trade() {
		return r34_inward_trade;
	}
	public void setR34_inward_trade(BigDecimal r34_inward_trade) {
		this.r34_inward_trade = r34_inward_trade;
	}
	public BigDecimal getR34_inward_other() {
		return r34_inward_other;
	}
	public void setR34_inward_other(BigDecimal r34_inward_other) {
		this.r34_inward_other = r34_inward_other;
	}
	public BigDecimal getR34_inward_total() {
		return r34_inward_total;
	}
	public void setR34_inward_total(BigDecimal r34_inward_total) {
		this.r34_inward_total = r34_inward_total;
	}
	public String getR35_gcc_countries() {
		return r35_gcc_countries;
	}
	public void setR35_gcc_countries(String r35_gcc_countries) {
		this.r35_gcc_countries = r35_gcc_countries;
	}
	public BigDecimal getR35_outward_family() {
		return r35_outward_family;
	}
	public void setR35_outward_family(BigDecimal r35_outward_family) {
		this.r35_outward_family = r35_outward_family;
	}
	public BigDecimal getR35_outward_investment() {
		return r35_outward_investment;
	}
	public void setR35_outward_investment(BigDecimal r35_outward_investment) {
		this.r35_outward_investment = r35_outward_investment;
	}
	public BigDecimal getR35_outward_trade() {
		return r35_outward_trade;
	}
	public void setR35_outward_trade(BigDecimal r35_outward_trade) {
		this.r35_outward_trade = r35_outward_trade;
	}
	public BigDecimal getR35_outward_other() {
		return r35_outward_other;
	}
	public void setR35_outward_other(BigDecimal r35_outward_other) {
		this.r35_outward_other = r35_outward_other;
	}
	public BigDecimal getR35_outward_total() {
		return r35_outward_total;
	}
	public void setR35_outward_total(BigDecimal r35_outward_total) {
		this.r35_outward_total = r35_outward_total;
	}
	public BigDecimal getR35_inward_family() {
		return r35_inward_family;
	}
	public void setR35_inward_family(BigDecimal r35_inward_family) {
		this.r35_inward_family = r35_inward_family;
	}
	public BigDecimal getR35_inward_investment() {
		return r35_inward_investment;
	}
	public void setR35_inward_investment(BigDecimal r35_inward_investment) {
		this.r35_inward_investment = r35_inward_investment;
	}
	public BigDecimal getR35_inward_trade() {
		return r35_inward_trade;
	}
	public void setR35_inward_trade(BigDecimal r35_inward_trade) {
		this.r35_inward_trade = r35_inward_trade;
	}
	public BigDecimal getR35_inward_other() {
		return r35_inward_other;
	}
	public void setR35_inward_other(BigDecimal r35_inward_other) {
		this.r35_inward_other = r35_inward_other;
	}
	public BigDecimal getR35_inward_total() {
		return r35_inward_total;
	}
	public void setR35_inward_total(BigDecimal r35_inward_total) {
		this.r35_inward_total = r35_inward_total;
	}
	public String getR36_gcc_countries1() {
		return r36_gcc_countries1;
	}
	public void setR36_gcc_countries1(String r36_gcc_countries1) {
		this.r36_gcc_countries1 = r36_gcc_countries1;
	}
	public BigDecimal getR36_outward_family() {
		return r36_outward_family;
	}
	public void setR36_outward_family(BigDecimal r36_outward_family) {
		this.r36_outward_family = r36_outward_family;
	}
	public BigDecimal getR36_outward_investment() {
		return r36_outward_investment;
	}
	public void setR36_outward_investment(BigDecimal r36_outward_investment) {
		this.r36_outward_investment = r36_outward_investment;
	}
	public BigDecimal getR36_outward_trade() {
		return r36_outward_trade;
	}
	public void setR36_outward_trade(BigDecimal r36_outward_trade) {
		this.r36_outward_trade = r36_outward_trade;
	}
	public BigDecimal getR36_outward_other() {
		return r36_outward_other;
	}
	public void setR36_outward_other(BigDecimal r36_outward_other) {
		this.r36_outward_other = r36_outward_other;
	}
	public BigDecimal getR36_outward_total() {
		return r36_outward_total;
	}
	public void setR36_outward_total(BigDecimal r36_outward_total) {
		this.r36_outward_total = r36_outward_total;
	}
	public BigDecimal getR36_inward_family() {
		return r36_inward_family;
	}
	public void setR36_inward_family(BigDecimal r36_inward_family) {
		this.r36_inward_family = r36_inward_family;
	}
	public BigDecimal getR36_inward_investment() {
		return r36_inward_investment;
	}
	public void setR36_inward_investment(BigDecimal r36_inward_investment) {
		this.r36_inward_investment = r36_inward_investment;
	}
	public BigDecimal getR36_inward_trade() {
		return r36_inward_trade;
	}
	public void setR36_inward_trade(BigDecimal r36_inward_trade) {
		this.r36_inward_trade = r36_inward_trade;
	}
	public BigDecimal getR36_inward_other() {
		return r36_inward_other;
	}
	public void setR36_inward_other(BigDecimal r36_inward_other) {
		this.r36_inward_other = r36_inward_other;
	}
	public BigDecimal getR36_inward_total() {
		return r36_inward_total;
	}
	public void setR36_inward_total(BigDecimal r36_inward_total) {
		this.r36_inward_total = r36_inward_total;
	}
	public String getR37_gcc_countries2() {
		return r37_gcc_countries2;
	}
	public void setR37_gcc_countries2(String r37_gcc_countries2) {
		this.r37_gcc_countries2 = r37_gcc_countries2;
	}
	public BigDecimal getR37_outward_family() {
		return r37_outward_family;
	}
	public void setR37_outward_family(BigDecimal r37_outward_family) {
		this.r37_outward_family = r37_outward_family;
	}
	public BigDecimal getR37_outward_investment() {
		return r37_outward_investment;
	}
	public void setR37_outward_investment(BigDecimal r37_outward_investment) {
		this.r37_outward_investment = r37_outward_investment;
	}
	public BigDecimal getR37_outward_trade() {
		return r37_outward_trade;
	}
	public void setR37_outward_trade(BigDecimal r37_outward_trade) {
		this.r37_outward_trade = r37_outward_trade;
	}
	public BigDecimal getR37_outward_other() {
		return r37_outward_other;
	}
	public void setR37_outward_other(BigDecimal r37_outward_other) {
		this.r37_outward_other = r37_outward_other;
	}
	public BigDecimal getR37_outward_total() {
		return r37_outward_total;
	}
	public void setR37_outward_total(BigDecimal r37_outward_total) {
		this.r37_outward_total = r37_outward_total;
	}
	public BigDecimal getR37_inward_family() {
		return r37_inward_family;
	}
	public void setR37_inward_family(BigDecimal r37_inward_family) {
		this.r37_inward_family = r37_inward_family;
	}
	public BigDecimal getR37_inward_investment() {
		return r37_inward_investment;
	}
	public void setR37_inward_investment(BigDecimal r37_inward_investment) {
		this.r37_inward_investment = r37_inward_investment;
	}
	public BigDecimal getR37_inward_trade() {
		return r37_inward_trade;
	}
	public void setR37_inward_trade(BigDecimal r37_inward_trade) {
		this.r37_inward_trade = r37_inward_trade;
	}
	public BigDecimal getR37_inward_other() {
		return r37_inward_other;
	}
	public void setR37_inward_other(BigDecimal r37_inward_other) {
		this.r37_inward_other = r37_inward_other;
	}
	public BigDecimal getR37_inward_total() {
		return r37_inward_total;
	}
	public void setR37_inward_total(BigDecimal r37_inward_total) {
		this.r37_inward_total = r37_inward_total;
	}
	public String getR38_gcc_countries3() {
		return r38_gcc_countries3;
	}
	public void setR38_gcc_countries3(String r38_gcc_countries3) {
		this.r38_gcc_countries3 = r38_gcc_countries3;
	}
	public BigDecimal getR38_outward_family() {
		return r38_outward_family;
	}
	public void setR38_outward_family(BigDecimal r38_outward_family) {
		this.r38_outward_family = r38_outward_family;
	}
	public BigDecimal getR38_outward_investment() {
		return r38_outward_investment;
	}
	public void setR38_outward_investment(BigDecimal r38_outward_investment) {
		this.r38_outward_investment = r38_outward_investment;
	}
	public BigDecimal getR38_outward_trade() {
		return r38_outward_trade;
	}
	public void setR38_outward_trade(BigDecimal r38_outward_trade) {
		this.r38_outward_trade = r38_outward_trade;
	}
	public BigDecimal getR38_outward_other() {
		return r38_outward_other;
	}
	public void setR38_outward_other(BigDecimal r38_outward_other) {
		this.r38_outward_other = r38_outward_other;
	}
	public BigDecimal getR38_outward_total() {
		return r38_outward_total;
	}
	public void setR38_outward_total(BigDecimal r38_outward_total) {
		this.r38_outward_total = r38_outward_total;
	}
	public BigDecimal getR38_inward_family() {
		return r38_inward_family;
	}
	public void setR38_inward_family(BigDecimal r38_inward_family) {
		this.r38_inward_family = r38_inward_family;
	}
	public BigDecimal getR38_inward_investment() {
		return r38_inward_investment;
	}
	public void setR38_inward_investment(BigDecimal r38_inward_investment) {
		this.r38_inward_investment = r38_inward_investment;
	}
	public BigDecimal getR38_inward_trade() {
		return r38_inward_trade;
	}
	public void setR38_inward_trade(BigDecimal r38_inward_trade) {
		this.r38_inward_trade = r38_inward_trade;
	}
	public BigDecimal getR38_inward_other() {
		return r38_inward_other;
	}
	public void setR38_inward_other(BigDecimal r38_inward_other) {
		this.r38_inward_other = r38_inward_other;
	}
	public BigDecimal getR38_inward_total() {
		return r38_inward_total;
	}
	public void setR38_inward_total(BigDecimal r38_inward_total) {
		this.r38_inward_total = r38_inward_total;
	}
	public String getR39_gcc_countries4() {
		return r39_gcc_countries4;
	}
	public void setR39_gcc_countries4(String r39_gcc_countries4) {
		this.r39_gcc_countries4 = r39_gcc_countries4;
	}
	public BigDecimal getR39_outward_family() {
		return r39_outward_family;
	}
	public void setR39_outward_family(BigDecimal r39_outward_family) {
		this.r39_outward_family = r39_outward_family;
	}
	public BigDecimal getR39_outward_investment() {
		return r39_outward_investment;
	}
	public void setR39_outward_investment(BigDecimal r39_outward_investment) {
		this.r39_outward_investment = r39_outward_investment;
	}
	public BigDecimal getR39_outward_trade() {
		return r39_outward_trade;
	}
	public void setR39_outward_trade(BigDecimal r39_outward_trade) {
		this.r39_outward_trade = r39_outward_trade;
	}
	public BigDecimal getR39_outward_other() {
		return r39_outward_other;
	}
	public void setR39_outward_other(BigDecimal r39_outward_other) {
		this.r39_outward_other = r39_outward_other;
	}
	public BigDecimal getR39_outward_total() {
		return r39_outward_total;
	}
	public void setR39_outward_total(BigDecimal r39_outward_total) {
		this.r39_outward_total = r39_outward_total;
	}
	public BigDecimal getR39_inward_family() {
		return r39_inward_family;
	}
	public void setR39_inward_family(BigDecimal r39_inward_family) {
		this.r39_inward_family = r39_inward_family;
	}
	public BigDecimal getR39_inward_investment() {
		return r39_inward_investment;
	}
	public void setR39_inward_investment(BigDecimal r39_inward_investment) {
		this.r39_inward_investment = r39_inward_investment;
	}
	public BigDecimal getR39_inward_trade() {
		return r39_inward_trade;
	}
	public void setR39_inward_trade(BigDecimal r39_inward_trade) {
		this.r39_inward_trade = r39_inward_trade;
	}
	public BigDecimal getR39_inward_other() {
		return r39_inward_other;
	}
	public void setR39_inward_other(BigDecimal r39_inward_other) {
		this.r39_inward_other = r39_inward_other;
	}
	public BigDecimal getR39_inward_total() {
		return r39_inward_total;
	}
	public void setR39_inward_total(BigDecimal r39_inward_total) {
		this.r39_inward_total = r39_inward_total;
	}
	public String getR40_gcc_countries5() {
		return r40_gcc_countries5;
	}
	public void setR40_gcc_countries5(String r40_gcc_countries5) {
		this.r40_gcc_countries5 = r40_gcc_countries5;
	}
	public BigDecimal getR40_outward_family() {
		return r40_outward_family;
	}
	public void setR40_outward_family(BigDecimal r40_outward_family) {
		this.r40_outward_family = r40_outward_family;
	}
	public BigDecimal getR40_outward_investment() {
		return r40_outward_investment;
	}
	public void setR40_outward_investment(BigDecimal r40_outward_investment) {
		this.r40_outward_investment = r40_outward_investment;
	}
	public BigDecimal getR40_outward_trade() {
		return r40_outward_trade;
	}
	public void setR40_outward_trade(BigDecimal r40_outward_trade) {
		this.r40_outward_trade = r40_outward_trade;
	}
	public BigDecimal getR40_outward_other() {
		return r40_outward_other;
	}
	public void setR40_outward_other(BigDecimal r40_outward_other) {
		this.r40_outward_other = r40_outward_other;
	}
	public BigDecimal getR40_outward_total() {
		return r40_outward_total;
	}
	public void setR40_outward_total(BigDecimal r40_outward_total) {
		this.r40_outward_total = r40_outward_total;
	}
	public BigDecimal getR40_inward_family() {
		return r40_inward_family;
	}
	public void setR40_inward_family(BigDecimal r40_inward_family) {
		this.r40_inward_family = r40_inward_family;
	}
	public BigDecimal getR40_inward_investment() {
		return r40_inward_investment;
	}
	public void setR40_inward_investment(BigDecimal r40_inward_investment) {
		this.r40_inward_investment = r40_inward_investment;
	}
	public BigDecimal getR40_inward_trade() {
		return r40_inward_trade;
	}
	public void setR40_inward_trade(BigDecimal r40_inward_trade) {
		this.r40_inward_trade = r40_inward_trade;
	}
	public BigDecimal getR40_inward_other() {
		return r40_inward_other;
	}
	public void setR40_inward_other(BigDecimal r40_inward_other) {
		this.r40_inward_other = r40_inward_other;
	}
	public BigDecimal getR40_inward_total() {
		return r40_inward_total;
	}
	public void setR40_inward_total(BigDecimal r40_inward_total) {
		this.r40_inward_total = r40_inward_total;
	}
	public String getR41_mena_countries() {
		return r41_mena_countries;
	}
	public void setR41_mena_countries(String r41_mena_countries) {
		this.r41_mena_countries = r41_mena_countries;
	}
	public BigDecimal getR41_outward_family() {
		return r41_outward_family;
	}
	public void setR41_outward_family(BigDecimal r41_outward_family) {
		this.r41_outward_family = r41_outward_family;
	}
	public BigDecimal getR41_outward_investment() {
		return r41_outward_investment;
	}
	public void setR41_outward_investment(BigDecimal r41_outward_investment) {
		this.r41_outward_investment = r41_outward_investment;
	}
	public BigDecimal getR41_outward_trade() {
		return r41_outward_trade;
	}
	public void setR41_outward_trade(BigDecimal r41_outward_trade) {
		this.r41_outward_trade = r41_outward_trade;
	}
	public BigDecimal getR41_outward_other() {
		return r41_outward_other;
	}
	public void setR41_outward_other(BigDecimal r41_outward_other) {
		this.r41_outward_other = r41_outward_other;
	}
	public BigDecimal getR41_outward_total() {
		return r41_outward_total;
	}
	public void setR41_outward_total(BigDecimal r41_outward_total) {
		this.r41_outward_total = r41_outward_total;
	}
	public BigDecimal getR41_inward_family() {
		return r41_inward_family;
	}
	public void setR41_inward_family(BigDecimal r41_inward_family) {
		this.r41_inward_family = r41_inward_family;
	}
	public BigDecimal getR41_inward_investment() {
		return r41_inward_investment;
	}
	public void setR41_inward_investment(BigDecimal r41_inward_investment) {
		this.r41_inward_investment = r41_inward_investment;
	}
	public BigDecimal getR41_inward_trade() {
		return r41_inward_trade;
	}
	public void setR41_inward_trade(BigDecimal r41_inward_trade) {
		this.r41_inward_trade = r41_inward_trade;
	}
	public BigDecimal getR41_inward_other() {
		return r41_inward_other;
	}
	public void setR41_inward_other(BigDecimal r41_inward_other) {
		this.r41_inward_other = r41_inward_other;
	}
	public BigDecimal getR41_inward_total() {
		return r41_inward_total;
	}
	public void setR41_inward_total(BigDecimal r41_inward_total) {
		this.r41_inward_total = r41_inward_total;
	}
	public String getR42_mena_countries1() {
		return r42_mena_countries1;
	}
	public void setR42_mena_countries1(String r42_mena_countries1) {
		this.r42_mena_countries1 = r42_mena_countries1;
	}
	public BigDecimal getR42_outward_family() {
		return r42_outward_family;
	}
	public void setR42_outward_family(BigDecimal r42_outward_family) {
		this.r42_outward_family = r42_outward_family;
	}
	public BigDecimal getR42_outward_investment() {
		return r42_outward_investment;
	}
	public void setR42_outward_investment(BigDecimal r42_outward_investment) {
		this.r42_outward_investment = r42_outward_investment;
	}
	public BigDecimal getR42_outward_trade() {
		return r42_outward_trade;
	}
	public void setR42_outward_trade(BigDecimal r42_outward_trade) {
		this.r42_outward_trade = r42_outward_trade;
	}
	public BigDecimal getR42_outward_other() {
		return r42_outward_other;
	}
	public void setR42_outward_other(BigDecimal r42_outward_other) {
		this.r42_outward_other = r42_outward_other;
	}
	public BigDecimal getR42_outward_total() {
		return r42_outward_total;
	}
	public void setR42_outward_total(BigDecimal r42_outward_total) {
		this.r42_outward_total = r42_outward_total;
	}
	public BigDecimal getR42_inward_family() {
		return r42_inward_family;
	}
	public void setR42_inward_family(BigDecimal r42_inward_family) {
		this.r42_inward_family = r42_inward_family;
	}
	public BigDecimal getR42_inward_investment() {
		return r42_inward_investment;
	}
	public void setR42_inward_investment(BigDecimal r42_inward_investment) {
		this.r42_inward_investment = r42_inward_investment;
	}
	public BigDecimal getR42_inward_trade() {
		return r42_inward_trade;
	}
	public void setR42_inward_trade(BigDecimal r42_inward_trade) {
		this.r42_inward_trade = r42_inward_trade;
	}
	public BigDecimal getR42_inward_other() {
		return r42_inward_other;
	}
	public void setR42_inward_other(BigDecimal r42_inward_other) {
		this.r42_inward_other = r42_inward_other;
	}
	public BigDecimal getR42_inward_total() {
		return r42_inward_total;
	}
	public void setR42_inward_total(BigDecimal r42_inward_total) {
		this.r42_inward_total = r42_inward_total;
	}
	public String getR43_mena_countries2() {
		return r43_mena_countries2;
	}
	public void setR43_mena_countries2(String r43_mena_countries2) {
		this.r43_mena_countries2 = r43_mena_countries2;
	}
	public BigDecimal getR43_outward_family() {
		return r43_outward_family;
	}
	public void setR43_outward_family(BigDecimal r43_outward_family) {
		this.r43_outward_family = r43_outward_family;
	}
	public BigDecimal getR43_outward_investment() {
		return r43_outward_investment;
	}
	public void setR43_outward_investment(BigDecimal r43_outward_investment) {
		this.r43_outward_investment = r43_outward_investment;
	}
	public BigDecimal getR43_outward_trade() {
		return r43_outward_trade;
	}
	public void setR43_outward_trade(BigDecimal r43_outward_trade) {
		this.r43_outward_trade = r43_outward_trade;
	}
	public BigDecimal getR43_outward_other() {
		return r43_outward_other;
	}
	public void setR43_outward_other(BigDecimal r43_outward_other) {
		this.r43_outward_other = r43_outward_other;
	}
	public BigDecimal getR43_outward_total() {
		return r43_outward_total;
	}
	public void setR43_outward_total(BigDecimal r43_outward_total) {
		this.r43_outward_total = r43_outward_total;
	}
	public BigDecimal getR43_inward_family() {
		return r43_inward_family;
	}
	public void setR43_inward_family(BigDecimal r43_inward_family) {
		this.r43_inward_family = r43_inward_family;
	}
	public BigDecimal getR43_inward_investment() {
		return r43_inward_investment;
	}
	public void setR43_inward_investment(BigDecimal r43_inward_investment) {
		this.r43_inward_investment = r43_inward_investment;
	}
	public BigDecimal getR43_inward_trade() {
		return r43_inward_trade;
	}
	public void setR43_inward_trade(BigDecimal r43_inward_trade) {
		this.r43_inward_trade = r43_inward_trade;
	}
	public BigDecimal getR43_inward_other() {
		return r43_inward_other;
	}
	public void setR43_inward_other(BigDecimal r43_inward_other) {
		this.r43_inward_other = r43_inward_other;
	}
	public BigDecimal getR43_inward_total() {
		return r43_inward_total;
	}
	public void setR43_inward_total(BigDecimal r43_inward_total) {
		this.r43_inward_total = r43_inward_total;
	}
	public String getR44_mena_countries3() {
		return r44_mena_countries3;
	}
	public void setR44_mena_countries3(String r44_mena_countries3) {
		this.r44_mena_countries3 = r44_mena_countries3;
	}
	public BigDecimal getR44_outward_family() {
		return r44_outward_family;
	}
	public void setR44_outward_family(BigDecimal r44_outward_family) {
		this.r44_outward_family = r44_outward_family;
	}
	public BigDecimal getR44_outward_investment() {
		return r44_outward_investment;
	}
	public void setR44_outward_investment(BigDecimal r44_outward_investment) {
		this.r44_outward_investment = r44_outward_investment;
	}
	public BigDecimal getR44_outward_trade() {
		return r44_outward_trade;
	}
	public void setR44_outward_trade(BigDecimal r44_outward_trade) {
		this.r44_outward_trade = r44_outward_trade;
	}
	public BigDecimal getR44_outward_other() {
		return r44_outward_other;
	}
	public void setR44_outward_other(BigDecimal r44_outward_other) {
		this.r44_outward_other = r44_outward_other;
	}
	public BigDecimal getR44_outward_total() {
		return r44_outward_total;
	}
	public void setR44_outward_total(BigDecimal r44_outward_total) {
		this.r44_outward_total = r44_outward_total;
	}
	public BigDecimal getR44_inward_family() {
		return r44_inward_family;
	}
	public void setR44_inward_family(BigDecimal r44_inward_family) {
		this.r44_inward_family = r44_inward_family;
	}
	public BigDecimal getR44_inward_investment() {
		return r44_inward_investment;
	}
	public void setR44_inward_investment(BigDecimal r44_inward_investment) {
		this.r44_inward_investment = r44_inward_investment;
	}
	public BigDecimal getR44_inward_trade() {
		return r44_inward_trade;
	}
	public void setR44_inward_trade(BigDecimal r44_inward_trade) {
		this.r44_inward_trade = r44_inward_trade;
	}
	public BigDecimal getR44_inward_other() {
		return r44_inward_other;
	}
	public void setR44_inward_other(BigDecimal r44_inward_other) {
		this.r44_inward_other = r44_inward_other;
	}
	public BigDecimal getR44_inward_total() {
		return r44_inward_total;
	}
	public void setR44_inward_total(BigDecimal r44_inward_total) {
		this.r44_inward_total = r44_inward_total;
	}
	public String getR45_mena_countries4() {
		return r45_mena_countries4;
	}
	public void setR45_mena_countries4(String r45_mena_countries4) {
		this.r45_mena_countries4 = r45_mena_countries4;
	}
	public BigDecimal getR45_outward_family() {
		return r45_outward_family;
	}
	public void setR45_outward_family(BigDecimal r45_outward_family) {
		this.r45_outward_family = r45_outward_family;
	}
	public BigDecimal getR45_outward_investment() {
		return r45_outward_investment;
	}
	public void setR45_outward_investment(BigDecimal r45_outward_investment) {
		this.r45_outward_investment = r45_outward_investment;
	}
	public BigDecimal getR45_outward_trade() {
		return r45_outward_trade;
	}
	public void setR45_outward_trade(BigDecimal r45_outward_trade) {
		this.r45_outward_trade = r45_outward_trade;
	}
	public BigDecimal getR45_outward_other() {
		return r45_outward_other;
	}
	public void setR45_outward_other(BigDecimal r45_outward_other) {
		this.r45_outward_other = r45_outward_other;
	}
	public BigDecimal getR45_outward_total() {
		return r45_outward_total;
	}
	public void setR45_outward_total(BigDecimal r45_outward_total) {
		this.r45_outward_total = r45_outward_total;
	}
	public BigDecimal getR45_inward_family() {
		return r45_inward_family;
	}
	public void setR45_inward_family(BigDecimal r45_inward_family) {
		this.r45_inward_family = r45_inward_family;
	}
	public BigDecimal getR45_inward_investment() {
		return r45_inward_investment;
	}
	public void setR45_inward_investment(BigDecimal r45_inward_investment) {
		this.r45_inward_investment = r45_inward_investment;
	}
	public BigDecimal getR45_inward_trade() {
		return r45_inward_trade;
	}
	public void setR45_inward_trade(BigDecimal r45_inward_trade) {
		this.r45_inward_trade = r45_inward_trade;
	}
	public BigDecimal getR45_inward_other() {
		return r45_inward_other;
	}
	public void setR45_inward_other(BigDecimal r45_inward_other) {
		this.r45_inward_other = r45_inward_other;
	}
	public BigDecimal getR45_inward_total() {
		return r45_inward_total;
	}
	public void setR45_inward_total(BigDecimal r45_inward_total) {
		this.r45_inward_total = r45_inward_total;
	}
	public String getR46_mena_countries5() {
		return r46_mena_countries5;
	}
	public void setR46_mena_countries5(String r46_mena_countries5) {
		this.r46_mena_countries5 = r46_mena_countries5;
	}
	public BigDecimal getR46_outward_family() {
		return r46_outward_family;
	}
	public void setR46_outward_family(BigDecimal r46_outward_family) {
		this.r46_outward_family = r46_outward_family;
	}
	public BigDecimal getR46_outward_investment() {
		return r46_outward_investment;
	}
	public void setR46_outward_investment(BigDecimal r46_outward_investment) {
		this.r46_outward_investment = r46_outward_investment;
	}
	public BigDecimal getR46_outward_trade() {
		return r46_outward_trade;
	}
	public void setR46_outward_trade(BigDecimal r46_outward_trade) {
		this.r46_outward_trade = r46_outward_trade;
	}
	public BigDecimal getR46_outward_other() {
		return r46_outward_other;
	}
	public void setR46_outward_other(BigDecimal r46_outward_other) {
		this.r46_outward_other = r46_outward_other;
	}
	public BigDecimal getR46_outward_total() {
		return r46_outward_total;
	}
	public void setR46_outward_total(BigDecimal r46_outward_total) {
		this.r46_outward_total = r46_outward_total;
	}
	public BigDecimal getR46_inward_family() {
		return r46_inward_family;
	}
	public void setR46_inward_family(BigDecimal r46_inward_family) {
		this.r46_inward_family = r46_inward_family;
	}
	public BigDecimal getR46_inward_investment() {
		return r46_inward_investment;
	}
	public void setR46_inward_investment(BigDecimal r46_inward_investment) {
		this.r46_inward_investment = r46_inward_investment;
	}
	public BigDecimal getR46_inward_trade() {
		return r46_inward_trade;
	}
	public void setR46_inward_trade(BigDecimal r46_inward_trade) {
		this.r46_inward_trade = r46_inward_trade;
	}
	public BigDecimal getR46_inward_other() {
		return r46_inward_other;
	}
	public void setR46_inward_other(BigDecimal r46_inward_other) {
		this.r46_inward_other = r46_inward_other;
	}
	public BigDecimal getR46_inward_total() {
		return r46_inward_total;
	}
	public void setR46_inward_total(BigDecimal r46_inward_total) {
		this.r46_inward_total = r46_inward_total;
	}
	public String getR47_mena_countries6() {
		return r47_mena_countries6;
	}
	public void setR47_mena_countries6(String r47_mena_countries6) {
		this.r47_mena_countries6 = r47_mena_countries6;
	}
	public BigDecimal getR47_outward_family() {
		return r47_outward_family;
	}
	public void setR47_outward_family(BigDecimal r47_outward_family) {
		this.r47_outward_family = r47_outward_family;
	}
	public BigDecimal getR47_outward_investment() {
		return r47_outward_investment;
	}
	public void setR47_outward_investment(BigDecimal r47_outward_investment) {
		this.r47_outward_investment = r47_outward_investment;
	}
	public BigDecimal getR47_outward_trade() {
		return r47_outward_trade;
	}
	public void setR47_outward_trade(BigDecimal r47_outward_trade) {
		this.r47_outward_trade = r47_outward_trade;
	}
	public BigDecimal getR47_outward_other() {
		return r47_outward_other;
	}
	public void setR47_outward_other(BigDecimal r47_outward_other) {
		this.r47_outward_other = r47_outward_other;
	}
	public BigDecimal getR47_outward_total() {
		return r47_outward_total;
	}
	public void setR47_outward_total(BigDecimal r47_outward_total) {
		this.r47_outward_total = r47_outward_total;
	}
	public BigDecimal getR47_inward_family() {
		return r47_inward_family;
	}
	public void setR47_inward_family(BigDecimal r47_inward_family) {
		this.r47_inward_family = r47_inward_family;
	}
	public BigDecimal getR47_inward_investment() {
		return r47_inward_investment;
	}
	public void setR47_inward_investment(BigDecimal r47_inward_investment) {
		this.r47_inward_investment = r47_inward_investment;
	}
	public BigDecimal getR47_inward_trade() {
		return r47_inward_trade;
	}
	public void setR47_inward_trade(BigDecimal r47_inward_trade) {
		this.r47_inward_trade = r47_inward_trade;
	}
	public BigDecimal getR47_inward_other() {
		return r47_inward_other;
	}
	public void setR47_inward_other(BigDecimal r47_inward_other) {
		this.r47_inward_other = r47_inward_other;
	}
	public BigDecimal getR47_inward_total() {
		return r47_inward_total;
	}
	public void setR47_inward_total(BigDecimal r47_inward_total) {
		this.r47_inward_total = r47_inward_total;
	}
	public String getR48_mena_countries7() {
		return r48_mena_countries7;
	}
	public void setR48_mena_countries7(String r48_mena_countries7) {
		this.r48_mena_countries7 = r48_mena_countries7;
	}
	public BigDecimal getR48_outward_family() {
		return r48_outward_family;
	}
	public void setR48_outward_family(BigDecimal r48_outward_family) {
		this.r48_outward_family = r48_outward_family;
	}
	public BigDecimal getR48_outward_investment() {
		return r48_outward_investment;
	}
	public void setR48_outward_investment(BigDecimal r48_outward_investment) {
		this.r48_outward_investment = r48_outward_investment;
	}
	public BigDecimal getR48_outward_trade() {
		return r48_outward_trade;
	}
	public void setR48_outward_trade(BigDecimal r48_outward_trade) {
		this.r48_outward_trade = r48_outward_trade;
	}
	public BigDecimal getR48_outward_other() {
		return r48_outward_other;
	}
	public void setR48_outward_other(BigDecimal r48_outward_other) {
		this.r48_outward_other = r48_outward_other;
	}
	public BigDecimal getR48_outward_total() {
		return r48_outward_total;
	}
	public void setR48_outward_total(BigDecimal r48_outward_total) {
		this.r48_outward_total = r48_outward_total;
	}
	public BigDecimal getR48_inward_family() {
		return r48_inward_family;
	}
	public void setR48_inward_family(BigDecimal r48_inward_family) {
		this.r48_inward_family = r48_inward_family;
	}
	public BigDecimal getR48_inward_investment() {
		return r48_inward_investment;
	}
	public void setR48_inward_investment(BigDecimal r48_inward_investment) {
		this.r48_inward_investment = r48_inward_investment;
	}
	public BigDecimal getR48_inward_trade() {
		return r48_inward_trade;
	}
	public void setR48_inward_trade(BigDecimal r48_inward_trade) {
		this.r48_inward_trade = r48_inward_trade;
	}
	public BigDecimal getR48_inward_other() {
		return r48_inward_other;
	}
	public void setR48_inward_other(BigDecimal r48_inward_other) {
		this.r48_inward_other = r48_inward_other;
	}
	public BigDecimal getR48_inward_total() {
		return r48_inward_total;
	}
	public void setR48_inward_total(BigDecimal r48_inward_total) {
		this.r48_inward_total = r48_inward_total;
	}
	public String getR49_mena_countries8() {
		return r49_mena_countries8;
	}
	public void setR49_mena_countries8(String r49_mena_countries8) {
		this.r49_mena_countries8 = r49_mena_countries8;
	}
	public BigDecimal getR49_outward_family() {
		return r49_outward_family;
	}
	public void setR49_outward_family(BigDecimal r49_outward_family) {
		this.r49_outward_family = r49_outward_family;
	}
	public BigDecimal getR49_outward_investment() {
		return r49_outward_investment;
	}
	public void setR49_outward_investment(BigDecimal r49_outward_investment) {
		this.r49_outward_investment = r49_outward_investment;
	}
	public BigDecimal getR49_outward_trade() {
		return r49_outward_trade;
	}
	public void setR49_outward_trade(BigDecimal r49_outward_trade) {
		this.r49_outward_trade = r49_outward_trade;
	}
	public BigDecimal getR49_outward_other() {
		return r49_outward_other;
	}
	public void setR49_outward_other(BigDecimal r49_outward_other) {
		this.r49_outward_other = r49_outward_other;
	}
	public BigDecimal getR49_outward_total() {
		return r49_outward_total;
	}
	public void setR49_outward_total(BigDecimal r49_outward_total) {
		this.r49_outward_total = r49_outward_total;
	}
	public BigDecimal getR49_inward_family() {
		return r49_inward_family;
	}
	public void setR49_inward_family(BigDecimal r49_inward_family) {
		this.r49_inward_family = r49_inward_family;
	}
	public BigDecimal getR49_inward_investment() {
		return r49_inward_investment;
	}
	public void setR49_inward_investment(BigDecimal r49_inward_investment) {
		this.r49_inward_investment = r49_inward_investment;
	}
	public BigDecimal getR49_inward_trade() {
		return r49_inward_trade;
	}
	public void setR49_inward_trade(BigDecimal r49_inward_trade) {
		this.r49_inward_trade = r49_inward_trade;
	}
	public BigDecimal getR49_inward_other() {
		return r49_inward_other;
	}
	public void setR49_inward_other(BigDecimal r49_inward_other) {
		this.r49_inward_other = r49_inward_other;
	}
	public BigDecimal getR49_inward_total() {
		return r49_inward_total;
	}
	public void setR49_inward_total(BigDecimal r49_inward_total) {
		this.r49_inward_total = r49_inward_total;
	}
	public String getR50_mena_countries9() {
		return r50_mena_countries9;
	}
	public void setR50_mena_countries9(String r50_mena_countries9) {
		this.r50_mena_countries9 = r50_mena_countries9;
	}
	public BigDecimal getR50_outward_family() {
		return r50_outward_family;
	}
	public void setR50_outward_family(BigDecimal r50_outward_family) {
		this.r50_outward_family = r50_outward_family;
	}
	public BigDecimal getR50_outward_investment() {
		return r50_outward_investment;
	}
	public void setR50_outward_investment(BigDecimal r50_outward_investment) {
		this.r50_outward_investment = r50_outward_investment;
	}
	public BigDecimal getR50_outward_trade() {
		return r50_outward_trade;
	}
	public void setR50_outward_trade(BigDecimal r50_outward_trade) {
		this.r50_outward_trade = r50_outward_trade;
	}
	public BigDecimal getR50_outward_other() {
		return r50_outward_other;
	}
	public void setR50_outward_other(BigDecimal r50_outward_other) {
		this.r50_outward_other = r50_outward_other;
	}
	public BigDecimal getR50_outward_total() {
		return r50_outward_total;
	}
	public void setR50_outward_total(BigDecimal r50_outward_total) {
		this.r50_outward_total = r50_outward_total;
	}
	public BigDecimal getR50_inward_family() {
		return r50_inward_family;
	}
	public void setR50_inward_family(BigDecimal r50_inward_family) {
		this.r50_inward_family = r50_inward_family;
	}
	public BigDecimal getR50_inward_investment() {
		return r50_inward_investment;
	}
	public void setR50_inward_investment(BigDecimal r50_inward_investment) {
		this.r50_inward_investment = r50_inward_investment;
	}
	public BigDecimal getR50_inward_trade() {
		return r50_inward_trade;
	}
	public void setR50_inward_trade(BigDecimal r50_inward_trade) {
		this.r50_inward_trade = r50_inward_trade;
	}
	public BigDecimal getR50_inward_other() {
		return r50_inward_other;
	}
	public void setR50_inward_other(BigDecimal r50_inward_other) {
		this.r50_inward_other = r50_inward_other;
	}
	public BigDecimal getR50_inward_total() {
		return r50_inward_total;
	}
	public void setR50_inward_total(BigDecimal r50_inward_total) {
		this.r50_inward_total = r50_inward_total;
	}
	public String getR51_mena_countries10() {
		return r51_mena_countries10;
	}
	public void setR51_mena_countries10(String r51_mena_countries10) {
		this.r51_mena_countries10 = r51_mena_countries10;
	}
	public BigDecimal getR51_outward_family() {
		return r51_outward_family;
	}
	public void setR51_outward_family(BigDecimal r51_outward_family) {
		this.r51_outward_family = r51_outward_family;
	}
	public BigDecimal getR51_outward_investment() {
		return r51_outward_investment;
	}
	public void setR51_outward_investment(BigDecimal r51_outward_investment) {
		this.r51_outward_investment = r51_outward_investment;
	}
	public BigDecimal getR51_outward_trade() {
		return r51_outward_trade;
	}
	public void setR51_outward_trade(BigDecimal r51_outward_trade) {
		this.r51_outward_trade = r51_outward_trade;
	}
	public BigDecimal getR51_outward_other() {
		return r51_outward_other;
	}
	public void setR51_outward_other(BigDecimal r51_outward_other) {
		this.r51_outward_other = r51_outward_other;
	}
	public BigDecimal getR51_outward_total() {
		return r51_outward_total;
	}
	public void setR51_outward_total(BigDecimal r51_outward_total) {
		this.r51_outward_total = r51_outward_total;
	}
	public BigDecimal getR51_inward_family() {
		return r51_inward_family;
	}
	public void setR51_inward_family(BigDecimal r51_inward_family) {
		this.r51_inward_family = r51_inward_family;
	}
	public BigDecimal getR51_inward_investment() {
		return r51_inward_investment;
	}
	public void setR51_inward_investment(BigDecimal r51_inward_investment) {
		this.r51_inward_investment = r51_inward_investment;
	}
	public BigDecimal getR51_inward_trade() {
		return r51_inward_trade;
	}
	public void setR51_inward_trade(BigDecimal r51_inward_trade) {
		this.r51_inward_trade = r51_inward_trade;
	}
	public BigDecimal getR51_inward_other() {
		return r51_inward_other;
	}
	public void setR51_inward_other(BigDecimal r51_inward_other) {
		this.r51_inward_other = r51_inward_other;
	}
	public BigDecimal getR51_inward_total() {
		return r51_inward_total;
	}
	public void setR51_inward_total(BigDecimal r51_inward_total) {
		this.r51_inward_total = r51_inward_total;
	}
	public String getR52_sub_saharan_countries() {
		return r52_sub_saharan_countries;
	}
	public void setR52_sub_saharan_countries(String r52_sub_saharan_countries) {
		this.r52_sub_saharan_countries = r52_sub_saharan_countries;
	}
	public BigDecimal getR52_outward_family() {
		return r52_outward_family;
	}
	public void setR52_outward_family(BigDecimal r52_outward_family) {
		this.r52_outward_family = r52_outward_family;
	}
	public BigDecimal getR52_outward_investment() {
		return r52_outward_investment;
	}
	public void setR52_outward_investment(BigDecimal r52_outward_investment) {
		this.r52_outward_investment = r52_outward_investment;
	}
	public BigDecimal getR52_outward_trade() {
		return r52_outward_trade;
	}
	public void setR52_outward_trade(BigDecimal r52_outward_trade) {
		this.r52_outward_trade = r52_outward_trade;
	}
	public BigDecimal getR52_outward_other() {
		return r52_outward_other;
	}
	public void setR52_outward_other(BigDecimal r52_outward_other) {
		this.r52_outward_other = r52_outward_other;
	}
	public BigDecimal getR52_outward_total() {
		return r52_outward_total;
	}
	public void setR52_outward_total(BigDecimal r52_outward_total) {
		this.r52_outward_total = r52_outward_total;
	}
	public BigDecimal getR52_inward_family() {
		return r52_inward_family;
	}
	public void setR52_inward_family(BigDecimal r52_inward_family) {
		this.r52_inward_family = r52_inward_family;
	}
	public BigDecimal getR52_inward_investment() {
		return r52_inward_investment;
	}
	public void setR52_inward_investment(BigDecimal r52_inward_investment) {
		this.r52_inward_investment = r52_inward_investment;
	}
	public BigDecimal getR52_inward_trade() {
		return r52_inward_trade;
	}
	public void setR52_inward_trade(BigDecimal r52_inward_trade) {
		this.r52_inward_trade = r52_inward_trade;
	}
	public BigDecimal getR52_inward_other() {
		return r52_inward_other;
	}
	public void setR52_inward_other(BigDecimal r52_inward_other) {
		this.r52_inward_other = r52_inward_other;
	}
	public BigDecimal getR52_inward_total() {
		return r52_inward_total;
	}
	public void setR52_inward_total(BigDecimal r52_inward_total) {
		this.r52_inward_total = r52_inward_total;
	}
	public String getR53_sub_saharan_countries1() {
		return r53_sub_saharan_countries1;
	}
	public void setR53_sub_saharan_countries1(String r53_sub_saharan_countries1) {
		this.r53_sub_saharan_countries1 = r53_sub_saharan_countries1;
	}
	public BigDecimal getR53_outward_family() {
		return r53_outward_family;
	}
	public void setR53_outward_family(BigDecimal r53_outward_family) {
		this.r53_outward_family = r53_outward_family;
	}
	public BigDecimal getR53_outward_investment() {
		return r53_outward_investment;
	}
	public void setR53_outward_investment(BigDecimal r53_outward_investment) {
		this.r53_outward_investment = r53_outward_investment;
	}
	public BigDecimal getR53_outward_trade() {
		return r53_outward_trade;
	}
	public void setR53_outward_trade(BigDecimal r53_outward_trade) {
		this.r53_outward_trade = r53_outward_trade;
	}
	public BigDecimal getR53_outward_other() {
		return r53_outward_other;
	}
	public void setR53_outward_other(BigDecimal r53_outward_other) {
		this.r53_outward_other = r53_outward_other;
	}
	public BigDecimal getR53_outward_total() {
		return r53_outward_total;
	}
	public void setR53_outward_total(BigDecimal r53_outward_total) {
		this.r53_outward_total = r53_outward_total;
	}
	public BigDecimal getR53_inward_family() {
		return r53_inward_family;
	}
	public void setR53_inward_family(BigDecimal r53_inward_family) {
		this.r53_inward_family = r53_inward_family;
	}
	public BigDecimal getR53_inward_investment() {
		return r53_inward_investment;
	}
	public void setR53_inward_investment(BigDecimal r53_inward_investment) {
		this.r53_inward_investment = r53_inward_investment;
	}
	public BigDecimal getR53_inward_trade() {
		return r53_inward_trade;
	}
	public void setR53_inward_trade(BigDecimal r53_inward_trade) {
		this.r53_inward_trade = r53_inward_trade;
	}
	public BigDecimal getR53_inward_other() {
		return r53_inward_other;
	}
	public void setR53_inward_other(BigDecimal r53_inward_other) {
		this.r53_inward_other = r53_inward_other;
	}
	public BigDecimal getR53_inward_total() {
		return r53_inward_total;
	}
	public void setR53_inward_total(BigDecimal r53_inward_total) {
		this.r53_inward_total = r53_inward_total;
	}
	public String getR54_sub_saharan_countries2() {
		return r54_sub_saharan_countries2;
	}
	public void setR54_sub_saharan_countries2(String r54_sub_saharan_countries2) {
		this.r54_sub_saharan_countries2 = r54_sub_saharan_countries2;
	}
	public BigDecimal getR54_outward_family() {
		return r54_outward_family;
	}
	public void setR54_outward_family(BigDecimal r54_outward_family) {
		this.r54_outward_family = r54_outward_family;
	}
	public BigDecimal getR54_outward_investment() {
		return r54_outward_investment;
	}
	public void setR54_outward_investment(BigDecimal r54_outward_investment) {
		this.r54_outward_investment = r54_outward_investment;
	}
	public BigDecimal getR54_outward_trade() {
		return r54_outward_trade;
	}
	public void setR54_outward_trade(BigDecimal r54_outward_trade) {
		this.r54_outward_trade = r54_outward_trade;
	}
	public BigDecimal getR54_outward_other() {
		return r54_outward_other;
	}
	public void setR54_outward_other(BigDecimal r54_outward_other) {
		this.r54_outward_other = r54_outward_other;
	}
	public BigDecimal getR54_outward_total() {
		return r54_outward_total;
	}
	public void setR54_outward_total(BigDecimal r54_outward_total) {
		this.r54_outward_total = r54_outward_total;
	}
	public BigDecimal getR54_inward_family() {
		return r54_inward_family;
	}
	public void setR54_inward_family(BigDecimal r54_inward_family) {
		this.r54_inward_family = r54_inward_family;
	}
	public BigDecimal getR54_inward_investment() {
		return r54_inward_investment;
	}
	public void setR54_inward_investment(BigDecimal r54_inward_investment) {
		this.r54_inward_investment = r54_inward_investment;
	}
	public BigDecimal getR54_inward_trade() {
		return r54_inward_trade;
	}
	public void setR54_inward_trade(BigDecimal r54_inward_trade) {
		this.r54_inward_trade = r54_inward_trade;
	}
	public BigDecimal getR54_inward_other() {
		return r54_inward_other;
	}
	public void setR54_inward_other(BigDecimal r54_inward_other) {
		this.r54_inward_other = r54_inward_other;
	}
	public BigDecimal getR54_inward_total() {
		return r54_inward_total;
	}
	public void setR54_inward_total(BigDecimal r54_inward_total) {
		this.r54_inward_total = r54_inward_total;
	}
	public String getR55_sub_saharan_countries3() {
		return r55_sub_saharan_countries3;
	}
	public void setR55_sub_saharan_countries3(String r55_sub_saharan_countries3) {
		this.r55_sub_saharan_countries3 = r55_sub_saharan_countries3;
	}
	public BigDecimal getR55_outward_family() {
		return r55_outward_family;
	}
	public void setR55_outward_family(BigDecimal r55_outward_family) {
		this.r55_outward_family = r55_outward_family;
	}
	public BigDecimal getR55_outward_investment() {
		return r55_outward_investment;
	}
	public void setR55_outward_investment(BigDecimal r55_outward_investment) {
		this.r55_outward_investment = r55_outward_investment;
	}
	public BigDecimal getR55_outward_trade() {
		return r55_outward_trade;
	}
	public void setR55_outward_trade(BigDecimal r55_outward_trade) {
		this.r55_outward_trade = r55_outward_trade;
	}
	public BigDecimal getR55_outward_other() {
		return r55_outward_other;
	}
	public void setR55_outward_other(BigDecimal r55_outward_other) {
		this.r55_outward_other = r55_outward_other;
	}
	public BigDecimal getR55_outward_total() {
		return r55_outward_total;
	}
	public void setR55_outward_total(BigDecimal r55_outward_total) {
		this.r55_outward_total = r55_outward_total;
	}
	public BigDecimal getR55_inward_family() {
		return r55_inward_family;
	}
	public void setR55_inward_family(BigDecimal r55_inward_family) {
		this.r55_inward_family = r55_inward_family;
	}
	public BigDecimal getR55_inward_investment() {
		return r55_inward_investment;
	}
	public void setR55_inward_investment(BigDecimal r55_inward_investment) {
		this.r55_inward_investment = r55_inward_investment;
	}
	public BigDecimal getR55_inward_trade() {
		return r55_inward_trade;
	}
	public void setR55_inward_trade(BigDecimal r55_inward_trade) {
		this.r55_inward_trade = r55_inward_trade;
	}
	public BigDecimal getR55_inward_other() {
		return r55_inward_other;
	}
	public void setR55_inward_other(BigDecimal r55_inward_other) {
		this.r55_inward_other = r55_inward_other;
	}
	public BigDecimal getR55_inward_total() {
		return r55_inward_total;
	}
	public void setR55_inward_total(BigDecimal r55_inward_total) {
		this.r55_inward_total = r55_inward_total;
	}
	public String getR56_sub_saharan_countries4() {
		return r56_sub_saharan_countries4;
	}
	public void setR56_sub_saharan_countries4(String r56_sub_saharan_countries4) {
		this.r56_sub_saharan_countries4 = r56_sub_saharan_countries4;
	}
	public BigDecimal getR56_outward_family() {
		return r56_outward_family;
	}
	public void setR56_outward_family(BigDecimal r56_outward_family) {
		this.r56_outward_family = r56_outward_family;
	}
	public BigDecimal getR56_outward_investment() {
		return r56_outward_investment;
	}
	public void setR56_outward_investment(BigDecimal r56_outward_investment) {
		this.r56_outward_investment = r56_outward_investment;
	}
	public BigDecimal getR56_outward_trade() {
		return r56_outward_trade;
	}
	public void setR56_outward_trade(BigDecimal r56_outward_trade) {
		this.r56_outward_trade = r56_outward_trade;
	}
	public BigDecimal getR56_outward_other() {
		return r56_outward_other;
	}
	public void setR56_outward_other(BigDecimal r56_outward_other) {
		this.r56_outward_other = r56_outward_other;
	}
	public BigDecimal getR56_outward_total() {
		return r56_outward_total;
	}
	public void setR56_outward_total(BigDecimal r56_outward_total) {
		this.r56_outward_total = r56_outward_total;
	}
	public BigDecimal getR56_inward_family() {
		return r56_inward_family;
	}
	public void setR56_inward_family(BigDecimal r56_inward_family) {
		this.r56_inward_family = r56_inward_family;
	}
	public BigDecimal getR56_inward_investment() {
		return r56_inward_investment;
	}
	public void setR56_inward_investment(BigDecimal r56_inward_investment) {
		this.r56_inward_investment = r56_inward_investment;
	}
	public BigDecimal getR56_inward_trade() {
		return r56_inward_trade;
	}
	public void setR56_inward_trade(BigDecimal r56_inward_trade) {
		this.r56_inward_trade = r56_inward_trade;
	}
	public BigDecimal getR56_inward_other() {
		return r56_inward_other;
	}
	public void setR56_inward_other(BigDecimal r56_inward_other) {
		this.r56_inward_other = r56_inward_other;
	}
	public BigDecimal getR56_inward_total() {
		return r56_inward_total;
	}
	public void setR56_inward_total(BigDecimal r56_inward_total) {
		this.r56_inward_total = r56_inward_total;
	}
	public String getR57_sub_saharan_countries5() {
		return r57_sub_saharan_countries5;
	}
	public void setR57_sub_saharan_countries5(String r57_sub_saharan_countries5) {
		this.r57_sub_saharan_countries5 = r57_sub_saharan_countries5;
	}
	public BigDecimal getR57_outward_family() {
		return r57_outward_family;
	}
	public void setR57_outward_family(BigDecimal r57_outward_family) {
		this.r57_outward_family = r57_outward_family;
	}
	public BigDecimal getR57_outward_investment() {
		return r57_outward_investment;
	}
	public void setR57_outward_investment(BigDecimal r57_outward_investment) {
		this.r57_outward_investment = r57_outward_investment;
	}
	public BigDecimal getR57_outward_trade() {
		return r57_outward_trade;
	}
	public void setR57_outward_trade(BigDecimal r57_outward_trade) {
		this.r57_outward_trade = r57_outward_trade;
	}
	public BigDecimal getR57_outward_other() {
		return r57_outward_other;
	}
	public void setR57_outward_other(BigDecimal r57_outward_other) {
		this.r57_outward_other = r57_outward_other;
	}
	public BigDecimal getR57_outward_total() {
		return r57_outward_total;
	}
	public void setR57_outward_total(BigDecimal r57_outward_total) {
		this.r57_outward_total = r57_outward_total;
	}
	public BigDecimal getR57_inward_family() {
		return r57_inward_family;
	}
	public void setR57_inward_family(BigDecimal r57_inward_family) {
		this.r57_inward_family = r57_inward_family;
	}
	public BigDecimal getR57_inward_investment() {
		return r57_inward_investment;
	}
	public void setR57_inward_investment(BigDecimal r57_inward_investment) {
		this.r57_inward_investment = r57_inward_investment;
	}
	public BigDecimal getR57_inward_trade() {
		return r57_inward_trade;
	}
	public void setR57_inward_trade(BigDecimal r57_inward_trade) {
		this.r57_inward_trade = r57_inward_trade;
	}
	public BigDecimal getR57_inward_other() {
		return r57_inward_other;
	}
	public void setR57_inward_other(BigDecimal r57_inward_other) {
		this.r57_inward_other = r57_inward_other;
	}
	public BigDecimal getR57_inward_total() {
		return r57_inward_total;
	}
	public void setR57_inward_total(BigDecimal r57_inward_total) {
		this.r57_inward_total = r57_inward_total;
	}
	public String getR58_asian_countries() {
		return r58_asian_countries;
	}
	public void setR58_asian_countries(String r58_asian_countries) {
		this.r58_asian_countries = r58_asian_countries;
	}
	public BigDecimal getR58_outward_family() {
		return r58_outward_family;
	}
	public void setR58_outward_family(BigDecimal r58_outward_family) {
		this.r58_outward_family = r58_outward_family;
	}
	public BigDecimal getR58_outward_investment() {
		return r58_outward_investment;
	}
	public void setR58_outward_investment(BigDecimal r58_outward_investment) {
		this.r58_outward_investment = r58_outward_investment;
	}
	public BigDecimal getR58_outward_trade() {
		return r58_outward_trade;
	}
	public void setR58_outward_trade(BigDecimal r58_outward_trade) {
		this.r58_outward_trade = r58_outward_trade;
	}
	public BigDecimal getR58_outward_other() {
		return r58_outward_other;
	}
	public void setR58_outward_other(BigDecimal r58_outward_other) {
		this.r58_outward_other = r58_outward_other;
	}
	public BigDecimal getR58_outward_total() {
		return r58_outward_total;
	}
	public void setR58_outward_total(BigDecimal r58_outward_total) {
		this.r58_outward_total = r58_outward_total;
	}
	public BigDecimal getR58_inward_family() {
		return r58_inward_family;
	}
	public void setR58_inward_family(BigDecimal r58_inward_family) {
		this.r58_inward_family = r58_inward_family;
	}
	public BigDecimal getR58_inward_investment() {
		return r58_inward_investment;
	}
	public void setR58_inward_investment(BigDecimal r58_inward_investment) {
		this.r58_inward_investment = r58_inward_investment;
	}
	public BigDecimal getR58_inward_trade() {
		return r58_inward_trade;
	}
	public void setR58_inward_trade(BigDecimal r58_inward_trade) {
		this.r58_inward_trade = r58_inward_trade;
	}
	public BigDecimal getR58_inward_other() {
		return r58_inward_other;
	}
	public void setR58_inward_other(BigDecimal r58_inward_other) {
		this.r58_inward_other = r58_inward_other;
	}
	public BigDecimal getR58_inward_total() {
		return r58_inward_total;
	}
	public void setR58_inward_total(BigDecimal r58_inward_total) {
		this.r58_inward_total = r58_inward_total;
	}
	public String getR59_asian_countries1() {
		return r59_asian_countries1;
	}
	public void setR59_asian_countries1(String r59_asian_countries1) {
		this.r59_asian_countries1 = r59_asian_countries1;
	}
	public BigDecimal getR59_outward_family() {
		return r59_outward_family;
	}
	public void setR59_outward_family(BigDecimal r59_outward_family) {
		this.r59_outward_family = r59_outward_family;
	}
	public BigDecimal getR59_outward_investment() {
		return r59_outward_investment;
	}
	public void setR59_outward_investment(BigDecimal r59_outward_investment) {
		this.r59_outward_investment = r59_outward_investment;
	}
	public BigDecimal getR59_outward_trade() {
		return r59_outward_trade;
	}
	public void setR59_outward_trade(BigDecimal r59_outward_trade) {
		this.r59_outward_trade = r59_outward_trade;
	}
	public BigDecimal getR59_outward_other() {
		return r59_outward_other;
	}
	public void setR59_outward_other(BigDecimal r59_outward_other) {
		this.r59_outward_other = r59_outward_other;
	}
	public BigDecimal getR59_outward_total() {
		return r59_outward_total;
	}
	public void setR59_outward_total(BigDecimal r59_outward_total) {
		this.r59_outward_total = r59_outward_total;
	}
	public BigDecimal getR59_inward_family() {
		return r59_inward_family;
	}
	public void setR59_inward_family(BigDecimal r59_inward_family) {
		this.r59_inward_family = r59_inward_family;
	}
	public BigDecimal getR59_inward_investment() {
		return r59_inward_investment;
	}
	public void setR59_inward_investment(BigDecimal r59_inward_investment) {
		this.r59_inward_investment = r59_inward_investment;
	}
	public BigDecimal getR59_inward_trade() {
		return r59_inward_trade;
	}
	public void setR59_inward_trade(BigDecimal r59_inward_trade) {
		this.r59_inward_trade = r59_inward_trade;
	}
	public BigDecimal getR59_inward_other() {
		return r59_inward_other;
	}
	public void setR59_inward_other(BigDecimal r59_inward_other) {
		this.r59_inward_other = r59_inward_other;
	}
	public BigDecimal getR59_inward_total() {
		return r59_inward_total;
	}
	public void setR59_inward_total(BigDecimal r59_inward_total) {
		this.r59_inward_total = r59_inward_total;
	}
	public String getR60_asian_countries2() {
		return r60_asian_countries2;
	}
	public void setR60_asian_countries2(String r60_asian_countries2) {
		this.r60_asian_countries2 = r60_asian_countries2;
	}
	public BigDecimal getR60_outward_family() {
		return r60_outward_family;
	}
	public void setR60_outward_family(BigDecimal r60_outward_family) {
		this.r60_outward_family = r60_outward_family;
	}
	public BigDecimal getR60_outward_investment() {
		return r60_outward_investment;
	}
	public void setR60_outward_investment(BigDecimal r60_outward_investment) {
		this.r60_outward_investment = r60_outward_investment;
	}
	public BigDecimal getR60_outward_trade() {
		return r60_outward_trade;
	}
	public void setR60_outward_trade(BigDecimal r60_outward_trade) {
		this.r60_outward_trade = r60_outward_trade;
	}
	public BigDecimal getR60_outward_other() {
		return r60_outward_other;
	}
	public void setR60_outward_other(BigDecimal r60_outward_other) {
		this.r60_outward_other = r60_outward_other;
	}
	public BigDecimal getR60_outward_total() {
		return r60_outward_total;
	}
	public void setR60_outward_total(BigDecimal r60_outward_total) {
		this.r60_outward_total = r60_outward_total;
	}
	public BigDecimal getR60_inward_family() {
		return r60_inward_family;
	}
	public void setR60_inward_family(BigDecimal r60_inward_family) {
		this.r60_inward_family = r60_inward_family;
	}
	public BigDecimal getR60_inward_investment() {
		return r60_inward_investment;
	}
	public void setR60_inward_investment(BigDecimal r60_inward_investment) {
		this.r60_inward_investment = r60_inward_investment;
	}
	public BigDecimal getR60_inward_trade() {
		return r60_inward_trade;
	}
	public void setR60_inward_trade(BigDecimal r60_inward_trade) {
		this.r60_inward_trade = r60_inward_trade;
	}
	public BigDecimal getR60_inward_other() {
		return r60_inward_other;
	}
	public void setR60_inward_other(BigDecimal r60_inward_other) {
		this.r60_inward_other = r60_inward_other;
	}
	public BigDecimal getR60_inward_total() {
		return r60_inward_total;
	}
	public void setR60_inward_total(BigDecimal r60_inward_total) {
		this.r60_inward_total = r60_inward_total;
	}
	public String getR61_asian_countries3() {
		return r61_asian_countries3;
	}
	public void setR61_asian_countries3(String r61_asian_countries3) {
		this.r61_asian_countries3 = r61_asian_countries3;
	}
	public BigDecimal getR61_outward_family() {
		return r61_outward_family;
	}
	public void setR61_outward_family(BigDecimal r61_outward_family) {
		this.r61_outward_family = r61_outward_family;
	}
	public BigDecimal getR61_outward_investment() {
		return r61_outward_investment;
	}
	public void setR61_outward_investment(BigDecimal r61_outward_investment) {
		this.r61_outward_investment = r61_outward_investment;
	}
	public BigDecimal getR61_outward_trade() {
		return r61_outward_trade;
	}
	public void setR61_outward_trade(BigDecimal r61_outward_trade) {
		this.r61_outward_trade = r61_outward_trade;
	}
	public BigDecimal getR61_outward_other() {
		return r61_outward_other;
	}
	public void setR61_outward_other(BigDecimal r61_outward_other) {
		this.r61_outward_other = r61_outward_other;
	}
	public BigDecimal getR61_outward_total() {
		return r61_outward_total;
	}
	public void setR61_outward_total(BigDecimal r61_outward_total) {
		this.r61_outward_total = r61_outward_total;
	}
	public BigDecimal getR61_inward_family() {
		return r61_inward_family;
	}
	public void setR61_inward_family(BigDecimal r61_inward_family) {
		this.r61_inward_family = r61_inward_family;
	}
	public BigDecimal getR61_inward_investment() {
		return r61_inward_investment;
	}
	public void setR61_inward_investment(BigDecimal r61_inward_investment) {
		this.r61_inward_investment = r61_inward_investment;
	}
	public BigDecimal getR61_inward_trade() {
		return r61_inward_trade;
	}
	public void setR61_inward_trade(BigDecimal r61_inward_trade) {
		this.r61_inward_trade = r61_inward_trade;
	}
	public BigDecimal getR61_inward_other() {
		return r61_inward_other;
	}
	public void setR61_inward_other(BigDecimal r61_inward_other) {
		this.r61_inward_other = r61_inward_other;
	}
	public BigDecimal getR61_inward_total() {
		return r61_inward_total;
	}
	public void setR61_inward_total(BigDecimal r61_inward_total) {
		this.r61_inward_total = r61_inward_total;
	}
	public String getR62_asian_countries4() {
		return r62_asian_countries4;
	}
	public void setR62_asian_countries4(String r62_asian_countries4) {
		this.r62_asian_countries4 = r62_asian_countries4;
	}
	public BigDecimal getR62_outward_family() {
		return r62_outward_family;
	}
	public void setR62_outward_family(BigDecimal r62_outward_family) {
		this.r62_outward_family = r62_outward_family;
	}
	public BigDecimal getR62_outward_investment() {
		return r62_outward_investment;
	}
	public void setR62_outward_investment(BigDecimal r62_outward_investment) {
		this.r62_outward_investment = r62_outward_investment;
	}
	public BigDecimal getR62_outward_trade() {
		return r62_outward_trade;
	}
	public void setR62_outward_trade(BigDecimal r62_outward_trade) {
		this.r62_outward_trade = r62_outward_trade;
	}
	public BigDecimal getR62_outward_other() {
		return r62_outward_other;
	}
	public void setR62_outward_other(BigDecimal r62_outward_other) {
		this.r62_outward_other = r62_outward_other;
	}
	public BigDecimal getR62_outward_total() {
		return r62_outward_total;
	}
	public void setR62_outward_total(BigDecimal r62_outward_total) {
		this.r62_outward_total = r62_outward_total;
	}
	public BigDecimal getR62_inward_family() {
		return r62_inward_family;
	}
	public void setR62_inward_family(BigDecimal r62_inward_family) {
		this.r62_inward_family = r62_inward_family;
	}
	public BigDecimal getR62_inward_investment() {
		return r62_inward_investment;
	}
	public void setR62_inward_investment(BigDecimal r62_inward_investment) {
		this.r62_inward_investment = r62_inward_investment;
	}
	public BigDecimal getR62_inward_trade() {
		return r62_inward_trade;
	}
	public void setR62_inward_trade(BigDecimal r62_inward_trade) {
		this.r62_inward_trade = r62_inward_trade;
	}
	public BigDecimal getR62_inward_other() {
		return r62_inward_other;
	}
	public void setR62_inward_other(BigDecimal r62_inward_other) {
		this.r62_inward_other = r62_inward_other;
	}
	public BigDecimal getR62_inward_total() {
		return r62_inward_total;
	}
	public void setR62_inward_total(BigDecimal r62_inward_total) {
		this.r62_inward_total = r62_inward_total;
	}
	public String getR63_asian_countries5() {
		return r63_asian_countries5;
	}
	public void setR63_asian_countries5(String r63_asian_countries5) {
		this.r63_asian_countries5 = r63_asian_countries5;
	}
	public BigDecimal getR63_outward_family() {
		return r63_outward_family;
	}
	public void setR63_outward_family(BigDecimal r63_outward_family) {
		this.r63_outward_family = r63_outward_family;
	}
	public BigDecimal getR63_outward_investment() {
		return r63_outward_investment;
	}
	public void setR63_outward_investment(BigDecimal r63_outward_investment) {
		this.r63_outward_investment = r63_outward_investment;
	}
	public BigDecimal getR63_outward_trade() {
		return r63_outward_trade;
	}
	public void setR63_outward_trade(BigDecimal r63_outward_trade) {
		this.r63_outward_trade = r63_outward_trade;
	}
	public BigDecimal getR63_outward_other() {
		return r63_outward_other;
	}
	public void setR63_outward_other(BigDecimal r63_outward_other) {
		this.r63_outward_other = r63_outward_other;
	}
	public BigDecimal getR63_outward_total() {
		return r63_outward_total;
	}
	public void setR63_outward_total(BigDecimal r63_outward_total) {
		this.r63_outward_total = r63_outward_total;
	}
	public BigDecimal getR63_inward_family() {
		return r63_inward_family;
	}
	public void setR63_inward_family(BigDecimal r63_inward_family) {
		this.r63_inward_family = r63_inward_family;
	}
	public BigDecimal getR63_inward_investment() {
		return r63_inward_investment;
	}
	public void setR63_inward_investment(BigDecimal r63_inward_investment) {
		this.r63_inward_investment = r63_inward_investment;
	}
	public BigDecimal getR63_inward_trade() {
		return r63_inward_trade;
	}
	public void setR63_inward_trade(BigDecimal r63_inward_trade) {
		this.r63_inward_trade = r63_inward_trade;
	}
	public BigDecimal getR63_inward_other() {
		return r63_inward_other;
	}
	public void setR63_inward_other(BigDecimal r63_inward_other) {
		this.r63_inward_other = r63_inward_other;
	}
	public BigDecimal getR63_inward_total() {
		return r63_inward_total;
	}
	public void setR63_inward_total(BigDecimal r63_inward_total) {
		this.r63_inward_total = r63_inward_total;
	}
	public String getR64_asian_countries6() {
		return r64_asian_countries6;
	}
	public void setR64_asian_countries6(String r64_asian_countries6) {
		this.r64_asian_countries6 = r64_asian_countries6;
	}
	public BigDecimal getR64_outward_family() {
		return r64_outward_family;
	}
	public void setR64_outward_family(BigDecimal r64_outward_family) {
		this.r64_outward_family = r64_outward_family;
	}
	public BigDecimal getR64_outward_investment() {
		return r64_outward_investment;
	}
	public void setR64_outward_investment(BigDecimal r64_outward_investment) {
		this.r64_outward_investment = r64_outward_investment;
	}
	public BigDecimal getR64_outward_trade() {
		return r64_outward_trade;
	}
	public void setR64_outward_trade(BigDecimal r64_outward_trade) {
		this.r64_outward_trade = r64_outward_trade;
	}
	public BigDecimal getR64_outward_other() {
		return r64_outward_other;
	}
	public void setR64_outward_other(BigDecimal r64_outward_other) {
		this.r64_outward_other = r64_outward_other;
	}
	public BigDecimal getR64_outward_total() {
		return r64_outward_total;
	}
	public void setR64_outward_total(BigDecimal r64_outward_total) {
		this.r64_outward_total = r64_outward_total;
	}
	public BigDecimal getR64_inward_family() {
		return r64_inward_family;
	}
	public void setR64_inward_family(BigDecimal r64_inward_family) {
		this.r64_inward_family = r64_inward_family;
	}
	public BigDecimal getR64_inward_investment() {
		return r64_inward_investment;
	}
	public void setR64_inward_investment(BigDecimal r64_inward_investment) {
		this.r64_inward_investment = r64_inward_investment;
	}
	public BigDecimal getR64_inward_trade() {
		return r64_inward_trade;
	}
	public void setR64_inward_trade(BigDecimal r64_inward_trade) {
		this.r64_inward_trade = r64_inward_trade;
	}
	public BigDecimal getR64_inward_other() {
		return r64_inward_other;
	}
	public void setR64_inward_other(BigDecimal r64_inward_other) {
		this.r64_inward_other = r64_inward_other;
	}
	public BigDecimal getR64_inward_total() {
		return r64_inward_total;
	}
	public void setR64_inward_total(BigDecimal r64_inward_total) {
		this.r64_inward_total = r64_inward_total;
	}
	public String getR65_asian_countries7() {
		return r65_asian_countries7;
	}
	public void setR65_asian_countries7(String r65_asian_countries7) {
		this.r65_asian_countries7 = r65_asian_countries7;
	}
	public BigDecimal getR65_outward_family() {
		return r65_outward_family;
	}
	public void setR65_outward_family(BigDecimal r65_outward_family) {
		this.r65_outward_family = r65_outward_family;
	}
	public BigDecimal getR65_outward_investment() {
		return r65_outward_investment;
	}
	public void setR65_outward_investment(BigDecimal r65_outward_investment) {
		this.r65_outward_investment = r65_outward_investment;
	}
	public BigDecimal getR65_outward_trade() {
		return r65_outward_trade;
	}
	public void setR65_outward_trade(BigDecimal r65_outward_trade) {
		this.r65_outward_trade = r65_outward_trade;
	}
	public BigDecimal getR65_outward_other() {
		return r65_outward_other;
	}
	public void setR65_outward_other(BigDecimal r65_outward_other) {
		this.r65_outward_other = r65_outward_other;
	}
	public BigDecimal getR65_outward_total() {
		return r65_outward_total;
	}
	public void setR65_outward_total(BigDecimal r65_outward_total) {
		this.r65_outward_total = r65_outward_total;
	}
	public BigDecimal getR65_inward_family() {
		return r65_inward_family;
	}
	public void setR65_inward_family(BigDecimal r65_inward_family) {
		this.r65_inward_family = r65_inward_family;
	}
	public BigDecimal getR65_inward_investment() {
		return r65_inward_investment;
	}
	public void setR65_inward_investment(BigDecimal r65_inward_investment) {
		this.r65_inward_investment = r65_inward_investment;
	}
	public BigDecimal getR65_inward_trade() {
		return r65_inward_trade;
	}
	public void setR65_inward_trade(BigDecimal r65_inward_trade) {
		this.r65_inward_trade = r65_inward_trade;
	}
	public BigDecimal getR65_inward_other() {
		return r65_inward_other;
	}
	public void setR65_inward_other(BigDecimal r65_inward_other) {
		this.r65_inward_other = r65_inward_other;
	}
	public BigDecimal getR65_inward_total() {
		return r65_inward_total;
	}
	public void setR65_inward_total(BigDecimal r65_inward_total) {
		this.r65_inward_total = r65_inward_total;
	}
	public String getR66_asian_countries8() {
		return r66_asian_countries8;
	}
	public void setR66_asian_countries8(String r66_asian_countries8) {
		this.r66_asian_countries8 = r66_asian_countries8;
	}
	public BigDecimal getR66_outward_family() {
		return r66_outward_family;
	}
	public void setR66_outward_family(BigDecimal r66_outward_family) {
		this.r66_outward_family = r66_outward_family;
	}
	public BigDecimal getR66_outward_investment() {
		return r66_outward_investment;
	}
	public void setR66_outward_investment(BigDecimal r66_outward_investment) {
		this.r66_outward_investment = r66_outward_investment;
	}
	public BigDecimal getR66_outward_trade() {
		return r66_outward_trade;
	}
	public void setR66_outward_trade(BigDecimal r66_outward_trade) {
		this.r66_outward_trade = r66_outward_trade;
	}
	public BigDecimal getR66_outward_other() {
		return r66_outward_other;
	}
	public void setR66_outward_other(BigDecimal r66_outward_other) {
		this.r66_outward_other = r66_outward_other;
	}
	public BigDecimal getR66_outward_total() {
		return r66_outward_total;
	}
	public void setR66_outward_total(BigDecimal r66_outward_total) {
		this.r66_outward_total = r66_outward_total;
	}
	public BigDecimal getR66_inward_family() {
		return r66_inward_family;
	}
	public void setR66_inward_family(BigDecimal r66_inward_family) {
		this.r66_inward_family = r66_inward_family;
	}
	public BigDecimal getR66_inward_investment() {
		return r66_inward_investment;
	}
	public void setR66_inward_investment(BigDecimal r66_inward_investment) {
		this.r66_inward_investment = r66_inward_investment;
	}
	public BigDecimal getR66_inward_trade() {
		return r66_inward_trade;
	}
	public void setR66_inward_trade(BigDecimal r66_inward_trade) {
		this.r66_inward_trade = r66_inward_trade;
	}
	public BigDecimal getR66_inward_other() {
		return r66_inward_other;
	}
	public void setR66_inward_other(BigDecimal r66_inward_other) {
		this.r66_inward_other = r66_inward_other;
	}
	public BigDecimal getR66_inward_total() {
		return r66_inward_total;
	}
	public void setR66_inward_total(BigDecimal r66_inward_total) {
		this.r66_inward_total = r66_inward_total;
	}
	public String getR67_asian_countries9() {
		return r67_asian_countries9;
	}
	public void setR67_asian_countries9(String r67_asian_countries9) {
		this.r67_asian_countries9 = r67_asian_countries9;
	}
	public BigDecimal getR67_outward_family() {
		return r67_outward_family;
	}
	public void setR67_outward_family(BigDecimal r67_outward_family) {
		this.r67_outward_family = r67_outward_family;
	}
	public BigDecimal getR67_outward_investment() {
		return r67_outward_investment;
	}
	public void setR67_outward_investment(BigDecimal r67_outward_investment) {
		this.r67_outward_investment = r67_outward_investment;
	}
	public BigDecimal getR67_outward_trade() {
		return r67_outward_trade;
	}
	public void setR67_outward_trade(BigDecimal r67_outward_trade) {
		this.r67_outward_trade = r67_outward_trade;
	}
	public BigDecimal getR67_outward_other() {
		return r67_outward_other;
	}
	public void setR67_outward_other(BigDecimal r67_outward_other) {
		this.r67_outward_other = r67_outward_other;
	}
	public BigDecimal getR67_outward_total() {
		return r67_outward_total;
	}
	public void setR67_outward_total(BigDecimal r67_outward_total) {
		this.r67_outward_total = r67_outward_total;
	}
	public BigDecimal getR67_inward_family() {
		return r67_inward_family;
	}
	public void setR67_inward_family(BigDecimal r67_inward_family) {
		this.r67_inward_family = r67_inward_family;
	}
	public BigDecimal getR67_inward_investment() {
		return r67_inward_investment;
	}
	public void setR67_inward_investment(BigDecimal r67_inward_investment) {
		this.r67_inward_investment = r67_inward_investment;
	}
	public BigDecimal getR67_inward_trade() {
		return r67_inward_trade;
	}
	public void setR67_inward_trade(BigDecimal r67_inward_trade) {
		this.r67_inward_trade = r67_inward_trade;
	}
	public BigDecimal getR67_inward_other() {
		return r67_inward_other;
	}
	public void setR67_inward_other(BigDecimal r67_inward_other) {
		this.r67_inward_other = r67_inward_other;
	}
	public BigDecimal getR67_inward_total() {
		return r67_inward_total;
	}
	public void setR67_inward_total(BigDecimal r67_inward_total) {
		this.r67_inward_total = r67_inward_total;
	}
	public String getR68_asian_countries10() {
		return r68_asian_countries10;
	}
	public void setR68_asian_countries10(String r68_asian_countries10) {
		this.r68_asian_countries10 = r68_asian_countries10;
	}
	public BigDecimal getR68_outward_family() {
		return r68_outward_family;
	}
	public void setR68_outward_family(BigDecimal r68_outward_family) {
		this.r68_outward_family = r68_outward_family;
	}
	public BigDecimal getR68_outward_investment() {
		return r68_outward_investment;
	}
	public void setR68_outward_investment(BigDecimal r68_outward_investment) {
		this.r68_outward_investment = r68_outward_investment;
	}
	public BigDecimal getR68_outward_trade() {
		return r68_outward_trade;
	}
	public void setR68_outward_trade(BigDecimal r68_outward_trade) {
		this.r68_outward_trade = r68_outward_trade;
	}
	public BigDecimal getR68_outward_other() {
		return r68_outward_other;
	}
	public void setR68_outward_other(BigDecimal r68_outward_other) {
		this.r68_outward_other = r68_outward_other;
	}
	public BigDecimal getR68_outward_total() {
		return r68_outward_total;
	}
	public void setR68_outward_total(BigDecimal r68_outward_total) {
		this.r68_outward_total = r68_outward_total;
	}
	public BigDecimal getR68_inward_family() {
		return r68_inward_family;
	}
	public void setR68_inward_family(BigDecimal r68_inward_family) {
		this.r68_inward_family = r68_inward_family;
	}
	public BigDecimal getR68_inward_investment() {
		return r68_inward_investment;
	}
	public void setR68_inward_investment(BigDecimal r68_inward_investment) {
		this.r68_inward_investment = r68_inward_investment;
	}
	public BigDecimal getR68_inward_trade() {
		return r68_inward_trade;
	}
	public void setR68_inward_trade(BigDecimal r68_inward_trade) {
		this.r68_inward_trade = r68_inward_trade;
	}
	public BigDecimal getR68_inward_other() {
		return r68_inward_other;
	}
	public void setR68_inward_other(BigDecimal r68_inward_other) {
		this.r68_inward_other = r68_inward_other;
	}
	public BigDecimal getR68_inward_total() {
		return r68_inward_total;
	}
	public void setR68_inward_total(BigDecimal r68_inward_total) {
		this.r68_inward_total = r68_inward_total;
	}
	public String getR69_asian_countries11() {
		return r69_asian_countries11;
	}
	public void setR69_asian_countries11(String r69_asian_countries11) {
		this.r69_asian_countries11 = r69_asian_countries11;
	}
	public BigDecimal getR69_outward_family() {
		return r69_outward_family;
	}
	public void setR69_outward_family(BigDecimal r69_outward_family) {
		this.r69_outward_family = r69_outward_family;
	}
	public BigDecimal getR69_outward_investment() {
		return r69_outward_investment;
	}
	public void setR69_outward_investment(BigDecimal r69_outward_investment) {
		this.r69_outward_investment = r69_outward_investment;
	}
	public BigDecimal getR69_outward_trade() {
		return r69_outward_trade;
	}
	public void setR69_outward_trade(BigDecimal r69_outward_trade) {
		this.r69_outward_trade = r69_outward_trade;
	}
	public BigDecimal getR69_outward_other() {
		return r69_outward_other;
	}
	public void setR69_outward_other(BigDecimal r69_outward_other) {
		this.r69_outward_other = r69_outward_other;
	}
	public BigDecimal getR69_outward_total() {
		return r69_outward_total;
	}
	public void setR69_outward_total(BigDecimal r69_outward_total) {
		this.r69_outward_total = r69_outward_total;
	}
	public BigDecimal getR69_inward_family() {
		return r69_inward_family;
	}
	public void setR69_inward_family(BigDecimal r69_inward_family) {
		this.r69_inward_family = r69_inward_family;
	}
	public BigDecimal getR69_inward_investment() {
		return r69_inward_investment;
	}
	public void setR69_inward_investment(BigDecimal r69_inward_investment) {
		this.r69_inward_investment = r69_inward_investment;
	}
	public BigDecimal getR69_inward_trade() {
		return r69_inward_trade;
	}
	public void setR69_inward_trade(BigDecimal r69_inward_trade) {
		this.r69_inward_trade = r69_inward_trade;
	}
	public BigDecimal getR69_inward_other() {
		return r69_inward_other;
	}
	public void setR69_inward_other(BigDecimal r69_inward_other) {
		this.r69_inward_other = r69_inward_other;
	}
	public BigDecimal getR69_inward_total() {
		return r69_inward_total;
	}
	public void setR69_inward_total(BigDecimal r69_inward_total) {
		this.r69_inward_total = r69_inward_total;
	}
	public String getR70_asian_countries12() {
		return r70_asian_countries12;
	}
	public void setR70_asian_countries12(String r70_asian_countries12) {
		this.r70_asian_countries12 = r70_asian_countries12;
	}
	public BigDecimal getR70_outward_family() {
		return r70_outward_family;
	}
	public void setR70_outward_family(BigDecimal r70_outward_family) {
		this.r70_outward_family = r70_outward_family;
	}
	public BigDecimal getR70_outward_investment() {
		return r70_outward_investment;
	}
	public void setR70_outward_investment(BigDecimal r70_outward_investment) {
		this.r70_outward_investment = r70_outward_investment;
	}
	public BigDecimal getR70_outward_trade() {
		return r70_outward_trade;
	}
	public void setR70_outward_trade(BigDecimal r70_outward_trade) {
		this.r70_outward_trade = r70_outward_trade;
	}
	public BigDecimal getR70_outward_other() {
		return r70_outward_other;
	}
	public void setR70_outward_other(BigDecimal r70_outward_other) {
		this.r70_outward_other = r70_outward_other;
	}
	public BigDecimal getR70_outward_total() {
		return r70_outward_total;
	}
	public void setR70_outward_total(BigDecimal r70_outward_total) {
		this.r70_outward_total = r70_outward_total;
	}
	public BigDecimal getR70_inward_family() {
		return r70_inward_family;
	}
	public void setR70_inward_family(BigDecimal r70_inward_family) {
		this.r70_inward_family = r70_inward_family;
	}
	public BigDecimal getR70_inward_investment() {
		return r70_inward_investment;
	}
	public void setR70_inward_investment(BigDecimal r70_inward_investment) {
		this.r70_inward_investment = r70_inward_investment;
	}
	public BigDecimal getR70_inward_trade() {
		return r70_inward_trade;
	}
	public void setR70_inward_trade(BigDecimal r70_inward_trade) {
		this.r70_inward_trade = r70_inward_trade;
	}
	public BigDecimal getR70_inward_other() {
		return r70_inward_other;
	}
	public void setR70_inward_other(BigDecimal r70_inward_other) {
		this.r70_inward_other = r70_inward_other;
	}
	public BigDecimal getR70_inward_total() {
		return r70_inward_total;
	}
	public void setR70_inward_total(BigDecimal r70_inward_total) {
		this.r70_inward_total = r70_inward_total;
	}
	public String getR71_asian_countries13() {
		return r71_asian_countries13;
	}
	public void setR71_asian_countries13(String r71_asian_countries13) {
		this.r71_asian_countries13 = r71_asian_countries13;
	}
	public BigDecimal getR71_outward_family() {
		return r71_outward_family;
	}
	public void setR71_outward_family(BigDecimal r71_outward_family) {
		this.r71_outward_family = r71_outward_family;
	}
	public BigDecimal getR71_outward_investment() {
		return r71_outward_investment;
	}
	public void setR71_outward_investment(BigDecimal r71_outward_investment) {
		this.r71_outward_investment = r71_outward_investment;
	}
	public BigDecimal getR71_outward_trade() {
		return r71_outward_trade;
	}
	public void setR71_outward_trade(BigDecimal r71_outward_trade) {
		this.r71_outward_trade = r71_outward_trade;
	}
	public BigDecimal getR71_outward_other() {
		return r71_outward_other;
	}
	public void setR71_outward_other(BigDecimal r71_outward_other) {
		this.r71_outward_other = r71_outward_other;
	}
	public BigDecimal getR71_outward_total() {
		return r71_outward_total;
	}
	public void setR71_outward_total(BigDecimal r71_outward_total) {
		this.r71_outward_total = r71_outward_total;
	}
	public BigDecimal getR71_inward_family() {
		return r71_inward_family;
	}
	public void setR71_inward_family(BigDecimal r71_inward_family) {
		this.r71_inward_family = r71_inward_family;
	}
	public BigDecimal getR71_inward_investment() {
		return r71_inward_investment;
	}
	public void setR71_inward_investment(BigDecimal r71_inward_investment) {
		this.r71_inward_investment = r71_inward_investment;
	}
	public BigDecimal getR71_inward_trade() {
		return r71_inward_trade;
	}
	public void setR71_inward_trade(BigDecimal r71_inward_trade) {
		this.r71_inward_trade = r71_inward_trade;
	}
	public BigDecimal getR71_inward_other() {
		return r71_inward_other;
	}
	public void setR71_inward_other(BigDecimal r71_inward_other) {
		this.r71_inward_other = r71_inward_other;
	}
	public BigDecimal getR71_inward_total() {
		return r71_inward_total;
	}
	public void setR71_inward_total(BigDecimal r71_inward_total) {
		this.r71_inward_total = r71_inward_total;
	}
	public String getR72_asian_countries14() {
		return r72_asian_countries14;
	}
	public void setR72_asian_countries14(String r72_asian_countries14) {
		this.r72_asian_countries14 = r72_asian_countries14;
	}
	public BigDecimal getR72_outward_family() {
		return r72_outward_family;
	}
	public void setR72_outward_family(BigDecimal r72_outward_family) {
		this.r72_outward_family = r72_outward_family;
	}
	public BigDecimal getR72_outward_investment() {
		return r72_outward_investment;
	}
	public void setR72_outward_investment(BigDecimal r72_outward_investment) {
		this.r72_outward_investment = r72_outward_investment;
	}
	public BigDecimal getR72_outward_trade() {
		return r72_outward_trade;
	}
	public void setR72_outward_trade(BigDecimal r72_outward_trade) {
		this.r72_outward_trade = r72_outward_trade;
	}
	public BigDecimal getR72_outward_other() {
		return r72_outward_other;
	}
	public void setR72_outward_other(BigDecimal r72_outward_other) {
		this.r72_outward_other = r72_outward_other;
	}
	public BigDecimal getR72_outward_total() {
		return r72_outward_total;
	}
	public void setR72_outward_total(BigDecimal r72_outward_total) {
		this.r72_outward_total = r72_outward_total;
	}
	public BigDecimal getR72_inward_family() {
		return r72_inward_family;
	}
	public void setR72_inward_family(BigDecimal r72_inward_family) {
		this.r72_inward_family = r72_inward_family;
	}
	public BigDecimal getR72_inward_investment() {
		return r72_inward_investment;
	}
	public void setR72_inward_investment(BigDecimal r72_inward_investment) {
		this.r72_inward_investment = r72_inward_investment;
	}
	public BigDecimal getR72_inward_trade() {
		return r72_inward_trade;
	}
	public void setR72_inward_trade(BigDecimal r72_inward_trade) {
		this.r72_inward_trade = r72_inward_trade;
	}
	public BigDecimal getR72_inward_other() {
		return r72_inward_other;
	}
	public void setR72_inward_other(BigDecimal r72_inward_other) {
		this.r72_inward_other = r72_inward_other;
	}
	public BigDecimal getR72_inward_total() {
		return r72_inward_total;
	}
	public void setR72_inward_total(BigDecimal r72_inward_total) {
		this.r72_inward_total = r72_inward_total;
	}
	public String getR73_asian_countries15() {
		return r73_asian_countries15;
	}
	public void setR73_asian_countries15(String r73_asian_countries15) {
		this.r73_asian_countries15 = r73_asian_countries15;
	}
	public BigDecimal getR73_outward_family() {
		return r73_outward_family;
	}
	public void setR73_outward_family(BigDecimal r73_outward_family) {
		this.r73_outward_family = r73_outward_family;
	}
	public BigDecimal getR73_outward_investment() {
		return r73_outward_investment;
	}
	public void setR73_outward_investment(BigDecimal r73_outward_investment) {
		this.r73_outward_investment = r73_outward_investment;
	}
	public BigDecimal getR73_outward_trade() {
		return r73_outward_trade;
	}
	public void setR73_outward_trade(BigDecimal r73_outward_trade) {
		this.r73_outward_trade = r73_outward_trade;
	}
	public BigDecimal getR73_outward_other() {
		return r73_outward_other;
	}
	public void setR73_outward_other(BigDecimal r73_outward_other) {
		this.r73_outward_other = r73_outward_other;
	}
	public BigDecimal getR73_outward_total() {
		return r73_outward_total;
	}
	public void setR73_outward_total(BigDecimal r73_outward_total) {
		this.r73_outward_total = r73_outward_total;
	}
	public BigDecimal getR73_inward_family() {
		return r73_inward_family;
	}
	public void setR73_inward_family(BigDecimal r73_inward_family) {
		this.r73_inward_family = r73_inward_family;
	}
	public BigDecimal getR73_inward_investment() {
		return r73_inward_investment;
	}
	public void setR73_inward_investment(BigDecimal r73_inward_investment) {
		this.r73_inward_investment = r73_inward_investment;
	}
	public BigDecimal getR73_inward_trade() {
		return r73_inward_trade;
	}
	public void setR73_inward_trade(BigDecimal r73_inward_trade) {
		this.r73_inward_trade = r73_inward_trade;
	}
	public BigDecimal getR73_inward_other() {
		return r73_inward_other;
	}
	public void setR73_inward_other(BigDecimal r73_inward_other) {
		this.r73_inward_other = r73_inward_other;
	}
	public BigDecimal getR73_inward_total() {
		return r73_inward_total;
	}
	public void setR73_inward_total(BigDecimal r73_inward_total) {
		this.r73_inward_total = r73_inward_total;
	}
	public String getR74_asian_countries16() {
		return r74_asian_countries16;
	}
	public void setR74_asian_countries16(String r74_asian_countries16) {
		this.r74_asian_countries16 = r74_asian_countries16;
	}
	public BigDecimal getR74_outward_family() {
		return r74_outward_family;
	}
	public void setR74_outward_family(BigDecimal r74_outward_family) {
		this.r74_outward_family = r74_outward_family;
	}
	public BigDecimal getR74_outward_investment() {
		return r74_outward_investment;
	}
	public void setR74_outward_investment(BigDecimal r74_outward_investment) {
		this.r74_outward_investment = r74_outward_investment;
	}
	public BigDecimal getR74_outward_trade() {
		return r74_outward_trade;
	}
	public void setR74_outward_trade(BigDecimal r74_outward_trade) {
		this.r74_outward_trade = r74_outward_trade;
	}
	public BigDecimal getR74_outward_other() {
		return r74_outward_other;
	}
	public void setR74_outward_other(BigDecimal r74_outward_other) {
		this.r74_outward_other = r74_outward_other;
	}
	public BigDecimal getR74_outward_total() {
		return r74_outward_total;
	}
	public void setR74_outward_total(BigDecimal r74_outward_total) {
		this.r74_outward_total = r74_outward_total;
	}
	public BigDecimal getR74_inward_family() {
		return r74_inward_family;
	}
	public void setR74_inward_family(BigDecimal r74_inward_family) {
		this.r74_inward_family = r74_inward_family;
	}
	public BigDecimal getR74_inward_investment() {
		return r74_inward_investment;
	}
	public void setR74_inward_investment(BigDecimal r74_inward_investment) {
		this.r74_inward_investment = r74_inward_investment;
	}
	public BigDecimal getR74_inward_trade() {
		return r74_inward_trade;
	}
	public void setR74_inward_trade(BigDecimal r74_inward_trade) {
		this.r74_inward_trade = r74_inward_trade;
	}
	public BigDecimal getR74_inward_other() {
		return r74_inward_other;
	}
	public void setR74_inward_other(BigDecimal r74_inward_other) {
		this.r74_inward_other = r74_inward_other;
	}
	public BigDecimal getR74_inward_total() {
		return r74_inward_total;
	}
	public void setR74_inward_total(BigDecimal r74_inward_total) {
		this.r74_inward_total = r74_inward_total;
	}
	public String getR75_asian_countries17() {
		return r75_asian_countries17;
	}
	public void setR75_asian_countries17(String r75_asian_countries17) {
		this.r75_asian_countries17 = r75_asian_countries17;
	}
	public BigDecimal getR75_outward_family() {
		return r75_outward_family;
	}
	public void setR75_outward_family(BigDecimal r75_outward_family) {
		this.r75_outward_family = r75_outward_family;
	}
	public BigDecimal getR75_outward_investment() {
		return r75_outward_investment;
	}
	public void setR75_outward_investment(BigDecimal r75_outward_investment) {
		this.r75_outward_investment = r75_outward_investment;
	}
	public BigDecimal getR75_outward_trade() {
		return r75_outward_trade;
	}
	public void setR75_outward_trade(BigDecimal r75_outward_trade) {
		this.r75_outward_trade = r75_outward_trade;
	}
	public BigDecimal getR75_outward_other() {
		return r75_outward_other;
	}
	public void setR75_outward_other(BigDecimal r75_outward_other) {
		this.r75_outward_other = r75_outward_other;
	}
	public BigDecimal getR75_outward_total() {
		return r75_outward_total;
	}
	public void setR75_outward_total(BigDecimal r75_outward_total) {
		this.r75_outward_total = r75_outward_total;
	}
	public BigDecimal getR75_inward_family() {
		return r75_inward_family;
	}
	public void setR75_inward_family(BigDecimal r75_inward_family) {
		this.r75_inward_family = r75_inward_family;
	}
	public BigDecimal getR75_inward_investment() {
		return r75_inward_investment;
	}
	public void setR75_inward_investment(BigDecimal r75_inward_investment) {
		this.r75_inward_investment = r75_inward_investment;
	}
	public BigDecimal getR75_inward_trade() {
		return r75_inward_trade;
	}
	public void setR75_inward_trade(BigDecimal r75_inward_trade) {
		this.r75_inward_trade = r75_inward_trade;
	}
	public BigDecimal getR75_inward_other() {
		return r75_inward_other;
	}
	public void setR75_inward_other(BigDecimal r75_inward_other) {
		this.r75_inward_other = r75_inward_other;
	}
	public BigDecimal getR75_inward_total() {
		return r75_inward_total;
	}
	public void setR75_inward_total(BigDecimal r75_inward_total) {
		this.r75_inward_total = r75_inward_total;
	}
	public String getR76_asian_countries18() {
		return r76_asian_countries18;
	}
	public void setR76_asian_countries18(String r76_asian_countries18) {
		this.r76_asian_countries18 = r76_asian_countries18;
	}
	public BigDecimal getR76_outward_family() {
		return r76_outward_family;
	}
	public void setR76_outward_family(BigDecimal r76_outward_family) {
		this.r76_outward_family = r76_outward_family;
	}
	public BigDecimal getR76_outward_investment() {
		return r76_outward_investment;
	}
	public void setR76_outward_investment(BigDecimal r76_outward_investment) {
		this.r76_outward_investment = r76_outward_investment;
	}
	public BigDecimal getR76_outward_trade() {
		return r76_outward_trade;
	}
	public void setR76_outward_trade(BigDecimal r76_outward_trade) {
		this.r76_outward_trade = r76_outward_trade;
	}
	public BigDecimal getR76_outward_other() {
		return r76_outward_other;
	}
	public void setR76_outward_other(BigDecimal r76_outward_other) {
		this.r76_outward_other = r76_outward_other;
	}
	public BigDecimal getR76_outward_total() {
		return r76_outward_total;
	}
	public void setR76_outward_total(BigDecimal r76_outward_total) {
		this.r76_outward_total = r76_outward_total;
	}
	public BigDecimal getR76_inward_family() {
		return r76_inward_family;
	}
	public void setR76_inward_family(BigDecimal r76_inward_family) {
		this.r76_inward_family = r76_inward_family;
	}
	public BigDecimal getR76_inward_investment() {
		return r76_inward_investment;
	}
	public void setR76_inward_investment(BigDecimal r76_inward_investment) {
		this.r76_inward_investment = r76_inward_investment;
	}
	public BigDecimal getR76_inward_trade() {
		return r76_inward_trade;
	}
	public void setR76_inward_trade(BigDecimal r76_inward_trade) {
		this.r76_inward_trade = r76_inward_trade;
	}
	public BigDecimal getR76_inward_other() {
		return r76_inward_other;
	}
	public void setR76_inward_other(BigDecimal r76_inward_other) {
		this.r76_inward_other = r76_inward_other;
	}
	public BigDecimal getR76_inward_total() {
		return r76_inward_total;
	}
	public void setR76_inward_total(BigDecimal r76_inward_total) {
		this.r76_inward_total = r76_inward_total;
	}
	public String getR77_latin_american_countries() {
		return r77_latin_american_countries;
	}
	public void setR77_latin_american_countries(String r77_latin_american_countries) {
		this.r77_latin_american_countries = r77_latin_american_countries;
	}
	public BigDecimal getR77_outward_family() {
		return r77_outward_family;
	}
	public void setR77_outward_family(BigDecimal r77_outward_family) {
		this.r77_outward_family = r77_outward_family;
	}
	public BigDecimal getR77_outward_investment() {
		return r77_outward_investment;
	}
	public void setR77_outward_investment(BigDecimal r77_outward_investment) {
		this.r77_outward_investment = r77_outward_investment;
	}
	public BigDecimal getR77_outward_trade() {
		return r77_outward_trade;
	}
	public void setR77_outward_trade(BigDecimal r77_outward_trade) {
		this.r77_outward_trade = r77_outward_trade;
	}
	public BigDecimal getR77_outward_other() {
		return r77_outward_other;
	}
	public void setR77_outward_other(BigDecimal r77_outward_other) {
		this.r77_outward_other = r77_outward_other;
	}
	public BigDecimal getR77_outward_total() {
		return r77_outward_total;
	}
	public void setR77_outward_total(BigDecimal r77_outward_total) {
		this.r77_outward_total = r77_outward_total;
	}
	public BigDecimal getR77_inward_family() {
		return r77_inward_family;
	}
	public void setR77_inward_family(BigDecimal r77_inward_family) {
		this.r77_inward_family = r77_inward_family;
	}
	public BigDecimal getR77_inward_investment() {
		return r77_inward_investment;
	}
	public void setR77_inward_investment(BigDecimal r77_inward_investment) {
		this.r77_inward_investment = r77_inward_investment;
	}
	public BigDecimal getR77_inward_trade() {
		return r77_inward_trade;
	}
	public void setR77_inward_trade(BigDecimal r77_inward_trade) {
		this.r77_inward_trade = r77_inward_trade;
	}
	public BigDecimal getR77_inward_other() {
		return r77_inward_other;
	}
	public void setR77_inward_other(BigDecimal r77_inward_other) {
		this.r77_inward_other = r77_inward_other;
	}
	public BigDecimal getR77_inward_total() {
		return r77_inward_total;
	}
	public void setR77_inward_total(BigDecimal r77_inward_total) {
		this.r77_inward_total = r77_inward_total;
	}
	public String getR78_latin_american_countries1() {
		return r78_latin_american_countries1;
	}
	public void setR78_latin_american_countries1(String r78_latin_american_countries1) {
		this.r78_latin_american_countries1 = r78_latin_american_countries1;
	}
	public BigDecimal getR78_outward_family() {
		return r78_outward_family;
	}
	public void setR78_outward_family(BigDecimal r78_outward_family) {
		this.r78_outward_family = r78_outward_family;
	}
	public BigDecimal getR78_outward_investment() {
		return r78_outward_investment;
	}
	public void setR78_outward_investment(BigDecimal r78_outward_investment) {
		this.r78_outward_investment = r78_outward_investment;
	}
	public BigDecimal getR78_outward_trade() {
		return r78_outward_trade;
	}
	public void setR78_outward_trade(BigDecimal r78_outward_trade) {
		this.r78_outward_trade = r78_outward_trade;
	}
	public BigDecimal getR78_outward_other() {
		return r78_outward_other;
	}
	public void setR78_outward_other(BigDecimal r78_outward_other) {
		this.r78_outward_other = r78_outward_other;
	}
	public BigDecimal getR78_outward_total() {
		return r78_outward_total;
	}
	public void setR78_outward_total(BigDecimal r78_outward_total) {
		this.r78_outward_total = r78_outward_total;
	}
	public BigDecimal getR78_inward_family() {
		return r78_inward_family;
	}
	public void setR78_inward_family(BigDecimal r78_inward_family) {
		this.r78_inward_family = r78_inward_family;
	}
	public BigDecimal getR78_inward_investment() {
		return r78_inward_investment;
	}
	public void setR78_inward_investment(BigDecimal r78_inward_investment) {
		this.r78_inward_investment = r78_inward_investment;
	}
	public BigDecimal getR78_inward_trade() {
		return r78_inward_trade;
	}
	public void setR78_inward_trade(BigDecimal r78_inward_trade) {
		this.r78_inward_trade = r78_inward_trade;
	}
	public BigDecimal getR78_inward_other() {
		return r78_inward_other;
	}
	public void setR78_inward_other(BigDecimal r78_inward_other) {
		this.r78_inward_other = r78_inward_other;
	}
	public BigDecimal getR78_inward_total() {
		return r78_inward_total;
	}
	public void setR78_inward_total(BigDecimal r78_inward_total) {
		this.r78_inward_total = r78_inward_total;
	}
	public String getR79_latin_american_countries2() {
		return r79_latin_american_countries2;
	}
	public void setR79_latin_american_countries2(String r79_latin_american_countries2) {
		this.r79_latin_american_countries2 = r79_latin_american_countries2;
	}
	public BigDecimal getR79_outward_family() {
		return r79_outward_family;
	}
	public void setR79_outward_family(BigDecimal r79_outward_family) {
		this.r79_outward_family = r79_outward_family;
	}
	public BigDecimal getR79_outward_investment() {
		return r79_outward_investment;
	}
	public void setR79_outward_investment(BigDecimal r79_outward_investment) {
		this.r79_outward_investment = r79_outward_investment;
	}
	public BigDecimal getR79_outward_trade() {
		return r79_outward_trade;
	}
	public void setR79_outward_trade(BigDecimal r79_outward_trade) {
		this.r79_outward_trade = r79_outward_trade;
	}
	public BigDecimal getR79_outward_other() {
		return r79_outward_other;
	}
	public void setR79_outward_other(BigDecimal r79_outward_other) {
		this.r79_outward_other = r79_outward_other;
	}
	public BigDecimal getR79_outward_total() {
		return r79_outward_total;
	}
	public void setR79_outward_total(BigDecimal r79_outward_total) {
		this.r79_outward_total = r79_outward_total;
	}
	public BigDecimal getR79_inward_family() {
		return r79_inward_family;
	}
	public void setR79_inward_family(BigDecimal r79_inward_family) {
		this.r79_inward_family = r79_inward_family;
	}
	public BigDecimal getR79_inward_investment() {
		return r79_inward_investment;
	}
	public void setR79_inward_investment(BigDecimal r79_inward_investment) {
		this.r79_inward_investment = r79_inward_investment;
	}
	public BigDecimal getR79_inward_trade() {
		return r79_inward_trade;
	}
	public void setR79_inward_trade(BigDecimal r79_inward_trade) {
		this.r79_inward_trade = r79_inward_trade;
	}
	public BigDecimal getR79_inward_other() {
		return r79_inward_other;
	}
	public void setR79_inward_other(BigDecimal r79_inward_other) {
		this.r79_inward_other = r79_inward_other;
	}
	public BigDecimal getR79_inward_total() {
		return r79_inward_total;
	}
	public void setR79_inward_total(BigDecimal r79_inward_total) {
		this.r79_inward_total = r79_inward_total;
	}
	public String getR80_latin_american_countries3() {
		return r80_latin_american_countries3;
	}
	public void setR80_latin_american_countries3(String r80_latin_american_countries3) {
		this.r80_latin_american_countries3 = r80_latin_american_countries3;
	}
	public BigDecimal getR80_outward_family() {
		return r80_outward_family;
	}
	public void setR80_outward_family(BigDecimal r80_outward_family) {
		this.r80_outward_family = r80_outward_family;
	}
	public BigDecimal getR80_outward_investment() {
		return r80_outward_investment;
	}
	public void setR80_outward_investment(BigDecimal r80_outward_investment) {
		this.r80_outward_investment = r80_outward_investment;
	}
	public BigDecimal getR80_outward_trade() {
		return r80_outward_trade;
	}
	public void setR80_outward_trade(BigDecimal r80_outward_trade) {
		this.r80_outward_trade = r80_outward_trade;
	}
	public BigDecimal getR80_outward_other() {
		return r80_outward_other;
	}
	public void setR80_outward_other(BigDecimal r80_outward_other) {
		this.r80_outward_other = r80_outward_other;
	}
	public BigDecimal getR80_outward_total() {
		return r80_outward_total;
	}
	public void setR80_outward_total(BigDecimal r80_outward_total) {
		this.r80_outward_total = r80_outward_total;
	}
	public BigDecimal getR80_inward_family() {
		return r80_inward_family;
	}
	public void setR80_inward_family(BigDecimal r80_inward_family) {
		this.r80_inward_family = r80_inward_family;
	}
	public BigDecimal getR80_inward_investment() {
		return r80_inward_investment;
	}
	public void setR80_inward_investment(BigDecimal r80_inward_investment) {
		this.r80_inward_investment = r80_inward_investment;
	}
	public BigDecimal getR80_inward_trade() {
		return r80_inward_trade;
	}
	public void setR80_inward_trade(BigDecimal r80_inward_trade) {
		this.r80_inward_trade = r80_inward_trade;
	}
	public BigDecimal getR80_inward_other() {
		return r80_inward_other;
	}
	public void setR80_inward_other(BigDecimal r80_inward_other) {
		this.r80_inward_other = r80_inward_other;
	}
	public BigDecimal getR80_inward_total() {
		return r80_inward_total;
	}
	public void setR80_inward_total(BigDecimal r80_inward_total) {
		this.r80_inward_total = r80_inward_total;
	}
	public String getR81_latin_american_countries4() {
		return r81_latin_american_countries4;
	}
	public void setR81_latin_american_countries4(String r81_latin_american_countries4) {
		this.r81_latin_american_countries4 = r81_latin_american_countries4;
	}
	public BigDecimal getR81_outward_family() {
		return r81_outward_family;
	}
	public void setR81_outward_family(BigDecimal r81_outward_family) {
		this.r81_outward_family = r81_outward_family;
	}
	public BigDecimal getR81_outward_investment() {
		return r81_outward_investment;
	}
	public void setR81_outward_investment(BigDecimal r81_outward_investment) {
		this.r81_outward_investment = r81_outward_investment;
	}
	public BigDecimal getR81_outward_trade() {
		return r81_outward_trade;
	}
	public void setR81_outward_trade(BigDecimal r81_outward_trade) {
		this.r81_outward_trade = r81_outward_trade;
	}
	public BigDecimal getR81_outward_other() {
		return r81_outward_other;
	}
	public void setR81_outward_other(BigDecimal r81_outward_other) {
		this.r81_outward_other = r81_outward_other;
	}
	public BigDecimal getR81_outward_total() {
		return r81_outward_total;
	}
	public void setR81_outward_total(BigDecimal r81_outward_total) {
		this.r81_outward_total = r81_outward_total;
	}
	public BigDecimal getR81_inward_family() {
		return r81_inward_family;
	}
	public void setR81_inward_family(BigDecimal r81_inward_family) {
		this.r81_inward_family = r81_inward_family;
	}
	public BigDecimal getR81_inward_investment() {
		return r81_inward_investment;
	}
	public void setR81_inward_investment(BigDecimal r81_inward_investment) {
		this.r81_inward_investment = r81_inward_investment;
	}
	public BigDecimal getR81_inward_trade() {
		return r81_inward_trade;
	}
	public void setR81_inward_trade(BigDecimal r81_inward_trade) {
		this.r81_inward_trade = r81_inward_trade;
	}
	public BigDecimal getR81_inward_other() {
		return r81_inward_other;
	}
	public void setR81_inward_other(BigDecimal r81_inward_other) {
		this.r81_inward_other = r81_inward_other;
	}
	public BigDecimal getR81_inward_total() {
		return r81_inward_total;
	}
	public void setR81_inward_total(BigDecimal r81_inward_total) {
		this.r81_inward_total = r81_inward_total;
	}
	public String getR82_latin_american_countries5() {
		return r82_latin_american_countries5;
	}
	public void setR82_latin_american_countries5(String r82_latin_american_countries5) {
		this.r82_latin_american_countries5 = r82_latin_american_countries5;
	}
	public BigDecimal getR82_outward_family() {
		return r82_outward_family;
	}
	public void setR82_outward_family(BigDecimal r82_outward_family) {
		this.r82_outward_family = r82_outward_family;
	}
	public BigDecimal getR82_outward_investment() {
		return r82_outward_investment;
	}
	public void setR82_outward_investment(BigDecimal r82_outward_investment) {
		this.r82_outward_investment = r82_outward_investment;
	}
	public BigDecimal getR82_outward_trade() {
		return r82_outward_trade;
	}
	public void setR82_outward_trade(BigDecimal r82_outward_trade) {
		this.r82_outward_trade = r82_outward_trade;
	}
	public BigDecimal getR82_outward_other() {
		return r82_outward_other;
	}
	public void setR82_outward_other(BigDecimal r82_outward_other) {
		this.r82_outward_other = r82_outward_other;
	}
	public BigDecimal getR82_outward_total() {
		return r82_outward_total;
	}
	public void setR82_outward_total(BigDecimal r82_outward_total) {
		this.r82_outward_total = r82_outward_total;
	}
	public BigDecimal getR82_inward_family() {
		return r82_inward_family;
	}
	public void setR82_inward_family(BigDecimal r82_inward_family) {
		this.r82_inward_family = r82_inward_family;
	}
	public BigDecimal getR82_inward_investment() {
		return r82_inward_investment;
	}
	public void setR82_inward_investment(BigDecimal r82_inward_investment) {
		this.r82_inward_investment = r82_inward_investment;
	}
	public BigDecimal getR82_inward_trade() {
		return r82_inward_trade;
	}
	public void setR82_inward_trade(BigDecimal r82_inward_trade) {
		this.r82_inward_trade = r82_inward_trade;
	}
	public BigDecimal getR82_inward_other() {
		return r82_inward_other;
	}
	public void setR82_inward_other(BigDecimal r82_inward_other) {
		this.r82_inward_other = r82_inward_other;
	}
	public BigDecimal getR82_inward_total() {
		return r82_inward_total;
	}
	public void setR82_inward_total(BigDecimal r82_inward_total) {
		this.r82_inward_total = r82_inward_total;
	}
	public String getR83_latin_american_countries6() {
		return r83_latin_american_countries6;
	}
	public void setR83_latin_american_countries6(String r83_latin_american_countries6) {
		this.r83_latin_american_countries6 = r83_latin_american_countries6;
	}
	public BigDecimal getR83_outward_family() {
		return r83_outward_family;
	}
	public void setR83_outward_family(BigDecimal r83_outward_family) {
		this.r83_outward_family = r83_outward_family;
	}
	public BigDecimal getR83_outward_investment() {
		return r83_outward_investment;
	}
	public void setR83_outward_investment(BigDecimal r83_outward_investment) {
		this.r83_outward_investment = r83_outward_investment;
	}
	public BigDecimal getR83_outward_trade() {
		return r83_outward_trade;
	}
	public void setR83_outward_trade(BigDecimal r83_outward_trade) {
		this.r83_outward_trade = r83_outward_trade;
	}
	public BigDecimal getR83_outward_other() {
		return r83_outward_other;
	}
	public void setR83_outward_other(BigDecimal r83_outward_other) {
		this.r83_outward_other = r83_outward_other;
	}
	public BigDecimal getR83_outward_total() {
		return r83_outward_total;
	}
	public void setR83_outward_total(BigDecimal r83_outward_total) {
		this.r83_outward_total = r83_outward_total;
	}
	public BigDecimal getR83_inward_family() {
		return r83_inward_family;
	}
	public void setR83_inward_family(BigDecimal r83_inward_family) {
		this.r83_inward_family = r83_inward_family;
	}
	public BigDecimal getR83_inward_investment() {
		return r83_inward_investment;
	}
	public void setR83_inward_investment(BigDecimal r83_inward_investment) {
		this.r83_inward_investment = r83_inward_investment;
	}
	public BigDecimal getR83_inward_trade() {
		return r83_inward_trade;
	}
	public void setR83_inward_trade(BigDecimal r83_inward_trade) {
		this.r83_inward_trade = r83_inward_trade;
	}
	public BigDecimal getR83_inward_other() {
		return r83_inward_other;
	}
	public void setR83_inward_other(BigDecimal r83_inward_other) {
		this.r83_inward_other = r83_inward_other;
	}
	public BigDecimal getR83_inward_total() {
		return r83_inward_total;
	}
	public void setR83_inward_total(BigDecimal r83_inward_total) {
		this.r83_inward_total = r83_inward_total;
	}
	public String getR84_oceania_countries() {
		return r84_oceania_countries;
	}
	public void setR84_oceania_countries(String r84_oceania_countries) {
		this.r84_oceania_countries = r84_oceania_countries;
	}
	public BigDecimal getR84_outward_family() {
		return r84_outward_family;
	}
	public void setR84_outward_family(BigDecimal r84_outward_family) {
		this.r84_outward_family = r84_outward_family;
	}
	public BigDecimal getR84_outward_investment() {
		return r84_outward_investment;
	}
	public void setR84_outward_investment(BigDecimal r84_outward_investment) {
		this.r84_outward_investment = r84_outward_investment;
	}
	public BigDecimal getR84_outward_trade() {
		return r84_outward_trade;
	}
	public void setR84_outward_trade(BigDecimal r84_outward_trade) {
		this.r84_outward_trade = r84_outward_trade;
	}
	public BigDecimal getR84_outward_other() {
		return r84_outward_other;
	}
	public void setR84_outward_other(BigDecimal r84_outward_other) {
		this.r84_outward_other = r84_outward_other;
	}
	public BigDecimal getR84_outward_total() {
		return r84_outward_total;
	}
	public void setR84_outward_total(BigDecimal r84_outward_total) {
		this.r84_outward_total = r84_outward_total;
	}
	public BigDecimal getR84_inward_family() {
		return r84_inward_family;
	}
	public void setR84_inward_family(BigDecimal r84_inward_family) {
		this.r84_inward_family = r84_inward_family;
	}
	public BigDecimal getR84_inward_investment() {
		return r84_inward_investment;
	}
	public void setR84_inward_investment(BigDecimal r84_inward_investment) {
		this.r84_inward_investment = r84_inward_investment;
	}
	public BigDecimal getR84_inward_trade() {
		return r84_inward_trade;
	}
	public void setR84_inward_trade(BigDecimal r84_inward_trade) {
		this.r84_inward_trade = r84_inward_trade;
	}
	public BigDecimal getR84_inward_other() {
		return r84_inward_other;
	}
	public void setR84_inward_other(BigDecimal r84_inward_other) {
		this.r84_inward_other = r84_inward_other;
	}
	public BigDecimal getR84_inward_total() {
		return r84_inward_total;
	}
	public void setR84_inward_total(BigDecimal r84_inward_total) {
		this.r84_inward_total = r84_inward_total;
	}
	public String getR85_oceania_countries1() {
		return r85_oceania_countries1;
	}
	public void setR85_oceania_countries1(String r85_oceania_countries1) {
		this.r85_oceania_countries1 = r85_oceania_countries1;
	}
	public BigDecimal getR85_outward_family() {
		return r85_outward_family;
	}
	public void setR85_outward_family(BigDecimal r85_outward_family) {
		this.r85_outward_family = r85_outward_family;
	}
	public BigDecimal getR85_outward_investment() {
		return r85_outward_investment;
	}
	public void setR85_outward_investment(BigDecimal r85_outward_investment) {
		this.r85_outward_investment = r85_outward_investment;
	}
	public BigDecimal getR85_outward_trade() {
		return r85_outward_trade;
	}
	public void setR85_outward_trade(BigDecimal r85_outward_trade) {
		this.r85_outward_trade = r85_outward_trade;
	}
	public BigDecimal getR85_outward_other() {
		return r85_outward_other;
	}
	public void setR85_outward_other(BigDecimal r85_outward_other) {
		this.r85_outward_other = r85_outward_other;
	}
	public BigDecimal getR85_outward_total() {
		return r85_outward_total;
	}
	public void setR85_outward_total(BigDecimal r85_outward_total) {
		this.r85_outward_total = r85_outward_total;
	}
	public BigDecimal getR85_inward_family() {
		return r85_inward_family;
	}
	public void setR85_inward_family(BigDecimal r85_inward_family) {
		this.r85_inward_family = r85_inward_family;
	}
	public BigDecimal getR85_inward_investment() {
		return r85_inward_investment;
	}
	public void setR85_inward_investment(BigDecimal r85_inward_investment) {
		this.r85_inward_investment = r85_inward_investment;
	}
	public BigDecimal getR85_inward_trade() {
		return r85_inward_trade;
	}
	public void setR85_inward_trade(BigDecimal r85_inward_trade) {
		this.r85_inward_trade = r85_inward_trade;
	}
	public BigDecimal getR85_inward_other() {
		return r85_inward_other;
	}
	public void setR85_inward_other(BigDecimal r85_inward_other) {
		this.r85_inward_other = r85_inward_other;
	}
	public BigDecimal getR85_inward_total() {
		return r85_inward_total;
	}
	public void setR85_inward_total(BigDecimal r85_inward_total) {
		this.r85_inward_total = r85_inward_total;
	}
	public String getR86_oceania_countries2() {
		return r86_oceania_countries2;
	}
	public void setR86_oceania_countries2(String r86_oceania_countries2) {
		this.r86_oceania_countries2 = r86_oceania_countries2;
	}
	public BigDecimal getR86_outward_family() {
		return r86_outward_family;
	}
	public void setR86_outward_family(BigDecimal r86_outward_family) {
		this.r86_outward_family = r86_outward_family;
	}
	public BigDecimal getR86_outward_investment() {
		return r86_outward_investment;
	}
	public void setR86_outward_investment(BigDecimal r86_outward_investment) {
		this.r86_outward_investment = r86_outward_investment;
	}
	public BigDecimal getR86_outward_trade() {
		return r86_outward_trade;
	}
	public void setR86_outward_trade(BigDecimal r86_outward_trade) {
		this.r86_outward_trade = r86_outward_trade;
	}
	public BigDecimal getR86_outward_other() {
		return r86_outward_other;
	}
	public void setR86_outward_other(BigDecimal r86_outward_other) {
		this.r86_outward_other = r86_outward_other;
	}
	public BigDecimal getR86_outward_total() {
		return r86_outward_total;
	}
	public void setR86_outward_total(BigDecimal r86_outward_total) {
		this.r86_outward_total = r86_outward_total;
	}
	public BigDecimal getR86_inward_family() {
		return r86_inward_family;
	}
	public void setR86_inward_family(BigDecimal r86_inward_family) {
		this.r86_inward_family = r86_inward_family;
	}
	public BigDecimal getR86_inward_investment() {
		return r86_inward_investment;
	}
	public void setR86_inward_investment(BigDecimal r86_inward_investment) {
		this.r86_inward_investment = r86_inward_investment;
	}
	public BigDecimal getR86_inward_trade() {
		return r86_inward_trade;
	}
	public void setR86_inward_trade(BigDecimal r86_inward_trade) {
		this.r86_inward_trade = r86_inward_trade;
	}
	public BigDecimal getR86_inward_other() {
		return r86_inward_other;
	}
	public void setR86_inward_other(BigDecimal r86_inward_other) {
		this.r86_inward_other = r86_inward_other;
	}
	public BigDecimal getR86_inward_total() {
		return r86_inward_total;
	}
	public void setR86_inward_total(BigDecimal r86_inward_total) {
		this.r86_inward_total = r86_inward_total;
	}
	public String getR87_remaining_countries() {
		return r87_remaining_countries;
	}
	public void setR87_remaining_countries(String r87_remaining_countries) {
		this.r87_remaining_countries = r87_remaining_countries;
	}
	public BigDecimal getR87_outward_family() {
		return r87_outward_family;
	}
	public void setR87_outward_family(BigDecimal r87_outward_family) {
		this.r87_outward_family = r87_outward_family;
	}
	public BigDecimal getR87_outward_investment() {
		return r87_outward_investment;
	}
	public void setR87_outward_investment(BigDecimal r87_outward_investment) {
		this.r87_outward_investment = r87_outward_investment;
	}
	public BigDecimal getR87_outward_trade() {
		return r87_outward_trade;
	}
	public void setR87_outward_trade(BigDecimal r87_outward_trade) {
		this.r87_outward_trade = r87_outward_trade;
	}
	public BigDecimal getR87_outward_other() {
		return r87_outward_other;
	}
	public void setR87_outward_other(BigDecimal r87_outward_other) {
		this.r87_outward_other = r87_outward_other;
	}
	public BigDecimal getR87_outward_total() {
		return r87_outward_total;
	}
	public void setR87_outward_total(BigDecimal r87_outward_total) {
		this.r87_outward_total = r87_outward_total;
	}
	public BigDecimal getR87_inward_family() {
		return r87_inward_family;
	}
	public void setR87_inward_family(BigDecimal r87_inward_family) {
		this.r87_inward_family = r87_inward_family;
	}
	public BigDecimal getR87_inward_investment() {
		return r87_inward_investment;
	}
	public void setR87_inward_investment(BigDecimal r87_inward_investment) {
		this.r87_inward_investment = r87_inward_investment;
	}
	public BigDecimal getR87_inward_trade() {
		return r87_inward_trade;
	}
	public void setR87_inward_trade(BigDecimal r87_inward_trade) {
		this.r87_inward_trade = r87_inward_trade;
	}
	public BigDecimal getR87_inward_other() {
		return r87_inward_other;
	}
	public void setR87_inward_other(BigDecimal r87_inward_other) {
		this.r87_inward_other = r87_inward_other;
	}
	public BigDecimal getR87_inward_total() {
		return r87_inward_total;
	}
	public void setR87_inward_total(BigDecimal r87_inward_total) {
		this.r87_inward_total = r87_inward_total;
	}
	public String getR88_remaining_countries1() {
		return r88_remaining_countries1;
	}
	public void setR88_remaining_countries1(String r88_remaining_countries1) {
		this.r88_remaining_countries1 = r88_remaining_countries1;
	}
	public BigDecimal getR88_outward_family() {
		return r88_outward_family;
	}
	public void setR88_outward_family(BigDecimal r88_outward_family) {
		this.r88_outward_family = r88_outward_family;
	}
	public BigDecimal getR88_outward_investment() {
		return r88_outward_investment;
	}
	public void setR88_outward_investment(BigDecimal r88_outward_investment) {
		this.r88_outward_investment = r88_outward_investment;
	}
	public BigDecimal getR88_outward_trade() {
		return r88_outward_trade;
	}
	public void setR88_outward_trade(BigDecimal r88_outward_trade) {
		this.r88_outward_trade = r88_outward_trade;
	}
	public BigDecimal getR88_outward_other() {
		return r88_outward_other;
	}
	public void setR88_outward_other(BigDecimal r88_outward_other) {
		this.r88_outward_other = r88_outward_other;
	}
	public BigDecimal getR88_outward_total() {
		return r88_outward_total;
	}
	public void setR88_outward_total(BigDecimal r88_outward_total) {
		this.r88_outward_total = r88_outward_total;
	}
	public BigDecimal getR88_inward_family() {
		return r88_inward_family;
	}
	public void setR88_inward_family(BigDecimal r88_inward_family) {
		this.r88_inward_family = r88_inward_family;
	}
	public BigDecimal getR88_inward_investment() {
		return r88_inward_investment;
	}
	public void setR88_inward_investment(BigDecimal r88_inward_investment) {
		this.r88_inward_investment = r88_inward_investment;
	}
	public BigDecimal getR88_inward_trade() {
		return r88_inward_trade;
	}
	public void setR88_inward_trade(BigDecimal r88_inward_trade) {
		this.r88_inward_trade = r88_inward_trade;
	}
	public BigDecimal getR88_inward_other() {
		return r88_inward_other;
	}
	public void setR88_inward_other(BigDecimal r88_inward_other) {
		this.r88_inward_other = r88_inward_other;
	}
	public BigDecimal getR88_inward_total() {
		return r88_inward_total;
	}
	public void setR88_inward_total(BigDecimal r88_inward_total) {
		this.r88_inward_total = r88_inward_total;
	}
	public String getR89_other_countries() {
		return r89_other_countries;
	}
	public void setR89_other_countries(String r89_other_countries) {
		this.r89_other_countries = r89_other_countries;
	}
	public BigDecimal getR89_outward_family() {
		return r89_outward_family;
	}
	public void setR89_outward_family(BigDecimal r89_outward_family) {
		this.r89_outward_family = r89_outward_family;
	}
	public BigDecimal getR89_outward_investment() {
		return r89_outward_investment;
	}
	public void setR89_outward_investment(BigDecimal r89_outward_investment) {
		this.r89_outward_investment = r89_outward_investment;
	}
	public BigDecimal getR89_outward_trade() {
		return r89_outward_trade;
	}
	public void setR89_outward_trade(BigDecimal r89_outward_trade) {
		this.r89_outward_trade = r89_outward_trade;
	}
	public BigDecimal getR89_outward_other() {
		return r89_outward_other;
	}
	public void setR89_outward_other(BigDecimal r89_outward_other) {
		this.r89_outward_other = r89_outward_other;
	}
	public BigDecimal getR89_outward_total() {
		return r89_outward_total;
	}
	public void setR89_outward_total(BigDecimal r89_outward_total) {
		this.r89_outward_total = r89_outward_total;
	}
	public BigDecimal getR89_inward_family() {
		return r89_inward_family;
	}
	public void setR89_inward_family(BigDecimal r89_inward_family) {
		this.r89_inward_family = r89_inward_family;
	}
	public BigDecimal getR89_inward_investment() {
		return r89_inward_investment;
	}
	public void setR89_inward_investment(BigDecimal r89_inward_investment) {
		this.r89_inward_investment = r89_inward_investment;
	}
	public BigDecimal getR89_inward_trade() {
		return r89_inward_trade;
	}
	public void setR89_inward_trade(BigDecimal r89_inward_trade) {
		this.r89_inward_trade = r89_inward_trade;
	}
	public BigDecimal getR89_inward_other() {
		return r89_inward_other;
	}
	public void setR89_inward_other(BigDecimal r89_inward_other) {
		this.r89_inward_other = r89_inward_other;
	}
	public BigDecimal getR89_inward_total() {
		return r89_inward_total;
	}
	public void setR89_inward_total(BigDecimal r89_inward_total) {
		this.r89_inward_total = r89_inward_total;
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
	public BRF038_ENTITY() {
		super();
		// TODO Auto-generated constructor stub
	}

	
}
