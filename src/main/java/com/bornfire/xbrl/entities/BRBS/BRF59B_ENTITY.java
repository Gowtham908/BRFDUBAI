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
@Table(name="BRF59B_SUMMARYTABLE")


public class BRF59B_ENTITY {

	
	private String	r22_product;
	private BigDecimal	r22_nbfi;
	private BigDecimal	r22_interbank;
	private BigDecimal	r22_gov;
	private BigDecimal	r22_corporate;
	private BigDecimal	r22_gre;
	private BigDecimal	r22_trade;
	private BigDecimal	r22_individuals;
	private BigDecimal	r22_investment;
	private BigDecimal	r22_nbfi1;
	private BigDecimal	r22_interbank1;
	private BigDecimal	r22_gov1;
	private BigDecimal	r22_corporate1;
	private BigDecimal	r22_gre1;
	private BigDecimal	r22_trade1;
	private BigDecimal	r22_individuals1;
	private BigDecimal	r22_investment1;
	private BigDecimal	r22_zer0;
	private BigDecimal	r22_three;
	private BigDecimal	r22_six;
	private BigDecimal	r22_oneyear;
	private BigDecimal	r22_foreign;
	private BigDecimal	r22_banks;
	private BigDecimal	r22_gov2;
	private BigDecimal	r22_other;
	private BigDecimal	r22_banks1;
	private BigDecimal	r22_individuals2;
	private BigDecimal	r22_other1;
	private BigDecimal	r22_banks2;
	private BigDecimal	r22_gov3;
	private BigDecimal	r22_others2;
	private BigDecimal	r22_banks3;
	private BigDecimal	r22_gov4;
	private BigDecimal	r22_others3;
	private BigDecimal	r22_foreign1;
	private BigDecimal	r22_guarantees;
	private BigDecimal	r22_nbfi2;
	private BigDecimal	r22_interbank2;
	private BigDecimal	r22_gov5;
	private BigDecimal	r22_corporate2;
	private BigDecimal	r22_gre2;
	private BigDecimal	r22_individuals3;
	private BigDecimal	r22_zero1;
	private BigDecimal	r22_three1;
	private BigDecimal	r22_six1;
	private BigDecimal	r22_oneyear1;
	private String	r22_empty;
	private String	r23_product;
	private BigDecimal	r23_nbfi;
	private BigDecimal	r23_interbank;
	private BigDecimal	r23_gov;
	private BigDecimal	r23_corporate;
	private BigDecimal	r23_gre;
	private BigDecimal	r23_trade;
	private BigDecimal	r23_individuals;
	private BigDecimal	r23_investment;
	private BigDecimal	r23_nbfi1;
	private BigDecimal	r23_interbank1;
	private BigDecimal	r23_gov1;
	private BigDecimal	r23_corporate1;
	private BigDecimal	r23_gre1;
	private BigDecimal	r23_trade1;
	private BigDecimal	r23_individuals1;
	private BigDecimal	r23_investment1;
	private BigDecimal	r23_zer0;
	private BigDecimal	r23_three;
	private BigDecimal	r23_six;
	private BigDecimal	r23_oneyear;
	private BigDecimal	r23_foreign;
	private BigDecimal	r23_banks;
	private BigDecimal	r23_gov2;
	private BigDecimal	r23_other;
	private BigDecimal	r23_banks1;
	private BigDecimal	r23_individuals2;
	private BigDecimal	r23_other1;
	private BigDecimal	r23_banks2;
	private BigDecimal	r23_gov3;
	private BigDecimal	r23_others2;
	private BigDecimal	r23_banks3;
	private BigDecimal	r23_gov4;
	private BigDecimal	r23_others3;
	private BigDecimal	r23_foreign1;
	private BigDecimal	r23_guarantees;
	private BigDecimal	r23_nbfi2;
	private BigDecimal	r23_interbank2;
	private BigDecimal	r23_gov5;
	private BigDecimal	r23_corporate2;
	private BigDecimal	r23_gre2;
	private BigDecimal	r23_individuals3;
	private BigDecimal	r23_zero1;
	private BigDecimal	r23_three1;
	private BigDecimal	r23_six1;
	private BigDecimal	r23_oneyear1;
	private String	r23_empty;
	private String	r24_product;
	private BigDecimal	r24_nbfi;
	private BigDecimal	r24_interbank;
	private BigDecimal	r24_gov;
	private BigDecimal	r24_corporate;
	private BigDecimal	r24_gre;
	private BigDecimal	r24_trade;
	private BigDecimal	r24_individuals;
	private BigDecimal	r24_investment;
	private BigDecimal	r24_nbfi1;
	private BigDecimal	r24_interbank1;
	private BigDecimal	r24_gov1;
	private BigDecimal	r24_corporate1;
	private BigDecimal	r24_gre1;
	private BigDecimal	r24_trade1;
	private BigDecimal	r24_individuals1;
	private BigDecimal	r24_investment1;
	private BigDecimal	r24_zer0;
	private BigDecimal	r24_three;
	private BigDecimal	r24_six;
	private BigDecimal	r24_oneyear;
	private BigDecimal	r24_foreign;
	private BigDecimal	r24_banks;
	private BigDecimal	r24_gov2;
	private BigDecimal	r24_other;
	private BigDecimal	r24_banks1;
	private BigDecimal	r24_individuals2;
	private BigDecimal	r24_other1;
	private BigDecimal	r24_banks2;
	private BigDecimal	r24_gov3;
	private BigDecimal	r24_others2;
	private BigDecimal	r24_banks3;
	private BigDecimal	r24_gov4;
	private BigDecimal	r24_others3;
	private BigDecimal	r24_foreign1;
	private BigDecimal	r24_guarantees;
	private BigDecimal	r24_nbfi2;
	private BigDecimal	r24_interbank2;
	private BigDecimal	r24_gov5;
	private BigDecimal	r24_corporate2;
	private BigDecimal	r24_gre2;
	private BigDecimal	r24_individuals3;
	private BigDecimal	r24_zero1;
	private BigDecimal	r24_three1;
	private BigDecimal	r24_six1;
	private BigDecimal	r24_oneyear1;
	private String	r24_empty;
	private String	r25_product;
	private BigDecimal	r25_nbfi;
	private BigDecimal	r25_interbank;
	private BigDecimal	r25_gov;
	private BigDecimal	r25_corporate;
	private BigDecimal	r25_gre;
	private BigDecimal	r25_trade;
	private BigDecimal	r25_individuals;
	private BigDecimal	r25_investment;
	private BigDecimal	r25_nbfi1;
	private BigDecimal	r25_interbank1;
	private BigDecimal	r25_gov1;
	private BigDecimal	r25_corporate1;
	private BigDecimal	r25_gre1;
	private BigDecimal	r25_trade1;
	private BigDecimal	r25_individuals1;
	private BigDecimal	r25_investment1;
	private BigDecimal	r25_zer0;
	private BigDecimal	r25_three;
	private BigDecimal	r25_six;
	private BigDecimal	r25_oneyear;
	private BigDecimal	r25_foreign;
	private BigDecimal	r25_banks;
	private BigDecimal	r25_gov2;
	private BigDecimal	r25_other;
	private BigDecimal	r25_banks1;
	private BigDecimal	r25_individuals2;
	private BigDecimal	r25_other1;
	private BigDecimal	r25_banks2;
	private BigDecimal	r25_gov3;
	private BigDecimal	r25_others2;
	private BigDecimal	r25_banks3;
	private BigDecimal	r25_gov4;
	private BigDecimal	r25_others3;
	private BigDecimal	r25_foreign1;
	private BigDecimal	r25_guarantees;
	private BigDecimal	r25_nbfi2;
	private BigDecimal	r25_interbank2;
	private BigDecimal	r25_gov5;
	private BigDecimal	r25_corporate2;
	private BigDecimal	r25_gre2;
	private BigDecimal	r25_individuals3;
	private BigDecimal	r25_zero1;
	private BigDecimal	r25_three1;
	private BigDecimal	r25_six1;
	private BigDecimal	r25_oneyear1;
	private String	r25_empty;
	private String	r26_product;
	private BigDecimal	r26_nbfi;
	private BigDecimal	r26_interbank;
	private BigDecimal	r26_gov;
	private BigDecimal	r26_corporate;
	private BigDecimal	r26_gre;
	private BigDecimal	r26_trade;
	private BigDecimal	r26_individuals;
	private BigDecimal	r26_investment;
	private BigDecimal	r26_nbfi1;
	private BigDecimal	r26_interbank1;
	private BigDecimal	r26_gov1;
	private BigDecimal	r26_corporate1;
	private BigDecimal	r26_gre1;
	private BigDecimal	r26_trade1;
	private BigDecimal	r26_individuals1;
	private BigDecimal	r26_investment1;
	private BigDecimal	r26_zer0;
	private BigDecimal	r26_three;
	private BigDecimal	r26_six;
	private BigDecimal	r26_oneyear;
	private BigDecimal	r26_foreign;
	private BigDecimal	r26_banks;
	private BigDecimal	r26_gov2;
	private BigDecimal	r26_other;
	private BigDecimal	r26_banks1;
	private BigDecimal	r26_individuals2;
	private BigDecimal	r26_other1;
	private BigDecimal	r26_banks2;
	private BigDecimal	r26_gov3;
	private BigDecimal	r26_others2;
	private BigDecimal	r26_banks3;
	private BigDecimal	r26_gov4;
	private BigDecimal	r26_others3;
	private BigDecimal	r26_foreign1;
	private BigDecimal	r26_guarantees;
	private BigDecimal	r26_nbfi2;
	private BigDecimal	r26_interbank2;
	private BigDecimal	r26_gov5;
	private BigDecimal	r26_corporate2;
	private BigDecimal	r26_gre2;
	private BigDecimal	r26_individuals3;
	private BigDecimal	r26_zero1;
	private BigDecimal	r26_three1;
	private BigDecimal	r26_six1;
	private BigDecimal	r26_oneyear1;
	private String	r26_empty;
	private String	r27_product;
	private BigDecimal	r27_nbfi;
	private BigDecimal	r27_interbank;
	private BigDecimal	r27_gov;
	private BigDecimal	r27_corporate;
	private BigDecimal	r27_gre;
	private BigDecimal	r27_trade;
	private BigDecimal	r27_individuals;
	private BigDecimal	r27_investment;
	private BigDecimal	r27_nbfi1;
	private BigDecimal	r27_interbank1;
	private BigDecimal	r27_gov1;
	private BigDecimal	r27_corporate1;
	private BigDecimal	r27_gre1;
	private BigDecimal	r27_trade1;
	private BigDecimal	r27_individuals1;
	private BigDecimal	r27_investment1;
	private BigDecimal	r27_zer0;
	private BigDecimal	r27_three;
	private BigDecimal	r27_six;
	private BigDecimal	r27_oneyear;
	private BigDecimal	r27_foreign;
	private BigDecimal	r27_banks;
	private BigDecimal	r27_gov2;
	private BigDecimal	r27_other;
	private BigDecimal	r27_banks1;
	private BigDecimal	r27_individuals2;
	private BigDecimal	r27_other1;
	private BigDecimal	r27_banks2;
	private BigDecimal	r27_gov3;
	private BigDecimal	r27_others2;
	private BigDecimal	r27_banks3;
	private BigDecimal	r27_gov4;
	private BigDecimal	r27_others3;
	private BigDecimal	r27_foreign1;
	private BigDecimal	r27_guarantees;
	private BigDecimal	r27_nbfi2;
	private BigDecimal	r27_interbank2;
	private BigDecimal	r27_gov5;
	private BigDecimal	r27_corporate2;
	private BigDecimal	r27_gre2;
	private BigDecimal	r27_individuals3;
	private BigDecimal	r27_zero1;
	private BigDecimal	r27_three1;
	private BigDecimal	r27_six1;
	private BigDecimal	r27_oneyear1;
	private String	r27_empty;
	private String	r28_product;
	private BigDecimal	r28_nbfi;
	private BigDecimal	r28_interbank;
	private BigDecimal	r28_gov;
	private BigDecimal	r28_corporate;
	private BigDecimal	r28_gre;
	private BigDecimal	r28_trade;
	private BigDecimal	r28_individuals;
	private BigDecimal	r28_investment;
	private BigDecimal	r28_nbfi1;
	private BigDecimal	r28_interbank1;
	private BigDecimal	r28_gov1;
	private BigDecimal	r28_corporate1;
	private BigDecimal	r28_gre1;
	private BigDecimal	r28_trade1;
	private BigDecimal	r28_individuals1;
	private BigDecimal	r28_investment1;
	private BigDecimal	r28_zer0;
	private BigDecimal	r28_three;
	private BigDecimal	r28_six;
	private BigDecimal	r28_oneyear;
	private BigDecimal	r28_foreign;
	private BigDecimal	r28_banks;
	private BigDecimal	r28_gov2;
	private BigDecimal	r28_other;
	private BigDecimal	r28_banks1;
	private BigDecimal	r28_individuals2;
	private BigDecimal	r28_other1;
	private BigDecimal	r28_banks2;
	private BigDecimal	r28_gov3;
	private BigDecimal	r28_others2;
	private BigDecimal	r28_banks3;
	private BigDecimal	r28_gov4;
	private BigDecimal	r28_others3;
	private BigDecimal	r28_foreign1;
	private BigDecimal	r28_guarantees;
	private BigDecimal	r28_nbfi2;
	private BigDecimal	r28_interbank2;
	private BigDecimal	r28_gov5;
	private BigDecimal	r28_corporate2;
	private BigDecimal	r28_gre2;
	private BigDecimal	r28_individuals3;
	private BigDecimal	r28_zero1;
	private BigDecimal	r28_three1;
	private BigDecimal	r28_six1;
	private BigDecimal	r28_oneyear1;
	private String	r28_empty;
	private String	r29_product;
	private BigDecimal	r29_nbfi;
	private BigDecimal	r29_interbank;
	private BigDecimal	r29_gov;
	private BigDecimal	r29_corporate;
	private BigDecimal	r29_gre;
	private BigDecimal	r29_trade;
	private BigDecimal	r29_individuals;
	private BigDecimal	r29_investment;
	private BigDecimal	r29_nbfi1;
	private BigDecimal	r29_interbank1;
	private BigDecimal	r29_gov1;
	private BigDecimal	r29_corporate1;
	private BigDecimal	r29_gre1;
	private BigDecimal	r29_trade1;
	private BigDecimal	r29_individuals1;
	private BigDecimal	r29_investment1;
	private BigDecimal	r29_zer0;
	private BigDecimal	r29_three;
	private BigDecimal	r29_six;
	private BigDecimal	r29_oneyear;
	private BigDecimal	r29_foreign;
	private BigDecimal	r29_banks;
	private BigDecimal	r29_gov2;
	private BigDecimal	r29_other;
	private BigDecimal	r29_banks1;
	private BigDecimal	r29_individuals2;
	private BigDecimal	r29_other1;
	private BigDecimal	r29_banks2;
	private BigDecimal	r29_gov3;
	private BigDecimal	r29_others2;
	private BigDecimal	r29_banks3;
	private BigDecimal	r29_gov4;
	private BigDecimal	r29_others3;
	private BigDecimal	r29_foreign1;
	private BigDecimal	r29_guarantees;
	private BigDecimal	r29_nbfi2;
	private BigDecimal	r29_interbank2;
	private BigDecimal	r29_gov5;
	private BigDecimal	r29_corporate2;
	private BigDecimal	r29_gre2;
	private BigDecimal	r29_individuals3;
	private BigDecimal	r29_zero1;
	private BigDecimal	r29_three1;
	private BigDecimal	r29_six1;
	private BigDecimal	r29_oneyear1;
	private String	r29_empty;
	private String	r30_product;
	private BigDecimal	r30_nbfi;
	private BigDecimal	r30_interbank;
	private BigDecimal	r30_gov;
	private BigDecimal	r30_corporate;
	private BigDecimal	r30_gre;
	private BigDecimal	r30_trade;
	private BigDecimal	r30_individuals;
	private BigDecimal	r30_investment;
	private BigDecimal	r30_nbfi1;
	private BigDecimal	r30_interbank1;
	private BigDecimal	r30_gov1;
	private BigDecimal	r30_corporate1;
	private BigDecimal	r30_gre1;
	private BigDecimal	r30_trade1;
	private BigDecimal	r30_individuals1;
	private BigDecimal	r30_investment1;
	private BigDecimal	r30_zer0;
	private BigDecimal	r30_three;
	private BigDecimal	r30_six;
	private BigDecimal	r30_oneyear;
	private BigDecimal	r30_foreign;
	private BigDecimal	r30_banks;
	private BigDecimal	r30_gov2;
	private BigDecimal	r30_other;
	private BigDecimal	r30_banks1;
	private BigDecimal	r30_individuals2;
	private BigDecimal	r30_other1;
	private BigDecimal	r30_banks2;
	private BigDecimal	r30_gov3;
	private BigDecimal	r30_others2;
	private BigDecimal	r30_banks3;
	private BigDecimal	r30_gov4;
	private BigDecimal	r30_others3;
	private BigDecimal	r30_foreign1;
	private BigDecimal	r30_guarantees;
	private BigDecimal	r30_nbfi2;
	private BigDecimal	r30_interbank2;
	private BigDecimal	r30_gov5;
	private BigDecimal	r30_corporate2;
	private BigDecimal	r30_gre2;
	private BigDecimal	r30_individuals3;
	private BigDecimal	r30_zero1;
	private BigDecimal	r30_three1;
	private BigDecimal	r30_six1;
	private BigDecimal	r30_oneyear1;
	private String	r30_empty;
	private String	r31_product;
	private BigDecimal	r31_nbfi;
	private BigDecimal	r31_interbank;
	private BigDecimal	r31_gov;
	private BigDecimal	r31_corporate;
	private BigDecimal	r31_gre;
	private BigDecimal	r31_trade;
	private BigDecimal	r31_individuals;
	private BigDecimal	r31_investment;
	private BigDecimal	r31_nbfi1;
	private BigDecimal	r31_interbank1;
	private BigDecimal	r31_gov1;
	private BigDecimal	r31_corporate1;
	private BigDecimal	r31_gre1;
	private BigDecimal	r31_trade1;
	private BigDecimal	r31_individuals1;
	private BigDecimal	r31_investment1;
	private BigDecimal	r31_zer0;
	private BigDecimal	r31_three;
	private BigDecimal	r31_six;
	private BigDecimal	r31_oneyear;
	private BigDecimal	r31_foreign;
	private BigDecimal	r31_banks;
	private BigDecimal	r31_gov2;
	private BigDecimal	r31_other;
	private BigDecimal	r31_banks1;
	private BigDecimal	r31_individuals2;
	private BigDecimal	r31_other1;
	private BigDecimal	r31_banks2;
	private BigDecimal	r31_gov3;
	private BigDecimal	r31_others2;
	private BigDecimal	r31_banks3;
	private BigDecimal	r31_gov4;
	private BigDecimal	r31_others3;
	private BigDecimal	r31_foreign1;
	private BigDecimal	r31_guarantees;
	private BigDecimal	r31_nbfi2;
	private BigDecimal	r31_interbank2;
	private BigDecimal	r31_gov5;
	private BigDecimal	r31_corporate2;
	private BigDecimal	r31_gre2;
	private BigDecimal	r31_individuals3;
	private BigDecimal	r31_zero1;
	private BigDecimal	r31_three1;
	private BigDecimal	r31_six1;
	private BigDecimal	r31_oneyear1;
	private String	r31_empty;
	private String	r32_product;
	private BigDecimal	r32_nbfi;
	private BigDecimal	r32_interbank;
	private BigDecimal	r32_gov;
	private BigDecimal	r32_corporate;
	private BigDecimal	r32_gre;
	private BigDecimal	r32_trade;
	private BigDecimal	r32_individuals;
	private BigDecimal	r32_investment;
	private BigDecimal	r32_nbfi1;
	private BigDecimal	r32_interbank1;
	private BigDecimal	r32_gov1;
	private BigDecimal	r32_corporate1;
	private BigDecimal	r32_gre1;
	private BigDecimal	r32_trade1;
	private BigDecimal	r32_individuals1;
	private BigDecimal	r32_investment1;
	private BigDecimal	r32_zer0;
	private BigDecimal	r32_three;
	private BigDecimal	r32_six;
	private BigDecimal	r32_oneyear;
	private BigDecimal	r32_foreign;
	private BigDecimal	r32_banks;
	private BigDecimal	r32_gov2;
	private BigDecimal	r32_other;
	private BigDecimal	r32_banks1;
	private BigDecimal	r32_individuals2;
	private BigDecimal	r32_other1;
	private BigDecimal	r32_banks2;
	private BigDecimal	r32_gov3;
	private BigDecimal	r32_others2;
	private BigDecimal	r32_banks3;
	private BigDecimal	r32_gov4;
	private BigDecimal	r32_others3;
	private BigDecimal	r32_foreign1;
	private BigDecimal	r32_guarantees;
	private BigDecimal	r32_nbfi2;
	private BigDecimal	r32_interbank2;
	private BigDecimal	r32_gov5;
	private BigDecimal	r32_corporate2;
	private BigDecimal	r32_gre2;
	private BigDecimal	r32_individuals3;
	private BigDecimal	r32_zero1;
	private BigDecimal	r32_three1;
	private BigDecimal	r32_six1;
	private BigDecimal	r32_oneyear1;
	private String	r32_empty;
	private String	r33_product;
	private BigDecimal	r33_nbfi;
	private BigDecimal	r33_interbank;
	private BigDecimal	r33_gov;
	private BigDecimal	r33_corporate;
	private BigDecimal	r33_gre;
	private BigDecimal	r33_trade;
	private BigDecimal	r33_individuals;
	private BigDecimal	r33_investment;
	private BigDecimal	r33_nbfi1;
	private BigDecimal	r33_interbank1;
	private BigDecimal	r33_gov1;
	private BigDecimal	r33_corporate1;
	private BigDecimal	r33_gre1;
	private BigDecimal	r33_trade1;
	private BigDecimal	r33_individuals1;
	private BigDecimal	r33_investment1;
	private BigDecimal	r33_zer0;
	private BigDecimal	r33_three;
	private BigDecimal	r33_six;
	private BigDecimal	r33_oneyear;
	private BigDecimal	r33_foreign;
	private BigDecimal	r33_banks;
	private BigDecimal	r33_gov2;
	private BigDecimal	r33_other;
	private BigDecimal	r33_banks1;
	private BigDecimal	r33_individuals2;
	private BigDecimal	r33_other1;
	private BigDecimal	r33_banks2;
	private BigDecimal	r33_gov3;
	private BigDecimal	r33_others2;
	private BigDecimal	r33_banks3;
	private BigDecimal	r33_gov4;
	private BigDecimal	r33_others3;
	private BigDecimal	r33_foreign1;
	private BigDecimal	r33_guarantees;
	private BigDecimal	r33_nbfi2;
	private BigDecimal	r33_interbank2;
	private BigDecimal	r33_gov5;
	private BigDecimal	r33_corporate2;
	private BigDecimal	r33_gre2;
	private BigDecimal	r33_individuals3;
	private BigDecimal	r33_zero1;
	private BigDecimal	r33_three1;
	private BigDecimal	r33_six1;
	private BigDecimal	r33_oneyear1;
	private String	r33_empty;
	private String	r34_product;
	private BigDecimal	r34_nbfi;
	private BigDecimal	r34_interbank;
	private BigDecimal	r34_gov;
	private BigDecimal	r34_corporate;
	private BigDecimal	r34_gre;
	private BigDecimal	r34_trade;
	private BigDecimal	r34_individuals;
	private BigDecimal	r34_investment;
	private BigDecimal	r34_nbfi1;
	private BigDecimal	r34_interbank1;
	private BigDecimal	r34_gov1;
	private BigDecimal	r34_corporate1;
	private BigDecimal	r34_gre1;
	private BigDecimal	r34_trade1;
	private BigDecimal	r34_individuals1;
	private BigDecimal	r34_investment1;
	private BigDecimal	r34_zer0;
	private BigDecimal	r34_three;
	private BigDecimal	r34_six;
	private BigDecimal	r34_oneyear;
	private BigDecimal	r34_foreign;
	private BigDecimal	r34_banks;
	private BigDecimal	r34_gov2;
	private BigDecimal	r34_other;
	private BigDecimal	r34_banks1;
	private BigDecimal	r34_individuals2;
	private BigDecimal	r34_other1;
	private BigDecimal	r34_banks2;
	private BigDecimal	r34_gov3;
	private BigDecimal	r34_others2;
	private BigDecimal	r34_banks3;
	private BigDecimal	r34_gov4;
	private BigDecimal	r34_others3;
	private BigDecimal	r34_foreign1;
	private BigDecimal	r34_guarantees;
	private BigDecimal	r34_nbfi2;
	private BigDecimal	r34_interbank2;
	private BigDecimal	r34_gov5;
	private BigDecimal	r34_corporate2;
	private BigDecimal	r34_gre2;
	private BigDecimal	r34_individuals3;
	private BigDecimal	r34_zero1;
	private BigDecimal	r34_three1;
	private BigDecimal	r34_six1;
	private BigDecimal	r34_oneyear1;
	private String	r34_empty;
	private String	r35_product;
	private BigDecimal	r35_nbfi;
	private BigDecimal	r35_interbank;
	private BigDecimal	r35_gov;
	private BigDecimal	r35_corporate;
	private BigDecimal	r35_gre;
	private BigDecimal	r35_trade;
	private BigDecimal	r35_individuals;
	private BigDecimal	r35_investment;
	private BigDecimal	r35_nbfi1;
	private BigDecimal	r35_interbank1;
	private BigDecimal	r35_gov1;
	private BigDecimal	r35_corporate1;
	private BigDecimal	r35_gre1;
	private BigDecimal	r35_trade1;
	private BigDecimal	r35_individuals1;
	private BigDecimal	r35_investment1;
	private BigDecimal	r35_zer0;
	private BigDecimal	r35_three;
	private BigDecimal	r35_six;
	private BigDecimal	r35_oneyear;
	private BigDecimal	r35_foreign;
	private BigDecimal	r35_banks;
	private BigDecimal	r35_gov2;
	private BigDecimal	r35_other;
	private BigDecimal	r35_banks1;
	private BigDecimal	r35_individuals2;
	private BigDecimal	r35_other1;
	private BigDecimal	r35_banks2;
	private BigDecimal	r35_gov3;
	private BigDecimal	r35_others2;
	private BigDecimal	r35_banks3;
	private BigDecimal	r35_gov4;
	private BigDecimal	r35_others3;
	private BigDecimal	r35_foreign1;
	private BigDecimal	r35_guarantees;
	private BigDecimal	r35_nbfi2;
	private BigDecimal	r35_interbank2;
	private BigDecimal	r35_gov5;
	private BigDecimal	r35_corporate2;
	private BigDecimal	r35_gre2;
	private BigDecimal	r35_individuals3;
	private BigDecimal	r35_zero1;
	private BigDecimal	r35_three1;
	private BigDecimal	r35_six1;
	private BigDecimal	r35_oneyear1;
	private String	r35_empty;
	private String	r36_product;
	private BigDecimal	r36_nbfi;
	private BigDecimal	r36_interbank;
	private BigDecimal	r36_gov;
	private BigDecimal	r36_corporate;
	private BigDecimal	r36_gre;
	private BigDecimal	r36_trade;
	private BigDecimal	r36_individuals;
	private BigDecimal	r36_investment;
	private BigDecimal	r36_nbfi1;
	private BigDecimal	r36_interbank1;
	private BigDecimal	r36_gov1;
	private BigDecimal	r36_corporate1;
	private BigDecimal	r36_gre1;
	private BigDecimal	r36_trade1;
	private BigDecimal	r36_individuals1;
	private BigDecimal	r36_investment1;
	private BigDecimal	r36_zer0;
	private BigDecimal	r36_three;
	private BigDecimal	r36_six;
	private BigDecimal	r36_oneyear;
	private BigDecimal	r36_foreign;
	private BigDecimal	r36_banks;
	private BigDecimal	r36_gov2;
	private BigDecimal	r36_other;
	private BigDecimal	r36_banks1;
	private BigDecimal	r36_individuals2;
	private BigDecimal	r36_other1;
	private BigDecimal	r36_banks2;
	private BigDecimal	r36_gov3;
	private BigDecimal	r36_others2;
	private BigDecimal	r36_banks3;
	private BigDecimal	r36_gov4;
	private BigDecimal	r36_others3;
	private BigDecimal	r36_foreign1;
	private BigDecimal	r36_guarantees;
	private BigDecimal	r36_nbfi2;
	private BigDecimal	r36_interbank2;
	private BigDecimal	r36_gov5;
	private BigDecimal	r36_corporate2;
	private BigDecimal	r36_gre2;
	private BigDecimal	r36_individuals3;
	private BigDecimal	r36_zero1;
	private BigDecimal	r36_three1;
	private BigDecimal	r36_six1;
	private BigDecimal	r36_oneyear1;
	private String	r36_empty;
	private String	r37_product;
	private BigDecimal	r37_nbfi;
	private BigDecimal	r37_interbank;
	private BigDecimal	r37_gov;
	private BigDecimal	r37_corporate;
	private BigDecimal	r37_gre;
	private BigDecimal	r37_trade;
	private BigDecimal	r37_individuals;
	private BigDecimal	r37_investment;
	private BigDecimal	r37_nbfi1;
	private BigDecimal	r37_interbank1;
	private BigDecimal	r37_gov1;
	private BigDecimal	r37_corporate1;
	private BigDecimal	r37_gre1;
	private BigDecimal	r37_trade1;
	private BigDecimal	r37_individuals1;
	private BigDecimal	r37_investment1;
	private BigDecimal	r37_zer0;
	private BigDecimal	r37_three;
	private BigDecimal	r37_six;
	private BigDecimal	r37_oneyear;
	private BigDecimal	r37_foreign;
	private BigDecimal	r37_banks;
	private BigDecimal	r37_gov2;
	private BigDecimal	r37_other;
	private BigDecimal	r37_banks1;
	private BigDecimal	r37_individuals2;
	private BigDecimal	r37_other1;
	private BigDecimal	r37_banks2;
	private BigDecimal	r37_gov3;
	private BigDecimal	r37_others2;
	private BigDecimal	r37_banks3;
	private BigDecimal	r37_gov4;
	private BigDecimal	r37_others3;
	private BigDecimal	r37_foreign1;
	private BigDecimal	r37_guarantees;
	private BigDecimal	r37_nbfi2;
	private BigDecimal	r37_interbank2;
	private BigDecimal	r37_gov5;
	private BigDecimal	r37_corporate2;
	private BigDecimal	r37_gre2;
	private BigDecimal	r37_individuals3;
	private BigDecimal	r37_zero1;
	private BigDecimal	r37_three1;
	private BigDecimal	r37_six1;
	private BigDecimal	r37_oneyear1;
	private String	r37_empty;
	private String	r38_product;
	private BigDecimal	r38_nbfi;
	private BigDecimal	r38_interbank;
	private BigDecimal	r38_gov;
	private BigDecimal	r38_corporate;
	private BigDecimal	r38_gre;
	private BigDecimal	r38_trade;
	private BigDecimal	r38_individuals;
	private BigDecimal	r38_investment;
	private BigDecimal	r38_nbfi1;
	private BigDecimal	r38_interbank1;
	private BigDecimal	r38_gov1;
	private BigDecimal	r38_corporate1;
	private BigDecimal	r38_gre1;
	private BigDecimal	r38_trade1;
	private BigDecimal	r38_individuals1;
	private BigDecimal	r38_investment1;
	private BigDecimal	r38_zer0;
	private BigDecimal	r38_three;
	private BigDecimal	r38_six;
	private BigDecimal	r38_oneyear;
	private BigDecimal	r38_foreign;
	private BigDecimal	r38_banks;
	private BigDecimal	r38_gov2;
	private BigDecimal	r38_other;
	private BigDecimal	r38_banks1;
	private BigDecimal	r38_individuals2;
	private BigDecimal	r38_other1;
	private BigDecimal	r38_banks2;
	private BigDecimal	r38_gov3;
	private BigDecimal	r38_others2;
	private BigDecimal	r38_banks3;
	private BigDecimal	r38_gov4;
	private BigDecimal	r38_others3;
	private BigDecimal	r38_foreign1;
	private BigDecimal	r38_guarantees;
	private BigDecimal	r38_nbfi2;
	private BigDecimal	r38_interbank2;
	private BigDecimal	r38_gov5;
	private BigDecimal	r38_corporate2;
	private BigDecimal	r38_gre2;
	private BigDecimal	r38_individuals3;
	private BigDecimal	r38_zero1;
	private BigDecimal	r38_three1;
	private BigDecimal	r38_six1;
	private BigDecimal	r38_oneyear1;
	private String	r38_empty;
	private String	r39_product;
	private BigDecimal	r39_nbfi;
	private BigDecimal	r39_interbank;
	private BigDecimal	r39_gov;
	private BigDecimal	r39_corporate;
	private BigDecimal	r39_gre;
	private BigDecimal	r39_trade;
	private BigDecimal	r39_individuals;
	private BigDecimal	r39_investment;
	private BigDecimal	r39_nbfi1;
	private BigDecimal	r39_interbank1;
	private BigDecimal	r39_gov1;
	private BigDecimal	r39_corporate1;
	private BigDecimal	r39_gre1;
	private BigDecimal	r39_trade1;
	private BigDecimal	r39_individuals1;
	private BigDecimal	r39_investment1;
	private BigDecimal	r39_zer0;
	private BigDecimal	r39_three;
	private BigDecimal	r39_six;
	private BigDecimal	r39_oneyear;
	private BigDecimal	r39_foreign;
	private BigDecimal	r39_banks;
	private BigDecimal	r39_gov2;
	private BigDecimal	r39_other;
	private BigDecimal	r39_banks1;
	private BigDecimal	r39_individuals2;
	private BigDecimal	r39_other1;
	private BigDecimal	r39_banks2;
	private BigDecimal	r39_gov3;
	private BigDecimal	r39_others2;
	private BigDecimal	r39_banks3;
	private BigDecimal	r39_gov4;
	private BigDecimal	r39_others3;
	private BigDecimal	r39_foreign1;
	private BigDecimal	r39_guarantees;
	private BigDecimal	r39_nbfi2;
	private BigDecimal	r39_interbank2;
	private BigDecimal	r39_gov5;
	private BigDecimal	r39_corporate2;
	private BigDecimal	r39_gre2;
	private BigDecimal	r39_individuals3;
	private BigDecimal	r39_zero1;
	private BigDecimal	r39_three1;
	private BigDecimal	r39_six1;
	private BigDecimal	r39_oneyear1;
	private String	r39_empty;
	private String	r40_product;
	private BigDecimal	r40_nbfi;
	private BigDecimal	r40_interbank;
	private BigDecimal	r40_gov;
	private BigDecimal	r40_corporate;
	private BigDecimal	r40_gre;
	private BigDecimal	r40_trade;
	private BigDecimal	r40_individuals;
	private BigDecimal	r40_investment;
	private BigDecimal	r40_nbfi1;
	private BigDecimal	r40_interbank1;
	private BigDecimal	r40_gov1;
	private BigDecimal	r40_corporate1;
	private BigDecimal	r40_gre1;
	private BigDecimal	r40_trade1;
	private BigDecimal	r40_individuals1;
	private BigDecimal	r40_investment1;
	private BigDecimal	r40_zer0;
	private BigDecimal	r40_three;
	private BigDecimal	r40_six;
	private BigDecimal	r40_oneyear;
	private BigDecimal	r40_foreign;
	private BigDecimal	r40_banks;
	private BigDecimal	r40_gov2;
	private BigDecimal	r40_other;
	private BigDecimal	r40_banks1;
	private BigDecimal	r40_individuals2;
	private BigDecimal	r40_other1;
	private BigDecimal	r40_banks2;
	private BigDecimal	r40_gov3;
	private BigDecimal	r40_others2;
	private BigDecimal	r40_banks3;
	private BigDecimal	r40_gov4;
	private BigDecimal	r40_others3;
	private BigDecimal	r40_foreign1;
	private BigDecimal	r40_guarantees;
	private BigDecimal	r40_nbfi2;
	private BigDecimal	r40_interbank2;
	private BigDecimal	r40_gov5;
	private BigDecimal	r40_corporate2;
	private BigDecimal	r40_gre2;
	private BigDecimal	r40_individuals3;
	private BigDecimal	r40_zero1;
	private BigDecimal	r40_three1;
	private BigDecimal	r40_six1;
	private BigDecimal	r40_oneyear1;
	private String	r40_empty;
	private String	r41_product;
	private BigDecimal	r41_nbfi;
	private BigDecimal	r41_interbank;
	private BigDecimal	r41_gov;
	private BigDecimal	r41_corporate;
	private BigDecimal	r41_gre;
	private BigDecimal	r41_trade;
	private BigDecimal	r41_individuals;
	private BigDecimal	r41_investment;
	private BigDecimal	r41_nbfi1;
	private BigDecimal	r41_interbank1;
	private BigDecimal	r41_gov1;
	private BigDecimal	r41_corporate1;
	private BigDecimal	r41_gre1;
	private BigDecimal	r41_trade1;
	private BigDecimal	r41_individuals1;
	private BigDecimal	r41_investment1;
	private BigDecimal	r41_zer0;
	private BigDecimal	r41_three;
	private BigDecimal	r41_six;
	private BigDecimal	r41_oneyear;
	private BigDecimal	r41_foreign;
	private BigDecimal	r41_banks;
	private BigDecimal	r41_gov2;
	private BigDecimal	r41_other;
	private BigDecimal	r41_banks1;
	private BigDecimal	r41_individuals2;
	private BigDecimal	r41_other1;
	private BigDecimal	r41_banks2;
	private BigDecimal	r41_gov3;
	private BigDecimal	r41_others2;
	private BigDecimal	r41_banks3;
	private BigDecimal	r41_gov4;
	private BigDecimal	r41_others3;
	private BigDecimal	r41_foreign1;
	private BigDecimal	r41_guarantees;
	private BigDecimal	r41_nbfi2;
	private BigDecimal	r41_interbank2;
	private BigDecimal	r41_gov5;
	private BigDecimal	r41_corporate2;
	private BigDecimal	r41_gre2;
	private BigDecimal	r41_individuals3;
	private BigDecimal	r41_zero1;
	private BigDecimal	r41_three1;
	private BigDecimal	r41_six1;
	private BigDecimal	r41_oneyear1;
	private String	r41_empty;
	private String	r42_product;
	private BigDecimal	r42_nbfi;
	private BigDecimal	r42_interbank;
	private BigDecimal	r42_gov;
	private BigDecimal	r42_corporate;
	private BigDecimal	r42_gre;
	private BigDecimal	r42_trade;
	private BigDecimal	r42_individuals;
	private BigDecimal	r42_investment;
	private BigDecimal	r42_nbfi1;
	private BigDecimal	r42_interbank1;
	private BigDecimal	r42_gov1;
	private BigDecimal	r42_corporate1;
	private BigDecimal	r42_gre1;
	private BigDecimal	r42_trade1;
	private BigDecimal	r42_individuals1;
	private BigDecimal	r42_investment1;
	private BigDecimal	r42_zer0;
	private BigDecimal	r42_three;
	private BigDecimal	r42_six;
	private BigDecimal	r42_oneyear;
	private BigDecimal	r42_foreign;
	private BigDecimal	r42_banks;
	private BigDecimal	r42_gov2;
	private BigDecimal	r42_other;
	private BigDecimal	r42_banks1;
	private BigDecimal	r42_individuals2;
	private BigDecimal	r42_other1;
	private BigDecimal	r42_banks2;
	private BigDecimal	r42_gov3;
	private BigDecimal	r42_others2;
	private BigDecimal	r42_banks3;
	private BigDecimal	r42_gov4;
	private BigDecimal	r42_others3;
	private BigDecimal	r42_foreign1;
	private BigDecimal	r42_guarantees;
	private BigDecimal	r42_nbfi2;
	private BigDecimal	r42_interbank2;
	private BigDecimal	r42_gov5;
	private BigDecimal	r42_corporate2;
	private BigDecimal	r42_gre2;
	private BigDecimal	r42_individuals3;
	private BigDecimal	r42_zero1;
	private BigDecimal	r42_three1;
	private BigDecimal	r42_six1;
	private BigDecimal	r42_oneyear1;
	private String	r42_empty;
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
	private String	repdesc;
	private String	frequency;
	public String getR22_product() {
		return r22_product;
	}
	public void setR22_product(String r22_product) {
		this.r22_product = r22_product;
	}
	public BigDecimal getR22_nbfi() {
		return r22_nbfi;
	}
	public void setR22_nbfi(BigDecimal r22_nbfi) {
		this.r22_nbfi = r22_nbfi;
	}
	public BigDecimal getR22_interbank() {
		return r22_interbank;
	}
	public void setR22_interbank(BigDecimal r22_interbank) {
		this.r22_interbank = r22_interbank;
	}
	public BigDecimal getR22_gov() {
		return r22_gov;
	}
	public void setR22_gov(BigDecimal r22_gov) {
		this.r22_gov = r22_gov;
	}
	public BigDecimal getR22_corporate() {
		return r22_corporate;
	}
	public void setR22_corporate(BigDecimal r22_corporate) {
		this.r22_corporate = r22_corporate;
	}
	public BigDecimal getR22_gre() {
		return r22_gre;
	}
	public void setR22_gre(BigDecimal r22_gre) {
		this.r22_gre = r22_gre;
	}
	public BigDecimal getR22_trade() {
		return r22_trade;
	}
	public void setR22_trade(BigDecimal r22_trade) {
		this.r22_trade = r22_trade;
	}
	public BigDecimal getR22_individuals() {
		return r22_individuals;
	}
	public void setR22_individuals(BigDecimal r22_individuals) {
		this.r22_individuals = r22_individuals;
	}
	public BigDecimal getR22_investment() {
		return r22_investment;
	}
	public void setR22_investment(BigDecimal r22_investment) {
		this.r22_investment = r22_investment;
	}
	public BigDecimal getR22_nbfi1() {
		return r22_nbfi1;
	}
	public void setR22_nbfi1(BigDecimal r22_nbfi1) {
		this.r22_nbfi1 = r22_nbfi1;
	}
	public BigDecimal getR22_interbank1() {
		return r22_interbank1;
	}
	public void setR22_interbank1(BigDecimal r22_interbank1) {
		this.r22_interbank1 = r22_interbank1;
	}
	public BigDecimal getR22_gov1() {
		return r22_gov1;
	}
	public void setR22_gov1(BigDecimal r22_gov1) {
		this.r22_gov1 = r22_gov1;
	}
	public BigDecimal getR22_corporate1() {
		return r22_corporate1;
	}
	public void setR22_corporate1(BigDecimal r22_corporate1) {
		this.r22_corporate1 = r22_corporate1;
	}
	public BigDecimal getR22_gre1() {
		return r22_gre1;
	}
	public void setR22_gre1(BigDecimal r22_gre1) {
		this.r22_gre1 = r22_gre1;
	}
	public BigDecimal getR22_trade1() {
		return r22_trade1;
	}
	public void setR22_trade1(BigDecimal r22_trade1) {
		this.r22_trade1 = r22_trade1;
	}
	public BigDecimal getR22_individuals1() {
		return r22_individuals1;
	}
	public void setR22_individuals1(BigDecimal r22_individuals1) {
		this.r22_individuals1 = r22_individuals1;
	}
	public BigDecimal getR22_investment1() {
		return r22_investment1;
	}
	public void setR22_investment1(BigDecimal r22_investment1) {
		this.r22_investment1 = r22_investment1;
	}
	public BigDecimal getR22_zer0() {
		return r22_zer0;
	}
	public void setR22_zer0(BigDecimal r22_zer0) {
		this.r22_zer0 = r22_zer0;
	}
	public BigDecimal getR22_three() {
		return r22_three;
	}
	public void setR22_three(BigDecimal r22_three) {
		this.r22_three = r22_three;
	}
	public BigDecimal getR22_six() {
		return r22_six;
	}
	public void setR22_six(BigDecimal r22_six) {
		this.r22_six = r22_six;
	}
	public BigDecimal getR22_oneyear() {
		return r22_oneyear;
	}
	public void setR22_oneyear(BigDecimal r22_oneyear) {
		this.r22_oneyear = r22_oneyear;
	}
	public BigDecimal getR22_foreign() {
		return r22_foreign;
	}
	public void setR22_foreign(BigDecimal r22_foreign) {
		this.r22_foreign = r22_foreign;
	}
	public BigDecimal getR22_banks() {
		return r22_banks;
	}
	public void setR22_banks(BigDecimal r22_banks) {
		this.r22_banks = r22_banks;
	}
	public BigDecimal getR22_gov2() {
		return r22_gov2;
	}
	public void setR22_gov2(BigDecimal r22_gov2) {
		this.r22_gov2 = r22_gov2;
	}
	public BigDecimal getR22_other() {
		return r22_other;
	}
	public void setR22_other(BigDecimal r22_other) {
		this.r22_other = r22_other;
	}
	public BigDecimal getR22_banks1() {
		return r22_banks1;
	}
	public void setR22_banks1(BigDecimal r22_banks1) {
		this.r22_banks1 = r22_banks1;
	}
	public BigDecimal getR22_individuals2() {
		return r22_individuals2;
	}
	public void setR22_individuals2(BigDecimal r22_individuals2) {
		this.r22_individuals2 = r22_individuals2;
	}
	public BigDecimal getR22_other1() {
		return r22_other1;
	}
	public void setR22_other1(BigDecimal r22_other1) {
		this.r22_other1 = r22_other1;
	}
	public BigDecimal getR22_banks2() {
		return r22_banks2;
	}
	public void setR22_banks2(BigDecimal r22_banks2) {
		this.r22_banks2 = r22_banks2;
	}
	public BigDecimal getR22_gov3() {
		return r22_gov3;
	}
	public void setR22_gov3(BigDecimal r22_gov3) {
		this.r22_gov3 = r22_gov3;
	}
	public BigDecimal getR22_others2() {
		return r22_others2;
	}
	public void setR22_others2(BigDecimal r22_others2) {
		this.r22_others2 = r22_others2;
	}
	public BigDecimal getR22_banks3() {
		return r22_banks3;
	}
	public void setR22_banks3(BigDecimal r22_banks3) {
		this.r22_banks3 = r22_banks3;
	}
	public BigDecimal getR22_gov4() {
		return r22_gov4;
	}
	public void setR22_gov4(BigDecimal r22_gov4) {
		this.r22_gov4 = r22_gov4;
	}
	public BigDecimal getR22_others3() {
		return r22_others3;
	}
	public void setR22_others3(BigDecimal r22_others3) {
		this.r22_others3 = r22_others3;
	}
	public BigDecimal getR22_foreign1() {
		return r22_foreign1;
	}
	public void setR22_foreign1(BigDecimal r22_foreign1) {
		this.r22_foreign1 = r22_foreign1;
	}
	public BigDecimal getR22_guarantees() {
		return r22_guarantees;
	}
	public void setR22_guarantees(BigDecimal r22_guarantees) {
		this.r22_guarantees = r22_guarantees;
	}
	public BigDecimal getR22_nbfi2() {
		return r22_nbfi2;
	}
	public void setR22_nbfi2(BigDecimal r22_nbfi2) {
		this.r22_nbfi2 = r22_nbfi2;
	}
	public BigDecimal getR22_interbank2() {
		return r22_interbank2;
	}
	public void setR22_interbank2(BigDecimal r22_interbank2) {
		this.r22_interbank2 = r22_interbank2;
	}
	public BigDecimal getR22_gov5() {
		return r22_gov5;
	}
	public void setR22_gov5(BigDecimal r22_gov5) {
		this.r22_gov5 = r22_gov5;
	}
	public BigDecimal getR22_corporate2() {
		return r22_corporate2;
	}
	public void setR22_corporate2(BigDecimal r22_corporate2) {
		this.r22_corporate2 = r22_corporate2;
	}
	public BigDecimal getR22_gre2() {
		return r22_gre2;
	}
	public void setR22_gre2(BigDecimal r22_gre2) {
		this.r22_gre2 = r22_gre2;
	}
	public BigDecimal getR22_individuals3() {
		return r22_individuals3;
	}
	public void setR22_individuals3(BigDecimal r22_individuals3) {
		this.r22_individuals3 = r22_individuals3;
	}
	public BigDecimal getR22_zero1() {
		return r22_zero1;
	}
	public void setR22_zero1(BigDecimal r22_zero1) {
		this.r22_zero1 = r22_zero1;
	}
	public BigDecimal getR22_three1() {
		return r22_three1;
	}
	public void setR22_three1(BigDecimal r22_three1) {
		this.r22_three1 = r22_three1;
	}
	public BigDecimal getR22_six1() {
		return r22_six1;
	}
	public void setR22_six1(BigDecimal r22_six1) {
		this.r22_six1 = r22_six1;
	}
	public BigDecimal getR22_oneyear1() {
		return r22_oneyear1;
	}
	public void setR22_oneyear1(BigDecimal r22_oneyear1) {
		this.r22_oneyear1 = r22_oneyear1;
	}
	public String getR22_empty() {
		return r22_empty;
	}
	public void setR22_empty(String r22_empty) {
		this.r22_empty = r22_empty;
	}
	public String getR23_product() {
		return r23_product;
	}
	public void setR23_product(String r23_product) {
		this.r23_product = r23_product;
	}
	public BigDecimal getR23_nbfi() {
		return r23_nbfi;
	}
	public void setR23_nbfi(BigDecimal r23_nbfi) {
		this.r23_nbfi = r23_nbfi;
	}
	public BigDecimal getR23_interbank() {
		return r23_interbank;
	}
	public void setR23_interbank(BigDecimal r23_interbank) {
		this.r23_interbank = r23_interbank;
	}
	public BigDecimal getR23_gov() {
		return r23_gov;
	}
	public void setR23_gov(BigDecimal r23_gov) {
		this.r23_gov = r23_gov;
	}
	public BigDecimal getR23_corporate() {
		return r23_corporate;
	}
	public void setR23_corporate(BigDecimal r23_corporate) {
		this.r23_corporate = r23_corporate;
	}
	public BigDecimal getR23_gre() {
		return r23_gre;
	}
	public void setR23_gre(BigDecimal r23_gre) {
		this.r23_gre = r23_gre;
	}
	public BigDecimal getR23_trade() {
		return r23_trade;
	}
	public void setR23_trade(BigDecimal r23_trade) {
		this.r23_trade = r23_trade;
	}
	public BigDecimal getR23_individuals() {
		return r23_individuals;
	}
	public void setR23_individuals(BigDecimal r23_individuals) {
		this.r23_individuals = r23_individuals;
	}
	public BigDecimal getR23_investment() {
		return r23_investment;
	}
	public void setR23_investment(BigDecimal r23_investment) {
		this.r23_investment = r23_investment;
	}
	public BigDecimal getR23_nbfi1() {
		return r23_nbfi1;
	}
	public void setR23_nbfi1(BigDecimal r23_nbfi1) {
		this.r23_nbfi1 = r23_nbfi1;
	}
	public BigDecimal getR23_interbank1() {
		return r23_interbank1;
	}
	public void setR23_interbank1(BigDecimal r23_interbank1) {
		this.r23_interbank1 = r23_interbank1;
	}
	public BigDecimal getR23_gov1() {
		return r23_gov1;
	}
	public void setR23_gov1(BigDecimal r23_gov1) {
		this.r23_gov1 = r23_gov1;
	}
	public BigDecimal getR23_corporate1() {
		return r23_corporate1;
	}
	public void setR23_corporate1(BigDecimal r23_corporate1) {
		this.r23_corporate1 = r23_corporate1;
	}
	public BigDecimal getR23_gre1() {
		return r23_gre1;
	}
	public void setR23_gre1(BigDecimal r23_gre1) {
		this.r23_gre1 = r23_gre1;
	}
	public BigDecimal getR23_trade1() {
		return r23_trade1;
	}
	public void setR23_trade1(BigDecimal r23_trade1) {
		this.r23_trade1 = r23_trade1;
	}
	public BigDecimal getR23_individuals1() {
		return r23_individuals1;
	}
	public void setR23_individuals1(BigDecimal r23_individuals1) {
		this.r23_individuals1 = r23_individuals1;
	}
	public BigDecimal getR23_investment1() {
		return r23_investment1;
	}
	public void setR23_investment1(BigDecimal r23_investment1) {
		this.r23_investment1 = r23_investment1;
	}
	public BigDecimal getR23_zer0() {
		return r23_zer0;
	}
	public void setR23_zer0(BigDecimal r23_zer0) {
		this.r23_zer0 = r23_zer0;
	}
	public BigDecimal getR23_three() {
		return r23_three;
	}
	public void setR23_three(BigDecimal r23_three) {
		this.r23_three = r23_three;
	}
	public BigDecimal getR23_six() {
		return r23_six;
	}
	public void setR23_six(BigDecimal r23_six) {
		this.r23_six = r23_six;
	}
	public BigDecimal getR23_oneyear() {
		return r23_oneyear;
	}
	public void setR23_oneyear(BigDecimal r23_oneyear) {
		this.r23_oneyear = r23_oneyear;
	}
	public BigDecimal getR23_foreign() {
		return r23_foreign;
	}
	public void setR23_foreign(BigDecimal r23_foreign) {
		this.r23_foreign = r23_foreign;
	}
	public BigDecimal getR23_banks() {
		return r23_banks;
	}
	public void setR23_banks(BigDecimal r23_banks) {
		this.r23_banks = r23_banks;
	}
	public BigDecimal getR23_gov2() {
		return r23_gov2;
	}
	public void setR23_gov2(BigDecimal r23_gov2) {
		this.r23_gov2 = r23_gov2;
	}
	public BigDecimal getR23_other() {
		return r23_other;
	}
	public void setR23_other(BigDecimal r23_other) {
		this.r23_other = r23_other;
	}
	public BigDecimal getR23_banks1() {
		return r23_banks1;
	}
	public void setR23_banks1(BigDecimal r23_banks1) {
		this.r23_banks1 = r23_banks1;
	}
	public BigDecimal getR23_individuals2() {
		return r23_individuals2;
	}
	public void setR23_individuals2(BigDecimal r23_individuals2) {
		this.r23_individuals2 = r23_individuals2;
	}
	public BigDecimal getR23_other1() {
		return r23_other1;
	}
	public void setR23_other1(BigDecimal r23_other1) {
		this.r23_other1 = r23_other1;
	}
	public BigDecimal getR23_banks2() {
		return r23_banks2;
	}
	public void setR23_banks2(BigDecimal r23_banks2) {
		this.r23_banks2 = r23_banks2;
	}
	public BigDecimal getR23_gov3() {
		return r23_gov3;
	}
	public void setR23_gov3(BigDecimal r23_gov3) {
		this.r23_gov3 = r23_gov3;
	}
	public BigDecimal getR23_others2() {
		return r23_others2;
	}
	public void setR23_others2(BigDecimal r23_others2) {
		this.r23_others2 = r23_others2;
	}
	public BigDecimal getR23_banks3() {
		return r23_banks3;
	}
	public void setR23_banks3(BigDecimal r23_banks3) {
		this.r23_banks3 = r23_banks3;
	}
	public BigDecimal getR23_gov4() {
		return r23_gov4;
	}
	public void setR23_gov4(BigDecimal r23_gov4) {
		this.r23_gov4 = r23_gov4;
	}
	public BigDecimal getR23_others3() {
		return r23_others3;
	}
	public void setR23_others3(BigDecimal r23_others3) {
		this.r23_others3 = r23_others3;
	}
	public BigDecimal getR23_foreign1() {
		return r23_foreign1;
	}
	public void setR23_foreign1(BigDecimal r23_foreign1) {
		this.r23_foreign1 = r23_foreign1;
	}
	public BigDecimal getR23_guarantees() {
		return r23_guarantees;
	}
	public void setR23_guarantees(BigDecimal r23_guarantees) {
		this.r23_guarantees = r23_guarantees;
	}
	public BigDecimal getR23_nbfi2() {
		return r23_nbfi2;
	}
	public void setR23_nbfi2(BigDecimal r23_nbfi2) {
		this.r23_nbfi2 = r23_nbfi2;
	}
	public BigDecimal getR23_interbank2() {
		return r23_interbank2;
	}
	public void setR23_interbank2(BigDecimal r23_interbank2) {
		this.r23_interbank2 = r23_interbank2;
	}
	public BigDecimal getR23_gov5() {
		return r23_gov5;
	}
	public void setR23_gov5(BigDecimal r23_gov5) {
		this.r23_gov5 = r23_gov5;
	}
	public BigDecimal getR23_corporate2() {
		return r23_corporate2;
	}
	public void setR23_corporate2(BigDecimal r23_corporate2) {
		this.r23_corporate2 = r23_corporate2;
	}
	public BigDecimal getR23_gre2() {
		return r23_gre2;
	}
	public void setR23_gre2(BigDecimal r23_gre2) {
		this.r23_gre2 = r23_gre2;
	}
	public BigDecimal getR23_individuals3() {
		return r23_individuals3;
	}
	public void setR23_individuals3(BigDecimal r23_individuals3) {
		this.r23_individuals3 = r23_individuals3;
	}
	public BigDecimal getR23_zero1() {
		return r23_zero1;
	}
	public void setR23_zero1(BigDecimal r23_zero1) {
		this.r23_zero1 = r23_zero1;
	}
	public BigDecimal getR23_three1() {
		return r23_three1;
	}
	public void setR23_three1(BigDecimal r23_three1) {
		this.r23_three1 = r23_three1;
	}
	public BigDecimal getR23_six1() {
		return r23_six1;
	}
	public void setR23_six1(BigDecimal r23_six1) {
		this.r23_six1 = r23_six1;
	}
	public BigDecimal getR23_oneyear1() {
		return r23_oneyear1;
	}
	public void setR23_oneyear1(BigDecimal r23_oneyear1) {
		this.r23_oneyear1 = r23_oneyear1;
	}
	public String getR23_empty() {
		return r23_empty;
	}
	public void setR23_empty(String r23_empty) {
		this.r23_empty = r23_empty;
	}
	public String getR24_product() {
		return r24_product;
	}
	public void setR24_product(String r24_product) {
		this.r24_product = r24_product;
	}
	public BigDecimal getR24_nbfi() {
		return r24_nbfi;
	}
	public void setR24_nbfi(BigDecimal r24_nbfi) {
		this.r24_nbfi = r24_nbfi;
	}
	public BigDecimal getR24_interbank() {
		return r24_interbank;
	}
	public void setR24_interbank(BigDecimal r24_interbank) {
		this.r24_interbank = r24_interbank;
	}
	public BigDecimal getR24_gov() {
		return r24_gov;
	}
	public void setR24_gov(BigDecimal r24_gov) {
		this.r24_gov = r24_gov;
	}
	public BigDecimal getR24_corporate() {
		return r24_corporate;
	}
	public void setR24_corporate(BigDecimal r24_corporate) {
		this.r24_corporate = r24_corporate;
	}
	public BigDecimal getR24_gre() {
		return r24_gre;
	}
	public void setR24_gre(BigDecimal r24_gre) {
		this.r24_gre = r24_gre;
	}
	public BigDecimal getR24_trade() {
		return r24_trade;
	}
	public void setR24_trade(BigDecimal r24_trade) {
		this.r24_trade = r24_trade;
	}
	public BigDecimal getR24_individuals() {
		return r24_individuals;
	}
	public void setR24_individuals(BigDecimal r24_individuals) {
		this.r24_individuals = r24_individuals;
	}
	public BigDecimal getR24_investment() {
		return r24_investment;
	}
	public void setR24_investment(BigDecimal r24_investment) {
		this.r24_investment = r24_investment;
	}
	public BigDecimal getR24_nbfi1() {
		return r24_nbfi1;
	}
	public void setR24_nbfi1(BigDecimal r24_nbfi1) {
		this.r24_nbfi1 = r24_nbfi1;
	}
	public BigDecimal getR24_interbank1() {
		return r24_interbank1;
	}
	public void setR24_interbank1(BigDecimal r24_interbank1) {
		this.r24_interbank1 = r24_interbank1;
	}
	public BigDecimal getR24_gov1() {
		return r24_gov1;
	}
	public void setR24_gov1(BigDecimal r24_gov1) {
		this.r24_gov1 = r24_gov1;
	}
	public BigDecimal getR24_corporate1() {
		return r24_corporate1;
	}
	public void setR24_corporate1(BigDecimal r24_corporate1) {
		this.r24_corporate1 = r24_corporate1;
	}
	public BigDecimal getR24_gre1() {
		return r24_gre1;
	}
	public void setR24_gre1(BigDecimal r24_gre1) {
		this.r24_gre1 = r24_gre1;
	}
	public BigDecimal getR24_trade1() {
		return r24_trade1;
	}
	public void setR24_trade1(BigDecimal r24_trade1) {
		this.r24_trade1 = r24_trade1;
	}
	public BigDecimal getR24_individuals1() {
		return r24_individuals1;
	}
	public void setR24_individuals1(BigDecimal r24_individuals1) {
		this.r24_individuals1 = r24_individuals1;
	}
	public BigDecimal getR24_investment1() {
		return r24_investment1;
	}
	public void setR24_investment1(BigDecimal r24_investment1) {
		this.r24_investment1 = r24_investment1;
	}
	public BigDecimal getR24_zer0() {
		return r24_zer0;
	}
	public void setR24_zer0(BigDecimal r24_zer0) {
		this.r24_zer0 = r24_zer0;
	}
	public BigDecimal getR24_three() {
		return r24_three;
	}
	public void setR24_three(BigDecimal r24_three) {
		this.r24_three = r24_three;
	}
	public BigDecimal getR24_six() {
		return r24_six;
	}
	public void setR24_six(BigDecimal r24_six) {
		this.r24_six = r24_six;
	}
	public BigDecimal getR24_oneyear() {
		return r24_oneyear;
	}
	public void setR24_oneyear(BigDecimal r24_oneyear) {
		this.r24_oneyear = r24_oneyear;
	}
	public BigDecimal getR24_foreign() {
		return r24_foreign;
	}
	public void setR24_foreign(BigDecimal r24_foreign) {
		this.r24_foreign = r24_foreign;
	}
	public BigDecimal getR24_banks() {
		return r24_banks;
	}
	public void setR24_banks(BigDecimal r24_banks) {
		this.r24_banks = r24_banks;
	}
	public BigDecimal getR24_gov2() {
		return r24_gov2;
	}
	public void setR24_gov2(BigDecimal r24_gov2) {
		this.r24_gov2 = r24_gov2;
	}
	public BigDecimal getR24_other() {
		return r24_other;
	}
	public void setR24_other(BigDecimal r24_other) {
		this.r24_other = r24_other;
	}
	public BigDecimal getR24_banks1() {
		return r24_banks1;
	}
	public void setR24_banks1(BigDecimal r24_banks1) {
		this.r24_banks1 = r24_banks1;
	}
	public BigDecimal getR24_individuals2() {
		return r24_individuals2;
	}
	public void setR24_individuals2(BigDecimal r24_individuals2) {
		this.r24_individuals2 = r24_individuals2;
	}
	public BigDecimal getR24_other1() {
		return r24_other1;
	}
	public void setR24_other1(BigDecimal r24_other1) {
		this.r24_other1 = r24_other1;
	}
	public BigDecimal getR24_banks2() {
		return r24_banks2;
	}
	public void setR24_banks2(BigDecimal r24_banks2) {
		this.r24_banks2 = r24_banks2;
	}
	public BigDecimal getR24_gov3() {
		return r24_gov3;
	}
	public void setR24_gov3(BigDecimal r24_gov3) {
		this.r24_gov3 = r24_gov3;
	}
	public BigDecimal getR24_others2() {
		return r24_others2;
	}
	public void setR24_others2(BigDecimal r24_others2) {
		this.r24_others2 = r24_others2;
	}
	public BigDecimal getR24_banks3() {
		return r24_banks3;
	}
	public void setR24_banks3(BigDecimal r24_banks3) {
		this.r24_banks3 = r24_banks3;
	}
	public BigDecimal getR24_gov4() {
		return r24_gov4;
	}
	public void setR24_gov4(BigDecimal r24_gov4) {
		this.r24_gov4 = r24_gov4;
	}
	public BigDecimal getR24_others3() {
		return r24_others3;
	}
	public void setR24_others3(BigDecimal r24_others3) {
		this.r24_others3 = r24_others3;
	}
	public BigDecimal getR24_foreign1() {
		return r24_foreign1;
	}
	public void setR24_foreign1(BigDecimal r24_foreign1) {
		this.r24_foreign1 = r24_foreign1;
	}
	public BigDecimal getR24_guarantees() {
		return r24_guarantees;
	}
	public void setR24_guarantees(BigDecimal r24_guarantees) {
		this.r24_guarantees = r24_guarantees;
	}
	public BigDecimal getR24_nbfi2() {
		return r24_nbfi2;
	}
	public void setR24_nbfi2(BigDecimal r24_nbfi2) {
		this.r24_nbfi2 = r24_nbfi2;
	}
	public BigDecimal getR24_interbank2() {
		return r24_interbank2;
	}
	public void setR24_interbank2(BigDecimal r24_interbank2) {
		this.r24_interbank2 = r24_interbank2;
	}
	public BigDecimal getR24_gov5() {
		return r24_gov5;
	}
	public void setR24_gov5(BigDecimal r24_gov5) {
		this.r24_gov5 = r24_gov5;
	}
	public BigDecimal getR24_corporate2() {
		return r24_corporate2;
	}
	public void setR24_corporate2(BigDecimal r24_corporate2) {
		this.r24_corporate2 = r24_corporate2;
	}
	public BigDecimal getR24_gre2() {
		return r24_gre2;
	}
	public void setR24_gre2(BigDecimal r24_gre2) {
		this.r24_gre2 = r24_gre2;
	}
	public BigDecimal getR24_individuals3() {
		return r24_individuals3;
	}
	public void setR24_individuals3(BigDecimal r24_individuals3) {
		this.r24_individuals3 = r24_individuals3;
	}
	public BigDecimal getR24_zero1() {
		return r24_zero1;
	}
	public void setR24_zero1(BigDecimal r24_zero1) {
		this.r24_zero1 = r24_zero1;
	}
	public BigDecimal getR24_three1() {
		return r24_three1;
	}
	public void setR24_three1(BigDecimal r24_three1) {
		this.r24_three1 = r24_three1;
	}
	public BigDecimal getR24_six1() {
		return r24_six1;
	}
	public void setR24_six1(BigDecimal r24_six1) {
		this.r24_six1 = r24_six1;
	}
	public BigDecimal getR24_oneyear1() {
		return r24_oneyear1;
	}
	public void setR24_oneyear1(BigDecimal r24_oneyear1) {
		this.r24_oneyear1 = r24_oneyear1;
	}
	public String getR24_empty() {
		return r24_empty;
	}
	public void setR24_empty(String r24_empty) {
		this.r24_empty = r24_empty;
	}
	public String getR25_product() {
		return r25_product;
	}
	public void setR25_product(String r25_product) {
		this.r25_product = r25_product;
	}
	public BigDecimal getR25_nbfi() {
		return r25_nbfi;
	}
	public void setR25_nbfi(BigDecimal r25_nbfi) {
		this.r25_nbfi = r25_nbfi;
	}
	public BigDecimal getR25_interbank() {
		return r25_interbank;
	}
	public void setR25_interbank(BigDecimal r25_interbank) {
		this.r25_interbank = r25_interbank;
	}
	public BigDecimal getR25_gov() {
		return r25_gov;
	}
	public void setR25_gov(BigDecimal r25_gov) {
		this.r25_gov = r25_gov;
	}
	public BigDecimal getR25_corporate() {
		return r25_corporate;
	}
	public void setR25_corporate(BigDecimal r25_corporate) {
		this.r25_corporate = r25_corporate;
	}
	public BigDecimal getR25_gre() {
		return r25_gre;
	}
	public void setR25_gre(BigDecimal r25_gre) {
		this.r25_gre = r25_gre;
	}
	public BigDecimal getR25_trade() {
		return r25_trade;
	}
	public void setR25_trade(BigDecimal r25_trade) {
		this.r25_trade = r25_trade;
	}
	public BigDecimal getR25_individuals() {
		return r25_individuals;
	}
	public void setR25_individuals(BigDecimal r25_individuals) {
		this.r25_individuals = r25_individuals;
	}
	public BigDecimal getR25_investment() {
		return r25_investment;
	}
	public void setR25_investment(BigDecimal r25_investment) {
		this.r25_investment = r25_investment;
	}
	public BigDecimal getR25_nbfi1() {
		return r25_nbfi1;
	}
	public void setR25_nbfi1(BigDecimal r25_nbfi1) {
		this.r25_nbfi1 = r25_nbfi1;
	}
	public BigDecimal getR25_interbank1() {
		return r25_interbank1;
	}
	public void setR25_interbank1(BigDecimal r25_interbank1) {
		this.r25_interbank1 = r25_interbank1;
	}
	public BigDecimal getR25_gov1() {
		return r25_gov1;
	}
	public void setR25_gov1(BigDecimal r25_gov1) {
		this.r25_gov1 = r25_gov1;
	}
	public BigDecimal getR25_corporate1() {
		return r25_corporate1;
	}
	public void setR25_corporate1(BigDecimal r25_corporate1) {
		this.r25_corporate1 = r25_corporate1;
	}
	public BigDecimal getR25_gre1() {
		return r25_gre1;
	}
	public void setR25_gre1(BigDecimal r25_gre1) {
		this.r25_gre1 = r25_gre1;
	}
	public BigDecimal getR25_trade1() {
		return r25_trade1;
	}
	public void setR25_trade1(BigDecimal r25_trade1) {
		this.r25_trade1 = r25_trade1;
	}
	public BigDecimal getR25_individuals1() {
		return r25_individuals1;
	}
	public void setR25_individuals1(BigDecimal r25_individuals1) {
		this.r25_individuals1 = r25_individuals1;
	}
	public BigDecimal getR25_investment1() {
		return r25_investment1;
	}
	public void setR25_investment1(BigDecimal r25_investment1) {
		this.r25_investment1 = r25_investment1;
	}
	public BigDecimal getR25_zer0() {
		return r25_zer0;
	}
	public void setR25_zer0(BigDecimal r25_zer0) {
		this.r25_zer0 = r25_zer0;
	}
	public BigDecimal getR25_three() {
		return r25_three;
	}
	public void setR25_three(BigDecimal r25_three) {
		this.r25_three = r25_three;
	}
	public BigDecimal getR25_six() {
		return r25_six;
	}
	public void setR25_six(BigDecimal r25_six) {
		this.r25_six = r25_six;
	}
	public BigDecimal getR25_oneyear() {
		return r25_oneyear;
	}
	public void setR25_oneyear(BigDecimal r25_oneyear) {
		this.r25_oneyear = r25_oneyear;
	}
	public BigDecimal getR25_foreign() {
		return r25_foreign;
	}
	public void setR25_foreign(BigDecimal r25_foreign) {
		this.r25_foreign = r25_foreign;
	}
	public BigDecimal getR25_banks() {
		return r25_banks;
	}
	public void setR25_banks(BigDecimal r25_banks) {
		this.r25_banks = r25_banks;
	}
	public BigDecimal getR25_gov2() {
		return r25_gov2;
	}
	public void setR25_gov2(BigDecimal r25_gov2) {
		this.r25_gov2 = r25_gov2;
	}
	public BigDecimal getR25_other() {
		return r25_other;
	}
	public void setR25_other(BigDecimal r25_other) {
		this.r25_other = r25_other;
	}
	public BigDecimal getR25_banks1() {
		return r25_banks1;
	}
	public void setR25_banks1(BigDecimal r25_banks1) {
		this.r25_banks1 = r25_banks1;
	}
	public BigDecimal getR25_individuals2() {
		return r25_individuals2;
	}
	public void setR25_individuals2(BigDecimal r25_individuals2) {
		this.r25_individuals2 = r25_individuals2;
	}
	public BigDecimal getR25_other1() {
		return r25_other1;
	}
	public void setR25_other1(BigDecimal r25_other1) {
		this.r25_other1 = r25_other1;
	}
	public BigDecimal getR25_banks2() {
		return r25_banks2;
	}
	public void setR25_banks2(BigDecimal r25_banks2) {
		this.r25_banks2 = r25_banks2;
	}
	public BigDecimal getR25_gov3() {
		return r25_gov3;
	}
	public void setR25_gov3(BigDecimal r25_gov3) {
		this.r25_gov3 = r25_gov3;
	}
	public BigDecimal getR25_others2() {
		return r25_others2;
	}
	public void setR25_others2(BigDecimal r25_others2) {
		this.r25_others2 = r25_others2;
	}
	public BigDecimal getR25_banks3() {
		return r25_banks3;
	}
	public void setR25_banks3(BigDecimal r25_banks3) {
		this.r25_banks3 = r25_banks3;
	}
	public BigDecimal getR25_gov4() {
		return r25_gov4;
	}
	public void setR25_gov4(BigDecimal r25_gov4) {
		this.r25_gov4 = r25_gov4;
	}
	public BigDecimal getR25_others3() {
		return r25_others3;
	}
	public void setR25_others3(BigDecimal r25_others3) {
		this.r25_others3 = r25_others3;
	}
	public BigDecimal getR25_foreign1() {
		return r25_foreign1;
	}
	public void setR25_foreign1(BigDecimal r25_foreign1) {
		this.r25_foreign1 = r25_foreign1;
	}
	public BigDecimal getR25_guarantees() {
		return r25_guarantees;
	}
	public void setR25_guarantees(BigDecimal r25_guarantees) {
		this.r25_guarantees = r25_guarantees;
	}
	public BigDecimal getR25_nbfi2() {
		return r25_nbfi2;
	}
	public void setR25_nbfi2(BigDecimal r25_nbfi2) {
		this.r25_nbfi2 = r25_nbfi2;
	}
	public BigDecimal getR25_interbank2() {
		return r25_interbank2;
	}
	public void setR25_interbank2(BigDecimal r25_interbank2) {
		this.r25_interbank2 = r25_interbank2;
	}
	public BigDecimal getR25_gov5() {
		return r25_gov5;
	}
	public void setR25_gov5(BigDecimal r25_gov5) {
		this.r25_gov5 = r25_gov5;
	}
	public BigDecimal getR25_corporate2() {
		return r25_corporate2;
	}
	public void setR25_corporate2(BigDecimal r25_corporate2) {
		this.r25_corporate2 = r25_corporate2;
	}
	public BigDecimal getR25_gre2() {
		return r25_gre2;
	}
	public void setR25_gre2(BigDecimal r25_gre2) {
		this.r25_gre2 = r25_gre2;
	}
	public BigDecimal getR25_individuals3() {
		return r25_individuals3;
	}
	public void setR25_individuals3(BigDecimal r25_individuals3) {
		this.r25_individuals3 = r25_individuals3;
	}
	public BigDecimal getR25_zero1() {
		return r25_zero1;
	}
	public void setR25_zero1(BigDecimal r25_zero1) {
		this.r25_zero1 = r25_zero1;
	}
	public BigDecimal getR25_three1() {
		return r25_three1;
	}
	public void setR25_three1(BigDecimal r25_three1) {
		this.r25_three1 = r25_three1;
	}
	public BigDecimal getR25_six1() {
		return r25_six1;
	}
	public void setR25_six1(BigDecimal r25_six1) {
		this.r25_six1 = r25_six1;
	}
	public BigDecimal getR25_oneyear1() {
		return r25_oneyear1;
	}
	public void setR25_oneyear1(BigDecimal r25_oneyear1) {
		this.r25_oneyear1 = r25_oneyear1;
	}
	public String getR25_empty() {
		return r25_empty;
	}
	public void setR25_empty(String r25_empty) {
		this.r25_empty = r25_empty;
	}
	public String getR26_product() {
		return r26_product;
	}
	public void setR26_product(String r26_product) {
		this.r26_product = r26_product;
	}
	public BigDecimal getR26_nbfi() {
		return r26_nbfi;
	}
	public void setR26_nbfi(BigDecimal r26_nbfi) {
		this.r26_nbfi = r26_nbfi;
	}
	public BigDecimal getR26_interbank() {
		return r26_interbank;
	}
	public void setR26_interbank(BigDecimal r26_interbank) {
		this.r26_interbank = r26_interbank;
	}
	public BigDecimal getR26_gov() {
		return r26_gov;
	}
	public void setR26_gov(BigDecimal r26_gov) {
		this.r26_gov = r26_gov;
	}
	public BigDecimal getR26_corporate() {
		return r26_corporate;
	}
	public void setR26_corporate(BigDecimal r26_corporate) {
		this.r26_corporate = r26_corporate;
	}
	public BigDecimal getR26_gre() {
		return r26_gre;
	}
	public void setR26_gre(BigDecimal r26_gre) {
		this.r26_gre = r26_gre;
	}
	public BigDecimal getR26_trade() {
		return r26_trade;
	}
	public void setR26_trade(BigDecimal r26_trade) {
		this.r26_trade = r26_trade;
	}
	public BigDecimal getR26_individuals() {
		return r26_individuals;
	}
	public void setR26_individuals(BigDecimal r26_individuals) {
		this.r26_individuals = r26_individuals;
	}
	public BigDecimal getR26_investment() {
		return r26_investment;
	}
	public void setR26_investment(BigDecimal r26_investment) {
		this.r26_investment = r26_investment;
	}
	public BigDecimal getR26_nbfi1() {
		return r26_nbfi1;
	}
	public void setR26_nbfi1(BigDecimal r26_nbfi1) {
		this.r26_nbfi1 = r26_nbfi1;
	}
	public BigDecimal getR26_interbank1() {
		return r26_interbank1;
	}
	public void setR26_interbank1(BigDecimal r26_interbank1) {
		this.r26_interbank1 = r26_interbank1;
	}
	public BigDecimal getR26_gov1() {
		return r26_gov1;
	}
	public void setR26_gov1(BigDecimal r26_gov1) {
		this.r26_gov1 = r26_gov1;
	}
	public BigDecimal getR26_corporate1() {
		return r26_corporate1;
	}
	public void setR26_corporate1(BigDecimal r26_corporate1) {
		this.r26_corporate1 = r26_corporate1;
	}
	public BigDecimal getR26_gre1() {
		return r26_gre1;
	}
	public void setR26_gre1(BigDecimal r26_gre1) {
		this.r26_gre1 = r26_gre1;
	}
	public BigDecimal getR26_trade1() {
		return r26_trade1;
	}
	public void setR26_trade1(BigDecimal r26_trade1) {
		this.r26_trade1 = r26_trade1;
	}
	public BigDecimal getR26_individuals1() {
		return r26_individuals1;
	}
	public void setR26_individuals1(BigDecimal r26_individuals1) {
		this.r26_individuals1 = r26_individuals1;
	}
	public BigDecimal getR26_investment1() {
		return r26_investment1;
	}
	public void setR26_investment1(BigDecimal r26_investment1) {
		this.r26_investment1 = r26_investment1;
	}
	public BigDecimal getR26_zer0() {
		return r26_zer0;
	}
	public void setR26_zer0(BigDecimal r26_zer0) {
		this.r26_zer0 = r26_zer0;
	}
	public BigDecimal getR26_three() {
		return r26_three;
	}
	public void setR26_three(BigDecimal r26_three) {
		this.r26_three = r26_three;
	}
	public BigDecimal getR26_six() {
		return r26_six;
	}
	public void setR26_six(BigDecimal r26_six) {
		this.r26_six = r26_six;
	}
	public BigDecimal getR26_oneyear() {
		return r26_oneyear;
	}
	public void setR26_oneyear(BigDecimal r26_oneyear) {
		this.r26_oneyear = r26_oneyear;
	}
	public BigDecimal getR26_foreign() {
		return r26_foreign;
	}
	public void setR26_foreign(BigDecimal r26_foreign) {
		this.r26_foreign = r26_foreign;
	}
	public BigDecimal getR26_banks() {
		return r26_banks;
	}
	public void setR26_banks(BigDecimal r26_banks) {
		this.r26_banks = r26_banks;
	}
	public BigDecimal getR26_gov2() {
		return r26_gov2;
	}
	public void setR26_gov2(BigDecimal r26_gov2) {
		this.r26_gov2 = r26_gov2;
	}
	public BigDecimal getR26_other() {
		return r26_other;
	}
	public void setR26_other(BigDecimal r26_other) {
		this.r26_other = r26_other;
	}
	public BigDecimal getR26_banks1() {
		return r26_banks1;
	}
	public void setR26_banks1(BigDecimal r26_banks1) {
		this.r26_banks1 = r26_banks1;
	}
	public BigDecimal getR26_individuals2() {
		return r26_individuals2;
	}
	public void setR26_individuals2(BigDecimal r26_individuals2) {
		this.r26_individuals2 = r26_individuals2;
	}
	public BigDecimal getR26_other1() {
		return r26_other1;
	}
	public void setR26_other1(BigDecimal r26_other1) {
		this.r26_other1 = r26_other1;
	}
	public BigDecimal getR26_banks2() {
		return r26_banks2;
	}
	public void setR26_banks2(BigDecimal r26_banks2) {
		this.r26_banks2 = r26_banks2;
	}
	public BigDecimal getR26_gov3() {
		return r26_gov3;
	}
	public void setR26_gov3(BigDecimal r26_gov3) {
		this.r26_gov3 = r26_gov3;
	}
	public BigDecimal getR26_others2() {
		return r26_others2;
	}
	public void setR26_others2(BigDecimal r26_others2) {
		this.r26_others2 = r26_others2;
	}
	public BigDecimal getR26_banks3() {
		return r26_banks3;
	}
	public void setR26_banks3(BigDecimal r26_banks3) {
		this.r26_banks3 = r26_banks3;
	}
	public BigDecimal getR26_gov4() {
		return r26_gov4;
	}
	public void setR26_gov4(BigDecimal r26_gov4) {
		this.r26_gov4 = r26_gov4;
	}
	public BigDecimal getR26_others3() {
		return r26_others3;
	}
	public void setR26_others3(BigDecimal r26_others3) {
		this.r26_others3 = r26_others3;
	}
	public BigDecimal getR26_foreign1() {
		return r26_foreign1;
	}
	public void setR26_foreign1(BigDecimal r26_foreign1) {
		this.r26_foreign1 = r26_foreign1;
	}
	public BigDecimal getR26_guarantees() {
		return r26_guarantees;
	}
	public void setR26_guarantees(BigDecimal r26_guarantees) {
		this.r26_guarantees = r26_guarantees;
	}
	public BigDecimal getR26_nbfi2() {
		return r26_nbfi2;
	}
	public void setR26_nbfi2(BigDecimal r26_nbfi2) {
		this.r26_nbfi2 = r26_nbfi2;
	}
	public BigDecimal getR26_interbank2() {
		return r26_interbank2;
	}
	public void setR26_interbank2(BigDecimal r26_interbank2) {
		this.r26_interbank2 = r26_interbank2;
	}
	public BigDecimal getR26_gov5() {
		return r26_gov5;
	}
	public void setR26_gov5(BigDecimal r26_gov5) {
		this.r26_gov5 = r26_gov5;
	}
	public BigDecimal getR26_corporate2() {
		return r26_corporate2;
	}
	public void setR26_corporate2(BigDecimal r26_corporate2) {
		this.r26_corporate2 = r26_corporate2;
	}
	public BigDecimal getR26_gre2() {
		return r26_gre2;
	}
	public void setR26_gre2(BigDecimal r26_gre2) {
		this.r26_gre2 = r26_gre2;
	}
	public BigDecimal getR26_individuals3() {
		return r26_individuals3;
	}
	public void setR26_individuals3(BigDecimal r26_individuals3) {
		this.r26_individuals3 = r26_individuals3;
	}
	public BigDecimal getR26_zero1() {
		return r26_zero1;
	}
	public void setR26_zero1(BigDecimal r26_zero1) {
		this.r26_zero1 = r26_zero1;
	}
	public BigDecimal getR26_three1() {
		return r26_three1;
	}
	public void setR26_three1(BigDecimal r26_three1) {
		this.r26_three1 = r26_three1;
	}
	public BigDecimal getR26_six1() {
		return r26_six1;
	}
	public void setR26_six1(BigDecimal r26_six1) {
		this.r26_six1 = r26_six1;
	}
	public BigDecimal getR26_oneyear1() {
		return r26_oneyear1;
	}
	public void setR26_oneyear1(BigDecimal r26_oneyear1) {
		this.r26_oneyear1 = r26_oneyear1;
	}
	public String getR26_empty() {
		return r26_empty;
	}
	public void setR26_empty(String r26_empty) {
		this.r26_empty = r26_empty;
	}
	public String getR27_product() {
		return r27_product;
	}
	public void setR27_product(String r27_product) {
		this.r27_product = r27_product;
	}
	public BigDecimal getR27_nbfi() {
		return r27_nbfi;
	}
	public void setR27_nbfi(BigDecimal r27_nbfi) {
		this.r27_nbfi = r27_nbfi;
	}
	public BigDecimal getR27_interbank() {
		return r27_interbank;
	}
	public void setR27_interbank(BigDecimal r27_interbank) {
		this.r27_interbank = r27_interbank;
	}
	public BigDecimal getR27_gov() {
		return r27_gov;
	}
	public void setR27_gov(BigDecimal r27_gov) {
		this.r27_gov = r27_gov;
	}
	public BigDecimal getR27_corporate() {
		return r27_corporate;
	}
	public void setR27_corporate(BigDecimal r27_corporate) {
		this.r27_corporate = r27_corporate;
	}
	public BigDecimal getR27_gre() {
		return r27_gre;
	}
	public void setR27_gre(BigDecimal r27_gre) {
		this.r27_gre = r27_gre;
	}
	public BigDecimal getR27_trade() {
		return r27_trade;
	}
	public void setR27_trade(BigDecimal r27_trade) {
		this.r27_trade = r27_trade;
	}
	public BigDecimal getR27_individuals() {
		return r27_individuals;
	}
	public void setR27_individuals(BigDecimal r27_individuals) {
		this.r27_individuals = r27_individuals;
	}
	public BigDecimal getR27_investment() {
		return r27_investment;
	}
	public void setR27_investment(BigDecimal r27_investment) {
		this.r27_investment = r27_investment;
	}
	public BigDecimal getR27_nbfi1() {
		return r27_nbfi1;
	}
	public void setR27_nbfi1(BigDecimal r27_nbfi1) {
		this.r27_nbfi1 = r27_nbfi1;
	}
	public BigDecimal getR27_interbank1() {
		return r27_interbank1;
	}
	public void setR27_interbank1(BigDecimal r27_interbank1) {
		this.r27_interbank1 = r27_interbank1;
	}
	public BigDecimal getR27_gov1() {
		return r27_gov1;
	}
	public void setR27_gov1(BigDecimal r27_gov1) {
		this.r27_gov1 = r27_gov1;
	}
	public BigDecimal getR27_corporate1() {
		return r27_corporate1;
	}
	public void setR27_corporate1(BigDecimal r27_corporate1) {
		this.r27_corporate1 = r27_corporate1;
	}
	public BigDecimal getR27_gre1() {
		return r27_gre1;
	}
	public void setR27_gre1(BigDecimal r27_gre1) {
		this.r27_gre1 = r27_gre1;
	}
	public BigDecimal getR27_trade1() {
		return r27_trade1;
	}
	public void setR27_trade1(BigDecimal r27_trade1) {
		this.r27_trade1 = r27_trade1;
	}
	public BigDecimal getR27_individuals1() {
		return r27_individuals1;
	}
	public void setR27_individuals1(BigDecimal r27_individuals1) {
		this.r27_individuals1 = r27_individuals1;
	}
	public BigDecimal getR27_investment1() {
		return r27_investment1;
	}
	public void setR27_investment1(BigDecimal r27_investment1) {
		this.r27_investment1 = r27_investment1;
	}
	public BigDecimal getR27_zer0() {
		return r27_zer0;
	}
	public void setR27_zer0(BigDecimal r27_zer0) {
		this.r27_zer0 = r27_zer0;
	}
	public BigDecimal getR27_three() {
		return r27_three;
	}
	public void setR27_three(BigDecimal r27_three) {
		this.r27_three = r27_three;
	}
	public BigDecimal getR27_six() {
		return r27_six;
	}
	public void setR27_six(BigDecimal r27_six) {
		this.r27_six = r27_six;
	}
	public BigDecimal getR27_oneyear() {
		return r27_oneyear;
	}
	public void setR27_oneyear(BigDecimal r27_oneyear) {
		this.r27_oneyear = r27_oneyear;
	}
	public BigDecimal getR27_foreign() {
		return r27_foreign;
	}
	public void setR27_foreign(BigDecimal r27_foreign) {
		this.r27_foreign = r27_foreign;
	}
	public BigDecimal getR27_banks() {
		return r27_banks;
	}
	public void setR27_banks(BigDecimal r27_banks) {
		this.r27_banks = r27_banks;
	}
	public BigDecimal getR27_gov2() {
		return r27_gov2;
	}
	public void setR27_gov2(BigDecimal r27_gov2) {
		this.r27_gov2 = r27_gov2;
	}
	public BigDecimal getR27_other() {
		return r27_other;
	}
	public void setR27_other(BigDecimal r27_other) {
		this.r27_other = r27_other;
	}
	public BigDecimal getR27_banks1() {
		return r27_banks1;
	}
	public void setR27_banks1(BigDecimal r27_banks1) {
		this.r27_banks1 = r27_banks1;
	}
	public BigDecimal getR27_individuals2() {
		return r27_individuals2;
	}
	public void setR27_individuals2(BigDecimal r27_individuals2) {
		this.r27_individuals2 = r27_individuals2;
	}
	public BigDecimal getR27_other1() {
		return r27_other1;
	}
	public void setR27_other1(BigDecimal r27_other1) {
		this.r27_other1 = r27_other1;
	}
	public BigDecimal getR27_banks2() {
		return r27_banks2;
	}
	public void setR27_banks2(BigDecimal r27_banks2) {
		this.r27_banks2 = r27_banks2;
	}
	public BigDecimal getR27_gov3() {
		return r27_gov3;
	}
	public void setR27_gov3(BigDecimal r27_gov3) {
		this.r27_gov3 = r27_gov3;
	}
	public BigDecimal getR27_others2() {
		return r27_others2;
	}
	public void setR27_others2(BigDecimal r27_others2) {
		this.r27_others2 = r27_others2;
	}
	public BigDecimal getR27_banks3() {
		return r27_banks3;
	}
	public void setR27_banks3(BigDecimal r27_banks3) {
		this.r27_banks3 = r27_banks3;
	}
	public BigDecimal getR27_gov4() {
		return r27_gov4;
	}
	public void setR27_gov4(BigDecimal r27_gov4) {
		this.r27_gov4 = r27_gov4;
	}
	public BigDecimal getR27_others3() {
		return r27_others3;
	}
	public void setR27_others3(BigDecimal r27_others3) {
		this.r27_others3 = r27_others3;
	}
	public BigDecimal getR27_foreign1() {
		return r27_foreign1;
	}
	public void setR27_foreign1(BigDecimal r27_foreign1) {
		this.r27_foreign1 = r27_foreign1;
	}
	public BigDecimal getR27_guarantees() {
		return r27_guarantees;
	}
	public void setR27_guarantees(BigDecimal r27_guarantees) {
		this.r27_guarantees = r27_guarantees;
	}
	public BigDecimal getR27_nbfi2() {
		return r27_nbfi2;
	}
	public void setR27_nbfi2(BigDecimal r27_nbfi2) {
		this.r27_nbfi2 = r27_nbfi2;
	}
	public BigDecimal getR27_interbank2() {
		return r27_interbank2;
	}
	public void setR27_interbank2(BigDecimal r27_interbank2) {
		this.r27_interbank2 = r27_interbank2;
	}
	public BigDecimal getR27_gov5() {
		return r27_gov5;
	}
	public void setR27_gov5(BigDecimal r27_gov5) {
		this.r27_gov5 = r27_gov5;
	}
	public BigDecimal getR27_corporate2() {
		return r27_corporate2;
	}
	public void setR27_corporate2(BigDecimal r27_corporate2) {
		this.r27_corporate2 = r27_corporate2;
	}
	public BigDecimal getR27_gre2() {
		return r27_gre2;
	}
	public void setR27_gre2(BigDecimal r27_gre2) {
		this.r27_gre2 = r27_gre2;
	}
	public BigDecimal getR27_individuals3() {
		return r27_individuals3;
	}
	public void setR27_individuals3(BigDecimal r27_individuals3) {
		this.r27_individuals3 = r27_individuals3;
	}
	public BigDecimal getR27_zero1() {
		return r27_zero1;
	}
	public void setR27_zero1(BigDecimal r27_zero1) {
		this.r27_zero1 = r27_zero1;
	}
	public BigDecimal getR27_three1() {
		return r27_three1;
	}
	public void setR27_three1(BigDecimal r27_three1) {
		this.r27_three1 = r27_three1;
	}
	public BigDecimal getR27_six1() {
		return r27_six1;
	}
	public void setR27_six1(BigDecimal r27_six1) {
		this.r27_six1 = r27_six1;
	}
	public BigDecimal getR27_oneyear1() {
		return r27_oneyear1;
	}
	public void setR27_oneyear1(BigDecimal r27_oneyear1) {
		this.r27_oneyear1 = r27_oneyear1;
	}
	public String getR27_empty() {
		return r27_empty;
	}
	public void setR27_empty(String r27_empty) {
		this.r27_empty = r27_empty;
	}
	public String getR28_product() {
		return r28_product;
	}
	public void setR28_product(String r28_product) {
		this.r28_product = r28_product;
	}
	public BigDecimal getR28_nbfi() {
		return r28_nbfi;
	}
	public void setR28_nbfi(BigDecimal r28_nbfi) {
		this.r28_nbfi = r28_nbfi;
	}
	public BigDecimal getR28_interbank() {
		return r28_interbank;
	}
	public void setR28_interbank(BigDecimal r28_interbank) {
		this.r28_interbank = r28_interbank;
	}
	public BigDecimal getR28_gov() {
		return r28_gov;
	}
	public void setR28_gov(BigDecimal r28_gov) {
		this.r28_gov = r28_gov;
	}
	public BigDecimal getR28_corporate() {
		return r28_corporate;
	}
	public void setR28_corporate(BigDecimal r28_corporate) {
		this.r28_corporate = r28_corporate;
	}
	public BigDecimal getR28_gre() {
		return r28_gre;
	}
	public void setR28_gre(BigDecimal r28_gre) {
		this.r28_gre = r28_gre;
	}
	public BigDecimal getR28_trade() {
		return r28_trade;
	}
	public void setR28_trade(BigDecimal r28_trade) {
		this.r28_trade = r28_trade;
	}
	public BigDecimal getR28_individuals() {
		return r28_individuals;
	}
	public void setR28_individuals(BigDecimal r28_individuals) {
		this.r28_individuals = r28_individuals;
	}
	public BigDecimal getR28_investment() {
		return r28_investment;
	}
	public void setR28_investment(BigDecimal r28_investment) {
		this.r28_investment = r28_investment;
	}
	public BigDecimal getR28_nbfi1() {
		return r28_nbfi1;
	}
	public void setR28_nbfi1(BigDecimal r28_nbfi1) {
		this.r28_nbfi1 = r28_nbfi1;
	}
	public BigDecimal getR28_interbank1() {
		return r28_interbank1;
	}
	public void setR28_interbank1(BigDecimal r28_interbank1) {
		this.r28_interbank1 = r28_interbank1;
	}
	public BigDecimal getR28_gov1() {
		return r28_gov1;
	}
	public void setR28_gov1(BigDecimal r28_gov1) {
		this.r28_gov1 = r28_gov1;
	}
	public BigDecimal getR28_corporate1() {
		return r28_corporate1;
	}
	public void setR28_corporate1(BigDecimal r28_corporate1) {
		this.r28_corporate1 = r28_corporate1;
	}
	public BigDecimal getR28_gre1() {
		return r28_gre1;
	}
	public void setR28_gre1(BigDecimal r28_gre1) {
		this.r28_gre1 = r28_gre1;
	}
	public BigDecimal getR28_trade1() {
		return r28_trade1;
	}
	public void setR28_trade1(BigDecimal r28_trade1) {
		this.r28_trade1 = r28_trade1;
	}
	public BigDecimal getR28_individuals1() {
		return r28_individuals1;
	}
	public void setR28_individuals1(BigDecimal r28_individuals1) {
		this.r28_individuals1 = r28_individuals1;
	}
	public BigDecimal getR28_investment1() {
		return r28_investment1;
	}
	public void setR28_investment1(BigDecimal r28_investment1) {
		this.r28_investment1 = r28_investment1;
	}
	public BigDecimal getR28_zer0() {
		return r28_zer0;
	}
	public void setR28_zer0(BigDecimal r28_zer0) {
		this.r28_zer0 = r28_zer0;
	}
	public BigDecimal getR28_three() {
		return r28_three;
	}
	public void setR28_three(BigDecimal r28_three) {
		this.r28_three = r28_three;
	}
	public BigDecimal getR28_six() {
		return r28_six;
	}
	public void setR28_six(BigDecimal r28_six) {
		this.r28_six = r28_six;
	}
	public BigDecimal getR28_oneyear() {
		return r28_oneyear;
	}
	public void setR28_oneyear(BigDecimal r28_oneyear) {
		this.r28_oneyear = r28_oneyear;
	}
	public BigDecimal getR28_foreign() {
		return r28_foreign;
	}
	public void setR28_foreign(BigDecimal r28_foreign) {
		this.r28_foreign = r28_foreign;
	}
	public BigDecimal getR28_banks() {
		return r28_banks;
	}
	public void setR28_banks(BigDecimal r28_banks) {
		this.r28_banks = r28_banks;
	}
	public BigDecimal getR28_gov2() {
		return r28_gov2;
	}
	public void setR28_gov2(BigDecimal r28_gov2) {
		this.r28_gov2 = r28_gov2;
	}
	public BigDecimal getR28_other() {
		return r28_other;
	}
	public void setR28_other(BigDecimal r28_other) {
		this.r28_other = r28_other;
	}
	public BigDecimal getR28_banks1() {
		return r28_banks1;
	}
	public void setR28_banks1(BigDecimal r28_banks1) {
		this.r28_banks1 = r28_banks1;
	}
	public BigDecimal getR28_individuals2() {
		return r28_individuals2;
	}
	public void setR28_individuals2(BigDecimal r28_individuals2) {
		this.r28_individuals2 = r28_individuals2;
	}
	public BigDecimal getR28_other1() {
		return r28_other1;
	}
	public void setR28_other1(BigDecimal r28_other1) {
		this.r28_other1 = r28_other1;
	}
	public BigDecimal getR28_banks2() {
		return r28_banks2;
	}
	public void setR28_banks2(BigDecimal r28_banks2) {
		this.r28_banks2 = r28_banks2;
	}
	public BigDecimal getR28_gov3() {
		return r28_gov3;
	}
	public void setR28_gov3(BigDecimal r28_gov3) {
		this.r28_gov3 = r28_gov3;
	}
	public BigDecimal getR28_others2() {
		return r28_others2;
	}
	public void setR28_others2(BigDecimal r28_others2) {
		this.r28_others2 = r28_others2;
	}
	public BigDecimal getR28_banks3() {
		return r28_banks3;
	}
	public void setR28_banks3(BigDecimal r28_banks3) {
		this.r28_banks3 = r28_banks3;
	}
	public BigDecimal getR28_gov4() {
		return r28_gov4;
	}
	public void setR28_gov4(BigDecimal r28_gov4) {
		this.r28_gov4 = r28_gov4;
	}
	public BigDecimal getR28_others3() {
		return r28_others3;
	}
	public void setR28_others3(BigDecimal r28_others3) {
		this.r28_others3 = r28_others3;
	}
	public BigDecimal getR28_foreign1() {
		return r28_foreign1;
	}
	public void setR28_foreign1(BigDecimal r28_foreign1) {
		this.r28_foreign1 = r28_foreign1;
	}
	public BigDecimal getR28_guarantees() {
		return r28_guarantees;
	}
	public void setR28_guarantees(BigDecimal r28_guarantees) {
		this.r28_guarantees = r28_guarantees;
	}
	public BigDecimal getR28_nbfi2() {
		return r28_nbfi2;
	}
	public void setR28_nbfi2(BigDecimal r28_nbfi2) {
		this.r28_nbfi2 = r28_nbfi2;
	}
	public BigDecimal getR28_interbank2() {
		return r28_interbank2;
	}
	public void setR28_interbank2(BigDecimal r28_interbank2) {
		this.r28_interbank2 = r28_interbank2;
	}
	public BigDecimal getR28_gov5() {
		return r28_gov5;
	}
	public void setR28_gov5(BigDecimal r28_gov5) {
		this.r28_gov5 = r28_gov5;
	}
	public BigDecimal getR28_corporate2() {
		return r28_corporate2;
	}
	public void setR28_corporate2(BigDecimal r28_corporate2) {
		this.r28_corporate2 = r28_corporate2;
	}
	public BigDecimal getR28_gre2() {
		return r28_gre2;
	}
	public void setR28_gre2(BigDecimal r28_gre2) {
		this.r28_gre2 = r28_gre2;
	}
	public BigDecimal getR28_individuals3() {
		return r28_individuals3;
	}
	public void setR28_individuals3(BigDecimal r28_individuals3) {
		this.r28_individuals3 = r28_individuals3;
	}
	public BigDecimal getR28_zero1() {
		return r28_zero1;
	}
	public void setR28_zero1(BigDecimal r28_zero1) {
		this.r28_zero1 = r28_zero1;
	}
	public BigDecimal getR28_three1() {
		return r28_three1;
	}
	public void setR28_three1(BigDecimal r28_three1) {
		this.r28_three1 = r28_three1;
	}
	public BigDecimal getR28_six1() {
		return r28_six1;
	}
	public void setR28_six1(BigDecimal r28_six1) {
		this.r28_six1 = r28_six1;
	}
	public BigDecimal getR28_oneyear1() {
		return r28_oneyear1;
	}
	public void setR28_oneyear1(BigDecimal r28_oneyear1) {
		this.r28_oneyear1 = r28_oneyear1;
	}
	public String getR28_empty() {
		return r28_empty;
	}
	public void setR28_empty(String r28_empty) {
		this.r28_empty = r28_empty;
	}
	public String getR29_product() {
		return r29_product;
	}
	public void setR29_product(String r29_product) {
		this.r29_product = r29_product;
	}
	public BigDecimal getR29_nbfi() {
		return r29_nbfi;
	}
	public void setR29_nbfi(BigDecimal r29_nbfi) {
		this.r29_nbfi = r29_nbfi;
	}
	public BigDecimal getR29_interbank() {
		return r29_interbank;
	}
	public void setR29_interbank(BigDecimal r29_interbank) {
		this.r29_interbank = r29_interbank;
	}
	public BigDecimal getR29_gov() {
		return r29_gov;
	}
	public void setR29_gov(BigDecimal r29_gov) {
		this.r29_gov = r29_gov;
	}
	public BigDecimal getR29_corporate() {
		return r29_corporate;
	}
	public void setR29_corporate(BigDecimal r29_corporate) {
		this.r29_corporate = r29_corporate;
	}
	public BigDecimal getR29_gre() {
		return r29_gre;
	}
	public void setR29_gre(BigDecimal r29_gre) {
		this.r29_gre = r29_gre;
	}
	public BigDecimal getR29_trade() {
		return r29_trade;
	}
	public void setR29_trade(BigDecimal r29_trade) {
		this.r29_trade = r29_trade;
	}
	public BigDecimal getR29_individuals() {
		return r29_individuals;
	}
	public void setR29_individuals(BigDecimal r29_individuals) {
		this.r29_individuals = r29_individuals;
	}
	public BigDecimal getR29_investment() {
		return r29_investment;
	}
	public void setR29_investment(BigDecimal r29_investment) {
		this.r29_investment = r29_investment;
	}
	public BigDecimal getR29_nbfi1() {
		return r29_nbfi1;
	}
	public void setR29_nbfi1(BigDecimal r29_nbfi1) {
		this.r29_nbfi1 = r29_nbfi1;
	}
	public BigDecimal getR29_interbank1() {
		return r29_interbank1;
	}
	public void setR29_interbank1(BigDecimal r29_interbank1) {
		this.r29_interbank1 = r29_interbank1;
	}
	public BigDecimal getR29_gov1() {
		return r29_gov1;
	}
	public void setR29_gov1(BigDecimal r29_gov1) {
		this.r29_gov1 = r29_gov1;
	}
	public BigDecimal getR29_corporate1() {
		return r29_corporate1;
	}
	public void setR29_corporate1(BigDecimal r29_corporate1) {
		this.r29_corporate1 = r29_corporate1;
	}
	public BigDecimal getR29_gre1() {
		return r29_gre1;
	}
	public void setR29_gre1(BigDecimal r29_gre1) {
		this.r29_gre1 = r29_gre1;
	}
	public BigDecimal getR29_trade1() {
		return r29_trade1;
	}
	public void setR29_trade1(BigDecimal r29_trade1) {
		this.r29_trade1 = r29_trade1;
	}
	public BigDecimal getR29_individuals1() {
		return r29_individuals1;
	}
	public void setR29_individuals1(BigDecimal r29_individuals1) {
		this.r29_individuals1 = r29_individuals1;
	}
	public BigDecimal getR29_investment1() {
		return r29_investment1;
	}
	public void setR29_investment1(BigDecimal r29_investment1) {
		this.r29_investment1 = r29_investment1;
	}
	public BigDecimal getR29_zer0() {
		return r29_zer0;
	}
	public void setR29_zer0(BigDecimal r29_zer0) {
		this.r29_zer0 = r29_zer0;
	}
	public BigDecimal getR29_three() {
		return r29_three;
	}
	public void setR29_three(BigDecimal r29_three) {
		this.r29_three = r29_three;
	}
	public BigDecimal getR29_six() {
		return r29_six;
	}
	public void setR29_six(BigDecimal r29_six) {
		this.r29_six = r29_six;
	}
	public BigDecimal getR29_oneyear() {
		return r29_oneyear;
	}
	public void setR29_oneyear(BigDecimal r29_oneyear) {
		this.r29_oneyear = r29_oneyear;
	}
	public BigDecimal getR29_foreign() {
		return r29_foreign;
	}
	public void setR29_foreign(BigDecimal r29_foreign) {
		this.r29_foreign = r29_foreign;
	}
	public BigDecimal getR29_banks() {
		return r29_banks;
	}
	public void setR29_banks(BigDecimal r29_banks) {
		this.r29_banks = r29_banks;
	}
	public BigDecimal getR29_gov2() {
		return r29_gov2;
	}
	public void setR29_gov2(BigDecimal r29_gov2) {
		this.r29_gov2 = r29_gov2;
	}
	public BigDecimal getR29_other() {
		return r29_other;
	}
	public void setR29_other(BigDecimal r29_other) {
		this.r29_other = r29_other;
	}
	public BigDecimal getR29_banks1() {
		return r29_banks1;
	}
	public void setR29_banks1(BigDecimal r29_banks1) {
		this.r29_banks1 = r29_banks1;
	}
	public BigDecimal getR29_individuals2() {
		return r29_individuals2;
	}
	public void setR29_individuals2(BigDecimal r29_individuals2) {
		this.r29_individuals2 = r29_individuals2;
	}
	public BigDecimal getR29_other1() {
		return r29_other1;
	}
	public void setR29_other1(BigDecimal r29_other1) {
		this.r29_other1 = r29_other1;
	}
	public BigDecimal getR29_banks2() {
		return r29_banks2;
	}
	public void setR29_banks2(BigDecimal r29_banks2) {
		this.r29_banks2 = r29_banks2;
	}
	public BigDecimal getR29_gov3() {
		return r29_gov3;
	}
	public void setR29_gov3(BigDecimal r29_gov3) {
		this.r29_gov3 = r29_gov3;
	}
	public BigDecimal getR29_others2() {
		return r29_others2;
	}
	public void setR29_others2(BigDecimal r29_others2) {
		this.r29_others2 = r29_others2;
	}
	public BigDecimal getR29_banks3() {
		return r29_banks3;
	}
	public void setR29_banks3(BigDecimal r29_banks3) {
		this.r29_banks3 = r29_banks3;
	}
	public BigDecimal getR29_gov4() {
		return r29_gov4;
	}
	public void setR29_gov4(BigDecimal r29_gov4) {
		this.r29_gov4 = r29_gov4;
	}
	public BigDecimal getR29_others3() {
		return r29_others3;
	}
	public void setR29_others3(BigDecimal r29_others3) {
		this.r29_others3 = r29_others3;
	}
	public BigDecimal getR29_foreign1() {
		return r29_foreign1;
	}
	public void setR29_foreign1(BigDecimal r29_foreign1) {
		this.r29_foreign1 = r29_foreign1;
	}
	public BigDecimal getR29_guarantees() {
		return r29_guarantees;
	}
	public void setR29_guarantees(BigDecimal r29_guarantees) {
		this.r29_guarantees = r29_guarantees;
	}
	public BigDecimal getR29_nbfi2() {
		return r29_nbfi2;
	}
	public void setR29_nbfi2(BigDecimal r29_nbfi2) {
		this.r29_nbfi2 = r29_nbfi2;
	}
	public BigDecimal getR29_interbank2() {
		return r29_interbank2;
	}
	public void setR29_interbank2(BigDecimal r29_interbank2) {
		this.r29_interbank2 = r29_interbank2;
	}
	public BigDecimal getR29_gov5() {
		return r29_gov5;
	}
	public void setR29_gov5(BigDecimal r29_gov5) {
		this.r29_gov5 = r29_gov5;
	}
	public BigDecimal getR29_corporate2() {
		return r29_corporate2;
	}
	public void setR29_corporate2(BigDecimal r29_corporate2) {
		this.r29_corporate2 = r29_corporate2;
	}
	public BigDecimal getR29_gre2() {
		return r29_gre2;
	}
	public void setR29_gre2(BigDecimal r29_gre2) {
		this.r29_gre2 = r29_gre2;
	}
	public BigDecimal getR29_individuals3() {
		return r29_individuals3;
	}
	public void setR29_individuals3(BigDecimal r29_individuals3) {
		this.r29_individuals3 = r29_individuals3;
	}
	public BigDecimal getR29_zero1() {
		return r29_zero1;
	}
	public void setR29_zero1(BigDecimal r29_zero1) {
		this.r29_zero1 = r29_zero1;
	}
	public BigDecimal getR29_three1() {
		return r29_three1;
	}
	public void setR29_three1(BigDecimal r29_three1) {
		this.r29_three1 = r29_three1;
	}
	public BigDecimal getR29_six1() {
		return r29_six1;
	}
	public void setR29_six1(BigDecimal r29_six1) {
		this.r29_six1 = r29_six1;
	}
	public BigDecimal getR29_oneyear1() {
		return r29_oneyear1;
	}
	public void setR29_oneyear1(BigDecimal r29_oneyear1) {
		this.r29_oneyear1 = r29_oneyear1;
	}
	public String getR29_empty() {
		return r29_empty;
	}
	public void setR29_empty(String r29_empty) {
		this.r29_empty = r29_empty;
	}
	public String getR30_product() {
		return r30_product;
	}
	public void setR30_product(String r30_product) {
		this.r30_product = r30_product;
	}
	public BigDecimal getR30_nbfi() {
		return r30_nbfi;
	}
	public void setR30_nbfi(BigDecimal r30_nbfi) {
		this.r30_nbfi = r30_nbfi;
	}
	public BigDecimal getR30_interbank() {
		return r30_interbank;
	}
	public void setR30_interbank(BigDecimal r30_interbank) {
		this.r30_interbank = r30_interbank;
	}
	public BigDecimal getR30_gov() {
		return r30_gov;
	}
	public void setR30_gov(BigDecimal r30_gov) {
		this.r30_gov = r30_gov;
	}
	public BigDecimal getR30_corporate() {
		return r30_corporate;
	}
	public void setR30_corporate(BigDecimal r30_corporate) {
		this.r30_corporate = r30_corporate;
	}
	public BigDecimal getR30_gre() {
		return r30_gre;
	}
	public void setR30_gre(BigDecimal r30_gre) {
		this.r30_gre = r30_gre;
	}
	public BigDecimal getR30_trade() {
		return r30_trade;
	}
	public void setR30_trade(BigDecimal r30_trade) {
		this.r30_trade = r30_trade;
	}
	public BigDecimal getR30_individuals() {
		return r30_individuals;
	}
	public void setR30_individuals(BigDecimal r30_individuals) {
		this.r30_individuals = r30_individuals;
	}
	public BigDecimal getR30_investment() {
		return r30_investment;
	}
	public void setR30_investment(BigDecimal r30_investment) {
		this.r30_investment = r30_investment;
	}
	public BigDecimal getR30_nbfi1() {
		return r30_nbfi1;
	}
	public void setR30_nbfi1(BigDecimal r30_nbfi1) {
		this.r30_nbfi1 = r30_nbfi1;
	}
	public BigDecimal getR30_interbank1() {
		return r30_interbank1;
	}
	public void setR30_interbank1(BigDecimal r30_interbank1) {
		this.r30_interbank1 = r30_interbank1;
	}
	public BigDecimal getR30_gov1() {
		return r30_gov1;
	}
	public void setR30_gov1(BigDecimal r30_gov1) {
		this.r30_gov1 = r30_gov1;
	}
	public BigDecimal getR30_corporate1() {
		return r30_corporate1;
	}
	public void setR30_corporate1(BigDecimal r30_corporate1) {
		this.r30_corporate1 = r30_corporate1;
	}
	public BigDecimal getR30_gre1() {
		return r30_gre1;
	}
	public void setR30_gre1(BigDecimal r30_gre1) {
		this.r30_gre1 = r30_gre1;
	}
	public BigDecimal getR30_trade1() {
		return r30_trade1;
	}
	public void setR30_trade1(BigDecimal r30_trade1) {
		this.r30_trade1 = r30_trade1;
	}
	public BigDecimal getR30_individuals1() {
		return r30_individuals1;
	}
	public void setR30_individuals1(BigDecimal r30_individuals1) {
		this.r30_individuals1 = r30_individuals1;
	}
	public BigDecimal getR30_investment1() {
		return r30_investment1;
	}
	public void setR30_investment1(BigDecimal r30_investment1) {
		this.r30_investment1 = r30_investment1;
	}
	public BigDecimal getR30_zer0() {
		return r30_zer0;
	}
	public void setR30_zer0(BigDecimal r30_zer0) {
		this.r30_zer0 = r30_zer0;
	}
	public BigDecimal getR30_three() {
		return r30_three;
	}
	public void setR30_three(BigDecimal r30_three) {
		this.r30_three = r30_three;
	}
	public BigDecimal getR30_six() {
		return r30_six;
	}
	public void setR30_six(BigDecimal r30_six) {
		this.r30_six = r30_six;
	}
	public BigDecimal getR30_oneyear() {
		return r30_oneyear;
	}
	public void setR30_oneyear(BigDecimal r30_oneyear) {
		this.r30_oneyear = r30_oneyear;
	}
	public BigDecimal getR30_foreign() {
		return r30_foreign;
	}
	public void setR30_foreign(BigDecimal r30_foreign) {
		this.r30_foreign = r30_foreign;
	}
	public BigDecimal getR30_banks() {
		return r30_banks;
	}
	public void setR30_banks(BigDecimal r30_banks) {
		this.r30_banks = r30_banks;
	}
	public BigDecimal getR30_gov2() {
		return r30_gov2;
	}
	public void setR30_gov2(BigDecimal r30_gov2) {
		this.r30_gov2 = r30_gov2;
	}
	public BigDecimal getR30_other() {
		return r30_other;
	}
	public void setR30_other(BigDecimal r30_other) {
		this.r30_other = r30_other;
	}
	public BigDecimal getR30_banks1() {
		return r30_banks1;
	}
	public void setR30_banks1(BigDecimal r30_banks1) {
		this.r30_banks1 = r30_banks1;
	}
	public BigDecimal getR30_individuals2() {
		return r30_individuals2;
	}
	public void setR30_individuals2(BigDecimal r30_individuals2) {
		this.r30_individuals2 = r30_individuals2;
	}
	public BigDecimal getR30_other1() {
		return r30_other1;
	}
	public void setR30_other1(BigDecimal r30_other1) {
		this.r30_other1 = r30_other1;
	}
	public BigDecimal getR30_banks2() {
		return r30_banks2;
	}
	public void setR30_banks2(BigDecimal r30_banks2) {
		this.r30_banks2 = r30_banks2;
	}
	public BigDecimal getR30_gov3() {
		return r30_gov3;
	}
	public void setR30_gov3(BigDecimal r30_gov3) {
		this.r30_gov3 = r30_gov3;
	}
	public BigDecimal getR30_others2() {
		return r30_others2;
	}
	public void setR30_others2(BigDecimal r30_others2) {
		this.r30_others2 = r30_others2;
	}
	public BigDecimal getR30_banks3() {
		return r30_banks3;
	}
	public void setR30_banks3(BigDecimal r30_banks3) {
		this.r30_banks3 = r30_banks3;
	}
	public BigDecimal getR30_gov4() {
		return r30_gov4;
	}
	public void setR30_gov4(BigDecimal r30_gov4) {
		this.r30_gov4 = r30_gov4;
	}
	public BigDecimal getR30_others3() {
		return r30_others3;
	}
	public void setR30_others3(BigDecimal r30_others3) {
		this.r30_others3 = r30_others3;
	}
	public BigDecimal getR30_foreign1() {
		return r30_foreign1;
	}
	public void setR30_foreign1(BigDecimal r30_foreign1) {
		this.r30_foreign1 = r30_foreign1;
	}
	public BigDecimal getR30_guarantees() {
		return r30_guarantees;
	}
	public void setR30_guarantees(BigDecimal r30_guarantees) {
		this.r30_guarantees = r30_guarantees;
	}
	public BigDecimal getR30_nbfi2() {
		return r30_nbfi2;
	}
	public void setR30_nbfi2(BigDecimal r30_nbfi2) {
		this.r30_nbfi2 = r30_nbfi2;
	}
	public BigDecimal getR30_interbank2() {
		return r30_interbank2;
	}
	public void setR30_interbank2(BigDecimal r30_interbank2) {
		this.r30_interbank2 = r30_interbank2;
	}
	public BigDecimal getR30_gov5() {
		return r30_gov5;
	}
	public void setR30_gov5(BigDecimal r30_gov5) {
		this.r30_gov5 = r30_gov5;
	}
	public BigDecimal getR30_corporate2() {
		return r30_corporate2;
	}
	public void setR30_corporate2(BigDecimal r30_corporate2) {
		this.r30_corporate2 = r30_corporate2;
	}
	public BigDecimal getR30_gre2() {
		return r30_gre2;
	}
	public void setR30_gre2(BigDecimal r30_gre2) {
		this.r30_gre2 = r30_gre2;
	}
	public BigDecimal getR30_individuals3() {
		return r30_individuals3;
	}
	public void setR30_individuals3(BigDecimal r30_individuals3) {
		this.r30_individuals3 = r30_individuals3;
	}
	public BigDecimal getR30_zero1() {
		return r30_zero1;
	}
	public void setR30_zero1(BigDecimal r30_zero1) {
		this.r30_zero1 = r30_zero1;
	}
	public BigDecimal getR30_three1() {
		return r30_three1;
	}
	public void setR30_three1(BigDecimal r30_three1) {
		this.r30_three1 = r30_three1;
	}
	public BigDecimal getR30_six1() {
		return r30_six1;
	}
	public void setR30_six1(BigDecimal r30_six1) {
		this.r30_six1 = r30_six1;
	}
	public BigDecimal getR30_oneyear1() {
		return r30_oneyear1;
	}
	public void setR30_oneyear1(BigDecimal r30_oneyear1) {
		this.r30_oneyear1 = r30_oneyear1;
	}
	public String getR30_empty() {
		return r30_empty;
	}
	public void setR30_empty(String r30_empty) {
		this.r30_empty = r30_empty;
	}
	public String getR31_product() {
		return r31_product;
	}
	public void setR31_product(String r31_product) {
		this.r31_product = r31_product;
	}
	public BigDecimal getR31_nbfi() {
		return r31_nbfi;
	}
	public void setR31_nbfi(BigDecimal r31_nbfi) {
		this.r31_nbfi = r31_nbfi;
	}
	public BigDecimal getR31_interbank() {
		return r31_interbank;
	}
	public void setR31_interbank(BigDecimal r31_interbank) {
		this.r31_interbank = r31_interbank;
	}
	public BigDecimal getR31_gov() {
		return r31_gov;
	}
	public void setR31_gov(BigDecimal r31_gov) {
		this.r31_gov = r31_gov;
	}
	public BigDecimal getR31_corporate() {
		return r31_corporate;
	}
	public void setR31_corporate(BigDecimal r31_corporate) {
		this.r31_corporate = r31_corporate;
	}
	public BigDecimal getR31_gre() {
		return r31_gre;
	}
	public void setR31_gre(BigDecimal r31_gre) {
		this.r31_gre = r31_gre;
	}
	public BigDecimal getR31_trade() {
		return r31_trade;
	}
	public void setR31_trade(BigDecimal r31_trade) {
		this.r31_trade = r31_trade;
	}
	public BigDecimal getR31_individuals() {
		return r31_individuals;
	}
	public void setR31_individuals(BigDecimal r31_individuals) {
		this.r31_individuals = r31_individuals;
	}
	public BigDecimal getR31_investment() {
		return r31_investment;
	}
	public void setR31_investment(BigDecimal r31_investment) {
		this.r31_investment = r31_investment;
	}
	public BigDecimal getR31_nbfi1() {
		return r31_nbfi1;
	}
	public void setR31_nbfi1(BigDecimal r31_nbfi1) {
		this.r31_nbfi1 = r31_nbfi1;
	}
	public BigDecimal getR31_interbank1() {
		return r31_interbank1;
	}
	public void setR31_interbank1(BigDecimal r31_interbank1) {
		this.r31_interbank1 = r31_interbank1;
	}
	public BigDecimal getR31_gov1() {
		return r31_gov1;
	}
	public void setR31_gov1(BigDecimal r31_gov1) {
		this.r31_gov1 = r31_gov1;
	}
	public BigDecimal getR31_corporate1() {
		return r31_corporate1;
	}
	public void setR31_corporate1(BigDecimal r31_corporate1) {
		this.r31_corporate1 = r31_corporate1;
	}
	public BigDecimal getR31_gre1() {
		return r31_gre1;
	}
	public void setR31_gre1(BigDecimal r31_gre1) {
		this.r31_gre1 = r31_gre1;
	}
	public BigDecimal getR31_trade1() {
		return r31_trade1;
	}
	public void setR31_trade1(BigDecimal r31_trade1) {
		this.r31_trade1 = r31_trade1;
	}
	public BigDecimal getR31_individuals1() {
		return r31_individuals1;
	}
	public void setR31_individuals1(BigDecimal r31_individuals1) {
		this.r31_individuals1 = r31_individuals1;
	}
	public BigDecimal getR31_investment1() {
		return r31_investment1;
	}
	public void setR31_investment1(BigDecimal r31_investment1) {
		this.r31_investment1 = r31_investment1;
	}
	public BigDecimal getR31_zer0() {
		return r31_zer0;
	}
	public void setR31_zer0(BigDecimal r31_zer0) {
		this.r31_zer0 = r31_zer0;
	}
	public BigDecimal getR31_three() {
		return r31_three;
	}
	public void setR31_three(BigDecimal r31_three) {
		this.r31_three = r31_three;
	}
	public BigDecimal getR31_six() {
		return r31_six;
	}
	public void setR31_six(BigDecimal r31_six) {
		this.r31_six = r31_six;
	}
	public BigDecimal getR31_oneyear() {
		return r31_oneyear;
	}
	public void setR31_oneyear(BigDecimal r31_oneyear) {
		this.r31_oneyear = r31_oneyear;
	}
	public BigDecimal getR31_foreign() {
		return r31_foreign;
	}
	public void setR31_foreign(BigDecimal r31_foreign) {
		this.r31_foreign = r31_foreign;
	}
	public BigDecimal getR31_banks() {
		return r31_banks;
	}
	public void setR31_banks(BigDecimal r31_banks) {
		this.r31_banks = r31_banks;
	}
	public BigDecimal getR31_gov2() {
		return r31_gov2;
	}
	public void setR31_gov2(BigDecimal r31_gov2) {
		this.r31_gov2 = r31_gov2;
	}
	public BigDecimal getR31_other() {
		return r31_other;
	}
	public void setR31_other(BigDecimal r31_other) {
		this.r31_other = r31_other;
	}
	public BigDecimal getR31_banks1() {
		return r31_banks1;
	}
	public void setR31_banks1(BigDecimal r31_banks1) {
		this.r31_banks1 = r31_banks1;
	}
	public BigDecimal getR31_individuals2() {
		return r31_individuals2;
	}
	public void setR31_individuals2(BigDecimal r31_individuals2) {
		this.r31_individuals2 = r31_individuals2;
	}
	public BigDecimal getR31_other1() {
		return r31_other1;
	}
	public void setR31_other1(BigDecimal r31_other1) {
		this.r31_other1 = r31_other1;
	}
	public BigDecimal getR31_banks2() {
		return r31_banks2;
	}
	public void setR31_banks2(BigDecimal r31_banks2) {
		this.r31_banks2 = r31_banks2;
	}
	public BigDecimal getR31_gov3() {
		return r31_gov3;
	}
	public void setR31_gov3(BigDecimal r31_gov3) {
		this.r31_gov3 = r31_gov3;
	}
	public BigDecimal getR31_others2() {
		return r31_others2;
	}
	public void setR31_others2(BigDecimal r31_others2) {
		this.r31_others2 = r31_others2;
	}
	public BigDecimal getR31_banks3() {
		return r31_banks3;
	}
	public void setR31_banks3(BigDecimal r31_banks3) {
		this.r31_banks3 = r31_banks3;
	}
	public BigDecimal getR31_gov4() {
		return r31_gov4;
	}
	public void setR31_gov4(BigDecimal r31_gov4) {
		this.r31_gov4 = r31_gov4;
	}
	public BigDecimal getR31_others3() {
		return r31_others3;
	}
	public void setR31_others3(BigDecimal r31_others3) {
		this.r31_others3 = r31_others3;
	}
	public BigDecimal getR31_foreign1() {
		return r31_foreign1;
	}
	public void setR31_foreign1(BigDecimal r31_foreign1) {
		this.r31_foreign1 = r31_foreign1;
	}
	public BigDecimal getR31_guarantees() {
		return r31_guarantees;
	}
	public void setR31_guarantees(BigDecimal r31_guarantees) {
		this.r31_guarantees = r31_guarantees;
	}
	public BigDecimal getR31_nbfi2() {
		return r31_nbfi2;
	}
	public void setR31_nbfi2(BigDecimal r31_nbfi2) {
		this.r31_nbfi2 = r31_nbfi2;
	}
	public BigDecimal getR31_interbank2() {
		return r31_interbank2;
	}
	public void setR31_interbank2(BigDecimal r31_interbank2) {
		this.r31_interbank2 = r31_interbank2;
	}
	public BigDecimal getR31_gov5() {
		return r31_gov5;
	}
	public void setR31_gov5(BigDecimal r31_gov5) {
		this.r31_gov5 = r31_gov5;
	}
	public BigDecimal getR31_corporate2() {
		return r31_corporate2;
	}
	public void setR31_corporate2(BigDecimal r31_corporate2) {
		this.r31_corporate2 = r31_corporate2;
	}
	public BigDecimal getR31_gre2() {
		return r31_gre2;
	}
	public void setR31_gre2(BigDecimal r31_gre2) {
		this.r31_gre2 = r31_gre2;
	}
	public BigDecimal getR31_individuals3() {
		return r31_individuals3;
	}
	public void setR31_individuals3(BigDecimal r31_individuals3) {
		this.r31_individuals3 = r31_individuals3;
	}
	public BigDecimal getR31_zero1() {
		return r31_zero1;
	}
	public void setR31_zero1(BigDecimal r31_zero1) {
		this.r31_zero1 = r31_zero1;
	}
	public BigDecimal getR31_three1() {
		return r31_three1;
	}
	public void setR31_three1(BigDecimal r31_three1) {
		this.r31_three1 = r31_three1;
	}
	public BigDecimal getR31_six1() {
		return r31_six1;
	}
	public void setR31_six1(BigDecimal r31_six1) {
		this.r31_six1 = r31_six1;
	}
	public BigDecimal getR31_oneyear1() {
		return r31_oneyear1;
	}
	public void setR31_oneyear1(BigDecimal r31_oneyear1) {
		this.r31_oneyear1 = r31_oneyear1;
	}
	public String getR31_empty() {
		return r31_empty;
	}
	public void setR31_empty(String r31_empty) {
		this.r31_empty = r31_empty;
	}
	public String getR32_product() {
		return r32_product;
	}
	public void setR32_product(String r32_product) {
		this.r32_product = r32_product;
	}
	public BigDecimal getR32_nbfi() {
		return r32_nbfi;
	}
	public void setR32_nbfi(BigDecimal r32_nbfi) {
		this.r32_nbfi = r32_nbfi;
	}
	public BigDecimal getR32_interbank() {
		return r32_interbank;
	}
	public void setR32_interbank(BigDecimal r32_interbank) {
		this.r32_interbank = r32_interbank;
	}
	public BigDecimal getR32_gov() {
		return r32_gov;
	}
	public void setR32_gov(BigDecimal r32_gov) {
		this.r32_gov = r32_gov;
	}
	public BigDecimal getR32_corporate() {
		return r32_corporate;
	}
	public void setR32_corporate(BigDecimal r32_corporate) {
		this.r32_corporate = r32_corporate;
	}
	public BigDecimal getR32_gre() {
		return r32_gre;
	}
	public void setR32_gre(BigDecimal r32_gre) {
		this.r32_gre = r32_gre;
	}
	public BigDecimal getR32_trade() {
		return r32_trade;
	}
	public void setR32_trade(BigDecimal r32_trade) {
		this.r32_trade = r32_trade;
	}
	public BigDecimal getR32_individuals() {
		return r32_individuals;
	}
	public void setR32_individuals(BigDecimal r32_individuals) {
		this.r32_individuals = r32_individuals;
	}
	public BigDecimal getR32_investment() {
		return r32_investment;
	}
	public void setR32_investment(BigDecimal r32_investment) {
		this.r32_investment = r32_investment;
	}
	public BigDecimal getR32_nbfi1() {
		return r32_nbfi1;
	}
	public void setR32_nbfi1(BigDecimal r32_nbfi1) {
		this.r32_nbfi1 = r32_nbfi1;
	}
	public BigDecimal getR32_interbank1() {
		return r32_interbank1;
	}
	public void setR32_interbank1(BigDecimal r32_interbank1) {
		this.r32_interbank1 = r32_interbank1;
	}
	public BigDecimal getR32_gov1() {
		return r32_gov1;
	}
	public void setR32_gov1(BigDecimal r32_gov1) {
		this.r32_gov1 = r32_gov1;
	}
	public BigDecimal getR32_corporate1() {
		return r32_corporate1;
	}
	public void setR32_corporate1(BigDecimal r32_corporate1) {
		this.r32_corporate1 = r32_corporate1;
	}
	public BigDecimal getR32_gre1() {
		return r32_gre1;
	}
	public void setR32_gre1(BigDecimal r32_gre1) {
		this.r32_gre1 = r32_gre1;
	}
	public BigDecimal getR32_trade1() {
		return r32_trade1;
	}
	public void setR32_trade1(BigDecimal r32_trade1) {
		this.r32_trade1 = r32_trade1;
	}
	public BigDecimal getR32_individuals1() {
		return r32_individuals1;
	}
	public void setR32_individuals1(BigDecimal r32_individuals1) {
		this.r32_individuals1 = r32_individuals1;
	}
	public BigDecimal getR32_investment1() {
		return r32_investment1;
	}
	public void setR32_investment1(BigDecimal r32_investment1) {
		this.r32_investment1 = r32_investment1;
	}
	public BigDecimal getR32_zer0() {
		return r32_zer0;
	}
	public void setR32_zer0(BigDecimal r32_zer0) {
		this.r32_zer0 = r32_zer0;
	}
	public BigDecimal getR32_three() {
		return r32_three;
	}
	public void setR32_three(BigDecimal r32_three) {
		this.r32_three = r32_three;
	}
	public BigDecimal getR32_six() {
		return r32_six;
	}
	public void setR32_six(BigDecimal r32_six) {
		this.r32_six = r32_six;
	}
	public BigDecimal getR32_oneyear() {
		return r32_oneyear;
	}
	public void setR32_oneyear(BigDecimal r32_oneyear) {
		this.r32_oneyear = r32_oneyear;
	}
	public BigDecimal getR32_foreign() {
		return r32_foreign;
	}
	public void setR32_foreign(BigDecimal r32_foreign) {
		this.r32_foreign = r32_foreign;
	}
	public BigDecimal getR32_banks() {
		return r32_banks;
	}
	public void setR32_banks(BigDecimal r32_banks) {
		this.r32_banks = r32_banks;
	}
	public BigDecimal getR32_gov2() {
		return r32_gov2;
	}
	public void setR32_gov2(BigDecimal r32_gov2) {
		this.r32_gov2 = r32_gov2;
	}
	public BigDecimal getR32_other() {
		return r32_other;
	}
	public void setR32_other(BigDecimal r32_other) {
		this.r32_other = r32_other;
	}
	public BigDecimal getR32_banks1() {
		return r32_banks1;
	}
	public void setR32_banks1(BigDecimal r32_banks1) {
		this.r32_banks1 = r32_banks1;
	}
	public BigDecimal getR32_individuals2() {
		return r32_individuals2;
	}
	public void setR32_individuals2(BigDecimal r32_individuals2) {
		this.r32_individuals2 = r32_individuals2;
	}
	public BigDecimal getR32_other1() {
		return r32_other1;
	}
	public void setR32_other1(BigDecimal r32_other1) {
		this.r32_other1 = r32_other1;
	}
	public BigDecimal getR32_banks2() {
		return r32_banks2;
	}
	public void setR32_banks2(BigDecimal r32_banks2) {
		this.r32_banks2 = r32_banks2;
	}
	public BigDecimal getR32_gov3() {
		return r32_gov3;
	}
	public void setR32_gov3(BigDecimal r32_gov3) {
		this.r32_gov3 = r32_gov3;
	}
	public BigDecimal getR32_others2() {
		return r32_others2;
	}
	public void setR32_others2(BigDecimal r32_others2) {
		this.r32_others2 = r32_others2;
	}
	public BigDecimal getR32_banks3() {
		return r32_banks3;
	}
	public void setR32_banks3(BigDecimal r32_banks3) {
		this.r32_banks3 = r32_banks3;
	}
	public BigDecimal getR32_gov4() {
		return r32_gov4;
	}
	public void setR32_gov4(BigDecimal r32_gov4) {
		this.r32_gov4 = r32_gov4;
	}
	public BigDecimal getR32_others3() {
		return r32_others3;
	}
	public void setR32_others3(BigDecimal r32_others3) {
		this.r32_others3 = r32_others3;
	}
	public BigDecimal getR32_foreign1() {
		return r32_foreign1;
	}
	public void setR32_foreign1(BigDecimal r32_foreign1) {
		this.r32_foreign1 = r32_foreign1;
	}
	public BigDecimal getR32_guarantees() {
		return r32_guarantees;
	}
	public void setR32_guarantees(BigDecimal r32_guarantees) {
		this.r32_guarantees = r32_guarantees;
	}
	public BigDecimal getR32_nbfi2() {
		return r32_nbfi2;
	}
	public void setR32_nbfi2(BigDecimal r32_nbfi2) {
		this.r32_nbfi2 = r32_nbfi2;
	}
	public BigDecimal getR32_interbank2() {
		return r32_interbank2;
	}
	public void setR32_interbank2(BigDecimal r32_interbank2) {
		this.r32_interbank2 = r32_interbank2;
	}
	public BigDecimal getR32_gov5() {
		return r32_gov5;
	}
	public void setR32_gov5(BigDecimal r32_gov5) {
		this.r32_gov5 = r32_gov5;
	}
	public BigDecimal getR32_corporate2() {
		return r32_corporate2;
	}
	public void setR32_corporate2(BigDecimal r32_corporate2) {
		this.r32_corporate2 = r32_corporate2;
	}
	public BigDecimal getR32_gre2() {
		return r32_gre2;
	}
	public void setR32_gre2(BigDecimal r32_gre2) {
		this.r32_gre2 = r32_gre2;
	}
	public BigDecimal getR32_individuals3() {
		return r32_individuals3;
	}
	public void setR32_individuals3(BigDecimal r32_individuals3) {
		this.r32_individuals3 = r32_individuals3;
	}
	public BigDecimal getR32_zero1() {
		return r32_zero1;
	}
	public void setR32_zero1(BigDecimal r32_zero1) {
		this.r32_zero1 = r32_zero1;
	}
	public BigDecimal getR32_three1() {
		return r32_three1;
	}
	public void setR32_three1(BigDecimal r32_three1) {
		this.r32_three1 = r32_three1;
	}
	public BigDecimal getR32_six1() {
		return r32_six1;
	}
	public void setR32_six1(BigDecimal r32_six1) {
		this.r32_six1 = r32_six1;
	}
	public BigDecimal getR32_oneyear1() {
		return r32_oneyear1;
	}
	public void setR32_oneyear1(BigDecimal r32_oneyear1) {
		this.r32_oneyear1 = r32_oneyear1;
	}
	public String getR32_empty() {
		return r32_empty;
	}
	public void setR32_empty(String r32_empty) {
		this.r32_empty = r32_empty;
	}
	public String getR33_product() {
		return r33_product;
	}
	public void setR33_product(String r33_product) {
		this.r33_product = r33_product;
	}
	public BigDecimal getR33_nbfi() {
		return r33_nbfi;
	}
	public void setR33_nbfi(BigDecimal r33_nbfi) {
		this.r33_nbfi = r33_nbfi;
	}
	public BigDecimal getR33_interbank() {
		return r33_interbank;
	}
	public void setR33_interbank(BigDecimal r33_interbank) {
		this.r33_interbank = r33_interbank;
	}
	public BigDecimal getR33_gov() {
		return r33_gov;
	}
	public void setR33_gov(BigDecimal r33_gov) {
		this.r33_gov = r33_gov;
	}
	public BigDecimal getR33_corporate() {
		return r33_corporate;
	}
	public void setR33_corporate(BigDecimal r33_corporate) {
		this.r33_corporate = r33_corporate;
	}
	public BigDecimal getR33_gre() {
		return r33_gre;
	}
	public void setR33_gre(BigDecimal r33_gre) {
		this.r33_gre = r33_gre;
	}
	public BigDecimal getR33_trade() {
		return r33_trade;
	}
	public void setR33_trade(BigDecimal r33_trade) {
		this.r33_trade = r33_trade;
	}
	public BigDecimal getR33_individuals() {
		return r33_individuals;
	}
	public void setR33_individuals(BigDecimal r33_individuals) {
		this.r33_individuals = r33_individuals;
	}
	public BigDecimal getR33_investment() {
		return r33_investment;
	}
	public void setR33_investment(BigDecimal r33_investment) {
		this.r33_investment = r33_investment;
	}
	public BigDecimal getR33_nbfi1() {
		return r33_nbfi1;
	}
	public void setR33_nbfi1(BigDecimal r33_nbfi1) {
		this.r33_nbfi1 = r33_nbfi1;
	}
	public BigDecimal getR33_interbank1() {
		return r33_interbank1;
	}
	public void setR33_interbank1(BigDecimal r33_interbank1) {
		this.r33_interbank1 = r33_interbank1;
	}
	public BigDecimal getR33_gov1() {
		return r33_gov1;
	}
	public void setR33_gov1(BigDecimal r33_gov1) {
		this.r33_gov1 = r33_gov1;
	}
	public BigDecimal getR33_corporate1() {
		return r33_corporate1;
	}
	public void setR33_corporate1(BigDecimal r33_corporate1) {
		this.r33_corporate1 = r33_corporate1;
	}
	public BigDecimal getR33_gre1() {
		return r33_gre1;
	}
	public void setR33_gre1(BigDecimal r33_gre1) {
		this.r33_gre1 = r33_gre1;
	}
	public BigDecimal getR33_trade1() {
		return r33_trade1;
	}
	public void setR33_trade1(BigDecimal r33_trade1) {
		this.r33_trade1 = r33_trade1;
	}
	public BigDecimal getR33_individuals1() {
		return r33_individuals1;
	}
	public void setR33_individuals1(BigDecimal r33_individuals1) {
		this.r33_individuals1 = r33_individuals1;
	}
	public BigDecimal getR33_investment1() {
		return r33_investment1;
	}
	public void setR33_investment1(BigDecimal r33_investment1) {
		this.r33_investment1 = r33_investment1;
	}
	public BigDecimal getR33_zer0() {
		return r33_zer0;
	}
	public void setR33_zer0(BigDecimal r33_zer0) {
		this.r33_zer0 = r33_zer0;
	}
	public BigDecimal getR33_three() {
		return r33_three;
	}
	public void setR33_three(BigDecimal r33_three) {
		this.r33_three = r33_three;
	}
	public BigDecimal getR33_six() {
		return r33_six;
	}
	public void setR33_six(BigDecimal r33_six) {
		this.r33_six = r33_six;
	}
	public BigDecimal getR33_oneyear() {
		return r33_oneyear;
	}
	public void setR33_oneyear(BigDecimal r33_oneyear) {
		this.r33_oneyear = r33_oneyear;
	}
	public BigDecimal getR33_foreign() {
		return r33_foreign;
	}
	public void setR33_foreign(BigDecimal r33_foreign) {
		this.r33_foreign = r33_foreign;
	}
	public BigDecimal getR33_banks() {
		return r33_banks;
	}
	public void setR33_banks(BigDecimal r33_banks) {
		this.r33_banks = r33_banks;
	}
	public BigDecimal getR33_gov2() {
		return r33_gov2;
	}
	public void setR33_gov2(BigDecimal r33_gov2) {
		this.r33_gov2 = r33_gov2;
	}
	public BigDecimal getR33_other() {
		return r33_other;
	}
	public void setR33_other(BigDecimal r33_other) {
		this.r33_other = r33_other;
	}
	public BigDecimal getR33_banks1() {
		return r33_banks1;
	}
	public void setR33_banks1(BigDecimal r33_banks1) {
		this.r33_banks1 = r33_banks1;
	}
	public BigDecimal getR33_individuals2() {
		return r33_individuals2;
	}
	public void setR33_individuals2(BigDecimal r33_individuals2) {
		this.r33_individuals2 = r33_individuals2;
	}
	public BigDecimal getR33_other1() {
		return r33_other1;
	}
	public void setR33_other1(BigDecimal r33_other1) {
		this.r33_other1 = r33_other1;
	}
	public BigDecimal getR33_banks2() {
		return r33_banks2;
	}
	public void setR33_banks2(BigDecimal r33_banks2) {
		this.r33_banks2 = r33_banks2;
	}
	public BigDecimal getR33_gov3() {
		return r33_gov3;
	}
	public void setR33_gov3(BigDecimal r33_gov3) {
		this.r33_gov3 = r33_gov3;
	}
	public BigDecimal getR33_others2() {
		return r33_others2;
	}
	public void setR33_others2(BigDecimal r33_others2) {
		this.r33_others2 = r33_others2;
	}
	public BigDecimal getR33_banks3() {
		return r33_banks3;
	}
	public void setR33_banks3(BigDecimal r33_banks3) {
		this.r33_banks3 = r33_banks3;
	}
	public BigDecimal getR33_gov4() {
		return r33_gov4;
	}
	public void setR33_gov4(BigDecimal r33_gov4) {
		this.r33_gov4 = r33_gov4;
	}
	public BigDecimal getR33_others3() {
		return r33_others3;
	}
	public void setR33_others3(BigDecimal r33_others3) {
		this.r33_others3 = r33_others3;
	}
	public BigDecimal getR33_foreign1() {
		return r33_foreign1;
	}
	public void setR33_foreign1(BigDecimal r33_foreign1) {
		this.r33_foreign1 = r33_foreign1;
	}
	public BigDecimal getR33_guarantees() {
		return r33_guarantees;
	}
	public void setR33_guarantees(BigDecimal r33_guarantees) {
		this.r33_guarantees = r33_guarantees;
	}
	public BigDecimal getR33_nbfi2() {
		return r33_nbfi2;
	}
	public void setR33_nbfi2(BigDecimal r33_nbfi2) {
		this.r33_nbfi2 = r33_nbfi2;
	}
	public BigDecimal getR33_interbank2() {
		return r33_interbank2;
	}
	public void setR33_interbank2(BigDecimal r33_interbank2) {
		this.r33_interbank2 = r33_interbank2;
	}
	public BigDecimal getR33_gov5() {
		return r33_gov5;
	}
	public void setR33_gov5(BigDecimal r33_gov5) {
		this.r33_gov5 = r33_gov5;
	}
	public BigDecimal getR33_corporate2() {
		return r33_corporate2;
	}
	public void setR33_corporate2(BigDecimal r33_corporate2) {
		this.r33_corporate2 = r33_corporate2;
	}
	public BigDecimal getR33_gre2() {
		return r33_gre2;
	}
	public void setR33_gre2(BigDecimal r33_gre2) {
		this.r33_gre2 = r33_gre2;
	}
	public BigDecimal getR33_individuals3() {
		return r33_individuals3;
	}
	public void setR33_individuals3(BigDecimal r33_individuals3) {
		this.r33_individuals3 = r33_individuals3;
	}
	public BigDecimal getR33_zero1() {
		return r33_zero1;
	}
	public void setR33_zero1(BigDecimal r33_zero1) {
		this.r33_zero1 = r33_zero1;
	}
	public BigDecimal getR33_three1() {
		return r33_three1;
	}
	public void setR33_three1(BigDecimal r33_three1) {
		this.r33_three1 = r33_three1;
	}
	public BigDecimal getR33_six1() {
		return r33_six1;
	}
	public void setR33_six1(BigDecimal r33_six1) {
		this.r33_six1 = r33_six1;
	}
	public BigDecimal getR33_oneyear1() {
		return r33_oneyear1;
	}
	public void setR33_oneyear1(BigDecimal r33_oneyear1) {
		this.r33_oneyear1 = r33_oneyear1;
	}
	public String getR33_empty() {
		return r33_empty;
	}
	public void setR33_empty(String r33_empty) {
		this.r33_empty = r33_empty;
	}
	public String getR34_product() {
		return r34_product;
	}
	public void setR34_product(String r34_product) {
		this.r34_product = r34_product;
	}
	public BigDecimal getR34_nbfi() {
		return r34_nbfi;
	}
	public void setR34_nbfi(BigDecimal r34_nbfi) {
		this.r34_nbfi = r34_nbfi;
	}
	public BigDecimal getR34_interbank() {
		return r34_interbank;
	}
	public void setR34_interbank(BigDecimal r34_interbank) {
		this.r34_interbank = r34_interbank;
	}
	public BigDecimal getR34_gov() {
		return r34_gov;
	}
	public void setR34_gov(BigDecimal r34_gov) {
		this.r34_gov = r34_gov;
	}
	public BigDecimal getR34_corporate() {
		return r34_corporate;
	}
	public void setR34_corporate(BigDecimal r34_corporate) {
		this.r34_corporate = r34_corporate;
	}
	public BigDecimal getR34_gre() {
		return r34_gre;
	}
	public void setR34_gre(BigDecimal r34_gre) {
		this.r34_gre = r34_gre;
	}
	public BigDecimal getR34_trade() {
		return r34_trade;
	}
	public void setR34_trade(BigDecimal r34_trade) {
		this.r34_trade = r34_trade;
	}
	public BigDecimal getR34_individuals() {
		return r34_individuals;
	}
	public void setR34_individuals(BigDecimal r34_individuals) {
		this.r34_individuals = r34_individuals;
	}
	public BigDecimal getR34_investment() {
		return r34_investment;
	}
	public void setR34_investment(BigDecimal r34_investment) {
		this.r34_investment = r34_investment;
	}
	public BigDecimal getR34_nbfi1() {
		return r34_nbfi1;
	}
	public void setR34_nbfi1(BigDecimal r34_nbfi1) {
		this.r34_nbfi1 = r34_nbfi1;
	}
	public BigDecimal getR34_interbank1() {
		return r34_interbank1;
	}
	public void setR34_interbank1(BigDecimal r34_interbank1) {
		this.r34_interbank1 = r34_interbank1;
	}
	public BigDecimal getR34_gov1() {
		return r34_gov1;
	}
	public void setR34_gov1(BigDecimal r34_gov1) {
		this.r34_gov1 = r34_gov1;
	}
	public BigDecimal getR34_corporate1() {
		return r34_corporate1;
	}
	public void setR34_corporate1(BigDecimal r34_corporate1) {
		this.r34_corporate1 = r34_corporate1;
	}
	public BigDecimal getR34_gre1() {
		return r34_gre1;
	}
	public void setR34_gre1(BigDecimal r34_gre1) {
		this.r34_gre1 = r34_gre1;
	}
	public BigDecimal getR34_trade1() {
		return r34_trade1;
	}
	public void setR34_trade1(BigDecimal r34_trade1) {
		this.r34_trade1 = r34_trade1;
	}
	public BigDecimal getR34_individuals1() {
		return r34_individuals1;
	}
	public void setR34_individuals1(BigDecimal r34_individuals1) {
		this.r34_individuals1 = r34_individuals1;
	}
	public BigDecimal getR34_investment1() {
		return r34_investment1;
	}
	public void setR34_investment1(BigDecimal r34_investment1) {
		this.r34_investment1 = r34_investment1;
	}
	public BigDecimal getR34_zer0() {
		return r34_zer0;
	}
	public void setR34_zer0(BigDecimal r34_zer0) {
		this.r34_zer0 = r34_zer0;
	}
	public BigDecimal getR34_three() {
		return r34_three;
	}
	public void setR34_three(BigDecimal r34_three) {
		this.r34_three = r34_three;
	}
	public BigDecimal getR34_six() {
		return r34_six;
	}
	public void setR34_six(BigDecimal r34_six) {
		this.r34_six = r34_six;
	}
	public BigDecimal getR34_oneyear() {
		return r34_oneyear;
	}
	public void setR34_oneyear(BigDecimal r34_oneyear) {
		this.r34_oneyear = r34_oneyear;
	}
	public BigDecimal getR34_foreign() {
		return r34_foreign;
	}
	public void setR34_foreign(BigDecimal r34_foreign) {
		this.r34_foreign = r34_foreign;
	}
	public BigDecimal getR34_banks() {
		return r34_banks;
	}
	public void setR34_banks(BigDecimal r34_banks) {
		this.r34_banks = r34_banks;
	}
	public BigDecimal getR34_gov2() {
		return r34_gov2;
	}
	public void setR34_gov2(BigDecimal r34_gov2) {
		this.r34_gov2 = r34_gov2;
	}
	public BigDecimal getR34_other() {
		return r34_other;
	}
	public void setR34_other(BigDecimal r34_other) {
		this.r34_other = r34_other;
	}
	public BigDecimal getR34_banks1() {
		return r34_banks1;
	}
	public void setR34_banks1(BigDecimal r34_banks1) {
		this.r34_banks1 = r34_banks1;
	}
	public BigDecimal getR34_individuals2() {
		return r34_individuals2;
	}
	public void setR34_individuals2(BigDecimal r34_individuals2) {
		this.r34_individuals2 = r34_individuals2;
	}
	public BigDecimal getR34_other1() {
		return r34_other1;
	}
	public void setR34_other1(BigDecimal r34_other1) {
		this.r34_other1 = r34_other1;
	}
	public BigDecimal getR34_banks2() {
		return r34_banks2;
	}
	public void setR34_banks2(BigDecimal r34_banks2) {
		this.r34_banks2 = r34_banks2;
	}
	public BigDecimal getR34_gov3() {
		return r34_gov3;
	}
	public void setR34_gov3(BigDecimal r34_gov3) {
		this.r34_gov3 = r34_gov3;
	}
	public BigDecimal getR34_others2() {
		return r34_others2;
	}
	public void setR34_others2(BigDecimal r34_others2) {
		this.r34_others2 = r34_others2;
	}
	public BigDecimal getR34_banks3() {
		return r34_banks3;
	}
	public void setR34_banks3(BigDecimal r34_banks3) {
		this.r34_banks3 = r34_banks3;
	}
	public BigDecimal getR34_gov4() {
		return r34_gov4;
	}
	public void setR34_gov4(BigDecimal r34_gov4) {
		this.r34_gov4 = r34_gov4;
	}
	public BigDecimal getR34_others3() {
		return r34_others3;
	}
	public void setR34_others3(BigDecimal r34_others3) {
		this.r34_others3 = r34_others3;
	}
	public BigDecimal getR34_foreign1() {
		return r34_foreign1;
	}
	public void setR34_foreign1(BigDecimal r34_foreign1) {
		this.r34_foreign1 = r34_foreign1;
	}
	public BigDecimal getR34_guarantees() {
		return r34_guarantees;
	}
	public void setR34_guarantees(BigDecimal r34_guarantees) {
		this.r34_guarantees = r34_guarantees;
	}
	public BigDecimal getR34_nbfi2() {
		return r34_nbfi2;
	}
	public void setR34_nbfi2(BigDecimal r34_nbfi2) {
		this.r34_nbfi2 = r34_nbfi2;
	}
	public BigDecimal getR34_interbank2() {
		return r34_interbank2;
	}
	public void setR34_interbank2(BigDecimal r34_interbank2) {
		this.r34_interbank2 = r34_interbank2;
	}
	public BigDecimal getR34_gov5() {
		return r34_gov5;
	}
	public void setR34_gov5(BigDecimal r34_gov5) {
		this.r34_gov5 = r34_gov5;
	}
	public BigDecimal getR34_corporate2() {
		return r34_corporate2;
	}
	public void setR34_corporate2(BigDecimal r34_corporate2) {
		this.r34_corporate2 = r34_corporate2;
	}
	public BigDecimal getR34_gre2() {
		return r34_gre2;
	}
	public void setR34_gre2(BigDecimal r34_gre2) {
		this.r34_gre2 = r34_gre2;
	}
	public BigDecimal getR34_individuals3() {
		return r34_individuals3;
	}
	public void setR34_individuals3(BigDecimal r34_individuals3) {
		this.r34_individuals3 = r34_individuals3;
	}
	public BigDecimal getR34_zero1() {
		return r34_zero1;
	}
	public void setR34_zero1(BigDecimal r34_zero1) {
		this.r34_zero1 = r34_zero1;
	}
	public BigDecimal getR34_three1() {
		return r34_three1;
	}
	public void setR34_three1(BigDecimal r34_three1) {
		this.r34_three1 = r34_three1;
	}
	public BigDecimal getR34_six1() {
		return r34_six1;
	}
	public void setR34_six1(BigDecimal r34_six1) {
		this.r34_six1 = r34_six1;
	}
	public BigDecimal getR34_oneyear1() {
		return r34_oneyear1;
	}
	public void setR34_oneyear1(BigDecimal r34_oneyear1) {
		this.r34_oneyear1 = r34_oneyear1;
	}
	public String getR34_empty() {
		return r34_empty;
	}
	public void setR34_empty(String r34_empty) {
		this.r34_empty = r34_empty;
	}
	public String getR35_product() {
		return r35_product;
	}
	public void setR35_product(String r35_product) {
		this.r35_product = r35_product;
	}
	public BigDecimal getR35_nbfi() {
		return r35_nbfi;
	}
	public void setR35_nbfi(BigDecimal r35_nbfi) {
		this.r35_nbfi = r35_nbfi;
	}
	public BigDecimal getR35_interbank() {
		return r35_interbank;
	}
	public void setR35_interbank(BigDecimal r35_interbank) {
		this.r35_interbank = r35_interbank;
	}
	public BigDecimal getR35_gov() {
		return r35_gov;
	}
	public void setR35_gov(BigDecimal r35_gov) {
		this.r35_gov = r35_gov;
	}
	public BigDecimal getR35_corporate() {
		return r35_corporate;
	}
	public void setR35_corporate(BigDecimal r35_corporate) {
		this.r35_corporate = r35_corporate;
	}
	public BigDecimal getR35_gre() {
		return r35_gre;
	}
	public void setR35_gre(BigDecimal r35_gre) {
		this.r35_gre = r35_gre;
	}
	public BigDecimal getR35_trade() {
		return r35_trade;
	}
	public void setR35_trade(BigDecimal r35_trade) {
		this.r35_trade = r35_trade;
	}
	public BigDecimal getR35_individuals() {
		return r35_individuals;
	}
	public void setR35_individuals(BigDecimal r35_individuals) {
		this.r35_individuals = r35_individuals;
	}
	public BigDecimal getR35_investment() {
		return r35_investment;
	}
	public void setR35_investment(BigDecimal r35_investment) {
		this.r35_investment = r35_investment;
	}
	public BigDecimal getR35_nbfi1() {
		return r35_nbfi1;
	}
	public void setR35_nbfi1(BigDecimal r35_nbfi1) {
		this.r35_nbfi1 = r35_nbfi1;
	}
	public BigDecimal getR35_interbank1() {
		return r35_interbank1;
	}
	public void setR35_interbank1(BigDecimal r35_interbank1) {
		this.r35_interbank1 = r35_interbank1;
	}
	public BigDecimal getR35_gov1() {
		return r35_gov1;
	}
	public void setR35_gov1(BigDecimal r35_gov1) {
		this.r35_gov1 = r35_gov1;
	}
	public BigDecimal getR35_corporate1() {
		return r35_corporate1;
	}
	public void setR35_corporate1(BigDecimal r35_corporate1) {
		this.r35_corporate1 = r35_corporate1;
	}
	public BigDecimal getR35_gre1() {
		return r35_gre1;
	}
	public void setR35_gre1(BigDecimal r35_gre1) {
		this.r35_gre1 = r35_gre1;
	}
	public BigDecimal getR35_trade1() {
		return r35_trade1;
	}
	public void setR35_trade1(BigDecimal r35_trade1) {
		this.r35_trade1 = r35_trade1;
	}
	public BigDecimal getR35_individuals1() {
		return r35_individuals1;
	}
	public void setR35_individuals1(BigDecimal r35_individuals1) {
		this.r35_individuals1 = r35_individuals1;
	}
	public BigDecimal getR35_investment1() {
		return r35_investment1;
	}
	public void setR35_investment1(BigDecimal r35_investment1) {
		this.r35_investment1 = r35_investment1;
	}
	public BigDecimal getR35_zer0() {
		return r35_zer0;
	}
	public void setR35_zer0(BigDecimal r35_zer0) {
		this.r35_zer0 = r35_zer0;
	}
	public BigDecimal getR35_three() {
		return r35_three;
	}
	public void setR35_three(BigDecimal r35_three) {
		this.r35_three = r35_three;
	}
	public BigDecimal getR35_six() {
		return r35_six;
	}
	public void setR35_six(BigDecimal r35_six) {
		this.r35_six = r35_six;
	}
	public BigDecimal getR35_oneyear() {
		return r35_oneyear;
	}
	public void setR35_oneyear(BigDecimal r35_oneyear) {
		this.r35_oneyear = r35_oneyear;
	}
	public BigDecimal getR35_foreign() {
		return r35_foreign;
	}
	public void setR35_foreign(BigDecimal r35_foreign) {
		this.r35_foreign = r35_foreign;
	}
	public BigDecimal getR35_banks() {
		return r35_banks;
	}
	public void setR35_banks(BigDecimal r35_banks) {
		this.r35_banks = r35_banks;
	}
	public BigDecimal getR35_gov2() {
		return r35_gov2;
	}
	public void setR35_gov2(BigDecimal r35_gov2) {
		this.r35_gov2 = r35_gov2;
	}
	public BigDecimal getR35_other() {
		return r35_other;
	}
	public void setR35_other(BigDecimal r35_other) {
		this.r35_other = r35_other;
	}
	public BigDecimal getR35_banks1() {
		return r35_banks1;
	}
	public void setR35_banks1(BigDecimal r35_banks1) {
		this.r35_banks1 = r35_banks1;
	}
	public BigDecimal getR35_individuals2() {
		return r35_individuals2;
	}
	public void setR35_individuals2(BigDecimal r35_individuals2) {
		this.r35_individuals2 = r35_individuals2;
	}
	public BigDecimal getR35_other1() {
		return r35_other1;
	}
	public void setR35_other1(BigDecimal r35_other1) {
		this.r35_other1 = r35_other1;
	}
	public BigDecimal getR35_banks2() {
		return r35_banks2;
	}
	public void setR35_banks2(BigDecimal r35_banks2) {
		this.r35_banks2 = r35_banks2;
	}
	public BigDecimal getR35_gov3() {
		return r35_gov3;
	}
	public void setR35_gov3(BigDecimal r35_gov3) {
		this.r35_gov3 = r35_gov3;
	}
	public BigDecimal getR35_others2() {
		return r35_others2;
	}
	public void setR35_others2(BigDecimal r35_others2) {
		this.r35_others2 = r35_others2;
	}
	public BigDecimal getR35_banks3() {
		return r35_banks3;
	}
	public void setR35_banks3(BigDecimal r35_banks3) {
		this.r35_banks3 = r35_banks3;
	}
	public BigDecimal getR35_gov4() {
		return r35_gov4;
	}
	public void setR35_gov4(BigDecimal r35_gov4) {
		this.r35_gov4 = r35_gov4;
	}
	public BigDecimal getR35_others3() {
		return r35_others3;
	}
	public void setR35_others3(BigDecimal r35_others3) {
		this.r35_others3 = r35_others3;
	}
	public BigDecimal getR35_foreign1() {
		return r35_foreign1;
	}
	public void setR35_foreign1(BigDecimal r35_foreign1) {
		this.r35_foreign1 = r35_foreign1;
	}
	public BigDecimal getR35_guarantees() {
		return r35_guarantees;
	}
	public void setR35_guarantees(BigDecimal r35_guarantees) {
		this.r35_guarantees = r35_guarantees;
	}
	public BigDecimal getR35_nbfi2() {
		return r35_nbfi2;
	}
	public void setR35_nbfi2(BigDecimal r35_nbfi2) {
		this.r35_nbfi2 = r35_nbfi2;
	}
	public BigDecimal getR35_interbank2() {
		return r35_interbank2;
	}
	public void setR35_interbank2(BigDecimal r35_interbank2) {
		this.r35_interbank2 = r35_interbank2;
	}
	public BigDecimal getR35_gov5() {
		return r35_gov5;
	}
	public void setR35_gov5(BigDecimal r35_gov5) {
		this.r35_gov5 = r35_gov5;
	}
	public BigDecimal getR35_corporate2() {
		return r35_corporate2;
	}
	public void setR35_corporate2(BigDecimal r35_corporate2) {
		this.r35_corporate2 = r35_corporate2;
	}
	public BigDecimal getR35_gre2() {
		return r35_gre2;
	}
	public void setR35_gre2(BigDecimal r35_gre2) {
		this.r35_gre2 = r35_gre2;
	}
	public BigDecimal getR35_individuals3() {
		return r35_individuals3;
	}
	public void setR35_individuals3(BigDecimal r35_individuals3) {
		this.r35_individuals3 = r35_individuals3;
	}
	public BigDecimal getR35_zero1() {
		return r35_zero1;
	}
	public void setR35_zero1(BigDecimal r35_zero1) {
		this.r35_zero1 = r35_zero1;
	}
	public BigDecimal getR35_three1() {
		return r35_three1;
	}
	public void setR35_three1(BigDecimal r35_three1) {
		this.r35_three1 = r35_three1;
	}
	public BigDecimal getR35_six1() {
		return r35_six1;
	}
	public void setR35_six1(BigDecimal r35_six1) {
		this.r35_six1 = r35_six1;
	}
	public BigDecimal getR35_oneyear1() {
		return r35_oneyear1;
	}
	public void setR35_oneyear1(BigDecimal r35_oneyear1) {
		this.r35_oneyear1 = r35_oneyear1;
	}
	public String getR35_empty() {
		return r35_empty;
	}
	public void setR35_empty(String r35_empty) {
		this.r35_empty = r35_empty;
	}
	public String getR36_product() {
		return r36_product;
	}
	public void setR36_product(String r36_product) {
		this.r36_product = r36_product;
	}
	public BigDecimal getR36_nbfi() {
		return r36_nbfi;
	}
	public void setR36_nbfi(BigDecimal r36_nbfi) {
		this.r36_nbfi = r36_nbfi;
	}
	public BigDecimal getR36_interbank() {
		return r36_interbank;
	}
	public void setR36_interbank(BigDecimal r36_interbank) {
		this.r36_interbank = r36_interbank;
	}
	public BigDecimal getR36_gov() {
		return r36_gov;
	}
	public void setR36_gov(BigDecimal r36_gov) {
		this.r36_gov = r36_gov;
	}
	public BigDecimal getR36_corporate() {
		return r36_corporate;
	}
	public void setR36_corporate(BigDecimal r36_corporate) {
		this.r36_corporate = r36_corporate;
	}
	public BigDecimal getR36_gre() {
		return r36_gre;
	}
	public void setR36_gre(BigDecimal r36_gre) {
		this.r36_gre = r36_gre;
	}
	public BigDecimal getR36_trade() {
		return r36_trade;
	}
	public void setR36_trade(BigDecimal r36_trade) {
		this.r36_trade = r36_trade;
	}
	public BigDecimal getR36_individuals() {
		return r36_individuals;
	}
	public void setR36_individuals(BigDecimal r36_individuals) {
		this.r36_individuals = r36_individuals;
	}
	public BigDecimal getR36_investment() {
		return r36_investment;
	}
	public void setR36_investment(BigDecimal r36_investment) {
		this.r36_investment = r36_investment;
	}
	public BigDecimal getR36_nbfi1() {
		return r36_nbfi1;
	}
	public void setR36_nbfi1(BigDecimal r36_nbfi1) {
		this.r36_nbfi1 = r36_nbfi1;
	}
	public BigDecimal getR36_interbank1() {
		return r36_interbank1;
	}
	public void setR36_interbank1(BigDecimal r36_interbank1) {
		this.r36_interbank1 = r36_interbank1;
	}
	public BigDecimal getR36_gov1() {
		return r36_gov1;
	}
	public void setR36_gov1(BigDecimal r36_gov1) {
		this.r36_gov1 = r36_gov1;
	}
	public BigDecimal getR36_corporate1() {
		return r36_corporate1;
	}
	public void setR36_corporate1(BigDecimal r36_corporate1) {
		this.r36_corporate1 = r36_corporate1;
	}
	public BigDecimal getR36_gre1() {
		return r36_gre1;
	}
	public void setR36_gre1(BigDecimal r36_gre1) {
		this.r36_gre1 = r36_gre1;
	}
	public BigDecimal getR36_trade1() {
		return r36_trade1;
	}
	public void setR36_trade1(BigDecimal r36_trade1) {
		this.r36_trade1 = r36_trade1;
	}
	public BigDecimal getR36_individuals1() {
		return r36_individuals1;
	}
	public void setR36_individuals1(BigDecimal r36_individuals1) {
		this.r36_individuals1 = r36_individuals1;
	}
	public BigDecimal getR36_investment1() {
		return r36_investment1;
	}
	public void setR36_investment1(BigDecimal r36_investment1) {
		this.r36_investment1 = r36_investment1;
	}
	public BigDecimal getR36_zer0() {
		return r36_zer0;
	}
	public void setR36_zer0(BigDecimal r36_zer0) {
		this.r36_zer0 = r36_zer0;
	}
	public BigDecimal getR36_three() {
		return r36_three;
	}
	public void setR36_three(BigDecimal r36_three) {
		this.r36_three = r36_three;
	}
	public BigDecimal getR36_six() {
		return r36_six;
	}
	public void setR36_six(BigDecimal r36_six) {
		this.r36_six = r36_six;
	}
	public BigDecimal getR36_oneyear() {
		return r36_oneyear;
	}
	public void setR36_oneyear(BigDecimal r36_oneyear) {
		this.r36_oneyear = r36_oneyear;
	}
	public BigDecimal getR36_foreign() {
		return r36_foreign;
	}
	public void setR36_foreign(BigDecimal r36_foreign) {
		this.r36_foreign = r36_foreign;
	}
	public BigDecimal getR36_banks() {
		return r36_banks;
	}
	public void setR36_banks(BigDecimal r36_banks) {
		this.r36_banks = r36_banks;
	}
	public BigDecimal getR36_gov2() {
		return r36_gov2;
	}
	public void setR36_gov2(BigDecimal r36_gov2) {
		this.r36_gov2 = r36_gov2;
	}
	public BigDecimal getR36_other() {
		return r36_other;
	}
	public void setR36_other(BigDecimal r36_other) {
		this.r36_other = r36_other;
	}
	public BigDecimal getR36_banks1() {
		return r36_banks1;
	}
	public void setR36_banks1(BigDecimal r36_banks1) {
		this.r36_banks1 = r36_banks1;
	}
	public BigDecimal getR36_individuals2() {
		return r36_individuals2;
	}
	public void setR36_individuals2(BigDecimal r36_individuals2) {
		this.r36_individuals2 = r36_individuals2;
	}
	public BigDecimal getR36_other1() {
		return r36_other1;
	}
	public void setR36_other1(BigDecimal r36_other1) {
		this.r36_other1 = r36_other1;
	}
	public BigDecimal getR36_banks2() {
		return r36_banks2;
	}
	public void setR36_banks2(BigDecimal r36_banks2) {
		this.r36_banks2 = r36_banks2;
	}
	public BigDecimal getR36_gov3() {
		return r36_gov3;
	}
	public void setR36_gov3(BigDecimal r36_gov3) {
		this.r36_gov3 = r36_gov3;
	}
	public BigDecimal getR36_others2() {
		return r36_others2;
	}
	public void setR36_others2(BigDecimal r36_others2) {
		this.r36_others2 = r36_others2;
	}
	public BigDecimal getR36_banks3() {
		return r36_banks3;
	}
	public void setR36_banks3(BigDecimal r36_banks3) {
		this.r36_banks3 = r36_banks3;
	}
	public BigDecimal getR36_gov4() {
		return r36_gov4;
	}
	public void setR36_gov4(BigDecimal r36_gov4) {
		this.r36_gov4 = r36_gov4;
	}
	public BigDecimal getR36_others3() {
		return r36_others3;
	}
	public void setR36_others3(BigDecimal r36_others3) {
		this.r36_others3 = r36_others3;
	}
	public BigDecimal getR36_foreign1() {
		return r36_foreign1;
	}
	public void setR36_foreign1(BigDecimal r36_foreign1) {
		this.r36_foreign1 = r36_foreign1;
	}
	public BigDecimal getR36_guarantees() {
		return r36_guarantees;
	}
	public void setR36_guarantees(BigDecimal r36_guarantees) {
		this.r36_guarantees = r36_guarantees;
	}
	public BigDecimal getR36_nbfi2() {
		return r36_nbfi2;
	}
	public void setR36_nbfi2(BigDecimal r36_nbfi2) {
		this.r36_nbfi2 = r36_nbfi2;
	}
	public BigDecimal getR36_interbank2() {
		return r36_interbank2;
	}
	public void setR36_interbank2(BigDecimal r36_interbank2) {
		this.r36_interbank2 = r36_interbank2;
	}
	public BigDecimal getR36_gov5() {
		return r36_gov5;
	}
	public void setR36_gov5(BigDecimal r36_gov5) {
		this.r36_gov5 = r36_gov5;
	}
	public BigDecimal getR36_corporate2() {
		return r36_corporate2;
	}
	public void setR36_corporate2(BigDecimal r36_corporate2) {
		this.r36_corporate2 = r36_corporate2;
	}
	public BigDecimal getR36_gre2() {
		return r36_gre2;
	}
	public void setR36_gre2(BigDecimal r36_gre2) {
		this.r36_gre2 = r36_gre2;
	}
	public BigDecimal getR36_individuals3() {
		return r36_individuals3;
	}
	public void setR36_individuals3(BigDecimal r36_individuals3) {
		this.r36_individuals3 = r36_individuals3;
	}
	public BigDecimal getR36_zero1() {
		return r36_zero1;
	}
	public void setR36_zero1(BigDecimal r36_zero1) {
		this.r36_zero1 = r36_zero1;
	}
	public BigDecimal getR36_three1() {
		return r36_three1;
	}
	public void setR36_three1(BigDecimal r36_three1) {
		this.r36_three1 = r36_three1;
	}
	public BigDecimal getR36_six1() {
		return r36_six1;
	}
	public void setR36_six1(BigDecimal r36_six1) {
		this.r36_six1 = r36_six1;
	}
	public BigDecimal getR36_oneyear1() {
		return r36_oneyear1;
	}
	public void setR36_oneyear1(BigDecimal r36_oneyear1) {
		this.r36_oneyear1 = r36_oneyear1;
	}
	public String getR36_empty() {
		return r36_empty;
	}
	public void setR36_empty(String r36_empty) {
		this.r36_empty = r36_empty;
	}
	public String getR37_product() {
		return r37_product;
	}
	public void setR37_product(String r37_product) {
		this.r37_product = r37_product;
	}
	public BigDecimal getR37_nbfi() {
		return r37_nbfi;
	}
	public void setR37_nbfi(BigDecimal r37_nbfi) {
		this.r37_nbfi = r37_nbfi;
	}
	public BigDecimal getR37_interbank() {
		return r37_interbank;
	}
	public void setR37_interbank(BigDecimal r37_interbank) {
		this.r37_interbank = r37_interbank;
	}
	public BigDecimal getR37_gov() {
		return r37_gov;
	}
	public void setR37_gov(BigDecimal r37_gov) {
		this.r37_gov = r37_gov;
	}
	public BigDecimal getR37_corporate() {
		return r37_corporate;
	}
	public void setR37_corporate(BigDecimal r37_corporate) {
		this.r37_corporate = r37_corporate;
	}
	public BigDecimal getR37_gre() {
		return r37_gre;
	}
	public void setR37_gre(BigDecimal r37_gre) {
		this.r37_gre = r37_gre;
	}
	public BigDecimal getR37_trade() {
		return r37_trade;
	}
	public void setR37_trade(BigDecimal r37_trade) {
		this.r37_trade = r37_trade;
	}
	public BigDecimal getR37_individuals() {
		return r37_individuals;
	}
	public void setR37_individuals(BigDecimal r37_individuals) {
		this.r37_individuals = r37_individuals;
	}
	public BigDecimal getR37_investment() {
		return r37_investment;
	}
	public void setR37_investment(BigDecimal r37_investment) {
		this.r37_investment = r37_investment;
	}
	public BigDecimal getR37_nbfi1() {
		return r37_nbfi1;
	}
	public void setR37_nbfi1(BigDecimal r37_nbfi1) {
		this.r37_nbfi1 = r37_nbfi1;
	}
	public BigDecimal getR37_interbank1() {
		return r37_interbank1;
	}
	public void setR37_interbank1(BigDecimal r37_interbank1) {
		this.r37_interbank1 = r37_interbank1;
	}
	public BigDecimal getR37_gov1() {
		return r37_gov1;
	}
	public void setR37_gov1(BigDecimal r37_gov1) {
		this.r37_gov1 = r37_gov1;
	}
	public BigDecimal getR37_corporate1() {
		return r37_corporate1;
	}
	public void setR37_corporate1(BigDecimal r37_corporate1) {
		this.r37_corporate1 = r37_corporate1;
	}
	public BigDecimal getR37_gre1() {
		return r37_gre1;
	}
	public void setR37_gre1(BigDecimal r37_gre1) {
		this.r37_gre1 = r37_gre1;
	}
	public BigDecimal getR37_trade1() {
		return r37_trade1;
	}
	public void setR37_trade1(BigDecimal r37_trade1) {
		this.r37_trade1 = r37_trade1;
	}
	public BigDecimal getR37_individuals1() {
		return r37_individuals1;
	}
	public void setR37_individuals1(BigDecimal r37_individuals1) {
		this.r37_individuals1 = r37_individuals1;
	}
	public BigDecimal getR37_investment1() {
		return r37_investment1;
	}
	public void setR37_investment1(BigDecimal r37_investment1) {
		this.r37_investment1 = r37_investment1;
	}
	public BigDecimal getR37_zer0() {
		return r37_zer0;
	}
	public void setR37_zer0(BigDecimal r37_zer0) {
		this.r37_zer0 = r37_zer0;
	}
	public BigDecimal getR37_three() {
		return r37_three;
	}
	public void setR37_three(BigDecimal r37_three) {
		this.r37_three = r37_three;
	}
	public BigDecimal getR37_six() {
		return r37_six;
	}
	public void setR37_six(BigDecimal r37_six) {
		this.r37_six = r37_six;
	}
	public BigDecimal getR37_oneyear() {
		return r37_oneyear;
	}
	public void setR37_oneyear(BigDecimal r37_oneyear) {
		this.r37_oneyear = r37_oneyear;
	}
	public BigDecimal getR37_foreign() {
		return r37_foreign;
	}
	public void setR37_foreign(BigDecimal r37_foreign) {
		this.r37_foreign = r37_foreign;
	}
	public BigDecimal getR37_banks() {
		return r37_banks;
	}
	public void setR37_banks(BigDecimal r37_banks) {
		this.r37_banks = r37_banks;
	}
	public BigDecimal getR37_gov2() {
		return r37_gov2;
	}
	public void setR37_gov2(BigDecimal r37_gov2) {
		this.r37_gov2 = r37_gov2;
	}
	public BigDecimal getR37_other() {
		return r37_other;
	}
	public void setR37_other(BigDecimal r37_other) {
		this.r37_other = r37_other;
	}
	public BigDecimal getR37_banks1() {
		return r37_banks1;
	}
	public void setR37_banks1(BigDecimal r37_banks1) {
		this.r37_banks1 = r37_banks1;
	}
	public BigDecimal getR37_individuals2() {
		return r37_individuals2;
	}
	public void setR37_individuals2(BigDecimal r37_individuals2) {
		this.r37_individuals2 = r37_individuals2;
	}
	public BigDecimal getR37_other1() {
		return r37_other1;
	}
	public void setR37_other1(BigDecimal r37_other1) {
		this.r37_other1 = r37_other1;
	}
	public BigDecimal getR37_banks2() {
		return r37_banks2;
	}
	public void setR37_banks2(BigDecimal r37_banks2) {
		this.r37_banks2 = r37_banks2;
	}
	public BigDecimal getR37_gov3() {
		return r37_gov3;
	}
	public void setR37_gov3(BigDecimal r37_gov3) {
		this.r37_gov3 = r37_gov3;
	}
	public BigDecimal getR37_others2() {
		return r37_others2;
	}
	public void setR37_others2(BigDecimal r37_others2) {
		this.r37_others2 = r37_others2;
	}
	public BigDecimal getR37_banks3() {
		return r37_banks3;
	}
	public void setR37_banks3(BigDecimal r37_banks3) {
		this.r37_banks3 = r37_banks3;
	}
	public BigDecimal getR37_gov4() {
		return r37_gov4;
	}
	public void setR37_gov4(BigDecimal r37_gov4) {
		this.r37_gov4 = r37_gov4;
	}
	public BigDecimal getR37_others3() {
		return r37_others3;
	}
	public void setR37_others3(BigDecimal r37_others3) {
		this.r37_others3 = r37_others3;
	}
	public BigDecimal getR37_foreign1() {
		return r37_foreign1;
	}
	public void setR37_foreign1(BigDecimal r37_foreign1) {
		this.r37_foreign1 = r37_foreign1;
	}
	public BigDecimal getR37_guarantees() {
		return r37_guarantees;
	}
	public void setR37_guarantees(BigDecimal r37_guarantees) {
		this.r37_guarantees = r37_guarantees;
	}
	public BigDecimal getR37_nbfi2() {
		return r37_nbfi2;
	}
	public void setR37_nbfi2(BigDecimal r37_nbfi2) {
		this.r37_nbfi2 = r37_nbfi2;
	}
	public BigDecimal getR37_interbank2() {
		return r37_interbank2;
	}
	public void setR37_interbank2(BigDecimal r37_interbank2) {
		this.r37_interbank2 = r37_interbank2;
	}
	public BigDecimal getR37_gov5() {
		return r37_gov5;
	}
	public void setR37_gov5(BigDecimal r37_gov5) {
		this.r37_gov5 = r37_gov5;
	}
	public BigDecimal getR37_corporate2() {
		return r37_corporate2;
	}
	public void setR37_corporate2(BigDecimal r37_corporate2) {
		this.r37_corporate2 = r37_corporate2;
	}
	public BigDecimal getR37_gre2() {
		return r37_gre2;
	}
	public void setR37_gre2(BigDecimal r37_gre2) {
		this.r37_gre2 = r37_gre2;
	}
	public BigDecimal getR37_individuals3() {
		return r37_individuals3;
	}
	public void setR37_individuals3(BigDecimal r37_individuals3) {
		this.r37_individuals3 = r37_individuals3;
	}
	public BigDecimal getR37_zero1() {
		return r37_zero1;
	}
	public void setR37_zero1(BigDecimal r37_zero1) {
		this.r37_zero1 = r37_zero1;
	}
	public BigDecimal getR37_three1() {
		return r37_three1;
	}
	public void setR37_three1(BigDecimal r37_three1) {
		this.r37_three1 = r37_three1;
	}
	public BigDecimal getR37_six1() {
		return r37_six1;
	}
	public void setR37_six1(BigDecimal r37_six1) {
		this.r37_six1 = r37_six1;
	}
	public BigDecimal getR37_oneyear1() {
		return r37_oneyear1;
	}
	public void setR37_oneyear1(BigDecimal r37_oneyear1) {
		this.r37_oneyear1 = r37_oneyear1;
	}
	public String getR37_empty() {
		return r37_empty;
	}
	public void setR37_empty(String r37_empty) {
		this.r37_empty = r37_empty;
	}
	public String getR38_product() {
		return r38_product;
	}
	public void setR38_product(String r38_product) {
		this.r38_product = r38_product;
	}
	public BigDecimal getR38_nbfi() {
		return r38_nbfi;
	}
	public void setR38_nbfi(BigDecimal r38_nbfi) {
		this.r38_nbfi = r38_nbfi;
	}
	public BigDecimal getR38_interbank() {
		return r38_interbank;
	}
	public void setR38_interbank(BigDecimal r38_interbank) {
		this.r38_interbank = r38_interbank;
	}
	public BigDecimal getR38_gov() {
		return r38_gov;
	}
	public void setR38_gov(BigDecimal r38_gov) {
		this.r38_gov = r38_gov;
	}
	public BigDecimal getR38_corporate() {
		return r38_corporate;
	}
	public void setR38_corporate(BigDecimal r38_corporate) {
		this.r38_corporate = r38_corporate;
	}
	public BigDecimal getR38_gre() {
		return r38_gre;
	}
	public void setR38_gre(BigDecimal r38_gre) {
		this.r38_gre = r38_gre;
	}
	public BigDecimal getR38_trade() {
		return r38_trade;
	}
	public void setR38_trade(BigDecimal r38_trade) {
		this.r38_trade = r38_trade;
	}
	public BigDecimal getR38_individuals() {
		return r38_individuals;
	}
	public void setR38_individuals(BigDecimal r38_individuals) {
		this.r38_individuals = r38_individuals;
	}
	public BigDecimal getR38_investment() {
		return r38_investment;
	}
	public void setR38_investment(BigDecimal r38_investment) {
		this.r38_investment = r38_investment;
	}
	public BigDecimal getR38_nbfi1() {
		return r38_nbfi1;
	}
	public void setR38_nbfi1(BigDecimal r38_nbfi1) {
		this.r38_nbfi1 = r38_nbfi1;
	}
	public BigDecimal getR38_interbank1() {
		return r38_interbank1;
	}
	public void setR38_interbank1(BigDecimal r38_interbank1) {
		this.r38_interbank1 = r38_interbank1;
	}
	public BigDecimal getR38_gov1() {
		return r38_gov1;
	}
	public void setR38_gov1(BigDecimal r38_gov1) {
		this.r38_gov1 = r38_gov1;
	}
	public BigDecimal getR38_corporate1() {
		return r38_corporate1;
	}
	public void setR38_corporate1(BigDecimal r38_corporate1) {
		this.r38_corporate1 = r38_corporate1;
	}
	public BigDecimal getR38_gre1() {
		return r38_gre1;
	}
	public void setR38_gre1(BigDecimal r38_gre1) {
		this.r38_gre1 = r38_gre1;
	}
	public BigDecimal getR38_trade1() {
		return r38_trade1;
	}
	public void setR38_trade1(BigDecimal r38_trade1) {
		this.r38_trade1 = r38_trade1;
	}
	public BigDecimal getR38_individuals1() {
		return r38_individuals1;
	}
	public void setR38_individuals1(BigDecimal r38_individuals1) {
		this.r38_individuals1 = r38_individuals1;
	}
	public BigDecimal getR38_investment1() {
		return r38_investment1;
	}
	public void setR38_investment1(BigDecimal r38_investment1) {
		this.r38_investment1 = r38_investment1;
	}
	public BigDecimal getR38_zer0() {
		return r38_zer0;
	}
	public void setR38_zer0(BigDecimal r38_zer0) {
		this.r38_zer0 = r38_zer0;
	}
	public BigDecimal getR38_three() {
		return r38_three;
	}
	public void setR38_three(BigDecimal r38_three) {
		this.r38_three = r38_three;
	}
	public BigDecimal getR38_six() {
		return r38_six;
	}
	public void setR38_six(BigDecimal r38_six) {
		this.r38_six = r38_six;
	}
	public BigDecimal getR38_oneyear() {
		return r38_oneyear;
	}
	public void setR38_oneyear(BigDecimal r38_oneyear) {
		this.r38_oneyear = r38_oneyear;
	}
	public BigDecimal getR38_foreign() {
		return r38_foreign;
	}
	public void setR38_foreign(BigDecimal r38_foreign) {
		this.r38_foreign = r38_foreign;
	}
	public BigDecimal getR38_banks() {
		return r38_banks;
	}
	public void setR38_banks(BigDecimal r38_banks) {
		this.r38_banks = r38_banks;
	}
	public BigDecimal getR38_gov2() {
		return r38_gov2;
	}
	public void setR38_gov2(BigDecimal r38_gov2) {
		this.r38_gov2 = r38_gov2;
	}
	public BigDecimal getR38_other() {
		return r38_other;
	}
	public void setR38_other(BigDecimal r38_other) {
		this.r38_other = r38_other;
	}
	public BigDecimal getR38_banks1() {
		return r38_banks1;
	}
	public void setR38_banks1(BigDecimal r38_banks1) {
		this.r38_banks1 = r38_banks1;
	}
	public BigDecimal getR38_individuals2() {
		return r38_individuals2;
	}
	public void setR38_individuals2(BigDecimal r38_individuals2) {
		this.r38_individuals2 = r38_individuals2;
	}
	public BigDecimal getR38_other1() {
		return r38_other1;
	}
	public void setR38_other1(BigDecimal r38_other1) {
		this.r38_other1 = r38_other1;
	}
	public BigDecimal getR38_banks2() {
		return r38_banks2;
	}
	public void setR38_banks2(BigDecimal r38_banks2) {
		this.r38_banks2 = r38_banks2;
	}
	public BigDecimal getR38_gov3() {
		return r38_gov3;
	}
	public void setR38_gov3(BigDecimal r38_gov3) {
		this.r38_gov3 = r38_gov3;
	}
	public BigDecimal getR38_others2() {
		return r38_others2;
	}
	public void setR38_others2(BigDecimal r38_others2) {
		this.r38_others2 = r38_others2;
	}
	public BigDecimal getR38_banks3() {
		return r38_banks3;
	}
	public void setR38_banks3(BigDecimal r38_banks3) {
		this.r38_banks3 = r38_banks3;
	}
	public BigDecimal getR38_gov4() {
		return r38_gov4;
	}
	public void setR38_gov4(BigDecimal r38_gov4) {
		this.r38_gov4 = r38_gov4;
	}
	public BigDecimal getR38_others3() {
		return r38_others3;
	}
	public void setR38_others3(BigDecimal r38_others3) {
		this.r38_others3 = r38_others3;
	}
	public BigDecimal getR38_foreign1() {
		return r38_foreign1;
	}
	public void setR38_foreign1(BigDecimal r38_foreign1) {
		this.r38_foreign1 = r38_foreign1;
	}
	public BigDecimal getR38_guarantees() {
		return r38_guarantees;
	}
	public void setR38_guarantees(BigDecimal r38_guarantees) {
		this.r38_guarantees = r38_guarantees;
	}
	public BigDecimal getR38_nbfi2() {
		return r38_nbfi2;
	}
	public void setR38_nbfi2(BigDecimal r38_nbfi2) {
		this.r38_nbfi2 = r38_nbfi2;
	}
	public BigDecimal getR38_interbank2() {
		return r38_interbank2;
	}
	public void setR38_interbank2(BigDecimal r38_interbank2) {
		this.r38_interbank2 = r38_interbank2;
	}
	public BigDecimal getR38_gov5() {
		return r38_gov5;
	}
	public void setR38_gov5(BigDecimal r38_gov5) {
		this.r38_gov5 = r38_gov5;
	}
	public BigDecimal getR38_corporate2() {
		return r38_corporate2;
	}
	public void setR38_corporate2(BigDecimal r38_corporate2) {
		this.r38_corporate2 = r38_corporate2;
	}
	public BigDecimal getR38_gre2() {
		return r38_gre2;
	}
	public void setR38_gre2(BigDecimal r38_gre2) {
		this.r38_gre2 = r38_gre2;
	}
	public BigDecimal getR38_individuals3() {
		return r38_individuals3;
	}
	public void setR38_individuals3(BigDecimal r38_individuals3) {
		this.r38_individuals3 = r38_individuals3;
	}
	public BigDecimal getR38_zero1() {
		return r38_zero1;
	}
	public void setR38_zero1(BigDecimal r38_zero1) {
		this.r38_zero1 = r38_zero1;
	}
	public BigDecimal getR38_three1() {
		return r38_three1;
	}
	public void setR38_three1(BigDecimal r38_three1) {
		this.r38_three1 = r38_three1;
	}
	public BigDecimal getR38_six1() {
		return r38_six1;
	}
	public void setR38_six1(BigDecimal r38_six1) {
		this.r38_six1 = r38_six1;
	}
	public BigDecimal getR38_oneyear1() {
		return r38_oneyear1;
	}
	public void setR38_oneyear1(BigDecimal r38_oneyear1) {
		this.r38_oneyear1 = r38_oneyear1;
	}
	public String getR38_empty() {
		return r38_empty;
	}
	public void setR38_empty(String r38_empty) {
		this.r38_empty = r38_empty;
	}
	public String getR39_product() {
		return r39_product;
	}
	public void setR39_product(String r39_product) {
		this.r39_product = r39_product;
	}
	public BigDecimal getR39_nbfi() {
		return r39_nbfi;
	}
	public void setR39_nbfi(BigDecimal r39_nbfi) {
		this.r39_nbfi = r39_nbfi;
	}
	public BigDecimal getR39_interbank() {
		return r39_interbank;
	}
	public void setR39_interbank(BigDecimal r39_interbank) {
		this.r39_interbank = r39_interbank;
	}
	public BigDecimal getR39_gov() {
		return r39_gov;
	}
	public void setR39_gov(BigDecimal r39_gov) {
		this.r39_gov = r39_gov;
	}
	public BigDecimal getR39_corporate() {
		return r39_corporate;
	}
	public void setR39_corporate(BigDecimal r39_corporate) {
		this.r39_corporate = r39_corporate;
	}
	public BigDecimal getR39_gre() {
		return r39_gre;
	}
	public void setR39_gre(BigDecimal r39_gre) {
		this.r39_gre = r39_gre;
	}
	public BigDecimal getR39_trade() {
		return r39_trade;
	}
	public void setR39_trade(BigDecimal r39_trade) {
		this.r39_trade = r39_trade;
	}
	public BigDecimal getR39_individuals() {
		return r39_individuals;
	}
	public void setR39_individuals(BigDecimal r39_individuals) {
		this.r39_individuals = r39_individuals;
	}
	public BigDecimal getR39_investment() {
		return r39_investment;
	}
	public void setR39_investment(BigDecimal r39_investment) {
		this.r39_investment = r39_investment;
	}
	public BigDecimal getR39_nbfi1() {
		return r39_nbfi1;
	}
	public void setR39_nbfi1(BigDecimal r39_nbfi1) {
		this.r39_nbfi1 = r39_nbfi1;
	}
	public BigDecimal getR39_interbank1() {
		return r39_interbank1;
	}
	public void setR39_interbank1(BigDecimal r39_interbank1) {
		this.r39_interbank1 = r39_interbank1;
	}
	public BigDecimal getR39_gov1() {
		return r39_gov1;
	}
	public void setR39_gov1(BigDecimal r39_gov1) {
		this.r39_gov1 = r39_gov1;
	}
	public BigDecimal getR39_corporate1() {
		return r39_corporate1;
	}
	public void setR39_corporate1(BigDecimal r39_corporate1) {
		this.r39_corporate1 = r39_corporate1;
	}
	public BigDecimal getR39_gre1() {
		return r39_gre1;
	}
	public void setR39_gre1(BigDecimal r39_gre1) {
		this.r39_gre1 = r39_gre1;
	}
	public BigDecimal getR39_trade1() {
		return r39_trade1;
	}
	public void setR39_trade1(BigDecimal r39_trade1) {
		this.r39_trade1 = r39_trade1;
	}
	public BigDecimal getR39_individuals1() {
		return r39_individuals1;
	}
	public void setR39_individuals1(BigDecimal r39_individuals1) {
		this.r39_individuals1 = r39_individuals1;
	}
	public BigDecimal getR39_investment1() {
		return r39_investment1;
	}
	public void setR39_investment1(BigDecimal r39_investment1) {
		this.r39_investment1 = r39_investment1;
	}
	public BigDecimal getR39_zer0() {
		return r39_zer0;
	}
	public void setR39_zer0(BigDecimal r39_zer0) {
		this.r39_zer0 = r39_zer0;
	}
	public BigDecimal getR39_three() {
		return r39_three;
	}
	public void setR39_three(BigDecimal r39_three) {
		this.r39_three = r39_three;
	}
	public BigDecimal getR39_six() {
		return r39_six;
	}
	public void setR39_six(BigDecimal r39_six) {
		this.r39_six = r39_six;
	}
	public BigDecimal getR39_oneyear() {
		return r39_oneyear;
	}
	public void setR39_oneyear(BigDecimal r39_oneyear) {
		this.r39_oneyear = r39_oneyear;
	}
	public BigDecimal getR39_foreign() {
		return r39_foreign;
	}
	public void setR39_foreign(BigDecimal r39_foreign) {
		this.r39_foreign = r39_foreign;
	}
	public BigDecimal getR39_banks() {
		return r39_banks;
	}
	public void setR39_banks(BigDecimal r39_banks) {
		this.r39_banks = r39_banks;
	}
	public BigDecimal getR39_gov2() {
		return r39_gov2;
	}
	public void setR39_gov2(BigDecimal r39_gov2) {
		this.r39_gov2 = r39_gov2;
	}
	public BigDecimal getR39_other() {
		return r39_other;
	}
	public void setR39_other(BigDecimal r39_other) {
		this.r39_other = r39_other;
	}
	public BigDecimal getR39_banks1() {
		return r39_banks1;
	}
	public void setR39_banks1(BigDecimal r39_banks1) {
		this.r39_banks1 = r39_banks1;
	}
	public BigDecimal getR39_individuals2() {
		return r39_individuals2;
	}
	public void setR39_individuals2(BigDecimal r39_individuals2) {
		this.r39_individuals2 = r39_individuals2;
	}
	public BigDecimal getR39_other1() {
		return r39_other1;
	}
	public void setR39_other1(BigDecimal r39_other1) {
		this.r39_other1 = r39_other1;
	}
	public BigDecimal getR39_banks2() {
		return r39_banks2;
	}
	public void setR39_banks2(BigDecimal r39_banks2) {
		this.r39_banks2 = r39_banks2;
	}
	public BigDecimal getR39_gov3() {
		return r39_gov3;
	}
	public void setR39_gov3(BigDecimal r39_gov3) {
		this.r39_gov3 = r39_gov3;
	}
	public BigDecimal getR39_others2() {
		return r39_others2;
	}
	public void setR39_others2(BigDecimal r39_others2) {
		this.r39_others2 = r39_others2;
	}
	public BigDecimal getR39_banks3() {
		return r39_banks3;
	}
	public void setR39_banks3(BigDecimal r39_banks3) {
		this.r39_banks3 = r39_banks3;
	}
	public BigDecimal getR39_gov4() {
		return r39_gov4;
	}
	public void setR39_gov4(BigDecimal r39_gov4) {
		this.r39_gov4 = r39_gov4;
	}
	public BigDecimal getR39_others3() {
		return r39_others3;
	}
	public void setR39_others3(BigDecimal r39_others3) {
		this.r39_others3 = r39_others3;
	}
	public BigDecimal getR39_foreign1() {
		return r39_foreign1;
	}
	public void setR39_foreign1(BigDecimal r39_foreign1) {
		this.r39_foreign1 = r39_foreign1;
	}
	public BigDecimal getR39_guarantees() {
		return r39_guarantees;
	}
	public void setR39_guarantees(BigDecimal r39_guarantees) {
		this.r39_guarantees = r39_guarantees;
	}
	public BigDecimal getR39_nbfi2() {
		return r39_nbfi2;
	}
	public void setR39_nbfi2(BigDecimal r39_nbfi2) {
		this.r39_nbfi2 = r39_nbfi2;
	}
	public BigDecimal getR39_interbank2() {
		return r39_interbank2;
	}
	public void setR39_interbank2(BigDecimal r39_interbank2) {
		this.r39_interbank2 = r39_interbank2;
	}
	public BigDecimal getR39_gov5() {
		return r39_gov5;
	}
	public void setR39_gov5(BigDecimal r39_gov5) {
		this.r39_gov5 = r39_gov5;
	}
	public BigDecimal getR39_corporate2() {
		return r39_corporate2;
	}
	public void setR39_corporate2(BigDecimal r39_corporate2) {
		this.r39_corporate2 = r39_corporate2;
	}
	public BigDecimal getR39_gre2() {
		return r39_gre2;
	}
	public void setR39_gre2(BigDecimal r39_gre2) {
		this.r39_gre2 = r39_gre2;
	}
	public BigDecimal getR39_individuals3() {
		return r39_individuals3;
	}
	public void setR39_individuals3(BigDecimal r39_individuals3) {
		this.r39_individuals3 = r39_individuals3;
	}
	public BigDecimal getR39_zero1() {
		return r39_zero1;
	}
	public void setR39_zero1(BigDecimal r39_zero1) {
		this.r39_zero1 = r39_zero1;
	}
	public BigDecimal getR39_three1() {
		return r39_three1;
	}
	public void setR39_three1(BigDecimal r39_three1) {
		this.r39_three1 = r39_three1;
	}
	public BigDecimal getR39_six1() {
		return r39_six1;
	}
	public void setR39_six1(BigDecimal r39_six1) {
		this.r39_six1 = r39_six1;
	}
	public BigDecimal getR39_oneyear1() {
		return r39_oneyear1;
	}
	public void setR39_oneyear1(BigDecimal r39_oneyear1) {
		this.r39_oneyear1 = r39_oneyear1;
	}
	public String getR39_empty() {
		return r39_empty;
	}
	public void setR39_empty(String r39_empty) {
		this.r39_empty = r39_empty;
	}
	public String getR40_product() {
		return r40_product;
	}
	public void setR40_product(String r40_product) {
		this.r40_product = r40_product;
	}
	public BigDecimal getR40_nbfi() {
		return r40_nbfi;
	}
	public void setR40_nbfi(BigDecimal r40_nbfi) {
		this.r40_nbfi = r40_nbfi;
	}
	public BigDecimal getR40_interbank() {
		return r40_interbank;
	}
	public void setR40_interbank(BigDecimal r40_interbank) {
		this.r40_interbank = r40_interbank;
	}
	public BigDecimal getR40_gov() {
		return r40_gov;
	}
	public void setR40_gov(BigDecimal r40_gov) {
		this.r40_gov = r40_gov;
	}
	public BigDecimal getR40_corporate() {
		return r40_corporate;
	}
	public void setR40_corporate(BigDecimal r40_corporate) {
		this.r40_corporate = r40_corporate;
	}
	public BigDecimal getR40_gre() {
		return r40_gre;
	}
	public void setR40_gre(BigDecimal r40_gre) {
		this.r40_gre = r40_gre;
	}
	public BigDecimal getR40_trade() {
		return r40_trade;
	}
	public void setR40_trade(BigDecimal r40_trade) {
		this.r40_trade = r40_trade;
	}
	public BigDecimal getR40_individuals() {
		return r40_individuals;
	}
	public void setR40_individuals(BigDecimal r40_individuals) {
		this.r40_individuals = r40_individuals;
	}
	public BigDecimal getR40_investment() {
		return r40_investment;
	}
	public void setR40_investment(BigDecimal r40_investment) {
		this.r40_investment = r40_investment;
	}
	public BigDecimal getR40_nbfi1() {
		return r40_nbfi1;
	}
	public void setR40_nbfi1(BigDecimal r40_nbfi1) {
		this.r40_nbfi1 = r40_nbfi1;
	}
	public BigDecimal getR40_interbank1() {
		return r40_interbank1;
	}
	public void setR40_interbank1(BigDecimal r40_interbank1) {
		this.r40_interbank1 = r40_interbank1;
	}
	public BigDecimal getR40_gov1() {
		return r40_gov1;
	}
	public void setR40_gov1(BigDecimal r40_gov1) {
		this.r40_gov1 = r40_gov1;
	}
	public BigDecimal getR40_corporate1() {
		return r40_corporate1;
	}
	public void setR40_corporate1(BigDecimal r40_corporate1) {
		this.r40_corporate1 = r40_corporate1;
	}
	public BigDecimal getR40_gre1() {
		return r40_gre1;
	}
	public void setR40_gre1(BigDecimal r40_gre1) {
		this.r40_gre1 = r40_gre1;
	}
	public BigDecimal getR40_trade1() {
		return r40_trade1;
	}
	public void setR40_trade1(BigDecimal r40_trade1) {
		this.r40_trade1 = r40_trade1;
	}
	public BigDecimal getR40_individuals1() {
		return r40_individuals1;
	}
	public void setR40_individuals1(BigDecimal r40_individuals1) {
		this.r40_individuals1 = r40_individuals1;
	}
	public BigDecimal getR40_investment1() {
		return r40_investment1;
	}
	public void setR40_investment1(BigDecimal r40_investment1) {
		this.r40_investment1 = r40_investment1;
	}
	public BigDecimal getR40_zer0() {
		return r40_zer0;
	}
	public void setR40_zer0(BigDecimal r40_zer0) {
		this.r40_zer0 = r40_zer0;
	}
	public BigDecimal getR40_three() {
		return r40_three;
	}
	public void setR40_three(BigDecimal r40_three) {
		this.r40_three = r40_three;
	}
	public BigDecimal getR40_six() {
		return r40_six;
	}
	public void setR40_six(BigDecimal r40_six) {
		this.r40_six = r40_six;
	}
	public BigDecimal getR40_oneyear() {
		return r40_oneyear;
	}
	public void setR40_oneyear(BigDecimal r40_oneyear) {
		this.r40_oneyear = r40_oneyear;
	}
	public BigDecimal getR40_foreign() {
		return r40_foreign;
	}
	public void setR40_foreign(BigDecimal r40_foreign) {
		this.r40_foreign = r40_foreign;
	}
	public BigDecimal getR40_banks() {
		return r40_banks;
	}
	public void setR40_banks(BigDecimal r40_banks) {
		this.r40_banks = r40_banks;
	}
	public BigDecimal getR40_gov2() {
		return r40_gov2;
	}
	public void setR40_gov2(BigDecimal r40_gov2) {
		this.r40_gov2 = r40_gov2;
	}
	public BigDecimal getR40_other() {
		return r40_other;
	}
	public void setR40_other(BigDecimal r40_other) {
		this.r40_other = r40_other;
	}
	public BigDecimal getR40_banks1() {
		return r40_banks1;
	}
	public void setR40_banks1(BigDecimal r40_banks1) {
		this.r40_banks1 = r40_banks1;
	}
	public BigDecimal getR40_individuals2() {
		return r40_individuals2;
	}
	public void setR40_individuals2(BigDecimal r40_individuals2) {
		this.r40_individuals2 = r40_individuals2;
	}
	public BigDecimal getR40_other1() {
		return r40_other1;
	}
	public void setR40_other1(BigDecimal r40_other1) {
		this.r40_other1 = r40_other1;
	}
	public BigDecimal getR40_banks2() {
		return r40_banks2;
	}
	public void setR40_banks2(BigDecimal r40_banks2) {
		this.r40_banks2 = r40_banks2;
	}
	public BigDecimal getR40_gov3() {
		return r40_gov3;
	}
	public void setR40_gov3(BigDecimal r40_gov3) {
		this.r40_gov3 = r40_gov3;
	}
	public BigDecimal getR40_others2() {
		return r40_others2;
	}
	public void setR40_others2(BigDecimal r40_others2) {
		this.r40_others2 = r40_others2;
	}
	public BigDecimal getR40_banks3() {
		return r40_banks3;
	}
	public void setR40_banks3(BigDecimal r40_banks3) {
		this.r40_banks3 = r40_banks3;
	}
	public BigDecimal getR40_gov4() {
		return r40_gov4;
	}
	public void setR40_gov4(BigDecimal r40_gov4) {
		this.r40_gov4 = r40_gov4;
	}
	public BigDecimal getR40_others3() {
		return r40_others3;
	}
	public void setR40_others3(BigDecimal r40_others3) {
		this.r40_others3 = r40_others3;
	}
	public BigDecimal getR40_foreign1() {
		return r40_foreign1;
	}
	public void setR40_foreign1(BigDecimal r40_foreign1) {
		this.r40_foreign1 = r40_foreign1;
	}
	public BigDecimal getR40_guarantees() {
		return r40_guarantees;
	}
	public void setR40_guarantees(BigDecimal r40_guarantees) {
		this.r40_guarantees = r40_guarantees;
	}
	public BigDecimal getR40_nbfi2() {
		return r40_nbfi2;
	}
	public void setR40_nbfi2(BigDecimal r40_nbfi2) {
		this.r40_nbfi2 = r40_nbfi2;
	}
	public BigDecimal getR40_interbank2() {
		return r40_interbank2;
	}
	public void setR40_interbank2(BigDecimal r40_interbank2) {
		this.r40_interbank2 = r40_interbank2;
	}
	public BigDecimal getR40_gov5() {
		return r40_gov5;
	}
	public void setR40_gov5(BigDecimal r40_gov5) {
		this.r40_gov5 = r40_gov5;
	}
	public BigDecimal getR40_corporate2() {
		return r40_corporate2;
	}
	public void setR40_corporate2(BigDecimal r40_corporate2) {
		this.r40_corporate2 = r40_corporate2;
	}
	public BigDecimal getR40_gre2() {
		return r40_gre2;
	}
	public void setR40_gre2(BigDecimal r40_gre2) {
		this.r40_gre2 = r40_gre2;
	}
	public BigDecimal getR40_individuals3() {
		return r40_individuals3;
	}
	public void setR40_individuals3(BigDecimal r40_individuals3) {
		this.r40_individuals3 = r40_individuals3;
	}
	public BigDecimal getR40_zero1() {
		return r40_zero1;
	}
	public void setR40_zero1(BigDecimal r40_zero1) {
		this.r40_zero1 = r40_zero1;
	}
	public BigDecimal getR40_three1() {
		return r40_three1;
	}
	public void setR40_three1(BigDecimal r40_three1) {
		this.r40_three1 = r40_three1;
	}
	public BigDecimal getR40_six1() {
		return r40_six1;
	}
	public void setR40_six1(BigDecimal r40_six1) {
		this.r40_six1 = r40_six1;
	}
	public BigDecimal getR40_oneyear1() {
		return r40_oneyear1;
	}
	public void setR40_oneyear1(BigDecimal r40_oneyear1) {
		this.r40_oneyear1 = r40_oneyear1;
	}
	public String getR40_empty() {
		return r40_empty;
	}
	public void setR40_empty(String r40_empty) {
		this.r40_empty = r40_empty;
	}
	public String getR41_product() {
		return r41_product;
	}
	public void setR41_product(String r41_product) {
		this.r41_product = r41_product;
	}
	public BigDecimal getR41_nbfi() {
		return r41_nbfi;
	}
	public void setR41_nbfi(BigDecimal r41_nbfi) {
		this.r41_nbfi = r41_nbfi;
	}
	public BigDecimal getR41_interbank() {
		return r41_interbank;
	}
	public void setR41_interbank(BigDecimal r41_interbank) {
		this.r41_interbank = r41_interbank;
	}
	public BigDecimal getR41_gov() {
		return r41_gov;
	}
	public void setR41_gov(BigDecimal r41_gov) {
		this.r41_gov = r41_gov;
	}
	public BigDecimal getR41_corporate() {
		return r41_corporate;
	}
	public void setR41_corporate(BigDecimal r41_corporate) {
		this.r41_corporate = r41_corporate;
	}
	public BigDecimal getR41_gre() {
		return r41_gre;
	}
	public void setR41_gre(BigDecimal r41_gre) {
		this.r41_gre = r41_gre;
	}
	public BigDecimal getR41_trade() {
		return r41_trade;
	}
	public void setR41_trade(BigDecimal r41_trade) {
		this.r41_trade = r41_trade;
	}
	public BigDecimal getR41_individuals() {
		return r41_individuals;
	}
	public void setR41_individuals(BigDecimal r41_individuals) {
		this.r41_individuals = r41_individuals;
	}
	public BigDecimal getR41_investment() {
		return r41_investment;
	}
	public void setR41_investment(BigDecimal r41_investment) {
		this.r41_investment = r41_investment;
	}
	public BigDecimal getR41_nbfi1() {
		return r41_nbfi1;
	}
	public void setR41_nbfi1(BigDecimal r41_nbfi1) {
		this.r41_nbfi1 = r41_nbfi1;
	}
	public BigDecimal getR41_interbank1() {
		return r41_interbank1;
	}
	public void setR41_interbank1(BigDecimal r41_interbank1) {
		this.r41_interbank1 = r41_interbank1;
	}
	public BigDecimal getR41_gov1() {
		return r41_gov1;
	}
	public void setR41_gov1(BigDecimal r41_gov1) {
		this.r41_gov1 = r41_gov1;
	}
	public BigDecimal getR41_corporate1() {
		return r41_corporate1;
	}
	public void setR41_corporate1(BigDecimal r41_corporate1) {
		this.r41_corporate1 = r41_corporate1;
	}
	public BigDecimal getR41_gre1() {
		return r41_gre1;
	}
	public void setR41_gre1(BigDecimal r41_gre1) {
		this.r41_gre1 = r41_gre1;
	}
	public BigDecimal getR41_trade1() {
		return r41_trade1;
	}
	public void setR41_trade1(BigDecimal r41_trade1) {
		this.r41_trade1 = r41_trade1;
	}
	public BigDecimal getR41_individuals1() {
		return r41_individuals1;
	}
	public void setR41_individuals1(BigDecimal r41_individuals1) {
		this.r41_individuals1 = r41_individuals1;
	}
	public BigDecimal getR41_investment1() {
		return r41_investment1;
	}
	public void setR41_investment1(BigDecimal r41_investment1) {
		this.r41_investment1 = r41_investment1;
	}
	public BigDecimal getR41_zer0() {
		return r41_zer0;
	}
	public void setR41_zer0(BigDecimal r41_zer0) {
		this.r41_zer0 = r41_zer0;
	}
	public BigDecimal getR41_three() {
		return r41_three;
	}
	public void setR41_three(BigDecimal r41_three) {
		this.r41_three = r41_three;
	}
	public BigDecimal getR41_six() {
		return r41_six;
	}
	public void setR41_six(BigDecimal r41_six) {
		this.r41_six = r41_six;
	}
	public BigDecimal getR41_oneyear() {
		return r41_oneyear;
	}
	public void setR41_oneyear(BigDecimal r41_oneyear) {
		this.r41_oneyear = r41_oneyear;
	}
	public BigDecimal getR41_foreign() {
		return r41_foreign;
	}
	public void setR41_foreign(BigDecimal r41_foreign) {
		this.r41_foreign = r41_foreign;
	}
	public BigDecimal getR41_banks() {
		return r41_banks;
	}
	public void setR41_banks(BigDecimal r41_banks) {
		this.r41_banks = r41_banks;
	}
	public BigDecimal getR41_gov2() {
		return r41_gov2;
	}
	public void setR41_gov2(BigDecimal r41_gov2) {
		this.r41_gov2 = r41_gov2;
	}
	public BigDecimal getR41_other() {
		return r41_other;
	}
	public void setR41_other(BigDecimal r41_other) {
		this.r41_other = r41_other;
	}
	public BigDecimal getR41_banks1() {
		return r41_banks1;
	}
	public void setR41_banks1(BigDecimal r41_banks1) {
		this.r41_banks1 = r41_banks1;
	}
	public BigDecimal getR41_individuals2() {
		return r41_individuals2;
	}
	public void setR41_individuals2(BigDecimal r41_individuals2) {
		this.r41_individuals2 = r41_individuals2;
	}
	public BigDecimal getR41_other1() {
		return r41_other1;
	}
	public void setR41_other1(BigDecimal r41_other1) {
		this.r41_other1 = r41_other1;
	}
	public BigDecimal getR41_banks2() {
		return r41_banks2;
	}
	public void setR41_banks2(BigDecimal r41_banks2) {
		this.r41_banks2 = r41_banks2;
	}
	public BigDecimal getR41_gov3() {
		return r41_gov3;
	}
	public void setR41_gov3(BigDecimal r41_gov3) {
		this.r41_gov3 = r41_gov3;
	}
	public BigDecimal getR41_others2() {
		return r41_others2;
	}
	public void setR41_others2(BigDecimal r41_others2) {
		this.r41_others2 = r41_others2;
	}
	public BigDecimal getR41_banks3() {
		return r41_banks3;
	}
	public void setR41_banks3(BigDecimal r41_banks3) {
		this.r41_banks3 = r41_banks3;
	}
	public BigDecimal getR41_gov4() {
		return r41_gov4;
	}
	public void setR41_gov4(BigDecimal r41_gov4) {
		this.r41_gov4 = r41_gov4;
	}
	public BigDecimal getR41_others3() {
		return r41_others3;
	}
	public void setR41_others3(BigDecimal r41_others3) {
		this.r41_others3 = r41_others3;
	}
	public BigDecimal getR41_foreign1() {
		return r41_foreign1;
	}
	public void setR41_foreign1(BigDecimal r41_foreign1) {
		this.r41_foreign1 = r41_foreign1;
	}
	public BigDecimal getR41_guarantees() {
		return r41_guarantees;
	}
	public void setR41_guarantees(BigDecimal r41_guarantees) {
		this.r41_guarantees = r41_guarantees;
	}
	public BigDecimal getR41_nbfi2() {
		return r41_nbfi2;
	}
	public void setR41_nbfi2(BigDecimal r41_nbfi2) {
		this.r41_nbfi2 = r41_nbfi2;
	}
	public BigDecimal getR41_interbank2() {
		return r41_interbank2;
	}
	public void setR41_interbank2(BigDecimal r41_interbank2) {
		this.r41_interbank2 = r41_interbank2;
	}
	public BigDecimal getR41_gov5() {
		return r41_gov5;
	}
	public void setR41_gov5(BigDecimal r41_gov5) {
		this.r41_gov5 = r41_gov5;
	}
	public BigDecimal getR41_corporate2() {
		return r41_corporate2;
	}
	public void setR41_corporate2(BigDecimal r41_corporate2) {
		this.r41_corporate2 = r41_corporate2;
	}
	public BigDecimal getR41_gre2() {
		return r41_gre2;
	}
	public void setR41_gre2(BigDecimal r41_gre2) {
		this.r41_gre2 = r41_gre2;
	}
	public BigDecimal getR41_individuals3() {
		return r41_individuals3;
	}
	public void setR41_individuals3(BigDecimal r41_individuals3) {
		this.r41_individuals3 = r41_individuals3;
	}
	public BigDecimal getR41_zero1() {
		return r41_zero1;
	}
	public void setR41_zero1(BigDecimal r41_zero1) {
		this.r41_zero1 = r41_zero1;
	}
	public BigDecimal getR41_three1() {
		return r41_three1;
	}
	public void setR41_three1(BigDecimal r41_three1) {
		this.r41_three1 = r41_three1;
	}
	public BigDecimal getR41_six1() {
		return r41_six1;
	}
	public void setR41_six1(BigDecimal r41_six1) {
		this.r41_six1 = r41_six1;
	}
	public BigDecimal getR41_oneyear1() {
		return r41_oneyear1;
	}
	public void setR41_oneyear1(BigDecimal r41_oneyear1) {
		this.r41_oneyear1 = r41_oneyear1;
	}
	public String getR41_empty() {
		return r41_empty;
	}
	public void setR41_empty(String r41_empty) {
		this.r41_empty = r41_empty;
	}
	public String getR42_product() {
		return r42_product;
	}
	public void setR42_product(String r42_product) {
		this.r42_product = r42_product;
	}
	public BigDecimal getR42_nbfi() {
		return r42_nbfi;
	}
	public void setR42_nbfi(BigDecimal r42_nbfi) {
		this.r42_nbfi = r42_nbfi;
	}
	public BigDecimal getR42_interbank() {
		return r42_interbank;
	}
	public void setR42_interbank(BigDecimal r42_interbank) {
		this.r42_interbank = r42_interbank;
	}
	public BigDecimal getR42_gov() {
		return r42_gov;
	}
	public void setR42_gov(BigDecimal r42_gov) {
		this.r42_gov = r42_gov;
	}
	public BigDecimal getR42_corporate() {
		return r42_corporate;
	}
	public void setR42_corporate(BigDecimal r42_corporate) {
		this.r42_corporate = r42_corporate;
	}
	public BigDecimal getR42_gre() {
		return r42_gre;
	}
	public void setR42_gre(BigDecimal r42_gre) {
		this.r42_gre = r42_gre;
	}
	public BigDecimal getR42_trade() {
		return r42_trade;
	}
	public void setR42_trade(BigDecimal r42_trade) {
		this.r42_trade = r42_trade;
	}
	public BigDecimal getR42_individuals() {
		return r42_individuals;
	}
	public void setR42_individuals(BigDecimal r42_individuals) {
		this.r42_individuals = r42_individuals;
	}
	public BigDecimal getR42_investment() {
		return r42_investment;
	}
	public void setR42_investment(BigDecimal r42_investment) {
		this.r42_investment = r42_investment;
	}
	public BigDecimal getR42_nbfi1() {
		return r42_nbfi1;
	}
	public void setR42_nbfi1(BigDecimal r42_nbfi1) {
		this.r42_nbfi1 = r42_nbfi1;
	}
	public BigDecimal getR42_interbank1() {
		return r42_interbank1;
	}
	public void setR42_interbank1(BigDecimal r42_interbank1) {
		this.r42_interbank1 = r42_interbank1;
	}
	public BigDecimal getR42_gov1() {
		return r42_gov1;
	}
	public void setR42_gov1(BigDecimal r42_gov1) {
		this.r42_gov1 = r42_gov1;
	}
	public BigDecimal getR42_corporate1() {
		return r42_corporate1;
	}
	public void setR42_corporate1(BigDecimal r42_corporate1) {
		this.r42_corporate1 = r42_corporate1;
	}
	public BigDecimal getR42_gre1() {
		return r42_gre1;
	}
	public void setR42_gre1(BigDecimal r42_gre1) {
		this.r42_gre1 = r42_gre1;
	}
	public BigDecimal getR42_trade1() {
		return r42_trade1;
	}
	public void setR42_trade1(BigDecimal r42_trade1) {
		this.r42_trade1 = r42_trade1;
	}
	public BigDecimal getR42_individuals1() {
		return r42_individuals1;
	}
	public void setR42_individuals1(BigDecimal r42_individuals1) {
		this.r42_individuals1 = r42_individuals1;
	}
	public BigDecimal getR42_investment1() {
		return r42_investment1;
	}
	public void setR42_investment1(BigDecimal r42_investment1) {
		this.r42_investment1 = r42_investment1;
	}
	public BigDecimal getR42_zer0() {
		return r42_zer0;
	}
	public void setR42_zer0(BigDecimal r42_zer0) {
		this.r42_zer0 = r42_zer0;
	}
	public BigDecimal getR42_three() {
		return r42_three;
	}
	public void setR42_three(BigDecimal r42_three) {
		this.r42_three = r42_three;
	}
	public BigDecimal getR42_six() {
		return r42_six;
	}
	public void setR42_six(BigDecimal r42_six) {
		this.r42_six = r42_six;
	}
	public BigDecimal getR42_oneyear() {
		return r42_oneyear;
	}
	public void setR42_oneyear(BigDecimal r42_oneyear) {
		this.r42_oneyear = r42_oneyear;
	}
	public BigDecimal getR42_foreign() {
		return r42_foreign;
	}
	public void setR42_foreign(BigDecimal r42_foreign) {
		this.r42_foreign = r42_foreign;
	}
	public BigDecimal getR42_banks() {
		return r42_banks;
	}
	public void setR42_banks(BigDecimal r42_banks) {
		this.r42_banks = r42_banks;
	}
	public BigDecimal getR42_gov2() {
		return r42_gov2;
	}
	public void setR42_gov2(BigDecimal r42_gov2) {
		this.r42_gov2 = r42_gov2;
	}
	public BigDecimal getR42_other() {
		return r42_other;
	}
	public void setR42_other(BigDecimal r42_other) {
		this.r42_other = r42_other;
	}
	public BigDecimal getR42_banks1() {
		return r42_banks1;
	}
	public void setR42_banks1(BigDecimal r42_banks1) {
		this.r42_banks1 = r42_banks1;
	}
	public BigDecimal getR42_individuals2() {
		return r42_individuals2;
	}
	public void setR42_individuals2(BigDecimal r42_individuals2) {
		this.r42_individuals2 = r42_individuals2;
	}
	public BigDecimal getR42_other1() {
		return r42_other1;
	}
	public void setR42_other1(BigDecimal r42_other1) {
		this.r42_other1 = r42_other1;
	}
	public BigDecimal getR42_banks2() {
		return r42_banks2;
	}
	public void setR42_banks2(BigDecimal r42_banks2) {
		this.r42_banks2 = r42_banks2;
	}
	public BigDecimal getR42_gov3() {
		return r42_gov3;
	}
	public void setR42_gov3(BigDecimal r42_gov3) {
		this.r42_gov3 = r42_gov3;
	}
	public BigDecimal getR42_others2() {
		return r42_others2;
	}
	public void setR42_others2(BigDecimal r42_others2) {
		this.r42_others2 = r42_others2;
	}
	public BigDecimal getR42_banks3() {
		return r42_banks3;
	}
	public void setR42_banks3(BigDecimal r42_banks3) {
		this.r42_banks3 = r42_banks3;
	}
	public BigDecimal getR42_gov4() {
		return r42_gov4;
	}
	public void setR42_gov4(BigDecimal r42_gov4) {
		this.r42_gov4 = r42_gov4;
	}
	public BigDecimal getR42_others3() {
		return r42_others3;
	}
	public void setR42_others3(BigDecimal r42_others3) {
		this.r42_others3 = r42_others3;
	}
	public BigDecimal getR42_foreign1() {
		return r42_foreign1;
	}
	public void setR42_foreign1(BigDecimal r42_foreign1) {
		this.r42_foreign1 = r42_foreign1;
	}
	public BigDecimal getR42_guarantees() {
		return r42_guarantees;
	}
	public void setR42_guarantees(BigDecimal r42_guarantees) {
		this.r42_guarantees = r42_guarantees;
	}
	public BigDecimal getR42_nbfi2() {
		return r42_nbfi2;
	}
	public void setR42_nbfi2(BigDecimal r42_nbfi2) {
		this.r42_nbfi2 = r42_nbfi2;
	}
	public BigDecimal getR42_interbank2() {
		return r42_interbank2;
	}
	public void setR42_interbank2(BigDecimal r42_interbank2) {
		this.r42_interbank2 = r42_interbank2;
	}
	public BigDecimal getR42_gov5() {
		return r42_gov5;
	}
	public void setR42_gov5(BigDecimal r42_gov5) {
		this.r42_gov5 = r42_gov5;
	}
	public BigDecimal getR42_corporate2() {
		return r42_corporate2;
	}
	public void setR42_corporate2(BigDecimal r42_corporate2) {
		this.r42_corporate2 = r42_corporate2;
	}
	public BigDecimal getR42_gre2() {
		return r42_gre2;
	}
	public void setR42_gre2(BigDecimal r42_gre2) {
		this.r42_gre2 = r42_gre2;
	}
	public BigDecimal getR42_individuals3() {
		return r42_individuals3;
	}
	public void setR42_individuals3(BigDecimal r42_individuals3) {
		this.r42_individuals3 = r42_individuals3;
	}
	public BigDecimal getR42_zero1() {
		return r42_zero1;
	}
	public void setR42_zero1(BigDecimal r42_zero1) {
		this.r42_zero1 = r42_zero1;
	}
	public BigDecimal getR42_three1() {
		return r42_three1;
	}
	public void setR42_three1(BigDecimal r42_three1) {
		this.r42_three1 = r42_three1;
	}
	public BigDecimal getR42_six1() {
		return r42_six1;
	}
	public void setR42_six1(BigDecimal r42_six1) {
		this.r42_six1 = r42_six1;
	}
	public BigDecimal getR42_oneyear1() {
		return r42_oneyear1;
	}
	public void setR42_oneyear1(BigDecimal r42_oneyear1) {
		this.r42_oneyear1 = r42_oneyear1;
	}
	public String getR42_empty() {
		return r42_empty;
	}
	public void setR42_empty(String r42_empty) {
		this.r42_empty = r42_empty;
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
	public BRF59B_ENTITY() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}