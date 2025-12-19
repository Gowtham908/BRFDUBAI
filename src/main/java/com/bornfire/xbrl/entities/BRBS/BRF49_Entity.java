package com.bornfire.xbrl.entities.BRBS;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
@Entity
@Table(name = "BRF49_SUMMARYTABLE")
public class BRF49_Entity {
	private String	r10_product;
	private BigDecimal	r10_year_amount;
	private BigDecimal	r10_year_factor;
	private BigDecimal	r10_year_calculated;
	private BigDecimal	r10_total_asf;
	private String	r11_product;
	private BigDecimal	r11_year_amount;
	private BigDecimal	r11_year_factor;
	private BigDecimal	r11_year_calculated;  
	private BigDecimal	r11_total_asf;
	private String	r13_product;
	private BigDecimal	r13_month_amount;
	private BigDecimal	r13_6month_amount;
	private BigDecimal	r13_year_amount;
	private BigDecimal	r13_month_factor;
	private BigDecimal	r13_6month_factor;
	private BigDecimal	r13_year_factor;
	private BigDecimal	r13_month_calculated;
	private BigDecimal	r13_6month_calculated;
	private BigDecimal	r13_year_calculated;
	private BigDecimal	r13_total_asf;
	private String	r14_product;
	private BigDecimal	r14_month_amount;
	private BigDecimal	r14_6month_amount;
	private BigDecimal	r14_year_amount;
	private BigDecimal	r14_month_factor;
	private BigDecimal	r14_6month_factor;
	private BigDecimal	r14_year_factor;
	private BigDecimal	r14_month_calculated;
	private BigDecimal	r14_6month_calculated;
	private BigDecimal	r14_year_calculated;
	private BigDecimal	r14_total_asf;
	private String	r15_product;
	private BigDecimal	r15_month_amount;
	private BigDecimal	r15_6month_amount;
	private BigDecimal	r15_year_amount;
	private BigDecimal	r15_month_factor;
	private BigDecimal	r15_6month_factor;
	private BigDecimal	r15_year_factor;
	private BigDecimal	r15_month_calculated;
	private BigDecimal	r15_6month_calculated;
	private BigDecimal	r15_year_calculated;
	private BigDecimal	r15_total_asf;
	private String	r17_product;
	private BigDecimal	r17_month_amount;
	private BigDecimal	r17_6month_amount;
	private BigDecimal	r17_year_amount;
	private BigDecimal	r17_month_factor;
	private BigDecimal	r17_6month_factor;
	private BigDecimal	r17_year_factor;
	private BigDecimal	r17_month_calculated;
	private BigDecimal	r17_6month_calculated;
	private BigDecimal	r17_year_calculated;
	private BigDecimal	r17_total_asf;
	private String	r18_product;
	private BigDecimal	r18_month_amount;
	private BigDecimal	r18_6month_amount;
	private BigDecimal	r18_year_amount;
	private BigDecimal	r18_month_factor;
	private BigDecimal	r18_6month_factor;
	private BigDecimal	r18_year_factor;
	private BigDecimal	r18_month_calculated;
	private BigDecimal	r18_6month_calculated;
	private BigDecimal	r18_year_calculated;
	private BigDecimal	r18_total_asf;
	private String	r19_product;
	private BigDecimal	r19_month_amount;
	private BigDecimal	r19_6month_amount;
	private BigDecimal	r19_year_amount;
	private BigDecimal	r19_month_factor;
	private BigDecimal	r19_6month_factor;
	private BigDecimal	r19_year_factor;
	private BigDecimal	r19_month_calculated;
	private BigDecimal	r19_6month_calculated;
	private BigDecimal	r19_year_calculated;
	private BigDecimal	r19_total_asf;
	private String	r20_product;
	private BigDecimal	r20_month_amount;
	private BigDecimal	r20_6month_amount;
	private BigDecimal	r20_year_amount;
	private BigDecimal	r20_month_factor;
	private BigDecimal	r20_6month_factor;
	private BigDecimal	r20_year_factor;
	private BigDecimal	r20_month_calculated;
	private BigDecimal	r20_6month_calculated;
	private BigDecimal	r20_year_calculated;
	private BigDecimal	r20_total_asf;
	private String	r21_product;
	private BigDecimal	r21_month_amount;
	private BigDecimal	r21_6month_amount;
	private BigDecimal	r21_year_amount;
	private BigDecimal	r21_month_factor;
	private BigDecimal	r21_6month_factor;
	private BigDecimal	r21_year_factor;
	private BigDecimal	r21_month_calculated;
	private BigDecimal	r21_6month_calculated;
	private BigDecimal	r21_year_calculated;
	private BigDecimal	r21_total_asf;
	private String	r22_product;
	private BigDecimal	r22_month_amount;
	private BigDecimal	r22_6month_amount;
	private BigDecimal	r22_year_amount;
	private BigDecimal	r22_month_factor;
	private BigDecimal	r22_6month_factor;
	private BigDecimal	r22_year_factor;
	private BigDecimal	r22_month_calculated;
	private BigDecimal	r22_6month_calculated;
	private BigDecimal	r22_year_calculated;
	private BigDecimal	r22_total_asf;
	private String	r23_product;
	private BigDecimal	r23_month_amount;
	private BigDecimal	r23_6month_amount;
	private BigDecimal	r23_year_amount;
	private BigDecimal	r23_month_factor;
	private BigDecimal	r23_6month_factor;
	private BigDecimal	r23_year_factor;
	private BigDecimal	r23_month_calculated;
	private BigDecimal	r23_6month_calculated;
	private BigDecimal	r23_year_calculated;
	private BigDecimal	r23_total_asf;
	private String	r24_product;
	private BigDecimal	r24_month_amount;
	private BigDecimal	r24_6month_amount;
	private BigDecimal	r24_year_amount;
	private BigDecimal	r24_month_factor;
	private BigDecimal	r24_6month_factor;
	private BigDecimal	r24_year_factor;
	private BigDecimal	r24_month_calculated;
	private BigDecimal	r24_6month_calculated;
	private BigDecimal	r24_year_calculated;
	private BigDecimal	r24_total_asf;
	private String	r25_product;
	private BigDecimal	r25_month_amount;
	private BigDecimal	r25_6month_amount;
	private BigDecimal	r25_year_amount;
	private BigDecimal	r25_month_factor;
	private BigDecimal	r25_6month_factor;
	private BigDecimal	r25_year_factor;
	private BigDecimal	r25_month_calculated;
	private BigDecimal	r25_6month_calculated;
	private BigDecimal	r25_year_calculated;
	private BigDecimal	r25_total_asf;
	private String	r27_product;
	private BigDecimal	r27_month_amount;
	private BigDecimal	r27_6month_amount;
	private BigDecimal	r27_year_amount;
	private BigDecimal	r27_month_factor;
	private BigDecimal	r27_6month_factor;
	private BigDecimal	r27_year_factor;
	private BigDecimal	r27_month_calculated;
	private BigDecimal	r27_6month_calculated;
	private BigDecimal	r27_year_calculated;
	private BigDecimal	r27_total_asf;
	private String	r28_product;
	private BigDecimal	r28_month_amount;
	private BigDecimal	r28_6month_amount;
	private BigDecimal	r28_year_amount;
	private BigDecimal	r28_month_factor;
	private BigDecimal	r28_6month_factor;
	private BigDecimal	r28_year_factor;
	private BigDecimal	r28_month_calculated;
	private BigDecimal	r28_6month_calculated;
	private BigDecimal	r28_year_calculated;
	private BigDecimal	r28_total_asf;
	private String	r29_product;
	private BigDecimal	r29_month_amount;
	private BigDecimal	r29_6month_amount;
	private BigDecimal	r29_year_amount;
	private BigDecimal	r29_month_factor;
	private BigDecimal	r29_6month_factor;
	private BigDecimal	r29_year_factor;
	private String	r30_product;
	private BigDecimal	r30_month_amount;
	private BigDecimal	r30_6month_amount;
	private BigDecimal	r30_year_amount;
	private BigDecimal	r30_month_factor;
	private BigDecimal	r30_6month_factor;
	private BigDecimal	r30_year_factor;
	private BigDecimal	r30_month_calculated;
	private BigDecimal	r30_6month_calculated;
	private BigDecimal	r30_year_calculated;
	private BigDecimal	r30_total_asf;
	private String	r31_product;
	private BigDecimal	r31_month_amount;
	private BigDecimal	r31_6month_amount;
	private BigDecimal	r31_year_amount;
	private BigDecimal	r31_month_factor;
	private BigDecimal	r31_6month_factor;
	private BigDecimal	r31_year_factor;
	private BigDecimal	r31_month_calculated;
	private BigDecimal	r31_6month_calculated;
	private BigDecimal	r31_year_calculated;
	private BigDecimal	r31_total_asf;
	private String	r32_product;
	private BigDecimal	r32_month_amount;
	private BigDecimal	r32_6month_amount;
	private BigDecimal	r32_year_amount;
	private BigDecimal	r32_month_factor;
	private BigDecimal	r32_6month_factor;
	private BigDecimal	r32_year_factor;
	private BigDecimal	r32_month_calculated;
	private BigDecimal	r32_6month_calculated;
	private BigDecimal	r32_year_calculated;
	private BigDecimal	r32_total_asf;
	private String	r33_product;
	private BigDecimal	r33_month_amount;
	private BigDecimal	r33_6month_amount;
	private BigDecimal	r33_year_amount;
	private BigDecimal	r33_month_factor;
	private BigDecimal	r33_6month_factor;
	private BigDecimal	r33_year_factor;
	private BigDecimal	r33_month_calculated;
	private BigDecimal	r33_6month_calculated;
	private BigDecimal	r33_year_calculated;
	private BigDecimal	r33_total_asf;
	private String	r34_product;
	private BigDecimal	r34_month_amount;
	private BigDecimal	r34_6month_amount;
	private BigDecimal	r34_year_amount;
	private BigDecimal	r34_month_factor;
	private BigDecimal	r34_6month_factor;
	private BigDecimal	r34_year_factor;
	private BigDecimal	r34_month_calculated;
	private BigDecimal	r34_6month_calculated;
	private BigDecimal	r34_year_calculated;
	private BigDecimal	r34_total_asf;
	private String	r35_product;
	private BigDecimal	r35_month_amount;
	private BigDecimal	r35_6month_amount;
	private BigDecimal	r35_year_amount;
	private BigDecimal	r35_month_factor;
	private BigDecimal	r35_6month_factor;
	private BigDecimal	r35_year_factor;
	private BigDecimal	r35_month_calculated;
	private BigDecimal	r35_6month_calculated;
	private BigDecimal	r35_year_calculated;
	private BigDecimal	r35_total_asf;
	private String	r36_product;
	private BigDecimal	r36_month_amount;
	private BigDecimal	r36_6month_amount;
	private BigDecimal	r36_year_amount;
	private BigDecimal	r36_month_factor;
	private BigDecimal	r36_6month_factor;
	private BigDecimal	r36_year_factor;
	private BigDecimal	r36_month_calculated;
	private BigDecimal	r36_6month_calculated;
	private BigDecimal	r36_year_calculated;
	private BigDecimal	r36_total_asf;
	private String	r38_product;
	private BigDecimal	r38_year_amount;
	private String	r39_product;
	private BigDecimal	r39_year_amount;
	private String	r40_product;
	private BigDecimal	r40_year_amount;
	private BigDecimal	r40_year_factor;
	private BigDecimal	r40_year_calculated;
	private BigDecimal	r40_total_asf;
	private String	r41_product;
	private BigDecimal	r41_year_amount;
	private BigDecimal	r41_year_factor;
	private BigDecimal	r41_year_calculated;
	private BigDecimal	r41_total_asf;
	private String	r42_product;
	private BigDecimal	r42_year_amount;
	private BigDecimal	r42_year_factor;
	private BigDecimal	r42_year_calculated;
	private BigDecimal	r42_total_asf;
	private String	r44_product;
	private BigDecimal	r44_month_amount;
	private BigDecimal	r44_6month_amount;
	private BigDecimal	r44_year_amount;
	private BigDecimal	r44_month_factor;
	private BigDecimal	r44_6month_factor;
	private BigDecimal	r44_year_factor;
	private BigDecimal	r44_month_calculated;
	private BigDecimal	r44_6month_calculated;
	private BigDecimal	r44_year_calculated;
	private BigDecimal	r44_total_asf;
	private String	r45_product;
	private BigDecimal	r45_month_amount;
	private BigDecimal	r45_6month_amount;
	private BigDecimal	r45_year_amount;
	private BigDecimal	r45_month_factor;
	private BigDecimal	r45_6month_factor;
	private BigDecimal	r45_year_factor;
	private BigDecimal	r45_month_calculated;
	private BigDecimal	r45_6month_calculated;
	private BigDecimal	r45_year_calculated;
	private BigDecimal	r45_total_asf;
	private String	r46_product;
	private BigDecimal	r46_month_amount;
	private BigDecimal	r46_month_factor;
	private BigDecimal	r46_month_calculated;
	private BigDecimal	r46_total_asf;
	private String	r47_product;
	private BigDecimal	r47_month_amount;
	private BigDecimal	r47_6month_amount;
	private BigDecimal	r47_year_amount;
	private BigDecimal	r47_month_factor;
	private BigDecimal	r47_6month_factor;
	private BigDecimal	r47_year_factor;
	private BigDecimal	r47_month_calculated;
	private BigDecimal	r47_6month_calculated;
	private BigDecimal	r47_year_calculated;
	private BigDecimal	r47_total_asf;
	private String	r53_product;
	private BigDecimal	r53_month_amount;
	private BigDecimal	r53_month_factor;
	private BigDecimal	r53_month_calculated;
	private BigDecimal	r53_total_asf;
	private String	r55_product;
	private BigDecimal	r55_month_amount;
	private BigDecimal	r55_month_factor;
	private BigDecimal	r55_month_calculated;
	private BigDecimal	r55_total_asf;
	private String	r56_product;
	private BigDecimal	r56_month_amount;
	private BigDecimal	r56_month_factor;
	private BigDecimal	r56_month_calculated;
	private BigDecimal	r56_total_asf;
	private String	r57_product;
	private BigDecimal	r57_month_amount;
	private BigDecimal	r57_6month_amount;
	private BigDecimal	r57_year_amount;
	private BigDecimal	r57_month_factor;
	private BigDecimal	r57_6month_factor;
	private BigDecimal	r57_year_factor;
	private BigDecimal	r57_month_calculated;
	private BigDecimal	r57_6month_calculated;
	private BigDecimal	r57_year_calculated;
	private BigDecimal	r57_total_asf;
	private String	r58_product;
	private BigDecimal	r58_month_amount;
	private BigDecimal	r58_6month_amount;
	private BigDecimal	r58_year_amount;
	private BigDecimal	r58_month_factor;
	private BigDecimal	r58_6month_factor;
	private BigDecimal	r58_year_factor;
	private BigDecimal	r58_month_calculated;
	private BigDecimal	r58_6month_calculated;
	private BigDecimal	r58_year_calculated;
	private BigDecimal	r58_total_asf;
	private String	r59_product;
	private BigDecimal	r59_6month_factor;
	private BigDecimal	r59_year_factor;
	private BigDecimal	r59_6month_calculated;
	private BigDecimal	r59_year_calculated;
	private BigDecimal	r59_total_asf;
	private String	r60_product;
	private BigDecimal	r60_year_amount;
	private BigDecimal	r60_year_factor;
	private BigDecimal	r60_year_calculated;
	private BigDecimal	r60_total_asf;
	private String	r62_product;
	private BigDecimal	r62_month_amount;
	private BigDecimal	r62_6month_amount;
	private BigDecimal	r62_year_amount;
	private BigDecimal	r62_month_factor;
	private BigDecimal	r62_6month_factor;
	private BigDecimal	r62_year_factor;
	private BigDecimal	r62_month_calculated;
	private BigDecimal	r62_6month_calculated;
	private BigDecimal	r62_year_calculated;
	private BigDecimal	r62_total_asf;
	private String	r63_product;
	private BigDecimal	r63_month_amount;
	private BigDecimal	r63_month_factor;
	private BigDecimal	r63_month_calculated;
	private BigDecimal	r63_total_asf;
	private String	r64_product;
	private BigDecimal	r64_6month_amount;
	private BigDecimal	r64_6month_factor;
	private BigDecimal	r64_6month_calculated;
	private BigDecimal	r64_total_asf;
	private String	r65_product;
	private BigDecimal	r65_year_amount;
	private BigDecimal	r65_year_factor;
	private BigDecimal	r65_year_calculated;
	private BigDecimal	r65_total_asf;
	private String	r68_product;
	private BigDecimal	r68_month_amount;
	private BigDecimal	r68_6month_amount;
	private BigDecimal	r68_year_amount;
	private BigDecimal	r68_month_factor;
	private BigDecimal	r68_6month_factor;
	private BigDecimal	r68_year_factor;
	private BigDecimal	r68_month_calculated;
	private BigDecimal	r68_6month_calculated;
	private BigDecimal	r68_year_calculated;
	private BigDecimal	r68_total_asf;
	private String	r69_product;
	private BigDecimal	r69_month_amount;
	private BigDecimal	r69_month_factor;
	private BigDecimal	r69_month_calculated;
	private BigDecimal	r69_total_asf;
	private String	r70_product;
	private BigDecimal	r70_6month_amount;
	private BigDecimal	r70_6month_factor;
	private BigDecimal	r70_6month_calculated;
	private BigDecimal	r70_total_asf;
	private String	r71_product;
	private BigDecimal	r71_year_amount;
	private BigDecimal	r71_year_factor;
	private BigDecimal	r71_year_calculated;
	private BigDecimal	r71_total_asf;
	private String	r73_product;
	private BigDecimal	r73_month_amount;
	private BigDecimal	r73_6month_amount;
	private BigDecimal	r73_year_amount;
	private BigDecimal	r73_month_factor;
	private BigDecimal	r73_6month_factor;
	private BigDecimal	r73_year_factor;
	private BigDecimal	r73_month_calculated;
	private BigDecimal	r73_6month_calculated;
	private BigDecimal	r73_year_calculated;
	private BigDecimal	r73_total_asf;
	private String	r74_product;
	private BigDecimal	r74_month_amount;
	private BigDecimal	r74_month_factor;
	private BigDecimal	r74_month_calculated;
	private BigDecimal	r74_total_asf;
	private String	r75_product;
	private BigDecimal	r75_6month_amount;
	private BigDecimal	r75_6month_factor;
	private BigDecimal	r75_6month_calculated;
	private BigDecimal	r75_total_asf;
	private String	r76_product;
	private BigDecimal	r76_year_amount;
	private BigDecimal	r76_year_factor;
	private BigDecimal	r76_year_calculated;
	private BigDecimal	r76_total_asf;
	private String	r79_product;
	private BigDecimal	r79_month_amount;
	private BigDecimal	r79_6month_amount;
	private BigDecimal	r79_year_amount;
	private BigDecimal	r79_month_factor;
	private BigDecimal	r79_6month_factor;
	private BigDecimal	r79_year_factor;
	private BigDecimal	r79_month_calculated;
	private BigDecimal	r79_6month_calculated;
	private BigDecimal	r79_year_calculated;
	private BigDecimal	r79_total_asf;
	private String	r80_product;
	private BigDecimal	r80_month_amount;
	private BigDecimal	r80_month_factor;
	private BigDecimal	r80_month_calculated;
	private BigDecimal	r80_total_asf;
	private String	r81_product;
	private BigDecimal	r81_6month_amount;
	private BigDecimal	r81_6month_factor;
	private BigDecimal	r81_6month_calculated;
	private BigDecimal	r81_total_asf;
	private String	r82_product;
	private BigDecimal	r82_year_amount;
	private BigDecimal	r82_year_factor;
	private BigDecimal	r82_year_calculated;
	private BigDecimal	r82_total_asf;
	private String	r84_product;
	private BigDecimal	r84_year_factor;
	private BigDecimal	r84_year_calculated;
	private BigDecimal	r84_total_asf;
	private String	r85_product;
	private BigDecimal	r85_year_factor;
	private BigDecimal	r85_year_calculated;
	private BigDecimal	r85_total_asf;
	private String	r86_product;
	private BigDecimal	r86_year_factor;
	private BigDecimal	r86_year_calculated;
	private BigDecimal	r86_total_asf;
	private String	r87_product;
	private BigDecimal	r87_year_factor;
	private BigDecimal	r87_year_calculated;
	private BigDecimal	r87_total_asf;
	private String	r89_product;
	private BigDecimal	r89_month_amount;
	private BigDecimal	r89_6month_amount;
	private BigDecimal	r89_year_amount;
	private BigDecimal	r89_month_factor;
	private BigDecimal	r89_6month_factor;
	private BigDecimal	r89_year_factor;
	private BigDecimal	r89_month_calculated;
	private BigDecimal	r89_6month_calculated;
	private BigDecimal	r89_year_calculated;
	private BigDecimal	r89_total_asf;
	private String	r90_product;
	private BigDecimal	r90_month_amount;
	private BigDecimal	r90_month_factor;
	private BigDecimal	r90_month_calculated;
	private BigDecimal	r90_total_asf;
	private String	r91_product;
	private BigDecimal	r91_6month_amount;
	private BigDecimal	r91_6month_factor;
	private BigDecimal	r91_6month_calculated;
	private BigDecimal	r91_total_asf;
	private String	r93_product;
	private BigDecimal	r93_year_amount;
	private BigDecimal	r93_month_factor;
	private BigDecimal	r93_6month_factor;
	private BigDecimal	r93_year_factor;
	private BigDecimal	r93_month_calculated;
	private BigDecimal	r93_6month_calculated;
	private BigDecimal	r93_year_calculated;
	private BigDecimal	r93_total_asf;
	private String	r94_product;
	private BigDecimal	r94_month_amount;
	private BigDecimal	r94_6month_amount;
	private BigDecimal	r94_year_amount;
	private BigDecimal	r94_month_factor;
	private BigDecimal	r94_6month_factor;
	private BigDecimal	r94_year_factor;
	private BigDecimal	r94_month_calculated;
	private BigDecimal	r94_6month_calculated;
	private BigDecimal	r94_year_calculated;
	private BigDecimal	r94_total_asf;
	private String	r95_product;
	private BigDecimal	r95_6month_amount;
	private BigDecimal	r95_year_amount;
	private BigDecimal	r95_6month_factor;
	private BigDecimal	r95_year_factor;
	private BigDecimal	r95_6month_calculated;
	private BigDecimal	r95_year_calculated;
	private BigDecimal	r95_total_asf;
	private String	r96_product;
	private BigDecimal	r96_6month_amount;
	private BigDecimal	r96_year_amount;
	private BigDecimal	r96_6month_factor;
	private BigDecimal	r96_year_factor;
	private BigDecimal	r96_6month_calculated;
	private BigDecimal	r96_year_calculated;
	private BigDecimal	r96_total_asf;
	private String	r98_product;
	private BigDecimal	r98_months_amount;
	private BigDecimal	r98_6months_amount;
	private BigDecimal	r98_year_amount;
	private BigDecimal	r98_months_factor;
	private BigDecimal	r98_6months_factor;
	private BigDecimal	r98_year_factor;
	private BigDecimal	r98_months_calculated;
	private BigDecimal	r98_6months_calculated;
	private BigDecimal	r98_year_calculated;
	private BigDecimal	r98_total_asf;
	private String	r99_product;
	private BigDecimal	r99_month_amount;
	private BigDecimal	r99_6month_amount;
	private BigDecimal	r99_year_amount;
	private BigDecimal	r99_month_factor;
	private BigDecimal	r99_6month_factor;
	private BigDecimal	r99_year_factor;
	private BigDecimal	r99_month_calculated;
	private BigDecimal	r99_6month_calculated;
	private BigDecimal	r99_year_calculated;
	private BigDecimal	r99_total_asf;
	private String	r100_product;
	private BigDecimal	r100_6month_amount;
	private BigDecimal	r100_year_amount;
	private BigDecimal	r100_6month_factor;
	private BigDecimal	r100_year_factor;
	private BigDecimal	r100_6month_calculated;
	private BigDecimal	r100_year_calculated;
	private BigDecimal	r100_total_asf;
	private String	r101_product;
	private BigDecimal	r101_6month_amount;
	private BigDecimal	r101_year_amount;
	private BigDecimal	r101_6month_factor;
	private BigDecimal	r101_year_factor;
	private BigDecimal	r101_6month_calculated;
	private BigDecimal	r101_year_calculated;
	private BigDecimal	r101_total_asf;
	private String	r103_product;
	private BigDecimal	r103_months_amount;
	private BigDecimal	r103_6months_amount;
	private BigDecimal	r103_year_amount;
	private BigDecimal	r103_months_factor;
	private BigDecimal	r103_6months_factor;
	private BigDecimal	r103_year_factor;
	private BigDecimal	r103_months_calculated;
	private BigDecimal	r103_6months_calculated;
	private BigDecimal	r103_year_calculated;
	private BigDecimal	r103_total_asf;
	private String	r104_product;
	private BigDecimal	r104_month_amount;
	private BigDecimal	r104_6month_amount;
	private BigDecimal	r104_year_amount;
	private BigDecimal	r104_month_factor;
	private BigDecimal	r104_6month_factor;
	private BigDecimal	r104_year_factor;
	private BigDecimal	r104_month_calculated;
	private BigDecimal	r104_6month_calculated;
	private BigDecimal	r104_year_calculated;
	private BigDecimal	r104_total_asf;
	private String	r105_product;
	private BigDecimal	r105_6month_amount;
	private BigDecimal	r105_year_amount;
	private BigDecimal	r105_6month_factor;
	private BigDecimal	r105_year_factor;
	private BigDecimal	r105_6month_calculated;
	private BigDecimal	r105_year_calculated;
	private BigDecimal	r105_total_asf;
	private String	r106_product;
	private BigDecimal	r106_6month_amount;
	private BigDecimal	r106_year_amount;
	private BigDecimal	r106_6month_factor;
	private BigDecimal	r106_year_factor;
	private BigDecimal	r106_6month_calculated;
	private BigDecimal	r106_year_calculated;
	private BigDecimal	r106_total_asf;
	private String	r109_product;
	private BigDecimal	r109_month_amount;
	private BigDecimal	r109_6month_amount;
	private BigDecimal	r109_month_factor;
	private BigDecimal	r109_6month_factor;
	private BigDecimal	r109_month_calculated;
	private BigDecimal	r109_6month_calculated;
	private BigDecimal	r109_total_asf;
	private String	r110_product;
	private BigDecimal	r110_month_amount;
	private BigDecimal	r110_month_factor;
	private BigDecimal	r110_month_calculated;
	private BigDecimal	r110_total_asf;
	private String	r111_product;
	private BigDecimal	r111_6month_amount;
	private BigDecimal	r111_6month_factor;
	private BigDecimal	r111_6month_calculated;
	private BigDecimal	r111_total_asf;
	private String	r113_product;
	private BigDecimal	r113_month_amount;
	private BigDecimal	r113_6month_amount;
	private BigDecimal	r113_month_factor;
	private BigDecimal	r113_6month_factor;
	private BigDecimal	r113_month_calculated;
	private BigDecimal	r113_6month_calculated;
	private BigDecimal	r113_total_asf;
	private String	r114_product;
	private BigDecimal	r114_month_amount;
	private BigDecimal	r114_month_factor;
	private BigDecimal	r114_month_calculated;
	private BigDecimal	r114_total_asf;
	private String	r115_product;
	private BigDecimal	r115_6month_amount;
	private BigDecimal	r115_6month_factor;
	private BigDecimal	r115_6month_calculated;
	private BigDecimal	r115_total_asf;
	private String	r117_product;
	private BigDecimal	r117_month_amount;
	private BigDecimal	r117_6month_amount;
	private BigDecimal	r117_month_factor;
	private BigDecimal	r117_6month_factor;
	private BigDecimal	r117_month_calculated;
	private BigDecimal	r117_6month_calculated;
	private BigDecimal	r117_total_asf;
	private String	r118_product;
	private BigDecimal	r118_month_amount;
	private BigDecimal	r118_month_factor;
	private BigDecimal	r118_month_calculated;
	private BigDecimal	r118_total_asf;
	private String	r119_product;
	private BigDecimal	r119_6month_amount;
	private BigDecimal	r119_6month_factor;
	private BigDecimal	r119_6month_calculated;
	private BigDecimal	r119_total_asf;
	private String	r122_product;
	private BigDecimal	r122_year_amount;
	private BigDecimal	r122_year_factor;
	private BigDecimal	r122_year_calculated;
	private BigDecimal	r122_total_asf;
	private String	r123_product;
	private BigDecimal	r123_month_amount;
	private BigDecimal	r123_month_factor;
	private BigDecimal	r123_month_calculated;
	private BigDecimal	r123_total_asf;
	private String	r124_product;
	private BigDecimal	r124_6month_amount;
	private BigDecimal	r124_6month_factor;
	private BigDecimal	r124_6month_calculated;
	private BigDecimal	r124_total_asf;
	private String	r125_product;
	private BigDecimal	r125_year_amount;
	private BigDecimal	r125_year_factor;
	private BigDecimal	r125_year_calculated;
	private BigDecimal	r125_total_asf;
	private String	r127_product;
	private BigDecimal	r127_year_amount;
	private BigDecimal	r127_year_factor;
	private BigDecimal	r127_year_calculated;
	private BigDecimal	r127_total_asf;
	private String	r128_product;
	private BigDecimal	r128_month_amount;
	private BigDecimal	r128_month_factor;
	private BigDecimal	r128_month_calculated;
	private BigDecimal	r128_total_asf;
	private String	r129_product;
	private BigDecimal	r129_6month_amount;
	private BigDecimal	r129_6month_factor;
	private BigDecimal	r129_6month_calculated;
	private BigDecimal	r129_total_asf;
	private String	r130_product;
	private BigDecimal	r130_year_amount;
	private BigDecimal	r130_year_factor;
	private BigDecimal	r130_year_calculated;
	private BigDecimal	r130_total_asf;
	private String	r132_product;
	private BigDecimal	r132_year_amount;
	private BigDecimal	r132_year_factor;
	private BigDecimal	r132_year_calculated;
	private BigDecimal	r132_total_asf;
	private String	r133_product;
	private BigDecimal	r133_month_amount;
	private BigDecimal	r133_month_factor;
	private BigDecimal	r133_month_calculated;
	private BigDecimal	r133_total_asf;
	private String	r134_product;
	private BigDecimal	r134_6month_amount;
	private BigDecimal	r134_6month_factor;
	private BigDecimal	r134_6month_calculated;
	private BigDecimal	r134_total_asf;
	private String	r135_product;
	private BigDecimal	r135_year_amount;
	private BigDecimal	r135_year_factor;
	private BigDecimal	r135_year_calculated;
	private BigDecimal	r135_total_asf;
	private String	r137_product;
	private BigDecimal	r137_year_amount;
	private BigDecimal	r137_year_factor;
	private BigDecimal	r137_year_calculated;
	private BigDecimal	r137_total_asf;
	private String	r138_product;
	private BigDecimal	r138_month_amount;
	private BigDecimal	r138_month_factor;
	private BigDecimal	r138_month_calculated;
	private BigDecimal	r138_total_asf;
	private String	r139_product;
	private BigDecimal	r139_6month_amount;
	private BigDecimal	r139_6month_factor;
	private BigDecimal	r139_6month_calculated;
	private BigDecimal	r139_total_asf;
	private String	r140_product;
	private BigDecimal	r140_year_amount;
	private BigDecimal	r140_year_factor;
	private BigDecimal	r140_year_calculated;
	private BigDecimal	r140_total_asf;
	private String	r142_product;
	private BigDecimal	r142_year_amount;
	private BigDecimal	r142_year_factor;
	private BigDecimal	r142_year_calculated;
	private BigDecimal	r142_total_asf;
	private String	r143_product;
	private BigDecimal	r143_month_amount;
	private BigDecimal	r143_month_factor;
	private BigDecimal	r143_month_calculated;
	private BigDecimal	r143_total_asf;
	private String	r144_product;
	private BigDecimal	r144_6month_amount;
	private BigDecimal	r144_6month_factor;
	private BigDecimal	r144_6month_calculated;
	private BigDecimal	r144_total_asf;
	private String	r145_product;
	private BigDecimal	r145_year_amount;
	private BigDecimal	r145_year_factor;
	private BigDecimal	r145_year_calculated;
	private BigDecimal	r145_total_asf;
	private String	r147_product;
	private BigDecimal	r147_year_amount;
	private String	r148_product;
	private BigDecimal	r148_year_amount;
	private String	r149_product;
	private BigDecimal	r149_year_amount;
	private BigDecimal	r149_year_factor;
	private BigDecimal	r149_year_calculated;
	private BigDecimal	r149_total_asf;
	private String	r150_product;
	private BigDecimal	r150_year_amount;
	private BigDecimal	r150_year_factor;
	private BigDecimal	r150_year_calculated;
	private BigDecimal	r150_total_asf;
	private String	r151_product;
	private BigDecimal	r151_months_amount;
	private BigDecimal	r151_6months_amount;
	private BigDecimal	r151_year_amount;
	private BigDecimal	r151_months_factor;
	private BigDecimal	r151_6months_factor;
	private BigDecimal	r151_year_factor;
	private BigDecimal	r151_months_calculated;
	private BigDecimal	r151_6months_calculated;
	private BigDecimal	r151_year_calculated;
	private BigDecimal	r151_total_asf;
	private String	r152_product;
	private BigDecimal	r152_year_amount;
	private String	r153_product;
	private BigDecimal	r153_year_amount;
	private BigDecimal	r153_year_factor;
	private BigDecimal	r153_year_calculated;
	private BigDecimal	r153_total_asf;
	private String	r155_product;
	private BigDecimal	r155_month_amount;
	private BigDecimal	r155_month_factor;
	private BigDecimal	r155_month_calculated;
	private BigDecimal	r155_total_asf;
	private String	r156_product;
	private BigDecimal	r156_months_amount;
	private BigDecimal	r156_6months_amount;
	private BigDecimal	r156_year_amount;
	private BigDecimal	r156_months_factor;
	private BigDecimal	r156_6months_factor;
	private BigDecimal	r156_year_factor;
	private BigDecimal	r156_months_calculated;
	private BigDecimal	r156_6months_calculated;
	private BigDecimal	r156_year_calculated;
	private BigDecimal	r156_total_asf;
	private String	r157_product;
	private BigDecimal	r157_months_amount;
	private BigDecimal	r157_6months_amount;
	private BigDecimal	r157_year_amount;
	private BigDecimal	r157_months_factor;
	private BigDecimal	r157_6months_factor;
	private BigDecimal	r157_year_factor;
	private BigDecimal	r157_months_calculated;
	private BigDecimal	r157_6months_calculated;
	private BigDecimal	r157_year_calculated;
	private BigDecimal	r157_total_asf;
	private String	r158_product;
	private BigDecimal	r158_months_amount;
	private BigDecimal	r158_6months_amount;
	private BigDecimal	r158_year_amount;
	private BigDecimal	r158_months_factor;
	private BigDecimal	r158_6months_factor;
	private BigDecimal	r158_year_factor;
	private BigDecimal	r158_months_calculated;
	private BigDecimal	r158_6months_calculated;
	private BigDecimal	r158_year_calculated;
	private BigDecimal	r158_total_asf;
	private String	r159_product;
	private BigDecimal	r159_months_amount;
	private BigDecimal	r159_6months_amount;
	private BigDecimal	r159_year_amount;
	private BigDecimal	r159_months_factor;
	private BigDecimal	r159_6months_factor;
	private BigDecimal	r159_year_factor;
	private BigDecimal	r159_months_calculated;
	private BigDecimal	r159_6months_calculated;
	private BigDecimal	r159_year_calculated;
	private BigDecimal	r159_total_asf;
	private String	r160_product;
	private BigDecimal	r160_months_amount;
	private BigDecimal	r160_6months_amount;
	private BigDecimal	r160_year_amount;
	private BigDecimal	r160_months_factor;
	private BigDecimal	r160_6months_factor;
	private BigDecimal	r160_year_factor;
	private BigDecimal	r160_months_calculated;
	private BigDecimal	r160_6months_calculated;
	private BigDecimal	r160_year_calculated;
	private BigDecimal	r160_total_asf;
	private String	r161_product;
	private BigDecimal	r161_months_amount;
	private BigDecimal	r161_6months_amount;
	private BigDecimal	r161_year_amount;
	private BigDecimal	r161_months_factor;
	private BigDecimal	r161_6months_factor;
	private BigDecimal	r161_year_factor;
	private BigDecimal	r161_months_calculated;
	private BigDecimal	r161_6months_calculated;
	private BigDecimal	r161_year_calculated;
	private BigDecimal	r161_total_asf;
	private String	r162_product;
	private BigDecimal	r162_months_amount;
	private BigDecimal	r162_6months_amount;
	private BigDecimal	r162_year_amount;
	private BigDecimal	r162_months_factor;
	private BigDecimal	r162_6months_factor;
	private BigDecimal	r162_year_factor;
	private BigDecimal	r162_months_calculated;
	private BigDecimal	r162_6months_calculated;
	private BigDecimal	r162_year_calculated;
	private BigDecimal	r162_total_asf;
	private String	r163_product;
	private BigDecimal	r163_months_amount;
	private BigDecimal	r163_6months_amount;
	private BigDecimal	r163_year_amount;
	private BigDecimal	r163_months_factor;
	private BigDecimal	r163_6months_factor;
	private BigDecimal	r163_year_factor;
	private BigDecimal	r163_months_calculated;
	private BigDecimal	r163_6months_calculated;
	private BigDecimal	r163_year_calculated;
	private BigDecimal	r163_total_asf;
	private String	r165_product;
	private BigDecimal	r165_amount;
	private BigDecimal	r165_rfs_factor;
	private BigDecimal	r165_total_asf;
	private String	r166_product;
	private BigDecimal	r166_amount;
	private BigDecimal	r166_rfs_factor;
	private BigDecimal	r166_total_asf;
	private String	r167_product;
	private BigDecimal	r167_amount;
	private BigDecimal	r167_rfs_factor;
	private BigDecimal	r167_total_asf;
	private String	r168_product;
	private BigDecimal	r168_amount;
	private BigDecimal	r168_rfs_factor;
	private BigDecimal	r168_total_asf;
	private String	r169_product;
	private BigDecimal	r169_amount;
	private BigDecimal	r169_rfs_factor;
	private BigDecimal	r169_total_asf;
	private String	r170_product;
	private String	r170_total_asf;
	private BigDecimal	r170_total_rsf;
	private String	r171_product;
	private String	r171_nsfr;
	private BigDecimal	r171_total_asf;
	private String	r174_product;
	private BigDecimal	r174_months_amount;
	private BigDecimal	r174_6months_amount;
	private BigDecimal	r174_year_amount;
	private BigDecimal	r174_months_factor;
	private BigDecimal	r174_6months_factor;
	private BigDecimal	r174_year_factor;
	private BigDecimal	r174_months_calculated;
	private BigDecimal	r174_6months_calculated;
	private BigDecimal	r174_year_calculated;
	private BigDecimal	r174_total_asf;
	private String	r175_nsfr;
	private BigDecimal	r175_total_asf;
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
	private String	r48_product;
	private BigDecimal	r48_total_asp;
	private BigDecimal	r59_year_amount;
	private BigDecimal	r59_6month_amount;
	private BigDecimal	r84_year_amount;
	private BigDecimal	r85_year_amount;
	private BigDecimal	r86_year_amount;
	private BigDecimal	r87_year_amount;
	private BigDecimal	r93_month_amount;
	private BigDecimal	r93_6month_amount;
	private BigDecimal	r29_month_calculated;
	private BigDecimal	r29_6month_calculated;
	private BigDecimal	r29_year_calculated;
	private BigDecimal	r29_total_asf;
	private String	repdesc;
	private String	frequency;
	public String getR10_product() {
		return r10_product;
	}
	public void setR10_product(String r10_product) {
		this.r10_product = r10_product;
	}
	public BigDecimal getR10_year_amount() {
		return r10_year_amount;
	}
	public void setR10_year_amount(BigDecimal r10_year_amount) {
		this.r10_year_amount = r10_year_amount;
	}
	public BigDecimal getR10_year_factor() {
		return r10_year_factor;
	}
	public void setR10_year_factor(BigDecimal r10_year_factor) {
		this.r10_year_factor = r10_year_factor;
	}
	public BigDecimal getR10_year_calculated() {
		return r10_year_calculated;
	}
	public void setR10_year_calculated(BigDecimal r10_year_calculated) {
		this.r10_year_calculated = r10_year_calculated;
	}
	public BigDecimal getR10_total_asf() {
		return r10_total_asf;
	}
	public void setR10_total_asf(BigDecimal r10_total_asf) {
		this.r10_total_asf = r10_total_asf;
	}
	public String getR11_product() {
		return r11_product;
	}
	public void setR11_product(String r11_product) {
		this.r11_product = r11_product;
	}
	public BigDecimal getR11_year_amount() {
		return r11_year_amount;
	}
	public void setR11_year_amount(BigDecimal r11_year_amount) {
		this.r11_year_amount = r11_year_amount;
	}
	public BigDecimal getR11_year_factor() {
		return r11_year_factor;
	}
	public void setR11_year_factor(BigDecimal r11_year_factor) {
		this.r11_year_factor = r11_year_factor;
	}
	public BigDecimal getR11_year_calculated() {
		return r11_year_calculated;
	}
	public void setR11_year_calculated(BigDecimal r11_year_calculated) {
		this.r11_year_calculated = r11_year_calculated;
	}
	public BigDecimal getR11_total_asf() {
		return r11_total_asf;
	}
	public void setR11_total_asf(BigDecimal r11_total_asf) {
		this.r11_total_asf = r11_total_asf;
	}
	public String getR13_product() {
		return r13_product;
	}
	public void setR13_product(String r13_product) {
		this.r13_product = r13_product;
	}
	public BigDecimal getR13_month_amount() {
		return r13_month_amount;
	}
	public void setR13_month_amount(BigDecimal r13_month_amount) {
		this.r13_month_amount = r13_month_amount;
	}
	public BigDecimal getR13_6month_amount() {
		return r13_6month_amount;
	}
	public void setR13_6month_amount(BigDecimal r13_6month_amount) {
		this.r13_6month_amount = r13_6month_amount;
	}
	public BigDecimal getR13_year_amount() {
		return r13_year_amount;
	}
	public void setR13_year_amount(BigDecimal r13_year_amount) {
		this.r13_year_amount = r13_year_amount;
	}
	public BigDecimal getR13_month_factor() {
		return r13_month_factor;
	}
	public void setR13_month_factor(BigDecimal r13_month_factor) {
		this.r13_month_factor = r13_month_factor;
	}
	public BigDecimal getR13_6month_factor() {
		return r13_6month_factor;
	}
	public void setR13_6month_factor(BigDecimal r13_6month_factor) {
		this.r13_6month_factor = r13_6month_factor;
	}
	public BigDecimal getR13_year_factor() {
		return r13_year_factor;
	}
	public void setR13_year_factor(BigDecimal r13_year_factor) {
		this.r13_year_factor = r13_year_factor;
	}
	public BigDecimal getR13_month_calculated() {
		return r13_month_calculated;
	}
	public void setR13_month_calculated(BigDecimal r13_month_calculated) {
		this.r13_month_calculated = r13_month_calculated;
	}
	public BigDecimal getR13_6month_calculated() {
		return r13_6month_calculated;
	}
	public void setR13_6month_calculated(BigDecimal r13_6month_calculated) {
		this.r13_6month_calculated = r13_6month_calculated;
	}
	public BigDecimal getR13_year_calculated() {
		return r13_year_calculated;
	}
	public void setR13_year_calculated(BigDecimal r13_year_calculated) {
		this.r13_year_calculated = r13_year_calculated;
	}
	public BigDecimal getR13_total_asf() {
		return r13_total_asf;
	}
	public void setR13_total_asf(BigDecimal r13_total_asf) {
		this.r13_total_asf = r13_total_asf;
	}
	public String getR14_product() {
		return r14_product;
	}
	public void setR14_product(String r14_product) {
		this.r14_product = r14_product;
	}
	public BigDecimal getR14_month_amount() {
		return r14_month_amount;
	}
	public void setR14_month_amount(BigDecimal r14_month_amount) {
		this.r14_month_amount = r14_month_amount;
	}
	public BigDecimal getR14_6month_amount() {
		return r14_6month_amount;
	}
	public void setR14_6month_amount(BigDecimal r14_6month_amount) {
		this.r14_6month_amount = r14_6month_amount;
	}
	public BigDecimal getR14_year_amount() {
		return r14_year_amount;
	}
	public void setR14_year_amount(BigDecimal r14_year_amount) {
		this.r14_year_amount = r14_year_amount;
	}
	public BigDecimal getR14_month_factor() {
		return r14_month_factor;
	}
	public void setR14_month_factor(BigDecimal r14_month_factor) {
		this.r14_month_factor = r14_month_factor;
	}
	public BigDecimal getR14_6month_factor() {
		return r14_6month_factor;
	}
	public void setR14_6month_factor(BigDecimal r14_6month_factor) {
		this.r14_6month_factor = r14_6month_factor;
	}
	public BigDecimal getR14_year_factor() {
		return r14_year_factor;
	}
	public void setR14_year_factor(BigDecimal r14_year_factor) {
		this.r14_year_factor = r14_year_factor;
	}
	public BigDecimal getR14_month_calculated() {
		return r14_month_calculated;
	}
	public void setR14_month_calculated(BigDecimal r14_month_calculated) {
		this.r14_month_calculated = r14_month_calculated;
	}
	public BigDecimal getR14_6month_calculated() {
		return r14_6month_calculated;
	}
	public void setR14_6month_calculated(BigDecimal r14_6month_calculated) {
		this.r14_6month_calculated = r14_6month_calculated;
	}
	public BigDecimal getR14_year_calculated() {
		return r14_year_calculated;
	}
	public void setR14_year_calculated(BigDecimal r14_year_calculated) {
		this.r14_year_calculated = r14_year_calculated;
	}
	public BigDecimal getR14_total_asf() {
		return r14_total_asf;
	}
	public void setR14_total_asf(BigDecimal r14_total_asf) {
		this.r14_total_asf = r14_total_asf;
	}
	public String getR15_product() {
		return r15_product;
	}
	public void setR15_product(String r15_product) {
		this.r15_product = r15_product;
	}
	public BigDecimal getR15_month_amount() {
		return r15_month_amount;
	}
	public void setR15_month_amount(BigDecimal r15_month_amount) {
		this.r15_month_amount = r15_month_amount;
	}
	public BigDecimal getR15_6month_amount() {
		return r15_6month_amount;
	}
	public void setR15_6month_amount(BigDecimal r15_6month_amount) {
		this.r15_6month_amount = r15_6month_amount;
	}
	public BigDecimal getR15_year_amount() {
		return r15_year_amount;
	}
	public void setR15_year_amount(BigDecimal r15_year_amount) {
		this.r15_year_amount = r15_year_amount;
	}
	public BigDecimal getR15_month_factor() {
		return r15_month_factor;
	}
	public void setR15_month_factor(BigDecimal r15_month_factor) {
		this.r15_month_factor = r15_month_factor;
	}
	public BigDecimal getR15_6month_factor() {
		return r15_6month_factor;
	}
	public void setR15_6month_factor(BigDecimal r15_6month_factor) {
		this.r15_6month_factor = r15_6month_factor;
	}
	public BigDecimal getR15_year_factor() {
		return r15_year_factor;
	}
	public void setR15_year_factor(BigDecimal r15_year_factor) {
		this.r15_year_factor = r15_year_factor;
	}
	public BigDecimal getR15_month_calculated() {
		return r15_month_calculated;
	}
	public void setR15_month_calculated(BigDecimal r15_month_calculated) {
		this.r15_month_calculated = r15_month_calculated;
	}
	public BigDecimal getR15_6month_calculated() {
		return r15_6month_calculated;
	}
	public void setR15_6month_calculated(BigDecimal r15_6month_calculated) {
		this.r15_6month_calculated = r15_6month_calculated;
	}
	public BigDecimal getR15_year_calculated() {
		return r15_year_calculated;
	}
	public void setR15_year_calculated(BigDecimal r15_year_calculated) {
		this.r15_year_calculated = r15_year_calculated;
	}
	public BigDecimal getR15_total_asf() {
		return r15_total_asf;
	}
	public void setR15_total_asf(BigDecimal r15_total_asf) {
		this.r15_total_asf = r15_total_asf;
	}
	public String getR17_product() {
		return r17_product;
	}
	public void setR17_product(String r17_product) {
		this.r17_product = r17_product;
	}
	public BigDecimal getR17_month_amount() {
		return r17_month_amount;
	}
	public void setR17_month_amount(BigDecimal r17_month_amount) {
		this.r17_month_amount = r17_month_amount;
	}
	public BigDecimal getR17_6month_amount() {
		return r17_6month_amount;
	}
	public void setR17_6month_amount(BigDecimal r17_6month_amount) {
		this.r17_6month_amount = r17_6month_amount;
	}
	public BigDecimal getR17_year_amount() {
		return r17_year_amount;
	}
	public void setR17_year_amount(BigDecimal r17_year_amount) {
		this.r17_year_amount = r17_year_amount;
	}
	public BigDecimal getR17_month_factor() {
		return r17_month_factor;
	}
	public void setR17_month_factor(BigDecimal r17_month_factor) {
		this.r17_month_factor = r17_month_factor;
	}
	public BigDecimal getR17_6month_factor() {
		return r17_6month_factor;
	}
	public void setR17_6month_factor(BigDecimal r17_6month_factor) {
		this.r17_6month_factor = r17_6month_factor;
	}
	public BigDecimal getR17_year_factor() {
		return r17_year_factor;
	}
	public void setR17_year_factor(BigDecimal r17_year_factor) {
		this.r17_year_factor = r17_year_factor;
	}
	public BigDecimal getR17_month_calculated() {
		return r17_month_calculated;
	}
	public void setR17_month_calculated(BigDecimal r17_month_calculated) {
		this.r17_month_calculated = r17_month_calculated;
	}
	public BigDecimal getR17_6month_calculated() {
		return r17_6month_calculated;
	}
	public void setR17_6month_calculated(BigDecimal r17_6month_calculated) {
		this.r17_6month_calculated = r17_6month_calculated;
	}
	public BigDecimal getR17_year_calculated() {
		return r17_year_calculated;
	}
	public void setR17_year_calculated(BigDecimal r17_year_calculated) {
		this.r17_year_calculated = r17_year_calculated;
	}
	public BigDecimal getR17_total_asf() {
		return r17_total_asf;
	}
	public void setR17_total_asf(BigDecimal r17_total_asf) {
		this.r17_total_asf = r17_total_asf;
	}
	public String getR18_product() {
		return r18_product;
	}
	public void setR18_product(String r18_product) {
		this.r18_product = r18_product;
	}
	public BigDecimal getR18_month_amount() {
		return r18_month_amount;
	}
	public void setR18_month_amount(BigDecimal r18_month_amount) {
		this.r18_month_amount = r18_month_amount;
	}
	public BigDecimal getR18_6month_amount() {
		return r18_6month_amount;
	}
	public void setR18_6month_amount(BigDecimal r18_6month_amount) {
		this.r18_6month_amount = r18_6month_amount;
	}
	public BigDecimal getR18_year_amount() {
		return r18_year_amount;
	}
	public void setR18_year_amount(BigDecimal r18_year_amount) {
		this.r18_year_amount = r18_year_amount;
	}
	public BigDecimal getR18_month_factor() {
		return r18_month_factor;
	}
	public void setR18_month_factor(BigDecimal r18_month_factor) {
		this.r18_month_factor = r18_month_factor;
	}
	public BigDecimal getR18_6month_factor() {
		return r18_6month_factor;
	}
	public void setR18_6month_factor(BigDecimal r18_6month_factor) {
		this.r18_6month_factor = r18_6month_factor;
	}
	public BigDecimal getR18_year_factor() {
		return r18_year_factor;
	}
	public void setR18_year_factor(BigDecimal r18_year_factor) {
		this.r18_year_factor = r18_year_factor;
	}
	public BigDecimal getR18_month_calculated() {
		return r18_month_calculated;
	}
	public void setR18_month_calculated(BigDecimal r18_month_calculated) {
		this.r18_month_calculated = r18_month_calculated;
	}
	public BigDecimal getR18_6month_calculated() {
		return r18_6month_calculated;
	}
	public void setR18_6month_calculated(BigDecimal r18_6month_calculated) {
		this.r18_6month_calculated = r18_6month_calculated;
	}
	public BigDecimal getR18_year_calculated() {
		return r18_year_calculated;
	}
	public void setR18_year_calculated(BigDecimal r18_year_calculated) {
		this.r18_year_calculated = r18_year_calculated;
	}
	public BigDecimal getR18_total_asf() {
		return r18_total_asf;
	}
	public void setR18_total_asf(BigDecimal r18_total_asf) {
		this.r18_total_asf = r18_total_asf;
	}
	public String getR19_product() {
		return r19_product;
	}
	public void setR19_product(String r19_product) {
		this.r19_product = r19_product;
	}
	public BigDecimal getR19_month_amount() {
		return r19_month_amount;
	}
	public void setR19_month_amount(BigDecimal r19_month_amount) {
		this.r19_month_amount = r19_month_amount;
	}
	public BigDecimal getR19_6month_amount() {
		return r19_6month_amount;
	}
	public void setR19_6month_amount(BigDecimal r19_6month_amount) {
		this.r19_6month_amount = r19_6month_amount;
	}
	public BigDecimal getR19_year_amount() {
		return r19_year_amount;
	}
	public void setR19_year_amount(BigDecimal r19_year_amount) {
		this.r19_year_amount = r19_year_amount;
	}
	public BigDecimal getR19_month_factor() {
		return r19_month_factor;
	}
	public void setR19_month_factor(BigDecimal r19_month_factor) {
		this.r19_month_factor = r19_month_factor;
	}
	public BigDecimal getR19_6month_factor() {
		return r19_6month_factor;
	}
	public void setR19_6month_factor(BigDecimal r19_6month_factor) {
		this.r19_6month_factor = r19_6month_factor;
	}
	public BigDecimal getR19_year_factor() {
		return r19_year_factor;
	}
	public void setR19_year_factor(BigDecimal r19_year_factor) {
		this.r19_year_factor = r19_year_factor;
	}
	public BigDecimal getR19_month_calculated() {
		return r19_month_calculated;
	}
	public void setR19_month_calculated(BigDecimal r19_month_calculated) {
		this.r19_month_calculated = r19_month_calculated;
	}
	public BigDecimal getR19_6month_calculated() {
		return r19_6month_calculated;
	}
	public void setR19_6month_calculated(BigDecimal r19_6month_calculated) {
		this.r19_6month_calculated = r19_6month_calculated;
	}
	public BigDecimal getR19_year_calculated() {
		return r19_year_calculated;
	}
	public void setR19_year_calculated(BigDecimal r19_year_calculated) {
		this.r19_year_calculated = r19_year_calculated;
	}
	public BigDecimal getR19_total_asf() {
		return r19_total_asf;
	}
	public void setR19_total_asf(BigDecimal r19_total_asf) {
		this.r19_total_asf = r19_total_asf;
	}
	public String getR20_product() {
		return r20_product;
	}
	public void setR20_product(String r20_product) {
		this.r20_product = r20_product;
	}
	public BigDecimal getR20_month_amount() {
		return r20_month_amount;
	}
	public void setR20_month_amount(BigDecimal r20_month_amount) {
		this.r20_month_amount = r20_month_amount;
	}
	public BigDecimal getR20_6month_amount() {
		return r20_6month_amount;
	}
	public void setR20_6month_amount(BigDecimal r20_6month_amount) {
		this.r20_6month_amount = r20_6month_amount;
	}
	public BigDecimal getR20_year_amount() {
		return r20_year_amount;
	}
	public void setR20_year_amount(BigDecimal r20_year_amount) {
		this.r20_year_amount = r20_year_amount;
	}
	public BigDecimal getR20_month_factor() {
		return r20_month_factor;
	}
	public void setR20_month_factor(BigDecimal r20_month_factor) {
		this.r20_month_factor = r20_month_factor;
	}
	public BigDecimal getR20_6month_factor() {
		return r20_6month_factor;
	}
	public void setR20_6month_factor(BigDecimal r20_6month_factor) {
		this.r20_6month_factor = r20_6month_factor;
	}
	public BigDecimal getR20_year_factor() {
		return r20_year_factor;
	}
	public void setR20_year_factor(BigDecimal r20_year_factor) {
		this.r20_year_factor = r20_year_factor;
	}
	public BigDecimal getR20_month_calculated() {
		return r20_month_calculated;
	}
	public void setR20_month_calculated(BigDecimal r20_month_calculated) {
		this.r20_month_calculated = r20_month_calculated;
	}
	public BigDecimal getR20_6month_calculated() {
		return r20_6month_calculated;
	}
	public void setR20_6month_calculated(BigDecimal r20_6month_calculated) {
		this.r20_6month_calculated = r20_6month_calculated;
	}
	public BigDecimal getR20_year_calculated() {
		return r20_year_calculated;
	}
	public void setR20_year_calculated(BigDecimal r20_year_calculated) {
		this.r20_year_calculated = r20_year_calculated;
	}
	public BigDecimal getR20_total_asf() {
		return r20_total_asf;
	}
	public void setR20_total_asf(BigDecimal r20_total_asf) {
		this.r20_total_asf = r20_total_asf;
	}
	public String getR21_product() {
		return r21_product;
	}
	public void setR21_product(String r21_product) {
		this.r21_product = r21_product;
	}
	public BigDecimal getR21_month_amount() {
		return r21_month_amount;
	}
	public void setR21_month_amount(BigDecimal r21_month_amount) {
		this.r21_month_amount = r21_month_amount;
	}
	public BigDecimal getR21_6month_amount() {
		return r21_6month_amount;
	}
	public void setR21_6month_amount(BigDecimal r21_6month_amount) {
		this.r21_6month_amount = r21_6month_amount;
	}
	public BigDecimal getR21_year_amount() {
		return r21_year_amount;
	}
	public void setR21_year_amount(BigDecimal r21_year_amount) {
		this.r21_year_amount = r21_year_amount;
	}
	public BigDecimal getR21_month_factor() {
		return r21_month_factor;
	}
	public void setR21_month_factor(BigDecimal r21_month_factor) {
		this.r21_month_factor = r21_month_factor;
	}
	public BigDecimal getR21_6month_factor() {
		return r21_6month_factor;
	}
	public void setR21_6month_factor(BigDecimal r21_6month_factor) {
		this.r21_6month_factor = r21_6month_factor;
	}
	public BigDecimal getR21_year_factor() {
		return r21_year_factor;
	}
	public void setR21_year_factor(BigDecimal r21_year_factor) {
		this.r21_year_factor = r21_year_factor;
	}
	public BigDecimal getR21_month_calculated() {
		return r21_month_calculated;
	}
	public void setR21_month_calculated(BigDecimal r21_month_calculated) {
		this.r21_month_calculated = r21_month_calculated;
	}
	public BigDecimal getR21_6month_calculated() {
		return r21_6month_calculated;
	}
	public void setR21_6month_calculated(BigDecimal r21_6month_calculated) {
		this.r21_6month_calculated = r21_6month_calculated;
	}
	public BigDecimal getR21_year_calculated() {
		return r21_year_calculated;
	}
	public void setR21_year_calculated(BigDecimal r21_year_calculated) {
		this.r21_year_calculated = r21_year_calculated;
	}
	public BigDecimal getR21_total_asf() {
		return r21_total_asf;
	}
	public void setR21_total_asf(BigDecimal r21_total_asf) {
		this.r21_total_asf = r21_total_asf;
	}
	public String getR22_product() {
		return r22_product;
	}
	public void setR22_product(String r22_product) {
		this.r22_product = r22_product;
	}
	public BigDecimal getR22_month_amount() {
		return r22_month_amount;
	}
	public void setR22_month_amount(BigDecimal r22_month_amount) {
		this.r22_month_amount = r22_month_amount;
	}
	public BigDecimal getR22_6month_amount() {
		return r22_6month_amount;
	}
	public void setR22_6month_amount(BigDecimal r22_6month_amount) {
		this.r22_6month_amount = r22_6month_amount;
	}
	public BigDecimal getR22_year_amount() {
		return r22_year_amount;
	}
	public void setR22_year_amount(BigDecimal r22_year_amount) {
		this.r22_year_amount = r22_year_amount;
	}
	public BigDecimal getR22_month_factor() {
		return r22_month_factor;
	}
	public void setR22_month_factor(BigDecimal r22_month_factor) {
		this.r22_month_factor = r22_month_factor;
	}
	public BigDecimal getR22_6month_factor() {
		return r22_6month_factor;
	}
	public void setR22_6month_factor(BigDecimal r22_6month_factor) {
		this.r22_6month_factor = r22_6month_factor;
	}
	public BigDecimal getR22_year_factor() {
		return r22_year_factor;
	}
	public void setR22_year_factor(BigDecimal r22_year_factor) {
		this.r22_year_factor = r22_year_factor;
	}
	public BigDecimal getR22_month_calculated() {
		return r22_month_calculated;
	}
	public void setR22_month_calculated(BigDecimal r22_month_calculated) {
		this.r22_month_calculated = r22_month_calculated;
	}
	public BigDecimal getR22_6month_calculated() {
		return r22_6month_calculated;
	}
	public void setR22_6month_calculated(BigDecimal r22_6month_calculated) {
		this.r22_6month_calculated = r22_6month_calculated;
	}
	public BigDecimal getR22_year_calculated() {
		return r22_year_calculated;
	}
	public void setR22_year_calculated(BigDecimal r22_year_calculated) {
		this.r22_year_calculated = r22_year_calculated;
	}
	public BigDecimal getR22_total_asf() {
		return r22_total_asf;
	}
	public void setR22_total_asf(BigDecimal r22_total_asf) {
		this.r22_total_asf = r22_total_asf;
	}
	public String getR23_product() {
		return r23_product;
	}
	public void setR23_product(String r23_product) {
		this.r23_product = r23_product;
	}
	public BigDecimal getR23_month_amount() {
		return r23_month_amount;
	}
	public void setR23_month_amount(BigDecimal r23_month_amount) {
		this.r23_month_amount = r23_month_amount;
	}
	public BigDecimal getR23_6month_amount() {
		return r23_6month_amount;
	}
	public void setR23_6month_amount(BigDecimal r23_6month_amount) {
		this.r23_6month_amount = r23_6month_amount;
	}
	public BigDecimal getR23_year_amount() {
		return r23_year_amount;
	}
	public void setR23_year_amount(BigDecimal r23_year_amount) {
		this.r23_year_amount = r23_year_amount;
	}
	public BigDecimal getR23_month_factor() {
		return r23_month_factor;
	}
	public void setR23_month_factor(BigDecimal r23_month_factor) {
		this.r23_month_factor = r23_month_factor;
	}
	public BigDecimal getR23_6month_factor() {
		return r23_6month_factor;
	}
	public void setR23_6month_factor(BigDecimal r23_6month_factor) {
		this.r23_6month_factor = r23_6month_factor;
	}
	public BigDecimal getR23_year_factor() {
		return r23_year_factor;
	}
	public void setR23_year_factor(BigDecimal r23_year_factor) {
		this.r23_year_factor = r23_year_factor;
	}
	public BigDecimal getR23_month_calculated() {
		return r23_month_calculated;
	}
	public void setR23_month_calculated(BigDecimal r23_month_calculated) {
		this.r23_month_calculated = r23_month_calculated;
	}
	public BigDecimal getR23_6month_calculated() {
		return r23_6month_calculated;
	}
	public void setR23_6month_calculated(BigDecimal r23_6month_calculated) {
		this.r23_6month_calculated = r23_6month_calculated;
	}
	public BigDecimal getR23_year_calculated() {
		return r23_year_calculated;
	}
	public void setR23_year_calculated(BigDecimal r23_year_calculated) {
		this.r23_year_calculated = r23_year_calculated;
	}
	public BigDecimal getR23_total_asf() {
		return r23_total_asf;
	}
	public void setR23_total_asf(BigDecimal r23_total_asf) {
		this.r23_total_asf = r23_total_asf;
	}
	public String getR24_product() {
		return r24_product;
	}
	public void setR24_product(String r24_product) {
		this.r24_product = r24_product;
	}
	public BigDecimal getR24_month_amount() {
		return r24_month_amount;
	}
	public void setR24_month_amount(BigDecimal r24_month_amount) {
		this.r24_month_amount = r24_month_amount;
	}
	public BigDecimal getR24_6month_amount() {
		return r24_6month_amount;
	}
	public void setR24_6month_amount(BigDecimal r24_6month_amount) {
		this.r24_6month_amount = r24_6month_amount;
	}
	public BigDecimal getR24_year_amount() {
		return r24_year_amount;
	}
	public void setR24_year_amount(BigDecimal r24_year_amount) {
		this.r24_year_amount = r24_year_amount;
	}
	public BigDecimal getR24_month_factor() {
		return r24_month_factor;
	}
	public void setR24_month_factor(BigDecimal r24_month_factor) {
		this.r24_month_factor = r24_month_factor;
	}
	public BigDecimal getR24_6month_factor() {
		return r24_6month_factor;
	}
	public void setR24_6month_factor(BigDecimal r24_6month_factor) {
		this.r24_6month_factor = r24_6month_factor;
	}
	public BigDecimal getR24_year_factor() {
		return r24_year_factor;
	}
	public void setR24_year_factor(BigDecimal r24_year_factor) {
		this.r24_year_factor = r24_year_factor;
	}
	public BigDecimal getR24_month_calculated() {
		return r24_month_calculated;
	}
	public void setR24_month_calculated(BigDecimal r24_month_calculated) {
		this.r24_month_calculated = r24_month_calculated;
	}
	public BigDecimal getR24_6month_calculated() {
		return r24_6month_calculated;
	}
	public void setR24_6month_calculated(BigDecimal r24_6month_calculated) {
		this.r24_6month_calculated = r24_6month_calculated;
	}
	public BigDecimal getR24_year_calculated() {
		return r24_year_calculated;
	}
	public void setR24_year_calculated(BigDecimal r24_year_calculated) {
		this.r24_year_calculated = r24_year_calculated;
	}
	public BigDecimal getR24_total_asf() {
		return r24_total_asf;
	}
	public void setR24_total_asf(BigDecimal r24_total_asf) {
		this.r24_total_asf = r24_total_asf;
	}
	public String getR25_product() {
		return r25_product;
	}
	public void setR25_product(String r25_product) {
		this.r25_product = r25_product;
	}
	public BigDecimal getR25_month_amount() {
		return r25_month_amount;
	}
	public void setR25_month_amount(BigDecimal r25_month_amount) {
		this.r25_month_amount = r25_month_amount;
	}
	public BigDecimal getR25_6month_amount() {
		return r25_6month_amount;
	}
	public void setR25_6month_amount(BigDecimal r25_6month_amount) {
		this.r25_6month_amount = r25_6month_amount;
	}
	public BigDecimal getR25_year_amount() {
		return r25_year_amount;
	}
	public void setR25_year_amount(BigDecimal r25_year_amount) {
		this.r25_year_amount = r25_year_amount;
	}
	public BigDecimal getR25_month_factor() {
		return r25_month_factor;
	}
	public void setR25_month_factor(BigDecimal r25_month_factor) {
		this.r25_month_factor = r25_month_factor;
	}
	public BigDecimal getR25_6month_factor() {
		return r25_6month_factor;
	}
	public void setR25_6month_factor(BigDecimal r25_6month_factor) {
		this.r25_6month_factor = r25_6month_factor;
	}
	public BigDecimal getR25_year_factor() {
		return r25_year_factor;
	}
	public void setR25_year_factor(BigDecimal r25_year_factor) {
		this.r25_year_factor = r25_year_factor;
	}
	public BigDecimal getR25_month_calculated() {
		return r25_month_calculated;
	}
	public void setR25_month_calculated(BigDecimal r25_month_calculated) {
		this.r25_month_calculated = r25_month_calculated;
	}
	public BigDecimal getR25_6month_calculated() {
		return r25_6month_calculated;
	}
	public void setR25_6month_calculated(BigDecimal r25_6month_calculated) {
		this.r25_6month_calculated = r25_6month_calculated;
	}
	public BigDecimal getR25_year_calculated() {
		return r25_year_calculated;
	}
	public void setR25_year_calculated(BigDecimal r25_year_calculated) {
		this.r25_year_calculated = r25_year_calculated;
	}
	public BigDecimal getR25_total_asf() {
		return r25_total_asf;
	}
	public void setR25_total_asf(BigDecimal r25_total_asf) {
		this.r25_total_asf = r25_total_asf;
	}
	public String getR27_product() {
		return r27_product;
	}
	public void setR27_product(String r27_product) {
		this.r27_product = r27_product;
	}
	public BigDecimal getR27_month_amount() {
		return r27_month_amount;
	}
	public void setR27_month_amount(BigDecimal r27_month_amount) {
		this.r27_month_amount = r27_month_amount;
	}
	public BigDecimal getR27_6month_amount() {
		return r27_6month_amount;
	}
	public void setR27_6month_amount(BigDecimal r27_6month_amount) {
		this.r27_6month_amount = r27_6month_amount;
	}
	public BigDecimal getR27_year_amount() {
		return r27_year_amount;
	}
	public void setR27_year_amount(BigDecimal r27_year_amount) {
		this.r27_year_amount = r27_year_amount;
	}
	public BigDecimal getR27_month_factor() {
		return r27_month_factor;
	}
	public void setR27_month_factor(BigDecimal r27_month_factor) {
		this.r27_month_factor = r27_month_factor;
	}
	public BigDecimal getR27_6month_factor() {
		return r27_6month_factor;
	}
	public void setR27_6month_factor(BigDecimal r27_6month_factor) {
		this.r27_6month_factor = r27_6month_factor;
	}
	public BigDecimal getR27_year_factor() {
		return r27_year_factor;
	}
	public void setR27_year_factor(BigDecimal r27_year_factor) {
		this.r27_year_factor = r27_year_factor;
	}
	public BigDecimal getR27_month_calculated() {
		return r27_month_calculated;
	}
	public void setR27_month_calculated(BigDecimal r27_month_calculated) {
		this.r27_month_calculated = r27_month_calculated;
	}
	public BigDecimal getR27_6month_calculated() {
		return r27_6month_calculated;
	}
	public void setR27_6month_calculated(BigDecimal r27_6month_calculated) {
		this.r27_6month_calculated = r27_6month_calculated;
	}
	public BigDecimal getR27_year_calculated() {
		return r27_year_calculated;
	}
	public void setR27_year_calculated(BigDecimal r27_year_calculated) {
		this.r27_year_calculated = r27_year_calculated;
	}
	public BigDecimal getR27_total_asf() {
		return r27_total_asf;
	}
	public void setR27_total_asf(BigDecimal r27_total_asf) {
		this.r27_total_asf = r27_total_asf;
	}
	public String getR28_product() {
		return r28_product;
	}
	public void setR28_product(String r28_product) {
		this.r28_product = r28_product;
	}
	public BigDecimal getR28_month_amount() {
		return r28_month_amount;
	}
	public void setR28_month_amount(BigDecimal r28_month_amount) {
		this.r28_month_amount = r28_month_amount;
	}
	public BigDecimal getR28_6month_amount() {
		return r28_6month_amount;
	}
	public void setR28_6month_amount(BigDecimal r28_6month_amount) {
		this.r28_6month_amount = r28_6month_amount;
	}
	public BigDecimal getR28_year_amount() {
		return r28_year_amount;
	}
	public void setR28_year_amount(BigDecimal r28_year_amount) {
		this.r28_year_amount = r28_year_amount;
	}
	public BigDecimal getR28_month_factor() {
		return r28_month_factor;
	}
	public void setR28_month_factor(BigDecimal r28_month_factor) {
		this.r28_month_factor = r28_month_factor;
	}
	public BigDecimal getR28_6month_factor() {
		return r28_6month_factor;
	}
	public void setR28_6month_factor(BigDecimal r28_6month_factor) {
		this.r28_6month_factor = r28_6month_factor;
	}
	public BigDecimal getR28_year_factor() {
		return r28_year_factor;
	}
	public void setR28_year_factor(BigDecimal r28_year_factor) {
		this.r28_year_factor = r28_year_factor;
	}
	public BigDecimal getR28_month_calculated() {
		return r28_month_calculated;
	}
	public void setR28_month_calculated(BigDecimal r28_month_calculated) {
		this.r28_month_calculated = r28_month_calculated;
	}
	public BigDecimal getR28_6month_calculated() {
		return r28_6month_calculated;
	}
	public void setR28_6month_calculated(BigDecimal r28_6month_calculated) {
		this.r28_6month_calculated = r28_6month_calculated;
	}
	public BigDecimal getR28_year_calculated() {
		return r28_year_calculated;
	}
	public void setR28_year_calculated(BigDecimal r28_year_calculated) {
		this.r28_year_calculated = r28_year_calculated;
	}
	public BigDecimal getR28_total_asf() {
		return r28_total_asf;
	}
	public void setR28_total_asf(BigDecimal r28_total_asf) {
		this.r28_total_asf = r28_total_asf;
	}
	public String getR29_product() {
		return r29_product;
	}
	public void setR29_product(String r29_product) {
		this.r29_product = r29_product;
	}
	public BigDecimal getR29_month_amount() {
		return r29_month_amount;
	}
	public void setR29_month_amount(BigDecimal r29_month_amount) {
		this.r29_month_amount = r29_month_amount;
	}
	public BigDecimal getR29_6month_amount() {
		return r29_6month_amount;
	}
	public void setR29_6month_amount(BigDecimal r29_6month_amount) {
		this.r29_6month_amount = r29_6month_amount;
	}
	public BigDecimal getR29_year_amount() {
		return r29_year_amount;
	}
	public void setR29_year_amount(BigDecimal r29_year_amount) {
		this.r29_year_amount = r29_year_amount;
	}
	public BigDecimal getR29_month_factor() {
		return r29_month_factor;
	}
	public void setR29_month_factor(BigDecimal r29_month_factor) {
		this.r29_month_factor = r29_month_factor;
	}
	public BigDecimal getR29_6month_factor() {
		return r29_6month_factor;
	}
	public void setR29_6month_factor(BigDecimal r29_6month_factor) {
		this.r29_6month_factor = r29_6month_factor;
	}
	public BigDecimal getR29_year_factor() {
		return r29_year_factor;
	}
	public void setR29_year_factor(BigDecimal r29_year_factor) {
		this.r29_year_factor = r29_year_factor;
	}
	public String getR30_product() {
		return r30_product;
	}
	public void setR30_product(String r30_product) {
		this.r30_product = r30_product;
	}
	public BigDecimal getR30_month_amount() {
		return r30_month_amount;
	}
	public void setR30_month_amount(BigDecimal r30_month_amount) {
		this.r30_month_amount = r30_month_amount;
	}
	public BigDecimal getR30_6month_amount() {
		return r30_6month_amount;
	}
	public void setR30_6month_amount(BigDecimal r30_6month_amount) {
		this.r30_6month_amount = r30_6month_amount;
	}
	public BigDecimal getR30_year_amount() {
		return r30_year_amount;
	}
	public void setR30_year_amount(BigDecimal r30_year_amount) {
		this.r30_year_amount = r30_year_amount;
	}
	public BigDecimal getR30_month_factor() {
		return r30_month_factor;
	}
	public void setR30_month_factor(BigDecimal r30_month_factor) {
		this.r30_month_factor = r30_month_factor;
	}
	public BigDecimal getR30_6month_factor() {
		return r30_6month_factor;
	}
	public void setR30_6month_factor(BigDecimal r30_6month_factor) {
		this.r30_6month_factor = r30_6month_factor;
	}
	public BigDecimal getR30_year_factor() {
		return r30_year_factor;
	}
	public void setR30_year_factor(BigDecimal r30_year_factor) {
		this.r30_year_factor = r30_year_factor;
	}
	public BigDecimal getR30_month_calculated() {
		return r30_month_calculated;
	}
	public void setR30_month_calculated(BigDecimal r30_month_calculated) {
		this.r30_month_calculated = r30_month_calculated;
	}
	public BigDecimal getR30_6month_calculated() {
		return r30_6month_calculated;
	}
	public void setR30_6month_calculated(BigDecimal r30_6month_calculated) {
		this.r30_6month_calculated = r30_6month_calculated;
	}
	public BigDecimal getR30_year_calculated() {
		return r30_year_calculated;
	}
	public void setR30_year_calculated(BigDecimal r30_year_calculated) {
		this.r30_year_calculated = r30_year_calculated;
	}
	public BigDecimal getR30_total_asf() {
		return r30_total_asf;
	}
	public void setR30_total_asf(BigDecimal r30_total_asf) {
		this.r30_total_asf = r30_total_asf;
	}
	public String getR31_product() {
		return r31_product;
	}
	public void setR31_product(String r31_product) {
		this.r31_product = r31_product;
	}
	public BigDecimal getR31_month_amount() {
		return r31_month_amount;
	}
	public void setR31_month_amount(BigDecimal r31_month_amount) {
		this.r31_month_amount = r31_month_amount;
	}
	public BigDecimal getR31_6month_amount() {
		return r31_6month_amount;
	}
	public void setR31_6month_amount(BigDecimal r31_6month_amount) {
		this.r31_6month_amount = r31_6month_amount;
	}
	public BigDecimal getR31_year_amount() {
		return r31_year_amount;
	}
	public void setR31_year_amount(BigDecimal r31_year_amount) {
		this.r31_year_amount = r31_year_amount;
	}
	public BigDecimal getR31_month_factor() {
		return r31_month_factor;
	}
	public void setR31_month_factor(BigDecimal r31_month_factor) {
		this.r31_month_factor = r31_month_factor;
	}
	public BigDecimal getR31_6month_factor() {
		return r31_6month_factor;
	}
	public void setR31_6month_factor(BigDecimal r31_6month_factor) {
		this.r31_6month_factor = r31_6month_factor;
	}
	public BigDecimal getR31_year_factor() {
		return r31_year_factor;
	}
	public void setR31_year_factor(BigDecimal r31_year_factor) {
		this.r31_year_factor = r31_year_factor;
	}
	public BigDecimal getR31_month_calculated() {
		return r31_month_calculated;
	}
	public void setR31_month_calculated(BigDecimal r31_month_calculated) {
		this.r31_month_calculated = r31_month_calculated;
	}
	public BigDecimal getR31_6month_calculated() {
		return r31_6month_calculated;
	}
	public void setR31_6month_calculated(BigDecimal r31_6month_calculated) {
		this.r31_6month_calculated = r31_6month_calculated;
	}
	public BigDecimal getR31_year_calculated() {
		return r31_year_calculated;
	}
	public void setR31_year_calculated(BigDecimal r31_year_calculated) {
		this.r31_year_calculated = r31_year_calculated;
	}
	public BigDecimal getR31_total_asf() {
		return r31_total_asf;
	}
	public void setR31_total_asf(BigDecimal r31_total_asf) {
		this.r31_total_asf = r31_total_asf;
	}
	public String getR32_product() {
		return r32_product;
	}
	public void setR32_product(String r32_product) {
		this.r32_product = r32_product;
	}
	public BigDecimal getR32_month_amount() {
		return r32_month_amount;
	}
	public void setR32_month_amount(BigDecimal r32_month_amount) {
		this.r32_month_amount = r32_month_amount;
	}
	public BigDecimal getR32_6month_amount() {
		return r32_6month_amount;
	}
	public void setR32_6month_amount(BigDecimal r32_6month_amount) {
		this.r32_6month_amount = r32_6month_amount;
	}
	public BigDecimal getR32_year_amount() {
		return r32_year_amount;
	}
	public void setR32_year_amount(BigDecimal r32_year_amount) {
		this.r32_year_amount = r32_year_amount;
	}
	public BigDecimal getR32_month_factor() {
		return r32_month_factor;
	}
	public void setR32_month_factor(BigDecimal r32_month_factor) {
		this.r32_month_factor = r32_month_factor;
	}
	public BigDecimal getR32_6month_factor() {
		return r32_6month_factor;
	}
	public void setR32_6month_factor(BigDecimal r32_6month_factor) {
		this.r32_6month_factor = r32_6month_factor;
	}
	public BigDecimal getR32_year_factor() {
		return r32_year_factor;
	}
	public void setR32_year_factor(BigDecimal r32_year_factor) {
		this.r32_year_factor = r32_year_factor;
	}
	public BigDecimal getR32_month_calculated() {
		return r32_month_calculated;
	}
	public void setR32_month_calculated(BigDecimal r32_month_calculated) {
		this.r32_month_calculated = r32_month_calculated;
	}
	public BigDecimal getR32_6month_calculated() {
		return r32_6month_calculated;
	}
	public void setR32_6month_calculated(BigDecimal r32_6month_calculated) {
		this.r32_6month_calculated = r32_6month_calculated;
	}
	public BigDecimal getR32_year_calculated() {
		return r32_year_calculated;
	}
	public void setR32_year_calculated(BigDecimal r32_year_calculated) {
		this.r32_year_calculated = r32_year_calculated;
	}
	public BigDecimal getR32_total_asf() {
		return r32_total_asf;
	}
	public void setR32_total_asf(BigDecimal r32_total_asf) {
		this.r32_total_asf = r32_total_asf;
	}
	public String getR33_product() {
		return r33_product;
	}
	public void setR33_product(String r33_product) {
		this.r33_product = r33_product;
	}
	public BigDecimal getR33_month_amount() {
		return r33_month_amount;
	}
	public void setR33_month_amount(BigDecimal r33_month_amount) {
		this.r33_month_amount = r33_month_amount;
	}
	public BigDecimal getR33_6month_amount() {
		return r33_6month_amount;
	}
	public void setR33_6month_amount(BigDecimal r33_6month_amount) {
		this.r33_6month_amount = r33_6month_amount;
	}
	public BigDecimal getR33_year_amount() {
		return r33_year_amount;
	}
	public void setR33_year_amount(BigDecimal r33_year_amount) {
		this.r33_year_amount = r33_year_amount;
	}
	public BigDecimal getR33_month_factor() {
		return r33_month_factor;
	}
	public void setR33_month_factor(BigDecimal r33_month_factor) {
		this.r33_month_factor = r33_month_factor;
	}
	public BigDecimal getR33_6month_factor() {
		return r33_6month_factor;
	}
	public void setR33_6month_factor(BigDecimal r33_6month_factor) {
		this.r33_6month_factor = r33_6month_factor;
	}
	public BigDecimal getR33_year_factor() {
		return r33_year_factor;
	}
	public void setR33_year_factor(BigDecimal r33_year_factor) {
		this.r33_year_factor = r33_year_factor;
	}
	public BigDecimal getR33_month_calculated() {
		return r33_month_calculated;
	}
	public void setR33_month_calculated(BigDecimal r33_month_calculated) {
		this.r33_month_calculated = r33_month_calculated;
	}
	public BigDecimal getR33_6month_calculated() {
		return r33_6month_calculated;
	}
	public void setR33_6month_calculated(BigDecimal r33_6month_calculated) {
		this.r33_6month_calculated = r33_6month_calculated;
	}
	public BigDecimal getR33_year_calculated() {
		return r33_year_calculated;
	}
	public void setR33_year_calculated(BigDecimal r33_year_calculated) {
		this.r33_year_calculated = r33_year_calculated;
	}
	public BigDecimal getR33_total_asf() {
		return r33_total_asf;
	}
	public void setR33_total_asf(BigDecimal r33_total_asf) {
		this.r33_total_asf = r33_total_asf;
	}
	public String getR34_product() {
		return r34_product;
	}
	public void setR34_product(String r34_product) {
		this.r34_product = r34_product;
	}
	public BigDecimal getR34_month_amount() {
		return r34_month_amount;
	}
	public void setR34_month_amount(BigDecimal r34_month_amount) {
		this.r34_month_amount = r34_month_amount;
	}
	public BigDecimal getR34_6month_amount() {
		return r34_6month_amount;
	}
	public void setR34_6month_amount(BigDecimal r34_6month_amount) {
		this.r34_6month_amount = r34_6month_amount;
	}
	public BigDecimal getR34_year_amount() {
		return r34_year_amount;
	}
	public void setR34_year_amount(BigDecimal r34_year_amount) {
		this.r34_year_amount = r34_year_amount;
	}
	public BigDecimal getR34_month_factor() {
		return r34_month_factor;
	}
	public void setR34_month_factor(BigDecimal r34_month_factor) {
		this.r34_month_factor = r34_month_factor;
	}
	public BigDecimal getR34_6month_factor() {
		return r34_6month_factor;
	}
	public void setR34_6month_factor(BigDecimal r34_6month_factor) {
		this.r34_6month_factor = r34_6month_factor;
	}
	public BigDecimal getR34_year_factor() {
		return r34_year_factor;
	}
	public void setR34_year_factor(BigDecimal r34_year_factor) {
		this.r34_year_factor = r34_year_factor;
	}
	public BigDecimal getR34_month_calculated() {
		return r34_month_calculated;
	}
	public void setR34_month_calculated(BigDecimal r34_month_calculated) {
		this.r34_month_calculated = r34_month_calculated;
	}
	public BigDecimal getR34_6month_calculated() {
		return r34_6month_calculated;
	}
	public void setR34_6month_calculated(BigDecimal r34_6month_calculated) {
		this.r34_6month_calculated = r34_6month_calculated;
	}
	public BigDecimal getR34_year_calculated() {
		return r34_year_calculated;
	}
	public void setR34_year_calculated(BigDecimal r34_year_calculated) {
		this.r34_year_calculated = r34_year_calculated;
	}
	public BigDecimal getR34_total_asf() {
		return r34_total_asf;
	}
	public void setR34_total_asf(BigDecimal r34_total_asf) {
		this.r34_total_asf = r34_total_asf;
	}
	public String getR35_product() {
		return r35_product;
	}
	public void setR35_product(String r35_product) {
		this.r35_product = r35_product;
	}
	public BigDecimal getR35_month_amount() {
		return r35_month_amount;
	}
	public void setR35_month_amount(BigDecimal r35_month_amount) {
		this.r35_month_amount = r35_month_amount;
	}
	public BigDecimal getR35_6month_amount() {
		return r35_6month_amount;
	}
	public void setR35_6month_amount(BigDecimal r35_6month_amount) {
		this.r35_6month_amount = r35_6month_amount;
	}
	public BigDecimal getR35_year_amount() {
		return r35_year_amount;
	}
	public void setR35_year_amount(BigDecimal r35_year_amount) {
		this.r35_year_amount = r35_year_amount;
	}
	public BigDecimal getR35_month_factor() {
		return r35_month_factor;
	}
	public void setR35_month_factor(BigDecimal r35_month_factor) {
		this.r35_month_factor = r35_month_factor;
	}
	public BigDecimal getR35_6month_factor() {
		return r35_6month_factor;
	}
	public void setR35_6month_factor(BigDecimal r35_6month_factor) {
		this.r35_6month_factor = r35_6month_factor;
	}
	public BigDecimal getR35_year_factor() {
		return r35_year_factor;
	}
	public void setR35_year_factor(BigDecimal r35_year_factor) {
		this.r35_year_factor = r35_year_factor;
	}
	public BigDecimal getR35_month_calculated() {
		return r35_month_calculated;
	}
	public void setR35_month_calculated(BigDecimal r35_month_calculated) {
		this.r35_month_calculated = r35_month_calculated;
	}
	public BigDecimal getR35_6month_calculated() {
		return r35_6month_calculated;
	}
	public void setR35_6month_calculated(BigDecimal r35_6month_calculated) {
		this.r35_6month_calculated = r35_6month_calculated;
	}
	public BigDecimal getR35_year_calculated() {
		return r35_year_calculated;
	}
	public void setR35_year_calculated(BigDecimal r35_year_calculated) {
		this.r35_year_calculated = r35_year_calculated;
	}
	public BigDecimal getR35_total_asf() {
		return r35_total_asf;
	}
	public void setR35_total_asf(BigDecimal r35_total_asf) {
		this.r35_total_asf = r35_total_asf;
	}
	public String getR36_product() {
		return r36_product;
	}
	public void setR36_product(String r36_product) {
		this.r36_product = r36_product;
	}
	public BigDecimal getR36_month_amount() {
		return r36_month_amount;
	}
	public void setR36_month_amount(BigDecimal r36_month_amount) {
		this.r36_month_amount = r36_month_amount;
	}
	public BigDecimal getR36_6month_amount() {
		return r36_6month_amount;
	}
	public void setR36_6month_amount(BigDecimal r36_6month_amount) {
		this.r36_6month_amount = r36_6month_amount;
	}
	public BigDecimal getR36_year_amount() {
		return r36_year_amount;
	}
	public void setR36_year_amount(BigDecimal r36_year_amount) {
		this.r36_year_amount = r36_year_amount;
	}
	public BigDecimal getR36_month_factor() {
		return r36_month_factor;
	}
	public void setR36_month_factor(BigDecimal r36_month_factor) {
		this.r36_month_factor = r36_month_factor;
	}
	public BigDecimal getR36_6month_factor() {
		return r36_6month_factor;
	}
	public void setR36_6month_factor(BigDecimal r36_6month_factor) {
		this.r36_6month_factor = r36_6month_factor;
	}
	public BigDecimal getR36_year_factor() {
		return r36_year_factor;
	}
	public void setR36_year_factor(BigDecimal r36_year_factor) {
		this.r36_year_factor = r36_year_factor;
	}
	public BigDecimal getR36_month_calculated() {
		return r36_month_calculated;
	}
	public void setR36_month_calculated(BigDecimal r36_month_calculated) {
		this.r36_month_calculated = r36_month_calculated;
	}
	public BigDecimal getR36_6month_calculated() {
		return r36_6month_calculated;
	}
	public void setR36_6month_calculated(BigDecimal r36_6month_calculated) {
		this.r36_6month_calculated = r36_6month_calculated;
	}
	public BigDecimal getR36_year_calculated() {
		return r36_year_calculated;
	}
	public void setR36_year_calculated(BigDecimal r36_year_calculated) {
		this.r36_year_calculated = r36_year_calculated;
	}
	public BigDecimal getR36_total_asf() {
		return r36_total_asf;
	}
	public void setR36_total_asf(BigDecimal r36_total_asf) {
		this.r36_total_asf = r36_total_asf;
	}
	public String getR38_product() {
		return r38_product;
	}
	public void setR38_product(String r38_product) {
		this.r38_product = r38_product;
	}
	public BigDecimal getR38_year_amount() {
		return r38_year_amount;
	}
	public void setR38_year_amount(BigDecimal r38_year_amount) {
		this.r38_year_amount = r38_year_amount;
	}
	public String getR39_product() {
		return r39_product;
	}
	public void setR39_product(String r39_product) {
		this.r39_product = r39_product;
	}
	public BigDecimal getR39_year_amount() {
		return r39_year_amount;
	}
	public void setR39_year_amount(BigDecimal r39_year_amount) {
		this.r39_year_amount = r39_year_amount;
	}
	public String getR40_product() {
		return r40_product;
	}
	public void setR40_product(String r40_product) {
		this.r40_product = r40_product;
	}
	public BigDecimal getR40_year_amount() {
		return r40_year_amount;
	}
	public void setR40_year_amount(BigDecimal r40_year_amount) {
		this.r40_year_amount = r40_year_amount;
	}
	public BigDecimal getR40_year_factor() {
		return r40_year_factor;
	}
	public void setR40_year_factor(BigDecimal r40_year_factor) {
		this.r40_year_factor = r40_year_factor;
	}
	public BigDecimal getR40_year_calculated() {
		return r40_year_calculated;
	}
	public void setR40_year_calculated(BigDecimal r40_year_calculated) {
		this.r40_year_calculated = r40_year_calculated;
	}
	public BigDecimal getR40_total_asf() {
		return r40_total_asf;
	}
	public void setR40_total_asf(BigDecimal r40_total_asf) {
		this.r40_total_asf = r40_total_asf;
	}
	public String getR41_product() {
		return r41_product;
	}
	public void setR41_product(String r41_product) {
		this.r41_product = r41_product;
	}
	public BigDecimal getR41_year_amount() {
		return r41_year_amount;
	}
	public void setR41_year_amount(BigDecimal r41_year_amount) {
		this.r41_year_amount = r41_year_amount;
	}
	public BigDecimal getR41_year_factor() {
		return r41_year_factor;
	}
	public void setR41_year_factor(BigDecimal r41_year_factor) {
		this.r41_year_factor = r41_year_factor;
	}
	public BigDecimal getR41_year_calculated() {
		return r41_year_calculated;
	}
	public void setR41_year_calculated(BigDecimal r41_year_calculated) {
		this.r41_year_calculated = r41_year_calculated;
	}
	public BigDecimal getR41_total_asf() {
		return r41_total_asf;
	}
	public void setR41_total_asf(BigDecimal r41_total_asf) {
		this.r41_total_asf = r41_total_asf;
	}
	public String getR42_product() {
		return r42_product;
	}
	public void setR42_product(String r42_product) {
		this.r42_product = r42_product;
	}
	public BigDecimal getR42_year_amount() {
		return r42_year_amount;
	}
	public void setR42_year_amount(BigDecimal r42_year_amount) {
		this.r42_year_amount = r42_year_amount;
	}
	public BigDecimal getR42_year_factor() {
		return r42_year_factor;
	}
	public void setR42_year_factor(BigDecimal r42_year_factor) {
		this.r42_year_factor = r42_year_factor;
	}
	public BigDecimal getR42_year_calculated() {
		return r42_year_calculated;
	}
	public void setR42_year_calculated(BigDecimal r42_year_calculated) {
		this.r42_year_calculated = r42_year_calculated;
	}
	public BigDecimal getR42_total_asf() {
		return r42_total_asf;
	}
	public void setR42_total_asf(BigDecimal r42_total_asf) {
		this.r42_total_asf = r42_total_asf;
	}
	public String getR44_product() {
		return r44_product;
	}
	public void setR44_product(String r44_product) {
		this.r44_product = r44_product;
	}
	public BigDecimal getR44_month_amount() {
		return r44_month_amount;
	}
	public void setR44_month_amount(BigDecimal r44_month_amount) {
		this.r44_month_amount = r44_month_amount;
	}
	public BigDecimal getR44_6month_amount() {
		return r44_6month_amount;
	}
	public void setR44_6month_amount(BigDecimal r44_6month_amount) {
		this.r44_6month_amount = r44_6month_amount;
	}
	public BigDecimal getR44_year_amount() {
		return r44_year_amount;
	}
	public void setR44_year_amount(BigDecimal r44_year_amount) {
		this.r44_year_amount = r44_year_amount;
	}
	public BigDecimal getR44_month_factor() {
		return r44_month_factor;
	}
	public void setR44_month_factor(BigDecimal r44_month_factor) {
		this.r44_month_factor = r44_month_factor;
	}
	public BigDecimal getR44_6month_factor() {
		return r44_6month_factor;
	}
	public void setR44_6month_factor(BigDecimal r44_6month_factor) {
		this.r44_6month_factor = r44_6month_factor;
	}
	public BigDecimal getR44_year_factor() {
		return r44_year_factor;
	}
	public void setR44_year_factor(BigDecimal r44_year_factor) {
		this.r44_year_factor = r44_year_factor;
	}
	public BigDecimal getR44_month_calculated() {
		return r44_month_calculated;
	}
	public void setR44_month_calculated(BigDecimal r44_month_calculated) {
		this.r44_month_calculated = r44_month_calculated;
	}
	public BigDecimal getR44_6month_calculated() {
		return r44_6month_calculated;
	}
	public void setR44_6month_calculated(BigDecimal r44_6month_calculated) {
		this.r44_6month_calculated = r44_6month_calculated;
	}
	public BigDecimal getR44_year_calculated() {
		return r44_year_calculated;
	}
	public void setR44_year_calculated(BigDecimal r44_year_calculated) {
		this.r44_year_calculated = r44_year_calculated;
	}
	public BigDecimal getR44_total_asf() {
		return r44_total_asf;
	}
	public void setR44_total_asf(BigDecimal r44_total_asf) {
		this.r44_total_asf = r44_total_asf;
	}
	public String getR45_product() {
		return r45_product;
	}
	public void setR45_product(String r45_product) {
		this.r45_product = r45_product;
	}
	public BigDecimal getR45_month_amount() {
		return r45_month_amount;
	}
	public void setR45_month_amount(BigDecimal r45_month_amount) {
		this.r45_month_amount = r45_month_amount;
	}
	public BigDecimal getR45_6month_amount() {
		return r45_6month_amount;
	}
	public void setR45_6month_amount(BigDecimal r45_6month_amount) {
		this.r45_6month_amount = r45_6month_amount;
	}
	public BigDecimal getR45_year_amount() {
		return r45_year_amount;
	}
	public void setR45_year_amount(BigDecimal r45_year_amount) {
		this.r45_year_amount = r45_year_amount;
	}
	public BigDecimal getR45_month_factor() {
		return r45_month_factor;
	}
	public void setR45_month_factor(BigDecimal r45_month_factor) {
		this.r45_month_factor = r45_month_factor;
	}
	public BigDecimal getR45_6month_factor() {
		return r45_6month_factor;
	}
	public void setR45_6month_factor(BigDecimal r45_6month_factor) {
		this.r45_6month_factor = r45_6month_factor;
	}
	public BigDecimal getR45_year_factor() {
		return r45_year_factor;
	}
	public void setR45_year_factor(BigDecimal r45_year_factor) {
		this.r45_year_factor = r45_year_factor;
	}
	public BigDecimal getR45_month_calculated() {
		return r45_month_calculated;
	}
	public void setR45_month_calculated(BigDecimal r45_month_calculated) {
		this.r45_month_calculated = r45_month_calculated;
	}
	public BigDecimal getR45_6month_calculated() {
		return r45_6month_calculated;
	}
	public void setR45_6month_calculated(BigDecimal r45_6month_calculated) {
		this.r45_6month_calculated = r45_6month_calculated;
	}
	public BigDecimal getR45_year_calculated() {
		return r45_year_calculated;
	}
	public void setR45_year_calculated(BigDecimal r45_year_calculated) {
		this.r45_year_calculated = r45_year_calculated;
	}
	public BigDecimal getR45_total_asf() {
		return r45_total_asf;
	}
	public void setR45_total_asf(BigDecimal r45_total_asf) {
		this.r45_total_asf = r45_total_asf;
	}
	public String getR46_product() {
		return r46_product;
	}
	public void setR46_product(String r46_product) {
		this.r46_product = r46_product;
	}
	public BigDecimal getR46_month_amount() {
		return r46_month_amount;
	}
	public void setR46_month_amount(BigDecimal r46_month_amount) {
		this.r46_month_amount = r46_month_amount;
	}
	public BigDecimal getR46_month_factor() {
		return r46_month_factor;
	}
	public void setR46_month_factor(BigDecimal r46_month_factor) {
		this.r46_month_factor = r46_month_factor;
	}
	public BigDecimal getR46_month_calculated() {
		return r46_month_calculated;
	}
	public void setR46_month_calculated(BigDecimal r46_month_calculated) {
		this.r46_month_calculated = r46_month_calculated;
	}
	public BigDecimal getR46_total_asf() {
		return r46_total_asf;
	}
	public void setR46_total_asf(BigDecimal r46_total_asf) {
		this.r46_total_asf = r46_total_asf;
	}
	public String getR47_product() {
		return r47_product;
	}
	public void setR47_product(String r47_product) {
		this.r47_product = r47_product;
	}
	public BigDecimal getR47_month_amount() {
		return r47_month_amount;
	}
	public void setR47_month_amount(BigDecimal r47_month_amount) {
		this.r47_month_amount = r47_month_amount;
	}
	public BigDecimal getR47_6month_amount() {
		return r47_6month_amount;
	}
	public void setR47_6month_amount(BigDecimal r47_6month_amount) {
		this.r47_6month_amount = r47_6month_amount;
	}
	public BigDecimal getR47_year_amount() {
		return r47_year_amount;
	}
	public void setR47_year_amount(BigDecimal r47_year_amount) {
		this.r47_year_amount = r47_year_amount;
	}
	public BigDecimal getR47_month_factor() {
		return r47_month_factor;
	}
	public void setR47_month_factor(BigDecimal r47_month_factor) {
		this.r47_month_factor = r47_month_factor;
	}
	public BigDecimal getR47_6month_factor() {
		return r47_6month_factor;
	}
	public void setR47_6month_factor(BigDecimal r47_6month_factor) {
		this.r47_6month_factor = r47_6month_factor;
	}
	public BigDecimal getR47_year_factor() {
		return r47_year_factor;
	}
	public void setR47_year_factor(BigDecimal r47_year_factor) {
		this.r47_year_factor = r47_year_factor;
	}
	public BigDecimal getR47_month_calculated() {
		return r47_month_calculated;
	}
	public void setR47_month_calculated(BigDecimal r47_month_calculated) {
		this.r47_month_calculated = r47_month_calculated;
	}
	public BigDecimal getR47_6month_calculated() {
		return r47_6month_calculated;
	}
	public void setR47_6month_calculated(BigDecimal r47_6month_calculated) {
		this.r47_6month_calculated = r47_6month_calculated;
	}
	public BigDecimal getR47_year_calculated() {
		return r47_year_calculated;
	}
	public void setR47_year_calculated(BigDecimal r47_year_calculated) {
		this.r47_year_calculated = r47_year_calculated;
	}
	public BigDecimal getR47_total_asf() {
		return r47_total_asf;
	}
	public void setR47_total_asf(BigDecimal r47_total_asf) {
		this.r47_total_asf = r47_total_asf;
	}
	public String getR53_product() {
		return r53_product;
	}
	public void setR53_product(String r53_product) {
		this.r53_product = r53_product;
	}
	public BigDecimal getR53_month_amount() {
		return r53_month_amount;
	}
	public void setR53_month_amount(BigDecimal r53_month_amount) {
		this.r53_month_amount = r53_month_amount;
	}
	public BigDecimal getR53_month_factor() {
		return r53_month_factor;
	}
	public void setR53_month_factor(BigDecimal r53_month_factor) {
		this.r53_month_factor = r53_month_factor;
	}
	public BigDecimal getR53_month_calculated() {
		return r53_month_calculated;
	}
	public void setR53_month_calculated(BigDecimal r53_month_calculated) {
		this.r53_month_calculated = r53_month_calculated;
	}
	public BigDecimal getR53_total_asf() {
		return r53_total_asf;
	}
	public void setR53_total_asf(BigDecimal r53_total_asf) {
		this.r53_total_asf = r53_total_asf;
	}
	public String getR55_product() {
		return r55_product;
	}
	public void setR55_product(String r55_product) {
		this.r55_product = r55_product;
	}
	public BigDecimal getR55_month_amount() {
		return r55_month_amount;
	}
	public void setR55_month_amount(BigDecimal r55_month_amount) {
		this.r55_month_amount = r55_month_amount;
	}
	public BigDecimal getR55_month_factor() {
		return r55_month_factor;
	}
	public void setR55_month_factor(BigDecimal r55_month_factor) {
		this.r55_month_factor = r55_month_factor;
	}
	public BigDecimal getR55_month_calculated() {
		return r55_month_calculated;
	}
	public void setR55_month_calculated(BigDecimal r55_month_calculated) {
		this.r55_month_calculated = r55_month_calculated;
	}
	public BigDecimal getR55_total_asf() {
		return r55_total_asf;
	}
	public void setR55_total_asf(BigDecimal r55_total_asf) {
		this.r55_total_asf = r55_total_asf;
	}
	public String getR56_product() {
		return r56_product;
	}
	public void setR56_product(String r56_product) {
		this.r56_product = r56_product;
	}
	public BigDecimal getR56_month_amount() {
		return r56_month_amount;
	}
	public void setR56_month_amount(BigDecimal r56_month_amount) {
		this.r56_month_amount = r56_month_amount;
	}
	public BigDecimal getR56_month_factor() {
		return r56_month_factor;
	}
	public void setR56_month_factor(BigDecimal r56_month_factor) {
		this.r56_month_factor = r56_month_factor;
	}
	public BigDecimal getR56_month_calculated() {
		return r56_month_calculated;
	}
	public void setR56_month_calculated(BigDecimal r56_month_calculated) {
		this.r56_month_calculated = r56_month_calculated;
	}
	public BigDecimal getR56_total_asf() {
		return r56_total_asf;
	}
	public void setR56_total_asf(BigDecimal r56_total_asf) {
		this.r56_total_asf = r56_total_asf;
	}
	public String getR57_product() {
		return r57_product;
	}
	public void setR57_product(String r57_product) {
		this.r57_product = r57_product;
	}
	public BigDecimal getR57_month_amount() {
		return r57_month_amount;
	}
	public void setR57_month_amount(BigDecimal r57_month_amount) {
		this.r57_month_amount = r57_month_amount;
	}
	public BigDecimal getR57_6month_amount() {
		return r57_6month_amount;
	}
	public void setR57_6month_amount(BigDecimal r57_6month_amount) {
		this.r57_6month_amount = r57_6month_amount;
	}
	public BigDecimal getR57_year_amount() {
		return r57_year_amount;
	}
	public void setR57_year_amount(BigDecimal r57_year_amount) {
		this.r57_year_amount = r57_year_amount;
	}
	public BigDecimal getR57_month_factor() {
		return r57_month_factor;
	}
	public void setR57_month_factor(BigDecimal r57_month_factor) {
		this.r57_month_factor = r57_month_factor;
	}
	public BigDecimal getR57_6month_factor() {
		return r57_6month_factor;
	}
	public void setR57_6month_factor(BigDecimal r57_6month_factor) {
		this.r57_6month_factor = r57_6month_factor;
	}
	public BigDecimal getR57_year_factor() {
		return r57_year_factor;
	}
	public void setR57_year_factor(BigDecimal r57_year_factor) {
		this.r57_year_factor = r57_year_factor;
	}
	public BigDecimal getR57_month_calculated() {
		return r57_month_calculated;
	}
	public void setR57_month_calculated(BigDecimal r57_month_calculated) {
		this.r57_month_calculated = r57_month_calculated;
	}
	public BigDecimal getR57_6month_calculated() {
		return r57_6month_calculated;
	}
	public void setR57_6month_calculated(BigDecimal r57_6month_calculated) {
		this.r57_6month_calculated = r57_6month_calculated;
	}
	public BigDecimal getR57_year_calculated() {
		return r57_year_calculated;
	}
	public void setR57_year_calculated(BigDecimal r57_year_calculated) {
		this.r57_year_calculated = r57_year_calculated;
	}
	public BigDecimal getR57_total_asf() {
		return r57_total_asf;
	}
	public void setR57_total_asf(BigDecimal r57_total_asf) {
		this.r57_total_asf = r57_total_asf;
	}
	public String getR58_product() {
		return r58_product;
	}
	public void setR58_product(String r58_product) {
		this.r58_product = r58_product;
	}
	public BigDecimal getR58_month_amount() {
		return r58_month_amount;
	}
	public void setR58_month_amount(BigDecimal r58_month_amount) {
		this.r58_month_amount = r58_month_amount;
	}
	public BigDecimal getR58_6month_amount() {
		return r58_6month_amount;
	}
	public void setR58_6month_amount(BigDecimal r58_6month_amount) {
		this.r58_6month_amount = r58_6month_amount;
	}
	public BigDecimal getR58_year_amount() {
		return r58_year_amount;
	}
	public void setR58_year_amount(BigDecimal r58_year_amount) {
		this.r58_year_amount = r58_year_amount;
	}
	public BigDecimal getR58_month_factor() {
		return r58_month_factor;
	}
	public void setR58_month_factor(BigDecimal r58_month_factor) {
		this.r58_month_factor = r58_month_factor;
	}
	public BigDecimal getR58_6month_factor() {
		return r58_6month_factor;
	}
	public void setR58_6month_factor(BigDecimal r58_6month_factor) {
		this.r58_6month_factor = r58_6month_factor;
	}
	public BigDecimal getR58_year_factor() {
		return r58_year_factor;
	}
	public void setR58_year_factor(BigDecimal r58_year_factor) {
		this.r58_year_factor = r58_year_factor;
	}
	public BigDecimal getR58_month_calculated() {
		return r58_month_calculated;
	}
	public void setR58_month_calculated(BigDecimal r58_month_calculated) {
		this.r58_month_calculated = r58_month_calculated;
	}
	public BigDecimal getR58_6month_calculated() {
		return r58_6month_calculated;
	}
	public void setR58_6month_calculated(BigDecimal r58_6month_calculated) {
		this.r58_6month_calculated = r58_6month_calculated;
	}
	public BigDecimal getR58_year_calculated() {
		return r58_year_calculated;
	}
	public void setR58_year_calculated(BigDecimal r58_year_calculated) {
		this.r58_year_calculated = r58_year_calculated;
	}
	public BigDecimal getR58_total_asf() {
		return r58_total_asf;
	}
	public void setR58_total_asf(BigDecimal r58_total_asf) {
		this.r58_total_asf = r58_total_asf;
	}
	public String getR59_product() {
		return r59_product;
	}
	public void setR59_product(String r59_product) {
		this.r59_product = r59_product;
	}
	public BigDecimal getR59_6month_factor() {
		return r59_6month_factor;
	}
	public void setR59_6month_factor(BigDecimal r59_6month_factor) {
		this.r59_6month_factor = r59_6month_factor;
	}
	public BigDecimal getR59_year_factor() {
		return r59_year_factor;
	}
	public void setR59_year_factor(BigDecimal r59_year_factor) {
		this.r59_year_factor = r59_year_factor;
	}
	public BigDecimal getR59_6month_calculated() {
		return r59_6month_calculated;
	}
	public void setR59_6month_calculated(BigDecimal r59_6month_calculated) {
		this.r59_6month_calculated = r59_6month_calculated;
	}
	public BigDecimal getR59_year_calculated() {
		return r59_year_calculated;
	}
	public void setR59_year_calculated(BigDecimal r59_year_calculated) {
		this.r59_year_calculated = r59_year_calculated;
	}
	public BigDecimal getR59_total_asf() {
		return r59_total_asf;
	}
	public void setR59_total_asf(BigDecimal r59_total_asf) {
		this.r59_total_asf = r59_total_asf;
	}
	public String getR60_product() {
		return r60_product;
	}
	public void setR60_product(String r60_product) {
		this.r60_product = r60_product;
	}
	public BigDecimal getR60_year_amount() {
		return r60_year_amount;
	}
	public void setR60_year_amount(BigDecimal r60_year_amount) {
		this.r60_year_amount = r60_year_amount;
	}
	public BigDecimal getR60_year_factor() {
		return r60_year_factor;
	}
	public void setR60_year_factor(BigDecimal r60_year_factor) {
		this.r60_year_factor = r60_year_factor;
	}
	public BigDecimal getR60_year_calculated() {
		return r60_year_calculated;
	}
	public void setR60_year_calculated(BigDecimal r60_year_calculated) {
		this.r60_year_calculated = r60_year_calculated;
	}
	public BigDecimal getR60_total_asf() {
		return r60_total_asf;
	}
	public void setR60_total_asf(BigDecimal r60_total_asf) {
		this.r60_total_asf = r60_total_asf;
	}
	public String getR62_product() {
		return r62_product;
	}
	public void setR62_product(String r62_product) {
		this.r62_product = r62_product;
	}
	public BigDecimal getR62_month_amount() {
		return r62_month_amount;
	}
	public void setR62_month_amount(BigDecimal r62_month_amount) {
		this.r62_month_amount = r62_month_amount;
	}
	public BigDecimal getR62_6month_amount() {
		return r62_6month_amount;
	}
	public void setR62_6month_amount(BigDecimal r62_6month_amount) {
		this.r62_6month_amount = r62_6month_amount;
	}
	public BigDecimal getR62_year_amount() {
		return r62_year_amount;
	}
	public void setR62_year_amount(BigDecimal r62_year_amount) {
		this.r62_year_amount = r62_year_amount;
	}
	public BigDecimal getR62_month_factor() {
		return r62_month_factor;
	}
	public void setR62_month_factor(BigDecimal r62_month_factor) {
		this.r62_month_factor = r62_month_factor;
	}
	public BigDecimal getR62_6month_factor() {
		return r62_6month_factor;
	}
	public void setR62_6month_factor(BigDecimal r62_6month_factor) {
		this.r62_6month_factor = r62_6month_factor;
	}
	public BigDecimal getR62_year_factor() {
		return r62_year_factor;
	}
	public void setR62_year_factor(BigDecimal r62_year_factor) {
		this.r62_year_factor = r62_year_factor;
	}
	public BigDecimal getR62_month_calculated() {
		return r62_month_calculated;
	}
	public void setR62_month_calculated(BigDecimal r62_month_calculated) {
		this.r62_month_calculated = r62_month_calculated;
	}
	public BigDecimal getR62_6month_calculated() {
		return r62_6month_calculated;
	}
	public void setR62_6month_calculated(BigDecimal r62_6month_calculated) {
		this.r62_6month_calculated = r62_6month_calculated;
	}
	public BigDecimal getR62_year_calculated() {
		return r62_year_calculated;
	}
	public void setR62_year_calculated(BigDecimal r62_year_calculated) {
		this.r62_year_calculated = r62_year_calculated;
	}
	public BigDecimal getR62_total_asf() {
		return r62_total_asf;
	}
	public void setR62_total_asf(BigDecimal r62_total_asf) {
		this.r62_total_asf = r62_total_asf;
	}
	public String getR63_product() {
		return r63_product;
	}
	public void setR63_product(String r63_product) {
		this.r63_product = r63_product;
	}
	public BigDecimal getR63_month_amount() {
		return r63_month_amount;
	}
	public void setR63_month_amount(BigDecimal r63_month_amount) {
		this.r63_month_amount = r63_month_amount;
	}
	public BigDecimal getR63_month_factor() {
		return r63_month_factor;
	}
	public void setR63_month_factor(BigDecimal r63_month_factor) {
		this.r63_month_factor = r63_month_factor;
	}
	public BigDecimal getR63_month_calculated() {
		return r63_month_calculated;
	}
	public void setR63_month_calculated(BigDecimal r63_month_calculated) {
		this.r63_month_calculated = r63_month_calculated;
	}
	public BigDecimal getR63_total_asf() {
		return r63_total_asf;
	}
	public void setR63_total_asf(BigDecimal r63_total_asf) {
		this.r63_total_asf = r63_total_asf;
	}
	public String getR64_product() {
		return r64_product;
	}
	public void setR64_product(String r64_product) {
		this.r64_product = r64_product;
	}
	public BigDecimal getR64_6month_amount() {
		return r64_6month_amount;
	}
	public void setR64_6month_amount(BigDecimal r64_6month_amount) {
		this.r64_6month_amount = r64_6month_amount;
	}
	public BigDecimal getR64_6month_factor() {
		return r64_6month_factor;
	}
	public void setR64_6month_factor(BigDecimal r64_6month_factor) {
		this.r64_6month_factor = r64_6month_factor;
	}
	public BigDecimal getR64_6month_calculated() {
		return r64_6month_calculated;
	}
	public void setR64_6month_calculated(BigDecimal r64_6month_calculated) {
		this.r64_6month_calculated = r64_6month_calculated;
	}
	public BigDecimal getR64_total_asf() {
		return r64_total_asf;
	}
	public void setR64_total_asf(BigDecimal r64_total_asf) {
		this.r64_total_asf = r64_total_asf;
	}
	public String getR65_product() {
		return r65_product;
	}
	public void setR65_product(String r65_product) {
		this.r65_product = r65_product;
	}
	public BigDecimal getR65_year_amount() {
		return r65_year_amount;
	}
	public void setR65_year_amount(BigDecimal r65_year_amount) {
		this.r65_year_amount = r65_year_amount;
	}
	public BigDecimal getR65_year_factor() {
		return r65_year_factor;
	}
	public void setR65_year_factor(BigDecimal r65_year_factor) {
		this.r65_year_factor = r65_year_factor;
	}
	public BigDecimal getR65_year_calculated() {
		return r65_year_calculated;
	}
	public void setR65_year_calculated(BigDecimal r65_year_calculated) {
		this.r65_year_calculated = r65_year_calculated;
	}
	public BigDecimal getR65_total_asf() {
		return r65_total_asf;
	}
	public void setR65_total_asf(BigDecimal r65_total_asf) {
		this.r65_total_asf = r65_total_asf;
	}
	public String getR68_product() {
		return r68_product;
	}
	public void setR68_product(String r68_product) {
		this.r68_product = r68_product;
	}
	public BigDecimal getR68_month_amount() {
		return r68_month_amount;
	}
	public void setR68_month_amount(BigDecimal r68_month_amount) {
		this.r68_month_amount = r68_month_amount;
	}
	public BigDecimal getR68_6month_amount() {
		return r68_6month_amount;
	}
	public void setR68_6month_amount(BigDecimal r68_6month_amount) {
		this.r68_6month_amount = r68_6month_amount;
	}
	public BigDecimal getR68_year_amount() {
		return r68_year_amount;
	}
	public void setR68_year_amount(BigDecimal r68_year_amount) {
		this.r68_year_amount = r68_year_amount;
	}
	public BigDecimal getR68_month_factor() {
		return r68_month_factor;
	}
	public void setR68_month_factor(BigDecimal r68_month_factor) {
		this.r68_month_factor = r68_month_factor;
	}
	public BigDecimal getR68_6month_factor() {
		return r68_6month_factor;
	}
	public void setR68_6month_factor(BigDecimal r68_6month_factor) {
		this.r68_6month_factor = r68_6month_factor;
	}
	public BigDecimal getR68_year_factor() {
		return r68_year_factor;
	}
	public void setR68_year_factor(BigDecimal r68_year_factor) {
		this.r68_year_factor = r68_year_factor;
	}
	public BigDecimal getR68_month_calculated() {
		return r68_month_calculated;
	}
	public void setR68_month_calculated(BigDecimal r68_month_calculated) {
		this.r68_month_calculated = r68_month_calculated;
	}
	public BigDecimal getR68_6month_calculated() {
		return r68_6month_calculated;
	}
	public void setR68_6month_calculated(BigDecimal r68_6month_calculated) {
		this.r68_6month_calculated = r68_6month_calculated;
	}
	public BigDecimal getR68_year_calculated() {
		return r68_year_calculated;
	}
	public void setR68_year_calculated(BigDecimal r68_year_calculated) {
		this.r68_year_calculated = r68_year_calculated;
	}
	public BigDecimal getR68_total_asf() {
		return r68_total_asf;
	}
	public void setR68_total_asf(BigDecimal r68_total_asf) {
		this.r68_total_asf = r68_total_asf;
	}
	public String getR69_product() {
		return r69_product;
	}
	public void setR69_product(String r69_product) {
		this.r69_product = r69_product;
	}
	public BigDecimal getR69_month_amount() {
		return r69_month_amount;
	}
	public void setR69_month_amount(BigDecimal r69_month_amount) {
		this.r69_month_amount = r69_month_amount;
	}
	public BigDecimal getR69_month_factor() {
		return r69_month_factor;
	}
	public void setR69_month_factor(BigDecimal r69_month_factor) {
		this.r69_month_factor = r69_month_factor;
	}
	public BigDecimal getR69_month_calculated() {
		return r69_month_calculated;
	}
	public void setR69_month_calculated(BigDecimal r69_month_calculated) {
		this.r69_month_calculated = r69_month_calculated;
	}
	public BigDecimal getR69_total_asf() {
		return r69_total_asf;
	}
	public void setR69_total_asf(BigDecimal r69_total_asf) {
		this.r69_total_asf = r69_total_asf;
	}
	public String getR70_product() {
		return r70_product;
	}
	public void setR70_product(String r70_product) {
		this.r70_product = r70_product;
	}
	public BigDecimal getR70_6month_amount() {
		return r70_6month_amount;
	}
	public void setR70_6month_amount(BigDecimal r70_6month_amount) {
		this.r70_6month_amount = r70_6month_amount;
	}
	public BigDecimal getR70_6month_factor() {
		return r70_6month_factor;
	}
	public void setR70_6month_factor(BigDecimal r70_6month_factor) {
		this.r70_6month_factor = r70_6month_factor;
	}
	public BigDecimal getR70_6month_calculated() {
		return r70_6month_calculated;
	}
	public void setR70_6month_calculated(BigDecimal r70_6month_calculated) {
		this.r70_6month_calculated = r70_6month_calculated;
	}
	public BigDecimal getR70_total_asf() {
		return r70_total_asf;
	}
	public void setR70_total_asf(BigDecimal r70_total_asf) {
		this.r70_total_asf = r70_total_asf;
	}
	public String getR71_product() {
		return r71_product;
	}
	public void setR71_product(String r71_product) {
		this.r71_product = r71_product;
	}
	public BigDecimal getR71_year_amount() {
		return r71_year_amount;
	}
	public void setR71_year_amount(BigDecimal r71_year_amount) {
		this.r71_year_amount = r71_year_amount;
	}
	public BigDecimal getR71_year_factor() {
		return r71_year_factor;
	}
	public void setR71_year_factor(BigDecimal r71_year_factor) {
		this.r71_year_factor = r71_year_factor;
	}
	public BigDecimal getR71_year_calculated() {
		return r71_year_calculated;
	}
	public void setR71_year_calculated(BigDecimal r71_year_calculated) {
		this.r71_year_calculated = r71_year_calculated;
	}
	public BigDecimal getR71_total_asf() {
		return r71_total_asf;
	}
	public void setR71_total_asf(BigDecimal r71_total_asf) {
		this.r71_total_asf = r71_total_asf;
	}
	public String getR73_product() {
		return r73_product;
	}
	public void setR73_product(String r73_product) {
		this.r73_product = r73_product;
	}
	public BigDecimal getR73_month_amount() {
		return r73_month_amount;
	}
	public void setR73_month_amount(BigDecimal r73_month_amount) {
		this.r73_month_amount = r73_month_amount;
	}
	public BigDecimal getR73_6month_amount() {
		return r73_6month_amount;
	}
	public void setR73_6month_amount(BigDecimal r73_6month_amount) {
		this.r73_6month_amount = r73_6month_amount;
	}
	public BigDecimal getR73_year_amount() {
		return r73_year_amount;
	}
	public void setR73_year_amount(BigDecimal r73_year_amount) {
		this.r73_year_amount = r73_year_amount;
	}
	public BigDecimal getR73_month_factor() {
		return r73_month_factor;
	}
	public void setR73_month_factor(BigDecimal r73_month_factor) {
		this.r73_month_factor = r73_month_factor;
	}
	public BigDecimal getR73_6month_factor() {
		return r73_6month_factor;
	}
	public void setR73_6month_factor(BigDecimal r73_6month_factor) {
		this.r73_6month_factor = r73_6month_factor;
	}
	public BigDecimal getR73_year_factor() {
		return r73_year_factor;
	}
	public void setR73_year_factor(BigDecimal r73_year_factor) {
		this.r73_year_factor = r73_year_factor;
	}
	public BigDecimal getR73_month_calculated() {
		return r73_month_calculated;
	}
	public void setR73_month_calculated(BigDecimal r73_month_calculated) {
		this.r73_month_calculated = r73_month_calculated;
	}
	public BigDecimal getR73_6month_calculated() {
		return r73_6month_calculated;
	}
	public void setR73_6month_calculated(BigDecimal r73_6month_calculated) {
		this.r73_6month_calculated = r73_6month_calculated;
	}
	public BigDecimal getR73_year_calculated() {
		return r73_year_calculated;
	}
	public void setR73_year_calculated(BigDecimal r73_year_calculated) {
		this.r73_year_calculated = r73_year_calculated;
	}
	public BigDecimal getR73_total_asf() {
		return r73_total_asf;
	}
	public void setR73_total_asf(BigDecimal r73_total_asf) {
		this.r73_total_asf = r73_total_asf;
	}
	public String getR74_product() {
		return r74_product;
	}
	public void setR74_product(String r74_product) {
		this.r74_product = r74_product;
	}
	public BigDecimal getR74_month_amount() {
		return r74_month_amount;
	}
	public void setR74_month_amount(BigDecimal r74_month_amount) {
		this.r74_month_amount = r74_month_amount;
	}
	public BigDecimal getR74_month_factor() {
		return r74_month_factor;
	}
	public void setR74_month_factor(BigDecimal r74_month_factor) {
		this.r74_month_factor = r74_month_factor;
	}
	public BigDecimal getR74_month_calculated() {
		return r74_month_calculated;
	}
	public void setR74_month_calculated(BigDecimal r74_month_calculated) {
		this.r74_month_calculated = r74_month_calculated;
	}
	public BigDecimal getR74_total_asf() {
		return r74_total_asf;
	}
	public void setR74_total_asf(BigDecimal r74_total_asf) {
		this.r74_total_asf = r74_total_asf;
	}
	public String getR75_product() {
		return r75_product;
	}
	public void setR75_product(String r75_product) {
		this.r75_product = r75_product;
	}
	public BigDecimal getR75_6month_amount() {
		return r75_6month_amount;
	}
	public void setR75_6month_amount(BigDecimal r75_6month_amount) {
		this.r75_6month_amount = r75_6month_amount;
	}
	public BigDecimal getR75_6month_factor() {
		return r75_6month_factor;
	}
	public void setR75_6month_factor(BigDecimal r75_6month_factor) {
		this.r75_6month_factor = r75_6month_factor;
	}
	public BigDecimal getR75_6month_calculated() {
		return r75_6month_calculated;
	}
	public void setR75_6month_calculated(BigDecimal r75_6month_calculated) {
		this.r75_6month_calculated = r75_6month_calculated;
	}
	public BigDecimal getR75_total_asf() {
		return r75_total_asf;
	}
	public void setR75_total_asf(BigDecimal r75_total_asf) {
		this.r75_total_asf = r75_total_asf;
	}
	public String getR76_product() {
		return r76_product;
	}
	public void setR76_product(String r76_product) {
		this.r76_product = r76_product;
	}
	public BigDecimal getR76_year_amount() {
		return r76_year_amount;
	}
	public void setR76_year_amount(BigDecimal r76_year_amount) {
		this.r76_year_amount = r76_year_amount;
	}
	public BigDecimal getR76_year_factor() {
		return r76_year_factor;
	}
	public void setR76_year_factor(BigDecimal r76_year_factor) {
		this.r76_year_factor = r76_year_factor;
	}
	public BigDecimal getR76_year_calculated() {
		return r76_year_calculated;
	}
	public void setR76_year_calculated(BigDecimal r76_year_calculated) {
		this.r76_year_calculated = r76_year_calculated;
	}
	public BigDecimal getR76_total_asf() {
		return r76_total_asf;
	}
	public void setR76_total_asf(BigDecimal r76_total_asf) {
		this.r76_total_asf = r76_total_asf;
	}
	public String getR79_product() {
		return r79_product;
	}
	public void setR79_product(String r79_product) {
		this.r79_product = r79_product;
	}
	public BigDecimal getR79_month_amount() {
		return r79_month_amount;
	}
	public void setR79_month_amount(BigDecimal r79_month_amount) {
		this.r79_month_amount = r79_month_amount;
	}
	public BigDecimal getR79_6month_amount() {
		return r79_6month_amount;
	}
	public void setR79_6month_amount(BigDecimal r79_6month_amount) {
		this.r79_6month_amount = r79_6month_amount;
	}
	public BigDecimal getR79_year_amount() {
		return r79_year_amount;
	}
	public void setR79_year_amount(BigDecimal r79_year_amount) {
		this.r79_year_amount = r79_year_amount;
	}
	public BigDecimal getR79_month_factor() {
		return r79_month_factor;
	}
	public void setR79_month_factor(BigDecimal r79_month_factor) {
		this.r79_month_factor = r79_month_factor;
	}
	public BigDecimal getR79_6month_factor() {
		return r79_6month_factor;
	}
	public void setR79_6month_factor(BigDecimal r79_6month_factor) {
		this.r79_6month_factor = r79_6month_factor;
	}
	public BigDecimal getR79_year_factor() {
		return r79_year_factor;
	}
	public void setR79_year_factor(BigDecimal r79_year_factor) {
		this.r79_year_factor = r79_year_factor;
	}
	public BigDecimal getR79_month_calculated() {
		return r79_month_calculated;
	}
	public void setR79_month_calculated(BigDecimal r79_month_calculated) {
		this.r79_month_calculated = r79_month_calculated;
	}
	public BigDecimal getR79_6month_calculated() {
		return r79_6month_calculated;
	}
	public void setR79_6month_calculated(BigDecimal r79_6month_calculated) {
		this.r79_6month_calculated = r79_6month_calculated;
	}
	public BigDecimal getR79_year_calculated() {
		return r79_year_calculated;
	}
	public void setR79_year_calculated(BigDecimal r79_year_calculated) {
		this.r79_year_calculated = r79_year_calculated;
	}
	public BigDecimal getR79_total_asf() {
		return r79_total_asf;
	}
	public void setR79_total_asf(BigDecimal r79_total_asf) {
		this.r79_total_asf = r79_total_asf;
	}
	public String getR80_product() {
		return r80_product;
	}
	public void setR80_product(String r80_product) {
		this.r80_product = r80_product;
	}
	public BigDecimal getR80_month_amount() {
		return r80_month_amount;
	}
	public void setR80_month_amount(BigDecimal r80_month_amount) {
		this.r80_month_amount = r80_month_amount;
	}
	public BigDecimal getR80_month_factor() {
		return r80_month_factor;
	}
	public void setR80_month_factor(BigDecimal r80_month_factor) {
		this.r80_month_factor = r80_month_factor;
	}
	public BigDecimal getR80_month_calculated() {
		return r80_month_calculated;
	}
	public void setR80_month_calculated(BigDecimal r80_month_calculated) {
		this.r80_month_calculated = r80_month_calculated;
	}
	public BigDecimal getR80_total_asf() {
		return r80_total_asf;
	}
	public void setR80_total_asf(BigDecimal r80_total_asf) {
		this.r80_total_asf = r80_total_asf;
	}
	public String getR81_product() {
		return r81_product;
	}
	public void setR81_product(String r81_product) {
		this.r81_product = r81_product;
	}
	public BigDecimal getR81_6month_amount() {
		return r81_6month_amount;
	}
	public void setR81_6month_amount(BigDecimal r81_6month_amount) {
		this.r81_6month_amount = r81_6month_amount;
	}
	public BigDecimal getR81_6month_factor() {
		return r81_6month_factor;
	}
	public void setR81_6month_factor(BigDecimal r81_6month_factor) {
		this.r81_6month_factor = r81_6month_factor;
	}
	public BigDecimal getR81_6month_calculated() {
		return r81_6month_calculated;
	}
	public void setR81_6month_calculated(BigDecimal r81_6month_calculated) {
		this.r81_6month_calculated = r81_6month_calculated;
	}
	public BigDecimal getR81_total_asf() {
		return r81_total_asf;
	}
	public void setR81_total_asf(BigDecimal r81_total_asf) {
		this.r81_total_asf = r81_total_asf;
	}
	public String getR82_product() {
		return r82_product;
	}
	public void setR82_product(String r82_product) {
		this.r82_product = r82_product;
	}
	public BigDecimal getR82_year_amount() {
		return r82_year_amount;
	}
	public void setR82_year_amount(BigDecimal r82_year_amount) {
		this.r82_year_amount = r82_year_amount;
	}
	public BigDecimal getR82_year_factor() {
		return r82_year_factor;
	}
	public void setR82_year_factor(BigDecimal r82_year_factor) {
		this.r82_year_factor = r82_year_factor;
	}
	public BigDecimal getR82_year_calculated() {
		return r82_year_calculated;
	}
	public void setR82_year_calculated(BigDecimal r82_year_calculated) {
		this.r82_year_calculated = r82_year_calculated;
	}
	public BigDecimal getR82_total_asf() {
		return r82_total_asf;
	}
	public void setR82_total_asf(BigDecimal r82_total_asf) {
		this.r82_total_asf = r82_total_asf;
	}
	public String getR84_product() {
		return r84_product;
	}
	public void setR84_product(String r84_product) {
		this.r84_product = r84_product;
	}
	public BigDecimal getR84_year_factor() {
		return r84_year_factor;
	}
	public void setR84_year_factor(BigDecimal r84_year_factor) {
		this.r84_year_factor = r84_year_factor;
	}
	public BigDecimal getR84_year_calculated() {
		return r84_year_calculated;
	}
	public void setR84_year_calculated(BigDecimal r84_year_calculated) {
		this.r84_year_calculated = r84_year_calculated;
	}
	public BigDecimal getR84_total_asf() {
		return r84_total_asf;
	}
	public void setR84_total_asf(BigDecimal r84_total_asf) {
		this.r84_total_asf = r84_total_asf;
	}
	public String getR85_product() {
		return r85_product;
	}
	public void setR85_product(String r85_product) {
		this.r85_product = r85_product;
	}
	public BigDecimal getR85_year_factor() {
		return r85_year_factor;
	}
	public void setR85_year_factor(BigDecimal r85_year_factor) {
		this.r85_year_factor = r85_year_factor;
	}
	public BigDecimal getR85_year_calculated() {
		return r85_year_calculated;
	}
	public void setR85_year_calculated(BigDecimal r85_year_calculated) {
		this.r85_year_calculated = r85_year_calculated;
	}
	public BigDecimal getR85_total_asf() {
		return r85_total_asf;
	}
	public void setR85_total_asf(BigDecimal r85_total_asf) {
		this.r85_total_asf = r85_total_asf;
	}
	public String getR86_product() {
		return r86_product;
	}
	public void setR86_product(String r86_product) {
		this.r86_product = r86_product;
	}
	public BigDecimal getR86_year_factor() {
		return r86_year_factor;
	}
	public void setR86_year_factor(BigDecimal r86_year_factor) {
		this.r86_year_factor = r86_year_factor;
	}
	public BigDecimal getR86_year_calculated() {
		return r86_year_calculated;
	}
	public void setR86_year_calculated(BigDecimal r86_year_calculated) {
		this.r86_year_calculated = r86_year_calculated;
	}
	public BigDecimal getR86_total_asf() {
		return r86_total_asf;
	}
	public void setR86_total_asf(BigDecimal r86_total_asf) {
		this.r86_total_asf = r86_total_asf;
	}
	public String getR87_product() {
		return r87_product;
	}
	public void setR87_product(String r87_product) {
		this.r87_product = r87_product;
	}
	public BigDecimal getR87_year_factor() {
		return r87_year_factor;
	}
	public void setR87_year_factor(BigDecimal r87_year_factor) {
		this.r87_year_factor = r87_year_factor;
	}
	public BigDecimal getR87_year_calculated() {
		return r87_year_calculated;
	}
	public void setR87_year_calculated(BigDecimal r87_year_calculated) {
		this.r87_year_calculated = r87_year_calculated;
	}
	public BigDecimal getR87_total_asf() {
		return r87_total_asf;
	}
	public void setR87_total_asf(BigDecimal r87_total_asf) {
		this.r87_total_asf = r87_total_asf;
	}
	public String getR89_product() {
		return r89_product;
	}
	public void setR89_product(String r89_product) {
		this.r89_product = r89_product;
	}
	public BigDecimal getR89_month_amount() {
		return r89_month_amount;
	}
	public void setR89_month_amount(BigDecimal r89_month_amount) {
		this.r89_month_amount = r89_month_amount;
	}
	public BigDecimal getR89_6month_amount() {
		return r89_6month_amount;
	}
	public void setR89_6month_amount(BigDecimal r89_6month_amount) {
		this.r89_6month_amount = r89_6month_amount;
	}
	public BigDecimal getR89_year_amount() {
		return r89_year_amount;
	}
	public void setR89_year_amount(BigDecimal r89_year_amount) {
		this.r89_year_amount = r89_year_amount;
	}
	public BigDecimal getR89_month_factor() {
		return r89_month_factor;
	}
	public void setR89_month_factor(BigDecimal r89_month_factor) {
		this.r89_month_factor = r89_month_factor;
	}
	public BigDecimal getR89_6month_factor() {
		return r89_6month_factor;
	}
	public void setR89_6month_factor(BigDecimal r89_6month_factor) {
		this.r89_6month_factor = r89_6month_factor;
	}
	public BigDecimal getR89_year_factor() {
		return r89_year_factor;
	}
	public void setR89_year_factor(BigDecimal r89_year_factor) {
		this.r89_year_factor = r89_year_factor;
	}
	public BigDecimal getR89_month_calculated() {
		return r89_month_calculated;
	}
	public void setR89_month_calculated(BigDecimal r89_month_calculated) {
		this.r89_month_calculated = r89_month_calculated;
	}
	public BigDecimal getR89_6month_calculated() {
		return r89_6month_calculated;
	}
	public void setR89_6month_calculated(BigDecimal r89_6month_calculated) {
		this.r89_6month_calculated = r89_6month_calculated;
	}
	public BigDecimal getR89_year_calculated() {
		return r89_year_calculated;
	}
	public void setR89_year_calculated(BigDecimal r89_year_calculated) {
		this.r89_year_calculated = r89_year_calculated;
	}
	public BigDecimal getR89_total_asf() {
		return r89_total_asf;
	}
	public void setR89_total_asf(BigDecimal r89_total_asf) {
		this.r89_total_asf = r89_total_asf;
	}
	public String getR90_product() {
		return r90_product;
	}
	public void setR90_product(String r90_product) {
		this.r90_product = r90_product;
	}
	public BigDecimal getR90_month_amount() {
		return r90_month_amount;
	}
	public void setR90_month_amount(BigDecimal r90_month_amount) {
		this.r90_month_amount = r90_month_amount;
	}
	public BigDecimal getR90_month_factor() {
		return r90_month_factor;
	}
	public void setR90_month_factor(BigDecimal r90_month_factor) {
		this.r90_month_factor = r90_month_factor;
	}
	public BigDecimal getR90_month_calculated() {
		return r90_month_calculated;
	}
	public void setR90_month_calculated(BigDecimal r90_month_calculated) {
		this.r90_month_calculated = r90_month_calculated;
	}
	public BigDecimal getR90_total_asf() {
		return r90_total_asf;
	}
	public void setR90_total_asf(BigDecimal r90_total_asf) {
		this.r90_total_asf = r90_total_asf;
	}
	public String getR91_product() {
		return r91_product;
	}
	public void setR91_product(String r91_product) {
		this.r91_product = r91_product;
	}
	public BigDecimal getR91_6month_amount() {
		return r91_6month_amount;
	}
	public void setR91_6month_amount(BigDecimal r91_6month_amount) {
		this.r91_6month_amount = r91_6month_amount;
	}
	public BigDecimal getR91_6month_factor() {
		return r91_6month_factor;
	}
	public void setR91_6month_factor(BigDecimal r91_6month_factor) {
		this.r91_6month_factor = r91_6month_factor;
	}
	public BigDecimal getR91_6month_calculated() {
		return r91_6month_calculated;
	}
	public void setR91_6month_calculated(BigDecimal r91_6month_calculated) {
		this.r91_6month_calculated = r91_6month_calculated;
	}
	public BigDecimal getR91_total_asf() {
		return r91_total_asf;
	}
	public void setR91_total_asf(BigDecimal r91_total_asf) {
		this.r91_total_asf = r91_total_asf;
	}
	public String getR93_product() {
		return r93_product;
	}
	public void setR93_product(String r93_product) {
		this.r93_product = r93_product;
	}
	public BigDecimal getR93_year_amount() {
		return r93_year_amount;
	}
	public void setR93_year_amount(BigDecimal r93_year_amount) {
		this.r93_year_amount = r93_year_amount;
	}
	public BigDecimal getR93_month_factor() {
		return r93_month_factor;
	}
	public void setR93_month_factor(BigDecimal r93_month_factor) {
		this.r93_month_factor = r93_month_factor;
	}
	public BigDecimal getR93_6month_factor() {
		return r93_6month_factor;
	}
	public void setR93_6month_factor(BigDecimal r93_6month_factor) {
		this.r93_6month_factor = r93_6month_factor;
	}
	public BigDecimal getR93_year_factor() {
		return r93_year_factor;
	}
	public void setR93_year_factor(BigDecimal r93_year_factor) {
		this.r93_year_factor = r93_year_factor;
	}
	public BigDecimal getR93_month_calculated() {
		return r93_month_calculated;
	}
	public void setR93_month_calculated(BigDecimal r93_month_calculated) {
		this.r93_month_calculated = r93_month_calculated;
	}
	public BigDecimal getR93_6month_calculated() {
		return r93_6month_calculated;
	}
	public void setR93_6month_calculated(BigDecimal r93_6month_calculated) {
		this.r93_6month_calculated = r93_6month_calculated;
	}
	public BigDecimal getR93_year_calculated() {
		return r93_year_calculated;
	}
	public void setR93_year_calculated(BigDecimal r93_year_calculated) {
		this.r93_year_calculated = r93_year_calculated;
	}
	public BigDecimal getR93_total_asf() {
		return r93_total_asf;
	}
	public void setR93_total_asf(BigDecimal r93_total_asf) {
		this.r93_total_asf = r93_total_asf;
	}
	public String getR94_product() {
		return r94_product;
	}
	public void setR94_product(String r94_product) {
		this.r94_product = r94_product;
	}
	public BigDecimal getR94_month_amount() {
		return r94_month_amount;
	}
	public void setR94_month_amount(BigDecimal r94_month_amount) {
		this.r94_month_amount = r94_month_amount;
	}
	public BigDecimal getR94_6month_amount() {
		return r94_6month_amount;
	}
	public void setR94_6month_amount(BigDecimal r94_6month_amount) {
		this.r94_6month_amount = r94_6month_amount;
	}
	public BigDecimal getR94_year_amount() {
		return r94_year_amount;
	}
	public void setR94_year_amount(BigDecimal r94_year_amount) {
		this.r94_year_amount = r94_year_amount;
	}
	public BigDecimal getR94_month_factor() {
		return r94_month_factor;
	}
	public void setR94_month_factor(BigDecimal r94_month_factor) {
		this.r94_month_factor = r94_month_factor;
	}
	public BigDecimal getR94_6month_factor() {
		return r94_6month_factor;
	}
	public void setR94_6month_factor(BigDecimal r94_6month_factor) {
		this.r94_6month_factor = r94_6month_factor;
	}
	public BigDecimal getR94_year_factor() {
		return r94_year_factor;
	}
	public void setR94_year_factor(BigDecimal r94_year_factor) {
		this.r94_year_factor = r94_year_factor;
	}
	public BigDecimal getR94_month_calculated() {
		return r94_month_calculated;
	}
	public void setR94_month_calculated(BigDecimal r94_month_calculated) {
		this.r94_month_calculated = r94_month_calculated;
	}
	public BigDecimal getR94_6month_calculated() {
		return r94_6month_calculated;
	}
	public void setR94_6month_calculated(BigDecimal r94_6month_calculated) {
		this.r94_6month_calculated = r94_6month_calculated;
	}
	public BigDecimal getR94_year_calculated() {
		return r94_year_calculated;
	}
	public void setR94_year_calculated(BigDecimal r94_year_calculated) {
		this.r94_year_calculated = r94_year_calculated;
	}
	public BigDecimal getR94_total_asf() {
		return r94_total_asf;
	}
	public void setR94_total_asf(BigDecimal r94_total_asf) {
		this.r94_total_asf = r94_total_asf;
	}
	public String getR95_product() {
		return r95_product;
	}
	public void setR95_product(String r95_product) {
		this.r95_product = r95_product;
	}
	public BigDecimal getR95_6month_amount() {
		return r95_6month_amount;
	}
	public void setR95_6month_amount(BigDecimal r95_6month_amount) {
		this.r95_6month_amount = r95_6month_amount;
	}
	public BigDecimal getR95_year_amount() {
		return r95_year_amount;
	}
	public void setR95_year_amount(BigDecimal r95_year_amount) {
		this.r95_year_amount = r95_year_amount;
	}
	public BigDecimal getR95_6month_factor() {
		return r95_6month_factor;
	}
	public void setR95_6month_factor(BigDecimal r95_6month_factor) {
		this.r95_6month_factor = r95_6month_factor;
	}
	public BigDecimal getR95_year_factor() {
		return r95_year_factor;
	}
	public void setR95_year_factor(BigDecimal r95_year_factor) {
		this.r95_year_factor = r95_year_factor;
	}
	public BigDecimal getR95_6month_calculated() {
		return r95_6month_calculated;
	}
	public void setR95_6month_calculated(BigDecimal r95_6month_calculated) {
		this.r95_6month_calculated = r95_6month_calculated;
	}
	public BigDecimal getR95_year_calculated() {
		return r95_year_calculated;
	}
	public void setR95_year_calculated(BigDecimal r95_year_calculated) {
		this.r95_year_calculated = r95_year_calculated;
	}
	public BigDecimal getR95_total_asf() {
		return r95_total_asf;
	}
	public void setR95_total_asf(BigDecimal r95_total_asf) {
		this.r95_total_asf = r95_total_asf;
	}
	public String getR96_product() {
		return r96_product;
	}
	public void setR96_product(String r96_product) {
		this.r96_product = r96_product;
	}
	public BigDecimal getR96_6month_amount() {
		return r96_6month_amount;
	}
	public void setR96_6month_amount(BigDecimal r96_6month_amount) {
		this.r96_6month_amount = r96_6month_amount;
	}
	public BigDecimal getR96_year_amount() {
		return r96_year_amount;
	}
	public void setR96_year_amount(BigDecimal r96_year_amount) {
		this.r96_year_amount = r96_year_amount;
	}
	public BigDecimal getR96_6month_factor() {
		return r96_6month_factor;
	}
	public void setR96_6month_factor(BigDecimal r96_6month_factor) {
		this.r96_6month_factor = r96_6month_factor;
	}
	public BigDecimal getR96_year_factor() {
		return r96_year_factor;
	}
	public void setR96_year_factor(BigDecimal r96_year_factor) {
		this.r96_year_factor = r96_year_factor;
	}
	public BigDecimal getR96_6month_calculated() {
		return r96_6month_calculated;
	}
	public void setR96_6month_calculated(BigDecimal r96_6month_calculated) {
		this.r96_6month_calculated = r96_6month_calculated;
	}
	public BigDecimal getR96_year_calculated() {
		return r96_year_calculated;
	}
	public void setR96_year_calculated(BigDecimal r96_year_calculated) {
		this.r96_year_calculated = r96_year_calculated;
	}
	public BigDecimal getR96_total_asf() {
		return r96_total_asf;
	}
	public void setR96_total_asf(BigDecimal r96_total_asf) {
		this.r96_total_asf = r96_total_asf;
	}
	public String getR98_product() {
		return r98_product;
	}
	public void setR98_product(String r98_product) {
		this.r98_product = r98_product;
	}
	public BigDecimal getR98_months_amount() {
		return r98_months_amount;
	}
	public void setR98_months_amount(BigDecimal r98_months_amount) {
		this.r98_months_amount = r98_months_amount;
	}
	public BigDecimal getR98_6months_amount() {
		return r98_6months_amount;
	}
	public void setR98_6months_amount(BigDecimal r98_6months_amount) {
		this.r98_6months_amount = r98_6months_amount;
	}
	public BigDecimal getR98_year_amount() {
		return r98_year_amount;
	}
	public void setR98_year_amount(BigDecimal r98_year_amount) {
		this.r98_year_amount = r98_year_amount;
	}
	public BigDecimal getR98_months_factor() {
		return r98_months_factor;
	}
	public void setR98_months_factor(BigDecimal r98_months_factor) {
		this.r98_months_factor = r98_months_factor;
	}
	public BigDecimal getR98_6months_factor() {
		return r98_6months_factor;
	}
	public void setR98_6months_factor(BigDecimal r98_6months_factor) {
		this.r98_6months_factor = r98_6months_factor;
	}
	public BigDecimal getR98_year_factor() {
		return r98_year_factor;
	}
	public void setR98_year_factor(BigDecimal r98_year_factor) {
		this.r98_year_factor = r98_year_factor;
	}
	public BigDecimal getR98_months_calculated() {
		return r98_months_calculated;
	}
	public void setR98_months_calculated(BigDecimal r98_months_calculated) {
		this.r98_months_calculated = r98_months_calculated;
	}
	public BigDecimal getR98_6months_calculated() {
		return r98_6months_calculated;
	}
	public void setR98_6months_calculated(BigDecimal r98_6months_calculated) {
		this.r98_6months_calculated = r98_6months_calculated;
	}
	public BigDecimal getR98_year_calculated() {
		return r98_year_calculated;
	}
	public void setR98_year_calculated(BigDecimal r98_year_calculated) {
		this.r98_year_calculated = r98_year_calculated;
	}
	public BigDecimal getR98_total_asf() {
		return r98_total_asf;
	}
	public void setR98_total_asf(BigDecimal r98_total_asf) {
		this.r98_total_asf = r98_total_asf;
	}
	public String getR99_product() {
		return r99_product;
	}
	public void setR99_product(String r99_product) {
		this.r99_product = r99_product;
	}
	public BigDecimal getR99_month_amount() {
		return r99_month_amount;
	}
	public void setR99_month_amount(BigDecimal r99_month_amount) {
		this.r99_month_amount = r99_month_amount;
	}
	public BigDecimal getR99_6month_amount() {
		return r99_6month_amount;
	}
	public void setR99_6month_amount(BigDecimal r99_6month_amount) {
		this.r99_6month_amount = r99_6month_amount;
	}
	public BigDecimal getR99_year_amount() {
		return r99_year_amount;
	}
	public void setR99_year_amount(BigDecimal r99_year_amount) {
		this.r99_year_amount = r99_year_amount;
	}
	public BigDecimal getR99_month_factor() {
		return r99_month_factor;
	}
	public void setR99_month_factor(BigDecimal r99_month_factor) {
		this.r99_month_factor = r99_month_factor;
	}
	public BigDecimal getR99_6month_factor() {
		return r99_6month_factor;
	}
	public void setR99_6month_factor(BigDecimal r99_6month_factor) {
		this.r99_6month_factor = r99_6month_factor;
	}
	public BigDecimal getR99_year_factor() {
		return r99_year_factor;
	}
	public void setR99_year_factor(BigDecimal r99_year_factor) {
		this.r99_year_factor = r99_year_factor;
	}
	public BigDecimal getR99_month_calculated() {
		return r99_month_calculated;
	}
	public void setR99_month_calculated(BigDecimal r99_month_calculated) {
		this.r99_month_calculated = r99_month_calculated;
	}
	public BigDecimal getR99_6month_calculated() {
		return r99_6month_calculated;
	}
	public void setR99_6month_calculated(BigDecimal r99_6month_calculated) {
		this.r99_6month_calculated = r99_6month_calculated;
	}
	public BigDecimal getR99_year_calculated() {
		return r99_year_calculated;
	}
	public void setR99_year_calculated(BigDecimal r99_year_calculated) {
		this.r99_year_calculated = r99_year_calculated;
	}
	public BigDecimal getR99_total_asf() {
		return r99_total_asf;
	}
	public void setR99_total_asf(BigDecimal r99_total_asf) {
		this.r99_total_asf = r99_total_asf;
	}
	public String getR100_product() {
		return r100_product;
	}
	public void setR100_product(String r100_product) {
		this.r100_product = r100_product;
	}
	public BigDecimal getR100_6month_amount() {
		return r100_6month_amount;
	}
	public void setR100_6month_amount(BigDecimal r100_6month_amount) {
		this.r100_6month_amount = r100_6month_amount;
	}
	public BigDecimal getR100_year_amount() {
		return r100_year_amount;
	}
	public void setR100_year_amount(BigDecimal r100_year_amount) {
		this.r100_year_amount = r100_year_amount;
	}
	public BigDecimal getR100_6month_factor() {
		return r100_6month_factor;
	}
	public void setR100_6month_factor(BigDecimal r100_6month_factor) {
		this.r100_6month_factor = r100_6month_factor;
	}
	public BigDecimal getR100_year_factor() {
		return r100_year_factor;
	}
	public void setR100_year_factor(BigDecimal r100_year_factor) {
		this.r100_year_factor = r100_year_factor;
	}
	public BigDecimal getR100_6month_calculated() {
		return r100_6month_calculated;
	}
	public void setR100_6month_calculated(BigDecimal r100_6month_calculated) {
		this.r100_6month_calculated = r100_6month_calculated;
	}
	public BigDecimal getR100_year_calculated() {
		return r100_year_calculated;
	}
	public void setR100_year_calculated(BigDecimal r100_year_calculated) {
		this.r100_year_calculated = r100_year_calculated;
	}
	public BigDecimal getR100_total_asf() {
		return r100_total_asf;
	}
	public void setR100_total_asf(BigDecimal r100_total_asf) {
		this.r100_total_asf = r100_total_asf;
	}
	public String getR101_product() {
		return r101_product;
	}
	public void setR101_product(String r101_product) {
		this.r101_product = r101_product;
	}
	public BigDecimal getR101_6month_amount() {
		return r101_6month_amount;
	}
	public void setR101_6month_amount(BigDecimal r101_6month_amount) {
		this.r101_6month_amount = r101_6month_amount;
	}
	public BigDecimal getR101_year_amount() {
		return r101_year_amount;
	}
	public void setR101_year_amount(BigDecimal r101_year_amount) {
		this.r101_year_amount = r101_year_amount;
	}
	public BigDecimal getR101_6month_factor() {
		return r101_6month_factor;
	}
	public void setR101_6month_factor(BigDecimal r101_6month_factor) {
		this.r101_6month_factor = r101_6month_factor;
	}
	public BigDecimal getR101_year_factor() {
		return r101_year_factor;
	}
	public void setR101_year_factor(BigDecimal r101_year_factor) {
		this.r101_year_factor = r101_year_factor;
	}
	public BigDecimal getR101_6month_calculated() {
		return r101_6month_calculated;
	}
	public void setR101_6month_calculated(BigDecimal r101_6month_calculated) {
		this.r101_6month_calculated = r101_6month_calculated;
	}
	public BigDecimal getR101_year_calculated() {
		return r101_year_calculated;
	}
	public void setR101_year_calculated(BigDecimal r101_year_calculated) {
		this.r101_year_calculated = r101_year_calculated;
	}
	public BigDecimal getR101_total_asf() {
		return r101_total_asf;
	}
	public void setR101_total_asf(BigDecimal r101_total_asf) {
		this.r101_total_asf = r101_total_asf;
	}
	public String getR103_product() {
		return r103_product;
	}
	public void setR103_product(String r103_product) {
		this.r103_product = r103_product;
	}
	public BigDecimal getR103_months_amount() {
		return r103_months_amount;
	}
	public void setR103_months_amount(BigDecimal r103_months_amount) {
		this.r103_months_amount = r103_months_amount;
	}
	public BigDecimal getR103_6months_amount() {
		return r103_6months_amount;
	}
	public void setR103_6months_amount(BigDecimal r103_6months_amount) {
		this.r103_6months_amount = r103_6months_amount;
	}
	public BigDecimal getR103_year_amount() {
		return r103_year_amount;
	}
	public void setR103_year_amount(BigDecimal r103_year_amount) {
		this.r103_year_amount = r103_year_amount;
	}
	public BigDecimal getR103_months_factor() {
		return r103_months_factor;
	}
	public void setR103_months_factor(BigDecimal r103_months_factor) {
		this.r103_months_factor = r103_months_factor;
	}
	public BigDecimal getR103_6months_factor() {
		return r103_6months_factor;
	}
	public void setR103_6months_factor(BigDecimal r103_6months_factor) {
		this.r103_6months_factor = r103_6months_factor;
	}
	public BigDecimal getR103_year_factor() {
		return r103_year_factor;
	}
	public void setR103_year_factor(BigDecimal r103_year_factor) {
		this.r103_year_factor = r103_year_factor;
	}
	public BigDecimal getR103_months_calculated() {
		return r103_months_calculated;
	}
	public void setR103_months_calculated(BigDecimal r103_months_calculated) {
		this.r103_months_calculated = r103_months_calculated;
	}
	public BigDecimal getR103_6months_calculated() {
		return r103_6months_calculated;
	}
	public void setR103_6months_calculated(BigDecimal r103_6months_calculated) {
		this.r103_6months_calculated = r103_6months_calculated;
	}
	public BigDecimal getR103_year_calculated() {
		return r103_year_calculated;
	}
	public void setR103_year_calculated(BigDecimal r103_year_calculated) {
		this.r103_year_calculated = r103_year_calculated;
	}
	public BigDecimal getR103_total_asf() {
		return r103_total_asf;
	}
	public void setR103_total_asf(BigDecimal r103_total_asf) {
		this.r103_total_asf = r103_total_asf;
	}
	public String getR104_product() {
		return r104_product;
	}
	public void setR104_product(String r104_product) {
		this.r104_product = r104_product;
	}
	public BigDecimal getR104_month_amount() {
		return r104_month_amount;
	}
	public void setR104_month_amount(BigDecimal r104_month_amount) {
		this.r104_month_amount = r104_month_amount;
	}
	public BigDecimal getR104_6month_amount() {
		return r104_6month_amount;
	}
	public void setR104_6month_amount(BigDecimal r104_6month_amount) {
		this.r104_6month_amount = r104_6month_amount;
	}
	public BigDecimal getR104_year_amount() {
		return r104_year_amount;
	}
	public void setR104_year_amount(BigDecimal r104_year_amount) {
		this.r104_year_amount = r104_year_amount;
	}
	public BigDecimal getR104_month_factor() {
		return r104_month_factor;
	}
	public void setR104_month_factor(BigDecimal r104_month_factor) {
		this.r104_month_factor = r104_month_factor;
	}
	public BigDecimal getR104_6month_factor() {
		return r104_6month_factor;
	}
	public void setR104_6month_factor(BigDecimal r104_6month_factor) {
		this.r104_6month_factor = r104_6month_factor;
	}
	public BigDecimal getR104_year_factor() {
		return r104_year_factor;
	}
	public void setR104_year_factor(BigDecimal r104_year_factor) {
		this.r104_year_factor = r104_year_factor;
	}
	public BigDecimal getR104_month_calculated() {
		return r104_month_calculated;
	}
	public void setR104_month_calculated(BigDecimal r104_month_calculated) {
		this.r104_month_calculated = r104_month_calculated;
	}
	public BigDecimal getR104_6month_calculated() {
		return r104_6month_calculated;
	}
	public void setR104_6month_calculated(BigDecimal r104_6month_calculated) {
		this.r104_6month_calculated = r104_6month_calculated;
	}
	public BigDecimal getR104_year_calculated() {
		return r104_year_calculated;
	}
	public void setR104_year_calculated(BigDecimal r104_year_calculated) {
		this.r104_year_calculated = r104_year_calculated;
	}
	public BigDecimal getR104_total_asf() {
		return r104_total_asf;
	}
	public void setR104_total_asf(BigDecimal r104_total_asf) {
		this.r104_total_asf = r104_total_asf;
	}
	public String getR105_product() {
		return r105_product;
	}
	public void setR105_product(String r105_product) {
		this.r105_product = r105_product;
	}
	public BigDecimal getR105_6month_amount() {
		return r105_6month_amount;
	}
	public void setR105_6month_amount(BigDecimal r105_6month_amount) {
		this.r105_6month_amount = r105_6month_amount;
	}
	public BigDecimal getR105_year_amount() {
		return r105_year_amount;
	}
	public void setR105_year_amount(BigDecimal r105_year_amount) {
		this.r105_year_amount = r105_year_amount;
	}
	public BigDecimal getR105_6month_factor() {
		return r105_6month_factor;
	}
	public void setR105_6month_factor(BigDecimal r105_6month_factor) {
		this.r105_6month_factor = r105_6month_factor;
	}
	public BigDecimal getR105_year_factor() {
		return r105_year_factor;
	}
	public void setR105_year_factor(BigDecimal r105_year_factor) {
		this.r105_year_factor = r105_year_factor;
	}
	public BigDecimal getR105_6month_calculated() {
		return r105_6month_calculated;
	}
	public void setR105_6month_calculated(BigDecimal r105_6month_calculated) {
		this.r105_6month_calculated = r105_6month_calculated;
	}
	public BigDecimal getR105_year_calculated() {
		return r105_year_calculated;
	}
	public void setR105_year_calculated(BigDecimal r105_year_calculated) {
		this.r105_year_calculated = r105_year_calculated;
	}
	public BigDecimal getR105_total_asf() {
		return r105_total_asf;
	}
	public void setR105_total_asf(BigDecimal r105_total_asf) {
		this.r105_total_asf = r105_total_asf;
	}
	public String getR106_product() {
		return r106_product;
	}
	public void setR106_product(String r106_product) {
		this.r106_product = r106_product;
	}
	public BigDecimal getR106_6month_amount() {
		return r106_6month_amount;
	}
	public void setR106_6month_amount(BigDecimal r106_6month_amount) {
		this.r106_6month_amount = r106_6month_amount;
	}
	public BigDecimal getR106_year_amount() {
		return r106_year_amount;
	}
	public void setR106_year_amount(BigDecimal r106_year_amount) {
		this.r106_year_amount = r106_year_amount;
	}
	public BigDecimal getR106_6month_factor() {
		return r106_6month_factor;
	}
	public void setR106_6month_factor(BigDecimal r106_6month_factor) {
		this.r106_6month_factor = r106_6month_factor;
	}
	public BigDecimal getR106_year_factor() {
		return r106_year_factor;
	}
	public void setR106_year_factor(BigDecimal r106_year_factor) {
		this.r106_year_factor = r106_year_factor;
	}
	public BigDecimal getR106_6month_calculated() {
		return r106_6month_calculated;
	}
	public void setR106_6month_calculated(BigDecimal r106_6month_calculated) {
		this.r106_6month_calculated = r106_6month_calculated;
	}
	public BigDecimal getR106_year_calculated() {
		return r106_year_calculated;
	}
	public void setR106_year_calculated(BigDecimal r106_year_calculated) {
		this.r106_year_calculated = r106_year_calculated;
	}
	public BigDecimal getR106_total_asf() {
		return r106_total_asf;
	}
	public void setR106_total_asf(BigDecimal r106_total_asf) {
		this.r106_total_asf = r106_total_asf;
	}
	public String getR109_product() {
		return r109_product;
	}
	public void setR109_product(String r109_product) {
		this.r109_product = r109_product;
	}
	public BigDecimal getR109_month_amount() {
		return r109_month_amount;
	}
	public void setR109_month_amount(BigDecimal r109_month_amount) {
		this.r109_month_amount = r109_month_amount;
	}
	public BigDecimal getR109_6month_amount() {
		return r109_6month_amount;
	}
	public void setR109_6month_amount(BigDecimal r109_6month_amount) {
		this.r109_6month_amount = r109_6month_amount;
	}
	public BigDecimal getR109_month_factor() {
		return r109_month_factor;
	}
	public void setR109_month_factor(BigDecimal r109_month_factor) {
		this.r109_month_factor = r109_month_factor;
	}
	public BigDecimal getR109_6month_factor() {
		return r109_6month_factor;
	}
	public void setR109_6month_factor(BigDecimal r109_6month_factor) {
		this.r109_6month_factor = r109_6month_factor;
	}
	public BigDecimal getR109_month_calculated() {
		return r109_month_calculated;
	}
	public void setR109_month_calculated(BigDecimal r109_month_calculated) {
		this.r109_month_calculated = r109_month_calculated;
	}
	public BigDecimal getR109_6month_calculated() {
		return r109_6month_calculated;
	}
	public void setR109_6month_calculated(BigDecimal r109_6month_calculated) {
		this.r109_6month_calculated = r109_6month_calculated;
	}
	public BigDecimal getR109_total_asf() {
		return r109_total_asf;
	}
	public void setR109_total_asf(BigDecimal r109_total_asf) {
		this.r109_total_asf = r109_total_asf;
	}
	public String getR110_product() {
		return r110_product;
	}
	public void setR110_product(String r110_product) {
		this.r110_product = r110_product;
	}
	public BigDecimal getR110_month_amount() {
		return r110_month_amount;
	}
	public void setR110_month_amount(BigDecimal r110_month_amount) {
		this.r110_month_amount = r110_month_amount;
	}
	public BigDecimal getR110_month_factor() {
		return r110_month_factor;
	}
	public void setR110_month_factor(BigDecimal r110_month_factor) {
		this.r110_month_factor = r110_month_factor;
	}
	public BigDecimal getR110_month_calculated() {
		return r110_month_calculated;
	}
	public void setR110_month_calculated(BigDecimal r110_month_calculated) {
		this.r110_month_calculated = r110_month_calculated;
	}
	public BigDecimal getR110_total_asf() {
		return r110_total_asf;
	}
	public void setR110_total_asf(BigDecimal r110_total_asf) {
		this.r110_total_asf = r110_total_asf;
	}
	public String getR111_product() {
		return r111_product;
	}
	public void setR111_product(String r111_product) {
		this.r111_product = r111_product;
	}
	public BigDecimal getR111_6month_amount() {
		return r111_6month_amount;
	}
	public void setR111_6month_amount(BigDecimal r111_6month_amount) {
		this.r111_6month_amount = r111_6month_amount;
	}
	public BigDecimal getR111_6month_factor() {
		return r111_6month_factor;
	}
	public void setR111_6month_factor(BigDecimal r111_6month_factor) {
		this.r111_6month_factor = r111_6month_factor;
	}
	public BigDecimal getR111_6month_calculated() {
		return r111_6month_calculated;
	}
	public void setR111_6month_calculated(BigDecimal r111_6month_calculated) {
		this.r111_6month_calculated = r111_6month_calculated;
	}
	public BigDecimal getR111_total_asf() {
		return r111_total_asf;
	}
	public void setR111_total_asf(BigDecimal r111_total_asf) {
		this.r111_total_asf = r111_total_asf;
	}
	public String getR113_product() {
		return r113_product;
	}
	public void setR113_product(String r113_product) {
		this.r113_product = r113_product;
	}
	public BigDecimal getR113_month_amount() {
		return r113_month_amount;
	}
	public void setR113_month_amount(BigDecimal r113_month_amount) {
		this.r113_month_amount = r113_month_amount;
	}
	public BigDecimal getR113_6month_amount() {
		return r113_6month_amount;
	}
	public void setR113_6month_amount(BigDecimal r113_6month_amount) {
		this.r113_6month_amount = r113_6month_amount;
	}
	public BigDecimal getR113_month_factor() {
		return r113_month_factor;
	}
	public void setR113_month_factor(BigDecimal r113_month_factor) {
		this.r113_month_factor = r113_month_factor;
	}
	public BigDecimal getR113_6month_factor() {
		return r113_6month_factor;
	}
	public void setR113_6month_factor(BigDecimal r113_6month_factor) {
		this.r113_6month_factor = r113_6month_factor;
	}
	public BigDecimal getR113_month_calculated() {
		return r113_month_calculated;
	}
	public void setR113_month_calculated(BigDecimal r113_month_calculated) {
		this.r113_month_calculated = r113_month_calculated;
	}
	public BigDecimal getR113_6month_calculated() {
		return r113_6month_calculated;
	}
	public void setR113_6month_calculated(BigDecimal r113_6month_calculated) {
		this.r113_6month_calculated = r113_6month_calculated;
	}
	public BigDecimal getR113_total_asf() {
		return r113_total_asf;
	}
	public void setR113_total_asf(BigDecimal r113_total_asf) {
		this.r113_total_asf = r113_total_asf;
	}
	public String getR114_product() {
		return r114_product;
	}
	public void setR114_product(String r114_product) {
		this.r114_product = r114_product;
	}
	public BigDecimal getR114_month_amount() {
		return r114_month_amount;
	}
	public void setR114_month_amount(BigDecimal r114_month_amount) {
		this.r114_month_amount = r114_month_amount;
	}
	public BigDecimal getR114_month_factor() {
		return r114_month_factor;
	}
	public void setR114_month_factor(BigDecimal r114_month_factor) {
		this.r114_month_factor = r114_month_factor;
	}
	public BigDecimal getR114_month_calculated() {
		return r114_month_calculated;
	}
	public void setR114_month_calculated(BigDecimal r114_month_calculated) {
		this.r114_month_calculated = r114_month_calculated;
	}
	public BigDecimal getR114_total_asf() {
		return r114_total_asf;
	}
	public void setR114_total_asf(BigDecimal r114_total_asf) {
		this.r114_total_asf = r114_total_asf;
	}
	public String getR115_product() {
		return r115_product;
	}
	public void setR115_product(String r115_product) {
		this.r115_product = r115_product;
	}
	public BigDecimal getR115_6month_amount() {
		return r115_6month_amount;
	}
	public void setR115_6month_amount(BigDecimal r115_6month_amount) {
		this.r115_6month_amount = r115_6month_amount;
	}
	public BigDecimal getR115_6month_factor() {
		return r115_6month_factor;
	}
	public void setR115_6month_factor(BigDecimal r115_6month_factor) {
		this.r115_6month_factor = r115_6month_factor;
	}
	public BigDecimal getR115_6month_calculated() {
		return r115_6month_calculated;
	}
	public void setR115_6month_calculated(BigDecimal r115_6month_calculated) {
		this.r115_6month_calculated = r115_6month_calculated;
	}
	public BigDecimal getR115_total_asf() {
		return r115_total_asf;
	}
	public void setR115_total_asf(BigDecimal r115_total_asf) {
		this.r115_total_asf = r115_total_asf;
	}
	public String getR117_product() {
		return r117_product;
	}
	public void setR117_product(String r117_product) {
		this.r117_product = r117_product;
	}
	public BigDecimal getR117_month_amount() {
		return r117_month_amount;
	}
	public void setR117_month_amount(BigDecimal r117_month_amount) {
		this.r117_month_amount = r117_month_amount;
	}
	public BigDecimal getR117_6month_amount() {
		return r117_6month_amount;
	}
	public void setR117_6month_amount(BigDecimal r117_6month_amount) {
		this.r117_6month_amount = r117_6month_amount;
	}
	public BigDecimal getR117_month_factor() {
		return r117_month_factor;
	}
	public void setR117_month_factor(BigDecimal r117_month_factor) {
		this.r117_month_factor = r117_month_factor;
	}
	public BigDecimal getR117_6month_factor() {
		return r117_6month_factor;
	}
	public void setR117_6month_factor(BigDecimal r117_6month_factor) {
		this.r117_6month_factor = r117_6month_factor;
	}
	public BigDecimal getR117_month_calculated() {
		return r117_month_calculated;
	}
	public void setR117_month_calculated(BigDecimal r117_month_calculated) {
		this.r117_month_calculated = r117_month_calculated;
	}
	public BigDecimal getR117_6month_calculated() {
		return r117_6month_calculated;
	}
	public void setR117_6month_calculated(BigDecimal r117_6month_calculated) {
		this.r117_6month_calculated = r117_6month_calculated;
	}
	public BigDecimal getR117_total_asf() {
		return r117_total_asf;
	}
	public void setR117_total_asf(BigDecimal r117_total_asf) {
		this.r117_total_asf = r117_total_asf;
	}
	public String getR118_product() {
		return r118_product;
	}
	public void setR118_product(String r118_product) {
		this.r118_product = r118_product;
	}
	public BigDecimal getR118_month_amount() {
		return r118_month_amount;
	}
	public void setR118_month_amount(BigDecimal r118_month_amount) {
		this.r118_month_amount = r118_month_amount;
	}
	public BigDecimal getR118_month_factor() {
		return r118_month_factor;
	}
	public void setR118_month_factor(BigDecimal r118_month_factor) {
		this.r118_month_factor = r118_month_factor;
	}
	public BigDecimal getR118_month_calculated() {
		return r118_month_calculated;
	}
	public void setR118_month_calculated(BigDecimal r118_month_calculated) {
		this.r118_month_calculated = r118_month_calculated;
	}
	public BigDecimal getR118_total_asf() {
		return r118_total_asf;
	}
	public void setR118_total_asf(BigDecimal r118_total_asf) {
		this.r118_total_asf = r118_total_asf;
	}
	public String getR119_product() {
		return r119_product;
	}
	public void setR119_product(String r119_product) {
		this.r119_product = r119_product;
	}
	public BigDecimal getR119_6month_amount() {
		return r119_6month_amount;
	}
	public void setR119_6month_amount(BigDecimal r119_6month_amount) {
		this.r119_6month_amount = r119_6month_amount;
	}
	public BigDecimal getR119_6month_factor() {
		return r119_6month_factor;
	}
	public void setR119_6month_factor(BigDecimal r119_6month_factor) {
		this.r119_6month_factor = r119_6month_factor;
	}
	public BigDecimal getR119_6month_calculated() {
		return r119_6month_calculated;
	}
	public void setR119_6month_calculated(BigDecimal r119_6month_calculated) {
		this.r119_6month_calculated = r119_6month_calculated;
	}
	public BigDecimal getR119_total_asf() {
		return r119_total_asf;
	}
	public void setR119_total_asf(BigDecimal r119_total_asf) {
		this.r119_total_asf = r119_total_asf;
	}
	public String getR122_product() {
		return r122_product;
	}
	public void setR122_product(String r122_product) {
		this.r122_product = r122_product;
	}
	public BigDecimal getR122_year_amount() {
		return r122_year_amount;
	}
	public void setR122_year_amount(BigDecimal r122_year_amount) {
		this.r122_year_amount = r122_year_amount;
	}
	public BigDecimal getR122_year_factor() {
		return r122_year_factor;
	}
	public void setR122_year_factor(BigDecimal r122_year_factor) {
		this.r122_year_factor = r122_year_factor;
	}
	public BigDecimal getR122_year_calculated() {
		return r122_year_calculated;
	}
	public void setR122_year_calculated(BigDecimal r122_year_calculated) {
		this.r122_year_calculated = r122_year_calculated;
	}
	public BigDecimal getR122_total_asf() {
		return r122_total_asf;
	}
	public void setR122_total_asf(BigDecimal r122_total_asf) {
		this.r122_total_asf = r122_total_asf;
	}
	public String getR123_product() {
		return r123_product;
	}
	public void setR123_product(String r123_product) {
		this.r123_product = r123_product;
	}
	public BigDecimal getR123_month_amount() {
		return r123_month_amount;
	}
	public void setR123_month_amount(BigDecimal r123_month_amount) {
		this.r123_month_amount = r123_month_amount;
	}
	public BigDecimal getR123_month_factor() {
		return r123_month_factor;
	}
	public void setR123_month_factor(BigDecimal r123_month_factor) {
		this.r123_month_factor = r123_month_factor;
	}
	public BigDecimal getR123_month_calculated() {
		return r123_month_calculated;
	}
	public void setR123_month_calculated(BigDecimal r123_month_calculated) {
		this.r123_month_calculated = r123_month_calculated;
	}
	public BigDecimal getR123_total_asf() {
		return r123_total_asf;
	}
	public void setR123_total_asf(BigDecimal r123_total_asf) {
		this.r123_total_asf = r123_total_asf;
	}
	public String getR124_product() {
		return r124_product;
	}
	public void setR124_product(String r124_product) {
		this.r124_product = r124_product;
	}
	public BigDecimal getR124_6month_amount() {
		return r124_6month_amount;
	}
	public void setR124_6month_amount(BigDecimal r124_6month_amount) {
		this.r124_6month_amount = r124_6month_amount;
	}
	public BigDecimal getR124_6month_factor() {
		return r124_6month_factor;
	}
	public void setR124_6month_factor(BigDecimal r124_6month_factor) {
		this.r124_6month_factor = r124_6month_factor;
	}
	public BigDecimal getR124_6month_calculated() {
		return r124_6month_calculated;
	}
	public void setR124_6month_calculated(BigDecimal r124_6month_calculated) {
		this.r124_6month_calculated = r124_6month_calculated;
	}
	public BigDecimal getR124_total_asf() {
		return r124_total_asf;
	}
	public void setR124_total_asf(BigDecimal r124_total_asf) {
		this.r124_total_asf = r124_total_asf;
	}
	public String getR125_product() {
		return r125_product;
	}
	public void setR125_product(String r125_product) {
		this.r125_product = r125_product;
	}
	public BigDecimal getR125_year_amount() {
		return r125_year_amount;
	}
	public void setR125_year_amount(BigDecimal r125_year_amount) {
		this.r125_year_amount = r125_year_amount;
	}
	public BigDecimal getR125_year_factor() {
		return r125_year_factor;
	}
	public void setR125_year_factor(BigDecimal r125_year_factor) {
		this.r125_year_factor = r125_year_factor;
	}
	public BigDecimal getR125_year_calculated() {
		return r125_year_calculated;
	}
	public void setR125_year_calculated(BigDecimal r125_year_calculated) {
		this.r125_year_calculated = r125_year_calculated;
	}
	public BigDecimal getR125_total_asf() {
		return r125_total_asf;
	}
	public void setR125_total_asf(BigDecimal r125_total_asf) {
		this.r125_total_asf = r125_total_asf;
	}
	public String getR127_product() {
		return r127_product;
	}
	public void setR127_product(String r127_product) {
		this.r127_product = r127_product;
	}
	public BigDecimal getR127_year_amount() {
		return r127_year_amount;
	}
	public void setR127_year_amount(BigDecimal r127_year_amount) {
		this.r127_year_amount = r127_year_amount;
	}
	public BigDecimal getR127_year_factor() {
		return r127_year_factor;
	}
	public void setR127_year_factor(BigDecimal r127_year_factor) {
		this.r127_year_factor = r127_year_factor;
	}
	public BigDecimal getR127_year_calculated() {
		return r127_year_calculated;
	}
	public void setR127_year_calculated(BigDecimal r127_year_calculated) {
		this.r127_year_calculated = r127_year_calculated;
	}
	public BigDecimal getR127_total_asf() {
		return r127_total_asf;
	}
	public void setR127_total_asf(BigDecimal r127_total_asf) {
		this.r127_total_asf = r127_total_asf;
	}
	public String getR128_product() {
		return r128_product;
	}
	public void setR128_product(String r128_product) {
		this.r128_product = r128_product;
	}
	public BigDecimal getR128_month_amount() {
		return r128_month_amount;
	}
	public void setR128_month_amount(BigDecimal r128_month_amount) {
		this.r128_month_amount = r128_month_amount;
	}
	public BigDecimal getR128_month_factor() {
		return r128_month_factor;
	}
	public void setR128_month_factor(BigDecimal r128_month_factor) {
		this.r128_month_factor = r128_month_factor;
	}
	public BigDecimal getR128_month_calculated() {
		return r128_month_calculated;
	}
	public void setR128_month_calculated(BigDecimal r128_month_calculated) {
		this.r128_month_calculated = r128_month_calculated;
	}
	public BigDecimal getR128_total_asf() {
		return r128_total_asf;
	}
	public void setR128_total_asf(BigDecimal r128_total_asf) {
		this.r128_total_asf = r128_total_asf;
	}
	public String getR129_product() {
		return r129_product;
	}
	public void setR129_product(String r129_product) {
		this.r129_product = r129_product;
	}
	public BigDecimal getR129_6month_amount() {
		return r129_6month_amount;
	}
	public void setR129_6month_amount(BigDecimal r129_6month_amount) {
		this.r129_6month_amount = r129_6month_amount;
	}
	public BigDecimal getR129_6month_factor() {
		return r129_6month_factor;
	}
	public void setR129_6month_factor(BigDecimal r129_6month_factor) {
		this.r129_6month_factor = r129_6month_factor;
	}
	public BigDecimal getR129_6month_calculated() {
		return r129_6month_calculated;
	}
	public void setR129_6month_calculated(BigDecimal r129_6month_calculated) {
		this.r129_6month_calculated = r129_6month_calculated;
	}
	public BigDecimal getR129_total_asf() {
		return r129_total_asf;
	}
	public void setR129_total_asf(BigDecimal r129_total_asf) {
		this.r129_total_asf = r129_total_asf;
	}
	public String getR130_product() {
		return r130_product;
	}
	public void setR130_product(String r130_product) {
		this.r130_product = r130_product;
	}
	public BigDecimal getR130_year_amount() {
		return r130_year_amount;
	}
	public void setR130_year_amount(BigDecimal r130_year_amount) {
		this.r130_year_amount = r130_year_amount;
	}
	public BigDecimal getR130_year_factor() {
		return r130_year_factor;
	}
	public void setR130_year_factor(BigDecimal r130_year_factor) {
		this.r130_year_factor = r130_year_factor;
	}
	public BigDecimal getR130_year_calculated() {
		return r130_year_calculated;
	}
	public void setR130_year_calculated(BigDecimal r130_year_calculated) {
		this.r130_year_calculated = r130_year_calculated;
	}
	public BigDecimal getR130_total_asf() {
		return r130_total_asf;
	}
	public void setR130_total_asf(BigDecimal r130_total_asf) {
		this.r130_total_asf = r130_total_asf;
	}
	public String getR132_product() {
		return r132_product;
	}
	public void setR132_product(String r132_product) {
		this.r132_product = r132_product;
	}
	public BigDecimal getR132_year_amount() {
		return r132_year_amount;
	}
	public void setR132_year_amount(BigDecimal r132_year_amount) {
		this.r132_year_amount = r132_year_amount;
	}
	public BigDecimal getR132_year_factor() {
		return r132_year_factor;
	}
	public void setR132_year_factor(BigDecimal r132_year_factor) {
		this.r132_year_factor = r132_year_factor;
	}
	public BigDecimal getR132_year_calculated() {
		return r132_year_calculated;
	}
	public void setR132_year_calculated(BigDecimal r132_year_calculated) {
		this.r132_year_calculated = r132_year_calculated;
	}
	public BigDecimal getR132_total_asf() {
		return r132_total_asf;
	}
	public void setR132_total_asf(BigDecimal r132_total_asf) {
		this.r132_total_asf = r132_total_asf;
	}
	public String getR133_product() {
		return r133_product;
	}
	public void setR133_product(String r133_product) {
		this.r133_product = r133_product;
	}
	public BigDecimal getR133_month_amount() {
		return r133_month_amount;
	}
	public void setR133_month_amount(BigDecimal r133_month_amount) {
		this.r133_month_amount = r133_month_amount;
	}
	public BigDecimal getR133_month_factor() {
		return r133_month_factor;
	}
	public void setR133_month_factor(BigDecimal r133_month_factor) {
		this.r133_month_factor = r133_month_factor;
	}
	public BigDecimal getR133_month_calculated() {
		return r133_month_calculated;
	}
	public void setR133_month_calculated(BigDecimal r133_month_calculated) {
		this.r133_month_calculated = r133_month_calculated;
	}
	public BigDecimal getR133_total_asf() {
		return r133_total_asf;
	}
	public void setR133_total_asf(BigDecimal r133_total_asf) {
		this.r133_total_asf = r133_total_asf;
	}
	public String getR134_product() {
		return r134_product;
	}
	public void setR134_product(String r134_product) {
		this.r134_product = r134_product;
	}
	public BigDecimal getR134_6month_amount() {
		return r134_6month_amount;
	}
	public void setR134_6month_amount(BigDecimal r134_6month_amount) {
		this.r134_6month_amount = r134_6month_amount;
	}
	public BigDecimal getR134_6month_factor() {
		return r134_6month_factor;
	}
	public void setR134_6month_factor(BigDecimal r134_6month_factor) {
		this.r134_6month_factor = r134_6month_factor;
	}
	public BigDecimal getR134_6month_calculated() {
		return r134_6month_calculated;
	}
	public void setR134_6month_calculated(BigDecimal r134_6month_calculated) {
		this.r134_6month_calculated = r134_6month_calculated;
	}
	public BigDecimal getR134_total_asf() {
		return r134_total_asf;
	}
	public void setR134_total_asf(BigDecimal r134_total_asf) {
		this.r134_total_asf = r134_total_asf;
	}
	public String getR135_product() {
		return r135_product;
	}
	public void setR135_product(String r135_product) {
		this.r135_product = r135_product;
	}
	public BigDecimal getR135_year_amount() {
		return r135_year_amount;
	}
	public void setR135_year_amount(BigDecimal r135_year_amount) {
		this.r135_year_amount = r135_year_amount;
	}
	public BigDecimal getR135_year_factor() {
		return r135_year_factor;
	}
	public void setR135_year_factor(BigDecimal r135_year_factor) {
		this.r135_year_factor = r135_year_factor;
	}
	public BigDecimal getR135_year_calculated() {
		return r135_year_calculated;
	}
	public void setR135_year_calculated(BigDecimal r135_year_calculated) {
		this.r135_year_calculated = r135_year_calculated;
	}
	public BigDecimal getR135_total_asf() {
		return r135_total_asf;
	}
	public void setR135_total_asf(BigDecimal r135_total_asf) {
		this.r135_total_asf = r135_total_asf;
	}
	public String getR137_product() {
		return r137_product;
	}
	public void setR137_product(String r137_product) {
		this.r137_product = r137_product;
	}
	public BigDecimal getR137_year_amount() {
		return r137_year_amount;
	}
	public void setR137_year_amount(BigDecimal r137_year_amount) {
		this.r137_year_amount = r137_year_amount;
	}
	public BigDecimal getR137_year_factor() {
		return r137_year_factor;
	}
	public void setR137_year_factor(BigDecimal r137_year_factor) {
		this.r137_year_factor = r137_year_factor;
	}
	public BigDecimal getR137_year_calculated() {
		return r137_year_calculated;
	}
	public void setR137_year_calculated(BigDecimal r137_year_calculated) {
		this.r137_year_calculated = r137_year_calculated;
	}
	public BigDecimal getR137_total_asf() {
		return r137_total_asf;
	}
	public void setR137_total_asf(BigDecimal r137_total_asf) {
		this.r137_total_asf = r137_total_asf;
	}
	public String getR138_product() {
		return r138_product;
	}
	public void setR138_product(String r138_product) {
		this.r138_product = r138_product;
	}
	public BigDecimal getR138_month_amount() {
		return r138_month_amount;
	}
	public void setR138_month_amount(BigDecimal r138_month_amount) {
		this.r138_month_amount = r138_month_amount;
	}
	public BigDecimal getR138_month_factor() {
		return r138_month_factor;
	}
	public void setR138_month_factor(BigDecimal r138_month_factor) {
		this.r138_month_factor = r138_month_factor;
	}
	public BigDecimal getR138_month_calculated() {
		return r138_month_calculated;
	}
	public void setR138_month_calculated(BigDecimal r138_month_calculated) {
		this.r138_month_calculated = r138_month_calculated;
	}
	public BigDecimal getR138_total_asf() {
		return r138_total_asf;
	}
	public void setR138_total_asf(BigDecimal r138_total_asf) {
		this.r138_total_asf = r138_total_asf;
	}
	public String getR139_product() {
		return r139_product;
	}
	public void setR139_product(String r139_product) {
		this.r139_product = r139_product;
	}
	public BigDecimal getR139_6month_amount() {
		return r139_6month_amount;
	}
	public void setR139_6month_amount(BigDecimal r139_6month_amount) {
		this.r139_6month_amount = r139_6month_amount;
	}
	public BigDecimal getR139_6month_factor() {
		return r139_6month_factor;
	}
	public void setR139_6month_factor(BigDecimal r139_6month_factor) {
		this.r139_6month_factor = r139_6month_factor;
	}
	public BigDecimal getR139_6month_calculated() {
		return r139_6month_calculated;
	}
	public void setR139_6month_calculated(BigDecimal r139_6month_calculated) {
		this.r139_6month_calculated = r139_6month_calculated;
	}
	public BigDecimal getR139_total_asf() {
		return r139_total_asf;
	}
	public void setR139_total_asf(BigDecimal r139_total_asf) {
		this.r139_total_asf = r139_total_asf;
	}
	public String getR140_product() {
		return r140_product;
	}
	public void setR140_product(String r140_product) {
		this.r140_product = r140_product;
	}
	public BigDecimal getR140_year_amount() {
		return r140_year_amount;
	}
	public void setR140_year_amount(BigDecimal r140_year_amount) {
		this.r140_year_amount = r140_year_amount;
	}
	public BigDecimal getR140_year_factor() {
		return r140_year_factor;
	}
	public void setR140_year_factor(BigDecimal r140_year_factor) {
		this.r140_year_factor = r140_year_factor;
	}
	public BigDecimal getR140_year_calculated() {
		return r140_year_calculated;
	}
	public void setR140_year_calculated(BigDecimal r140_year_calculated) {
		this.r140_year_calculated = r140_year_calculated;
	}
	public BigDecimal getR140_total_asf() {
		return r140_total_asf;
	}
	public void setR140_total_asf(BigDecimal r140_total_asf) {
		this.r140_total_asf = r140_total_asf;
	}
	public String getR142_product() {
		return r142_product;
	}
	public void setR142_product(String r142_product) {
		this.r142_product = r142_product;
	}
	public BigDecimal getR142_year_amount() {
		return r142_year_amount;
	}
	public void setR142_year_amount(BigDecimal r142_year_amount) {
		this.r142_year_amount = r142_year_amount;
	}
	public BigDecimal getR142_year_factor() {
		return r142_year_factor;
	}
	public void setR142_year_factor(BigDecimal r142_year_factor) {
		this.r142_year_factor = r142_year_factor;
	}
	public BigDecimal getR142_year_calculated() {
		return r142_year_calculated;
	}
	public void setR142_year_calculated(BigDecimal r142_year_calculated) {
		this.r142_year_calculated = r142_year_calculated;
	}
	public BigDecimal getR142_total_asf() {
		return r142_total_asf;
	}
	public void setR142_total_asf(BigDecimal r142_total_asf) {
		this.r142_total_asf = r142_total_asf;
	}
	public String getR143_product() {
		return r143_product;
	}
	public void setR143_product(String r143_product) {
		this.r143_product = r143_product;
	}
	public BigDecimal getR143_month_amount() {
		return r143_month_amount;
	}
	public void setR143_month_amount(BigDecimal r143_month_amount) {
		this.r143_month_amount = r143_month_amount;
	}
	public BigDecimal getR143_month_factor() {
		return r143_month_factor;
	}
	public void setR143_month_factor(BigDecimal r143_month_factor) {
		this.r143_month_factor = r143_month_factor;
	}
	public BigDecimal getR143_month_calculated() {
		return r143_month_calculated;
	}
	public void setR143_month_calculated(BigDecimal r143_month_calculated) {
		this.r143_month_calculated = r143_month_calculated;
	}
	public BigDecimal getR143_total_asf() {
		return r143_total_asf;
	}
	public void setR143_total_asf(BigDecimal r143_total_asf) {
		this.r143_total_asf = r143_total_asf;
	}
	public String getR144_product() {
		return r144_product;
	}
	public void setR144_product(String r144_product) {
		this.r144_product = r144_product;
	}
	public BigDecimal getR144_6month_amount() {
		return r144_6month_amount;
	}
	public void setR144_6month_amount(BigDecimal r144_6month_amount) {
		this.r144_6month_amount = r144_6month_amount;
	}
	public BigDecimal getR144_6month_factor() {
		return r144_6month_factor;
	}
	public void setR144_6month_factor(BigDecimal r144_6month_factor) {
		this.r144_6month_factor = r144_6month_factor;
	}
	public BigDecimal getR144_6month_calculated() {
		return r144_6month_calculated;
	}
	public void setR144_6month_calculated(BigDecimal r144_6month_calculated) {
		this.r144_6month_calculated = r144_6month_calculated;
	}
	public BigDecimal getR144_total_asf() {
		return r144_total_asf;
	}
	public void setR144_total_asf(BigDecimal r144_total_asf) {
		this.r144_total_asf = r144_total_asf;
	}
	public String getR145_product() {
		return r145_product;
	}
	public void setR145_product(String r145_product) {
		this.r145_product = r145_product;
	}
	public BigDecimal getR145_year_amount() {
		return r145_year_amount;
	}
	public void setR145_year_amount(BigDecimal r145_year_amount) {
		this.r145_year_amount = r145_year_amount;
	}
	public BigDecimal getR145_year_factor() {
		return r145_year_factor;
	}
	public void setR145_year_factor(BigDecimal r145_year_factor) {
		this.r145_year_factor = r145_year_factor;
	}
	public BigDecimal getR145_year_calculated() {
		return r145_year_calculated;
	}
	public void setR145_year_calculated(BigDecimal r145_year_calculated) {
		this.r145_year_calculated = r145_year_calculated;
	}
	public BigDecimal getR145_total_asf() {
		return r145_total_asf;
	}
	public void setR145_total_asf(BigDecimal r145_total_asf) {
		this.r145_total_asf = r145_total_asf;
	}
	public String getR147_product() {
		return r147_product;
	}
	public void setR147_product(String r147_product) {
		this.r147_product = r147_product;
	}
	public BigDecimal getR147_year_amount() {
		return r147_year_amount;
	}
	public void setR147_year_amount(BigDecimal r147_year_amount) {
		this.r147_year_amount = r147_year_amount;
	}
	public String getR148_product() {
		return r148_product;
	}
	public void setR148_product(String r148_product) {
		this.r148_product = r148_product;
	}
	public BigDecimal getR148_year_amount() {
		return r148_year_amount;
	}
	public void setR148_year_amount(BigDecimal r148_year_amount) {
		this.r148_year_amount = r148_year_amount;
	}
	public String getR149_product() {
		return r149_product;
	}
	public void setR149_product(String r149_product) {
		this.r149_product = r149_product;
	}
	public BigDecimal getR149_year_amount() {
		return r149_year_amount;
	}
	public void setR149_year_amount(BigDecimal r149_year_amount) {
		this.r149_year_amount = r149_year_amount;
	}
	public BigDecimal getR149_year_factor() {
		return r149_year_factor;
	}
	public void setR149_year_factor(BigDecimal r149_year_factor) {
		this.r149_year_factor = r149_year_factor;
	}
	public BigDecimal getR149_year_calculated() {
		return r149_year_calculated;
	}
	public void setR149_year_calculated(BigDecimal r149_year_calculated) {
		this.r149_year_calculated = r149_year_calculated;
	}
	public BigDecimal getR149_total_asf() {
		return r149_total_asf;
	}
	public void setR149_total_asf(BigDecimal r149_total_asf) {
		this.r149_total_asf = r149_total_asf;
	}
	public String getR150_product() {
		return r150_product;
	}
	public void setR150_product(String r150_product) {
		this.r150_product = r150_product;
	}
	public BigDecimal getR150_year_amount() {
		return r150_year_amount;
	}
	public void setR150_year_amount(BigDecimal r150_year_amount) {
		this.r150_year_amount = r150_year_amount;
	}
	public BigDecimal getR150_year_factor() {
		return r150_year_factor;
	}
	public void setR150_year_factor(BigDecimal r150_year_factor) {
		this.r150_year_factor = r150_year_factor;
	}
	public BigDecimal getR150_year_calculated() {
		return r150_year_calculated;
	}
	public void setR150_year_calculated(BigDecimal r150_year_calculated) {
		this.r150_year_calculated = r150_year_calculated;
	}
	public BigDecimal getR150_total_asf() {
		return r150_total_asf;
	}
	public void setR150_total_asf(BigDecimal r150_total_asf) {
		this.r150_total_asf = r150_total_asf;
	}
	public String getR151_product() {
		return r151_product;
	}
	public void setR151_product(String r151_product) {
		this.r151_product = r151_product;
	}
	public BigDecimal getR151_months_amount() {
		return r151_months_amount;
	}
	public void setR151_months_amount(BigDecimal r151_months_amount) {
		this.r151_months_amount = r151_months_amount;
	}
	public BigDecimal getR151_6months_amount() {
		return r151_6months_amount;
	}
	public void setR151_6months_amount(BigDecimal r151_6months_amount) {
		this.r151_6months_amount = r151_6months_amount;
	}
	public BigDecimal getR151_year_amount() {
		return r151_year_amount;
	}
	public void setR151_year_amount(BigDecimal r151_year_amount) {
		this.r151_year_amount = r151_year_amount;
	}
	public BigDecimal getR151_months_factor() {
		return r151_months_factor;
	}
	public void setR151_months_factor(BigDecimal r151_months_factor) {
		this.r151_months_factor = r151_months_factor;
	}
	public BigDecimal getR151_6months_factor() {
		return r151_6months_factor;
	}
	public void setR151_6months_factor(BigDecimal r151_6months_factor) {
		this.r151_6months_factor = r151_6months_factor;
	}
	public BigDecimal getR151_year_factor() {
		return r151_year_factor;
	}
	public void setR151_year_factor(BigDecimal r151_year_factor) {
		this.r151_year_factor = r151_year_factor;
	}
	public BigDecimal getR151_months_calculated() {
		return r151_months_calculated;
	}
	public void setR151_months_calculated(BigDecimal r151_months_calculated) {
		this.r151_months_calculated = r151_months_calculated;
	}
	public BigDecimal getR151_6months_calculated() {
		return r151_6months_calculated;
	}
	public void setR151_6months_calculated(BigDecimal r151_6months_calculated) {
		this.r151_6months_calculated = r151_6months_calculated;
	}
	public BigDecimal getR151_year_calculated() {
		return r151_year_calculated;
	}
	public void setR151_year_calculated(BigDecimal r151_year_calculated) {
		this.r151_year_calculated = r151_year_calculated;
	}
	public BigDecimal getR151_total_asf() {
		return r151_total_asf;
	}
	public void setR151_total_asf(BigDecimal r151_total_asf) {
		this.r151_total_asf = r151_total_asf;
	}
	public String getR152_product() {
		return r152_product;
	}
	public void setR152_product(String r152_product) {
		this.r152_product = r152_product;
	}
	public BigDecimal getR152_year_amount() {
		return r152_year_amount;
	}
	public void setR152_year_amount(BigDecimal r152_year_amount) {
		this.r152_year_amount = r152_year_amount;
	}
	public String getR153_product() {
		return r153_product;
	}
	public void setR153_product(String r153_product) {
		this.r153_product = r153_product;
	}
	public BigDecimal getR153_year_amount() {
		return r153_year_amount;
	}
	public void setR153_year_amount(BigDecimal r153_year_amount) {
		this.r153_year_amount = r153_year_amount;
	}
	public BigDecimal getR153_year_factor() {
		return r153_year_factor;
	}
	public void setR153_year_factor(BigDecimal r153_year_factor) {
		this.r153_year_factor = r153_year_factor;
	}
	public BigDecimal getR153_year_calculated() {
		return r153_year_calculated;
	}
	public void setR153_year_calculated(BigDecimal r153_year_calculated) {
		this.r153_year_calculated = r153_year_calculated;
	}
	public BigDecimal getR153_total_asf() {
		return r153_total_asf;
	}
	public void setR153_total_asf(BigDecimal r153_total_asf) {
		this.r153_total_asf = r153_total_asf;
	}
	public String getR155_product() {
		return r155_product;
	}
	public void setR155_product(String r155_product) {
		this.r155_product = r155_product;
	}
	public BigDecimal getR155_month_amount() {
		return r155_month_amount;
	}
	public void setR155_month_amount(BigDecimal r155_month_amount) {
		this.r155_month_amount = r155_month_amount;
	}
	public BigDecimal getR155_month_factor() {
		return r155_month_factor;
	}
	public void setR155_month_factor(BigDecimal r155_month_factor) {
		this.r155_month_factor = r155_month_factor;
	}
	public BigDecimal getR155_month_calculated() {
		return r155_month_calculated;
	}
	public void setR155_month_calculated(BigDecimal r155_month_calculated) {
		this.r155_month_calculated = r155_month_calculated;
	}
	public BigDecimal getR155_total_asf() {
		return r155_total_asf;
	}
	public void setR155_total_asf(BigDecimal r155_total_asf) {
		this.r155_total_asf = r155_total_asf;
	}
	public String getR156_product() {
		return r156_product;
	}
	public void setR156_product(String r156_product) {
		this.r156_product = r156_product;
	}
	public BigDecimal getR156_months_amount() {
		return r156_months_amount;
	}
	public void setR156_months_amount(BigDecimal r156_months_amount) {
		this.r156_months_amount = r156_months_amount;
	}
	public BigDecimal getR156_6months_amount() {
		return r156_6months_amount;
	}
	public void setR156_6months_amount(BigDecimal r156_6months_amount) {
		this.r156_6months_amount = r156_6months_amount;
	}
	public BigDecimal getR156_year_amount() {
		return r156_year_amount;
	}
	public void setR156_year_amount(BigDecimal r156_year_amount) {
		this.r156_year_amount = r156_year_amount;
	}
	public BigDecimal getR156_months_factor() {
		return r156_months_factor;
	}
	public void setR156_months_factor(BigDecimal r156_months_factor) {
		this.r156_months_factor = r156_months_factor;
	}
	public BigDecimal getR156_6months_factor() {
		return r156_6months_factor;
	}
	public void setR156_6months_factor(BigDecimal r156_6months_factor) {
		this.r156_6months_factor = r156_6months_factor;
	}
	public BigDecimal getR156_year_factor() {
		return r156_year_factor;
	}
	public void setR156_year_factor(BigDecimal r156_year_factor) {
		this.r156_year_factor = r156_year_factor;
	}
	public BigDecimal getR156_months_calculated() {
		return r156_months_calculated;
	}
	public void setR156_months_calculated(BigDecimal r156_months_calculated) {
		this.r156_months_calculated = r156_months_calculated;
	}
	public BigDecimal getR156_6months_calculated() {
		return r156_6months_calculated;
	}
	public void setR156_6months_calculated(BigDecimal r156_6months_calculated) {
		this.r156_6months_calculated = r156_6months_calculated;
	}
	public BigDecimal getR156_year_calculated() {
		return r156_year_calculated;
	}
	public void setR156_year_calculated(BigDecimal r156_year_calculated) {
		this.r156_year_calculated = r156_year_calculated;
	}
	public BigDecimal getR156_total_asf() {
		return r156_total_asf;
	}
	public void setR156_total_asf(BigDecimal r156_total_asf) {
		this.r156_total_asf = r156_total_asf;
	}
	public String getR157_product() {
		return r157_product;
	}
	public void setR157_product(String r157_product) {
		this.r157_product = r157_product;
	}
	public BigDecimal getR157_months_amount() {
		return r157_months_amount;
	}
	public void setR157_months_amount(BigDecimal r157_months_amount) {
		this.r157_months_amount = r157_months_amount;
	}
	public BigDecimal getR157_6months_amount() {
		return r157_6months_amount;
	}
	public void setR157_6months_amount(BigDecimal r157_6months_amount) {
		this.r157_6months_amount = r157_6months_amount;
	}
	public BigDecimal getR157_year_amount() {
		return r157_year_amount;
	}
	public void setR157_year_amount(BigDecimal r157_year_amount) {
		this.r157_year_amount = r157_year_amount;
	}
	public BigDecimal getR157_months_factor() {
		return r157_months_factor;
	}
	public void setR157_months_factor(BigDecimal r157_months_factor) {
		this.r157_months_factor = r157_months_factor;
	}
	public BigDecimal getR157_6months_factor() {
		return r157_6months_factor;
	}
	public void setR157_6months_factor(BigDecimal r157_6months_factor) {
		this.r157_6months_factor = r157_6months_factor;
	}
	public BigDecimal getR157_year_factor() {
		return r157_year_factor;
	}
	public void setR157_year_factor(BigDecimal r157_year_factor) {
		this.r157_year_factor = r157_year_factor;
	}
	public BigDecimal getR157_months_calculated() {
		return r157_months_calculated;
	}
	public void setR157_months_calculated(BigDecimal r157_months_calculated) {
		this.r157_months_calculated = r157_months_calculated;
	}
	public BigDecimal getR157_6months_calculated() {
		return r157_6months_calculated;
	}
	public void setR157_6months_calculated(BigDecimal r157_6months_calculated) {
		this.r157_6months_calculated = r157_6months_calculated;
	}
	public BigDecimal getR157_year_calculated() {
		return r157_year_calculated;
	}
	public void setR157_year_calculated(BigDecimal r157_year_calculated) {
		this.r157_year_calculated = r157_year_calculated;
	}
	public BigDecimal getR157_total_asf() {
		return r157_total_asf;
	}
	public void setR157_total_asf(BigDecimal r157_total_asf) {
		this.r157_total_asf = r157_total_asf;
	}
	public String getR158_product() {
		return r158_product;
	}
	public void setR158_product(String r158_product) {
		this.r158_product = r158_product;
	}
	public BigDecimal getR158_months_amount() {
		return r158_months_amount;
	}
	public void setR158_months_amount(BigDecimal r158_months_amount) {
		this.r158_months_amount = r158_months_amount;
	}
	public BigDecimal getR158_6months_amount() {
		return r158_6months_amount;
	}
	public void setR158_6months_amount(BigDecimal r158_6months_amount) {
		this.r158_6months_amount = r158_6months_amount;
	}
	public BigDecimal getR158_year_amount() {
		return r158_year_amount;
	}
	public void setR158_year_amount(BigDecimal r158_year_amount) {
		this.r158_year_amount = r158_year_amount;
	}
	public BigDecimal getR158_months_factor() {
		return r158_months_factor;
	}
	public void setR158_months_factor(BigDecimal r158_months_factor) {
		this.r158_months_factor = r158_months_factor;
	}
	public BigDecimal getR158_6months_factor() {
		return r158_6months_factor;
	}
	public void setR158_6months_factor(BigDecimal r158_6months_factor) {
		this.r158_6months_factor = r158_6months_factor;
	}
	public BigDecimal getR158_year_factor() {
		return r158_year_factor;
	}
	public void setR158_year_factor(BigDecimal r158_year_factor) {
		this.r158_year_factor = r158_year_factor;
	}
	public BigDecimal getR158_months_calculated() {
		return r158_months_calculated;
	}
	public void setR158_months_calculated(BigDecimal r158_months_calculated) {
		this.r158_months_calculated = r158_months_calculated;
	}
	public BigDecimal getR158_6months_calculated() {
		return r158_6months_calculated;
	}
	public void setR158_6months_calculated(BigDecimal r158_6months_calculated) {
		this.r158_6months_calculated = r158_6months_calculated;
	}
	public BigDecimal getR158_year_calculated() {
		return r158_year_calculated;
	}
	public void setR158_year_calculated(BigDecimal r158_year_calculated) {
		this.r158_year_calculated = r158_year_calculated;
	}
	public BigDecimal getR158_total_asf() {
		return r158_total_asf;
	}
	public void setR158_total_asf(BigDecimal r158_total_asf) {
		this.r158_total_asf = r158_total_asf;
	}
	public String getR159_product() {
		return r159_product;
	}
	public void setR159_product(String r159_product) {
		this.r159_product = r159_product;
	}
	public BigDecimal getR159_months_amount() {
		return r159_months_amount;
	}
	public void setR159_months_amount(BigDecimal r159_months_amount) {
		this.r159_months_amount = r159_months_amount;
	}
	public BigDecimal getR159_6months_amount() {
		return r159_6months_amount;
	}
	public void setR159_6months_amount(BigDecimal r159_6months_amount) {
		this.r159_6months_amount = r159_6months_amount;
	}
	public BigDecimal getR159_year_amount() {
		return r159_year_amount;
	}
	public void setR159_year_amount(BigDecimal r159_year_amount) {
		this.r159_year_amount = r159_year_amount;
	}
	public BigDecimal getR159_months_factor() {
		return r159_months_factor;
	}
	public void setR159_months_factor(BigDecimal r159_months_factor) {
		this.r159_months_factor = r159_months_factor;
	}
	public BigDecimal getR159_6months_factor() {
		return r159_6months_factor;
	}
	public void setR159_6months_factor(BigDecimal r159_6months_factor) {
		this.r159_6months_factor = r159_6months_factor;
	}
	public BigDecimal getR159_year_factor() {
		return r159_year_factor;
	}
	public void setR159_year_factor(BigDecimal r159_year_factor) {
		this.r159_year_factor = r159_year_factor;
	}
	public BigDecimal getR159_months_calculated() {
		return r159_months_calculated;
	}
	public void setR159_months_calculated(BigDecimal r159_months_calculated) {
		this.r159_months_calculated = r159_months_calculated;
	}
	public BigDecimal getR159_6months_calculated() {
		return r159_6months_calculated;
	}
	public void setR159_6months_calculated(BigDecimal r159_6months_calculated) {
		this.r159_6months_calculated = r159_6months_calculated;
	}
	public BigDecimal getR159_year_calculated() {
		return r159_year_calculated;
	}
	public void setR159_year_calculated(BigDecimal r159_year_calculated) {
		this.r159_year_calculated = r159_year_calculated;
	}
	public BigDecimal getR159_total_asf() {
		return r159_total_asf;
	}
	public void setR159_total_asf(BigDecimal r159_total_asf) {
		this.r159_total_asf = r159_total_asf;
	}
	public String getR160_product() {
		return r160_product;
	}
	public void setR160_product(String r160_product) {
		this.r160_product = r160_product;
	}
	public BigDecimal getR160_months_amount() {
		return r160_months_amount;
	}
	public void setR160_months_amount(BigDecimal r160_months_amount) {
		this.r160_months_amount = r160_months_amount;
	}
	public BigDecimal getR160_6months_amount() {
		return r160_6months_amount;
	}
	public void setR160_6months_amount(BigDecimal r160_6months_amount) {
		this.r160_6months_amount = r160_6months_amount;
	}
	public BigDecimal getR160_year_amount() {
		return r160_year_amount;
	}
	public void setR160_year_amount(BigDecimal r160_year_amount) {
		this.r160_year_amount = r160_year_amount;
	}
	public BigDecimal getR160_months_factor() {
		return r160_months_factor;
	}
	public void setR160_months_factor(BigDecimal r160_months_factor) {
		this.r160_months_factor = r160_months_factor;
	}
	public BigDecimal getR160_6months_factor() {
		return r160_6months_factor;
	}
	public void setR160_6months_factor(BigDecimal r160_6months_factor) {
		this.r160_6months_factor = r160_6months_factor;
	}
	public BigDecimal getR160_year_factor() {
		return r160_year_factor;
	}
	public void setR160_year_factor(BigDecimal r160_year_factor) {
		this.r160_year_factor = r160_year_factor;
	}
	public BigDecimal getR160_months_calculated() {
		return r160_months_calculated;
	}
	public void setR160_months_calculated(BigDecimal r160_months_calculated) {
		this.r160_months_calculated = r160_months_calculated;
	}
	public BigDecimal getR160_6months_calculated() {
		return r160_6months_calculated;
	}
	public void setR160_6months_calculated(BigDecimal r160_6months_calculated) {
		this.r160_6months_calculated = r160_6months_calculated;
	}
	public BigDecimal getR160_year_calculated() {
		return r160_year_calculated;
	}
	public void setR160_year_calculated(BigDecimal r160_year_calculated) {
		this.r160_year_calculated = r160_year_calculated;
	}
	public BigDecimal getR160_total_asf() {
		return r160_total_asf;
	}
	public void setR160_total_asf(BigDecimal r160_total_asf) {
		this.r160_total_asf = r160_total_asf;
	}
	public String getR161_product() {
		return r161_product;
	}
	public void setR161_product(String r161_product) {
		this.r161_product = r161_product;
	}
	public BigDecimal getR161_months_amount() {
		return r161_months_amount;
	}
	public void setR161_months_amount(BigDecimal r161_months_amount) {
		this.r161_months_amount = r161_months_amount;
	}
	public BigDecimal getR161_6months_amount() {
		return r161_6months_amount;
	}
	public void setR161_6months_amount(BigDecimal r161_6months_amount) {
		this.r161_6months_amount = r161_6months_amount;
	}
	public BigDecimal getR161_year_amount() {
		return r161_year_amount;
	}
	public void setR161_year_amount(BigDecimal r161_year_amount) {
		this.r161_year_amount = r161_year_amount;
	}
	public BigDecimal getR161_months_factor() {
		return r161_months_factor;
	}
	public void setR161_months_factor(BigDecimal r161_months_factor) {
		this.r161_months_factor = r161_months_factor;
	}
	public BigDecimal getR161_6months_factor() {
		return r161_6months_factor;
	}
	public void setR161_6months_factor(BigDecimal r161_6months_factor) {
		this.r161_6months_factor = r161_6months_factor;
	}
	public BigDecimal getR161_year_factor() {
		return r161_year_factor;
	}
	public void setR161_year_factor(BigDecimal r161_year_factor) {
		this.r161_year_factor = r161_year_factor;
	}
	public BigDecimal getR161_months_calculated() {
		return r161_months_calculated;
	}
	public void setR161_months_calculated(BigDecimal r161_months_calculated) {
		this.r161_months_calculated = r161_months_calculated;
	}
	public BigDecimal getR161_6months_calculated() {
		return r161_6months_calculated;
	}
	public void setR161_6months_calculated(BigDecimal r161_6months_calculated) {
		this.r161_6months_calculated = r161_6months_calculated;
	}
	public BigDecimal getR161_year_calculated() {
		return r161_year_calculated;
	}
	public void setR161_year_calculated(BigDecimal r161_year_calculated) {
		this.r161_year_calculated = r161_year_calculated;
	}
	public BigDecimal getR161_total_asf() {
		return r161_total_asf;
	}
	public void setR161_total_asf(BigDecimal r161_total_asf) {
		this.r161_total_asf = r161_total_asf;
	}
	public String getR162_product() {
		return r162_product;
	}
	public void setR162_product(String r162_product) {
		this.r162_product = r162_product;
	}
	public BigDecimal getR162_months_amount() {
		return r162_months_amount;
	}
	public void setR162_months_amount(BigDecimal r162_months_amount) {
		this.r162_months_amount = r162_months_amount;
	}
	public BigDecimal getR162_6months_amount() {
		return r162_6months_amount;
	}
	public void setR162_6months_amount(BigDecimal r162_6months_amount) {
		this.r162_6months_amount = r162_6months_amount;
	}
	public BigDecimal getR162_year_amount() {
		return r162_year_amount;
	}
	public void setR162_year_amount(BigDecimal r162_year_amount) {
		this.r162_year_amount = r162_year_amount;
	}
	public BigDecimal getR162_months_factor() {
		return r162_months_factor;
	}
	public void setR162_months_factor(BigDecimal r162_months_factor) {
		this.r162_months_factor = r162_months_factor;
	}
	public BigDecimal getR162_6months_factor() {
		return r162_6months_factor;
	}
	public void setR162_6months_factor(BigDecimal r162_6months_factor) {
		this.r162_6months_factor = r162_6months_factor;
	}
	public BigDecimal getR162_year_factor() {
		return r162_year_factor;
	}
	public void setR162_year_factor(BigDecimal r162_year_factor) {
		this.r162_year_factor = r162_year_factor;
	}
	public BigDecimal getR162_months_calculated() {
		return r162_months_calculated;
	}
	public void setR162_months_calculated(BigDecimal r162_months_calculated) {
		this.r162_months_calculated = r162_months_calculated;
	}
	public BigDecimal getR162_6months_calculated() {
		return r162_6months_calculated;
	}
	public void setR162_6months_calculated(BigDecimal r162_6months_calculated) {
		this.r162_6months_calculated = r162_6months_calculated;
	}
	public BigDecimal getR162_year_calculated() {
		return r162_year_calculated;
	}
	public void setR162_year_calculated(BigDecimal r162_year_calculated) {
		this.r162_year_calculated = r162_year_calculated;
	}
	public BigDecimal getR162_total_asf() {
		return r162_total_asf;
	}
	public void setR162_total_asf(BigDecimal r162_total_asf) {
		this.r162_total_asf = r162_total_asf;
	}
	public String getR163_product() {
		return r163_product;
	}
	public void setR163_product(String r163_product) {
		this.r163_product = r163_product;
	}
	public BigDecimal getR163_months_amount() {
		return r163_months_amount;
	}
	public void setR163_months_amount(BigDecimal r163_months_amount) {
		this.r163_months_amount = r163_months_amount;
	}
	public BigDecimal getR163_6months_amount() {
		return r163_6months_amount;
	}
	public void setR163_6months_amount(BigDecimal r163_6months_amount) {
		this.r163_6months_amount = r163_6months_amount;
	}
	public BigDecimal getR163_year_amount() {
		return r163_year_amount;
	}
	public void setR163_year_amount(BigDecimal r163_year_amount) {
		this.r163_year_amount = r163_year_amount;
	}
	public BigDecimal getR163_months_factor() {
		return r163_months_factor;
	}
	public void setR163_months_factor(BigDecimal r163_months_factor) {
		this.r163_months_factor = r163_months_factor;
	}
	public BigDecimal getR163_6months_factor() {
		return r163_6months_factor;
	}
	public void setR163_6months_factor(BigDecimal r163_6months_factor) {
		this.r163_6months_factor = r163_6months_factor;
	}
	public BigDecimal getR163_year_factor() {
		return r163_year_factor;
	}
	public void setR163_year_factor(BigDecimal r163_year_factor) {
		this.r163_year_factor = r163_year_factor;
	}
	public BigDecimal getR163_months_calculated() {
		return r163_months_calculated;
	}
	public void setR163_months_calculated(BigDecimal r163_months_calculated) {
		this.r163_months_calculated = r163_months_calculated;
	}
	public BigDecimal getR163_6months_calculated() {
		return r163_6months_calculated;
	}
	public void setR163_6months_calculated(BigDecimal r163_6months_calculated) {
		this.r163_6months_calculated = r163_6months_calculated;
	}
	public BigDecimal getR163_year_calculated() {
		return r163_year_calculated;
	}
	public void setR163_year_calculated(BigDecimal r163_year_calculated) {
		this.r163_year_calculated = r163_year_calculated;
	}
	public BigDecimal getR163_total_asf() {
		return r163_total_asf;
	}
	public void setR163_total_asf(BigDecimal r163_total_asf) {
		this.r163_total_asf = r163_total_asf;
	}
	public String getR165_product() {
		return r165_product;
	}
	public void setR165_product(String r165_product) {
		this.r165_product = r165_product;
	}
	public BigDecimal getR165_amount() {
		return r165_amount;
	}
	public void setR165_amount(BigDecimal r165_amount) {
		this.r165_amount = r165_amount;
	}
	public BigDecimal getR165_rfs_factor() {
		return r165_rfs_factor;
	}
	public void setR165_rfs_factor(BigDecimal r165_rfs_factor) {
		this.r165_rfs_factor = r165_rfs_factor;
	}
	public BigDecimal getR165_total_asf() {
		return r165_total_asf;
	}
	public void setR165_total_asf(BigDecimal r165_total_asf) {
		this.r165_total_asf = r165_total_asf;
	}
	public String getR166_product() {
		return r166_product;
	}
	public void setR166_product(String r166_product) {
		this.r166_product = r166_product;
	}
	public BigDecimal getR166_amount() {
		return r166_amount;
	}
	public void setR166_amount(BigDecimal r166_amount) {
		this.r166_amount = r166_amount;
	}
	public BigDecimal getR166_rfs_factor() {
		return r166_rfs_factor;
	}
	public void setR166_rfs_factor(BigDecimal r166_rfs_factor) {
		this.r166_rfs_factor = r166_rfs_factor;
	}
	public BigDecimal getR166_total_asf() {
		return r166_total_asf;
	}
	public void setR166_total_asf(BigDecimal r166_total_asf) {
		this.r166_total_asf = r166_total_asf;
	}
	public String getR167_product() {
		return r167_product;
	}
	public void setR167_product(String r167_product) {
		this.r167_product = r167_product;
	}
	public BigDecimal getR167_amount() {
		return r167_amount;
	}
	public void setR167_amount(BigDecimal r167_amount) {
		this.r167_amount = r167_amount;
	}
	public BigDecimal getR167_rfs_factor() {
		return r167_rfs_factor;
	}
	public void setR167_rfs_factor(BigDecimal r167_rfs_factor) {
		this.r167_rfs_factor = r167_rfs_factor;
	}
	public BigDecimal getR167_total_asf() {
		return r167_total_asf;
	}
	public void setR167_total_asf(BigDecimal r167_total_asf) {
		this.r167_total_asf = r167_total_asf;
	}
	public String getR168_product() {
		return r168_product;
	}
	public void setR168_product(String r168_product) {
		this.r168_product = r168_product;
	}
	public BigDecimal getR168_amount() {
		return r168_amount;
	}
	public void setR168_amount(BigDecimal r168_amount) {
		this.r168_amount = r168_amount;
	}
	public BigDecimal getR168_rfs_factor() {
		return r168_rfs_factor;
	}
	public void setR168_rfs_factor(BigDecimal r168_rfs_factor) {
		this.r168_rfs_factor = r168_rfs_factor;
	}
	public BigDecimal getR168_total_asf() {
		return r168_total_asf;
	}
	public void setR168_total_asf(BigDecimal r168_total_asf) {
		this.r168_total_asf = r168_total_asf;
	}
	public String getR169_product() {
		return r169_product;
	}
	public void setR169_product(String r169_product) {
		this.r169_product = r169_product;
	}
	public BigDecimal getR169_amount() {
		return r169_amount;
	}
	public void setR169_amount(BigDecimal r169_amount) {
		this.r169_amount = r169_amount;
	}
	public BigDecimal getR169_rfs_factor() {
		return r169_rfs_factor;
	}
	public void setR169_rfs_factor(BigDecimal r169_rfs_factor) {
		this.r169_rfs_factor = r169_rfs_factor;
	}
	public BigDecimal getR169_total_asf() {
		return r169_total_asf;
	}
	public void setR169_total_asf(BigDecimal r169_total_asf) {
		this.r169_total_asf = r169_total_asf;
	}
	public String getR170_product() {
		return r170_product;
	}
	public void setR170_product(String r170_product) {
		this.r170_product = r170_product;
	}
	public String getR170_total_asf() {
		return r170_total_asf;
	}
	public void setR170_total_asf(String r170_total_asf) {
		this.r170_total_asf = r170_total_asf;
	}
	public BigDecimal getR170_total_rsf() {
		return r170_total_rsf;
	}
	public void setR170_total_rsf(BigDecimal r170_total_rsf) {
		this.r170_total_rsf = r170_total_rsf;
	}
	public String getR171_product() {
		return r171_product;
	}
	public void setR171_product(String r171_product) {
		this.r171_product = r171_product;
	}
	public String getR171_nsfr() {
		return r171_nsfr;
	}
	public void setR171_nsfr(String r171_nsfr) {
		this.r171_nsfr = r171_nsfr;
	}
	public BigDecimal getR171_total_asf() {
		return r171_total_asf;
	}
	public void setR171_total_asf(BigDecimal r171_total_asf) {
		this.r171_total_asf = r171_total_asf;
	}
	public String getR174_product() {
		return r174_product;
	}
	public void setR174_product(String r174_product) {
		this.r174_product = r174_product;
	}
	public BigDecimal getR174_months_amount() {
		return r174_months_amount;
	}
	public void setR174_months_amount(BigDecimal r174_months_amount) {
		this.r174_months_amount = r174_months_amount;
	}
	public BigDecimal getR174_6months_amount() {
		return r174_6months_amount;
	}
	public void setR174_6months_amount(BigDecimal r174_6months_amount) {
		this.r174_6months_amount = r174_6months_amount;
	}
	public BigDecimal getR174_year_amount() {
		return r174_year_amount;
	}
	public void setR174_year_amount(BigDecimal r174_year_amount) {
		this.r174_year_amount = r174_year_amount;
	}
	public BigDecimal getR174_months_factor() {
		return r174_months_factor;
	}
	public void setR174_months_factor(BigDecimal r174_months_factor) {
		this.r174_months_factor = r174_months_factor;
	}
	public BigDecimal getR174_6months_factor() {
		return r174_6months_factor;
	}
	public void setR174_6months_factor(BigDecimal r174_6months_factor) {
		this.r174_6months_factor = r174_6months_factor;
	}
	public BigDecimal getR174_year_factor() {
		return r174_year_factor;
	}
	public void setR174_year_factor(BigDecimal r174_year_factor) {
		this.r174_year_factor = r174_year_factor;
	}
	public BigDecimal getR174_months_calculated() {
		return r174_months_calculated;
	}
	public void setR174_months_calculated(BigDecimal r174_months_calculated) {
		this.r174_months_calculated = r174_months_calculated;
	}
	public BigDecimal getR174_6months_calculated() {
		return r174_6months_calculated;
	}
	public void setR174_6months_calculated(BigDecimal r174_6months_calculated) {
		this.r174_6months_calculated = r174_6months_calculated;
	}
	public BigDecimal getR174_year_calculated() {
		return r174_year_calculated;
	}
	public void setR174_year_calculated(BigDecimal r174_year_calculated) {
		this.r174_year_calculated = r174_year_calculated;
	}
	public BigDecimal getR174_total_asf() {
		return r174_total_asf;
	}
	public void setR174_total_asf(BigDecimal r174_total_asf) {
		this.r174_total_asf = r174_total_asf;
	}
	public String getR175_nsfr() {
		return r175_nsfr;
	}
	public void setR175_nsfr(String r175_nsfr) {
		this.r175_nsfr = r175_nsfr;
	}
	public BigDecimal getR175_total_asf() {
		return r175_total_asf;
	}
	public void setR175_total_asf(BigDecimal r175_total_asf) {
		this.r175_total_asf = r175_total_asf;
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
	public String getR48_product() {
		return r48_product;
	}
	public void setR48_product(String r48_product) {
		this.r48_product = r48_product;
	}
	public BigDecimal getR48_total_asp() {
		return r48_total_asp;
	}
	public void setR48_total_asp(BigDecimal r48_total_asp) {
		this.r48_total_asp = r48_total_asp;
	}
	public BigDecimal getR59_year_amount() {
		return r59_year_amount;
	}
	public void setR59_year_amount(BigDecimal r59_year_amount) {
		this.r59_year_amount = r59_year_amount;
	}
	public BigDecimal getR59_6month_amount() {
		return r59_6month_amount;
	}
	public void setR59_6month_amount(BigDecimal r59_6month_amount) {
		this.r59_6month_amount = r59_6month_amount;
	}
	public BigDecimal getR84_year_amount() {
		return r84_year_amount;
	}
	public void setR84_year_amount(BigDecimal r84_year_amount) {
		this.r84_year_amount = r84_year_amount;
	}
	public BigDecimal getR85_year_amount() {
		return r85_year_amount;
	}
	public void setR85_year_amount(BigDecimal r85_year_amount) {
		this.r85_year_amount = r85_year_amount;
	}
	public BigDecimal getR86_year_amount() {
		return r86_year_amount;
	}
	public void setR86_year_amount(BigDecimal r86_year_amount) {
		this.r86_year_amount = r86_year_amount;
	}
	public BigDecimal getR87_year_amount() {
		return r87_year_amount;
	}
	public void setR87_year_amount(BigDecimal r87_year_amount) {
		this.r87_year_amount = r87_year_amount;
	}
	public BigDecimal getR93_month_amount() {
		return r93_month_amount;
	}
	public void setR93_month_amount(BigDecimal r93_month_amount) {
		this.r93_month_amount = r93_month_amount;
	}
	public BigDecimal getR93_6month_amount() {
		return r93_6month_amount;
	}
	public void setR93_6month_amount(BigDecimal r93_6month_amount) {
		this.r93_6month_amount = r93_6month_amount;
	}
	public BigDecimal getR29_month_calculated() {
		return r29_month_calculated;
	}
	public void setR29_month_calculated(BigDecimal r29_month_calculated) {
		this.r29_month_calculated = r29_month_calculated;
	}
	public BigDecimal getR29_6month_calculated() {
		return r29_6month_calculated;
	}
	public void setR29_6month_calculated(BigDecimal r29_6month_calculated) {
		this.r29_6month_calculated = r29_6month_calculated;
	}
	public BigDecimal getR29_year_calculated() {
		return r29_year_calculated;
	}
	public void setR29_year_calculated(BigDecimal r29_year_calculated) {
		this.r29_year_calculated = r29_year_calculated;
	}
	public BigDecimal getR29_total_asf() {
		return r29_total_asf;
	}
	public void setR29_total_asf(BigDecimal r29_total_asf) {
		this.r29_total_asf = r29_total_asf;
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
	public BRF49_Entity() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
