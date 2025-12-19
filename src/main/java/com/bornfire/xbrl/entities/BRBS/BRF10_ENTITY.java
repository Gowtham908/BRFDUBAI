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
@Table(name="BRF10_SUMMARYTABLE")
public class BRF10_ENTITY{
	private String	r10_product;
	private BigDecimal	r10_6month_uae;
	private BigDecimal	r10_12month_uae;
	private BigDecimal	r10_1year_uae;
	private BigDecimal	r10_6month_other_uae;
	private BigDecimal	r10_12month_other_uae;
	private BigDecimal	r10_1year_other_uae;
	private BigDecimal	r10_6month_non_uae;
	private BigDecimal	r10_12month_non_uae;
	private BigDecimal	r10_1year_non_uae;
	private BigDecimal	r10_6month_other_non_uae;
	private BigDecimal	r10_12month_other_non_uae;
	private BigDecimal	r10_1year_other_non_uae;
	private BigDecimal	r10_other_assets;
	private BigDecimal	r10_total_assets;
	private BigDecimal	r10_total_libilities;
	private BigDecimal	r10_net_forward;
	private BigDecimal	r10_net_overall;
	private String	r11_product;
	private BigDecimal	r11_6month_uae;
	private BigDecimal	r11_12month_uae;
	private BigDecimal	r11_1year_uae;
	private BigDecimal	r11_6month_other_uae;
	private BigDecimal	r11_12month_other_uae;
	private BigDecimal	r11_1year_other_uae;
	private BigDecimal	r11_6month_non_uae;
	private BigDecimal	r11_12month_non_uae;
	private BigDecimal	r11_1year_non_uae;
	private BigDecimal	r11_6month_other_non_uae;
	private BigDecimal	r11_12month_other_non_uae;
	private BigDecimal	r11_1year_other_non_uae;
	private BigDecimal	r11_other_assets;
	private BigDecimal	r11_total_assets;
	private BigDecimal	r11_total_libilities;
	private BigDecimal	r11_net_forward;
	private BigDecimal	r11_net_overall;
	private String	r12_product;
	private BigDecimal	r12_6month_uae;
	private BigDecimal	r12_12month_uae;
	private BigDecimal	r12_1year_uae;
	private BigDecimal	r12_6month_other_uae;
	private BigDecimal	r12_12month_other_uae;
	private BigDecimal	r12_1year_other_uae;
	private BigDecimal	r12_6month_non_uae;
	private BigDecimal	r12_12month_non_uae;
	private BigDecimal	r12_1year_non_uae;
	private BigDecimal	r12_6month_other_non_uae;
	private BigDecimal	r12_12month_other_non_uae;
	private BigDecimal	r12_1year_other_non_uae;
	private BigDecimal	r12_other_assets;
	private BigDecimal	r12_total_assets;
	private BigDecimal	r12_total_libilities;
	private BigDecimal	r12_net_forward;
	private BigDecimal	r12_net_overall;
	private String	r13_product;
	private BigDecimal	r13_6month_uae;
	private BigDecimal	r13_12month_uae;
	private BigDecimal	r13_1year_uae;
	private BigDecimal	r13_6month_other_uae;
	private BigDecimal	r13_12month_other_uae;
	private BigDecimal	r13_1year_other_uae;
	private BigDecimal	r13_6month_non_uae;
	private BigDecimal	r13_12month_non_uae;
	private BigDecimal	r13_1year_non_uae;
	private BigDecimal	r13_6month_other_non_uae;
	private BigDecimal	r13_12month_other_non_uae;
	private BigDecimal	r13_1year_other_non_uae;
	private BigDecimal	r13_other_assets;
	private BigDecimal	r13_total_assets;
	private BigDecimal	r13_total_libilities;
	private BigDecimal	r13_net_forward;
	private BigDecimal	r13_net_overall;
	private String	r14_product;
	private BigDecimal	r14_6month_uae;
	private BigDecimal	r14_12month_uae;
	private BigDecimal	r14_1year_uae;
	private BigDecimal	r14_6month_other_uae;
	private BigDecimal	r14_12month_other_uae;
	private BigDecimal	r14_1year_other_uae;
	private BigDecimal	r14_6month_non_uae;
	private BigDecimal	r14_12month_non_uae;
	private BigDecimal	r14_1year_non_uae;
	private BigDecimal	r14_6month_other_non_uae;
	private BigDecimal	r14_12month_other_non_uae;
	private BigDecimal	r14_1year_other_non_uae;
	private BigDecimal	r14_other_assets;
	private BigDecimal	r14_total_assets;
	private BigDecimal	r14_total_libilities;
	private BigDecimal	r14_net_forward;
	private BigDecimal	r14_net_overall;
	private String	r15_product;
	private BigDecimal	r15_6month_uae;
	private BigDecimal	r15_12month_uae;
	private BigDecimal	r15_1year_uae;
	private BigDecimal	r15_6month_other_uae;
	private BigDecimal	r15_12month_other_uae;
	private BigDecimal	r15_1year_other_uae;
	private BigDecimal	r15_6month_non_uae;
	private BigDecimal	r15_12month_non_uae;
	private BigDecimal	r15_1year_non_uae;
	private BigDecimal	r15_6month_other_non_uae;
	private BigDecimal	r15_12month_other_non_uae;
	private BigDecimal	r15_1year_other_non_uae;
	private BigDecimal	r15_other_assets;
	private BigDecimal	r15_total_assets;
	private BigDecimal	r15_total_libilities;
	private BigDecimal	r15_net_forward;
	private BigDecimal	r15_net_overall;
	private String	r16_product;
	private BigDecimal	r16_6month_uae;
	private BigDecimal	r16_12month_uae;
	private BigDecimal	r16_1year_uae;
	private BigDecimal	r16_6month_other_uae;
	private BigDecimal	r16_12month_other_uae;
	private BigDecimal	r16_1year_other_uae;
	private BigDecimal	r16_6month_non_uae;
	private BigDecimal	r16_12month_non_uae;
	private BigDecimal	r16_1year_non_uae;
	private BigDecimal	r16_6month_other_non_uae;
	private BigDecimal	r16_12month_other_non_uae;
	private BigDecimal	r16_1year_other_non_uae;
	private BigDecimal	r16_other_assets;
	private BigDecimal	r16_total_assets;
	private BigDecimal	r16_total_libilities;
	private BigDecimal	r16_net_forward;
	private BigDecimal	r16_net_overall;
	private String	r17_product;
	private BigDecimal	r17_6month_uae;
	private BigDecimal	r17_12month_uae;
	private BigDecimal	r17_1year_uae;
	private BigDecimal	r17_6month_other_uae;
	private BigDecimal	r17_12month_other_uae;
	private BigDecimal	r17_1year_other_uae;
	private BigDecimal	r17_6month_non_uae;
	private BigDecimal	r17_12month_non_uae;
	private BigDecimal	r17_1year_non_uae;
	private BigDecimal	r17_6month_other_non_uae;
	private BigDecimal	r17_12month_other_non_uae;
	private BigDecimal	r17_1year_other_non_uae;
	private BigDecimal	r17_other_assets;
	private BigDecimal	r17_total_assets;
	private BigDecimal	r17_total_libilities;
	private BigDecimal	r17_net_forward;
	private BigDecimal	r17_net_overall;
	private String	r18_product;
	private BigDecimal	r18_6month_uae;
	private BigDecimal	r18_12month_uae;
	private BigDecimal	r18_1year_uae;
	private BigDecimal	r18_6month_other_uae;
	private BigDecimal	r18_12month_other_uae;
	private BigDecimal	r18_1year_other_uae;
	private BigDecimal	r18_6month_non_uae;
	private BigDecimal	r18_12month_non_uae;
	private BigDecimal	r18_1year_non_uae;
	private BigDecimal	r18_6month_other_non_uae;
	private BigDecimal	r18_12month_other_non_uae;
	private BigDecimal	r18_1year_other_non_uae;
	private BigDecimal	r18_other_assets;
	private BigDecimal	r18_total_assets;
	private BigDecimal	r18_total_libilities;
	private BigDecimal	r18_net_forward;
	private BigDecimal	r18_net_overall;
	private String	r19_product;
	private BigDecimal	r19_6month_uae;
	private BigDecimal	r19_12month_uae;
	private BigDecimal	r19_1year_uae;
	private BigDecimal	r19_6month_other_uae;
	private BigDecimal	r19_12month_other_uae;
	private BigDecimal	r19_1year_other_uae;
	private BigDecimal	r19_6month_non_uae;
	private BigDecimal	r19_12month_non_uae;
	private BigDecimal	r19_1year_non_uae;
	private BigDecimal	r19_6month_other_non_uae;
	private BigDecimal	r19_12month_other_non_uae;
	private BigDecimal	r19_1year_other_non_uae;
	private BigDecimal	r19_other_assets;
	private BigDecimal	r19_total_assets;
	private BigDecimal	r19_total_libilities;
	private BigDecimal	r19_net_forward;
	private BigDecimal	r19_net_overall;
	private String	r20_product;
	private BigDecimal	r20_6month_uae;
	private BigDecimal	r20_12month_uae;
	private BigDecimal	r20_1year_uae;
	private BigDecimal	r20_6month_other_uae;
	private BigDecimal	r20_12month_other_uae;
	private BigDecimal	r20_1year_other_uae;
	private BigDecimal	r20_6month_non_uae;
	private BigDecimal	r20_12month_non_uae;
	private BigDecimal	r20_1year_non_uae;
	private BigDecimal	r20_6month_other_non_uae;
	private BigDecimal	r20_12month_other_non_uae;
	private BigDecimal	r20_1year_other_non_uae;
	private BigDecimal	r20_other_assets;
	private BigDecimal	r20_total_assets;
	private BigDecimal	r20_total_libilities;
	private BigDecimal	r20_net_forward;
	private BigDecimal	r20_net_overall;
	private String	r21_total;
	private BigDecimal	r21_6month_uae;
	private BigDecimal	r21_12month_uae;
	private BigDecimal	r21_1year_uae;
	private BigDecimal	r21_6month_other_uae;
	private BigDecimal	r21_12month_other_uae;
	private BigDecimal	r21_1year_other_uae;
	private BigDecimal	r21_6month_non_uae;
	private BigDecimal	r21_12month_non_uae;
	private BigDecimal	r21_1year_non_uae;
	private BigDecimal	r21_6month_other_non_uae;
	private BigDecimal	r21_12month_other_non_uae;
	private BigDecimal	r21_1year_other_non_uae;
	private BigDecimal	r21_other_assets;
	private BigDecimal	r21_total_assets;
	private BigDecimal	r21_total_libilities;
	private BigDecimal	r21_net_forward;
	private BigDecimal	r21_net_overall;
	private String	r22_product;
	private BigDecimal	r22_6month_uae;
	private BigDecimal	r22_12month_uae;
	private BigDecimal	r22_1year_uae;
	private BigDecimal	r22_6month_other_uae;
	private BigDecimal	r22_12month_other_uae;
	private BigDecimal	r22_1year_other_uae;
	private BigDecimal	r22_6month_non_uae;
	private BigDecimal	r22_12month_non_uae;
	private BigDecimal	r22_1year_non_uae;
	private BigDecimal	r22_6month_other_non_uae;
	private BigDecimal	r22_12month_other_non_uae;
	private BigDecimal	r22_1year_other_non_uae;
	private BigDecimal	r22_other_assets;
	private BigDecimal	r22_total_assets;
	private BigDecimal	r22_total_libilities;
	private BigDecimal	r22_net_forward;
	private BigDecimal	r22_net_overall;
	private String	r23_product;
	private BigDecimal	r23_6month_uae;
	private BigDecimal	r23_12month_uae;
	private BigDecimal	r23_1year_uae;
	private BigDecimal	r23_6month_other_uae;
	private BigDecimal	r23_12month_other_uae;
	private BigDecimal	r23_1year_other_uae;
	private BigDecimal	r23_6month_non_uae;
	private BigDecimal	r23_12month_non_uae;
	private BigDecimal	r23_1year_non_uae;
	private BigDecimal	r23_6month_other_non_uae;
	private BigDecimal	r23_12month_other_non_uae;
	private BigDecimal	r23_1year_other_non_uae;
	private BigDecimal	r23_other_assets;
	private BigDecimal	r23_total_assets;
	private BigDecimal	r23_total_libilities;
	private BigDecimal	r23_net_forward;
	private BigDecimal	r23_net_overall;
	private String	r24_product;
	private BigDecimal	r24_6month_uae;
	private BigDecimal	r24_12month_uae;
	private BigDecimal	r24_1year_uae;
	private BigDecimal	r24_6month_other_uae;
	private BigDecimal	r24_12month_other_uae;
	private BigDecimal	r24_1year_other_uae;
	private BigDecimal	r24_6month_non_uae;
	private BigDecimal	r24_12month_non_uae;
	private BigDecimal	r24_1year_non_uae;
	private BigDecimal	r24_6month_other_non_uae;
	private BigDecimal	r24_12month_other_non_uae;
	private BigDecimal	r24_1year_other_non_uae;
	private BigDecimal	r24_other_assets;
	private BigDecimal	r24_total_assets;
	private BigDecimal	r24_total_libilities;
	private BigDecimal	r24_net_forward;
	private BigDecimal	r24_net_overall;
	private String	r25_product;
	private BigDecimal	r25_6month_uae;
	private BigDecimal	r25_12month_uae;
	private BigDecimal	r25_1year_uae;
	private BigDecimal	r25_6month_other_uae;
	private BigDecimal	r25_12month_other_uae;
	private BigDecimal	r25_1year_other_uae;
	private BigDecimal	r25_6month_non_uae;
	private BigDecimal	r25_12month_non_uae;
	private BigDecimal	r25_1year_non_uae;
	private BigDecimal	r25_6month_other_non_uae;
	private BigDecimal	r25_12month_other_non_uae;
	private BigDecimal	r25_1year_other_non_uae;
	private BigDecimal	r25_other_assets;
	private BigDecimal	r25_total_assets;
	private BigDecimal	r25_total_libilities;
	private BigDecimal	r25_net_forward;
	private BigDecimal	r25_net_overall;
	private String	r30_product;
	private BigDecimal	r30_6month_uae;
	private BigDecimal	r30_12month_uae;
	private BigDecimal	r30_1year_uae;
	private BigDecimal	r30_6month_other_uae;
	private BigDecimal	r30_12month_other_uae;
	private BigDecimal	r30_1year_other_uae;
	private BigDecimal	r30_6month_non_uae;
	private BigDecimal	r30_12month_non_uae;
	private BigDecimal	r30_1year_non_uae;
	private BigDecimal	r30_6month_other_non_uae;
	private BigDecimal	r30_12month_other_non_uae;
	private BigDecimal	r30_1year_other_non_uae;
	private BigDecimal	r30_total_libilities;
	private BigDecimal	r30_total_spot;
	private String	r31_product;
	private BigDecimal	r31_6month_uae;
	private BigDecimal	r31_12month_uae;
	private BigDecimal	r31_1year_uae;
	private BigDecimal	r31_6month_other_uae;
	private BigDecimal	r31_12month_other_uae;
	private BigDecimal	r31_1year_other_uae;
	private BigDecimal	r31_6month_non_uae;
	private BigDecimal	r31_12month_non_uae;
	private BigDecimal	r31_1year_non_uae;
	private BigDecimal	r31_6month_other_non_uae;
	private BigDecimal	r31_12month_other_non_uae;
	private BigDecimal	r31_1year_other_non_uae;
	private BigDecimal	r31_total_libilities;
	private BigDecimal	r31_total_spot;
	private String	r32_product;
	private BigDecimal	r32_6month_uae;
	private BigDecimal	r32_12month_uae;
	private BigDecimal	r32_1year_uae;
	private BigDecimal	r32_6month_other_uae;
	private BigDecimal	r32_12month_other_uae;
	private BigDecimal	r32_1year_other_uae;
	private BigDecimal	r32_6month_non_uae;
	private BigDecimal	r32_12month_non_uae;
	private BigDecimal	r32_1year_non_uae;
	private BigDecimal	r32_6month_other_non_uae;
	private BigDecimal	r32_12month_other_non_uae;
	private BigDecimal	r32_1year_other_non_uae;
	private BigDecimal	r32_total_libilities;
	private BigDecimal	r32_total_spot;
	private String	r33_product;
	private BigDecimal	r33_6month_uae;
	private BigDecimal	r33_12month_uae;
	private BigDecimal	r33_1year_uae;
	private BigDecimal	r33_6month_other_uae;
	private BigDecimal	r33_12month_other_uae;
	private BigDecimal	r33_1year_other_uae;
	private BigDecimal	r33_6month_non_uae;
	private BigDecimal	r33_12month_non_uae;
	private BigDecimal	r33_1year_non_uae;
	private BigDecimal	r33_6month_other_non_uae;
	private BigDecimal	r33_12month_other_non_uae;
	private BigDecimal	r33_1year_other_non_uae;
	private BigDecimal	r33_total_libilities;
	private BigDecimal	r33_total_spot;
	private String	r34_product;
	private BigDecimal	r34_6month_uae;
	private BigDecimal	r34_12month_uae;
	private BigDecimal	r34_1year_uae;
	private BigDecimal	r34_6month_other_uae;
	private BigDecimal	r34_12month_other_uae;
	private BigDecimal	r34_1year_other_uae;
	private BigDecimal	r34_6month_non_uae;
	private BigDecimal	r34_12month_non_uae;
	private BigDecimal	r34_1year_non_uae;
	private BigDecimal	r34_6month_other_non_uae;
	private BigDecimal	r34_12month_other_non_uae;
	private BigDecimal	r34_1year_other_non_uae;
	private BigDecimal	r34_total_libilities;
	private BigDecimal	r34_total_spot;
	private String	r35_product;
	private BigDecimal	r35_6month_uae;
	private BigDecimal	r35_12month_uae;
	private BigDecimal	r35_1year_uae;
	private BigDecimal	r35_6month_other_uae;
	private BigDecimal	r35_12month_other_uae;
	private BigDecimal	r35_1year_other_uae;
	private BigDecimal	r35_6month_non_uae;
	private BigDecimal	r35_12month_non_uae;
	private BigDecimal	r35_1year_non_uae;
	private BigDecimal	r35_6month_other_non_uae;
	private BigDecimal	r35_12month_other_non_uae;
	private BigDecimal	r35_1year_other_non_uae;
	private BigDecimal	r35_total_libilities;
	private BigDecimal	r35_total_spot;
	private String	r36_product;
	private BigDecimal	r36_6month_uae;
	private BigDecimal	r36_12month_uae;
	private BigDecimal	r36_1year_uae;
	private BigDecimal	r36_6month_other_uae;
	private BigDecimal	r36_12month_other_uae;
	private BigDecimal	r36_1year_other_uae;
	private BigDecimal	r36_6month_non_uae;
	private BigDecimal	r36_12month_non_uae;
	private BigDecimal	r36_1year_non_uae;
	private BigDecimal	r36_6month_other_non_uae;
	private BigDecimal	r36_12month_other_non_uae;
	private BigDecimal	r36_1year_other_non_uae;
	private BigDecimal	r36_total_libilities;
	private BigDecimal	r36_total_spot;
	private String	r37_product;
	private BigDecimal	r37_6month_uae;
	private BigDecimal	r37_12month_uae;
	private BigDecimal	r37_1year_uae;
	private BigDecimal	r37_6month_other_uae;
	private BigDecimal	r37_12month_other_uae;
	private BigDecimal	r37_1year_other_uae;
	private BigDecimal	r37_6month_non_uae;
	private BigDecimal	r37_12month_non_uae;
	private BigDecimal	r37_1year_non_uae;
	private BigDecimal	r37_6month_other_non_uae;
	private BigDecimal	r37_12month_other_non_uae;
	private BigDecimal	r37_1year_other_non_uae;
	private BigDecimal	r37_total_libilities;
	private BigDecimal	r37_total_spot;
	private String	r38_product;
	private BigDecimal	r38_6month_uae;
	private BigDecimal	r38_12month_uae;
	private BigDecimal	r38_1year_uae;
	private BigDecimal	r38_6month_other_uae;
	private BigDecimal	r38_12month_other_uae;
	private BigDecimal	r38_1year_other_uae;
	private BigDecimal	r38_6month_non_uae;
	private BigDecimal	r38_12month_non_uae;
	private BigDecimal	r38_1year_non_uae;
	private BigDecimal	r38_6month_other_non_uae;
	private BigDecimal	r38_12month_other_non_uae;
	private BigDecimal	r38_1year_other_non_uae;
	private BigDecimal	r38_total_libilities;
	private BigDecimal	r38_total_spot;
	private String	r39_product;
	private BigDecimal	r39_6month_uae;
	private BigDecimal	r39_12month_uae;
	private BigDecimal	r39_1year_uae;
	private BigDecimal	r39_6month_other_uae;
	private BigDecimal	r39_12month_other_uae;
	private BigDecimal	r39_1year_other_uae;
	private BigDecimal	r39_6month_non_uae;
	private BigDecimal	r39_12month_non_uae;
	private BigDecimal	r39_1year_non_uae;
	private BigDecimal	r39_6month_other_non_uae;
	private BigDecimal	r39_12month_other_non_uae;
	private BigDecimal	r39_1year_other_non_uae;
	private BigDecimal	r39_total_libilities;
	private BigDecimal	r39_total_spot;
	private String	r40_product;
	private BigDecimal	r40_6month_uae;
	private BigDecimal	r40_12month_uae;
	private BigDecimal	r40_1year_uae;
	private BigDecimal	r40_6month_other_uae;
	private BigDecimal	r40_12month_other_uae;
	private BigDecimal	r40_1year_other_uae;
	private BigDecimal	r40_6month_non_uae;
	private BigDecimal	r40_12month_non_uae;
	private BigDecimal	r40_1year_non_uae;
	private BigDecimal	r40_6month_other_non_uae;
	private BigDecimal	r40_12month_other_non_uae;
	private BigDecimal	r40_1year_other_non_uae;
	private BigDecimal	r40_total_libilities;
	private BigDecimal	r40_total_spot;
	private String	r41_total;
	private BigDecimal	r41_6month_uae;
	private BigDecimal	r41_12month_uae;
	private BigDecimal	r41_1year_uae;
	private BigDecimal	r41_6month_other_uae;
	private BigDecimal	r41_12month_other_uae;
	private BigDecimal	r41_1year_other_uae;
	private BigDecimal	r41_6month_non_uae;
	private BigDecimal	r41_12month_non_uae;
	private BigDecimal	r41_1year_non_uae;
	private BigDecimal	r41_6month_other_non_uae;
	private BigDecimal	r41_12month_other_non_uae;
	private BigDecimal	r41_1year_other_non_uae;
	private BigDecimal	r41_total_libilities;
	private BigDecimal	r41_total_spot;
	private String	r43_product;
	private BigDecimal	r43_6month_uae;
	private BigDecimal	r43_12month_uae;
	private BigDecimal	r43_1year_uae;
	private BigDecimal	r43_6month_other_uae;
	private BigDecimal	r43_12month_other_uae;
	private BigDecimal	r43_1year_other_uae;
	private BigDecimal	r43_6month_non_uae;
	private BigDecimal	r43_12month_non_uae;
	private BigDecimal	r43_1year_non_uae;
	private BigDecimal	r43_6month_other_non_uae;
	private BigDecimal	r43_12month_other_non_uae;
	private BigDecimal	r43_1year_other_non_uae;
	private BigDecimal	r43_total_libilities;
	private BigDecimal	r43_total_spot;
	private String	r44_product;
	private BigDecimal	r44_6month_uae;
	private BigDecimal	r44_12month_uae;
	private BigDecimal	r44_1year_uae;
	private BigDecimal	r44_6month_other_uae;
	private BigDecimal	r44_12month_other_uae;
	private BigDecimal	r44_1year_other_uae;
	private BigDecimal	r44_6month_non_uae;
	private BigDecimal	r44_12month_non_uae;
	private BigDecimal	r44_1year_non_uae;
	private BigDecimal	r44_6month_other_non_uae;
	private BigDecimal	r44_12month_other_non_uae;
	private BigDecimal	r44_1year_other_non_uae;
	private BigDecimal	r44_total_libilities;
	private BigDecimal	r44_total_spot;
	private String	r45_product;
	private BigDecimal	r45_6month_uae;
	private BigDecimal	r45_12month_uae;
	private BigDecimal	r45_1year_uae;
	private BigDecimal	r45_6month_other_uae;
	private BigDecimal	r45_12month_other_uae;
	private BigDecimal	r45_1year_other_uae;
	private BigDecimal	r45_6month_non_uae;
	private BigDecimal	r45_12month_non_uae;
	private BigDecimal	r45_1year_non_uae;
	private BigDecimal	r45_6month_other_non_uae;
	private BigDecimal	r45_12month_other_non_uae;
	private BigDecimal	r45_1year_other_non_uae;
	private BigDecimal	r45_total_libilities;
	private BigDecimal	r45_total_spot;
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
	public String getR10_product() {
		return r10_product;
	}
	public void setR10_product(String r10_product) {
		this.r10_product = r10_product;
	}
	public BigDecimal getR10_6month_uae() {
		return r10_6month_uae;
	}
	public void setR10_6month_uae(BigDecimal r10_6month_uae) {
		this.r10_6month_uae = r10_6month_uae;
	}
	public BigDecimal getR10_12month_uae() {
		return r10_12month_uae;
	}
	public void setR10_12month_uae(BigDecimal r10_12month_uae) {
		this.r10_12month_uae = r10_12month_uae;
	}
	public BigDecimal getR10_1year_uae() {
		return r10_1year_uae;
	}
	public void setR10_1year_uae(BigDecimal r10_1year_uae) {
		this.r10_1year_uae = r10_1year_uae;
	}
	public BigDecimal getR10_6month_other_uae() {
		return r10_6month_other_uae;
	}
	public void setR10_6month_other_uae(BigDecimal r10_6month_other_uae) {
		this.r10_6month_other_uae = r10_6month_other_uae;
	}
	public BigDecimal getR10_12month_other_uae() {
		return r10_12month_other_uae;
	}
	public void setR10_12month_other_uae(BigDecimal r10_12month_other_uae) {
		this.r10_12month_other_uae = r10_12month_other_uae;
	}
	public BigDecimal getR10_1year_other_uae() {
		return r10_1year_other_uae;
	}
	public void setR10_1year_other_uae(BigDecimal r10_1year_other_uae) {
		this.r10_1year_other_uae = r10_1year_other_uae;
	}
	public BigDecimal getR10_6month_non_uae() {
		return r10_6month_non_uae;
	}
	public void setR10_6month_non_uae(BigDecimal r10_6month_non_uae) {
		this.r10_6month_non_uae = r10_6month_non_uae;
	}
	public BigDecimal getR10_12month_non_uae() {
		return r10_12month_non_uae;
	}
	public void setR10_12month_non_uae(BigDecimal r10_12month_non_uae) {
		this.r10_12month_non_uae = r10_12month_non_uae;
	}
	public BigDecimal getR10_1year_non_uae() {
		return r10_1year_non_uae;
	}
	public void setR10_1year_non_uae(BigDecimal r10_1year_non_uae) {
		this.r10_1year_non_uae = r10_1year_non_uae;
	}
	public BigDecimal getR10_6month_other_non_uae() {
		return r10_6month_other_non_uae;
	}
	public void setR10_6month_other_non_uae(BigDecimal r10_6month_other_non_uae) {
		this.r10_6month_other_non_uae = r10_6month_other_non_uae;
	}
	public BigDecimal getR10_12month_other_non_uae() {
		return r10_12month_other_non_uae;
	}
	public void setR10_12month_other_non_uae(BigDecimal r10_12month_other_non_uae) {
		this.r10_12month_other_non_uae = r10_12month_other_non_uae;
	}
	public BigDecimal getR10_1year_other_non_uae() {
		return r10_1year_other_non_uae;
	}
	public void setR10_1year_other_non_uae(BigDecimal r10_1year_other_non_uae) {
		this.r10_1year_other_non_uae = r10_1year_other_non_uae;
	}
	public BigDecimal getR10_other_assets() {
		return r10_other_assets;
	}
	public void setR10_other_assets(BigDecimal r10_other_assets) {
		this.r10_other_assets = r10_other_assets;
	}
	public BigDecimal getR10_total_assets() {
		return r10_total_assets;
	}
	public void setR10_total_assets(BigDecimal r10_total_assets) {
		this.r10_total_assets = r10_total_assets;
	}
	public BigDecimal getR10_total_libilities() {
		return r10_total_libilities;
	}
	public void setR10_total_libilities(BigDecimal r10_total_libilities) {
		this.r10_total_libilities = r10_total_libilities;
	}
	public BigDecimal getR10_net_forward() {
		return r10_net_forward;
	}
	public void setR10_net_forward(BigDecimal r10_net_forward) {
		this.r10_net_forward = r10_net_forward;
	}
	public BigDecimal getR10_net_overall() {
		return r10_net_overall;
	}
	public void setR10_net_overall(BigDecimal r10_net_overall) {
		this.r10_net_overall = r10_net_overall;
	}
	public String getR11_product() {
		return r11_product;
	}
	public void setR11_product(String r11_product) {
		this.r11_product = r11_product;
	}
	public BigDecimal getR11_6month_uae() {
		return r11_6month_uae;
	}
	public void setR11_6month_uae(BigDecimal r11_6month_uae) {
		this.r11_6month_uae = r11_6month_uae;
	}
	public BigDecimal getR11_12month_uae() {
		return r11_12month_uae;
	}
	public void setR11_12month_uae(BigDecimal r11_12month_uae) {
		this.r11_12month_uae = r11_12month_uae;
	}
	public BigDecimal getR11_1year_uae() {
		return r11_1year_uae;
	}
	public void setR11_1year_uae(BigDecimal r11_1year_uae) {
		this.r11_1year_uae = r11_1year_uae;
	}
	public BigDecimal getR11_6month_other_uae() {
		return r11_6month_other_uae;
	}
	public void setR11_6month_other_uae(BigDecimal r11_6month_other_uae) {
		this.r11_6month_other_uae = r11_6month_other_uae;
	}
	public BigDecimal getR11_12month_other_uae() {
		return r11_12month_other_uae;
	}
	public void setR11_12month_other_uae(BigDecimal r11_12month_other_uae) {
		this.r11_12month_other_uae = r11_12month_other_uae;
	}
	public BigDecimal getR11_1year_other_uae() {
		return r11_1year_other_uae;
	}
	public void setR11_1year_other_uae(BigDecimal r11_1year_other_uae) {
		this.r11_1year_other_uae = r11_1year_other_uae;
	}
	public BigDecimal getR11_6month_non_uae() {
		return r11_6month_non_uae;
	}
	public void setR11_6month_non_uae(BigDecimal r11_6month_non_uae) {
		this.r11_6month_non_uae = r11_6month_non_uae;
	}
	public BigDecimal getR11_12month_non_uae() {
		return r11_12month_non_uae;
	}
	public void setR11_12month_non_uae(BigDecimal r11_12month_non_uae) {
		this.r11_12month_non_uae = r11_12month_non_uae;
	}
	public BigDecimal getR11_1year_non_uae() {
		return r11_1year_non_uae;
	}
	public void setR11_1year_non_uae(BigDecimal r11_1year_non_uae) {
		this.r11_1year_non_uae = r11_1year_non_uae;
	}
	public BigDecimal getR11_6month_other_non_uae() {
		return r11_6month_other_non_uae;
	}
	public void setR11_6month_other_non_uae(BigDecimal r11_6month_other_non_uae) {
		this.r11_6month_other_non_uae = r11_6month_other_non_uae;
	}
	public BigDecimal getR11_12month_other_non_uae() {
		return r11_12month_other_non_uae;
	}
	public void setR11_12month_other_non_uae(BigDecimal r11_12month_other_non_uae) {
		this.r11_12month_other_non_uae = r11_12month_other_non_uae;
	}
	public BigDecimal getR11_1year_other_non_uae() {
		return r11_1year_other_non_uae;
	}
	public void setR11_1year_other_non_uae(BigDecimal r11_1year_other_non_uae) {
		this.r11_1year_other_non_uae = r11_1year_other_non_uae;
	}
	public BigDecimal getR11_other_assets() {
		return r11_other_assets;
	}
	public void setR11_other_assets(BigDecimal r11_other_assets) {
		this.r11_other_assets = r11_other_assets;
	}
	public BigDecimal getR11_total_assets() {
		return r11_total_assets;
	}
	public void setR11_total_assets(BigDecimal r11_total_assets) {
		this.r11_total_assets = r11_total_assets;
	}
	public BigDecimal getR11_total_libilities() {
		return r11_total_libilities;
	}
	public void setR11_total_libilities(BigDecimal r11_total_libilities) {
		this.r11_total_libilities = r11_total_libilities;
	}
	public BigDecimal getR11_net_forward() {
		return r11_net_forward;
	}
	public void setR11_net_forward(BigDecimal r11_net_forward) {
		this.r11_net_forward = r11_net_forward;
	}
	public BigDecimal getR11_net_overall() {
		return r11_net_overall;
	}
	public void setR11_net_overall(BigDecimal r11_net_overall) {
		this.r11_net_overall = r11_net_overall;
	}
	public String getR12_product() {
		return r12_product;
	}
	public void setR12_product(String r12_product) {
		this.r12_product = r12_product;
	}
	public BigDecimal getR12_6month_uae() {
		return r12_6month_uae;
	}
	public void setR12_6month_uae(BigDecimal r12_6month_uae) {
		this.r12_6month_uae = r12_6month_uae;
	}
	public BigDecimal getR12_12month_uae() {
		return r12_12month_uae;
	}
	public void setR12_12month_uae(BigDecimal r12_12month_uae) {
		this.r12_12month_uae = r12_12month_uae;
	}
	public BigDecimal getR12_1year_uae() {
		return r12_1year_uae;
	}
	public void setR12_1year_uae(BigDecimal r12_1year_uae) {
		this.r12_1year_uae = r12_1year_uae;
	}
	public BigDecimal getR12_6month_other_uae() {
		return r12_6month_other_uae;
	}
	public void setR12_6month_other_uae(BigDecimal r12_6month_other_uae) {
		this.r12_6month_other_uae = r12_6month_other_uae;
	}
	public BigDecimal getR12_12month_other_uae() {
		return r12_12month_other_uae;
	}
	public void setR12_12month_other_uae(BigDecimal r12_12month_other_uae) {
		this.r12_12month_other_uae = r12_12month_other_uae;
	}
	public BigDecimal getR12_1year_other_uae() {
		return r12_1year_other_uae;
	}
	public void setR12_1year_other_uae(BigDecimal r12_1year_other_uae) {
		this.r12_1year_other_uae = r12_1year_other_uae;
	}
	public BigDecimal getR12_6month_non_uae() {
		return r12_6month_non_uae;
	}
	public void setR12_6month_non_uae(BigDecimal r12_6month_non_uae) {
		this.r12_6month_non_uae = r12_6month_non_uae;
	}
	public BigDecimal getR12_12month_non_uae() {
		return r12_12month_non_uae;
	}
	public void setR12_12month_non_uae(BigDecimal r12_12month_non_uae) {
		this.r12_12month_non_uae = r12_12month_non_uae;
	}
	public BigDecimal getR12_1year_non_uae() {
		return r12_1year_non_uae;
	}
	public void setR12_1year_non_uae(BigDecimal r12_1year_non_uae) {
		this.r12_1year_non_uae = r12_1year_non_uae;
	}
	public BigDecimal getR12_6month_other_non_uae() {
		return r12_6month_other_non_uae;
	}
	public void setR12_6month_other_non_uae(BigDecimal r12_6month_other_non_uae) {
		this.r12_6month_other_non_uae = r12_6month_other_non_uae;
	}
	public BigDecimal getR12_12month_other_non_uae() {
		return r12_12month_other_non_uae;
	}
	public void setR12_12month_other_non_uae(BigDecimal r12_12month_other_non_uae) {
		this.r12_12month_other_non_uae = r12_12month_other_non_uae;
	}
	public BigDecimal getR12_1year_other_non_uae() {
		return r12_1year_other_non_uae;
	}
	public void setR12_1year_other_non_uae(BigDecimal r12_1year_other_non_uae) {
		this.r12_1year_other_non_uae = r12_1year_other_non_uae;
	}
	public BigDecimal getR12_other_assets() {
		return r12_other_assets;
	}
	public void setR12_other_assets(BigDecimal r12_other_assets) {
		this.r12_other_assets = r12_other_assets;
	}
	public BigDecimal getR12_total_assets() {
		return r12_total_assets;
	}
	public void setR12_total_assets(BigDecimal r12_total_assets) {
		this.r12_total_assets = r12_total_assets;
	}
	public BigDecimal getR12_total_libilities() {
		return r12_total_libilities;
	}
	public void setR12_total_libilities(BigDecimal r12_total_libilities) {
		this.r12_total_libilities = r12_total_libilities;
	}
	public BigDecimal getR12_net_forward() {
		return r12_net_forward;
	}
	public void setR12_net_forward(BigDecimal r12_net_forward) {
		this.r12_net_forward = r12_net_forward;
	}
	public BigDecimal getR12_net_overall() {
		return r12_net_overall;
	}
	public void setR12_net_overall(BigDecimal r12_net_overall) {
		this.r12_net_overall = r12_net_overall;
	}
	public String getR13_product() {
		return r13_product;
	}
	public void setR13_product(String r13_product) {
		this.r13_product = r13_product;
	}
	public BigDecimal getR13_6month_uae() {
		return r13_6month_uae;
	}
	public void setR13_6month_uae(BigDecimal r13_6month_uae) {
		this.r13_6month_uae = r13_6month_uae;
	}
	public BigDecimal getR13_12month_uae() {
		return r13_12month_uae;
	}
	public void setR13_12month_uae(BigDecimal r13_12month_uae) {
		this.r13_12month_uae = r13_12month_uae;
	}
	public BigDecimal getR13_1year_uae() {
		return r13_1year_uae;
	}
	public void setR13_1year_uae(BigDecimal r13_1year_uae) {
		this.r13_1year_uae = r13_1year_uae;
	}
	public BigDecimal getR13_6month_other_uae() {
		return r13_6month_other_uae;
	}
	public void setR13_6month_other_uae(BigDecimal r13_6month_other_uae) {
		this.r13_6month_other_uae = r13_6month_other_uae;
	}
	public BigDecimal getR13_12month_other_uae() {
		return r13_12month_other_uae;
	}
	public void setR13_12month_other_uae(BigDecimal r13_12month_other_uae) {
		this.r13_12month_other_uae = r13_12month_other_uae;
	}
	public BigDecimal getR13_1year_other_uae() {
		return r13_1year_other_uae;
	}
	public void setR13_1year_other_uae(BigDecimal r13_1year_other_uae) {
		this.r13_1year_other_uae = r13_1year_other_uae;
	}
	public BigDecimal getR13_6month_non_uae() {
		return r13_6month_non_uae;
	}
	public void setR13_6month_non_uae(BigDecimal r13_6month_non_uae) {
		this.r13_6month_non_uae = r13_6month_non_uae;
	}
	public BigDecimal getR13_12month_non_uae() {
		return r13_12month_non_uae;
	}
	public void setR13_12month_non_uae(BigDecimal r13_12month_non_uae) {
		this.r13_12month_non_uae = r13_12month_non_uae;
	}
	public BigDecimal getR13_1year_non_uae() {
		return r13_1year_non_uae;
	}
	public void setR13_1year_non_uae(BigDecimal r13_1year_non_uae) {
		this.r13_1year_non_uae = r13_1year_non_uae;
	}
	public BigDecimal getR13_6month_other_non_uae() {
		return r13_6month_other_non_uae;
	}
	public void setR13_6month_other_non_uae(BigDecimal r13_6month_other_non_uae) {
		this.r13_6month_other_non_uae = r13_6month_other_non_uae;
	}
	public BigDecimal getR13_12month_other_non_uae() {
		return r13_12month_other_non_uae;
	}
	public void setR13_12month_other_non_uae(BigDecimal r13_12month_other_non_uae) {
		this.r13_12month_other_non_uae = r13_12month_other_non_uae;
	}
	public BigDecimal getR13_1year_other_non_uae() {
		return r13_1year_other_non_uae;
	}
	public void setR13_1year_other_non_uae(BigDecimal r13_1year_other_non_uae) {
		this.r13_1year_other_non_uae = r13_1year_other_non_uae;
	}
	public BigDecimal getR13_other_assets() {
		return r13_other_assets;
	}
	public void setR13_other_assets(BigDecimal r13_other_assets) {
		this.r13_other_assets = r13_other_assets;
	}
	public BigDecimal getR13_total_assets() {
		return r13_total_assets;
	}
	public void setR13_total_assets(BigDecimal r13_total_assets) {
		this.r13_total_assets = r13_total_assets;
	}
	public BigDecimal getR13_total_libilities() {
		return r13_total_libilities;
	}
	public void setR13_total_libilities(BigDecimal r13_total_libilities) {
		this.r13_total_libilities = r13_total_libilities;
	}
	public BigDecimal getR13_net_forward() {
		return r13_net_forward;
	}
	public void setR13_net_forward(BigDecimal r13_net_forward) {
		this.r13_net_forward = r13_net_forward;
	}
	public BigDecimal getR13_net_overall() {
		return r13_net_overall;
	}
	public void setR13_net_overall(BigDecimal r13_net_overall) {
		this.r13_net_overall = r13_net_overall;
	}
	public String getR14_product() {
		return r14_product;
	}
	public void setR14_product(String r14_product) {
		this.r14_product = r14_product;
	}
	public BigDecimal getR14_6month_uae() {
		return r14_6month_uae;
	}
	public void setR14_6month_uae(BigDecimal r14_6month_uae) {
		this.r14_6month_uae = r14_6month_uae;
	}
	public BigDecimal getR14_12month_uae() {
		return r14_12month_uae;
	}
	public void setR14_12month_uae(BigDecimal r14_12month_uae) {
		this.r14_12month_uae = r14_12month_uae;
	}
	public BigDecimal getR14_1year_uae() {
		return r14_1year_uae;
	}
	public void setR14_1year_uae(BigDecimal r14_1year_uae) {
		this.r14_1year_uae = r14_1year_uae;
	}
	public BigDecimal getR14_6month_other_uae() {
		return r14_6month_other_uae;
	}
	public void setR14_6month_other_uae(BigDecimal r14_6month_other_uae) {
		this.r14_6month_other_uae = r14_6month_other_uae;
	}
	public BigDecimal getR14_12month_other_uae() {
		return r14_12month_other_uae;
	}
	public void setR14_12month_other_uae(BigDecimal r14_12month_other_uae) {
		this.r14_12month_other_uae = r14_12month_other_uae;
	}
	public BigDecimal getR14_1year_other_uae() {
		return r14_1year_other_uae;
	}
	public void setR14_1year_other_uae(BigDecimal r14_1year_other_uae) {
		this.r14_1year_other_uae = r14_1year_other_uae;
	}
	public BigDecimal getR14_6month_non_uae() {
		return r14_6month_non_uae;
	}
	public void setR14_6month_non_uae(BigDecimal r14_6month_non_uae) {
		this.r14_6month_non_uae = r14_6month_non_uae;
	}
	public BigDecimal getR14_12month_non_uae() {
		return r14_12month_non_uae;
	}
	public void setR14_12month_non_uae(BigDecimal r14_12month_non_uae) {
		this.r14_12month_non_uae = r14_12month_non_uae;
	}
	public BigDecimal getR14_1year_non_uae() {
		return r14_1year_non_uae;
	}
	public void setR14_1year_non_uae(BigDecimal r14_1year_non_uae) {
		this.r14_1year_non_uae = r14_1year_non_uae;
	}
	public BigDecimal getR14_6month_other_non_uae() {
		return r14_6month_other_non_uae;
	}
	public void setR14_6month_other_non_uae(BigDecimal r14_6month_other_non_uae) {
		this.r14_6month_other_non_uae = r14_6month_other_non_uae;
	}
	public BigDecimal getR14_12month_other_non_uae() {
		return r14_12month_other_non_uae;
	}
	public void setR14_12month_other_non_uae(BigDecimal r14_12month_other_non_uae) {
		this.r14_12month_other_non_uae = r14_12month_other_non_uae;
	}
	public BigDecimal getR14_1year_other_non_uae() {
		return r14_1year_other_non_uae;
	}
	public void setR14_1year_other_non_uae(BigDecimal r14_1year_other_non_uae) {
		this.r14_1year_other_non_uae = r14_1year_other_non_uae;
	}
	public BigDecimal getR14_other_assets() {
		return r14_other_assets;
	}
	public void setR14_other_assets(BigDecimal r14_other_assets) {
		this.r14_other_assets = r14_other_assets;
	}
	public BigDecimal getR14_total_assets() {
		return r14_total_assets;
	}
	public void setR14_total_assets(BigDecimal r14_total_assets) {
		this.r14_total_assets = r14_total_assets;
	}
	public BigDecimal getR14_total_libilities() {
		return r14_total_libilities;
	}
	public void setR14_total_libilities(BigDecimal r14_total_libilities) {
		this.r14_total_libilities = r14_total_libilities;
	}
	public BigDecimal getR14_net_forward() {
		return r14_net_forward;
	}
	public void setR14_net_forward(BigDecimal r14_net_forward) {
		this.r14_net_forward = r14_net_forward;
	}
	public BigDecimal getR14_net_overall() {
		return r14_net_overall;
	}
	public void setR14_net_overall(BigDecimal r14_net_overall) {
		this.r14_net_overall = r14_net_overall;
	}
	public String getR15_product() {
		return r15_product;
	}
	public void setR15_product(String r15_product) {
		this.r15_product = r15_product;
	}
	public BigDecimal getR15_6month_uae() {
		return r15_6month_uae;
	}
	public void setR15_6month_uae(BigDecimal r15_6month_uae) {
		this.r15_6month_uae = r15_6month_uae;
	}
	public BigDecimal getR15_12month_uae() {
		return r15_12month_uae;
	}
	public void setR15_12month_uae(BigDecimal r15_12month_uae) {
		this.r15_12month_uae = r15_12month_uae;
	}
	public BigDecimal getR15_1year_uae() {
		return r15_1year_uae;
	}
	public void setR15_1year_uae(BigDecimal r15_1year_uae) {
		this.r15_1year_uae = r15_1year_uae;
	}
	public BigDecimal getR15_6month_other_uae() {
		return r15_6month_other_uae;
	}
	public void setR15_6month_other_uae(BigDecimal r15_6month_other_uae) {
		this.r15_6month_other_uae = r15_6month_other_uae;
	}
	public BigDecimal getR15_12month_other_uae() {
		return r15_12month_other_uae;
	}
	public void setR15_12month_other_uae(BigDecimal r15_12month_other_uae) {
		this.r15_12month_other_uae = r15_12month_other_uae;
	}
	public BigDecimal getR15_1year_other_uae() {
		return r15_1year_other_uae;
	}
	public void setR15_1year_other_uae(BigDecimal r15_1year_other_uae) {
		this.r15_1year_other_uae = r15_1year_other_uae;
	}
	public BigDecimal getR15_6month_non_uae() {
		return r15_6month_non_uae;
	}
	public void setR15_6month_non_uae(BigDecimal r15_6month_non_uae) {
		this.r15_6month_non_uae = r15_6month_non_uae;
	}
	public BigDecimal getR15_12month_non_uae() {
		return r15_12month_non_uae;
	}
	public void setR15_12month_non_uae(BigDecimal r15_12month_non_uae) {
		this.r15_12month_non_uae = r15_12month_non_uae;
	}
	public BigDecimal getR15_1year_non_uae() {
		return r15_1year_non_uae;
	}
	public void setR15_1year_non_uae(BigDecimal r15_1year_non_uae) {
		this.r15_1year_non_uae = r15_1year_non_uae;
	}
	public BigDecimal getR15_6month_other_non_uae() {
		return r15_6month_other_non_uae;
	}
	public void setR15_6month_other_non_uae(BigDecimal r15_6month_other_non_uae) {
		this.r15_6month_other_non_uae = r15_6month_other_non_uae;
	}
	public BigDecimal getR15_12month_other_non_uae() {
		return r15_12month_other_non_uae;
	}
	public void setR15_12month_other_non_uae(BigDecimal r15_12month_other_non_uae) {
		this.r15_12month_other_non_uae = r15_12month_other_non_uae;
	}
	public BigDecimal getR15_1year_other_non_uae() {
		return r15_1year_other_non_uae;
	}
	public void setR15_1year_other_non_uae(BigDecimal r15_1year_other_non_uae) {
		this.r15_1year_other_non_uae = r15_1year_other_non_uae;
	}
	public BigDecimal getR15_other_assets() {
		return r15_other_assets;
	}
	public void setR15_other_assets(BigDecimal r15_other_assets) {
		this.r15_other_assets = r15_other_assets;
	}
	public BigDecimal getR15_total_assets() {
		return r15_total_assets;
	}
	public void setR15_total_assets(BigDecimal r15_total_assets) {
		this.r15_total_assets = r15_total_assets;
	}
	public BigDecimal getR15_total_libilities() {
		return r15_total_libilities;
	}
	public void setR15_total_libilities(BigDecimal r15_total_libilities) {
		this.r15_total_libilities = r15_total_libilities;
	}
	public BigDecimal getR15_net_forward() {
		return r15_net_forward;
	}
	public void setR15_net_forward(BigDecimal r15_net_forward) {
		this.r15_net_forward = r15_net_forward;
	}
	public BigDecimal getR15_net_overall() {
		return r15_net_overall;
	}
	public void setR15_net_overall(BigDecimal r15_net_overall) {
		this.r15_net_overall = r15_net_overall;
	}
	public String getR16_product() {
		return r16_product;
	}
	public void setR16_product(String r16_product) {
		this.r16_product = r16_product;
	}
	public BigDecimal getR16_6month_uae() {
		return r16_6month_uae;
	}
	public void setR16_6month_uae(BigDecimal r16_6month_uae) {
		this.r16_6month_uae = r16_6month_uae;
	}
	public BigDecimal getR16_12month_uae() {
		return r16_12month_uae;
	}
	public void setR16_12month_uae(BigDecimal r16_12month_uae) {
		this.r16_12month_uae = r16_12month_uae;
	}
	public BigDecimal getR16_1year_uae() {
		return r16_1year_uae;
	}
	public void setR16_1year_uae(BigDecimal r16_1year_uae) {
		this.r16_1year_uae = r16_1year_uae;
	}
	public BigDecimal getR16_6month_other_uae() {
		return r16_6month_other_uae;
	}
	public void setR16_6month_other_uae(BigDecimal r16_6month_other_uae) {
		this.r16_6month_other_uae = r16_6month_other_uae;
	}
	public BigDecimal getR16_12month_other_uae() {
		return r16_12month_other_uae;
	}
	public void setR16_12month_other_uae(BigDecimal r16_12month_other_uae) {
		this.r16_12month_other_uae = r16_12month_other_uae;
	}
	public BigDecimal getR16_1year_other_uae() {
		return r16_1year_other_uae;
	}
	public void setR16_1year_other_uae(BigDecimal r16_1year_other_uae) {
		this.r16_1year_other_uae = r16_1year_other_uae;
	}
	public BigDecimal getR16_6month_non_uae() {
		return r16_6month_non_uae;
	}
	public void setR16_6month_non_uae(BigDecimal r16_6month_non_uae) {
		this.r16_6month_non_uae = r16_6month_non_uae;
	}
	public BigDecimal getR16_12month_non_uae() {
		return r16_12month_non_uae;
	}
	public void setR16_12month_non_uae(BigDecimal r16_12month_non_uae) {
		this.r16_12month_non_uae = r16_12month_non_uae;
	}
	public BigDecimal getR16_1year_non_uae() {
		return r16_1year_non_uae;
	}
	public void setR16_1year_non_uae(BigDecimal r16_1year_non_uae) {
		this.r16_1year_non_uae = r16_1year_non_uae;
	}
	public BigDecimal getR16_6month_other_non_uae() {
		return r16_6month_other_non_uae;
	}
	public void setR16_6month_other_non_uae(BigDecimal r16_6month_other_non_uae) {
		this.r16_6month_other_non_uae = r16_6month_other_non_uae;
	}
	public BigDecimal getR16_12month_other_non_uae() {
		return r16_12month_other_non_uae;
	}
	public void setR16_12month_other_non_uae(BigDecimal r16_12month_other_non_uae) {
		this.r16_12month_other_non_uae = r16_12month_other_non_uae;
	}
	public BigDecimal getR16_1year_other_non_uae() {
		return r16_1year_other_non_uae;
	}
	public void setR16_1year_other_non_uae(BigDecimal r16_1year_other_non_uae) {
		this.r16_1year_other_non_uae = r16_1year_other_non_uae;
	}
	public BigDecimal getR16_other_assets() {
		return r16_other_assets;
	}
	public void setR16_other_assets(BigDecimal r16_other_assets) {
		this.r16_other_assets = r16_other_assets;
	}
	public BigDecimal getR16_total_assets() {
		return r16_total_assets;
	}
	public void setR16_total_assets(BigDecimal r16_total_assets) {
		this.r16_total_assets = r16_total_assets;
	}
	public BigDecimal getR16_total_libilities() {
		return r16_total_libilities;
	}
	public void setR16_total_libilities(BigDecimal r16_total_libilities) {
		this.r16_total_libilities = r16_total_libilities;
	}
	public BigDecimal getR16_net_forward() {
		return r16_net_forward;
	}
	public void setR16_net_forward(BigDecimal r16_net_forward) {
		this.r16_net_forward = r16_net_forward;
	}
	public BigDecimal getR16_net_overall() {
		return r16_net_overall;
	}
	public void setR16_net_overall(BigDecimal r16_net_overall) {
		this.r16_net_overall = r16_net_overall;
	}
	public String getR17_product() {
		return r17_product;
	}
	public void setR17_product(String r17_product) {
		this.r17_product = r17_product;
	}
	public BigDecimal getR17_6month_uae() {
		return r17_6month_uae;
	}
	public void setR17_6month_uae(BigDecimal r17_6month_uae) {
		this.r17_6month_uae = r17_6month_uae;
	}
	public BigDecimal getR17_12month_uae() {
		return r17_12month_uae;
	}
	public void setR17_12month_uae(BigDecimal r17_12month_uae) {
		this.r17_12month_uae = r17_12month_uae;
	}
	public BigDecimal getR17_1year_uae() {
		return r17_1year_uae;
	}
	public void setR17_1year_uae(BigDecimal r17_1year_uae) {
		this.r17_1year_uae = r17_1year_uae;
	}
	public BigDecimal getR17_6month_other_uae() {
		return r17_6month_other_uae;
	}
	public void setR17_6month_other_uae(BigDecimal r17_6month_other_uae) {
		this.r17_6month_other_uae = r17_6month_other_uae;
	}
	public BigDecimal getR17_12month_other_uae() {
		return r17_12month_other_uae;
	}
	public void setR17_12month_other_uae(BigDecimal r17_12month_other_uae) {
		this.r17_12month_other_uae = r17_12month_other_uae;
	}
	public BigDecimal getR17_1year_other_uae() {
		return r17_1year_other_uae;
	}
	public void setR17_1year_other_uae(BigDecimal r17_1year_other_uae) {
		this.r17_1year_other_uae = r17_1year_other_uae;
	}
	public BigDecimal getR17_6month_non_uae() {
		return r17_6month_non_uae;
	}
	public void setR17_6month_non_uae(BigDecimal r17_6month_non_uae) {
		this.r17_6month_non_uae = r17_6month_non_uae;
	}
	public BigDecimal getR17_12month_non_uae() {
		return r17_12month_non_uae;
	}
	public void setR17_12month_non_uae(BigDecimal r17_12month_non_uae) {
		this.r17_12month_non_uae = r17_12month_non_uae;
	}
	public BigDecimal getR17_1year_non_uae() {
		return r17_1year_non_uae;
	}
	public void setR17_1year_non_uae(BigDecimal r17_1year_non_uae) {
		this.r17_1year_non_uae = r17_1year_non_uae;
	}
	public BigDecimal getR17_6month_other_non_uae() {
		return r17_6month_other_non_uae;
	}
	public void setR17_6month_other_non_uae(BigDecimal r17_6month_other_non_uae) {
		this.r17_6month_other_non_uae = r17_6month_other_non_uae;
	}
	public BigDecimal getR17_12month_other_non_uae() {
		return r17_12month_other_non_uae;
	}
	public void setR17_12month_other_non_uae(BigDecimal r17_12month_other_non_uae) {
		this.r17_12month_other_non_uae = r17_12month_other_non_uae;
	}
	public BigDecimal getR17_1year_other_non_uae() {
		return r17_1year_other_non_uae;
	}
	public void setR17_1year_other_non_uae(BigDecimal r17_1year_other_non_uae) {
		this.r17_1year_other_non_uae = r17_1year_other_non_uae;
	}
	public BigDecimal getR17_other_assets() {
		return r17_other_assets;
	}
	public void setR17_other_assets(BigDecimal r17_other_assets) {
		this.r17_other_assets = r17_other_assets;
	}
	public BigDecimal getR17_total_assets() {
		return r17_total_assets;
	}
	public void setR17_total_assets(BigDecimal r17_total_assets) {
		this.r17_total_assets = r17_total_assets;
	}
	public BigDecimal getR17_total_libilities() {
		return r17_total_libilities;
	}
	public void setR17_total_libilities(BigDecimal r17_total_libilities) {
		this.r17_total_libilities = r17_total_libilities;
	}
	public BigDecimal getR17_net_forward() {
		return r17_net_forward;
	}
	public void setR17_net_forward(BigDecimal r17_net_forward) {
		this.r17_net_forward = r17_net_forward;
	}
	public BigDecimal getR17_net_overall() {
		return r17_net_overall;
	}
	public void setR17_net_overall(BigDecimal r17_net_overall) {
		this.r17_net_overall = r17_net_overall;
	}
	public String getR18_product() {
		return r18_product;
	}
	public void setR18_product(String r18_product) {
		this.r18_product = r18_product;
	}
	public BigDecimal getR18_6month_uae() {
		return r18_6month_uae;
	}
	public void setR18_6month_uae(BigDecimal r18_6month_uae) {
		this.r18_6month_uae = r18_6month_uae;
	}
	public BigDecimal getR18_12month_uae() {
		return r18_12month_uae;
	}
	public void setR18_12month_uae(BigDecimal r18_12month_uae) {
		this.r18_12month_uae = r18_12month_uae;
	}
	public BigDecimal getR18_1year_uae() {
		return r18_1year_uae;
	}
	public void setR18_1year_uae(BigDecimal r18_1year_uae) {
		this.r18_1year_uae = r18_1year_uae;
	}
	public BigDecimal getR18_6month_other_uae() {
		return r18_6month_other_uae;
	}
	public void setR18_6month_other_uae(BigDecimal r18_6month_other_uae) {
		this.r18_6month_other_uae = r18_6month_other_uae;
	}
	public BigDecimal getR18_12month_other_uae() {
		return r18_12month_other_uae;
	}
	public void setR18_12month_other_uae(BigDecimal r18_12month_other_uae) {
		this.r18_12month_other_uae = r18_12month_other_uae;
	}
	public BigDecimal getR18_1year_other_uae() {
		return r18_1year_other_uae;
	}
	public void setR18_1year_other_uae(BigDecimal r18_1year_other_uae) {
		this.r18_1year_other_uae = r18_1year_other_uae;
	}
	public BigDecimal getR18_6month_non_uae() {
		return r18_6month_non_uae;
	}
	public void setR18_6month_non_uae(BigDecimal r18_6month_non_uae) {
		this.r18_6month_non_uae = r18_6month_non_uae;
	}
	public BigDecimal getR18_12month_non_uae() {
		return r18_12month_non_uae;
	}
	public void setR18_12month_non_uae(BigDecimal r18_12month_non_uae) {
		this.r18_12month_non_uae = r18_12month_non_uae;
	}
	public BigDecimal getR18_1year_non_uae() {
		return r18_1year_non_uae;
	}
	public void setR18_1year_non_uae(BigDecimal r18_1year_non_uae) {
		this.r18_1year_non_uae = r18_1year_non_uae;
	}
	public BigDecimal getR18_6month_other_non_uae() {
		return r18_6month_other_non_uae;
	}
	public void setR18_6month_other_non_uae(BigDecimal r18_6month_other_non_uae) {
		this.r18_6month_other_non_uae = r18_6month_other_non_uae;
	}
	public BigDecimal getR18_12month_other_non_uae() {
		return r18_12month_other_non_uae;
	}
	public void setR18_12month_other_non_uae(BigDecimal r18_12month_other_non_uae) {
		this.r18_12month_other_non_uae = r18_12month_other_non_uae;
	}
	public BigDecimal getR18_1year_other_non_uae() {
		return r18_1year_other_non_uae;
	}
	public void setR18_1year_other_non_uae(BigDecimal r18_1year_other_non_uae) {
		this.r18_1year_other_non_uae = r18_1year_other_non_uae;
	}
	public BigDecimal getR18_other_assets() {
		return r18_other_assets;
	}
	public void setR18_other_assets(BigDecimal r18_other_assets) {
		this.r18_other_assets = r18_other_assets;
	}
	public BigDecimal getR18_total_assets() {
		return r18_total_assets;
	}
	public void setR18_total_assets(BigDecimal r18_total_assets) {
		this.r18_total_assets = r18_total_assets;
	}
	public BigDecimal getR18_total_libilities() {
		return r18_total_libilities;
	}
	public void setR18_total_libilities(BigDecimal r18_total_libilities) {
		this.r18_total_libilities = r18_total_libilities;
	}
	public BigDecimal getR18_net_forward() {
		return r18_net_forward;
	}
	public void setR18_net_forward(BigDecimal r18_net_forward) {
		this.r18_net_forward = r18_net_forward;
	}
	public BigDecimal getR18_net_overall() {
		return r18_net_overall;
	}
	public void setR18_net_overall(BigDecimal r18_net_overall) {
		this.r18_net_overall = r18_net_overall;
	}
	public String getR19_product() {
		return r19_product;
	}
	public void setR19_product(String r19_product) {
		this.r19_product = r19_product;
	}
	public BigDecimal getR19_6month_uae() {
		return r19_6month_uae;
	}
	public void setR19_6month_uae(BigDecimal r19_6month_uae) {
		this.r19_6month_uae = r19_6month_uae;
	}
	public BigDecimal getR19_12month_uae() {
		return r19_12month_uae;
	}
	public void setR19_12month_uae(BigDecimal r19_12month_uae) {
		this.r19_12month_uae = r19_12month_uae;
	}
	public BigDecimal getR19_1year_uae() {
		return r19_1year_uae;
	}
	public void setR19_1year_uae(BigDecimal r19_1year_uae) {
		this.r19_1year_uae = r19_1year_uae;
	}
	public BigDecimal getR19_6month_other_uae() {
		return r19_6month_other_uae;
	}
	public void setR19_6month_other_uae(BigDecimal r19_6month_other_uae) {
		this.r19_6month_other_uae = r19_6month_other_uae;
	}
	public BigDecimal getR19_12month_other_uae() {
		return r19_12month_other_uae;
	}
	public void setR19_12month_other_uae(BigDecimal r19_12month_other_uae) {
		this.r19_12month_other_uae = r19_12month_other_uae;
	}
	public BigDecimal getR19_1year_other_uae() {
		return r19_1year_other_uae;
	}
	public void setR19_1year_other_uae(BigDecimal r19_1year_other_uae) {
		this.r19_1year_other_uae = r19_1year_other_uae;
	}
	public BigDecimal getR19_6month_non_uae() {
		return r19_6month_non_uae;
	}
	public void setR19_6month_non_uae(BigDecimal r19_6month_non_uae) {
		this.r19_6month_non_uae = r19_6month_non_uae;
	}
	public BigDecimal getR19_12month_non_uae() {
		return r19_12month_non_uae;
	}
	public void setR19_12month_non_uae(BigDecimal r19_12month_non_uae) {
		this.r19_12month_non_uae = r19_12month_non_uae;
	}
	public BigDecimal getR19_1year_non_uae() {
		return r19_1year_non_uae;
	}
	public void setR19_1year_non_uae(BigDecimal r19_1year_non_uae) {
		this.r19_1year_non_uae = r19_1year_non_uae;
	}
	public BigDecimal getR19_6month_other_non_uae() {
		return r19_6month_other_non_uae;
	}
	public void setR19_6month_other_non_uae(BigDecimal r19_6month_other_non_uae) {
		this.r19_6month_other_non_uae = r19_6month_other_non_uae;
	}
	public BigDecimal getR19_12month_other_non_uae() {
		return r19_12month_other_non_uae;
	}
	public void setR19_12month_other_non_uae(BigDecimal r19_12month_other_non_uae) {
		this.r19_12month_other_non_uae = r19_12month_other_non_uae;
	}
	public BigDecimal getR19_1year_other_non_uae() {
		return r19_1year_other_non_uae;
	}
	public void setR19_1year_other_non_uae(BigDecimal r19_1year_other_non_uae) {
		this.r19_1year_other_non_uae = r19_1year_other_non_uae;
	}
	public BigDecimal getR19_other_assets() {
		return r19_other_assets;
	}
	public void setR19_other_assets(BigDecimal r19_other_assets) {
		this.r19_other_assets = r19_other_assets;
	}
	public BigDecimal getR19_total_assets() {
		return r19_total_assets;
	}
	public void setR19_total_assets(BigDecimal r19_total_assets) {
		this.r19_total_assets = r19_total_assets;
	}
	public BigDecimal getR19_total_libilities() {
		return r19_total_libilities;
	}
	public void setR19_total_libilities(BigDecimal r19_total_libilities) {
		this.r19_total_libilities = r19_total_libilities;
	}
	public BigDecimal getR19_net_forward() {
		return r19_net_forward;
	}
	public void setR19_net_forward(BigDecimal r19_net_forward) {
		this.r19_net_forward = r19_net_forward;
	}
	public BigDecimal getR19_net_overall() {
		return r19_net_overall;
	}
	public void setR19_net_overall(BigDecimal r19_net_overall) {
		this.r19_net_overall = r19_net_overall;
	}
	public String getR20_product() {
		return r20_product;
	}
	public void setR20_product(String r20_product) {
		this.r20_product = r20_product;
	}
	public BigDecimal getR20_6month_uae() {
		return r20_6month_uae;
	}
	public void setR20_6month_uae(BigDecimal r20_6month_uae) {
		this.r20_6month_uae = r20_6month_uae;
	}
	public BigDecimal getR20_12month_uae() {
		return r20_12month_uae;
	}
	public void setR20_12month_uae(BigDecimal r20_12month_uae) {
		this.r20_12month_uae = r20_12month_uae;
	}
	public BigDecimal getR20_1year_uae() {
		return r20_1year_uae;
	}
	public void setR20_1year_uae(BigDecimal r20_1year_uae) {
		this.r20_1year_uae = r20_1year_uae;
	}
	public BigDecimal getR20_6month_other_uae() {
		return r20_6month_other_uae;
	}
	public void setR20_6month_other_uae(BigDecimal r20_6month_other_uae) {
		this.r20_6month_other_uae = r20_6month_other_uae;
	}
	public BigDecimal getR20_12month_other_uae() {
		return r20_12month_other_uae;
	}
	public void setR20_12month_other_uae(BigDecimal r20_12month_other_uae) {
		this.r20_12month_other_uae = r20_12month_other_uae;
	}
	public BigDecimal getR20_1year_other_uae() {
		return r20_1year_other_uae;
	}
	public void setR20_1year_other_uae(BigDecimal r20_1year_other_uae) {
		this.r20_1year_other_uae = r20_1year_other_uae;
	}
	public BigDecimal getR20_6month_non_uae() {
		return r20_6month_non_uae;
	}
	public void setR20_6month_non_uae(BigDecimal r20_6month_non_uae) {
		this.r20_6month_non_uae = r20_6month_non_uae;
	}
	public BigDecimal getR20_12month_non_uae() {
		return r20_12month_non_uae;
	}
	public void setR20_12month_non_uae(BigDecimal r20_12month_non_uae) {
		this.r20_12month_non_uae = r20_12month_non_uae;
	}
	public BigDecimal getR20_1year_non_uae() {
		return r20_1year_non_uae;
	}
	public void setR20_1year_non_uae(BigDecimal r20_1year_non_uae) {
		this.r20_1year_non_uae = r20_1year_non_uae;
	}
	public BigDecimal getR20_6month_other_non_uae() {
		return r20_6month_other_non_uae;
	}
	public void setR20_6month_other_non_uae(BigDecimal r20_6month_other_non_uae) {
		this.r20_6month_other_non_uae = r20_6month_other_non_uae;
	}
	public BigDecimal getR20_12month_other_non_uae() {
		return r20_12month_other_non_uae;
	}
	public void setR20_12month_other_non_uae(BigDecimal r20_12month_other_non_uae) {
		this.r20_12month_other_non_uae = r20_12month_other_non_uae;
	}
	public BigDecimal getR20_1year_other_non_uae() {
		return r20_1year_other_non_uae;
	}
	public void setR20_1year_other_non_uae(BigDecimal r20_1year_other_non_uae) {
		this.r20_1year_other_non_uae = r20_1year_other_non_uae;
	}
	public BigDecimal getR20_other_assets() {
		return r20_other_assets;
	}
	public void setR20_other_assets(BigDecimal r20_other_assets) {
		this.r20_other_assets = r20_other_assets;
	}
	public BigDecimal getR20_total_assets() {
		return r20_total_assets;
	}
	public void setR20_total_assets(BigDecimal r20_total_assets) {
		this.r20_total_assets = r20_total_assets;
	}
	public BigDecimal getR20_total_libilities() {
		return r20_total_libilities;
	}
	public void setR20_total_libilities(BigDecimal r20_total_libilities) {
		this.r20_total_libilities = r20_total_libilities;
	}
	public BigDecimal getR20_net_forward() {
		return r20_net_forward;
	}
	public void setR20_net_forward(BigDecimal r20_net_forward) {
		this.r20_net_forward = r20_net_forward;
	}
	public BigDecimal getR20_net_overall() {
		return r20_net_overall;
	}
	public void setR20_net_overall(BigDecimal r20_net_overall) {
		this.r20_net_overall = r20_net_overall;
	}
	public String getR21_total() {
		return r21_total;
	}
	public void setR21_total(String r21_total) {
		this.r21_total = r21_total;
	}
	public BigDecimal getR21_6month_uae() {
		return r21_6month_uae;
	}
	public void setR21_6month_uae(BigDecimal r21_6month_uae) {
		this.r21_6month_uae = r21_6month_uae;
	}
	public BigDecimal getR21_12month_uae() {
		return r21_12month_uae;
	}
	public void setR21_12month_uae(BigDecimal r21_12month_uae) {
		this.r21_12month_uae = r21_12month_uae;
	}
	public BigDecimal getR21_1year_uae() {
		return r21_1year_uae;
	}
	public void setR21_1year_uae(BigDecimal r21_1year_uae) {
		this.r21_1year_uae = r21_1year_uae;
	}
	public BigDecimal getR21_6month_other_uae() {
		return r21_6month_other_uae;
	}
	public void setR21_6month_other_uae(BigDecimal r21_6month_other_uae) {
		this.r21_6month_other_uae = r21_6month_other_uae;
	}
	public BigDecimal getR21_12month_other_uae() {
		return r21_12month_other_uae;
	}
	public void setR21_12month_other_uae(BigDecimal r21_12month_other_uae) {
		this.r21_12month_other_uae = r21_12month_other_uae;
	}
	public BigDecimal getR21_1year_other_uae() {
		return r21_1year_other_uae;
	}
	public void setR21_1year_other_uae(BigDecimal r21_1year_other_uae) {
		this.r21_1year_other_uae = r21_1year_other_uae;
	}
	public BigDecimal getR21_6month_non_uae() {
		return r21_6month_non_uae;
	}
	public void setR21_6month_non_uae(BigDecimal r21_6month_non_uae) {
		this.r21_6month_non_uae = r21_6month_non_uae;
	}
	public BigDecimal getR21_12month_non_uae() {
		return r21_12month_non_uae;
	}
	public void setR21_12month_non_uae(BigDecimal r21_12month_non_uae) {
		this.r21_12month_non_uae = r21_12month_non_uae;
	}
	public BigDecimal getR21_1year_non_uae() {
		return r21_1year_non_uae;
	}
	public void setR21_1year_non_uae(BigDecimal r21_1year_non_uae) {
		this.r21_1year_non_uae = r21_1year_non_uae;
	}
	public BigDecimal getR21_6month_other_non_uae() {
		return r21_6month_other_non_uae;
	}
	public void setR21_6month_other_non_uae(BigDecimal r21_6month_other_non_uae) {
		this.r21_6month_other_non_uae = r21_6month_other_non_uae;
	}
	public BigDecimal getR21_12month_other_non_uae() {
		return r21_12month_other_non_uae;
	}
	public void setR21_12month_other_non_uae(BigDecimal r21_12month_other_non_uae) {
		this.r21_12month_other_non_uae = r21_12month_other_non_uae;
	}
	public BigDecimal getR21_1year_other_non_uae() {
		return r21_1year_other_non_uae;
	}
	public void setR21_1year_other_non_uae(BigDecimal r21_1year_other_non_uae) {
		this.r21_1year_other_non_uae = r21_1year_other_non_uae;
	}
	public BigDecimal getR21_other_assets() {
		return r21_other_assets;
	}
	public void setR21_other_assets(BigDecimal r21_other_assets) {
		this.r21_other_assets = r21_other_assets;
	}
	public BigDecimal getR21_total_assets() {
		return r21_total_assets;
	}
	public void setR21_total_assets(BigDecimal r21_total_assets) {
		this.r21_total_assets = r21_total_assets;
	}
	public BigDecimal getR21_total_libilities() {
		return r21_total_libilities;
	}
	public void setR21_total_libilities(BigDecimal r21_total_libilities) {
		this.r21_total_libilities = r21_total_libilities;
	}
	public BigDecimal getR21_net_forward() {
		return r21_net_forward;
	}
	public void setR21_net_forward(BigDecimal r21_net_forward) {
		this.r21_net_forward = r21_net_forward;
	}
	public BigDecimal getR21_net_overall() {
		return r21_net_overall;
	}
	public void setR21_net_overall(BigDecimal r21_net_overall) {
		this.r21_net_overall = r21_net_overall;
	}
	public String getR22_product() {
		return r22_product;
	}
	public void setR22_product(String r22_product) {
		this.r22_product = r22_product;
	}
	public BigDecimal getR22_6month_uae() {
		return r22_6month_uae;
	}
	public void setR22_6month_uae(BigDecimal r22_6month_uae) {
		this.r22_6month_uae = r22_6month_uae;
	}
	public BigDecimal getR22_12month_uae() {
		return r22_12month_uae;
	}
	public void setR22_12month_uae(BigDecimal r22_12month_uae) {
		this.r22_12month_uae = r22_12month_uae;
	}
	public BigDecimal getR22_1year_uae() {
		return r22_1year_uae;
	}
	public void setR22_1year_uae(BigDecimal r22_1year_uae) {
		this.r22_1year_uae = r22_1year_uae;
	}
	public BigDecimal getR22_6month_other_uae() {
		return r22_6month_other_uae;
	}
	public void setR22_6month_other_uae(BigDecimal r22_6month_other_uae) {
		this.r22_6month_other_uae = r22_6month_other_uae;
	}
	public BigDecimal getR22_12month_other_uae() {
		return r22_12month_other_uae;
	}
	public void setR22_12month_other_uae(BigDecimal r22_12month_other_uae) {
		this.r22_12month_other_uae = r22_12month_other_uae;
	}
	public BigDecimal getR22_1year_other_uae() {
		return r22_1year_other_uae;
	}
	public void setR22_1year_other_uae(BigDecimal r22_1year_other_uae) {
		this.r22_1year_other_uae = r22_1year_other_uae;
	}
	public BigDecimal getR22_6month_non_uae() {
		return r22_6month_non_uae;
	}
	public void setR22_6month_non_uae(BigDecimal r22_6month_non_uae) {
		this.r22_6month_non_uae = r22_6month_non_uae;
	}
	public BigDecimal getR22_12month_non_uae() {
		return r22_12month_non_uae;
	}
	public void setR22_12month_non_uae(BigDecimal r22_12month_non_uae) {
		this.r22_12month_non_uae = r22_12month_non_uae;
	}
	public BigDecimal getR22_1year_non_uae() {
		return r22_1year_non_uae;
	}
	public void setR22_1year_non_uae(BigDecimal r22_1year_non_uae) {
		this.r22_1year_non_uae = r22_1year_non_uae;
	}
	public BigDecimal getR22_6month_other_non_uae() {
		return r22_6month_other_non_uae;
	}
	public void setR22_6month_other_non_uae(BigDecimal r22_6month_other_non_uae) {
		this.r22_6month_other_non_uae = r22_6month_other_non_uae;
	}
	public BigDecimal getR22_12month_other_non_uae() {
		return r22_12month_other_non_uae;
	}
	public void setR22_12month_other_non_uae(BigDecimal r22_12month_other_non_uae) {
		this.r22_12month_other_non_uae = r22_12month_other_non_uae;
	}
	public BigDecimal getR22_1year_other_non_uae() {
		return r22_1year_other_non_uae;
	}
	public void setR22_1year_other_non_uae(BigDecimal r22_1year_other_non_uae) {
		this.r22_1year_other_non_uae = r22_1year_other_non_uae;
	}
	public BigDecimal getR22_other_assets() {
		return r22_other_assets;
	}
	public void setR22_other_assets(BigDecimal r22_other_assets) {
		this.r22_other_assets = r22_other_assets;
	}
	public BigDecimal getR22_total_assets() {
		return r22_total_assets;
	}
	public void setR22_total_assets(BigDecimal r22_total_assets) {
		this.r22_total_assets = r22_total_assets;
	}
	public BigDecimal getR22_total_libilities() {
		return r22_total_libilities;
	}
	public void setR22_total_libilities(BigDecimal r22_total_libilities) {
		this.r22_total_libilities = r22_total_libilities;
	}
	public BigDecimal getR22_net_forward() {
		return r22_net_forward;
	}
	public void setR22_net_forward(BigDecimal r22_net_forward) {
		this.r22_net_forward = r22_net_forward;
	}
	public BigDecimal getR22_net_overall() {
		return r22_net_overall;
	}
	public void setR22_net_overall(BigDecimal r22_net_overall) {
		this.r22_net_overall = r22_net_overall;
	}
	public String getR23_product() {
		return r23_product;
	}
	public void setR23_product(String r23_product) {
		this.r23_product = r23_product;
	}
	public BigDecimal getR23_6month_uae() {
		return r23_6month_uae;
	}
	public void setR23_6month_uae(BigDecimal r23_6month_uae) {
		this.r23_6month_uae = r23_6month_uae;
	}
	public BigDecimal getR23_12month_uae() {
		return r23_12month_uae;
	}
	public void setR23_12month_uae(BigDecimal r23_12month_uae) {
		this.r23_12month_uae = r23_12month_uae;
	}
	public BigDecimal getR23_1year_uae() {
		return r23_1year_uae;
	}
	public void setR23_1year_uae(BigDecimal r23_1year_uae) {
		this.r23_1year_uae = r23_1year_uae;
	}
	public BigDecimal getR23_6month_other_uae() {
		return r23_6month_other_uae;
	}
	public void setR23_6month_other_uae(BigDecimal r23_6month_other_uae) {
		this.r23_6month_other_uae = r23_6month_other_uae;
	}
	public BigDecimal getR23_12month_other_uae() {
		return r23_12month_other_uae;
	}
	public void setR23_12month_other_uae(BigDecimal r23_12month_other_uae) {
		this.r23_12month_other_uae = r23_12month_other_uae;
	}
	public BigDecimal getR23_1year_other_uae() {
		return r23_1year_other_uae;
	}
	public void setR23_1year_other_uae(BigDecimal r23_1year_other_uae) {
		this.r23_1year_other_uae = r23_1year_other_uae;
	}
	public BigDecimal getR23_6month_non_uae() {
		return r23_6month_non_uae;
	}
	public void setR23_6month_non_uae(BigDecimal r23_6month_non_uae) {
		this.r23_6month_non_uae = r23_6month_non_uae;
	}
	public BigDecimal getR23_12month_non_uae() {
		return r23_12month_non_uae;
	}
	public void setR23_12month_non_uae(BigDecimal r23_12month_non_uae) {
		this.r23_12month_non_uae = r23_12month_non_uae;
	}
	public BigDecimal getR23_1year_non_uae() {
		return r23_1year_non_uae;
	}
	public void setR23_1year_non_uae(BigDecimal r23_1year_non_uae) {
		this.r23_1year_non_uae = r23_1year_non_uae;
	}
	public BigDecimal getR23_6month_other_non_uae() {
		return r23_6month_other_non_uae;
	}
	public void setR23_6month_other_non_uae(BigDecimal r23_6month_other_non_uae) {
		this.r23_6month_other_non_uae = r23_6month_other_non_uae;
	}
	public BigDecimal getR23_12month_other_non_uae() {
		return r23_12month_other_non_uae;
	}
	public void setR23_12month_other_non_uae(BigDecimal r23_12month_other_non_uae) {
		this.r23_12month_other_non_uae = r23_12month_other_non_uae;
	}
	public BigDecimal getR23_1year_other_non_uae() {
		return r23_1year_other_non_uae;
	}
	public void setR23_1year_other_non_uae(BigDecimal r23_1year_other_non_uae) {
		this.r23_1year_other_non_uae = r23_1year_other_non_uae;
	}
	public BigDecimal getR23_other_assets() {
		return r23_other_assets;
	}
	public void setR23_other_assets(BigDecimal r23_other_assets) {
		this.r23_other_assets = r23_other_assets;
	}
	public BigDecimal getR23_total_assets() {
		return r23_total_assets;
	}
	public void setR23_total_assets(BigDecimal r23_total_assets) {
		this.r23_total_assets = r23_total_assets;
	}
	public BigDecimal getR23_total_libilities() {
		return r23_total_libilities;
	}
	public void setR23_total_libilities(BigDecimal r23_total_libilities) {
		this.r23_total_libilities = r23_total_libilities;
	}
	public BigDecimal getR23_net_forward() {
		return r23_net_forward;
	}
	public void setR23_net_forward(BigDecimal r23_net_forward) {
		this.r23_net_forward = r23_net_forward;
	}
	public BigDecimal getR23_net_overall() {
		return r23_net_overall;
	}
	public void setR23_net_overall(BigDecimal r23_net_overall) {
		this.r23_net_overall = r23_net_overall;
	}
	public String getR24_product() {
		return r24_product;
	}
	public void setR24_product(String r24_product) {
		this.r24_product = r24_product;
	}
	public BigDecimal getR24_6month_uae() {
		return r24_6month_uae;
	}
	public void setR24_6month_uae(BigDecimal r24_6month_uae) {
		this.r24_6month_uae = r24_6month_uae;
	}
	public BigDecimal getR24_12month_uae() {
		return r24_12month_uae;
	}
	public void setR24_12month_uae(BigDecimal r24_12month_uae) {
		this.r24_12month_uae = r24_12month_uae;
	}
	public BigDecimal getR24_1year_uae() {
		return r24_1year_uae;
	}
	public void setR24_1year_uae(BigDecimal r24_1year_uae) {
		this.r24_1year_uae = r24_1year_uae;
	}
	public BigDecimal getR24_6month_other_uae() {
		return r24_6month_other_uae;
	}
	public void setR24_6month_other_uae(BigDecimal r24_6month_other_uae) {
		this.r24_6month_other_uae = r24_6month_other_uae;
	}
	public BigDecimal getR24_12month_other_uae() {
		return r24_12month_other_uae;
	}
	public void setR24_12month_other_uae(BigDecimal r24_12month_other_uae) {
		this.r24_12month_other_uae = r24_12month_other_uae;
	}
	public BigDecimal getR24_1year_other_uae() {
		return r24_1year_other_uae;
	}
	public void setR24_1year_other_uae(BigDecimal r24_1year_other_uae) {
		this.r24_1year_other_uae = r24_1year_other_uae;
	}
	public BigDecimal getR24_6month_non_uae() {
		return r24_6month_non_uae;
	}
	public void setR24_6month_non_uae(BigDecimal r24_6month_non_uae) {
		this.r24_6month_non_uae = r24_6month_non_uae;
	}
	public BigDecimal getR24_12month_non_uae() {
		return r24_12month_non_uae;
	}
	public void setR24_12month_non_uae(BigDecimal r24_12month_non_uae) {
		this.r24_12month_non_uae = r24_12month_non_uae;
	}
	public BigDecimal getR24_1year_non_uae() {
		return r24_1year_non_uae;
	}
	public void setR24_1year_non_uae(BigDecimal r24_1year_non_uae) {
		this.r24_1year_non_uae = r24_1year_non_uae;
	}
	public BigDecimal getR24_6month_other_non_uae() {
		return r24_6month_other_non_uae;
	}
	public void setR24_6month_other_non_uae(BigDecimal r24_6month_other_non_uae) {
		this.r24_6month_other_non_uae = r24_6month_other_non_uae;
	}
	public BigDecimal getR24_12month_other_non_uae() {
		return r24_12month_other_non_uae;
	}
	public void setR24_12month_other_non_uae(BigDecimal r24_12month_other_non_uae) {
		this.r24_12month_other_non_uae = r24_12month_other_non_uae;
	}
	public BigDecimal getR24_1year_other_non_uae() {
		return r24_1year_other_non_uae;
	}
	public void setR24_1year_other_non_uae(BigDecimal r24_1year_other_non_uae) {
		this.r24_1year_other_non_uae = r24_1year_other_non_uae;
	}
	public BigDecimal getR24_other_assets() {
		return r24_other_assets;
	}
	public void setR24_other_assets(BigDecimal r24_other_assets) {
		this.r24_other_assets = r24_other_assets;
	}
	public BigDecimal getR24_total_assets() {
		return r24_total_assets;
	}
	public void setR24_total_assets(BigDecimal r24_total_assets) {
		this.r24_total_assets = r24_total_assets;
	}
	public BigDecimal getR24_total_libilities() {
		return r24_total_libilities;
	}
	public void setR24_total_libilities(BigDecimal r24_total_libilities) {
		this.r24_total_libilities = r24_total_libilities;
	}
	public BigDecimal getR24_net_forward() {
		return r24_net_forward;
	}
	public void setR24_net_forward(BigDecimal r24_net_forward) {
		this.r24_net_forward = r24_net_forward;
	}
	public BigDecimal getR24_net_overall() {
		return r24_net_overall;
	}
	public void setR24_net_overall(BigDecimal r24_net_overall) {
		this.r24_net_overall = r24_net_overall;
	}
	public String getR25_product() {
		return r25_product;
	}
	public void setR25_product(String r25_product) {
		this.r25_product = r25_product;
	}
	public BigDecimal getR25_6month_uae() {
		return r25_6month_uae;
	}
	public void setR25_6month_uae(BigDecimal r25_6month_uae) {
		this.r25_6month_uae = r25_6month_uae;
	}
	public BigDecimal getR25_12month_uae() {
		return r25_12month_uae;
	}
	public void setR25_12month_uae(BigDecimal r25_12month_uae) {
		this.r25_12month_uae = r25_12month_uae;
	}
	public BigDecimal getR25_1year_uae() {
		return r25_1year_uae;
	}
	public void setR25_1year_uae(BigDecimal r25_1year_uae) {
		this.r25_1year_uae = r25_1year_uae;
	}
	public BigDecimal getR25_6month_other_uae() {
		return r25_6month_other_uae;
	}
	public void setR25_6month_other_uae(BigDecimal r25_6month_other_uae) {
		this.r25_6month_other_uae = r25_6month_other_uae;
	}
	public BigDecimal getR25_12month_other_uae() {
		return r25_12month_other_uae;
	}
	public void setR25_12month_other_uae(BigDecimal r25_12month_other_uae) {
		this.r25_12month_other_uae = r25_12month_other_uae;
	}
	public BigDecimal getR25_1year_other_uae() {
		return r25_1year_other_uae;
	}
	public void setR25_1year_other_uae(BigDecimal r25_1year_other_uae) {
		this.r25_1year_other_uae = r25_1year_other_uae;
	}
	public BigDecimal getR25_6month_non_uae() {
		return r25_6month_non_uae;
	}
	public void setR25_6month_non_uae(BigDecimal r25_6month_non_uae) {
		this.r25_6month_non_uae = r25_6month_non_uae;
	}
	public BigDecimal getR25_12month_non_uae() {
		return r25_12month_non_uae;
	}
	public void setR25_12month_non_uae(BigDecimal r25_12month_non_uae) {
		this.r25_12month_non_uae = r25_12month_non_uae;
	}
	public BigDecimal getR25_1year_non_uae() {
		return r25_1year_non_uae;
	}
	public void setR25_1year_non_uae(BigDecimal r25_1year_non_uae) {
		this.r25_1year_non_uae = r25_1year_non_uae;
	}
	public BigDecimal getR25_6month_other_non_uae() {
		return r25_6month_other_non_uae;
	}
	public void setR25_6month_other_non_uae(BigDecimal r25_6month_other_non_uae) {
		this.r25_6month_other_non_uae = r25_6month_other_non_uae;
	}
	public BigDecimal getR25_12month_other_non_uae() {
		return r25_12month_other_non_uae;
	}
	public void setR25_12month_other_non_uae(BigDecimal r25_12month_other_non_uae) {
		this.r25_12month_other_non_uae = r25_12month_other_non_uae;
	}
	public BigDecimal getR25_1year_other_non_uae() {
		return r25_1year_other_non_uae;
	}
	public void setR25_1year_other_non_uae(BigDecimal r25_1year_other_non_uae) {
		this.r25_1year_other_non_uae = r25_1year_other_non_uae;
	}
	public BigDecimal getR25_other_assets() {
		return r25_other_assets;
	}
	public void setR25_other_assets(BigDecimal r25_other_assets) {
		this.r25_other_assets = r25_other_assets;
	}
	public BigDecimal getR25_total_assets() {
		return r25_total_assets;
	}
	public void setR25_total_assets(BigDecimal r25_total_assets) {
		this.r25_total_assets = r25_total_assets;
	}
	public BigDecimal getR25_total_libilities() {
		return r25_total_libilities;
	}
	public void setR25_total_libilities(BigDecimal r25_total_libilities) {
		this.r25_total_libilities = r25_total_libilities;
	}
	public BigDecimal getR25_net_forward() {
		return r25_net_forward;
	}
	public void setR25_net_forward(BigDecimal r25_net_forward) {
		this.r25_net_forward = r25_net_forward;
	}
	public BigDecimal getR25_net_overall() {
		return r25_net_overall;
	}
	public void setR25_net_overall(BigDecimal r25_net_overall) {
		this.r25_net_overall = r25_net_overall;
	}
	public String getR30_product() {
		return r30_product;
	}
	public void setR30_product(String r30_product) {
		this.r30_product = r30_product;
	}
	public BigDecimal getR30_6month_uae() {
		return r30_6month_uae;
	}
	public void setR30_6month_uae(BigDecimal r30_6month_uae) {
		this.r30_6month_uae = r30_6month_uae;
	}
	public BigDecimal getR30_12month_uae() {
		return r30_12month_uae;
	}
	public void setR30_12month_uae(BigDecimal r30_12month_uae) {
		this.r30_12month_uae = r30_12month_uae;
	}
	public BigDecimal getR30_1year_uae() {
		return r30_1year_uae;
	}
	public void setR30_1year_uae(BigDecimal r30_1year_uae) {
		this.r30_1year_uae = r30_1year_uae;
	}
	public BigDecimal getR30_6month_other_uae() {
		return r30_6month_other_uae;
	}
	public void setR30_6month_other_uae(BigDecimal r30_6month_other_uae) {
		this.r30_6month_other_uae = r30_6month_other_uae;
	}
	public BigDecimal getR30_12month_other_uae() {
		return r30_12month_other_uae;
	}
	public void setR30_12month_other_uae(BigDecimal r30_12month_other_uae) {
		this.r30_12month_other_uae = r30_12month_other_uae;
	}
	public BigDecimal getR30_1year_other_uae() {
		return r30_1year_other_uae;
	}
	public void setR30_1year_other_uae(BigDecimal r30_1year_other_uae) {
		this.r30_1year_other_uae = r30_1year_other_uae;
	}
	public BigDecimal getR30_6month_non_uae() {
		return r30_6month_non_uae;
	}
	public void setR30_6month_non_uae(BigDecimal r30_6month_non_uae) {
		this.r30_6month_non_uae = r30_6month_non_uae;
	}
	public BigDecimal getR30_12month_non_uae() {
		return r30_12month_non_uae;
	}
	public void setR30_12month_non_uae(BigDecimal r30_12month_non_uae) {
		this.r30_12month_non_uae = r30_12month_non_uae;
	}
	public BigDecimal getR30_1year_non_uae() {
		return r30_1year_non_uae;
	}
	public void setR30_1year_non_uae(BigDecimal r30_1year_non_uae) {
		this.r30_1year_non_uae = r30_1year_non_uae;
	}
	public BigDecimal getR30_6month_other_non_uae() {
		return r30_6month_other_non_uae;
	}
	public void setR30_6month_other_non_uae(BigDecimal r30_6month_other_non_uae) {
		this.r30_6month_other_non_uae = r30_6month_other_non_uae;
	}
	public BigDecimal getR30_12month_other_non_uae() {
		return r30_12month_other_non_uae;
	}
	public void setR30_12month_other_non_uae(BigDecimal r30_12month_other_non_uae) {
		this.r30_12month_other_non_uae = r30_12month_other_non_uae;
	}
	public BigDecimal getR30_1year_other_non_uae() {
		return r30_1year_other_non_uae;
	}
	public void setR30_1year_other_non_uae(BigDecimal r30_1year_other_non_uae) {
		this.r30_1year_other_non_uae = r30_1year_other_non_uae;
	}
	public BigDecimal getR30_total_libilities() {
		return r30_total_libilities;
	}
	public void setR30_total_libilities(BigDecimal r30_total_libilities) {
		this.r30_total_libilities = r30_total_libilities;
	}
	public BigDecimal getR30_total_spot() {
		return r30_total_spot;
	}
	public void setR30_total_spot(BigDecimal r30_total_spot) {
		this.r30_total_spot = r30_total_spot;
	}
	public String getR31_product() {
		return r31_product;
	}
	public void setR31_product(String r31_product) {
		this.r31_product = r31_product;
	}
	public BigDecimal getR31_6month_uae() {
		return r31_6month_uae;
	}
	public void setR31_6month_uae(BigDecimal r31_6month_uae) {
		this.r31_6month_uae = r31_6month_uae;
	}
	public BigDecimal getR31_12month_uae() {
		return r31_12month_uae;
	}
	public void setR31_12month_uae(BigDecimal r31_12month_uae) {
		this.r31_12month_uae = r31_12month_uae;
	}
	public BigDecimal getR31_1year_uae() {
		return r31_1year_uae;
	}
	public void setR31_1year_uae(BigDecimal r31_1year_uae) {
		this.r31_1year_uae = r31_1year_uae;
	}
	public BigDecimal getR31_6month_other_uae() {
		return r31_6month_other_uae;
	}
	public void setR31_6month_other_uae(BigDecimal r31_6month_other_uae) {
		this.r31_6month_other_uae = r31_6month_other_uae;
	}
	public BigDecimal getR31_12month_other_uae() {
		return r31_12month_other_uae;
	}
	public void setR31_12month_other_uae(BigDecimal r31_12month_other_uae) {
		this.r31_12month_other_uae = r31_12month_other_uae;
	}
	public BigDecimal getR31_1year_other_uae() {
		return r31_1year_other_uae;
	}
	public void setR31_1year_other_uae(BigDecimal r31_1year_other_uae) {
		this.r31_1year_other_uae = r31_1year_other_uae;
	}
	public BigDecimal getR31_6month_non_uae() {
		return r31_6month_non_uae;
	}
	public void setR31_6month_non_uae(BigDecimal r31_6month_non_uae) {
		this.r31_6month_non_uae = r31_6month_non_uae;
	}
	public BigDecimal getR31_12month_non_uae() {
		return r31_12month_non_uae;
	}
	public void setR31_12month_non_uae(BigDecimal r31_12month_non_uae) {
		this.r31_12month_non_uae = r31_12month_non_uae;
	}
	public BigDecimal getR31_1year_non_uae() {
		return r31_1year_non_uae;
	}
	public void setR31_1year_non_uae(BigDecimal r31_1year_non_uae) {
		this.r31_1year_non_uae = r31_1year_non_uae;
	}
	public BigDecimal getR31_6month_other_non_uae() {
		return r31_6month_other_non_uae;
	}
	public void setR31_6month_other_non_uae(BigDecimal r31_6month_other_non_uae) {
		this.r31_6month_other_non_uae = r31_6month_other_non_uae;
	}
	public BigDecimal getR31_12month_other_non_uae() {
		return r31_12month_other_non_uae;
	}
	public void setR31_12month_other_non_uae(BigDecimal r31_12month_other_non_uae) {
		this.r31_12month_other_non_uae = r31_12month_other_non_uae;
	}
	public BigDecimal getR31_1year_other_non_uae() {
		return r31_1year_other_non_uae;
	}
	public void setR31_1year_other_non_uae(BigDecimal r31_1year_other_non_uae) {
		this.r31_1year_other_non_uae = r31_1year_other_non_uae;
	}
	public BigDecimal getR31_total_libilities() {
		return r31_total_libilities;
	}
	public void setR31_total_libilities(BigDecimal r31_total_libilities) {
		this.r31_total_libilities = r31_total_libilities;
	}
	public BigDecimal getR31_total_spot() {
		return r31_total_spot;
	}
	public void setR31_total_spot(BigDecimal r31_total_spot) {
		this.r31_total_spot = r31_total_spot;
	}
	public String getR32_product() {
		return r32_product;
	}
	public void setR32_product(String r32_product) {
		this.r32_product = r32_product;
	}
	public BigDecimal getR32_6month_uae() {
		return r32_6month_uae;
	}
	public void setR32_6month_uae(BigDecimal r32_6month_uae) {
		this.r32_6month_uae = r32_6month_uae;
	}
	public BigDecimal getR32_12month_uae() {
		return r32_12month_uae;
	}
	public void setR32_12month_uae(BigDecimal r32_12month_uae) {
		this.r32_12month_uae = r32_12month_uae;
	}
	public BigDecimal getR32_1year_uae() {
		return r32_1year_uae;
	}
	public void setR32_1year_uae(BigDecimal r32_1year_uae) {
		this.r32_1year_uae = r32_1year_uae;
	}
	public BigDecimal getR32_6month_other_uae() {
		return r32_6month_other_uae;
	}
	public void setR32_6month_other_uae(BigDecimal r32_6month_other_uae) {
		this.r32_6month_other_uae = r32_6month_other_uae;
	}
	public BigDecimal getR32_12month_other_uae() {
		return r32_12month_other_uae;
	}
	public void setR32_12month_other_uae(BigDecimal r32_12month_other_uae) {
		this.r32_12month_other_uae = r32_12month_other_uae;
	}
	public BigDecimal getR32_1year_other_uae() {
		return r32_1year_other_uae;
	}
	public void setR32_1year_other_uae(BigDecimal r32_1year_other_uae) {
		this.r32_1year_other_uae = r32_1year_other_uae;
	}
	public BigDecimal getR32_6month_non_uae() {
		return r32_6month_non_uae;
	}
	public void setR32_6month_non_uae(BigDecimal r32_6month_non_uae) {
		this.r32_6month_non_uae = r32_6month_non_uae;
	}
	public BigDecimal getR32_12month_non_uae() {
		return r32_12month_non_uae;
	}
	public void setR32_12month_non_uae(BigDecimal r32_12month_non_uae) {
		this.r32_12month_non_uae = r32_12month_non_uae;
	}
	public BigDecimal getR32_1year_non_uae() {
		return r32_1year_non_uae;
	}
	public void setR32_1year_non_uae(BigDecimal r32_1year_non_uae) {
		this.r32_1year_non_uae = r32_1year_non_uae;
	}
	public BigDecimal getR32_6month_other_non_uae() {
		return r32_6month_other_non_uae;
	}
	public void setR32_6month_other_non_uae(BigDecimal r32_6month_other_non_uae) {
		this.r32_6month_other_non_uae = r32_6month_other_non_uae;
	}
	public BigDecimal getR32_12month_other_non_uae() {
		return r32_12month_other_non_uae;
	}
	public void setR32_12month_other_non_uae(BigDecimal r32_12month_other_non_uae) {
		this.r32_12month_other_non_uae = r32_12month_other_non_uae;
	}
	public BigDecimal getR32_1year_other_non_uae() {
		return r32_1year_other_non_uae;
	}
	public void setR32_1year_other_non_uae(BigDecimal r32_1year_other_non_uae) {
		this.r32_1year_other_non_uae = r32_1year_other_non_uae;
	}
	public BigDecimal getR32_total_libilities() {
		return r32_total_libilities;
	}
	public void setR32_total_libilities(BigDecimal r32_total_libilities) {
		this.r32_total_libilities = r32_total_libilities;
	}
	public BigDecimal getR32_total_spot() {
		return r32_total_spot;
	}
	public void setR32_total_spot(BigDecimal r32_total_spot) {
		this.r32_total_spot = r32_total_spot;
	}
	public String getR33_product() {
		return r33_product;
	}
	public void setR33_product(String r33_product) {
		this.r33_product = r33_product;
	}
	public BigDecimal getR33_6month_uae() {
		return r33_6month_uae;
	}
	public void setR33_6month_uae(BigDecimal r33_6month_uae) {
		this.r33_6month_uae = r33_6month_uae;
	}
	public BigDecimal getR33_12month_uae() {
		return r33_12month_uae;
	}
	public void setR33_12month_uae(BigDecimal r33_12month_uae) {
		this.r33_12month_uae = r33_12month_uae;
	}
	public BigDecimal getR33_1year_uae() {
		return r33_1year_uae;
	}
	public void setR33_1year_uae(BigDecimal r33_1year_uae) {
		this.r33_1year_uae = r33_1year_uae;
	}
	public BigDecimal getR33_6month_other_uae() {
		return r33_6month_other_uae;
	}
	public void setR33_6month_other_uae(BigDecimal r33_6month_other_uae) {
		this.r33_6month_other_uae = r33_6month_other_uae;
	}
	public BigDecimal getR33_12month_other_uae() {
		return r33_12month_other_uae;
	}
	public void setR33_12month_other_uae(BigDecimal r33_12month_other_uae) {
		this.r33_12month_other_uae = r33_12month_other_uae;
	}
	public BigDecimal getR33_1year_other_uae() {
		return r33_1year_other_uae;
	}
	public void setR33_1year_other_uae(BigDecimal r33_1year_other_uae) {
		this.r33_1year_other_uae = r33_1year_other_uae;
	}
	public BigDecimal getR33_6month_non_uae() {
		return r33_6month_non_uae;
	}
	public void setR33_6month_non_uae(BigDecimal r33_6month_non_uae) {
		this.r33_6month_non_uae = r33_6month_non_uae;
	}
	public BigDecimal getR33_12month_non_uae() {
		return r33_12month_non_uae;
	}
	public void setR33_12month_non_uae(BigDecimal r33_12month_non_uae) {
		this.r33_12month_non_uae = r33_12month_non_uae;
	}
	public BigDecimal getR33_1year_non_uae() {
		return r33_1year_non_uae;
	}
	public void setR33_1year_non_uae(BigDecimal r33_1year_non_uae) {
		this.r33_1year_non_uae = r33_1year_non_uae;
	}
	public BigDecimal getR33_6month_other_non_uae() {
		return r33_6month_other_non_uae;
	}
	public void setR33_6month_other_non_uae(BigDecimal r33_6month_other_non_uae) {
		this.r33_6month_other_non_uae = r33_6month_other_non_uae;
	}
	public BigDecimal getR33_12month_other_non_uae() {
		return r33_12month_other_non_uae;
	}
	public void setR33_12month_other_non_uae(BigDecimal r33_12month_other_non_uae) {
		this.r33_12month_other_non_uae = r33_12month_other_non_uae;
	}
	public BigDecimal getR33_1year_other_non_uae() {
		return r33_1year_other_non_uae;
	}
	public void setR33_1year_other_non_uae(BigDecimal r33_1year_other_non_uae) {
		this.r33_1year_other_non_uae = r33_1year_other_non_uae;
	}
	public BigDecimal getR33_total_libilities() {
		return r33_total_libilities;
	}
	public void setR33_total_libilities(BigDecimal r33_total_libilities) {
		this.r33_total_libilities = r33_total_libilities;
	}
	public BigDecimal getR33_total_spot() {
		return r33_total_spot;
	}
	public void setR33_total_spot(BigDecimal r33_total_spot) {
		this.r33_total_spot = r33_total_spot;
	}
	public String getR34_product() {
		return r34_product;
	}
	public void setR34_product(String r34_product) {
		this.r34_product = r34_product;
	}
	public BigDecimal getR34_6month_uae() {
		return r34_6month_uae;
	}
	public void setR34_6month_uae(BigDecimal r34_6month_uae) {
		this.r34_6month_uae = r34_6month_uae;
	}
	public BigDecimal getR34_12month_uae() {
		return r34_12month_uae;
	}
	public void setR34_12month_uae(BigDecimal r34_12month_uae) {
		this.r34_12month_uae = r34_12month_uae;
	}
	public BigDecimal getR34_1year_uae() {
		return r34_1year_uae;
	}
	public void setR34_1year_uae(BigDecimal r34_1year_uae) {
		this.r34_1year_uae = r34_1year_uae;
	}
	public BigDecimal getR34_6month_other_uae() {
		return r34_6month_other_uae;
	}
	public void setR34_6month_other_uae(BigDecimal r34_6month_other_uae) {
		this.r34_6month_other_uae = r34_6month_other_uae;
	}
	public BigDecimal getR34_12month_other_uae() {
		return r34_12month_other_uae;
	}
	public void setR34_12month_other_uae(BigDecimal r34_12month_other_uae) {
		this.r34_12month_other_uae = r34_12month_other_uae;
	}
	public BigDecimal getR34_1year_other_uae() {
		return r34_1year_other_uae;
	}
	public void setR34_1year_other_uae(BigDecimal r34_1year_other_uae) {
		this.r34_1year_other_uae = r34_1year_other_uae;
	}
	public BigDecimal getR34_6month_non_uae() {
		return r34_6month_non_uae;
	}
	public void setR34_6month_non_uae(BigDecimal r34_6month_non_uae) {
		this.r34_6month_non_uae = r34_6month_non_uae;
	}
	public BigDecimal getR34_12month_non_uae() {
		return r34_12month_non_uae;
	}
	public void setR34_12month_non_uae(BigDecimal r34_12month_non_uae) {
		this.r34_12month_non_uae = r34_12month_non_uae;
	}
	public BigDecimal getR34_1year_non_uae() {
		return r34_1year_non_uae;
	}
	public void setR34_1year_non_uae(BigDecimal r34_1year_non_uae) {
		this.r34_1year_non_uae = r34_1year_non_uae;
	}
	public BigDecimal getR34_6month_other_non_uae() {
		return r34_6month_other_non_uae;
	}
	public void setR34_6month_other_non_uae(BigDecimal r34_6month_other_non_uae) {
		this.r34_6month_other_non_uae = r34_6month_other_non_uae;
	}
	public BigDecimal getR34_12month_other_non_uae() {
		return r34_12month_other_non_uae;
	}
	public void setR34_12month_other_non_uae(BigDecimal r34_12month_other_non_uae) {
		this.r34_12month_other_non_uae = r34_12month_other_non_uae;
	}
	public BigDecimal getR34_1year_other_non_uae() {
		return r34_1year_other_non_uae;
	}
	public void setR34_1year_other_non_uae(BigDecimal r34_1year_other_non_uae) {
		this.r34_1year_other_non_uae = r34_1year_other_non_uae;
	}
	public BigDecimal getR34_total_libilities() {
		return r34_total_libilities;
	}
	public void setR34_total_libilities(BigDecimal r34_total_libilities) {
		this.r34_total_libilities = r34_total_libilities;
	}
	public BigDecimal getR34_total_spot() {
		return r34_total_spot;
	}
	public void setR34_total_spot(BigDecimal r34_total_spot) {
		this.r34_total_spot = r34_total_spot;
	}
	public String getR35_product() {
		return r35_product;
	}
	public void setR35_product(String r35_product) {
		this.r35_product = r35_product;
	}
	public BigDecimal getR35_6month_uae() {
		return r35_6month_uae;
	}
	public void setR35_6month_uae(BigDecimal r35_6month_uae) {
		this.r35_6month_uae = r35_6month_uae;
	}
	public BigDecimal getR35_12month_uae() {
		return r35_12month_uae;
	}
	public void setR35_12month_uae(BigDecimal r35_12month_uae) {
		this.r35_12month_uae = r35_12month_uae;
	}
	public BigDecimal getR35_1year_uae() {
		return r35_1year_uae;
	}
	public void setR35_1year_uae(BigDecimal r35_1year_uae) {
		this.r35_1year_uae = r35_1year_uae;
	}
	public BigDecimal getR35_6month_other_uae() {
		return r35_6month_other_uae;
	}
	public void setR35_6month_other_uae(BigDecimal r35_6month_other_uae) {
		this.r35_6month_other_uae = r35_6month_other_uae;
	}
	public BigDecimal getR35_12month_other_uae() {
		return r35_12month_other_uae;
	}
	public void setR35_12month_other_uae(BigDecimal r35_12month_other_uae) {
		this.r35_12month_other_uae = r35_12month_other_uae;
	}
	public BigDecimal getR35_1year_other_uae() {
		return r35_1year_other_uae;
	}
	public void setR35_1year_other_uae(BigDecimal r35_1year_other_uae) {
		this.r35_1year_other_uae = r35_1year_other_uae;
	}
	public BigDecimal getR35_6month_non_uae() {
		return r35_6month_non_uae;
	}
	public void setR35_6month_non_uae(BigDecimal r35_6month_non_uae) {
		this.r35_6month_non_uae = r35_6month_non_uae;
	}
	public BigDecimal getR35_12month_non_uae() {
		return r35_12month_non_uae;
	}
	public void setR35_12month_non_uae(BigDecimal r35_12month_non_uae) {
		this.r35_12month_non_uae = r35_12month_non_uae;
	}
	public BigDecimal getR35_1year_non_uae() {
		return r35_1year_non_uae;
	}
	public void setR35_1year_non_uae(BigDecimal r35_1year_non_uae) {
		this.r35_1year_non_uae = r35_1year_non_uae;
	}
	public BigDecimal getR35_6month_other_non_uae() {
		return r35_6month_other_non_uae;
	}
	public void setR35_6month_other_non_uae(BigDecimal r35_6month_other_non_uae) {
		this.r35_6month_other_non_uae = r35_6month_other_non_uae;
	}
	public BigDecimal getR35_12month_other_non_uae() {
		return r35_12month_other_non_uae;
	}
	public void setR35_12month_other_non_uae(BigDecimal r35_12month_other_non_uae) {
		this.r35_12month_other_non_uae = r35_12month_other_non_uae;
	}
	public BigDecimal getR35_1year_other_non_uae() {
		return r35_1year_other_non_uae;
	}
	public void setR35_1year_other_non_uae(BigDecimal r35_1year_other_non_uae) {
		this.r35_1year_other_non_uae = r35_1year_other_non_uae;
	}
	public BigDecimal getR35_total_libilities() {
		return r35_total_libilities;
	}
	public void setR35_total_libilities(BigDecimal r35_total_libilities) {
		this.r35_total_libilities = r35_total_libilities;
	}
	public BigDecimal getR35_total_spot() {
		return r35_total_spot;
	}
	public void setR35_total_spot(BigDecimal r35_total_spot) {
		this.r35_total_spot = r35_total_spot;
	}
	public String getR36_product() {
		return r36_product;
	}
	public void setR36_product(String r36_product) {
		this.r36_product = r36_product;
	}
	public BigDecimal getR36_6month_uae() {
		return r36_6month_uae;
	}
	public void setR36_6month_uae(BigDecimal r36_6month_uae) {
		this.r36_6month_uae = r36_6month_uae;
	}
	public BigDecimal getR36_12month_uae() {
		return r36_12month_uae;
	}
	public void setR36_12month_uae(BigDecimal r36_12month_uae) {
		this.r36_12month_uae = r36_12month_uae;
	}
	public BigDecimal getR36_1year_uae() {
		return r36_1year_uae;
	}
	public void setR36_1year_uae(BigDecimal r36_1year_uae) {
		this.r36_1year_uae = r36_1year_uae;
	}
	public BigDecimal getR36_6month_other_uae() {
		return r36_6month_other_uae;
	}
	public void setR36_6month_other_uae(BigDecimal r36_6month_other_uae) {
		this.r36_6month_other_uae = r36_6month_other_uae;
	}
	public BigDecimal getR36_12month_other_uae() {
		return r36_12month_other_uae;
	}
	public void setR36_12month_other_uae(BigDecimal r36_12month_other_uae) {
		this.r36_12month_other_uae = r36_12month_other_uae;
	}
	public BigDecimal getR36_1year_other_uae() {
		return r36_1year_other_uae;
	}
	public void setR36_1year_other_uae(BigDecimal r36_1year_other_uae) {
		this.r36_1year_other_uae = r36_1year_other_uae;
	}
	public BigDecimal getR36_6month_non_uae() {
		return r36_6month_non_uae;
	}
	public void setR36_6month_non_uae(BigDecimal r36_6month_non_uae) {
		this.r36_6month_non_uae = r36_6month_non_uae;
	}
	public BigDecimal getR36_12month_non_uae() {
		return r36_12month_non_uae;
	}
	public void setR36_12month_non_uae(BigDecimal r36_12month_non_uae) {
		this.r36_12month_non_uae = r36_12month_non_uae;
	}
	public BigDecimal getR36_1year_non_uae() {
		return r36_1year_non_uae;
	}
	public void setR36_1year_non_uae(BigDecimal r36_1year_non_uae) {
		this.r36_1year_non_uae = r36_1year_non_uae;
	}
	public BigDecimal getR36_6month_other_non_uae() {
		return r36_6month_other_non_uae;
	}
	public void setR36_6month_other_non_uae(BigDecimal r36_6month_other_non_uae) {
		this.r36_6month_other_non_uae = r36_6month_other_non_uae;
	}
	public BigDecimal getR36_12month_other_non_uae() {
		return r36_12month_other_non_uae;
	}
	public void setR36_12month_other_non_uae(BigDecimal r36_12month_other_non_uae) {
		this.r36_12month_other_non_uae = r36_12month_other_non_uae;
	}
	public BigDecimal getR36_1year_other_non_uae() {
		return r36_1year_other_non_uae;
	}
	public void setR36_1year_other_non_uae(BigDecimal r36_1year_other_non_uae) {
		this.r36_1year_other_non_uae = r36_1year_other_non_uae;
	}
	public BigDecimal getR36_total_libilities() {
		return r36_total_libilities;
	}
	public void setR36_total_libilities(BigDecimal r36_total_libilities) {
		this.r36_total_libilities = r36_total_libilities;
	}
	public BigDecimal getR36_total_spot() {
		return r36_total_spot;
	}
	public void setR36_total_spot(BigDecimal r36_total_spot) {
		this.r36_total_spot = r36_total_spot;
	}
	public String getR37_product() {
		return r37_product;
	}
	public void setR37_product(String r37_product) {
		this.r37_product = r37_product;
	}
	public BigDecimal getR37_6month_uae() {
		return r37_6month_uae;
	}
	public void setR37_6month_uae(BigDecimal r37_6month_uae) {
		this.r37_6month_uae = r37_6month_uae;
	}
	public BigDecimal getR37_12month_uae() {
		return r37_12month_uae;
	}
	public void setR37_12month_uae(BigDecimal r37_12month_uae) {
		this.r37_12month_uae = r37_12month_uae;
	}
	public BigDecimal getR37_1year_uae() {
		return r37_1year_uae;
	}
	public void setR37_1year_uae(BigDecimal r37_1year_uae) {
		this.r37_1year_uae = r37_1year_uae;
	}
	public BigDecimal getR37_6month_other_uae() {
		return r37_6month_other_uae;
	}
	public void setR37_6month_other_uae(BigDecimal r37_6month_other_uae) {
		this.r37_6month_other_uae = r37_6month_other_uae;
	}
	public BigDecimal getR37_12month_other_uae() {
		return r37_12month_other_uae;
	}
	public void setR37_12month_other_uae(BigDecimal r37_12month_other_uae) {
		this.r37_12month_other_uae = r37_12month_other_uae;
	}
	public BigDecimal getR37_1year_other_uae() {
		return r37_1year_other_uae;
	}
	public void setR37_1year_other_uae(BigDecimal r37_1year_other_uae) {
		this.r37_1year_other_uae = r37_1year_other_uae;
	}
	public BigDecimal getR37_6month_non_uae() {
		return r37_6month_non_uae;
	}
	public void setR37_6month_non_uae(BigDecimal r37_6month_non_uae) {
		this.r37_6month_non_uae = r37_6month_non_uae;
	}
	public BigDecimal getR37_12month_non_uae() {
		return r37_12month_non_uae;
	}
	public void setR37_12month_non_uae(BigDecimal r37_12month_non_uae) {
		this.r37_12month_non_uae = r37_12month_non_uae;
	}
	public BigDecimal getR37_1year_non_uae() {
		return r37_1year_non_uae;
	}
	public void setR37_1year_non_uae(BigDecimal r37_1year_non_uae) {
		this.r37_1year_non_uae = r37_1year_non_uae;
	}
	public BigDecimal getR37_6month_other_non_uae() {
		return r37_6month_other_non_uae;
	}
	public void setR37_6month_other_non_uae(BigDecimal r37_6month_other_non_uae) {
		this.r37_6month_other_non_uae = r37_6month_other_non_uae;
	}
	public BigDecimal getR37_12month_other_non_uae() {
		return r37_12month_other_non_uae;
	}
	public void setR37_12month_other_non_uae(BigDecimal r37_12month_other_non_uae) {
		this.r37_12month_other_non_uae = r37_12month_other_non_uae;
	}
	public BigDecimal getR37_1year_other_non_uae() {
		return r37_1year_other_non_uae;
	}
	public void setR37_1year_other_non_uae(BigDecimal r37_1year_other_non_uae) {
		this.r37_1year_other_non_uae = r37_1year_other_non_uae;
	}
	public BigDecimal getR37_total_libilities() {
		return r37_total_libilities;
	}
	public void setR37_total_libilities(BigDecimal r37_total_libilities) {
		this.r37_total_libilities = r37_total_libilities;
	}
	public BigDecimal getR37_total_spot() {
		return r37_total_spot;
	}
	public void setR37_total_spot(BigDecimal r37_total_spot) {
		this.r37_total_spot = r37_total_spot;
	}
	public String getR38_product() {
		return r38_product;
	}
	public void setR38_product(String r38_product) {
		this.r38_product = r38_product;
	}
	public BigDecimal getR38_6month_uae() {
		return r38_6month_uae;
	}
	public void setR38_6month_uae(BigDecimal r38_6month_uae) {
		this.r38_6month_uae = r38_6month_uae;
	}
	public BigDecimal getR38_12month_uae() {
		return r38_12month_uae;
	}
	public void setR38_12month_uae(BigDecimal r38_12month_uae) {
		this.r38_12month_uae = r38_12month_uae;
	}
	public BigDecimal getR38_1year_uae() {
		return r38_1year_uae;
	}
	public void setR38_1year_uae(BigDecimal r38_1year_uae) {
		this.r38_1year_uae = r38_1year_uae;
	}
	public BigDecimal getR38_6month_other_uae() {
		return r38_6month_other_uae;
	}
	public void setR38_6month_other_uae(BigDecimal r38_6month_other_uae) {
		this.r38_6month_other_uae = r38_6month_other_uae;
	}
	public BigDecimal getR38_12month_other_uae() {
		return r38_12month_other_uae;
	}
	public void setR38_12month_other_uae(BigDecimal r38_12month_other_uae) {
		this.r38_12month_other_uae = r38_12month_other_uae;
	}
	public BigDecimal getR38_1year_other_uae() {
		return r38_1year_other_uae;
	}
	public void setR38_1year_other_uae(BigDecimal r38_1year_other_uae) {
		this.r38_1year_other_uae = r38_1year_other_uae;
	}
	public BigDecimal getR38_6month_non_uae() {
		return r38_6month_non_uae;
	}
	public void setR38_6month_non_uae(BigDecimal r38_6month_non_uae) {
		this.r38_6month_non_uae = r38_6month_non_uae;
	}
	public BigDecimal getR38_12month_non_uae() {
		return r38_12month_non_uae;
	}
	public void setR38_12month_non_uae(BigDecimal r38_12month_non_uae) {
		this.r38_12month_non_uae = r38_12month_non_uae;
	}
	public BigDecimal getR38_1year_non_uae() {
		return r38_1year_non_uae;
	}
	public void setR38_1year_non_uae(BigDecimal r38_1year_non_uae) {
		this.r38_1year_non_uae = r38_1year_non_uae;
	}
	public BigDecimal getR38_6month_other_non_uae() {
		return r38_6month_other_non_uae;
	}
	public void setR38_6month_other_non_uae(BigDecimal r38_6month_other_non_uae) {
		this.r38_6month_other_non_uae = r38_6month_other_non_uae;
	}
	public BigDecimal getR38_12month_other_non_uae() {
		return r38_12month_other_non_uae;
	}
	public void setR38_12month_other_non_uae(BigDecimal r38_12month_other_non_uae) {
		this.r38_12month_other_non_uae = r38_12month_other_non_uae;
	}
	public BigDecimal getR38_1year_other_non_uae() {
		return r38_1year_other_non_uae;
	}
	public void setR38_1year_other_non_uae(BigDecimal r38_1year_other_non_uae) {
		this.r38_1year_other_non_uae = r38_1year_other_non_uae;
	}
	public BigDecimal getR38_total_libilities() {
		return r38_total_libilities;
	}
	public void setR38_total_libilities(BigDecimal r38_total_libilities) {
		this.r38_total_libilities = r38_total_libilities;
	}
	public BigDecimal getR38_total_spot() {
		return r38_total_spot;
	}
	public void setR38_total_spot(BigDecimal r38_total_spot) {
		this.r38_total_spot = r38_total_spot;
	}
	public String getR39_product() {
		return r39_product;
	}
	public void setR39_product(String r39_product) {
		this.r39_product = r39_product;
	}
	public BigDecimal getR39_6month_uae() {
		return r39_6month_uae;
	}
	public void setR39_6month_uae(BigDecimal r39_6month_uae) {
		this.r39_6month_uae = r39_6month_uae;
	}
	public BigDecimal getR39_12month_uae() {
		return r39_12month_uae;
	}
	public void setR39_12month_uae(BigDecimal r39_12month_uae) {
		this.r39_12month_uae = r39_12month_uae;
	}
	public BigDecimal getR39_1year_uae() {
		return r39_1year_uae;
	}
	public void setR39_1year_uae(BigDecimal r39_1year_uae) {
		this.r39_1year_uae = r39_1year_uae;
	}
	public BigDecimal getR39_6month_other_uae() {
		return r39_6month_other_uae;
	}
	public void setR39_6month_other_uae(BigDecimal r39_6month_other_uae) {
		this.r39_6month_other_uae = r39_6month_other_uae;
	}
	public BigDecimal getR39_12month_other_uae() {
		return r39_12month_other_uae;
	}
	public void setR39_12month_other_uae(BigDecimal r39_12month_other_uae) {
		this.r39_12month_other_uae = r39_12month_other_uae;
	}
	public BigDecimal getR39_1year_other_uae() {
		return r39_1year_other_uae;
	}
	public void setR39_1year_other_uae(BigDecimal r39_1year_other_uae) {
		this.r39_1year_other_uae = r39_1year_other_uae;
	}
	public BigDecimal getR39_6month_non_uae() {
		return r39_6month_non_uae;
	}
	public void setR39_6month_non_uae(BigDecimal r39_6month_non_uae) {
		this.r39_6month_non_uae = r39_6month_non_uae;
	}
	public BigDecimal getR39_12month_non_uae() {
		return r39_12month_non_uae;
	}
	public void setR39_12month_non_uae(BigDecimal r39_12month_non_uae) {
		this.r39_12month_non_uae = r39_12month_non_uae;
	}
	public BigDecimal getR39_1year_non_uae() {
		return r39_1year_non_uae;
	}
	public void setR39_1year_non_uae(BigDecimal r39_1year_non_uae) {
		this.r39_1year_non_uae = r39_1year_non_uae;
	}
	public BigDecimal getR39_6month_other_non_uae() {
		return r39_6month_other_non_uae;
	}
	public void setR39_6month_other_non_uae(BigDecimal r39_6month_other_non_uae) {
		this.r39_6month_other_non_uae = r39_6month_other_non_uae;
	}
	public BigDecimal getR39_12month_other_non_uae() {
		return r39_12month_other_non_uae;
	}
	public void setR39_12month_other_non_uae(BigDecimal r39_12month_other_non_uae) {
		this.r39_12month_other_non_uae = r39_12month_other_non_uae;
	}
	public BigDecimal getR39_1year_other_non_uae() {
		return r39_1year_other_non_uae;
	}
	public void setR39_1year_other_non_uae(BigDecimal r39_1year_other_non_uae) {
		this.r39_1year_other_non_uae = r39_1year_other_non_uae;
	}
	public BigDecimal getR39_total_libilities() {
		return r39_total_libilities;
	}
	public void setR39_total_libilities(BigDecimal r39_total_libilities) {
		this.r39_total_libilities = r39_total_libilities;
	}
	public BigDecimal getR39_total_spot() {
		return r39_total_spot;
	}
	public void setR39_total_spot(BigDecimal r39_total_spot) {
		this.r39_total_spot = r39_total_spot;
	}
	public String getR40_product() {
		return r40_product;
	}
	public void setR40_product(String r40_product) {
		this.r40_product = r40_product;
	}
	public BigDecimal getR40_6month_uae() {
		return r40_6month_uae;
	}
	public void setR40_6month_uae(BigDecimal r40_6month_uae) {
		this.r40_6month_uae = r40_6month_uae;
	}
	public BigDecimal getR40_12month_uae() {
		return r40_12month_uae;
	}
	public void setR40_12month_uae(BigDecimal r40_12month_uae) {
		this.r40_12month_uae = r40_12month_uae;
	}
	public BigDecimal getR40_1year_uae() {
		return r40_1year_uae;
	}
	public void setR40_1year_uae(BigDecimal r40_1year_uae) {
		this.r40_1year_uae = r40_1year_uae;
	}
	public BigDecimal getR40_6month_other_uae() {
		return r40_6month_other_uae;
	}
	public void setR40_6month_other_uae(BigDecimal r40_6month_other_uae) {
		this.r40_6month_other_uae = r40_6month_other_uae;
	}
	public BigDecimal getR40_12month_other_uae() {
		return r40_12month_other_uae;
	}
	public void setR40_12month_other_uae(BigDecimal r40_12month_other_uae) {
		this.r40_12month_other_uae = r40_12month_other_uae;
	}
	public BigDecimal getR40_1year_other_uae() {
		return r40_1year_other_uae;
	}
	public void setR40_1year_other_uae(BigDecimal r40_1year_other_uae) {
		this.r40_1year_other_uae = r40_1year_other_uae;
	}
	public BigDecimal getR40_6month_non_uae() {
		return r40_6month_non_uae;
	}
	public void setR40_6month_non_uae(BigDecimal r40_6month_non_uae) {
		this.r40_6month_non_uae = r40_6month_non_uae;
	}
	public BigDecimal getR40_12month_non_uae() {
		return r40_12month_non_uae;
	}
	public void setR40_12month_non_uae(BigDecimal r40_12month_non_uae) {
		this.r40_12month_non_uae = r40_12month_non_uae;
	}
	public BigDecimal getR40_1year_non_uae() {
		return r40_1year_non_uae;
	}
	public void setR40_1year_non_uae(BigDecimal r40_1year_non_uae) {
		this.r40_1year_non_uae = r40_1year_non_uae;
	}
	public BigDecimal getR40_6month_other_non_uae() {
		return r40_6month_other_non_uae;
	}
	public void setR40_6month_other_non_uae(BigDecimal r40_6month_other_non_uae) {
		this.r40_6month_other_non_uae = r40_6month_other_non_uae;
	}
	public BigDecimal getR40_12month_other_non_uae() {
		return r40_12month_other_non_uae;
	}
	public void setR40_12month_other_non_uae(BigDecimal r40_12month_other_non_uae) {
		this.r40_12month_other_non_uae = r40_12month_other_non_uae;
	}
	public BigDecimal getR40_1year_other_non_uae() {
		return r40_1year_other_non_uae;
	}
	public void setR40_1year_other_non_uae(BigDecimal r40_1year_other_non_uae) {
		this.r40_1year_other_non_uae = r40_1year_other_non_uae;
	}
	public BigDecimal getR40_total_libilities() {
		return r40_total_libilities;
	}
	public void setR40_total_libilities(BigDecimal r40_total_libilities) {
		this.r40_total_libilities = r40_total_libilities;
	}
	public BigDecimal getR40_total_spot() {
		return r40_total_spot;
	}
	public void setR40_total_spot(BigDecimal r40_total_spot) {
		this.r40_total_spot = r40_total_spot;
	}
	public String getR41_total() {
		return r41_total;
	}
	public void setR41_total(String r41_total) {
		this.r41_total = r41_total;
	}
	public BigDecimal getR41_6month_uae() {
		return r41_6month_uae;
	}
	public void setR41_6month_uae(BigDecimal r41_6month_uae) {
		this.r41_6month_uae = r41_6month_uae;
	}
	public BigDecimal getR41_12month_uae() {
		return r41_12month_uae;
	}
	public void setR41_12month_uae(BigDecimal r41_12month_uae) {
		this.r41_12month_uae = r41_12month_uae;
	}
	public BigDecimal getR41_1year_uae() {
		return r41_1year_uae;
	}
	public void setR41_1year_uae(BigDecimal r41_1year_uae) {
		this.r41_1year_uae = r41_1year_uae;
	}
	public BigDecimal getR41_6month_other_uae() {
		return r41_6month_other_uae;
	}
	public void setR41_6month_other_uae(BigDecimal r41_6month_other_uae) {
		this.r41_6month_other_uae = r41_6month_other_uae;
	}
	public BigDecimal getR41_12month_other_uae() {
		return r41_12month_other_uae;
	}
	public void setR41_12month_other_uae(BigDecimal r41_12month_other_uae) {
		this.r41_12month_other_uae = r41_12month_other_uae;
	}
	public BigDecimal getR41_1year_other_uae() {
		return r41_1year_other_uae;
	}
	public void setR41_1year_other_uae(BigDecimal r41_1year_other_uae) {
		this.r41_1year_other_uae = r41_1year_other_uae;
	}
	public BigDecimal getR41_6month_non_uae() {
		return r41_6month_non_uae;
	}
	public void setR41_6month_non_uae(BigDecimal r41_6month_non_uae) {
		this.r41_6month_non_uae = r41_6month_non_uae;
	}
	public BigDecimal getR41_12month_non_uae() {
		return r41_12month_non_uae;
	}
	public void setR41_12month_non_uae(BigDecimal r41_12month_non_uae) {
		this.r41_12month_non_uae = r41_12month_non_uae;
	}
	public BigDecimal getR41_1year_non_uae() {
		return r41_1year_non_uae;
	}
	public void setR41_1year_non_uae(BigDecimal r41_1year_non_uae) {
		this.r41_1year_non_uae = r41_1year_non_uae;
	}
	public BigDecimal getR41_6month_other_non_uae() {
		return r41_6month_other_non_uae;
	}
	public void setR41_6month_other_non_uae(BigDecimal r41_6month_other_non_uae) {
		this.r41_6month_other_non_uae = r41_6month_other_non_uae;
	}
	public BigDecimal getR41_12month_other_non_uae() {
		return r41_12month_other_non_uae;
	}
	public void setR41_12month_other_non_uae(BigDecimal r41_12month_other_non_uae) {
		this.r41_12month_other_non_uae = r41_12month_other_non_uae;
	}
	public BigDecimal getR41_1year_other_non_uae() {
		return r41_1year_other_non_uae;
	}
	public void setR41_1year_other_non_uae(BigDecimal r41_1year_other_non_uae) {
		this.r41_1year_other_non_uae = r41_1year_other_non_uae;
	}
	public BigDecimal getR41_total_libilities() {
		return r41_total_libilities;
	}
	public void setR41_total_libilities(BigDecimal r41_total_libilities) {
		this.r41_total_libilities = r41_total_libilities;
	}
	public BigDecimal getR41_total_spot() {
		return r41_total_spot;
	}
	public void setR41_total_spot(BigDecimal r41_total_spot) {
		this.r41_total_spot = r41_total_spot;
	}
	public String getR43_product() {
		return r43_product;
	}
	public void setR43_product(String r43_product) {
		this.r43_product = r43_product;
	}
	public BigDecimal getR43_6month_uae() {
		return r43_6month_uae;
	}
	public void setR43_6month_uae(BigDecimal r43_6month_uae) {
		this.r43_6month_uae = r43_6month_uae;
	}
	public BigDecimal getR43_12month_uae() {
		return r43_12month_uae;
	}
	public void setR43_12month_uae(BigDecimal r43_12month_uae) {
		this.r43_12month_uae = r43_12month_uae;
	}
	public BigDecimal getR43_1year_uae() {
		return r43_1year_uae;
	}
	public void setR43_1year_uae(BigDecimal r43_1year_uae) {
		this.r43_1year_uae = r43_1year_uae;
	}
	public BigDecimal getR43_6month_other_uae() {
		return r43_6month_other_uae;
	}
	public void setR43_6month_other_uae(BigDecimal r43_6month_other_uae) {
		this.r43_6month_other_uae = r43_6month_other_uae;
	}
	public BigDecimal getR43_12month_other_uae() {
		return r43_12month_other_uae;
	}
	public void setR43_12month_other_uae(BigDecimal r43_12month_other_uae) {
		this.r43_12month_other_uae = r43_12month_other_uae;
	}
	public BigDecimal getR43_1year_other_uae() {
		return r43_1year_other_uae;
	}
	public void setR43_1year_other_uae(BigDecimal r43_1year_other_uae) {
		this.r43_1year_other_uae = r43_1year_other_uae;
	}
	public BigDecimal getR43_6month_non_uae() {
		return r43_6month_non_uae;
	}
	public void setR43_6month_non_uae(BigDecimal r43_6month_non_uae) {
		this.r43_6month_non_uae = r43_6month_non_uae;
	}
	public BigDecimal getR43_12month_non_uae() {
		return r43_12month_non_uae;
	}
	public void setR43_12month_non_uae(BigDecimal r43_12month_non_uae) {
		this.r43_12month_non_uae = r43_12month_non_uae;
	}
	public BigDecimal getR43_1year_non_uae() {
		return r43_1year_non_uae;
	}
	public void setR43_1year_non_uae(BigDecimal r43_1year_non_uae) {
		this.r43_1year_non_uae = r43_1year_non_uae;
	}
	public BigDecimal getR43_6month_other_non_uae() {
		return r43_6month_other_non_uae;
	}
	public void setR43_6month_other_non_uae(BigDecimal r43_6month_other_non_uae) {
		this.r43_6month_other_non_uae = r43_6month_other_non_uae;
	}
	public BigDecimal getR43_12month_other_non_uae() {
		return r43_12month_other_non_uae;
	}
	public void setR43_12month_other_non_uae(BigDecimal r43_12month_other_non_uae) {
		this.r43_12month_other_non_uae = r43_12month_other_non_uae;
	}
	public BigDecimal getR43_1year_other_non_uae() {
		return r43_1year_other_non_uae;
	}
	public void setR43_1year_other_non_uae(BigDecimal r43_1year_other_non_uae) {
		this.r43_1year_other_non_uae = r43_1year_other_non_uae;
	}
	public BigDecimal getR43_total_libilities() {
		return r43_total_libilities;
	}
	public void setR43_total_libilities(BigDecimal r43_total_libilities) {
		this.r43_total_libilities = r43_total_libilities;
	}
	public BigDecimal getR43_total_spot() {
		return r43_total_spot;
	}
	public void setR43_total_spot(BigDecimal r43_total_spot) {
		this.r43_total_spot = r43_total_spot;
	}
	public String getR44_product() {
		return r44_product;
	}
	public void setR44_product(String r44_product) {
		this.r44_product = r44_product;
	}
	public BigDecimal getR44_6month_uae() {
		return r44_6month_uae;
	}
	public void setR44_6month_uae(BigDecimal r44_6month_uae) {
		this.r44_6month_uae = r44_6month_uae;
	}
	public BigDecimal getR44_12month_uae() {
		return r44_12month_uae;
	}
	public void setR44_12month_uae(BigDecimal r44_12month_uae) {
		this.r44_12month_uae = r44_12month_uae;
	}
	public BigDecimal getR44_1year_uae() {
		return r44_1year_uae;
	}
	public void setR44_1year_uae(BigDecimal r44_1year_uae) {
		this.r44_1year_uae = r44_1year_uae;
	}
	public BigDecimal getR44_6month_other_uae() {
		return r44_6month_other_uae;
	}
	public void setR44_6month_other_uae(BigDecimal r44_6month_other_uae) {
		this.r44_6month_other_uae = r44_6month_other_uae;
	}
	public BigDecimal getR44_12month_other_uae() {
		return r44_12month_other_uae;
	}
	public void setR44_12month_other_uae(BigDecimal r44_12month_other_uae) {
		this.r44_12month_other_uae = r44_12month_other_uae;
	}
	public BigDecimal getR44_1year_other_uae() {
		return r44_1year_other_uae;
	}
	public void setR44_1year_other_uae(BigDecimal r44_1year_other_uae) {
		this.r44_1year_other_uae = r44_1year_other_uae;
	}
	public BigDecimal getR44_6month_non_uae() {
		return r44_6month_non_uae;
	}
	public void setR44_6month_non_uae(BigDecimal r44_6month_non_uae) {
		this.r44_6month_non_uae = r44_6month_non_uae;
	}
	public BigDecimal getR44_12month_non_uae() {
		return r44_12month_non_uae;
	}
	public void setR44_12month_non_uae(BigDecimal r44_12month_non_uae) {
		this.r44_12month_non_uae = r44_12month_non_uae;
	}
	public BigDecimal getR44_1year_non_uae() {
		return r44_1year_non_uae;
	}
	public void setR44_1year_non_uae(BigDecimal r44_1year_non_uae) {
		this.r44_1year_non_uae = r44_1year_non_uae;
	}
	public BigDecimal getR44_6month_other_non_uae() {
		return r44_6month_other_non_uae;
	}
	public void setR44_6month_other_non_uae(BigDecimal r44_6month_other_non_uae) {
		this.r44_6month_other_non_uae = r44_6month_other_non_uae;
	}
	public BigDecimal getR44_12month_other_non_uae() {
		return r44_12month_other_non_uae;
	}
	public void setR44_12month_other_non_uae(BigDecimal r44_12month_other_non_uae) {
		this.r44_12month_other_non_uae = r44_12month_other_non_uae;
	}
	public BigDecimal getR44_1year_other_non_uae() {
		return r44_1year_other_non_uae;
	}
	public void setR44_1year_other_non_uae(BigDecimal r44_1year_other_non_uae) {
		this.r44_1year_other_non_uae = r44_1year_other_non_uae;
	}
	public BigDecimal getR44_total_libilities() {
		return r44_total_libilities;
	}
	public void setR44_total_libilities(BigDecimal r44_total_libilities) {
		this.r44_total_libilities = r44_total_libilities;
	}
	public BigDecimal getR44_total_spot() {
		return r44_total_spot;
	}
	public void setR44_total_spot(BigDecimal r44_total_spot) {
		this.r44_total_spot = r44_total_spot;
	}
	public String getR45_product() {
		return r45_product;
	}
	public void setR45_product(String r45_product) {
		this.r45_product = r45_product;
	}
	public BigDecimal getR45_6month_uae() {
		return r45_6month_uae;
	}
	public void setR45_6month_uae(BigDecimal r45_6month_uae) {
		this.r45_6month_uae = r45_6month_uae;
	}
	public BigDecimal getR45_12month_uae() {
		return r45_12month_uae;
	}
	public void setR45_12month_uae(BigDecimal r45_12month_uae) {
		this.r45_12month_uae = r45_12month_uae;
	}
	public BigDecimal getR45_1year_uae() {
		return r45_1year_uae;
	}
	public void setR45_1year_uae(BigDecimal r45_1year_uae) {
		this.r45_1year_uae = r45_1year_uae;
	}
	public BigDecimal getR45_6month_other_uae() {
		return r45_6month_other_uae;
	}
	public void setR45_6month_other_uae(BigDecimal r45_6month_other_uae) {
		this.r45_6month_other_uae = r45_6month_other_uae;
	}
	public BigDecimal getR45_12month_other_uae() {
		return r45_12month_other_uae;
	}
	public void setR45_12month_other_uae(BigDecimal r45_12month_other_uae) {
		this.r45_12month_other_uae = r45_12month_other_uae;
	}
	public BigDecimal getR45_1year_other_uae() {
		return r45_1year_other_uae;
	}
	public void setR45_1year_other_uae(BigDecimal r45_1year_other_uae) {
		this.r45_1year_other_uae = r45_1year_other_uae;
	}
	public BigDecimal getR45_6month_non_uae() {
		return r45_6month_non_uae;
	}
	public void setR45_6month_non_uae(BigDecimal r45_6month_non_uae) {
		this.r45_6month_non_uae = r45_6month_non_uae;
	}
	public BigDecimal getR45_12month_non_uae() {
		return r45_12month_non_uae;
	}
	public void setR45_12month_non_uae(BigDecimal r45_12month_non_uae) {
		this.r45_12month_non_uae = r45_12month_non_uae;
	}
	public BigDecimal getR45_1year_non_uae() {
		return r45_1year_non_uae;
	}
	public void setR45_1year_non_uae(BigDecimal r45_1year_non_uae) {
		this.r45_1year_non_uae = r45_1year_non_uae;
	}
	public BigDecimal getR45_6month_other_non_uae() {
		return r45_6month_other_non_uae;
	}
	public void setR45_6month_other_non_uae(BigDecimal r45_6month_other_non_uae) {
		this.r45_6month_other_non_uae = r45_6month_other_non_uae;
	}
	public BigDecimal getR45_12month_other_non_uae() {
		return r45_12month_other_non_uae;
	}
	public void setR45_12month_other_non_uae(BigDecimal r45_12month_other_non_uae) {
		this.r45_12month_other_non_uae = r45_12month_other_non_uae;
	}
	public BigDecimal getR45_1year_other_non_uae() {
		return r45_1year_other_non_uae;
	}
	public void setR45_1year_other_non_uae(BigDecimal r45_1year_other_non_uae) {
		this.r45_1year_other_non_uae = r45_1year_other_non_uae;
	}
	public BigDecimal getR45_total_libilities() {
		return r45_total_libilities;
	}
	public void setR45_total_libilities(BigDecimal r45_total_libilities) {
		this.r45_total_libilities = r45_total_libilities;
	}
	public BigDecimal getR45_total_spot() {
		return r45_total_spot;
	}
	public void setR45_total_spot(BigDecimal r45_total_spot) {
		this.r45_total_spot = r45_total_spot;
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
	public BRF10_ENTITY() {
		super();
		// TODO Auto-generated constructor stub
	}
}