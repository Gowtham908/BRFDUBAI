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
@Table(name="BRF37_SUMMARYTABLE")
public class BRF37{
	
	private String	r11_demand_deposits;
	private BigDecimal	r11_aed;
	private BigDecimal	r11_fcy;
	private BigDecimal	r11_total;
	private BigDecimal	r11_commercial;
	private BigDecimal	r11_gre;
	private BigDecimal	r11_fdbi;
	private BigDecimal	r11_sme;
	private BigDecimal	r11_individual;
	private String	r12_demand_deposits1;
	private BigDecimal	r12_aed;
	private BigDecimal	r12_fcy;
	private BigDecimal	r12_total;
	private BigDecimal	r12_commercial;
	private BigDecimal	r12_gre;
	private BigDecimal	r12_fdbi;
	private BigDecimal	r12_sme;
	private BigDecimal	r12_individual;
	private String	r13_demand_deposits2;
	private BigDecimal	r13_aed;
	private BigDecimal	r13_fcy;
	private BigDecimal	r13_total;
	private BigDecimal	r13_commercial;
	private BigDecimal	r13_gre;
	private BigDecimal	r13_fdbi;
	private BigDecimal	r13_sme;
	private BigDecimal	r13_individual;
	private String	r14_demand_deposits3;
	private BigDecimal	r14_aed;
	private BigDecimal	r14_fcy;
	private BigDecimal	r14_total;
	private BigDecimal	r14_commercial;
	private BigDecimal	r14_gre;
	private BigDecimal	r14_fdbi;
	private BigDecimal	r14_sme;
	private BigDecimal	r14_individual;
	private String	r15_demand_deposits4;
	private BigDecimal	r15_aed;
	private BigDecimal	r15_fcy;
	private BigDecimal	r15_total;
	private BigDecimal	r15_commercial;
	private BigDecimal	r15_gre;
	private BigDecimal	r15_fdbi;
	private BigDecimal	r15_sme;
	private BigDecimal	r15_individual;
	private String	r16_time_deposits;
	private BigDecimal	r16_aed;
	private BigDecimal	r16_fcy;
	private BigDecimal	r16_total;
	private BigDecimal	r16_commercial;
	private BigDecimal	r16_gre;
	private BigDecimal	r16_fdbi;
	private BigDecimal	r16_sme;
	private BigDecimal	r16_individual;
	private String	r17_time_deposits1;
	private BigDecimal	r17_aed;
	private BigDecimal	r17_fcy;
	private BigDecimal	r17_total;
	private BigDecimal	r17_commercial;
	private BigDecimal	r17_gre;
	private BigDecimal	r17_fdbi;
	private BigDecimal	r17_sme;
	private BigDecimal	r17_individual;
	private String	r18_time_deposits2;
	private BigDecimal	r18_aed;
	private BigDecimal	r18_fcy;
	private BigDecimal	r18_total;
	private BigDecimal	r18_commercial;
	private BigDecimal	r18_gre;
	private BigDecimal	r18_fdbi;
	private BigDecimal	r18_sme;
	private BigDecimal	r18_individual;
	private String	r19_time_deposits3;
	private BigDecimal	r19_aed;
	private BigDecimal	r19_fcy;
	private BigDecimal	r19_total;
	private BigDecimal	r19_commercial;
	private BigDecimal	r19_gre;
	private BigDecimal	r19_fdbi;
	private BigDecimal	r19_sme;
	private BigDecimal	r19_individual;
	private String	r20_time_deposits4;
	private BigDecimal	r20_aed;
	private BigDecimal	r20_fcy;
	private BigDecimal	r20_total;
	private BigDecimal	r20_commercial;
	private BigDecimal	r20_gre;
	private BigDecimal	r20_fdbi;
	private BigDecimal	r20_sme;
	private BigDecimal	r20_individual;
	private String	r21_time_deposits5;
	private BigDecimal	r21_aed;
	private BigDecimal	r21_fcy;
	private BigDecimal	r21_total;
	private BigDecimal	r21_commercial;
	private BigDecimal	r21_gre;
	private BigDecimal	r21_fdbi;
	private BigDecimal	r21_sme;
	private BigDecimal	r21_individual;
	private String	r22_time_deposits6;
	private BigDecimal	r22_aed;
	private BigDecimal	r22_fcy;
	private BigDecimal	r22_total;
	private BigDecimal	r22_commercial;
	private BigDecimal	r22_gre;
	private BigDecimal	r22_fdbi;
	private BigDecimal	r22_sme;
	private BigDecimal	r22_individual;
	private String	r23_time_deposits7;
	private BigDecimal	r23_aed;
	private BigDecimal	r23_fcy;
	private BigDecimal	r23_total;
	private BigDecimal	r23_commercial;
	private BigDecimal	r23_gre;
	private BigDecimal	r23_fdbi;
	private BigDecimal	r23_sme;
	private BigDecimal	r23_individual;
	private String	r24_time_deposits8;
	private BigDecimal	r24_aed;
	private BigDecimal	r24_fcy;
	private BigDecimal	r24_total;
	private BigDecimal	r24_commercial;
	private BigDecimal	r24_gre;
	private BigDecimal	r24_fdbi;
	private BigDecimal	r24_sme;
	private BigDecimal	r24_individual;
	private String	r25_time_deposits9;
	private BigDecimal	r25_aed;
	private BigDecimal	r25_fcy;
	private BigDecimal	r25_total;
	private BigDecimal	r25_commercial;
	private BigDecimal	r25_gre;
	private BigDecimal	r25_fdbi;
	private BigDecimal	r25_sme;
	private BigDecimal	r25_individual;
	private String	r26_time_deposits10;
	private BigDecimal	r26_aed;
	private BigDecimal	r26_fcy;
	private BigDecimal	r26_total;
	private BigDecimal	r26_commercial;
	private BigDecimal	r26_gre;
	private BigDecimal	r26_fdbi;
	private BigDecimal	r26_sme;
	private BigDecimal	r26_individual;
	private String	r27_saving_deposits;
	private BigDecimal	r27_aed;
	private BigDecimal	r27_fcy;
	private BigDecimal	r27_total;
	private BigDecimal	r27_commercial;
	private BigDecimal	r27_gre;
	private BigDecimal	r27_fdbi;
	private BigDecimal	r27_sme;
	private BigDecimal	r27_individual;
	private String	r28_saving_deposits1;
	private BigDecimal	r28_aed;
	private BigDecimal	r28_fcy;
	private BigDecimal	r28_total;
	private BigDecimal	r28_commercial;
	private BigDecimal	r28_gre;
	private BigDecimal	r28_fdbi;
	private BigDecimal	r28_sme;
	private BigDecimal	r28_individual;
	private String	r29_saving_deposits2;
	private BigDecimal	r29_aed;
	private BigDecimal	r29_fcy;
	private BigDecimal	r29_total;
	private BigDecimal	r29_commercial;
	private BigDecimal	r29_gre;
	private BigDecimal	r29_fdbi;
	private BigDecimal	r29_sme;
	private BigDecimal	r29_individual;
	private String	r30_saving_deposits3;
	private BigDecimal	r30_aed;
	private BigDecimal	r30_fcy;
	private BigDecimal	r30_total;
	private BigDecimal	r30_commercial;
	private BigDecimal	r30_gre;
	private BigDecimal	r30_fdbi;
	private BigDecimal	r30_sme;
	private BigDecimal	r30_individual;
	private String	r31_saving_deposits4;
	private BigDecimal	r31_aed;
	private BigDecimal	r31_fcy;
	private BigDecimal	r31_total;
	private BigDecimal	r31_commercial;
	private BigDecimal	r31_gre;
	private BigDecimal	r31_fdbi;
	private BigDecimal	r31_sme;
	private BigDecimal	r31_individual;
	private String	r32_total_deposits;
	private BigDecimal	r32_aed;
	private BigDecimal	r32_fcy;
	private BigDecimal	r32_total;
	private BigDecimal	r32_commercial;
	private BigDecimal	r32_gre;
	private BigDecimal	r32_fdbi;
	private BigDecimal	r32_sme;
	private BigDecimal	r32_individual;
	private String	r33_loan;
	private BigDecimal	r33_aed;
	private BigDecimal	r33_fcy;
	private BigDecimal	r33_total;
	private BigDecimal	r33_commercial;
	private BigDecimal	r33_gre;
	private BigDecimal	r33_fdbi;
	private BigDecimal	r33_sme;
	private BigDecimal	r33_individual;
	private String	r34_loan;
	private BigDecimal	r34_aed;
	private BigDecimal	r34_fcy;
	private BigDecimal	r34_total;
	private BigDecimal	r34_commercial;
	private BigDecimal	r34_gre;
	private BigDecimal	r34_fdbi;
	private BigDecimal	r34_sme;
	private BigDecimal	r34_individual;
	private String	r35_loan1;
	private BigDecimal	r35_aed;
	private BigDecimal	r35_fcy;
	private BigDecimal	r35_total;
	private BigDecimal	r35_commercial;
	private BigDecimal	r35_gre;
	private BigDecimal	r35_fdbi;
	private BigDecimal	r35_sme;
	private BigDecimal	r35_individual;
	private String	r36_loan2;
	private BigDecimal	r36_aed;
	private BigDecimal	r36_fcy;
	private BigDecimal	r36_total;
	private BigDecimal	r36_commercial;
	private BigDecimal	r36_gre;
	private BigDecimal	r36_fdbi;
	private BigDecimal	r36_sme;
	private BigDecimal	r36_individual;
	private String	r37_loan3;
	private BigDecimal	r37_aed;
	private BigDecimal	r37_fcy;
	private BigDecimal	r37_total;
	private BigDecimal	r37_commercial;
	private BigDecimal	r37_gre;
	private BigDecimal	r37_fdbi;
	private BigDecimal	r37_sme;
	private BigDecimal	r37_individual;
	private String	r38_loan4;
	private BigDecimal	r38_aed;
	private BigDecimal	r38_fcy;
	private BigDecimal	r38_total;
	private BigDecimal	r38_commercial;
	private BigDecimal	r38_gre;
	private BigDecimal	r38_fdbi;
	private BigDecimal	r38_sme;
	private BigDecimal	r38_individual;
	private String	r39_loan5;
	private BigDecimal	r39_aed;
	private BigDecimal	r39_fcy;
	private BigDecimal	r39_total;
	private BigDecimal	r39_commercial;
	private BigDecimal	r39_gre;
	private BigDecimal	r39_fdbi;
	private BigDecimal	r39_sme;
	private BigDecimal	r39_individual;
	private String	r40_loan6;
	private BigDecimal	r40_aed;
	private BigDecimal	r40_fcy;
	private BigDecimal	r40_total;
	private BigDecimal	r40_commercial;
	private BigDecimal	r40_gre;
	private BigDecimal	r40_fdbi;
	private BigDecimal	r40_sme;
	private BigDecimal	r40_individual;
	private String	r41_loan7;
	private BigDecimal	r41_aed;
	private BigDecimal	r41_fcy;
	private BigDecimal	r41_total;
	private BigDecimal	r41_commercial;
	private BigDecimal	r41_gre;
	private BigDecimal	r41_fdbi;
	private BigDecimal	r41_sme;
	private BigDecimal	r41_individual;
	private String	r42_loan8;
	private BigDecimal	r42_aed;
	private BigDecimal	r42_fcy;
	private BigDecimal	r42_total;
	private BigDecimal	r42_commercial;
	private BigDecimal	r42_gre;
	private BigDecimal	r42_fdbi;
	private BigDecimal	r42_sme;
	private BigDecimal	r42_individual;
	private String	r43_loan9;
	private BigDecimal	r43_aed;
	private BigDecimal	r43_fcy;
	private BigDecimal	r43_total;
	private BigDecimal	r43_commercial;
	private BigDecimal	r43_gre;
	private BigDecimal	r43_fdbi;
	private BigDecimal	r43_sme;
	private BigDecimal	r43_individual;
	private String	r44_loan10;
	private BigDecimal	r44_aed;
	private BigDecimal	r44_fcy;
	private BigDecimal	r44_total;
	private BigDecimal	r44_commercial;
	private BigDecimal	r44_gre;
	private BigDecimal	r44_fdbi;
	private BigDecimal	r44_sme;
	private BigDecimal	r44_individual;
	private String	r45_credit_card;
	private BigDecimal	r45_aed;
	private BigDecimal	r45_fcy;
	private BigDecimal	r45_total;
	private BigDecimal	r45_commercial;
	private BigDecimal	r45_gre;
	private BigDecimal	r45_fdbi;
	private BigDecimal	r45_sme;
	private BigDecimal	r45_individual;
	private String	r46_credit_card1;
	private BigDecimal	r46_aed;
	private BigDecimal	r46_fcy;
	private BigDecimal	r46_total;
	private BigDecimal	r46_commercial;
	private BigDecimal	r46_gre;
	private BigDecimal	r46_fdbi;
	private BigDecimal	r46_sme;
	private BigDecimal	r46_individual;
	private String	r47_credit_card2;
	private BigDecimal	r47_aed;
	private BigDecimal	r47_fcy;
	private BigDecimal	r47_total;
	private BigDecimal	r47_commercial;
	private BigDecimal	r47_gre;
	private BigDecimal	r47_fdbi;
	private BigDecimal	r47_sme;
	private BigDecimal	r47_individual;
	private String	r48_credit_card3;
	private BigDecimal	r48_aed;
	private BigDecimal	r48_fcy;
	private BigDecimal	r48_total;
	private BigDecimal	r48_commercial;
	private BigDecimal	r48_gre;
	private BigDecimal	r48_fdbi;
	private BigDecimal	r48_sme;
	private BigDecimal	r48_individual;
	private String	r49_credit_card4;
	private BigDecimal	r49_aed;
	private BigDecimal	r49_fcy;
	private BigDecimal	r49_total;
	private BigDecimal	r49_commercial;
	private BigDecimal	r49_gre;
	private BigDecimal	r49_fdbi;
	private BigDecimal	r49_sme;
	private BigDecimal	r49_individual;
	private String	r50_credit_card5;
	private BigDecimal	r50_aed;
	private BigDecimal	r50_fcy;
	private BigDecimal	r50_total;
	private BigDecimal	r50_commercial;
	private BigDecimal	r50_gre;
	private BigDecimal	r50_fdbi;
	private BigDecimal	r50_sme;
	private BigDecimal	r50_individual;
	private String	r51_credit_card6;
	private BigDecimal	r51_aed;
	private BigDecimal	r51_fcy;
	private BigDecimal	r51_total;
	private BigDecimal	r51_commercial;
	private BigDecimal	r51_gre;
	private BigDecimal	r51_fdbi;
	private BigDecimal	r51_sme;
	private BigDecimal	r51_individual;
	private String	r52_credit_card7;
	private BigDecimal	r52_aed;
	private BigDecimal	r52_fcy;
	private BigDecimal	r52_total;
	private BigDecimal	r52_commercial;
	private BigDecimal	r52_gre;
	private BigDecimal	r52_fdbi;
	private BigDecimal	r52_sme;
	private BigDecimal	r52_individual;
	private String	r53_non_performing_loans;
	private BigDecimal	r53_aed;
	private BigDecimal	r53_fcy;
	private BigDecimal	r53_total;
	private BigDecimal	r53_commercial;
	private BigDecimal	r53_gre;
	private BigDecimal	r53_fdbi;
	private BigDecimal	r53_sme;
	private BigDecimal	r53_individual;
	private String	r54_non_performing_loans1;
	private BigDecimal	r54_aed;
	private BigDecimal	r54_fcy;
	private BigDecimal	r54_total;
	private BigDecimal	r54_commercial;
	private BigDecimal	r54_gre;
	private BigDecimal	r54_fdbi;
	private BigDecimal	r54_sme;
	private BigDecimal	r54_individual;
	private String	r55_non_performing_loans2;
	private BigDecimal	r55_aed;
	private BigDecimal	r55_fcy;
	private BigDecimal	r55_total;
	private BigDecimal	r55_commercial;
	private BigDecimal	r55_gre;
	private BigDecimal	r55_fdbi;
	private BigDecimal	r55_sme;
	private BigDecimal	r55_individual;
	private String	r56_non_performing_loans3;
	private BigDecimal	r56_aed;
	private BigDecimal	r56_fcy;
	private BigDecimal	r56_total;
	private BigDecimal	r56_commercial;
	private BigDecimal	r56_gre;
	private BigDecimal	r56_fdbi;
	private BigDecimal	r56_sme;
	private BigDecimal	r56_individual;
	private String	r57_period_wise;
	private BigDecimal	r57_minimum_rate;
	private BigDecimal	r57_maximum_rate;
	private BigDecimal	r57_average_rate;
	private BigDecimal	r57_minimum_rate_inidiv;
	private BigDecimal	r57_maximum_rate_inidiv;
	private BigDecimal	r57_average_rate_inidiv;
	private String	r58_period_wise1;
	private BigDecimal	r58_minimum_rate;
	private BigDecimal	r58_maximum_rate;
	private BigDecimal	r58_average_rate;
	private BigDecimal	r58_minimum_rate_inidiv;
	private BigDecimal	r58_maximum_rate_inidiv;
	private BigDecimal	r58_average_rate_inidiv;
	private String	r59_period_wise2;
	private BigDecimal	r59_minimum_rate;
	private BigDecimal	r59_maximum_rate;
	private BigDecimal	r59_average_rate;
	private BigDecimal	r59_minimum_rate_inidiv;
	private BigDecimal	r59_maximum_rate_inidiv;
	private BigDecimal	r59_average_rate_inidiv;
	private String	r60_period_wise3;
	private BigDecimal	r60_minimum_rate;
	private BigDecimal	r60_maximum_rate;
	private BigDecimal	r60_average_rate;
	private BigDecimal	r60_minimum_rate_inidiv;
	private BigDecimal	r60_maximum_rate_inidiv;
	private BigDecimal	r60_average_rate_inidiv;
	private String	r61_period_wise4;
	private BigDecimal	r61_minimum_rate;
	private BigDecimal	r61_maximum_rate;
	private BigDecimal	r61_average_rate;
	private BigDecimal	r61_minimum_rate_inidiv;
	private BigDecimal	r61_maximum_rate_inidiv;
	private BigDecimal	r61_average_rate_inidiv;
	private String	r62_period_wise5;
	private BigDecimal	r62_minimum_rate;
	private BigDecimal	r62_maximum_rate;
	private BigDecimal	r62_average_rate;
	private BigDecimal	r62_minimum_rate_inidiv;
	private BigDecimal	r62_maximum_rate_inidiv;
	private BigDecimal	r62_average_rate_inidiv;
	private String	r63_period_wise6;
	private BigDecimal	r63_minimum_rate;
	private BigDecimal	r63_maximum_rate;
	private BigDecimal	r63_average_rate;
	private BigDecimal	r63_minimum_rate_inidiv;
	private BigDecimal	r63_maximum_rate_inidiv;
	private BigDecimal	r63_average_rate_inidiv;
	private String	r64_period_wise7;
	private BigDecimal	r64_minimum_rate;
	private BigDecimal	r64_maximum_rate;
	private BigDecimal	r64_average_rate;
	private BigDecimal	r64_minimum_rate_inidiv;
	private BigDecimal	r64_maximum_rate_inidiv;
	private BigDecimal	r64_average_rate_inidiv;
	private String	r65_period_wise_saving;
	private BigDecimal	r65_minimum_rate;
	private BigDecimal	r65_maximum_rate;
	private BigDecimal	r65_average_rate;
	private BigDecimal	r65_minimum_rate_inidiv;
	private BigDecimal	r65_maximum_rate_inidiv;
	private BigDecimal	r65_average_rate_inidiv;
	private String	r66_period_wise_call;
	private BigDecimal	r66_minimum_rate;
	private BigDecimal	r66_maximum_rate;
	private BigDecimal	r66_average_rate;
	private BigDecimal	r66_minimum_rate_inidiv;
	private BigDecimal	r66_maximum_rate_inidiv;
	private BigDecimal	r66_average_rate_inidiv;
	private String	r67_period_wise_current;
	private BigDecimal	r67_minimum_rate;
	private BigDecimal	r67_maximum_rate;
	private BigDecimal	r67_average_rate;
	private BigDecimal	r67_minimum_rate_inidiv;
	private BigDecimal	r67_maximum_rate_inidiv;
	private BigDecimal	r67_average_rate_inidiv;
	private String	r68_period_wise_distribution;
	private BigDecimal	r68_minimum_rate;
	private BigDecimal	r68_maximum_rate;
	private BigDecimal	r68_average_rate;
	private BigDecimal	r68_minimum_rate_inidiv;
	private BigDecimal	r68_maximum_rate_inidiv;
	private BigDecimal	r68_average_rate_inidiv;
	private String	r69_period_wise_distribution1;
	private BigDecimal	r69_minimum_rate;
	private BigDecimal	r69_maximum_rate;
	private BigDecimal	r69_average_rate;
	private BigDecimal	r69_minimum_rate_inidiv;
	private BigDecimal	r69_maximum_rate_inidiv;
	private BigDecimal	r69_average_rate_inidiv;
	private String	r70_period_wise_distribution2;
	private BigDecimal	r70_minimum_rate;
	private BigDecimal	r70_maximum_rate;
	private BigDecimal	r70_average_rate;
	private BigDecimal	r70_minimum_rate_inidiv;
	private BigDecimal	r70_maximum_rate_inidiv;
	private BigDecimal	r70_average_rate_inidiv;
	private String	r71_period_wise_distribution3;
	private BigDecimal	r71_minimum_rate;
	private BigDecimal	r71_maximum_rate;
	private BigDecimal	r71_average_rate;
	private BigDecimal	r71_minimum_rate_inidiv;
	private BigDecimal	r71_maximum_rate_inidiv;
	private BigDecimal	r71_average_rate_inidiv;
	private String	r72_period_wise_distribution4;
	private BigDecimal	r72_minimum_rate;
	private BigDecimal	r72_maximum_rate;
	private BigDecimal	r72_average_rate;
	private BigDecimal	r72_minimum_rate_inidiv;
	private BigDecimal	r72_maximum_rate_inidiv;
	private BigDecimal	r72_average_rate_inidiv;
	private String	r73_period_wise_distribution5;
	private BigDecimal	r73_minimum_rate;
	private BigDecimal	r73_maximum_rate;
	private BigDecimal	r73_average_rate;
	private BigDecimal	r73_minimum_rate_inidiv;
	private BigDecimal	r73_maximum_rate_inidiv;
	private BigDecimal	r73_average_rate_inidiv;
	private String	r74_period_wise_distribution6;
	private BigDecimal	r74_minimum_rate;
	private BigDecimal	r74_maximum_rate;
	private BigDecimal	r74_average_rate;
	private BigDecimal	r74_minimum_rate_inidiv;
	private BigDecimal	r74_maximum_rate_inidiv;
	private BigDecimal	r74_average_rate_inidiv;
	private String	r75_period_wise_distribution7;
	private BigDecimal	r75_minimum_rate;
	private BigDecimal	r75_maximum_rate;
	private BigDecimal	r75_average_rate;
	private BigDecimal	r75_minimum_rate_inidiv;
	private BigDecimal	r75_maximum_rate_inidiv;
	private BigDecimal	r75_average_rate_inidiv;
	private String	r76_period_wise_distribution_saving;
	private BigDecimal	r76_minimum_rate;
	private BigDecimal	r76_maximum_rate;
	private BigDecimal	r76_average_rate;
	private BigDecimal	r76_minimum_rate_inidiv;
	private BigDecimal	r76_maximum_rate_inidiv;
	private BigDecimal	r76_average_rate_inidiv;
	private String	r77_period_wise_distribution_call;
	private BigDecimal	r77_minimum_rate;
	private BigDecimal	r77_maximum_rate;
	private BigDecimal	r77_average_rate;
	private BigDecimal	r77_minimum_rate_inidiv;
	private BigDecimal	r77_maximum_rate_inidiv;
	private BigDecimal	r77_average_rate_inidiv;
	private String	r78_period_wise_distribution_current;
	private BigDecimal	r78_minimum_rate;
	private BigDecimal	r78_maximum_rate;
	private BigDecimal	r78_average_rate;
	private BigDecimal	r78_minimum_rate_inidiv;
	private BigDecimal	r78_maximum_rate_inidiv;
	private BigDecimal	r78_average_rate_inidiv;
	private String	r79_period_wise_week;
	private BigDecimal	r79_minimum_rate;
	private BigDecimal	r79_maximum_rate;
	private BigDecimal	r79_average_rate;
	private String	r80_period_wise_1month;
	private BigDecimal	r80_minimum_rate;
	private BigDecimal	r80_maximum_rate;
	private BigDecimal	r80_average_rate;
	private String	r81_period_wise_3month;
	private BigDecimal	r81_minimum_rate;
	private BigDecimal	r81_maximum_rate;
	private BigDecimal	r81_average_rate;
	private String	r82_period_wise_6month;
	private BigDecimal	r82_minimum_rate;
	private BigDecimal	r82_maximum_rate;
	private BigDecimal	r82_average_rate;
	private String	r83_period_wise_year;
	private BigDecimal	r83_minimum_rate;
	private BigDecimal	r83_maximum_rate;
	private BigDecimal	r83_average_rate;
	private String	r84_interest_rate;
	private BigDecimal	r84_minimum_rate;
	private BigDecimal	r84_maximum_rate;
	private BigDecimal	r84_average_rate;
	private String	r85_interest_profit;
	private BigDecimal	r85_minimum_rate;
	private BigDecimal	r85_maximum_rate;
	private BigDecimal	r85_average_rate;
	private String	r86_aed_50k;
	private BigDecimal	r86_minimum_rate;
	private BigDecimal	r86_maximum_rate;
	private BigDecimal	r86_average_rate;
	private String	r87_aed_100k;
	private BigDecimal	r87_minimum_rate;
	private BigDecimal	r87_maximum_rate;
	private BigDecimal	r87_average_rate;
	private String	r88_aed_200k;
	private BigDecimal	r88_minimum_rate;
	private BigDecimal	r88_maximum_rate;
	private BigDecimal	r88_average_rate;
	private String	r89_above_200k;
	private BigDecimal	r89_minimum_rate;
	private BigDecimal	r89_maximum_rate;
	private BigDecimal	r89_average_rate;
	private String	r90_interest_profit;
	private BigDecimal	r90_minimum_rate;
	private BigDecimal	r90_maximum_rate;
	private BigDecimal	r90_average_rate;
	private String	r91_aed_50k;
	private BigDecimal	r91_minimum_rate;
	private BigDecimal	r91_maximum_rate;
	private BigDecimal	r91_average_rate;
	private String	r92_aed_100k;
	private BigDecimal	r92_minimum_rate;
	private BigDecimal	r92_maximum_rate;
	private BigDecimal	r92_average_rate;
	private String	r93_aed_200k;
	private BigDecimal	r93_minimum_rate;
	private BigDecimal	r93_maximum_rate;
	private BigDecimal	r93_average_rate;
	private String	r94_above_200k;
	private BigDecimal	r94_minimum_rate;
	private BigDecimal	r94_maximum_rate;
	private BigDecimal	r94_average_rate;
	private String	r95_interest_rate2;
	private BigDecimal	r95_minimum_rate;
	private BigDecimal	r95_maximum_rate;
	private BigDecimal	r95_average_rate;
	private String	r96_interest_profit2;
	private BigDecimal	r96_minimum_rate;
	private BigDecimal	r96_maximum_rate;
	private BigDecimal	r96_average_rate2;
	private String	r97_aed_50k;
	private BigDecimal	r97_minimum_rate;
	private BigDecimal	r97_maximum_rate;
	private BigDecimal	r97_average_rate;
	private String	r98_aed_100k2;
	private BigDecimal	r98_minimum_rate;
	private BigDecimal	r98_maximum_rate;
	private BigDecimal	r98_average_rate;
	private String	r99_aed_200k2;
	private BigDecimal	r99_minimum_rate;
	private BigDecimal	r99_maximum_rate;
	private BigDecimal	r99_average_rate;
	private String	r100_above_200k2;
	private BigDecimal	r100_minimum_rate;
	private BigDecimal	r100_maximum_rate;
	private BigDecimal	r100_average_rate;
	private String	r101_interest_rate3;
	private BigDecimal	r101_minimum_rate;
	private BigDecimal	r101_maximum_rate;
	private BigDecimal	r101_average_rate;
	private String	r102_interest_profit3;
	private BigDecimal	r102_minimum_rate;
	private BigDecimal	r102_maximum_rate;
	private BigDecimal	r102_average_rate;
	private String	r103_aed_50k3;
	private BigDecimal	r103_minimum_rate;
	private BigDecimal	r103_maximum_rate;
	private BigDecimal	r103_average_rate;
	private String	r104_aed_100k3;
	private BigDecimal	r104_minimum_rate;
	private BigDecimal	r104_maximum_rate;
	private BigDecimal	r104_average_rate;
	private String	r105_aed_200k3;
	private BigDecimal	r105_minimum_rate;
	private BigDecimal	r105_maximum_rate;
	private BigDecimal	r105_average_rate;
	private String	r106_above_200k3;
	private BigDecimal	r106_minimum_rate;
	private BigDecimal	r106_maximum_rate;
	private BigDecimal	r106_average_rate;
	private String	r107_interest_rate4;
	private BigDecimal	r107_minimum_rate;
	private BigDecimal	r107_maximum_rate;
	private BigDecimal	r107_average_rate;
	private String	r108_interest_profit4;
	private BigDecimal	r108_minimum_rate;
	private BigDecimal	r108_maximum_rate;
	private BigDecimal	r108_average_rate;
	private String	r109_aed_50k4;
	private BigDecimal	r109_minimum_rate;
	private BigDecimal	r109_maximum_rate;
	private BigDecimal	r109_average_rate;
	private String	r110_aed_100k4;
	private BigDecimal	r110_minimum_rate;
	private BigDecimal	r110_maximum_rate;
	private BigDecimal	r110_average_rate;
	private String	r111_aed_200k4;
	private BigDecimal	r111_minimum_rate;
	private BigDecimal	r111_maximum_rate;
	private BigDecimal	r111_average_rate;
	private String	r112_above_200k4;
	private BigDecimal	r112_minimum_rate;
	private BigDecimal	r112_maximum_rate;
	private BigDecimal	r112_average_rate;
	private String	r113_interest_rate5;
	private BigDecimal	r113_minimum_rate;
	private BigDecimal	r113_maximum_rate;
	private BigDecimal	r113_average_rate;
	private String	r114_interest_profit5;
	private BigDecimal	r114_minimum_rate;
	private BigDecimal	r114_maximum_rate;
	private BigDecimal	r114_average_rate;
	private String	r115_aed_50k5;
	private BigDecimal	r115_minimum_rate;
	private BigDecimal	r115_maximum_rate;
	private BigDecimal	r115_average_rate;
	private String	r116_aed_100k5;
	private BigDecimal	r116_minimum_rate;
	private BigDecimal	r116_maximum_rate;
	private BigDecimal	r116_average_rate;
	private String	r117_aed_200k5;
	private BigDecimal	r117_minimum_rate;
	private BigDecimal	r117_maximum_rate;
	private BigDecimal	r117_average_rate;
	private String	r118_above_200k5;
	private BigDecimal	r118_minimum_rate;
	private BigDecimal	r118_maximum_rate;
	private BigDecimal	r118_average_rate;
	private String	r119_interest_rate6;
	private BigDecimal	r119_minimum_rate;
	private BigDecimal	r119_maximum_rate;
	private BigDecimal	r119_average_rate;
	private String	r120_interest_profit6;
	private BigDecimal	r120_minimum_rate;
	private BigDecimal	r120_maximum_rate;
	private BigDecimal	r120_average_rate;
	private String	r121_aed_50k6;
	private BigDecimal	r121_minimum_rate;
	private BigDecimal	r121_maximum_rate;
	private BigDecimal	r121_average_rate;
	private String	r122_aed_100k6;
	private BigDecimal	r122_minimum_rate;
	private BigDecimal	r122_maximum_rate;
	private BigDecimal	r122_average_rate;
	private String	r123_aed_200k6;
	private BigDecimal	r123_minimum_rate;
	private BigDecimal	r123_maximum_rate;
	private BigDecimal	r123_average_rate;
	private String	r124_above_200k6;
	private BigDecimal	r124_minimum_rate;
	private BigDecimal	r124_maximum_rate;
	private BigDecimal	r124_average_rate;
	private String	r125_interest_rate7;
	private BigDecimal	r125_minimum_rate;
	private BigDecimal	r125_maximum_rate;
	private BigDecimal	r125_average_rate;
	private String	r126_interest_profit7;
	private BigDecimal	r126_minimum_rate;
	private BigDecimal	r126_maximum_rate;
	private BigDecimal	r126_average_rate;
	private String	r127_aed_50k7;
	private BigDecimal	r127_minimum_rate;
	private BigDecimal	r127_maximum_rate;
	private BigDecimal	r127_average_rate;
	private String	r128_aed_100k7;
	private BigDecimal	r128_minimum_rate;
	private BigDecimal	r128_maximum_rate;
	private BigDecimal	r128_average_rate;
	private String	r129_aed_200k7;
	private BigDecimal	r129_minimum_rate;
	private BigDecimal	r129_maximum_rate;
	private BigDecimal	r129_average_rate;
	private String	r130_interest_rate8;
	private BigDecimal	r130_minimum_rate;
	private BigDecimal	r130_maximum_rate;
	private BigDecimal	r130_average_rate;
	private String	r131_interest_profit8;
	private BigDecimal	r131_minimum_rate;
	private BigDecimal	r131_maximum_rate;
	private BigDecimal	r131_average_rate;
	private String	r132_aed_50k8;
	private BigDecimal	r132_minimum_rate;
	private BigDecimal	r132_maximum_rate;
	private BigDecimal	r132_average_rate;
	private String	r133_aed_100k8;
	private BigDecimal	r133_minimum_rate;
	private BigDecimal	r133_maximum_rate;
	private BigDecimal	r133_average_rate;
	private String	r134_aed_200k8;
	private BigDecimal	r134_minimum_rate;
	private BigDecimal	r134_maximum_rate;
	private BigDecimal	r134_average_rate;
	private String	r135_above_200k8;
	private BigDecimal	r135_minimum_rate;
	private BigDecimal	r135_maximum_rate;
	private BigDecimal	r135_average_rate;
	private String	r136_overdrafts;
	private BigDecimal	r136_minimum_rate;
	private BigDecimal	r136_maximum_rate;
	private BigDecimal	r136_average_rate;
	private BigDecimal	r136_federal;
	private BigDecimal	r136_gre;
	private BigDecimal	r136_nbfi;
	private BigDecimal	r136_sme;
	private String	r137_trade_bills;
	private BigDecimal	r137_minimum_rate;
	private BigDecimal	r137_maximum_rate;
	private BigDecimal	r137_average_rate;
	private BigDecimal	r137_federal;
	private BigDecimal	r137_gre;
	private BigDecimal	r137_nbfi;
	private BigDecimal	r137_sme;
	private String	r138_trade_loans;
	private BigDecimal	r138_minimum_rate;
	private BigDecimal	r138_maximum_rate;
	private BigDecimal	r138_average_rate;
	private BigDecimal	r138_federal;
	private BigDecimal	r138_gre;
	private BigDecimal	r138_nbfi;
	private BigDecimal	r138_sme;
	private String	r139_real_estate;
	private BigDecimal	r139_minimum_rate;
	private BigDecimal	r139_maximum_rate;
	private BigDecimal	r139_average_rate;
	private BigDecimal	r139_federal;
	private BigDecimal	r139_gre;
	private BigDecimal	r139_nbfi;
	private BigDecimal	r139_sme;
	private String	r140_trust_reciept;
	private BigDecimal	r140_minimum_rate;
	private BigDecimal	r140_maximum_rate;
	private BigDecimal	r140_average_rate;
	private BigDecimal	r140_federal;
	private BigDecimal	r140_gre;
	private BigDecimal	r140_nbfi;
	private BigDecimal	r140_sme;
	private String	r141_syndicated_loans;
	private BigDecimal	r141_minimum_rate;
	private BigDecimal	r141_maximum_rate;
	private BigDecimal	r141_average_rate;
	private BigDecimal	r141_federal;
	private BigDecimal	r141_gre;
	private BigDecimal	r141_nbfi;
	private BigDecimal	r141_sme;
	private String	r142_discount_rates;
	private BigDecimal	r142_minimum_rate;
	private BigDecimal	r142_maximum_rate;
	private BigDecimal	r142_average_rate;
	private BigDecimal	r142_federal;
	private BigDecimal	r142_gre;
	private BigDecimal	r142_nbfi;
	private BigDecimal	r142_sme;
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
	private String	r143_interest_rate;
	private BigDecimal	r143_maximum_rate;
	private BigDecimal	r143_minimum_rate;
	private BigDecimal	r143_average_rate;
	private String	r144_above_200k7;
	private BigDecimal	r144_minimum_rate;
	private BigDecimal	r144_maximum_rate;
	private BigDecimal	r144_average_rate;
	private String	repdesc;
	private String	frequency;
	public String getR11_demand_deposits() {
		return r11_demand_deposits;
	}
	public void setR11_demand_deposits(String r11_demand_deposits) {
		this.r11_demand_deposits = r11_demand_deposits;
	}
	public BigDecimal getR11_aed() {
		return r11_aed;
	}
	public void setR11_aed(BigDecimal r11_aed) {
		this.r11_aed = r11_aed;
	}
	public BigDecimal getR11_fcy() {
		return r11_fcy;
	}
	public void setR11_fcy(BigDecimal r11_fcy) {
		this.r11_fcy = r11_fcy;
	}
	public BigDecimal getR11_total() {
		return r11_total;
	}
	public void setR11_total(BigDecimal r11_total) {
		this.r11_total = r11_total;
	}
	public BigDecimal getR11_commercial() {
		return r11_commercial;
	}
	public void setR11_commercial(BigDecimal r11_commercial) {
		this.r11_commercial = r11_commercial;
	}
	public BigDecimal getR11_gre() {
		return r11_gre;
	}
	public void setR11_gre(BigDecimal r11_gre) {
		this.r11_gre = r11_gre;
	}
	public BigDecimal getR11_fdbi() {
		return r11_fdbi;
	}
	public void setR11_fdbi(BigDecimal r11_fdbi) {
		this.r11_fdbi = r11_fdbi;
	}
	public BigDecimal getR11_sme() {
		return r11_sme;
	}
	public void setR11_sme(BigDecimal r11_sme) {
		this.r11_sme = r11_sme;
	}
	public BigDecimal getR11_individual() {
		return r11_individual;
	}
	public void setR11_individual(BigDecimal r11_individual) {
		this.r11_individual = r11_individual;
	}
	public String getR12_demand_deposits1() {
		return r12_demand_deposits1;
	}
	public void setR12_demand_deposits1(String r12_demand_deposits1) {
		this.r12_demand_deposits1 = r12_demand_deposits1;
	}
	public BigDecimal getR12_aed() {
		return r12_aed;
	}
	public void setR12_aed(BigDecimal r12_aed) {
		this.r12_aed = r12_aed;
	}
	public BigDecimal getR12_fcy() {
		return r12_fcy;
	}
	public void setR12_fcy(BigDecimal r12_fcy) {
		this.r12_fcy = r12_fcy;
	}
	public BigDecimal getR12_total() {
		return r12_total;
	}
	public void setR12_total(BigDecimal r12_total) {
		this.r12_total = r12_total;
	}
	public BigDecimal getR12_commercial() {
		return r12_commercial;
	}
	public void setR12_commercial(BigDecimal r12_commercial) {
		this.r12_commercial = r12_commercial;
	}
	public BigDecimal getR12_gre() {
		return r12_gre;
	}
	public void setR12_gre(BigDecimal r12_gre) {
		this.r12_gre = r12_gre;
	}
	public BigDecimal getR12_fdbi() {
		return r12_fdbi;
	}
	public void setR12_fdbi(BigDecimal r12_fdbi) {
		this.r12_fdbi = r12_fdbi;
	}
	public BigDecimal getR12_sme() {
		return r12_sme;
	}
	public void setR12_sme(BigDecimal r12_sme) {
		this.r12_sme = r12_sme;
	}
	public BigDecimal getR12_individual() {
		return r12_individual;
	}
	public void setR12_individual(BigDecimal r12_individual) {
		this.r12_individual = r12_individual;
	}
	public String getR13_demand_deposits2() {
		return r13_demand_deposits2;
	}
	public void setR13_demand_deposits2(String r13_demand_deposits2) {
		this.r13_demand_deposits2 = r13_demand_deposits2;
	}
	public BigDecimal getR13_aed() {
		return r13_aed;
	}
	public void setR13_aed(BigDecimal r13_aed) {
		this.r13_aed = r13_aed;
	}
	public BigDecimal getR13_fcy() {
		return r13_fcy;
	}
	public void setR13_fcy(BigDecimal r13_fcy) {
		this.r13_fcy = r13_fcy;
	}
	public BigDecimal getR13_total() {
		return r13_total;
	}
	public void setR13_total(BigDecimal r13_total) {
		this.r13_total = r13_total;
	}
	public BigDecimal getR13_commercial() {
		return r13_commercial;
	}
	public void setR13_commercial(BigDecimal r13_commercial) {
		this.r13_commercial = r13_commercial;
	}
	public BigDecimal getR13_gre() {
		return r13_gre;
	}
	public void setR13_gre(BigDecimal r13_gre) {
		this.r13_gre = r13_gre;
	}
	public BigDecimal getR13_fdbi() {
		return r13_fdbi;
	}
	public void setR13_fdbi(BigDecimal r13_fdbi) {
		this.r13_fdbi = r13_fdbi;
	}
	public BigDecimal getR13_sme() {
		return r13_sme;
	}
	public void setR13_sme(BigDecimal r13_sme) {
		this.r13_sme = r13_sme;
	}
	public BigDecimal getR13_individual() {
		return r13_individual;
	}
	public void setR13_individual(BigDecimal r13_individual) {
		this.r13_individual = r13_individual;
	}
	public String getR14_demand_deposits3() {
		return r14_demand_deposits3;
	}
	public void setR14_demand_deposits3(String r14_demand_deposits3) {
		this.r14_demand_deposits3 = r14_demand_deposits3;
	}
	public BigDecimal getR14_aed() {
		return r14_aed;
	}
	public void setR14_aed(BigDecimal r14_aed) {
		this.r14_aed = r14_aed;
	}
	public BigDecimal getR14_fcy() {
		return r14_fcy;
	}
	public void setR14_fcy(BigDecimal r14_fcy) {
		this.r14_fcy = r14_fcy;
	}
	public BigDecimal getR14_total() {
		return r14_total;
	}
	public void setR14_total(BigDecimal r14_total) {
		this.r14_total = r14_total;
	}
	public BigDecimal getR14_commercial() {
		return r14_commercial;
	}
	public void setR14_commercial(BigDecimal r14_commercial) {
		this.r14_commercial = r14_commercial;
	}
	public BigDecimal getR14_gre() {
		return r14_gre;
	}
	public void setR14_gre(BigDecimal r14_gre) {
		this.r14_gre = r14_gre;
	}
	public BigDecimal getR14_fdbi() {
		return r14_fdbi;
	}
	public void setR14_fdbi(BigDecimal r14_fdbi) {
		this.r14_fdbi = r14_fdbi;
	}
	public BigDecimal getR14_sme() {
		return r14_sme;
	}
	public void setR14_sme(BigDecimal r14_sme) {
		this.r14_sme = r14_sme;
	}
	public BigDecimal getR14_individual() {
		return r14_individual;
	}
	public void setR14_individual(BigDecimal r14_individual) {
		this.r14_individual = r14_individual;
	}
	public String getR15_demand_deposits4() {
		return r15_demand_deposits4;
	}
	public void setR15_demand_deposits4(String r15_demand_deposits4) {
		this.r15_demand_deposits4 = r15_demand_deposits4;
	}
	public BigDecimal getR15_aed() {
		return r15_aed;
	}
	public void setR15_aed(BigDecimal r15_aed) {
		this.r15_aed = r15_aed;
	}
	public BigDecimal getR15_fcy() {
		return r15_fcy;
	}
	public void setR15_fcy(BigDecimal r15_fcy) {
		this.r15_fcy = r15_fcy;
	}
	public BigDecimal getR15_total() {
		return r15_total;
	}
	public void setR15_total(BigDecimal r15_total) {
		this.r15_total = r15_total;
	}
	public BigDecimal getR15_commercial() {
		return r15_commercial;
	}
	public void setR15_commercial(BigDecimal r15_commercial) {
		this.r15_commercial = r15_commercial;
	}
	public BigDecimal getR15_gre() {
		return r15_gre;
	}
	public void setR15_gre(BigDecimal r15_gre) {
		this.r15_gre = r15_gre;
	}
	public BigDecimal getR15_fdbi() {
		return r15_fdbi;
	}
	public void setR15_fdbi(BigDecimal r15_fdbi) {
		this.r15_fdbi = r15_fdbi;
	}
	public BigDecimal getR15_sme() {
		return r15_sme;
	}
	public void setR15_sme(BigDecimal r15_sme) {
		this.r15_sme = r15_sme;
	}
	public BigDecimal getR15_individual() {
		return r15_individual;
	}
	public void setR15_individual(BigDecimal r15_individual) {
		this.r15_individual = r15_individual;
	}
	public String getR16_time_deposits() {
		return r16_time_deposits;
	}
	public void setR16_time_deposits(String r16_time_deposits) {
		this.r16_time_deposits = r16_time_deposits;
	}
	public BigDecimal getR16_aed() {
		return r16_aed;
	}
	public void setR16_aed(BigDecimal r16_aed) {
		this.r16_aed = r16_aed;
	}
	public BigDecimal getR16_fcy() {
		return r16_fcy;
	}
	public void setR16_fcy(BigDecimal r16_fcy) {
		this.r16_fcy = r16_fcy;
	}
	public BigDecimal getR16_total() {
		return r16_total;
	}
	public void setR16_total(BigDecimal r16_total) {
		this.r16_total = r16_total;
	}
	public BigDecimal getR16_commercial() {
		return r16_commercial;
	}
	public void setR16_commercial(BigDecimal r16_commercial) {
		this.r16_commercial = r16_commercial;
	}
	public BigDecimal getR16_gre() {
		return r16_gre;
	}
	public void setR16_gre(BigDecimal r16_gre) {
		this.r16_gre = r16_gre;
	}
	public BigDecimal getR16_fdbi() {
		return r16_fdbi;
	}
	public void setR16_fdbi(BigDecimal r16_fdbi) {
		this.r16_fdbi = r16_fdbi;
	}
	public BigDecimal getR16_sme() {
		return r16_sme;
	}
	public void setR16_sme(BigDecimal r16_sme) {
		this.r16_sme = r16_sme;
	}
	public BigDecimal getR16_individual() {
		return r16_individual;
	}
	public void setR16_individual(BigDecimal r16_individual) {
		this.r16_individual = r16_individual;
	}
	public String getR17_time_deposits1() {
		return r17_time_deposits1;
	}
	public void setR17_time_deposits1(String r17_time_deposits1) {
		this.r17_time_deposits1 = r17_time_deposits1;
	}
	public BigDecimal getR17_aed() {
		return r17_aed;
	}
	public void setR17_aed(BigDecimal r17_aed) {
		this.r17_aed = r17_aed;
	}
	public BigDecimal getR17_fcy() {
		return r17_fcy;
	}
	public void setR17_fcy(BigDecimal r17_fcy) {
		this.r17_fcy = r17_fcy;
	}
	public BigDecimal getR17_total() {
		return r17_total;
	}
	public void setR17_total(BigDecimal r17_total) {
		this.r17_total = r17_total;
	}
	public BigDecimal getR17_commercial() {
		return r17_commercial;
	}
	public void setR17_commercial(BigDecimal r17_commercial) {
		this.r17_commercial = r17_commercial;
	}
	public BigDecimal getR17_gre() {
		return r17_gre;
	}
	public void setR17_gre(BigDecimal r17_gre) {
		this.r17_gre = r17_gre;
	}
	public BigDecimal getR17_fdbi() {
		return r17_fdbi;
	}
	public void setR17_fdbi(BigDecimal r17_fdbi) {
		this.r17_fdbi = r17_fdbi;
	}
	public BigDecimal getR17_sme() {
		return r17_sme;
	}
	public void setR17_sme(BigDecimal r17_sme) {
		this.r17_sme = r17_sme;
	}
	public BigDecimal getR17_individual() {
		return r17_individual;
	}
	public void setR17_individual(BigDecimal r17_individual) {
		this.r17_individual = r17_individual;
	}
	public String getR18_time_deposits2() {
		return r18_time_deposits2;
	}
	public void setR18_time_deposits2(String r18_time_deposits2) {
		this.r18_time_deposits2 = r18_time_deposits2;
	}
	public BigDecimal getR18_aed() {
		return r18_aed;
	}
	public void setR18_aed(BigDecimal r18_aed) {
		this.r18_aed = r18_aed;
	}
	public BigDecimal getR18_fcy() {
		return r18_fcy;
	}
	public void setR18_fcy(BigDecimal r18_fcy) {
		this.r18_fcy = r18_fcy;
	}
	public BigDecimal getR18_total() {
		return r18_total;
	}
	public void setR18_total(BigDecimal r18_total) {
		this.r18_total = r18_total;
	}
	public BigDecimal getR18_commercial() {
		return r18_commercial;
	}
	public void setR18_commercial(BigDecimal r18_commercial) {
		this.r18_commercial = r18_commercial;
	}
	public BigDecimal getR18_gre() {
		return r18_gre;
	}
	public void setR18_gre(BigDecimal r18_gre) {
		this.r18_gre = r18_gre;
	}
	public BigDecimal getR18_fdbi() {
		return r18_fdbi;
	}
	public void setR18_fdbi(BigDecimal r18_fdbi) {
		this.r18_fdbi = r18_fdbi;
	}
	public BigDecimal getR18_sme() {
		return r18_sme;
	}
	public void setR18_sme(BigDecimal r18_sme) {
		this.r18_sme = r18_sme;
	}
	public BigDecimal getR18_individual() {
		return r18_individual;
	}
	public void setR18_individual(BigDecimal r18_individual) {
		this.r18_individual = r18_individual;
	}
	public String getR19_time_deposits3() {
		return r19_time_deposits3;
	}
	public void setR19_time_deposits3(String r19_time_deposits3) {
		this.r19_time_deposits3 = r19_time_deposits3;
	}
	public BigDecimal getR19_aed() {
		return r19_aed;
	}
	public void setR19_aed(BigDecimal r19_aed) {
		this.r19_aed = r19_aed;
	}
	public BigDecimal getR19_fcy() {
		return r19_fcy;
	}
	public void setR19_fcy(BigDecimal r19_fcy) {
		this.r19_fcy = r19_fcy;
	}
	public BigDecimal getR19_total() {
		return r19_total;
	}
	public void setR19_total(BigDecimal r19_total) {
		this.r19_total = r19_total;
	}
	public BigDecimal getR19_commercial() {
		return r19_commercial;
	}
	public void setR19_commercial(BigDecimal r19_commercial) {
		this.r19_commercial = r19_commercial;
	}
	public BigDecimal getR19_gre() {
		return r19_gre;
	}
	public void setR19_gre(BigDecimal r19_gre) {
		this.r19_gre = r19_gre;
	}
	public BigDecimal getR19_fdbi() {
		return r19_fdbi;
	}
	public void setR19_fdbi(BigDecimal r19_fdbi) {
		this.r19_fdbi = r19_fdbi;
	}
	public BigDecimal getR19_sme() {
		return r19_sme;
	}
	public void setR19_sme(BigDecimal r19_sme) {
		this.r19_sme = r19_sme;
	}
	public BigDecimal getR19_individual() {
		return r19_individual;
	}
	public void setR19_individual(BigDecimal r19_individual) {
		this.r19_individual = r19_individual;
	}
	public String getR20_time_deposits4() {
		return r20_time_deposits4;
	}
	public void setR20_time_deposits4(String r20_time_deposits4) {
		this.r20_time_deposits4 = r20_time_deposits4;
	}
	public BigDecimal getR20_aed() {
		return r20_aed;
	}
	public void setR20_aed(BigDecimal r20_aed) {
		this.r20_aed = r20_aed;
	}
	public BigDecimal getR20_fcy() {
		return r20_fcy;
	}
	public void setR20_fcy(BigDecimal r20_fcy) {
		this.r20_fcy = r20_fcy;
	}
	public BigDecimal getR20_total() {
		return r20_total;
	}
	public void setR20_total(BigDecimal r20_total) {
		this.r20_total = r20_total;
	}
	public BigDecimal getR20_commercial() {
		return r20_commercial;
	}
	public void setR20_commercial(BigDecimal r20_commercial) {
		this.r20_commercial = r20_commercial;
	}
	public BigDecimal getR20_gre() {
		return r20_gre;
	}
	public void setR20_gre(BigDecimal r20_gre) {
		this.r20_gre = r20_gre;
	}
	public BigDecimal getR20_fdbi() {
		return r20_fdbi;
	}
	public void setR20_fdbi(BigDecimal r20_fdbi) {
		this.r20_fdbi = r20_fdbi;
	}
	public BigDecimal getR20_sme() {
		return r20_sme;
	}
	public void setR20_sme(BigDecimal r20_sme) {
		this.r20_sme = r20_sme;
	}
	public BigDecimal getR20_individual() {
		return r20_individual;
	}
	public void setR20_individual(BigDecimal r20_individual) {
		this.r20_individual = r20_individual;
	}
	public String getR21_time_deposits5() {
		return r21_time_deposits5;
	}
	public void setR21_time_deposits5(String r21_time_deposits5) {
		this.r21_time_deposits5 = r21_time_deposits5;
	}
	public BigDecimal getR21_aed() {
		return r21_aed;
	}
	public void setR21_aed(BigDecimal r21_aed) {
		this.r21_aed = r21_aed;
	}
	public BigDecimal getR21_fcy() {
		return r21_fcy;
	}
	public void setR21_fcy(BigDecimal r21_fcy) {
		this.r21_fcy = r21_fcy;
	}
	public BigDecimal getR21_total() {
		return r21_total;
	}
	public void setR21_total(BigDecimal r21_total) {
		this.r21_total = r21_total;
	}
	public BigDecimal getR21_commercial() {
		return r21_commercial;
	}
	public void setR21_commercial(BigDecimal r21_commercial) {
		this.r21_commercial = r21_commercial;
	}
	public BigDecimal getR21_gre() {
		return r21_gre;
	}
	public void setR21_gre(BigDecimal r21_gre) {
		this.r21_gre = r21_gre;
	}
	public BigDecimal getR21_fdbi() {
		return r21_fdbi;
	}
	public void setR21_fdbi(BigDecimal r21_fdbi) {
		this.r21_fdbi = r21_fdbi;
	}
	public BigDecimal getR21_sme() {
		return r21_sme;
	}
	public void setR21_sme(BigDecimal r21_sme) {
		this.r21_sme = r21_sme;
	}
	public BigDecimal getR21_individual() {
		return r21_individual;
	}
	public void setR21_individual(BigDecimal r21_individual) {
		this.r21_individual = r21_individual;
	}
	public String getR22_time_deposits6() {
		return r22_time_deposits6;
	}
	public void setR22_time_deposits6(String r22_time_deposits6) {
		this.r22_time_deposits6 = r22_time_deposits6;
	}
	public BigDecimal getR22_aed() {
		return r22_aed;
	}
	public void setR22_aed(BigDecimal r22_aed) {
		this.r22_aed = r22_aed;
	}
	public BigDecimal getR22_fcy() {
		return r22_fcy;
	}
	public void setR22_fcy(BigDecimal r22_fcy) {
		this.r22_fcy = r22_fcy;
	}
	public BigDecimal getR22_total() {
		return r22_total;
	}
	public void setR22_total(BigDecimal r22_total) {
		this.r22_total = r22_total;
	}
	public BigDecimal getR22_commercial() {
		return r22_commercial;
	}
	public void setR22_commercial(BigDecimal r22_commercial) {
		this.r22_commercial = r22_commercial;
	}
	public BigDecimal getR22_gre() {
		return r22_gre;
	}
	public void setR22_gre(BigDecimal r22_gre) {
		this.r22_gre = r22_gre;
	}
	public BigDecimal getR22_fdbi() {
		return r22_fdbi;
	}
	public void setR22_fdbi(BigDecimal r22_fdbi) {
		this.r22_fdbi = r22_fdbi;
	}
	public BigDecimal getR22_sme() {
		return r22_sme;
	}
	public void setR22_sme(BigDecimal r22_sme) {
		this.r22_sme = r22_sme;
	}
	public BigDecimal getR22_individual() {
		return r22_individual;
	}
	public void setR22_individual(BigDecimal r22_individual) {
		this.r22_individual = r22_individual;
	}
	public String getR23_time_deposits7() {
		return r23_time_deposits7;
	}
	public void setR23_time_deposits7(String r23_time_deposits7) {
		this.r23_time_deposits7 = r23_time_deposits7;
	}
	public BigDecimal getR23_aed() {
		return r23_aed;
	}
	public void setR23_aed(BigDecimal r23_aed) {
		this.r23_aed = r23_aed;
	}
	public BigDecimal getR23_fcy() {
		return r23_fcy;
	}
	public void setR23_fcy(BigDecimal r23_fcy) {
		this.r23_fcy = r23_fcy;
	}
	public BigDecimal getR23_total() {
		return r23_total;
	}
	public void setR23_total(BigDecimal r23_total) {
		this.r23_total = r23_total;
	}
	public BigDecimal getR23_commercial() {
		return r23_commercial;
	}
	public void setR23_commercial(BigDecimal r23_commercial) {
		this.r23_commercial = r23_commercial;
	}
	public BigDecimal getR23_gre() {
		return r23_gre;
	}
	public void setR23_gre(BigDecimal r23_gre) {
		this.r23_gre = r23_gre;
	}
	public BigDecimal getR23_fdbi() {
		return r23_fdbi;
	}
	public void setR23_fdbi(BigDecimal r23_fdbi) {
		this.r23_fdbi = r23_fdbi;
	}
	public BigDecimal getR23_sme() {
		return r23_sme;
	}
	public void setR23_sme(BigDecimal r23_sme) {
		this.r23_sme = r23_sme;
	}
	public BigDecimal getR23_individual() {
		return r23_individual;
	}
	public void setR23_individual(BigDecimal r23_individual) {
		this.r23_individual = r23_individual;
	}
	public String getR24_time_deposits8() {
		return r24_time_deposits8;
	}
	public void setR24_time_deposits8(String r24_time_deposits8) {
		this.r24_time_deposits8 = r24_time_deposits8;
	}
	public BigDecimal getR24_aed() {
		return r24_aed;
	}
	public void setR24_aed(BigDecimal r24_aed) {
		this.r24_aed = r24_aed;
	}
	public BigDecimal getR24_fcy() {
		return r24_fcy;
	}
	public void setR24_fcy(BigDecimal r24_fcy) {
		this.r24_fcy = r24_fcy;
	}
	public BigDecimal getR24_total() {
		return r24_total;
	}
	public void setR24_total(BigDecimal r24_total) {
		this.r24_total = r24_total;
	}
	public BigDecimal getR24_commercial() {
		return r24_commercial;
	}
	public void setR24_commercial(BigDecimal r24_commercial) {
		this.r24_commercial = r24_commercial;
	}
	public BigDecimal getR24_gre() {
		return r24_gre;
	}
	public void setR24_gre(BigDecimal r24_gre) {
		this.r24_gre = r24_gre;
	}
	public BigDecimal getR24_fdbi() {
		return r24_fdbi;
	}
	public void setR24_fdbi(BigDecimal r24_fdbi) {
		this.r24_fdbi = r24_fdbi;
	}
	public BigDecimal getR24_sme() {
		return r24_sme;
	}
	public void setR24_sme(BigDecimal r24_sme) {
		this.r24_sme = r24_sme;
	}
	public BigDecimal getR24_individual() {
		return r24_individual;
	}
	public void setR24_individual(BigDecimal r24_individual) {
		this.r24_individual = r24_individual;
	}
	public String getR25_time_deposits9() {
		return r25_time_deposits9;
	}
	public void setR25_time_deposits9(String r25_time_deposits9) {
		this.r25_time_deposits9 = r25_time_deposits9;
	}
	public BigDecimal getR25_aed() {
		return r25_aed;
	}
	public void setR25_aed(BigDecimal r25_aed) {
		this.r25_aed = r25_aed;
	}
	public BigDecimal getR25_fcy() {
		return r25_fcy;
	}
	public void setR25_fcy(BigDecimal r25_fcy) {
		this.r25_fcy = r25_fcy;
	}
	public BigDecimal getR25_total() {
		return r25_total;
	}
	public void setR25_total(BigDecimal r25_total) {
		this.r25_total = r25_total;
	}
	public BigDecimal getR25_commercial() {
		return r25_commercial;
	}
	public void setR25_commercial(BigDecimal r25_commercial) {
		this.r25_commercial = r25_commercial;
	}
	public BigDecimal getR25_gre() {
		return r25_gre;
	}
	public void setR25_gre(BigDecimal r25_gre) {
		this.r25_gre = r25_gre;
	}
	public BigDecimal getR25_fdbi() {
		return r25_fdbi;
	}
	public void setR25_fdbi(BigDecimal r25_fdbi) {
		this.r25_fdbi = r25_fdbi;
	}
	public BigDecimal getR25_sme() {
		return r25_sme;
	}
	public void setR25_sme(BigDecimal r25_sme) {
		this.r25_sme = r25_sme;
	}
	public BigDecimal getR25_individual() {
		return r25_individual;
	}
	public void setR25_individual(BigDecimal r25_individual) {
		this.r25_individual = r25_individual;
	}
	public String getR26_time_deposits10() {
		return r26_time_deposits10;
	}
	public void setR26_time_deposits10(String r26_time_deposits10) {
		this.r26_time_deposits10 = r26_time_deposits10;
	}
	public BigDecimal getR26_aed() {
		return r26_aed;
	}
	public void setR26_aed(BigDecimal r26_aed) {
		this.r26_aed = r26_aed;
	}
	public BigDecimal getR26_fcy() {
		return r26_fcy;
	}
	public void setR26_fcy(BigDecimal r26_fcy) {
		this.r26_fcy = r26_fcy;
	}
	public BigDecimal getR26_total() {
		return r26_total;
	}
	public void setR26_total(BigDecimal r26_total) {
		this.r26_total = r26_total;
	}
	public BigDecimal getR26_commercial() {
		return r26_commercial;
	}
	public void setR26_commercial(BigDecimal r26_commercial) {
		this.r26_commercial = r26_commercial;
	}
	public BigDecimal getR26_gre() {
		return r26_gre;
	}
	public void setR26_gre(BigDecimal r26_gre) {
		this.r26_gre = r26_gre;
	}
	public BigDecimal getR26_fdbi() {
		return r26_fdbi;
	}
	public void setR26_fdbi(BigDecimal r26_fdbi) {
		this.r26_fdbi = r26_fdbi;
	}
	public BigDecimal getR26_sme() {
		return r26_sme;
	}
	public void setR26_sme(BigDecimal r26_sme) {
		this.r26_sme = r26_sme;
	}
	public BigDecimal getR26_individual() {
		return r26_individual;
	}
	public void setR26_individual(BigDecimal r26_individual) {
		this.r26_individual = r26_individual;
	}
	public String getR27_saving_deposits() {
		return r27_saving_deposits;
	}
	public void setR27_saving_deposits(String r27_saving_deposits) {
		this.r27_saving_deposits = r27_saving_deposits;
	}
	public BigDecimal getR27_aed() {
		return r27_aed;
	}
	public void setR27_aed(BigDecimal r27_aed) {
		this.r27_aed = r27_aed;
	}
	public BigDecimal getR27_fcy() {
		return r27_fcy;
	}
	public void setR27_fcy(BigDecimal r27_fcy) {
		this.r27_fcy = r27_fcy;
	}
	public BigDecimal getR27_total() {
		return r27_total;
	}
	public void setR27_total(BigDecimal r27_total) {
		this.r27_total = r27_total;
	}
	public BigDecimal getR27_commercial() {
		return r27_commercial;
	}
	public void setR27_commercial(BigDecimal r27_commercial) {
		this.r27_commercial = r27_commercial;
	}
	public BigDecimal getR27_gre() {
		return r27_gre;
	}
	public void setR27_gre(BigDecimal r27_gre) {
		this.r27_gre = r27_gre;
	}
	public BigDecimal getR27_fdbi() {
		return r27_fdbi;
	}
	public void setR27_fdbi(BigDecimal r27_fdbi) {
		this.r27_fdbi = r27_fdbi;
	}
	public BigDecimal getR27_sme() {
		return r27_sme;
	}
	public void setR27_sme(BigDecimal r27_sme) {
		this.r27_sme = r27_sme;
	}
	public BigDecimal getR27_individual() {
		return r27_individual;
	}
	public void setR27_individual(BigDecimal r27_individual) {
		this.r27_individual = r27_individual;
	}
	public String getR28_saving_deposits1() {
		return r28_saving_deposits1;
	}
	public void setR28_saving_deposits1(String r28_saving_deposits1) {
		this.r28_saving_deposits1 = r28_saving_deposits1;
	}
	public BigDecimal getR28_aed() {
		return r28_aed;
	}
	public void setR28_aed(BigDecimal r28_aed) {
		this.r28_aed = r28_aed;
	}
	public BigDecimal getR28_fcy() {
		return r28_fcy;
	}
	public void setR28_fcy(BigDecimal r28_fcy) {
		this.r28_fcy = r28_fcy;
	}
	public BigDecimal getR28_total() {
		return r28_total;
	}
	public void setR28_total(BigDecimal r28_total) {
		this.r28_total = r28_total;
	}
	public BigDecimal getR28_commercial() {
		return r28_commercial;
	}
	public void setR28_commercial(BigDecimal r28_commercial) {
		this.r28_commercial = r28_commercial;
	}
	public BigDecimal getR28_gre() {
		return r28_gre;
	}
	public void setR28_gre(BigDecimal r28_gre) {
		this.r28_gre = r28_gre;
	}
	public BigDecimal getR28_fdbi() {
		return r28_fdbi;
	}
	public void setR28_fdbi(BigDecimal r28_fdbi) {
		this.r28_fdbi = r28_fdbi;
	}
	public BigDecimal getR28_sme() {
		return r28_sme;
	}
	public void setR28_sme(BigDecimal r28_sme) {
		this.r28_sme = r28_sme;
	}
	public BigDecimal getR28_individual() {
		return r28_individual;
	}
	public void setR28_individual(BigDecimal r28_individual) {
		this.r28_individual = r28_individual;
	}
	public String getR29_saving_deposits2() {
		return r29_saving_deposits2;
	}
	public void setR29_saving_deposits2(String r29_saving_deposits2) {
		this.r29_saving_deposits2 = r29_saving_deposits2;
	}
	public BigDecimal getR29_aed() {
		return r29_aed;
	}
	public void setR29_aed(BigDecimal r29_aed) {
		this.r29_aed = r29_aed;
	}
	public BigDecimal getR29_fcy() {
		return r29_fcy;
	}
	public void setR29_fcy(BigDecimal r29_fcy) {
		this.r29_fcy = r29_fcy;
	}
	public BigDecimal getR29_total() {
		return r29_total;
	}
	public void setR29_total(BigDecimal r29_total) {
		this.r29_total = r29_total;
	}
	public BigDecimal getR29_commercial() {
		return r29_commercial;
	}
	public void setR29_commercial(BigDecimal r29_commercial) {
		this.r29_commercial = r29_commercial;
	}
	public BigDecimal getR29_gre() {
		return r29_gre;
	}
	public void setR29_gre(BigDecimal r29_gre) {
		this.r29_gre = r29_gre;
	}
	public BigDecimal getR29_fdbi() {
		return r29_fdbi;
	}
	public void setR29_fdbi(BigDecimal r29_fdbi) {
		this.r29_fdbi = r29_fdbi;
	}
	public BigDecimal getR29_sme() {
		return r29_sme;
	}
	public void setR29_sme(BigDecimal r29_sme) {
		this.r29_sme = r29_sme;
	}
	public BigDecimal getR29_individual() {
		return r29_individual;
	}
	public void setR29_individual(BigDecimal r29_individual) {
		this.r29_individual = r29_individual;
	}
	public String getR30_saving_deposits3() {
		return r30_saving_deposits3;
	}
	public void setR30_saving_deposits3(String r30_saving_deposits3) {
		this.r30_saving_deposits3 = r30_saving_deposits3;
	}
	public BigDecimal getR30_aed() {
		return r30_aed;
	}
	public void setR30_aed(BigDecimal r30_aed) {
		this.r30_aed = r30_aed;
	}
	public BigDecimal getR30_fcy() {
		return r30_fcy;
	}
	public void setR30_fcy(BigDecimal r30_fcy) {
		this.r30_fcy = r30_fcy;
	}
	public BigDecimal getR30_total() {
		return r30_total;
	}
	public void setR30_total(BigDecimal r30_total) {
		this.r30_total = r30_total;
	}
	public BigDecimal getR30_commercial() {
		return r30_commercial;
	}
	public void setR30_commercial(BigDecimal r30_commercial) {
		this.r30_commercial = r30_commercial;
	}
	public BigDecimal getR30_gre() {
		return r30_gre;
	}
	public void setR30_gre(BigDecimal r30_gre) {
		this.r30_gre = r30_gre;
	}
	public BigDecimal getR30_fdbi() {
		return r30_fdbi;
	}
	public void setR30_fdbi(BigDecimal r30_fdbi) {
		this.r30_fdbi = r30_fdbi;
	}
	public BigDecimal getR30_sme() {
		return r30_sme;
	}
	public void setR30_sme(BigDecimal r30_sme) {
		this.r30_sme = r30_sme;
	}
	public BigDecimal getR30_individual() {
		return r30_individual;
	}
	public void setR30_individual(BigDecimal r30_individual) {
		this.r30_individual = r30_individual;
	}
	public String getR31_saving_deposits4() {
		return r31_saving_deposits4;
	}
	public void setR31_saving_deposits4(String r31_saving_deposits4) {
		this.r31_saving_deposits4 = r31_saving_deposits4;
	}
	public BigDecimal getR31_aed() {
		return r31_aed;
	}
	public void setR31_aed(BigDecimal r31_aed) {
		this.r31_aed = r31_aed;
	}
	public BigDecimal getR31_fcy() {
		return r31_fcy;
	}
	public void setR31_fcy(BigDecimal r31_fcy) {
		this.r31_fcy = r31_fcy;
	}
	public BigDecimal getR31_total() {
		return r31_total;
	}
	public void setR31_total(BigDecimal r31_total) {
		this.r31_total = r31_total;
	}
	public BigDecimal getR31_commercial() {
		return r31_commercial;
	}
	public void setR31_commercial(BigDecimal r31_commercial) {
		this.r31_commercial = r31_commercial;
	}
	public BigDecimal getR31_gre() {
		return r31_gre;
	}
	public void setR31_gre(BigDecimal r31_gre) {
		this.r31_gre = r31_gre;
	}
	public BigDecimal getR31_fdbi() {
		return r31_fdbi;
	}
	public void setR31_fdbi(BigDecimal r31_fdbi) {
		this.r31_fdbi = r31_fdbi;
	}
	public BigDecimal getR31_sme() {
		return r31_sme;
	}
	public void setR31_sme(BigDecimal r31_sme) {
		this.r31_sme = r31_sme;
	}
	public BigDecimal getR31_individual() {
		return r31_individual;
	}
	public void setR31_individual(BigDecimal r31_individual) {
		this.r31_individual = r31_individual;
	}
	public String getR32_total_deposits() {
		return r32_total_deposits;
	}
	public void setR32_total_deposits(String r32_total_deposits) {
		this.r32_total_deposits = r32_total_deposits;
	}
	public BigDecimal getR32_aed() {
		return r32_aed;
	}
	public void setR32_aed(BigDecimal r32_aed) {
		this.r32_aed = r32_aed;
	}
	public BigDecimal getR32_fcy() {
		return r32_fcy;
	}
	public void setR32_fcy(BigDecimal r32_fcy) {
		this.r32_fcy = r32_fcy;
	}
	public BigDecimal getR32_total() {
		return r32_total;
	}
	public void setR32_total(BigDecimal r32_total) {
		this.r32_total = r32_total;
	}
	public BigDecimal getR32_commercial() {
		return r32_commercial;
	}
	public void setR32_commercial(BigDecimal r32_commercial) {
		this.r32_commercial = r32_commercial;
	}
	public BigDecimal getR32_gre() {
		return r32_gre;
	}
	public void setR32_gre(BigDecimal r32_gre) {
		this.r32_gre = r32_gre;
	}
	public BigDecimal getR32_fdbi() {
		return r32_fdbi;
	}
	public void setR32_fdbi(BigDecimal r32_fdbi) {
		this.r32_fdbi = r32_fdbi;
	}
	public BigDecimal getR32_sme() {
		return r32_sme;
	}
	public void setR32_sme(BigDecimal r32_sme) {
		this.r32_sme = r32_sme;
	}
	public BigDecimal getR32_individual() {
		return r32_individual;
	}
	public void setR32_individual(BigDecimal r32_individual) {
		this.r32_individual = r32_individual;
	}
	public String getR33_loan() {
		return r33_loan;
	}
	public void setR33_loan(String r33_loan) {
		this.r33_loan = r33_loan;
	}
	public BigDecimal getR33_aed() {
		return r33_aed;
	}
	public void setR33_aed(BigDecimal r33_aed) {
		this.r33_aed = r33_aed;
	}
	public BigDecimal getR33_fcy() {
		return r33_fcy;
	}
	public void setR33_fcy(BigDecimal r33_fcy) {
		this.r33_fcy = r33_fcy;
	}
	public BigDecimal getR33_total() {
		return r33_total;
	}
	public void setR33_total(BigDecimal r33_total) {
		this.r33_total = r33_total;
	}
	public BigDecimal getR33_commercial() {
		return r33_commercial;
	}
	public void setR33_commercial(BigDecimal r33_commercial) {
		this.r33_commercial = r33_commercial;
	}
	public BigDecimal getR33_gre() {
		return r33_gre;
	}
	public void setR33_gre(BigDecimal r33_gre) {
		this.r33_gre = r33_gre;
	}
	public BigDecimal getR33_fdbi() {
		return r33_fdbi;
	}
	public void setR33_fdbi(BigDecimal r33_fdbi) {
		this.r33_fdbi = r33_fdbi;
	}
	public BigDecimal getR33_sme() {
		return r33_sme;
	}
	public void setR33_sme(BigDecimal r33_sme) {
		this.r33_sme = r33_sme;
	}
	public BigDecimal getR33_individual() {
		return r33_individual;
	}
	public void setR33_individual(BigDecimal r33_individual) {
		this.r33_individual = r33_individual;
	}
	public String getR34_loan() {
		return r34_loan;
	}
	public void setR34_loan(String r34_loan) {
		this.r34_loan = r34_loan;
	}
	public BigDecimal getR34_aed() {
		return r34_aed;
	}
	public void setR34_aed(BigDecimal r34_aed) {
		this.r34_aed = r34_aed;
	}
	public BigDecimal getR34_fcy() {
		return r34_fcy;
	}
	public void setR34_fcy(BigDecimal r34_fcy) {
		this.r34_fcy = r34_fcy;
	}
	public BigDecimal getR34_total() {
		return r34_total;
	}
	public void setR34_total(BigDecimal r34_total) {
		this.r34_total = r34_total;
	}
	public BigDecimal getR34_commercial() {
		return r34_commercial;
	}
	public void setR34_commercial(BigDecimal r34_commercial) {
		this.r34_commercial = r34_commercial;
	}
	public BigDecimal getR34_gre() {
		return r34_gre;
	}
	public void setR34_gre(BigDecimal r34_gre) {
		this.r34_gre = r34_gre;
	}
	public BigDecimal getR34_fdbi() {
		return r34_fdbi;
	}
	public void setR34_fdbi(BigDecimal r34_fdbi) {
		this.r34_fdbi = r34_fdbi;
	}
	public BigDecimal getR34_sme() {
		return r34_sme;
	}
	public void setR34_sme(BigDecimal r34_sme) {
		this.r34_sme = r34_sme;
	}
	public BigDecimal getR34_individual() {
		return r34_individual;
	}
	public void setR34_individual(BigDecimal r34_individual) {
		this.r34_individual = r34_individual;
	}
	public String getR35_loan1() {
		return r35_loan1;
	}
	public void setR35_loan1(String r35_loan1) {
		this.r35_loan1 = r35_loan1;
	}
	public BigDecimal getR35_aed() {
		return r35_aed;
	}
	public void setR35_aed(BigDecimal r35_aed) {
		this.r35_aed = r35_aed;
	}
	public BigDecimal getR35_fcy() {
		return r35_fcy;
	}
	public void setR35_fcy(BigDecimal r35_fcy) {
		this.r35_fcy = r35_fcy;
	}
	public BigDecimal getR35_total() {
		return r35_total;
	}
	public void setR35_total(BigDecimal r35_total) {
		this.r35_total = r35_total;
	}
	public BigDecimal getR35_commercial() {
		return r35_commercial;
	}
	public void setR35_commercial(BigDecimal r35_commercial) {
		this.r35_commercial = r35_commercial;
	}
	public BigDecimal getR35_gre() {
		return r35_gre;
	}
	public void setR35_gre(BigDecimal r35_gre) {
		this.r35_gre = r35_gre;
	}
	public BigDecimal getR35_fdbi() {
		return r35_fdbi;
	}
	public void setR35_fdbi(BigDecimal r35_fdbi) {
		this.r35_fdbi = r35_fdbi;
	}
	public BigDecimal getR35_sme() {
		return r35_sme;
	}
	public void setR35_sme(BigDecimal r35_sme) {
		this.r35_sme = r35_sme;
	}
	public BigDecimal getR35_individual() {
		return r35_individual;
	}
	public void setR35_individual(BigDecimal r35_individual) {
		this.r35_individual = r35_individual;
	}
	public String getR36_loan2() {
		return r36_loan2;
	}
	public void setR36_loan2(String r36_loan2) {
		this.r36_loan2 = r36_loan2;
	}
	public BigDecimal getR36_aed() {
		return r36_aed;
	}
	public void setR36_aed(BigDecimal r36_aed) {
		this.r36_aed = r36_aed;
	}
	public BigDecimal getR36_fcy() {
		return r36_fcy;
	}
	public void setR36_fcy(BigDecimal r36_fcy) {
		this.r36_fcy = r36_fcy;
	}
	public BigDecimal getR36_total() {
		return r36_total;
	}
	public void setR36_total(BigDecimal r36_total) {
		this.r36_total = r36_total;
	}
	public BigDecimal getR36_commercial() {
		return r36_commercial;
	}
	public void setR36_commercial(BigDecimal r36_commercial) {
		this.r36_commercial = r36_commercial;
	}
	public BigDecimal getR36_gre() {
		return r36_gre;
	}
	public void setR36_gre(BigDecimal r36_gre) {
		this.r36_gre = r36_gre;
	}
	public BigDecimal getR36_fdbi() {
		return r36_fdbi;
	}
	public void setR36_fdbi(BigDecimal r36_fdbi) {
		this.r36_fdbi = r36_fdbi;
	}
	public BigDecimal getR36_sme() {
		return r36_sme;
	}
	public void setR36_sme(BigDecimal r36_sme) {
		this.r36_sme = r36_sme;
	}
	public BigDecimal getR36_individual() {
		return r36_individual;
	}
	public void setR36_individual(BigDecimal r36_individual) {
		this.r36_individual = r36_individual;
	}
	public String getR37_loan3() {
		return r37_loan3;
	}
	public void setR37_loan3(String r37_loan3) {
		this.r37_loan3 = r37_loan3;
	}
	public BigDecimal getR37_aed() {
		return r37_aed;
	}
	public void setR37_aed(BigDecimal r37_aed) {
		this.r37_aed = r37_aed;
	}
	public BigDecimal getR37_fcy() {
		return r37_fcy;
	}
	public void setR37_fcy(BigDecimal r37_fcy) {
		this.r37_fcy = r37_fcy;
	}
	public BigDecimal getR37_total() {
		return r37_total;
	}
	public void setR37_total(BigDecimal r37_total) {
		this.r37_total = r37_total;
	}
	public BigDecimal getR37_commercial() {
		return r37_commercial;
	}
	public void setR37_commercial(BigDecimal r37_commercial) {
		this.r37_commercial = r37_commercial;
	}
	public BigDecimal getR37_gre() {
		return r37_gre;
	}
	public void setR37_gre(BigDecimal r37_gre) {
		this.r37_gre = r37_gre;
	}
	public BigDecimal getR37_fdbi() {
		return r37_fdbi;
	}
	public void setR37_fdbi(BigDecimal r37_fdbi) {
		this.r37_fdbi = r37_fdbi;
	}
	public BigDecimal getR37_sme() {
		return r37_sme;
	}
	public void setR37_sme(BigDecimal r37_sme) {
		this.r37_sme = r37_sme;
	}
	public BigDecimal getR37_individual() {
		return r37_individual;
	}
	public void setR37_individual(BigDecimal r37_individual) {
		this.r37_individual = r37_individual;
	}
	public String getR38_loan4() {
		return r38_loan4;
	}
	public void setR38_loan4(String r38_loan4) {
		this.r38_loan4 = r38_loan4;
	}
	public BigDecimal getR38_aed() {
		return r38_aed;
	}
	public void setR38_aed(BigDecimal r38_aed) {
		this.r38_aed = r38_aed;
	}
	public BigDecimal getR38_fcy() {
		return r38_fcy;
	}
	public void setR38_fcy(BigDecimal r38_fcy) {
		this.r38_fcy = r38_fcy;
	}
	public BigDecimal getR38_total() {
		return r38_total;
	}
	public void setR38_total(BigDecimal r38_total) {
		this.r38_total = r38_total;
	}
	public BigDecimal getR38_commercial() {
		return r38_commercial;
	}
	public void setR38_commercial(BigDecimal r38_commercial) {
		this.r38_commercial = r38_commercial;
	}
	public BigDecimal getR38_gre() {
		return r38_gre;
	}
	public void setR38_gre(BigDecimal r38_gre) {
		this.r38_gre = r38_gre;
	}
	public BigDecimal getR38_fdbi() {
		return r38_fdbi;
	}
	public void setR38_fdbi(BigDecimal r38_fdbi) {
		this.r38_fdbi = r38_fdbi;
	}
	public BigDecimal getR38_sme() {
		return r38_sme;
	}
	public void setR38_sme(BigDecimal r38_sme) {
		this.r38_sme = r38_sme;
	}
	public BigDecimal getR38_individual() {
		return r38_individual;
	}
	public void setR38_individual(BigDecimal r38_individual) {
		this.r38_individual = r38_individual;
	}
	public String getR39_loan5() {
		return r39_loan5;
	}
	public void setR39_loan5(String r39_loan5) {
		this.r39_loan5 = r39_loan5;
	}
	public BigDecimal getR39_aed() {
		return r39_aed;
	}
	public void setR39_aed(BigDecimal r39_aed) {
		this.r39_aed = r39_aed;
	}
	public BigDecimal getR39_fcy() {
		return r39_fcy;
	}
	public void setR39_fcy(BigDecimal r39_fcy) {
		this.r39_fcy = r39_fcy;
	}
	public BigDecimal getR39_total() {
		return r39_total;
	}
	public void setR39_total(BigDecimal r39_total) {
		this.r39_total = r39_total;
	}
	public BigDecimal getR39_commercial() {
		return r39_commercial;
	}
	public void setR39_commercial(BigDecimal r39_commercial) {
		this.r39_commercial = r39_commercial;
	}
	public BigDecimal getR39_gre() {
		return r39_gre;
	}
	public void setR39_gre(BigDecimal r39_gre) {
		this.r39_gre = r39_gre;
	}
	public BigDecimal getR39_fdbi() {
		return r39_fdbi;
	}
	public void setR39_fdbi(BigDecimal r39_fdbi) {
		this.r39_fdbi = r39_fdbi;
	}
	public BigDecimal getR39_sme() {
		return r39_sme;
	}
	public void setR39_sme(BigDecimal r39_sme) {
		this.r39_sme = r39_sme;
	}
	public BigDecimal getR39_individual() {
		return r39_individual;
	}
	public void setR39_individual(BigDecimal r39_individual) {
		this.r39_individual = r39_individual;
	}
	public String getR40_loan6() {
		return r40_loan6;
	}
	public void setR40_loan6(String r40_loan6) {
		this.r40_loan6 = r40_loan6;
	}
	public BigDecimal getR40_aed() {
		return r40_aed;
	}
	public void setR40_aed(BigDecimal r40_aed) {
		this.r40_aed = r40_aed;
	}
	public BigDecimal getR40_fcy() {
		return r40_fcy;
	}
	public void setR40_fcy(BigDecimal r40_fcy) {
		this.r40_fcy = r40_fcy;
	}
	public BigDecimal getR40_total() {
		return r40_total;
	}
	public void setR40_total(BigDecimal r40_total) {
		this.r40_total = r40_total;
	}
	public BigDecimal getR40_commercial() {
		return r40_commercial;
	}
	public void setR40_commercial(BigDecimal r40_commercial) {
		this.r40_commercial = r40_commercial;
	}
	public BigDecimal getR40_gre() {
		return r40_gre;
	}
	public void setR40_gre(BigDecimal r40_gre) {
		this.r40_gre = r40_gre;
	}
	public BigDecimal getR40_fdbi() {
		return r40_fdbi;
	}
	public void setR40_fdbi(BigDecimal r40_fdbi) {
		this.r40_fdbi = r40_fdbi;
	}
	public BigDecimal getR40_sme() {
		return r40_sme;
	}
	public void setR40_sme(BigDecimal r40_sme) {
		this.r40_sme = r40_sme;
	}
	public BigDecimal getR40_individual() {
		return r40_individual;
	}
	public void setR40_individual(BigDecimal r40_individual) {
		this.r40_individual = r40_individual;
	}
	public String getR41_loan7() {
		return r41_loan7;
	}
	public void setR41_loan7(String r41_loan7) {
		this.r41_loan7 = r41_loan7;
	}
	public BigDecimal getR41_aed() {
		return r41_aed;
	}
	public void setR41_aed(BigDecimal r41_aed) {
		this.r41_aed = r41_aed;
	}
	public BigDecimal getR41_fcy() {
		return r41_fcy;
	}
	public void setR41_fcy(BigDecimal r41_fcy) {
		this.r41_fcy = r41_fcy;
	}
	public BigDecimal getR41_total() {
		return r41_total;
	}
	public void setR41_total(BigDecimal r41_total) {
		this.r41_total = r41_total;
	}
	public BigDecimal getR41_commercial() {
		return r41_commercial;
	}
	public void setR41_commercial(BigDecimal r41_commercial) {
		this.r41_commercial = r41_commercial;
	}
	public BigDecimal getR41_gre() {
		return r41_gre;
	}
	public void setR41_gre(BigDecimal r41_gre) {
		this.r41_gre = r41_gre;
	}
	public BigDecimal getR41_fdbi() {
		return r41_fdbi;
	}
	public void setR41_fdbi(BigDecimal r41_fdbi) {
		this.r41_fdbi = r41_fdbi;
	}
	public BigDecimal getR41_sme() {
		return r41_sme;
	}
	public void setR41_sme(BigDecimal r41_sme) {
		this.r41_sme = r41_sme;
	}
	public BigDecimal getR41_individual() {
		return r41_individual;
	}
	public void setR41_individual(BigDecimal r41_individual) {
		this.r41_individual = r41_individual;
	}
	public String getR42_loan8() {
		return r42_loan8;
	}
	public void setR42_loan8(String r42_loan8) {
		this.r42_loan8 = r42_loan8;
	}
	public BigDecimal getR42_aed() {
		return r42_aed;
	}
	public void setR42_aed(BigDecimal r42_aed) {
		this.r42_aed = r42_aed;
	}
	public BigDecimal getR42_fcy() {
		return r42_fcy;
	}
	public void setR42_fcy(BigDecimal r42_fcy) {
		this.r42_fcy = r42_fcy;
	}
	public BigDecimal getR42_total() {
		return r42_total;
	}
	public void setR42_total(BigDecimal r42_total) {
		this.r42_total = r42_total;
	}
	public BigDecimal getR42_commercial() {
		return r42_commercial;
	}
	public void setR42_commercial(BigDecimal r42_commercial) {
		this.r42_commercial = r42_commercial;
	}
	public BigDecimal getR42_gre() {
		return r42_gre;
	}
	public void setR42_gre(BigDecimal r42_gre) {
		this.r42_gre = r42_gre;
	}
	public BigDecimal getR42_fdbi() {
		return r42_fdbi;
	}
	public void setR42_fdbi(BigDecimal r42_fdbi) {
		this.r42_fdbi = r42_fdbi;
	}
	public BigDecimal getR42_sme() {
		return r42_sme;
	}
	public void setR42_sme(BigDecimal r42_sme) {
		this.r42_sme = r42_sme;
	}
	public BigDecimal getR42_individual() {
		return r42_individual;
	}
	public void setR42_individual(BigDecimal r42_individual) {
		this.r42_individual = r42_individual;
	}
	public String getR43_loan9() {
		return r43_loan9;
	}
	public void setR43_loan9(String r43_loan9) {
		this.r43_loan9 = r43_loan9;
	}
	public BigDecimal getR43_aed() {
		return r43_aed;
	}
	public void setR43_aed(BigDecimal r43_aed) {
		this.r43_aed = r43_aed;
	}
	public BigDecimal getR43_fcy() {
		return r43_fcy;
	}
	public void setR43_fcy(BigDecimal r43_fcy) {
		this.r43_fcy = r43_fcy;
	}
	public BigDecimal getR43_total() {
		return r43_total;
	}
	public void setR43_total(BigDecimal r43_total) {
		this.r43_total = r43_total;
	}
	public BigDecimal getR43_commercial() {
		return r43_commercial;
	}
	public void setR43_commercial(BigDecimal r43_commercial) {
		this.r43_commercial = r43_commercial;
	}
	public BigDecimal getR43_gre() {
		return r43_gre;
	}
	public void setR43_gre(BigDecimal r43_gre) {
		this.r43_gre = r43_gre;
	}
	public BigDecimal getR43_fdbi() {
		return r43_fdbi;
	}
	public void setR43_fdbi(BigDecimal r43_fdbi) {
		this.r43_fdbi = r43_fdbi;
	}
	public BigDecimal getR43_sme() {
		return r43_sme;
	}
	public void setR43_sme(BigDecimal r43_sme) {
		this.r43_sme = r43_sme;
	}
	public BigDecimal getR43_individual() {
		return r43_individual;
	}
	public void setR43_individual(BigDecimal r43_individual) {
		this.r43_individual = r43_individual;
	}
	public String getR44_loan10() {
		return r44_loan10;
	}
	public void setR44_loan10(String r44_loan10) {
		this.r44_loan10 = r44_loan10;
	}
	public BigDecimal getR44_aed() {
		return r44_aed;
	}
	public void setR44_aed(BigDecimal r44_aed) {
		this.r44_aed = r44_aed;
	}
	public BigDecimal getR44_fcy() {
		return r44_fcy;
	}
	public void setR44_fcy(BigDecimal r44_fcy) {
		this.r44_fcy = r44_fcy;
	}
	public BigDecimal getR44_total() {
		return r44_total;
	}
	public void setR44_total(BigDecimal r44_total) {
		this.r44_total = r44_total;
	}
	public BigDecimal getR44_commercial() {
		return r44_commercial;
	}
	public void setR44_commercial(BigDecimal r44_commercial) {
		this.r44_commercial = r44_commercial;
	}
	public BigDecimal getR44_gre() {
		return r44_gre;
	}
	public void setR44_gre(BigDecimal r44_gre) {
		this.r44_gre = r44_gre;
	}
	public BigDecimal getR44_fdbi() {
		return r44_fdbi;
	}
	public void setR44_fdbi(BigDecimal r44_fdbi) {
		this.r44_fdbi = r44_fdbi;
	}
	public BigDecimal getR44_sme() {
		return r44_sme;
	}
	public void setR44_sme(BigDecimal r44_sme) {
		this.r44_sme = r44_sme;
	}
	public BigDecimal getR44_individual() {
		return r44_individual;
	}
	public void setR44_individual(BigDecimal r44_individual) {
		this.r44_individual = r44_individual;
	}
	public String getR45_credit_card() {
		return r45_credit_card;
	}
	public void setR45_credit_card(String r45_credit_card) {
		this.r45_credit_card = r45_credit_card;
	}
	public BigDecimal getR45_aed() {
		return r45_aed;
	}
	public void setR45_aed(BigDecimal r45_aed) {
		this.r45_aed = r45_aed;
	}
	public BigDecimal getR45_fcy() {
		return r45_fcy;
	}
	public void setR45_fcy(BigDecimal r45_fcy) {
		this.r45_fcy = r45_fcy;
	}
	public BigDecimal getR45_total() {
		return r45_total;
	}
	public void setR45_total(BigDecimal r45_total) {
		this.r45_total = r45_total;
	}
	public BigDecimal getR45_commercial() {
		return r45_commercial;
	}
	public void setR45_commercial(BigDecimal r45_commercial) {
		this.r45_commercial = r45_commercial;
	}
	public BigDecimal getR45_gre() {
		return r45_gre;
	}
	public void setR45_gre(BigDecimal r45_gre) {
		this.r45_gre = r45_gre;
	}
	public BigDecimal getR45_fdbi() {
		return r45_fdbi;
	}
	public void setR45_fdbi(BigDecimal r45_fdbi) {
		this.r45_fdbi = r45_fdbi;
	}
	public BigDecimal getR45_sme() {
		return r45_sme;
	}
	public void setR45_sme(BigDecimal r45_sme) {
		this.r45_sme = r45_sme;
	}
	public BigDecimal getR45_individual() {
		return r45_individual;
	}
	public void setR45_individual(BigDecimal r45_individual) {
		this.r45_individual = r45_individual;
	}
	public String getR46_credit_card1() {
		return r46_credit_card1;
	}
	public void setR46_credit_card1(String r46_credit_card1) {
		this.r46_credit_card1 = r46_credit_card1;
	}
	public BigDecimal getR46_aed() {
		return r46_aed;
	}
	public void setR46_aed(BigDecimal r46_aed) {
		this.r46_aed = r46_aed;
	}
	public BigDecimal getR46_fcy() {
		return r46_fcy;
	}
	public void setR46_fcy(BigDecimal r46_fcy) {
		this.r46_fcy = r46_fcy;
	}
	public BigDecimal getR46_total() {
		return r46_total;
	}
	public void setR46_total(BigDecimal r46_total) {
		this.r46_total = r46_total;
	}
	public BigDecimal getR46_commercial() {
		return r46_commercial;
	}
	public void setR46_commercial(BigDecimal r46_commercial) {
		this.r46_commercial = r46_commercial;
	}
	public BigDecimal getR46_gre() {
		return r46_gre;
	}
	public void setR46_gre(BigDecimal r46_gre) {
		this.r46_gre = r46_gre;
	}
	public BigDecimal getR46_fdbi() {
		return r46_fdbi;
	}
	public void setR46_fdbi(BigDecimal r46_fdbi) {
		this.r46_fdbi = r46_fdbi;
	}
	public BigDecimal getR46_sme() {
		return r46_sme;
	}
	public void setR46_sme(BigDecimal r46_sme) {
		this.r46_sme = r46_sme;
	}
	public BigDecimal getR46_individual() {
		return r46_individual;
	}
	public void setR46_individual(BigDecimal r46_individual) {
		this.r46_individual = r46_individual;
	}
	public String getR47_credit_card2() {
		return r47_credit_card2;
	}
	public void setR47_credit_card2(String r47_credit_card2) {
		this.r47_credit_card2 = r47_credit_card2;
	}
	public BigDecimal getR47_aed() {
		return r47_aed;
	}
	public void setR47_aed(BigDecimal r47_aed) {
		this.r47_aed = r47_aed;
	}
	public BigDecimal getR47_fcy() {
		return r47_fcy;
	}
	public void setR47_fcy(BigDecimal r47_fcy) {
		this.r47_fcy = r47_fcy;
	}
	public BigDecimal getR47_total() {
		return r47_total;
	}
	public void setR47_total(BigDecimal r47_total) {
		this.r47_total = r47_total;
	}
	public BigDecimal getR47_commercial() {
		return r47_commercial;
	}
	public void setR47_commercial(BigDecimal r47_commercial) {
		this.r47_commercial = r47_commercial;
	}
	public BigDecimal getR47_gre() {
		return r47_gre;
	}
	public void setR47_gre(BigDecimal r47_gre) {
		this.r47_gre = r47_gre;
	}
	public BigDecimal getR47_fdbi() {
		return r47_fdbi;
	}
	public void setR47_fdbi(BigDecimal r47_fdbi) {
		this.r47_fdbi = r47_fdbi;
	}
	public BigDecimal getR47_sme() {
		return r47_sme;
	}
	public void setR47_sme(BigDecimal r47_sme) {
		this.r47_sme = r47_sme;
	}
	public BigDecimal getR47_individual() {
		return r47_individual;
	}
	public void setR47_individual(BigDecimal r47_individual) {
		this.r47_individual = r47_individual;
	}
	public String getR48_credit_card3() {
		return r48_credit_card3;
	}
	public void setR48_credit_card3(String r48_credit_card3) {
		this.r48_credit_card3 = r48_credit_card3;
	}
	public BigDecimal getR48_aed() {
		return r48_aed;
	}
	public void setR48_aed(BigDecimal r48_aed) {
		this.r48_aed = r48_aed;
	}
	public BigDecimal getR48_fcy() {
		return r48_fcy;
	}
	public void setR48_fcy(BigDecimal r48_fcy) {
		this.r48_fcy = r48_fcy;
	}
	public BigDecimal getR48_total() {
		return r48_total;
	}
	public void setR48_total(BigDecimal r48_total) {
		this.r48_total = r48_total;
	}
	public BigDecimal getR48_commercial() {
		return r48_commercial;
	}
	public void setR48_commercial(BigDecimal r48_commercial) {
		this.r48_commercial = r48_commercial;
	}
	public BigDecimal getR48_gre() {
		return r48_gre;
	}
	public void setR48_gre(BigDecimal r48_gre) {
		this.r48_gre = r48_gre;
	}
	public BigDecimal getR48_fdbi() {
		return r48_fdbi;
	}
	public void setR48_fdbi(BigDecimal r48_fdbi) {
		this.r48_fdbi = r48_fdbi;
	}
	public BigDecimal getR48_sme() {
		return r48_sme;
	}
	public void setR48_sme(BigDecimal r48_sme) {
		this.r48_sme = r48_sme;
	}
	public BigDecimal getR48_individual() {
		return r48_individual;
	}
	public void setR48_individual(BigDecimal r48_individual) {
		this.r48_individual = r48_individual;
	}
	public String getR49_credit_card4() {
		return r49_credit_card4;
	}
	public void setR49_credit_card4(String r49_credit_card4) {
		this.r49_credit_card4 = r49_credit_card4;
	}
	public BigDecimal getR49_aed() {
		return r49_aed;
	}
	public void setR49_aed(BigDecimal r49_aed) {
		this.r49_aed = r49_aed;
	}
	public BigDecimal getR49_fcy() {
		return r49_fcy;
	}
	public void setR49_fcy(BigDecimal r49_fcy) {
		this.r49_fcy = r49_fcy;
	}
	public BigDecimal getR49_total() {
		return r49_total;
	}
	public void setR49_total(BigDecimal r49_total) {
		this.r49_total = r49_total;
	}
	public BigDecimal getR49_commercial() {
		return r49_commercial;
	}
	public void setR49_commercial(BigDecimal r49_commercial) {
		this.r49_commercial = r49_commercial;
	}
	public BigDecimal getR49_gre() {
		return r49_gre;
	}
	public void setR49_gre(BigDecimal r49_gre) {
		this.r49_gre = r49_gre;
	}
	public BigDecimal getR49_fdbi() {
		return r49_fdbi;
	}
	public void setR49_fdbi(BigDecimal r49_fdbi) {
		this.r49_fdbi = r49_fdbi;
	}
	public BigDecimal getR49_sme() {
		return r49_sme;
	}
	public void setR49_sme(BigDecimal r49_sme) {
		this.r49_sme = r49_sme;
	}
	public BigDecimal getR49_individual() {
		return r49_individual;
	}
	public void setR49_individual(BigDecimal r49_individual) {
		this.r49_individual = r49_individual;
	}
	public String getR50_credit_card5() {
		return r50_credit_card5;
	}
	public void setR50_credit_card5(String r50_credit_card5) {
		this.r50_credit_card5 = r50_credit_card5;
	}
	public BigDecimal getR50_aed() {
		return r50_aed;
	}
	public void setR50_aed(BigDecimal r50_aed) {
		this.r50_aed = r50_aed;
	}
	public BigDecimal getR50_fcy() {
		return r50_fcy;
	}
	public void setR50_fcy(BigDecimal r50_fcy) {
		this.r50_fcy = r50_fcy;
	}
	public BigDecimal getR50_total() {
		return r50_total;
	}
	public void setR50_total(BigDecimal r50_total) {
		this.r50_total = r50_total;
	}
	public BigDecimal getR50_commercial() {
		return r50_commercial;
	}
	public void setR50_commercial(BigDecimal r50_commercial) {
		this.r50_commercial = r50_commercial;
	}
	public BigDecimal getR50_gre() {
		return r50_gre;
	}
	public void setR50_gre(BigDecimal r50_gre) {
		this.r50_gre = r50_gre;
	}
	public BigDecimal getR50_fdbi() {
		return r50_fdbi;
	}
	public void setR50_fdbi(BigDecimal r50_fdbi) {
		this.r50_fdbi = r50_fdbi;
	}
	public BigDecimal getR50_sme() {
		return r50_sme;
	}
	public void setR50_sme(BigDecimal r50_sme) {
		this.r50_sme = r50_sme;
	}
	public BigDecimal getR50_individual() {
		return r50_individual;
	}
	public void setR50_individual(BigDecimal r50_individual) {
		this.r50_individual = r50_individual;
	}
	public String getR51_credit_card6() {
		return r51_credit_card6;
	}
	public void setR51_credit_card6(String r51_credit_card6) {
		this.r51_credit_card6 = r51_credit_card6;
	}
	public BigDecimal getR51_aed() {
		return r51_aed;
	}
	public void setR51_aed(BigDecimal r51_aed) {
		this.r51_aed = r51_aed;
	}
	public BigDecimal getR51_fcy() {
		return r51_fcy;
	}
	public void setR51_fcy(BigDecimal r51_fcy) {
		this.r51_fcy = r51_fcy;
	}
	public BigDecimal getR51_total() {
		return r51_total;
	}
	public void setR51_total(BigDecimal r51_total) {
		this.r51_total = r51_total;
	}
	public BigDecimal getR51_commercial() {
		return r51_commercial;
	}
	public void setR51_commercial(BigDecimal r51_commercial) {
		this.r51_commercial = r51_commercial;
	}
	public BigDecimal getR51_gre() {
		return r51_gre;
	}
	public void setR51_gre(BigDecimal r51_gre) {
		this.r51_gre = r51_gre;
	}
	public BigDecimal getR51_fdbi() {
		return r51_fdbi;
	}
	public void setR51_fdbi(BigDecimal r51_fdbi) {
		this.r51_fdbi = r51_fdbi;
	}
	public BigDecimal getR51_sme() {
		return r51_sme;
	}
	public void setR51_sme(BigDecimal r51_sme) {
		this.r51_sme = r51_sme;
	}
	public BigDecimal getR51_individual() {
		return r51_individual;
	}
	public void setR51_individual(BigDecimal r51_individual) {
		this.r51_individual = r51_individual;
	}
	public String getR52_credit_card7() {
		return r52_credit_card7;
	}
	public void setR52_credit_card7(String r52_credit_card7) {
		this.r52_credit_card7 = r52_credit_card7;
	}
	public BigDecimal getR52_aed() {
		return r52_aed;
	}
	public void setR52_aed(BigDecimal r52_aed) {
		this.r52_aed = r52_aed;
	}
	public BigDecimal getR52_fcy() {
		return r52_fcy;
	}
	public void setR52_fcy(BigDecimal r52_fcy) {
		this.r52_fcy = r52_fcy;
	}
	public BigDecimal getR52_total() {
		return r52_total;
	}
	public void setR52_total(BigDecimal r52_total) {
		this.r52_total = r52_total;
	}
	public BigDecimal getR52_commercial() {
		return r52_commercial;
	}
	public void setR52_commercial(BigDecimal r52_commercial) {
		this.r52_commercial = r52_commercial;
	}
	public BigDecimal getR52_gre() {
		return r52_gre;
	}
	public void setR52_gre(BigDecimal r52_gre) {
		this.r52_gre = r52_gre;
	}
	public BigDecimal getR52_fdbi() {
		return r52_fdbi;
	}
	public void setR52_fdbi(BigDecimal r52_fdbi) {
		this.r52_fdbi = r52_fdbi;
	}
	public BigDecimal getR52_sme() {
		return r52_sme;
	}
	public void setR52_sme(BigDecimal r52_sme) {
		this.r52_sme = r52_sme;
	}
	public BigDecimal getR52_individual() {
		return r52_individual;
	}
	public void setR52_individual(BigDecimal r52_individual) {
		this.r52_individual = r52_individual;
	}
	public String getR53_non_performing_loans() {
		return r53_non_performing_loans;
	}
	public void setR53_non_performing_loans(String r53_non_performing_loans) {
		this.r53_non_performing_loans = r53_non_performing_loans;
	}
	public BigDecimal getR53_aed() {
		return r53_aed;
	}
	public void setR53_aed(BigDecimal r53_aed) {
		this.r53_aed = r53_aed;
	}
	public BigDecimal getR53_fcy() {
		return r53_fcy;
	}
	public void setR53_fcy(BigDecimal r53_fcy) {
		this.r53_fcy = r53_fcy;
	}
	public BigDecimal getR53_total() {
		return r53_total;
	}
	public void setR53_total(BigDecimal r53_total) {
		this.r53_total = r53_total;
	}
	public BigDecimal getR53_commercial() {
		return r53_commercial;
	}
	public void setR53_commercial(BigDecimal r53_commercial) {
		this.r53_commercial = r53_commercial;
	}
	public BigDecimal getR53_gre() {
		return r53_gre;
	}
	public void setR53_gre(BigDecimal r53_gre) {
		this.r53_gre = r53_gre;
	}
	public BigDecimal getR53_fdbi() {
		return r53_fdbi;
	}
	public void setR53_fdbi(BigDecimal r53_fdbi) {
		this.r53_fdbi = r53_fdbi;
	}
	public BigDecimal getR53_sme() {
		return r53_sme;
	}
	public void setR53_sme(BigDecimal r53_sme) {
		this.r53_sme = r53_sme;
	}
	public BigDecimal getR53_individual() {
		return r53_individual;
	}
	public void setR53_individual(BigDecimal r53_individual) {
		this.r53_individual = r53_individual;
	}
	public String getR54_non_performing_loans1() {
		return r54_non_performing_loans1;
	}
	public void setR54_non_performing_loans1(String r54_non_performing_loans1) {
		this.r54_non_performing_loans1 = r54_non_performing_loans1;
	}
	public BigDecimal getR54_aed() {
		return r54_aed;
	}
	public void setR54_aed(BigDecimal r54_aed) {
		this.r54_aed = r54_aed;
	}
	public BigDecimal getR54_fcy() {
		return r54_fcy;
	}
	public void setR54_fcy(BigDecimal r54_fcy) {
		this.r54_fcy = r54_fcy;
	}
	public BigDecimal getR54_total() {
		return r54_total;
	}
	public void setR54_total(BigDecimal r54_total) {
		this.r54_total = r54_total;
	}
	public BigDecimal getR54_commercial() {
		return r54_commercial;
	}
	public void setR54_commercial(BigDecimal r54_commercial) {
		this.r54_commercial = r54_commercial;
	}
	public BigDecimal getR54_gre() {
		return r54_gre;
	}
	public void setR54_gre(BigDecimal r54_gre) {
		this.r54_gre = r54_gre;
	}
	public BigDecimal getR54_fdbi() {
		return r54_fdbi;
	}
	public void setR54_fdbi(BigDecimal r54_fdbi) {
		this.r54_fdbi = r54_fdbi;
	}
	public BigDecimal getR54_sme() {
		return r54_sme;
	}
	public void setR54_sme(BigDecimal r54_sme) {
		this.r54_sme = r54_sme;
	}
	public BigDecimal getR54_individual() {
		return r54_individual;
	}
	public void setR54_individual(BigDecimal r54_individual) {
		this.r54_individual = r54_individual;
	}
	public String getR55_non_performing_loans2() {
		return r55_non_performing_loans2;
	}
	public void setR55_non_performing_loans2(String r55_non_performing_loans2) {
		this.r55_non_performing_loans2 = r55_non_performing_loans2;
	}
	public BigDecimal getR55_aed() {
		return r55_aed;
	}
	public void setR55_aed(BigDecimal r55_aed) {
		this.r55_aed = r55_aed;
	}
	public BigDecimal getR55_fcy() {
		return r55_fcy;
	}
	public void setR55_fcy(BigDecimal r55_fcy) {
		this.r55_fcy = r55_fcy;
	}
	public BigDecimal getR55_total() {
		return r55_total;
	}
	public void setR55_total(BigDecimal r55_total) {
		this.r55_total = r55_total;
	}
	public BigDecimal getR55_commercial() {
		return r55_commercial;
	}
	public void setR55_commercial(BigDecimal r55_commercial) {
		this.r55_commercial = r55_commercial;
	}
	public BigDecimal getR55_gre() {
		return r55_gre;
	}
	public void setR55_gre(BigDecimal r55_gre) {
		this.r55_gre = r55_gre;
	}
	public BigDecimal getR55_fdbi() {
		return r55_fdbi;
	}
	public void setR55_fdbi(BigDecimal r55_fdbi) {
		this.r55_fdbi = r55_fdbi;
	}
	public BigDecimal getR55_sme() {
		return r55_sme;
	}
	public void setR55_sme(BigDecimal r55_sme) {
		this.r55_sme = r55_sme;
	}
	public BigDecimal getR55_individual() {
		return r55_individual;
	}
	public void setR55_individual(BigDecimal r55_individual) {
		this.r55_individual = r55_individual;
	}
	public String getR56_non_performing_loans3() {
		return r56_non_performing_loans3;
	}
	public void setR56_non_performing_loans3(String r56_non_performing_loans3) {
		this.r56_non_performing_loans3 = r56_non_performing_loans3;
	}
	public BigDecimal getR56_aed() {
		return r56_aed;
	}
	public void setR56_aed(BigDecimal r56_aed) {
		this.r56_aed = r56_aed;
	}
	public BigDecimal getR56_fcy() {
		return r56_fcy;
	}
	public void setR56_fcy(BigDecimal r56_fcy) {
		this.r56_fcy = r56_fcy;
	}
	public BigDecimal getR56_total() {
		return r56_total;
	}
	public void setR56_total(BigDecimal r56_total) {
		this.r56_total = r56_total;
	}
	public BigDecimal getR56_commercial() {
		return r56_commercial;
	}
	public void setR56_commercial(BigDecimal r56_commercial) {
		this.r56_commercial = r56_commercial;
	}
	public BigDecimal getR56_gre() {
		return r56_gre;
	}
	public void setR56_gre(BigDecimal r56_gre) {
		this.r56_gre = r56_gre;
	}
	public BigDecimal getR56_fdbi() {
		return r56_fdbi;
	}
	public void setR56_fdbi(BigDecimal r56_fdbi) {
		this.r56_fdbi = r56_fdbi;
	}
	public BigDecimal getR56_sme() {
		return r56_sme;
	}
	public void setR56_sme(BigDecimal r56_sme) {
		this.r56_sme = r56_sme;
	}
	public BigDecimal getR56_individual() {
		return r56_individual;
	}
	public void setR56_individual(BigDecimal r56_individual) {
		this.r56_individual = r56_individual;
	}
	public String getR57_period_wise() {
		return r57_period_wise;
	}
	public void setR57_period_wise(String r57_period_wise) {
		this.r57_period_wise = r57_period_wise;
	}
	public BigDecimal getR57_minimum_rate() {
		return r57_minimum_rate;
	}
	public void setR57_minimum_rate(BigDecimal r57_minimum_rate) {
		this.r57_minimum_rate = r57_minimum_rate;
	}
	public BigDecimal getR57_maximum_rate() {
		return r57_maximum_rate;
	}
	public void setR57_maximum_rate(BigDecimal r57_maximum_rate) {
		this.r57_maximum_rate = r57_maximum_rate;
	}
	public BigDecimal getR57_average_rate() {
		return r57_average_rate;
	}
	public void setR57_average_rate(BigDecimal r57_average_rate) {
		this.r57_average_rate = r57_average_rate;
	}
	public BigDecimal getR57_minimum_rate_inidiv() {
		return r57_minimum_rate_inidiv;
	}
	public void setR57_minimum_rate_inidiv(BigDecimal r57_minimum_rate_inidiv) {
		this.r57_minimum_rate_inidiv = r57_minimum_rate_inidiv;
	}
	public BigDecimal getR57_maximum_rate_inidiv() {
		return r57_maximum_rate_inidiv;
	}
	public void setR57_maximum_rate_inidiv(BigDecimal r57_maximum_rate_inidiv) {
		this.r57_maximum_rate_inidiv = r57_maximum_rate_inidiv;
	}
	public BigDecimal getR57_average_rate_inidiv() {
		return r57_average_rate_inidiv;
	}
	public void setR57_average_rate_inidiv(BigDecimal r57_average_rate_inidiv) {
		this.r57_average_rate_inidiv = r57_average_rate_inidiv;
	}
	public String getR58_period_wise1() {
		return r58_period_wise1;
	}
	public void setR58_period_wise1(String r58_period_wise1) {
		this.r58_period_wise1 = r58_period_wise1;
	}
	public BigDecimal getR58_minimum_rate() {
		return r58_minimum_rate;
	}
	public void setR58_minimum_rate(BigDecimal r58_minimum_rate) {
		this.r58_minimum_rate = r58_minimum_rate;
	}
	public BigDecimal getR58_maximum_rate() {
		return r58_maximum_rate;
	}
	public void setR58_maximum_rate(BigDecimal r58_maximum_rate) {
		this.r58_maximum_rate = r58_maximum_rate;
	}
	public BigDecimal getR58_average_rate() {
		return r58_average_rate;
	}
	public void setR58_average_rate(BigDecimal r58_average_rate) {
		this.r58_average_rate = r58_average_rate;
	}
	public BigDecimal getR58_minimum_rate_inidiv() {
		return r58_minimum_rate_inidiv;
	}
	public void setR58_minimum_rate_inidiv(BigDecimal r58_minimum_rate_inidiv) {
		this.r58_minimum_rate_inidiv = r58_minimum_rate_inidiv;
	}
	public BigDecimal getR58_maximum_rate_inidiv() {
		return r58_maximum_rate_inidiv;
	}
	public void setR58_maximum_rate_inidiv(BigDecimal r58_maximum_rate_inidiv) {
		this.r58_maximum_rate_inidiv = r58_maximum_rate_inidiv;
	}
	public BigDecimal getR58_average_rate_inidiv() {
		return r58_average_rate_inidiv;
	}
	public void setR58_average_rate_inidiv(BigDecimal r58_average_rate_inidiv) {
		this.r58_average_rate_inidiv = r58_average_rate_inidiv;
	}
	public String getR59_period_wise2() {
		return r59_period_wise2;
	}
	public void setR59_period_wise2(String r59_period_wise2) {
		this.r59_period_wise2 = r59_period_wise2;
	}
	public BigDecimal getR59_minimum_rate() {
		return r59_minimum_rate;
	}
	public void setR59_minimum_rate(BigDecimal r59_minimum_rate) {
		this.r59_minimum_rate = r59_minimum_rate;
	}
	public BigDecimal getR59_maximum_rate() {
		return r59_maximum_rate;
	}
	public void setR59_maximum_rate(BigDecimal r59_maximum_rate) {
		this.r59_maximum_rate = r59_maximum_rate;
	}
	public BigDecimal getR59_average_rate() {
		return r59_average_rate;
	}
	public void setR59_average_rate(BigDecimal r59_average_rate) {
		this.r59_average_rate = r59_average_rate;
	}
	public BigDecimal getR59_minimum_rate_inidiv() {
		return r59_minimum_rate_inidiv;
	}
	public void setR59_minimum_rate_inidiv(BigDecimal r59_minimum_rate_inidiv) {
		this.r59_minimum_rate_inidiv = r59_minimum_rate_inidiv;
	}
	public BigDecimal getR59_maximum_rate_inidiv() {
		return r59_maximum_rate_inidiv;
	}
	public void setR59_maximum_rate_inidiv(BigDecimal r59_maximum_rate_inidiv) {
		this.r59_maximum_rate_inidiv = r59_maximum_rate_inidiv;
	}
	public BigDecimal getR59_average_rate_inidiv() {
		return r59_average_rate_inidiv;
	}
	public void setR59_average_rate_inidiv(BigDecimal r59_average_rate_inidiv) {
		this.r59_average_rate_inidiv = r59_average_rate_inidiv;
	}
	public String getR60_period_wise3() {
		return r60_period_wise3;
	}
	public void setR60_period_wise3(String r60_period_wise3) {
		this.r60_period_wise3 = r60_period_wise3;
	}
	public BigDecimal getR60_minimum_rate() {
		return r60_minimum_rate;
	}
	public void setR60_minimum_rate(BigDecimal r60_minimum_rate) {
		this.r60_minimum_rate = r60_minimum_rate;
	}
	public BigDecimal getR60_maximum_rate() {
		return r60_maximum_rate;
	}
	public void setR60_maximum_rate(BigDecimal r60_maximum_rate) {
		this.r60_maximum_rate = r60_maximum_rate;
	}
	public BigDecimal getR60_average_rate() {
		return r60_average_rate;
	}
	public void setR60_average_rate(BigDecimal r60_average_rate) {
		this.r60_average_rate = r60_average_rate;
	}
	public BigDecimal getR60_minimum_rate_inidiv() {
		return r60_minimum_rate_inidiv;
	}
	public void setR60_minimum_rate_inidiv(BigDecimal r60_minimum_rate_inidiv) {
		this.r60_minimum_rate_inidiv = r60_minimum_rate_inidiv;
	}
	public BigDecimal getR60_maximum_rate_inidiv() {
		return r60_maximum_rate_inidiv;
	}
	public void setR60_maximum_rate_inidiv(BigDecimal r60_maximum_rate_inidiv) {
		this.r60_maximum_rate_inidiv = r60_maximum_rate_inidiv;
	}
	public BigDecimal getR60_average_rate_inidiv() {
		return r60_average_rate_inidiv;
	}
	public void setR60_average_rate_inidiv(BigDecimal r60_average_rate_inidiv) {
		this.r60_average_rate_inidiv = r60_average_rate_inidiv;
	}
	public String getR61_period_wise4() {
		return r61_period_wise4;
	}
	public void setR61_period_wise4(String r61_period_wise4) {
		this.r61_period_wise4 = r61_period_wise4;
	}
	public BigDecimal getR61_minimum_rate() {
		return r61_minimum_rate;
	}
	public void setR61_minimum_rate(BigDecimal r61_minimum_rate) {
		this.r61_minimum_rate = r61_minimum_rate;
	}
	public BigDecimal getR61_maximum_rate() {
		return r61_maximum_rate;
	}
	public void setR61_maximum_rate(BigDecimal r61_maximum_rate) {
		this.r61_maximum_rate = r61_maximum_rate;
	}
	public BigDecimal getR61_average_rate() {
		return r61_average_rate;
	}
	public void setR61_average_rate(BigDecimal r61_average_rate) {
		this.r61_average_rate = r61_average_rate;
	}
	public BigDecimal getR61_minimum_rate_inidiv() {
		return r61_minimum_rate_inidiv;
	}
	public void setR61_minimum_rate_inidiv(BigDecimal r61_minimum_rate_inidiv) {
		this.r61_minimum_rate_inidiv = r61_minimum_rate_inidiv;
	}
	public BigDecimal getR61_maximum_rate_inidiv() {
		return r61_maximum_rate_inidiv;
	}
	public void setR61_maximum_rate_inidiv(BigDecimal r61_maximum_rate_inidiv) {
		this.r61_maximum_rate_inidiv = r61_maximum_rate_inidiv;
	}
	public BigDecimal getR61_average_rate_inidiv() {
		return r61_average_rate_inidiv;
	}
	public void setR61_average_rate_inidiv(BigDecimal r61_average_rate_inidiv) {
		this.r61_average_rate_inidiv = r61_average_rate_inidiv;
	}
	public String getR62_period_wise5() {
		return r62_period_wise5;
	}
	public void setR62_period_wise5(String r62_period_wise5) {
		this.r62_period_wise5 = r62_period_wise5;
	}
	public BigDecimal getR62_minimum_rate() {
		return r62_minimum_rate;
	}
	public void setR62_minimum_rate(BigDecimal r62_minimum_rate) {
		this.r62_minimum_rate = r62_minimum_rate;
	}
	public BigDecimal getR62_maximum_rate() {
		return r62_maximum_rate;
	}
	public void setR62_maximum_rate(BigDecimal r62_maximum_rate) {
		this.r62_maximum_rate = r62_maximum_rate;
	}
	public BigDecimal getR62_average_rate() {
		return r62_average_rate;
	}
	public void setR62_average_rate(BigDecimal r62_average_rate) {
		this.r62_average_rate = r62_average_rate;
	}
	public BigDecimal getR62_minimum_rate_inidiv() {
		return r62_minimum_rate_inidiv;
	}
	public void setR62_minimum_rate_inidiv(BigDecimal r62_minimum_rate_inidiv) {
		this.r62_minimum_rate_inidiv = r62_minimum_rate_inidiv;
	}
	public BigDecimal getR62_maximum_rate_inidiv() {
		return r62_maximum_rate_inidiv;
	}
	public void setR62_maximum_rate_inidiv(BigDecimal r62_maximum_rate_inidiv) {
		this.r62_maximum_rate_inidiv = r62_maximum_rate_inidiv;
	}
	public BigDecimal getR62_average_rate_inidiv() {
		return r62_average_rate_inidiv;
	}
	public void setR62_average_rate_inidiv(BigDecimal r62_average_rate_inidiv) {
		this.r62_average_rate_inidiv = r62_average_rate_inidiv;
	}
	public String getR63_period_wise6() {
		return r63_period_wise6;
	}
	public void setR63_period_wise6(String r63_period_wise6) {
		this.r63_period_wise6 = r63_period_wise6;
	}
	public BigDecimal getR63_minimum_rate() {
		return r63_minimum_rate;
	}
	public void setR63_minimum_rate(BigDecimal r63_minimum_rate) {
		this.r63_minimum_rate = r63_minimum_rate;
	}
	public BigDecimal getR63_maximum_rate() {
		return r63_maximum_rate;
	}
	public void setR63_maximum_rate(BigDecimal r63_maximum_rate) {
		this.r63_maximum_rate = r63_maximum_rate;
	}
	public BigDecimal getR63_average_rate() {
		return r63_average_rate;
	}
	public void setR63_average_rate(BigDecimal r63_average_rate) {
		this.r63_average_rate = r63_average_rate;
	}
	public BigDecimal getR63_minimum_rate_inidiv() {
		return r63_minimum_rate_inidiv;
	}
	public void setR63_minimum_rate_inidiv(BigDecimal r63_minimum_rate_inidiv) {
		this.r63_minimum_rate_inidiv = r63_minimum_rate_inidiv;
	}
	public BigDecimal getR63_maximum_rate_inidiv() {
		return r63_maximum_rate_inidiv;
	}
	public void setR63_maximum_rate_inidiv(BigDecimal r63_maximum_rate_inidiv) {
		this.r63_maximum_rate_inidiv = r63_maximum_rate_inidiv;
	}
	public BigDecimal getR63_average_rate_inidiv() {
		return r63_average_rate_inidiv;
	}
	public void setR63_average_rate_inidiv(BigDecimal r63_average_rate_inidiv) {
		this.r63_average_rate_inidiv = r63_average_rate_inidiv;
	}
	public String getR64_period_wise7() {
		return r64_period_wise7;
	}
	public void setR64_period_wise7(String r64_period_wise7) {
		this.r64_period_wise7 = r64_period_wise7;
	}
	public BigDecimal getR64_minimum_rate() {
		return r64_minimum_rate;
	}
	public void setR64_minimum_rate(BigDecimal r64_minimum_rate) {
		this.r64_minimum_rate = r64_minimum_rate;
	}
	public BigDecimal getR64_maximum_rate() {
		return r64_maximum_rate;
	}
	public void setR64_maximum_rate(BigDecimal r64_maximum_rate) {
		this.r64_maximum_rate = r64_maximum_rate;
	}
	public BigDecimal getR64_average_rate() {
		return r64_average_rate;
	}
	public void setR64_average_rate(BigDecimal r64_average_rate) {
		this.r64_average_rate = r64_average_rate;
	}
	public BigDecimal getR64_minimum_rate_inidiv() {
		return r64_minimum_rate_inidiv;
	}
	public void setR64_minimum_rate_inidiv(BigDecimal r64_minimum_rate_inidiv) {
		this.r64_minimum_rate_inidiv = r64_minimum_rate_inidiv;
	}
	public BigDecimal getR64_maximum_rate_inidiv() {
		return r64_maximum_rate_inidiv;
	}
	public void setR64_maximum_rate_inidiv(BigDecimal r64_maximum_rate_inidiv) {
		this.r64_maximum_rate_inidiv = r64_maximum_rate_inidiv;
	}
	public BigDecimal getR64_average_rate_inidiv() {
		return r64_average_rate_inidiv;
	}
	public void setR64_average_rate_inidiv(BigDecimal r64_average_rate_inidiv) {
		this.r64_average_rate_inidiv = r64_average_rate_inidiv;
	}
	public String getR65_period_wise_saving() {
		return r65_period_wise_saving;
	}
	public void setR65_period_wise_saving(String r65_period_wise_saving) {
		this.r65_period_wise_saving = r65_period_wise_saving;
	}
	public BigDecimal getR65_minimum_rate() {
		return r65_minimum_rate;
	}
	public void setR65_minimum_rate(BigDecimal r65_minimum_rate) {
		this.r65_minimum_rate = r65_minimum_rate;
	}
	public BigDecimal getR65_maximum_rate() {
		return r65_maximum_rate;
	}
	public void setR65_maximum_rate(BigDecimal r65_maximum_rate) {
		this.r65_maximum_rate = r65_maximum_rate;
	}
	public BigDecimal getR65_average_rate() {
		return r65_average_rate;
	}
	public void setR65_average_rate(BigDecimal r65_average_rate) {
		this.r65_average_rate = r65_average_rate;
	}
	public BigDecimal getR65_minimum_rate_inidiv() {
		return r65_minimum_rate_inidiv;
	}
	public void setR65_minimum_rate_inidiv(BigDecimal r65_minimum_rate_inidiv) {
		this.r65_minimum_rate_inidiv = r65_minimum_rate_inidiv;
	}
	public BigDecimal getR65_maximum_rate_inidiv() {
		return r65_maximum_rate_inidiv;
	}
	public void setR65_maximum_rate_inidiv(BigDecimal r65_maximum_rate_inidiv) {
		this.r65_maximum_rate_inidiv = r65_maximum_rate_inidiv;
	}
	public BigDecimal getR65_average_rate_inidiv() {
		return r65_average_rate_inidiv;
	}
	public void setR65_average_rate_inidiv(BigDecimal r65_average_rate_inidiv) {
		this.r65_average_rate_inidiv = r65_average_rate_inidiv;
	}
	public String getR66_period_wise_call() {
		return r66_period_wise_call;
	}
	public void setR66_period_wise_call(String r66_period_wise_call) {
		this.r66_period_wise_call = r66_period_wise_call;
	}
	public BigDecimal getR66_minimum_rate() {
		return r66_minimum_rate;
	}
	public void setR66_minimum_rate(BigDecimal r66_minimum_rate) {
		this.r66_minimum_rate = r66_minimum_rate;
	}
	public BigDecimal getR66_maximum_rate() {
		return r66_maximum_rate;
	}
	public void setR66_maximum_rate(BigDecimal r66_maximum_rate) {
		this.r66_maximum_rate = r66_maximum_rate;
	}
	public BigDecimal getR66_average_rate() {
		return r66_average_rate;
	}
	public void setR66_average_rate(BigDecimal r66_average_rate) {
		this.r66_average_rate = r66_average_rate;
	}
	public BigDecimal getR66_minimum_rate_inidiv() {
		return r66_minimum_rate_inidiv;
	}
	public void setR66_minimum_rate_inidiv(BigDecimal r66_minimum_rate_inidiv) {
		this.r66_minimum_rate_inidiv = r66_minimum_rate_inidiv;
	}
	public BigDecimal getR66_maximum_rate_inidiv() {
		return r66_maximum_rate_inidiv;
	}
	public void setR66_maximum_rate_inidiv(BigDecimal r66_maximum_rate_inidiv) {
		this.r66_maximum_rate_inidiv = r66_maximum_rate_inidiv;
	}
	public BigDecimal getR66_average_rate_inidiv() {
		return r66_average_rate_inidiv;
	}
	public void setR66_average_rate_inidiv(BigDecimal r66_average_rate_inidiv) {
		this.r66_average_rate_inidiv = r66_average_rate_inidiv;
	}
	public String getR67_period_wise_current() {
		return r67_period_wise_current;
	}
	public void setR67_period_wise_current(String r67_period_wise_current) {
		this.r67_period_wise_current = r67_period_wise_current;
	}
	public BigDecimal getR67_minimum_rate() {
		return r67_minimum_rate;
	}
	public void setR67_minimum_rate(BigDecimal r67_minimum_rate) {
		this.r67_minimum_rate = r67_minimum_rate;
	}
	public BigDecimal getR67_maximum_rate() {
		return r67_maximum_rate;
	}
	public void setR67_maximum_rate(BigDecimal r67_maximum_rate) {
		this.r67_maximum_rate = r67_maximum_rate;
	}
	public BigDecimal getR67_average_rate() {
		return r67_average_rate;
	}
	public void setR67_average_rate(BigDecimal r67_average_rate) {
		this.r67_average_rate = r67_average_rate;
	}
	public BigDecimal getR67_minimum_rate_inidiv() {
		return r67_minimum_rate_inidiv;
	}
	public void setR67_minimum_rate_inidiv(BigDecimal r67_minimum_rate_inidiv) {
		this.r67_minimum_rate_inidiv = r67_minimum_rate_inidiv;
	}
	public BigDecimal getR67_maximum_rate_inidiv() {
		return r67_maximum_rate_inidiv;
	}
	public void setR67_maximum_rate_inidiv(BigDecimal r67_maximum_rate_inidiv) {
		this.r67_maximum_rate_inidiv = r67_maximum_rate_inidiv;
	}
	public BigDecimal getR67_average_rate_inidiv() {
		return r67_average_rate_inidiv;
	}
	public void setR67_average_rate_inidiv(BigDecimal r67_average_rate_inidiv) {
		this.r67_average_rate_inidiv = r67_average_rate_inidiv;
	}
	public String getR68_period_wise_distribution() {
		return r68_period_wise_distribution;
	}
	public void setR68_period_wise_distribution(String r68_period_wise_distribution) {
		this.r68_period_wise_distribution = r68_period_wise_distribution;
	}
	public BigDecimal getR68_minimum_rate() {
		return r68_minimum_rate;
	}
	public void setR68_minimum_rate(BigDecimal r68_minimum_rate) {
		this.r68_minimum_rate = r68_minimum_rate;
	}
	public BigDecimal getR68_maximum_rate() {
		return r68_maximum_rate;
	}
	public void setR68_maximum_rate(BigDecimal r68_maximum_rate) {
		this.r68_maximum_rate = r68_maximum_rate;
	}
	public BigDecimal getR68_average_rate() {
		return r68_average_rate;
	}
	public void setR68_average_rate(BigDecimal r68_average_rate) {
		this.r68_average_rate = r68_average_rate;
	}
	public BigDecimal getR68_minimum_rate_inidiv() {
		return r68_minimum_rate_inidiv;
	}
	public void setR68_minimum_rate_inidiv(BigDecimal r68_minimum_rate_inidiv) {
		this.r68_minimum_rate_inidiv = r68_minimum_rate_inidiv;
	}
	public BigDecimal getR68_maximum_rate_inidiv() {
		return r68_maximum_rate_inidiv;
	}
	public void setR68_maximum_rate_inidiv(BigDecimal r68_maximum_rate_inidiv) {
		this.r68_maximum_rate_inidiv = r68_maximum_rate_inidiv;
	}
	public BigDecimal getR68_average_rate_inidiv() {
		return r68_average_rate_inidiv;
	}
	public void setR68_average_rate_inidiv(BigDecimal r68_average_rate_inidiv) {
		this.r68_average_rate_inidiv = r68_average_rate_inidiv;
	}
	public String getR69_period_wise_distribution1() {
		return r69_period_wise_distribution1;
	}
	public void setR69_period_wise_distribution1(String r69_period_wise_distribution1) {
		this.r69_period_wise_distribution1 = r69_period_wise_distribution1;
	}
	public BigDecimal getR69_minimum_rate() {
		return r69_minimum_rate;
	}
	public void setR69_minimum_rate(BigDecimal r69_minimum_rate) {
		this.r69_minimum_rate = r69_minimum_rate;
	}
	public BigDecimal getR69_maximum_rate() {
		return r69_maximum_rate;
	}
	public void setR69_maximum_rate(BigDecimal r69_maximum_rate) {
		this.r69_maximum_rate = r69_maximum_rate;
	}
	public BigDecimal getR69_average_rate() {
		return r69_average_rate;
	}
	public void setR69_average_rate(BigDecimal r69_average_rate) {
		this.r69_average_rate = r69_average_rate;
	}
	public BigDecimal getR69_minimum_rate_inidiv() {
		return r69_minimum_rate_inidiv;
	}
	public void setR69_minimum_rate_inidiv(BigDecimal r69_minimum_rate_inidiv) {
		this.r69_minimum_rate_inidiv = r69_minimum_rate_inidiv;
	}
	public BigDecimal getR69_maximum_rate_inidiv() {
		return r69_maximum_rate_inidiv;
	}
	public void setR69_maximum_rate_inidiv(BigDecimal r69_maximum_rate_inidiv) {
		this.r69_maximum_rate_inidiv = r69_maximum_rate_inidiv;
	}
	public BigDecimal getR69_average_rate_inidiv() {
		return r69_average_rate_inidiv;
	}
	public void setR69_average_rate_inidiv(BigDecimal r69_average_rate_inidiv) {
		this.r69_average_rate_inidiv = r69_average_rate_inidiv;
	}
	public String getR70_period_wise_distribution2() {
		return r70_period_wise_distribution2;
	}
	public void setR70_period_wise_distribution2(String r70_period_wise_distribution2) {
		this.r70_period_wise_distribution2 = r70_period_wise_distribution2;
	}
	public BigDecimal getR70_minimum_rate() {
		return r70_minimum_rate;
	}
	public void setR70_minimum_rate(BigDecimal r70_minimum_rate) {
		this.r70_minimum_rate = r70_minimum_rate;
	}
	public BigDecimal getR70_maximum_rate() {
		return r70_maximum_rate;
	}
	public void setR70_maximum_rate(BigDecimal r70_maximum_rate) {
		this.r70_maximum_rate = r70_maximum_rate;
	}
	public BigDecimal getR70_average_rate() {
		return r70_average_rate;
	}
	public void setR70_average_rate(BigDecimal r70_average_rate) {
		this.r70_average_rate = r70_average_rate;
	}
	public BigDecimal getR70_minimum_rate_inidiv() {
		return r70_minimum_rate_inidiv;
	}
	public void setR70_minimum_rate_inidiv(BigDecimal r70_minimum_rate_inidiv) {
		this.r70_minimum_rate_inidiv = r70_minimum_rate_inidiv;
	}
	public BigDecimal getR70_maximum_rate_inidiv() {
		return r70_maximum_rate_inidiv;
	}
	public void setR70_maximum_rate_inidiv(BigDecimal r70_maximum_rate_inidiv) {
		this.r70_maximum_rate_inidiv = r70_maximum_rate_inidiv;
	}
	public BigDecimal getR70_average_rate_inidiv() {
		return r70_average_rate_inidiv;
	}
	public void setR70_average_rate_inidiv(BigDecimal r70_average_rate_inidiv) {
		this.r70_average_rate_inidiv = r70_average_rate_inidiv;
	}
	public String getR71_period_wise_distribution3() {
		return r71_period_wise_distribution3;
	}
	public void setR71_period_wise_distribution3(String r71_period_wise_distribution3) {
		this.r71_period_wise_distribution3 = r71_period_wise_distribution3;
	}
	public BigDecimal getR71_minimum_rate() {
		return r71_minimum_rate;
	}
	public void setR71_minimum_rate(BigDecimal r71_minimum_rate) {
		this.r71_minimum_rate = r71_minimum_rate;
	}
	public BigDecimal getR71_maximum_rate() {
		return r71_maximum_rate;
	}
	public void setR71_maximum_rate(BigDecimal r71_maximum_rate) {
		this.r71_maximum_rate = r71_maximum_rate;
	}
	public BigDecimal getR71_average_rate() {
		return r71_average_rate;
	}
	public void setR71_average_rate(BigDecimal r71_average_rate) {
		this.r71_average_rate = r71_average_rate;
	}
	public BigDecimal getR71_minimum_rate_inidiv() {
		return r71_minimum_rate_inidiv;
	}
	public void setR71_minimum_rate_inidiv(BigDecimal r71_minimum_rate_inidiv) {
		this.r71_minimum_rate_inidiv = r71_minimum_rate_inidiv;
	}
	public BigDecimal getR71_maximum_rate_inidiv() {
		return r71_maximum_rate_inidiv;
	}
	public void setR71_maximum_rate_inidiv(BigDecimal r71_maximum_rate_inidiv) {
		this.r71_maximum_rate_inidiv = r71_maximum_rate_inidiv;
	}
	public BigDecimal getR71_average_rate_inidiv() {
		return r71_average_rate_inidiv;
	}
	public void setR71_average_rate_inidiv(BigDecimal r71_average_rate_inidiv) {
		this.r71_average_rate_inidiv = r71_average_rate_inidiv;
	}
	public String getR72_period_wise_distribution4() {
		return r72_period_wise_distribution4;
	}
	public void setR72_period_wise_distribution4(String r72_period_wise_distribution4) {
		this.r72_period_wise_distribution4 = r72_period_wise_distribution4;
	}
	public BigDecimal getR72_minimum_rate() {
		return r72_minimum_rate;
	}
	public void setR72_minimum_rate(BigDecimal r72_minimum_rate) {
		this.r72_minimum_rate = r72_minimum_rate;
	}
	public BigDecimal getR72_maximum_rate() {
		return r72_maximum_rate;
	}
	public void setR72_maximum_rate(BigDecimal r72_maximum_rate) {
		this.r72_maximum_rate = r72_maximum_rate;
	}
	public BigDecimal getR72_average_rate() {
		return r72_average_rate;
	}
	public void setR72_average_rate(BigDecimal r72_average_rate) {
		this.r72_average_rate = r72_average_rate;
	}
	public BigDecimal getR72_minimum_rate_inidiv() {
		return r72_minimum_rate_inidiv;
	}
	public void setR72_minimum_rate_inidiv(BigDecimal r72_minimum_rate_inidiv) {
		this.r72_minimum_rate_inidiv = r72_minimum_rate_inidiv;
	}
	public BigDecimal getR72_maximum_rate_inidiv() {
		return r72_maximum_rate_inidiv;
	}
	public void setR72_maximum_rate_inidiv(BigDecimal r72_maximum_rate_inidiv) {
		this.r72_maximum_rate_inidiv = r72_maximum_rate_inidiv;
	}
	public BigDecimal getR72_average_rate_inidiv() {
		return r72_average_rate_inidiv;
	}
	public void setR72_average_rate_inidiv(BigDecimal r72_average_rate_inidiv) {
		this.r72_average_rate_inidiv = r72_average_rate_inidiv;
	}
	public String getR73_period_wise_distribution5() {
		return r73_period_wise_distribution5;
	}
	public void setR73_period_wise_distribution5(String r73_period_wise_distribution5) {
		this.r73_period_wise_distribution5 = r73_period_wise_distribution5;
	}
	public BigDecimal getR73_minimum_rate() {
		return r73_minimum_rate;
	}
	public void setR73_minimum_rate(BigDecimal r73_minimum_rate) {
		this.r73_minimum_rate = r73_minimum_rate;
	}
	public BigDecimal getR73_maximum_rate() {
		return r73_maximum_rate;
	}
	public void setR73_maximum_rate(BigDecimal r73_maximum_rate) {
		this.r73_maximum_rate = r73_maximum_rate;
	}
	public BigDecimal getR73_average_rate() {
		return r73_average_rate;
	}
	public void setR73_average_rate(BigDecimal r73_average_rate) {
		this.r73_average_rate = r73_average_rate;
	}
	public BigDecimal getR73_minimum_rate_inidiv() {
		return r73_minimum_rate_inidiv;
	}
	public void setR73_minimum_rate_inidiv(BigDecimal r73_minimum_rate_inidiv) {
		this.r73_minimum_rate_inidiv = r73_minimum_rate_inidiv;
	}
	public BigDecimal getR73_maximum_rate_inidiv() {
		return r73_maximum_rate_inidiv;
	}
	public void setR73_maximum_rate_inidiv(BigDecimal r73_maximum_rate_inidiv) {
		this.r73_maximum_rate_inidiv = r73_maximum_rate_inidiv;
	}
	public BigDecimal getR73_average_rate_inidiv() {
		return r73_average_rate_inidiv;
	}
	public void setR73_average_rate_inidiv(BigDecimal r73_average_rate_inidiv) {
		this.r73_average_rate_inidiv = r73_average_rate_inidiv;
	}
	public String getR74_period_wise_distribution6() {
		return r74_period_wise_distribution6;
	}
	public void setR74_period_wise_distribution6(String r74_period_wise_distribution6) {
		this.r74_period_wise_distribution6 = r74_period_wise_distribution6;
	}
	public BigDecimal getR74_minimum_rate() {
		return r74_minimum_rate;
	}
	public void setR74_minimum_rate(BigDecimal r74_minimum_rate) {
		this.r74_minimum_rate = r74_minimum_rate;
	}
	public BigDecimal getR74_maximum_rate() {
		return r74_maximum_rate;
	}
	public void setR74_maximum_rate(BigDecimal r74_maximum_rate) {
		this.r74_maximum_rate = r74_maximum_rate;
	}
	public BigDecimal getR74_average_rate() {
		return r74_average_rate;
	}
	public void setR74_average_rate(BigDecimal r74_average_rate) {
		this.r74_average_rate = r74_average_rate;
	}
	public BigDecimal getR74_minimum_rate_inidiv() {
		return r74_minimum_rate_inidiv;
	}
	public void setR74_minimum_rate_inidiv(BigDecimal r74_minimum_rate_inidiv) {
		this.r74_minimum_rate_inidiv = r74_minimum_rate_inidiv;
	}
	public BigDecimal getR74_maximum_rate_inidiv() {
		return r74_maximum_rate_inidiv;
	}
	public void setR74_maximum_rate_inidiv(BigDecimal r74_maximum_rate_inidiv) {
		this.r74_maximum_rate_inidiv = r74_maximum_rate_inidiv;
	}
	public BigDecimal getR74_average_rate_inidiv() {
		return r74_average_rate_inidiv;
	}
	public void setR74_average_rate_inidiv(BigDecimal r74_average_rate_inidiv) {
		this.r74_average_rate_inidiv = r74_average_rate_inidiv;
	}
	public String getR75_period_wise_distribution7() {
		return r75_period_wise_distribution7;
	}
	public void setR75_period_wise_distribution7(String r75_period_wise_distribution7) {
		this.r75_period_wise_distribution7 = r75_period_wise_distribution7;
	}
	public BigDecimal getR75_minimum_rate() {
		return r75_minimum_rate;
	}
	public void setR75_minimum_rate(BigDecimal r75_minimum_rate) {
		this.r75_minimum_rate = r75_minimum_rate;
	}
	public BigDecimal getR75_maximum_rate() {
		return r75_maximum_rate;
	}
	public void setR75_maximum_rate(BigDecimal r75_maximum_rate) {
		this.r75_maximum_rate = r75_maximum_rate;
	}
	public BigDecimal getR75_average_rate() {
		return r75_average_rate;
	}
	public void setR75_average_rate(BigDecimal r75_average_rate) {
		this.r75_average_rate = r75_average_rate;
	}
	public BigDecimal getR75_minimum_rate_inidiv() {
		return r75_minimum_rate_inidiv;
	}
	public void setR75_minimum_rate_inidiv(BigDecimal r75_minimum_rate_inidiv) {
		this.r75_minimum_rate_inidiv = r75_minimum_rate_inidiv;
	}
	public BigDecimal getR75_maximum_rate_inidiv() {
		return r75_maximum_rate_inidiv;
	}
	public void setR75_maximum_rate_inidiv(BigDecimal r75_maximum_rate_inidiv) {
		this.r75_maximum_rate_inidiv = r75_maximum_rate_inidiv;
	}
	public BigDecimal getR75_average_rate_inidiv() {
		return r75_average_rate_inidiv;
	}
	public void setR75_average_rate_inidiv(BigDecimal r75_average_rate_inidiv) {
		this.r75_average_rate_inidiv = r75_average_rate_inidiv;
	}
	public String getR76_period_wise_distribution_saving() {
		return r76_period_wise_distribution_saving;
	}
	public void setR76_period_wise_distribution_saving(String r76_period_wise_distribution_saving) {
		this.r76_period_wise_distribution_saving = r76_period_wise_distribution_saving;
	}
	public BigDecimal getR76_minimum_rate() {
		return r76_minimum_rate;
	}
	public void setR76_minimum_rate(BigDecimal r76_minimum_rate) {
		this.r76_minimum_rate = r76_minimum_rate;
	}
	public BigDecimal getR76_maximum_rate() {
		return r76_maximum_rate;
	}
	public void setR76_maximum_rate(BigDecimal r76_maximum_rate) {
		this.r76_maximum_rate = r76_maximum_rate;
	}
	public BigDecimal getR76_average_rate() {
		return r76_average_rate;
	}
	public void setR76_average_rate(BigDecimal r76_average_rate) {
		this.r76_average_rate = r76_average_rate;
	}
	public BigDecimal getR76_minimum_rate_inidiv() {
		return r76_minimum_rate_inidiv;
	}
	public void setR76_minimum_rate_inidiv(BigDecimal r76_minimum_rate_inidiv) {
		this.r76_minimum_rate_inidiv = r76_minimum_rate_inidiv;
	}
	public BigDecimal getR76_maximum_rate_inidiv() {
		return r76_maximum_rate_inidiv;
	}
	public void setR76_maximum_rate_inidiv(BigDecimal r76_maximum_rate_inidiv) {
		this.r76_maximum_rate_inidiv = r76_maximum_rate_inidiv;
	}
	public BigDecimal getR76_average_rate_inidiv() {
		return r76_average_rate_inidiv;
	}
	public void setR76_average_rate_inidiv(BigDecimal r76_average_rate_inidiv) {
		this.r76_average_rate_inidiv = r76_average_rate_inidiv;
	}
	public String getR77_period_wise_distribution_call() {
		return r77_period_wise_distribution_call;
	}
	public void setR77_period_wise_distribution_call(String r77_period_wise_distribution_call) {
		this.r77_period_wise_distribution_call = r77_period_wise_distribution_call;
	}
	public BigDecimal getR77_minimum_rate() {
		return r77_minimum_rate;
	}
	public void setR77_minimum_rate(BigDecimal r77_minimum_rate) {
		this.r77_minimum_rate = r77_minimum_rate;
	}
	public BigDecimal getR77_maximum_rate() {
		return r77_maximum_rate;
	}
	public void setR77_maximum_rate(BigDecimal r77_maximum_rate) {
		this.r77_maximum_rate = r77_maximum_rate;
	}
	public BigDecimal getR77_average_rate() {
		return r77_average_rate;
	}
	public void setR77_average_rate(BigDecimal r77_average_rate) {
		this.r77_average_rate = r77_average_rate;
	}
	public BigDecimal getR77_minimum_rate_inidiv() {
		return r77_minimum_rate_inidiv;
	}
	public void setR77_minimum_rate_inidiv(BigDecimal r77_minimum_rate_inidiv) {
		this.r77_minimum_rate_inidiv = r77_minimum_rate_inidiv;
	}
	public BigDecimal getR77_maximum_rate_inidiv() {
		return r77_maximum_rate_inidiv;
	}
	public void setR77_maximum_rate_inidiv(BigDecimal r77_maximum_rate_inidiv) {
		this.r77_maximum_rate_inidiv = r77_maximum_rate_inidiv;
	}
	public BigDecimal getR77_average_rate_inidiv() {
		return r77_average_rate_inidiv;
	}
	public void setR77_average_rate_inidiv(BigDecimal r77_average_rate_inidiv) {
		this.r77_average_rate_inidiv = r77_average_rate_inidiv;
	}
	public String getR78_period_wise_distribution_current() {
		return r78_period_wise_distribution_current;
	}
	public void setR78_period_wise_distribution_current(String r78_period_wise_distribution_current) {
		this.r78_period_wise_distribution_current = r78_period_wise_distribution_current;
	}
	public BigDecimal getR78_minimum_rate() {
		return r78_minimum_rate;
	}
	public void setR78_minimum_rate(BigDecimal r78_minimum_rate) {
		this.r78_minimum_rate = r78_minimum_rate;
	}
	public BigDecimal getR78_maximum_rate() {
		return r78_maximum_rate;
	}
	public void setR78_maximum_rate(BigDecimal r78_maximum_rate) {
		this.r78_maximum_rate = r78_maximum_rate;
	}
	public BigDecimal getR78_average_rate() {
		return r78_average_rate;
	}
	public void setR78_average_rate(BigDecimal r78_average_rate) {
		this.r78_average_rate = r78_average_rate;
	}
	public BigDecimal getR78_minimum_rate_inidiv() {
		return r78_minimum_rate_inidiv;
	}
	public void setR78_minimum_rate_inidiv(BigDecimal r78_minimum_rate_inidiv) {
		this.r78_minimum_rate_inidiv = r78_minimum_rate_inidiv;
	}
	public BigDecimal getR78_maximum_rate_inidiv() {
		return r78_maximum_rate_inidiv;
	}
	public void setR78_maximum_rate_inidiv(BigDecimal r78_maximum_rate_inidiv) {
		this.r78_maximum_rate_inidiv = r78_maximum_rate_inidiv;
	}
	public BigDecimal getR78_average_rate_inidiv() {
		return r78_average_rate_inidiv;
	}
	public void setR78_average_rate_inidiv(BigDecimal r78_average_rate_inidiv) {
		this.r78_average_rate_inidiv = r78_average_rate_inidiv;
	}
	public String getR79_period_wise_week() {
		return r79_period_wise_week;
	}
	public void setR79_period_wise_week(String r79_period_wise_week) {
		this.r79_period_wise_week = r79_period_wise_week;
	}
	public BigDecimal getR79_minimum_rate() {
		return r79_minimum_rate;
	}
	public void setR79_minimum_rate(BigDecimal r79_minimum_rate) {
		this.r79_minimum_rate = r79_minimum_rate;
	}
	public BigDecimal getR79_maximum_rate() {
		return r79_maximum_rate;
	}
	public void setR79_maximum_rate(BigDecimal r79_maximum_rate) {
		this.r79_maximum_rate = r79_maximum_rate;
	}
	public BigDecimal getR79_average_rate() {
		return r79_average_rate;
	}
	public void setR79_average_rate(BigDecimal r79_average_rate) {
		this.r79_average_rate = r79_average_rate;
	}
	public String getR80_period_wise_1month() {
		return r80_period_wise_1month;
	}
	public void setR80_period_wise_1month(String r80_period_wise_1month) {
		this.r80_period_wise_1month = r80_period_wise_1month;
	}
	public BigDecimal getR80_minimum_rate() {
		return r80_minimum_rate;
	}
	public void setR80_minimum_rate(BigDecimal r80_minimum_rate) {
		this.r80_minimum_rate = r80_minimum_rate;
	}
	public BigDecimal getR80_maximum_rate() {
		return r80_maximum_rate;
	}
	public void setR80_maximum_rate(BigDecimal r80_maximum_rate) {
		this.r80_maximum_rate = r80_maximum_rate;
	}
	public BigDecimal getR80_average_rate() {
		return r80_average_rate;
	}
	public void setR80_average_rate(BigDecimal r80_average_rate) {
		this.r80_average_rate = r80_average_rate;
	}
	public String getR81_period_wise_3month() {
		return r81_period_wise_3month;
	}
	public void setR81_period_wise_3month(String r81_period_wise_3month) {
		this.r81_period_wise_3month = r81_period_wise_3month;
	}
	public BigDecimal getR81_minimum_rate() {
		return r81_minimum_rate;
	}
	public void setR81_minimum_rate(BigDecimal r81_minimum_rate) {
		this.r81_minimum_rate = r81_minimum_rate;
	}
	public BigDecimal getR81_maximum_rate() {
		return r81_maximum_rate;
	}
	public void setR81_maximum_rate(BigDecimal r81_maximum_rate) {
		this.r81_maximum_rate = r81_maximum_rate;
	}
	public BigDecimal getR81_average_rate() {
		return r81_average_rate;
	}
	public void setR81_average_rate(BigDecimal r81_average_rate) {
		this.r81_average_rate = r81_average_rate;
	}
	public String getR82_period_wise_6month() {
		return r82_period_wise_6month;
	}
	public void setR82_period_wise_6month(String r82_period_wise_6month) {
		this.r82_period_wise_6month = r82_period_wise_6month;
	}
	public BigDecimal getR82_minimum_rate() {
		return r82_minimum_rate;
	}
	public void setR82_minimum_rate(BigDecimal r82_minimum_rate) {
		this.r82_minimum_rate = r82_minimum_rate;
	}
	public BigDecimal getR82_maximum_rate() {
		return r82_maximum_rate;
	}
	public void setR82_maximum_rate(BigDecimal r82_maximum_rate) {
		this.r82_maximum_rate = r82_maximum_rate;
	}
	public BigDecimal getR82_average_rate() {
		return r82_average_rate;
	}
	public void setR82_average_rate(BigDecimal r82_average_rate) {
		this.r82_average_rate = r82_average_rate;
	}
	public String getR83_period_wise_year() {
		return r83_period_wise_year;
	}
	public void setR83_period_wise_year(String r83_period_wise_year) {
		this.r83_period_wise_year = r83_period_wise_year;
	}
	public BigDecimal getR83_minimum_rate() {
		return r83_minimum_rate;
	}
	public void setR83_minimum_rate(BigDecimal r83_minimum_rate) {
		this.r83_minimum_rate = r83_minimum_rate;
	}
	public BigDecimal getR83_maximum_rate() {
		return r83_maximum_rate;
	}
	public void setR83_maximum_rate(BigDecimal r83_maximum_rate) {
		this.r83_maximum_rate = r83_maximum_rate;
	}
	public BigDecimal getR83_average_rate() {
		return r83_average_rate;
	}
	public void setR83_average_rate(BigDecimal r83_average_rate) {
		this.r83_average_rate = r83_average_rate;
	}
	public String getR84_interest_rate() {
		return r84_interest_rate;
	}
	public void setR84_interest_rate(String r84_interest_rate) {
		this.r84_interest_rate = r84_interest_rate;
	}
	public BigDecimal getR84_minimum_rate() {
		return r84_minimum_rate;
	}
	public void setR84_minimum_rate(BigDecimal r84_minimum_rate) {
		this.r84_minimum_rate = r84_minimum_rate;
	}
	public BigDecimal getR84_maximum_rate() {
		return r84_maximum_rate;
	}
	public void setR84_maximum_rate(BigDecimal r84_maximum_rate) {
		this.r84_maximum_rate = r84_maximum_rate;
	}
	public BigDecimal getR84_average_rate() {
		return r84_average_rate;
	}
	public void setR84_average_rate(BigDecimal r84_average_rate) {
		this.r84_average_rate = r84_average_rate;
	}
	public String getR85_interest_profit() {
		return r85_interest_profit;
	}
	public void setR85_interest_profit(String r85_interest_profit) {
		this.r85_interest_profit = r85_interest_profit;
	}
	public BigDecimal getR85_minimum_rate() {
		return r85_minimum_rate;
	}
	public void setR85_minimum_rate(BigDecimal r85_minimum_rate) {
		this.r85_minimum_rate = r85_minimum_rate;
	}
	public BigDecimal getR85_maximum_rate() {
		return r85_maximum_rate;
	}
	public void setR85_maximum_rate(BigDecimal r85_maximum_rate) {
		this.r85_maximum_rate = r85_maximum_rate;
	}
	public BigDecimal getR85_average_rate() {
		return r85_average_rate;
	}
	public void setR85_average_rate(BigDecimal r85_average_rate) {
		this.r85_average_rate = r85_average_rate;
	}
	public String getR86_aed_50k() {
		return r86_aed_50k;
	}
	public void setR86_aed_50k(String r86_aed_50k) {
		this.r86_aed_50k = r86_aed_50k;
	}
	public BigDecimal getR86_minimum_rate() {
		return r86_minimum_rate;
	}
	public void setR86_minimum_rate(BigDecimal r86_minimum_rate) {
		this.r86_minimum_rate = r86_minimum_rate;
	}
	public BigDecimal getR86_maximum_rate() {
		return r86_maximum_rate;
	}
	public void setR86_maximum_rate(BigDecimal r86_maximum_rate) {
		this.r86_maximum_rate = r86_maximum_rate;
	}
	public BigDecimal getR86_average_rate() {
		return r86_average_rate;
	}
	public void setR86_average_rate(BigDecimal r86_average_rate) {
		this.r86_average_rate = r86_average_rate;
	}
	public String getR87_aed_100k() {
		return r87_aed_100k;
	}
	public void setR87_aed_100k(String r87_aed_100k) {
		this.r87_aed_100k = r87_aed_100k;
	}
	public BigDecimal getR87_minimum_rate() {
		return r87_minimum_rate;
	}
	public void setR87_minimum_rate(BigDecimal r87_minimum_rate) {
		this.r87_minimum_rate = r87_minimum_rate;
	}
	public BigDecimal getR87_maximum_rate() {
		return r87_maximum_rate;
	}
	public void setR87_maximum_rate(BigDecimal r87_maximum_rate) {
		this.r87_maximum_rate = r87_maximum_rate;
	}
	public BigDecimal getR87_average_rate() {
		return r87_average_rate;
	}
	public void setR87_average_rate(BigDecimal r87_average_rate) {
		this.r87_average_rate = r87_average_rate;
	}
	public String getR88_aed_200k() {
		return r88_aed_200k;
	}
	public void setR88_aed_200k(String r88_aed_200k) {
		this.r88_aed_200k = r88_aed_200k;
	}
	public BigDecimal getR88_minimum_rate() {
		return r88_minimum_rate;
	}
	public void setR88_minimum_rate(BigDecimal r88_minimum_rate) {
		this.r88_minimum_rate = r88_minimum_rate;
	}
	public BigDecimal getR88_maximum_rate() {
		return r88_maximum_rate;
	}
	public void setR88_maximum_rate(BigDecimal r88_maximum_rate) {
		this.r88_maximum_rate = r88_maximum_rate;
	}
	public BigDecimal getR88_average_rate() {
		return r88_average_rate;
	}
	public void setR88_average_rate(BigDecimal r88_average_rate) {
		this.r88_average_rate = r88_average_rate;
	}
	public String getR89_above_200k() {
		return r89_above_200k;
	}
	public void setR89_above_200k(String r89_above_200k) {
		this.r89_above_200k = r89_above_200k;
	}
	public BigDecimal getR89_minimum_rate() {
		return r89_minimum_rate;
	}
	public void setR89_minimum_rate(BigDecimal r89_minimum_rate) {
		this.r89_minimum_rate = r89_minimum_rate;
	}
	public BigDecimal getR89_maximum_rate() {
		return r89_maximum_rate;
	}
	public void setR89_maximum_rate(BigDecimal r89_maximum_rate) {
		this.r89_maximum_rate = r89_maximum_rate;
	}
	public BigDecimal getR89_average_rate() {
		return r89_average_rate;
	}
	public void setR89_average_rate(BigDecimal r89_average_rate) {
		this.r89_average_rate = r89_average_rate;
	}
	public String getR90_interest_profit() {
		return r90_interest_profit;
	}
	public void setR90_interest_profit(String r90_interest_profit) {
		this.r90_interest_profit = r90_interest_profit;
	}
	public BigDecimal getR90_minimum_rate() {
		return r90_minimum_rate;
	}
	public void setR90_minimum_rate(BigDecimal r90_minimum_rate) {
		this.r90_minimum_rate = r90_minimum_rate;
	}
	public BigDecimal getR90_maximum_rate() {
		return r90_maximum_rate;
	}
	public void setR90_maximum_rate(BigDecimal r90_maximum_rate) {
		this.r90_maximum_rate = r90_maximum_rate;
	}
	public BigDecimal getR90_average_rate() {
		return r90_average_rate;
	}
	public void setR90_average_rate(BigDecimal r90_average_rate) {
		this.r90_average_rate = r90_average_rate;
	}
	public String getR91_aed_50k() {
		return r91_aed_50k;
	}
	public void setR91_aed_50k(String r91_aed_50k) {
		this.r91_aed_50k = r91_aed_50k;
	}
	public BigDecimal getR91_minimum_rate() {
		return r91_minimum_rate;
	}
	public void setR91_minimum_rate(BigDecimal r91_minimum_rate) {
		this.r91_minimum_rate = r91_minimum_rate;
	}
	public BigDecimal getR91_maximum_rate() {
		return r91_maximum_rate;
	}
	public void setR91_maximum_rate(BigDecimal r91_maximum_rate) {
		this.r91_maximum_rate = r91_maximum_rate;
	}
	public BigDecimal getR91_average_rate() {
		return r91_average_rate;
	}
	public void setR91_average_rate(BigDecimal r91_average_rate) {
		this.r91_average_rate = r91_average_rate;
	}
	public String getR92_aed_100k() {
		return r92_aed_100k;
	}
	public void setR92_aed_100k(String r92_aed_100k) {
		this.r92_aed_100k = r92_aed_100k;
	}
	public BigDecimal getR92_minimum_rate() {
		return r92_minimum_rate;
	}
	public void setR92_minimum_rate(BigDecimal r92_minimum_rate) {
		this.r92_minimum_rate = r92_minimum_rate;
	}
	public BigDecimal getR92_maximum_rate() {
		return r92_maximum_rate;
	}
	public void setR92_maximum_rate(BigDecimal r92_maximum_rate) {
		this.r92_maximum_rate = r92_maximum_rate;
	}
	public BigDecimal getR92_average_rate() {
		return r92_average_rate;
	}
	public void setR92_average_rate(BigDecimal r92_average_rate) {
		this.r92_average_rate = r92_average_rate;
	}
	public String getR93_aed_200k() {
		return r93_aed_200k;
	}
	public void setR93_aed_200k(String r93_aed_200k) {
		this.r93_aed_200k = r93_aed_200k;
	}
	public BigDecimal getR93_minimum_rate() {
		return r93_minimum_rate;
	}
	public void setR93_minimum_rate(BigDecimal r93_minimum_rate) {
		this.r93_minimum_rate = r93_minimum_rate;
	}
	public BigDecimal getR93_maximum_rate() {
		return r93_maximum_rate;
	}
	public void setR93_maximum_rate(BigDecimal r93_maximum_rate) {
		this.r93_maximum_rate = r93_maximum_rate;
	}
	public BigDecimal getR93_average_rate() {
		return r93_average_rate;
	}
	public void setR93_average_rate(BigDecimal r93_average_rate) {
		this.r93_average_rate = r93_average_rate;
	}
	public String getR94_above_200k() {
		return r94_above_200k;
	}
	public void setR94_above_200k(String r94_above_200k) {
		this.r94_above_200k = r94_above_200k;
	}
	public BigDecimal getR94_minimum_rate() {
		return r94_minimum_rate;
	}
	public void setR94_minimum_rate(BigDecimal r94_minimum_rate) {
		this.r94_minimum_rate = r94_minimum_rate;
	}
	public BigDecimal getR94_maximum_rate() {
		return r94_maximum_rate;
	}
	public void setR94_maximum_rate(BigDecimal r94_maximum_rate) {
		this.r94_maximum_rate = r94_maximum_rate;
	}
	public BigDecimal getR94_average_rate() {
		return r94_average_rate;
	}
	public void setR94_average_rate(BigDecimal r94_average_rate) {
		this.r94_average_rate = r94_average_rate;
	}
	public String getR95_interest_rate2() {
		return r95_interest_rate2;
	}
	public void setR95_interest_rate2(String r95_interest_rate2) {
		this.r95_interest_rate2 = r95_interest_rate2;
	}
	public BigDecimal getR95_minimum_rate() {
		return r95_minimum_rate;
	}
	public void setR95_minimum_rate(BigDecimal r95_minimum_rate) {
		this.r95_minimum_rate = r95_minimum_rate;
	}
	public BigDecimal getR95_maximum_rate() {
		return r95_maximum_rate;
	}
	public void setR95_maximum_rate(BigDecimal r95_maximum_rate) {
		this.r95_maximum_rate = r95_maximum_rate;
	}
	public BigDecimal getR95_average_rate() {
		return r95_average_rate;
	}
	public void setR95_average_rate(BigDecimal r95_average_rate) {
		this.r95_average_rate = r95_average_rate;
	}
	public String getR96_interest_profit2() {
		return r96_interest_profit2;
	}
	public void setR96_interest_profit2(String r96_interest_profit2) {
		this.r96_interest_profit2 = r96_interest_profit2;
	}
	public BigDecimal getR96_minimum_rate() {
		return r96_minimum_rate;
	}
	public void setR96_minimum_rate(BigDecimal r96_minimum_rate) {
		this.r96_minimum_rate = r96_minimum_rate;
	}
	public BigDecimal getR96_maximum_rate() {
		return r96_maximum_rate;
	}
	public void setR96_maximum_rate(BigDecimal r96_maximum_rate) {
		this.r96_maximum_rate = r96_maximum_rate;
	}
	public BigDecimal getR96_average_rate2() {
		return r96_average_rate2;
	}
	public void setR96_average_rate2(BigDecimal r96_average_rate2) {
		this.r96_average_rate2 = r96_average_rate2;
	}
	public String getR97_aed_50k() {
		return r97_aed_50k;
	}
	public void setR97_aed_50k(String r97_aed_50k) {
		this.r97_aed_50k = r97_aed_50k;
	}
	public BigDecimal getR97_minimum_rate() {
		return r97_minimum_rate;
	}
	public void setR97_minimum_rate(BigDecimal r97_minimum_rate) {
		this.r97_minimum_rate = r97_minimum_rate;
	}
	public BigDecimal getR97_maximum_rate() {
		return r97_maximum_rate;
	}
	public void setR97_maximum_rate(BigDecimal r97_maximum_rate) {
		this.r97_maximum_rate = r97_maximum_rate;
	}
	public BigDecimal getR97_average_rate() {
		return r97_average_rate;
	}
	public void setR97_average_rate(BigDecimal r97_average_rate) {
		this.r97_average_rate = r97_average_rate;
	}
	public String getR98_aed_100k2() {
		return r98_aed_100k2;
	}
	public void setR98_aed_100k2(String r98_aed_100k2) {
		this.r98_aed_100k2 = r98_aed_100k2;
	}
	public BigDecimal getR98_minimum_rate() {
		return r98_minimum_rate;
	}
	public void setR98_minimum_rate(BigDecimal r98_minimum_rate) {
		this.r98_minimum_rate = r98_minimum_rate;
	}
	public BigDecimal getR98_maximum_rate() {
		return r98_maximum_rate;
	}
	public void setR98_maximum_rate(BigDecimal r98_maximum_rate) {
		this.r98_maximum_rate = r98_maximum_rate;
	}
	public BigDecimal getR98_average_rate() {
		return r98_average_rate;
	}
	public void setR98_average_rate(BigDecimal r98_average_rate) {
		this.r98_average_rate = r98_average_rate;
	}
	public String getR99_aed_200k2() {
		return r99_aed_200k2;
	}
	public void setR99_aed_200k2(String r99_aed_200k2) {
		this.r99_aed_200k2 = r99_aed_200k2;
	}
	public BigDecimal getR99_minimum_rate() {
		return r99_minimum_rate;
	}
	public void setR99_minimum_rate(BigDecimal r99_minimum_rate) {
		this.r99_minimum_rate = r99_minimum_rate;
	}
	public BigDecimal getR99_maximum_rate() {
		return r99_maximum_rate;
	}
	public void setR99_maximum_rate(BigDecimal r99_maximum_rate) {
		this.r99_maximum_rate = r99_maximum_rate;
	}
	public BigDecimal getR99_average_rate() {
		return r99_average_rate;
	}
	public void setR99_average_rate(BigDecimal r99_average_rate) {
		this.r99_average_rate = r99_average_rate;
	}
	public String getR100_above_200k2() {
		return r100_above_200k2;
	}
	public void setR100_above_200k2(String r100_above_200k2) {
		this.r100_above_200k2 = r100_above_200k2;
	}
	public BigDecimal getR100_minimum_rate() {
		return r100_minimum_rate;
	}
	public void setR100_minimum_rate(BigDecimal r100_minimum_rate) {
		this.r100_minimum_rate = r100_minimum_rate;
	}
	public BigDecimal getR100_maximum_rate() {
		return r100_maximum_rate;
	}
	public void setR100_maximum_rate(BigDecimal r100_maximum_rate) {
		this.r100_maximum_rate = r100_maximum_rate;
	}
	public BigDecimal getR100_average_rate() {
		return r100_average_rate;
	}
	public void setR100_average_rate(BigDecimal r100_average_rate) {
		this.r100_average_rate = r100_average_rate;
	}
	public String getR101_interest_rate3() {
		return r101_interest_rate3;
	}
	public void setR101_interest_rate3(String r101_interest_rate3) {
		this.r101_interest_rate3 = r101_interest_rate3;
	}
	public BigDecimal getR101_minimum_rate() {
		return r101_minimum_rate;
	}
	public void setR101_minimum_rate(BigDecimal r101_minimum_rate) {
		this.r101_minimum_rate = r101_minimum_rate;
	}
	public BigDecimal getR101_maximum_rate() {
		return r101_maximum_rate;
	}
	public void setR101_maximum_rate(BigDecimal r101_maximum_rate) {
		this.r101_maximum_rate = r101_maximum_rate;
	}
	public BigDecimal getR101_average_rate() {
		return r101_average_rate;
	}
	public void setR101_average_rate(BigDecimal r101_average_rate) {
		this.r101_average_rate = r101_average_rate;
	}
	public String getR102_interest_profit3() {
		return r102_interest_profit3;
	}
	public void setR102_interest_profit3(String r102_interest_profit3) {
		this.r102_interest_profit3 = r102_interest_profit3;
	}
	public BigDecimal getR102_minimum_rate() {
		return r102_minimum_rate;
	}
	public void setR102_minimum_rate(BigDecimal r102_minimum_rate) {
		this.r102_minimum_rate = r102_minimum_rate;
	}
	public BigDecimal getR102_maximum_rate() {
		return r102_maximum_rate;
	}
	public void setR102_maximum_rate(BigDecimal r102_maximum_rate) {
		this.r102_maximum_rate = r102_maximum_rate;
	}
	public BigDecimal getR102_average_rate() {
		return r102_average_rate;
	}
	public void setR102_average_rate(BigDecimal r102_average_rate) {
		this.r102_average_rate = r102_average_rate;
	}
	public String getR103_aed_50k3() {
		return r103_aed_50k3;
	}
	public void setR103_aed_50k3(String r103_aed_50k3) {
		this.r103_aed_50k3 = r103_aed_50k3;
	}
	public BigDecimal getR103_minimum_rate() {
		return r103_minimum_rate;
	}
	public void setR103_minimum_rate(BigDecimal r103_minimum_rate) {
		this.r103_minimum_rate = r103_minimum_rate;
	}
	public BigDecimal getR103_maximum_rate() {
		return r103_maximum_rate;
	}
	public void setR103_maximum_rate(BigDecimal r103_maximum_rate) {
		this.r103_maximum_rate = r103_maximum_rate;
	}
	public BigDecimal getR103_average_rate() {
		return r103_average_rate;
	}
	public void setR103_average_rate(BigDecimal r103_average_rate) {
		this.r103_average_rate = r103_average_rate;
	}
	public String getR104_aed_100k3() {
		return r104_aed_100k3;
	}
	public void setR104_aed_100k3(String r104_aed_100k3) {
		this.r104_aed_100k3 = r104_aed_100k3;
	}
	public BigDecimal getR104_minimum_rate() {
		return r104_minimum_rate;
	}
	public void setR104_minimum_rate(BigDecimal r104_minimum_rate) {
		this.r104_minimum_rate = r104_minimum_rate;
	}
	public BigDecimal getR104_maximum_rate() {
		return r104_maximum_rate;
	}
	public void setR104_maximum_rate(BigDecimal r104_maximum_rate) {
		this.r104_maximum_rate = r104_maximum_rate;
	}
	public BigDecimal getR104_average_rate() {
		return r104_average_rate;
	}
	public void setR104_average_rate(BigDecimal r104_average_rate) {
		this.r104_average_rate = r104_average_rate;
	}
	public String getR105_aed_200k3() {
		return r105_aed_200k3;
	}
	public void setR105_aed_200k3(String r105_aed_200k3) {
		this.r105_aed_200k3 = r105_aed_200k3;
	}
	public BigDecimal getR105_minimum_rate() {
		return r105_minimum_rate;
	}
	public void setR105_minimum_rate(BigDecimal r105_minimum_rate) {
		this.r105_minimum_rate = r105_minimum_rate;
	}
	public BigDecimal getR105_maximum_rate() {
		return r105_maximum_rate;
	}
	public void setR105_maximum_rate(BigDecimal r105_maximum_rate) {
		this.r105_maximum_rate = r105_maximum_rate;
	}
	public BigDecimal getR105_average_rate() {
		return r105_average_rate;
	}
	public void setR105_average_rate(BigDecimal r105_average_rate) {
		this.r105_average_rate = r105_average_rate;
	}
	public String getR106_above_200k3() {
		return r106_above_200k3;
	}
	public void setR106_above_200k3(String r106_above_200k3) {
		this.r106_above_200k3 = r106_above_200k3;
	}
	public BigDecimal getR106_minimum_rate() {
		return r106_minimum_rate;
	}
	public void setR106_minimum_rate(BigDecimal r106_minimum_rate) {
		this.r106_minimum_rate = r106_minimum_rate;
	}
	public BigDecimal getR106_maximum_rate() {
		return r106_maximum_rate;
	}
	public void setR106_maximum_rate(BigDecimal r106_maximum_rate) {
		this.r106_maximum_rate = r106_maximum_rate;
	}
	public BigDecimal getR106_average_rate() {
		return r106_average_rate;
	}
	public void setR106_average_rate(BigDecimal r106_average_rate) {
		this.r106_average_rate = r106_average_rate;
	}
	public String getR107_interest_rate4() {
		return r107_interest_rate4;
	}
	public void setR107_interest_rate4(String r107_interest_rate4) {
		this.r107_interest_rate4 = r107_interest_rate4;
	}
	public BigDecimal getR107_minimum_rate() {
		return r107_minimum_rate;
	}
	public void setR107_minimum_rate(BigDecimal r107_minimum_rate) {
		this.r107_minimum_rate = r107_minimum_rate;
	}
	public BigDecimal getR107_maximum_rate() {
		return r107_maximum_rate;
	}
	public void setR107_maximum_rate(BigDecimal r107_maximum_rate) {
		this.r107_maximum_rate = r107_maximum_rate;
	}
	public BigDecimal getR107_average_rate() {
		return r107_average_rate;
	}
	public void setR107_average_rate(BigDecimal r107_average_rate) {
		this.r107_average_rate = r107_average_rate;
	}
	public String getR108_interest_profit4() {
		return r108_interest_profit4;
	}
	public void setR108_interest_profit4(String r108_interest_profit4) {
		this.r108_interest_profit4 = r108_interest_profit4;
	}
	public BigDecimal getR108_minimum_rate() {
		return r108_minimum_rate;
	}
	public void setR108_minimum_rate(BigDecimal r108_minimum_rate) {
		this.r108_minimum_rate = r108_minimum_rate;
	}
	public BigDecimal getR108_maximum_rate() {
		return r108_maximum_rate;
	}
	public void setR108_maximum_rate(BigDecimal r108_maximum_rate) {
		this.r108_maximum_rate = r108_maximum_rate;
	}
	public BigDecimal getR108_average_rate() {
		return r108_average_rate;
	}
	public void setR108_average_rate(BigDecimal r108_average_rate) {
		this.r108_average_rate = r108_average_rate;
	}
	public String getR109_aed_50k4() {
		return r109_aed_50k4;
	}
	public void setR109_aed_50k4(String r109_aed_50k4) {
		this.r109_aed_50k4 = r109_aed_50k4;
	}
	public BigDecimal getR109_minimum_rate() {
		return r109_minimum_rate;
	}
	public void setR109_minimum_rate(BigDecimal r109_minimum_rate) {
		this.r109_minimum_rate = r109_minimum_rate;
	}
	public BigDecimal getR109_maximum_rate() {
		return r109_maximum_rate;
	}
	public void setR109_maximum_rate(BigDecimal r109_maximum_rate) {
		this.r109_maximum_rate = r109_maximum_rate;
	}
	public BigDecimal getR109_average_rate() {
		return r109_average_rate;
	}
	public void setR109_average_rate(BigDecimal r109_average_rate) {
		this.r109_average_rate = r109_average_rate;
	}
	public String getR110_aed_100k4() {
		return r110_aed_100k4;
	}
	public void setR110_aed_100k4(String r110_aed_100k4) {
		this.r110_aed_100k4 = r110_aed_100k4;
	}
	public BigDecimal getR110_minimum_rate() {
		return r110_minimum_rate;
	}
	public void setR110_minimum_rate(BigDecimal r110_minimum_rate) {
		this.r110_minimum_rate = r110_minimum_rate;
	}
	public BigDecimal getR110_maximum_rate() {
		return r110_maximum_rate;
	}
	public void setR110_maximum_rate(BigDecimal r110_maximum_rate) {
		this.r110_maximum_rate = r110_maximum_rate;
	}
	public BigDecimal getR110_average_rate() {
		return r110_average_rate;
	}
	public void setR110_average_rate(BigDecimal r110_average_rate) {
		this.r110_average_rate = r110_average_rate;
	}
	public String getR111_aed_200k4() {
		return r111_aed_200k4;
	}
	public void setR111_aed_200k4(String r111_aed_200k4) {
		this.r111_aed_200k4 = r111_aed_200k4;
	}
	public BigDecimal getR111_minimum_rate() {
		return r111_minimum_rate;
	}
	public void setR111_minimum_rate(BigDecimal r111_minimum_rate) {
		this.r111_minimum_rate = r111_minimum_rate;
	}
	public BigDecimal getR111_maximum_rate() {
		return r111_maximum_rate;
	}
	public void setR111_maximum_rate(BigDecimal r111_maximum_rate) {
		this.r111_maximum_rate = r111_maximum_rate;
	}
	public BigDecimal getR111_average_rate() {
		return r111_average_rate;
	}
	public void setR111_average_rate(BigDecimal r111_average_rate) {
		this.r111_average_rate = r111_average_rate;
	}
	public String getR112_above_200k4() {
		return r112_above_200k4;
	}
	public void setR112_above_200k4(String r112_above_200k4) {
		this.r112_above_200k4 = r112_above_200k4;
	}
	public BigDecimal getR112_minimum_rate() {
		return r112_minimum_rate;
	}
	public void setR112_minimum_rate(BigDecimal r112_minimum_rate) {
		this.r112_minimum_rate = r112_minimum_rate;
	}
	public BigDecimal getR112_maximum_rate() {
		return r112_maximum_rate;
	}
	public void setR112_maximum_rate(BigDecimal r112_maximum_rate) {
		this.r112_maximum_rate = r112_maximum_rate;
	}
	public BigDecimal getR112_average_rate() {
		return r112_average_rate;
	}
	public void setR112_average_rate(BigDecimal r112_average_rate) {
		this.r112_average_rate = r112_average_rate;
	}
	public String getR113_interest_rate5() {
		return r113_interest_rate5;
	}
	public void setR113_interest_rate5(String r113_interest_rate5) {
		this.r113_interest_rate5 = r113_interest_rate5;
	}
	public BigDecimal getR113_minimum_rate() {
		return r113_minimum_rate;
	}
	public void setR113_minimum_rate(BigDecimal r113_minimum_rate) {
		this.r113_minimum_rate = r113_minimum_rate;
	}
	public BigDecimal getR113_maximum_rate() {
		return r113_maximum_rate;
	}
	public void setR113_maximum_rate(BigDecimal r113_maximum_rate) {
		this.r113_maximum_rate = r113_maximum_rate;
	}
	public BigDecimal getR113_average_rate() {
		return r113_average_rate;
	}
	public void setR113_average_rate(BigDecimal r113_average_rate) {
		this.r113_average_rate = r113_average_rate;
	}
	public String getR114_interest_profit5() {
		return r114_interest_profit5;
	}
	public void setR114_interest_profit5(String r114_interest_profit5) {
		this.r114_interest_profit5 = r114_interest_profit5;
	}
	public BigDecimal getR114_minimum_rate() {
		return r114_minimum_rate;
	}
	public void setR114_minimum_rate(BigDecimal r114_minimum_rate) {
		this.r114_minimum_rate = r114_minimum_rate;
	}
	public BigDecimal getR114_maximum_rate() {
		return r114_maximum_rate;
	}
	public void setR114_maximum_rate(BigDecimal r114_maximum_rate) {
		this.r114_maximum_rate = r114_maximum_rate;
	}
	public BigDecimal getR114_average_rate() {
		return r114_average_rate;
	}
	public void setR114_average_rate(BigDecimal r114_average_rate) {
		this.r114_average_rate = r114_average_rate;
	}
	public String getR115_aed_50k5() {
		return r115_aed_50k5;
	}
	public void setR115_aed_50k5(String r115_aed_50k5) {
		this.r115_aed_50k5 = r115_aed_50k5;
	}
	public BigDecimal getR115_minimum_rate() {
		return r115_minimum_rate;
	}
	public void setR115_minimum_rate(BigDecimal r115_minimum_rate) {
		this.r115_minimum_rate = r115_minimum_rate;
	}
	public BigDecimal getR115_maximum_rate() {
		return r115_maximum_rate;
	}
	public void setR115_maximum_rate(BigDecimal r115_maximum_rate) {
		this.r115_maximum_rate = r115_maximum_rate;
	}
	public BigDecimal getR115_average_rate() {
		return r115_average_rate;
	}
	public void setR115_average_rate(BigDecimal r115_average_rate) {
		this.r115_average_rate = r115_average_rate;
	}
	public String getR116_aed_100k5() {
		return r116_aed_100k5;
	}
	public void setR116_aed_100k5(String r116_aed_100k5) {
		this.r116_aed_100k5 = r116_aed_100k5;
	}
	public BigDecimal getR116_minimum_rate() {
		return r116_minimum_rate;
	}
	public void setR116_minimum_rate(BigDecimal r116_minimum_rate) {
		this.r116_minimum_rate = r116_minimum_rate;
	}
	public BigDecimal getR116_maximum_rate() {
		return r116_maximum_rate;
	}
	public void setR116_maximum_rate(BigDecimal r116_maximum_rate) {
		this.r116_maximum_rate = r116_maximum_rate;
	}
	public BigDecimal getR116_average_rate() {
		return r116_average_rate;
	}
	public void setR116_average_rate(BigDecimal r116_average_rate) {
		this.r116_average_rate = r116_average_rate;
	}
	public String getR117_aed_200k5() {
		return r117_aed_200k5;
	}
	public void setR117_aed_200k5(String r117_aed_200k5) {
		this.r117_aed_200k5 = r117_aed_200k5;
	}
	public BigDecimal getR117_minimum_rate() {
		return r117_minimum_rate;
	}
	public void setR117_minimum_rate(BigDecimal r117_minimum_rate) {
		this.r117_minimum_rate = r117_minimum_rate;
	}
	public BigDecimal getR117_maximum_rate() {
		return r117_maximum_rate;
	}
	public void setR117_maximum_rate(BigDecimal r117_maximum_rate) {
		this.r117_maximum_rate = r117_maximum_rate;
	}
	public BigDecimal getR117_average_rate() {
		return r117_average_rate;
	}
	public void setR117_average_rate(BigDecimal r117_average_rate) {
		this.r117_average_rate = r117_average_rate;
	}
	public String getR118_above_200k5() {
		return r118_above_200k5;
	}
	public void setR118_above_200k5(String r118_above_200k5) {
		this.r118_above_200k5 = r118_above_200k5;
	}
	public BigDecimal getR118_minimum_rate() {
		return r118_minimum_rate;
	}
	public void setR118_minimum_rate(BigDecimal r118_minimum_rate) {
		this.r118_minimum_rate = r118_minimum_rate;
	}
	public BigDecimal getR118_maximum_rate() {
		return r118_maximum_rate;
	}
	public void setR118_maximum_rate(BigDecimal r118_maximum_rate) {
		this.r118_maximum_rate = r118_maximum_rate;
	}
	public BigDecimal getR118_average_rate() {
		return r118_average_rate;
	}
	public void setR118_average_rate(BigDecimal r118_average_rate) {
		this.r118_average_rate = r118_average_rate;
	}
	public String getR119_interest_rate6() {
		return r119_interest_rate6;
	}
	public void setR119_interest_rate6(String r119_interest_rate6) {
		this.r119_interest_rate6 = r119_interest_rate6;
	}
	public BigDecimal getR119_minimum_rate() {
		return r119_minimum_rate;
	}
	public void setR119_minimum_rate(BigDecimal r119_minimum_rate) {
		this.r119_minimum_rate = r119_minimum_rate;
	}
	public BigDecimal getR119_maximum_rate() {
		return r119_maximum_rate;
	}
	public void setR119_maximum_rate(BigDecimal r119_maximum_rate) {
		this.r119_maximum_rate = r119_maximum_rate;
	}
	public BigDecimal getR119_average_rate() {
		return r119_average_rate;
	}
	public void setR119_average_rate(BigDecimal r119_average_rate) {
		this.r119_average_rate = r119_average_rate;
	}
	public String getR120_interest_profit6() {
		return r120_interest_profit6;
	}
	public void setR120_interest_profit6(String r120_interest_profit6) {
		this.r120_interest_profit6 = r120_interest_profit6;
	}
	public BigDecimal getR120_minimum_rate() {
		return r120_minimum_rate;
	}
	public void setR120_minimum_rate(BigDecimal r120_minimum_rate) {
		this.r120_minimum_rate = r120_minimum_rate;
	}
	public BigDecimal getR120_maximum_rate() {
		return r120_maximum_rate;
	}
	public void setR120_maximum_rate(BigDecimal r120_maximum_rate) {
		this.r120_maximum_rate = r120_maximum_rate;
	}
	public BigDecimal getR120_average_rate() {
		return r120_average_rate;
	}
	public void setR120_average_rate(BigDecimal r120_average_rate) {
		this.r120_average_rate = r120_average_rate;
	}
	public String getR121_aed_50k6() {
		return r121_aed_50k6;
	}
	public void setR121_aed_50k6(String r121_aed_50k6) {
		this.r121_aed_50k6 = r121_aed_50k6;
	}
	public BigDecimal getR121_minimum_rate() {
		return r121_minimum_rate;
	}
	public void setR121_minimum_rate(BigDecimal r121_minimum_rate) {
		this.r121_minimum_rate = r121_minimum_rate;
	}
	public BigDecimal getR121_maximum_rate() {
		return r121_maximum_rate;
	}
	public void setR121_maximum_rate(BigDecimal r121_maximum_rate) {
		this.r121_maximum_rate = r121_maximum_rate;
	}
	public BigDecimal getR121_average_rate() {
		return r121_average_rate;
	}
	public void setR121_average_rate(BigDecimal r121_average_rate) {
		this.r121_average_rate = r121_average_rate;
	}
	public String getR122_aed_100k6() {
		return r122_aed_100k6;
	}
	public void setR122_aed_100k6(String r122_aed_100k6) {
		this.r122_aed_100k6 = r122_aed_100k6;
	}
	public BigDecimal getR122_minimum_rate() {
		return r122_minimum_rate;
	}
	public void setR122_minimum_rate(BigDecimal r122_minimum_rate) {
		this.r122_minimum_rate = r122_minimum_rate;
	}
	public BigDecimal getR122_maximum_rate() {
		return r122_maximum_rate;
	}
	public void setR122_maximum_rate(BigDecimal r122_maximum_rate) {
		this.r122_maximum_rate = r122_maximum_rate;
	}
	public BigDecimal getR122_average_rate() {
		return r122_average_rate;
	}
	public void setR122_average_rate(BigDecimal r122_average_rate) {
		this.r122_average_rate = r122_average_rate;
	}
	public String getR123_aed_200k6() {
		return r123_aed_200k6;
	}
	public void setR123_aed_200k6(String r123_aed_200k6) {
		this.r123_aed_200k6 = r123_aed_200k6;
	}
	public BigDecimal getR123_minimum_rate() {
		return r123_minimum_rate;
	}
	public void setR123_minimum_rate(BigDecimal r123_minimum_rate) {
		this.r123_minimum_rate = r123_minimum_rate;
	}
	public BigDecimal getR123_maximum_rate() {
		return r123_maximum_rate;
	}
	public void setR123_maximum_rate(BigDecimal r123_maximum_rate) {
		this.r123_maximum_rate = r123_maximum_rate;
	}
	public BigDecimal getR123_average_rate() {
		return r123_average_rate;
	}
	public void setR123_average_rate(BigDecimal r123_average_rate) {
		this.r123_average_rate = r123_average_rate;
	}
	public String getR124_above_200k6() {
		return r124_above_200k6;
	}
	public void setR124_above_200k6(String r124_above_200k6) {
		this.r124_above_200k6 = r124_above_200k6;
	}
	public BigDecimal getR124_minimum_rate() {
		return r124_minimum_rate;
	}
	public void setR124_minimum_rate(BigDecimal r124_minimum_rate) {
		this.r124_minimum_rate = r124_minimum_rate;
	}
	public BigDecimal getR124_maximum_rate() {
		return r124_maximum_rate;
	}
	public void setR124_maximum_rate(BigDecimal r124_maximum_rate) {
		this.r124_maximum_rate = r124_maximum_rate;
	}
	public BigDecimal getR124_average_rate() {
		return r124_average_rate;
	}
	public void setR124_average_rate(BigDecimal r124_average_rate) {
		this.r124_average_rate = r124_average_rate;
	}
	public String getR125_interest_rate7() {
		return r125_interest_rate7;
	}
	public void setR125_interest_rate7(String r125_interest_rate7) {
		this.r125_interest_rate7 = r125_interest_rate7;
	}
	public BigDecimal getR125_minimum_rate() {
		return r125_minimum_rate;
	}
	public void setR125_minimum_rate(BigDecimal r125_minimum_rate) {
		this.r125_minimum_rate = r125_minimum_rate;
	}
	public BigDecimal getR125_maximum_rate() {
		return r125_maximum_rate;
	}
	public void setR125_maximum_rate(BigDecimal r125_maximum_rate) {
		this.r125_maximum_rate = r125_maximum_rate;
	}
	public BigDecimal getR125_average_rate() {
		return r125_average_rate;
	}
	public void setR125_average_rate(BigDecimal r125_average_rate) {
		this.r125_average_rate = r125_average_rate;
	}
	public String getR126_interest_profit7() {
		return r126_interest_profit7;
	}
	public void setR126_interest_profit7(String r126_interest_profit7) {
		this.r126_interest_profit7 = r126_interest_profit7;
	}
	public BigDecimal getR126_minimum_rate() {
		return r126_minimum_rate;
	}
	public void setR126_minimum_rate(BigDecimal r126_minimum_rate) {
		this.r126_minimum_rate = r126_minimum_rate;
	}
	public BigDecimal getR126_maximum_rate() {
		return r126_maximum_rate;
	}
	public void setR126_maximum_rate(BigDecimal r126_maximum_rate) {
		this.r126_maximum_rate = r126_maximum_rate;
	}
	public BigDecimal getR126_average_rate() {
		return r126_average_rate;
	}
	public void setR126_average_rate(BigDecimal r126_average_rate) {
		this.r126_average_rate = r126_average_rate;
	}
	public String getR127_aed_50k7() {
		return r127_aed_50k7;
	}
	public void setR127_aed_50k7(String r127_aed_50k7) {
		this.r127_aed_50k7 = r127_aed_50k7;
	}
	public BigDecimal getR127_minimum_rate() {
		return r127_minimum_rate;
	}
	public void setR127_minimum_rate(BigDecimal r127_minimum_rate) {
		this.r127_minimum_rate = r127_minimum_rate;
	}
	public BigDecimal getR127_maximum_rate() {
		return r127_maximum_rate;
	}
	public void setR127_maximum_rate(BigDecimal r127_maximum_rate) {
		this.r127_maximum_rate = r127_maximum_rate;
	}
	public BigDecimal getR127_average_rate() {
		return r127_average_rate;
	}
	public void setR127_average_rate(BigDecimal r127_average_rate) {
		this.r127_average_rate = r127_average_rate;
	}
	public String getR128_aed_100k7() {
		return r128_aed_100k7;
	}
	public void setR128_aed_100k7(String r128_aed_100k7) {
		this.r128_aed_100k7 = r128_aed_100k7;
	}
	public BigDecimal getR128_minimum_rate() {
		return r128_minimum_rate;
	}
	public void setR128_minimum_rate(BigDecimal r128_minimum_rate) {
		this.r128_minimum_rate = r128_minimum_rate;
	}
	public BigDecimal getR128_maximum_rate() {
		return r128_maximum_rate;
	}
	public void setR128_maximum_rate(BigDecimal r128_maximum_rate) {
		this.r128_maximum_rate = r128_maximum_rate;
	}
	public BigDecimal getR128_average_rate() {
		return r128_average_rate;
	}
	public void setR128_average_rate(BigDecimal r128_average_rate) {
		this.r128_average_rate = r128_average_rate;
	}
	public String getR129_aed_200k7() {
		return r129_aed_200k7;
	}
	public void setR129_aed_200k7(String r129_aed_200k7) {
		this.r129_aed_200k7 = r129_aed_200k7;
	}
	public BigDecimal getR129_minimum_rate() {
		return r129_minimum_rate;
	}
	public void setR129_minimum_rate(BigDecimal r129_minimum_rate) {
		this.r129_minimum_rate = r129_minimum_rate;
	}
	public BigDecimal getR129_maximum_rate() {
		return r129_maximum_rate;
	}
	public void setR129_maximum_rate(BigDecimal r129_maximum_rate) {
		this.r129_maximum_rate = r129_maximum_rate;
	}
	public BigDecimal getR129_average_rate() {
		return r129_average_rate;
	}
	public void setR129_average_rate(BigDecimal r129_average_rate) {
		this.r129_average_rate = r129_average_rate;
	}
	public String getR130_interest_rate8() {
		return r130_interest_rate8;
	}
	public void setR130_interest_rate8(String r130_interest_rate8) {
		this.r130_interest_rate8 = r130_interest_rate8;
	}
	public BigDecimal getR130_minimum_rate() {
		return r130_minimum_rate;
	}
	public void setR130_minimum_rate(BigDecimal r130_minimum_rate) {
		this.r130_minimum_rate = r130_minimum_rate;
	}
	public BigDecimal getR130_maximum_rate() {
		return r130_maximum_rate;
	}
	public void setR130_maximum_rate(BigDecimal r130_maximum_rate) {
		this.r130_maximum_rate = r130_maximum_rate;
	}
	public BigDecimal getR130_average_rate() {
		return r130_average_rate;
	}
	public void setR130_average_rate(BigDecimal r130_average_rate) {
		this.r130_average_rate = r130_average_rate;
	}
	public String getR131_interest_profit8() {
		return r131_interest_profit8;
	}
	public void setR131_interest_profit8(String r131_interest_profit8) {
		this.r131_interest_profit8 = r131_interest_profit8;
	}
	public BigDecimal getR131_minimum_rate() {
		return r131_minimum_rate;
	}
	public void setR131_minimum_rate(BigDecimal r131_minimum_rate) {
		this.r131_minimum_rate = r131_minimum_rate;
	}
	public BigDecimal getR131_maximum_rate() {
		return r131_maximum_rate;
	}
	public void setR131_maximum_rate(BigDecimal r131_maximum_rate) {
		this.r131_maximum_rate = r131_maximum_rate;
	}
	public BigDecimal getR131_average_rate() {
		return r131_average_rate;
	}
	public void setR131_average_rate(BigDecimal r131_average_rate) {
		this.r131_average_rate = r131_average_rate;
	}
	public String getR132_aed_50k8() {
		return r132_aed_50k8;
	}
	public void setR132_aed_50k8(String r132_aed_50k8) {
		this.r132_aed_50k8 = r132_aed_50k8;
	}
	public BigDecimal getR132_minimum_rate() {
		return r132_minimum_rate;
	}
	public void setR132_minimum_rate(BigDecimal r132_minimum_rate) {
		this.r132_minimum_rate = r132_minimum_rate;
	}
	public BigDecimal getR132_maximum_rate() {
		return r132_maximum_rate;
	}
	public void setR132_maximum_rate(BigDecimal r132_maximum_rate) {
		this.r132_maximum_rate = r132_maximum_rate;
	}
	public BigDecimal getR132_average_rate() {
		return r132_average_rate;
	}
	public void setR132_average_rate(BigDecimal r132_average_rate) {
		this.r132_average_rate = r132_average_rate;
	}
	public String getR133_aed_100k8() {
		return r133_aed_100k8;
	}
	public void setR133_aed_100k8(String r133_aed_100k8) {
		this.r133_aed_100k8 = r133_aed_100k8;
	}
	public BigDecimal getR133_minimum_rate() {
		return r133_minimum_rate;
	}
	public void setR133_minimum_rate(BigDecimal r133_minimum_rate) {
		this.r133_minimum_rate = r133_minimum_rate;
	}
	public BigDecimal getR133_maximum_rate() {
		return r133_maximum_rate;
	}
	public void setR133_maximum_rate(BigDecimal r133_maximum_rate) {
		this.r133_maximum_rate = r133_maximum_rate;
	}
	public BigDecimal getR133_average_rate() {
		return r133_average_rate;
	}
	public void setR133_average_rate(BigDecimal r133_average_rate) {
		this.r133_average_rate = r133_average_rate;
	}
	public String getR134_aed_200k8() {
		return r134_aed_200k8;
	}
	public void setR134_aed_200k8(String r134_aed_200k8) {
		this.r134_aed_200k8 = r134_aed_200k8;
	}
	public BigDecimal getR134_minimum_rate() {
		return r134_minimum_rate;
	}
	public void setR134_minimum_rate(BigDecimal r134_minimum_rate) {
		this.r134_minimum_rate = r134_minimum_rate;
	}
	public BigDecimal getR134_maximum_rate() {
		return r134_maximum_rate;
	}
	public void setR134_maximum_rate(BigDecimal r134_maximum_rate) {
		this.r134_maximum_rate = r134_maximum_rate;
	}
	public BigDecimal getR134_average_rate() {
		return r134_average_rate;
	}
	public void setR134_average_rate(BigDecimal r134_average_rate) {
		this.r134_average_rate = r134_average_rate;
	}
	public String getR135_above_200k8() {
		return r135_above_200k8;
	}
	public void setR135_above_200k8(String r135_above_200k8) {
		this.r135_above_200k8 = r135_above_200k8;
	}
	public BigDecimal getR135_minimum_rate() {
		return r135_minimum_rate;
	}
	public void setR135_minimum_rate(BigDecimal r135_minimum_rate) {
		this.r135_minimum_rate = r135_minimum_rate;
	}
	public BigDecimal getR135_maximum_rate() {
		return r135_maximum_rate;
	}
	public void setR135_maximum_rate(BigDecimal r135_maximum_rate) {
		this.r135_maximum_rate = r135_maximum_rate;
	}
	public BigDecimal getR135_average_rate() {
		return r135_average_rate;
	}
	public void setR135_average_rate(BigDecimal r135_average_rate) {
		this.r135_average_rate = r135_average_rate;
	}
	public String getR136_overdrafts() {
		return r136_overdrafts;
	}
	public void setR136_overdrafts(String r136_overdrafts) {
		this.r136_overdrafts = r136_overdrafts;
	}
	public BigDecimal getR136_minimum_rate() {
		return r136_minimum_rate;
	}
	public void setR136_minimum_rate(BigDecimal r136_minimum_rate) {
		this.r136_minimum_rate = r136_minimum_rate;
	}
	public BigDecimal getR136_maximum_rate() {
		return r136_maximum_rate;
	}
	public void setR136_maximum_rate(BigDecimal r136_maximum_rate) {
		this.r136_maximum_rate = r136_maximum_rate;
	}
	public BigDecimal getR136_average_rate() {
		return r136_average_rate;
	}
	public void setR136_average_rate(BigDecimal r136_average_rate) {
		this.r136_average_rate = r136_average_rate;
	}
	public BigDecimal getR136_federal() {
		return r136_federal;
	}
	public void setR136_federal(BigDecimal r136_federal) {
		this.r136_federal = r136_federal;
	}
	public BigDecimal getR136_gre() {
		return r136_gre;
	}
	public void setR136_gre(BigDecimal r136_gre) {
		this.r136_gre = r136_gre;
	}
	public BigDecimal getR136_nbfi() {
		return r136_nbfi;
	}
	public void setR136_nbfi(BigDecimal r136_nbfi) {
		this.r136_nbfi = r136_nbfi;
	}
	public BigDecimal getR136_sme() {
		return r136_sme;
	}
	public void setR136_sme(BigDecimal r136_sme) {
		this.r136_sme = r136_sme;
	}
	public String getR137_trade_bills() {
		return r137_trade_bills;
	}
	public void setR137_trade_bills(String r137_trade_bills) {
		this.r137_trade_bills = r137_trade_bills;
	}
	public BigDecimal getR137_minimum_rate() {
		return r137_minimum_rate;
	}
	public void setR137_minimum_rate(BigDecimal r137_minimum_rate) {
		this.r137_minimum_rate = r137_minimum_rate;
	}
	public BigDecimal getR137_maximum_rate() {
		return r137_maximum_rate;
	}
	public void setR137_maximum_rate(BigDecimal r137_maximum_rate) {
		this.r137_maximum_rate = r137_maximum_rate;
	}
	public BigDecimal getR137_average_rate() {
		return r137_average_rate;
	}
	public void setR137_average_rate(BigDecimal r137_average_rate) {
		this.r137_average_rate = r137_average_rate;
	}
	public BigDecimal getR137_federal() {
		return r137_federal;
	}
	public void setR137_federal(BigDecimal r137_federal) {
		this.r137_federal = r137_federal;
	}
	public BigDecimal getR137_gre() {
		return r137_gre;
	}
	public void setR137_gre(BigDecimal r137_gre) {
		this.r137_gre = r137_gre;
	}
	public BigDecimal getR137_nbfi() {
		return r137_nbfi;
	}
	public void setR137_nbfi(BigDecimal r137_nbfi) {
		this.r137_nbfi = r137_nbfi;
	}
	public BigDecimal getR137_sme() {
		return r137_sme;
	}
	public void setR137_sme(BigDecimal r137_sme) {
		this.r137_sme = r137_sme;
	}
	public String getR138_trade_loans() {
		return r138_trade_loans;
	}
	public void setR138_trade_loans(String r138_trade_loans) {
		this.r138_trade_loans = r138_trade_loans;
	}
	public BigDecimal getR138_minimum_rate() {
		return r138_minimum_rate;
	}
	public void setR138_minimum_rate(BigDecimal r138_minimum_rate) {
		this.r138_minimum_rate = r138_minimum_rate;
	}
	public BigDecimal getR138_maximum_rate() {
		return r138_maximum_rate;
	}
	public void setR138_maximum_rate(BigDecimal r138_maximum_rate) {
		this.r138_maximum_rate = r138_maximum_rate;
	}
	public BigDecimal getR138_average_rate() {
		return r138_average_rate;
	}
	public void setR138_average_rate(BigDecimal r138_average_rate) {
		this.r138_average_rate = r138_average_rate;
	}
	public BigDecimal getR138_federal() {
		return r138_federal;
	}
	public void setR138_federal(BigDecimal r138_federal) {
		this.r138_federal = r138_federal;
	}
	public BigDecimal getR138_gre() {
		return r138_gre;
	}
	public void setR138_gre(BigDecimal r138_gre) {
		this.r138_gre = r138_gre;
	}
	public BigDecimal getR138_nbfi() {
		return r138_nbfi;
	}
	public void setR138_nbfi(BigDecimal r138_nbfi) {
		this.r138_nbfi = r138_nbfi;
	}
	public BigDecimal getR138_sme() {
		return r138_sme;
	}
	public void setR138_sme(BigDecimal r138_sme) {
		this.r138_sme = r138_sme;
	}
	public String getR139_real_estate() {
		return r139_real_estate;
	}
	public void setR139_real_estate(String r139_real_estate) {
		this.r139_real_estate = r139_real_estate;
	}
	public BigDecimal getR139_minimum_rate() {
		return r139_minimum_rate;
	}
	public void setR139_minimum_rate(BigDecimal r139_minimum_rate) {
		this.r139_minimum_rate = r139_minimum_rate;
	}
	public BigDecimal getR139_maximum_rate() {
		return r139_maximum_rate;
	}
	public void setR139_maximum_rate(BigDecimal r139_maximum_rate) {
		this.r139_maximum_rate = r139_maximum_rate;
	}
	public BigDecimal getR139_average_rate() {
		return r139_average_rate;
	}
	public void setR139_average_rate(BigDecimal r139_average_rate) {
		this.r139_average_rate = r139_average_rate;
	}
	public BigDecimal getR139_federal() {
		return r139_federal;
	}
	public void setR139_federal(BigDecimal r139_federal) {
		this.r139_federal = r139_federal;
	}
	public BigDecimal getR139_gre() {
		return r139_gre;
	}
	public void setR139_gre(BigDecimal r139_gre) {
		this.r139_gre = r139_gre;
	}
	public BigDecimal getR139_nbfi() {
		return r139_nbfi;
	}
	public void setR139_nbfi(BigDecimal r139_nbfi) {
		this.r139_nbfi = r139_nbfi;
	}
	public BigDecimal getR139_sme() {
		return r139_sme;
	}
	public void setR139_sme(BigDecimal r139_sme) {
		this.r139_sme = r139_sme;
	}
	public String getR140_trust_reciept() {
		return r140_trust_reciept;
	}
	public void setR140_trust_reciept(String r140_trust_reciept) {
		this.r140_trust_reciept = r140_trust_reciept;
	}
	public BigDecimal getR140_minimum_rate() {
		return r140_minimum_rate;
	}
	public void setR140_minimum_rate(BigDecimal r140_minimum_rate) {
		this.r140_minimum_rate = r140_minimum_rate;
	}
	public BigDecimal getR140_maximum_rate() {
		return r140_maximum_rate;
	}
	public void setR140_maximum_rate(BigDecimal r140_maximum_rate) {
		this.r140_maximum_rate = r140_maximum_rate;
	}
	public BigDecimal getR140_average_rate() {
		return r140_average_rate;
	}
	public void setR140_average_rate(BigDecimal r140_average_rate) {
		this.r140_average_rate = r140_average_rate;
	}
	public BigDecimal getR140_federal() {
		return r140_federal;
	}
	public void setR140_federal(BigDecimal r140_federal) {
		this.r140_federal = r140_federal;
	}
	public BigDecimal getR140_gre() {
		return r140_gre;
	}
	public void setR140_gre(BigDecimal r140_gre) {
		this.r140_gre = r140_gre;
	}
	public BigDecimal getR140_nbfi() {
		return r140_nbfi;
	}
	public void setR140_nbfi(BigDecimal r140_nbfi) {
		this.r140_nbfi = r140_nbfi;
	}
	public BigDecimal getR140_sme() {
		return r140_sme;
	}
	public void setR140_sme(BigDecimal r140_sme) {
		this.r140_sme = r140_sme;
	}
	public String getR141_syndicated_loans() {
		return r141_syndicated_loans;
	}
	public void setR141_syndicated_loans(String r141_syndicated_loans) {
		this.r141_syndicated_loans = r141_syndicated_loans;
	}
	public BigDecimal getR141_minimum_rate() {
		return r141_minimum_rate;
	}
	public void setR141_minimum_rate(BigDecimal r141_minimum_rate) {
		this.r141_minimum_rate = r141_minimum_rate;
	}
	public BigDecimal getR141_maximum_rate() {
		return r141_maximum_rate;
	}
	public void setR141_maximum_rate(BigDecimal r141_maximum_rate) {
		this.r141_maximum_rate = r141_maximum_rate;
	}
	public BigDecimal getR141_average_rate() {
		return r141_average_rate;
	}
	public void setR141_average_rate(BigDecimal r141_average_rate) {
		this.r141_average_rate = r141_average_rate;
	}
	public BigDecimal getR141_federal() {
		return r141_federal;
	}
	public void setR141_federal(BigDecimal r141_federal) {
		this.r141_federal = r141_federal;
	}
	public BigDecimal getR141_gre() {
		return r141_gre;
	}
	public void setR141_gre(BigDecimal r141_gre) {
		this.r141_gre = r141_gre;
	}
	public BigDecimal getR141_nbfi() {
		return r141_nbfi;
	}
	public void setR141_nbfi(BigDecimal r141_nbfi) {
		this.r141_nbfi = r141_nbfi;
	}
	public BigDecimal getR141_sme() {
		return r141_sme;
	}
	public void setR141_sme(BigDecimal r141_sme) {
		this.r141_sme = r141_sme;
	}
	public String getR142_discount_rates() {
		return r142_discount_rates;
	}
	public void setR142_discount_rates(String r142_discount_rates) {
		this.r142_discount_rates = r142_discount_rates;
	}
	public BigDecimal getR142_minimum_rate() {
		return r142_minimum_rate;
	}
	public void setR142_minimum_rate(BigDecimal r142_minimum_rate) {
		this.r142_minimum_rate = r142_minimum_rate;
	}
	public BigDecimal getR142_maximum_rate() {
		return r142_maximum_rate;
	}
	public void setR142_maximum_rate(BigDecimal r142_maximum_rate) {
		this.r142_maximum_rate = r142_maximum_rate;
	}
	public BigDecimal getR142_average_rate() {
		return r142_average_rate;
	}
	public void setR142_average_rate(BigDecimal r142_average_rate) {
		this.r142_average_rate = r142_average_rate;
	}
	public BigDecimal getR142_federal() {
		return r142_federal;
	}
	public void setR142_federal(BigDecimal r142_federal) {
		this.r142_federal = r142_federal;
	}
	public BigDecimal getR142_gre() {
		return r142_gre;
	}
	public void setR142_gre(BigDecimal r142_gre) {
		this.r142_gre = r142_gre;
	}
	public BigDecimal getR142_nbfi() {
		return r142_nbfi;
	}
	public void setR142_nbfi(BigDecimal r142_nbfi) {
		this.r142_nbfi = r142_nbfi;
	}
	public BigDecimal getR142_sme() {
		return r142_sme;
	}
	public void setR142_sme(BigDecimal r142_sme) {
		this.r142_sme = r142_sme;
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
	public String getR143_interest_rate() {
		return r143_interest_rate;
	}
	public void setR143_interest_rate(String r143_interest_rate) {
		this.r143_interest_rate = r143_interest_rate;
	}
	public BigDecimal getR143_maximum_rate() {
		return r143_maximum_rate;
	}
	public void setR143_maximum_rate(BigDecimal r143_maximum_rate) {
		this.r143_maximum_rate = r143_maximum_rate;
	}
	public BigDecimal getR143_minimum_rate() {
		return r143_minimum_rate;
	}
	public void setR143_minimum_rate(BigDecimal r143_minimum_rate) {
		this.r143_minimum_rate = r143_minimum_rate;
	}
	public BigDecimal getR143_average_rate() {
		return r143_average_rate;
	}
	public void setR143_average_rate(BigDecimal r143_average_rate) {
		this.r143_average_rate = r143_average_rate;
	}
	public String getR144_above_200k7() {
		return r144_above_200k7;
	}
	public void setR144_above_200k7(String r144_above_200k7) {
		this.r144_above_200k7 = r144_above_200k7;
	}
	public BigDecimal getR144_minimum_rate() {
		return r144_minimum_rate;
	}
	public void setR144_minimum_rate(BigDecimal r144_minimum_rate) {
		this.r144_minimum_rate = r144_minimum_rate;
	}
	public BigDecimal getR144_maximum_rate() {
		return r144_maximum_rate;
	}
	public void setR144_maximum_rate(BigDecimal r144_maximum_rate) {
		this.r144_maximum_rate = r144_maximum_rate;
	}
	public BigDecimal getR144_average_rate() {
		return r144_average_rate;
	}
	public void setR144_average_rate(BigDecimal r144_average_rate) {
		this.r144_average_rate = r144_average_rate;
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
	public BRF37() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}