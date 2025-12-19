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
@Table(name="BRF95_TABLE1")

public class BRF95_TABLE1 {
	private BigDecimal	hni_0_loan_bal;
	private BigDecimal	hni_0_loan_bill_amt;
	private BigDecimal	hni_0_loan_tot_bal;
	private BigDecimal	hni_0_loan_tot_prov;
	private BigDecimal	hni_0_loan_int_sus;
	private BigDecimal	hni_0_loan_crm;
	private BigDecimal	hni_0_loan_tot_dra;
	private BigDecimal	hni_0_inves_bal;
	private BigDecimal	hni_0_inves_prov;
	private BigDecimal	hni_0_inves_crm;
	private BigDecimal	hni_0_inves_rwa;
	private BigDecimal	hni_0_plac_bal;
	private BigDecimal	hni_0_plac_prov;
	private BigDecimal	hni_0_plac_crm;
	private BigDecimal	hni_0_plac_rwa;
	private BigDecimal	hni_0_cash_bal;
	private BigDecimal	hni_0_cash_prov;
	private BigDecimal	hni_0_cash_crm;
	private BigDecimal	hni_0_cash_rwa;
	private BigDecimal	hni_0_tot_bal;
	private BigDecimal	hni_0_tot_prov;
	private BigDecimal	hni_0_tot_int_sus;
	private BigDecimal	hni_0_tot_crm;
	private BigDecimal	hni_0_tot_rwa;
	private BigDecimal	hni_20_loan_bal;
	private BigDecimal	hni_20_loan_bill_amt;
	private BigDecimal	hni_20_loan_tot_bal;
	private BigDecimal	hni_20_loan_tot_prov;
	private BigDecimal	hni_20_loan_int_sus;
	private BigDecimal	hni_20_loan_crm;
	private BigDecimal	hni_20_loan_tot_dra;
	private BigDecimal	hni_20_inves_bal;
	private BigDecimal	hni_20_inves_prov;
	private BigDecimal	hni_20_inves_crm;
	private BigDecimal	hni_20_inves_rwa;
	private BigDecimal	hni_20_plac_bal;
	private BigDecimal	hni_20_plac_prov;
	private BigDecimal	hni_20_plac_crm;
	private BigDecimal	hni_20_plac_rwa;
	private BigDecimal	hni_20_cash_bal;
	private BigDecimal	hni_20_cash_prov;
	private BigDecimal	hni_20_cash_crm;
	private BigDecimal	hni_20_cash_rwa;
	private BigDecimal	hni_20_tot_bal;
	private BigDecimal	hni_20_tot_prov;
	private BigDecimal	hni_20_tot_int_sus;
	private BigDecimal	hni_20_tot_crm;
	private BigDecimal	hni_20_tot_rwa;
	private BigDecimal	hni_50_loan_bal;
	private BigDecimal	hni_50_loan_bill_amt;
	private BigDecimal	hni_50_loan_tot_bal;
	private BigDecimal	hni_50_loan_tot_prov;
	private BigDecimal	hni_50_loan_int_sus;
	private BigDecimal	hni_50_loan_crm;
	private BigDecimal	hni_50_loan_tot_dra;
	private BigDecimal	hni_50_inves_bal;
	private BigDecimal	hni_50_inves_prov;
	private BigDecimal	hni_50_inves_crm;
	private BigDecimal	hni_50_inves_rwa;
	private BigDecimal	hni_50_plac_bal;
	private BigDecimal	hni_50_plac_prov;
	private BigDecimal	hni_50_plac_crm;
	private BigDecimal	hni_50_plac_rwa;
	private BigDecimal	hni_50_cash_bal;
	private BigDecimal	hni_50_cash_prov;
	private BigDecimal	hni_50_cash_crm;
	private BigDecimal	hni_50_cash_rwa;
	private BigDecimal	hni_50_tot_bal;
	private BigDecimal	hni_50_tot_prov;
	private BigDecimal	hni_50_tot_int_sus;
	private BigDecimal	hni_50_tot_crm;
	private BigDecimal	hni_50_tot_rwa;
	private BigDecimal	hni_150_loan_bal;
	private BigDecimal	hni_150_loan_bill_amt;
	private BigDecimal	hni_150_loan_tot_bal;
	private BigDecimal	hni_150_loan_tot_prov;
	private BigDecimal	hni_150_loan_int_sus;
	private BigDecimal	hni_150_loan_crm;
	private BigDecimal	hni_150_loan_tot_dra;
	private BigDecimal	hni_150_inves_bal;
	private BigDecimal	hni_150_inves_prov;
	private BigDecimal	hni_150_inves_crm;
	private BigDecimal	hni_150_inves_rwa;
	private BigDecimal	hni_150_plac_bal;
	private BigDecimal	hni_150_plac_prov;
	private BigDecimal	hni_150_plac_crm;
	private BigDecimal	hni_150_plac_rwa;
	private BigDecimal	hni_150_cash_bal;
	private BigDecimal	hni_150_cash_prov;
	private BigDecimal	hni_150_cash_crm;
	private BigDecimal	hni_150_cash_rwa;
	private BigDecimal	hni_150_tot_bal;
	private BigDecimal	hni_150_tot_prov;
	private BigDecimal	hni_150_tot_int_sus;
	private BigDecimal	hni_150_tot_crm;
	private BigDecimal	hni_150_tot_rwa;
	private BigDecimal	pdl_0_loan_bal;
	private BigDecimal	pdl_0_loan_bill_amt;
	private BigDecimal	pdl_0_loan_tot_bal;
	private BigDecimal	pdl_0_loan_tot_prov;
	private BigDecimal	pdl_0_loan_int_sus;
	private BigDecimal	pdl_0_loan_crm;
	private BigDecimal	pdl_0_loan_tot_dra;
	private BigDecimal	pdl_0_inves_bal;
	private BigDecimal	pdl_0_inves_prov;
	private BigDecimal	pdl_0_inves_crm;
	private BigDecimal	pdl_0_inves_rwa;
	private BigDecimal	pdl_0_plac_bal;
	private BigDecimal	pdl_0_plac_prov;
	private BigDecimal	pdl_0_plac_crm;
	private BigDecimal	pdl_0_plac_rwa;
	private BigDecimal	pdl_0_cash_bal;
	private BigDecimal	pdl_0_cash_prov;
	private BigDecimal	pdl_0_cash_crm;
	private BigDecimal	pdl_0_cash_rwa;
	private BigDecimal	pdl_0_tot_bal;
	private BigDecimal	pdl_0_tot_prov;
	private BigDecimal	pdl_0_tot_int_sus;
	private BigDecimal	pdl_0_tot_crm;
	private BigDecimal	pdl_0_tot_rwa;
	private BigDecimal	pdl_20_loan_bal;
	private BigDecimal	pdl_20_loan_bill_amt;
	private BigDecimal	pdl_20_loan_tot_bal;
	private BigDecimal	pdl_20_loan_tot_prov;
	private BigDecimal	pdl_20_loan_int_sus;
	private BigDecimal	pdl_20_loan_crm;
	private BigDecimal	pdl_20_loan_tot_dra;
	private BigDecimal	pdl_20_inves_bal;
	private BigDecimal	pdl_20_inves_prov;
	private BigDecimal	pdl_20_inves_crm;
	private BigDecimal	pdl_20_inves_rwa;
	private BigDecimal	pdl_20_plac_bal;
	private BigDecimal	pdl_20_plac_prov;
	private BigDecimal	pdl_20_plac_crm;
	private BigDecimal	pdl_20_plac_rwa;
	private BigDecimal	pdl_20_cash_bal;
	private BigDecimal	pdl_20_cash_prov;
	private BigDecimal	pdl_20_cash_crm;
	private BigDecimal	pdl_20_cash_rwa;
	private BigDecimal	pdl_20_tot_bal;
	private BigDecimal	pdl_20_tot_prov;
	private BigDecimal	pdl_20_tot_int_sus;
	private BigDecimal	pdl_20_tot_crm;
	private BigDecimal	pdl_20_tot_rwa;
	private BigDecimal	pdl_50_loan_bal;
	private BigDecimal	pdl_50_loan_bill_amt;
	private BigDecimal	pdl_50_loan_tot_bal;
	private BigDecimal	pdl_50_loan_tot_prov;
	private BigDecimal	pdl_50_loan_int_sus;
	private BigDecimal	pdl_50_loan_crm;
	private BigDecimal	pdl_50_loan_tot_dra;
	private BigDecimal	pdl_50_inves_bal;
	private BigDecimal	pdl_50_inves_prov;
	private BigDecimal	pdl_50_inves_crm;
	private BigDecimal	pdl_50_inves_rwa;
	private BigDecimal	pdl_50_plac_bal;
	private BigDecimal	pdl_50_plac_prov;
	private BigDecimal	pdl_50_plac_crm;
	private BigDecimal	pdl_50_plac_rwa;
	private BigDecimal	pdl_50_cash_bal;
	private BigDecimal	pdl_50_cash_prov;
	private BigDecimal	pdl_50_cash_crm;
	private BigDecimal	pdl_50_cash_rwa;
	private BigDecimal	pdl_50_tot_bal;
	private BigDecimal	pdl_50_tot_prov;
	private BigDecimal	pdl_50_tot_int_sus;
	private BigDecimal	pdl_50_tot_crm;
	private BigDecimal	pdl_50_tot_rwa;
	private BigDecimal	res_0_loan_bal;
	private BigDecimal	res_0_loan_bill_amt;
	private BigDecimal	res_0_loan_tot_bal;
	private BigDecimal	res_0_loan_tot_prov;
	private BigDecimal	res_0_loan_int_sus;
	private BigDecimal	res_0_loan_crm;
	private BigDecimal	res_0_loan_tot_dra;
	private BigDecimal	res_0_inves_bal;
	private BigDecimal	res_0_inves_prov;
	private BigDecimal	res_0_inves_crm;
	private BigDecimal	res_0_inves_rwa;
	private BigDecimal	res_0_plac_bal;
	private BigDecimal	res_0_plac_prov;
	private BigDecimal	res_0_plac_crm;
	private BigDecimal	res_0_plac_rwa;
	private BigDecimal	res_0_cash_bal;
	private BigDecimal	res_0_cash_prov;
	private BigDecimal	res_0_cash_crm;
	private BigDecimal	res_0_cash_rwa;
	private BigDecimal	res_0_tot_bal;
	private BigDecimal	res_0_tot_prov;
	private BigDecimal	res_0_tot_int_sus;
	private BigDecimal	res_0_tot_crm;
	private BigDecimal	res_0_tot_rwa;
	private BigDecimal	res_20_loan_bal;
	private BigDecimal	res_20_loan_bill_amt;
	private BigDecimal	res_20_loan_tot_bal;
	private BigDecimal	res_20_loan_tot_prov;
	private BigDecimal	res_20_loan_int_sus;
	private BigDecimal	res_20_loan_crm;
	private BigDecimal	res_20_loan_tot_dra;
	private BigDecimal	res_20_inves_bal;
	private BigDecimal	res_20_inves_prov;
	private BigDecimal	res_20_inves_crm;
	private BigDecimal	res_20_inves_rwa;
	private BigDecimal	res_20_plac_bal;
	private BigDecimal	res_20_plac_prov;
	private BigDecimal	res_20_plac_crm;
	private BigDecimal	res_20_plac_rwa;
	private BigDecimal	res_20_cash_bal;
	private BigDecimal	res_20_cash_prov;
	private BigDecimal	res_20_cash_crm;
	private BigDecimal	res_20_cash_rwa;
	private BigDecimal	res_20_tot_bal;
	private BigDecimal	res_20_tot_prov;
	private BigDecimal	res_20_tot_int_sus;
	private BigDecimal	res_20_tot_crm;
	private BigDecimal	res_20_tot_rwa;
	private BigDecimal	res_50_loan_bal;
	private BigDecimal	res_50_loan_bill_amt;
	private BigDecimal	res_50_loan_tot_bal;
	private BigDecimal	res_50_loan_tot_prov;
	private BigDecimal	res_50_loan_int_sus;
	private BigDecimal	res_50_loan_crm;
	private BigDecimal	res_50_loan_tot_dra;
	private BigDecimal	res_50_inves_bal;
	private BigDecimal	res_50_inves_prov;
	private BigDecimal	res_50_inves_crm;
	private BigDecimal	res_50_inves_rwa;
	private BigDecimal	res_50_plac_bal;
	private BigDecimal	res_50_plac_prov;
	private BigDecimal	res_50_plac_crm;
	private BigDecimal	res_50_plac_rwa;
	private BigDecimal	res_50_cash_bal;
	private BigDecimal	res_50_cash_prov;
	private BigDecimal	res_50_cash_crm;
	private BigDecimal	res_50_cash_rwa;
	private BigDecimal	res_50_tot_bal;
	private BigDecimal	res_50_tot_prov;
	private BigDecimal	res_50_tot_int_sus;
	private BigDecimal	res_50_tot_crm;
	private BigDecimal	res_50_tot_rwa;
	private BigDecimal	res_150_loan_bal;
	private BigDecimal	res_150_loan_bill_amt;
	private BigDecimal	res_150_loan_tot_bal;
	private BigDecimal	res_150_loan_tot_prov;
	private BigDecimal	res_150_loan_int_sus;
	private BigDecimal	res_150_loan_crm;
	private BigDecimal	res_150_loan_tot_dra;
	private BigDecimal	res_150_inves_bal;
	private BigDecimal	res_150_inves_prov;
	private BigDecimal	res_150_inves_crm;
	private BigDecimal	res_150_inves_rwa;
	private BigDecimal	res_150_plac_bal;
	private BigDecimal	res_150_plac_prov;
	private BigDecimal	res_150_plac_crm;
	private BigDecimal	res_150_plac_rwa;
	private BigDecimal	res_150_cash_bal;
	private BigDecimal	res_150_cash_prov;
	private BigDecimal	res_150_cash_crm;
	private BigDecimal	res_150_cash_rwa;
	private BigDecimal	res_150_tot_bal;
	private BigDecimal	res_150_tot_prov;
	private BigDecimal	res_150_tot_int_sus;
	private BigDecimal	res_150_tot_crm;
	private BigDecimal	res_150_tot_rwa;
	private BigDecimal	rrp_inde1_0_loan_bal;
	private BigDecimal	rrp_inde1_0_loan_bill_amt;
	private BigDecimal	rrp_inde1_0_loan_tot_bal;
	private BigDecimal	rrp_inde1_0_loan_tot_prov;
	private BigDecimal	rrp_inde1_0_loan_int_sus;
	private BigDecimal	rrp_inde1_0_loan_crm;
	private BigDecimal	rrp_inde1_0_loan_tot_dra;
	private BigDecimal	rrp_inde1_0_inves_bal;
	private BigDecimal	rrp_inde1_0_inves_prov;
	private BigDecimal	rrp_inde1_0_inves_crm;
	private BigDecimal	rrp_inde1_0_inves_rwa;
	private BigDecimal	rrp_inde1_0_plac_bal;
	private BigDecimal	rrp_inde1_0_plac_prov;
	private BigDecimal	rrp_inde1_0_plac_crm;
	private BigDecimal	rrp_inde1_0_plac_rwa;
	private BigDecimal	rrp_inde1_0_cash_bal;
	private BigDecimal	rrp_inde1_0_cash_prov;
	private BigDecimal	rrp_inde1_0_cash_crm;
	private BigDecimal	rrp_inde1_0_cash_rwa;
	private BigDecimal	rrp_inde1_0_tot_bal;
	private BigDecimal	rrp_inde1_0_tot_prov;
	private BigDecimal	rrp_inde1_0_tot_int_sus;
	private BigDecimal	rrp_inde1_0_tot_crm;
	private BigDecimal	rrp_inde1_0_tot_rwa;
	private BigDecimal	rrp_inde1_20_loan_bal;
	private BigDecimal	rrp_inde1_20_loan_bill_amt;
	private BigDecimal	rrp_inde1_20_loan_tot_bal;
	private BigDecimal	rrp_inde1_20_loan_tot_prov;
	private BigDecimal	rrp_inde1_20_loan_int_sus;
	private BigDecimal	rrp_inde1_20_loan_crm;
	private BigDecimal	rrp_inde1_20_loan_tot_dra;
	private BigDecimal	rrp_inde1_20_inves_bal;
	private BigDecimal	rrp_inde1_20_inves_prov;
	private BigDecimal	rrp_inde1_20_inves_crm;
	private BigDecimal	rrp_inde1_20_inves_rwa;
	private BigDecimal	rrp_inde1_20_plac_bal;
	private BigDecimal	rrp_inde1_20_plac_prov;
	private BigDecimal	rrp_inde1_20_plac_crm;
	private BigDecimal	rrp_inde1_20_plac_rwa;
	private BigDecimal	rrp_inde1_20_cash_bal;
	private BigDecimal	rrp_inde1_20_cash_prov;
	private BigDecimal	rrp_inde1_20_cash_crm;
	private BigDecimal	rrp_inde1_20_cash_rwa;
	private BigDecimal	rrp_inde1_20_tot_bal;
	private BigDecimal	rrp_inde1_20_tot_prov;
	private BigDecimal	rrp_inde1_20_tot_int_sus;
	private BigDecimal	rrp_inde1_20_tot_crm;
	private BigDecimal	rrp_inde1_20_tot_rwa;
	private BigDecimal	rrp_inde1_50_loan_bal;
	private BigDecimal	rrp_inde1_50_loan_bill_amt;
	private BigDecimal	rrp_inde1_50_loan_tot_bal;
	private BigDecimal	rrp_inde1_50_loan_tot_prov;
	private BigDecimal	rrp_inde1_50_loan_int_sus;
	private BigDecimal	rrp_inde1_50_loan_crm;
	private BigDecimal	rrp_inde1_50_loan_tot_dra;
	private BigDecimal	rrp_inde1_50_inves_bal;
	private BigDecimal	rrp_inde1_50_inves_prov;
	private BigDecimal	rrp_inde1_50_inves_crm;
	private BigDecimal	rrp_inde1_50_inves_rwa;
	private BigDecimal	rrp_inde1_50_plac_bal;
	private BigDecimal	rrp_inde1_50_plac_prov;
	private BigDecimal	rrp_inde1_50_plac_crm;
	private BigDecimal	rrp_inde1_50_plac_rwa;
	private BigDecimal	rrp_inde1_50_cash_bal;
	private BigDecimal	rrp_inde1_50_cash_prov;
	private BigDecimal	rrp_inde1_50_cash_crm;
	private BigDecimal	rrp_inde1_50_cash_rwa;
	private BigDecimal	rrp_inde1_50_tot_bal;
	private BigDecimal	rrp_inde1_50_tot_prov;
	private BigDecimal	rrp_inde1_50_tot_int_sus;
	private BigDecimal	rrp_inde1_50_tot_crm;
	private BigDecimal	rrp_inde1_50_tot_rwa;
	private BigDecimal	rrp_inde1_100_loan_bal;
	private BigDecimal	rrp_inde1_100_loan_bill_amt;
	private BigDecimal	rrp_inde1_100_loan_tot_bal;
	private BigDecimal	rrp_inde1_100_loan_tot_prov;
	private BigDecimal	rrp_inde1_100_loan_int_sus;
	private BigDecimal	rrp_inde1_100_loan_crm;
	private BigDecimal	rrp_inde1_100_loan_tot_dra;
	private BigDecimal	rrp_inde1_100_inves_bal;
	private BigDecimal	rrp_inde1_100_inves_prov;
	private BigDecimal	rrp_inde1_100_inves_crm;
	private BigDecimal	rrp_inde1_100_inves_rwa;
	private BigDecimal	rrp_inde1_100_plac_bal;
	private BigDecimal	rrp_inde1_100_plac_prov;
	private BigDecimal	rrp_inde1_100_plac_crm;
	private BigDecimal	rrp_inde1_100_plac_rwa;
	private BigDecimal	rrp_inde1_100_cash_bal;
	private BigDecimal	rrp_inde1_100_cash_prov;
	private BigDecimal	rrp_inde1_100_cash_crm;
	private BigDecimal	rrp_inde1_100_cash_rwa;
	private BigDecimal	rrp_inde1_100_tot_bal;
	private BigDecimal	rrp_inde1_100_tot_prov;
	private BigDecimal	rrp_inde1_100_tot_int_sus;
	private BigDecimal	rrp_inde1_100_tot_crm;
	private BigDecimal	rrp_inde1_100_tot_rwa;
	private BigDecimal	rrp_inde1_150_loan_bal;
	private BigDecimal	rrp_inde1_150_loan_bill_amt;
	private BigDecimal	rrp_inde1_150_loan_tot_bal;
	private BigDecimal	rrp_inde1_150_loan_tot_prov;
	private BigDecimal	rrp_inde1_150_loan_int_sus;
	private BigDecimal	rrp_inde1_150_loan_crm;
	private BigDecimal	rrp_inde1_150_loan_tot_dra;
	private BigDecimal	rrp_inde1_150_inves_bal;
	private BigDecimal	rrp_inde1_150_inves_prov;
	private BigDecimal	rrp_inde1_150_inves_crm;
	private BigDecimal	rrp_inde1_150_inves_rwa;
	private BigDecimal	rrp_inde1_150_plac_bal;
	private BigDecimal	rrp_inde1_150_plac_prov;
	private BigDecimal	rrp_inde1_150_plac_crm;
	private BigDecimal	rrp_inde1_150_plac_rwa;
	private BigDecimal	rrp_inde1_150_cash_bal;
	private BigDecimal	rrp_inde1_150_cash_prov;
	private BigDecimal	rrp_inde1_150_cash_crm;
	private BigDecimal	rrp_inde1_150_cash_rwa;
	private BigDecimal	rrp_inde1_150_tot_bal;
	private BigDecimal	rrp_inde1_150_tot_prov;
	private BigDecimal	rrp_inde1_150_tot_int_sus;
	private BigDecimal	rrp_inde1_150_tot_crm;
	private BigDecimal	rrp_inde1_150_tot_rwa;
	private BigDecimal	rrp_inde2_0_loan_bal;
	private BigDecimal	rrp_inde2_0_loan_bill_amt;
	private BigDecimal	rrp_inde2_0_loan_tot_bal;
	private BigDecimal	rrp_inde2_0_loan_tot_prov;
	private BigDecimal	rrp_inde2_0_loan_int_sus;
	private BigDecimal	rrp_inde2_0_loan_crm;
	private BigDecimal	rrp_inde2_0_loan_tot_dra;
	private BigDecimal	rrp_inde2_0_inves_bal;
	private BigDecimal	rrp_inde2_0_inves_prov;
	private BigDecimal	rrp_inde2_0_inves_crm;
	private BigDecimal	rrp_inde2_0_inves_rwa;
	private BigDecimal	rrp_inde2_0_plac_bal;
	private BigDecimal	rrp_inde2_0_plac_prov;
	private BigDecimal	rrp_inde2_0_plac_crm;
	private BigDecimal	rrp_inde2_0_plac_rwa;
	private BigDecimal	rrp_inde2_0_cash_bal;
	private BigDecimal	rrp_inde2_0_cash_prov;
	private BigDecimal	rrp_inde2_0_cash_crm;
	private BigDecimal	rrp_inde2_0_cash_rwa;
	private BigDecimal	rrp_inde2_0_tot_bal;
	private BigDecimal	rrp_inde2_0_tot_prov;
	private BigDecimal	rrp_inde2_0_tot_int_sus;
	private BigDecimal	rrp_inde2_0_tot_crm;
	private BigDecimal	rrp_inde2_0_tot_rwa;
	private BigDecimal	rrp_inde2_20_loan_bal;
	private BigDecimal	rrp_inde2_20_loan_bill_amt;
	private BigDecimal	rrp_inde2_20_loan_tot_bal;
	private BigDecimal	rrp_inde2_20_loan_tot_prov;
	private BigDecimal	rrp_inde2_20_loan_int_sus;
	private BigDecimal	rrp_inde2_20_loan_crm;
	private BigDecimal	rrp_inde2_20_loan_tot_dra;
	private BigDecimal	rrp_inde2_20_inves_bal;
	private BigDecimal	rrp_inde2_20_inves_prov;
	private BigDecimal	rrp_inde2_20_inves_crm;
	private BigDecimal	rrp_inde2_20_inves_rwa;
	private BigDecimal	rrp_inde2_20_plac_bal;
	private BigDecimal	rrp_inde2_20_plac_prov;
	private BigDecimal	rrp_inde2_20_plac_crm;
	private BigDecimal	rrp_inde2_20_plac_rwa;
	private BigDecimal	rrp_inde2_20_cash_bal;
	private BigDecimal	rrp_inde2_20_cash_prov;
	private BigDecimal	rrp_inde2_20_cash_crm;
	private BigDecimal	rrp_inde2_20_cash_rwa;
	private BigDecimal	rrp_inde2_20_tot_bal;
	private BigDecimal	rrp_inde2_20_tot_prov;
	private BigDecimal	rrp_inde2_20_tot_int_sus;
	private BigDecimal	rrp_inde2_20_tot_crm;
	private BigDecimal	rrp_inde2_20_tot_rwa;
	private BigDecimal	rrp_inde2_50_loan_bal;
	private BigDecimal	rrp_inde2_50_loan_bill_amt;
	private BigDecimal	rrp_inde2_50_loan_tot_bal;
	private BigDecimal	rrp_inde2_50_loan_tot_prov;
	private BigDecimal	rrp_inde2_50_loan_int_sus;
	private BigDecimal	rrp_inde2_50_loan_crm;
	private BigDecimal	rrp_inde2_50_loan_tot_dra;
	private BigDecimal	rrp_inde2_50_inves_bal;
	private BigDecimal	rrp_inde2_50_inves_prov;
	private BigDecimal	rrp_inde2_50_inves_crm;
	private BigDecimal	rrp_inde2_50_inves_rwa;
	private BigDecimal	rrp_inde2_50_plac_bal;
	private BigDecimal	rrp_inde2_50_plac_prov;
	private BigDecimal	rrp_inde2_50_plac_crm;
	private BigDecimal	rrp_inde2_50_plac_rwa;
	private BigDecimal	rrp_inde2_50_cash_bal;
	private BigDecimal	rrp_inde2_50_cash_prov;
	private BigDecimal	rrp_inde2_50_cash_crm;
	private BigDecimal	rrp_inde2_50_cash_rwa;
	private BigDecimal	rrp_inde2_50_tot_bal;
	private BigDecimal	rrp_inde2_50_tot_prov;
	private BigDecimal	rrp_inde2_50_tot_int_sus;
	private BigDecimal	rrp_inde2_50_tot_crm;
	private BigDecimal	rrp_inde2_50_tot_rwa;
	private BigDecimal	rrp_inde2_150_loan_bal;
	private BigDecimal	rrp_inde2_150_loan_bill_amt;
	private BigDecimal	rrp_inde2_150_loan_tot_bal;
	private BigDecimal	rrp_inde2_150_loan_tot_prov;
	private BigDecimal	rrp_inde2_150_loan_int_sus;
	private BigDecimal	rrp_inde2_150_loan_crm;
	private BigDecimal	rrp_inde2_150_loan_tot_dra;
	private BigDecimal	rrp_inde2_150_inves_bal;
	private BigDecimal	rrp_inde2_150_inves_prov;
	private BigDecimal	rrp_inde2_150_inves_crm;
	private BigDecimal	rrp_inde2_150_inves_rwa;
	private BigDecimal	rrp_inde2_150_plac_bal;
	private BigDecimal	rrp_inde2_150_plac_prov;
	private BigDecimal	rrp_inde2_150_plac_crm;
	private BigDecimal	rrp_inde2_150_plac_rwa;
	private BigDecimal	rrp_inde2_150_cash_bal;
	private BigDecimal	rrp_inde2_150_cash_prov;
	private BigDecimal	rrp_inde2_150_cash_crm;
	private BigDecimal	rrp_inde2_150_cash_rwa;
	private BigDecimal	rrp_inde2_150_tot_bal;
	private BigDecimal	rrp_inde2_150_tot_prov;
	private BigDecimal	rrp_inde2_150_tot_int_sus;
	private BigDecimal	rrp_inde2_150_tot_crm;
	private BigDecimal	rrp_inde2_150_tot_rwa;
	private BigDecimal	rrp_smlb_0_loan_bal;
	private BigDecimal	rrp_smlb_0_loan_bill_amt;
	private BigDecimal	rrp_smlb_0_loan_tot_bal;
	private BigDecimal	rrp_smlb_0_loan_tot_prov;
	private BigDecimal	rrp_smlb_0_loan_int_sus;
	private BigDecimal	rrp_smlb_0_loan_crm;
	private BigDecimal	rrp_smlb_0_loan_tot_dra;
	private BigDecimal	rrp_smlb_0_inves_bal;
	private BigDecimal	rrp_smlb_0_inves_prov;
	private BigDecimal	rrp_smlb_0_inves_crm;
	private BigDecimal	rrp_smlb_0_inves_rwa;
	private BigDecimal	rrp_smlb_0_plac_bal;
	private BigDecimal	rrp_smlb_0_plac_prov;
	private BigDecimal	rrp_smlb_0_plac_crm;
	private BigDecimal	rrp_smlb_0_plac_rwa;
	private BigDecimal	rrp_smlb_0_cash_bal;
	private BigDecimal	rrp_smlb_0_cash_prov;
	private BigDecimal	rrp_smlb_0_cash_crm;
	private BigDecimal	rrp_smlb_0_cash_rwa;
	private BigDecimal	rrp_smlb_0_tot_bal;
	private BigDecimal	rrp_smlb_0_tot_prov;
	private BigDecimal	rrp_smlb_0_tot_int_sus;
	private BigDecimal	rrp_smlb_0_tot_crm;
	private BigDecimal	rrp_smlb_0_tot_rwa;
	private BigDecimal	rrp_smlb_20_loan_bal;
	private BigDecimal	rrp_smlb_20_loan_bill_amt;
	private BigDecimal	rrp_smlb_20_loan_tot_bal;
	private BigDecimal	rrp_smlb_20_loan_tot_prov;
	private BigDecimal	rrp_smlb_20_loan_int_sus;
	private BigDecimal	rrp_smlb_20_loan_crm;
	private BigDecimal	rrp_smlb_20_loan_tot_dra;
	private BigDecimal	rrp_smlb_20_inves_bal;
	private BigDecimal	rrp_smlb_20_inves_prov;
	private BigDecimal	rrp_smlb_20_inves_crm;
	private BigDecimal	rrp_smlb_20_inves_rwa;
	private BigDecimal	rrp_smlb_20_plac_bal;
	private BigDecimal	rrp_smlb_20_plac_prov;
	private BigDecimal	rrp_smlb_20_plac_crm;
	private BigDecimal	rrp_smlb_20_plac_rwa;
	private BigDecimal	rrp_smlb_20_cash_bal;
	private BigDecimal	rrp_smlb_20_cash_prov;
	private BigDecimal	rrp_smlb_20_cash_crm;
	private BigDecimal	rrp_smlb_20_cash_rwa;
	private BigDecimal	rrp_smlb_20_tot_bal;
	private BigDecimal	rrp_smlb_20_tot_prov;
	private BigDecimal	rrp_smlb_20_tot_int_sus;
	private BigDecimal	rrp_smlb_20_tot_crm;
	private BigDecimal	rrp_smlb_20_tot_rwa;
	private BigDecimal	rrp_smlb_50_loan_bal;
	private BigDecimal	rrp_smlb_50_loan_bill_amt;
	private BigDecimal	rrp_smlb_50_loan_tot_bal;
	private BigDecimal	rrp_smlb_50_loan_tot_prov;
	private BigDecimal	rrp_smlb_50_loan_int_sus;
	private BigDecimal	rrp_smlb_50_loan_crm;
	private BigDecimal	rrp_smlb_50_loan_tot_dra;
	private BigDecimal	rrp_smlb_50_inves_bal;
	private BigDecimal	rrp_smlb_50_inves_prov;
	private BigDecimal	rrp_smlb_50_inves_crm;
	private BigDecimal	rrp_smlb_50_inves_rwa;
	private BigDecimal	rrp_smlb_50_plac_bal;
	private BigDecimal	rrp_smlb_50_plac_prov;
	private BigDecimal	rrp_smlb_50_plac_crm;
	private BigDecimal	rrp_smlb_50_plac_rwa;
	private BigDecimal	rrp_smlb_50_cash_bal;
	private BigDecimal	rrp_smlb_50_cash_prov;
	private BigDecimal	rrp_smlb_50_cash_crm;
	private BigDecimal	rrp_smlb_50_cash_rwa;
	private BigDecimal	rrp_smlb_50_tot_bal;
	private BigDecimal	rrp_smlb_50_tot_prov;
	private BigDecimal	rrp_smlb_50_tot_int_sus;
	private BigDecimal	rrp_smlb_50_tot_crm;
	private BigDecimal	rrp_smlb_50_tot_rwa;
	private BigDecimal	rrp_smlb_100_loan_bal;
	private BigDecimal	rrp_smlb_100_loan_bill_amt;
	private BigDecimal	rrp_smlb_100_loan_tot_bal;
	private BigDecimal	rrp_smlb_100_loan_tot_prov;
	private BigDecimal	rrp_smlb_100_loan_int_sus;
	private BigDecimal	rrp_smlb_100_loan_crm;
	private BigDecimal	rrp_smlb_100_loan_tot_dra;
	private BigDecimal	rrp_smlb_100_inves_bal;
	private BigDecimal	rrp_smlb_100_inves_prov;
	private BigDecimal	rrp_smlb_100_inves_crm;
	private BigDecimal	rrp_smlb_100_inves_rwa;
	private BigDecimal	rrp_smlb_100_plac_bal;
	private BigDecimal	rrp_smlb_100_plac_prov;
	private BigDecimal	rrp_smlb_100_plac_crm;
	private BigDecimal	rrp_smlb_100_plac_rwa;
	private BigDecimal	rrp_smlb_100_cash_bal;
	private BigDecimal	rrp_smlb_100_cash_prov;
	private BigDecimal	rrp_smlb_100_cash_crm;
	private BigDecimal	rrp_smlb_100_cash_rwa;
	private BigDecimal	rrp_smlb_100_tot_bal;
	private BigDecimal	rrp_smlb_100_tot_prov;
	private BigDecimal	rrp_smlb_100_tot_int_sus;
	private BigDecimal	rrp_smlb_100_tot_crm;
	private BigDecimal	rrp_smlb_100_tot_rwa;
	private BigDecimal	rrp_smlb_150_loan_bal;
	private BigDecimal	rrp_smlb_150_loan_bill_amt;
	private BigDecimal	rrp_smlb_150_loan_tot_bal;
	private BigDecimal	rrp_smlb_150_loan_tot_prov;
	private BigDecimal	rrp_smlb_150_loan_int_sus;
	private BigDecimal	rrp_smlb_150_loan_crm;
	private BigDecimal	rrp_smlb_150_loan_tot_dra;
	private BigDecimal	rrp_smlb_150_inves_bal;
	private BigDecimal	rrp_smlb_150_inves_prov;
	private BigDecimal	rrp_smlb_150_inves_crm;
	private BigDecimal	rrp_smlb_150_inves_rwa;
	private BigDecimal	rrp_smlb_150_plac_bal;
	private BigDecimal	rrp_smlb_150_plac_prov;
	private BigDecimal	rrp_smlb_150_plac_crm;
	private BigDecimal	rrp_smlb_150_plac_rwa;
	private BigDecimal	rrp_smlb_150_cash_bal;
	private BigDecimal	rrp_smlb_150_cash_prov;
	private BigDecimal	rrp_smlb_150_cash_crm;
	private BigDecimal	rrp_smlb_150_cash_rwa;
	private BigDecimal	rrp_smlb_150_tot_bal;
	private BigDecimal	rrp_smlb_150_tot_prov;
	private BigDecimal	rrp_smlb_150_tot_int_sus;
	private BigDecimal	rrp_smlb_150_tot_crm;
	private BigDecimal	rrp_smlb_150_tot_rwa;
	private BigDecimal	rrp_smlb2_0_loan_bal;
	private BigDecimal	rrp_smlb2_0_loan_bill_amt;
	private BigDecimal	rrp_smlb2_0_loan_tot_bal;
	private BigDecimal	rrp_smlb2_0_loan_tot_prov;
	private BigDecimal	rrp_smlb2_0_loan_int_sus;
	private BigDecimal	rrp_smlb2_0_loan_crm;
	private BigDecimal	rrp_smlb2_0_loan_tot_dra;
	private BigDecimal	rrp_smlb2_0_inves_bal;
	private BigDecimal	rrp_smlb2_0_inves_prov;
	private BigDecimal	rrp_smlb2_0_inves_crm;
	private BigDecimal	rrp_smlb2_0_inves_rwa;
	private BigDecimal	rrp_smlb2_0_plac_bal;
	private BigDecimal	rrp_smlb2_0_plac_prov;
	private BigDecimal	rrp_smlb2_0_plac_crm;
	private BigDecimal	rrp_smlb2_0_plac_rwa;
	private BigDecimal	rrp_smlb2_0_cash_bal;
	private BigDecimal	rrp_smlb2_0_cash_prov;
	private BigDecimal	rrp_smlb2_0_cash_crm;
	private BigDecimal	rrp_smlb2_0_cash_rwa;
	private BigDecimal	rrp_smlb2_0_tot_bal;
	private BigDecimal	rrp_smlb2_0_tot_prov;
	private BigDecimal	rrp_smlb2_0_tot_int_sus;
	private BigDecimal	rrp_smlb2_0_tot_crm;
	private BigDecimal	rrp_smlb2_0_tot_rwa;
	private BigDecimal	rrp_smlb2_20_loan_bal;
	private BigDecimal	rrp_smlb2_20_loan_bill_amt;
	private BigDecimal	rrp_smlb2_20_loan_tot_bal;
	private BigDecimal	rrp_smlb2_20_loan_tot_prov;
	private BigDecimal	rrp_smlb2_20_loan_int_sus;
	private BigDecimal	rrp_smlb2_20_loan_crm;
	private BigDecimal	rrp_smlb2_20_loan_tot_dra;
	private BigDecimal	rrp_smlb2_20_inves_bal;
	private BigDecimal	rrp_smlb2_20_inves_prov;
	private BigDecimal	rrp_smlb2_20_inves_crm;
	private BigDecimal	rrp_smlb2_20_inves_rwa;
	private BigDecimal	rrp_smlb2_20_plac_bal;
	private BigDecimal	rrp_smlb2_20_plac_prov;
	private BigDecimal	rrp_smlb2_20_plac_crm;
	private BigDecimal	rrp_smlb2_20_plac_rwa;
	private BigDecimal	rrp_smlb2_20_cash_bal;
	private BigDecimal	rrp_smlb2_20_cash_prov;
	private BigDecimal	rrp_smlb2_20_cash_crm;
	private BigDecimal	rrp_smlb2_20_cash_rwa;
	private BigDecimal	rrp_smlb2_20_tot_bal;
	private BigDecimal	rrp_smlb2_20_tot_prov;
	private BigDecimal	rrp_smlb2_20_tot_int_sus;
	private BigDecimal	rrp_smlb2_20_tot_crm;
	private BigDecimal	rrp_smlb2_20_tot_rwa;
	private BigDecimal	rrp_smlb2_50_loan_bal;
	private BigDecimal	rrp_smlb2_50_loan_bill_amt;
	private BigDecimal	rrp_smlb2_50_loan_tot_bal;
	private BigDecimal	rrp_smlb2_50_loan_tot_prov;
	private BigDecimal	rrp_smlb2_50_loan_int_sus;
	private BigDecimal	rrp_smlb2_50_loan_crm;
	private BigDecimal	rrp_smlb2_50_loan_tot_dra;
	private BigDecimal	rrp_smlb2_50_inves_bal;
	private BigDecimal	rrp_smlb2_50_inves_prov;
	private BigDecimal	rrp_smlb2_50_inves_crm;
	private BigDecimal	rrp_smlb2_50_inves_rwa;
	private BigDecimal	rrp_smlb2_50_plac_bal;
	private BigDecimal	rrp_smlb2_50_plac_prov;
	private BigDecimal	rrp_smlb2_50_plac_crm;
	private BigDecimal	rrp_smlb2_50_plac_rwa;
	private BigDecimal	rrp_smlb2_50_cash_bal;
	private BigDecimal	rrp_smlb2_50_cash_prov;
	private BigDecimal	rrp_smlb2_50_cash_crm;
	private BigDecimal	rrp_smlb2_50_cash_rwa;
	private BigDecimal	rrp_smlb2_50_tot_bal;
	private BigDecimal	rrp_smlb2_50_tot_prov;
	private BigDecimal	rrp_smlb2_50_tot_int_sus;
	private BigDecimal	rrp_smlb2_50_tot_crm;
	private BigDecimal	rrp_smlb2_50_tot_rwa;
	private BigDecimal	rrp_smlb2_100_loan_bal;
	private BigDecimal	rrp_smlb2_100_loan_bill_amt;
	private BigDecimal	rrp_smlb2_100_loan_tot_bal;
	private BigDecimal	rrp_smlb2_100_loan_tot_prov;
	private BigDecimal	rrp_smlb2_100_loan_int_sus;
	private BigDecimal	rrp_smlb2_100_loan_crm;
	private BigDecimal	rrp_smlb2_100_loan_tot_dra;
	private BigDecimal	rrp_smlb2_100_inves_bal;
	private BigDecimal	rrp_smlb2_100_inves_prov;
	private BigDecimal	rrp_smlb2_100_inves_crm;
	private BigDecimal	rrp_smlb2_100_inves_rwa;
	private BigDecimal	rrp_smlb2_100_plac_bal;
	private BigDecimal	rrp_smlb2_100_plac_prov;
	private BigDecimal	rrp_smlb2_100_plac_crm;
	private BigDecimal	rrp_smlb2_100_plac_rwa;
	private BigDecimal	rrp_smlb2_100_cash_bal;
	private BigDecimal	rrp_smlb2_100_cash_prov;
	private BigDecimal	rrp_smlb2_100_cash_crm;
	private BigDecimal	rrp_smlb2_100_cash_rwa;
	private BigDecimal	rrp_smlb2_100_tot_bal;
	private BigDecimal	rrp_smlb2_100_tot_prov;
	private BigDecimal	rrp_smlb2_100_tot_int_sus;
	private BigDecimal	rrp_smlb2_100_tot_crm;
	private BigDecimal	rrp_smlb2_100_tot_rwa;
	private BigDecimal	rrp_smlb2_150_loan_bal;
	private BigDecimal	rrp_smlb2_150_loan_bill_amt;
	private BigDecimal	rrp_smlb2_150_loan_tot_bal;
	private BigDecimal	rrp_smlb2_150_loan_tot_prov;
	private BigDecimal	rrp_smlb2_150_loan_int_sus;
	private BigDecimal	rrp_smlb2_150_loan_crm;
	private BigDecimal	rrp_smlb2_150_loan_tot_dra;
	private BigDecimal	rrp_smlb2_150_inves_bal;
	private BigDecimal	rrp_smlb2_150_inves_prov;
	private BigDecimal	rrp_smlb2_150_inves_crm;
	private BigDecimal	rrp_smlb2_150_inves_rwa;
	private BigDecimal	rrp_smlb2_150_plac_bal;
	private BigDecimal	rrp_smlb2_150_plac_prov;
	private BigDecimal	rrp_smlb2_150_plac_crm;
	private BigDecimal	rrp_smlb2_150_plac_rwa;
	private BigDecimal	rrp_smlb2_150_cash_bal;
	private BigDecimal	rrp_smlb2_150_cash_prov;
	private BigDecimal	rrp_smlb2_150_cash_crm;
	private BigDecimal	rrp_smlb2_150_cash_rwa;
	private BigDecimal	rrp_smlb2_150_tot_bal;
	private BigDecimal	rrp_smlb2_150_tot_prov;
	private BigDecimal	rrp_smlb2_150_tot_int_sus;
	private BigDecimal	rrp_smlb2_150_tot_crm;
	private BigDecimal	rrp_smlb2_150_tot_rwa;
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
	public BigDecimal getHni_0_loan_bal() {
		return hni_0_loan_bal;
	}
	public void setHni_0_loan_bal(BigDecimal hni_0_loan_bal) {
		this.hni_0_loan_bal = hni_0_loan_bal;
	}
	public BigDecimal getHni_0_loan_bill_amt() {
		return hni_0_loan_bill_amt;
	}
	public void setHni_0_loan_bill_amt(BigDecimal hni_0_loan_bill_amt) {
		this.hni_0_loan_bill_amt = hni_0_loan_bill_amt;
	}
	public BigDecimal getHni_0_loan_tot_bal() {
		return hni_0_loan_tot_bal;
	}
	public void setHni_0_loan_tot_bal(BigDecimal hni_0_loan_tot_bal) {
		this.hni_0_loan_tot_bal = hni_0_loan_tot_bal;
	}
	public BigDecimal getHni_0_loan_tot_prov() {
		return hni_0_loan_tot_prov;
	}
	public void setHni_0_loan_tot_prov(BigDecimal hni_0_loan_tot_prov) {
		this.hni_0_loan_tot_prov = hni_0_loan_tot_prov;
	}
	public BigDecimal getHni_0_loan_int_sus() {
		return hni_0_loan_int_sus;
	}
	public void setHni_0_loan_int_sus(BigDecimal hni_0_loan_int_sus) {
		this.hni_0_loan_int_sus = hni_0_loan_int_sus;
	}
	public BigDecimal getHni_0_loan_crm() {
		return hni_0_loan_crm;
	}
	public void setHni_0_loan_crm(BigDecimal hni_0_loan_crm) {
		this.hni_0_loan_crm = hni_0_loan_crm;
	}
	public BigDecimal getHni_0_loan_tot_dra() {
		return hni_0_loan_tot_dra;
	}
	public void setHni_0_loan_tot_dra(BigDecimal hni_0_loan_tot_dra) {
		this.hni_0_loan_tot_dra = hni_0_loan_tot_dra;
	}
	public BigDecimal getHni_0_inves_bal() {
		return hni_0_inves_bal;
	}
	public void setHni_0_inves_bal(BigDecimal hni_0_inves_bal) {
		this.hni_0_inves_bal = hni_0_inves_bal;
	}
	public BigDecimal getHni_0_inves_prov() {
		return hni_0_inves_prov;
	}
	public void setHni_0_inves_prov(BigDecimal hni_0_inves_prov) {
		this.hni_0_inves_prov = hni_0_inves_prov;
	}
	public BigDecimal getHni_0_inves_crm() {
		return hni_0_inves_crm;
	}
	public void setHni_0_inves_crm(BigDecimal hni_0_inves_crm) {
		this.hni_0_inves_crm = hni_0_inves_crm;
	}
	public BigDecimal getHni_0_inves_rwa() {
		return hni_0_inves_rwa;
	}
	public void setHni_0_inves_rwa(BigDecimal hni_0_inves_rwa) {
		this.hni_0_inves_rwa = hni_0_inves_rwa;
	}
	public BigDecimal getHni_0_plac_bal() {
		return hni_0_plac_bal;
	}
	public void setHni_0_plac_bal(BigDecimal hni_0_plac_bal) {
		this.hni_0_plac_bal = hni_0_plac_bal;
	}
	public BigDecimal getHni_0_plac_prov() {
		return hni_0_plac_prov;
	}
	public void setHni_0_plac_prov(BigDecimal hni_0_plac_prov) {
		this.hni_0_plac_prov = hni_0_plac_prov;
	}
	public BigDecimal getHni_0_plac_crm() {
		return hni_0_plac_crm;
	}
	public void setHni_0_plac_crm(BigDecimal hni_0_plac_crm) {
		this.hni_0_plac_crm = hni_0_plac_crm;
	}
	public BigDecimal getHni_0_plac_rwa() {
		return hni_0_plac_rwa;
	}
	public void setHni_0_plac_rwa(BigDecimal hni_0_plac_rwa) {
		this.hni_0_plac_rwa = hni_0_plac_rwa;
	}
	public BigDecimal getHni_0_cash_bal() {
		return hni_0_cash_bal;
	}
	public void setHni_0_cash_bal(BigDecimal hni_0_cash_bal) {
		this.hni_0_cash_bal = hni_0_cash_bal;
	}
	public BigDecimal getHni_0_cash_prov() {
		return hni_0_cash_prov;
	}
	public void setHni_0_cash_prov(BigDecimal hni_0_cash_prov) {
		this.hni_0_cash_prov = hni_0_cash_prov;
	}
	public BigDecimal getHni_0_cash_crm() {
		return hni_0_cash_crm;
	}
	public void setHni_0_cash_crm(BigDecimal hni_0_cash_crm) {
		this.hni_0_cash_crm = hni_0_cash_crm;
	}
	public BigDecimal getHni_0_cash_rwa() {
		return hni_0_cash_rwa;
	}
	public void setHni_0_cash_rwa(BigDecimal hni_0_cash_rwa) {
		this.hni_0_cash_rwa = hni_0_cash_rwa;
	}
	public BigDecimal getHni_0_tot_bal() {
		return hni_0_tot_bal;
	}
	public void setHni_0_tot_bal(BigDecimal hni_0_tot_bal) {
		this.hni_0_tot_bal = hni_0_tot_bal;
	}
	public BigDecimal getHni_0_tot_prov() {
		return hni_0_tot_prov;
	}
	public void setHni_0_tot_prov(BigDecimal hni_0_tot_prov) {
		this.hni_0_tot_prov = hni_0_tot_prov;
	}
	public BigDecimal getHni_0_tot_int_sus() {
		return hni_0_tot_int_sus;
	}
	public void setHni_0_tot_int_sus(BigDecimal hni_0_tot_int_sus) {
		this.hni_0_tot_int_sus = hni_0_tot_int_sus;
	}
	public BigDecimal getHni_0_tot_crm() {
		return hni_0_tot_crm;
	}
	public void setHni_0_tot_crm(BigDecimal hni_0_tot_crm) {
		this.hni_0_tot_crm = hni_0_tot_crm;
	}
	public BigDecimal getHni_0_tot_rwa() {
		return hni_0_tot_rwa;
	}
	public void setHni_0_tot_rwa(BigDecimal hni_0_tot_rwa) {
		this.hni_0_tot_rwa = hni_0_tot_rwa;
	}
	public BigDecimal getHni_20_loan_bal() {
		return hni_20_loan_bal;
	}
	public void setHni_20_loan_bal(BigDecimal hni_20_loan_bal) {
		this.hni_20_loan_bal = hni_20_loan_bal;
	}
	public BigDecimal getHni_20_loan_bill_amt() {
		return hni_20_loan_bill_amt;
	}
	public void setHni_20_loan_bill_amt(BigDecimal hni_20_loan_bill_amt) {
		this.hni_20_loan_bill_amt = hni_20_loan_bill_amt;
	}
	public BigDecimal getHni_20_loan_tot_bal() {
		return hni_20_loan_tot_bal;
	}
	public void setHni_20_loan_tot_bal(BigDecimal hni_20_loan_tot_bal) {
		this.hni_20_loan_tot_bal = hni_20_loan_tot_bal;
	}
	public BigDecimal getHni_20_loan_tot_prov() {
		return hni_20_loan_tot_prov;
	}
	public void setHni_20_loan_tot_prov(BigDecimal hni_20_loan_tot_prov) {
		this.hni_20_loan_tot_prov = hni_20_loan_tot_prov;
	}
	public BigDecimal getHni_20_loan_int_sus() {
		return hni_20_loan_int_sus;
	}
	public void setHni_20_loan_int_sus(BigDecimal hni_20_loan_int_sus) {
		this.hni_20_loan_int_sus = hni_20_loan_int_sus;
	}
	public BigDecimal getHni_20_loan_crm() {
		return hni_20_loan_crm;
	}
	public void setHni_20_loan_crm(BigDecimal hni_20_loan_crm) {
		this.hni_20_loan_crm = hni_20_loan_crm;
	}
	public BigDecimal getHni_20_loan_tot_dra() {
		return hni_20_loan_tot_dra;
	}
	public void setHni_20_loan_tot_dra(BigDecimal hni_20_loan_tot_dra) {
		this.hni_20_loan_tot_dra = hni_20_loan_tot_dra;
	}
	public BigDecimal getHni_20_inves_bal() {
		return hni_20_inves_bal;
	}
	public void setHni_20_inves_bal(BigDecimal hni_20_inves_bal) {
		this.hni_20_inves_bal = hni_20_inves_bal;
	}
	public BigDecimal getHni_20_inves_prov() {
		return hni_20_inves_prov;
	}
	public void setHni_20_inves_prov(BigDecimal hni_20_inves_prov) {
		this.hni_20_inves_prov = hni_20_inves_prov;
	}
	public BigDecimal getHni_20_inves_crm() {
		return hni_20_inves_crm;
	}
	public void setHni_20_inves_crm(BigDecimal hni_20_inves_crm) {
		this.hni_20_inves_crm = hni_20_inves_crm;
	}
	public BigDecimal getHni_20_inves_rwa() {
		return hni_20_inves_rwa;
	}
	public void setHni_20_inves_rwa(BigDecimal hni_20_inves_rwa) {
		this.hni_20_inves_rwa = hni_20_inves_rwa;
	}
	public BigDecimal getHni_20_plac_bal() {
		return hni_20_plac_bal;
	}
	public void setHni_20_plac_bal(BigDecimal hni_20_plac_bal) {
		this.hni_20_plac_bal = hni_20_plac_bal;
	}
	public BigDecimal getHni_20_plac_prov() {
		return hni_20_plac_prov;
	}
	public void setHni_20_plac_prov(BigDecimal hni_20_plac_prov) {
		this.hni_20_plac_prov = hni_20_plac_prov;
	}
	public BigDecimal getHni_20_plac_crm() {
		return hni_20_plac_crm;
	}
	public void setHni_20_plac_crm(BigDecimal hni_20_plac_crm) {
		this.hni_20_plac_crm = hni_20_plac_crm;
	}
	public BigDecimal getHni_20_plac_rwa() {
		return hni_20_plac_rwa;
	}
	public void setHni_20_plac_rwa(BigDecimal hni_20_plac_rwa) {
		this.hni_20_plac_rwa = hni_20_plac_rwa;
	}
	public BigDecimal getHni_20_cash_bal() {
		return hni_20_cash_bal;
	}
	public void setHni_20_cash_bal(BigDecimal hni_20_cash_bal) {
		this.hni_20_cash_bal = hni_20_cash_bal;
	}
	public BigDecimal getHni_20_cash_prov() {
		return hni_20_cash_prov;
	}
	public void setHni_20_cash_prov(BigDecimal hni_20_cash_prov) {
		this.hni_20_cash_prov = hni_20_cash_prov;
	}
	public BigDecimal getHni_20_cash_crm() {
		return hni_20_cash_crm;
	}
	public void setHni_20_cash_crm(BigDecimal hni_20_cash_crm) {
		this.hni_20_cash_crm = hni_20_cash_crm;
	}
	public BigDecimal getHni_20_cash_rwa() {
		return hni_20_cash_rwa;
	}
	public void setHni_20_cash_rwa(BigDecimal hni_20_cash_rwa) {
		this.hni_20_cash_rwa = hni_20_cash_rwa;
	}
	public BigDecimal getHni_20_tot_bal() {
		return hni_20_tot_bal;
	}
	public void setHni_20_tot_bal(BigDecimal hni_20_tot_bal) {
		this.hni_20_tot_bal = hni_20_tot_bal;
	}
	public BigDecimal getHni_20_tot_prov() {
		return hni_20_tot_prov;
	}
	public void setHni_20_tot_prov(BigDecimal hni_20_tot_prov) {
		this.hni_20_tot_prov = hni_20_tot_prov;
	}
	public BigDecimal getHni_20_tot_int_sus() {
		return hni_20_tot_int_sus;
	}
	public void setHni_20_tot_int_sus(BigDecimal hni_20_tot_int_sus) {
		this.hni_20_tot_int_sus = hni_20_tot_int_sus;
	}
	public BigDecimal getHni_20_tot_crm() {
		return hni_20_tot_crm;
	}
	public void setHni_20_tot_crm(BigDecimal hni_20_tot_crm) {
		this.hni_20_tot_crm = hni_20_tot_crm;
	}
	public BigDecimal getHni_20_tot_rwa() {
		return hni_20_tot_rwa;
	}
	public void setHni_20_tot_rwa(BigDecimal hni_20_tot_rwa) {
		this.hni_20_tot_rwa = hni_20_tot_rwa;
	}
	public BigDecimal getHni_50_loan_bal() {
		return hni_50_loan_bal;
	}
	public void setHni_50_loan_bal(BigDecimal hni_50_loan_bal) {
		this.hni_50_loan_bal = hni_50_loan_bal;
	}
	public BigDecimal getHni_50_loan_bill_amt() {
		return hni_50_loan_bill_amt;
	}
	public void setHni_50_loan_bill_amt(BigDecimal hni_50_loan_bill_amt) {
		this.hni_50_loan_bill_amt = hni_50_loan_bill_amt;
	}
	public BigDecimal getHni_50_loan_tot_bal() {
		return hni_50_loan_tot_bal;
	}
	public void setHni_50_loan_tot_bal(BigDecimal hni_50_loan_tot_bal) {
		this.hni_50_loan_tot_bal = hni_50_loan_tot_bal;
	}
	public BigDecimal getHni_50_loan_tot_prov() {
		return hni_50_loan_tot_prov;
	}
	public void setHni_50_loan_tot_prov(BigDecimal hni_50_loan_tot_prov) {
		this.hni_50_loan_tot_prov = hni_50_loan_tot_prov;
	}
	public BigDecimal getHni_50_loan_int_sus() {
		return hni_50_loan_int_sus;
	}
	public void setHni_50_loan_int_sus(BigDecimal hni_50_loan_int_sus) {
		this.hni_50_loan_int_sus = hni_50_loan_int_sus;
	}
	public BigDecimal getHni_50_loan_crm() {
		return hni_50_loan_crm;
	}
	public void setHni_50_loan_crm(BigDecimal hni_50_loan_crm) {
		this.hni_50_loan_crm = hni_50_loan_crm;
	}
	public BigDecimal getHni_50_loan_tot_dra() {
		return hni_50_loan_tot_dra;
	}
	public void setHni_50_loan_tot_dra(BigDecimal hni_50_loan_tot_dra) {
		this.hni_50_loan_tot_dra = hni_50_loan_tot_dra;
	}
	public BigDecimal getHni_50_inves_bal() {
		return hni_50_inves_bal;
	}
	public void setHni_50_inves_bal(BigDecimal hni_50_inves_bal) {
		this.hni_50_inves_bal = hni_50_inves_bal;
	}
	public BigDecimal getHni_50_inves_prov() {
		return hni_50_inves_prov;
	}
	public void setHni_50_inves_prov(BigDecimal hni_50_inves_prov) {
		this.hni_50_inves_prov = hni_50_inves_prov;
	}
	public BigDecimal getHni_50_inves_crm() {
		return hni_50_inves_crm;
	}
	public void setHni_50_inves_crm(BigDecimal hni_50_inves_crm) {
		this.hni_50_inves_crm = hni_50_inves_crm;
	}
	public BigDecimal getHni_50_inves_rwa() {
		return hni_50_inves_rwa;
	}
	public void setHni_50_inves_rwa(BigDecimal hni_50_inves_rwa) {
		this.hni_50_inves_rwa = hni_50_inves_rwa;
	}
	public BigDecimal getHni_50_plac_bal() {
		return hni_50_plac_bal;
	}
	public void setHni_50_plac_bal(BigDecimal hni_50_plac_bal) {
		this.hni_50_plac_bal = hni_50_plac_bal;
	}
	public BigDecimal getHni_50_plac_prov() {
		return hni_50_plac_prov;
	}
	public void setHni_50_plac_prov(BigDecimal hni_50_plac_prov) {
		this.hni_50_plac_prov = hni_50_plac_prov;
	}
	public BigDecimal getHni_50_plac_crm() {
		return hni_50_plac_crm;
	}
	public void setHni_50_plac_crm(BigDecimal hni_50_plac_crm) {
		this.hni_50_plac_crm = hni_50_plac_crm;
	}
	public BigDecimal getHni_50_plac_rwa() {
		return hni_50_plac_rwa;
	}
	public void setHni_50_plac_rwa(BigDecimal hni_50_plac_rwa) {
		this.hni_50_plac_rwa = hni_50_plac_rwa;
	}
	public BigDecimal getHni_50_cash_bal() {
		return hni_50_cash_bal;
	}
	public void setHni_50_cash_bal(BigDecimal hni_50_cash_bal) {
		this.hni_50_cash_bal = hni_50_cash_bal;
	}
	public BigDecimal getHni_50_cash_prov() {
		return hni_50_cash_prov;
	}
	public void setHni_50_cash_prov(BigDecimal hni_50_cash_prov) {
		this.hni_50_cash_prov = hni_50_cash_prov;
	}
	public BigDecimal getHni_50_cash_crm() {
		return hni_50_cash_crm;
	}
	public void setHni_50_cash_crm(BigDecimal hni_50_cash_crm) {
		this.hni_50_cash_crm = hni_50_cash_crm;
	}
	public BigDecimal getHni_50_cash_rwa() {
		return hni_50_cash_rwa;
	}
	public void setHni_50_cash_rwa(BigDecimal hni_50_cash_rwa) {
		this.hni_50_cash_rwa = hni_50_cash_rwa;
	}
	public BigDecimal getHni_50_tot_bal() {
		return hni_50_tot_bal;
	}
	public void setHni_50_tot_bal(BigDecimal hni_50_tot_bal) {
		this.hni_50_tot_bal = hni_50_tot_bal;
	}
	public BigDecimal getHni_50_tot_prov() {
		return hni_50_tot_prov;
	}
	public void setHni_50_tot_prov(BigDecimal hni_50_tot_prov) {
		this.hni_50_tot_prov = hni_50_tot_prov;
	}
	public BigDecimal getHni_50_tot_int_sus() {
		return hni_50_tot_int_sus;
	}
	public void setHni_50_tot_int_sus(BigDecimal hni_50_tot_int_sus) {
		this.hni_50_tot_int_sus = hni_50_tot_int_sus;
	}
	public BigDecimal getHni_50_tot_crm() {
		return hni_50_tot_crm;
	}
	public void setHni_50_tot_crm(BigDecimal hni_50_tot_crm) {
		this.hni_50_tot_crm = hni_50_tot_crm;
	}
	public BigDecimal getHni_50_tot_rwa() {
		return hni_50_tot_rwa;
	}
	public void setHni_50_tot_rwa(BigDecimal hni_50_tot_rwa) {
		this.hni_50_tot_rwa = hni_50_tot_rwa;
	}
	public BigDecimal getHni_150_loan_bal() {
		return hni_150_loan_bal;
	}
	public void setHni_150_loan_bal(BigDecimal hni_150_loan_bal) {
		this.hni_150_loan_bal = hni_150_loan_bal;
	}
	public BigDecimal getHni_150_loan_bill_amt() {
		return hni_150_loan_bill_amt;
	}
	public void setHni_150_loan_bill_amt(BigDecimal hni_150_loan_bill_amt) {
		this.hni_150_loan_bill_amt = hni_150_loan_bill_amt;
	}
	public BigDecimal getHni_150_loan_tot_bal() {
		return hni_150_loan_tot_bal;
	}
	public void setHni_150_loan_tot_bal(BigDecimal hni_150_loan_tot_bal) {
		this.hni_150_loan_tot_bal = hni_150_loan_tot_bal;
	}
	public BigDecimal getHni_150_loan_tot_prov() {
		return hni_150_loan_tot_prov;
	}
	public void setHni_150_loan_tot_prov(BigDecimal hni_150_loan_tot_prov) {
		this.hni_150_loan_tot_prov = hni_150_loan_tot_prov;
	}
	public BigDecimal getHni_150_loan_int_sus() {
		return hni_150_loan_int_sus;
	}
	public void setHni_150_loan_int_sus(BigDecimal hni_150_loan_int_sus) {
		this.hni_150_loan_int_sus = hni_150_loan_int_sus;
	}
	public BigDecimal getHni_150_loan_crm() {
		return hni_150_loan_crm;
	}
	public void setHni_150_loan_crm(BigDecimal hni_150_loan_crm) {
		this.hni_150_loan_crm = hni_150_loan_crm;
	}
	public BigDecimal getHni_150_loan_tot_dra() {
		return hni_150_loan_tot_dra;
	}
	public void setHni_150_loan_tot_dra(BigDecimal hni_150_loan_tot_dra) {
		this.hni_150_loan_tot_dra = hni_150_loan_tot_dra;
	}
	public BigDecimal getHni_150_inves_bal() {
		return hni_150_inves_bal;
	}
	public void setHni_150_inves_bal(BigDecimal hni_150_inves_bal) {
		this.hni_150_inves_bal = hni_150_inves_bal;
	}
	public BigDecimal getHni_150_inves_prov() {
		return hni_150_inves_prov;
	}
	public void setHni_150_inves_prov(BigDecimal hni_150_inves_prov) {
		this.hni_150_inves_prov = hni_150_inves_prov;
	}
	public BigDecimal getHni_150_inves_crm() {
		return hni_150_inves_crm;
	}
	public void setHni_150_inves_crm(BigDecimal hni_150_inves_crm) {
		this.hni_150_inves_crm = hni_150_inves_crm;
	}
	public BigDecimal getHni_150_inves_rwa() {
		return hni_150_inves_rwa;
	}
	public void setHni_150_inves_rwa(BigDecimal hni_150_inves_rwa) {
		this.hni_150_inves_rwa = hni_150_inves_rwa;
	}
	public BigDecimal getHni_150_plac_bal() {
		return hni_150_plac_bal;
	}
	public void setHni_150_plac_bal(BigDecimal hni_150_plac_bal) {
		this.hni_150_plac_bal = hni_150_plac_bal;
	}
	public BigDecimal getHni_150_plac_prov() {
		return hni_150_plac_prov;
	}
	public void setHni_150_plac_prov(BigDecimal hni_150_plac_prov) {
		this.hni_150_plac_prov = hni_150_plac_prov;
	}
	public BigDecimal getHni_150_plac_crm() {
		return hni_150_plac_crm;
	}
	public void setHni_150_plac_crm(BigDecimal hni_150_plac_crm) {
		this.hni_150_plac_crm = hni_150_plac_crm;
	}
	public BigDecimal getHni_150_plac_rwa() {
		return hni_150_plac_rwa;
	}
	public void setHni_150_plac_rwa(BigDecimal hni_150_plac_rwa) {
		this.hni_150_plac_rwa = hni_150_plac_rwa;
	}
	public BigDecimal getHni_150_cash_bal() {
		return hni_150_cash_bal;
	}
	public void setHni_150_cash_bal(BigDecimal hni_150_cash_bal) {
		this.hni_150_cash_bal = hni_150_cash_bal;
	}
	public BigDecimal getHni_150_cash_prov() {
		return hni_150_cash_prov;
	}
	public void setHni_150_cash_prov(BigDecimal hni_150_cash_prov) {
		this.hni_150_cash_prov = hni_150_cash_prov;
	}
	public BigDecimal getHni_150_cash_crm() {
		return hni_150_cash_crm;
	}
	public void setHni_150_cash_crm(BigDecimal hni_150_cash_crm) {
		this.hni_150_cash_crm = hni_150_cash_crm;
	}
	public BigDecimal getHni_150_cash_rwa() {
		return hni_150_cash_rwa;
	}
	public void setHni_150_cash_rwa(BigDecimal hni_150_cash_rwa) {
		this.hni_150_cash_rwa = hni_150_cash_rwa;
	}
	public BigDecimal getHni_150_tot_bal() {
		return hni_150_tot_bal;
	}
	public void setHni_150_tot_bal(BigDecimal hni_150_tot_bal) {
		this.hni_150_tot_bal = hni_150_tot_bal;
	}
	public BigDecimal getHni_150_tot_prov() {
		return hni_150_tot_prov;
	}
	public void setHni_150_tot_prov(BigDecimal hni_150_tot_prov) {
		this.hni_150_tot_prov = hni_150_tot_prov;
	}
	public BigDecimal getHni_150_tot_int_sus() {
		return hni_150_tot_int_sus;
	}
	public void setHni_150_tot_int_sus(BigDecimal hni_150_tot_int_sus) {
		this.hni_150_tot_int_sus = hni_150_tot_int_sus;
	}
	public BigDecimal getHni_150_tot_crm() {
		return hni_150_tot_crm;
	}
	public void setHni_150_tot_crm(BigDecimal hni_150_tot_crm) {
		this.hni_150_tot_crm = hni_150_tot_crm;
	}
	public BigDecimal getHni_150_tot_rwa() {
		return hni_150_tot_rwa;
	}
	public void setHni_150_tot_rwa(BigDecimal hni_150_tot_rwa) {
		this.hni_150_tot_rwa = hni_150_tot_rwa;
	}
	public BigDecimal getPdl_0_loan_bal() {
		return pdl_0_loan_bal;
	}
	public void setPdl_0_loan_bal(BigDecimal pdl_0_loan_bal) {
		this.pdl_0_loan_bal = pdl_0_loan_bal;
	}
	public BigDecimal getPdl_0_loan_bill_amt() {
		return pdl_0_loan_bill_amt;
	}
	public void setPdl_0_loan_bill_amt(BigDecimal pdl_0_loan_bill_amt) {
		this.pdl_0_loan_bill_amt = pdl_0_loan_bill_amt;
	}
	public BigDecimal getPdl_0_loan_tot_bal() {
		return pdl_0_loan_tot_bal;
	}
	public void setPdl_0_loan_tot_bal(BigDecimal pdl_0_loan_tot_bal) {
		this.pdl_0_loan_tot_bal = pdl_0_loan_tot_bal;
	}
	public BigDecimal getPdl_0_loan_tot_prov() {
		return pdl_0_loan_tot_prov;
	}
	public void setPdl_0_loan_tot_prov(BigDecimal pdl_0_loan_tot_prov) {
		this.pdl_0_loan_tot_prov = pdl_0_loan_tot_prov;
	}
	public BigDecimal getPdl_0_loan_int_sus() {
		return pdl_0_loan_int_sus;
	}
	public void setPdl_0_loan_int_sus(BigDecimal pdl_0_loan_int_sus) {
		this.pdl_0_loan_int_sus = pdl_0_loan_int_sus;
	}
	public BigDecimal getPdl_0_loan_crm() {
		return pdl_0_loan_crm;
	}
	public void setPdl_0_loan_crm(BigDecimal pdl_0_loan_crm) {
		this.pdl_0_loan_crm = pdl_0_loan_crm;
	}
	public BigDecimal getPdl_0_loan_tot_dra() {
		return pdl_0_loan_tot_dra;
	}
	public void setPdl_0_loan_tot_dra(BigDecimal pdl_0_loan_tot_dra) {
		this.pdl_0_loan_tot_dra = pdl_0_loan_tot_dra;
	}
	public BigDecimal getPdl_0_inves_bal() {
		return pdl_0_inves_bal;
	}
	public void setPdl_0_inves_bal(BigDecimal pdl_0_inves_bal) {
		this.pdl_0_inves_bal = pdl_0_inves_bal;
	}
	public BigDecimal getPdl_0_inves_prov() {
		return pdl_0_inves_prov;
	}
	public void setPdl_0_inves_prov(BigDecimal pdl_0_inves_prov) {
		this.pdl_0_inves_prov = pdl_0_inves_prov;
	}
	public BigDecimal getPdl_0_inves_crm() {
		return pdl_0_inves_crm;
	}
	public void setPdl_0_inves_crm(BigDecimal pdl_0_inves_crm) {
		this.pdl_0_inves_crm = pdl_0_inves_crm;
	}
	public BigDecimal getPdl_0_inves_rwa() {
		return pdl_0_inves_rwa;
	}
	public void setPdl_0_inves_rwa(BigDecimal pdl_0_inves_rwa) {
		this.pdl_0_inves_rwa = pdl_0_inves_rwa;
	}
	public BigDecimal getPdl_0_plac_bal() {
		return pdl_0_plac_bal;
	}
	public void setPdl_0_plac_bal(BigDecimal pdl_0_plac_bal) {
		this.pdl_0_plac_bal = pdl_0_plac_bal;
	}
	public BigDecimal getPdl_0_plac_prov() {
		return pdl_0_plac_prov;
	}
	public void setPdl_0_plac_prov(BigDecimal pdl_0_plac_prov) {
		this.pdl_0_plac_prov = pdl_0_plac_prov;
	}
	public BigDecimal getPdl_0_plac_crm() {
		return pdl_0_plac_crm;
	}
	public void setPdl_0_plac_crm(BigDecimal pdl_0_plac_crm) {
		this.pdl_0_plac_crm = pdl_0_plac_crm;
	}
	public BigDecimal getPdl_0_plac_rwa() {
		return pdl_0_plac_rwa;
	}
	public void setPdl_0_plac_rwa(BigDecimal pdl_0_plac_rwa) {
		this.pdl_0_plac_rwa = pdl_0_plac_rwa;
	}
	public BigDecimal getPdl_0_cash_bal() {
		return pdl_0_cash_bal;
	}
	public void setPdl_0_cash_bal(BigDecimal pdl_0_cash_bal) {
		this.pdl_0_cash_bal = pdl_0_cash_bal;
	}
	public BigDecimal getPdl_0_cash_prov() {
		return pdl_0_cash_prov;
	}
	public void setPdl_0_cash_prov(BigDecimal pdl_0_cash_prov) {
		this.pdl_0_cash_prov = pdl_0_cash_prov;
	}
	public BigDecimal getPdl_0_cash_crm() {
		return pdl_0_cash_crm;
	}
	public void setPdl_0_cash_crm(BigDecimal pdl_0_cash_crm) {
		this.pdl_0_cash_crm = pdl_0_cash_crm;
	}
	public BigDecimal getPdl_0_cash_rwa() {
		return pdl_0_cash_rwa;
	}
	public void setPdl_0_cash_rwa(BigDecimal pdl_0_cash_rwa) {
		this.pdl_0_cash_rwa = pdl_0_cash_rwa;
	}
	public BigDecimal getPdl_0_tot_bal() {
		return pdl_0_tot_bal;
	}
	public void setPdl_0_tot_bal(BigDecimal pdl_0_tot_bal) {
		this.pdl_0_tot_bal = pdl_0_tot_bal;
	}
	public BigDecimal getPdl_0_tot_prov() {
		return pdl_0_tot_prov;
	}
	public void setPdl_0_tot_prov(BigDecimal pdl_0_tot_prov) {
		this.pdl_0_tot_prov = pdl_0_tot_prov;
	}
	public BigDecimal getPdl_0_tot_int_sus() {
		return pdl_0_tot_int_sus;
	}
	public void setPdl_0_tot_int_sus(BigDecimal pdl_0_tot_int_sus) {
		this.pdl_0_tot_int_sus = pdl_0_tot_int_sus;
	}
	public BigDecimal getPdl_0_tot_crm() {
		return pdl_0_tot_crm;
	}
	public void setPdl_0_tot_crm(BigDecimal pdl_0_tot_crm) {
		this.pdl_0_tot_crm = pdl_0_tot_crm;
	}
	public BigDecimal getPdl_0_tot_rwa() {
		return pdl_0_tot_rwa;
	}
	public void setPdl_0_tot_rwa(BigDecimal pdl_0_tot_rwa) {
		this.pdl_0_tot_rwa = pdl_0_tot_rwa;
	}
	public BigDecimal getPdl_20_loan_bal() {
		return pdl_20_loan_bal;
	}
	public void setPdl_20_loan_bal(BigDecimal pdl_20_loan_bal) {
		this.pdl_20_loan_bal = pdl_20_loan_bal;
	}
	public BigDecimal getPdl_20_loan_bill_amt() {
		return pdl_20_loan_bill_amt;
	}
	public void setPdl_20_loan_bill_amt(BigDecimal pdl_20_loan_bill_amt) {
		this.pdl_20_loan_bill_amt = pdl_20_loan_bill_amt;
	}
	public BigDecimal getPdl_20_loan_tot_bal() {
		return pdl_20_loan_tot_bal;
	}
	public void setPdl_20_loan_tot_bal(BigDecimal pdl_20_loan_tot_bal) {
		this.pdl_20_loan_tot_bal = pdl_20_loan_tot_bal;
	}
	public BigDecimal getPdl_20_loan_tot_prov() {
		return pdl_20_loan_tot_prov;
	}
	public void setPdl_20_loan_tot_prov(BigDecimal pdl_20_loan_tot_prov) {
		this.pdl_20_loan_tot_prov = pdl_20_loan_tot_prov;
	}
	public BigDecimal getPdl_20_loan_int_sus() {
		return pdl_20_loan_int_sus;
	}
	public void setPdl_20_loan_int_sus(BigDecimal pdl_20_loan_int_sus) {
		this.pdl_20_loan_int_sus = pdl_20_loan_int_sus;
	}
	public BigDecimal getPdl_20_loan_crm() {
		return pdl_20_loan_crm;
	}
	public void setPdl_20_loan_crm(BigDecimal pdl_20_loan_crm) {
		this.pdl_20_loan_crm = pdl_20_loan_crm;
	}
	public BigDecimal getPdl_20_loan_tot_dra() {
		return pdl_20_loan_tot_dra;
	}
	public void setPdl_20_loan_tot_dra(BigDecimal pdl_20_loan_tot_dra) {
		this.pdl_20_loan_tot_dra = pdl_20_loan_tot_dra;
	}
	public BigDecimal getPdl_20_inves_bal() {
		return pdl_20_inves_bal;
	}
	public void setPdl_20_inves_bal(BigDecimal pdl_20_inves_bal) {
		this.pdl_20_inves_bal = pdl_20_inves_bal;
	}
	public BigDecimal getPdl_20_inves_prov() {
		return pdl_20_inves_prov;
	}
	public void setPdl_20_inves_prov(BigDecimal pdl_20_inves_prov) {
		this.pdl_20_inves_prov = pdl_20_inves_prov;
	}
	public BigDecimal getPdl_20_inves_crm() {
		return pdl_20_inves_crm;
	}
	public void setPdl_20_inves_crm(BigDecimal pdl_20_inves_crm) {
		this.pdl_20_inves_crm = pdl_20_inves_crm;
	}
	public BigDecimal getPdl_20_inves_rwa() {
		return pdl_20_inves_rwa;
	}
	public void setPdl_20_inves_rwa(BigDecimal pdl_20_inves_rwa) {
		this.pdl_20_inves_rwa = pdl_20_inves_rwa;
	}
	public BigDecimal getPdl_20_plac_bal() {
		return pdl_20_plac_bal;
	}
	public void setPdl_20_plac_bal(BigDecimal pdl_20_plac_bal) {
		this.pdl_20_plac_bal = pdl_20_plac_bal;
	}
	public BigDecimal getPdl_20_plac_prov() {
		return pdl_20_plac_prov;
	}
	public void setPdl_20_plac_prov(BigDecimal pdl_20_plac_prov) {
		this.pdl_20_plac_prov = pdl_20_plac_prov;
	}
	public BigDecimal getPdl_20_plac_crm() {
		return pdl_20_plac_crm;
	}
	public void setPdl_20_plac_crm(BigDecimal pdl_20_plac_crm) {
		this.pdl_20_plac_crm = pdl_20_plac_crm;
	}
	public BigDecimal getPdl_20_plac_rwa() {
		return pdl_20_plac_rwa;
	}
	public void setPdl_20_plac_rwa(BigDecimal pdl_20_plac_rwa) {
		this.pdl_20_plac_rwa = pdl_20_plac_rwa;
	}
	public BigDecimal getPdl_20_cash_bal() {
		return pdl_20_cash_bal;
	}
	public void setPdl_20_cash_bal(BigDecimal pdl_20_cash_bal) {
		this.pdl_20_cash_bal = pdl_20_cash_bal;
	}
	public BigDecimal getPdl_20_cash_prov() {
		return pdl_20_cash_prov;
	}
	public void setPdl_20_cash_prov(BigDecimal pdl_20_cash_prov) {
		this.pdl_20_cash_prov = pdl_20_cash_prov;
	}
	public BigDecimal getPdl_20_cash_crm() {
		return pdl_20_cash_crm;
	}
	public void setPdl_20_cash_crm(BigDecimal pdl_20_cash_crm) {
		this.pdl_20_cash_crm = pdl_20_cash_crm;
	}
	public BigDecimal getPdl_20_cash_rwa() {
		return pdl_20_cash_rwa;
	}
	public void setPdl_20_cash_rwa(BigDecimal pdl_20_cash_rwa) {
		this.pdl_20_cash_rwa = pdl_20_cash_rwa;
	}
	public BigDecimal getPdl_20_tot_bal() {
		return pdl_20_tot_bal;
	}
	public void setPdl_20_tot_bal(BigDecimal pdl_20_tot_bal) {
		this.pdl_20_tot_bal = pdl_20_tot_bal;
	}
	public BigDecimal getPdl_20_tot_prov() {
		return pdl_20_tot_prov;
	}
	public void setPdl_20_tot_prov(BigDecimal pdl_20_tot_prov) {
		this.pdl_20_tot_prov = pdl_20_tot_prov;
	}
	public BigDecimal getPdl_20_tot_int_sus() {
		return pdl_20_tot_int_sus;
	}
	public void setPdl_20_tot_int_sus(BigDecimal pdl_20_tot_int_sus) {
		this.pdl_20_tot_int_sus = pdl_20_tot_int_sus;
	}
	public BigDecimal getPdl_20_tot_crm() {
		return pdl_20_tot_crm;
	}
	public void setPdl_20_tot_crm(BigDecimal pdl_20_tot_crm) {
		this.pdl_20_tot_crm = pdl_20_tot_crm;
	}
	public BigDecimal getPdl_20_tot_rwa() {
		return pdl_20_tot_rwa;
	}
	public void setPdl_20_tot_rwa(BigDecimal pdl_20_tot_rwa) {
		this.pdl_20_tot_rwa = pdl_20_tot_rwa;
	}
	public BigDecimal getPdl_50_loan_bal() {
		return pdl_50_loan_bal;
	}
	public void setPdl_50_loan_bal(BigDecimal pdl_50_loan_bal) {
		this.pdl_50_loan_bal = pdl_50_loan_bal;
	}
	public BigDecimal getPdl_50_loan_bill_amt() {
		return pdl_50_loan_bill_amt;
	}
	public void setPdl_50_loan_bill_amt(BigDecimal pdl_50_loan_bill_amt) {
		this.pdl_50_loan_bill_amt = pdl_50_loan_bill_amt;
	}
	public BigDecimal getPdl_50_loan_tot_bal() {
		return pdl_50_loan_tot_bal;
	}
	public void setPdl_50_loan_tot_bal(BigDecimal pdl_50_loan_tot_bal) {
		this.pdl_50_loan_tot_bal = pdl_50_loan_tot_bal;
	}
	public BigDecimal getPdl_50_loan_tot_prov() {
		return pdl_50_loan_tot_prov;
	}
	public void setPdl_50_loan_tot_prov(BigDecimal pdl_50_loan_tot_prov) {
		this.pdl_50_loan_tot_prov = pdl_50_loan_tot_prov;
	}
	public BigDecimal getPdl_50_loan_int_sus() {
		return pdl_50_loan_int_sus;
	}
	public void setPdl_50_loan_int_sus(BigDecimal pdl_50_loan_int_sus) {
		this.pdl_50_loan_int_sus = pdl_50_loan_int_sus;
	}
	public BigDecimal getPdl_50_loan_crm() {
		return pdl_50_loan_crm;
	}
	public void setPdl_50_loan_crm(BigDecimal pdl_50_loan_crm) {
		this.pdl_50_loan_crm = pdl_50_loan_crm;
	}
	public BigDecimal getPdl_50_loan_tot_dra() {
		return pdl_50_loan_tot_dra;
	}
	public void setPdl_50_loan_tot_dra(BigDecimal pdl_50_loan_tot_dra) {
		this.pdl_50_loan_tot_dra = pdl_50_loan_tot_dra;
	}
	public BigDecimal getPdl_50_inves_bal() {
		return pdl_50_inves_bal;
	}
	public void setPdl_50_inves_bal(BigDecimal pdl_50_inves_bal) {
		this.pdl_50_inves_bal = pdl_50_inves_bal;
	}
	public BigDecimal getPdl_50_inves_prov() {
		return pdl_50_inves_prov;
	}
	public void setPdl_50_inves_prov(BigDecimal pdl_50_inves_prov) {
		this.pdl_50_inves_prov = pdl_50_inves_prov;
	}
	public BigDecimal getPdl_50_inves_crm() {
		return pdl_50_inves_crm;
	}
	public void setPdl_50_inves_crm(BigDecimal pdl_50_inves_crm) {
		this.pdl_50_inves_crm = pdl_50_inves_crm;
	}
	public BigDecimal getPdl_50_inves_rwa() {
		return pdl_50_inves_rwa;
	}
	public void setPdl_50_inves_rwa(BigDecimal pdl_50_inves_rwa) {
		this.pdl_50_inves_rwa = pdl_50_inves_rwa;
	}
	public BigDecimal getPdl_50_plac_bal() {
		return pdl_50_plac_bal;
	}
	public void setPdl_50_plac_bal(BigDecimal pdl_50_plac_bal) {
		this.pdl_50_plac_bal = pdl_50_plac_bal;
	}
	public BigDecimal getPdl_50_plac_prov() {
		return pdl_50_plac_prov;
	}
	public void setPdl_50_plac_prov(BigDecimal pdl_50_plac_prov) {
		this.pdl_50_plac_prov = pdl_50_plac_prov;
	}
	public BigDecimal getPdl_50_plac_crm() {
		return pdl_50_plac_crm;
	}
	public void setPdl_50_plac_crm(BigDecimal pdl_50_plac_crm) {
		this.pdl_50_plac_crm = pdl_50_plac_crm;
	}
	public BigDecimal getPdl_50_plac_rwa() {
		return pdl_50_plac_rwa;
	}
	public void setPdl_50_plac_rwa(BigDecimal pdl_50_plac_rwa) {
		this.pdl_50_plac_rwa = pdl_50_plac_rwa;
	}
	public BigDecimal getPdl_50_cash_bal() {
		return pdl_50_cash_bal;
	}
	public void setPdl_50_cash_bal(BigDecimal pdl_50_cash_bal) {
		this.pdl_50_cash_bal = pdl_50_cash_bal;
	}
	public BigDecimal getPdl_50_cash_prov() {
		return pdl_50_cash_prov;
	}
	public void setPdl_50_cash_prov(BigDecimal pdl_50_cash_prov) {
		this.pdl_50_cash_prov = pdl_50_cash_prov;
	}
	public BigDecimal getPdl_50_cash_crm() {
		return pdl_50_cash_crm;
	}
	public void setPdl_50_cash_crm(BigDecimal pdl_50_cash_crm) {
		this.pdl_50_cash_crm = pdl_50_cash_crm;
	}
	public BigDecimal getPdl_50_cash_rwa() {
		return pdl_50_cash_rwa;
	}
	public void setPdl_50_cash_rwa(BigDecimal pdl_50_cash_rwa) {
		this.pdl_50_cash_rwa = pdl_50_cash_rwa;
	}
	public BigDecimal getPdl_50_tot_bal() {
		return pdl_50_tot_bal;
	}
	public void setPdl_50_tot_bal(BigDecimal pdl_50_tot_bal) {
		this.pdl_50_tot_bal = pdl_50_tot_bal;
	}
	public BigDecimal getPdl_50_tot_prov() {
		return pdl_50_tot_prov;
	}
	public void setPdl_50_tot_prov(BigDecimal pdl_50_tot_prov) {
		this.pdl_50_tot_prov = pdl_50_tot_prov;
	}
	public BigDecimal getPdl_50_tot_int_sus() {
		return pdl_50_tot_int_sus;
	}
	public void setPdl_50_tot_int_sus(BigDecimal pdl_50_tot_int_sus) {
		this.pdl_50_tot_int_sus = pdl_50_tot_int_sus;
	}
	public BigDecimal getPdl_50_tot_crm() {
		return pdl_50_tot_crm;
	}
	public void setPdl_50_tot_crm(BigDecimal pdl_50_tot_crm) {
		this.pdl_50_tot_crm = pdl_50_tot_crm;
	}
	public BigDecimal getPdl_50_tot_rwa() {
		return pdl_50_tot_rwa;
	}
	public void setPdl_50_tot_rwa(BigDecimal pdl_50_tot_rwa) {
		this.pdl_50_tot_rwa = pdl_50_tot_rwa;
	}
	public BigDecimal getRes_0_loan_bal() {
		return res_0_loan_bal;
	}
	public void setRes_0_loan_bal(BigDecimal res_0_loan_bal) {
		this.res_0_loan_bal = res_0_loan_bal;
	}
	public BigDecimal getRes_0_loan_bill_amt() {
		return res_0_loan_bill_amt;
	}
	public void setRes_0_loan_bill_amt(BigDecimal res_0_loan_bill_amt) {
		this.res_0_loan_bill_amt = res_0_loan_bill_amt;
	}
	public BigDecimal getRes_0_loan_tot_bal() {
		return res_0_loan_tot_bal;
	}
	public void setRes_0_loan_tot_bal(BigDecimal res_0_loan_tot_bal) {
		this.res_0_loan_tot_bal = res_0_loan_tot_bal;
	}
	public BigDecimal getRes_0_loan_tot_prov() {
		return res_0_loan_tot_prov;
	}
	public void setRes_0_loan_tot_prov(BigDecimal res_0_loan_tot_prov) {
		this.res_0_loan_tot_prov = res_0_loan_tot_prov;
	}
	public BigDecimal getRes_0_loan_int_sus() {
		return res_0_loan_int_sus;
	}
	public void setRes_0_loan_int_sus(BigDecimal res_0_loan_int_sus) {
		this.res_0_loan_int_sus = res_0_loan_int_sus;
	}
	public BigDecimal getRes_0_loan_crm() {
		return res_0_loan_crm;
	}
	public void setRes_0_loan_crm(BigDecimal res_0_loan_crm) {
		this.res_0_loan_crm = res_0_loan_crm;
	}
	public BigDecimal getRes_0_loan_tot_dra() {
		return res_0_loan_tot_dra;
	}
	public void setRes_0_loan_tot_dra(BigDecimal res_0_loan_tot_dra) {
		this.res_0_loan_tot_dra = res_0_loan_tot_dra;
	}
	public BigDecimal getRes_0_inves_bal() {
		return res_0_inves_bal;
	}
	public void setRes_0_inves_bal(BigDecimal res_0_inves_bal) {
		this.res_0_inves_bal = res_0_inves_bal;
	}
	public BigDecimal getRes_0_inves_prov() {
		return res_0_inves_prov;
	}
	public void setRes_0_inves_prov(BigDecimal res_0_inves_prov) {
		this.res_0_inves_prov = res_0_inves_prov;
	}
	public BigDecimal getRes_0_inves_crm() {
		return res_0_inves_crm;
	}
	public void setRes_0_inves_crm(BigDecimal res_0_inves_crm) {
		this.res_0_inves_crm = res_0_inves_crm;
	}
	public BigDecimal getRes_0_inves_rwa() {
		return res_0_inves_rwa;
	}
	public void setRes_0_inves_rwa(BigDecimal res_0_inves_rwa) {
		this.res_0_inves_rwa = res_0_inves_rwa;
	}
	public BigDecimal getRes_0_plac_bal() {
		return res_0_plac_bal;
	}
	public void setRes_0_plac_bal(BigDecimal res_0_plac_bal) {
		this.res_0_plac_bal = res_0_plac_bal;
	}
	public BigDecimal getRes_0_plac_prov() {
		return res_0_plac_prov;
	}
	public void setRes_0_plac_prov(BigDecimal res_0_plac_prov) {
		this.res_0_plac_prov = res_0_plac_prov;
	}
	public BigDecimal getRes_0_plac_crm() {
		return res_0_plac_crm;
	}
	public void setRes_0_plac_crm(BigDecimal res_0_plac_crm) {
		this.res_0_plac_crm = res_0_plac_crm;
	}
	public BigDecimal getRes_0_plac_rwa() {
		return res_0_plac_rwa;
	}
	public void setRes_0_plac_rwa(BigDecimal res_0_plac_rwa) {
		this.res_0_plac_rwa = res_0_plac_rwa;
	}
	public BigDecimal getRes_0_cash_bal() {
		return res_0_cash_bal;
	}
	public void setRes_0_cash_bal(BigDecimal res_0_cash_bal) {
		this.res_0_cash_bal = res_0_cash_bal;
	}
	public BigDecimal getRes_0_cash_prov() {
		return res_0_cash_prov;
	}
	public void setRes_0_cash_prov(BigDecimal res_0_cash_prov) {
		this.res_0_cash_prov = res_0_cash_prov;
	}
	public BigDecimal getRes_0_cash_crm() {
		return res_0_cash_crm;
	}
	public void setRes_0_cash_crm(BigDecimal res_0_cash_crm) {
		this.res_0_cash_crm = res_0_cash_crm;
	}
	public BigDecimal getRes_0_cash_rwa() {
		return res_0_cash_rwa;
	}
	public void setRes_0_cash_rwa(BigDecimal res_0_cash_rwa) {
		this.res_0_cash_rwa = res_0_cash_rwa;
	}
	public BigDecimal getRes_0_tot_bal() {
		return res_0_tot_bal;
	}
	public void setRes_0_tot_bal(BigDecimal res_0_tot_bal) {
		this.res_0_tot_bal = res_0_tot_bal;
	}
	public BigDecimal getRes_0_tot_prov() {
		return res_0_tot_prov;
	}
	public void setRes_0_tot_prov(BigDecimal res_0_tot_prov) {
		this.res_0_tot_prov = res_0_tot_prov;
	}
	public BigDecimal getRes_0_tot_int_sus() {
		return res_0_tot_int_sus;
	}
	public void setRes_0_tot_int_sus(BigDecimal res_0_tot_int_sus) {
		this.res_0_tot_int_sus = res_0_tot_int_sus;
	}
	public BigDecimal getRes_0_tot_crm() {
		return res_0_tot_crm;
	}
	public void setRes_0_tot_crm(BigDecimal res_0_tot_crm) {
		this.res_0_tot_crm = res_0_tot_crm;
	}
	public BigDecimal getRes_0_tot_rwa() {
		return res_0_tot_rwa;
	}
	public void setRes_0_tot_rwa(BigDecimal res_0_tot_rwa) {
		this.res_0_tot_rwa = res_0_tot_rwa;
	}
	public BigDecimal getRes_20_loan_bal() {
		return res_20_loan_bal;
	}
	public void setRes_20_loan_bal(BigDecimal res_20_loan_bal) {
		this.res_20_loan_bal = res_20_loan_bal;
	}
	public BigDecimal getRes_20_loan_bill_amt() {
		return res_20_loan_bill_amt;
	}
	public void setRes_20_loan_bill_amt(BigDecimal res_20_loan_bill_amt) {
		this.res_20_loan_bill_amt = res_20_loan_bill_amt;
	}
	public BigDecimal getRes_20_loan_tot_bal() {
		return res_20_loan_tot_bal;
	}
	public void setRes_20_loan_tot_bal(BigDecimal res_20_loan_tot_bal) {
		this.res_20_loan_tot_bal = res_20_loan_tot_bal;
	}
	public BigDecimal getRes_20_loan_tot_prov() {
		return res_20_loan_tot_prov;
	}
	public void setRes_20_loan_tot_prov(BigDecimal res_20_loan_tot_prov) {
		this.res_20_loan_tot_prov = res_20_loan_tot_prov;
	}
	public BigDecimal getRes_20_loan_int_sus() {
		return res_20_loan_int_sus;
	}
	public void setRes_20_loan_int_sus(BigDecimal res_20_loan_int_sus) {
		this.res_20_loan_int_sus = res_20_loan_int_sus;
	}
	public BigDecimal getRes_20_loan_crm() {
		return res_20_loan_crm;
	}
	public void setRes_20_loan_crm(BigDecimal res_20_loan_crm) {
		this.res_20_loan_crm = res_20_loan_crm;
	}
	public BigDecimal getRes_20_loan_tot_dra() {
		return res_20_loan_tot_dra;
	}
	public void setRes_20_loan_tot_dra(BigDecimal res_20_loan_tot_dra) {
		this.res_20_loan_tot_dra = res_20_loan_tot_dra;
	}
	public BigDecimal getRes_20_inves_bal() {
		return res_20_inves_bal;
	}
	public void setRes_20_inves_bal(BigDecimal res_20_inves_bal) {
		this.res_20_inves_bal = res_20_inves_bal;
	}
	public BigDecimal getRes_20_inves_prov() {
		return res_20_inves_prov;
	}
	public void setRes_20_inves_prov(BigDecimal res_20_inves_prov) {
		this.res_20_inves_prov = res_20_inves_prov;
	}
	public BigDecimal getRes_20_inves_crm() {
		return res_20_inves_crm;
	}
	public void setRes_20_inves_crm(BigDecimal res_20_inves_crm) {
		this.res_20_inves_crm = res_20_inves_crm;
	}
	public BigDecimal getRes_20_inves_rwa() {
		return res_20_inves_rwa;
	}
	public void setRes_20_inves_rwa(BigDecimal res_20_inves_rwa) {
		this.res_20_inves_rwa = res_20_inves_rwa;
	}
	public BigDecimal getRes_20_plac_bal() {
		return res_20_plac_bal;
	}
	public void setRes_20_plac_bal(BigDecimal res_20_plac_bal) {
		this.res_20_plac_bal = res_20_plac_bal;
	}
	public BigDecimal getRes_20_plac_prov() {
		return res_20_plac_prov;
	}
	public void setRes_20_plac_prov(BigDecimal res_20_plac_prov) {
		this.res_20_plac_prov = res_20_plac_prov;
	}
	public BigDecimal getRes_20_plac_crm() {
		return res_20_plac_crm;
	}
	public void setRes_20_plac_crm(BigDecimal res_20_plac_crm) {
		this.res_20_plac_crm = res_20_plac_crm;
	}
	public BigDecimal getRes_20_plac_rwa() {
		return res_20_plac_rwa;
	}
	public void setRes_20_plac_rwa(BigDecimal res_20_plac_rwa) {
		this.res_20_plac_rwa = res_20_plac_rwa;
	}
	public BigDecimal getRes_20_cash_bal() {
		return res_20_cash_bal;
	}
	public void setRes_20_cash_bal(BigDecimal res_20_cash_bal) {
		this.res_20_cash_bal = res_20_cash_bal;
	}
	public BigDecimal getRes_20_cash_prov() {
		return res_20_cash_prov;
	}
	public void setRes_20_cash_prov(BigDecimal res_20_cash_prov) {
		this.res_20_cash_prov = res_20_cash_prov;
	}
	public BigDecimal getRes_20_cash_crm() {
		return res_20_cash_crm;
	}
	public void setRes_20_cash_crm(BigDecimal res_20_cash_crm) {
		this.res_20_cash_crm = res_20_cash_crm;
	}
	public BigDecimal getRes_20_cash_rwa() {
		return res_20_cash_rwa;
	}
	public void setRes_20_cash_rwa(BigDecimal res_20_cash_rwa) {
		this.res_20_cash_rwa = res_20_cash_rwa;
	}
	public BigDecimal getRes_20_tot_bal() {
		return res_20_tot_bal;
	}
	public void setRes_20_tot_bal(BigDecimal res_20_tot_bal) {
		this.res_20_tot_bal = res_20_tot_bal;
	}
	public BigDecimal getRes_20_tot_prov() {
		return res_20_tot_prov;
	}
	public void setRes_20_tot_prov(BigDecimal res_20_tot_prov) {
		this.res_20_tot_prov = res_20_tot_prov;
	}
	public BigDecimal getRes_20_tot_int_sus() {
		return res_20_tot_int_sus;
	}
	public void setRes_20_tot_int_sus(BigDecimal res_20_tot_int_sus) {
		this.res_20_tot_int_sus = res_20_tot_int_sus;
	}
	public BigDecimal getRes_20_tot_crm() {
		return res_20_tot_crm;
	}
	public void setRes_20_tot_crm(BigDecimal res_20_tot_crm) {
		this.res_20_tot_crm = res_20_tot_crm;
	}
	public BigDecimal getRes_20_tot_rwa() {
		return res_20_tot_rwa;
	}
	public void setRes_20_tot_rwa(BigDecimal res_20_tot_rwa) {
		this.res_20_tot_rwa = res_20_tot_rwa;
	}
	public BigDecimal getRes_50_loan_bal() {
		return res_50_loan_bal;
	}
	public void setRes_50_loan_bal(BigDecimal res_50_loan_bal) {
		this.res_50_loan_bal = res_50_loan_bal;
	}
	public BigDecimal getRes_50_loan_bill_amt() {
		return res_50_loan_bill_amt;
	}
	public void setRes_50_loan_bill_amt(BigDecimal res_50_loan_bill_amt) {
		this.res_50_loan_bill_amt = res_50_loan_bill_amt;
	}
	public BigDecimal getRes_50_loan_tot_bal() {
		return res_50_loan_tot_bal;
	}
	public void setRes_50_loan_tot_bal(BigDecimal res_50_loan_tot_bal) {
		this.res_50_loan_tot_bal = res_50_loan_tot_bal;
	}
	public BigDecimal getRes_50_loan_tot_prov() {
		return res_50_loan_tot_prov;
	}
	public void setRes_50_loan_tot_prov(BigDecimal res_50_loan_tot_prov) {
		this.res_50_loan_tot_prov = res_50_loan_tot_prov;
	}
	public BigDecimal getRes_50_loan_int_sus() {
		return res_50_loan_int_sus;
	}
	public void setRes_50_loan_int_sus(BigDecimal res_50_loan_int_sus) {
		this.res_50_loan_int_sus = res_50_loan_int_sus;
	}
	public BigDecimal getRes_50_loan_crm() {
		return res_50_loan_crm;
	}
	public void setRes_50_loan_crm(BigDecimal res_50_loan_crm) {
		this.res_50_loan_crm = res_50_loan_crm;
	}
	public BigDecimal getRes_50_loan_tot_dra() {
		return res_50_loan_tot_dra;
	}
	public void setRes_50_loan_tot_dra(BigDecimal res_50_loan_tot_dra) {
		this.res_50_loan_tot_dra = res_50_loan_tot_dra;
	}
	public BigDecimal getRes_50_inves_bal() {
		return res_50_inves_bal;
	}
	public void setRes_50_inves_bal(BigDecimal res_50_inves_bal) {
		this.res_50_inves_bal = res_50_inves_bal;
	}
	public BigDecimal getRes_50_inves_prov() {
		return res_50_inves_prov;
	}
	public void setRes_50_inves_prov(BigDecimal res_50_inves_prov) {
		this.res_50_inves_prov = res_50_inves_prov;
	}
	public BigDecimal getRes_50_inves_crm() {
		return res_50_inves_crm;
	}
	public void setRes_50_inves_crm(BigDecimal res_50_inves_crm) {
		this.res_50_inves_crm = res_50_inves_crm;
	}
	public BigDecimal getRes_50_inves_rwa() {
		return res_50_inves_rwa;
	}
	public void setRes_50_inves_rwa(BigDecimal res_50_inves_rwa) {
		this.res_50_inves_rwa = res_50_inves_rwa;
	}
	public BigDecimal getRes_50_plac_bal() {
		return res_50_plac_bal;
	}
	public void setRes_50_plac_bal(BigDecimal res_50_plac_bal) {
		this.res_50_plac_bal = res_50_plac_bal;
	}
	public BigDecimal getRes_50_plac_prov() {
		return res_50_plac_prov;
	}
	public void setRes_50_plac_prov(BigDecimal res_50_plac_prov) {
		this.res_50_plac_prov = res_50_plac_prov;
	}
	public BigDecimal getRes_50_plac_crm() {
		return res_50_plac_crm;
	}
	public void setRes_50_plac_crm(BigDecimal res_50_plac_crm) {
		this.res_50_plac_crm = res_50_plac_crm;
	}
	public BigDecimal getRes_50_plac_rwa() {
		return res_50_plac_rwa;
	}
	public void setRes_50_plac_rwa(BigDecimal res_50_plac_rwa) {
		this.res_50_plac_rwa = res_50_plac_rwa;
	}
	public BigDecimal getRes_50_cash_bal() {
		return res_50_cash_bal;
	}
	public void setRes_50_cash_bal(BigDecimal res_50_cash_bal) {
		this.res_50_cash_bal = res_50_cash_bal;
	}
	public BigDecimal getRes_50_cash_prov() {
		return res_50_cash_prov;
	}
	public void setRes_50_cash_prov(BigDecimal res_50_cash_prov) {
		this.res_50_cash_prov = res_50_cash_prov;
	}
	public BigDecimal getRes_50_cash_crm() {
		return res_50_cash_crm;
	}
	public void setRes_50_cash_crm(BigDecimal res_50_cash_crm) {
		this.res_50_cash_crm = res_50_cash_crm;
	}
	public BigDecimal getRes_50_cash_rwa() {
		return res_50_cash_rwa;
	}
	public void setRes_50_cash_rwa(BigDecimal res_50_cash_rwa) {
		this.res_50_cash_rwa = res_50_cash_rwa;
	}
	public BigDecimal getRes_50_tot_bal() {
		return res_50_tot_bal;
	}
	public void setRes_50_tot_bal(BigDecimal res_50_tot_bal) {
		this.res_50_tot_bal = res_50_tot_bal;
	}
	public BigDecimal getRes_50_tot_prov() {
		return res_50_tot_prov;
	}
	public void setRes_50_tot_prov(BigDecimal res_50_tot_prov) {
		this.res_50_tot_prov = res_50_tot_prov;
	}
	public BigDecimal getRes_50_tot_int_sus() {
		return res_50_tot_int_sus;
	}
	public void setRes_50_tot_int_sus(BigDecimal res_50_tot_int_sus) {
		this.res_50_tot_int_sus = res_50_tot_int_sus;
	}
	public BigDecimal getRes_50_tot_crm() {
		return res_50_tot_crm;
	}
	public void setRes_50_tot_crm(BigDecimal res_50_tot_crm) {
		this.res_50_tot_crm = res_50_tot_crm;
	}
	public BigDecimal getRes_50_tot_rwa() {
		return res_50_tot_rwa;
	}
	public void setRes_50_tot_rwa(BigDecimal res_50_tot_rwa) {
		this.res_50_tot_rwa = res_50_tot_rwa;
	}
	public BigDecimal getRes_150_loan_bal() {
		return res_150_loan_bal;
	}
	public void setRes_150_loan_bal(BigDecimal res_150_loan_bal) {
		this.res_150_loan_bal = res_150_loan_bal;
	}
	public BigDecimal getRes_150_loan_bill_amt() {
		return res_150_loan_bill_amt;
	}
	public void setRes_150_loan_bill_amt(BigDecimal res_150_loan_bill_amt) {
		this.res_150_loan_bill_amt = res_150_loan_bill_amt;
	}
	public BigDecimal getRes_150_loan_tot_bal() {
		return res_150_loan_tot_bal;
	}
	public void setRes_150_loan_tot_bal(BigDecimal res_150_loan_tot_bal) {
		this.res_150_loan_tot_bal = res_150_loan_tot_bal;
	}
	public BigDecimal getRes_150_loan_tot_prov() {
		return res_150_loan_tot_prov;
	}
	public void setRes_150_loan_tot_prov(BigDecimal res_150_loan_tot_prov) {
		this.res_150_loan_tot_prov = res_150_loan_tot_prov;
	}
	public BigDecimal getRes_150_loan_int_sus() {
		return res_150_loan_int_sus;
	}
	public void setRes_150_loan_int_sus(BigDecimal res_150_loan_int_sus) {
		this.res_150_loan_int_sus = res_150_loan_int_sus;
	}
	public BigDecimal getRes_150_loan_crm() {
		return res_150_loan_crm;
	}
	public void setRes_150_loan_crm(BigDecimal res_150_loan_crm) {
		this.res_150_loan_crm = res_150_loan_crm;
	}
	public BigDecimal getRes_150_loan_tot_dra() {
		return res_150_loan_tot_dra;
	}
	public void setRes_150_loan_tot_dra(BigDecimal res_150_loan_tot_dra) {
		this.res_150_loan_tot_dra = res_150_loan_tot_dra;
	}
	public BigDecimal getRes_150_inves_bal() {
		return res_150_inves_bal;
	}
	public void setRes_150_inves_bal(BigDecimal res_150_inves_bal) {
		this.res_150_inves_bal = res_150_inves_bal;
	}
	public BigDecimal getRes_150_inves_prov() {
		return res_150_inves_prov;
	}
	public void setRes_150_inves_prov(BigDecimal res_150_inves_prov) {
		this.res_150_inves_prov = res_150_inves_prov;
	}
	public BigDecimal getRes_150_inves_crm() {
		return res_150_inves_crm;
	}
	public void setRes_150_inves_crm(BigDecimal res_150_inves_crm) {
		this.res_150_inves_crm = res_150_inves_crm;
	}
	public BigDecimal getRes_150_inves_rwa() {
		return res_150_inves_rwa;
	}
	public void setRes_150_inves_rwa(BigDecimal res_150_inves_rwa) {
		this.res_150_inves_rwa = res_150_inves_rwa;
	}
	public BigDecimal getRes_150_plac_bal() {
		return res_150_plac_bal;
	}
	public void setRes_150_plac_bal(BigDecimal res_150_plac_bal) {
		this.res_150_plac_bal = res_150_plac_bal;
	}
	public BigDecimal getRes_150_plac_prov() {
		return res_150_plac_prov;
	}
	public void setRes_150_plac_prov(BigDecimal res_150_plac_prov) {
		this.res_150_plac_prov = res_150_plac_prov;
	}
	public BigDecimal getRes_150_plac_crm() {
		return res_150_plac_crm;
	}
	public void setRes_150_plac_crm(BigDecimal res_150_plac_crm) {
		this.res_150_plac_crm = res_150_plac_crm;
	}
	public BigDecimal getRes_150_plac_rwa() {
		return res_150_plac_rwa;
	}
	public void setRes_150_plac_rwa(BigDecimal res_150_plac_rwa) {
		this.res_150_plac_rwa = res_150_plac_rwa;
	}
	public BigDecimal getRes_150_cash_bal() {
		return res_150_cash_bal;
	}
	public void setRes_150_cash_bal(BigDecimal res_150_cash_bal) {
		this.res_150_cash_bal = res_150_cash_bal;
	}
	public BigDecimal getRes_150_cash_prov() {
		return res_150_cash_prov;
	}
	public void setRes_150_cash_prov(BigDecimal res_150_cash_prov) {
		this.res_150_cash_prov = res_150_cash_prov;
	}
	public BigDecimal getRes_150_cash_crm() {
		return res_150_cash_crm;
	}
	public void setRes_150_cash_crm(BigDecimal res_150_cash_crm) {
		this.res_150_cash_crm = res_150_cash_crm;
	}
	public BigDecimal getRes_150_cash_rwa() {
		return res_150_cash_rwa;
	}
	public void setRes_150_cash_rwa(BigDecimal res_150_cash_rwa) {
		this.res_150_cash_rwa = res_150_cash_rwa;
	}
	public BigDecimal getRes_150_tot_bal() {
		return res_150_tot_bal;
	}
	public void setRes_150_tot_bal(BigDecimal res_150_tot_bal) {
		this.res_150_tot_bal = res_150_tot_bal;
	}
	public BigDecimal getRes_150_tot_prov() {
		return res_150_tot_prov;
	}
	public void setRes_150_tot_prov(BigDecimal res_150_tot_prov) {
		this.res_150_tot_prov = res_150_tot_prov;
	}
	public BigDecimal getRes_150_tot_int_sus() {
		return res_150_tot_int_sus;
	}
	public void setRes_150_tot_int_sus(BigDecimal res_150_tot_int_sus) {
		this.res_150_tot_int_sus = res_150_tot_int_sus;
	}
	public BigDecimal getRes_150_tot_crm() {
		return res_150_tot_crm;
	}
	public void setRes_150_tot_crm(BigDecimal res_150_tot_crm) {
		this.res_150_tot_crm = res_150_tot_crm;
	}
	public BigDecimal getRes_150_tot_rwa() {
		return res_150_tot_rwa;
	}
	public void setRes_150_tot_rwa(BigDecimal res_150_tot_rwa) {
		this.res_150_tot_rwa = res_150_tot_rwa;
	}
	public BigDecimal getRrp_inde1_0_loan_bal() {
		return rrp_inde1_0_loan_bal;
	}
	public void setRrp_inde1_0_loan_bal(BigDecimal rrp_inde1_0_loan_bal) {
		this.rrp_inde1_0_loan_bal = rrp_inde1_0_loan_bal;
	}
	public BigDecimal getRrp_inde1_0_loan_bill_amt() {
		return rrp_inde1_0_loan_bill_amt;
	}
	public void setRrp_inde1_0_loan_bill_amt(BigDecimal rrp_inde1_0_loan_bill_amt) {
		this.rrp_inde1_0_loan_bill_amt = rrp_inde1_0_loan_bill_amt;
	}
	public BigDecimal getRrp_inde1_0_loan_tot_bal() {
		return rrp_inde1_0_loan_tot_bal;
	}
	public void setRrp_inde1_0_loan_tot_bal(BigDecimal rrp_inde1_0_loan_tot_bal) {
		this.rrp_inde1_0_loan_tot_bal = rrp_inde1_0_loan_tot_bal;
	}
	public BigDecimal getRrp_inde1_0_loan_tot_prov() {
		return rrp_inde1_0_loan_tot_prov;
	}
	public void setRrp_inde1_0_loan_tot_prov(BigDecimal rrp_inde1_0_loan_tot_prov) {
		this.rrp_inde1_0_loan_tot_prov = rrp_inde1_0_loan_tot_prov;
	}
	public BigDecimal getRrp_inde1_0_loan_int_sus() {
		return rrp_inde1_0_loan_int_sus;
	}
	public void setRrp_inde1_0_loan_int_sus(BigDecimal rrp_inde1_0_loan_int_sus) {
		this.rrp_inde1_0_loan_int_sus = rrp_inde1_0_loan_int_sus;
	}
	public BigDecimal getRrp_inde1_0_loan_crm() {
		return rrp_inde1_0_loan_crm;
	}
	public void setRrp_inde1_0_loan_crm(BigDecimal rrp_inde1_0_loan_crm) {
		this.rrp_inde1_0_loan_crm = rrp_inde1_0_loan_crm;
	}
	public BigDecimal getRrp_inde1_0_loan_tot_dra() {
		return rrp_inde1_0_loan_tot_dra;
	}
	public void setRrp_inde1_0_loan_tot_dra(BigDecimal rrp_inde1_0_loan_tot_dra) {
		this.rrp_inde1_0_loan_tot_dra = rrp_inde1_0_loan_tot_dra;
	}
	public BigDecimal getRrp_inde1_0_inves_bal() {
		return rrp_inde1_0_inves_bal;
	}
	public void setRrp_inde1_0_inves_bal(BigDecimal rrp_inde1_0_inves_bal) {
		this.rrp_inde1_0_inves_bal = rrp_inde1_0_inves_bal;
	}
	public BigDecimal getRrp_inde1_0_inves_prov() {
		return rrp_inde1_0_inves_prov;
	}
	public void setRrp_inde1_0_inves_prov(BigDecimal rrp_inde1_0_inves_prov) {
		this.rrp_inde1_0_inves_prov = rrp_inde1_0_inves_prov;
	}
	public BigDecimal getRrp_inde1_0_inves_crm() {
		return rrp_inde1_0_inves_crm;
	}
	public void setRrp_inde1_0_inves_crm(BigDecimal rrp_inde1_0_inves_crm) {
		this.rrp_inde1_0_inves_crm = rrp_inde1_0_inves_crm;
	}
	public BigDecimal getRrp_inde1_0_inves_rwa() {
		return rrp_inde1_0_inves_rwa;
	}
	public void setRrp_inde1_0_inves_rwa(BigDecimal rrp_inde1_0_inves_rwa) {
		this.rrp_inde1_0_inves_rwa = rrp_inde1_0_inves_rwa;
	}
	public BigDecimal getRrp_inde1_0_plac_bal() {
		return rrp_inde1_0_plac_bal;
	}
	public void setRrp_inde1_0_plac_bal(BigDecimal rrp_inde1_0_plac_bal) {
		this.rrp_inde1_0_plac_bal = rrp_inde1_0_plac_bal;
	}
	public BigDecimal getRrp_inde1_0_plac_prov() {
		return rrp_inde1_0_plac_prov;
	}
	public void setRrp_inde1_0_plac_prov(BigDecimal rrp_inde1_0_plac_prov) {
		this.rrp_inde1_0_plac_prov = rrp_inde1_0_plac_prov;
	}
	public BigDecimal getRrp_inde1_0_plac_crm() {
		return rrp_inde1_0_plac_crm;
	}
	public void setRrp_inde1_0_plac_crm(BigDecimal rrp_inde1_0_plac_crm) {
		this.rrp_inde1_0_plac_crm = rrp_inde1_0_plac_crm;
	}
	public BigDecimal getRrp_inde1_0_plac_rwa() {
		return rrp_inde1_0_plac_rwa;
	}
	public void setRrp_inde1_0_plac_rwa(BigDecimal rrp_inde1_0_plac_rwa) {
		this.rrp_inde1_0_plac_rwa = rrp_inde1_0_plac_rwa;
	}
	public BigDecimal getRrp_inde1_0_cash_bal() {
		return rrp_inde1_0_cash_bal;
	}
	public void setRrp_inde1_0_cash_bal(BigDecimal rrp_inde1_0_cash_bal) {
		this.rrp_inde1_0_cash_bal = rrp_inde1_0_cash_bal;
	}
	public BigDecimal getRrp_inde1_0_cash_prov() {
		return rrp_inde1_0_cash_prov;
	}
	public void setRrp_inde1_0_cash_prov(BigDecimal rrp_inde1_0_cash_prov) {
		this.rrp_inde1_0_cash_prov = rrp_inde1_0_cash_prov;
	}
	public BigDecimal getRrp_inde1_0_cash_crm() {
		return rrp_inde1_0_cash_crm;
	}
	public void setRrp_inde1_0_cash_crm(BigDecimal rrp_inde1_0_cash_crm) {
		this.rrp_inde1_0_cash_crm = rrp_inde1_0_cash_crm;
	}
	public BigDecimal getRrp_inde1_0_cash_rwa() {
		return rrp_inde1_0_cash_rwa;
	}
	public void setRrp_inde1_0_cash_rwa(BigDecimal rrp_inde1_0_cash_rwa) {
		this.rrp_inde1_0_cash_rwa = rrp_inde1_0_cash_rwa;
	}
	public BigDecimal getRrp_inde1_0_tot_bal() {
		return rrp_inde1_0_tot_bal;
	}
	public void setRrp_inde1_0_tot_bal(BigDecimal rrp_inde1_0_tot_bal) {
		this.rrp_inde1_0_tot_bal = rrp_inde1_0_tot_bal;
	}
	public BigDecimal getRrp_inde1_0_tot_prov() {
		return rrp_inde1_0_tot_prov;
	}
	public void setRrp_inde1_0_tot_prov(BigDecimal rrp_inde1_0_tot_prov) {
		this.rrp_inde1_0_tot_prov = rrp_inde1_0_tot_prov;
	}
	public BigDecimal getRrp_inde1_0_tot_int_sus() {
		return rrp_inde1_0_tot_int_sus;
	}
	public void setRrp_inde1_0_tot_int_sus(BigDecimal rrp_inde1_0_tot_int_sus) {
		this.rrp_inde1_0_tot_int_sus = rrp_inde1_0_tot_int_sus;
	}
	public BigDecimal getRrp_inde1_0_tot_crm() {
		return rrp_inde1_0_tot_crm;
	}
	public void setRrp_inde1_0_tot_crm(BigDecimal rrp_inde1_0_tot_crm) {
		this.rrp_inde1_0_tot_crm = rrp_inde1_0_tot_crm;
	}
	public BigDecimal getRrp_inde1_0_tot_rwa() {
		return rrp_inde1_0_tot_rwa;
	}
	public void setRrp_inde1_0_tot_rwa(BigDecimal rrp_inde1_0_tot_rwa) {
		this.rrp_inde1_0_tot_rwa = rrp_inde1_0_tot_rwa;
	}
	public BigDecimal getRrp_inde1_20_loan_bal() {
		return rrp_inde1_20_loan_bal;
	}
	public void setRrp_inde1_20_loan_bal(BigDecimal rrp_inde1_20_loan_bal) {
		this.rrp_inde1_20_loan_bal = rrp_inde1_20_loan_bal;
	}
	public BigDecimal getRrp_inde1_20_loan_bill_amt() {
		return rrp_inde1_20_loan_bill_amt;
	}
	public void setRrp_inde1_20_loan_bill_amt(BigDecimal rrp_inde1_20_loan_bill_amt) {
		this.rrp_inde1_20_loan_bill_amt = rrp_inde1_20_loan_bill_amt;
	}
	public BigDecimal getRrp_inde1_20_loan_tot_bal() {
		return rrp_inde1_20_loan_tot_bal;
	}
	public void setRrp_inde1_20_loan_tot_bal(BigDecimal rrp_inde1_20_loan_tot_bal) {
		this.rrp_inde1_20_loan_tot_bal = rrp_inde1_20_loan_tot_bal;
	}
	public BigDecimal getRrp_inde1_20_loan_tot_prov() {
		return rrp_inde1_20_loan_tot_prov;
	}
	public void setRrp_inde1_20_loan_tot_prov(BigDecimal rrp_inde1_20_loan_tot_prov) {
		this.rrp_inde1_20_loan_tot_prov = rrp_inde1_20_loan_tot_prov;
	}
	public BigDecimal getRrp_inde1_20_loan_int_sus() {
		return rrp_inde1_20_loan_int_sus;
	}
	public void setRrp_inde1_20_loan_int_sus(BigDecimal rrp_inde1_20_loan_int_sus) {
		this.rrp_inde1_20_loan_int_sus = rrp_inde1_20_loan_int_sus;
	}
	public BigDecimal getRrp_inde1_20_loan_crm() {
		return rrp_inde1_20_loan_crm;
	}
	public void setRrp_inde1_20_loan_crm(BigDecimal rrp_inde1_20_loan_crm) {
		this.rrp_inde1_20_loan_crm = rrp_inde1_20_loan_crm;
	}
	public BigDecimal getRrp_inde1_20_loan_tot_dra() {
		return rrp_inde1_20_loan_tot_dra;
	}
	public void setRrp_inde1_20_loan_tot_dra(BigDecimal rrp_inde1_20_loan_tot_dra) {
		this.rrp_inde1_20_loan_tot_dra = rrp_inde1_20_loan_tot_dra;
	}
	public BigDecimal getRrp_inde1_20_inves_bal() {
		return rrp_inde1_20_inves_bal;
	}
	public void setRrp_inde1_20_inves_bal(BigDecimal rrp_inde1_20_inves_bal) {
		this.rrp_inde1_20_inves_bal = rrp_inde1_20_inves_bal;
	}
	public BigDecimal getRrp_inde1_20_inves_prov() {
		return rrp_inde1_20_inves_prov;
	}
	public void setRrp_inde1_20_inves_prov(BigDecimal rrp_inde1_20_inves_prov) {
		this.rrp_inde1_20_inves_prov = rrp_inde1_20_inves_prov;
	}
	public BigDecimal getRrp_inde1_20_inves_crm() {
		return rrp_inde1_20_inves_crm;
	}
	public void setRrp_inde1_20_inves_crm(BigDecimal rrp_inde1_20_inves_crm) {
		this.rrp_inde1_20_inves_crm = rrp_inde1_20_inves_crm;
	}
	public BigDecimal getRrp_inde1_20_inves_rwa() {
		return rrp_inde1_20_inves_rwa;
	}
	public void setRrp_inde1_20_inves_rwa(BigDecimal rrp_inde1_20_inves_rwa) {
		this.rrp_inde1_20_inves_rwa = rrp_inde1_20_inves_rwa;
	}
	public BigDecimal getRrp_inde1_20_plac_bal() {
		return rrp_inde1_20_plac_bal;
	}
	public void setRrp_inde1_20_plac_bal(BigDecimal rrp_inde1_20_plac_bal) {
		this.rrp_inde1_20_plac_bal = rrp_inde1_20_plac_bal;
	}
	public BigDecimal getRrp_inde1_20_plac_prov() {
		return rrp_inde1_20_plac_prov;
	}
	public void setRrp_inde1_20_plac_prov(BigDecimal rrp_inde1_20_plac_prov) {
		this.rrp_inde1_20_plac_prov = rrp_inde1_20_plac_prov;
	}
	public BigDecimal getRrp_inde1_20_plac_crm() {
		return rrp_inde1_20_plac_crm;
	}
	public void setRrp_inde1_20_plac_crm(BigDecimal rrp_inde1_20_plac_crm) {
		this.rrp_inde1_20_plac_crm = rrp_inde1_20_plac_crm;
	}
	public BigDecimal getRrp_inde1_20_plac_rwa() {
		return rrp_inde1_20_plac_rwa;
	}
	public void setRrp_inde1_20_plac_rwa(BigDecimal rrp_inde1_20_plac_rwa) {
		this.rrp_inde1_20_plac_rwa = rrp_inde1_20_plac_rwa;
	}
	public BigDecimal getRrp_inde1_20_cash_bal() {
		return rrp_inde1_20_cash_bal;
	}
	public void setRrp_inde1_20_cash_bal(BigDecimal rrp_inde1_20_cash_bal) {
		this.rrp_inde1_20_cash_bal = rrp_inde1_20_cash_bal;
	}
	public BigDecimal getRrp_inde1_20_cash_prov() {
		return rrp_inde1_20_cash_prov;
	}
	public void setRrp_inde1_20_cash_prov(BigDecimal rrp_inde1_20_cash_prov) {
		this.rrp_inde1_20_cash_prov = rrp_inde1_20_cash_prov;
	}
	public BigDecimal getRrp_inde1_20_cash_crm() {
		return rrp_inde1_20_cash_crm;
	}
	public void setRrp_inde1_20_cash_crm(BigDecimal rrp_inde1_20_cash_crm) {
		this.rrp_inde1_20_cash_crm = rrp_inde1_20_cash_crm;
	}
	public BigDecimal getRrp_inde1_20_cash_rwa() {
		return rrp_inde1_20_cash_rwa;
	}
	public void setRrp_inde1_20_cash_rwa(BigDecimal rrp_inde1_20_cash_rwa) {
		this.rrp_inde1_20_cash_rwa = rrp_inde1_20_cash_rwa;
	}
	public BigDecimal getRrp_inde1_20_tot_bal() {
		return rrp_inde1_20_tot_bal;
	}
	public void setRrp_inde1_20_tot_bal(BigDecimal rrp_inde1_20_tot_bal) {
		this.rrp_inde1_20_tot_bal = rrp_inde1_20_tot_bal;
	}
	public BigDecimal getRrp_inde1_20_tot_prov() {
		return rrp_inde1_20_tot_prov;
	}
	public void setRrp_inde1_20_tot_prov(BigDecimal rrp_inde1_20_tot_prov) {
		this.rrp_inde1_20_tot_prov = rrp_inde1_20_tot_prov;
	}
	public BigDecimal getRrp_inde1_20_tot_int_sus() {
		return rrp_inde1_20_tot_int_sus;
	}
	public void setRrp_inde1_20_tot_int_sus(BigDecimal rrp_inde1_20_tot_int_sus) {
		this.rrp_inde1_20_tot_int_sus = rrp_inde1_20_tot_int_sus;
	}
	public BigDecimal getRrp_inde1_20_tot_crm() {
		return rrp_inde1_20_tot_crm;
	}
	public void setRrp_inde1_20_tot_crm(BigDecimal rrp_inde1_20_tot_crm) {
		this.rrp_inde1_20_tot_crm = rrp_inde1_20_tot_crm;
	}
	public BigDecimal getRrp_inde1_20_tot_rwa() {
		return rrp_inde1_20_tot_rwa;
	}
	public void setRrp_inde1_20_tot_rwa(BigDecimal rrp_inde1_20_tot_rwa) {
		this.rrp_inde1_20_tot_rwa = rrp_inde1_20_tot_rwa;
	}
	public BigDecimal getRrp_inde1_50_loan_bal() {
		return rrp_inde1_50_loan_bal;
	}
	public void setRrp_inde1_50_loan_bal(BigDecimal rrp_inde1_50_loan_bal) {
		this.rrp_inde1_50_loan_bal = rrp_inde1_50_loan_bal;
	}
	public BigDecimal getRrp_inde1_50_loan_bill_amt() {
		return rrp_inde1_50_loan_bill_amt;
	}
	public void setRrp_inde1_50_loan_bill_amt(BigDecimal rrp_inde1_50_loan_bill_amt) {
		this.rrp_inde1_50_loan_bill_amt = rrp_inde1_50_loan_bill_amt;
	}
	public BigDecimal getRrp_inde1_50_loan_tot_bal() {
		return rrp_inde1_50_loan_tot_bal;
	}
	public void setRrp_inde1_50_loan_tot_bal(BigDecimal rrp_inde1_50_loan_tot_bal) {
		this.rrp_inde1_50_loan_tot_bal = rrp_inde1_50_loan_tot_bal;
	}
	public BigDecimal getRrp_inde1_50_loan_tot_prov() {
		return rrp_inde1_50_loan_tot_prov;
	}
	public void setRrp_inde1_50_loan_tot_prov(BigDecimal rrp_inde1_50_loan_tot_prov) {
		this.rrp_inde1_50_loan_tot_prov = rrp_inde1_50_loan_tot_prov;
	}
	public BigDecimal getRrp_inde1_50_loan_int_sus() {
		return rrp_inde1_50_loan_int_sus;
	}
	public void setRrp_inde1_50_loan_int_sus(BigDecimal rrp_inde1_50_loan_int_sus) {
		this.rrp_inde1_50_loan_int_sus = rrp_inde1_50_loan_int_sus;
	}
	public BigDecimal getRrp_inde1_50_loan_crm() {
		return rrp_inde1_50_loan_crm;
	}
	public void setRrp_inde1_50_loan_crm(BigDecimal rrp_inde1_50_loan_crm) {
		this.rrp_inde1_50_loan_crm = rrp_inde1_50_loan_crm;
	}
	public BigDecimal getRrp_inde1_50_loan_tot_dra() {
		return rrp_inde1_50_loan_tot_dra;
	}
	public void setRrp_inde1_50_loan_tot_dra(BigDecimal rrp_inde1_50_loan_tot_dra) {
		this.rrp_inde1_50_loan_tot_dra = rrp_inde1_50_loan_tot_dra;
	}
	public BigDecimal getRrp_inde1_50_inves_bal() {
		return rrp_inde1_50_inves_bal;
	}
	public void setRrp_inde1_50_inves_bal(BigDecimal rrp_inde1_50_inves_bal) {
		this.rrp_inde1_50_inves_bal = rrp_inde1_50_inves_bal;
	}
	public BigDecimal getRrp_inde1_50_inves_prov() {
		return rrp_inde1_50_inves_prov;
	}
	public void setRrp_inde1_50_inves_prov(BigDecimal rrp_inde1_50_inves_prov) {
		this.rrp_inde1_50_inves_prov = rrp_inde1_50_inves_prov;
	}
	public BigDecimal getRrp_inde1_50_inves_crm() {
		return rrp_inde1_50_inves_crm;
	}
	public void setRrp_inde1_50_inves_crm(BigDecimal rrp_inde1_50_inves_crm) {
		this.rrp_inde1_50_inves_crm = rrp_inde1_50_inves_crm;
	}
	public BigDecimal getRrp_inde1_50_inves_rwa() {
		return rrp_inde1_50_inves_rwa;
	}
	public void setRrp_inde1_50_inves_rwa(BigDecimal rrp_inde1_50_inves_rwa) {
		this.rrp_inde1_50_inves_rwa = rrp_inde1_50_inves_rwa;
	}
	public BigDecimal getRrp_inde1_50_plac_bal() {
		return rrp_inde1_50_plac_bal;
	}
	public void setRrp_inde1_50_plac_bal(BigDecimal rrp_inde1_50_plac_bal) {
		this.rrp_inde1_50_plac_bal = rrp_inde1_50_plac_bal;
	}
	public BigDecimal getRrp_inde1_50_plac_prov() {
		return rrp_inde1_50_plac_prov;
	}
	public void setRrp_inde1_50_plac_prov(BigDecimal rrp_inde1_50_plac_prov) {
		this.rrp_inde1_50_plac_prov = rrp_inde1_50_plac_prov;
	}
	public BigDecimal getRrp_inde1_50_plac_crm() {
		return rrp_inde1_50_plac_crm;
	}
	public void setRrp_inde1_50_plac_crm(BigDecimal rrp_inde1_50_plac_crm) {
		this.rrp_inde1_50_plac_crm = rrp_inde1_50_plac_crm;
	}
	public BigDecimal getRrp_inde1_50_plac_rwa() {
		return rrp_inde1_50_plac_rwa;
	}
	public void setRrp_inde1_50_plac_rwa(BigDecimal rrp_inde1_50_plac_rwa) {
		this.rrp_inde1_50_plac_rwa = rrp_inde1_50_plac_rwa;
	}
	public BigDecimal getRrp_inde1_50_cash_bal() {
		return rrp_inde1_50_cash_bal;
	}
	public void setRrp_inde1_50_cash_bal(BigDecimal rrp_inde1_50_cash_bal) {
		this.rrp_inde1_50_cash_bal = rrp_inde1_50_cash_bal;
	}
	public BigDecimal getRrp_inde1_50_cash_prov() {
		return rrp_inde1_50_cash_prov;
	}
	public void setRrp_inde1_50_cash_prov(BigDecimal rrp_inde1_50_cash_prov) {
		this.rrp_inde1_50_cash_prov = rrp_inde1_50_cash_prov;
	}
	public BigDecimal getRrp_inde1_50_cash_crm() {
		return rrp_inde1_50_cash_crm;
	}
	public void setRrp_inde1_50_cash_crm(BigDecimal rrp_inde1_50_cash_crm) {
		this.rrp_inde1_50_cash_crm = rrp_inde1_50_cash_crm;
	}
	public BigDecimal getRrp_inde1_50_cash_rwa() {
		return rrp_inde1_50_cash_rwa;
	}
	public void setRrp_inde1_50_cash_rwa(BigDecimal rrp_inde1_50_cash_rwa) {
		this.rrp_inde1_50_cash_rwa = rrp_inde1_50_cash_rwa;
	}
	public BigDecimal getRrp_inde1_50_tot_bal() {
		return rrp_inde1_50_tot_bal;
	}
	public void setRrp_inde1_50_tot_bal(BigDecimal rrp_inde1_50_tot_bal) {
		this.rrp_inde1_50_tot_bal = rrp_inde1_50_tot_bal;
	}
	public BigDecimal getRrp_inde1_50_tot_prov() {
		return rrp_inde1_50_tot_prov;
	}
	public void setRrp_inde1_50_tot_prov(BigDecimal rrp_inde1_50_tot_prov) {
		this.rrp_inde1_50_tot_prov = rrp_inde1_50_tot_prov;
	}
	public BigDecimal getRrp_inde1_50_tot_int_sus() {
		return rrp_inde1_50_tot_int_sus;
	}
	public void setRrp_inde1_50_tot_int_sus(BigDecimal rrp_inde1_50_tot_int_sus) {
		this.rrp_inde1_50_tot_int_sus = rrp_inde1_50_tot_int_sus;
	}
	public BigDecimal getRrp_inde1_50_tot_crm() {
		return rrp_inde1_50_tot_crm;
	}
	public void setRrp_inde1_50_tot_crm(BigDecimal rrp_inde1_50_tot_crm) {
		this.rrp_inde1_50_tot_crm = rrp_inde1_50_tot_crm;
	}
	public BigDecimal getRrp_inde1_50_tot_rwa() {
		return rrp_inde1_50_tot_rwa;
	}
	public void setRrp_inde1_50_tot_rwa(BigDecimal rrp_inde1_50_tot_rwa) {
		this.rrp_inde1_50_tot_rwa = rrp_inde1_50_tot_rwa;
	}
	public BigDecimal getRrp_inde1_100_loan_bal() {
		return rrp_inde1_100_loan_bal;
	}
	public void setRrp_inde1_100_loan_bal(BigDecimal rrp_inde1_100_loan_bal) {
		this.rrp_inde1_100_loan_bal = rrp_inde1_100_loan_bal;
	}
	public BigDecimal getRrp_inde1_100_loan_bill_amt() {
		return rrp_inde1_100_loan_bill_amt;
	}
	public void setRrp_inde1_100_loan_bill_amt(BigDecimal rrp_inde1_100_loan_bill_amt) {
		this.rrp_inde1_100_loan_bill_amt = rrp_inde1_100_loan_bill_amt;
	}
	public BigDecimal getRrp_inde1_100_loan_tot_bal() {
		return rrp_inde1_100_loan_tot_bal;
	}
	public void setRrp_inde1_100_loan_tot_bal(BigDecimal rrp_inde1_100_loan_tot_bal) {
		this.rrp_inde1_100_loan_tot_bal = rrp_inde1_100_loan_tot_bal;
	}
	public BigDecimal getRrp_inde1_100_loan_tot_prov() {
		return rrp_inde1_100_loan_tot_prov;
	}
	public void setRrp_inde1_100_loan_tot_prov(BigDecimal rrp_inde1_100_loan_tot_prov) {
		this.rrp_inde1_100_loan_tot_prov = rrp_inde1_100_loan_tot_prov;
	}
	public BigDecimal getRrp_inde1_100_loan_int_sus() {
		return rrp_inde1_100_loan_int_sus;
	}
	public void setRrp_inde1_100_loan_int_sus(BigDecimal rrp_inde1_100_loan_int_sus) {
		this.rrp_inde1_100_loan_int_sus = rrp_inde1_100_loan_int_sus;
	}
	public BigDecimal getRrp_inde1_100_loan_crm() {
		return rrp_inde1_100_loan_crm;
	}
	public void setRrp_inde1_100_loan_crm(BigDecimal rrp_inde1_100_loan_crm) {
		this.rrp_inde1_100_loan_crm = rrp_inde1_100_loan_crm;
	}
	public BigDecimal getRrp_inde1_100_loan_tot_dra() {
		return rrp_inde1_100_loan_tot_dra;
	}
	public void setRrp_inde1_100_loan_tot_dra(BigDecimal rrp_inde1_100_loan_tot_dra) {
		this.rrp_inde1_100_loan_tot_dra = rrp_inde1_100_loan_tot_dra;
	}
	public BigDecimal getRrp_inde1_100_inves_bal() {
		return rrp_inde1_100_inves_bal;
	}
	public void setRrp_inde1_100_inves_bal(BigDecimal rrp_inde1_100_inves_bal) {
		this.rrp_inde1_100_inves_bal = rrp_inde1_100_inves_bal;
	}
	public BigDecimal getRrp_inde1_100_inves_prov() {
		return rrp_inde1_100_inves_prov;
	}
	public void setRrp_inde1_100_inves_prov(BigDecimal rrp_inde1_100_inves_prov) {
		this.rrp_inde1_100_inves_prov = rrp_inde1_100_inves_prov;
	}
	public BigDecimal getRrp_inde1_100_inves_crm() {
		return rrp_inde1_100_inves_crm;
	}
	public void setRrp_inde1_100_inves_crm(BigDecimal rrp_inde1_100_inves_crm) {
		this.rrp_inde1_100_inves_crm = rrp_inde1_100_inves_crm;
	}
	public BigDecimal getRrp_inde1_100_inves_rwa() {
		return rrp_inde1_100_inves_rwa;
	}
	public void setRrp_inde1_100_inves_rwa(BigDecimal rrp_inde1_100_inves_rwa) {
		this.rrp_inde1_100_inves_rwa = rrp_inde1_100_inves_rwa;
	}
	public BigDecimal getRrp_inde1_100_plac_bal() {
		return rrp_inde1_100_plac_bal;
	}
	public void setRrp_inde1_100_plac_bal(BigDecimal rrp_inde1_100_plac_bal) {
		this.rrp_inde1_100_plac_bal = rrp_inde1_100_plac_bal;
	}
	public BigDecimal getRrp_inde1_100_plac_prov() {
		return rrp_inde1_100_plac_prov;
	}
	public void setRrp_inde1_100_plac_prov(BigDecimal rrp_inde1_100_plac_prov) {
		this.rrp_inde1_100_plac_prov = rrp_inde1_100_plac_prov;
	}
	public BigDecimal getRrp_inde1_100_plac_crm() {
		return rrp_inde1_100_plac_crm;
	}
	public void setRrp_inde1_100_plac_crm(BigDecimal rrp_inde1_100_plac_crm) {
		this.rrp_inde1_100_plac_crm = rrp_inde1_100_plac_crm;
	}
	public BigDecimal getRrp_inde1_100_plac_rwa() {
		return rrp_inde1_100_plac_rwa;
	}
	public void setRrp_inde1_100_plac_rwa(BigDecimal rrp_inde1_100_plac_rwa) {
		this.rrp_inde1_100_plac_rwa = rrp_inde1_100_plac_rwa;
	}
	public BigDecimal getRrp_inde1_100_cash_bal() {
		return rrp_inde1_100_cash_bal;
	}
	public void setRrp_inde1_100_cash_bal(BigDecimal rrp_inde1_100_cash_bal) {
		this.rrp_inde1_100_cash_bal = rrp_inde1_100_cash_bal;
	}
	public BigDecimal getRrp_inde1_100_cash_prov() {
		return rrp_inde1_100_cash_prov;
	}
	public void setRrp_inde1_100_cash_prov(BigDecimal rrp_inde1_100_cash_prov) {
		this.rrp_inde1_100_cash_prov = rrp_inde1_100_cash_prov;
	}
	public BigDecimal getRrp_inde1_100_cash_crm() {
		return rrp_inde1_100_cash_crm;
	}
	public void setRrp_inde1_100_cash_crm(BigDecimal rrp_inde1_100_cash_crm) {
		this.rrp_inde1_100_cash_crm = rrp_inde1_100_cash_crm;
	}
	public BigDecimal getRrp_inde1_100_cash_rwa() {
		return rrp_inde1_100_cash_rwa;
	}
	public void setRrp_inde1_100_cash_rwa(BigDecimal rrp_inde1_100_cash_rwa) {
		this.rrp_inde1_100_cash_rwa = rrp_inde1_100_cash_rwa;
	}
	public BigDecimal getRrp_inde1_100_tot_bal() {
		return rrp_inde1_100_tot_bal;
	}
	public void setRrp_inde1_100_tot_bal(BigDecimal rrp_inde1_100_tot_bal) {
		this.rrp_inde1_100_tot_bal = rrp_inde1_100_tot_bal;
	}
	public BigDecimal getRrp_inde1_100_tot_prov() {
		return rrp_inde1_100_tot_prov;
	}
	public void setRrp_inde1_100_tot_prov(BigDecimal rrp_inde1_100_tot_prov) {
		this.rrp_inde1_100_tot_prov = rrp_inde1_100_tot_prov;
	}
	public BigDecimal getRrp_inde1_100_tot_int_sus() {
		return rrp_inde1_100_tot_int_sus;
	}
	public void setRrp_inde1_100_tot_int_sus(BigDecimal rrp_inde1_100_tot_int_sus) {
		this.rrp_inde1_100_tot_int_sus = rrp_inde1_100_tot_int_sus;
	}
	public BigDecimal getRrp_inde1_100_tot_crm() {
		return rrp_inde1_100_tot_crm;
	}
	public void setRrp_inde1_100_tot_crm(BigDecimal rrp_inde1_100_tot_crm) {
		this.rrp_inde1_100_tot_crm = rrp_inde1_100_tot_crm;
	}
	public BigDecimal getRrp_inde1_100_tot_rwa() {
		return rrp_inde1_100_tot_rwa;
	}
	public void setRrp_inde1_100_tot_rwa(BigDecimal rrp_inde1_100_tot_rwa) {
		this.rrp_inde1_100_tot_rwa = rrp_inde1_100_tot_rwa;
	}
	public BigDecimal getRrp_inde1_150_loan_bal() {
		return rrp_inde1_150_loan_bal;
	}
	public void setRrp_inde1_150_loan_bal(BigDecimal rrp_inde1_150_loan_bal) {
		this.rrp_inde1_150_loan_bal = rrp_inde1_150_loan_bal;
	}
	public BigDecimal getRrp_inde1_150_loan_bill_amt() {
		return rrp_inde1_150_loan_bill_amt;
	}
	public void setRrp_inde1_150_loan_bill_amt(BigDecimal rrp_inde1_150_loan_bill_amt) {
		this.rrp_inde1_150_loan_bill_amt = rrp_inde1_150_loan_bill_amt;
	}
	public BigDecimal getRrp_inde1_150_loan_tot_bal() {
		return rrp_inde1_150_loan_tot_bal;
	}
	public void setRrp_inde1_150_loan_tot_bal(BigDecimal rrp_inde1_150_loan_tot_bal) {
		this.rrp_inde1_150_loan_tot_bal = rrp_inde1_150_loan_tot_bal;
	}
	public BigDecimal getRrp_inde1_150_loan_tot_prov() {
		return rrp_inde1_150_loan_tot_prov;
	}
	public void setRrp_inde1_150_loan_tot_prov(BigDecimal rrp_inde1_150_loan_tot_prov) {
		this.rrp_inde1_150_loan_tot_prov = rrp_inde1_150_loan_tot_prov;
	}
	public BigDecimal getRrp_inde1_150_loan_int_sus() {
		return rrp_inde1_150_loan_int_sus;
	}
	public void setRrp_inde1_150_loan_int_sus(BigDecimal rrp_inde1_150_loan_int_sus) {
		this.rrp_inde1_150_loan_int_sus = rrp_inde1_150_loan_int_sus;
	}
	public BigDecimal getRrp_inde1_150_loan_crm() {
		return rrp_inde1_150_loan_crm;
	}
	public void setRrp_inde1_150_loan_crm(BigDecimal rrp_inde1_150_loan_crm) {
		this.rrp_inde1_150_loan_crm = rrp_inde1_150_loan_crm;
	}
	public BigDecimal getRrp_inde1_150_loan_tot_dra() {
		return rrp_inde1_150_loan_tot_dra;
	}
	public void setRrp_inde1_150_loan_tot_dra(BigDecimal rrp_inde1_150_loan_tot_dra) {
		this.rrp_inde1_150_loan_tot_dra = rrp_inde1_150_loan_tot_dra;
	}
	public BigDecimal getRrp_inde1_150_inves_bal() {
		return rrp_inde1_150_inves_bal;
	}
	public void setRrp_inde1_150_inves_bal(BigDecimal rrp_inde1_150_inves_bal) {
		this.rrp_inde1_150_inves_bal = rrp_inde1_150_inves_bal;
	}
	public BigDecimal getRrp_inde1_150_inves_prov() {
		return rrp_inde1_150_inves_prov;
	}
	public void setRrp_inde1_150_inves_prov(BigDecimal rrp_inde1_150_inves_prov) {
		this.rrp_inde1_150_inves_prov = rrp_inde1_150_inves_prov;
	}
	public BigDecimal getRrp_inde1_150_inves_crm() {
		return rrp_inde1_150_inves_crm;
	}
	public void setRrp_inde1_150_inves_crm(BigDecimal rrp_inde1_150_inves_crm) {
		this.rrp_inde1_150_inves_crm = rrp_inde1_150_inves_crm;
	}
	public BigDecimal getRrp_inde1_150_inves_rwa() {
		return rrp_inde1_150_inves_rwa;
	}
	public void setRrp_inde1_150_inves_rwa(BigDecimal rrp_inde1_150_inves_rwa) {
		this.rrp_inde1_150_inves_rwa = rrp_inde1_150_inves_rwa;
	}
	public BigDecimal getRrp_inde1_150_plac_bal() {
		return rrp_inde1_150_plac_bal;
	}
	public void setRrp_inde1_150_plac_bal(BigDecimal rrp_inde1_150_plac_bal) {
		this.rrp_inde1_150_plac_bal = rrp_inde1_150_plac_bal;
	}
	public BigDecimal getRrp_inde1_150_plac_prov() {
		return rrp_inde1_150_plac_prov;
	}
	public void setRrp_inde1_150_plac_prov(BigDecimal rrp_inde1_150_plac_prov) {
		this.rrp_inde1_150_plac_prov = rrp_inde1_150_plac_prov;
	}
	public BigDecimal getRrp_inde1_150_plac_crm() {
		return rrp_inde1_150_plac_crm;
	}
	public void setRrp_inde1_150_plac_crm(BigDecimal rrp_inde1_150_plac_crm) {
		this.rrp_inde1_150_plac_crm = rrp_inde1_150_plac_crm;
	}
	public BigDecimal getRrp_inde1_150_plac_rwa() {
		return rrp_inde1_150_plac_rwa;
	}
	public void setRrp_inde1_150_plac_rwa(BigDecimal rrp_inde1_150_plac_rwa) {
		this.rrp_inde1_150_plac_rwa = rrp_inde1_150_plac_rwa;
	}
	public BigDecimal getRrp_inde1_150_cash_bal() {
		return rrp_inde1_150_cash_bal;
	}
	public void setRrp_inde1_150_cash_bal(BigDecimal rrp_inde1_150_cash_bal) {
		this.rrp_inde1_150_cash_bal = rrp_inde1_150_cash_bal;
	}
	public BigDecimal getRrp_inde1_150_cash_prov() {
		return rrp_inde1_150_cash_prov;
	}
	public void setRrp_inde1_150_cash_prov(BigDecimal rrp_inde1_150_cash_prov) {
		this.rrp_inde1_150_cash_prov = rrp_inde1_150_cash_prov;
	}
	public BigDecimal getRrp_inde1_150_cash_crm() {
		return rrp_inde1_150_cash_crm;
	}
	public void setRrp_inde1_150_cash_crm(BigDecimal rrp_inde1_150_cash_crm) {
		this.rrp_inde1_150_cash_crm = rrp_inde1_150_cash_crm;
	}
	public BigDecimal getRrp_inde1_150_cash_rwa() {
		return rrp_inde1_150_cash_rwa;
	}
	public void setRrp_inde1_150_cash_rwa(BigDecimal rrp_inde1_150_cash_rwa) {
		this.rrp_inde1_150_cash_rwa = rrp_inde1_150_cash_rwa;
	}
	public BigDecimal getRrp_inde1_150_tot_bal() {
		return rrp_inde1_150_tot_bal;
	}
	public void setRrp_inde1_150_tot_bal(BigDecimal rrp_inde1_150_tot_bal) {
		this.rrp_inde1_150_tot_bal = rrp_inde1_150_tot_bal;
	}
	public BigDecimal getRrp_inde1_150_tot_prov() {
		return rrp_inde1_150_tot_prov;
	}
	public void setRrp_inde1_150_tot_prov(BigDecimal rrp_inde1_150_tot_prov) {
		this.rrp_inde1_150_tot_prov = rrp_inde1_150_tot_prov;
	}
	public BigDecimal getRrp_inde1_150_tot_int_sus() {
		return rrp_inde1_150_tot_int_sus;
	}
	public void setRrp_inde1_150_tot_int_sus(BigDecimal rrp_inde1_150_tot_int_sus) {
		this.rrp_inde1_150_tot_int_sus = rrp_inde1_150_tot_int_sus;
	}
	public BigDecimal getRrp_inde1_150_tot_crm() {
		return rrp_inde1_150_tot_crm;
	}
	public void setRrp_inde1_150_tot_crm(BigDecimal rrp_inde1_150_tot_crm) {
		this.rrp_inde1_150_tot_crm = rrp_inde1_150_tot_crm;
	}
	public BigDecimal getRrp_inde1_150_tot_rwa() {
		return rrp_inde1_150_tot_rwa;
	}
	public void setRrp_inde1_150_tot_rwa(BigDecimal rrp_inde1_150_tot_rwa) {
		this.rrp_inde1_150_tot_rwa = rrp_inde1_150_tot_rwa;
	}
	public BigDecimal getRrp_inde2_0_loan_bal() {
		return rrp_inde2_0_loan_bal;
	}
	public void setRrp_inde2_0_loan_bal(BigDecimal rrp_inde2_0_loan_bal) {
		this.rrp_inde2_0_loan_bal = rrp_inde2_0_loan_bal;
	}
	public BigDecimal getRrp_inde2_0_loan_bill_amt() {
		return rrp_inde2_0_loan_bill_amt;
	}
	public void setRrp_inde2_0_loan_bill_amt(BigDecimal rrp_inde2_0_loan_bill_amt) {
		this.rrp_inde2_0_loan_bill_amt = rrp_inde2_0_loan_bill_amt;
	}
	public BigDecimal getRrp_inde2_0_loan_tot_bal() {
		return rrp_inde2_0_loan_tot_bal;
	}
	public void setRrp_inde2_0_loan_tot_bal(BigDecimal rrp_inde2_0_loan_tot_bal) {
		this.rrp_inde2_0_loan_tot_bal = rrp_inde2_0_loan_tot_bal;
	}
	public BigDecimal getRrp_inde2_0_loan_tot_prov() {
		return rrp_inde2_0_loan_tot_prov;
	}
	public void setRrp_inde2_0_loan_tot_prov(BigDecimal rrp_inde2_0_loan_tot_prov) {
		this.rrp_inde2_0_loan_tot_prov = rrp_inde2_0_loan_tot_prov;
	}
	public BigDecimal getRrp_inde2_0_loan_int_sus() {
		return rrp_inde2_0_loan_int_sus;
	}
	public void setRrp_inde2_0_loan_int_sus(BigDecimal rrp_inde2_0_loan_int_sus) {
		this.rrp_inde2_0_loan_int_sus = rrp_inde2_0_loan_int_sus;
	}
	public BigDecimal getRrp_inde2_0_loan_crm() {
		return rrp_inde2_0_loan_crm;
	}
	public void setRrp_inde2_0_loan_crm(BigDecimal rrp_inde2_0_loan_crm) {
		this.rrp_inde2_0_loan_crm = rrp_inde2_0_loan_crm;
	}
	public BigDecimal getRrp_inde2_0_loan_tot_dra() {
		return rrp_inde2_0_loan_tot_dra;
	}
	public void setRrp_inde2_0_loan_tot_dra(BigDecimal rrp_inde2_0_loan_tot_dra) {
		this.rrp_inde2_0_loan_tot_dra = rrp_inde2_0_loan_tot_dra;
	}
	public BigDecimal getRrp_inde2_0_inves_bal() {
		return rrp_inde2_0_inves_bal;
	}
	public void setRrp_inde2_0_inves_bal(BigDecimal rrp_inde2_0_inves_bal) {
		this.rrp_inde2_0_inves_bal = rrp_inde2_0_inves_bal;
	}
	public BigDecimal getRrp_inde2_0_inves_prov() {
		return rrp_inde2_0_inves_prov;
	}
	public void setRrp_inde2_0_inves_prov(BigDecimal rrp_inde2_0_inves_prov) {
		this.rrp_inde2_0_inves_prov = rrp_inde2_0_inves_prov;
	}
	public BigDecimal getRrp_inde2_0_inves_crm() {
		return rrp_inde2_0_inves_crm;
	}
	public void setRrp_inde2_0_inves_crm(BigDecimal rrp_inde2_0_inves_crm) {
		this.rrp_inde2_0_inves_crm = rrp_inde2_0_inves_crm;
	}
	public BigDecimal getRrp_inde2_0_inves_rwa() {
		return rrp_inde2_0_inves_rwa;
	}
	public void setRrp_inde2_0_inves_rwa(BigDecimal rrp_inde2_0_inves_rwa) {
		this.rrp_inde2_0_inves_rwa = rrp_inde2_0_inves_rwa;
	}
	public BigDecimal getRrp_inde2_0_plac_bal() {
		return rrp_inde2_0_plac_bal;
	}
	public void setRrp_inde2_0_plac_bal(BigDecimal rrp_inde2_0_plac_bal) {
		this.rrp_inde2_0_plac_bal = rrp_inde2_0_plac_bal;
	}
	public BigDecimal getRrp_inde2_0_plac_prov() {
		return rrp_inde2_0_plac_prov;
	}
	public void setRrp_inde2_0_plac_prov(BigDecimal rrp_inde2_0_plac_prov) {
		this.rrp_inde2_0_plac_prov = rrp_inde2_0_plac_prov;
	}
	public BigDecimal getRrp_inde2_0_plac_crm() {
		return rrp_inde2_0_plac_crm;
	}
	public void setRrp_inde2_0_plac_crm(BigDecimal rrp_inde2_0_plac_crm) {
		this.rrp_inde2_0_plac_crm = rrp_inde2_0_plac_crm;
	}
	public BigDecimal getRrp_inde2_0_plac_rwa() {
		return rrp_inde2_0_plac_rwa;
	}
	public void setRrp_inde2_0_plac_rwa(BigDecimal rrp_inde2_0_plac_rwa) {
		this.rrp_inde2_0_plac_rwa = rrp_inde2_0_plac_rwa;
	}
	public BigDecimal getRrp_inde2_0_cash_bal() {
		return rrp_inde2_0_cash_bal;
	}
	public void setRrp_inde2_0_cash_bal(BigDecimal rrp_inde2_0_cash_bal) {
		this.rrp_inde2_0_cash_bal = rrp_inde2_0_cash_bal;
	}
	public BigDecimal getRrp_inde2_0_cash_prov() {
		return rrp_inde2_0_cash_prov;
	}
	public void setRrp_inde2_0_cash_prov(BigDecimal rrp_inde2_0_cash_prov) {
		this.rrp_inde2_0_cash_prov = rrp_inde2_0_cash_prov;
	}
	public BigDecimal getRrp_inde2_0_cash_crm() {
		return rrp_inde2_0_cash_crm;
	}
	public void setRrp_inde2_0_cash_crm(BigDecimal rrp_inde2_0_cash_crm) {
		this.rrp_inde2_0_cash_crm = rrp_inde2_0_cash_crm;
	}
	public BigDecimal getRrp_inde2_0_cash_rwa() {
		return rrp_inde2_0_cash_rwa;
	}
	public void setRrp_inde2_0_cash_rwa(BigDecimal rrp_inde2_0_cash_rwa) {
		this.rrp_inde2_0_cash_rwa = rrp_inde2_0_cash_rwa;
	}
	public BigDecimal getRrp_inde2_0_tot_bal() {
		return rrp_inde2_0_tot_bal;
	}
	public void setRrp_inde2_0_tot_bal(BigDecimal rrp_inde2_0_tot_bal) {
		this.rrp_inde2_0_tot_bal = rrp_inde2_0_tot_bal;
	}
	public BigDecimal getRrp_inde2_0_tot_prov() {
		return rrp_inde2_0_tot_prov;
	}
	public void setRrp_inde2_0_tot_prov(BigDecimal rrp_inde2_0_tot_prov) {
		this.rrp_inde2_0_tot_prov = rrp_inde2_0_tot_prov;
	}
	public BigDecimal getRrp_inde2_0_tot_int_sus() {
		return rrp_inde2_0_tot_int_sus;
	}
	public void setRrp_inde2_0_tot_int_sus(BigDecimal rrp_inde2_0_tot_int_sus) {
		this.rrp_inde2_0_tot_int_sus = rrp_inde2_0_tot_int_sus;
	}
	public BigDecimal getRrp_inde2_0_tot_crm() {
		return rrp_inde2_0_tot_crm;
	}
	public void setRrp_inde2_0_tot_crm(BigDecimal rrp_inde2_0_tot_crm) {
		this.rrp_inde2_0_tot_crm = rrp_inde2_0_tot_crm;
	}
	public BigDecimal getRrp_inde2_0_tot_rwa() {
		return rrp_inde2_0_tot_rwa;
	}
	public void setRrp_inde2_0_tot_rwa(BigDecimal rrp_inde2_0_tot_rwa) {
		this.rrp_inde2_0_tot_rwa = rrp_inde2_0_tot_rwa;
	}
	public BigDecimal getRrp_inde2_20_loan_bal() {
		return rrp_inde2_20_loan_bal;
	}
	public void setRrp_inde2_20_loan_bal(BigDecimal rrp_inde2_20_loan_bal) {
		this.rrp_inde2_20_loan_bal = rrp_inde2_20_loan_bal;
	}
	public BigDecimal getRrp_inde2_20_loan_bill_amt() {
		return rrp_inde2_20_loan_bill_amt;
	}
	public void setRrp_inde2_20_loan_bill_amt(BigDecimal rrp_inde2_20_loan_bill_amt) {
		this.rrp_inde2_20_loan_bill_amt = rrp_inde2_20_loan_bill_amt;
	}
	public BigDecimal getRrp_inde2_20_loan_tot_bal() {
		return rrp_inde2_20_loan_tot_bal;
	}
	public void setRrp_inde2_20_loan_tot_bal(BigDecimal rrp_inde2_20_loan_tot_bal) {
		this.rrp_inde2_20_loan_tot_bal = rrp_inde2_20_loan_tot_bal;
	}
	public BigDecimal getRrp_inde2_20_loan_tot_prov() {
		return rrp_inde2_20_loan_tot_prov;
	}
	public void setRrp_inde2_20_loan_tot_prov(BigDecimal rrp_inde2_20_loan_tot_prov) {
		this.rrp_inde2_20_loan_tot_prov = rrp_inde2_20_loan_tot_prov;
	}
	public BigDecimal getRrp_inde2_20_loan_int_sus() {
		return rrp_inde2_20_loan_int_sus;
	}
	public void setRrp_inde2_20_loan_int_sus(BigDecimal rrp_inde2_20_loan_int_sus) {
		this.rrp_inde2_20_loan_int_sus = rrp_inde2_20_loan_int_sus;
	}
	public BigDecimal getRrp_inde2_20_loan_crm() {
		return rrp_inde2_20_loan_crm;
	}
	public void setRrp_inde2_20_loan_crm(BigDecimal rrp_inde2_20_loan_crm) {
		this.rrp_inde2_20_loan_crm = rrp_inde2_20_loan_crm;
	}
	public BigDecimal getRrp_inde2_20_loan_tot_dra() {
		return rrp_inde2_20_loan_tot_dra;
	}
	public void setRrp_inde2_20_loan_tot_dra(BigDecimal rrp_inde2_20_loan_tot_dra) {
		this.rrp_inde2_20_loan_tot_dra = rrp_inde2_20_loan_tot_dra;
	}
	public BigDecimal getRrp_inde2_20_inves_bal() {
		return rrp_inde2_20_inves_bal;
	}
	public void setRrp_inde2_20_inves_bal(BigDecimal rrp_inde2_20_inves_bal) {
		this.rrp_inde2_20_inves_bal = rrp_inde2_20_inves_bal;
	}
	public BigDecimal getRrp_inde2_20_inves_prov() {
		return rrp_inde2_20_inves_prov;
	}
	public void setRrp_inde2_20_inves_prov(BigDecimal rrp_inde2_20_inves_prov) {
		this.rrp_inde2_20_inves_prov = rrp_inde2_20_inves_prov;
	}
	public BigDecimal getRrp_inde2_20_inves_crm() {
		return rrp_inde2_20_inves_crm;
	}
	public void setRrp_inde2_20_inves_crm(BigDecimal rrp_inde2_20_inves_crm) {
		this.rrp_inde2_20_inves_crm = rrp_inde2_20_inves_crm;
	}
	public BigDecimal getRrp_inde2_20_inves_rwa() {
		return rrp_inde2_20_inves_rwa;
	}
	public void setRrp_inde2_20_inves_rwa(BigDecimal rrp_inde2_20_inves_rwa) {
		this.rrp_inde2_20_inves_rwa = rrp_inde2_20_inves_rwa;
	}
	public BigDecimal getRrp_inde2_20_plac_bal() {
		return rrp_inde2_20_plac_bal;
	}
	public void setRrp_inde2_20_plac_bal(BigDecimal rrp_inde2_20_plac_bal) {
		this.rrp_inde2_20_plac_bal = rrp_inde2_20_plac_bal;
	}
	public BigDecimal getRrp_inde2_20_plac_prov() {
		return rrp_inde2_20_plac_prov;
	}
	public void setRrp_inde2_20_plac_prov(BigDecimal rrp_inde2_20_plac_prov) {
		this.rrp_inde2_20_plac_prov = rrp_inde2_20_plac_prov;
	}
	public BigDecimal getRrp_inde2_20_plac_crm() {
		return rrp_inde2_20_plac_crm;
	}
	public void setRrp_inde2_20_plac_crm(BigDecimal rrp_inde2_20_plac_crm) {
		this.rrp_inde2_20_plac_crm = rrp_inde2_20_plac_crm;
	}
	public BigDecimal getRrp_inde2_20_plac_rwa() {
		return rrp_inde2_20_plac_rwa;
	}
	public void setRrp_inde2_20_plac_rwa(BigDecimal rrp_inde2_20_plac_rwa) {
		this.rrp_inde2_20_plac_rwa = rrp_inde2_20_plac_rwa;
	}
	public BigDecimal getRrp_inde2_20_cash_bal() {
		return rrp_inde2_20_cash_bal;
	}
	public void setRrp_inde2_20_cash_bal(BigDecimal rrp_inde2_20_cash_bal) {
		this.rrp_inde2_20_cash_bal = rrp_inde2_20_cash_bal;
	}
	public BigDecimal getRrp_inde2_20_cash_prov() {
		return rrp_inde2_20_cash_prov;
	}
	public void setRrp_inde2_20_cash_prov(BigDecimal rrp_inde2_20_cash_prov) {
		this.rrp_inde2_20_cash_prov = rrp_inde2_20_cash_prov;
	}
	public BigDecimal getRrp_inde2_20_cash_crm() {
		return rrp_inde2_20_cash_crm;
	}
	public void setRrp_inde2_20_cash_crm(BigDecimal rrp_inde2_20_cash_crm) {
		this.rrp_inde2_20_cash_crm = rrp_inde2_20_cash_crm;
	}
	public BigDecimal getRrp_inde2_20_cash_rwa() {
		return rrp_inde2_20_cash_rwa;
	}
	public void setRrp_inde2_20_cash_rwa(BigDecimal rrp_inde2_20_cash_rwa) {
		this.rrp_inde2_20_cash_rwa = rrp_inde2_20_cash_rwa;
	}
	public BigDecimal getRrp_inde2_20_tot_bal() {
		return rrp_inde2_20_tot_bal;
	}
	public void setRrp_inde2_20_tot_bal(BigDecimal rrp_inde2_20_tot_bal) {
		this.rrp_inde2_20_tot_bal = rrp_inde2_20_tot_bal;
	}
	public BigDecimal getRrp_inde2_20_tot_prov() {
		return rrp_inde2_20_tot_prov;
	}
	public void setRrp_inde2_20_tot_prov(BigDecimal rrp_inde2_20_tot_prov) {
		this.rrp_inde2_20_tot_prov = rrp_inde2_20_tot_prov;
	}
	public BigDecimal getRrp_inde2_20_tot_int_sus() {
		return rrp_inde2_20_tot_int_sus;
	}
	public void setRrp_inde2_20_tot_int_sus(BigDecimal rrp_inde2_20_tot_int_sus) {
		this.rrp_inde2_20_tot_int_sus = rrp_inde2_20_tot_int_sus;
	}
	public BigDecimal getRrp_inde2_20_tot_crm() {
		return rrp_inde2_20_tot_crm;
	}
	public void setRrp_inde2_20_tot_crm(BigDecimal rrp_inde2_20_tot_crm) {
		this.rrp_inde2_20_tot_crm = rrp_inde2_20_tot_crm;
	}
	public BigDecimal getRrp_inde2_20_tot_rwa() {
		return rrp_inde2_20_tot_rwa;
	}
	public void setRrp_inde2_20_tot_rwa(BigDecimal rrp_inde2_20_tot_rwa) {
		this.rrp_inde2_20_tot_rwa = rrp_inde2_20_tot_rwa;
	}
	public BigDecimal getRrp_inde2_50_loan_bal() {
		return rrp_inde2_50_loan_bal;
	}
	public void setRrp_inde2_50_loan_bal(BigDecimal rrp_inde2_50_loan_bal) {
		this.rrp_inde2_50_loan_bal = rrp_inde2_50_loan_bal;
	}
	public BigDecimal getRrp_inde2_50_loan_bill_amt() {
		return rrp_inde2_50_loan_bill_amt;
	}
	public void setRrp_inde2_50_loan_bill_amt(BigDecimal rrp_inde2_50_loan_bill_amt) {
		this.rrp_inde2_50_loan_bill_amt = rrp_inde2_50_loan_bill_amt;
	}
	public BigDecimal getRrp_inde2_50_loan_tot_bal() {
		return rrp_inde2_50_loan_tot_bal;
	}
	public void setRrp_inde2_50_loan_tot_bal(BigDecimal rrp_inde2_50_loan_tot_bal) {
		this.rrp_inde2_50_loan_tot_bal = rrp_inde2_50_loan_tot_bal;
	}
	public BigDecimal getRrp_inde2_50_loan_tot_prov() {
		return rrp_inde2_50_loan_tot_prov;
	}
	public void setRrp_inde2_50_loan_tot_prov(BigDecimal rrp_inde2_50_loan_tot_prov) {
		this.rrp_inde2_50_loan_tot_prov = rrp_inde2_50_loan_tot_prov;
	}
	public BigDecimal getRrp_inde2_50_loan_int_sus() {
		return rrp_inde2_50_loan_int_sus;
	}
	public void setRrp_inde2_50_loan_int_sus(BigDecimal rrp_inde2_50_loan_int_sus) {
		this.rrp_inde2_50_loan_int_sus = rrp_inde2_50_loan_int_sus;
	}
	public BigDecimal getRrp_inde2_50_loan_crm() {
		return rrp_inde2_50_loan_crm;
	}
	public void setRrp_inde2_50_loan_crm(BigDecimal rrp_inde2_50_loan_crm) {
		this.rrp_inde2_50_loan_crm = rrp_inde2_50_loan_crm;
	}
	public BigDecimal getRrp_inde2_50_loan_tot_dra() {
		return rrp_inde2_50_loan_tot_dra;
	}
	public void setRrp_inde2_50_loan_tot_dra(BigDecimal rrp_inde2_50_loan_tot_dra) {
		this.rrp_inde2_50_loan_tot_dra = rrp_inde2_50_loan_tot_dra;
	}
	public BigDecimal getRrp_inde2_50_inves_bal() {
		return rrp_inde2_50_inves_bal;
	}
	public void setRrp_inde2_50_inves_bal(BigDecimal rrp_inde2_50_inves_bal) {
		this.rrp_inde2_50_inves_bal = rrp_inde2_50_inves_bal;
	}
	public BigDecimal getRrp_inde2_50_inves_prov() {
		return rrp_inde2_50_inves_prov;
	}
	public void setRrp_inde2_50_inves_prov(BigDecimal rrp_inde2_50_inves_prov) {
		this.rrp_inde2_50_inves_prov = rrp_inde2_50_inves_prov;
	}
	public BigDecimal getRrp_inde2_50_inves_crm() {
		return rrp_inde2_50_inves_crm;
	}
	public void setRrp_inde2_50_inves_crm(BigDecimal rrp_inde2_50_inves_crm) {
		this.rrp_inde2_50_inves_crm = rrp_inde2_50_inves_crm;
	}
	public BigDecimal getRrp_inde2_50_inves_rwa() {
		return rrp_inde2_50_inves_rwa;
	}
	public void setRrp_inde2_50_inves_rwa(BigDecimal rrp_inde2_50_inves_rwa) {
		this.rrp_inde2_50_inves_rwa = rrp_inde2_50_inves_rwa;
	}
	public BigDecimal getRrp_inde2_50_plac_bal() {
		return rrp_inde2_50_plac_bal;
	}
	public void setRrp_inde2_50_plac_bal(BigDecimal rrp_inde2_50_plac_bal) {
		this.rrp_inde2_50_plac_bal = rrp_inde2_50_plac_bal;
	}
	public BigDecimal getRrp_inde2_50_plac_prov() {
		return rrp_inde2_50_plac_prov;
	}
	public void setRrp_inde2_50_plac_prov(BigDecimal rrp_inde2_50_plac_prov) {
		this.rrp_inde2_50_plac_prov = rrp_inde2_50_plac_prov;
	}
	public BigDecimal getRrp_inde2_50_plac_crm() {
		return rrp_inde2_50_plac_crm;
	}
	public void setRrp_inde2_50_plac_crm(BigDecimal rrp_inde2_50_plac_crm) {
		this.rrp_inde2_50_plac_crm = rrp_inde2_50_plac_crm;
	}
	public BigDecimal getRrp_inde2_50_plac_rwa() {
		return rrp_inde2_50_plac_rwa;
	}
	public void setRrp_inde2_50_plac_rwa(BigDecimal rrp_inde2_50_plac_rwa) {
		this.rrp_inde2_50_plac_rwa = rrp_inde2_50_plac_rwa;
	}
	public BigDecimal getRrp_inde2_50_cash_bal() {
		return rrp_inde2_50_cash_bal;
	}
	public void setRrp_inde2_50_cash_bal(BigDecimal rrp_inde2_50_cash_bal) {
		this.rrp_inde2_50_cash_bal = rrp_inde2_50_cash_bal;
	}
	public BigDecimal getRrp_inde2_50_cash_prov() {
		return rrp_inde2_50_cash_prov;
	}
	public void setRrp_inde2_50_cash_prov(BigDecimal rrp_inde2_50_cash_prov) {
		this.rrp_inde2_50_cash_prov = rrp_inde2_50_cash_prov;
	}
	public BigDecimal getRrp_inde2_50_cash_crm() {
		return rrp_inde2_50_cash_crm;
	}
	public void setRrp_inde2_50_cash_crm(BigDecimal rrp_inde2_50_cash_crm) {
		this.rrp_inde2_50_cash_crm = rrp_inde2_50_cash_crm;
	}
	public BigDecimal getRrp_inde2_50_cash_rwa() {
		return rrp_inde2_50_cash_rwa;
	}
	public void setRrp_inde2_50_cash_rwa(BigDecimal rrp_inde2_50_cash_rwa) {
		this.rrp_inde2_50_cash_rwa = rrp_inde2_50_cash_rwa;
	}
	public BigDecimal getRrp_inde2_50_tot_bal() {
		return rrp_inde2_50_tot_bal;
	}
	public void setRrp_inde2_50_tot_bal(BigDecimal rrp_inde2_50_tot_bal) {
		this.rrp_inde2_50_tot_bal = rrp_inde2_50_tot_bal;
	}
	public BigDecimal getRrp_inde2_50_tot_prov() {
		return rrp_inde2_50_tot_prov;
	}
	public void setRrp_inde2_50_tot_prov(BigDecimal rrp_inde2_50_tot_prov) {
		this.rrp_inde2_50_tot_prov = rrp_inde2_50_tot_prov;
	}
	public BigDecimal getRrp_inde2_50_tot_int_sus() {
		return rrp_inde2_50_tot_int_sus;
	}
	public void setRrp_inde2_50_tot_int_sus(BigDecimal rrp_inde2_50_tot_int_sus) {
		this.rrp_inde2_50_tot_int_sus = rrp_inde2_50_tot_int_sus;
	}
	public BigDecimal getRrp_inde2_50_tot_crm() {
		return rrp_inde2_50_tot_crm;
	}
	public void setRrp_inde2_50_tot_crm(BigDecimal rrp_inde2_50_tot_crm) {
		this.rrp_inde2_50_tot_crm = rrp_inde2_50_tot_crm;
	}
	public BigDecimal getRrp_inde2_50_tot_rwa() {
		return rrp_inde2_50_tot_rwa;
	}
	public void setRrp_inde2_50_tot_rwa(BigDecimal rrp_inde2_50_tot_rwa) {
		this.rrp_inde2_50_tot_rwa = rrp_inde2_50_tot_rwa;
	}
	public BigDecimal getRrp_inde2_150_loan_bal() {
		return rrp_inde2_150_loan_bal;
	}
	public void setRrp_inde2_150_loan_bal(BigDecimal rrp_inde2_150_loan_bal) {
		this.rrp_inde2_150_loan_bal = rrp_inde2_150_loan_bal;
	}
	public BigDecimal getRrp_inde2_150_loan_bill_amt() {
		return rrp_inde2_150_loan_bill_amt;
	}
	public void setRrp_inde2_150_loan_bill_amt(BigDecimal rrp_inde2_150_loan_bill_amt) {
		this.rrp_inde2_150_loan_bill_amt = rrp_inde2_150_loan_bill_amt;
	}
	public BigDecimal getRrp_inde2_150_loan_tot_bal() {
		return rrp_inde2_150_loan_tot_bal;
	}
	public void setRrp_inde2_150_loan_tot_bal(BigDecimal rrp_inde2_150_loan_tot_bal) {
		this.rrp_inde2_150_loan_tot_bal = rrp_inde2_150_loan_tot_bal;
	}
	public BigDecimal getRrp_inde2_150_loan_tot_prov() {
		return rrp_inde2_150_loan_tot_prov;
	}
	public void setRrp_inde2_150_loan_tot_prov(BigDecimal rrp_inde2_150_loan_tot_prov) {
		this.rrp_inde2_150_loan_tot_prov = rrp_inde2_150_loan_tot_prov;
	}
	public BigDecimal getRrp_inde2_150_loan_int_sus() {
		return rrp_inde2_150_loan_int_sus;
	}
	public void setRrp_inde2_150_loan_int_sus(BigDecimal rrp_inde2_150_loan_int_sus) {
		this.rrp_inde2_150_loan_int_sus = rrp_inde2_150_loan_int_sus;
	}
	public BigDecimal getRrp_inde2_150_loan_crm() {
		return rrp_inde2_150_loan_crm;
	}
	public void setRrp_inde2_150_loan_crm(BigDecimal rrp_inde2_150_loan_crm) {
		this.rrp_inde2_150_loan_crm = rrp_inde2_150_loan_crm;
	}
	public BigDecimal getRrp_inde2_150_loan_tot_dra() {
		return rrp_inde2_150_loan_tot_dra;
	}
	public void setRrp_inde2_150_loan_tot_dra(BigDecimal rrp_inde2_150_loan_tot_dra) {
		this.rrp_inde2_150_loan_tot_dra = rrp_inde2_150_loan_tot_dra;
	}
	public BigDecimal getRrp_inde2_150_inves_bal() {
		return rrp_inde2_150_inves_bal;
	}
	public void setRrp_inde2_150_inves_bal(BigDecimal rrp_inde2_150_inves_bal) {
		this.rrp_inde2_150_inves_bal = rrp_inde2_150_inves_bal;
	}
	public BigDecimal getRrp_inde2_150_inves_prov() {
		return rrp_inde2_150_inves_prov;
	}
	public void setRrp_inde2_150_inves_prov(BigDecimal rrp_inde2_150_inves_prov) {
		this.rrp_inde2_150_inves_prov = rrp_inde2_150_inves_prov;
	}
	public BigDecimal getRrp_inde2_150_inves_crm() {
		return rrp_inde2_150_inves_crm;
	}
	public void setRrp_inde2_150_inves_crm(BigDecimal rrp_inde2_150_inves_crm) {
		this.rrp_inde2_150_inves_crm = rrp_inde2_150_inves_crm;
	}
	public BigDecimal getRrp_inde2_150_inves_rwa() {
		return rrp_inde2_150_inves_rwa;
	}
	public void setRrp_inde2_150_inves_rwa(BigDecimal rrp_inde2_150_inves_rwa) {
		this.rrp_inde2_150_inves_rwa = rrp_inde2_150_inves_rwa;
	}
	public BigDecimal getRrp_inde2_150_plac_bal() {
		return rrp_inde2_150_plac_bal;
	}
	public void setRrp_inde2_150_plac_bal(BigDecimal rrp_inde2_150_plac_bal) {
		this.rrp_inde2_150_plac_bal = rrp_inde2_150_plac_bal;
	}
	public BigDecimal getRrp_inde2_150_plac_prov() {
		return rrp_inde2_150_plac_prov;
	}
	public void setRrp_inde2_150_plac_prov(BigDecimal rrp_inde2_150_plac_prov) {
		this.rrp_inde2_150_plac_prov = rrp_inde2_150_plac_prov;
	}
	public BigDecimal getRrp_inde2_150_plac_crm() {
		return rrp_inde2_150_plac_crm;
	}
	public void setRrp_inde2_150_plac_crm(BigDecimal rrp_inde2_150_plac_crm) {
		this.rrp_inde2_150_plac_crm = rrp_inde2_150_plac_crm;
	}
	public BigDecimal getRrp_inde2_150_plac_rwa() {
		return rrp_inde2_150_plac_rwa;
	}
	public void setRrp_inde2_150_plac_rwa(BigDecimal rrp_inde2_150_plac_rwa) {
		this.rrp_inde2_150_plac_rwa = rrp_inde2_150_plac_rwa;
	}
	public BigDecimal getRrp_inde2_150_cash_bal() {
		return rrp_inde2_150_cash_bal;
	}
	public void setRrp_inde2_150_cash_bal(BigDecimal rrp_inde2_150_cash_bal) {
		this.rrp_inde2_150_cash_bal = rrp_inde2_150_cash_bal;
	}
	public BigDecimal getRrp_inde2_150_cash_prov() {
		return rrp_inde2_150_cash_prov;
	}
	public void setRrp_inde2_150_cash_prov(BigDecimal rrp_inde2_150_cash_prov) {
		this.rrp_inde2_150_cash_prov = rrp_inde2_150_cash_prov;
	}
	public BigDecimal getRrp_inde2_150_cash_crm() {
		return rrp_inde2_150_cash_crm;
	}
	public void setRrp_inde2_150_cash_crm(BigDecimal rrp_inde2_150_cash_crm) {
		this.rrp_inde2_150_cash_crm = rrp_inde2_150_cash_crm;
	}
	public BigDecimal getRrp_inde2_150_cash_rwa() {
		return rrp_inde2_150_cash_rwa;
	}
	public void setRrp_inde2_150_cash_rwa(BigDecimal rrp_inde2_150_cash_rwa) {
		this.rrp_inde2_150_cash_rwa = rrp_inde2_150_cash_rwa;
	}
	public BigDecimal getRrp_inde2_150_tot_bal() {
		return rrp_inde2_150_tot_bal;
	}
	public void setRrp_inde2_150_tot_bal(BigDecimal rrp_inde2_150_tot_bal) {
		this.rrp_inde2_150_tot_bal = rrp_inde2_150_tot_bal;
	}
	public BigDecimal getRrp_inde2_150_tot_prov() {
		return rrp_inde2_150_tot_prov;
	}
	public void setRrp_inde2_150_tot_prov(BigDecimal rrp_inde2_150_tot_prov) {
		this.rrp_inde2_150_tot_prov = rrp_inde2_150_tot_prov;
	}
	public BigDecimal getRrp_inde2_150_tot_int_sus() {
		return rrp_inde2_150_tot_int_sus;
	}
	public void setRrp_inde2_150_tot_int_sus(BigDecimal rrp_inde2_150_tot_int_sus) {
		this.rrp_inde2_150_tot_int_sus = rrp_inde2_150_tot_int_sus;
	}
	public BigDecimal getRrp_inde2_150_tot_crm() {
		return rrp_inde2_150_tot_crm;
	}
	public void setRrp_inde2_150_tot_crm(BigDecimal rrp_inde2_150_tot_crm) {
		this.rrp_inde2_150_tot_crm = rrp_inde2_150_tot_crm;
	}
	public BigDecimal getRrp_inde2_150_tot_rwa() {
		return rrp_inde2_150_tot_rwa;
	}
	public void setRrp_inde2_150_tot_rwa(BigDecimal rrp_inde2_150_tot_rwa) {
		this.rrp_inde2_150_tot_rwa = rrp_inde2_150_tot_rwa;
	}
	public BigDecimal getRrp_smlb_0_loan_bal() {
		return rrp_smlb_0_loan_bal;
	}
	public void setRrp_smlb_0_loan_bal(BigDecimal rrp_smlb_0_loan_bal) {
		this.rrp_smlb_0_loan_bal = rrp_smlb_0_loan_bal;
	}
	public BigDecimal getRrp_smlb_0_loan_bill_amt() {
		return rrp_smlb_0_loan_bill_amt;
	}
	public void setRrp_smlb_0_loan_bill_amt(BigDecimal rrp_smlb_0_loan_bill_amt) {
		this.rrp_smlb_0_loan_bill_amt = rrp_smlb_0_loan_bill_amt;
	}
	public BigDecimal getRrp_smlb_0_loan_tot_bal() {
		return rrp_smlb_0_loan_tot_bal;
	}
	public void setRrp_smlb_0_loan_tot_bal(BigDecimal rrp_smlb_0_loan_tot_bal) {
		this.rrp_smlb_0_loan_tot_bal = rrp_smlb_0_loan_tot_bal;
	}
	public BigDecimal getRrp_smlb_0_loan_tot_prov() {
		return rrp_smlb_0_loan_tot_prov;
	}
	public void setRrp_smlb_0_loan_tot_prov(BigDecimal rrp_smlb_0_loan_tot_prov) {
		this.rrp_smlb_0_loan_tot_prov = rrp_smlb_0_loan_tot_prov;
	}
	public BigDecimal getRrp_smlb_0_loan_int_sus() {
		return rrp_smlb_0_loan_int_sus;
	}
	public void setRrp_smlb_0_loan_int_sus(BigDecimal rrp_smlb_0_loan_int_sus) {
		this.rrp_smlb_0_loan_int_sus = rrp_smlb_0_loan_int_sus;
	}
	public BigDecimal getRrp_smlb_0_loan_crm() {
		return rrp_smlb_0_loan_crm;
	}
	public void setRrp_smlb_0_loan_crm(BigDecimal rrp_smlb_0_loan_crm) {
		this.rrp_smlb_0_loan_crm = rrp_smlb_0_loan_crm;
	}
	public BigDecimal getRrp_smlb_0_loan_tot_dra() {
		return rrp_smlb_0_loan_tot_dra;
	}
	public void setRrp_smlb_0_loan_tot_dra(BigDecimal rrp_smlb_0_loan_tot_dra) {
		this.rrp_smlb_0_loan_tot_dra = rrp_smlb_0_loan_tot_dra;
	}
	public BigDecimal getRrp_smlb_0_inves_bal() {
		return rrp_smlb_0_inves_bal;
	}
	public void setRrp_smlb_0_inves_bal(BigDecimal rrp_smlb_0_inves_bal) {
		this.rrp_smlb_0_inves_bal = rrp_smlb_0_inves_bal;
	}
	public BigDecimal getRrp_smlb_0_inves_prov() {
		return rrp_smlb_0_inves_prov;
	}
	public void setRrp_smlb_0_inves_prov(BigDecimal rrp_smlb_0_inves_prov) {
		this.rrp_smlb_0_inves_prov = rrp_smlb_0_inves_prov;
	}
	public BigDecimal getRrp_smlb_0_inves_crm() {
		return rrp_smlb_0_inves_crm;
	}
	public void setRrp_smlb_0_inves_crm(BigDecimal rrp_smlb_0_inves_crm) {
		this.rrp_smlb_0_inves_crm = rrp_smlb_0_inves_crm;
	}
	public BigDecimal getRrp_smlb_0_inves_rwa() {
		return rrp_smlb_0_inves_rwa;
	}
	public void setRrp_smlb_0_inves_rwa(BigDecimal rrp_smlb_0_inves_rwa) {
		this.rrp_smlb_0_inves_rwa = rrp_smlb_0_inves_rwa;
	}
	public BigDecimal getRrp_smlb_0_plac_bal() {
		return rrp_smlb_0_plac_bal;
	}
	public void setRrp_smlb_0_plac_bal(BigDecimal rrp_smlb_0_plac_bal) {
		this.rrp_smlb_0_plac_bal = rrp_smlb_0_plac_bal;
	}
	public BigDecimal getRrp_smlb_0_plac_prov() {
		return rrp_smlb_0_plac_prov;
	}
	public void setRrp_smlb_0_plac_prov(BigDecimal rrp_smlb_0_plac_prov) {
		this.rrp_smlb_0_plac_prov = rrp_smlb_0_plac_prov;
	}
	public BigDecimal getRrp_smlb_0_plac_crm() {
		return rrp_smlb_0_plac_crm;
	}
	public void setRrp_smlb_0_plac_crm(BigDecimal rrp_smlb_0_plac_crm) {
		this.rrp_smlb_0_plac_crm = rrp_smlb_0_plac_crm;
	}
	public BigDecimal getRrp_smlb_0_plac_rwa() {
		return rrp_smlb_0_plac_rwa;
	}
	public void setRrp_smlb_0_plac_rwa(BigDecimal rrp_smlb_0_plac_rwa) {
		this.rrp_smlb_0_plac_rwa = rrp_smlb_0_plac_rwa;
	}
	public BigDecimal getRrp_smlb_0_cash_bal() {
		return rrp_smlb_0_cash_bal;
	}
	public void setRrp_smlb_0_cash_bal(BigDecimal rrp_smlb_0_cash_bal) {
		this.rrp_smlb_0_cash_bal = rrp_smlb_0_cash_bal;
	}
	public BigDecimal getRrp_smlb_0_cash_prov() {
		return rrp_smlb_0_cash_prov;
	}
	public void setRrp_smlb_0_cash_prov(BigDecimal rrp_smlb_0_cash_prov) {
		this.rrp_smlb_0_cash_prov = rrp_smlb_0_cash_prov;
	}
	public BigDecimal getRrp_smlb_0_cash_crm() {
		return rrp_smlb_0_cash_crm;
	}
	public void setRrp_smlb_0_cash_crm(BigDecimal rrp_smlb_0_cash_crm) {
		this.rrp_smlb_0_cash_crm = rrp_smlb_0_cash_crm;
	}
	public BigDecimal getRrp_smlb_0_cash_rwa() {
		return rrp_smlb_0_cash_rwa;
	}
	public void setRrp_smlb_0_cash_rwa(BigDecimal rrp_smlb_0_cash_rwa) {
		this.rrp_smlb_0_cash_rwa = rrp_smlb_0_cash_rwa;
	}
	public BigDecimal getRrp_smlb_0_tot_bal() {
		return rrp_smlb_0_tot_bal;
	}
	public void setRrp_smlb_0_tot_bal(BigDecimal rrp_smlb_0_tot_bal) {
		this.rrp_smlb_0_tot_bal = rrp_smlb_0_tot_bal;
	}
	public BigDecimal getRrp_smlb_0_tot_prov() {
		return rrp_smlb_0_tot_prov;
	}
	public void setRrp_smlb_0_tot_prov(BigDecimal rrp_smlb_0_tot_prov) {
		this.rrp_smlb_0_tot_prov = rrp_smlb_0_tot_prov;
	}
	public BigDecimal getRrp_smlb_0_tot_int_sus() {
		return rrp_smlb_0_tot_int_sus;
	}
	public void setRrp_smlb_0_tot_int_sus(BigDecimal rrp_smlb_0_tot_int_sus) {
		this.rrp_smlb_0_tot_int_sus = rrp_smlb_0_tot_int_sus;
	}
	public BigDecimal getRrp_smlb_0_tot_crm() {
		return rrp_smlb_0_tot_crm;
	}
	public void setRrp_smlb_0_tot_crm(BigDecimal rrp_smlb_0_tot_crm) {
		this.rrp_smlb_0_tot_crm = rrp_smlb_0_tot_crm;
	}
	public BigDecimal getRrp_smlb_0_tot_rwa() {
		return rrp_smlb_0_tot_rwa;
	}
	public void setRrp_smlb_0_tot_rwa(BigDecimal rrp_smlb_0_tot_rwa) {
		this.rrp_smlb_0_tot_rwa = rrp_smlb_0_tot_rwa;
	}
	public BigDecimal getRrp_smlb_20_loan_bal() {
		return rrp_smlb_20_loan_bal;
	}
	public void setRrp_smlb_20_loan_bal(BigDecimal rrp_smlb_20_loan_bal) {
		this.rrp_smlb_20_loan_bal = rrp_smlb_20_loan_bal;
	}
	public BigDecimal getRrp_smlb_20_loan_bill_amt() {
		return rrp_smlb_20_loan_bill_amt;
	}
	public void setRrp_smlb_20_loan_bill_amt(BigDecimal rrp_smlb_20_loan_bill_amt) {
		this.rrp_smlb_20_loan_bill_amt = rrp_smlb_20_loan_bill_amt;
	}
	public BigDecimal getRrp_smlb_20_loan_tot_bal() {
		return rrp_smlb_20_loan_tot_bal;
	}
	public void setRrp_smlb_20_loan_tot_bal(BigDecimal rrp_smlb_20_loan_tot_bal) {
		this.rrp_smlb_20_loan_tot_bal = rrp_smlb_20_loan_tot_bal;
	}
	public BigDecimal getRrp_smlb_20_loan_tot_prov() {
		return rrp_smlb_20_loan_tot_prov;
	}
	public void setRrp_smlb_20_loan_tot_prov(BigDecimal rrp_smlb_20_loan_tot_prov) {
		this.rrp_smlb_20_loan_tot_prov = rrp_smlb_20_loan_tot_prov;
	}
	public BigDecimal getRrp_smlb_20_loan_int_sus() {
		return rrp_smlb_20_loan_int_sus;
	}
	public void setRrp_smlb_20_loan_int_sus(BigDecimal rrp_smlb_20_loan_int_sus) {
		this.rrp_smlb_20_loan_int_sus = rrp_smlb_20_loan_int_sus;
	}
	public BigDecimal getRrp_smlb_20_loan_crm() {
		return rrp_smlb_20_loan_crm;
	}
	public void setRrp_smlb_20_loan_crm(BigDecimal rrp_smlb_20_loan_crm) {
		this.rrp_smlb_20_loan_crm = rrp_smlb_20_loan_crm;
	}
	public BigDecimal getRrp_smlb_20_loan_tot_dra() {
		return rrp_smlb_20_loan_tot_dra;
	}
	public void setRrp_smlb_20_loan_tot_dra(BigDecimal rrp_smlb_20_loan_tot_dra) {
		this.rrp_smlb_20_loan_tot_dra = rrp_smlb_20_loan_tot_dra;
	}
	public BigDecimal getRrp_smlb_20_inves_bal() {
		return rrp_smlb_20_inves_bal;
	}
	public void setRrp_smlb_20_inves_bal(BigDecimal rrp_smlb_20_inves_bal) {
		this.rrp_smlb_20_inves_bal = rrp_smlb_20_inves_bal;
	}
	public BigDecimal getRrp_smlb_20_inves_prov() {
		return rrp_smlb_20_inves_prov;
	}
	public void setRrp_smlb_20_inves_prov(BigDecimal rrp_smlb_20_inves_prov) {
		this.rrp_smlb_20_inves_prov = rrp_smlb_20_inves_prov;
	}
	public BigDecimal getRrp_smlb_20_inves_crm() {
		return rrp_smlb_20_inves_crm;
	}
	public void setRrp_smlb_20_inves_crm(BigDecimal rrp_smlb_20_inves_crm) {
		this.rrp_smlb_20_inves_crm = rrp_smlb_20_inves_crm;
	}
	public BigDecimal getRrp_smlb_20_inves_rwa() {
		return rrp_smlb_20_inves_rwa;
	}
	public void setRrp_smlb_20_inves_rwa(BigDecimal rrp_smlb_20_inves_rwa) {
		this.rrp_smlb_20_inves_rwa = rrp_smlb_20_inves_rwa;
	}
	public BigDecimal getRrp_smlb_20_plac_bal() {
		return rrp_smlb_20_plac_bal;
	}
	public void setRrp_smlb_20_plac_bal(BigDecimal rrp_smlb_20_plac_bal) {
		this.rrp_smlb_20_plac_bal = rrp_smlb_20_plac_bal;
	}
	public BigDecimal getRrp_smlb_20_plac_prov() {
		return rrp_smlb_20_plac_prov;
	}
	public void setRrp_smlb_20_plac_prov(BigDecimal rrp_smlb_20_plac_prov) {
		this.rrp_smlb_20_plac_prov = rrp_smlb_20_plac_prov;
	}
	public BigDecimal getRrp_smlb_20_plac_crm() {
		return rrp_smlb_20_plac_crm;
	}
	public void setRrp_smlb_20_plac_crm(BigDecimal rrp_smlb_20_plac_crm) {
		this.rrp_smlb_20_plac_crm = rrp_smlb_20_plac_crm;
	}
	public BigDecimal getRrp_smlb_20_plac_rwa() {
		return rrp_smlb_20_plac_rwa;
	}
	public void setRrp_smlb_20_plac_rwa(BigDecimal rrp_smlb_20_plac_rwa) {
		this.rrp_smlb_20_plac_rwa = rrp_smlb_20_plac_rwa;
	}
	public BigDecimal getRrp_smlb_20_cash_bal() {
		return rrp_smlb_20_cash_bal;
	}
	public void setRrp_smlb_20_cash_bal(BigDecimal rrp_smlb_20_cash_bal) {
		this.rrp_smlb_20_cash_bal = rrp_smlb_20_cash_bal;
	}
	public BigDecimal getRrp_smlb_20_cash_prov() {
		return rrp_smlb_20_cash_prov;
	}
	public void setRrp_smlb_20_cash_prov(BigDecimal rrp_smlb_20_cash_prov) {
		this.rrp_smlb_20_cash_prov = rrp_smlb_20_cash_prov;
	}
	public BigDecimal getRrp_smlb_20_cash_crm() {
		return rrp_smlb_20_cash_crm;
	}
	public void setRrp_smlb_20_cash_crm(BigDecimal rrp_smlb_20_cash_crm) {
		this.rrp_smlb_20_cash_crm = rrp_smlb_20_cash_crm;
	}
	public BigDecimal getRrp_smlb_20_cash_rwa() {
		return rrp_smlb_20_cash_rwa;
	}
	public void setRrp_smlb_20_cash_rwa(BigDecimal rrp_smlb_20_cash_rwa) {
		this.rrp_smlb_20_cash_rwa = rrp_smlb_20_cash_rwa;
	}
	public BigDecimal getRrp_smlb_20_tot_bal() {
		return rrp_smlb_20_tot_bal;
	}
	public void setRrp_smlb_20_tot_bal(BigDecimal rrp_smlb_20_tot_bal) {
		this.rrp_smlb_20_tot_bal = rrp_smlb_20_tot_bal;
	}
	public BigDecimal getRrp_smlb_20_tot_prov() {
		return rrp_smlb_20_tot_prov;
	}
	public void setRrp_smlb_20_tot_prov(BigDecimal rrp_smlb_20_tot_prov) {
		this.rrp_smlb_20_tot_prov = rrp_smlb_20_tot_prov;
	}
	public BigDecimal getRrp_smlb_20_tot_int_sus() {
		return rrp_smlb_20_tot_int_sus;
	}
	public void setRrp_smlb_20_tot_int_sus(BigDecimal rrp_smlb_20_tot_int_sus) {
		this.rrp_smlb_20_tot_int_sus = rrp_smlb_20_tot_int_sus;
	}
	public BigDecimal getRrp_smlb_20_tot_crm() {
		return rrp_smlb_20_tot_crm;
	}
	public void setRrp_smlb_20_tot_crm(BigDecimal rrp_smlb_20_tot_crm) {
		this.rrp_smlb_20_tot_crm = rrp_smlb_20_tot_crm;
	}
	public BigDecimal getRrp_smlb_20_tot_rwa() {
		return rrp_smlb_20_tot_rwa;
	}
	public void setRrp_smlb_20_tot_rwa(BigDecimal rrp_smlb_20_tot_rwa) {
		this.rrp_smlb_20_tot_rwa = rrp_smlb_20_tot_rwa;
	}
	public BigDecimal getRrp_smlb_50_loan_bal() {
		return rrp_smlb_50_loan_bal;
	}
	public void setRrp_smlb_50_loan_bal(BigDecimal rrp_smlb_50_loan_bal) {
		this.rrp_smlb_50_loan_bal = rrp_smlb_50_loan_bal;
	}
	public BigDecimal getRrp_smlb_50_loan_bill_amt() {
		return rrp_smlb_50_loan_bill_amt;
	}
	public void setRrp_smlb_50_loan_bill_amt(BigDecimal rrp_smlb_50_loan_bill_amt) {
		this.rrp_smlb_50_loan_bill_amt = rrp_smlb_50_loan_bill_amt;
	}
	public BigDecimal getRrp_smlb_50_loan_tot_bal() {
		return rrp_smlb_50_loan_tot_bal;
	}
	public void setRrp_smlb_50_loan_tot_bal(BigDecimal rrp_smlb_50_loan_tot_bal) {
		this.rrp_smlb_50_loan_tot_bal = rrp_smlb_50_loan_tot_bal;
	}
	public BigDecimal getRrp_smlb_50_loan_tot_prov() {
		return rrp_smlb_50_loan_tot_prov;
	}
	public void setRrp_smlb_50_loan_tot_prov(BigDecimal rrp_smlb_50_loan_tot_prov) {
		this.rrp_smlb_50_loan_tot_prov = rrp_smlb_50_loan_tot_prov;
	}
	public BigDecimal getRrp_smlb_50_loan_int_sus() {
		return rrp_smlb_50_loan_int_sus;
	}
	public void setRrp_smlb_50_loan_int_sus(BigDecimal rrp_smlb_50_loan_int_sus) {
		this.rrp_smlb_50_loan_int_sus = rrp_smlb_50_loan_int_sus;
	}
	public BigDecimal getRrp_smlb_50_loan_crm() {
		return rrp_smlb_50_loan_crm;
	}
	public void setRrp_smlb_50_loan_crm(BigDecimal rrp_smlb_50_loan_crm) {
		this.rrp_smlb_50_loan_crm = rrp_smlb_50_loan_crm;
	}
	public BigDecimal getRrp_smlb_50_loan_tot_dra() {
		return rrp_smlb_50_loan_tot_dra;
	}
	public void setRrp_smlb_50_loan_tot_dra(BigDecimal rrp_smlb_50_loan_tot_dra) {
		this.rrp_smlb_50_loan_tot_dra = rrp_smlb_50_loan_tot_dra;
	}
	public BigDecimal getRrp_smlb_50_inves_bal() {
		return rrp_smlb_50_inves_bal;
	}
	public void setRrp_smlb_50_inves_bal(BigDecimal rrp_smlb_50_inves_bal) {
		this.rrp_smlb_50_inves_bal = rrp_smlb_50_inves_bal;
	}
	public BigDecimal getRrp_smlb_50_inves_prov() {
		return rrp_smlb_50_inves_prov;
	}
	public void setRrp_smlb_50_inves_prov(BigDecimal rrp_smlb_50_inves_prov) {
		this.rrp_smlb_50_inves_prov = rrp_smlb_50_inves_prov;
	}
	public BigDecimal getRrp_smlb_50_inves_crm() {
		return rrp_smlb_50_inves_crm;
	}
	public void setRrp_smlb_50_inves_crm(BigDecimal rrp_smlb_50_inves_crm) {
		this.rrp_smlb_50_inves_crm = rrp_smlb_50_inves_crm;
	}
	public BigDecimal getRrp_smlb_50_inves_rwa() {
		return rrp_smlb_50_inves_rwa;
	}
	public void setRrp_smlb_50_inves_rwa(BigDecimal rrp_smlb_50_inves_rwa) {
		this.rrp_smlb_50_inves_rwa = rrp_smlb_50_inves_rwa;
	}
	public BigDecimal getRrp_smlb_50_plac_bal() {
		return rrp_smlb_50_plac_bal;
	}
	public void setRrp_smlb_50_plac_bal(BigDecimal rrp_smlb_50_plac_bal) {
		this.rrp_smlb_50_plac_bal = rrp_smlb_50_plac_bal;
	}
	public BigDecimal getRrp_smlb_50_plac_prov() {
		return rrp_smlb_50_plac_prov;
	}
	public void setRrp_smlb_50_plac_prov(BigDecimal rrp_smlb_50_plac_prov) {
		this.rrp_smlb_50_plac_prov = rrp_smlb_50_plac_prov;
	}
	public BigDecimal getRrp_smlb_50_plac_crm() {
		return rrp_smlb_50_plac_crm;
	}
	public void setRrp_smlb_50_plac_crm(BigDecimal rrp_smlb_50_plac_crm) {
		this.rrp_smlb_50_plac_crm = rrp_smlb_50_plac_crm;
	}
	public BigDecimal getRrp_smlb_50_plac_rwa() {
		return rrp_smlb_50_plac_rwa;
	}
	public void setRrp_smlb_50_plac_rwa(BigDecimal rrp_smlb_50_plac_rwa) {
		this.rrp_smlb_50_plac_rwa = rrp_smlb_50_plac_rwa;
	}
	public BigDecimal getRrp_smlb_50_cash_bal() {
		return rrp_smlb_50_cash_bal;
	}
	public void setRrp_smlb_50_cash_bal(BigDecimal rrp_smlb_50_cash_bal) {
		this.rrp_smlb_50_cash_bal = rrp_smlb_50_cash_bal;
	}
	public BigDecimal getRrp_smlb_50_cash_prov() {
		return rrp_smlb_50_cash_prov;
	}
	public void setRrp_smlb_50_cash_prov(BigDecimal rrp_smlb_50_cash_prov) {
		this.rrp_smlb_50_cash_prov = rrp_smlb_50_cash_prov;
	}
	public BigDecimal getRrp_smlb_50_cash_crm() {
		return rrp_smlb_50_cash_crm;
	}
	public void setRrp_smlb_50_cash_crm(BigDecimal rrp_smlb_50_cash_crm) {
		this.rrp_smlb_50_cash_crm = rrp_smlb_50_cash_crm;
	}
	public BigDecimal getRrp_smlb_50_cash_rwa() {
		return rrp_smlb_50_cash_rwa;
	}
	public void setRrp_smlb_50_cash_rwa(BigDecimal rrp_smlb_50_cash_rwa) {
		this.rrp_smlb_50_cash_rwa = rrp_smlb_50_cash_rwa;
	}
	public BigDecimal getRrp_smlb_50_tot_bal() {
		return rrp_smlb_50_tot_bal;
	}
	public void setRrp_smlb_50_tot_bal(BigDecimal rrp_smlb_50_tot_bal) {
		this.rrp_smlb_50_tot_bal = rrp_smlb_50_tot_bal;
	}
	public BigDecimal getRrp_smlb_50_tot_prov() {
		return rrp_smlb_50_tot_prov;
	}
	public void setRrp_smlb_50_tot_prov(BigDecimal rrp_smlb_50_tot_prov) {
		this.rrp_smlb_50_tot_prov = rrp_smlb_50_tot_prov;
	}
	public BigDecimal getRrp_smlb_50_tot_int_sus() {
		return rrp_smlb_50_tot_int_sus;
	}
	public void setRrp_smlb_50_tot_int_sus(BigDecimal rrp_smlb_50_tot_int_sus) {
		this.rrp_smlb_50_tot_int_sus = rrp_smlb_50_tot_int_sus;
	}
	public BigDecimal getRrp_smlb_50_tot_crm() {
		return rrp_smlb_50_tot_crm;
	}
	public void setRrp_smlb_50_tot_crm(BigDecimal rrp_smlb_50_tot_crm) {
		this.rrp_smlb_50_tot_crm = rrp_smlb_50_tot_crm;
	}
	public BigDecimal getRrp_smlb_50_tot_rwa() {
		return rrp_smlb_50_tot_rwa;
	}
	public void setRrp_smlb_50_tot_rwa(BigDecimal rrp_smlb_50_tot_rwa) {
		this.rrp_smlb_50_tot_rwa = rrp_smlb_50_tot_rwa;
	}
	public BigDecimal getRrp_smlb_100_loan_bal() {
		return rrp_smlb_100_loan_bal;
	}
	public void setRrp_smlb_100_loan_bal(BigDecimal rrp_smlb_100_loan_bal) {
		this.rrp_smlb_100_loan_bal = rrp_smlb_100_loan_bal;
	}
	public BigDecimal getRrp_smlb_100_loan_bill_amt() {
		return rrp_smlb_100_loan_bill_amt;
	}
	public void setRrp_smlb_100_loan_bill_amt(BigDecimal rrp_smlb_100_loan_bill_amt) {
		this.rrp_smlb_100_loan_bill_amt = rrp_smlb_100_loan_bill_amt;
	}
	public BigDecimal getRrp_smlb_100_loan_tot_bal() {
		return rrp_smlb_100_loan_tot_bal;
	}
	public void setRrp_smlb_100_loan_tot_bal(BigDecimal rrp_smlb_100_loan_tot_bal) {
		this.rrp_smlb_100_loan_tot_bal = rrp_smlb_100_loan_tot_bal;
	}
	public BigDecimal getRrp_smlb_100_loan_tot_prov() {
		return rrp_smlb_100_loan_tot_prov;
	}
	public void setRrp_smlb_100_loan_tot_prov(BigDecimal rrp_smlb_100_loan_tot_prov) {
		this.rrp_smlb_100_loan_tot_prov = rrp_smlb_100_loan_tot_prov;
	}
	public BigDecimal getRrp_smlb_100_loan_int_sus() {
		return rrp_smlb_100_loan_int_sus;
	}
	public void setRrp_smlb_100_loan_int_sus(BigDecimal rrp_smlb_100_loan_int_sus) {
		this.rrp_smlb_100_loan_int_sus = rrp_smlb_100_loan_int_sus;
	}
	public BigDecimal getRrp_smlb_100_loan_crm() {
		return rrp_smlb_100_loan_crm;
	}
	public void setRrp_smlb_100_loan_crm(BigDecimal rrp_smlb_100_loan_crm) {
		this.rrp_smlb_100_loan_crm = rrp_smlb_100_loan_crm;
	}
	public BigDecimal getRrp_smlb_100_loan_tot_dra() {
		return rrp_smlb_100_loan_tot_dra;
	}
	public void setRrp_smlb_100_loan_tot_dra(BigDecimal rrp_smlb_100_loan_tot_dra) {
		this.rrp_smlb_100_loan_tot_dra = rrp_smlb_100_loan_tot_dra;
	}
	public BigDecimal getRrp_smlb_100_inves_bal() {
		return rrp_smlb_100_inves_bal;
	}
	public void setRrp_smlb_100_inves_bal(BigDecimal rrp_smlb_100_inves_bal) {
		this.rrp_smlb_100_inves_bal = rrp_smlb_100_inves_bal;
	}
	public BigDecimal getRrp_smlb_100_inves_prov() {
		return rrp_smlb_100_inves_prov;
	}
	public void setRrp_smlb_100_inves_prov(BigDecimal rrp_smlb_100_inves_prov) {
		this.rrp_smlb_100_inves_prov = rrp_smlb_100_inves_prov;
	}
	public BigDecimal getRrp_smlb_100_inves_crm() {
		return rrp_smlb_100_inves_crm;
	}
	public void setRrp_smlb_100_inves_crm(BigDecimal rrp_smlb_100_inves_crm) {
		this.rrp_smlb_100_inves_crm = rrp_smlb_100_inves_crm;
	}
	public BigDecimal getRrp_smlb_100_inves_rwa() {
		return rrp_smlb_100_inves_rwa;
	}
	public void setRrp_smlb_100_inves_rwa(BigDecimal rrp_smlb_100_inves_rwa) {
		this.rrp_smlb_100_inves_rwa = rrp_smlb_100_inves_rwa;
	}
	public BigDecimal getRrp_smlb_100_plac_bal() {
		return rrp_smlb_100_plac_bal;
	}
	public void setRrp_smlb_100_plac_bal(BigDecimal rrp_smlb_100_plac_bal) {
		this.rrp_smlb_100_plac_bal = rrp_smlb_100_plac_bal;
	}
	public BigDecimal getRrp_smlb_100_plac_prov() {
		return rrp_smlb_100_plac_prov;
	}
	public void setRrp_smlb_100_plac_prov(BigDecimal rrp_smlb_100_plac_prov) {
		this.rrp_smlb_100_plac_prov = rrp_smlb_100_plac_prov;
	}
	public BigDecimal getRrp_smlb_100_plac_crm() {
		return rrp_smlb_100_plac_crm;
	}
	public void setRrp_smlb_100_plac_crm(BigDecimal rrp_smlb_100_plac_crm) {
		this.rrp_smlb_100_plac_crm = rrp_smlb_100_plac_crm;
	}
	public BigDecimal getRrp_smlb_100_plac_rwa() {
		return rrp_smlb_100_plac_rwa;
	}
	public void setRrp_smlb_100_plac_rwa(BigDecimal rrp_smlb_100_plac_rwa) {
		this.rrp_smlb_100_plac_rwa = rrp_smlb_100_plac_rwa;
	}
	public BigDecimal getRrp_smlb_100_cash_bal() {
		return rrp_smlb_100_cash_bal;
	}
	public void setRrp_smlb_100_cash_bal(BigDecimal rrp_smlb_100_cash_bal) {
		this.rrp_smlb_100_cash_bal = rrp_smlb_100_cash_bal;
	}
	public BigDecimal getRrp_smlb_100_cash_prov() {
		return rrp_smlb_100_cash_prov;
	}
	public void setRrp_smlb_100_cash_prov(BigDecimal rrp_smlb_100_cash_prov) {
		this.rrp_smlb_100_cash_prov = rrp_smlb_100_cash_prov;
	}
	public BigDecimal getRrp_smlb_100_cash_crm() {
		return rrp_smlb_100_cash_crm;
	}
	public void setRrp_smlb_100_cash_crm(BigDecimal rrp_smlb_100_cash_crm) {
		this.rrp_smlb_100_cash_crm = rrp_smlb_100_cash_crm;
	}
	public BigDecimal getRrp_smlb_100_cash_rwa() {
		return rrp_smlb_100_cash_rwa;
	}
	public void setRrp_smlb_100_cash_rwa(BigDecimal rrp_smlb_100_cash_rwa) {
		this.rrp_smlb_100_cash_rwa = rrp_smlb_100_cash_rwa;
	}
	public BigDecimal getRrp_smlb_100_tot_bal() {
		return rrp_smlb_100_tot_bal;
	}
	public void setRrp_smlb_100_tot_bal(BigDecimal rrp_smlb_100_tot_bal) {
		this.rrp_smlb_100_tot_bal = rrp_smlb_100_tot_bal;
	}
	public BigDecimal getRrp_smlb_100_tot_prov() {
		return rrp_smlb_100_tot_prov;
	}
	public void setRrp_smlb_100_tot_prov(BigDecimal rrp_smlb_100_tot_prov) {
		this.rrp_smlb_100_tot_prov = rrp_smlb_100_tot_prov;
	}
	public BigDecimal getRrp_smlb_100_tot_int_sus() {
		return rrp_smlb_100_tot_int_sus;
	}
	public void setRrp_smlb_100_tot_int_sus(BigDecimal rrp_smlb_100_tot_int_sus) {
		this.rrp_smlb_100_tot_int_sus = rrp_smlb_100_tot_int_sus;
	}
	public BigDecimal getRrp_smlb_100_tot_crm() {
		return rrp_smlb_100_tot_crm;
	}
	public void setRrp_smlb_100_tot_crm(BigDecimal rrp_smlb_100_tot_crm) {
		this.rrp_smlb_100_tot_crm = rrp_smlb_100_tot_crm;
	}
	public BigDecimal getRrp_smlb_100_tot_rwa() {
		return rrp_smlb_100_tot_rwa;
	}
	public void setRrp_smlb_100_tot_rwa(BigDecimal rrp_smlb_100_tot_rwa) {
		this.rrp_smlb_100_tot_rwa = rrp_smlb_100_tot_rwa;
	}
	public BigDecimal getRrp_smlb_150_loan_bal() {
		return rrp_smlb_150_loan_bal;
	}
	public void setRrp_smlb_150_loan_bal(BigDecimal rrp_smlb_150_loan_bal) {
		this.rrp_smlb_150_loan_bal = rrp_smlb_150_loan_bal;
	}
	public BigDecimal getRrp_smlb_150_loan_bill_amt() {
		return rrp_smlb_150_loan_bill_amt;
	}
	public void setRrp_smlb_150_loan_bill_amt(BigDecimal rrp_smlb_150_loan_bill_amt) {
		this.rrp_smlb_150_loan_bill_amt = rrp_smlb_150_loan_bill_amt;
	}
	public BigDecimal getRrp_smlb_150_loan_tot_bal() {
		return rrp_smlb_150_loan_tot_bal;
	}
	public void setRrp_smlb_150_loan_tot_bal(BigDecimal rrp_smlb_150_loan_tot_bal) {
		this.rrp_smlb_150_loan_tot_bal = rrp_smlb_150_loan_tot_bal;
	}
	public BigDecimal getRrp_smlb_150_loan_tot_prov() {
		return rrp_smlb_150_loan_tot_prov;
	}
	public void setRrp_smlb_150_loan_tot_prov(BigDecimal rrp_smlb_150_loan_tot_prov) {
		this.rrp_smlb_150_loan_tot_prov = rrp_smlb_150_loan_tot_prov;
	}
	public BigDecimal getRrp_smlb_150_loan_int_sus() {
		return rrp_smlb_150_loan_int_sus;
	}
	public void setRrp_smlb_150_loan_int_sus(BigDecimal rrp_smlb_150_loan_int_sus) {
		this.rrp_smlb_150_loan_int_sus = rrp_smlb_150_loan_int_sus;
	}
	public BigDecimal getRrp_smlb_150_loan_crm() {
		return rrp_smlb_150_loan_crm;
	}
	public void setRrp_smlb_150_loan_crm(BigDecimal rrp_smlb_150_loan_crm) {
		this.rrp_smlb_150_loan_crm = rrp_smlb_150_loan_crm;
	}
	public BigDecimal getRrp_smlb_150_loan_tot_dra() {
		return rrp_smlb_150_loan_tot_dra;
	}
	public void setRrp_smlb_150_loan_tot_dra(BigDecimal rrp_smlb_150_loan_tot_dra) {
		this.rrp_smlb_150_loan_tot_dra = rrp_smlb_150_loan_tot_dra;
	}
	public BigDecimal getRrp_smlb_150_inves_bal() {
		return rrp_smlb_150_inves_bal;
	}
	public void setRrp_smlb_150_inves_bal(BigDecimal rrp_smlb_150_inves_bal) {
		this.rrp_smlb_150_inves_bal = rrp_smlb_150_inves_bal;
	}
	public BigDecimal getRrp_smlb_150_inves_prov() {
		return rrp_smlb_150_inves_prov;
	}
	public void setRrp_smlb_150_inves_prov(BigDecimal rrp_smlb_150_inves_prov) {
		this.rrp_smlb_150_inves_prov = rrp_smlb_150_inves_prov;
	}
	public BigDecimal getRrp_smlb_150_inves_crm() {
		return rrp_smlb_150_inves_crm;
	}
	public void setRrp_smlb_150_inves_crm(BigDecimal rrp_smlb_150_inves_crm) {
		this.rrp_smlb_150_inves_crm = rrp_smlb_150_inves_crm;
	}
	public BigDecimal getRrp_smlb_150_inves_rwa() {
		return rrp_smlb_150_inves_rwa;
	}
	public void setRrp_smlb_150_inves_rwa(BigDecimal rrp_smlb_150_inves_rwa) {
		this.rrp_smlb_150_inves_rwa = rrp_smlb_150_inves_rwa;
	}
	public BigDecimal getRrp_smlb_150_plac_bal() {
		return rrp_smlb_150_plac_bal;
	}
	public void setRrp_smlb_150_plac_bal(BigDecimal rrp_smlb_150_plac_bal) {
		this.rrp_smlb_150_plac_bal = rrp_smlb_150_plac_bal;
	}
	public BigDecimal getRrp_smlb_150_plac_prov() {
		return rrp_smlb_150_plac_prov;
	}
	public void setRrp_smlb_150_plac_prov(BigDecimal rrp_smlb_150_plac_prov) {
		this.rrp_smlb_150_plac_prov = rrp_smlb_150_plac_prov;
	}
	public BigDecimal getRrp_smlb_150_plac_crm() {
		return rrp_smlb_150_plac_crm;
	}
	public void setRrp_smlb_150_plac_crm(BigDecimal rrp_smlb_150_plac_crm) {
		this.rrp_smlb_150_plac_crm = rrp_smlb_150_plac_crm;
	}
	public BigDecimal getRrp_smlb_150_plac_rwa() {
		return rrp_smlb_150_plac_rwa;
	}
	public void setRrp_smlb_150_plac_rwa(BigDecimal rrp_smlb_150_plac_rwa) {
		this.rrp_smlb_150_plac_rwa = rrp_smlb_150_plac_rwa;
	}
	public BigDecimal getRrp_smlb_150_cash_bal() {
		return rrp_smlb_150_cash_bal;
	}
	public void setRrp_smlb_150_cash_bal(BigDecimal rrp_smlb_150_cash_bal) {
		this.rrp_smlb_150_cash_bal = rrp_smlb_150_cash_bal;
	}
	public BigDecimal getRrp_smlb_150_cash_prov() {
		return rrp_smlb_150_cash_prov;
	}
	public void setRrp_smlb_150_cash_prov(BigDecimal rrp_smlb_150_cash_prov) {
		this.rrp_smlb_150_cash_prov = rrp_smlb_150_cash_prov;
	}
	public BigDecimal getRrp_smlb_150_cash_crm() {
		return rrp_smlb_150_cash_crm;
	}
	public void setRrp_smlb_150_cash_crm(BigDecimal rrp_smlb_150_cash_crm) {
		this.rrp_smlb_150_cash_crm = rrp_smlb_150_cash_crm;
	}
	public BigDecimal getRrp_smlb_150_cash_rwa() {
		return rrp_smlb_150_cash_rwa;
	}
	public void setRrp_smlb_150_cash_rwa(BigDecimal rrp_smlb_150_cash_rwa) {
		this.rrp_smlb_150_cash_rwa = rrp_smlb_150_cash_rwa;
	}
	public BigDecimal getRrp_smlb_150_tot_bal() {
		return rrp_smlb_150_tot_bal;
	}
	public void setRrp_smlb_150_tot_bal(BigDecimal rrp_smlb_150_tot_bal) {
		this.rrp_smlb_150_tot_bal = rrp_smlb_150_tot_bal;
	}
	public BigDecimal getRrp_smlb_150_tot_prov() {
		return rrp_smlb_150_tot_prov;
	}
	public void setRrp_smlb_150_tot_prov(BigDecimal rrp_smlb_150_tot_prov) {
		this.rrp_smlb_150_tot_prov = rrp_smlb_150_tot_prov;
	}
	public BigDecimal getRrp_smlb_150_tot_int_sus() {
		return rrp_smlb_150_tot_int_sus;
	}
	public void setRrp_smlb_150_tot_int_sus(BigDecimal rrp_smlb_150_tot_int_sus) {
		this.rrp_smlb_150_tot_int_sus = rrp_smlb_150_tot_int_sus;
	}
	public BigDecimal getRrp_smlb_150_tot_crm() {
		return rrp_smlb_150_tot_crm;
	}
	public void setRrp_smlb_150_tot_crm(BigDecimal rrp_smlb_150_tot_crm) {
		this.rrp_smlb_150_tot_crm = rrp_smlb_150_tot_crm;
	}
	public BigDecimal getRrp_smlb_150_tot_rwa() {
		return rrp_smlb_150_tot_rwa;
	}
	public void setRrp_smlb_150_tot_rwa(BigDecimal rrp_smlb_150_tot_rwa) {
		this.rrp_smlb_150_tot_rwa = rrp_smlb_150_tot_rwa;
	}
	public BigDecimal getRrp_smlb2_0_loan_bal() {
		return rrp_smlb2_0_loan_bal;
	}
	public void setRrp_smlb2_0_loan_bal(BigDecimal rrp_smlb2_0_loan_bal) {
		this.rrp_smlb2_0_loan_bal = rrp_smlb2_0_loan_bal;
	}
	public BigDecimal getRrp_smlb2_0_loan_bill_amt() {
		return rrp_smlb2_0_loan_bill_amt;
	}
	public void setRrp_smlb2_0_loan_bill_amt(BigDecimal rrp_smlb2_0_loan_bill_amt) {
		this.rrp_smlb2_0_loan_bill_amt = rrp_smlb2_0_loan_bill_amt;
	}
	public BigDecimal getRrp_smlb2_0_loan_tot_bal() {
		return rrp_smlb2_0_loan_tot_bal;
	}
	public void setRrp_smlb2_0_loan_tot_bal(BigDecimal rrp_smlb2_0_loan_tot_bal) {
		this.rrp_smlb2_0_loan_tot_bal = rrp_smlb2_0_loan_tot_bal;
	}
	public BigDecimal getRrp_smlb2_0_loan_tot_prov() {
		return rrp_smlb2_0_loan_tot_prov;
	}
	public void setRrp_smlb2_0_loan_tot_prov(BigDecimal rrp_smlb2_0_loan_tot_prov) {
		this.rrp_smlb2_0_loan_tot_prov = rrp_smlb2_0_loan_tot_prov;
	}
	public BigDecimal getRrp_smlb2_0_loan_int_sus() {
		return rrp_smlb2_0_loan_int_sus;
	}
	public void setRrp_smlb2_0_loan_int_sus(BigDecimal rrp_smlb2_0_loan_int_sus) {
		this.rrp_smlb2_0_loan_int_sus = rrp_smlb2_0_loan_int_sus;
	}
	public BigDecimal getRrp_smlb2_0_loan_crm() {
		return rrp_smlb2_0_loan_crm;
	}
	public void setRrp_smlb2_0_loan_crm(BigDecimal rrp_smlb2_0_loan_crm) {
		this.rrp_smlb2_0_loan_crm = rrp_smlb2_0_loan_crm;
	}
	public BigDecimal getRrp_smlb2_0_loan_tot_dra() {
		return rrp_smlb2_0_loan_tot_dra;
	}
	public void setRrp_smlb2_0_loan_tot_dra(BigDecimal rrp_smlb2_0_loan_tot_dra) {
		this.rrp_smlb2_0_loan_tot_dra = rrp_smlb2_0_loan_tot_dra;
	}
	public BigDecimal getRrp_smlb2_0_inves_bal() {
		return rrp_smlb2_0_inves_bal;
	}
	public void setRrp_smlb2_0_inves_bal(BigDecimal rrp_smlb2_0_inves_bal) {
		this.rrp_smlb2_0_inves_bal = rrp_smlb2_0_inves_bal;
	}
	public BigDecimal getRrp_smlb2_0_inves_prov() {
		return rrp_smlb2_0_inves_prov;
	}
	public void setRrp_smlb2_0_inves_prov(BigDecimal rrp_smlb2_0_inves_prov) {
		this.rrp_smlb2_0_inves_prov = rrp_smlb2_0_inves_prov;
	}
	public BigDecimal getRrp_smlb2_0_inves_crm() {
		return rrp_smlb2_0_inves_crm;
	}
	public void setRrp_smlb2_0_inves_crm(BigDecimal rrp_smlb2_0_inves_crm) {
		this.rrp_smlb2_0_inves_crm = rrp_smlb2_0_inves_crm;
	}
	public BigDecimal getRrp_smlb2_0_inves_rwa() {
		return rrp_smlb2_0_inves_rwa;
	}
	public void setRrp_smlb2_0_inves_rwa(BigDecimal rrp_smlb2_0_inves_rwa) {
		this.rrp_smlb2_0_inves_rwa = rrp_smlb2_0_inves_rwa;
	}
	public BigDecimal getRrp_smlb2_0_plac_bal() {
		return rrp_smlb2_0_plac_bal;
	}
	public void setRrp_smlb2_0_plac_bal(BigDecimal rrp_smlb2_0_plac_bal) {
		this.rrp_smlb2_0_plac_bal = rrp_smlb2_0_plac_bal;
	}
	public BigDecimal getRrp_smlb2_0_plac_prov() {
		return rrp_smlb2_0_plac_prov;
	}
	public void setRrp_smlb2_0_plac_prov(BigDecimal rrp_smlb2_0_plac_prov) {
		this.rrp_smlb2_0_plac_prov = rrp_smlb2_0_plac_prov;
	}
	public BigDecimal getRrp_smlb2_0_plac_crm() {
		return rrp_smlb2_0_plac_crm;
	}
	public void setRrp_smlb2_0_plac_crm(BigDecimal rrp_smlb2_0_plac_crm) {
		this.rrp_smlb2_0_plac_crm = rrp_smlb2_0_plac_crm;
	}
	public BigDecimal getRrp_smlb2_0_plac_rwa() {
		return rrp_smlb2_0_plac_rwa;
	}
	public void setRrp_smlb2_0_plac_rwa(BigDecimal rrp_smlb2_0_plac_rwa) {
		this.rrp_smlb2_0_plac_rwa = rrp_smlb2_0_plac_rwa;
	}
	public BigDecimal getRrp_smlb2_0_cash_bal() {
		return rrp_smlb2_0_cash_bal;
	}
	public void setRrp_smlb2_0_cash_bal(BigDecimal rrp_smlb2_0_cash_bal) {
		this.rrp_smlb2_0_cash_bal = rrp_smlb2_0_cash_bal;
	}
	public BigDecimal getRrp_smlb2_0_cash_prov() {
		return rrp_smlb2_0_cash_prov;
	}
	public void setRrp_smlb2_0_cash_prov(BigDecimal rrp_smlb2_0_cash_prov) {
		this.rrp_smlb2_0_cash_prov = rrp_smlb2_0_cash_prov;
	}
	public BigDecimal getRrp_smlb2_0_cash_crm() {
		return rrp_smlb2_0_cash_crm;
	}
	public void setRrp_smlb2_0_cash_crm(BigDecimal rrp_smlb2_0_cash_crm) {
		this.rrp_smlb2_0_cash_crm = rrp_smlb2_0_cash_crm;
	}
	public BigDecimal getRrp_smlb2_0_cash_rwa() {
		return rrp_smlb2_0_cash_rwa;
	}
	public void setRrp_smlb2_0_cash_rwa(BigDecimal rrp_smlb2_0_cash_rwa) {
		this.rrp_smlb2_0_cash_rwa = rrp_smlb2_0_cash_rwa;
	}
	public BigDecimal getRrp_smlb2_0_tot_bal() {
		return rrp_smlb2_0_tot_bal;
	}
	public void setRrp_smlb2_0_tot_bal(BigDecimal rrp_smlb2_0_tot_bal) {
		this.rrp_smlb2_0_tot_bal = rrp_smlb2_0_tot_bal;
	}
	public BigDecimal getRrp_smlb2_0_tot_prov() {
		return rrp_smlb2_0_tot_prov;
	}
	public void setRrp_smlb2_0_tot_prov(BigDecimal rrp_smlb2_0_tot_prov) {
		this.rrp_smlb2_0_tot_prov = rrp_smlb2_0_tot_prov;
	}
	public BigDecimal getRrp_smlb2_0_tot_int_sus() {
		return rrp_smlb2_0_tot_int_sus;
	}
	public void setRrp_smlb2_0_tot_int_sus(BigDecimal rrp_smlb2_0_tot_int_sus) {
		this.rrp_smlb2_0_tot_int_sus = rrp_smlb2_0_tot_int_sus;
	}
	public BigDecimal getRrp_smlb2_0_tot_crm() {
		return rrp_smlb2_0_tot_crm;
	}
	public void setRrp_smlb2_0_tot_crm(BigDecimal rrp_smlb2_0_tot_crm) {
		this.rrp_smlb2_0_tot_crm = rrp_smlb2_0_tot_crm;
	}
	public BigDecimal getRrp_smlb2_0_tot_rwa() {
		return rrp_smlb2_0_tot_rwa;
	}
	public void setRrp_smlb2_0_tot_rwa(BigDecimal rrp_smlb2_0_tot_rwa) {
		this.rrp_smlb2_0_tot_rwa = rrp_smlb2_0_tot_rwa;
	}
	public BigDecimal getRrp_smlb2_20_loan_bal() {
		return rrp_smlb2_20_loan_bal;
	}
	public void setRrp_smlb2_20_loan_bal(BigDecimal rrp_smlb2_20_loan_bal) {
		this.rrp_smlb2_20_loan_bal = rrp_smlb2_20_loan_bal;
	}
	public BigDecimal getRrp_smlb2_20_loan_bill_amt() {
		return rrp_smlb2_20_loan_bill_amt;
	}
	public void setRrp_smlb2_20_loan_bill_amt(BigDecimal rrp_smlb2_20_loan_bill_amt) {
		this.rrp_smlb2_20_loan_bill_amt = rrp_smlb2_20_loan_bill_amt;
	}
	public BigDecimal getRrp_smlb2_20_loan_tot_bal() {
		return rrp_smlb2_20_loan_tot_bal;
	}
	public void setRrp_smlb2_20_loan_tot_bal(BigDecimal rrp_smlb2_20_loan_tot_bal) {
		this.rrp_smlb2_20_loan_tot_bal = rrp_smlb2_20_loan_tot_bal;
	}
	public BigDecimal getRrp_smlb2_20_loan_tot_prov() {
		return rrp_smlb2_20_loan_tot_prov;
	}
	public void setRrp_smlb2_20_loan_tot_prov(BigDecimal rrp_smlb2_20_loan_tot_prov) {
		this.rrp_smlb2_20_loan_tot_prov = rrp_smlb2_20_loan_tot_prov;
	}
	public BigDecimal getRrp_smlb2_20_loan_int_sus() {
		return rrp_smlb2_20_loan_int_sus;
	}
	public void setRrp_smlb2_20_loan_int_sus(BigDecimal rrp_smlb2_20_loan_int_sus) {
		this.rrp_smlb2_20_loan_int_sus = rrp_smlb2_20_loan_int_sus;
	}
	public BigDecimal getRrp_smlb2_20_loan_crm() {
		return rrp_smlb2_20_loan_crm;
	}
	public void setRrp_smlb2_20_loan_crm(BigDecimal rrp_smlb2_20_loan_crm) {
		this.rrp_smlb2_20_loan_crm = rrp_smlb2_20_loan_crm;
	}
	public BigDecimal getRrp_smlb2_20_loan_tot_dra() {
		return rrp_smlb2_20_loan_tot_dra;
	}
	public void setRrp_smlb2_20_loan_tot_dra(BigDecimal rrp_smlb2_20_loan_tot_dra) {
		this.rrp_smlb2_20_loan_tot_dra = rrp_smlb2_20_loan_tot_dra;
	}
	public BigDecimal getRrp_smlb2_20_inves_bal() {
		return rrp_smlb2_20_inves_bal;
	}
	public void setRrp_smlb2_20_inves_bal(BigDecimal rrp_smlb2_20_inves_bal) {
		this.rrp_smlb2_20_inves_bal = rrp_smlb2_20_inves_bal;
	}
	public BigDecimal getRrp_smlb2_20_inves_prov() {
		return rrp_smlb2_20_inves_prov;
	}
	public void setRrp_smlb2_20_inves_prov(BigDecimal rrp_smlb2_20_inves_prov) {
		this.rrp_smlb2_20_inves_prov = rrp_smlb2_20_inves_prov;
	}
	public BigDecimal getRrp_smlb2_20_inves_crm() {
		return rrp_smlb2_20_inves_crm;
	}
	public void setRrp_smlb2_20_inves_crm(BigDecimal rrp_smlb2_20_inves_crm) {
		this.rrp_smlb2_20_inves_crm = rrp_smlb2_20_inves_crm;
	}
	public BigDecimal getRrp_smlb2_20_inves_rwa() {
		return rrp_smlb2_20_inves_rwa;
	}
	public void setRrp_smlb2_20_inves_rwa(BigDecimal rrp_smlb2_20_inves_rwa) {
		this.rrp_smlb2_20_inves_rwa = rrp_smlb2_20_inves_rwa;
	}
	public BigDecimal getRrp_smlb2_20_plac_bal() {
		return rrp_smlb2_20_plac_bal;
	}
	public void setRrp_smlb2_20_plac_bal(BigDecimal rrp_smlb2_20_plac_bal) {
		this.rrp_smlb2_20_plac_bal = rrp_smlb2_20_plac_bal;
	}
	public BigDecimal getRrp_smlb2_20_plac_prov() {
		return rrp_smlb2_20_plac_prov;
	}
	public void setRrp_smlb2_20_plac_prov(BigDecimal rrp_smlb2_20_plac_prov) {
		this.rrp_smlb2_20_plac_prov = rrp_smlb2_20_plac_prov;
	}
	public BigDecimal getRrp_smlb2_20_plac_crm() {
		return rrp_smlb2_20_plac_crm;
	}
	public void setRrp_smlb2_20_plac_crm(BigDecimal rrp_smlb2_20_plac_crm) {
		this.rrp_smlb2_20_plac_crm = rrp_smlb2_20_plac_crm;
	}
	public BigDecimal getRrp_smlb2_20_plac_rwa() {
		return rrp_smlb2_20_plac_rwa;
	}
	public void setRrp_smlb2_20_plac_rwa(BigDecimal rrp_smlb2_20_plac_rwa) {
		this.rrp_smlb2_20_plac_rwa = rrp_smlb2_20_plac_rwa;
	}
	public BigDecimal getRrp_smlb2_20_cash_bal() {
		return rrp_smlb2_20_cash_bal;
	}
	public void setRrp_smlb2_20_cash_bal(BigDecimal rrp_smlb2_20_cash_bal) {
		this.rrp_smlb2_20_cash_bal = rrp_smlb2_20_cash_bal;
	}
	public BigDecimal getRrp_smlb2_20_cash_prov() {
		return rrp_smlb2_20_cash_prov;
	}
	public void setRrp_smlb2_20_cash_prov(BigDecimal rrp_smlb2_20_cash_prov) {
		this.rrp_smlb2_20_cash_prov = rrp_smlb2_20_cash_prov;
	}
	public BigDecimal getRrp_smlb2_20_cash_crm() {
		return rrp_smlb2_20_cash_crm;
	}
	public void setRrp_smlb2_20_cash_crm(BigDecimal rrp_smlb2_20_cash_crm) {
		this.rrp_smlb2_20_cash_crm = rrp_smlb2_20_cash_crm;
	}
	public BigDecimal getRrp_smlb2_20_cash_rwa() {
		return rrp_smlb2_20_cash_rwa;
	}
	public void setRrp_smlb2_20_cash_rwa(BigDecimal rrp_smlb2_20_cash_rwa) {
		this.rrp_smlb2_20_cash_rwa = rrp_smlb2_20_cash_rwa;
	}
	public BigDecimal getRrp_smlb2_20_tot_bal() {
		return rrp_smlb2_20_tot_bal;
	}
	public void setRrp_smlb2_20_tot_bal(BigDecimal rrp_smlb2_20_tot_bal) {
		this.rrp_smlb2_20_tot_bal = rrp_smlb2_20_tot_bal;
	}
	public BigDecimal getRrp_smlb2_20_tot_prov() {
		return rrp_smlb2_20_tot_prov;
	}
	public void setRrp_smlb2_20_tot_prov(BigDecimal rrp_smlb2_20_tot_prov) {
		this.rrp_smlb2_20_tot_prov = rrp_smlb2_20_tot_prov;
	}
	public BigDecimal getRrp_smlb2_20_tot_int_sus() {
		return rrp_smlb2_20_tot_int_sus;
	}
	public void setRrp_smlb2_20_tot_int_sus(BigDecimal rrp_smlb2_20_tot_int_sus) {
		this.rrp_smlb2_20_tot_int_sus = rrp_smlb2_20_tot_int_sus;
	}
	public BigDecimal getRrp_smlb2_20_tot_crm() {
		return rrp_smlb2_20_tot_crm;
	}
	public void setRrp_smlb2_20_tot_crm(BigDecimal rrp_smlb2_20_tot_crm) {
		this.rrp_smlb2_20_tot_crm = rrp_smlb2_20_tot_crm;
	}
	public BigDecimal getRrp_smlb2_20_tot_rwa() {
		return rrp_smlb2_20_tot_rwa;
	}
	public void setRrp_smlb2_20_tot_rwa(BigDecimal rrp_smlb2_20_tot_rwa) {
		this.rrp_smlb2_20_tot_rwa = rrp_smlb2_20_tot_rwa;
	}
	public BigDecimal getRrp_smlb2_50_loan_bal() {
		return rrp_smlb2_50_loan_bal;
	}
	public void setRrp_smlb2_50_loan_bal(BigDecimal rrp_smlb2_50_loan_bal) {
		this.rrp_smlb2_50_loan_bal = rrp_smlb2_50_loan_bal;
	}
	public BigDecimal getRrp_smlb2_50_loan_bill_amt() {
		return rrp_smlb2_50_loan_bill_amt;
	}
	public void setRrp_smlb2_50_loan_bill_amt(BigDecimal rrp_smlb2_50_loan_bill_amt) {
		this.rrp_smlb2_50_loan_bill_amt = rrp_smlb2_50_loan_bill_amt;
	}
	public BigDecimal getRrp_smlb2_50_loan_tot_bal() {
		return rrp_smlb2_50_loan_tot_bal;
	}
	public void setRrp_smlb2_50_loan_tot_bal(BigDecimal rrp_smlb2_50_loan_tot_bal) {
		this.rrp_smlb2_50_loan_tot_bal = rrp_smlb2_50_loan_tot_bal;
	}
	public BigDecimal getRrp_smlb2_50_loan_tot_prov() {
		return rrp_smlb2_50_loan_tot_prov;
	}
	public void setRrp_smlb2_50_loan_tot_prov(BigDecimal rrp_smlb2_50_loan_tot_prov) {
		this.rrp_smlb2_50_loan_tot_prov = rrp_smlb2_50_loan_tot_prov;
	}
	public BigDecimal getRrp_smlb2_50_loan_int_sus() {
		return rrp_smlb2_50_loan_int_sus;
	}
	public void setRrp_smlb2_50_loan_int_sus(BigDecimal rrp_smlb2_50_loan_int_sus) {
		this.rrp_smlb2_50_loan_int_sus = rrp_smlb2_50_loan_int_sus;
	}
	public BigDecimal getRrp_smlb2_50_loan_crm() {
		return rrp_smlb2_50_loan_crm;
	}
	public void setRrp_smlb2_50_loan_crm(BigDecimal rrp_smlb2_50_loan_crm) {
		this.rrp_smlb2_50_loan_crm = rrp_smlb2_50_loan_crm;
	}
	public BigDecimal getRrp_smlb2_50_loan_tot_dra() {
		return rrp_smlb2_50_loan_tot_dra;
	}
	public void setRrp_smlb2_50_loan_tot_dra(BigDecimal rrp_smlb2_50_loan_tot_dra) {
		this.rrp_smlb2_50_loan_tot_dra = rrp_smlb2_50_loan_tot_dra;
	}
	public BigDecimal getRrp_smlb2_50_inves_bal() {
		return rrp_smlb2_50_inves_bal;
	}
	public void setRrp_smlb2_50_inves_bal(BigDecimal rrp_smlb2_50_inves_bal) {
		this.rrp_smlb2_50_inves_bal = rrp_smlb2_50_inves_bal;
	}
	public BigDecimal getRrp_smlb2_50_inves_prov() {
		return rrp_smlb2_50_inves_prov;
	}
	public void setRrp_smlb2_50_inves_prov(BigDecimal rrp_smlb2_50_inves_prov) {
		this.rrp_smlb2_50_inves_prov = rrp_smlb2_50_inves_prov;
	}
	public BigDecimal getRrp_smlb2_50_inves_crm() {
		return rrp_smlb2_50_inves_crm;
	}
	public void setRrp_smlb2_50_inves_crm(BigDecimal rrp_smlb2_50_inves_crm) {
		this.rrp_smlb2_50_inves_crm = rrp_smlb2_50_inves_crm;
	}
	public BigDecimal getRrp_smlb2_50_inves_rwa() {
		return rrp_smlb2_50_inves_rwa;
	}
	public void setRrp_smlb2_50_inves_rwa(BigDecimal rrp_smlb2_50_inves_rwa) {
		this.rrp_smlb2_50_inves_rwa = rrp_smlb2_50_inves_rwa;
	}
	public BigDecimal getRrp_smlb2_50_plac_bal() {
		return rrp_smlb2_50_plac_bal;
	}
	public void setRrp_smlb2_50_plac_bal(BigDecimal rrp_smlb2_50_plac_bal) {
		this.rrp_smlb2_50_plac_bal = rrp_smlb2_50_plac_bal;
	}
	public BigDecimal getRrp_smlb2_50_plac_prov() {
		return rrp_smlb2_50_plac_prov;
	}
	public void setRrp_smlb2_50_plac_prov(BigDecimal rrp_smlb2_50_plac_prov) {
		this.rrp_smlb2_50_plac_prov = rrp_smlb2_50_plac_prov;
	}
	public BigDecimal getRrp_smlb2_50_plac_crm() {
		return rrp_smlb2_50_plac_crm;
	}
	public void setRrp_smlb2_50_plac_crm(BigDecimal rrp_smlb2_50_plac_crm) {
		this.rrp_smlb2_50_plac_crm = rrp_smlb2_50_plac_crm;
	}
	public BigDecimal getRrp_smlb2_50_plac_rwa() {
		return rrp_smlb2_50_plac_rwa;
	}
	public void setRrp_smlb2_50_plac_rwa(BigDecimal rrp_smlb2_50_plac_rwa) {
		this.rrp_smlb2_50_plac_rwa = rrp_smlb2_50_plac_rwa;
	}
	public BigDecimal getRrp_smlb2_50_cash_bal() {
		return rrp_smlb2_50_cash_bal;
	}
	public void setRrp_smlb2_50_cash_bal(BigDecimal rrp_smlb2_50_cash_bal) {
		this.rrp_smlb2_50_cash_bal = rrp_smlb2_50_cash_bal;
	}
	public BigDecimal getRrp_smlb2_50_cash_prov() {
		return rrp_smlb2_50_cash_prov;
	}
	public void setRrp_smlb2_50_cash_prov(BigDecimal rrp_smlb2_50_cash_prov) {
		this.rrp_smlb2_50_cash_prov = rrp_smlb2_50_cash_prov;
	}
	public BigDecimal getRrp_smlb2_50_cash_crm() {
		return rrp_smlb2_50_cash_crm;
	}
	public void setRrp_smlb2_50_cash_crm(BigDecimal rrp_smlb2_50_cash_crm) {
		this.rrp_smlb2_50_cash_crm = rrp_smlb2_50_cash_crm;
	}
	public BigDecimal getRrp_smlb2_50_cash_rwa() {
		return rrp_smlb2_50_cash_rwa;
	}
	public void setRrp_smlb2_50_cash_rwa(BigDecimal rrp_smlb2_50_cash_rwa) {
		this.rrp_smlb2_50_cash_rwa = rrp_smlb2_50_cash_rwa;
	}
	public BigDecimal getRrp_smlb2_50_tot_bal() {
		return rrp_smlb2_50_tot_bal;
	}
	public void setRrp_smlb2_50_tot_bal(BigDecimal rrp_smlb2_50_tot_bal) {
		this.rrp_smlb2_50_tot_bal = rrp_smlb2_50_tot_bal;
	}
	public BigDecimal getRrp_smlb2_50_tot_prov() {
		return rrp_smlb2_50_tot_prov;
	}
	public void setRrp_smlb2_50_tot_prov(BigDecimal rrp_smlb2_50_tot_prov) {
		this.rrp_smlb2_50_tot_prov = rrp_smlb2_50_tot_prov;
	}
	public BigDecimal getRrp_smlb2_50_tot_int_sus() {
		return rrp_smlb2_50_tot_int_sus;
	}
	public void setRrp_smlb2_50_tot_int_sus(BigDecimal rrp_smlb2_50_tot_int_sus) {
		this.rrp_smlb2_50_tot_int_sus = rrp_smlb2_50_tot_int_sus;
	}
	public BigDecimal getRrp_smlb2_50_tot_crm() {
		return rrp_smlb2_50_tot_crm;
	}
	public void setRrp_smlb2_50_tot_crm(BigDecimal rrp_smlb2_50_tot_crm) {
		this.rrp_smlb2_50_tot_crm = rrp_smlb2_50_tot_crm;
	}
	public BigDecimal getRrp_smlb2_50_tot_rwa() {
		return rrp_smlb2_50_tot_rwa;
	}
	public void setRrp_smlb2_50_tot_rwa(BigDecimal rrp_smlb2_50_tot_rwa) {
		this.rrp_smlb2_50_tot_rwa = rrp_smlb2_50_tot_rwa;
	}
	public BigDecimal getRrp_smlb2_100_loan_bal() {
		return rrp_smlb2_100_loan_bal;
	}
	public void setRrp_smlb2_100_loan_bal(BigDecimal rrp_smlb2_100_loan_bal) {
		this.rrp_smlb2_100_loan_bal = rrp_smlb2_100_loan_bal;
	}
	public BigDecimal getRrp_smlb2_100_loan_bill_amt() {
		return rrp_smlb2_100_loan_bill_amt;
	}
	public void setRrp_smlb2_100_loan_bill_amt(BigDecimal rrp_smlb2_100_loan_bill_amt) {
		this.rrp_smlb2_100_loan_bill_amt = rrp_smlb2_100_loan_bill_amt;
	}
	public BigDecimal getRrp_smlb2_100_loan_tot_bal() {
		return rrp_smlb2_100_loan_tot_bal;
	}
	public void setRrp_smlb2_100_loan_tot_bal(BigDecimal rrp_smlb2_100_loan_tot_bal) {
		this.rrp_smlb2_100_loan_tot_bal = rrp_smlb2_100_loan_tot_bal;
	}
	public BigDecimal getRrp_smlb2_100_loan_tot_prov() {
		return rrp_smlb2_100_loan_tot_prov;
	}
	public void setRrp_smlb2_100_loan_tot_prov(BigDecimal rrp_smlb2_100_loan_tot_prov) {
		this.rrp_smlb2_100_loan_tot_prov = rrp_smlb2_100_loan_tot_prov;
	}
	public BigDecimal getRrp_smlb2_100_loan_int_sus() {
		return rrp_smlb2_100_loan_int_sus;
	}
	public void setRrp_smlb2_100_loan_int_sus(BigDecimal rrp_smlb2_100_loan_int_sus) {
		this.rrp_smlb2_100_loan_int_sus = rrp_smlb2_100_loan_int_sus;
	}
	public BigDecimal getRrp_smlb2_100_loan_crm() {
		return rrp_smlb2_100_loan_crm;
	}
	public void setRrp_smlb2_100_loan_crm(BigDecimal rrp_smlb2_100_loan_crm) {
		this.rrp_smlb2_100_loan_crm = rrp_smlb2_100_loan_crm;
	}
	public BigDecimal getRrp_smlb2_100_loan_tot_dra() {
		return rrp_smlb2_100_loan_tot_dra;
	}
	public void setRrp_smlb2_100_loan_tot_dra(BigDecimal rrp_smlb2_100_loan_tot_dra) {
		this.rrp_smlb2_100_loan_tot_dra = rrp_smlb2_100_loan_tot_dra;
	}
	public BigDecimal getRrp_smlb2_100_inves_bal() {
		return rrp_smlb2_100_inves_bal;
	}
	public void setRrp_smlb2_100_inves_bal(BigDecimal rrp_smlb2_100_inves_bal) {
		this.rrp_smlb2_100_inves_bal = rrp_smlb2_100_inves_bal;
	}
	public BigDecimal getRrp_smlb2_100_inves_prov() {
		return rrp_smlb2_100_inves_prov;
	}
	public void setRrp_smlb2_100_inves_prov(BigDecimal rrp_smlb2_100_inves_prov) {
		this.rrp_smlb2_100_inves_prov = rrp_smlb2_100_inves_prov;
	}
	public BigDecimal getRrp_smlb2_100_inves_crm() {
		return rrp_smlb2_100_inves_crm;
	}
	public void setRrp_smlb2_100_inves_crm(BigDecimal rrp_smlb2_100_inves_crm) {
		this.rrp_smlb2_100_inves_crm = rrp_smlb2_100_inves_crm;
	}
	public BigDecimal getRrp_smlb2_100_inves_rwa() {
		return rrp_smlb2_100_inves_rwa;
	}
	public void setRrp_smlb2_100_inves_rwa(BigDecimal rrp_smlb2_100_inves_rwa) {
		this.rrp_smlb2_100_inves_rwa = rrp_smlb2_100_inves_rwa;
	}
	public BigDecimal getRrp_smlb2_100_plac_bal() {
		return rrp_smlb2_100_plac_bal;
	}
	public void setRrp_smlb2_100_plac_bal(BigDecimal rrp_smlb2_100_plac_bal) {
		this.rrp_smlb2_100_plac_bal = rrp_smlb2_100_plac_bal;
	}
	public BigDecimal getRrp_smlb2_100_plac_prov() {
		return rrp_smlb2_100_plac_prov;
	}
	public void setRrp_smlb2_100_plac_prov(BigDecimal rrp_smlb2_100_plac_prov) {
		this.rrp_smlb2_100_plac_prov = rrp_smlb2_100_plac_prov;
	}
	public BigDecimal getRrp_smlb2_100_plac_crm() {
		return rrp_smlb2_100_plac_crm;
	}
	public void setRrp_smlb2_100_plac_crm(BigDecimal rrp_smlb2_100_plac_crm) {
		this.rrp_smlb2_100_plac_crm = rrp_smlb2_100_plac_crm;
	}
	public BigDecimal getRrp_smlb2_100_plac_rwa() {
		return rrp_smlb2_100_plac_rwa;
	}
	public void setRrp_smlb2_100_plac_rwa(BigDecimal rrp_smlb2_100_plac_rwa) {
		this.rrp_smlb2_100_plac_rwa = rrp_smlb2_100_plac_rwa;
	}
	public BigDecimal getRrp_smlb2_100_cash_bal() {
		return rrp_smlb2_100_cash_bal;
	}
	public void setRrp_smlb2_100_cash_bal(BigDecimal rrp_smlb2_100_cash_bal) {
		this.rrp_smlb2_100_cash_bal = rrp_smlb2_100_cash_bal;
	}
	public BigDecimal getRrp_smlb2_100_cash_prov() {
		return rrp_smlb2_100_cash_prov;
	}
	public void setRrp_smlb2_100_cash_prov(BigDecimal rrp_smlb2_100_cash_prov) {
		this.rrp_smlb2_100_cash_prov = rrp_smlb2_100_cash_prov;
	}
	public BigDecimal getRrp_smlb2_100_cash_crm() {
		return rrp_smlb2_100_cash_crm;
	}
	public void setRrp_smlb2_100_cash_crm(BigDecimal rrp_smlb2_100_cash_crm) {
		this.rrp_smlb2_100_cash_crm = rrp_smlb2_100_cash_crm;
	}
	public BigDecimal getRrp_smlb2_100_cash_rwa() {
		return rrp_smlb2_100_cash_rwa;
	}
	public void setRrp_smlb2_100_cash_rwa(BigDecimal rrp_smlb2_100_cash_rwa) {
		this.rrp_smlb2_100_cash_rwa = rrp_smlb2_100_cash_rwa;
	}
	public BigDecimal getRrp_smlb2_100_tot_bal() {
		return rrp_smlb2_100_tot_bal;
	}
	public void setRrp_smlb2_100_tot_bal(BigDecimal rrp_smlb2_100_tot_bal) {
		this.rrp_smlb2_100_tot_bal = rrp_smlb2_100_tot_bal;
	}
	public BigDecimal getRrp_smlb2_100_tot_prov() {
		return rrp_smlb2_100_tot_prov;
	}
	public void setRrp_smlb2_100_tot_prov(BigDecimal rrp_smlb2_100_tot_prov) {
		this.rrp_smlb2_100_tot_prov = rrp_smlb2_100_tot_prov;
	}
	public BigDecimal getRrp_smlb2_100_tot_int_sus() {
		return rrp_smlb2_100_tot_int_sus;
	}
	public void setRrp_smlb2_100_tot_int_sus(BigDecimal rrp_smlb2_100_tot_int_sus) {
		this.rrp_smlb2_100_tot_int_sus = rrp_smlb2_100_tot_int_sus;
	}
	public BigDecimal getRrp_smlb2_100_tot_crm() {
		return rrp_smlb2_100_tot_crm;
	}
	public void setRrp_smlb2_100_tot_crm(BigDecimal rrp_smlb2_100_tot_crm) {
		this.rrp_smlb2_100_tot_crm = rrp_smlb2_100_tot_crm;
	}
	public BigDecimal getRrp_smlb2_100_tot_rwa() {
		return rrp_smlb2_100_tot_rwa;
	}
	public void setRrp_smlb2_100_tot_rwa(BigDecimal rrp_smlb2_100_tot_rwa) {
		this.rrp_smlb2_100_tot_rwa = rrp_smlb2_100_tot_rwa;
	}
	public BigDecimal getRrp_smlb2_150_loan_bal() {
		return rrp_smlb2_150_loan_bal;
	}
	public void setRrp_smlb2_150_loan_bal(BigDecimal rrp_smlb2_150_loan_bal) {
		this.rrp_smlb2_150_loan_bal = rrp_smlb2_150_loan_bal;
	}
	public BigDecimal getRrp_smlb2_150_loan_bill_amt() {
		return rrp_smlb2_150_loan_bill_amt;
	}
	public void setRrp_smlb2_150_loan_bill_amt(BigDecimal rrp_smlb2_150_loan_bill_amt) {
		this.rrp_smlb2_150_loan_bill_amt = rrp_smlb2_150_loan_bill_amt;
	}
	public BigDecimal getRrp_smlb2_150_loan_tot_bal() {
		return rrp_smlb2_150_loan_tot_bal;
	}
	public void setRrp_smlb2_150_loan_tot_bal(BigDecimal rrp_smlb2_150_loan_tot_bal) {
		this.rrp_smlb2_150_loan_tot_bal = rrp_smlb2_150_loan_tot_bal;
	}
	public BigDecimal getRrp_smlb2_150_loan_tot_prov() {
		return rrp_smlb2_150_loan_tot_prov;
	}
	public void setRrp_smlb2_150_loan_tot_prov(BigDecimal rrp_smlb2_150_loan_tot_prov) {
		this.rrp_smlb2_150_loan_tot_prov = rrp_smlb2_150_loan_tot_prov;
	}
	public BigDecimal getRrp_smlb2_150_loan_int_sus() {
		return rrp_smlb2_150_loan_int_sus;
	}
	public void setRrp_smlb2_150_loan_int_sus(BigDecimal rrp_smlb2_150_loan_int_sus) {
		this.rrp_smlb2_150_loan_int_sus = rrp_smlb2_150_loan_int_sus;
	}
	public BigDecimal getRrp_smlb2_150_loan_crm() {
		return rrp_smlb2_150_loan_crm;
	}
	public void setRrp_smlb2_150_loan_crm(BigDecimal rrp_smlb2_150_loan_crm) {
		this.rrp_smlb2_150_loan_crm = rrp_smlb2_150_loan_crm;
	}
	public BigDecimal getRrp_smlb2_150_loan_tot_dra() {
		return rrp_smlb2_150_loan_tot_dra;
	}
	public void setRrp_smlb2_150_loan_tot_dra(BigDecimal rrp_smlb2_150_loan_tot_dra) {
		this.rrp_smlb2_150_loan_tot_dra = rrp_smlb2_150_loan_tot_dra;
	}
	public BigDecimal getRrp_smlb2_150_inves_bal() {
		return rrp_smlb2_150_inves_bal;
	}
	public void setRrp_smlb2_150_inves_bal(BigDecimal rrp_smlb2_150_inves_bal) {
		this.rrp_smlb2_150_inves_bal = rrp_smlb2_150_inves_bal;
	}
	public BigDecimal getRrp_smlb2_150_inves_prov() {
		return rrp_smlb2_150_inves_prov;
	}
	public void setRrp_smlb2_150_inves_prov(BigDecimal rrp_smlb2_150_inves_prov) {
		this.rrp_smlb2_150_inves_prov = rrp_smlb2_150_inves_prov;
	}
	public BigDecimal getRrp_smlb2_150_inves_crm() {
		return rrp_smlb2_150_inves_crm;
	}
	public void setRrp_smlb2_150_inves_crm(BigDecimal rrp_smlb2_150_inves_crm) {
		this.rrp_smlb2_150_inves_crm = rrp_smlb2_150_inves_crm;
	}
	public BigDecimal getRrp_smlb2_150_inves_rwa() {
		return rrp_smlb2_150_inves_rwa;
	}
	public void setRrp_smlb2_150_inves_rwa(BigDecimal rrp_smlb2_150_inves_rwa) {
		this.rrp_smlb2_150_inves_rwa = rrp_smlb2_150_inves_rwa;
	}
	public BigDecimal getRrp_smlb2_150_plac_bal() {
		return rrp_smlb2_150_plac_bal;
	}
	public void setRrp_smlb2_150_plac_bal(BigDecimal rrp_smlb2_150_plac_bal) {
		this.rrp_smlb2_150_plac_bal = rrp_smlb2_150_plac_bal;
	}
	public BigDecimal getRrp_smlb2_150_plac_prov() {
		return rrp_smlb2_150_plac_prov;
	}
	public void setRrp_smlb2_150_plac_prov(BigDecimal rrp_smlb2_150_plac_prov) {
		this.rrp_smlb2_150_plac_prov = rrp_smlb2_150_plac_prov;
	}
	public BigDecimal getRrp_smlb2_150_plac_crm() {
		return rrp_smlb2_150_plac_crm;
	}
	public void setRrp_smlb2_150_plac_crm(BigDecimal rrp_smlb2_150_plac_crm) {
		this.rrp_smlb2_150_plac_crm = rrp_smlb2_150_plac_crm;
	}
	public BigDecimal getRrp_smlb2_150_plac_rwa() {
		return rrp_smlb2_150_plac_rwa;
	}
	public void setRrp_smlb2_150_plac_rwa(BigDecimal rrp_smlb2_150_plac_rwa) {
		this.rrp_smlb2_150_plac_rwa = rrp_smlb2_150_plac_rwa;
	}
	public BigDecimal getRrp_smlb2_150_cash_bal() {
		return rrp_smlb2_150_cash_bal;
	}
	public void setRrp_smlb2_150_cash_bal(BigDecimal rrp_smlb2_150_cash_bal) {
		this.rrp_smlb2_150_cash_bal = rrp_smlb2_150_cash_bal;
	}
	public BigDecimal getRrp_smlb2_150_cash_prov() {
		return rrp_smlb2_150_cash_prov;
	}
	public void setRrp_smlb2_150_cash_prov(BigDecimal rrp_smlb2_150_cash_prov) {
		this.rrp_smlb2_150_cash_prov = rrp_smlb2_150_cash_prov;
	}
	public BigDecimal getRrp_smlb2_150_cash_crm() {
		return rrp_smlb2_150_cash_crm;
	}
	public void setRrp_smlb2_150_cash_crm(BigDecimal rrp_smlb2_150_cash_crm) {
		this.rrp_smlb2_150_cash_crm = rrp_smlb2_150_cash_crm;
	}
	public BigDecimal getRrp_smlb2_150_cash_rwa() {
		return rrp_smlb2_150_cash_rwa;
	}
	public void setRrp_smlb2_150_cash_rwa(BigDecimal rrp_smlb2_150_cash_rwa) {
		this.rrp_smlb2_150_cash_rwa = rrp_smlb2_150_cash_rwa;
	}
	public BigDecimal getRrp_smlb2_150_tot_bal() {
		return rrp_smlb2_150_tot_bal;
	}
	public void setRrp_smlb2_150_tot_bal(BigDecimal rrp_smlb2_150_tot_bal) {
		this.rrp_smlb2_150_tot_bal = rrp_smlb2_150_tot_bal;
	}
	public BigDecimal getRrp_smlb2_150_tot_prov() {
		return rrp_smlb2_150_tot_prov;
	}
	public void setRrp_smlb2_150_tot_prov(BigDecimal rrp_smlb2_150_tot_prov) {
		this.rrp_smlb2_150_tot_prov = rrp_smlb2_150_tot_prov;
	}
	public BigDecimal getRrp_smlb2_150_tot_int_sus() {
		return rrp_smlb2_150_tot_int_sus;
	}
	public void setRrp_smlb2_150_tot_int_sus(BigDecimal rrp_smlb2_150_tot_int_sus) {
		this.rrp_smlb2_150_tot_int_sus = rrp_smlb2_150_tot_int_sus;
	}
	public BigDecimal getRrp_smlb2_150_tot_crm() {
		return rrp_smlb2_150_tot_crm;
	}
	public void setRrp_smlb2_150_tot_crm(BigDecimal rrp_smlb2_150_tot_crm) {
		this.rrp_smlb2_150_tot_crm = rrp_smlb2_150_tot_crm;
	}
	public BigDecimal getRrp_smlb2_150_tot_rwa() {
		return rrp_smlb2_150_tot_rwa;
	}
	public void setRrp_smlb2_150_tot_rwa(BigDecimal rrp_smlb2_150_tot_rwa) {
		this.rrp_smlb2_150_tot_rwa = rrp_smlb2_150_tot_rwa;
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
	

}
