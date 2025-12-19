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
@Table(name="CR4A_T1")
public class BASEL_8_ENTITY1 {
	private String	r9_product;
	private String	r9_risk_weight;
	private BigDecimal	r9_total_exposure;
	private String	r10_product;
	private String	r10_risk_weight;
	private BigDecimal	r10_total_exposure;
	private String	r11_product;
	private String	r11_risk_weight;
	private BigDecimal	r11_total_exposure;
	private String	r12_product;
	private String	r12_risk_weight;
	private BigDecimal	r12_total_exposure;
	private String	r13_product;
	private String	r13_risk_weight;
	private BigDecimal	r13_total_exposure;
	private String	r14_product;
	private String	r14_risk_weight;
	private BigDecimal	r14_total_exposure_0;
	private String	r15_risk_weight;
	private BigDecimal	r15_total_exposure_20;
	private String	r16_risk_weight;
	private BigDecimal	r16_total_exposure_50;
	private String	r17_risk_weight;
	private BigDecimal	r17_total_exposure_100;
	private String	r18_risk_weight;
	private BigDecimal	r18_total_exposure_150;
	private String	r19_risk_weight;
	private BigDecimal	r19_total_exposure_100;
	private String	r20_sub_total;
	private BigDecimal	r20_total_exposure;
	private String	r21_product;
	private String	r21_risk_weight;
	private BigDecimal	r21_total_exposure_0;
	private String	r22_product;
	private String	r22_risk_weight;
	private BigDecimal	r22_total_exposure_0;
	private String	r23_risk_weight;
	private BigDecimal	r23_total_exposure_20;
	private BigDecimal	r23_cash_1;
	private BigDecimal	r23_sovereign_2;
	private BigDecimal	r23_others_3;
	private BigDecimal	r23_sovereign_4;
	private BigDecimal	r23_others_5;
	private BigDecimal	r23_sovereign_6;
	private BigDecimal	r23_others_7;
	private BigDecimal	r23_sovereign_8;
	private BigDecimal	r23_others_9;
	private BigDecimal	r23_sovereign_10;
	private BigDecimal	r23_others_11;
	private BigDecimal	r23_sovereign_12;
	private BigDecimal	r23_others_13;
	private BigDecimal	r23_rated_14;
	private BigDecimal	r23_main_index_15;
	private BigDecimal	r23_other_equities_16;
	private BigDecimal	r23_mutual_funds_17;
	private BigDecimal	r23_total_collateral_19;
	private BigDecimal	r23_net_collateral_20;
	private BigDecimal	r23_net_collateral_21;
	private String	r24_risk_weight;
	private BigDecimal	r24_total_exposure_50;
	private BigDecimal	r24_cash_1;
	private BigDecimal	r24_sovereign_2;
	private BigDecimal	r24_others_3;
	private BigDecimal	r24_sovereign_4;
	private BigDecimal	r24_others_5;
	private BigDecimal	r24_sovereign_6;
	private BigDecimal	r24_others_7;
	private BigDecimal	r24_sovereign_8;
	private BigDecimal	r24_others_9;
	private BigDecimal	r24_sovereign_10;
	private BigDecimal	r24_others_11;
	private BigDecimal	r24_sovereign_12;
	private BigDecimal	r24_others_13;
	private BigDecimal	r24_rated_14;
	private BigDecimal	r24_main_index_15;
	private BigDecimal	r24_other_equities_16;
	private BigDecimal	r24_mutual_funds_17;
	private BigDecimal	r24_total_collateral_19;
	private BigDecimal	r24_net_collateral_20;
	private BigDecimal	r24_net_collateral_21;
	private String	r25_risk_weight;
	private BigDecimal	r25_total_exposure_100;
	private BigDecimal	r25_cash_1;
	private BigDecimal	r25_sovereign_2;
	private BigDecimal	r25_others_3;
	private BigDecimal	r25_sovereign_4;
	private BigDecimal	r25_others_5;
	private BigDecimal	r25_sovereign_6;
	private BigDecimal	r25_others_7;
	private BigDecimal	r25_sovereign_8;
	private BigDecimal	r25_others_9;
	private BigDecimal	r25_sovereign_10;
	private BigDecimal	r25_others_11;
	private BigDecimal	r25_sovereign_12;
	private BigDecimal	r25_others_13;
	private BigDecimal	r25_rated_14;
	private BigDecimal	r25_main_index_15;
	private BigDecimal	r25_other_equities_16;
	private BigDecimal	r25_mutual_funds_17;
	private BigDecimal	r25_total_collateral_19;
	private BigDecimal	r25_net_collateral_20;
	private BigDecimal	r25_net_collateral_21;
	private String	r26_risk_weight;
	private BigDecimal	r26_total_exposure_150;
	private BigDecimal	r26_cash_1;
	private BigDecimal	r26_sovereign_2;
	private BigDecimal	r26_others_3;
	private BigDecimal	r26_sovereign_4;
	private BigDecimal	r26_others_5;
	private BigDecimal	r26_sovereign_6;
	private BigDecimal	r26_others_7;
	private BigDecimal	r26_sovereign_8;
	private BigDecimal	r26_others_9;
	private BigDecimal	r26_sovereign_10;
	private BigDecimal	r26_others_11;
	private BigDecimal	r26_sovereign_12;
	private BigDecimal	r26_others_13;
	private BigDecimal	r26_rated_14;
	private BigDecimal	r26_main_index_15;
	private BigDecimal	r26_other_equities_16;
	private BigDecimal	r26_mutual_funds_17;
	private BigDecimal	r26_total_collateral_19;
	private BigDecimal	r26_net_collateral_20;
	private BigDecimal	r26_net_collateral_21;
	private String	r27_risk_weight;
	private BigDecimal	r27_total_exposure_100;
	private BigDecimal	r27_cash_1;
	private BigDecimal	r27_sovereign_2;
	private BigDecimal	r27_others_3;
	private BigDecimal	r27_sovereign_4;
	private BigDecimal	r27_others_5;
	private BigDecimal	r27_sovereign_6;
	private BigDecimal	r27_others_7;
	private BigDecimal	r27_sovereign_8;
	private BigDecimal	r27_others_9;
	private BigDecimal	r27_sovereign_10;
	private BigDecimal	r27_others_11;
	private BigDecimal	r27_sovereign_12;
	private BigDecimal	r27_others_13;
	private BigDecimal	r27_rated_14;
	private BigDecimal	r27_main_index_15;
	private BigDecimal	r27_other_equities_16;
	private BigDecimal	r27_mutual_funds_17;
	private BigDecimal	r27_total_collateral_19;
	private BigDecimal	r27_net_collateral_20;
	private BigDecimal	r27_net_collateral_21;
	private String	r28_product;
	private String	r28_risk_weight;
	private BigDecimal	r28_total_exposure_0;
	private String	r29_risk_weight;
	private BigDecimal	r29_total_exposure_20;
	private BigDecimal	r29_cash_1;
	private BigDecimal	r29_sovereign_2;
	private BigDecimal	r29_others_3;
	private BigDecimal	r29_sovereign_4;
	private BigDecimal	r29_others_5;
	private BigDecimal	r29_sovereign_6;
	private BigDecimal	r29_others_7;
	private BigDecimal	r29_sovereign_8;
	private BigDecimal	r29_others_9;
	private BigDecimal	r29_sovereign_10;
	private BigDecimal	r29_others_11;
	private BigDecimal	r29_sovereign_12;
	private BigDecimal	r29_others_13;
	private BigDecimal	r29_rated_14;
	private BigDecimal	r29_main_index_15;
	private BigDecimal	r29_other_equities_16;
	private BigDecimal	r29_mutual_funds_17;
	private BigDecimal	r29_total_collateral_19;
	private BigDecimal	r29_net_collateral_20;
	private BigDecimal	r29_net_collateral_21;
	private String	r30_risk_weight;
	private BigDecimal	r30_total_exposure_50;
	private BigDecimal	r30_cash_1;
	private BigDecimal	r30_sovereign_2;
	private BigDecimal	r30_others_3;
	private BigDecimal	r30_sovereign_4;
	private BigDecimal	r30_others_5;
	private BigDecimal	r30_sovereign_6;
	private BigDecimal	r30_others_7;
	private BigDecimal	r30_sovereign_8;
	private BigDecimal	r30_others_9;
	private BigDecimal	r30_sovereign_10;
	private BigDecimal	r30_others_11;
	private BigDecimal	r30_sovereign_12;
	private BigDecimal	r30_others_13;
	private BigDecimal	r30_rated_14;
	private BigDecimal	r30_main_index_15;
	private BigDecimal	r30_other_equities_16;
	private BigDecimal	r30_mutual_funds_17;
	private BigDecimal	r30_total_collateral_19;
	private BigDecimal	r30_net_collateral_20;
	private BigDecimal	r30_net_collateral_21;
	private String	r31_risk_weight;
	private BigDecimal	r31_total_exposure_100;
	private BigDecimal	r31_cash_1;
	private BigDecimal	r31_sovereign_2;
	private BigDecimal	r31_others_3;
	private BigDecimal	r31_sovereign_4;
	private BigDecimal	r31_others_5;
	private BigDecimal	r31_sovereign_6;
	private BigDecimal	r31_others_7;
	private BigDecimal	r31_sovereign_8;
	private BigDecimal	r31_others_9;
	private BigDecimal	r31_sovereign_10;
	private BigDecimal	r31_others_11;
	private BigDecimal	r31_sovereign_12;
	private BigDecimal	r31_others_13;
	private BigDecimal	r31_rated_14;
	private BigDecimal	r31_main_index_15;
	private BigDecimal	r31_other_equities_16;
	private BigDecimal	r31_mutual_funds_17;
	private BigDecimal	r31_total_collateral_19;
	private BigDecimal	r31_net_collateral_20;
	private BigDecimal	r31_net_collateral_21;
	private String	r32_risk_weight;
	private BigDecimal	r32_total_exposure_150;
	private BigDecimal	r32_cash_1;
	private BigDecimal	r32_sovereign_2;
	private BigDecimal	r32_others_3;
	private BigDecimal	r32_sovereign_4;
	private BigDecimal	r32_others_5;
	private BigDecimal	r32_sovereign_6;
	private BigDecimal	r32_others_7;
	private BigDecimal	r32_sovereign_8;
	private BigDecimal	r32_others_9;
	private BigDecimal	r32_sovereign_10;
	private BigDecimal	r32_others_11;
	private BigDecimal	r32_sovereign_12;
	private BigDecimal	r32_others_13;
	private BigDecimal	r32_rated_14;
	private BigDecimal	r32_main_index_15;
	private BigDecimal	r32_other_equities_16;
	private BigDecimal	r32_mutual_funds_17;
	private BigDecimal	r32_total_collateral_19;
	private BigDecimal	r32_net_collateral_20;
	private BigDecimal	r32_net_collateral_21;
	private String	r33_risk_weight;
	private BigDecimal	r33_total_exposure_100;
	private BigDecimal	r33_cash_1;
	private BigDecimal	r33_sovereign_2;
	private BigDecimal	r33_others_3;
	private BigDecimal	r33_sovereign_4;
	private BigDecimal	r33_others_5;
	private BigDecimal	r33_sovereign_6;
	private BigDecimal	r33_others_7;
	private BigDecimal	r33_sovereign_8;
	private BigDecimal	r33_others_9;
	private BigDecimal	r33_sovereign_10;
	private BigDecimal	r33_others_11;
	private BigDecimal	r33_sovereign_12;
	private BigDecimal	r33_others_13;
	private BigDecimal	r33_rated_14;
	private BigDecimal	r33_main_index_15;
	private BigDecimal	r33_other_equities_16;
	private BigDecimal	r33_mutual_funds_17;
	private BigDecimal	r33_total_collateral_19;
	private BigDecimal	r33_net_collateral_20;
	private BigDecimal	r33_net_collateral_21;
	private String	r34_sub_total;
	private BigDecimal	r34_total_exposure;
	private BigDecimal	r34_cash_1;
	private BigDecimal	r34_sovereign_2;
	private BigDecimal	r34_others_3;
	private BigDecimal	r34_sovereign_4;
	private BigDecimal	r34_others_5;
	private BigDecimal	r34_sovereign_6;
	private BigDecimal	r34_others_7;
	private BigDecimal	r34_sovereign_8;
	private BigDecimal	r34_others_9;
	private BigDecimal	r34_sovereign_10;
	private BigDecimal	r34_others_11;
	private BigDecimal	r34_sovereign_12;
	private BigDecimal	r34_others_13;
	private BigDecimal	r34_rated_14;
	private BigDecimal	r34_main_index_15;
	private BigDecimal	r34_other_equities_16;
	private BigDecimal	r34_mutual_funds_17;
	private BigDecimal	r34_total_collateral_19;
	private BigDecimal	r34_net_collateral_20;
	private BigDecimal	r34_net_collateral_21;
	private String	r35_total_sovereign;
	private BigDecimal	r35_total_exposure;
	private BigDecimal	r35_cash_1;
	private BigDecimal	r35_sovereign_2;
	private BigDecimal	r35_others_3;
	private BigDecimal	r35_sovereign_4;
	private BigDecimal	r35_others_5;
	private BigDecimal	r35_sovereign_6;
	private BigDecimal	r35_others_7;
	private BigDecimal	r35_sovereign_8;
	private BigDecimal	r35_others_9;
	private BigDecimal	r35_sovereign_10;
	private BigDecimal	r35_others_11;
	private BigDecimal	r35_sovereign_12;
	private BigDecimal	r35_others_13;
	private BigDecimal	r35_rated_14;
	private BigDecimal	r35_main_index_15;
	private BigDecimal	r35_other_equities_16;
	private BigDecimal	r35_mutual_funds_17;
	private BigDecimal	r35_total_collateral_19;
	private BigDecimal	r35_net_collateral_20;
	private BigDecimal	r35_net_collateral_21;
	private String	r36_product;
	private String	r36_risk_weight;
	private BigDecimal	r36_total_exposure_0;
	private String	r37_risk_weight;
	private BigDecimal	r37_total_exposure_20;
	private BigDecimal	r37_cash_1;
	private BigDecimal	r37_sovereign_2;
	private BigDecimal	r37_others_3;
	private BigDecimal	r37_sovereign_4;
	private BigDecimal	r37_others_5;
	private BigDecimal	r37_sovereign_6;
	private BigDecimal	r37_others_7;
	private BigDecimal	r37_sovereign_8;
	private BigDecimal	r37_others_9;
	private BigDecimal	r37_sovereign_10;
	private BigDecimal	r37_others_11;
	private BigDecimal	r37_sovereign_12;
	private BigDecimal	r37_others_13;
	private BigDecimal	r37_rated_14;
	private BigDecimal	r37_main_index_15;
	private BigDecimal	r37_other_equities_16;
	private BigDecimal	r37_mutual_funds_17;
	private BigDecimal	r37_other_national_18;
	private BigDecimal	r37_total_collateral_19;
	private BigDecimal	r37_net_collateral_20;
	private BigDecimal	r37_net_collateral_21;
	private String	r38_risk_weight;
	private BigDecimal	r38_total_exposure_50;
	private BigDecimal	r38_cash_1;
	private BigDecimal	r38_sovereign_2;
	private BigDecimal	r38_others_3;
	private BigDecimal	r38_sovereign_4;
	private BigDecimal	r38_others_5;
	private BigDecimal	r38_sovereign_6;
	private BigDecimal	r38_others_7;
	private BigDecimal	r38_sovereign_8;
	private BigDecimal	r38_others_9;
	private BigDecimal	r38_sovereign_10;
	private BigDecimal	r38_others_11;
	private BigDecimal	r38_sovereign_12;
	private BigDecimal	r38_others_13;
	private BigDecimal	r38_rated_14;
	private BigDecimal	r38_main_index_15;
	private BigDecimal	r38_other_equities_16;
	private BigDecimal	r38_mutual_funds_17;
	private BigDecimal	r38_other_national_18;
	private BigDecimal	r38_total_collateral_19;
	private BigDecimal	r38_net_collateral_20;
	private BigDecimal	r38_net_collateral_21;
	private String	r39_risk_weight;
	private BigDecimal	r39_total_exposure_100;
	private BigDecimal	r39_cash_1;
	private BigDecimal	r39_sovereign_2;
	private BigDecimal	r39_others_3;
	private BigDecimal	r39_sovereign_4;
	private BigDecimal	r39_others_5;
	private BigDecimal	r39_sovereign_6;
	private BigDecimal	r39_others_7;
	private BigDecimal	r39_sovereign_8;
	private BigDecimal	r39_others_9;
	private BigDecimal	r39_sovereign_10;
	private BigDecimal	r39_others_11;
	private BigDecimal	r39_sovereign_12;
	private BigDecimal	r39_others_13;
	private BigDecimal	r39_rated_14;
	private BigDecimal	r39_main_index_15;
	private BigDecimal	r39_other_equities_16;
	private BigDecimal	r39_mutual_funds_17;
	private BigDecimal	r39_other_national_18;
	private BigDecimal	r39_total_collateral_19;
	private BigDecimal	r39_net_collateral_20;
	private BigDecimal	r39_net_collateral_21;
	private String	r40_risk_weight;
	private BigDecimal	r40_total_exposure_100;
	private BigDecimal	r40_cash_1;
	private BigDecimal	r40_sovereign_2;
	private BigDecimal	r40_others_3;
	private BigDecimal	r40_sovereign_4;
	private BigDecimal	r40_others_5;
	private BigDecimal	r40_sovereign_6;
	private BigDecimal	r40_others_7;
	private BigDecimal	r40_sovereign_8;
	private BigDecimal	r40_others_9;
	private BigDecimal	r40_sovereign_10;
	private BigDecimal	r40_others_11;
	private BigDecimal	r40_sovereign_12;
	private BigDecimal	r40_others_13;
	private BigDecimal	r40_rated_14;
	private BigDecimal	r40_main_index_15;
	private BigDecimal	r40_other_equities_16;
	private BigDecimal	r40_mutual_funds_17;
	private BigDecimal	r40_other_national_18;
	private BigDecimal	r40_total_collateral_19;
	private BigDecimal	r40_net_collateral_20;
	private BigDecimal	r40_net_collateral_21;
	private String	r41_risk_weight;
	private BigDecimal	r41_total_exposure_100;
	private BigDecimal	r41_cash_1;
	private BigDecimal	r41_sovereign_2;
	private BigDecimal	r41_others_3;
	private BigDecimal	r41_sovereign_4;
	private BigDecimal	r41_others_5;
	private BigDecimal	r41_sovereign_6;
	private BigDecimal	r41_others_7;
	private BigDecimal	r41_sovereign_8;
	private BigDecimal	r41_others_9;
	private BigDecimal	r41_sovereign_10;
	private BigDecimal	r41_others_11;
	private BigDecimal	r41_sovereign_12;
	private BigDecimal	r41_others_13;
	private BigDecimal	r41_rated_14;
	private BigDecimal	r41_main_index_15;
	private BigDecimal	r41_other_equities_16;
	private BigDecimal	r41_mutual_funds_17;
	private BigDecimal	r41_other_national_18;
	private BigDecimal	r41_total_collateral_19;
	private BigDecimal	r41_net_collateral_20;
	private BigDecimal	r41_net_collateral_21;
	private String	r42_sub_total;
	private BigDecimal	r42_total_exposure;
	private BigDecimal	r42_cash_1;
	private BigDecimal	r42_sovereign_2;
	private BigDecimal	r42_others_3;
	private BigDecimal	r42_sovereign_4;
	private BigDecimal	r42_others_5;
	private BigDecimal	r42_sovereign_6;
	private BigDecimal	r42_others_7;
	private BigDecimal	r42_sovereign_8;
	private BigDecimal	r42_others_9;
	private BigDecimal	r42_sovereign_10;
	private BigDecimal	r42_others_11;
	private BigDecimal	r42_sovereign_12;
	private BigDecimal	r42_others_13;
	private BigDecimal	r42_rated_14;
	private BigDecimal	r42_main_index_15;
	private BigDecimal	r42_other_equities_16;
	private BigDecimal	r42_mutual_funds_17;
	private BigDecimal	r42_other_national_18;
	private BigDecimal	r42_total_collateral_19;
	private BigDecimal	r42_net_collateral_20;
	private BigDecimal	r42_net_collateral_21;
	private String	r43_product;
	private String	r43_risk_weight;
	private BigDecimal	r43_total_exposure_0;
	private String	r44_risk_weight;
	private BigDecimal	r44_total_exposure_20;
	private BigDecimal	r44_cash_1;
	private BigDecimal	r44_sovereign_2;
	private BigDecimal	r44_others_3;
	private BigDecimal	r44_sovereign_4;
	private BigDecimal	r44_others_5;
	private BigDecimal	r44_sovereign_6;
	private BigDecimal	r44_others_7;
	private BigDecimal	r44_sovereign_8;
	private BigDecimal	r44_others_9;
	private BigDecimal	r44_sovereign_10;
	private BigDecimal	r44_others_11;
	private BigDecimal	r44_sovereign_12;
	private BigDecimal	r44_others_13;
	private BigDecimal	r44_rated_14;
	private BigDecimal	r44_main_index_15;
	private BigDecimal	r44_other_equities_16;
	private BigDecimal	r44_mutual_funds_17;
	private BigDecimal	r44_other_national_18;
	private BigDecimal	r44_total_collateral_19;
	private BigDecimal	r44_net_collateral_20;
	private BigDecimal	r44_net_collateral_21;
	private String	r45_risk_weight;
	private BigDecimal	r45_total_exposure_50;
	private BigDecimal	r45_cash_1;
	private BigDecimal	r45_sovereign_2;
	private BigDecimal	r45_others_3;
	private BigDecimal	r45_sovereign_4;
	private BigDecimal	r45_others_5;
	private BigDecimal	r45_sovereign_6;
	private BigDecimal	r45_others_7;
	private BigDecimal	r45_sovereign_8;
	private BigDecimal	r45_others_9;
	private BigDecimal	r45_sovereign_10;
	private BigDecimal	r45_others_11;
	private BigDecimal	r45_sovereign_12;
	private BigDecimal	r45_others_13;
	private BigDecimal	r45_rated_14;
	private BigDecimal	r45_main_index_15;
	private BigDecimal	r45_other_equities_16;
	private BigDecimal	r45_mutual_funds_17;
	private BigDecimal	r45_other_national_18;
	private BigDecimal	r45_total_collateral_19;
	private BigDecimal	r45_net_collateral_20;
	private BigDecimal	r45_net_collateral_21;
	private String	r46_risk_weight;
	private BigDecimal	r46_total_exposure_100;
	private BigDecimal	r46_cash_1;
	private BigDecimal	r46_sovereign_2;
	private BigDecimal	r46_others_3;
	private BigDecimal	r46_sovereign_4;
	private BigDecimal	r46_others_5;
	private BigDecimal	r46_sovereign_6;
	private BigDecimal	r46_others_7;
	private BigDecimal	r46_sovereign_8;
	private BigDecimal	r46_others_9;
	private BigDecimal	r46_sovereign_10;
	private BigDecimal	r46_others_11;
	private BigDecimal	r46_sovereign_12;
	private BigDecimal	r46_others_13;
	private BigDecimal	r46_rated_14;
	private BigDecimal	r46_main_index_15;
	private BigDecimal	r46_other_equities_16;
	private BigDecimal	r46_mutual_funds_17;
	private BigDecimal	r46_other_national_18;
	private BigDecimal	r46_total_collateral_19;
	private BigDecimal	r46_net_collateral_20;
	private BigDecimal	r46_net_collateral_21;
	private String	r47_risk_weight;
	private BigDecimal	r47_total_exposure_150;
	private BigDecimal	r47_cash_1;
	private BigDecimal	r47_sovereign_2;
	private BigDecimal	r47_others_3;
	private BigDecimal	r47_sovereign_4;
	private BigDecimal	r47_others_5;
	private BigDecimal	r47_sovereign_6;
	private BigDecimal	r47_others_7;
	private BigDecimal	r47_sovereign_8;
	private BigDecimal	r47_others_9;
	private BigDecimal	r47_sovereign_10;
	private BigDecimal	r47_others_11;
	private BigDecimal	r47_sovereign_12;
	private BigDecimal	r47_others_13;
	private BigDecimal	r47_rated_14;
	private BigDecimal	r47_main_index_15;
	private BigDecimal	r47_other_equities_16;
	private BigDecimal	r47_mutual_funds_17;
	private BigDecimal	r47_other_national_18;
	private BigDecimal	r47_total_collateral_19;
	private BigDecimal	r47_net_collateral_20;
	private BigDecimal	r47_net_collateral_21;
	private String	r48_risk_weight;
	private BigDecimal	r48_total_exposure_50;
	private BigDecimal	r48_cash_1;
	private BigDecimal	r48_sovereign_2;
	private BigDecimal	r48_others_3;
	private BigDecimal	r48_sovereign_4;
	private BigDecimal	r48_others_5;
	private BigDecimal	r48_sovereign_6;
	private BigDecimal	r48_others_7;
	private BigDecimal	r48_sovereign_8;
	private BigDecimal	r48_others_9;
	private BigDecimal	r48_sovereign_10;
	private BigDecimal	r48_others_11;
	private BigDecimal	r48_sovereign_12;
	private BigDecimal	r48_others_13;
	private BigDecimal	r48_rated_14;
	private BigDecimal	r48_main_index_15;
	private BigDecimal	r48_other_equities_16;
	private BigDecimal	r48_mutual_funds_17;
	private BigDecimal	r48_other_national_18;
	private BigDecimal	r48_total_collateral_19;
	private BigDecimal	r48_net_collateral_20;
	private BigDecimal	r48_net_collateral_21;
	private String	r49_sub_total;
	private BigDecimal	r49_total_exposure;
	private BigDecimal	r49_cash_1;
	private BigDecimal	r49_sovereign_2;
	private BigDecimal	r49_others_3;
	private BigDecimal	r49_sovereign_4;
	private BigDecimal	r49_others_5;
	private BigDecimal	r49_sovereign_6;
	private BigDecimal	r49_others_7;
	private BigDecimal	r49_sovereign_8;
	private BigDecimal	r49_others_9;
	private BigDecimal	r49_sovereign_10;
	private BigDecimal	r49_others_11;
	private BigDecimal	r49_sovereign_12;
	private BigDecimal	r49_others_13;
	private BigDecimal	r49_rated_14;
	private BigDecimal	r49_main_index_15;
	private BigDecimal	r49_other_equities_16;
	private BigDecimal	r49_mutual_funds_17;
	private BigDecimal	r49_other_national_18;
	private BigDecimal	r49_total_collateral_19;
	private BigDecimal	r49_net_collateral_20;
	private BigDecimal	r49_net_collateral_21;
	private String	r50_product;
	private String	r50_risk_weight;
	private BigDecimal	r50_total_exposure_0;
	private String	r51_risk_weight;
	private BigDecimal	r51_total_exposure_20;
	private BigDecimal	r51_cash_1;
	private BigDecimal	r51_sovereign_2;
	private BigDecimal	r51_others_3;
	private BigDecimal	r51_sovereign_4;
	private BigDecimal	r51_others_5;
	private BigDecimal	r51_sovereign_6;
	private BigDecimal	r51_others_7;
	private BigDecimal	r51_sovereign_8;
	private BigDecimal	r51_others_9;
	private BigDecimal	r51_sovereign_10;
	private BigDecimal	r51_others_11;
	private BigDecimal	r51_sovereign_12;
	private BigDecimal	r51_others_13;
	private BigDecimal	r51_rated_14;
	private BigDecimal	r51_main_index_15;
	private BigDecimal	r51_other_equities_16;
	private BigDecimal	r51_mutual_funds_17;
	private BigDecimal	r51_total_collateral_19;
	private BigDecimal	r51_net_collateral_20;
	private BigDecimal	r51_net_collateral_21;
	private String	r52_risk_weight;
	private BigDecimal	r52_total_exposure_50;
	private BigDecimal	r52_cash_1;
	private BigDecimal	r52_sovereign_2;
	private BigDecimal	r52_others_3;
	private BigDecimal	r52_sovereign_4;
	private BigDecimal	r52_others_5;
	private BigDecimal	r52_sovereign_6;
	private BigDecimal	r52_others_7;
	private BigDecimal	r52_sovereign_8;
	private BigDecimal	r52_others_9;
	private BigDecimal	r52_sovereign_10;
	private BigDecimal	r52_others_11;
	private BigDecimal	r52_sovereign_12;
	private BigDecimal	r52_others_13;
	private BigDecimal	r52_rated_14;
	private BigDecimal	r52_main_index_15;
	private BigDecimal	r52_other_equities_16;
	private BigDecimal	r52_mutual_funds_17;
	private BigDecimal	r52_total_collateral_19;
	private BigDecimal	r52_net_collateral_20;
	private BigDecimal	r52_net_collateral_21;
	private String	r53_risk_weight;
	private BigDecimal	r53_total_exposure_100;
	private BigDecimal	r53_cash_1;
	private BigDecimal	r53_sovereign_2;
	private BigDecimal	r53_others_3;
	private BigDecimal	r53_sovereign_4;
	private BigDecimal	r53_others_5;
	private BigDecimal	r53_sovereign_6;
	private BigDecimal	r53_others_7;
	private BigDecimal	r53_sovereign_8;
	private BigDecimal	r53_others_9;
	private BigDecimal	r53_sovereign_10;
	private BigDecimal	r53_others_11;
	private BigDecimal	r53_sovereign_12;
	private BigDecimal	r53_others_13;
	private BigDecimal	r53_rated_14;
	private BigDecimal	r53_main_index_15;
	private BigDecimal	r53_other_equities_16;
	private BigDecimal	r53_mutual_funds_17;
	private BigDecimal	r53_total_collateral_19;
	private BigDecimal	r53_net_collateral_20;
	private BigDecimal	r53_net_collateral_21;
	private String	r54_risk_weight;
	private BigDecimal	r54_total_exposure_150;
	private BigDecimal	r54_cash_1;
	private BigDecimal	r54_sovereign_2;
	private BigDecimal	r54_others_3;
	private BigDecimal	r54_sovereign_4;
	private BigDecimal	r54_others_5;
	private BigDecimal	r54_sovereign_6;
	private BigDecimal	r54_others_7;
	private BigDecimal	r54_sovereign_8;
	private BigDecimal	r54_others_9;
	private BigDecimal	r54_sovereign_10;
	private BigDecimal	r54_others_11;
	private BigDecimal	r54_sovereign_12;
	private BigDecimal	r54_others_13;
	private BigDecimal	r54_rated_14;
	private BigDecimal	r54_main_index_15;
	private BigDecimal	r54_other_equities_16;
	private BigDecimal	r54_mutual_funds_17;
	private BigDecimal	r54_total_collateral_19;
	private BigDecimal	r54_net_collateral_20;
	private BigDecimal	r54_net_collateral_21;
	private String	r55_risk_weight;
	private BigDecimal	r55_total_exposure_100;
	private BigDecimal	r55_cash_1;
	private BigDecimal	r55_sovereign_2;
	private BigDecimal	r55_others_3;
	private BigDecimal	r55_sovereign_4;
	private BigDecimal	r55_others_5;
	private BigDecimal	r55_sovereign_6;
	private BigDecimal	r55_others_7;
	private BigDecimal	r55_sovereign_8;
	private BigDecimal	r55_others_9;
	private BigDecimal	r55_sovereign_10;
	private BigDecimal	r55_others_11;
	private BigDecimal	r55_sovereign_12;
	private BigDecimal	r55_others_13;
	private BigDecimal	r55_rated_14;
	private BigDecimal	r55_main_index_15;
	private BigDecimal	r55_other_equities_16;
	private BigDecimal	r55_mutual_funds_17;
	private BigDecimal	r55_total_collateral_19;
	private BigDecimal	r55_net_collateral_20;
	private BigDecimal	r55_net_collateral_21;
	private String	r56_product;
	private String	r56_risk_weight;
	private BigDecimal	r56_total_exposure_100;
	private BigDecimal	r56_cash_1;
	private BigDecimal	r56_sovereign_2;
	private BigDecimal	r56_others_3;
	private BigDecimal	r56_sovereign_4;
	private BigDecimal	r56_others_5;
	private BigDecimal	r56_sovereign_6;
	private BigDecimal	r56_others_7;
	private BigDecimal	r56_sovereign_8;
	private BigDecimal	r56_others_9;
	private BigDecimal	r56_sovereign_10;
	private BigDecimal	r56_others_11;
	private BigDecimal	r56_sovereign_12;
	private BigDecimal	r56_others_13;
	private BigDecimal	r56_rated_14;
	private BigDecimal	r56_main_index_15;
	private BigDecimal	r56_other_equities_16;
	private BigDecimal	r56_mutual_funds_17;
	private BigDecimal	r56_total_collateral_19;
	private BigDecimal	r56_net_collateral_20;
	private BigDecimal	r56_net_collateral_21;
	private String	r57_sub_total;
	private BigDecimal	r57_total_exposure;
	private BigDecimal	r57_cash_1;
	private BigDecimal	r57_sovereign_2;
	private BigDecimal	r57_others_3;
	private BigDecimal	r57_sovereign_4;
	private BigDecimal	r57_others_5;
	private BigDecimal	r57_sovereign_6;
	private BigDecimal	r57_others_7;
	private BigDecimal	r57_sovereign_8;
	private BigDecimal	r57_others_9;
	private BigDecimal	r57_sovereign_10;
	private BigDecimal	r57_others_11;
	private BigDecimal	r57_sovereign_12;
	private BigDecimal	r57_others_13;
	private BigDecimal	r57_rated_14;
	private BigDecimal	r57_main_index_15;
	private BigDecimal	r57_other_equities_16;
	private BigDecimal	r57_mutual_funds_17;
	private BigDecimal	r57_total_collateral_19;
	private BigDecimal	r57_net_collateral_20;
	private BigDecimal	r57_net_collateral_21;
	private String	r58_total;
	private BigDecimal	r58_total_exposure;
	private BigDecimal	r58_cash_1;
	private BigDecimal	r58_sovereign_2;
	private BigDecimal	r58_others_3;
	private BigDecimal	r58_sovereign_4;
	private BigDecimal	r58_others_5;
	private BigDecimal	r58_sovereign_6;
	private BigDecimal	r58_others_7;
	private BigDecimal	r58_sovereign_8;
	private BigDecimal	r58_others_9;
	private BigDecimal	r58_sovereign_10;
	private BigDecimal	r58_others_11;
	private BigDecimal	r58_sovereign_12;
	private BigDecimal	r58_others_13;
	private BigDecimal	r58_rated_14;
	private BigDecimal	r58_main_index_15;
	private BigDecimal	r58_other_equities_16;
	private BigDecimal	r58_mutual_funds_17;
	private BigDecimal	r58_total_collateral_19;
	private BigDecimal	r58_net_collateral_20;
	private BigDecimal	r58_net_collateral_21;
	private String	r59_product;
	private String	r59_risk_weight;
	private BigDecimal	r59_total_exposure_0;
	private String	r60_product;
	private String	r61_risk_weight;
	private BigDecimal	r61_total_exposure_0;
	private String	r62_risk_weight;
	private BigDecimal	r62_total_exposure_20;
	private BigDecimal	r62_cash_1;
	private BigDecimal	r62_sovereign_2;
	private BigDecimal	r62_others_3;
	private BigDecimal	r62_sovereign_4;
	private BigDecimal	r62_others_5;
	private BigDecimal	r62_sovereign_6;
	private BigDecimal	r62_others_7;
	private BigDecimal	r62_sovereign_8;
	private BigDecimal	r62_others_9;
	private BigDecimal	r62_sovereign_10;
	private BigDecimal	r62_others_11;
	private BigDecimal	r62_sovereign_12;
	private BigDecimal	r62_others_13;
	private BigDecimal	r62_rated_14;
	private BigDecimal	r62_main_index_15;
	private BigDecimal	r62_other_equities_16;
	private BigDecimal	r62_mutual_funds_17;
	private BigDecimal	r62_total_collateral_19;
	private BigDecimal	r62_net_collateral_20;
	private BigDecimal	r62_net_collateral_21;
	private String	r63_risk_weight;
	private BigDecimal	r63_total_exposure_50;
	private BigDecimal	r63_cash_1;
	private BigDecimal	r63_sovereign_2;
	private BigDecimal	r63_others_3;
	private BigDecimal	r63_sovereign_4;
	private BigDecimal	r63_others_5;
	private BigDecimal	r63_sovereign_6;
	private BigDecimal	r63_others_7;
	private BigDecimal	r63_sovereign_8;
	private BigDecimal	r63_others_9;
	private BigDecimal	r63_sovereign_10;
	private BigDecimal	r63_others_11;
	private BigDecimal	r63_sovereign_12;
	private BigDecimal	r63_others_13;
	private BigDecimal	r63_rated_14;
	private BigDecimal	r63_main_index_15;
	private BigDecimal	r63_other_equities_16;
	private BigDecimal	r63_mutual_funds_17;
	private BigDecimal	r63_total_collateral_19;
	private BigDecimal	r63_net_collateral_20;
	private BigDecimal	r63_net_collateral_21;
	private String	r64_risk_weight;
	private BigDecimal	r64_total_exposure_100;
	private BigDecimal	r64_cash_1;
	private BigDecimal	r64_sovereign_2;
	private BigDecimal	r64_others_3;
	private BigDecimal	r64_sovereign_4;
	private BigDecimal	r64_others_5;
	private BigDecimal	r64_sovereign_6;
	private BigDecimal	r64_others_7;
	private BigDecimal	r64_sovereign_8;
	private BigDecimal	r64_others_9;
	private BigDecimal	r64_sovereign_10;
	private BigDecimal	r64_others_11;
	private BigDecimal	r64_sovereign_12;
	private BigDecimal	r64_others_13;
	private BigDecimal	r64_rated_14;
	private BigDecimal	r64_main_index_15;
	private BigDecimal	r64_other_equities_16;
	private BigDecimal	r64_mutual_funds_17;
	private BigDecimal	r64_total_collateral_19;
	private BigDecimal	r64_net_collateral_20;
	private BigDecimal	r64_net_collateral_21;
	private String	r65_risk_weight;
	private BigDecimal	r65_total_exposure_100;
	private BigDecimal	r65_cash_1;
	private BigDecimal	r65_sovereign_2;
	private BigDecimal	r65_others_3;
	private BigDecimal	r65_sovereign_4;
	private BigDecimal	r65_others_5;
	private BigDecimal	r65_sovereign_6;
	private BigDecimal	r65_others_7;
	private BigDecimal	r65_sovereign_8;
	private BigDecimal	r65_others_9;
	private BigDecimal	r65_sovereign_10;
	private BigDecimal	r65_others_11;
	private BigDecimal	r65_sovereign_12;
	private BigDecimal	r65_others_13;
	private BigDecimal	r65_rated_14;
	private BigDecimal	r65_main_index_15;
	private BigDecimal	r65_other_equities_16;
	private BigDecimal	r65_mutual_funds_17;
	private BigDecimal	r65_total_collateral_19;
	private BigDecimal	r65_net_collateral_20;
	private BigDecimal	r65_net_collateral_21;
	private String	r66_product;
	private String	r66_risk_weight;
	private BigDecimal	r66_total_exposure_100;
	private BigDecimal	r66_cash_1;
	private BigDecimal	r66_sovereign_2;
	private BigDecimal	r66_others_3;
	private BigDecimal	r66_sovereign_4;
	private BigDecimal	r66_others_5;
	private BigDecimal	r66_sovereign_6;
	private BigDecimal	r66_others_7;
	private BigDecimal	r66_sovereign_8;
	private BigDecimal	r66_others_9;
	private BigDecimal	r66_sovereign_10;
	private BigDecimal	r66_others_11;
	private BigDecimal	r66_sovereign_12;
	private BigDecimal	r66_others_13;
	private BigDecimal	r66_rated_14;
	private BigDecimal	r66_main_index_15;
	private BigDecimal	r66_other_equities_16;
	private BigDecimal	r66_mutual_funds_17;
	private BigDecimal	r66_total_collateral_19;
	private BigDecimal	r66_net_collateral_20;
	private BigDecimal	r66_net_collateral_21;
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
	private BigDecimal	r20_cash_1;
	private BigDecimal	r20_sovereign_2;
	private BigDecimal	r20_others_3;
	private BigDecimal	r20_sovereign_4;
	private BigDecimal	r20_others_5;
	private BigDecimal	r20_sovereign_6;
	private BigDecimal	r20_others_7;
	private BigDecimal	r20_sovereign_8;
	private BigDecimal	r20_others_9;
	private BigDecimal	r20_sovereign_10;
	private BigDecimal	r20_others_11;
	private BigDecimal	r20_sovereign_12;
	private BigDecimal	r20_others_13;
	private BigDecimal	r20_rated_14;
	private BigDecimal	r20_main_index_15;
	private BigDecimal	r20_other_equities_16;
	private BigDecimal	r20_mutual_funds_17;
	private BigDecimal	r20_total_collateral_19;
	private BigDecimal	r20_net_collateral_20;
	private BigDecimal	r20_net_collateral_21;
	private BigDecimal	r60_total_exposure_0;
	private String	r60_risk_weight;
	private BigDecimal	r60_total_exposure_20;
	private BigDecimal	r60_cash_1;
	private BigDecimal	r60_sovereign_2;
	private BigDecimal	r60_others_3;
	private BigDecimal	r60_sovereign_4;
	private BigDecimal	r60_others_5;
	private BigDecimal	r60_sovereign_6;
	private BigDecimal	r60_others_7;
	private BigDecimal	r60_sovereign_8;
	private BigDecimal	r60_others_9;
	private BigDecimal	r60_sovereign_10;
	private BigDecimal	r60_others_11;
	private BigDecimal	r60_sovereign_12;
	private BigDecimal	r60_others_13;
	private BigDecimal	r60_rated_14;
	private BigDecimal	r60_main_index_15;
	private BigDecimal	r60_other_equities_16;
	private BigDecimal	r60_mutual_funds_17;
	private BigDecimal	r60_total_collateral_19;
	private BigDecimal	r60_net_collateral_20;
	private BigDecimal	r60_net_collateral_21;
	public String getR9_product() {
		return r9_product;
	}
	public void setR9_product(String r9_product) {
		this.r9_product = r9_product;
	}
	public String getR9_risk_weight() {
		return r9_risk_weight;
	}
	public void setR9_risk_weight(String r9_risk_weight) {
		this.r9_risk_weight = r9_risk_weight;
	}
	public BigDecimal getR9_total_exposure() {
		return r9_total_exposure;
	}
	public void setR9_total_exposure(BigDecimal r9_total_exposure) {
		this.r9_total_exposure = r9_total_exposure;
	}
	public String getR10_product() {
		return r10_product;
	}
	public void setR10_product(String r10_product) {
		this.r10_product = r10_product;
	}
	public String getR10_risk_weight() {
		return r10_risk_weight;
	}
	public void setR10_risk_weight(String r10_risk_weight) {
		this.r10_risk_weight = r10_risk_weight;
	}
	public BigDecimal getR10_total_exposure() {
		return r10_total_exposure;
	}
	public void setR10_total_exposure(BigDecimal r10_total_exposure) {
		this.r10_total_exposure = r10_total_exposure;
	}
	public String getR11_product() {
		return r11_product;
	}
	public void setR11_product(String r11_product) {
		this.r11_product = r11_product;
	}
	public String getR11_risk_weight() {
		return r11_risk_weight;
	}
	public void setR11_risk_weight(String r11_risk_weight) {
		this.r11_risk_weight = r11_risk_weight;
	}
	public BigDecimal getR11_total_exposure() {
		return r11_total_exposure;
	}
	public void setR11_total_exposure(BigDecimal r11_total_exposure) {
		this.r11_total_exposure = r11_total_exposure;
	}
	public String getR12_product() {
		return r12_product;
	}
	public void setR12_product(String r12_product) {
		this.r12_product = r12_product;
	}
	public String getR12_risk_weight() {
		return r12_risk_weight;
	}
	public void setR12_risk_weight(String r12_risk_weight) {
		this.r12_risk_weight = r12_risk_weight;
	}
	public BigDecimal getR12_total_exposure() {
		return r12_total_exposure;
	}
	public void setR12_total_exposure(BigDecimal r12_total_exposure) {
		this.r12_total_exposure = r12_total_exposure;
	}
	public String getR13_product() {
		return r13_product;
	}
	public void setR13_product(String r13_product) {
		this.r13_product = r13_product;
	}
	public String getR13_risk_weight() {
		return r13_risk_weight;
	}
	public void setR13_risk_weight(String r13_risk_weight) {
		this.r13_risk_weight = r13_risk_weight;
	}
	public BigDecimal getR13_total_exposure() {
		return r13_total_exposure;
	}
	public void setR13_total_exposure(BigDecimal r13_total_exposure) {
		this.r13_total_exposure = r13_total_exposure;
	}
	public String getR14_product() {
		return r14_product;
	}
	public void setR14_product(String r14_product) {
		this.r14_product = r14_product;
	}
	public String getR14_risk_weight() {
		return r14_risk_weight;
	}
	public void setR14_risk_weight(String r14_risk_weight) {
		this.r14_risk_weight = r14_risk_weight;
	}
	public BigDecimal getR14_total_exposure_0() {
		return r14_total_exposure_0;
	}
	public void setR14_total_exposure_0(BigDecimal r14_total_exposure_0) {
		this.r14_total_exposure_0 = r14_total_exposure_0;
	}
	public String getR15_risk_weight() {
		return r15_risk_weight;
	}
	public void setR15_risk_weight(String r15_risk_weight) {
		this.r15_risk_weight = r15_risk_weight;
	}
	public BigDecimal getR15_total_exposure_20() {
		return r15_total_exposure_20;
	}
	public void setR15_total_exposure_20(BigDecimal r15_total_exposure_20) {
		this.r15_total_exposure_20 = r15_total_exposure_20;
	}
	public String getR16_risk_weight() {
		return r16_risk_weight;
	}
	public void setR16_risk_weight(String r16_risk_weight) {
		this.r16_risk_weight = r16_risk_weight;
	}
	public BigDecimal getR16_total_exposure_50() {
		return r16_total_exposure_50;
	}
	public void setR16_total_exposure_50(BigDecimal r16_total_exposure_50) {
		this.r16_total_exposure_50 = r16_total_exposure_50;
	}
	public String getR17_risk_weight() {
		return r17_risk_weight;
	}
	public void setR17_risk_weight(String r17_risk_weight) {
		this.r17_risk_weight = r17_risk_weight;
	}
	public BigDecimal getR17_total_exposure_100() {
		return r17_total_exposure_100;
	}
	public void setR17_total_exposure_100(BigDecimal r17_total_exposure_100) {
		this.r17_total_exposure_100 = r17_total_exposure_100;
	}
	public String getR18_risk_weight() {
		return r18_risk_weight;
	}
	public void setR18_risk_weight(String r18_risk_weight) {
		this.r18_risk_weight = r18_risk_weight;
	}
	public BigDecimal getR18_total_exposure_150() {
		return r18_total_exposure_150;
	}
	public void setR18_total_exposure_150(BigDecimal r18_total_exposure_150) {
		this.r18_total_exposure_150 = r18_total_exposure_150;
	}
	public String getR19_risk_weight() {
		return r19_risk_weight;
	}
	public void setR19_risk_weight(String r19_risk_weight) {
		this.r19_risk_weight = r19_risk_weight;
	}
	public BigDecimal getR19_total_exposure_100() {
		return r19_total_exposure_100;
	}
	public void setR19_total_exposure_100(BigDecimal r19_total_exposure_100) {
		this.r19_total_exposure_100 = r19_total_exposure_100;
	}
	public String getR20_sub_total() {
		return r20_sub_total;
	}
	public void setR20_sub_total(String r20_sub_total) {
		this.r20_sub_total = r20_sub_total;
	}
	public BigDecimal getR20_total_exposure() {
		return r20_total_exposure;
	}
	public void setR20_total_exposure(BigDecimal r20_total_exposure) {
		this.r20_total_exposure = r20_total_exposure;
	}
	public String getR21_product() {
		return r21_product;
	}
	public void setR21_product(String r21_product) {
		this.r21_product = r21_product;
	}
	public String getR21_risk_weight() {
		return r21_risk_weight;
	}
	public void setR21_risk_weight(String r21_risk_weight) {
		this.r21_risk_weight = r21_risk_weight;
	}
	public BigDecimal getR21_total_exposure_0() {
		return r21_total_exposure_0;
	}
	public void setR21_total_exposure_0(BigDecimal r21_total_exposure_0) {
		this.r21_total_exposure_0 = r21_total_exposure_0;
	}
	public String getR22_product() {
		return r22_product;
	}
	public void setR22_product(String r22_product) {
		this.r22_product = r22_product;
	}
	public String getR22_risk_weight() {
		return r22_risk_weight;
	}
	public void setR22_risk_weight(String r22_risk_weight) {
		this.r22_risk_weight = r22_risk_weight;
	}
	public BigDecimal getR22_total_exposure_0() {
		return r22_total_exposure_0;
	}
	public void setR22_total_exposure_0(BigDecimal r22_total_exposure_0) {
		this.r22_total_exposure_0 = r22_total_exposure_0;
	}
	public String getR23_risk_weight() {
		return r23_risk_weight;
	}
	public void setR23_risk_weight(String r23_risk_weight) {
		this.r23_risk_weight = r23_risk_weight;
	}
	public BigDecimal getR23_total_exposure_20() {
		return r23_total_exposure_20;
	}
	public void setR23_total_exposure_20(BigDecimal r23_total_exposure_20) {
		this.r23_total_exposure_20 = r23_total_exposure_20;
	}
	public BigDecimal getR23_cash_1() {
		return r23_cash_1;
	}
	public void setR23_cash_1(BigDecimal r23_cash_1) {
		this.r23_cash_1 = r23_cash_1;
	}
	public BigDecimal getR23_sovereign_2() {
		return r23_sovereign_2;
	}
	public void setR23_sovereign_2(BigDecimal r23_sovereign_2) {
		this.r23_sovereign_2 = r23_sovereign_2;
	}
	public BigDecimal getR23_others_3() {
		return r23_others_3;
	}
	public void setR23_others_3(BigDecimal r23_others_3) {
		this.r23_others_3 = r23_others_3;
	}
	public BigDecimal getR23_sovereign_4() {
		return r23_sovereign_4;
	}
	public void setR23_sovereign_4(BigDecimal r23_sovereign_4) {
		this.r23_sovereign_4 = r23_sovereign_4;
	}
	public BigDecimal getR23_others_5() {
		return r23_others_5;
	}
	public void setR23_others_5(BigDecimal r23_others_5) {
		this.r23_others_5 = r23_others_5;
	}
	public BigDecimal getR23_sovereign_6() {
		return r23_sovereign_6;
	}
	public void setR23_sovereign_6(BigDecimal r23_sovereign_6) {
		this.r23_sovereign_6 = r23_sovereign_6;
	}
	public BigDecimal getR23_others_7() {
		return r23_others_7;
	}
	public void setR23_others_7(BigDecimal r23_others_7) {
		this.r23_others_7 = r23_others_7;
	}
	public BigDecimal getR23_sovereign_8() {
		return r23_sovereign_8;
	}
	public void setR23_sovereign_8(BigDecimal r23_sovereign_8) {
		this.r23_sovereign_8 = r23_sovereign_8;
	}
	public BigDecimal getR23_others_9() {
		return r23_others_9;
	}
	public void setR23_others_9(BigDecimal r23_others_9) {
		this.r23_others_9 = r23_others_9;
	}
	public BigDecimal getR23_sovereign_10() {
		return r23_sovereign_10;
	}
	public void setR23_sovereign_10(BigDecimal r23_sovereign_10) {
		this.r23_sovereign_10 = r23_sovereign_10;
	}
	public BigDecimal getR23_others_11() {
		return r23_others_11;
	}
	public void setR23_others_11(BigDecimal r23_others_11) {
		this.r23_others_11 = r23_others_11;
	}
	public BigDecimal getR23_sovereign_12() {
		return r23_sovereign_12;
	}
	public void setR23_sovereign_12(BigDecimal r23_sovereign_12) {
		this.r23_sovereign_12 = r23_sovereign_12;
	}
	public BigDecimal getR23_others_13() {
		return r23_others_13;
	}
	public void setR23_others_13(BigDecimal r23_others_13) {
		this.r23_others_13 = r23_others_13;
	}
	public BigDecimal getR23_rated_14() {
		return r23_rated_14;
	}
	public void setR23_rated_14(BigDecimal r23_rated_14) {
		this.r23_rated_14 = r23_rated_14;
	}
	public BigDecimal getR23_main_index_15() {
		return r23_main_index_15;
	}
	public void setR23_main_index_15(BigDecimal r23_main_index_15) {
		this.r23_main_index_15 = r23_main_index_15;
	}
	public BigDecimal getR23_other_equities_16() {
		return r23_other_equities_16;
	}
	public void setR23_other_equities_16(BigDecimal r23_other_equities_16) {
		this.r23_other_equities_16 = r23_other_equities_16;
	}
	public BigDecimal getR23_mutual_funds_17() {
		return r23_mutual_funds_17;
	}
	public void setR23_mutual_funds_17(BigDecimal r23_mutual_funds_17) {
		this.r23_mutual_funds_17 = r23_mutual_funds_17;
	}
	public BigDecimal getR23_total_collateral_19() {
		return r23_total_collateral_19;
	}
	public void setR23_total_collateral_19(BigDecimal r23_total_collateral_19) {
		this.r23_total_collateral_19 = r23_total_collateral_19;
	}
	public BigDecimal getR23_net_collateral_20() {
		return r23_net_collateral_20;
	}
	public void setR23_net_collateral_20(BigDecimal r23_net_collateral_20) {
		this.r23_net_collateral_20 = r23_net_collateral_20;
	}
	public BigDecimal getR23_net_collateral_21() {
		return r23_net_collateral_21;
	}
	public void setR23_net_collateral_21(BigDecimal r23_net_collateral_21) {
		this.r23_net_collateral_21 = r23_net_collateral_21;
	}
	public String getR24_risk_weight() {
		return r24_risk_weight;
	}
	public void setR24_risk_weight(String r24_risk_weight) {
		this.r24_risk_weight = r24_risk_weight;
	}
	public BigDecimal getR24_total_exposure_50() {
		return r24_total_exposure_50;
	}
	public void setR24_total_exposure_50(BigDecimal r24_total_exposure_50) {
		this.r24_total_exposure_50 = r24_total_exposure_50;
	}
	public BigDecimal getR24_cash_1() {
		return r24_cash_1;
	}
	public void setR24_cash_1(BigDecimal r24_cash_1) {
		this.r24_cash_1 = r24_cash_1;
	}
	public BigDecimal getR24_sovereign_2() {
		return r24_sovereign_2;
	}
	public void setR24_sovereign_2(BigDecimal r24_sovereign_2) {
		this.r24_sovereign_2 = r24_sovereign_2;
	}
	public BigDecimal getR24_others_3() {
		return r24_others_3;
	}
	public void setR24_others_3(BigDecimal r24_others_3) {
		this.r24_others_3 = r24_others_3;
	}
	public BigDecimal getR24_sovereign_4() {
		return r24_sovereign_4;
	}
	public void setR24_sovereign_4(BigDecimal r24_sovereign_4) {
		this.r24_sovereign_4 = r24_sovereign_4;
	}
	public BigDecimal getR24_others_5() {
		return r24_others_5;
	}
	public void setR24_others_5(BigDecimal r24_others_5) {
		this.r24_others_5 = r24_others_5;
	}
	public BigDecimal getR24_sovereign_6() {
		return r24_sovereign_6;
	}
	public void setR24_sovereign_6(BigDecimal r24_sovereign_6) {
		this.r24_sovereign_6 = r24_sovereign_6;
	}
	public BigDecimal getR24_others_7() {
		return r24_others_7;
	}
	public void setR24_others_7(BigDecimal r24_others_7) {
		this.r24_others_7 = r24_others_7;
	}
	public BigDecimal getR24_sovereign_8() {
		return r24_sovereign_8;
	}
	public void setR24_sovereign_8(BigDecimal r24_sovereign_8) {
		this.r24_sovereign_8 = r24_sovereign_8;
	}
	public BigDecimal getR24_others_9() {
		return r24_others_9;
	}
	public void setR24_others_9(BigDecimal r24_others_9) {
		this.r24_others_9 = r24_others_9;
	}
	public BigDecimal getR24_sovereign_10() {
		return r24_sovereign_10;
	}
	public void setR24_sovereign_10(BigDecimal r24_sovereign_10) {
		this.r24_sovereign_10 = r24_sovereign_10;
	}
	public BigDecimal getR24_others_11() {
		return r24_others_11;
	}
	public void setR24_others_11(BigDecimal r24_others_11) {
		this.r24_others_11 = r24_others_11;
	}
	public BigDecimal getR24_sovereign_12() {
		return r24_sovereign_12;
	}
	public void setR24_sovereign_12(BigDecimal r24_sovereign_12) {
		this.r24_sovereign_12 = r24_sovereign_12;
	}
	public BigDecimal getR24_others_13() {
		return r24_others_13;
	}
	public void setR24_others_13(BigDecimal r24_others_13) {
		this.r24_others_13 = r24_others_13;
	}
	public BigDecimal getR24_rated_14() {
		return r24_rated_14;
	}
	public void setR24_rated_14(BigDecimal r24_rated_14) {
		this.r24_rated_14 = r24_rated_14;
	}
	public BigDecimal getR24_main_index_15() {
		return r24_main_index_15;
	}
	public void setR24_main_index_15(BigDecimal r24_main_index_15) {
		this.r24_main_index_15 = r24_main_index_15;
	}
	public BigDecimal getR24_other_equities_16() {
		return r24_other_equities_16;
	}
	public void setR24_other_equities_16(BigDecimal r24_other_equities_16) {
		this.r24_other_equities_16 = r24_other_equities_16;
	}
	public BigDecimal getR24_mutual_funds_17() {
		return r24_mutual_funds_17;
	}
	public void setR24_mutual_funds_17(BigDecimal r24_mutual_funds_17) {
		this.r24_mutual_funds_17 = r24_mutual_funds_17;
	}
	public BigDecimal getR24_total_collateral_19() {
		return r24_total_collateral_19;
	}
	public void setR24_total_collateral_19(BigDecimal r24_total_collateral_19) {
		this.r24_total_collateral_19 = r24_total_collateral_19;
	}
	public BigDecimal getR24_net_collateral_20() {
		return r24_net_collateral_20;
	}
	public void setR24_net_collateral_20(BigDecimal r24_net_collateral_20) {
		this.r24_net_collateral_20 = r24_net_collateral_20;
	}
	public BigDecimal getR24_net_collateral_21() {
		return r24_net_collateral_21;
	}
	public void setR24_net_collateral_21(BigDecimal r24_net_collateral_21) {
		this.r24_net_collateral_21 = r24_net_collateral_21;
	}
	public String getR25_risk_weight() {
		return r25_risk_weight;
	}
	public void setR25_risk_weight(String r25_risk_weight) {
		this.r25_risk_weight = r25_risk_weight;
	}
	public BigDecimal getR25_total_exposure_100() {
		return r25_total_exposure_100;
	}
	public void setR25_total_exposure_100(BigDecimal r25_total_exposure_100) {
		this.r25_total_exposure_100 = r25_total_exposure_100;
	}
	public BigDecimal getR25_cash_1() {
		return r25_cash_1;
	}
	public void setR25_cash_1(BigDecimal r25_cash_1) {
		this.r25_cash_1 = r25_cash_1;
	}
	public BigDecimal getR25_sovereign_2() {
		return r25_sovereign_2;
	}
	public void setR25_sovereign_2(BigDecimal r25_sovereign_2) {
		this.r25_sovereign_2 = r25_sovereign_2;
	}
	public BigDecimal getR25_others_3() {
		return r25_others_3;
	}
	public void setR25_others_3(BigDecimal r25_others_3) {
		this.r25_others_3 = r25_others_3;
	}
	public BigDecimal getR25_sovereign_4() {
		return r25_sovereign_4;
	}
	public void setR25_sovereign_4(BigDecimal r25_sovereign_4) {
		this.r25_sovereign_4 = r25_sovereign_4;
	}
	public BigDecimal getR25_others_5() {
		return r25_others_5;
	}
	public void setR25_others_5(BigDecimal r25_others_5) {
		this.r25_others_5 = r25_others_5;
	}
	public BigDecimal getR25_sovereign_6() {
		return r25_sovereign_6;
	}
	public void setR25_sovereign_6(BigDecimal r25_sovereign_6) {
		this.r25_sovereign_6 = r25_sovereign_6;
	}
	public BigDecimal getR25_others_7() {
		return r25_others_7;
	}
	public void setR25_others_7(BigDecimal r25_others_7) {
		this.r25_others_7 = r25_others_7;
	}
	public BigDecimal getR25_sovereign_8() {
		return r25_sovereign_8;
	}
	public void setR25_sovereign_8(BigDecimal r25_sovereign_8) {
		this.r25_sovereign_8 = r25_sovereign_8;
	}
	public BigDecimal getR25_others_9() {
		return r25_others_9;
	}
	public void setR25_others_9(BigDecimal r25_others_9) {
		this.r25_others_9 = r25_others_9;
	}
	public BigDecimal getR25_sovereign_10() {
		return r25_sovereign_10;
	}
	public void setR25_sovereign_10(BigDecimal r25_sovereign_10) {
		this.r25_sovereign_10 = r25_sovereign_10;
	}
	public BigDecimal getR25_others_11() {
		return r25_others_11;
	}
	public void setR25_others_11(BigDecimal r25_others_11) {
		this.r25_others_11 = r25_others_11;
	}
	public BigDecimal getR25_sovereign_12() {
		return r25_sovereign_12;
	}
	public void setR25_sovereign_12(BigDecimal r25_sovereign_12) {
		this.r25_sovereign_12 = r25_sovereign_12;
	}
	public BigDecimal getR25_others_13() {
		return r25_others_13;
	}
	public void setR25_others_13(BigDecimal r25_others_13) {
		this.r25_others_13 = r25_others_13;
	}
	public BigDecimal getR25_rated_14() {
		return r25_rated_14;
	}
	public void setR25_rated_14(BigDecimal r25_rated_14) {
		this.r25_rated_14 = r25_rated_14;
	}
	public BigDecimal getR25_main_index_15() {
		return r25_main_index_15;
	}
	public void setR25_main_index_15(BigDecimal r25_main_index_15) {
		this.r25_main_index_15 = r25_main_index_15;
	}
	public BigDecimal getR25_other_equities_16() {
		return r25_other_equities_16;
	}
	public void setR25_other_equities_16(BigDecimal r25_other_equities_16) {
		this.r25_other_equities_16 = r25_other_equities_16;
	}
	public BigDecimal getR25_mutual_funds_17() {
		return r25_mutual_funds_17;
	}
	public void setR25_mutual_funds_17(BigDecimal r25_mutual_funds_17) {
		this.r25_mutual_funds_17 = r25_mutual_funds_17;
	}
	public BigDecimal getR25_total_collateral_19() {
		return r25_total_collateral_19;
	}
	public void setR25_total_collateral_19(BigDecimal r25_total_collateral_19) {
		this.r25_total_collateral_19 = r25_total_collateral_19;
	}
	public BigDecimal getR25_net_collateral_20() {
		return r25_net_collateral_20;
	}
	public void setR25_net_collateral_20(BigDecimal r25_net_collateral_20) {
		this.r25_net_collateral_20 = r25_net_collateral_20;
	}
	public BigDecimal getR25_net_collateral_21() {
		return r25_net_collateral_21;
	}
	public void setR25_net_collateral_21(BigDecimal r25_net_collateral_21) {
		this.r25_net_collateral_21 = r25_net_collateral_21;
	}
	public String getR26_risk_weight() {
		return r26_risk_weight;
	}
	public void setR26_risk_weight(String r26_risk_weight) {
		this.r26_risk_weight = r26_risk_weight;
	}
	public BigDecimal getR26_total_exposure_150() {
		return r26_total_exposure_150;
	}
	public void setR26_total_exposure_150(BigDecimal r26_total_exposure_150) {
		this.r26_total_exposure_150 = r26_total_exposure_150;
	}
	public BigDecimal getR26_cash_1() {
		return r26_cash_1;
	}
	public void setR26_cash_1(BigDecimal r26_cash_1) {
		this.r26_cash_1 = r26_cash_1;
	}
	public BigDecimal getR26_sovereign_2() {
		return r26_sovereign_2;
	}
	public void setR26_sovereign_2(BigDecimal r26_sovereign_2) {
		this.r26_sovereign_2 = r26_sovereign_2;
	}
	public BigDecimal getR26_others_3() {
		return r26_others_3;
	}
	public void setR26_others_3(BigDecimal r26_others_3) {
		this.r26_others_3 = r26_others_3;
	}
	public BigDecimal getR26_sovereign_4() {
		return r26_sovereign_4;
	}
	public void setR26_sovereign_4(BigDecimal r26_sovereign_4) {
		this.r26_sovereign_4 = r26_sovereign_4;
	}
	public BigDecimal getR26_others_5() {
		return r26_others_5;
	}
	public void setR26_others_5(BigDecimal r26_others_5) {
		this.r26_others_5 = r26_others_5;
	}
	public BigDecimal getR26_sovereign_6() {
		return r26_sovereign_6;
	}
	public void setR26_sovereign_6(BigDecimal r26_sovereign_6) {
		this.r26_sovereign_6 = r26_sovereign_6;
	}
	public BigDecimal getR26_others_7() {
		return r26_others_7;
	}
	public void setR26_others_7(BigDecimal r26_others_7) {
		this.r26_others_7 = r26_others_7;
	}
	public BigDecimal getR26_sovereign_8() {
		return r26_sovereign_8;
	}
	public void setR26_sovereign_8(BigDecimal r26_sovereign_8) {
		this.r26_sovereign_8 = r26_sovereign_8;
	}
	public BigDecimal getR26_others_9() {
		return r26_others_9;
	}
	public void setR26_others_9(BigDecimal r26_others_9) {
		this.r26_others_9 = r26_others_9;
	}
	public BigDecimal getR26_sovereign_10() {
		return r26_sovereign_10;
	}
	public void setR26_sovereign_10(BigDecimal r26_sovereign_10) {
		this.r26_sovereign_10 = r26_sovereign_10;
	}
	public BigDecimal getR26_others_11() {
		return r26_others_11;
	}
	public void setR26_others_11(BigDecimal r26_others_11) {
		this.r26_others_11 = r26_others_11;
	}
	public BigDecimal getR26_sovereign_12() {
		return r26_sovereign_12;
	}
	public void setR26_sovereign_12(BigDecimal r26_sovereign_12) {
		this.r26_sovereign_12 = r26_sovereign_12;
	}
	public BigDecimal getR26_others_13() {
		return r26_others_13;
	}
	public void setR26_others_13(BigDecimal r26_others_13) {
		this.r26_others_13 = r26_others_13;
	}
	public BigDecimal getR26_rated_14() {
		return r26_rated_14;
	}
	public void setR26_rated_14(BigDecimal r26_rated_14) {
		this.r26_rated_14 = r26_rated_14;
	}
	public BigDecimal getR26_main_index_15() {
		return r26_main_index_15;
	}
	public void setR26_main_index_15(BigDecimal r26_main_index_15) {
		this.r26_main_index_15 = r26_main_index_15;
	}
	public BigDecimal getR26_other_equities_16() {
		return r26_other_equities_16;
	}
	public void setR26_other_equities_16(BigDecimal r26_other_equities_16) {
		this.r26_other_equities_16 = r26_other_equities_16;
	}
	public BigDecimal getR26_mutual_funds_17() {
		return r26_mutual_funds_17;
	}
	public void setR26_mutual_funds_17(BigDecimal r26_mutual_funds_17) {
		this.r26_mutual_funds_17 = r26_mutual_funds_17;
	}
	public BigDecimal getR26_total_collateral_19() {
		return r26_total_collateral_19;
	}
	public void setR26_total_collateral_19(BigDecimal r26_total_collateral_19) {
		this.r26_total_collateral_19 = r26_total_collateral_19;
	}
	public BigDecimal getR26_net_collateral_20() {
		return r26_net_collateral_20;
	}
	public void setR26_net_collateral_20(BigDecimal r26_net_collateral_20) {
		this.r26_net_collateral_20 = r26_net_collateral_20;
	}
	public BigDecimal getR26_net_collateral_21() {
		return r26_net_collateral_21;
	}
	public void setR26_net_collateral_21(BigDecimal r26_net_collateral_21) {
		this.r26_net_collateral_21 = r26_net_collateral_21;
	}
	public String getR27_risk_weight() {
		return r27_risk_weight;
	}
	public void setR27_risk_weight(String r27_risk_weight) {
		this.r27_risk_weight = r27_risk_weight;
	}
	public BigDecimal getR27_total_exposure_100() {
		return r27_total_exposure_100;
	}
	public void setR27_total_exposure_100(BigDecimal r27_total_exposure_100) {
		this.r27_total_exposure_100 = r27_total_exposure_100;
	}
	public BigDecimal getR27_cash_1() {
		return r27_cash_1;
	}
	public void setR27_cash_1(BigDecimal r27_cash_1) {
		this.r27_cash_1 = r27_cash_1;
	}
	public BigDecimal getR27_sovereign_2() {
		return r27_sovereign_2;
	}
	public void setR27_sovereign_2(BigDecimal r27_sovereign_2) {
		this.r27_sovereign_2 = r27_sovereign_2;
	}
	public BigDecimal getR27_others_3() {
		return r27_others_3;
	}
	public void setR27_others_3(BigDecimal r27_others_3) {
		this.r27_others_3 = r27_others_3;
	}
	public BigDecimal getR27_sovereign_4() {
		return r27_sovereign_4;
	}
	public void setR27_sovereign_4(BigDecimal r27_sovereign_4) {
		this.r27_sovereign_4 = r27_sovereign_4;
	}
	public BigDecimal getR27_others_5() {
		return r27_others_5;
	}
	public void setR27_others_5(BigDecimal r27_others_5) {
		this.r27_others_5 = r27_others_5;
	}
	public BigDecimal getR27_sovereign_6() {
		return r27_sovereign_6;
	}
	public void setR27_sovereign_6(BigDecimal r27_sovereign_6) {
		this.r27_sovereign_6 = r27_sovereign_6;
	}
	public BigDecimal getR27_others_7() {
		return r27_others_7;
	}
	public void setR27_others_7(BigDecimal r27_others_7) {
		this.r27_others_7 = r27_others_7;
	}
	public BigDecimal getR27_sovereign_8() {
		return r27_sovereign_8;
	}
	public void setR27_sovereign_8(BigDecimal r27_sovereign_8) {
		this.r27_sovereign_8 = r27_sovereign_8;
	}
	public BigDecimal getR27_others_9() {
		return r27_others_9;
	}
	public void setR27_others_9(BigDecimal r27_others_9) {
		this.r27_others_9 = r27_others_9;
	}
	public BigDecimal getR27_sovereign_10() {
		return r27_sovereign_10;
	}
	public void setR27_sovereign_10(BigDecimal r27_sovereign_10) {
		this.r27_sovereign_10 = r27_sovereign_10;
	}
	public BigDecimal getR27_others_11() {
		return r27_others_11;
	}
	public void setR27_others_11(BigDecimal r27_others_11) {
		this.r27_others_11 = r27_others_11;
	}
	public BigDecimal getR27_sovereign_12() {
		return r27_sovereign_12;
	}
	public void setR27_sovereign_12(BigDecimal r27_sovereign_12) {
		this.r27_sovereign_12 = r27_sovereign_12;
	}
	public BigDecimal getR27_others_13() {
		return r27_others_13;
	}
	public void setR27_others_13(BigDecimal r27_others_13) {
		this.r27_others_13 = r27_others_13;
	}
	public BigDecimal getR27_rated_14() {
		return r27_rated_14;
	}
	public void setR27_rated_14(BigDecimal r27_rated_14) {
		this.r27_rated_14 = r27_rated_14;
	}
	public BigDecimal getR27_main_index_15() {
		return r27_main_index_15;
	}
	public void setR27_main_index_15(BigDecimal r27_main_index_15) {
		this.r27_main_index_15 = r27_main_index_15;
	}
	public BigDecimal getR27_other_equities_16() {
		return r27_other_equities_16;
	}
	public void setR27_other_equities_16(BigDecimal r27_other_equities_16) {
		this.r27_other_equities_16 = r27_other_equities_16;
	}
	public BigDecimal getR27_mutual_funds_17() {
		return r27_mutual_funds_17;
	}
	public void setR27_mutual_funds_17(BigDecimal r27_mutual_funds_17) {
		this.r27_mutual_funds_17 = r27_mutual_funds_17;
	}
	public BigDecimal getR27_total_collateral_19() {
		return r27_total_collateral_19;
	}
	public void setR27_total_collateral_19(BigDecimal r27_total_collateral_19) {
		this.r27_total_collateral_19 = r27_total_collateral_19;
	}
	public BigDecimal getR27_net_collateral_20() {
		return r27_net_collateral_20;
	}
	public void setR27_net_collateral_20(BigDecimal r27_net_collateral_20) {
		this.r27_net_collateral_20 = r27_net_collateral_20;
	}
	public BigDecimal getR27_net_collateral_21() {
		return r27_net_collateral_21;
	}
	public void setR27_net_collateral_21(BigDecimal r27_net_collateral_21) {
		this.r27_net_collateral_21 = r27_net_collateral_21;
	}
	public String getR28_product() {
		return r28_product;
	}
	public void setR28_product(String r28_product) {
		this.r28_product = r28_product;
	}
	public String getR28_risk_weight() {
		return r28_risk_weight;
	}
	public void setR28_risk_weight(String r28_risk_weight) {
		this.r28_risk_weight = r28_risk_weight;
	}
	public BigDecimal getR28_total_exposure_0() {
		return r28_total_exposure_0;
	}
	public void setR28_total_exposure_0(BigDecimal r28_total_exposure_0) {
		this.r28_total_exposure_0 = r28_total_exposure_0;
	}
	public String getR29_risk_weight() {
		return r29_risk_weight;
	}
	public void setR29_risk_weight(String r29_risk_weight) {
		this.r29_risk_weight = r29_risk_weight;
	}
	public BigDecimal getR29_total_exposure_20() {
		return r29_total_exposure_20;
	}
	public void setR29_total_exposure_20(BigDecimal r29_total_exposure_20) {
		this.r29_total_exposure_20 = r29_total_exposure_20;
	}
	public BigDecimal getR29_cash_1() {
		return r29_cash_1;
	}
	public void setR29_cash_1(BigDecimal r29_cash_1) {
		this.r29_cash_1 = r29_cash_1;
	}
	public BigDecimal getR29_sovereign_2() {
		return r29_sovereign_2;
	}
	public void setR29_sovereign_2(BigDecimal r29_sovereign_2) {
		this.r29_sovereign_2 = r29_sovereign_2;
	}
	public BigDecimal getR29_others_3() {
		return r29_others_3;
	}
	public void setR29_others_3(BigDecimal r29_others_3) {
		this.r29_others_3 = r29_others_3;
	}
	public BigDecimal getR29_sovereign_4() {
		return r29_sovereign_4;
	}
	public void setR29_sovereign_4(BigDecimal r29_sovereign_4) {
		this.r29_sovereign_4 = r29_sovereign_4;
	}
	public BigDecimal getR29_others_5() {
		return r29_others_5;
	}
	public void setR29_others_5(BigDecimal r29_others_5) {
		this.r29_others_5 = r29_others_5;
	}
	public BigDecimal getR29_sovereign_6() {
		return r29_sovereign_6;
	}
	public void setR29_sovereign_6(BigDecimal r29_sovereign_6) {
		this.r29_sovereign_6 = r29_sovereign_6;
	}
	public BigDecimal getR29_others_7() {
		return r29_others_7;
	}
	public void setR29_others_7(BigDecimal r29_others_7) {
		this.r29_others_7 = r29_others_7;
	}
	public BigDecimal getR29_sovereign_8() {
		return r29_sovereign_8;
	}
	public void setR29_sovereign_8(BigDecimal r29_sovereign_8) {
		this.r29_sovereign_8 = r29_sovereign_8;
	}
	public BigDecimal getR29_others_9() {
		return r29_others_9;
	}
	public void setR29_others_9(BigDecimal r29_others_9) {
		this.r29_others_9 = r29_others_9;
	}
	public BigDecimal getR29_sovereign_10() {
		return r29_sovereign_10;
	}
	public void setR29_sovereign_10(BigDecimal r29_sovereign_10) {
		this.r29_sovereign_10 = r29_sovereign_10;
	}
	public BigDecimal getR29_others_11() {
		return r29_others_11;
	}
	public void setR29_others_11(BigDecimal r29_others_11) {
		this.r29_others_11 = r29_others_11;
	}
	public BigDecimal getR29_sovereign_12() {
		return r29_sovereign_12;
	}
	public void setR29_sovereign_12(BigDecimal r29_sovereign_12) {
		this.r29_sovereign_12 = r29_sovereign_12;
	}
	public BigDecimal getR29_others_13() {
		return r29_others_13;
	}
	public void setR29_others_13(BigDecimal r29_others_13) {
		this.r29_others_13 = r29_others_13;
	}
	public BigDecimal getR29_rated_14() {
		return r29_rated_14;
	}
	public void setR29_rated_14(BigDecimal r29_rated_14) {
		this.r29_rated_14 = r29_rated_14;
	}
	public BigDecimal getR29_main_index_15() {
		return r29_main_index_15;
	}
	public void setR29_main_index_15(BigDecimal r29_main_index_15) {
		this.r29_main_index_15 = r29_main_index_15;
	}
	public BigDecimal getR29_other_equities_16() {
		return r29_other_equities_16;
	}
	public void setR29_other_equities_16(BigDecimal r29_other_equities_16) {
		this.r29_other_equities_16 = r29_other_equities_16;
	}
	public BigDecimal getR29_mutual_funds_17() {
		return r29_mutual_funds_17;
	}
	public void setR29_mutual_funds_17(BigDecimal r29_mutual_funds_17) {
		this.r29_mutual_funds_17 = r29_mutual_funds_17;
	}
	public BigDecimal getR29_total_collateral_19() {
		return r29_total_collateral_19;
	}
	public void setR29_total_collateral_19(BigDecimal r29_total_collateral_19) {
		this.r29_total_collateral_19 = r29_total_collateral_19;
	}
	public BigDecimal getR29_net_collateral_20() {
		return r29_net_collateral_20;
	}
	public void setR29_net_collateral_20(BigDecimal r29_net_collateral_20) {
		this.r29_net_collateral_20 = r29_net_collateral_20;
	}
	public BigDecimal getR29_net_collateral_21() {
		return r29_net_collateral_21;
	}
	public void setR29_net_collateral_21(BigDecimal r29_net_collateral_21) {
		this.r29_net_collateral_21 = r29_net_collateral_21;
	}
	public String getR30_risk_weight() {
		return r30_risk_weight;
	}
	public void setR30_risk_weight(String r30_risk_weight) {
		this.r30_risk_weight = r30_risk_weight;
	}
	public BigDecimal getR30_total_exposure_50() {
		return r30_total_exposure_50;
	}
	public void setR30_total_exposure_50(BigDecimal r30_total_exposure_50) {
		this.r30_total_exposure_50 = r30_total_exposure_50;
	}
	public BigDecimal getR30_cash_1() {
		return r30_cash_1;
	}
	public void setR30_cash_1(BigDecimal r30_cash_1) {
		this.r30_cash_1 = r30_cash_1;
	}
	public BigDecimal getR30_sovereign_2() {
		return r30_sovereign_2;
	}
	public void setR30_sovereign_2(BigDecimal r30_sovereign_2) {
		this.r30_sovereign_2 = r30_sovereign_2;
	}
	public BigDecimal getR30_others_3() {
		return r30_others_3;
	}
	public void setR30_others_3(BigDecimal r30_others_3) {
		this.r30_others_3 = r30_others_3;
	}
	public BigDecimal getR30_sovereign_4() {
		return r30_sovereign_4;
	}
	public void setR30_sovereign_4(BigDecimal r30_sovereign_4) {
		this.r30_sovereign_4 = r30_sovereign_4;
	}
	public BigDecimal getR30_others_5() {
		return r30_others_5;
	}
	public void setR30_others_5(BigDecimal r30_others_5) {
		this.r30_others_5 = r30_others_5;
	}
	public BigDecimal getR30_sovereign_6() {
		return r30_sovereign_6;
	}
	public void setR30_sovereign_6(BigDecimal r30_sovereign_6) {
		this.r30_sovereign_6 = r30_sovereign_6;
	}
	public BigDecimal getR30_others_7() {
		return r30_others_7;
	}
	public void setR30_others_7(BigDecimal r30_others_7) {
		this.r30_others_7 = r30_others_7;
	}
	public BigDecimal getR30_sovereign_8() {
		return r30_sovereign_8;
	}
	public void setR30_sovereign_8(BigDecimal r30_sovereign_8) {
		this.r30_sovereign_8 = r30_sovereign_8;
	}
	public BigDecimal getR30_others_9() {
		return r30_others_9;
	}
	public void setR30_others_9(BigDecimal r30_others_9) {
		this.r30_others_9 = r30_others_9;
	}
	public BigDecimal getR30_sovereign_10() {
		return r30_sovereign_10;
	}
	public void setR30_sovereign_10(BigDecimal r30_sovereign_10) {
		this.r30_sovereign_10 = r30_sovereign_10;
	}
	public BigDecimal getR30_others_11() {
		return r30_others_11;
	}
	public void setR30_others_11(BigDecimal r30_others_11) {
		this.r30_others_11 = r30_others_11;
	}
	public BigDecimal getR30_sovereign_12() {
		return r30_sovereign_12;
	}
	public void setR30_sovereign_12(BigDecimal r30_sovereign_12) {
		this.r30_sovereign_12 = r30_sovereign_12;
	}
	public BigDecimal getR30_others_13() {
		return r30_others_13;
	}
	public void setR30_others_13(BigDecimal r30_others_13) {
		this.r30_others_13 = r30_others_13;
	}
	public BigDecimal getR30_rated_14() {
		return r30_rated_14;
	}
	public void setR30_rated_14(BigDecimal r30_rated_14) {
		this.r30_rated_14 = r30_rated_14;
	}
	public BigDecimal getR30_main_index_15() {
		return r30_main_index_15;
	}
	public void setR30_main_index_15(BigDecimal r30_main_index_15) {
		this.r30_main_index_15 = r30_main_index_15;
	}
	public BigDecimal getR30_other_equities_16() {
		return r30_other_equities_16;
	}
	public void setR30_other_equities_16(BigDecimal r30_other_equities_16) {
		this.r30_other_equities_16 = r30_other_equities_16;
	}
	public BigDecimal getR30_mutual_funds_17() {
		return r30_mutual_funds_17;
	}
	public void setR30_mutual_funds_17(BigDecimal r30_mutual_funds_17) {
		this.r30_mutual_funds_17 = r30_mutual_funds_17;
	}
	public BigDecimal getR30_total_collateral_19() {
		return r30_total_collateral_19;
	}
	public void setR30_total_collateral_19(BigDecimal r30_total_collateral_19) {
		this.r30_total_collateral_19 = r30_total_collateral_19;
	}
	public BigDecimal getR30_net_collateral_20() {
		return r30_net_collateral_20;
	}
	public void setR30_net_collateral_20(BigDecimal r30_net_collateral_20) {
		this.r30_net_collateral_20 = r30_net_collateral_20;
	}
	public BigDecimal getR30_net_collateral_21() {
		return r30_net_collateral_21;
	}
	public void setR30_net_collateral_21(BigDecimal r30_net_collateral_21) {
		this.r30_net_collateral_21 = r30_net_collateral_21;
	}
	public String getR31_risk_weight() {
		return r31_risk_weight;
	}
	public void setR31_risk_weight(String r31_risk_weight) {
		this.r31_risk_weight = r31_risk_weight;
	}
	public BigDecimal getR31_total_exposure_100() {
		return r31_total_exposure_100;
	}
	public void setR31_total_exposure_100(BigDecimal r31_total_exposure_100) {
		this.r31_total_exposure_100 = r31_total_exposure_100;
	}
	public BigDecimal getR31_cash_1() {
		return r31_cash_1;
	}
	public void setR31_cash_1(BigDecimal r31_cash_1) {
		this.r31_cash_1 = r31_cash_1;
	}
	public BigDecimal getR31_sovereign_2() {
		return r31_sovereign_2;
	}
	public void setR31_sovereign_2(BigDecimal r31_sovereign_2) {
		this.r31_sovereign_2 = r31_sovereign_2;
	}
	public BigDecimal getR31_others_3() {
		return r31_others_3;
	}
	public void setR31_others_3(BigDecimal r31_others_3) {
		this.r31_others_3 = r31_others_3;
	}
	public BigDecimal getR31_sovereign_4() {
		return r31_sovereign_4;
	}
	public void setR31_sovereign_4(BigDecimal r31_sovereign_4) {
		this.r31_sovereign_4 = r31_sovereign_4;
	}
	public BigDecimal getR31_others_5() {
		return r31_others_5;
	}
	public void setR31_others_5(BigDecimal r31_others_5) {
		this.r31_others_5 = r31_others_5;
	}
	public BigDecimal getR31_sovereign_6() {
		return r31_sovereign_6;
	}
	public void setR31_sovereign_6(BigDecimal r31_sovereign_6) {
		this.r31_sovereign_6 = r31_sovereign_6;
	}
	public BigDecimal getR31_others_7() {
		return r31_others_7;
	}
	public void setR31_others_7(BigDecimal r31_others_7) {
		this.r31_others_7 = r31_others_7;
	}
	public BigDecimal getR31_sovereign_8() {
		return r31_sovereign_8;
	}
	public void setR31_sovereign_8(BigDecimal r31_sovereign_8) {
		this.r31_sovereign_8 = r31_sovereign_8;
	}
	public BigDecimal getR31_others_9() {
		return r31_others_9;
	}
	public void setR31_others_9(BigDecimal r31_others_9) {
		this.r31_others_9 = r31_others_9;
	}
	public BigDecimal getR31_sovereign_10() {
		return r31_sovereign_10;
	}
	public void setR31_sovereign_10(BigDecimal r31_sovereign_10) {
		this.r31_sovereign_10 = r31_sovereign_10;
	}
	public BigDecimal getR31_others_11() {
		return r31_others_11;
	}
	public void setR31_others_11(BigDecimal r31_others_11) {
		this.r31_others_11 = r31_others_11;
	}
	public BigDecimal getR31_sovereign_12() {
		return r31_sovereign_12;
	}
	public void setR31_sovereign_12(BigDecimal r31_sovereign_12) {
		this.r31_sovereign_12 = r31_sovereign_12;
	}
	public BigDecimal getR31_others_13() {
		return r31_others_13;
	}
	public void setR31_others_13(BigDecimal r31_others_13) {
		this.r31_others_13 = r31_others_13;
	}
	public BigDecimal getR31_rated_14() {
		return r31_rated_14;
	}
	public void setR31_rated_14(BigDecimal r31_rated_14) {
		this.r31_rated_14 = r31_rated_14;
	}
	public BigDecimal getR31_main_index_15() {
		return r31_main_index_15;
	}
	public void setR31_main_index_15(BigDecimal r31_main_index_15) {
		this.r31_main_index_15 = r31_main_index_15;
	}
	public BigDecimal getR31_other_equities_16() {
		return r31_other_equities_16;
	}
	public void setR31_other_equities_16(BigDecimal r31_other_equities_16) {
		this.r31_other_equities_16 = r31_other_equities_16;
	}
	public BigDecimal getR31_mutual_funds_17() {
		return r31_mutual_funds_17;
	}
	public void setR31_mutual_funds_17(BigDecimal r31_mutual_funds_17) {
		this.r31_mutual_funds_17 = r31_mutual_funds_17;
	}
	public BigDecimal getR31_total_collateral_19() {
		return r31_total_collateral_19;
	}
	public void setR31_total_collateral_19(BigDecimal r31_total_collateral_19) {
		this.r31_total_collateral_19 = r31_total_collateral_19;
	}
	public BigDecimal getR31_net_collateral_20() {
		return r31_net_collateral_20;
	}
	public void setR31_net_collateral_20(BigDecimal r31_net_collateral_20) {
		this.r31_net_collateral_20 = r31_net_collateral_20;
	}
	public BigDecimal getR31_net_collateral_21() {
		return r31_net_collateral_21;
	}
	public void setR31_net_collateral_21(BigDecimal r31_net_collateral_21) {
		this.r31_net_collateral_21 = r31_net_collateral_21;
	}
	public String getR32_risk_weight() {
		return r32_risk_weight;
	}
	public void setR32_risk_weight(String r32_risk_weight) {
		this.r32_risk_weight = r32_risk_weight;
	}
	public BigDecimal getR32_total_exposure_150() {
		return r32_total_exposure_150;
	}
	public void setR32_total_exposure_150(BigDecimal r32_total_exposure_150) {
		this.r32_total_exposure_150 = r32_total_exposure_150;
	}
	public BigDecimal getR32_cash_1() {
		return r32_cash_1;
	}
	public void setR32_cash_1(BigDecimal r32_cash_1) {
		this.r32_cash_1 = r32_cash_1;
	}
	public BigDecimal getR32_sovereign_2() {
		return r32_sovereign_2;
	}
	public void setR32_sovereign_2(BigDecimal r32_sovereign_2) {
		this.r32_sovereign_2 = r32_sovereign_2;
	}
	public BigDecimal getR32_others_3() {
		return r32_others_3;
	}
	public void setR32_others_3(BigDecimal r32_others_3) {
		this.r32_others_3 = r32_others_3;
	}
	public BigDecimal getR32_sovereign_4() {
		return r32_sovereign_4;
	}
	public void setR32_sovereign_4(BigDecimal r32_sovereign_4) {
		this.r32_sovereign_4 = r32_sovereign_4;
	}
	public BigDecimal getR32_others_5() {
		return r32_others_5;
	}
	public void setR32_others_5(BigDecimal r32_others_5) {
		this.r32_others_5 = r32_others_5;
	}
	public BigDecimal getR32_sovereign_6() {
		return r32_sovereign_6;
	}
	public void setR32_sovereign_6(BigDecimal r32_sovereign_6) {
		this.r32_sovereign_6 = r32_sovereign_6;
	}
	public BigDecimal getR32_others_7() {
		return r32_others_7;
	}
	public void setR32_others_7(BigDecimal r32_others_7) {
		this.r32_others_7 = r32_others_7;
	}
	public BigDecimal getR32_sovereign_8() {
		return r32_sovereign_8;
	}
	public void setR32_sovereign_8(BigDecimal r32_sovereign_8) {
		this.r32_sovereign_8 = r32_sovereign_8;
	}
	public BigDecimal getR32_others_9() {
		return r32_others_9;
	}
	public void setR32_others_9(BigDecimal r32_others_9) {
		this.r32_others_9 = r32_others_9;
	}
	public BigDecimal getR32_sovereign_10() {
		return r32_sovereign_10;
	}
	public void setR32_sovereign_10(BigDecimal r32_sovereign_10) {
		this.r32_sovereign_10 = r32_sovereign_10;
	}
	public BigDecimal getR32_others_11() {
		return r32_others_11;
	}
	public void setR32_others_11(BigDecimal r32_others_11) {
		this.r32_others_11 = r32_others_11;
	}
	public BigDecimal getR32_sovereign_12() {
		return r32_sovereign_12;
	}
	public void setR32_sovereign_12(BigDecimal r32_sovereign_12) {
		this.r32_sovereign_12 = r32_sovereign_12;
	}
	public BigDecimal getR32_others_13() {
		return r32_others_13;
	}
	public void setR32_others_13(BigDecimal r32_others_13) {
		this.r32_others_13 = r32_others_13;
	}
	public BigDecimal getR32_rated_14() {
		return r32_rated_14;
	}
	public void setR32_rated_14(BigDecimal r32_rated_14) {
		this.r32_rated_14 = r32_rated_14;
	}
	public BigDecimal getR32_main_index_15() {
		return r32_main_index_15;
	}
	public void setR32_main_index_15(BigDecimal r32_main_index_15) {
		this.r32_main_index_15 = r32_main_index_15;
	}
	public BigDecimal getR32_other_equities_16() {
		return r32_other_equities_16;
	}
	public void setR32_other_equities_16(BigDecimal r32_other_equities_16) {
		this.r32_other_equities_16 = r32_other_equities_16;
	}
	public BigDecimal getR32_mutual_funds_17() {
		return r32_mutual_funds_17;
	}
	public void setR32_mutual_funds_17(BigDecimal r32_mutual_funds_17) {
		this.r32_mutual_funds_17 = r32_mutual_funds_17;
	}
	public BigDecimal getR32_total_collateral_19() {
		return r32_total_collateral_19;
	}
	public void setR32_total_collateral_19(BigDecimal r32_total_collateral_19) {
		this.r32_total_collateral_19 = r32_total_collateral_19;
	}
	public BigDecimal getR32_net_collateral_20() {
		return r32_net_collateral_20;
	}
	public void setR32_net_collateral_20(BigDecimal r32_net_collateral_20) {
		this.r32_net_collateral_20 = r32_net_collateral_20;
	}
	public BigDecimal getR32_net_collateral_21() {
		return r32_net_collateral_21;
	}
	public void setR32_net_collateral_21(BigDecimal r32_net_collateral_21) {
		this.r32_net_collateral_21 = r32_net_collateral_21;
	}
	public String getR33_risk_weight() {
		return r33_risk_weight;
	}
	public void setR33_risk_weight(String r33_risk_weight) {
		this.r33_risk_weight = r33_risk_weight;
	}
	public BigDecimal getR33_total_exposure_100() {
		return r33_total_exposure_100;
	}
	public void setR33_total_exposure_100(BigDecimal r33_total_exposure_100) {
		this.r33_total_exposure_100 = r33_total_exposure_100;
	}
	public BigDecimal getR33_cash_1() {
		return r33_cash_1;
	}
	public void setR33_cash_1(BigDecimal r33_cash_1) {
		this.r33_cash_1 = r33_cash_1;
	}
	public BigDecimal getR33_sovereign_2() {
		return r33_sovereign_2;
	}
	public void setR33_sovereign_2(BigDecimal r33_sovereign_2) {
		this.r33_sovereign_2 = r33_sovereign_2;
	}
	public BigDecimal getR33_others_3() {
		return r33_others_3;
	}
	public void setR33_others_3(BigDecimal r33_others_3) {
		this.r33_others_3 = r33_others_3;
	}
	public BigDecimal getR33_sovereign_4() {
		return r33_sovereign_4;
	}
	public void setR33_sovereign_4(BigDecimal r33_sovereign_4) {
		this.r33_sovereign_4 = r33_sovereign_4;
	}
	public BigDecimal getR33_others_5() {
		return r33_others_5;
	}
	public void setR33_others_5(BigDecimal r33_others_5) {
		this.r33_others_5 = r33_others_5;
	}
	public BigDecimal getR33_sovereign_6() {
		return r33_sovereign_6;
	}
	public void setR33_sovereign_6(BigDecimal r33_sovereign_6) {
		this.r33_sovereign_6 = r33_sovereign_6;
	}
	public BigDecimal getR33_others_7() {
		return r33_others_7;
	}
	public void setR33_others_7(BigDecimal r33_others_7) {
		this.r33_others_7 = r33_others_7;
	}
	public BigDecimal getR33_sovereign_8() {
		return r33_sovereign_8;
	}
	public void setR33_sovereign_8(BigDecimal r33_sovereign_8) {
		this.r33_sovereign_8 = r33_sovereign_8;
	}
	public BigDecimal getR33_others_9() {
		return r33_others_9;
	}
	public void setR33_others_9(BigDecimal r33_others_9) {
		this.r33_others_9 = r33_others_9;
	}
	public BigDecimal getR33_sovereign_10() {
		return r33_sovereign_10;
	}
	public void setR33_sovereign_10(BigDecimal r33_sovereign_10) {
		this.r33_sovereign_10 = r33_sovereign_10;
	}
	public BigDecimal getR33_others_11() {
		return r33_others_11;
	}
	public void setR33_others_11(BigDecimal r33_others_11) {
		this.r33_others_11 = r33_others_11;
	}
	public BigDecimal getR33_sovereign_12() {
		return r33_sovereign_12;
	}
	public void setR33_sovereign_12(BigDecimal r33_sovereign_12) {
		this.r33_sovereign_12 = r33_sovereign_12;
	}
	public BigDecimal getR33_others_13() {
		return r33_others_13;
	}
	public void setR33_others_13(BigDecimal r33_others_13) {
		this.r33_others_13 = r33_others_13;
	}
	public BigDecimal getR33_rated_14() {
		return r33_rated_14;
	}
	public void setR33_rated_14(BigDecimal r33_rated_14) {
		this.r33_rated_14 = r33_rated_14;
	}
	public BigDecimal getR33_main_index_15() {
		return r33_main_index_15;
	}
	public void setR33_main_index_15(BigDecimal r33_main_index_15) {
		this.r33_main_index_15 = r33_main_index_15;
	}
	public BigDecimal getR33_other_equities_16() {
		return r33_other_equities_16;
	}
	public void setR33_other_equities_16(BigDecimal r33_other_equities_16) {
		this.r33_other_equities_16 = r33_other_equities_16;
	}
	public BigDecimal getR33_mutual_funds_17() {
		return r33_mutual_funds_17;
	}
	public void setR33_mutual_funds_17(BigDecimal r33_mutual_funds_17) {
		this.r33_mutual_funds_17 = r33_mutual_funds_17;
	}
	public BigDecimal getR33_total_collateral_19() {
		return r33_total_collateral_19;
	}
	public void setR33_total_collateral_19(BigDecimal r33_total_collateral_19) {
		this.r33_total_collateral_19 = r33_total_collateral_19;
	}
	public BigDecimal getR33_net_collateral_20() {
		return r33_net_collateral_20;
	}
	public void setR33_net_collateral_20(BigDecimal r33_net_collateral_20) {
		this.r33_net_collateral_20 = r33_net_collateral_20;
	}
	public BigDecimal getR33_net_collateral_21() {
		return r33_net_collateral_21;
	}
	public void setR33_net_collateral_21(BigDecimal r33_net_collateral_21) {
		this.r33_net_collateral_21 = r33_net_collateral_21;
	}
	public String getR34_sub_total() {
		return r34_sub_total;
	}
	public void setR34_sub_total(String r34_sub_total) {
		this.r34_sub_total = r34_sub_total;
	}
	public BigDecimal getR34_total_exposure() {
		return r34_total_exposure;
	}
	public void setR34_total_exposure(BigDecimal r34_total_exposure) {
		this.r34_total_exposure = r34_total_exposure;
	}
	public BigDecimal getR34_cash_1() {
		return r34_cash_1;
	}
	public void setR34_cash_1(BigDecimal r34_cash_1) {
		this.r34_cash_1 = r34_cash_1;
	}
	public BigDecimal getR34_sovereign_2() {
		return r34_sovereign_2;
	}
	public void setR34_sovereign_2(BigDecimal r34_sovereign_2) {
		this.r34_sovereign_2 = r34_sovereign_2;
	}
	public BigDecimal getR34_others_3() {
		return r34_others_3;
	}
	public void setR34_others_3(BigDecimal r34_others_3) {
		this.r34_others_3 = r34_others_3;
	}
	public BigDecimal getR34_sovereign_4() {
		return r34_sovereign_4;
	}
	public void setR34_sovereign_4(BigDecimal r34_sovereign_4) {
		this.r34_sovereign_4 = r34_sovereign_4;
	}
	public BigDecimal getR34_others_5() {
		return r34_others_5;
	}
	public void setR34_others_5(BigDecimal r34_others_5) {
		this.r34_others_5 = r34_others_5;
	}
	public BigDecimal getR34_sovereign_6() {
		return r34_sovereign_6;
	}
	public void setR34_sovereign_6(BigDecimal r34_sovereign_6) {
		this.r34_sovereign_6 = r34_sovereign_6;
	}
	public BigDecimal getR34_others_7() {
		return r34_others_7;
	}
	public void setR34_others_7(BigDecimal r34_others_7) {
		this.r34_others_7 = r34_others_7;
	}
	public BigDecimal getR34_sovereign_8() {
		return r34_sovereign_8;
	}
	public void setR34_sovereign_8(BigDecimal r34_sovereign_8) {
		this.r34_sovereign_8 = r34_sovereign_8;
	}
	public BigDecimal getR34_others_9() {
		return r34_others_9;
	}
	public void setR34_others_9(BigDecimal r34_others_9) {
		this.r34_others_9 = r34_others_9;
	}
	public BigDecimal getR34_sovereign_10() {
		return r34_sovereign_10;
	}
	public void setR34_sovereign_10(BigDecimal r34_sovereign_10) {
		this.r34_sovereign_10 = r34_sovereign_10;
	}
	public BigDecimal getR34_others_11() {
		return r34_others_11;
	}
	public void setR34_others_11(BigDecimal r34_others_11) {
		this.r34_others_11 = r34_others_11;
	}
	public BigDecimal getR34_sovereign_12() {
		return r34_sovereign_12;
	}
	public void setR34_sovereign_12(BigDecimal r34_sovereign_12) {
		this.r34_sovereign_12 = r34_sovereign_12;
	}
	public BigDecimal getR34_others_13() {
		return r34_others_13;
	}
	public void setR34_others_13(BigDecimal r34_others_13) {
		this.r34_others_13 = r34_others_13;
	}
	public BigDecimal getR34_rated_14() {
		return r34_rated_14;
	}
	public void setR34_rated_14(BigDecimal r34_rated_14) {
		this.r34_rated_14 = r34_rated_14;
	}
	public BigDecimal getR34_main_index_15() {
		return r34_main_index_15;
	}
	public void setR34_main_index_15(BigDecimal r34_main_index_15) {
		this.r34_main_index_15 = r34_main_index_15;
	}
	public BigDecimal getR34_other_equities_16() {
		return r34_other_equities_16;
	}
	public void setR34_other_equities_16(BigDecimal r34_other_equities_16) {
		this.r34_other_equities_16 = r34_other_equities_16;
	}
	public BigDecimal getR34_mutual_funds_17() {
		return r34_mutual_funds_17;
	}
	public void setR34_mutual_funds_17(BigDecimal r34_mutual_funds_17) {
		this.r34_mutual_funds_17 = r34_mutual_funds_17;
	}
	public BigDecimal getR34_total_collateral_19() {
		return r34_total_collateral_19;
	}
	public void setR34_total_collateral_19(BigDecimal r34_total_collateral_19) {
		this.r34_total_collateral_19 = r34_total_collateral_19;
	}
	public BigDecimal getR34_net_collateral_20() {
		return r34_net_collateral_20;
	}
	public void setR34_net_collateral_20(BigDecimal r34_net_collateral_20) {
		this.r34_net_collateral_20 = r34_net_collateral_20;
	}
	public BigDecimal getR34_net_collateral_21() {
		return r34_net_collateral_21;
	}
	public void setR34_net_collateral_21(BigDecimal r34_net_collateral_21) {
		this.r34_net_collateral_21 = r34_net_collateral_21;
	}
	public String getR35_total_sovereign() {
		return r35_total_sovereign;
	}
	public void setR35_total_sovereign(String r35_total_sovereign) {
		this.r35_total_sovereign = r35_total_sovereign;
	}
	public BigDecimal getR35_total_exposure() {
		return r35_total_exposure;
	}
	public void setR35_total_exposure(BigDecimal r35_total_exposure) {
		this.r35_total_exposure = r35_total_exposure;
	}
	public BigDecimal getR35_cash_1() {
		return r35_cash_1;
	}
	public void setR35_cash_1(BigDecimal r35_cash_1) {
		this.r35_cash_1 = r35_cash_1;
	}
	public BigDecimal getR35_sovereign_2() {
		return r35_sovereign_2;
	}
	public void setR35_sovereign_2(BigDecimal r35_sovereign_2) {
		this.r35_sovereign_2 = r35_sovereign_2;
	}
	public BigDecimal getR35_others_3() {
		return r35_others_3;
	}
	public void setR35_others_3(BigDecimal r35_others_3) {
		this.r35_others_3 = r35_others_3;
	}
	public BigDecimal getR35_sovereign_4() {
		return r35_sovereign_4;
	}
	public void setR35_sovereign_4(BigDecimal r35_sovereign_4) {
		this.r35_sovereign_4 = r35_sovereign_4;
	}
	public BigDecimal getR35_others_5() {
		return r35_others_5;
	}
	public void setR35_others_5(BigDecimal r35_others_5) {
		this.r35_others_5 = r35_others_5;
	}
	public BigDecimal getR35_sovereign_6() {
		return r35_sovereign_6;
	}
	public void setR35_sovereign_6(BigDecimal r35_sovereign_6) {
		this.r35_sovereign_6 = r35_sovereign_6;
	}
	public BigDecimal getR35_others_7() {
		return r35_others_7;
	}
	public void setR35_others_7(BigDecimal r35_others_7) {
		this.r35_others_7 = r35_others_7;
	}
	public BigDecimal getR35_sovereign_8() {
		return r35_sovereign_8;
	}
	public void setR35_sovereign_8(BigDecimal r35_sovereign_8) {
		this.r35_sovereign_8 = r35_sovereign_8;
	}
	public BigDecimal getR35_others_9() {
		return r35_others_9;
	}
	public void setR35_others_9(BigDecimal r35_others_9) {
		this.r35_others_9 = r35_others_9;
	}
	public BigDecimal getR35_sovereign_10() {
		return r35_sovereign_10;
	}
	public void setR35_sovereign_10(BigDecimal r35_sovereign_10) {
		this.r35_sovereign_10 = r35_sovereign_10;
	}
	public BigDecimal getR35_others_11() {
		return r35_others_11;
	}
	public void setR35_others_11(BigDecimal r35_others_11) {
		this.r35_others_11 = r35_others_11;
	}
	public BigDecimal getR35_sovereign_12() {
		return r35_sovereign_12;
	}
	public void setR35_sovereign_12(BigDecimal r35_sovereign_12) {
		this.r35_sovereign_12 = r35_sovereign_12;
	}
	public BigDecimal getR35_others_13() {
		return r35_others_13;
	}
	public void setR35_others_13(BigDecimal r35_others_13) {
		this.r35_others_13 = r35_others_13;
	}
	public BigDecimal getR35_rated_14() {
		return r35_rated_14;
	}
	public void setR35_rated_14(BigDecimal r35_rated_14) {
		this.r35_rated_14 = r35_rated_14;
	}
	public BigDecimal getR35_main_index_15() {
		return r35_main_index_15;
	}
	public void setR35_main_index_15(BigDecimal r35_main_index_15) {
		this.r35_main_index_15 = r35_main_index_15;
	}
	public BigDecimal getR35_other_equities_16() {
		return r35_other_equities_16;
	}
	public void setR35_other_equities_16(BigDecimal r35_other_equities_16) {
		this.r35_other_equities_16 = r35_other_equities_16;
	}
	public BigDecimal getR35_mutual_funds_17() {
		return r35_mutual_funds_17;
	}
	public void setR35_mutual_funds_17(BigDecimal r35_mutual_funds_17) {
		this.r35_mutual_funds_17 = r35_mutual_funds_17;
	}
	public BigDecimal getR35_total_collateral_19() {
		return r35_total_collateral_19;
	}
	public void setR35_total_collateral_19(BigDecimal r35_total_collateral_19) {
		this.r35_total_collateral_19 = r35_total_collateral_19;
	}
	public BigDecimal getR35_net_collateral_20() {
		return r35_net_collateral_20;
	}
	public void setR35_net_collateral_20(BigDecimal r35_net_collateral_20) {
		this.r35_net_collateral_20 = r35_net_collateral_20;
	}
	public BigDecimal getR35_net_collateral_21() {
		return r35_net_collateral_21;
	}
	public void setR35_net_collateral_21(BigDecimal r35_net_collateral_21) {
		this.r35_net_collateral_21 = r35_net_collateral_21;
	}
	public String getR36_product() {
		return r36_product;
	}
	public void setR36_product(String r36_product) {
		this.r36_product = r36_product;
	}
	public String getR36_risk_weight() {
		return r36_risk_weight;
	}
	public void setR36_risk_weight(String r36_risk_weight) {
		this.r36_risk_weight = r36_risk_weight;
	}
	public BigDecimal getR36_total_exposure_0() {
		return r36_total_exposure_0;
	}
	public void setR36_total_exposure_0(BigDecimal r36_total_exposure_0) {
		this.r36_total_exposure_0 = r36_total_exposure_0;
	}
	public String getR37_risk_weight() {
		return r37_risk_weight;
	}
	public void setR37_risk_weight(String r37_risk_weight) {
		this.r37_risk_weight = r37_risk_weight;
	}
	public BigDecimal getR37_total_exposure_20() {
		return r37_total_exposure_20;
	}
	public void setR37_total_exposure_20(BigDecimal r37_total_exposure_20) {
		this.r37_total_exposure_20 = r37_total_exposure_20;
	}
	public BigDecimal getR37_cash_1() {
		return r37_cash_1;
	}
	public void setR37_cash_1(BigDecimal r37_cash_1) {
		this.r37_cash_1 = r37_cash_1;
	}
	public BigDecimal getR37_sovereign_2() {
		return r37_sovereign_2;
	}
	public void setR37_sovereign_2(BigDecimal r37_sovereign_2) {
		this.r37_sovereign_2 = r37_sovereign_2;
	}
	public BigDecimal getR37_others_3() {
		return r37_others_3;
	}
	public void setR37_others_3(BigDecimal r37_others_3) {
		this.r37_others_3 = r37_others_3;
	}
	public BigDecimal getR37_sovereign_4() {
		return r37_sovereign_4;
	}
	public void setR37_sovereign_4(BigDecimal r37_sovereign_4) {
		this.r37_sovereign_4 = r37_sovereign_4;
	}
	public BigDecimal getR37_others_5() {
		return r37_others_5;
	}
	public void setR37_others_5(BigDecimal r37_others_5) {
		this.r37_others_5 = r37_others_5;
	}
	public BigDecimal getR37_sovereign_6() {
		return r37_sovereign_6;
	}
	public void setR37_sovereign_6(BigDecimal r37_sovereign_6) {
		this.r37_sovereign_6 = r37_sovereign_6;
	}
	public BigDecimal getR37_others_7() {
		return r37_others_7;
	}
	public void setR37_others_7(BigDecimal r37_others_7) {
		this.r37_others_7 = r37_others_7;
	}
	public BigDecimal getR37_sovereign_8() {
		return r37_sovereign_8;
	}
	public void setR37_sovereign_8(BigDecimal r37_sovereign_8) {
		this.r37_sovereign_8 = r37_sovereign_8;
	}
	public BigDecimal getR37_others_9() {
		return r37_others_9;
	}
	public void setR37_others_9(BigDecimal r37_others_9) {
		this.r37_others_9 = r37_others_9;
	}
	public BigDecimal getR37_sovereign_10() {
		return r37_sovereign_10;
	}
	public void setR37_sovereign_10(BigDecimal r37_sovereign_10) {
		this.r37_sovereign_10 = r37_sovereign_10;
	}
	public BigDecimal getR37_others_11() {
		return r37_others_11;
	}
	public void setR37_others_11(BigDecimal r37_others_11) {
		this.r37_others_11 = r37_others_11;
	}
	public BigDecimal getR37_sovereign_12() {
		return r37_sovereign_12;
	}
	public void setR37_sovereign_12(BigDecimal r37_sovereign_12) {
		this.r37_sovereign_12 = r37_sovereign_12;
	}
	public BigDecimal getR37_others_13() {
		return r37_others_13;
	}
	public void setR37_others_13(BigDecimal r37_others_13) {
		this.r37_others_13 = r37_others_13;
	}
	public BigDecimal getR37_rated_14() {
		return r37_rated_14;
	}
	public void setR37_rated_14(BigDecimal r37_rated_14) {
		this.r37_rated_14 = r37_rated_14;
	}
	public BigDecimal getR37_main_index_15() {
		return r37_main_index_15;
	}
	public void setR37_main_index_15(BigDecimal r37_main_index_15) {
		this.r37_main_index_15 = r37_main_index_15;
	}
	public BigDecimal getR37_other_equities_16() {
		return r37_other_equities_16;
	}
	public void setR37_other_equities_16(BigDecimal r37_other_equities_16) {
		this.r37_other_equities_16 = r37_other_equities_16;
	}
	public BigDecimal getR37_mutual_funds_17() {
		return r37_mutual_funds_17;
	}
	public void setR37_mutual_funds_17(BigDecimal r37_mutual_funds_17) {
		this.r37_mutual_funds_17 = r37_mutual_funds_17;
	}
	public BigDecimal getR37_other_national_18() {
		return r37_other_national_18;
	}
	public void setR37_other_national_18(BigDecimal r37_other_national_18) {
		this.r37_other_national_18 = r37_other_national_18;
	}
	public BigDecimal getR37_total_collateral_19() {
		return r37_total_collateral_19;
	}
	public void setR37_total_collateral_19(BigDecimal r37_total_collateral_19) {
		this.r37_total_collateral_19 = r37_total_collateral_19;
	}
	public BigDecimal getR37_net_collateral_20() {
		return r37_net_collateral_20;
	}
	public void setR37_net_collateral_20(BigDecimal r37_net_collateral_20) {
		this.r37_net_collateral_20 = r37_net_collateral_20;
	}
	public BigDecimal getR37_net_collateral_21() {
		return r37_net_collateral_21;
	}
	public void setR37_net_collateral_21(BigDecimal r37_net_collateral_21) {
		this.r37_net_collateral_21 = r37_net_collateral_21;
	}
	public String getR38_risk_weight() {
		return r38_risk_weight;
	}
	public void setR38_risk_weight(String r38_risk_weight) {
		this.r38_risk_weight = r38_risk_weight;
	}
	public BigDecimal getR38_total_exposure_50() {
		return r38_total_exposure_50;
	}
	public void setR38_total_exposure_50(BigDecimal r38_total_exposure_50) {
		this.r38_total_exposure_50 = r38_total_exposure_50;
	}
	public BigDecimal getR38_cash_1() {
		return r38_cash_1;
	}
	public void setR38_cash_1(BigDecimal r38_cash_1) {
		this.r38_cash_1 = r38_cash_1;
	}
	public BigDecimal getR38_sovereign_2() {
		return r38_sovereign_2;
	}
	public void setR38_sovereign_2(BigDecimal r38_sovereign_2) {
		this.r38_sovereign_2 = r38_sovereign_2;
	}
	public BigDecimal getR38_others_3() {
		return r38_others_3;
	}
	public void setR38_others_3(BigDecimal r38_others_3) {
		this.r38_others_3 = r38_others_3;
	}
	public BigDecimal getR38_sovereign_4() {
		return r38_sovereign_4;
	}
	public void setR38_sovereign_4(BigDecimal r38_sovereign_4) {
		this.r38_sovereign_4 = r38_sovereign_4;
	}
	public BigDecimal getR38_others_5() {
		return r38_others_5;
	}
	public void setR38_others_5(BigDecimal r38_others_5) {
		this.r38_others_5 = r38_others_5;
	}
	public BigDecimal getR38_sovereign_6() {
		return r38_sovereign_6;
	}
	public void setR38_sovereign_6(BigDecimal r38_sovereign_6) {
		this.r38_sovereign_6 = r38_sovereign_6;
	}
	public BigDecimal getR38_others_7() {
		return r38_others_7;
	}
	public void setR38_others_7(BigDecimal r38_others_7) {
		this.r38_others_7 = r38_others_7;
	}
	public BigDecimal getR38_sovereign_8() {
		return r38_sovereign_8;
	}
	public void setR38_sovereign_8(BigDecimal r38_sovereign_8) {
		this.r38_sovereign_8 = r38_sovereign_8;
	}
	public BigDecimal getR38_others_9() {
		return r38_others_9;
	}
	public void setR38_others_9(BigDecimal r38_others_9) {
		this.r38_others_9 = r38_others_9;
	}
	public BigDecimal getR38_sovereign_10() {
		return r38_sovereign_10;
	}
	public void setR38_sovereign_10(BigDecimal r38_sovereign_10) {
		this.r38_sovereign_10 = r38_sovereign_10;
	}
	public BigDecimal getR38_others_11() {
		return r38_others_11;
	}
	public void setR38_others_11(BigDecimal r38_others_11) {
		this.r38_others_11 = r38_others_11;
	}
	public BigDecimal getR38_sovereign_12() {
		return r38_sovereign_12;
	}
	public void setR38_sovereign_12(BigDecimal r38_sovereign_12) {
		this.r38_sovereign_12 = r38_sovereign_12;
	}
	public BigDecimal getR38_others_13() {
		return r38_others_13;
	}
	public void setR38_others_13(BigDecimal r38_others_13) {
		this.r38_others_13 = r38_others_13;
	}
	public BigDecimal getR38_rated_14() {
		return r38_rated_14;
	}
	public void setR38_rated_14(BigDecimal r38_rated_14) {
		this.r38_rated_14 = r38_rated_14;
	}
	public BigDecimal getR38_main_index_15() {
		return r38_main_index_15;
	}
	public void setR38_main_index_15(BigDecimal r38_main_index_15) {
		this.r38_main_index_15 = r38_main_index_15;
	}
	public BigDecimal getR38_other_equities_16() {
		return r38_other_equities_16;
	}
	public void setR38_other_equities_16(BigDecimal r38_other_equities_16) {
		this.r38_other_equities_16 = r38_other_equities_16;
	}
	public BigDecimal getR38_mutual_funds_17() {
		return r38_mutual_funds_17;
	}
	public void setR38_mutual_funds_17(BigDecimal r38_mutual_funds_17) {
		this.r38_mutual_funds_17 = r38_mutual_funds_17;
	}
	public BigDecimal getR38_other_national_18() {
		return r38_other_national_18;
	}
	public void setR38_other_national_18(BigDecimal r38_other_national_18) {
		this.r38_other_national_18 = r38_other_national_18;
	}
	public BigDecimal getR38_total_collateral_19() {
		return r38_total_collateral_19;
	}
	public void setR38_total_collateral_19(BigDecimal r38_total_collateral_19) {
		this.r38_total_collateral_19 = r38_total_collateral_19;
	}
	public BigDecimal getR38_net_collateral_20() {
		return r38_net_collateral_20;
	}
	public void setR38_net_collateral_20(BigDecimal r38_net_collateral_20) {
		this.r38_net_collateral_20 = r38_net_collateral_20;
	}
	public BigDecimal getR38_net_collateral_21() {
		return r38_net_collateral_21;
	}
	public void setR38_net_collateral_21(BigDecimal r38_net_collateral_21) {
		this.r38_net_collateral_21 = r38_net_collateral_21;
	}
	public String getR39_risk_weight() {
		return r39_risk_weight;
	}
	public void setR39_risk_weight(String r39_risk_weight) {
		this.r39_risk_weight = r39_risk_weight;
	}
	public BigDecimal getR39_total_exposure_100() {
		return r39_total_exposure_100;
	}
	public void setR39_total_exposure_100(BigDecimal r39_total_exposure_100) {
		this.r39_total_exposure_100 = r39_total_exposure_100;
	}
	public BigDecimal getR39_cash_1() {
		return r39_cash_1;
	}
	public void setR39_cash_1(BigDecimal r39_cash_1) {
		this.r39_cash_1 = r39_cash_1;
	}
	public BigDecimal getR39_sovereign_2() {
		return r39_sovereign_2;
	}
	public void setR39_sovereign_2(BigDecimal r39_sovereign_2) {
		this.r39_sovereign_2 = r39_sovereign_2;
	}
	public BigDecimal getR39_others_3() {
		return r39_others_3;
	}
	public void setR39_others_3(BigDecimal r39_others_3) {
		this.r39_others_3 = r39_others_3;
	}
	public BigDecimal getR39_sovereign_4() {
		return r39_sovereign_4;
	}
	public void setR39_sovereign_4(BigDecimal r39_sovereign_4) {
		this.r39_sovereign_4 = r39_sovereign_4;
	}
	public BigDecimal getR39_others_5() {
		return r39_others_5;
	}
	public void setR39_others_5(BigDecimal r39_others_5) {
		this.r39_others_5 = r39_others_5;
	}
	public BigDecimal getR39_sovereign_6() {
		return r39_sovereign_6;
	}
	public void setR39_sovereign_6(BigDecimal r39_sovereign_6) {
		this.r39_sovereign_6 = r39_sovereign_6;
	}
	public BigDecimal getR39_others_7() {
		return r39_others_7;
	}
	public void setR39_others_7(BigDecimal r39_others_7) {
		this.r39_others_7 = r39_others_7;
	}
	public BigDecimal getR39_sovereign_8() {
		return r39_sovereign_8;
	}
	public void setR39_sovereign_8(BigDecimal r39_sovereign_8) {
		this.r39_sovereign_8 = r39_sovereign_8;
	}
	public BigDecimal getR39_others_9() {
		return r39_others_9;
	}
	public void setR39_others_9(BigDecimal r39_others_9) {
		this.r39_others_9 = r39_others_9;
	}
	public BigDecimal getR39_sovereign_10() {
		return r39_sovereign_10;
	}
	public void setR39_sovereign_10(BigDecimal r39_sovereign_10) {
		this.r39_sovereign_10 = r39_sovereign_10;
	}
	public BigDecimal getR39_others_11() {
		return r39_others_11;
	}
	public void setR39_others_11(BigDecimal r39_others_11) {
		this.r39_others_11 = r39_others_11;
	}
	public BigDecimal getR39_sovereign_12() {
		return r39_sovereign_12;
	}
	public void setR39_sovereign_12(BigDecimal r39_sovereign_12) {
		this.r39_sovereign_12 = r39_sovereign_12;
	}
	public BigDecimal getR39_others_13() {
		return r39_others_13;
	}
	public void setR39_others_13(BigDecimal r39_others_13) {
		this.r39_others_13 = r39_others_13;
	}
	public BigDecimal getR39_rated_14() {
		return r39_rated_14;
	}
	public void setR39_rated_14(BigDecimal r39_rated_14) {
		this.r39_rated_14 = r39_rated_14;
	}
	public BigDecimal getR39_main_index_15() {
		return r39_main_index_15;
	}
	public void setR39_main_index_15(BigDecimal r39_main_index_15) {
		this.r39_main_index_15 = r39_main_index_15;
	}
	public BigDecimal getR39_other_equities_16() {
		return r39_other_equities_16;
	}
	public void setR39_other_equities_16(BigDecimal r39_other_equities_16) {
		this.r39_other_equities_16 = r39_other_equities_16;
	}
	public BigDecimal getR39_mutual_funds_17() {
		return r39_mutual_funds_17;
	}
	public void setR39_mutual_funds_17(BigDecimal r39_mutual_funds_17) {
		this.r39_mutual_funds_17 = r39_mutual_funds_17;
	}
	public BigDecimal getR39_other_national_18() {
		return r39_other_national_18;
	}
	public void setR39_other_national_18(BigDecimal r39_other_national_18) {
		this.r39_other_national_18 = r39_other_national_18;
	}
	public BigDecimal getR39_total_collateral_19() {
		return r39_total_collateral_19;
	}
	public void setR39_total_collateral_19(BigDecimal r39_total_collateral_19) {
		this.r39_total_collateral_19 = r39_total_collateral_19;
	}
	public BigDecimal getR39_net_collateral_20() {
		return r39_net_collateral_20;
	}
	public void setR39_net_collateral_20(BigDecimal r39_net_collateral_20) {
		this.r39_net_collateral_20 = r39_net_collateral_20;
	}
	public BigDecimal getR39_net_collateral_21() {
		return r39_net_collateral_21;
	}
	public void setR39_net_collateral_21(BigDecimal r39_net_collateral_21) {
		this.r39_net_collateral_21 = r39_net_collateral_21;
	}
	public String getR40_risk_weight() {
		return r40_risk_weight;
	}
	public void setR40_risk_weight(String r40_risk_weight) {
		this.r40_risk_weight = r40_risk_weight;
	}
	public BigDecimal getR40_total_exposure_100() {
		return r40_total_exposure_100;
	}
	public void setR40_total_exposure_100(BigDecimal r40_total_exposure_100) {
		this.r40_total_exposure_100 = r40_total_exposure_100;
	}
	public BigDecimal getR40_cash_1() {
		return r40_cash_1;
	}
	public void setR40_cash_1(BigDecimal r40_cash_1) {
		this.r40_cash_1 = r40_cash_1;
	}
	public BigDecimal getR40_sovereign_2() {
		return r40_sovereign_2;
	}
	public void setR40_sovereign_2(BigDecimal r40_sovereign_2) {
		this.r40_sovereign_2 = r40_sovereign_2;
	}
	public BigDecimal getR40_others_3() {
		return r40_others_3;
	}
	public void setR40_others_3(BigDecimal r40_others_3) {
		this.r40_others_3 = r40_others_3;
	}
	public BigDecimal getR40_sovereign_4() {
		return r40_sovereign_4;
	}
	public void setR40_sovereign_4(BigDecimal r40_sovereign_4) {
		this.r40_sovereign_4 = r40_sovereign_4;
	}
	public BigDecimal getR40_others_5() {
		return r40_others_5;
	}
	public void setR40_others_5(BigDecimal r40_others_5) {
		this.r40_others_5 = r40_others_5;
	}
	public BigDecimal getR40_sovereign_6() {
		return r40_sovereign_6;
	}
	public void setR40_sovereign_6(BigDecimal r40_sovereign_6) {
		this.r40_sovereign_6 = r40_sovereign_6;
	}
	public BigDecimal getR40_others_7() {
		return r40_others_7;
	}
	public void setR40_others_7(BigDecimal r40_others_7) {
		this.r40_others_7 = r40_others_7;
	}
	public BigDecimal getR40_sovereign_8() {
		return r40_sovereign_8;
	}
	public void setR40_sovereign_8(BigDecimal r40_sovereign_8) {
		this.r40_sovereign_8 = r40_sovereign_8;
	}
	public BigDecimal getR40_others_9() {
		return r40_others_9;
	}
	public void setR40_others_9(BigDecimal r40_others_9) {
		this.r40_others_9 = r40_others_9;
	}
	public BigDecimal getR40_sovereign_10() {
		return r40_sovereign_10;
	}
	public void setR40_sovereign_10(BigDecimal r40_sovereign_10) {
		this.r40_sovereign_10 = r40_sovereign_10;
	}
	public BigDecimal getR40_others_11() {
		return r40_others_11;
	}
	public void setR40_others_11(BigDecimal r40_others_11) {
		this.r40_others_11 = r40_others_11;
	}
	public BigDecimal getR40_sovereign_12() {
		return r40_sovereign_12;
	}
	public void setR40_sovereign_12(BigDecimal r40_sovereign_12) {
		this.r40_sovereign_12 = r40_sovereign_12;
	}
	public BigDecimal getR40_others_13() {
		return r40_others_13;
	}
	public void setR40_others_13(BigDecimal r40_others_13) {
		this.r40_others_13 = r40_others_13;
	}
	public BigDecimal getR40_rated_14() {
		return r40_rated_14;
	}
	public void setR40_rated_14(BigDecimal r40_rated_14) {
		this.r40_rated_14 = r40_rated_14;
	}
	public BigDecimal getR40_main_index_15() {
		return r40_main_index_15;
	}
	public void setR40_main_index_15(BigDecimal r40_main_index_15) {
		this.r40_main_index_15 = r40_main_index_15;
	}
	public BigDecimal getR40_other_equities_16() {
		return r40_other_equities_16;
	}
	public void setR40_other_equities_16(BigDecimal r40_other_equities_16) {
		this.r40_other_equities_16 = r40_other_equities_16;
	}
	public BigDecimal getR40_mutual_funds_17() {
		return r40_mutual_funds_17;
	}
	public void setR40_mutual_funds_17(BigDecimal r40_mutual_funds_17) {
		this.r40_mutual_funds_17 = r40_mutual_funds_17;
	}
	public BigDecimal getR40_other_national_18() {
		return r40_other_national_18;
	}
	public void setR40_other_national_18(BigDecimal r40_other_national_18) {
		this.r40_other_national_18 = r40_other_national_18;
	}
	public BigDecimal getR40_total_collateral_19() {
		return r40_total_collateral_19;
	}
	public void setR40_total_collateral_19(BigDecimal r40_total_collateral_19) {
		this.r40_total_collateral_19 = r40_total_collateral_19;
	}
	public BigDecimal getR40_net_collateral_20() {
		return r40_net_collateral_20;
	}
	public void setR40_net_collateral_20(BigDecimal r40_net_collateral_20) {
		this.r40_net_collateral_20 = r40_net_collateral_20;
	}
	public BigDecimal getR40_net_collateral_21() {
		return r40_net_collateral_21;
	}
	public void setR40_net_collateral_21(BigDecimal r40_net_collateral_21) {
		this.r40_net_collateral_21 = r40_net_collateral_21;
	}
	public String getR41_risk_weight() {
		return r41_risk_weight;
	}
	public void setR41_risk_weight(String r41_risk_weight) {
		this.r41_risk_weight = r41_risk_weight;
	}
	public BigDecimal getR41_total_exposure_100() {
		return r41_total_exposure_100;
	}
	public void setR41_total_exposure_100(BigDecimal r41_total_exposure_100) {
		this.r41_total_exposure_100 = r41_total_exposure_100;
	}
	public BigDecimal getR41_cash_1() {
		return r41_cash_1;
	}
	public void setR41_cash_1(BigDecimal r41_cash_1) {
		this.r41_cash_1 = r41_cash_1;
	}
	public BigDecimal getR41_sovereign_2() {
		return r41_sovereign_2;
	}
	public void setR41_sovereign_2(BigDecimal r41_sovereign_2) {
		this.r41_sovereign_2 = r41_sovereign_2;
	}
	public BigDecimal getR41_others_3() {
		return r41_others_3;
	}
	public void setR41_others_3(BigDecimal r41_others_3) {
		this.r41_others_3 = r41_others_3;
	}
	public BigDecimal getR41_sovereign_4() {
		return r41_sovereign_4;
	}
	public void setR41_sovereign_4(BigDecimal r41_sovereign_4) {
		this.r41_sovereign_4 = r41_sovereign_4;
	}
	public BigDecimal getR41_others_5() {
		return r41_others_5;
	}
	public void setR41_others_5(BigDecimal r41_others_5) {
		this.r41_others_5 = r41_others_5;
	}
	public BigDecimal getR41_sovereign_6() {
		return r41_sovereign_6;
	}
	public void setR41_sovereign_6(BigDecimal r41_sovereign_6) {
		this.r41_sovereign_6 = r41_sovereign_6;
	}
	public BigDecimal getR41_others_7() {
		return r41_others_7;
	}
	public void setR41_others_7(BigDecimal r41_others_7) {
		this.r41_others_7 = r41_others_7;
	}
	public BigDecimal getR41_sovereign_8() {
		return r41_sovereign_8;
	}
	public void setR41_sovereign_8(BigDecimal r41_sovereign_8) {
		this.r41_sovereign_8 = r41_sovereign_8;
	}
	public BigDecimal getR41_others_9() {
		return r41_others_9;
	}
	public void setR41_others_9(BigDecimal r41_others_9) {
		this.r41_others_9 = r41_others_9;
	}
	public BigDecimal getR41_sovereign_10() {
		return r41_sovereign_10;
	}
	public void setR41_sovereign_10(BigDecimal r41_sovereign_10) {
		this.r41_sovereign_10 = r41_sovereign_10;
	}
	public BigDecimal getR41_others_11() {
		return r41_others_11;
	}
	public void setR41_others_11(BigDecimal r41_others_11) {
		this.r41_others_11 = r41_others_11;
	}
	public BigDecimal getR41_sovereign_12() {
		return r41_sovereign_12;
	}
	public void setR41_sovereign_12(BigDecimal r41_sovereign_12) {
		this.r41_sovereign_12 = r41_sovereign_12;
	}
	public BigDecimal getR41_others_13() {
		return r41_others_13;
	}
	public void setR41_others_13(BigDecimal r41_others_13) {
		this.r41_others_13 = r41_others_13;
	}
	public BigDecimal getR41_rated_14() {
		return r41_rated_14;
	}
	public void setR41_rated_14(BigDecimal r41_rated_14) {
		this.r41_rated_14 = r41_rated_14;
	}
	public BigDecimal getR41_main_index_15() {
		return r41_main_index_15;
	}
	public void setR41_main_index_15(BigDecimal r41_main_index_15) {
		this.r41_main_index_15 = r41_main_index_15;
	}
	public BigDecimal getR41_other_equities_16() {
		return r41_other_equities_16;
	}
	public void setR41_other_equities_16(BigDecimal r41_other_equities_16) {
		this.r41_other_equities_16 = r41_other_equities_16;
	}
	public BigDecimal getR41_mutual_funds_17() {
		return r41_mutual_funds_17;
	}
	public void setR41_mutual_funds_17(BigDecimal r41_mutual_funds_17) {
		this.r41_mutual_funds_17 = r41_mutual_funds_17;
	}
	public BigDecimal getR41_other_national_18() {
		return r41_other_national_18;
	}
	public void setR41_other_national_18(BigDecimal r41_other_national_18) {
		this.r41_other_national_18 = r41_other_national_18;
	}
	public BigDecimal getR41_total_collateral_19() {
		return r41_total_collateral_19;
	}
	public void setR41_total_collateral_19(BigDecimal r41_total_collateral_19) {
		this.r41_total_collateral_19 = r41_total_collateral_19;
	}
	public BigDecimal getR41_net_collateral_20() {
		return r41_net_collateral_20;
	}
	public void setR41_net_collateral_20(BigDecimal r41_net_collateral_20) {
		this.r41_net_collateral_20 = r41_net_collateral_20;
	}
	public BigDecimal getR41_net_collateral_21() {
		return r41_net_collateral_21;
	}
	public void setR41_net_collateral_21(BigDecimal r41_net_collateral_21) {
		this.r41_net_collateral_21 = r41_net_collateral_21;
	}
	public String getR42_sub_total() {
		return r42_sub_total;
	}
	public void setR42_sub_total(String r42_sub_total) {
		this.r42_sub_total = r42_sub_total;
	}
	public BigDecimal getR42_total_exposure() {
		return r42_total_exposure;
	}
	public void setR42_total_exposure(BigDecimal r42_total_exposure) {
		this.r42_total_exposure = r42_total_exposure;
	}
	public BigDecimal getR42_cash_1() {
		return r42_cash_1;
	}
	public void setR42_cash_1(BigDecimal r42_cash_1) {
		this.r42_cash_1 = r42_cash_1;
	}
	public BigDecimal getR42_sovereign_2() {
		return r42_sovereign_2;
	}
	public void setR42_sovereign_2(BigDecimal r42_sovereign_2) {
		this.r42_sovereign_2 = r42_sovereign_2;
	}
	public BigDecimal getR42_others_3() {
		return r42_others_3;
	}
	public void setR42_others_3(BigDecimal r42_others_3) {
		this.r42_others_3 = r42_others_3;
	}
	public BigDecimal getR42_sovereign_4() {
		return r42_sovereign_4;
	}
	public void setR42_sovereign_4(BigDecimal r42_sovereign_4) {
		this.r42_sovereign_4 = r42_sovereign_4;
	}
	public BigDecimal getR42_others_5() {
		return r42_others_5;
	}
	public void setR42_others_5(BigDecimal r42_others_5) {
		this.r42_others_5 = r42_others_5;
	}
	public BigDecimal getR42_sovereign_6() {
		return r42_sovereign_6;
	}
	public void setR42_sovereign_6(BigDecimal r42_sovereign_6) {
		this.r42_sovereign_6 = r42_sovereign_6;
	}
	public BigDecimal getR42_others_7() {
		return r42_others_7;
	}
	public void setR42_others_7(BigDecimal r42_others_7) {
		this.r42_others_7 = r42_others_7;
	}
	public BigDecimal getR42_sovereign_8() {
		return r42_sovereign_8;
	}
	public void setR42_sovereign_8(BigDecimal r42_sovereign_8) {
		this.r42_sovereign_8 = r42_sovereign_8;
	}
	public BigDecimal getR42_others_9() {
		return r42_others_9;
	}
	public void setR42_others_9(BigDecimal r42_others_9) {
		this.r42_others_9 = r42_others_9;
	}
	public BigDecimal getR42_sovereign_10() {
		return r42_sovereign_10;
	}
	public void setR42_sovereign_10(BigDecimal r42_sovereign_10) {
		this.r42_sovereign_10 = r42_sovereign_10;
	}
	public BigDecimal getR42_others_11() {
		return r42_others_11;
	}
	public void setR42_others_11(BigDecimal r42_others_11) {
		this.r42_others_11 = r42_others_11;
	}
	public BigDecimal getR42_sovereign_12() {
		return r42_sovereign_12;
	}
	public void setR42_sovereign_12(BigDecimal r42_sovereign_12) {
		this.r42_sovereign_12 = r42_sovereign_12;
	}
	public BigDecimal getR42_others_13() {
		return r42_others_13;
	}
	public void setR42_others_13(BigDecimal r42_others_13) {
		this.r42_others_13 = r42_others_13;
	}
	public BigDecimal getR42_rated_14() {
		return r42_rated_14;
	}
	public void setR42_rated_14(BigDecimal r42_rated_14) {
		this.r42_rated_14 = r42_rated_14;
	}
	public BigDecimal getR42_main_index_15() {
		return r42_main_index_15;
	}
	public void setR42_main_index_15(BigDecimal r42_main_index_15) {
		this.r42_main_index_15 = r42_main_index_15;
	}
	public BigDecimal getR42_other_equities_16() {
		return r42_other_equities_16;
	}
	public void setR42_other_equities_16(BigDecimal r42_other_equities_16) {
		this.r42_other_equities_16 = r42_other_equities_16;
	}
	public BigDecimal getR42_mutual_funds_17() {
		return r42_mutual_funds_17;
	}
	public void setR42_mutual_funds_17(BigDecimal r42_mutual_funds_17) {
		this.r42_mutual_funds_17 = r42_mutual_funds_17;
	}
	public BigDecimal getR42_other_national_18() {
		return r42_other_national_18;
	}
	public void setR42_other_national_18(BigDecimal r42_other_national_18) {
		this.r42_other_national_18 = r42_other_national_18;
	}
	public BigDecimal getR42_total_collateral_19() {
		return r42_total_collateral_19;
	}
	public void setR42_total_collateral_19(BigDecimal r42_total_collateral_19) {
		this.r42_total_collateral_19 = r42_total_collateral_19;
	}
	public BigDecimal getR42_net_collateral_20() {
		return r42_net_collateral_20;
	}
	public void setR42_net_collateral_20(BigDecimal r42_net_collateral_20) {
		this.r42_net_collateral_20 = r42_net_collateral_20;
	}
	public BigDecimal getR42_net_collateral_21() {
		return r42_net_collateral_21;
	}
	public void setR42_net_collateral_21(BigDecimal r42_net_collateral_21) {
		this.r42_net_collateral_21 = r42_net_collateral_21;
	}
	public String getR43_product() {
		return r43_product;
	}
	public void setR43_product(String r43_product) {
		this.r43_product = r43_product;
	}
	public String getR43_risk_weight() {
		return r43_risk_weight;
	}
	public void setR43_risk_weight(String r43_risk_weight) {
		this.r43_risk_weight = r43_risk_weight;
	}
	public BigDecimal getR43_total_exposure_0() {
		return r43_total_exposure_0;
	}
	public void setR43_total_exposure_0(BigDecimal r43_total_exposure_0) {
		this.r43_total_exposure_0 = r43_total_exposure_0;
	}
	public String getR44_risk_weight() {
		return r44_risk_weight;
	}
	public void setR44_risk_weight(String r44_risk_weight) {
		this.r44_risk_weight = r44_risk_weight;
	}
	public BigDecimal getR44_total_exposure_20() {
		return r44_total_exposure_20;
	}
	public void setR44_total_exposure_20(BigDecimal r44_total_exposure_20) {
		this.r44_total_exposure_20 = r44_total_exposure_20;
	}
	public BigDecimal getR44_cash_1() {
		return r44_cash_1;
	}
	public void setR44_cash_1(BigDecimal r44_cash_1) {
		this.r44_cash_1 = r44_cash_1;
	}
	public BigDecimal getR44_sovereign_2() {
		return r44_sovereign_2;
	}
	public void setR44_sovereign_2(BigDecimal r44_sovereign_2) {
		this.r44_sovereign_2 = r44_sovereign_2;
	}
	public BigDecimal getR44_others_3() {
		return r44_others_3;
	}
	public void setR44_others_3(BigDecimal r44_others_3) {
		this.r44_others_3 = r44_others_3;
	}
	public BigDecimal getR44_sovereign_4() {
		return r44_sovereign_4;
	}
	public void setR44_sovereign_4(BigDecimal r44_sovereign_4) {
		this.r44_sovereign_4 = r44_sovereign_4;
	}
	public BigDecimal getR44_others_5() {
		return r44_others_5;
	}
	public void setR44_others_5(BigDecimal r44_others_5) {
		this.r44_others_5 = r44_others_5;
	}
	public BigDecimal getR44_sovereign_6() {
		return r44_sovereign_6;
	}
	public void setR44_sovereign_6(BigDecimal r44_sovereign_6) {
		this.r44_sovereign_6 = r44_sovereign_6;
	}
	public BigDecimal getR44_others_7() {
		return r44_others_7;
	}
	public void setR44_others_7(BigDecimal r44_others_7) {
		this.r44_others_7 = r44_others_7;
	}
	public BigDecimal getR44_sovereign_8() {
		return r44_sovereign_8;
	}
	public void setR44_sovereign_8(BigDecimal r44_sovereign_8) {
		this.r44_sovereign_8 = r44_sovereign_8;
	}
	public BigDecimal getR44_others_9() {
		return r44_others_9;
	}
	public void setR44_others_9(BigDecimal r44_others_9) {
		this.r44_others_9 = r44_others_9;
	}
	public BigDecimal getR44_sovereign_10() {
		return r44_sovereign_10;
	}
	public void setR44_sovereign_10(BigDecimal r44_sovereign_10) {
		this.r44_sovereign_10 = r44_sovereign_10;
	}
	public BigDecimal getR44_others_11() {
		return r44_others_11;
	}
	public void setR44_others_11(BigDecimal r44_others_11) {
		this.r44_others_11 = r44_others_11;
	}
	public BigDecimal getR44_sovereign_12() {
		return r44_sovereign_12;
	}
	public void setR44_sovereign_12(BigDecimal r44_sovereign_12) {
		this.r44_sovereign_12 = r44_sovereign_12;
	}
	public BigDecimal getR44_others_13() {
		return r44_others_13;
	}
	public void setR44_others_13(BigDecimal r44_others_13) {
		this.r44_others_13 = r44_others_13;
	}
	public BigDecimal getR44_rated_14() {
		return r44_rated_14;
	}
	public void setR44_rated_14(BigDecimal r44_rated_14) {
		this.r44_rated_14 = r44_rated_14;
	}
	public BigDecimal getR44_main_index_15() {
		return r44_main_index_15;
	}
	public void setR44_main_index_15(BigDecimal r44_main_index_15) {
		this.r44_main_index_15 = r44_main_index_15;
	}
	public BigDecimal getR44_other_equities_16() {
		return r44_other_equities_16;
	}
	public void setR44_other_equities_16(BigDecimal r44_other_equities_16) {
		this.r44_other_equities_16 = r44_other_equities_16;
	}
	public BigDecimal getR44_mutual_funds_17() {
		return r44_mutual_funds_17;
	}
	public void setR44_mutual_funds_17(BigDecimal r44_mutual_funds_17) {
		this.r44_mutual_funds_17 = r44_mutual_funds_17;
	}
	public BigDecimal getR44_other_national_18() {
		return r44_other_national_18;
	}
	public void setR44_other_national_18(BigDecimal r44_other_national_18) {
		this.r44_other_national_18 = r44_other_national_18;
	}
	public BigDecimal getR44_total_collateral_19() {
		return r44_total_collateral_19;
	}
	public void setR44_total_collateral_19(BigDecimal r44_total_collateral_19) {
		this.r44_total_collateral_19 = r44_total_collateral_19;
	}
	public BigDecimal getR44_net_collateral_20() {
		return r44_net_collateral_20;
	}
	public void setR44_net_collateral_20(BigDecimal r44_net_collateral_20) {
		this.r44_net_collateral_20 = r44_net_collateral_20;
	}
	public BigDecimal getR44_net_collateral_21() {
		return r44_net_collateral_21;
	}
	public void setR44_net_collateral_21(BigDecimal r44_net_collateral_21) {
		this.r44_net_collateral_21 = r44_net_collateral_21;
	}
	public String getR45_risk_weight() {
		return r45_risk_weight;
	}
	public void setR45_risk_weight(String r45_risk_weight) {
		this.r45_risk_weight = r45_risk_weight;
	}
	public BigDecimal getR45_total_exposure_50() {
		return r45_total_exposure_50;
	}
	public void setR45_total_exposure_50(BigDecimal r45_total_exposure_50) {
		this.r45_total_exposure_50 = r45_total_exposure_50;
	}
	public BigDecimal getR45_cash_1() {
		return r45_cash_1;
	}
	public void setR45_cash_1(BigDecimal r45_cash_1) {
		this.r45_cash_1 = r45_cash_1;
	}
	public BigDecimal getR45_sovereign_2() {
		return r45_sovereign_2;
	}
	public void setR45_sovereign_2(BigDecimal r45_sovereign_2) {
		this.r45_sovereign_2 = r45_sovereign_2;
	}
	public BigDecimal getR45_others_3() {
		return r45_others_3;
	}
	public void setR45_others_3(BigDecimal r45_others_3) {
		this.r45_others_3 = r45_others_3;
	}
	public BigDecimal getR45_sovereign_4() {
		return r45_sovereign_4;
	}
	public void setR45_sovereign_4(BigDecimal r45_sovereign_4) {
		this.r45_sovereign_4 = r45_sovereign_4;
	}
	public BigDecimal getR45_others_5() {
		return r45_others_5;
	}
	public void setR45_others_5(BigDecimal r45_others_5) {
		this.r45_others_5 = r45_others_5;
	}
	public BigDecimal getR45_sovereign_6() {
		return r45_sovereign_6;
	}
	public void setR45_sovereign_6(BigDecimal r45_sovereign_6) {
		this.r45_sovereign_6 = r45_sovereign_6;
	}
	public BigDecimal getR45_others_7() {
		return r45_others_7;
	}
	public void setR45_others_7(BigDecimal r45_others_7) {
		this.r45_others_7 = r45_others_7;
	}
	public BigDecimal getR45_sovereign_8() {
		return r45_sovereign_8;
	}
	public void setR45_sovereign_8(BigDecimal r45_sovereign_8) {
		this.r45_sovereign_8 = r45_sovereign_8;
	}
	public BigDecimal getR45_others_9() {
		return r45_others_9;
	}
	public void setR45_others_9(BigDecimal r45_others_9) {
		this.r45_others_9 = r45_others_9;
	}
	public BigDecimal getR45_sovereign_10() {
		return r45_sovereign_10;
	}
	public void setR45_sovereign_10(BigDecimal r45_sovereign_10) {
		this.r45_sovereign_10 = r45_sovereign_10;
	}
	public BigDecimal getR45_others_11() {
		return r45_others_11;
	}
	public void setR45_others_11(BigDecimal r45_others_11) {
		this.r45_others_11 = r45_others_11;
	}
	public BigDecimal getR45_sovereign_12() {
		return r45_sovereign_12;
	}
	public void setR45_sovereign_12(BigDecimal r45_sovereign_12) {
		this.r45_sovereign_12 = r45_sovereign_12;
	}
	public BigDecimal getR45_others_13() {
		return r45_others_13;
	}
	public void setR45_others_13(BigDecimal r45_others_13) {
		this.r45_others_13 = r45_others_13;
	}
	public BigDecimal getR45_rated_14() {
		return r45_rated_14;
	}
	public void setR45_rated_14(BigDecimal r45_rated_14) {
		this.r45_rated_14 = r45_rated_14;
	}
	public BigDecimal getR45_main_index_15() {
		return r45_main_index_15;
	}
	public void setR45_main_index_15(BigDecimal r45_main_index_15) {
		this.r45_main_index_15 = r45_main_index_15;
	}
	public BigDecimal getR45_other_equities_16() {
		return r45_other_equities_16;
	}
	public void setR45_other_equities_16(BigDecimal r45_other_equities_16) {
		this.r45_other_equities_16 = r45_other_equities_16;
	}
	public BigDecimal getR45_mutual_funds_17() {
		return r45_mutual_funds_17;
	}
	public void setR45_mutual_funds_17(BigDecimal r45_mutual_funds_17) {
		this.r45_mutual_funds_17 = r45_mutual_funds_17;
	}
	public BigDecimal getR45_other_national_18() {
		return r45_other_national_18;
	}
	public void setR45_other_national_18(BigDecimal r45_other_national_18) {
		this.r45_other_national_18 = r45_other_national_18;
	}
	public BigDecimal getR45_total_collateral_19() {
		return r45_total_collateral_19;
	}
	public void setR45_total_collateral_19(BigDecimal r45_total_collateral_19) {
		this.r45_total_collateral_19 = r45_total_collateral_19;
	}
	public BigDecimal getR45_net_collateral_20() {
		return r45_net_collateral_20;
	}
	public void setR45_net_collateral_20(BigDecimal r45_net_collateral_20) {
		this.r45_net_collateral_20 = r45_net_collateral_20;
	}
	public BigDecimal getR45_net_collateral_21() {
		return r45_net_collateral_21;
	}
	public void setR45_net_collateral_21(BigDecimal r45_net_collateral_21) {
		this.r45_net_collateral_21 = r45_net_collateral_21;
	}
	public String getR46_risk_weight() {
		return r46_risk_weight;
	}
	public void setR46_risk_weight(String r46_risk_weight) {
		this.r46_risk_weight = r46_risk_weight;
	}
	public BigDecimal getR46_total_exposure_100() {
		return r46_total_exposure_100;
	}
	public void setR46_total_exposure_100(BigDecimal r46_total_exposure_100) {
		this.r46_total_exposure_100 = r46_total_exposure_100;
	}
	public BigDecimal getR46_cash_1() {
		return r46_cash_1;
	}
	public void setR46_cash_1(BigDecimal r46_cash_1) {
		this.r46_cash_1 = r46_cash_1;
	}
	public BigDecimal getR46_sovereign_2() {
		return r46_sovereign_2;
	}
	public void setR46_sovereign_2(BigDecimal r46_sovereign_2) {
		this.r46_sovereign_2 = r46_sovereign_2;
	}
	public BigDecimal getR46_others_3() {
		return r46_others_3;
	}
	public void setR46_others_3(BigDecimal r46_others_3) {
		this.r46_others_3 = r46_others_3;
	}
	public BigDecimal getR46_sovereign_4() {
		return r46_sovereign_4;
	}
	public void setR46_sovereign_4(BigDecimal r46_sovereign_4) {
		this.r46_sovereign_4 = r46_sovereign_4;
	}
	public BigDecimal getR46_others_5() {
		return r46_others_5;
	}
	public void setR46_others_5(BigDecimal r46_others_5) {
		this.r46_others_5 = r46_others_5;
	}
	public BigDecimal getR46_sovereign_6() {
		return r46_sovereign_6;
	}
	public void setR46_sovereign_6(BigDecimal r46_sovereign_6) {
		this.r46_sovereign_6 = r46_sovereign_6;
	}
	public BigDecimal getR46_others_7() {
		return r46_others_7;
	}
	public void setR46_others_7(BigDecimal r46_others_7) {
		this.r46_others_7 = r46_others_7;
	}
	public BigDecimal getR46_sovereign_8() {
		return r46_sovereign_8;
	}
	public void setR46_sovereign_8(BigDecimal r46_sovereign_8) {
		this.r46_sovereign_8 = r46_sovereign_8;
	}
	public BigDecimal getR46_others_9() {
		return r46_others_9;
	}
	public void setR46_others_9(BigDecimal r46_others_9) {
		this.r46_others_9 = r46_others_9;
	}
	public BigDecimal getR46_sovereign_10() {
		return r46_sovereign_10;
	}
	public void setR46_sovereign_10(BigDecimal r46_sovereign_10) {
		this.r46_sovereign_10 = r46_sovereign_10;
	}
	public BigDecimal getR46_others_11() {
		return r46_others_11;
	}
	public void setR46_others_11(BigDecimal r46_others_11) {
		this.r46_others_11 = r46_others_11;
	}
	public BigDecimal getR46_sovereign_12() {
		return r46_sovereign_12;
	}
	public void setR46_sovereign_12(BigDecimal r46_sovereign_12) {
		this.r46_sovereign_12 = r46_sovereign_12;
	}
	public BigDecimal getR46_others_13() {
		return r46_others_13;
	}
	public void setR46_others_13(BigDecimal r46_others_13) {
		this.r46_others_13 = r46_others_13;
	}
	public BigDecimal getR46_rated_14() {
		return r46_rated_14;
	}
	public void setR46_rated_14(BigDecimal r46_rated_14) {
		this.r46_rated_14 = r46_rated_14;
	}
	public BigDecimal getR46_main_index_15() {
		return r46_main_index_15;
	}
	public void setR46_main_index_15(BigDecimal r46_main_index_15) {
		this.r46_main_index_15 = r46_main_index_15;
	}
	public BigDecimal getR46_other_equities_16() {
		return r46_other_equities_16;
	}
	public void setR46_other_equities_16(BigDecimal r46_other_equities_16) {
		this.r46_other_equities_16 = r46_other_equities_16;
	}
	public BigDecimal getR46_mutual_funds_17() {
		return r46_mutual_funds_17;
	}
	public void setR46_mutual_funds_17(BigDecimal r46_mutual_funds_17) {
		this.r46_mutual_funds_17 = r46_mutual_funds_17;
	}
	public BigDecimal getR46_other_national_18() {
		return r46_other_national_18;
	}
	public void setR46_other_national_18(BigDecimal r46_other_national_18) {
		this.r46_other_national_18 = r46_other_national_18;
	}
	public BigDecimal getR46_total_collateral_19() {
		return r46_total_collateral_19;
	}
	public void setR46_total_collateral_19(BigDecimal r46_total_collateral_19) {
		this.r46_total_collateral_19 = r46_total_collateral_19;
	}
	public BigDecimal getR46_net_collateral_20() {
		return r46_net_collateral_20;
	}
	public void setR46_net_collateral_20(BigDecimal r46_net_collateral_20) {
		this.r46_net_collateral_20 = r46_net_collateral_20;
	}
	public BigDecimal getR46_net_collateral_21() {
		return r46_net_collateral_21;
	}
	public void setR46_net_collateral_21(BigDecimal r46_net_collateral_21) {
		this.r46_net_collateral_21 = r46_net_collateral_21;
	}
	public String getR47_risk_weight() {
		return r47_risk_weight;
	}
	public void setR47_risk_weight(String r47_risk_weight) {
		this.r47_risk_weight = r47_risk_weight;
	}
	public BigDecimal getR47_total_exposure_150() {
		return r47_total_exposure_150;
	}
	public void setR47_total_exposure_150(BigDecimal r47_total_exposure_150) {
		this.r47_total_exposure_150 = r47_total_exposure_150;
	}
	public BigDecimal getR47_cash_1() {
		return r47_cash_1;
	}
	public void setR47_cash_1(BigDecimal r47_cash_1) {
		this.r47_cash_1 = r47_cash_1;
	}
	public BigDecimal getR47_sovereign_2() {
		return r47_sovereign_2;
	}
	public void setR47_sovereign_2(BigDecimal r47_sovereign_2) {
		this.r47_sovereign_2 = r47_sovereign_2;
	}
	public BigDecimal getR47_others_3() {
		return r47_others_3;
	}
	public void setR47_others_3(BigDecimal r47_others_3) {
		this.r47_others_3 = r47_others_3;
	}
	public BigDecimal getR47_sovereign_4() {
		return r47_sovereign_4;
	}
	public void setR47_sovereign_4(BigDecimal r47_sovereign_4) {
		this.r47_sovereign_4 = r47_sovereign_4;
	}
	public BigDecimal getR47_others_5() {
		return r47_others_5;
	}
	public void setR47_others_5(BigDecimal r47_others_5) {
		this.r47_others_5 = r47_others_5;
	}
	public BigDecimal getR47_sovereign_6() {
		return r47_sovereign_6;
	}
	public void setR47_sovereign_6(BigDecimal r47_sovereign_6) {
		this.r47_sovereign_6 = r47_sovereign_6;
	}
	public BigDecimal getR47_others_7() {
		return r47_others_7;
	}
	public void setR47_others_7(BigDecimal r47_others_7) {
		this.r47_others_7 = r47_others_7;
	}
	public BigDecimal getR47_sovereign_8() {
		return r47_sovereign_8;
	}
	public void setR47_sovereign_8(BigDecimal r47_sovereign_8) {
		this.r47_sovereign_8 = r47_sovereign_8;
	}
	public BigDecimal getR47_others_9() {
		return r47_others_9;
	}
	public void setR47_others_9(BigDecimal r47_others_9) {
		this.r47_others_9 = r47_others_9;
	}
	public BigDecimal getR47_sovereign_10() {
		return r47_sovereign_10;
	}
	public void setR47_sovereign_10(BigDecimal r47_sovereign_10) {
		this.r47_sovereign_10 = r47_sovereign_10;
	}
	public BigDecimal getR47_others_11() {
		return r47_others_11;
	}
	public void setR47_others_11(BigDecimal r47_others_11) {
		this.r47_others_11 = r47_others_11;
	}
	public BigDecimal getR47_sovereign_12() {
		return r47_sovereign_12;
	}
	public void setR47_sovereign_12(BigDecimal r47_sovereign_12) {
		this.r47_sovereign_12 = r47_sovereign_12;
	}
	public BigDecimal getR47_others_13() {
		return r47_others_13;
	}
	public void setR47_others_13(BigDecimal r47_others_13) {
		this.r47_others_13 = r47_others_13;
	}
	public BigDecimal getR47_rated_14() {
		return r47_rated_14;
	}
	public void setR47_rated_14(BigDecimal r47_rated_14) {
		this.r47_rated_14 = r47_rated_14;
	}
	public BigDecimal getR47_main_index_15() {
		return r47_main_index_15;
	}
	public void setR47_main_index_15(BigDecimal r47_main_index_15) {
		this.r47_main_index_15 = r47_main_index_15;
	}
	public BigDecimal getR47_other_equities_16() {
		return r47_other_equities_16;
	}
	public void setR47_other_equities_16(BigDecimal r47_other_equities_16) {
		this.r47_other_equities_16 = r47_other_equities_16;
	}
	public BigDecimal getR47_mutual_funds_17() {
		return r47_mutual_funds_17;
	}
	public void setR47_mutual_funds_17(BigDecimal r47_mutual_funds_17) {
		this.r47_mutual_funds_17 = r47_mutual_funds_17;
	}
	public BigDecimal getR47_other_national_18() {
		return r47_other_national_18;
	}
	public void setR47_other_national_18(BigDecimal r47_other_national_18) {
		this.r47_other_national_18 = r47_other_national_18;
	}
	public BigDecimal getR47_total_collateral_19() {
		return r47_total_collateral_19;
	}
	public void setR47_total_collateral_19(BigDecimal r47_total_collateral_19) {
		this.r47_total_collateral_19 = r47_total_collateral_19;
	}
	public BigDecimal getR47_net_collateral_20() {
		return r47_net_collateral_20;
	}
	public void setR47_net_collateral_20(BigDecimal r47_net_collateral_20) {
		this.r47_net_collateral_20 = r47_net_collateral_20;
	}
	public BigDecimal getR47_net_collateral_21() {
		return r47_net_collateral_21;
	}
	public void setR47_net_collateral_21(BigDecimal r47_net_collateral_21) {
		this.r47_net_collateral_21 = r47_net_collateral_21;
	}
	public String getR48_risk_weight() {
		return r48_risk_weight;
	}
	public void setR48_risk_weight(String r48_risk_weight) {
		this.r48_risk_weight = r48_risk_weight;
	}
	public BigDecimal getR48_total_exposure_50() {
		return r48_total_exposure_50;
	}
	public void setR48_total_exposure_50(BigDecimal r48_total_exposure_50) {
		this.r48_total_exposure_50 = r48_total_exposure_50;
	}
	public BigDecimal getR48_cash_1() {
		return r48_cash_1;
	}
	public void setR48_cash_1(BigDecimal r48_cash_1) {
		this.r48_cash_1 = r48_cash_1;
	}
	public BigDecimal getR48_sovereign_2() {
		return r48_sovereign_2;
	}
	public void setR48_sovereign_2(BigDecimal r48_sovereign_2) {
		this.r48_sovereign_2 = r48_sovereign_2;
	}
	public BigDecimal getR48_others_3() {
		return r48_others_3;
	}
	public void setR48_others_3(BigDecimal r48_others_3) {
		this.r48_others_3 = r48_others_3;
	}
	public BigDecimal getR48_sovereign_4() {
		return r48_sovereign_4;
	}
	public void setR48_sovereign_4(BigDecimal r48_sovereign_4) {
		this.r48_sovereign_4 = r48_sovereign_4;
	}
	public BigDecimal getR48_others_5() {
		return r48_others_5;
	}
	public void setR48_others_5(BigDecimal r48_others_5) {
		this.r48_others_5 = r48_others_5;
	}
	public BigDecimal getR48_sovereign_6() {
		return r48_sovereign_6;
	}
	public void setR48_sovereign_6(BigDecimal r48_sovereign_6) {
		this.r48_sovereign_6 = r48_sovereign_6;
	}
	public BigDecimal getR48_others_7() {
		return r48_others_7;
	}
	public void setR48_others_7(BigDecimal r48_others_7) {
		this.r48_others_7 = r48_others_7;
	}
	public BigDecimal getR48_sovereign_8() {
		return r48_sovereign_8;
	}
	public void setR48_sovereign_8(BigDecimal r48_sovereign_8) {
		this.r48_sovereign_8 = r48_sovereign_8;
	}
	public BigDecimal getR48_others_9() {
		return r48_others_9;
	}
	public void setR48_others_9(BigDecimal r48_others_9) {
		this.r48_others_9 = r48_others_9;
	}
	public BigDecimal getR48_sovereign_10() {
		return r48_sovereign_10;
	}
	public void setR48_sovereign_10(BigDecimal r48_sovereign_10) {
		this.r48_sovereign_10 = r48_sovereign_10;
	}
	public BigDecimal getR48_others_11() {
		return r48_others_11;
	}
	public void setR48_others_11(BigDecimal r48_others_11) {
		this.r48_others_11 = r48_others_11;
	}
	public BigDecimal getR48_sovereign_12() {
		return r48_sovereign_12;
	}
	public void setR48_sovereign_12(BigDecimal r48_sovereign_12) {
		this.r48_sovereign_12 = r48_sovereign_12;
	}
	public BigDecimal getR48_others_13() {
		return r48_others_13;
	}
	public void setR48_others_13(BigDecimal r48_others_13) {
		this.r48_others_13 = r48_others_13;
	}
	public BigDecimal getR48_rated_14() {
		return r48_rated_14;
	}
	public void setR48_rated_14(BigDecimal r48_rated_14) {
		this.r48_rated_14 = r48_rated_14;
	}
	public BigDecimal getR48_main_index_15() {
		return r48_main_index_15;
	}
	public void setR48_main_index_15(BigDecimal r48_main_index_15) {
		this.r48_main_index_15 = r48_main_index_15;
	}
	public BigDecimal getR48_other_equities_16() {
		return r48_other_equities_16;
	}
	public void setR48_other_equities_16(BigDecimal r48_other_equities_16) {
		this.r48_other_equities_16 = r48_other_equities_16;
	}
	public BigDecimal getR48_mutual_funds_17() {
		return r48_mutual_funds_17;
	}
	public void setR48_mutual_funds_17(BigDecimal r48_mutual_funds_17) {
		this.r48_mutual_funds_17 = r48_mutual_funds_17;
	}
	public BigDecimal getR48_other_national_18() {
		return r48_other_national_18;
	}
	public void setR48_other_national_18(BigDecimal r48_other_national_18) {
		this.r48_other_national_18 = r48_other_national_18;
	}
	public BigDecimal getR48_total_collateral_19() {
		return r48_total_collateral_19;
	}
	public void setR48_total_collateral_19(BigDecimal r48_total_collateral_19) {
		this.r48_total_collateral_19 = r48_total_collateral_19;
	}
	public BigDecimal getR48_net_collateral_20() {
		return r48_net_collateral_20;
	}
	public void setR48_net_collateral_20(BigDecimal r48_net_collateral_20) {
		this.r48_net_collateral_20 = r48_net_collateral_20;
	}
	public BigDecimal getR48_net_collateral_21() {
		return r48_net_collateral_21;
	}
	public void setR48_net_collateral_21(BigDecimal r48_net_collateral_21) {
		this.r48_net_collateral_21 = r48_net_collateral_21;
	}
	public String getR49_sub_total() {
		return r49_sub_total;
	}
	public void setR49_sub_total(String r49_sub_total) {
		this.r49_sub_total = r49_sub_total;
	}
	public BigDecimal getR49_total_exposure() {
		return r49_total_exposure;
	}
	public void setR49_total_exposure(BigDecimal r49_total_exposure) {
		this.r49_total_exposure = r49_total_exposure;
	}
	public BigDecimal getR49_cash_1() {
		return r49_cash_1;
	}
	public void setR49_cash_1(BigDecimal r49_cash_1) {
		this.r49_cash_1 = r49_cash_1;
	}
	public BigDecimal getR49_sovereign_2() {
		return r49_sovereign_2;
	}
	public void setR49_sovereign_2(BigDecimal r49_sovereign_2) {
		this.r49_sovereign_2 = r49_sovereign_2;
	}
	public BigDecimal getR49_others_3() {
		return r49_others_3;
	}
	public void setR49_others_3(BigDecimal r49_others_3) {
		this.r49_others_3 = r49_others_3;
	}
	public BigDecimal getR49_sovereign_4() {
		return r49_sovereign_4;
	}
	public void setR49_sovereign_4(BigDecimal r49_sovereign_4) {
		this.r49_sovereign_4 = r49_sovereign_4;
	}
	public BigDecimal getR49_others_5() {
		return r49_others_5;
	}
	public void setR49_others_5(BigDecimal r49_others_5) {
		this.r49_others_5 = r49_others_5;
	}
	public BigDecimal getR49_sovereign_6() {
		return r49_sovereign_6;
	}
	public void setR49_sovereign_6(BigDecimal r49_sovereign_6) {
		this.r49_sovereign_6 = r49_sovereign_6;
	}
	public BigDecimal getR49_others_7() {
		return r49_others_7;
	}
	public void setR49_others_7(BigDecimal r49_others_7) {
		this.r49_others_7 = r49_others_7;
	}
	public BigDecimal getR49_sovereign_8() {
		return r49_sovereign_8;
	}
	public void setR49_sovereign_8(BigDecimal r49_sovereign_8) {
		this.r49_sovereign_8 = r49_sovereign_8;
	}
	public BigDecimal getR49_others_9() {
		return r49_others_9;
	}
	public void setR49_others_9(BigDecimal r49_others_9) {
		this.r49_others_9 = r49_others_9;
	}
	public BigDecimal getR49_sovereign_10() {
		return r49_sovereign_10;
	}
	public void setR49_sovereign_10(BigDecimal r49_sovereign_10) {
		this.r49_sovereign_10 = r49_sovereign_10;
	}
	public BigDecimal getR49_others_11() {
		return r49_others_11;
	}
	public void setR49_others_11(BigDecimal r49_others_11) {
		this.r49_others_11 = r49_others_11;
	}
	public BigDecimal getR49_sovereign_12() {
		return r49_sovereign_12;
	}
	public void setR49_sovereign_12(BigDecimal r49_sovereign_12) {
		this.r49_sovereign_12 = r49_sovereign_12;
	}
	public BigDecimal getR49_others_13() {
		return r49_others_13;
	}
	public void setR49_others_13(BigDecimal r49_others_13) {
		this.r49_others_13 = r49_others_13;
	}
	public BigDecimal getR49_rated_14() {
		return r49_rated_14;
	}
	public void setR49_rated_14(BigDecimal r49_rated_14) {
		this.r49_rated_14 = r49_rated_14;
	}
	public BigDecimal getR49_main_index_15() {
		return r49_main_index_15;
	}
	public void setR49_main_index_15(BigDecimal r49_main_index_15) {
		this.r49_main_index_15 = r49_main_index_15;
	}
	public BigDecimal getR49_other_equities_16() {
		return r49_other_equities_16;
	}
	public void setR49_other_equities_16(BigDecimal r49_other_equities_16) {
		this.r49_other_equities_16 = r49_other_equities_16;
	}
	public BigDecimal getR49_mutual_funds_17() {
		return r49_mutual_funds_17;
	}
	public void setR49_mutual_funds_17(BigDecimal r49_mutual_funds_17) {
		this.r49_mutual_funds_17 = r49_mutual_funds_17;
	}
	public BigDecimal getR49_other_national_18() {
		return r49_other_national_18;
	}
	public void setR49_other_national_18(BigDecimal r49_other_national_18) {
		this.r49_other_national_18 = r49_other_national_18;
	}
	public BigDecimal getR49_total_collateral_19() {
		return r49_total_collateral_19;
	}
	public void setR49_total_collateral_19(BigDecimal r49_total_collateral_19) {
		this.r49_total_collateral_19 = r49_total_collateral_19;
	}
	public BigDecimal getR49_net_collateral_20() {
		return r49_net_collateral_20;
	}
	public void setR49_net_collateral_20(BigDecimal r49_net_collateral_20) {
		this.r49_net_collateral_20 = r49_net_collateral_20;
	}
	public BigDecimal getR49_net_collateral_21() {
		return r49_net_collateral_21;
	}
	public void setR49_net_collateral_21(BigDecimal r49_net_collateral_21) {
		this.r49_net_collateral_21 = r49_net_collateral_21;
	}
	public String getR50_product() {
		return r50_product;
	}
	public void setR50_product(String r50_product) {
		this.r50_product = r50_product;
	}
	public String getR50_risk_weight() {
		return r50_risk_weight;
	}
	public void setR50_risk_weight(String r50_risk_weight) {
		this.r50_risk_weight = r50_risk_weight;
	}
	public BigDecimal getR50_total_exposure_0() {
		return r50_total_exposure_0;
	}
	public void setR50_total_exposure_0(BigDecimal r50_total_exposure_0) {
		this.r50_total_exposure_0 = r50_total_exposure_0;
	}
	public String getR51_risk_weight() {
		return r51_risk_weight;
	}
	public void setR51_risk_weight(String r51_risk_weight) {
		this.r51_risk_weight = r51_risk_weight;
	}
	public BigDecimal getR51_total_exposure_20() {
		return r51_total_exposure_20;
	}
	public void setR51_total_exposure_20(BigDecimal r51_total_exposure_20) {
		this.r51_total_exposure_20 = r51_total_exposure_20;
	}
	public BigDecimal getR51_cash_1() {
		return r51_cash_1;
	}
	public void setR51_cash_1(BigDecimal r51_cash_1) {
		this.r51_cash_1 = r51_cash_1;
	}
	public BigDecimal getR51_sovereign_2() {
		return r51_sovereign_2;
	}
	public void setR51_sovereign_2(BigDecimal r51_sovereign_2) {
		this.r51_sovereign_2 = r51_sovereign_2;
	}
	public BigDecimal getR51_others_3() {
		return r51_others_3;
	}
	public void setR51_others_3(BigDecimal r51_others_3) {
		this.r51_others_3 = r51_others_3;
	}
	public BigDecimal getR51_sovereign_4() {
		return r51_sovereign_4;
	}
	public void setR51_sovereign_4(BigDecimal r51_sovereign_4) {
		this.r51_sovereign_4 = r51_sovereign_4;
	}
	public BigDecimal getR51_others_5() {
		return r51_others_5;
	}
	public void setR51_others_5(BigDecimal r51_others_5) {
		this.r51_others_5 = r51_others_5;
	}
	public BigDecimal getR51_sovereign_6() {
		return r51_sovereign_6;
	}
	public void setR51_sovereign_6(BigDecimal r51_sovereign_6) {
		this.r51_sovereign_6 = r51_sovereign_6;
	}
	public BigDecimal getR51_others_7() {
		return r51_others_7;
	}
	public void setR51_others_7(BigDecimal r51_others_7) {
		this.r51_others_7 = r51_others_7;
	}
	public BigDecimal getR51_sovereign_8() {
		return r51_sovereign_8;
	}
	public void setR51_sovereign_8(BigDecimal r51_sovereign_8) {
		this.r51_sovereign_8 = r51_sovereign_8;
	}
	public BigDecimal getR51_others_9() {
		return r51_others_9;
	}
	public void setR51_others_9(BigDecimal r51_others_9) {
		this.r51_others_9 = r51_others_9;
	}
	public BigDecimal getR51_sovereign_10() {
		return r51_sovereign_10;
	}
	public void setR51_sovereign_10(BigDecimal r51_sovereign_10) {
		this.r51_sovereign_10 = r51_sovereign_10;
	}
	public BigDecimal getR51_others_11() {
		return r51_others_11;
	}
	public void setR51_others_11(BigDecimal r51_others_11) {
		this.r51_others_11 = r51_others_11;
	}
	public BigDecimal getR51_sovereign_12() {
		return r51_sovereign_12;
	}
	public void setR51_sovereign_12(BigDecimal r51_sovereign_12) {
		this.r51_sovereign_12 = r51_sovereign_12;
	}
	public BigDecimal getR51_others_13() {
		return r51_others_13;
	}
	public void setR51_others_13(BigDecimal r51_others_13) {
		this.r51_others_13 = r51_others_13;
	}
	public BigDecimal getR51_rated_14() {
		return r51_rated_14;
	}
	public void setR51_rated_14(BigDecimal r51_rated_14) {
		this.r51_rated_14 = r51_rated_14;
	}
	public BigDecimal getR51_main_index_15() {
		return r51_main_index_15;
	}
	public void setR51_main_index_15(BigDecimal r51_main_index_15) {
		this.r51_main_index_15 = r51_main_index_15;
	}
	public BigDecimal getR51_other_equities_16() {
		return r51_other_equities_16;
	}
	public void setR51_other_equities_16(BigDecimal r51_other_equities_16) {
		this.r51_other_equities_16 = r51_other_equities_16;
	}
	public BigDecimal getR51_mutual_funds_17() {
		return r51_mutual_funds_17;
	}
	public void setR51_mutual_funds_17(BigDecimal r51_mutual_funds_17) {
		this.r51_mutual_funds_17 = r51_mutual_funds_17;
	}
	public BigDecimal getR51_total_collateral_19() {
		return r51_total_collateral_19;
	}
	public void setR51_total_collateral_19(BigDecimal r51_total_collateral_19) {
		this.r51_total_collateral_19 = r51_total_collateral_19;
	}
	public BigDecimal getR51_net_collateral_20() {
		return r51_net_collateral_20;
	}
	public void setR51_net_collateral_20(BigDecimal r51_net_collateral_20) {
		this.r51_net_collateral_20 = r51_net_collateral_20;
	}
	public BigDecimal getR51_net_collateral_21() {
		return r51_net_collateral_21;
	}
	public void setR51_net_collateral_21(BigDecimal r51_net_collateral_21) {
		this.r51_net_collateral_21 = r51_net_collateral_21;
	}
	public String getR52_risk_weight() {
		return r52_risk_weight;
	}
	public void setR52_risk_weight(String r52_risk_weight) {
		this.r52_risk_weight = r52_risk_weight;
	}
	public BigDecimal getR52_total_exposure_50() {
		return r52_total_exposure_50;
	}
	public void setR52_total_exposure_50(BigDecimal r52_total_exposure_50) {
		this.r52_total_exposure_50 = r52_total_exposure_50;
	}
	public BigDecimal getR52_cash_1() {
		return r52_cash_1;
	}
	public void setR52_cash_1(BigDecimal r52_cash_1) {
		this.r52_cash_1 = r52_cash_1;
	}
	public BigDecimal getR52_sovereign_2() {
		return r52_sovereign_2;
	}
	public void setR52_sovereign_2(BigDecimal r52_sovereign_2) {
		this.r52_sovereign_2 = r52_sovereign_2;
	}
	public BigDecimal getR52_others_3() {
		return r52_others_3;
	}
	public void setR52_others_3(BigDecimal r52_others_3) {
		this.r52_others_3 = r52_others_3;
	}
	public BigDecimal getR52_sovereign_4() {
		return r52_sovereign_4;
	}
	public void setR52_sovereign_4(BigDecimal r52_sovereign_4) {
		this.r52_sovereign_4 = r52_sovereign_4;
	}
	public BigDecimal getR52_others_5() {
		return r52_others_5;
	}
	public void setR52_others_5(BigDecimal r52_others_5) {
		this.r52_others_5 = r52_others_5;
	}
	public BigDecimal getR52_sovereign_6() {
		return r52_sovereign_6;
	}
	public void setR52_sovereign_6(BigDecimal r52_sovereign_6) {
		this.r52_sovereign_6 = r52_sovereign_6;
	}
	public BigDecimal getR52_others_7() {
		return r52_others_7;
	}
	public void setR52_others_7(BigDecimal r52_others_7) {
		this.r52_others_7 = r52_others_7;
	}
	public BigDecimal getR52_sovereign_8() {
		return r52_sovereign_8;
	}
	public void setR52_sovereign_8(BigDecimal r52_sovereign_8) {
		this.r52_sovereign_8 = r52_sovereign_8;
	}
	public BigDecimal getR52_others_9() {
		return r52_others_9;
	}
	public void setR52_others_9(BigDecimal r52_others_9) {
		this.r52_others_9 = r52_others_9;
	}
	public BigDecimal getR52_sovereign_10() {
		return r52_sovereign_10;
	}
	public void setR52_sovereign_10(BigDecimal r52_sovereign_10) {
		this.r52_sovereign_10 = r52_sovereign_10;
	}
	public BigDecimal getR52_others_11() {
		return r52_others_11;
	}
	public void setR52_others_11(BigDecimal r52_others_11) {
		this.r52_others_11 = r52_others_11;
	}
	public BigDecimal getR52_sovereign_12() {
		return r52_sovereign_12;
	}
	public void setR52_sovereign_12(BigDecimal r52_sovereign_12) {
		this.r52_sovereign_12 = r52_sovereign_12;
	}
	public BigDecimal getR52_others_13() {
		return r52_others_13;
	}
	public void setR52_others_13(BigDecimal r52_others_13) {
		this.r52_others_13 = r52_others_13;
	}
	public BigDecimal getR52_rated_14() {
		return r52_rated_14;
	}
	public void setR52_rated_14(BigDecimal r52_rated_14) {
		this.r52_rated_14 = r52_rated_14;
	}
	public BigDecimal getR52_main_index_15() {
		return r52_main_index_15;
	}
	public void setR52_main_index_15(BigDecimal r52_main_index_15) {
		this.r52_main_index_15 = r52_main_index_15;
	}
	public BigDecimal getR52_other_equities_16() {
		return r52_other_equities_16;
	}
	public void setR52_other_equities_16(BigDecimal r52_other_equities_16) {
		this.r52_other_equities_16 = r52_other_equities_16;
	}
	public BigDecimal getR52_mutual_funds_17() {
		return r52_mutual_funds_17;
	}
	public void setR52_mutual_funds_17(BigDecimal r52_mutual_funds_17) {
		this.r52_mutual_funds_17 = r52_mutual_funds_17;
	}
	public BigDecimal getR52_total_collateral_19() {
		return r52_total_collateral_19;
	}
	public void setR52_total_collateral_19(BigDecimal r52_total_collateral_19) {
		this.r52_total_collateral_19 = r52_total_collateral_19;
	}
	public BigDecimal getR52_net_collateral_20() {
		return r52_net_collateral_20;
	}
	public void setR52_net_collateral_20(BigDecimal r52_net_collateral_20) {
		this.r52_net_collateral_20 = r52_net_collateral_20;
	}
	public BigDecimal getR52_net_collateral_21() {
		return r52_net_collateral_21;
	}
	public void setR52_net_collateral_21(BigDecimal r52_net_collateral_21) {
		this.r52_net_collateral_21 = r52_net_collateral_21;
	}
	public String getR53_risk_weight() {
		return r53_risk_weight;
	}
	public void setR53_risk_weight(String r53_risk_weight) {
		this.r53_risk_weight = r53_risk_weight;
	}
	public BigDecimal getR53_total_exposure_100() {
		return r53_total_exposure_100;
	}
	public void setR53_total_exposure_100(BigDecimal r53_total_exposure_100) {
		this.r53_total_exposure_100 = r53_total_exposure_100;
	}
	public BigDecimal getR53_cash_1() {
		return r53_cash_1;
	}
	public void setR53_cash_1(BigDecimal r53_cash_1) {
		this.r53_cash_1 = r53_cash_1;
	}
	public BigDecimal getR53_sovereign_2() {
		return r53_sovereign_2;
	}
	public void setR53_sovereign_2(BigDecimal r53_sovereign_2) {
		this.r53_sovereign_2 = r53_sovereign_2;
	}
	public BigDecimal getR53_others_3() {
		return r53_others_3;
	}
	public void setR53_others_3(BigDecimal r53_others_3) {
		this.r53_others_3 = r53_others_3;
	}
	public BigDecimal getR53_sovereign_4() {
		return r53_sovereign_4;
	}
	public void setR53_sovereign_4(BigDecimal r53_sovereign_4) {
		this.r53_sovereign_4 = r53_sovereign_4;
	}
	public BigDecimal getR53_others_5() {
		return r53_others_5;
	}
	public void setR53_others_5(BigDecimal r53_others_5) {
		this.r53_others_5 = r53_others_5;
	}
	public BigDecimal getR53_sovereign_6() {
		return r53_sovereign_6;
	}
	public void setR53_sovereign_6(BigDecimal r53_sovereign_6) {
		this.r53_sovereign_6 = r53_sovereign_6;
	}
	public BigDecimal getR53_others_7() {
		return r53_others_7;
	}
	public void setR53_others_7(BigDecimal r53_others_7) {
		this.r53_others_7 = r53_others_7;
	}
	public BigDecimal getR53_sovereign_8() {
		return r53_sovereign_8;
	}
	public void setR53_sovereign_8(BigDecimal r53_sovereign_8) {
		this.r53_sovereign_8 = r53_sovereign_8;
	}
	public BigDecimal getR53_others_9() {
		return r53_others_9;
	}
	public void setR53_others_9(BigDecimal r53_others_9) {
		this.r53_others_9 = r53_others_9;
	}
	public BigDecimal getR53_sovereign_10() {
		return r53_sovereign_10;
	}
	public void setR53_sovereign_10(BigDecimal r53_sovereign_10) {
		this.r53_sovereign_10 = r53_sovereign_10;
	}
	public BigDecimal getR53_others_11() {
		return r53_others_11;
	}
	public void setR53_others_11(BigDecimal r53_others_11) {
		this.r53_others_11 = r53_others_11;
	}
	public BigDecimal getR53_sovereign_12() {
		return r53_sovereign_12;
	}
	public void setR53_sovereign_12(BigDecimal r53_sovereign_12) {
		this.r53_sovereign_12 = r53_sovereign_12;
	}
	public BigDecimal getR53_others_13() {
		return r53_others_13;
	}
	public void setR53_others_13(BigDecimal r53_others_13) {
		this.r53_others_13 = r53_others_13;
	}
	public BigDecimal getR53_rated_14() {
		return r53_rated_14;
	}
	public void setR53_rated_14(BigDecimal r53_rated_14) {
		this.r53_rated_14 = r53_rated_14;
	}
	public BigDecimal getR53_main_index_15() {
		return r53_main_index_15;
	}
	public void setR53_main_index_15(BigDecimal r53_main_index_15) {
		this.r53_main_index_15 = r53_main_index_15;
	}
	public BigDecimal getR53_other_equities_16() {
		return r53_other_equities_16;
	}
	public void setR53_other_equities_16(BigDecimal r53_other_equities_16) {
		this.r53_other_equities_16 = r53_other_equities_16;
	}
	public BigDecimal getR53_mutual_funds_17() {
		return r53_mutual_funds_17;
	}
	public void setR53_mutual_funds_17(BigDecimal r53_mutual_funds_17) {
		this.r53_mutual_funds_17 = r53_mutual_funds_17;
	}
	public BigDecimal getR53_total_collateral_19() {
		return r53_total_collateral_19;
	}
	public void setR53_total_collateral_19(BigDecimal r53_total_collateral_19) {
		this.r53_total_collateral_19 = r53_total_collateral_19;
	}
	public BigDecimal getR53_net_collateral_20() {
		return r53_net_collateral_20;
	}
	public void setR53_net_collateral_20(BigDecimal r53_net_collateral_20) {
		this.r53_net_collateral_20 = r53_net_collateral_20;
	}
	public BigDecimal getR53_net_collateral_21() {
		return r53_net_collateral_21;
	}
	public void setR53_net_collateral_21(BigDecimal r53_net_collateral_21) {
		this.r53_net_collateral_21 = r53_net_collateral_21;
	}
	public String getR54_risk_weight() {
		return r54_risk_weight;
	}
	public void setR54_risk_weight(String r54_risk_weight) {
		this.r54_risk_weight = r54_risk_weight;
	}
	public BigDecimal getR54_total_exposure_150() {
		return r54_total_exposure_150;
	}
	public void setR54_total_exposure_150(BigDecimal r54_total_exposure_150) {
		this.r54_total_exposure_150 = r54_total_exposure_150;
	}
	public BigDecimal getR54_cash_1() {
		return r54_cash_1;
	}
	public void setR54_cash_1(BigDecimal r54_cash_1) {
		this.r54_cash_1 = r54_cash_1;
	}
	public BigDecimal getR54_sovereign_2() {
		return r54_sovereign_2;
	}
	public void setR54_sovereign_2(BigDecimal r54_sovereign_2) {
		this.r54_sovereign_2 = r54_sovereign_2;
	}
	public BigDecimal getR54_others_3() {
		return r54_others_3;
	}
	public void setR54_others_3(BigDecimal r54_others_3) {
		this.r54_others_3 = r54_others_3;
	}
	public BigDecimal getR54_sovereign_4() {
		return r54_sovereign_4;
	}
	public void setR54_sovereign_4(BigDecimal r54_sovereign_4) {
		this.r54_sovereign_4 = r54_sovereign_4;
	}
	public BigDecimal getR54_others_5() {
		return r54_others_5;
	}
	public void setR54_others_5(BigDecimal r54_others_5) {
		this.r54_others_5 = r54_others_5;
	}
	public BigDecimal getR54_sovereign_6() {
		return r54_sovereign_6;
	}
	public void setR54_sovereign_6(BigDecimal r54_sovereign_6) {
		this.r54_sovereign_6 = r54_sovereign_6;
	}
	public BigDecimal getR54_others_7() {
		return r54_others_7;
	}
	public void setR54_others_7(BigDecimal r54_others_7) {
		this.r54_others_7 = r54_others_7;
	}
	public BigDecimal getR54_sovereign_8() {
		return r54_sovereign_8;
	}
	public void setR54_sovereign_8(BigDecimal r54_sovereign_8) {
		this.r54_sovereign_8 = r54_sovereign_8;
	}
	public BigDecimal getR54_others_9() {
		return r54_others_9;
	}
	public void setR54_others_9(BigDecimal r54_others_9) {
		this.r54_others_9 = r54_others_9;
	}
	public BigDecimal getR54_sovereign_10() {
		return r54_sovereign_10;
	}
	public void setR54_sovereign_10(BigDecimal r54_sovereign_10) {
		this.r54_sovereign_10 = r54_sovereign_10;
	}
	public BigDecimal getR54_others_11() {
		return r54_others_11;
	}
	public void setR54_others_11(BigDecimal r54_others_11) {
		this.r54_others_11 = r54_others_11;
	}
	public BigDecimal getR54_sovereign_12() {
		return r54_sovereign_12;
	}
	public void setR54_sovereign_12(BigDecimal r54_sovereign_12) {
		this.r54_sovereign_12 = r54_sovereign_12;
	}
	public BigDecimal getR54_others_13() {
		return r54_others_13;
	}
	public void setR54_others_13(BigDecimal r54_others_13) {
		this.r54_others_13 = r54_others_13;
	}
	public BigDecimal getR54_rated_14() {
		return r54_rated_14;
	}
	public void setR54_rated_14(BigDecimal r54_rated_14) {
		this.r54_rated_14 = r54_rated_14;
	}
	public BigDecimal getR54_main_index_15() {
		return r54_main_index_15;
	}
	public void setR54_main_index_15(BigDecimal r54_main_index_15) {
		this.r54_main_index_15 = r54_main_index_15;
	}
	public BigDecimal getR54_other_equities_16() {
		return r54_other_equities_16;
	}
	public void setR54_other_equities_16(BigDecimal r54_other_equities_16) {
		this.r54_other_equities_16 = r54_other_equities_16;
	}
	public BigDecimal getR54_mutual_funds_17() {
		return r54_mutual_funds_17;
	}
	public void setR54_mutual_funds_17(BigDecimal r54_mutual_funds_17) {
		this.r54_mutual_funds_17 = r54_mutual_funds_17;
	}
	public BigDecimal getR54_total_collateral_19() {
		return r54_total_collateral_19;
	}
	public void setR54_total_collateral_19(BigDecimal r54_total_collateral_19) {
		this.r54_total_collateral_19 = r54_total_collateral_19;
	}
	public BigDecimal getR54_net_collateral_20() {
		return r54_net_collateral_20;
	}
	public void setR54_net_collateral_20(BigDecimal r54_net_collateral_20) {
		this.r54_net_collateral_20 = r54_net_collateral_20;
	}
	public BigDecimal getR54_net_collateral_21() {
		return r54_net_collateral_21;
	}
	public void setR54_net_collateral_21(BigDecimal r54_net_collateral_21) {
		this.r54_net_collateral_21 = r54_net_collateral_21;
	}
	public String getR55_risk_weight() {
		return r55_risk_weight;
	}
	public void setR55_risk_weight(String r55_risk_weight) {
		this.r55_risk_weight = r55_risk_weight;
	}
	public BigDecimal getR55_total_exposure_100() {
		return r55_total_exposure_100;
	}
	public void setR55_total_exposure_100(BigDecimal r55_total_exposure_100) {
		this.r55_total_exposure_100 = r55_total_exposure_100;
	}
	public BigDecimal getR55_cash_1() {
		return r55_cash_1;
	}
	public void setR55_cash_1(BigDecimal r55_cash_1) {
		this.r55_cash_1 = r55_cash_1;
	}
	public BigDecimal getR55_sovereign_2() {
		return r55_sovereign_2;
	}
	public void setR55_sovereign_2(BigDecimal r55_sovereign_2) {
		this.r55_sovereign_2 = r55_sovereign_2;
	}
	public BigDecimal getR55_others_3() {
		return r55_others_3;
	}
	public void setR55_others_3(BigDecimal r55_others_3) {
		this.r55_others_3 = r55_others_3;
	}
	public BigDecimal getR55_sovereign_4() {
		return r55_sovereign_4;
	}
	public void setR55_sovereign_4(BigDecimal r55_sovereign_4) {
		this.r55_sovereign_4 = r55_sovereign_4;
	}
	public BigDecimal getR55_others_5() {
		return r55_others_5;
	}
	public void setR55_others_5(BigDecimal r55_others_5) {
		this.r55_others_5 = r55_others_5;
	}
	public BigDecimal getR55_sovereign_6() {
		return r55_sovereign_6;
	}
	public void setR55_sovereign_6(BigDecimal r55_sovereign_6) {
		this.r55_sovereign_6 = r55_sovereign_6;
	}
	public BigDecimal getR55_others_7() {
		return r55_others_7;
	}
	public void setR55_others_7(BigDecimal r55_others_7) {
		this.r55_others_7 = r55_others_7;
	}
	public BigDecimal getR55_sovereign_8() {
		return r55_sovereign_8;
	}
	public void setR55_sovereign_8(BigDecimal r55_sovereign_8) {
		this.r55_sovereign_8 = r55_sovereign_8;
	}
	public BigDecimal getR55_others_9() {
		return r55_others_9;
	}
	public void setR55_others_9(BigDecimal r55_others_9) {
		this.r55_others_9 = r55_others_9;
	}
	public BigDecimal getR55_sovereign_10() {
		return r55_sovereign_10;
	}
	public void setR55_sovereign_10(BigDecimal r55_sovereign_10) {
		this.r55_sovereign_10 = r55_sovereign_10;
	}
	public BigDecimal getR55_others_11() {
		return r55_others_11;
	}
	public void setR55_others_11(BigDecimal r55_others_11) {
		this.r55_others_11 = r55_others_11;
	}
	public BigDecimal getR55_sovereign_12() {
		return r55_sovereign_12;
	}
	public void setR55_sovereign_12(BigDecimal r55_sovereign_12) {
		this.r55_sovereign_12 = r55_sovereign_12;
	}
	public BigDecimal getR55_others_13() {
		return r55_others_13;
	}
	public void setR55_others_13(BigDecimal r55_others_13) {
		this.r55_others_13 = r55_others_13;
	}
	public BigDecimal getR55_rated_14() {
		return r55_rated_14;
	}
	public void setR55_rated_14(BigDecimal r55_rated_14) {
		this.r55_rated_14 = r55_rated_14;
	}
	public BigDecimal getR55_main_index_15() {
		return r55_main_index_15;
	}
	public void setR55_main_index_15(BigDecimal r55_main_index_15) {
		this.r55_main_index_15 = r55_main_index_15;
	}
	public BigDecimal getR55_other_equities_16() {
		return r55_other_equities_16;
	}
	public void setR55_other_equities_16(BigDecimal r55_other_equities_16) {
		this.r55_other_equities_16 = r55_other_equities_16;
	}
	public BigDecimal getR55_mutual_funds_17() {
		return r55_mutual_funds_17;
	}
	public void setR55_mutual_funds_17(BigDecimal r55_mutual_funds_17) {
		this.r55_mutual_funds_17 = r55_mutual_funds_17;
	}
	public BigDecimal getR55_total_collateral_19() {
		return r55_total_collateral_19;
	}
	public void setR55_total_collateral_19(BigDecimal r55_total_collateral_19) {
		this.r55_total_collateral_19 = r55_total_collateral_19;
	}
	public BigDecimal getR55_net_collateral_20() {
		return r55_net_collateral_20;
	}
	public void setR55_net_collateral_20(BigDecimal r55_net_collateral_20) {
		this.r55_net_collateral_20 = r55_net_collateral_20;
	}
	public BigDecimal getR55_net_collateral_21() {
		return r55_net_collateral_21;
	}
	public void setR55_net_collateral_21(BigDecimal r55_net_collateral_21) {
		this.r55_net_collateral_21 = r55_net_collateral_21;
	}
	public String getR56_product() {
		return r56_product;
	}
	public void setR56_product(String r56_product) {
		this.r56_product = r56_product;
	}
	public String getR56_risk_weight() {
		return r56_risk_weight;
	}
	public void setR56_risk_weight(String r56_risk_weight) {
		this.r56_risk_weight = r56_risk_weight;
	}
	public BigDecimal getR56_total_exposure_100() {
		return r56_total_exposure_100;
	}
	public void setR56_total_exposure_100(BigDecimal r56_total_exposure_100) {
		this.r56_total_exposure_100 = r56_total_exposure_100;
	}
	public BigDecimal getR56_cash_1() {
		return r56_cash_1;
	}
	public void setR56_cash_1(BigDecimal r56_cash_1) {
		this.r56_cash_1 = r56_cash_1;
	}
	public BigDecimal getR56_sovereign_2() {
		return r56_sovereign_2;
	}
	public void setR56_sovereign_2(BigDecimal r56_sovereign_2) {
		this.r56_sovereign_2 = r56_sovereign_2;
	}
	public BigDecimal getR56_others_3() {
		return r56_others_3;
	}
	public void setR56_others_3(BigDecimal r56_others_3) {
		this.r56_others_3 = r56_others_3;
	}
	public BigDecimal getR56_sovereign_4() {
		return r56_sovereign_4;
	}
	public void setR56_sovereign_4(BigDecimal r56_sovereign_4) {
		this.r56_sovereign_4 = r56_sovereign_4;
	}
	public BigDecimal getR56_others_5() {
		return r56_others_5;
	}
	public void setR56_others_5(BigDecimal r56_others_5) {
		this.r56_others_5 = r56_others_5;
	}
	public BigDecimal getR56_sovereign_6() {
		return r56_sovereign_6;
	}
	public void setR56_sovereign_6(BigDecimal r56_sovereign_6) {
		this.r56_sovereign_6 = r56_sovereign_6;
	}
	public BigDecimal getR56_others_7() {
		return r56_others_7;
	}
	public void setR56_others_7(BigDecimal r56_others_7) {
		this.r56_others_7 = r56_others_7;
	}
	public BigDecimal getR56_sovereign_8() {
		return r56_sovereign_8;
	}
	public void setR56_sovereign_8(BigDecimal r56_sovereign_8) {
		this.r56_sovereign_8 = r56_sovereign_8;
	}
	public BigDecimal getR56_others_9() {
		return r56_others_9;
	}
	public void setR56_others_9(BigDecimal r56_others_9) {
		this.r56_others_9 = r56_others_9;
	}
	public BigDecimal getR56_sovereign_10() {
		return r56_sovereign_10;
	}
	public void setR56_sovereign_10(BigDecimal r56_sovereign_10) {
		this.r56_sovereign_10 = r56_sovereign_10;
	}
	public BigDecimal getR56_others_11() {
		return r56_others_11;
	}
	public void setR56_others_11(BigDecimal r56_others_11) {
		this.r56_others_11 = r56_others_11;
	}
	public BigDecimal getR56_sovereign_12() {
		return r56_sovereign_12;
	}
	public void setR56_sovereign_12(BigDecimal r56_sovereign_12) {
		this.r56_sovereign_12 = r56_sovereign_12;
	}
	public BigDecimal getR56_others_13() {
		return r56_others_13;
	}
	public void setR56_others_13(BigDecimal r56_others_13) {
		this.r56_others_13 = r56_others_13;
	}
	public BigDecimal getR56_rated_14() {
		return r56_rated_14;
	}
	public void setR56_rated_14(BigDecimal r56_rated_14) {
		this.r56_rated_14 = r56_rated_14;
	}
	public BigDecimal getR56_main_index_15() {
		return r56_main_index_15;
	}
	public void setR56_main_index_15(BigDecimal r56_main_index_15) {
		this.r56_main_index_15 = r56_main_index_15;
	}
	public BigDecimal getR56_other_equities_16() {
		return r56_other_equities_16;
	}
	public void setR56_other_equities_16(BigDecimal r56_other_equities_16) {
		this.r56_other_equities_16 = r56_other_equities_16;
	}
	public BigDecimal getR56_mutual_funds_17() {
		return r56_mutual_funds_17;
	}
	public void setR56_mutual_funds_17(BigDecimal r56_mutual_funds_17) {
		this.r56_mutual_funds_17 = r56_mutual_funds_17;
	}
	public BigDecimal getR56_total_collateral_19() {
		return r56_total_collateral_19;
	}
	public void setR56_total_collateral_19(BigDecimal r56_total_collateral_19) {
		this.r56_total_collateral_19 = r56_total_collateral_19;
	}
	public BigDecimal getR56_net_collateral_20() {
		return r56_net_collateral_20;
	}
	public void setR56_net_collateral_20(BigDecimal r56_net_collateral_20) {
		this.r56_net_collateral_20 = r56_net_collateral_20;
	}
	public BigDecimal getR56_net_collateral_21() {
		return r56_net_collateral_21;
	}
	public void setR56_net_collateral_21(BigDecimal r56_net_collateral_21) {
		this.r56_net_collateral_21 = r56_net_collateral_21;
	}
	public String getR57_sub_total() {
		return r57_sub_total;
	}
	public void setR57_sub_total(String r57_sub_total) {
		this.r57_sub_total = r57_sub_total;
	}
	public BigDecimal getR57_total_exposure() {
		return r57_total_exposure;
	}
	public void setR57_total_exposure(BigDecimal r57_total_exposure) {
		this.r57_total_exposure = r57_total_exposure;
	}
	public BigDecimal getR57_cash_1() {
		return r57_cash_1;
	}
	public void setR57_cash_1(BigDecimal r57_cash_1) {
		this.r57_cash_1 = r57_cash_1;
	}
	public BigDecimal getR57_sovereign_2() {
		return r57_sovereign_2;
	}
	public void setR57_sovereign_2(BigDecimal r57_sovereign_2) {
		this.r57_sovereign_2 = r57_sovereign_2;
	}
	public BigDecimal getR57_others_3() {
		return r57_others_3;
	}
	public void setR57_others_3(BigDecimal r57_others_3) {
		this.r57_others_3 = r57_others_3;
	}
	public BigDecimal getR57_sovereign_4() {
		return r57_sovereign_4;
	}
	public void setR57_sovereign_4(BigDecimal r57_sovereign_4) {
		this.r57_sovereign_4 = r57_sovereign_4;
	}
	public BigDecimal getR57_others_5() {
		return r57_others_5;
	}
	public void setR57_others_5(BigDecimal r57_others_5) {
		this.r57_others_5 = r57_others_5;
	}
	public BigDecimal getR57_sovereign_6() {
		return r57_sovereign_6;
	}
	public void setR57_sovereign_6(BigDecimal r57_sovereign_6) {
		this.r57_sovereign_6 = r57_sovereign_6;
	}
	public BigDecimal getR57_others_7() {
		return r57_others_7;
	}
	public void setR57_others_7(BigDecimal r57_others_7) {
		this.r57_others_7 = r57_others_7;
	}
	public BigDecimal getR57_sovereign_8() {
		return r57_sovereign_8;
	}
	public void setR57_sovereign_8(BigDecimal r57_sovereign_8) {
		this.r57_sovereign_8 = r57_sovereign_8;
	}
	public BigDecimal getR57_others_9() {
		return r57_others_9;
	}
	public void setR57_others_9(BigDecimal r57_others_9) {
		this.r57_others_9 = r57_others_9;
	}
	public BigDecimal getR57_sovereign_10() {
		return r57_sovereign_10;
	}
	public void setR57_sovereign_10(BigDecimal r57_sovereign_10) {
		this.r57_sovereign_10 = r57_sovereign_10;
	}
	public BigDecimal getR57_others_11() {
		return r57_others_11;
	}
	public void setR57_others_11(BigDecimal r57_others_11) {
		this.r57_others_11 = r57_others_11;
	}
	public BigDecimal getR57_sovereign_12() {
		return r57_sovereign_12;
	}
	public void setR57_sovereign_12(BigDecimal r57_sovereign_12) {
		this.r57_sovereign_12 = r57_sovereign_12;
	}
	public BigDecimal getR57_others_13() {
		return r57_others_13;
	}
	public void setR57_others_13(BigDecimal r57_others_13) {
		this.r57_others_13 = r57_others_13;
	}
	public BigDecimal getR57_rated_14() {
		return r57_rated_14;
	}
	public void setR57_rated_14(BigDecimal r57_rated_14) {
		this.r57_rated_14 = r57_rated_14;
	}
	public BigDecimal getR57_main_index_15() {
		return r57_main_index_15;
	}
	public void setR57_main_index_15(BigDecimal r57_main_index_15) {
		this.r57_main_index_15 = r57_main_index_15;
	}
	public BigDecimal getR57_other_equities_16() {
		return r57_other_equities_16;
	}
	public void setR57_other_equities_16(BigDecimal r57_other_equities_16) {
		this.r57_other_equities_16 = r57_other_equities_16;
	}
	public BigDecimal getR57_mutual_funds_17() {
		return r57_mutual_funds_17;
	}
	public void setR57_mutual_funds_17(BigDecimal r57_mutual_funds_17) {
		this.r57_mutual_funds_17 = r57_mutual_funds_17;
	}
	public BigDecimal getR57_total_collateral_19() {
		return r57_total_collateral_19;
	}
	public void setR57_total_collateral_19(BigDecimal r57_total_collateral_19) {
		this.r57_total_collateral_19 = r57_total_collateral_19;
	}
	public BigDecimal getR57_net_collateral_20() {
		return r57_net_collateral_20;
	}
	public void setR57_net_collateral_20(BigDecimal r57_net_collateral_20) {
		this.r57_net_collateral_20 = r57_net_collateral_20;
	}
	public BigDecimal getR57_net_collateral_21() {
		return r57_net_collateral_21;
	}
	public void setR57_net_collateral_21(BigDecimal r57_net_collateral_21) {
		this.r57_net_collateral_21 = r57_net_collateral_21;
	}
	public String getR58_total() {
		return r58_total;
	}
	public void setR58_total(String r58_total) {
		this.r58_total = r58_total;
	}
	public BigDecimal getR58_total_exposure() {
		return r58_total_exposure;
	}
	public void setR58_total_exposure(BigDecimal r58_total_exposure) {
		this.r58_total_exposure = r58_total_exposure;
	}
	public BigDecimal getR58_cash_1() {
		return r58_cash_1;
	}
	public void setR58_cash_1(BigDecimal r58_cash_1) {
		this.r58_cash_1 = r58_cash_1;
	}
	public BigDecimal getR58_sovereign_2() {
		return r58_sovereign_2;
	}
	public void setR58_sovereign_2(BigDecimal r58_sovereign_2) {
		this.r58_sovereign_2 = r58_sovereign_2;
	}
	public BigDecimal getR58_others_3() {
		return r58_others_3;
	}
	public void setR58_others_3(BigDecimal r58_others_3) {
		this.r58_others_3 = r58_others_3;
	}
	public BigDecimal getR58_sovereign_4() {
		return r58_sovereign_4;
	}
	public void setR58_sovereign_4(BigDecimal r58_sovereign_4) {
		this.r58_sovereign_4 = r58_sovereign_4;
	}
	public BigDecimal getR58_others_5() {
		return r58_others_5;
	}
	public void setR58_others_5(BigDecimal r58_others_5) {
		this.r58_others_5 = r58_others_5;
	}
	public BigDecimal getR58_sovereign_6() {
		return r58_sovereign_6;
	}
	public void setR58_sovereign_6(BigDecimal r58_sovereign_6) {
		this.r58_sovereign_6 = r58_sovereign_6;
	}
	public BigDecimal getR58_others_7() {
		return r58_others_7;
	}
	public void setR58_others_7(BigDecimal r58_others_7) {
		this.r58_others_7 = r58_others_7;
	}
	public BigDecimal getR58_sovereign_8() {
		return r58_sovereign_8;
	}
	public void setR58_sovereign_8(BigDecimal r58_sovereign_8) {
		this.r58_sovereign_8 = r58_sovereign_8;
	}
	public BigDecimal getR58_others_9() {
		return r58_others_9;
	}
	public void setR58_others_9(BigDecimal r58_others_9) {
		this.r58_others_9 = r58_others_9;
	}
	public BigDecimal getR58_sovereign_10() {
		return r58_sovereign_10;
	}
	public void setR58_sovereign_10(BigDecimal r58_sovereign_10) {
		this.r58_sovereign_10 = r58_sovereign_10;
	}
	public BigDecimal getR58_others_11() {
		return r58_others_11;
	}
	public void setR58_others_11(BigDecimal r58_others_11) {
		this.r58_others_11 = r58_others_11;
	}
	public BigDecimal getR58_sovereign_12() {
		return r58_sovereign_12;
	}
	public void setR58_sovereign_12(BigDecimal r58_sovereign_12) {
		this.r58_sovereign_12 = r58_sovereign_12;
	}
	public BigDecimal getR58_others_13() {
		return r58_others_13;
	}
	public void setR58_others_13(BigDecimal r58_others_13) {
		this.r58_others_13 = r58_others_13;
	}
	public BigDecimal getR58_rated_14() {
		return r58_rated_14;
	}
	public void setR58_rated_14(BigDecimal r58_rated_14) {
		this.r58_rated_14 = r58_rated_14;
	}
	public BigDecimal getR58_main_index_15() {
		return r58_main_index_15;
	}
	public void setR58_main_index_15(BigDecimal r58_main_index_15) {
		this.r58_main_index_15 = r58_main_index_15;
	}
	public BigDecimal getR58_other_equities_16() {
		return r58_other_equities_16;
	}
	public void setR58_other_equities_16(BigDecimal r58_other_equities_16) {
		this.r58_other_equities_16 = r58_other_equities_16;
	}
	public BigDecimal getR58_mutual_funds_17() {
		return r58_mutual_funds_17;
	}
	public void setR58_mutual_funds_17(BigDecimal r58_mutual_funds_17) {
		this.r58_mutual_funds_17 = r58_mutual_funds_17;
	}
	public BigDecimal getR58_total_collateral_19() {
		return r58_total_collateral_19;
	}
	public void setR58_total_collateral_19(BigDecimal r58_total_collateral_19) {
		this.r58_total_collateral_19 = r58_total_collateral_19;
	}
	public BigDecimal getR58_net_collateral_20() {
		return r58_net_collateral_20;
	}
	public void setR58_net_collateral_20(BigDecimal r58_net_collateral_20) {
		this.r58_net_collateral_20 = r58_net_collateral_20;
	}
	public BigDecimal getR58_net_collateral_21() {
		return r58_net_collateral_21;
	}
	public void setR58_net_collateral_21(BigDecimal r58_net_collateral_21) {
		this.r58_net_collateral_21 = r58_net_collateral_21;
	}
	public String getR59_product() {
		return r59_product;
	}
	public void setR59_product(String r59_product) {
		this.r59_product = r59_product;
	}
	public String getR59_risk_weight() {
		return r59_risk_weight;
	}
	public void setR59_risk_weight(String r59_risk_weight) {
		this.r59_risk_weight = r59_risk_weight;
	}
	public BigDecimal getR59_total_exposure_0() {
		return r59_total_exposure_0;
	}
	public void setR59_total_exposure_0(BigDecimal r59_total_exposure_0) {
		this.r59_total_exposure_0 = r59_total_exposure_0;
	}
	public String getR60_product() {
		return r60_product;
	}
	public void setR60_product(String r60_product) {
		this.r60_product = r60_product;
	}
	public String getR61_risk_weight() {
		return r61_risk_weight;
	}
	public void setR61_risk_weight(String r61_risk_weight) {
		this.r61_risk_weight = r61_risk_weight;
	}
	public BigDecimal getR61_total_exposure_0() {
		return r61_total_exposure_0;
	}
	public void setR61_total_exposure_0(BigDecimal r61_total_exposure_0) {
		this.r61_total_exposure_0 = r61_total_exposure_0;
	}
	public String getR62_risk_weight() {
		return r62_risk_weight;
	}
	public void setR62_risk_weight(String r62_risk_weight) {
		this.r62_risk_weight = r62_risk_weight;
	}
	public BigDecimal getR62_total_exposure_20() {
		return r62_total_exposure_20;
	}
	public void setR62_total_exposure_20(BigDecimal r62_total_exposure_20) {
		this.r62_total_exposure_20 = r62_total_exposure_20;
	}
	public BigDecimal getR62_cash_1() {
		return r62_cash_1;
	}
	public void setR62_cash_1(BigDecimal r62_cash_1) {
		this.r62_cash_1 = r62_cash_1;
	}
	public BigDecimal getR62_sovereign_2() {
		return r62_sovereign_2;
	}
	public void setR62_sovereign_2(BigDecimal r62_sovereign_2) {
		this.r62_sovereign_2 = r62_sovereign_2;
	}
	public BigDecimal getR62_others_3() {
		return r62_others_3;
	}
	public void setR62_others_3(BigDecimal r62_others_3) {
		this.r62_others_3 = r62_others_3;
	}
	public BigDecimal getR62_sovereign_4() {
		return r62_sovereign_4;
	}
	public void setR62_sovereign_4(BigDecimal r62_sovereign_4) {
		this.r62_sovereign_4 = r62_sovereign_4;
	}
	public BigDecimal getR62_others_5() {
		return r62_others_5;
	}
	public void setR62_others_5(BigDecimal r62_others_5) {
		this.r62_others_5 = r62_others_5;
	}
	public BigDecimal getR62_sovereign_6() {
		return r62_sovereign_6;
	}
	public void setR62_sovereign_6(BigDecimal r62_sovereign_6) {
		this.r62_sovereign_6 = r62_sovereign_6;
	}
	public BigDecimal getR62_others_7() {
		return r62_others_7;
	}
	public void setR62_others_7(BigDecimal r62_others_7) {
		this.r62_others_7 = r62_others_7;
	}
	public BigDecimal getR62_sovereign_8() {
		return r62_sovereign_8;
	}
	public void setR62_sovereign_8(BigDecimal r62_sovereign_8) {
		this.r62_sovereign_8 = r62_sovereign_8;
	}
	public BigDecimal getR62_others_9() {
		return r62_others_9;
	}
	public void setR62_others_9(BigDecimal r62_others_9) {
		this.r62_others_9 = r62_others_9;
	}
	public BigDecimal getR62_sovereign_10() {
		return r62_sovereign_10;
	}
	public void setR62_sovereign_10(BigDecimal r62_sovereign_10) {
		this.r62_sovereign_10 = r62_sovereign_10;
	}
	public BigDecimal getR62_others_11() {
		return r62_others_11;
	}
	public void setR62_others_11(BigDecimal r62_others_11) {
		this.r62_others_11 = r62_others_11;
	}
	public BigDecimal getR62_sovereign_12() {
		return r62_sovereign_12;
	}
	public void setR62_sovereign_12(BigDecimal r62_sovereign_12) {
		this.r62_sovereign_12 = r62_sovereign_12;
	}
	public BigDecimal getR62_others_13() {
		return r62_others_13;
	}
	public void setR62_others_13(BigDecimal r62_others_13) {
		this.r62_others_13 = r62_others_13;
	}
	public BigDecimal getR62_rated_14() {
		return r62_rated_14;
	}
	public void setR62_rated_14(BigDecimal r62_rated_14) {
		this.r62_rated_14 = r62_rated_14;
	}
	public BigDecimal getR62_main_index_15() {
		return r62_main_index_15;
	}
	public void setR62_main_index_15(BigDecimal r62_main_index_15) {
		this.r62_main_index_15 = r62_main_index_15;
	}
	public BigDecimal getR62_other_equities_16() {
		return r62_other_equities_16;
	}
	public void setR62_other_equities_16(BigDecimal r62_other_equities_16) {
		this.r62_other_equities_16 = r62_other_equities_16;
	}
	public BigDecimal getR62_mutual_funds_17() {
		return r62_mutual_funds_17;
	}
	public void setR62_mutual_funds_17(BigDecimal r62_mutual_funds_17) {
		this.r62_mutual_funds_17 = r62_mutual_funds_17;
	}
	public BigDecimal getR62_total_collateral_19() {
		return r62_total_collateral_19;
	}
	public void setR62_total_collateral_19(BigDecimal r62_total_collateral_19) {
		this.r62_total_collateral_19 = r62_total_collateral_19;
	}
	public BigDecimal getR62_net_collateral_20() {
		return r62_net_collateral_20;
	}
	public void setR62_net_collateral_20(BigDecimal r62_net_collateral_20) {
		this.r62_net_collateral_20 = r62_net_collateral_20;
	}
	public BigDecimal getR62_net_collateral_21() {
		return r62_net_collateral_21;
	}
	public void setR62_net_collateral_21(BigDecimal r62_net_collateral_21) {
		this.r62_net_collateral_21 = r62_net_collateral_21;
	}
	public String getR63_risk_weight() {
		return r63_risk_weight;
	}
	public void setR63_risk_weight(String r63_risk_weight) {
		this.r63_risk_weight = r63_risk_weight;
	}
	public BigDecimal getR63_total_exposure_50() {
		return r63_total_exposure_50;
	}
	public void setR63_total_exposure_50(BigDecimal r63_total_exposure_50) {
		this.r63_total_exposure_50 = r63_total_exposure_50;
	}
	public BigDecimal getR63_cash_1() {
		return r63_cash_1;
	}
	public void setR63_cash_1(BigDecimal r63_cash_1) {
		this.r63_cash_1 = r63_cash_1;
	}
	public BigDecimal getR63_sovereign_2() {
		return r63_sovereign_2;
	}
	public void setR63_sovereign_2(BigDecimal r63_sovereign_2) {
		this.r63_sovereign_2 = r63_sovereign_2;
	}
	public BigDecimal getR63_others_3() {
		return r63_others_3;
	}
	public void setR63_others_3(BigDecimal r63_others_3) {
		this.r63_others_3 = r63_others_3;
	}
	public BigDecimal getR63_sovereign_4() {
		return r63_sovereign_4;
	}
	public void setR63_sovereign_4(BigDecimal r63_sovereign_4) {
		this.r63_sovereign_4 = r63_sovereign_4;
	}
	public BigDecimal getR63_others_5() {
		return r63_others_5;
	}
	public void setR63_others_5(BigDecimal r63_others_5) {
		this.r63_others_5 = r63_others_5;
	}
	public BigDecimal getR63_sovereign_6() {
		return r63_sovereign_6;
	}
	public void setR63_sovereign_6(BigDecimal r63_sovereign_6) {
		this.r63_sovereign_6 = r63_sovereign_6;
	}
	public BigDecimal getR63_others_7() {
		return r63_others_7;
	}
	public void setR63_others_7(BigDecimal r63_others_7) {
		this.r63_others_7 = r63_others_7;
	}
	public BigDecimal getR63_sovereign_8() {
		return r63_sovereign_8;
	}
	public void setR63_sovereign_8(BigDecimal r63_sovereign_8) {
		this.r63_sovereign_8 = r63_sovereign_8;
	}
	public BigDecimal getR63_others_9() {
		return r63_others_9;
	}
	public void setR63_others_9(BigDecimal r63_others_9) {
		this.r63_others_9 = r63_others_9;
	}
	public BigDecimal getR63_sovereign_10() {
		return r63_sovereign_10;
	}
	public void setR63_sovereign_10(BigDecimal r63_sovereign_10) {
		this.r63_sovereign_10 = r63_sovereign_10;
	}
	public BigDecimal getR63_others_11() {
		return r63_others_11;
	}
	public void setR63_others_11(BigDecimal r63_others_11) {
		this.r63_others_11 = r63_others_11;
	}
	public BigDecimal getR63_sovereign_12() {
		return r63_sovereign_12;
	}
	public void setR63_sovereign_12(BigDecimal r63_sovereign_12) {
		this.r63_sovereign_12 = r63_sovereign_12;
	}
	public BigDecimal getR63_others_13() {
		return r63_others_13;
	}
	public void setR63_others_13(BigDecimal r63_others_13) {
		this.r63_others_13 = r63_others_13;
	}
	public BigDecimal getR63_rated_14() {
		return r63_rated_14;
	}
	public void setR63_rated_14(BigDecimal r63_rated_14) {
		this.r63_rated_14 = r63_rated_14;
	}
	public BigDecimal getR63_main_index_15() {
		return r63_main_index_15;
	}
	public void setR63_main_index_15(BigDecimal r63_main_index_15) {
		this.r63_main_index_15 = r63_main_index_15;
	}
	public BigDecimal getR63_other_equities_16() {
		return r63_other_equities_16;
	}
	public void setR63_other_equities_16(BigDecimal r63_other_equities_16) {
		this.r63_other_equities_16 = r63_other_equities_16;
	}
	public BigDecimal getR63_mutual_funds_17() {
		return r63_mutual_funds_17;
	}
	public void setR63_mutual_funds_17(BigDecimal r63_mutual_funds_17) {
		this.r63_mutual_funds_17 = r63_mutual_funds_17;
	}
	public BigDecimal getR63_total_collateral_19() {
		return r63_total_collateral_19;
	}
	public void setR63_total_collateral_19(BigDecimal r63_total_collateral_19) {
		this.r63_total_collateral_19 = r63_total_collateral_19;
	}
	public BigDecimal getR63_net_collateral_20() {
		return r63_net_collateral_20;
	}
	public void setR63_net_collateral_20(BigDecimal r63_net_collateral_20) {
		this.r63_net_collateral_20 = r63_net_collateral_20;
	}
	public BigDecimal getR63_net_collateral_21() {
		return r63_net_collateral_21;
	}
	public void setR63_net_collateral_21(BigDecimal r63_net_collateral_21) {
		this.r63_net_collateral_21 = r63_net_collateral_21;
	}
	public String getR64_risk_weight() {
		return r64_risk_weight;
	}
	public void setR64_risk_weight(String r64_risk_weight) {
		this.r64_risk_weight = r64_risk_weight;
	}
	public BigDecimal getR64_total_exposure_100() {
		return r64_total_exposure_100;
	}
	public void setR64_total_exposure_100(BigDecimal r64_total_exposure_100) {
		this.r64_total_exposure_100 = r64_total_exposure_100;
	}
	public BigDecimal getR64_cash_1() {
		return r64_cash_1;
	}
	public void setR64_cash_1(BigDecimal r64_cash_1) {
		this.r64_cash_1 = r64_cash_1;
	}
	public BigDecimal getR64_sovereign_2() {
		return r64_sovereign_2;
	}
	public void setR64_sovereign_2(BigDecimal r64_sovereign_2) {
		this.r64_sovereign_2 = r64_sovereign_2;
	}
	public BigDecimal getR64_others_3() {
		return r64_others_3;
	}
	public void setR64_others_3(BigDecimal r64_others_3) {
		this.r64_others_3 = r64_others_3;
	}
	public BigDecimal getR64_sovereign_4() {
		return r64_sovereign_4;
	}
	public void setR64_sovereign_4(BigDecimal r64_sovereign_4) {
		this.r64_sovereign_4 = r64_sovereign_4;
	}
	public BigDecimal getR64_others_5() {
		return r64_others_5;
	}
	public void setR64_others_5(BigDecimal r64_others_5) {
		this.r64_others_5 = r64_others_5;
	}
	public BigDecimal getR64_sovereign_6() {
		return r64_sovereign_6;
	}
	public void setR64_sovereign_6(BigDecimal r64_sovereign_6) {
		this.r64_sovereign_6 = r64_sovereign_6;
	}
	public BigDecimal getR64_others_7() {
		return r64_others_7;
	}
	public void setR64_others_7(BigDecimal r64_others_7) {
		this.r64_others_7 = r64_others_7;
	}
	public BigDecimal getR64_sovereign_8() {
		return r64_sovereign_8;
	}
	public void setR64_sovereign_8(BigDecimal r64_sovereign_8) {
		this.r64_sovereign_8 = r64_sovereign_8;
	}
	public BigDecimal getR64_others_9() {
		return r64_others_9;
	}
	public void setR64_others_9(BigDecimal r64_others_9) {
		this.r64_others_9 = r64_others_9;
	}
	public BigDecimal getR64_sovereign_10() {
		return r64_sovereign_10;
	}
	public void setR64_sovereign_10(BigDecimal r64_sovereign_10) {
		this.r64_sovereign_10 = r64_sovereign_10;
	}
	public BigDecimal getR64_others_11() {
		return r64_others_11;
	}
	public void setR64_others_11(BigDecimal r64_others_11) {
		this.r64_others_11 = r64_others_11;
	}
	public BigDecimal getR64_sovereign_12() {
		return r64_sovereign_12;
	}
	public void setR64_sovereign_12(BigDecimal r64_sovereign_12) {
		this.r64_sovereign_12 = r64_sovereign_12;
	}
	public BigDecimal getR64_others_13() {
		return r64_others_13;
	}
	public void setR64_others_13(BigDecimal r64_others_13) {
		this.r64_others_13 = r64_others_13;
	}
	public BigDecimal getR64_rated_14() {
		return r64_rated_14;
	}
	public void setR64_rated_14(BigDecimal r64_rated_14) {
		this.r64_rated_14 = r64_rated_14;
	}
	public BigDecimal getR64_main_index_15() {
		return r64_main_index_15;
	}
	public void setR64_main_index_15(BigDecimal r64_main_index_15) {
		this.r64_main_index_15 = r64_main_index_15;
	}
	public BigDecimal getR64_other_equities_16() {
		return r64_other_equities_16;
	}
	public void setR64_other_equities_16(BigDecimal r64_other_equities_16) {
		this.r64_other_equities_16 = r64_other_equities_16;
	}
	public BigDecimal getR64_mutual_funds_17() {
		return r64_mutual_funds_17;
	}
	public void setR64_mutual_funds_17(BigDecimal r64_mutual_funds_17) {
		this.r64_mutual_funds_17 = r64_mutual_funds_17;
	}
	public BigDecimal getR64_total_collateral_19() {
		return r64_total_collateral_19;
	}
	public void setR64_total_collateral_19(BigDecimal r64_total_collateral_19) {
		this.r64_total_collateral_19 = r64_total_collateral_19;
	}
	public BigDecimal getR64_net_collateral_20() {
		return r64_net_collateral_20;
	}
	public void setR64_net_collateral_20(BigDecimal r64_net_collateral_20) {
		this.r64_net_collateral_20 = r64_net_collateral_20;
	}
	public BigDecimal getR64_net_collateral_21() {
		return r64_net_collateral_21;
	}
	public void setR64_net_collateral_21(BigDecimal r64_net_collateral_21) {
		this.r64_net_collateral_21 = r64_net_collateral_21;
	}
	public String getR65_risk_weight() {
		return r65_risk_weight;
	}
	public void setR65_risk_weight(String r65_risk_weight) {
		this.r65_risk_weight = r65_risk_weight;
	}
	public BigDecimal getR65_total_exposure_100() {
		return r65_total_exposure_100;
	}
	public void setR65_total_exposure_100(BigDecimal r65_total_exposure_100) {
		this.r65_total_exposure_100 = r65_total_exposure_100;
	}
	public BigDecimal getR65_cash_1() {
		return r65_cash_1;
	}
	public void setR65_cash_1(BigDecimal r65_cash_1) {
		this.r65_cash_1 = r65_cash_1;
	}
	public BigDecimal getR65_sovereign_2() {
		return r65_sovereign_2;
	}
	public void setR65_sovereign_2(BigDecimal r65_sovereign_2) {
		this.r65_sovereign_2 = r65_sovereign_2;
	}
	public BigDecimal getR65_others_3() {
		return r65_others_3;
	}
	public void setR65_others_3(BigDecimal r65_others_3) {
		this.r65_others_3 = r65_others_3;
	}
	public BigDecimal getR65_sovereign_4() {
		return r65_sovereign_4;
	}
	public void setR65_sovereign_4(BigDecimal r65_sovereign_4) {
		this.r65_sovereign_4 = r65_sovereign_4;
	}
	public BigDecimal getR65_others_5() {
		return r65_others_5;
	}
	public void setR65_others_5(BigDecimal r65_others_5) {
		this.r65_others_5 = r65_others_5;
	}
	public BigDecimal getR65_sovereign_6() {
		return r65_sovereign_6;
	}
	public void setR65_sovereign_6(BigDecimal r65_sovereign_6) {
		this.r65_sovereign_6 = r65_sovereign_6;
	}
	public BigDecimal getR65_others_7() {
		return r65_others_7;
	}
	public void setR65_others_7(BigDecimal r65_others_7) {
		this.r65_others_7 = r65_others_7;
	}
	public BigDecimal getR65_sovereign_8() {
		return r65_sovereign_8;
	}
	public void setR65_sovereign_8(BigDecimal r65_sovereign_8) {
		this.r65_sovereign_8 = r65_sovereign_8;
	}
	public BigDecimal getR65_others_9() {
		return r65_others_9;
	}
	public void setR65_others_9(BigDecimal r65_others_9) {
		this.r65_others_9 = r65_others_9;
	}
	public BigDecimal getR65_sovereign_10() {
		return r65_sovereign_10;
	}
	public void setR65_sovereign_10(BigDecimal r65_sovereign_10) {
		this.r65_sovereign_10 = r65_sovereign_10;
	}
	public BigDecimal getR65_others_11() {
		return r65_others_11;
	}
	public void setR65_others_11(BigDecimal r65_others_11) {
		this.r65_others_11 = r65_others_11;
	}
	public BigDecimal getR65_sovereign_12() {
		return r65_sovereign_12;
	}
	public void setR65_sovereign_12(BigDecimal r65_sovereign_12) {
		this.r65_sovereign_12 = r65_sovereign_12;
	}
	public BigDecimal getR65_others_13() {
		return r65_others_13;
	}
	public void setR65_others_13(BigDecimal r65_others_13) {
		this.r65_others_13 = r65_others_13;
	}
	public BigDecimal getR65_rated_14() {
		return r65_rated_14;
	}
	public void setR65_rated_14(BigDecimal r65_rated_14) {
		this.r65_rated_14 = r65_rated_14;
	}
	public BigDecimal getR65_main_index_15() {
		return r65_main_index_15;
	}
	public void setR65_main_index_15(BigDecimal r65_main_index_15) {
		this.r65_main_index_15 = r65_main_index_15;
	}
	public BigDecimal getR65_other_equities_16() {
		return r65_other_equities_16;
	}
	public void setR65_other_equities_16(BigDecimal r65_other_equities_16) {
		this.r65_other_equities_16 = r65_other_equities_16;
	}
	public BigDecimal getR65_mutual_funds_17() {
		return r65_mutual_funds_17;
	}
	public void setR65_mutual_funds_17(BigDecimal r65_mutual_funds_17) {
		this.r65_mutual_funds_17 = r65_mutual_funds_17;
	}
	public BigDecimal getR65_total_collateral_19() {
		return r65_total_collateral_19;
	}
	public void setR65_total_collateral_19(BigDecimal r65_total_collateral_19) {
		this.r65_total_collateral_19 = r65_total_collateral_19;
	}
	public BigDecimal getR65_net_collateral_20() {
		return r65_net_collateral_20;
	}
	public void setR65_net_collateral_20(BigDecimal r65_net_collateral_20) {
		this.r65_net_collateral_20 = r65_net_collateral_20;
	}
	public BigDecimal getR65_net_collateral_21() {
		return r65_net_collateral_21;
	}
	public void setR65_net_collateral_21(BigDecimal r65_net_collateral_21) {
		this.r65_net_collateral_21 = r65_net_collateral_21;
	}
	public String getR66_product() {
		return r66_product;
	}
	public void setR66_product(String r66_product) {
		this.r66_product = r66_product;
	}
	public String getR66_risk_weight() {
		return r66_risk_weight;
	}
	public void setR66_risk_weight(String r66_risk_weight) {
		this.r66_risk_weight = r66_risk_weight;
	}
	public BigDecimal getR66_total_exposure_100() {
		return r66_total_exposure_100;
	}
	public void setR66_total_exposure_100(BigDecimal r66_total_exposure_100) {
		this.r66_total_exposure_100 = r66_total_exposure_100;
	}
	public BigDecimal getR66_cash_1() {
		return r66_cash_1;
	}
	public void setR66_cash_1(BigDecimal r66_cash_1) {
		this.r66_cash_1 = r66_cash_1;
	}
	public BigDecimal getR66_sovereign_2() {
		return r66_sovereign_2;
	}
	public void setR66_sovereign_2(BigDecimal r66_sovereign_2) {
		this.r66_sovereign_2 = r66_sovereign_2;
	}
	public BigDecimal getR66_others_3() {
		return r66_others_3;
	}
	public void setR66_others_3(BigDecimal r66_others_3) {
		this.r66_others_3 = r66_others_3;
	}
	public BigDecimal getR66_sovereign_4() {
		return r66_sovereign_4;
	}
	public void setR66_sovereign_4(BigDecimal r66_sovereign_4) {
		this.r66_sovereign_4 = r66_sovereign_4;
	}
	public BigDecimal getR66_others_5() {
		return r66_others_5;
	}
	public void setR66_others_5(BigDecimal r66_others_5) {
		this.r66_others_5 = r66_others_5;
	}
	public BigDecimal getR66_sovereign_6() {
		return r66_sovereign_6;
	}
	public void setR66_sovereign_6(BigDecimal r66_sovereign_6) {
		this.r66_sovereign_6 = r66_sovereign_6;
	}
	public BigDecimal getR66_others_7() {
		return r66_others_7;
	}
	public void setR66_others_7(BigDecimal r66_others_7) {
		this.r66_others_7 = r66_others_7;
	}
	public BigDecimal getR66_sovereign_8() {
		return r66_sovereign_8;
	}
	public void setR66_sovereign_8(BigDecimal r66_sovereign_8) {
		this.r66_sovereign_8 = r66_sovereign_8;
	}
	public BigDecimal getR66_others_9() {
		return r66_others_9;
	}
	public void setR66_others_9(BigDecimal r66_others_9) {
		this.r66_others_9 = r66_others_9;
	}
	public BigDecimal getR66_sovereign_10() {
		return r66_sovereign_10;
	}
	public void setR66_sovereign_10(BigDecimal r66_sovereign_10) {
		this.r66_sovereign_10 = r66_sovereign_10;
	}
	public BigDecimal getR66_others_11() {
		return r66_others_11;
	}
	public void setR66_others_11(BigDecimal r66_others_11) {
		this.r66_others_11 = r66_others_11;
	}
	public BigDecimal getR66_sovereign_12() {
		return r66_sovereign_12;
	}
	public void setR66_sovereign_12(BigDecimal r66_sovereign_12) {
		this.r66_sovereign_12 = r66_sovereign_12;
	}
	public BigDecimal getR66_others_13() {
		return r66_others_13;
	}
	public void setR66_others_13(BigDecimal r66_others_13) {
		this.r66_others_13 = r66_others_13;
	}
	public BigDecimal getR66_rated_14() {
		return r66_rated_14;
	}
	public void setR66_rated_14(BigDecimal r66_rated_14) {
		this.r66_rated_14 = r66_rated_14;
	}
	public BigDecimal getR66_main_index_15() {
		return r66_main_index_15;
	}
	public void setR66_main_index_15(BigDecimal r66_main_index_15) {
		this.r66_main_index_15 = r66_main_index_15;
	}
	public BigDecimal getR66_other_equities_16() {
		return r66_other_equities_16;
	}
	public void setR66_other_equities_16(BigDecimal r66_other_equities_16) {
		this.r66_other_equities_16 = r66_other_equities_16;
	}
	public BigDecimal getR66_mutual_funds_17() {
		return r66_mutual_funds_17;
	}
	public void setR66_mutual_funds_17(BigDecimal r66_mutual_funds_17) {
		this.r66_mutual_funds_17 = r66_mutual_funds_17;
	}
	public BigDecimal getR66_total_collateral_19() {
		return r66_total_collateral_19;
	}
	public void setR66_total_collateral_19(BigDecimal r66_total_collateral_19) {
		this.r66_total_collateral_19 = r66_total_collateral_19;
	}
	public BigDecimal getR66_net_collateral_20() {
		return r66_net_collateral_20;
	}
	public void setR66_net_collateral_20(BigDecimal r66_net_collateral_20) {
		this.r66_net_collateral_20 = r66_net_collateral_20;
	}
	public BigDecimal getR66_net_collateral_21() {
		return r66_net_collateral_21;
	}
	public void setR66_net_collateral_21(BigDecimal r66_net_collateral_21) {
		this.r66_net_collateral_21 = r66_net_collateral_21;
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
	public BigDecimal getR20_cash_1() {
		return r20_cash_1;
	}
	public void setR20_cash_1(BigDecimal r20_cash_1) {
		this.r20_cash_1 = r20_cash_1;
	}
	public BigDecimal getR20_sovereign_2() {
		return r20_sovereign_2;
	}
	public void setR20_sovereign_2(BigDecimal r20_sovereign_2) {
		this.r20_sovereign_2 = r20_sovereign_2;
	}
	public BigDecimal getR20_others_3() {
		return r20_others_3;
	}
	public void setR20_others_3(BigDecimal r20_others_3) {
		this.r20_others_3 = r20_others_3;
	}
	public BigDecimal getR20_sovereign_4() {
		return r20_sovereign_4;
	}
	public void setR20_sovereign_4(BigDecimal r20_sovereign_4) {
		this.r20_sovereign_4 = r20_sovereign_4;
	}
	public BigDecimal getR20_others_5() {
		return r20_others_5;
	}
	public void setR20_others_5(BigDecimal r20_others_5) {
		this.r20_others_5 = r20_others_5;
	}
	public BigDecimal getR20_sovereign_6() {
		return r20_sovereign_6;
	}
	public void setR20_sovereign_6(BigDecimal r20_sovereign_6) {
		this.r20_sovereign_6 = r20_sovereign_6;
	}
	public BigDecimal getR20_others_7() {
		return r20_others_7;
	}
	public void setR20_others_7(BigDecimal r20_others_7) {
		this.r20_others_7 = r20_others_7;
	}
	public BigDecimal getR20_sovereign_8() {
		return r20_sovereign_8;
	}
	public void setR20_sovereign_8(BigDecimal r20_sovereign_8) {
		this.r20_sovereign_8 = r20_sovereign_8;
	}
	public BigDecimal getR20_others_9() {
		return r20_others_9;
	}
	public void setR20_others_9(BigDecimal r20_others_9) {
		this.r20_others_9 = r20_others_9;
	}
	public BigDecimal getR20_sovereign_10() {
		return r20_sovereign_10;
	}
	public void setR20_sovereign_10(BigDecimal r20_sovereign_10) {
		this.r20_sovereign_10 = r20_sovereign_10;
	}
	public BigDecimal getR20_others_11() {
		return r20_others_11;
	}
	public void setR20_others_11(BigDecimal r20_others_11) {
		this.r20_others_11 = r20_others_11;
	}
	public BigDecimal getR20_sovereign_12() {
		return r20_sovereign_12;
	}
	public void setR20_sovereign_12(BigDecimal r20_sovereign_12) {
		this.r20_sovereign_12 = r20_sovereign_12;
	}
	public BigDecimal getR20_others_13() {
		return r20_others_13;
	}
	public void setR20_others_13(BigDecimal r20_others_13) {
		this.r20_others_13 = r20_others_13;
	}
	public BigDecimal getR20_rated_14() {
		return r20_rated_14;
	}
	public void setR20_rated_14(BigDecimal r20_rated_14) {
		this.r20_rated_14 = r20_rated_14;
	}
	public BigDecimal getR20_main_index_15() {
		return r20_main_index_15;
	}
	public void setR20_main_index_15(BigDecimal r20_main_index_15) {
		this.r20_main_index_15 = r20_main_index_15;
	}
	public BigDecimal getR20_other_equities_16() {
		return r20_other_equities_16;
	}
	public void setR20_other_equities_16(BigDecimal r20_other_equities_16) {
		this.r20_other_equities_16 = r20_other_equities_16;
	}
	public BigDecimal getR20_mutual_funds_17() {
		return r20_mutual_funds_17;
	}
	public void setR20_mutual_funds_17(BigDecimal r20_mutual_funds_17) {
		this.r20_mutual_funds_17 = r20_mutual_funds_17;
	}
	public BigDecimal getR20_total_collateral_19() {
		return r20_total_collateral_19;
	}
	public void setR20_total_collateral_19(BigDecimal r20_total_collateral_19) {
		this.r20_total_collateral_19 = r20_total_collateral_19;
	}
	public BigDecimal getR20_net_collateral_20() {
		return r20_net_collateral_20;
	}
	public void setR20_net_collateral_20(BigDecimal r20_net_collateral_20) {
		this.r20_net_collateral_20 = r20_net_collateral_20;
	}
	public BigDecimal getR20_net_collateral_21() {
		return r20_net_collateral_21;
	}
	public void setR20_net_collateral_21(BigDecimal r20_net_collateral_21) {
		this.r20_net_collateral_21 = r20_net_collateral_21;
	}
	public BigDecimal getR60_total_exposure_0() {
		return r60_total_exposure_0;
	}
	public void setR60_total_exposure_0(BigDecimal r60_total_exposure_0) {
		this.r60_total_exposure_0 = r60_total_exposure_0;
	}
	public String getR60_risk_weight() {
		return r60_risk_weight;
	}
	public void setR60_risk_weight(String r60_risk_weight) {
		this.r60_risk_weight = r60_risk_weight;
	}
	public BigDecimal getR60_total_exposure_20() {
		return r60_total_exposure_20;
	}
	public void setR60_total_exposure_20(BigDecimal r60_total_exposure_20) {
		this.r60_total_exposure_20 = r60_total_exposure_20;
	}
	public BigDecimal getR60_cash_1() {
		return r60_cash_1;
	}
	public void setR60_cash_1(BigDecimal r60_cash_1) {
		this.r60_cash_1 = r60_cash_1;
	}
	public BigDecimal getR60_sovereign_2() {
		return r60_sovereign_2;
	}
	public void setR60_sovereign_2(BigDecimal r60_sovereign_2) {
		this.r60_sovereign_2 = r60_sovereign_2;
	}
	public BigDecimal getR60_others_3() {
		return r60_others_3;
	}
	public void setR60_others_3(BigDecimal r60_others_3) {
		this.r60_others_3 = r60_others_3;
	}
	public BigDecimal getR60_sovereign_4() {
		return r60_sovereign_4;
	}
	public void setR60_sovereign_4(BigDecimal r60_sovereign_4) {
		this.r60_sovereign_4 = r60_sovereign_4;
	}
	public BigDecimal getR60_others_5() {
		return r60_others_5;
	}
	public void setR60_others_5(BigDecimal r60_others_5) {
		this.r60_others_5 = r60_others_5;
	}
	public BigDecimal getR60_sovereign_6() {
		return r60_sovereign_6;
	}
	public void setR60_sovereign_6(BigDecimal r60_sovereign_6) {
		this.r60_sovereign_6 = r60_sovereign_6;
	}
	public BigDecimal getR60_others_7() {
		return r60_others_7;
	}
	public void setR60_others_7(BigDecimal r60_others_7) {
		this.r60_others_7 = r60_others_7;
	}
	public BigDecimal getR60_sovereign_8() {
		return r60_sovereign_8;
	}
	public void setR60_sovereign_8(BigDecimal r60_sovereign_8) {
		this.r60_sovereign_8 = r60_sovereign_8;
	}
	public BigDecimal getR60_others_9() {
		return r60_others_9;
	}
	public void setR60_others_9(BigDecimal r60_others_9) {
		this.r60_others_9 = r60_others_9;
	}
	public BigDecimal getR60_sovereign_10() {
		return r60_sovereign_10;
	}
	public void setR60_sovereign_10(BigDecimal r60_sovereign_10) {
		this.r60_sovereign_10 = r60_sovereign_10;
	}
	public BigDecimal getR60_others_11() {
		return r60_others_11;
	}
	public void setR60_others_11(BigDecimal r60_others_11) {
		this.r60_others_11 = r60_others_11;
	}
	public BigDecimal getR60_sovereign_12() {
		return r60_sovereign_12;
	}
	public void setR60_sovereign_12(BigDecimal r60_sovereign_12) {
		this.r60_sovereign_12 = r60_sovereign_12;
	}
	public BigDecimal getR60_others_13() {
		return r60_others_13;
	}
	public void setR60_others_13(BigDecimal r60_others_13) {
		this.r60_others_13 = r60_others_13;
	}
	public BigDecimal getR60_rated_14() {
		return r60_rated_14;
	}
	public void setR60_rated_14(BigDecimal r60_rated_14) {
		this.r60_rated_14 = r60_rated_14;
	}
	public BigDecimal getR60_main_index_15() {
		return r60_main_index_15;
	}
	public void setR60_main_index_15(BigDecimal r60_main_index_15) {
		this.r60_main_index_15 = r60_main_index_15;
	}
	public BigDecimal getR60_other_equities_16() {
		return r60_other_equities_16;
	}
	public void setR60_other_equities_16(BigDecimal r60_other_equities_16) {
		this.r60_other_equities_16 = r60_other_equities_16;
	}
	public BigDecimal getR60_mutual_funds_17() {
		return r60_mutual_funds_17;
	}
	public void setR60_mutual_funds_17(BigDecimal r60_mutual_funds_17) {
		this.r60_mutual_funds_17 = r60_mutual_funds_17;
	}
	public BigDecimal getR60_total_collateral_19() {
		return r60_total_collateral_19;
	}
	public void setR60_total_collateral_19(BigDecimal r60_total_collateral_19) {
		this.r60_total_collateral_19 = r60_total_collateral_19;
	}
	public BigDecimal getR60_net_collateral_20() {
		return r60_net_collateral_20;
	}
	public void setR60_net_collateral_20(BigDecimal r60_net_collateral_20) {
		this.r60_net_collateral_20 = r60_net_collateral_20;
	}
	public BigDecimal getR60_net_collateral_21() {
		return r60_net_collateral_21;
	}
	public void setR60_net_collateral_21(BigDecimal r60_net_collateral_21) {
		this.r60_net_collateral_21 = r60_net_collateral_21;
	}
	public BASEL_8_ENTITY1() {
		super();
		// TODO Auto-generated constructor stub
	}

}