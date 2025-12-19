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
@Table(name="BRF95_FUND_BASED1")

public class BRF95_FUND_BASED1 {
	
	private BigDecimal	r6_bank_st_0_loan_bal;
	private BigDecimal	r6_bank_st_0_loan_bill_amt;
	private BigDecimal	r6_bank_st_0_loan_tot_bal;
	private BigDecimal	r6_bank_st_0_loan_tot_prov;
	private BigDecimal	r6_bank_st_0_loan_int_sus;
	private BigDecimal	r6_bank_st_0_loan_crm;
	private BigDecimal	r6_bank_st_0_loan_tot_dra;
	private BigDecimal	r6_bank_st_0_inves_bal;
	private BigDecimal	r6_bank_st_0_inves_prov;
	private BigDecimal	r6_bank_st_0_inves_crm;
	private BigDecimal	r6_bank_st_0_inves_rwa;
	private BigDecimal	r6_bank_st_0_plac_bal;
	private BigDecimal	r6_bank_st_0_plac_prov;
	private BigDecimal	r6_bank_st_0_plac_crm;
	private BigDecimal	r6_bank_st_0_plac_rwa;
	private BigDecimal	r6_bank_st_0_cash_bal;
	private BigDecimal	r6_bank_st_0_cash_prov;
	private BigDecimal	r6_bank_st_0_cash_crm;
	private BigDecimal	r6_bank_st_0_cash_rwa;
	private BigDecimal	r6_bank_st_0_tot_bal;
	private BigDecimal	r6_bank_st_0_tot_prov;
	private BigDecimal	r6_bank_st_0_tot_int_sus;
	private BigDecimal	r6_bank_st_0_tot_crm;
	private BigDecimal	r6_bank_st_0_tot_rwa;
	private BigDecimal	r7_bank_st_20_loan_bal;
	private BigDecimal	r7_bank_st_20_loan_bill_amt;
	private BigDecimal	r7_bank_st_20_loan_tot_bal;
	private BigDecimal	r7_bank_st_20_loan_tot_prov;
	private BigDecimal	r7_bank_st_20_loan_int_sus;
	private BigDecimal	r7_bank_st_20_loan_crm;
	private BigDecimal	r7_bank_st_20_loan_tot_dra;
	private BigDecimal	r7_bank_st_20_inves_bal;
	private BigDecimal	r7_bank_st_20_inves_prov;
	private BigDecimal	r7_bank_st_20_inves_crm;
	private BigDecimal	r7_bank_st_20_inves_rwa;
	private BigDecimal	r7_bank_st_20_plac_bal;
	private BigDecimal	r7_bank_st_20_plac_prov;
	private BigDecimal	r7_bank_st_20_plac_crm;
	private BigDecimal	r7_bank_st_20_plac_rwa;
	private BigDecimal	r7_bank_st_20_cash_bal;
	private BigDecimal	r7_bank_st_20_cash_prov;
	private BigDecimal	r7_bank_st_20_cash_crm;
	private BigDecimal	r7_bank_st_20_cash_rwa;
	private BigDecimal	r7_bank_st_20_tot_bal;
	private BigDecimal	r7_bank_st_20_tot_prov;
	private BigDecimal	r7_bank_st_20_tot_int_sus;
	private BigDecimal	r7_bank_st_20_tot_crm;
	private BigDecimal	r7_bank_st_20_tot_rwa;
	private BigDecimal	r8_bank_st_50_loan_bal;
	private BigDecimal	r8_bank_st_50_loan_bill_amt;
	private BigDecimal	r8_bank_st_50_loan_tot_bal;
	private BigDecimal	r8_bank_st_50_loan_tot_prov;
	private BigDecimal	r8_bank_st_50_loan_int_sus;
	private BigDecimal	r8_bank_st_50_loan_crm;
	private BigDecimal	r8_bank_st_50_loan_tot_dra;
	private BigDecimal	r8_bank_st_50_inves_bal;
	private BigDecimal	r8_bank_st_50_inves_prov;
	private BigDecimal	r8_bank_st_50_inves_crm;
	private BigDecimal	r8_bank_st_50_inves_rwa;
	private BigDecimal	r8_bank_st_50_plac_bal;
	private BigDecimal	r8_bank_st_50_plac_prov;
	private BigDecimal	r8_bank_st_50_plac_crm;
	private BigDecimal	r8_bank_st_50_plac_rwa;
	private BigDecimal	r8_bank_st_50_cash_bal;
	private BigDecimal	r8_bank_st_50_cash_prov;
	private BigDecimal	r8_bank_st_50_cash_crm;
	private BigDecimal	r8_bank_st_50_cash_rwa;
	private BigDecimal	r8_bank_st_50_tot_bal;
	private BigDecimal	r8_bank_st_50_tot_prov;
	private BigDecimal	r8_bank_st_50_tot_int_sus;
	private BigDecimal	r8_bank_st_50_tot_crm;
	private BigDecimal	r8_bank_st_50_tot_rwa;
	private BigDecimal	r9_bank_st_100_loan_bal;
	private BigDecimal	r9_bank_st_100_loan_bill_amt;
	private BigDecimal	r9_bank_st_100_loan_tot_bal;
	private BigDecimal	r9_bank_st_100_loan_tot_prov;
	private BigDecimal	r9_bank_st_100_loan_int_sus;
	private BigDecimal	r9_bank_st_100_loan_crm;
	private BigDecimal	r9_bank_st_100_loan_tot_dra;
	private BigDecimal	r9_bank_st_100_inves_bal;
	private BigDecimal	r9_bank_st_100_inves_prov;
	private BigDecimal	r9_bank_st_100_inves_crm;
	private BigDecimal	r9_bank_st_100_inves_rwa;
	private BigDecimal	r9_bank_st_100_plac_bal;
	private BigDecimal	r9_bank_st_100_plac_prov;
	private BigDecimal	r9_bank_st_100_plac_crm;
	private BigDecimal	r9_bank_st_100_plac_rwa;
	private BigDecimal	r9_bank_st_100_cash_bal;
	private BigDecimal	r9_bank_st_100_cash_prov;
	private BigDecimal	r9_bank_st_100_cash_crm;
	private BigDecimal	r9_bank_st_100_cash_rwa;
	private BigDecimal	r9_bank_st_100_tot_bal;
	private BigDecimal	r9_bank_st_100_tot_prov;
	private BigDecimal	r9_bank_st_100_tot_int_sus;
	private BigDecimal	r9_bank_st_100_tot_crm;
	private BigDecimal	r9_bank_st_100_tot_rwa;
	private BigDecimal	r10_bank_st_150_loan_bal;
	private BigDecimal	r10_bank_st_150_loan_bill_amt;
	private BigDecimal	r10_bank_st_150_loan_tot_bal;
	private BigDecimal	r10_bank_st_150_loan_tot_prov;
	private BigDecimal	r10_bank_st_150_loan_int_sus;
	private BigDecimal	r10_bank_st_150_loan_crm;
	private BigDecimal	r10_bank_st_150_loan_tot_dra;
	private BigDecimal	r10_bank_st_150_inves_bal;
	private BigDecimal	r10_bank_st_150_inves_prov;
	private BigDecimal	r10_bank_st_150_inves_crm;
	private BigDecimal	r10_bank_st_150_inves_rwa;
	private BigDecimal	r10_bank_st_150_plac_bal;
	private BigDecimal	r10_bank_st_150_plac_prov;
	private BigDecimal	r10_bank_st_150_plac_crm;
	private BigDecimal	r10_bank_st_150_plac_rwa;
	private BigDecimal	r10_bank_st_150_cash_bal;
	private BigDecimal	r10_bank_st_150_cash_prov;
	private BigDecimal	r10_bank_st_150_cash_crm;
	private BigDecimal	r10_bank_st_150_cash_rwa;
	private BigDecimal	r10_bank_st_150_tot_bal;
	private BigDecimal	r10_bank_st_150_tot_prov;
	private BigDecimal	r10_bank_st_150_tot_int_sus;
	private BigDecimal	r10_bank_st_150_tot_crm;
	private BigDecimal	r10_bank_st_150_tot_rwa;
	private BigDecimal	r11_bank_lt_0_loan_bal;
	private BigDecimal	r11_bank_lt_0_loan_bill_amt;
	private BigDecimal	r11_bank_lt_0_loan_tot_bal;
	private BigDecimal	r11_bank_lt_0_loan_tot_prov;
	private BigDecimal	r11_bank_lt_0_loan_int_sus;
	private BigDecimal	r11_bank_lt_0_loan_crm;
	private BigDecimal	r11_bank_lt_0_loan_tot_dra;
	private BigDecimal	r11_bank_lt_0_inves_bal;
	private BigDecimal	r11_bank_lt_0_inves_prov;
	private BigDecimal	r11_bank_lt_0_inves_crm;
	private BigDecimal	r11_bank_lt_0_inves_rwa;
	private BigDecimal	r11_bank_lt_0_plac_bal;
	private BigDecimal	r11_bank_lt_0_plac_prov;
	private BigDecimal	r11_bank_lt_0_plac_crm;
	private BigDecimal	r11_bank_lt_0_plac_rwa;
	private BigDecimal	r11_bank_lt_0_cash_bal;
	private BigDecimal	r11_bank_lt_0_cash_prov;
	private BigDecimal	r11_bank_lt_0_cash_crm;
	private BigDecimal	r11_bank_lt_0_cash_rwa;
	private BigDecimal	r11_bank_lt_0_tot_bal;
	private BigDecimal	r11_bank_lt_0_tot_prov;
	private BigDecimal	r11_bank_lt_0_tot_int_sus;
	private BigDecimal	r11_bank_lt_0_tot_crm;
	private BigDecimal	r11_bank_lt_0_tot_rwa;
	private BigDecimal	r12_bank_lt_20_loan_bal;
	private BigDecimal	r12_bank_lt_20_loan_bill_amt;
	private BigDecimal	r12_bank_lt_20_loan_tot_bal;
	private BigDecimal	r12_bank_lt_20_loan_tot_prov;
	private BigDecimal	r12_bank_lt_20_loan_int_sus;
	private BigDecimal	r12_bank_lt_20_loan_crm;
	private BigDecimal	r12_bank_lt_20_loan_tot_dra;
	private BigDecimal	r12_bank_lt_20_inves_bal;
	private BigDecimal	r12_bank_lt_20_inves_prov;
	private BigDecimal	r12_bank_lt_20_inves_crm;
	private BigDecimal	r12_bank_lt_20_inves_rwa;
	private BigDecimal	r12_bank_lt_20_plac_bal;
	private BigDecimal	r12_bank_lt_20_plac_prov;
	private BigDecimal	r12_bank_lt_20_plac_crm;
	private BigDecimal	r12_bank_lt_20_plac_rwa;
	private BigDecimal	r12_bank_lt_20_cash_bal;
	private BigDecimal	r12_bank_lt_20_cash_prov;
	private BigDecimal	r12_bank_lt_20_cash_crm;
	private BigDecimal	r12_bank_lt_20_cash_rwa;
	private BigDecimal	r12_bank_lt_20_tot_bal;
	private BigDecimal	r12_bank_lt_20_tot_prov;
	private BigDecimal	r12_bank_lt_20_tot_int_sus;
	private BigDecimal	r12_bank_lt_20_tot_crm;
	private BigDecimal	r12_bank_lt_20_tot_rwa;
	private BigDecimal	r13_bank_lt_50_loan_bal;
	private BigDecimal	r13_bank_lt_50_loan_bill_amt;
	private BigDecimal	r13_bank_lt_50_loan_tot_bal;
	private BigDecimal	r13_bank_lt_50_loan_tot_prov;
	private BigDecimal	r13_bank_lt_50_loan_int_sus;
	private BigDecimal	r13_bank_lt_50_loan_crm;
	private BigDecimal	r13_bank_lt_50_loan_tot_dra;
	private BigDecimal	r13_bank_lt_50_inves_bal;
	private BigDecimal	r13_bank_lt_50_inves_prov;
	private BigDecimal	r13_bank_lt_50_inves_crm;
	private BigDecimal	r13_bank_lt_50_inves_rwa;
	private BigDecimal	r13_bank_lt_50_plac_bal;
	private BigDecimal	r13_bank_lt_50_plac_prov;
	private BigDecimal	r13_bank_lt_50_plac_crm;
	private BigDecimal	r13_bank_lt_50_plac_rwa;
	private BigDecimal	r13_bank_lt_50_cash_bal;
	private BigDecimal	r13_bank_lt_50_cash_prov;
	private BigDecimal	r13_bank_lt_50_cash_crm;
	private BigDecimal	r13_bank_lt_50_cash_rwa;
	private BigDecimal	r13_bank_lt_50_tot_bal;
	private BigDecimal	r13_bank_lt_50_tot_prov;
	private BigDecimal	r13_bank_lt_50_tot_int_sus;
	private BigDecimal	r13_bank_lt_50_tot_crm;
	private BigDecimal	r13_bank_lt_50_tot_rwa;
	private BigDecimal	r14_bank_lt_100_loan_bal;
	private BigDecimal	r14_bank_lt_100_loan_bill_amt;
	private BigDecimal	r14_bank_lt_100_loan_tot_bal;
	private BigDecimal	r14_bank_lt_100_loan_tot_prov;
	private BigDecimal	r14_bank_lt_100_loan_int_sus;
	private BigDecimal	r14_bank_lt_100_loan_crm;
	private BigDecimal	r14_bank_lt_100_loan_tot_dra;
	private BigDecimal	r14_bank_lt_100_inves_bal;
	private BigDecimal	r14_bank_lt_100_inves_prov;
	private BigDecimal	r14_bank_lt_100_inves_crm;
	private BigDecimal	r14_bank_lt_100_inves_rwa;
	private BigDecimal	r14_bank_lt_100_plac_bal;
	private BigDecimal	r14_bank_lt_100_plac_prov;
	private BigDecimal	r14_bank_lt_100_plac_crm;
	private BigDecimal	r14_bank_lt_100_plac_rwa;
	private BigDecimal	r14_bank_lt_100_cash_bal;
	private BigDecimal	r14_bank_lt_100_cash_prov;
	private BigDecimal	r14_bank_lt_100_cash_crm;
	private BigDecimal	r14_bank_lt_100_cash_rwa;
	private BigDecimal	r14_bank_lt_100_tot_bal;
	private BigDecimal	r14_bank_lt_100_tot_prov;
	private BigDecimal	r14_bank_lt_100_tot_int_sus;
	private BigDecimal	r14_bank_lt_100_tot_crm;
	private BigDecimal	r14_bank_lt_100_tot_rwa;
	private BigDecimal	r15_bank_lt_150_loan_bal;
	private BigDecimal	r15_bank_lt_150_loan_bill_amt;
	private BigDecimal	r15_bank_lt_150_loan_tot_bal;
	private BigDecimal	r15_bank_lt_150_loan_tot_prov;
	private BigDecimal	r15_bank_lt_150_loan_int_sus;
	private BigDecimal	r15_bank_lt_150_loan_crm;
	private BigDecimal	r15_bank_lt_150_loan_tot_dra;
	private BigDecimal	r15_bank_lt_150_inves_bal;
	private BigDecimal	r15_bank_lt_150_inves_prov;
	private BigDecimal	r15_bank_lt_150_inves_crm;
	private BigDecimal	r15_bank_lt_150_inves_rwa;
	private BigDecimal	r15_bank_lt_150_plac_bal;
	private BigDecimal	r15_bank_lt_150_plac_prov;
	private BigDecimal	r15_bank_lt_150_plac_crm;
	private BigDecimal	r15_bank_lt_150_plac_rwa;
	private BigDecimal	r15_bank_lt_150_cash_bal;
	private BigDecimal	r15_bank_lt_150_cash_prov;
	private BigDecimal	r15_bank_lt_150_cash_crm;
	private BigDecimal	r15_bank_lt_150_cash_rwa;
	private BigDecimal	r15_bank_lt_150_tot_bal;
	private BigDecimal	r15_bank_lt_150_tot_prov;
	private BigDecimal	r15_bank_lt_150_tot_int_sus;
	private BigDecimal	r15_bank_lt_150_tot_crm;
	private BigDecimal	r15_bank_lt_150_tot_rwa;
	private BigDecimal	r16_cbs_0_loan_bal;
	private BigDecimal	r16_cbs_0_loan_bill_amt;
	private BigDecimal	r16_cbs_0_loan_tot_bal;
	private BigDecimal	r16_cbs_0_loan_tot_prov;
	private BigDecimal	r16_cbs_0_loan_int_sus;
	private BigDecimal	r16_cbs_0_loan_crm;
	private BigDecimal	r16_cbs_0_loan_tot_dra;
	private BigDecimal	r16_cbs_0_inves_bal;
	private BigDecimal	r16_cbs_0_inves_prov;
	private BigDecimal	r16_cbs_0_inves_crm;
	private BigDecimal	r16_cbs_0_inves_rwa;
	private BigDecimal	r16_cbs_0_plac_bal;
	private BigDecimal	r16_cbs_0_plac_prov;
	private BigDecimal	r16_cbs_0_plac_crm;
	private BigDecimal	r16_cbs_0_plac_rwa;
	private BigDecimal	r16_cbs_0_cash_bal;
	private BigDecimal	r16_cbs_0_cash_prov;
	private BigDecimal	r16_cbs_0_cash_crm;
	private BigDecimal	r16_cbs_0_cash_rwa;
	private BigDecimal	r16_cbs_0_tot_bal;
	private BigDecimal	r16_cbs_0_tot_prov;
	private BigDecimal	r16_cbs_0_tot_int_sus;
	private BigDecimal	r16_cbs_0_tot_crm;
	private BigDecimal	r16_cbs_0_tot_rwa;
	private BigDecimal	r17_cbs_20_loan_bal;
	private BigDecimal	r17_cbs_20_loan_bill_amt;
	private BigDecimal	r17_cbs_20_loan_tot_bal;
	private BigDecimal	r17_cbs_20_loan_tot_prov;
	private BigDecimal	r17_cbs_20_loan_int_sus;
	private BigDecimal	r17_cbs_20_loan_crm;
	private BigDecimal	r17_cbs_20_loan_tot_dra;
	private BigDecimal	r17_cbs_20_inves_bal;
	private BigDecimal	r17_cbs_20_inves_prov;
	private BigDecimal	r17_cbs_20_inves_crm;
	private BigDecimal	r17_cbs_20_inves_rwa;
	private BigDecimal	r17_cbs_20_plac_bal;
	private BigDecimal	r17_cbs_20_plac_prov;
	private BigDecimal	r17_cbs_20_plac_crm;
	private BigDecimal	r17_cbs_20_plac_rwa;
	private BigDecimal	r17_cbs_20_cash_bal;
	private BigDecimal	r17_cbs_20_cash_prov;
	private BigDecimal	r17_cbs_20_cash_crm;
	private BigDecimal	r17_cbs_20_cash_rwa;
	private BigDecimal	r17_cbs_20_tot_bal;
	private BigDecimal	r17_cbs_20_tot_prov;
	private BigDecimal	r17_cbs_20_tot_int_sus;
	private BigDecimal	r17_cbs_20_tot_crm;
	private BigDecimal	r17_cbs_20_tot_rwa;
	private BigDecimal	r18_cbs_20_loan_bal;
	private BigDecimal	r18_cbs_20_loan_bill_amt;
	private BigDecimal	r18_cbs_20_loan_tot_bal;
	private BigDecimal	r18_cbs_20_loan_tot_prov;
	private BigDecimal	r18_cbs_20_loan_int_sus;
	private BigDecimal	r18_cbs_20_loan_crm;
	private BigDecimal	r18_cbs_20_loan_tot_dra;
	private BigDecimal	r18_cbs_20_inves_bal;
	private BigDecimal	r18_cbs_20_inves_prov;
	private BigDecimal	r18_cbs_20_inves_crm;
	private BigDecimal	r18_cbs_20_inves_rwa;
	private BigDecimal	r18_cbs_20_plac_bal;
	private BigDecimal	r18_cbs_20_plac_prov;
	private BigDecimal	r18_cbs_20_plac_crm;
	private BigDecimal	r18_cbs_20_plac_rwa;
	private BigDecimal	r18_cbs_20_cash_bal;
	private BigDecimal	r18_cbs_20_cash_prov;
	private BigDecimal	r18_cbs_20_cash_crm;
	private BigDecimal	r18_cbs_20_cash_rwa;
	private BigDecimal	r18_cbs_20_tot_bal;
	private BigDecimal	r18_cbs_20_tot_prov;
	private BigDecimal	r18_cbs_20_tot_int_sus;
	private BigDecimal	r18_cbs_20_tot_crm;
	private BigDecimal	r18_cbs_20_tot_rwa;
	private BigDecimal	r19_cbs_0_loan_bal;
	private BigDecimal	r19_cbs_0_loan_bill_amt;
	private BigDecimal	r19_cbs_0_loan_tot_bal;
	private BigDecimal	r19_cbs_0_loan_tot_prov;
	private BigDecimal	r19_cbs_0_loan_int_sus;
	private BigDecimal	r19_cbs_0_loan_crm;
	private BigDecimal	r19_cbs_0_loan_tot_dra;
	private BigDecimal	r19_cbs_0_inves_bal;
	private BigDecimal	r19_cbs_0_inves_prov;
	private BigDecimal	r19_cbs_0_inves_crm;
	private BigDecimal	r19_cbs_0_inves_rwa;
	private BigDecimal	r19_cbs_0_plac_bal;
	private BigDecimal	r19_cbs_0_plac_prov;
	private BigDecimal	r19_cbs_0_plac_crm;
	private BigDecimal	r19_cbs_0_plac_rwa;
	private BigDecimal	r19_cbs_0_cash_bal;
	private BigDecimal	r19_cbs_0_cash_prov;
	private BigDecimal	r19_cbs_0_cash_crm;
	private BigDecimal	r19_cbs_0_cash_rwa;
	private BigDecimal	r19_cbs_0_tot_bal;
	private BigDecimal	r19_cbs_0_tot_prov;
	private BigDecimal	r19_cbs_0_tot_int_sus;
	private BigDecimal	r19_cbs_0_tot_crm;
	private BigDecimal	r19_cbs_0_tot_rwa;
	private BigDecimal	r20_cbs_20_loan_bal;
	private BigDecimal	r20_cbs_20_loan_bill_amt;
	private BigDecimal	r20_cbs_20_loan_tot_bal;
	private BigDecimal	r20_cbs_20_loan_tot_prov;
	private BigDecimal	r20_cbs_20_loan_int_sus;
	private BigDecimal	r20_cbs_20_loan_crm;
	private BigDecimal	r20_cbs_20_loan_tot_dra;
	private BigDecimal	r20_cbs_20_inves_bal;
	private BigDecimal	r20_cbs_20_inves_prov;
	private BigDecimal	r20_cbs_20_inves_crm;
	private BigDecimal	r20_cbs_20_inves_rwa;
	private BigDecimal	r20_cbs_20_plac_bal;
	private BigDecimal	r20_cbs_20_plac_prov;
	private BigDecimal	r20_cbs_20_plac_crm;
	private BigDecimal	r20_cbs_20_plac_rwa;
	private BigDecimal	r20_cbs_20_cash_bal;
	private BigDecimal	r20_cbs_20_cash_prov;
	private BigDecimal	r20_cbs_20_cash_crm;
	private BigDecimal	r20_cbs_20_cash_rwa;
	private BigDecimal	r20_cbs_20_tot_bal;
	private BigDecimal	r20_cbs_20_tot_prov;
	private BigDecimal	r20_cbs_20_tot_int_sus;
	private BigDecimal	r20_cbs_20_tot_crm;
	private BigDecimal	r20_cbs_20_tot_rwa;
	private BigDecimal	r21_cbs_50_loan_bal;
	private BigDecimal	r21_cbs_50_loan_bill_amt;
	private BigDecimal	r21_cbs_50_loan_tot_bal;
	private BigDecimal	r21_cbs_50_loan_tot_prov;
	private BigDecimal	r21_cbs_50_loan_int_sus;
	private BigDecimal	r21_cbs_50_loan_crm;
	private BigDecimal	r21_cbs_50_loan_tot_dra;
	private BigDecimal	r21_cbs_50_inves_bal;
	private BigDecimal	r21_cbs_50_inves_prov;
	private BigDecimal	r21_cbs_50_inves_crm;
	private BigDecimal	r21_cbs_50_inves_rwa;
	private BigDecimal	r21_cbs_50_plac_bal;
	private BigDecimal	r21_cbs_50_plac_prov;
	private BigDecimal	r21_cbs_50_plac_crm;
	private BigDecimal	r21_cbs_50_plac_rwa;
	private BigDecimal	r21_cbs_50_cash_bal;
	private BigDecimal	r21_cbs_50_cash_prov;
	private BigDecimal	r21_cbs_50_cash_crm;
	private BigDecimal	r21_cbs_50_cash_rwa;
	private BigDecimal	r21_cbs_50_tot_bal;
	private BigDecimal	r21_cbs_50_tot_prov;
	private BigDecimal	r21_cbs_50_tot_int_sus;
	private BigDecimal	r21_cbs_50_tot_crm;
	private BigDecimal	r21_cbs_50_tot_rwa;
	private BigDecimal	r22_cbs_100_loan_bal;
	private BigDecimal	r22_cbs_100_loan_bill_amt;
	private BigDecimal	r22_cbs_100_loan_tot_bal;
	private BigDecimal	r22_cbs_100_loan_tot_prov;
	private BigDecimal	r22_cbs_100_loan_int_sus;
	private BigDecimal	r22_cbs_100_loan_crm;
	private BigDecimal	r22_cbs_100_loan_tot_dra;
	private BigDecimal	r22_cbs_100_inves_bal;
	private BigDecimal	r22_cbs_100_inves_prov;
	private BigDecimal	r22_cbs_100_inves_crm;
	private BigDecimal	r22_cbs_100_inves_rwa;
	private BigDecimal	r22_cbs_100_plac_bal;
	private BigDecimal	r22_cbs_100_plac_prov;
	private BigDecimal	r22_cbs_100_plac_crm;
	private BigDecimal	r22_cbs_100_plac_rwa;
	private BigDecimal	r22_cbs_100_cash_bal;
	private BigDecimal	r22_cbs_100_cash_prov;
	private BigDecimal	r22_cbs_100_cash_crm;
	private BigDecimal	r22_cbs_100_cash_rwa;
	private BigDecimal	r22_cbs_100_tot_bal;
	private BigDecimal	r22_cbs_100_tot_prov;
	private BigDecimal	r22_cbs_100_tot_int_sus;
	private BigDecimal	r22_cbs_100_tot_crm;
	private BigDecimal	r22_cbs_100_tot_rwa;
	private BigDecimal	r23_cbs_150_loan_bal;
	private BigDecimal	r23_cbs_150_loan_bill_amt;
	private BigDecimal	r23_cbs_150_loan_tot_bal;
	private BigDecimal	r23_cbs_150_loan_tot_prov;
	private BigDecimal	r23_cbs_150_loan_int_sus;
	private BigDecimal	r23_cbs_150_loan_crm;
	private BigDecimal	r23_cbs_150_loan_tot_dra;
	private BigDecimal	r23_cbs_150_inves_bal;
	private BigDecimal	r23_cbs_150_inves_prov;
	private BigDecimal	r23_cbs_150_inves_crm;
	private BigDecimal	r23_cbs_150_inves_rwa;
	private BigDecimal	r23_cbs_150_plac_bal;
	private BigDecimal	r23_cbs_150_plac_prov;
	private BigDecimal	r23_cbs_150_plac_crm;
	private BigDecimal	r23_cbs_150_plac_rwa;
	private BigDecimal	r23_cbs_150_cash_bal;
	private BigDecimal	r23_cbs_150_cash_prov;
	private BigDecimal	r23_cbs_150_cash_crm;
	private BigDecimal	r23_cbs_150_cash_rwa;
	private BigDecimal	r23_cbs_150_tot_bal;
	private BigDecimal	r23_cbs_150_tot_prov;
	private BigDecimal	r23_cbs_150_tot_int_sus;
	private BigDecimal	r23_cbs_150_tot_crm;
	private BigDecimal	r23_cbs_150_tot_rwa;

	private Date	report_submit_date;
	@Id
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date	report_date;
	private Date	report_from_date;
	private Date	report_to_date;
	private String	report_code;
	private String	entity_flg;
	private String	modify_flg;
    private String	del_flg;
	public BigDecimal getR6_bank_st_0_loan_bal() {
		return r6_bank_st_0_loan_bal;
	}
	public void setR6_bank_st_0_loan_bal(BigDecimal r6_bank_st_0_loan_bal) {
		this.r6_bank_st_0_loan_bal = r6_bank_st_0_loan_bal;
	}
	public BigDecimal getR6_bank_st_0_loan_bill_amt() {
		return r6_bank_st_0_loan_bill_amt;
	}
	public void setR6_bank_st_0_loan_bill_amt(BigDecimal r6_bank_st_0_loan_bill_amt) {
		this.r6_bank_st_0_loan_bill_amt = r6_bank_st_0_loan_bill_amt;
	}
	public BigDecimal getR6_bank_st_0_loan_tot_bal() {
		return r6_bank_st_0_loan_tot_bal;
	}
	public void setR6_bank_st_0_loan_tot_bal(BigDecimal r6_bank_st_0_loan_tot_bal) {
		this.r6_bank_st_0_loan_tot_bal = r6_bank_st_0_loan_tot_bal;
	}
	public BigDecimal getR6_bank_st_0_loan_tot_prov() {
		return r6_bank_st_0_loan_tot_prov;
	}
	public void setR6_bank_st_0_loan_tot_prov(BigDecimal r6_bank_st_0_loan_tot_prov) {
		this.r6_bank_st_0_loan_tot_prov = r6_bank_st_0_loan_tot_prov;
	}
	public BigDecimal getR6_bank_st_0_loan_int_sus() {
		return r6_bank_st_0_loan_int_sus;
	}
	public void setR6_bank_st_0_loan_int_sus(BigDecimal r6_bank_st_0_loan_int_sus) {
		this.r6_bank_st_0_loan_int_sus = r6_bank_st_0_loan_int_sus;
	}
	public BigDecimal getR6_bank_st_0_loan_crm() {
		return r6_bank_st_0_loan_crm;
	}
	public void setR6_bank_st_0_loan_crm(BigDecimal r6_bank_st_0_loan_crm) {
		this.r6_bank_st_0_loan_crm = r6_bank_st_0_loan_crm;
	}
	public BigDecimal getR6_bank_st_0_loan_tot_dra() {
		return r6_bank_st_0_loan_tot_dra;
	}
	public void setR6_bank_st_0_loan_tot_dra(BigDecimal r6_bank_st_0_loan_tot_dra) {
		this.r6_bank_st_0_loan_tot_dra = r6_bank_st_0_loan_tot_dra;
	}
	public BigDecimal getR6_bank_st_0_inves_bal() {
		return r6_bank_st_0_inves_bal;
	}
	public void setR6_bank_st_0_inves_bal(BigDecimal r6_bank_st_0_inves_bal) {
		this.r6_bank_st_0_inves_bal = r6_bank_st_0_inves_bal;
	}
	public BigDecimal getR6_bank_st_0_inves_prov() {
		return r6_bank_st_0_inves_prov;
	}
	public void setR6_bank_st_0_inves_prov(BigDecimal r6_bank_st_0_inves_prov) {
		this.r6_bank_st_0_inves_prov = r6_bank_st_0_inves_prov;
	}
	public BigDecimal getR6_bank_st_0_inves_crm() {
		return r6_bank_st_0_inves_crm;
	}
	public void setR6_bank_st_0_inves_crm(BigDecimal r6_bank_st_0_inves_crm) {
		this.r6_bank_st_0_inves_crm = r6_bank_st_0_inves_crm;
	}
	public BigDecimal getR6_bank_st_0_inves_rwa() {
		return r6_bank_st_0_inves_rwa;
	}
	public void setR6_bank_st_0_inves_rwa(BigDecimal r6_bank_st_0_inves_rwa) {
		this.r6_bank_st_0_inves_rwa = r6_bank_st_0_inves_rwa;
	}
	public BigDecimal getR6_bank_st_0_plac_bal() {
		return r6_bank_st_0_plac_bal;
	}
	public void setR6_bank_st_0_plac_bal(BigDecimal r6_bank_st_0_plac_bal) {
		this.r6_bank_st_0_plac_bal = r6_bank_st_0_plac_bal;
	}
	public BigDecimal getR6_bank_st_0_plac_prov() {
		return r6_bank_st_0_plac_prov;
	}
	public void setR6_bank_st_0_plac_prov(BigDecimal r6_bank_st_0_plac_prov) {
		this.r6_bank_st_0_plac_prov = r6_bank_st_0_plac_prov;
	}
	public BigDecimal getR6_bank_st_0_plac_crm() {
		return r6_bank_st_0_plac_crm;
	}
	public void setR6_bank_st_0_plac_crm(BigDecimal r6_bank_st_0_plac_crm) {
		this.r6_bank_st_0_plac_crm = r6_bank_st_0_plac_crm;
	}
	public BigDecimal getR6_bank_st_0_plac_rwa() {
		return r6_bank_st_0_plac_rwa;
	}
	public void setR6_bank_st_0_plac_rwa(BigDecimal r6_bank_st_0_plac_rwa) {
		this.r6_bank_st_0_plac_rwa = r6_bank_st_0_plac_rwa;
	}
	public BigDecimal getR6_bank_st_0_cash_bal() {
		return r6_bank_st_0_cash_bal;
	}
	public void setR6_bank_st_0_cash_bal(BigDecimal r6_bank_st_0_cash_bal) {
		this.r6_bank_st_0_cash_bal = r6_bank_st_0_cash_bal;
	}
	public BigDecimal getR6_bank_st_0_cash_prov() {
		return r6_bank_st_0_cash_prov;
	}
	public void setR6_bank_st_0_cash_prov(BigDecimal r6_bank_st_0_cash_prov) {
		this.r6_bank_st_0_cash_prov = r6_bank_st_0_cash_prov;
	}
	public BigDecimal getR6_bank_st_0_cash_crm() {
		return r6_bank_st_0_cash_crm;
	}
	public void setR6_bank_st_0_cash_crm(BigDecimal r6_bank_st_0_cash_crm) {
		this.r6_bank_st_0_cash_crm = r6_bank_st_0_cash_crm;
	}
	public BigDecimal getR6_bank_st_0_cash_rwa() {
		return r6_bank_st_0_cash_rwa;
	}
	public void setR6_bank_st_0_cash_rwa(BigDecimal r6_bank_st_0_cash_rwa) {
		this.r6_bank_st_0_cash_rwa = r6_bank_st_0_cash_rwa;
	}
	public BigDecimal getR6_bank_st_0_tot_bal() {
		return r6_bank_st_0_tot_bal;
	}
	public void setR6_bank_st_0_tot_bal(BigDecimal r6_bank_st_0_tot_bal) {
		this.r6_bank_st_0_tot_bal = r6_bank_st_0_tot_bal;
	}
	public BigDecimal getR6_bank_st_0_tot_prov() {
		return r6_bank_st_0_tot_prov;
	}
	public void setR6_bank_st_0_tot_prov(BigDecimal r6_bank_st_0_tot_prov) {
		this.r6_bank_st_0_tot_prov = r6_bank_st_0_tot_prov;
	}
	public BigDecimal getR6_bank_st_0_tot_int_sus() {
		return r6_bank_st_0_tot_int_sus;
	}
	public void setR6_bank_st_0_tot_int_sus(BigDecimal r6_bank_st_0_tot_int_sus) {
		this.r6_bank_st_0_tot_int_sus = r6_bank_st_0_tot_int_sus;
	}
	public BigDecimal getR6_bank_st_0_tot_crm() {
		return r6_bank_st_0_tot_crm;
	}
	public void setR6_bank_st_0_tot_crm(BigDecimal r6_bank_st_0_tot_crm) {
		this.r6_bank_st_0_tot_crm = r6_bank_st_0_tot_crm;
	}
	public BigDecimal getR6_bank_st_0_tot_rwa() {
		return r6_bank_st_0_tot_rwa;
	}
	public void setR6_bank_st_0_tot_rwa(BigDecimal r6_bank_st_0_tot_rwa) {
		this.r6_bank_st_0_tot_rwa = r6_bank_st_0_tot_rwa;
	}
	public BigDecimal getR7_bank_st_20_loan_bal() {
		return r7_bank_st_20_loan_bal;
	}
	public void setR7_bank_st_20_loan_bal(BigDecimal r7_bank_st_20_loan_bal) {
		this.r7_bank_st_20_loan_bal = r7_bank_st_20_loan_bal;
	}
	public BigDecimal getR7_bank_st_20_loan_bill_amt() {
		return r7_bank_st_20_loan_bill_amt;
	}
	public void setR7_bank_st_20_loan_bill_amt(BigDecimal r7_bank_st_20_loan_bill_amt) {
		this.r7_bank_st_20_loan_bill_amt = r7_bank_st_20_loan_bill_amt;
	}
	public BigDecimal getR7_bank_st_20_loan_tot_bal() {
		return r7_bank_st_20_loan_tot_bal;
	}
	public void setR7_bank_st_20_loan_tot_bal(BigDecimal r7_bank_st_20_loan_tot_bal) {
		this.r7_bank_st_20_loan_tot_bal = r7_bank_st_20_loan_tot_bal;
	}
	public BigDecimal getR7_bank_st_20_loan_tot_prov() {
		return r7_bank_st_20_loan_tot_prov;
	}
	public void setR7_bank_st_20_loan_tot_prov(BigDecimal r7_bank_st_20_loan_tot_prov) {
		this.r7_bank_st_20_loan_tot_prov = r7_bank_st_20_loan_tot_prov;
	}
	public BigDecimal getR7_bank_st_20_loan_int_sus() {
		return r7_bank_st_20_loan_int_sus;
	}
	public void setR7_bank_st_20_loan_int_sus(BigDecimal r7_bank_st_20_loan_int_sus) {
		this.r7_bank_st_20_loan_int_sus = r7_bank_st_20_loan_int_sus;
	}
	public BigDecimal getR7_bank_st_20_loan_crm() {
		return r7_bank_st_20_loan_crm;
	}
	public void setR7_bank_st_20_loan_crm(BigDecimal r7_bank_st_20_loan_crm) {
		this.r7_bank_st_20_loan_crm = r7_bank_st_20_loan_crm;
	}
	public BigDecimal getR7_bank_st_20_loan_tot_dra() {
		return r7_bank_st_20_loan_tot_dra;
	}
	public void setR7_bank_st_20_loan_tot_dra(BigDecimal r7_bank_st_20_loan_tot_dra) {
		this.r7_bank_st_20_loan_tot_dra = r7_bank_st_20_loan_tot_dra;
	}
	public BigDecimal getR7_bank_st_20_inves_bal() {
		return r7_bank_st_20_inves_bal;
	}
	public void setR7_bank_st_20_inves_bal(BigDecimal r7_bank_st_20_inves_bal) {
		this.r7_bank_st_20_inves_bal = r7_bank_st_20_inves_bal;
	}
	public BigDecimal getR7_bank_st_20_inves_prov() {
		return r7_bank_st_20_inves_prov;
	}
	public void setR7_bank_st_20_inves_prov(BigDecimal r7_bank_st_20_inves_prov) {
		this.r7_bank_st_20_inves_prov = r7_bank_st_20_inves_prov;
	}
	public BigDecimal getR7_bank_st_20_inves_crm() {
		return r7_bank_st_20_inves_crm;
	}
	public void setR7_bank_st_20_inves_crm(BigDecimal r7_bank_st_20_inves_crm) {
		this.r7_bank_st_20_inves_crm = r7_bank_st_20_inves_crm;
	}
	public BigDecimal getR7_bank_st_20_inves_rwa() {
		return r7_bank_st_20_inves_rwa;
	}
	public void setR7_bank_st_20_inves_rwa(BigDecimal r7_bank_st_20_inves_rwa) {
		this.r7_bank_st_20_inves_rwa = r7_bank_st_20_inves_rwa;
	}
	public BigDecimal getR7_bank_st_20_plac_bal() {
		return r7_bank_st_20_plac_bal;
	}
	public void setR7_bank_st_20_plac_bal(BigDecimal r7_bank_st_20_plac_bal) {
		this.r7_bank_st_20_plac_bal = r7_bank_st_20_plac_bal;
	}
	public BigDecimal getR7_bank_st_20_plac_prov() {
		return r7_bank_st_20_plac_prov;
	}
	public void setR7_bank_st_20_plac_prov(BigDecimal r7_bank_st_20_plac_prov) {
		this.r7_bank_st_20_plac_prov = r7_bank_st_20_plac_prov;
	}
	public BigDecimal getR7_bank_st_20_plac_crm() {
		return r7_bank_st_20_plac_crm;
	}
	public void setR7_bank_st_20_plac_crm(BigDecimal r7_bank_st_20_plac_crm) {
		this.r7_bank_st_20_plac_crm = r7_bank_st_20_plac_crm;
	}
	public BigDecimal getR7_bank_st_20_plac_rwa() {
		return r7_bank_st_20_plac_rwa;
	}
	public void setR7_bank_st_20_plac_rwa(BigDecimal r7_bank_st_20_plac_rwa) {
		this.r7_bank_st_20_plac_rwa = r7_bank_st_20_plac_rwa;
	}
	public BigDecimal getR7_bank_st_20_cash_bal() {
		return r7_bank_st_20_cash_bal;
	}
	public void setR7_bank_st_20_cash_bal(BigDecimal r7_bank_st_20_cash_bal) {
		this.r7_bank_st_20_cash_bal = r7_bank_st_20_cash_bal;
	}
	public BigDecimal getR7_bank_st_20_cash_prov() {
		return r7_bank_st_20_cash_prov;
	}
	public void setR7_bank_st_20_cash_prov(BigDecimal r7_bank_st_20_cash_prov) {
		this.r7_bank_st_20_cash_prov = r7_bank_st_20_cash_prov;
	}
	public BigDecimal getR7_bank_st_20_cash_crm() {
		return r7_bank_st_20_cash_crm;
	}
	public void setR7_bank_st_20_cash_crm(BigDecimal r7_bank_st_20_cash_crm) {
		this.r7_bank_st_20_cash_crm = r7_bank_st_20_cash_crm;
	}
	public BigDecimal getR7_bank_st_20_cash_rwa() {
		return r7_bank_st_20_cash_rwa;
	}
	public void setR7_bank_st_20_cash_rwa(BigDecimal r7_bank_st_20_cash_rwa) {
		this.r7_bank_st_20_cash_rwa = r7_bank_st_20_cash_rwa;
	}
	public BigDecimal getR7_bank_st_20_tot_bal() {
		return r7_bank_st_20_tot_bal;
	}
	public void setR7_bank_st_20_tot_bal(BigDecimal r7_bank_st_20_tot_bal) {
		this.r7_bank_st_20_tot_bal = r7_bank_st_20_tot_bal;
	}
	public BigDecimal getR7_bank_st_20_tot_prov() {
		return r7_bank_st_20_tot_prov;
	}
	public void setR7_bank_st_20_tot_prov(BigDecimal r7_bank_st_20_tot_prov) {
		this.r7_bank_st_20_tot_prov = r7_bank_st_20_tot_prov;
	}
	public BigDecimal getR7_bank_st_20_tot_int_sus() {
		return r7_bank_st_20_tot_int_sus;
	}
	public void setR7_bank_st_20_tot_int_sus(BigDecimal r7_bank_st_20_tot_int_sus) {
		this.r7_bank_st_20_tot_int_sus = r7_bank_st_20_tot_int_sus;
	}
	public BigDecimal getR7_bank_st_20_tot_crm() {
		return r7_bank_st_20_tot_crm;
	}
	public void setR7_bank_st_20_tot_crm(BigDecimal r7_bank_st_20_tot_crm) {
		this.r7_bank_st_20_tot_crm = r7_bank_st_20_tot_crm;
	}
	public BigDecimal getR7_bank_st_20_tot_rwa() {
		return r7_bank_st_20_tot_rwa;
	}
	public void setR7_bank_st_20_tot_rwa(BigDecimal r7_bank_st_20_tot_rwa) {
		this.r7_bank_st_20_tot_rwa = r7_bank_st_20_tot_rwa;
	}
	public BigDecimal getR8_bank_st_50_loan_bal() {
		return r8_bank_st_50_loan_bal;
	}
	public void setR8_bank_st_50_loan_bal(BigDecimal r8_bank_st_50_loan_bal) {
		this.r8_bank_st_50_loan_bal = r8_bank_st_50_loan_bal;
	}
	public BigDecimal getR8_bank_st_50_loan_bill_amt() {
		return r8_bank_st_50_loan_bill_amt;
	}
	public void setR8_bank_st_50_loan_bill_amt(BigDecimal r8_bank_st_50_loan_bill_amt) {
		this.r8_bank_st_50_loan_bill_amt = r8_bank_st_50_loan_bill_amt;
	}
	public BigDecimal getR8_bank_st_50_loan_tot_bal() {
		return r8_bank_st_50_loan_tot_bal;
	}
	public void setR8_bank_st_50_loan_tot_bal(BigDecimal r8_bank_st_50_loan_tot_bal) {
		this.r8_bank_st_50_loan_tot_bal = r8_bank_st_50_loan_tot_bal;
	}
	public BigDecimal getR8_bank_st_50_loan_tot_prov() {
		return r8_bank_st_50_loan_tot_prov;
	}
	public void setR8_bank_st_50_loan_tot_prov(BigDecimal r8_bank_st_50_loan_tot_prov) {
		this.r8_bank_st_50_loan_tot_prov = r8_bank_st_50_loan_tot_prov;
	}
	public BigDecimal getR8_bank_st_50_loan_int_sus() {
		return r8_bank_st_50_loan_int_sus;
	}
	public void setR8_bank_st_50_loan_int_sus(BigDecimal r8_bank_st_50_loan_int_sus) {
		this.r8_bank_st_50_loan_int_sus = r8_bank_st_50_loan_int_sus;
	}
	public BigDecimal getR8_bank_st_50_loan_crm() {
		return r8_bank_st_50_loan_crm;
	}
	public void setR8_bank_st_50_loan_crm(BigDecimal r8_bank_st_50_loan_crm) {
		this.r8_bank_st_50_loan_crm = r8_bank_st_50_loan_crm;
	}
	public BigDecimal getR8_bank_st_50_loan_tot_dra() {
		return r8_bank_st_50_loan_tot_dra;
	}
	public void setR8_bank_st_50_loan_tot_dra(BigDecimal r8_bank_st_50_loan_tot_dra) {
		this.r8_bank_st_50_loan_tot_dra = r8_bank_st_50_loan_tot_dra;
	}
	public BigDecimal getR8_bank_st_50_inves_bal() {
		return r8_bank_st_50_inves_bal;
	}
	public void setR8_bank_st_50_inves_bal(BigDecimal r8_bank_st_50_inves_bal) {
		this.r8_bank_st_50_inves_bal = r8_bank_st_50_inves_bal;
	}
	public BigDecimal getR8_bank_st_50_inves_prov() {
		return r8_bank_st_50_inves_prov;
	}
	public void setR8_bank_st_50_inves_prov(BigDecimal r8_bank_st_50_inves_prov) {
		this.r8_bank_st_50_inves_prov = r8_bank_st_50_inves_prov;
	}
	public BigDecimal getR8_bank_st_50_inves_crm() {
		return r8_bank_st_50_inves_crm;
	}
	public void setR8_bank_st_50_inves_crm(BigDecimal r8_bank_st_50_inves_crm) {
		this.r8_bank_st_50_inves_crm = r8_bank_st_50_inves_crm;
	}
	public BigDecimal getR8_bank_st_50_inves_rwa() {
		return r8_bank_st_50_inves_rwa;
	}
	public void setR8_bank_st_50_inves_rwa(BigDecimal r8_bank_st_50_inves_rwa) {
		this.r8_bank_st_50_inves_rwa = r8_bank_st_50_inves_rwa;
	}
	public BigDecimal getR8_bank_st_50_plac_bal() {
		return r8_bank_st_50_plac_bal;
	}
	public void setR8_bank_st_50_plac_bal(BigDecimal r8_bank_st_50_plac_bal) {
		this.r8_bank_st_50_plac_bal = r8_bank_st_50_plac_bal;
	}
	public BigDecimal getR8_bank_st_50_plac_prov() {
		return r8_bank_st_50_plac_prov;
	}
	public void setR8_bank_st_50_plac_prov(BigDecimal r8_bank_st_50_plac_prov) {
		this.r8_bank_st_50_plac_prov = r8_bank_st_50_plac_prov;
	}
	public BigDecimal getR8_bank_st_50_plac_crm() {
		return r8_bank_st_50_plac_crm;
	}
	public void setR8_bank_st_50_plac_crm(BigDecimal r8_bank_st_50_plac_crm) {
		this.r8_bank_st_50_plac_crm = r8_bank_st_50_plac_crm;
	}
	public BigDecimal getR8_bank_st_50_plac_rwa() {
		return r8_bank_st_50_plac_rwa;
	}
	public void setR8_bank_st_50_plac_rwa(BigDecimal r8_bank_st_50_plac_rwa) {
		this.r8_bank_st_50_plac_rwa = r8_bank_st_50_plac_rwa;
	}
	public BigDecimal getR8_bank_st_50_cash_bal() {
		return r8_bank_st_50_cash_bal;
	}
	public void setR8_bank_st_50_cash_bal(BigDecimal r8_bank_st_50_cash_bal) {
		this.r8_bank_st_50_cash_bal = r8_bank_st_50_cash_bal;
	}
	public BigDecimal getR8_bank_st_50_cash_prov() {
		return r8_bank_st_50_cash_prov;
	}
	public void setR8_bank_st_50_cash_prov(BigDecimal r8_bank_st_50_cash_prov) {
		this.r8_bank_st_50_cash_prov = r8_bank_st_50_cash_prov;
	}
	public BigDecimal getR8_bank_st_50_cash_crm() {
		return r8_bank_st_50_cash_crm;
	}
	public void setR8_bank_st_50_cash_crm(BigDecimal r8_bank_st_50_cash_crm) {
		this.r8_bank_st_50_cash_crm = r8_bank_st_50_cash_crm;
	}
	public BigDecimal getR8_bank_st_50_cash_rwa() {
		return r8_bank_st_50_cash_rwa;
	}
	public void setR8_bank_st_50_cash_rwa(BigDecimal r8_bank_st_50_cash_rwa) {
		this.r8_bank_st_50_cash_rwa = r8_bank_st_50_cash_rwa;
	}
	public BigDecimal getR8_bank_st_50_tot_bal() {
		return r8_bank_st_50_tot_bal;
	}
	public void setR8_bank_st_50_tot_bal(BigDecimal r8_bank_st_50_tot_bal) {
		this.r8_bank_st_50_tot_bal = r8_bank_st_50_tot_bal;
	}
	public BigDecimal getR8_bank_st_50_tot_prov() {
		return r8_bank_st_50_tot_prov;
	}
	public void setR8_bank_st_50_tot_prov(BigDecimal r8_bank_st_50_tot_prov) {
		this.r8_bank_st_50_tot_prov = r8_bank_st_50_tot_prov;
	}
	public BigDecimal getR8_bank_st_50_tot_int_sus() {
		return r8_bank_st_50_tot_int_sus;
	}
	public void setR8_bank_st_50_tot_int_sus(BigDecimal r8_bank_st_50_tot_int_sus) {
		this.r8_bank_st_50_tot_int_sus = r8_bank_st_50_tot_int_sus;
	}
	public BigDecimal getR8_bank_st_50_tot_crm() {
		return r8_bank_st_50_tot_crm;
	}
	public void setR8_bank_st_50_tot_crm(BigDecimal r8_bank_st_50_tot_crm) {
		this.r8_bank_st_50_tot_crm = r8_bank_st_50_tot_crm;
	}
	public BigDecimal getR8_bank_st_50_tot_rwa() {
		return r8_bank_st_50_tot_rwa;
	}
	public void setR8_bank_st_50_tot_rwa(BigDecimal r8_bank_st_50_tot_rwa) {
		this.r8_bank_st_50_tot_rwa = r8_bank_st_50_tot_rwa;
	}
	public BigDecimal getR9_bank_st_100_loan_bal() {
		return r9_bank_st_100_loan_bal;
	}
	public void setR9_bank_st_100_loan_bal(BigDecimal r9_bank_st_100_loan_bal) {
		this.r9_bank_st_100_loan_bal = r9_bank_st_100_loan_bal;
	}
	public BigDecimal getR9_bank_st_100_loan_bill_amt() {
		return r9_bank_st_100_loan_bill_amt;
	}
	public void setR9_bank_st_100_loan_bill_amt(BigDecimal r9_bank_st_100_loan_bill_amt) {
		this.r9_bank_st_100_loan_bill_amt = r9_bank_st_100_loan_bill_amt;
	}
	public BigDecimal getR9_bank_st_100_loan_tot_bal() {
		return r9_bank_st_100_loan_tot_bal;
	}
	public void setR9_bank_st_100_loan_tot_bal(BigDecimal r9_bank_st_100_loan_tot_bal) {
		this.r9_bank_st_100_loan_tot_bal = r9_bank_st_100_loan_tot_bal;
	}
	public BigDecimal getR9_bank_st_100_loan_tot_prov() {
		return r9_bank_st_100_loan_tot_prov;
	}
	public void setR9_bank_st_100_loan_tot_prov(BigDecimal r9_bank_st_100_loan_tot_prov) {
		this.r9_bank_st_100_loan_tot_prov = r9_bank_st_100_loan_tot_prov;
	}
	public BigDecimal getR9_bank_st_100_loan_int_sus() {
		return r9_bank_st_100_loan_int_sus;
	}
	public void setR9_bank_st_100_loan_int_sus(BigDecimal r9_bank_st_100_loan_int_sus) {
		this.r9_bank_st_100_loan_int_sus = r9_bank_st_100_loan_int_sus;
	}
	public BigDecimal getR9_bank_st_100_loan_crm() {
		return r9_bank_st_100_loan_crm;
	}
	public void setR9_bank_st_100_loan_crm(BigDecimal r9_bank_st_100_loan_crm) {
		this.r9_bank_st_100_loan_crm = r9_bank_st_100_loan_crm;
	}
	public BigDecimal getR9_bank_st_100_loan_tot_dra() {
		return r9_bank_st_100_loan_tot_dra;
	}
	public void setR9_bank_st_100_loan_tot_dra(BigDecimal r9_bank_st_100_loan_tot_dra) {
		this.r9_bank_st_100_loan_tot_dra = r9_bank_st_100_loan_tot_dra;
	}
	public BigDecimal getR9_bank_st_100_inves_bal() {
		return r9_bank_st_100_inves_bal;
	}
	public void setR9_bank_st_100_inves_bal(BigDecimal r9_bank_st_100_inves_bal) {
		this.r9_bank_st_100_inves_bal = r9_bank_st_100_inves_bal;
	}
	public BigDecimal getR9_bank_st_100_inves_prov() {
		return r9_bank_st_100_inves_prov;
	}
	public void setR9_bank_st_100_inves_prov(BigDecimal r9_bank_st_100_inves_prov) {
		this.r9_bank_st_100_inves_prov = r9_bank_st_100_inves_prov;
	}
	public BigDecimal getR9_bank_st_100_inves_crm() {
		return r9_bank_st_100_inves_crm;
	}
	public void setR9_bank_st_100_inves_crm(BigDecimal r9_bank_st_100_inves_crm) {
		this.r9_bank_st_100_inves_crm = r9_bank_st_100_inves_crm;
	}
	public BigDecimal getR9_bank_st_100_inves_rwa() {
		return r9_bank_st_100_inves_rwa;
	}
	public void setR9_bank_st_100_inves_rwa(BigDecimal r9_bank_st_100_inves_rwa) {
		this.r9_bank_st_100_inves_rwa = r9_bank_st_100_inves_rwa;
	}
	public BigDecimal getR9_bank_st_100_plac_bal() {
		return r9_bank_st_100_plac_bal;
	}
	public void setR9_bank_st_100_plac_bal(BigDecimal r9_bank_st_100_plac_bal) {
		this.r9_bank_st_100_plac_bal = r9_bank_st_100_plac_bal;
	}
	public BigDecimal getR9_bank_st_100_plac_prov() {
		return r9_bank_st_100_plac_prov;
	}
	public void setR9_bank_st_100_plac_prov(BigDecimal r9_bank_st_100_plac_prov) {
		this.r9_bank_st_100_plac_prov = r9_bank_st_100_plac_prov;
	}
	public BigDecimal getR9_bank_st_100_plac_crm() {
		return r9_bank_st_100_plac_crm;
	}
	public void setR9_bank_st_100_plac_crm(BigDecimal r9_bank_st_100_plac_crm) {
		this.r9_bank_st_100_plac_crm = r9_bank_st_100_plac_crm;
	}
	public BigDecimal getR9_bank_st_100_plac_rwa() {
		return r9_bank_st_100_plac_rwa;
	}
	public void setR9_bank_st_100_plac_rwa(BigDecimal r9_bank_st_100_plac_rwa) {
		this.r9_bank_st_100_plac_rwa = r9_bank_st_100_plac_rwa;
	}
	public BigDecimal getR9_bank_st_100_cash_bal() {
		return r9_bank_st_100_cash_bal;
	}
	public void setR9_bank_st_100_cash_bal(BigDecimal r9_bank_st_100_cash_bal) {
		this.r9_bank_st_100_cash_bal = r9_bank_st_100_cash_bal;
	}
	public BigDecimal getR9_bank_st_100_cash_prov() {
		return r9_bank_st_100_cash_prov;
	}
	public void setR9_bank_st_100_cash_prov(BigDecimal r9_bank_st_100_cash_prov) {
		this.r9_bank_st_100_cash_prov = r9_bank_st_100_cash_prov;
	}
	public BigDecimal getR9_bank_st_100_cash_crm() {
		return r9_bank_st_100_cash_crm;
	}
	public void setR9_bank_st_100_cash_crm(BigDecimal r9_bank_st_100_cash_crm) {
		this.r9_bank_st_100_cash_crm = r9_bank_st_100_cash_crm;
	}
	public BigDecimal getR9_bank_st_100_cash_rwa() {
		return r9_bank_st_100_cash_rwa;
	}
	public void setR9_bank_st_100_cash_rwa(BigDecimal r9_bank_st_100_cash_rwa) {
		this.r9_bank_st_100_cash_rwa = r9_bank_st_100_cash_rwa;
	}
	public BigDecimal getR9_bank_st_100_tot_bal() {
		return r9_bank_st_100_tot_bal;
	}
	public void setR9_bank_st_100_tot_bal(BigDecimal r9_bank_st_100_tot_bal) {
		this.r9_bank_st_100_tot_bal = r9_bank_st_100_tot_bal;
	}
	public BigDecimal getR9_bank_st_100_tot_prov() {
		return r9_bank_st_100_tot_prov;
	}
	public void setR9_bank_st_100_tot_prov(BigDecimal r9_bank_st_100_tot_prov) {
		this.r9_bank_st_100_tot_prov = r9_bank_st_100_tot_prov;
	}
	public BigDecimal getR9_bank_st_100_tot_int_sus() {
		return r9_bank_st_100_tot_int_sus;
	}
	public void setR9_bank_st_100_tot_int_sus(BigDecimal r9_bank_st_100_tot_int_sus) {
		this.r9_bank_st_100_tot_int_sus = r9_bank_st_100_tot_int_sus;
	}
	public BigDecimal getR9_bank_st_100_tot_crm() {
		return r9_bank_st_100_tot_crm;
	}
	public void setR9_bank_st_100_tot_crm(BigDecimal r9_bank_st_100_tot_crm) {
		this.r9_bank_st_100_tot_crm = r9_bank_st_100_tot_crm;
	}
	public BigDecimal getR9_bank_st_100_tot_rwa() {
		return r9_bank_st_100_tot_rwa;
	}
	public void setR9_bank_st_100_tot_rwa(BigDecimal r9_bank_st_100_tot_rwa) {
		this.r9_bank_st_100_tot_rwa = r9_bank_st_100_tot_rwa;
	}
	public BigDecimal getR10_bank_st_150_loan_bal() {
		return r10_bank_st_150_loan_bal;
	}
	public void setR10_bank_st_150_loan_bal(BigDecimal r10_bank_st_150_loan_bal) {
		this.r10_bank_st_150_loan_bal = r10_bank_st_150_loan_bal;
	}
	public BigDecimal getR10_bank_st_150_loan_bill_amt() {
		return r10_bank_st_150_loan_bill_amt;
	}
	public void setR10_bank_st_150_loan_bill_amt(BigDecimal r10_bank_st_150_loan_bill_amt) {
		this.r10_bank_st_150_loan_bill_amt = r10_bank_st_150_loan_bill_amt;
	}
	public BigDecimal getR10_bank_st_150_loan_tot_bal() {
		return r10_bank_st_150_loan_tot_bal;
	}
	public void setR10_bank_st_150_loan_tot_bal(BigDecimal r10_bank_st_150_loan_tot_bal) {
		this.r10_bank_st_150_loan_tot_bal = r10_bank_st_150_loan_tot_bal;
	}
	public BigDecimal getR10_bank_st_150_loan_tot_prov() {
		return r10_bank_st_150_loan_tot_prov;
	}
	public void setR10_bank_st_150_loan_tot_prov(BigDecimal r10_bank_st_150_loan_tot_prov) {
		this.r10_bank_st_150_loan_tot_prov = r10_bank_st_150_loan_tot_prov;
	}
	public BigDecimal getR10_bank_st_150_loan_int_sus() {
		return r10_bank_st_150_loan_int_sus;
	}
	public void setR10_bank_st_150_loan_int_sus(BigDecimal r10_bank_st_150_loan_int_sus) {
		this.r10_bank_st_150_loan_int_sus = r10_bank_st_150_loan_int_sus;
	}
	public BigDecimal getR10_bank_st_150_loan_crm() {
		return r10_bank_st_150_loan_crm;
	}
	public void setR10_bank_st_150_loan_crm(BigDecimal r10_bank_st_150_loan_crm) {
		this.r10_bank_st_150_loan_crm = r10_bank_st_150_loan_crm;
	}
	public BigDecimal getR10_bank_st_150_loan_tot_dra() {
		return r10_bank_st_150_loan_tot_dra;
	}
	public void setR10_bank_st_150_loan_tot_dra(BigDecimal r10_bank_st_150_loan_tot_dra) {
		this.r10_bank_st_150_loan_tot_dra = r10_bank_st_150_loan_tot_dra;
	}
	public BigDecimal getR10_bank_st_150_inves_bal() {
		return r10_bank_st_150_inves_bal;
	}
	public void setR10_bank_st_150_inves_bal(BigDecimal r10_bank_st_150_inves_bal) {
		this.r10_bank_st_150_inves_bal = r10_bank_st_150_inves_bal;
	}
	public BigDecimal getR10_bank_st_150_inves_prov() {
		return r10_bank_st_150_inves_prov;
	}
	public void setR10_bank_st_150_inves_prov(BigDecimal r10_bank_st_150_inves_prov) {
		this.r10_bank_st_150_inves_prov = r10_bank_st_150_inves_prov;
	}
	public BigDecimal getR10_bank_st_150_inves_crm() {
		return r10_bank_st_150_inves_crm;
	}
	public void setR10_bank_st_150_inves_crm(BigDecimal r10_bank_st_150_inves_crm) {
		this.r10_bank_st_150_inves_crm = r10_bank_st_150_inves_crm;
	}
	public BigDecimal getR10_bank_st_150_inves_rwa() {
		return r10_bank_st_150_inves_rwa;
	}
	public void setR10_bank_st_150_inves_rwa(BigDecimal r10_bank_st_150_inves_rwa) {
		this.r10_bank_st_150_inves_rwa = r10_bank_st_150_inves_rwa;
	}
	public BigDecimal getR10_bank_st_150_plac_bal() {
		return r10_bank_st_150_plac_bal;
	}
	public void setR10_bank_st_150_plac_bal(BigDecimal r10_bank_st_150_plac_bal) {
		this.r10_bank_st_150_plac_bal = r10_bank_st_150_plac_bal;
	}
	public BigDecimal getR10_bank_st_150_plac_prov() {
		return r10_bank_st_150_plac_prov;
	}
	public void setR10_bank_st_150_plac_prov(BigDecimal r10_bank_st_150_plac_prov) {
		this.r10_bank_st_150_plac_prov = r10_bank_st_150_plac_prov;
	}
	public BigDecimal getR10_bank_st_150_plac_crm() {
		return r10_bank_st_150_plac_crm;
	}
	public void setR10_bank_st_150_plac_crm(BigDecimal r10_bank_st_150_plac_crm) {
		this.r10_bank_st_150_plac_crm = r10_bank_st_150_plac_crm;
	}
	public BigDecimal getR10_bank_st_150_plac_rwa() {
		return r10_bank_st_150_plac_rwa;
	}
	public void setR10_bank_st_150_plac_rwa(BigDecimal r10_bank_st_150_plac_rwa) {
		this.r10_bank_st_150_plac_rwa = r10_bank_st_150_plac_rwa;
	}
	public BigDecimal getR10_bank_st_150_cash_bal() {
		return r10_bank_st_150_cash_bal;
	}
	public void setR10_bank_st_150_cash_bal(BigDecimal r10_bank_st_150_cash_bal) {
		this.r10_bank_st_150_cash_bal = r10_bank_st_150_cash_bal;
	}
	public BigDecimal getR10_bank_st_150_cash_prov() {
		return r10_bank_st_150_cash_prov;
	}
	public void setR10_bank_st_150_cash_prov(BigDecimal r10_bank_st_150_cash_prov) {
		this.r10_bank_st_150_cash_prov = r10_bank_st_150_cash_prov;
	}
	public BigDecimal getR10_bank_st_150_cash_crm() {
		return r10_bank_st_150_cash_crm;
	}
	public void setR10_bank_st_150_cash_crm(BigDecimal r10_bank_st_150_cash_crm) {
		this.r10_bank_st_150_cash_crm = r10_bank_st_150_cash_crm;
	}
	public BigDecimal getR10_bank_st_150_cash_rwa() {
		return r10_bank_st_150_cash_rwa;
	}
	public void setR10_bank_st_150_cash_rwa(BigDecimal r10_bank_st_150_cash_rwa) {
		this.r10_bank_st_150_cash_rwa = r10_bank_st_150_cash_rwa;
	}
	public BigDecimal getR10_bank_st_150_tot_bal() {
		return r10_bank_st_150_tot_bal;
	}
	public void setR10_bank_st_150_tot_bal(BigDecimal r10_bank_st_150_tot_bal) {
		this.r10_bank_st_150_tot_bal = r10_bank_st_150_tot_bal;
	}
	public BigDecimal getR10_bank_st_150_tot_prov() {
		return r10_bank_st_150_tot_prov;
	}
	public void setR10_bank_st_150_tot_prov(BigDecimal r10_bank_st_150_tot_prov) {
		this.r10_bank_st_150_tot_prov = r10_bank_st_150_tot_prov;
	}
	public BigDecimal getR10_bank_st_150_tot_int_sus() {
		return r10_bank_st_150_tot_int_sus;
	}
	public void setR10_bank_st_150_tot_int_sus(BigDecimal r10_bank_st_150_tot_int_sus) {
		this.r10_bank_st_150_tot_int_sus = r10_bank_st_150_tot_int_sus;
	}
	public BigDecimal getR10_bank_st_150_tot_crm() {
		return r10_bank_st_150_tot_crm;
	}
	public void setR10_bank_st_150_tot_crm(BigDecimal r10_bank_st_150_tot_crm) {
		this.r10_bank_st_150_tot_crm = r10_bank_st_150_tot_crm;
	}
	public BigDecimal getR10_bank_st_150_tot_rwa() {
		return r10_bank_st_150_tot_rwa;
	}
	public void setR10_bank_st_150_tot_rwa(BigDecimal r10_bank_st_150_tot_rwa) {
		this.r10_bank_st_150_tot_rwa = r10_bank_st_150_tot_rwa;
	}
	public BigDecimal getR11_bank_lt_0_loan_bal() {
		return r11_bank_lt_0_loan_bal;
	}
	public void setR11_bank_lt_0_loan_bal(BigDecimal r11_bank_lt_0_loan_bal) {
		this.r11_bank_lt_0_loan_bal = r11_bank_lt_0_loan_bal;
	}
	public BigDecimal getR11_bank_lt_0_loan_bill_amt() {
		return r11_bank_lt_0_loan_bill_amt;
	}
	public void setR11_bank_lt_0_loan_bill_amt(BigDecimal r11_bank_lt_0_loan_bill_amt) {
		this.r11_bank_lt_0_loan_bill_amt = r11_bank_lt_0_loan_bill_amt;
	}
	public BigDecimal getR11_bank_lt_0_loan_tot_bal() {
		return r11_bank_lt_0_loan_tot_bal;
	}
	public void setR11_bank_lt_0_loan_tot_bal(BigDecimal r11_bank_lt_0_loan_tot_bal) {
		this.r11_bank_lt_0_loan_tot_bal = r11_bank_lt_0_loan_tot_bal;
	}
	public BigDecimal getR11_bank_lt_0_loan_tot_prov() {
		return r11_bank_lt_0_loan_tot_prov;
	}
	public void setR11_bank_lt_0_loan_tot_prov(BigDecimal r11_bank_lt_0_loan_tot_prov) {
		this.r11_bank_lt_0_loan_tot_prov = r11_bank_lt_0_loan_tot_prov;
	}
	public BigDecimal getR11_bank_lt_0_loan_int_sus() {
		return r11_bank_lt_0_loan_int_sus;
	}
	public void setR11_bank_lt_0_loan_int_sus(BigDecimal r11_bank_lt_0_loan_int_sus) {
		this.r11_bank_lt_0_loan_int_sus = r11_bank_lt_0_loan_int_sus;
	}
	public BigDecimal getR11_bank_lt_0_loan_crm() {
		return r11_bank_lt_0_loan_crm;
	}
	public void setR11_bank_lt_0_loan_crm(BigDecimal r11_bank_lt_0_loan_crm) {
		this.r11_bank_lt_0_loan_crm = r11_bank_lt_0_loan_crm;
	}
	public BigDecimal getR11_bank_lt_0_loan_tot_dra() {
		return r11_bank_lt_0_loan_tot_dra;
	}
	public void setR11_bank_lt_0_loan_tot_dra(BigDecimal r11_bank_lt_0_loan_tot_dra) {
		this.r11_bank_lt_0_loan_tot_dra = r11_bank_lt_0_loan_tot_dra;
	}
	public BigDecimal getR11_bank_lt_0_inves_bal() {
		return r11_bank_lt_0_inves_bal;
	}
	public void setR11_bank_lt_0_inves_bal(BigDecimal r11_bank_lt_0_inves_bal) {
		this.r11_bank_lt_0_inves_bal = r11_bank_lt_0_inves_bal;
	}
	public BigDecimal getR11_bank_lt_0_inves_prov() {
		return r11_bank_lt_0_inves_prov;
	}
	public void setR11_bank_lt_0_inves_prov(BigDecimal r11_bank_lt_0_inves_prov) {
		this.r11_bank_lt_0_inves_prov = r11_bank_lt_0_inves_prov;
	}
	public BigDecimal getR11_bank_lt_0_inves_crm() {
		return r11_bank_lt_0_inves_crm;
	}
	public void setR11_bank_lt_0_inves_crm(BigDecimal r11_bank_lt_0_inves_crm) {
		this.r11_bank_lt_0_inves_crm = r11_bank_lt_0_inves_crm;
	}
	public BigDecimal getR11_bank_lt_0_inves_rwa() {
		return r11_bank_lt_0_inves_rwa;
	}
	public void setR11_bank_lt_0_inves_rwa(BigDecimal r11_bank_lt_0_inves_rwa) {
		this.r11_bank_lt_0_inves_rwa = r11_bank_lt_0_inves_rwa;
	}
	public BigDecimal getR11_bank_lt_0_plac_bal() {
		return r11_bank_lt_0_plac_bal;
	}
	public void setR11_bank_lt_0_plac_bal(BigDecimal r11_bank_lt_0_plac_bal) {
		this.r11_bank_lt_0_plac_bal = r11_bank_lt_0_plac_bal;
	}
	public BigDecimal getR11_bank_lt_0_plac_prov() {
		return r11_bank_lt_0_plac_prov;
	}
	public void setR11_bank_lt_0_plac_prov(BigDecimal r11_bank_lt_0_plac_prov) {
		this.r11_bank_lt_0_plac_prov = r11_bank_lt_0_plac_prov;
	}
	public BigDecimal getR11_bank_lt_0_plac_crm() {
		return r11_bank_lt_0_plac_crm;
	}
	public void setR11_bank_lt_0_plac_crm(BigDecimal r11_bank_lt_0_plac_crm) {
		this.r11_bank_lt_0_plac_crm = r11_bank_lt_0_plac_crm;
	}
	public BigDecimal getR11_bank_lt_0_plac_rwa() {
		return r11_bank_lt_0_plac_rwa;
	}
	public void setR11_bank_lt_0_plac_rwa(BigDecimal r11_bank_lt_0_plac_rwa) {
		this.r11_bank_lt_0_plac_rwa = r11_bank_lt_0_plac_rwa;
	}
	public BigDecimal getR11_bank_lt_0_cash_bal() {
		return r11_bank_lt_0_cash_bal;
	}
	public void setR11_bank_lt_0_cash_bal(BigDecimal r11_bank_lt_0_cash_bal) {
		this.r11_bank_lt_0_cash_bal = r11_bank_lt_0_cash_bal;
	}
	public BigDecimal getR11_bank_lt_0_cash_prov() {
		return r11_bank_lt_0_cash_prov;
	}
	public void setR11_bank_lt_0_cash_prov(BigDecimal r11_bank_lt_0_cash_prov) {
		this.r11_bank_lt_0_cash_prov = r11_bank_lt_0_cash_prov;
	}
	public BigDecimal getR11_bank_lt_0_cash_crm() {
		return r11_bank_lt_0_cash_crm;
	}
	public void setR11_bank_lt_0_cash_crm(BigDecimal r11_bank_lt_0_cash_crm) {
		this.r11_bank_lt_0_cash_crm = r11_bank_lt_0_cash_crm;
	}
	public BigDecimal getR11_bank_lt_0_cash_rwa() {
		return r11_bank_lt_0_cash_rwa;
	}
	public void setR11_bank_lt_0_cash_rwa(BigDecimal r11_bank_lt_0_cash_rwa) {
		this.r11_bank_lt_0_cash_rwa = r11_bank_lt_0_cash_rwa;
	}
	public BigDecimal getR11_bank_lt_0_tot_bal() {
		return r11_bank_lt_0_tot_bal;
	}
	public void setR11_bank_lt_0_tot_bal(BigDecimal r11_bank_lt_0_tot_bal) {
		this.r11_bank_lt_0_tot_bal = r11_bank_lt_0_tot_bal;
	}
	public BigDecimal getR11_bank_lt_0_tot_prov() {
		return r11_bank_lt_0_tot_prov;
	}
	public void setR11_bank_lt_0_tot_prov(BigDecimal r11_bank_lt_0_tot_prov) {
		this.r11_bank_lt_0_tot_prov = r11_bank_lt_0_tot_prov;
	}
	public BigDecimal getR11_bank_lt_0_tot_int_sus() {
		return r11_bank_lt_0_tot_int_sus;
	}
	public void setR11_bank_lt_0_tot_int_sus(BigDecimal r11_bank_lt_0_tot_int_sus) {
		this.r11_bank_lt_0_tot_int_sus = r11_bank_lt_0_tot_int_sus;
	}
	public BigDecimal getR11_bank_lt_0_tot_crm() {
		return r11_bank_lt_0_tot_crm;
	}
	public void setR11_bank_lt_0_tot_crm(BigDecimal r11_bank_lt_0_tot_crm) {
		this.r11_bank_lt_0_tot_crm = r11_bank_lt_0_tot_crm;
	}
	public BigDecimal getR11_bank_lt_0_tot_rwa() {
		return r11_bank_lt_0_tot_rwa;
	}
	public void setR11_bank_lt_0_tot_rwa(BigDecimal r11_bank_lt_0_tot_rwa) {
		this.r11_bank_lt_0_tot_rwa = r11_bank_lt_0_tot_rwa;
	}
	public BigDecimal getR12_bank_lt_20_loan_bal() {
		return r12_bank_lt_20_loan_bal;
	}
	public void setR12_bank_lt_20_loan_bal(BigDecimal r12_bank_lt_20_loan_bal) {
		this.r12_bank_lt_20_loan_bal = r12_bank_lt_20_loan_bal;
	}
	public BigDecimal getR12_bank_lt_20_loan_bill_amt() {
		return r12_bank_lt_20_loan_bill_amt;
	}
	public void setR12_bank_lt_20_loan_bill_amt(BigDecimal r12_bank_lt_20_loan_bill_amt) {
		this.r12_bank_lt_20_loan_bill_amt = r12_bank_lt_20_loan_bill_amt;
	}
	public BigDecimal getR12_bank_lt_20_loan_tot_bal() {
		return r12_bank_lt_20_loan_tot_bal;
	}
	public void setR12_bank_lt_20_loan_tot_bal(BigDecimal r12_bank_lt_20_loan_tot_bal) {
		this.r12_bank_lt_20_loan_tot_bal = r12_bank_lt_20_loan_tot_bal;
	}
	public BigDecimal getR12_bank_lt_20_loan_tot_prov() {
		return r12_bank_lt_20_loan_tot_prov;
	}
	public void setR12_bank_lt_20_loan_tot_prov(BigDecimal r12_bank_lt_20_loan_tot_prov) {
		this.r12_bank_lt_20_loan_tot_prov = r12_bank_lt_20_loan_tot_prov;
	}
	public BigDecimal getR12_bank_lt_20_loan_int_sus() {
		return r12_bank_lt_20_loan_int_sus;
	}
	public void setR12_bank_lt_20_loan_int_sus(BigDecimal r12_bank_lt_20_loan_int_sus) {
		this.r12_bank_lt_20_loan_int_sus = r12_bank_lt_20_loan_int_sus;
	}
	public BigDecimal getR12_bank_lt_20_loan_crm() {
		return r12_bank_lt_20_loan_crm;
	}
	public void setR12_bank_lt_20_loan_crm(BigDecimal r12_bank_lt_20_loan_crm) {
		this.r12_bank_lt_20_loan_crm = r12_bank_lt_20_loan_crm;
	}
	public BigDecimal getR12_bank_lt_20_loan_tot_dra() {
		return r12_bank_lt_20_loan_tot_dra;
	}
	public void setR12_bank_lt_20_loan_tot_dra(BigDecimal r12_bank_lt_20_loan_tot_dra) {
		this.r12_bank_lt_20_loan_tot_dra = r12_bank_lt_20_loan_tot_dra;
	}
	public BigDecimal getR12_bank_lt_20_inves_bal() {
		return r12_bank_lt_20_inves_bal;
	}
	public void setR12_bank_lt_20_inves_bal(BigDecimal r12_bank_lt_20_inves_bal) {
		this.r12_bank_lt_20_inves_bal = r12_bank_lt_20_inves_bal;
	}
	public BigDecimal getR12_bank_lt_20_inves_prov() {
		return r12_bank_lt_20_inves_prov;
	}
	public void setR12_bank_lt_20_inves_prov(BigDecimal r12_bank_lt_20_inves_prov) {
		this.r12_bank_lt_20_inves_prov = r12_bank_lt_20_inves_prov;
	}
	public BigDecimal getR12_bank_lt_20_inves_crm() {
		return r12_bank_lt_20_inves_crm;
	}
	public void setR12_bank_lt_20_inves_crm(BigDecimal r12_bank_lt_20_inves_crm) {
		this.r12_bank_lt_20_inves_crm = r12_bank_lt_20_inves_crm;
	}
	public BigDecimal getR12_bank_lt_20_inves_rwa() {
		return r12_bank_lt_20_inves_rwa;
	}
	public void setR12_bank_lt_20_inves_rwa(BigDecimal r12_bank_lt_20_inves_rwa) {
		this.r12_bank_lt_20_inves_rwa = r12_bank_lt_20_inves_rwa;
	}
	public BigDecimal getR12_bank_lt_20_plac_bal() {
		return r12_bank_lt_20_plac_bal;
	}
	public void setR12_bank_lt_20_plac_bal(BigDecimal r12_bank_lt_20_plac_bal) {
		this.r12_bank_lt_20_plac_bal = r12_bank_lt_20_plac_bal;
	}
	public BigDecimal getR12_bank_lt_20_plac_prov() {
		return r12_bank_lt_20_plac_prov;
	}
	public void setR12_bank_lt_20_plac_prov(BigDecimal r12_bank_lt_20_plac_prov) {
		this.r12_bank_lt_20_plac_prov = r12_bank_lt_20_plac_prov;
	}
	public BigDecimal getR12_bank_lt_20_plac_crm() {
		return r12_bank_lt_20_plac_crm;
	}
	public void setR12_bank_lt_20_plac_crm(BigDecimal r12_bank_lt_20_plac_crm) {
		this.r12_bank_lt_20_plac_crm = r12_bank_lt_20_plac_crm;
	}
	public BigDecimal getR12_bank_lt_20_plac_rwa() {
		return r12_bank_lt_20_plac_rwa;
	}
	public void setR12_bank_lt_20_plac_rwa(BigDecimal r12_bank_lt_20_plac_rwa) {
		this.r12_bank_lt_20_plac_rwa = r12_bank_lt_20_plac_rwa;
	}
	public BigDecimal getR12_bank_lt_20_cash_bal() {
		return r12_bank_lt_20_cash_bal;
	}
	public void setR12_bank_lt_20_cash_bal(BigDecimal r12_bank_lt_20_cash_bal) {
		this.r12_bank_lt_20_cash_bal = r12_bank_lt_20_cash_bal;
	}
	public BigDecimal getR12_bank_lt_20_cash_prov() {
		return r12_bank_lt_20_cash_prov;
	}
	public void setR12_bank_lt_20_cash_prov(BigDecimal r12_bank_lt_20_cash_prov) {
		this.r12_bank_lt_20_cash_prov = r12_bank_lt_20_cash_prov;
	}
	public BigDecimal getR12_bank_lt_20_cash_crm() {
		return r12_bank_lt_20_cash_crm;
	}
	public void setR12_bank_lt_20_cash_crm(BigDecimal r12_bank_lt_20_cash_crm) {
		this.r12_bank_lt_20_cash_crm = r12_bank_lt_20_cash_crm;
	}
	public BigDecimal getR12_bank_lt_20_cash_rwa() {
		return r12_bank_lt_20_cash_rwa;
	}
	public void setR12_bank_lt_20_cash_rwa(BigDecimal r12_bank_lt_20_cash_rwa) {
		this.r12_bank_lt_20_cash_rwa = r12_bank_lt_20_cash_rwa;
	}
	public BigDecimal getR12_bank_lt_20_tot_bal() {
		return r12_bank_lt_20_tot_bal;
	}
	public void setR12_bank_lt_20_tot_bal(BigDecimal r12_bank_lt_20_tot_bal) {
		this.r12_bank_lt_20_tot_bal = r12_bank_lt_20_tot_bal;
	}
	public BigDecimal getR12_bank_lt_20_tot_prov() {
		return r12_bank_lt_20_tot_prov;
	}
	public void setR12_bank_lt_20_tot_prov(BigDecimal r12_bank_lt_20_tot_prov) {
		this.r12_bank_lt_20_tot_prov = r12_bank_lt_20_tot_prov;
	}
	public BigDecimal getR12_bank_lt_20_tot_int_sus() {
		return r12_bank_lt_20_tot_int_sus;
	}
	public void setR12_bank_lt_20_tot_int_sus(BigDecimal r12_bank_lt_20_tot_int_sus) {
		this.r12_bank_lt_20_tot_int_sus = r12_bank_lt_20_tot_int_sus;
	}
	public BigDecimal getR12_bank_lt_20_tot_crm() {
		return r12_bank_lt_20_tot_crm;
	}
	public void setR12_bank_lt_20_tot_crm(BigDecimal r12_bank_lt_20_tot_crm) {
		this.r12_bank_lt_20_tot_crm = r12_bank_lt_20_tot_crm;
	}
	public BigDecimal getR12_bank_lt_20_tot_rwa() {
		return r12_bank_lt_20_tot_rwa;
	}
	public void setR12_bank_lt_20_tot_rwa(BigDecimal r12_bank_lt_20_tot_rwa) {
		this.r12_bank_lt_20_tot_rwa = r12_bank_lt_20_tot_rwa;
	}
	public BigDecimal getR13_bank_lt_50_loan_bal() {
		return r13_bank_lt_50_loan_bal;
	}
	public void setR13_bank_lt_50_loan_bal(BigDecimal r13_bank_lt_50_loan_bal) {
		this.r13_bank_lt_50_loan_bal = r13_bank_lt_50_loan_bal;
	}
	public BigDecimal getR13_bank_lt_50_loan_bill_amt() {
		return r13_bank_lt_50_loan_bill_amt;
	}
	public void setR13_bank_lt_50_loan_bill_amt(BigDecimal r13_bank_lt_50_loan_bill_amt) {
		this.r13_bank_lt_50_loan_bill_amt = r13_bank_lt_50_loan_bill_amt;
	}
	public BigDecimal getR13_bank_lt_50_loan_tot_bal() {
		return r13_bank_lt_50_loan_tot_bal;
	}
	public void setR13_bank_lt_50_loan_tot_bal(BigDecimal r13_bank_lt_50_loan_tot_bal) {
		this.r13_bank_lt_50_loan_tot_bal = r13_bank_lt_50_loan_tot_bal;
	}
	public BigDecimal getR13_bank_lt_50_loan_tot_prov() {
		return r13_bank_lt_50_loan_tot_prov;
	}
	public void setR13_bank_lt_50_loan_tot_prov(BigDecimal r13_bank_lt_50_loan_tot_prov) {
		this.r13_bank_lt_50_loan_tot_prov = r13_bank_lt_50_loan_tot_prov;
	}
	public BigDecimal getR13_bank_lt_50_loan_int_sus() {
		return r13_bank_lt_50_loan_int_sus;
	}
	public void setR13_bank_lt_50_loan_int_sus(BigDecimal r13_bank_lt_50_loan_int_sus) {
		this.r13_bank_lt_50_loan_int_sus = r13_bank_lt_50_loan_int_sus;
	}
	public BigDecimal getR13_bank_lt_50_loan_crm() {
		return r13_bank_lt_50_loan_crm;
	}
	public void setR13_bank_lt_50_loan_crm(BigDecimal r13_bank_lt_50_loan_crm) {
		this.r13_bank_lt_50_loan_crm = r13_bank_lt_50_loan_crm;
	}
	public BigDecimal getR13_bank_lt_50_loan_tot_dra() {
		return r13_bank_lt_50_loan_tot_dra;
	}
	public void setR13_bank_lt_50_loan_tot_dra(BigDecimal r13_bank_lt_50_loan_tot_dra) {
		this.r13_bank_lt_50_loan_tot_dra = r13_bank_lt_50_loan_tot_dra;
	}
	public BigDecimal getR13_bank_lt_50_inves_bal() {
		return r13_bank_lt_50_inves_bal;
	}
	public void setR13_bank_lt_50_inves_bal(BigDecimal r13_bank_lt_50_inves_bal) {
		this.r13_bank_lt_50_inves_bal = r13_bank_lt_50_inves_bal;
	}
	public BigDecimal getR13_bank_lt_50_inves_prov() {
		return r13_bank_lt_50_inves_prov;
	}
	public void setR13_bank_lt_50_inves_prov(BigDecimal r13_bank_lt_50_inves_prov) {
		this.r13_bank_lt_50_inves_prov = r13_bank_lt_50_inves_prov;
	}
	public BigDecimal getR13_bank_lt_50_inves_crm() {
		return r13_bank_lt_50_inves_crm;
	}
	public void setR13_bank_lt_50_inves_crm(BigDecimal r13_bank_lt_50_inves_crm) {
		this.r13_bank_lt_50_inves_crm = r13_bank_lt_50_inves_crm;
	}
	public BigDecimal getR13_bank_lt_50_inves_rwa() {
		return r13_bank_lt_50_inves_rwa;
	}
	public void setR13_bank_lt_50_inves_rwa(BigDecimal r13_bank_lt_50_inves_rwa) {
		this.r13_bank_lt_50_inves_rwa = r13_bank_lt_50_inves_rwa;
	}
	public BigDecimal getR13_bank_lt_50_plac_bal() {
		return r13_bank_lt_50_plac_bal;
	}
	public void setR13_bank_lt_50_plac_bal(BigDecimal r13_bank_lt_50_plac_bal) {
		this.r13_bank_lt_50_plac_bal = r13_bank_lt_50_plac_bal;
	}
	public BigDecimal getR13_bank_lt_50_plac_prov() {
		return r13_bank_lt_50_plac_prov;
	}
	public void setR13_bank_lt_50_plac_prov(BigDecimal r13_bank_lt_50_plac_prov) {
		this.r13_bank_lt_50_plac_prov = r13_bank_lt_50_plac_prov;
	}
	public BigDecimal getR13_bank_lt_50_plac_crm() {
		return r13_bank_lt_50_plac_crm;
	}
	public void setR13_bank_lt_50_plac_crm(BigDecimal r13_bank_lt_50_plac_crm) {
		this.r13_bank_lt_50_plac_crm = r13_bank_lt_50_plac_crm;
	}
	public BigDecimal getR13_bank_lt_50_plac_rwa() {
		return r13_bank_lt_50_plac_rwa;
	}
	public void setR13_bank_lt_50_plac_rwa(BigDecimal r13_bank_lt_50_plac_rwa) {
		this.r13_bank_lt_50_plac_rwa = r13_bank_lt_50_plac_rwa;
	}
	public BigDecimal getR13_bank_lt_50_cash_bal() {
		return r13_bank_lt_50_cash_bal;
	}
	public void setR13_bank_lt_50_cash_bal(BigDecimal r13_bank_lt_50_cash_bal) {
		this.r13_bank_lt_50_cash_bal = r13_bank_lt_50_cash_bal;
	}
	public BigDecimal getR13_bank_lt_50_cash_prov() {
		return r13_bank_lt_50_cash_prov;
	}
	public void setR13_bank_lt_50_cash_prov(BigDecimal r13_bank_lt_50_cash_prov) {
		this.r13_bank_lt_50_cash_prov = r13_bank_lt_50_cash_prov;
	}
	public BigDecimal getR13_bank_lt_50_cash_crm() {
		return r13_bank_lt_50_cash_crm;
	}
	public void setR13_bank_lt_50_cash_crm(BigDecimal r13_bank_lt_50_cash_crm) {
		this.r13_bank_lt_50_cash_crm = r13_bank_lt_50_cash_crm;
	}
	public BigDecimal getR13_bank_lt_50_cash_rwa() {
		return r13_bank_lt_50_cash_rwa;
	}
	public void setR13_bank_lt_50_cash_rwa(BigDecimal r13_bank_lt_50_cash_rwa) {
		this.r13_bank_lt_50_cash_rwa = r13_bank_lt_50_cash_rwa;
	}
	public BigDecimal getR13_bank_lt_50_tot_bal() {
		return r13_bank_lt_50_tot_bal;
	}
	public void setR13_bank_lt_50_tot_bal(BigDecimal r13_bank_lt_50_tot_bal) {
		this.r13_bank_lt_50_tot_bal = r13_bank_lt_50_tot_bal;
	}
	public BigDecimal getR13_bank_lt_50_tot_prov() {
		return r13_bank_lt_50_tot_prov;
	}
	public void setR13_bank_lt_50_tot_prov(BigDecimal r13_bank_lt_50_tot_prov) {
		this.r13_bank_lt_50_tot_prov = r13_bank_lt_50_tot_prov;
	}
	public BigDecimal getR13_bank_lt_50_tot_int_sus() {
		return r13_bank_lt_50_tot_int_sus;
	}
	public void setR13_bank_lt_50_tot_int_sus(BigDecimal r13_bank_lt_50_tot_int_sus) {
		this.r13_bank_lt_50_tot_int_sus = r13_bank_lt_50_tot_int_sus;
	}
	public BigDecimal getR13_bank_lt_50_tot_crm() {
		return r13_bank_lt_50_tot_crm;
	}
	public void setR13_bank_lt_50_tot_crm(BigDecimal r13_bank_lt_50_tot_crm) {
		this.r13_bank_lt_50_tot_crm = r13_bank_lt_50_tot_crm;
	}
	public BigDecimal getR13_bank_lt_50_tot_rwa() {
		return r13_bank_lt_50_tot_rwa;
	}
	public void setR13_bank_lt_50_tot_rwa(BigDecimal r13_bank_lt_50_tot_rwa) {
		this.r13_bank_lt_50_tot_rwa = r13_bank_lt_50_tot_rwa;
	}
	public BigDecimal getR14_bank_lt_100_loan_bal() {
		return r14_bank_lt_100_loan_bal;
	}
	public void setR14_bank_lt_100_loan_bal(BigDecimal r14_bank_lt_100_loan_bal) {
		this.r14_bank_lt_100_loan_bal = r14_bank_lt_100_loan_bal;
	}
	public BigDecimal getR14_bank_lt_100_loan_bill_amt() {
		return r14_bank_lt_100_loan_bill_amt;
	}
	public void setR14_bank_lt_100_loan_bill_amt(BigDecimal r14_bank_lt_100_loan_bill_amt) {
		this.r14_bank_lt_100_loan_bill_amt = r14_bank_lt_100_loan_bill_amt;
	}
	public BigDecimal getR14_bank_lt_100_loan_tot_bal() {
		return r14_bank_lt_100_loan_tot_bal;
	}
	public void setR14_bank_lt_100_loan_tot_bal(BigDecimal r14_bank_lt_100_loan_tot_bal) {
		this.r14_bank_lt_100_loan_tot_bal = r14_bank_lt_100_loan_tot_bal;
	}
	public BigDecimal getR14_bank_lt_100_loan_tot_prov() {
		return r14_bank_lt_100_loan_tot_prov;
	}
	public void setR14_bank_lt_100_loan_tot_prov(BigDecimal r14_bank_lt_100_loan_tot_prov) {
		this.r14_bank_lt_100_loan_tot_prov = r14_bank_lt_100_loan_tot_prov;
	}
	public BigDecimal getR14_bank_lt_100_loan_int_sus() {
		return r14_bank_lt_100_loan_int_sus;
	}
	public void setR14_bank_lt_100_loan_int_sus(BigDecimal r14_bank_lt_100_loan_int_sus) {
		this.r14_bank_lt_100_loan_int_sus = r14_bank_lt_100_loan_int_sus;
	}
	public BigDecimal getR14_bank_lt_100_loan_crm() {
		return r14_bank_lt_100_loan_crm;
	}
	public void setR14_bank_lt_100_loan_crm(BigDecimal r14_bank_lt_100_loan_crm) {
		this.r14_bank_lt_100_loan_crm = r14_bank_lt_100_loan_crm;
	}
	public BigDecimal getR14_bank_lt_100_loan_tot_dra() {
		return r14_bank_lt_100_loan_tot_dra;
	}
	public void setR14_bank_lt_100_loan_tot_dra(BigDecimal r14_bank_lt_100_loan_tot_dra) {
		this.r14_bank_lt_100_loan_tot_dra = r14_bank_lt_100_loan_tot_dra;
	}
	public BigDecimal getR14_bank_lt_100_inves_bal() {
		return r14_bank_lt_100_inves_bal;
	}
	public void setR14_bank_lt_100_inves_bal(BigDecimal r14_bank_lt_100_inves_bal) {
		this.r14_bank_lt_100_inves_bal = r14_bank_lt_100_inves_bal;
	}
	public BigDecimal getR14_bank_lt_100_inves_prov() {
		return r14_bank_lt_100_inves_prov;
	}
	public void setR14_bank_lt_100_inves_prov(BigDecimal r14_bank_lt_100_inves_prov) {
		this.r14_bank_lt_100_inves_prov = r14_bank_lt_100_inves_prov;
	}
	public BigDecimal getR14_bank_lt_100_inves_crm() {
		return r14_bank_lt_100_inves_crm;
	}
	public void setR14_bank_lt_100_inves_crm(BigDecimal r14_bank_lt_100_inves_crm) {
		this.r14_bank_lt_100_inves_crm = r14_bank_lt_100_inves_crm;
	}
	public BigDecimal getR14_bank_lt_100_inves_rwa() {
		return r14_bank_lt_100_inves_rwa;
	}
	public void setR14_bank_lt_100_inves_rwa(BigDecimal r14_bank_lt_100_inves_rwa) {
		this.r14_bank_lt_100_inves_rwa = r14_bank_lt_100_inves_rwa;
	}
	public BigDecimal getR14_bank_lt_100_plac_bal() {
		return r14_bank_lt_100_plac_bal;
	}
	public void setR14_bank_lt_100_plac_bal(BigDecimal r14_bank_lt_100_plac_bal) {
		this.r14_bank_lt_100_plac_bal = r14_bank_lt_100_plac_bal;
	}
	public BigDecimal getR14_bank_lt_100_plac_prov() {
		return r14_bank_lt_100_plac_prov;
	}
	public void setR14_bank_lt_100_plac_prov(BigDecimal r14_bank_lt_100_plac_prov) {
		this.r14_bank_lt_100_plac_prov = r14_bank_lt_100_plac_prov;
	}
	public BigDecimal getR14_bank_lt_100_plac_crm() {
		return r14_bank_lt_100_plac_crm;
	}
	public void setR14_bank_lt_100_plac_crm(BigDecimal r14_bank_lt_100_plac_crm) {
		this.r14_bank_lt_100_plac_crm = r14_bank_lt_100_plac_crm;
	}
	public BigDecimal getR14_bank_lt_100_plac_rwa() {
		return r14_bank_lt_100_plac_rwa;
	}
	public void setR14_bank_lt_100_plac_rwa(BigDecimal r14_bank_lt_100_plac_rwa) {
		this.r14_bank_lt_100_plac_rwa = r14_bank_lt_100_plac_rwa;
	}
	public BigDecimal getR14_bank_lt_100_cash_bal() {
		return r14_bank_lt_100_cash_bal;
	}
	public void setR14_bank_lt_100_cash_bal(BigDecimal r14_bank_lt_100_cash_bal) {
		this.r14_bank_lt_100_cash_bal = r14_bank_lt_100_cash_bal;
	}
	public BigDecimal getR14_bank_lt_100_cash_prov() {
		return r14_bank_lt_100_cash_prov;
	}
	public void setR14_bank_lt_100_cash_prov(BigDecimal r14_bank_lt_100_cash_prov) {
		this.r14_bank_lt_100_cash_prov = r14_bank_lt_100_cash_prov;
	}
	public BigDecimal getR14_bank_lt_100_cash_crm() {
		return r14_bank_lt_100_cash_crm;
	}
	public void setR14_bank_lt_100_cash_crm(BigDecimal r14_bank_lt_100_cash_crm) {
		this.r14_bank_lt_100_cash_crm = r14_bank_lt_100_cash_crm;
	}
	public BigDecimal getR14_bank_lt_100_cash_rwa() {
		return r14_bank_lt_100_cash_rwa;
	}
	public void setR14_bank_lt_100_cash_rwa(BigDecimal r14_bank_lt_100_cash_rwa) {
		this.r14_bank_lt_100_cash_rwa = r14_bank_lt_100_cash_rwa;
	}
	public BigDecimal getR14_bank_lt_100_tot_bal() {
		return r14_bank_lt_100_tot_bal;
	}
	public void setR14_bank_lt_100_tot_bal(BigDecimal r14_bank_lt_100_tot_bal) {
		this.r14_bank_lt_100_tot_bal = r14_bank_lt_100_tot_bal;
	}
	public BigDecimal getR14_bank_lt_100_tot_prov() {
		return r14_bank_lt_100_tot_prov;
	}
	public void setR14_bank_lt_100_tot_prov(BigDecimal r14_bank_lt_100_tot_prov) {
		this.r14_bank_lt_100_tot_prov = r14_bank_lt_100_tot_prov;
	}
	public BigDecimal getR14_bank_lt_100_tot_int_sus() {
		return r14_bank_lt_100_tot_int_sus;
	}
	public void setR14_bank_lt_100_tot_int_sus(BigDecimal r14_bank_lt_100_tot_int_sus) {
		this.r14_bank_lt_100_tot_int_sus = r14_bank_lt_100_tot_int_sus;
	}
	public BigDecimal getR14_bank_lt_100_tot_crm() {
		return r14_bank_lt_100_tot_crm;
	}
	public void setR14_bank_lt_100_tot_crm(BigDecimal r14_bank_lt_100_tot_crm) {
		this.r14_bank_lt_100_tot_crm = r14_bank_lt_100_tot_crm;
	}
	public BigDecimal getR14_bank_lt_100_tot_rwa() {
		return r14_bank_lt_100_tot_rwa;
	}
	public void setR14_bank_lt_100_tot_rwa(BigDecimal r14_bank_lt_100_tot_rwa) {
		this.r14_bank_lt_100_tot_rwa = r14_bank_lt_100_tot_rwa;
	}
	public BigDecimal getR15_bank_lt_150_loan_bal() {
		return r15_bank_lt_150_loan_bal;
	}
	public void setR15_bank_lt_150_loan_bal(BigDecimal r15_bank_lt_150_loan_bal) {
		this.r15_bank_lt_150_loan_bal = r15_bank_lt_150_loan_bal;
	}
	public BigDecimal getR15_bank_lt_150_loan_bill_amt() {
		return r15_bank_lt_150_loan_bill_amt;
	}
	public void setR15_bank_lt_150_loan_bill_amt(BigDecimal r15_bank_lt_150_loan_bill_amt) {
		this.r15_bank_lt_150_loan_bill_amt = r15_bank_lt_150_loan_bill_amt;
	}
	public BigDecimal getR15_bank_lt_150_loan_tot_bal() {
		return r15_bank_lt_150_loan_tot_bal;
	}
	public void setR15_bank_lt_150_loan_tot_bal(BigDecimal r15_bank_lt_150_loan_tot_bal) {
		this.r15_bank_lt_150_loan_tot_bal = r15_bank_lt_150_loan_tot_bal;
	}
	public BigDecimal getR15_bank_lt_150_loan_tot_prov() {
		return r15_bank_lt_150_loan_tot_prov;
	}
	public void setR15_bank_lt_150_loan_tot_prov(BigDecimal r15_bank_lt_150_loan_tot_prov) {
		this.r15_bank_lt_150_loan_tot_prov = r15_bank_lt_150_loan_tot_prov;
	}
	public BigDecimal getR15_bank_lt_150_loan_int_sus() {
		return r15_bank_lt_150_loan_int_sus;
	}
	public void setR15_bank_lt_150_loan_int_sus(BigDecimal r15_bank_lt_150_loan_int_sus) {
		this.r15_bank_lt_150_loan_int_sus = r15_bank_lt_150_loan_int_sus;
	}
	public BigDecimal getR15_bank_lt_150_loan_crm() {
		return r15_bank_lt_150_loan_crm;
	}
	public void setR15_bank_lt_150_loan_crm(BigDecimal r15_bank_lt_150_loan_crm) {
		this.r15_bank_lt_150_loan_crm = r15_bank_lt_150_loan_crm;
	}
	public BigDecimal getR15_bank_lt_150_loan_tot_dra() {
		return r15_bank_lt_150_loan_tot_dra;
	}
	public void setR15_bank_lt_150_loan_tot_dra(BigDecimal r15_bank_lt_150_loan_tot_dra) {
		this.r15_bank_lt_150_loan_tot_dra = r15_bank_lt_150_loan_tot_dra;
	}
	public BigDecimal getR15_bank_lt_150_inves_bal() {
		return r15_bank_lt_150_inves_bal;
	}
	public void setR15_bank_lt_150_inves_bal(BigDecimal r15_bank_lt_150_inves_bal) {
		this.r15_bank_lt_150_inves_bal = r15_bank_lt_150_inves_bal;
	}
	public BigDecimal getR15_bank_lt_150_inves_prov() {
		return r15_bank_lt_150_inves_prov;
	}
	public void setR15_bank_lt_150_inves_prov(BigDecimal r15_bank_lt_150_inves_prov) {
		this.r15_bank_lt_150_inves_prov = r15_bank_lt_150_inves_prov;
	}
	public BigDecimal getR15_bank_lt_150_inves_crm() {
		return r15_bank_lt_150_inves_crm;
	}
	public void setR15_bank_lt_150_inves_crm(BigDecimal r15_bank_lt_150_inves_crm) {
		this.r15_bank_lt_150_inves_crm = r15_bank_lt_150_inves_crm;
	}
	public BigDecimal getR15_bank_lt_150_inves_rwa() {
		return r15_bank_lt_150_inves_rwa;
	}
	public void setR15_bank_lt_150_inves_rwa(BigDecimal r15_bank_lt_150_inves_rwa) {
		this.r15_bank_lt_150_inves_rwa = r15_bank_lt_150_inves_rwa;
	}
	public BigDecimal getR15_bank_lt_150_plac_bal() {
		return r15_bank_lt_150_plac_bal;
	}
	public void setR15_bank_lt_150_plac_bal(BigDecimal r15_bank_lt_150_plac_bal) {
		this.r15_bank_lt_150_plac_bal = r15_bank_lt_150_plac_bal;
	}
	public BigDecimal getR15_bank_lt_150_plac_prov() {
		return r15_bank_lt_150_plac_prov;
	}
	public void setR15_bank_lt_150_plac_prov(BigDecimal r15_bank_lt_150_plac_prov) {
		this.r15_bank_lt_150_plac_prov = r15_bank_lt_150_plac_prov;
	}
	public BigDecimal getR15_bank_lt_150_plac_crm() {
		return r15_bank_lt_150_plac_crm;
	}
	public void setR15_bank_lt_150_plac_crm(BigDecimal r15_bank_lt_150_plac_crm) {
		this.r15_bank_lt_150_plac_crm = r15_bank_lt_150_plac_crm;
	}
	public BigDecimal getR15_bank_lt_150_plac_rwa() {
		return r15_bank_lt_150_plac_rwa;
	}
	public void setR15_bank_lt_150_plac_rwa(BigDecimal r15_bank_lt_150_plac_rwa) {
		this.r15_bank_lt_150_plac_rwa = r15_bank_lt_150_plac_rwa;
	}
	public BigDecimal getR15_bank_lt_150_cash_bal() {
		return r15_bank_lt_150_cash_bal;
	}
	public void setR15_bank_lt_150_cash_bal(BigDecimal r15_bank_lt_150_cash_bal) {
		this.r15_bank_lt_150_cash_bal = r15_bank_lt_150_cash_bal;
	}
	public BigDecimal getR15_bank_lt_150_cash_prov() {
		return r15_bank_lt_150_cash_prov;
	}
	public void setR15_bank_lt_150_cash_prov(BigDecimal r15_bank_lt_150_cash_prov) {
		this.r15_bank_lt_150_cash_prov = r15_bank_lt_150_cash_prov;
	}
	public BigDecimal getR15_bank_lt_150_cash_crm() {
		return r15_bank_lt_150_cash_crm;
	}
	public void setR15_bank_lt_150_cash_crm(BigDecimal r15_bank_lt_150_cash_crm) {
		this.r15_bank_lt_150_cash_crm = r15_bank_lt_150_cash_crm;
	}
	public BigDecimal getR15_bank_lt_150_cash_rwa() {
		return r15_bank_lt_150_cash_rwa;
	}
	public void setR15_bank_lt_150_cash_rwa(BigDecimal r15_bank_lt_150_cash_rwa) {
		this.r15_bank_lt_150_cash_rwa = r15_bank_lt_150_cash_rwa;
	}
	public BigDecimal getR15_bank_lt_150_tot_bal() {
		return r15_bank_lt_150_tot_bal;
	}
	public void setR15_bank_lt_150_tot_bal(BigDecimal r15_bank_lt_150_tot_bal) {
		this.r15_bank_lt_150_tot_bal = r15_bank_lt_150_tot_bal;
	}
	public BigDecimal getR15_bank_lt_150_tot_prov() {
		return r15_bank_lt_150_tot_prov;
	}
	public void setR15_bank_lt_150_tot_prov(BigDecimal r15_bank_lt_150_tot_prov) {
		this.r15_bank_lt_150_tot_prov = r15_bank_lt_150_tot_prov;
	}
	public BigDecimal getR15_bank_lt_150_tot_int_sus() {
		return r15_bank_lt_150_tot_int_sus;
	}
	public void setR15_bank_lt_150_tot_int_sus(BigDecimal r15_bank_lt_150_tot_int_sus) {
		this.r15_bank_lt_150_tot_int_sus = r15_bank_lt_150_tot_int_sus;
	}
	public BigDecimal getR15_bank_lt_150_tot_crm() {
		return r15_bank_lt_150_tot_crm;
	}
	public void setR15_bank_lt_150_tot_crm(BigDecimal r15_bank_lt_150_tot_crm) {
		this.r15_bank_lt_150_tot_crm = r15_bank_lt_150_tot_crm;
	}
	public BigDecimal getR15_bank_lt_150_tot_rwa() {
		return r15_bank_lt_150_tot_rwa;
	}
	public void setR15_bank_lt_150_tot_rwa(BigDecimal r15_bank_lt_150_tot_rwa) {
		this.r15_bank_lt_150_tot_rwa = r15_bank_lt_150_tot_rwa;
	}
	public BigDecimal getR16_cbs_0_loan_bal() {
		return r16_cbs_0_loan_bal;
	}
	public void setR16_cbs_0_loan_bal(BigDecimal r16_cbs_0_loan_bal) {
		this.r16_cbs_0_loan_bal = r16_cbs_0_loan_bal;
	}
	public BigDecimal getR16_cbs_0_loan_bill_amt() {
		return r16_cbs_0_loan_bill_amt;
	}
	public void setR16_cbs_0_loan_bill_amt(BigDecimal r16_cbs_0_loan_bill_amt) {
		this.r16_cbs_0_loan_bill_amt = r16_cbs_0_loan_bill_amt;
	}
	public BigDecimal getR16_cbs_0_loan_tot_bal() {
		return r16_cbs_0_loan_tot_bal;
	}
	public void setR16_cbs_0_loan_tot_bal(BigDecimal r16_cbs_0_loan_tot_bal) {
		this.r16_cbs_0_loan_tot_bal = r16_cbs_0_loan_tot_bal;
	}
	public BigDecimal getR16_cbs_0_loan_tot_prov() {
		return r16_cbs_0_loan_tot_prov;
	}
	public void setR16_cbs_0_loan_tot_prov(BigDecimal r16_cbs_0_loan_tot_prov) {
		this.r16_cbs_0_loan_tot_prov = r16_cbs_0_loan_tot_prov;
	}
	public BigDecimal getR16_cbs_0_loan_int_sus() {
		return r16_cbs_0_loan_int_sus;
	}
	public void setR16_cbs_0_loan_int_sus(BigDecimal r16_cbs_0_loan_int_sus) {
		this.r16_cbs_0_loan_int_sus = r16_cbs_0_loan_int_sus;
	}
	public BigDecimal getR16_cbs_0_loan_crm() {
		return r16_cbs_0_loan_crm;
	}
	public void setR16_cbs_0_loan_crm(BigDecimal r16_cbs_0_loan_crm) {
		this.r16_cbs_0_loan_crm = r16_cbs_0_loan_crm;
	}
	public BigDecimal getR16_cbs_0_loan_tot_dra() {
		return r16_cbs_0_loan_tot_dra;
	}
	public void setR16_cbs_0_loan_tot_dra(BigDecimal r16_cbs_0_loan_tot_dra) {
		this.r16_cbs_0_loan_tot_dra = r16_cbs_0_loan_tot_dra;
	}
	public BigDecimal getR16_cbs_0_inves_bal() {
		return r16_cbs_0_inves_bal;
	}
	public void setR16_cbs_0_inves_bal(BigDecimal r16_cbs_0_inves_bal) {
		this.r16_cbs_0_inves_bal = r16_cbs_0_inves_bal;
	}
	public BigDecimal getR16_cbs_0_inves_prov() {
		return r16_cbs_0_inves_prov;
	}
	public void setR16_cbs_0_inves_prov(BigDecimal r16_cbs_0_inves_prov) {
		this.r16_cbs_0_inves_prov = r16_cbs_0_inves_prov;
	}
	public BigDecimal getR16_cbs_0_inves_crm() {
		return r16_cbs_0_inves_crm;
	}
	public void setR16_cbs_0_inves_crm(BigDecimal r16_cbs_0_inves_crm) {
		this.r16_cbs_0_inves_crm = r16_cbs_0_inves_crm;
	}
	public BigDecimal getR16_cbs_0_inves_rwa() {
		return r16_cbs_0_inves_rwa;
	}
	public void setR16_cbs_0_inves_rwa(BigDecimal r16_cbs_0_inves_rwa) {
		this.r16_cbs_0_inves_rwa = r16_cbs_0_inves_rwa;
	}
	public BigDecimal getR16_cbs_0_plac_bal() {
		return r16_cbs_0_plac_bal;
	}
	public void setR16_cbs_0_plac_bal(BigDecimal r16_cbs_0_plac_bal) {
		this.r16_cbs_0_plac_bal = r16_cbs_0_plac_bal;
	}
	public BigDecimal getR16_cbs_0_plac_prov() {
		return r16_cbs_0_plac_prov;
	}
	public void setR16_cbs_0_plac_prov(BigDecimal r16_cbs_0_plac_prov) {
		this.r16_cbs_0_plac_prov = r16_cbs_0_plac_prov;
	}
	public BigDecimal getR16_cbs_0_plac_crm() {
		return r16_cbs_0_plac_crm;
	}
	public void setR16_cbs_0_plac_crm(BigDecimal r16_cbs_0_plac_crm) {
		this.r16_cbs_0_plac_crm = r16_cbs_0_plac_crm;
	}
	public BigDecimal getR16_cbs_0_plac_rwa() {
		return r16_cbs_0_plac_rwa;
	}
	public void setR16_cbs_0_plac_rwa(BigDecimal r16_cbs_0_plac_rwa) {
		this.r16_cbs_0_plac_rwa = r16_cbs_0_plac_rwa;
	}
	public BigDecimal getR16_cbs_0_cash_bal() {
		return r16_cbs_0_cash_bal;
	}
	public void setR16_cbs_0_cash_bal(BigDecimal r16_cbs_0_cash_bal) {
		this.r16_cbs_0_cash_bal = r16_cbs_0_cash_bal;
	}
	public BigDecimal getR16_cbs_0_cash_prov() {
		return r16_cbs_0_cash_prov;
	}
	public void setR16_cbs_0_cash_prov(BigDecimal r16_cbs_0_cash_prov) {
		this.r16_cbs_0_cash_prov = r16_cbs_0_cash_prov;
	}
	public BigDecimal getR16_cbs_0_cash_crm() {
		return r16_cbs_0_cash_crm;
	}
	public void setR16_cbs_0_cash_crm(BigDecimal r16_cbs_0_cash_crm) {
		this.r16_cbs_0_cash_crm = r16_cbs_0_cash_crm;
	}
	public BigDecimal getR16_cbs_0_cash_rwa() {
		return r16_cbs_0_cash_rwa;
	}
	public void setR16_cbs_0_cash_rwa(BigDecimal r16_cbs_0_cash_rwa) {
		this.r16_cbs_0_cash_rwa = r16_cbs_0_cash_rwa;
	}
	public BigDecimal getR16_cbs_0_tot_bal() {
		return r16_cbs_0_tot_bal;
	}
	public void setR16_cbs_0_tot_bal(BigDecimal r16_cbs_0_tot_bal) {
		this.r16_cbs_0_tot_bal = r16_cbs_0_tot_bal;
	}
	public BigDecimal getR16_cbs_0_tot_prov() {
		return r16_cbs_0_tot_prov;
	}
	public void setR16_cbs_0_tot_prov(BigDecimal r16_cbs_0_tot_prov) {
		this.r16_cbs_0_tot_prov = r16_cbs_0_tot_prov;
	}
	public BigDecimal getR16_cbs_0_tot_int_sus() {
		return r16_cbs_0_tot_int_sus;
	}
	public void setR16_cbs_0_tot_int_sus(BigDecimal r16_cbs_0_tot_int_sus) {
		this.r16_cbs_0_tot_int_sus = r16_cbs_0_tot_int_sus;
	}
	public BigDecimal getR16_cbs_0_tot_crm() {
		return r16_cbs_0_tot_crm;
	}
	public void setR16_cbs_0_tot_crm(BigDecimal r16_cbs_0_tot_crm) {
		this.r16_cbs_0_tot_crm = r16_cbs_0_tot_crm;
	}
	public BigDecimal getR16_cbs_0_tot_rwa() {
		return r16_cbs_0_tot_rwa;
	}
	public void setR16_cbs_0_tot_rwa(BigDecimal r16_cbs_0_tot_rwa) {
		this.r16_cbs_0_tot_rwa = r16_cbs_0_tot_rwa;
	}
	public BigDecimal getR17_cbs_20_loan_bal() {
		return r17_cbs_20_loan_bal;
	}
	public void setR17_cbs_20_loan_bal(BigDecimal r17_cbs_20_loan_bal) {
		this.r17_cbs_20_loan_bal = r17_cbs_20_loan_bal;
	}
	public BigDecimal getR17_cbs_20_loan_bill_amt() {
		return r17_cbs_20_loan_bill_amt;
	}
	public void setR17_cbs_20_loan_bill_amt(BigDecimal r17_cbs_20_loan_bill_amt) {
		this.r17_cbs_20_loan_bill_amt = r17_cbs_20_loan_bill_amt;
	}
	public BigDecimal getR17_cbs_20_loan_tot_bal() {
		return r17_cbs_20_loan_tot_bal;
	}
	public void setR17_cbs_20_loan_tot_bal(BigDecimal r17_cbs_20_loan_tot_bal) {
		this.r17_cbs_20_loan_tot_bal = r17_cbs_20_loan_tot_bal;
	}
	public BigDecimal getR17_cbs_20_loan_tot_prov() {
		return r17_cbs_20_loan_tot_prov;
	}
	public void setR17_cbs_20_loan_tot_prov(BigDecimal r17_cbs_20_loan_tot_prov) {
		this.r17_cbs_20_loan_tot_prov = r17_cbs_20_loan_tot_prov;
	}
	public BigDecimal getR17_cbs_20_loan_int_sus() {
		return r17_cbs_20_loan_int_sus;
	}
	public void setR17_cbs_20_loan_int_sus(BigDecimal r17_cbs_20_loan_int_sus) {
		this.r17_cbs_20_loan_int_sus = r17_cbs_20_loan_int_sus;
	}
	public BigDecimal getR17_cbs_20_loan_crm() {
		return r17_cbs_20_loan_crm;
	}
	public void setR17_cbs_20_loan_crm(BigDecimal r17_cbs_20_loan_crm) {
		this.r17_cbs_20_loan_crm = r17_cbs_20_loan_crm;
	}
	public BigDecimal getR17_cbs_20_loan_tot_dra() {
		return r17_cbs_20_loan_tot_dra;
	}
	public void setR17_cbs_20_loan_tot_dra(BigDecimal r17_cbs_20_loan_tot_dra) {
		this.r17_cbs_20_loan_tot_dra = r17_cbs_20_loan_tot_dra;
	}
	public BigDecimal getR17_cbs_20_inves_bal() {
		return r17_cbs_20_inves_bal;
	}
	public void setR17_cbs_20_inves_bal(BigDecimal r17_cbs_20_inves_bal) {
		this.r17_cbs_20_inves_bal = r17_cbs_20_inves_bal;
	}
	public BigDecimal getR17_cbs_20_inves_prov() {
		return r17_cbs_20_inves_prov;
	}
	public void setR17_cbs_20_inves_prov(BigDecimal r17_cbs_20_inves_prov) {
		this.r17_cbs_20_inves_prov = r17_cbs_20_inves_prov;
	}
	public BigDecimal getR17_cbs_20_inves_crm() {
		return r17_cbs_20_inves_crm;
	}
	public void setR17_cbs_20_inves_crm(BigDecimal r17_cbs_20_inves_crm) {
		this.r17_cbs_20_inves_crm = r17_cbs_20_inves_crm;
	}
	public BigDecimal getR17_cbs_20_inves_rwa() {
		return r17_cbs_20_inves_rwa;
	}
	public void setR17_cbs_20_inves_rwa(BigDecimal r17_cbs_20_inves_rwa) {
		this.r17_cbs_20_inves_rwa = r17_cbs_20_inves_rwa;
	}
	public BigDecimal getR17_cbs_20_plac_bal() {
		return r17_cbs_20_plac_bal;
	}
	public void setR17_cbs_20_plac_bal(BigDecimal r17_cbs_20_plac_bal) {
		this.r17_cbs_20_plac_bal = r17_cbs_20_plac_bal;
	}
	public BigDecimal getR17_cbs_20_plac_prov() {
		return r17_cbs_20_plac_prov;
	}
	public void setR17_cbs_20_plac_prov(BigDecimal r17_cbs_20_plac_prov) {
		this.r17_cbs_20_plac_prov = r17_cbs_20_plac_prov;
	}
	public BigDecimal getR17_cbs_20_plac_crm() {
		return r17_cbs_20_plac_crm;
	}
	public void setR17_cbs_20_plac_crm(BigDecimal r17_cbs_20_plac_crm) {
		this.r17_cbs_20_plac_crm = r17_cbs_20_plac_crm;
	}
	public BigDecimal getR17_cbs_20_plac_rwa() {
		return r17_cbs_20_plac_rwa;
	}
	public void setR17_cbs_20_plac_rwa(BigDecimal r17_cbs_20_plac_rwa) {
		this.r17_cbs_20_plac_rwa = r17_cbs_20_plac_rwa;
	}
	public BigDecimal getR17_cbs_20_cash_bal() {
		return r17_cbs_20_cash_bal;
	}
	public void setR17_cbs_20_cash_bal(BigDecimal r17_cbs_20_cash_bal) {
		this.r17_cbs_20_cash_bal = r17_cbs_20_cash_bal;
	}
	public BigDecimal getR17_cbs_20_cash_prov() {
		return r17_cbs_20_cash_prov;
	}
	public void setR17_cbs_20_cash_prov(BigDecimal r17_cbs_20_cash_prov) {
		this.r17_cbs_20_cash_prov = r17_cbs_20_cash_prov;
	}
	public BigDecimal getR17_cbs_20_cash_crm() {
		return r17_cbs_20_cash_crm;
	}
	public void setR17_cbs_20_cash_crm(BigDecimal r17_cbs_20_cash_crm) {
		this.r17_cbs_20_cash_crm = r17_cbs_20_cash_crm;
	}
	public BigDecimal getR17_cbs_20_cash_rwa() {
		return r17_cbs_20_cash_rwa;
	}
	public void setR17_cbs_20_cash_rwa(BigDecimal r17_cbs_20_cash_rwa) {
		this.r17_cbs_20_cash_rwa = r17_cbs_20_cash_rwa;
	}
	public BigDecimal getR17_cbs_20_tot_bal() {
		return r17_cbs_20_tot_bal;
	}
	public void setR17_cbs_20_tot_bal(BigDecimal r17_cbs_20_tot_bal) {
		this.r17_cbs_20_tot_bal = r17_cbs_20_tot_bal;
	}
	public BigDecimal getR17_cbs_20_tot_prov() {
		return r17_cbs_20_tot_prov;
	}
	public void setR17_cbs_20_tot_prov(BigDecimal r17_cbs_20_tot_prov) {
		this.r17_cbs_20_tot_prov = r17_cbs_20_tot_prov;
	}
	public BigDecimal getR17_cbs_20_tot_int_sus() {
		return r17_cbs_20_tot_int_sus;
	}
	public void setR17_cbs_20_tot_int_sus(BigDecimal r17_cbs_20_tot_int_sus) {
		this.r17_cbs_20_tot_int_sus = r17_cbs_20_tot_int_sus;
	}
	public BigDecimal getR17_cbs_20_tot_crm() {
		return r17_cbs_20_tot_crm;
	}
	public void setR17_cbs_20_tot_crm(BigDecimal r17_cbs_20_tot_crm) {
		this.r17_cbs_20_tot_crm = r17_cbs_20_tot_crm;
	}
	public BigDecimal getR17_cbs_20_tot_rwa() {
		return r17_cbs_20_tot_rwa;
	}
	public void setR17_cbs_20_tot_rwa(BigDecimal r17_cbs_20_tot_rwa) {
		this.r17_cbs_20_tot_rwa = r17_cbs_20_tot_rwa;
	}
	public BigDecimal getR18_cbs_20_loan_bal() {
		return r18_cbs_20_loan_bal;
	}
	public void setR18_cbs_20_loan_bal(BigDecimal r18_cbs_20_loan_bal) {
		this.r18_cbs_20_loan_bal = r18_cbs_20_loan_bal;
	}
	public BigDecimal getR18_cbs_20_loan_bill_amt() {
		return r18_cbs_20_loan_bill_amt;
	}
	public void setR18_cbs_20_loan_bill_amt(BigDecimal r18_cbs_20_loan_bill_amt) {
		this.r18_cbs_20_loan_bill_amt = r18_cbs_20_loan_bill_amt;
	}
	public BigDecimal getR18_cbs_20_loan_tot_bal() {
		return r18_cbs_20_loan_tot_bal;
	}
	public void setR18_cbs_20_loan_tot_bal(BigDecimal r18_cbs_20_loan_tot_bal) {
		this.r18_cbs_20_loan_tot_bal = r18_cbs_20_loan_tot_bal;
	}
	public BigDecimal getR18_cbs_20_loan_tot_prov() {
		return r18_cbs_20_loan_tot_prov;
	}
	public void setR18_cbs_20_loan_tot_prov(BigDecimal r18_cbs_20_loan_tot_prov) {
		this.r18_cbs_20_loan_tot_prov = r18_cbs_20_loan_tot_prov;
	}
	public BigDecimal getR18_cbs_20_loan_int_sus() {
		return r18_cbs_20_loan_int_sus;
	}
	public void setR18_cbs_20_loan_int_sus(BigDecimal r18_cbs_20_loan_int_sus) {
		this.r18_cbs_20_loan_int_sus = r18_cbs_20_loan_int_sus;
	}
	public BigDecimal getR18_cbs_20_loan_crm() {
		return r18_cbs_20_loan_crm;
	}
	public void setR18_cbs_20_loan_crm(BigDecimal r18_cbs_20_loan_crm) {
		this.r18_cbs_20_loan_crm = r18_cbs_20_loan_crm;
	}
	public BigDecimal getR18_cbs_20_loan_tot_dra() {
		return r18_cbs_20_loan_tot_dra;
	}
	public void setR18_cbs_20_loan_tot_dra(BigDecimal r18_cbs_20_loan_tot_dra) {
		this.r18_cbs_20_loan_tot_dra = r18_cbs_20_loan_tot_dra;
	}
	public BigDecimal getR18_cbs_20_inves_bal() {
		return r18_cbs_20_inves_bal;
	}
	public void setR18_cbs_20_inves_bal(BigDecimal r18_cbs_20_inves_bal) {
		this.r18_cbs_20_inves_bal = r18_cbs_20_inves_bal;
	}
	public BigDecimal getR18_cbs_20_inves_prov() {
		return r18_cbs_20_inves_prov;
	}
	public void setR18_cbs_20_inves_prov(BigDecimal r18_cbs_20_inves_prov) {
		this.r18_cbs_20_inves_prov = r18_cbs_20_inves_prov;
	}
	public BigDecimal getR18_cbs_20_inves_crm() {
		return r18_cbs_20_inves_crm;
	}
	public void setR18_cbs_20_inves_crm(BigDecimal r18_cbs_20_inves_crm) {
		this.r18_cbs_20_inves_crm = r18_cbs_20_inves_crm;
	}
	public BigDecimal getR18_cbs_20_inves_rwa() {
		return r18_cbs_20_inves_rwa;
	}
	public void setR18_cbs_20_inves_rwa(BigDecimal r18_cbs_20_inves_rwa) {
		this.r18_cbs_20_inves_rwa = r18_cbs_20_inves_rwa;
	}
	public BigDecimal getR18_cbs_20_plac_bal() {
		return r18_cbs_20_plac_bal;
	}
	public void setR18_cbs_20_plac_bal(BigDecimal r18_cbs_20_plac_bal) {
		this.r18_cbs_20_plac_bal = r18_cbs_20_plac_bal;
	}
	public BigDecimal getR18_cbs_20_plac_prov() {
		return r18_cbs_20_plac_prov;
	}
	public void setR18_cbs_20_plac_prov(BigDecimal r18_cbs_20_plac_prov) {
		this.r18_cbs_20_plac_prov = r18_cbs_20_plac_prov;
	}
	public BigDecimal getR18_cbs_20_plac_crm() {
		return r18_cbs_20_plac_crm;
	}
	public void setR18_cbs_20_plac_crm(BigDecimal r18_cbs_20_plac_crm) {
		this.r18_cbs_20_plac_crm = r18_cbs_20_plac_crm;
	}
	public BigDecimal getR18_cbs_20_plac_rwa() {
		return r18_cbs_20_plac_rwa;
	}
	public void setR18_cbs_20_plac_rwa(BigDecimal r18_cbs_20_plac_rwa) {
		this.r18_cbs_20_plac_rwa = r18_cbs_20_plac_rwa;
	}
	public BigDecimal getR18_cbs_20_cash_bal() {
		return r18_cbs_20_cash_bal;
	}
	public void setR18_cbs_20_cash_bal(BigDecimal r18_cbs_20_cash_bal) {
		this.r18_cbs_20_cash_bal = r18_cbs_20_cash_bal;
	}
	public BigDecimal getR18_cbs_20_cash_prov() {
		return r18_cbs_20_cash_prov;
	}
	public void setR18_cbs_20_cash_prov(BigDecimal r18_cbs_20_cash_prov) {
		this.r18_cbs_20_cash_prov = r18_cbs_20_cash_prov;
	}
	public BigDecimal getR18_cbs_20_cash_crm() {
		return r18_cbs_20_cash_crm;
	}
	public void setR18_cbs_20_cash_crm(BigDecimal r18_cbs_20_cash_crm) {
		this.r18_cbs_20_cash_crm = r18_cbs_20_cash_crm;
	}
	public BigDecimal getR18_cbs_20_cash_rwa() {
		return r18_cbs_20_cash_rwa;
	}
	public void setR18_cbs_20_cash_rwa(BigDecimal r18_cbs_20_cash_rwa) {
		this.r18_cbs_20_cash_rwa = r18_cbs_20_cash_rwa;
	}
	public BigDecimal getR18_cbs_20_tot_bal() {
		return r18_cbs_20_tot_bal;
	}
	public void setR18_cbs_20_tot_bal(BigDecimal r18_cbs_20_tot_bal) {
		this.r18_cbs_20_tot_bal = r18_cbs_20_tot_bal;
	}
	public BigDecimal getR18_cbs_20_tot_prov() {
		return r18_cbs_20_tot_prov;
	}
	public void setR18_cbs_20_tot_prov(BigDecimal r18_cbs_20_tot_prov) {
		this.r18_cbs_20_tot_prov = r18_cbs_20_tot_prov;
	}
	public BigDecimal getR18_cbs_20_tot_int_sus() {
		return r18_cbs_20_tot_int_sus;
	}
	public void setR18_cbs_20_tot_int_sus(BigDecimal r18_cbs_20_tot_int_sus) {
		this.r18_cbs_20_tot_int_sus = r18_cbs_20_tot_int_sus;
	}
	public BigDecimal getR18_cbs_20_tot_crm() {
		return r18_cbs_20_tot_crm;
	}
	public void setR18_cbs_20_tot_crm(BigDecimal r18_cbs_20_tot_crm) {
		this.r18_cbs_20_tot_crm = r18_cbs_20_tot_crm;
	}
	public BigDecimal getR18_cbs_20_tot_rwa() {
		return r18_cbs_20_tot_rwa;
	}
	public void setR18_cbs_20_tot_rwa(BigDecimal r18_cbs_20_tot_rwa) {
		this.r18_cbs_20_tot_rwa = r18_cbs_20_tot_rwa;
	}
	public BigDecimal getR19_cbs_0_loan_bal() {
		return r19_cbs_0_loan_bal;
	}
	public void setR19_cbs_0_loan_bal(BigDecimal r19_cbs_0_loan_bal) {
		this.r19_cbs_0_loan_bal = r19_cbs_0_loan_bal;
	}
	public BigDecimal getR19_cbs_0_loan_bill_amt() {
		return r19_cbs_0_loan_bill_amt;
	}
	public void setR19_cbs_0_loan_bill_amt(BigDecimal r19_cbs_0_loan_bill_amt) {
		this.r19_cbs_0_loan_bill_amt = r19_cbs_0_loan_bill_amt;
	}
	public BigDecimal getR19_cbs_0_loan_tot_bal() {
		return r19_cbs_0_loan_tot_bal;
	}
	public void setR19_cbs_0_loan_tot_bal(BigDecimal r19_cbs_0_loan_tot_bal) {
		this.r19_cbs_0_loan_tot_bal = r19_cbs_0_loan_tot_bal;
	}
	public BigDecimal getR19_cbs_0_loan_tot_prov() {
		return r19_cbs_0_loan_tot_prov;
	}
	public void setR19_cbs_0_loan_tot_prov(BigDecimal r19_cbs_0_loan_tot_prov) {
		this.r19_cbs_0_loan_tot_prov = r19_cbs_0_loan_tot_prov;
	}
	public BigDecimal getR19_cbs_0_loan_int_sus() {
		return r19_cbs_0_loan_int_sus;
	}
	public void setR19_cbs_0_loan_int_sus(BigDecimal r19_cbs_0_loan_int_sus) {
		this.r19_cbs_0_loan_int_sus = r19_cbs_0_loan_int_sus;
	}
	public BigDecimal getR19_cbs_0_loan_crm() {
		return r19_cbs_0_loan_crm;
	}
	public void setR19_cbs_0_loan_crm(BigDecimal r19_cbs_0_loan_crm) {
		this.r19_cbs_0_loan_crm = r19_cbs_0_loan_crm;
	}
	public BigDecimal getR19_cbs_0_loan_tot_dra() {
		return r19_cbs_0_loan_tot_dra;
	}
	public void setR19_cbs_0_loan_tot_dra(BigDecimal r19_cbs_0_loan_tot_dra) {
		this.r19_cbs_0_loan_tot_dra = r19_cbs_0_loan_tot_dra;
	}
	public BigDecimal getR19_cbs_0_inves_bal() {
		return r19_cbs_0_inves_bal;
	}
	public void setR19_cbs_0_inves_bal(BigDecimal r19_cbs_0_inves_bal) {
		this.r19_cbs_0_inves_bal = r19_cbs_0_inves_bal;
	}
	public BigDecimal getR19_cbs_0_inves_prov() {
		return r19_cbs_0_inves_prov;
	}
	public void setR19_cbs_0_inves_prov(BigDecimal r19_cbs_0_inves_prov) {
		this.r19_cbs_0_inves_prov = r19_cbs_0_inves_prov;
	}
	public BigDecimal getR19_cbs_0_inves_crm() {
		return r19_cbs_0_inves_crm;
	}
	public void setR19_cbs_0_inves_crm(BigDecimal r19_cbs_0_inves_crm) {
		this.r19_cbs_0_inves_crm = r19_cbs_0_inves_crm;
	}
	public BigDecimal getR19_cbs_0_inves_rwa() {
		return r19_cbs_0_inves_rwa;
	}
	public void setR19_cbs_0_inves_rwa(BigDecimal r19_cbs_0_inves_rwa) {
		this.r19_cbs_0_inves_rwa = r19_cbs_0_inves_rwa;
	}
	public BigDecimal getR19_cbs_0_plac_bal() {
		return r19_cbs_0_plac_bal;
	}
	public void setR19_cbs_0_plac_bal(BigDecimal r19_cbs_0_plac_bal) {
		this.r19_cbs_0_plac_bal = r19_cbs_0_plac_bal;
	}
	public BigDecimal getR19_cbs_0_plac_prov() {
		return r19_cbs_0_plac_prov;
	}
	public void setR19_cbs_0_plac_prov(BigDecimal r19_cbs_0_plac_prov) {
		this.r19_cbs_0_plac_prov = r19_cbs_0_plac_prov;
	}
	public BigDecimal getR19_cbs_0_plac_crm() {
		return r19_cbs_0_plac_crm;
	}
	public void setR19_cbs_0_plac_crm(BigDecimal r19_cbs_0_plac_crm) {
		this.r19_cbs_0_plac_crm = r19_cbs_0_plac_crm;
	}
	public BigDecimal getR19_cbs_0_plac_rwa() {
		return r19_cbs_0_plac_rwa;
	}
	public void setR19_cbs_0_plac_rwa(BigDecimal r19_cbs_0_plac_rwa) {
		this.r19_cbs_0_plac_rwa = r19_cbs_0_plac_rwa;
	}
	public BigDecimal getR19_cbs_0_cash_bal() {
		return r19_cbs_0_cash_bal;
	}
	public void setR19_cbs_0_cash_bal(BigDecimal r19_cbs_0_cash_bal) {
		this.r19_cbs_0_cash_bal = r19_cbs_0_cash_bal;
	}
	public BigDecimal getR19_cbs_0_cash_prov() {
		return r19_cbs_0_cash_prov;
	}
	public void setR19_cbs_0_cash_prov(BigDecimal r19_cbs_0_cash_prov) {
		this.r19_cbs_0_cash_prov = r19_cbs_0_cash_prov;
	}
	public BigDecimal getR19_cbs_0_cash_crm() {
		return r19_cbs_0_cash_crm;
	}
	public void setR19_cbs_0_cash_crm(BigDecimal r19_cbs_0_cash_crm) {
		this.r19_cbs_0_cash_crm = r19_cbs_0_cash_crm;
	}
	public BigDecimal getR19_cbs_0_cash_rwa() {
		return r19_cbs_0_cash_rwa;
	}
	public void setR19_cbs_0_cash_rwa(BigDecimal r19_cbs_0_cash_rwa) {
		this.r19_cbs_0_cash_rwa = r19_cbs_0_cash_rwa;
	}
	public BigDecimal getR19_cbs_0_tot_bal() {
		return r19_cbs_0_tot_bal;
	}
	public void setR19_cbs_0_tot_bal(BigDecimal r19_cbs_0_tot_bal) {
		this.r19_cbs_0_tot_bal = r19_cbs_0_tot_bal;
	}
	public BigDecimal getR19_cbs_0_tot_prov() {
		return r19_cbs_0_tot_prov;
	}
	public void setR19_cbs_0_tot_prov(BigDecimal r19_cbs_0_tot_prov) {
		this.r19_cbs_0_tot_prov = r19_cbs_0_tot_prov;
	}
	public BigDecimal getR19_cbs_0_tot_int_sus() {
		return r19_cbs_0_tot_int_sus;
	}
	public void setR19_cbs_0_tot_int_sus(BigDecimal r19_cbs_0_tot_int_sus) {
		this.r19_cbs_0_tot_int_sus = r19_cbs_0_tot_int_sus;
	}
	public BigDecimal getR19_cbs_0_tot_crm() {
		return r19_cbs_0_tot_crm;
	}
	public void setR19_cbs_0_tot_crm(BigDecimal r19_cbs_0_tot_crm) {
		this.r19_cbs_0_tot_crm = r19_cbs_0_tot_crm;
	}
	public BigDecimal getR19_cbs_0_tot_rwa() {
		return r19_cbs_0_tot_rwa;
	}
	public void setR19_cbs_0_tot_rwa(BigDecimal r19_cbs_0_tot_rwa) {
		this.r19_cbs_0_tot_rwa = r19_cbs_0_tot_rwa;
	}
	public BigDecimal getR20_cbs_20_loan_bal() {
		return r20_cbs_20_loan_bal;
	}
	public void setR20_cbs_20_loan_bal(BigDecimal r20_cbs_20_loan_bal) {
		this.r20_cbs_20_loan_bal = r20_cbs_20_loan_bal;
	}
	public BigDecimal getR20_cbs_20_loan_bill_amt() {
		return r20_cbs_20_loan_bill_amt;
	}
	public void setR20_cbs_20_loan_bill_amt(BigDecimal r20_cbs_20_loan_bill_amt) {
		this.r20_cbs_20_loan_bill_amt = r20_cbs_20_loan_bill_amt;
	}
	public BigDecimal getR20_cbs_20_loan_tot_bal() {
		return r20_cbs_20_loan_tot_bal;
	}
	public void setR20_cbs_20_loan_tot_bal(BigDecimal r20_cbs_20_loan_tot_bal) {
		this.r20_cbs_20_loan_tot_bal = r20_cbs_20_loan_tot_bal;
	}
	public BigDecimal getR20_cbs_20_loan_tot_prov() {
		return r20_cbs_20_loan_tot_prov;
	}
	public void setR20_cbs_20_loan_tot_prov(BigDecimal r20_cbs_20_loan_tot_prov) {
		this.r20_cbs_20_loan_tot_prov = r20_cbs_20_loan_tot_prov;
	}
	public BigDecimal getR20_cbs_20_loan_int_sus() {
		return r20_cbs_20_loan_int_sus;
	}
	public void setR20_cbs_20_loan_int_sus(BigDecimal r20_cbs_20_loan_int_sus) {
		this.r20_cbs_20_loan_int_sus = r20_cbs_20_loan_int_sus;
	}
	public BigDecimal getR20_cbs_20_loan_crm() {
		return r20_cbs_20_loan_crm;
	}
	public void setR20_cbs_20_loan_crm(BigDecimal r20_cbs_20_loan_crm) {
		this.r20_cbs_20_loan_crm = r20_cbs_20_loan_crm;
	}
	public BigDecimal getR20_cbs_20_loan_tot_dra() {
		return r20_cbs_20_loan_tot_dra;
	}
	public void setR20_cbs_20_loan_tot_dra(BigDecimal r20_cbs_20_loan_tot_dra) {
		this.r20_cbs_20_loan_tot_dra = r20_cbs_20_loan_tot_dra;
	}
	public BigDecimal getR20_cbs_20_inves_bal() {
		return r20_cbs_20_inves_bal;
	}
	public void setR20_cbs_20_inves_bal(BigDecimal r20_cbs_20_inves_bal) {
		this.r20_cbs_20_inves_bal = r20_cbs_20_inves_bal;
	}
	public BigDecimal getR20_cbs_20_inves_prov() {
		return r20_cbs_20_inves_prov;
	}
	public void setR20_cbs_20_inves_prov(BigDecimal r20_cbs_20_inves_prov) {
		this.r20_cbs_20_inves_prov = r20_cbs_20_inves_prov;
	}
	public BigDecimal getR20_cbs_20_inves_crm() {
		return r20_cbs_20_inves_crm;
	}
	public void setR20_cbs_20_inves_crm(BigDecimal r20_cbs_20_inves_crm) {
		this.r20_cbs_20_inves_crm = r20_cbs_20_inves_crm;
	}
	public BigDecimal getR20_cbs_20_inves_rwa() {
		return r20_cbs_20_inves_rwa;
	}
	public void setR20_cbs_20_inves_rwa(BigDecimal r20_cbs_20_inves_rwa) {
		this.r20_cbs_20_inves_rwa = r20_cbs_20_inves_rwa;
	}
	public BigDecimal getR20_cbs_20_plac_bal() {
		return r20_cbs_20_plac_bal;
	}
	public void setR20_cbs_20_plac_bal(BigDecimal r20_cbs_20_plac_bal) {
		this.r20_cbs_20_plac_bal = r20_cbs_20_plac_bal;
	}
	public BigDecimal getR20_cbs_20_plac_prov() {
		return r20_cbs_20_plac_prov;
	}
	public void setR20_cbs_20_plac_prov(BigDecimal r20_cbs_20_plac_prov) {
		this.r20_cbs_20_plac_prov = r20_cbs_20_plac_prov;
	}
	public BigDecimal getR20_cbs_20_plac_crm() {
		return r20_cbs_20_plac_crm;
	}
	public void setR20_cbs_20_plac_crm(BigDecimal r20_cbs_20_plac_crm) {
		this.r20_cbs_20_plac_crm = r20_cbs_20_plac_crm;
	}
	public BigDecimal getR20_cbs_20_plac_rwa() {
		return r20_cbs_20_plac_rwa;
	}
	public void setR20_cbs_20_plac_rwa(BigDecimal r20_cbs_20_plac_rwa) {
		this.r20_cbs_20_plac_rwa = r20_cbs_20_plac_rwa;
	}
	public BigDecimal getR20_cbs_20_cash_bal() {
		return r20_cbs_20_cash_bal;
	}
	public void setR20_cbs_20_cash_bal(BigDecimal r20_cbs_20_cash_bal) {
		this.r20_cbs_20_cash_bal = r20_cbs_20_cash_bal;
	}
	public BigDecimal getR20_cbs_20_cash_prov() {
		return r20_cbs_20_cash_prov;
	}
	public void setR20_cbs_20_cash_prov(BigDecimal r20_cbs_20_cash_prov) {
		this.r20_cbs_20_cash_prov = r20_cbs_20_cash_prov;
	}
	public BigDecimal getR20_cbs_20_cash_crm() {
		return r20_cbs_20_cash_crm;
	}
	public void setR20_cbs_20_cash_crm(BigDecimal r20_cbs_20_cash_crm) {
		this.r20_cbs_20_cash_crm = r20_cbs_20_cash_crm;
	}
	public BigDecimal getR20_cbs_20_cash_rwa() {
		return r20_cbs_20_cash_rwa;
	}
	public void setR20_cbs_20_cash_rwa(BigDecimal r20_cbs_20_cash_rwa) {
		this.r20_cbs_20_cash_rwa = r20_cbs_20_cash_rwa;
	}
	public BigDecimal getR20_cbs_20_tot_bal() {
		return r20_cbs_20_tot_bal;
	}
	public void setR20_cbs_20_tot_bal(BigDecimal r20_cbs_20_tot_bal) {
		this.r20_cbs_20_tot_bal = r20_cbs_20_tot_bal;
	}
	public BigDecimal getR20_cbs_20_tot_prov() {
		return r20_cbs_20_tot_prov;
	}
	public void setR20_cbs_20_tot_prov(BigDecimal r20_cbs_20_tot_prov) {
		this.r20_cbs_20_tot_prov = r20_cbs_20_tot_prov;
	}
	public BigDecimal getR20_cbs_20_tot_int_sus() {
		return r20_cbs_20_tot_int_sus;
	}
	public void setR20_cbs_20_tot_int_sus(BigDecimal r20_cbs_20_tot_int_sus) {
		this.r20_cbs_20_tot_int_sus = r20_cbs_20_tot_int_sus;
	}
	public BigDecimal getR20_cbs_20_tot_crm() {
		return r20_cbs_20_tot_crm;
	}
	public void setR20_cbs_20_tot_crm(BigDecimal r20_cbs_20_tot_crm) {
		this.r20_cbs_20_tot_crm = r20_cbs_20_tot_crm;
	}
	public BigDecimal getR20_cbs_20_tot_rwa() {
		return r20_cbs_20_tot_rwa;
	}
	public void setR20_cbs_20_tot_rwa(BigDecimal r20_cbs_20_tot_rwa) {
		this.r20_cbs_20_tot_rwa = r20_cbs_20_tot_rwa;
	}
	public BigDecimal getR21_cbs_50_loan_bal() {
		return r21_cbs_50_loan_bal;
	}
	public void setR21_cbs_50_loan_bal(BigDecimal r21_cbs_50_loan_bal) {
		this.r21_cbs_50_loan_bal = r21_cbs_50_loan_bal;
	}
	public BigDecimal getR21_cbs_50_loan_bill_amt() {
		return r21_cbs_50_loan_bill_amt;
	}
	public void setR21_cbs_50_loan_bill_amt(BigDecimal r21_cbs_50_loan_bill_amt) {
		this.r21_cbs_50_loan_bill_amt = r21_cbs_50_loan_bill_amt;
	}
	public BigDecimal getR21_cbs_50_loan_tot_bal() {
		return r21_cbs_50_loan_tot_bal;
	}
	public void setR21_cbs_50_loan_tot_bal(BigDecimal r21_cbs_50_loan_tot_bal) {
		this.r21_cbs_50_loan_tot_bal = r21_cbs_50_loan_tot_bal;
	}
	public BigDecimal getR21_cbs_50_loan_tot_prov() {
		return r21_cbs_50_loan_tot_prov;
	}
	public void setR21_cbs_50_loan_tot_prov(BigDecimal r21_cbs_50_loan_tot_prov) {
		this.r21_cbs_50_loan_tot_prov = r21_cbs_50_loan_tot_prov;
	}
	public BigDecimal getR21_cbs_50_loan_int_sus() {
		return r21_cbs_50_loan_int_sus;
	}
	public void setR21_cbs_50_loan_int_sus(BigDecimal r21_cbs_50_loan_int_sus) {
		this.r21_cbs_50_loan_int_sus = r21_cbs_50_loan_int_sus;
	}
	public BigDecimal getR21_cbs_50_loan_crm() {
		return r21_cbs_50_loan_crm;
	}
	public void setR21_cbs_50_loan_crm(BigDecimal r21_cbs_50_loan_crm) {
		this.r21_cbs_50_loan_crm = r21_cbs_50_loan_crm;
	}
	public BigDecimal getR21_cbs_50_loan_tot_dra() {
		return r21_cbs_50_loan_tot_dra;
	}
	public void setR21_cbs_50_loan_tot_dra(BigDecimal r21_cbs_50_loan_tot_dra) {
		this.r21_cbs_50_loan_tot_dra = r21_cbs_50_loan_tot_dra;
	}
	public BigDecimal getR21_cbs_50_inves_bal() {
		return r21_cbs_50_inves_bal;
	}
	public void setR21_cbs_50_inves_bal(BigDecimal r21_cbs_50_inves_bal) {
		this.r21_cbs_50_inves_bal = r21_cbs_50_inves_bal;
	}
	public BigDecimal getR21_cbs_50_inves_prov() {
		return r21_cbs_50_inves_prov;
	}
	public void setR21_cbs_50_inves_prov(BigDecimal r21_cbs_50_inves_prov) {
		this.r21_cbs_50_inves_prov = r21_cbs_50_inves_prov;
	}
	public BigDecimal getR21_cbs_50_inves_crm() {
		return r21_cbs_50_inves_crm;
	}
	public void setR21_cbs_50_inves_crm(BigDecimal r21_cbs_50_inves_crm) {
		this.r21_cbs_50_inves_crm = r21_cbs_50_inves_crm;
	}
	public BigDecimal getR21_cbs_50_inves_rwa() {
		return r21_cbs_50_inves_rwa;
	}
	public void setR21_cbs_50_inves_rwa(BigDecimal r21_cbs_50_inves_rwa) {
		this.r21_cbs_50_inves_rwa = r21_cbs_50_inves_rwa;
	}
	public BigDecimal getR21_cbs_50_plac_bal() {
		return r21_cbs_50_plac_bal;
	}
	public void setR21_cbs_50_plac_bal(BigDecimal r21_cbs_50_plac_bal) {
		this.r21_cbs_50_plac_bal = r21_cbs_50_plac_bal;
	}
	public BigDecimal getR21_cbs_50_plac_prov() {
		return r21_cbs_50_plac_prov;
	}
	public void setR21_cbs_50_plac_prov(BigDecimal r21_cbs_50_plac_prov) {
		this.r21_cbs_50_plac_prov = r21_cbs_50_plac_prov;
	}
	public BigDecimal getR21_cbs_50_plac_crm() {
		return r21_cbs_50_plac_crm;
	}
	public void setR21_cbs_50_plac_crm(BigDecimal r21_cbs_50_plac_crm) {
		this.r21_cbs_50_plac_crm = r21_cbs_50_plac_crm;
	}
	public BigDecimal getR21_cbs_50_plac_rwa() {
		return r21_cbs_50_plac_rwa;
	}
	public void setR21_cbs_50_plac_rwa(BigDecimal r21_cbs_50_plac_rwa) {
		this.r21_cbs_50_plac_rwa = r21_cbs_50_plac_rwa;
	}
	public BigDecimal getR21_cbs_50_cash_bal() {
		return r21_cbs_50_cash_bal;
	}
	public void setR21_cbs_50_cash_bal(BigDecimal r21_cbs_50_cash_bal) {
		this.r21_cbs_50_cash_bal = r21_cbs_50_cash_bal;
	}
	public BigDecimal getR21_cbs_50_cash_prov() {
		return r21_cbs_50_cash_prov;
	}
	public void setR21_cbs_50_cash_prov(BigDecimal r21_cbs_50_cash_prov) {
		this.r21_cbs_50_cash_prov = r21_cbs_50_cash_prov;
	}
	public BigDecimal getR21_cbs_50_cash_crm() {
		return r21_cbs_50_cash_crm;
	}
	public void setR21_cbs_50_cash_crm(BigDecimal r21_cbs_50_cash_crm) {
		this.r21_cbs_50_cash_crm = r21_cbs_50_cash_crm;
	}
	public BigDecimal getR21_cbs_50_cash_rwa() {
		return r21_cbs_50_cash_rwa;
	}
	public void setR21_cbs_50_cash_rwa(BigDecimal r21_cbs_50_cash_rwa) {
		this.r21_cbs_50_cash_rwa = r21_cbs_50_cash_rwa;
	}
	public BigDecimal getR21_cbs_50_tot_bal() {
		return r21_cbs_50_tot_bal;
	}
	public void setR21_cbs_50_tot_bal(BigDecimal r21_cbs_50_tot_bal) {
		this.r21_cbs_50_tot_bal = r21_cbs_50_tot_bal;
	}
	public BigDecimal getR21_cbs_50_tot_prov() {
		return r21_cbs_50_tot_prov;
	}
	public void setR21_cbs_50_tot_prov(BigDecimal r21_cbs_50_tot_prov) {
		this.r21_cbs_50_tot_prov = r21_cbs_50_tot_prov;
	}
	public BigDecimal getR21_cbs_50_tot_int_sus() {
		return r21_cbs_50_tot_int_sus;
	}
	public void setR21_cbs_50_tot_int_sus(BigDecimal r21_cbs_50_tot_int_sus) {
		this.r21_cbs_50_tot_int_sus = r21_cbs_50_tot_int_sus;
	}
	public BigDecimal getR21_cbs_50_tot_crm() {
		return r21_cbs_50_tot_crm;
	}
	public void setR21_cbs_50_tot_crm(BigDecimal r21_cbs_50_tot_crm) {
		this.r21_cbs_50_tot_crm = r21_cbs_50_tot_crm;
	}
	public BigDecimal getR21_cbs_50_tot_rwa() {
		return r21_cbs_50_tot_rwa;
	}
	public void setR21_cbs_50_tot_rwa(BigDecimal r21_cbs_50_tot_rwa) {
		this.r21_cbs_50_tot_rwa = r21_cbs_50_tot_rwa;
	}
	public BigDecimal getR22_cbs_100_loan_bal() {
		return r22_cbs_100_loan_bal;
	}
	public void setR22_cbs_100_loan_bal(BigDecimal r22_cbs_100_loan_bal) {
		this.r22_cbs_100_loan_bal = r22_cbs_100_loan_bal;
	}
	public BigDecimal getR22_cbs_100_loan_bill_amt() {
		return r22_cbs_100_loan_bill_amt;
	}
	public void setR22_cbs_100_loan_bill_amt(BigDecimal r22_cbs_100_loan_bill_amt) {
		this.r22_cbs_100_loan_bill_amt = r22_cbs_100_loan_bill_amt;
	}
	public BigDecimal getR22_cbs_100_loan_tot_bal() {
		return r22_cbs_100_loan_tot_bal;
	}
	public void setR22_cbs_100_loan_tot_bal(BigDecimal r22_cbs_100_loan_tot_bal) {
		this.r22_cbs_100_loan_tot_bal = r22_cbs_100_loan_tot_bal;
	}
	public BigDecimal getR22_cbs_100_loan_tot_prov() {
		return r22_cbs_100_loan_tot_prov;
	}
	public void setR22_cbs_100_loan_tot_prov(BigDecimal r22_cbs_100_loan_tot_prov) {
		this.r22_cbs_100_loan_tot_prov = r22_cbs_100_loan_tot_prov;
	}
	public BigDecimal getR22_cbs_100_loan_int_sus() {
		return r22_cbs_100_loan_int_sus;
	}
	public void setR22_cbs_100_loan_int_sus(BigDecimal r22_cbs_100_loan_int_sus) {
		this.r22_cbs_100_loan_int_sus = r22_cbs_100_loan_int_sus;
	}
	public BigDecimal getR22_cbs_100_loan_crm() {
		return r22_cbs_100_loan_crm;
	}
	public void setR22_cbs_100_loan_crm(BigDecimal r22_cbs_100_loan_crm) {
		this.r22_cbs_100_loan_crm = r22_cbs_100_loan_crm;
	}
	public BigDecimal getR22_cbs_100_loan_tot_dra() {
		return r22_cbs_100_loan_tot_dra;
	}
	public void setR22_cbs_100_loan_tot_dra(BigDecimal r22_cbs_100_loan_tot_dra) {
		this.r22_cbs_100_loan_tot_dra = r22_cbs_100_loan_tot_dra;
	}
	public BigDecimal getR22_cbs_100_inves_bal() {
		return r22_cbs_100_inves_bal;
	}
	public void setR22_cbs_100_inves_bal(BigDecimal r22_cbs_100_inves_bal) {
		this.r22_cbs_100_inves_bal = r22_cbs_100_inves_bal;
	}
	public BigDecimal getR22_cbs_100_inves_prov() {
		return r22_cbs_100_inves_prov;
	}
	public void setR22_cbs_100_inves_prov(BigDecimal r22_cbs_100_inves_prov) {
		this.r22_cbs_100_inves_prov = r22_cbs_100_inves_prov;
	}
	public BigDecimal getR22_cbs_100_inves_crm() {
		return r22_cbs_100_inves_crm;
	}
	public void setR22_cbs_100_inves_crm(BigDecimal r22_cbs_100_inves_crm) {
		this.r22_cbs_100_inves_crm = r22_cbs_100_inves_crm;
	}
	public BigDecimal getR22_cbs_100_inves_rwa() {
		return r22_cbs_100_inves_rwa;
	}
	public void setR22_cbs_100_inves_rwa(BigDecimal r22_cbs_100_inves_rwa) {
		this.r22_cbs_100_inves_rwa = r22_cbs_100_inves_rwa;
	}
	public BigDecimal getR22_cbs_100_plac_bal() {
		return r22_cbs_100_plac_bal;
	}
	public void setR22_cbs_100_plac_bal(BigDecimal r22_cbs_100_plac_bal) {
		this.r22_cbs_100_plac_bal = r22_cbs_100_plac_bal;
	}
	public BigDecimal getR22_cbs_100_plac_prov() {
		return r22_cbs_100_plac_prov;
	}
	public void setR22_cbs_100_plac_prov(BigDecimal r22_cbs_100_plac_prov) {
		this.r22_cbs_100_plac_prov = r22_cbs_100_plac_prov;
	}
	public BigDecimal getR22_cbs_100_plac_crm() {
		return r22_cbs_100_plac_crm;
	}
	public void setR22_cbs_100_plac_crm(BigDecimal r22_cbs_100_plac_crm) {
		this.r22_cbs_100_plac_crm = r22_cbs_100_plac_crm;
	}
	public BigDecimal getR22_cbs_100_plac_rwa() {
		return r22_cbs_100_plac_rwa;
	}
	public void setR22_cbs_100_plac_rwa(BigDecimal r22_cbs_100_plac_rwa) {
		this.r22_cbs_100_plac_rwa = r22_cbs_100_plac_rwa;
	}
	public BigDecimal getR22_cbs_100_cash_bal() {
		return r22_cbs_100_cash_bal;
	}
	public void setR22_cbs_100_cash_bal(BigDecimal r22_cbs_100_cash_bal) {
		this.r22_cbs_100_cash_bal = r22_cbs_100_cash_bal;
	}
	public BigDecimal getR22_cbs_100_cash_prov() {
		return r22_cbs_100_cash_prov;
	}
	public void setR22_cbs_100_cash_prov(BigDecimal r22_cbs_100_cash_prov) {
		this.r22_cbs_100_cash_prov = r22_cbs_100_cash_prov;
	}
	public BigDecimal getR22_cbs_100_cash_crm() {
		return r22_cbs_100_cash_crm;
	}
	public void setR22_cbs_100_cash_crm(BigDecimal r22_cbs_100_cash_crm) {
		this.r22_cbs_100_cash_crm = r22_cbs_100_cash_crm;
	}
	public BigDecimal getR22_cbs_100_cash_rwa() {
		return r22_cbs_100_cash_rwa;
	}
	public void setR22_cbs_100_cash_rwa(BigDecimal r22_cbs_100_cash_rwa) {
		this.r22_cbs_100_cash_rwa = r22_cbs_100_cash_rwa;
	}
	public BigDecimal getR22_cbs_100_tot_bal() {
		return r22_cbs_100_tot_bal;
	}
	public void setR22_cbs_100_tot_bal(BigDecimal r22_cbs_100_tot_bal) {
		this.r22_cbs_100_tot_bal = r22_cbs_100_tot_bal;
	}
	public BigDecimal getR22_cbs_100_tot_prov() {
		return r22_cbs_100_tot_prov;
	}
	public void setR22_cbs_100_tot_prov(BigDecimal r22_cbs_100_tot_prov) {
		this.r22_cbs_100_tot_prov = r22_cbs_100_tot_prov;
	}
	public BigDecimal getR22_cbs_100_tot_int_sus() {
		return r22_cbs_100_tot_int_sus;
	}
	public void setR22_cbs_100_tot_int_sus(BigDecimal r22_cbs_100_tot_int_sus) {
		this.r22_cbs_100_tot_int_sus = r22_cbs_100_tot_int_sus;
	}
	public BigDecimal getR22_cbs_100_tot_crm() {
		return r22_cbs_100_tot_crm;
	}
	public void setR22_cbs_100_tot_crm(BigDecimal r22_cbs_100_tot_crm) {
		this.r22_cbs_100_tot_crm = r22_cbs_100_tot_crm;
	}
	public BigDecimal getR22_cbs_100_tot_rwa() {
		return r22_cbs_100_tot_rwa;
	}
	public void setR22_cbs_100_tot_rwa(BigDecimal r22_cbs_100_tot_rwa) {
		this.r22_cbs_100_tot_rwa = r22_cbs_100_tot_rwa;
	}
	public BigDecimal getR23_cbs_150_loan_bal() {
		return r23_cbs_150_loan_bal;
	}
	public void setR23_cbs_150_loan_bal(BigDecimal r23_cbs_150_loan_bal) {
		this.r23_cbs_150_loan_bal = r23_cbs_150_loan_bal;
	}
	public BigDecimal getR23_cbs_150_loan_bill_amt() {
		return r23_cbs_150_loan_bill_amt;
	}
	public void setR23_cbs_150_loan_bill_amt(BigDecimal r23_cbs_150_loan_bill_amt) {
		this.r23_cbs_150_loan_bill_amt = r23_cbs_150_loan_bill_amt;
	}
	public BigDecimal getR23_cbs_150_loan_tot_bal() {
		return r23_cbs_150_loan_tot_bal;
	}
	public void setR23_cbs_150_loan_tot_bal(BigDecimal r23_cbs_150_loan_tot_bal) {
		this.r23_cbs_150_loan_tot_bal = r23_cbs_150_loan_tot_bal;
	}
	public BigDecimal getR23_cbs_150_loan_tot_prov() {
		return r23_cbs_150_loan_tot_prov;
	}
	public void setR23_cbs_150_loan_tot_prov(BigDecimal r23_cbs_150_loan_tot_prov) {
		this.r23_cbs_150_loan_tot_prov = r23_cbs_150_loan_tot_prov;
	}
	public BigDecimal getR23_cbs_150_loan_int_sus() {
		return r23_cbs_150_loan_int_sus;
	}
	public void setR23_cbs_150_loan_int_sus(BigDecimal r23_cbs_150_loan_int_sus) {
		this.r23_cbs_150_loan_int_sus = r23_cbs_150_loan_int_sus;
	}
	public BigDecimal getR23_cbs_150_loan_crm() {
		return r23_cbs_150_loan_crm;
	}
	public void setR23_cbs_150_loan_crm(BigDecimal r23_cbs_150_loan_crm) {
		this.r23_cbs_150_loan_crm = r23_cbs_150_loan_crm;
	}
	public BigDecimal getR23_cbs_150_loan_tot_dra() {
		return r23_cbs_150_loan_tot_dra;
	}
	public void setR23_cbs_150_loan_tot_dra(BigDecimal r23_cbs_150_loan_tot_dra) {
		this.r23_cbs_150_loan_tot_dra = r23_cbs_150_loan_tot_dra;
	}
	public BigDecimal getR23_cbs_150_inves_bal() {
		return r23_cbs_150_inves_bal;
	}
	public void setR23_cbs_150_inves_bal(BigDecimal r23_cbs_150_inves_bal) {
		this.r23_cbs_150_inves_bal = r23_cbs_150_inves_bal;
	}
	public BigDecimal getR23_cbs_150_inves_prov() {
		return r23_cbs_150_inves_prov;
	}
	public void setR23_cbs_150_inves_prov(BigDecimal r23_cbs_150_inves_prov) {
		this.r23_cbs_150_inves_prov = r23_cbs_150_inves_prov;
	}
	public BigDecimal getR23_cbs_150_inves_crm() {
		return r23_cbs_150_inves_crm;
	}
	public void setR23_cbs_150_inves_crm(BigDecimal r23_cbs_150_inves_crm) {
		this.r23_cbs_150_inves_crm = r23_cbs_150_inves_crm;
	}
	public BigDecimal getR23_cbs_150_inves_rwa() {
		return r23_cbs_150_inves_rwa;
	}
	public void setR23_cbs_150_inves_rwa(BigDecimal r23_cbs_150_inves_rwa) {
		this.r23_cbs_150_inves_rwa = r23_cbs_150_inves_rwa;
	}
	public BigDecimal getR23_cbs_150_plac_bal() {
		return r23_cbs_150_plac_bal;
	}
	public void setR23_cbs_150_plac_bal(BigDecimal r23_cbs_150_plac_bal) {
		this.r23_cbs_150_plac_bal = r23_cbs_150_plac_bal;
	}
	public BigDecimal getR23_cbs_150_plac_prov() {
		return r23_cbs_150_plac_prov;
	}
	public void setR23_cbs_150_plac_prov(BigDecimal r23_cbs_150_plac_prov) {
		this.r23_cbs_150_plac_prov = r23_cbs_150_plac_prov;
	}
	public BigDecimal getR23_cbs_150_plac_crm() {
		return r23_cbs_150_plac_crm;
	}
	public void setR23_cbs_150_plac_crm(BigDecimal r23_cbs_150_plac_crm) {
		this.r23_cbs_150_plac_crm = r23_cbs_150_plac_crm;
	}
	public BigDecimal getR23_cbs_150_plac_rwa() {
		return r23_cbs_150_plac_rwa;
	}
	public void setR23_cbs_150_plac_rwa(BigDecimal r23_cbs_150_plac_rwa) {
		this.r23_cbs_150_plac_rwa = r23_cbs_150_plac_rwa;
	}
	public BigDecimal getR23_cbs_150_cash_bal() {
		return r23_cbs_150_cash_bal;
	}
	public void setR23_cbs_150_cash_bal(BigDecimal r23_cbs_150_cash_bal) {
		this.r23_cbs_150_cash_bal = r23_cbs_150_cash_bal;
	}
	public BigDecimal getR23_cbs_150_cash_prov() {
		return r23_cbs_150_cash_prov;
	}
	public void setR23_cbs_150_cash_prov(BigDecimal r23_cbs_150_cash_prov) {
		this.r23_cbs_150_cash_prov = r23_cbs_150_cash_prov;
	}
	public BigDecimal getR23_cbs_150_cash_crm() {
		return r23_cbs_150_cash_crm;
	}
	public void setR23_cbs_150_cash_crm(BigDecimal r23_cbs_150_cash_crm) {
		this.r23_cbs_150_cash_crm = r23_cbs_150_cash_crm;
	}
	public BigDecimal getR23_cbs_150_cash_rwa() {
		return r23_cbs_150_cash_rwa;
	}
	public void setR23_cbs_150_cash_rwa(BigDecimal r23_cbs_150_cash_rwa) {
		this.r23_cbs_150_cash_rwa = r23_cbs_150_cash_rwa;
	}
	public BigDecimal getR23_cbs_150_tot_bal() {
		return r23_cbs_150_tot_bal;
	}
	public void setR23_cbs_150_tot_bal(BigDecimal r23_cbs_150_tot_bal) {
		this.r23_cbs_150_tot_bal = r23_cbs_150_tot_bal;
	}
	public BigDecimal getR23_cbs_150_tot_prov() {
		return r23_cbs_150_tot_prov;
	}
	public void setR23_cbs_150_tot_prov(BigDecimal r23_cbs_150_tot_prov) {
		this.r23_cbs_150_tot_prov = r23_cbs_150_tot_prov;
	}
	public BigDecimal getR23_cbs_150_tot_int_sus() {
		return r23_cbs_150_tot_int_sus;
	}
	public void setR23_cbs_150_tot_int_sus(BigDecimal r23_cbs_150_tot_int_sus) {
		this.r23_cbs_150_tot_int_sus = r23_cbs_150_tot_int_sus;
	}
	public BigDecimal getR23_cbs_150_tot_crm() {
		return r23_cbs_150_tot_crm;
	}
	public void setR23_cbs_150_tot_crm(BigDecimal r23_cbs_150_tot_crm) {
		this.r23_cbs_150_tot_crm = r23_cbs_150_tot_crm;
	}
	public BigDecimal getR23_cbs_150_tot_rwa() {
		return r23_cbs_150_tot_rwa;
	}
	public void setR23_cbs_150_tot_rwa(BigDecimal r23_cbs_150_tot_rwa) {
		this.r23_cbs_150_tot_rwa = r23_cbs_150_tot_rwa;
	}
	public Date getReport_submit_date() {
		return report_submit_date;
	}
	public void setReport_submit_date(Date report_submit_date) {
		this.report_submit_date = report_submit_date;
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
	public BRF95_FUND_BASED1() {
		super();
		// TODO Auto-generated constructor stub
	}
}