package com.bornfire.xbrl.entities.BRBS;
import java.math.BigDecimal;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="MR3_RES")
public class B25_BASEL_RPT {
	
	@Id
	private Date	report_date;
	private String	currency_type;
	private String	r1_product1;
	private String	r1_product2;
	private BigDecimal	r1_debt_sec_long;
	private BigDecimal	r1_debt_sec_short;
	private BigDecimal	r1_int_rate_long;
	private BigDecimal	r1_int_rate_short;
	private BigDecimal	r1_options_long; 
	private BigDecimal	r1_options_short;
	private BigDecimal	r1_total_position_long;
	private BigDecimal	r1_total_position_short;
	private String	r1_risk_weight;
	private String	r1_weighted_positions_long;
	private String	r1_weighted_positions_short;
	private BigDecimal	r1_within_bands_zones_matched;
	private String	r1_within_bands_zones_unmatched;
	private BigDecimal	r1_between_zones_matched;
	private BigDecimal	r1_between_zones_unmatched;
	private BigDecimal	r1_net_pos_cap_charge;
	private String	r1_risk_cap_charge;
	private BigDecimal	r1_capital_charge;
	private String	r2_product1;
	private String	r2_product2;
	private BigDecimal	r2_debt_sec_long;
	private BigDecimal	r2_debt_sec_short;
	private BigDecimal	r2_int_rate_long;
	private BigDecimal	r2_int_rate_short;
	private BigDecimal	r2_options_long;
	private BigDecimal	r2_options_short;
	private BigDecimal	r2_total_position_long;
	private BigDecimal	r2_total_position_short;
	private String	r2_risk_weight;
	private String	r2_weighted_positions_long;
	private String	r2_weighted_positions_short;
	private BigDecimal	r2_within_bands_zones_matched;
	private String	r2_within_bands_zones_unmatched;
	private BigDecimal	r2_between_zones_matched;
	private BigDecimal	r2_between_zones_unmatched;
	private BigDecimal	r2_net_pos_cap_charge;
	private String	r2_risk_cap_charge;
	private BigDecimal	r2_capital_charge;
	private String	r3_product1;
	private String	r3_product2;
	private BigDecimal	r3_debt_sec_long;
	private BigDecimal	r3_debt_sec_short;
	private BigDecimal	r3_int_rate_long;
	private BigDecimal	r3_int_rate_short;
	private BigDecimal	r3_options_long;
	private BigDecimal	r3_options_short;
	private BigDecimal	r3_total_position_long;
	private BigDecimal	r3_total_position_short;
	private String	r3_risk_weight;
	private String	r3_weighted_positions_long;
	private String	r3_weighted_positions_short;
	private BigDecimal	r3_within_bands_zones_matched;
	private String	r3_within_bands_zones_unmatched;
	private BigDecimal	r3_between_zones_matched;
	private BigDecimal	r3_between_zones_unmatched;
	private BigDecimal	r3_net_pos_cap_charge;
	private String	r3_risk_cap_charge;
	private BigDecimal	r3_capital_charge;
	private String	r4_product1;
	private String	r4_product2;
	private BigDecimal	r4_debt_sec_long;
	private BigDecimal	r4_debt_sec_short;
	private BigDecimal	r4_int_rate_long;
	private BigDecimal	r4_int_rate_short;
	private BigDecimal	r4_options_long;
	private BigDecimal	r4_options_short;
	private BigDecimal	r4_total_position_long;
	private BigDecimal	r4_total_position_short;
	private String	r4_risk_weight;
	private String	r4_weighted_positions_long;
	private String	r4_weighted_positions_short;
	private BigDecimal	r4_within_bands_zones_matched;
	private String	r4_within_bands_zones_unmatched;
	private BigDecimal	r4_between_zones_matched;
	private BigDecimal	r4_between_zones_unmatched;
	private BigDecimal	r4_net_pos_cap_charge;
	private String	r4_risk_cap_charge;
	private BigDecimal	r4_capital_charge;
	private String	r5_product1;
	private String	r5_product2;
	private BigDecimal	r5_debt_sec_long;
	private BigDecimal	r5_debt_sec_short;
	private BigDecimal	r5_int_rate_long;
	private BigDecimal	r5_int_rate_short;
	private BigDecimal	r5_options_long;
	private BigDecimal	r5_options_short;
	private BigDecimal	r5_total_position_long;
	private BigDecimal	r5_total_position_short;
	private String	r5_risk_weight;
	private String	r5_weighted_positions_long;
	private String	r5_weighted_positions_short;
	private BigDecimal	r5_within_bands_zones_matched;
	private String	r5_within_bands_zones_unmatched;
	private BigDecimal	r5_between_zones_matched;
	private BigDecimal	r5_between_zones_unmatched;
	private BigDecimal	r5_net_pos_cap_charge;
	private String	r5_risk_cap_charge;
	private BigDecimal	r5_capital_charge;
	private String	r6_product1;
	private String	r6_product2;
	private BigDecimal	r6_debt_sec_long;
	private BigDecimal	r6_debt_sec_short;
	private BigDecimal	r6_int_rate_long;
	private BigDecimal	r6_int_rate_short;
	private BigDecimal	r6_options_long;
	private BigDecimal	r6_options_short;
	private BigDecimal	r6_total_position_long;
	private BigDecimal	r6_total_position_short;
	private String	r6_risk_weight;
	private String	r6_weighted_positions_long;
	private String	r6_weighted_positions_short;
	private BigDecimal	r6_within_bands_zones_matched;
	private String	r6_within_bands_zones_unmatched;
	private BigDecimal	r6_between_zones_matched;
	private BigDecimal	r6_between_zones_unmatched;
	private BigDecimal	r6_net_pos_cap_charge;
	private String	r6_risk_cap_charge;
	private BigDecimal	r6_capital_charge;
	private String	r7_product1;
	private String	r7_product2;
	private BigDecimal	r7_debt_sec_long;
	private BigDecimal	r7_debt_sec_short;
	private BigDecimal	r7_int_rate_long;
	private BigDecimal	r7_int_rate_short;
	private BigDecimal	r7_options_long;
	private BigDecimal	r7_options_short;
	private BigDecimal	r7_total_position_long;
	private BigDecimal	r7_total_position_short;
	private String	r7_risk_weight;
	private String	r7_weighted_positions_long;
	private String	r7_weighted_positions_short;
	private BigDecimal	r7_within_bands_zones_matched;
	private String	r7_within_bands_zones_unmatched;
	private BigDecimal	r7_between_zones_matched;
	private BigDecimal	r7_between_zones_unmatched;
	private BigDecimal	r7_net_pos_cap_charge;
	private String	r7_risk_cap_charge;
	private BigDecimal	r7_capital_charge;
	private String	r8_product1;
	private String	r8_product2;
	private BigDecimal	r8_debt_sec_long;
	private BigDecimal	r8_debt_sec_short;
	private BigDecimal	r8_int_rate_long;
	private BigDecimal	r8_int_rate_short;
	private BigDecimal	r8_options_long;
	private BigDecimal	r8_options_short;
	private BigDecimal	r8_total_position_long;
	private BigDecimal	r8_total_position_short;
	private String	r8_risk_weight;
	private String	r8_weighted_positions_long;
	private String	r8_weighted_positions_short;
	private BigDecimal	r8_within_bands_zones_matched;
	private String	r8_within_bands_zones_unmatched;
	private BigDecimal	r8_between_zones_matched;
	private BigDecimal	r8_between_zones_unmatched;
	private BigDecimal	r8_net_pos_cap_charge;
	private String	r8_risk_cap_charge;
	private BigDecimal	r8_capital_charge;
	private String	r9_product1;
	private String	r9_product2;
	private BigDecimal	r9_debt_sec_long;
	private BigDecimal	r9_debt_sec_short;
	private BigDecimal	r9_int_rate_long;
	private BigDecimal	r9_int_rate_short;
	private BigDecimal	r9_options_long;
	private BigDecimal	r9_options_short;
	private BigDecimal	r9_total_position_long;
	private BigDecimal	r9_total_position_short;
	private String	r9_risk_weight;
	private String	r9_weighted_positions_long;
	private String	r9_weighted_positions_short;
	private BigDecimal	r9_within_bands_zones_matched;
	private String	r9_within_bands_zones_unmatched;
	private BigDecimal	r9_between_zones_matched;
	private BigDecimal	r9_between_zones_unmatched;
	private BigDecimal	r9_net_pos_cap_charge;
	private String	r9_risk_cap_charge;
	private BigDecimal	r9_capital_charge;
	private String	r10_product1;
	private String	r10_product2;
	private BigDecimal	r10_debt_sec_long;
	private BigDecimal	r10_debt_sec_short;
	private BigDecimal	r10_int_rate_long;
	private BigDecimal	r10_int_rate_short;
	private BigDecimal	r10_options_long;
	private BigDecimal	r10_options_short;
	private BigDecimal	r10_total_position_long;
	private BigDecimal	r10_total_position_short;
	private String	r10_risk_weight;
	private String	r10_weighted_positions_long;
	private String	r10_weighted_positions_short;
	private BigDecimal	r10_within_bands_zones_matched;
	private String	r10_within_bands_zones_unmatched;
	private BigDecimal	r10_between_zones_matched;
	private BigDecimal	r10_between_zones_unmatched;
	private BigDecimal	r10_net_pos_cap_charge;
	private String	r10_risk_cap_charge;
	private BigDecimal	r10_capital_charge;
	private String	r11_product1;
	private String	r11_product2;
	private BigDecimal	r11_debt_sec_long;
	private BigDecimal	r11_debt_sec_short;
	private BigDecimal	r11_int_rate_long;
	private BigDecimal	r11_int_rate_short;
	private BigDecimal	r11_options_long;
	private BigDecimal	r11_options_short;
	private BigDecimal	r11_total_position_long;
	private BigDecimal	r11_total_position_short;
	private String	r11_risk_weight;
	private String	r11_weighted_positions_long;
	private String	r11_weighted_positions_short;
	private BigDecimal	r11_within_bands_zones_matched;
	private String	r11_within_bands_zones_unmatched;
	private BigDecimal	r11_between_zones_matched;
	private BigDecimal	r11_between_zones_unmatched;
	private BigDecimal	r11_net_pos_cap_charge;
	private String	r11_risk_cap_charge;
	private BigDecimal	r11_capital_charge;
	private String	r12_product1;
	private String	r12_product2;
	private BigDecimal	r12_debt_sec_long;
	private BigDecimal	r12_debt_sec_short;
	private BigDecimal	r12_int_rate_long;
	private BigDecimal	r12_int_rate_short;
	private BigDecimal	r12_options_long;
	private BigDecimal	r12_options_short;
	private BigDecimal	r12_total_position_long;
	private BigDecimal	r12_total_position_short;
	private String	r12_risk_weight;
	private String	r12_weighted_positions_long;
	private String	r12_weighted_positions_short;
	private BigDecimal	r12_within_bands_zones_matched;
	private String	r12_within_bands_zones_unmatched;
	private BigDecimal	r12_between_zones_matched;
	private BigDecimal	r12_between_zones_unmatched;
	private BigDecimal	r12_net_pos_cap_charge;
	private String	r12_risk_cap_charge;
	private BigDecimal	r12_capital_charge;
	private String	r13_product1;
	private String	r13_product2;
	private BigDecimal	r13_debt_sec_long;
	private BigDecimal	r13_debt_sec_short;
	private BigDecimal	r13_int_rate_long;
	private BigDecimal	r13_int_rate_short;
	private BigDecimal	r13_options_long;
	private BigDecimal	r13_options_short;
	private BigDecimal	r13_total_position_long;
	private BigDecimal	r13_total_position_short;
	private String	r13_risk_weight;
	private String	r13_weighted_positions_long;
	private String	r13_weighted_positions_short;
	private BigDecimal	r13_within_bands_zones_matched;
	private String	r13_within_bands_zones_unmatched;
	private BigDecimal	r13_between_zones_matched;
	private BigDecimal	r13_between_zones_unmatched;
	private BigDecimal	r13_net_pos_cap_charge;
	private String	r13_risk_cap_charge;
	private BigDecimal	r13_capital_charge;
	private String	r14_product1;
	private String	r14_product2;
	private BigDecimal	r14_debt_sec_long;
	private BigDecimal	r14_debt_sec_short;
	private BigDecimal	r14_int_rate_long;
	private BigDecimal	r14_int_rate_short;
	private BigDecimal	r14_options_long;
	private BigDecimal	r14_options_short;
	private BigDecimal	r14_total_position_long;
	private BigDecimal	r14_total_position_short;
	private String	r14_risk_weight;
	private String	r14_weighted_positions_long;
	private String	r14_weighted_positions_short;
	private BigDecimal	r14_within_bands_zones_matched;
	private String	r14_within_bands_zones_unmatched;
	private BigDecimal	r14_between_zones_matched;
	private BigDecimal	r14_between_zones_unmatched;
	private BigDecimal	r14_net_pos_cap_charge;
	private String	r14_risk_cap_charge;
	private BigDecimal	r14_capital_charge;
	private String	r15_product1;
	private String	r15_product2;
	private BigDecimal	r15_debt_sec_long;
	private BigDecimal	r15_debt_sec_short;
	private BigDecimal	r15_int_rate_long;
	private BigDecimal	r15_int_rate_short;
	private BigDecimal	r15_options_long;
	private BigDecimal	r15_options_short;
	private BigDecimal	r15_total_position_long;
	private BigDecimal	r15_total_position_short;
	private String	r15_risk_weight;
	private String	r15_weighted_positions_long;
	private String	r15_weighted_positions_short;
	private BigDecimal	r15_within_bands_zones_matched;
	private String	r15_within_bands_zones_unmatched;
	private BigDecimal	r15_between_zones_matched;
	private BigDecimal	r15_between_zones_unmatched;
	private BigDecimal	r15_net_pos_cap_charge;
	private String	r15_risk_cap_charge;
	private BigDecimal	r15_capital_charge;
	private String	r16_product1;
	private String	r16_product2;
	private BigDecimal	r16_debt_sec_long;
	private BigDecimal	r16_debt_sec_short;
	private BigDecimal	r16_int_rate_long;
	private BigDecimal	r16_int_rate_short;
	private BigDecimal	r16_options_long;
	private BigDecimal	r16_options_short;
	private BigDecimal	r16_total_position_long;
	private BigDecimal	r16_total_position_short;
	private String	r16_risk_weight;
	private String	r16_weighted_positions_long;
	private String	r16_weighted_positions_short;
	private BigDecimal	r16_within_bands_zones_matched;
	private String	r16_within_bands_zones_unmatched;
	private BigDecimal	r16_between_zones_matched;
	private BigDecimal	r16_between_zones_unmatched;
	private BigDecimal	r16_net_pos_cap_charge;
	private String	r16_risk_cap_charge;
	private BigDecimal	r16_capital_charge;
	private String	r17_product1;
	private String	r17_product2;
	private BigDecimal	r17_debt_sec_long;
	private BigDecimal	r17_debt_sec_short;
	private BigDecimal	r17_int_rate_long;
	private BigDecimal	r17_int_rate_short;
	private BigDecimal	r17_options_long;
	private BigDecimal	r17_options_short;
	private BigDecimal	r17_total_position_long;
	private BigDecimal	r17_total_position_short;
	private String	r17_risk_weight;
	private String	r17_weighted_positions_long;
	private String	r17_weighted_positions_short;
	private BigDecimal	r17_within_bands_zones_matched;
	private String	r17_within_bands_zones_unmatched;
	private BigDecimal	r17_between_zones_matched;
	private BigDecimal	r17_between_zones_unmatched;
	private BigDecimal	r17_net_pos_cap_charge;
	private String	r17_risk_cap_charge;
	private BigDecimal	r17_capital_charge;
	private String	r18_product1;
	private String	r18_product2;
	private BigDecimal	r18_debt_sec_long;
	private BigDecimal	r18_debt_sec_short;
	private BigDecimal	r18_int_rate_long;
	private BigDecimal	r18_int_rate_short;
	private BigDecimal	r18_options_long;
	private BigDecimal	r18_options_short;
	private BigDecimal	r18_total_position_long;
	private BigDecimal	r18_total_position_short;
	private String	r18_risk_weight;
	private String	r18_weighted_positions_long;
	private String	r18_weighted_positions_short;
	private BigDecimal	r18_within_bands_zones_matched;
	private String	r18_within_bands_zones_unmatched;
	private BigDecimal	r18_between_zones_matched;
	private BigDecimal	r18_between_zones_unmatched;
	private BigDecimal	r18_net_pos_cap_charge;
	private String	r18_risk_cap_charge;
	private BigDecimal	r18_capital_charge;
	private String	r19_product1;
	private String	r19_product2;
	private BigDecimal	r19_debt_sec_long;
	private BigDecimal	r19_debt_sec_short;
	private BigDecimal	r19_int_rate_long;
	private BigDecimal	r19_int_rate_short;
	private BigDecimal	r19_options_long;
	private BigDecimal	r19_options_short;
	private BigDecimal	r19_total_position_long;
	private BigDecimal	r19_total_position_short;
	private String	r19_risk_weight;
	private String	r19_weighted_positions_long;
	private String	r19_weighted_positions_short;
	private BigDecimal	r19_within_bands_zones_matched;
	private String	r19_within_bands_zones_unmatched;
	private BigDecimal	r19_between_zones_matched;
	private BigDecimal	r19_between_zones_unmatched;
	private BigDecimal	r19_net_pos_cap_charge;
	private String	r19_risk_cap_charge;
	private BigDecimal	r19_capital_charge;
	private String	r20_product1;
	private String	r20_product2;
	private BigDecimal	r20_debt_sec_long;
	private BigDecimal	r20_debt_sec_short;
	private BigDecimal	r20_int_rate_long;
	private BigDecimal	r20_int_rate_short;
	private BigDecimal	r20_options_long;
	private BigDecimal	r20_options_short;
	private BigDecimal	r20_total_position_long;
	private BigDecimal	r20_total_position_short;
	private String	r20_risk_weight;
	private String	r20_weighted_positions_long;
	private String	r20_weighted_positions_short;
	private BigDecimal	r20_within_bands_zones_matched;
	private String	r20_within_bands_zones_unmatched;
	private BigDecimal	r20_between_zones_matched;
	private BigDecimal	r20_between_zones_unmatched;
	private BigDecimal	r20_net_pos_cap_charge;
	private String	r20_risk_cap_charge;
	private BigDecimal	r20_capital_charge;
	private String	r21_product1;
	private String	r21_product2;
	private BigDecimal	r21_debt_sec_long;
	private BigDecimal	r21_debt_sec_short;
	private BigDecimal	r21_int_rate_long;
	private BigDecimal	r21_int_rate_short;
	private BigDecimal	r21_options_long;
	private BigDecimal	r21_options_short;
	private BigDecimal	r21_total_position_long;
	private BigDecimal	r21_total_position_short;
	private String	r21_risk_weight;
	private String	r21_weighted_positions_long;
	private String	r21_weighted_positions_short;
	private BigDecimal	r21_within_bands_zones_matched;
	private String	r21_within_bands_zones_unmatched;
	private BigDecimal	r21_between_zones_matched;
	private BigDecimal	r21_between_zones_unmatched;
	private BigDecimal	r21_net_pos_cap_charge;
	private String	r21_risk_cap_charge;
	private BigDecimal	r21_capital_charge;
	private String	r22_product1;
	private String	r22_product2;
	private BigDecimal	r22_debt_sec_long;
	private BigDecimal	r22_debt_sec_short;
	private BigDecimal	r22_int_rate_long;
	private BigDecimal	r22_int_rate_short;
	private BigDecimal	r22_options_long;
	private BigDecimal	r22_options_short;
	private BigDecimal	r22_total_position_long;
	private BigDecimal	r22_total_position_short;
	private String	r22_risk_weight;
	private String	r22_weighted_positions_long;
	private String	r22_weighted_positions_short;
	private BigDecimal	r22_within_bands_zones_matched;
	private String	r22_within_bands_zones_unmatched;
	private BigDecimal	r22_between_zones_matched;
	private BigDecimal	r22_between_zones_unmatched;
	private BigDecimal	r22_net_pos_cap_charge;
	private String	r22_risk_cap_charge;
	private BigDecimal	r22_capital_charge;
	private String	r23_product1;
	private String	r23_product2;
	private BigDecimal	r23_debt_sec_long;
	private BigDecimal	r23_debt_sec_short;
	private BigDecimal	r23_int_rate_long;
	private BigDecimal	r23_int_rate_short;
	private BigDecimal	r23_options_long;
	private BigDecimal	r23_options_short;
	private BigDecimal	r23_total_position_long;
	private BigDecimal	r23_total_position_short;
	private String	r23_risk_weight;
	private String	r23_weighted_positions_long;
	private String	r23_weighted_positions_short;
	private BigDecimal	r23_within_bands_zones_matched;
	private String	r23_within_bands_zones_unmatched;
	private BigDecimal	r23_between_zones_matched;
	private BigDecimal	r23_between_zones_unmatched;
	private BigDecimal	r23_net_pos_cap_charge;
	private String	r23_risk_cap_charge;
	private BigDecimal	r23_capital_charge;
	private String	r24_product1;
	private String	r24_product2;
	private BigDecimal	r24_debt_sec_long;
	private BigDecimal	r24_debt_sec_short;
	private BigDecimal	r24_int_rate_long;
	private BigDecimal	r24_int_rate_short;
	private BigDecimal	r24_options_long;
	private BigDecimal	r24_options_short;
	private BigDecimal	r24_total_position_long;
	private BigDecimal	r24_total_position_short;
	private String	r24_risk_weight;
	private String	r24_weighted_positions_long;
	private String	r24_weighted_positions_short;
	private BigDecimal	r24_within_bands_zones_matched;
	private String	r24_within_bands_zones_unmatched;
	private BigDecimal	r24_between_zones_matched;
	private BigDecimal	r24_between_zones_unmatched;
	private BigDecimal	r24_net_pos_cap_charge;
	private String	r24_risk_cap_charge;
	private BigDecimal	r24_capital_charge;
	private String	r25_product1;
	private String	r25_product2;
	private BigDecimal	r25_debt_sec_long;
	private BigDecimal	r25_debt_sec_short;
	private BigDecimal	r25_int_rate_long;
	private BigDecimal	r25_int_rate_short;
	private BigDecimal	r25_options_long;
	private BigDecimal	r25_options_short;
	private BigDecimal	r25_total_position_long;
	private BigDecimal	r25_total_position_short;
	private String	r25_risk_weight;
	private String	r25_weighted_positions_long;
	private String	r25_weighted_positions_short;
	private BigDecimal	r25_within_bands_zones_matched;
	private String	r25_within_bands_zones_unmatched;
	private BigDecimal	r25_between_zones_matched;
	private BigDecimal	r25_between_zones_unmatched;
	private BigDecimal	r25_net_pos_cap_charge;
	private String	r25_risk_cap_charge;
	private BigDecimal	r25_capital_charge;
	private String	r26_product1;
	private String	r26_product2;
	private BigDecimal	r26_debt_sec_long;
	private BigDecimal	r26_debt_sec_short;
	private BigDecimal	r26_int_rate_long;
	private BigDecimal	r26_int_rate_short;
	private BigDecimal	r26_options_long;
	private BigDecimal	r26_options_short;
	private BigDecimal	r26_total_position_long;
	private BigDecimal	r26_total_position_short;
	private String	r26_risk_weight;
	private String	r26_weighted_positions_long;
	private String	r26_weighted_positions_short;
	private BigDecimal	r26_within_bands_zones_matched;
	private String	r26_within_bands_zones_unmatched;
	private BigDecimal	r26_between_zones_matched;
	private BigDecimal	r26_between_zones_unmatched;
	private BigDecimal	r26_net_pos_cap_charge;
	private String	r26_risk_cap_charge;
	private BigDecimal	r26_capital_charge;
	private String	r27_product1;
	private String	r27_product2;
	private BigDecimal	r27_debt_sec_long;
	private BigDecimal	r27_debt_sec_short;
	private BigDecimal	r27_int_rate_long;
	private BigDecimal	r27_int_rate_short;
	private BigDecimal	r27_options_long;
	private BigDecimal	r27_options_short;
	private BigDecimal	r27_total_position_long;
	private BigDecimal	r27_total_position_short;
	private String	r27_risk_weight;
	private String	r27_weighted_positions_long;
	private String	r27_weighted_positions_short;
	private BigDecimal	r27_within_bands_zones_matched;
	private String	r27_within_bands_zones_unmatched;
	private BigDecimal	r27_between_zones_matched;
	private BigDecimal	r27_between_zones_unmatched;
	private BigDecimal	r27_net_pos_cap_charge;
	private String	r27_risk_cap_charge;
	private BigDecimal	r27_capital_charge;
	private String	r28_product1;
	private String	r28_product2;
	private BigDecimal	r28_debt_sec_long;
	private BigDecimal	r28_debt_sec_short;
	private BigDecimal	r28_int_rate_long;
	private BigDecimal	r28_int_rate_short;
	private BigDecimal	r28_options_long;
	private BigDecimal	r28_options_short;
	private BigDecimal	r28_total_position_long;
	private BigDecimal	r28_total_position_short;
	private String	r28_risk_weight;
	private String	r28_weighted_positions_long;
	private String	r28_weighted_positions_short;
	private BigDecimal	r28_within_bands_zones_matched;
	private String	r28_within_bands_zones_unmatched;
	private BigDecimal	r28_between_zones_matched;
	private BigDecimal	r28_between_zones_unmatched;
	private BigDecimal	r28_net_pos_cap_charge;
	private String	r28_risk_cap_charge;
	private BigDecimal	r28_capital_charge;
	private String	r29_product1;
	private String	r29_product2;
	private BigDecimal	r29_debt_sec_long;
	private BigDecimal	r29_debt_sec_short;
	private BigDecimal	r29_int_rate_long;
	private BigDecimal	r29_int_rate_short;
	private BigDecimal	r29_options_long;
	private BigDecimal	r29_options_short;
	private BigDecimal	r29_total_position_long;
	private BigDecimal	r29_total_position_short;
	private String	r29_risk_weight;
	private String	r29_weighted_positions_long;
	private String	r29_weighted_positions_short;
	private BigDecimal	r29_within_bands_zones_matched;
	private String	r29_within_bands_zones_unmatched;
	private BigDecimal	r29_between_zones_matched;
	private BigDecimal	r29_between_zones_unmatched;
	private BigDecimal	r29_net_pos_cap_charge;
	private String	r29_risk_cap_charge;
	private BigDecimal	r29_capital_charge;
	private String	r30_product1;
	private String	r30_product2;
	private BigDecimal	r30_debt_sec_long;
	private BigDecimal	r30_debt_sec_short;
	private BigDecimal	r30_int_rate_long;
	private BigDecimal	r30_int_rate_short;
	private BigDecimal	r30_options_long;
	private BigDecimal	r30_options_short;
	private BigDecimal	r30_total_position_long;
	private BigDecimal	r30_total_position_short;
	private String	r30_risk_weight;
	private String	r30_weighted_positions_long;
	private String	r30_weighted_positions_short;
	private BigDecimal	r30_within_bands_zones_matched;
	private String	r30_within_bands_zones_unmatched;
	private BigDecimal	r30_between_zones_matched;
	private BigDecimal	r30_between_zones_unmatched;
	private BigDecimal	r30_net_pos_cap_charge;
	private String	r30_risk_cap_charge;
	private BigDecimal	r30_capital_charge;
	private String	r31_product1;
	private String	r31_product2;
	private BigDecimal	r31_debt_sec_long;
	private BigDecimal	r31_debt_sec_short;
	private BigDecimal	r31_int_rate_long;
	private BigDecimal	r31_int_rate_short;
	private BigDecimal	r31_options_long;
	private BigDecimal	r31_options_short;
	private BigDecimal	r31_total_position_long;
	private BigDecimal	r31_total_position_short;
	private String	r31_risk_weight;
	private String	r31_weighted_positions_long;
	private String	r31_weighted_positions_short;
	private BigDecimal	r31_within_bands_zones_matched;
	private String	r31_within_bands_zones_unmatched;
	private BigDecimal	r31_between_zones_matched;
	private BigDecimal	r31_between_zones_unmatched;
	private BigDecimal	r31_net_pos_cap_charge;
	private String	r31_risk_cap_charge;
	private BigDecimal	r31_capital_charge;
	private String	r32_product1;
	private String	r32_product2;
	private BigDecimal	r32_debt_sec_long;
	private BigDecimal	r32_debt_sec_short;
	private BigDecimal	r32_int_rate_long;
	private BigDecimal	r32_int_rate_short;
	private BigDecimal	r32_options_long;
	private BigDecimal	r32_options_short;
	private BigDecimal	r32_total_position_long;
	private BigDecimal	r32_total_position_short;
	private String	r32_risk_weight;
	private String	r32_weighted_positions_long;
	private String	r32_weighted_positions_short;
	private BigDecimal	r32_within_bands_zones_matched;
	private String	r32_within_bands_zones_unmatched;
	private BigDecimal	r32_between_zones_matched;
	private BigDecimal	r32_between_zones_unmatched;
	private BigDecimal	r32_net_pos_cap_charge;
	private String	r32_risk_cap_charge;
	private BigDecimal	r32_capital_charge;
	private String	r33_product1;
	private String	r33_product2;
	private BigDecimal	r33_debt_sec_long;
	private BigDecimal	r33_debt_sec_short;
	private BigDecimal	r33_int_rate_long;
	private BigDecimal	r33_int_rate_short;
	private BigDecimal	r33_options_long;
	private BigDecimal	r33_options_short;
	private BigDecimal	r33_total_position_long;
	private BigDecimal	r33_total_position_short;
	private String	r33_risk_weight;
	private String	r33_weighted_positions_long;
	private String	r33_weighted_positions_short;
	private BigDecimal	r33_within_bands_zones_matched;
	private String	r33_within_bands_zones_unmatched;
	private BigDecimal	r33_between_zones_matched;
	private BigDecimal	r33_between_zones_unmatched;
	private BigDecimal	r33_net_pos_cap_charge;
	private String	r33_risk_cap_charge;
	private BigDecimal	r33_capital_charge;
	private String	r34_product1;
	private String	r34_product2;
	private BigDecimal	r34_debt_sec_long;
	private BigDecimal	r34_debt_sec_short;
	private BigDecimal	r34_int_rate_long;
	private BigDecimal	r34_int_rate_short;
	private BigDecimal	r34_options_long;
	private BigDecimal	r34_options_short;
	private BigDecimal	r34_total_position_long;
	private BigDecimal	r34_total_position_short;
	private String	r34_risk_weight;
	private String	r34_weighted_positions_long;
	private String	r34_weighted_positions_short;
	private BigDecimal	r34_within_bands_zones_matched;
	private String	r34_within_bands_zones_unmatched;
	private BigDecimal	r34_between_zones_matched;
	private BigDecimal	r34_between_zones_unmatched;
	private BigDecimal	r34_net_pos_cap_charge;
	private String	r34_risk_cap_charge;
	private BigDecimal	r34_capital_charge;
	private String	r35_product1;
	private String	r35_product2;
	private BigDecimal	r35_debt_sec_long;
	private BigDecimal	r35_debt_sec_short;
	private BigDecimal	r35_int_rate_long;
	private BigDecimal	r35_int_rate_short;
	private BigDecimal	r35_options_long;
	private BigDecimal	r35_options_short;
	private BigDecimal	r35_total_position_long;
	private BigDecimal	r35_total_position_short;
	private String	r35_risk_weight;
	private String	r35_weighted_positions_long;
	private String	r35_weighted_positions_short;
	private BigDecimal	r35_within_bands_zones_matched;
	private String	r35_within_bands_zones_unmatched;
	private BigDecimal	r35_between_zones_matched;
	private BigDecimal	r35_between_zones_unmatched;
	private BigDecimal	r35_net_pos_cap_charge;
	private String	r35_risk_cap_charge;
	private BigDecimal	r35_capital_charge;
	private String	r36_product1;
	private String	r36_product2;
	private BigDecimal	r36_debt_sec_long;
	private BigDecimal	r36_debt_sec_short;
	private BigDecimal	r36_int_rate_long;
	private BigDecimal	r36_int_rate_short;
	private BigDecimal	r36_options_long;
	private BigDecimal	r36_options_short;
	private BigDecimal	r36_total_position_long;
	private BigDecimal	r36_total_position_short;
	private String	r36_risk_weight;
	private String	r36_weighted_positions_long;
	private String	r36_weighted_positions_short;
	private BigDecimal	r36_within_bands_zones_matched;
	private String	r36_within_bands_zones_unmatched;
	private BigDecimal	r36_between_zones_matched;
	private BigDecimal	r36_between_zones_unmatched;
	private BigDecimal	r36_net_pos_cap_charge;
	private String	r36_risk_cap_charge;
	private BigDecimal	r36_capital_charge;
	private String	r37_product1;
	private String	r37_product2;
	private BigDecimal	r37_debt_sec_long;
	private BigDecimal	r37_debt_sec_short;
	private BigDecimal	r37_int_rate_long;
	private BigDecimal	r37_int_rate_short;
	private BigDecimal	r37_options_long;
	private BigDecimal	r37_options_short;
	private BigDecimal	r37_total_position_long;
	private BigDecimal	r37_total_position_short;
	private String	r37_risk_weight;
	private String	r37_weighted_positions_long;
	private String	r37_weighted_positions_short;
	private BigDecimal	r37_within_bands_zones_matched;
	private String	r37_within_bands_zones_unmatched;
	private BigDecimal	r37_between_zones_matched;
	private BigDecimal	r37_between_zones_unmatched;
	private BigDecimal	r37_net_pos_cap_charge;
	private String	r37_risk_cap_charge;
	private BigDecimal	r37_capital_charge;
	private String	r38_product1;
	private String	r38_product2;
	private BigDecimal	r38_debt_sec_long;
	private BigDecimal	r38_debt_sec_short;
	private BigDecimal	r38_int_rate_long;
	private BigDecimal	r38_int_rate_short;
	private BigDecimal	r38_options_long;
	private BigDecimal	r38_options_short;
	private BigDecimal	r38_total_position_long;
	private BigDecimal	r38_total_position_short;
	private String	r38_risk_weight;
	private String	r38_weighted_positions_long;
	private String	r38_weighted_positions_short;
	private BigDecimal	r38_within_bands_zones_matched;
	private String	r38_within_bands_zones_unmatched;
	private BigDecimal	r38_between_zones_matched;
	private BigDecimal	r38_between_zones_unmatched;
	private BigDecimal	r38_net_pos_cap_charge;
	private String	r38_risk_cap_charge;
	private BigDecimal	r38_capital_charge;
	private Date	report_submit_date;
	private Date	report_from_date;
	private Date	report_to_date;
	private String	report_code;
	private String	entity_flg;
	private String	modify_flg;
	private String	del_flg;
	public Date getReport_date() {
		return report_date;
	}
	public void setReport_date(Date report_date) {
		this.report_date = report_date;
	}
	public String getCurrency_type() {
		return currency_type;
	}
	public void setCurrency_type(String currency_type) {
		this.currency_type = currency_type;
	}
	public String getR1_product1() {
		return r1_product1;
	}
	public void setR1_product1(String r1_product1) {
		this.r1_product1 = r1_product1;
	}
	public String getR1_product2() {
		return r1_product2;
	}
	public void setR1_product2(String r1_product2) {
		this.r1_product2 = r1_product2;
	}
	public BigDecimal getR1_debt_sec_long() {
		return r1_debt_sec_long;
	}
	public void setR1_debt_sec_long(BigDecimal r1_debt_sec_long) {
		this.r1_debt_sec_long = r1_debt_sec_long;
	}
	public BigDecimal getR1_debt_sec_short() {
		return r1_debt_sec_short;
	}
	public void setR1_debt_sec_short(BigDecimal r1_debt_sec_short) {
		this.r1_debt_sec_short = r1_debt_sec_short;
	}
	public BigDecimal getR1_int_rate_long() {
		return r1_int_rate_long;
	}
	public void setR1_int_rate_long(BigDecimal r1_int_rate_long) {
		this.r1_int_rate_long = r1_int_rate_long;
	}
	public BigDecimal getR1_int_rate_short() {
		return r1_int_rate_short;
	}
	public void setR1_int_rate_short(BigDecimal r1_int_rate_short) {
		this.r1_int_rate_short = r1_int_rate_short;
	}
	public BigDecimal getR1_options_long() {
		return r1_options_long;
	}
	public void setR1_options_long(BigDecimal r1_options_long) {
		this.r1_options_long = r1_options_long;
	}
	public BigDecimal getR1_options_short() {
		return r1_options_short;
	}
	public void setR1_options_short(BigDecimal r1_options_short) {
		this.r1_options_short = r1_options_short;
	}
	public BigDecimal getR1_total_position_long() {
		return r1_total_position_long;
	}
	public void setR1_total_position_long(BigDecimal r1_total_position_long) {
		this.r1_total_position_long = r1_total_position_long;
	}
	public BigDecimal getR1_total_position_short() {
		return r1_total_position_short;
	}
	public void setR1_total_position_short(BigDecimal r1_total_position_short) {
		this.r1_total_position_short = r1_total_position_short;
	}
	public String getR1_risk_weight() {
		return r1_risk_weight;
	}
	public void setR1_risk_weight(String r1_risk_weight) {
		this.r1_risk_weight = r1_risk_weight;
	}
	public String getR1_weighted_positions_long() {
		return r1_weighted_positions_long;
	}
	public void setR1_weighted_positions_long(String r1_weighted_positions_long) {
		this.r1_weighted_positions_long = r1_weighted_positions_long;
	}
	public String getR1_weighted_positions_short() {
		return r1_weighted_positions_short;
	}
	public void setR1_weighted_positions_short(String r1_weighted_positions_short) {
		this.r1_weighted_positions_short = r1_weighted_positions_short;
	}
	public BigDecimal getR1_within_bands_zones_matched() {
		return r1_within_bands_zones_matched;
	}
	public void setR1_within_bands_zones_matched(BigDecimal r1_within_bands_zones_matched) {
		this.r1_within_bands_zones_matched = r1_within_bands_zones_matched;
	}
	public String getR1_within_bands_zones_unmatched() {
		return r1_within_bands_zones_unmatched;
	}
	public void setR1_within_bands_zones_unmatched(String r1_within_bands_zones_unmatched) {
		this.r1_within_bands_zones_unmatched = r1_within_bands_zones_unmatched;
	}
	public BigDecimal getR1_between_zones_matched() {
		return r1_between_zones_matched;
	}
	public void setR1_between_zones_matched(BigDecimal r1_between_zones_matched) {
		this.r1_between_zones_matched = r1_between_zones_matched;
	}
	public BigDecimal getR1_between_zones_unmatched() {
		return r1_between_zones_unmatched;
	}
	public void setR1_between_zones_unmatched(BigDecimal r1_between_zones_unmatched) {
		this.r1_between_zones_unmatched = r1_between_zones_unmatched;
	}
	public BigDecimal getR1_net_pos_cap_charge() {
		return r1_net_pos_cap_charge;
	}
	public void setR1_net_pos_cap_charge(BigDecimal r1_net_pos_cap_charge) {
		this.r1_net_pos_cap_charge = r1_net_pos_cap_charge;
	}
	public String getR1_risk_cap_charge() {
		return r1_risk_cap_charge;
	}
	public void setR1_risk_cap_charge(String r1_risk_cap_charge) {
		this.r1_risk_cap_charge = r1_risk_cap_charge;
	}
	public BigDecimal getR1_capital_charge() {
		return r1_capital_charge;
	}
	public void setR1_capital_charge(BigDecimal r1_capital_charge) {
		this.r1_capital_charge = r1_capital_charge;
	}
	public String getR2_product1() {
		return r2_product1;
	}
	public void setR2_product1(String r2_product1) {
		this.r2_product1 = r2_product1;
	}
	public String getR2_product2() {
		return r2_product2;
	}
	public void setR2_product2(String r2_product2) {
		this.r2_product2 = r2_product2;
	}
	public BigDecimal getR2_debt_sec_long() {
		return r2_debt_sec_long;
	}
	public void setR2_debt_sec_long(BigDecimal r2_debt_sec_long) {
		this.r2_debt_sec_long = r2_debt_sec_long;
	}
	public BigDecimal getR2_debt_sec_short() {
		return r2_debt_sec_short;
	}
	public void setR2_debt_sec_short(BigDecimal r2_debt_sec_short) {
		this.r2_debt_sec_short = r2_debt_sec_short;
	}
	public BigDecimal getR2_int_rate_long() {
		return r2_int_rate_long;
	}
	public void setR2_int_rate_long(BigDecimal r2_int_rate_long) {
		this.r2_int_rate_long = r2_int_rate_long;
	}
	public BigDecimal getR2_int_rate_short() {
		return r2_int_rate_short;
	}
	public void setR2_int_rate_short(BigDecimal r2_int_rate_short) {
		this.r2_int_rate_short = r2_int_rate_short;
	}
	public BigDecimal getR2_options_long() {
		return r2_options_long;
	}
	public void setR2_options_long(BigDecimal r2_options_long) {
		this.r2_options_long = r2_options_long;
	}
	public BigDecimal getR2_options_short() {
		return r2_options_short;
	}
	public void setR2_options_short(BigDecimal r2_options_short) {
		this.r2_options_short = r2_options_short;
	}
	public BigDecimal getR2_total_position_long() {
		return r2_total_position_long;
	}
	public void setR2_total_position_long(BigDecimal r2_total_position_long) {
		this.r2_total_position_long = r2_total_position_long;
	}
	public BigDecimal getR2_total_position_short() {
		return r2_total_position_short;
	}
	public void setR2_total_position_short(BigDecimal r2_total_position_short) {
		this.r2_total_position_short = r2_total_position_short;
	}
	public String getR2_risk_weight() {
		return r2_risk_weight;
	}
	public void setR2_risk_weight(String r2_risk_weight) {
		this.r2_risk_weight = r2_risk_weight;
	}
	public String getR2_weighted_positions_long() {
		return r2_weighted_positions_long;
	}
	public void setR2_weighted_positions_long(String r2_weighted_positions_long) {
		this.r2_weighted_positions_long = r2_weighted_positions_long;
	}
	public String getR2_weighted_positions_short() {
		return r2_weighted_positions_short;
	}
	public void setR2_weighted_positions_short(String r2_weighted_positions_short) {
		this.r2_weighted_positions_short = r2_weighted_positions_short;
	}
	public BigDecimal getR2_within_bands_zones_matched() {
		return r2_within_bands_zones_matched;
	}
	public void setR2_within_bands_zones_matched(BigDecimal r2_within_bands_zones_matched) {
		this.r2_within_bands_zones_matched = r2_within_bands_zones_matched;
	}
	public String getR2_within_bands_zones_unmatched() {
		return r2_within_bands_zones_unmatched;
	}
	public void setR2_within_bands_zones_unmatched(String r2_within_bands_zones_unmatched) {
		this.r2_within_bands_zones_unmatched = r2_within_bands_zones_unmatched;
	}
	public BigDecimal getR2_between_zones_matched() {
		return r2_between_zones_matched;
	}
	public void setR2_between_zones_matched(BigDecimal r2_between_zones_matched) {
		this.r2_between_zones_matched = r2_between_zones_matched;
	}
	public BigDecimal getR2_between_zones_unmatched() {
		return r2_between_zones_unmatched;
	}
	public void setR2_between_zones_unmatched(BigDecimal r2_between_zones_unmatched) {
		this.r2_between_zones_unmatched = r2_between_zones_unmatched;
	}
	public BigDecimal getR2_net_pos_cap_charge() {
		return r2_net_pos_cap_charge;
	}
	public void setR2_net_pos_cap_charge(BigDecimal r2_net_pos_cap_charge) {
		this.r2_net_pos_cap_charge = r2_net_pos_cap_charge;
	}
	public String getR2_risk_cap_charge() {
		return r2_risk_cap_charge;
	}
	public void setR2_risk_cap_charge(String r2_risk_cap_charge) {
		this.r2_risk_cap_charge = r2_risk_cap_charge;
	}
	public BigDecimal getR2_capital_charge() {
		return r2_capital_charge;
	}
	public void setR2_capital_charge(BigDecimal r2_capital_charge) {
		this.r2_capital_charge = r2_capital_charge;
	}
	public String getR3_product1() {
		return r3_product1;
	}
	public void setR3_product1(String r3_product1) {
		this.r3_product1 = r3_product1;
	}
	public String getR3_product2() {
		return r3_product2;
	}
	public void setR3_product2(String r3_product2) {
		this.r3_product2 = r3_product2;
	}
	public BigDecimal getR3_debt_sec_long() {
		return r3_debt_sec_long;
	}
	public void setR3_debt_sec_long(BigDecimal r3_debt_sec_long) {
		this.r3_debt_sec_long = r3_debt_sec_long;
	}
	public BigDecimal getR3_debt_sec_short() {
		return r3_debt_sec_short;
	}
	public void setR3_debt_sec_short(BigDecimal r3_debt_sec_short) {
		this.r3_debt_sec_short = r3_debt_sec_short;
	}
	public BigDecimal getR3_int_rate_long() {
		return r3_int_rate_long;
	}
	public void setR3_int_rate_long(BigDecimal r3_int_rate_long) {
		this.r3_int_rate_long = r3_int_rate_long;
	}
	public BigDecimal getR3_int_rate_short() {
		return r3_int_rate_short;
	}
	public void setR3_int_rate_short(BigDecimal r3_int_rate_short) {
		this.r3_int_rate_short = r3_int_rate_short;
	}
	public BigDecimal getR3_options_long() {
		return r3_options_long;
	}
	public void setR3_options_long(BigDecimal r3_options_long) {
		this.r3_options_long = r3_options_long;
	}
	public BigDecimal getR3_options_short() {
		return r3_options_short;
	}
	public void setR3_options_short(BigDecimal r3_options_short) {
		this.r3_options_short = r3_options_short;
	}
	public BigDecimal getR3_total_position_long() {
		return r3_total_position_long;
	}
	public void setR3_total_position_long(BigDecimal r3_total_position_long) {
		this.r3_total_position_long = r3_total_position_long;
	}
	public BigDecimal getR3_total_position_short() {
		return r3_total_position_short;
	}
	public void setR3_total_position_short(BigDecimal r3_total_position_short) {
		this.r3_total_position_short = r3_total_position_short;
	}
	public String getR3_risk_weight() {
		return r3_risk_weight;
	}
	public void setR3_risk_weight(String r3_risk_weight) {
		this.r3_risk_weight = r3_risk_weight;
	}
	public String getR3_weighted_positions_long() {
		return r3_weighted_positions_long;
	}
	public void setR3_weighted_positions_long(String r3_weighted_positions_long) {
		this.r3_weighted_positions_long = r3_weighted_positions_long;
	}
	public String getR3_weighted_positions_short() {
		return r3_weighted_positions_short;
	}
	public void setR3_weighted_positions_short(String r3_weighted_positions_short) {
		this.r3_weighted_positions_short = r3_weighted_positions_short;
	}
	public BigDecimal getR3_within_bands_zones_matched() {
		return r3_within_bands_zones_matched;
	}
	public void setR3_within_bands_zones_matched(BigDecimal r3_within_bands_zones_matched) {
		this.r3_within_bands_zones_matched = r3_within_bands_zones_matched;
	}
	public String getR3_within_bands_zones_unmatched() {
		return r3_within_bands_zones_unmatched;
	}
	public void setR3_within_bands_zones_unmatched(String r3_within_bands_zones_unmatched) {
		this.r3_within_bands_zones_unmatched = r3_within_bands_zones_unmatched;
	}
	public BigDecimal getR3_between_zones_matched() {
		return r3_between_zones_matched;
	}
	public void setR3_between_zones_matched(BigDecimal r3_between_zones_matched) {
		this.r3_between_zones_matched = r3_between_zones_matched;
	}
	public BigDecimal getR3_between_zones_unmatched() {
		return r3_between_zones_unmatched;
	}
	public void setR3_between_zones_unmatched(BigDecimal r3_between_zones_unmatched) {
		this.r3_between_zones_unmatched = r3_between_zones_unmatched;
	}
	public BigDecimal getR3_net_pos_cap_charge() {
		return r3_net_pos_cap_charge;
	}
	public void setR3_net_pos_cap_charge(BigDecimal r3_net_pos_cap_charge) {
		this.r3_net_pos_cap_charge = r3_net_pos_cap_charge;
	}
	public String getR3_risk_cap_charge() {
		return r3_risk_cap_charge;
	}
	public void setR3_risk_cap_charge(String r3_risk_cap_charge) {
		this.r3_risk_cap_charge = r3_risk_cap_charge;
	}
	public BigDecimal getR3_capital_charge() {
		return r3_capital_charge;
	}
	public void setR3_capital_charge(BigDecimal r3_capital_charge) {
		this.r3_capital_charge = r3_capital_charge;
	}
	public String getR4_product1() {
		return r4_product1;
	}
	public void setR4_product1(String r4_product1) {
		this.r4_product1 = r4_product1;
	}
	public String getR4_product2() {
		return r4_product2;
	}
	public void setR4_product2(String r4_product2) {
		this.r4_product2 = r4_product2;
	}
	public BigDecimal getR4_debt_sec_long() {
		return r4_debt_sec_long;
	}
	public void setR4_debt_sec_long(BigDecimal r4_debt_sec_long) {
		this.r4_debt_sec_long = r4_debt_sec_long;
	}
	public BigDecimal getR4_debt_sec_short() {
		return r4_debt_sec_short;
	}
	public void setR4_debt_sec_short(BigDecimal r4_debt_sec_short) {
		this.r4_debt_sec_short = r4_debt_sec_short;
	}
	public BigDecimal getR4_int_rate_long() {
		return r4_int_rate_long;
	}
	public void setR4_int_rate_long(BigDecimal r4_int_rate_long) {
		this.r4_int_rate_long = r4_int_rate_long;
	}
	public BigDecimal getR4_int_rate_short() {
		return r4_int_rate_short;
	}
	public void setR4_int_rate_short(BigDecimal r4_int_rate_short) {
		this.r4_int_rate_short = r4_int_rate_short;
	}
	public BigDecimal getR4_options_long() {
		return r4_options_long;
	}
	public void setR4_options_long(BigDecimal r4_options_long) {
		this.r4_options_long = r4_options_long;
	}
	public BigDecimal getR4_options_short() {
		return r4_options_short;
	}
	public void setR4_options_short(BigDecimal r4_options_short) {
		this.r4_options_short = r4_options_short;
	}
	public BigDecimal getR4_total_position_long() {
		return r4_total_position_long;
	}
	public void setR4_total_position_long(BigDecimal r4_total_position_long) {
		this.r4_total_position_long = r4_total_position_long;
	}
	public BigDecimal getR4_total_position_short() {
		return r4_total_position_short;
	}
	public void setR4_total_position_short(BigDecimal r4_total_position_short) {
		this.r4_total_position_short = r4_total_position_short;
	}
	public String getR4_risk_weight() {
		return r4_risk_weight;
	}
	public void setR4_risk_weight(String r4_risk_weight) {
		this.r4_risk_weight = r4_risk_weight;
	}
	public String getR4_weighted_positions_long() {
		return r4_weighted_positions_long;
	}
	public void setR4_weighted_positions_long(String r4_weighted_positions_long) {
		this.r4_weighted_positions_long = r4_weighted_positions_long;
	}
	public String getR4_weighted_positions_short() {
		return r4_weighted_positions_short;
	}
	public void setR4_weighted_positions_short(String r4_weighted_positions_short) {
		this.r4_weighted_positions_short = r4_weighted_positions_short;
	}
	public BigDecimal getR4_within_bands_zones_matched() {
		return r4_within_bands_zones_matched;
	}
	public void setR4_within_bands_zones_matched(BigDecimal r4_within_bands_zones_matched) {
		this.r4_within_bands_zones_matched = r4_within_bands_zones_matched;
	}
	public String getR4_within_bands_zones_unmatched() {
		return r4_within_bands_zones_unmatched;
	}
	public void setR4_within_bands_zones_unmatched(String r4_within_bands_zones_unmatched) {
		this.r4_within_bands_zones_unmatched = r4_within_bands_zones_unmatched;
	}
	public BigDecimal getR4_between_zones_matched() {
		return r4_between_zones_matched;
	}
	public void setR4_between_zones_matched(BigDecimal r4_between_zones_matched) {
		this.r4_between_zones_matched = r4_between_zones_matched;
	}
	public BigDecimal getR4_between_zones_unmatched() {
		return r4_between_zones_unmatched;
	}
	public void setR4_between_zones_unmatched(BigDecimal r4_between_zones_unmatched) {
		this.r4_between_zones_unmatched = r4_between_zones_unmatched;
	}
	public BigDecimal getR4_net_pos_cap_charge() {
		return r4_net_pos_cap_charge;
	}
	public void setR4_net_pos_cap_charge(BigDecimal r4_net_pos_cap_charge) {
		this.r4_net_pos_cap_charge = r4_net_pos_cap_charge;
	}
	public String getR4_risk_cap_charge() {
		return r4_risk_cap_charge;
	}
	public void setR4_risk_cap_charge(String r4_risk_cap_charge) {
		this.r4_risk_cap_charge = r4_risk_cap_charge;
	}
	public BigDecimal getR4_capital_charge() {
		return r4_capital_charge;
	}
	public void setR4_capital_charge(BigDecimal r4_capital_charge) {
		this.r4_capital_charge = r4_capital_charge;
	}
	public String getR5_product1() {
		return r5_product1;
	}
	public void setR5_product1(String r5_product1) {
		this.r5_product1 = r5_product1;
	}
	public String getR5_product2() {
		return r5_product2;
	}
	public void setR5_product2(String r5_product2) {
		this.r5_product2 = r5_product2;
	}
	public BigDecimal getR5_debt_sec_long() {
		return r5_debt_sec_long;
	}
	public void setR5_debt_sec_long(BigDecimal r5_debt_sec_long) {
		this.r5_debt_sec_long = r5_debt_sec_long;
	}
	public BigDecimal getR5_debt_sec_short() {
		return r5_debt_sec_short;
	}
	public void setR5_debt_sec_short(BigDecimal r5_debt_sec_short) {
		this.r5_debt_sec_short = r5_debt_sec_short;
	}
	public BigDecimal getR5_int_rate_long() {
		return r5_int_rate_long;
	}
	public void setR5_int_rate_long(BigDecimal r5_int_rate_long) {
		this.r5_int_rate_long = r5_int_rate_long;
	}
	public BigDecimal getR5_int_rate_short() {
		return r5_int_rate_short;
	}
	public void setR5_int_rate_short(BigDecimal r5_int_rate_short) {
		this.r5_int_rate_short = r5_int_rate_short;
	}
	public BigDecimal getR5_options_long() {
		return r5_options_long;
	}
	public void setR5_options_long(BigDecimal r5_options_long) {
		this.r5_options_long = r5_options_long;
	}
	public BigDecimal getR5_options_short() {
		return r5_options_short;
	}
	public void setR5_options_short(BigDecimal r5_options_short) {
		this.r5_options_short = r5_options_short;
	}
	public BigDecimal getR5_total_position_long() {
		return r5_total_position_long;
	}
	public void setR5_total_position_long(BigDecimal r5_total_position_long) {
		this.r5_total_position_long = r5_total_position_long;
	}
	public BigDecimal getR5_total_position_short() {
		return r5_total_position_short;
	}
	public void setR5_total_position_short(BigDecimal r5_total_position_short) {
		this.r5_total_position_short = r5_total_position_short;
	}
	public String getR5_risk_weight() {
		return r5_risk_weight;
	}
	public void setR5_risk_weight(String r5_risk_weight) {
		this.r5_risk_weight = r5_risk_weight;
	}
	public String getR5_weighted_positions_long() {
		return r5_weighted_positions_long;
	}
	public void setR5_weighted_positions_long(String r5_weighted_positions_long) {
		this.r5_weighted_positions_long = r5_weighted_positions_long;
	}
	public String getR5_weighted_positions_short() {
		return r5_weighted_positions_short;
	}
	public void setR5_weighted_positions_short(String r5_weighted_positions_short) {
		this.r5_weighted_positions_short = r5_weighted_positions_short;
	}
	public BigDecimal getR5_within_bands_zones_matched() {
		return r5_within_bands_zones_matched;
	}
	public void setR5_within_bands_zones_matched(BigDecimal r5_within_bands_zones_matched) {
		this.r5_within_bands_zones_matched = r5_within_bands_zones_matched;
	}
	public String getR5_within_bands_zones_unmatched() {
		return r5_within_bands_zones_unmatched;
	}
	public void setR5_within_bands_zones_unmatched(String r5_within_bands_zones_unmatched) {
		this.r5_within_bands_zones_unmatched = r5_within_bands_zones_unmatched;
	}
	public BigDecimal getR5_between_zones_matched() {
		return r5_between_zones_matched;
	}
	public void setR5_between_zones_matched(BigDecimal r5_between_zones_matched) {
		this.r5_between_zones_matched = r5_between_zones_matched;
	}
	public BigDecimal getR5_between_zones_unmatched() {
		return r5_between_zones_unmatched;
	}
	public void setR5_between_zones_unmatched(BigDecimal r5_between_zones_unmatched) {
		this.r5_between_zones_unmatched = r5_between_zones_unmatched;
	}
	public BigDecimal getR5_net_pos_cap_charge() {
		return r5_net_pos_cap_charge;
	}
	public void setR5_net_pos_cap_charge(BigDecimal r5_net_pos_cap_charge) {
		this.r5_net_pos_cap_charge = r5_net_pos_cap_charge;
	}
	public String getR5_risk_cap_charge() {
		return r5_risk_cap_charge;
	}
	public void setR5_risk_cap_charge(String r5_risk_cap_charge) {
		this.r5_risk_cap_charge = r5_risk_cap_charge;
	}
	public BigDecimal getR5_capital_charge() {
		return r5_capital_charge;
	}
	public void setR5_capital_charge(BigDecimal r5_capital_charge) {
		this.r5_capital_charge = r5_capital_charge;
	}
	public String getR6_product1() {
		return r6_product1;
	}
	public void setR6_product1(String r6_product1) {
		this.r6_product1 = r6_product1;
	}
	public String getR6_product2() {
		return r6_product2;
	}
	public void setR6_product2(String r6_product2) {
		this.r6_product2 = r6_product2;
	}
	public BigDecimal getR6_debt_sec_long() {
		return r6_debt_sec_long;
	}
	public void setR6_debt_sec_long(BigDecimal r6_debt_sec_long) {
		this.r6_debt_sec_long = r6_debt_sec_long;
	}
	public BigDecimal getR6_debt_sec_short() {
		return r6_debt_sec_short;
	}
	public void setR6_debt_sec_short(BigDecimal r6_debt_sec_short) {
		this.r6_debt_sec_short = r6_debt_sec_short;
	}
	public BigDecimal getR6_int_rate_long() {
		return r6_int_rate_long;
	}
	public void setR6_int_rate_long(BigDecimal r6_int_rate_long) {
		this.r6_int_rate_long = r6_int_rate_long;
	}
	public BigDecimal getR6_int_rate_short() {
		return r6_int_rate_short;
	}
	public void setR6_int_rate_short(BigDecimal r6_int_rate_short) {
		this.r6_int_rate_short = r6_int_rate_short;
	}
	public BigDecimal getR6_options_long() {
		return r6_options_long;
	}
	public void setR6_options_long(BigDecimal r6_options_long) {
		this.r6_options_long = r6_options_long;
	}
	public BigDecimal getR6_options_short() {
		return r6_options_short;
	}
	public void setR6_options_short(BigDecimal r6_options_short) {
		this.r6_options_short = r6_options_short;
	}
	public BigDecimal getR6_total_position_long() {
		return r6_total_position_long;
	}
	public void setR6_total_position_long(BigDecimal r6_total_position_long) {
		this.r6_total_position_long = r6_total_position_long;
	}
	public BigDecimal getR6_total_position_short() {
		return r6_total_position_short;
	}
	public void setR6_total_position_short(BigDecimal r6_total_position_short) {
		this.r6_total_position_short = r6_total_position_short;
	}
	public String getR6_risk_weight() {
		return r6_risk_weight;
	}
	public void setR6_risk_weight(String r6_risk_weight) {
		this.r6_risk_weight = r6_risk_weight;
	}
	public String getR6_weighted_positions_long() {
		return r6_weighted_positions_long;
	}
	public void setR6_weighted_positions_long(String r6_weighted_positions_long) {
		this.r6_weighted_positions_long = r6_weighted_positions_long;
	}
	public String getR6_weighted_positions_short() {
		return r6_weighted_positions_short;
	}
	public void setR6_weighted_positions_short(String r6_weighted_positions_short) {
		this.r6_weighted_positions_short = r6_weighted_positions_short;
	}
	public BigDecimal getR6_within_bands_zones_matched() {
		return r6_within_bands_zones_matched;
	}
	public void setR6_within_bands_zones_matched(BigDecimal r6_within_bands_zones_matched) {
		this.r6_within_bands_zones_matched = r6_within_bands_zones_matched;
	}
	public String getR6_within_bands_zones_unmatched() {
		return r6_within_bands_zones_unmatched;
	}
	public void setR6_within_bands_zones_unmatched(String r6_within_bands_zones_unmatched) {
		this.r6_within_bands_zones_unmatched = r6_within_bands_zones_unmatched;
	}
	public BigDecimal getR6_between_zones_matched() {
		return r6_between_zones_matched;
	}
	public void setR6_between_zones_matched(BigDecimal r6_between_zones_matched) {
		this.r6_between_zones_matched = r6_between_zones_matched;
	}
	public BigDecimal getR6_between_zones_unmatched() {
		return r6_between_zones_unmatched;
	}
	public void setR6_between_zones_unmatched(BigDecimal r6_between_zones_unmatched) {
		this.r6_between_zones_unmatched = r6_between_zones_unmatched;
	}
	public BigDecimal getR6_net_pos_cap_charge() {
		return r6_net_pos_cap_charge;
	}
	public void setR6_net_pos_cap_charge(BigDecimal r6_net_pos_cap_charge) {
		this.r6_net_pos_cap_charge = r6_net_pos_cap_charge;
	}
	public String getR6_risk_cap_charge() {
		return r6_risk_cap_charge;
	}
	public void setR6_risk_cap_charge(String r6_risk_cap_charge) {
		this.r6_risk_cap_charge = r6_risk_cap_charge;
	}
	public BigDecimal getR6_capital_charge() {
		return r6_capital_charge;
	}
	public void setR6_capital_charge(BigDecimal r6_capital_charge) {
		this.r6_capital_charge = r6_capital_charge;
	}
	public String getR7_product1() {
		return r7_product1;
	}
	public void setR7_product1(String r7_product1) {
		this.r7_product1 = r7_product1;
	}
	public String getR7_product2() {
		return r7_product2;
	}
	public void setR7_product2(String r7_product2) {
		this.r7_product2 = r7_product2;
	}
	public BigDecimal getR7_debt_sec_long() {
		return r7_debt_sec_long;
	}
	public void setR7_debt_sec_long(BigDecimal r7_debt_sec_long) {
		this.r7_debt_sec_long = r7_debt_sec_long;
	}
	public BigDecimal getR7_debt_sec_short() {
		return r7_debt_sec_short;
	}
	public void setR7_debt_sec_short(BigDecimal r7_debt_sec_short) {
		this.r7_debt_sec_short = r7_debt_sec_short;
	}
	public BigDecimal getR7_int_rate_long() {
		return r7_int_rate_long;
	}
	public void setR7_int_rate_long(BigDecimal r7_int_rate_long) {
		this.r7_int_rate_long = r7_int_rate_long;
	}
	public BigDecimal getR7_int_rate_short() {
		return r7_int_rate_short;
	}
	public void setR7_int_rate_short(BigDecimal r7_int_rate_short) {
		this.r7_int_rate_short = r7_int_rate_short;
	}
	public BigDecimal getR7_options_long() {
		return r7_options_long;
	}
	public void setR7_options_long(BigDecimal r7_options_long) {
		this.r7_options_long = r7_options_long;
	}
	public BigDecimal getR7_options_short() {
		return r7_options_short;
	}
	public void setR7_options_short(BigDecimal r7_options_short) {
		this.r7_options_short = r7_options_short;
	}
	public BigDecimal getR7_total_position_long() {
		return r7_total_position_long;
	}
	public void setR7_total_position_long(BigDecimal r7_total_position_long) {
		this.r7_total_position_long = r7_total_position_long;
	}
	public BigDecimal getR7_total_position_short() {
		return r7_total_position_short;
	}
	public void setR7_total_position_short(BigDecimal r7_total_position_short) {
		this.r7_total_position_short = r7_total_position_short;
	}
	public String getR7_risk_weight() {
		return r7_risk_weight;
	}
	public void setR7_risk_weight(String r7_risk_weight) {
		this.r7_risk_weight = r7_risk_weight;
	}
	public String getR7_weighted_positions_long() {
		return r7_weighted_positions_long;
	}
	public void setR7_weighted_positions_long(String r7_weighted_positions_long) {
		this.r7_weighted_positions_long = r7_weighted_positions_long;
	}
	public String getR7_weighted_positions_short() {
		return r7_weighted_positions_short;
	}
	public void setR7_weighted_positions_short(String r7_weighted_positions_short) {
		this.r7_weighted_positions_short = r7_weighted_positions_short;
	}
	public BigDecimal getR7_within_bands_zones_matched() {
		return r7_within_bands_zones_matched;
	}
	public void setR7_within_bands_zones_matched(BigDecimal r7_within_bands_zones_matched) {
		this.r7_within_bands_zones_matched = r7_within_bands_zones_matched;
	}
	public String getR7_within_bands_zones_unmatched() {
		return r7_within_bands_zones_unmatched;
	}
	public void setR7_within_bands_zones_unmatched(String r7_within_bands_zones_unmatched) {
		this.r7_within_bands_zones_unmatched = r7_within_bands_zones_unmatched;
	}
	public BigDecimal getR7_between_zones_matched() {
		return r7_between_zones_matched;
	}
	public void setR7_between_zones_matched(BigDecimal r7_between_zones_matched) {
		this.r7_between_zones_matched = r7_between_zones_matched;
	}
	public BigDecimal getR7_between_zones_unmatched() {
		return r7_between_zones_unmatched;
	}
	public void setR7_between_zones_unmatched(BigDecimal r7_between_zones_unmatched) {
		this.r7_between_zones_unmatched = r7_between_zones_unmatched;
	}
	public BigDecimal getR7_net_pos_cap_charge() {
		return r7_net_pos_cap_charge;
	}
	public void setR7_net_pos_cap_charge(BigDecimal r7_net_pos_cap_charge) {
		this.r7_net_pos_cap_charge = r7_net_pos_cap_charge;
	}
	public String getR7_risk_cap_charge() {
		return r7_risk_cap_charge;
	}
	public void setR7_risk_cap_charge(String r7_risk_cap_charge) {
		this.r7_risk_cap_charge = r7_risk_cap_charge;
	}
	public BigDecimal getR7_capital_charge() {
		return r7_capital_charge;
	}
	public void setR7_capital_charge(BigDecimal r7_capital_charge) {
		this.r7_capital_charge = r7_capital_charge;
	}
	public String getR8_product1() {
		return r8_product1;
	}
	public void setR8_product1(String r8_product1) {
		this.r8_product1 = r8_product1;
	}
	public String getR8_product2() {
		return r8_product2;
	}
	public void setR8_product2(String r8_product2) {
		this.r8_product2 = r8_product2;
	}
	public BigDecimal getR8_debt_sec_long() {
		return r8_debt_sec_long;
	}
	public void setR8_debt_sec_long(BigDecimal r8_debt_sec_long) {
		this.r8_debt_sec_long = r8_debt_sec_long;
	}
	public BigDecimal getR8_debt_sec_short() {
		return r8_debt_sec_short;
	}
	public void setR8_debt_sec_short(BigDecimal r8_debt_sec_short) {
		this.r8_debt_sec_short = r8_debt_sec_short;
	}
	public BigDecimal getR8_int_rate_long() {
		return r8_int_rate_long;
	}
	public void setR8_int_rate_long(BigDecimal r8_int_rate_long) {
		this.r8_int_rate_long = r8_int_rate_long;
	}
	public BigDecimal getR8_int_rate_short() {
		return r8_int_rate_short;
	}
	public void setR8_int_rate_short(BigDecimal r8_int_rate_short) {
		this.r8_int_rate_short = r8_int_rate_short;
	}
	public BigDecimal getR8_options_long() {
		return r8_options_long;
	}
	public void setR8_options_long(BigDecimal r8_options_long) {
		this.r8_options_long = r8_options_long;
	}
	public BigDecimal getR8_options_short() {
		return r8_options_short;
	}
	public void setR8_options_short(BigDecimal r8_options_short) {
		this.r8_options_short = r8_options_short;
	}
	public BigDecimal getR8_total_position_long() {
		return r8_total_position_long;
	}
	public void setR8_total_position_long(BigDecimal r8_total_position_long) {
		this.r8_total_position_long = r8_total_position_long;
	}
	public BigDecimal getR8_total_position_short() {
		return r8_total_position_short;
	}
	public void setR8_total_position_short(BigDecimal r8_total_position_short) {
		this.r8_total_position_short = r8_total_position_short;
	}
	public String getR8_risk_weight() {
		return r8_risk_weight;
	}
	public void setR8_risk_weight(String r8_risk_weight) {
		this.r8_risk_weight = r8_risk_weight;
	}
	public String getR8_weighted_positions_long() {
		return r8_weighted_positions_long;
	}
	public void setR8_weighted_positions_long(String r8_weighted_positions_long) {
		this.r8_weighted_positions_long = r8_weighted_positions_long;
	}
	public String getR8_weighted_positions_short() {
		return r8_weighted_positions_short;
	}
	public void setR8_weighted_positions_short(String r8_weighted_positions_short) {
		this.r8_weighted_positions_short = r8_weighted_positions_short;
	}
	public BigDecimal getR8_within_bands_zones_matched() {
		return r8_within_bands_zones_matched;
	}
	public void setR8_within_bands_zones_matched(BigDecimal r8_within_bands_zones_matched) {
		this.r8_within_bands_zones_matched = r8_within_bands_zones_matched;
	}
	public String getR8_within_bands_zones_unmatched() {
		return r8_within_bands_zones_unmatched;
	}
	public void setR8_within_bands_zones_unmatched(String r8_within_bands_zones_unmatched) {
		this.r8_within_bands_zones_unmatched = r8_within_bands_zones_unmatched;
	}
	public BigDecimal getR8_between_zones_matched() {
		return r8_between_zones_matched;
	}
	public void setR8_between_zones_matched(BigDecimal r8_between_zones_matched) {
		this.r8_between_zones_matched = r8_between_zones_matched;
	}
	public BigDecimal getR8_between_zones_unmatched() {
		return r8_between_zones_unmatched;
	}
	public void setR8_between_zones_unmatched(BigDecimal r8_between_zones_unmatched) {
		this.r8_between_zones_unmatched = r8_between_zones_unmatched;
	}
	public BigDecimal getR8_net_pos_cap_charge() {
		return r8_net_pos_cap_charge;
	}
	public void setR8_net_pos_cap_charge(BigDecimal r8_net_pos_cap_charge) {
		this.r8_net_pos_cap_charge = r8_net_pos_cap_charge;
	}
	public String getR8_risk_cap_charge() {
		return r8_risk_cap_charge;
	}
	public void setR8_risk_cap_charge(String r8_risk_cap_charge) {
		this.r8_risk_cap_charge = r8_risk_cap_charge;
	}
	public BigDecimal getR8_capital_charge() {
		return r8_capital_charge;
	}
	public void setR8_capital_charge(BigDecimal r8_capital_charge) {
		this.r8_capital_charge = r8_capital_charge;
	}
	public String getR9_product1() {
		return r9_product1;
	}
	public void setR9_product1(String r9_product1) {
		this.r9_product1 = r9_product1;
	}
	public String getR9_product2() {
		return r9_product2;
	}
	public void setR9_product2(String r9_product2) {
		this.r9_product2 = r9_product2;
	}
	public BigDecimal getR9_debt_sec_long() {
		return r9_debt_sec_long;
	}
	public void setR9_debt_sec_long(BigDecimal r9_debt_sec_long) {
		this.r9_debt_sec_long = r9_debt_sec_long;
	}
	public BigDecimal getR9_debt_sec_short() {
		return r9_debt_sec_short;
	}
	public void setR9_debt_sec_short(BigDecimal r9_debt_sec_short) {
		this.r9_debt_sec_short = r9_debt_sec_short;
	}
	public BigDecimal getR9_int_rate_long() {
		return r9_int_rate_long;
	}
	public void setR9_int_rate_long(BigDecimal r9_int_rate_long) {
		this.r9_int_rate_long = r9_int_rate_long;
	}
	public BigDecimal getR9_int_rate_short() {
		return r9_int_rate_short;
	}
	public void setR9_int_rate_short(BigDecimal r9_int_rate_short) {
		this.r9_int_rate_short = r9_int_rate_short;
	}
	public BigDecimal getR9_options_long() {
		return r9_options_long;
	}
	public void setR9_options_long(BigDecimal r9_options_long) {
		this.r9_options_long = r9_options_long;
	}
	public BigDecimal getR9_options_short() {
		return r9_options_short;
	}
	public void setR9_options_short(BigDecimal r9_options_short) {
		this.r9_options_short = r9_options_short;
	}
	public BigDecimal getR9_total_position_long() {
		return r9_total_position_long;
	}
	public void setR9_total_position_long(BigDecimal r9_total_position_long) {
		this.r9_total_position_long = r9_total_position_long;
	}
	public BigDecimal getR9_total_position_short() {
		return r9_total_position_short;
	}
	public void setR9_total_position_short(BigDecimal r9_total_position_short) {
		this.r9_total_position_short = r9_total_position_short;
	}
	public String getR9_risk_weight() {
		return r9_risk_weight;
	}
	public void setR9_risk_weight(String r9_risk_weight) {
		this.r9_risk_weight = r9_risk_weight;
	}
	public String getR9_weighted_positions_long() {
		return r9_weighted_positions_long;
	}
	public void setR9_weighted_positions_long(String r9_weighted_positions_long) {
		this.r9_weighted_positions_long = r9_weighted_positions_long;
	}
	public String getR9_weighted_positions_short() {
		return r9_weighted_positions_short;
	}
	public void setR9_weighted_positions_short(String r9_weighted_positions_short) {
		this.r9_weighted_positions_short = r9_weighted_positions_short;
	}
	public BigDecimal getR9_within_bands_zones_matched() {
		return r9_within_bands_zones_matched;
	}
	public void setR9_within_bands_zones_matched(BigDecimal r9_within_bands_zones_matched) {
		this.r9_within_bands_zones_matched = r9_within_bands_zones_matched;
	}
	public String getR9_within_bands_zones_unmatched() {
		return r9_within_bands_zones_unmatched;
	}
	public void setR9_within_bands_zones_unmatched(String r9_within_bands_zones_unmatched) {
		this.r9_within_bands_zones_unmatched = r9_within_bands_zones_unmatched;
	}
	public BigDecimal getR9_between_zones_matched() {
		return r9_between_zones_matched;
	}
	public void setR9_between_zones_matched(BigDecimal r9_between_zones_matched) {
		this.r9_between_zones_matched = r9_between_zones_matched;
	}
	public BigDecimal getR9_between_zones_unmatched() {
		return r9_between_zones_unmatched;
	}
	public void setR9_between_zones_unmatched(BigDecimal r9_between_zones_unmatched) {
		this.r9_between_zones_unmatched = r9_between_zones_unmatched;
	}
	public BigDecimal getR9_net_pos_cap_charge() {
		return r9_net_pos_cap_charge;
	}
	public void setR9_net_pos_cap_charge(BigDecimal r9_net_pos_cap_charge) {
		this.r9_net_pos_cap_charge = r9_net_pos_cap_charge;
	}
	public String getR9_risk_cap_charge() {
		return r9_risk_cap_charge;
	}
	public void setR9_risk_cap_charge(String r9_risk_cap_charge) {
		this.r9_risk_cap_charge = r9_risk_cap_charge;
	}
	public BigDecimal getR9_capital_charge() {
		return r9_capital_charge;
	}
	public void setR9_capital_charge(BigDecimal r9_capital_charge) {
		this.r9_capital_charge = r9_capital_charge;
	}
	public String getR10_product1() {
		return r10_product1;
	}
	public void setR10_product1(String r10_product1) {
		this.r10_product1 = r10_product1;
	}
	public String getR10_product2() {
		return r10_product2;
	}
	public void setR10_product2(String r10_product2) {
		this.r10_product2 = r10_product2;
	}
	public BigDecimal getR10_debt_sec_long() {
		return r10_debt_sec_long;
	}
	public void setR10_debt_sec_long(BigDecimal r10_debt_sec_long) {
		this.r10_debt_sec_long = r10_debt_sec_long;
	}
	public BigDecimal getR10_debt_sec_short() {
		return r10_debt_sec_short;
	}
	public void setR10_debt_sec_short(BigDecimal r10_debt_sec_short) {
		this.r10_debt_sec_short = r10_debt_sec_short;
	}
	public BigDecimal getR10_int_rate_long() {
		return r10_int_rate_long;
	}
	public void setR10_int_rate_long(BigDecimal r10_int_rate_long) {
		this.r10_int_rate_long = r10_int_rate_long;
	}
	public BigDecimal getR10_int_rate_short() {
		return r10_int_rate_short;
	}
	public void setR10_int_rate_short(BigDecimal r10_int_rate_short) {
		this.r10_int_rate_short = r10_int_rate_short;
	}
	public BigDecimal getR10_options_long() {
		return r10_options_long;
	}
	public void setR10_options_long(BigDecimal r10_options_long) {
		this.r10_options_long = r10_options_long;
	}
	public BigDecimal getR10_options_short() {
		return r10_options_short;
	}
	public void setR10_options_short(BigDecimal r10_options_short) {
		this.r10_options_short = r10_options_short;
	}
	public BigDecimal getR10_total_position_long() {
		return r10_total_position_long;
	}
	public void setR10_total_position_long(BigDecimal r10_total_position_long) {
		this.r10_total_position_long = r10_total_position_long;
	}
	public BigDecimal getR10_total_position_short() {
		return r10_total_position_short;
	}
	public void setR10_total_position_short(BigDecimal r10_total_position_short) {
		this.r10_total_position_short = r10_total_position_short;
	}
	public String getR10_risk_weight() {
		return r10_risk_weight;
	}
	public void setR10_risk_weight(String r10_risk_weight) {
		this.r10_risk_weight = r10_risk_weight;
	}
	public String getR10_weighted_positions_long() {
		return r10_weighted_positions_long;
	}
	public void setR10_weighted_positions_long(String r10_weighted_positions_long) {
		this.r10_weighted_positions_long = r10_weighted_positions_long;
	}
	public String getR10_weighted_positions_short() {
		return r10_weighted_positions_short;
	}
	public void setR10_weighted_positions_short(String r10_weighted_positions_short) {
		this.r10_weighted_positions_short = r10_weighted_positions_short;
	}
	public BigDecimal getR10_within_bands_zones_matched() {
		return r10_within_bands_zones_matched;
	}
	public void setR10_within_bands_zones_matched(BigDecimal r10_within_bands_zones_matched) {
		this.r10_within_bands_zones_matched = r10_within_bands_zones_matched;
	}
	public String getR10_within_bands_zones_unmatched() {
		return r10_within_bands_zones_unmatched;
	}
	public void setR10_within_bands_zones_unmatched(String r10_within_bands_zones_unmatched) {
		this.r10_within_bands_zones_unmatched = r10_within_bands_zones_unmatched;
	}
	public BigDecimal getR10_between_zones_matched() {
		return r10_between_zones_matched;
	}
	public void setR10_between_zones_matched(BigDecimal r10_between_zones_matched) {
		this.r10_between_zones_matched = r10_between_zones_matched;
	}
	public BigDecimal getR10_between_zones_unmatched() {
		return r10_between_zones_unmatched;
	}
	public void setR10_between_zones_unmatched(BigDecimal r10_between_zones_unmatched) {
		this.r10_between_zones_unmatched = r10_between_zones_unmatched;
	}
	public BigDecimal getR10_net_pos_cap_charge() {
		return r10_net_pos_cap_charge;
	}
	public void setR10_net_pos_cap_charge(BigDecimal r10_net_pos_cap_charge) {
		this.r10_net_pos_cap_charge = r10_net_pos_cap_charge;
	}
	public String getR10_risk_cap_charge() {
		return r10_risk_cap_charge;
	}
	public void setR10_risk_cap_charge(String r10_risk_cap_charge) {
		this.r10_risk_cap_charge = r10_risk_cap_charge;
	}
	public BigDecimal getR10_capital_charge() {
		return r10_capital_charge;
	}
	public void setR10_capital_charge(BigDecimal r10_capital_charge) {
		this.r10_capital_charge = r10_capital_charge;
	}
	public String getR11_product1() {
		return r11_product1;
	}
	public void setR11_product1(String r11_product1) {
		this.r11_product1 = r11_product1;
	}
	public String getR11_product2() {
		return r11_product2;
	}
	public void setR11_product2(String r11_product2) {
		this.r11_product2 = r11_product2;
	}
	public BigDecimal getR11_debt_sec_long() {
		return r11_debt_sec_long;
	}
	public void setR11_debt_sec_long(BigDecimal r11_debt_sec_long) {
		this.r11_debt_sec_long = r11_debt_sec_long;
	}
	public BigDecimal getR11_debt_sec_short() {
		return r11_debt_sec_short;
	}
	public void setR11_debt_sec_short(BigDecimal r11_debt_sec_short) {
		this.r11_debt_sec_short = r11_debt_sec_short;
	}
	public BigDecimal getR11_int_rate_long() {
		return r11_int_rate_long;
	}
	public void setR11_int_rate_long(BigDecimal r11_int_rate_long) {
		this.r11_int_rate_long = r11_int_rate_long;
	}
	public BigDecimal getR11_int_rate_short() {
		return r11_int_rate_short;
	}
	public void setR11_int_rate_short(BigDecimal r11_int_rate_short) {
		this.r11_int_rate_short = r11_int_rate_short;
	}
	public BigDecimal getR11_options_long() {
		return r11_options_long;
	}
	public void setR11_options_long(BigDecimal r11_options_long) {
		this.r11_options_long = r11_options_long;
	}
	public BigDecimal getR11_options_short() {
		return r11_options_short;
	}
	public void setR11_options_short(BigDecimal r11_options_short) {
		this.r11_options_short = r11_options_short;
	}
	public BigDecimal getR11_total_position_long() {
		return r11_total_position_long;
	}
	public void setR11_total_position_long(BigDecimal r11_total_position_long) {
		this.r11_total_position_long = r11_total_position_long;
	}
	public BigDecimal getR11_total_position_short() {
		return r11_total_position_short;
	}
	public void setR11_total_position_short(BigDecimal r11_total_position_short) {
		this.r11_total_position_short = r11_total_position_short;
	}
	public String getR11_risk_weight() {
		return r11_risk_weight;
	}
	public void setR11_risk_weight(String r11_risk_weight) {
		this.r11_risk_weight = r11_risk_weight;
	}
	public String getR11_weighted_positions_long() {
		return r11_weighted_positions_long;
	}
	public void setR11_weighted_positions_long(String r11_weighted_positions_long) {
		this.r11_weighted_positions_long = r11_weighted_positions_long;
	}
	public String getR11_weighted_positions_short() {
		return r11_weighted_positions_short;
	}
	public void setR11_weighted_positions_short(String r11_weighted_positions_short) {
		this.r11_weighted_positions_short = r11_weighted_positions_short;
	}
	public BigDecimal getR11_within_bands_zones_matched() {
		return r11_within_bands_zones_matched;
	}
	public void setR11_within_bands_zones_matched(BigDecimal r11_within_bands_zones_matched) {
		this.r11_within_bands_zones_matched = r11_within_bands_zones_matched;
	}
	public String getR11_within_bands_zones_unmatched() {
		return r11_within_bands_zones_unmatched;
	}
	public void setR11_within_bands_zones_unmatched(String r11_within_bands_zones_unmatched) {
		this.r11_within_bands_zones_unmatched = r11_within_bands_zones_unmatched;
	}
	public BigDecimal getR11_between_zones_matched() {
		return r11_between_zones_matched;
	}
	public void setR11_between_zones_matched(BigDecimal r11_between_zones_matched) {
		this.r11_between_zones_matched = r11_between_zones_matched;
	}
	public BigDecimal getR11_between_zones_unmatched() {
		return r11_between_zones_unmatched;
	}
	public void setR11_between_zones_unmatched(BigDecimal r11_between_zones_unmatched) {
		this.r11_between_zones_unmatched = r11_between_zones_unmatched;
	}
	public BigDecimal getR11_net_pos_cap_charge() {
		return r11_net_pos_cap_charge;
	}
	public void setR11_net_pos_cap_charge(BigDecimal r11_net_pos_cap_charge) {
		this.r11_net_pos_cap_charge = r11_net_pos_cap_charge;
	}
	public String getR11_risk_cap_charge() {
		return r11_risk_cap_charge;
	}
	public void setR11_risk_cap_charge(String r11_risk_cap_charge) {
		this.r11_risk_cap_charge = r11_risk_cap_charge;
	}
	public BigDecimal getR11_capital_charge() {
		return r11_capital_charge;
	}
	public void setR11_capital_charge(BigDecimal r11_capital_charge) {
		this.r11_capital_charge = r11_capital_charge;
	}
	public String getR12_product1() {
		return r12_product1;
	}
	public void setR12_product1(String r12_product1) {
		this.r12_product1 = r12_product1;
	}
	public String getR12_product2() {
		return r12_product2;
	}
	public void setR12_product2(String r12_product2) {
		this.r12_product2 = r12_product2;
	}
	public BigDecimal getR12_debt_sec_long() {
		return r12_debt_sec_long;
	}
	public void setR12_debt_sec_long(BigDecimal r12_debt_sec_long) {
		this.r12_debt_sec_long = r12_debt_sec_long;
	}
	public BigDecimal getR12_debt_sec_short() {
		return r12_debt_sec_short;
	}
	public void setR12_debt_sec_short(BigDecimal r12_debt_sec_short) {
		this.r12_debt_sec_short = r12_debt_sec_short;
	}
	public BigDecimal getR12_int_rate_long() {
		return r12_int_rate_long;
	}
	public void setR12_int_rate_long(BigDecimal r12_int_rate_long) {
		this.r12_int_rate_long = r12_int_rate_long;
	}
	public BigDecimal getR12_int_rate_short() {
		return r12_int_rate_short;
	}
	public void setR12_int_rate_short(BigDecimal r12_int_rate_short) {
		this.r12_int_rate_short = r12_int_rate_short;
	}
	public BigDecimal getR12_options_long() {
		return r12_options_long;
	}
	public void setR12_options_long(BigDecimal r12_options_long) {
		this.r12_options_long = r12_options_long;
	}
	public BigDecimal getR12_options_short() {
		return r12_options_short;
	}
	public void setR12_options_short(BigDecimal r12_options_short) {
		this.r12_options_short = r12_options_short;
	}
	public BigDecimal getR12_total_position_long() {
		return r12_total_position_long;
	}
	public void setR12_total_position_long(BigDecimal r12_total_position_long) {
		this.r12_total_position_long = r12_total_position_long;
	}
	public BigDecimal getR12_total_position_short() {
		return r12_total_position_short;
	}
	public void setR12_total_position_short(BigDecimal r12_total_position_short) {
		this.r12_total_position_short = r12_total_position_short;
	}
	public String getR12_risk_weight() {
		return r12_risk_weight;
	}
	public void setR12_risk_weight(String r12_risk_weight) {
		this.r12_risk_weight = r12_risk_weight;
	}
	public String getR12_weighted_positions_long() {
		return r12_weighted_positions_long;
	}
	public void setR12_weighted_positions_long(String r12_weighted_positions_long) {
		this.r12_weighted_positions_long = r12_weighted_positions_long;
	}
	public String getR12_weighted_positions_short() {
		return r12_weighted_positions_short;
	}
	public void setR12_weighted_positions_short(String r12_weighted_positions_short) {
		this.r12_weighted_positions_short = r12_weighted_positions_short;
	}
	public BigDecimal getR12_within_bands_zones_matched() {
		return r12_within_bands_zones_matched;
	}
	public void setR12_within_bands_zones_matched(BigDecimal r12_within_bands_zones_matched) {
		this.r12_within_bands_zones_matched = r12_within_bands_zones_matched;
	}
	public String getR12_within_bands_zones_unmatched() {
		return r12_within_bands_zones_unmatched;
	}
	public void setR12_within_bands_zones_unmatched(String r12_within_bands_zones_unmatched) {
		this.r12_within_bands_zones_unmatched = r12_within_bands_zones_unmatched;
	}
	public BigDecimal getR12_between_zones_matched() {
		return r12_between_zones_matched;
	}
	public void setR12_between_zones_matched(BigDecimal r12_between_zones_matched) {
		this.r12_between_zones_matched = r12_between_zones_matched;
	}
	public BigDecimal getR12_between_zones_unmatched() {
		return r12_between_zones_unmatched;
	}
	public void setR12_between_zones_unmatched(BigDecimal r12_between_zones_unmatched) {
		this.r12_between_zones_unmatched = r12_between_zones_unmatched;
	}
	public BigDecimal getR12_net_pos_cap_charge() {
		return r12_net_pos_cap_charge;
	}
	public void setR12_net_pos_cap_charge(BigDecimal r12_net_pos_cap_charge) {
		this.r12_net_pos_cap_charge = r12_net_pos_cap_charge;
	}
	public String getR12_risk_cap_charge() {
		return r12_risk_cap_charge;
	}
	public void setR12_risk_cap_charge(String r12_risk_cap_charge) {
		this.r12_risk_cap_charge = r12_risk_cap_charge;
	}
	public BigDecimal getR12_capital_charge() {
		return r12_capital_charge;
	}
	public void setR12_capital_charge(BigDecimal r12_capital_charge) {
		this.r12_capital_charge = r12_capital_charge;
	}
	public String getR13_product1() {
		return r13_product1;
	}
	public void setR13_product1(String r13_product1) {
		this.r13_product1 = r13_product1;
	}
	public String getR13_product2() {
		return r13_product2;
	}
	public void setR13_product2(String r13_product2) {
		this.r13_product2 = r13_product2;
	}
	public BigDecimal getR13_debt_sec_long() {
		return r13_debt_sec_long;
	}
	public void setR13_debt_sec_long(BigDecimal r13_debt_sec_long) {
		this.r13_debt_sec_long = r13_debt_sec_long;
	}
	public BigDecimal getR13_debt_sec_short() {
		return r13_debt_sec_short;
	}
	public void setR13_debt_sec_short(BigDecimal r13_debt_sec_short) {
		this.r13_debt_sec_short = r13_debt_sec_short;
	}
	public BigDecimal getR13_int_rate_long() {
		return r13_int_rate_long;
	}
	public void setR13_int_rate_long(BigDecimal r13_int_rate_long) {
		this.r13_int_rate_long = r13_int_rate_long;
	}
	public BigDecimal getR13_int_rate_short() {
		return r13_int_rate_short;
	}
	public void setR13_int_rate_short(BigDecimal r13_int_rate_short) {
		this.r13_int_rate_short = r13_int_rate_short;
	}
	public BigDecimal getR13_options_long() {
		return r13_options_long;
	}
	public void setR13_options_long(BigDecimal r13_options_long) {
		this.r13_options_long = r13_options_long;
	}
	public BigDecimal getR13_options_short() {
		return r13_options_short;
	}
	public void setR13_options_short(BigDecimal r13_options_short) {
		this.r13_options_short = r13_options_short;
	}
	public BigDecimal getR13_total_position_long() {
		return r13_total_position_long;
	}
	public void setR13_total_position_long(BigDecimal r13_total_position_long) {
		this.r13_total_position_long = r13_total_position_long;
	}
	public BigDecimal getR13_total_position_short() {
		return r13_total_position_short;
	}
	public void setR13_total_position_short(BigDecimal r13_total_position_short) {
		this.r13_total_position_short = r13_total_position_short;
	}
	public String getR13_risk_weight() {
		return r13_risk_weight;
	}
	public void setR13_risk_weight(String r13_risk_weight) {
		this.r13_risk_weight = r13_risk_weight;
	}
	public String getR13_weighted_positions_long() {
		return r13_weighted_positions_long;
	}
	public void setR13_weighted_positions_long(String r13_weighted_positions_long) {
		this.r13_weighted_positions_long = r13_weighted_positions_long;
	}
	public String getR13_weighted_positions_short() {
		return r13_weighted_positions_short;
	}
	public void setR13_weighted_positions_short(String r13_weighted_positions_short) {
		this.r13_weighted_positions_short = r13_weighted_positions_short;
	}
	public BigDecimal getR13_within_bands_zones_matched() {
		return r13_within_bands_zones_matched;
	}
	public void setR13_within_bands_zones_matched(BigDecimal r13_within_bands_zones_matched) {
		this.r13_within_bands_zones_matched = r13_within_bands_zones_matched;
	}
	public String getR13_within_bands_zones_unmatched() {
		return r13_within_bands_zones_unmatched;
	}
	public void setR13_within_bands_zones_unmatched(String r13_within_bands_zones_unmatched) {
		this.r13_within_bands_zones_unmatched = r13_within_bands_zones_unmatched;
	}
	public BigDecimal getR13_between_zones_matched() {
		return r13_between_zones_matched;
	}
	public void setR13_between_zones_matched(BigDecimal r13_between_zones_matched) {
		this.r13_between_zones_matched = r13_between_zones_matched;
	}
	public BigDecimal getR13_between_zones_unmatched() {
		return r13_between_zones_unmatched;
	}
	public void setR13_between_zones_unmatched(BigDecimal r13_between_zones_unmatched) {
		this.r13_between_zones_unmatched = r13_between_zones_unmatched;
	}
	public BigDecimal getR13_net_pos_cap_charge() {
		return r13_net_pos_cap_charge;
	}
	public void setR13_net_pos_cap_charge(BigDecimal r13_net_pos_cap_charge) {
		this.r13_net_pos_cap_charge = r13_net_pos_cap_charge;
	}
	public String getR13_risk_cap_charge() {
		return r13_risk_cap_charge;
	}
	public void setR13_risk_cap_charge(String r13_risk_cap_charge) {
		this.r13_risk_cap_charge = r13_risk_cap_charge;
	}
	public BigDecimal getR13_capital_charge() {
		return r13_capital_charge;
	}
	public void setR13_capital_charge(BigDecimal r13_capital_charge) {
		this.r13_capital_charge = r13_capital_charge;
	}
	public String getR14_product1() {
		return r14_product1;
	}
	public void setR14_product1(String r14_product1) {
		this.r14_product1 = r14_product1;
	}
	public String getR14_product2() {
		return r14_product2;
	}
	public void setR14_product2(String r14_product2) {
		this.r14_product2 = r14_product2;
	}
	public BigDecimal getR14_debt_sec_long() {
		return r14_debt_sec_long;
	}
	public void setR14_debt_sec_long(BigDecimal r14_debt_sec_long) {
		this.r14_debt_sec_long = r14_debt_sec_long;
	}
	public BigDecimal getR14_debt_sec_short() {
		return r14_debt_sec_short;
	}
	public void setR14_debt_sec_short(BigDecimal r14_debt_sec_short) {
		this.r14_debt_sec_short = r14_debt_sec_short;
	}
	public BigDecimal getR14_int_rate_long() {
		return r14_int_rate_long;
	}
	public void setR14_int_rate_long(BigDecimal r14_int_rate_long) {
		this.r14_int_rate_long = r14_int_rate_long;
	}
	public BigDecimal getR14_int_rate_short() {
		return r14_int_rate_short;
	}
	public void setR14_int_rate_short(BigDecimal r14_int_rate_short) {
		this.r14_int_rate_short = r14_int_rate_short;
	}
	public BigDecimal getR14_options_long() {
		return r14_options_long;
	}
	public void setR14_options_long(BigDecimal r14_options_long) {
		this.r14_options_long = r14_options_long;
	}
	public BigDecimal getR14_options_short() {
		return r14_options_short;
	}
	public void setR14_options_short(BigDecimal r14_options_short) {
		this.r14_options_short = r14_options_short;
	}
	public BigDecimal getR14_total_position_long() {
		return r14_total_position_long;
	}
	public void setR14_total_position_long(BigDecimal r14_total_position_long) {
		this.r14_total_position_long = r14_total_position_long;
	}
	public BigDecimal getR14_total_position_short() {
		return r14_total_position_short;
	}
	public void setR14_total_position_short(BigDecimal r14_total_position_short) {
		this.r14_total_position_short = r14_total_position_short;
	}
	public String getR14_risk_weight() {
		return r14_risk_weight;
	}
	public void setR14_risk_weight(String r14_risk_weight) {
		this.r14_risk_weight = r14_risk_weight;
	}
	public String getR14_weighted_positions_long() {
		return r14_weighted_positions_long;
	}
	public void setR14_weighted_positions_long(String r14_weighted_positions_long) {
		this.r14_weighted_positions_long = r14_weighted_positions_long;
	}
	public String getR14_weighted_positions_short() {
		return r14_weighted_positions_short;
	}
	public void setR14_weighted_positions_short(String r14_weighted_positions_short) {
		this.r14_weighted_positions_short = r14_weighted_positions_short;
	}
	public BigDecimal getR14_within_bands_zones_matched() {
		return r14_within_bands_zones_matched;
	}
	public void setR14_within_bands_zones_matched(BigDecimal r14_within_bands_zones_matched) {
		this.r14_within_bands_zones_matched = r14_within_bands_zones_matched;
	}
	public String getR14_within_bands_zones_unmatched() {
		return r14_within_bands_zones_unmatched;
	}
	public void setR14_within_bands_zones_unmatched(String r14_within_bands_zones_unmatched) {
		this.r14_within_bands_zones_unmatched = r14_within_bands_zones_unmatched;
	}
	public BigDecimal getR14_between_zones_matched() {
		return r14_between_zones_matched;
	}
	public void setR14_between_zones_matched(BigDecimal r14_between_zones_matched) {
		this.r14_between_zones_matched = r14_between_zones_matched;
	}
	public BigDecimal getR14_between_zones_unmatched() {
		return r14_between_zones_unmatched;
	}
	public void setR14_between_zones_unmatched(BigDecimal r14_between_zones_unmatched) {
		this.r14_between_zones_unmatched = r14_between_zones_unmatched;
	}
	public BigDecimal getR14_net_pos_cap_charge() {
		return r14_net_pos_cap_charge;
	}
	public void setR14_net_pos_cap_charge(BigDecimal r14_net_pos_cap_charge) {
		this.r14_net_pos_cap_charge = r14_net_pos_cap_charge;
	}
	public String getR14_risk_cap_charge() {
		return r14_risk_cap_charge;
	}
	public void setR14_risk_cap_charge(String r14_risk_cap_charge) {
		this.r14_risk_cap_charge = r14_risk_cap_charge;
	}
	public BigDecimal getR14_capital_charge() {
		return r14_capital_charge;
	}
	public void setR14_capital_charge(BigDecimal r14_capital_charge) {
		this.r14_capital_charge = r14_capital_charge;
	}
	public String getR15_product1() {
		return r15_product1;
	}
	public void setR15_product1(String r15_product1) {
		this.r15_product1 = r15_product1;
	}
	public String getR15_product2() {
		return r15_product2;
	}
	public void setR15_product2(String r15_product2) {
		this.r15_product2 = r15_product2;
	}
	public BigDecimal getR15_debt_sec_long() {
		return r15_debt_sec_long;
	}
	public void setR15_debt_sec_long(BigDecimal r15_debt_sec_long) {
		this.r15_debt_sec_long = r15_debt_sec_long;
	}
	public BigDecimal getR15_debt_sec_short() {
		return r15_debt_sec_short;
	}
	public void setR15_debt_sec_short(BigDecimal r15_debt_sec_short) {
		this.r15_debt_sec_short = r15_debt_sec_short;
	}
	public BigDecimal getR15_int_rate_long() {
		return r15_int_rate_long;
	}
	public void setR15_int_rate_long(BigDecimal r15_int_rate_long) {
		this.r15_int_rate_long = r15_int_rate_long;
	}
	public BigDecimal getR15_int_rate_short() {
		return r15_int_rate_short;
	}
	public void setR15_int_rate_short(BigDecimal r15_int_rate_short) {
		this.r15_int_rate_short = r15_int_rate_short;
	}
	public BigDecimal getR15_options_long() {
		return r15_options_long;
	}
	public void setR15_options_long(BigDecimal r15_options_long) {
		this.r15_options_long = r15_options_long;
	}
	public BigDecimal getR15_options_short() {
		return r15_options_short;
	}
	public void setR15_options_short(BigDecimal r15_options_short) {
		this.r15_options_short = r15_options_short;
	}
	public BigDecimal getR15_total_position_long() {
		return r15_total_position_long;
	}
	public void setR15_total_position_long(BigDecimal r15_total_position_long) {
		this.r15_total_position_long = r15_total_position_long;
	}
	public BigDecimal getR15_total_position_short() {
		return r15_total_position_short;
	}
	public void setR15_total_position_short(BigDecimal r15_total_position_short) {
		this.r15_total_position_short = r15_total_position_short;
	}
	public String getR15_risk_weight() {
		return r15_risk_weight;
	}
	public void setR15_risk_weight(String r15_risk_weight) {
		this.r15_risk_weight = r15_risk_weight;
	}
	public String getR15_weighted_positions_long() {
		return r15_weighted_positions_long;
	}
	public void setR15_weighted_positions_long(String r15_weighted_positions_long) {
		this.r15_weighted_positions_long = r15_weighted_positions_long;
	}
	public String getR15_weighted_positions_short() {
		return r15_weighted_positions_short;
	}
	public void setR15_weighted_positions_short(String r15_weighted_positions_short) {
		this.r15_weighted_positions_short = r15_weighted_positions_short;
	}
	public BigDecimal getR15_within_bands_zones_matched() {
		return r15_within_bands_zones_matched;
	}
	public void setR15_within_bands_zones_matched(BigDecimal r15_within_bands_zones_matched) {
		this.r15_within_bands_zones_matched = r15_within_bands_zones_matched;
	}
	public String getR15_within_bands_zones_unmatched() {
		return r15_within_bands_zones_unmatched;
	}
	public void setR15_within_bands_zones_unmatched(String r15_within_bands_zones_unmatched) {
		this.r15_within_bands_zones_unmatched = r15_within_bands_zones_unmatched;
	}
	public BigDecimal getR15_between_zones_matched() {
		return r15_between_zones_matched;
	}
	public void setR15_between_zones_matched(BigDecimal r15_between_zones_matched) {
		this.r15_between_zones_matched = r15_between_zones_matched;
	}
	public BigDecimal getR15_between_zones_unmatched() {
		return r15_between_zones_unmatched;
	}
	public void setR15_between_zones_unmatched(BigDecimal r15_between_zones_unmatched) {
		this.r15_between_zones_unmatched = r15_between_zones_unmatched;
	}
	public BigDecimal getR15_net_pos_cap_charge() {
		return r15_net_pos_cap_charge;
	}
	public void setR15_net_pos_cap_charge(BigDecimal r15_net_pos_cap_charge) {
		this.r15_net_pos_cap_charge = r15_net_pos_cap_charge;
	}
	public String getR15_risk_cap_charge() {
		return r15_risk_cap_charge;
	}
	public void setR15_risk_cap_charge(String r15_risk_cap_charge) {
		this.r15_risk_cap_charge = r15_risk_cap_charge;
	}
	public BigDecimal getR15_capital_charge() {
		return r15_capital_charge;
	}
	public void setR15_capital_charge(BigDecimal r15_capital_charge) {
		this.r15_capital_charge = r15_capital_charge;
	}
	public String getR16_product1() {
		return r16_product1;
	}
	public void setR16_product1(String r16_product1) {
		this.r16_product1 = r16_product1;
	}
	public String getR16_product2() {
		return r16_product2;
	}
	public void setR16_product2(String r16_product2) {
		this.r16_product2 = r16_product2;
	}
	public BigDecimal getR16_debt_sec_long() {
		return r16_debt_sec_long;
	}
	public void setR16_debt_sec_long(BigDecimal r16_debt_sec_long) {
		this.r16_debt_sec_long = r16_debt_sec_long;
	}
	public BigDecimal getR16_debt_sec_short() {
		return r16_debt_sec_short;
	}
	public void setR16_debt_sec_short(BigDecimal r16_debt_sec_short) {
		this.r16_debt_sec_short = r16_debt_sec_short;
	}
	public BigDecimal getR16_int_rate_long() {
		return r16_int_rate_long;
	}
	public void setR16_int_rate_long(BigDecimal r16_int_rate_long) {
		this.r16_int_rate_long = r16_int_rate_long;
	}
	public BigDecimal getR16_int_rate_short() {
		return r16_int_rate_short;
	}
	public void setR16_int_rate_short(BigDecimal r16_int_rate_short) {
		this.r16_int_rate_short = r16_int_rate_short;
	}
	public BigDecimal getR16_options_long() {
		return r16_options_long;
	}
	public void setR16_options_long(BigDecimal r16_options_long) {
		this.r16_options_long = r16_options_long;
	}
	public BigDecimal getR16_options_short() {
		return r16_options_short;
	}
	public void setR16_options_short(BigDecimal r16_options_short) {
		this.r16_options_short = r16_options_short;
	}
	public BigDecimal getR16_total_position_long() {
		return r16_total_position_long;
	}
	public void setR16_total_position_long(BigDecimal r16_total_position_long) {
		this.r16_total_position_long = r16_total_position_long;
	}
	public BigDecimal getR16_total_position_short() {
		return r16_total_position_short;
	}
	public void setR16_total_position_short(BigDecimal r16_total_position_short) {
		this.r16_total_position_short = r16_total_position_short;
	}
	public String getR16_risk_weight() {
		return r16_risk_weight;
	}
	public void setR16_risk_weight(String r16_risk_weight) {
		this.r16_risk_weight = r16_risk_weight;
	}
	public String getR16_weighted_positions_long() {
		return r16_weighted_positions_long;
	}
	public void setR16_weighted_positions_long(String r16_weighted_positions_long) {
		this.r16_weighted_positions_long = r16_weighted_positions_long;
	}
	public String getR16_weighted_positions_short() {
		return r16_weighted_positions_short;
	}
	public void setR16_weighted_positions_short(String r16_weighted_positions_short) {
		this.r16_weighted_positions_short = r16_weighted_positions_short;
	}
	public BigDecimal getR16_within_bands_zones_matched() {
		return r16_within_bands_zones_matched;
	}
	public void setR16_within_bands_zones_matched(BigDecimal r16_within_bands_zones_matched) {
		this.r16_within_bands_zones_matched = r16_within_bands_zones_matched;
	}
	public String getR16_within_bands_zones_unmatched() {
		return r16_within_bands_zones_unmatched;
	}
	public void setR16_within_bands_zones_unmatched(String r16_within_bands_zones_unmatched) {
		this.r16_within_bands_zones_unmatched = r16_within_bands_zones_unmatched;
	}
	public BigDecimal getR16_between_zones_matched() {
		return r16_between_zones_matched;
	}
	public void setR16_between_zones_matched(BigDecimal r16_between_zones_matched) {
		this.r16_between_zones_matched = r16_between_zones_matched;
	}
	public BigDecimal getR16_between_zones_unmatched() {
		return r16_between_zones_unmatched;
	}
	public void setR16_between_zones_unmatched(BigDecimal r16_between_zones_unmatched) {
		this.r16_between_zones_unmatched = r16_between_zones_unmatched;
	}
	public BigDecimal getR16_net_pos_cap_charge() {
		return r16_net_pos_cap_charge;
	}
	public void setR16_net_pos_cap_charge(BigDecimal r16_net_pos_cap_charge) {
		this.r16_net_pos_cap_charge = r16_net_pos_cap_charge;
	}
	public String getR16_risk_cap_charge() {
		return r16_risk_cap_charge;
	}
	public void setR16_risk_cap_charge(String r16_risk_cap_charge) {
		this.r16_risk_cap_charge = r16_risk_cap_charge;
	}
	public BigDecimal getR16_capital_charge() {
		return r16_capital_charge;
	}
	public void setR16_capital_charge(BigDecimal r16_capital_charge) {
		this.r16_capital_charge = r16_capital_charge;
	}
	public String getR17_product1() {
		return r17_product1;
	}
	public void setR17_product1(String r17_product1) {
		this.r17_product1 = r17_product1;
	}
	public String getR17_product2() {
		return r17_product2;
	}
	public void setR17_product2(String r17_product2) {
		this.r17_product2 = r17_product2;
	}
	public BigDecimal getR17_debt_sec_long() {
		return r17_debt_sec_long;
	}
	public void setR17_debt_sec_long(BigDecimal r17_debt_sec_long) {
		this.r17_debt_sec_long = r17_debt_sec_long;
	}
	public BigDecimal getR17_debt_sec_short() {
		return r17_debt_sec_short;
	}
	public void setR17_debt_sec_short(BigDecimal r17_debt_sec_short) {
		this.r17_debt_sec_short = r17_debt_sec_short;
	}
	public BigDecimal getR17_int_rate_long() {
		return r17_int_rate_long;
	}
	public void setR17_int_rate_long(BigDecimal r17_int_rate_long) {
		this.r17_int_rate_long = r17_int_rate_long;
	}
	public BigDecimal getR17_int_rate_short() {
		return r17_int_rate_short;
	}
	public void setR17_int_rate_short(BigDecimal r17_int_rate_short) {
		this.r17_int_rate_short = r17_int_rate_short;
	}
	public BigDecimal getR17_options_long() {
		return r17_options_long;
	}
	public void setR17_options_long(BigDecimal r17_options_long) {
		this.r17_options_long = r17_options_long;
	}
	public BigDecimal getR17_options_short() {
		return r17_options_short;
	}
	public void setR17_options_short(BigDecimal r17_options_short) {
		this.r17_options_short = r17_options_short;
	}
	public BigDecimal getR17_total_position_long() {
		return r17_total_position_long;
	}
	public void setR17_total_position_long(BigDecimal r17_total_position_long) {
		this.r17_total_position_long = r17_total_position_long;
	}
	public BigDecimal getR17_total_position_short() {
		return r17_total_position_short;
	}
	public void setR17_total_position_short(BigDecimal r17_total_position_short) {
		this.r17_total_position_short = r17_total_position_short;
	}
	public String getR17_risk_weight() {
		return r17_risk_weight;
	}
	public void setR17_risk_weight(String r17_risk_weight) {
		this.r17_risk_weight = r17_risk_weight;
	}
	public String getR17_weighted_positions_long() {
		return r17_weighted_positions_long;
	}
	public void setR17_weighted_positions_long(String r17_weighted_positions_long) {
		this.r17_weighted_positions_long = r17_weighted_positions_long;
	}
	public String getR17_weighted_positions_short() {
		return r17_weighted_positions_short;
	}
	public void setR17_weighted_positions_short(String r17_weighted_positions_short) {
		this.r17_weighted_positions_short = r17_weighted_positions_short;
	}
	public BigDecimal getR17_within_bands_zones_matched() {
		return r17_within_bands_zones_matched;
	}
	public void setR17_within_bands_zones_matched(BigDecimal r17_within_bands_zones_matched) {
		this.r17_within_bands_zones_matched = r17_within_bands_zones_matched;
	}
	public String getR17_within_bands_zones_unmatched() {
		return r17_within_bands_zones_unmatched;
	}
	public void setR17_within_bands_zones_unmatched(String r17_within_bands_zones_unmatched) {
		this.r17_within_bands_zones_unmatched = r17_within_bands_zones_unmatched;
	}
	public BigDecimal getR17_between_zones_matched() {
		return r17_between_zones_matched;
	}
	public void setR17_between_zones_matched(BigDecimal r17_between_zones_matched) {
		this.r17_between_zones_matched = r17_between_zones_matched;
	}
	public BigDecimal getR17_between_zones_unmatched() {
		return r17_between_zones_unmatched;
	}
	public void setR17_between_zones_unmatched(BigDecimal r17_between_zones_unmatched) {
		this.r17_between_zones_unmatched = r17_between_zones_unmatched;
	}
	public BigDecimal getR17_net_pos_cap_charge() {
		return r17_net_pos_cap_charge;
	}
	public void setR17_net_pos_cap_charge(BigDecimal r17_net_pos_cap_charge) {
		this.r17_net_pos_cap_charge = r17_net_pos_cap_charge;
	}
	public String getR17_risk_cap_charge() {
		return r17_risk_cap_charge;
	}
	public void setR17_risk_cap_charge(String r17_risk_cap_charge) {
		this.r17_risk_cap_charge = r17_risk_cap_charge;
	}
	public BigDecimal getR17_capital_charge() {
		return r17_capital_charge;
	}
	public void setR17_capital_charge(BigDecimal r17_capital_charge) {
		this.r17_capital_charge = r17_capital_charge;
	}
	public String getR18_product1() {
		return r18_product1;
	}
	public void setR18_product1(String r18_product1) {
		this.r18_product1 = r18_product1;
	}
	public String getR18_product2() {
		return r18_product2;
	}
	public void setR18_product2(String r18_product2) {
		this.r18_product2 = r18_product2;
	}
	public BigDecimal getR18_debt_sec_long() {
		return r18_debt_sec_long;
	}
	public void setR18_debt_sec_long(BigDecimal r18_debt_sec_long) {
		this.r18_debt_sec_long = r18_debt_sec_long;
	}
	public BigDecimal getR18_debt_sec_short() {
		return r18_debt_sec_short;
	}
	public void setR18_debt_sec_short(BigDecimal r18_debt_sec_short) {
		this.r18_debt_sec_short = r18_debt_sec_short;
	}
	public BigDecimal getR18_int_rate_long() {
		return r18_int_rate_long;
	}
	public void setR18_int_rate_long(BigDecimal r18_int_rate_long) {
		this.r18_int_rate_long = r18_int_rate_long;
	}
	public BigDecimal getR18_int_rate_short() {
		return r18_int_rate_short;
	}
	public void setR18_int_rate_short(BigDecimal r18_int_rate_short) {
		this.r18_int_rate_short = r18_int_rate_short;
	}
	public BigDecimal getR18_options_long() {
		return r18_options_long;
	}
	public void setR18_options_long(BigDecimal r18_options_long) {
		this.r18_options_long = r18_options_long;
	}
	public BigDecimal getR18_options_short() {
		return r18_options_short;
	}
	public void setR18_options_short(BigDecimal r18_options_short) {
		this.r18_options_short = r18_options_short;
	}
	public BigDecimal getR18_total_position_long() {
		return r18_total_position_long;
	}
	public void setR18_total_position_long(BigDecimal r18_total_position_long) {
		this.r18_total_position_long = r18_total_position_long;
	}
	public BigDecimal getR18_total_position_short() {
		return r18_total_position_short;
	}
	public void setR18_total_position_short(BigDecimal r18_total_position_short) {
		this.r18_total_position_short = r18_total_position_short;
	}
	public String getR18_risk_weight() {
		return r18_risk_weight;
	}
	public void setR18_risk_weight(String r18_risk_weight) {
		this.r18_risk_weight = r18_risk_weight;
	}
	public String getR18_weighted_positions_long() {
		return r18_weighted_positions_long;
	}
	public void setR18_weighted_positions_long(String r18_weighted_positions_long) {
		this.r18_weighted_positions_long = r18_weighted_positions_long;
	}
	public String getR18_weighted_positions_short() {
		return r18_weighted_positions_short;
	}
	public void setR18_weighted_positions_short(String r18_weighted_positions_short) {
		this.r18_weighted_positions_short = r18_weighted_positions_short;
	}
	public BigDecimal getR18_within_bands_zones_matched() {
		return r18_within_bands_zones_matched;
	}
	public void setR18_within_bands_zones_matched(BigDecimal r18_within_bands_zones_matched) {
		this.r18_within_bands_zones_matched = r18_within_bands_zones_matched;
	}
	public String getR18_within_bands_zones_unmatched() {
		return r18_within_bands_zones_unmatched;
	}
	public void setR18_within_bands_zones_unmatched(String r18_within_bands_zones_unmatched) {
		this.r18_within_bands_zones_unmatched = r18_within_bands_zones_unmatched;
	}
	public BigDecimal getR18_between_zones_matched() {
		return r18_between_zones_matched;
	}
	public void setR18_between_zones_matched(BigDecimal r18_between_zones_matched) {
		this.r18_between_zones_matched = r18_between_zones_matched;
	}
	public BigDecimal getR18_between_zones_unmatched() {
		return r18_between_zones_unmatched;
	}
	public void setR18_between_zones_unmatched(BigDecimal r18_between_zones_unmatched) {
		this.r18_between_zones_unmatched = r18_between_zones_unmatched;
	}
	public BigDecimal getR18_net_pos_cap_charge() {
		return r18_net_pos_cap_charge;
	}
	public void setR18_net_pos_cap_charge(BigDecimal r18_net_pos_cap_charge) {
		this.r18_net_pos_cap_charge = r18_net_pos_cap_charge;
	}
	public String getR18_risk_cap_charge() {
		return r18_risk_cap_charge;
	}
	public void setR18_risk_cap_charge(String r18_risk_cap_charge) {
		this.r18_risk_cap_charge = r18_risk_cap_charge;
	}
	public BigDecimal getR18_capital_charge() {
		return r18_capital_charge;
	}
	public void setR18_capital_charge(BigDecimal r18_capital_charge) {
		this.r18_capital_charge = r18_capital_charge;
	}
	public String getR19_product1() {
		return r19_product1;
	}
	public void setR19_product1(String r19_product1) {
		this.r19_product1 = r19_product1;
	}
	public String getR19_product2() {
		return r19_product2;
	}
	public void setR19_product2(String r19_product2) {
		this.r19_product2 = r19_product2;
	}
	public BigDecimal getR19_debt_sec_long() {
		return r19_debt_sec_long;
	}
	public void setR19_debt_sec_long(BigDecimal r19_debt_sec_long) {
		this.r19_debt_sec_long = r19_debt_sec_long;
	}
	public BigDecimal getR19_debt_sec_short() {
		return r19_debt_sec_short;
	}
	public void setR19_debt_sec_short(BigDecimal r19_debt_sec_short) {
		this.r19_debt_sec_short = r19_debt_sec_short;
	}
	public BigDecimal getR19_int_rate_long() {
		return r19_int_rate_long;
	}
	public void setR19_int_rate_long(BigDecimal r19_int_rate_long) {
		this.r19_int_rate_long = r19_int_rate_long;
	}
	public BigDecimal getR19_int_rate_short() {
		return r19_int_rate_short;
	}
	public void setR19_int_rate_short(BigDecimal r19_int_rate_short) {
		this.r19_int_rate_short = r19_int_rate_short;
	}
	public BigDecimal getR19_options_long() {
		return r19_options_long;
	}
	public void setR19_options_long(BigDecimal r19_options_long) {
		this.r19_options_long = r19_options_long;
	}
	public BigDecimal getR19_options_short() {
		return r19_options_short;
	}
	public void setR19_options_short(BigDecimal r19_options_short) {
		this.r19_options_short = r19_options_short;
	}
	public BigDecimal getR19_total_position_long() {
		return r19_total_position_long;
	}
	public void setR19_total_position_long(BigDecimal r19_total_position_long) {
		this.r19_total_position_long = r19_total_position_long;
	}
	public BigDecimal getR19_total_position_short() {
		return r19_total_position_short;
	}
	public void setR19_total_position_short(BigDecimal r19_total_position_short) {
		this.r19_total_position_short = r19_total_position_short;
	}
	public String getR19_risk_weight() {
		return r19_risk_weight;
	}
	public void setR19_risk_weight(String r19_risk_weight) {
		this.r19_risk_weight = r19_risk_weight;
	}
	public String getR19_weighted_positions_long() {
		return r19_weighted_positions_long;
	}
	public void setR19_weighted_positions_long(String r19_weighted_positions_long) {
		this.r19_weighted_positions_long = r19_weighted_positions_long;
	}
	public String getR19_weighted_positions_short() {
		return r19_weighted_positions_short;
	}
	public void setR19_weighted_positions_short(String r19_weighted_positions_short) {
		this.r19_weighted_positions_short = r19_weighted_positions_short;
	}
	public BigDecimal getR19_within_bands_zones_matched() {
		return r19_within_bands_zones_matched;
	}
	public void setR19_within_bands_zones_matched(BigDecimal r19_within_bands_zones_matched) {
		this.r19_within_bands_zones_matched = r19_within_bands_zones_matched;
	}
	public String getR19_within_bands_zones_unmatched() {
		return r19_within_bands_zones_unmatched;
	}
	public void setR19_within_bands_zones_unmatched(String r19_within_bands_zones_unmatched) {
		this.r19_within_bands_zones_unmatched = r19_within_bands_zones_unmatched;
	}
	public BigDecimal getR19_between_zones_matched() {
		return r19_between_zones_matched;
	}
	public void setR19_between_zones_matched(BigDecimal r19_between_zones_matched) {
		this.r19_between_zones_matched = r19_between_zones_matched;
	}
	public BigDecimal getR19_between_zones_unmatched() {
		return r19_between_zones_unmatched;
	}
	public void setR19_between_zones_unmatched(BigDecimal r19_between_zones_unmatched) {
		this.r19_between_zones_unmatched = r19_between_zones_unmatched;
	}
	public BigDecimal getR19_net_pos_cap_charge() {
		return r19_net_pos_cap_charge;
	}
	public void setR19_net_pos_cap_charge(BigDecimal r19_net_pos_cap_charge) {
		this.r19_net_pos_cap_charge = r19_net_pos_cap_charge;
	}
	public String getR19_risk_cap_charge() {
		return r19_risk_cap_charge;
	}
	public void setR19_risk_cap_charge(String r19_risk_cap_charge) {
		this.r19_risk_cap_charge = r19_risk_cap_charge;
	}
	public BigDecimal getR19_capital_charge() {
		return r19_capital_charge;
	}
	public void setR19_capital_charge(BigDecimal r19_capital_charge) {
		this.r19_capital_charge = r19_capital_charge;
	}
	public String getR20_product1() {
		return r20_product1;
	}
	public void setR20_product1(String r20_product1) {
		this.r20_product1 = r20_product1;
	}
	public String getR20_product2() {
		return r20_product2;
	}
	public void setR20_product2(String r20_product2) {
		this.r20_product2 = r20_product2;
	}
	public BigDecimal getR20_debt_sec_long() {
		return r20_debt_sec_long;
	}
	public void setR20_debt_sec_long(BigDecimal r20_debt_sec_long) {
		this.r20_debt_sec_long = r20_debt_sec_long;
	}
	public BigDecimal getR20_debt_sec_short() {
		return r20_debt_sec_short;
	}
	public void setR20_debt_sec_short(BigDecimal r20_debt_sec_short) {
		this.r20_debt_sec_short = r20_debt_sec_short;
	}
	public BigDecimal getR20_int_rate_long() {
		return r20_int_rate_long;
	}
	public void setR20_int_rate_long(BigDecimal r20_int_rate_long) {
		this.r20_int_rate_long = r20_int_rate_long;
	}
	public BigDecimal getR20_int_rate_short() {
		return r20_int_rate_short;
	}
	public void setR20_int_rate_short(BigDecimal r20_int_rate_short) {
		this.r20_int_rate_short = r20_int_rate_short;
	}
	public BigDecimal getR20_options_long() {
		return r20_options_long;
	}
	public void setR20_options_long(BigDecimal r20_options_long) {
		this.r20_options_long = r20_options_long;
	}
	public BigDecimal getR20_options_short() {
		return r20_options_short;
	}
	public void setR20_options_short(BigDecimal r20_options_short) {
		this.r20_options_short = r20_options_short;
	}
	public BigDecimal getR20_total_position_long() {
		return r20_total_position_long;
	}
	public void setR20_total_position_long(BigDecimal r20_total_position_long) {
		this.r20_total_position_long = r20_total_position_long;
	}
	public BigDecimal getR20_total_position_short() {
		return r20_total_position_short;
	}
	public void setR20_total_position_short(BigDecimal r20_total_position_short) {
		this.r20_total_position_short = r20_total_position_short;
	}
	public String getR20_risk_weight() {
		return r20_risk_weight;
	}
	public void setR20_risk_weight(String r20_risk_weight) {
		this.r20_risk_weight = r20_risk_weight;
	}
	public String getR20_weighted_positions_long() {
		return r20_weighted_positions_long;
	}
	public void setR20_weighted_positions_long(String r20_weighted_positions_long) {
		this.r20_weighted_positions_long = r20_weighted_positions_long;
	}
	public String getR20_weighted_positions_short() {
		return r20_weighted_positions_short;
	}
	public void setR20_weighted_positions_short(String r20_weighted_positions_short) {
		this.r20_weighted_positions_short = r20_weighted_positions_short;
	}
	public BigDecimal getR20_within_bands_zones_matched() {
		return r20_within_bands_zones_matched;
	}
	public void setR20_within_bands_zones_matched(BigDecimal r20_within_bands_zones_matched) {
		this.r20_within_bands_zones_matched = r20_within_bands_zones_matched;
	}
	public String getR20_within_bands_zones_unmatched() {
		return r20_within_bands_zones_unmatched;
	}
	public void setR20_within_bands_zones_unmatched(String r20_within_bands_zones_unmatched) {
		this.r20_within_bands_zones_unmatched = r20_within_bands_zones_unmatched;
	}
	public BigDecimal getR20_between_zones_matched() {
		return r20_between_zones_matched;
	}
	public void setR20_between_zones_matched(BigDecimal r20_between_zones_matched) {
		this.r20_between_zones_matched = r20_between_zones_matched;
	}
	public BigDecimal getR20_between_zones_unmatched() {
		return r20_between_zones_unmatched;
	}
	public void setR20_between_zones_unmatched(BigDecimal r20_between_zones_unmatched) {
		this.r20_between_zones_unmatched = r20_between_zones_unmatched;
	}
	public BigDecimal getR20_net_pos_cap_charge() {
		return r20_net_pos_cap_charge;
	}
	public void setR20_net_pos_cap_charge(BigDecimal r20_net_pos_cap_charge) {
		this.r20_net_pos_cap_charge = r20_net_pos_cap_charge;
	}
	public String getR20_risk_cap_charge() {
		return r20_risk_cap_charge;
	}
	public void setR20_risk_cap_charge(String r20_risk_cap_charge) {
		this.r20_risk_cap_charge = r20_risk_cap_charge;
	}
	public BigDecimal getR20_capital_charge() {
		return r20_capital_charge;
	}
	public void setR20_capital_charge(BigDecimal r20_capital_charge) {
		this.r20_capital_charge = r20_capital_charge;
	}
	public String getR21_product1() {
		return r21_product1;
	}
	public void setR21_product1(String r21_product1) {
		this.r21_product1 = r21_product1;
	}
	public String getR21_product2() {
		return r21_product2;
	}
	public void setR21_product2(String r21_product2) {
		this.r21_product2 = r21_product2;
	}
	public BigDecimal getR21_debt_sec_long() {
		return r21_debt_sec_long;
	}
	public void setR21_debt_sec_long(BigDecimal r21_debt_sec_long) {
		this.r21_debt_sec_long = r21_debt_sec_long;
	}
	public BigDecimal getR21_debt_sec_short() {
		return r21_debt_sec_short;
	}
	public void setR21_debt_sec_short(BigDecimal r21_debt_sec_short) {
		this.r21_debt_sec_short = r21_debt_sec_short;
	}
	public BigDecimal getR21_int_rate_long() {
		return r21_int_rate_long;
	}
	public void setR21_int_rate_long(BigDecimal r21_int_rate_long) {
		this.r21_int_rate_long = r21_int_rate_long;
	}
	public BigDecimal getR21_int_rate_short() {
		return r21_int_rate_short;
	}
	public void setR21_int_rate_short(BigDecimal r21_int_rate_short) {
		this.r21_int_rate_short = r21_int_rate_short;
	}
	public BigDecimal getR21_options_long() {
		return r21_options_long;
	}
	public void setR21_options_long(BigDecimal r21_options_long) {
		this.r21_options_long = r21_options_long;
	}
	public BigDecimal getR21_options_short() {
		return r21_options_short;
	}
	public void setR21_options_short(BigDecimal r21_options_short) {
		this.r21_options_short = r21_options_short;
	}
	public BigDecimal getR21_total_position_long() {
		return r21_total_position_long;
	}
	public void setR21_total_position_long(BigDecimal r21_total_position_long) {
		this.r21_total_position_long = r21_total_position_long;
	}
	public BigDecimal getR21_total_position_short() {
		return r21_total_position_short;
	}
	public void setR21_total_position_short(BigDecimal r21_total_position_short) {
		this.r21_total_position_short = r21_total_position_short;
	}
	public String getR21_risk_weight() {
		return r21_risk_weight;
	}
	public void setR21_risk_weight(String r21_risk_weight) {
		this.r21_risk_weight = r21_risk_weight;
	}
	public String getR21_weighted_positions_long() {
		return r21_weighted_positions_long;
	}
	public void setR21_weighted_positions_long(String r21_weighted_positions_long) {
		this.r21_weighted_positions_long = r21_weighted_positions_long;
	}
	public String getR21_weighted_positions_short() {
		return r21_weighted_positions_short;
	}
	public void setR21_weighted_positions_short(String r21_weighted_positions_short) {
		this.r21_weighted_positions_short = r21_weighted_positions_short;
	}
	public BigDecimal getR21_within_bands_zones_matched() {
		return r21_within_bands_zones_matched;
	}
	public void setR21_within_bands_zones_matched(BigDecimal r21_within_bands_zones_matched) {
		this.r21_within_bands_zones_matched = r21_within_bands_zones_matched;
	}
	public String getR21_within_bands_zones_unmatched() {
		return r21_within_bands_zones_unmatched;
	}
	public void setR21_within_bands_zones_unmatched(String r21_within_bands_zones_unmatched) {
		this.r21_within_bands_zones_unmatched = r21_within_bands_zones_unmatched;
	}
	public BigDecimal getR21_between_zones_matched() {
		return r21_between_zones_matched;
	}
	public void setR21_between_zones_matched(BigDecimal r21_between_zones_matched) {
		this.r21_between_zones_matched = r21_between_zones_matched;
	}
	public BigDecimal getR21_between_zones_unmatched() {
		return r21_between_zones_unmatched;
	}
	public void setR21_between_zones_unmatched(BigDecimal r21_between_zones_unmatched) {
		this.r21_between_zones_unmatched = r21_between_zones_unmatched;
	}
	public BigDecimal getR21_net_pos_cap_charge() {
		return r21_net_pos_cap_charge;
	}
	public void setR21_net_pos_cap_charge(BigDecimal r21_net_pos_cap_charge) {
		this.r21_net_pos_cap_charge = r21_net_pos_cap_charge;
	}
	public String getR21_risk_cap_charge() {
		return r21_risk_cap_charge;
	}
	public void setR21_risk_cap_charge(String r21_risk_cap_charge) {
		this.r21_risk_cap_charge = r21_risk_cap_charge;
	}
	public BigDecimal getR21_capital_charge() {
		return r21_capital_charge;
	}
	public void setR21_capital_charge(BigDecimal r21_capital_charge) {
		this.r21_capital_charge = r21_capital_charge;
	}
	public String getR22_product1() {
		return r22_product1;
	}
	public void setR22_product1(String r22_product1) {
		this.r22_product1 = r22_product1;
	}
	public String getR22_product2() {
		return r22_product2;
	}
	public void setR22_product2(String r22_product2) {
		this.r22_product2 = r22_product2;
	}
	public BigDecimal getR22_debt_sec_long() {
		return r22_debt_sec_long;
	}
	public void setR22_debt_sec_long(BigDecimal r22_debt_sec_long) {
		this.r22_debt_sec_long = r22_debt_sec_long;
	}
	public BigDecimal getR22_debt_sec_short() {
		return r22_debt_sec_short;
	}
	public void setR22_debt_sec_short(BigDecimal r22_debt_sec_short) {
		this.r22_debt_sec_short = r22_debt_sec_short;
	}
	public BigDecimal getR22_int_rate_long() {
		return r22_int_rate_long;
	}
	public void setR22_int_rate_long(BigDecimal r22_int_rate_long) {
		this.r22_int_rate_long = r22_int_rate_long;
	}
	public BigDecimal getR22_int_rate_short() {
		return r22_int_rate_short;
	}
	public void setR22_int_rate_short(BigDecimal r22_int_rate_short) {
		this.r22_int_rate_short = r22_int_rate_short;
	}
	public BigDecimal getR22_options_long() {
		return r22_options_long;
	}
	public void setR22_options_long(BigDecimal r22_options_long) {
		this.r22_options_long = r22_options_long;
	}
	public BigDecimal getR22_options_short() {
		return r22_options_short;
	}
	public void setR22_options_short(BigDecimal r22_options_short) {
		this.r22_options_short = r22_options_short;
	}
	public BigDecimal getR22_total_position_long() {
		return r22_total_position_long;
	}
	public void setR22_total_position_long(BigDecimal r22_total_position_long) {
		this.r22_total_position_long = r22_total_position_long;
	}
	public BigDecimal getR22_total_position_short() {
		return r22_total_position_short;
	}
	public void setR22_total_position_short(BigDecimal r22_total_position_short) {
		this.r22_total_position_short = r22_total_position_short;
	}
	public String getR22_risk_weight() {
		return r22_risk_weight;
	}
	public void setR22_risk_weight(String r22_risk_weight) {
		this.r22_risk_weight = r22_risk_weight;
	}
	public String getR22_weighted_positions_long() {
		return r22_weighted_positions_long;
	}
	public void setR22_weighted_positions_long(String r22_weighted_positions_long) {
		this.r22_weighted_positions_long = r22_weighted_positions_long;
	}
	public String getR22_weighted_positions_short() {
		return r22_weighted_positions_short;
	}
	public void setR22_weighted_positions_short(String r22_weighted_positions_short) {
		this.r22_weighted_positions_short = r22_weighted_positions_short;
	}
	public BigDecimal getR22_within_bands_zones_matched() {
		return r22_within_bands_zones_matched;
	}
	public void setR22_within_bands_zones_matched(BigDecimal r22_within_bands_zones_matched) {
		this.r22_within_bands_zones_matched = r22_within_bands_zones_matched;
	}
	public String getR22_within_bands_zones_unmatched() {
		return r22_within_bands_zones_unmatched;
	}
	public void setR22_within_bands_zones_unmatched(String r22_within_bands_zones_unmatched) {
		this.r22_within_bands_zones_unmatched = r22_within_bands_zones_unmatched;
	}
	public BigDecimal getR22_between_zones_matched() {
		return r22_between_zones_matched;
	}
	public void setR22_between_zones_matched(BigDecimal r22_between_zones_matched) {
		this.r22_between_zones_matched = r22_between_zones_matched;
	}
	public BigDecimal getR22_between_zones_unmatched() {
		return r22_between_zones_unmatched;
	}
	public void setR22_between_zones_unmatched(BigDecimal r22_between_zones_unmatched) {
		this.r22_between_zones_unmatched = r22_between_zones_unmatched;
	}
	public BigDecimal getR22_net_pos_cap_charge() {
		return r22_net_pos_cap_charge;
	}
	public void setR22_net_pos_cap_charge(BigDecimal r22_net_pos_cap_charge) {
		this.r22_net_pos_cap_charge = r22_net_pos_cap_charge;
	}
	public String getR22_risk_cap_charge() {
		return r22_risk_cap_charge;
	}
	public void setR22_risk_cap_charge(String r22_risk_cap_charge) {
		this.r22_risk_cap_charge = r22_risk_cap_charge;
	}
	public BigDecimal getR22_capital_charge() {
		return r22_capital_charge;
	}
	public void setR22_capital_charge(BigDecimal r22_capital_charge) {
		this.r22_capital_charge = r22_capital_charge;
	}
	public String getR23_product1() {
		return r23_product1;
	}
	public void setR23_product1(String r23_product1) {
		this.r23_product1 = r23_product1;
	}
	public String getR23_product2() {
		return r23_product2;
	}
	public void setR23_product2(String r23_product2) {
		this.r23_product2 = r23_product2;
	}
	public BigDecimal getR23_debt_sec_long() {
		return r23_debt_sec_long;
	}
	public void setR23_debt_sec_long(BigDecimal r23_debt_sec_long) {
		this.r23_debt_sec_long = r23_debt_sec_long;
	}
	public BigDecimal getR23_debt_sec_short() {
		return r23_debt_sec_short;
	}
	public void setR23_debt_sec_short(BigDecimal r23_debt_sec_short) {
		this.r23_debt_sec_short = r23_debt_sec_short;
	}
	public BigDecimal getR23_int_rate_long() {
		return r23_int_rate_long;
	}
	public void setR23_int_rate_long(BigDecimal r23_int_rate_long) {
		this.r23_int_rate_long = r23_int_rate_long;
	}
	public BigDecimal getR23_int_rate_short() {
		return r23_int_rate_short;
	}
	public void setR23_int_rate_short(BigDecimal r23_int_rate_short) {
		this.r23_int_rate_short = r23_int_rate_short;
	}
	public BigDecimal getR23_options_long() {
		return r23_options_long;
	}
	public void setR23_options_long(BigDecimal r23_options_long) {
		this.r23_options_long = r23_options_long;
	}
	public BigDecimal getR23_options_short() {
		return r23_options_short;
	}
	public void setR23_options_short(BigDecimal r23_options_short) {
		this.r23_options_short = r23_options_short;
	}
	public BigDecimal getR23_total_position_long() {
		return r23_total_position_long;
	}
	public void setR23_total_position_long(BigDecimal r23_total_position_long) {
		this.r23_total_position_long = r23_total_position_long;
	}
	public BigDecimal getR23_total_position_short() {
		return r23_total_position_short;
	}
	public void setR23_total_position_short(BigDecimal r23_total_position_short) {
		this.r23_total_position_short = r23_total_position_short;
	}
	public String getR23_risk_weight() {
		return r23_risk_weight;
	}
	public void setR23_risk_weight(String r23_risk_weight) {
		this.r23_risk_weight = r23_risk_weight;
	}
	public String getR23_weighted_positions_long() {
		return r23_weighted_positions_long;
	}
	public void setR23_weighted_positions_long(String r23_weighted_positions_long) {
		this.r23_weighted_positions_long = r23_weighted_positions_long;
	}
	public String getR23_weighted_positions_short() {
		return r23_weighted_positions_short;
	}
	public void setR23_weighted_positions_short(String r23_weighted_positions_short) {
		this.r23_weighted_positions_short = r23_weighted_positions_short;
	}
	public BigDecimal getR23_within_bands_zones_matched() {
		return r23_within_bands_zones_matched;
	}
	public void setR23_within_bands_zones_matched(BigDecimal r23_within_bands_zones_matched) {
		this.r23_within_bands_zones_matched = r23_within_bands_zones_matched;
	}
	public String getR23_within_bands_zones_unmatched() {
		return r23_within_bands_zones_unmatched;
	}
	public void setR23_within_bands_zones_unmatched(String r23_within_bands_zones_unmatched) {
		this.r23_within_bands_zones_unmatched = r23_within_bands_zones_unmatched;
	}
	public BigDecimal getR23_between_zones_matched() {
		return r23_between_zones_matched;
	}
	public void setR23_between_zones_matched(BigDecimal r23_between_zones_matched) {
		this.r23_between_zones_matched = r23_between_zones_matched;
	}
	public BigDecimal getR23_between_zones_unmatched() {
		return r23_between_zones_unmatched;
	}
	public void setR23_between_zones_unmatched(BigDecimal r23_between_zones_unmatched) {
		this.r23_between_zones_unmatched = r23_between_zones_unmatched;
	}
	public BigDecimal getR23_net_pos_cap_charge() {
		return r23_net_pos_cap_charge;
	}
	public void setR23_net_pos_cap_charge(BigDecimal r23_net_pos_cap_charge) {
		this.r23_net_pos_cap_charge = r23_net_pos_cap_charge;
	}
	public String getR23_risk_cap_charge() {
		return r23_risk_cap_charge;
	}
	public void setR23_risk_cap_charge(String r23_risk_cap_charge) {
		this.r23_risk_cap_charge = r23_risk_cap_charge;
	}
	public BigDecimal getR23_capital_charge() {
		return r23_capital_charge;
	}
	public void setR23_capital_charge(BigDecimal r23_capital_charge) {
		this.r23_capital_charge = r23_capital_charge;
	}
	public String getR24_product1() {
		return r24_product1;
	}
	public void setR24_product1(String r24_product1) {
		this.r24_product1 = r24_product1;
	}
	public String getR24_product2() {
		return r24_product2;
	}
	public void setR24_product2(String r24_product2) {
		this.r24_product2 = r24_product2;
	}
	public BigDecimal getR24_debt_sec_long() {
		return r24_debt_sec_long;
	}
	public void setR24_debt_sec_long(BigDecimal r24_debt_sec_long) {
		this.r24_debt_sec_long = r24_debt_sec_long;
	}
	public BigDecimal getR24_debt_sec_short() {
		return r24_debt_sec_short;
	}
	public void setR24_debt_sec_short(BigDecimal r24_debt_sec_short) {
		this.r24_debt_sec_short = r24_debt_sec_short;
	}
	public BigDecimal getR24_int_rate_long() {
		return r24_int_rate_long;
	}
	public void setR24_int_rate_long(BigDecimal r24_int_rate_long) {
		this.r24_int_rate_long = r24_int_rate_long;
	}
	public BigDecimal getR24_int_rate_short() {
		return r24_int_rate_short;
	}
	public void setR24_int_rate_short(BigDecimal r24_int_rate_short) {
		this.r24_int_rate_short = r24_int_rate_short;
	}
	public BigDecimal getR24_options_long() {
		return r24_options_long;
	}
	public void setR24_options_long(BigDecimal r24_options_long) {
		this.r24_options_long = r24_options_long;
	}
	public BigDecimal getR24_options_short() {
		return r24_options_short;
	}
	public void setR24_options_short(BigDecimal r24_options_short) {
		this.r24_options_short = r24_options_short;
	}
	public BigDecimal getR24_total_position_long() {
		return r24_total_position_long;
	}
	public void setR24_total_position_long(BigDecimal r24_total_position_long) {
		this.r24_total_position_long = r24_total_position_long;
	}
	public BigDecimal getR24_total_position_short() {
		return r24_total_position_short;
	}
	public void setR24_total_position_short(BigDecimal r24_total_position_short) {
		this.r24_total_position_short = r24_total_position_short;
	}
	public String getR24_risk_weight() {
		return r24_risk_weight;
	}
	public void setR24_risk_weight(String r24_risk_weight) {
		this.r24_risk_weight = r24_risk_weight;
	}
	public String getR24_weighted_positions_long() {
		return r24_weighted_positions_long;
	}
	public void setR24_weighted_positions_long(String r24_weighted_positions_long) {
		this.r24_weighted_positions_long = r24_weighted_positions_long;
	}
	public String getR24_weighted_positions_short() {
		return r24_weighted_positions_short;
	}
	public void setR24_weighted_positions_short(String r24_weighted_positions_short) {
		this.r24_weighted_positions_short = r24_weighted_positions_short;
	}
	public BigDecimal getR24_within_bands_zones_matched() {
		return r24_within_bands_zones_matched;
	}
	public void setR24_within_bands_zones_matched(BigDecimal r24_within_bands_zones_matched) {
		this.r24_within_bands_zones_matched = r24_within_bands_zones_matched;
	}
	public String getR24_within_bands_zones_unmatched() {
		return r24_within_bands_zones_unmatched;
	}
	public void setR24_within_bands_zones_unmatched(String r24_within_bands_zones_unmatched) {
		this.r24_within_bands_zones_unmatched = r24_within_bands_zones_unmatched;
	}
	public BigDecimal getR24_between_zones_matched() {
		return r24_between_zones_matched;
	}
	public void setR24_between_zones_matched(BigDecimal r24_between_zones_matched) {
		this.r24_between_zones_matched = r24_between_zones_matched;
	}
	public BigDecimal getR24_between_zones_unmatched() {
		return r24_between_zones_unmatched;
	}
	public void setR24_between_zones_unmatched(BigDecimal r24_between_zones_unmatched) {
		this.r24_between_zones_unmatched = r24_between_zones_unmatched;
	}
	public BigDecimal getR24_net_pos_cap_charge() {
		return r24_net_pos_cap_charge;
	}
	public void setR24_net_pos_cap_charge(BigDecimal r24_net_pos_cap_charge) {
		this.r24_net_pos_cap_charge = r24_net_pos_cap_charge;
	}
	public String getR24_risk_cap_charge() {
		return r24_risk_cap_charge;
	}
	public void setR24_risk_cap_charge(String r24_risk_cap_charge) {
		this.r24_risk_cap_charge = r24_risk_cap_charge;
	}
	public BigDecimal getR24_capital_charge() {
		return r24_capital_charge;
	}
	public void setR24_capital_charge(BigDecimal r24_capital_charge) {
		this.r24_capital_charge = r24_capital_charge;
	}
	public String getR25_product1() {
		return r25_product1;
	}
	public void setR25_product1(String r25_product1) {
		this.r25_product1 = r25_product1;
	}
	public String getR25_product2() {
		return r25_product2;
	}
	public void setR25_product2(String r25_product2) {
		this.r25_product2 = r25_product2;
	}
	public BigDecimal getR25_debt_sec_long() {
		return r25_debt_sec_long;
	}
	public void setR25_debt_sec_long(BigDecimal r25_debt_sec_long) {
		this.r25_debt_sec_long = r25_debt_sec_long;
	}
	public BigDecimal getR25_debt_sec_short() {
		return r25_debt_sec_short;
	}
	public void setR25_debt_sec_short(BigDecimal r25_debt_sec_short) {
		this.r25_debt_sec_short = r25_debt_sec_short;
	}
	public BigDecimal getR25_int_rate_long() {
		return r25_int_rate_long;
	}
	public void setR25_int_rate_long(BigDecimal r25_int_rate_long) {
		this.r25_int_rate_long = r25_int_rate_long;
	}
	public BigDecimal getR25_int_rate_short() {
		return r25_int_rate_short;
	}
	public void setR25_int_rate_short(BigDecimal r25_int_rate_short) {
		this.r25_int_rate_short = r25_int_rate_short;
	}
	public BigDecimal getR25_options_long() {
		return r25_options_long;
	}
	public void setR25_options_long(BigDecimal r25_options_long) {
		this.r25_options_long = r25_options_long;
	}
	public BigDecimal getR25_options_short() {
		return r25_options_short;
	}
	public void setR25_options_short(BigDecimal r25_options_short) {
		this.r25_options_short = r25_options_short;
	}
	public BigDecimal getR25_total_position_long() {
		return r25_total_position_long;
	}
	public void setR25_total_position_long(BigDecimal r25_total_position_long) {
		this.r25_total_position_long = r25_total_position_long;
	}
	public BigDecimal getR25_total_position_short() {
		return r25_total_position_short;
	}
	public void setR25_total_position_short(BigDecimal r25_total_position_short) {
		this.r25_total_position_short = r25_total_position_short;
	}
	public String getR25_risk_weight() {
		return r25_risk_weight;
	}
	public void setR25_risk_weight(String r25_risk_weight) {
		this.r25_risk_weight = r25_risk_weight;
	}
	public String getR25_weighted_positions_long() {
		return r25_weighted_positions_long;
	}
	public void setR25_weighted_positions_long(String r25_weighted_positions_long) {
		this.r25_weighted_positions_long = r25_weighted_positions_long;
	}
	public String getR25_weighted_positions_short() {
		return r25_weighted_positions_short;
	}
	public void setR25_weighted_positions_short(String r25_weighted_positions_short) {
		this.r25_weighted_positions_short = r25_weighted_positions_short;
	}
	public BigDecimal getR25_within_bands_zones_matched() {
		return r25_within_bands_zones_matched;
	}
	public void setR25_within_bands_zones_matched(BigDecimal r25_within_bands_zones_matched) {
		this.r25_within_bands_zones_matched = r25_within_bands_zones_matched;
	}
	public String getR25_within_bands_zones_unmatched() {
		return r25_within_bands_zones_unmatched;
	}
	public void setR25_within_bands_zones_unmatched(String r25_within_bands_zones_unmatched) {
		this.r25_within_bands_zones_unmatched = r25_within_bands_zones_unmatched;
	}
	public BigDecimal getR25_between_zones_matched() {
		return r25_between_zones_matched;
	}
	public void setR25_between_zones_matched(BigDecimal r25_between_zones_matched) {
		this.r25_between_zones_matched = r25_between_zones_matched;
	}
	public BigDecimal getR25_between_zones_unmatched() {
		return r25_between_zones_unmatched;
	}
	public void setR25_between_zones_unmatched(BigDecimal r25_between_zones_unmatched) {
		this.r25_between_zones_unmatched = r25_between_zones_unmatched;
	}
	public BigDecimal getR25_net_pos_cap_charge() {
		return r25_net_pos_cap_charge;
	}
	public void setR25_net_pos_cap_charge(BigDecimal r25_net_pos_cap_charge) {
		this.r25_net_pos_cap_charge = r25_net_pos_cap_charge;
	}
	public String getR25_risk_cap_charge() {
		return r25_risk_cap_charge;
	}
	public void setR25_risk_cap_charge(String r25_risk_cap_charge) {
		this.r25_risk_cap_charge = r25_risk_cap_charge;
	}
	public BigDecimal getR25_capital_charge() {
		return r25_capital_charge;
	}
	public void setR25_capital_charge(BigDecimal r25_capital_charge) {
		this.r25_capital_charge = r25_capital_charge;
	}
	public String getR26_product1() {
		return r26_product1;
	}
	public void setR26_product1(String r26_product1) {
		this.r26_product1 = r26_product1;
	}
	public String getR26_product2() {
		return r26_product2;
	}
	public void setR26_product2(String r26_product2) {
		this.r26_product2 = r26_product2;
	}
	public BigDecimal getR26_debt_sec_long() {
		return r26_debt_sec_long;
	}
	public void setR26_debt_sec_long(BigDecimal r26_debt_sec_long) {
		this.r26_debt_sec_long = r26_debt_sec_long;
	}
	public BigDecimal getR26_debt_sec_short() {
		return r26_debt_sec_short;
	}
	public void setR26_debt_sec_short(BigDecimal r26_debt_sec_short) {
		this.r26_debt_sec_short = r26_debt_sec_short;
	}
	public BigDecimal getR26_int_rate_long() {
		return r26_int_rate_long;
	}
	public void setR26_int_rate_long(BigDecimal r26_int_rate_long) {
		this.r26_int_rate_long = r26_int_rate_long;
	}
	public BigDecimal getR26_int_rate_short() {
		return r26_int_rate_short;
	}
	public void setR26_int_rate_short(BigDecimal r26_int_rate_short) {
		this.r26_int_rate_short = r26_int_rate_short;
	}
	public BigDecimal getR26_options_long() {
		return r26_options_long;
	}
	public void setR26_options_long(BigDecimal r26_options_long) {
		this.r26_options_long = r26_options_long;
	}
	public BigDecimal getR26_options_short() {
		return r26_options_short;
	}
	public void setR26_options_short(BigDecimal r26_options_short) {
		this.r26_options_short = r26_options_short;
	}
	public BigDecimal getR26_total_position_long() {
		return r26_total_position_long;
	}
	public void setR26_total_position_long(BigDecimal r26_total_position_long) {
		this.r26_total_position_long = r26_total_position_long;
	}
	public BigDecimal getR26_total_position_short() {
		return r26_total_position_short;
	}
	public void setR26_total_position_short(BigDecimal r26_total_position_short) {
		this.r26_total_position_short = r26_total_position_short;
	}
	public String getR26_risk_weight() {
		return r26_risk_weight;
	}
	public void setR26_risk_weight(String r26_risk_weight) {
		this.r26_risk_weight = r26_risk_weight;
	}
	public String getR26_weighted_positions_long() {
		return r26_weighted_positions_long;
	}
	public void setR26_weighted_positions_long(String r26_weighted_positions_long) {
		this.r26_weighted_positions_long = r26_weighted_positions_long;
	}
	public String getR26_weighted_positions_short() {
		return r26_weighted_positions_short;
	}
	public void setR26_weighted_positions_short(String r26_weighted_positions_short) {
		this.r26_weighted_positions_short = r26_weighted_positions_short;
	}
	public BigDecimal getR26_within_bands_zones_matched() {
		return r26_within_bands_zones_matched;
	}
	public void setR26_within_bands_zones_matched(BigDecimal r26_within_bands_zones_matched) {
		this.r26_within_bands_zones_matched = r26_within_bands_zones_matched;
	}
	public String getR26_within_bands_zones_unmatched() {
		return r26_within_bands_zones_unmatched;
	}
	public void setR26_within_bands_zones_unmatched(String r26_within_bands_zones_unmatched) {
		this.r26_within_bands_zones_unmatched = r26_within_bands_zones_unmatched;
	}
	public BigDecimal getR26_between_zones_matched() {
		return r26_between_zones_matched;
	}
	public void setR26_between_zones_matched(BigDecimal r26_between_zones_matched) {
		this.r26_between_zones_matched = r26_between_zones_matched;
	}
	public BigDecimal getR26_between_zones_unmatched() {
		return r26_between_zones_unmatched;
	}
	public void setR26_between_zones_unmatched(BigDecimal r26_between_zones_unmatched) {
		this.r26_between_zones_unmatched = r26_between_zones_unmatched;
	}
	public BigDecimal getR26_net_pos_cap_charge() {
		return r26_net_pos_cap_charge;
	}
	public void setR26_net_pos_cap_charge(BigDecimal r26_net_pos_cap_charge) {
		this.r26_net_pos_cap_charge = r26_net_pos_cap_charge;
	}
	public String getR26_risk_cap_charge() {
		return r26_risk_cap_charge;
	}
	public void setR26_risk_cap_charge(String r26_risk_cap_charge) {
		this.r26_risk_cap_charge = r26_risk_cap_charge;
	}
	public BigDecimal getR26_capital_charge() {
		return r26_capital_charge;
	}
	public void setR26_capital_charge(BigDecimal r26_capital_charge) {
		this.r26_capital_charge = r26_capital_charge;
	}
	public String getR27_product1() {
		return r27_product1;
	}
	public void setR27_product1(String r27_product1) {
		this.r27_product1 = r27_product1;
	}
	public String getR27_product2() {
		return r27_product2;
	}
	public void setR27_product2(String r27_product2) {
		this.r27_product2 = r27_product2;
	}
	public BigDecimal getR27_debt_sec_long() {
		return r27_debt_sec_long;
	}
	public void setR27_debt_sec_long(BigDecimal r27_debt_sec_long) {
		this.r27_debt_sec_long = r27_debt_sec_long;
	}
	public BigDecimal getR27_debt_sec_short() {
		return r27_debt_sec_short;
	}
	public void setR27_debt_sec_short(BigDecimal r27_debt_sec_short) {
		this.r27_debt_sec_short = r27_debt_sec_short;
	}
	public BigDecimal getR27_int_rate_long() {
		return r27_int_rate_long;
	}
	public void setR27_int_rate_long(BigDecimal r27_int_rate_long) {
		this.r27_int_rate_long = r27_int_rate_long;
	}
	public BigDecimal getR27_int_rate_short() {
		return r27_int_rate_short;
	}
	public void setR27_int_rate_short(BigDecimal r27_int_rate_short) {
		this.r27_int_rate_short = r27_int_rate_short;
	}
	public BigDecimal getR27_options_long() {
		return r27_options_long;
	}
	public void setR27_options_long(BigDecimal r27_options_long) {
		this.r27_options_long = r27_options_long;
	}
	public BigDecimal getR27_options_short() {
		return r27_options_short;
	}
	public void setR27_options_short(BigDecimal r27_options_short) {
		this.r27_options_short = r27_options_short;
	}
	public BigDecimal getR27_total_position_long() {
		return r27_total_position_long;
	}
	public void setR27_total_position_long(BigDecimal r27_total_position_long) {
		this.r27_total_position_long = r27_total_position_long;
	}
	public BigDecimal getR27_total_position_short() {
		return r27_total_position_short;
	}
	public void setR27_total_position_short(BigDecimal r27_total_position_short) {
		this.r27_total_position_short = r27_total_position_short;
	}
	public String getR27_risk_weight() {
		return r27_risk_weight;
	}
	public void setR27_risk_weight(String r27_risk_weight) {
		this.r27_risk_weight = r27_risk_weight;
	}
	public String getR27_weighted_positions_long() {
		return r27_weighted_positions_long;
	}
	public void setR27_weighted_positions_long(String r27_weighted_positions_long) {
		this.r27_weighted_positions_long = r27_weighted_positions_long;
	}
	public String getR27_weighted_positions_short() {
		return r27_weighted_positions_short;
	}
	public void setR27_weighted_positions_short(String r27_weighted_positions_short) {
		this.r27_weighted_positions_short = r27_weighted_positions_short;
	}
	public BigDecimal getR27_within_bands_zones_matched() {
		return r27_within_bands_zones_matched;
	}
	public void setR27_within_bands_zones_matched(BigDecimal r27_within_bands_zones_matched) {
		this.r27_within_bands_zones_matched = r27_within_bands_zones_matched;
	}
	public String getR27_within_bands_zones_unmatched() {
		return r27_within_bands_zones_unmatched;
	}
	public void setR27_within_bands_zones_unmatched(String r27_within_bands_zones_unmatched) {
		this.r27_within_bands_zones_unmatched = r27_within_bands_zones_unmatched;
	}
	public BigDecimal getR27_between_zones_matched() {
		return r27_between_zones_matched;
	}
	public void setR27_between_zones_matched(BigDecimal r27_between_zones_matched) {
		this.r27_between_zones_matched = r27_between_zones_matched;
	}
	public BigDecimal getR27_between_zones_unmatched() {
		return r27_between_zones_unmatched;
	}
	public void setR27_between_zones_unmatched(BigDecimal r27_between_zones_unmatched) {
		this.r27_between_zones_unmatched = r27_between_zones_unmatched;
	}
	public BigDecimal getR27_net_pos_cap_charge() {
		return r27_net_pos_cap_charge;
	}
	public void setR27_net_pos_cap_charge(BigDecimal r27_net_pos_cap_charge) {
		this.r27_net_pos_cap_charge = r27_net_pos_cap_charge;
	}
	public String getR27_risk_cap_charge() {
		return r27_risk_cap_charge;
	}
	public void setR27_risk_cap_charge(String r27_risk_cap_charge) {
		this.r27_risk_cap_charge = r27_risk_cap_charge;
	}
	public BigDecimal getR27_capital_charge() {
		return r27_capital_charge;
	}
	public void setR27_capital_charge(BigDecimal r27_capital_charge) {
		this.r27_capital_charge = r27_capital_charge;
	}
	public String getR28_product1() {
		return r28_product1;
	}
	public void setR28_product1(String r28_product1) {
		this.r28_product1 = r28_product1;
	}
	public String getR28_product2() {
		return r28_product2;
	}
	public void setR28_product2(String r28_product2) {
		this.r28_product2 = r28_product2;
	}
	public BigDecimal getR28_debt_sec_long() {
		return r28_debt_sec_long;
	}
	public void setR28_debt_sec_long(BigDecimal r28_debt_sec_long) {
		this.r28_debt_sec_long = r28_debt_sec_long;
	}
	public BigDecimal getR28_debt_sec_short() {
		return r28_debt_sec_short;
	}
	public void setR28_debt_sec_short(BigDecimal r28_debt_sec_short) {
		this.r28_debt_sec_short = r28_debt_sec_short;
	}
	public BigDecimal getR28_int_rate_long() {
		return r28_int_rate_long;
	}
	public void setR28_int_rate_long(BigDecimal r28_int_rate_long) {
		this.r28_int_rate_long = r28_int_rate_long;
	}
	public BigDecimal getR28_int_rate_short() {
		return r28_int_rate_short;
	}
	public void setR28_int_rate_short(BigDecimal r28_int_rate_short) {
		this.r28_int_rate_short = r28_int_rate_short;
	}
	public BigDecimal getR28_options_long() {
		return r28_options_long;
	}
	public void setR28_options_long(BigDecimal r28_options_long) {
		this.r28_options_long = r28_options_long;
	}
	public BigDecimal getR28_options_short() {
		return r28_options_short;
	}
	public void setR28_options_short(BigDecimal r28_options_short) {
		this.r28_options_short = r28_options_short;
	}
	public BigDecimal getR28_total_position_long() {
		return r28_total_position_long;
	}
	public void setR28_total_position_long(BigDecimal r28_total_position_long) {
		this.r28_total_position_long = r28_total_position_long;
	}
	public BigDecimal getR28_total_position_short() {
		return r28_total_position_short;
	}
	public void setR28_total_position_short(BigDecimal r28_total_position_short) {
		this.r28_total_position_short = r28_total_position_short;
	}
	public String getR28_risk_weight() {
		return r28_risk_weight;
	}
	public void setR28_risk_weight(String r28_risk_weight) {
		this.r28_risk_weight = r28_risk_weight;
	}
	public String getR28_weighted_positions_long() {
		return r28_weighted_positions_long;
	}
	public void setR28_weighted_positions_long(String r28_weighted_positions_long) {
		this.r28_weighted_positions_long = r28_weighted_positions_long;
	}
	public String getR28_weighted_positions_short() {
		return r28_weighted_positions_short;
	}
	public void setR28_weighted_positions_short(String r28_weighted_positions_short) {
		this.r28_weighted_positions_short = r28_weighted_positions_short;
	}
	public BigDecimal getR28_within_bands_zones_matched() {
		return r28_within_bands_zones_matched;
	}
	public void setR28_within_bands_zones_matched(BigDecimal r28_within_bands_zones_matched) {
		this.r28_within_bands_zones_matched = r28_within_bands_zones_matched;
	}
	public String getR28_within_bands_zones_unmatched() {
		return r28_within_bands_zones_unmatched;
	}
	public void setR28_within_bands_zones_unmatched(String r28_within_bands_zones_unmatched) {
		this.r28_within_bands_zones_unmatched = r28_within_bands_zones_unmatched;
	}
	public BigDecimal getR28_between_zones_matched() {
		return r28_between_zones_matched;
	}
	public void setR28_between_zones_matched(BigDecimal r28_between_zones_matched) {
		this.r28_between_zones_matched = r28_between_zones_matched;
	}
	public BigDecimal getR28_between_zones_unmatched() {
		return r28_between_zones_unmatched;
	}
	public void setR28_between_zones_unmatched(BigDecimal r28_between_zones_unmatched) {
		this.r28_between_zones_unmatched = r28_between_zones_unmatched;
	}
	public BigDecimal getR28_net_pos_cap_charge() {
		return r28_net_pos_cap_charge;
	}
	public void setR28_net_pos_cap_charge(BigDecimal r28_net_pos_cap_charge) {
		this.r28_net_pos_cap_charge = r28_net_pos_cap_charge;
	}
	public String getR28_risk_cap_charge() {
		return r28_risk_cap_charge;
	}
	public void setR28_risk_cap_charge(String r28_risk_cap_charge) {
		this.r28_risk_cap_charge = r28_risk_cap_charge;
	}
	public BigDecimal getR28_capital_charge() {
		return r28_capital_charge;
	}
	public void setR28_capital_charge(BigDecimal r28_capital_charge) {
		this.r28_capital_charge = r28_capital_charge;
	}
	public String getR29_product1() {
		return r29_product1;
	}
	public void setR29_product1(String r29_product1) {
		this.r29_product1 = r29_product1;
	}
	public String getR29_product2() {
		return r29_product2;
	}
	public void setR29_product2(String r29_product2) {
		this.r29_product2 = r29_product2;
	}
	public BigDecimal getR29_debt_sec_long() {
		return r29_debt_sec_long;
	}
	public void setR29_debt_sec_long(BigDecimal r29_debt_sec_long) {
		this.r29_debt_sec_long = r29_debt_sec_long;
	}
	public BigDecimal getR29_debt_sec_short() {
		return r29_debt_sec_short;
	}
	public void setR29_debt_sec_short(BigDecimal r29_debt_sec_short) {
		this.r29_debt_sec_short = r29_debt_sec_short;
	}
	public BigDecimal getR29_int_rate_long() {
		return r29_int_rate_long;
	}
	public void setR29_int_rate_long(BigDecimal r29_int_rate_long) {
		this.r29_int_rate_long = r29_int_rate_long;
	}
	public BigDecimal getR29_int_rate_short() {
		return r29_int_rate_short;
	}
	public void setR29_int_rate_short(BigDecimal r29_int_rate_short) {
		this.r29_int_rate_short = r29_int_rate_short;
	}
	public BigDecimal getR29_options_long() {
		return r29_options_long;
	}
	public void setR29_options_long(BigDecimal r29_options_long) {
		this.r29_options_long = r29_options_long;
	}
	public BigDecimal getR29_options_short() {
		return r29_options_short;
	}
	public void setR29_options_short(BigDecimal r29_options_short) {
		this.r29_options_short = r29_options_short;
	}
	public BigDecimal getR29_total_position_long() {
		return r29_total_position_long;
	}
	public void setR29_total_position_long(BigDecimal r29_total_position_long) {
		this.r29_total_position_long = r29_total_position_long;
	}
	public BigDecimal getR29_total_position_short() {
		return r29_total_position_short;
	}
	public void setR29_total_position_short(BigDecimal r29_total_position_short) {
		this.r29_total_position_short = r29_total_position_short;
	}
	public String getR29_risk_weight() {
		return r29_risk_weight;
	}
	public void setR29_risk_weight(String r29_risk_weight) {
		this.r29_risk_weight = r29_risk_weight;
	}
	public String getR29_weighted_positions_long() {
		return r29_weighted_positions_long;
	}
	public void setR29_weighted_positions_long(String r29_weighted_positions_long) {
		this.r29_weighted_positions_long = r29_weighted_positions_long;
	}
	public String getR29_weighted_positions_short() {
		return r29_weighted_positions_short;
	}
	public void setR29_weighted_positions_short(String r29_weighted_positions_short) {
		this.r29_weighted_positions_short = r29_weighted_positions_short;
	}
	public BigDecimal getR29_within_bands_zones_matched() {
		return r29_within_bands_zones_matched;
	}
	public void setR29_within_bands_zones_matched(BigDecimal r29_within_bands_zones_matched) {
		this.r29_within_bands_zones_matched = r29_within_bands_zones_matched;
	}
	public String getR29_within_bands_zones_unmatched() {
		return r29_within_bands_zones_unmatched;
	}
	public void setR29_within_bands_zones_unmatched(String r29_within_bands_zones_unmatched) {
		this.r29_within_bands_zones_unmatched = r29_within_bands_zones_unmatched;
	}
	public BigDecimal getR29_between_zones_matched() {
		return r29_between_zones_matched;
	}
	public void setR29_between_zones_matched(BigDecimal r29_between_zones_matched) {
		this.r29_between_zones_matched = r29_between_zones_matched;
	}
	public BigDecimal getR29_between_zones_unmatched() {
		return r29_between_zones_unmatched;
	}
	public void setR29_between_zones_unmatched(BigDecimal r29_between_zones_unmatched) {
		this.r29_between_zones_unmatched = r29_between_zones_unmatched;
	}
	public BigDecimal getR29_net_pos_cap_charge() {
		return r29_net_pos_cap_charge;
	}
	public void setR29_net_pos_cap_charge(BigDecimal r29_net_pos_cap_charge) {
		this.r29_net_pos_cap_charge = r29_net_pos_cap_charge;
	}
	public String getR29_risk_cap_charge() {
		return r29_risk_cap_charge;
	}
	public void setR29_risk_cap_charge(String r29_risk_cap_charge) {
		this.r29_risk_cap_charge = r29_risk_cap_charge;
	}
	public BigDecimal getR29_capital_charge() {
		return r29_capital_charge;
	}
	public void setR29_capital_charge(BigDecimal r29_capital_charge) {
		this.r29_capital_charge = r29_capital_charge;
	}
	public String getR30_product1() {
		return r30_product1;
	}
	public void setR30_product1(String r30_product1) {
		this.r30_product1 = r30_product1;
	}
	public String getR30_product2() {
		return r30_product2;
	}
	public void setR30_product2(String r30_product2) {
		this.r30_product2 = r30_product2;
	}
	public BigDecimal getR30_debt_sec_long() {
		return r30_debt_sec_long;
	}
	public void setR30_debt_sec_long(BigDecimal r30_debt_sec_long) {
		this.r30_debt_sec_long = r30_debt_sec_long;
	}
	public BigDecimal getR30_debt_sec_short() {
		return r30_debt_sec_short;
	}
	public void setR30_debt_sec_short(BigDecimal r30_debt_sec_short) {
		this.r30_debt_sec_short = r30_debt_sec_short;
	}
	public BigDecimal getR30_int_rate_long() {
		return r30_int_rate_long;
	}
	public void setR30_int_rate_long(BigDecimal r30_int_rate_long) {
		this.r30_int_rate_long = r30_int_rate_long;
	}
	public BigDecimal getR30_int_rate_short() {
		return r30_int_rate_short;
	}
	public void setR30_int_rate_short(BigDecimal r30_int_rate_short) {
		this.r30_int_rate_short = r30_int_rate_short;
	}
	public BigDecimal getR30_options_long() {
		return r30_options_long;
	}
	public void setR30_options_long(BigDecimal r30_options_long) {
		this.r30_options_long = r30_options_long;
	}
	public BigDecimal getR30_options_short() {
		return r30_options_short;
	}
	public void setR30_options_short(BigDecimal r30_options_short) {
		this.r30_options_short = r30_options_short;
	}
	public BigDecimal getR30_total_position_long() {
		return r30_total_position_long;
	}
	public void setR30_total_position_long(BigDecimal r30_total_position_long) {
		this.r30_total_position_long = r30_total_position_long;
	}
	public BigDecimal getR30_total_position_short() {
		return r30_total_position_short;
	}
	public void setR30_total_position_short(BigDecimal r30_total_position_short) {
		this.r30_total_position_short = r30_total_position_short;
	}
	public String getR30_risk_weight() {
		return r30_risk_weight;
	}
	public void setR30_risk_weight(String r30_risk_weight) {
		this.r30_risk_weight = r30_risk_weight;
	}
	public String getR30_weighted_positions_long() {
		return r30_weighted_positions_long;
	}
	public void setR30_weighted_positions_long(String r30_weighted_positions_long) {
		this.r30_weighted_positions_long = r30_weighted_positions_long;
	}
	public String getR30_weighted_positions_short() {
		return r30_weighted_positions_short;
	}
	public void setR30_weighted_positions_short(String r30_weighted_positions_short) {
		this.r30_weighted_positions_short = r30_weighted_positions_short;
	}
	public BigDecimal getR30_within_bands_zones_matched() {
		return r30_within_bands_zones_matched;
	}
	public void setR30_within_bands_zones_matched(BigDecimal r30_within_bands_zones_matched) {
		this.r30_within_bands_zones_matched = r30_within_bands_zones_matched;
	}
	public String getR30_within_bands_zones_unmatched() {
		return r30_within_bands_zones_unmatched;
	}
	public void setR30_within_bands_zones_unmatched(String r30_within_bands_zones_unmatched) {
		this.r30_within_bands_zones_unmatched = r30_within_bands_zones_unmatched;
	}
	public BigDecimal getR30_between_zones_matched() {
		return r30_between_zones_matched;
	}
	public void setR30_between_zones_matched(BigDecimal r30_between_zones_matched) {
		this.r30_between_zones_matched = r30_between_zones_matched;
	}
	public BigDecimal getR30_between_zones_unmatched() {
		return r30_between_zones_unmatched;
	}
	public void setR30_between_zones_unmatched(BigDecimal r30_between_zones_unmatched) {
		this.r30_between_zones_unmatched = r30_between_zones_unmatched;
	}
	public BigDecimal getR30_net_pos_cap_charge() {
		return r30_net_pos_cap_charge;
	}
	public void setR30_net_pos_cap_charge(BigDecimal r30_net_pos_cap_charge) {
		this.r30_net_pos_cap_charge = r30_net_pos_cap_charge;
	}
	public String getR30_risk_cap_charge() {
		return r30_risk_cap_charge;
	}
	public void setR30_risk_cap_charge(String r30_risk_cap_charge) {
		this.r30_risk_cap_charge = r30_risk_cap_charge;
	}
	public BigDecimal getR30_capital_charge() {
		return r30_capital_charge;
	}
	public void setR30_capital_charge(BigDecimal r30_capital_charge) {
		this.r30_capital_charge = r30_capital_charge;
	}
	public String getR31_product1() {
		return r31_product1;
	}
	public void setR31_product1(String r31_product1) {
		this.r31_product1 = r31_product1;
	}
	public String getR31_product2() {
		return r31_product2;
	}
	public void setR31_product2(String r31_product2) {
		this.r31_product2 = r31_product2;
	}
	public BigDecimal getR31_debt_sec_long() {
		return r31_debt_sec_long;
	}
	public void setR31_debt_sec_long(BigDecimal r31_debt_sec_long) {
		this.r31_debt_sec_long = r31_debt_sec_long;
	}
	public BigDecimal getR31_debt_sec_short() {
		return r31_debt_sec_short;
	}
	public void setR31_debt_sec_short(BigDecimal r31_debt_sec_short) {
		this.r31_debt_sec_short = r31_debt_sec_short;
	}
	public BigDecimal getR31_int_rate_long() {
		return r31_int_rate_long;
	}
	public void setR31_int_rate_long(BigDecimal r31_int_rate_long) {
		this.r31_int_rate_long = r31_int_rate_long;
	}
	public BigDecimal getR31_int_rate_short() {
		return r31_int_rate_short;
	}
	public void setR31_int_rate_short(BigDecimal r31_int_rate_short) {
		this.r31_int_rate_short = r31_int_rate_short;
	}
	public BigDecimal getR31_options_long() {
		return r31_options_long;
	}
	public void setR31_options_long(BigDecimal r31_options_long) {
		this.r31_options_long = r31_options_long;
	}
	public BigDecimal getR31_options_short() {
		return r31_options_short;
	}
	public void setR31_options_short(BigDecimal r31_options_short) {
		this.r31_options_short = r31_options_short;
	}
	public BigDecimal getR31_total_position_long() {
		return r31_total_position_long;
	}
	public void setR31_total_position_long(BigDecimal r31_total_position_long) {
		this.r31_total_position_long = r31_total_position_long;
	}
	public BigDecimal getR31_total_position_short() {
		return r31_total_position_short;
	}
	public void setR31_total_position_short(BigDecimal r31_total_position_short) {
		this.r31_total_position_short = r31_total_position_short;
	}
	public String getR31_risk_weight() {
		return r31_risk_weight;
	}
	public void setR31_risk_weight(String r31_risk_weight) {
		this.r31_risk_weight = r31_risk_weight;
	}
	public String getR31_weighted_positions_long() {
		return r31_weighted_positions_long;
	}
	public void setR31_weighted_positions_long(String r31_weighted_positions_long) {
		this.r31_weighted_positions_long = r31_weighted_positions_long;
	}
	public String getR31_weighted_positions_short() {
		return r31_weighted_positions_short;
	}
	public void setR31_weighted_positions_short(String r31_weighted_positions_short) {
		this.r31_weighted_positions_short = r31_weighted_positions_short;
	}
	public BigDecimal getR31_within_bands_zones_matched() {
		return r31_within_bands_zones_matched;
	}
	public void setR31_within_bands_zones_matched(BigDecimal r31_within_bands_zones_matched) {
		this.r31_within_bands_zones_matched = r31_within_bands_zones_matched;
	}
	public String getR31_within_bands_zones_unmatched() {
		return r31_within_bands_zones_unmatched;
	}
	public void setR31_within_bands_zones_unmatched(String r31_within_bands_zones_unmatched) {
		this.r31_within_bands_zones_unmatched = r31_within_bands_zones_unmatched;
	}
	public BigDecimal getR31_between_zones_matched() {
		return r31_between_zones_matched;
	}
	public void setR31_between_zones_matched(BigDecimal r31_between_zones_matched) {
		this.r31_between_zones_matched = r31_between_zones_matched;
	}
	public BigDecimal getR31_between_zones_unmatched() {
		return r31_between_zones_unmatched;
	}
	public void setR31_between_zones_unmatched(BigDecimal r31_between_zones_unmatched) {
		this.r31_between_zones_unmatched = r31_between_zones_unmatched;
	}
	public BigDecimal getR31_net_pos_cap_charge() {
		return r31_net_pos_cap_charge;
	}
	public void setR31_net_pos_cap_charge(BigDecimal r31_net_pos_cap_charge) {
		this.r31_net_pos_cap_charge = r31_net_pos_cap_charge;
	}
	public String getR31_risk_cap_charge() {
		return r31_risk_cap_charge;
	}
	public void setR31_risk_cap_charge(String r31_risk_cap_charge) {
		this.r31_risk_cap_charge = r31_risk_cap_charge;
	}
	public BigDecimal getR31_capital_charge() {
		return r31_capital_charge;
	}
	public void setR31_capital_charge(BigDecimal r31_capital_charge) {
		this.r31_capital_charge = r31_capital_charge;
	}
	public String getR32_product1() {
		return r32_product1;
	}
	public void setR32_product1(String r32_product1) {
		this.r32_product1 = r32_product1;
	}
	public String getR32_product2() {
		return r32_product2;
	}
	public void setR32_product2(String r32_product2) {
		this.r32_product2 = r32_product2;
	}
	public BigDecimal getR32_debt_sec_long() {
		return r32_debt_sec_long;
	}
	public void setR32_debt_sec_long(BigDecimal r32_debt_sec_long) {
		this.r32_debt_sec_long = r32_debt_sec_long;
	}
	public BigDecimal getR32_debt_sec_short() {
		return r32_debt_sec_short;
	}
	public void setR32_debt_sec_short(BigDecimal r32_debt_sec_short) {
		this.r32_debt_sec_short = r32_debt_sec_short;
	}
	public BigDecimal getR32_int_rate_long() {
		return r32_int_rate_long;
	}
	public void setR32_int_rate_long(BigDecimal r32_int_rate_long) {
		this.r32_int_rate_long = r32_int_rate_long;
	}
	public BigDecimal getR32_int_rate_short() {
		return r32_int_rate_short;
	}
	public void setR32_int_rate_short(BigDecimal r32_int_rate_short) {
		this.r32_int_rate_short = r32_int_rate_short;
	}
	public BigDecimal getR32_options_long() {
		return r32_options_long;
	}
	public void setR32_options_long(BigDecimal r32_options_long) {
		this.r32_options_long = r32_options_long;
	}
	public BigDecimal getR32_options_short() {
		return r32_options_short;
	}
	public void setR32_options_short(BigDecimal r32_options_short) {
		this.r32_options_short = r32_options_short;
	}
	public BigDecimal getR32_total_position_long() {
		return r32_total_position_long;
	}
	public void setR32_total_position_long(BigDecimal r32_total_position_long) {
		this.r32_total_position_long = r32_total_position_long;
	}
	public BigDecimal getR32_total_position_short() {
		return r32_total_position_short;
	}
	public void setR32_total_position_short(BigDecimal r32_total_position_short) {
		this.r32_total_position_short = r32_total_position_short;
	}
	public String getR32_risk_weight() {
		return r32_risk_weight;
	}
	public void setR32_risk_weight(String r32_risk_weight) {
		this.r32_risk_weight = r32_risk_weight;
	}
	public String getR32_weighted_positions_long() {
		return r32_weighted_positions_long;
	}
	public void setR32_weighted_positions_long(String r32_weighted_positions_long) {
		this.r32_weighted_positions_long = r32_weighted_positions_long;
	}
	public String getR32_weighted_positions_short() {
		return r32_weighted_positions_short;
	}
	public void setR32_weighted_positions_short(String r32_weighted_positions_short) {
		this.r32_weighted_positions_short = r32_weighted_positions_short;
	}
	public BigDecimal getR32_within_bands_zones_matched() {
		return r32_within_bands_zones_matched;
	}
	public void setR32_within_bands_zones_matched(BigDecimal r32_within_bands_zones_matched) {
		this.r32_within_bands_zones_matched = r32_within_bands_zones_matched;
	}
	public String getR32_within_bands_zones_unmatched() {
		return r32_within_bands_zones_unmatched;
	}
	public void setR32_within_bands_zones_unmatched(String r32_within_bands_zones_unmatched) {
		this.r32_within_bands_zones_unmatched = r32_within_bands_zones_unmatched;
	}
	public BigDecimal getR32_between_zones_matched() {
		return r32_between_zones_matched;
	}
	public void setR32_between_zones_matched(BigDecimal r32_between_zones_matched) {
		this.r32_between_zones_matched = r32_between_zones_matched;
	}
	public BigDecimal getR32_between_zones_unmatched() {
		return r32_between_zones_unmatched;
	}
	public void setR32_between_zones_unmatched(BigDecimal r32_between_zones_unmatched) {
		this.r32_between_zones_unmatched = r32_between_zones_unmatched;
	}
	public BigDecimal getR32_net_pos_cap_charge() {
		return r32_net_pos_cap_charge;
	}
	public void setR32_net_pos_cap_charge(BigDecimal r32_net_pos_cap_charge) {
		this.r32_net_pos_cap_charge = r32_net_pos_cap_charge;
	}
	public String getR32_risk_cap_charge() {
		return r32_risk_cap_charge;
	}
	public void setR32_risk_cap_charge(String r32_risk_cap_charge) {
		this.r32_risk_cap_charge = r32_risk_cap_charge;
	}
	public BigDecimal getR32_capital_charge() {
		return r32_capital_charge;
	}
	public void setR32_capital_charge(BigDecimal r32_capital_charge) {
		this.r32_capital_charge = r32_capital_charge;
	}
	public String getR33_product1() {
		return r33_product1;
	}
	public void setR33_product1(String r33_product1) {
		this.r33_product1 = r33_product1;
	}
	public String getR33_product2() {
		return r33_product2;
	}
	public void setR33_product2(String r33_product2) {
		this.r33_product2 = r33_product2;
	}
	public BigDecimal getR33_debt_sec_long() {
		return r33_debt_sec_long;
	}
	public void setR33_debt_sec_long(BigDecimal r33_debt_sec_long) {
		this.r33_debt_sec_long = r33_debt_sec_long;
	}
	public BigDecimal getR33_debt_sec_short() {
		return r33_debt_sec_short;
	}
	public void setR33_debt_sec_short(BigDecimal r33_debt_sec_short) {
		this.r33_debt_sec_short = r33_debt_sec_short;
	}
	public BigDecimal getR33_int_rate_long() {
		return r33_int_rate_long;
	}
	public void setR33_int_rate_long(BigDecimal r33_int_rate_long) {
		this.r33_int_rate_long = r33_int_rate_long;
	}
	public BigDecimal getR33_int_rate_short() {
		return r33_int_rate_short;
	}
	public void setR33_int_rate_short(BigDecimal r33_int_rate_short) {
		this.r33_int_rate_short = r33_int_rate_short;
	}
	public BigDecimal getR33_options_long() {
		return r33_options_long;
	}
	public void setR33_options_long(BigDecimal r33_options_long) {
		this.r33_options_long = r33_options_long;
	}
	public BigDecimal getR33_options_short() {
		return r33_options_short;
	}
	public void setR33_options_short(BigDecimal r33_options_short) {
		this.r33_options_short = r33_options_short;
	}
	public BigDecimal getR33_total_position_long() {
		return r33_total_position_long;
	}
	public void setR33_total_position_long(BigDecimal r33_total_position_long) {
		this.r33_total_position_long = r33_total_position_long;
	}
	public BigDecimal getR33_total_position_short() {
		return r33_total_position_short;
	}
	public void setR33_total_position_short(BigDecimal r33_total_position_short) {
		this.r33_total_position_short = r33_total_position_short;
	}
	public String getR33_risk_weight() {
		return r33_risk_weight;
	}
	public void setR33_risk_weight(String r33_risk_weight) {
		this.r33_risk_weight = r33_risk_weight;
	}
	public String getR33_weighted_positions_long() {
		return r33_weighted_positions_long;
	}
	public void setR33_weighted_positions_long(String r33_weighted_positions_long) {
		this.r33_weighted_positions_long = r33_weighted_positions_long;
	}
	public String getR33_weighted_positions_short() {
		return r33_weighted_positions_short;
	}
	public void setR33_weighted_positions_short(String r33_weighted_positions_short) {
		this.r33_weighted_positions_short = r33_weighted_positions_short;
	}
	public BigDecimal getR33_within_bands_zones_matched() {
		return r33_within_bands_zones_matched;
	}
	public void setR33_within_bands_zones_matched(BigDecimal r33_within_bands_zones_matched) {
		this.r33_within_bands_zones_matched = r33_within_bands_zones_matched;
	}
	public String getR33_within_bands_zones_unmatched() {
		return r33_within_bands_zones_unmatched;
	}
	public void setR33_within_bands_zones_unmatched(String r33_within_bands_zones_unmatched) {
		this.r33_within_bands_zones_unmatched = r33_within_bands_zones_unmatched;
	}
	public BigDecimal getR33_between_zones_matched() {
		return r33_between_zones_matched;
	}
	public void setR33_between_zones_matched(BigDecimal r33_between_zones_matched) {
		this.r33_between_zones_matched = r33_between_zones_matched;
	}
	public BigDecimal getR33_between_zones_unmatched() {
		return r33_between_zones_unmatched;
	}
	public void setR33_between_zones_unmatched(BigDecimal r33_between_zones_unmatched) {
		this.r33_between_zones_unmatched = r33_between_zones_unmatched;
	}
	public BigDecimal getR33_net_pos_cap_charge() {
		return r33_net_pos_cap_charge;
	}
	public void setR33_net_pos_cap_charge(BigDecimal r33_net_pos_cap_charge) {
		this.r33_net_pos_cap_charge = r33_net_pos_cap_charge;
	}
	public String getR33_risk_cap_charge() {
		return r33_risk_cap_charge;
	}
	public void setR33_risk_cap_charge(String r33_risk_cap_charge) {
		this.r33_risk_cap_charge = r33_risk_cap_charge;
	}
	public BigDecimal getR33_capital_charge() {
		return r33_capital_charge;
	}
	public void setR33_capital_charge(BigDecimal r33_capital_charge) {
		this.r33_capital_charge = r33_capital_charge;
	}
	public String getR34_product1() {
		return r34_product1;
	}
	public void setR34_product1(String r34_product1) {
		this.r34_product1 = r34_product1;
	}
	public String getR34_product2() {
		return r34_product2;
	}
	public void setR34_product2(String r34_product2) {
		this.r34_product2 = r34_product2;
	}
	public BigDecimal getR34_debt_sec_long() {
		return r34_debt_sec_long;
	}
	public void setR34_debt_sec_long(BigDecimal r34_debt_sec_long) {
		this.r34_debt_sec_long = r34_debt_sec_long;
	}
	public BigDecimal getR34_debt_sec_short() {
		return r34_debt_sec_short;
	}
	public void setR34_debt_sec_short(BigDecimal r34_debt_sec_short) {
		this.r34_debt_sec_short = r34_debt_sec_short;
	}
	public BigDecimal getR34_int_rate_long() {
		return r34_int_rate_long;
	}
	public void setR34_int_rate_long(BigDecimal r34_int_rate_long) {
		this.r34_int_rate_long = r34_int_rate_long;
	}
	public BigDecimal getR34_int_rate_short() {
		return r34_int_rate_short;
	}
	public void setR34_int_rate_short(BigDecimal r34_int_rate_short) {
		this.r34_int_rate_short = r34_int_rate_short;
	}
	public BigDecimal getR34_options_long() {
		return r34_options_long;
	}
	public void setR34_options_long(BigDecimal r34_options_long) {
		this.r34_options_long = r34_options_long;
	}
	public BigDecimal getR34_options_short() {
		return r34_options_short;
	}
	public void setR34_options_short(BigDecimal r34_options_short) {
		this.r34_options_short = r34_options_short;
	}
	public BigDecimal getR34_total_position_long() {
		return r34_total_position_long;
	}
	public void setR34_total_position_long(BigDecimal r34_total_position_long) {
		this.r34_total_position_long = r34_total_position_long;
	}
	public BigDecimal getR34_total_position_short() {
		return r34_total_position_short;
	}
	public void setR34_total_position_short(BigDecimal r34_total_position_short) {
		this.r34_total_position_short = r34_total_position_short;
	}
	public String getR34_risk_weight() {
		return r34_risk_weight;
	}
	public void setR34_risk_weight(String r34_risk_weight) {
		this.r34_risk_weight = r34_risk_weight;
	}
	public String getR34_weighted_positions_long() {
		return r34_weighted_positions_long;
	}
	public void setR34_weighted_positions_long(String r34_weighted_positions_long) {
		this.r34_weighted_positions_long = r34_weighted_positions_long;
	}
	public String getR34_weighted_positions_short() {
		return r34_weighted_positions_short;
	}
	public void setR34_weighted_positions_short(String r34_weighted_positions_short) {
		this.r34_weighted_positions_short = r34_weighted_positions_short;
	}
	public BigDecimal getR34_within_bands_zones_matched() {
		return r34_within_bands_zones_matched;
	}
	public void setR34_within_bands_zones_matched(BigDecimal r34_within_bands_zones_matched) {
		this.r34_within_bands_zones_matched = r34_within_bands_zones_matched;
	}
	public String getR34_within_bands_zones_unmatched() {
		return r34_within_bands_zones_unmatched;
	}
	public void setR34_within_bands_zones_unmatched(String r34_within_bands_zones_unmatched) {
		this.r34_within_bands_zones_unmatched = r34_within_bands_zones_unmatched;
	}
	public BigDecimal getR34_between_zones_matched() {
		return r34_between_zones_matched;
	}
	public void setR34_between_zones_matched(BigDecimal r34_between_zones_matched) {
		this.r34_between_zones_matched = r34_between_zones_matched;
	}
	public BigDecimal getR34_between_zones_unmatched() {
		return r34_between_zones_unmatched;
	}
	public void setR34_between_zones_unmatched(BigDecimal r34_between_zones_unmatched) {
		this.r34_between_zones_unmatched = r34_between_zones_unmatched;
	}
	public BigDecimal getR34_net_pos_cap_charge() {
		return r34_net_pos_cap_charge;
	}
	public void setR34_net_pos_cap_charge(BigDecimal r34_net_pos_cap_charge) {
		this.r34_net_pos_cap_charge = r34_net_pos_cap_charge;
	}
	public String getR34_risk_cap_charge() {
		return r34_risk_cap_charge;
	}
	public void setR34_risk_cap_charge(String r34_risk_cap_charge) {
		this.r34_risk_cap_charge = r34_risk_cap_charge;
	}
	public BigDecimal getR34_capital_charge() {
		return r34_capital_charge;
	}
	public void setR34_capital_charge(BigDecimal r34_capital_charge) {
		this.r34_capital_charge = r34_capital_charge;
	}
	public String getR35_product1() {
		return r35_product1;
	}
	public void setR35_product1(String r35_product1) {
		this.r35_product1 = r35_product1;
	}
	public String getR35_product2() {
		return r35_product2;
	}
	public void setR35_product2(String r35_product2) {
		this.r35_product2 = r35_product2;
	}
	public BigDecimal getR35_debt_sec_long() {
		return r35_debt_sec_long;
	}
	public void setR35_debt_sec_long(BigDecimal r35_debt_sec_long) {
		this.r35_debt_sec_long = r35_debt_sec_long;
	}
	public BigDecimal getR35_debt_sec_short() {
		return r35_debt_sec_short;
	}
	public void setR35_debt_sec_short(BigDecimal r35_debt_sec_short) {
		this.r35_debt_sec_short = r35_debt_sec_short;
	}
	public BigDecimal getR35_int_rate_long() {
		return r35_int_rate_long;
	}
	public void setR35_int_rate_long(BigDecimal r35_int_rate_long) {
		this.r35_int_rate_long = r35_int_rate_long;
	}
	public BigDecimal getR35_int_rate_short() {
		return r35_int_rate_short;
	}
	public void setR35_int_rate_short(BigDecimal r35_int_rate_short) {
		this.r35_int_rate_short = r35_int_rate_short;
	}
	public BigDecimal getR35_options_long() {
		return r35_options_long;
	}
	public void setR35_options_long(BigDecimal r35_options_long) {
		this.r35_options_long = r35_options_long;
	}
	public BigDecimal getR35_options_short() {
		return r35_options_short;
	}
	public void setR35_options_short(BigDecimal r35_options_short) {
		this.r35_options_short = r35_options_short;
	}
	public BigDecimal getR35_total_position_long() {
		return r35_total_position_long;
	}
	public void setR35_total_position_long(BigDecimal r35_total_position_long) {
		this.r35_total_position_long = r35_total_position_long;
	}
	public BigDecimal getR35_total_position_short() {
		return r35_total_position_short;
	}
	public void setR35_total_position_short(BigDecimal r35_total_position_short) {
		this.r35_total_position_short = r35_total_position_short;
	}
	public String getR35_risk_weight() {
		return r35_risk_weight;
	}
	public void setR35_risk_weight(String r35_risk_weight) {
		this.r35_risk_weight = r35_risk_weight;
	}
	public String getR35_weighted_positions_long() {
		return r35_weighted_positions_long;
	}
	public void setR35_weighted_positions_long(String r35_weighted_positions_long) {
		this.r35_weighted_positions_long = r35_weighted_positions_long;
	}
	public String getR35_weighted_positions_short() {
		return r35_weighted_positions_short;
	}
	public void setR35_weighted_positions_short(String r35_weighted_positions_short) {
		this.r35_weighted_positions_short = r35_weighted_positions_short;
	}
	public BigDecimal getR35_within_bands_zones_matched() {
		return r35_within_bands_zones_matched;
	}
	public void setR35_within_bands_zones_matched(BigDecimal r35_within_bands_zones_matched) {
		this.r35_within_bands_zones_matched = r35_within_bands_zones_matched;
	}
	public String getR35_within_bands_zones_unmatched() {
		return r35_within_bands_zones_unmatched;
	}
	public void setR35_within_bands_zones_unmatched(String r35_within_bands_zones_unmatched) {
		this.r35_within_bands_zones_unmatched = r35_within_bands_zones_unmatched;
	}
	public BigDecimal getR35_between_zones_matched() {
		return r35_between_zones_matched;
	}
	public void setR35_between_zones_matched(BigDecimal r35_between_zones_matched) {
		this.r35_between_zones_matched = r35_between_zones_matched;
	}
	public BigDecimal getR35_between_zones_unmatched() {
		return r35_between_zones_unmatched;
	}
	public void setR35_between_zones_unmatched(BigDecimal r35_between_zones_unmatched) {
		this.r35_between_zones_unmatched = r35_between_zones_unmatched;
	}
	public BigDecimal getR35_net_pos_cap_charge() {
		return r35_net_pos_cap_charge;
	}
	public void setR35_net_pos_cap_charge(BigDecimal r35_net_pos_cap_charge) {
		this.r35_net_pos_cap_charge = r35_net_pos_cap_charge;
	}
	public String getR35_risk_cap_charge() {
		return r35_risk_cap_charge;
	}
	public void setR35_risk_cap_charge(String r35_risk_cap_charge) {
		this.r35_risk_cap_charge = r35_risk_cap_charge;
	}
	public BigDecimal getR35_capital_charge() {
		return r35_capital_charge;
	}
	public void setR35_capital_charge(BigDecimal r35_capital_charge) {
		this.r35_capital_charge = r35_capital_charge;
	}
	public String getR36_product1() {
		return r36_product1;
	}
	public void setR36_product1(String r36_product1) {
		this.r36_product1 = r36_product1;
	}
	public String getR36_product2() {
		return r36_product2;
	}
	public void setR36_product2(String r36_product2) {
		this.r36_product2 = r36_product2;
	}
	public BigDecimal getR36_debt_sec_long() {
		return r36_debt_sec_long;
	}
	public void setR36_debt_sec_long(BigDecimal r36_debt_sec_long) {
		this.r36_debt_sec_long = r36_debt_sec_long;
	}
	public BigDecimal getR36_debt_sec_short() {
		return r36_debt_sec_short;
	}
	public void setR36_debt_sec_short(BigDecimal r36_debt_sec_short) {
		this.r36_debt_sec_short = r36_debt_sec_short;
	}
	public BigDecimal getR36_int_rate_long() {
		return r36_int_rate_long;
	}
	public void setR36_int_rate_long(BigDecimal r36_int_rate_long) {
		this.r36_int_rate_long = r36_int_rate_long;
	}
	public BigDecimal getR36_int_rate_short() {
		return r36_int_rate_short;
	}
	public void setR36_int_rate_short(BigDecimal r36_int_rate_short) {
		this.r36_int_rate_short = r36_int_rate_short;
	}
	public BigDecimal getR36_options_long() {
		return r36_options_long;
	}
	public void setR36_options_long(BigDecimal r36_options_long) {
		this.r36_options_long = r36_options_long;
	}
	public BigDecimal getR36_options_short() {
		return r36_options_short;
	}
	public void setR36_options_short(BigDecimal r36_options_short) {
		this.r36_options_short = r36_options_short;
	}
	public BigDecimal getR36_total_position_long() {
		return r36_total_position_long;
	}
	public void setR36_total_position_long(BigDecimal r36_total_position_long) {
		this.r36_total_position_long = r36_total_position_long;
	}
	public BigDecimal getR36_total_position_short() {
		return r36_total_position_short;
	}
	public void setR36_total_position_short(BigDecimal r36_total_position_short) {
		this.r36_total_position_short = r36_total_position_short;
	}
	public String getR36_risk_weight() {
		return r36_risk_weight;
	}
	public void setR36_risk_weight(String r36_risk_weight) {
		this.r36_risk_weight = r36_risk_weight;
	}
	public String getR36_weighted_positions_long() {
		return r36_weighted_positions_long;
	}
	public void setR36_weighted_positions_long(String r36_weighted_positions_long) {
		this.r36_weighted_positions_long = r36_weighted_positions_long;
	}
	public String getR36_weighted_positions_short() {
		return r36_weighted_positions_short;
	}
	public void setR36_weighted_positions_short(String r36_weighted_positions_short) {
		this.r36_weighted_positions_short = r36_weighted_positions_short;
	}
	public BigDecimal getR36_within_bands_zones_matched() {
		return r36_within_bands_zones_matched;
	}
	public void setR36_within_bands_zones_matched(BigDecimal r36_within_bands_zones_matched) {
		this.r36_within_bands_zones_matched = r36_within_bands_zones_matched;
	}
	public String getR36_within_bands_zones_unmatched() {
		return r36_within_bands_zones_unmatched;
	}
	public void setR36_within_bands_zones_unmatched(String r36_within_bands_zones_unmatched) {
		this.r36_within_bands_zones_unmatched = r36_within_bands_zones_unmatched;
	}
	public BigDecimal getR36_between_zones_matched() {
		return r36_between_zones_matched;
	}
	public void setR36_between_zones_matched(BigDecimal r36_between_zones_matched) {
		this.r36_between_zones_matched = r36_between_zones_matched;
	}
	public BigDecimal getR36_between_zones_unmatched() {
		return r36_between_zones_unmatched;
	}
	public void setR36_between_zones_unmatched(BigDecimal r36_between_zones_unmatched) {
		this.r36_between_zones_unmatched = r36_between_zones_unmatched;
	}
	public BigDecimal getR36_net_pos_cap_charge() {
		return r36_net_pos_cap_charge;
	}
	public void setR36_net_pos_cap_charge(BigDecimal r36_net_pos_cap_charge) {
		this.r36_net_pos_cap_charge = r36_net_pos_cap_charge;
	}
	public String getR36_risk_cap_charge() {
		return r36_risk_cap_charge;
	}
	public void setR36_risk_cap_charge(String r36_risk_cap_charge) {
		this.r36_risk_cap_charge = r36_risk_cap_charge;
	}
	public BigDecimal getR36_capital_charge() {
		return r36_capital_charge;
	}
	public void setR36_capital_charge(BigDecimal r36_capital_charge) {
		this.r36_capital_charge = r36_capital_charge;
	}
	public String getR37_product1() {
		return r37_product1;
	}
	public void setR37_product1(String r37_product1) {
		this.r37_product1 = r37_product1;
	}
	public String getR37_product2() {
		return r37_product2;
	}
	public void setR37_product2(String r37_product2) {
		this.r37_product2 = r37_product2;
	}
	public BigDecimal getR37_debt_sec_long() {
		return r37_debt_sec_long;
	}
	public void setR37_debt_sec_long(BigDecimal r37_debt_sec_long) {
		this.r37_debt_sec_long = r37_debt_sec_long;
	}
	public BigDecimal getR37_debt_sec_short() {
		return r37_debt_sec_short;
	}
	public void setR37_debt_sec_short(BigDecimal r37_debt_sec_short) {
		this.r37_debt_sec_short = r37_debt_sec_short;
	}
	public BigDecimal getR37_int_rate_long() {
		return r37_int_rate_long;
	}
	public void setR37_int_rate_long(BigDecimal r37_int_rate_long) {
		this.r37_int_rate_long = r37_int_rate_long;
	}
	public BigDecimal getR37_int_rate_short() {
		return r37_int_rate_short;
	}
	public void setR37_int_rate_short(BigDecimal r37_int_rate_short) {
		this.r37_int_rate_short = r37_int_rate_short;
	}
	public BigDecimal getR37_options_long() {
		return r37_options_long;
	}
	public void setR37_options_long(BigDecimal r37_options_long) {
		this.r37_options_long = r37_options_long;
	}
	public BigDecimal getR37_options_short() {
		return r37_options_short;
	}
	public void setR37_options_short(BigDecimal r37_options_short) {
		this.r37_options_short = r37_options_short;
	}
	public BigDecimal getR37_total_position_long() {
		return r37_total_position_long;
	}
	public void setR37_total_position_long(BigDecimal r37_total_position_long) {
		this.r37_total_position_long = r37_total_position_long;
	}
	public BigDecimal getR37_total_position_short() {
		return r37_total_position_short;
	}
	public void setR37_total_position_short(BigDecimal r37_total_position_short) {
		this.r37_total_position_short = r37_total_position_short;
	}
	public String getR37_risk_weight() {
		return r37_risk_weight;
	}
	public void setR37_risk_weight(String r37_risk_weight) {
		this.r37_risk_weight = r37_risk_weight;
	}
	public String getR37_weighted_positions_long() {
		return r37_weighted_positions_long;
	}
	public void setR37_weighted_positions_long(String r37_weighted_positions_long) {
		this.r37_weighted_positions_long = r37_weighted_positions_long;
	}
	public String getR37_weighted_positions_short() {
		return r37_weighted_positions_short;
	}
	public void setR37_weighted_positions_short(String r37_weighted_positions_short) {
		this.r37_weighted_positions_short = r37_weighted_positions_short;
	}
	public BigDecimal getR37_within_bands_zones_matched() {
		return r37_within_bands_zones_matched;
	}
	public void setR37_within_bands_zones_matched(BigDecimal r37_within_bands_zones_matched) {
		this.r37_within_bands_zones_matched = r37_within_bands_zones_matched;
	}
	public String getR37_within_bands_zones_unmatched() {
		return r37_within_bands_zones_unmatched;
	}
	public void setR37_within_bands_zones_unmatched(String r37_within_bands_zones_unmatched) {
		this.r37_within_bands_zones_unmatched = r37_within_bands_zones_unmatched;
	}
	public BigDecimal getR37_between_zones_matched() {
		return r37_between_zones_matched;
	}
	public void setR37_between_zones_matched(BigDecimal r37_between_zones_matched) {
		this.r37_between_zones_matched = r37_between_zones_matched;
	}
	public BigDecimal getR37_between_zones_unmatched() {
		return r37_between_zones_unmatched;
	}
	public void setR37_between_zones_unmatched(BigDecimal r37_between_zones_unmatched) {
		this.r37_between_zones_unmatched = r37_between_zones_unmatched;
	}
	public BigDecimal getR37_net_pos_cap_charge() {
		return r37_net_pos_cap_charge;
	}
	public void setR37_net_pos_cap_charge(BigDecimal r37_net_pos_cap_charge) {
		this.r37_net_pos_cap_charge = r37_net_pos_cap_charge;
	}
	public String getR37_risk_cap_charge() {
		return r37_risk_cap_charge;
	}
	public void setR37_risk_cap_charge(String r37_risk_cap_charge) {
		this.r37_risk_cap_charge = r37_risk_cap_charge;
	}
	public BigDecimal getR37_capital_charge() {
		return r37_capital_charge;
	}
	public void setR37_capital_charge(BigDecimal r37_capital_charge) {
		this.r37_capital_charge = r37_capital_charge;
	}
	public String getR38_product1() {
		return r38_product1;
	}
	public void setR38_product1(String r38_product1) {
		this.r38_product1 = r38_product1;
	}
	public String getR38_product2() {
		return r38_product2;
	}
	public void setR38_product2(String r38_product2) {
		this.r38_product2 = r38_product2;
	}
	public BigDecimal getR38_debt_sec_long() {
		return r38_debt_sec_long;
	}
	public void setR38_debt_sec_long(BigDecimal r38_debt_sec_long) {
		this.r38_debt_sec_long = r38_debt_sec_long;
	}
	public BigDecimal getR38_debt_sec_short() {
		return r38_debt_sec_short;
	}
	public void setR38_debt_sec_short(BigDecimal r38_debt_sec_short) {
		this.r38_debt_sec_short = r38_debt_sec_short;
	}
	public BigDecimal getR38_int_rate_long() {
		return r38_int_rate_long;
	}
	public void setR38_int_rate_long(BigDecimal r38_int_rate_long) {
		this.r38_int_rate_long = r38_int_rate_long;
	}
	public BigDecimal getR38_int_rate_short() {
		return r38_int_rate_short;
	}
	public void setR38_int_rate_short(BigDecimal r38_int_rate_short) {
		this.r38_int_rate_short = r38_int_rate_short;
	}
	public BigDecimal getR38_options_long() {
		return r38_options_long;
	}
	public void setR38_options_long(BigDecimal r38_options_long) {
		this.r38_options_long = r38_options_long;
	}
	public BigDecimal getR38_options_short() {
		return r38_options_short;
	}
	public void setR38_options_short(BigDecimal r38_options_short) {
		this.r38_options_short = r38_options_short;
	}
	public BigDecimal getR38_total_position_long() {
		return r38_total_position_long;
	}
	public void setR38_total_position_long(BigDecimal r38_total_position_long) {
		this.r38_total_position_long = r38_total_position_long;
	}
	public BigDecimal getR38_total_position_short() {
		return r38_total_position_short;
	}
	public void setR38_total_position_short(BigDecimal r38_total_position_short) {
		this.r38_total_position_short = r38_total_position_short;
	}
	public String getR38_risk_weight() {
		return r38_risk_weight;
	}
	public void setR38_risk_weight(String r38_risk_weight) {
		this.r38_risk_weight = r38_risk_weight;
	}
	public String getR38_weighted_positions_long() {
		return r38_weighted_positions_long;
	}
	public void setR38_weighted_positions_long(String r38_weighted_positions_long) {
		this.r38_weighted_positions_long = r38_weighted_positions_long;
	}
	public String getR38_weighted_positions_short() {
		return r38_weighted_positions_short;
	}
	public void setR38_weighted_positions_short(String r38_weighted_positions_short) {
		this.r38_weighted_positions_short = r38_weighted_positions_short;
	}
	public BigDecimal getR38_within_bands_zones_matched() {
		return r38_within_bands_zones_matched;
	}
	public void setR38_within_bands_zones_matched(BigDecimal r38_within_bands_zones_matched) {
		this.r38_within_bands_zones_matched = r38_within_bands_zones_matched;
	}
	public String getR38_within_bands_zones_unmatched() {
		return r38_within_bands_zones_unmatched;
	}
	public void setR38_within_bands_zones_unmatched(String r38_within_bands_zones_unmatched) {
		this.r38_within_bands_zones_unmatched = r38_within_bands_zones_unmatched;
	}
	public BigDecimal getR38_between_zones_matched() {
		return r38_between_zones_matched;
	}
	public void setR38_between_zones_matched(BigDecimal r38_between_zones_matched) {
		this.r38_between_zones_matched = r38_between_zones_matched;
	}
	public BigDecimal getR38_between_zones_unmatched() {
		return r38_between_zones_unmatched;
	}
	public void setR38_between_zones_unmatched(BigDecimal r38_between_zones_unmatched) {
		this.r38_between_zones_unmatched = r38_between_zones_unmatched;
	}
	public BigDecimal getR38_net_pos_cap_charge() {
		return r38_net_pos_cap_charge;
	}
	public void setR38_net_pos_cap_charge(BigDecimal r38_net_pos_cap_charge) {
		this.r38_net_pos_cap_charge = r38_net_pos_cap_charge;
	}
	public String getR38_risk_cap_charge() {
		return r38_risk_cap_charge;
	}
	public void setR38_risk_cap_charge(String r38_risk_cap_charge) {
		this.r38_risk_cap_charge = r38_risk_cap_charge;
	}
	public BigDecimal getR38_capital_charge() {
		return r38_capital_charge;
	}
	public void setR38_capital_charge(BigDecimal r38_capital_charge) {
		this.r38_capital_charge = r38_capital_charge;
	}
	public Date getReport_submit_date() {
		return report_submit_date;
	}
	public void setReport_submit_date(Date report_submit_date) {
		this.report_submit_date = report_submit_date;
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
	public String getReport_code() {
		return report_code;
	}
	public void setReport_code(String report_code) {
		this.report_code = report_code;
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
	public B25_BASEL_RPT() {
		super();
	
	}


}
