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
@Table(name="BRF59A_SUMMARYTABLE")

public class BRF59A_ENTITY {

	private String	r1_product;
	private BigDecimal	r1_nbfi;
	private BigDecimal	r1_interbank;
	private BigDecimal	r1_gov;
	private BigDecimal	r1_corporate;
	private BigDecimal	r1_gre;
	private BigDecimal	r1_trade;
	private BigDecimal	r1_individuals;
	private BigDecimal	r1_investment;
	private BigDecimal	r1_nbfi1;
	private BigDecimal	r1_interbank1;
	private BigDecimal	r1_gov1;
	private BigDecimal	r1_corporate1;
	private BigDecimal	r1_gre1;
	private BigDecimal	r1_trade1;
	private BigDecimal	r1_individuals1;
	private BigDecimal	r1_investment1;
	private BigDecimal	r1_zer0;
	private BigDecimal	r1_three;
	private BigDecimal	r1_six;
	private BigDecimal	r1_oneyear;
	private BigDecimal	r1_foreign;
	private BigDecimal	r1_banks;
	private BigDecimal	r1_gov2;
	private BigDecimal	r1_other;
	private BigDecimal	r1_banks1;
	private BigDecimal	r1_individuals2;
	private BigDecimal	r1_other1;
	private BigDecimal	r1_banks2;
	private BigDecimal	r1_gov3;
	private BigDecimal	r1_others2;
	private BigDecimal	r1_banks3;
	private BigDecimal	r1_gov4;
	private BigDecimal	r1_others3;
	private BigDecimal	r1_foreign1;
	private BigDecimal	r1_guarantees;
	private BigDecimal	r1_nbfi2;
	private BigDecimal	r1_interbank2;
	private BigDecimal	r1_gov5;
	private BigDecimal	r1_corporate2;
	private BigDecimal	r1_gre2;
	private BigDecimal	r1_individuals3;
	private BigDecimal	r1_zero1;
	private BigDecimal	r1_three1;
	private BigDecimal	r1_six1;
	private BigDecimal	r1_oneyear1;
	private String	r1_empty;
	private String	r2_product;
	private BigDecimal	r2_nbfi;
	private BigDecimal	r2_interbank;
	private BigDecimal	r2_gov;
	private BigDecimal	r2_corporate;
	private BigDecimal	r2_gre;
	private BigDecimal	r2_trade;
	private BigDecimal	r2_individuals;
	private BigDecimal	r2_investment;
	private BigDecimal	r2_nbfi1;
	private BigDecimal	r2_interbank1;
	private BigDecimal	r2_gov1;
	private BigDecimal	r2_corporate1;
	private BigDecimal	r2_gre1;
	private BigDecimal	r2_trade1;
	private BigDecimal	r2_individuals1;
	private BigDecimal	r2_investment1;
	private BigDecimal	r2_zer0;
	private BigDecimal	r2_three;
	private BigDecimal	r2_six;
	private BigDecimal	r2_oneyear;
	private BigDecimal	r2_foreign;
	private BigDecimal	r2_banks;
	private BigDecimal	r2_gov2;
	private BigDecimal	r2_other;
	private BigDecimal	r2_banks1;
	private BigDecimal	r2_individuals2;
	private BigDecimal	r2_other1;
	private BigDecimal	r2_banks2;
	private BigDecimal	r2_gov3;
	private BigDecimal	r2_others2;
	private BigDecimal	r2_banks3;
	private BigDecimal	r2_gov4;
	private BigDecimal	r2_others3;
	private BigDecimal	r2_foreign1;
	private BigDecimal	r2_guarantees;
	private BigDecimal	r2_nbfi2;
	private BigDecimal	r2_interbank2;
	private BigDecimal	r2_gov5;
	private BigDecimal	r2_corporate2;
	private BigDecimal	r2_gre2;
	private BigDecimal	r2_individuals3;
	private BigDecimal	r2_zero1;
	private BigDecimal	r2_three1;
	private BigDecimal	r2_six1;
	private BigDecimal	r2_oneyear1;
	private String	r2_empty;
	private String	r3_product;
	private BigDecimal	r3_nbfi;
	private BigDecimal	r3_interbank;
	private BigDecimal	r3_gov;
	private BigDecimal	r3_corporate;
	private BigDecimal	r3_gre;
	private BigDecimal	r3_trade;
	private BigDecimal	r3_individuals;
	private BigDecimal	r3_investment;
	private BigDecimal	r3_nbfi1;
	private BigDecimal	r3_interbank1;
	private BigDecimal	r3_gov1;
	private BigDecimal	r3_corporate1;
	private BigDecimal	r3_gre1;
	private BigDecimal	r3_trade1;
	private BigDecimal	r3_individuals1;
	private BigDecimal	r3_investment1;
	private BigDecimal	r3_zer0;
	private BigDecimal	r3_three;
	private BigDecimal	r3_six;
	private BigDecimal	r3_oneyear;
	private BigDecimal	r3_foreign;
	private BigDecimal	r3_banks;
	private BigDecimal	r3_gov2;
	private BigDecimal	r3_other;
	private BigDecimal	r3_banks1;
	private BigDecimal	r3_individuals2;
	private BigDecimal	r3_other1;
	private BigDecimal	r3_banks2;
	private BigDecimal	r3_gov3;
	private BigDecimal	r3_others2;
	private BigDecimal	r3_banks3;
	private BigDecimal	r3_gov4;
	private BigDecimal	r3_others3;
	private BigDecimal	r3_foreign1;
	private BigDecimal	r3_guarantees;
	private BigDecimal	r3_nbfi2;
	private BigDecimal	r3_interbank2;
	private BigDecimal	r3_gov5;
	private BigDecimal	r3_corporate2;
	private BigDecimal	r3_gre2;
	private BigDecimal	r3_individuals3;
	private BigDecimal	r3_zero1;
	private BigDecimal	r3_three1;
	private BigDecimal	r3_six1;
	private BigDecimal	r3_oneyear1;
	private String	r3_empty;
	private String	r4_product;
	private BigDecimal	r4_nbfi;
	private BigDecimal	r4_interbank;
	private BigDecimal	r4_gov;
	private BigDecimal	r4_corporate;
	private BigDecimal	r4_gre;
	private BigDecimal	r4_trade;
	private BigDecimal	r4_individuals;
	private BigDecimal	r4_investment;
	private BigDecimal	r4_nbfi1;
	private BigDecimal	r4_interbank1;
	private BigDecimal	r4_gov1;
	private BigDecimal	r4_corporate1;
	private BigDecimal	r4_gre1;
	private BigDecimal	r4_trade1;
	private BigDecimal	r4_individuals1;
	private BigDecimal	r4_investment1;
	private BigDecimal	r4_zer0;
	private BigDecimal	r4_three;
	private BigDecimal	r4_six;
	private BigDecimal	r4_oneyear;
	private BigDecimal	r4_foreign;
	private BigDecimal	r4_banks;
	private BigDecimal	r4_gov2;
	private BigDecimal	r4_other;
	private BigDecimal	r4_banks1;
	private BigDecimal	r4_individuals2;
	private BigDecimal	r4_other1;
	private BigDecimal	r4_banks2;
	private BigDecimal	r4_gov3;
	private BigDecimal	r4_others2;
	private BigDecimal	r4_banks3;
	private BigDecimal	r4_gov4;
	private BigDecimal	r4_others3;
	private BigDecimal	r4_foreign1;
	private BigDecimal	r4_guarantees;
	private BigDecimal	r4_nbfi2;
	private BigDecimal	r4_interbank2;
	private BigDecimal	r4_gov5;
	private BigDecimal	r4_corporate2;
	private BigDecimal	r4_gre2;
	private BigDecimal	r4_individuals3;
	private BigDecimal	r4_zero1;
	private BigDecimal	r4_three1;
	private BigDecimal	r4_six1;
	private BigDecimal	r4_oneyear1;
	private String	r4_empty;
	private String	r5_product;
	private BigDecimal	r5_nbfi;
	private BigDecimal	r5_interbank;
	private BigDecimal	r5_gov;
	private BigDecimal	r5_corporate;
	private BigDecimal	r5_gre;
	private BigDecimal	r5_trade;
	private BigDecimal	r5_individuals;
	private BigDecimal	r5_investment;
	private BigDecimal	r5_nbfi1;
	private BigDecimal	r5_interbank1;
	private BigDecimal	r5_gov1;
	private BigDecimal	r5_corporate1;
	private BigDecimal	r5_gre1;
	private BigDecimal	r5_trade1;
	private BigDecimal	r5_individuals1;
	private BigDecimal	r5_investment1;
	private BigDecimal	r5_zer0;
	private BigDecimal	r5_three;
	private BigDecimal	r5_six;
	private BigDecimal	r5_oneyear;
	private BigDecimal	r5_foreign;
	private BigDecimal	r5_banks;
	private BigDecimal	r5_gov2;
	private BigDecimal	r5_other;
	private BigDecimal	r5_banks1;
	private BigDecimal	r5_individuals2;
	private BigDecimal	r5_other1;
	private BigDecimal	r5_banks2;
	private BigDecimal	r5_gov3;
	private BigDecimal	r5_others2;
	private BigDecimal	r5_banks3;
	private BigDecimal	r5_gov4;
	private BigDecimal	r5_others3;
	private BigDecimal	r5_foreign1;
	private BigDecimal	r5_guarantees;
	private BigDecimal	r5_nbfi2;
	private BigDecimal	r5_interbank2;
	private BigDecimal	r5_gov5;
	private BigDecimal	r5_corporate2;
	private BigDecimal	r5_gre2;
	private BigDecimal	r5_individuals3;
	private BigDecimal	r5_zero1;
	private BigDecimal	r5_three1;
	private BigDecimal	r5_six1;
	private BigDecimal	r5_oneyear1;
	private String	r5_empty;
	private String	r6_product;
	private BigDecimal	r6_nbfi;
	private BigDecimal	r6_interbank;
	private BigDecimal	r6_gov;
	private BigDecimal	r6_corporate;
	private BigDecimal	r6_gre;
	private BigDecimal	r6_trade;
	private BigDecimal	r6_individuals;
	private BigDecimal	r6_investment;
	private BigDecimal	r6_nbfi1;
	private BigDecimal	r6_interbank1;
	private BigDecimal	r6_gov1;
	private BigDecimal	r6_corporate1;
	private BigDecimal	r6_gre1;
	private BigDecimal	r6_trade1;
	private BigDecimal	r6_individuals1;
	private BigDecimal	r6_investment1;
	private BigDecimal	r6_zer0;
	private BigDecimal	r6_three;
	private BigDecimal	r6_six;
	private BigDecimal	r6_oneyear;
	private BigDecimal	r6_foreign;
	private BigDecimal	r6_banks;
	private BigDecimal	r6_gov2;
	private BigDecimal	r6_other;
	private BigDecimal	r6_banks1;
	private BigDecimal	r6_individuals2;
	private BigDecimal	r6_other1;
	private BigDecimal	r6_banks2;
	private BigDecimal	r6_gov3;
	private BigDecimal	r6_others2;
	private BigDecimal	r6_banks3;
	private BigDecimal	r6_gov4;
	private BigDecimal	r6_others3;
	private BigDecimal	r6_foreign1;
	private BigDecimal	r6_guarantees;
	private BigDecimal	r6_nbfi2;
	private BigDecimal	r6_interbank2;
	private BigDecimal	r6_gov5;
	private BigDecimal	r6_corporate2;
	private BigDecimal	r6_gre2;
	private BigDecimal	r6_individuals3;
	private BigDecimal	r6_zero1;
	private BigDecimal	r6_three1;
	private BigDecimal	r6_six1;
	private BigDecimal	r6_oneyear1;
	private String	r6_empty;
	private String	r7_product;
	private BigDecimal	r7_nbfi;
	private BigDecimal	r7_interbank;
	private BigDecimal	r7_gov;
	private BigDecimal	r7_corporate;
	private BigDecimal	r7_gre;
	private BigDecimal	r7_trade;
	private BigDecimal	r7_individuals;
	private BigDecimal	r7_investment;
	private BigDecimal	r7_nbfi1;
	private BigDecimal	r7_interbank1;
	private BigDecimal	r7_gov1;
	private BigDecimal	r7_corporate1;
	private BigDecimal	r7_gre1;
	private BigDecimal	r7_trade1;
	private BigDecimal	r7_individuals1;
	private BigDecimal	r7_investment1;
	private BigDecimal	r7_zer0;
	private BigDecimal	r7_three;
	private BigDecimal	r7_six;
	private BigDecimal	r7_oneyear;
	private BigDecimal	r7_foreign;
	private BigDecimal	r7_banks;
	private BigDecimal	r7_gov2;
	private BigDecimal	r7_other;
	private BigDecimal	r7_banks1;
	private BigDecimal	r7_individuals2;
	private BigDecimal	r7_other1;
	private BigDecimal	r7_banks2;
	private BigDecimal	r7_gov3;
	private BigDecimal	r7_others2;
	private BigDecimal	r7_banks3;
	private BigDecimal	r7_gov4;
	private BigDecimal	r7_others3;
	private BigDecimal	r7_foreign1;
	private BigDecimal	r7_guarantees;
	private BigDecimal	r7_nbfi2;
	private BigDecimal	r7_interbank2;
	private BigDecimal	r7_gov5;
	private BigDecimal	r7_corporate2;
	private BigDecimal	r7_gre2;
	private BigDecimal	r7_individuals3;
	private BigDecimal	r7_zero1;
	private BigDecimal	r7_three1;
	private BigDecimal	r7_six1;
	private BigDecimal	r7_oneyear1;
	private String	r7_empty;
	private String	r8_product;
	private BigDecimal	r8_nbfi;
	private BigDecimal	r8_interbank;
	private BigDecimal	r8_gov;
	private BigDecimal	r8_corporate;
	private BigDecimal	r8_gre;
	private BigDecimal	r8_trade;
	private BigDecimal	r8_individuals;
	private BigDecimal	r8_investment;
	private BigDecimal	r8_nbfi1;
	private BigDecimal	r8_interbank1;
	private BigDecimal	r8_gov1;
	private BigDecimal	r8_corporate1;
	private BigDecimal	r8_gre1;
	private BigDecimal	r8_trade1;
	private BigDecimal	r8_individuals1;
	private BigDecimal	r8_investment1;
	private BigDecimal	r8_zer0;
	private BigDecimal	r8_three;
	private BigDecimal	r8_six;
	private BigDecimal	r8_oneyear;
	private BigDecimal	r8_foreign;
	private BigDecimal	r8_banks;
	private BigDecimal	r8_gov2;
	private BigDecimal	r8_other;
	private BigDecimal	r8_banks1;
	private BigDecimal	r8_individuals2;
	private BigDecimal	r8_other1;
	private BigDecimal	r8_banks2;
	private BigDecimal	r8_gov3;
	private BigDecimal	r8_others2;
	private BigDecimal	r8_banks3;
	private BigDecimal	r8_gov4;
	private BigDecimal	r8_others3;
	private BigDecimal	r8_foreign1;
	private BigDecimal	r8_guarantees;
	private BigDecimal	r8_nbfi2;
	private BigDecimal	r8_interbank2;
	private BigDecimal	r8_gov5;
	private BigDecimal	r8_corporate2;
	private BigDecimal	r8_gre2;
	private BigDecimal	r8_individuals3;
	private BigDecimal	r8_zero1;
	private BigDecimal	r8_three1;
	private BigDecimal	r8_six1;
	private BigDecimal	r8_oneyear1;
	private String	r8_empty;
	private String	r9_product;
	private BigDecimal	r9_nbfi;
	private BigDecimal	r9_interbank;
	private BigDecimal	r9_gov;
	private BigDecimal	r9_corporate;
	private BigDecimal	r9_gre;
	private BigDecimal	r9_trade;
	private BigDecimal	r9_individuals;
	private BigDecimal	r9_investment;
	private BigDecimal	r9_nbfi1;
	private BigDecimal	r9_interbank1;
	private BigDecimal	r9_gov1;
	private BigDecimal	r9_corporate1;
	private BigDecimal	r9_gre1;
	private BigDecimal	r9_trade1;
	private BigDecimal	r9_individuals1;
	private BigDecimal	r9_investment1;
	private BigDecimal	r9_zer0;
	private BigDecimal	r9_three;
	private BigDecimal	r9_six;
	private BigDecimal	r9_oneyear;
	private BigDecimal	r9_foreign;
	private BigDecimal	r9_banks;
	private BigDecimal	r9_gov2;
	private BigDecimal	r9_other;
	private BigDecimal	r9_banks1;
	private BigDecimal	r9_individuals2;
	private BigDecimal	r9_other1;
	private BigDecimal	r9_banks2;
	private BigDecimal	r9_gov3;
	private BigDecimal	r9_others2;
	private BigDecimal	r9_banks3;
	private BigDecimal	r9_gov4;
	private BigDecimal	r9_others3;
	private BigDecimal	r9_foreign1;
	private BigDecimal	r9_guarantees;
	private BigDecimal	r9_nbfi2;
	private BigDecimal	r9_interbank2;
	private BigDecimal	r9_gov5;
	private BigDecimal	r9_corporate2;
	private BigDecimal	r9_gre2;
	private BigDecimal	r9_individuals3;
	private BigDecimal	r9_zero1;
	private BigDecimal	r9_three1;
	private BigDecimal	r9_six1;
	private BigDecimal	r9_oneyear1;
	private String	r9_empty;
	private String	r10_product;
	private BigDecimal	r10_nbfi;
	private BigDecimal	r10_interbank;
	private BigDecimal	r10_gov;
	private BigDecimal	r10_corporate;
	private BigDecimal	r10_gre;
	private BigDecimal	r10_trade;
	private BigDecimal	r10_individuals;
	private BigDecimal	r10_investment;
	private BigDecimal	r10_nbfi1;
	private BigDecimal	r10_interbank1;
	private BigDecimal	r10_gov1;
	private BigDecimal	r10_corporate1;
	private BigDecimal	r10_gre1;
	private BigDecimal	r10_trade1;
	private BigDecimal	r10_individuals1;
	private BigDecimal	r10_investment1;
	private BigDecimal	r10_zer0;
	private BigDecimal	r10_three;
	private BigDecimal	r10_six;
	private BigDecimal	r10_oneyear;
	private BigDecimal	r10_foreign;
	private BigDecimal	r10_banks;
	private BigDecimal	r10_gov2;
	private BigDecimal	r10_other;
	private BigDecimal	r10_banks1;
	private BigDecimal	r10_individuals2;
	private BigDecimal	r10_other1;
	private BigDecimal	r10_banks2;
	private BigDecimal	r10_gov3;
	private BigDecimal	r10_others2;
	private BigDecimal	r10_banks3;
	private BigDecimal	r10_gov4;
	private BigDecimal	r10_others3;
	private BigDecimal	r10_foreign1;
	private BigDecimal	r10_guarantees;
	private BigDecimal	r10_nbfi2;
	private BigDecimal	r10_interbank2;
	private BigDecimal	r10_gov5;
	private BigDecimal	r10_corporate2;
	private BigDecimal	r10_gre2;
	private BigDecimal	r10_individuals3;
	private BigDecimal	r10_zero1;
	private BigDecimal	r10_three1;
	private BigDecimal	r10_six1;
	private BigDecimal	r10_oneyear1;
	private String	r10_empty;
	private String	r11_product;
	private BigDecimal	r11_nbfi;
	private BigDecimal	r11_interbank;
	private BigDecimal	r11_gov;
	private BigDecimal	r11_corporate;
	private BigDecimal	r11_gre;
	private BigDecimal	r11_trade;
	private BigDecimal	r11_individuals;
	private BigDecimal	r11_investment;
	private BigDecimal	r11_nbfi1;
	private BigDecimal	r11_interbank1;
	private BigDecimal	r11_gov1;
	private BigDecimal	r11_corporate1;
	private BigDecimal	r11_gre1;
	private BigDecimal	r11_trade1;
	private BigDecimal	r11_individuals1;
	private BigDecimal	r11_investment1;
	private BigDecimal	r11_zer0;
	private BigDecimal	r11_three;
	private BigDecimal	r11_six;
	private BigDecimal	r11_oneyear;
	private BigDecimal	r11_foreign;
	private BigDecimal	r11_banks;
	private BigDecimal	r11_gov2;
	private BigDecimal	r11_other;
	private BigDecimal	r11_banks1;
	private BigDecimal	r11_individuals2;
	private BigDecimal	r11_other1;
	private BigDecimal	r11_banks2;
	private BigDecimal	r11_gov3;
	private BigDecimal	r11_others2;
	private BigDecimal	r11_banks3;
	private BigDecimal	r11_gov4;
	private BigDecimal	r11_others3;
	private BigDecimal	r11_foreign1;
	private BigDecimal	r11_guarantees;
	private BigDecimal	r11_nbfi2;
	private BigDecimal	r11_interbank2;
	private BigDecimal	r11_gov5;
	private BigDecimal	r11_corporate2;
	private BigDecimal	r11_gre2;
	private BigDecimal	r11_individuals3;
	private BigDecimal	r11_zero1;
	private BigDecimal	r11_three1;
	private BigDecimal	r11_six1;
	private BigDecimal	r11_oneyear1;
	private String	r11_empty;
	private String	r12_product;
	private BigDecimal	r12_nbfi;
	private BigDecimal	r12_interbank;
	private BigDecimal	r12_gov;
	private BigDecimal	r12_corporate;
	private BigDecimal	r12_gre;
	private BigDecimal	r12_trade;
	private BigDecimal	r12_individuals;
	private BigDecimal	r12_investment;
	private BigDecimal	r12_nbfi1;
	private BigDecimal	r12_interbank1;
	private BigDecimal	r12_gov1;
	private BigDecimal	r12_corporate1;
	private BigDecimal	r12_gre1;
	private BigDecimal	r12_trade1;
	private BigDecimal	r12_individuals1;
	private BigDecimal	r12_investment1;
	private BigDecimal	r12_zer0;
	private BigDecimal	r12_three;
	private BigDecimal	r12_six;
	private BigDecimal	r12_oneyear;
	private BigDecimal	r12_foreign;
	private BigDecimal	r12_banks;
	private BigDecimal	r12_gov2;
	private BigDecimal	r12_other;
	private BigDecimal	r12_banks1;
	private BigDecimal	r12_individuals2;
	private BigDecimal	r12_other1;
	private BigDecimal	r12_banks2;
	private BigDecimal	r12_gov3;
	private BigDecimal	r12_others2;
	private BigDecimal	r12_banks3;
	private BigDecimal	r12_gov4;
	private BigDecimal	r12_others3;
	private BigDecimal	r12_foreign1;
	private BigDecimal	r12_guarantees;
	private BigDecimal	r12_nbfi2;
	private BigDecimal	r12_interbank2;
	private BigDecimal	r12_gov5;
	private BigDecimal	r12_corporate2;
	private BigDecimal	r12_gre2;
	private BigDecimal	r12_individuals3;
	private BigDecimal	r12_zero1;
	private BigDecimal	r12_three1;
	private BigDecimal	r12_six1;
	private BigDecimal	r12_oneyear1;
	private String	r12_empty;
	private String	r13_product;
	private BigDecimal	r13_nbfi;
	private BigDecimal	r13_interbank;
	private BigDecimal	r13_gov;
	private BigDecimal	r13_corporate;
	private BigDecimal	r13_gre;
	private BigDecimal	r13_trade;
	private BigDecimal	r13_individuals;
	private BigDecimal	r13_investment;
	private BigDecimal	r13_nbfi1;
	private BigDecimal	r13_interbank1;
	private BigDecimal	r13_gov1;
	private BigDecimal	r13_corporate1;
	private BigDecimal	r13_gre1;
	private BigDecimal	r13_trade1;
	private BigDecimal	r13_individuals1;
	private BigDecimal	r13_investment1;
	private BigDecimal	r13_zer0;
	private BigDecimal	r13_three;
	private BigDecimal	r13_six;
	private BigDecimal	r13_oneyear;
	private BigDecimal	r13_foreign;
	private BigDecimal	r13_banks;
	private BigDecimal	r13_gov2;
	private BigDecimal	r13_other;
	private BigDecimal	r13_banks1;
	private BigDecimal	r13_individuals2;
	private BigDecimal	r13_other1;
	private BigDecimal	r13_banks2;
	private BigDecimal	r13_gov3;
	private BigDecimal	r13_others2;
	private BigDecimal	r13_banks3;
	private BigDecimal	r13_gov4;
	private BigDecimal	r13_others3;
	private BigDecimal	r13_foreign1;
	private BigDecimal	r13_guarantees;
	private BigDecimal	r13_nbfi2;
	private BigDecimal	r13_interbank2;
	private BigDecimal	r13_gov5;
	private BigDecimal	r13_corporate2;
	private BigDecimal	r13_gre2;
	private BigDecimal	r13_individuals3;
	private BigDecimal	r13_zero1;
	private BigDecimal	r13_three1;
	private BigDecimal	r13_six1;
	private BigDecimal	r13_oneyear1;
	private String	r13_empty;
	private String	r14_product;
	private BigDecimal	r14_nbfi;
	private BigDecimal	r14_interbank;
	private BigDecimal	r14_gov;
	private BigDecimal	r14_corporate;
	private BigDecimal	r14_gre;
	private BigDecimal	r14_trade;
	private BigDecimal	r14_individuals;
	private BigDecimal	r14_investment;
	private BigDecimal	r14_nbfi1;
	private BigDecimal	r14_interbank1;
	private BigDecimal	r14_gov1;
	private BigDecimal	r14_corporate1;
	private BigDecimal	r14_gre1;
	private BigDecimal	r14_trade1;
	private BigDecimal	r14_individuals1;
	private BigDecimal	r14_investment1;
	private BigDecimal	r14_zer0;
	private BigDecimal	r14_three;
	private BigDecimal	r14_six;
	private BigDecimal	r14_oneyear;
	private BigDecimal	r14_foreign;
	private BigDecimal	r14_banks;
	private BigDecimal	r14_gov2;
	private BigDecimal	r14_other;
	private BigDecimal	r14_banks1;
	private BigDecimal	r14_individuals2;
	private BigDecimal	r14_other1;
	private BigDecimal	r14_banks2;
	private BigDecimal	r14_gov3;
	private BigDecimal	r14_others2;
	private BigDecimal	r14_banks3;
	private BigDecimal	r14_gov4;
	private BigDecimal	r14_others3;
	private BigDecimal	r14_foreign1;
	private BigDecimal	r14_guarantees;
	private BigDecimal	r14_nbfi2;
	private BigDecimal	r14_interbank2;
	private BigDecimal	r14_gov5;
	private BigDecimal	r14_corporate2;
	private BigDecimal	r14_gre2;
	private BigDecimal	r14_individuals3;
	private BigDecimal	r14_zero1;
	private BigDecimal	r14_three1;
	private BigDecimal	r14_six1;
	private BigDecimal	r14_oneyear1;
	private String	r14_empty;
	private String	r15_product;
	private BigDecimal	r15_nbfi;
	private BigDecimal	r15_interbank;
	private BigDecimal	r15_gov;
	private BigDecimal	r15_corporate;
	private BigDecimal	r15_gre;
	private BigDecimal	r15_trade;
	private BigDecimal	r15_individuals;
	private BigDecimal	r15_investment;
	private BigDecimal	r15_nbfi1;
	private BigDecimal	r15_interbank1;
	private BigDecimal	r15_gov1;
	private BigDecimal	r15_corporate1;
	private BigDecimal	r15_gre1;
	private BigDecimal	r15_trade1;
	private BigDecimal	r15_individuals1;
	private BigDecimal	r15_investment1;
	private BigDecimal	r15_zer0;
	private BigDecimal	r15_three;
	private BigDecimal	r15_six;
	private BigDecimal	r15_oneyear;
	private BigDecimal	r15_foreign;
	private BigDecimal	r15_banks;
	private BigDecimal	r15_gov2;
	private BigDecimal	r15_other;
	private BigDecimal	r15_banks1;
	private BigDecimal	r15_individuals2;
	private BigDecimal	r15_other1;
	private BigDecimal	r15_banks2;
	private BigDecimal	r15_gov3;
	private BigDecimal	r15_others2;
	private BigDecimal	r15_banks3;
	private BigDecimal	r15_gov4;
	private BigDecimal	r15_others3;
	private BigDecimal	r15_foreign1;
	private BigDecimal	r15_guarantees;
	private BigDecimal	r15_nbfi2;
	private BigDecimal	r15_interbank2;
	private BigDecimal	r15_gov5;
	private BigDecimal	r15_corporate2;
	private BigDecimal	r15_gre2;
	private BigDecimal	r15_individuals3;
	private BigDecimal	r15_zero1;
	private BigDecimal	r15_three1;
	private BigDecimal	r15_six1;
	private BigDecimal	r15_oneyear1;
	private String	r15_empty;
	private String	r16_product;
	private BigDecimal	r16_nbfi;
	private BigDecimal	r16_interbank;
	private BigDecimal	r16_gov;
	private BigDecimal	r16_corporate;
	private BigDecimal	r16_gre;
	private BigDecimal	r16_trade;
	private BigDecimal	r16_individuals;
	private BigDecimal	r16_investment;
	private BigDecimal	r16_nbfi1;
	private BigDecimal	r16_interbank1;
	private BigDecimal	r16_gov1;
	private BigDecimal	r16_corporate1;
	private BigDecimal	r16_gre1;
	private BigDecimal	r16_trade1;
	private BigDecimal	r16_individuals1;
	private BigDecimal	r16_investment1;
	private BigDecimal	r16_zer0;
	private BigDecimal	r16_three;
	private BigDecimal	r16_six;
	private BigDecimal	r16_oneyear;
	private BigDecimal	r16_foreign;
	private BigDecimal	r16_banks;
	private BigDecimal	r16_gov2;
	private BigDecimal	r16_other;
	private BigDecimal	r16_banks1;
	private BigDecimal	r16_individuals2;
	private BigDecimal	r16_other1;
	private BigDecimal	r16_banks2;
	private BigDecimal	r16_gov3;
	private BigDecimal	r16_others2;
	private BigDecimal	r16_banks3;
	private BigDecimal	r16_gov4;
	private BigDecimal	r16_others3;
	private BigDecimal	r16_foreign1;
	private BigDecimal	r16_guarantees;
	private BigDecimal	r16_nbfi2;
	private BigDecimal	r16_interbank2;
	private BigDecimal	r16_gov5;
	private BigDecimal	r16_corporate2;
	private BigDecimal	r16_gre2;
	private BigDecimal	r16_individuals3;
	private BigDecimal	r16_zero1;
	private BigDecimal	r16_three1;
	private BigDecimal	r16_six1;
	private BigDecimal	r16_oneyear1;
	private String	r16_empty;
	private String	r17_product;
	private BigDecimal	r17_nbfi;
	private BigDecimal	r17_interbank;
	private BigDecimal	r17_gov;
	private BigDecimal	r17_corporate;
	private BigDecimal	r17_gre;
	private BigDecimal	r17_trade;
	private BigDecimal	r17_individuals;
	private BigDecimal	r17_investment;
	private BigDecimal	r17_nbfi1;
	private BigDecimal	r17_interbank1;
	private BigDecimal	r17_gov1;
	private BigDecimal	r17_corporate1;
	private BigDecimal	r17_gre1;
	private BigDecimal	r17_trade1;
	private BigDecimal	r17_individuals1;
	private BigDecimal	r17_investment1;
	private BigDecimal	r17_zer0;
	private BigDecimal	r17_three;
	private BigDecimal	r17_six;
	private BigDecimal	r17_oneyear;
	private BigDecimal	r17_foreign;
	private BigDecimal	r17_banks;
	private BigDecimal	r17_gov2;
	private BigDecimal	r17_other;
	private BigDecimal	r17_banks1;
	private BigDecimal	r17_individuals2;
	private BigDecimal	r17_other1;
	private BigDecimal	r17_banks2;
	private BigDecimal	r17_gov3;
	private BigDecimal	r17_others2;
	private BigDecimal	r17_banks3;
	private BigDecimal	r17_gov4;
	private BigDecimal	r17_others3;
	private BigDecimal	r17_foreign1;
	private BigDecimal	r17_guarantees;
	private BigDecimal	r17_nbfi2;
	private BigDecimal	r17_interbank2;
	private BigDecimal	r17_gov5;
	private BigDecimal	r17_corporate2;
	private BigDecimal	r17_gre2;
	private BigDecimal	r17_individuals3;
	private BigDecimal	r17_zero1;
	private BigDecimal	r17_three1;
	private BigDecimal	r17_six1;
	private BigDecimal	r17_oneyear1;
	private String	r17_empty;
	private String	r18_product;
	private BigDecimal	r18_nbfi;
	private BigDecimal	r18_interbank;
	private BigDecimal	r18_gov;
	private BigDecimal	r18_corporate;
	private BigDecimal	r18_gre;
	private BigDecimal	r18_trade;
	private BigDecimal	r18_individuals;
	private BigDecimal	r18_investment;
	private BigDecimal	r18_nbfi1;
	private BigDecimal	r18_interbank1;
	private BigDecimal	r18_gov1;
	private BigDecimal	r18_corporate1;
	private BigDecimal	r18_gre1;
	private BigDecimal	r18_trade1;
	private BigDecimal	r18_individuals1;
	private BigDecimal	r18_investment1;
	private BigDecimal	r18_zer0;
	private BigDecimal	r18_three;
	private BigDecimal	r18_six;
	private BigDecimal	r18_oneyear;
	private BigDecimal	r18_foreign;
	private BigDecimal	r18_banks;
	private BigDecimal	r18_gov2;
	private BigDecimal	r18_other;
	private BigDecimal	r18_banks1;
	private BigDecimal	r18_individuals2;
	private BigDecimal	r18_other1;
	private BigDecimal	r18_banks2;
	private BigDecimal	r18_gov3;
	private BigDecimal	r18_others2;
	private BigDecimal	r18_banks3;
	private BigDecimal	r18_gov4;
	private BigDecimal	r18_others3;
	private BigDecimal	r18_foreign1;
	private BigDecimal	r18_guarantees;
	private BigDecimal	r18_nbfi2;
	private BigDecimal	r18_interbank2;
	private BigDecimal	r18_gov5;
	private BigDecimal	r18_corporate2;
	private BigDecimal	r18_gre2;
	private BigDecimal	r18_individuals3;
	private BigDecimal	r18_zero1;
	private BigDecimal	r18_three1;
	private BigDecimal	r18_six1;
	private BigDecimal	r18_oneyear1;
	private String	r18_empty;
	private String	r19_product;
	private BigDecimal	r19_nbfi;
	private BigDecimal	r19_interbank;
	private BigDecimal	r19_gov;
	private BigDecimal	r19_corporate;
	private BigDecimal	r19_gre;
	private BigDecimal	r19_trade;
	private BigDecimal	r19_individuals;
	private BigDecimal	r19_investment;
	private BigDecimal	r19_nbfi1;
	private BigDecimal	r19_interbank1;
	private BigDecimal	r19_gov1;
	private BigDecimal	r19_corporate1;
	private BigDecimal	r19_gre1;
	private BigDecimal	r19_trade1;
	private BigDecimal	r19_individuals1;
	private BigDecimal	r19_investment1;
	private BigDecimal	r19_zer0;
	private BigDecimal	r19_three;
	private BigDecimal	r19_six;
	private BigDecimal	r19_oneyear;
	private BigDecimal	r19_foreign;
	private BigDecimal	r19_banks;
	private BigDecimal	r19_gov2;
	private BigDecimal	r19_other;
	private BigDecimal	r19_banks1;
	private BigDecimal	r19_individuals2;
	private BigDecimal	r19_other1;
	private BigDecimal	r19_banks2;
	private BigDecimal	r19_gov3;
	private BigDecimal	r19_others2;
	private BigDecimal	r19_banks3;
	private BigDecimal	r19_gov4;
	private BigDecimal	r19_others3;
	private BigDecimal	r19_foreign1;
	private BigDecimal	r19_guarantees;
	private BigDecimal	r19_nbfi2;
	private BigDecimal	r19_interbank2;
	private BigDecimal	r19_gov5;
	private BigDecimal	r19_corporate2;
	private BigDecimal	r19_gre2;
	private BigDecimal	r19_individuals3;
	private BigDecimal	r19_zero1;
	private BigDecimal	r19_three1;
	private BigDecimal	r19_six1;
	private BigDecimal	r19_oneyear1;
	private String	r19_empty;
	private String	r20_product;
	private BigDecimal	r20_nbfi;
	private BigDecimal	r20_interbank;
	private BigDecimal	r20_gov;
	private BigDecimal	r20_corporate;
	private BigDecimal	r20_gre;
	private BigDecimal	r20_trade;
	private BigDecimal	r20_individuals;
	private BigDecimal	r20_investment;
	private BigDecimal	r20_nbfi1;
	private BigDecimal	r20_interbank1;
	private BigDecimal	r20_gov1;
	private BigDecimal	r20_corporate1;
	private BigDecimal	r20_gre1;
	private BigDecimal	r20_trade1;
	private BigDecimal	r20_individuals1;
	private BigDecimal	r20_investment1;
	private BigDecimal	r20_zer0;
	private BigDecimal	r20_three;
	private BigDecimal	r20_six;
	private BigDecimal	r20_oneyear;
	private BigDecimal	r20_foreign;
	private BigDecimal	r20_banks;
	private BigDecimal	r20_gov2;
	private BigDecimal	r20_other;
	private BigDecimal	r20_banks1;
	private BigDecimal	r20_individuals2;
	private BigDecimal	r20_other1;
	private BigDecimal	r20_banks2;
	private BigDecimal	r20_gov3;
	private BigDecimal	r20_others2;
	private BigDecimal	r20_banks3;
	private BigDecimal	r20_gov4;
	private BigDecimal	r20_others3;
	private BigDecimal	r20_foreign1;
	private BigDecimal	r20_guarantees;
	private BigDecimal	r20_nbfi2;
	private BigDecimal	r20_interbank2;
	private BigDecimal	r20_gov5;
	private BigDecimal	r20_corporate2;
	private BigDecimal	r20_gre2;
	private BigDecimal	r20_individuals3;
	private BigDecimal	r20_zero1;
	private BigDecimal	r20_three1;
	private BigDecimal	r20_six1;
	private BigDecimal	r20_oneyear1;
	private String	r20_empty;
	private String	r21_product;
	private BigDecimal	r21_nbfi;
	private BigDecimal	r21_interbank;
	private BigDecimal	r21_gov;
	private BigDecimal	r21_corporate;
	private BigDecimal	r21_gre;
	private BigDecimal	r21_trade;
	private BigDecimal	r21_individuals;
	private BigDecimal	r21_investment;
	private BigDecimal	r21_nbfi1;
	private BigDecimal	r21_interbank1;
	private BigDecimal	r21_gov1;
	private BigDecimal	r21_corporate1;
	private BigDecimal	r21_gre1;
	private BigDecimal	r21_trade1;
	private BigDecimal	r21_individuals1;
	private BigDecimal	r21_investment1;
	private BigDecimal	r21_zer0;
	private BigDecimal	r21_three;
	private BigDecimal	r21_six;
	private BigDecimal	r21_oneyear;
	private BigDecimal	r21_foreign;
	private BigDecimal	r21_banks;
	private BigDecimal	r21_gov2;
	private BigDecimal	r21_other;
	private BigDecimal	r21_banks1;
	private BigDecimal	r21_individuals2;
	private BigDecimal	r21_other1;
	private BigDecimal	r21_banks2;
	private BigDecimal	r21_gov3;
	private BigDecimal	r21_others2;
	private BigDecimal	r21_banks3;
	private BigDecimal	r21_gov4;
	private BigDecimal	r21_others3;
	private BigDecimal	r21_foreign1;
	private BigDecimal	r21_guarantees;
	private BigDecimal	r21_nbfi2;
	private BigDecimal	r21_interbank2;
	private BigDecimal	r21_gov5;
	private BigDecimal	r21_corporate2;
	private BigDecimal	r21_gre2;
	private BigDecimal	r21_individuals3;
	private BigDecimal	r21_zero1;
	private BigDecimal	r21_three1;
	private BigDecimal	r21_six1;
	private BigDecimal	r21_oneyear1;
	private String	r21_empty;
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
	public String getR1_product() {
		return r1_product;
	}
	public void setR1_product(String r1_product) {
		this.r1_product = r1_product;
	}
	public BigDecimal getR1_nbfi() {
		return r1_nbfi;
	}
	public void setR1_nbfi(BigDecimal r1_nbfi) {
		this.r1_nbfi = r1_nbfi;
	}
	public BigDecimal getR1_interbank() {
		return r1_interbank;
	}
	public void setR1_interbank(BigDecimal r1_interbank) {
		this.r1_interbank = r1_interbank;
	}
	public BigDecimal getR1_gov() {
		return r1_gov;
	}
	public void setR1_gov(BigDecimal r1_gov) {
		this.r1_gov = r1_gov;
	}
	public BigDecimal getR1_corporate() {
		return r1_corporate;
	}
	public void setR1_corporate(BigDecimal r1_corporate) {
		this.r1_corporate = r1_corporate;
	}
	public BigDecimal getR1_gre() {
		return r1_gre;
	}
	public void setR1_gre(BigDecimal r1_gre) {
		this.r1_gre = r1_gre;
	}
	public BigDecimal getR1_trade() {
		return r1_trade;
	}
	public void setR1_trade(BigDecimal r1_trade) {
		this.r1_trade = r1_trade;
	}
	public BigDecimal getR1_individuals() {
		return r1_individuals;
	}
	public void setR1_individuals(BigDecimal r1_individuals) {
		this.r1_individuals = r1_individuals;
	}
	public BigDecimal getR1_investment() {
		return r1_investment;
	}
	public void setR1_investment(BigDecimal r1_investment) {
		this.r1_investment = r1_investment;
	}
	public BigDecimal getR1_nbfi1() {
		return r1_nbfi1;
	}
	public void setR1_nbfi1(BigDecimal r1_nbfi1) {
		this.r1_nbfi1 = r1_nbfi1;
	}
	public BigDecimal getR1_interbank1() {
		return r1_interbank1;
	}
	public void setR1_interbank1(BigDecimal r1_interbank1) {
		this.r1_interbank1 = r1_interbank1;
	}
	public BigDecimal getR1_gov1() {
		return r1_gov1;
	}
	public void setR1_gov1(BigDecimal r1_gov1) {
		this.r1_gov1 = r1_gov1;
	}
	public BigDecimal getR1_corporate1() {
		return r1_corporate1;
	}
	public void setR1_corporate1(BigDecimal r1_corporate1) {
		this.r1_corporate1 = r1_corporate1;
	}
	public BigDecimal getR1_gre1() {
		return r1_gre1;
	}
	public void setR1_gre1(BigDecimal r1_gre1) {
		this.r1_gre1 = r1_gre1;
	}
	public BigDecimal getR1_trade1() {
		return r1_trade1;
	}
	public void setR1_trade1(BigDecimal r1_trade1) {
		this.r1_trade1 = r1_trade1;
	}
	public BigDecimal getR1_individuals1() {
		return r1_individuals1;
	}
	public void setR1_individuals1(BigDecimal r1_individuals1) {
		this.r1_individuals1 = r1_individuals1;
	}
	public BigDecimal getR1_investment1() {
		return r1_investment1;
	}
	public void setR1_investment1(BigDecimal r1_investment1) {
		this.r1_investment1 = r1_investment1;
	}
	public BigDecimal getR1_zer0() {
		return r1_zer0;
	}
	public void setR1_zer0(BigDecimal r1_zer0) {
		this.r1_zer0 = r1_zer0;
	}
	public BigDecimal getR1_three() {
		return r1_three;
	}
	public void setR1_three(BigDecimal r1_three) {
		this.r1_three = r1_three;
	}
	public BigDecimal getR1_six() {
		return r1_six;
	}
	public void setR1_six(BigDecimal r1_six) {
		this.r1_six = r1_six;
	}
	public BigDecimal getR1_oneyear() {
		return r1_oneyear;
	}
	public void setR1_oneyear(BigDecimal r1_oneyear) {
		this.r1_oneyear = r1_oneyear;
	}
	public BigDecimal getR1_foreign() {
		return r1_foreign;
	}
	public void setR1_foreign(BigDecimal r1_foreign) {
		this.r1_foreign = r1_foreign;
	}
	public BigDecimal getR1_banks() {
		return r1_banks;
	}
	public void setR1_banks(BigDecimal r1_banks) {
		this.r1_banks = r1_banks;
	}
	public BigDecimal getR1_gov2() {
		return r1_gov2;
	}
	public void setR1_gov2(BigDecimal r1_gov2) {
		this.r1_gov2 = r1_gov2;
	}
	public BigDecimal getR1_other() {
		return r1_other;
	}
	public void setR1_other(BigDecimal r1_other) {
		this.r1_other = r1_other;
	}
	public BigDecimal getR1_banks1() {
		return r1_banks1;
	}
	public void setR1_banks1(BigDecimal r1_banks1) {
		this.r1_banks1 = r1_banks1;
	}
	public BigDecimal getR1_individuals2() {
		return r1_individuals2;
	}
	public void setR1_individuals2(BigDecimal r1_individuals2) {
		this.r1_individuals2 = r1_individuals2;
	}
	public BigDecimal getR1_other1() {
		return r1_other1;
	}
	public void setR1_other1(BigDecimal r1_other1) {
		this.r1_other1 = r1_other1;
	}
	public BigDecimal getR1_banks2() {
		return r1_banks2;
	}
	public void setR1_banks2(BigDecimal r1_banks2) {
		this.r1_banks2 = r1_banks2;
	}
	public BigDecimal getR1_gov3() {
		return r1_gov3;
	}
	public void setR1_gov3(BigDecimal r1_gov3) {
		this.r1_gov3 = r1_gov3;
	}
	public BigDecimal getR1_others2() {
		return r1_others2;
	}
	public void setR1_others2(BigDecimal r1_others2) {
		this.r1_others2 = r1_others2;
	}
	public BigDecimal getR1_banks3() {
		return r1_banks3;
	}
	public void setR1_banks3(BigDecimal r1_banks3) {
		this.r1_banks3 = r1_banks3;
	}
	public BigDecimal getR1_gov4() {
		return r1_gov4;
	}
	public void setR1_gov4(BigDecimal r1_gov4) {
		this.r1_gov4 = r1_gov4;
	}
	public BigDecimal getR1_others3() {
		return r1_others3;
	}
	public void setR1_others3(BigDecimal r1_others3) {
		this.r1_others3 = r1_others3;
	}
	public BigDecimal getR1_foreign1() {
		return r1_foreign1;
	}
	public void setR1_foreign1(BigDecimal r1_foreign1) {
		this.r1_foreign1 = r1_foreign1;
	}
	public BigDecimal getR1_guarantees() {
		return r1_guarantees;
	}
	public void setR1_guarantees(BigDecimal r1_guarantees) {
		this.r1_guarantees = r1_guarantees;
	}
	public BigDecimal getR1_nbfi2() {
		return r1_nbfi2;
	}
	public void setR1_nbfi2(BigDecimal r1_nbfi2) {
		this.r1_nbfi2 = r1_nbfi2;
	}
	public BigDecimal getR1_interbank2() {
		return r1_interbank2;
	}
	public void setR1_interbank2(BigDecimal r1_interbank2) {
		this.r1_interbank2 = r1_interbank2;
	}
	public BigDecimal getR1_gov5() {
		return r1_gov5;
	}
	public void setR1_gov5(BigDecimal r1_gov5) {
		this.r1_gov5 = r1_gov5;
	}
	public BigDecimal getR1_corporate2() {
		return r1_corporate2;
	}
	public void setR1_corporate2(BigDecimal r1_corporate2) {
		this.r1_corporate2 = r1_corporate2;
	}
	public BigDecimal getR1_gre2() {
		return r1_gre2;
	}
	public void setR1_gre2(BigDecimal r1_gre2) {
		this.r1_gre2 = r1_gre2;
	}
	public BigDecimal getR1_individuals3() {
		return r1_individuals3;
	}
	public void setR1_individuals3(BigDecimal r1_individuals3) {
		this.r1_individuals3 = r1_individuals3;
	}
	public BigDecimal getR1_zero1() {
		return r1_zero1;
	}
	public void setR1_zero1(BigDecimal r1_zero1) {
		this.r1_zero1 = r1_zero1;
	}
	public BigDecimal getR1_three1() {
		return r1_three1;
	}
	public void setR1_three1(BigDecimal r1_three1) {
		this.r1_three1 = r1_three1;
	}
	public BigDecimal getR1_six1() {
		return r1_six1;
	}
	public void setR1_six1(BigDecimal r1_six1) {
		this.r1_six1 = r1_six1;
	}
	public BigDecimal getR1_oneyear1() {
		return r1_oneyear1;
	}
	public void setR1_oneyear1(BigDecimal r1_oneyear1) {
		this.r1_oneyear1 = r1_oneyear1;
	}
	public String getR1_empty() {
		return r1_empty;
	}
	public void setR1_empty(String r1_empty) {
		this.r1_empty = r1_empty;
	}
	public String getR2_product() {
		return r2_product;
	}
	public void setR2_product(String r2_product) {
		this.r2_product = r2_product;
	}
	public BigDecimal getR2_nbfi() {
		return r2_nbfi;
	}
	public void setR2_nbfi(BigDecimal r2_nbfi) {
		this.r2_nbfi = r2_nbfi;
	}
	public BigDecimal getR2_interbank() {
		return r2_interbank;
	}
	public void setR2_interbank(BigDecimal r2_interbank) {
		this.r2_interbank = r2_interbank;
	}
	public BigDecimal getR2_gov() {
		return r2_gov;
	}
	public void setR2_gov(BigDecimal r2_gov) {
		this.r2_gov = r2_gov;
	}
	public BigDecimal getR2_corporate() {
		return r2_corporate;
	}
	public void setR2_corporate(BigDecimal r2_corporate) {
		this.r2_corporate = r2_corporate;
	}
	public BigDecimal getR2_gre() {
		return r2_gre;
	}
	public void setR2_gre(BigDecimal r2_gre) {
		this.r2_gre = r2_gre;
	}
	public BigDecimal getR2_trade() {
		return r2_trade;
	}
	public void setR2_trade(BigDecimal r2_trade) {
		this.r2_trade = r2_trade;
	}
	public BigDecimal getR2_individuals() {
		return r2_individuals;
	}
	public void setR2_individuals(BigDecimal r2_individuals) {
		this.r2_individuals = r2_individuals;
	}
	public BigDecimal getR2_investment() {
		return r2_investment;
	}
	public void setR2_investment(BigDecimal r2_investment) {
		this.r2_investment = r2_investment;
	}
	public BigDecimal getR2_nbfi1() {
		return r2_nbfi1;
	}
	public void setR2_nbfi1(BigDecimal r2_nbfi1) {
		this.r2_nbfi1 = r2_nbfi1;
	}
	public BigDecimal getR2_interbank1() {
		return r2_interbank1;
	}
	public void setR2_interbank1(BigDecimal r2_interbank1) {
		this.r2_interbank1 = r2_interbank1;
	}
	public BigDecimal getR2_gov1() {
		return r2_gov1;
	}
	public void setR2_gov1(BigDecimal r2_gov1) {
		this.r2_gov1 = r2_gov1;
	}
	public BigDecimal getR2_corporate1() {
		return r2_corporate1;
	}
	public void setR2_corporate1(BigDecimal r2_corporate1) {
		this.r2_corporate1 = r2_corporate1;
	}
	public BigDecimal getR2_gre1() {
		return r2_gre1;
	}
	public void setR2_gre1(BigDecimal r2_gre1) {
		this.r2_gre1 = r2_gre1;
	}
	public BigDecimal getR2_trade1() {
		return r2_trade1;
	}
	public void setR2_trade1(BigDecimal r2_trade1) {
		this.r2_trade1 = r2_trade1;
	}
	public BigDecimal getR2_individuals1() {
		return r2_individuals1;
	}
	public void setR2_individuals1(BigDecimal r2_individuals1) {
		this.r2_individuals1 = r2_individuals1;
	}
	public BigDecimal getR2_investment1() {
		return r2_investment1;
	}
	public void setR2_investment1(BigDecimal r2_investment1) {
		this.r2_investment1 = r2_investment1;
	}
	public BigDecimal getR2_zer0() {
		return r2_zer0;
	}
	public void setR2_zer0(BigDecimal r2_zer0) {
		this.r2_zer0 = r2_zer0;
	}
	public BigDecimal getR2_three() {
		return r2_three;
	}
	public void setR2_three(BigDecimal r2_three) {
		this.r2_three = r2_three;
	}
	public BigDecimal getR2_six() {
		return r2_six;
	}
	public void setR2_six(BigDecimal r2_six) {
		this.r2_six = r2_six;
	}
	public BigDecimal getR2_oneyear() {
		return r2_oneyear;
	}
	public void setR2_oneyear(BigDecimal r2_oneyear) {
		this.r2_oneyear = r2_oneyear;
	}
	public BigDecimal getR2_foreign() {
		return r2_foreign;
	}
	public void setR2_foreign(BigDecimal r2_foreign) {
		this.r2_foreign = r2_foreign;
	}
	public BigDecimal getR2_banks() {
		return r2_banks;
	}
	public void setR2_banks(BigDecimal r2_banks) {
		this.r2_banks = r2_banks;
	}
	public BigDecimal getR2_gov2() {
		return r2_gov2;
	}
	public void setR2_gov2(BigDecimal r2_gov2) {
		this.r2_gov2 = r2_gov2;
	}
	public BigDecimal getR2_other() {
		return r2_other;
	}
	public void setR2_other(BigDecimal r2_other) {
		this.r2_other = r2_other;
	}
	public BigDecimal getR2_banks1() {
		return r2_banks1;
	}
	public void setR2_banks1(BigDecimal r2_banks1) {
		this.r2_banks1 = r2_banks1;
	}
	public BigDecimal getR2_individuals2() {
		return r2_individuals2;
	}
	public void setR2_individuals2(BigDecimal r2_individuals2) {
		this.r2_individuals2 = r2_individuals2;
	}
	public BigDecimal getR2_other1() {
		return r2_other1;
	}
	public void setR2_other1(BigDecimal r2_other1) {
		this.r2_other1 = r2_other1;
	}
	public BigDecimal getR2_banks2() {
		return r2_banks2;
	}
	public void setR2_banks2(BigDecimal r2_banks2) {
		this.r2_banks2 = r2_banks2;
	}
	public BigDecimal getR2_gov3() {
		return r2_gov3;
	}
	public void setR2_gov3(BigDecimal r2_gov3) {
		this.r2_gov3 = r2_gov3;
	}
	public BigDecimal getR2_others2() {
		return r2_others2;
	}
	public void setR2_others2(BigDecimal r2_others2) {
		this.r2_others2 = r2_others2;
	}
	public BigDecimal getR2_banks3() {
		return r2_banks3;
	}
	public void setR2_banks3(BigDecimal r2_banks3) {
		this.r2_banks3 = r2_banks3;
	}
	public BigDecimal getR2_gov4() {
		return r2_gov4;
	}
	public void setR2_gov4(BigDecimal r2_gov4) {
		this.r2_gov4 = r2_gov4;
	}
	public BigDecimal getR2_others3() {
		return r2_others3;
	}
	public void setR2_others3(BigDecimal r2_others3) {
		this.r2_others3 = r2_others3;
	}
	public BigDecimal getR2_foreign1() {
		return r2_foreign1;
	}
	public void setR2_foreign1(BigDecimal r2_foreign1) {
		this.r2_foreign1 = r2_foreign1;
	}
	public BigDecimal getR2_guarantees() {
		return r2_guarantees;
	}
	public void setR2_guarantees(BigDecimal r2_guarantees) {
		this.r2_guarantees = r2_guarantees;
	}
	public BigDecimal getR2_nbfi2() {
		return r2_nbfi2;
	}
	public void setR2_nbfi2(BigDecimal r2_nbfi2) {
		this.r2_nbfi2 = r2_nbfi2;
	}
	public BigDecimal getR2_interbank2() {
		return r2_interbank2;
	}
	public void setR2_interbank2(BigDecimal r2_interbank2) {
		this.r2_interbank2 = r2_interbank2;
	}
	public BigDecimal getR2_gov5() {
		return r2_gov5;
	}
	public void setR2_gov5(BigDecimal r2_gov5) {
		this.r2_gov5 = r2_gov5;
	}
	public BigDecimal getR2_corporate2() {
		return r2_corporate2;
	}
	public void setR2_corporate2(BigDecimal r2_corporate2) {
		this.r2_corporate2 = r2_corporate2;
	}
	public BigDecimal getR2_gre2() {
		return r2_gre2;
	}
	public void setR2_gre2(BigDecimal r2_gre2) {
		this.r2_gre2 = r2_gre2;
	}
	public BigDecimal getR2_individuals3() {
		return r2_individuals3;
	}
	public void setR2_individuals3(BigDecimal r2_individuals3) {
		this.r2_individuals3 = r2_individuals3;
	}
	public BigDecimal getR2_zero1() {
		return r2_zero1;
	}
	public void setR2_zero1(BigDecimal r2_zero1) {
		this.r2_zero1 = r2_zero1;
	}
	public BigDecimal getR2_three1() {
		return r2_three1;
	}
	public void setR2_three1(BigDecimal r2_three1) {
		this.r2_three1 = r2_three1;
	}
	public BigDecimal getR2_six1() {
		return r2_six1;
	}
	public void setR2_six1(BigDecimal r2_six1) {
		this.r2_six1 = r2_six1;
	}
	public BigDecimal getR2_oneyear1() {
		return r2_oneyear1;
	}
	public void setR2_oneyear1(BigDecimal r2_oneyear1) {
		this.r2_oneyear1 = r2_oneyear1;
	}
	public String getR2_empty() {
		return r2_empty;
	}
	public void setR2_empty(String r2_empty) {
		this.r2_empty = r2_empty;
	}
	public String getR3_product() {
		return r3_product;
	}
	public void setR3_product(String r3_product) {
		this.r3_product = r3_product;
	}
	public BigDecimal getR3_nbfi() {
		return r3_nbfi;
	}
	public void setR3_nbfi(BigDecimal r3_nbfi) {
		this.r3_nbfi = r3_nbfi;
	}
	public BigDecimal getR3_interbank() {
		return r3_interbank;
	}
	public void setR3_interbank(BigDecimal r3_interbank) {
		this.r3_interbank = r3_interbank;
	}
	public BigDecimal getR3_gov() {
		return r3_gov;
	}
	public void setR3_gov(BigDecimal r3_gov) {
		this.r3_gov = r3_gov;
	}
	public BigDecimal getR3_corporate() {
		return r3_corporate;
	}
	public void setR3_corporate(BigDecimal r3_corporate) {
		this.r3_corporate = r3_corporate;
	}
	public BigDecimal getR3_gre() {
		return r3_gre;
	}
	public void setR3_gre(BigDecimal r3_gre) {
		this.r3_gre = r3_gre;
	}
	public BigDecimal getR3_trade() {
		return r3_trade;
	}
	public void setR3_trade(BigDecimal r3_trade) {
		this.r3_trade = r3_trade;
	}
	public BigDecimal getR3_individuals() {
		return r3_individuals;
	}
	public void setR3_individuals(BigDecimal r3_individuals) {
		this.r3_individuals = r3_individuals;
	}
	public BigDecimal getR3_investment() {
		return r3_investment;
	}
	public void setR3_investment(BigDecimal r3_investment) {
		this.r3_investment = r3_investment;
	}
	public BigDecimal getR3_nbfi1() {
		return r3_nbfi1;
	}
	public void setR3_nbfi1(BigDecimal r3_nbfi1) {
		this.r3_nbfi1 = r3_nbfi1;
	}
	public BigDecimal getR3_interbank1() {
		return r3_interbank1;
	}
	public void setR3_interbank1(BigDecimal r3_interbank1) {
		this.r3_interbank1 = r3_interbank1;
	}
	public BigDecimal getR3_gov1() {
		return r3_gov1;
	}
	public void setR3_gov1(BigDecimal r3_gov1) {
		this.r3_gov1 = r3_gov1;
	}
	public BigDecimal getR3_corporate1() {
		return r3_corporate1;
	}
	public void setR3_corporate1(BigDecimal r3_corporate1) {
		this.r3_corporate1 = r3_corporate1;
	}
	public BigDecimal getR3_gre1() {
		return r3_gre1;
	}
	public void setR3_gre1(BigDecimal r3_gre1) {
		this.r3_gre1 = r3_gre1;
	}
	public BigDecimal getR3_trade1() {
		return r3_trade1;
	}
	public void setR3_trade1(BigDecimal r3_trade1) {
		this.r3_trade1 = r3_trade1;
	}
	public BigDecimal getR3_individuals1() {
		return r3_individuals1;
	}
	public void setR3_individuals1(BigDecimal r3_individuals1) {
		this.r3_individuals1 = r3_individuals1;
	}
	public BigDecimal getR3_investment1() {
		return r3_investment1;
	}
	public void setR3_investment1(BigDecimal r3_investment1) {
		this.r3_investment1 = r3_investment1;
	}
	public BigDecimal getR3_zer0() {
		return r3_zer0;
	}
	public void setR3_zer0(BigDecimal r3_zer0) {
		this.r3_zer0 = r3_zer0;
	}
	public BigDecimal getR3_three() {
		return r3_three;
	}
	public void setR3_three(BigDecimal r3_three) {
		this.r3_three = r3_three;
	}
	public BigDecimal getR3_six() {
		return r3_six;
	}
	public void setR3_six(BigDecimal r3_six) {
		this.r3_six = r3_six;
	}
	public BigDecimal getR3_oneyear() {
		return r3_oneyear;
	}
	public void setR3_oneyear(BigDecimal r3_oneyear) {
		this.r3_oneyear = r3_oneyear;
	}
	public BigDecimal getR3_foreign() {
		return r3_foreign;
	}
	public void setR3_foreign(BigDecimal r3_foreign) {
		this.r3_foreign = r3_foreign;
	}
	public BigDecimal getR3_banks() {
		return r3_banks;
	}
	public void setR3_banks(BigDecimal r3_banks) {
		this.r3_banks = r3_banks;
	}
	public BigDecimal getR3_gov2() {
		return r3_gov2;
	}
	public void setR3_gov2(BigDecimal r3_gov2) {
		this.r3_gov2 = r3_gov2;
	}
	public BigDecimal getR3_other() {
		return r3_other;
	}
	public void setR3_other(BigDecimal r3_other) {
		this.r3_other = r3_other;
	}
	public BigDecimal getR3_banks1() {
		return r3_banks1;
	}
	public void setR3_banks1(BigDecimal r3_banks1) {
		this.r3_banks1 = r3_banks1;
	}
	public BigDecimal getR3_individuals2() {
		return r3_individuals2;
	}
	public void setR3_individuals2(BigDecimal r3_individuals2) {
		this.r3_individuals2 = r3_individuals2;
	}
	public BigDecimal getR3_other1() {
		return r3_other1;
	}
	public void setR3_other1(BigDecimal r3_other1) {
		this.r3_other1 = r3_other1;
	}
	public BigDecimal getR3_banks2() {
		return r3_banks2;
	}
	public void setR3_banks2(BigDecimal r3_banks2) {
		this.r3_banks2 = r3_banks2;
	}
	public BigDecimal getR3_gov3() {
		return r3_gov3;
	}
	public void setR3_gov3(BigDecimal r3_gov3) {
		this.r3_gov3 = r3_gov3;
	}
	public BigDecimal getR3_others2() {
		return r3_others2;
	}
	public void setR3_others2(BigDecimal r3_others2) {
		this.r3_others2 = r3_others2;
	}
	public BigDecimal getR3_banks3() {
		return r3_banks3;
	}
	public void setR3_banks3(BigDecimal r3_banks3) {
		this.r3_banks3 = r3_banks3;
	}
	public BigDecimal getR3_gov4() {
		return r3_gov4;
	}
	public void setR3_gov4(BigDecimal r3_gov4) {
		this.r3_gov4 = r3_gov4;
	}
	public BigDecimal getR3_others3() {
		return r3_others3;
	}
	public void setR3_others3(BigDecimal r3_others3) {
		this.r3_others3 = r3_others3;
	}
	public BigDecimal getR3_foreign1() {
		return r3_foreign1;
	}
	public void setR3_foreign1(BigDecimal r3_foreign1) {
		this.r3_foreign1 = r3_foreign1;
	}
	public BigDecimal getR3_guarantees() {
		return r3_guarantees;
	}
	public void setR3_guarantees(BigDecimal r3_guarantees) {
		this.r3_guarantees = r3_guarantees;
	}
	public BigDecimal getR3_nbfi2() {
		return r3_nbfi2;
	}
	public void setR3_nbfi2(BigDecimal r3_nbfi2) {
		this.r3_nbfi2 = r3_nbfi2;
	}
	public BigDecimal getR3_interbank2() {
		return r3_interbank2;
	}
	public void setR3_interbank2(BigDecimal r3_interbank2) {
		this.r3_interbank2 = r3_interbank2;
	}
	public BigDecimal getR3_gov5() {
		return r3_gov5;
	}
	public void setR3_gov5(BigDecimal r3_gov5) {
		this.r3_gov5 = r3_gov5;
	}
	public BigDecimal getR3_corporate2() {
		return r3_corporate2;
	}
	public void setR3_corporate2(BigDecimal r3_corporate2) {
		this.r3_corporate2 = r3_corporate2;
	}
	public BigDecimal getR3_gre2() {
		return r3_gre2;
	}
	public void setR3_gre2(BigDecimal r3_gre2) {
		this.r3_gre2 = r3_gre2;
	}
	public BigDecimal getR3_individuals3() {
		return r3_individuals3;
	}
	public void setR3_individuals3(BigDecimal r3_individuals3) {
		this.r3_individuals3 = r3_individuals3;
	}
	public BigDecimal getR3_zero1() {
		return r3_zero1;
	}
	public void setR3_zero1(BigDecimal r3_zero1) {
		this.r3_zero1 = r3_zero1;
	}
	public BigDecimal getR3_three1() {
		return r3_three1;
	}
	public void setR3_three1(BigDecimal r3_three1) {
		this.r3_three1 = r3_three1;
	}
	public BigDecimal getR3_six1() {
		return r3_six1;
	}
	public void setR3_six1(BigDecimal r3_six1) {
		this.r3_six1 = r3_six1;
	}
	public BigDecimal getR3_oneyear1() {
		return r3_oneyear1;
	}
	public void setR3_oneyear1(BigDecimal r3_oneyear1) {
		this.r3_oneyear1 = r3_oneyear1;
	}
	public String getR3_empty() {
		return r3_empty;
	}
	public void setR3_empty(String r3_empty) {
		this.r3_empty = r3_empty;
	}
	public String getR4_product() {
		return r4_product;
	}
	public void setR4_product(String r4_product) {
		this.r4_product = r4_product;
	}
	public BigDecimal getR4_nbfi() {
		return r4_nbfi;
	}
	public void setR4_nbfi(BigDecimal r4_nbfi) {
		this.r4_nbfi = r4_nbfi;
	}
	public BigDecimal getR4_interbank() {
		return r4_interbank;
	}
	public void setR4_interbank(BigDecimal r4_interbank) {
		this.r4_interbank = r4_interbank;
	}
	public BigDecimal getR4_gov() {
		return r4_gov;
	}
	public void setR4_gov(BigDecimal r4_gov) {
		this.r4_gov = r4_gov;
	}
	public BigDecimal getR4_corporate() {
		return r4_corporate;
	}
	public void setR4_corporate(BigDecimal r4_corporate) {
		this.r4_corporate = r4_corporate;
	}
	public BigDecimal getR4_gre() {
		return r4_gre;
	}
	public void setR4_gre(BigDecimal r4_gre) {
		this.r4_gre = r4_gre;
	}
	public BigDecimal getR4_trade() {
		return r4_trade;
	}
	public void setR4_trade(BigDecimal r4_trade) {
		this.r4_trade = r4_trade;
	}
	public BigDecimal getR4_individuals() {
		return r4_individuals;
	}
	public void setR4_individuals(BigDecimal r4_individuals) {
		this.r4_individuals = r4_individuals;
	}
	public BigDecimal getR4_investment() {
		return r4_investment;
	}
	public void setR4_investment(BigDecimal r4_investment) {
		this.r4_investment = r4_investment;
	}
	public BigDecimal getR4_nbfi1() {
		return r4_nbfi1;
	}
	public void setR4_nbfi1(BigDecimal r4_nbfi1) {
		this.r4_nbfi1 = r4_nbfi1;
	}
	public BigDecimal getR4_interbank1() {
		return r4_interbank1;
	}
	public void setR4_interbank1(BigDecimal r4_interbank1) {
		this.r4_interbank1 = r4_interbank1;
	}
	public BigDecimal getR4_gov1() {
		return r4_gov1;
	}
	public void setR4_gov1(BigDecimal r4_gov1) {
		this.r4_gov1 = r4_gov1;
	}
	public BigDecimal getR4_corporate1() {
		return r4_corporate1;
	}
	public void setR4_corporate1(BigDecimal r4_corporate1) {
		this.r4_corporate1 = r4_corporate1;
	}
	public BigDecimal getR4_gre1() {
		return r4_gre1;
	}
	public void setR4_gre1(BigDecimal r4_gre1) {
		this.r4_gre1 = r4_gre1;
	}
	public BigDecimal getR4_trade1() {
		return r4_trade1;
	}
	public void setR4_trade1(BigDecimal r4_trade1) {
		this.r4_trade1 = r4_trade1;
	}
	public BigDecimal getR4_individuals1() {
		return r4_individuals1;
	}
	public void setR4_individuals1(BigDecimal r4_individuals1) {
		this.r4_individuals1 = r4_individuals1;
	}
	public BigDecimal getR4_investment1() {
		return r4_investment1;
	}
	public void setR4_investment1(BigDecimal r4_investment1) {
		this.r4_investment1 = r4_investment1;
	}
	public BigDecimal getR4_zer0() {
		return r4_zer0;
	}
	public void setR4_zer0(BigDecimal r4_zer0) {
		this.r4_zer0 = r4_zer0;
	}
	public BigDecimal getR4_three() {
		return r4_three;
	}
	public void setR4_three(BigDecimal r4_three) {
		this.r4_three = r4_three;
	}
	public BigDecimal getR4_six() {
		return r4_six;
	}
	public void setR4_six(BigDecimal r4_six) {
		this.r4_six = r4_six;
	}
	public BigDecimal getR4_oneyear() {
		return r4_oneyear;
	}
	public void setR4_oneyear(BigDecimal r4_oneyear) {
		this.r4_oneyear = r4_oneyear;
	}
	public BigDecimal getR4_foreign() {
		return r4_foreign;
	}
	public void setR4_foreign(BigDecimal r4_foreign) {
		this.r4_foreign = r4_foreign;
	}
	public BigDecimal getR4_banks() {
		return r4_banks;
	}
	public void setR4_banks(BigDecimal r4_banks) {
		this.r4_banks = r4_banks;
	}
	public BigDecimal getR4_gov2() {
		return r4_gov2;
	}
	public void setR4_gov2(BigDecimal r4_gov2) {
		this.r4_gov2 = r4_gov2;
	}
	public BigDecimal getR4_other() {
		return r4_other;
	}
	public void setR4_other(BigDecimal r4_other) {
		this.r4_other = r4_other;
	}
	public BigDecimal getR4_banks1() {
		return r4_banks1;
	}
	public void setR4_banks1(BigDecimal r4_banks1) {
		this.r4_banks1 = r4_banks1;
	}
	public BigDecimal getR4_individuals2() {
		return r4_individuals2;
	}
	public void setR4_individuals2(BigDecimal r4_individuals2) {
		this.r4_individuals2 = r4_individuals2;
	}
	public BigDecimal getR4_other1() {
		return r4_other1;
	}
	public void setR4_other1(BigDecimal r4_other1) {
		this.r4_other1 = r4_other1;
	}
	public BigDecimal getR4_banks2() {
		return r4_banks2;
	}
	public void setR4_banks2(BigDecimal r4_banks2) {
		this.r4_banks2 = r4_banks2;
	}
	public BigDecimal getR4_gov3() {
		return r4_gov3;
	}
	public void setR4_gov3(BigDecimal r4_gov3) {
		this.r4_gov3 = r4_gov3;
	}
	public BigDecimal getR4_others2() {
		return r4_others2;
	}
	public void setR4_others2(BigDecimal r4_others2) {
		this.r4_others2 = r4_others2;
	}
	public BigDecimal getR4_banks3() {
		return r4_banks3;
	}
	public void setR4_banks3(BigDecimal r4_banks3) {
		this.r4_banks3 = r4_banks3;
	}
	public BigDecimal getR4_gov4() {
		return r4_gov4;
	}
	public void setR4_gov4(BigDecimal r4_gov4) {
		this.r4_gov4 = r4_gov4;
	}
	public BigDecimal getR4_others3() {
		return r4_others3;
	}
	public void setR4_others3(BigDecimal r4_others3) {
		this.r4_others3 = r4_others3;
	}
	public BigDecimal getR4_foreign1() {
		return r4_foreign1;
	}
	public void setR4_foreign1(BigDecimal r4_foreign1) {
		this.r4_foreign1 = r4_foreign1;
	}
	public BigDecimal getR4_guarantees() {
		return r4_guarantees;
	}
	public void setR4_guarantees(BigDecimal r4_guarantees) {
		this.r4_guarantees = r4_guarantees;
	}
	public BigDecimal getR4_nbfi2() {
		return r4_nbfi2;
	}
	public void setR4_nbfi2(BigDecimal r4_nbfi2) {
		this.r4_nbfi2 = r4_nbfi2;
	}
	public BigDecimal getR4_interbank2() {
		return r4_interbank2;
	}
	public void setR4_interbank2(BigDecimal r4_interbank2) {
		this.r4_interbank2 = r4_interbank2;
	}
	public BigDecimal getR4_gov5() {
		return r4_gov5;
	}
	public void setR4_gov5(BigDecimal r4_gov5) {
		this.r4_gov5 = r4_gov5;
	}
	public BigDecimal getR4_corporate2() {
		return r4_corporate2;
	}
	public void setR4_corporate2(BigDecimal r4_corporate2) {
		this.r4_corporate2 = r4_corporate2;
	}
	public BigDecimal getR4_gre2() {
		return r4_gre2;
	}
	public void setR4_gre2(BigDecimal r4_gre2) {
		this.r4_gre2 = r4_gre2;
	}
	public BigDecimal getR4_individuals3() {
		return r4_individuals3;
	}
	public void setR4_individuals3(BigDecimal r4_individuals3) {
		this.r4_individuals3 = r4_individuals3;
	}
	public BigDecimal getR4_zero1() {
		return r4_zero1;
	}
	public void setR4_zero1(BigDecimal r4_zero1) {
		this.r4_zero1 = r4_zero1;
	}
	public BigDecimal getR4_three1() {
		return r4_three1;
	}
	public void setR4_three1(BigDecimal r4_three1) {
		this.r4_three1 = r4_three1;
	}
	public BigDecimal getR4_six1() {
		return r4_six1;
	}
	public void setR4_six1(BigDecimal r4_six1) {
		this.r4_six1 = r4_six1;
	}
	public BigDecimal getR4_oneyear1() {
		return r4_oneyear1;
	}
	public void setR4_oneyear1(BigDecimal r4_oneyear1) {
		this.r4_oneyear1 = r4_oneyear1;
	}
	public String getR4_empty() {
		return r4_empty;
	}
	public void setR4_empty(String r4_empty) {
		this.r4_empty = r4_empty;
	}
	public String getR5_product() {
		return r5_product;
	}
	public void setR5_product(String r5_product) {
		this.r5_product = r5_product;
	}
	public BigDecimal getR5_nbfi() {
		return r5_nbfi;
	}
	public void setR5_nbfi(BigDecimal r5_nbfi) {
		this.r5_nbfi = r5_nbfi;
	}
	public BigDecimal getR5_interbank() {
		return r5_interbank;
	}
	public void setR5_interbank(BigDecimal r5_interbank) {
		this.r5_interbank = r5_interbank;
	}
	public BigDecimal getR5_gov() {
		return r5_gov;
	}
	public void setR5_gov(BigDecimal r5_gov) {
		this.r5_gov = r5_gov;
	}
	public BigDecimal getR5_corporate() {
		return r5_corporate;
	}
	public void setR5_corporate(BigDecimal r5_corporate) {
		this.r5_corporate = r5_corporate;
	}
	public BigDecimal getR5_gre() {
		return r5_gre;
	}
	public void setR5_gre(BigDecimal r5_gre) {
		this.r5_gre = r5_gre;
	}
	public BigDecimal getR5_trade() {
		return r5_trade;
	}
	public void setR5_trade(BigDecimal r5_trade) {
		this.r5_trade = r5_trade;
	}
	public BigDecimal getR5_individuals() {
		return r5_individuals;
	}
	public void setR5_individuals(BigDecimal r5_individuals) {
		this.r5_individuals = r5_individuals;
	}
	public BigDecimal getR5_investment() {
		return r5_investment;
	}
	public void setR5_investment(BigDecimal r5_investment) {
		this.r5_investment = r5_investment;
	}
	public BigDecimal getR5_nbfi1() {
		return r5_nbfi1;
	}
	public void setR5_nbfi1(BigDecimal r5_nbfi1) {
		this.r5_nbfi1 = r5_nbfi1;
	}
	public BigDecimal getR5_interbank1() {
		return r5_interbank1;
	}
	public void setR5_interbank1(BigDecimal r5_interbank1) {
		this.r5_interbank1 = r5_interbank1;
	}
	public BigDecimal getR5_gov1() {
		return r5_gov1;
	}
	public void setR5_gov1(BigDecimal r5_gov1) {
		this.r5_gov1 = r5_gov1;
	}
	public BigDecimal getR5_corporate1() {
		return r5_corporate1;
	}
	public void setR5_corporate1(BigDecimal r5_corporate1) {
		this.r5_corporate1 = r5_corporate1;
	}
	public BigDecimal getR5_gre1() {
		return r5_gre1;
	}
	public void setR5_gre1(BigDecimal r5_gre1) {
		this.r5_gre1 = r5_gre1;
	}
	public BigDecimal getR5_trade1() {
		return r5_trade1;
	}
	public void setR5_trade1(BigDecimal r5_trade1) {
		this.r5_trade1 = r5_trade1;
	}
	public BigDecimal getR5_individuals1() {
		return r5_individuals1;
	}
	public void setR5_individuals1(BigDecimal r5_individuals1) {
		this.r5_individuals1 = r5_individuals1;
	}
	public BigDecimal getR5_investment1() {
		return r5_investment1;
	}
	public void setR5_investment1(BigDecimal r5_investment1) {
		this.r5_investment1 = r5_investment1;
	}
	public BigDecimal getR5_zer0() {
		return r5_zer0;
	}
	public void setR5_zer0(BigDecimal r5_zer0) {
		this.r5_zer0 = r5_zer0;
	}
	public BigDecimal getR5_three() {
		return r5_three;
	}
	public void setR5_three(BigDecimal r5_three) {
		this.r5_three = r5_three;
	}
	public BigDecimal getR5_six() {
		return r5_six;
	}
	public void setR5_six(BigDecimal r5_six) {
		this.r5_six = r5_six;
	}
	public BigDecimal getR5_oneyear() {
		return r5_oneyear;
	}
	public void setR5_oneyear(BigDecimal r5_oneyear) {
		this.r5_oneyear = r5_oneyear;
	}
	public BigDecimal getR5_foreign() {
		return r5_foreign;
	}
	public void setR5_foreign(BigDecimal r5_foreign) {
		this.r5_foreign = r5_foreign;
	}
	public BigDecimal getR5_banks() {
		return r5_banks;
	}
	public void setR5_banks(BigDecimal r5_banks) {
		this.r5_banks = r5_banks;
	}
	public BigDecimal getR5_gov2() {
		return r5_gov2;
	}
	public void setR5_gov2(BigDecimal r5_gov2) {
		this.r5_gov2 = r5_gov2;
	}
	public BigDecimal getR5_other() {
		return r5_other;
	}
	public void setR5_other(BigDecimal r5_other) {
		this.r5_other = r5_other;
	}
	public BigDecimal getR5_banks1() {
		return r5_banks1;
	}
	public void setR5_banks1(BigDecimal r5_banks1) {
		this.r5_banks1 = r5_banks1;
	}
	public BigDecimal getR5_individuals2() {
		return r5_individuals2;
	}
	public void setR5_individuals2(BigDecimal r5_individuals2) {
		this.r5_individuals2 = r5_individuals2;
	}
	public BigDecimal getR5_other1() {
		return r5_other1;
	}
	public void setR5_other1(BigDecimal r5_other1) {
		this.r5_other1 = r5_other1;
	}
	public BigDecimal getR5_banks2() {
		return r5_banks2;
	}
	public void setR5_banks2(BigDecimal r5_banks2) {
		this.r5_banks2 = r5_banks2;
	}
	public BigDecimal getR5_gov3() {
		return r5_gov3;
	}
	public void setR5_gov3(BigDecimal r5_gov3) {
		this.r5_gov3 = r5_gov3;
	}
	public BigDecimal getR5_others2() {
		return r5_others2;
	}
	public void setR5_others2(BigDecimal r5_others2) {
		this.r5_others2 = r5_others2;
	}
	public BigDecimal getR5_banks3() {
		return r5_banks3;
	}
	public void setR5_banks3(BigDecimal r5_banks3) {
		this.r5_banks3 = r5_banks3;
	}
	public BigDecimal getR5_gov4() {
		return r5_gov4;
	}
	public void setR5_gov4(BigDecimal r5_gov4) {
		this.r5_gov4 = r5_gov4;
	}
	public BigDecimal getR5_others3() {
		return r5_others3;
	}
	public void setR5_others3(BigDecimal r5_others3) {
		this.r5_others3 = r5_others3;
	}
	public BigDecimal getR5_foreign1() {
		return r5_foreign1;
	}
	public void setR5_foreign1(BigDecimal r5_foreign1) {
		this.r5_foreign1 = r5_foreign1;
	}
	public BigDecimal getR5_guarantees() {
		return r5_guarantees;
	}
	public void setR5_guarantees(BigDecimal r5_guarantees) {
		this.r5_guarantees = r5_guarantees;
	}
	public BigDecimal getR5_nbfi2() {
		return r5_nbfi2;
	}
	public void setR5_nbfi2(BigDecimal r5_nbfi2) {
		this.r5_nbfi2 = r5_nbfi2;
	}
	public BigDecimal getR5_interbank2() {
		return r5_interbank2;
	}
	public void setR5_interbank2(BigDecimal r5_interbank2) {
		this.r5_interbank2 = r5_interbank2;
	}
	public BigDecimal getR5_gov5() {
		return r5_gov5;
	}
	public void setR5_gov5(BigDecimal r5_gov5) {
		this.r5_gov5 = r5_gov5;
	}
	public BigDecimal getR5_corporate2() {
		return r5_corporate2;
	}
	public void setR5_corporate2(BigDecimal r5_corporate2) {
		this.r5_corporate2 = r5_corporate2;
	}
	public BigDecimal getR5_gre2() {
		return r5_gre2;
	}
	public void setR5_gre2(BigDecimal r5_gre2) {
		this.r5_gre2 = r5_gre2;
	}
	public BigDecimal getR5_individuals3() {
		return r5_individuals3;
	}
	public void setR5_individuals3(BigDecimal r5_individuals3) {
		this.r5_individuals3 = r5_individuals3;
	}
	public BigDecimal getR5_zero1() {
		return r5_zero1;
	}
	public void setR5_zero1(BigDecimal r5_zero1) {
		this.r5_zero1 = r5_zero1;
	}
	public BigDecimal getR5_three1() {
		return r5_three1;
	}
	public void setR5_three1(BigDecimal r5_three1) {
		this.r5_three1 = r5_three1;
	}
	public BigDecimal getR5_six1() {
		return r5_six1;
	}
	public void setR5_six1(BigDecimal r5_six1) {
		this.r5_six1 = r5_six1;
	}
	public BigDecimal getR5_oneyear1() {
		return r5_oneyear1;
	}
	public void setR5_oneyear1(BigDecimal r5_oneyear1) {
		this.r5_oneyear1 = r5_oneyear1;
	}
	public String getR5_empty() {
		return r5_empty;
	}
	public void setR5_empty(String r5_empty) {
		this.r5_empty = r5_empty;
	}
	public String getR6_product() {
		return r6_product;
	}
	public void setR6_product(String r6_product) {
		this.r6_product = r6_product;
	}
	public BigDecimal getR6_nbfi() {
		return r6_nbfi;
	}
	public void setR6_nbfi(BigDecimal r6_nbfi) {
		this.r6_nbfi = r6_nbfi;
	}
	public BigDecimal getR6_interbank() {
		return r6_interbank;
	}
	public void setR6_interbank(BigDecimal r6_interbank) {
		this.r6_interbank = r6_interbank;
	}
	public BigDecimal getR6_gov() {
		return r6_gov;
	}
	public void setR6_gov(BigDecimal r6_gov) {
		this.r6_gov = r6_gov;
	}
	public BigDecimal getR6_corporate() {
		return r6_corporate;
	}
	public void setR6_corporate(BigDecimal r6_corporate) {
		this.r6_corporate = r6_corporate;
	}
	public BigDecimal getR6_gre() {
		return r6_gre;
	}
	public void setR6_gre(BigDecimal r6_gre) {
		this.r6_gre = r6_gre;
	}
	public BigDecimal getR6_trade() {
		return r6_trade;
	}
	public void setR6_trade(BigDecimal r6_trade) {
		this.r6_trade = r6_trade;
	}
	public BigDecimal getR6_individuals() {
		return r6_individuals;
	}
	public void setR6_individuals(BigDecimal r6_individuals) {
		this.r6_individuals = r6_individuals;
	}
	public BigDecimal getR6_investment() {
		return r6_investment;
	}
	public void setR6_investment(BigDecimal r6_investment) {
		this.r6_investment = r6_investment;
	}
	public BigDecimal getR6_nbfi1() {
		return r6_nbfi1;
	}
	public void setR6_nbfi1(BigDecimal r6_nbfi1) {
		this.r6_nbfi1 = r6_nbfi1;
	}
	public BigDecimal getR6_interbank1() {
		return r6_interbank1;
	}
	public void setR6_interbank1(BigDecimal r6_interbank1) {
		this.r6_interbank1 = r6_interbank1;
	}
	public BigDecimal getR6_gov1() {
		return r6_gov1;
	}
	public void setR6_gov1(BigDecimal r6_gov1) {
		this.r6_gov1 = r6_gov1;
	}
	public BigDecimal getR6_corporate1() {
		return r6_corporate1;
	}
	public void setR6_corporate1(BigDecimal r6_corporate1) {
		this.r6_corporate1 = r6_corporate1;
	}
	public BigDecimal getR6_gre1() {
		return r6_gre1;
	}
	public void setR6_gre1(BigDecimal r6_gre1) {
		this.r6_gre1 = r6_gre1;
	}
	public BigDecimal getR6_trade1() {
		return r6_trade1;
	}
	public void setR6_trade1(BigDecimal r6_trade1) {
		this.r6_trade1 = r6_trade1;
	}
	public BigDecimal getR6_individuals1() {
		return r6_individuals1;
	}
	public void setR6_individuals1(BigDecimal r6_individuals1) {
		this.r6_individuals1 = r6_individuals1;
	}
	public BigDecimal getR6_investment1() {
		return r6_investment1;
	}
	public void setR6_investment1(BigDecimal r6_investment1) {
		this.r6_investment1 = r6_investment1;
	}
	public BigDecimal getR6_zer0() {
		return r6_zer0;
	}
	public void setR6_zer0(BigDecimal r6_zer0) {
		this.r6_zer0 = r6_zer0;
	}
	public BigDecimal getR6_three() {
		return r6_three;
	}
	public void setR6_three(BigDecimal r6_three) {
		this.r6_three = r6_three;
	}
	public BigDecimal getR6_six() {
		return r6_six;
	}
	public void setR6_six(BigDecimal r6_six) {
		this.r6_six = r6_six;
	}
	public BigDecimal getR6_oneyear() {
		return r6_oneyear;
	}
	public void setR6_oneyear(BigDecimal r6_oneyear) {
		this.r6_oneyear = r6_oneyear;
	}
	public BigDecimal getR6_foreign() {
		return r6_foreign;
	}
	public void setR6_foreign(BigDecimal r6_foreign) {
		this.r6_foreign = r6_foreign;
	}
	public BigDecimal getR6_banks() {
		return r6_banks;
	}
	public void setR6_banks(BigDecimal r6_banks) {
		this.r6_banks = r6_banks;
	}
	public BigDecimal getR6_gov2() {
		return r6_gov2;
	}
	public void setR6_gov2(BigDecimal r6_gov2) {
		this.r6_gov2 = r6_gov2;
	}
	public BigDecimal getR6_other() {
		return r6_other;
	}
	public void setR6_other(BigDecimal r6_other) {
		this.r6_other = r6_other;
	}
	public BigDecimal getR6_banks1() {
		return r6_banks1;
	}
	public void setR6_banks1(BigDecimal r6_banks1) {
		this.r6_banks1 = r6_banks1;
	}
	public BigDecimal getR6_individuals2() {
		return r6_individuals2;
	}
	public void setR6_individuals2(BigDecimal r6_individuals2) {
		this.r6_individuals2 = r6_individuals2;
	}
	public BigDecimal getR6_other1() {
		return r6_other1;
	}
	public void setR6_other1(BigDecimal r6_other1) {
		this.r6_other1 = r6_other1;
	}
	public BigDecimal getR6_banks2() {
		return r6_banks2;
	}
	public void setR6_banks2(BigDecimal r6_banks2) {
		this.r6_banks2 = r6_banks2;
	}
	public BigDecimal getR6_gov3() {
		return r6_gov3;
	}
	public void setR6_gov3(BigDecimal r6_gov3) {
		this.r6_gov3 = r6_gov3;
	}
	public BigDecimal getR6_others2() {
		return r6_others2;
	}
	public void setR6_others2(BigDecimal r6_others2) {
		this.r6_others2 = r6_others2;
	}
	public BigDecimal getR6_banks3() {
		return r6_banks3;
	}
	public void setR6_banks3(BigDecimal r6_banks3) {
		this.r6_banks3 = r6_banks3;
	}
	public BigDecimal getR6_gov4() {
		return r6_gov4;
	}
	public void setR6_gov4(BigDecimal r6_gov4) {
		this.r6_gov4 = r6_gov4;
	}
	public BigDecimal getR6_others3() {
		return r6_others3;
	}
	public void setR6_others3(BigDecimal r6_others3) {
		this.r6_others3 = r6_others3;
	}
	public BigDecimal getR6_foreign1() {
		return r6_foreign1;
	}
	public void setR6_foreign1(BigDecimal r6_foreign1) {
		this.r6_foreign1 = r6_foreign1;
	}
	public BigDecimal getR6_guarantees() {
		return r6_guarantees;
	}
	public void setR6_guarantees(BigDecimal r6_guarantees) {
		this.r6_guarantees = r6_guarantees;
	}
	public BigDecimal getR6_nbfi2() {
		return r6_nbfi2;
	}
	public void setR6_nbfi2(BigDecimal r6_nbfi2) {
		this.r6_nbfi2 = r6_nbfi2;
	}
	public BigDecimal getR6_interbank2() {
		return r6_interbank2;
	}
	public void setR6_interbank2(BigDecimal r6_interbank2) {
		this.r6_interbank2 = r6_interbank2;
	}
	public BigDecimal getR6_gov5() {
		return r6_gov5;
	}
	public void setR6_gov5(BigDecimal r6_gov5) {
		this.r6_gov5 = r6_gov5;
	}
	public BigDecimal getR6_corporate2() {
		return r6_corporate2;
	}
	public void setR6_corporate2(BigDecimal r6_corporate2) {
		this.r6_corporate2 = r6_corporate2;
	}
	public BigDecimal getR6_gre2() {
		return r6_gre2;
	}
	public void setR6_gre2(BigDecimal r6_gre2) {
		this.r6_gre2 = r6_gre2;
	}
	public BigDecimal getR6_individuals3() {
		return r6_individuals3;
	}
	public void setR6_individuals3(BigDecimal r6_individuals3) {
		this.r6_individuals3 = r6_individuals3;
	}
	public BigDecimal getR6_zero1() {
		return r6_zero1;
	}
	public void setR6_zero1(BigDecimal r6_zero1) {
		this.r6_zero1 = r6_zero1;
	}
	public BigDecimal getR6_three1() {
		return r6_three1;
	}
	public void setR6_three1(BigDecimal r6_three1) {
		this.r6_three1 = r6_three1;
	}
	public BigDecimal getR6_six1() {
		return r6_six1;
	}
	public void setR6_six1(BigDecimal r6_six1) {
		this.r6_six1 = r6_six1;
	}
	public BigDecimal getR6_oneyear1() {
		return r6_oneyear1;
	}
	public void setR6_oneyear1(BigDecimal r6_oneyear1) {
		this.r6_oneyear1 = r6_oneyear1;
	}
	public String getR6_empty() {
		return r6_empty;
	}
	public void setR6_empty(String r6_empty) {
		this.r6_empty = r6_empty;
	}
	public String getR7_product() {
		return r7_product;
	}
	public void setR7_product(String r7_product) {
		this.r7_product = r7_product;
	}
	public BigDecimal getR7_nbfi() {
		return r7_nbfi;
	}
	public void setR7_nbfi(BigDecimal r7_nbfi) {
		this.r7_nbfi = r7_nbfi;
	}
	public BigDecimal getR7_interbank() {
		return r7_interbank;
	}
	public void setR7_interbank(BigDecimal r7_interbank) {
		this.r7_interbank = r7_interbank;
	}
	public BigDecimal getR7_gov() {
		return r7_gov;
	}
	public void setR7_gov(BigDecimal r7_gov) {
		this.r7_gov = r7_gov;
	}
	public BigDecimal getR7_corporate() {
		return r7_corporate;
	}
	public void setR7_corporate(BigDecimal r7_corporate) {
		this.r7_corporate = r7_corporate;
	}
	public BigDecimal getR7_gre() {
		return r7_gre;
	}
	public void setR7_gre(BigDecimal r7_gre) {
		this.r7_gre = r7_gre;
	}
	public BigDecimal getR7_trade() {
		return r7_trade;
	}
	public void setR7_trade(BigDecimal r7_trade) {
		this.r7_trade = r7_trade;
	}
	public BigDecimal getR7_individuals() {
		return r7_individuals;
	}
	public void setR7_individuals(BigDecimal r7_individuals) {
		this.r7_individuals = r7_individuals;
	}
	public BigDecimal getR7_investment() {
		return r7_investment;
	}
	public void setR7_investment(BigDecimal r7_investment) {
		this.r7_investment = r7_investment;
	}
	public BigDecimal getR7_nbfi1() {
		return r7_nbfi1;
	}
	public void setR7_nbfi1(BigDecimal r7_nbfi1) {
		this.r7_nbfi1 = r7_nbfi1;
	}
	public BigDecimal getR7_interbank1() {
		return r7_interbank1;
	}
	public void setR7_interbank1(BigDecimal r7_interbank1) {
		this.r7_interbank1 = r7_interbank1;
	}
	public BigDecimal getR7_gov1() {
		return r7_gov1;
	}
	public void setR7_gov1(BigDecimal r7_gov1) {
		this.r7_gov1 = r7_gov1;
	}
	public BigDecimal getR7_corporate1() {
		return r7_corporate1;
	}
	public void setR7_corporate1(BigDecimal r7_corporate1) {
		this.r7_corporate1 = r7_corporate1;
	}
	public BigDecimal getR7_gre1() {
		return r7_gre1;
	}
	public void setR7_gre1(BigDecimal r7_gre1) {
		this.r7_gre1 = r7_gre1;
	}
	public BigDecimal getR7_trade1() {
		return r7_trade1;
	}
	public void setR7_trade1(BigDecimal r7_trade1) {
		this.r7_trade1 = r7_trade1;
	}
	public BigDecimal getR7_individuals1() {
		return r7_individuals1;
	}
	public void setR7_individuals1(BigDecimal r7_individuals1) {
		this.r7_individuals1 = r7_individuals1;
	}
	public BigDecimal getR7_investment1() {
		return r7_investment1;
	}
	public void setR7_investment1(BigDecimal r7_investment1) {
		this.r7_investment1 = r7_investment1;
	}
	public BigDecimal getR7_zer0() {
		return r7_zer0;
	}
	public void setR7_zer0(BigDecimal r7_zer0) {
		this.r7_zer0 = r7_zer0;
	}
	public BigDecimal getR7_three() {
		return r7_three;
	}
	public void setR7_three(BigDecimal r7_three) {
		this.r7_three = r7_three;
	}
	public BigDecimal getR7_six() {
		return r7_six;
	}
	public void setR7_six(BigDecimal r7_six) {
		this.r7_six = r7_six;
	}
	public BigDecimal getR7_oneyear() {
		return r7_oneyear;
	}
	public void setR7_oneyear(BigDecimal r7_oneyear) {
		this.r7_oneyear = r7_oneyear;
	}
	public BigDecimal getR7_foreign() {
		return r7_foreign;
	}
	public void setR7_foreign(BigDecimal r7_foreign) {
		this.r7_foreign = r7_foreign;
	}
	public BigDecimal getR7_banks() {
		return r7_banks;
	}
	public void setR7_banks(BigDecimal r7_banks) {
		this.r7_banks = r7_banks;
	}
	public BigDecimal getR7_gov2() {
		return r7_gov2;
	}
	public void setR7_gov2(BigDecimal r7_gov2) {
		this.r7_gov2 = r7_gov2;
	}
	public BigDecimal getR7_other() {
		return r7_other;
	}
	public void setR7_other(BigDecimal r7_other) {
		this.r7_other = r7_other;
	}
	public BigDecimal getR7_banks1() {
		return r7_banks1;
	}
	public void setR7_banks1(BigDecimal r7_banks1) {
		this.r7_banks1 = r7_banks1;
	}
	public BigDecimal getR7_individuals2() {
		return r7_individuals2;
	}
	public void setR7_individuals2(BigDecimal r7_individuals2) {
		this.r7_individuals2 = r7_individuals2;
	}
	public BigDecimal getR7_other1() {
		return r7_other1;
	}
	public void setR7_other1(BigDecimal r7_other1) {
		this.r7_other1 = r7_other1;
	}
	public BigDecimal getR7_banks2() {
		return r7_banks2;
	}
	public void setR7_banks2(BigDecimal r7_banks2) {
		this.r7_banks2 = r7_banks2;
	}
	public BigDecimal getR7_gov3() {
		return r7_gov3;
	}
	public void setR7_gov3(BigDecimal r7_gov3) {
		this.r7_gov3 = r7_gov3;
	}
	public BigDecimal getR7_others2() {
		return r7_others2;
	}
	public void setR7_others2(BigDecimal r7_others2) {
		this.r7_others2 = r7_others2;
	}
	public BigDecimal getR7_banks3() {
		return r7_banks3;
	}
	public void setR7_banks3(BigDecimal r7_banks3) {
		this.r7_banks3 = r7_banks3;
	}
	public BigDecimal getR7_gov4() {
		return r7_gov4;
	}
	public void setR7_gov4(BigDecimal r7_gov4) {
		this.r7_gov4 = r7_gov4;
	}
	public BigDecimal getR7_others3() {
		return r7_others3;
	}
	public void setR7_others3(BigDecimal r7_others3) {
		this.r7_others3 = r7_others3;
	}
	public BigDecimal getR7_foreign1() {
		return r7_foreign1;
	}
	public void setR7_foreign1(BigDecimal r7_foreign1) {
		this.r7_foreign1 = r7_foreign1;
	}
	public BigDecimal getR7_guarantees() {
		return r7_guarantees;
	}
	public void setR7_guarantees(BigDecimal r7_guarantees) {
		this.r7_guarantees = r7_guarantees;
	}
	public BigDecimal getR7_nbfi2() {
		return r7_nbfi2;
	}
	public void setR7_nbfi2(BigDecimal r7_nbfi2) {
		this.r7_nbfi2 = r7_nbfi2;
	}
	public BigDecimal getR7_interbank2() {
		return r7_interbank2;
	}
	public void setR7_interbank2(BigDecimal r7_interbank2) {
		this.r7_interbank2 = r7_interbank2;
	}
	public BigDecimal getR7_gov5() {
		return r7_gov5;
	}
	public void setR7_gov5(BigDecimal r7_gov5) {
		this.r7_gov5 = r7_gov5;
	}
	public BigDecimal getR7_corporate2() {
		return r7_corporate2;
	}
	public void setR7_corporate2(BigDecimal r7_corporate2) {
		this.r7_corporate2 = r7_corporate2;
	}
	public BigDecimal getR7_gre2() {
		return r7_gre2;
	}
	public void setR7_gre2(BigDecimal r7_gre2) {
		this.r7_gre2 = r7_gre2;
	}
	public BigDecimal getR7_individuals3() {
		return r7_individuals3;
	}
	public void setR7_individuals3(BigDecimal r7_individuals3) {
		this.r7_individuals3 = r7_individuals3;
	}
	public BigDecimal getR7_zero1() {
		return r7_zero1;
	}
	public void setR7_zero1(BigDecimal r7_zero1) {
		this.r7_zero1 = r7_zero1;
	}
	public BigDecimal getR7_three1() {
		return r7_three1;
	}
	public void setR7_three1(BigDecimal r7_three1) {
		this.r7_three1 = r7_three1;
	}
	public BigDecimal getR7_six1() {
		return r7_six1;
	}
	public void setR7_six1(BigDecimal r7_six1) {
		this.r7_six1 = r7_six1;
	}
	public BigDecimal getR7_oneyear1() {
		return r7_oneyear1;
	}
	public void setR7_oneyear1(BigDecimal r7_oneyear1) {
		this.r7_oneyear1 = r7_oneyear1;
	}
	public String getR7_empty() {
		return r7_empty;
	}
	public void setR7_empty(String r7_empty) {
		this.r7_empty = r7_empty;
	}
	public String getR8_product() {
		return r8_product;
	}
	public void setR8_product(String r8_product) {
		this.r8_product = r8_product;
	}
	public BigDecimal getR8_nbfi() {
		return r8_nbfi;
	}
	public void setR8_nbfi(BigDecimal r8_nbfi) {
		this.r8_nbfi = r8_nbfi;
	}
	public BigDecimal getR8_interbank() {
		return r8_interbank;
	}
	public void setR8_interbank(BigDecimal r8_interbank) {
		this.r8_interbank = r8_interbank;
	}
	public BigDecimal getR8_gov() {
		return r8_gov;
	}
	public void setR8_gov(BigDecimal r8_gov) {
		this.r8_gov = r8_gov;
	}
	public BigDecimal getR8_corporate() {
		return r8_corporate;
	}
	public void setR8_corporate(BigDecimal r8_corporate) {
		this.r8_corporate = r8_corporate;
	}
	public BigDecimal getR8_gre() {
		return r8_gre;
	}
	public void setR8_gre(BigDecimal r8_gre) {
		this.r8_gre = r8_gre;
	}
	public BigDecimal getR8_trade() {
		return r8_trade;
	}
	public void setR8_trade(BigDecimal r8_trade) {
		this.r8_trade = r8_trade;
	}
	public BigDecimal getR8_individuals() {
		return r8_individuals;
	}
	public void setR8_individuals(BigDecimal r8_individuals) {
		this.r8_individuals = r8_individuals;
	}
	public BigDecimal getR8_investment() {
		return r8_investment;
	}
	public void setR8_investment(BigDecimal r8_investment) {
		this.r8_investment = r8_investment;
	}
	public BigDecimal getR8_nbfi1() {
		return r8_nbfi1;
	}
	public void setR8_nbfi1(BigDecimal r8_nbfi1) {
		this.r8_nbfi1 = r8_nbfi1;
	}
	public BigDecimal getR8_interbank1() {
		return r8_interbank1;
	}
	public void setR8_interbank1(BigDecimal r8_interbank1) {
		this.r8_interbank1 = r8_interbank1;
	}
	public BigDecimal getR8_gov1() {
		return r8_gov1;
	}
	public void setR8_gov1(BigDecimal r8_gov1) {
		this.r8_gov1 = r8_gov1;
	}
	public BigDecimal getR8_corporate1() {
		return r8_corporate1;
	}
	public void setR8_corporate1(BigDecimal r8_corporate1) {
		this.r8_corporate1 = r8_corporate1;
	}
	public BigDecimal getR8_gre1() {
		return r8_gre1;
	}
	public void setR8_gre1(BigDecimal r8_gre1) {
		this.r8_gre1 = r8_gre1;
	}
	public BigDecimal getR8_trade1() {
		return r8_trade1;
	}
	public void setR8_trade1(BigDecimal r8_trade1) {
		this.r8_trade1 = r8_trade1;
	}
	public BigDecimal getR8_individuals1() {
		return r8_individuals1;
	}
	public void setR8_individuals1(BigDecimal r8_individuals1) {
		this.r8_individuals1 = r8_individuals1;
	}
	public BigDecimal getR8_investment1() {
		return r8_investment1;
	}
	public void setR8_investment1(BigDecimal r8_investment1) {
		this.r8_investment1 = r8_investment1;
	}
	public BigDecimal getR8_zer0() {
		return r8_zer0;
	}
	public void setR8_zer0(BigDecimal r8_zer0) {
		this.r8_zer0 = r8_zer0;
	}
	public BigDecimal getR8_three() {
		return r8_three;
	}
	public void setR8_three(BigDecimal r8_three) {
		this.r8_three = r8_three;
	}
	public BigDecimal getR8_six() {
		return r8_six;
	}
	public void setR8_six(BigDecimal r8_six) {
		this.r8_six = r8_six;
	}
	public BigDecimal getR8_oneyear() {
		return r8_oneyear;
	}
	public void setR8_oneyear(BigDecimal r8_oneyear) {
		this.r8_oneyear = r8_oneyear;
	}
	public BigDecimal getR8_foreign() {
		return r8_foreign;
	}
	public void setR8_foreign(BigDecimal r8_foreign) {
		this.r8_foreign = r8_foreign;
	}
	public BigDecimal getR8_banks() {
		return r8_banks;
	}
	public void setR8_banks(BigDecimal r8_banks) {
		this.r8_banks = r8_banks;
	}
	public BigDecimal getR8_gov2() {
		return r8_gov2;
	}
	public void setR8_gov2(BigDecimal r8_gov2) {
		this.r8_gov2 = r8_gov2;
	}
	public BigDecimal getR8_other() {
		return r8_other;
	}
	public void setR8_other(BigDecimal r8_other) {
		this.r8_other = r8_other;
	}
	public BigDecimal getR8_banks1() {
		return r8_banks1;
	}
	public void setR8_banks1(BigDecimal r8_banks1) {
		this.r8_banks1 = r8_banks1;
	}
	public BigDecimal getR8_individuals2() {
		return r8_individuals2;
	}
	public void setR8_individuals2(BigDecimal r8_individuals2) {
		this.r8_individuals2 = r8_individuals2;
	}
	public BigDecimal getR8_other1() {
		return r8_other1;
	}
	public void setR8_other1(BigDecimal r8_other1) {
		this.r8_other1 = r8_other1;
	}
	public BigDecimal getR8_banks2() {
		return r8_banks2;
	}
	public void setR8_banks2(BigDecimal r8_banks2) {
		this.r8_banks2 = r8_banks2;
	}
	public BigDecimal getR8_gov3() {
		return r8_gov3;
	}
	public void setR8_gov3(BigDecimal r8_gov3) {
		this.r8_gov3 = r8_gov3;
	}
	public BigDecimal getR8_others2() {
		return r8_others2;
	}
	public void setR8_others2(BigDecimal r8_others2) {
		this.r8_others2 = r8_others2;
	}
	public BigDecimal getR8_banks3() {
		return r8_banks3;
	}
	public void setR8_banks3(BigDecimal r8_banks3) {
		this.r8_banks3 = r8_banks3;
	}
	public BigDecimal getR8_gov4() {
		return r8_gov4;
	}
	public void setR8_gov4(BigDecimal r8_gov4) {
		this.r8_gov4 = r8_gov4;
	}
	public BigDecimal getR8_others3() {
		return r8_others3;
	}
	public void setR8_others3(BigDecimal r8_others3) {
		this.r8_others3 = r8_others3;
	}
	public BigDecimal getR8_foreign1() {
		return r8_foreign1;
	}
	public void setR8_foreign1(BigDecimal r8_foreign1) {
		this.r8_foreign1 = r8_foreign1;
	}
	public BigDecimal getR8_guarantees() {
		return r8_guarantees;
	}
	public void setR8_guarantees(BigDecimal r8_guarantees) {
		this.r8_guarantees = r8_guarantees;
	}
	public BigDecimal getR8_nbfi2() {
		return r8_nbfi2;
	}
	public void setR8_nbfi2(BigDecimal r8_nbfi2) {
		this.r8_nbfi2 = r8_nbfi2;
	}
	public BigDecimal getR8_interbank2() {
		return r8_interbank2;
	}
	public void setR8_interbank2(BigDecimal r8_interbank2) {
		this.r8_interbank2 = r8_interbank2;
	}
	public BigDecimal getR8_gov5() {
		return r8_gov5;
	}
	public void setR8_gov5(BigDecimal r8_gov5) {
		this.r8_gov5 = r8_gov5;
	}
	public BigDecimal getR8_corporate2() {
		return r8_corporate2;
	}
	public void setR8_corporate2(BigDecimal r8_corporate2) {
		this.r8_corporate2 = r8_corporate2;
	}
	public BigDecimal getR8_gre2() {
		return r8_gre2;
	}
	public void setR8_gre2(BigDecimal r8_gre2) {
		this.r8_gre2 = r8_gre2;
	}
	public BigDecimal getR8_individuals3() {
		return r8_individuals3;
	}
	public void setR8_individuals3(BigDecimal r8_individuals3) {
		this.r8_individuals3 = r8_individuals3;
	}
	public BigDecimal getR8_zero1() {
		return r8_zero1;
	}
	public void setR8_zero1(BigDecimal r8_zero1) {
		this.r8_zero1 = r8_zero1;
	}
	public BigDecimal getR8_three1() {
		return r8_three1;
	}
	public void setR8_three1(BigDecimal r8_three1) {
		this.r8_three1 = r8_three1;
	}
	public BigDecimal getR8_six1() {
		return r8_six1;
	}
	public void setR8_six1(BigDecimal r8_six1) {
		this.r8_six1 = r8_six1;
	}
	public BigDecimal getR8_oneyear1() {
		return r8_oneyear1;
	}
	public void setR8_oneyear1(BigDecimal r8_oneyear1) {
		this.r8_oneyear1 = r8_oneyear1;
	}
	public String getR8_empty() {
		return r8_empty;
	}
	public void setR8_empty(String r8_empty) {
		this.r8_empty = r8_empty;
	}
	public String getR9_product() {
		return r9_product;
	}
	public void setR9_product(String r9_product) {
		this.r9_product = r9_product;
	}
	public BigDecimal getR9_nbfi() {
		return r9_nbfi;
	}
	public void setR9_nbfi(BigDecimal r9_nbfi) {
		this.r9_nbfi = r9_nbfi;
	}
	public BigDecimal getR9_interbank() {
		return r9_interbank;
	}
	public void setR9_interbank(BigDecimal r9_interbank) {
		this.r9_interbank = r9_interbank;
	}
	public BigDecimal getR9_gov() {
		return r9_gov;
	}
	public void setR9_gov(BigDecimal r9_gov) {
		this.r9_gov = r9_gov;
	}
	public BigDecimal getR9_corporate() {
		return r9_corporate;
	}
	public void setR9_corporate(BigDecimal r9_corporate) {
		this.r9_corporate = r9_corporate;
	}
	public BigDecimal getR9_gre() {
		return r9_gre;
	}
	public void setR9_gre(BigDecimal r9_gre) {
		this.r9_gre = r9_gre;
	}
	public BigDecimal getR9_trade() {
		return r9_trade;
	}
	public void setR9_trade(BigDecimal r9_trade) {
		this.r9_trade = r9_trade;
	}
	public BigDecimal getR9_individuals() {
		return r9_individuals;
	}
	public void setR9_individuals(BigDecimal r9_individuals) {
		this.r9_individuals = r9_individuals;
	}
	public BigDecimal getR9_investment() {
		return r9_investment;
	}
	public void setR9_investment(BigDecimal r9_investment) {
		this.r9_investment = r9_investment;
	}
	public BigDecimal getR9_nbfi1() {
		return r9_nbfi1;
	}
	public void setR9_nbfi1(BigDecimal r9_nbfi1) {
		this.r9_nbfi1 = r9_nbfi1;
	}
	public BigDecimal getR9_interbank1() {
		return r9_interbank1;
	}
	public void setR9_interbank1(BigDecimal r9_interbank1) {
		this.r9_interbank1 = r9_interbank1;
	}
	public BigDecimal getR9_gov1() {
		return r9_gov1;
	}
	public void setR9_gov1(BigDecimal r9_gov1) {
		this.r9_gov1 = r9_gov1;
	}
	public BigDecimal getR9_corporate1() {
		return r9_corporate1;
	}
	public void setR9_corporate1(BigDecimal r9_corporate1) {
		this.r9_corporate1 = r9_corporate1;
	}
	public BigDecimal getR9_gre1() {
		return r9_gre1;
	}
	public void setR9_gre1(BigDecimal r9_gre1) {
		this.r9_gre1 = r9_gre1;
	}
	public BigDecimal getR9_trade1() {
		return r9_trade1;
	}
	public void setR9_trade1(BigDecimal r9_trade1) {
		this.r9_trade1 = r9_trade1;
	}
	public BigDecimal getR9_individuals1() {
		return r9_individuals1;
	}
	public void setR9_individuals1(BigDecimal r9_individuals1) {
		this.r9_individuals1 = r9_individuals1;
	}
	public BigDecimal getR9_investment1() {
		return r9_investment1;
	}
	public void setR9_investment1(BigDecimal r9_investment1) {
		this.r9_investment1 = r9_investment1;
	}
	public BigDecimal getR9_zer0() {
		return r9_zer0;
	}
	public void setR9_zer0(BigDecimal r9_zer0) {
		this.r9_zer0 = r9_zer0;
	}
	public BigDecimal getR9_three() {
		return r9_three;
	}
	public void setR9_three(BigDecimal r9_three) {
		this.r9_three = r9_three;
	}
	public BigDecimal getR9_six() {
		return r9_six;
	}
	public void setR9_six(BigDecimal r9_six) {
		this.r9_six = r9_six;
	}
	public BigDecimal getR9_oneyear() {
		return r9_oneyear;
	}
	public void setR9_oneyear(BigDecimal r9_oneyear) {
		this.r9_oneyear = r9_oneyear;
	}
	public BigDecimal getR9_foreign() {
		return r9_foreign;
	}
	public void setR9_foreign(BigDecimal r9_foreign) {
		this.r9_foreign = r9_foreign;
	}
	public BigDecimal getR9_banks() {
		return r9_banks;
	}
	public void setR9_banks(BigDecimal r9_banks) {
		this.r9_banks = r9_banks;
	}
	public BigDecimal getR9_gov2() {
		return r9_gov2;
	}
	public void setR9_gov2(BigDecimal r9_gov2) {
		this.r9_gov2 = r9_gov2;
	}
	public BigDecimal getR9_other() {
		return r9_other;
	}
	public void setR9_other(BigDecimal r9_other) {
		this.r9_other = r9_other;
	}
	public BigDecimal getR9_banks1() {
		return r9_banks1;
	}
	public void setR9_banks1(BigDecimal r9_banks1) {
		this.r9_banks1 = r9_banks1;
	}
	public BigDecimal getR9_individuals2() {
		return r9_individuals2;
	}
	public void setR9_individuals2(BigDecimal r9_individuals2) {
		this.r9_individuals2 = r9_individuals2;
	}
	public BigDecimal getR9_other1() {
		return r9_other1;
	}
	public void setR9_other1(BigDecimal r9_other1) {
		this.r9_other1 = r9_other1;
	}
	public BigDecimal getR9_banks2() {
		return r9_banks2;
	}
	public void setR9_banks2(BigDecimal r9_banks2) {
		this.r9_banks2 = r9_banks2;
	}
	public BigDecimal getR9_gov3() {
		return r9_gov3;
	}
	public void setR9_gov3(BigDecimal r9_gov3) {
		this.r9_gov3 = r9_gov3;
	}
	public BigDecimal getR9_others2() {
		return r9_others2;
	}
	public void setR9_others2(BigDecimal r9_others2) {
		this.r9_others2 = r9_others2;
	}
	public BigDecimal getR9_banks3() {
		return r9_banks3;
	}
	public void setR9_banks3(BigDecimal r9_banks3) {
		this.r9_banks3 = r9_banks3;
	}
	public BigDecimal getR9_gov4() {
		return r9_gov4;
	}
	public void setR9_gov4(BigDecimal r9_gov4) {
		this.r9_gov4 = r9_gov4;
	}
	public BigDecimal getR9_others3() {
		return r9_others3;
	}
	public void setR9_others3(BigDecimal r9_others3) {
		this.r9_others3 = r9_others3;
	}
	public BigDecimal getR9_foreign1() {
		return r9_foreign1;
	}
	public void setR9_foreign1(BigDecimal r9_foreign1) {
		this.r9_foreign1 = r9_foreign1;
	}
	public BigDecimal getR9_guarantees() {
		return r9_guarantees;
	}
	public void setR9_guarantees(BigDecimal r9_guarantees) {
		this.r9_guarantees = r9_guarantees;
	}
	public BigDecimal getR9_nbfi2() {
		return r9_nbfi2;
	}
	public void setR9_nbfi2(BigDecimal r9_nbfi2) {
		this.r9_nbfi2 = r9_nbfi2;
	}
	public BigDecimal getR9_interbank2() {
		return r9_interbank2;
	}
	public void setR9_interbank2(BigDecimal r9_interbank2) {
		this.r9_interbank2 = r9_interbank2;
	}
	public BigDecimal getR9_gov5() {
		return r9_gov5;
	}
	public void setR9_gov5(BigDecimal r9_gov5) {
		this.r9_gov5 = r9_gov5;
	}
	public BigDecimal getR9_corporate2() {
		return r9_corporate2;
	}
	public void setR9_corporate2(BigDecimal r9_corporate2) {
		this.r9_corporate2 = r9_corporate2;
	}
	public BigDecimal getR9_gre2() {
		return r9_gre2;
	}
	public void setR9_gre2(BigDecimal r9_gre2) {
		this.r9_gre2 = r9_gre2;
	}
	public BigDecimal getR9_individuals3() {
		return r9_individuals3;
	}
	public void setR9_individuals3(BigDecimal r9_individuals3) {
		this.r9_individuals3 = r9_individuals3;
	}
	public BigDecimal getR9_zero1() {
		return r9_zero1;
	}
	public void setR9_zero1(BigDecimal r9_zero1) {
		this.r9_zero1 = r9_zero1;
	}
	public BigDecimal getR9_three1() {
		return r9_three1;
	}
	public void setR9_three1(BigDecimal r9_three1) {
		this.r9_three1 = r9_three1;
	}
	public BigDecimal getR9_six1() {
		return r9_six1;
	}
	public void setR9_six1(BigDecimal r9_six1) {
		this.r9_six1 = r9_six1;
	}
	public BigDecimal getR9_oneyear1() {
		return r9_oneyear1;
	}
	public void setR9_oneyear1(BigDecimal r9_oneyear1) {
		this.r9_oneyear1 = r9_oneyear1;
	}
	public String getR9_empty() {
		return r9_empty;
	}
	public void setR9_empty(String r9_empty) {
		this.r9_empty = r9_empty;
	}
	public String getR10_product() {
		return r10_product;
	}
	public void setR10_product(String r10_product) {
		this.r10_product = r10_product;
	}
	public BigDecimal getR10_nbfi() {
		return r10_nbfi;
	}
	public void setR10_nbfi(BigDecimal r10_nbfi) {
		this.r10_nbfi = r10_nbfi;
	}
	public BigDecimal getR10_interbank() {
		return r10_interbank;
	}
	public void setR10_interbank(BigDecimal r10_interbank) {
		this.r10_interbank = r10_interbank;
	}
	public BigDecimal getR10_gov() {
		return r10_gov;
	}
	public void setR10_gov(BigDecimal r10_gov) {
		this.r10_gov = r10_gov;
	}
	public BigDecimal getR10_corporate() {
		return r10_corporate;
	}
	public void setR10_corporate(BigDecimal r10_corporate) {
		this.r10_corporate = r10_corporate;
	}
	public BigDecimal getR10_gre() {
		return r10_gre;
	}
	public void setR10_gre(BigDecimal r10_gre) {
		this.r10_gre = r10_gre;
	}
	public BigDecimal getR10_trade() {
		return r10_trade;
	}
	public void setR10_trade(BigDecimal r10_trade) {
		this.r10_trade = r10_trade;
	}
	public BigDecimal getR10_individuals() {
		return r10_individuals;
	}
	public void setR10_individuals(BigDecimal r10_individuals) {
		this.r10_individuals = r10_individuals;
	}
	public BigDecimal getR10_investment() {
		return r10_investment;
	}
	public void setR10_investment(BigDecimal r10_investment) {
		this.r10_investment = r10_investment;
	}
	public BigDecimal getR10_nbfi1() {
		return r10_nbfi1;
	}
	public void setR10_nbfi1(BigDecimal r10_nbfi1) {
		this.r10_nbfi1 = r10_nbfi1;
	}
	public BigDecimal getR10_interbank1() {
		return r10_interbank1;
	}
	public void setR10_interbank1(BigDecimal r10_interbank1) {
		this.r10_interbank1 = r10_interbank1;
	}
	public BigDecimal getR10_gov1() {
		return r10_gov1;
	}
	public void setR10_gov1(BigDecimal r10_gov1) {
		this.r10_gov1 = r10_gov1;
	}
	public BigDecimal getR10_corporate1() {
		return r10_corporate1;
	}
	public void setR10_corporate1(BigDecimal r10_corporate1) {
		this.r10_corporate1 = r10_corporate1;
	}
	public BigDecimal getR10_gre1() {
		return r10_gre1;
	}
	public void setR10_gre1(BigDecimal r10_gre1) {
		this.r10_gre1 = r10_gre1;
	}
	public BigDecimal getR10_trade1() {
		return r10_trade1;
	}
	public void setR10_trade1(BigDecimal r10_trade1) {
		this.r10_trade1 = r10_trade1;
	}
	public BigDecimal getR10_individuals1() {
		return r10_individuals1;
	}
	public void setR10_individuals1(BigDecimal r10_individuals1) {
		this.r10_individuals1 = r10_individuals1;
	}
	public BigDecimal getR10_investment1() {
		return r10_investment1;
	}
	public void setR10_investment1(BigDecimal r10_investment1) {
		this.r10_investment1 = r10_investment1;
	}
	public BigDecimal getR10_zer0() {
		return r10_zer0;
	}
	public void setR10_zer0(BigDecimal r10_zer0) {
		this.r10_zer0 = r10_zer0;
	}
	public BigDecimal getR10_three() {
		return r10_three;
	}
	public void setR10_three(BigDecimal r10_three) {
		this.r10_three = r10_three;
	}
	public BigDecimal getR10_six() {
		return r10_six;
	}
	public void setR10_six(BigDecimal r10_six) {
		this.r10_six = r10_six;
	}
	public BigDecimal getR10_oneyear() {
		return r10_oneyear;
	}
	public void setR10_oneyear(BigDecimal r10_oneyear) {
		this.r10_oneyear = r10_oneyear;
	}
	public BigDecimal getR10_foreign() {
		return r10_foreign;
	}
	public void setR10_foreign(BigDecimal r10_foreign) {
		this.r10_foreign = r10_foreign;
	}
	public BigDecimal getR10_banks() {
		return r10_banks;
	}
	public void setR10_banks(BigDecimal r10_banks) {
		this.r10_banks = r10_banks;
	}
	public BigDecimal getR10_gov2() {
		return r10_gov2;
	}
	public void setR10_gov2(BigDecimal r10_gov2) {
		this.r10_gov2 = r10_gov2;
	}
	public BigDecimal getR10_other() {
		return r10_other;
	}
	public void setR10_other(BigDecimal r10_other) {
		this.r10_other = r10_other;
	}
	public BigDecimal getR10_banks1() {
		return r10_banks1;
	}
	public void setR10_banks1(BigDecimal r10_banks1) {
		this.r10_banks1 = r10_banks1;
	}
	public BigDecimal getR10_individuals2() {
		return r10_individuals2;
	}
	public void setR10_individuals2(BigDecimal r10_individuals2) {
		this.r10_individuals2 = r10_individuals2;
	}
	public BigDecimal getR10_other1() {
		return r10_other1;
	}
	public void setR10_other1(BigDecimal r10_other1) {
		this.r10_other1 = r10_other1;
	}
	public BigDecimal getR10_banks2() {
		return r10_banks2;
	}
	public void setR10_banks2(BigDecimal r10_banks2) {
		this.r10_banks2 = r10_banks2;
	}
	public BigDecimal getR10_gov3() {
		return r10_gov3;
	}
	public void setR10_gov3(BigDecimal r10_gov3) {
		this.r10_gov3 = r10_gov3;
	}
	public BigDecimal getR10_others2() {
		return r10_others2;
	}
	public void setR10_others2(BigDecimal r10_others2) {
		this.r10_others2 = r10_others2;
	}
	public BigDecimal getR10_banks3() {
		return r10_banks3;
	}
	public void setR10_banks3(BigDecimal r10_banks3) {
		this.r10_banks3 = r10_banks3;
	}
	public BigDecimal getR10_gov4() {
		return r10_gov4;
	}
	public void setR10_gov4(BigDecimal r10_gov4) {
		this.r10_gov4 = r10_gov4;
	}
	public BigDecimal getR10_others3() {
		return r10_others3;
	}
	public void setR10_others3(BigDecimal r10_others3) {
		this.r10_others3 = r10_others3;
	}
	public BigDecimal getR10_foreign1() {
		return r10_foreign1;
	}
	public void setR10_foreign1(BigDecimal r10_foreign1) {
		this.r10_foreign1 = r10_foreign1;
	}
	public BigDecimal getR10_guarantees() {
		return r10_guarantees;
	}
	public void setR10_guarantees(BigDecimal r10_guarantees) {
		this.r10_guarantees = r10_guarantees;
	}
	public BigDecimal getR10_nbfi2() {
		return r10_nbfi2;
	}
	public void setR10_nbfi2(BigDecimal r10_nbfi2) {
		this.r10_nbfi2 = r10_nbfi2;
	}
	public BigDecimal getR10_interbank2() {
		return r10_interbank2;
	}
	public void setR10_interbank2(BigDecimal r10_interbank2) {
		this.r10_interbank2 = r10_interbank2;
	}
	public BigDecimal getR10_gov5() {
		return r10_gov5;
	}
	public void setR10_gov5(BigDecimal r10_gov5) {
		this.r10_gov5 = r10_gov5;
	}
	public BigDecimal getR10_corporate2() {
		return r10_corporate2;
	}
	public void setR10_corporate2(BigDecimal r10_corporate2) {
		this.r10_corporate2 = r10_corporate2;
	}
	public BigDecimal getR10_gre2() {
		return r10_gre2;
	}
	public void setR10_gre2(BigDecimal r10_gre2) {
		this.r10_gre2 = r10_gre2;
	}
	public BigDecimal getR10_individuals3() {
		return r10_individuals3;
	}
	public void setR10_individuals3(BigDecimal r10_individuals3) {
		this.r10_individuals3 = r10_individuals3;
	}
	public BigDecimal getR10_zero1() {
		return r10_zero1;
	}
	public void setR10_zero1(BigDecimal r10_zero1) {
		this.r10_zero1 = r10_zero1;
	}
	public BigDecimal getR10_three1() {
		return r10_three1;
	}
	public void setR10_three1(BigDecimal r10_three1) {
		this.r10_three1 = r10_three1;
	}
	public BigDecimal getR10_six1() {
		return r10_six1;
	}
	public void setR10_six1(BigDecimal r10_six1) {
		this.r10_six1 = r10_six1;
	}
	public BigDecimal getR10_oneyear1() {
		return r10_oneyear1;
	}
	public void setR10_oneyear1(BigDecimal r10_oneyear1) {
		this.r10_oneyear1 = r10_oneyear1;
	}
	public String getR10_empty() {
		return r10_empty;
	}
	public void setR10_empty(String r10_empty) {
		this.r10_empty = r10_empty;
	}
	public String getR11_product() {
		return r11_product;
	}
	public void setR11_product(String r11_product) {
		this.r11_product = r11_product;
	}
	public BigDecimal getR11_nbfi() {
		return r11_nbfi;
	}
	public void setR11_nbfi(BigDecimal r11_nbfi) {
		this.r11_nbfi = r11_nbfi;
	}
	public BigDecimal getR11_interbank() {
		return r11_interbank;
	}
	public void setR11_interbank(BigDecimal r11_interbank) {
		this.r11_interbank = r11_interbank;
	}
	public BigDecimal getR11_gov() {
		return r11_gov;
	}
	public void setR11_gov(BigDecimal r11_gov) {
		this.r11_gov = r11_gov;
	}
	public BigDecimal getR11_corporate() {
		return r11_corporate;
	}
	public void setR11_corporate(BigDecimal r11_corporate) {
		this.r11_corporate = r11_corporate;
	}
	public BigDecimal getR11_gre() {
		return r11_gre;
	}
	public void setR11_gre(BigDecimal r11_gre) {
		this.r11_gre = r11_gre;
	}
	public BigDecimal getR11_trade() {
		return r11_trade;
	}
	public void setR11_trade(BigDecimal r11_trade) {
		this.r11_trade = r11_trade;
	}
	public BigDecimal getR11_individuals() {
		return r11_individuals;
	}
	public void setR11_individuals(BigDecimal r11_individuals) {
		this.r11_individuals = r11_individuals;
	}
	public BigDecimal getR11_investment() {
		return r11_investment;
	}
	public void setR11_investment(BigDecimal r11_investment) {
		this.r11_investment = r11_investment;
	}
	public BigDecimal getR11_nbfi1() {
		return r11_nbfi1;
	}
	public void setR11_nbfi1(BigDecimal r11_nbfi1) {
		this.r11_nbfi1 = r11_nbfi1;
	}
	public BigDecimal getR11_interbank1() {
		return r11_interbank1;
	}
	public void setR11_interbank1(BigDecimal r11_interbank1) {
		this.r11_interbank1 = r11_interbank1;
	}
	public BigDecimal getR11_gov1() {
		return r11_gov1;
	}
	public void setR11_gov1(BigDecimal r11_gov1) {
		this.r11_gov1 = r11_gov1;
	}
	public BigDecimal getR11_corporate1() {
		return r11_corporate1;
	}
	public void setR11_corporate1(BigDecimal r11_corporate1) {
		this.r11_corporate1 = r11_corporate1;
	}
	public BigDecimal getR11_gre1() {
		return r11_gre1;
	}
	public void setR11_gre1(BigDecimal r11_gre1) {
		this.r11_gre1 = r11_gre1;
	}
	public BigDecimal getR11_trade1() {
		return r11_trade1;
	}
	public void setR11_trade1(BigDecimal r11_trade1) {
		this.r11_trade1 = r11_trade1;
	}
	public BigDecimal getR11_individuals1() {
		return r11_individuals1;
	}
	public void setR11_individuals1(BigDecimal r11_individuals1) {
		this.r11_individuals1 = r11_individuals1;
	}
	public BigDecimal getR11_investment1() {
		return r11_investment1;
	}
	public void setR11_investment1(BigDecimal r11_investment1) {
		this.r11_investment1 = r11_investment1;
	}
	public BigDecimal getR11_zer0() {
		return r11_zer0;
	}
	public void setR11_zer0(BigDecimal r11_zer0) {
		this.r11_zer0 = r11_zer0;
	}
	public BigDecimal getR11_three() {
		return r11_three;
	}
	public void setR11_three(BigDecimal r11_three) {
		this.r11_three = r11_three;
	}
	public BigDecimal getR11_six() {
		return r11_six;
	}
	public void setR11_six(BigDecimal r11_six) {
		this.r11_six = r11_six;
	}
	public BigDecimal getR11_oneyear() {
		return r11_oneyear;
	}
	public void setR11_oneyear(BigDecimal r11_oneyear) {
		this.r11_oneyear = r11_oneyear;
	}
	public BigDecimal getR11_foreign() {
		return r11_foreign;
	}
	public void setR11_foreign(BigDecimal r11_foreign) {
		this.r11_foreign = r11_foreign;
	}
	public BigDecimal getR11_banks() {
		return r11_banks;
	}
	public void setR11_banks(BigDecimal r11_banks) {
		this.r11_banks = r11_banks;
	}
	public BigDecimal getR11_gov2() {
		return r11_gov2;
	}
	public void setR11_gov2(BigDecimal r11_gov2) {
		this.r11_gov2 = r11_gov2;
	}
	public BigDecimal getR11_other() {
		return r11_other;
	}
	public void setR11_other(BigDecimal r11_other) {
		this.r11_other = r11_other;
	}
	public BigDecimal getR11_banks1() {
		return r11_banks1;
	}
	public void setR11_banks1(BigDecimal r11_banks1) {
		this.r11_banks1 = r11_banks1;
	}
	public BigDecimal getR11_individuals2() {
		return r11_individuals2;
	}
	public void setR11_individuals2(BigDecimal r11_individuals2) {
		this.r11_individuals2 = r11_individuals2;
	}
	public BigDecimal getR11_other1() {
		return r11_other1;
	}
	public void setR11_other1(BigDecimal r11_other1) {
		this.r11_other1 = r11_other1;
	}
	public BigDecimal getR11_banks2() {
		return r11_banks2;
	}
	public void setR11_banks2(BigDecimal r11_banks2) {
		this.r11_banks2 = r11_banks2;
	}
	public BigDecimal getR11_gov3() {
		return r11_gov3;
	}
	public void setR11_gov3(BigDecimal r11_gov3) {
		this.r11_gov3 = r11_gov3;
	}
	public BigDecimal getR11_others2() {
		return r11_others2;
	}
	public void setR11_others2(BigDecimal r11_others2) {
		this.r11_others2 = r11_others2;
	}
	public BigDecimal getR11_banks3() {
		return r11_banks3;
	}
	public void setR11_banks3(BigDecimal r11_banks3) {
		this.r11_banks3 = r11_banks3;
	}
	public BigDecimal getR11_gov4() {
		return r11_gov4;
	}
	public void setR11_gov4(BigDecimal r11_gov4) {
		this.r11_gov4 = r11_gov4;
	}
	public BigDecimal getR11_others3() {
		return r11_others3;
	}
	public void setR11_others3(BigDecimal r11_others3) {
		this.r11_others3 = r11_others3;
	}
	public BigDecimal getR11_foreign1() {
		return r11_foreign1;
	}
	public void setR11_foreign1(BigDecimal r11_foreign1) {
		this.r11_foreign1 = r11_foreign1;
	}
	public BigDecimal getR11_guarantees() {
		return r11_guarantees;
	}
	public void setR11_guarantees(BigDecimal r11_guarantees) {
		this.r11_guarantees = r11_guarantees;
	}
	public BigDecimal getR11_nbfi2() {
		return r11_nbfi2;
	}
	public void setR11_nbfi2(BigDecimal r11_nbfi2) {
		this.r11_nbfi2 = r11_nbfi2;
	}
	public BigDecimal getR11_interbank2() {
		return r11_interbank2;
	}
	public void setR11_interbank2(BigDecimal r11_interbank2) {
		this.r11_interbank2 = r11_interbank2;
	}
	public BigDecimal getR11_gov5() {
		return r11_gov5;
	}
	public void setR11_gov5(BigDecimal r11_gov5) {
		this.r11_gov5 = r11_gov5;
	}
	public BigDecimal getR11_corporate2() {
		return r11_corporate2;
	}
	public void setR11_corporate2(BigDecimal r11_corporate2) {
		this.r11_corporate2 = r11_corporate2;
	}
	public BigDecimal getR11_gre2() {
		return r11_gre2;
	}
	public void setR11_gre2(BigDecimal r11_gre2) {
		this.r11_gre2 = r11_gre2;
	}
	public BigDecimal getR11_individuals3() {
		return r11_individuals3;
	}
	public void setR11_individuals3(BigDecimal r11_individuals3) {
		this.r11_individuals3 = r11_individuals3;
	}
	public BigDecimal getR11_zero1() {
		return r11_zero1;
	}
	public void setR11_zero1(BigDecimal r11_zero1) {
		this.r11_zero1 = r11_zero1;
	}
	public BigDecimal getR11_three1() {
		return r11_three1;
	}
	public void setR11_three1(BigDecimal r11_three1) {
		this.r11_three1 = r11_three1;
	}
	public BigDecimal getR11_six1() {
		return r11_six1;
	}
	public void setR11_six1(BigDecimal r11_six1) {
		this.r11_six1 = r11_six1;
	}
	public BigDecimal getR11_oneyear1() {
		return r11_oneyear1;
	}
	public void setR11_oneyear1(BigDecimal r11_oneyear1) {
		this.r11_oneyear1 = r11_oneyear1;
	}
	public String getR11_empty() {
		return r11_empty;
	}
	public void setR11_empty(String r11_empty) {
		this.r11_empty = r11_empty;
	}
	public String getR12_product() {
		return r12_product;
	}
	public void setR12_product(String r12_product) {
		this.r12_product = r12_product;
	}
	public BigDecimal getR12_nbfi() {
		return r12_nbfi;
	}
	public void setR12_nbfi(BigDecimal r12_nbfi) {
		this.r12_nbfi = r12_nbfi;
	}
	public BigDecimal getR12_interbank() {
		return r12_interbank;
	}
	public void setR12_interbank(BigDecimal r12_interbank) {
		this.r12_interbank = r12_interbank;
	}
	public BigDecimal getR12_gov() {
		return r12_gov;
	}
	public void setR12_gov(BigDecimal r12_gov) {
		this.r12_gov = r12_gov;
	}
	public BigDecimal getR12_corporate() {
		return r12_corporate;
	}
	public void setR12_corporate(BigDecimal r12_corporate) {
		this.r12_corporate = r12_corporate;
	}
	public BigDecimal getR12_gre() {
		return r12_gre;
	}
	public void setR12_gre(BigDecimal r12_gre) {
		this.r12_gre = r12_gre;
	}
	public BigDecimal getR12_trade() {
		return r12_trade;
	}
	public void setR12_trade(BigDecimal r12_trade) {
		this.r12_trade = r12_trade;
	}
	public BigDecimal getR12_individuals() {
		return r12_individuals;
	}
	public void setR12_individuals(BigDecimal r12_individuals) {
		this.r12_individuals = r12_individuals;
	}
	public BigDecimal getR12_investment() {
		return r12_investment;
	}
	public void setR12_investment(BigDecimal r12_investment) {
		this.r12_investment = r12_investment;
	}
	public BigDecimal getR12_nbfi1() {
		return r12_nbfi1;
	}
	public void setR12_nbfi1(BigDecimal r12_nbfi1) {
		this.r12_nbfi1 = r12_nbfi1;
	}
	public BigDecimal getR12_interbank1() {
		return r12_interbank1;
	}
	public void setR12_interbank1(BigDecimal r12_interbank1) {
		this.r12_interbank1 = r12_interbank1;
	}
	public BigDecimal getR12_gov1() {
		return r12_gov1;
	}
	public void setR12_gov1(BigDecimal r12_gov1) {
		this.r12_gov1 = r12_gov1;
	}
	public BigDecimal getR12_corporate1() {
		return r12_corporate1;
	}
	public void setR12_corporate1(BigDecimal r12_corporate1) {
		this.r12_corporate1 = r12_corporate1;
	}
	public BigDecimal getR12_gre1() {
		return r12_gre1;
	}
	public void setR12_gre1(BigDecimal r12_gre1) {
		this.r12_gre1 = r12_gre1;
	}
	public BigDecimal getR12_trade1() {
		return r12_trade1;
	}
	public void setR12_trade1(BigDecimal r12_trade1) {
		this.r12_trade1 = r12_trade1;
	}
	public BigDecimal getR12_individuals1() {
		return r12_individuals1;
	}
	public void setR12_individuals1(BigDecimal r12_individuals1) {
		this.r12_individuals1 = r12_individuals1;
	}
	public BigDecimal getR12_investment1() {
		return r12_investment1;
	}
	public void setR12_investment1(BigDecimal r12_investment1) {
		this.r12_investment1 = r12_investment1;
	}
	public BigDecimal getR12_zer0() {
		return r12_zer0;
	}
	public void setR12_zer0(BigDecimal r12_zer0) {
		this.r12_zer0 = r12_zer0;
	}
	public BigDecimal getR12_three() {
		return r12_three;
	}
	public void setR12_three(BigDecimal r12_three) {
		this.r12_three = r12_three;
	}
	public BigDecimal getR12_six() {
		return r12_six;
	}
	public void setR12_six(BigDecimal r12_six) {
		this.r12_six = r12_six;
	}
	public BigDecimal getR12_oneyear() {
		return r12_oneyear;
	}
	public void setR12_oneyear(BigDecimal r12_oneyear) {
		this.r12_oneyear = r12_oneyear;
	}
	public BigDecimal getR12_foreign() {
		return r12_foreign;
	}
	public void setR12_foreign(BigDecimal r12_foreign) {
		this.r12_foreign = r12_foreign;
	}
	public BigDecimal getR12_banks() {
		return r12_banks;
	}
	public void setR12_banks(BigDecimal r12_banks) {
		this.r12_banks = r12_banks;
	}
	public BigDecimal getR12_gov2() {
		return r12_gov2;
	}
	public void setR12_gov2(BigDecimal r12_gov2) {
		this.r12_gov2 = r12_gov2;
	}
	public BigDecimal getR12_other() {
		return r12_other;
	}
	public void setR12_other(BigDecimal r12_other) {
		this.r12_other = r12_other;
	}
	public BigDecimal getR12_banks1() {
		return r12_banks1;
	}
	public void setR12_banks1(BigDecimal r12_banks1) {
		this.r12_banks1 = r12_banks1;
	}
	public BigDecimal getR12_individuals2() {
		return r12_individuals2;
	}
	public void setR12_individuals2(BigDecimal r12_individuals2) {
		this.r12_individuals2 = r12_individuals2;
	}
	public BigDecimal getR12_other1() {
		return r12_other1;
	}
	public void setR12_other1(BigDecimal r12_other1) {
		this.r12_other1 = r12_other1;
	}
	public BigDecimal getR12_banks2() {
		return r12_banks2;
	}
	public void setR12_banks2(BigDecimal r12_banks2) {
		this.r12_banks2 = r12_banks2;
	}
	public BigDecimal getR12_gov3() {
		return r12_gov3;
	}
	public void setR12_gov3(BigDecimal r12_gov3) {
		this.r12_gov3 = r12_gov3;
	}
	public BigDecimal getR12_others2() {
		return r12_others2;
	}
	public void setR12_others2(BigDecimal r12_others2) {
		this.r12_others2 = r12_others2;
	}
	public BigDecimal getR12_banks3() {
		return r12_banks3;
	}
	public void setR12_banks3(BigDecimal r12_banks3) {
		this.r12_banks3 = r12_banks3;
	}
	public BigDecimal getR12_gov4() {
		return r12_gov4;
	}
	public void setR12_gov4(BigDecimal r12_gov4) {
		this.r12_gov4 = r12_gov4;
	}
	public BigDecimal getR12_others3() {
		return r12_others3;
	}
	public void setR12_others3(BigDecimal r12_others3) {
		this.r12_others3 = r12_others3;
	}
	public BigDecimal getR12_foreign1() {
		return r12_foreign1;
	}
	public void setR12_foreign1(BigDecimal r12_foreign1) {
		this.r12_foreign1 = r12_foreign1;
	}
	public BigDecimal getR12_guarantees() {
		return r12_guarantees;
	}
	public void setR12_guarantees(BigDecimal r12_guarantees) {
		this.r12_guarantees = r12_guarantees;
	}
	public BigDecimal getR12_nbfi2() {
		return r12_nbfi2;
	}
	public void setR12_nbfi2(BigDecimal r12_nbfi2) {
		this.r12_nbfi2 = r12_nbfi2;
	}
	public BigDecimal getR12_interbank2() {
		return r12_interbank2;
	}
	public void setR12_interbank2(BigDecimal r12_interbank2) {
		this.r12_interbank2 = r12_interbank2;
	}
	public BigDecimal getR12_gov5() {
		return r12_gov5;
	}
	public void setR12_gov5(BigDecimal r12_gov5) {
		this.r12_gov5 = r12_gov5;
	}
	public BigDecimal getR12_corporate2() {
		return r12_corporate2;
	}
	public void setR12_corporate2(BigDecimal r12_corporate2) {
		this.r12_corporate2 = r12_corporate2;
	}
	public BigDecimal getR12_gre2() {
		return r12_gre2;
	}
	public void setR12_gre2(BigDecimal r12_gre2) {
		this.r12_gre2 = r12_gre2;
	}
	public BigDecimal getR12_individuals3() {
		return r12_individuals3;
	}
	public void setR12_individuals3(BigDecimal r12_individuals3) {
		this.r12_individuals3 = r12_individuals3;
	}
	public BigDecimal getR12_zero1() {
		return r12_zero1;
	}
	public void setR12_zero1(BigDecimal r12_zero1) {
		this.r12_zero1 = r12_zero1;
	}
	public BigDecimal getR12_three1() {
		return r12_three1;
	}
	public void setR12_three1(BigDecimal r12_three1) {
		this.r12_three1 = r12_three1;
	}
	public BigDecimal getR12_six1() {
		return r12_six1;
	}
	public void setR12_six1(BigDecimal r12_six1) {
		this.r12_six1 = r12_six1;
	}
	public BigDecimal getR12_oneyear1() {
		return r12_oneyear1;
	}
	public void setR12_oneyear1(BigDecimal r12_oneyear1) {
		this.r12_oneyear1 = r12_oneyear1;
	}
	public String getR12_empty() {
		return r12_empty;
	}
	public void setR12_empty(String r12_empty) {
		this.r12_empty = r12_empty;
	}
	public String getR13_product() {
		return r13_product;
	}
	public void setR13_product(String r13_product) {
		this.r13_product = r13_product;
	}
	public BigDecimal getR13_nbfi() {
		return r13_nbfi;
	}
	public void setR13_nbfi(BigDecimal r13_nbfi) {
		this.r13_nbfi = r13_nbfi;
	}
	public BigDecimal getR13_interbank() {
		return r13_interbank;
	}
	public void setR13_interbank(BigDecimal r13_interbank) {
		this.r13_interbank = r13_interbank;
	}
	public BigDecimal getR13_gov() {
		return r13_gov;
	}
	public void setR13_gov(BigDecimal r13_gov) {
		this.r13_gov = r13_gov;
	}
	public BigDecimal getR13_corporate() {
		return r13_corporate;
	}
	public void setR13_corporate(BigDecimal r13_corporate) {
		this.r13_corporate = r13_corporate;
	}
	public BigDecimal getR13_gre() {
		return r13_gre;
	}
	public void setR13_gre(BigDecimal r13_gre) {
		this.r13_gre = r13_gre;
	}
	public BigDecimal getR13_trade() {
		return r13_trade;
	}
	public void setR13_trade(BigDecimal r13_trade) {
		this.r13_trade = r13_trade;
	}
	public BigDecimal getR13_individuals() {
		return r13_individuals;
	}
	public void setR13_individuals(BigDecimal r13_individuals) {
		this.r13_individuals = r13_individuals;
	}
	public BigDecimal getR13_investment() {
		return r13_investment;
	}
	public void setR13_investment(BigDecimal r13_investment) {
		this.r13_investment = r13_investment;
	}
	public BigDecimal getR13_nbfi1() {
		return r13_nbfi1;
	}
	public void setR13_nbfi1(BigDecimal r13_nbfi1) {
		this.r13_nbfi1 = r13_nbfi1;
	}
	public BigDecimal getR13_interbank1() {
		return r13_interbank1;
	}
	public void setR13_interbank1(BigDecimal r13_interbank1) {
		this.r13_interbank1 = r13_interbank1;
	}
	public BigDecimal getR13_gov1() {
		return r13_gov1;
	}
	public void setR13_gov1(BigDecimal r13_gov1) {
		this.r13_gov1 = r13_gov1;
	}
	public BigDecimal getR13_corporate1() {
		return r13_corporate1;
	}
	public void setR13_corporate1(BigDecimal r13_corporate1) {
		this.r13_corporate1 = r13_corporate1;
	}
	public BigDecimal getR13_gre1() {
		return r13_gre1;
	}
	public void setR13_gre1(BigDecimal r13_gre1) {
		this.r13_gre1 = r13_gre1;
	}
	public BigDecimal getR13_trade1() {
		return r13_trade1;
	}
	public void setR13_trade1(BigDecimal r13_trade1) {
		this.r13_trade1 = r13_trade1;
	}
	public BigDecimal getR13_individuals1() {
		return r13_individuals1;
	}
	public void setR13_individuals1(BigDecimal r13_individuals1) {
		this.r13_individuals1 = r13_individuals1;
	}
	public BigDecimal getR13_investment1() {
		return r13_investment1;
	}
	public void setR13_investment1(BigDecimal r13_investment1) {
		this.r13_investment1 = r13_investment1;
	}
	public BigDecimal getR13_zer0() {
		return r13_zer0;
	}
	public void setR13_zer0(BigDecimal r13_zer0) {
		this.r13_zer0 = r13_zer0;
	}
	public BigDecimal getR13_three() {
		return r13_three;
	}
	public void setR13_three(BigDecimal r13_three) {
		this.r13_three = r13_three;
	}
	public BigDecimal getR13_six() {
		return r13_six;
	}
	public void setR13_six(BigDecimal r13_six) {
		this.r13_six = r13_six;
	}
	public BigDecimal getR13_oneyear() {
		return r13_oneyear;
	}
	public void setR13_oneyear(BigDecimal r13_oneyear) {
		this.r13_oneyear = r13_oneyear;
	}
	public BigDecimal getR13_foreign() {
		return r13_foreign;
	}
	public void setR13_foreign(BigDecimal r13_foreign) {
		this.r13_foreign = r13_foreign;
	}
	public BigDecimal getR13_banks() {
		return r13_banks;
	}
	public void setR13_banks(BigDecimal r13_banks) {
		this.r13_banks = r13_banks;
	}
	public BigDecimal getR13_gov2() {
		return r13_gov2;
	}
	public void setR13_gov2(BigDecimal r13_gov2) {
		this.r13_gov2 = r13_gov2;
	}
	public BigDecimal getR13_other() {
		return r13_other;
	}
	public void setR13_other(BigDecimal r13_other) {
		this.r13_other = r13_other;
	}
	public BigDecimal getR13_banks1() {
		return r13_banks1;
	}
	public void setR13_banks1(BigDecimal r13_banks1) {
		this.r13_banks1 = r13_banks1;
	}
	public BigDecimal getR13_individuals2() {
		return r13_individuals2;
	}
	public void setR13_individuals2(BigDecimal r13_individuals2) {
		this.r13_individuals2 = r13_individuals2;
	}
	public BigDecimal getR13_other1() {
		return r13_other1;
	}
	public void setR13_other1(BigDecimal r13_other1) {
		this.r13_other1 = r13_other1;
	}
	public BigDecimal getR13_banks2() {
		return r13_banks2;
	}
	public void setR13_banks2(BigDecimal r13_banks2) {
		this.r13_banks2 = r13_banks2;
	}
	public BigDecimal getR13_gov3() {
		return r13_gov3;
	}
	public void setR13_gov3(BigDecimal r13_gov3) {
		this.r13_gov3 = r13_gov3;
	}
	public BigDecimal getR13_others2() {
		return r13_others2;
	}
	public void setR13_others2(BigDecimal r13_others2) {
		this.r13_others2 = r13_others2;
	}
	public BigDecimal getR13_banks3() {
		return r13_banks3;
	}
	public void setR13_banks3(BigDecimal r13_banks3) {
		this.r13_banks3 = r13_banks3;
	}
	public BigDecimal getR13_gov4() {
		return r13_gov4;
	}
	public void setR13_gov4(BigDecimal r13_gov4) {
		this.r13_gov4 = r13_gov4;
	}
	public BigDecimal getR13_others3() {
		return r13_others3;
	}
	public void setR13_others3(BigDecimal r13_others3) {
		this.r13_others3 = r13_others3;
	}
	public BigDecimal getR13_foreign1() {
		return r13_foreign1;
	}
	public void setR13_foreign1(BigDecimal r13_foreign1) {
		this.r13_foreign1 = r13_foreign1;
	}
	public BigDecimal getR13_guarantees() {
		return r13_guarantees;
	}
	public void setR13_guarantees(BigDecimal r13_guarantees) {
		this.r13_guarantees = r13_guarantees;
	}
	public BigDecimal getR13_nbfi2() {
		return r13_nbfi2;
	}
	public void setR13_nbfi2(BigDecimal r13_nbfi2) {
		this.r13_nbfi2 = r13_nbfi2;
	}
	public BigDecimal getR13_interbank2() {
		return r13_interbank2;
	}
	public void setR13_interbank2(BigDecimal r13_interbank2) {
		this.r13_interbank2 = r13_interbank2;
	}
	public BigDecimal getR13_gov5() {
		return r13_gov5;
	}
	public void setR13_gov5(BigDecimal r13_gov5) {
		this.r13_gov5 = r13_gov5;
	}
	public BigDecimal getR13_corporate2() {
		return r13_corporate2;
	}
	public void setR13_corporate2(BigDecimal r13_corporate2) {
		this.r13_corporate2 = r13_corporate2;
	}
	public BigDecimal getR13_gre2() {
		return r13_gre2;
	}
	public void setR13_gre2(BigDecimal r13_gre2) {
		this.r13_gre2 = r13_gre2;
	}
	public BigDecimal getR13_individuals3() {
		return r13_individuals3;
	}
	public void setR13_individuals3(BigDecimal r13_individuals3) {
		this.r13_individuals3 = r13_individuals3;
	}
	public BigDecimal getR13_zero1() {
		return r13_zero1;
	}
	public void setR13_zero1(BigDecimal r13_zero1) {
		this.r13_zero1 = r13_zero1;
	}
	public BigDecimal getR13_three1() {
		return r13_three1;
	}
	public void setR13_three1(BigDecimal r13_three1) {
		this.r13_three1 = r13_three1;
	}
	public BigDecimal getR13_six1() {
		return r13_six1;
	}
	public void setR13_six1(BigDecimal r13_six1) {
		this.r13_six1 = r13_six1;
	}
	public BigDecimal getR13_oneyear1() {
		return r13_oneyear1;
	}
	public void setR13_oneyear1(BigDecimal r13_oneyear1) {
		this.r13_oneyear1 = r13_oneyear1;
	}
	public String getR13_empty() {
		return r13_empty;
	}
	public void setR13_empty(String r13_empty) {
		this.r13_empty = r13_empty;
	}
	public String getR14_product() {
		return r14_product;
	}
	public void setR14_product(String r14_product) {
		this.r14_product = r14_product;
	}
	public BigDecimal getR14_nbfi() {
		return r14_nbfi;
	}
	public void setR14_nbfi(BigDecimal r14_nbfi) {
		this.r14_nbfi = r14_nbfi;
	}
	public BigDecimal getR14_interbank() {
		return r14_interbank;
	}
	public void setR14_interbank(BigDecimal r14_interbank) {
		this.r14_interbank = r14_interbank;
	}
	public BigDecimal getR14_gov() {
		return r14_gov;
	}
	public void setR14_gov(BigDecimal r14_gov) {
		this.r14_gov = r14_gov;
	}
	public BigDecimal getR14_corporate() {
		return r14_corporate;
	}
	public void setR14_corporate(BigDecimal r14_corporate) {
		this.r14_corporate = r14_corporate;
	}
	public BigDecimal getR14_gre() {
		return r14_gre;
	}
	public void setR14_gre(BigDecimal r14_gre) {
		this.r14_gre = r14_gre;
	}
	public BigDecimal getR14_trade() {
		return r14_trade;
	}
	public void setR14_trade(BigDecimal r14_trade) {
		this.r14_trade = r14_trade;
	}
	public BigDecimal getR14_individuals() {
		return r14_individuals;
	}
	public void setR14_individuals(BigDecimal r14_individuals) {
		this.r14_individuals = r14_individuals;
	}
	public BigDecimal getR14_investment() {
		return r14_investment;
	}
	public void setR14_investment(BigDecimal r14_investment) {
		this.r14_investment = r14_investment;
	}
	public BigDecimal getR14_nbfi1() {
		return r14_nbfi1;
	}
	public void setR14_nbfi1(BigDecimal r14_nbfi1) {
		this.r14_nbfi1 = r14_nbfi1;
	}
	public BigDecimal getR14_interbank1() {
		return r14_interbank1;
	}
	public void setR14_interbank1(BigDecimal r14_interbank1) {
		this.r14_interbank1 = r14_interbank1;
	}
	public BigDecimal getR14_gov1() {
		return r14_gov1;
	}
	public void setR14_gov1(BigDecimal r14_gov1) {
		this.r14_gov1 = r14_gov1;
	}
	public BigDecimal getR14_corporate1() {
		return r14_corporate1;
	}
	public void setR14_corporate1(BigDecimal r14_corporate1) {
		this.r14_corporate1 = r14_corporate1;
	}
	public BigDecimal getR14_gre1() {
		return r14_gre1;
	}
	public void setR14_gre1(BigDecimal r14_gre1) {
		this.r14_gre1 = r14_gre1;
	}
	public BigDecimal getR14_trade1() {
		return r14_trade1;
	}
	public void setR14_trade1(BigDecimal r14_trade1) {
		this.r14_trade1 = r14_trade1;
	}
	public BigDecimal getR14_individuals1() {
		return r14_individuals1;
	}
	public void setR14_individuals1(BigDecimal r14_individuals1) {
		this.r14_individuals1 = r14_individuals1;
	}
	public BigDecimal getR14_investment1() {
		return r14_investment1;
	}
	public void setR14_investment1(BigDecimal r14_investment1) {
		this.r14_investment1 = r14_investment1;
	}
	public BigDecimal getR14_zer0() {
		return r14_zer0;
	}
	public void setR14_zer0(BigDecimal r14_zer0) {
		this.r14_zer0 = r14_zer0;
	}
	public BigDecimal getR14_three() {
		return r14_three;
	}
	public void setR14_three(BigDecimal r14_three) {
		this.r14_three = r14_three;
	}
	public BigDecimal getR14_six() {
		return r14_six;
	}
	public void setR14_six(BigDecimal r14_six) {
		this.r14_six = r14_six;
	}
	public BigDecimal getR14_oneyear() {
		return r14_oneyear;
	}
	public void setR14_oneyear(BigDecimal r14_oneyear) {
		this.r14_oneyear = r14_oneyear;
	}
	public BigDecimal getR14_foreign() {
		return r14_foreign;
	}
	public void setR14_foreign(BigDecimal r14_foreign) {
		this.r14_foreign = r14_foreign;
	}
	public BigDecimal getR14_banks() {
		return r14_banks;
	}
	public void setR14_banks(BigDecimal r14_banks) {
		this.r14_banks = r14_banks;
	}
	public BigDecimal getR14_gov2() {
		return r14_gov2;
	}
	public void setR14_gov2(BigDecimal r14_gov2) {
		this.r14_gov2 = r14_gov2;
	}
	public BigDecimal getR14_other() {
		return r14_other;
	}
	public void setR14_other(BigDecimal r14_other) {
		this.r14_other = r14_other;
	}
	public BigDecimal getR14_banks1() {
		return r14_banks1;
	}
	public void setR14_banks1(BigDecimal r14_banks1) {
		this.r14_banks1 = r14_banks1;
	}
	public BigDecimal getR14_individuals2() {
		return r14_individuals2;
	}
	public void setR14_individuals2(BigDecimal r14_individuals2) {
		this.r14_individuals2 = r14_individuals2;
	}
	public BigDecimal getR14_other1() {
		return r14_other1;
	}
	public void setR14_other1(BigDecimal r14_other1) {
		this.r14_other1 = r14_other1;
	}
	public BigDecimal getR14_banks2() {
		return r14_banks2;
	}
	public void setR14_banks2(BigDecimal r14_banks2) {
		this.r14_banks2 = r14_banks2;
	}
	public BigDecimal getR14_gov3() {
		return r14_gov3;
	}
	public void setR14_gov3(BigDecimal r14_gov3) {
		this.r14_gov3 = r14_gov3;
	}
	public BigDecimal getR14_others2() {
		return r14_others2;
	}
	public void setR14_others2(BigDecimal r14_others2) {
		this.r14_others2 = r14_others2;
	}
	public BigDecimal getR14_banks3() {
		return r14_banks3;
	}
	public void setR14_banks3(BigDecimal r14_banks3) {
		this.r14_banks3 = r14_banks3;
	}
	public BigDecimal getR14_gov4() {
		return r14_gov4;
	}
	public void setR14_gov4(BigDecimal r14_gov4) {
		this.r14_gov4 = r14_gov4;
	}
	public BigDecimal getR14_others3() {
		return r14_others3;
	}
	public void setR14_others3(BigDecimal r14_others3) {
		this.r14_others3 = r14_others3;
	}
	public BigDecimal getR14_foreign1() {
		return r14_foreign1;
	}
	public void setR14_foreign1(BigDecimal r14_foreign1) {
		this.r14_foreign1 = r14_foreign1;
	}
	public BigDecimal getR14_guarantees() {
		return r14_guarantees;
	}
	public void setR14_guarantees(BigDecimal r14_guarantees) {
		this.r14_guarantees = r14_guarantees;
	}
	public BigDecimal getR14_nbfi2() {
		return r14_nbfi2;
	}
	public void setR14_nbfi2(BigDecimal r14_nbfi2) {
		this.r14_nbfi2 = r14_nbfi2;
	}
	public BigDecimal getR14_interbank2() {
		return r14_interbank2;
	}
	public void setR14_interbank2(BigDecimal r14_interbank2) {
		this.r14_interbank2 = r14_interbank2;
	}
	public BigDecimal getR14_gov5() {
		return r14_gov5;
	}
	public void setR14_gov5(BigDecimal r14_gov5) {
		this.r14_gov5 = r14_gov5;
	}
	public BigDecimal getR14_corporate2() {
		return r14_corporate2;
	}
	public void setR14_corporate2(BigDecimal r14_corporate2) {
		this.r14_corporate2 = r14_corporate2;
	}
	public BigDecimal getR14_gre2() {
		return r14_gre2;
	}
	public void setR14_gre2(BigDecimal r14_gre2) {
		this.r14_gre2 = r14_gre2;
	}
	public BigDecimal getR14_individuals3() {
		return r14_individuals3;
	}
	public void setR14_individuals3(BigDecimal r14_individuals3) {
		this.r14_individuals3 = r14_individuals3;
	}
	public BigDecimal getR14_zero1() {
		return r14_zero1;
	}
	public void setR14_zero1(BigDecimal r14_zero1) {
		this.r14_zero1 = r14_zero1;
	}
	public BigDecimal getR14_three1() {
		return r14_three1;
	}
	public void setR14_three1(BigDecimal r14_three1) {
		this.r14_three1 = r14_three1;
	}
	public BigDecimal getR14_six1() {
		return r14_six1;
	}
	public void setR14_six1(BigDecimal r14_six1) {
		this.r14_six1 = r14_six1;
	}
	public BigDecimal getR14_oneyear1() {
		return r14_oneyear1;
	}
	public void setR14_oneyear1(BigDecimal r14_oneyear1) {
		this.r14_oneyear1 = r14_oneyear1;
	}
	public String getR14_empty() {
		return r14_empty;
	}
	public void setR14_empty(String r14_empty) {
		this.r14_empty = r14_empty;
	}
	public String getR15_product() {
		return r15_product;
	}
	public void setR15_product(String r15_product) {
		this.r15_product = r15_product;
	}
	public BigDecimal getR15_nbfi() {
		return r15_nbfi;
	}
	public void setR15_nbfi(BigDecimal r15_nbfi) {
		this.r15_nbfi = r15_nbfi;
	}
	public BigDecimal getR15_interbank() {
		return r15_interbank;
	}
	public void setR15_interbank(BigDecimal r15_interbank) {
		this.r15_interbank = r15_interbank;
	}
	public BigDecimal getR15_gov() {
		return r15_gov;
	}
	public void setR15_gov(BigDecimal r15_gov) {
		this.r15_gov = r15_gov;
	}
	public BigDecimal getR15_corporate() {
		return r15_corporate;
	}
	public void setR15_corporate(BigDecimal r15_corporate) {
		this.r15_corporate = r15_corporate;
	}
	public BigDecimal getR15_gre() {
		return r15_gre;
	}
	public void setR15_gre(BigDecimal r15_gre) {
		this.r15_gre = r15_gre;
	}
	public BigDecimal getR15_trade() {
		return r15_trade;
	}
	public void setR15_trade(BigDecimal r15_trade) {
		this.r15_trade = r15_trade;
	}
	public BigDecimal getR15_individuals() {
		return r15_individuals;
	}
	public void setR15_individuals(BigDecimal r15_individuals) {
		this.r15_individuals = r15_individuals;
	}
	public BigDecimal getR15_investment() {
		return r15_investment;
	}
	public void setR15_investment(BigDecimal r15_investment) {
		this.r15_investment = r15_investment;
	}
	public BigDecimal getR15_nbfi1() {
		return r15_nbfi1;
	}
	public void setR15_nbfi1(BigDecimal r15_nbfi1) {
		this.r15_nbfi1 = r15_nbfi1;
	}
	public BigDecimal getR15_interbank1() {
		return r15_interbank1;
	}
	public void setR15_interbank1(BigDecimal r15_interbank1) {
		this.r15_interbank1 = r15_interbank1;
	}
	public BigDecimal getR15_gov1() {
		return r15_gov1;
	}
	public void setR15_gov1(BigDecimal r15_gov1) {
		this.r15_gov1 = r15_gov1;
	}
	public BigDecimal getR15_corporate1() {
		return r15_corporate1;
	}
	public void setR15_corporate1(BigDecimal r15_corporate1) {
		this.r15_corporate1 = r15_corporate1;
	}
	public BigDecimal getR15_gre1() {
		return r15_gre1;
	}
	public void setR15_gre1(BigDecimal r15_gre1) {
		this.r15_gre1 = r15_gre1;
	}
	public BigDecimal getR15_trade1() {
		return r15_trade1;
	}
	public void setR15_trade1(BigDecimal r15_trade1) {
		this.r15_trade1 = r15_trade1;
	}
	public BigDecimal getR15_individuals1() {
		return r15_individuals1;
	}
	public void setR15_individuals1(BigDecimal r15_individuals1) {
		this.r15_individuals1 = r15_individuals1;
	}
	public BigDecimal getR15_investment1() {
		return r15_investment1;
	}
	public void setR15_investment1(BigDecimal r15_investment1) {
		this.r15_investment1 = r15_investment1;
	}
	public BigDecimal getR15_zer0() {
		return r15_zer0;
	}
	public void setR15_zer0(BigDecimal r15_zer0) {
		this.r15_zer0 = r15_zer0;
	}
	public BigDecimal getR15_three() {
		return r15_three;
	}
	public void setR15_three(BigDecimal r15_three) {
		this.r15_three = r15_three;
	}
	public BigDecimal getR15_six() {
		return r15_six;
	}
	public void setR15_six(BigDecimal r15_six) {
		this.r15_six = r15_six;
	}
	public BigDecimal getR15_oneyear() {
		return r15_oneyear;
	}
	public void setR15_oneyear(BigDecimal r15_oneyear) {
		this.r15_oneyear = r15_oneyear;
	}
	public BigDecimal getR15_foreign() {
		return r15_foreign;
	}
	public void setR15_foreign(BigDecimal r15_foreign) {
		this.r15_foreign = r15_foreign;
	}
	public BigDecimal getR15_banks() {
		return r15_banks;
	}
	public void setR15_banks(BigDecimal r15_banks) {
		this.r15_banks = r15_banks;
	}
	public BigDecimal getR15_gov2() {
		return r15_gov2;
	}
	public void setR15_gov2(BigDecimal r15_gov2) {
		this.r15_gov2 = r15_gov2;
	}
	public BigDecimal getR15_other() {
		return r15_other;
	}
	public void setR15_other(BigDecimal r15_other) {
		this.r15_other = r15_other;
	}
	public BigDecimal getR15_banks1() {
		return r15_banks1;
	}
	public void setR15_banks1(BigDecimal r15_banks1) {
		this.r15_banks1 = r15_banks1;
	}
	public BigDecimal getR15_individuals2() {
		return r15_individuals2;
	}
	public void setR15_individuals2(BigDecimal r15_individuals2) {
		this.r15_individuals2 = r15_individuals2;
	}
	public BigDecimal getR15_other1() {
		return r15_other1;
	}
	public void setR15_other1(BigDecimal r15_other1) {
		this.r15_other1 = r15_other1;
	}
	public BigDecimal getR15_banks2() {
		return r15_banks2;
	}
	public void setR15_banks2(BigDecimal r15_banks2) {
		this.r15_banks2 = r15_banks2;
	}
	public BigDecimal getR15_gov3() {
		return r15_gov3;
	}
	public void setR15_gov3(BigDecimal r15_gov3) {
		this.r15_gov3 = r15_gov3;
	}
	public BigDecimal getR15_others2() {
		return r15_others2;
	}
	public void setR15_others2(BigDecimal r15_others2) {
		this.r15_others2 = r15_others2;
	}
	public BigDecimal getR15_banks3() {
		return r15_banks3;
	}
	public void setR15_banks3(BigDecimal r15_banks3) {
		this.r15_banks3 = r15_banks3;
	}
	public BigDecimal getR15_gov4() {
		return r15_gov4;
	}
	public void setR15_gov4(BigDecimal r15_gov4) {
		this.r15_gov4 = r15_gov4;
	}
	public BigDecimal getR15_others3() {
		return r15_others3;
	}
	public void setR15_others3(BigDecimal r15_others3) {
		this.r15_others3 = r15_others3;
	}
	public BigDecimal getR15_foreign1() {
		return r15_foreign1;
	}
	public void setR15_foreign1(BigDecimal r15_foreign1) {
		this.r15_foreign1 = r15_foreign1;
	}
	public BigDecimal getR15_guarantees() {
		return r15_guarantees;
	}
	public void setR15_guarantees(BigDecimal r15_guarantees) {
		this.r15_guarantees = r15_guarantees;
	}
	public BigDecimal getR15_nbfi2() {
		return r15_nbfi2;
	}
	public void setR15_nbfi2(BigDecimal r15_nbfi2) {
		this.r15_nbfi2 = r15_nbfi2;
	}
	public BigDecimal getR15_interbank2() {
		return r15_interbank2;
	}
	public void setR15_interbank2(BigDecimal r15_interbank2) {
		this.r15_interbank2 = r15_interbank2;
	}
	public BigDecimal getR15_gov5() {
		return r15_gov5;
	}
	public void setR15_gov5(BigDecimal r15_gov5) {
		this.r15_gov5 = r15_gov5;
	}
	public BigDecimal getR15_corporate2() {
		return r15_corporate2;
	}
	public void setR15_corporate2(BigDecimal r15_corporate2) {
		this.r15_corporate2 = r15_corporate2;
	}
	public BigDecimal getR15_gre2() {
		return r15_gre2;
	}
	public void setR15_gre2(BigDecimal r15_gre2) {
		this.r15_gre2 = r15_gre2;
	}
	public BigDecimal getR15_individuals3() {
		return r15_individuals3;
	}
	public void setR15_individuals3(BigDecimal r15_individuals3) {
		this.r15_individuals3 = r15_individuals3;
	}
	public BigDecimal getR15_zero1() {
		return r15_zero1;
	}
	public void setR15_zero1(BigDecimal r15_zero1) {
		this.r15_zero1 = r15_zero1;
	}
	public BigDecimal getR15_three1() {
		return r15_three1;
	}
	public void setR15_three1(BigDecimal r15_three1) {
		this.r15_three1 = r15_three1;
	}
	public BigDecimal getR15_six1() {
		return r15_six1;
	}
	public void setR15_six1(BigDecimal r15_six1) {
		this.r15_six1 = r15_six1;
	}
	public BigDecimal getR15_oneyear1() {
		return r15_oneyear1;
	}
	public void setR15_oneyear1(BigDecimal r15_oneyear1) {
		this.r15_oneyear1 = r15_oneyear1;
	}
	public String getR15_empty() {
		return r15_empty;
	}
	public void setR15_empty(String r15_empty) {
		this.r15_empty = r15_empty;
	}
	public String getR16_product() {
		return r16_product;
	}
	public void setR16_product(String r16_product) {
		this.r16_product = r16_product;
	}
	public BigDecimal getR16_nbfi() {
		return r16_nbfi;
	}
	public void setR16_nbfi(BigDecimal r16_nbfi) {
		this.r16_nbfi = r16_nbfi;
	}
	public BigDecimal getR16_interbank() {
		return r16_interbank;
	}
	public void setR16_interbank(BigDecimal r16_interbank) {
		this.r16_interbank = r16_interbank;
	}
	public BigDecimal getR16_gov() {
		return r16_gov;
	}
	public void setR16_gov(BigDecimal r16_gov) {
		this.r16_gov = r16_gov;
	}
	public BigDecimal getR16_corporate() {
		return r16_corporate;
	}
	public void setR16_corporate(BigDecimal r16_corporate) {
		this.r16_corporate = r16_corporate;
	}
	public BigDecimal getR16_gre() {
		return r16_gre;
	}
	public void setR16_gre(BigDecimal r16_gre) {
		this.r16_gre = r16_gre;
	}
	public BigDecimal getR16_trade() {
		return r16_trade;
	}
	public void setR16_trade(BigDecimal r16_trade) {
		this.r16_trade = r16_trade;
	}
	public BigDecimal getR16_individuals() {
		return r16_individuals;
	}
	public void setR16_individuals(BigDecimal r16_individuals) {
		this.r16_individuals = r16_individuals;
	}
	public BigDecimal getR16_investment() {
		return r16_investment;
	}
	public void setR16_investment(BigDecimal r16_investment) {
		this.r16_investment = r16_investment;
	}
	public BigDecimal getR16_nbfi1() {
		return r16_nbfi1;
	}
	public void setR16_nbfi1(BigDecimal r16_nbfi1) {
		this.r16_nbfi1 = r16_nbfi1;
	}
	public BigDecimal getR16_interbank1() {
		return r16_interbank1;
	}
	public void setR16_interbank1(BigDecimal r16_interbank1) {
		this.r16_interbank1 = r16_interbank1;
	}
	public BigDecimal getR16_gov1() {
		return r16_gov1;
	}
	public void setR16_gov1(BigDecimal r16_gov1) {
		this.r16_gov1 = r16_gov1;
	}
	public BigDecimal getR16_corporate1() {
		return r16_corporate1;
	}
	public void setR16_corporate1(BigDecimal r16_corporate1) {
		this.r16_corporate1 = r16_corporate1;
	}
	public BigDecimal getR16_gre1() {
		return r16_gre1;
	}
	public void setR16_gre1(BigDecimal r16_gre1) {
		this.r16_gre1 = r16_gre1;
	}
	public BigDecimal getR16_trade1() {
		return r16_trade1;
	}
	public void setR16_trade1(BigDecimal r16_trade1) {
		this.r16_trade1 = r16_trade1;
	}
	public BigDecimal getR16_individuals1() {
		return r16_individuals1;
	}
	public void setR16_individuals1(BigDecimal r16_individuals1) {
		this.r16_individuals1 = r16_individuals1;
	}
	public BigDecimal getR16_investment1() {
		return r16_investment1;
	}
	public void setR16_investment1(BigDecimal r16_investment1) {
		this.r16_investment1 = r16_investment1;
	}
	public BigDecimal getR16_zer0() {
		return r16_zer0;
	}
	public void setR16_zer0(BigDecimal r16_zer0) {
		this.r16_zer0 = r16_zer0;
	}
	public BigDecimal getR16_three() {
		return r16_three;
	}
	public void setR16_three(BigDecimal r16_three) {
		this.r16_three = r16_three;
	}
	public BigDecimal getR16_six() {
		return r16_six;
	}
	public void setR16_six(BigDecimal r16_six) {
		this.r16_six = r16_six;
	}
	public BigDecimal getR16_oneyear() {
		return r16_oneyear;
	}
	public void setR16_oneyear(BigDecimal r16_oneyear) {
		this.r16_oneyear = r16_oneyear;
	}
	public BigDecimal getR16_foreign() {
		return r16_foreign;
	}
	public void setR16_foreign(BigDecimal r16_foreign) {
		this.r16_foreign = r16_foreign;
	}
	public BigDecimal getR16_banks() {
		return r16_banks;
	}
	public void setR16_banks(BigDecimal r16_banks) {
		this.r16_banks = r16_banks;
	}
	public BigDecimal getR16_gov2() {
		return r16_gov2;
	}
	public void setR16_gov2(BigDecimal r16_gov2) {
		this.r16_gov2 = r16_gov2;
	}
	public BigDecimal getR16_other() {
		return r16_other;
	}
	public void setR16_other(BigDecimal r16_other) {
		this.r16_other = r16_other;
	}
	public BigDecimal getR16_banks1() {
		return r16_banks1;
	}
	public void setR16_banks1(BigDecimal r16_banks1) {
		this.r16_banks1 = r16_banks1;
	}
	public BigDecimal getR16_individuals2() {
		return r16_individuals2;
	}
	public void setR16_individuals2(BigDecimal r16_individuals2) {
		this.r16_individuals2 = r16_individuals2;
	}
	public BigDecimal getR16_other1() {
		return r16_other1;
	}
	public void setR16_other1(BigDecimal r16_other1) {
		this.r16_other1 = r16_other1;
	}
	public BigDecimal getR16_banks2() {
		return r16_banks2;
	}
	public void setR16_banks2(BigDecimal r16_banks2) {
		this.r16_banks2 = r16_banks2;
	}
	public BigDecimal getR16_gov3() {
		return r16_gov3;
	}
	public void setR16_gov3(BigDecimal r16_gov3) {
		this.r16_gov3 = r16_gov3;
	}
	public BigDecimal getR16_others2() {
		return r16_others2;
	}
	public void setR16_others2(BigDecimal r16_others2) {
		this.r16_others2 = r16_others2;
	}
	public BigDecimal getR16_banks3() {
		return r16_banks3;
	}
	public void setR16_banks3(BigDecimal r16_banks3) {
		this.r16_banks3 = r16_banks3;
	}
	public BigDecimal getR16_gov4() {
		return r16_gov4;
	}
	public void setR16_gov4(BigDecimal r16_gov4) {
		this.r16_gov4 = r16_gov4;
	}
	public BigDecimal getR16_others3() {
		return r16_others3;
	}
	public void setR16_others3(BigDecimal r16_others3) {
		this.r16_others3 = r16_others3;
	}
	public BigDecimal getR16_foreign1() {
		return r16_foreign1;
	}
	public void setR16_foreign1(BigDecimal r16_foreign1) {
		this.r16_foreign1 = r16_foreign1;
	}
	public BigDecimal getR16_guarantees() {
		return r16_guarantees;
	}
	public void setR16_guarantees(BigDecimal r16_guarantees) {
		this.r16_guarantees = r16_guarantees;
	}
	public BigDecimal getR16_nbfi2() {
		return r16_nbfi2;
	}
	public void setR16_nbfi2(BigDecimal r16_nbfi2) {
		this.r16_nbfi2 = r16_nbfi2;
	}
	public BigDecimal getR16_interbank2() {
		return r16_interbank2;
	}
	public void setR16_interbank2(BigDecimal r16_interbank2) {
		this.r16_interbank2 = r16_interbank2;
	}
	public BigDecimal getR16_gov5() {
		return r16_gov5;
	}
	public void setR16_gov5(BigDecimal r16_gov5) {
		this.r16_gov5 = r16_gov5;
	}
	public BigDecimal getR16_corporate2() {
		return r16_corporate2;
	}
	public void setR16_corporate2(BigDecimal r16_corporate2) {
		this.r16_corporate2 = r16_corporate2;
	}
	public BigDecimal getR16_gre2() {
		return r16_gre2;
	}
	public void setR16_gre2(BigDecimal r16_gre2) {
		this.r16_gre2 = r16_gre2;
	}
	public BigDecimal getR16_individuals3() {
		return r16_individuals3;
	}
	public void setR16_individuals3(BigDecimal r16_individuals3) {
		this.r16_individuals3 = r16_individuals3;
	}
	public BigDecimal getR16_zero1() {
		return r16_zero1;
	}
	public void setR16_zero1(BigDecimal r16_zero1) {
		this.r16_zero1 = r16_zero1;
	}
	public BigDecimal getR16_three1() {
		return r16_three1;
	}
	public void setR16_three1(BigDecimal r16_three1) {
		this.r16_three1 = r16_three1;
	}
	public BigDecimal getR16_six1() {
		return r16_six1;
	}
	public void setR16_six1(BigDecimal r16_six1) {
		this.r16_six1 = r16_six1;
	}
	public BigDecimal getR16_oneyear1() {
		return r16_oneyear1;
	}
	public void setR16_oneyear1(BigDecimal r16_oneyear1) {
		this.r16_oneyear1 = r16_oneyear1;
	}
	public String getR16_empty() {
		return r16_empty;
	}
	public void setR16_empty(String r16_empty) {
		this.r16_empty = r16_empty;
	}
	public String getR17_product() {
		return r17_product;
	}
	public void setR17_product(String r17_product) {
		this.r17_product = r17_product;
	}
	public BigDecimal getR17_nbfi() {
		return r17_nbfi;
	}
	public void setR17_nbfi(BigDecimal r17_nbfi) {
		this.r17_nbfi = r17_nbfi;
	}
	public BigDecimal getR17_interbank() {
		return r17_interbank;
	}
	public void setR17_interbank(BigDecimal r17_interbank) {
		this.r17_interbank = r17_interbank;
	}
	public BigDecimal getR17_gov() {
		return r17_gov;
	}
	public void setR17_gov(BigDecimal r17_gov) {
		this.r17_gov = r17_gov;
	}
	public BigDecimal getR17_corporate() {
		return r17_corporate;
	}
	public void setR17_corporate(BigDecimal r17_corporate) {
		this.r17_corporate = r17_corporate;
	}
	public BigDecimal getR17_gre() {
		return r17_gre;
	}
	public void setR17_gre(BigDecimal r17_gre) {
		this.r17_gre = r17_gre;
	}
	public BigDecimal getR17_trade() {
		return r17_trade;
	}
	public void setR17_trade(BigDecimal r17_trade) {
		this.r17_trade = r17_trade;
	}
	public BigDecimal getR17_individuals() {
		return r17_individuals;
	}
	public void setR17_individuals(BigDecimal r17_individuals) {
		this.r17_individuals = r17_individuals;
	}
	public BigDecimal getR17_investment() {
		return r17_investment;
	}
	public void setR17_investment(BigDecimal r17_investment) {
		this.r17_investment = r17_investment;
	}
	public BigDecimal getR17_nbfi1() {
		return r17_nbfi1;
	}
	public void setR17_nbfi1(BigDecimal r17_nbfi1) {
		this.r17_nbfi1 = r17_nbfi1;
	}
	public BigDecimal getR17_interbank1() {
		return r17_interbank1;
	}
	public void setR17_interbank1(BigDecimal r17_interbank1) {
		this.r17_interbank1 = r17_interbank1;
	}
	public BigDecimal getR17_gov1() {
		return r17_gov1;
	}
	public void setR17_gov1(BigDecimal r17_gov1) {
		this.r17_gov1 = r17_gov1;
	}
	public BigDecimal getR17_corporate1() {
		return r17_corporate1;
	}
	public void setR17_corporate1(BigDecimal r17_corporate1) {
		this.r17_corporate1 = r17_corporate1;
	}
	public BigDecimal getR17_gre1() {
		return r17_gre1;
	}
	public void setR17_gre1(BigDecimal r17_gre1) {
		this.r17_gre1 = r17_gre1;
	}
	public BigDecimal getR17_trade1() {
		return r17_trade1;
	}
	public void setR17_trade1(BigDecimal r17_trade1) {
		this.r17_trade1 = r17_trade1;
	}
	public BigDecimal getR17_individuals1() {
		return r17_individuals1;
	}
	public void setR17_individuals1(BigDecimal r17_individuals1) {
		this.r17_individuals1 = r17_individuals1;
	}
	public BigDecimal getR17_investment1() {
		return r17_investment1;
	}
	public void setR17_investment1(BigDecimal r17_investment1) {
		this.r17_investment1 = r17_investment1;
	}
	public BigDecimal getR17_zer0() {
		return r17_zer0;
	}
	public void setR17_zer0(BigDecimal r17_zer0) {
		this.r17_zer0 = r17_zer0;
	}
	public BigDecimal getR17_three() {
		return r17_three;
	}
	public void setR17_three(BigDecimal r17_three) {
		this.r17_three = r17_three;
	}
	public BigDecimal getR17_six() {
		return r17_six;
	}
	public void setR17_six(BigDecimal r17_six) {
		this.r17_six = r17_six;
	}
	public BigDecimal getR17_oneyear() {
		return r17_oneyear;
	}
	public void setR17_oneyear(BigDecimal r17_oneyear) {
		this.r17_oneyear = r17_oneyear;
	}
	public BigDecimal getR17_foreign() {
		return r17_foreign;
	}
	public void setR17_foreign(BigDecimal r17_foreign) {
		this.r17_foreign = r17_foreign;
	}
	public BigDecimal getR17_banks() {
		return r17_banks;
	}
	public void setR17_banks(BigDecimal r17_banks) {
		this.r17_banks = r17_banks;
	}
	public BigDecimal getR17_gov2() {
		return r17_gov2;
	}
	public void setR17_gov2(BigDecimal r17_gov2) {
		this.r17_gov2 = r17_gov2;
	}
	public BigDecimal getR17_other() {
		return r17_other;
	}
	public void setR17_other(BigDecimal r17_other) {
		this.r17_other = r17_other;
	}
	public BigDecimal getR17_banks1() {
		return r17_banks1;
	}
	public void setR17_banks1(BigDecimal r17_banks1) {
		this.r17_banks1 = r17_banks1;
	}
	public BigDecimal getR17_individuals2() {
		return r17_individuals2;
	}
	public void setR17_individuals2(BigDecimal r17_individuals2) {
		this.r17_individuals2 = r17_individuals2;
	}
	public BigDecimal getR17_other1() {
		return r17_other1;
	}
	public void setR17_other1(BigDecimal r17_other1) {
		this.r17_other1 = r17_other1;
	}
	public BigDecimal getR17_banks2() {
		return r17_banks2;
	}
	public void setR17_banks2(BigDecimal r17_banks2) {
		this.r17_banks2 = r17_banks2;
	}
	public BigDecimal getR17_gov3() {
		return r17_gov3;
	}
	public void setR17_gov3(BigDecimal r17_gov3) {
		this.r17_gov3 = r17_gov3;
	}
	public BigDecimal getR17_others2() {
		return r17_others2;
	}
	public void setR17_others2(BigDecimal r17_others2) {
		this.r17_others2 = r17_others2;
	}
	public BigDecimal getR17_banks3() {
		return r17_banks3;
	}
	public void setR17_banks3(BigDecimal r17_banks3) {
		this.r17_banks3 = r17_banks3;
	}
	public BigDecimal getR17_gov4() {
		return r17_gov4;
	}
	public void setR17_gov4(BigDecimal r17_gov4) {
		this.r17_gov4 = r17_gov4;
	}
	public BigDecimal getR17_others3() {
		return r17_others3;
	}
	public void setR17_others3(BigDecimal r17_others3) {
		this.r17_others3 = r17_others3;
	}
	public BigDecimal getR17_foreign1() {
		return r17_foreign1;
	}
	public void setR17_foreign1(BigDecimal r17_foreign1) {
		this.r17_foreign1 = r17_foreign1;
	}
	public BigDecimal getR17_guarantees() {
		return r17_guarantees;
	}
	public void setR17_guarantees(BigDecimal r17_guarantees) {
		this.r17_guarantees = r17_guarantees;
	}
	public BigDecimal getR17_nbfi2() {
		return r17_nbfi2;
	}
	public void setR17_nbfi2(BigDecimal r17_nbfi2) {
		this.r17_nbfi2 = r17_nbfi2;
	}
	public BigDecimal getR17_interbank2() {
		return r17_interbank2;
	}
	public void setR17_interbank2(BigDecimal r17_interbank2) {
		this.r17_interbank2 = r17_interbank2;
	}
	public BigDecimal getR17_gov5() {
		return r17_gov5;
	}
	public void setR17_gov5(BigDecimal r17_gov5) {
		this.r17_gov5 = r17_gov5;
	}
	public BigDecimal getR17_corporate2() {
		return r17_corporate2;
	}
	public void setR17_corporate2(BigDecimal r17_corporate2) {
		this.r17_corporate2 = r17_corporate2;
	}
	public BigDecimal getR17_gre2() {
		return r17_gre2;
	}
	public void setR17_gre2(BigDecimal r17_gre2) {
		this.r17_gre2 = r17_gre2;
	}
	public BigDecimal getR17_individuals3() {
		return r17_individuals3;
	}
	public void setR17_individuals3(BigDecimal r17_individuals3) {
		this.r17_individuals3 = r17_individuals3;
	}
	public BigDecimal getR17_zero1() {
		return r17_zero1;
	}
	public void setR17_zero1(BigDecimal r17_zero1) {
		this.r17_zero1 = r17_zero1;
	}
	public BigDecimal getR17_three1() {
		return r17_three1;
	}
	public void setR17_three1(BigDecimal r17_three1) {
		this.r17_three1 = r17_three1;
	}
	public BigDecimal getR17_six1() {
		return r17_six1;
	}
	public void setR17_six1(BigDecimal r17_six1) {
		this.r17_six1 = r17_six1;
	}
	public BigDecimal getR17_oneyear1() {
		return r17_oneyear1;
	}
	public void setR17_oneyear1(BigDecimal r17_oneyear1) {
		this.r17_oneyear1 = r17_oneyear1;
	}
	public String getR17_empty() {
		return r17_empty;
	}
	public void setR17_empty(String r17_empty) {
		this.r17_empty = r17_empty;
	}
	public String getR18_product() {
		return r18_product;
	}
	public void setR18_product(String r18_product) {
		this.r18_product = r18_product;
	}
	public BigDecimal getR18_nbfi() {
		return r18_nbfi;
	}
	public void setR18_nbfi(BigDecimal r18_nbfi) {
		this.r18_nbfi = r18_nbfi;
	}
	public BigDecimal getR18_interbank() {
		return r18_interbank;
	}
	public void setR18_interbank(BigDecimal r18_interbank) {
		this.r18_interbank = r18_interbank;
	}
	public BigDecimal getR18_gov() {
		return r18_gov;
	}
	public void setR18_gov(BigDecimal r18_gov) {
		this.r18_gov = r18_gov;
	}
	public BigDecimal getR18_corporate() {
		return r18_corporate;
	}
	public void setR18_corporate(BigDecimal r18_corporate) {
		this.r18_corporate = r18_corporate;
	}
	public BigDecimal getR18_gre() {
		return r18_gre;
	}
	public void setR18_gre(BigDecimal r18_gre) {
		this.r18_gre = r18_gre;
	}
	public BigDecimal getR18_trade() {
		return r18_trade;
	}
	public void setR18_trade(BigDecimal r18_trade) {
		this.r18_trade = r18_trade;
	}
	public BigDecimal getR18_individuals() {
		return r18_individuals;
	}
	public void setR18_individuals(BigDecimal r18_individuals) {
		this.r18_individuals = r18_individuals;
	}
	public BigDecimal getR18_investment() {
		return r18_investment;
	}
	public void setR18_investment(BigDecimal r18_investment) {
		this.r18_investment = r18_investment;
	}
	public BigDecimal getR18_nbfi1() {
		return r18_nbfi1;
	}
	public void setR18_nbfi1(BigDecimal r18_nbfi1) {
		this.r18_nbfi1 = r18_nbfi1;
	}
	public BigDecimal getR18_interbank1() {
		return r18_interbank1;
	}
	public void setR18_interbank1(BigDecimal r18_interbank1) {
		this.r18_interbank1 = r18_interbank1;
	}
	public BigDecimal getR18_gov1() {
		return r18_gov1;
	}
	public void setR18_gov1(BigDecimal r18_gov1) {
		this.r18_gov1 = r18_gov1;
	}
	public BigDecimal getR18_corporate1() {
		return r18_corporate1;
	}
	public void setR18_corporate1(BigDecimal r18_corporate1) {
		this.r18_corporate1 = r18_corporate1;
	}
	public BigDecimal getR18_gre1() {
		return r18_gre1;
	}
	public void setR18_gre1(BigDecimal r18_gre1) {
		this.r18_gre1 = r18_gre1;
	}
	public BigDecimal getR18_trade1() {
		return r18_trade1;
	}
	public void setR18_trade1(BigDecimal r18_trade1) {
		this.r18_trade1 = r18_trade1;
	}
	public BigDecimal getR18_individuals1() {
		return r18_individuals1;
	}
	public void setR18_individuals1(BigDecimal r18_individuals1) {
		this.r18_individuals1 = r18_individuals1;
	}
	public BigDecimal getR18_investment1() {
		return r18_investment1;
	}
	public void setR18_investment1(BigDecimal r18_investment1) {
		this.r18_investment1 = r18_investment1;
	}
	public BigDecimal getR18_zer0() {
		return r18_zer0;
	}
	public void setR18_zer0(BigDecimal r18_zer0) {
		this.r18_zer0 = r18_zer0;
	}
	public BigDecimal getR18_three() {
		return r18_three;
	}
	public void setR18_three(BigDecimal r18_three) {
		this.r18_three = r18_three;
	}
	public BigDecimal getR18_six() {
		return r18_six;
	}
	public void setR18_six(BigDecimal r18_six) {
		this.r18_six = r18_six;
	}
	public BigDecimal getR18_oneyear() {
		return r18_oneyear;
	}
	public void setR18_oneyear(BigDecimal r18_oneyear) {
		this.r18_oneyear = r18_oneyear;
	}
	public BigDecimal getR18_foreign() {
		return r18_foreign;
	}
	public void setR18_foreign(BigDecimal r18_foreign) {
		this.r18_foreign = r18_foreign;
	}
	public BigDecimal getR18_banks() {
		return r18_banks;
	}
	public void setR18_banks(BigDecimal r18_banks) {
		this.r18_banks = r18_banks;
	}
	public BigDecimal getR18_gov2() {
		return r18_gov2;
	}
	public void setR18_gov2(BigDecimal r18_gov2) {
		this.r18_gov2 = r18_gov2;
	}
	public BigDecimal getR18_other() {
		return r18_other;
	}
	public void setR18_other(BigDecimal r18_other) {
		this.r18_other = r18_other;
	}
	public BigDecimal getR18_banks1() {
		return r18_banks1;
	}
	public void setR18_banks1(BigDecimal r18_banks1) {
		this.r18_banks1 = r18_banks1;
	}
	public BigDecimal getR18_individuals2() {
		return r18_individuals2;
	}
	public void setR18_individuals2(BigDecimal r18_individuals2) {
		this.r18_individuals2 = r18_individuals2;
	}
	public BigDecimal getR18_other1() {
		return r18_other1;
	}
	public void setR18_other1(BigDecimal r18_other1) {
		this.r18_other1 = r18_other1;
	}
	public BigDecimal getR18_banks2() {
		return r18_banks2;
	}
	public void setR18_banks2(BigDecimal r18_banks2) {
		this.r18_banks2 = r18_banks2;
	}
	public BigDecimal getR18_gov3() {
		return r18_gov3;
	}
	public void setR18_gov3(BigDecimal r18_gov3) {
		this.r18_gov3 = r18_gov3;
	}
	public BigDecimal getR18_others2() {
		return r18_others2;
	}
	public void setR18_others2(BigDecimal r18_others2) {
		this.r18_others2 = r18_others2;
	}
	public BigDecimal getR18_banks3() {
		return r18_banks3;
	}
	public void setR18_banks3(BigDecimal r18_banks3) {
		this.r18_banks3 = r18_banks3;
	}
	public BigDecimal getR18_gov4() {
		return r18_gov4;
	}
	public void setR18_gov4(BigDecimal r18_gov4) {
		this.r18_gov4 = r18_gov4;
	}
	public BigDecimal getR18_others3() {
		return r18_others3;
	}
	public void setR18_others3(BigDecimal r18_others3) {
		this.r18_others3 = r18_others3;
	}
	public BigDecimal getR18_foreign1() {
		return r18_foreign1;
	}
	public void setR18_foreign1(BigDecimal r18_foreign1) {
		this.r18_foreign1 = r18_foreign1;
	}
	public BigDecimal getR18_guarantees() {
		return r18_guarantees;
	}
	public void setR18_guarantees(BigDecimal r18_guarantees) {
		this.r18_guarantees = r18_guarantees;
	}
	public BigDecimal getR18_nbfi2() {
		return r18_nbfi2;
	}
	public void setR18_nbfi2(BigDecimal r18_nbfi2) {
		this.r18_nbfi2 = r18_nbfi2;
	}
	public BigDecimal getR18_interbank2() {
		return r18_interbank2;
	}
	public void setR18_interbank2(BigDecimal r18_interbank2) {
		this.r18_interbank2 = r18_interbank2;
	}
	public BigDecimal getR18_gov5() {
		return r18_gov5;
	}
	public void setR18_gov5(BigDecimal r18_gov5) {
		this.r18_gov5 = r18_gov5;
	}
	public BigDecimal getR18_corporate2() {
		return r18_corporate2;
	}
	public void setR18_corporate2(BigDecimal r18_corporate2) {
		this.r18_corporate2 = r18_corporate2;
	}
	public BigDecimal getR18_gre2() {
		return r18_gre2;
	}
	public void setR18_gre2(BigDecimal r18_gre2) {
		this.r18_gre2 = r18_gre2;
	}
	public BigDecimal getR18_individuals3() {
		return r18_individuals3;
	}
	public void setR18_individuals3(BigDecimal r18_individuals3) {
		this.r18_individuals3 = r18_individuals3;
	}
	public BigDecimal getR18_zero1() {
		return r18_zero1;
	}
	public void setR18_zero1(BigDecimal r18_zero1) {
		this.r18_zero1 = r18_zero1;
	}
	public BigDecimal getR18_three1() {
		return r18_three1;
	}
	public void setR18_three1(BigDecimal r18_three1) {
		this.r18_three1 = r18_three1;
	}
	public BigDecimal getR18_six1() {
		return r18_six1;
	}
	public void setR18_six1(BigDecimal r18_six1) {
		this.r18_six1 = r18_six1;
	}
	public BigDecimal getR18_oneyear1() {
		return r18_oneyear1;
	}
	public void setR18_oneyear1(BigDecimal r18_oneyear1) {
		this.r18_oneyear1 = r18_oneyear1;
	}
	public String getR18_empty() {
		return r18_empty;
	}
	public void setR18_empty(String r18_empty) {
		this.r18_empty = r18_empty;
	}
	public String getR19_product() {
		return r19_product;
	}
	public void setR19_product(String r19_product) {
		this.r19_product = r19_product;
	}
	public BigDecimal getR19_nbfi() {
		return r19_nbfi;
	}
	public void setR19_nbfi(BigDecimal r19_nbfi) {
		this.r19_nbfi = r19_nbfi;
	}
	public BigDecimal getR19_interbank() {
		return r19_interbank;
	}
	public void setR19_interbank(BigDecimal r19_interbank) {
		this.r19_interbank = r19_interbank;
	}
	public BigDecimal getR19_gov() {
		return r19_gov;
	}
	public void setR19_gov(BigDecimal r19_gov) {
		this.r19_gov = r19_gov;
	}
	public BigDecimal getR19_corporate() {
		return r19_corporate;
	}
	public void setR19_corporate(BigDecimal r19_corporate) {
		this.r19_corporate = r19_corporate;
	}
	public BigDecimal getR19_gre() {
		return r19_gre;
	}
	public void setR19_gre(BigDecimal r19_gre) {
		this.r19_gre = r19_gre;
	}
	public BigDecimal getR19_trade() {
		return r19_trade;
	}
	public void setR19_trade(BigDecimal r19_trade) {
		this.r19_trade = r19_trade;
	}
	public BigDecimal getR19_individuals() {
		return r19_individuals;
	}
	public void setR19_individuals(BigDecimal r19_individuals) {
		this.r19_individuals = r19_individuals;
	}
	public BigDecimal getR19_investment() {
		return r19_investment;
	}
	public void setR19_investment(BigDecimal r19_investment) {
		this.r19_investment = r19_investment;
	}
	public BigDecimal getR19_nbfi1() {
		return r19_nbfi1;
	}
	public void setR19_nbfi1(BigDecimal r19_nbfi1) {
		this.r19_nbfi1 = r19_nbfi1;
	}
	public BigDecimal getR19_interbank1() {
		return r19_interbank1;
	}
	public void setR19_interbank1(BigDecimal r19_interbank1) {
		this.r19_interbank1 = r19_interbank1;
	}
	public BigDecimal getR19_gov1() {
		return r19_gov1;
	}
	public void setR19_gov1(BigDecimal r19_gov1) {
		this.r19_gov1 = r19_gov1;
	}
	public BigDecimal getR19_corporate1() {
		return r19_corporate1;
	}
	public void setR19_corporate1(BigDecimal r19_corporate1) {
		this.r19_corporate1 = r19_corporate1;
	}
	public BigDecimal getR19_gre1() {
		return r19_gre1;
	}
	public void setR19_gre1(BigDecimal r19_gre1) {
		this.r19_gre1 = r19_gre1;
	}
	public BigDecimal getR19_trade1() {
		return r19_trade1;
	}
	public void setR19_trade1(BigDecimal r19_trade1) {
		this.r19_trade1 = r19_trade1;
	}
	public BigDecimal getR19_individuals1() {
		return r19_individuals1;
	}
	public void setR19_individuals1(BigDecimal r19_individuals1) {
		this.r19_individuals1 = r19_individuals1;
	}
	public BigDecimal getR19_investment1() {
		return r19_investment1;
	}
	public void setR19_investment1(BigDecimal r19_investment1) {
		this.r19_investment1 = r19_investment1;
	}
	public BigDecimal getR19_zer0() {
		return r19_zer0;
	}
	public void setR19_zer0(BigDecimal r19_zer0) {
		this.r19_zer0 = r19_zer0;
	}
	public BigDecimal getR19_three() {
		return r19_three;
	}
	public void setR19_three(BigDecimal r19_three) {
		this.r19_three = r19_three;
	}
	public BigDecimal getR19_six() {
		return r19_six;
	}
	public void setR19_six(BigDecimal r19_six) {
		this.r19_six = r19_six;
	}
	public BigDecimal getR19_oneyear() {
		return r19_oneyear;
	}
	public void setR19_oneyear(BigDecimal r19_oneyear) {
		this.r19_oneyear = r19_oneyear;
	}
	public BigDecimal getR19_foreign() {
		return r19_foreign;
	}
	public void setR19_foreign(BigDecimal r19_foreign) {
		this.r19_foreign = r19_foreign;
	}
	public BigDecimal getR19_banks() {
		return r19_banks;
	}
	public void setR19_banks(BigDecimal r19_banks) {
		this.r19_banks = r19_banks;
	}
	public BigDecimal getR19_gov2() {
		return r19_gov2;
	}
	public void setR19_gov2(BigDecimal r19_gov2) {
		this.r19_gov2 = r19_gov2;
	}
	public BigDecimal getR19_other() {
		return r19_other;
	}
	public void setR19_other(BigDecimal r19_other) {
		this.r19_other = r19_other;
	}
	public BigDecimal getR19_banks1() {
		return r19_banks1;
	}
	public void setR19_banks1(BigDecimal r19_banks1) {
		this.r19_banks1 = r19_banks1;
	}
	public BigDecimal getR19_individuals2() {
		return r19_individuals2;
	}
	public void setR19_individuals2(BigDecimal r19_individuals2) {
		this.r19_individuals2 = r19_individuals2;
	}
	public BigDecimal getR19_other1() {
		return r19_other1;
	}
	public void setR19_other1(BigDecimal r19_other1) {
		this.r19_other1 = r19_other1;
	}
	public BigDecimal getR19_banks2() {
		return r19_banks2;
	}
	public void setR19_banks2(BigDecimal r19_banks2) {
		this.r19_banks2 = r19_banks2;
	}
	public BigDecimal getR19_gov3() {
		return r19_gov3;
	}
	public void setR19_gov3(BigDecimal r19_gov3) {
		this.r19_gov3 = r19_gov3;
	}
	public BigDecimal getR19_others2() {
		return r19_others2;
	}
	public void setR19_others2(BigDecimal r19_others2) {
		this.r19_others2 = r19_others2;
	}
	public BigDecimal getR19_banks3() {
		return r19_banks3;
	}
	public void setR19_banks3(BigDecimal r19_banks3) {
		this.r19_banks3 = r19_banks3;
	}
	public BigDecimal getR19_gov4() {
		return r19_gov4;
	}
	public void setR19_gov4(BigDecimal r19_gov4) {
		this.r19_gov4 = r19_gov4;
	}
	public BigDecimal getR19_others3() {
		return r19_others3;
	}
	public void setR19_others3(BigDecimal r19_others3) {
		this.r19_others3 = r19_others3;
	}
	public BigDecimal getR19_foreign1() {
		return r19_foreign1;
	}
	public void setR19_foreign1(BigDecimal r19_foreign1) {
		this.r19_foreign1 = r19_foreign1;
	}
	public BigDecimal getR19_guarantees() {
		return r19_guarantees;
	}
	public void setR19_guarantees(BigDecimal r19_guarantees) {
		this.r19_guarantees = r19_guarantees;
	}
	public BigDecimal getR19_nbfi2() {
		return r19_nbfi2;
	}
	public void setR19_nbfi2(BigDecimal r19_nbfi2) {
		this.r19_nbfi2 = r19_nbfi2;
	}
	public BigDecimal getR19_interbank2() {
		return r19_interbank2;
	}
	public void setR19_interbank2(BigDecimal r19_interbank2) {
		this.r19_interbank2 = r19_interbank2;
	}
	public BigDecimal getR19_gov5() {
		return r19_gov5;
	}
	public void setR19_gov5(BigDecimal r19_gov5) {
		this.r19_gov5 = r19_gov5;
	}
	public BigDecimal getR19_corporate2() {
		return r19_corporate2;
	}
	public void setR19_corporate2(BigDecimal r19_corporate2) {
		this.r19_corporate2 = r19_corporate2;
	}
	public BigDecimal getR19_gre2() {
		return r19_gre2;
	}
	public void setR19_gre2(BigDecimal r19_gre2) {
		this.r19_gre2 = r19_gre2;
	}
	public BigDecimal getR19_individuals3() {
		return r19_individuals3;
	}
	public void setR19_individuals3(BigDecimal r19_individuals3) {
		this.r19_individuals3 = r19_individuals3;
	}
	public BigDecimal getR19_zero1() {
		return r19_zero1;
	}
	public void setR19_zero1(BigDecimal r19_zero1) {
		this.r19_zero1 = r19_zero1;
	}
	public BigDecimal getR19_three1() {
		return r19_three1;
	}
	public void setR19_three1(BigDecimal r19_three1) {
		this.r19_three1 = r19_three1;
	}
	public BigDecimal getR19_six1() {
		return r19_six1;
	}
	public void setR19_six1(BigDecimal r19_six1) {
		this.r19_six1 = r19_six1;
	}
	public BigDecimal getR19_oneyear1() {
		return r19_oneyear1;
	}
	public void setR19_oneyear1(BigDecimal r19_oneyear1) {
		this.r19_oneyear1 = r19_oneyear1;
	}
	public String getR19_empty() {
		return r19_empty;
	}
	public void setR19_empty(String r19_empty) {
		this.r19_empty = r19_empty;
	}
	public String getR20_product() {
		return r20_product;
	}
	public void setR20_product(String r20_product) {
		this.r20_product = r20_product;
	}
	public BigDecimal getR20_nbfi() {
		return r20_nbfi;
	}
	public void setR20_nbfi(BigDecimal r20_nbfi) {
		this.r20_nbfi = r20_nbfi;
	}
	public BigDecimal getR20_interbank() {
		return r20_interbank;
	}
	public void setR20_interbank(BigDecimal r20_interbank) {
		this.r20_interbank = r20_interbank;
	}
	public BigDecimal getR20_gov() {
		return r20_gov;
	}
	public void setR20_gov(BigDecimal r20_gov) {
		this.r20_gov = r20_gov;
	}
	public BigDecimal getR20_corporate() {
		return r20_corporate;
	}
	public void setR20_corporate(BigDecimal r20_corporate) {
		this.r20_corporate = r20_corporate;
	}
	public BigDecimal getR20_gre() {
		return r20_gre;
	}
	public void setR20_gre(BigDecimal r20_gre) {
		this.r20_gre = r20_gre;
	}
	public BigDecimal getR20_trade() {
		return r20_trade;
	}
	public void setR20_trade(BigDecimal r20_trade) {
		this.r20_trade = r20_trade;
	}
	public BigDecimal getR20_individuals() {
		return r20_individuals;
	}
	public void setR20_individuals(BigDecimal r20_individuals) {
		this.r20_individuals = r20_individuals;
	}
	public BigDecimal getR20_investment() {
		return r20_investment;
	}
	public void setR20_investment(BigDecimal r20_investment) {
		this.r20_investment = r20_investment;
	}
	public BigDecimal getR20_nbfi1() {
		return r20_nbfi1;
	}
	public void setR20_nbfi1(BigDecimal r20_nbfi1) {
		this.r20_nbfi1 = r20_nbfi1;
	}
	public BigDecimal getR20_interbank1() {
		return r20_interbank1;
	}
	public void setR20_interbank1(BigDecimal r20_interbank1) {
		this.r20_interbank1 = r20_interbank1;
	}
	public BigDecimal getR20_gov1() {
		return r20_gov1;
	}
	public void setR20_gov1(BigDecimal r20_gov1) {
		this.r20_gov1 = r20_gov1;
	}
	public BigDecimal getR20_corporate1() {
		return r20_corporate1;
	}
	public void setR20_corporate1(BigDecimal r20_corporate1) {
		this.r20_corporate1 = r20_corporate1;
	}
	public BigDecimal getR20_gre1() {
		return r20_gre1;
	}
	public void setR20_gre1(BigDecimal r20_gre1) {
		this.r20_gre1 = r20_gre1;
	}
	public BigDecimal getR20_trade1() {
		return r20_trade1;
	}
	public void setR20_trade1(BigDecimal r20_trade1) {
		this.r20_trade1 = r20_trade1;
	}
	public BigDecimal getR20_individuals1() {
		return r20_individuals1;
	}
	public void setR20_individuals1(BigDecimal r20_individuals1) {
		this.r20_individuals1 = r20_individuals1;
	}
	public BigDecimal getR20_investment1() {
		return r20_investment1;
	}
	public void setR20_investment1(BigDecimal r20_investment1) {
		this.r20_investment1 = r20_investment1;
	}
	public BigDecimal getR20_zer0() {
		return r20_zer0;
	}
	public void setR20_zer0(BigDecimal r20_zer0) {
		this.r20_zer0 = r20_zer0;
	}
	public BigDecimal getR20_three() {
		return r20_three;
	}
	public void setR20_three(BigDecimal r20_three) {
		this.r20_three = r20_three;
	}
	public BigDecimal getR20_six() {
		return r20_six;
	}
	public void setR20_six(BigDecimal r20_six) {
		this.r20_six = r20_six;
	}
	public BigDecimal getR20_oneyear() {
		return r20_oneyear;
	}
	public void setR20_oneyear(BigDecimal r20_oneyear) {
		this.r20_oneyear = r20_oneyear;
	}
	public BigDecimal getR20_foreign() {
		return r20_foreign;
	}
	public void setR20_foreign(BigDecimal r20_foreign) {
		this.r20_foreign = r20_foreign;
	}
	public BigDecimal getR20_banks() {
		return r20_banks;
	}
	public void setR20_banks(BigDecimal r20_banks) {
		this.r20_banks = r20_banks;
	}
	public BigDecimal getR20_gov2() {
		return r20_gov2;
	}
	public void setR20_gov2(BigDecimal r20_gov2) {
		this.r20_gov2 = r20_gov2;
	}
	public BigDecimal getR20_other() {
		return r20_other;
	}
	public void setR20_other(BigDecimal r20_other) {
		this.r20_other = r20_other;
	}
	public BigDecimal getR20_banks1() {
		return r20_banks1;
	}
	public void setR20_banks1(BigDecimal r20_banks1) {
		this.r20_banks1 = r20_banks1;
	}
	public BigDecimal getR20_individuals2() {
		return r20_individuals2;
	}
	public void setR20_individuals2(BigDecimal r20_individuals2) {
		this.r20_individuals2 = r20_individuals2;
	}
	public BigDecimal getR20_other1() {
		return r20_other1;
	}
	public void setR20_other1(BigDecimal r20_other1) {
		this.r20_other1 = r20_other1;
	}
	public BigDecimal getR20_banks2() {
		return r20_banks2;
	}
	public void setR20_banks2(BigDecimal r20_banks2) {
		this.r20_banks2 = r20_banks2;
	}
	public BigDecimal getR20_gov3() {
		return r20_gov3;
	}
	public void setR20_gov3(BigDecimal r20_gov3) {
		this.r20_gov3 = r20_gov3;
	}
	public BigDecimal getR20_others2() {
		return r20_others2;
	}
	public void setR20_others2(BigDecimal r20_others2) {
		this.r20_others2 = r20_others2;
	}
	public BigDecimal getR20_banks3() {
		return r20_banks3;
	}
	public void setR20_banks3(BigDecimal r20_banks3) {
		this.r20_banks3 = r20_banks3;
	}
	public BigDecimal getR20_gov4() {
		return r20_gov4;
	}
	public void setR20_gov4(BigDecimal r20_gov4) {
		this.r20_gov4 = r20_gov4;
	}
	public BigDecimal getR20_others3() {
		return r20_others3;
	}
	public void setR20_others3(BigDecimal r20_others3) {
		this.r20_others3 = r20_others3;
	}
	public BigDecimal getR20_foreign1() {
		return r20_foreign1;
	}
	public void setR20_foreign1(BigDecimal r20_foreign1) {
		this.r20_foreign1 = r20_foreign1;
	}
	public BigDecimal getR20_guarantees() {
		return r20_guarantees;
	}
	public void setR20_guarantees(BigDecimal r20_guarantees) {
		this.r20_guarantees = r20_guarantees;
	}
	public BigDecimal getR20_nbfi2() {
		return r20_nbfi2;
	}
	public void setR20_nbfi2(BigDecimal r20_nbfi2) {
		this.r20_nbfi2 = r20_nbfi2;
	}
	public BigDecimal getR20_interbank2() {
		return r20_interbank2;
	}
	public void setR20_interbank2(BigDecimal r20_interbank2) {
		this.r20_interbank2 = r20_interbank2;
	}
	public BigDecimal getR20_gov5() {
		return r20_gov5;
	}
	public void setR20_gov5(BigDecimal r20_gov5) {
		this.r20_gov5 = r20_gov5;
	}
	public BigDecimal getR20_corporate2() {
		return r20_corporate2;
	}
	public void setR20_corporate2(BigDecimal r20_corporate2) {
		this.r20_corporate2 = r20_corporate2;
	}
	public BigDecimal getR20_gre2() {
		return r20_gre2;
	}
	public void setR20_gre2(BigDecimal r20_gre2) {
		this.r20_gre2 = r20_gre2;
	}
	public BigDecimal getR20_individuals3() {
		return r20_individuals3;
	}
	public void setR20_individuals3(BigDecimal r20_individuals3) {
		this.r20_individuals3 = r20_individuals3;
	}
	public BigDecimal getR20_zero1() {
		return r20_zero1;
	}
	public void setR20_zero1(BigDecimal r20_zero1) {
		this.r20_zero1 = r20_zero1;
	}
	public BigDecimal getR20_three1() {
		return r20_three1;
	}
	public void setR20_three1(BigDecimal r20_three1) {
		this.r20_three1 = r20_three1;
	}
	public BigDecimal getR20_six1() {
		return r20_six1;
	}
	public void setR20_six1(BigDecimal r20_six1) {
		this.r20_six1 = r20_six1;
	}
	public BigDecimal getR20_oneyear1() {
		return r20_oneyear1;
	}
	public void setR20_oneyear1(BigDecimal r20_oneyear1) {
		this.r20_oneyear1 = r20_oneyear1;
	}
	public String getR20_empty() {
		return r20_empty;
	}
	public void setR20_empty(String r20_empty) {
		this.r20_empty = r20_empty;
	}
	public String getR21_product() {
		return r21_product;
	}
	public void setR21_product(String r21_product) {
		this.r21_product = r21_product;
	}
	public BigDecimal getR21_nbfi() {
		return r21_nbfi;
	}
	public void setR21_nbfi(BigDecimal r21_nbfi) {
		this.r21_nbfi = r21_nbfi;
	}
	public BigDecimal getR21_interbank() {
		return r21_interbank;
	}
	public void setR21_interbank(BigDecimal r21_interbank) {
		this.r21_interbank = r21_interbank;
	}
	public BigDecimal getR21_gov() {
		return r21_gov;
	}
	public void setR21_gov(BigDecimal r21_gov) {
		this.r21_gov = r21_gov;
	}
	public BigDecimal getR21_corporate() {
		return r21_corporate;
	}
	public void setR21_corporate(BigDecimal r21_corporate) {
		this.r21_corporate = r21_corporate;
	}
	public BigDecimal getR21_gre() {
		return r21_gre;
	}
	public void setR21_gre(BigDecimal r21_gre) {
		this.r21_gre = r21_gre;
	}
	public BigDecimal getR21_trade() {
		return r21_trade;
	}
	public void setR21_trade(BigDecimal r21_trade) {
		this.r21_trade = r21_trade;
	}
	public BigDecimal getR21_individuals() {
		return r21_individuals;
	}
	public void setR21_individuals(BigDecimal r21_individuals) {
		this.r21_individuals = r21_individuals;
	}
	public BigDecimal getR21_investment() {
		return r21_investment;
	}
	public void setR21_investment(BigDecimal r21_investment) {
		this.r21_investment = r21_investment;
	}
	public BigDecimal getR21_nbfi1() {
		return r21_nbfi1;
	}
	public void setR21_nbfi1(BigDecimal r21_nbfi1) {
		this.r21_nbfi1 = r21_nbfi1;
	}
	public BigDecimal getR21_interbank1() {
		return r21_interbank1;
	}
	public void setR21_interbank1(BigDecimal r21_interbank1) {
		this.r21_interbank1 = r21_interbank1;
	}
	public BigDecimal getR21_gov1() {
		return r21_gov1;
	}
	public void setR21_gov1(BigDecimal r21_gov1) {
		this.r21_gov1 = r21_gov1;
	}
	public BigDecimal getR21_corporate1() {
		return r21_corporate1;
	}
	public void setR21_corporate1(BigDecimal r21_corporate1) {
		this.r21_corporate1 = r21_corporate1;
	}
	public BigDecimal getR21_gre1() {
		return r21_gre1;
	}
	public void setR21_gre1(BigDecimal r21_gre1) {
		this.r21_gre1 = r21_gre1;
	}
	public BigDecimal getR21_trade1() {
		return r21_trade1;
	}
	public void setR21_trade1(BigDecimal r21_trade1) {
		this.r21_trade1 = r21_trade1;
	}
	public BigDecimal getR21_individuals1() {
		return r21_individuals1;
	}
	public void setR21_individuals1(BigDecimal r21_individuals1) {
		this.r21_individuals1 = r21_individuals1;
	}
	public BigDecimal getR21_investment1() {
		return r21_investment1;
	}
	public void setR21_investment1(BigDecimal r21_investment1) {
		this.r21_investment1 = r21_investment1;
	}
	public BigDecimal getR21_zer0() {
		return r21_zer0;
	}
	public void setR21_zer0(BigDecimal r21_zer0) {
		this.r21_zer0 = r21_zer0;
	}
	public BigDecimal getR21_three() {
		return r21_three;
	}
	public void setR21_three(BigDecimal r21_three) {
		this.r21_three = r21_three;
	}
	public BigDecimal getR21_six() {
		return r21_six;
	}
	public void setR21_six(BigDecimal r21_six) {
		this.r21_six = r21_six;
	}
	public BigDecimal getR21_oneyear() {
		return r21_oneyear;
	}
	public void setR21_oneyear(BigDecimal r21_oneyear) {
		this.r21_oneyear = r21_oneyear;
	}
	public BigDecimal getR21_foreign() {
		return r21_foreign;
	}
	public void setR21_foreign(BigDecimal r21_foreign) {
		this.r21_foreign = r21_foreign;
	}
	public BigDecimal getR21_banks() {
		return r21_banks;
	}
	public void setR21_banks(BigDecimal r21_banks) {
		this.r21_banks = r21_banks;
	}
	public BigDecimal getR21_gov2() {
		return r21_gov2;
	}
	public void setR21_gov2(BigDecimal r21_gov2) {
		this.r21_gov2 = r21_gov2;
	}
	public BigDecimal getR21_other() {
		return r21_other;
	}
	public void setR21_other(BigDecimal r21_other) {
		this.r21_other = r21_other;
	}
	public BigDecimal getR21_banks1() {
		return r21_banks1;
	}
	public void setR21_banks1(BigDecimal r21_banks1) {
		this.r21_banks1 = r21_banks1;
	}
	public BigDecimal getR21_individuals2() {
		return r21_individuals2;
	}
	public void setR21_individuals2(BigDecimal r21_individuals2) {
		this.r21_individuals2 = r21_individuals2;
	}
	public BigDecimal getR21_other1() {
		return r21_other1;
	}
	public void setR21_other1(BigDecimal r21_other1) {
		this.r21_other1 = r21_other1;
	}
	public BigDecimal getR21_banks2() {
		return r21_banks2;
	}
	public void setR21_banks2(BigDecimal r21_banks2) {
		this.r21_banks2 = r21_banks2;
	}
	public BigDecimal getR21_gov3() {
		return r21_gov3;
	}
	public void setR21_gov3(BigDecimal r21_gov3) {
		this.r21_gov3 = r21_gov3;
	}
	public BigDecimal getR21_others2() {
		return r21_others2;
	}
	public void setR21_others2(BigDecimal r21_others2) {
		this.r21_others2 = r21_others2;
	}
	public BigDecimal getR21_banks3() {
		return r21_banks3;
	}
	public void setR21_banks3(BigDecimal r21_banks3) {
		this.r21_banks3 = r21_banks3;
	}
	public BigDecimal getR21_gov4() {
		return r21_gov4;
	}
	public void setR21_gov4(BigDecimal r21_gov4) {
		this.r21_gov4 = r21_gov4;
	}
	public BigDecimal getR21_others3() {
		return r21_others3;
	}
	public void setR21_others3(BigDecimal r21_others3) {
		this.r21_others3 = r21_others3;
	}
	public BigDecimal getR21_foreign1() {
		return r21_foreign1;
	}
	public void setR21_foreign1(BigDecimal r21_foreign1) {
		this.r21_foreign1 = r21_foreign1;
	}
	public BigDecimal getR21_guarantees() {
		return r21_guarantees;
	}
	public void setR21_guarantees(BigDecimal r21_guarantees) {
		this.r21_guarantees = r21_guarantees;
	}
	public BigDecimal getR21_nbfi2() {
		return r21_nbfi2;
	}
	public void setR21_nbfi2(BigDecimal r21_nbfi2) {
		this.r21_nbfi2 = r21_nbfi2;
	}
	public BigDecimal getR21_interbank2() {
		return r21_interbank2;
	}
	public void setR21_interbank2(BigDecimal r21_interbank2) {
		this.r21_interbank2 = r21_interbank2;
	}
	public BigDecimal getR21_gov5() {
		return r21_gov5;
	}
	public void setR21_gov5(BigDecimal r21_gov5) {
		this.r21_gov5 = r21_gov5;
	}
	public BigDecimal getR21_corporate2() {
		return r21_corporate2;
	}
	public void setR21_corporate2(BigDecimal r21_corporate2) {
		this.r21_corporate2 = r21_corporate2;
	}
	public BigDecimal getR21_gre2() {
		return r21_gre2;
	}
	public void setR21_gre2(BigDecimal r21_gre2) {
		this.r21_gre2 = r21_gre2;
	}
	public BigDecimal getR21_individuals3() {
		return r21_individuals3;
	}
	public void setR21_individuals3(BigDecimal r21_individuals3) {
		this.r21_individuals3 = r21_individuals3;
	}
	public BigDecimal getR21_zero1() {
		return r21_zero1;
	}
	public void setR21_zero1(BigDecimal r21_zero1) {
		this.r21_zero1 = r21_zero1;
	}
	public BigDecimal getR21_three1() {
		return r21_three1;
	}
	public void setR21_three1(BigDecimal r21_three1) {
		this.r21_three1 = r21_three1;
	}
	public BigDecimal getR21_six1() {
		return r21_six1;
	}
	public void setR21_six1(BigDecimal r21_six1) {
		this.r21_six1 = r21_six1;
	}
	public BigDecimal getR21_oneyear1() {
		return r21_oneyear1;
	}
	public void setR21_oneyear1(BigDecimal r21_oneyear1) {
		this.r21_oneyear1 = r21_oneyear1;
	}
	public String getR21_empty() {
		return r21_empty;
	}
	public void setR21_empty(String r21_empty) {
		this.r21_empty = r21_empty;
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
	public BRF59A_ENTITY() {
		super();
		// TODO Auto-generated constructor stub
	}
}