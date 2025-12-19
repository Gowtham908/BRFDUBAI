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
@Table(name="BRF5A_SUMMARYTABLE")
public class BRF5_ENTITY {

	private String	r1_investment;
	private String	r1_security;
	private BigDecimal	r1_nominal;
	private BigDecimal	r1_units;
	private String	r1_country;
	private String	r1_ccy;
	private BigDecimal	r1_amt_total_security;
	private BigDecimal	r1_aed_equivalent;
	private BigDecimal	r1_logicfromcbs;
	private BigDecimal	r1_logicfromktp;
	private BigDecimal	r1_rating;
	private String	r1_ratingtype;
	private BigDecimal	r1_market_value;
	private String	r1_counterpartytype;
	private String	r1_validationformulasecurityidentifier;
	private String	r1_validationformulacountry;
	private String	r1_validationformularating;
	private String	r1_validationformulacounterparty;
	private String	r1_rowvalid;
	private String	r3_investment;
	private String	r3_security;
	private BigDecimal	r3_nominal;
	private BigDecimal	r3_units;
	private String	r3_country;
	private String	r3_ccy;
	private BigDecimal	r3_amt_total_security;
	private BigDecimal	r3_aed_equivalent;
	private BigDecimal	r3_logicfromcbs;
	private BigDecimal	r3_logicfromktp;
	private BigDecimal	r3_rating;
	private String	r3_ratingtype;
	private BigDecimal	r3_market_value;
	private String	r3_counterpartytype;
	private String	r3_validationformulasecurityidentifier;
	private String	r3_validationformulacountry;
	private String	r3_validationformularating;
	private String	r3_validationformulacounterparty;
	private String	r3_rowvalid;
	private String	r4_investment;
	private String	r4_security;
	private BigDecimal	r4_nominal;
	private BigDecimal	r4_units;
	private String	r4_country;
	private String	r4_ccy;
	private BigDecimal	r4_amt_total_security;
	private BigDecimal	r4_aed_equivalent;
	private BigDecimal	r4_logicfromcbs;
	private BigDecimal	r4_logicfromktp;
	private BigDecimal	r4_rating;
	private String	r4_ratingtype;
	private BigDecimal	r4_market_value;
	private String	r4_counterpartytype;
	private String	r4_validationformulasecurityidentifier;
	private String	r4_validationformulacountry;
	private String	r4_validationformularating;
	private String	r4_validationformulacounterparty;
	private String	r4_rowvalid;
	private String	r6_investment;
	private String	r6_security;
	private BigDecimal	r6_nominal;
	private BigDecimal	r6_units;
	private String	r6_country;
	private String	r6_ccy;
	private BigDecimal	r6_amt_total_security;
	private BigDecimal	r6_aed_equivalent;
	private BigDecimal	r6_logicfromcbs;
	private BigDecimal	r6_logicfromktp;
	private BigDecimal	r6_rating;
	private String	r6_ratingtype;
	private BigDecimal	r6_market_value;
	private String	r6_counterpartytype;
	private String	r6_validationformulasecurityidentifier;
	private String	r6_validationformulacountry;
	private String	r6_validationformularating;
	private String	r6_validationformulacounterparty;
	private String	r6_rowvalid;
	private String	r7_investment;
	private String	r7_security;
	private BigDecimal	r7_nominal;
	private BigDecimal	r7_units;
	private String	r7_country;
	private String	r7_ccy;
	private BigDecimal	r7_amt_total_security;
	private BigDecimal	r7_aed_equivalent;
	private BigDecimal	r7_logicfromcbs;
	private BigDecimal	r7_logicfromktp;
	private BigDecimal	r7_rating;
	private String	r7_ratingtype;
	private BigDecimal	r7_market_value;
	private String	r7_counterpartytype;
	private String	r7_validationformulasecurityidentifier;
	private String	r7_validationformulacountry;
	private String	r7_validationformularating;
	private String	r7_validationformulacounterparty;
	private String	r7_rowvalid;
	private String	r9_investment;
	private String	r9_security;
	private BigDecimal	r9_nominal;
	private BigDecimal	r9_units;
	private String	r9_country;
	private String	r9_ccy;
	private BigDecimal	r9_amt_total_security;
	private BigDecimal	r9_aed_equivalent;
	private BigDecimal	r9_logicfromcbs;
	private BigDecimal	r9_logicfromktp;
	private BigDecimal	r9_rating;
	private String	r9_ratingtype;
	private BigDecimal	r9_market_value;
	private String	r9_counterpartytype;
	private String	r9_validationformulasecurityidentifier;
	private String	r9_validationformulacountry;
	private String	r9_validationformularating;
	private String	r9_validationformulacounterparty;
	private String	r9_rowvalid;
	private String	r10_investment;
	private String	r10_security;
	private BigDecimal	r10_nominal;
	private BigDecimal	r10_units;
	private String	r10_country;
	private String	r10_ccy;
	private BigDecimal	r10_amt_total_security;
	private BigDecimal	r10_aed_equivalent;
	private BigDecimal	r10_logicfromcbs;
	private BigDecimal	r10_logicfromktp;
	private BigDecimal	r10_rating;
	private String	r10_ratingtype;
	private BigDecimal	r10_market_value;
	private String	r10_counterpartytype;
	private String	r10_validationformulasecurityidentifier;
	private String	r10_validationformulacountry;
	private String	r10_validationformularating;
	private String	r10_validationformulacounterparty;
	private String	r10_rowvalid;
	private String	r11_investment;
	private String	r11_security;
	private BigDecimal	r11_nominal;
	private BigDecimal	r11_units;
	private String	r11_country;
	private String	r11_ccy;
	private BigDecimal	r11_amt_total_security;
	private BigDecimal	r11_aed_equivalent;
	private BigDecimal	r11_logicfromcbs;
	private BigDecimal	r11_logicfromktp;
	private BigDecimal	r11_rating;
	private String	r11_ratingtype;
	private BigDecimal	r11_market_value;
	private String	r11_counterpartytype;
	private String	r11_validationformulasecurityidentifier;
	private String	r11_validationformulacountry;
	private String	r11_validationformularating;
	private String	r11_validationformulacounterparty;
	private String	r11_rowvalid;
	private String	r12_investment;
	private String	r12_security;
	private BigDecimal	r12_nominal;
	private BigDecimal	r12_units;
	private String	r12_country;
	private String	r12_ccy;
	private BigDecimal	r12_amt_total_security;
	private BigDecimal	r12_aed_equivalent;
	private BigDecimal	r12_logicfromcbs;
	private BigDecimal	r12_logicfromktp;
	private BigDecimal	r12_rating;
	private String	r12_ratingtype;
	private BigDecimal	r12_market_value;
	private String	r12_counterpartytype;
	private String	r12_validationformulasecurityidentifier;
	private String	r12_validationformulacountry;
	private String	r12_validationformularating;
	private String	r12_validationformulacounterparty;
	private String	r12_rowvalid;
	private String	r14_investment;
	private String	r14_security;
	private BigDecimal	r14_nominal;
	private BigDecimal	r14_units;
	private String	r14_country;
	private String	r14_ccy;
	private BigDecimal	r14_amt_total_security;
	private BigDecimal	r14_aed_equivalent;
	private BigDecimal	r14_logicfromcbs;
	private BigDecimal	r14_logicfromktp;
	private BigDecimal	r14_rating;
	private String	r14_ratingtype;
	private BigDecimal	r14_market_value;
	private String	r14_counterpartytype;
	private String	r14_validationformulasecurityidentifier;
	private String	r14_validationformulacountry;
	private String	r14_validationformularating;
	private String	r14_validationformulacounterparty;
	private String	r14_rowvalid;
	private String	r15_investment;
	private String	r15_security;
	private BigDecimal	r15_nominal;
	private BigDecimal	r15_units;
	private String	r15_country;
	private String	r15_ccy;
	private BigDecimal	r15_amt_total_security;
	private BigDecimal	r15_aed_equivalent;
	private BigDecimal	r15_logicfromcbs;
	private BigDecimal	r15_logicfromktp;
	private BigDecimal	r15_rating;
	private String	r15_ratingtype;
	private BigDecimal	r15_market_value;
	private String	r15_counterpartytype;
	private String	r15_validationformulasecurityidentifier;
	private String	r15_validationformulacountry;
	private String	r15_validationformularating;
	private String	r15_validationformulacounterparty;
	private String	r15_rowvalid;
	private String	r16_investment;
	private String	r16_security;
	private BigDecimal	r16_nominal;
	private BigDecimal	r16_units;
	private String	r16_country;
	private String	r16_ccy;
	private BigDecimal	r16_amt_total_security;
	private BigDecimal	r16_aed_equivalent;
	private BigDecimal	r16_logicfromcbs;
	private BigDecimal	r16_logicfromktp;
	private BigDecimal	r16_rating;
	private String	r16_ratingtype;
	private BigDecimal	r16_market_value;
	private String	r16_counterpartytype;
	private String	r16_validationformulasecurityidentifier;
	private String	r16_validationformulacountry;
	private String	r16_validationformularating;
	private String	r16_validationformulacounterparty;
	private String	r16_rowvalid;
	private String	r17_investment;
	private String	r17_security;
	private BigDecimal	r17_nominal;
	private BigDecimal	r17_units;
	private String	r17_country;
	private String	r17_ccy;
	private BigDecimal	r17_amt_total_security;
	private BigDecimal	r17_aed_equivalent;
	private BigDecimal	r17_logicfromcbs;
	private BigDecimal	r17_logicfromktp;
	private BigDecimal	r17_rating;
	private String	r17_ratingtype;
	private BigDecimal	r17_market_value;
	private String	r17_counterpartytype;
	private String	r17_validationformulasecurityidentifier;
	private String	r17_validationformulacountry;
	private String	r17_validationformularating;
	private String	r17_validationformulacounterparty;
	private String	r17_rowvalid;
	private String	r18_investment;
	private String	r18_security;
	private BigDecimal	r18_nominal;
	private BigDecimal	r18_units;
	private String	r18_country;
	private String	r18_ccy;
	private BigDecimal	r18_amt_total_security;
	private BigDecimal	r18_aed_equivalent;
	private BigDecimal	r18_logicfromcbs;
	private BigDecimal	r18_logicfromktp;
	private BigDecimal	r18_rating;
	private String	r18_ratingtype;
	private BigDecimal	r18_market_value;
	private String	r18_counterpartytype;
	private String	r18_validationformulasecurityidentifier;
	private String	r18_validationformulacountry;
	private String	r18_validationformularating;
	private String	r18_validationformulacounterparty;
	private String	r18_rowvalid;
	private String	r19_investment;
	private String	r19_security;
	private BigDecimal	r19_nominal;
	private BigDecimal	r19_units;
	private String	r19_country;
	private String	r19_ccy;
	private BigDecimal	r19_amt_total_security;
	private BigDecimal	r19_aed_equivalent;
	private BigDecimal	r19_logicfromcbs;
	private BigDecimal	r19_logicfromktp;
	private BigDecimal	r19_rating;
	private String	r19_ratingtype;
	private BigDecimal	r19_market_value;
	private String	r19_counterpartytype;
	private String	r19_validationformulasecurityidentifier;
	private String	r19_validationformulacountry;
	private String	r19_validationformularating;
	private String	r19_validationformulacounterparty;
	private String	r19_rowvalid;
	private String	r20_investment;
	private String	r20_security;
	private BigDecimal	r20_nominal;
	private BigDecimal	r20_units;
	private String	r20_country;
	private String	r20_ccy;
	private BigDecimal	r20_amt_total_security;
	private BigDecimal	r20_aed_equivalent;
	private BigDecimal	r20_logicfromcbs;
	private BigDecimal	r20_logicfromktp;
	private BigDecimal	r20_rating;
	private String	r20_ratingtype;
	private BigDecimal	r20_market_value;
	private String	r20_counterpartytype;
	private String	r20_validationformulasecurityidentifier;
	private String	r20_validationformulacountry;
	private String	r20_validationformularating;
	private String	r20_validationformulacounterparty;
	private String	r20_rowvalid;
	private String	r21_investment;
	private String	r21_security;
	private BigDecimal	r21_nominal;
	private BigDecimal	r21_units;
	private String	r21_country;
	private String	r21_ccy;
	private BigDecimal	r21_amt_total_security;
	private BigDecimal	r21_aed_equivalent;
	private BigDecimal	r21_logicfromcbs;
	private BigDecimal	r21_logicfromktp;
	private BigDecimal	r21_rating;
	private String	r21_ratingtype;
	private BigDecimal	r21_market_value;
	private String	r21_counterpartytype;
	private String	r21_validationformulasecurityidentifier;
	private String	r21_validationformulacountry;
	private String	r21_validationformularating;
	private String	r21_validationformulacounterparty;
	private String	r21_rowvalid;
	private String	r22_investment;
	private String	r22_security;
	private BigDecimal	r22_nominal;
	private BigDecimal	r22_units;
	private String	r22_country;
	private String	r22_ccy;
	private BigDecimal	r22_amt_total_security;
	private BigDecimal	r22_aed_equivalent;
	private BigDecimal	r22_logicfromcbs;
	private BigDecimal	r22_logicfromktp;
	private BigDecimal	r22_rating;
	private String	r22_ratingtype;
	private BigDecimal	r22_market_value;
	private String	r22_counterpartytype;
	private String	r22_validationformulasecurityidentifier;
	private String	r22_validationformulacountry;
	private String	r22_validationformularating;
	private String	r22_validationformulacounterparty;
	private String	r22_rowvalid;
	private String	r23_investment;
	private String	r23_security;
	private BigDecimal	r23_nominal;
	private BigDecimal	r23_units;
	private String	r23_country;
	private String	r23_ccy;
	private BigDecimal	r23_amt_total_security;
	private BigDecimal	r23_aed_equivalent;
	private BigDecimal	r23_logicfromcbs;
	private BigDecimal	r23_logicfromktp;
	private BigDecimal	r23_rating;
	private String	r23_ratingtype;
	private BigDecimal	r23_market_value;
	private String	r23_counterpartytype;
	private String	r23_validationformulasecurityidentifier;
	private String	r23_validationformulacountry;
	private String	r23_validationformularating;
	private String	r23_validationformulacounterparty;
	private String	r23_rowvalid;
	private String	r24_investment;
	private String	r24_security;
	private BigDecimal	r24_nominal;
	private BigDecimal	r24_units;
	private String	r24_country;
	private String	r24_ccy;
	private BigDecimal	r24_amt_total_security;
	private BigDecimal	r24_aed_equivalent;
	private BigDecimal	r24_logicfromcbs;
	private BigDecimal	r24_logicfromktp;
	private BigDecimal	r24_rating;
	private String	r24_ratingtype;
	private BigDecimal	r24_market_value;
	private String	r24_counterpartytype;
	private String	r24_validationformulasecurityidentifier;
	private String	r24_validationformulacountry;
	private String	r24_validationformularating;
	private String	r24_validationformulacounterparty;
	private String	r24_rowvalid;
	private String	r25_investment;
	private String	r25_security;
	private BigDecimal	r25_nominal;
	private BigDecimal	r25_units;
	private String	r25_country;
	private String	r25_ccy;
	private BigDecimal	r25_amt_total_security;
	private BigDecimal	r25_aed_equivalent;
	private BigDecimal	r25_logicfromcbs;
	private BigDecimal	r25_logicfromktp;
	private BigDecimal	r25_rating;
	private String	r25_ratingtype;
	private BigDecimal	r25_market_value;
	private String	r25_counterpartytype;
	private String	r25_validationformulasecurityidentifier;
	private String	r25_validationformulacountry;
	private String	r25_validationformularating;
	private String	r25_validationformulacounterparty;
	private String	r25_rowvalid;
	private String	r26_investment;
	private String	r26_security;
	private BigDecimal	r26_nominal;
	private BigDecimal	r26_units;
	private String	r26_country;
	private String	r26_ccy;
	private BigDecimal	r26_amt_total_security;
	private BigDecimal	r26_aed_equivalent;
	private BigDecimal	r26_logicfromcbs;
	private BigDecimal	r26_logicfromktp;
	private BigDecimal	r26_rating;
	private String	r26_ratingtype;
	private BigDecimal	r26_market_value;
	private String	r26_counterpartytype;
	private String	r26_validationformulasecurityidentifier;
	private String	r26_validationformulacountry;
	private String	r26_validationformularating;
	private String	r26_validationformulacounterparty;
	private String	r26_rowvalid;
	private String	r27_investment;
	private String	r27_security;
	private BigDecimal	r27_nominal;
	private BigDecimal	r27_units;
	private String	r27_country;
	private String	r27_ccy;
	private BigDecimal	r27_amt_total_security;
	private BigDecimal	r27_aed_equivalent;
	private BigDecimal	r27_logicfromcbs;
	private BigDecimal	r27_logicfromktp;
	private BigDecimal	r27_rating;
	private String	r27_ratingtype;
	private BigDecimal	r27_market_value;
	private String	r27_counterpartytype;
	private String	r27_validationformulasecurityidentifier;
	private String	r27_validationformulacountry;
	private String	r27_validationformularating;
	private String	r27_validationformulacounterparty;
	private String	r27_rowvalid;
	private String	r28_investment;
	private String	r28_security;
	private BigDecimal	r28_nominal;
	private BigDecimal	r28_units;
	private String	r28_country;
	private String	r28_ccy;
	private BigDecimal	r28_amt_total_security;
	private BigDecimal	r28_aed_equivalent;
	private BigDecimal	r28_logicfromcbs;
	private BigDecimal	r28_logicfromktp;
	private BigDecimal	r28_rating;
	private String	r28_ratingtype;
	private BigDecimal	r28_market_value;
	private String	r28_counterpartytype;
	private String	r28_validationformulasecurityidentifier;
	private String	r28_validationformulacountry;
	private String	r28_validationformularating;
	private String	r28_validationformulacounterparty;
	private String	r28_rowvalid;
	private String	r29_investment;
	private String	r29_security;
	private BigDecimal	r29_nominal;
	private BigDecimal	r29_units;
	private String	r29_country;
	private String	r29_ccy;
	private BigDecimal	r29_amt_total_security;
	private BigDecimal	r29_aed_equivalent;
	private BigDecimal	r29_logicfromcbs;
	private BigDecimal	r29_logicfromktp;
	private BigDecimal	r29_rating;
	private String	r29_ratingtype;
	private BigDecimal	r29_market_value;
	private String	r29_counterpartytype;
	private String	r29_validationformulasecurityidentifier;
	private String	r29_validationformulacountry;
	private String	r29_validationformularating;
	private String	r29_validationformulacounterparty;
	private String	r29_rowvalid;
	private String	r30_investment;
	private String	r30_security;
	private BigDecimal	r30_nominal;
	private BigDecimal	r30_units;
	private String	r30_country;
	private String	r30_ccy;
	private BigDecimal	r30_amt_total_security;
	private BigDecimal	r30_aed_equivalent;
	private BigDecimal	r30_logicfromcbs;
	private BigDecimal	r30_logicfromktp;
	private BigDecimal	r30_rating;
	private String	r30_ratingtype;
	private BigDecimal	r30_market_value;
	private String	r30_counterpartytype;
	private String	r30_validationformulasecurityidentifier;
	private String	r30_validationformulacountry;
	private String	r30_validationformularating;
	private String	r30_validationformulacounterparty;
	private String	r30_rowvalid;
	private String	r31_investment;
	private String	r31_security;
	private BigDecimal	r31_nominal;
	private BigDecimal	r31_units;
	private String	r31_country;
	private String	r31_ccy;
	private BigDecimal	r31_amt_total_security;
	private BigDecimal	r31_aed_equivalent;
	private BigDecimal	r31_logicfromcbs;
	private BigDecimal	r31_logicfromktp;
	private BigDecimal	r31_rating;
	private String	r31_ratingtype;
	private BigDecimal	r31_market_value;
	private String	r31_counterpartytype;
	private String	r31_validationformulasecurityidentifier;
	private String	r31_validationformulacountry;
	private String	r31_validationformularating;
	private String	r31_validationformulacounterparty;
	private String	r31_rowvalid;
	private String	r32_investment;
	private String	r32_security;
	private BigDecimal	r32_nominal;
	private BigDecimal	r32_units;
	private String	r32_country;
	private String	r32_ccy;
	private BigDecimal	r32_amt_total_security;
	private BigDecimal	r32_aed_equivalent;
	private BigDecimal	r32_logicfromcbs;
	private BigDecimal	r32_logicfromktp;
	private BigDecimal	r32_rating;
	private String	r32_ratingtype;
	private BigDecimal	r32_market_value;
	private String	r32_counterpartytype;
	private String	r32_validationformulasecurityidentifier;
	private String	r32_validationformulacountry;
	private String	r32_validationformularating;
	private String	r32_validationformulacounterparty;
	private String	r32_rowvalid;
	private String	r33_investment;
	private String	r33_security;
	private BigDecimal	r33_nominal;
	private BigDecimal	r33_units;
	private String	r33_country;
	private String	r33_ccy;
	private BigDecimal	r33_amt_total_security;
	private BigDecimal	r33_aed_equivalent;
	private BigDecimal	r33_logicfromcbs;
	private BigDecimal	r33_logicfromktp;
	private BigDecimal	r33_rating;
	private String	r33_ratingtype;
	private BigDecimal	r33_market_value;
	private String	r33_counterpartytype;
	private String	r33_validationformulasecurityidentifier;
	private String	r33_validationformulacountry;
	private String	r33_validationformularating;
	private String	r33_validationformulacounterparty;
	private String	r33_rowvalid;
	private String	r34_investment;
	private String	r34_security;
	private BigDecimal	r34_nominal;
	private BigDecimal	r34_units;
	private String	r34_country;
	private String	r34_ccy;
	private BigDecimal	r34_amt_total_security;
	private BigDecimal	r34_aed_equivalent;
	private BigDecimal	r34_logicfromcbs;
	private BigDecimal	r34_logicfromktp;
	private BigDecimal	r34_rating;
	private String	r34_ratingtype;
	private BigDecimal	r34_market_value;
	private String	r34_counterpartytype;
	private String	r34_validationformulasecurityidentifier;
	private String	r34_validationformulacountry;
	private String	r34_validationformularating;
	private String	r34_validationformulacounterparty;
	private String	r34_rowvalid;
	private String	r36_investment;
	private String	r36_security;
	private BigDecimal	r36_nominal;
	private BigDecimal	r36_units;
	private String	r36_country;
	private String	r36_ccy;
	private BigDecimal	r36_amt_total_security;
	private BigDecimal	r36_aed_equivalent;
	private BigDecimal	r36_logicfromcbs;
	private BigDecimal	r36_logicfromktp;
	private BigDecimal	r36_rating;
	private String	r36_ratingtype;
	private BigDecimal	r36_market_value;
	private String	r36_counterpartytype;
	private String	r36_validationformulasecurityidentifier;
	private String	r36_validationformulacountry;
	private String	r36_validationformularating;
	private String	r36_validationformulacounterparty;
	private String	r36_rowvalid;
	private String	r37_investment;
	private String	r37_security;
	private BigDecimal	r37_nominal;
	private BigDecimal	r37_units;
	private String	r37_country;
	private String	r37_ccy;
	private BigDecimal	r37_amt_total_security;
	private BigDecimal	r37_aed_equivalent;
	private BigDecimal	r37_logicfromcbs;
	private BigDecimal	r37_logicfromktp;
	private BigDecimal	r37_rating;
	private String	r37_ratingtype;
	private BigDecimal	r37_market_value;
	private String	r37_counterpartytype;
	private String	r37_validationformulasecurityidentifier;
	private String	r37_validationformulacountry;
	private String	r37_validationformularating;
	private String	r37_validationformulacounterparty;
	private String	r37_rowvalid;
	private String	r38_investment;
	private String	r38_security;
	private BigDecimal	r38_nominal;
	private BigDecimal	r38_units;
	private String	r38_country;
	private String	r38_ccy;
	private BigDecimal	r38_amt_total_security;
	private BigDecimal	r38_aed_equivalent;
	private BigDecimal	r38_logicfromcbs;
	private BigDecimal	r38_logicfromktp;
	private BigDecimal	r38_rating;
	private String	r38_ratingtype;
	private BigDecimal	r38_market_value;
	private String	r38_counterpartytype;
	private String	r38_validationformulasecurityidentifier;
	private String	r38_validationformulacountry;
	private String	r38_validationformularating;
	private String	r38_validationformulacounterparty;
	private String	r38_rowvalid;
	private String	r39_investment;
	private String	r39_security;
	private BigDecimal	r39_nominal;
	private BigDecimal	r39_units;
	private String	r39_country;
	private String	r39_ccy;
	private BigDecimal	r39_amt_total_security;
	private BigDecimal	r39_aed_equivalent;
	private BigDecimal	r39_logicfromcbs;
	private BigDecimal	r39_logicfromktp;
	private BigDecimal	r39_rating;
	private String	r39_ratingtype;
	private BigDecimal	r39_market_value;
	private String	r39_counterpartytype;
	private String	r39_validationformulasecurityidentifier;
	private String	r39_validationformulacountry;
	private String	r39_validationformularating;
	private String	r39_validationformulacounterparty;
	private String	r39_rowvalid;
	private String	r40_investment;
	private String	r40_security;
	private BigDecimal	r40_nominal;
	private BigDecimal	r40_units;
	private String	r40_country;
	private String	r40_ccy;
	private BigDecimal	r40_amt_total_security;
	private BigDecimal	r40_aed_equivalent;
	private BigDecimal	r40_logicfromcbs;
	private BigDecimal	r40_logicfromktp;
	private BigDecimal	r40_rating;
	private String	r40_ratingtype;
	private BigDecimal	r40_market_value;
	private String	r40_counterpartytype;
	private String	r40_validationformulasecurityidentifier;
	private String	r40_validationformulacountry;
	private String	r40_validationformularating;
	private String	r40_validationformulacounterparty;
	private String	r40_rowvalid;
	private String	r42_investment;
	private String	r42_security;
	private BigDecimal	r42_nominal;
	private BigDecimal	r42_units;
	private String	r42_country;
	private String	r42_ccy;
	private BigDecimal	r42_amt_total_security;
	private BigDecimal	r42_aed_equivalent;
	private BigDecimal	r42_logicfromcbs;
	private BigDecimal	r42_logicfromktp;
	private BigDecimal	r42_rating;
	private String	r42_ratingtype;
	private BigDecimal	r42_market_value;
	private String	r42_counterpartytype;
	private String	r42_validationformulasecurityidentifier;
	private String	r42_validationformulacountry;
	private String	r42_validationformularating;
	private String	r42_validationformulacounterparty;
	private String	r42_rowvalid;
	private String	r43_investment;
	private String	r43_security;
	private BigDecimal	r43_nominal;
	private BigDecimal	r43_units;
	private String	r43_country;
	private String	r43_ccy;
	private BigDecimal	r43_amt_total_security;
	private BigDecimal	r43_aed_equivalent;
	private BigDecimal	r43_logicfromcbs;
	private BigDecimal	r43_logicfromktp;
	private BigDecimal	r43_rating;
	private String	r43_ratingtype;
	private BigDecimal	r43_market_value;
	private String	r43_counterpartytype;
	private String	r43_validationformulasecurityidentifier;
	private String	r43_validationformulacountry;
	private String	r43_validationformularating;
	private String	r43_validationformulacounterparty;
	private String	r43_rowvalid;
	private String	r44_investment;
	private String	r44_security;
	private BigDecimal	r44_nominal;
	private BigDecimal	r44_units;
	private String	r44_country;
	private String	r44_ccy;
	private BigDecimal	r44_amt_total_security;
	private BigDecimal	r44_aed_equivalent;
	private BigDecimal	r44_logicfromcbs;
	private BigDecimal	r44_logicfromktp;
	private BigDecimal	r44_rating;
	private String	r44_ratingtype;
	private BigDecimal	r44_market_value;
	private String	r44_counterpartytype;
	private String	r44_validationformulasecurityidentifier;
	private String	r44_validationformulacountry;
	private String	r44_validationformularating;
	private String	r44_validationformulacounterparty;
	private String	r44_rowvalid;
	private String	r45_investment;
	private String	r45_security;
	private BigDecimal	r45_nominal;
	private BigDecimal	r45_units;
	private String	r45_country;
	private String	r45_ccy;
	private BigDecimal	r45_amt_total_security;
	private BigDecimal	r45_aed_equivalent;
	private BigDecimal	r45_logicfromcbs;
	private BigDecimal	r45_logicfromktp;
	private BigDecimal	r45_rating;
	private String	r45_ratingtype;
	private BigDecimal	r45_market_value;
	private String	r45_counterpartytype;
	private String	r45_validationformulasecurityidentifier;
	private String	r45_validationformulacountry;
	private String	r45_validationformularating;
	private String	r45_validationformulacounterparty;
	private String	r45_rowvalid;
	private String	r46_investment;
	private String	r46_security;
	private BigDecimal	r46_nominal;
	private BigDecimal	r46_units;
	private String	r46_country;
	private String	r46_ccy;
	private BigDecimal	r46_amt_total_security;
	private BigDecimal	r46_aed_equivalent;
	private BigDecimal	r46_logicfromcbs;
	private BigDecimal	r46_logicfromktp;
	private BigDecimal	r46_rating;
	private String	r46_ratingtype;
	private BigDecimal	r46_market_value;
	private String	r46_counterpartytype;
	private String	r46_validationformulasecurityidentifier;
	private String	r46_validationformulacountry;
	private String	r46_validationformularating;
	private String	r46_validationformulacounterparty;
	private String	r46_rowvalid;
	private String	r47_investment;
	private String	r47_security;
	private BigDecimal	r47_nominal;
	private BigDecimal	r47_units;
	private String	r47_country;
	private String	r47_ccy;
	private BigDecimal	r47_amt_total_security;
	private BigDecimal	r47_aed_equivalent;
	private BigDecimal	r47_logicfromcbs;
	private BigDecimal	r47_logicfromktp;
	private BigDecimal	r47_rating;
	private String	r47_ratingtype;
	private BigDecimal	r47_market_value;
	private String	r47_counterpartytype;
	private String	r47_validationformulasecurityidentifier;
	private String	r47_validationformulacountry;
	private String	r47_validationformularating;
	private String	r47_validationformulacounterparty;
	private String	r47_rowvalid;
	private String	r51_investment;
	private String	r51_security;
	private BigDecimal	r51_nominal;
	private BigDecimal	r51_units;
	private String	r51_country;
	private String	r51_ccy;
	private BigDecimal	r51_amt_total_security;
	private BigDecimal	r51_aed_equivalent;
	private BigDecimal	r51_logicfromcbs;
	private BigDecimal	r51_logicfromktp;
	private BigDecimal	r51_rating;
	private String	r51_ratingtype;
	private BigDecimal	r51_market_value;
	private String	r51_counterpartytype;
	private String	r51_validationformulasecurityidentifier;
	private String	r51_validationformulacountry;
	private String	r51_validationformularating;
	private String	r51_validationformulacounterparty;
	private String	r51_rowvalid;
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
	public String getR1_investment() {
		return r1_investment;
	}
	public void setR1_investment(String r1_investment) {
		this.r1_investment = r1_investment;
	}
	public String getR1_security() {
		return r1_security;
	}
	public void setR1_security(String r1_security) {
		this.r1_security = r1_security;
	}
	public BigDecimal getR1_nominal() {
		return r1_nominal;
	}
	public void setR1_nominal(BigDecimal r1_nominal) {
		this.r1_nominal = r1_nominal;
	}
	public BigDecimal getR1_units() {
		return r1_units;
	}
	public void setR1_units(BigDecimal r1_units) {
		this.r1_units = r1_units;
	}
	public String getR1_country() {
		return r1_country;
	}
	public void setR1_country(String r1_country) {
		this.r1_country = r1_country;
	}
	public String getR1_ccy() {
		return r1_ccy;
	}
	public void setR1_ccy(String r1_ccy) {
		this.r1_ccy = r1_ccy;
	}
	public BigDecimal getR1_amt_total_security() {
		return r1_amt_total_security;
	}
	public void setR1_amt_total_security(BigDecimal r1_amt_total_security) {
		this.r1_amt_total_security = r1_amt_total_security;
	}
	public BigDecimal getR1_aed_equivalent() {
		return r1_aed_equivalent;
	}
	public void setR1_aed_equivalent(BigDecimal r1_aed_equivalent) {
		this.r1_aed_equivalent = r1_aed_equivalent;
	}
	public BigDecimal getR1_logicfromcbs() {
		return r1_logicfromcbs;
	}
	public void setR1_logicfromcbs(BigDecimal r1_logicfromcbs) {
		this.r1_logicfromcbs = r1_logicfromcbs;
	}
	public BigDecimal getR1_logicfromktp() {
		return r1_logicfromktp;
	}
	public void setR1_logicfromktp(BigDecimal r1_logicfromktp) {
		this.r1_logicfromktp = r1_logicfromktp;
	}
	public BigDecimal getR1_rating() {
		return r1_rating;
	}
	public void setR1_rating(BigDecimal r1_rating) {
		this.r1_rating = r1_rating;
	}
	public String getR1_ratingtype() {
		return r1_ratingtype;
	}
	public void setR1_ratingtype(String r1_ratingtype) {
		this.r1_ratingtype = r1_ratingtype;
	}
	public BigDecimal getR1_market_value() {
		return r1_market_value;
	}
	public void setR1_market_value(BigDecimal r1_market_value) {
		this.r1_market_value = r1_market_value;
	}
	public String getR1_counterpartytype() {
		return r1_counterpartytype;
	}
	public void setR1_counterpartytype(String r1_counterpartytype) {
		this.r1_counterpartytype = r1_counterpartytype;
	}
	public String getR1_validationformulasecurityidentifier() {
		return r1_validationformulasecurityidentifier;
	}
	public void setR1_validationformulasecurityidentifier(String r1_validationformulasecurityidentifier) {
		this.r1_validationformulasecurityidentifier = r1_validationformulasecurityidentifier;
	}
	public String getR1_validationformulacountry() {
		return r1_validationformulacountry;
	}
	public void setR1_validationformulacountry(String r1_validationformulacountry) {
		this.r1_validationformulacountry = r1_validationformulacountry;
	}
	public String getR1_validationformularating() {
		return r1_validationformularating;
	}
	public void setR1_validationformularating(String r1_validationformularating) {
		this.r1_validationformularating = r1_validationformularating;
	}
	public String getR1_validationformulacounterparty() {
		return r1_validationformulacounterparty;
	}
	public void setR1_validationformulacounterparty(String r1_validationformulacounterparty) {
		this.r1_validationformulacounterparty = r1_validationformulacounterparty;
	}
	public String getR1_rowvalid() {
		return r1_rowvalid;
	}
	public void setR1_rowvalid(String r1_rowvalid) {
		this.r1_rowvalid = r1_rowvalid;
	}
	public String getR3_investment() {
		return r3_investment;
	}
	public void setR3_investment(String r3_investment) {
		this.r3_investment = r3_investment;
	}
	public String getR3_security() {
		return r3_security;
	}
	public void setR3_security(String r3_security) {
		this.r3_security = r3_security;
	}
	public BigDecimal getR3_nominal() {
		return r3_nominal;
	}
	public void setR3_nominal(BigDecimal r3_nominal) {
		this.r3_nominal = r3_nominal;
	}
	public BigDecimal getR3_units() {
		return r3_units;
	}
	public void setR3_units(BigDecimal r3_units) {
		this.r3_units = r3_units;
	}
	public String getR3_country() {
		return r3_country;
	}
	public void setR3_country(String r3_country) {
		this.r3_country = r3_country;
	}
	public String getR3_ccy() {
		return r3_ccy;
	}
	public void setR3_ccy(String r3_ccy) {
		this.r3_ccy = r3_ccy;
	}
	public BigDecimal getR3_amt_total_security() {
		return r3_amt_total_security;
	}
	public void setR3_amt_total_security(BigDecimal r3_amt_total_security) {
		this.r3_amt_total_security = r3_amt_total_security;
	}
	public BigDecimal getR3_aed_equivalent() {
		return r3_aed_equivalent;
	}
	public void setR3_aed_equivalent(BigDecimal r3_aed_equivalent) {
		this.r3_aed_equivalent = r3_aed_equivalent;
	}
	public BigDecimal getR3_logicfromcbs() {
		return r3_logicfromcbs;
	}
	public void setR3_logicfromcbs(BigDecimal r3_logicfromcbs) {
		this.r3_logicfromcbs = r3_logicfromcbs;
	}
	public BigDecimal getR3_logicfromktp() {
		return r3_logicfromktp;
	}
	public void setR3_logicfromktp(BigDecimal r3_logicfromktp) {
		this.r3_logicfromktp = r3_logicfromktp;
	}
	public BigDecimal getR3_rating() {
		return r3_rating;
	}
	public void setR3_rating(BigDecimal r3_rating) {
		this.r3_rating = r3_rating;
	}
	public String getR3_ratingtype() {
		return r3_ratingtype;
	}
	public void setR3_ratingtype(String r3_ratingtype) {
		this.r3_ratingtype = r3_ratingtype;
	}
	public BigDecimal getR3_market_value() {
		return r3_market_value;
	}
	public void setR3_market_value(BigDecimal r3_market_value) {
		this.r3_market_value = r3_market_value;
	}
	public String getR3_counterpartytype() {
		return r3_counterpartytype;
	}
	public void setR3_counterpartytype(String r3_counterpartytype) {
		this.r3_counterpartytype = r3_counterpartytype;
	}
	public String getR3_validationformulasecurityidentifier() {
		return r3_validationformulasecurityidentifier;
	}
	public void setR3_validationformulasecurityidentifier(String r3_validationformulasecurityidentifier) {
		this.r3_validationformulasecurityidentifier = r3_validationformulasecurityidentifier;
	}
	public String getR3_validationformulacountry() {
		return r3_validationformulacountry;
	}
	public void setR3_validationformulacountry(String r3_validationformulacountry) {
		this.r3_validationformulacountry = r3_validationformulacountry;
	}
	public String getR3_validationformularating() {
		return r3_validationformularating;
	}
	public void setR3_validationformularating(String r3_validationformularating) {
		this.r3_validationformularating = r3_validationformularating;
	}
	public String getR3_validationformulacounterparty() {
		return r3_validationformulacounterparty;
	}
	public void setR3_validationformulacounterparty(String r3_validationformulacounterparty) {
		this.r3_validationformulacounterparty = r3_validationformulacounterparty;
	}
	public String getR3_rowvalid() {
		return r3_rowvalid;
	}
	public void setR3_rowvalid(String r3_rowvalid) {
		this.r3_rowvalid = r3_rowvalid;
	}
	public String getR4_investment() {
		return r4_investment;
	}
	public void setR4_investment(String r4_investment) {
		this.r4_investment = r4_investment;
	}
	public String getR4_security() {
		return r4_security;
	}
	public void setR4_security(String r4_security) {
		this.r4_security = r4_security;
	}
	public BigDecimal getR4_nominal() {
		return r4_nominal;
	}
	public void setR4_nominal(BigDecimal r4_nominal) {
		this.r4_nominal = r4_nominal;
	}
	public BigDecimal getR4_units() {
		return r4_units;
	}
	public void setR4_units(BigDecimal r4_units) {
		this.r4_units = r4_units;
	}
	public String getR4_country() {
		return r4_country;
	}
	public void setR4_country(String r4_country) {
		this.r4_country = r4_country;
	}
	public String getR4_ccy() {
		return r4_ccy;
	}
	public void setR4_ccy(String r4_ccy) {
		this.r4_ccy = r4_ccy;
	}
	public BigDecimal getR4_amt_total_security() {
		return r4_amt_total_security;
	}
	public void setR4_amt_total_security(BigDecimal r4_amt_total_security) {
		this.r4_amt_total_security = r4_amt_total_security;
	}
	public BigDecimal getR4_aed_equivalent() {
		return r4_aed_equivalent;
	}
	public void setR4_aed_equivalent(BigDecimal r4_aed_equivalent) {
		this.r4_aed_equivalent = r4_aed_equivalent;
	}
	public BigDecimal getR4_logicfromcbs() {
		return r4_logicfromcbs;
	}
	public void setR4_logicfromcbs(BigDecimal r4_logicfromcbs) {
		this.r4_logicfromcbs = r4_logicfromcbs;
	}
	public BigDecimal getR4_logicfromktp() {
		return r4_logicfromktp;
	}
	public void setR4_logicfromktp(BigDecimal r4_logicfromktp) {
		this.r4_logicfromktp = r4_logicfromktp;
	}
	public BigDecimal getR4_rating() {
		return r4_rating;
	}
	public void setR4_rating(BigDecimal r4_rating) {
		this.r4_rating = r4_rating;
	}
	public String getR4_ratingtype() {
		return r4_ratingtype;
	}
	public void setR4_ratingtype(String r4_ratingtype) {
		this.r4_ratingtype = r4_ratingtype;
	}
	public BigDecimal getR4_market_value() {
		return r4_market_value;
	}
	public void setR4_market_value(BigDecimal r4_market_value) {
		this.r4_market_value = r4_market_value;
	}
	public String getR4_counterpartytype() {
		return r4_counterpartytype;
	}
	public void setR4_counterpartytype(String r4_counterpartytype) {
		this.r4_counterpartytype = r4_counterpartytype;
	}
	public String getR4_validationformulasecurityidentifier() {
		return r4_validationformulasecurityidentifier;
	}
	public void setR4_validationformulasecurityidentifier(String r4_validationformulasecurityidentifier) {
		this.r4_validationformulasecurityidentifier = r4_validationformulasecurityidentifier;
	}
	public String getR4_validationformulacountry() {
		return r4_validationformulacountry;
	}
	public void setR4_validationformulacountry(String r4_validationformulacountry) {
		this.r4_validationformulacountry = r4_validationformulacountry;
	}
	public String getR4_validationformularating() {
		return r4_validationformularating;
	}
	public void setR4_validationformularating(String r4_validationformularating) {
		this.r4_validationformularating = r4_validationformularating;
	}
	public String getR4_validationformulacounterparty() {
		return r4_validationformulacounterparty;
	}
	public void setR4_validationformulacounterparty(String r4_validationformulacounterparty) {
		this.r4_validationformulacounterparty = r4_validationformulacounterparty;
	}
	public String getR4_rowvalid() {
		return r4_rowvalid;
	}
	public void setR4_rowvalid(String r4_rowvalid) {
		this.r4_rowvalid = r4_rowvalid;
	}
	public String getR6_investment() {
		return r6_investment;
	}
	public void setR6_investment(String r6_investment) {
		this.r6_investment = r6_investment;
	}
	public String getR6_security() {
		return r6_security;
	}
	public void setR6_security(String r6_security) {
		this.r6_security = r6_security;
	}
	public BigDecimal getR6_nominal() {
		return r6_nominal;
	}
	public void setR6_nominal(BigDecimal r6_nominal) {
		this.r6_nominal = r6_nominal;
	}
	public BigDecimal getR6_units() {
		return r6_units;
	}
	public void setR6_units(BigDecimal r6_units) {
		this.r6_units = r6_units;
	}
	public String getR6_country() {
		return r6_country;
	}
	public void setR6_country(String r6_country) {
		this.r6_country = r6_country;
	}
	public String getR6_ccy() {
		return r6_ccy;
	}
	public void setR6_ccy(String r6_ccy) {
		this.r6_ccy = r6_ccy;
	}
	public BigDecimal getR6_amt_total_security() {
		return r6_amt_total_security;
	}
	public void setR6_amt_total_security(BigDecimal r6_amt_total_security) {
		this.r6_amt_total_security = r6_amt_total_security;
	}
	public BigDecimal getR6_aed_equivalent() {
		return r6_aed_equivalent;
	}
	public void setR6_aed_equivalent(BigDecimal r6_aed_equivalent) {
		this.r6_aed_equivalent = r6_aed_equivalent;
	}
	public BigDecimal getR6_logicfromcbs() {
		return r6_logicfromcbs;
	}
	public void setR6_logicfromcbs(BigDecimal r6_logicfromcbs) {
		this.r6_logicfromcbs = r6_logicfromcbs;
	}
	public BigDecimal getR6_logicfromktp() {
		return r6_logicfromktp;
	}
	public void setR6_logicfromktp(BigDecimal r6_logicfromktp) {
		this.r6_logicfromktp = r6_logicfromktp;
	}
	public BigDecimal getR6_rating() {
		return r6_rating;
	}
	public void setR6_rating(BigDecimal r6_rating) {
		this.r6_rating = r6_rating;
	}
	public String getR6_ratingtype() {
		return r6_ratingtype;
	}
	public void setR6_ratingtype(String r6_ratingtype) {
		this.r6_ratingtype = r6_ratingtype;
	}
	public BigDecimal getR6_market_value() {
		return r6_market_value;
	}
	public void setR6_market_value(BigDecimal r6_market_value) {
		this.r6_market_value = r6_market_value;
	}
	public String getR6_counterpartytype() {
		return r6_counterpartytype;
	}
	public void setR6_counterpartytype(String r6_counterpartytype) {
		this.r6_counterpartytype = r6_counterpartytype;
	}
	public String getR6_validationformulasecurityidentifier() {
		return r6_validationformulasecurityidentifier;
	}
	public void setR6_validationformulasecurityidentifier(String r6_validationformulasecurityidentifier) {
		this.r6_validationformulasecurityidentifier = r6_validationformulasecurityidentifier;
	}
	public String getR6_validationformulacountry() {
		return r6_validationformulacountry;
	}
	public void setR6_validationformulacountry(String r6_validationformulacountry) {
		this.r6_validationformulacountry = r6_validationformulacountry;
	}
	public String getR6_validationformularating() {
		return r6_validationformularating;
	}
	public void setR6_validationformularating(String r6_validationformularating) {
		this.r6_validationformularating = r6_validationformularating;
	}
	public String getR6_validationformulacounterparty() {
		return r6_validationformulacounterparty;
	}
	public void setR6_validationformulacounterparty(String r6_validationformulacounterparty) {
		this.r6_validationformulacounterparty = r6_validationformulacounterparty;
	}
	public String getR6_rowvalid() {
		return r6_rowvalid;
	}
	public void setR6_rowvalid(String r6_rowvalid) {
		this.r6_rowvalid = r6_rowvalid;
	}
	public String getR7_investment() {
		return r7_investment;
	}
	public void setR7_investment(String r7_investment) {
		this.r7_investment = r7_investment;
	}
	public String getR7_security() {
		return r7_security;
	}
	public void setR7_security(String r7_security) {
		this.r7_security = r7_security;
	}
	public BigDecimal getR7_nominal() {
		return r7_nominal;
	}
	public void setR7_nominal(BigDecimal r7_nominal) {
		this.r7_nominal = r7_nominal;
	}
	public BigDecimal getR7_units() {
		return r7_units;
	}
	public void setR7_units(BigDecimal r7_units) {
		this.r7_units = r7_units;
	}
	public String getR7_country() {
		return r7_country;
	}
	public void setR7_country(String r7_country) {
		this.r7_country = r7_country;
	}
	public String getR7_ccy() {
		return r7_ccy;
	}
	public void setR7_ccy(String r7_ccy) {
		this.r7_ccy = r7_ccy;
	}
	public BigDecimal getR7_amt_total_security() {
		return r7_amt_total_security;
	}
	public void setR7_amt_total_security(BigDecimal r7_amt_total_security) {
		this.r7_amt_total_security = r7_amt_total_security;
	}
	public BigDecimal getR7_aed_equivalent() {
		return r7_aed_equivalent;
	}
	public void setR7_aed_equivalent(BigDecimal r7_aed_equivalent) {
		this.r7_aed_equivalent = r7_aed_equivalent;
	}
	public BigDecimal getR7_logicfromcbs() {
		return r7_logicfromcbs;
	}
	public void setR7_logicfromcbs(BigDecimal r7_logicfromcbs) {
		this.r7_logicfromcbs = r7_logicfromcbs;
	}
	public BigDecimal getR7_logicfromktp() {
		return r7_logicfromktp;
	}
	public void setR7_logicfromktp(BigDecimal r7_logicfromktp) {
		this.r7_logicfromktp = r7_logicfromktp;
	}
	public BigDecimal getR7_rating() {
		return r7_rating;
	}
	public void setR7_rating(BigDecimal r7_rating) {
		this.r7_rating = r7_rating;
	}
	public String getR7_ratingtype() {
		return r7_ratingtype;
	}
	public void setR7_ratingtype(String r7_ratingtype) {
		this.r7_ratingtype = r7_ratingtype;
	}
	public BigDecimal getR7_market_value() {
		return r7_market_value;
	}
	public void setR7_market_value(BigDecimal r7_market_value) {
		this.r7_market_value = r7_market_value;
	}
	public String getR7_counterpartytype() {
		return r7_counterpartytype;
	}
	public void setR7_counterpartytype(String r7_counterpartytype) {
		this.r7_counterpartytype = r7_counterpartytype;
	}
	public String getR7_validationformulasecurityidentifier() {
		return r7_validationformulasecurityidentifier;
	}
	public void setR7_validationformulasecurityidentifier(String r7_validationformulasecurityidentifier) {
		this.r7_validationformulasecurityidentifier = r7_validationformulasecurityidentifier;
	}
	public String getR7_validationformulacountry() {
		return r7_validationformulacountry;
	}
	public void setR7_validationformulacountry(String r7_validationformulacountry) {
		this.r7_validationformulacountry = r7_validationformulacountry;
	}
	public String getR7_validationformularating() {
		return r7_validationformularating;
	}
	public void setR7_validationformularating(String r7_validationformularating) {
		this.r7_validationformularating = r7_validationformularating;
	}
	public String getR7_validationformulacounterparty() {
		return r7_validationformulacounterparty;
	}
	public void setR7_validationformulacounterparty(String r7_validationformulacounterparty) {
		this.r7_validationformulacounterparty = r7_validationformulacounterparty;
	}
	public String getR7_rowvalid() {
		return r7_rowvalid;
	}
	public void setR7_rowvalid(String r7_rowvalid) {
		this.r7_rowvalid = r7_rowvalid;
	}
	public String getR9_investment() {
		return r9_investment;
	}
	public void setR9_investment(String r9_investment) {
		this.r9_investment = r9_investment;
	}
	public String getR9_security() {
		return r9_security;
	}
	public void setR9_security(String r9_security) {
		this.r9_security = r9_security;
	}
	public BigDecimal getR9_nominal() {
		return r9_nominal;
	}
	public void setR9_nominal(BigDecimal r9_nominal) {
		this.r9_nominal = r9_nominal;
	}
	public BigDecimal getR9_units() {
		return r9_units;
	}
	public void setR9_units(BigDecimal r9_units) {
		this.r9_units = r9_units;
	}
	public String getR9_country() {
		return r9_country;
	}
	public void setR9_country(String r9_country) {
		this.r9_country = r9_country;
	}
	public String getR9_ccy() {
		return r9_ccy;
	}
	public void setR9_ccy(String r9_ccy) {
		this.r9_ccy = r9_ccy;
	}
	public BigDecimal getR9_amt_total_security() {
		return r9_amt_total_security;
	}
	public void setR9_amt_total_security(BigDecimal r9_amt_total_security) {
		this.r9_amt_total_security = r9_amt_total_security;
	}
	public BigDecimal getR9_aed_equivalent() {
		return r9_aed_equivalent;
	}
	public void setR9_aed_equivalent(BigDecimal r9_aed_equivalent) {
		this.r9_aed_equivalent = r9_aed_equivalent;
	}
	public BigDecimal getR9_logicfromcbs() {
		return r9_logicfromcbs;
	}
	public void setR9_logicfromcbs(BigDecimal r9_logicfromcbs) {
		this.r9_logicfromcbs = r9_logicfromcbs;
	}
	public BigDecimal getR9_logicfromktp() {
		return r9_logicfromktp;
	}
	public void setR9_logicfromktp(BigDecimal r9_logicfromktp) {
		this.r9_logicfromktp = r9_logicfromktp;
	}
	public BigDecimal getR9_rating() {
		return r9_rating;
	}
	public void setR9_rating(BigDecimal r9_rating) {
		this.r9_rating = r9_rating;
	}
	public String getR9_ratingtype() {
		return r9_ratingtype;
	}
	public void setR9_ratingtype(String r9_ratingtype) {
		this.r9_ratingtype = r9_ratingtype;
	}
	public BigDecimal getR9_market_value() {
		return r9_market_value;
	}
	public void setR9_market_value(BigDecimal r9_market_value) {
		this.r9_market_value = r9_market_value;
	}
	public String getR9_counterpartytype() {
		return r9_counterpartytype;
	}
	public void setR9_counterpartytype(String r9_counterpartytype) {
		this.r9_counterpartytype = r9_counterpartytype;
	}
	public String getR9_validationformulasecurityidentifier() {
		return r9_validationformulasecurityidentifier;
	}
	public void setR9_validationformulasecurityidentifier(String r9_validationformulasecurityidentifier) {
		this.r9_validationformulasecurityidentifier = r9_validationformulasecurityidentifier;
	}
	public String getR9_validationformulacountry() {
		return r9_validationformulacountry;
	}
	public void setR9_validationformulacountry(String r9_validationformulacountry) {
		this.r9_validationformulacountry = r9_validationformulacountry;
	}
	public String getR9_validationformularating() {
		return r9_validationformularating;
	}
	public void setR9_validationformularating(String r9_validationformularating) {
		this.r9_validationformularating = r9_validationformularating;
	}
	public String getR9_validationformulacounterparty() {
		return r9_validationformulacounterparty;
	}
	public void setR9_validationformulacounterparty(String r9_validationformulacounterparty) {
		this.r9_validationformulacounterparty = r9_validationformulacounterparty;
	}
	public String getR9_rowvalid() {
		return r9_rowvalid;
	}
	public void setR9_rowvalid(String r9_rowvalid) {
		this.r9_rowvalid = r9_rowvalid;
	}
	public String getR10_investment() {
		return r10_investment;
	}
	public void setR10_investment(String r10_investment) {
		this.r10_investment = r10_investment;
	}
	public String getR10_security() {
		return r10_security;
	}
	public void setR10_security(String r10_security) {
		this.r10_security = r10_security;
	}
	public BigDecimal getR10_nominal() {
		return r10_nominal;
	}
	public void setR10_nominal(BigDecimal r10_nominal) {
		this.r10_nominal = r10_nominal;
	}
	public BigDecimal getR10_units() {
		return r10_units;
	}
	public void setR10_units(BigDecimal r10_units) {
		this.r10_units = r10_units;
	}
	public String getR10_country() {
		return r10_country;
	}
	public void setR10_country(String r10_country) {
		this.r10_country = r10_country;
	}
	public String getR10_ccy() {
		return r10_ccy;
	}
	public void setR10_ccy(String r10_ccy) {
		this.r10_ccy = r10_ccy;
	}
	public BigDecimal getR10_amt_total_security() {
		return r10_amt_total_security;
	}
	public void setR10_amt_total_security(BigDecimal r10_amt_total_security) {
		this.r10_amt_total_security = r10_amt_total_security;
	}
	public BigDecimal getR10_aed_equivalent() {
		return r10_aed_equivalent;
	}
	public void setR10_aed_equivalent(BigDecimal r10_aed_equivalent) {
		this.r10_aed_equivalent = r10_aed_equivalent;
	}
	public BigDecimal getR10_logicfromcbs() {
		return r10_logicfromcbs;
	}
	public void setR10_logicfromcbs(BigDecimal r10_logicfromcbs) {
		this.r10_logicfromcbs = r10_logicfromcbs;
	}
	public BigDecimal getR10_logicfromktp() {
		return r10_logicfromktp;
	}
	public void setR10_logicfromktp(BigDecimal r10_logicfromktp) {
		this.r10_logicfromktp = r10_logicfromktp;
	}
	public BigDecimal getR10_rating() {
		return r10_rating;
	}
	public void setR10_rating(BigDecimal r10_rating) {
		this.r10_rating = r10_rating;
	}
	public String getR10_ratingtype() {
		return r10_ratingtype;
	}
	public void setR10_ratingtype(String r10_ratingtype) {
		this.r10_ratingtype = r10_ratingtype;
	}
	public BigDecimal getR10_market_value() {
		return r10_market_value;
	}
	public void setR10_market_value(BigDecimal r10_market_value) {
		this.r10_market_value = r10_market_value;
	}
	public String getR10_counterpartytype() {
		return r10_counterpartytype;
	}
	public void setR10_counterpartytype(String r10_counterpartytype) {
		this.r10_counterpartytype = r10_counterpartytype;
	}
	public String getR10_validationformulasecurityidentifier() {
		return r10_validationformulasecurityidentifier;
	}
	public void setR10_validationformulasecurityidentifier(String r10_validationformulasecurityidentifier) {
		this.r10_validationformulasecurityidentifier = r10_validationformulasecurityidentifier;
	}
	public String getR10_validationformulacountry() {
		return r10_validationformulacountry;
	}
	public void setR10_validationformulacountry(String r10_validationformulacountry) {
		this.r10_validationformulacountry = r10_validationformulacountry;
	}
	public String getR10_validationformularating() {
		return r10_validationformularating;
	}
	public void setR10_validationformularating(String r10_validationformularating) {
		this.r10_validationformularating = r10_validationformularating;
	}
	public String getR10_validationformulacounterparty() {
		return r10_validationformulacounterparty;
	}
	public void setR10_validationformulacounterparty(String r10_validationformulacounterparty) {
		this.r10_validationformulacounterparty = r10_validationformulacounterparty;
	}
	public String getR10_rowvalid() {
		return r10_rowvalid;
	}
	public void setR10_rowvalid(String r10_rowvalid) {
		this.r10_rowvalid = r10_rowvalid;
	}
	public String getR11_investment() {
		return r11_investment;
	}
	public void setR11_investment(String r11_investment) {
		this.r11_investment = r11_investment;
	}
	public String getR11_security() {
		return r11_security;
	}
	public void setR11_security(String r11_security) {
		this.r11_security = r11_security;
	}
	public BigDecimal getR11_nominal() {
		return r11_nominal;
	}
	public void setR11_nominal(BigDecimal r11_nominal) {
		this.r11_nominal = r11_nominal;
	}
	public BigDecimal getR11_units() {
		return r11_units;
	}
	public void setR11_units(BigDecimal r11_units) {
		this.r11_units = r11_units;
	}
	public String getR11_country() {
		return r11_country;
	}
	public void setR11_country(String r11_country) {
		this.r11_country = r11_country;
	}
	public String getR11_ccy() {
		return r11_ccy;
	}
	public void setR11_ccy(String r11_ccy) {
		this.r11_ccy = r11_ccy;
	}
	public BigDecimal getR11_amt_total_security() {
		return r11_amt_total_security;
	}
	public void setR11_amt_total_security(BigDecimal r11_amt_total_security) {
		this.r11_amt_total_security = r11_amt_total_security;
	}
	public BigDecimal getR11_aed_equivalent() {
		return r11_aed_equivalent;
	}
	public void setR11_aed_equivalent(BigDecimal r11_aed_equivalent) {
		this.r11_aed_equivalent = r11_aed_equivalent;
	}
	public BigDecimal getR11_logicfromcbs() {
		return r11_logicfromcbs;
	}
	public void setR11_logicfromcbs(BigDecimal r11_logicfromcbs) {
		this.r11_logicfromcbs = r11_logicfromcbs;
	}
	public BigDecimal getR11_logicfromktp() {
		return r11_logicfromktp;
	}
	public void setR11_logicfromktp(BigDecimal r11_logicfromktp) {
		this.r11_logicfromktp = r11_logicfromktp;
	}
	public BigDecimal getR11_rating() {
		return r11_rating;
	}
	public void setR11_rating(BigDecimal r11_rating) {
		this.r11_rating = r11_rating;
	}
	public String getR11_ratingtype() {
		return r11_ratingtype;
	}
	public void setR11_ratingtype(String r11_ratingtype) {
		this.r11_ratingtype = r11_ratingtype;
	}
	public BigDecimal getR11_market_value() {
		return r11_market_value;
	}
	public void setR11_market_value(BigDecimal r11_market_value) {
		this.r11_market_value = r11_market_value;
	}
	public String getR11_counterpartytype() {
		return r11_counterpartytype;
	}
	public void setR11_counterpartytype(String r11_counterpartytype) {
		this.r11_counterpartytype = r11_counterpartytype;
	}
	public String getR11_validationformulasecurityidentifier() {
		return r11_validationformulasecurityidentifier;
	}
	public void setR11_validationformulasecurityidentifier(String r11_validationformulasecurityidentifier) {
		this.r11_validationformulasecurityidentifier = r11_validationformulasecurityidentifier;
	}
	public String getR11_validationformulacountry() {
		return r11_validationformulacountry;
	}
	public void setR11_validationformulacountry(String r11_validationformulacountry) {
		this.r11_validationformulacountry = r11_validationformulacountry;
	}
	public String getR11_validationformularating() {
		return r11_validationformularating;
	}
	public void setR11_validationformularating(String r11_validationformularating) {
		this.r11_validationformularating = r11_validationformularating;
	}
	public String getR11_validationformulacounterparty() {
		return r11_validationformulacounterparty;
	}
	public void setR11_validationformulacounterparty(String r11_validationformulacounterparty) {
		this.r11_validationformulacounterparty = r11_validationformulacounterparty;
	}
	public String getR11_rowvalid() {
		return r11_rowvalid;
	}
	public void setR11_rowvalid(String r11_rowvalid) {
		this.r11_rowvalid = r11_rowvalid;
	}
	public String getR12_investment() {
		return r12_investment;
	}
	public void setR12_investment(String r12_investment) {
		this.r12_investment = r12_investment;
	}
	public String getR12_security() {
		return r12_security;
	}
	public void setR12_security(String r12_security) {
		this.r12_security = r12_security;
	}
	public BigDecimal getR12_nominal() {
		return r12_nominal;
	}
	public void setR12_nominal(BigDecimal r12_nominal) {
		this.r12_nominal = r12_nominal;
	}
	public BigDecimal getR12_units() {
		return r12_units;
	}
	public void setR12_units(BigDecimal r12_units) {
		this.r12_units = r12_units;
	}
	public String getR12_country() {
		return r12_country;
	}
	public void setR12_country(String r12_country) {
		this.r12_country = r12_country;
	}
	public String getR12_ccy() {
		return r12_ccy;
	}
	public void setR12_ccy(String r12_ccy) {
		this.r12_ccy = r12_ccy;
	}
	public BigDecimal getR12_amt_total_security() {
		return r12_amt_total_security;
	}
	public void setR12_amt_total_security(BigDecimal r12_amt_total_security) {
		this.r12_amt_total_security = r12_amt_total_security;
	}
	public BigDecimal getR12_aed_equivalent() {
		return r12_aed_equivalent;
	}
	public void setR12_aed_equivalent(BigDecimal r12_aed_equivalent) {
		this.r12_aed_equivalent = r12_aed_equivalent;
	}
	public BigDecimal getR12_logicfromcbs() {
		return r12_logicfromcbs;
	}
	public void setR12_logicfromcbs(BigDecimal r12_logicfromcbs) {
		this.r12_logicfromcbs = r12_logicfromcbs;
	}
	public BigDecimal getR12_logicfromktp() {
		return r12_logicfromktp;
	}
	public void setR12_logicfromktp(BigDecimal r12_logicfromktp) {
		this.r12_logicfromktp = r12_logicfromktp;
	}
	public BigDecimal getR12_rating() {
		return r12_rating;
	}
	public void setR12_rating(BigDecimal r12_rating) {
		this.r12_rating = r12_rating;
	}
	public String getR12_ratingtype() {
		return r12_ratingtype;
	}
	public void setR12_ratingtype(String r12_ratingtype) {
		this.r12_ratingtype = r12_ratingtype;
	}
	public BigDecimal getR12_market_value() {
		return r12_market_value;
	}
	public void setR12_market_value(BigDecimal r12_market_value) {
		this.r12_market_value = r12_market_value;
	}
	public String getR12_counterpartytype() {
		return r12_counterpartytype;
	}
	public void setR12_counterpartytype(String r12_counterpartytype) {
		this.r12_counterpartytype = r12_counterpartytype;
	}
	public String getR12_validationformulasecurityidentifier() {
		return r12_validationformulasecurityidentifier;
	}
	public void setR12_validationformulasecurityidentifier(String r12_validationformulasecurityidentifier) {
		this.r12_validationformulasecurityidentifier = r12_validationformulasecurityidentifier;
	}
	public String getR12_validationformulacountry() {
		return r12_validationformulacountry;
	}
	public void setR12_validationformulacountry(String r12_validationformulacountry) {
		this.r12_validationformulacountry = r12_validationformulacountry;
	}
	public String getR12_validationformularating() {
		return r12_validationformularating;
	}
	public void setR12_validationformularating(String r12_validationformularating) {
		this.r12_validationformularating = r12_validationformularating;
	}
	public String getR12_validationformulacounterparty() {
		return r12_validationformulacounterparty;
	}
	public void setR12_validationformulacounterparty(String r12_validationformulacounterparty) {
		this.r12_validationformulacounterparty = r12_validationformulacounterparty;
	}
	public String getR12_rowvalid() {
		return r12_rowvalid;
	}
	public void setR12_rowvalid(String r12_rowvalid) {
		this.r12_rowvalid = r12_rowvalid;
	}
	public String getR14_investment() {
		return r14_investment;
	}
	public void setR14_investment(String r14_investment) {
		this.r14_investment = r14_investment;
	}
	public String getR14_security() {
		return r14_security;
	}
	public void setR14_security(String r14_security) {
		this.r14_security = r14_security;
	}
	public BigDecimal getR14_nominal() {
		return r14_nominal;
	}
	public void setR14_nominal(BigDecimal r14_nominal) {
		this.r14_nominal = r14_nominal;
	}
	public BigDecimal getR14_units() {
		return r14_units;
	}
	public void setR14_units(BigDecimal r14_units) {
		this.r14_units = r14_units;
	}
	public String getR14_country() {
		return r14_country;
	}
	public void setR14_country(String r14_country) {
		this.r14_country = r14_country;
	}
	public String getR14_ccy() {
		return r14_ccy;
	}
	public void setR14_ccy(String r14_ccy) {
		this.r14_ccy = r14_ccy;
	}
	public BigDecimal getR14_amt_total_security() {
		return r14_amt_total_security;
	}
	public void setR14_amt_total_security(BigDecimal r14_amt_total_security) {
		this.r14_amt_total_security = r14_amt_total_security;
	}
	public BigDecimal getR14_aed_equivalent() {
		return r14_aed_equivalent;
	}
	public void setR14_aed_equivalent(BigDecimal r14_aed_equivalent) {
		this.r14_aed_equivalent = r14_aed_equivalent;
	}
	public BigDecimal getR14_logicfromcbs() {
		return r14_logicfromcbs;
	}
	public void setR14_logicfromcbs(BigDecimal r14_logicfromcbs) {
		this.r14_logicfromcbs = r14_logicfromcbs;
	}
	public BigDecimal getR14_logicfromktp() {
		return r14_logicfromktp;
	}
	public void setR14_logicfromktp(BigDecimal r14_logicfromktp) {
		this.r14_logicfromktp = r14_logicfromktp;
	}
	public BigDecimal getR14_rating() {
		return r14_rating;
	}
	public void setR14_rating(BigDecimal r14_rating) {
		this.r14_rating = r14_rating;
	}
	public String getR14_ratingtype() {
		return r14_ratingtype;
	}
	public void setR14_ratingtype(String r14_ratingtype) {
		this.r14_ratingtype = r14_ratingtype;
	}
	public BigDecimal getR14_market_value() {
		return r14_market_value;
	}
	public void setR14_market_value(BigDecimal r14_market_value) {
		this.r14_market_value = r14_market_value;
	}
	public String getR14_counterpartytype() {
		return r14_counterpartytype;
	}
	public void setR14_counterpartytype(String r14_counterpartytype) {
		this.r14_counterpartytype = r14_counterpartytype;
	}
	public String getR14_validationformulasecurityidentifier() {
		return r14_validationformulasecurityidentifier;
	}
	public void setR14_validationformulasecurityidentifier(String r14_validationformulasecurityidentifier) {
		this.r14_validationformulasecurityidentifier = r14_validationformulasecurityidentifier;
	}
	public String getR14_validationformulacountry() {
		return r14_validationformulacountry;
	}
	public void setR14_validationformulacountry(String r14_validationformulacountry) {
		this.r14_validationformulacountry = r14_validationformulacountry;
	}
	public String getR14_validationformularating() {
		return r14_validationformularating;
	}
	public void setR14_validationformularating(String r14_validationformularating) {
		this.r14_validationformularating = r14_validationformularating;
	}
	public String getR14_validationformulacounterparty() {
		return r14_validationformulacounterparty;
	}
	public void setR14_validationformulacounterparty(String r14_validationformulacounterparty) {
		this.r14_validationformulacounterparty = r14_validationformulacounterparty;
	}
	public String getR14_rowvalid() {
		return r14_rowvalid;
	}
	public void setR14_rowvalid(String r14_rowvalid) {
		this.r14_rowvalid = r14_rowvalid;
	}
	public String getR15_investment() {
		return r15_investment;
	}
	public void setR15_investment(String r15_investment) {
		this.r15_investment = r15_investment;
	}
	public String getR15_security() {
		return r15_security;
	}
	public void setR15_security(String r15_security) {
		this.r15_security = r15_security;
	}
	public BigDecimal getR15_nominal() {
		return r15_nominal;
	}
	public void setR15_nominal(BigDecimal r15_nominal) {
		this.r15_nominal = r15_nominal;
	}
	public BigDecimal getR15_units() {
		return r15_units;
	}
	public void setR15_units(BigDecimal r15_units) {
		this.r15_units = r15_units;
	}
	public String getR15_country() {
		return r15_country;
	}
	public void setR15_country(String r15_country) {
		this.r15_country = r15_country;
	}
	public String getR15_ccy() {
		return r15_ccy;
	}
	public void setR15_ccy(String r15_ccy) {
		this.r15_ccy = r15_ccy;
	}
	public BigDecimal getR15_amt_total_security() {
		return r15_amt_total_security;
	}
	public void setR15_amt_total_security(BigDecimal r15_amt_total_security) {
		this.r15_amt_total_security = r15_amt_total_security;
	}
	public BigDecimal getR15_aed_equivalent() {
		return r15_aed_equivalent;
	}
	public void setR15_aed_equivalent(BigDecimal r15_aed_equivalent) {
		this.r15_aed_equivalent = r15_aed_equivalent;
	}
	public BigDecimal getR15_logicfromcbs() {
		return r15_logicfromcbs;
	}
	public void setR15_logicfromcbs(BigDecimal r15_logicfromcbs) {
		this.r15_logicfromcbs = r15_logicfromcbs;
	}
	public BigDecimal getR15_logicfromktp() {
		return r15_logicfromktp;
	}
	public void setR15_logicfromktp(BigDecimal r15_logicfromktp) {
		this.r15_logicfromktp = r15_logicfromktp;
	}
	public BigDecimal getR15_rating() {
		return r15_rating;
	}
	public void setR15_rating(BigDecimal r15_rating) {
		this.r15_rating = r15_rating;
	}
	public String getR15_ratingtype() {
		return r15_ratingtype;
	}
	public void setR15_ratingtype(String r15_ratingtype) {
		this.r15_ratingtype = r15_ratingtype;
	}
	public BigDecimal getR15_market_value() {
		return r15_market_value;
	}
	public void setR15_market_value(BigDecimal r15_market_value) {
		this.r15_market_value = r15_market_value;
	}
	public String getR15_counterpartytype() {
		return r15_counterpartytype;
	}
	public void setR15_counterpartytype(String r15_counterpartytype) {
		this.r15_counterpartytype = r15_counterpartytype;
	}
	public String getR15_validationformulasecurityidentifier() {
		return r15_validationformulasecurityidentifier;
	}
	public void setR15_validationformulasecurityidentifier(String r15_validationformulasecurityidentifier) {
		this.r15_validationformulasecurityidentifier = r15_validationformulasecurityidentifier;
	}
	public String getR15_validationformulacountry() {
		return r15_validationformulacountry;
	}
	public void setR15_validationformulacountry(String r15_validationformulacountry) {
		this.r15_validationformulacountry = r15_validationformulacountry;
	}
	public String getR15_validationformularating() {
		return r15_validationformularating;
	}
	public void setR15_validationformularating(String r15_validationformularating) {
		this.r15_validationformularating = r15_validationformularating;
	}
	public String getR15_validationformulacounterparty() {
		return r15_validationformulacounterparty;
	}
	public void setR15_validationformulacounterparty(String r15_validationformulacounterparty) {
		this.r15_validationformulacounterparty = r15_validationformulacounterparty;
	}
	public String getR15_rowvalid() {
		return r15_rowvalid;
	}
	public void setR15_rowvalid(String r15_rowvalid) {
		this.r15_rowvalid = r15_rowvalid;
	}
	public String getR16_investment() {
		return r16_investment;
	}
	public void setR16_investment(String r16_investment) {
		this.r16_investment = r16_investment;
	}
	public String getR16_security() {
		return r16_security;
	}
	public void setR16_security(String r16_security) {
		this.r16_security = r16_security;
	}
	public BigDecimal getR16_nominal() {
		return r16_nominal;
	}
	public void setR16_nominal(BigDecimal r16_nominal) {
		this.r16_nominal = r16_nominal;
	}
	public BigDecimal getR16_units() {
		return r16_units;
	}
	public void setR16_units(BigDecimal r16_units) {
		this.r16_units = r16_units;
	}
	public String getR16_country() {
		return r16_country;
	}
	public void setR16_country(String r16_country) {
		this.r16_country = r16_country;
	}
	public String getR16_ccy() {
		return r16_ccy;
	}
	public void setR16_ccy(String r16_ccy) {
		this.r16_ccy = r16_ccy;
	}
	public BigDecimal getR16_amt_total_security() {
		return r16_amt_total_security;
	}
	public void setR16_amt_total_security(BigDecimal r16_amt_total_security) {
		this.r16_amt_total_security = r16_amt_total_security;
	}
	public BigDecimal getR16_aed_equivalent() {
		return r16_aed_equivalent;
	}
	public void setR16_aed_equivalent(BigDecimal r16_aed_equivalent) {
		this.r16_aed_equivalent = r16_aed_equivalent;
	}
	public BigDecimal getR16_logicfromcbs() {
		return r16_logicfromcbs;
	}
	public void setR16_logicfromcbs(BigDecimal r16_logicfromcbs) {
		this.r16_logicfromcbs = r16_logicfromcbs;
	}
	public BigDecimal getR16_logicfromktp() {
		return r16_logicfromktp;
	}
	public void setR16_logicfromktp(BigDecimal r16_logicfromktp) {
		this.r16_logicfromktp = r16_logicfromktp;
	}
	public BigDecimal getR16_rating() {
		return r16_rating;
	}
	public void setR16_rating(BigDecimal r16_rating) {
		this.r16_rating = r16_rating;
	}
	public String getR16_ratingtype() {
		return r16_ratingtype;
	}
	public void setR16_ratingtype(String r16_ratingtype) {
		this.r16_ratingtype = r16_ratingtype;
	}
	public BigDecimal getR16_market_value() {
		return r16_market_value;
	}
	public void setR16_market_value(BigDecimal r16_market_value) {
		this.r16_market_value = r16_market_value;
	}
	public String getR16_counterpartytype() {
		return r16_counterpartytype;
	}
	public void setR16_counterpartytype(String r16_counterpartytype) {
		this.r16_counterpartytype = r16_counterpartytype;
	}
	public String getR16_validationformulasecurityidentifier() {
		return r16_validationformulasecurityidentifier;
	}
	public void setR16_validationformulasecurityidentifier(String r16_validationformulasecurityidentifier) {
		this.r16_validationformulasecurityidentifier = r16_validationformulasecurityidentifier;
	}
	public String getR16_validationformulacountry() {
		return r16_validationformulacountry;
	}
	public void setR16_validationformulacountry(String r16_validationformulacountry) {
		this.r16_validationformulacountry = r16_validationformulacountry;
	}
	public String getR16_validationformularating() {
		return r16_validationformularating;
	}
	public void setR16_validationformularating(String r16_validationformularating) {
		this.r16_validationformularating = r16_validationformularating;
	}
	public String getR16_validationformulacounterparty() {
		return r16_validationformulacounterparty;
	}
	public void setR16_validationformulacounterparty(String r16_validationformulacounterparty) {
		this.r16_validationformulacounterparty = r16_validationformulacounterparty;
	}
	public String getR16_rowvalid() {
		return r16_rowvalid;
	}
	public void setR16_rowvalid(String r16_rowvalid) {
		this.r16_rowvalid = r16_rowvalid;
	}
	public String getR17_investment() {
		return r17_investment;
	}
	public void setR17_investment(String r17_investment) {
		this.r17_investment = r17_investment;
	}
	public String getR17_security() {
		return r17_security;
	}
	public void setR17_security(String r17_security) {
		this.r17_security = r17_security;
	}
	public BigDecimal getR17_nominal() {
		return r17_nominal;
	}
	public void setR17_nominal(BigDecimal r17_nominal) {
		this.r17_nominal = r17_nominal;
	}
	public BigDecimal getR17_units() {
		return r17_units;
	}
	public void setR17_units(BigDecimal r17_units) {
		this.r17_units = r17_units;
	}
	public String getR17_country() {
		return r17_country;
	}
	public void setR17_country(String r17_country) {
		this.r17_country = r17_country;
	}
	public String getR17_ccy() {
		return r17_ccy;
	}
	public void setR17_ccy(String r17_ccy) {
		this.r17_ccy = r17_ccy;
	}
	public BigDecimal getR17_amt_total_security() {
		return r17_amt_total_security;
	}
	public void setR17_amt_total_security(BigDecimal r17_amt_total_security) {
		this.r17_amt_total_security = r17_amt_total_security;
	}
	public BigDecimal getR17_aed_equivalent() {
		return r17_aed_equivalent;
	}
	public void setR17_aed_equivalent(BigDecimal r17_aed_equivalent) {
		this.r17_aed_equivalent = r17_aed_equivalent;
	}
	public BigDecimal getR17_logicfromcbs() {
		return r17_logicfromcbs;
	}
	public void setR17_logicfromcbs(BigDecimal r17_logicfromcbs) {
		this.r17_logicfromcbs = r17_logicfromcbs;
	}
	public BigDecimal getR17_logicfromktp() {
		return r17_logicfromktp;
	}
	public void setR17_logicfromktp(BigDecimal r17_logicfromktp) {
		this.r17_logicfromktp = r17_logicfromktp;
	}
	public BigDecimal getR17_rating() {
		return r17_rating;
	}
	public void setR17_rating(BigDecimal r17_rating) {
		this.r17_rating = r17_rating;
	}
	public String getR17_ratingtype() {
		return r17_ratingtype;
	}
	public void setR17_ratingtype(String r17_ratingtype) {
		this.r17_ratingtype = r17_ratingtype;
	}
	public BigDecimal getR17_market_value() {
		return r17_market_value;
	}
	public void setR17_market_value(BigDecimal r17_market_value) {
		this.r17_market_value = r17_market_value;
	}
	public String getR17_counterpartytype() {
		return r17_counterpartytype;
	}
	public void setR17_counterpartytype(String r17_counterpartytype) {
		this.r17_counterpartytype = r17_counterpartytype;
	}
	public String getR17_validationformulasecurityidentifier() {
		return r17_validationformulasecurityidentifier;
	}
	public void setR17_validationformulasecurityidentifier(String r17_validationformulasecurityidentifier) {
		this.r17_validationformulasecurityidentifier = r17_validationformulasecurityidentifier;
	}
	public String getR17_validationformulacountry() {
		return r17_validationformulacountry;
	}
	public void setR17_validationformulacountry(String r17_validationformulacountry) {
		this.r17_validationformulacountry = r17_validationformulacountry;
	}
	public String getR17_validationformularating() {
		return r17_validationformularating;
	}
	public void setR17_validationformularating(String r17_validationformularating) {
		this.r17_validationformularating = r17_validationformularating;
	}
	public String getR17_validationformulacounterparty() {
		return r17_validationformulacounterparty;
	}
	public void setR17_validationformulacounterparty(String r17_validationformulacounterparty) {
		this.r17_validationformulacounterparty = r17_validationformulacounterparty;
	}
	public String getR17_rowvalid() {
		return r17_rowvalid;
	}
	public void setR17_rowvalid(String r17_rowvalid) {
		this.r17_rowvalid = r17_rowvalid;
	}
	public String getR18_investment() {
		return r18_investment;
	}
	public void setR18_investment(String r18_investment) {
		this.r18_investment = r18_investment;
	}
	public String getR18_security() {
		return r18_security;
	}
	public void setR18_security(String r18_security) {
		this.r18_security = r18_security;
	}
	public BigDecimal getR18_nominal() {
		return r18_nominal;
	}
	public void setR18_nominal(BigDecimal r18_nominal) {
		this.r18_nominal = r18_nominal;
	}
	public BigDecimal getR18_units() {
		return r18_units;
	}
	public void setR18_units(BigDecimal r18_units) {
		this.r18_units = r18_units;
	}
	public String getR18_country() {
		return r18_country;
	}
	public void setR18_country(String r18_country) {
		this.r18_country = r18_country;
	}
	public String getR18_ccy() {
		return r18_ccy;
	}
	public void setR18_ccy(String r18_ccy) {
		this.r18_ccy = r18_ccy;
	}
	public BigDecimal getR18_amt_total_security() {
		return r18_amt_total_security;
	}
	public void setR18_amt_total_security(BigDecimal r18_amt_total_security) {
		this.r18_amt_total_security = r18_amt_total_security;
	}
	public BigDecimal getR18_aed_equivalent() {
		return r18_aed_equivalent;
	}
	public void setR18_aed_equivalent(BigDecimal r18_aed_equivalent) {
		this.r18_aed_equivalent = r18_aed_equivalent;
	}
	public BigDecimal getR18_logicfromcbs() {
		return r18_logicfromcbs;
	}
	public void setR18_logicfromcbs(BigDecimal r18_logicfromcbs) {
		this.r18_logicfromcbs = r18_logicfromcbs;
	}
	public BigDecimal getR18_logicfromktp() {
		return r18_logicfromktp;
	}
	public void setR18_logicfromktp(BigDecimal r18_logicfromktp) {
		this.r18_logicfromktp = r18_logicfromktp;
	}
	public BigDecimal getR18_rating() {
		return r18_rating;
	}
	public void setR18_rating(BigDecimal r18_rating) {
		this.r18_rating = r18_rating;
	}
	public String getR18_ratingtype() {
		return r18_ratingtype;
	}
	public void setR18_ratingtype(String r18_ratingtype) {
		this.r18_ratingtype = r18_ratingtype;
	}
	public BigDecimal getR18_market_value() {
		return r18_market_value;
	}
	public void setR18_market_value(BigDecimal r18_market_value) {
		this.r18_market_value = r18_market_value;
	}
	public String getR18_counterpartytype() {
		return r18_counterpartytype;
	}
	public void setR18_counterpartytype(String r18_counterpartytype) {
		this.r18_counterpartytype = r18_counterpartytype;
	}
	public String getR18_validationformulasecurityidentifier() {
		return r18_validationformulasecurityidentifier;
	}
	public void setR18_validationformulasecurityidentifier(String r18_validationformulasecurityidentifier) {
		this.r18_validationformulasecurityidentifier = r18_validationformulasecurityidentifier;
	}
	public String getR18_validationformulacountry() {
		return r18_validationformulacountry;
	}
	public void setR18_validationformulacountry(String r18_validationformulacountry) {
		this.r18_validationformulacountry = r18_validationformulacountry;
	}
	public String getR18_validationformularating() {
		return r18_validationformularating;
	}
	public void setR18_validationformularating(String r18_validationformularating) {
		this.r18_validationformularating = r18_validationformularating;
	}
	public String getR18_validationformulacounterparty() {
		return r18_validationformulacounterparty;
	}
	public void setR18_validationformulacounterparty(String r18_validationformulacounterparty) {
		this.r18_validationformulacounterparty = r18_validationformulacounterparty;
	}
	public String getR18_rowvalid() {
		return r18_rowvalid;
	}
	public void setR18_rowvalid(String r18_rowvalid) {
		this.r18_rowvalid = r18_rowvalid;
	}
	public String getR19_investment() {
		return r19_investment;
	}
	public void setR19_investment(String r19_investment) {
		this.r19_investment = r19_investment;
	}
	public String getR19_security() {
		return r19_security;
	}
	public void setR19_security(String r19_security) {
		this.r19_security = r19_security;
	}
	public BigDecimal getR19_nominal() {
		return r19_nominal;
	}
	public void setR19_nominal(BigDecimal r19_nominal) {
		this.r19_nominal = r19_nominal;
	}
	public BigDecimal getR19_units() {
		return r19_units;
	}
	public void setR19_units(BigDecimal r19_units) {
		this.r19_units = r19_units;
	}
	public String getR19_country() {
		return r19_country;
	}
	public void setR19_country(String r19_country) {
		this.r19_country = r19_country;
	}
	public String getR19_ccy() {
		return r19_ccy;
	}
	public void setR19_ccy(String r19_ccy) {
		this.r19_ccy = r19_ccy;
	}
	public BigDecimal getR19_amt_total_security() {
		return r19_amt_total_security;
	}
	public void setR19_amt_total_security(BigDecimal r19_amt_total_security) {
		this.r19_amt_total_security = r19_amt_total_security;
	}
	public BigDecimal getR19_aed_equivalent() {
		return r19_aed_equivalent;
	}
	public void setR19_aed_equivalent(BigDecimal r19_aed_equivalent) {
		this.r19_aed_equivalent = r19_aed_equivalent;
	}
	public BigDecimal getR19_logicfromcbs() {
		return r19_logicfromcbs;
	}
	public void setR19_logicfromcbs(BigDecimal r19_logicfromcbs) {
		this.r19_logicfromcbs = r19_logicfromcbs;
	}
	public BigDecimal getR19_logicfromktp() {
		return r19_logicfromktp;
	}
	public void setR19_logicfromktp(BigDecimal r19_logicfromktp) {
		this.r19_logicfromktp = r19_logicfromktp;
	}
	public BigDecimal getR19_rating() {
		return r19_rating;
	}
	public void setR19_rating(BigDecimal r19_rating) {
		this.r19_rating = r19_rating;
	}
	public String getR19_ratingtype() {
		return r19_ratingtype;
	}
	public void setR19_ratingtype(String r19_ratingtype) {
		this.r19_ratingtype = r19_ratingtype;
	}
	public BigDecimal getR19_market_value() {
		return r19_market_value;
	}
	public void setR19_market_value(BigDecimal r19_market_value) {
		this.r19_market_value = r19_market_value;
	}
	public String getR19_counterpartytype() {
		return r19_counterpartytype;
	}
	public void setR19_counterpartytype(String r19_counterpartytype) {
		this.r19_counterpartytype = r19_counterpartytype;
	}
	public String getR19_validationformulasecurityidentifier() {
		return r19_validationformulasecurityidentifier;
	}
	public void setR19_validationformulasecurityidentifier(String r19_validationformulasecurityidentifier) {
		this.r19_validationformulasecurityidentifier = r19_validationformulasecurityidentifier;
	}
	public String getR19_validationformulacountry() {
		return r19_validationformulacountry;
	}
	public void setR19_validationformulacountry(String r19_validationformulacountry) {
		this.r19_validationformulacountry = r19_validationformulacountry;
	}
	public String getR19_validationformularating() {
		return r19_validationformularating;
	}
	public void setR19_validationformularating(String r19_validationformularating) {
		this.r19_validationformularating = r19_validationformularating;
	}
	public String getR19_validationformulacounterparty() {
		return r19_validationformulacounterparty;
	}
	public void setR19_validationformulacounterparty(String r19_validationformulacounterparty) {
		this.r19_validationformulacounterparty = r19_validationformulacounterparty;
	}
	public String getR19_rowvalid() {
		return r19_rowvalid;
	}
	public void setR19_rowvalid(String r19_rowvalid) {
		this.r19_rowvalid = r19_rowvalid;
	}
	public String getR20_investment() {
		return r20_investment;
	}
	public void setR20_investment(String r20_investment) {
		this.r20_investment = r20_investment;
	}
	public String getR20_security() {
		return r20_security;
	}
	public void setR20_security(String r20_security) {
		this.r20_security = r20_security;
	}
	public BigDecimal getR20_nominal() {
		return r20_nominal;
	}
	public void setR20_nominal(BigDecimal r20_nominal) {
		this.r20_nominal = r20_nominal;
	}
	public BigDecimal getR20_units() {
		return r20_units;
	}
	public void setR20_units(BigDecimal r20_units) {
		this.r20_units = r20_units;
	}
	public String getR20_country() {
		return r20_country;
	}
	public void setR20_country(String r20_country) {
		this.r20_country = r20_country;
	}
	public String getR20_ccy() {
		return r20_ccy;
	}
	public void setR20_ccy(String r20_ccy) {
		this.r20_ccy = r20_ccy;
	}
	public BigDecimal getR20_amt_total_security() {
		return r20_amt_total_security;
	}
	public void setR20_amt_total_security(BigDecimal r20_amt_total_security) {
		this.r20_amt_total_security = r20_amt_total_security;
	}
	public BigDecimal getR20_aed_equivalent() {
		return r20_aed_equivalent;
	}
	public void setR20_aed_equivalent(BigDecimal r20_aed_equivalent) {
		this.r20_aed_equivalent = r20_aed_equivalent;
	}
	public BigDecimal getR20_logicfromcbs() {
		return r20_logicfromcbs;
	}
	public void setR20_logicfromcbs(BigDecimal r20_logicfromcbs) {
		this.r20_logicfromcbs = r20_logicfromcbs;
	}
	public BigDecimal getR20_logicfromktp() {
		return r20_logicfromktp;
	}
	public void setR20_logicfromktp(BigDecimal r20_logicfromktp) {
		this.r20_logicfromktp = r20_logicfromktp;
	}
	public BigDecimal getR20_rating() {
		return r20_rating;
	}
	public void setR20_rating(BigDecimal r20_rating) {
		this.r20_rating = r20_rating;
	}
	public String getR20_ratingtype() {
		return r20_ratingtype;
	}
	public void setR20_ratingtype(String r20_ratingtype) {
		this.r20_ratingtype = r20_ratingtype;
	}
	public BigDecimal getR20_market_value() {
		return r20_market_value;
	}
	public void setR20_market_value(BigDecimal r20_market_value) {
		this.r20_market_value = r20_market_value;
	}
	public String getR20_counterpartytype() {
		return r20_counterpartytype;
	}
	public void setR20_counterpartytype(String r20_counterpartytype) {
		this.r20_counterpartytype = r20_counterpartytype;
	}
	public String getR20_validationformulasecurityidentifier() {
		return r20_validationformulasecurityidentifier;
	}
	public void setR20_validationformulasecurityidentifier(String r20_validationformulasecurityidentifier) {
		this.r20_validationformulasecurityidentifier = r20_validationformulasecurityidentifier;
	}
	public String getR20_validationformulacountry() {
		return r20_validationformulacountry;
	}
	public void setR20_validationformulacountry(String r20_validationformulacountry) {
		this.r20_validationformulacountry = r20_validationformulacountry;
	}
	public String getR20_validationformularating() {
		return r20_validationformularating;
	}
	public void setR20_validationformularating(String r20_validationformularating) {
		this.r20_validationformularating = r20_validationformularating;
	}
	public String getR20_validationformulacounterparty() {
		return r20_validationformulacounterparty;
	}
	public void setR20_validationformulacounterparty(String r20_validationformulacounterparty) {
		this.r20_validationformulacounterparty = r20_validationformulacounterparty;
	}
	public String getR20_rowvalid() {
		return r20_rowvalid;
	}
	public void setR20_rowvalid(String r20_rowvalid) {
		this.r20_rowvalid = r20_rowvalid;
	}
	public String getR21_investment() {
		return r21_investment;
	}
	public void setR21_investment(String r21_investment) {
		this.r21_investment = r21_investment;
	}
	public String getR21_security() {
		return r21_security;
	}
	public void setR21_security(String r21_security) {
		this.r21_security = r21_security;
	}
	public BigDecimal getR21_nominal() {
		return r21_nominal;
	}
	public void setR21_nominal(BigDecimal r21_nominal) {
		this.r21_nominal = r21_nominal;
	}
	public BigDecimal getR21_units() {
		return r21_units;
	}
	public void setR21_units(BigDecimal r21_units) {
		this.r21_units = r21_units;
	}
	public String getR21_country() {
		return r21_country;
	}
	public void setR21_country(String r21_country) {
		this.r21_country = r21_country;
	}
	public String getR21_ccy() {
		return r21_ccy;
	}
	public void setR21_ccy(String r21_ccy) {
		this.r21_ccy = r21_ccy;
	}
	public BigDecimal getR21_amt_total_security() {
		return r21_amt_total_security;
	}
	public void setR21_amt_total_security(BigDecimal r21_amt_total_security) {
		this.r21_amt_total_security = r21_amt_total_security;
	}
	public BigDecimal getR21_aed_equivalent() {
		return r21_aed_equivalent;
	}
	public void setR21_aed_equivalent(BigDecimal r21_aed_equivalent) {
		this.r21_aed_equivalent = r21_aed_equivalent;
	}
	public BigDecimal getR21_logicfromcbs() {
		return r21_logicfromcbs;
	}
	public void setR21_logicfromcbs(BigDecimal r21_logicfromcbs) {
		this.r21_logicfromcbs = r21_logicfromcbs;
	}
	public BigDecimal getR21_logicfromktp() {
		return r21_logicfromktp;
	}
	public void setR21_logicfromktp(BigDecimal r21_logicfromktp) {
		this.r21_logicfromktp = r21_logicfromktp;
	}
	public BigDecimal getR21_rating() {
		return r21_rating;
	}
	public void setR21_rating(BigDecimal r21_rating) {
		this.r21_rating = r21_rating;
	}
	public String getR21_ratingtype() {
		return r21_ratingtype;
	}
	public void setR21_ratingtype(String r21_ratingtype) {
		this.r21_ratingtype = r21_ratingtype;
	}
	public BigDecimal getR21_market_value() {
		return r21_market_value;
	}
	public void setR21_market_value(BigDecimal r21_market_value) {
		this.r21_market_value = r21_market_value;
	}
	public String getR21_counterpartytype() {
		return r21_counterpartytype;
	}
	public void setR21_counterpartytype(String r21_counterpartytype) {
		this.r21_counterpartytype = r21_counterpartytype;
	}
	public String getR21_validationformulasecurityidentifier() {
		return r21_validationformulasecurityidentifier;
	}
	public void setR21_validationformulasecurityidentifier(String r21_validationformulasecurityidentifier) {
		this.r21_validationformulasecurityidentifier = r21_validationformulasecurityidentifier;
	}
	public String getR21_validationformulacountry() {
		return r21_validationformulacountry;
	}
	public void setR21_validationformulacountry(String r21_validationformulacountry) {
		this.r21_validationformulacountry = r21_validationformulacountry;
	}
	public String getR21_validationformularating() {
		return r21_validationformularating;
	}
	public void setR21_validationformularating(String r21_validationformularating) {
		this.r21_validationformularating = r21_validationformularating;
	}
	public String getR21_validationformulacounterparty() {
		return r21_validationformulacounterparty;
	}
	public void setR21_validationformulacounterparty(String r21_validationformulacounterparty) {
		this.r21_validationformulacounterparty = r21_validationformulacounterparty;
	}
	public String getR21_rowvalid() {
		return r21_rowvalid;
	}
	public void setR21_rowvalid(String r21_rowvalid) {
		this.r21_rowvalid = r21_rowvalid;
	}
	public String getR22_investment() {
		return r22_investment;
	}
	public void setR22_investment(String r22_investment) {
		this.r22_investment = r22_investment;
	}
	public String getR22_security() {
		return r22_security;
	}
	public void setR22_security(String r22_security) {
		this.r22_security = r22_security;
	}
	public BigDecimal getR22_nominal() {
		return r22_nominal;
	}
	public void setR22_nominal(BigDecimal r22_nominal) {
		this.r22_nominal = r22_nominal;
	}
	public BigDecimal getR22_units() {
		return r22_units;
	}
	public void setR22_units(BigDecimal r22_units) {
		this.r22_units = r22_units;
	}
	public String getR22_country() {
		return r22_country;
	}
	public void setR22_country(String r22_country) {
		this.r22_country = r22_country;
	}
	public String getR22_ccy() {
		return r22_ccy;
	}
	public void setR22_ccy(String r22_ccy) {
		this.r22_ccy = r22_ccy;
	}
	public BigDecimal getR22_amt_total_security() {
		return r22_amt_total_security;
	}
	public void setR22_amt_total_security(BigDecimal r22_amt_total_security) {
		this.r22_amt_total_security = r22_amt_total_security;
	}
	public BigDecimal getR22_aed_equivalent() {
		return r22_aed_equivalent;
	}
	public void setR22_aed_equivalent(BigDecimal r22_aed_equivalent) {
		this.r22_aed_equivalent = r22_aed_equivalent;
	}
	public BigDecimal getR22_logicfromcbs() {
		return r22_logicfromcbs;
	}
	public void setR22_logicfromcbs(BigDecimal r22_logicfromcbs) {
		this.r22_logicfromcbs = r22_logicfromcbs;
	}
	public BigDecimal getR22_logicfromktp() {
		return r22_logicfromktp;
	}
	public void setR22_logicfromktp(BigDecimal r22_logicfromktp) {
		this.r22_logicfromktp = r22_logicfromktp;
	}
	public BigDecimal getR22_rating() {
		return r22_rating;
	}
	public void setR22_rating(BigDecimal r22_rating) {
		this.r22_rating = r22_rating;
	}
	public String getR22_ratingtype() {
		return r22_ratingtype;
	}
	public void setR22_ratingtype(String r22_ratingtype) {
		this.r22_ratingtype = r22_ratingtype;
	}
	public BigDecimal getR22_market_value() {
		return r22_market_value;
	}
	public void setR22_market_value(BigDecimal r22_market_value) {
		this.r22_market_value = r22_market_value;
	}
	public String getR22_counterpartytype() {
		return r22_counterpartytype;
	}
	public void setR22_counterpartytype(String r22_counterpartytype) {
		this.r22_counterpartytype = r22_counterpartytype;
	}
	public String getR22_validationformulasecurityidentifier() {
		return r22_validationformulasecurityidentifier;
	}
	public void setR22_validationformulasecurityidentifier(String r22_validationformulasecurityidentifier) {
		this.r22_validationformulasecurityidentifier = r22_validationformulasecurityidentifier;
	}
	public String getR22_validationformulacountry() {
		return r22_validationformulacountry;
	}
	public void setR22_validationformulacountry(String r22_validationformulacountry) {
		this.r22_validationformulacountry = r22_validationformulacountry;
	}
	public String getR22_validationformularating() {
		return r22_validationformularating;
	}
	public void setR22_validationformularating(String r22_validationformularating) {
		this.r22_validationformularating = r22_validationformularating;
	}
	public String getR22_validationformulacounterparty() {
		return r22_validationformulacounterparty;
	}
	public void setR22_validationformulacounterparty(String r22_validationformulacounterparty) {
		this.r22_validationformulacounterparty = r22_validationformulacounterparty;
	}
	public String getR22_rowvalid() {
		return r22_rowvalid;
	}
	public void setR22_rowvalid(String r22_rowvalid) {
		this.r22_rowvalid = r22_rowvalid;
	}
	public String getR23_investment() {
		return r23_investment;
	}
	public void setR23_investment(String r23_investment) {
		this.r23_investment = r23_investment;
	}
	public String getR23_security() {
		return r23_security;
	}
	public void setR23_security(String r23_security) {
		this.r23_security = r23_security;
	}
	public BigDecimal getR23_nominal() {
		return r23_nominal;
	}
	public void setR23_nominal(BigDecimal r23_nominal) {
		this.r23_nominal = r23_nominal;
	}
	public BigDecimal getR23_units() {
		return r23_units;
	}
	public void setR23_units(BigDecimal r23_units) {
		this.r23_units = r23_units;
	}
	public String getR23_country() {
		return r23_country;
	}
	public void setR23_country(String r23_country) {
		this.r23_country = r23_country;
	}
	public String getR23_ccy() {
		return r23_ccy;
	}
	public void setR23_ccy(String r23_ccy) {
		this.r23_ccy = r23_ccy;
	}
	public BigDecimal getR23_amt_total_security() {
		return r23_amt_total_security;
	}
	public void setR23_amt_total_security(BigDecimal r23_amt_total_security) {
		this.r23_amt_total_security = r23_amt_total_security;
	}
	public BigDecimal getR23_aed_equivalent() {
		return r23_aed_equivalent;
	}
	public void setR23_aed_equivalent(BigDecimal r23_aed_equivalent) {
		this.r23_aed_equivalent = r23_aed_equivalent;
	}
	public BigDecimal getR23_logicfromcbs() {
		return r23_logicfromcbs;
	}
	public void setR23_logicfromcbs(BigDecimal r23_logicfromcbs) {
		this.r23_logicfromcbs = r23_logicfromcbs;
	}
	public BigDecimal getR23_logicfromktp() {
		return r23_logicfromktp;
	}
	public void setR23_logicfromktp(BigDecimal r23_logicfromktp) {
		this.r23_logicfromktp = r23_logicfromktp;
	}
	public BigDecimal getR23_rating() {
		return r23_rating;
	}
	public void setR23_rating(BigDecimal r23_rating) {
		this.r23_rating = r23_rating;
	}
	public String getR23_ratingtype() {
		return r23_ratingtype;
	}
	public void setR23_ratingtype(String r23_ratingtype) {
		this.r23_ratingtype = r23_ratingtype;
	}
	public BigDecimal getR23_market_value() {
		return r23_market_value;
	}
	public void setR23_market_value(BigDecimal r23_market_value) {
		this.r23_market_value = r23_market_value;
	}
	public String getR23_counterpartytype() {
		return r23_counterpartytype;
	}
	public void setR23_counterpartytype(String r23_counterpartytype) {
		this.r23_counterpartytype = r23_counterpartytype;
	}
	public String getR23_validationformulasecurityidentifier() {
		return r23_validationformulasecurityidentifier;
	}
	public void setR23_validationformulasecurityidentifier(String r23_validationformulasecurityidentifier) {
		this.r23_validationformulasecurityidentifier = r23_validationformulasecurityidentifier;
	}
	public String getR23_validationformulacountry() {
		return r23_validationformulacountry;
	}
	public void setR23_validationformulacountry(String r23_validationformulacountry) {
		this.r23_validationformulacountry = r23_validationformulacountry;
	}
	public String getR23_validationformularating() {
		return r23_validationformularating;
	}
	public void setR23_validationformularating(String r23_validationformularating) {
		this.r23_validationformularating = r23_validationformularating;
	}
	public String getR23_validationformulacounterparty() {
		return r23_validationformulacounterparty;
	}
	public void setR23_validationformulacounterparty(String r23_validationformulacounterparty) {
		this.r23_validationformulacounterparty = r23_validationformulacounterparty;
	}
	public String getR23_rowvalid() {
		return r23_rowvalid;
	}
	public void setR23_rowvalid(String r23_rowvalid) {
		this.r23_rowvalid = r23_rowvalid;
	}
	public String getR24_investment() {
		return r24_investment;
	}
	public void setR24_investment(String r24_investment) {
		this.r24_investment = r24_investment;
	}
	public String getR24_security() {
		return r24_security;
	}
	public void setR24_security(String r24_security) {
		this.r24_security = r24_security;
	}
	public BigDecimal getR24_nominal() {
		return r24_nominal;
	}
	public void setR24_nominal(BigDecimal r24_nominal) {
		this.r24_nominal = r24_nominal;
	}
	public BigDecimal getR24_units() {
		return r24_units;
	}
	public void setR24_units(BigDecimal r24_units) {
		this.r24_units = r24_units;
	}
	public String getR24_country() {
		return r24_country;
	}
	public void setR24_country(String r24_country) {
		this.r24_country = r24_country;
	}
	public String getR24_ccy() {
		return r24_ccy;
	}
	public void setR24_ccy(String r24_ccy) {
		this.r24_ccy = r24_ccy;
	}
	public BigDecimal getR24_amt_total_security() {
		return r24_amt_total_security;
	}
	public void setR24_amt_total_security(BigDecimal r24_amt_total_security) {
		this.r24_amt_total_security = r24_amt_total_security;
	}
	public BigDecimal getR24_aed_equivalent() {
		return r24_aed_equivalent;
	}
	public void setR24_aed_equivalent(BigDecimal r24_aed_equivalent) {
		this.r24_aed_equivalent = r24_aed_equivalent;
	}
	public BigDecimal getR24_logicfromcbs() {
		return r24_logicfromcbs;
	}
	public void setR24_logicfromcbs(BigDecimal r24_logicfromcbs) {
		this.r24_logicfromcbs = r24_logicfromcbs;
	}
	public BigDecimal getR24_logicfromktp() {
		return r24_logicfromktp;
	}
	public void setR24_logicfromktp(BigDecimal r24_logicfromktp) {
		this.r24_logicfromktp = r24_logicfromktp;
	}
	public BigDecimal getR24_rating() {
		return r24_rating;
	}
	public void setR24_rating(BigDecimal r24_rating) {
		this.r24_rating = r24_rating;
	}
	public String getR24_ratingtype() {
		return r24_ratingtype;
	}
	public void setR24_ratingtype(String r24_ratingtype) {
		this.r24_ratingtype = r24_ratingtype;
	}
	public BigDecimal getR24_market_value() {
		return r24_market_value;
	}
	public void setR24_market_value(BigDecimal r24_market_value) {
		this.r24_market_value = r24_market_value;
	}
	public String getR24_counterpartytype() {
		return r24_counterpartytype;
	}
	public void setR24_counterpartytype(String r24_counterpartytype) {
		this.r24_counterpartytype = r24_counterpartytype;
	}
	public String getR24_validationformulasecurityidentifier() {
		return r24_validationformulasecurityidentifier;
	}
	public void setR24_validationformulasecurityidentifier(String r24_validationformulasecurityidentifier) {
		this.r24_validationformulasecurityidentifier = r24_validationformulasecurityidentifier;
	}
	public String getR24_validationformulacountry() {
		return r24_validationformulacountry;
	}
	public void setR24_validationformulacountry(String r24_validationformulacountry) {
		this.r24_validationformulacountry = r24_validationformulacountry;
	}
	public String getR24_validationformularating() {
		return r24_validationformularating;
	}
	public void setR24_validationformularating(String r24_validationformularating) {
		this.r24_validationformularating = r24_validationformularating;
	}
	public String getR24_validationformulacounterparty() {
		return r24_validationformulacounterparty;
	}
	public void setR24_validationformulacounterparty(String r24_validationformulacounterparty) {
		this.r24_validationformulacounterparty = r24_validationformulacounterparty;
	}
	public String getR24_rowvalid() {
		return r24_rowvalid;
	}
	public void setR24_rowvalid(String r24_rowvalid) {
		this.r24_rowvalid = r24_rowvalid;
	}
	public String getR25_investment() {
		return r25_investment;
	}
	public void setR25_investment(String r25_investment) {
		this.r25_investment = r25_investment;
	}
	public String getR25_security() {
		return r25_security;
	}
	public void setR25_security(String r25_security) {
		this.r25_security = r25_security;
	}
	public BigDecimal getR25_nominal() {
		return r25_nominal;
	}
	public void setR25_nominal(BigDecimal r25_nominal) {
		this.r25_nominal = r25_nominal;
	}
	public BigDecimal getR25_units() {
		return r25_units;
	}
	public void setR25_units(BigDecimal r25_units) {
		this.r25_units = r25_units;
	}
	public String getR25_country() {
		return r25_country;
	}
	public void setR25_country(String r25_country) {
		this.r25_country = r25_country;
	}
	public String getR25_ccy() {
		return r25_ccy;
	}
	public void setR25_ccy(String r25_ccy) {
		this.r25_ccy = r25_ccy;
	}
	public BigDecimal getR25_amt_total_security() {
		return r25_amt_total_security;
	}
	public void setR25_amt_total_security(BigDecimal r25_amt_total_security) {
		this.r25_amt_total_security = r25_amt_total_security;
	}
	public BigDecimal getR25_aed_equivalent() {
		return r25_aed_equivalent;
	}
	public void setR25_aed_equivalent(BigDecimal r25_aed_equivalent) {
		this.r25_aed_equivalent = r25_aed_equivalent;
	}
	public BigDecimal getR25_logicfromcbs() {
		return r25_logicfromcbs;
	}
	public void setR25_logicfromcbs(BigDecimal r25_logicfromcbs) {
		this.r25_logicfromcbs = r25_logicfromcbs;
	}
	public BigDecimal getR25_logicfromktp() {
		return r25_logicfromktp;
	}
	public void setR25_logicfromktp(BigDecimal r25_logicfromktp) {
		this.r25_logicfromktp = r25_logicfromktp;
	}
	public BigDecimal getR25_rating() {
		return r25_rating;
	}
	public void setR25_rating(BigDecimal r25_rating) {
		this.r25_rating = r25_rating;
	}
	public String getR25_ratingtype() {
		return r25_ratingtype;
	}
	public void setR25_ratingtype(String r25_ratingtype) {
		this.r25_ratingtype = r25_ratingtype;
	}
	public BigDecimal getR25_market_value() {
		return r25_market_value;
	}
	public void setR25_market_value(BigDecimal r25_market_value) {
		this.r25_market_value = r25_market_value;
	}
	public String getR25_counterpartytype() {
		return r25_counterpartytype;
	}
	public void setR25_counterpartytype(String r25_counterpartytype) {
		this.r25_counterpartytype = r25_counterpartytype;
	}
	public String getR25_validationformulasecurityidentifier() {
		return r25_validationformulasecurityidentifier;
	}
	public void setR25_validationformulasecurityidentifier(String r25_validationformulasecurityidentifier) {
		this.r25_validationformulasecurityidentifier = r25_validationformulasecurityidentifier;
	}
	public String getR25_validationformulacountry() {
		return r25_validationformulacountry;
	}
	public void setR25_validationformulacountry(String r25_validationformulacountry) {
		this.r25_validationformulacountry = r25_validationformulacountry;
	}
	public String getR25_validationformularating() {
		return r25_validationformularating;
	}
	public void setR25_validationformularating(String r25_validationformularating) {
		this.r25_validationformularating = r25_validationformularating;
	}
	public String getR25_validationformulacounterparty() {
		return r25_validationformulacounterparty;
	}
	public void setR25_validationformulacounterparty(String r25_validationformulacounterparty) {
		this.r25_validationformulacounterparty = r25_validationformulacounterparty;
	}
	public String getR25_rowvalid() {
		return r25_rowvalid;
	}
	public void setR25_rowvalid(String r25_rowvalid) {
		this.r25_rowvalid = r25_rowvalid;
	}
	public String getR26_investment() {
		return r26_investment;
	}
	public void setR26_investment(String r26_investment) {
		this.r26_investment = r26_investment;
	}
	public String getR26_security() {
		return r26_security;
	}
	public void setR26_security(String r26_security) {
		this.r26_security = r26_security;
	}
	public BigDecimal getR26_nominal() {
		return r26_nominal;
	}
	public void setR26_nominal(BigDecimal r26_nominal) {
		this.r26_nominal = r26_nominal;
	}
	public BigDecimal getR26_units() {
		return r26_units;
	}
	public void setR26_units(BigDecimal r26_units) {
		this.r26_units = r26_units;
	}
	public String getR26_country() {
		return r26_country;
	}
	public void setR26_country(String r26_country) {
		this.r26_country = r26_country;
	}
	public String getR26_ccy() {
		return r26_ccy;
	}
	public void setR26_ccy(String r26_ccy) {
		this.r26_ccy = r26_ccy;
	}
	public BigDecimal getR26_amt_total_security() {
		return r26_amt_total_security;
	}
	public void setR26_amt_total_security(BigDecimal r26_amt_total_security) {
		this.r26_amt_total_security = r26_amt_total_security;
	}
	public BigDecimal getR26_aed_equivalent() {
		return r26_aed_equivalent;
	}
	public void setR26_aed_equivalent(BigDecimal r26_aed_equivalent) {
		this.r26_aed_equivalent = r26_aed_equivalent;
	}
	public BigDecimal getR26_logicfromcbs() {
		return r26_logicfromcbs;
	}
	public void setR26_logicfromcbs(BigDecimal r26_logicfromcbs) {
		this.r26_logicfromcbs = r26_logicfromcbs;
	}
	public BigDecimal getR26_logicfromktp() {
		return r26_logicfromktp;
	}
	public void setR26_logicfromktp(BigDecimal r26_logicfromktp) {
		this.r26_logicfromktp = r26_logicfromktp;
	}
	public BigDecimal getR26_rating() {
		return r26_rating;
	}
	public void setR26_rating(BigDecimal r26_rating) {
		this.r26_rating = r26_rating;
	}
	public String getR26_ratingtype() {
		return r26_ratingtype;
	}
	public void setR26_ratingtype(String r26_ratingtype) {
		this.r26_ratingtype = r26_ratingtype;
	}
	public BigDecimal getR26_market_value() {
		return r26_market_value;
	}
	public void setR26_market_value(BigDecimal r26_market_value) {
		this.r26_market_value = r26_market_value;
	}
	public String getR26_counterpartytype() {
		return r26_counterpartytype;
	}
	public void setR26_counterpartytype(String r26_counterpartytype) {
		this.r26_counterpartytype = r26_counterpartytype;
	}
	public String getR26_validationformulasecurityidentifier() {
		return r26_validationformulasecurityidentifier;
	}
	public void setR26_validationformulasecurityidentifier(String r26_validationformulasecurityidentifier) {
		this.r26_validationformulasecurityidentifier = r26_validationformulasecurityidentifier;
	}
	public String getR26_validationformulacountry() {
		return r26_validationformulacountry;
	}
	public void setR26_validationformulacountry(String r26_validationformulacountry) {
		this.r26_validationformulacountry = r26_validationformulacountry;
	}
	public String getR26_validationformularating() {
		return r26_validationformularating;
	}
	public void setR26_validationformularating(String r26_validationformularating) {
		this.r26_validationformularating = r26_validationformularating;
	}
	public String getR26_validationformulacounterparty() {
		return r26_validationformulacounterparty;
	}
	public void setR26_validationformulacounterparty(String r26_validationformulacounterparty) {
		this.r26_validationformulacounterparty = r26_validationformulacounterparty;
	}
	public String getR26_rowvalid() {
		return r26_rowvalid;
	}
	public void setR26_rowvalid(String r26_rowvalid) {
		this.r26_rowvalid = r26_rowvalid;
	}
	public String getR27_investment() {
		return r27_investment;
	}
	public void setR27_investment(String r27_investment) {
		this.r27_investment = r27_investment;
	}
	public String getR27_security() {
		return r27_security;
	}
	public void setR27_security(String r27_security) {
		this.r27_security = r27_security;
	}
	public BigDecimal getR27_nominal() {
		return r27_nominal;
	}
	public void setR27_nominal(BigDecimal r27_nominal) {
		this.r27_nominal = r27_nominal;
	}
	public BigDecimal getR27_units() {
		return r27_units;
	}
	public void setR27_units(BigDecimal r27_units) {
		this.r27_units = r27_units;
	}
	public String getR27_country() {
		return r27_country;
	}
	public void setR27_country(String r27_country) {
		this.r27_country = r27_country;
	}
	public String getR27_ccy() {
		return r27_ccy;
	}
	public void setR27_ccy(String r27_ccy) {
		this.r27_ccy = r27_ccy;
	}
	public BigDecimal getR27_amt_total_security() {
		return r27_amt_total_security;
	}
	public void setR27_amt_total_security(BigDecimal r27_amt_total_security) {
		this.r27_amt_total_security = r27_amt_total_security;
	}
	public BigDecimal getR27_aed_equivalent() {
		return r27_aed_equivalent;
	}
	public void setR27_aed_equivalent(BigDecimal r27_aed_equivalent) {
		this.r27_aed_equivalent = r27_aed_equivalent;
	}
	public BigDecimal getR27_logicfromcbs() {
		return r27_logicfromcbs;
	}
	public void setR27_logicfromcbs(BigDecimal r27_logicfromcbs) {
		this.r27_logicfromcbs = r27_logicfromcbs;
	}
	public BigDecimal getR27_logicfromktp() {
		return r27_logicfromktp;
	}
	public void setR27_logicfromktp(BigDecimal r27_logicfromktp) {
		this.r27_logicfromktp = r27_logicfromktp;
	}
	public BigDecimal getR27_rating() {
		return r27_rating;
	}
	public void setR27_rating(BigDecimal r27_rating) {
		this.r27_rating = r27_rating;
	}
	public String getR27_ratingtype() {
		return r27_ratingtype;
	}
	public void setR27_ratingtype(String r27_ratingtype) {
		this.r27_ratingtype = r27_ratingtype;
	}
	public BigDecimal getR27_market_value() {
		return r27_market_value;
	}
	public void setR27_market_value(BigDecimal r27_market_value) {
		this.r27_market_value = r27_market_value;
	}
	public String getR27_counterpartytype() {
		return r27_counterpartytype;
	}
	public void setR27_counterpartytype(String r27_counterpartytype) {
		this.r27_counterpartytype = r27_counterpartytype;
	}
	public String getR27_validationformulasecurityidentifier() {
		return r27_validationformulasecurityidentifier;
	}
	public void setR27_validationformulasecurityidentifier(String r27_validationformulasecurityidentifier) {
		this.r27_validationformulasecurityidentifier = r27_validationformulasecurityidentifier;
	}
	public String getR27_validationformulacountry() {
		return r27_validationformulacountry;
	}
	public void setR27_validationformulacountry(String r27_validationformulacountry) {
		this.r27_validationformulacountry = r27_validationformulacountry;
	}
	public String getR27_validationformularating() {
		return r27_validationformularating;
	}
	public void setR27_validationformularating(String r27_validationformularating) {
		this.r27_validationformularating = r27_validationformularating;
	}
	public String getR27_validationformulacounterparty() {
		return r27_validationformulacounterparty;
	}
	public void setR27_validationformulacounterparty(String r27_validationformulacounterparty) {
		this.r27_validationformulacounterparty = r27_validationformulacounterparty;
	}
	public String getR27_rowvalid() {
		return r27_rowvalid;
	}
	public void setR27_rowvalid(String r27_rowvalid) {
		this.r27_rowvalid = r27_rowvalid;
	}
	public String getR28_investment() {
		return r28_investment;
	}
	public void setR28_investment(String r28_investment) {
		this.r28_investment = r28_investment;
	}
	public String getR28_security() {
		return r28_security;
	}
	public void setR28_security(String r28_security) {
		this.r28_security = r28_security;
	}
	public BigDecimal getR28_nominal() {
		return r28_nominal;
	}
	public void setR28_nominal(BigDecimal r28_nominal) {
		this.r28_nominal = r28_nominal;
	}
	public BigDecimal getR28_units() {
		return r28_units;
	}
	public void setR28_units(BigDecimal r28_units) {
		this.r28_units = r28_units;
	}
	public String getR28_country() {
		return r28_country;
	}
	public void setR28_country(String r28_country) {
		this.r28_country = r28_country;
	}
	public String getR28_ccy() {
		return r28_ccy;
	}
	public void setR28_ccy(String r28_ccy) {
		this.r28_ccy = r28_ccy;
	}
	public BigDecimal getR28_amt_total_security() {
		return r28_amt_total_security;
	}
	public void setR28_amt_total_security(BigDecimal r28_amt_total_security) {
		this.r28_amt_total_security = r28_amt_total_security;
	}
	public BigDecimal getR28_aed_equivalent() {
		return r28_aed_equivalent;
	}
	public void setR28_aed_equivalent(BigDecimal r28_aed_equivalent) {
		this.r28_aed_equivalent = r28_aed_equivalent;
	}
	public BigDecimal getR28_logicfromcbs() {
		return r28_logicfromcbs;
	}
	public void setR28_logicfromcbs(BigDecimal r28_logicfromcbs) {
		this.r28_logicfromcbs = r28_logicfromcbs;
	}
	public BigDecimal getR28_logicfromktp() {
		return r28_logicfromktp;
	}
	public void setR28_logicfromktp(BigDecimal r28_logicfromktp) {
		this.r28_logicfromktp = r28_logicfromktp;
	}
	public BigDecimal getR28_rating() {
		return r28_rating;
	}
	public void setR28_rating(BigDecimal r28_rating) {
		this.r28_rating = r28_rating;
	}
	public String getR28_ratingtype() {
		return r28_ratingtype;
	}
	public void setR28_ratingtype(String r28_ratingtype) {
		this.r28_ratingtype = r28_ratingtype;
	}
	public BigDecimal getR28_market_value() {
		return r28_market_value;
	}
	public void setR28_market_value(BigDecimal r28_market_value) {
		this.r28_market_value = r28_market_value;
	}
	public String getR28_counterpartytype() {
		return r28_counterpartytype;
	}
	public void setR28_counterpartytype(String r28_counterpartytype) {
		this.r28_counterpartytype = r28_counterpartytype;
	}
	public String getR28_validationformulasecurityidentifier() {
		return r28_validationformulasecurityidentifier;
	}
	public void setR28_validationformulasecurityidentifier(String r28_validationformulasecurityidentifier) {
		this.r28_validationformulasecurityidentifier = r28_validationformulasecurityidentifier;
	}
	public String getR28_validationformulacountry() {
		return r28_validationformulacountry;
	}
	public void setR28_validationformulacountry(String r28_validationformulacountry) {
		this.r28_validationformulacountry = r28_validationformulacountry;
	}
	public String getR28_validationformularating() {
		return r28_validationformularating;
	}
	public void setR28_validationformularating(String r28_validationformularating) {
		this.r28_validationformularating = r28_validationformularating;
	}
	public String getR28_validationformulacounterparty() {
		return r28_validationformulacounterparty;
	}
	public void setR28_validationformulacounterparty(String r28_validationformulacounterparty) {
		this.r28_validationformulacounterparty = r28_validationformulacounterparty;
	}
	public String getR28_rowvalid() {
		return r28_rowvalid;
	}
	public void setR28_rowvalid(String r28_rowvalid) {
		this.r28_rowvalid = r28_rowvalid;
	}
	public String getR29_investment() {
		return r29_investment;
	}
	public void setR29_investment(String r29_investment) {
		this.r29_investment = r29_investment;
	}
	public String getR29_security() {
		return r29_security;
	}
	public void setR29_security(String r29_security) {
		this.r29_security = r29_security;
	}
	public BigDecimal getR29_nominal() {
		return r29_nominal;
	}
	public void setR29_nominal(BigDecimal r29_nominal) {
		this.r29_nominal = r29_nominal;
	}
	public BigDecimal getR29_units() {
		return r29_units;
	}
	public void setR29_units(BigDecimal r29_units) {
		this.r29_units = r29_units;
	}
	public String getR29_country() {
		return r29_country;
	}
	public void setR29_country(String r29_country) {
		this.r29_country = r29_country;
	}
	public String getR29_ccy() {
		return r29_ccy;
	}
	public void setR29_ccy(String r29_ccy) {
		this.r29_ccy = r29_ccy;
	}
	public BigDecimal getR29_amt_total_security() {
		return r29_amt_total_security;
	}
	public void setR29_amt_total_security(BigDecimal r29_amt_total_security) {
		this.r29_amt_total_security = r29_amt_total_security;
	}
	public BigDecimal getR29_aed_equivalent() {
		return r29_aed_equivalent;
	}
	public void setR29_aed_equivalent(BigDecimal r29_aed_equivalent) {
		this.r29_aed_equivalent = r29_aed_equivalent;
	}
	public BigDecimal getR29_logicfromcbs() {
		return r29_logicfromcbs;
	}
	public void setR29_logicfromcbs(BigDecimal r29_logicfromcbs) {
		this.r29_logicfromcbs = r29_logicfromcbs;
	}
	public BigDecimal getR29_logicfromktp() {
		return r29_logicfromktp;
	}
	public void setR29_logicfromktp(BigDecimal r29_logicfromktp) {
		this.r29_logicfromktp = r29_logicfromktp;
	}
	public BigDecimal getR29_rating() {
		return r29_rating;
	}
	public void setR29_rating(BigDecimal r29_rating) {
		this.r29_rating = r29_rating;
	}
	public String getR29_ratingtype() {
		return r29_ratingtype;
	}
	public void setR29_ratingtype(String r29_ratingtype) {
		this.r29_ratingtype = r29_ratingtype;
	}
	public BigDecimal getR29_market_value() {
		return r29_market_value;
	}
	public void setR29_market_value(BigDecimal r29_market_value) {
		this.r29_market_value = r29_market_value;
	}
	public String getR29_counterpartytype() {
		return r29_counterpartytype;
	}
	public void setR29_counterpartytype(String r29_counterpartytype) {
		this.r29_counterpartytype = r29_counterpartytype;
	}
	public String getR29_validationformulasecurityidentifier() {
		return r29_validationformulasecurityidentifier;
	}
	public void setR29_validationformulasecurityidentifier(String r29_validationformulasecurityidentifier) {
		this.r29_validationformulasecurityidentifier = r29_validationformulasecurityidentifier;
	}
	public String getR29_validationformulacountry() {
		return r29_validationformulacountry;
	}
	public void setR29_validationformulacountry(String r29_validationformulacountry) {
		this.r29_validationformulacountry = r29_validationformulacountry;
	}
	public String getR29_validationformularating() {
		return r29_validationformularating;
	}
	public void setR29_validationformularating(String r29_validationformularating) {
		this.r29_validationformularating = r29_validationformularating;
	}
	public String getR29_validationformulacounterparty() {
		return r29_validationformulacounterparty;
	}
	public void setR29_validationformulacounterparty(String r29_validationformulacounterparty) {
		this.r29_validationformulacounterparty = r29_validationformulacounterparty;
	}
	public String getR29_rowvalid() {
		return r29_rowvalid;
	}
	public void setR29_rowvalid(String r29_rowvalid) {
		this.r29_rowvalid = r29_rowvalid;
	}
	public String getR30_investment() {
		return r30_investment;
	}
	public void setR30_investment(String r30_investment) {
		this.r30_investment = r30_investment;
	}
	public String getR30_security() {
		return r30_security;
	}
	public void setR30_security(String r30_security) {
		this.r30_security = r30_security;
	}
	public BigDecimal getR30_nominal() {
		return r30_nominal;
	}
	public void setR30_nominal(BigDecimal r30_nominal) {
		this.r30_nominal = r30_nominal;
	}
	public BigDecimal getR30_units() {
		return r30_units;
	}
	public void setR30_units(BigDecimal r30_units) {
		this.r30_units = r30_units;
	}
	public String getR30_country() {
		return r30_country;
	}
	public void setR30_country(String r30_country) {
		this.r30_country = r30_country;
	}
	public String getR30_ccy() {
		return r30_ccy;
	}
	public void setR30_ccy(String r30_ccy) {
		this.r30_ccy = r30_ccy;
	}
	public BigDecimal getR30_amt_total_security() {
		return r30_amt_total_security;
	}
	public void setR30_amt_total_security(BigDecimal r30_amt_total_security) {
		this.r30_amt_total_security = r30_amt_total_security;
	}
	public BigDecimal getR30_aed_equivalent() {
		return r30_aed_equivalent;
	}
	public void setR30_aed_equivalent(BigDecimal r30_aed_equivalent) {
		this.r30_aed_equivalent = r30_aed_equivalent;
	}
	public BigDecimal getR30_logicfromcbs() {
		return r30_logicfromcbs;
	}
	public void setR30_logicfromcbs(BigDecimal r30_logicfromcbs) {
		this.r30_logicfromcbs = r30_logicfromcbs;
	}
	public BigDecimal getR30_logicfromktp() {
		return r30_logicfromktp;
	}
	public void setR30_logicfromktp(BigDecimal r30_logicfromktp) {
		this.r30_logicfromktp = r30_logicfromktp;
	}
	public BigDecimal getR30_rating() {
		return r30_rating;
	}
	public void setR30_rating(BigDecimal r30_rating) {
		this.r30_rating = r30_rating;
	}
	public String getR30_ratingtype() {
		return r30_ratingtype;
	}
	public void setR30_ratingtype(String r30_ratingtype) {
		this.r30_ratingtype = r30_ratingtype;
	}
	public BigDecimal getR30_market_value() {
		return r30_market_value;
	}
	public void setR30_market_value(BigDecimal r30_market_value) {
		this.r30_market_value = r30_market_value;
	}
	public String getR30_counterpartytype() {
		return r30_counterpartytype;
	}
	public void setR30_counterpartytype(String r30_counterpartytype) {
		this.r30_counterpartytype = r30_counterpartytype;
	}
	public String getR30_validationformulasecurityidentifier() {
		return r30_validationformulasecurityidentifier;
	}
	public void setR30_validationformulasecurityidentifier(String r30_validationformulasecurityidentifier) {
		this.r30_validationformulasecurityidentifier = r30_validationformulasecurityidentifier;
	}
	public String getR30_validationformulacountry() {
		return r30_validationformulacountry;
	}
	public void setR30_validationformulacountry(String r30_validationformulacountry) {
		this.r30_validationformulacountry = r30_validationformulacountry;
	}
	public String getR30_validationformularating() {
		return r30_validationformularating;
	}
	public void setR30_validationformularating(String r30_validationformularating) {
		this.r30_validationformularating = r30_validationformularating;
	}
	public String getR30_validationformulacounterparty() {
		return r30_validationformulacounterparty;
	}
	public void setR30_validationformulacounterparty(String r30_validationformulacounterparty) {
		this.r30_validationformulacounterparty = r30_validationformulacounterparty;
	}
	public String getR30_rowvalid() {
		return r30_rowvalid;
	}
	public void setR30_rowvalid(String r30_rowvalid) {
		this.r30_rowvalid = r30_rowvalid;
	}
	public String getR31_investment() {
		return r31_investment;
	}
	public void setR31_investment(String r31_investment) {
		this.r31_investment = r31_investment;
	}
	public String getR31_security() {
		return r31_security;
	}
	public void setR31_security(String r31_security) {
		this.r31_security = r31_security;
	}
	public BigDecimal getR31_nominal() {
		return r31_nominal;
	}
	public void setR31_nominal(BigDecimal r31_nominal) {
		this.r31_nominal = r31_nominal;
	}
	public BigDecimal getR31_units() {
		return r31_units;
	}
	public void setR31_units(BigDecimal r31_units) {
		this.r31_units = r31_units;
	}
	public String getR31_country() {
		return r31_country;
	}
	public void setR31_country(String r31_country) {
		this.r31_country = r31_country;
	}
	public String getR31_ccy() {
		return r31_ccy;
	}
	public void setR31_ccy(String r31_ccy) {
		this.r31_ccy = r31_ccy;
	}
	public BigDecimal getR31_amt_total_security() {
		return r31_amt_total_security;
	}
	public void setR31_amt_total_security(BigDecimal r31_amt_total_security) {
		this.r31_amt_total_security = r31_amt_total_security;
	}
	public BigDecimal getR31_aed_equivalent() {
		return r31_aed_equivalent;
	}
	public void setR31_aed_equivalent(BigDecimal r31_aed_equivalent) {
		this.r31_aed_equivalent = r31_aed_equivalent;
	}
	public BigDecimal getR31_logicfromcbs() {
		return r31_logicfromcbs;
	}
	public void setR31_logicfromcbs(BigDecimal r31_logicfromcbs) {
		this.r31_logicfromcbs = r31_logicfromcbs;
	}
	public BigDecimal getR31_logicfromktp() {
		return r31_logicfromktp;
	}
	public void setR31_logicfromktp(BigDecimal r31_logicfromktp) {
		this.r31_logicfromktp = r31_logicfromktp;
	}
	public BigDecimal getR31_rating() {
		return r31_rating;
	}
	public void setR31_rating(BigDecimal r31_rating) {
		this.r31_rating = r31_rating;
	}
	public String getR31_ratingtype() {
		return r31_ratingtype;
	}
	public void setR31_ratingtype(String r31_ratingtype) {
		this.r31_ratingtype = r31_ratingtype;
	}
	public BigDecimal getR31_market_value() {
		return r31_market_value;
	}
	public void setR31_market_value(BigDecimal r31_market_value) {
		this.r31_market_value = r31_market_value;
	}
	public String getR31_counterpartytype() {
		return r31_counterpartytype;
	}
	public void setR31_counterpartytype(String r31_counterpartytype) {
		this.r31_counterpartytype = r31_counterpartytype;
	}
	public String getR31_validationformulasecurityidentifier() {
		return r31_validationformulasecurityidentifier;
	}
	public void setR31_validationformulasecurityidentifier(String r31_validationformulasecurityidentifier) {
		this.r31_validationformulasecurityidentifier = r31_validationformulasecurityidentifier;
	}
	public String getR31_validationformulacountry() {
		return r31_validationformulacountry;
	}
	public void setR31_validationformulacountry(String r31_validationformulacountry) {
		this.r31_validationformulacountry = r31_validationformulacountry;
	}
	public String getR31_validationformularating() {
		return r31_validationformularating;
	}
	public void setR31_validationformularating(String r31_validationformularating) {
		this.r31_validationformularating = r31_validationformularating;
	}
	public String getR31_validationformulacounterparty() {
		return r31_validationformulacounterparty;
	}
	public void setR31_validationformulacounterparty(String r31_validationformulacounterparty) {
		this.r31_validationformulacounterparty = r31_validationformulacounterparty;
	}
	public String getR31_rowvalid() {
		return r31_rowvalid;
	}
	public void setR31_rowvalid(String r31_rowvalid) {
		this.r31_rowvalid = r31_rowvalid;
	}
	public String getR32_investment() {
		return r32_investment;
	}
	public void setR32_investment(String r32_investment) {
		this.r32_investment = r32_investment;
	}
	public String getR32_security() {
		return r32_security;
	}
	public void setR32_security(String r32_security) {
		this.r32_security = r32_security;
	}
	public BigDecimal getR32_nominal() {
		return r32_nominal;
	}
	public void setR32_nominal(BigDecimal r32_nominal) {
		this.r32_nominal = r32_nominal;
	}
	public BigDecimal getR32_units() {
		return r32_units;
	}
	public void setR32_units(BigDecimal r32_units) {
		this.r32_units = r32_units;
	}
	public String getR32_country() {
		return r32_country;
	}
	public void setR32_country(String r32_country) {
		this.r32_country = r32_country;
	}
	public String getR32_ccy() {
		return r32_ccy;
	}
	public void setR32_ccy(String r32_ccy) {
		this.r32_ccy = r32_ccy;
	}
	public BigDecimal getR32_amt_total_security() {
		return r32_amt_total_security;
	}
	public void setR32_amt_total_security(BigDecimal r32_amt_total_security) {
		this.r32_amt_total_security = r32_amt_total_security;
	}
	public BigDecimal getR32_aed_equivalent() {
		return r32_aed_equivalent;
	}
	public void setR32_aed_equivalent(BigDecimal r32_aed_equivalent) {
		this.r32_aed_equivalent = r32_aed_equivalent;
	}
	public BigDecimal getR32_logicfromcbs() {
		return r32_logicfromcbs;
	}
	public void setR32_logicfromcbs(BigDecimal r32_logicfromcbs) {
		this.r32_logicfromcbs = r32_logicfromcbs;
	}
	public BigDecimal getR32_logicfromktp() {
		return r32_logicfromktp;
	}
	public void setR32_logicfromktp(BigDecimal r32_logicfromktp) {
		this.r32_logicfromktp = r32_logicfromktp;
	}
	public BigDecimal getR32_rating() {
		return r32_rating;
	}
	public void setR32_rating(BigDecimal r32_rating) {
		this.r32_rating = r32_rating;
	}
	public String getR32_ratingtype() {
		return r32_ratingtype;
	}
	public void setR32_ratingtype(String r32_ratingtype) {
		this.r32_ratingtype = r32_ratingtype;
	}
	public BigDecimal getR32_market_value() {
		return r32_market_value;
	}
	public void setR32_market_value(BigDecimal r32_market_value) {
		this.r32_market_value = r32_market_value;
	}
	public String getR32_counterpartytype() {
		return r32_counterpartytype;
	}
	public void setR32_counterpartytype(String r32_counterpartytype) {
		this.r32_counterpartytype = r32_counterpartytype;
	}
	public String getR32_validationformulasecurityidentifier() {
		return r32_validationformulasecurityidentifier;
	}
	public void setR32_validationformulasecurityidentifier(String r32_validationformulasecurityidentifier) {
		this.r32_validationformulasecurityidentifier = r32_validationformulasecurityidentifier;
	}
	public String getR32_validationformulacountry() {
		return r32_validationformulacountry;
	}
	public void setR32_validationformulacountry(String r32_validationformulacountry) {
		this.r32_validationformulacountry = r32_validationformulacountry;
	}
	public String getR32_validationformularating() {
		return r32_validationformularating;
	}
	public void setR32_validationformularating(String r32_validationformularating) {
		this.r32_validationformularating = r32_validationformularating;
	}
	public String getR32_validationformulacounterparty() {
		return r32_validationformulacounterparty;
	}
	public void setR32_validationformulacounterparty(String r32_validationformulacounterparty) {
		this.r32_validationformulacounterparty = r32_validationformulacounterparty;
	}
	public String getR32_rowvalid() {
		return r32_rowvalid;
	}
	public void setR32_rowvalid(String r32_rowvalid) {
		this.r32_rowvalid = r32_rowvalid;
	}
	public String getR33_investment() {
		return r33_investment;
	}
	public void setR33_investment(String r33_investment) {
		this.r33_investment = r33_investment;
	}
	public String getR33_security() {
		return r33_security;
	}
	public void setR33_security(String r33_security) {
		this.r33_security = r33_security;
	}
	public BigDecimal getR33_nominal() {
		return r33_nominal;
	}
	public void setR33_nominal(BigDecimal r33_nominal) {
		this.r33_nominal = r33_nominal;
	}
	public BigDecimal getR33_units() {
		return r33_units;
	}
	public void setR33_units(BigDecimal r33_units) {
		this.r33_units = r33_units;
	}
	public String getR33_country() {
		return r33_country;
	}
	public void setR33_country(String r33_country) {
		this.r33_country = r33_country;
	}
	public String getR33_ccy() {
		return r33_ccy;
	}
	public void setR33_ccy(String r33_ccy) {
		this.r33_ccy = r33_ccy;
	}
	public BigDecimal getR33_amt_total_security() {
		return r33_amt_total_security;
	}
	public void setR33_amt_total_security(BigDecimal r33_amt_total_security) {
		this.r33_amt_total_security = r33_amt_total_security;
	}
	public BigDecimal getR33_aed_equivalent() {
		return r33_aed_equivalent;
	}
	public void setR33_aed_equivalent(BigDecimal r33_aed_equivalent) {
		this.r33_aed_equivalent = r33_aed_equivalent;
	}
	public BigDecimal getR33_logicfromcbs() {
		return r33_logicfromcbs;
	}
	public void setR33_logicfromcbs(BigDecimal r33_logicfromcbs) {
		this.r33_logicfromcbs = r33_logicfromcbs;
	}
	public BigDecimal getR33_logicfromktp() {
		return r33_logicfromktp;
	}
	public void setR33_logicfromktp(BigDecimal r33_logicfromktp) {
		this.r33_logicfromktp = r33_logicfromktp;
	}
	public BigDecimal getR33_rating() {
		return r33_rating;
	}
	public void setR33_rating(BigDecimal r33_rating) {
		this.r33_rating = r33_rating;
	}
	public String getR33_ratingtype() {
		return r33_ratingtype;
	}
	public void setR33_ratingtype(String r33_ratingtype) {
		this.r33_ratingtype = r33_ratingtype;
	}
	public BigDecimal getR33_market_value() {
		return r33_market_value;
	}
	public void setR33_market_value(BigDecimal r33_market_value) {
		this.r33_market_value = r33_market_value;
	}
	public String getR33_counterpartytype() {
		return r33_counterpartytype;
	}
	public void setR33_counterpartytype(String r33_counterpartytype) {
		this.r33_counterpartytype = r33_counterpartytype;
	}
	public String getR33_validationformulasecurityidentifier() {
		return r33_validationformulasecurityidentifier;
	}
	public void setR33_validationformulasecurityidentifier(String r33_validationformulasecurityidentifier) {
		this.r33_validationformulasecurityidentifier = r33_validationformulasecurityidentifier;
	}
	public String getR33_validationformulacountry() {
		return r33_validationformulacountry;
	}
	public void setR33_validationformulacountry(String r33_validationformulacountry) {
		this.r33_validationformulacountry = r33_validationformulacountry;
	}
	public String getR33_validationformularating() {
		return r33_validationformularating;
	}
	public void setR33_validationformularating(String r33_validationformularating) {
		this.r33_validationformularating = r33_validationformularating;
	}
	public String getR33_validationformulacounterparty() {
		return r33_validationformulacounterparty;
	}
	public void setR33_validationformulacounterparty(String r33_validationformulacounterparty) {
		this.r33_validationformulacounterparty = r33_validationformulacounterparty;
	}
	public String getR33_rowvalid() {
		return r33_rowvalid;
	}
	public void setR33_rowvalid(String r33_rowvalid) {
		this.r33_rowvalid = r33_rowvalid;
	}
	public String getR34_investment() {
		return r34_investment;
	}
	public void setR34_investment(String r34_investment) {
		this.r34_investment = r34_investment;
	}
	public String getR34_security() {
		return r34_security;
	}
	public void setR34_security(String r34_security) {
		this.r34_security = r34_security;
	}
	public BigDecimal getR34_nominal() {
		return r34_nominal;
	}
	public void setR34_nominal(BigDecimal r34_nominal) {
		this.r34_nominal = r34_nominal;
	}
	public BigDecimal getR34_units() {
		return r34_units;
	}
	public void setR34_units(BigDecimal r34_units) {
		this.r34_units = r34_units;
	}
	public String getR34_country() {
		return r34_country;
	}
	public void setR34_country(String r34_country) {
		this.r34_country = r34_country;
	}
	public String getR34_ccy() {
		return r34_ccy;
	}
	public void setR34_ccy(String r34_ccy) {
		this.r34_ccy = r34_ccy;
	}
	public BigDecimal getR34_amt_total_security() {
		return r34_amt_total_security;
	}
	public void setR34_amt_total_security(BigDecimal r34_amt_total_security) {
		this.r34_amt_total_security = r34_amt_total_security;
	}
	public BigDecimal getR34_aed_equivalent() {
		return r34_aed_equivalent;
	}
	public void setR34_aed_equivalent(BigDecimal r34_aed_equivalent) {
		this.r34_aed_equivalent = r34_aed_equivalent;
	}
	public BigDecimal getR34_logicfromcbs() {
		return r34_logicfromcbs;
	}
	public void setR34_logicfromcbs(BigDecimal r34_logicfromcbs) {
		this.r34_logicfromcbs = r34_logicfromcbs;
	}
	public BigDecimal getR34_logicfromktp() {
		return r34_logicfromktp;
	}
	public void setR34_logicfromktp(BigDecimal r34_logicfromktp) {
		this.r34_logicfromktp = r34_logicfromktp;
	}
	public BigDecimal getR34_rating() {
		return r34_rating;
	}
	public void setR34_rating(BigDecimal r34_rating) {
		this.r34_rating = r34_rating;
	}
	public String getR34_ratingtype() {
		return r34_ratingtype;
	}
	public void setR34_ratingtype(String r34_ratingtype) {
		this.r34_ratingtype = r34_ratingtype;
	}
	public BigDecimal getR34_market_value() {
		return r34_market_value;
	}
	public void setR34_market_value(BigDecimal r34_market_value) {
		this.r34_market_value = r34_market_value;
	}
	public String getR34_counterpartytype() {
		return r34_counterpartytype;
	}
	public void setR34_counterpartytype(String r34_counterpartytype) {
		this.r34_counterpartytype = r34_counterpartytype;
	}
	public String getR34_validationformulasecurityidentifier() {
		return r34_validationformulasecurityidentifier;
	}
	public void setR34_validationformulasecurityidentifier(String r34_validationformulasecurityidentifier) {
		this.r34_validationformulasecurityidentifier = r34_validationformulasecurityidentifier;
	}
	public String getR34_validationformulacountry() {
		return r34_validationformulacountry;
	}
	public void setR34_validationformulacountry(String r34_validationformulacountry) {
		this.r34_validationformulacountry = r34_validationformulacountry;
	}
	public String getR34_validationformularating() {
		return r34_validationformularating;
	}
	public void setR34_validationformularating(String r34_validationformularating) {
		this.r34_validationformularating = r34_validationformularating;
	}
	public String getR34_validationformulacounterparty() {
		return r34_validationformulacounterparty;
	}
	public void setR34_validationformulacounterparty(String r34_validationformulacounterparty) {
		this.r34_validationformulacounterparty = r34_validationformulacounterparty;
	}
	public String getR34_rowvalid() {
		return r34_rowvalid;
	}
	public void setR34_rowvalid(String r34_rowvalid) {
		this.r34_rowvalid = r34_rowvalid;
	}
	public String getR36_investment() {
		return r36_investment;
	}
	public void setR36_investment(String r36_investment) {
		this.r36_investment = r36_investment;
	}
	public String getR36_security() {
		return r36_security;
	}
	public void setR36_security(String r36_security) {
		this.r36_security = r36_security;
	}
	public BigDecimal getR36_nominal() {
		return r36_nominal;
	}
	public void setR36_nominal(BigDecimal r36_nominal) {
		this.r36_nominal = r36_nominal;
	}
	public BigDecimal getR36_units() {
		return r36_units;
	}
	public void setR36_units(BigDecimal r36_units) {
		this.r36_units = r36_units;
	}
	public String getR36_country() {
		return r36_country;
	}
	public void setR36_country(String r36_country) {
		this.r36_country = r36_country;
	}
	public String getR36_ccy() {
		return r36_ccy;
	}
	public void setR36_ccy(String r36_ccy) {
		this.r36_ccy = r36_ccy;
	}
	public BigDecimal getR36_amt_total_security() {
		return r36_amt_total_security;
	}
	public void setR36_amt_total_security(BigDecimal r36_amt_total_security) {
		this.r36_amt_total_security = r36_amt_total_security;
	}
	public BigDecimal getR36_aed_equivalent() {
		return r36_aed_equivalent;
	}
	public void setR36_aed_equivalent(BigDecimal r36_aed_equivalent) {
		this.r36_aed_equivalent = r36_aed_equivalent;
	}
	public BigDecimal getR36_logicfromcbs() {
		return r36_logicfromcbs;
	}
	public void setR36_logicfromcbs(BigDecimal r36_logicfromcbs) {
		this.r36_logicfromcbs = r36_logicfromcbs;
	}
	public BigDecimal getR36_logicfromktp() {
		return r36_logicfromktp;
	}
	public void setR36_logicfromktp(BigDecimal r36_logicfromktp) {
		this.r36_logicfromktp = r36_logicfromktp;
	}
	public BigDecimal getR36_rating() {
		return r36_rating;
	}
	public void setR36_rating(BigDecimal r36_rating) {
		this.r36_rating = r36_rating;
	}
	public String getR36_ratingtype() {
		return r36_ratingtype;
	}
	public void setR36_ratingtype(String r36_ratingtype) {
		this.r36_ratingtype = r36_ratingtype;
	}
	public BigDecimal getR36_market_value() {
		return r36_market_value;
	}
	public void setR36_market_value(BigDecimal r36_market_value) {
		this.r36_market_value = r36_market_value;
	}
	public String getR36_counterpartytype() {
		return r36_counterpartytype;
	}
	public void setR36_counterpartytype(String r36_counterpartytype) {
		this.r36_counterpartytype = r36_counterpartytype;
	}
	public String getR36_validationformulasecurityidentifier() {
		return r36_validationformulasecurityidentifier;
	}
	public void setR36_validationformulasecurityidentifier(String r36_validationformulasecurityidentifier) {
		this.r36_validationformulasecurityidentifier = r36_validationformulasecurityidentifier;
	}
	public String getR36_validationformulacountry() {
		return r36_validationformulacountry;
	}
	public void setR36_validationformulacountry(String r36_validationformulacountry) {
		this.r36_validationformulacountry = r36_validationformulacountry;
	}
	public String getR36_validationformularating() {
		return r36_validationformularating;
	}
	public void setR36_validationformularating(String r36_validationformularating) {
		this.r36_validationformularating = r36_validationformularating;
	}
	public String getR36_validationformulacounterparty() {
		return r36_validationformulacounterparty;
	}
	public void setR36_validationformulacounterparty(String r36_validationformulacounterparty) {
		this.r36_validationformulacounterparty = r36_validationformulacounterparty;
	}
	public String getR36_rowvalid() {
		return r36_rowvalid;
	}
	public void setR36_rowvalid(String r36_rowvalid) {
		this.r36_rowvalid = r36_rowvalid;
	}
	public String getR37_investment() {
		return r37_investment;
	}
	public void setR37_investment(String r37_investment) {
		this.r37_investment = r37_investment;
	}
	public String getR37_security() {
		return r37_security;
	}
	public void setR37_security(String r37_security) {
		this.r37_security = r37_security;
	}
	public BigDecimal getR37_nominal() {
		return r37_nominal;
	}
	public void setR37_nominal(BigDecimal r37_nominal) {
		this.r37_nominal = r37_nominal;
	}
	public BigDecimal getR37_units() {
		return r37_units;
	}
	public void setR37_units(BigDecimal r37_units) {
		this.r37_units = r37_units;
	}
	public String getR37_country() {
		return r37_country;
	}
	public void setR37_country(String r37_country) {
		this.r37_country = r37_country;
	}
	public String getR37_ccy() {
		return r37_ccy;
	}
	public void setR37_ccy(String r37_ccy) {
		this.r37_ccy = r37_ccy;
	}
	public BigDecimal getR37_amt_total_security() {
		return r37_amt_total_security;
	}
	public void setR37_amt_total_security(BigDecimal r37_amt_total_security) {
		this.r37_amt_total_security = r37_amt_total_security;
	}
	public BigDecimal getR37_aed_equivalent() {
		return r37_aed_equivalent;
	}
	public void setR37_aed_equivalent(BigDecimal r37_aed_equivalent) {
		this.r37_aed_equivalent = r37_aed_equivalent;
	}
	public BigDecimal getR37_logicfromcbs() {
		return r37_logicfromcbs;
	}
	public void setR37_logicfromcbs(BigDecimal r37_logicfromcbs) {
		this.r37_logicfromcbs = r37_logicfromcbs;
	}
	public BigDecimal getR37_logicfromktp() {
		return r37_logicfromktp;
	}
	public void setR37_logicfromktp(BigDecimal r37_logicfromktp) {
		this.r37_logicfromktp = r37_logicfromktp;
	}
	public BigDecimal getR37_rating() {
		return r37_rating;
	}
	public void setR37_rating(BigDecimal r37_rating) {
		this.r37_rating = r37_rating;
	}
	public String getR37_ratingtype() {
		return r37_ratingtype;
	}
	public void setR37_ratingtype(String r37_ratingtype) {
		this.r37_ratingtype = r37_ratingtype;
	}
	public BigDecimal getR37_market_value() {
		return r37_market_value;
	}
	public void setR37_market_value(BigDecimal r37_market_value) {
		this.r37_market_value = r37_market_value;
	}
	public String getR37_counterpartytype() {
		return r37_counterpartytype;
	}
	public void setR37_counterpartytype(String r37_counterpartytype) {
		this.r37_counterpartytype = r37_counterpartytype;
	}
	public String getR37_validationformulasecurityidentifier() {
		return r37_validationformulasecurityidentifier;
	}
	public void setR37_validationformulasecurityidentifier(String r37_validationformulasecurityidentifier) {
		this.r37_validationformulasecurityidentifier = r37_validationformulasecurityidentifier;
	}
	public String getR37_validationformulacountry() {
		return r37_validationformulacountry;
	}
	public void setR37_validationformulacountry(String r37_validationformulacountry) {
		this.r37_validationformulacountry = r37_validationformulacountry;
	}
	public String getR37_validationformularating() {
		return r37_validationformularating;
	}
	public void setR37_validationformularating(String r37_validationformularating) {
		this.r37_validationformularating = r37_validationformularating;
	}
	public String getR37_validationformulacounterparty() {
		return r37_validationformulacounterparty;
	}
	public void setR37_validationformulacounterparty(String r37_validationformulacounterparty) {
		this.r37_validationformulacounterparty = r37_validationformulacounterparty;
	}
	public String getR37_rowvalid() {
		return r37_rowvalid;
	}
	public void setR37_rowvalid(String r37_rowvalid) {
		this.r37_rowvalid = r37_rowvalid;
	}
	public String getR38_investment() {
		return r38_investment;
	}
	public void setR38_investment(String r38_investment) {
		this.r38_investment = r38_investment;
	}
	public String getR38_security() {
		return r38_security;
	}
	public void setR38_security(String r38_security) {
		this.r38_security = r38_security;
	}
	public BigDecimal getR38_nominal() {
		return r38_nominal;
	}
	public void setR38_nominal(BigDecimal r38_nominal) {
		this.r38_nominal = r38_nominal;
	}
	public BigDecimal getR38_units() {
		return r38_units;
	}
	public void setR38_units(BigDecimal r38_units) {
		this.r38_units = r38_units;
	}
	public String getR38_country() {
		return r38_country;
	}
	public void setR38_country(String r38_country) {
		this.r38_country = r38_country;
	}
	public String getR38_ccy() {
		return r38_ccy;
	}
	public void setR38_ccy(String r38_ccy) {
		this.r38_ccy = r38_ccy;
	}
	public BigDecimal getR38_amt_total_security() {
		return r38_amt_total_security;
	}
	public void setR38_amt_total_security(BigDecimal r38_amt_total_security) {
		this.r38_amt_total_security = r38_amt_total_security;
	}
	public BigDecimal getR38_aed_equivalent() {
		return r38_aed_equivalent;
	}
	public void setR38_aed_equivalent(BigDecimal r38_aed_equivalent) {
		this.r38_aed_equivalent = r38_aed_equivalent;
	}
	public BigDecimal getR38_logicfromcbs() {
		return r38_logicfromcbs;
	}
	public void setR38_logicfromcbs(BigDecimal r38_logicfromcbs) {
		this.r38_logicfromcbs = r38_logicfromcbs;
	}
	public BigDecimal getR38_logicfromktp() {
		return r38_logicfromktp;
	}
	public void setR38_logicfromktp(BigDecimal r38_logicfromktp) {
		this.r38_logicfromktp = r38_logicfromktp;
	}
	public BigDecimal getR38_rating() {
		return r38_rating;
	}
	public void setR38_rating(BigDecimal r38_rating) {
		this.r38_rating = r38_rating;
	}
	public String getR38_ratingtype() {
		return r38_ratingtype;
	}
	public void setR38_ratingtype(String r38_ratingtype) {
		this.r38_ratingtype = r38_ratingtype;
	}
	public BigDecimal getR38_market_value() {
		return r38_market_value;
	}
	public void setR38_market_value(BigDecimal r38_market_value) {
		this.r38_market_value = r38_market_value;
	}
	public String getR38_counterpartytype() {
		return r38_counterpartytype;
	}
	public void setR38_counterpartytype(String r38_counterpartytype) {
		this.r38_counterpartytype = r38_counterpartytype;
	}
	public String getR38_validationformulasecurityidentifier() {
		return r38_validationformulasecurityidentifier;
	}
	public void setR38_validationformulasecurityidentifier(String r38_validationformulasecurityidentifier) {
		this.r38_validationformulasecurityidentifier = r38_validationformulasecurityidentifier;
	}
	public String getR38_validationformulacountry() {
		return r38_validationformulacountry;
	}
	public void setR38_validationformulacountry(String r38_validationformulacountry) {
		this.r38_validationformulacountry = r38_validationformulacountry;
	}
	public String getR38_validationformularating() {
		return r38_validationformularating;
	}
	public void setR38_validationformularating(String r38_validationformularating) {
		this.r38_validationformularating = r38_validationformularating;
	}
	public String getR38_validationformulacounterparty() {
		return r38_validationformulacounterparty;
	}
	public void setR38_validationformulacounterparty(String r38_validationformulacounterparty) {
		this.r38_validationformulacounterparty = r38_validationformulacounterparty;
	}
	public String getR38_rowvalid() {
		return r38_rowvalid;
	}
	public void setR38_rowvalid(String r38_rowvalid) {
		this.r38_rowvalid = r38_rowvalid;
	}
	public String getR39_investment() {
		return r39_investment;
	}
	public void setR39_investment(String r39_investment) {
		this.r39_investment = r39_investment;
	}
	public String getR39_security() {
		return r39_security;
	}
	public void setR39_security(String r39_security) {
		this.r39_security = r39_security;
	}
	public BigDecimal getR39_nominal() {
		return r39_nominal;
	}
	public void setR39_nominal(BigDecimal r39_nominal) {
		this.r39_nominal = r39_nominal;
	}
	public BigDecimal getR39_units() {
		return r39_units;
	}
	public void setR39_units(BigDecimal r39_units) {
		this.r39_units = r39_units;
	}
	public String getR39_country() {
		return r39_country;
	}
	public void setR39_country(String r39_country) {
		this.r39_country = r39_country;
	}
	public String getR39_ccy() {
		return r39_ccy;
	}
	public void setR39_ccy(String r39_ccy) {
		this.r39_ccy = r39_ccy;
	}
	public BigDecimal getR39_amt_total_security() {
		return r39_amt_total_security;
	}
	public void setR39_amt_total_security(BigDecimal r39_amt_total_security) {
		this.r39_amt_total_security = r39_amt_total_security;
	}
	public BigDecimal getR39_aed_equivalent() {
		return r39_aed_equivalent;
	}
	public void setR39_aed_equivalent(BigDecimal r39_aed_equivalent) {
		this.r39_aed_equivalent = r39_aed_equivalent;
	}
	public BigDecimal getR39_logicfromcbs() {
		return r39_logicfromcbs;
	}
	public void setR39_logicfromcbs(BigDecimal r39_logicfromcbs) {
		this.r39_logicfromcbs = r39_logicfromcbs;
	}
	public BigDecimal getR39_logicfromktp() {
		return r39_logicfromktp;
	}
	public void setR39_logicfromktp(BigDecimal r39_logicfromktp) {
		this.r39_logicfromktp = r39_logicfromktp;
	}
	public BigDecimal getR39_rating() {
		return r39_rating;
	}
	public void setR39_rating(BigDecimal r39_rating) {
		this.r39_rating = r39_rating;
	}
	public String getR39_ratingtype() {
		return r39_ratingtype;
	}
	public void setR39_ratingtype(String r39_ratingtype) {
		this.r39_ratingtype = r39_ratingtype;
	}
	public BigDecimal getR39_market_value() {
		return r39_market_value;
	}
	public void setR39_market_value(BigDecimal r39_market_value) {
		this.r39_market_value = r39_market_value;
	}
	public String getR39_counterpartytype() {
		return r39_counterpartytype;
	}
	public void setR39_counterpartytype(String r39_counterpartytype) {
		this.r39_counterpartytype = r39_counterpartytype;
	}
	public String getR39_validationformulasecurityidentifier() {
		return r39_validationformulasecurityidentifier;
	}
	public void setR39_validationformulasecurityidentifier(String r39_validationformulasecurityidentifier) {
		this.r39_validationformulasecurityidentifier = r39_validationformulasecurityidentifier;
	}
	public String getR39_validationformulacountry() {
		return r39_validationformulacountry;
	}
	public void setR39_validationformulacountry(String r39_validationformulacountry) {
		this.r39_validationformulacountry = r39_validationformulacountry;
	}
	public String getR39_validationformularating() {
		return r39_validationformularating;
	}
	public void setR39_validationformularating(String r39_validationformularating) {
		this.r39_validationformularating = r39_validationformularating;
	}
	public String getR39_validationformulacounterparty() {
		return r39_validationformulacounterparty;
	}
	public void setR39_validationformulacounterparty(String r39_validationformulacounterparty) {
		this.r39_validationformulacounterparty = r39_validationformulacounterparty;
	}
	public String getR39_rowvalid() {
		return r39_rowvalid;
	}
	public void setR39_rowvalid(String r39_rowvalid) {
		this.r39_rowvalid = r39_rowvalid;
	}
	public String getR40_investment() {
		return r40_investment;
	}
	public void setR40_investment(String r40_investment) {
		this.r40_investment = r40_investment;
	}
	public String getR40_security() {
		return r40_security;
	}
	public void setR40_security(String r40_security) {
		this.r40_security = r40_security;
	}
	public BigDecimal getR40_nominal() {
		return r40_nominal;
	}
	public void setR40_nominal(BigDecimal r40_nominal) {
		this.r40_nominal = r40_nominal;
	}
	public BigDecimal getR40_units() {
		return r40_units;
	}
	public void setR40_units(BigDecimal r40_units) {
		this.r40_units = r40_units;
	}
	public String getR40_country() {
		return r40_country;
	}
	public void setR40_country(String r40_country) {
		this.r40_country = r40_country;
	}
	public String getR40_ccy() {
		return r40_ccy;
	}
	public void setR40_ccy(String r40_ccy) {
		this.r40_ccy = r40_ccy;
	}
	public BigDecimal getR40_amt_total_security() {
		return r40_amt_total_security;
	}
	public void setR40_amt_total_security(BigDecimal r40_amt_total_security) {
		this.r40_amt_total_security = r40_amt_total_security;
	}
	public BigDecimal getR40_aed_equivalent() {
		return r40_aed_equivalent;
	}
	public void setR40_aed_equivalent(BigDecimal r40_aed_equivalent) {
		this.r40_aed_equivalent = r40_aed_equivalent;
	}
	public BigDecimal getR40_logicfromcbs() {
		return r40_logicfromcbs;
	}
	public void setR40_logicfromcbs(BigDecimal r40_logicfromcbs) {
		this.r40_logicfromcbs = r40_logicfromcbs;
	}
	public BigDecimal getR40_logicfromktp() {
		return r40_logicfromktp;
	}
	public void setR40_logicfromktp(BigDecimal r40_logicfromktp) {
		this.r40_logicfromktp = r40_logicfromktp;
	}
	public BigDecimal getR40_rating() {
		return r40_rating;
	}
	public void setR40_rating(BigDecimal r40_rating) {
		this.r40_rating = r40_rating;
	}
	public String getR40_ratingtype() {
		return r40_ratingtype;
	}
	public void setR40_ratingtype(String r40_ratingtype) {
		this.r40_ratingtype = r40_ratingtype;
	}
	public BigDecimal getR40_market_value() {
		return r40_market_value;
	}
	public void setR40_market_value(BigDecimal r40_market_value) {
		this.r40_market_value = r40_market_value;
	}
	public String getR40_counterpartytype() {
		return r40_counterpartytype;
	}
	public void setR40_counterpartytype(String r40_counterpartytype) {
		this.r40_counterpartytype = r40_counterpartytype;
	}
	public String getR40_validationformulasecurityidentifier() {
		return r40_validationformulasecurityidentifier;
	}
	public void setR40_validationformulasecurityidentifier(String r40_validationformulasecurityidentifier) {
		this.r40_validationformulasecurityidentifier = r40_validationformulasecurityidentifier;
	}
	public String getR40_validationformulacountry() {
		return r40_validationformulacountry;
	}
	public void setR40_validationformulacountry(String r40_validationformulacountry) {
		this.r40_validationformulacountry = r40_validationformulacountry;
	}
	public String getR40_validationformularating() {
		return r40_validationformularating;
	}
	public void setR40_validationformularating(String r40_validationformularating) {
		this.r40_validationformularating = r40_validationformularating;
	}
	public String getR40_validationformulacounterparty() {
		return r40_validationformulacounterparty;
	}
	public void setR40_validationformulacounterparty(String r40_validationformulacounterparty) {
		this.r40_validationformulacounterparty = r40_validationformulacounterparty;
	}
	public String getR40_rowvalid() {
		return r40_rowvalid;
	}
	public void setR40_rowvalid(String r40_rowvalid) {
		this.r40_rowvalid = r40_rowvalid;
	}
	public String getR42_investment() {
		return r42_investment;
	}
	public void setR42_investment(String r42_investment) {
		this.r42_investment = r42_investment;
	}
	public String getR42_security() {
		return r42_security;
	}
	public void setR42_security(String r42_security) {
		this.r42_security = r42_security;
	}
	public BigDecimal getR42_nominal() {
		return r42_nominal;
	}
	public void setR42_nominal(BigDecimal r42_nominal) {
		this.r42_nominal = r42_nominal;
	}
	public BigDecimal getR42_units() {
		return r42_units;
	}
	public void setR42_units(BigDecimal r42_units) {
		this.r42_units = r42_units;
	}
	public String getR42_country() {
		return r42_country;
	}
	public void setR42_country(String r42_country) {
		this.r42_country = r42_country;
	}
	public String getR42_ccy() {
		return r42_ccy;
	}
	public void setR42_ccy(String r42_ccy) {
		this.r42_ccy = r42_ccy;
	}
	public BigDecimal getR42_amt_total_security() {
		return r42_amt_total_security;
	}
	public void setR42_amt_total_security(BigDecimal r42_amt_total_security) {
		this.r42_amt_total_security = r42_amt_total_security;
	}
	public BigDecimal getR42_aed_equivalent() {
		return r42_aed_equivalent;
	}
	public void setR42_aed_equivalent(BigDecimal r42_aed_equivalent) {
		this.r42_aed_equivalent = r42_aed_equivalent;
	}
	public BigDecimal getR42_logicfromcbs() {
		return r42_logicfromcbs;
	}
	public void setR42_logicfromcbs(BigDecimal r42_logicfromcbs) {
		this.r42_logicfromcbs = r42_logicfromcbs;
	}
	public BigDecimal getR42_logicfromktp() {
		return r42_logicfromktp;
	}
	public void setR42_logicfromktp(BigDecimal r42_logicfromktp) {
		this.r42_logicfromktp = r42_logicfromktp;
	}
	public BigDecimal getR42_rating() {
		return r42_rating;
	}
	public void setR42_rating(BigDecimal r42_rating) {
		this.r42_rating = r42_rating;
	}
	public String getR42_ratingtype() {
		return r42_ratingtype;
	}
	public void setR42_ratingtype(String r42_ratingtype) {
		this.r42_ratingtype = r42_ratingtype;
	}
	public BigDecimal getR42_market_value() {
		return r42_market_value;
	}
	public void setR42_market_value(BigDecimal r42_market_value) {
		this.r42_market_value = r42_market_value;
	}
	public String getR42_counterpartytype() {
		return r42_counterpartytype;
	}
	public void setR42_counterpartytype(String r42_counterpartytype) {
		this.r42_counterpartytype = r42_counterpartytype;
	}
	public String getR42_validationformulasecurityidentifier() {
		return r42_validationformulasecurityidentifier;
	}
	public void setR42_validationformulasecurityidentifier(String r42_validationformulasecurityidentifier) {
		this.r42_validationformulasecurityidentifier = r42_validationformulasecurityidentifier;
	}
	public String getR42_validationformulacountry() {
		return r42_validationformulacountry;
	}
	public void setR42_validationformulacountry(String r42_validationformulacountry) {
		this.r42_validationformulacountry = r42_validationformulacountry;
	}
	public String getR42_validationformularating() {
		return r42_validationformularating;
	}
	public void setR42_validationformularating(String r42_validationformularating) {
		this.r42_validationformularating = r42_validationformularating;
	}
	public String getR42_validationformulacounterparty() {
		return r42_validationformulacounterparty;
	}
	public void setR42_validationformulacounterparty(String r42_validationformulacounterparty) {
		this.r42_validationformulacounterparty = r42_validationformulacounterparty;
	}
	public String getR42_rowvalid() {
		return r42_rowvalid;
	}
	public void setR42_rowvalid(String r42_rowvalid) {
		this.r42_rowvalid = r42_rowvalid;
	}
	public String getR43_investment() {
		return r43_investment;
	}
	public void setR43_investment(String r43_investment) {
		this.r43_investment = r43_investment;
	}
	public String getR43_security() {
		return r43_security;
	}
	public void setR43_security(String r43_security) {
		this.r43_security = r43_security;
	}
	public BigDecimal getR43_nominal() {
		return r43_nominal;
	}
	public void setR43_nominal(BigDecimal r43_nominal) {
		this.r43_nominal = r43_nominal;
	}
	public BigDecimal getR43_units() {
		return r43_units;
	}
	public void setR43_units(BigDecimal r43_units) {
		this.r43_units = r43_units;
	}
	public String getR43_country() {
		return r43_country;
	}
	public void setR43_country(String r43_country) {
		this.r43_country = r43_country;
	}
	public String getR43_ccy() {
		return r43_ccy;
	}
	public void setR43_ccy(String r43_ccy) {
		this.r43_ccy = r43_ccy;
	}
	public BigDecimal getR43_amt_total_security() {
		return r43_amt_total_security;
	}
	public void setR43_amt_total_security(BigDecimal r43_amt_total_security) {
		this.r43_amt_total_security = r43_amt_total_security;
	}
	public BigDecimal getR43_aed_equivalent() {
		return r43_aed_equivalent;
	}
	public void setR43_aed_equivalent(BigDecimal r43_aed_equivalent) {
		this.r43_aed_equivalent = r43_aed_equivalent;
	}
	public BigDecimal getR43_logicfromcbs() {
		return r43_logicfromcbs;
	}
	public void setR43_logicfromcbs(BigDecimal r43_logicfromcbs) {
		this.r43_logicfromcbs = r43_logicfromcbs;
	}
	public BigDecimal getR43_logicfromktp() {
		return r43_logicfromktp;
	}
	public void setR43_logicfromktp(BigDecimal r43_logicfromktp) {
		this.r43_logicfromktp = r43_logicfromktp;
	}
	public BigDecimal getR43_rating() {
		return r43_rating;
	}
	public void setR43_rating(BigDecimal r43_rating) {
		this.r43_rating = r43_rating;
	}
	public String getR43_ratingtype() {
		return r43_ratingtype;
	}
	public void setR43_ratingtype(String r43_ratingtype) {
		this.r43_ratingtype = r43_ratingtype;
	}
	public BigDecimal getR43_market_value() {
		return r43_market_value;
	}
	public void setR43_market_value(BigDecimal r43_market_value) {
		this.r43_market_value = r43_market_value;
	}
	public String getR43_counterpartytype() {
		return r43_counterpartytype;
	}
	public void setR43_counterpartytype(String r43_counterpartytype) {
		this.r43_counterpartytype = r43_counterpartytype;
	}
	public String getR43_validationformulasecurityidentifier() {
		return r43_validationformulasecurityidentifier;
	}
	public void setR43_validationformulasecurityidentifier(String r43_validationformulasecurityidentifier) {
		this.r43_validationformulasecurityidentifier = r43_validationformulasecurityidentifier;
	}
	public String getR43_validationformulacountry() {
		return r43_validationformulacountry;
	}
	public void setR43_validationformulacountry(String r43_validationformulacountry) {
		this.r43_validationformulacountry = r43_validationformulacountry;
	}
	public String getR43_validationformularating() {
		return r43_validationformularating;
	}
	public void setR43_validationformularating(String r43_validationformularating) {
		this.r43_validationformularating = r43_validationformularating;
	}
	public String getR43_validationformulacounterparty() {
		return r43_validationformulacounterparty;
	}
	public void setR43_validationformulacounterparty(String r43_validationformulacounterparty) {
		this.r43_validationformulacounterparty = r43_validationformulacounterparty;
	}
	public String getR43_rowvalid() {
		return r43_rowvalid;
	}
	public void setR43_rowvalid(String r43_rowvalid) {
		this.r43_rowvalid = r43_rowvalid;
	}
	public String getR44_investment() {
		return r44_investment;
	}
	public void setR44_investment(String r44_investment) {
		this.r44_investment = r44_investment;
	}
	public String getR44_security() {
		return r44_security;
	}
	public void setR44_security(String r44_security) {
		this.r44_security = r44_security;
	}
	public BigDecimal getR44_nominal() {
		return r44_nominal;
	}
	public void setR44_nominal(BigDecimal r44_nominal) {
		this.r44_nominal = r44_nominal;
	}
	public BigDecimal getR44_units() {
		return r44_units;
	}
	public void setR44_units(BigDecimal r44_units) {
		this.r44_units = r44_units;
	}
	public String getR44_country() {
		return r44_country;
	}
	public void setR44_country(String r44_country) {
		this.r44_country = r44_country;
	}
	public String getR44_ccy() {
		return r44_ccy;
	}
	public void setR44_ccy(String r44_ccy) {
		this.r44_ccy = r44_ccy;
	}
	public BigDecimal getR44_amt_total_security() {
		return r44_amt_total_security;
	}
	public void setR44_amt_total_security(BigDecimal r44_amt_total_security) {
		this.r44_amt_total_security = r44_amt_total_security;
	}
	public BigDecimal getR44_aed_equivalent() {
		return r44_aed_equivalent;
	}
	public void setR44_aed_equivalent(BigDecimal r44_aed_equivalent) {
		this.r44_aed_equivalent = r44_aed_equivalent;
	}
	public BigDecimal getR44_logicfromcbs() {
		return r44_logicfromcbs;
	}
	public void setR44_logicfromcbs(BigDecimal r44_logicfromcbs) {
		this.r44_logicfromcbs = r44_logicfromcbs;
	}
	public BigDecimal getR44_logicfromktp() {
		return r44_logicfromktp;
	}
	public void setR44_logicfromktp(BigDecimal r44_logicfromktp) {
		this.r44_logicfromktp = r44_logicfromktp;
	}
	public BigDecimal getR44_rating() {
		return r44_rating;
	}
	public void setR44_rating(BigDecimal r44_rating) {
		this.r44_rating = r44_rating;
	}
	public String getR44_ratingtype() {
		return r44_ratingtype;
	}
	public void setR44_ratingtype(String r44_ratingtype) {
		this.r44_ratingtype = r44_ratingtype;
	}
	public BigDecimal getR44_market_value() {
		return r44_market_value;
	}
	public void setR44_market_value(BigDecimal r44_market_value) {
		this.r44_market_value = r44_market_value;
	}
	public String getR44_counterpartytype() {
		return r44_counterpartytype;
	}
	public void setR44_counterpartytype(String r44_counterpartytype) {
		this.r44_counterpartytype = r44_counterpartytype;
	}
	public String getR44_validationformulasecurityidentifier() {
		return r44_validationformulasecurityidentifier;
	}
	public void setR44_validationformulasecurityidentifier(String r44_validationformulasecurityidentifier) {
		this.r44_validationformulasecurityidentifier = r44_validationformulasecurityidentifier;
	}
	public String getR44_validationformulacountry() {
		return r44_validationformulacountry;
	}
	public void setR44_validationformulacountry(String r44_validationformulacountry) {
		this.r44_validationformulacountry = r44_validationformulacountry;
	}
	public String getR44_validationformularating() {
		return r44_validationformularating;
	}
	public void setR44_validationformularating(String r44_validationformularating) {
		this.r44_validationformularating = r44_validationformularating;
	}
	public String getR44_validationformulacounterparty() {
		return r44_validationformulacounterparty;
	}
	public void setR44_validationformulacounterparty(String r44_validationformulacounterparty) {
		this.r44_validationformulacounterparty = r44_validationformulacounterparty;
	}
	public String getR44_rowvalid() {
		return r44_rowvalid;
	}
	public void setR44_rowvalid(String r44_rowvalid) {
		this.r44_rowvalid = r44_rowvalid;
	}
	public String getR45_investment() {
		return r45_investment;
	}
	public void setR45_investment(String r45_investment) {
		this.r45_investment = r45_investment;
	}
	public String getR45_security() {
		return r45_security;
	}
	public void setR45_security(String r45_security) {
		this.r45_security = r45_security;
	}
	public BigDecimal getR45_nominal() {
		return r45_nominal;
	}
	public void setR45_nominal(BigDecimal r45_nominal) {
		this.r45_nominal = r45_nominal;
	}
	public BigDecimal getR45_units() {
		return r45_units;
	}
	public void setR45_units(BigDecimal r45_units) {
		this.r45_units = r45_units;
	}
	public String getR45_country() {
		return r45_country;
	}
	public void setR45_country(String r45_country) {
		this.r45_country = r45_country;
	}
	public String getR45_ccy() {
		return r45_ccy;
	}
	public void setR45_ccy(String r45_ccy) {
		this.r45_ccy = r45_ccy;
	}
	public BigDecimal getR45_amt_total_security() {
		return r45_amt_total_security;
	}
	public void setR45_amt_total_security(BigDecimal r45_amt_total_security) {
		this.r45_amt_total_security = r45_amt_total_security;
	}
	public BigDecimal getR45_aed_equivalent() {
		return r45_aed_equivalent;
	}
	public void setR45_aed_equivalent(BigDecimal r45_aed_equivalent) {
		this.r45_aed_equivalent = r45_aed_equivalent;
	}
	public BigDecimal getR45_logicfromcbs() {
		return r45_logicfromcbs;
	}
	public void setR45_logicfromcbs(BigDecimal r45_logicfromcbs) {
		this.r45_logicfromcbs = r45_logicfromcbs;
	}
	public BigDecimal getR45_logicfromktp() {
		return r45_logicfromktp;
	}
	public void setR45_logicfromktp(BigDecimal r45_logicfromktp) {
		this.r45_logicfromktp = r45_logicfromktp;
	}
	public BigDecimal getR45_rating() {
		return r45_rating;
	}
	public void setR45_rating(BigDecimal r45_rating) {
		this.r45_rating = r45_rating;
	}
	public String getR45_ratingtype() {
		return r45_ratingtype;
	}
	public void setR45_ratingtype(String r45_ratingtype) {
		this.r45_ratingtype = r45_ratingtype;
	}
	public BigDecimal getR45_market_value() {
		return r45_market_value;
	}
	public void setR45_market_value(BigDecimal r45_market_value) {
		this.r45_market_value = r45_market_value;
	}
	public String getR45_counterpartytype() {
		return r45_counterpartytype;
	}
	public void setR45_counterpartytype(String r45_counterpartytype) {
		this.r45_counterpartytype = r45_counterpartytype;
	}
	public String getR45_validationformulasecurityidentifier() {
		return r45_validationformulasecurityidentifier;
	}
	public void setR45_validationformulasecurityidentifier(String r45_validationformulasecurityidentifier) {
		this.r45_validationformulasecurityidentifier = r45_validationformulasecurityidentifier;
	}
	public String getR45_validationformulacountry() {
		return r45_validationformulacountry;
	}
	public void setR45_validationformulacountry(String r45_validationformulacountry) {
		this.r45_validationformulacountry = r45_validationformulacountry;
	}
	public String getR45_validationformularating() {
		return r45_validationformularating;
	}
	public void setR45_validationformularating(String r45_validationformularating) {
		this.r45_validationformularating = r45_validationformularating;
	}
	public String getR45_validationformulacounterparty() {
		return r45_validationformulacounterparty;
	}
	public void setR45_validationformulacounterparty(String r45_validationformulacounterparty) {
		this.r45_validationformulacounterparty = r45_validationformulacounterparty;
	}
	public String getR45_rowvalid() {
		return r45_rowvalid;
	}
	public void setR45_rowvalid(String r45_rowvalid) {
		this.r45_rowvalid = r45_rowvalid;
	}
	public String getR46_investment() {
		return r46_investment;
	}
	public void setR46_investment(String r46_investment) {
		this.r46_investment = r46_investment;
	}
	public String getR46_security() {
		return r46_security;
	}
	public void setR46_security(String r46_security) {
		this.r46_security = r46_security;
	}
	public BigDecimal getR46_nominal() {
		return r46_nominal;
	}
	public void setR46_nominal(BigDecimal r46_nominal) {
		this.r46_nominal = r46_nominal;
	}
	public BigDecimal getR46_units() {
		return r46_units;
	}
	public void setR46_units(BigDecimal r46_units) {
		this.r46_units = r46_units;
	}
	public String getR46_country() {
		return r46_country;
	}
	public void setR46_country(String r46_country) {
		this.r46_country = r46_country;
	}
	public String getR46_ccy() {
		return r46_ccy;
	}
	public void setR46_ccy(String r46_ccy) {
		this.r46_ccy = r46_ccy;
	}
	public BigDecimal getR46_amt_total_security() {
		return r46_amt_total_security;
	}
	public void setR46_amt_total_security(BigDecimal r46_amt_total_security) {
		this.r46_amt_total_security = r46_amt_total_security;
	}
	public BigDecimal getR46_aed_equivalent() {
		return r46_aed_equivalent;
	}
	public void setR46_aed_equivalent(BigDecimal r46_aed_equivalent) {
		this.r46_aed_equivalent = r46_aed_equivalent;
	}
	public BigDecimal getR46_logicfromcbs() {
		return r46_logicfromcbs;
	}
	public void setR46_logicfromcbs(BigDecimal r46_logicfromcbs) {
		this.r46_logicfromcbs = r46_logicfromcbs;
	}
	public BigDecimal getR46_logicfromktp() {
		return r46_logicfromktp;
	}
	public void setR46_logicfromktp(BigDecimal r46_logicfromktp) {
		this.r46_logicfromktp = r46_logicfromktp;
	}
	public BigDecimal getR46_rating() {
		return r46_rating;
	}
	public void setR46_rating(BigDecimal r46_rating) {
		this.r46_rating = r46_rating;
	}
	public String getR46_ratingtype() {
		return r46_ratingtype;
	}
	public void setR46_ratingtype(String r46_ratingtype) {
		this.r46_ratingtype = r46_ratingtype;
	}
	public BigDecimal getR46_market_value() {
		return r46_market_value;
	}
	public void setR46_market_value(BigDecimal r46_market_value) {
		this.r46_market_value = r46_market_value;
	}
	public String getR46_counterpartytype() {
		return r46_counterpartytype;
	}
	public void setR46_counterpartytype(String r46_counterpartytype) {
		this.r46_counterpartytype = r46_counterpartytype;
	}
	public String getR46_validationformulasecurityidentifier() {
		return r46_validationformulasecurityidentifier;
	}
	public void setR46_validationformulasecurityidentifier(String r46_validationformulasecurityidentifier) {
		this.r46_validationformulasecurityidentifier = r46_validationformulasecurityidentifier;
	}
	public String getR46_validationformulacountry() {
		return r46_validationformulacountry;
	}
	public void setR46_validationformulacountry(String r46_validationformulacountry) {
		this.r46_validationformulacountry = r46_validationformulacountry;
	}
	public String getR46_validationformularating() {
		return r46_validationformularating;
	}
	public void setR46_validationformularating(String r46_validationformularating) {
		this.r46_validationformularating = r46_validationformularating;
	}
	public String getR46_validationformulacounterparty() {
		return r46_validationformulacounterparty;
	}
	public void setR46_validationformulacounterparty(String r46_validationformulacounterparty) {
		this.r46_validationformulacounterparty = r46_validationformulacounterparty;
	}
	public String getR46_rowvalid() {
		return r46_rowvalid;
	}
	public void setR46_rowvalid(String r46_rowvalid) {
		this.r46_rowvalid = r46_rowvalid;
	}
	public String getR47_investment() {
		return r47_investment;
	}
	public void setR47_investment(String r47_investment) {
		this.r47_investment = r47_investment;
	}
	public String getR47_security() {
		return r47_security;
	}
	public void setR47_security(String r47_security) {
		this.r47_security = r47_security;
	}
	public BigDecimal getR47_nominal() {
		return r47_nominal;
	}
	public void setR47_nominal(BigDecimal r47_nominal) {
		this.r47_nominal = r47_nominal;
	}
	public BigDecimal getR47_units() {
		return r47_units;
	}
	public void setR47_units(BigDecimal r47_units) {
		this.r47_units = r47_units;
	}
	public String getR47_country() {
		return r47_country;
	}
	public void setR47_country(String r47_country) {
		this.r47_country = r47_country;
	}
	public String getR47_ccy() {
		return r47_ccy;
	}
	public void setR47_ccy(String r47_ccy) {
		this.r47_ccy = r47_ccy;
	}
	public BigDecimal getR47_amt_total_security() {
		return r47_amt_total_security;
	}
	public void setR47_amt_total_security(BigDecimal r47_amt_total_security) {
		this.r47_amt_total_security = r47_amt_total_security;
	}
	public BigDecimal getR47_aed_equivalent() {
		return r47_aed_equivalent;
	}
	public void setR47_aed_equivalent(BigDecimal r47_aed_equivalent) {
		this.r47_aed_equivalent = r47_aed_equivalent;
	}
	public BigDecimal getR47_logicfromcbs() {
		return r47_logicfromcbs;
	}
	public void setR47_logicfromcbs(BigDecimal r47_logicfromcbs) {
		this.r47_logicfromcbs = r47_logicfromcbs;
	}
	public BigDecimal getR47_logicfromktp() {
		return r47_logicfromktp;
	}
	public void setR47_logicfromktp(BigDecimal r47_logicfromktp) {
		this.r47_logicfromktp = r47_logicfromktp;
	}
	public BigDecimal getR47_rating() {
		return r47_rating;
	}
	public void setR47_rating(BigDecimal r47_rating) {
		this.r47_rating = r47_rating;
	}
	public String getR47_ratingtype() {
		return r47_ratingtype;
	}
	public void setR47_ratingtype(String r47_ratingtype) {
		this.r47_ratingtype = r47_ratingtype;
	}
	public BigDecimal getR47_market_value() {
		return r47_market_value;
	}
	public void setR47_market_value(BigDecimal r47_market_value) {
		this.r47_market_value = r47_market_value;
	}
	public String getR47_counterpartytype() {
		return r47_counterpartytype;
	}
	public void setR47_counterpartytype(String r47_counterpartytype) {
		this.r47_counterpartytype = r47_counterpartytype;
	}
	public String getR47_validationformulasecurityidentifier() {
		return r47_validationformulasecurityidentifier;
	}
	public void setR47_validationformulasecurityidentifier(String r47_validationformulasecurityidentifier) {
		this.r47_validationformulasecurityidentifier = r47_validationformulasecurityidentifier;
	}
	public String getR47_validationformulacountry() {
		return r47_validationformulacountry;
	}
	public void setR47_validationformulacountry(String r47_validationformulacountry) {
		this.r47_validationformulacountry = r47_validationformulacountry;
	}
	public String getR47_validationformularating() {
		return r47_validationformularating;
	}
	public void setR47_validationformularating(String r47_validationformularating) {
		this.r47_validationformularating = r47_validationformularating;
	}
	public String getR47_validationformulacounterparty() {
		return r47_validationformulacounterparty;
	}
	public void setR47_validationformulacounterparty(String r47_validationformulacounterparty) {
		this.r47_validationformulacounterparty = r47_validationformulacounterparty;
	}
	public String getR47_rowvalid() {
		return r47_rowvalid;
	}
	public void setR47_rowvalid(String r47_rowvalid) {
		this.r47_rowvalid = r47_rowvalid;
	}
	public String getR51_investment() {
		return r51_investment;
	}
	public void setR51_investment(String r51_investment) {
		this.r51_investment = r51_investment;
	}
	public String getR51_security() {
		return r51_security;
	}
	public void setR51_security(String r51_security) {
		this.r51_security = r51_security;
	}
	public BigDecimal getR51_nominal() {
		return r51_nominal;
	}
	public void setR51_nominal(BigDecimal r51_nominal) {
		this.r51_nominal = r51_nominal;
	}
	public BigDecimal getR51_units() {
		return r51_units;
	}
	public void setR51_units(BigDecimal r51_units) {
		this.r51_units = r51_units;
	}
	public String getR51_country() {
		return r51_country;
	}
	public void setR51_country(String r51_country) {
		this.r51_country = r51_country;
	}
	public String getR51_ccy() {
		return r51_ccy;
	}
	public void setR51_ccy(String r51_ccy) {
		this.r51_ccy = r51_ccy;
	}
	public BigDecimal getR51_amt_total_security() {
		return r51_amt_total_security;
	}
	public void setR51_amt_total_security(BigDecimal r51_amt_total_security) {
		this.r51_amt_total_security = r51_amt_total_security;
	}
	public BigDecimal getR51_aed_equivalent() {
		return r51_aed_equivalent;
	}
	public void setR51_aed_equivalent(BigDecimal r51_aed_equivalent) {
		this.r51_aed_equivalent = r51_aed_equivalent;
	}
	public BigDecimal getR51_logicfromcbs() {
		return r51_logicfromcbs;
	}
	public void setR51_logicfromcbs(BigDecimal r51_logicfromcbs) {
		this.r51_logicfromcbs = r51_logicfromcbs;
	}
	public BigDecimal getR51_logicfromktp() {
		return r51_logicfromktp;
	}
	public void setR51_logicfromktp(BigDecimal r51_logicfromktp) {
		this.r51_logicfromktp = r51_logicfromktp;
	}
	public BigDecimal getR51_rating() {
		return r51_rating;
	}
	public void setR51_rating(BigDecimal r51_rating) {
		this.r51_rating = r51_rating;
	}
	public String getR51_ratingtype() {
		return r51_ratingtype;
	}
	public void setR51_ratingtype(String r51_ratingtype) {
		this.r51_ratingtype = r51_ratingtype;
	}
	public BigDecimal getR51_market_value() {
		return r51_market_value;
	}
	public void setR51_market_value(BigDecimal r51_market_value) {
		this.r51_market_value = r51_market_value;
	}
	public String getR51_counterpartytype() {
		return r51_counterpartytype;
	}
	public void setR51_counterpartytype(String r51_counterpartytype) {
		this.r51_counterpartytype = r51_counterpartytype;
	}
	public String getR51_validationformulasecurityidentifier() {
		return r51_validationformulasecurityidentifier;
	}
	public void setR51_validationformulasecurityidentifier(String r51_validationformulasecurityidentifier) {
		this.r51_validationformulasecurityidentifier = r51_validationformulasecurityidentifier;
	}
	public String getR51_validationformulacountry() {
		return r51_validationformulacountry;
	}
	public void setR51_validationformulacountry(String r51_validationformulacountry) {
		this.r51_validationformulacountry = r51_validationformulacountry;
	}
	public String getR51_validationformularating() {
		return r51_validationformularating;
	}
	public void setR51_validationformularating(String r51_validationformularating) {
		this.r51_validationformularating = r51_validationformularating;
	}
	public String getR51_validationformulacounterparty() {
		return r51_validationformulacounterparty;
	}
	public void setR51_validationformulacounterparty(String r51_validationformulacounterparty) {
		this.r51_validationformulacounterparty = r51_validationformulacounterparty;
	}
	public String getR51_rowvalid() {
		return r51_rowvalid;
	}
	public void setR51_rowvalid(String r51_rowvalid) {
		this.r51_rowvalid = r51_rowvalid;
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
	public BRF5_ENTITY() {
		super();
		
	}
	public BRF5_ENTITY(String cust_id, String foracid, String acct_name, BigDecimal acct_balance_lc,
			String report_name_1, String report_lable_1, String report_addl_criteria_1, String report_addl_criteria_2,
			String report_addl_criteria_3, String create_user, Date create_time, String modify_user, Date modify_time,
			String verify_user, Date verify_time, String entity_flg2, String modify_flg2, String del_flg2,
			Date report_date2, BigDecimal acct_balance_ac) {
		// TODO Auto-generated constructor stub
	}


	
	
}
