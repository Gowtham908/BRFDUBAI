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
@Table(name="BRF3_SUMMARYTABLE")
public class BRF003_ENTITY{
	private String	r1_product;
	private BigDecimal	r1_resident_outstand;
	private BigDecimal	r1_non_resident_outstand;
	private String	r2_product;
	private BigDecimal	r2_resident_outstand;
	private BigDecimal	r2_non_resident_outstand;
	private String	r3_product;
	private BigDecimal	r3_resident_outstand;
	private BigDecimal	r3_non_resident_outstand;
	private String	r4_product;
	private BigDecimal	r4_resident_outstand;
	private BigDecimal	r4_non_resident_outstand;
	private String	r5_product;
	private BigDecimal	r5_resident_outstand;
	private BigDecimal	r5_non_resident_outstand;
	private String	r6_product;
	private BigDecimal	r6_resident_outstand;
	private BigDecimal	r6_non_resident_outstand;
	private String	r7_product;
	private BigDecimal	r7_resident_outstand;
	private BigDecimal	r7_non_resident_outstand;
	private String	r8_product;
	private BigDecimal	r8_resident_outstand;
	private BigDecimal	r8_non_resident_outstand;
	private String	r9_product;
	private BigDecimal	r9_resident_outstand;
	private BigDecimal	r9_non_resident_outstand;
	private String	r10_product;
	private BigDecimal	r10_resident_outstand;
	private BigDecimal	r10_non_resident_outstand;
	private String	r11_product;
	private BigDecimal	r11_resident_outstand;
	private BigDecimal	r11_non_resident_outstand;
	private String	r12_product;
	private BigDecimal	r12_resident_outstand;
	private BigDecimal	r12_non_resident_outstand;
	private String	r13_product;
	private BigDecimal	r13_resident_outstand;
	private BigDecimal	r13_non_resident_outstand;
	private String	r14_product;
	private BigDecimal	r14_resident_outstand;
	private BigDecimal	r14_non_resident_outstand;
	private String	r15_product;
	private BigDecimal	r15_resident_outstand;
	private BigDecimal	r15_non_resident_outstand;
	private String	r16_product;
	private BigDecimal	r16_resident_outstand;
	private BigDecimal	r16_non_resident_outstand;
	private String	r17_product;
	private BigDecimal	r17_resident_outstand;
	private BigDecimal	r17_non_resident_outstand;
	private String	r18_product;
	private BigDecimal	r18_resident_outstand;
	private BigDecimal	r18_non_resident_outstand;
	private String	r19_product;
	private BigDecimal	r19_hedging_amount;
	private BigDecimal	r19_trading_amount;
	private BigDecimal	r19_resident_amount;
	private BigDecimal	r19_non_resident_amount;
	private BigDecimal	r19_with1year_amount;
	private BigDecimal	r19_1to3year_amount;
	private BigDecimal	r19_over3year_amount;
	private String	r20_product;
	private BigDecimal	r20_hedging_amount;
	private BigDecimal	r20_trading_amount;
	private BigDecimal	r20_resident_amount;
	private BigDecimal	r20_non_resident_amount;
	private BigDecimal	r20_with1year_amount;
	private BigDecimal	r20_1to3year_amount;
	private BigDecimal	r20_over3year_amount;
	private String	r21_product;
	private BigDecimal	r21_hedging_amount;
	private BigDecimal	r21_trading_amount;
	private BigDecimal	r21_resident_amount;
	private BigDecimal	r21_non_resident_amount;
	private BigDecimal	r21_with1year_amount;
	private BigDecimal	r21_1to3year_amount;
	private BigDecimal	r21_over3year_amount;
	private String	r22_product;
	private BigDecimal	r22_hedging_amount;
	private BigDecimal	r22_trading_amount;
	private BigDecimal	r22_resident_amount;
	private BigDecimal	r22_non_resident_amount;
	private BigDecimal	r22_with1year_amount;
	private BigDecimal	r22_1to3year_amount;
	private BigDecimal	r22_over3year_amount;
	private String	r23_product;
	private BigDecimal	r23_hedging_amount;
	private BigDecimal	r23_trading_amount;
	private BigDecimal	r23_resident_amount;
	private BigDecimal	r23_non_resident_amount;
	private BigDecimal	r23_with1year_amount;
	private BigDecimal	r23_1to3year_amount;
	private BigDecimal	r23_over3year_amount;
	private String	r24_product;
	private BigDecimal	r24_hedging_amount;
	private BigDecimal	r24_trading_amount;
	private BigDecimal	r24_resident_amount;
	private BigDecimal	r24_non_resident_amount;
	private BigDecimal	r24_with1year_amount;
	private BigDecimal	r24_1to3year_amount;
	private BigDecimal	r24_over3year_amount;
	private String	r25_product;
	private BigDecimal	r25_hedging_amount;
	private BigDecimal	r25_trading_amount;
	private BigDecimal	r25_resident_amount;
	private BigDecimal	r25_non_resident_amount;
	private BigDecimal	r25_with1year_amount;
	private BigDecimal	r25_1to3year_amount;
	private BigDecimal	r25_over3year_amount;
	private String	r26_product;
	private BigDecimal	r26_hedging_amount;
	private BigDecimal	r26_trading_amount;
	private BigDecimal	r26_resident_amount;
	private BigDecimal	r26_non_resident_amount;
	private BigDecimal	r26_with1year_amount;
	private BigDecimal	r26_1to3year_amount;
	private BigDecimal	r26_over3year_amount;
	private String	r27_product;
	private BigDecimal	r27_hedging_amount;
	private BigDecimal	r27_trading_amount;
	private BigDecimal	r27_resident_amount;
	private BigDecimal	r27_non_resident_amount;
	private BigDecimal	r27_with1year_amount;
	private BigDecimal	r27_1to3year_amount;
	private BigDecimal	r27_over3year_amount;
	private BigDecimal	r27_10_headging_nl;
	private BigDecimal	r27_10_n_headging_nl_;
	private BigDecimal	r27_10_trading_nl;
	private BigDecimal	r27_10_n_trading_nl_;
	private String	r28_product;
	private BigDecimal	r28_hedging_amount;
	private BigDecimal	r28_trading_amount;
	private BigDecimal	r28_resident_amount;
	private BigDecimal	r28_non_resident_amount;
	private BigDecimal	r28_with1year_amount;
	private BigDecimal	r28_1to3year_amount;
	private BigDecimal	r28_over3year_amount;
	private BigDecimal	r28_10_headging_nl;
	private BigDecimal	r28_10_n_headging_nl_;
	private BigDecimal	r28_10_trading_nl;
	private BigDecimal	r28_10_n_trading_nl_;
	private String	r29_product;
	private BigDecimal	r29_hedging_amount;
	private BigDecimal	r29_trading_amount;
	private BigDecimal	r29_resident_amount;
	private BigDecimal	r29_non_resident_amount;
	private BigDecimal	r29_with1year_amount;
	private BigDecimal	r29_1to3year_amount;
	private BigDecimal	r29_over3year_amount;
	private BigDecimal	r29_10_headging_nl;
	private BigDecimal	r29_10_n_headging_nl_;
	private BigDecimal	r29_10_trading_nl;
	private BigDecimal	r29_10_n_trading_nl_;
	private String	r30_product;
	private BigDecimal	r30_hedging_amount;
	private BigDecimal	r30_trading_amount;
	private BigDecimal	r30_resident_amount;
	private BigDecimal	r30_non_resident_amount;
	private BigDecimal	r30_with1year_amount;
	private BigDecimal	r30_1to3year_amount;
	private BigDecimal	r30_over3year_amount;
	private BigDecimal	r30_10_headging_nl;
	private BigDecimal	r30_10_n_headging_nl_;
	private BigDecimal	r30_10_trading_nl;
	private BigDecimal	r30_10_n_trading_nl_;
	private String	r31_product;
	private BigDecimal	r31_hedging_amount;
	private BigDecimal	r31_trading_amount;
	private BigDecimal	r31_resident_amount;
	private BigDecimal	r31_non_resident_amount;
	private BigDecimal	r31_with1year_amount;
	private BigDecimal	r31_1to3year_amount;
	private BigDecimal	r31_over3year_amount;
	private BigDecimal	r31_10_headging_nl;
	private BigDecimal	r31_10_n_headging_nl_;
	private BigDecimal	r31_10_trading_nl;
	private BigDecimal	r31_10_n_trading_nl_;
	private String	r32_product;
	private BigDecimal	r32_hedging_amount;
	private BigDecimal	r32_trading_amount;
	private BigDecimal	r32_resident_amount;
	private BigDecimal	r32_non_resident_amount;
	private BigDecimal	r32_with1year_amount;
	private BigDecimal	r32_1to3year_amount;
	private BigDecimal	r32_over3year_amount;
	private BigDecimal	r32_10_headging_nl;
	private BigDecimal	r32_10_n_headging_nl_;
	private BigDecimal	r32_10_trading_nl;
	private BigDecimal	r32_10_n_trading_nl_;
	private String	r33_product;
	private BigDecimal	r33_hedging_amount;
	private BigDecimal	r33_trading_amount;
	private BigDecimal	r33_resident_amount;
	private BigDecimal	r33_non_resident_amount;
	private BigDecimal	r33_with1year_amount;
	private BigDecimal	r33_1to3year_amount;
	private BigDecimal	r33_over3year_amount;
	private BigDecimal	r33_10_headging_nl;
	private BigDecimal	r33_10_n_headging_nl_;
	private BigDecimal	r33_10_trading_nl;
	private BigDecimal	r33_10_n_trading_nl_;
	private String	r34_product;
	private BigDecimal	r34_hedging_amount;
	private BigDecimal	r34_trading_amount;
	private BigDecimal	r34_resident_amount;
	private BigDecimal	r34_non_resident_amount;
	private BigDecimal	r34_with1year_amount;
	private BigDecimal	r34_1to3year_amount;
	private BigDecimal	r34_over3year_amount;
	private BigDecimal	r34_10_headging_nl;
	private BigDecimal	r34_10_n_headging_nl_;
	private BigDecimal	r34_10_trading_nl;
	private BigDecimal	r34_10_n_trading_nl_;
	private String	r35_product;
	private BigDecimal	r35_hedging_amount;
	private BigDecimal	r35_trading_amount;
	private BigDecimal	r35_resident_amount;
	private BigDecimal	r35_non_resident_amount;
	private BigDecimal	r35_with1year_amount;
	private BigDecimal	r35_1to3year_amount;
	private BigDecimal	r35_over3year_amount;
	private BigDecimal	r35_10_headging_nl;
	private BigDecimal	r35_10_n_headging_nl_;
	private BigDecimal	r35_10_trading_nl;
	private BigDecimal	r35_10_n_trading_nl_;
	private String	r36_product;
	private BigDecimal	r36_hedging_amount;
	private BigDecimal	r36_trading_amount;
	private BigDecimal	r36_resident_amount;
	private BigDecimal	r36_non_resident_amount;
	private BigDecimal	r36_with1year_amount;
	private BigDecimal	r36_1to3year_amount;
	private BigDecimal	r36_over3year_amount;
	private BigDecimal	r36_10_headging_nl;
	private BigDecimal	r36_10_n_headging_nl_;
	private BigDecimal	r36_10_trading_nl;
	private BigDecimal	r36_10_n_trading_nl_;
	private String	r37_product;
	private BigDecimal	r37_hedging_amount;
	private BigDecimal	r37_trading_amount;
	private BigDecimal	r37_resident_amount;
	private BigDecimal	r37_non_resident_amount;
	private BigDecimal	r37_with1year_amount;
	private BigDecimal	r37_1to3year_amount;
	private BigDecimal	r37_over3year_amount;
	private BigDecimal	r37_10_headging_nl;
	private BigDecimal	r37_10_n_headging_nl_;
	private BigDecimal	r37_10_trading_nl;
	private BigDecimal	r37_10_n_trading_nl_;
	private String	r38_product;
	private BigDecimal	r38_hedging_amount;
	private BigDecimal	r38_trading_amount;
	private BigDecimal	r38_resident_amount;
	private BigDecimal	r38_non_resident_amount;
	private BigDecimal	r38_with1year_amount;
	private BigDecimal	r38_1to3year_amount;
	private BigDecimal	r38_over3year_amount;
	private BigDecimal	r38_bought_headging_nd;
	private BigDecimal	r38_sold_headging_nd;
	private BigDecimal	r38_bought_trading_nd;
	private BigDecimal	r38_sold_trading_nd;
	private String	r39_product;
	private BigDecimal	r39_hedging_amount;
	private BigDecimal	r39_trading_amount;
	private BigDecimal	r39_resident_amount;
	private BigDecimal	r39_non_resident_amount;
	private BigDecimal	r39_with1year_amount;
	private BigDecimal	r39_1to3year_amount;
	private BigDecimal	r39_over3year_amount;
	private BigDecimal	r39_bought_headging_nd;
	private BigDecimal	r39_sold_headging_nd;
	private BigDecimal	r39_bought_trading_nd;
	private BigDecimal	r39_sold_trading_nd;
	private String	r40_product;
	private BigDecimal	r40_hedging_amount;
	private BigDecimal	r40_trading_amount;
	private BigDecimal	r40_resident_amount;
	private BigDecimal	r40_non_resident_amount;
	private BigDecimal	r40_with1year_amount;
	private BigDecimal	r40_1to3year_amount;
	private BigDecimal	r40_over3year_amount;
	private BigDecimal	r40_bought_headging_nd;
	private BigDecimal	r40_sold_headging_nd;
	private BigDecimal	r40_bought_trading_nd;
	private BigDecimal	r40_sold_trading_nd;
	private String	r41_product;
	private BigDecimal	r41_hedging_amount;
	private BigDecimal	r41_trading_amount;
	private BigDecimal	r41_resident_amount;
	private BigDecimal	r41_non_resident_amount;
	private BigDecimal	r41_with1year_amount;
	private BigDecimal	r41_1to3year_amount;
	private BigDecimal	r41_over3year_amount;
	private BigDecimal	r41_bought_headging_nd;
	private BigDecimal	r41_sold_headging_nd;
	private BigDecimal	r41_bought_trading_nd;
	private BigDecimal	r41_sold_trading_nd;
	private String	r42_product;
	private BigDecimal	r42_hedging_amount;
	private BigDecimal	r42_trading_amount;
	private BigDecimal	r42_resident_amount;
	private BigDecimal	r42_non_resident_amount;
	private BigDecimal	r42_with1year_amount;
	private BigDecimal	r42_1to3year_amount;
	private BigDecimal	r42_over3year_amount;
	private BigDecimal	r42_bought_headging_nd;
	private BigDecimal	r42_sold_headging_nd;
	private BigDecimal	r42_bought_trading_nd;
	private BigDecimal	r42_sold_trading_nd;
	private String	r43_product;
	private BigDecimal	r43_hedging_amount;
	private BigDecimal	r43_trading_amount;
	private BigDecimal	r43_resident_amount;
	private BigDecimal	r43_non_resident_amount;
	private BigDecimal	r43_with1year_amount;
	private BigDecimal	r43_1to3year_amount;
	private BigDecimal	r43_over3year_amount;
	private BigDecimal	r43_bought_headging_nd;
	private BigDecimal	r43_sold_headging_nd;
	private BigDecimal	r43_bought_trading_nd;
	private BigDecimal	r43_sold_trading_nd;
	private String	r44_product;
	private BigDecimal	r44_hedging_amount;
	private BigDecimal	r44_trading_amount;
	private BigDecimal	r44_resident_amount;
	private BigDecimal	r44_non_resident_amount;
	private BigDecimal	r44_with1year_amount;
	private BigDecimal	r44_1to3year_amount;
	private BigDecimal	r44_over3year_amount;
	private BigDecimal	r44_bought_headging_nd;
	private BigDecimal	r44_sold_headging_nd;
	private BigDecimal	r44_bought_trading_nd;
	private BigDecimal	r44_sold_trading_nd;
	private String	r45_product;
	private BigDecimal	r45_hedging_amount;
	private BigDecimal	r45_trading_amount;
	private BigDecimal	r45_resident_amount;
	private BigDecimal	r45_non_resident_amount;
	private BigDecimal	r45_with1year_amount;
	private BigDecimal	r45_1to3year_amount;
	private BigDecimal	r45_over3year_amount;
	private BigDecimal	r45_bought_headging_nd;
	private BigDecimal	r45_sold_headging_nd;
	private BigDecimal	r45_bought_trading_nd;
	private BigDecimal	r45_sold_trading_nd;
	private String	r46_product;
	private BigDecimal	r46_hedging_amount;
	private BigDecimal	r46_trading_amount;
	private BigDecimal	r46_resident_amount;
	private BigDecimal	r46_non_resident_amount;
	private BigDecimal	r46_with1year_amount;
	private BigDecimal	r46_1to3year_amount;
	private BigDecimal	r46_over3year_amount;
	private BigDecimal	r46_bought_headging_nd;
	private BigDecimal	r46_sold_headging_nd;
	private BigDecimal	r46_bought_trading_nd;
	private BigDecimal	r46_sold_trading_nd;
	private String	r47_product;
	private BigDecimal	r47_hedging_amount;
	private BigDecimal	r47_trading_amount;
	private BigDecimal	r47_resident_amount;
	private BigDecimal	r47_non_resident_amount;
	private BigDecimal	r47_with1year_amount;
	private BigDecimal	r47_1to3year_amount;
	private BigDecimal	r47_over3year_amount;
	private BigDecimal	r47_2_headging_nl;
	private BigDecimal	r47_2_n_headging_nl_;
	private BigDecimal	r47_2_trading_nl;
	private BigDecimal	r47_2_n_trading_nl_;
	private String	r48_product;
	private BigDecimal	r48_hedging_amount;
	private BigDecimal	r48_trading_amount;
	private BigDecimal	r48_resident_amount;
	private BigDecimal	r48_non_resident_amount;
	private BigDecimal	r48_with1year_amount;
	private BigDecimal	r48_1to3year_amount;
	private BigDecimal	r48_over3year_amount;
	private BigDecimal	r48_2_headging_nl;
	private BigDecimal	r48_2_n_headging_nl_;
	private BigDecimal	r48_2_trading_nl;
	private BigDecimal	r48_2_n_trading_nl_;
	private String	r49_product;
	private BigDecimal	r49_hedging_amount;
	private BigDecimal	r49_trading_amount;
	private BigDecimal	r49_resident_amount;
	private BigDecimal	r49_non_resident_amount;
	private BigDecimal	r49_with1year_amount;
	private BigDecimal	r49_1to3year_amount;
	private BigDecimal	r49_over3year_amount;
	private BigDecimal	r49_2_headging_nl;
	private BigDecimal	r49_2_n_headging_nl_;
	private BigDecimal	r49_2_trading_nl;
	private BigDecimal	r49_2_n_trading_nl_;
	private String	r50_product;
	private BigDecimal	r50_hedging_amount;
	private BigDecimal	r50_trading_amount;
	private BigDecimal	r50_resident_amount;
	private BigDecimal	r50_non_resident_amount;
	private BigDecimal	r50_with1year_amount;
	private BigDecimal	r50_1to3year_amount;
	private BigDecimal	r50_over3year_amount;
	private BigDecimal	r50_2_headging_nl;
	private BigDecimal	r50_2_n_headging_nl_;
	private BigDecimal	r50_2_trading_nl;
	private BigDecimal	r50_2_n_trading_nl_;
	private String	r51_product;
	private BigDecimal	r51_hedging_amount;
	private BigDecimal	r51_trading_amount;
	private BigDecimal	r51_resident_amount;
	private BigDecimal	r51_non_resident_amount;
	private BigDecimal	r51_with1year_amount;
	private BigDecimal	r51_1to3year_amount;
	private BigDecimal	r51_over3year_amount;
	private BigDecimal	r51_2_headging_nl;
	private BigDecimal	r51_2_n_headging_nl_;
	private BigDecimal	r51_2_trading_nl;
	private BigDecimal	r51_2_n_trading_nl_;
	private String	r52_product;
	private BigDecimal	r52_hedging_amount;
	private BigDecimal	r52_trading_amount;
	private BigDecimal	r52_resident_amount;
	private BigDecimal	r52_non_resident_amount;
	private BigDecimal	r52_with1year_amount;
	private BigDecimal	r52_1to3year_amount;
	private BigDecimal	r52_over3year_amount;
	private BigDecimal	r52_10_headging_nl;
	private BigDecimal	r52_10_n_headging_nl_;
	private BigDecimal	r52_10_trading_nl;
	private BigDecimal	r52_10_n_trading_nl_;
	private String	r53_product;
	private BigDecimal	r53_hedging_amount;
	private BigDecimal	r53_trading_amount;
	private BigDecimal	r53_resident_amount;
	private BigDecimal	r53_non_resident_amount;
	private BigDecimal	r53_with1year_amount;
	private BigDecimal	r53_1to3year_amount;
	private BigDecimal	r53_over3year_amount;
	private BigDecimal	r53_10_headging_nl;
	private BigDecimal	r53_10_n_headging_nl_;
	private BigDecimal	r53_10_trading_nl;
	private BigDecimal	r53_10_n_trading_nl_;
	private String	r54_product;
	private BigDecimal	r54_pro_bou_amount;
	private BigDecimal	r54_pro_sold_amount;
	private BigDecimal	r54_resident;
	private BigDecimal	r54_non_resident;
	private BigDecimal	r54_with1year_amount;
	private BigDecimal	r54_1to3year_amount;
	private BigDecimal	r54_over3year_amount;
	private BigDecimal	r54_pro_bou_ngl;
	private BigDecimal	r54_pro_sold_ngl;
	private String	r55_product;
	private BigDecimal	r55_pro_bou_amount;
	private BigDecimal	r55_pro_sold_amount;
	private BigDecimal	r55_resident;
	private BigDecimal	r55_non_resident;
	private BigDecimal	r55_with1year_amount;
	private BigDecimal	r55_1to3year_amount;
	private BigDecimal	r55_over3year_amount;
	private BigDecimal	r55_pro_bou_ngl;
	private BigDecimal	r55_pro_sold_ngl;
	private String	r56_product;
	private BigDecimal	r56_pro_bou_amount;
	private BigDecimal	r56_pro_sold_amount;
	private BigDecimal	r56_resident;
	private BigDecimal	r56_non_resident;
	private BigDecimal	r56_with1year_amount;
	private BigDecimal	r56_1to3year_amount;
	private BigDecimal	r56_over3year_amount;
	private BigDecimal	r56_pro_bou_ngl;
	private BigDecimal	r56_pro_sold_ngl;
	private String	r57_product;
	private BigDecimal	r57_pro_bou_amount;
	private BigDecimal	r57_pro_sold_amount;
	private BigDecimal	r57_resident;
	private BigDecimal	r57_non_resident;
	private BigDecimal	r57_with1year_amount;
	private BigDecimal	r57_1to3year_amount;
	private BigDecimal	r57_over3year_amount;
	private BigDecimal	r57_pro_bou_ngl;
	private BigDecimal	r57_pro_sold_ngl;
	private String	r58_product;
	private BigDecimal	r58_pro_bou_amount;
	private BigDecimal	r58_pro_sold_amount;
	private BigDecimal	r58_resident;
	private BigDecimal	r58_non_resident;
	private BigDecimal	r58_with1year_amount;
	private BigDecimal	r58_1to3year_amount;
	private BigDecimal	r58_over3year_amount;
	private BigDecimal	r58_pro_bou_ngl;
	private BigDecimal	r58_pro_sold_ngl;
	private String	r59_product;
	private BigDecimal	r59_pro_bou_amount;
	private BigDecimal	r59_pro_sold_amount;
	private BigDecimal	r59_resident;
	private BigDecimal	r59_non_resident;
	private BigDecimal	r59_with1year_amount;
	private BigDecimal	r59_1to3year_amount;
	private BigDecimal	r59_over3year_amount;
	private BigDecimal	r59_pro_bou_ngl;
	private BigDecimal	r59_pro_sold_ngl;
	private String	r60_product;
	private BigDecimal	r60_pro_bou_amount;
	private BigDecimal	r60_pro_sold_amount;
	private BigDecimal	r60_resident;
	private BigDecimal	r60_non_resident;
	private BigDecimal	r60_with1year_amount;
	private BigDecimal	r60_1to3year_amount;
	private BigDecimal	r60_over3year_amount;
	private BigDecimal	r60_pro_bou_ngl;
	private BigDecimal	r60_pro_sold_ngl;
	private String	r61_product;
	private BigDecimal	r61_pro_bou_amount;
	private BigDecimal	r61_pro_sold_amount;
	private BigDecimal	r61_resident;
	private BigDecimal	r61_non_resident;
	private BigDecimal	r61_with1year_amount;
	private BigDecimal	r61_1to3year_amount;
	private BigDecimal	r61_over3year_amount;
	private BigDecimal	r61_pro_bou_ngl;
	private BigDecimal	r61_pro_sold_ngl;
	private String	r62_product;
	private BigDecimal	r62_pro_bou_amount;
	private BigDecimal	r62_pro_sold_amount;
	private BigDecimal	r62_resident;
	private BigDecimal	r62_non_resident;
	private BigDecimal	r62_with1year_amount;
	private BigDecimal	r62_1to3year_amount;
	private BigDecimal	r62_over3year_amount;
	private BigDecimal	r62_pro_bou_ngl;
	private BigDecimal	r62_pro_sold_ngl;
	private String	r63_product;
	private BigDecimal	r63_pro_bou_amount;
	private BigDecimal	r63_pro_sold_amount;
	private BigDecimal	r63_resident;
	private BigDecimal	r63_non_resident;
	private BigDecimal	r63_with1year_amount;
	private BigDecimal	r63_1to3year_amount;
	private BigDecimal	r63_over3year_amount;
	private BigDecimal	r63_pro_bou_ngl;
	private BigDecimal	r63_pro_sold_ngl;
	private String	r64_product;
	private BigDecimal	r64_pro_bou_amount;
	private BigDecimal	r64_pro_sold_amount;
	private BigDecimal	r64_resident;
	private BigDecimal	r64_non_resident;
	private BigDecimal	r64_with1year_amount;
	private BigDecimal	r64_1to3year_amount;
	private BigDecimal	r64_over3year_amount;
	private BigDecimal	r64_pro_bou_ngl;
	private BigDecimal	r64_pro_sold_ngl;
	private String	r65_product;
	private BigDecimal	r65_pro_bou_amount;
	private BigDecimal	r65_pro_sold_amount;
	private BigDecimal	r65_resident;
	private BigDecimal	r65_non_resident;
	private BigDecimal	r65_with1year_amount;
	private BigDecimal	r65_1to3year_amount;
	private BigDecimal	r65_over3year_amount;
	private BigDecimal	r65_pro_bou_ngl;
	private BigDecimal	r65_pro_sold_ngl;
	private String	r66_product;
	private BigDecimal	r66_pro_bou_amount;
	private BigDecimal	r66_pro_sold_amount;
	private BigDecimal	r66_resident;
	private BigDecimal	r66_non_resident;
	private BigDecimal	r66_with1year_amount;
	private BigDecimal	r66_1to3year_amount;
	private BigDecimal	r66_over3year_amount;
	private BigDecimal	r66_pro_bou_ngl;
	private BigDecimal	r66_pro_sold_ngl;
	private String	r67_product;
	private BigDecimal	r67_pro_bou_amount;
	private BigDecimal	r67_pro_sold_amount;
	private BigDecimal	r67_resident;
	private BigDecimal	r67_non_resident;
	private BigDecimal	r67_with1year_amount;
	private BigDecimal	r67_1to3year_amount;
	private BigDecimal	r67_over3year_amount;
	private BigDecimal	r67_pro_bou_ngl;
	private BigDecimal	r67_pro_sold_ngl;
	private String	r68_product;
	private BigDecimal	r68_pro_bou_amount;
	private BigDecimal	r68_pro_sold_amount;
	private BigDecimal	r68_resident;
	private BigDecimal	r68_non_resident;
	private BigDecimal	r68_with1year_amount;
	private BigDecimal	r68_1to3year_amount;
	private BigDecimal	r68_over3year_amount;
	private BigDecimal	r68_pro_bou_ngl;
	private BigDecimal	r68_pro_sold_ngl;
	private String	r69_product;
	private BigDecimal	r69_pro_bou_amount;
	private BigDecimal	r69_pro_sold_amount;
	private BigDecimal	r69_resident;
	private BigDecimal	r69_non_resident;
	private BigDecimal	r69_with1year_amount;
	private BigDecimal	r69_1to3year_amount;
	private BigDecimal	r69_over3year_amount;
	private BigDecimal	r69_pro_bou_ngl;
	private BigDecimal	r69_pro_sold_ngl;
	private String	r70_product;
	private BigDecimal	r70_pro_bou_amount;
	private BigDecimal	r70_pro_sold_amount;
	private BigDecimal	r70_resident;
	private BigDecimal	r70_non_resident;
	private BigDecimal	r70_with1year_amount;
	private BigDecimal	r70_1to3year_amount;
	private BigDecimal	r70_over3year_amount;
	private BigDecimal	r70_pro_bou_ngl;
	private BigDecimal	r70_pro_sold_ngl;
	private String	r71_product;
	private BigDecimal	r71_pro_bou_amount;
	private BigDecimal	r71_pro_sold_amount;
	private BigDecimal	r71_resident;
	private BigDecimal	r71_non_resident;
	private BigDecimal	r71_with1year_amount;
	private BigDecimal	r71_1to3year_amount;
	private BigDecimal	r71_over3year_amount;
	private BigDecimal	r71_pro_bou_ngl;
	private BigDecimal	r71_pro_sold_ngl;
	private String	r72_product;
	private BigDecimal	r72_pro_bou_amount;
	private BigDecimal	r72_pro_sold_amount;
	private BigDecimal	r72_resident;
	private BigDecimal	r72_non_resident;
	private BigDecimal	r72_with1year_amount;
	private BigDecimal	r72_1to3year_amount;
	private BigDecimal	r72_over3year_amount;
	private BigDecimal	r72_pro_bou_ngl;
	private BigDecimal	r72_pro_sold_ngl;
	private String	r73_product;
	private BigDecimal	r73_pro_bou_amount;
	private BigDecimal	r73_pro_sold_amount;
	private BigDecimal	r73_resident;
	private BigDecimal	r73_non_resident;
	private BigDecimal	r73_with1year_amount;
	private BigDecimal	r73_1to3year_amount;
	private BigDecimal	r73_over3year_amount;
	private BigDecimal	r73_pro_bou_ngl;
	private BigDecimal	r73_pro_sold_ngl;
	private String	r74_product;
	private BigDecimal	r74_hedging_amount;
	private BigDecimal	r74_trading_amount;
	private BigDecimal	r74_resident_amount;
	private BigDecimal	r74_non_resident_amount;
	private BigDecimal	r74_with1year_amount;
	private BigDecimal	r74_1to3year_amount;
	private BigDecimal	r74_over3year_amount;
	private BigDecimal	r74_10_headging_nl;
	private BigDecimal	r74_10_n_headging_nl_;
	private BigDecimal	r74_10_trading_nl;
	private BigDecimal	r74_10_n_trading_nl_;
	private String	r75_product;
	private BigDecimal	r75_hedging_amount;
	private BigDecimal	r75_trading_amount;
	private BigDecimal	r75_resident_amount;
	private BigDecimal	r75_non_resident_amount;
	private BigDecimal	r75_with1year_amount;
	private BigDecimal	r75_1to3year_amount;
	private BigDecimal	r75_over3year_amount;
	private BigDecimal	r75_10_headging_nl;
	private BigDecimal	r75_10_n_headging_nl_;
	private BigDecimal	r75_10_trading_nl;
	private BigDecimal	r75_10_n_trading_nl_;
	private String	r76_product;
	private BigDecimal	r76_hedging_amount;
	private BigDecimal	r76_trading_amount;
	private BigDecimal	r76_resident_amount;
	private BigDecimal	r76_non_resident_amount;
	private BigDecimal	r76_with1year_amount;
	private BigDecimal	r76_1to3year_amount;
	private BigDecimal	r76_over3year_amount;
	private BigDecimal	r76_10_headging_nl;
	private BigDecimal	r76_10_n_headging_nl_;
	private BigDecimal	r76_10_trading_nl;
	private BigDecimal	r76_10_n_trading_nl_;
	private String	r77_product;
	private BigDecimal	r77_hedging_amount;
	private BigDecimal	r77_trading_amount;
	private BigDecimal	r77_resident_amount;
	private BigDecimal	r77_non_resident_amount;
	private BigDecimal	r77_with1year_amount;
	private BigDecimal	r77_1to3year_amount;
	private BigDecimal	r77_over3year_amount;
	private BigDecimal	r77_10_headging_nl;
	private BigDecimal	r77_10_n_headging_nl_;
	private BigDecimal	r77_10_trading_nl;
	private BigDecimal	r77_10_n_trading_nl_;
	private String	r78_product;
	private BigDecimal	r78_hedging_amount;
	private BigDecimal	r78_trading_amount;
	private BigDecimal	r78_resident_amount;
	private BigDecimal	r78_non_resident_amount;
	private BigDecimal	r78_with1year_amount;
	private BigDecimal	r78_1to3year_amount;
	private BigDecimal	r78_over3year_amount;
	private BigDecimal	r78_10_headging_nl;
	private BigDecimal	r78_10_n_headging_nl_;
	private BigDecimal	r78_10_trading_nl;
	private BigDecimal	r78_10_n_trading_nl_;
	private String	r79_product;
	private BigDecimal	r79_hedging_amount;
	private BigDecimal	r79_trading_amount;
	private BigDecimal	r79_resident_amount;
	private BigDecimal	r79_non_resident_amount;
	private BigDecimal	r79_with1year_amount;
	private BigDecimal	r79_1to3year_amount;
	private BigDecimal	r79_over3year_amount;
	private BigDecimal	r79_10_headging_nl;
	private BigDecimal	r79_10_n_headging_nl_;
	private BigDecimal	r79_10_trading_nl;
	private BigDecimal	r79_10_n_trading_nl_;
	private String	r80_product;
	private BigDecimal	r80_hedging_amount;
	private BigDecimal	r80_trading_amount;
	private BigDecimal	r80_resident_amount;
	private BigDecimal	r80_non_resident_amount;
	private BigDecimal	r80_with1year_amount;
	private BigDecimal	r80_1to3year_amount;
	private BigDecimal	r80_over3year_amount;
	private BigDecimal	r80_10_headging_nl;
	private BigDecimal	r80_10_n_headging_nl_;
	private BigDecimal	r80_10_trading_nl;
	private BigDecimal	r80_10_n_trading_nl_;
	private String	r81_product;
	private BigDecimal	r81_hedging_amount;
	private BigDecimal	r81_trading_amount;
	private BigDecimal	r81_resident_amount;
	private BigDecimal	r81_non_resident_amount;
	private BigDecimal	r81_with1year_amount;
	private BigDecimal	r81_1to3year_amount;
	private BigDecimal	r81_over3year_amount;
	private BigDecimal	r81_10_headging_nl;
	private BigDecimal	r81_10_n_headging_nl_;
	private BigDecimal	r81_10_trading_nl;
	private BigDecimal	r81_10_n_trading_nl_;
	private String	r82_product;
	private BigDecimal	r82_hedging_amount;
	private BigDecimal	r82_trading_amount;
	private BigDecimal	r82_resident_amount;
	private BigDecimal	r82_non_resident_amount;
	private BigDecimal	r82_with1year_amount;
	private BigDecimal	r82_1to3year_amount;
	private BigDecimal	r82_over3year_amount;
	private BigDecimal	r82_10_headging_nl;
	private BigDecimal	r82_10_n_headging_nl_;
	private BigDecimal	r82_10_trading_nl;
	private BigDecimal	r82_10_n_trading_nl_;
	private String	r83_product1;
	private BigDecimal	r83_resident_for_exc;
	private BigDecimal	r83_non_resident_for_exc;
	private String	r83_product2;
	private BigDecimal	r83_resident_curr_opt;
	private BigDecimal	r83_non_resident_curr_opt;
	private String	r84_product1;
	private BigDecimal	r84_resident_for_exc;
	private BigDecimal	r84_non_resident_for_exc;
	private String	r84_product2;
	private BigDecimal	r84_resident_curr_opt;
	private BigDecimal	r84_non_resident_curr_opt;
	private String	r85_product1;
	private BigDecimal	r85_resident_for_exc;
	private BigDecimal	r85_non_resident_for_exc;
	private String	r85_product2;
	private BigDecimal	r85_resident_curr_opt;
	private BigDecimal	r85_non_resident_curr_opt;
	private String	r86_product1;
	private BigDecimal	r86_resident_for_exc;
	private BigDecimal	r86_non_resident_for_exc;
	private String	r86_product2;
	private BigDecimal	r86_resident_curr_opt;
	private BigDecimal	r86_non_resident_curr_opt;
	private String	r87_product1;
	private BigDecimal	r87_resident_for_exc;
	private BigDecimal	r87_non_resident_for_exc;
	private String	r87_product2;
	private BigDecimal	r87_resident_curr_opt;
	private BigDecimal	r87_non_resident_curr_opt;
	private String	r88_product1;
	private BigDecimal	r88_resident_for_exc;
	private BigDecimal	r88_non_resident_for_exc;
	private String	r88_product2;
	private BigDecimal	r88_resident_curr_opt;
	private BigDecimal	r88_non_resident_curr_opt;
	private String	r89_product1;
	private BigDecimal	r89_resident_for_exc;
	private BigDecimal	r89_non_resident_for_exc;
	private String	r89_product2;
	private BigDecimal	r89_resident_curr_opt;
	private BigDecimal	r89_non_resident_curr_opt;
	private String	r90_product1;
	private BigDecimal	r90_resident_for_exc;
	private BigDecimal	r90_non_resident_for_exc;
	private String	r90_product2;
	private BigDecimal	r90_resident_curr_opt;
	private BigDecimal	r90_non_resident_curr_opt;
	private String	r91_product1;
	private BigDecimal	r91_resident_for_exc;
	private BigDecimal	r91_non_resident_for_exc;
	private String	r91_product2;
	private BigDecimal	r91_resident_curr_opt;
	private BigDecimal	r91_non_resident_curr_opt;
	private String	r92_product1;
	private BigDecimal	r92_resident_for_exc;
	private BigDecimal	r92_non_resident_for_exc;
	private String	r92_product2;
	private BigDecimal	r92_resident_curr_opt;
	private BigDecimal	r92_non_resident_curr_opt;
	private String	r93_product1;
	private BigDecimal	r93_resident_for_exc;
	private BigDecimal	r93_non_resident_for_exc;
	private String	r93_product2;
	private BigDecimal	r93_resident_curr_opt;
	private BigDecimal	r93_non_resident_curr_opt;
	private String	r94_product1;
	private BigDecimal	r94_resident_for_exc;
	private BigDecimal	r94_non_resident_for_exc;
	private String	r94_product2;
	private BigDecimal	r94_resident_curr_opt;
	private BigDecimal	r94_non_resident_curr_opt;
	private String	r95_product1;
	private BigDecimal	r95_resident_for_exc;
	private BigDecimal	r95_non_resident_for_exc;
	private String	r95_product2;
	private BigDecimal	r95_resident_curr_opt;
	private BigDecimal	r95_non_resident_curr_opt;
	private String	r96_product1;
	private BigDecimal	r96_resident_for_exc;
	private BigDecimal	r96_non_resident_for_exc;
	private String	r96_product2;
	private BigDecimal	r96_resident_curr_opt;
	private BigDecimal	r96_non_resident_curr_opt;
	private String	r97_product1;
	private BigDecimal	r97_resident_for_exc;
	private BigDecimal	r97_non_resident_for_exc;
	private String	r97_product2;
	private BigDecimal	r97_resident_curr_opt;
	private BigDecimal	r97_non_resident_curr_opt;
	private String	r98_product1;
	private BigDecimal	r98_resident_interest_exp;
	private BigDecimal	r98_non_resident_interest_exp;
	private String	r98_product2;
	private BigDecimal	r98_resident_credit_exp;
	private BigDecimal	r98_non_resident_credit_exp;
	private String	r99_product1;
	private BigDecimal	r99_resident_interest_exp;
	private BigDecimal	r99_non_resident_interest_exp;
	private String	r99_product2;
	private BigDecimal	r99_resident_credit_exp;
	private BigDecimal	r99_non_resident_credit_exp;
	private String	r100_product1;
	private BigDecimal	r100_resident_interest_exp;
	private BigDecimal	r100_non_resident_interest_exp;
	private String	r100_product2;
	private BigDecimal	r100_resident_credit_exp;
	private BigDecimal	r100_non_resident_credit_exp;
	private String	r101_product1;
	private BigDecimal	r101_resident_interest_exp;
	private BigDecimal	r101_non_resident_interest_exp;
	private String	r101_product2;
	private BigDecimal	r101_resident_credit_exp;
	private BigDecimal	r101_non_resident_credit_exp;
	private String	r102_product1;
	private BigDecimal	r102_resident_interest_exp;
	private BigDecimal	r102_non_resident_interest_exp;
	private String	r102_product2;
	private BigDecimal	r102_resident_credit_exp;
	private BigDecimal	r102_non_resident_credit_exp;
	private String	r103_product1;
	private BigDecimal	r103_resident_interest_exp;
	private BigDecimal	r103_non_resident_interest_exp;
	private String	r103_product2;
	private BigDecimal	r103_resident_credit_exp;
	private BigDecimal	r103_non_resident_credit_exp;
	private String	r104_product1;
	private BigDecimal	r104_resident_interest_exp;
	private BigDecimal	r104_non_resident_interest_exp;
	private String	r104_product2;
	private BigDecimal	r104_resident_credit_exp;
	private BigDecimal	r104_non_resident_credit_exp;
	private String	r105_product1;
	private BigDecimal	r105_resident_interest_exp;
	private BigDecimal	r105_non_resident_interest_exp;
	private String	r105_product2;
	private BigDecimal	r105_resident_credit_exp;
	private BigDecimal	r105_non_resident_credit_exp;
	private String	r106_product1;
	private BigDecimal	r106_resident_interest_exp;
	private BigDecimal	r106_non_resident_interest_exp;
	private String	r106_product2;
	private BigDecimal	r106_resident_credit_exp;
	private BigDecimal	r106_non_resident_credit_exp;
	private String	r107_product1;
	private BigDecimal	r107_resident_interest_exp;
	private BigDecimal	r107_non_resident_interest_exp;
	private String	r107_product2;
	private BigDecimal	r107_resident_credit_exp;
	private BigDecimal	r107_non_resident_credit_exp;
	private String	r108_product1;
	private BigDecimal	r108_resident_interest_exp;
	private BigDecimal	r108_non_resident_interest_exp;
	private String	r108_product2;
	private BigDecimal	r108_resident_credit_exp;
	private BigDecimal	r108_non_resident_credit_exp;
	private String	r109_product1;
	private BigDecimal	r109_resident_interest_exp;
	private BigDecimal	r109_non_resident_interest_exp;
	private String	r109_product2;
	private BigDecimal	r109_resident_credit_exp;
	private BigDecimal	r109_non_resident_credit_exp;
	private String	r110_product1;
	private BigDecimal	r110_resident_interest_exp;
	private BigDecimal	r110_non_resident_interest_exp;
	private String	r110_product2;
	private BigDecimal	r110_resident_credit_exp;
	private BigDecimal	r110_non_resident_credit_exp;
	private String	r111_product1;
	private BigDecimal	r111_resident_interest_exp;
	private BigDecimal	r111_non_resident_interest_exp;
	private String	r111_product2;
	private BigDecimal	r111_resident_credit_exp;
	private BigDecimal	r111_non_resident_credit_exp;
	private String	r112_product1;
	private BigDecimal	r112_resident_interest_exp;
	private BigDecimal	r112_non_resident_interest_exp;
	private String	r112_product2;
	private BigDecimal	r112_resident_credit_exp;
	private BigDecimal	r112_non_resident_credit_exp;
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
	public String getR1_product() {
		return r1_product;
	}
	public void setR1_product(String r1_product) {
		this.r1_product = r1_product;
	}
	public BigDecimal getR1_resident_outstand() {
		return r1_resident_outstand;
	}
	public void setR1_resident_outstand(BigDecimal r1_resident_outstand) {
		this.r1_resident_outstand = r1_resident_outstand;
	}
	public BigDecimal getR1_non_resident_outstand() {
		return r1_non_resident_outstand;
	}
	public void setR1_non_resident_outstand(BigDecimal r1_non_resident_outstand) {
		this.r1_non_resident_outstand = r1_non_resident_outstand;
	}
	public String getR2_product() {
		return r2_product;
	}
	public void setR2_product(String r2_product) {
		this.r2_product = r2_product;
	}
	public BigDecimal getR2_resident_outstand() {
		return r2_resident_outstand;
	}
	public void setR2_resident_outstand(BigDecimal r2_resident_outstand) {
		this.r2_resident_outstand = r2_resident_outstand;
	}
	public BigDecimal getR2_non_resident_outstand() {
		return r2_non_resident_outstand;
	}
	public void setR2_non_resident_outstand(BigDecimal r2_non_resident_outstand) {
		this.r2_non_resident_outstand = r2_non_resident_outstand;
	}
	public String getR3_product() {
		return r3_product;
	}
	public void setR3_product(String r3_product) {
		this.r3_product = r3_product;
	}
	public BigDecimal getR3_resident_outstand() {
		return r3_resident_outstand;
	}
	public void setR3_resident_outstand(BigDecimal r3_resident_outstand) {
		this.r3_resident_outstand = r3_resident_outstand;
	}
	public BigDecimal getR3_non_resident_outstand() {
		return r3_non_resident_outstand;
	}
	public void setR3_non_resident_outstand(BigDecimal r3_non_resident_outstand) {
		this.r3_non_resident_outstand = r3_non_resident_outstand;
	}
	public String getR4_product() {
		return r4_product;
	}
	public void setR4_product(String r4_product) {
		this.r4_product = r4_product;
	}
	public BigDecimal getR4_resident_outstand() {
		return r4_resident_outstand;
	}
	public void setR4_resident_outstand(BigDecimal r4_resident_outstand) {
		this.r4_resident_outstand = r4_resident_outstand;
	}
	public BigDecimal getR4_non_resident_outstand() {
		return r4_non_resident_outstand;
	}
	public void setR4_non_resident_outstand(BigDecimal r4_non_resident_outstand) {
		this.r4_non_resident_outstand = r4_non_resident_outstand;
	}
	public String getR5_product() {
		return r5_product;
	}
	public void setR5_product(String r5_product) {
		this.r5_product = r5_product;
	}
	public BigDecimal getR5_resident_outstand() {
		return r5_resident_outstand;
	}
	public void setR5_resident_outstand(BigDecimal r5_resident_outstand) {
		this.r5_resident_outstand = r5_resident_outstand;
	}
	public BigDecimal getR5_non_resident_outstand() {
		return r5_non_resident_outstand;
	}
	public void setR5_non_resident_outstand(BigDecimal r5_non_resident_outstand) {
		this.r5_non_resident_outstand = r5_non_resident_outstand;
	}
	public String getR6_product() {
		return r6_product;
	}
	public void setR6_product(String r6_product) {
		this.r6_product = r6_product;
	}
	public BigDecimal getR6_resident_outstand() {
		return r6_resident_outstand;
	}
	public void setR6_resident_outstand(BigDecimal r6_resident_outstand) {
		this.r6_resident_outstand = r6_resident_outstand;
	}
	public BigDecimal getR6_non_resident_outstand() {
		return r6_non_resident_outstand;
	}
	public void setR6_non_resident_outstand(BigDecimal r6_non_resident_outstand) {
		this.r6_non_resident_outstand = r6_non_resident_outstand;
	}
	public String getR7_product() {
		return r7_product;
	}
	public void setR7_product(String r7_product) {
		this.r7_product = r7_product;
	}
	public BigDecimal getR7_resident_outstand() {
		return r7_resident_outstand;
	}
	public void setR7_resident_outstand(BigDecimal r7_resident_outstand) {
		this.r7_resident_outstand = r7_resident_outstand;
	}
	public BigDecimal getR7_non_resident_outstand() {
		return r7_non_resident_outstand;
	}
	public void setR7_non_resident_outstand(BigDecimal r7_non_resident_outstand) {
		this.r7_non_resident_outstand = r7_non_resident_outstand;
	}
	public String getR8_product() {
		return r8_product;
	}
	public void setR8_product(String r8_product) {
		this.r8_product = r8_product;
	}
	public BigDecimal getR8_resident_outstand() {
		return r8_resident_outstand;
	}
	public void setR8_resident_outstand(BigDecimal r8_resident_outstand) {
		this.r8_resident_outstand = r8_resident_outstand;
	}
	public BigDecimal getR8_non_resident_outstand() {
		return r8_non_resident_outstand;
	}
	public void setR8_non_resident_outstand(BigDecimal r8_non_resident_outstand) {
		this.r8_non_resident_outstand = r8_non_resident_outstand;
	}
	public String getR9_product() {
		return r9_product;
	}
	public void setR9_product(String r9_product) {
		this.r9_product = r9_product;
	}
	public BigDecimal getR9_resident_outstand() {
		return r9_resident_outstand;
	}
	public void setR9_resident_outstand(BigDecimal r9_resident_outstand) {
		this.r9_resident_outstand = r9_resident_outstand;
	}
	public BigDecimal getR9_non_resident_outstand() {
		return r9_non_resident_outstand;
	}
	public void setR9_non_resident_outstand(BigDecimal r9_non_resident_outstand) {
		this.r9_non_resident_outstand = r9_non_resident_outstand;
	}
	public String getR10_product() {
		return r10_product;
	}
	public void setR10_product(String r10_product) {
		this.r10_product = r10_product;
	}
	public BigDecimal getR10_resident_outstand() {
		return r10_resident_outstand;
	}
	public void setR10_resident_outstand(BigDecimal r10_resident_outstand) {
		this.r10_resident_outstand = r10_resident_outstand;
	}
	public BigDecimal getR10_non_resident_outstand() {
		return r10_non_resident_outstand;
	}
	public void setR10_non_resident_outstand(BigDecimal r10_non_resident_outstand) {
		this.r10_non_resident_outstand = r10_non_resident_outstand;
	}
	public String getR11_product() {
		return r11_product;
	}
	public void setR11_product(String r11_product) {
		this.r11_product = r11_product;
	}
	public BigDecimal getR11_resident_outstand() {
		return r11_resident_outstand;
	}
	public void setR11_resident_outstand(BigDecimal r11_resident_outstand) {
		this.r11_resident_outstand = r11_resident_outstand;
	}
	public BigDecimal getR11_non_resident_outstand() {
		return r11_non_resident_outstand;
	}
	public void setR11_non_resident_outstand(BigDecimal r11_non_resident_outstand) {
		this.r11_non_resident_outstand = r11_non_resident_outstand;
	}
	public String getR12_product() {
		return r12_product;
	}
	public void setR12_product(String r12_product) {
		this.r12_product = r12_product;
	}
	public BigDecimal getR12_resident_outstand() {
		return r12_resident_outstand;
	}
	public void setR12_resident_outstand(BigDecimal r12_resident_outstand) {
		this.r12_resident_outstand = r12_resident_outstand;
	}
	public BigDecimal getR12_non_resident_outstand() {
		return r12_non_resident_outstand;
	}
	public void setR12_non_resident_outstand(BigDecimal r12_non_resident_outstand) {
		this.r12_non_resident_outstand = r12_non_resident_outstand;
	}
	public String getR13_product() {
		return r13_product;
	}
	public void setR13_product(String r13_product) {
		this.r13_product = r13_product;
	}
	public BigDecimal getR13_resident_outstand() {
		return r13_resident_outstand;
	}
	public void setR13_resident_outstand(BigDecimal r13_resident_outstand) {
		this.r13_resident_outstand = r13_resident_outstand;
	}
	public BigDecimal getR13_non_resident_outstand() {
		return r13_non_resident_outstand;
	}
	public void setR13_non_resident_outstand(BigDecimal r13_non_resident_outstand) {
		this.r13_non_resident_outstand = r13_non_resident_outstand;
	}
	public String getR14_product() {
		return r14_product;
	}
	public void setR14_product(String r14_product) {
		this.r14_product = r14_product;
	}
	public BigDecimal getR14_resident_outstand() {
		return r14_resident_outstand;
	}
	public void setR14_resident_outstand(BigDecimal r14_resident_outstand) {
		this.r14_resident_outstand = r14_resident_outstand;
	}
	public BigDecimal getR14_non_resident_outstand() {
		return r14_non_resident_outstand;
	}
	public void setR14_non_resident_outstand(BigDecimal r14_non_resident_outstand) {
		this.r14_non_resident_outstand = r14_non_resident_outstand;
	}
	public String getR15_product() {
		return r15_product;
	}
	public void setR15_product(String r15_product) {
		this.r15_product = r15_product;
	}
	public BigDecimal getR15_resident_outstand() {
		return r15_resident_outstand;
	}
	public void setR15_resident_outstand(BigDecimal r15_resident_outstand) {
		this.r15_resident_outstand = r15_resident_outstand;
	}
	public BigDecimal getR15_non_resident_outstand() {
		return r15_non_resident_outstand;
	}
	public void setR15_non_resident_outstand(BigDecimal r15_non_resident_outstand) {
		this.r15_non_resident_outstand = r15_non_resident_outstand;
	}
	public String getR16_product() {
		return r16_product;
	}
	public void setR16_product(String r16_product) {
		this.r16_product = r16_product;
	}
	public BigDecimal getR16_resident_outstand() {
		return r16_resident_outstand;
	}
	public void setR16_resident_outstand(BigDecimal r16_resident_outstand) {
		this.r16_resident_outstand = r16_resident_outstand;
	}
	public BigDecimal getR16_non_resident_outstand() {
		return r16_non_resident_outstand;
	}
	public void setR16_non_resident_outstand(BigDecimal r16_non_resident_outstand) {
		this.r16_non_resident_outstand = r16_non_resident_outstand;
	}
	public String getR17_product() {
		return r17_product;
	}
	public void setR17_product(String r17_product) {
		this.r17_product = r17_product;
	}
	public BigDecimal getR17_resident_outstand() {
		return r17_resident_outstand;
	}
	public void setR17_resident_outstand(BigDecimal r17_resident_outstand) {
		this.r17_resident_outstand = r17_resident_outstand;
	}
	public BigDecimal getR17_non_resident_outstand() {
		return r17_non_resident_outstand;
	}
	public void setR17_non_resident_outstand(BigDecimal r17_non_resident_outstand) {
		this.r17_non_resident_outstand = r17_non_resident_outstand;
	}
	public String getR18_product() {
		return r18_product;
	}
	public void setR18_product(String r18_product) {
		this.r18_product = r18_product;
	}
	public BigDecimal getR18_resident_outstand() {
		return r18_resident_outstand;
	}
	public void setR18_resident_outstand(BigDecimal r18_resident_outstand) {
		this.r18_resident_outstand = r18_resident_outstand;
	}
	public BigDecimal getR18_non_resident_outstand() {
		return r18_non_resident_outstand;
	}
	public void setR18_non_resident_outstand(BigDecimal r18_non_resident_outstand) {
		this.r18_non_resident_outstand = r18_non_resident_outstand;
	}
	public String getR19_product() {
		return r19_product;
	}
	public void setR19_product(String r19_product) {
		this.r19_product = r19_product;
	}
	public BigDecimal getR19_hedging_amount() {
		return r19_hedging_amount;
	}
	public void setR19_hedging_amount(BigDecimal r19_hedging_amount) {
		this.r19_hedging_amount = r19_hedging_amount;
	}
	public BigDecimal getR19_trading_amount() {
		return r19_trading_amount;
	}
	public void setR19_trading_amount(BigDecimal r19_trading_amount) {
		this.r19_trading_amount = r19_trading_amount;
	}
	public BigDecimal getR19_resident_amount() {
		return r19_resident_amount;
	}
	public void setR19_resident_amount(BigDecimal r19_resident_amount) {
		this.r19_resident_amount = r19_resident_amount;
	}
	public BigDecimal getR19_non_resident_amount() {
		return r19_non_resident_amount;
	}
	public void setR19_non_resident_amount(BigDecimal r19_non_resident_amount) {
		this.r19_non_resident_amount = r19_non_resident_amount;
	}
	public BigDecimal getR19_with1year_amount() {
		return r19_with1year_amount;
	}
	public void setR19_with1year_amount(BigDecimal r19_with1year_amount) {
		this.r19_with1year_amount = r19_with1year_amount;
	}
	public BigDecimal getR19_1to3year_amount() {
		return r19_1to3year_amount;
	}
	public void setR19_1to3year_amount(BigDecimal r19_1to3year_amount) {
		this.r19_1to3year_amount = r19_1to3year_amount;
	}
	public BigDecimal getR19_over3year_amount() {
		return r19_over3year_amount;
	}
	public void setR19_over3year_amount(BigDecimal r19_over3year_amount) {
		this.r19_over3year_amount = r19_over3year_amount;
	}
	public String getR20_product() {
		return r20_product;
	}
	public void setR20_product(String r20_product) {
		this.r20_product = r20_product;
	}
	public BigDecimal getR20_hedging_amount() {
		return r20_hedging_amount;
	}
	public void setR20_hedging_amount(BigDecimal r20_hedging_amount) {
		this.r20_hedging_amount = r20_hedging_amount;
	}
	public BigDecimal getR20_trading_amount() {
		return r20_trading_amount;
	}
	public void setR20_trading_amount(BigDecimal r20_trading_amount) {
		this.r20_trading_amount = r20_trading_amount;
	}
	public BigDecimal getR20_resident_amount() {
		return r20_resident_amount;
	}
	public void setR20_resident_amount(BigDecimal r20_resident_amount) {
		this.r20_resident_amount = r20_resident_amount;
	}
	public BigDecimal getR20_non_resident_amount() {
		return r20_non_resident_amount;
	}
	public void setR20_non_resident_amount(BigDecimal r20_non_resident_amount) {
		this.r20_non_resident_amount = r20_non_resident_amount;
	}
	public BigDecimal getR20_with1year_amount() {
		return r20_with1year_amount;
	}
	public void setR20_with1year_amount(BigDecimal r20_with1year_amount) {
		this.r20_with1year_amount = r20_with1year_amount;
	}
	public BigDecimal getR20_1to3year_amount() {
		return r20_1to3year_amount;
	}
	public void setR20_1to3year_amount(BigDecimal r20_1to3year_amount) {
		this.r20_1to3year_amount = r20_1to3year_amount;
	}
	public BigDecimal getR20_over3year_amount() {
		return r20_over3year_amount;
	}
	public void setR20_over3year_amount(BigDecimal r20_over3year_amount) {
		this.r20_over3year_amount = r20_over3year_amount;
	}
	public String getR21_product() {
		return r21_product;
	}
	public void setR21_product(String r21_product) {
		this.r21_product = r21_product;
	}
	public BigDecimal getR21_hedging_amount() {
		return r21_hedging_amount;
	}
	public void setR21_hedging_amount(BigDecimal r21_hedging_amount) {
		this.r21_hedging_amount = r21_hedging_amount;
	}
	public BigDecimal getR21_trading_amount() {
		return r21_trading_amount;
	}
	public void setR21_trading_amount(BigDecimal r21_trading_amount) {
		this.r21_trading_amount = r21_trading_amount;
	}
	public BigDecimal getR21_resident_amount() {
		return r21_resident_amount;
	}
	public void setR21_resident_amount(BigDecimal r21_resident_amount) {
		this.r21_resident_amount = r21_resident_amount;
	}
	public BigDecimal getR21_non_resident_amount() {
		return r21_non_resident_amount;
	}
	public void setR21_non_resident_amount(BigDecimal r21_non_resident_amount) {
		this.r21_non_resident_amount = r21_non_resident_amount;
	}
	public BigDecimal getR21_with1year_amount() {
		return r21_with1year_amount;
	}
	public void setR21_with1year_amount(BigDecimal r21_with1year_amount) {
		this.r21_with1year_amount = r21_with1year_amount;
	}
	public BigDecimal getR21_1to3year_amount() {
		return r21_1to3year_amount;
	}
	public void setR21_1to3year_amount(BigDecimal r21_1to3year_amount) {
		this.r21_1to3year_amount = r21_1to3year_amount;
	}
	public BigDecimal getR21_over3year_amount() {
		return r21_over3year_amount;
	}
	public void setR21_over3year_amount(BigDecimal r21_over3year_amount) {
		this.r21_over3year_amount = r21_over3year_amount;
	}
	public String getR22_product() {
		return r22_product;
	}
	public void setR22_product(String r22_product) {
		this.r22_product = r22_product;
	}
	public BigDecimal getR22_hedging_amount() {
		return r22_hedging_amount;
	}
	public void setR22_hedging_amount(BigDecimal r22_hedging_amount) {
		this.r22_hedging_amount = r22_hedging_amount;
	}
	public BigDecimal getR22_trading_amount() {
		return r22_trading_amount;
	}
	public void setR22_trading_amount(BigDecimal r22_trading_amount) {
		this.r22_trading_amount = r22_trading_amount;
	}
	public BigDecimal getR22_resident_amount() {
		return r22_resident_amount;
	}
	public void setR22_resident_amount(BigDecimal r22_resident_amount) {
		this.r22_resident_amount = r22_resident_amount;
	}
	public BigDecimal getR22_non_resident_amount() {
		return r22_non_resident_amount;
	}
	public void setR22_non_resident_amount(BigDecimal r22_non_resident_amount) {
		this.r22_non_resident_amount = r22_non_resident_amount;
	}
	public BigDecimal getR22_with1year_amount() {
		return r22_with1year_amount;
	}
	public void setR22_with1year_amount(BigDecimal r22_with1year_amount) {
		this.r22_with1year_amount = r22_with1year_amount;
	}
	public BigDecimal getR22_1to3year_amount() {
		return r22_1to3year_amount;
	}
	public void setR22_1to3year_amount(BigDecimal r22_1to3year_amount) {
		this.r22_1to3year_amount = r22_1to3year_amount;
	}
	public BigDecimal getR22_over3year_amount() {
		return r22_over3year_amount;
	}
	public void setR22_over3year_amount(BigDecimal r22_over3year_amount) {
		this.r22_over3year_amount = r22_over3year_amount;
	}
	public String getR23_product() {
		return r23_product;
	}
	public void setR23_product(String r23_product) {
		this.r23_product = r23_product;
	}
	public BigDecimal getR23_hedging_amount() {
		return r23_hedging_amount;
	}
	public void setR23_hedging_amount(BigDecimal r23_hedging_amount) {
		this.r23_hedging_amount = r23_hedging_amount;
	}
	public BigDecimal getR23_trading_amount() {
		return r23_trading_amount;
	}
	public void setR23_trading_amount(BigDecimal r23_trading_amount) {
		this.r23_trading_amount = r23_trading_amount;
	}
	public BigDecimal getR23_resident_amount() {
		return r23_resident_amount;
	}
	public void setR23_resident_amount(BigDecimal r23_resident_amount) {
		this.r23_resident_amount = r23_resident_amount;
	}
	public BigDecimal getR23_non_resident_amount() {
		return r23_non_resident_amount;
	}
	public void setR23_non_resident_amount(BigDecimal r23_non_resident_amount) {
		this.r23_non_resident_amount = r23_non_resident_amount;
	}
	public BigDecimal getR23_with1year_amount() {
		return r23_with1year_amount;
	}
	public void setR23_with1year_amount(BigDecimal r23_with1year_amount) {
		this.r23_with1year_amount = r23_with1year_amount;
	}
	public BigDecimal getR23_1to3year_amount() {
		return r23_1to3year_amount;
	}
	public void setR23_1to3year_amount(BigDecimal r23_1to3year_amount) {
		this.r23_1to3year_amount = r23_1to3year_amount;
	}
	public BigDecimal getR23_over3year_amount() {
		return r23_over3year_amount;
	}
	public void setR23_over3year_amount(BigDecimal r23_over3year_amount) {
		this.r23_over3year_amount = r23_over3year_amount;
	}
	public String getR24_product() {
		return r24_product;
	}
	public void setR24_product(String r24_product) {
		this.r24_product = r24_product;
	}
	public BigDecimal getR24_hedging_amount() {
		return r24_hedging_amount;
	}
	public void setR24_hedging_amount(BigDecimal r24_hedging_amount) {
		this.r24_hedging_amount = r24_hedging_amount;
	}
	public BigDecimal getR24_trading_amount() {
		return r24_trading_amount;
	}
	public void setR24_trading_amount(BigDecimal r24_trading_amount) {
		this.r24_trading_amount = r24_trading_amount;
	}
	public BigDecimal getR24_resident_amount() {
		return r24_resident_amount;
	}
	public void setR24_resident_amount(BigDecimal r24_resident_amount) {
		this.r24_resident_amount = r24_resident_amount;
	}
	public BigDecimal getR24_non_resident_amount() {
		return r24_non_resident_amount;
	}
	public void setR24_non_resident_amount(BigDecimal r24_non_resident_amount) {
		this.r24_non_resident_amount = r24_non_resident_amount;
	}
	public BigDecimal getR24_with1year_amount() {
		return r24_with1year_amount;
	}
	public void setR24_with1year_amount(BigDecimal r24_with1year_amount) {
		this.r24_with1year_amount = r24_with1year_amount;
	}
	public BigDecimal getR24_1to3year_amount() {
		return r24_1to3year_amount;
	}
	public void setR24_1to3year_amount(BigDecimal r24_1to3year_amount) {
		this.r24_1to3year_amount = r24_1to3year_amount;
	}
	public BigDecimal getR24_over3year_amount() {
		return r24_over3year_amount;
	}
	public void setR24_over3year_amount(BigDecimal r24_over3year_amount) {
		this.r24_over3year_amount = r24_over3year_amount;
	}
	public String getR25_product() {
		return r25_product;
	}
	public void setR25_product(String r25_product) {
		this.r25_product = r25_product;
	}
	public BigDecimal getR25_hedging_amount() {
		return r25_hedging_amount;
	}
	public void setR25_hedging_amount(BigDecimal r25_hedging_amount) {
		this.r25_hedging_amount = r25_hedging_amount;
	}
	public BigDecimal getR25_trading_amount() {
		return r25_trading_amount;
	}
	public void setR25_trading_amount(BigDecimal r25_trading_amount) {
		this.r25_trading_amount = r25_trading_amount;
	}
	public BigDecimal getR25_resident_amount() {
		return r25_resident_amount;
	}
	public void setR25_resident_amount(BigDecimal r25_resident_amount) {
		this.r25_resident_amount = r25_resident_amount;
	}
	public BigDecimal getR25_non_resident_amount() {
		return r25_non_resident_amount;
	}
	public void setR25_non_resident_amount(BigDecimal r25_non_resident_amount) {
		this.r25_non_resident_amount = r25_non_resident_amount;
	}
	public BigDecimal getR25_with1year_amount() {
		return r25_with1year_amount;
	}
	public void setR25_with1year_amount(BigDecimal r25_with1year_amount) {
		this.r25_with1year_amount = r25_with1year_amount;
	}
	public BigDecimal getR25_1to3year_amount() {
		return r25_1to3year_amount;
	}
	public void setR25_1to3year_amount(BigDecimal r25_1to3year_amount) {
		this.r25_1to3year_amount = r25_1to3year_amount;
	}
	public BigDecimal getR25_over3year_amount() {
		return r25_over3year_amount;
	}
	public void setR25_over3year_amount(BigDecimal r25_over3year_amount) {
		this.r25_over3year_amount = r25_over3year_amount;
	}
	public String getR26_product() {
		return r26_product;
	}
	public void setR26_product(String r26_product) {
		this.r26_product = r26_product;
	}
	public BigDecimal getR26_hedging_amount() {
		return r26_hedging_amount;
	}
	public void setR26_hedging_amount(BigDecimal r26_hedging_amount) {
		this.r26_hedging_amount = r26_hedging_amount;
	}
	public BigDecimal getR26_trading_amount() {
		return r26_trading_amount;
	}
	public void setR26_trading_amount(BigDecimal r26_trading_amount) {
		this.r26_trading_amount = r26_trading_amount;
	}
	public BigDecimal getR26_resident_amount() {
		return r26_resident_amount;
	}
	public void setR26_resident_amount(BigDecimal r26_resident_amount) {
		this.r26_resident_amount = r26_resident_amount;
	}
	public BigDecimal getR26_non_resident_amount() {
		return r26_non_resident_amount;
	}
	public void setR26_non_resident_amount(BigDecimal r26_non_resident_amount) {
		this.r26_non_resident_amount = r26_non_resident_amount;
	}
	public BigDecimal getR26_with1year_amount() {
		return r26_with1year_amount;
	}
	public void setR26_with1year_amount(BigDecimal r26_with1year_amount) {
		this.r26_with1year_amount = r26_with1year_amount;
	}
	public BigDecimal getR26_1to3year_amount() {
		return r26_1to3year_amount;
	}
	public void setR26_1to3year_amount(BigDecimal r26_1to3year_amount) {
		this.r26_1to3year_amount = r26_1to3year_amount;
	}
	public BigDecimal getR26_over3year_amount() {
		return r26_over3year_amount;
	}
	public void setR26_over3year_amount(BigDecimal r26_over3year_amount) {
		this.r26_over3year_amount = r26_over3year_amount;
	}
	public String getR27_product() {
		return r27_product;
	}
	public void setR27_product(String r27_product) {
		this.r27_product = r27_product;
	}
	public BigDecimal getR27_hedging_amount() {
		return r27_hedging_amount;
	}
	public void setR27_hedging_amount(BigDecimal r27_hedging_amount) {
		this.r27_hedging_amount = r27_hedging_amount;
	}
	public BigDecimal getR27_trading_amount() {
		return r27_trading_amount;
	}
	public void setR27_trading_amount(BigDecimal r27_trading_amount) {
		this.r27_trading_amount = r27_trading_amount;
	}
	public BigDecimal getR27_resident_amount() {
		return r27_resident_amount;
	}
	public void setR27_resident_amount(BigDecimal r27_resident_amount) {
		this.r27_resident_amount = r27_resident_amount;
	}
	public BigDecimal getR27_non_resident_amount() {
		return r27_non_resident_amount;
	}
	public void setR27_non_resident_amount(BigDecimal r27_non_resident_amount) {
		this.r27_non_resident_amount = r27_non_resident_amount;
	}
	public BigDecimal getR27_with1year_amount() {
		return r27_with1year_amount;
	}
	public void setR27_with1year_amount(BigDecimal r27_with1year_amount) {
		this.r27_with1year_amount = r27_with1year_amount;
	}
	public BigDecimal getR27_1to3year_amount() {
		return r27_1to3year_amount;
	}
	public void setR27_1to3year_amount(BigDecimal r27_1to3year_amount) {
		this.r27_1to3year_amount = r27_1to3year_amount;
	}
	public BigDecimal getR27_over3year_amount() {
		return r27_over3year_amount;
	}
	public void setR27_over3year_amount(BigDecimal r27_over3year_amount) {
		this.r27_over3year_amount = r27_over3year_amount;
	}
	public BigDecimal getR27_10_headging_nl() {
		return r27_10_headging_nl;
	}
	public void setR27_10_headging_nl(BigDecimal r27_10_headging_nl) {
		this.r27_10_headging_nl = r27_10_headging_nl;
	}
	public BigDecimal getR27_10_n_headging_nl_() {
		return r27_10_n_headging_nl_;
	}
	public void setR27_10_n_headging_nl_(BigDecimal r27_10_n_headging_nl_) {
		this.r27_10_n_headging_nl_ = r27_10_n_headging_nl_;
	}
	public BigDecimal getR27_10_trading_nl() {
		return r27_10_trading_nl;
	}
	public void setR27_10_trading_nl(BigDecimal r27_10_trading_nl) {
		this.r27_10_trading_nl = r27_10_trading_nl;
	}
	public BigDecimal getR27_10_n_trading_nl_() {
		return r27_10_n_trading_nl_;
	}
	public void setR27_10_n_trading_nl_(BigDecimal r27_10_n_trading_nl_) {
		this.r27_10_n_trading_nl_ = r27_10_n_trading_nl_;
	}
	public String getR28_product() {
		return r28_product;
	}
	public void setR28_product(String r28_product) {
		this.r28_product = r28_product;
	}
	public BigDecimal getR28_hedging_amount() {
		return r28_hedging_amount;
	}
	public void setR28_hedging_amount(BigDecimal r28_hedging_amount) {
		this.r28_hedging_amount = r28_hedging_amount;
	}
	public BigDecimal getR28_trading_amount() {
		return r28_trading_amount;
	}
	public void setR28_trading_amount(BigDecimal r28_trading_amount) {
		this.r28_trading_amount = r28_trading_amount;
	}
	public BigDecimal getR28_resident_amount() {
		return r28_resident_amount;
	}
	public void setR28_resident_amount(BigDecimal r28_resident_amount) {
		this.r28_resident_amount = r28_resident_amount;
	}
	public BigDecimal getR28_non_resident_amount() {
		return r28_non_resident_amount;
	}
	public void setR28_non_resident_amount(BigDecimal r28_non_resident_amount) {
		this.r28_non_resident_amount = r28_non_resident_amount;
	}
	public BigDecimal getR28_with1year_amount() {
		return r28_with1year_amount;
	}
	public void setR28_with1year_amount(BigDecimal r28_with1year_amount) {
		this.r28_with1year_amount = r28_with1year_amount;
	}
	public BigDecimal getR28_1to3year_amount() {
		return r28_1to3year_amount;
	}
	public void setR28_1to3year_amount(BigDecimal r28_1to3year_amount) {
		this.r28_1to3year_amount = r28_1to3year_amount;
	}
	public BigDecimal getR28_over3year_amount() {
		return r28_over3year_amount;
	}
	public void setR28_over3year_amount(BigDecimal r28_over3year_amount) {
		this.r28_over3year_amount = r28_over3year_amount;
	}
	public BigDecimal getR28_10_headging_nl() {
		return r28_10_headging_nl;
	}
	public void setR28_10_headging_nl(BigDecimal r28_10_headging_nl) {
		this.r28_10_headging_nl = r28_10_headging_nl;
	}
	public BigDecimal getR28_10_n_headging_nl_() {
		return r28_10_n_headging_nl_;
	}
	public void setR28_10_n_headging_nl_(BigDecimal r28_10_n_headging_nl_) {
		this.r28_10_n_headging_nl_ = r28_10_n_headging_nl_;
	}
	public BigDecimal getR28_10_trading_nl() {
		return r28_10_trading_nl;
	}
	public void setR28_10_trading_nl(BigDecimal r28_10_trading_nl) {
		this.r28_10_trading_nl = r28_10_trading_nl;
	}
	public BigDecimal getR28_10_n_trading_nl_() {
		return r28_10_n_trading_nl_;
	}
	public void setR28_10_n_trading_nl_(BigDecimal r28_10_n_trading_nl_) {
		this.r28_10_n_trading_nl_ = r28_10_n_trading_nl_;
	}
	public String getR29_product() {
		return r29_product;
	}
	public void setR29_product(String r29_product) {
		this.r29_product = r29_product;
	}
	public BigDecimal getR29_hedging_amount() {
		return r29_hedging_amount;
	}
	public void setR29_hedging_amount(BigDecimal r29_hedging_amount) {
		this.r29_hedging_amount = r29_hedging_amount;
	}
	public BigDecimal getR29_trading_amount() {
		return r29_trading_amount;
	}
	public void setR29_trading_amount(BigDecimal r29_trading_amount) {
		this.r29_trading_amount = r29_trading_amount;
	}
	public BigDecimal getR29_resident_amount() {
		return r29_resident_amount;
	}
	public void setR29_resident_amount(BigDecimal r29_resident_amount) {
		this.r29_resident_amount = r29_resident_amount;
	}
	public BigDecimal getR29_non_resident_amount() {
		return r29_non_resident_amount;
	}
	public void setR29_non_resident_amount(BigDecimal r29_non_resident_amount) {
		this.r29_non_resident_amount = r29_non_resident_amount;
	}
	public BigDecimal getR29_with1year_amount() {
		return r29_with1year_amount;
	}
	public void setR29_with1year_amount(BigDecimal r29_with1year_amount) {
		this.r29_with1year_amount = r29_with1year_amount;
	}
	public BigDecimal getR29_1to3year_amount() {
		return r29_1to3year_amount;
	}
	public void setR29_1to3year_amount(BigDecimal r29_1to3year_amount) {
		this.r29_1to3year_amount = r29_1to3year_amount;
	}
	public BigDecimal getR29_over3year_amount() {
		return r29_over3year_amount;
	}
	public void setR29_over3year_amount(BigDecimal r29_over3year_amount) {
		this.r29_over3year_amount = r29_over3year_amount;
	}
	public BigDecimal getR29_10_headging_nl() {
		return r29_10_headging_nl;
	}
	public void setR29_10_headging_nl(BigDecimal r29_10_headging_nl) {
		this.r29_10_headging_nl = r29_10_headging_nl;
	}
	public BigDecimal getR29_10_n_headging_nl_() {
		return r29_10_n_headging_nl_;
	}
	public void setR29_10_n_headging_nl_(BigDecimal r29_10_n_headging_nl_) {
		this.r29_10_n_headging_nl_ = r29_10_n_headging_nl_;
	}
	public BigDecimal getR29_10_trading_nl() {
		return r29_10_trading_nl;
	}
	public void setR29_10_trading_nl(BigDecimal r29_10_trading_nl) {
		this.r29_10_trading_nl = r29_10_trading_nl;
	}
	public BigDecimal getR29_10_n_trading_nl_() {
		return r29_10_n_trading_nl_;
	}
	public void setR29_10_n_trading_nl_(BigDecimal r29_10_n_trading_nl_) {
		this.r29_10_n_trading_nl_ = r29_10_n_trading_nl_;
	}
	public String getR30_product() {
		return r30_product;
	}
	public void setR30_product(String r30_product) {
		this.r30_product = r30_product;
	}
	public BigDecimal getR30_hedging_amount() {
		return r30_hedging_amount;
	}
	public void setR30_hedging_amount(BigDecimal r30_hedging_amount) {
		this.r30_hedging_amount = r30_hedging_amount;
	}
	public BigDecimal getR30_trading_amount() {
		return r30_trading_amount;
	}
	public void setR30_trading_amount(BigDecimal r30_trading_amount) {
		this.r30_trading_amount = r30_trading_amount;
	}
	public BigDecimal getR30_resident_amount() {
		return r30_resident_amount;
	}
	public void setR30_resident_amount(BigDecimal r30_resident_amount) {
		this.r30_resident_amount = r30_resident_amount;
	}
	public BigDecimal getR30_non_resident_amount() {
		return r30_non_resident_amount;
	}
	public void setR30_non_resident_amount(BigDecimal r30_non_resident_amount) {
		this.r30_non_resident_amount = r30_non_resident_amount;
	}
	public BigDecimal getR30_with1year_amount() {
		return r30_with1year_amount;
	}
	public void setR30_with1year_amount(BigDecimal r30_with1year_amount) {
		this.r30_with1year_amount = r30_with1year_amount;
	}
	public BigDecimal getR30_1to3year_amount() {
		return r30_1to3year_amount;
	}
	public void setR30_1to3year_amount(BigDecimal r30_1to3year_amount) {
		this.r30_1to3year_amount = r30_1to3year_amount;
	}
	public BigDecimal getR30_over3year_amount() {
		return r30_over3year_amount;
	}
	public void setR30_over3year_amount(BigDecimal r30_over3year_amount) {
		this.r30_over3year_amount = r30_over3year_amount;
	}
	public BigDecimal getR30_10_headging_nl() {
		return r30_10_headging_nl;
	}
	public void setR30_10_headging_nl(BigDecimal r30_10_headging_nl) {
		this.r30_10_headging_nl = r30_10_headging_nl;
	}
	public BigDecimal getR30_10_n_headging_nl_() {
		return r30_10_n_headging_nl_;
	}
	public void setR30_10_n_headging_nl_(BigDecimal r30_10_n_headging_nl_) {
		this.r30_10_n_headging_nl_ = r30_10_n_headging_nl_;
	}
	public BigDecimal getR30_10_trading_nl() {
		return r30_10_trading_nl;
	}
	public void setR30_10_trading_nl(BigDecimal r30_10_trading_nl) {
		this.r30_10_trading_nl = r30_10_trading_nl;
	}
	public BigDecimal getR30_10_n_trading_nl_() {
		return r30_10_n_trading_nl_;
	}
	public void setR30_10_n_trading_nl_(BigDecimal r30_10_n_trading_nl_) {
		this.r30_10_n_trading_nl_ = r30_10_n_trading_nl_;
	}
	public String getR31_product() {
		return r31_product;
	}
	public void setR31_product(String r31_product) {
		this.r31_product = r31_product;
	}
	public BigDecimal getR31_hedging_amount() {
		return r31_hedging_amount;
	}
	public void setR31_hedging_amount(BigDecimal r31_hedging_amount) {
		this.r31_hedging_amount = r31_hedging_amount;
	}
	public BigDecimal getR31_trading_amount() {
		return r31_trading_amount;
	}
	public void setR31_trading_amount(BigDecimal r31_trading_amount) {
		this.r31_trading_amount = r31_trading_amount;
	}
	public BigDecimal getR31_resident_amount() {
		return r31_resident_amount;
	}
	public void setR31_resident_amount(BigDecimal r31_resident_amount) {
		this.r31_resident_amount = r31_resident_amount;
	}
	public BigDecimal getR31_non_resident_amount() {
		return r31_non_resident_amount;
	}
	public void setR31_non_resident_amount(BigDecimal r31_non_resident_amount) {
		this.r31_non_resident_amount = r31_non_resident_amount;
	}
	public BigDecimal getR31_with1year_amount() {
		return r31_with1year_amount;
	}
	public void setR31_with1year_amount(BigDecimal r31_with1year_amount) {
		this.r31_with1year_amount = r31_with1year_amount;
	}
	public BigDecimal getR31_1to3year_amount() {
		return r31_1to3year_amount;
	}
	public void setR31_1to3year_amount(BigDecimal r31_1to3year_amount) {
		this.r31_1to3year_amount = r31_1to3year_amount;
	}
	public BigDecimal getR31_over3year_amount() {
		return r31_over3year_amount;
	}
	public void setR31_over3year_amount(BigDecimal r31_over3year_amount) {
		this.r31_over3year_amount = r31_over3year_amount;
	}
	public BigDecimal getR31_10_headging_nl() {
		return r31_10_headging_nl;
	}
	public void setR31_10_headging_nl(BigDecimal r31_10_headging_nl) {
		this.r31_10_headging_nl = r31_10_headging_nl;
	}
	public BigDecimal getR31_10_n_headging_nl_() {
		return r31_10_n_headging_nl_;
	}
	public void setR31_10_n_headging_nl_(BigDecimal r31_10_n_headging_nl_) {
		this.r31_10_n_headging_nl_ = r31_10_n_headging_nl_;
	}
	public BigDecimal getR31_10_trading_nl() {
		return r31_10_trading_nl;
	}
	public void setR31_10_trading_nl(BigDecimal r31_10_trading_nl) {
		this.r31_10_trading_nl = r31_10_trading_nl;
	}
	public BigDecimal getR31_10_n_trading_nl_() {
		return r31_10_n_trading_nl_;
	}
	public void setR31_10_n_trading_nl_(BigDecimal r31_10_n_trading_nl_) {
		this.r31_10_n_trading_nl_ = r31_10_n_trading_nl_;
	}
	public String getR32_product() {
		return r32_product;
	}
	public void setR32_product(String r32_product) {
		this.r32_product = r32_product;
	}
	public BigDecimal getR32_hedging_amount() {
		return r32_hedging_amount;
	}
	public void setR32_hedging_amount(BigDecimal r32_hedging_amount) {
		this.r32_hedging_amount = r32_hedging_amount;
	}
	public BigDecimal getR32_trading_amount() {
		return r32_trading_amount;
	}
	public void setR32_trading_amount(BigDecimal r32_trading_amount) {
		this.r32_trading_amount = r32_trading_amount;
	}
	public BigDecimal getR32_resident_amount() {
		return r32_resident_amount;
	}
	public void setR32_resident_amount(BigDecimal r32_resident_amount) {
		this.r32_resident_amount = r32_resident_amount;
	}
	public BigDecimal getR32_non_resident_amount() {
		return r32_non_resident_amount;
	}
	public void setR32_non_resident_amount(BigDecimal r32_non_resident_amount) {
		this.r32_non_resident_amount = r32_non_resident_amount;
	}
	public BigDecimal getR32_with1year_amount() {
		return r32_with1year_amount;
	}
	public void setR32_with1year_amount(BigDecimal r32_with1year_amount) {
		this.r32_with1year_amount = r32_with1year_amount;
	}
	public BigDecimal getR32_1to3year_amount() {
		return r32_1to3year_amount;
	}
	public void setR32_1to3year_amount(BigDecimal r32_1to3year_amount) {
		this.r32_1to3year_amount = r32_1to3year_amount;
	}
	public BigDecimal getR32_over3year_amount() {
		return r32_over3year_amount;
	}
	public void setR32_over3year_amount(BigDecimal r32_over3year_amount) {
		this.r32_over3year_amount = r32_over3year_amount;
	}
	public BigDecimal getR32_10_headging_nl() {
		return r32_10_headging_nl;
	}
	public void setR32_10_headging_nl(BigDecimal r32_10_headging_nl) {
		this.r32_10_headging_nl = r32_10_headging_nl;
	}
	public BigDecimal getR32_10_n_headging_nl_() {
		return r32_10_n_headging_nl_;
	}
	public void setR32_10_n_headging_nl_(BigDecimal r32_10_n_headging_nl_) {
		this.r32_10_n_headging_nl_ = r32_10_n_headging_nl_;
	}
	public BigDecimal getR32_10_trading_nl() {
		return r32_10_trading_nl;
	}
	public void setR32_10_trading_nl(BigDecimal r32_10_trading_nl) {
		this.r32_10_trading_nl = r32_10_trading_nl;
	}
	public BigDecimal getR32_10_n_trading_nl_() {
		return r32_10_n_trading_nl_;
	}
	public void setR32_10_n_trading_nl_(BigDecimal r32_10_n_trading_nl_) {
		this.r32_10_n_trading_nl_ = r32_10_n_trading_nl_;
	}
	public String getR33_product() {
		return r33_product;
	}
	public void setR33_product(String r33_product) {
		this.r33_product = r33_product;
	}
	public BigDecimal getR33_hedging_amount() {
		return r33_hedging_amount;
	}
	public void setR33_hedging_amount(BigDecimal r33_hedging_amount) {
		this.r33_hedging_amount = r33_hedging_amount;
	}
	public BigDecimal getR33_trading_amount() {
		return r33_trading_amount;
	}
	public void setR33_trading_amount(BigDecimal r33_trading_amount) {
		this.r33_trading_amount = r33_trading_amount;
	}
	public BigDecimal getR33_resident_amount() {
		return r33_resident_amount;
	}
	public void setR33_resident_amount(BigDecimal r33_resident_amount) {
		this.r33_resident_amount = r33_resident_amount;
	}
	public BigDecimal getR33_non_resident_amount() {
		return r33_non_resident_amount;
	}
	public void setR33_non_resident_amount(BigDecimal r33_non_resident_amount) {
		this.r33_non_resident_amount = r33_non_resident_amount;
	}
	public BigDecimal getR33_with1year_amount() {
		return r33_with1year_amount;
	}
	public void setR33_with1year_amount(BigDecimal r33_with1year_amount) {
		this.r33_with1year_amount = r33_with1year_amount;
	}
	public BigDecimal getR33_1to3year_amount() {
		return r33_1to3year_amount;
	}
	public void setR33_1to3year_amount(BigDecimal r33_1to3year_amount) {
		this.r33_1to3year_amount = r33_1to3year_amount;
	}
	public BigDecimal getR33_over3year_amount() {
		return r33_over3year_amount;
	}
	public void setR33_over3year_amount(BigDecimal r33_over3year_amount) {
		this.r33_over3year_amount = r33_over3year_amount;
	}
	public BigDecimal getR33_10_headging_nl() {
		return r33_10_headging_nl;
	}
	public void setR33_10_headging_nl(BigDecimal r33_10_headging_nl) {
		this.r33_10_headging_nl = r33_10_headging_nl;
	}
	public BigDecimal getR33_10_n_headging_nl_() {
		return r33_10_n_headging_nl_;
	}
	public void setR33_10_n_headging_nl_(BigDecimal r33_10_n_headging_nl_) {
		this.r33_10_n_headging_nl_ = r33_10_n_headging_nl_;
	}
	public BigDecimal getR33_10_trading_nl() {
		return r33_10_trading_nl;
	}
	public void setR33_10_trading_nl(BigDecimal r33_10_trading_nl) {
		this.r33_10_trading_nl = r33_10_trading_nl;
	}
	public BigDecimal getR33_10_n_trading_nl_() {
		return r33_10_n_trading_nl_;
	}
	public void setR33_10_n_trading_nl_(BigDecimal r33_10_n_trading_nl_) {
		this.r33_10_n_trading_nl_ = r33_10_n_trading_nl_;
	}
	public String getR34_product() {
		return r34_product;
	}
	public void setR34_product(String r34_product) {
		this.r34_product = r34_product;
	}
	public BigDecimal getR34_hedging_amount() {
		return r34_hedging_amount;
	}
	public void setR34_hedging_amount(BigDecimal r34_hedging_amount) {
		this.r34_hedging_amount = r34_hedging_amount;
	}
	public BigDecimal getR34_trading_amount() {
		return r34_trading_amount;
	}
	public void setR34_trading_amount(BigDecimal r34_trading_amount) {
		this.r34_trading_amount = r34_trading_amount;
	}
	public BigDecimal getR34_resident_amount() {
		return r34_resident_amount;
	}
	public void setR34_resident_amount(BigDecimal r34_resident_amount) {
		this.r34_resident_amount = r34_resident_amount;
	}
	public BigDecimal getR34_non_resident_amount() {
		return r34_non_resident_amount;
	}
	public void setR34_non_resident_amount(BigDecimal r34_non_resident_amount) {
		this.r34_non_resident_amount = r34_non_resident_amount;
	}
	public BigDecimal getR34_with1year_amount() {
		return r34_with1year_amount;
	}
	public void setR34_with1year_amount(BigDecimal r34_with1year_amount) {
		this.r34_with1year_amount = r34_with1year_amount;
	}
	public BigDecimal getR34_1to3year_amount() {
		return r34_1to3year_amount;
	}
	public void setR34_1to3year_amount(BigDecimal r34_1to3year_amount) {
		this.r34_1to3year_amount = r34_1to3year_amount;
	}
	public BigDecimal getR34_over3year_amount() {
		return r34_over3year_amount;
	}
	public void setR34_over3year_amount(BigDecimal r34_over3year_amount) {
		this.r34_over3year_amount = r34_over3year_amount;
	}
	public BigDecimal getR34_10_headging_nl() {
		return r34_10_headging_nl;
	}
	public void setR34_10_headging_nl(BigDecimal r34_10_headging_nl) {
		this.r34_10_headging_nl = r34_10_headging_nl;
	}
	public BigDecimal getR34_10_n_headging_nl_() {
		return r34_10_n_headging_nl_;
	}
	public void setR34_10_n_headging_nl_(BigDecimal r34_10_n_headging_nl_) {
		this.r34_10_n_headging_nl_ = r34_10_n_headging_nl_;
	}
	public BigDecimal getR34_10_trading_nl() {
		return r34_10_trading_nl;
	}
	public void setR34_10_trading_nl(BigDecimal r34_10_trading_nl) {
		this.r34_10_trading_nl = r34_10_trading_nl;
	}
	public BigDecimal getR34_10_n_trading_nl_() {
		return r34_10_n_trading_nl_;
	}
	public void setR34_10_n_trading_nl_(BigDecimal r34_10_n_trading_nl_) {
		this.r34_10_n_trading_nl_ = r34_10_n_trading_nl_;
	}
	public String getR35_product() {
		return r35_product;
	}
	public void setR35_product(String r35_product) {
		this.r35_product = r35_product;
	}
	public BigDecimal getR35_hedging_amount() {
		return r35_hedging_amount;
	}
	public void setR35_hedging_amount(BigDecimal r35_hedging_amount) {
		this.r35_hedging_amount = r35_hedging_amount;
	}
	public BigDecimal getR35_trading_amount() {
		return r35_trading_amount;
	}
	public void setR35_trading_amount(BigDecimal r35_trading_amount) {
		this.r35_trading_amount = r35_trading_amount;
	}
	public BigDecimal getR35_resident_amount() {
		return r35_resident_amount;
	}
	public void setR35_resident_amount(BigDecimal r35_resident_amount) {
		this.r35_resident_amount = r35_resident_amount;
	}
	public BigDecimal getR35_non_resident_amount() {
		return r35_non_resident_amount;
	}
	public void setR35_non_resident_amount(BigDecimal r35_non_resident_amount) {
		this.r35_non_resident_amount = r35_non_resident_amount;
	}
	public BigDecimal getR35_with1year_amount() {
		return r35_with1year_amount;
	}
	public void setR35_with1year_amount(BigDecimal r35_with1year_amount) {
		this.r35_with1year_amount = r35_with1year_amount;
	}
	public BigDecimal getR35_1to3year_amount() {
		return r35_1to3year_amount;
	}
	public void setR35_1to3year_amount(BigDecimal r35_1to3year_amount) {
		this.r35_1to3year_amount = r35_1to3year_amount;
	}
	public BigDecimal getR35_over3year_amount() {
		return r35_over3year_amount;
	}
	public void setR35_over3year_amount(BigDecimal r35_over3year_amount) {
		this.r35_over3year_amount = r35_over3year_amount;
	}
	public BigDecimal getR35_10_headging_nl() {
		return r35_10_headging_nl;
	}
	public void setR35_10_headging_nl(BigDecimal r35_10_headging_nl) {
		this.r35_10_headging_nl = r35_10_headging_nl;
	}
	public BigDecimal getR35_10_n_headging_nl_() {
		return r35_10_n_headging_nl_;
	}
	public void setR35_10_n_headging_nl_(BigDecimal r35_10_n_headging_nl_) {
		this.r35_10_n_headging_nl_ = r35_10_n_headging_nl_;
	}
	public BigDecimal getR35_10_trading_nl() {
		return r35_10_trading_nl;
	}
	public void setR35_10_trading_nl(BigDecimal r35_10_trading_nl) {
		this.r35_10_trading_nl = r35_10_trading_nl;
	}
	public BigDecimal getR35_10_n_trading_nl_() {
		return r35_10_n_trading_nl_;
	}
	public void setR35_10_n_trading_nl_(BigDecimal r35_10_n_trading_nl_) {
		this.r35_10_n_trading_nl_ = r35_10_n_trading_nl_;
	}
	public String getR36_product() {
		return r36_product;
	}
	public void setR36_product(String r36_product) {
		this.r36_product = r36_product;
	}
	public BigDecimal getR36_hedging_amount() {
		return r36_hedging_amount;
	}
	public void setR36_hedging_amount(BigDecimal r36_hedging_amount) {
		this.r36_hedging_amount = r36_hedging_amount;
	}
	public BigDecimal getR36_trading_amount() {
		return r36_trading_amount;
	}
	public void setR36_trading_amount(BigDecimal r36_trading_amount) {
		this.r36_trading_amount = r36_trading_amount;
	}
	public BigDecimal getR36_resident_amount() {
		return r36_resident_amount;
	}
	public void setR36_resident_amount(BigDecimal r36_resident_amount) {
		this.r36_resident_amount = r36_resident_amount;
	}
	public BigDecimal getR36_non_resident_amount() {
		return r36_non_resident_amount;
	}
	public void setR36_non_resident_amount(BigDecimal r36_non_resident_amount) {
		this.r36_non_resident_amount = r36_non_resident_amount;
	}
	public BigDecimal getR36_with1year_amount() {
		return r36_with1year_amount;
	}
	public void setR36_with1year_amount(BigDecimal r36_with1year_amount) {
		this.r36_with1year_amount = r36_with1year_amount;
	}
	public BigDecimal getR36_1to3year_amount() {
		return r36_1to3year_amount;
	}
	public void setR36_1to3year_amount(BigDecimal r36_1to3year_amount) {
		this.r36_1to3year_amount = r36_1to3year_amount;
	}
	public BigDecimal getR36_over3year_amount() {
		return r36_over3year_amount;
	}
	public void setR36_over3year_amount(BigDecimal r36_over3year_amount) {
		this.r36_over3year_amount = r36_over3year_amount;
	}
	public BigDecimal getR36_10_headging_nl() {
		return r36_10_headging_nl;
	}
	public void setR36_10_headging_nl(BigDecimal r36_10_headging_nl) {
		this.r36_10_headging_nl = r36_10_headging_nl;
	}
	public BigDecimal getR36_10_n_headging_nl_() {
		return r36_10_n_headging_nl_;
	}
	public void setR36_10_n_headging_nl_(BigDecimal r36_10_n_headging_nl_) {
		this.r36_10_n_headging_nl_ = r36_10_n_headging_nl_;
	}
	public BigDecimal getR36_10_trading_nl() {
		return r36_10_trading_nl;
	}
	public void setR36_10_trading_nl(BigDecimal r36_10_trading_nl) {
		this.r36_10_trading_nl = r36_10_trading_nl;
	}
	public BigDecimal getR36_10_n_trading_nl_() {
		return r36_10_n_trading_nl_;
	}
	public void setR36_10_n_trading_nl_(BigDecimal r36_10_n_trading_nl_) {
		this.r36_10_n_trading_nl_ = r36_10_n_trading_nl_;
	}
	public String getR37_product() {
		return r37_product;
	}
	public void setR37_product(String r37_product) {
		this.r37_product = r37_product;
	}
	public BigDecimal getR37_hedging_amount() {
		return r37_hedging_amount;
	}
	public void setR37_hedging_amount(BigDecimal r37_hedging_amount) {
		this.r37_hedging_amount = r37_hedging_amount;
	}
	public BigDecimal getR37_trading_amount() {
		return r37_trading_amount;
	}
	public void setR37_trading_amount(BigDecimal r37_trading_amount) {
		this.r37_trading_amount = r37_trading_amount;
	}
	public BigDecimal getR37_resident_amount() {
		return r37_resident_amount;
	}
	public void setR37_resident_amount(BigDecimal r37_resident_amount) {
		this.r37_resident_amount = r37_resident_amount;
	}
	public BigDecimal getR37_non_resident_amount() {
		return r37_non_resident_amount;
	}
	public void setR37_non_resident_amount(BigDecimal r37_non_resident_amount) {
		this.r37_non_resident_amount = r37_non_resident_amount;
	}
	public BigDecimal getR37_with1year_amount() {
		return r37_with1year_amount;
	}
	public void setR37_with1year_amount(BigDecimal r37_with1year_amount) {
		this.r37_with1year_amount = r37_with1year_amount;
	}
	public BigDecimal getR37_1to3year_amount() {
		return r37_1to3year_amount;
	}
	public void setR37_1to3year_amount(BigDecimal r37_1to3year_amount) {
		this.r37_1to3year_amount = r37_1to3year_amount;
	}
	public BigDecimal getR37_over3year_amount() {
		return r37_over3year_amount;
	}
	public void setR37_over3year_amount(BigDecimal r37_over3year_amount) {
		this.r37_over3year_amount = r37_over3year_amount;
	}
	public BigDecimal getR37_10_headging_nl() {
		return r37_10_headging_nl;
	}
	public void setR37_10_headging_nl(BigDecimal r37_10_headging_nl) {
		this.r37_10_headging_nl = r37_10_headging_nl;
	}
	public BigDecimal getR37_10_n_headging_nl_() {
		return r37_10_n_headging_nl_;
	}
	public void setR37_10_n_headging_nl_(BigDecimal r37_10_n_headging_nl_) {
		this.r37_10_n_headging_nl_ = r37_10_n_headging_nl_;
	}
	public BigDecimal getR37_10_trading_nl() {
		return r37_10_trading_nl;
	}
	public void setR37_10_trading_nl(BigDecimal r37_10_trading_nl) {
		this.r37_10_trading_nl = r37_10_trading_nl;
	}
	public BigDecimal getR37_10_n_trading_nl_() {
		return r37_10_n_trading_nl_;
	}
	public void setR37_10_n_trading_nl_(BigDecimal r37_10_n_trading_nl_) {
		this.r37_10_n_trading_nl_ = r37_10_n_trading_nl_;
	}
	public String getR38_product() {
		return r38_product;
	}
	public void setR38_product(String r38_product) {
		this.r38_product = r38_product;
	}
	public BigDecimal getR38_hedging_amount() {
		return r38_hedging_amount;
	}
	public void setR38_hedging_amount(BigDecimal r38_hedging_amount) {
		this.r38_hedging_amount = r38_hedging_amount;
	}
	public BigDecimal getR38_trading_amount() {
		return r38_trading_amount;
	}
	public void setR38_trading_amount(BigDecimal r38_trading_amount) {
		this.r38_trading_amount = r38_trading_amount;
	}
	public BigDecimal getR38_resident_amount() {
		return r38_resident_amount;
	}
	public void setR38_resident_amount(BigDecimal r38_resident_amount) {
		this.r38_resident_amount = r38_resident_amount;
	}
	public BigDecimal getR38_non_resident_amount() {
		return r38_non_resident_amount;
	}
	public void setR38_non_resident_amount(BigDecimal r38_non_resident_amount) {
		this.r38_non_resident_amount = r38_non_resident_amount;
	}
	public BigDecimal getR38_with1year_amount() {
		return r38_with1year_amount;
	}
	public void setR38_with1year_amount(BigDecimal r38_with1year_amount) {
		this.r38_with1year_amount = r38_with1year_amount;
	}
	public BigDecimal getR38_1to3year_amount() {
		return r38_1to3year_amount;
	}
	public void setR38_1to3year_amount(BigDecimal r38_1to3year_amount) {
		this.r38_1to3year_amount = r38_1to3year_amount;
	}
	public BigDecimal getR38_over3year_amount() {
		return r38_over3year_amount;
	}
	public void setR38_over3year_amount(BigDecimal r38_over3year_amount) {
		this.r38_over3year_amount = r38_over3year_amount;
	}
	public BigDecimal getR38_bought_headging_nd() {
		return r38_bought_headging_nd;
	}
	public void setR38_bought_headging_nd(BigDecimal r38_bought_headging_nd) {
		this.r38_bought_headging_nd = r38_bought_headging_nd;
	}
	public BigDecimal getR38_sold_headging_nd() {
		return r38_sold_headging_nd;
	}
	public void setR38_sold_headging_nd(BigDecimal r38_sold_headging_nd) {
		this.r38_sold_headging_nd = r38_sold_headging_nd;
	}
	public BigDecimal getR38_bought_trading_nd() {
		return r38_bought_trading_nd;
	}
	public void setR38_bought_trading_nd(BigDecimal r38_bought_trading_nd) {
		this.r38_bought_trading_nd = r38_bought_trading_nd;
	}
	public BigDecimal getR38_sold_trading_nd() {
		return r38_sold_trading_nd;
	}
	public void setR38_sold_trading_nd(BigDecimal r38_sold_trading_nd) {
		this.r38_sold_trading_nd = r38_sold_trading_nd;
	}
	public String getR39_product() {
		return r39_product;
	}
	public void setR39_product(String r39_product) {
		this.r39_product = r39_product;
	}
	public BigDecimal getR39_hedging_amount() {
		return r39_hedging_amount;
	}
	public void setR39_hedging_amount(BigDecimal r39_hedging_amount) {
		this.r39_hedging_amount = r39_hedging_amount;
	}
	public BigDecimal getR39_trading_amount() {
		return r39_trading_amount;
	}
	public void setR39_trading_amount(BigDecimal r39_trading_amount) {
		this.r39_trading_amount = r39_trading_amount;
	}
	public BigDecimal getR39_resident_amount() {
		return r39_resident_amount;
	}
	public void setR39_resident_amount(BigDecimal r39_resident_amount) {
		this.r39_resident_amount = r39_resident_amount;
	}
	public BigDecimal getR39_non_resident_amount() {
		return r39_non_resident_amount;
	}
	public void setR39_non_resident_amount(BigDecimal r39_non_resident_amount) {
		this.r39_non_resident_amount = r39_non_resident_amount;
	}
	public BigDecimal getR39_with1year_amount() {
		return r39_with1year_amount;
	}
	public void setR39_with1year_amount(BigDecimal r39_with1year_amount) {
		this.r39_with1year_amount = r39_with1year_amount;
	}
	public BigDecimal getR39_1to3year_amount() {
		return r39_1to3year_amount;
	}
	public void setR39_1to3year_amount(BigDecimal r39_1to3year_amount) {
		this.r39_1to3year_amount = r39_1to3year_amount;
	}
	public BigDecimal getR39_over3year_amount() {
		return r39_over3year_amount;
	}
	public void setR39_over3year_amount(BigDecimal r39_over3year_amount) {
		this.r39_over3year_amount = r39_over3year_amount;
	}
	public BigDecimal getR39_bought_headging_nd() {
		return r39_bought_headging_nd;
	}
	public void setR39_bought_headging_nd(BigDecimal r39_bought_headging_nd) {
		this.r39_bought_headging_nd = r39_bought_headging_nd;
	}
	public BigDecimal getR39_sold_headging_nd() {
		return r39_sold_headging_nd;
	}
	public void setR39_sold_headging_nd(BigDecimal r39_sold_headging_nd) {
		this.r39_sold_headging_nd = r39_sold_headging_nd;
	}
	public BigDecimal getR39_bought_trading_nd() {
		return r39_bought_trading_nd;
	}
	public void setR39_bought_trading_nd(BigDecimal r39_bought_trading_nd) {
		this.r39_bought_trading_nd = r39_bought_trading_nd;
	}
	public BigDecimal getR39_sold_trading_nd() {
		return r39_sold_trading_nd;
	}
	public void setR39_sold_trading_nd(BigDecimal r39_sold_trading_nd) {
		this.r39_sold_trading_nd = r39_sold_trading_nd;
	}
	public String getR40_product() {
		return r40_product;
	}
	public void setR40_product(String r40_product) {
		this.r40_product = r40_product;
	}
	public BigDecimal getR40_hedging_amount() {
		return r40_hedging_amount;
	}
	public void setR40_hedging_amount(BigDecimal r40_hedging_amount) {
		this.r40_hedging_amount = r40_hedging_amount;
	}
	public BigDecimal getR40_trading_amount() {
		return r40_trading_amount;
	}
	public void setR40_trading_amount(BigDecimal r40_trading_amount) {
		this.r40_trading_amount = r40_trading_amount;
	}
	public BigDecimal getR40_resident_amount() {
		return r40_resident_amount;
	}
	public void setR40_resident_amount(BigDecimal r40_resident_amount) {
		this.r40_resident_amount = r40_resident_amount;
	}
	public BigDecimal getR40_non_resident_amount() {
		return r40_non_resident_amount;
	}
	public void setR40_non_resident_amount(BigDecimal r40_non_resident_amount) {
		this.r40_non_resident_amount = r40_non_resident_amount;
	}
	public BigDecimal getR40_with1year_amount() {
		return r40_with1year_amount;
	}
	public void setR40_with1year_amount(BigDecimal r40_with1year_amount) {
		this.r40_with1year_amount = r40_with1year_amount;
	}
	public BigDecimal getR40_1to3year_amount() {
		return r40_1to3year_amount;
	}
	public void setR40_1to3year_amount(BigDecimal r40_1to3year_amount) {
		this.r40_1to3year_amount = r40_1to3year_amount;
	}
	public BigDecimal getR40_over3year_amount() {
		return r40_over3year_amount;
	}
	public void setR40_over3year_amount(BigDecimal r40_over3year_amount) {
		this.r40_over3year_amount = r40_over3year_amount;
	}
	public BigDecimal getR40_bought_headging_nd() {
		return r40_bought_headging_nd;
	}
	public void setR40_bought_headging_nd(BigDecimal r40_bought_headging_nd) {
		this.r40_bought_headging_nd = r40_bought_headging_nd;
	}
	public BigDecimal getR40_sold_headging_nd() {
		return r40_sold_headging_nd;
	}
	public void setR40_sold_headging_nd(BigDecimal r40_sold_headging_nd) {
		this.r40_sold_headging_nd = r40_sold_headging_nd;
	}
	public BigDecimal getR40_bought_trading_nd() {
		return r40_bought_trading_nd;
	}
	public void setR40_bought_trading_nd(BigDecimal r40_bought_trading_nd) {
		this.r40_bought_trading_nd = r40_bought_trading_nd;
	}
	public BigDecimal getR40_sold_trading_nd() {
		return r40_sold_trading_nd;
	}
	public void setR40_sold_trading_nd(BigDecimal r40_sold_trading_nd) {
		this.r40_sold_trading_nd = r40_sold_trading_nd;
	}
	public String getR41_product() {
		return r41_product;
	}
	public void setR41_product(String r41_product) {
		this.r41_product = r41_product;
	}
	public BigDecimal getR41_hedging_amount() {
		return r41_hedging_amount;
	}
	public void setR41_hedging_amount(BigDecimal r41_hedging_amount) {
		this.r41_hedging_amount = r41_hedging_amount;
	}
	public BigDecimal getR41_trading_amount() {
		return r41_trading_amount;
	}
	public void setR41_trading_amount(BigDecimal r41_trading_amount) {
		this.r41_trading_amount = r41_trading_amount;
	}
	public BigDecimal getR41_resident_amount() {
		return r41_resident_amount;
	}
	public void setR41_resident_amount(BigDecimal r41_resident_amount) {
		this.r41_resident_amount = r41_resident_amount;
	}
	public BigDecimal getR41_non_resident_amount() {
		return r41_non_resident_amount;
	}
	public void setR41_non_resident_amount(BigDecimal r41_non_resident_amount) {
		this.r41_non_resident_amount = r41_non_resident_amount;
	}
	public BigDecimal getR41_with1year_amount() {
		return r41_with1year_amount;
	}
	public void setR41_with1year_amount(BigDecimal r41_with1year_amount) {
		this.r41_with1year_amount = r41_with1year_amount;
	}
	public BigDecimal getR41_1to3year_amount() {
		return r41_1to3year_amount;
	}
	public void setR41_1to3year_amount(BigDecimal r41_1to3year_amount) {
		this.r41_1to3year_amount = r41_1to3year_amount;
	}
	public BigDecimal getR41_over3year_amount() {
		return r41_over3year_amount;
	}
	public void setR41_over3year_amount(BigDecimal r41_over3year_amount) {
		this.r41_over3year_amount = r41_over3year_amount;
	}
	public BigDecimal getR41_bought_headging_nd() {
		return r41_bought_headging_nd;
	}
	public void setR41_bought_headging_nd(BigDecimal r41_bought_headging_nd) {
		this.r41_bought_headging_nd = r41_bought_headging_nd;
	}
	public BigDecimal getR41_sold_headging_nd() {
		return r41_sold_headging_nd;
	}
	public void setR41_sold_headging_nd(BigDecimal r41_sold_headging_nd) {
		this.r41_sold_headging_nd = r41_sold_headging_nd;
	}
	public BigDecimal getR41_bought_trading_nd() {
		return r41_bought_trading_nd;
	}
	public void setR41_bought_trading_nd(BigDecimal r41_bought_trading_nd) {
		this.r41_bought_trading_nd = r41_bought_trading_nd;
	}
	public BigDecimal getR41_sold_trading_nd() {
		return r41_sold_trading_nd;
	}
	public void setR41_sold_trading_nd(BigDecimal r41_sold_trading_nd) {
		this.r41_sold_trading_nd = r41_sold_trading_nd;
	}
	public String getR42_product() {
		return r42_product;
	}
	public void setR42_product(String r42_product) {
		this.r42_product = r42_product;
	}
	public BigDecimal getR42_hedging_amount() {
		return r42_hedging_amount;
	}
	public void setR42_hedging_amount(BigDecimal r42_hedging_amount) {
		this.r42_hedging_amount = r42_hedging_amount;
	}
	public BigDecimal getR42_trading_amount() {
		return r42_trading_amount;
	}
	public void setR42_trading_amount(BigDecimal r42_trading_amount) {
		this.r42_trading_amount = r42_trading_amount;
	}
	public BigDecimal getR42_resident_amount() {
		return r42_resident_amount;
	}
	public void setR42_resident_amount(BigDecimal r42_resident_amount) {
		this.r42_resident_amount = r42_resident_amount;
	}
	public BigDecimal getR42_non_resident_amount() {
		return r42_non_resident_amount;
	}
	public void setR42_non_resident_amount(BigDecimal r42_non_resident_amount) {
		this.r42_non_resident_amount = r42_non_resident_amount;
	}
	public BigDecimal getR42_with1year_amount() {
		return r42_with1year_amount;
	}
	public void setR42_with1year_amount(BigDecimal r42_with1year_amount) {
		this.r42_with1year_amount = r42_with1year_amount;
	}
	public BigDecimal getR42_1to3year_amount() {
		return r42_1to3year_amount;
	}
	public void setR42_1to3year_amount(BigDecimal r42_1to3year_amount) {
		this.r42_1to3year_amount = r42_1to3year_amount;
	}
	public BigDecimal getR42_over3year_amount() {
		return r42_over3year_amount;
	}
	public void setR42_over3year_amount(BigDecimal r42_over3year_amount) {
		this.r42_over3year_amount = r42_over3year_amount;
	}
	public BigDecimal getR42_bought_headging_nd() {
		return r42_bought_headging_nd;
	}
	public void setR42_bought_headging_nd(BigDecimal r42_bought_headging_nd) {
		this.r42_bought_headging_nd = r42_bought_headging_nd;
	}
	public BigDecimal getR42_sold_headging_nd() {
		return r42_sold_headging_nd;
	}
	public void setR42_sold_headging_nd(BigDecimal r42_sold_headging_nd) {
		this.r42_sold_headging_nd = r42_sold_headging_nd;
	}
	public BigDecimal getR42_bought_trading_nd() {
		return r42_bought_trading_nd;
	}
	public void setR42_bought_trading_nd(BigDecimal r42_bought_trading_nd) {
		this.r42_bought_trading_nd = r42_bought_trading_nd;
	}
	public BigDecimal getR42_sold_trading_nd() {
		return r42_sold_trading_nd;
	}
	public void setR42_sold_trading_nd(BigDecimal r42_sold_trading_nd) {
		this.r42_sold_trading_nd = r42_sold_trading_nd;
	}
	public String getR43_product() {
		return r43_product;
	}
	public void setR43_product(String r43_product) {
		this.r43_product = r43_product;
	}
	public BigDecimal getR43_hedging_amount() {
		return r43_hedging_amount;
	}
	public void setR43_hedging_amount(BigDecimal r43_hedging_amount) {
		this.r43_hedging_amount = r43_hedging_amount;
	}
	public BigDecimal getR43_trading_amount() {
		return r43_trading_amount;
	}
	public void setR43_trading_amount(BigDecimal r43_trading_amount) {
		this.r43_trading_amount = r43_trading_amount;
	}
	public BigDecimal getR43_resident_amount() {
		return r43_resident_amount;
	}
	public void setR43_resident_amount(BigDecimal r43_resident_amount) {
		this.r43_resident_amount = r43_resident_amount;
	}
	public BigDecimal getR43_non_resident_amount() {
		return r43_non_resident_amount;
	}
	public void setR43_non_resident_amount(BigDecimal r43_non_resident_amount) {
		this.r43_non_resident_amount = r43_non_resident_amount;
	}
	public BigDecimal getR43_with1year_amount() {
		return r43_with1year_amount;
	}
	public void setR43_with1year_amount(BigDecimal r43_with1year_amount) {
		this.r43_with1year_amount = r43_with1year_amount;
	}
	public BigDecimal getR43_1to3year_amount() {
		return r43_1to3year_amount;
	}
	public void setR43_1to3year_amount(BigDecimal r43_1to3year_amount) {
		this.r43_1to3year_amount = r43_1to3year_amount;
	}
	public BigDecimal getR43_over3year_amount() {
		return r43_over3year_amount;
	}
	public void setR43_over3year_amount(BigDecimal r43_over3year_amount) {
		this.r43_over3year_amount = r43_over3year_amount;
	}
	public BigDecimal getR43_bought_headging_nd() {
		return r43_bought_headging_nd;
	}
	public void setR43_bought_headging_nd(BigDecimal r43_bought_headging_nd) {
		this.r43_bought_headging_nd = r43_bought_headging_nd;
	}
	public BigDecimal getR43_sold_headging_nd() {
		return r43_sold_headging_nd;
	}
	public void setR43_sold_headging_nd(BigDecimal r43_sold_headging_nd) {
		this.r43_sold_headging_nd = r43_sold_headging_nd;
	}
	public BigDecimal getR43_bought_trading_nd() {
		return r43_bought_trading_nd;
	}
	public void setR43_bought_trading_nd(BigDecimal r43_bought_trading_nd) {
		this.r43_bought_trading_nd = r43_bought_trading_nd;
	}
	public BigDecimal getR43_sold_trading_nd() {
		return r43_sold_trading_nd;
	}
	public void setR43_sold_trading_nd(BigDecimal r43_sold_trading_nd) {
		this.r43_sold_trading_nd = r43_sold_trading_nd;
	}
	public String getR44_product() {
		return r44_product;
	}
	public void setR44_product(String r44_product) {
		this.r44_product = r44_product;
	}
	public BigDecimal getR44_hedging_amount() {
		return r44_hedging_amount;
	}
	public void setR44_hedging_amount(BigDecimal r44_hedging_amount) {
		this.r44_hedging_amount = r44_hedging_amount;
	}
	public BigDecimal getR44_trading_amount() {
		return r44_trading_amount;
	}
	public void setR44_trading_amount(BigDecimal r44_trading_amount) {
		this.r44_trading_amount = r44_trading_amount;
	}
	public BigDecimal getR44_resident_amount() {
		return r44_resident_amount;
	}
	public void setR44_resident_amount(BigDecimal r44_resident_amount) {
		this.r44_resident_amount = r44_resident_amount;
	}
	public BigDecimal getR44_non_resident_amount() {
		return r44_non_resident_amount;
	}
	public void setR44_non_resident_amount(BigDecimal r44_non_resident_amount) {
		this.r44_non_resident_amount = r44_non_resident_amount;
	}
	public BigDecimal getR44_with1year_amount() {
		return r44_with1year_amount;
	}
	public void setR44_with1year_amount(BigDecimal r44_with1year_amount) {
		this.r44_with1year_amount = r44_with1year_amount;
	}
	public BigDecimal getR44_1to3year_amount() {
		return r44_1to3year_amount;
	}
	public void setR44_1to3year_amount(BigDecimal r44_1to3year_amount) {
		this.r44_1to3year_amount = r44_1to3year_amount;
	}
	public BigDecimal getR44_over3year_amount() {
		return r44_over3year_amount;
	}
	public void setR44_over3year_amount(BigDecimal r44_over3year_amount) {
		this.r44_over3year_amount = r44_over3year_amount;
	}
	public BigDecimal getR44_bought_headging_nd() {
		return r44_bought_headging_nd;
	}
	public void setR44_bought_headging_nd(BigDecimal r44_bought_headging_nd) {
		this.r44_bought_headging_nd = r44_bought_headging_nd;
	}
	public BigDecimal getR44_sold_headging_nd() {
		return r44_sold_headging_nd;
	}
	public void setR44_sold_headging_nd(BigDecimal r44_sold_headging_nd) {
		this.r44_sold_headging_nd = r44_sold_headging_nd;
	}
	public BigDecimal getR44_bought_trading_nd() {
		return r44_bought_trading_nd;
	}
	public void setR44_bought_trading_nd(BigDecimal r44_bought_trading_nd) {
		this.r44_bought_trading_nd = r44_bought_trading_nd;
	}
	public BigDecimal getR44_sold_trading_nd() {
		return r44_sold_trading_nd;
	}
	public void setR44_sold_trading_nd(BigDecimal r44_sold_trading_nd) {
		this.r44_sold_trading_nd = r44_sold_trading_nd;
	}
	public String getR45_product() {
		return r45_product;
	}
	public void setR45_product(String r45_product) {
		this.r45_product = r45_product;
	}
	public BigDecimal getR45_hedging_amount() {
		return r45_hedging_amount;
	}
	public void setR45_hedging_amount(BigDecimal r45_hedging_amount) {
		this.r45_hedging_amount = r45_hedging_amount;
	}
	public BigDecimal getR45_trading_amount() {
		return r45_trading_amount;
	}
	public void setR45_trading_amount(BigDecimal r45_trading_amount) {
		this.r45_trading_amount = r45_trading_amount;
	}
	public BigDecimal getR45_resident_amount() {
		return r45_resident_amount;
	}
	public void setR45_resident_amount(BigDecimal r45_resident_amount) {
		this.r45_resident_amount = r45_resident_amount;
	}
	public BigDecimal getR45_non_resident_amount() {
		return r45_non_resident_amount;
	}
	public void setR45_non_resident_amount(BigDecimal r45_non_resident_amount) {
		this.r45_non_resident_amount = r45_non_resident_amount;
	}
	public BigDecimal getR45_with1year_amount() {
		return r45_with1year_amount;
	}
	public void setR45_with1year_amount(BigDecimal r45_with1year_amount) {
		this.r45_with1year_amount = r45_with1year_amount;
	}
	public BigDecimal getR45_1to3year_amount() {
		return r45_1to3year_amount;
	}
	public void setR45_1to3year_amount(BigDecimal r45_1to3year_amount) {
		this.r45_1to3year_amount = r45_1to3year_amount;
	}
	public BigDecimal getR45_over3year_amount() {
		return r45_over3year_amount;
	}
	public void setR45_over3year_amount(BigDecimal r45_over3year_amount) {
		this.r45_over3year_amount = r45_over3year_amount;
	}
	public BigDecimal getR45_bought_headging_nd() {
		return r45_bought_headging_nd;
	}
	public void setR45_bought_headging_nd(BigDecimal r45_bought_headging_nd) {
		this.r45_bought_headging_nd = r45_bought_headging_nd;
	}
	public BigDecimal getR45_sold_headging_nd() {
		return r45_sold_headging_nd;
	}
	public void setR45_sold_headging_nd(BigDecimal r45_sold_headging_nd) {
		this.r45_sold_headging_nd = r45_sold_headging_nd;
	}
	public BigDecimal getR45_bought_trading_nd() {
		return r45_bought_trading_nd;
	}
	public void setR45_bought_trading_nd(BigDecimal r45_bought_trading_nd) {
		this.r45_bought_trading_nd = r45_bought_trading_nd;
	}
	public BigDecimal getR45_sold_trading_nd() {
		return r45_sold_trading_nd;
	}
	public void setR45_sold_trading_nd(BigDecimal r45_sold_trading_nd) {
		this.r45_sold_trading_nd = r45_sold_trading_nd;
	}
	public String getR46_product() {
		return r46_product;
	}
	public void setR46_product(String r46_product) {
		this.r46_product = r46_product;
	}
	public BigDecimal getR46_hedging_amount() {
		return r46_hedging_amount;
	}
	public void setR46_hedging_amount(BigDecimal r46_hedging_amount) {
		this.r46_hedging_amount = r46_hedging_amount;
	}
	public BigDecimal getR46_trading_amount() {
		return r46_trading_amount;
	}
	public void setR46_trading_amount(BigDecimal r46_trading_amount) {
		this.r46_trading_amount = r46_trading_amount;
	}
	public BigDecimal getR46_resident_amount() {
		return r46_resident_amount;
	}
	public void setR46_resident_amount(BigDecimal r46_resident_amount) {
		this.r46_resident_amount = r46_resident_amount;
	}
	public BigDecimal getR46_non_resident_amount() {
		return r46_non_resident_amount;
	}
	public void setR46_non_resident_amount(BigDecimal r46_non_resident_amount) {
		this.r46_non_resident_amount = r46_non_resident_amount;
	}
	public BigDecimal getR46_with1year_amount() {
		return r46_with1year_amount;
	}
	public void setR46_with1year_amount(BigDecimal r46_with1year_amount) {
		this.r46_with1year_amount = r46_with1year_amount;
	}
	public BigDecimal getR46_1to3year_amount() {
		return r46_1to3year_amount;
	}
	public void setR46_1to3year_amount(BigDecimal r46_1to3year_amount) {
		this.r46_1to3year_amount = r46_1to3year_amount;
	}
	public BigDecimal getR46_over3year_amount() {
		return r46_over3year_amount;
	}
	public void setR46_over3year_amount(BigDecimal r46_over3year_amount) {
		this.r46_over3year_amount = r46_over3year_amount;
	}
	public BigDecimal getR46_bought_headging_nd() {
		return r46_bought_headging_nd;
	}
	public void setR46_bought_headging_nd(BigDecimal r46_bought_headging_nd) {
		this.r46_bought_headging_nd = r46_bought_headging_nd;
	}
	public BigDecimal getR46_sold_headging_nd() {
		return r46_sold_headging_nd;
	}
	public void setR46_sold_headging_nd(BigDecimal r46_sold_headging_nd) {
		this.r46_sold_headging_nd = r46_sold_headging_nd;
	}
	public BigDecimal getR46_bought_trading_nd() {
		return r46_bought_trading_nd;
	}
	public void setR46_bought_trading_nd(BigDecimal r46_bought_trading_nd) {
		this.r46_bought_trading_nd = r46_bought_trading_nd;
	}
	public BigDecimal getR46_sold_trading_nd() {
		return r46_sold_trading_nd;
	}
	public void setR46_sold_trading_nd(BigDecimal r46_sold_trading_nd) {
		this.r46_sold_trading_nd = r46_sold_trading_nd;
	}
	public String getR47_product() {
		return r47_product;
	}
	public void setR47_product(String r47_product) {
		this.r47_product = r47_product;
	}
	public BigDecimal getR47_hedging_amount() {
		return r47_hedging_amount;
	}
	public void setR47_hedging_amount(BigDecimal r47_hedging_amount) {
		this.r47_hedging_amount = r47_hedging_amount;
	}
	public BigDecimal getR47_trading_amount() {
		return r47_trading_amount;
	}
	public void setR47_trading_amount(BigDecimal r47_trading_amount) {
		this.r47_trading_amount = r47_trading_amount;
	}
	public BigDecimal getR47_resident_amount() {
		return r47_resident_amount;
	}
	public void setR47_resident_amount(BigDecimal r47_resident_amount) {
		this.r47_resident_amount = r47_resident_amount;
	}
	public BigDecimal getR47_non_resident_amount() {
		return r47_non_resident_amount;
	}
	public void setR47_non_resident_amount(BigDecimal r47_non_resident_amount) {
		this.r47_non_resident_amount = r47_non_resident_amount;
	}
	public BigDecimal getR47_with1year_amount() {
		return r47_with1year_amount;
	}
	public void setR47_with1year_amount(BigDecimal r47_with1year_amount) {
		this.r47_with1year_amount = r47_with1year_amount;
	}
	public BigDecimal getR47_1to3year_amount() {
		return r47_1to3year_amount;
	}
	public void setR47_1to3year_amount(BigDecimal r47_1to3year_amount) {
		this.r47_1to3year_amount = r47_1to3year_amount;
	}
	public BigDecimal getR47_over3year_amount() {
		return r47_over3year_amount;
	}
	public void setR47_over3year_amount(BigDecimal r47_over3year_amount) {
		this.r47_over3year_amount = r47_over3year_amount;
	}
	public BigDecimal getR47_2_headging_nl() {
		return r47_2_headging_nl;
	}
	public void setR47_2_headging_nl(BigDecimal r47_2_headging_nl) {
		this.r47_2_headging_nl = r47_2_headging_nl;
	}
	public BigDecimal getR47_2_n_headging_nl_() {
		return r47_2_n_headging_nl_;
	}
	public void setR47_2_n_headging_nl_(BigDecimal r47_2_n_headging_nl_) {
		this.r47_2_n_headging_nl_ = r47_2_n_headging_nl_;
	}
	public BigDecimal getR47_2_trading_nl() {
		return r47_2_trading_nl;
	}
	public void setR47_2_trading_nl(BigDecimal r47_2_trading_nl) {
		this.r47_2_trading_nl = r47_2_trading_nl;
	}
	public BigDecimal getR47_2_n_trading_nl_() {
		return r47_2_n_trading_nl_;
	}
	public void setR47_2_n_trading_nl_(BigDecimal r47_2_n_trading_nl_) {
		this.r47_2_n_trading_nl_ = r47_2_n_trading_nl_;
	}
	public String getR48_product() {
		return r48_product;
	}
	public void setR48_product(String r48_product) {
		this.r48_product = r48_product;
	}
	public BigDecimal getR48_hedging_amount() {
		return r48_hedging_amount;
	}
	public void setR48_hedging_amount(BigDecimal r48_hedging_amount) {
		this.r48_hedging_amount = r48_hedging_amount;
	}
	public BigDecimal getR48_trading_amount() {
		return r48_trading_amount;
	}
	public void setR48_trading_amount(BigDecimal r48_trading_amount) {
		this.r48_trading_amount = r48_trading_amount;
	}
	public BigDecimal getR48_resident_amount() {
		return r48_resident_amount;
	}
	public void setR48_resident_amount(BigDecimal r48_resident_amount) {
		this.r48_resident_amount = r48_resident_amount;
	}
	public BigDecimal getR48_non_resident_amount() {
		return r48_non_resident_amount;
	}
	public void setR48_non_resident_amount(BigDecimal r48_non_resident_amount) {
		this.r48_non_resident_amount = r48_non_resident_amount;
	}
	public BigDecimal getR48_with1year_amount() {
		return r48_with1year_amount;
	}
	public void setR48_with1year_amount(BigDecimal r48_with1year_amount) {
		this.r48_with1year_amount = r48_with1year_amount;
	}
	public BigDecimal getR48_1to3year_amount() {
		return r48_1to3year_amount;
	}
	public void setR48_1to3year_amount(BigDecimal r48_1to3year_amount) {
		this.r48_1to3year_amount = r48_1to3year_amount;
	}
	public BigDecimal getR48_over3year_amount() {
		return r48_over3year_amount;
	}
	public void setR48_over3year_amount(BigDecimal r48_over3year_amount) {
		this.r48_over3year_amount = r48_over3year_amount;
	}
	public BigDecimal getR48_2_headging_nl() {
		return r48_2_headging_nl;
	}
	public void setR48_2_headging_nl(BigDecimal r48_2_headging_nl) {
		this.r48_2_headging_nl = r48_2_headging_nl;
	}
	public BigDecimal getR48_2_n_headging_nl_() {
		return r48_2_n_headging_nl_;
	}
	public void setR48_2_n_headging_nl_(BigDecimal r48_2_n_headging_nl_) {
		this.r48_2_n_headging_nl_ = r48_2_n_headging_nl_;
	}
	public BigDecimal getR48_2_trading_nl() {
		return r48_2_trading_nl;
	}
	public void setR48_2_trading_nl(BigDecimal r48_2_trading_nl) {
		this.r48_2_trading_nl = r48_2_trading_nl;
	}
	public BigDecimal getR48_2_n_trading_nl_() {
		return r48_2_n_trading_nl_;
	}
	public void setR48_2_n_trading_nl_(BigDecimal r48_2_n_trading_nl_) {
		this.r48_2_n_trading_nl_ = r48_2_n_trading_nl_;
	}
	public String getR49_product() {
		return r49_product;
	}
	public void setR49_product(String r49_product) {
		this.r49_product = r49_product;
	}
	public BigDecimal getR49_hedging_amount() {
		return r49_hedging_amount;
	}
	public void setR49_hedging_amount(BigDecimal r49_hedging_amount) {
		this.r49_hedging_amount = r49_hedging_amount;
	}
	public BigDecimal getR49_trading_amount() {
		return r49_trading_amount;
	}
	public void setR49_trading_amount(BigDecimal r49_trading_amount) {
		this.r49_trading_amount = r49_trading_amount;
	}
	public BigDecimal getR49_resident_amount() {
		return r49_resident_amount;
	}
	public void setR49_resident_amount(BigDecimal r49_resident_amount) {
		this.r49_resident_amount = r49_resident_amount;
	}
	public BigDecimal getR49_non_resident_amount() {
		return r49_non_resident_amount;
	}
	public void setR49_non_resident_amount(BigDecimal r49_non_resident_amount) {
		this.r49_non_resident_amount = r49_non_resident_amount;
	}
	public BigDecimal getR49_with1year_amount() {
		return r49_with1year_amount;
	}
	public void setR49_with1year_amount(BigDecimal r49_with1year_amount) {
		this.r49_with1year_amount = r49_with1year_amount;
	}
	public BigDecimal getR49_1to3year_amount() {
		return r49_1to3year_amount;
	}
	public void setR49_1to3year_amount(BigDecimal r49_1to3year_amount) {
		this.r49_1to3year_amount = r49_1to3year_amount;
	}
	public BigDecimal getR49_over3year_amount() {
		return r49_over3year_amount;
	}
	public void setR49_over3year_amount(BigDecimal r49_over3year_amount) {
		this.r49_over3year_amount = r49_over3year_amount;
	}
	public BigDecimal getR49_2_headging_nl() {
		return r49_2_headging_nl;
	}
	public void setR49_2_headging_nl(BigDecimal r49_2_headging_nl) {
		this.r49_2_headging_nl = r49_2_headging_nl;
	}
	public BigDecimal getR49_2_n_headging_nl_() {
		return r49_2_n_headging_nl_;
	}
	public void setR49_2_n_headging_nl_(BigDecimal r49_2_n_headging_nl_) {
		this.r49_2_n_headging_nl_ = r49_2_n_headging_nl_;
	}
	public BigDecimal getR49_2_trading_nl() {
		return r49_2_trading_nl;
	}
	public void setR49_2_trading_nl(BigDecimal r49_2_trading_nl) {
		this.r49_2_trading_nl = r49_2_trading_nl;
	}
	public BigDecimal getR49_2_n_trading_nl_() {
		return r49_2_n_trading_nl_;
	}
	public void setR49_2_n_trading_nl_(BigDecimal r49_2_n_trading_nl_) {
		this.r49_2_n_trading_nl_ = r49_2_n_trading_nl_;
	}
	public String getR50_product() {
		return r50_product;
	}
	public void setR50_product(String r50_product) {
		this.r50_product = r50_product;
	}
	public BigDecimal getR50_hedging_amount() {
		return r50_hedging_amount;
	}
	public void setR50_hedging_amount(BigDecimal r50_hedging_amount) {
		this.r50_hedging_amount = r50_hedging_amount;
	}
	public BigDecimal getR50_trading_amount() {
		return r50_trading_amount;
	}
	public void setR50_trading_amount(BigDecimal r50_trading_amount) {
		this.r50_trading_amount = r50_trading_amount;
	}
	public BigDecimal getR50_resident_amount() {
		return r50_resident_amount;
	}
	public void setR50_resident_amount(BigDecimal r50_resident_amount) {
		this.r50_resident_amount = r50_resident_amount;
	}
	public BigDecimal getR50_non_resident_amount() {
		return r50_non_resident_amount;
	}
	public void setR50_non_resident_amount(BigDecimal r50_non_resident_amount) {
		this.r50_non_resident_amount = r50_non_resident_amount;
	}
	public BigDecimal getR50_with1year_amount() {
		return r50_with1year_amount;
	}
	public void setR50_with1year_amount(BigDecimal r50_with1year_amount) {
		this.r50_with1year_amount = r50_with1year_amount;
	}
	public BigDecimal getR50_1to3year_amount() {
		return r50_1to3year_amount;
	}
	public void setR50_1to3year_amount(BigDecimal r50_1to3year_amount) {
		this.r50_1to3year_amount = r50_1to3year_amount;
	}
	public BigDecimal getR50_over3year_amount() {
		return r50_over3year_amount;
	}
	public void setR50_over3year_amount(BigDecimal r50_over3year_amount) {
		this.r50_over3year_amount = r50_over3year_amount;
	}
	public BigDecimal getR50_2_headging_nl() {
		return r50_2_headging_nl;
	}
	public void setR50_2_headging_nl(BigDecimal r50_2_headging_nl) {
		this.r50_2_headging_nl = r50_2_headging_nl;
	}
	public BigDecimal getR50_2_n_headging_nl_() {
		return r50_2_n_headging_nl_;
	}
	public void setR50_2_n_headging_nl_(BigDecimal r50_2_n_headging_nl_) {
		this.r50_2_n_headging_nl_ = r50_2_n_headging_nl_;
	}
	public BigDecimal getR50_2_trading_nl() {
		return r50_2_trading_nl;
	}
	public void setR50_2_trading_nl(BigDecimal r50_2_trading_nl) {
		this.r50_2_trading_nl = r50_2_trading_nl;
	}
	public BigDecimal getR50_2_n_trading_nl_() {
		return r50_2_n_trading_nl_;
	}
	public void setR50_2_n_trading_nl_(BigDecimal r50_2_n_trading_nl_) {
		this.r50_2_n_trading_nl_ = r50_2_n_trading_nl_;
	}
	public String getR51_product() {
		return r51_product;
	}
	public void setR51_product(String r51_product) {
		this.r51_product = r51_product;
	}
	public BigDecimal getR51_hedging_amount() {
		return r51_hedging_amount;
	}
	public void setR51_hedging_amount(BigDecimal r51_hedging_amount) {
		this.r51_hedging_amount = r51_hedging_amount;
	}
	public BigDecimal getR51_trading_amount() {
		return r51_trading_amount;
	}
	public void setR51_trading_amount(BigDecimal r51_trading_amount) {
		this.r51_trading_amount = r51_trading_amount;
	}
	public BigDecimal getR51_resident_amount() {
		return r51_resident_amount;
	}
	public void setR51_resident_amount(BigDecimal r51_resident_amount) {
		this.r51_resident_amount = r51_resident_amount;
	}
	public BigDecimal getR51_non_resident_amount() {
		return r51_non_resident_amount;
	}
	public void setR51_non_resident_amount(BigDecimal r51_non_resident_amount) {
		this.r51_non_resident_amount = r51_non_resident_amount;
	}
	public BigDecimal getR51_with1year_amount() {
		return r51_with1year_amount;
	}
	public void setR51_with1year_amount(BigDecimal r51_with1year_amount) {
		this.r51_with1year_amount = r51_with1year_amount;
	}
	public BigDecimal getR51_1to3year_amount() {
		return r51_1to3year_amount;
	}
	public void setR51_1to3year_amount(BigDecimal r51_1to3year_amount) {
		this.r51_1to3year_amount = r51_1to3year_amount;
	}
	public BigDecimal getR51_over3year_amount() {
		return r51_over3year_amount;
	}
	public void setR51_over3year_amount(BigDecimal r51_over3year_amount) {
		this.r51_over3year_amount = r51_over3year_amount;
	}
	public BigDecimal getR51_2_headging_nl() {
		return r51_2_headging_nl;
	}
	public void setR51_2_headging_nl(BigDecimal r51_2_headging_nl) {
		this.r51_2_headging_nl = r51_2_headging_nl;
	}
	public BigDecimal getR51_2_n_headging_nl_() {
		return r51_2_n_headging_nl_;
	}
	public void setR51_2_n_headging_nl_(BigDecimal r51_2_n_headging_nl_) {
		this.r51_2_n_headging_nl_ = r51_2_n_headging_nl_;
	}
	public BigDecimal getR51_2_trading_nl() {
		return r51_2_trading_nl;
	}
	public void setR51_2_trading_nl(BigDecimal r51_2_trading_nl) {
		this.r51_2_trading_nl = r51_2_trading_nl;
	}
	public BigDecimal getR51_2_n_trading_nl_() {
		return r51_2_n_trading_nl_;
	}
	public void setR51_2_n_trading_nl_(BigDecimal r51_2_n_trading_nl_) {
		this.r51_2_n_trading_nl_ = r51_2_n_trading_nl_;
	}
	public String getR52_product() {
		return r52_product;
	}
	public void setR52_product(String r52_product) {
		this.r52_product = r52_product;
	}
	public BigDecimal getR52_hedging_amount() {
		return r52_hedging_amount;
	}
	public void setR52_hedging_amount(BigDecimal r52_hedging_amount) {
		this.r52_hedging_amount = r52_hedging_amount;
	}
	public BigDecimal getR52_trading_amount() {
		return r52_trading_amount;
	}
	public void setR52_trading_amount(BigDecimal r52_trading_amount) {
		this.r52_trading_amount = r52_trading_amount;
	}
	public BigDecimal getR52_resident_amount() {
		return r52_resident_amount;
	}
	public void setR52_resident_amount(BigDecimal r52_resident_amount) {
		this.r52_resident_amount = r52_resident_amount;
	}
	public BigDecimal getR52_non_resident_amount() {
		return r52_non_resident_amount;
	}
	public void setR52_non_resident_amount(BigDecimal r52_non_resident_amount) {
		this.r52_non_resident_amount = r52_non_resident_amount;
	}
	public BigDecimal getR52_with1year_amount() {
		return r52_with1year_amount;
	}
	public void setR52_with1year_amount(BigDecimal r52_with1year_amount) {
		this.r52_with1year_amount = r52_with1year_amount;
	}
	public BigDecimal getR52_1to3year_amount() {
		return r52_1to3year_amount;
	}
	public void setR52_1to3year_amount(BigDecimal r52_1to3year_amount) {
		this.r52_1to3year_amount = r52_1to3year_amount;
	}
	public BigDecimal getR52_over3year_amount() {
		return r52_over3year_amount;
	}
	public void setR52_over3year_amount(BigDecimal r52_over3year_amount) {
		this.r52_over3year_amount = r52_over3year_amount;
	}
	public BigDecimal getR52_10_headging_nl() {
		return r52_10_headging_nl;
	}
	public void setR52_10_headging_nl(BigDecimal r52_10_headging_nl) {
		this.r52_10_headging_nl = r52_10_headging_nl;
	}
	public BigDecimal getR52_10_n_headging_nl_() {
		return r52_10_n_headging_nl_;
	}
	public void setR52_10_n_headging_nl_(BigDecimal r52_10_n_headging_nl_) {
		this.r52_10_n_headging_nl_ = r52_10_n_headging_nl_;
	}
	public BigDecimal getR52_10_trading_nl() {
		return r52_10_trading_nl;
	}
	public void setR52_10_trading_nl(BigDecimal r52_10_trading_nl) {
		this.r52_10_trading_nl = r52_10_trading_nl;
	}
	public BigDecimal getR52_10_n_trading_nl_() {
		return r52_10_n_trading_nl_;
	}
	public void setR52_10_n_trading_nl_(BigDecimal r52_10_n_trading_nl_) {
		this.r52_10_n_trading_nl_ = r52_10_n_trading_nl_;
	}
	public String getR53_product() {
		return r53_product;
	}
	public void setR53_product(String r53_product) {
		this.r53_product = r53_product;
	}
	public BigDecimal getR53_hedging_amount() {
		return r53_hedging_amount;
	}
	public void setR53_hedging_amount(BigDecimal r53_hedging_amount) {
		this.r53_hedging_amount = r53_hedging_amount;
	}
	public BigDecimal getR53_trading_amount() {
		return r53_trading_amount;
	}
	public void setR53_trading_amount(BigDecimal r53_trading_amount) {
		this.r53_trading_amount = r53_trading_amount;
	}
	public BigDecimal getR53_resident_amount() {
		return r53_resident_amount;
	}
	public void setR53_resident_amount(BigDecimal r53_resident_amount) {
		this.r53_resident_amount = r53_resident_amount;
	}
	public BigDecimal getR53_non_resident_amount() {
		return r53_non_resident_amount;
	}
	public void setR53_non_resident_amount(BigDecimal r53_non_resident_amount) {
		this.r53_non_resident_amount = r53_non_resident_amount;
	}
	public BigDecimal getR53_with1year_amount() {
		return r53_with1year_amount;
	}
	public void setR53_with1year_amount(BigDecimal r53_with1year_amount) {
		this.r53_with1year_amount = r53_with1year_amount;
	}
	public BigDecimal getR53_1to3year_amount() {
		return r53_1to3year_amount;
	}
	public void setR53_1to3year_amount(BigDecimal r53_1to3year_amount) {
		this.r53_1to3year_amount = r53_1to3year_amount;
	}
	public BigDecimal getR53_over3year_amount() {
		return r53_over3year_amount;
	}
	public void setR53_over3year_amount(BigDecimal r53_over3year_amount) {
		this.r53_over3year_amount = r53_over3year_amount;
	}
	public BigDecimal getR53_10_headging_nl() {
		return r53_10_headging_nl;
	}
	public void setR53_10_headging_nl(BigDecimal r53_10_headging_nl) {
		this.r53_10_headging_nl = r53_10_headging_nl;
	}
	public BigDecimal getR53_10_n_headging_nl_() {
		return r53_10_n_headging_nl_;
	}
	public void setR53_10_n_headging_nl_(BigDecimal r53_10_n_headging_nl_) {
		this.r53_10_n_headging_nl_ = r53_10_n_headging_nl_;
	}
	public BigDecimal getR53_10_trading_nl() {
		return r53_10_trading_nl;
	}
	public void setR53_10_trading_nl(BigDecimal r53_10_trading_nl) {
		this.r53_10_trading_nl = r53_10_trading_nl;
	}
	public BigDecimal getR53_10_n_trading_nl_() {
		return r53_10_n_trading_nl_;
	}
	public void setR53_10_n_trading_nl_(BigDecimal r53_10_n_trading_nl_) {
		this.r53_10_n_trading_nl_ = r53_10_n_trading_nl_;
	}
	public String getR54_product() {
		return r54_product;
	}
	public void setR54_product(String r54_product) {
		this.r54_product = r54_product;
	}
	public BigDecimal getR54_pro_bou_amount() {
		return r54_pro_bou_amount;
	}
	public void setR54_pro_bou_amount(BigDecimal r54_pro_bou_amount) {
		this.r54_pro_bou_amount = r54_pro_bou_amount;
	}
	public BigDecimal getR54_pro_sold_amount() {
		return r54_pro_sold_amount;
	}
	public void setR54_pro_sold_amount(BigDecimal r54_pro_sold_amount) {
		this.r54_pro_sold_amount = r54_pro_sold_amount;
	}
	public BigDecimal getR54_resident() {
		return r54_resident;
	}
	public void setR54_resident(BigDecimal r54_resident) {
		this.r54_resident = r54_resident;
	}
	public BigDecimal getR54_non_resident() {
		return r54_non_resident;
	}
	public void setR54_non_resident(BigDecimal r54_non_resident) {
		this.r54_non_resident = r54_non_resident;
	}
	public BigDecimal getR54_with1year_amount() {
		return r54_with1year_amount;
	}
	public void setR54_with1year_amount(BigDecimal r54_with1year_amount) {
		this.r54_with1year_amount = r54_with1year_amount;
	}
	public BigDecimal getR54_1to3year_amount() {
		return r54_1to3year_amount;
	}
	public void setR54_1to3year_amount(BigDecimal r54_1to3year_amount) {
		this.r54_1to3year_amount = r54_1to3year_amount;
	}
	public BigDecimal getR54_over3year_amount() {
		return r54_over3year_amount;
	}
	public void setR54_over3year_amount(BigDecimal r54_over3year_amount) {
		this.r54_over3year_amount = r54_over3year_amount;
	}
	public BigDecimal getR54_pro_bou_ngl() {
		return r54_pro_bou_ngl;
	}
	public void setR54_pro_bou_ngl(BigDecimal r54_pro_bou_ngl) {
		this.r54_pro_bou_ngl = r54_pro_bou_ngl;
	}
	public BigDecimal getR54_pro_sold_ngl() {
		return r54_pro_sold_ngl;
	}
	public void setR54_pro_sold_ngl(BigDecimal r54_pro_sold_ngl) {
		this.r54_pro_sold_ngl = r54_pro_sold_ngl;
	}
	public String getR55_product() {
		return r55_product;
	}
	public void setR55_product(String r55_product) {
		this.r55_product = r55_product;
	}
	public BigDecimal getR55_pro_bou_amount() {
		return r55_pro_bou_amount;
	}
	public void setR55_pro_bou_amount(BigDecimal r55_pro_bou_amount) {
		this.r55_pro_bou_amount = r55_pro_bou_amount;
	}
	public BigDecimal getR55_pro_sold_amount() {
		return r55_pro_sold_amount;
	}
	public void setR55_pro_sold_amount(BigDecimal r55_pro_sold_amount) {
		this.r55_pro_sold_amount = r55_pro_sold_amount;
	}
	public BigDecimal getR55_resident() {
		return r55_resident;
	}
	public void setR55_resident(BigDecimal r55_resident) {
		this.r55_resident = r55_resident;
	}
	public BigDecimal getR55_non_resident() {
		return r55_non_resident;
	}
	public void setR55_non_resident(BigDecimal r55_non_resident) {
		this.r55_non_resident = r55_non_resident;
	}
	public BigDecimal getR55_with1year_amount() {
		return r55_with1year_amount;
	}
	public void setR55_with1year_amount(BigDecimal r55_with1year_amount) {
		this.r55_with1year_amount = r55_with1year_amount;
	}
	public BigDecimal getR55_1to3year_amount() {
		return r55_1to3year_amount;
	}
	public void setR55_1to3year_amount(BigDecimal r55_1to3year_amount) {
		this.r55_1to3year_amount = r55_1to3year_amount;
	}
	public BigDecimal getR55_over3year_amount() {
		return r55_over3year_amount;
	}
	public void setR55_over3year_amount(BigDecimal r55_over3year_amount) {
		this.r55_over3year_amount = r55_over3year_amount;
	}
	public BigDecimal getR55_pro_bou_ngl() {
		return r55_pro_bou_ngl;
	}
	public void setR55_pro_bou_ngl(BigDecimal r55_pro_bou_ngl) {
		this.r55_pro_bou_ngl = r55_pro_bou_ngl;
	}
	public BigDecimal getR55_pro_sold_ngl() {
		return r55_pro_sold_ngl;
	}
	public void setR55_pro_sold_ngl(BigDecimal r55_pro_sold_ngl) {
		this.r55_pro_sold_ngl = r55_pro_sold_ngl;
	}
	public String getR56_product() {
		return r56_product;
	}
	public void setR56_product(String r56_product) {
		this.r56_product = r56_product;
	}
	public BigDecimal getR56_pro_bou_amount() {
		return r56_pro_bou_amount;
	}
	public void setR56_pro_bou_amount(BigDecimal r56_pro_bou_amount) {
		this.r56_pro_bou_amount = r56_pro_bou_amount;
	}
	public BigDecimal getR56_pro_sold_amount() {
		return r56_pro_sold_amount;
	}
	public void setR56_pro_sold_amount(BigDecimal r56_pro_sold_amount) {
		this.r56_pro_sold_amount = r56_pro_sold_amount;
	}
	public BigDecimal getR56_resident() {
		return r56_resident;
	}
	public void setR56_resident(BigDecimal r56_resident) {
		this.r56_resident = r56_resident;
	}
	public BigDecimal getR56_non_resident() {
		return r56_non_resident;
	}
	public void setR56_non_resident(BigDecimal r56_non_resident) {
		this.r56_non_resident = r56_non_resident;
	}
	public BigDecimal getR56_with1year_amount() {
		return r56_with1year_amount;
	}
	public void setR56_with1year_amount(BigDecimal r56_with1year_amount) {
		this.r56_with1year_amount = r56_with1year_amount;
	}
	public BigDecimal getR56_1to3year_amount() {
		return r56_1to3year_amount;
	}
	public void setR56_1to3year_amount(BigDecimal r56_1to3year_amount) {
		this.r56_1to3year_amount = r56_1to3year_amount;
	}
	public BigDecimal getR56_over3year_amount() {
		return r56_over3year_amount;
	}
	public void setR56_over3year_amount(BigDecimal r56_over3year_amount) {
		this.r56_over3year_amount = r56_over3year_amount;
	}
	public BigDecimal getR56_pro_bou_ngl() {
		return r56_pro_bou_ngl;
	}
	public void setR56_pro_bou_ngl(BigDecimal r56_pro_bou_ngl) {
		this.r56_pro_bou_ngl = r56_pro_bou_ngl;
	}
	public BigDecimal getR56_pro_sold_ngl() {
		return r56_pro_sold_ngl;
	}
	public void setR56_pro_sold_ngl(BigDecimal r56_pro_sold_ngl) {
		this.r56_pro_sold_ngl = r56_pro_sold_ngl;
	}
	public String getR57_product() {
		return r57_product;
	}
	public void setR57_product(String r57_product) {
		this.r57_product = r57_product;
	}
	public BigDecimal getR57_pro_bou_amount() {
		return r57_pro_bou_amount;
	}
	public void setR57_pro_bou_amount(BigDecimal r57_pro_bou_amount) {
		this.r57_pro_bou_amount = r57_pro_bou_amount;
	}
	public BigDecimal getR57_pro_sold_amount() {
		return r57_pro_sold_amount;
	}
	public void setR57_pro_sold_amount(BigDecimal r57_pro_sold_amount) {
		this.r57_pro_sold_amount = r57_pro_sold_amount;
	}
	public BigDecimal getR57_resident() {
		return r57_resident;
	}
	public void setR57_resident(BigDecimal r57_resident) {
		this.r57_resident = r57_resident;
	}
	public BigDecimal getR57_non_resident() {
		return r57_non_resident;
	}
	public void setR57_non_resident(BigDecimal r57_non_resident) {
		this.r57_non_resident = r57_non_resident;
	}
	public BigDecimal getR57_with1year_amount() {
		return r57_with1year_amount;
	}
	public void setR57_with1year_amount(BigDecimal r57_with1year_amount) {
		this.r57_with1year_amount = r57_with1year_amount;
	}
	public BigDecimal getR57_1to3year_amount() {
		return r57_1to3year_amount;
	}
	public void setR57_1to3year_amount(BigDecimal r57_1to3year_amount) {
		this.r57_1to3year_amount = r57_1to3year_amount;
	}
	public BigDecimal getR57_over3year_amount() {
		return r57_over3year_amount;
	}
	public void setR57_over3year_amount(BigDecimal r57_over3year_amount) {
		this.r57_over3year_amount = r57_over3year_amount;
	}
	public BigDecimal getR57_pro_bou_ngl() {
		return r57_pro_bou_ngl;
	}
	public void setR57_pro_bou_ngl(BigDecimal r57_pro_bou_ngl) {
		this.r57_pro_bou_ngl = r57_pro_bou_ngl;
	}
	public BigDecimal getR57_pro_sold_ngl() {
		return r57_pro_sold_ngl;
	}
	public void setR57_pro_sold_ngl(BigDecimal r57_pro_sold_ngl) {
		this.r57_pro_sold_ngl = r57_pro_sold_ngl;
	}
	public String getR58_product() {
		return r58_product;
	}
	public void setR58_product(String r58_product) {
		this.r58_product = r58_product;
	}
	public BigDecimal getR58_pro_bou_amount() {
		return r58_pro_bou_amount;
	}
	public void setR58_pro_bou_amount(BigDecimal r58_pro_bou_amount) {
		this.r58_pro_bou_amount = r58_pro_bou_amount;
	}
	public BigDecimal getR58_pro_sold_amount() {
		return r58_pro_sold_amount;
	}
	public void setR58_pro_sold_amount(BigDecimal r58_pro_sold_amount) {
		this.r58_pro_sold_amount = r58_pro_sold_amount;
	}
	public BigDecimal getR58_resident() {
		return r58_resident;
	}
	public void setR58_resident(BigDecimal r58_resident) {
		this.r58_resident = r58_resident;
	}
	public BigDecimal getR58_non_resident() {
		return r58_non_resident;
	}
	public void setR58_non_resident(BigDecimal r58_non_resident) {
		this.r58_non_resident = r58_non_resident;
	}
	public BigDecimal getR58_with1year_amount() {
		return r58_with1year_amount;
	}
	public void setR58_with1year_amount(BigDecimal r58_with1year_amount) {
		this.r58_with1year_amount = r58_with1year_amount;
	}
	public BigDecimal getR58_1to3year_amount() {
		return r58_1to3year_amount;
	}
	public void setR58_1to3year_amount(BigDecimal r58_1to3year_amount) {
		this.r58_1to3year_amount = r58_1to3year_amount;
	}
	public BigDecimal getR58_over3year_amount() {
		return r58_over3year_amount;
	}
	public void setR58_over3year_amount(BigDecimal r58_over3year_amount) {
		this.r58_over3year_amount = r58_over3year_amount;
	}
	public BigDecimal getR58_pro_bou_ngl() {
		return r58_pro_bou_ngl;
	}
	public void setR58_pro_bou_ngl(BigDecimal r58_pro_bou_ngl) {
		this.r58_pro_bou_ngl = r58_pro_bou_ngl;
	}
	public BigDecimal getR58_pro_sold_ngl() {
		return r58_pro_sold_ngl;
	}
	public void setR58_pro_sold_ngl(BigDecimal r58_pro_sold_ngl) {
		this.r58_pro_sold_ngl = r58_pro_sold_ngl;
	}
	public String getR59_product() {
		return r59_product;
	}
	public void setR59_product(String r59_product) {
		this.r59_product = r59_product;
	}
	public BigDecimal getR59_pro_bou_amount() {
		return r59_pro_bou_amount;
	}
	public void setR59_pro_bou_amount(BigDecimal r59_pro_bou_amount) {
		this.r59_pro_bou_amount = r59_pro_bou_amount;
	}
	public BigDecimal getR59_pro_sold_amount() {
		return r59_pro_sold_amount;
	}
	public void setR59_pro_sold_amount(BigDecimal r59_pro_sold_amount) {
		this.r59_pro_sold_amount = r59_pro_sold_amount;
	}
	public BigDecimal getR59_resident() {
		return r59_resident;
	}
	public void setR59_resident(BigDecimal r59_resident) {
		this.r59_resident = r59_resident;
	}
	public BigDecimal getR59_non_resident() {
		return r59_non_resident;
	}
	public void setR59_non_resident(BigDecimal r59_non_resident) {
		this.r59_non_resident = r59_non_resident;
	}
	public BigDecimal getR59_with1year_amount() {
		return r59_with1year_amount;
	}
	public void setR59_with1year_amount(BigDecimal r59_with1year_amount) {
		this.r59_with1year_amount = r59_with1year_amount;
	}
	public BigDecimal getR59_1to3year_amount() {
		return r59_1to3year_amount;
	}
	public void setR59_1to3year_amount(BigDecimal r59_1to3year_amount) {
		this.r59_1to3year_amount = r59_1to3year_amount;
	}
	public BigDecimal getR59_over3year_amount() {
		return r59_over3year_amount;
	}
	public void setR59_over3year_amount(BigDecimal r59_over3year_amount) {
		this.r59_over3year_amount = r59_over3year_amount;
	}
	public BigDecimal getR59_pro_bou_ngl() {
		return r59_pro_bou_ngl;
	}
	public void setR59_pro_bou_ngl(BigDecimal r59_pro_bou_ngl) {
		this.r59_pro_bou_ngl = r59_pro_bou_ngl;
	}
	public BigDecimal getR59_pro_sold_ngl() {
		return r59_pro_sold_ngl;
	}
	public void setR59_pro_sold_ngl(BigDecimal r59_pro_sold_ngl) {
		this.r59_pro_sold_ngl = r59_pro_sold_ngl;
	}
	public String getR60_product() {
		return r60_product;
	}
	public void setR60_product(String r60_product) {
		this.r60_product = r60_product;
	}
	public BigDecimal getR60_pro_bou_amount() {
		return r60_pro_bou_amount;
	}
	public void setR60_pro_bou_amount(BigDecimal r60_pro_bou_amount) {
		this.r60_pro_bou_amount = r60_pro_bou_amount;
	}
	public BigDecimal getR60_pro_sold_amount() {
		return r60_pro_sold_amount;
	}
	public void setR60_pro_sold_amount(BigDecimal r60_pro_sold_amount) {
		this.r60_pro_sold_amount = r60_pro_sold_amount;
	}
	public BigDecimal getR60_resident() {
		return r60_resident;
	}
	public void setR60_resident(BigDecimal r60_resident) {
		this.r60_resident = r60_resident;
	}
	public BigDecimal getR60_non_resident() {
		return r60_non_resident;
	}
	public void setR60_non_resident(BigDecimal r60_non_resident) {
		this.r60_non_resident = r60_non_resident;
	}
	public BigDecimal getR60_with1year_amount() {
		return r60_with1year_amount;
	}
	public void setR60_with1year_amount(BigDecimal r60_with1year_amount) {
		this.r60_with1year_amount = r60_with1year_amount;
	}
	public BigDecimal getR60_1to3year_amount() {
		return r60_1to3year_amount;
	}
	public void setR60_1to3year_amount(BigDecimal r60_1to3year_amount) {
		this.r60_1to3year_amount = r60_1to3year_amount;
	}
	public BigDecimal getR60_over3year_amount() {
		return r60_over3year_amount;
	}
	public void setR60_over3year_amount(BigDecimal r60_over3year_amount) {
		this.r60_over3year_amount = r60_over3year_amount;
	}
	public BigDecimal getR60_pro_bou_ngl() {
		return r60_pro_bou_ngl;
	}
	public void setR60_pro_bou_ngl(BigDecimal r60_pro_bou_ngl) {
		this.r60_pro_bou_ngl = r60_pro_bou_ngl;
	}
	public BigDecimal getR60_pro_sold_ngl() {
		return r60_pro_sold_ngl;
	}
	public void setR60_pro_sold_ngl(BigDecimal r60_pro_sold_ngl) {
		this.r60_pro_sold_ngl = r60_pro_sold_ngl;
	}
	public String getR61_product() {
		return r61_product;
	}
	public void setR61_product(String r61_product) {
		this.r61_product = r61_product;
	}
	public BigDecimal getR61_pro_bou_amount() {
		return r61_pro_bou_amount;
	}
	public void setR61_pro_bou_amount(BigDecimal r61_pro_bou_amount) {
		this.r61_pro_bou_amount = r61_pro_bou_amount;
	}
	public BigDecimal getR61_pro_sold_amount() {
		return r61_pro_sold_amount;
	}
	public void setR61_pro_sold_amount(BigDecimal r61_pro_sold_amount) {
		this.r61_pro_sold_amount = r61_pro_sold_amount;
	}
	public BigDecimal getR61_resident() {
		return r61_resident;
	}
	public void setR61_resident(BigDecimal r61_resident) {
		this.r61_resident = r61_resident;
	}
	public BigDecimal getR61_non_resident() {
		return r61_non_resident;
	}
	public void setR61_non_resident(BigDecimal r61_non_resident) {
		this.r61_non_resident = r61_non_resident;
	}
	public BigDecimal getR61_with1year_amount() {
		return r61_with1year_amount;
	}
	public void setR61_with1year_amount(BigDecimal r61_with1year_amount) {
		this.r61_with1year_amount = r61_with1year_amount;
	}
	public BigDecimal getR61_1to3year_amount() {
		return r61_1to3year_amount;
	}
	public void setR61_1to3year_amount(BigDecimal r61_1to3year_amount) {
		this.r61_1to3year_amount = r61_1to3year_amount;
	}
	public BigDecimal getR61_over3year_amount() {
		return r61_over3year_amount;
	}
	public void setR61_over3year_amount(BigDecimal r61_over3year_amount) {
		this.r61_over3year_amount = r61_over3year_amount;
	}
	public BigDecimal getR61_pro_bou_ngl() {
		return r61_pro_bou_ngl;
	}
	public void setR61_pro_bou_ngl(BigDecimal r61_pro_bou_ngl) {
		this.r61_pro_bou_ngl = r61_pro_bou_ngl;
	}
	public BigDecimal getR61_pro_sold_ngl() {
		return r61_pro_sold_ngl;
	}
	public void setR61_pro_sold_ngl(BigDecimal r61_pro_sold_ngl) {
		this.r61_pro_sold_ngl = r61_pro_sold_ngl;
	}
	public String getR62_product() {
		return r62_product;
	}
	public void setR62_product(String r62_product) {
		this.r62_product = r62_product;
	}
	public BigDecimal getR62_pro_bou_amount() {
		return r62_pro_bou_amount;
	}
	public void setR62_pro_bou_amount(BigDecimal r62_pro_bou_amount) {
		this.r62_pro_bou_amount = r62_pro_bou_amount;
	}
	public BigDecimal getR62_pro_sold_amount() {
		return r62_pro_sold_amount;
	}
	public void setR62_pro_sold_amount(BigDecimal r62_pro_sold_amount) {
		this.r62_pro_sold_amount = r62_pro_sold_amount;
	}
	public BigDecimal getR62_resident() {
		return r62_resident;
	}
	public void setR62_resident(BigDecimal r62_resident) {
		this.r62_resident = r62_resident;
	}
	public BigDecimal getR62_non_resident() {
		return r62_non_resident;
	}
	public void setR62_non_resident(BigDecimal r62_non_resident) {
		this.r62_non_resident = r62_non_resident;
	}
	public BigDecimal getR62_with1year_amount() {
		return r62_with1year_amount;
	}
	public void setR62_with1year_amount(BigDecimal r62_with1year_amount) {
		this.r62_with1year_amount = r62_with1year_amount;
	}
	public BigDecimal getR62_1to3year_amount() {
		return r62_1to3year_amount;
	}
	public void setR62_1to3year_amount(BigDecimal r62_1to3year_amount) {
		this.r62_1to3year_amount = r62_1to3year_amount;
	}
	public BigDecimal getR62_over3year_amount() {
		return r62_over3year_amount;
	}
	public void setR62_over3year_amount(BigDecimal r62_over3year_amount) {
		this.r62_over3year_amount = r62_over3year_amount;
	}
	public BigDecimal getR62_pro_bou_ngl() {
		return r62_pro_bou_ngl;
	}
	public void setR62_pro_bou_ngl(BigDecimal r62_pro_bou_ngl) {
		this.r62_pro_bou_ngl = r62_pro_bou_ngl;
	}
	public BigDecimal getR62_pro_sold_ngl() {
		return r62_pro_sold_ngl;
	}
	public void setR62_pro_sold_ngl(BigDecimal r62_pro_sold_ngl) {
		this.r62_pro_sold_ngl = r62_pro_sold_ngl;
	}
	public String getR63_product() {
		return r63_product;
	}
	public void setR63_product(String r63_product) {
		this.r63_product = r63_product;
	}
	public BigDecimal getR63_pro_bou_amount() {
		return r63_pro_bou_amount;
	}
	public void setR63_pro_bou_amount(BigDecimal r63_pro_bou_amount) {
		this.r63_pro_bou_amount = r63_pro_bou_amount;
	}
	public BigDecimal getR63_pro_sold_amount() {
		return r63_pro_sold_amount;
	}
	public void setR63_pro_sold_amount(BigDecimal r63_pro_sold_amount) {
		this.r63_pro_sold_amount = r63_pro_sold_amount;
	}
	public BigDecimal getR63_resident() {
		return r63_resident;
	}
	public void setR63_resident(BigDecimal r63_resident) {
		this.r63_resident = r63_resident;
	}
	public BigDecimal getR63_non_resident() {
		return r63_non_resident;
	}
	public void setR63_non_resident(BigDecimal r63_non_resident) {
		this.r63_non_resident = r63_non_resident;
	}
	public BigDecimal getR63_with1year_amount() {
		return r63_with1year_amount;
	}
	public void setR63_with1year_amount(BigDecimal r63_with1year_amount) {
		this.r63_with1year_amount = r63_with1year_amount;
	}
	public BigDecimal getR63_1to3year_amount() {
		return r63_1to3year_amount;
	}
	public void setR63_1to3year_amount(BigDecimal r63_1to3year_amount) {
		this.r63_1to3year_amount = r63_1to3year_amount;
	}
	public BigDecimal getR63_over3year_amount() {
		return r63_over3year_amount;
	}
	public void setR63_over3year_amount(BigDecimal r63_over3year_amount) {
		this.r63_over3year_amount = r63_over3year_amount;
	}
	public BigDecimal getR63_pro_bou_ngl() {
		return r63_pro_bou_ngl;
	}
	public void setR63_pro_bou_ngl(BigDecimal r63_pro_bou_ngl) {
		this.r63_pro_bou_ngl = r63_pro_bou_ngl;
	}
	public BigDecimal getR63_pro_sold_ngl() {
		return r63_pro_sold_ngl;
	}
	public void setR63_pro_sold_ngl(BigDecimal r63_pro_sold_ngl) {
		this.r63_pro_sold_ngl = r63_pro_sold_ngl;
	}
	public String getR64_product() {
		return r64_product;
	}
	public void setR64_product(String r64_product) {
		this.r64_product = r64_product;
	}
	public BigDecimal getR64_pro_bou_amount() {
		return r64_pro_bou_amount;
	}
	public void setR64_pro_bou_amount(BigDecimal r64_pro_bou_amount) {
		this.r64_pro_bou_amount = r64_pro_bou_amount;
	}
	public BigDecimal getR64_pro_sold_amount() {
		return r64_pro_sold_amount;
	}
	public void setR64_pro_sold_amount(BigDecimal r64_pro_sold_amount) {
		this.r64_pro_sold_amount = r64_pro_sold_amount;
	}
	public BigDecimal getR64_resident() {
		return r64_resident;
	}
	public void setR64_resident(BigDecimal r64_resident) {
		this.r64_resident = r64_resident;
	}
	public BigDecimal getR64_non_resident() {
		return r64_non_resident;
	}
	public void setR64_non_resident(BigDecimal r64_non_resident) {
		this.r64_non_resident = r64_non_resident;
	}
	public BigDecimal getR64_with1year_amount() {
		return r64_with1year_amount;
	}
	public void setR64_with1year_amount(BigDecimal r64_with1year_amount) {
		this.r64_with1year_amount = r64_with1year_amount;
	}
	public BigDecimal getR64_1to3year_amount() {
		return r64_1to3year_amount;
	}
	public void setR64_1to3year_amount(BigDecimal r64_1to3year_amount) {
		this.r64_1to3year_amount = r64_1to3year_amount;
	}
	public BigDecimal getR64_over3year_amount() {
		return r64_over3year_amount;
	}
	public void setR64_over3year_amount(BigDecimal r64_over3year_amount) {
		this.r64_over3year_amount = r64_over3year_amount;
	}
	public BigDecimal getR64_pro_bou_ngl() {
		return r64_pro_bou_ngl;
	}
	public void setR64_pro_bou_ngl(BigDecimal r64_pro_bou_ngl) {
		this.r64_pro_bou_ngl = r64_pro_bou_ngl;
	}
	public BigDecimal getR64_pro_sold_ngl() {
		return r64_pro_sold_ngl;
	}
	public void setR64_pro_sold_ngl(BigDecimal r64_pro_sold_ngl) {
		this.r64_pro_sold_ngl = r64_pro_sold_ngl;
	}
	public String getR65_product() {
		return r65_product;
	}
	public void setR65_product(String r65_product) {
		this.r65_product = r65_product;
	}
	public BigDecimal getR65_pro_bou_amount() {
		return r65_pro_bou_amount;
	}
	public void setR65_pro_bou_amount(BigDecimal r65_pro_bou_amount) {
		this.r65_pro_bou_amount = r65_pro_bou_amount;
	}
	public BigDecimal getR65_pro_sold_amount() {
		return r65_pro_sold_amount;
	}
	public void setR65_pro_sold_amount(BigDecimal r65_pro_sold_amount) {
		this.r65_pro_sold_amount = r65_pro_sold_amount;
	}
	public BigDecimal getR65_resident() {
		return r65_resident;
	}
	public void setR65_resident(BigDecimal r65_resident) {
		this.r65_resident = r65_resident;
	}
	public BigDecimal getR65_non_resident() {
		return r65_non_resident;
	}
	public void setR65_non_resident(BigDecimal r65_non_resident) {
		this.r65_non_resident = r65_non_resident;
	}
	public BigDecimal getR65_with1year_amount() {
		return r65_with1year_amount;
	}
	public void setR65_with1year_amount(BigDecimal r65_with1year_amount) {
		this.r65_with1year_amount = r65_with1year_amount;
	}
	public BigDecimal getR65_1to3year_amount() {
		return r65_1to3year_amount;
	}
	public void setR65_1to3year_amount(BigDecimal r65_1to3year_amount) {
		this.r65_1to3year_amount = r65_1to3year_amount;
	}
	public BigDecimal getR65_over3year_amount() {
		return r65_over3year_amount;
	}
	public void setR65_over3year_amount(BigDecimal r65_over3year_amount) {
		this.r65_over3year_amount = r65_over3year_amount;
	}
	public BigDecimal getR65_pro_bou_ngl() {
		return r65_pro_bou_ngl;
	}
	public void setR65_pro_bou_ngl(BigDecimal r65_pro_bou_ngl) {
		this.r65_pro_bou_ngl = r65_pro_bou_ngl;
	}
	public BigDecimal getR65_pro_sold_ngl() {
		return r65_pro_sold_ngl;
	}
	public void setR65_pro_sold_ngl(BigDecimal r65_pro_sold_ngl) {
		this.r65_pro_sold_ngl = r65_pro_sold_ngl;
	}
	public String getR66_product() {
		return r66_product;
	}
	public void setR66_product(String r66_product) {
		this.r66_product = r66_product;
	}
	public BigDecimal getR66_pro_bou_amount() {
		return r66_pro_bou_amount;
	}
	public void setR66_pro_bou_amount(BigDecimal r66_pro_bou_amount) {
		this.r66_pro_bou_amount = r66_pro_bou_amount;
	}
	public BigDecimal getR66_pro_sold_amount() {
		return r66_pro_sold_amount;
	}
	public void setR66_pro_sold_amount(BigDecimal r66_pro_sold_amount) {
		this.r66_pro_sold_amount = r66_pro_sold_amount;
	}
	public BigDecimal getR66_resident() {
		return r66_resident;
	}
	public void setR66_resident(BigDecimal r66_resident) {
		this.r66_resident = r66_resident;
	}
	public BigDecimal getR66_non_resident() {
		return r66_non_resident;
	}
	public void setR66_non_resident(BigDecimal r66_non_resident) {
		this.r66_non_resident = r66_non_resident;
	}
	public BigDecimal getR66_with1year_amount() {
		return r66_with1year_amount;
	}
	public void setR66_with1year_amount(BigDecimal r66_with1year_amount) {
		this.r66_with1year_amount = r66_with1year_amount;
	}
	public BigDecimal getR66_1to3year_amount() {
		return r66_1to3year_amount;
	}
	public void setR66_1to3year_amount(BigDecimal r66_1to3year_amount) {
		this.r66_1to3year_amount = r66_1to3year_amount;
	}
	public BigDecimal getR66_over3year_amount() {
		return r66_over3year_amount;
	}
	public void setR66_over3year_amount(BigDecimal r66_over3year_amount) {
		this.r66_over3year_amount = r66_over3year_amount;
	}
	public BigDecimal getR66_pro_bou_ngl() {
		return r66_pro_bou_ngl;
	}
	public void setR66_pro_bou_ngl(BigDecimal r66_pro_bou_ngl) {
		this.r66_pro_bou_ngl = r66_pro_bou_ngl;
	}
	public BigDecimal getR66_pro_sold_ngl() {
		return r66_pro_sold_ngl;
	}
	public void setR66_pro_sold_ngl(BigDecimal r66_pro_sold_ngl) {
		this.r66_pro_sold_ngl = r66_pro_sold_ngl;
	}
	public String getR67_product() {
		return r67_product;
	}
	public void setR67_product(String r67_product) {
		this.r67_product = r67_product;
	}
	public BigDecimal getR67_pro_bou_amount() {
		return r67_pro_bou_amount;
	}
	public void setR67_pro_bou_amount(BigDecimal r67_pro_bou_amount) {
		this.r67_pro_bou_amount = r67_pro_bou_amount;
	}
	public BigDecimal getR67_pro_sold_amount() {
		return r67_pro_sold_amount;
	}
	public void setR67_pro_sold_amount(BigDecimal r67_pro_sold_amount) {
		this.r67_pro_sold_amount = r67_pro_sold_amount;
	}
	public BigDecimal getR67_resident() {
		return r67_resident;
	}
	public void setR67_resident(BigDecimal r67_resident) {
		this.r67_resident = r67_resident;
	}
	public BigDecimal getR67_non_resident() {
		return r67_non_resident;
	}
	public void setR67_non_resident(BigDecimal r67_non_resident) {
		this.r67_non_resident = r67_non_resident;
	}
	public BigDecimal getR67_with1year_amount() {
		return r67_with1year_amount;
	}
	public void setR67_with1year_amount(BigDecimal r67_with1year_amount) {
		this.r67_with1year_amount = r67_with1year_amount;
	}
	public BigDecimal getR67_1to3year_amount() {
		return r67_1to3year_amount;
	}
	public void setR67_1to3year_amount(BigDecimal r67_1to3year_amount) {
		this.r67_1to3year_amount = r67_1to3year_amount;
	}
	public BigDecimal getR67_over3year_amount() {
		return r67_over3year_amount;
	}
	public void setR67_over3year_amount(BigDecimal r67_over3year_amount) {
		this.r67_over3year_amount = r67_over3year_amount;
	}
	public BigDecimal getR67_pro_bou_ngl() {
		return r67_pro_bou_ngl;
	}
	public void setR67_pro_bou_ngl(BigDecimal r67_pro_bou_ngl) {
		this.r67_pro_bou_ngl = r67_pro_bou_ngl;
	}
	public BigDecimal getR67_pro_sold_ngl() {
		return r67_pro_sold_ngl;
	}
	public void setR67_pro_sold_ngl(BigDecimal r67_pro_sold_ngl) {
		this.r67_pro_sold_ngl = r67_pro_sold_ngl;
	}
	public String getR68_product() {
		return r68_product;
	}
	public void setR68_product(String r68_product) {
		this.r68_product = r68_product;
	}
	public BigDecimal getR68_pro_bou_amount() {
		return r68_pro_bou_amount;
	}
	public void setR68_pro_bou_amount(BigDecimal r68_pro_bou_amount) {
		this.r68_pro_bou_amount = r68_pro_bou_amount;
	}
	public BigDecimal getR68_pro_sold_amount() {
		return r68_pro_sold_amount;
	}
	public void setR68_pro_sold_amount(BigDecimal r68_pro_sold_amount) {
		this.r68_pro_sold_amount = r68_pro_sold_amount;
	}
	public BigDecimal getR68_resident() {
		return r68_resident;
	}
	public void setR68_resident(BigDecimal r68_resident) {
		this.r68_resident = r68_resident;
	}
	public BigDecimal getR68_non_resident() {
		return r68_non_resident;
	}
	public void setR68_non_resident(BigDecimal r68_non_resident) {
		this.r68_non_resident = r68_non_resident;
	}
	public BigDecimal getR68_with1year_amount() {
		return r68_with1year_amount;
	}
	public void setR68_with1year_amount(BigDecimal r68_with1year_amount) {
		this.r68_with1year_amount = r68_with1year_amount;
	}
	public BigDecimal getR68_1to3year_amount() {
		return r68_1to3year_amount;
	}
	public void setR68_1to3year_amount(BigDecimal r68_1to3year_amount) {
		this.r68_1to3year_amount = r68_1to3year_amount;
	}
	public BigDecimal getR68_over3year_amount() {
		return r68_over3year_amount;
	}
	public void setR68_over3year_amount(BigDecimal r68_over3year_amount) {
		this.r68_over3year_amount = r68_over3year_amount;
	}
	public BigDecimal getR68_pro_bou_ngl() {
		return r68_pro_bou_ngl;
	}
	public void setR68_pro_bou_ngl(BigDecimal r68_pro_bou_ngl) {
		this.r68_pro_bou_ngl = r68_pro_bou_ngl;
	}
	public BigDecimal getR68_pro_sold_ngl() {
		return r68_pro_sold_ngl;
	}
	public void setR68_pro_sold_ngl(BigDecimal r68_pro_sold_ngl) {
		this.r68_pro_sold_ngl = r68_pro_sold_ngl;
	}
	public String getR69_product() {
		return r69_product;
	}
	public void setR69_product(String r69_product) {
		this.r69_product = r69_product;
	}
	public BigDecimal getR69_pro_bou_amount() {
		return r69_pro_bou_amount;
	}
	public void setR69_pro_bou_amount(BigDecimal r69_pro_bou_amount) {
		this.r69_pro_bou_amount = r69_pro_bou_amount;
	}
	public BigDecimal getR69_pro_sold_amount() {
		return r69_pro_sold_amount;
	}
	public void setR69_pro_sold_amount(BigDecimal r69_pro_sold_amount) {
		this.r69_pro_sold_amount = r69_pro_sold_amount;
	}
	public BigDecimal getR69_resident() {
		return r69_resident;
	}
	public void setR69_resident(BigDecimal r69_resident) {
		this.r69_resident = r69_resident;
	}
	public BigDecimal getR69_non_resident() {
		return r69_non_resident;
	}
	public void setR69_non_resident(BigDecimal r69_non_resident) {
		this.r69_non_resident = r69_non_resident;
	}
	public BigDecimal getR69_with1year_amount() {
		return r69_with1year_amount;
	}
	public void setR69_with1year_amount(BigDecimal r69_with1year_amount) {
		this.r69_with1year_amount = r69_with1year_amount;
	}
	public BigDecimal getR69_1to3year_amount() {
		return r69_1to3year_amount;
	}
	public void setR69_1to3year_amount(BigDecimal r69_1to3year_amount) {
		this.r69_1to3year_amount = r69_1to3year_amount;
	}
	public BigDecimal getR69_over3year_amount() {
		return r69_over3year_amount;
	}
	public void setR69_over3year_amount(BigDecimal r69_over3year_amount) {
		this.r69_over3year_amount = r69_over3year_amount;
	}
	public BigDecimal getR69_pro_bou_ngl() {
		return r69_pro_bou_ngl;
	}
	public void setR69_pro_bou_ngl(BigDecimal r69_pro_bou_ngl) {
		this.r69_pro_bou_ngl = r69_pro_bou_ngl;
	}
	public BigDecimal getR69_pro_sold_ngl() {
		return r69_pro_sold_ngl;
	}
	public void setR69_pro_sold_ngl(BigDecimal r69_pro_sold_ngl) {
		this.r69_pro_sold_ngl = r69_pro_sold_ngl;
	}
	public String getR70_product() {
		return r70_product;
	}
	public void setR70_product(String r70_product) {
		this.r70_product = r70_product;
	}
	public BigDecimal getR70_pro_bou_amount() {
		return r70_pro_bou_amount;
	}
	public void setR70_pro_bou_amount(BigDecimal r70_pro_bou_amount) {
		this.r70_pro_bou_amount = r70_pro_bou_amount;
	}
	public BigDecimal getR70_pro_sold_amount() {
		return r70_pro_sold_amount;
	}
	public void setR70_pro_sold_amount(BigDecimal r70_pro_sold_amount) {
		this.r70_pro_sold_amount = r70_pro_sold_amount;
	}
	public BigDecimal getR70_resident() {
		return r70_resident;
	}
	public void setR70_resident(BigDecimal r70_resident) {
		this.r70_resident = r70_resident;
	}
	public BigDecimal getR70_non_resident() {
		return r70_non_resident;
	}
	public void setR70_non_resident(BigDecimal r70_non_resident) {
		this.r70_non_resident = r70_non_resident;
	}
	public BigDecimal getR70_with1year_amount() {
		return r70_with1year_amount;
	}
	public void setR70_with1year_amount(BigDecimal r70_with1year_amount) {
		this.r70_with1year_amount = r70_with1year_amount;
	}
	public BigDecimal getR70_1to3year_amount() {
		return r70_1to3year_amount;
	}
	public void setR70_1to3year_amount(BigDecimal r70_1to3year_amount) {
		this.r70_1to3year_amount = r70_1to3year_amount;
	}
	public BigDecimal getR70_over3year_amount() {
		return r70_over3year_amount;
	}
	public void setR70_over3year_amount(BigDecimal r70_over3year_amount) {
		this.r70_over3year_amount = r70_over3year_amount;
	}
	public BigDecimal getR70_pro_bou_ngl() {
		return r70_pro_bou_ngl;
	}
	public void setR70_pro_bou_ngl(BigDecimal r70_pro_bou_ngl) {
		this.r70_pro_bou_ngl = r70_pro_bou_ngl;
	}
	public BigDecimal getR70_pro_sold_ngl() {
		return r70_pro_sold_ngl;
	}
	public void setR70_pro_sold_ngl(BigDecimal r70_pro_sold_ngl) {
		this.r70_pro_sold_ngl = r70_pro_sold_ngl;
	}
	public String getR71_product() {
		return r71_product;
	}
	public void setR71_product(String r71_product) {
		this.r71_product = r71_product;
	}
	public BigDecimal getR71_pro_bou_amount() {
		return r71_pro_bou_amount;
	}
	public void setR71_pro_bou_amount(BigDecimal r71_pro_bou_amount) {
		this.r71_pro_bou_amount = r71_pro_bou_amount;
	}
	public BigDecimal getR71_pro_sold_amount() {
		return r71_pro_sold_amount;
	}
	public void setR71_pro_sold_amount(BigDecimal r71_pro_sold_amount) {
		this.r71_pro_sold_amount = r71_pro_sold_amount;
	}
	public BigDecimal getR71_resident() {
		return r71_resident;
	}
	public void setR71_resident(BigDecimal r71_resident) {
		this.r71_resident = r71_resident;
	}
	public BigDecimal getR71_non_resident() {
		return r71_non_resident;
	}
	public void setR71_non_resident(BigDecimal r71_non_resident) {
		this.r71_non_resident = r71_non_resident;
	}
	public BigDecimal getR71_with1year_amount() {
		return r71_with1year_amount;
	}
	public void setR71_with1year_amount(BigDecimal r71_with1year_amount) {
		this.r71_with1year_amount = r71_with1year_amount;
	}
	public BigDecimal getR71_1to3year_amount() {
		return r71_1to3year_amount;
	}
	public void setR71_1to3year_amount(BigDecimal r71_1to3year_amount) {
		this.r71_1to3year_amount = r71_1to3year_amount;
	}
	public BigDecimal getR71_over3year_amount() {
		return r71_over3year_amount;
	}
	public void setR71_over3year_amount(BigDecimal r71_over3year_amount) {
		this.r71_over3year_amount = r71_over3year_amount;
	}
	public BigDecimal getR71_pro_bou_ngl() {
		return r71_pro_bou_ngl;
	}
	public void setR71_pro_bou_ngl(BigDecimal r71_pro_bou_ngl) {
		this.r71_pro_bou_ngl = r71_pro_bou_ngl;
	}
	public BigDecimal getR71_pro_sold_ngl() {
		return r71_pro_sold_ngl;
	}
	public void setR71_pro_sold_ngl(BigDecimal r71_pro_sold_ngl) {
		this.r71_pro_sold_ngl = r71_pro_sold_ngl;
	}
	public String getR72_product() {
		return r72_product;
	}
	public void setR72_product(String r72_product) {
		this.r72_product = r72_product;
	}
	public BigDecimal getR72_pro_bou_amount() {
		return r72_pro_bou_amount;
	}
	public void setR72_pro_bou_amount(BigDecimal r72_pro_bou_amount) {
		this.r72_pro_bou_amount = r72_pro_bou_amount;
	}
	public BigDecimal getR72_pro_sold_amount() {
		return r72_pro_sold_amount;
	}
	public void setR72_pro_sold_amount(BigDecimal r72_pro_sold_amount) {
		this.r72_pro_sold_amount = r72_pro_sold_amount;
	}
	public BigDecimal getR72_resident() {
		return r72_resident;
	}
	public void setR72_resident(BigDecimal r72_resident) {
		this.r72_resident = r72_resident;
	}
	public BigDecimal getR72_non_resident() {
		return r72_non_resident;
	}
	public void setR72_non_resident(BigDecimal r72_non_resident) {
		this.r72_non_resident = r72_non_resident;
	}
	public BigDecimal getR72_with1year_amount() {
		return r72_with1year_amount;
	}
	public void setR72_with1year_amount(BigDecimal r72_with1year_amount) {
		this.r72_with1year_amount = r72_with1year_amount;
	}
	public BigDecimal getR72_1to3year_amount() {
		return r72_1to3year_amount;
	}
	public void setR72_1to3year_amount(BigDecimal r72_1to3year_amount) {
		this.r72_1to3year_amount = r72_1to3year_amount;
	}
	public BigDecimal getR72_over3year_amount() {
		return r72_over3year_amount;
	}
	public void setR72_over3year_amount(BigDecimal r72_over3year_amount) {
		this.r72_over3year_amount = r72_over3year_amount;
	}
	public BigDecimal getR72_pro_bou_ngl() {
		return r72_pro_bou_ngl;
	}
	public void setR72_pro_bou_ngl(BigDecimal r72_pro_bou_ngl) {
		this.r72_pro_bou_ngl = r72_pro_bou_ngl;
	}
	public BigDecimal getR72_pro_sold_ngl() {
		return r72_pro_sold_ngl;
	}
	public void setR72_pro_sold_ngl(BigDecimal r72_pro_sold_ngl) {
		this.r72_pro_sold_ngl = r72_pro_sold_ngl;
	}
	public String getR73_product() {
		return r73_product;
	}
	public void setR73_product(String r73_product) {
		this.r73_product = r73_product;
	}
	public BigDecimal getR73_pro_bou_amount() {
		return r73_pro_bou_amount;
	}
	public void setR73_pro_bou_amount(BigDecimal r73_pro_bou_amount) {
		this.r73_pro_bou_amount = r73_pro_bou_amount;
	}
	public BigDecimal getR73_pro_sold_amount() {
		return r73_pro_sold_amount;
	}
	public void setR73_pro_sold_amount(BigDecimal r73_pro_sold_amount) {
		this.r73_pro_sold_amount = r73_pro_sold_amount;
	}
	public BigDecimal getR73_resident() {
		return r73_resident;
	}
	public void setR73_resident(BigDecimal r73_resident) {
		this.r73_resident = r73_resident;
	}
	public BigDecimal getR73_non_resident() {
		return r73_non_resident;
	}
	public void setR73_non_resident(BigDecimal r73_non_resident) {
		this.r73_non_resident = r73_non_resident;
	}
	public BigDecimal getR73_with1year_amount() {
		return r73_with1year_amount;
	}
	public void setR73_with1year_amount(BigDecimal r73_with1year_amount) {
		this.r73_with1year_amount = r73_with1year_amount;
	}
	public BigDecimal getR73_1to3year_amount() {
		return r73_1to3year_amount;
	}
	public void setR73_1to3year_amount(BigDecimal r73_1to3year_amount) {
		this.r73_1to3year_amount = r73_1to3year_amount;
	}
	public BigDecimal getR73_over3year_amount() {
		return r73_over3year_amount;
	}
	public void setR73_over3year_amount(BigDecimal r73_over3year_amount) {
		this.r73_over3year_amount = r73_over3year_amount;
	}
	public BigDecimal getR73_pro_bou_ngl() {
		return r73_pro_bou_ngl;
	}
	public void setR73_pro_bou_ngl(BigDecimal r73_pro_bou_ngl) {
		this.r73_pro_bou_ngl = r73_pro_bou_ngl;
	}
	public BigDecimal getR73_pro_sold_ngl() {
		return r73_pro_sold_ngl;
	}
	public void setR73_pro_sold_ngl(BigDecimal r73_pro_sold_ngl) {
		this.r73_pro_sold_ngl = r73_pro_sold_ngl;
	}
	public String getR74_product() {
		return r74_product;
	}
	public void setR74_product(String r74_product) {
		this.r74_product = r74_product;
	}
	public BigDecimal getR74_hedging_amount() {
		return r74_hedging_amount;
	}
	public void setR74_hedging_amount(BigDecimal r74_hedging_amount) {
		this.r74_hedging_amount = r74_hedging_amount;
	}
	public BigDecimal getR74_trading_amount() {
		return r74_trading_amount;
	}
	public void setR74_trading_amount(BigDecimal r74_trading_amount) {
		this.r74_trading_amount = r74_trading_amount;
	}
	public BigDecimal getR74_resident_amount() {
		return r74_resident_amount;
	}
	public void setR74_resident_amount(BigDecimal r74_resident_amount) {
		this.r74_resident_amount = r74_resident_amount;
	}
	public BigDecimal getR74_non_resident_amount() {
		return r74_non_resident_amount;
	}
	public void setR74_non_resident_amount(BigDecimal r74_non_resident_amount) {
		this.r74_non_resident_amount = r74_non_resident_amount;
	}
	public BigDecimal getR74_with1year_amount() {
		return r74_with1year_amount;
	}
	public void setR74_with1year_amount(BigDecimal r74_with1year_amount) {
		this.r74_with1year_amount = r74_with1year_amount;
	}
	public BigDecimal getR74_1to3year_amount() {
		return r74_1to3year_amount;
	}
	public void setR74_1to3year_amount(BigDecimal r74_1to3year_amount) {
		this.r74_1to3year_amount = r74_1to3year_amount;
	}
	public BigDecimal getR74_over3year_amount() {
		return r74_over3year_amount;
	}
	public void setR74_over3year_amount(BigDecimal r74_over3year_amount) {
		this.r74_over3year_amount = r74_over3year_amount;
	}
	public BigDecimal getR74_10_headging_nl() {
		return r74_10_headging_nl;
	}
	public void setR74_10_headging_nl(BigDecimal r74_10_headging_nl) {
		this.r74_10_headging_nl = r74_10_headging_nl;
	}
	public BigDecimal getR74_10_n_headging_nl_() {
		return r74_10_n_headging_nl_;
	}
	public void setR74_10_n_headging_nl_(BigDecimal r74_10_n_headging_nl_) {
		this.r74_10_n_headging_nl_ = r74_10_n_headging_nl_;
	}
	public BigDecimal getR74_10_trading_nl() {
		return r74_10_trading_nl;
	}
	public void setR74_10_trading_nl(BigDecimal r74_10_trading_nl) {
		this.r74_10_trading_nl = r74_10_trading_nl;
	}
	public BigDecimal getR74_10_n_trading_nl_() {
		return r74_10_n_trading_nl_;
	}
	public void setR74_10_n_trading_nl_(BigDecimal r74_10_n_trading_nl_) {
		this.r74_10_n_trading_nl_ = r74_10_n_trading_nl_;
	}
	public String getR75_product() {
		return r75_product;
	}
	public void setR75_product(String r75_product) {
		this.r75_product = r75_product;
	}
	public BigDecimal getR75_hedging_amount() {
		return r75_hedging_amount;
	}
	public void setR75_hedging_amount(BigDecimal r75_hedging_amount) {
		this.r75_hedging_amount = r75_hedging_amount;
	}
	public BigDecimal getR75_trading_amount() {
		return r75_trading_amount;
	}
	public void setR75_trading_amount(BigDecimal r75_trading_amount) {
		this.r75_trading_amount = r75_trading_amount;
	}
	public BigDecimal getR75_resident_amount() {
		return r75_resident_amount;
	}
	public void setR75_resident_amount(BigDecimal r75_resident_amount) {
		this.r75_resident_amount = r75_resident_amount;
	}
	public BigDecimal getR75_non_resident_amount() {
		return r75_non_resident_amount;
	}
	public void setR75_non_resident_amount(BigDecimal r75_non_resident_amount) {
		this.r75_non_resident_amount = r75_non_resident_amount;
	}
	public BigDecimal getR75_with1year_amount() {
		return r75_with1year_amount;
	}
	public void setR75_with1year_amount(BigDecimal r75_with1year_amount) {
		this.r75_with1year_amount = r75_with1year_amount;
	}
	public BigDecimal getR75_1to3year_amount() {
		return r75_1to3year_amount;
	}
	public void setR75_1to3year_amount(BigDecimal r75_1to3year_amount) {
		this.r75_1to3year_amount = r75_1to3year_amount;
	}
	public BigDecimal getR75_over3year_amount() {
		return r75_over3year_amount;
	}
	public void setR75_over3year_amount(BigDecimal r75_over3year_amount) {
		this.r75_over3year_amount = r75_over3year_amount;
	}
	public BigDecimal getR75_10_headging_nl() {
		return r75_10_headging_nl;
	}
	public void setR75_10_headging_nl(BigDecimal r75_10_headging_nl) {
		this.r75_10_headging_nl = r75_10_headging_nl;
	}
	public BigDecimal getR75_10_n_headging_nl_() {
		return r75_10_n_headging_nl_;
	}
	public void setR75_10_n_headging_nl_(BigDecimal r75_10_n_headging_nl_) {
		this.r75_10_n_headging_nl_ = r75_10_n_headging_nl_;
	}
	public BigDecimal getR75_10_trading_nl() {
		return r75_10_trading_nl;
	}
	public void setR75_10_trading_nl(BigDecimal r75_10_trading_nl) {
		this.r75_10_trading_nl = r75_10_trading_nl;
	}
	public BigDecimal getR75_10_n_trading_nl_() {
		return r75_10_n_trading_nl_;
	}
	public void setR75_10_n_trading_nl_(BigDecimal r75_10_n_trading_nl_) {
		this.r75_10_n_trading_nl_ = r75_10_n_trading_nl_;
	}
	public String getR76_product() {
		return r76_product;
	}
	public void setR76_product(String r76_product) {
		this.r76_product = r76_product;
	}
	public BigDecimal getR76_hedging_amount() {
		return r76_hedging_amount;
	}
	public void setR76_hedging_amount(BigDecimal r76_hedging_amount) {
		this.r76_hedging_amount = r76_hedging_amount;
	}
	public BigDecimal getR76_trading_amount() {
		return r76_trading_amount;
	}
	public void setR76_trading_amount(BigDecimal r76_trading_amount) {
		this.r76_trading_amount = r76_trading_amount;
	}
	public BigDecimal getR76_resident_amount() {
		return r76_resident_amount;
	}
	public void setR76_resident_amount(BigDecimal r76_resident_amount) {
		this.r76_resident_amount = r76_resident_amount;
	}
	public BigDecimal getR76_non_resident_amount() {
		return r76_non_resident_amount;
	}
	public void setR76_non_resident_amount(BigDecimal r76_non_resident_amount) {
		this.r76_non_resident_amount = r76_non_resident_amount;
	}
	public BigDecimal getR76_with1year_amount() {
		return r76_with1year_amount;
	}
	public void setR76_with1year_amount(BigDecimal r76_with1year_amount) {
		this.r76_with1year_amount = r76_with1year_amount;
	}
	public BigDecimal getR76_1to3year_amount() {
		return r76_1to3year_amount;
	}
	public void setR76_1to3year_amount(BigDecimal r76_1to3year_amount) {
		this.r76_1to3year_amount = r76_1to3year_amount;
	}
	public BigDecimal getR76_over3year_amount() {
		return r76_over3year_amount;
	}
	public void setR76_over3year_amount(BigDecimal r76_over3year_amount) {
		this.r76_over3year_amount = r76_over3year_amount;
	}
	public BigDecimal getR76_10_headging_nl() {
		return r76_10_headging_nl;
	}
	public void setR76_10_headging_nl(BigDecimal r76_10_headging_nl) {
		this.r76_10_headging_nl = r76_10_headging_nl;
	}
	public BigDecimal getR76_10_n_headging_nl_() {
		return r76_10_n_headging_nl_;
	}
	public void setR76_10_n_headging_nl_(BigDecimal r76_10_n_headging_nl_) {
		this.r76_10_n_headging_nl_ = r76_10_n_headging_nl_;
	}
	public BigDecimal getR76_10_trading_nl() {
		return r76_10_trading_nl;
	}
	public void setR76_10_trading_nl(BigDecimal r76_10_trading_nl) {
		this.r76_10_trading_nl = r76_10_trading_nl;
	}
	public BigDecimal getR76_10_n_trading_nl_() {
		return r76_10_n_trading_nl_;
	}
	public void setR76_10_n_trading_nl_(BigDecimal r76_10_n_trading_nl_) {
		this.r76_10_n_trading_nl_ = r76_10_n_trading_nl_;
	}
	public String getR77_product() {
		return r77_product;
	}
	public void setR77_product(String r77_product) {
		this.r77_product = r77_product;
	}
	public BigDecimal getR77_hedging_amount() {
		return r77_hedging_amount;
	}
	public void setR77_hedging_amount(BigDecimal r77_hedging_amount) {
		this.r77_hedging_amount = r77_hedging_amount;
	}
	public BigDecimal getR77_trading_amount() {
		return r77_trading_amount;
	}
	public void setR77_trading_amount(BigDecimal r77_trading_amount) {
		this.r77_trading_amount = r77_trading_amount;
	}
	public BigDecimal getR77_resident_amount() {
		return r77_resident_amount;
	}
	public void setR77_resident_amount(BigDecimal r77_resident_amount) {
		this.r77_resident_amount = r77_resident_amount;
	}
	public BigDecimal getR77_non_resident_amount() {
		return r77_non_resident_amount;
	}
	public void setR77_non_resident_amount(BigDecimal r77_non_resident_amount) {
		this.r77_non_resident_amount = r77_non_resident_amount;
	}
	public BigDecimal getR77_with1year_amount() {
		return r77_with1year_amount;
	}
	public void setR77_with1year_amount(BigDecimal r77_with1year_amount) {
		this.r77_with1year_amount = r77_with1year_amount;
	}
	public BigDecimal getR77_1to3year_amount() {
		return r77_1to3year_amount;
	}
	public void setR77_1to3year_amount(BigDecimal r77_1to3year_amount) {
		this.r77_1to3year_amount = r77_1to3year_amount;
	}
	public BigDecimal getR77_over3year_amount() {
		return r77_over3year_amount;
	}
	public void setR77_over3year_amount(BigDecimal r77_over3year_amount) {
		this.r77_over3year_amount = r77_over3year_amount;
	}
	public BigDecimal getR77_10_headging_nl() {
		return r77_10_headging_nl;
	}
	public void setR77_10_headging_nl(BigDecimal r77_10_headging_nl) {
		this.r77_10_headging_nl = r77_10_headging_nl;
	}
	public BigDecimal getR77_10_n_headging_nl_() {
		return r77_10_n_headging_nl_;
	}
	public void setR77_10_n_headging_nl_(BigDecimal r77_10_n_headging_nl_) {
		this.r77_10_n_headging_nl_ = r77_10_n_headging_nl_;
	}
	public BigDecimal getR77_10_trading_nl() {
		return r77_10_trading_nl;
	}
	public void setR77_10_trading_nl(BigDecimal r77_10_trading_nl) {
		this.r77_10_trading_nl = r77_10_trading_nl;
	}
	public BigDecimal getR77_10_n_trading_nl_() {
		return r77_10_n_trading_nl_;
	}
	public void setR77_10_n_trading_nl_(BigDecimal r77_10_n_trading_nl_) {
		this.r77_10_n_trading_nl_ = r77_10_n_trading_nl_;
	}
	public String getR78_product() {
		return r78_product;
	}
	public void setR78_product(String r78_product) {
		this.r78_product = r78_product;
	}
	public BigDecimal getR78_hedging_amount() {
		return r78_hedging_amount;
	}
	public void setR78_hedging_amount(BigDecimal r78_hedging_amount) {
		this.r78_hedging_amount = r78_hedging_amount;
	}
	public BigDecimal getR78_trading_amount() {
		return r78_trading_amount;
	}
	public void setR78_trading_amount(BigDecimal r78_trading_amount) {
		this.r78_trading_amount = r78_trading_amount;
	}
	public BigDecimal getR78_resident_amount() {
		return r78_resident_amount;
	}
	public void setR78_resident_amount(BigDecimal r78_resident_amount) {
		this.r78_resident_amount = r78_resident_amount;
	}
	public BigDecimal getR78_non_resident_amount() {
		return r78_non_resident_amount;
	}
	public void setR78_non_resident_amount(BigDecimal r78_non_resident_amount) {
		this.r78_non_resident_amount = r78_non_resident_amount;
	}
	public BigDecimal getR78_with1year_amount() {
		return r78_with1year_amount;
	}
	public void setR78_with1year_amount(BigDecimal r78_with1year_amount) {
		this.r78_with1year_amount = r78_with1year_amount;
	}
	public BigDecimal getR78_1to3year_amount() {
		return r78_1to3year_amount;
	}
	public void setR78_1to3year_amount(BigDecimal r78_1to3year_amount) {
		this.r78_1to3year_amount = r78_1to3year_amount;
	}
	public BigDecimal getR78_over3year_amount() {
		return r78_over3year_amount;
	}
	public void setR78_over3year_amount(BigDecimal r78_over3year_amount) {
		this.r78_over3year_amount = r78_over3year_amount;
	}
	public BigDecimal getR78_10_headging_nl() {
		return r78_10_headging_nl;
	}
	public void setR78_10_headging_nl(BigDecimal r78_10_headging_nl) {
		this.r78_10_headging_nl = r78_10_headging_nl;
	}
	public BigDecimal getR78_10_n_headging_nl_() {
		return r78_10_n_headging_nl_;
	}
	public void setR78_10_n_headging_nl_(BigDecimal r78_10_n_headging_nl_) {
		this.r78_10_n_headging_nl_ = r78_10_n_headging_nl_;
	}
	public BigDecimal getR78_10_trading_nl() {
		return r78_10_trading_nl;
	}
	public void setR78_10_trading_nl(BigDecimal r78_10_trading_nl) {
		this.r78_10_trading_nl = r78_10_trading_nl;
	}
	public BigDecimal getR78_10_n_trading_nl_() {
		return r78_10_n_trading_nl_;
	}
	public void setR78_10_n_trading_nl_(BigDecimal r78_10_n_trading_nl_) {
		this.r78_10_n_trading_nl_ = r78_10_n_trading_nl_;
	}
	public String getR79_product() {
		return r79_product;
	}
	public void setR79_product(String r79_product) {
		this.r79_product = r79_product;
	}
	public BigDecimal getR79_hedging_amount() {
		return r79_hedging_amount;
	}
	public void setR79_hedging_amount(BigDecimal r79_hedging_amount) {
		this.r79_hedging_amount = r79_hedging_amount;
	}
	public BigDecimal getR79_trading_amount() {
		return r79_trading_amount;
	}
	public void setR79_trading_amount(BigDecimal r79_trading_amount) {
		this.r79_trading_amount = r79_trading_amount;
	}
	public BigDecimal getR79_resident_amount() {
		return r79_resident_amount;
	}
	public void setR79_resident_amount(BigDecimal r79_resident_amount) {
		this.r79_resident_amount = r79_resident_amount;
	}
	public BigDecimal getR79_non_resident_amount() {
		return r79_non_resident_amount;
	}
	public void setR79_non_resident_amount(BigDecimal r79_non_resident_amount) {
		this.r79_non_resident_amount = r79_non_resident_amount;
	}
	public BigDecimal getR79_with1year_amount() {
		return r79_with1year_amount;
	}
	public void setR79_with1year_amount(BigDecimal r79_with1year_amount) {
		this.r79_with1year_amount = r79_with1year_amount;
	}
	public BigDecimal getR79_1to3year_amount() {
		return r79_1to3year_amount;
	}
	public void setR79_1to3year_amount(BigDecimal r79_1to3year_amount) {
		this.r79_1to3year_amount = r79_1to3year_amount;
	}
	public BigDecimal getR79_over3year_amount() {
		return r79_over3year_amount;
	}
	public void setR79_over3year_amount(BigDecimal r79_over3year_amount) {
		this.r79_over3year_amount = r79_over3year_amount;
	}
	public BigDecimal getR79_10_headging_nl() {
		return r79_10_headging_nl;
	}
	public void setR79_10_headging_nl(BigDecimal r79_10_headging_nl) {
		this.r79_10_headging_nl = r79_10_headging_nl;
	}
	public BigDecimal getR79_10_n_headging_nl_() {
		return r79_10_n_headging_nl_;
	}
	public void setR79_10_n_headging_nl_(BigDecimal r79_10_n_headging_nl_) {
		this.r79_10_n_headging_nl_ = r79_10_n_headging_nl_;
	}
	public BigDecimal getR79_10_trading_nl() {
		return r79_10_trading_nl;
	}
	public void setR79_10_trading_nl(BigDecimal r79_10_trading_nl) {
		this.r79_10_trading_nl = r79_10_trading_nl;
	}
	public BigDecimal getR79_10_n_trading_nl_() {
		return r79_10_n_trading_nl_;
	}
	public void setR79_10_n_trading_nl_(BigDecimal r79_10_n_trading_nl_) {
		this.r79_10_n_trading_nl_ = r79_10_n_trading_nl_;
	}
	public String getR80_product() {
		return r80_product;
	}
	public void setR80_product(String r80_product) {
		this.r80_product = r80_product;
	}
	public BigDecimal getR80_hedging_amount() {
		return r80_hedging_amount;
	}
	public void setR80_hedging_amount(BigDecimal r80_hedging_amount) {
		this.r80_hedging_amount = r80_hedging_amount;
	}
	public BigDecimal getR80_trading_amount() {
		return r80_trading_amount;
	}
	public void setR80_trading_amount(BigDecimal r80_trading_amount) {
		this.r80_trading_amount = r80_trading_amount;
	}
	public BigDecimal getR80_resident_amount() {
		return r80_resident_amount;
	}
	public void setR80_resident_amount(BigDecimal r80_resident_amount) {
		this.r80_resident_amount = r80_resident_amount;
	}
	public BigDecimal getR80_non_resident_amount() {
		return r80_non_resident_amount;
	}
	public void setR80_non_resident_amount(BigDecimal r80_non_resident_amount) {
		this.r80_non_resident_amount = r80_non_resident_amount;
	}
	public BigDecimal getR80_with1year_amount() {
		return r80_with1year_amount;
	}
	public void setR80_with1year_amount(BigDecimal r80_with1year_amount) {
		this.r80_with1year_amount = r80_with1year_amount;
	}
	public BigDecimal getR80_1to3year_amount() {
		return r80_1to3year_amount;
	}
	public void setR80_1to3year_amount(BigDecimal r80_1to3year_amount) {
		this.r80_1to3year_amount = r80_1to3year_amount;
	}
	public BigDecimal getR80_over3year_amount() {
		return r80_over3year_amount;
	}
	public void setR80_over3year_amount(BigDecimal r80_over3year_amount) {
		this.r80_over3year_amount = r80_over3year_amount;
	}
	public BigDecimal getR80_10_headging_nl() {
		return r80_10_headging_nl;
	}
	public void setR80_10_headging_nl(BigDecimal r80_10_headging_nl) {
		this.r80_10_headging_nl = r80_10_headging_nl;
	}
	public BigDecimal getR80_10_n_headging_nl_() {
		return r80_10_n_headging_nl_;
	}
	public void setR80_10_n_headging_nl_(BigDecimal r80_10_n_headging_nl_) {
		this.r80_10_n_headging_nl_ = r80_10_n_headging_nl_;
	}
	public BigDecimal getR80_10_trading_nl() {
		return r80_10_trading_nl;
	}
	public void setR80_10_trading_nl(BigDecimal r80_10_trading_nl) {
		this.r80_10_trading_nl = r80_10_trading_nl;
	}
	public BigDecimal getR80_10_n_trading_nl_() {
		return r80_10_n_trading_nl_;
	}
	public void setR80_10_n_trading_nl_(BigDecimal r80_10_n_trading_nl_) {
		this.r80_10_n_trading_nl_ = r80_10_n_trading_nl_;
	}
	public String getR81_product() {
		return r81_product;
	}
	public void setR81_product(String r81_product) {
		this.r81_product = r81_product;
	}
	public BigDecimal getR81_hedging_amount() {
		return r81_hedging_amount;
	}
	public void setR81_hedging_amount(BigDecimal r81_hedging_amount) {
		this.r81_hedging_amount = r81_hedging_amount;
	}
	public BigDecimal getR81_trading_amount() {
		return r81_trading_amount;
	}
	public void setR81_trading_amount(BigDecimal r81_trading_amount) {
		this.r81_trading_amount = r81_trading_amount;
	}
	public BigDecimal getR81_resident_amount() {
		return r81_resident_amount;
	}
	public void setR81_resident_amount(BigDecimal r81_resident_amount) {
		this.r81_resident_amount = r81_resident_amount;
	}
	public BigDecimal getR81_non_resident_amount() {
		return r81_non_resident_amount;
	}
	public void setR81_non_resident_amount(BigDecimal r81_non_resident_amount) {
		this.r81_non_resident_amount = r81_non_resident_amount;
	}
	public BigDecimal getR81_with1year_amount() {
		return r81_with1year_amount;
	}
	public void setR81_with1year_amount(BigDecimal r81_with1year_amount) {
		this.r81_with1year_amount = r81_with1year_amount;
	}
	public BigDecimal getR81_1to3year_amount() {
		return r81_1to3year_amount;
	}
	public void setR81_1to3year_amount(BigDecimal r81_1to3year_amount) {
		this.r81_1to3year_amount = r81_1to3year_amount;
	}
	public BigDecimal getR81_over3year_amount() {
		return r81_over3year_amount;
	}
	public void setR81_over3year_amount(BigDecimal r81_over3year_amount) {
		this.r81_over3year_amount = r81_over3year_amount;
	}
	public BigDecimal getR81_10_headging_nl() {
		return r81_10_headging_nl;
	}
	public void setR81_10_headging_nl(BigDecimal r81_10_headging_nl) {
		this.r81_10_headging_nl = r81_10_headging_nl;
	}
	public BigDecimal getR81_10_n_headging_nl_() {
		return r81_10_n_headging_nl_;
	}
	public void setR81_10_n_headging_nl_(BigDecimal r81_10_n_headging_nl_) {
		this.r81_10_n_headging_nl_ = r81_10_n_headging_nl_;
	}
	public BigDecimal getR81_10_trading_nl() {
		return r81_10_trading_nl;
	}
	public void setR81_10_trading_nl(BigDecimal r81_10_trading_nl) {
		this.r81_10_trading_nl = r81_10_trading_nl;
	}
	public BigDecimal getR81_10_n_trading_nl_() {
		return r81_10_n_trading_nl_;
	}
	public void setR81_10_n_trading_nl_(BigDecimal r81_10_n_trading_nl_) {
		this.r81_10_n_trading_nl_ = r81_10_n_trading_nl_;
	}
	public String getR82_product() {
		return r82_product;
	}
	public void setR82_product(String r82_product) {
		this.r82_product = r82_product;
	}
	public BigDecimal getR82_hedging_amount() {
		return r82_hedging_amount;
	}
	public void setR82_hedging_amount(BigDecimal r82_hedging_amount) {
		this.r82_hedging_amount = r82_hedging_amount;
	}
	public BigDecimal getR82_trading_amount() {
		return r82_trading_amount;
	}
	public void setR82_trading_amount(BigDecimal r82_trading_amount) {
		this.r82_trading_amount = r82_trading_amount;
	}
	public BigDecimal getR82_resident_amount() {
		return r82_resident_amount;
	}
	public void setR82_resident_amount(BigDecimal r82_resident_amount) {
		this.r82_resident_amount = r82_resident_amount;
	}
	public BigDecimal getR82_non_resident_amount() {
		return r82_non_resident_amount;
	}
	public void setR82_non_resident_amount(BigDecimal r82_non_resident_amount) {
		this.r82_non_resident_amount = r82_non_resident_amount;
	}
	public BigDecimal getR82_with1year_amount() {
		return r82_with1year_amount;
	}
	public void setR82_with1year_amount(BigDecimal r82_with1year_amount) {
		this.r82_with1year_amount = r82_with1year_amount;
	}
	public BigDecimal getR82_1to3year_amount() {
		return r82_1to3year_amount;
	}
	public void setR82_1to3year_amount(BigDecimal r82_1to3year_amount) {
		this.r82_1to3year_amount = r82_1to3year_amount;
	}
	public BigDecimal getR82_over3year_amount() {
		return r82_over3year_amount;
	}
	public void setR82_over3year_amount(BigDecimal r82_over3year_amount) {
		this.r82_over3year_amount = r82_over3year_amount;
	}
	public BigDecimal getR82_10_headging_nl() {
		return r82_10_headging_nl;
	}
	public void setR82_10_headging_nl(BigDecimal r82_10_headging_nl) {
		this.r82_10_headging_nl = r82_10_headging_nl;
	}
	public BigDecimal getR82_10_n_headging_nl_() {
		return r82_10_n_headging_nl_;
	}
	public void setR82_10_n_headging_nl_(BigDecimal r82_10_n_headging_nl_) {
		this.r82_10_n_headging_nl_ = r82_10_n_headging_nl_;
	}
	public BigDecimal getR82_10_trading_nl() {
		return r82_10_trading_nl;
	}
	public void setR82_10_trading_nl(BigDecimal r82_10_trading_nl) {
		this.r82_10_trading_nl = r82_10_trading_nl;
	}
	public BigDecimal getR82_10_n_trading_nl_() {
		return r82_10_n_trading_nl_;
	}
	public void setR82_10_n_trading_nl_(BigDecimal r82_10_n_trading_nl_) {
		this.r82_10_n_trading_nl_ = r82_10_n_trading_nl_;
	}
	public String getR83_product1() {
		return r83_product1;
	}
	public void setR83_product1(String r83_product1) {
		this.r83_product1 = r83_product1;
	}
	public BigDecimal getR83_resident_for_exc() {
		return r83_resident_for_exc;
	}
	public void setR83_resident_for_exc(BigDecimal r83_resident_for_exc) {
		this.r83_resident_for_exc = r83_resident_for_exc;
	}
	public BigDecimal getR83_non_resident_for_exc() {
		return r83_non_resident_for_exc;
	}
	public void setR83_non_resident_for_exc(BigDecimal r83_non_resident_for_exc) {
		this.r83_non_resident_for_exc = r83_non_resident_for_exc;
	}
	public String getR83_product2() {
		return r83_product2;
	}
	public void setR83_product2(String r83_product2) {
		this.r83_product2 = r83_product2;
	}
	public BigDecimal getR83_resident_curr_opt() {
		return r83_resident_curr_opt;
	}
	public void setR83_resident_curr_opt(BigDecimal r83_resident_curr_opt) {
		this.r83_resident_curr_opt = r83_resident_curr_opt;
	}
	public BigDecimal getR83_non_resident_curr_opt() {
		return r83_non_resident_curr_opt;
	}
	public void setR83_non_resident_curr_opt(BigDecimal r83_non_resident_curr_opt) {
		this.r83_non_resident_curr_opt = r83_non_resident_curr_opt;
	}
	public String getR84_product1() {
		return r84_product1;
	}
	public void setR84_product1(String r84_product1) {
		this.r84_product1 = r84_product1;
	}
	public BigDecimal getR84_resident_for_exc() {
		return r84_resident_for_exc;
	}
	public void setR84_resident_for_exc(BigDecimal r84_resident_for_exc) {
		this.r84_resident_for_exc = r84_resident_for_exc;
	}
	public BigDecimal getR84_non_resident_for_exc() {
		return r84_non_resident_for_exc;
	}
	public void setR84_non_resident_for_exc(BigDecimal r84_non_resident_for_exc) {
		this.r84_non_resident_for_exc = r84_non_resident_for_exc;
	}
	public String getR84_product2() {
		return r84_product2;
	}
	public void setR84_product2(String r84_product2) {
		this.r84_product2 = r84_product2;
	}
	public BigDecimal getR84_resident_curr_opt() {
		return r84_resident_curr_opt;
	}
	public void setR84_resident_curr_opt(BigDecimal r84_resident_curr_opt) {
		this.r84_resident_curr_opt = r84_resident_curr_opt;
	}
	public BigDecimal getR84_non_resident_curr_opt() {
		return r84_non_resident_curr_opt;
	}
	public void setR84_non_resident_curr_opt(BigDecimal r84_non_resident_curr_opt) {
		this.r84_non_resident_curr_opt = r84_non_resident_curr_opt;
	}
	public String getR85_product1() {
		return r85_product1;
	}
	public void setR85_product1(String r85_product1) {
		this.r85_product1 = r85_product1;
	}
	public BigDecimal getR85_resident_for_exc() {
		return r85_resident_for_exc;
	}
	public void setR85_resident_for_exc(BigDecimal r85_resident_for_exc) {
		this.r85_resident_for_exc = r85_resident_for_exc;
	}
	public BigDecimal getR85_non_resident_for_exc() {
		return r85_non_resident_for_exc;
	}
	public void setR85_non_resident_for_exc(BigDecimal r85_non_resident_for_exc) {
		this.r85_non_resident_for_exc = r85_non_resident_for_exc;
	}
	public String getR85_product2() {
		return r85_product2;
	}
	public void setR85_product2(String r85_product2) {
		this.r85_product2 = r85_product2;
	}
	public BigDecimal getR85_resident_curr_opt() {
		return r85_resident_curr_opt;
	}
	public void setR85_resident_curr_opt(BigDecimal r85_resident_curr_opt) {
		this.r85_resident_curr_opt = r85_resident_curr_opt;
	}
	public BigDecimal getR85_non_resident_curr_opt() {
		return r85_non_resident_curr_opt;
	}
	public void setR85_non_resident_curr_opt(BigDecimal r85_non_resident_curr_opt) {
		this.r85_non_resident_curr_opt = r85_non_resident_curr_opt;
	}
	public String getR86_product1() {
		return r86_product1;
	}
	public void setR86_product1(String r86_product1) {
		this.r86_product1 = r86_product1;
	}
	public BigDecimal getR86_resident_for_exc() {
		return r86_resident_for_exc;
	}
	public void setR86_resident_for_exc(BigDecimal r86_resident_for_exc) {
		this.r86_resident_for_exc = r86_resident_for_exc;
	}
	public BigDecimal getR86_non_resident_for_exc() {
		return r86_non_resident_for_exc;
	}
	public void setR86_non_resident_for_exc(BigDecimal r86_non_resident_for_exc) {
		this.r86_non_resident_for_exc = r86_non_resident_for_exc;
	}
	public String getR86_product2() {
		return r86_product2;
	}
	public void setR86_product2(String r86_product2) {
		this.r86_product2 = r86_product2;
	}
	public BigDecimal getR86_resident_curr_opt() {
		return r86_resident_curr_opt;
	}
	public void setR86_resident_curr_opt(BigDecimal r86_resident_curr_opt) {
		this.r86_resident_curr_opt = r86_resident_curr_opt;
	}
	public BigDecimal getR86_non_resident_curr_opt() {
		return r86_non_resident_curr_opt;
	}
	public void setR86_non_resident_curr_opt(BigDecimal r86_non_resident_curr_opt) {
		this.r86_non_resident_curr_opt = r86_non_resident_curr_opt;
	}
	public String getR87_product1() {
		return r87_product1;
	}
	public void setR87_product1(String r87_product1) {
		this.r87_product1 = r87_product1;
	}
	public BigDecimal getR87_resident_for_exc() {
		return r87_resident_for_exc;
	}
	public void setR87_resident_for_exc(BigDecimal r87_resident_for_exc) {
		this.r87_resident_for_exc = r87_resident_for_exc;
	}
	public BigDecimal getR87_non_resident_for_exc() {
		return r87_non_resident_for_exc;
	}
	public void setR87_non_resident_for_exc(BigDecimal r87_non_resident_for_exc) {
		this.r87_non_resident_for_exc = r87_non_resident_for_exc;
	}
	public String getR87_product2() {
		return r87_product2;
	}
	public void setR87_product2(String r87_product2) {
		this.r87_product2 = r87_product2;
	}
	public BigDecimal getR87_resident_curr_opt() {
		return r87_resident_curr_opt;
	}
	public void setR87_resident_curr_opt(BigDecimal r87_resident_curr_opt) {
		this.r87_resident_curr_opt = r87_resident_curr_opt;
	}
	public BigDecimal getR87_non_resident_curr_opt() {
		return r87_non_resident_curr_opt;
	}
	public void setR87_non_resident_curr_opt(BigDecimal r87_non_resident_curr_opt) {
		this.r87_non_resident_curr_opt = r87_non_resident_curr_opt;
	}
	public String getR88_product1() {
		return r88_product1;
	}
	public void setR88_product1(String r88_product1) {
		this.r88_product1 = r88_product1;
	}
	public BigDecimal getR88_resident_for_exc() {
		return r88_resident_for_exc;
	}
	public void setR88_resident_for_exc(BigDecimal r88_resident_for_exc) {
		this.r88_resident_for_exc = r88_resident_for_exc;
	}
	public BigDecimal getR88_non_resident_for_exc() {
		return r88_non_resident_for_exc;
	}
	public void setR88_non_resident_for_exc(BigDecimal r88_non_resident_for_exc) {
		this.r88_non_resident_for_exc = r88_non_resident_for_exc;
	}
	public String getR88_product2() {
		return r88_product2;
	}
	public void setR88_product2(String r88_product2) {
		this.r88_product2 = r88_product2;
	}
	public BigDecimal getR88_resident_curr_opt() {
		return r88_resident_curr_opt;
	}
	public void setR88_resident_curr_opt(BigDecimal r88_resident_curr_opt) {
		this.r88_resident_curr_opt = r88_resident_curr_opt;
	}
	public BigDecimal getR88_non_resident_curr_opt() {
		return r88_non_resident_curr_opt;
	}
	public void setR88_non_resident_curr_opt(BigDecimal r88_non_resident_curr_opt) {
		this.r88_non_resident_curr_opt = r88_non_resident_curr_opt;
	}
	public String getR89_product1() {
		return r89_product1;
	}
	public void setR89_product1(String r89_product1) {
		this.r89_product1 = r89_product1;
	}
	public BigDecimal getR89_resident_for_exc() {
		return r89_resident_for_exc;
	}
	public void setR89_resident_for_exc(BigDecimal r89_resident_for_exc) {
		this.r89_resident_for_exc = r89_resident_for_exc;
	}
	public BigDecimal getR89_non_resident_for_exc() {
		return r89_non_resident_for_exc;
	}
	public void setR89_non_resident_for_exc(BigDecimal r89_non_resident_for_exc) {
		this.r89_non_resident_for_exc = r89_non_resident_for_exc;
	}
	public String getR89_product2() {
		return r89_product2;
	}
	public void setR89_product2(String r89_product2) {
		this.r89_product2 = r89_product2;
	}
	public BigDecimal getR89_resident_curr_opt() {
		return r89_resident_curr_opt;
	}
	public void setR89_resident_curr_opt(BigDecimal r89_resident_curr_opt) {
		this.r89_resident_curr_opt = r89_resident_curr_opt;
	}
	public BigDecimal getR89_non_resident_curr_opt() {
		return r89_non_resident_curr_opt;
	}
	public void setR89_non_resident_curr_opt(BigDecimal r89_non_resident_curr_opt) {
		this.r89_non_resident_curr_opt = r89_non_resident_curr_opt;
	}
	public String getR90_product1() {
		return r90_product1;
	}
	public void setR90_product1(String r90_product1) {
		this.r90_product1 = r90_product1;
	}
	public BigDecimal getR90_resident_for_exc() {
		return r90_resident_for_exc;
	}
	public void setR90_resident_for_exc(BigDecimal r90_resident_for_exc) {
		this.r90_resident_for_exc = r90_resident_for_exc;
	}
	public BigDecimal getR90_non_resident_for_exc() {
		return r90_non_resident_for_exc;
	}
	public void setR90_non_resident_for_exc(BigDecimal r90_non_resident_for_exc) {
		this.r90_non_resident_for_exc = r90_non_resident_for_exc;
	}
	public String getR90_product2() {
		return r90_product2;
	}
	public void setR90_product2(String r90_product2) {
		this.r90_product2 = r90_product2;
	}
	public BigDecimal getR90_resident_curr_opt() {
		return r90_resident_curr_opt;
	}
	public void setR90_resident_curr_opt(BigDecimal r90_resident_curr_opt) {
		this.r90_resident_curr_opt = r90_resident_curr_opt;
	}
	public BigDecimal getR90_non_resident_curr_opt() {
		return r90_non_resident_curr_opt;
	}
	public void setR90_non_resident_curr_opt(BigDecimal r90_non_resident_curr_opt) {
		this.r90_non_resident_curr_opt = r90_non_resident_curr_opt;
	}
	public String getR91_product1() {
		return r91_product1;
	}
	public void setR91_product1(String r91_product1) {
		this.r91_product1 = r91_product1;
	}
	public BigDecimal getR91_resident_for_exc() {
		return r91_resident_for_exc;
	}
	public void setR91_resident_for_exc(BigDecimal r91_resident_for_exc) {
		this.r91_resident_for_exc = r91_resident_for_exc;
	}
	public BigDecimal getR91_non_resident_for_exc() {
		return r91_non_resident_for_exc;
	}
	public void setR91_non_resident_for_exc(BigDecimal r91_non_resident_for_exc) {
		this.r91_non_resident_for_exc = r91_non_resident_for_exc;
	}
	public String getR91_product2() {
		return r91_product2;
	}
	public void setR91_product2(String r91_product2) {
		this.r91_product2 = r91_product2;
	}
	public BigDecimal getR91_resident_curr_opt() {
		return r91_resident_curr_opt;
	}
	public void setR91_resident_curr_opt(BigDecimal r91_resident_curr_opt) {
		this.r91_resident_curr_opt = r91_resident_curr_opt;
	}
	public BigDecimal getR91_non_resident_curr_opt() {
		return r91_non_resident_curr_opt;
	}
	public void setR91_non_resident_curr_opt(BigDecimal r91_non_resident_curr_opt) {
		this.r91_non_resident_curr_opt = r91_non_resident_curr_opt;
	}
	public String getR92_product1() {
		return r92_product1;
	}
	public void setR92_product1(String r92_product1) {
		this.r92_product1 = r92_product1;
	}
	public BigDecimal getR92_resident_for_exc() {
		return r92_resident_for_exc;
	}
	public void setR92_resident_for_exc(BigDecimal r92_resident_for_exc) {
		this.r92_resident_for_exc = r92_resident_for_exc;
	}
	public BigDecimal getR92_non_resident_for_exc() {
		return r92_non_resident_for_exc;
	}
	public void setR92_non_resident_for_exc(BigDecimal r92_non_resident_for_exc) {
		this.r92_non_resident_for_exc = r92_non_resident_for_exc;
	}
	public String getR92_product2() {
		return r92_product2;
	}
	public void setR92_product2(String r92_product2) {
		this.r92_product2 = r92_product2;
	}
	public BigDecimal getR92_resident_curr_opt() {
		return r92_resident_curr_opt;
	}
	public void setR92_resident_curr_opt(BigDecimal r92_resident_curr_opt) {
		this.r92_resident_curr_opt = r92_resident_curr_opt;
	}
	public BigDecimal getR92_non_resident_curr_opt() {
		return r92_non_resident_curr_opt;
	}
	public void setR92_non_resident_curr_opt(BigDecimal r92_non_resident_curr_opt) {
		this.r92_non_resident_curr_opt = r92_non_resident_curr_opt;
	}
	public String getR93_product1() {
		return r93_product1;
	}
	public void setR93_product1(String r93_product1) {
		this.r93_product1 = r93_product1;
	}
	public BigDecimal getR93_resident_for_exc() {
		return r93_resident_for_exc;
	}
	public void setR93_resident_for_exc(BigDecimal r93_resident_for_exc) {
		this.r93_resident_for_exc = r93_resident_for_exc;
	}
	public BigDecimal getR93_non_resident_for_exc() {
		return r93_non_resident_for_exc;
	}
	public void setR93_non_resident_for_exc(BigDecimal r93_non_resident_for_exc) {
		this.r93_non_resident_for_exc = r93_non_resident_for_exc;
	}
	public String getR93_product2() {
		return r93_product2;
	}
	public void setR93_product2(String r93_product2) {
		this.r93_product2 = r93_product2;
	}
	public BigDecimal getR93_resident_curr_opt() {
		return r93_resident_curr_opt;
	}
	public void setR93_resident_curr_opt(BigDecimal r93_resident_curr_opt) {
		this.r93_resident_curr_opt = r93_resident_curr_opt;
	}
	public BigDecimal getR93_non_resident_curr_opt() {
		return r93_non_resident_curr_opt;
	}
	public void setR93_non_resident_curr_opt(BigDecimal r93_non_resident_curr_opt) {
		this.r93_non_resident_curr_opt = r93_non_resident_curr_opt;
	}
	public String getR94_product1() {
		return r94_product1;
	}
	public void setR94_product1(String r94_product1) {
		this.r94_product1 = r94_product1;
	}
	public BigDecimal getR94_resident_for_exc() {
		return r94_resident_for_exc;
	}
	public void setR94_resident_for_exc(BigDecimal r94_resident_for_exc) {
		this.r94_resident_for_exc = r94_resident_for_exc;
	}
	public BigDecimal getR94_non_resident_for_exc() {
		return r94_non_resident_for_exc;
	}
	public void setR94_non_resident_for_exc(BigDecimal r94_non_resident_for_exc) {
		this.r94_non_resident_for_exc = r94_non_resident_for_exc;
	}
	public String getR94_product2() {
		return r94_product2;
	}
	public void setR94_product2(String r94_product2) {
		this.r94_product2 = r94_product2;
	}
	public BigDecimal getR94_resident_curr_opt() {
		return r94_resident_curr_opt;
	}
	public void setR94_resident_curr_opt(BigDecimal r94_resident_curr_opt) {
		this.r94_resident_curr_opt = r94_resident_curr_opt;
	}
	public BigDecimal getR94_non_resident_curr_opt() {
		return r94_non_resident_curr_opt;
	}
	public void setR94_non_resident_curr_opt(BigDecimal r94_non_resident_curr_opt) {
		this.r94_non_resident_curr_opt = r94_non_resident_curr_opt;
	}
	public String getR95_product1() {
		return r95_product1;
	}
	public void setR95_product1(String r95_product1) {
		this.r95_product1 = r95_product1;
	}
	public BigDecimal getR95_resident_for_exc() {
		return r95_resident_for_exc;
	}
	public void setR95_resident_for_exc(BigDecimal r95_resident_for_exc) {
		this.r95_resident_for_exc = r95_resident_for_exc;
	}
	public BigDecimal getR95_non_resident_for_exc() {
		return r95_non_resident_for_exc;
	}
	public void setR95_non_resident_for_exc(BigDecimal r95_non_resident_for_exc) {
		this.r95_non_resident_for_exc = r95_non_resident_for_exc;
	}
	public String getR95_product2() {
		return r95_product2;
	}
	public void setR95_product2(String r95_product2) {
		this.r95_product2 = r95_product2;
	}
	public BigDecimal getR95_resident_curr_opt() {
		return r95_resident_curr_opt;
	}
	public void setR95_resident_curr_opt(BigDecimal r95_resident_curr_opt) {
		this.r95_resident_curr_opt = r95_resident_curr_opt;
	}
	public BigDecimal getR95_non_resident_curr_opt() {
		return r95_non_resident_curr_opt;
	}
	public void setR95_non_resident_curr_opt(BigDecimal r95_non_resident_curr_opt) {
		this.r95_non_resident_curr_opt = r95_non_resident_curr_opt;
	}
	public String getR96_product1() {
		return r96_product1;
	}
	public void setR96_product1(String r96_product1) {
		this.r96_product1 = r96_product1;
	}
	public BigDecimal getR96_resident_for_exc() {
		return r96_resident_for_exc;
	}
	public void setR96_resident_for_exc(BigDecimal r96_resident_for_exc) {
		this.r96_resident_for_exc = r96_resident_for_exc;
	}
	public BigDecimal getR96_non_resident_for_exc() {
		return r96_non_resident_for_exc;
	}
	public void setR96_non_resident_for_exc(BigDecimal r96_non_resident_for_exc) {
		this.r96_non_resident_for_exc = r96_non_resident_for_exc;
	}
	public String getR96_product2() {
		return r96_product2;
	}
	public void setR96_product2(String r96_product2) {
		this.r96_product2 = r96_product2;
	}
	public BigDecimal getR96_resident_curr_opt() {
		return r96_resident_curr_opt;
	}
	public void setR96_resident_curr_opt(BigDecimal r96_resident_curr_opt) {
		this.r96_resident_curr_opt = r96_resident_curr_opt;
	}
	public BigDecimal getR96_non_resident_curr_opt() {
		return r96_non_resident_curr_opt;
	}
	public void setR96_non_resident_curr_opt(BigDecimal r96_non_resident_curr_opt) {
		this.r96_non_resident_curr_opt = r96_non_resident_curr_opt;
	}
	public String getR97_product1() {
		return r97_product1;
	}
	public void setR97_product1(String r97_product1) {
		this.r97_product1 = r97_product1;
	}
	public BigDecimal getR97_resident_for_exc() {
		return r97_resident_for_exc;
	}
	public void setR97_resident_for_exc(BigDecimal r97_resident_for_exc) {
		this.r97_resident_for_exc = r97_resident_for_exc;
	}
	public BigDecimal getR97_non_resident_for_exc() {
		return r97_non_resident_for_exc;
	}
	public void setR97_non_resident_for_exc(BigDecimal r97_non_resident_for_exc) {
		this.r97_non_resident_for_exc = r97_non_resident_for_exc;
	}
	public String getR97_product2() {
		return r97_product2;
	}
	public void setR97_product2(String r97_product2) {
		this.r97_product2 = r97_product2;
	}
	public BigDecimal getR97_resident_curr_opt() {
		return r97_resident_curr_opt;
	}
	public void setR97_resident_curr_opt(BigDecimal r97_resident_curr_opt) {
		this.r97_resident_curr_opt = r97_resident_curr_opt;
	}
	public BigDecimal getR97_non_resident_curr_opt() {
		return r97_non_resident_curr_opt;
	}
	public void setR97_non_resident_curr_opt(BigDecimal r97_non_resident_curr_opt) {
		this.r97_non_resident_curr_opt = r97_non_resident_curr_opt;
	}
	public String getR98_product1() {
		return r98_product1;
	}
	public void setR98_product1(String r98_product1) {
		this.r98_product1 = r98_product1;
	}
	public BigDecimal getR98_resident_interest_exp() {
		return r98_resident_interest_exp;
	}
	public void setR98_resident_interest_exp(BigDecimal r98_resident_interest_exp) {
		this.r98_resident_interest_exp = r98_resident_interest_exp;
	}
	public BigDecimal getR98_non_resident_interest_exp() {
		return r98_non_resident_interest_exp;
	}
	public void setR98_non_resident_interest_exp(BigDecimal r98_non_resident_interest_exp) {
		this.r98_non_resident_interest_exp = r98_non_resident_interest_exp;
	}
	public String getR98_product2() {
		return r98_product2;
	}
	public void setR98_product2(String r98_product2) {
		this.r98_product2 = r98_product2;
	}
	public BigDecimal getR98_resident_credit_exp() {
		return r98_resident_credit_exp;
	}
	public void setR98_resident_credit_exp(BigDecimal r98_resident_credit_exp) {
		this.r98_resident_credit_exp = r98_resident_credit_exp;
	}
	public BigDecimal getR98_non_resident_credit_exp() {
		return r98_non_resident_credit_exp;
	}
	public void setR98_non_resident_credit_exp(BigDecimal r98_non_resident_credit_exp) {
		this.r98_non_resident_credit_exp = r98_non_resident_credit_exp;
	}
	public String getR99_product1() {
		return r99_product1;
	}
	public void setR99_product1(String r99_product1) {
		this.r99_product1 = r99_product1;
	}
	public BigDecimal getR99_resident_interest_exp() {
		return r99_resident_interest_exp;
	}
	public void setR99_resident_interest_exp(BigDecimal r99_resident_interest_exp) {
		this.r99_resident_interest_exp = r99_resident_interest_exp;
	}
	public BigDecimal getR99_non_resident_interest_exp() {
		return r99_non_resident_interest_exp;
	}
	public void setR99_non_resident_interest_exp(BigDecimal r99_non_resident_interest_exp) {
		this.r99_non_resident_interest_exp = r99_non_resident_interest_exp;
	}
	public String getR99_product2() {
		return r99_product2;
	}
	public void setR99_product2(String r99_product2) {
		this.r99_product2 = r99_product2;
	}
	public BigDecimal getR99_resident_credit_exp() {
		return r99_resident_credit_exp;
	}
	public void setR99_resident_credit_exp(BigDecimal r99_resident_credit_exp) {
		this.r99_resident_credit_exp = r99_resident_credit_exp;
	}
	public BigDecimal getR99_non_resident_credit_exp() {
		return r99_non_resident_credit_exp;
	}
	public void setR99_non_resident_credit_exp(BigDecimal r99_non_resident_credit_exp) {
		this.r99_non_resident_credit_exp = r99_non_resident_credit_exp;
	}
	public String getR100_product1() {
		return r100_product1;
	}
	public void setR100_product1(String r100_product1) {
		this.r100_product1 = r100_product1;
	}
	public BigDecimal getR100_resident_interest_exp() {
		return r100_resident_interest_exp;
	}
	public void setR100_resident_interest_exp(BigDecimal r100_resident_interest_exp) {
		this.r100_resident_interest_exp = r100_resident_interest_exp;
	}
	public BigDecimal getR100_non_resident_interest_exp() {
		return r100_non_resident_interest_exp;
	}
	public void setR100_non_resident_interest_exp(BigDecimal r100_non_resident_interest_exp) {
		this.r100_non_resident_interest_exp = r100_non_resident_interest_exp;
	}
	public String getR100_product2() {
		return r100_product2;
	}
	public void setR100_product2(String r100_product2) {
		this.r100_product2 = r100_product2;
	}
	public BigDecimal getR100_resident_credit_exp() {
		return r100_resident_credit_exp;
	}
	public void setR100_resident_credit_exp(BigDecimal r100_resident_credit_exp) {
		this.r100_resident_credit_exp = r100_resident_credit_exp;
	}
	public BigDecimal getR100_non_resident_credit_exp() {
		return r100_non_resident_credit_exp;
	}
	public void setR100_non_resident_credit_exp(BigDecimal r100_non_resident_credit_exp) {
		this.r100_non_resident_credit_exp = r100_non_resident_credit_exp;
	}
	public String getR101_product1() {
		return r101_product1;
	}
	public void setR101_product1(String r101_product1) {
		this.r101_product1 = r101_product1;
	}
	public BigDecimal getR101_resident_interest_exp() {
		return r101_resident_interest_exp;
	}
	public void setR101_resident_interest_exp(BigDecimal r101_resident_interest_exp) {
		this.r101_resident_interest_exp = r101_resident_interest_exp;
	}
	public BigDecimal getR101_non_resident_interest_exp() {
		return r101_non_resident_interest_exp;
	}
	public void setR101_non_resident_interest_exp(BigDecimal r101_non_resident_interest_exp) {
		this.r101_non_resident_interest_exp = r101_non_resident_interest_exp;
	}
	public String getR101_product2() {
		return r101_product2;
	}
	public void setR101_product2(String r101_product2) {
		this.r101_product2 = r101_product2;
	}
	public BigDecimal getR101_resident_credit_exp() {
		return r101_resident_credit_exp;
	}
	public void setR101_resident_credit_exp(BigDecimal r101_resident_credit_exp) {
		this.r101_resident_credit_exp = r101_resident_credit_exp;
	}
	public BigDecimal getR101_non_resident_credit_exp() {
		return r101_non_resident_credit_exp;
	}
	public void setR101_non_resident_credit_exp(BigDecimal r101_non_resident_credit_exp) {
		this.r101_non_resident_credit_exp = r101_non_resident_credit_exp;
	}
	public String getR102_product1() {
		return r102_product1;
	}
	public void setR102_product1(String r102_product1) {
		this.r102_product1 = r102_product1;
	}
	public BigDecimal getR102_resident_interest_exp() {
		return r102_resident_interest_exp;
	}
	public void setR102_resident_interest_exp(BigDecimal r102_resident_interest_exp) {
		this.r102_resident_interest_exp = r102_resident_interest_exp;
	}
	public BigDecimal getR102_non_resident_interest_exp() {
		return r102_non_resident_interest_exp;
	}
	public void setR102_non_resident_interest_exp(BigDecimal r102_non_resident_interest_exp) {
		this.r102_non_resident_interest_exp = r102_non_resident_interest_exp;
	}
	public String getR102_product2() {
		return r102_product2;
	}
	public void setR102_product2(String r102_product2) {
		this.r102_product2 = r102_product2;
	}
	public BigDecimal getR102_resident_credit_exp() {
		return r102_resident_credit_exp;
	}
	public void setR102_resident_credit_exp(BigDecimal r102_resident_credit_exp) {
		this.r102_resident_credit_exp = r102_resident_credit_exp;
	}
	public BigDecimal getR102_non_resident_credit_exp() {
		return r102_non_resident_credit_exp;
	}
	public void setR102_non_resident_credit_exp(BigDecimal r102_non_resident_credit_exp) {
		this.r102_non_resident_credit_exp = r102_non_resident_credit_exp;
	}
	public String getR103_product1() {
		return r103_product1;
	}
	public void setR103_product1(String r103_product1) {
		this.r103_product1 = r103_product1;
	}
	public BigDecimal getR103_resident_interest_exp() {
		return r103_resident_interest_exp;
	}
	public void setR103_resident_interest_exp(BigDecimal r103_resident_interest_exp) {
		this.r103_resident_interest_exp = r103_resident_interest_exp;
	}
	public BigDecimal getR103_non_resident_interest_exp() {
		return r103_non_resident_interest_exp;
	}
	public void setR103_non_resident_interest_exp(BigDecimal r103_non_resident_interest_exp) {
		this.r103_non_resident_interest_exp = r103_non_resident_interest_exp;
	}
	public String getR103_product2() {
		return r103_product2;
	}
	public void setR103_product2(String r103_product2) {
		this.r103_product2 = r103_product2;
	}
	public BigDecimal getR103_resident_credit_exp() {
		return r103_resident_credit_exp;
	}
	public void setR103_resident_credit_exp(BigDecimal r103_resident_credit_exp) {
		this.r103_resident_credit_exp = r103_resident_credit_exp;
	}
	public BigDecimal getR103_non_resident_credit_exp() {
		return r103_non_resident_credit_exp;
	}
	public void setR103_non_resident_credit_exp(BigDecimal r103_non_resident_credit_exp) {
		this.r103_non_resident_credit_exp = r103_non_resident_credit_exp;
	}
	public String getR104_product1() {
		return r104_product1;
	}
	public void setR104_product1(String r104_product1) {
		this.r104_product1 = r104_product1;
	}
	public BigDecimal getR104_resident_interest_exp() {
		return r104_resident_interest_exp;
	}
	public void setR104_resident_interest_exp(BigDecimal r104_resident_interest_exp) {
		this.r104_resident_interest_exp = r104_resident_interest_exp;
	}
	public BigDecimal getR104_non_resident_interest_exp() {
		return r104_non_resident_interest_exp;
	}
	public void setR104_non_resident_interest_exp(BigDecimal r104_non_resident_interest_exp) {
		this.r104_non_resident_interest_exp = r104_non_resident_interest_exp;
	}
	public String getR104_product2() {
		return r104_product2;
	}
	public void setR104_product2(String r104_product2) {
		this.r104_product2 = r104_product2;
	}
	public BigDecimal getR104_resident_credit_exp() {
		return r104_resident_credit_exp;
	}
	public void setR104_resident_credit_exp(BigDecimal r104_resident_credit_exp) {
		this.r104_resident_credit_exp = r104_resident_credit_exp;
	}
	public BigDecimal getR104_non_resident_credit_exp() {
		return r104_non_resident_credit_exp;
	}
	public void setR104_non_resident_credit_exp(BigDecimal r104_non_resident_credit_exp) {
		this.r104_non_resident_credit_exp = r104_non_resident_credit_exp;
	}
	public String getR105_product1() {
		return r105_product1;
	}
	public void setR105_product1(String r105_product1) {
		this.r105_product1 = r105_product1;
	}
	public BigDecimal getR105_resident_interest_exp() {
		return r105_resident_interest_exp;
	}
	public void setR105_resident_interest_exp(BigDecimal r105_resident_interest_exp) {
		this.r105_resident_interest_exp = r105_resident_interest_exp;
	}
	public BigDecimal getR105_non_resident_interest_exp() {
		return r105_non_resident_interest_exp;
	}
	public void setR105_non_resident_interest_exp(BigDecimal r105_non_resident_interest_exp) {
		this.r105_non_resident_interest_exp = r105_non_resident_interest_exp;
	}
	public String getR105_product2() {
		return r105_product2;
	}
	public void setR105_product2(String r105_product2) {
		this.r105_product2 = r105_product2;
	}
	public BigDecimal getR105_resident_credit_exp() {
		return r105_resident_credit_exp;
	}
	public void setR105_resident_credit_exp(BigDecimal r105_resident_credit_exp) {
		this.r105_resident_credit_exp = r105_resident_credit_exp;
	}
	public BigDecimal getR105_non_resident_credit_exp() {
		return r105_non_resident_credit_exp;
	}
	public void setR105_non_resident_credit_exp(BigDecimal r105_non_resident_credit_exp) {
		this.r105_non_resident_credit_exp = r105_non_resident_credit_exp;
	}
	public String getR106_product1() {
		return r106_product1;
	}
	public void setR106_product1(String r106_product1) {
		this.r106_product1 = r106_product1;
	}
	public BigDecimal getR106_resident_interest_exp() {
		return r106_resident_interest_exp;
	}
	public void setR106_resident_interest_exp(BigDecimal r106_resident_interest_exp) {
		this.r106_resident_interest_exp = r106_resident_interest_exp;
	}
	public BigDecimal getR106_non_resident_interest_exp() {
		return r106_non_resident_interest_exp;
	}
	public void setR106_non_resident_interest_exp(BigDecimal r106_non_resident_interest_exp) {
		this.r106_non_resident_interest_exp = r106_non_resident_interest_exp;
	}
	public String getR106_product2() {
		return r106_product2;
	}
	public void setR106_product2(String r106_product2) {
		this.r106_product2 = r106_product2;
	}
	public BigDecimal getR106_resident_credit_exp() {
		return r106_resident_credit_exp;
	}
	public void setR106_resident_credit_exp(BigDecimal r106_resident_credit_exp) {
		this.r106_resident_credit_exp = r106_resident_credit_exp;
	}
	public BigDecimal getR106_non_resident_credit_exp() {
		return r106_non_resident_credit_exp;
	}
	public void setR106_non_resident_credit_exp(BigDecimal r106_non_resident_credit_exp) {
		this.r106_non_resident_credit_exp = r106_non_resident_credit_exp;
	}
	public String getR107_product1() {
		return r107_product1;
	}
	public void setR107_product1(String r107_product1) {
		this.r107_product1 = r107_product1;
	}
	public BigDecimal getR107_resident_interest_exp() {
		return r107_resident_interest_exp;
	}
	public void setR107_resident_interest_exp(BigDecimal r107_resident_interest_exp) {
		this.r107_resident_interest_exp = r107_resident_interest_exp;
	}
	public BigDecimal getR107_non_resident_interest_exp() {
		return r107_non_resident_interest_exp;
	}
	public void setR107_non_resident_interest_exp(BigDecimal r107_non_resident_interest_exp) {
		this.r107_non_resident_interest_exp = r107_non_resident_interest_exp;
	}
	public String getR107_product2() {
		return r107_product2;
	}
	public void setR107_product2(String r107_product2) {
		this.r107_product2 = r107_product2;
	}
	public BigDecimal getR107_resident_credit_exp() {
		return r107_resident_credit_exp;
	}
	public void setR107_resident_credit_exp(BigDecimal r107_resident_credit_exp) {
		this.r107_resident_credit_exp = r107_resident_credit_exp;
	}
	public BigDecimal getR107_non_resident_credit_exp() {
		return r107_non_resident_credit_exp;
	}
	public void setR107_non_resident_credit_exp(BigDecimal r107_non_resident_credit_exp) {
		this.r107_non_resident_credit_exp = r107_non_resident_credit_exp;
	}
	public String getR108_product1() {
		return r108_product1;
	}
	public void setR108_product1(String r108_product1) {
		this.r108_product1 = r108_product1;
	}
	public BigDecimal getR108_resident_interest_exp() {
		return r108_resident_interest_exp;
	}
	public void setR108_resident_interest_exp(BigDecimal r108_resident_interest_exp) {
		this.r108_resident_interest_exp = r108_resident_interest_exp;
	}
	public BigDecimal getR108_non_resident_interest_exp() {
		return r108_non_resident_interest_exp;
	}
	public void setR108_non_resident_interest_exp(BigDecimal r108_non_resident_interest_exp) {
		this.r108_non_resident_interest_exp = r108_non_resident_interest_exp;
	}
	public String getR108_product2() {
		return r108_product2;
	}
	public void setR108_product2(String r108_product2) {
		this.r108_product2 = r108_product2;
	}
	public BigDecimal getR108_resident_credit_exp() {
		return r108_resident_credit_exp;
	}
	public void setR108_resident_credit_exp(BigDecimal r108_resident_credit_exp) {
		this.r108_resident_credit_exp = r108_resident_credit_exp;
	}
	public BigDecimal getR108_non_resident_credit_exp() {
		return r108_non_resident_credit_exp;
	}
	public void setR108_non_resident_credit_exp(BigDecimal r108_non_resident_credit_exp) {
		this.r108_non_resident_credit_exp = r108_non_resident_credit_exp;
	}
	public String getR109_product1() {
		return r109_product1;
	}
	public void setR109_product1(String r109_product1) {
		this.r109_product1 = r109_product1;
	}
	public BigDecimal getR109_resident_interest_exp() {
		return r109_resident_interest_exp;
	}
	public void setR109_resident_interest_exp(BigDecimal r109_resident_interest_exp) {
		this.r109_resident_interest_exp = r109_resident_interest_exp;
	}
	public BigDecimal getR109_non_resident_interest_exp() {
		return r109_non_resident_interest_exp;
	}
	public void setR109_non_resident_interest_exp(BigDecimal r109_non_resident_interest_exp) {
		this.r109_non_resident_interest_exp = r109_non_resident_interest_exp;
	}
	public String getR109_product2() {
		return r109_product2;
	}
	public void setR109_product2(String r109_product2) {
		this.r109_product2 = r109_product2;
	}
	public BigDecimal getR109_resident_credit_exp() {
		return r109_resident_credit_exp;
	}
	public void setR109_resident_credit_exp(BigDecimal r109_resident_credit_exp) {
		this.r109_resident_credit_exp = r109_resident_credit_exp;
	}
	public BigDecimal getR109_non_resident_credit_exp() {
		return r109_non_resident_credit_exp;
	}
	public void setR109_non_resident_credit_exp(BigDecimal r109_non_resident_credit_exp) {
		this.r109_non_resident_credit_exp = r109_non_resident_credit_exp;
	}
	public String getR110_product1() {
		return r110_product1;
	}
	public void setR110_product1(String r110_product1) {
		this.r110_product1 = r110_product1;
	}
	public BigDecimal getR110_resident_interest_exp() {
		return r110_resident_interest_exp;
	}
	public void setR110_resident_interest_exp(BigDecimal r110_resident_interest_exp) {
		this.r110_resident_interest_exp = r110_resident_interest_exp;
	}
	public BigDecimal getR110_non_resident_interest_exp() {
		return r110_non_resident_interest_exp;
	}
	public void setR110_non_resident_interest_exp(BigDecimal r110_non_resident_interest_exp) {
		this.r110_non_resident_interest_exp = r110_non_resident_interest_exp;
	}
	public String getR110_product2() {
		return r110_product2;
	}
	public void setR110_product2(String r110_product2) {
		this.r110_product2 = r110_product2;
	}
	public BigDecimal getR110_resident_credit_exp() {
		return r110_resident_credit_exp;
	}
	public void setR110_resident_credit_exp(BigDecimal r110_resident_credit_exp) {
		this.r110_resident_credit_exp = r110_resident_credit_exp;
	}
	public BigDecimal getR110_non_resident_credit_exp() {
		return r110_non_resident_credit_exp;
	}
	public void setR110_non_resident_credit_exp(BigDecimal r110_non_resident_credit_exp) {
		this.r110_non_resident_credit_exp = r110_non_resident_credit_exp;
	}
	public String getR111_product1() {
		return r111_product1;
	}
	public void setR111_product1(String r111_product1) {
		this.r111_product1 = r111_product1;
	}
	public BigDecimal getR111_resident_interest_exp() {
		return r111_resident_interest_exp;
	}
	public void setR111_resident_interest_exp(BigDecimal r111_resident_interest_exp) {
		this.r111_resident_interest_exp = r111_resident_interest_exp;
	}
	public BigDecimal getR111_non_resident_interest_exp() {
		return r111_non_resident_interest_exp;
	}
	public void setR111_non_resident_interest_exp(BigDecimal r111_non_resident_interest_exp) {
		this.r111_non_resident_interest_exp = r111_non_resident_interest_exp;
	}
	public String getR111_product2() {
		return r111_product2;
	}
	public void setR111_product2(String r111_product2) {
		this.r111_product2 = r111_product2;
	}
	public BigDecimal getR111_resident_credit_exp() {
		return r111_resident_credit_exp;
	}
	public void setR111_resident_credit_exp(BigDecimal r111_resident_credit_exp) {
		this.r111_resident_credit_exp = r111_resident_credit_exp;
	}
	public BigDecimal getR111_non_resident_credit_exp() {
		return r111_non_resident_credit_exp;
	}
	public void setR111_non_resident_credit_exp(BigDecimal r111_non_resident_credit_exp) {
		this.r111_non_resident_credit_exp = r111_non_resident_credit_exp;
	}
	public String getR112_product1() {
		return r112_product1;
	}
	public void setR112_product1(String r112_product1) {
		this.r112_product1 = r112_product1;
	}
	public BigDecimal getR112_resident_interest_exp() {
		return r112_resident_interest_exp;
	}
	public void setR112_resident_interest_exp(BigDecimal r112_resident_interest_exp) {
		this.r112_resident_interest_exp = r112_resident_interest_exp;
	}
	public BigDecimal getR112_non_resident_interest_exp() {
		return r112_non_resident_interest_exp;
	}
	public void setR112_non_resident_interest_exp(BigDecimal r112_non_resident_interest_exp) {
		this.r112_non_resident_interest_exp = r112_non_resident_interest_exp;
	}
	public String getR112_product2() {
		return r112_product2;
	}
	public void setR112_product2(String r112_product2) {
		this.r112_product2 = r112_product2;
	}
	public BigDecimal getR112_resident_credit_exp() {
		return r112_resident_credit_exp;
	}
	public void setR112_resident_credit_exp(BigDecimal r112_resident_credit_exp) {
		this.r112_resident_credit_exp = r112_resident_credit_exp;
	}
	public BigDecimal getR112_non_resident_credit_exp() {
		return r112_non_resident_credit_exp;
	}
	public void setR112_non_resident_credit_exp(BigDecimal r112_non_resident_credit_exp) {
		this.r112_non_resident_credit_exp = r112_non_resident_credit_exp;
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
	public BRF003_ENTITY() {
		super();
		// TODO Auto-generated constructor stub
	}
}
