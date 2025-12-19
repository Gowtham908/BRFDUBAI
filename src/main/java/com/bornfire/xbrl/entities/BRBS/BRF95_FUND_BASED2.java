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
@Table(name="BRF95_FUND_BASED2")
public class BRF95_FUND_BASED2 {
	private BigDecimal	r24_cre_0_loan_bal;
	private BigDecimal	r24_cre_0_loan_bill_amt;
	private BigDecimal	r24_cre_0_loan_tot_bal;
	private BigDecimal	r24_cre_0_loan_tot_prov;
	private BigDecimal	r24_cre_0_loan_int_sus;
	private BigDecimal	r24_cre_0_loan_crm;
	private BigDecimal	r24_cre_0_loan_tot_dra;
	private BigDecimal	r24_cre_0_inves_bal;
	private BigDecimal	r24_cre_0_inves_prov;
	private BigDecimal	r24_cre_0_inves_crm;
	private BigDecimal	r24_cre_0_inves_rwa;
	private BigDecimal	r24_cre_0_plac_bal;
	private BigDecimal	r24_cre_0_plac_prov;
	private BigDecimal	r24_cre_0_plac_crm;
	private BigDecimal	r24_cre_0_plac_rwa;
	private BigDecimal	r24_cre_0_cash_bal;
	private BigDecimal	r24_cre_0_cash_prov;
	private BigDecimal	r24_cre_0_cash_crm;
	private BigDecimal	r24_cre_0_cash_rwa;
	private BigDecimal	r24_cre_0_tot_bal;
	private BigDecimal	r24_cre_0_tot_prov;
	private BigDecimal	r24_cre_0_tot_int_sus;
	private BigDecimal	r24_cre_0_tot_crm;
	private BigDecimal	r24_cre_0_tot_rwa;
	private BigDecimal	r25_cre_20_loan_bal;
	private BigDecimal	r25_cre_20_loan_bill_amt;
	private BigDecimal	r25_cre_20_loan_tot_bal;
	private BigDecimal	r25_cre_20_loan_tot_prov;
	private BigDecimal	r25_cre_20_loan_int_sus;
	private BigDecimal	r25_cre_20_loan_crm;
	private BigDecimal	r25_cre_20_loan_tot_dra;
	private BigDecimal	r25_cre_20_inves_bal;
	private BigDecimal	r25_cre_20_inves_prov;
	private BigDecimal	r25_cre_20_inves_crm;
	private BigDecimal	r25_cre_20_inves_rwa;
	private BigDecimal	r25_cre_20_plac_bal;
	private BigDecimal	r25_cre_20_plac_prov;
	private BigDecimal	r25_cre_20_plac_crm;
	private BigDecimal	r25_cre_20_plac_rwa;
	private BigDecimal	r25_cre_20_cash_bal;
	private BigDecimal	r25_cre_20_cash_prov;
	private BigDecimal	r25_cre_20_cash_crm;
	private BigDecimal	r25_cre_20_cash_rwa;
	private BigDecimal	r25_cre_20_tot_bal;
	private BigDecimal	r25_cre_20_tot_prov;
	private BigDecimal	r25_cre_20_tot_int_sus;
	private BigDecimal	r25_cre_20_tot_crm;
	private BigDecimal	r25_cre_20_tot_rwa;
	private BigDecimal	r26_cre_50_loan_bal;
	private BigDecimal	r26_cre_50_loan_bill_amt;
	private BigDecimal	r26_cre_50_loan_tot_bal;
	private BigDecimal	r26_cre_50_loan_tot_prov;
	private BigDecimal	r26_cre_50_loan_int_sus;
	private BigDecimal	r26_cre_50_loan_crm;
	private BigDecimal	r26_cre_50_loan_tot_dra;
	private BigDecimal	r26_cre_50_inves_bal;
	private BigDecimal	r26_cre_50_inves_prov;
	private BigDecimal	r26_cre_50_inves_crm;
	private BigDecimal	r26_cre_50_inves_rwa;
	private BigDecimal	r26_cre_50_plac_bal;
	private BigDecimal	r26_cre_50_plac_prov;
	private BigDecimal	r26_cre_50_plac_crm;
	private BigDecimal	r26_cre_50_plac_rwa;
	private BigDecimal	r26_cre_50_cash_bal;
	private BigDecimal	r26_cre_50_cash_prov;
	private BigDecimal	r26_cre_50_cash_crm;
	private BigDecimal	r26_cre_50_cash_rwa;
	private BigDecimal	r26_cre_50_tot_bal;
	private BigDecimal	r26_cre_50_tot_prov;
	private BigDecimal	r26_cre_50_tot_int_sus;
	private BigDecimal	r26_cre_50_tot_crm;
	private BigDecimal	r26_cre_50_tot_rwa;
	private BigDecimal	r27_cre_100_loan_bal;
	private BigDecimal	r27_cre_100_loan_bill_amt;
	private BigDecimal	r27_cre_100_loan_tot_bal;
	private BigDecimal	r27_cre_100_loan_tot_prov;
	private BigDecimal	r27_cre_100_loan_int_sus;
	private BigDecimal	r27_cre_100_loan_crm;
	private BigDecimal	r27_cre_100_loan_tot_dra;
	private BigDecimal	r27_cre_100_inves_bal;
	private BigDecimal	r27_cre_100_inves_prov;
	private BigDecimal	r27_cre_100_inves_crm;
	private BigDecimal	r27_cre_100_inves_rwa;
	private BigDecimal	r27_cre_100_plac_bal;
	private BigDecimal	r27_cre_100_plac_prov;
	private BigDecimal	r27_cre_100_plac_crm;
	private BigDecimal	r27_cre_100_plac_rwa;
	private BigDecimal	r27_cre_100_cash_bal;
	private BigDecimal	r27_cre_100_cash_prov;
	private BigDecimal	r27_cre_100_cash_crm;
	private BigDecimal	r27_cre_100_cash_rwa;
	private BigDecimal	r27_cre_100_tot_bal;
	private BigDecimal	r27_cre_100_tot_prov;
	private BigDecimal	r27_cre_100_tot_int_sus;
	private BigDecimal	r27_cre_100_tot_crm;
	private BigDecimal	r27_cre_100_tot_rwa;
	private BigDecimal	r28_cre_150_loan_bal;
	private BigDecimal	r28_cre_150_loan_bill_amt;
	private BigDecimal	r28_cre_150_loan_tot_bal;
	private BigDecimal	r28_cre_150_loan_tot_prov;
	private BigDecimal	r28_cre_150_loan_int_sus;
	private BigDecimal	r28_cre_150_loan_crm;
	private BigDecimal	r28_cre_150_loan_tot_dra;
	private BigDecimal	r28_cre_150_inves_bal;
	private BigDecimal	r28_cre_150_inves_prov;
	private BigDecimal	r28_cre_150_inves_crm;
	private BigDecimal	r28_cre_150_inves_rwa;
	private BigDecimal	r28_cre_150_plac_bal;
	private BigDecimal	r28_cre_150_plac_prov;
	private BigDecimal	r28_cre_150_plac_crm;
	private BigDecimal	r28_cre_150_plac_rwa;
	private BigDecimal	r28_cre_150_cash_bal;
	private BigDecimal	r28_cre_150_cash_prov;
	private BigDecimal	r28_cre_150_cash_crm;
	private BigDecimal	r28_cre_150_cash_rwa;
	private BigDecimal	r28_cre_150_tot_bal;
	private BigDecimal	r28_cre_150_tot_prov;
	private BigDecimal	r28_cre_150_tot_int_sus;
	private BigDecimal	r28_cre_150_tot_crm;
	private BigDecimal	r28_cre_150_tot_rwa;
	private BigDecimal	r29_crt_0_loan_bal;
	private BigDecimal	r29_crt_0_loan_bill_amt;
	private BigDecimal	r29_crt_0_loan_tot_bal;
	private BigDecimal	r29_crt_0_loan_tot_prov;
	private BigDecimal	r29_crt_0_loan_int_sus;
	private BigDecimal	r29_crt_0_loan_crm;
	private BigDecimal	r29_crt_0_loan_tot_dra;
	private BigDecimal	r29_crt_0_inves_bal;
	private BigDecimal	r29_crt_0_inves_prov;
	private BigDecimal	r29_crt_0_inves_crm;
	private BigDecimal	r29_crt_0_inves_rwa;
	private BigDecimal	r29_crt_0_plac_bal;
	private BigDecimal	r29_crt_0_plac_prov;
	private BigDecimal	r29_crt_0_plac_crm;
	private BigDecimal	r29_crt_0_plac_rwa;
	private BigDecimal	r29_crt_0_cash_bal;
	private BigDecimal	r29_crt_0_cash_prov;
	private BigDecimal	r29_crt_0_cash_crm;
	private BigDecimal	r29_crt_0_cash_rwa;
	private BigDecimal	r29_crt_0_tot_bal;
	private BigDecimal	r29_crt_0_tot_prov;
	private BigDecimal	r29_crt_0_tot_int_sus;
	private BigDecimal	r29_crt_0_tot_crm;
	private BigDecimal	r29_crt_0_tot_rwa;
	private BigDecimal	r30_crt_20_loan_bal;
	private BigDecimal	r30_crt_20_loan_bill_amt;
	private BigDecimal	r30_crt_20_loan_tot_bal;
	private BigDecimal	r30_crt_20_loan_tot_prov;
	private BigDecimal	r30_crt_20_loan_int_sus;
	private BigDecimal	r30_crt_20_loan_crm;
	private BigDecimal	r30_crt_20_loan_tot_dra;
	private BigDecimal	r30_crt_20_inves_bal;
	private BigDecimal	r30_crt_20_inves_prov;
	private BigDecimal	r30_crt_20_inves_crm;
	private BigDecimal	r30_crt_20_inves_rwa;
	private BigDecimal	r30_crt_20_plac_bal;
	private BigDecimal	r30_crt_20_plac_prov;
	private BigDecimal	r30_crt_20_plac_crm;
	private BigDecimal	r30_crt_20_plac_rwa;
	private BigDecimal	r30_crt_20_cash_bal;
	private BigDecimal	r30_crt_20_cash_prov;
	private BigDecimal	r30_crt_20_cash_crm;
	private BigDecimal	r30_crt_20_cash_rwa;
	private BigDecimal	r30_crt_20_tot_bal;
	private BigDecimal	r30_crt_20_tot_prov;
	private BigDecimal	r30_crt_20_tot_int_sus;
	private BigDecimal	r30_crt_20_tot_crm;
	private BigDecimal	r30_crt_20_tot_rwa;
	private BigDecimal	r31_crt_50_loan_bal;
	private BigDecimal	r31_crt_50_loan_bill_amt;
	private BigDecimal	r31_crt_50_loan_tot_bal;
	private BigDecimal	r31_crt_50_loan_tot_prov;
	private BigDecimal	r31_crt_50_loan_int_sus;
	private BigDecimal	r31_crt_50_loan_crm;
	private BigDecimal	r31_crt_50_loan_tot_dra;
	private BigDecimal	r31_crt_50_inves_bal;
	private BigDecimal	r31_crt_50_inves_prov;
	private BigDecimal	r31_crt_50_inves_crm;
	private BigDecimal	r31_crt_50_inves_rwa;
	private BigDecimal	r31_crt_50_plac_bal;
	private BigDecimal	r31_crt_50_plac_prov;
	private BigDecimal	r31_crt_50_plac_crm;
	private BigDecimal	r31_crt_50_plac_rwa;
	private BigDecimal	r31_crt_50_cash_bal;
	private BigDecimal	r31_crt_50_cash_prov;
	private BigDecimal	r31_crt_50_cash_crm;
	private BigDecimal	r31_crt_50_cash_rwa;
	private BigDecimal	r31_crt_50_tot_bal;
	private BigDecimal	r31_crt_50_tot_prov;
	private BigDecimal	r31_crt_50_tot_int_sus;
	private BigDecimal	r31_crt_50_tot_crm;
	private BigDecimal	r31_crt_50_tot_rwa;
	private BigDecimal	r32_crt_100_loan_bal;
	private BigDecimal	r32_crt_100_loan_bill_amt;
	private BigDecimal	r32_crt_100_loan_tot_bal;
	private BigDecimal	r32_crt_100_loan_tot_prov;
	private BigDecimal	r32_crt_100_loan_int_sus;
	private BigDecimal	r32_crt_100_loan_crm;
	private BigDecimal	r32_crt_100_loan_tot_dra;
	private BigDecimal	r32_crt_100_inves_bal;
	private BigDecimal	r32_crt_100_inves_prov;
	private BigDecimal	r32_crt_100_inves_crm;
	private BigDecimal	r32_crt_100_inves_rwa;
	private BigDecimal	r32_crt_100_plac_bal;
	private BigDecimal	r32_crt_100_plac_prov;
	private BigDecimal	r32_crt_100_plac_crm;
	private BigDecimal	r32_crt_100_plac_rwa;
	private BigDecimal	r32_crt_100_cash_bal;
	private BigDecimal	r32_crt_100_cash_prov;
	private BigDecimal	r32_crt_100_cash_crm;
	private BigDecimal	r32_crt_100_cash_rwa;
	private BigDecimal	r32_crt_100_tot_bal;
	private BigDecimal	r32_crt_100_tot_prov;
	private BigDecimal	r32_crt_100_tot_int_sus;
	private BigDecimal	r32_crt_100_tot_crm;
	private BigDecimal	r32_crt_100_tot_rwa;
	private BigDecimal	r33_crt_150_loan_bal;
	private BigDecimal	r33_crt_150_loan_bill_amt;
	private BigDecimal	r33_crt_150_loan_tot_bal;
	private BigDecimal	r33_crt_150_loan_tot_prov;
	private BigDecimal	r33_crt_150_loan_int_sus;
	private BigDecimal	r33_crt_150_loan_crm;
	private BigDecimal	r33_crt_150_loan_tot_dra;
	private BigDecimal	r33_crt_150_inves_bal;
	private BigDecimal	r33_crt_150_inves_prov;
	private BigDecimal	r33_crt_150_inves_crm;
	private BigDecimal	r33_crt_150_inves_rwa;
	private BigDecimal	r33_crt_150_plac_bal;
	private BigDecimal	r33_crt_150_plac_prov;
	private BigDecimal	r33_crt_150_plac_crm;
	private BigDecimal	r33_crt_150_plac_rwa;
	private BigDecimal	r33_crt_150_cash_bal;
	private BigDecimal	r33_crt_150_cash_prov;
	private BigDecimal	r33_crt_150_cash_crm;
	private BigDecimal	r33_crt_150_cash_rwa;
	private BigDecimal	r33_crt_150_tot_bal;
	private BigDecimal	r33_crt_150_tot_prov;
	private BigDecimal	r33_crt_150_tot_int_sus;
	private BigDecimal	r33_crt_150_tot_crm;
	private BigDecimal	r33_crt_150_tot_rwa;
	private BigDecimal	r34_hni_100_loan_bal;
	private BigDecimal	r34_hni_100_loan_bill_amt;
	private BigDecimal	r34_hni_100_loan_tot_bal;
	private BigDecimal	r34_hni_100_loan_tot_prov;
	private BigDecimal	r34_hni_100_loan_int_sus;
	private BigDecimal	r34_hni_100_loan_crm;
	private BigDecimal	r34_hni_100_loan_tot_dra;
	private BigDecimal	r34_hni_100_inves_bal;
	private BigDecimal	r34_hni_100_inves_prov;
	private BigDecimal	r34_hni_100_inves_crm;
	private BigDecimal	r34_hni_100_inves_rwa;
	private BigDecimal	r34_hni_100_plac_bal;
	private BigDecimal	r34_hni_100_plac_prov;
	private BigDecimal	r34_hni_100_plac_crm;
	private BigDecimal	r34_hni_100_plac_rwa;
	private BigDecimal	r34_hni_100_cash_bal;
	private BigDecimal	r34_hni_100_cash_prov;
	private BigDecimal	r34_hni_100_cash_crm;
	private BigDecimal	r34_hni_100_cash_rwa;
	private BigDecimal	r34_hni_100_tot_bal;
	private BigDecimal	r34_hni_100_tot_prov;
	private BigDecimal	r34_hni_100_tot_int_sus;
	private BigDecimal	r34_hni_100_tot_crm;
	private BigDecimal	r34_hni_100_tot_rwa;
	private BigDecimal	r35_pdl_100_loan_bal;
	private BigDecimal	r35_pdl_100_loan_bill_amt;
	private BigDecimal	r35_pdl_100_loan_tot_bal;
	private BigDecimal	r35_pdl_100_loan_tot_prov;
	private BigDecimal	r35_pdl_100_loan_int_sus;
	private BigDecimal	r35_pdl_100_loan_crm;
	private BigDecimal	r35_pdl_100_loan_tot_dra;
	private BigDecimal	r35_pdl_100_inves_bal;
	private BigDecimal	r35_pdl_100_inves_prov;
	private BigDecimal	r35_pdl_100_inves_crm;
	private BigDecimal	r35_pdl_100_inves_rwa;
	private BigDecimal	r35_pdl_100_plac_bal;
	private BigDecimal	r35_pdl_100_plac_prov;
	private BigDecimal	r35_pdl_100_plac_crm;
	private BigDecimal	r35_pdl_100_plac_rwa;
	private BigDecimal	r35_pdl_100_cash_bal;
	private BigDecimal	r35_pdl_100_cash_prov;
	private BigDecimal	r35_pdl_100_cash_crm;
	private BigDecimal	r35_pdl_100_cash_rwa;
	private BigDecimal	r35_pdl_100_tot_bal;
	private BigDecimal	r35_pdl_100_tot_prov;
	private BigDecimal	r35_pdl_100_tot_int_sus;
	private BigDecimal	r35_pdl_100_tot_crm;
	private BigDecimal	r35_pdl_100_tot_rwa;
	private BigDecimal	r36_pdl_150_loan_bal;
	private BigDecimal	r36_pdl_150_loan_bill_amt;
	private BigDecimal	r36_pdl_150_loan_tot_bal;
	private BigDecimal	r36_pdl_150_loan_tot_prov;
	private BigDecimal	r36_pdl_150_loan_int_sus;
	private BigDecimal	r36_pdl_150_loan_crm;
	private BigDecimal	r36_pdl_150_loan_tot_dra;
	private BigDecimal	r36_pdl_150_inves_bal;
	private BigDecimal	r36_pdl_150_inves_prov;
	private BigDecimal	r36_pdl_150_inves_crm;
	private BigDecimal	r36_pdl_150_inves_rwa;
	private BigDecimal	r36_pdl_150_plac_bal;
	private BigDecimal	r36_pdl_150_plac_prov;
	private BigDecimal	r36_pdl_150_plac_crm;
	private BigDecimal	r36_pdl_150_plac_rwa;
	private BigDecimal	r36_pdl_150_cash_bal;
	private BigDecimal	r36_pdl_150_cash_prov;
	private BigDecimal	r36_pdl_150_cash_crm;
	private BigDecimal	r36_pdl_150_cash_rwa;
	private BigDecimal	r36_pdl_150_tot_bal;
	private BigDecimal	r36_pdl_150_tot_prov;
	private BigDecimal	r36_pdl_150_tot_int_sus;
	private BigDecimal	r36_pdl_150_tot_crm;
	private BigDecimal	r36_pdl_150_tot_rwa;
	private BigDecimal	r37_pse_0_loan_bal;
	private BigDecimal	r37_pse_0_loan_bill_amt;
	private BigDecimal	r37_pse_0_loan_tot_bal;
	private BigDecimal	r37_pse_0_loan_tot_prov;
	private BigDecimal	r37_pse_0_loan_int_sus;
	private BigDecimal	r37_pse_0_loan_crm;
	private BigDecimal	r37_pse_0_loan_tot_dra;
	private BigDecimal	r37_pse_0_inves_bal;
	private BigDecimal	r37_pse_0_inves_prov;
	private BigDecimal	r37_pse_0_inves_crm;
	private BigDecimal	r37_pse_0_inves_rwa;
	private BigDecimal	r37_pse_0_plac_bal;
	private BigDecimal	r37_pse_0_plac_prov;
	private BigDecimal	r37_pse_0_plac_crm;
	private BigDecimal	r37_pse_0_plac_rwa;
	private BigDecimal	r37_pse_0_cash_bal;
	private BigDecimal	r37_pse_0_cash_prov;
	private BigDecimal	r37_pse_0_cash_crm;
	private BigDecimal	r37_pse_0_cash_rwa;
	private BigDecimal	r37_pse_0_tot_bal;
	private BigDecimal	r37_pse_0_tot_prov;
	private BigDecimal	r37_pse_0_tot_int_sus;
	private BigDecimal	r37_pse_0_tot_crm;
	private BigDecimal	r37_pse_0_tot_rwa;
	private BigDecimal	r38_pse_20_loan_bal;
	private BigDecimal	r38_pse_20_loan_bill_amt;
	private BigDecimal	r38_pse_20_loan_tot_bal;
	private BigDecimal	r38_pse_20_loan_tot_prov;
	private BigDecimal	r38_pse_20_loan_int_sus;
	private BigDecimal	r38_pse_20_loan_crm;
	private BigDecimal	r38_pse_20_loan_tot_dra;
	private BigDecimal	r38_pse_20_inves_bal;
	private BigDecimal	r38_pse_20_inves_prov;
	private BigDecimal	r38_pse_20_inves_crm;
	private BigDecimal	r38_pse_20_inves_rwa;
	private BigDecimal	r38_pse_20_plac_bal;
	private BigDecimal	r38_pse_20_plac_prov;
	private BigDecimal	r38_pse_20_plac_crm;
	private BigDecimal	r38_pse_20_plac_rwa;
	private BigDecimal	r38_pse_20_cash_bal;
	private BigDecimal	r38_pse_20_cash_prov;
	private BigDecimal	r38_pse_20_cash_crm;
	private BigDecimal	r38_pse_20_cash_rwa;
	private BigDecimal	r38_pse_20_tot_bal;
	private BigDecimal	r38_pse_20_tot_prov;
	private BigDecimal	r38_pse_20_tot_int_sus;
	private BigDecimal	r38_pse_20_tot_crm;
	private BigDecimal	r38_pse_20_tot_rwa;
	private BigDecimal	r39_pse_50_loan_bal;
	private BigDecimal	r39_pse_50_loan_bill_amt;
	private BigDecimal	r39_pse_50_loan_tot_bal;
	private BigDecimal	r39_pse_50_loan_tot_prov;
	private BigDecimal	r39_pse_50_loan_int_sus;
	private BigDecimal	r39_pse_50_loan_crm;
	private BigDecimal	r39_pse_50_loan_tot_dra;
	private BigDecimal	r39_pse_50_inves_bal;
	private BigDecimal	r39_pse_50_inves_prov;
	private BigDecimal	r39_pse_50_inves_crm;
	private BigDecimal	r39_pse_50_inves_rwa;
	private BigDecimal	r39_pse_50_plac_bal;
	private BigDecimal	r39_pse_50_plac_prov;
	private BigDecimal	r39_pse_50_plac_crm;
	private BigDecimal	r39_pse_50_plac_rwa;
	private BigDecimal	r39_pse_50_cash_bal;
	private BigDecimal	r39_pse_50_cash_prov;
	private BigDecimal	r39_pse_50_cash_crm;
	private BigDecimal	r39_pse_50_cash_rwa;
	private BigDecimal	r39_pse_50_tot_bal;
	private BigDecimal	r39_pse_50_tot_prov;
	private BigDecimal	r39_pse_50_tot_int_sus;
	private BigDecimal	r39_pse_50_tot_crm;
	private BigDecimal	r39_pse_50_tot_rwa;
	private BigDecimal	r40_pse_100_loan_bal;
	private BigDecimal	r40_pse_100_loan_bill_amt;
	private BigDecimal	r40_pse_100_loan_tot_bal;
	private BigDecimal	r40_pse_100_loan_tot_prov;
	private BigDecimal	r40_pse_100_loan_int_sus;
	private BigDecimal	r40_pse_100_loan_crm;
	private BigDecimal	r40_pse_100_loan_tot_dra;
	private BigDecimal	r40_pse_100_inves_bal;
	private BigDecimal	r40_pse_100_inves_prov;
	private BigDecimal	r40_pse_100_inves_crm;
	private BigDecimal	r40_pse_100_inves_rwa;
	private BigDecimal	r40_pse_100_plac_bal;
	private BigDecimal	r40_pse_100_plac_prov;
	private BigDecimal	r40_pse_100_plac_crm;
	private BigDecimal	r40_pse_100_plac_rwa;
	private BigDecimal	r40_pse_100_cash_bal;
	private BigDecimal	r40_pse_100_cash_prov;
	private BigDecimal	r40_pse_100_cash_crm;
	private BigDecimal	r40_pse_100_cash_rwa;
	private BigDecimal	r40_pse_100_tot_bal;
	private BigDecimal	r40_pse_100_tot_prov;
	private BigDecimal	r40_pse_100_tot_int_sus;
	private BigDecimal	r40_pse_100_tot_crm;
	private BigDecimal	r40_pse_100_tot_rwa;
	private BigDecimal	r41_pse_150_loan_bal;
	private BigDecimal	r41_pse_150_loan_bill_amt;
	private BigDecimal	r41_pse_150_loan_tot_bal;
	private BigDecimal	r41_pse_150_loan_tot_prov;
	private BigDecimal	r41_pse_150_loan_int_sus;
	private BigDecimal	r41_pse_150_loan_crm;
	private BigDecimal	r41_pse_150_loan_tot_dra;
	private BigDecimal	r41_pse_150_inves_bal;
	private BigDecimal	r41_pse_150_inves_prov;
	private BigDecimal	r41_pse_150_inves_crm;
	private BigDecimal	r41_pse_150_inves_rwa;
	private BigDecimal	r41_pse_150_plac_bal;
	private BigDecimal	r41_pse_150_plac_prov;
	private BigDecimal	r41_pse_150_plac_crm;
	private BigDecimal	r41_pse_150_plac_rwa;
	private BigDecimal	r41_pse_150_cash_bal;
	private BigDecimal	r41_pse_150_cash_prov;
	private BigDecimal	r41_pse_150_cash_crm;
	private BigDecimal	r41_pse_150_cash_rwa;
	private BigDecimal	r41_pse_150_tot_bal;
	private BigDecimal	r41_pse_150_tot_prov;
	private BigDecimal	r41_pse_150_tot_int_sus;
	private BigDecimal	r41_pse_150_tot_crm;
	private BigDecimal	r41_pse_150_tot_rwa;
	private BigDecimal	r42_res_35_loan_bal;
	private BigDecimal	r42_res_35_loan_bill_amt;
	private BigDecimal	r42_res_35_loan_tot_bal;
	private BigDecimal	r42_res_35_loan_tot_prov;
	private BigDecimal	r42_res_35_loan_int_sus;
	private BigDecimal	r42_res_35_loan_crm;
	private BigDecimal	r42_res_35_loan_tot_dra;
	private BigDecimal	r42_res_35_inves_bal;
	private BigDecimal	r42_res_35_inves_prov;
	private BigDecimal	r42_res_35_inves_crm;
	private BigDecimal	r42_res_35_inves_rwa;
	private BigDecimal	r42_res_35_plac_bal;
	private BigDecimal	r42_res_35_plac_prov;
	private BigDecimal	r42_res_35_plac_crm;
	private BigDecimal	r42_res_35_plac_rwa;
	private BigDecimal	r42_res_35_cash_bal;
	private BigDecimal	r42_res_35_cash_prov;
	private BigDecimal	r42_res_35_cash_crm;
	private BigDecimal	r42_res_35_cash_rwa;
	private BigDecimal	r42_res_35_tot_bal;
	private BigDecimal	r42_res_35_tot_prov;
	private BigDecimal	r42_res_35_tot_int_sus;
	private BigDecimal	r42_res_35_tot_crm;
	private BigDecimal	r42_res_35_tot_rwa;
	private BigDecimal	r43_res_100_loan_bal;
	private BigDecimal	r43_res_100_loan_bill_amt;
	private BigDecimal	r43_res_100_loan_tot_bal;
	private BigDecimal	r43_res_100_loan_tot_prov;
	private BigDecimal	r43_res_100_loan_int_sus;
	private BigDecimal	r43_res_100_loan_crm;
	private BigDecimal	r43_res_100_loan_tot_dra;
	private BigDecimal	r43_res_100_inves_bal;
	private BigDecimal	r43_res_100_inves_prov;
	private BigDecimal	r43_res_100_inves_crm;
	private BigDecimal	r43_res_100_inves_rwa;
	private BigDecimal	r43_res_100_plac_bal;
	private BigDecimal	r43_res_100_plac_prov;
	private BigDecimal	r43_res_100_plac_crm;
	private BigDecimal	r43_res_100_plac_rwa;
	private BigDecimal	r43_res_100_cash_bal;
	private BigDecimal	r43_res_100_cash_prov;
	private BigDecimal	r43_res_100_cash_crm;
	private BigDecimal	r43_res_100_cash_rwa;
	private BigDecimal	r43_res_100_tot_bal;
	private BigDecimal	r43_res_100_tot_prov;
	private BigDecimal	r43_res_100_tot_int_sus;
	private BigDecimal	r43_res_100_tot_crm;
	private BigDecimal	r43_res_100_tot_rwa;
	private BigDecimal	r44_res_75_loan_bal;
	private BigDecimal	r44_res_75_loan_bill_amt;
	private BigDecimal	r44_res_75_loan_tot_bal;
	private BigDecimal	r44_res_75_loan_tot_prov;
	private BigDecimal	r44_res_75_loan_int_sus;
	private BigDecimal	r44_res_75_loan_crm;
	private BigDecimal	r44_res_75_loan_tot_dra;
	private BigDecimal	r44_res_75_inves_bal;
	private BigDecimal	r44_res_75_inves_prov;
	private BigDecimal	r44_res_75_inves_crm;
	private BigDecimal	r44_res_75_inves_rwa;
	private BigDecimal	r44_res_75_plac_bal;
	private BigDecimal	r44_res_75_plac_prov;
	private BigDecimal	r44_res_75_plac_crm;
	private BigDecimal	r44_res_75_plac_rwa;
	private BigDecimal	r44_res_75_cash_bal;
	private BigDecimal	r44_res_75_cash_prov;
	private BigDecimal	r44_res_75_cash_crm;
	private BigDecimal	r44_res_75_cash_rwa;
	private BigDecimal	r44_res_75_tot_bal;
	private BigDecimal	r44_res_75_tot_prov;
	private BigDecimal	r44_res_75_tot_int_sus;
	private BigDecimal	r44_res_75_tot_crm;
	private BigDecimal	r44_res_75_tot_rwa;
	private BigDecimal r45_res_100_loan_bal;
	private BigDecimal	r45_res_100_loan_bill_amt;
	private BigDecimal	r45_res_100_loan_tot_bal;
	private BigDecimal	r45_res_100_loan_tot_prov;
	private BigDecimal	r45_res_100_loan_int_sus;
	private BigDecimal	r45_res_100_loan_crm;
	private BigDecimal	r45_res_100_loan_tot_dra;
	private BigDecimal	r45_res_100_inves_bal;
	private BigDecimal	r45_res_100_inves_prov;
	private BigDecimal	r45_res_100_inves_crm;
	private BigDecimal	r45_res_100_inves_rwa;
	private BigDecimal	r45_res_100_plac_bal;
	private BigDecimal	r45_res_100_plac_prov;
	private BigDecimal	r45_res_100_plac_crm;
	private BigDecimal	r45_res_100_plac_rwa;
	private BigDecimal	r45_res_100_cash_bal;
	private BigDecimal	r45_res_100_cash_prov;
	private BigDecimal	r45_res_100_cash_crm;
	private BigDecimal	r45_res_100_cash_rwa;
	private BigDecimal	r45_res_100_tot_bal;
	private BigDecimal	r45_res_100_tot_prov;
	private BigDecimal	r45_res_100_tot_int_sus;
	private BigDecimal	r45_res_100_tot_crm;
	private BigDecimal	r45_res_100_tot_rwa;
	private BigDecimal	r46_res_75_loan_bal;
	private BigDecimal	r46_res_75_loan_bill_amt;
	private BigDecimal	r46_res_75_loan_tot_bal;
	private BigDecimal	r46_res_75_loan_tot_prov;
	private BigDecimal	r46_res_75_loan_int_sus;
	private BigDecimal	r46_res_75_loan_crm;
	private BigDecimal	r46_res_75_loan_tot_dra;
	private BigDecimal	r46_res_75_inves_bal;
	private BigDecimal	r46_res_75_inves_prov;
	private BigDecimal	r46_res_75_inves_crm;
	private BigDecimal	r46_res_75_inves_rwa;
	private BigDecimal	r46_res_75_plac_bal;
	private BigDecimal	r46_res_75_plac_prov;
	private BigDecimal	r46_res_75_plac_crm;
	private BigDecimal	r46_res_75_plac_rwa;
	private BigDecimal	r46_res_75_cash_bal;
	private BigDecimal	r46_res_75_cash_prov;
	private BigDecimal	r46_res_75_cash_crm;
	private BigDecimal	r46_res_75_cash_rwa;
	private BigDecimal	r46_res_75_tot_bal;
	private BigDecimal	r46_res_75_tot_prov;
	private BigDecimal	r46_res_75_tot_int_sus;
	private BigDecimal	r46_res_75_tot_crm;
	private BigDecimal	r46_res_75_tot_rwa;
	private BigDecimal	r47_res_85_loan_bal;
	private BigDecimal	r47_res_85_loan_bill_amt;
	private BigDecimal	r47_res_85_loan_tot_bal;
	private BigDecimal	r47_res_85_loan_tot_prov;
	private BigDecimal	r47_res_85_loan_int_sus;
	private BigDecimal	r47_res_85_loan_crm;
	private BigDecimal	r47_res_85_loan_tot_dra;
	private BigDecimal	r47_res_85_inves_bal;
	private BigDecimal	r47_res_85_inves_prov;
	private BigDecimal	r47_res_85_inves_crm;
	private BigDecimal	r47_res_85_inves_rwa;
	private BigDecimal	r47_res_85_plac_bal;
	private BigDecimal	r47_res_85_plac_prov;
	private BigDecimal	r47_res_85_plac_crm;
	private BigDecimal	r47_res_85_plac_rwa;
	private BigDecimal	r47_res_85_cash_bal;
	private BigDecimal	r47_res_85_cash_prov;
	private BigDecimal	r47_res_85_cash_crm;
	private BigDecimal	r47_res_85_cash_rwa;
	private BigDecimal	r47_res_85_tot_bal;
	private BigDecimal	r47_res_85_tot_prov;
	private BigDecimal	r47_res_85_tot_int_sus;
	private BigDecimal	r47_res_85_tot_crm;
	private BigDecimal	r47_res_85_tot_rwa;
	private BigDecimal	r48_res_0_loan_bal;
	private BigDecimal	r48_res_0_loan_bill_amt;
	private BigDecimal	r48_res_0_loan_tot_bal;
	private BigDecimal	r48_res_0_loan_tot_prov;
	private BigDecimal	r48_res_0_loan_int_sus;
	private BigDecimal	r48_res_0_loan_crm;
	private BigDecimal	r48_res_0_loan_tot_dra;
	private BigDecimal	r48_res_0_inves_bal;
	private BigDecimal	r48_res_0_inves_prov;
	private BigDecimal	r48_res_0_inves_crm;
	private BigDecimal	r48_res_0_inves_rwa;
	private BigDecimal	r48_res_0_plac_bal;
	private BigDecimal	r48_res_0_plac_prov;
	private BigDecimal	r48_res_0_plac_crm;
	private BigDecimal	r48_res_0_plac_rwa;
	private BigDecimal	r48_res_0_cash_bal;
	private BigDecimal	r48_res_0_cash_prov;
	private BigDecimal	r48_res_0_cash_crm;
	private BigDecimal	r48_res_0_cash_rwa;
	private BigDecimal	r48_res_0_tot_bal;
	private BigDecimal	r48_res_0_tot_prov;
	private BigDecimal	r48_res_0_tot_int_sus;
	private BigDecimal	r48_res_0_tot_crm;
	private BigDecimal	r48_res_0_tot_rwa;
	private BigDecimal	r49_res_100_loan_bal;
	private BigDecimal	r49_res_100_loan_bill_amt;
	private BigDecimal	r49_res_100_loan_tot_bal;
	private BigDecimal	r49_res_100_loan_tot_prov;
	private BigDecimal	r49_res_100_loan_int_sus;
	private BigDecimal	r49_res_100_loan_crm;
	private BigDecimal	r49_res_100_loan_tot_dra;
	private BigDecimal	r49_res_100_inves_bal;
	private BigDecimal	r49_res_100_inves_prov;
	private BigDecimal	r49_res_100_inves_crm;
	private BigDecimal	r49_res_100_inves_rwa;
	private BigDecimal	r49_res_100_plac_bal;
	private BigDecimal	r49_res_100_plac_prov;
	private BigDecimal	r49_res_100_plac_crm;
	private BigDecimal	r49_res_100_plac_rwa;
	private BigDecimal	r49_res_100_cash_bal;
	private BigDecimal	r49_res_100_cash_prov;
	private BigDecimal	r49_res_100_cash_crm;
	private BigDecimal	r49_res_100_cash_rwa;
	private BigDecimal	r49_res_100_tot_bal;
	private BigDecimal	r49_res_100_tot_prov;
	private BigDecimal	r49_res_100_tot_int_sus;
	private BigDecimal	r49_res_100_tot_crm;
	private BigDecimal	r49_res_100_tot_rwa;
	private BigDecimal	r50_res_250_loan_bal;
	private BigDecimal	r50_res_250_loan_bill_amt;
	private BigDecimal	r50_res_250_loan_tot_bal;
	private BigDecimal	r50_res_250_loan_tot_prov;
	private BigDecimal	r50_res_250_loan_int_sus;
	private BigDecimal	r50_res_250_loan_crm;
	private BigDecimal	r50_res_250_loan_tot_dra;
	private BigDecimal	r50_res_250_inves_bal;
	private BigDecimal	r50_res_250_inves_prov;
	private BigDecimal	r50_res_250_inves_crm;
	private BigDecimal	r50_res_250_inves_rwa;
	private BigDecimal	r50_res_250_plac_bal;
	private BigDecimal	r50_res_250_plac_prov;
	private BigDecimal	r50_res_250_plac_crm;
	private BigDecimal	r50_res_250_plac_rwa;
	private BigDecimal	r50_res_250_cash_bal;
	private BigDecimal	r50_res_250_cash_prov;
	private BigDecimal	r50_res_250_cash_crm;
	private BigDecimal	r50_res_250_cash_rwa;
	private BigDecimal	r50_res_250_tot_bal;
	private BigDecimal	r50_res_250_tot_prov;
	private BigDecimal	r50_res_250_tot_int_sus;
	private BigDecimal	r50_res_250_tot_crm;
	private BigDecimal	r50_res_250_tot_rwa;
	private BigDecimal	r51_res_100_loan_bal;
	private BigDecimal	r51_res_100_loan_bill_amt;
	private BigDecimal	r51_res_100_loan_tot_bal;
	private BigDecimal	r51_res_100_loan_tot_prov;
	private BigDecimal	r51_res_100_loan_int_sus;
	private BigDecimal	r51_res_100_loan_crm;
	private BigDecimal	r51_res_100_loan_tot_dra;
	private BigDecimal	r51_res_100_inves_bal;
	private BigDecimal	r51_res_100_inves_prov;
	private BigDecimal	r51_res_100_inves_crm;
	private BigDecimal	r51_res_100_inves_rwa;
	private BigDecimal	r51_res_100_plac_bal;
	private BigDecimal	r51_res_100_plac_prov;
	private BigDecimal	r51_res_100_plac_crm;
	private BigDecimal	r51_res_100_plac_rwa;
	private BigDecimal	r51_res_100_cash_bal;
	private BigDecimal	r51_res_100_cash_prov;
	private BigDecimal	r51_res_100_cash_crm;
	private BigDecimal	r51_res_100_cash_rwa;
	private BigDecimal	r51_res_100_tot_bal;
	private BigDecimal	r51_res_100_tot_prov;
	private BigDecimal	r51_res_100_tot_int_sus;
	private BigDecimal	r51_res_100_tot_crm;
	private BigDecimal	r51_res_100_tot_rwa;

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
	public BigDecimal getR24_cre_0_loan_bal() {
		return r24_cre_0_loan_bal;
	}
	public void setR24_cre_0_loan_bal(BigDecimal r24_cre_0_loan_bal) {
		this.r24_cre_0_loan_bal = r24_cre_0_loan_bal;
	}
	public BigDecimal getR24_cre_0_loan_bill_amt() {
		return r24_cre_0_loan_bill_amt;
	}
	public void setR24_cre_0_loan_bill_amt(BigDecimal r24_cre_0_loan_bill_amt) {
		this.r24_cre_0_loan_bill_amt = r24_cre_0_loan_bill_amt;
	}
	public BigDecimal getR24_cre_0_loan_tot_bal() {
		return r24_cre_0_loan_tot_bal;
	}
	public void setR24_cre_0_loan_tot_bal(BigDecimal r24_cre_0_loan_tot_bal) {
		this.r24_cre_0_loan_tot_bal = r24_cre_0_loan_tot_bal;
	}
	public BigDecimal getR24_cre_0_loan_tot_prov() {
		return r24_cre_0_loan_tot_prov;
	}
	public void setR24_cre_0_loan_tot_prov(BigDecimal r24_cre_0_loan_tot_prov) {
		this.r24_cre_0_loan_tot_prov = r24_cre_0_loan_tot_prov;
	}
	public BigDecimal getR24_cre_0_loan_int_sus() {
		return r24_cre_0_loan_int_sus;
	}
	public void setR24_cre_0_loan_int_sus(BigDecimal r24_cre_0_loan_int_sus) {
		this.r24_cre_0_loan_int_sus = r24_cre_0_loan_int_sus;
	}
	public BigDecimal getR24_cre_0_loan_crm() {
		return r24_cre_0_loan_crm;
	}
	public void setR24_cre_0_loan_crm(BigDecimal r24_cre_0_loan_crm) {
		this.r24_cre_0_loan_crm = r24_cre_0_loan_crm;
	}
	public BigDecimal getR24_cre_0_loan_tot_dra() {
		return r24_cre_0_loan_tot_dra;
	}
	public void setR24_cre_0_loan_tot_dra(BigDecimal r24_cre_0_loan_tot_dra) {
		this.r24_cre_0_loan_tot_dra = r24_cre_0_loan_tot_dra;
	}
	public BigDecimal getR24_cre_0_inves_bal() {
		return r24_cre_0_inves_bal;
	}
	public void setR24_cre_0_inves_bal(BigDecimal r24_cre_0_inves_bal) {
		this.r24_cre_0_inves_bal = r24_cre_0_inves_bal;
	}
	public BigDecimal getR24_cre_0_inves_prov() {
		return r24_cre_0_inves_prov;
	}
	public void setR24_cre_0_inves_prov(BigDecimal r24_cre_0_inves_prov) {
		this.r24_cre_0_inves_prov = r24_cre_0_inves_prov;
	}
	public BigDecimal getR24_cre_0_inves_crm() {
		return r24_cre_0_inves_crm;
	}
	public void setR24_cre_0_inves_crm(BigDecimal r24_cre_0_inves_crm) {
		this.r24_cre_0_inves_crm = r24_cre_0_inves_crm;
	}
	public BigDecimal getR24_cre_0_inves_rwa() {
		return r24_cre_0_inves_rwa;
	}
	public void setR24_cre_0_inves_rwa(BigDecimal r24_cre_0_inves_rwa) {
		this.r24_cre_0_inves_rwa = r24_cre_0_inves_rwa;
	}
	public BigDecimal getR24_cre_0_plac_bal() {
		return r24_cre_0_plac_bal;
	}
	public void setR24_cre_0_plac_bal(BigDecimal r24_cre_0_plac_bal) {
		this.r24_cre_0_plac_bal = r24_cre_0_plac_bal;
	}
	public BigDecimal getR24_cre_0_plac_prov() {
		return r24_cre_0_plac_prov;
	}
	public void setR24_cre_0_plac_prov(BigDecimal r24_cre_0_plac_prov) {
		this.r24_cre_0_plac_prov = r24_cre_0_plac_prov;
	}
	public BigDecimal getR24_cre_0_plac_crm() {
		return r24_cre_0_plac_crm;
	}
	public void setR24_cre_0_plac_crm(BigDecimal r24_cre_0_plac_crm) {
		this.r24_cre_0_plac_crm = r24_cre_0_plac_crm;
	}
	public BigDecimal getR24_cre_0_plac_rwa() {
		return r24_cre_0_plac_rwa;
	}
	public void setR24_cre_0_plac_rwa(BigDecimal r24_cre_0_plac_rwa) {
		this.r24_cre_0_plac_rwa = r24_cre_0_plac_rwa;
	}
	public BigDecimal getR24_cre_0_cash_bal() {
		return r24_cre_0_cash_bal;
	}
	public void setR24_cre_0_cash_bal(BigDecimal r24_cre_0_cash_bal) {
		this.r24_cre_0_cash_bal = r24_cre_0_cash_bal;
	}
	public BigDecimal getR24_cre_0_cash_prov() {
		return r24_cre_0_cash_prov;
	}
	public void setR24_cre_0_cash_prov(BigDecimal r24_cre_0_cash_prov) {
		this.r24_cre_0_cash_prov = r24_cre_0_cash_prov;
	}
	public BigDecimal getR24_cre_0_cash_crm() {
		return r24_cre_0_cash_crm;
	}
	public void setR24_cre_0_cash_crm(BigDecimal r24_cre_0_cash_crm) {
		this.r24_cre_0_cash_crm = r24_cre_0_cash_crm;
	}
	public BigDecimal getR24_cre_0_cash_rwa() {
		return r24_cre_0_cash_rwa;
	}
	public void setR24_cre_0_cash_rwa(BigDecimal r24_cre_0_cash_rwa) {
		this.r24_cre_0_cash_rwa = r24_cre_0_cash_rwa;
	}
	public BigDecimal getR24_cre_0_tot_bal() {
		return r24_cre_0_tot_bal;
	}
	public void setR24_cre_0_tot_bal(BigDecimal r24_cre_0_tot_bal) {
		this.r24_cre_0_tot_bal = r24_cre_0_tot_bal;
	}
	public BigDecimal getR24_cre_0_tot_prov() {
		return r24_cre_0_tot_prov;
	}
	public void setR24_cre_0_tot_prov(BigDecimal r24_cre_0_tot_prov) {
		this.r24_cre_0_tot_prov = r24_cre_0_tot_prov;
	}
	public BigDecimal getR24_cre_0_tot_int_sus() {
		return r24_cre_0_tot_int_sus;
	}
	public void setR24_cre_0_tot_int_sus(BigDecimal r24_cre_0_tot_int_sus) {
		this.r24_cre_0_tot_int_sus = r24_cre_0_tot_int_sus;
	}
	public BigDecimal getR24_cre_0_tot_crm() {
		return r24_cre_0_tot_crm;
	}
	public void setR24_cre_0_tot_crm(BigDecimal r24_cre_0_tot_crm) {
		this.r24_cre_0_tot_crm = r24_cre_0_tot_crm;
	}
	public BigDecimal getR24_cre_0_tot_rwa() {
		return r24_cre_0_tot_rwa;
	}
	public void setR24_cre_0_tot_rwa(BigDecimal r24_cre_0_tot_rwa) {
		this.r24_cre_0_tot_rwa = r24_cre_0_tot_rwa;
	}
	public BigDecimal getR25_cre_20_loan_bal() {
		return r25_cre_20_loan_bal;
	}
	public void setR25_cre_20_loan_bal(BigDecimal r25_cre_20_loan_bal) {
		this.r25_cre_20_loan_bal = r25_cre_20_loan_bal;
	}
	public BigDecimal getR25_cre_20_loan_bill_amt() {
		return r25_cre_20_loan_bill_amt;
	}
	public void setR25_cre_20_loan_bill_amt(BigDecimal r25_cre_20_loan_bill_amt) {
		this.r25_cre_20_loan_bill_amt = r25_cre_20_loan_bill_amt;
	}
	public BigDecimal getR25_cre_20_loan_tot_bal() {
		return r25_cre_20_loan_tot_bal;
	}
	public void setR25_cre_20_loan_tot_bal(BigDecimal r25_cre_20_loan_tot_bal) {
		this.r25_cre_20_loan_tot_bal = r25_cre_20_loan_tot_bal;
	}
	public BigDecimal getR25_cre_20_loan_tot_prov() {
		return r25_cre_20_loan_tot_prov;
	}
	public void setR25_cre_20_loan_tot_prov(BigDecimal r25_cre_20_loan_tot_prov) {
		this.r25_cre_20_loan_tot_prov = r25_cre_20_loan_tot_prov;
	}
	public BigDecimal getR25_cre_20_loan_int_sus() {
		return r25_cre_20_loan_int_sus;
	}
	public void setR25_cre_20_loan_int_sus(BigDecimal r25_cre_20_loan_int_sus) {
		this.r25_cre_20_loan_int_sus = r25_cre_20_loan_int_sus;
	}
	public BigDecimal getR25_cre_20_loan_crm() {
		return r25_cre_20_loan_crm;
	}
	public void setR25_cre_20_loan_crm(BigDecimal r25_cre_20_loan_crm) {
		this.r25_cre_20_loan_crm = r25_cre_20_loan_crm;
	}
	public BigDecimal getR25_cre_20_loan_tot_dra() {
		return r25_cre_20_loan_tot_dra;
	}
	public void setR25_cre_20_loan_tot_dra(BigDecimal r25_cre_20_loan_tot_dra) {
		this.r25_cre_20_loan_tot_dra = r25_cre_20_loan_tot_dra;
	}
	public BigDecimal getR25_cre_20_inves_bal() {
		return r25_cre_20_inves_bal;
	}
	public void setR25_cre_20_inves_bal(BigDecimal r25_cre_20_inves_bal) {
		this.r25_cre_20_inves_bal = r25_cre_20_inves_bal;
	}
	public BigDecimal getR25_cre_20_inves_prov() {
		return r25_cre_20_inves_prov;
	}
	public void setR25_cre_20_inves_prov(BigDecimal r25_cre_20_inves_prov) {
		this.r25_cre_20_inves_prov = r25_cre_20_inves_prov;
	}
	public BigDecimal getR25_cre_20_inves_crm() {
		return r25_cre_20_inves_crm;
	}
	public void setR25_cre_20_inves_crm(BigDecimal r25_cre_20_inves_crm) {
		this.r25_cre_20_inves_crm = r25_cre_20_inves_crm;
	}
	public BigDecimal getR25_cre_20_inves_rwa() {
		return r25_cre_20_inves_rwa;
	}
	public void setR25_cre_20_inves_rwa(BigDecimal r25_cre_20_inves_rwa) {
		this.r25_cre_20_inves_rwa = r25_cre_20_inves_rwa;
	}
	public BigDecimal getR25_cre_20_plac_bal() {
		return r25_cre_20_plac_bal;
	}
	public void setR25_cre_20_plac_bal(BigDecimal r25_cre_20_plac_bal) {
		this.r25_cre_20_plac_bal = r25_cre_20_plac_bal;
	}
	public BigDecimal getR25_cre_20_plac_prov() {
		return r25_cre_20_plac_prov;
	}
	public void setR25_cre_20_plac_prov(BigDecimal r25_cre_20_plac_prov) {
		this.r25_cre_20_plac_prov = r25_cre_20_plac_prov;
	}
	public BigDecimal getR25_cre_20_plac_crm() {
		return r25_cre_20_plac_crm;
	}
	public void setR25_cre_20_plac_crm(BigDecimal r25_cre_20_plac_crm) {
		this.r25_cre_20_plac_crm = r25_cre_20_plac_crm;
	}
	public BigDecimal getR25_cre_20_plac_rwa() {
		return r25_cre_20_plac_rwa;
	}
	public void setR25_cre_20_plac_rwa(BigDecimal r25_cre_20_plac_rwa) {
		this.r25_cre_20_plac_rwa = r25_cre_20_plac_rwa;
	}
	public BigDecimal getR25_cre_20_cash_bal() {
		return r25_cre_20_cash_bal;
	}
	public void setR25_cre_20_cash_bal(BigDecimal r25_cre_20_cash_bal) {
		this.r25_cre_20_cash_bal = r25_cre_20_cash_bal;
	}
	public BigDecimal getR25_cre_20_cash_prov() {
		return r25_cre_20_cash_prov;
	}
	public void setR25_cre_20_cash_prov(BigDecimal r25_cre_20_cash_prov) {
		this.r25_cre_20_cash_prov = r25_cre_20_cash_prov;
	}
	public BigDecimal getR25_cre_20_cash_crm() {
		return r25_cre_20_cash_crm;
	}
	public void setR25_cre_20_cash_crm(BigDecimal r25_cre_20_cash_crm) {
		this.r25_cre_20_cash_crm = r25_cre_20_cash_crm;
	}
	public BigDecimal getR25_cre_20_cash_rwa() {
		return r25_cre_20_cash_rwa;
	}
	public void setR25_cre_20_cash_rwa(BigDecimal r25_cre_20_cash_rwa) {
		this.r25_cre_20_cash_rwa = r25_cre_20_cash_rwa;
	}
	public BigDecimal getR25_cre_20_tot_bal() {
		return r25_cre_20_tot_bal;
	}
	public void setR25_cre_20_tot_bal(BigDecimal r25_cre_20_tot_bal) {
		this.r25_cre_20_tot_bal = r25_cre_20_tot_bal;
	}
	public BigDecimal getR25_cre_20_tot_prov() {
		return r25_cre_20_tot_prov;
	}
	public void setR25_cre_20_tot_prov(BigDecimal r25_cre_20_tot_prov) {
		this.r25_cre_20_tot_prov = r25_cre_20_tot_prov;
	}
	public BigDecimal getR25_cre_20_tot_int_sus() {
		return r25_cre_20_tot_int_sus;
	}
	public void setR25_cre_20_tot_int_sus(BigDecimal r25_cre_20_tot_int_sus) {
		this.r25_cre_20_tot_int_sus = r25_cre_20_tot_int_sus;
	}
	public BigDecimal getR25_cre_20_tot_crm() {
		return r25_cre_20_tot_crm;
	}
	public void setR25_cre_20_tot_crm(BigDecimal r25_cre_20_tot_crm) {
		this.r25_cre_20_tot_crm = r25_cre_20_tot_crm;
	}
	public BigDecimal getR25_cre_20_tot_rwa() {
		return r25_cre_20_tot_rwa;
	}
	public void setR25_cre_20_tot_rwa(BigDecimal r25_cre_20_tot_rwa) {
		this.r25_cre_20_tot_rwa = r25_cre_20_tot_rwa;
	}
	public BigDecimal getR26_cre_50_loan_bal() {
		return r26_cre_50_loan_bal;
	}
	public void setR26_cre_50_loan_bal(BigDecimal r26_cre_50_loan_bal) {
		this.r26_cre_50_loan_bal = r26_cre_50_loan_bal;
	}
	public BigDecimal getR26_cre_50_loan_bill_amt() {
		return r26_cre_50_loan_bill_amt;
	}
	public void setR26_cre_50_loan_bill_amt(BigDecimal r26_cre_50_loan_bill_amt) {
		this.r26_cre_50_loan_bill_amt = r26_cre_50_loan_bill_amt;
	}
	public BigDecimal getR26_cre_50_loan_tot_bal() {
		return r26_cre_50_loan_tot_bal;
	}
	public void setR26_cre_50_loan_tot_bal(BigDecimal r26_cre_50_loan_tot_bal) {
		this.r26_cre_50_loan_tot_bal = r26_cre_50_loan_tot_bal;
	}
	public BigDecimal getR26_cre_50_loan_tot_prov() {
		return r26_cre_50_loan_tot_prov;
	}
	public void setR26_cre_50_loan_tot_prov(BigDecimal r26_cre_50_loan_tot_prov) {
		this.r26_cre_50_loan_tot_prov = r26_cre_50_loan_tot_prov;
	}
	public BigDecimal getR26_cre_50_loan_int_sus() {
		return r26_cre_50_loan_int_sus;
	}
	public void setR26_cre_50_loan_int_sus(BigDecimal r26_cre_50_loan_int_sus) {
		this.r26_cre_50_loan_int_sus = r26_cre_50_loan_int_sus;
	}
	public BigDecimal getR26_cre_50_loan_crm() {
		return r26_cre_50_loan_crm;
	}
	public void setR26_cre_50_loan_crm(BigDecimal r26_cre_50_loan_crm) {
		this.r26_cre_50_loan_crm = r26_cre_50_loan_crm;
	}
	public BigDecimal getR26_cre_50_loan_tot_dra() {
		return r26_cre_50_loan_tot_dra;
	}
	public void setR26_cre_50_loan_tot_dra(BigDecimal r26_cre_50_loan_tot_dra) {
		this.r26_cre_50_loan_tot_dra = r26_cre_50_loan_tot_dra;
	}
	public BigDecimal getR26_cre_50_inves_bal() {
		return r26_cre_50_inves_bal;
	}
	public void setR26_cre_50_inves_bal(BigDecimal r26_cre_50_inves_bal) {
		this.r26_cre_50_inves_bal = r26_cre_50_inves_bal;
	}
	public BigDecimal getR26_cre_50_inves_prov() {
		return r26_cre_50_inves_prov;
	}
	public void setR26_cre_50_inves_prov(BigDecimal r26_cre_50_inves_prov) {
		this.r26_cre_50_inves_prov = r26_cre_50_inves_prov;
	}
	public BigDecimal getR26_cre_50_inves_crm() {
		return r26_cre_50_inves_crm;
	}
	public void setR26_cre_50_inves_crm(BigDecimal r26_cre_50_inves_crm) {
		this.r26_cre_50_inves_crm = r26_cre_50_inves_crm;
	}
	public BigDecimal getR26_cre_50_inves_rwa() {
		return r26_cre_50_inves_rwa;
	}
	public void setR26_cre_50_inves_rwa(BigDecimal r26_cre_50_inves_rwa) {
		this.r26_cre_50_inves_rwa = r26_cre_50_inves_rwa;
	}
	public BigDecimal getR26_cre_50_plac_bal() {
		return r26_cre_50_plac_bal;
	}
	public void setR26_cre_50_plac_bal(BigDecimal r26_cre_50_plac_bal) {
		this.r26_cre_50_plac_bal = r26_cre_50_plac_bal;
	}
	public BigDecimal getR26_cre_50_plac_prov() {
		return r26_cre_50_plac_prov;
	}
	public void setR26_cre_50_plac_prov(BigDecimal r26_cre_50_plac_prov) {
		this.r26_cre_50_plac_prov = r26_cre_50_plac_prov;
	}
	public BigDecimal getR26_cre_50_plac_crm() {
		return r26_cre_50_plac_crm;
	}
	public void setR26_cre_50_plac_crm(BigDecimal r26_cre_50_plac_crm) {
		this.r26_cre_50_plac_crm = r26_cre_50_plac_crm;
	}
	public BigDecimal getR26_cre_50_plac_rwa() {
		return r26_cre_50_plac_rwa;
	}
	public void setR26_cre_50_plac_rwa(BigDecimal r26_cre_50_plac_rwa) {
		this.r26_cre_50_plac_rwa = r26_cre_50_plac_rwa;
	}
	public BigDecimal getR26_cre_50_cash_bal() {
		return r26_cre_50_cash_bal;
	}
	public void setR26_cre_50_cash_bal(BigDecimal r26_cre_50_cash_bal) {
		this.r26_cre_50_cash_bal = r26_cre_50_cash_bal;
	}
	public BigDecimal getR26_cre_50_cash_prov() {
		return r26_cre_50_cash_prov;
	}
	public void setR26_cre_50_cash_prov(BigDecimal r26_cre_50_cash_prov) {
		this.r26_cre_50_cash_prov = r26_cre_50_cash_prov;
	}
	public BigDecimal getR26_cre_50_cash_crm() {
		return r26_cre_50_cash_crm;
	}
	public void setR26_cre_50_cash_crm(BigDecimal r26_cre_50_cash_crm) {
		this.r26_cre_50_cash_crm = r26_cre_50_cash_crm;
	}
	public BigDecimal getR26_cre_50_cash_rwa() {
		return r26_cre_50_cash_rwa;
	}
	public void setR26_cre_50_cash_rwa(BigDecimal r26_cre_50_cash_rwa) {
		this.r26_cre_50_cash_rwa = r26_cre_50_cash_rwa;
	}
	public BigDecimal getR26_cre_50_tot_bal() {
		return r26_cre_50_tot_bal;
	}
	public void setR26_cre_50_tot_bal(BigDecimal r26_cre_50_tot_bal) {
		this.r26_cre_50_tot_bal = r26_cre_50_tot_bal;
	}
	public BigDecimal getR26_cre_50_tot_prov() {
		return r26_cre_50_tot_prov;
	}
	public void setR26_cre_50_tot_prov(BigDecimal r26_cre_50_tot_prov) {
		this.r26_cre_50_tot_prov = r26_cre_50_tot_prov;
	}
	public BigDecimal getR26_cre_50_tot_int_sus() {
		return r26_cre_50_tot_int_sus;
	}
	public void setR26_cre_50_tot_int_sus(BigDecimal r26_cre_50_tot_int_sus) {
		this.r26_cre_50_tot_int_sus = r26_cre_50_tot_int_sus;
	}
	public BigDecimal getR26_cre_50_tot_crm() {
		return r26_cre_50_tot_crm;
	}
	public void setR26_cre_50_tot_crm(BigDecimal r26_cre_50_tot_crm) {
		this.r26_cre_50_tot_crm = r26_cre_50_tot_crm;
	}
	public BigDecimal getR26_cre_50_tot_rwa() {
		return r26_cre_50_tot_rwa;
	}
	public void setR26_cre_50_tot_rwa(BigDecimal r26_cre_50_tot_rwa) {
		this.r26_cre_50_tot_rwa = r26_cre_50_tot_rwa;
	}
	public BigDecimal getR27_cre_100_loan_bal() {
		return r27_cre_100_loan_bal;
	}
	public void setR27_cre_100_loan_bal(BigDecimal r27_cre_100_loan_bal) {
		this.r27_cre_100_loan_bal = r27_cre_100_loan_bal;
	}
	public BigDecimal getR27_cre_100_loan_bill_amt() {
		return r27_cre_100_loan_bill_amt;
	}
	public void setR27_cre_100_loan_bill_amt(BigDecimal r27_cre_100_loan_bill_amt) {
		this.r27_cre_100_loan_bill_amt = r27_cre_100_loan_bill_amt;
	}
	public BigDecimal getR27_cre_100_loan_tot_bal() {
		return r27_cre_100_loan_tot_bal;
	}
	public void setR27_cre_100_loan_tot_bal(BigDecimal r27_cre_100_loan_tot_bal) {
		this.r27_cre_100_loan_tot_bal = r27_cre_100_loan_tot_bal;
	}
	public BigDecimal getR27_cre_100_loan_tot_prov() {
		return r27_cre_100_loan_tot_prov;
	}
	public void setR27_cre_100_loan_tot_prov(BigDecimal r27_cre_100_loan_tot_prov) {
		this.r27_cre_100_loan_tot_prov = r27_cre_100_loan_tot_prov;
	}
	public BigDecimal getR27_cre_100_loan_int_sus() {
		return r27_cre_100_loan_int_sus;
	}
	public void setR27_cre_100_loan_int_sus(BigDecimal r27_cre_100_loan_int_sus) {
		this.r27_cre_100_loan_int_sus = r27_cre_100_loan_int_sus;
	}
	public BigDecimal getR27_cre_100_loan_crm() {
		return r27_cre_100_loan_crm;
	}
	public void setR27_cre_100_loan_crm(BigDecimal r27_cre_100_loan_crm) {
		this.r27_cre_100_loan_crm = r27_cre_100_loan_crm;
	}
	public BigDecimal getR27_cre_100_loan_tot_dra() {
		return r27_cre_100_loan_tot_dra;
	}
	public void setR27_cre_100_loan_tot_dra(BigDecimal r27_cre_100_loan_tot_dra) {
		this.r27_cre_100_loan_tot_dra = r27_cre_100_loan_tot_dra;
	}
	public BigDecimal getR27_cre_100_inves_bal() {
		return r27_cre_100_inves_bal;
	}
	public void setR27_cre_100_inves_bal(BigDecimal r27_cre_100_inves_bal) {
		this.r27_cre_100_inves_bal = r27_cre_100_inves_bal;
	}
	public BigDecimal getR27_cre_100_inves_prov() {
		return r27_cre_100_inves_prov;
	}
	public void setR27_cre_100_inves_prov(BigDecimal r27_cre_100_inves_prov) {
		this.r27_cre_100_inves_prov = r27_cre_100_inves_prov;
	}
	public BigDecimal getR27_cre_100_inves_crm() {
		return r27_cre_100_inves_crm;
	}
	public void setR27_cre_100_inves_crm(BigDecimal r27_cre_100_inves_crm) {
		this.r27_cre_100_inves_crm = r27_cre_100_inves_crm;
	}
	public BigDecimal getR27_cre_100_inves_rwa() {
		return r27_cre_100_inves_rwa;
	}
	public void setR27_cre_100_inves_rwa(BigDecimal r27_cre_100_inves_rwa) {
		this.r27_cre_100_inves_rwa = r27_cre_100_inves_rwa;
	}
	public BigDecimal getR27_cre_100_plac_bal() {
		return r27_cre_100_plac_bal;
	}
	public void setR27_cre_100_plac_bal(BigDecimal r27_cre_100_plac_bal) {
		this.r27_cre_100_plac_bal = r27_cre_100_plac_bal;
	}
	public BigDecimal getR27_cre_100_plac_prov() {
		return r27_cre_100_plac_prov;
	}
	public void setR27_cre_100_plac_prov(BigDecimal r27_cre_100_plac_prov) {
		this.r27_cre_100_plac_prov = r27_cre_100_plac_prov;
	}
	public BigDecimal getR27_cre_100_plac_crm() {
		return r27_cre_100_plac_crm;
	}
	public void setR27_cre_100_plac_crm(BigDecimal r27_cre_100_plac_crm) {
		this.r27_cre_100_plac_crm = r27_cre_100_plac_crm;
	}
	public BigDecimal getR27_cre_100_plac_rwa() {
		return r27_cre_100_plac_rwa;
	}
	public void setR27_cre_100_plac_rwa(BigDecimal r27_cre_100_plac_rwa) {
		this.r27_cre_100_plac_rwa = r27_cre_100_plac_rwa;
	}
	public BigDecimal getR27_cre_100_cash_bal() {
		return r27_cre_100_cash_bal;
	}
	public void setR27_cre_100_cash_bal(BigDecimal r27_cre_100_cash_bal) {
		this.r27_cre_100_cash_bal = r27_cre_100_cash_bal;
	}
	public BigDecimal getR27_cre_100_cash_prov() {
		return r27_cre_100_cash_prov;
	}
	public void setR27_cre_100_cash_prov(BigDecimal r27_cre_100_cash_prov) {
		this.r27_cre_100_cash_prov = r27_cre_100_cash_prov;
	}
	public BigDecimal getR27_cre_100_cash_crm() {
		return r27_cre_100_cash_crm;
	}
	public void setR27_cre_100_cash_crm(BigDecimal r27_cre_100_cash_crm) {
		this.r27_cre_100_cash_crm = r27_cre_100_cash_crm;
	}
	public BigDecimal getR27_cre_100_cash_rwa() {
		return r27_cre_100_cash_rwa;
	}
	public void setR27_cre_100_cash_rwa(BigDecimal r27_cre_100_cash_rwa) {
		this.r27_cre_100_cash_rwa = r27_cre_100_cash_rwa;
	}
	public BigDecimal getR27_cre_100_tot_bal() {
		return r27_cre_100_tot_bal;
	}
	public void setR27_cre_100_tot_bal(BigDecimal r27_cre_100_tot_bal) {
		this.r27_cre_100_tot_bal = r27_cre_100_tot_bal;
	}
	public BigDecimal getR27_cre_100_tot_prov() {
		return r27_cre_100_tot_prov;
	}
	public void setR27_cre_100_tot_prov(BigDecimal r27_cre_100_tot_prov) {
		this.r27_cre_100_tot_prov = r27_cre_100_tot_prov;
	}
	public BigDecimal getR27_cre_100_tot_int_sus() {
		return r27_cre_100_tot_int_sus;
	}
	public void setR27_cre_100_tot_int_sus(BigDecimal r27_cre_100_tot_int_sus) {
		this.r27_cre_100_tot_int_sus = r27_cre_100_tot_int_sus;
	}
	public BigDecimal getR27_cre_100_tot_crm() {
		return r27_cre_100_tot_crm;
	}
	public void setR27_cre_100_tot_crm(BigDecimal r27_cre_100_tot_crm) {
		this.r27_cre_100_tot_crm = r27_cre_100_tot_crm;
	}
	public BigDecimal getR27_cre_100_tot_rwa() {
		return r27_cre_100_tot_rwa;
	}
	public void setR27_cre_100_tot_rwa(BigDecimal r27_cre_100_tot_rwa) {
		this.r27_cre_100_tot_rwa = r27_cre_100_tot_rwa;
	}
	public BigDecimal getR28_cre_150_loan_bal() {
		return r28_cre_150_loan_bal;
	}
	public void setR28_cre_150_loan_bal(BigDecimal r28_cre_150_loan_bal) {
		this.r28_cre_150_loan_bal = r28_cre_150_loan_bal;
	}
	public BigDecimal getR28_cre_150_loan_bill_amt() {
		return r28_cre_150_loan_bill_amt;
	}
	public void setR28_cre_150_loan_bill_amt(BigDecimal r28_cre_150_loan_bill_amt) {
		this.r28_cre_150_loan_bill_amt = r28_cre_150_loan_bill_amt;
	}
	public BigDecimal getR28_cre_150_loan_tot_bal() {
		return r28_cre_150_loan_tot_bal;
	}
	public void setR28_cre_150_loan_tot_bal(BigDecimal r28_cre_150_loan_tot_bal) {
		this.r28_cre_150_loan_tot_bal = r28_cre_150_loan_tot_bal;
	}
	public BigDecimal getR28_cre_150_loan_tot_prov() {
		return r28_cre_150_loan_tot_prov;
	}
	public void setR28_cre_150_loan_tot_prov(BigDecimal r28_cre_150_loan_tot_prov) {
		this.r28_cre_150_loan_tot_prov = r28_cre_150_loan_tot_prov;
	}
	public BigDecimal getR28_cre_150_loan_int_sus() {
		return r28_cre_150_loan_int_sus;
	}
	public void setR28_cre_150_loan_int_sus(BigDecimal r28_cre_150_loan_int_sus) {
		this.r28_cre_150_loan_int_sus = r28_cre_150_loan_int_sus;
	}
	public BigDecimal getR28_cre_150_loan_crm() {
		return r28_cre_150_loan_crm;
	}
	public void setR28_cre_150_loan_crm(BigDecimal r28_cre_150_loan_crm) {
		this.r28_cre_150_loan_crm = r28_cre_150_loan_crm;
	}
	public BigDecimal getR28_cre_150_loan_tot_dra() {
		return r28_cre_150_loan_tot_dra;
	}
	public void setR28_cre_150_loan_tot_dra(BigDecimal r28_cre_150_loan_tot_dra) {
		this.r28_cre_150_loan_tot_dra = r28_cre_150_loan_tot_dra;
	}
	public BigDecimal getR28_cre_150_inves_bal() {
		return r28_cre_150_inves_bal;
	}
	public void setR28_cre_150_inves_bal(BigDecimal r28_cre_150_inves_bal) {
		this.r28_cre_150_inves_bal = r28_cre_150_inves_bal;
	}
	public BigDecimal getR28_cre_150_inves_prov() {
		return r28_cre_150_inves_prov;
	}
	public void setR28_cre_150_inves_prov(BigDecimal r28_cre_150_inves_prov) {
		this.r28_cre_150_inves_prov = r28_cre_150_inves_prov;
	}
	public BigDecimal getR28_cre_150_inves_crm() {
		return r28_cre_150_inves_crm;
	}
	public void setR28_cre_150_inves_crm(BigDecimal r28_cre_150_inves_crm) {
		this.r28_cre_150_inves_crm = r28_cre_150_inves_crm;
	}
	public BigDecimal getR28_cre_150_inves_rwa() {
		return r28_cre_150_inves_rwa;
	}
	public void setR28_cre_150_inves_rwa(BigDecimal r28_cre_150_inves_rwa) {
		this.r28_cre_150_inves_rwa = r28_cre_150_inves_rwa;
	}
	public BigDecimal getR28_cre_150_plac_bal() {
		return r28_cre_150_plac_bal;
	}
	public void setR28_cre_150_plac_bal(BigDecimal r28_cre_150_plac_bal) {
		this.r28_cre_150_plac_bal = r28_cre_150_plac_bal;
	}
	public BigDecimal getR28_cre_150_plac_prov() {
		return r28_cre_150_plac_prov;
	}
	public void setR28_cre_150_plac_prov(BigDecimal r28_cre_150_plac_prov) {
		this.r28_cre_150_plac_prov = r28_cre_150_plac_prov;
	}
	public BigDecimal getR28_cre_150_plac_crm() {
		return r28_cre_150_plac_crm;
	}
	public void setR28_cre_150_plac_crm(BigDecimal r28_cre_150_plac_crm) {
		this.r28_cre_150_plac_crm = r28_cre_150_plac_crm;
	}
	public BigDecimal getR28_cre_150_plac_rwa() {
		return r28_cre_150_plac_rwa;
	}
	public void setR28_cre_150_plac_rwa(BigDecimal r28_cre_150_plac_rwa) {
		this.r28_cre_150_plac_rwa = r28_cre_150_plac_rwa;
	}
	public BigDecimal getR28_cre_150_cash_bal() {
		return r28_cre_150_cash_bal;
	}
	public void setR28_cre_150_cash_bal(BigDecimal r28_cre_150_cash_bal) {
		this.r28_cre_150_cash_bal = r28_cre_150_cash_bal;
	}
	public BigDecimal getR28_cre_150_cash_prov() {
		return r28_cre_150_cash_prov;
	}
	public void setR28_cre_150_cash_prov(BigDecimal r28_cre_150_cash_prov) {
		this.r28_cre_150_cash_prov = r28_cre_150_cash_prov;
	}
	public BigDecimal getR28_cre_150_cash_crm() {
		return r28_cre_150_cash_crm;
	}
	public void setR28_cre_150_cash_crm(BigDecimal r28_cre_150_cash_crm) {
		this.r28_cre_150_cash_crm = r28_cre_150_cash_crm;
	}
	public BigDecimal getR28_cre_150_cash_rwa() {
		return r28_cre_150_cash_rwa;
	}
	public void setR28_cre_150_cash_rwa(BigDecimal r28_cre_150_cash_rwa) {
		this.r28_cre_150_cash_rwa = r28_cre_150_cash_rwa;
	}
	public BigDecimal getR28_cre_150_tot_bal() {
		return r28_cre_150_tot_bal;
	}
	public void setR28_cre_150_tot_bal(BigDecimal r28_cre_150_tot_bal) {
		this.r28_cre_150_tot_bal = r28_cre_150_tot_bal;
	}
	public BigDecimal getR28_cre_150_tot_prov() {
		return r28_cre_150_tot_prov;
	}
	public void setR28_cre_150_tot_prov(BigDecimal r28_cre_150_tot_prov) {
		this.r28_cre_150_tot_prov = r28_cre_150_tot_prov;
	}
	public BigDecimal getR28_cre_150_tot_int_sus() {
		return r28_cre_150_tot_int_sus;
	}
	public void setR28_cre_150_tot_int_sus(BigDecimal r28_cre_150_tot_int_sus) {
		this.r28_cre_150_tot_int_sus = r28_cre_150_tot_int_sus;
	}
	public BigDecimal getR28_cre_150_tot_crm() {
		return r28_cre_150_tot_crm;
	}
	public void setR28_cre_150_tot_crm(BigDecimal r28_cre_150_tot_crm) {
		this.r28_cre_150_tot_crm = r28_cre_150_tot_crm;
	}
	public BigDecimal getR28_cre_150_tot_rwa() {
		return r28_cre_150_tot_rwa;
	}
	public void setR28_cre_150_tot_rwa(BigDecimal r28_cre_150_tot_rwa) {
		this.r28_cre_150_tot_rwa = r28_cre_150_tot_rwa;
	}
	public BigDecimal getR29_crt_0_loan_bal() {
		return r29_crt_0_loan_bal;
	}
	public void setR29_crt_0_loan_bal(BigDecimal r29_crt_0_loan_bal) {
		this.r29_crt_0_loan_bal = r29_crt_0_loan_bal;
	}
	public BigDecimal getR29_crt_0_loan_bill_amt() {
		return r29_crt_0_loan_bill_amt;
	}
	public void setR29_crt_0_loan_bill_amt(BigDecimal r29_crt_0_loan_bill_amt) {
		this.r29_crt_0_loan_bill_amt = r29_crt_0_loan_bill_amt;
	}
	public BigDecimal getR29_crt_0_loan_tot_bal() {
		return r29_crt_0_loan_tot_bal;
	}
	public void setR29_crt_0_loan_tot_bal(BigDecimal r29_crt_0_loan_tot_bal) {
		this.r29_crt_0_loan_tot_bal = r29_crt_0_loan_tot_bal;
	}
	public BigDecimal getR29_crt_0_loan_tot_prov() {
		return r29_crt_0_loan_tot_prov;
	}
	public void setR29_crt_0_loan_tot_prov(BigDecimal r29_crt_0_loan_tot_prov) {
		this.r29_crt_0_loan_tot_prov = r29_crt_0_loan_tot_prov;
	}
	public BigDecimal getR29_crt_0_loan_int_sus() {
		return r29_crt_0_loan_int_sus;
	}
	public void setR29_crt_0_loan_int_sus(BigDecimal r29_crt_0_loan_int_sus) {
		this.r29_crt_0_loan_int_sus = r29_crt_0_loan_int_sus;
	}
	public BigDecimal getR29_crt_0_loan_crm() {
		return r29_crt_0_loan_crm;
	}
	public void setR29_crt_0_loan_crm(BigDecimal r29_crt_0_loan_crm) {
		this.r29_crt_0_loan_crm = r29_crt_0_loan_crm;
	}
	public BigDecimal getR29_crt_0_loan_tot_dra() {
		return r29_crt_0_loan_tot_dra;
	}
	public void setR29_crt_0_loan_tot_dra(BigDecimal r29_crt_0_loan_tot_dra) {
		this.r29_crt_0_loan_tot_dra = r29_crt_0_loan_tot_dra;
	}
	public BigDecimal getR29_crt_0_inves_bal() {
		return r29_crt_0_inves_bal;
	}
	public void setR29_crt_0_inves_bal(BigDecimal r29_crt_0_inves_bal) {
		this.r29_crt_0_inves_bal = r29_crt_0_inves_bal;
	}
	public BigDecimal getR29_crt_0_inves_prov() {
		return r29_crt_0_inves_prov;
	}
	public void setR29_crt_0_inves_prov(BigDecimal r29_crt_0_inves_prov) {
		this.r29_crt_0_inves_prov = r29_crt_0_inves_prov;
	}
	public BigDecimal getR29_crt_0_inves_crm() {
		return r29_crt_0_inves_crm;
	}
	public void setR29_crt_0_inves_crm(BigDecimal r29_crt_0_inves_crm) {
		this.r29_crt_0_inves_crm = r29_crt_0_inves_crm;
	}
	public BigDecimal getR29_crt_0_inves_rwa() {
		return r29_crt_0_inves_rwa;
	}
	public void setR29_crt_0_inves_rwa(BigDecimal r29_crt_0_inves_rwa) {
		this.r29_crt_0_inves_rwa = r29_crt_0_inves_rwa;
	}
	public BigDecimal getR29_crt_0_plac_bal() {
		return r29_crt_0_plac_bal;
	}
	public void setR29_crt_0_plac_bal(BigDecimal r29_crt_0_plac_bal) {
		this.r29_crt_0_plac_bal = r29_crt_0_plac_bal;
	}
	public BigDecimal getR29_crt_0_plac_prov() {
		return r29_crt_0_plac_prov;
	}
	public void setR29_crt_0_plac_prov(BigDecimal r29_crt_0_plac_prov) {
		this.r29_crt_0_plac_prov = r29_crt_0_plac_prov;
	}
	public BigDecimal getR29_crt_0_plac_crm() {
		return r29_crt_0_plac_crm;
	}
	public void setR29_crt_0_plac_crm(BigDecimal r29_crt_0_plac_crm) {
		this.r29_crt_0_plac_crm = r29_crt_0_plac_crm;
	}
	public BigDecimal getR29_crt_0_plac_rwa() {
		return r29_crt_0_plac_rwa;
	}
	public void setR29_crt_0_plac_rwa(BigDecimal r29_crt_0_plac_rwa) {
		this.r29_crt_0_plac_rwa = r29_crt_0_plac_rwa;
	}
	public BigDecimal getR29_crt_0_cash_bal() {
		return r29_crt_0_cash_bal;
	}
	public void setR29_crt_0_cash_bal(BigDecimal r29_crt_0_cash_bal) {
		this.r29_crt_0_cash_bal = r29_crt_0_cash_bal;
	}
	public BigDecimal getR29_crt_0_cash_prov() {
		return r29_crt_0_cash_prov;
	}
	public void setR29_crt_0_cash_prov(BigDecimal r29_crt_0_cash_prov) {
		this.r29_crt_0_cash_prov = r29_crt_0_cash_prov;
	}
	public BigDecimal getR29_crt_0_cash_crm() {
		return r29_crt_0_cash_crm;
	}
	public void setR29_crt_0_cash_crm(BigDecimal r29_crt_0_cash_crm) {
		this.r29_crt_0_cash_crm = r29_crt_0_cash_crm;
	}
	public BigDecimal getR29_crt_0_cash_rwa() {
		return r29_crt_0_cash_rwa;
	}
	public void setR29_crt_0_cash_rwa(BigDecimal r29_crt_0_cash_rwa) {
		this.r29_crt_0_cash_rwa = r29_crt_0_cash_rwa;
	}
	public BigDecimal getR29_crt_0_tot_bal() {
		return r29_crt_0_tot_bal;
	}
	public void setR29_crt_0_tot_bal(BigDecimal r29_crt_0_tot_bal) {
		this.r29_crt_0_tot_bal = r29_crt_0_tot_bal;
	}
	public BigDecimal getR29_crt_0_tot_prov() {
		return r29_crt_0_tot_prov;
	}
	public void setR29_crt_0_tot_prov(BigDecimal r29_crt_0_tot_prov) {
		this.r29_crt_0_tot_prov = r29_crt_0_tot_prov;
	}
	public BigDecimal getR29_crt_0_tot_int_sus() {
		return r29_crt_0_tot_int_sus;
	}
	public void setR29_crt_0_tot_int_sus(BigDecimal r29_crt_0_tot_int_sus) {
		this.r29_crt_0_tot_int_sus = r29_crt_0_tot_int_sus;
	}
	public BigDecimal getR29_crt_0_tot_crm() {
		return r29_crt_0_tot_crm;
	}
	public void setR29_crt_0_tot_crm(BigDecimal r29_crt_0_tot_crm) {
		this.r29_crt_0_tot_crm = r29_crt_0_tot_crm;
	}
	public BigDecimal getR29_crt_0_tot_rwa() {
		return r29_crt_0_tot_rwa;
	}
	public void setR29_crt_0_tot_rwa(BigDecimal r29_crt_0_tot_rwa) {
		this.r29_crt_0_tot_rwa = r29_crt_0_tot_rwa;
	}
	public BigDecimal getR30_crt_20_loan_bal() {
		return r30_crt_20_loan_bal;
	}
	public void setR30_crt_20_loan_bal(BigDecimal r30_crt_20_loan_bal) {
		this.r30_crt_20_loan_bal = r30_crt_20_loan_bal;
	}
	public BigDecimal getR30_crt_20_loan_bill_amt() {
		return r30_crt_20_loan_bill_amt;
	}
	public void setR30_crt_20_loan_bill_amt(BigDecimal r30_crt_20_loan_bill_amt) {
		this.r30_crt_20_loan_bill_amt = r30_crt_20_loan_bill_amt;
	}
	public BigDecimal getR30_crt_20_loan_tot_bal() {
		return r30_crt_20_loan_tot_bal;
	}
	public void setR30_crt_20_loan_tot_bal(BigDecimal r30_crt_20_loan_tot_bal) {
		this.r30_crt_20_loan_tot_bal = r30_crt_20_loan_tot_bal;
	}
	public BigDecimal getR30_crt_20_loan_tot_prov() {
		return r30_crt_20_loan_tot_prov;
	}
	public void setR30_crt_20_loan_tot_prov(BigDecimal r30_crt_20_loan_tot_prov) {
		this.r30_crt_20_loan_tot_prov = r30_crt_20_loan_tot_prov;
	}
	public BigDecimal getR30_crt_20_loan_int_sus() {
		return r30_crt_20_loan_int_sus;
	}
	public void setR30_crt_20_loan_int_sus(BigDecimal r30_crt_20_loan_int_sus) {
		this.r30_crt_20_loan_int_sus = r30_crt_20_loan_int_sus;
	}
	public BigDecimal getR30_crt_20_loan_crm() {
		return r30_crt_20_loan_crm;
	}
	public void setR30_crt_20_loan_crm(BigDecimal r30_crt_20_loan_crm) {
		this.r30_crt_20_loan_crm = r30_crt_20_loan_crm;
	}
	public BigDecimal getR30_crt_20_loan_tot_dra() {
		return r30_crt_20_loan_tot_dra;
	}
	public void setR30_crt_20_loan_tot_dra(BigDecimal r30_crt_20_loan_tot_dra) {
		this.r30_crt_20_loan_tot_dra = r30_crt_20_loan_tot_dra;
	}
	public BigDecimal getR30_crt_20_inves_bal() {
		return r30_crt_20_inves_bal;
	}
	public void setR30_crt_20_inves_bal(BigDecimal r30_crt_20_inves_bal) {
		this.r30_crt_20_inves_bal = r30_crt_20_inves_bal;
	}
	public BigDecimal getR30_crt_20_inves_prov() {
		return r30_crt_20_inves_prov;
	}
	public void setR30_crt_20_inves_prov(BigDecimal r30_crt_20_inves_prov) {
		this.r30_crt_20_inves_prov = r30_crt_20_inves_prov;
	}
	public BigDecimal getR30_crt_20_inves_crm() {
		return r30_crt_20_inves_crm;
	}
	public void setR30_crt_20_inves_crm(BigDecimal r30_crt_20_inves_crm) {
		this.r30_crt_20_inves_crm = r30_crt_20_inves_crm;
	}
	public BigDecimal getR30_crt_20_inves_rwa() {
		return r30_crt_20_inves_rwa;
	}
	public void setR30_crt_20_inves_rwa(BigDecimal r30_crt_20_inves_rwa) {
		this.r30_crt_20_inves_rwa = r30_crt_20_inves_rwa;
	}
	public BigDecimal getR30_crt_20_plac_bal() {
		return r30_crt_20_plac_bal;
	}
	public void setR30_crt_20_plac_bal(BigDecimal r30_crt_20_plac_bal) {
		this.r30_crt_20_plac_bal = r30_crt_20_plac_bal;
	}
	public BigDecimal getR30_crt_20_plac_prov() {
		return r30_crt_20_plac_prov;
	}
	public void setR30_crt_20_plac_prov(BigDecimal r30_crt_20_plac_prov) {
		this.r30_crt_20_plac_prov = r30_crt_20_plac_prov;
	}
	public BigDecimal getR30_crt_20_plac_crm() {
		return r30_crt_20_plac_crm;
	}
	public void setR30_crt_20_plac_crm(BigDecimal r30_crt_20_plac_crm) {
		this.r30_crt_20_plac_crm = r30_crt_20_plac_crm;
	}
	public BigDecimal getR30_crt_20_plac_rwa() {
		return r30_crt_20_plac_rwa;
	}
	public void setR30_crt_20_plac_rwa(BigDecimal r30_crt_20_plac_rwa) {
		this.r30_crt_20_plac_rwa = r30_crt_20_plac_rwa;
	}
	public BigDecimal getR30_crt_20_cash_bal() {
		return r30_crt_20_cash_bal;
	}
	public void setR30_crt_20_cash_bal(BigDecimal r30_crt_20_cash_bal) {
		this.r30_crt_20_cash_bal = r30_crt_20_cash_bal;
	}
	public BigDecimal getR30_crt_20_cash_prov() {
		return r30_crt_20_cash_prov;
	}
	public void setR30_crt_20_cash_prov(BigDecimal r30_crt_20_cash_prov) {
		this.r30_crt_20_cash_prov = r30_crt_20_cash_prov;
	}
	public BigDecimal getR30_crt_20_cash_crm() {
		return r30_crt_20_cash_crm;
	}
	public void setR30_crt_20_cash_crm(BigDecimal r30_crt_20_cash_crm) {
		this.r30_crt_20_cash_crm = r30_crt_20_cash_crm;
	}
	public BigDecimal getR30_crt_20_cash_rwa() {
		return r30_crt_20_cash_rwa;
	}
	public void setR30_crt_20_cash_rwa(BigDecimal r30_crt_20_cash_rwa) {
		this.r30_crt_20_cash_rwa = r30_crt_20_cash_rwa;
	}
	public BigDecimal getR30_crt_20_tot_bal() {
		return r30_crt_20_tot_bal;
	}
	public void setR30_crt_20_tot_bal(BigDecimal r30_crt_20_tot_bal) {
		this.r30_crt_20_tot_bal = r30_crt_20_tot_bal;
	}
	public BigDecimal getR30_crt_20_tot_prov() {
		return r30_crt_20_tot_prov;
	}
	public void setR30_crt_20_tot_prov(BigDecimal r30_crt_20_tot_prov) {
		this.r30_crt_20_tot_prov = r30_crt_20_tot_prov;
	}
	public BigDecimal getR30_crt_20_tot_int_sus() {
		return r30_crt_20_tot_int_sus;
	}
	public void setR30_crt_20_tot_int_sus(BigDecimal r30_crt_20_tot_int_sus) {
		this.r30_crt_20_tot_int_sus = r30_crt_20_tot_int_sus;
	}
	public BigDecimal getR30_crt_20_tot_crm() {
		return r30_crt_20_tot_crm;
	}
	public void setR30_crt_20_tot_crm(BigDecimal r30_crt_20_tot_crm) {
		this.r30_crt_20_tot_crm = r30_crt_20_tot_crm;
	}
	public BigDecimal getR30_crt_20_tot_rwa() {
		return r30_crt_20_tot_rwa;
	}
	public void setR30_crt_20_tot_rwa(BigDecimal r30_crt_20_tot_rwa) {
		this.r30_crt_20_tot_rwa = r30_crt_20_tot_rwa;
	}
	public BigDecimal getR31_crt_50_loan_bal() {
		return r31_crt_50_loan_bal;
	}
	public void setR31_crt_50_loan_bal(BigDecimal r31_crt_50_loan_bal) {
		this.r31_crt_50_loan_bal = r31_crt_50_loan_bal;
	}
	public BigDecimal getR31_crt_50_loan_bill_amt() {
		return r31_crt_50_loan_bill_amt;
	}
	public void setR31_crt_50_loan_bill_amt(BigDecimal r31_crt_50_loan_bill_amt) {
		this.r31_crt_50_loan_bill_amt = r31_crt_50_loan_bill_amt;
	}
	public BigDecimal getR31_crt_50_loan_tot_bal() {
		return r31_crt_50_loan_tot_bal;
	}
	public void setR31_crt_50_loan_tot_bal(BigDecimal r31_crt_50_loan_tot_bal) {
		this.r31_crt_50_loan_tot_bal = r31_crt_50_loan_tot_bal;
	}
	public BigDecimal getR31_crt_50_loan_tot_prov() {
		return r31_crt_50_loan_tot_prov;
	}
	public void setR31_crt_50_loan_tot_prov(BigDecimal r31_crt_50_loan_tot_prov) {
		this.r31_crt_50_loan_tot_prov = r31_crt_50_loan_tot_prov;
	}
	public BigDecimal getR31_crt_50_loan_int_sus() {
		return r31_crt_50_loan_int_sus;
	}
	public void setR31_crt_50_loan_int_sus(BigDecimal r31_crt_50_loan_int_sus) {
		this.r31_crt_50_loan_int_sus = r31_crt_50_loan_int_sus;
	}
	public BigDecimal getR31_crt_50_loan_crm() {
		return r31_crt_50_loan_crm;
	}
	public void setR31_crt_50_loan_crm(BigDecimal r31_crt_50_loan_crm) {
		this.r31_crt_50_loan_crm = r31_crt_50_loan_crm;
	}
	public BigDecimal getR31_crt_50_loan_tot_dra() {
		return r31_crt_50_loan_tot_dra;
	}
	public void setR31_crt_50_loan_tot_dra(BigDecimal r31_crt_50_loan_tot_dra) {
		this.r31_crt_50_loan_tot_dra = r31_crt_50_loan_tot_dra;
	}
	public BigDecimal getR31_crt_50_inves_bal() {
		return r31_crt_50_inves_bal;
	}
	public void setR31_crt_50_inves_bal(BigDecimal r31_crt_50_inves_bal) {
		this.r31_crt_50_inves_bal = r31_crt_50_inves_bal;
	}
	public BigDecimal getR31_crt_50_inves_prov() {
		return r31_crt_50_inves_prov;
	}
	public void setR31_crt_50_inves_prov(BigDecimal r31_crt_50_inves_prov) {
		this.r31_crt_50_inves_prov = r31_crt_50_inves_prov;
	}
	public BigDecimal getR31_crt_50_inves_crm() {
		return r31_crt_50_inves_crm;
	}
	public void setR31_crt_50_inves_crm(BigDecimal r31_crt_50_inves_crm) {
		this.r31_crt_50_inves_crm = r31_crt_50_inves_crm;
	}
	public BigDecimal getR31_crt_50_inves_rwa() {
		return r31_crt_50_inves_rwa;
	}
	public void setR31_crt_50_inves_rwa(BigDecimal r31_crt_50_inves_rwa) {
		this.r31_crt_50_inves_rwa = r31_crt_50_inves_rwa;
	}
	public BigDecimal getR31_crt_50_plac_bal() {
		return r31_crt_50_plac_bal;
	}
	public void setR31_crt_50_plac_bal(BigDecimal r31_crt_50_plac_bal) {
		this.r31_crt_50_plac_bal = r31_crt_50_plac_bal;
	}
	public BigDecimal getR31_crt_50_plac_prov() {
		return r31_crt_50_plac_prov;
	}
	public void setR31_crt_50_plac_prov(BigDecimal r31_crt_50_plac_prov) {
		this.r31_crt_50_plac_prov = r31_crt_50_plac_prov;
	}
	public BigDecimal getR31_crt_50_plac_crm() {
		return r31_crt_50_plac_crm;
	}
	public void setR31_crt_50_plac_crm(BigDecimal r31_crt_50_plac_crm) {
		this.r31_crt_50_plac_crm = r31_crt_50_plac_crm;
	}
	public BigDecimal getR31_crt_50_plac_rwa() {
		return r31_crt_50_plac_rwa;
	}
	public void setR31_crt_50_plac_rwa(BigDecimal r31_crt_50_plac_rwa) {
		this.r31_crt_50_plac_rwa = r31_crt_50_plac_rwa;
	}
	public BigDecimal getR31_crt_50_cash_bal() {
		return r31_crt_50_cash_bal;
	}
	public void setR31_crt_50_cash_bal(BigDecimal r31_crt_50_cash_bal) {
		this.r31_crt_50_cash_bal = r31_crt_50_cash_bal;
	}
	public BigDecimal getR31_crt_50_cash_prov() {
		return r31_crt_50_cash_prov;
	}
	public void setR31_crt_50_cash_prov(BigDecimal r31_crt_50_cash_prov) {
		this.r31_crt_50_cash_prov = r31_crt_50_cash_prov;
	}
	public BigDecimal getR31_crt_50_cash_crm() {
		return r31_crt_50_cash_crm;
	}
	public void setR31_crt_50_cash_crm(BigDecimal r31_crt_50_cash_crm) {
		this.r31_crt_50_cash_crm = r31_crt_50_cash_crm;
	}
	public BigDecimal getR31_crt_50_cash_rwa() {
		return r31_crt_50_cash_rwa;
	}
	public void setR31_crt_50_cash_rwa(BigDecimal r31_crt_50_cash_rwa) {
		this.r31_crt_50_cash_rwa = r31_crt_50_cash_rwa;
	}
	public BigDecimal getR31_crt_50_tot_bal() {
		return r31_crt_50_tot_bal;
	}
	public void setR31_crt_50_tot_bal(BigDecimal r31_crt_50_tot_bal) {
		this.r31_crt_50_tot_bal = r31_crt_50_tot_bal;
	}
	public BigDecimal getR31_crt_50_tot_prov() {
		return r31_crt_50_tot_prov;
	}
	public void setR31_crt_50_tot_prov(BigDecimal r31_crt_50_tot_prov) {
		this.r31_crt_50_tot_prov = r31_crt_50_tot_prov;
	}
	public BigDecimal getR31_crt_50_tot_int_sus() {
		return r31_crt_50_tot_int_sus;
	}
	public void setR31_crt_50_tot_int_sus(BigDecimal r31_crt_50_tot_int_sus) {
		this.r31_crt_50_tot_int_sus = r31_crt_50_tot_int_sus;
	}
	public BigDecimal getR31_crt_50_tot_crm() {
		return r31_crt_50_tot_crm;
	}
	public void setR31_crt_50_tot_crm(BigDecimal r31_crt_50_tot_crm) {
		this.r31_crt_50_tot_crm = r31_crt_50_tot_crm;
	}
	public BigDecimal getR31_crt_50_tot_rwa() {
		return r31_crt_50_tot_rwa;
	}
	public void setR31_crt_50_tot_rwa(BigDecimal r31_crt_50_tot_rwa) {
		this.r31_crt_50_tot_rwa = r31_crt_50_tot_rwa;
	}
	public BigDecimal getR32_crt_100_loan_bal() {
		return r32_crt_100_loan_bal;
	}
	public void setR32_crt_100_loan_bal(BigDecimal r32_crt_100_loan_bal) {
		this.r32_crt_100_loan_bal = r32_crt_100_loan_bal;
	}
	public BigDecimal getR32_crt_100_loan_bill_amt() {
		return r32_crt_100_loan_bill_amt;
	}
	public void setR32_crt_100_loan_bill_amt(BigDecimal r32_crt_100_loan_bill_amt) {
		this.r32_crt_100_loan_bill_amt = r32_crt_100_loan_bill_amt;
	}
	public BigDecimal getR32_crt_100_loan_tot_bal() {
		return r32_crt_100_loan_tot_bal;
	}
	public void setR32_crt_100_loan_tot_bal(BigDecimal r32_crt_100_loan_tot_bal) {
		this.r32_crt_100_loan_tot_bal = r32_crt_100_loan_tot_bal;
	}
	public BigDecimal getR32_crt_100_loan_tot_prov() {
		return r32_crt_100_loan_tot_prov;
	}
	public void setR32_crt_100_loan_tot_prov(BigDecimal r32_crt_100_loan_tot_prov) {
		this.r32_crt_100_loan_tot_prov = r32_crt_100_loan_tot_prov;
	}
	public BigDecimal getR32_crt_100_loan_int_sus() {
		return r32_crt_100_loan_int_sus;
	}
	public void setR32_crt_100_loan_int_sus(BigDecimal r32_crt_100_loan_int_sus) {
		this.r32_crt_100_loan_int_sus = r32_crt_100_loan_int_sus;
	}
	public BigDecimal getR32_crt_100_loan_crm() {
		return r32_crt_100_loan_crm;
	}
	public void setR32_crt_100_loan_crm(BigDecimal r32_crt_100_loan_crm) {
		this.r32_crt_100_loan_crm = r32_crt_100_loan_crm;
	}
	public BigDecimal getR32_crt_100_loan_tot_dra() {
		return r32_crt_100_loan_tot_dra;
	}
	public void setR32_crt_100_loan_tot_dra(BigDecimal r32_crt_100_loan_tot_dra) {
		this.r32_crt_100_loan_tot_dra = r32_crt_100_loan_tot_dra;
	}
	public BigDecimal getR32_crt_100_inves_bal() {
		return r32_crt_100_inves_bal;
	}
	public void setR32_crt_100_inves_bal(BigDecimal r32_crt_100_inves_bal) {
		this.r32_crt_100_inves_bal = r32_crt_100_inves_bal;
	}
	public BigDecimal getR32_crt_100_inves_prov() {
		return r32_crt_100_inves_prov;
	}
	public void setR32_crt_100_inves_prov(BigDecimal r32_crt_100_inves_prov) {
		this.r32_crt_100_inves_prov = r32_crt_100_inves_prov;
	}
	public BigDecimal getR32_crt_100_inves_crm() {
		return r32_crt_100_inves_crm;
	}
	public void setR32_crt_100_inves_crm(BigDecimal r32_crt_100_inves_crm) {
		this.r32_crt_100_inves_crm = r32_crt_100_inves_crm;
	}
	public BigDecimal getR32_crt_100_inves_rwa() {
		return r32_crt_100_inves_rwa;
	}
	public void setR32_crt_100_inves_rwa(BigDecimal r32_crt_100_inves_rwa) {
		this.r32_crt_100_inves_rwa = r32_crt_100_inves_rwa;
	}
	public BigDecimal getR32_crt_100_plac_bal() {
		return r32_crt_100_plac_bal;
	}
	public void setR32_crt_100_plac_bal(BigDecimal r32_crt_100_plac_bal) {
		this.r32_crt_100_plac_bal = r32_crt_100_plac_bal;
	}
	public BigDecimal getR32_crt_100_plac_prov() {
		return r32_crt_100_plac_prov;
	}
	public void setR32_crt_100_plac_prov(BigDecimal r32_crt_100_plac_prov) {
		this.r32_crt_100_plac_prov = r32_crt_100_plac_prov;
	}
	public BigDecimal getR32_crt_100_plac_crm() {
		return r32_crt_100_plac_crm;
	}
	public void setR32_crt_100_plac_crm(BigDecimal r32_crt_100_plac_crm) {
		this.r32_crt_100_plac_crm = r32_crt_100_plac_crm;
	}
	public BigDecimal getR32_crt_100_plac_rwa() {
		return r32_crt_100_plac_rwa;
	}
	public void setR32_crt_100_plac_rwa(BigDecimal r32_crt_100_plac_rwa) {
		this.r32_crt_100_plac_rwa = r32_crt_100_plac_rwa;
	}
	public BigDecimal getR32_crt_100_cash_bal() {
		return r32_crt_100_cash_bal;
	}
	public void setR32_crt_100_cash_bal(BigDecimal r32_crt_100_cash_bal) {
		this.r32_crt_100_cash_bal = r32_crt_100_cash_bal;
	}
	public BigDecimal getR32_crt_100_cash_prov() {
		return r32_crt_100_cash_prov;
	}
	public void setR32_crt_100_cash_prov(BigDecimal r32_crt_100_cash_prov) {
		this.r32_crt_100_cash_prov = r32_crt_100_cash_prov;
	}
	public BigDecimal getR32_crt_100_cash_crm() {
		return r32_crt_100_cash_crm;
	}
	public void setR32_crt_100_cash_crm(BigDecimal r32_crt_100_cash_crm) {
		this.r32_crt_100_cash_crm = r32_crt_100_cash_crm;
	}
	public BigDecimal getR32_crt_100_cash_rwa() {
		return r32_crt_100_cash_rwa;
	}
	public void setR32_crt_100_cash_rwa(BigDecimal r32_crt_100_cash_rwa) {
		this.r32_crt_100_cash_rwa = r32_crt_100_cash_rwa;
	}
	public BigDecimal getR32_crt_100_tot_bal() {
		return r32_crt_100_tot_bal;
	}
	public void setR32_crt_100_tot_bal(BigDecimal r32_crt_100_tot_bal) {
		this.r32_crt_100_tot_bal = r32_crt_100_tot_bal;
	}
	public BigDecimal getR32_crt_100_tot_prov() {
		return r32_crt_100_tot_prov;
	}
	public void setR32_crt_100_tot_prov(BigDecimal r32_crt_100_tot_prov) {
		this.r32_crt_100_tot_prov = r32_crt_100_tot_prov;
	}
	public BigDecimal getR32_crt_100_tot_int_sus() {
		return r32_crt_100_tot_int_sus;
	}
	public void setR32_crt_100_tot_int_sus(BigDecimal r32_crt_100_tot_int_sus) {
		this.r32_crt_100_tot_int_sus = r32_crt_100_tot_int_sus;
	}
	public BigDecimal getR32_crt_100_tot_crm() {
		return r32_crt_100_tot_crm;
	}
	public void setR32_crt_100_tot_crm(BigDecimal r32_crt_100_tot_crm) {
		this.r32_crt_100_tot_crm = r32_crt_100_tot_crm;
	}
	public BigDecimal getR32_crt_100_tot_rwa() {
		return r32_crt_100_tot_rwa;
	}
	public void setR32_crt_100_tot_rwa(BigDecimal r32_crt_100_tot_rwa) {
		this.r32_crt_100_tot_rwa = r32_crt_100_tot_rwa;
	}
	public BigDecimal getR33_crt_150_loan_bal() {
		return r33_crt_150_loan_bal;
	}
	public void setR33_crt_150_loan_bal(BigDecimal r33_crt_150_loan_bal) {
		this.r33_crt_150_loan_bal = r33_crt_150_loan_bal;
	}
	public BigDecimal getR33_crt_150_loan_bill_amt() {
		return r33_crt_150_loan_bill_amt;
	}
	public void setR33_crt_150_loan_bill_amt(BigDecimal r33_crt_150_loan_bill_amt) {
		this.r33_crt_150_loan_bill_amt = r33_crt_150_loan_bill_amt;
	}
	public BigDecimal getR33_crt_150_loan_tot_bal() {
		return r33_crt_150_loan_tot_bal;
	}
	public void setR33_crt_150_loan_tot_bal(BigDecimal r33_crt_150_loan_tot_bal) {
		this.r33_crt_150_loan_tot_bal = r33_crt_150_loan_tot_bal;
	}
	public BigDecimal getR33_crt_150_loan_tot_prov() {
		return r33_crt_150_loan_tot_prov;
	}
	public void setR33_crt_150_loan_tot_prov(BigDecimal r33_crt_150_loan_tot_prov) {
		this.r33_crt_150_loan_tot_prov = r33_crt_150_loan_tot_prov;
	}
	public BigDecimal getR33_crt_150_loan_int_sus() {
		return r33_crt_150_loan_int_sus;
	}
	public void setR33_crt_150_loan_int_sus(BigDecimal r33_crt_150_loan_int_sus) {
		this.r33_crt_150_loan_int_sus = r33_crt_150_loan_int_sus;
	}
	public BigDecimal getR33_crt_150_loan_crm() {
		return r33_crt_150_loan_crm;
	}
	public void setR33_crt_150_loan_crm(BigDecimal r33_crt_150_loan_crm) {
		this.r33_crt_150_loan_crm = r33_crt_150_loan_crm;
	}
	public BigDecimal getR33_crt_150_loan_tot_dra() {
		return r33_crt_150_loan_tot_dra;
	}
	public void setR33_crt_150_loan_tot_dra(BigDecimal r33_crt_150_loan_tot_dra) {
		this.r33_crt_150_loan_tot_dra = r33_crt_150_loan_tot_dra;
	}
	public BigDecimal getR33_crt_150_inves_bal() {
		return r33_crt_150_inves_bal;
	}
	public void setR33_crt_150_inves_bal(BigDecimal r33_crt_150_inves_bal) {
		this.r33_crt_150_inves_bal = r33_crt_150_inves_bal;
	}
	public BigDecimal getR33_crt_150_inves_prov() {
		return r33_crt_150_inves_prov;
	}
	public void setR33_crt_150_inves_prov(BigDecimal r33_crt_150_inves_prov) {
		this.r33_crt_150_inves_prov = r33_crt_150_inves_prov;
	}
	public BigDecimal getR33_crt_150_inves_crm() {
		return r33_crt_150_inves_crm;
	}
	public void setR33_crt_150_inves_crm(BigDecimal r33_crt_150_inves_crm) {
		this.r33_crt_150_inves_crm = r33_crt_150_inves_crm;
	}
	public BigDecimal getR33_crt_150_inves_rwa() {
		return r33_crt_150_inves_rwa;
	}
	public void setR33_crt_150_inves_rwa(BigDecimal r33_crt_150_inves_rwa) {
		this.r33_crt_150_inves_rwa = r33_crt_150_inves_rwa;
	}
	public BigDecimal getR33_crt_150_plac_bal() {
		return r33_crt_150_plac_bal;
	}
	public void setR33_crt_150_plac_bal(BigDecimal r33_crt_150_plac_bal) {
		this.r33_crt_150_plac_bal = r33_crt_150_plac_bal;
	}
	public BigDecimal getR33_crt_150_plac_prov() {
		return r33_crt_150_plac_prov;
	}
	public void setR33_crt_150_plac_prov(BigDecimal r33_crt_150_plac_prov) {
		this.r33_crt_150_plac_prov = r33_crt_150_plac_prov;
	}
	public BigDecimal getR33_crt_150_plac_crm() {
		return r33_crt_150_plac_crm;
	}
	public void setR33_crt_150_plac_crm(BigDecimal r33_crt_150_plac_crm) {
		this.r33_crt_150_plac_crm = r33_crt_150_plac_crm;
	}
	public BigDecimal getR33_crt_150_plac_rwa() {
		return r33_crt_150_plac_rwa;
	}
	public void setR33_crt_150_plac_rwa(BigDecimal r33_crt_150_plac_rwa) {
		this.r33_crt_150_plac_rwa = r33_crt_150_plac_rwa;
	}
	public BigDecimal getR33_crt_150_cash_bal() {
		return r33_crt_150_cash_bal;
	}
	public void setR33_crt_150_cash_bal(BigDecimal r33_crt_150_cash_bal) {
		this.r33_crt_150_cash_bal = r33_crt_150_cash_bal;
	}
	public BigDecimal getR33_crt_150_cash_prov() {
		return r33_crt_150_cash_prov;
	}
	public void setR33_crt_150_cash_prov(BigDecimal r33_crt_150_cash_prov) {
		this.r33_crt_150_cash_prov = r33_crt_150_cash_prov;
	}
	public BigDecimal getR33_crt_150_cash_crm() {
		return r33_crt_150_cash_crm;
	}
	public void setR33_crt_150_cash_crm(BigDecimal r33_crt_150_cash_crm) {
		this.r33_crt_150_cash_crm = r33_crt_150_cash_crm;
	}
	public BigDecimal getR33_crt_150_cash_rwa() {
		return r33_crt_150_cash_rwa;
	}
	public void setR33_crt_150_cash_rwa(BigDecimal r33_crt_150_cash_rwa) {
		this.r33_crt_150_cash_rwa = r33_crt_150_cash_rwa;
	}
	public BigDecimal getR33_crt_150_tot_bal() {
		return r33_crt_150_tot_bal;
	}
	public void setR33_crt_150_tot_bal(BigDecimal r33_crt_150_tot_bal) {
		this.r33_crt_150_tot_bal = r33_crt_150_tot_bal;
	}
	public BigDecimal getR33_crt_150_tot_prov() {
		return r33_crt_150_tot_prov;
	}
	public void setR33_crt_150_tot_prov(BigDecimal r33_crt_150_tot_prov) {
		this.r33_crt_150_tot_prov = r33_crt_150_tot_prov;
	}
	public BigDecimal getR33_crt_150_tot_int_sus() {
		return r33_crt_150_tot_int_sus;
	}
	public void setR33_crt_150_tot_int_sus(BigDecimal r33_crt_150_tot_int_sus) {
		this.r33_crt_150_tot_int_sus = r33_crt_150_tot_int_sus;
	}
	public BigDecimal getR33_crt_150_tot_crm() {
		return r33_crt_150_tot_crm;
	}
	public void setR33_crt_150_tot_crm(BigDecimal r33_crt_150_tot_crm) {
		this.r33_crt_150_tot_crm = r33_crt_150_tot_crm;
	}
	public BigDecimal getR33_crt_150_tot_rwa() {
		return r33_crt_150_tot_rwa;
	}
	public void setR33_crt_150_tot_rwa(BigDecimal r33_crt_150_tot_rwa) {
		this.r33_crt_150_tot_rwa = r33_crt_150_tot_rwa;
	}
	public BigDecimal getR34_hni_100_loan_bal() {
		return r34_hni_100_loan_bal;
	}
	public void setR34_hni_100_loan_bal(BigDecimal r34_hni_100_loan_bal) {
		this.r34_hni_100_loan_bal = r34_hni_100_loan_bal;
	}
	public BigDecimal getR34_hni_100_loan_bill_amt() {
		return r34_hni_100_loan_bill_amt;
	}
	public void setR34_hni_100_loan_bill_amt(BigDecimal r34_hni_100_loan_bill_amt) {
		this.r34_hni_100_loan_bill_amt = r34_hni_100_loan_bill_amt;
	}
	public BigDecimal getR34_hni_100_loan_tot_bal() {
		return r34_hni_100_loan_tot_bal;
	}
	public void setR34_hni_100_loan_tot_bal(BigDecimal r34_hni_100_loan_tot_bal) {
		this.r34_hni_100_loan_tot_bal = r34_hni_100_loan_tot_bal;
	}
	public BigDecimal getR34_hni_100_loan_tot_prov() {
		return r34_hni_100_loan_tot_prov;
	}
	public void setR34_hni_100_loan_tot_prov(BigDecimal r34_hni_100_loan_tot_prov) {
		this.r34_hni_100_loan_tot_prov = r34_hni_100_loan_tot_prov;
	}
	public BigDecimal getR34_hni_100_loan_int_sus() {
		return r34_hni_100_loan_int_sus;
	}
	public void setR34_hni_100_loan_int_sus(BigDecimal r34_hni_100_loan_int_sus) {
		this.r34_hni_100_loan_int_sus = r34_hni_100_loan_int_sus;
	}
	public BigDecimal getR34_hni_100_loan_crm() {
		return r34_hni_100_loan_crm;
	}
	public void setR34_hni_100_loan_crm(BigDecimal r34_hni_100_loan_crm) {
		this.r34_hni_100_loan_crm = r34_hni_100_loan_crm;
	}
	public BigDecimal getR34_hni_100_loan_tot_dra() {
		return r34_hni_100_loan_tot_dra;
	}
	public void setR34_hni_100_loan_tot_dra(BigDecimal r34_hni_100_loan_tot_dra) {
		this.r34_hni_100_loan_tot_dra = r34_hni_100_loan_tot_dra;
	}
	public BigDecimal getR34_hni_100_inves_bal() {
		return r34_hni_100_inves_bal;
	}
	public void setR34_hni_100_inves_bal(BigDecimal r34_hni_100_inves_bal) {
		this.r34_hni_100_inves_bal = r34_hni_100_inves_bal;
	}
	public BigDecimal getR34_hni_100_inves_prov() {
		return r34_hni_100_inves_prov;
	}
	public void setR34_hni_100_inves_prov(BigDecimal r34_hni_100_inves_prov) {
		this.r34_hni_100_inves_prov = r34_hni_100_inves_prov;
	}
	public BigDecimal getR34_hni_100_inves_crm() {
		return r34_hni_100_inves_crm;
	}
	public void setR34_hni_100_inves_crm(BigDecimal r34_hni_100_inves_crm) {
		this.r34_hni_100_inves_crm = r34_hni_100_inves_crm;
	}
	public BigDecimal getR34_hni_100_inves_rwa() {
		return r34_hni_100_inves_rwa;
	}
	public void setR34_hni_100_inves_rwa(BigDecimal r34_hni_100_inves_rwa) {
		this.r34_hni_100_inves_rwa = r34_hni_100_inves_rwa;
	}
	public BigDecimal getR34_hni_100_plac_bal() {
		return r34_hni_100_plac_bal;
	}
	public void setR34_hni_100_plac_bal(BigDecimal r34_hni_100_plac_bal) {
		this.r34_hni_100_plac_bal = r34_hni_100_plac_bal;
	}
	public BigDecimal getR34_hni_100_plac_prov() {
		return r34_hni_100_plac_prov;
	}
	public void setR34_hni_100_plac_prov(BigDecimal r34_hni_100_plac_prov) {
		this.r34_hni_100_plac_prov = r34_hni_100_plac_prov;
	}
	public BigDecimal getR34_hni_100_plac_crm() {
		return r34_hni_100_plac_crm;
	}
	public void setR34_hni_100_plac_crm(BigDecimal r34_hni_100_plac_crm) {
		this.r34_hni_100_plac_crm = r34_hni_100_plac_crm;
	}
	public BigDecimal getR34_hni_100_plac_rwa() {
		return r34_hni_100_plac_rwa;
	}
	public void setR34_hni_100_plac_rwa(BigDecimal r34_hni_100_plac_rwa) {
		this.r34_hni_100_plac_rwa = r34_hni_100_plac_rwa;
	}
	public BigDecimal getR34_hni_100_cash_bal() {
		return r34_hni_100_cash_bal;
	}
	public void setR34_hni_100_cash_bal(BigDecimal r34_hni_100_cash_bal) {
		this.r34_hni_100_cash_bal = r34_hni_100_cash_bal;
	}
	public BigDecimal getR34_hni_100_cash_prov() {
		return r34_hni_100_cash_prov;
	}
	public void setR34_hni_100_cash_prov(BigDecimal r34_hni_100_cash_prov) {
		this.r34_hni_100_cash_prov = r34_hni_100_cash_prov;
	}
	public BigDecimal getR34_hni_100_cash_crm() {
		return r34_hni_100_cash_crm;
	}
	public void setR34_hni_100_cash_crm(BigDecimal r34_hni_100_cash_crm) {
		this.r34_hni_100_cash_crm = r34_hni_100_cash_crm;
	}
	public BigDecimal getR34_hni_100_cash_rwa() {
		return r34_hni_100_cash_rwa;
	}
	public void setR34_hni_100_cash_rwa(BigDecimal r34_hni_100_cash_rwa) {
		this.r34_hni_100_cash_rwa = r34_hni_100_cash_rwa;
	}
	public BigDecimal getR34_hni_100_tot_bal() {
		return r34_hni_100_tot_bal;
	}
	public void setR34_hni_100_tot_bal(BigDecimal r34_hni_100_tot_bal) {
		this.r34_hni_100_tot_bal = r34_hni_100_tot_bal;
	}
	public BigDecimal getR34_hni_100_tot_prov() {
		return r34_hni_100_tot_prov;
	}
	public void setR34_hni_100_tot_prov(BigDecimal r34_hni_100_tot_prov) {
		this.r34_hni_100_tot_prov = r34_hni_100_tot_prov;
	}
	public BigDecimal getR34_hni_100_tot_int_sus() {
		return r34_hni_100_tot_int_sus;
	}
	public void setR34_hni_100_tot_int_sus(BigDecimal r34_hni_100_tot_int_sus) {
		this.r34_hni_100_tot_int_sus = r34_hni_100_tot_int_sus;
	}
	public BigDecimal getR34_hni_100_tot_crm() {
		return r34_hni_100_tot_crm;
	}
	public void setR34_hni_100_tot_crm(BigDecimal r34_hni_100_tot_crm) {
		this.r34_hni_100_tot_crm = r34_hni_100_tot_crm;
	}
	public BigDecimal getR34_hni_100_tot_rwa() {
		return r34_hni_100_tot_rwa;
	}
	public void setR34_hni_100_tot_rwa(BigDecimal r34_hni_100_tot_rwa) {
		this.r34_hni_100_tot_rwa = r34_hni_100_tot_rwa;
	}
	public BigDecimal getR35_pdl_100_loan_bal() {
		return r35_pdl_100_loan_bal;
	}
	public void setR35_pdl_100_loan_bal(BigDecimal r35_pdl_100_loan_bal) {
		this.r35_pdl_100_loan_bal = r35_pdl_100_loan_bal;
	}
	public BigDecimal getR35_pdl_100_loan_bill_amt() {
		return r35_pdl_100_loan_bill_amt;
	}
	public void setR35_pdl_100_loan_bill_amt(BigDecimal r35_pdl_100_loan_bill_amt) {
		this.r35_pdl_100_loan_bill_amt = r35_pdl_100_loan_bill_amt;
	}
	public BigDecimal getR35_pdl_100_loan_tot_bal() {
		return r35_pdl_100_loan_tot_bal;
	}
	public void setR35_pdl_100_loan_tot_bal(BigDecimal r35_pdl_100_loan_tot_bal) {
		this.r35_pdl_100_loan_tot_bal = r35_pdl_100_loan_tot_bal;
	}
	public BigDecimal getR35_pdl_100_loan_tot_prov() {
		return r35_pdl_100_loan_tot_prov;
	}
	public void setR35_pdl_100_loan_tot_prov(BigDecimal r35_pdl_100_loan_tot_prov) {
		this.r35_pdl_100_loan_tot_prov = r35_pdl_100_loan_tot_prov;
	}
	public BigDecimal getR35_pdl_100_loan_int_sus() {
		return r35_pdl_100_loan_int_sus;
	}
	public void setR35_pdl_100_loan_int_sus(BigDecimal r35_pdl_100_loan_int_sus) {
		this.r35_pdl_100_loan_int_sus = r35_pdl_100_loan_int_sus;
	}
	public BigDecimal getR35_pdl_100_loan_crm() {
		return r35_pdl_100_loan_crm;
	}
	public void setR35_pdl_100_loan_crm(BigDecimal r35_pdl_100_loan_crm) {
		this.r35_pdl_100_loan_crm = r35_pdl_100_loan_crm;
	}
	public BigDecimal getR35_pdl_100_loan_tot_dra() {
		return r35_pdl_100_loan_tot_dra;
	}
	public void setR35_pdl_100_loan_tot_dra(BigDecimal r35_pdl_100_loan_tot_dra) {
		this.r35_pdl_100_loan_tot_dra = r35_pdl_100_loan_tot_dra;
	}
	public BigDecimal getR35_pdl_100_inves_bal() {
		return r35_pdl_100_inves_bal;
	}
	public void setR35_pdl_100_inves_bal(BigDecimal r35_pdl_100_inves_bal) {
		this.r35_pdl_100_inves_bal = r35_pdl_100_inves_bal;
	}
	public BigDecimal getR35_pdl_100_inves_prov() {
		return r35_pdl_100_inves_prov;
	}
	public void setR35_pdl_100_inves_prov(BigDecimal r35_pdl_100_inves_prov) {
		this.r35_pdl_100_inves_prov = r35_pdl_100_inves_prov;
	}
	public BigDecimal getR35_pdl_100_inves_crm() {
		return r35_pdl_100_inves_crm;
	}
	public void setR35_pdl_100_inves_crm(BigDecimal r35_pdl_100_inves_crm) {
		this.r35_pdl_100_inves_crm = r35_pdl_100_inves_crm;
	}
	public BigDecimal getR35_pdl_100_inves_rwa() {
		return r35_pdl_100_inves_rwa;
	}
	public void setR35_pdl_100_inves_rwa(BigDecimal r35_pdl_100_inves_rwa) {
		this.r35_pdl_100_inves_rwa = r35_pdl_100_inves_rwa;
	}
	public BigDecimal getR35_pdl_100_plac_bal() {
		return r35_pdl_100_plac_bal;
	}
	public void setR35_pdl_100_plac_bal(BigDecimal r35_pdl_100_plac_bal) {
		this.r35_pdl_100_plac_bal = r35_pdl_100_plac_bal;
	}
	public BigDecimal getR35_pdl_100_plac_prov() {
		return r35_pdl_100_plac_prov;
	}
	public void setR35_pdl_100_plac_prov(BigDecimal r35_pdl_100_plac_prov) {
		this.r35_pdl_100_plac_prov = r35_pdl_100_plac_prov;
	}
	public BigDecimal getR35_pdl_100_plac_crm() {
		return r35_pdl_100_plac_crm;
	}
	public void setR35_pdl_100_plac_crm(BigDecimal r35_pdl_100_plac_crm) {
		this.r35_pdl_100_plac_crm = r35_pdl_100_plac_crm;
	}
	public BigDecimal getR35_pdl_100_plac_rwa() {
		return r35_pdl_100_plac_rwa;
	}
	public void setR35_pdl_100_plac_rwa(BigDecimal r35_pdl_100_plac_rwa) {
		this.r35_pdl_100_plac_rwa = r35_pdl_100_plac_rwa;
	}
	public BigDecimal getR35_pdl_100_cash_bal() {
		return r35_pdl_100_cash_bal;
	}
	public void setR35_pdl_100_cash_bal(BigDecimal r35_pdl_100_cash_bal) {
		this.r35_pdl_100_cash_bal = r35_pdl_100_cash_bal;
	}
	public BigDecimal getR35_pdl_100_cash_prov() {
		return r35_pdl_100_cash_prov;
	}
	public void setR35_pdl_100_cash_prov(BigDecimal r35_pdl_100_cash_prov) {
		this.r35_pdl_100_cash_prov = r35_pdl_100_cash_prov;
	}
	public BigDecimal getR35_pdl_100_cash_crm() {
		return r35_pdl_100_cash_crm;
	}
	public void setR35_pdl_100_cash_crm(BigDecimal r35_pdl_100_cash_crm) {
		this.r35_pdl_100_cash_crm = r35_pdl_100_cash_crm;
	}
	public BigDecimal getR35_pdl_100_cash_rwa() {
		return r35_pdl_100_cash_rwa;
	}
	public void setR35_pdl_100_cash_rwa(BigDecimal r35_pdl_100_cash_rwa) {
		this.r35_pdl_100_cash_rwa = r35_pdl_100_cash_rwa;
	}
	public BigDecimal getR35_pdl_100_tot_bal() {
		return r35_pdl_100_tot_bal;
	}
	public void setR35_pdl_100_tot_bal(BigDecimal r35_pdl_100_tot_bal) {
		this.r35_pdl_100_tot_bal = r35_pdl_100_tot_bal;
	}
	public BigDecimal getR35_pdl_100_tot_prov() {
		return r35_pdl_100_tot_prov;
	}
	public void setR35_pdl_100_tot_prov(BigDecimal r35_pdl_100_tot_prov) {
		this.r35_pdl_100_tot_prov = r35_pdl_100_tot_prov;
	}
	public BigDecimal getR35_pdl_100_tot_int_sus() {
		return r35_pdl_100_tot_int_sus;
	}
	public void setR35_pdl_100_tot_int_sus(BigDecimal r35_pdl_100_tot_int_sus) {
		this.r35_pdl_100_tot_int_sus = r35_pdl_100_tot_int_sus;
	}
	public BigDecimal getR35_pdl_100_tot_crm() {
		return r35_pdl_100_tot_crm;
	}
	public void setR35_pdl_100_tot_crm(BigDecimal r35_pdl_100_tot_crm) {
		this.r35_pdl_100_tot_crm = r35_pdl_100_tot_crm;
	}
	public BigDecimal getR35_pdl_100_tot_rwa() {
		return r35_pdl_100_tot_rwa;
	}
	public void setR35_pdl_100_tot_rwa(BigDecimal r35_pdl_100_tot_rwa) {
		this.r35_pdl_100_tot_rwa = r35_pdl_100_tot_rwa;
	}
	public BigDecimal getR36_pdl_150_loan_bal() {
		return r36_pdl_150_loan_bal;
	}
	public void setR36_pdl_150_loan_bal(BigDecimal r36_pdl_150_loan_bal) {
		this.r36_pdl_150_loan_bal = r36_pdl_150_loan_bal;
	}
	public BigDecimal getR36_pdl_150_loan_bill_amt() {
		return r36_pdl_150_loan_bill_amt;
	}
	public void setR36_pdl_150_loan_bill_amt(BigDecimal r36_pdl_150_loan_bill_amt) {
		this.r36_pdl_150_loan_bill_amt = r36_pdl_150_loan_bill_amt;
	}
	public BigDecimal getR36_pdl_150_loan_tot_bal() {
		return r36_pdl_150_loan_tot_bal;
	}
	public void setR36_pdl_150_loan_tot_bal(BigDecimal r36_pdl_150_loan_tot_bal) {
		this.r36_pdl_150_loan_tot_bal = r36_pdl_150_loan_tot_bal;
	}
	public BigDecimal getR36_pdl_150_loan_tot_prov() {
		return r36_pdl_150_loan_tot_prov;
	}
	public void setR36_pdl_150_loan_tot_prov(BigDecimal r36_pdl_150_loan_tot_prov) {
		this.r36_pdl_150_loan_tot_prov = r36_pdl_150_loan_tot_prov;
	}
	public BigDecimal getR36_pdl_150_loan_int_sus() {
		return r36_pdl_150_loan_int_sus;
	}
	public void setR36_pdl_150_loan_int_sus(BigDecimal r36_pdl_150_loan_int_sus) {
		this.r36_pdl_150_loan_int_sus = r36_pdl_150_loan_int_sus;
	}
	public BigDecimal getR36_pdl_150_loan_crm() {
		return r36_pdl_150_loan_crm;
	}
	public void setR36_pdl_150_loan_crm(BigDecimal r36_pdl_150_loan_crm) {
		this.r36_pdl_150_loan_crm = r36_pdl_150_loan_crm;
	}
	public BigDecimal getR36_pdl_150_loan_tot_dra() {
		return r36_pdl_150_loan_tot_dra;
	}
	public void setR36_pdl_150_loan_tot_dra(BigDecimal r36_pdl_150_loan_tot_dra) {
		this.r36_pdl_150_loan_tot_dra = r36_pdl_150_loan_tot_dra;
	}
	public BigDecimal getR36_pdl_150_inves_bal() {
		return r36_pdl_150_inves_bal;
	}
	public void setR36_pdl_150_inves_bal(BigDecimal r36_pdl_150_inves_bal) {
		this.r36_pdl_150_inves_bal = r36_pdl_150_inves_bal;
	}
	public BigDecimal getR36_pdl_150_inves_prov() {
		return r36_pdl_150_inves_prov;
	}
	public void setR36_pdl_150_inves_prov(BigDecimal r36_pdl_150_inves_prov) {
		this.r36_pdl_150_inves_prov = r36_pdl_150_inves_prov;
	}
	public BigDecimal getR36_pdl_150_inves_crm() {
		return r36_pdl_150_inves_crm;
	}
	public void setR36_pdl_150_inves_crm(BigDecimal r36_pdl_150_inves_crm) {
		this.r36_pdl_150_inves_crm = r36_pdl_150_inves_crm;
	}
	public BigDecimal getR36_pdl_150_inves_rwa() {
		return r36_pdl_150_inves_rwa;
	}
	public void setR36_pdl_150_inves_rwa(BigDecimal r36_pdl_150_inves_rwa) {
		this.r36_pdl_150_inves_rwa = r36_pdl_150_inves_rwa;
	}
	public BigDecimal getR36_pdl_150_plac_bal() {
		return r36_pdl_150_plac_bal;
	}
	public void setR36_pdl_150_plac_bal(BigDecimal r36_pdl_150_plac_bal) {
		this.r36_pdl_150_plac_bal = r36_pdl_150_plac_bal;
	}
	public BigDecimal getR36_pdl_150_plac_prov() {
		return r36_pdl_150_plac_prov;
	}
	public void setR36_pdl_150_plac_prov(BigDecimal r36_pdl_150_plac_prov) {
		this.r36_pdl_150_plac_prov = r36_pdl_150_plac_prov;
	}
	public BigDecimal getR36_pdl_150_plac_crm() {
		return r36_pdl_150_plac_crm;
	}
	public void setR36_pdl_150_plac_crm(BigDecimal r36_pdl_150_plac_crm) {
		this.r36_pdl_150_plac_crm = r36_pdl_150_plac_crm;
	}
	public BigDecimal getR36_pdl_150_plac_rwa() {
		return r36_pdl_150_plac_rwa;
	}
	public void setR36_pdl_150_plac_rwa(BigDecimal r36_pdl_150_plac_rwa) {
		this.r36_pdl_150_plac_rwa = r36_pdl_150_plac_rwa;
	}
	public BigDecimal getR36_pdl_150_cash_bal() {
		return r36_pdl_150_cash_bal;
	}
	public void setR36_pdl_150_cash_bal(BigDecimal r36_pdl_150_cash_bal) {
		this.r36_pdl_150_cash_bal = r36_pdl_150_cash_bal;
	}
	public BigDecimal getR36_pdl_150_cash_prov() {
		return r36_pdl_150_cash_prov;
	}
	public void setR36_pdl_150_cash_prov(BigDecimal r36_pdl_150_cash_prov) {
		this.r36_pdl_150_cash_prov = r36_pdl_150_cash_prov;
	}
	public BigDecimal getR36_pdl_150_cash_crm() {
		return r36_pdl_150_cash_crm;
	}
	public void setR36_pdl_150_cash_crm(BigDecimal r36_pdl_150_cash_crm) {
		this.r36_pdl_150_cash_crm = r36_pdl_150_cash_crm;
	}
	public BigDecimal getR36_pdl_150_cash_rwa() {
		return r36_pdl_150_cash_rwa;
	}
	public void setR36_pdl_150_cash_rwa(BigDecimal r36_pdl_150_cash_rwa) {
		this.r36_pdl_150_cash_rwa = r36_pdl_150_cash_rwa;
	}
	public BigDecimal getR36_pdl_150_tot_bal() {
		return r36_pdl_150_tot_bal;
	}
	public void setR36_pdl_150_tot_bal(BigDecimal r36_pdl_150_tot_bal) {
		this.r36_pdl_150_tot_bal = r36_pdl_150_tot_bal;
	}
	public BigDecimal getR36_pdl_150_tot_prov() {
		return r36_pdl_150_tot_prov;
	}
	public void setR36_pdl_150_tot_prov(BigDecimal r36_pdl_150_tot_prov) {
		this.r36_pdl_150_tot_prov = r36_pdl_150_tot_prov;
	}
	public BigDecimal getR36_pdl_150_tot_int_sus() {
		return r36_pdl_150_tot_int_sus;
	}
	public void setR36_pdl_150_tot_int_sus(BigDecimal r36_pdl_150_tot_int_sus) {
		this.r36_pdl_150_tot_int_sus = r36_pdl_150_tot_int_sus;
	}
	public BigDecimal getR36_pdl_150_tot_crm() {
		return r36_pdl_150_tot_crm;
	}
	public void setR36_pdl_150_tot_crm(BigDecimal r36_pdl_150_tot_crm) {
		this.r36_pdl_150_tot_crm = r36_pdl_150_tot_crm;
	}
	public BigDecimal getR36_pdl_150_tot_rwa() {
		return r36_pdl_150_tot_rwa;
	}
	public void setR36_pdl_150_tot_rwa(BigDecimal r36_pdl_150_tot_rwa) {
		this.r36_pdl_150_tot_rwa = r36_pdl_150_tot_rwa;
	}
	public BigDecimal getR37_pse_0_loan_bal() {
		return r37_pse_0_loan_bal;
	}
	public void setR37_pse_0_loan_bal(BigDecimal r37_pse_0_loan_bal) {
		this.r37_pse_0_loan_bal = r37_pse_0_loan_bal;
	}
	public BigDecimal getR37_pse_0_loan_bill_amt() {
		return r37_pse_0_loan_bill_amt;
	}
	public void setR37_pse_0_loan_bill_amt(BigDecimal r37_pse_0_loan_bill_amt) {
		this.r37_pse_0_loan_bill_amt = r37_pse_0_loan_bill_amt;
	}
	public BigDecimal getR37_pse_0_loan_tot_bal() {
		return r37_pse_0_loan_tot_bal;
	}
	public void setR37_pse_0_loan_tot_bal(BigDecimal r37_pse_0_loan_tot_bal) {
		this.r37_pse_0_loan_tot_bal = r37_pse_0_loan_tot_bal;
	}
	public BigDecimal getR37_pse_0_loan_tot_prov() {
		return r37_pse_0_loan_tot_prov;
	}
	public void setR37_pse_0_loan_tot_prov(BigDecimal r37_pse_0_loan_tot_prov) {
		this.r37_pse_0_loan_tot_prov = r37_pse_0_loan_tot_prov;
	}
	public BigDecimal getR37_pse_0_loan_int_sus() {
		return r37_pse_0_loan_int_sus;
	}
	public void setR37_pse_0_loan_int_sus(BigDecimal r37_pse_0_loan_int_sus) {
		this.r37_pse_0_loan_int_sus = r37_pse_0_loan_int_sus;
	}
	public BigDecimal getR37_pse_0_loan_crm() {
		return r37_pse_0_loan_crm;
	}
	public void setR37_pse_0_loan_crm(BigDecimal r37_pse_0_loan_crm) {
		this.r37_pse_0_loan_crm = r37_pse_0_loan_crm;
	}
	public BigDecimal getR37_pse_0_loan_tot_dra() {
		return r37_pse_0_loan_tot_dra;
	}
	public void setR37_pse_0_loan_tot_dra(BigDecimal r37_pse_0_loan_tot_dra) {
		this.r37_pse_0_loan_tot_dra = r37_pse_0_loan_tot_dra;
	}
	public BigDecimal getR37_pse_0_inves_bal() {
		return r37_pse_0_inves_bal;
	}
	public void setR37_pse_0_inves_bal(BigDecimal r37_pse_0_inves_bal) {
		this.r37_pse_0_inves_bal = r37_pse_0_inves_bal;
	}
	public BigDecimal getR37_pse_0_inves_prov() {
		return r37_pse_0_inves_prov;
	}
	public void setR37_pse_0_inves_prov(BigDecimal r37_pse_0_inves_prov) {
		this.r37_pse_0_inves_prov = r37_pse_0_inves_prov;
	}
	public BigDecimal getR37_pse_0_inves_crm() {
		return r37_pse_0_inves_crm;
	}
	public void setR37_pse_0_inves_crm(BigDecimal r37_pse_0_inves_crm) {
		this.r37_pse_0_inves_crm = r37_pse_0_inves_crm;
	}
	public BigDecimal getR37_pse_0_inves_rwa() {
		return r37_pse_0_inves_rwa;
	}
	public void setR37_pse_0_inves_rwa(BigDecimal r37_pse_0_inves_rwa) {
		this.r37_pse_0_inves_rwa = r37_pse_0_inves_rwa;
	}
	public BigDecimal getR37_pse_0_plac_bal() {
		return r37_pse_0_plac_bal;
	}
	public void setR37_pse_0_plac_bal(BigDecimal r37_pse_0_plac_bal) {
		this.r37_pse_0_plac_bal = r37_pse_0_plac_bal;
	}
	public BigDecimal getR37_pse_0_plac_prov() {
		return r37_pse_0_plac_prov;
	}
	public void setR37_pse_0_plac_prov(BigDecimal r37_pse_0_plac_prov) {
		this.r37_pse_0_plac_prov = r37_pse_0_plac_prov;
	}
	public BigDecimal getR37_pse_0_plac_crm() {
		return r37_pse_0_plac_crm;
	}
	public void setR37_pse_0_plac_crm(BigDecimal r37_pse_0_plac_crm) {
		this.r37_pse_0_plac_crm = r37_pse_0_plac_crm;
	}
	public BigDecimal getR37_pse_0_plac_rwa() {
		return r37_pse_0_plac_rwa;
	}
	public void setR37_pse_0_plac_rwa(BigDecimal r37_pse_0_plac_rwa) {
		this.r37_pse_0_plac_rwa = r37_pse_0_plac_rwa;
	}
	public BigDecimal getR37_pse_0_cash_bal() {
		return r37_pse_0_cash_bal;
	}
	public void setR37_pse_0_cash_bal(BigDecimal r37_pse_0_cash_bal) {
		this.r37_pse_0_cash_bal = r37_pse_0_cash_bal;
	}
	public BigDecimal getR37_pse_0_cash_prov() {
		return r37_pse_0_cash_prov;
	}
	public void setR37_pse_0_cash_prov(BigDecimal r37_pse_0_cash_prov) {
		this.r37_pse_0_cash_prov = r37_pse_0_cash_prov;
	}
	public BigDecimal getR37_pse_0_cash_crm() {
		return r37_pse_0_cash_crm;
	}
	public void setR37_pse_0_cash_crm(BigDecimal r37_pse_0_cash_crm) {
		this.r37_pse_0_cash_crm = r37_pse_0_cash_crm;
	}
	public BigDecimal getR37_pse_0_cash_rwa() {
		return r37_pse_0_cash_rwa;
	}
	public void setR37_pse_0_cash_rwa(BigDecimal r37_pse_0_cash_rwa) {
		this.r37_pse_0_cash_rwa = r37_pse_0_cash_rwa;
	}
	public BigDecimal getR37_pse_0_tot_bal() {
		return r37_pse_0_tot_bal;
	}
	public void setR37_pse_0_tot_bal(BigDecimal r37_pse_0_tot_bal) {
		this.r37_pse_0_tot_bal = r37_pse_0_tot_bal;
	}
	public BigDecimal getR37_pse_0_tot_prov() {
		return r37_pse_0_tot_prov;
	}
	public void setR37_pse_0_tot_prov(BigDecimal r37_pse_0_tot_prov) {
		this.r37_pse_0_tot_prov = r37_pse_0_tot_prov;
	}
	public BigDecimal getR37_pse_0_tot_int_sus() {
		return r37_pse_0_tot_int_sus;
	}
	public void setR37_pse_0_tot_int_sus(BigDecimal r37_pse_0_tot_int_sus) {
		this.r37_pse_0_tot_int_sus = r37_pse_0_tot_int_sus;
	}
	public BigDecimal getR37_pse_0_tot_crm() {
		return r37_pse_0_tot_crm;
	}
	public void setR37_pse_0_tot_crm(BigDecimal r37_pse_0_tot_crm) {
		this.r37_pse_0_tot_crm = r37_pse_0_tot_crm;
	}
	public BigDecimal getR37_pse_0_tot_rwa() {
		return r37_pse_0_tot_rwa;
	}
	public void setR37_pse_0_tot_rwa(BigDecimal r37_pse_0_tot_rwa) {
		this.r37_pse_0_tot_rwa = r37_pse_0_tot_rwa;
	}
	public BigDecimal getR38_pse_20_loan_bal() {
		return r38_pse_20_loan_bal;
	}
	public void setR38_pse_20_loan_bal(BigDecimal r38_pse_20_loan_bal) {
		this.r38_pse_20_loan_bal = r38_pse_20_loan_bal;
	}
	public BigDecimal getR38_pse_20_loan_bill_amt() {
		return r38_pse_20_loan_bill_amt;
	}
	public void setR38_pse_20_loan_bill_amt(BigDecimal r38_pse_20_loan_bill_amt) {
		this.r38_pse_20_loan_bill_amt = r38_pse_20_loan_bill_amt;
	}
	public BigDecimal getR38_pse_20_loan_tot_bal() {
		return r38_pse_20_loan_tot_bal;
	}
	public void setR38_pse_20_loan_tot_bal(BigDecimal r38_pse_20_loan_tot_bal) {
		this.r38_pse_20_loan_tot_bal = r38_pse_20_loan_tot_bal;
	}
	public BigDecimal getR38_pse_20_loan_tot_prov() {
		return r38_pse_20_loan_tot_prov;
	}
	public void setR38_pse_20_loan_tot_prov(BigDecimal r38_pse_20_loan_tot_prov) {
		this.r38_pse_20_loan_tot_prov = r38_pse_20_loan_tot_prov;
	}
	public BigDecimal getR38_pse_20_loan_int_sus() {
		return r38_pse_20_loan_int_sus;
	}
	public void setR38_pse_20_loan_int_sus(BigDecimal r38_pse_20_loan_int_sus) {
		this.r38_pse_20_loan_int_sus = r38_pse_20_loan_int_sus;
	}
	public BigDecimal getR38_pse_20_loan_crm() {
		return r38_pse_20_loan_crm;
	}
	public void setR38_pse_20_loan_crm(BigDecimal r38_pse_20_loan_crm) {
		this.r38_pse_20_loan_crm = r38_pse_20_loan_crm;
	}
	public BigDecimal getR38_pse_20_loan_tot_dra() {
		return r38_pse_20_loan_tot_dra;
	}
	public void setR38_pse_20_loan_tot_dra(BigDecimal r38_pse_20_loan_tot_dra) {
		this.r38_pse_20_loan_tot_dra = r38_pse_20_loan_tot_dra;
	}
	public BigDecimal getR38_pse_20_inves_bal() {
		return r38_pse_20_inves_bal;
	}
	public void setR38_pse_20_inves_bal(BigDecimal r38_pse_20_inves_bal) {
		this.r38_pse_20_inves_bal = r38_pse_20_inves_bal;
	}
	public BigDecimal getR38_pse_20_inves_prov() {
		return r38_pse_20_inves_prov;
	}
	public void setR38_pse_20_inves_prov(BigDecimal r38_pse_20_inves_prov) {
		this.r38_pse_20_inves_prov = r38_pse_20_inves_prov;
	}
	public BigDecimal getR38_pse_20_inves_crm() {
		return r38_pse_20_inves_crm;
	}
	public void setR38_pse_20_inves_crm(BigDecimal r38_pse_20_inves_crm) {
		this.r38_pse_20_inves_crm = r38_pse_20_inves_crm;
	}
	public BigDecimal getR38_pse_20_inves_rwa() {
		return r38_pse_20_inves_rwa;
	}
	public void setR38_pse_20_inves_rwa(BigDecimal r38_pse_20_inves_rwa) {
		this.r38_pse_20_inves_rwa = r38_pse_20_inves_rwa;
	}
	public BigDecimal getR38_pse_20_plac_bal() {
		return r38_pse_20_plac_bal;
	}
	public void setR38_pse_20_plac_bal(BigDecimal r38_pse_20_plac_bal) {
		this.r38_pse_20_plac_bal = r38_pse_20_plac_bal;
	}
	public BigDecimal getR38_pse_20_plac_prov() {
		return r38_pse_20_plac_prov;
	}
	public void setR38_pse_20_plac_prov(BigDecimal r38_pse_20_plac_prov) {
		this.r38_pse_20_plac_prov = r38_pse_20_plac_prov;
	}
	public BigDecimal getR38_pse_20_plac_crm() {
		return r38_pse_20_plac_crm;
	}
	public void setR38_pse_20_plac_crm(BigDecimal r38_pse_20_plac_crm) {
		this.r38_pse_20_plac_crm = r38_pse_20_plac_crm;
	}
	public BigDecimal getR38_pse_20_plac_rwa() {
		return r38_pse_20_plac_rwa;
	}
	public void setR38_pse_20_plac_rwa(BigDecimal r38_pse_20_plac_rwa) {
		this.r38_pse_20_plac_rwa = r38_pse_20_plac_rwa;
	}
	public BigDecimal getR38_pse_20_cash_bal() {
		return r38_pse_20_cash_bal;
	}
	public void setR38_pse_20_cash_bal(BigDecimal r38_pse_20_cash_bal) {
		this.r38_pse_20_cash_bal = r38_pse_20_cash_bal;
	}
	public BigDecimal getR38_pse_20_cash_prov() {
		return r38_pse_20_cash_prov;
	}
	public void setR38_pse_20_cash_prov(BigDecimal r38_pse_20_cash_prov) {
		this.r38_pse_20_cash_prov = r38_pse_20_cash_prov;
	}
	public BigDecimal getR38_pse_20_cash_crm() {
		return r38_pse_20_cash_crm;
	}
	public void setR38_pse_20_cash_crm(BigDecimal r38_pse_20_cash_crm) {
		this.r38_pse_20_cash_crm = r38_pse_20_cash_crm;
	}
	public BigDecimal getR38_pse_20_cash_rwa() {
		return r38_pse_20_cash_rwa;
	}
	public void setR38_pse_20_cash_rwa(BigDecimal r38_pse_20_cash_rwa) {
		this.r38_pse_20_cash_rwa = r38_pse_20_cash_rwa;
	}
	public BigDecimal getR38_pse_20_tot_bal() {
		return r38_pse_20_tot_bal;
	}
	public void setR38_pse_20_tot_bal(BigDecimal r38_pse_20_tot_bal) {
		this.r38_pse_20_tot_bal = r38_pse_20_tot_bal;
	}
	public BigDecimal getR38_pse_20_tot_prov() {
		return r38_pse_20_tot_prov;
	}
	public void setR38_pse_20_tot_prov(BigDecimal r38_pse_20_tot_prov) {
		this.r38_pse_20_tot_prov = r38_pse_20_tot_prov;
	}
	public BigDecimal getR38_pse_20_tot_int_sus() {
		return r38_pse_20_tot_int_sus;
	}
	public void setR38_pse_20_tot_int_sus(BigDecimal r38_pse_20_tot_int_sus) {
		this.r38_pse_20_tot_int_sus = r38_pse_20_tot_int_sus;
	}
	public BigDecimal getR38_pse_20_tot_crm() {
		return r38_pse_20_tot_crm;
	}
	public void setR38_pse_20_tot_crm(BigDecimal r38_pse_20_tot_crm) {
		this.r38_pse_20_tot_crm = r38_pse_20_tot_crm;
	}
	public BigDecimal getR38_pse_20_tot_rwa() {
		return r38_pse_20_tot_rwa;
	}
	public void setR38_pse_20_tot_rwa(BigDecimal r38_pse_20_tot_rwa) {
		this.r38_pse_20_tot_rwa = r38_pse_20_tot_rwa;
	}
	public BigDecimal getR39_pse_50_loan_bal() {
		return r39_pse_50_loan_bal;
	}
	public void setR39_pse_50_loan_bal(BigDecimal r39_pse_50_loan_bal) {
		this.r39_pse_50_loan_bal = r39_pse_50_loan_bal;
	}
	public BigDecimal getR39_pse_50_loan_bill_amt() {
		return r39_pse_50_loan_bill_amt;
	}
	public void setR39_pse_50_loan_bill_amt(BigDecimal r39_pse_50_loan_bill_amt) {
		this.r39_pse_50_loan_bill_amt = r39_pse_50_loan_bill_amt;
	}
	public BigDecimal getR39_pse_50_loan_tot_bal() {
		return r39_pse_50_loan_tot_bal;
	}
	public void setR39_pse_50_loan_tot_bal(BigDecimal r39_pse_50_loan_tot_bal) {
		this.r39_pse_50_loan_tot_bal = r39_pse_50_loan_tot_bal;
	}
	public BigDecimal getR39_pse_50_loan_tot_prov() {
		return r39_pse_50_loan_tot_prov;
	}
	public void setR39_pse_50_loan_tot_prov(BigDecimal r39_pse_50_loan_tot_prov) {
		this.r39_pse_50_loan_tot_prov = r39_pse_50_loan_tot_prov;
	}
	public BigDecimal getR39_pse_50_loan_int_sus() {
		return r39_pse_50_loan_int_sus;
	}
	public void setR39_pse_50_loan_int_sus(BigDecimal r39_pse_50_loan_int_sus) {
		this.r39_pse_50_loan_int_sus = r39_pse_50_loan_int_sus;
	}
	public BigDecimal getR39_pse_50_loan_crm() {
		return r39_pse_50_loan_crm;
	}
	public void setR39_pse_50_loan_crm(BigDecimal r39_pse_50_loan_crm) {
		this.r39_pse_50_loan_crm = r39_pse_50_loan_crm;
	}
	public BigDecimal getR39_pse_50_loan_tot_dra() {
		return r39_pse_50_loan_tot_dra;
	}
	public void setR39_pse_50_loan_tot_dra(BigDecimal r39_pse_50_loan_tot_dra) {
		this.r39_pse_50_loan_tot_dra = r39_pse_50_loan_tot_dra;
	}
	public BigDecimal getR39_pse_50_inves_bal() {
		return r39_pse_50_inves_bal;
	}
	public void setR39_pse_50_inves_bal(BigDecimal r39_pse_50_inves_bal) {
		this.r39_pse_50_inves_bal = r39_pse_50_inves_bal;
	}
	public BigDecimal getR39_pse_50_inves_prov() {
		return r39_pse_50_inves_prov;
	}
	public void setR39_pse_50_inves_prov(BigDecimal r39_pse_50_inves_prov) {
		this.r39_pse_50_inves_prov = r39_pse_50_inves_prov;
	}
	public BigDecimal getR39_pse_50_inves_crm() {
		return r39_pse_50_inves_crm;
	}
	public void setR39_pse_50_inves_crm(BigDecimal r39_pse_50_inves_crm) {
		this.r39_pse_50_inves_crm = r39_pse_50_inves_crm;
	}
	public BigDecimal getR39_pse_50_inves_rwa() {
		return r39_pse_50_inves_rwa;
	}
	public void setR39_pse_50_inves_rwa(BigDecimal r39_pse_50_inves_rwa) {
		this.r39_pse_50_inves_rwa = r39_pse_50_inves_rwa;
	}
	public BigDecimal getR39_pse_50_plac_bal() {
		return r39_pse_50_plac_bal;
	}
	public void setR39_pse_50_plac_bal(BigDecimal r39_pse_50_plac_bal) {
		this.r39_pse_50_plac_bal = r39_pse_50_plac_bal;
	}
	public BigDecimal getR39_pse_50_plac_prov() {
		return r39_pse_50_plac_prov;
	}
	public void setR39_pse_50_plac_prov(BigDecimal r39_pse_50_plac_prov) {
		this.r39_pse_50_plac_prov = r39_pse_50_plac_prov;
	}
	public BigDecimal getR39_pse_50_plac_crm() {
		return r39_pse_50_plac_crm;
	}
	public void setR39_pse_50_plac_crm(BigDecimal r39_pse_50_plac_crm) {
		this.r39_pse_50_plac_crm = r39_pse_50_plac_crm;
	}
	public BigDecimal getR39_pse_50_plac_rwa() {
		return r39_pse_50_plac_rwa;
	}
	public void setR39_pse_50_plac_rwa(BigDecimal r39_pse_50_plac_rwa) {
		this.r39_pse_50_plac_rwa = r39_pse_50_plac_rwa;
	}
	public BigDecimal getR39_pse_50_cash_bal() {
		return r39_pse_50_cash_bal;
	}
	public void setR39_pse_50_cash_bal(BigDecimal r39_pse_50_cash_bal) {
		this.r39_pse_50_cash_bal = r39_pse_50_cash_bal;
	}
	public BigDecimal getR39_pse_50_cash_prov() {
		return r39_pse_50_cash_prov;
	}
	public void setR39_pse_50_cash_prov(BigDecimal r39_pse_50_cash_prov) {
		this.r39_pse_50_cash_prov = r39_pse_50_cash_prov;
	}
	public BigDecimal getR39_pse_50_cash_crm() {
		return r39_pse_50_cash_crm;
	}
	public void setR39_pse_50_cash_crm(BigDecimal r39_pse_50_cash_crm) {
		this.r39_pse_50_cash_crm = r39_pse_50_cash_crm;
	}
	public BigDecimal getR39_pse_50_cash_rwa() {
		return r39_pse_50_cash_rwa;
	}
	public void setR39_pse_50_cash_rwa(BigDecimal r39_pse_50_cash_rwa) {
		this.r39_pse_50_cash_rwa = r39_pse_50_cash_rwa;
	}
	public BigDecimal getR39_pse_50_tot_bal() {
		return r39_pse_50_tot_bal;
	}
	public void setR39_pse_50_tot_bal(BigDecimal r39_pse_50_tot_bal) {
		this.r39_pse_50_tot_bal = r39_pse_50_tot_bal;
	}
	public BigDecimal getR39_pse_50_tot_prov() {
		return r39_pse_50_tot_prov;
	}
	public void setR39_pse_50_tot_prov(BigDecimal r39_pse_50_tot_prov) {
		this.r39_pse_50_tot_prov = r39_pse_50_tot_prov;
	}
	public BigDecimal getR39_pse_50_tot_int_sus() {
		return r39_pse_50_tot_int_sus;
	}
	public void setR39_pse_50_tot_int_sus(BigDecimal r39_pse_50_tot_int_sus) {
		this.r39_pse_50_tot_int_sus = r39_pse_50_tot_int_sus;
	}
	public BigDecimal getR39_pse_50_tot_crm() {
		return r39_pse_50_tot_crm;
	}
	public void setR39_pse_50_tot_crm(BigDecimal r39_pse_50_tot_crm) {
		this.r39_pse_50_tot_crm = r39_pse_50_tot_crm;
	}
	public BigDecimal getR39_pse_50_tot_rwa() {
		return r39_pse_50_tot_rwa;
	}
	public void setR39_pse_50_tot_rwa(BigDecimal r39_pse_50_tot_rwa) {
		this.r39_pse_50_tot_rwa = r39_pse_50_tot_rwa;
	}
	public BigDecimal getR40_pse_100_loan_bal() {
		return r40_pse_100_loan_bal;
	}
	public void setR40_pse_100_loan_bal(BigDecimal r40_pse_100_loan_bal) {
		this.r40_pse_100_loan_bal = r40_pse_100_loan_bal;
	}
	public BigDecimal getR40_pse_100_loan_bill_amt() {
		return r40_pse_100_loan_bill_amt;
	}
	public void setR40_pse_100_loan_bill_amt(BigDecimal r40_pse_100_loan_bill_amt) {
		this.r40_pse_100_loan_bill_amt = r40_pse_100_loan_bill_amt;
	}
	public BigDecimal getR40_pse_100_loan_tot_bal() {
		return r40_pse_100_loan_tot_bal;
	}
	public void setR40_pse_100_loan_tot_bal(BigDecimal r40_pse_100_loan_tot_bal) {
		this.r40_pse_100_loan_tot_bal = r40_pse_100_loan_tot_bal;
	}
	public BigDecimal getR40_pse_100_loan_tot_prov() {
		return r40_pse_100_loan_tot_prov;
	}
	public void setR40_pse_100_loan_tot_prov(BigDecimal r40_pse_100_loan_tot_prov) {
		this.r40_pse_100_loan_tot_prov = r40_pse_100_loan_tot_prov;
	}
	public BigDecimal getR40_pse_100_loan_int_sus() {
		return r40_pse_100_loan_int_sus;
	}
	public void setR40_pse_100_loan_int_sus(BigDecimal r40_pse_100_loan_int_sus) {
		this.r40_pse_100_loan_int_sus = r40_pse_100_loan_int_sus;
	}
	public BigDecimal getR40_pse_100_loan_crm() {
		return r40_pse_100_loan_crm;
	}
	public void setR40_pse_100_loan_crm(BigDecimal r40_pse_100_loan_crm) {
		this.r40_pse_100_loan_crm = r40_pse_100_loan_crm;
	}
	public BigDecimal getR40_pse_100_loan_tot_dra() {
		return r40_pse_100_loan_tot_dra;
	}
	public void setR40_pse_100_loan_tot_dra(BigDecimal r40_pse_100_loan_tot_dra) {
		this.r40_pse_100_loan_tot_dra = r40_pse_100_loan_tot_dra;
	}
	public BigDecimal getR40_pse_100_inves_bal() {
		return r40_pse_100_inves_bal;
	}
	public void setR40_pse_100_inves_bal(BigDecimal r40_pse_100_inves_bal) {
		this.r40_pse_100_inves_bal = r40_pse_100_inves_bal;
	}
	public BigDecimal getR40_pse_100_inves_prov() {
		return r40_pse_100_inves_prov;
	}
	public void setR40_pse_100_inves_prov(BigDecimal r40_pse_100_inves_prov) {
		this.r40_pse_100_inves_prov = r40_pse_100_inves_prov;
	}
	public BigDecimal getR40_pse_100_inves_crm() {
		return r40_pse_100_inves_crm;
	}
	public void setR40_pse_100_inves_crm(BigDecimal r40_pse_100_inves_crm) {
		this.r40_pse_100_inves_crm = r40_pse_100_inves_crm;
	}
	public BigDecimal getR40_pse_100_inves_rwa() {
		return r40_pse_100_inves_rwa;
	}
	public void setR40_pse_100_inves_rwa(BigDecimal r40_pse_100_inves_rwa) {
		this.r40_pse_100_inves_rwa = r40_pse_100_inves_rwa;
	}
	public BigDecimal getR40_pse_100_plac_bal() {
		return r40_pse_100_plac_bal;
	}
	public void setR40_pse_100_plac_bal(BigDecimal r40_pse_100_plac_bal) {
		this.r40_pse_100_plac_bal = r40_pse_100_plac_bal;
	}
	public BigDecimal getR40_pse_100_plac_prov() {
		return r40_pse_100_plac_prov;
	}
	public void setR40_pse_100_plac_prov(BigDecimal r40_pse_100_plac_prov) {
		this.r40_pse_100_plac_prov = r40_pse_100_plac_prov;
	}
	public BigDecimal getR40_pse_100_plac_crm() {
		return r40_pse_100_plac_crm;
	}
	public void setR40_pse_100_plac_crm(BigDecimal r40_pse_100_plac_crm) {
		this.r40_pse_100_plac_crm = r40_pse_100_plac_crm;
	}
	public BigDecimal getR40_pse_100_plac_rwa() {
		return r40_pse_100_plac_rwa;
	}
	public void setR40_pse_100_plac_rwa(BigDecimal r40_pse_100_plac_rwa) {
		this.r40_pse_100_plac_rwa = r40_pse_100_plac_rwa;
	}
	public BigDecimal getR40_pse_100_cash_bal() {
		return r40_pse_100_cash_bal;
	}
	public void setR40_pse_100_cash_bal(BigDecimal r40_pse_100_cash_bal) {
		this.r40_pse_100_cash_bal = r40_pse_100_cash_bal;
	}
	public BigDecimal getR40_pse_100_cash_prov() {
		return r40_pse_100_cash_prov;
	}
	public void setR40_pse_100_cash_prov(BigDecimal r40_pse_100_cash_prov) {
		this.r40_pse_100_cash_prov = r40_pse_100_cash_prov;
	}
	public BigDecimal getR40_pse_100_cash_crm() {
		return r40_pse_100_cash_crm;
	}
	public void setR40_pse_100_cash_crm(BigDecimal r40_pse_100_cash_crm) {
		this.r40_pse_100_cash_crm = r40_pse_100_cash_crm;
	}
	public BigDecimal getR40_pse_100_cash_rwa() {
		return r40_pse_100_cash_rwa;
	}
	public void setR40_pse_100_cash_rwa(BigDecimal r40_pse_100_cash_rwa) {
		this.r40_pse_100_cash_rwa = r40_pse_100_cash_rwa;
	}
	public BigDecimal getR40_pse_100_tot_bal() {
		return r40_pse_100_tot_bal;
	}
	public void setR40_pse_100_tot_bal(BigDecimal r40_pse_100_tot_bal) {
		this.r40_pse_100_tot_bal = r40_pse_100_tot_bal;
	}
	public BigDecimal getR40_pse_100_tot_prov() {
		return r40_pse_100_tot_prov;
	}
	public void setR40_pse_100_tot_prov(BigDecimal r40_pse_100_tot_prov) {
		this.r40_pse_100_tot_prov = r40_pse_100_tot_prov;
	}
	public BigDecimal getR40_pse_100_tot_int_sus() {
		return r40_pse_100_tot_int_sus;
	}
	public void setR40_pse_100_tot_int_sus(BigDecimal r40_pse_100_tot_int_sus) {
		this.r40_pse_100_tot_int_sus = r40_pse_100_tot_int_sus;
	}
	public BigDecimal getR40_pse_100_tot_crm() {
		return r40_pse_100_tot_crm;
	}
	public void setR40_pse_100_tot_crm(BigDecimal r40_pse_100_tot_crm) {
		this.r40_pse_100_tot_crm = r40_pse_100_tot_crm;
	}
	public BigDecimal getR40_pse_100_tot_rwa() {
		return r40_pse_100_tot_rwa;
	}
	public void setR40_pse_100_tot_rwa(BigDecimal r40_pse_100_tot_rwa) {
		this.r40_pse_100_tot_rwa = r40_pse_100_tot_rwa;
	}
	public BigDecimal getR41_pse_150_loan_bal() {
		return r41_pse_150_loan_bal;
	}
	public void setR41_pse_150_loan_bal(BigDecimal r41_pse_150_loan_bal) {
		this.r41_pse_150_loan_bal = r41_pse_150_loan_bal;
	}
	public BigDecimal getR41_pse_150_loan_bill_amt() {
		return r41_pse_150_loan_bill_amt;
	}
	public void setR41_pse_150_loan_bill_amt(BigDecimal r41_pse_150_loan_bill_amt) {
		this.r41_pse_150_loan_bill_amt = r41_pse_150_loan_bill_amt;
	}
	public BigDecimal getR41_pse_150_loan_tot_bal() {
		return r41_pse_150_loan_tot_bal;
	}
	public void setR41_pse_150_loan_tot_bal(BigDecimal r41_pse_150_loan_tot_bal) {
		this.r41_pse_150_loan_tot_bal = r41_pse_150_loan_tot_bal;
	}
	public BigDecimal getR41_pse_150_loan_tot_prov() {
		return r41_pse_150_loan_tot_prov;
	}
	public void setR41_pse_150_loan_tot_prov(BigDecimal r41_pse_150_loan_tot_prov) {
		this.r41_pse_150_loan_tot_prov = r41_pse_150_loan_tot_prov;
	}
	public BigDecimal getR41_pse_150_loan_int_sus() {
		return r41_pse_150_loan_int_sus;
	}
	public void setR41_pse_150_loan_int_sus(BigDecimal r41_pse_150_loan_int_sus) {
		this.r41_pse_150_loan_int_sus = r41_pse_150_loan_int_sus;
	}
	public BigDecimal getR41_pse_150_loan_crm() {
		return r41_pse_150_loan_crm;
	}
	public void setR41_pse_150_loan_crm(BigDecimal r41_pse_150_loan_crm) {
		this.r41_pse_150_loan_crm = r41_pse_150_loan_crm;
	}
	public BigDecimal getR41_pse_150_loan_tot_dra() {
		return r41_pse_150_loan_tot_dra;
	}
	public void setR41_pse_150_loan_tot_dra(BigDecimal r41_pse_150_loan_tot_dra) {
		this.r41_pse_150_loan_tot_dra = r41_pse_150_loan_tot_dra;
	}
	public BigDecimal getR41_pse_150_inves_bal() {
		return r41_pse_150_inves_bal;
	}
	public void setR41_pse_150_inves_bal(BigDecimal r41_pse_150_inves_bal) {
		this.r41_pse_150_inves_bal = r41_pse_150_inves_bal;
	}
	public BigDecimal getR41_pse_150_inves_prov() {
		return r41_pse_150_inves_prov;
	}
	public void setR41_pse_150_inves_prov(BigDecimal r41_pse_150_inves_prov) {
		this.r41_pse_150_inves_prov = r41_pse_150_inves_prov;
	}
	public BigDecimal getR41_pse_150_inves_crm() {
		return r41_pse_150_inves_crm;
	}
	public void setR41_pse_150_inves_crm(BigDecimal r41_pse_150_inves_crm) {
		this.r41_pse_150_inves_crm = r41_pse_150_inves_crm;
	}
	public BigDecimal getR41_pse_150_inves_rwa() {
		return r41_pse_150_inves_rwa;
	}
	public void setR41_pse_150_inves_rwa(BigDecimal r41_pse_150_inves_rwa) {
		this.r41_pse_150_inves_rwa = r41_pse_150_inves_rwa;
	}
	public BigDecimal getR41_pse_150_plac_bal() {
		return r41_pse_150_plac_bal;
	}
	public void setR41_pse_150_plac_bal(BigDecimal r41_pse_150_plac_bal) {
		this.r41_pse_150_plac_bal = r41_pse_150_plac_bal;
	}
	public BigDecimal getR41_pse_150_plac_prov() {
		return r41_pse_150_plac_prov;
	}
	public void setR41_pse_150_plac_prov(BigDecimal r41_pse_150_plac_prov) {
		this.r41_pse_150_plac_prov = r41_pse_150_plac_prov;
	}
	public BigDecimal getR41_pse_150_plac_crm() {
		return r41_pse_150_plac_crm;
	}
	public void setR41_pse_150_plac_crm(BigDecimal r41_pse_150_plac_crm) {
		this.r41_pse_150_plac_crm = r41_pse_150_plac_crm;
	}
	public BigDecimal getR41_pse_150_plac_rwa() {
		return r41_pse_150_plac_rwa;
	}
	public void setR41_pse_150_plac_rwa(BigDecimal r41_pse_150_plac_rwa) {
		this.r41_pse_150_plac_rwa = r41_pse_150_plac_rwa;
	}
	public BigDecimal getR41_pse_150_cash_bal() {
		return r41_pse_150_cash_bal;
	}
	public void setR41_pse_150_cash_bal(BigDecimal r41_pse_150_cash_bal) {
		this.r41_pse_150_cash_bal = r41_pse_150_cash_bal;
	}
	public BigDecimal getR41_pse_150_cash_prov() {
		return r41_pse_150_cash_prov;
	}
	public void setR41_pse_150_cash_prov(BigDecimal r41_pse_150_cash_prov) {
		this.r41_pse_150_cash_prov = r41_pse_150_cash_prov;
	}
	public BigDecimal getR41_pse_150_cash_crm() {
		return r41_pse_150_cash_crm;
	}
	public void setR41_pse_150_cash_crm(BigDecimal r41_pse_150_cash_crm) {
		this.r41_pse_150_cash_crm = r41_pse_150_cash_crm;
	}
	public BigDecimal getR41_pse_150_cash_rwa() {
		return r41_pse_150_cash_rwa;
	}
	public void setR41_pse_150_cash_rwa(BigDecimal r41_pse_150_cash_rwa) {
		this.r41_pse_150_cash_rwa = r41_pse_150_cash_rwa;
	}
	public BigDecimal getR41_pse_150_tot_bal() {
		return r41_pse_150_tot_bal;
	}
	public void setR41_pse_150_tot_bal(BigDecimal r41_pse_150_tot_bal) {
		this.r41_pse_150_tot_bal = r41_pse_150_tot_bal;
	}
	public BigDecimal getR41_pse_150_tot_prov() {
		return r41_pse_150_tot_prov;
	}
	public void setR41_pse_150_tot_prov(BigDecimal r41_pse_150_tot_prov) {
		this.r41_pse_150_tot_prov = r41_pse_150_tot_prov;
	}
	public BigDecimal getR41_pse_150_tot_int_sus() {
		return r41_pse_150_tot_int_sus;
	}
	public void setR41_pse_150_tot_int_sus(BigDecimal r41_pse_150_tot_int_sus) {
		this.r41_pse_150_tot_int_sus = r41_pse_150_tot_int_sus;
	}
	public BigDecimal getR41_pse_150_tot_crm() {
		return r41_pse_150_tot_crm;
	}
	public void setR41_pse_150_tot_crm(BigDecimal r41_pse_150_tot_crm) {
		this.r41_pse_150_tot_crm = r41_pse_150_tot_crm;
	}
	public BigDecimal getR41_pse_150_tot_rwa() {
		return r41_pse_150_tot_rwa;
	}
	public void setR41_pse_150_tot_rwa(BigDecimal r41_pse_150_tot_rwa) {
		this.r41_pse_150_tot_rwa = r41_pse_150_tot_rwa;
	}
	public BigDecimal getR42_res_35_loan_bal() {
		return r42_res_35_loan_bal;
	}
	public void setR42_res_35_loan_bal(BigDecimal r42_res_35_loan_bal) {
		this.r42_res_35_loan_bal = r42_res_35_loan_bal;
	}
	public BigDecimal getR42_res_35_loan_bill_amt() {
		return r42_res_35_loan_bill_amt;
	}
	public void setR42_res_35_loan_bill_amt(BigDecimal r42_res_35_loan_bill_amt) {
		this.r42_res_35_loan_bill_amt = r42_res_35_loan_bill_amt;
	}
	public BigDecimal getR42_res_35_loan_tot_bal() {
		return r42_res_35_loan_tot_bal;
	}
	public void setR42_res_35_loan_tot_bal(BigDecimal r42_res_35_loan_tot_bal) {
		this.r42_res_35_loan_tot_bal = r42_res_35_loan_tot_bal;
	}
	public BigDecimal getR42_res_35_loan_tot_prov() {
		return r42_res_35_loan_tot_prov;
	}
	public void setR42_res_35_loan_tot_prov(BigDecimal r42_res_35_loan_tot_prov) {
		this.r42_res_35_loan_tot_prov = r42_res_35_loan_tot_prov;
	}
	public BigDecimal getR42_res_35_loan_int_sus() {
		return r42_res_35_loan_int_sus;
	}
	public void setR42_res_35_loan_int_sus(BigDecimal r42_res_35_loan_int_sus) {
		this.r42_res_35_loan_int_sus = r42_res_35_loan_int_sus;
	}
	public BigDecimal getR42_res_35_loan_crm() {
		return r42_res_35_loan_crm;
	}
	public void setR42_res_35_loan_crm(BigDecimal r42_res_35_loan_crm) {
		this.r42_res_35_loan_crm = r42_res_35_loan_crm;
	}
	public BigDecimal getR42_res_35_loan_tot_dra() {
		return r42_res_35_loan_tot_dra;
	}
	public void setR42_res_35_loan_tot_dra(BigDecimal r42_res_35_loan_tot_dra) {
		this.r42_res_35_loan_tot_dra = r42_res_35_loan_tot_dra;
	}
	public BigDecimal getR42_res_35_inves_bal() {
		return r42_res_35_inves_bal;
	}
	public void setR42_res_35_inves_bal(BigDecimal r42_res_35_inves_bal) {
		this.r42_res_35_inves_bal = r42_res_35_inves_bal;
	}
	public BigDecimal getR42_res_35_inves_prov() {
		return r42_res_35_inves_prov;
	}
	public void setR42_res_35_inves_prov(BigDecimal r42_res_35_inves_prov) {
		this.r42_res_35_inves_prov = r42_res_35_inves_prov;
	}
	public BigDecimal getR42_res_35_inves_crm() {
		return r42_res_35_inves_crm;
	}
	public void setR42_res_35_inves_crm(BigDecimal r42_res_35_inves_crm) {
		this.r42_res_35_inves_crm = r42_res_35_inves_crm;
	}
	public BigDecimal getR42_res_35_inves_rwa() {
		return r42_res_35_inves_rwa;
	}
	public void setR42_res_35_inves_rwa(BigDecimal r42_res_35_inves_rwa) {
		this.r42_res_35_inves_rwa = r42_res_35_inves_rwa;
	}
	public BigDecimal getR42_res_35_plac_bal() {
		return r42_res_35_plac_bal;
	}
	public void setR42_res_35_plac_bal(BigDecimal r42_res_35_plac_bal) {
		this.r42_res_35_plac_bal = r42_res_35_plac_bal;
	}
	public BigDecimal getR42_res_35_plac_prov() {
		return r42_res_35_plac_prov;
	}
	public void setR42_res_35_plac_prov(BigDecimal r42_res_35_plac_prov) {
		this.r42_res_35_plac_prov = r42_res_35_plac_prov;
	}
	public BigDecimal getR42_res_35_plac_crm() {
		return r42_res_35_plac_crm;
	}
	public void setR42_res_35_plac_crm(BigDecimal r42_res_35_plac_crm) {
		this.r42_res_35_plac_crm = r42_res_35_plac_crm;
	}
	public BigDecimal getR42_res_35_plac_rwa() {
		return r42_res_35_plac_rwa;
	}
	public void setR42_res_35_plac_rwa(BigDecimal r42_res_35_plac_rwa) {
		this.r42_res_35_plac_rwa = r42_res_35_plac_rwa;
	}
	public BigDecimal getR42_res_35_cash_bal() {
		return r42_res_35_cash_bal;
	}
	public void setR42_res_35_cash_bal(BigDecimal r42_res_35_cash_bal) {
		this.r42_res_35_cash_bal = r42_res_35_cash_bal;
	}
	public BigDecimal getR42_res_35_cash_prov() {
		return r42_res_35_cash_prov;
	}
	public void setR42_res_35_cash_prov(BigDecimal r42_res_35_cash_prov) {
		this.r42_res_35_cash_prov = r42_res_35_cash_prov;
	}
	public BigDecimal getR42_res_35_cash_crm() {
		return r42_res_35_cash_crm;
	}
	public void setR42_res_35_cash_crm(BigDecimal r42_res_35_cash_crm) {
		this.r42_res_35_cash_crm = r42_res_35_cash_crm;
	}
	public BigDecimal getR42_res_35_cash_rwa() {
		return r42_res_35_cash_rwa;
	}
	public void setR42_res_35_cash_rwa(BigDecimal r42_res_35_cash_rwa) {
		this.r42_res_35_cash_rwa = r42_res_35_cash_rwa;
	}
	public BigDecimal getR42_res_35_tot_bal() {
		return r42_res_35_tot_bal;
	}
	public void setR42_res_35_tot_bal(BigDecimal r42_res_35_tot_bal) {
		this.r42_res_35_tot_bal = r42_res_35_tot_bal;
	}
	public BigDecimal getR42_res_35_tot_prov() {
		return r42_res_35_tot_prov;
	}
	public void setR42_res_35_tot_prov(BigDecimal r42_res_35_tot_prov) {
		this.r42_res_35_tot_prov = r42_res_35_tot_prov;
	}
	public BigDecimal getR42_res_35_tot_int_sus() {
		return r42_res_35_tot_int_sus;
	}
	public void setR42_res_35_tot_int_sus(BigDecimal r42_res_35_tot_int_sus) {
		this.r42_res_35_tot_int_sus = r42_res_35_tot_int_sus;
	}
	public BigDecimal getR42_res_35_tot_crm() {
		return r42_res_35_tot_crm;
	}
	public void setR42_res_35_tot_crm(BigDecimal r42_res_35_tot_crm) {
		this.r42_res_35_tot_crm = r42_res_35_tot_crm;
	}
	public BigDecimal getR42_res_35_tot_rwa() {
		return r42_res_35_tot_rwa;
	}
	public void setR42_res_35_tot_rwa(BigDecimal r42_res_35_tot_rwa) {
		this.r42_res_35_tot_rwa = r42_res_35_tot_rwa;
	}
	public BigDecimal getR43_res_100_loan_bal() {
		return r43_res_100_loan_bal;
	}
	public void setR43_res_100_loan_bal(BigDecimal r43_res_100_loan_bal) {
		this.r43_res_100_loan_bal = r43_res_100_loan_bal;
	}
	public BigDecimal getR43_res_100_loan_bill_amt() {
		return r43_res_100_loan_bill_amt;
	}
	public void setR43_res_100_loan_bill_amt(BigDecimal r43_res_100_loan_bill_amt) {
		this.r43_res_100_loan_bill_amt = r43_res_100_loan_bill_amt;
	}
	public BigDecimal getR43_res_100_loan_tot_bal() {
		return r43_res_100_loan_tot_bal;
	}
	public void setR43_res_100_loan_tot_bal(BigDecimal r43_res_100_loan_tot_bal) {
		this.r43_res_100_loan_tot_bal = r43_res_100_loan_tot_bal;
	}
	public BigDecimal getR43_res_100_loan_tot_prov() {
		return r43_res_100_loan_tot_prov;
	}
	public void setR43_res_100_loan_tot_prov(BigDecimal r43_res_100_loan_tot_prov) {
		this.r43_res_100_loan_tot_prov = r43_res_100_loan_tot_prov;
	}
	public BigDecimal getR43_res_100_loan_int_sus() {
		return r43_res_100_loan_int_sus;
	}
	public void setR43_res_100_loan_int_sus(BigDecimal r43_res_100_loan_int_sus) {
		this.r43_res_100_loan_int_sus = r43_res_100_loan_int_sus;
	}
	public BigDecimal getR43_res_100_loan_crm() {
		return r43_res_100_loan_crm;
	}
	public void setR43_res_100_loan_crm(BigDecimal r43_res_100_loan_crm) {
		this.r43_res_100_loan_crm = r43_res_100_loan_crm;
	}
	public BigDecimal getR43_res_100_loan_tot_dra() {
		return r43_res_100_loan_tot_dra;
	}
	public void setR43_res_100_loan_tot_dra(BigDecimal r43_res_100_loan_tot_dra) {
		this.r43_res_100_loan_tot_dra = r43_res_100_loan_tot_dra;
	}
	public BigDecimal getR43_res_100_inves_bal() {
		return r43_res_100_inves_bal;
	}
	public void setR43_res_100_inves_bal(BigDecimal r43_res_100_inves_bal) {
		this.r43_res_100_inves_bal = r43_res_100_inves_bal;
	}
	public BigDecimal getR43_res_100_inves_prov() {
		return r43_res_100_inves_prov;
	}
	public void setR43_res_100_inves_prov(BigDecimal r43_res_100_inves_prov) {
		this.r43_res_100_inves_prov = r43_res_100_inves_prov;
	}
	public BigDecimal getR43_res_100_inves_crm() {
		return r43_res_100_inves_crm;
	}
	public void setR43_res_100_inves_crm(BigDecimal r43_res_100_inves_crm) {
		this.r43_res_100_inves_crm = r43_res_100_inves_crm;
	}
	public BigDecimal getR43_res_100_inves_rwa() {
		return r43_res_100_inves_rwa;
	}
	public void setR43_res_100_inves_rwa(BigDecimal r43_res_100_inves_rwa) {
		this.r43_res_100_inves_rwa = r43_res_100_inves_rwa;
	}
	public BigDecimal getR43_res_100_plac_bal() {
		return r43_res_100_plac_bal;
	}
	public void setR43_res_100_plac_bal(BigDecimal r43_res_100_plac_bal) {
		this.r43_res_100_plac_bal = r43_res_100_plac_bal;
	}
	public BigDecimal getR43_res_100_plac_prov() {
		return r43_res_100_plac_prov;
	}
	public void setR43_res_100_plac_prov(BigDecimal r43_res_100_plac_prov) {
		this.r43_res_100_plac_prov = r43_res_100_plac_prov;
	}
	public BigDecimal getR43_res_100_plac_crm() {
		return r43_res_100_plac_crm;
	}
	public void setR43_res_100_plac_crm(BigDecimal r43_res_100_plac_crm) {
		this.r43_res_100_plac_crm = r43_res_100_plac_crm;
	}
	public BigDecimal getR43_res_100_plac_rwa() {
		return r43_res_100_plac_rwa;
	}
	public void setR43_res_100_plac_rwa(BigDecimal r43_res_100_plac_rwa) {
		this.r43_res_100_plac_rwa = r43_res_100_plac_rwa;
	}
	public BigDecimal getR43_res_100_cash_bal() {
		return r43_res_100_cash_bal;
	}
	public void setR43_res_100_cash_bal(BigDecimal r43_res_100_cash_bal) {
		this.r43_res_100_cash_bal = r43_res_100_cash_bal;
	}
	public BigDecimal getR43_res_100_cash_prov() {
		return r43_res_100_cash_prov;
	}
	public void setR43_res_100_cash_prov(BigDecimal r43_res_100_cash_prov) {
		this.r43_res_100_cash_prov = r43_res_100_cash_prov;
	}
	public BigDecimal getR43_res_100_cash_crm() {
		return r43_res_100_cash_crm;
	}
	public void setR43_res_100_cash_crm(BigDecimal r43_res_100_cash_crm) {
		this.r43_res_100_cash_crm = r43_res_100_cash_crm;
	}
	public BigDecimal getR43_res_100_cash_rwa() {
		return r43_res_100_cash_rwa;
	}
	public void setR43_res_100_cash_rwa(BigDecimal r43_res_100_cash_rwa) {
		this.r43_res_100_cash_rwa = r43_res_100_cash_rwa;
	}
	public BigDecimal getR43_res_100_tot_bal() {
		return r43_res_100_tot_bal;
	}
	public void setR43_res_100_tot_bal(BigDecimal r43_res_100_tot_bal) {
		this.r43_res_100_tot_bal = r43_res_100_tot_bal;
	}
	public BigDecimal getR43_res_100_tot_prov() {
		return r43_res_100_tot_prov;
	}
	public void setR43_res_100_tot_prov(BigDecimal r43_res_100_tot_prov) {
		this.r43_res_100_tot_prov = r43_res_100_tot_prov;
	}
	public BigDecimal getR43_res_100_tot_int_sus() {
		return r43_res_100_tot_int_sus;
	}
	public void setR43_res_100_tot_int_sus(BigDecimal r43_res_100_tot_int_sus) {
		this.r43_res_100_tot_int_sus = r43_res_100_tot_int_sus;
	}
	public BigDecimal getR43_res_100_tot_crm() {
		return r43_res_100_tot_crm;
	}
	public void setR43_res_100_tot_crm(BigDecimal r43_res_100_tot_crm) {
		this.r43_res_100_tot_crm = r43_res_100_tot_crm;
	}
	public BigDecimal getR43_res_100_tot_rwa() {
		return r43_res_100_tot_rwa;
	}
	public void setR43_res_100_tot_rwa(BigDecimal r43_res_100_tot_rwa) {
		this.r43_res_100_tot_rwa = r43_res_100_tot_rwa;
	}
	public BigDecimal getR44_res_75_loan_bal() {
		return r44_res_75_loan_bal;
	}
	public void setR44_res_75_loan_bal(BigDecimal r44_res_75_loan_bal) {
		this.r44_res_75_loan_bal = r44_res_75_loan_bal;
	}
	public BigDecimal getR44_res_75_loan_bill_amt() {
		return r44_res_75_loan_bill_amt;
	}
	public void setR44_res_75_loan_bill_amt(BigDecimal r44_res_75_loan_bill_amt) {
		this.r44_res_75_loan_bill_amt = r44_res_75_loan_bill_amt;
	}
	public BigDecimal getR44_res_75_loan_tot_bal() {
		return r44_res_75_loan_tot_bal;
	}
	public void setR44_res_75_loan_tot_bal(BigDecimal r44_res_75_loan_tot_bal) {
		this.r44_res_75_loan_tot_bal = r44_res_75_loan_tot_bal;
	}
	public BigDecimal getR44_res_75_loan_tot_prov() {
		return r44_res_75_loan_tot_prov;
	}
	public void setR44_res_75_loan_tot_prov(BigDecimal r44_res_75_loan_tot_prov) {
		this.r44_res_75_loan_tot_prov = r44_res_75_loan_tot_prov;
	}
	public BigDecimal getR44_res_75_loan_int_sus() {
		return r44_res_75_loan_int_sus;
	}
	public void setR44_res_75_loan_int_sus(BigDecimal r44_res_75_loan_int_sus) {
		this.r44_res_75_loan_int_sus = r44_res_75_loan_int_sus;
	}
	public BigDecimal getR44_res_75_loan_crm() {
		return r44_res_75_loan_crm;
	}
	public void setR44_res_75_loan_crm(BigDecimal r44_res_75_loan_crm) {
		this.r44_res_75_loan_crm = r44_res_75_loan_crm;
	}
	public BigDecimal getR44_res_75_loan_tot_dra() {
		return r44_res_75_loan_tot_dra;
	}
	public void setR44_res_75_loan_tot_dra(BigDecimal r44_res_75_loan_tot_dra) {
		this.r44_res_75_loan_tot_dra = r44_res_75_loan_tot_dra;
	}
	public BigDecimal getR44_res_75_inves_bal() {
		return r44_res_75_inves_bal;
	}
	public void setR44_res_75_inves_bal(BigDecimal r44_res_75_inves_bal) {
		this.r44_res_75_inves_bal = r44_res_75_inves_bal;
	}
	public BigDecimal getR44_res_75_inves_prov() {
		return r44_res_75_inves_prov;
	}
	public void setR44_res_75_inves_prov(BigDecimal r44_res_75_inves_prov) {
		this.r44_res_75_inves_prov = r44_res_75_inves_prov;
	}
	public BigDecimal getR44_res_75_inves_crm() {
		return r44_res_75_inves_crm;
	}
	public void setR44_res_75_inves_crm(BigDecimal r44_res_75_inves_crm) {
		this.r44_res_75_inves_crm = r44_res_75_inves_crm;
	}
	public BigDecimal getR44_res_75_inves_rwa() {
		return r44_res_75_inves_rwa;
	}
	public void setR44_res_75_inves_rwa(BigDecimal r44_res_75_inves_rwa) {
		this.r44_res_75_inves_rwa = r44_res_75_inves_rwa;
	}
	public BigDecimal getR44_res_75_plac_bal() {
		return r44_res_75_plac_bal;
	}
	public void setR44_res_75_plac_bal(BigDecimal r44_res_75_plac_bal) {
		this.r44_res_75_plac_bal = r44_res_75_plac_bal;
	}
	public BigDecimal getR44_res_75_plac_prov() {
		return r44_res_75_plac_prov;
	}
	public void setR44_res_75_plac_prov(BigDecimal r44_res_75_plac_prov) {
		this.r44_res_75_plac_prov = r44_res_75_plac_prov;
	}
	public BigDecimal getR44_res_75_plac_crm() {
		return r44_res_75_plac_crm;
	}
	public void setR44_res_75_plac_crm(BigDecimal r44_res_75_plac_crm) {
		this.r44_res_75_plac_crm = r44_res_75_plac_crm;
	}
	public BigDecimal getR44_res_75_plac_rwa() {
		return r44_res_75_plac_rwa;
	}
	public void setR44_res_75_plac_rwa(BigDecimal r44_res_75_plac_rwa) {
		this.r44_res_75_plac_rwa = r44_res_75_plac_rwa;
	}
	public BigDecimal getR44_res_75_cash_bal() {
		return r44_res_75_cash_bal;
	}
	public void setR44_res_75_cash_bal(BigDecimal r44_res_75_cash_bal) {
		this.r44_res_75_cash_bal = r44_res_75_cash_bal;
	}
	public BigDecimal getR44_res_75_cash_prov() {
		return r44_res_75_cash_prov;
	}
	public void setR44_res_75_cash_prov(BigDecimal r44_res_75_cash_prov) {
		this.r44_res_75_cash_prov = r44_res_75_cash_prov;
	}
	public BigDecimal getR44_res_75_cash_crm() {
		return r44_res_75_cash_crm;
	}
	public void setR44_res_75_cash_crm(BigDecimal r44_res_75_cash_crm) {
		this.r44_res_75_cash_crm = r44_res_75_cash_crm;
	}
	public BigDecimal getR44_res_75_cash_rwa() {
		return r44_res_75_cash_rwa;
	}
	public void setR44_res_75_cash_rwa(BigDecimal r44_res_75_cash_rwa) {
		this.r44_res_75_cash_rwa = r44_res_75_cash_rwa;
	}
	public BigDecimal getR44_res_75_tot_bal() {
		return r44_res_75_tot_bal;
	}
	public void setR44_res_75_tot_bal(BigDecimal r44_res_75_tot_bal) {
		this.r44_res_75_tot_bal = r44_res_75_tot_bal;
	}
	public BigDecimal getR44_res_75_tot_prov() {
		return r44_res_75_tot_prov;
	}
	public void setR44_res_75_tot_prov(BigDecimal r44_res_75_tot_prov) {
		this.r44_res_75_tot_prov = r44_res_75_tot_prov;
	}
	public BigDecimal getR44_res_75_tot_int_sus() {
		return r44_res_75_tot_int_sus;
	}
	public void setR44_res_75_tot_int_sus(BigDecimal r44_res_75_tot_int_sus) {
		this.r44_res_75_tot_int_sus = r44_res_75_tot_int_sus;
	}
	public BigDecimal getR44_res_75_tot_crm() {
		return r44_res_75_tot_crm;
	}
	public void setR44_res_75_tot_crm(BigDecimal r44_res_75_tot_crm) {
		this.r44_res_75_tot_crm = r44_res_75_tot_crm;
	}
	public BigDecimal getR44_res_75_tot_rwa() {
		return r44_res_75_tot_rwa;
	}
	public void setR44_res_75_tot_rwa(BigDecimal r44_res_75_tot_rwa) {
		this.r44_res_75_tot_rwa = r44_res_75_tot_rwa;
	}
	public BigDecimal getR45_res_100_loan_bal() {
		return r45_res_100_loan_bal;
	}
	public void setR45_res_100_loan_bal(BigDecimal r45_res_100_loan_bal) {
		this.r45_res_100_loan_bal = r45_res_100_loan_bal;
	}
	public BigDecimal getR45_res_100_loan_bill_amt() {
		return r45_res_100_loan_bill_amt;
	}
	public void setR45_res_100_loan_bill_amt(BigDecimal r45_res_100_loan_bill_amt) {
		this.r45_res_100_loan_bill_amt = r45_res_100_loan_bill_amt;
	}
	public BigDecimal getR45_res_100_loan_tot_bal() {
		return r45_res_100_loan_tot_bal;
	}
	public void setR45_res_100_loan_tot_bal(BigDecimal r45_res_100_loan_tot_bal) {
		this.r45_res_100_loan_tot_bal = r45_res_100_loan_tot_bal;
	}
	public BigDecimal getR45_res_100_loan_tot_prov() {
		return r45_res_100_loan_tot_prov;
	}
	public void setR45_res_100_loan_tot_prov(BigDecimal r45_res_100_loan_tot_prov) {
		this.r45_res_100_loan_tot_prov = r45_res_100_loan_tot_prov;
	}
	public BigDecimal getR45_res_100_loan_int_sus() {
		return r45_res_100_loan_int_sus;
	}
	public void setR45_res_100_loan_int_sus(BigDecimal r45_res_100_loan_int_sus) {
		this.r45_res_100_loan_int_sus = r45_res_100_loan_int_sus;
	}
	public BigDecimal getR45_res_100_loan_crm() {
		return r45_res_100_loan_crm;
	}
	public void setR45_res_100_loan_crm(BigDecimal r45_res_100_loan_crm) {
		this.r45_res_100_loan_crm = r45_res_100_loan_crm;
	}
	public BigDecimal getR45_res_100_loan_tot_dra() {
		return r45_res_100_loan_tot_dra;
	}
	public void setR45_res_100_loan_tot_dra(BigDecimal r45_res_100_loan_tot_dra) {
		this.r45_res_100_loan_tot_dra = r45_res_100_loan_tot_dra;
	}
	public BigDecimal getR45_res_100_inves_bal() {
		return r45_res_100_inves_bal;
	}
	public void setR45_res_100_inves_bal(BigDecimal r45_res_100_inves_bal) {
		this.r45_res_100_inves_bal = r45_res_100_inves_bal;
	}
	public BigDecimal getR45_res_100_inves_prov() {
		return r45_res_100_inves_prov;
	}
	public void setR45_res_100_inves_prov(BigDecimal r45_res_100_inves_prov) {
		this.r45_res_100_inves_prov = r45_res_100_inves_prov;
	}
	public BigDecimal getR45_res_100_inves_crm() {
		return r45_res_100_inves_crm;
	}
	public void setR45_res_100_inves_crm(BigDecimal r45_res_100_inves_crm) {
		this.r45_res_100_inves_crm = r45_res_100_inves_crm;
	}
	public BigDecimal getR45_res_100_inves_rwa() {
		return r45_res_100_inves_rwa;
	}
	public void setR45_res_100_inves_rwa(BigDecimal r45_res_100_inves_rwa) {
		this.r45_res_100_inves_rwa = r45_res_100_inves_rwa;
	}
	public BigDecimal getR45_res_100_plac_bal() {
		return r45_res_100_plac_bal;
	}
	public void setR45_res_100_plac_bal(BigDecimal r45_res_100_plac_bal) {
		this.r45_res_100_plac_bal = r45_res_100_plac_bal;
	}
	public BigDecimal getR45_res_100_plac_prov() {
		return r45_res_100_plac_prov;
	}
	public void setR45_res_100_plac_prov(BigDecimal r45_res_100_plac_prov) {
		this.r45_res_100_plac_prov = r45_res_100_plac_prov;
	}
	public BigDecimal getR45_res_100_plac_crm() {
		return r45_res_100_plac_crm;
	}
	public void setR45_res_100_plac_crm(BigDecimal r45_res_100_plac_crm) {
		this.r45_res_100_plac_crm = r45_res_100_plac_crm;
	}
	public BigDecimal getR45_res_100_plac_rwa() {
		return r45_res_100_plac_rwa;
	}
	public void setR45_res_100_plac_rwa(BigDecimal r45_res_100_plac_rwa) {
		this.r45_res_100_plac_rwa = r45_res_100_plac_rwa;
	}
	public BigDecimal getR45_res_100_cash_bal() {
		return r45_res_100_cash_bal;
	}
	public void setR45_res_100_cash_bal(BigDecimal r45_res_100_cash_bal) {
		this.r45_res_100_cash_bal = r45_res_100_cash_bal;
	}
	public BigDecimal getR45_res_100_cash_prov() {
		return r45_res_100_cash_prov;
	}
	public void setR45_res_100_cash_prov(BigDecimal r45_res_100_cash_prov) {
		this.r45_res_100_cash_prov = r45_res_100_cash_prov;
	}
	public BigDecimal getR45_res_100_cash_crm() {
		return r45_res_100_cash_crm;
	}
	public void setR45_res_100_cash_crm(BigDecimal r45_res_100_cash_crm) {
		this.r45_res_100_cash_crm = r45_res_100_cash_crm;
	}
	public BigDecimal getR45_res_100_cash_rwa() {
		return r45_res_100_cash_rwa;
	}
	public void setR45_res_100_cash_rwa(BigDecimal r45_res_100_cash_rwa) {
		this.r45_res_100_cash_rwa = r45_res_100_cash_rwa;
	}
	public BigDecimal getR45_res_100_tot_bal() {
		return r45_res_100_tot_bal;
	}
	public void setR45_res_100_tot_bal(BigDecimal r45_res_100_tot_bal) {
		this.r45_res_100_tot_bal = r45_res_100_tot_bal;
	}
	public BigDecimal getR45_res_100_tot_prov() {
		return r45_res_100_tot_prov;
	}
	public void setR45_res_100_tot_prov(BigDecimal r45_res_100_tot_prov) {
		this.r45_res_100_tot_prov = r45_res_100_tot_prov;
	}
	public BigDecimal getR45_res_100_tot_int_sus() {
		return r45_res_100_tot_int_sus;
	}
	public void setR45_res_100_tot_int_sus(BigDecimal r45_res_100_tot_int_sus) {
		this.r45_res_100_tot_int_sus = r45_res_100_tot_int_sus;
	}
	public BigDecimal getR45_res_100_tot_crm() {
		return r45_res_100_tot_crm;
	}
	public void setR45_res_100_tot_crm(BigDecimal r45_res_100_tot_crm) {
		this.r45_res_100_tot_crm = r45_res_100_tot_crm;
	}
	public BigDecimal getR45_res_100_tot_rwa() {
		return r45_res_100_tot_rwa;
	}
	public void setR45_res_100_tot_rwa(BigDecimal r45_res_100_tot_rwa) {
		this.r45_res_100_tot_rwa = r45_res_100_tot_rwa;
	}
	public BigDecimal getR46_res_75_loan_bal() {
		return r46_res_75_loan_bal;
	}
	public void setR46_res_75_loan_bal(BigDecimal r46_res_75_loan_bal) {
		this.r46_res_75_loan_bal = r46_res_75_loan_bal;
	}
	public BigDecimal getR46_res_75_loan_bill_amt() {
		return r46_res_75_loan_bill_amt;
	}
	public void setR46_res_75_loan_bill_amt(BigDecimal r46_res_75_loan_bill_amt) {
		this.r46_res_75_loan_bill_amt = r46_res_75_loan_bill_amt;
	}
	public BigDecimal getR46_res_75_loan_tot_bal() {
		return r46_res_75_loan_tot_bal;
	}
	public void setR46_res_75_loan_tot_bal(BigDecimal r46_res_75_loan_tot_bal) {
		this.r46_res_75_loan_tot_bal = r46_res_75_loan_tot_bal;
	}
	public BigDecimal getR46_res_75_loan_tot_prov() {
		return r46_res_75_loan_tot_prov;
	}
	public void setR46_res_75_loan_tot_prov(BigDecimal r46_res_75_loan_tot_prov) {
		this.r46_res_75_loan_tot_prov = r46_res_75_loan_tot_prov;
	}
	public BigDecimal getR46_res_75_loan_int_sus() {
		return r46_res_75_loan_int_sus;
	}
	public void setR46_res_75_loan_int_sus(BigDecimal r46_res_75_loan_int_sus) {
		this.r46_res_75_loan_int_sus = r46_res_75_loan_int_sus;
	}
	public BigDecimal getR46_res_75_loan_crm() {
		return r46_res_75_loan_crm;
	}
	public void setR46_res_75_loan_crm(BigDecimal r46_res_75_loan_crm) {
		this.r46_res_75_loan_crm = r46_res_75_loan_crm;
	}
	public BigDecimal getR46_res_75_loan_tot_dra() {
		return r46_res_75_loan_tot_dra;
	}
	public void setR46_res_75_loan_tot_dra(BigDecimal r46_res_75_loan_tot_dra) {
		this.r46_res_75_loan_tot_dra = r46_res_75_loan_tot_dra;
	}
	public BigDecimal getR46_res_75_inves_bal() {
		return r46_res_75_inves_bal;
	}
	public void setR46_res_75_inves_bal(BigDecimal r46_res_75_inves_bal) {
		this.r46_res_75_inves_bal = r46_res_75_inves_bal;
	}
	public BigDecimal getR46_res_75_inves_prov() {
		return r46_res_75_inves_prov;
	}
	public void setR46_res_75_inves_prov(BigDecimal r46_res_75_inves_prov) {
		this.r46_res_75_inves_prov = r46_res_75_inves_prov;
	}
	public BigDecimal getR46_res_75_inves_crm() {
		return r46_res_75_inves_crm;
	}
	public void setR46_res_75_inves_crm(BigDecimal r46_res_75_inves_crm) {
		this.r46_res_75_inves_crm = r46_res_75_inves_crm;
	}
	public BigDecimal getR46_res_75_inves_rwa() {
		return r46_res_75_inves_rwa;
	}
	public void setR46_res_75_inves_rwa(BigDecimal r46_res_75_inves_rwa) {
		this.r46_res_75_inves_rwa = r46_res_75_inves_rwa;
	}
	public BigDecimal getR46_res_75_plac_bal() {
		return r46_res_75_plac_bal;
	}
	public void setR46_res_75_plac_bal(BigDecimal r46_res_75_plac_bal) {
		this.r46_res_75_plac_bal = r46_res_75_plac_bal;
	}
	public BigDecimal getR46_res_75_plac_prov() {
		return r46_res_75_plac_prov;
	}
	public void setR46_res_75_plac_prov(BigDecimal r46_res_75_plac_prov) {
		this.r46_res_75_plac_prov = r46_res_75_plac_prov;
	}
	public BigDecimal getR46_res_75_plac_crm() {
		return r46_res_75_plac_crm;
	}
	public void setR46_res_75_plac_crm(BigDecimal r46_res_75_plac_crm) {
		this.r46_res_75_plac_crm = r46_res_75_plac_crm;
	}
	public BigDecimal getR46_res_75_plac_rwa() {
		return r46_res_75_plac_rwa;
	}
	public void setR46_res_75_plac_rwa(BigDecimal r46_res_75_plac_rwa) {
		this.r46_res_75_plac_rwa = r46_res_75_plac_rwa;
	}
	public BigDecimal getR46_res_75_cash_bal() {
		return r46_res_75_cash_bal;
	}
	public void setR46_res_75_cash_bal(BigDecimal r46_res_75_cash_bal) {
		this.r46_res_75_cash_bal = r46_res_75_cash_bal;
	}
	public BigDecimal getR46_res_75_cash_prov() {
		return r46_res_75_cash_prov;
	}
	public void setR46_res_75_cash_prov(BigDecimal r46_res_75_cash_prov) {
		this.r46_res_75_cash_prov = r46_res_75_cash_prov;
	}
	public BigDecimal getR46_res_75_cash_crm() {
		return r46_res_75_cash_crm;
	}
	public void setR46_res_75_cash_crm(BigDecimal r46_res_75_cash_crm) {
		this.r46_res_75_cash_crm = r46_res_75_cash_crm;
	}
	public BigDecimal getR46_res_75_cash_rwa() {
		return r46_res_75_cash_rwa;
	}
	public void setR46_res_75_cash_rwa(BigDecimal r46_res_75_cash_rwa) {
		this.r46_res_75_cash_rwa = r46_res_75_cash_rwa;
	}
	public BigDecimal getR46_res_75_tot_bal() {
		return r46_res_75_tot_bal;
	}
	public void setR46_res_75_tot_bal(BigDecimal r46_res_75_tot_bal) {
		this.r46_res_75_tot_bal = r46_res_75_tot_bal;
	}
	public BigDecimal getR46_res_75_tot_prov() {
		return r46_res_75_tot_prov;
	}
	public void setR46_res_75_tot_prov(BigDecimal r46_res_75_tot_prov) {
		this.r46_res_75_tot_prov = r46_res_75_tot_prov;
	}
	public BigDecimal getR46_res_75_tot_int_sus() {
		return r46_res_75_tot_int_sus;
	}
	public void setR46_res_75_tot_int_sus(BigDecimal r46_res_75_tot_int_sus) {
		this.r46_res_75_tot_int_sus = r46_res_75_tot_int_sus;
	}
	public BigDecimal getR46_res_75_tot_crm() {
		return r46_res_75_tot_crm;
	}
	public void setR46_res_75_tot_crm(BigDecimal r46_res_75_tot_crm) {
		this.r46_res_75_tot_crm = r46_res_75_tot_crm;
	}
	public BigDecimal getR46_res_75_tot_rwa() {
		return r46_res_75_tot_rwa;
	}
	public void setR46_res_75_tot_rwa(BigDecimal r46_res_75_tot_rwa) {
		this.r46_res_75_tot_rwa = r46_res_75_tot_rwa;
	}
	public BigDecimal getR47_res_85_loan_bal() {
		return r47_res_85_loan_bal;
	}
	public void setR47_res_85_loan_bal(BigDecimal r47_res_85_loan_bal) {
		this.r47_res_85_loan_bal = r47_res_85_loan_bal;
	}
	public BigDecimal getR47_res_85_loan_bill_amt() {
		return r47_res_85_loan_bill_amt;
	}
	public void setR47_res_85_loan_bill_amt(BigDecimal r47_res_85_loan_bill_amt) {
		this.r47_res_85_loan_bill_amt = r47_res_85_loan_bill_amt;
	}
	public BigDecimal getR47_res_85_loan_tot_bal() {
		return r47_res_85_loan_tot_bal;
	}
	public void setR47_res_85_loan_tot_bal(BigDecimal r47_res_85_loan_tot_bal) {
		this.r47_res_85_loan_tot_bal = r47_res_85_loan_tot_bal;
	}
	public BigDecimal getR47_res_85_loan_tot_prov() {
		return r47_res_85_loan_tot_prov;
	}
	public void setR47_res_85_loan_tot_prov(BigDecimal r47_res_85_loan_tot_prov) {
		this.r47_res_85_loan_tot_prov = r47_res_85_loan_tot_prov;
	}
	public BigDecimal getR47_res_85_loan_int_sus() {
		return r47_res_85_loan_int_sus;
	}
	public void setR47_res_85_loan_int_sus(BigDecimal r47_res_85_loan_int_sus) {
		this.r47_res_85_loan_int_sus = r47_res_85_loan_int_sus;
	}
	public BigDecimal getR47_res_85_loan_crm() {
		return r47_res_85_loan_crm;
	}
	public void setR47_res_85_loan_crm(BigDecimal r47_res_85_loan_crm) {
		this.r47_res_85_loan_crm = r47_res_85_loan_crm;
	}
	public BigDecimal getR47_res_85_loan_tot_dra() {
		return r47_res_85_loan_tot_dra;
	}
	public void setR47_res_85_loan_tot_dra(BigDecimal r47_res_85_loan_tot_dra) {
		this.r47_res_85_loan_tot_dra = r47_res_85_loan_tot_dra;
	}
	public BigDecimal getR47_res_85_inves_bal() {
		return r47_res_85_inves_bal;
	}
	public void setR47_res_85_inves_bal(BigDecimal r47_res_85_inves_bal) {
		this.r47_res_85_inves_bal = r47_res_85_inves_bal;
	}
	public BigDecimal getR47_res_85_inves_prov() {
		return r47_res_85_inves_prov;
	}
	public void setR47_res_85_inves_prov(BigDecimal r47_res_85_inves_prov) {
		this.r47_res_85_inves_prov = r47_res_85_inves_prov;
	}
	public BigDecimal getR47_res_85_inves_crm() {
		return r47_res_85_inves_crm;
	}
	public void setR47_res_85_inves_crm(BigDecimal r47_res_85_inves_crm) {
		this.r47_res_85_inves_crm = r47_res_85_inves_crm;
	}
	public BigDecimal getR47_res_85_inves_rwa() {
		return r47_res_85_inves_rwa;
	}
	public void setR47_res_85_inves_rwa(BigDecimal r47_res_85_inves_rwa) {
		this.r47_res_85_inves_rwa = r47_res_85_inves_rwa;
	}
	public BigDecimal getR47_res_85_plac_bal() {
		return r47_res_85_plac_bal;
	}
	public void setR47_res_85_plac_bal(BigDecimal r47_res_85_plac_bal) {
		this.r47_res_85_plac_bal = r47_res_85_plac_bal;
	}
	public BigDecimal getR47_res_85_plac_prov() {
		return r47_res_85_plac_prov;
	}
	public void setR47_res_85_plac_prov(BigDecimal r47_res_85_plac_prov) {
		this.r47_res_85_plac_prov = r47_res_85_plac_prov;
	}
	public BigDecimal getR47_res_85_plac_crm() {
		return r47_res_85_plac_crm;
	}
	public void setR47_res_85_plac_crm(BigDecimal r47_res_85_plac_crm) {
		this.r47_res_85_plac_crm = r47_res_85_plac_crm;
	}
	public BigDecimal getR47_res_85_plac_rwa() {
		return r47_res_85_plac_rwa;
	}
	public void setR47_res_85_plac_rwa(BigDecimal r47_res_85_plac_rwa) {
		this.r47_res_85_plac_rwa = r47_res_85_plac_rwa;
	}
	public BigDecimal getR47_res_85_cash_bal() {
		return r47_res_85_cash_bal;
	}
	public void setR47_res_85_cash_bal(BigDecimal r47_res_85_cash_bal) {
		this.r47_res_85_cash_bal = r47_res_85_cash_bal;
	}
	public BigDecimal getR47_res_85_cash_prov() {
		return r47_res_85_cash_prov;
	}
	public void setR47_res_85_cash_prov(BigDecimal r47_res_85_cash_prov) {
		this.r47_res_85_cash_prov = r47_res_85_cash_prov;
	}
	public BigDecimal getR47_res_85_cash_crm() {
		return r47_res_85_cash_crm;
	}
	public void setR47_res_85_cash_crm(BigDecimal r47_res_85_cash_crm) {
		this.r47_res_85_cash_crm = r47_res_85_cash_crm;
	}
	public BigDecimal getR47_res_85_cash_rwa() {
		return r47_res_85_cash_rwa;
	}
	public void setR47_res_85_cash_rwa(BigDecimal r47_res_85_cash_rwa) {
		this.r47_res_85_cash_rwa = r47_res_85_cash_rwa;
	}
	public BigDecimal getR47_res_85_tot_bal() {
		return r47_res_85_tot_bal;
	}
	public void setR47_res_85_tot_bal(BigDecimal r47_res_85_tot_bal) {
		this.r47_res_85_tot_bal = r47_res_85_tot_bal;
	}
	public BigDecimal getR47_res_85_tot_prov() {
		return r47_res_85_tot_prov;
	}
	public void setR47_res_85_tot_prov(BigDecimal r47_res_85_tot_prov) {
		this.r47_res_85_tot_prov = r47_res_85_tot_prov;
	}
	public BigDecimal getR47_res_85_tot_int_sus() {
		return r47_res_85_tot_int_sus;
	}
	public void setR47_res_85_tot_int_sus(BigDecimal r47_res_85_tot_int_sus) {
		this.r47_res_85_tot_int_sus = r47_res_85_tot_int_sus;
	}
	public BigDecimal getR47_res_85_tot_crm() {
		return r47_res_85_tot_crm;
	}
	public void setR47_res_85_tot_crm(BigDecimal r47_res_85_tot_crm) {
		this.r47_res_85_tot_crm = r47_res_85_tot_crm;
	}
	public BigDecimal getR47_res_85_tot_rwa() {
		return r47_res_85_tot_rwa;
	}
	public void setR47_res_85_tot_rwa(BigDecimal r47_res_85_tot_rwa) {
		this.r47_res_85_tot_rwa = r47_res_85_tot_rwa;
	}
	public BigDecimal getR48_res_0_loan_bal() {
		return r48_res_0_loan_bal;
	}
	public void setR48_res_0_loan_bal(BigDecimal r48_res_0_loan_bal) {
		this.r48_res_0_loan_bal = r48_res_0_loan_bal;
	}
	public BigDecimal getR48_res_0_loan_bill_amt() {
		return r48_res_0_loan_bill_amt;
	}
	public void setR48_res_0_loan_bill_amt(BigDecimal r48_res_0_loan_bill_amt) {
		this.r48_res_0_loan_bill_amt = r48_res_0_loan_bill_amt;
	}
	public BigDecimal getR48_res_0_loan_tot_bal() {
		return r48_res_0_loan_tot_bal;
	}
	public void setR48_res_0_loan_tot_bal(BigDecimal r48_res_0_loan_tot_bal) {
		this.r48_res_0_loan_tot_bal = r48_res_0_loan_tot_bal;
	}
	public BigDecimal getR48_res_0_loan_tot_prov() {
		return r48_res_0_loan_tot_prov;
	}
	public void setR48_res_0_loan_tot_prov(BigDecimal r48_res_0_loan_tot_prov) {
		this.r48_res_0_loan_tot_prov = r48_res_0_loan_tot_prov;
	}
	public BigDecimal getR48_res_0_loan_int_sus() {
		return r48_res_0_loan_int_sus;
	}
	public void setR48_res_0_loan_int_sus(BigDecimal r48_res_0_loan_int_sus) {
		this.r48_res_0_loan_int_sus = r48_res_0_loan_int_sus;
	}
	public BigDecimal getR48_res_0_loan_crm() {
		return r48_res_0_loan_crm;
	}
	public void setR48_res_0_loan_crm(BigDecimal r48_res_0_loan_crm) {
		this.r48_res_0_loan_crm = r48_res_0_loan_crm;
	}
	public BigDecimal getR48_res_0_loan_tot_dra() {
		return r48_res_0_loan_tot_dra;
	}
	public void setR48_res_0_loan_tot_dra(BigDecimal r48_res_0_loan_tot_dra) {
		this.r48_res_0_loan_tot_dra = r48_res_0_loan_tot_dra;
	}
	public BigDecimal getR48_res_0_inves_bal() {
		return r48_res_0_inves_bal;
	}
	public void setR48_res_0_inves_bal(BigDecimal r48_res_0_inves_bal) {
		this.r48_res_0_inves_bal = r48_res_0_inves_bal;
	}
	public BigDecimal getR48_res_0_inves_prov() {
		return r48_res_0_inves_prov;
	}
	public void setR48_res_0_inves_prov(BigDecimal r48_res_0_inves_prov) {
		this.r48_res_0_inves_prov = r48_res_0_inves_prov;
	}
	public BigDecimal getR48_res_0_inves_crm() {
		return r48_res_0_inves_crm;
	}
	public void setR48_res_0_inves_crm(BigDecimal r48_res_0_inves_crm) {
		this.r48_res_0_inves_crm = r48_res_0_inves_crm;
	}
	public BigDecimal getR48_res_0_inves_rwa() {
		return r48_res_0_inves_rwa;
	}
	public void setR48_res_0_inves_rwa(BigDecimal r48_res_0_inves_rwa) {
		this.r48_res_0_inves_rwa = r48_res_0_inves_rwa;
	}
	public BigDecimal getR48_res_0_plac_bal() {
		return r48_res_0_plac_bal;
	}
	public void setR48_res_0_plac_bal(BigDecimal r48_res_0_plac_bal) {
		this.r48_res_0_plac_bal = r48_res_0_plac_bal;
	}
	public BigDecimal getR48_res_0_plac_prov() {
		return r48_res_0_plac_prov;
	}
	public void setR48_res_0_plac_prov(BigDecimal r48_res_0_plac_prov) {
		this.r48_res_0_plac_prov = r48_res_0_plac_prov;
	}
	public BigDecimal getR48_res_0_plac_crm() {
		return r48_res_0_plac_crm;
	}
	public void setR48_res_0_plac_crm(BigDecimal r48_res_0_plac_crm) {
		this.r48_res_0_plac_crm = r48_res_0_plac_crm;
	}
	public BigDecimal getR48_res_0_plac_rwa() {
		return r48_res_0_plac_rwa;
	}
	public void setR48_res_0_plac_rwa(BigDecimal r48_res_0_plac_rwa) {
		this.r48_res_0_plac_rwa = r48_res_0_plac_rwa;
	}
	public BigDecimal getR48_res_0_cash_bal() {
		return r48_res_0_cash_bal;
	}
	public void setR48_res_0_cash_bal(BigDecimal r48_res_0_cash_bal) {
		this.r48_res_0_cash_bal = r48_res_0_cash_bal;
	}
	public BigDecimal getR48_res_0_cash_prov() {
		return r48_res_0_cash_prov;
	}
	public void setR48_res_0_cash_prov(BigDecimal r48_res_0_cash_prov) {
		this.r48_res_0_cash_prov = r48_res_0_cash_prov;
	}
	public BigDecimal getR48_res_0_cash_crm() {
		return r48_res_0_cash_crm;
	}
	public void setR48_res_0_cash_crm(BigDecimal r48_res_0_cash_crm) {
		this.r48_res_0_cash_crm = r48_res_0_cash_crm;
	}
	public BigDecimal getR48_res_0_cash_rwa() {
		return r48_res_0_cash_rwa;
	}
	public void setR48_res_0_cash_rwa(BigDecimal r48_res_0_cash_rwa) {
		this.r48_res_0_cash_rwa = r48_res_0_cash_rwa;
	}
	public BigDecimal getR48_res_0_tot_bal() {
		return r48_res_0_tot_bal;
	}
	public void setR48_res_0_tot_bal(BigDecimal r48_res_0_tot_bal) {
		this.r48_res_0_tot_bal = r48_res_0_tot_bal;
	}
	public BigDecimal getR48_res_0_tot_prov() {
		return r48_res_0_tot_prov;
	}
	public void setR48_res_0_tot_prov(BigDecimal r48_res_0_tot_prov) {
		this.r48_res_0_tot_prov = r48_res_0_tot_prov;
	}
	public BigDecimal getR48_res_0_tot_int_sus() {
		return r48_res_0_tot_int_sus;
	}
	public void setR48_res_0_tot_int_sus(BigDecimal r48_res_0_tot_int_sus) {
		this.r48_res_0_tot_int_sus = r48_res_0_tot_int_sus;
	}
	public BigDecimal getR48_res_0_tot_crm() {
		return r48_res_0_tot_crm;
	}
	public void setR48_res_0_tot_crm(BigDecimal r48_res_0_tot_crm) {
		this.r48_res_0_tot_crm = r48_res_0_tot_crm;
	}
	public BigDecimal getR48_res_0_tot_rwa() {
		return r48_res_0_tot_rwa;
	}
	public void setR48_res_0_tot_rwa(BigDecimal r48_res_0_tot_rwa) {
		this.r48_res_0_tot_rwa = r48_res_0_tot_rwa;
	}
	public BigDecimal getR49_res_100_loan_bal() {
		return r49_res_100_loan_bal;
	}
	public void setR49_res_100_loan_bal(BigDecimal r49_res_100_loan_bal) {
		this.r49_res_100_loan_bal = r49_res_100_loan_bal;
	}
	public BigDecimal getR49_res_100_loan_bill_amt() {
		return r49_res_100_loan_bill_amt;
	}
	public void setR49_res_100_loan_bill_amt(BigDecimal r49_res_100_loan_bill_amt) {
		this.r49_res_100_loan_bill_amt = r49_res_100_loan_bill_amt;
	}
	public BigDecimal getR49_res_100_loan_tot_bal() {
		return r49_res_100_loan_tot_bal;
	}
	public void setR49_res_100_loan_tot_bal(BigDecimal r49_res_100_loan_tot_bal) {
		this.r49_res_100_loan_tot_bal = r49_res_100_loan_tot_bal;
	}
	public BigDecimal getR49_res_100_loan_tot_prov() {
		return r49_res_100_loan_tot_prov;
	}
	public void setR49_res_100_loan_tot_prov(BigDecimal r49_res_100_loan_tot_prov) {
		this.r49_res_100_loan_tot_prov = r49_res_100_loan_tot_prov;
	}
	public BigDecimal getR49_res_100_loan_int_sus() {
		return r49_res_100_loan_int_sus;
	}
	public void setR49_res_100_loan_int_sus(BigDecimal r49_res_100_loan_int_sus) {
		this.r49_res_100_loan_int_sus = r49_res_100_loan_int_sus;
	}
	public BigDecimal getR49_res_100_loan_crm() {
		return r49_res_100_loan_crm;
	}
	public void setR49_res_100_loan_crm(BigDecimal r49_res_100_loan_crm) {
		this.r49_res_100_loan_crm = r49_res_100_loan_crm;
	}
	public BigDecimal getR49_res_100_loan_tot_dra() {
		return r49_res_100_loan_tot_dra;
	}
	public void setR49_res_100_loan_tot_dra(BigDecimal r49_res_100_loan_tot_dra) {
		this.r49_res_100_loan_tot_dra = r49_res_100_loan_tot_dra;
	}
	public BigDecimal getR49_res_100_inves_bal() {
		return r49_res_100_inves_bal;
	}
	public void setR49_res_100_inves_bal(BigDecimal r49_res_100_inves_bal) {
		this.r49_res_100_inves_bal = r49_res_100_inves_bal;
	}
	public BigDecimal getR49_res_100_inves_prov() {
		return r49_res_100_inves_prov;
	}
	public void setR49_res_100_inves_prov(BigDecimal r49_res_100_inves_prov) {
		this.r49_res_100_inves_prov = r49_res_100_inves_prov;
	}
	public BigDecimal getR49_res_100_inves_crm() {
		return r49_res_100_inves_crm;
	}
	public void setR49_res_100_inves_crm(BigDecimal r49_res_100_inves_crm) {
		this.r49_res_100_inves_crm = r49_res_100_inves_crm;
	}
	public BigDecimal getR49_res_100_inves_rwa() {
		return r49_res_100_inves_rwa;
	}
	public void setR49_res_100_inves_rwa(BigDecimal r49_res_100_inves_rwa) {
		this.r49_res_100_inves_rwa = r49_res_100_inves_rwa;
	}
	public BigDecimal getR49_res_100_plac_bal() {
		return r49_res_100_plac_bal;
	}
	public void setR49_res_100_plac_bal(BigDecimal r49_res_100_plac_bal) {
		this.r49_res_100_plac_bal = r49_res_100_plac_bal;
	}
	public BigDecimal getR49_res_100_plac_prov() {
		return r49_res_100_plac_prov;
	}
	public void setR49_res_100_plac_prov(BigDecimal r49_res_100_plac_prov) {
		this.r49_res_100_plac_prov = r49_res_100_plac_prov;
	}
	public BigDecimal getR49_res_100_plac_crm() {
		return r49_res_100_plac_crm;
	}
	public void setR49_res_100_plac_crm(BigDecimal r49_res_100_plac_crm) {
		this.r49_res_100_plac_crm = r49_res_100_plac_crm;
	}
	public BigDecimal getR49_res_100_plac_rwa() {
		return r49_res_100_plac_rwa;
	}
	public void setR49_res_100_plac_rwa(BigDecimal r49_res_100_plac_rwa) {
		this.r49_res_100_plac_rwa = r49_res_100_plac_rwa;
	}
	public BigDecimal getR49_res_100_cash_bal() {
		return r49_res_100_cash_bal;
	}
	public void setR49_res_100_cash_bal(BigDecimal r49_res_100_cash_bal) {
		this.r49_res_100_cash_bal = r49_res_100_cash_bal;
	}
	public BigDecimal getR49_res_100_cash_prov() {
		return r49_res_100_cash_prov;
	}
	public void setR49_res_100_cash_prov(BigDecimal r49_res_100_cash_prov) {
		this.r49_res_100_cash_prov = r49_res_100_cash_prov;
	}
	public BigDecimal getR49_res_100_cash_crm() {
		return r49_res_100_cash_crm;
	}
	public void setR49_res_100_cash_crm(BigDecimal r49_res_100_cash_crm) {
		this.r49_res_100_cash_crm = r49_res_100_cash_crm;
	}
	public BigDecimal getR49_res_100_cash_rwa() {
		return r49_res_100_cash_rwa;
	}
	public void setR49_res_100_cash_rwa(BigDecimal r49_res_100_cash_rwa) {
		this.r49_res_100_cash_rwa = r49_res_100_cash_rwa;
	}
	public BigDecimal getR49_res_100_tot_bal() {
		return r49_res_100_tot_bal;
	}
	public void setR49_res_100_tot_bal(BigDecimal r49_res_100_tot_bal) {
		this.r49_res_100_tot_bal = r49_res_100_tot_bal;
	}
	public BigDecimal getR49_res_100_tot_prov() {
		return r49_res_100_tot_prov;
	}
	public void setR49_res_100_tot_prov(BigDecimal r49_res_100_tot_prov) {
		this.r49_res_100_tot_prov = r49_res_100_tot_prov;
	}
	public BigDecimal getR49_res_100_tot_int_sus() {
		return r49_res_100_tot_int_sus;
	}
	public void setR49_res_100_tot_int_sus(BigDecimal r49_res_100_tot_int_sus) {
		this.r49_res_100_tot_int_sus = r49_res_100_tot_int_sus;
	}
	public BigDecimal getR49_res_100_tot_crm() {
		return r49_res_100_tot_crm;
	}
	public void setR49_res_100_tot_crm(BigDecimal r49_res_100_tot_crm) {
		this.r49_res_100_tot_crm = r49_res_100_tot_crm;
	}
	public BigDecimal getR49_res_100_tot_rwa() {
		return r49_res_100_tot_rwa;
	}
	public void setR49_res_100_tot_rwa(BigDecimal r49_res_100_tot_rwa) {
		this.r49_res_100_tot_rwa = r49_res_100_tot_rwa;
	}
	public BigDecimal getR50_res_250_loan_bal() {
		return r50_res_250_loan_bal;
	}
	public void setR50_res_250_loan_bal(BigDecimal r50_res_250_loan_bal) {
		this.r50_res_250_loan_bal = r50_res_250_loan_bal;
	}
	public BigDecimal getR50_res_250_loan_bill_amt() {
		return r50_res_250_loan_bill_amt;
	}
	public void setR50_res_250_loan_bill_amt(BigDecimal r50_res_250_loan_bill_amt) {
		this.r50_res_250_loan_bill_amt = r50_res_250_loan_bill_amt;
	}
	public BigDecimal getR50_res_250_loan_tot_bal() {
		return r50_res_250_loan_tot_bal;
	}
	public void setR50_res_250_loan_tot_bal(BigDecimal r50_res_250_loan_tot_bal) {
		this.r50_res_250_loan_tot_bal = r50_res_250_loan_tot_bal;
	}
	public BigDecimal getR50_res_250_loan_tot_prov() {
		return r50_res_250_loan_tot_prov;
	}
	public void setR50_res_250_loan_tot_prov(BigDecimal r50_res_250_loan_tot_prov) {
		this.r50_res_250_loan_tot_prov = r50_res_250_loan_tot_prov;
	}
	public BigDecimal getR50_res_250_loan_int_sus() {
		return r50_res_250_loan_int_sus;
	}
	public void setR50_res_250_loan_int_sus(BigDecimal r50_res_250_loan_int_sus) {
		this.r50_res_250_loan_int_sus = r50_res_250_loan_int_sus;
	}
	public BigDecimal getR50_res_250_loan_crm() {
		return r50_res_250_loan_crm;
	}
	public void setR50_res_250_loan_crm(BigDecimal r50_res_250_loan_crm) {
		this.r50_res_250_loan_crm = r50_res_250_loan_crm;
	}
	public BigDecimal getR50_res_250_loan_tot_dra() {
		return r50_res_250_loan_tot_dra;
	}
	public void setR50_res_250_loan_tot_dra(BigDecimal r50_res_250_loan_tot_dra) {
		this.r50_res_250_loan_tot_dra = r50_res_250_loan_tot_dra;
	}
	public BigDecimal getR50_res_250_inves_bal() {
		return r50_res_250_inves_bal;
	}
	public void setR50_res_250_inves_bal(BigDecimal r50_res_250_inves_bal) {
		this.r50_res_250_inves_bal = r50_res_250_inves_bal;
	}
	public BigDecimal getR50_res_250_inves_prov() {
		return r50_res_250_inves_prov;
	}
	public void setR50_res_250_inves_prov(BigDecimal r50_res_250_inves_prov) {
		this.r50_res_250_inves_prov = r50_res_250_inves_prov;
	}
	public BigDecimal getR50_res_250_inves_crm() {
		return r50_res_250_inves_crm;
	}
	public void setR50_res_250_inves_crm(BigDecimal r50_res_250_inves_crm) {
		this.r50_res_250_inves_crm = r50_res_250_inves_crm;
	}
	public BigDecimal getR50_res_250_inves_rwa() {
		return r50_res_250_inves_rwa;
	}
	public void setR50_res_250_inves_rwa(BigDecimal r50_res_250_inves_rwa) {
		this.r50_res_250_inves_rwa = r50_res_250_inves_rwa;
	}
	public BigDecimal getR50_res_250_plac_bal() {
		return r50_res_250_plac_bal;
	}
	public void setR50_res_250_plac_bal(BigDecimal r50_res_250_plac_bal) {
		this.r50_res_250_plac_bal = r50_res_250_plac_bal;
	}
	public BigDecimal getR50_res_250_plac_prov() {
		return r50_res_250_plac_prov;
	}
	public void setR50_res_250_plac_prov(BigDecimal r50_res_250_plac_prov) {
		this.r50_res_250_plac_prov = r50_res_250_plac_prov;
	}
	public BigDecimal getR50_res_250_plac_crm() {
		return r50_res_250_plac_crm;
	}
	public void setR50_res_250_plac_crm(BigDecimal r50_res_250_plac_crm) {
		this.r50_res_250_plac_crm = r50_res_250_plac_crm;
	}
	public BigDecimal getR50_res_250_plac_rwa() {
		return r50_res_250_plac_rwa;
	}
	public void setR50_res_250_plac_rwa(BigDecimal r50_res_250_plac_rwa) {
		this.r50_res_250_plac_rwa = r50_res_250_plac_rwa;
	}
	public BigDecimal getR50_res_250_cash_bal() {
		return r50_res_250_cash_bal;
	}
	public void setR50_res_250_cash_bal(BigDecimal r50_res_250_cash_bal) {
		this.r50_res_250_cash_bal = r50_res_250_cash_bal;
	}
	public BigDecimal getR50_res_250_cash_prov() {
		return r50_res_250_cash_prov;
	}
	public void setR50_res_250_cash_prov(BigDecimal r50_res_250_cash_prov) {
		this.r50_res_250_cash_prov = r50_res_250_cash_prov;
	}
	public BigDecimal getR50_res_250_cash_crm() {
		return r50_res_250_cash_crm;
	}
	public void setR50_res_250_cash_crm(BigDecimal r50_res_250_cash_crm) {
		this.r50_res_250_cash_crm = r50_res_250_cash_crm;
	}
	public BigDecimal getR50_res_250_cash_rwa() {
		return r50_res_250_cash_rwa;
	}
	public void setR50_res_250_cash_rwa(BigDecimal r50_res_250_cash_rwa) {
		this.r50_res_250_cash_rwa = r50_res_250_cash_rwa;
	}
	public BigDecimal getR50_res_250_tot_bal() {
		return r50_res_250_tot_bal;
	}
	public void setR50_res_250_tot_bal(BigDecimal r50_res_250_tot_bal) {
		this.r50_res_250_tot_bal = r50_res_250_tot_bal;
	}
	public BigDecimal getR50_res_250_tot_prov() {
		return r50_res_250_tot_prov;
	}
	public void setR50_res_250_tot_prov(BigDecimal r50_res_250_tot_prov) {
		this.r50_res_250_tot_prov = r50_res_250_tot_prov;
	}
	public BigDecimal getR50_res_250_tot_int_sus() {
		return r50_res_250_tot_int_sus;
	}
	public void setR50_res_250_tot_int_sus(BigDecimal r50_res_250_tot_int_sus) {
		this.r50_res_250_tot_int_sus = r50_res_250_tot_int_sus;
	}
	public BigDecimal getR50_res_250_tot_crm() {
		return r50_res_250_tot_crm;
	}
	public void setR50_res_250_tot_crm(BigDecimal r50_res_250_tot_crm) {
		this.r50_res_250_tot_crm = r50_res_250_tot_crm;
	}
	public BigDecimal getR50_res_250_tot_rwa() {
		return r50_res_250_tot_rwa;
	}
	public void setR50_res_250_tot_rwa(BigDecimal r50_res_250_tot_rwa) {
		this.r50_res_250_tot_rwa = r50_res_250_tot_rwa;
	}
	public BigDecimal getR51_res_100_loan_bal() {
		return r51_res_100_loan_bal;
	}
	public void setR51_res_100_loan_bal(BigDecimal r51_res_100_loan_bal) {
		this.r51_res_100_loan_bal = r51_res_100_loan_bal;
	}
	public BigDecimal getR51_res_100_loan_bill_amt() {
		return r51_res_100_loan_bill_amt;
	}
	public void setR51_res_100_loan_bill_amt(BigDecimal r51_res_100_loan_bill_amt) {
		this.r51_res_100_loan_bill_amt = r51_res_100_loan_bill_amt;
	}
	public BigDecimal getR51_res_100_loan_tot_bal() {
		return r51_res_100_loan_tot_bal;
	}
	public void setR51_res_100_loan_tot_bal(BigDecimal r51_res_100_loan_tot_bal) {
		this.r51_res_100_loan_tot_bal = r51_res_100_loan_tot_bal;
	}
	public BigDecimal getR51_res_100_loan_tot_prov() {
		return r51_res_100_loan_tot_prov;
	}
	public void setR51_res_100_loan_tot_prov(BigDecimal r51_res_100_loan_tot_prov) {
		this.r51_res_100_loan_tot_prov = r51_res_100_loan_tot_prov;
	}
	public BigDecimal getR51_res_100_loan_int_sus() {
		return r51_res_100_loan_int_sus;
	}
	public void setR51_res_100_loan_int_sus(BigDecimal r51_res_100_loan_int_sus) {
		this.r51_res_100_loan_int_sus = r51_res_100_loan_int_sus;
	}
	public BigDecimal getR51_res_100_loan_crm() {
		return r51_res_100_loan_crm;
	}
	public void setR51_res_100_loan_crm(BigDecimal r51_res_100_loan_crm) {
		this.r51_res_100_loan_crm = r51_res_100_loan_crm;
	}
	public BigDecimal getR51_res_100_loan_tot_dra() {
		return r51_res_100_loan_tot_dra;
	}
	public void setR51_res_100_loan_tot_dra(BigDecimal r51_res_100_loan_tot_dra) {
		this.r51_res_100_loan_tot_dra = r51_res_100_loan_tot_dra;
	}
	public BigDecimal getR51_res_100_inves_bal() {
		return r51_res_100_inves_bal;
	}
	public void setR51_res_100_inves_bal(BigDecimal r51_res_100_inves_bal) {
		this.r51_res_100_inves_bal = r51_res_100_inves_bal;
	}
	public BigDecimal getR51_res_100_inves_prov() {
		return r51_res_100_inves_prov;
	}
	public void setR51_res_100_inves_prov(BigDecimal r51_res_100_inves_prov) {
		this.r51_res_100_inves_prov = r51_res_100_inves_prov;
	}
	public BigDecimal getR51_res_100_inves_crm() {
		return r51_res_100_inves_crm;
	}
	public void setR51_res_100_inves_crm(BigDecimal r51_res_100_inves_crm) {
		this.r51_res_100_inves_crm = r51_res_100_inves_crm;
	}
	public BigDecimal getR51_res_100_inves_rwa() {
		return r51_res_100_inves_rwa;
	}
	public void setR51_res_100_inves_rwa(BigDecimal r51_res_100_inves_rwa) {
		this.r51_res_100_inves_rwa = r51_res_100_inves_rwa;
	}
	public BigDecimal getR51_res_100_plac_bal() {
		return r51_res_100_plac_bal;
	}
	public void setR51_res_100_plac_bal(BigDecimal r51_res_100_plac_bal) {
		this.r51_res_100_plac_bal = r51_res_100_plac_bal;
	}
	public BigDecimal getR51_res_100_plac_prov() {
		return r51_res_100_plac_prov;
	}
	public void setR51_res_100_plac_prov(BigDecimal r51_res_100_plac_prov) {
		this.r51_res_100_plac_prov = r51_res_100_plac_prov;
	}
	public BigDecimal getR51_res_100_plac_crm() {
		return r51_res_100_plac_crm;
	}
	public void setR51_res_100_plac_crm(BigDecimal r51_res_100_plac_crm) {
		this.r51_res_100_plac_crm = r51_res_100_plac_crm;
	}
	public BigDecimal getR51_res_100_plac_rwa() {
		return r51_res_100_plac_rwa;
	}
	public void setR51_res_100_plac_rwa(BigDecimal r51_res_100_plac_rwa) {
		this.r51_res_100_plac_rwa = r51_res_100_plac_rwa;
	}
	public BigDecimal getR51_res_100_cash_bal() {
		return r51_res_100_cash_bal;
	}
	public void setR51_res_100_cash_bal(BigDecimal r51_res_100_cash_bal) {
		this.r51_res_100_cash_bal = r51_res_100_cash_bal;
	}
	public BigDecimal getR51_res_100_cash_prov() {
		return r51_res_100_cash_prov;
	}
	public void setR51_res_100_cash_prov(BigDecimal r51_res_100_cash_prov) {
		this.r51_res_100_cash_prov = r51_res_100_cash_prov;
	}
	public BigDecimal getR51_res_100_cash_crm() {
		return r51_res_100_cash_crm;
	}
	public void setR51_res_100_cash_crm(BigDecimal r51_res_100_cash_crm) {
		this.r51_res_100_cash_crm = r51_res_100_cash_crm;
	}
	public BigDecimal getR51_res_100_cash_rwa() {
		return r51_res_100_cash_rwa;
	}
	public void setR51_res_100_cash_rwa(BigDecimal r51_res_100_cash_rwa) {
		this.r51_res_100_cash_rwa = r51_res_100_cash_rwa;
	}
	public BigDecimal getR51_res_100_tot_bal() {
		return r51_res_100_tot_bal;
	}
	public void setR51_res_100_tot_bal(BigDecimal r51_res_100_tot_bal) {
		this.r51_res_100_tot_bal = r51_res_100_tot_bal;
	}
	public BigDecimal getR51_res_100_tot_prov() {
		return r51_res_100_tot_prov;
	}
	public void setR51_res_100_tot_prov(BigDecimal r51_res_100_tot_prov) {
		this.r51_res_100_tot_prov = r51_res_100_tot_prov;
	}
	public BigDecimal getR51_res_100_tot_int_sus() {
		return r51_res_100_tot_int_sus;
	}
	public void setR51_res_100_tot_int_sus(BigDecimal r51_res_100_tot_int_sus) {
		this.r51_res_100_tot_int_sus = r51_res_100_tot_int_sus;
	}
	public BigDecimal getR51_res_100_tot_crm() {
		return r51_res_100_tot_crm;
	}
	public void setR51_res_100_tot_crm(BigDecimal r51_res_100_tot_crm) {
		this.r51_res_100_tot_crm = r51_res_100_tot_crm;
	}
	public BigDecimal getR51_res_100_tot_rwa() {
		return r51_res_100_tot_rwa;
	}
	public void setR51_res_100_tot_rwa(BigDecimal r51_res_100_tot_rwa) {
		this.r51_res_100_tot_rwa = r51_res_100_tot_rwa;
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
	public BRF95_FUND_BASED2() {
		super();
		// TODO Auto-generated constructor stub
	}
}