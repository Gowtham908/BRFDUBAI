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
@Table(name="BRF95_TABLE3")

public class BRF95_TABLE3 {
	private BigDecimal	hni_0_20_lcbg_balance;
	private BigDecimal	hni_0_20_acceptance_amount;
	private BigDecimal	hni_0_20_lcbg_crm;
	private BigDecimal	hni_0_20_rwa;
	private BigDecimal	hni_0_20_under_ccf_amt;
	private BigDecimal	hni_0_50_lcbg_balance;
	private BigDecimal	hni_0_50_acceptance_amount;
	private BigDecimal	hni_0_50_lcbg_crm;
	private BigDecimal	hni_0_50_rwa;
	private BigDecimal	hni_0_50_under_ccf_amt;
	private BigDecimal	hni_0_10_lcbg_balance;
	private BigDecimal	hni_0_10_acceptance_amount;
	private BigDecimal	hni_0_10_lcbg_crm;
	private BigDecimal	hni_0_10_rwa;
	private BigDecimal	hni_0_10_under_ccf_amt;
	private BigDecimal	hni_0_lcbg_balance;
	private BigDecimal	hni_0_acceptance_amount;
	private BigDecimal	hni_0_lcbg_crm;
	private BigDecimal	hni_0_rwa;
	private BigDecimal	hni_0_under_ccf_amt;
	private BigDecimal	hni_20_20_lcbg_balance;
	private BigDecimal	hni_20_20_acceptance_amount;
	private BigDecimal	hni_20_20_lcbg_crm;
	private BigDecimal	hni_20_20_rwa;
	private BigDecimal	hni_20_20_under_ccf_amt;
	private BigDecimal	hni_20_50_lcbg_balance;
	private BigDecimal	hni_20_50_acceptance_amount;
	private BigDecimal	hni_20_50_lcbg_crm;
	private BigDecimal	hni_20_50_rwa;
	private BigDecimal	hni_20_50_under_ccf_amt;
	private BigDecimal	hni_20_10_lcbg_balance;
	private BigDecimal	hni_20_10_acceptance_amount;
	private BigDecimal	hni_20_10_lcbg_crm;
	private BigDecimal	hni_20_10_rwa;
	private BigDecimal	hni_20_10_under_ccf_amt;
	private BigDecimal	hni_20_lcbg_balance;
	private BigDecimal	hni_20_acceptance_amount;
	private BigDecimal	hni_20_lcbg_crm;
	private BigDecimal	hni_20_rwa;
	private BigDecimal	hni_20_under_ccf_amt;
	private BigDecimal	hni_50_20_lcbg_balance;
	private BigDecimal	hni_50_20_acceptance_amount;
	private BigDecimal	hni_50_20_lcbg_crm;
	private BigDecimal	hni_50_20_rwa;
	private BigDecimal	hni_50_20_under_ccf_amt;
	private BigDecimal	hni_50_50_lcbg_balance;
	private BigDecimal	hni_50_50_acceptance_amount;
	private BigDecimal	hni_50_50_lcbg_crm;
	private BigDecimal	hni_50_50_rwa;
	private BigDecimal	hni_50_50_under_ccf_amt;
	private BigDecimal	hni_50_10_lcbg_balance;
	private BigDecimal	hni_50_10_acceptance_amount;
	private BigDecimal	hni_50_10_lcbg_crm;
	private BigDecimal	hni_50_10_rwa;
	private BigDecimal	hni_50_10_under_ccf_amt;
	private BigDecimal	hni_50_lcbg_balance;
	private BigDecimal	hni_50_acceptance_amount;
	private BigDecimal	hni_50_lcbg_crm;
	private BigDecimal	hni_50_rwa;
	private BigDecimal	hni_50_under_ccf_amt;
	private BigDecimal	hni_100_20_lcbg_balance;
	private BigDecimal	hni_100_20_acceptance_amount;
	private BigDecimal	hni_100_20_lcbg_crm;
	private BigDecimal	hni_100_20_rwa;
	private BigDecimal	hni_100_20_under_ccf_amt;
	private BigDecimal	hni_100_50_lcbg_balance;
	private BigDecimal	hni_100_50_acceptance_amount;
	private BigDecimal	hni_100_50_lcbg_crm;
	private BigDecimal	hni_100_50_rwa;
	private BigDecimal	hni_100_50_under_ccf_amt;
	private BigDecimal	hni_100_10_lcbg_balance;
	private BigDecimal	hni_100_10_acceptance_amount;
	private BigDecimal	hni_100_10_lcbg_crm;
	private BigDecimal	hni_100_10_rwa;
	private BigDecimal	hni_100_10_under_ccf_amt;
	private BigDecimal	hni_100_lcbg_balance;
	private BigDecimal	hni_100_acceptance_amount;
	private BigDecimal	hni_100_lcbg_crm;
	private BigDecimal	hni_100_rwa;
	private BigDecimal	hni_100_under_ccf_amt;
	private BigDecimal	hni_150_20_lcbg_balance;
	private BigDecimal	hni_150_20_acceptance_amount;
	private BigDecimal	hni_150_20_lcbg_crm;
	private BigDecimal	hni_150_20_rwa;
	private BigDecimal	hni_150_20_under_ccf_amt;
	private BigDecimal	hni_150_50_lcbg_balance;
	private BigDecimal	hni_150_50_acceptance_amount;
	private BigDecimal	hni_150_50_lcbg_crm;
	private BigDecimal	hni_150_50_rwa;
	private BigDecimal	hni_150_50_under_ccf_amt;
	private BigDecimal	hni_150_10_lcbg_balance;
	private BigDecimal	hni_150_10_acceptance_amount;
	private BigDecimal	hni_150_10_lcbg_crm;
	private BigDecimal	hni_150_10_rwa;
	private BigDecimal	hni_150_10_under_ccf_amt;
	private BigDecimal	hni_150_lcbg_balance;
	private BigDecimal	hni_150_acceptance_amount;
	private BigDecimal	hni_150_lcbg_crm;
	private BigDecimal	hni_150_rwa;
	private BigDecimal	hni_150_under_ccf_amt;
	private BigDecimal	pdl_0_20_lcbg_balance;
	private BigDecimal	pdl_0_20_acceptance_amount;
	private BigDecimal	pdl_0_20_lcbg_crm;
	private BigDecimal	pdl_0_20_rwa;
	private BigDecimal	pdl_0_20_under_ccf_amt;
	private BigDecimal	pdl_0_50_lcbg_balance;
	private BigDecimal	pdl_0_50_acceptance_amount;
	private BigDecimal	pdl_0_50_lcbg_crm;
	private BigDecimal	pdl_0_50_rwa;
	private BigDecimal	pdl_0_50_under_ccf_amt;
	private BigDecimal	pdl_0_10_lcbg_balance;
	private BigDecimal	pdl_0_10_acceptance_amount;
	private BigDecimal	pdl_0_10_lcbg_crm;
	private BigDecimal	pdl_0_10_rwa;
	private BigDecimal	pdl_0_10_under_ccf_amt;
	private BigDecimal	pdl_0_lcbg_balance;
	private BigDecimal	pdl_0_acceptance_amount;
	private BigDecimal	pdl_0_lcbg_crm;
	private BigDecimal	pdl_0_rwa;
	private BigDecimal	pdl_0_under_ccf_amt;
	private BigDecimal	pdl_20_20_lcbg_balance;
	private BigDecimal	pdl_20_20_acceptance_amount;
	private BigDecimal	pdl_20_20_lcbg_crm;
	private BigDecimal	pdl_20_20_rwa;
	private BigDecimal	pdl_20_20_under_ccf_amt;
	private BigDecimal	pdl_20_50_lcbg_balance;
	private BigDecimal	pdl_20_50_acceptance_amount;
	private BigDecimal	pdl_20_50_lcbg_crm;
	private BigDecimal	pdl_20_50_rwa;
	private BigDecimal	pdl_20_50_under_ccf_amt;
	private BigDecimal	pdl_20_10_lcbg_balance;
	private BigDecimal	pdl_20_10_acceptance_amount;
	private BigDecimal	pdl_20_10_lcbg_crm;
	private BigDecimal	pdl_20_10_rwa;
	private BigDecimal	pdl_20_10_under_ccf_amt;
	private BigDecimal	pdl_20_lcbg_balance;
	private BigDecimal	pdl_20_acceptance_amount;
	private BigDecimal	pdl_20_lcbg_crm;
	private BigDecimal	pdl_20_rwa;
	private BigDecimal	pdl_20_under_ccf_amt;
	private BigDecimal	pdl_50_20_lcbg_balance;
	private BigDecimal	pdl_50_20_acceptance_amount;
	private BigDecimal	pdl_50_20_lcbg_crm;
	private BigDecimal	pdl_50_20_rwa;
	private BigDecimal	pdl_50_20_under_ccf_amt;
	private BigDecimal	pdl_50_50_lcbg_balance;
	private BigDecimal	pdl_50_50_acceptance_amount;
	private BigDecimal	pdl_50_50_lcbg_crm;
	private BigDecimal	pdl_50_50_rwa;
	private BigDecimal	pdl_50_50_under_ccf_amt;
	private BigDecimal	pdl_50_10_lcbg_balance;
	private BigDecimal	pdl_50_10_acceptance_amount;
	private BigDecimal	pdl_50_10_lcbg_crm;
	private BigDecimal	pdl_50_10_rwa;
	private BigDecimal	pdl_50_10_under_ccf_amt;
	private BigDecimal	pdl_50_lcbg_balance;
	private BigDecimal	pdl_50_acceptance_amount;
	private BigDecimal	pdl_50_lcbg_crm;
	private BigDecimal	pdl_50_rwa;
	private BigDecimal	pdl_50_under_ccf_amt;
	private BigDecimal	res_0_20_lcbg_balance;
	private BigDecimal	res_0_20_acceptance_amount;
	private BigDecimal	res_0_20_lcbg_crm;
	private BigDecimal	res_0_20_rwa;
	private BigDecimal	res_0_20_under_ccf_amt;
	private BigDecimal	res_0_50_lcbg_balance;
	private BigDecimal	res_0_50_acceptance_amount;
	private BigDecimal	res_0_50_lcbg_crm;
	private BigDecimal	res_0_50_rwa;
	private BigDecimal	res_0_50_under_ccf_amt;
	private BigDecimal	res_0_10_lcbg_balance;
	private BigDecimal	res_0_10_acceptance_amount;
	private BigDecimal	res_0_10_lcbg_crm;
	private BigDecimal	res_0_10_rwa;
	private BigDecimal	res_0_10_under_ccf_amt;
	private BigDecimal	res_0_lcbg_balance;
	private BigDecimal	res_0_acceptance_amount;
	private BigDecimal	res_0_lcbg_crm;
	private BigDecimal	res_0_rwa;
	private BigDecimal	res_0_under_ccf_amt;
	private BigDecimal	res_20_20_lcbg_balance;
	private BigDecimal	res_20_20_acceptance_amount;
	private BigDecimal	res_20_20_lcbg_crm;
	private BigDecimal	res_20_20_rwa;
	private BigDecimal	res_20_20_under_ccf_amt;
	private BigDecimal	res_20_50_lcbg_balance;
	private BigDecimal	res_20_50_acceptance_amount;
	private BigDecimal	res_20_50_lcbg_crm;
	private BigDecimal	res_20_50_rwa;
	private BigDecimal	res_20_50_under_ccf_amt;
	private BigDecimal	res_20_10_lcbg_balance;
	private BigDecimal	res_20_10_acceptance_amount;
	private BigDecimal	res_20_10_lcbg_crm;
	private BigDecimal	res_20_10_rwa;
	private BigDecimal	res_20_10_under_ccf_amt;
	private BigDecimal	res_20_lcbg_balance;
	private BigDecimal	res_20_acceptance_amount;
	private BigDecimal	res_20_lcbg_crm;
	private BigDecimal	res_20_rwa;
	private BigDecimal	res_20_under_ccf_amt;
	private BigDecimal	res_50_20_lcbg_balance;
	private BigDecimal	res_50_20_acceptance_amount;
	private BigDecimal	res_50_20_lcbg_crm;
	private BigDecimal	res_50_20_rwa;
	private BigDecimal	res_50_20_under_ccf_amt;
	private BigDecimal	res_50_50_lcbg_balance;
	private BigDecimal	res_50_50_acceptance_amount;
	private BigDecimal	res_50_50_lcbg_crm;
	private BigDecimal	res_50_50_rwa;
	private BigDecimal	res_50_50_under_ccf_amt;
	private BigDecimal	res_50_10_lcbg_balance;
	private BigDecimal	res_50_10_acceptance_amount;
	private BigDecimal	res_50_10_lcbg_crm;
	private BigDecimal	res_50_10_rwa;
	private BigDecimal	res_50_10_under_ccf_amt;
	private BigDecimal	res_50_lcbg_balance;
	private BigDecimal	res_50_acceptance_amount;
	private BigDecimal	res_50_lcbg_crm;
	private BigDecimal	res_50_rwa;
	private BigDecimal	res_50_under_ccf_amt;
	private BigDecimal	res_150_20_lcbg_balance;
	private BigDecimal	res_150_20_acceptance_amount;
	private BigDecimal	res_150_20_lcbg_crm;
	private BigDecimal	res_150_20_rwa;
	private BigDecimal	res_150_20_under_ccf_amt;
	private BigDecimal	res_150_50_lcbg_balance;
	private BigDecimal	res_150_50_acceptance_amount;
	private BigDecimal	res_150_50_lcbg_crm;
	private BigDecimal	res_150_50_rwa;
	private BigDecimal	res_150_50_under_ccf_amt;
	private BigDecimal	res_150_10_lcbg_balance;
	private BigDecimal	res_150_10_acceptance_amount;
	private BigDecimal	res_150_10_lcbg_crm;
	private BigDecimal	res_150_10_rwa;
	private BigDecimal	res_150_10_under_ccf_amt;
	private BigDecimal	res_150_lcbg_balance;
	private BigDecimal	res_150_acceptance_amount;
	private BigDecimal	res_150_lcbg_crm;
	private BigDecimal	res_150_rwa;
	private BigDecimal	res_150_under_ccf_amt;
	private BigDecimal	rrp_inde1_0_20_lcbg_balance;
	private BigDecimal	rrp_inde1_0_20_acceptance_amount;
	private BigDecimal	rrp_inde1_0_20_lcbg_crm;
	private BigDecimal	rrp_inde1_0_20_rwa;
	private BigDecimal	rrp_inde1_0_20_under_ccf_amt;
	private BigDecimal	rrp_inde1_0_50_lcbg_balance;
	private BigDecimal	rrp_inde1_0_50_acceptance_amount;
	private BigDecimal	rrp_inde1_0_50_lcbg_crm;
	private BigDecimal	rrp_inde1_0_50_rwa;
	private BigDecimal	rrp_inde1_0_50_under_ccf_amt;
	private BigDecimal	rrp_inde1_0_10_lcbg_balance;
	private BigDecimal	rrp_inde1_0_10_acceptance_amount;
	private BigDecimal	rrp_inde1_0_10_lcbg_crm;
	private BigDecimal	rrp_inde1_0_10_rwa;
	private BigDecimal	rrp_inde1_0_10_under_ccf_amt;
	private BigDecimal	rrp_inde1_0_lcbg_balance;
	private BigDecimal	rrp_inde1_0_acceptance_amount;
	private BigDecimal	rrp_inde1_0_lcbg_crm;
	private BigDecimal	rrp_inde1_0_rwa;
	private BigDecimal	rrp_inde1_0_under_ccf_amt;
	private BigDecimal	rrp_inde1_20_20_lcbg_balance;
	private BigDecimal	rrp_inde1_20_20_acceptance_amount;
	private BigDecimal	rrp_inde1_20_20_lcbg_crm;
	private BigDecimal	rrp_inde1_20_20_rwa;
	private BigDecimal	rrp_inde1_20_20_under_ccf_amt;
	private BigDecimal	rrp_inde1_20_50_lcbg_balance;
	private BigDecimal	rrp_inde1_20_50_acceptance_amount;
	private BigDecimal	rrp_inde1_20_50_lcbg_crm;
	private BigDecimal	rrp_inde1_20_50_rwa;
	private BigDecimal	rrp_inde1_20_50_under_ccf_amt;
	private BigDecimal	rrp_inde1_20_10_lcbg_balance;
	private BigDecimal	rrp_inde1_20_10_acceptance_amount;
	private BigDecimal	rrp_inde1_20_10_lcbg_crm;
	private BigDecimal	rrp_inde1_20_10_rwa;
	private BigDecimal	rrp_inde1_20_10_under_ccf_amt;
	private BigDecimal	rrp_inde1_20_lcbg_balance;
	private BigDecimal	rrp_inde1_20_acceptance_amount;
	private BigDecimal	rrp_inde1_20_lcbg_crm;
	private BigDecimal	rrp_inde1_20_rwa;
	private BigDecimal	rrp_inde1_20_under_ccf_amt;
	private BigDecimal	rrp_inde1_50_20_lcbg_balance;
	private BigDecimal	rrp_inde1_50_20_acceptance_amount;
	private BigDecimal	rrp_inde1_50_20_lcbg_crm;
	private BigDecimal	rrp_inde1_50_20_rwa;
	private BigDecimal	rrp_inde1_50_20_under_ccf_amt;
	private BigDecimal	rrp_inde1_50_50_lcbg_balance;
	private BigDecimal	rrp_inde1_50_50_acceptance_amount;
	private BigDecimal	rrp_inde1_50_50_lcbg_crm;
	private BigDecimal	rrp_inde1_50_50_rwa;
	private BigDecimal	rrp_inde1_50_50_under_ccf_amt;
	private BigDecimal	rrp_inde1_50_10_lcbg_balance;
	private BigDecimal	rrp_inde1_50_10_acceptance_amount;
	private BigDecimal	rrp_inde1_50_10_lcbg_crm;
	private BigDecimal	rrp_inde1_50_10_rwa;
	private BigDecimal	rrp_inde1_50_10_under_ccf_amt;
	private BigDecimal	rrp_inde1_50_lcbg_balance;
	private BigDecimal	rrp_inde1_50_acceptance_amount;
	private BigDecimal	rrp_inde1_50_lcbg_crm;
	private BigDecimal	rrp_inde1_50_rwa;
	private BigDecimal	rrp_inde1_50_under_ccf_amt;
	private BigDecimal	rrp_inde1_100_20_lcbg_balance;
	private BigDecimal	rrp_inde1_100_20_acceptance_amount;
	private BigDecimal	rrp_inde1_100_20_lcbg_crm;
	private BigDecimal	rrp_inde1_100_20_rwa;
	private BigDecimal	rrp_inde1_100_20_under_ccf_amt;
	private BigDecimal	rrp_inde1_100_50_lcbg_balance;
	private BigDecimal	rrp_inde1_100_50_acceptance_amount;
	private BigDecimal	rrp_inde1_100_50_lcbg_crm;
	private BigDecimal	rrp_inde1_100_50_rwa;
	private BigDecimal	rrp_inde1_100_50_under_ccf_amt;
	private BigDecimal	rrp_inde1_100_10_lcbg_balance;
	private BigDecimal	rrp_inde1_100_10_acceptance_amount;
	private BigDecimal	rrp_inde1_100_10_lcbg_crm;
	private BigDecimal	rrp_inde1_100_10_rwa;
	private BigDecimal	rrp_inde1_100_10_under_ccf_amt;
	private BigDecimal	rrp_inde1_100_lcbg_balance;
	private BigDecimal	rrp_inde1_100_acceptance_amount;
	private BigDecimal	rrp_inde1_100_lcbg_crm;
	private BigDecimal	rrp_inde1_100_rwa;
	private BigDecimal	rrp_inde1_100_under_ccf_amt;
	private BigDecimal	rrp_inde1_150_20_lcbg_balance;
	private BigDecimal	rrp_inde1_150_20_acceptance_amount;
	private BigDecimal	rrp_inde1_150_20_lcbg_crm;
	private BigDecimal	rrp_inde1_150_20_rwa;
	private BigDecimal	rrp_inde1_150_20_under_ccf_amt;
	private BigDecimal	rrp_inde1_150_50_lcbg_balance;
	private BigDecimal	rrp_inde1_150_50_acceptance_amount;
	private BigDecimal	rrp_inde1_150_50_lcbg_crm;
	private BigDecimal	rrp_inde1_150_50_rwa;
	private BigDecimal	rrp_inde1_150_50_under_ccf_amt;
	private BigDecimal	rrp_inde1_150_10_lcbg_balance;
	private BigDecimal	rrp_inde1_150_10_acceptance_amount;
	private BigDecimal	rrp_inde1_150_10_lcbg_crm;
	private BigDecimal	rrp_inde1_150_10_rwa;
	private BigDecimal	rrp_inde1_150_10_under_ccf_amt;
	private BigDecimal	rrp_inde1_150_lcbg_balance;
	private BigDecimal	rrp_inde1_150_acceptance_amount;
	private BigDecimal	rrp_inde1_150_lcbg_crm;
	private BigDecimal	rrp_inde1_150_rwa;
	private BigDecimal	rrp_inde1_150_under_ccf_amt;
	private BigDecimal	rrp_inde2_0_20_lcbg_balance;
	private BigDecimal	rrp_inde2_0_20_acceptance_amount;
	private BigDecimal	rrp_inde2_0_20_lcbg_crm;
	private BigDecimal	rrp_inde2_0_20_rwa;
	private BigDecimal	rrp_inde2_0_20_under_ccf_amt;
	private BigDecimal	rrp_inde2_0_50_lcbg_balance;
	private BigDecimal	rrp_inde2_0_50_acceptance_amount;
	private BigDecimal	rrp_inde2_0_50_lcbg_crm;
	private BigDecimal	rrp_inde2_0_50_rwa;
	private BigDecimal	rrp_inde2_0_50_under_ccf_amt;
	private BigDecimal	rrp_inde2_0_10_lcbg_balance;
	private BigDecimal	rrp_inde2_0_10_acceptance_amount;
	private BigDecimal	rrp_inde2_0_10_lcbg_crm;
	private BigDecimal	rrp_inde2_0_10_rwa;
	private BigDecimal	rrp_inde2_0_10_under_ccf_amt;
	private BigDecimal	rrp_inde2_0_lcbg_balance;
	private BigDecimal	rrp_inde2_0_acceptance_amount;
	private BigDecimal	rrp_inde2_0_lcbg_crm;
	private BigDecimal	rrp_inde2_0_rwa;
	private BigDecimal	rrp_inde2_0_under_ccf_amt;
	private BigDecimal	rrp_inde2_20_20_lcbg_balance;
	private BigDecimal	rrp_inde2_20_20_acceptance_amount;
	private BigDecimal	rrp_inde2_20_20_lcbg_crm;
	private BigDecimal	rrp_inde2_20_20_rwa;
	private BigDecimal	rrp_inde2_20_20_under_ccf_amt;
	private BigDecimal	rrp_inde2_20_50_lcbg_balance;
	private BigDecimal	rrp_inde2_20_50_acceptance_amount;
	private BigDecimal	rrp_inde2_20_50_lcbg_crm;
	private BigDecimal	rrp_inde2_20_50_rwa;
	private BigDecimal	rrp_inde2_20_50_under_ccf_amt;
	private BigDecimal	rrp_inde2_20_10_lcbg_balance;
	private BigDecimal	rrp_inde2_20_10_acceptance_amount;
	private BigDecimal	rrp_inde2_20_10_lcbg_crm;
	private BigDecimal	rrp_inde2_20_10_rwa;
	private BigDecimal	rrp_inde2_20_10_under_ccf_amt;
	private BigDecimal	rrp_inde2_20_lcbg_balance;
	private BigDecimal	rrp_inde2_20_acceptance_amount;
	private BigDecimal	rrp_inde2_20_lcbg_crm;
	private BigDecimal	rrp_inde2_20_rwa;
	private BigDecimal	rrp_inde2_20_under_ccf_amt;
	private BigDecimal	rrp_inde2_50_20_lcbg_balance;
	private BigDecimal	rrp_inde2_50_20_acceptance_amount;
	private BigDecimal	rrp_inde2_50_20_lcbg_crm;
	private BigDecimal	rrp_inde2_50_20_rwa;
	private BigDecimal	rrp_inde2_50_20_under_ccf_amt;
	private BigDecimal	rrp_inde2_50_50_lcbg_balance;
	private BigDecimal	rrp_inde2_50_50_acceptance_amount;
	private BigDecimal	rrp_inde2_50_50_lcbg_crm;
	private BigDecimal	rrp_inde2_50_50_rwa;
	private BigDecimal	rrp_inde2_50_50_under_ccf_amt;
	private BigDecimal	rrp_inde2_50_10_lcbg_balance;
	private BigDecimal	rrp_inde2_50_10_acceptance_amount;
	private BigDecimal	rrp_inde2_50_10_lcbg_crm;
	private BigDecimal	rrp_inde2_50_10_rwa;
	private BigDecimal	rrp_inde2_50_10_under_ccf_amt;
	private BigDecimal	rrp_inde2_50_lcbg_balance;
	private BigDecimal	rrp_inde2_50_acceptance_amount;
	private BigDecimal	rrp_inde2_50_lcbg_crm;
	private BigDecimal	rrp_inde2_50_rwa;
	private BigDecimal	rrp_inde2_50_under_ccf_amt;
	private BigDecimal	rrp_inde2_150_20_lcbg_balance;
	private BigDecimal	rrp_inde2_150_20_acceptance_amount;
	private BigDecimal	rrp_inde2_150_20_lcbg_crm;
	private BigDecimal	rrp_inde2_150_20_rwa;
	private BigDecimal	rrp_inde2_150_20_under_ccf_amt;
	private BigDecimal	rrp_inde2_150_50_lcbg_balance;
	private BigDecimal	rrp_inde2_150_50_acceptance_amount;
	private BigDecimal	rrp_inde2_150_50_lcbg_crm;
	private BigDecimal	rrp_inde2_150_50_rwa;
	private BigDecimal	rrp_inde2_150_50_under_ccf_amt;
	private BigDecimal	rrp_inde2_150_10_lcbg_balance;
	private BigDecimal	rrp_inde2_150_10_acceptance_amount;
	private BigDecimal	rrp_inde2_150_10_lcbg_crm;
	private BigDecimal	rrp_inde2_150_10_rwa;
	private BigDecimal	rrp_inde2_150_10_under_ccf_amt;
	private BigDecimal	rrp_inde2_150_lcbg_balance;
	private BigDecimal	rrp_inde2_150_acceptance_amount;
	private BigDecimal	rrp_inde2_150_lcbg_crm;
	private BigDecimal	rrp_inde2_150_rwa;
	private BigDecimal	rrp_inde2_150_under_ccf_amt;
	private BigDecimal	rrp_smlb_0_20_lcbg_balance;
	private BigDecimal	rrp_smlb_0_20_acceptance_amount;
	private BigDecimal	rrp_smlb_0_20_lcbg_crm;
	private BigDecimal	rrp_smlb_0_20_rwa;
	private BigDecimal	rrp_smlb_0_20_under_ccf_amt;
	private BigDecimal	rrp_smlb_0_50_lcbg_balance;
	private BigDecimal	rrp_smlb_0_50_acceptance_amount;
	private BigDecimal	rrp_smlb_0_50_lcbg_crm;
	private BigDecimal	rrp_smlb_0_50_rwa;
	private BigDecimal	rrp_smlb_0_50_under_ccf_amt;
	private BigDecimal	rrp_smlb_0_10_lcbg_balance;
	private BigDecimal	rrp_smlb_0_10_acceptance_amount;
	private BigDecimal	rrp_smlb_0_10_lcbg_crm;
	private BigDecimal	rrp_smlb_0_10_rwa;
	private BigDecimal	rrp_smlb_0_10_under_ccf_amt;
	private BigDecimal	rrp_smlb_0_lcbg_balance;
	private BigDecimal	rrp_smlb_0_acceptance_amount;
	private BigDecimal	rrp_smlb_0_lcbg_crm;
	private BigDecimal	rrp_smlb_0_rwa;
	private BigDecimal	rrp_smlb_0_under_ccf_amt;
	private BigDecimal	rrp_smlb_20_20_lcbg_balance;
	private BigDecimal	rrp_smlb_20_20_acceptance_amount;
	private BigDecimal	rrp_smlb_20_20_lcbg_crm;
	private BigDecimal	rrp_smlb_20_20_rwa;
	private BigDecimal	rrp_smlb_20_20_under_ccf_amt;
	private BigDecimal	rrp_smlb_20_50_lcbg_balance;
	private BigDecimal	rrp_smlb_20_50_acceptance_amount;
	private BigDecimal	rrp_smlb_20_50_lcbg_crm;
	private BigDecimal	rrp_smlb_20_50_rwa;
	private BigDecimal	rrp_smlb_20_50_under_ccf_amt;
	private BigDecimal	rrp_smlb_20_10_lcbg_balance;
	private BigDecimal	rrp_smlb_20_10_acceptance_amount;
	private BigDecimal	rrp_smlb_20_10_lcbg_crm;
	private BigDecimal	rrp_smlb_20_10_rwa;
	private BigDecimal	rrp_smlb_20_10_under_ccf_amt;
	private BigDecimal	rrp_smlb_20_lcbg_balance;
	private BigDecimal	rrp_smlb_20_acceptance_amount;
	private BigDecimal	rrp_smlb_20_lcbg_crm;
	private BigDecimal	rrp_smlb_20_rwa;
	private BigDecimal	rrp_smlb_20_under_ccf_amt;
	private BigDecimal	rrp_smlb_50_20_lcbg_balance;
	private BigDecimal	rrp_smlb_50_20_acceptance_amount;
	private BigDecimal	rrp_smlb_50_20_lcbg_crm;
	private BigDecimal	rrp_smlb_50_20_rwa;
	private BigDecimal	rrp_smlb_50_20_under_ccf_amt;
	private BigDecimal	rrp_smlb_50_50_lcbg_balance;
	private BigDecimal	rrp_smlb_50_50_acceptance_amount;
	private BigDecimal	rrp_smlb_50_50_lcbg_crm;
	private BigDecimal	rrp_smlb_50_50_rwa;
	private BigDecimal	rrp_smlb_50_50_under_ccf_amt;
	private BigDecimal	rrp_smlb_50_10_lcbg_balance;
	private BigDecimal	rrp_smlb_50_10_acceptance_amount;
	private BigDecimal	rrp_smlb_50_10_lcbg_crm;
	private BigDecimal	rrp_smlb_50_10_rwa;
	private BigDecimal	rrp_smlb_50_10_under_ccf_amt;
	private BigDecimal	rrp_smlb_50_lcbg_balance;
	private BigDecimal	rrp_smlb_50_acceptance_amount;
	private BigDecimal	rrp_smlb_50_lcbg_crm;
	private BigDecimal	rrp_smlb_50_rwa;
	private BigDecimal	rrp_smlb_50_under_ccf_amt;
	private BigDecimal	rrp_smlb_100_20_lcbg_balance;
	private BigDecimal	rrp_smlb_100_20_acceptance_amount;
	private BigDecimal	rrp_smlb_100_20_lcbg_crm;
	private BigDecimal	rrp_smlb_100_20_rwa;
	private BigDecimal	rrp_smlb_100_20_under_ccf_amt;
	private BigDecimal	rrp_smlb_100_50_lcbg_balance;
	private BigDecimal	rrp_smlb_100_50_acceptance_amount;
	private BigDecimal	rrp_smlb_100_50_lcbg_crm;
	private BigDecimal	rrp_smlb_100_50_rwa;
	private BigDecimal	rrp_smlb_100_50_under_ccf_amt;
	private BigDecimal	rrp_smlb_100_10_lcbg_balance;
	private BigDecimal	rrp_smlb_100_10_acceptance_amount;
	private BigDecimal	rrp_smlb_100_10_lcbg_crm;
	private BigDecimal	rrp_smlb_100_10_rwa;
	private BigDecimal	rrp_smlb_100_10_under_ccf_amt;
	private BigDecimal	rrp_smlb_100_lcbg_balance;
	private BigDecimal	rrp_smlb_100_acceptance_amount;
	private BigDecimal	rrp_smlb_100_lcbg_crm;
	private BigDecimal	rrp_smlb_100_rwa;
	private BigDecimal	rrp_smlb_100_under_ccf_amt;
	private BigDecimal	rrp_smlb_150_20_lcbg_balance;
	private BigDecimal	rrp_smlb_150_20_acceptance_amount;
	private BigDecimal	rrp_smlb_150_20_lcbg_crm;
	private BigDecimal	rrp_smlb_150_20_rwa;
	private BigDecimal	rrp_smlb_150_20_under_ccf_amt;
	private BigDecimal	rrp_smlb_150_50_lcbg_balance;
	private BigDecimal	rrp_smlb_150_50_acceptance_amount;
	private BigDecimal	rrp_smlb_150_50_lcbg_crm;
	private BigDecimal	rrp_smlb_150_50_rwa;
	private BigDecimal	rrp_smlb_150_50_under_ccf_amt;
	private BigDecimal	rrp_smlb_150_10_lcbg_balance;
	private BigDecimal	rrp_smlb_150_10_acceptance_amount;
	private BigDecimal	rrp_smlb_150_10_lcbg_crm;
	private BigDecimal	rrp_smlb_150_10_rwa;
	private BigDecimal	rrp_smlb_150_10_under_ccf_amt;
	private BigDecimal	rrp_smlb_150_lcbg_balance;
	private BigDecimal	rrp_smlb_150_acceptance_amount;
	private BigDecimal	rrp_smlb_150_lcbg_crm;
	private BigDecimal	rrp_smlb_150_rwa;
	private BigDecimal	rrp_smlb_150_under_ccf_amt;
	private BigDecimal	rrp_smlb2_0_20_lcbg_balance;
	private BigDecimal	rrp_smlb2_0_20_acceptance_amount;
	private BigDecimal	rrp_smlb2_0_20_lcbg_crm;
	private BigDecimal	rrp_smlb2_0_20_rwa;
	private BigDecimal	rrp_smlb2_0_20_under_ccf_amt;
	private BigDecimal	rrp_smlb2_0_50_lcbg_balance;
	private BigDecimal	rrp_smlb2_0_50_acceptance_amount;
	private BigDecimal	rrp_smlb2_0_50_lcbg_crm;
	private BigDecimal	rrp_smlb2_0_50_rwa;
	private BigDecimal	rrp_smlb2_0_50_under_ccf_amt;
	private BigDecimal	rrp_smlb2_0_10_lcbg_balance;
	private BigDecimal	rrp_smlb2_0_10_acceptance_amount;
	private BigDecimal	rrp_smlb2_0_10_lcbg_crm;
	private BigDecimal	rrp_smlb2_0_10_rwa;
	private BigDecimal	rrp_smlb2_0_10_under_ccf_amt;
	private BigDecimal	rrp_smlb2_0_lcbg_balance;
	private BigDecimal	rrp_smlb2_0_acceptance_amount;
	private BigDecimal	rrp_smlb2_0_lcbg_crm;
	private BigDecimal	rrp_smlb2_0_rwa;
	private BigDecimal	rrp_smlb2_0_under_ccf_amt;
	private BigDecimal	rrp_smlb2_20_20_lcbg_balance;
	private BigDecimal	rrp_smlb2_20_20_acceptance_amount;
	private BigDecimal	rrp_smlb2_20_20_lcbg_crm;
	private BigDecimal	rrp_smlb2_20_20_rwa;
	private BigDecimal	rrp_smlb2_20_20_under_ccf_amt;
	private BigDecimal	rrp_smlb2_20_50_lcbg_balance;
	private BigDecimal	rrp_smlb2_20_50_acceptance_amount;
	private BigDecimal	rrp_smlb2_20_50_lcbg_crm;
	private BigDecimal	rrp_smlb2_20_50_rwa;
	private BigDecimal	rrp_smlb2_20_50_under_ccf_amt;
	private BigDecimal	rrp_smlb2_20_10_lcbg_balance;
	private BigDecimal	rrp_smlb2_20_10_acceptance_amount;
	private BigDecimal	rrp_smlb2_20_10_lcbg_crm;
	private BigDecimal	rrp_smlb2_20_10_rwa;
	private BigDecimal	rrp_smlb2_20_10_under_ccf_amt;
	private BigDecimal	rrp_smlb2_20_lcbg_balance;
	private BigDecimal	rrp_smlb2_20_acceptance_amount;
	private BigDecimal	rrp_smlb2_20_lcbg_crm;
	private BigDecimal	rrp_smlb2_20_rwa;
	private BigDecimal	rrp_smlb2_20_under_ccf_amt;
	private BigDecimal	rrp_smlb2_50_20_lcbg_balance;
	private BigDecimal	rrp_smlb2_50_20_acceptance_amount;
	private BigDecimal	rrp_smlb2_50_20_lcbg_crm;
	private BigDecimal	rrp_smlb2_50_20_rwa;
	private BigDecimal	rrp_smlb2_50_20_under_ccf_amt;
	private BigDecimal	rrp_smlb2_50_50_lcbg_balance;
	private BigDecimal	rrp_smlb2_50_50_acceptance_amount;
	private BigDecimal	rrp_smlb2_50_50_lcbg_crm;
	private BigDecimal	rrp_smlb2_50_50_rwa;
	private BigDecimal	rrp_smlb2_50_50_under_ccf_amt;
	private BigDecimal	rrp_smlb2_50_10_lcbg_balance;
	private BigDecimal	rrp_smlb2_50_10_acceptance_amount;
	private BigDecimal	rrp_smlb2_50_10_lcbg_crm;
	private BigDecimal	rrp_smlb2_50_10_rwa;
	private BigDecimal	rrp_smlb2_50_10_under_ccf_amt;
	private BigDecimal	rrp_smlb2_50_lcbg_balance;
	private BigDecimal	rrp_smlb2_50_acceptance_amount;
	private BigDecimal	rrp_smlb2_50_lcbg_crm;
	private BigDecimal	rrp_smlb2_50_rwa;
	private BigDecimal	rrp_smlb2_50_under_ccf_amt;
	private BigDecimal	rrp_smlb2_100_20_lcbg_balance;
	private BigDecimal	rrp_smlb2_100_20_acceptance_amount;
	private BigDecimal	rrp_smlb2_100_20_lcbg_crm;
	private BigDecimal	rrp_smlb2_100_20_rwa;
	private BigDecimal	rrp_smlb2_100_20_under_ccf_amt;
	private BigDecimal	rrp_smlb2_100_50_lcbg_balance;
	private BigDecimal	rrp_smlb2_100_50_acceptance_amount;
	private BigDecimal	rrp_smlb2_100_50_lcbg_crm;
	private BigDecimal	rrp_smlb2_100_50_rwa;
	private BigDecimal	rrp_smlb2_100_50_under_ccf_amt;
	private BigDecimal	rrp_smlb2_100_10_lcbg_balance;
	private BigDecimal	rrp_smlb2_100_10_acceptance_amount;
	private BigDecimal	rrp_smlb2_100_10_lcbg_crm;
	private BigDecimal	rrp_smlb2_100_10_rwa;
	private BigDecimal	rrp_smlb2_100_10_under_ccf_amt;
	private BigDecimal	rrp_smlb2_100_lcbg_balance;
	private BigDecimal	rrp_smlb2_100_acceptance_amount;
	private BigDecimal	rrp_smlb2_100_lcbg_crm;
	private BigDecimal	rrp_smlb2_100_rwa;
	private BigDecimal	rrp_smlb2_100_under_ccf_amt;
	private BigDecimal	rrp_smlb2_150_20_lcbg_balance;
	private BigDecimal	rrp_smlb2_150_20_acceptance_amount;
	private BigDecimal	rrp_smlb2_150_20_lcbg_crm;
	private BigDecimal	rrp_smlb2_150_20_rwa;
	private BigDecimal	rrp_smlb2_150_20_under_ccf_amt;
	private BigDecimal	rrp_smlb2_150_50_lcbg_balance;
	private BigDecimal	rrp_smlb2_150_50_acceptance_amount;
	private BigDecimal	rrp_smlb2_150_50_lcbg_crm;
	private BigDecimal	rrp_smlb2_150_50_rwa;
	private BigDecimal	rrp_smlb2_150_50_under_ccf_amt;
	private BigDecimal	rrp_smlb2_150_10_lcbg_balance;
	private BigDecimal	rrp_smlb2_150_10_acceptance_amount;
	private BigDecimal	rrp_smlb2_150_10_lcbg_crm;
	private BigDecimal	rrp_smlb2_150_10_rwa;
	private BigDecimal	rrp_smlb2_150_10_under_ccf_amt;
	private BigDecimal	rrp_smlb2_150_lcbg_balance;
	private BigDecimal	rrp_smlb2_150_acceptance_amount;
	private BigDecimal	rrp_smlb2_150_lcbg_crm;
	private BigDecimal	rrp_smlb2_150_rwa;
	private BigDecimal	rrp_smlb2_150_under_ccf_amt;
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
	public BigDecimal getHni_0_20_lcbg_balance() {
		return hni_0_20_lcbg_balance;
	}
	public void setHni_0_20_lcbg_balance(BigDecimal hni_0_20_lcbg_balance) {
		this.hni_0_20_lcbg_balance = hni_0_20_lcbg_balance;
	}
	public BigDecimal getHni_0_20_acceptance_amount() {
		return hni_0_20_acceptance_amount;
	}
	public void setHni_0_20_acceptance_amount(BigDecimal hni_0_20_acceptance_amount) {
		this.hni_0_20_acceptance_amount = hni_0_20_acceptance_amount;
	}
	public BigDecimal getHni_0_20_lcbg_crm() {
		return hni_0_20_lcbg_crm;
	}
	public void setHni_0_20_lcbg_crm(BigDecimal hni_0_20_lcbg_crm) {
		this.hni_0_20_lcbg_crm = hni_0_20_lcbg_crm;
	}
	public BigDecimal getHni_0_20_rwa() {
		return hni_0_20_rwa;
	}
	public void setHni_0_20_rwa(BigDecimal hni_0_20_rwa) {
		this.hni_0_20_rwa = hni_0_20_rwa;
	}
	public BigDecimal getHni_0_20_under_ccf_amt() {
		return hni_0_20_under_ccf_amt;
	}
	public void setHni_0_20_under_ccf_amt(BigDecimal hni_0_20_under_ccf_amt) {
		this.hni_0_20_under_ccf_amt = hni_0_20_under_ccf_amt;
	}
	public BigDecimal getHni_0_50_lcbg_balance() {
		return hni_0_50_lcbg_balance;
	}
	public void setHni_0_50_lcbg_balance(BigDecimal hni_0_50_lcbg_balance) {
		this.hni_0_50_lcbg_balance = hni_0_50_lcbg_balance;
	}
	public BigDecimal getHni_0_50_acceptance_amount() {
		return hni_0_50_acceptance_amount;
	}
	public void setHni_0_50_acceptance_amount(BigDecimal hni_0_50_acceptance_amount) {
		this.hni_0_50_acceptance_amount = hni_0_50_acceptance_amount;
	}
	public BigDecimal getHni_0_50_lcbg_crm() {
		return hni_0_50_lcbg_crm;
	}
	public void setHni_0_50_lcbg_crm(BigDecimal hni_0_50_lcbg_crm) {
		this.hni_0_50_lcbg_crm = hni_0_50_lcbg_crm;
	}
	public BigDecimal getHni_0_50_rwa() {
		return hni_0_50_rwa;
	}
	public void setHni_0_50_rwa(BigDecimal hni_0_50_rwa) {
		this.hni_0_50_rwa = hni_0_50_rwa;
	}
	public BigDecimal getHni_0_50_under_ccf_amt() {
		return hni_0_50_under_ccf_amt;
	}
	public void setHni_0_50_under_ccf_amt(BigDecimal hni_0_50_under_ccf_amt) {
		this.hni_0_50_under_ccf_amt = hni_0_50_under_ccf_amt;
	}
	public BigDecimal getHni_0_10_lcbg_balance() {
		return hni_0_10_lcbg_balance;
	}
	public void setHni_0_10_lcbg_balance(BigDecimal hni_0_10_lcbg_balance) {
		this.hni_0_10_lcbg_balance = hni_0_10_lcbg_balance;
	}
	public BigDecimal getHni_0_10_acceptance_amount() {
		return hni_0_10_acceptance_amount;
	}
	public void setHni_0_10_acceptance_amount(BigDecimal hni_0_10_acceptance_amount) {
		this.hni_0_10_acceptance_amount = hni_0_10_acceptance_amount;
	}
	public BigDecimal getHni_0_10_lcbg_crm() {
		return hni_0_10_lcbg_crm;
	}
	public void setHni_0_10_lcbg_crm(BigDecimal hni_0_10_lcbg_crm) {
		this.hni_0_10_lcbg_crm = hni_0_10_lcbg_crm;
	}
	public BigDecimal getHni_0_10_rwa() {
		return hni_0_10_rwa;
	}
	public void setHni_0_10_rwa(BigDecimal hni_0_10_rwa) {
		this.hni_0_10_rwa = hni_0_10_rwa;
	}
	public BigDecimal getHni_0_10_under_ccf_amt() {
		return hni_0_10_under_ccf_amt;
	}
	public void setHni_0_10_under_ccf_amt(BigDecimal hni_0_10_under_ccf_amt) {
		this.hni_0_10_under_ccf_amt = hni_0_10_under_ccf_amt;
	}
	public BigDecimal getHni_0_lcbg_balance() {
		return hni_0_lcbg_balance;
	}
	public void setHni_0_lcbg_balance(BigDecimal hni_0_lcbg_balance) {
		this.hni_0_lcbg_balance = hni_0_lcbg_balance;
	}
	public BigDecimal getHni_0_acceptance_amount() {
		return hni_0_acceptance_amount;
	}
	public void setHni_0_acceptance_amount(BigDecimal hni_0_acceptance_amount) {
		this.hni_0_acceptance_amount = hni_0_acceptance_amount;
	}
	public BigDecimal getHni_0_lcbg_crm() {
		return hni_0_lcbg_crm;
	}
	public void setHni_0_lcbg_crm(BigDecimal hni_0_lcbg_crm) {
		this.hni_0_lcbg_crm = hni_0_lcbg_crm;
	}
	public BigDecimal getHni_0_rwa() {
		return hni_0_rwa;
	}
	public void setHni_0_rwa(BigDecimal hni_0_rwa) {
		this.hni_0_rwa = hni_0_rwa;
	}
	public BigDecimal getHni_0_under_ccf_amt() {
		return hni_0_under_ccf_amt;
	}
	public void setHni_0_under_ccf_amt(BigDecimal hni_0_under_ccf_amt) {
		this.hni_0_under_ccf_amt = hni_0_under_ccf_amt;
	}
	public BigDecimal getHni_20_20_lcbg_balance() {
		return hni_20_20_lcbg_balance;
	}
	public void setHni_20_20_lcbg_balance(BigDecimal hni_20_20_lcbg_balance) {
		this.hni_20_20_lcbg_balance = hni_20_20_lcbg_balance;
	}
	public BigDecimal getHni_20_20_acceptance_amount() {
		return hni_20_20_acceptance_amount;
	}
	public void setHni_20_20_acceptance_amount(BigDecimal hni_20_20_acceptance_amount) {
		this.hni_20_20_acceptance_amount = hni_20_20_acceptance_amount;
	}
	public BigDecimal getHni_20_20_lcbg_crm() {
		return hni_20_20_lcbg_crm;
	}
	public void setHni_20_20_lcbg_crm(BigDecimal hni_20_20_lcbg_crm) {
		this.hni_20_20_lcbg_crm = hni_20_20_lcbg_crm;
	}
	public BigDecimal getHni_20_20_rwa() {
		return hni_20_20_rwa;
	}
	public void setHni_20_20_rwa(BigDecimal hni_20_20_rwa) {
		this.hni_20_20_rwa = hni_20_20_rwa;
	}
	public BigDecimal getHni_20_20_under_ccf_amt() {
		return hni_20_20_under_ccf_amt;
	}
	public void setHni_20_20_under_ccf_amt(BigDecimal hni_20_20_under_ccf_amt) {
		this.hni_20_20_under_ccf_amt = hni_20_20_under_ccf_amt;
	}
	public BigDecimal getHni_20_50_lcbg_balance() {
		return hni_20_50_lcbg_balance;
	}
	public void setHni_20_50_lcbg_balance(BigDecimal hni_20_50_lcbg_balance) {
		this.hni_20_50_lcbg_balance = hni_20_50_lcbg_balance;
	}
	public BigDecimal getHni_20_50_acceptance_amount() {
		return hni_20_50_acceptance_amount;
	}
	public void setHni_20_50_acceptance_amount(BigDecimal hni_20_50_acceptance_amount) {
		this.hni_20_50_acceptance_amount = hni_20_50_acceptance_amount;
	}
	public BigDecimal getHni_20_50_lcbg_crm() {
		return hni_20_50_lcbg_crm;
	}
	public void setHni_20_50_lcbg_crm(BigDecimal hni_20_50_lcbg_crm) {
		this.hni_20_50_lcbg_crm = hni_20_50_lcbg_crm;
	}
	public BigDecimal getHni_20_50_rwa() {
		return hni_20_50_rwa;
	}
	public void setHni_20_50_rwa(BigDecimal hni_20_50_rwa) {
		this.hni_20_50_rwa = hni_20_50_rwa;
	}
	public BigDecimal getHni_20_50_under_ccf_amt() {
		return hni_20_50_under_ccf_amt;
	}
	public void setHni_20_50_under_ccf_amt(BigDecimal hni_20_50_under_ccf_amt) {
		this.hni_20_50_under_ccf_amt = hni_20_50_under_ccf_amt;
	}
	public BigDecimal getHni_20_10_lcbg_balance() {
		return hni_20_10_lcbg_balance;
	}
	public void setHni_20_10_lcbg_balance(BigDecimal hni_20_10_lcbg_balance) {
		this.hni_20_10_lcbg_balance = hni_20_10_lcbg_balance;
	}
	public BigDecimal getHni_20_10_acceptance_amount() {
		return hni_20_10_acceptance_amount;
	}
	public void setHni_20_10_acceptance_amount(BigDecimal hni_20_10_acceptance_amount) {
		this.hni_20_10_acceptance_amount = hni_20_10_acceptance_amount;
	}
	public BigDecimal getHni_20_10_lcbg_crm() {
		return hni_20_10_lcbg_crm;
	}
	public void setHni_20_10_lcbg_crm(BigDecimal hni_20_10_lcbg_crm) {
		this.hni_20_10_lcbg_crm = hni_20_10_lcbg_crm;
	}
	public BigDecimal getHni_20_10_rwa() {
		return hni_20_10_rwa;
	}
	public void setHni_20_10_rwa(BigDecimal hni_20_10_rwa) {
		this.hni_20_10_rwa = hni_20_10_rwa;
	}
	public BigDecimal getHni_20_10_under_ccf_amt() {
		return hni_20_10_under_ccf_amt;
	}
	public void setHni_20_10_under_ccf_amt(BigDecimal hni_20_10_under_ccf_amt) {
		this.hni_20_10_under_ccf_amt = hni_20_10_under_ccf_amt;
	}
	public BigDecimal getHni_20_lcbg_balance() {
		return hni_20_lcbg_balance;
	}
	public void setHni_20_lcbg_balance(BigDecimal hni_20_lcbg_balance) {
		this.hni_20_lcbg_balance = hni_20_lcbg_balance;
	}
	public BigDecimal getHni_20_acceptance_amount() {
		return hni_20_acceptance_amount;
	}
	public void setHni_20_acceptance_amount(BigDecimal hni_20_acceptance_amount) {
		this.hni_20_acceptance_amount = hni_20_acceptance_amount;
	}
	public BigDecimal getHni_20_lcbg_crm() {
		return hni_20_lcbg_crm;
	}
	public void setHni_20_lcbg_crm(BigDecimal hni_20_lcbg_crm) {
		this.hni_20_lcbg_crm = hni_20_lcbg_crm;
	}
	public BigDecimal getHni_20_rwa() {
		return hni_20_rwa;
	}
	public void setHni_20_rwa(BigDecimal hni_20_rwa) {
		this.hni_20_rwa = hni_20_rwa;
	}
	public BigDecimal getHni_20_under_ccf_amt() {
		return hni_20_under_ccf_amt;
	}
	public void setHni_20_under_ccf_amt(BigDecimal hni_20_under_ccf_amt) {
		this.hni_20_under_ccf_amt = hni_20_under_ccf_amt;
	}
	public BigDecimal getHni_50_20_lcbg_balance() {
		return hni_50_20_lcbg_balance;
	}
	public void setHni_50_20_lcbg_balance(BigDecimal hni_50_20_lcbg_balance) {
		this.hni_50_20_lcbg_balance = hni_50_20_lcbg_balance;
	}
	public BigDecimal getHni_50_20_acceptance_amount() {
		return hni_50_20_acceptance_amount;
	}
	public void setHni_50_20_acceptance_amount(BigDecimal hni_50_20_acceptance_amount) {
		this.hni_50_20_acceptance_amount = hni_50_20_acceptance_amount;
	}
	public BigDecimal getHni_50_20_lcbg_crm() {
		return hni_50_20_lcbg_crm;
	}
	public void setHni_50_20_lcbg_crm(BigDecimal hni_50_20_lcbg_crm) {
		this.hni_50_20_lcbg_crm = hni_50_20_lcbg_crm;
	}
	public BigDecimal getHni_50_20_rwa() {
		return hni_50_20_rwa;
	}
	public void setHni_50_20_rwa(BigDecimal hni_50_20_rwa) {
		this.hni_50_20_rwa = hni_50_20_rwa;
	}
	public BigDecimal getHni_50_20_under_ccf_amt() {
		return hni_50_20_under_ccf_amt;
	}
	public void setHni_50_20_under_ccf_amt(BigDecimal hni_50_20_under_ccf_amt) {
		this.hni_50_20_under_ccf_amt = hni_50_20_under_ccf_amt;
	}
	public BigDecimal getHni_50_50_lcbg_balance() {
		return hni_50_50_lcbg_balance;
	}
	public void setHni_50_50_lcbg_balance(BigDecimal hni_50_50_lcbg_balance) {
		this.hni_50_50_lcbg_balance = hni_50_50_lcbg_balance;
	}
	public BigDecimal getHni_50_50_acceptance_amount() {
		return hni_50_50_acceptance_amount;
	}
	public void setHni_50_50_acceptance_amount(BigDecimal hni_50_50_acceptance_amount) {
		this.hni_50_50_acceptance_amount = hni_50_50_acceptance_amount;
	}
	public BigDecimal getHni_50_50_lcbg_crm() {
		return hni_50_50_lcbg_crm;
	}
	public void setHni_50_50_lcbg_crm(BigDecimal hni_50_50_lcbg_crm) {
		this.hni_50_50_lcbg_crm = hni_50_50_lcbg_crm;
	}
	public BigDecimal getHni_50_50_rwa() {
		return hni_50_50_rwa;
	}
	public void setHni_50_50_rwa(BigDecimal hni_50_50_rwa) {
		this.hni_50_50_rwa = hni_50_50_rwa;
	}
	public BigDecimal getHni_50_50_under_ccf_amt() {
		return hni_50_50_under_ccf_amt;
	}
	public void setHni_50_50_under_ccf_amt(BigDecimal hni_50_50_under_ccf_amt) {
		this.hni_50_50_under_ccf_amt = hni_50_50_under_ccf_amt;
	}
	public BigDecimal getHni_50_10_lcbg_balance() {
		return hni_50_10_lcbg_balance;
	}
	public void setHni_50_10_lcbg_balance(BigDecimal hni_50_10_lcbg_balance) {
		this.hni_50_10_lcbg_balance = hni_50_10_lcbg_balance;
	}
	public BigDecimal getHni_50_10_acceptance_amount() {
		return hni_50_10_acceptance_amount;
	}
	public void setHni_50_10_acceptance_amount(BigDecimal hni_50_10_acceptance_amount) {
		this.hni_50_10_acceptance_amount = hni_50_10_acceptance_amount;
	}
	public BigDecimal getHni_50_10_lcbg_crm() {
		return hni_50_10_lcbg_crm;
	}
	public void setHni_50_10_lcbg_crm(BigDecimal hni_50_10_lcbg_crm) {
		this.hni_50_10_lcbg_crm = hni_50_10_lcbg_crm;
	}
	public BigDecimal getHni_50_10_rwa() {
		return hni_50_10_rwa;
	}
	public void setHni_50_10_rwa(BigDecimal hni_50_10_rwa) {
		this.hni_50_10_rwa = hni_50_10_rwa;
	}
	public BigDecimal getHni_50_10_under_ccf_amt() {
		return hni_50_10_under_ccf_amt;
	}
	public void setHni_50_10_under_ccf_amt(BigDecimal hni_50_10_under_ccf_amt) {
		this.hni_50_10_under_ccf_amt = hni_50_10_under_ccf_amt;
	}
	public BigDecimal getHni_50_lcbg_balance() {
		return hni_50_lcbg_balance;
	}
	public void setHni_50_lcbg_balance(BigDecimal hni_50_lcbg_balance) {
		this.hni_50_lcbg_balance = hni_50_lcbg_balance;
	}
	public BigDecimal getHni_50_acceptance_amount() {
		return hni_50_acceptance_amount;
	}
	public void setHni_50_acceptance_amount(BigDecimal hni_50_acceptance_amount) {
		this.hni_50_acceptance_amount = hni_50_acceptance_amount;
	}
	public BigDecimal getHni_50_lcbg_crm() {
		return hni_50_lcbg_crm;
	}
	public void setHni_50_lcbg_crm(BigDecimal hni_50_lcbg_crm) {
		this.hni_50_lcbg_crm = hni_50_lcbg_crm;
	}
	public BigDecimal getHni_50_rwa() {
		return hni_50_rwa;
	}
	public void setHni_50_rwa(BigDecimal hni_50_rwa) {
		this.hni_50_rwa = hni_50_rwa;
	}
	public BigDecimal getHni_50_under_ccf_amt() {
		return hni_50_under_ccf_amt;
	}
	public void setHni_50_under_ccf_amt(BigDecimal hni_50_under_ccf_amt) {
		this.hni_50_under_ccf_amt = hni_50_under_ccf_amt;
	}
	public BigDecimal getHni_100_20_lcbg_balance() {
		return hni_100_20_lcbg_balance;
	}
	public void setHni_100_20_lcbg_balance(BigDecimal hni_100_20_lcbg_balance) {
		this.hni_100_20_lcbg_balance = hni_100_20_lcbg_balance;
	}
	public BigDecimal getHni_100_20_acceptance_amount() {
		return hni_100_20_acceptance_amount;
	}
	public void setHni_100_20_acceptance_amount(BigDecimal hni_100_20_acceptance_amount) {
		this.hni_100_20_acceptance_amount = hni_100_20_acceptance_amount;
	}
	public BigDecimal getHni_100_20_lcbg_crm() {
		return hni_100_20_lcbg_crm;
	}
	public void setHni_100_20_lcbg_crm(BigDecimal hni_100_20_lcbg_crm) {
		this.hni_100_20_lcbg_crm = hni_100_20_lcbg_crm;
	}
	public BigDecimal getHni_100_20_rwa() {
		return hni_100_20_rwa;
	}
	public void setHni_100_20_rwa(BigDecimal hni_100_20_rwa) {
		this.hni_100_20_rwa = hni_100_20_rwa;
	}
	public BigDecimal getHni_100_20_under_ccf_amt() {
		return hni_100_20_under_ccf_amt;
	}
	public void setHni_100_20_under_ccf_amt(BigDecimal hni_100_20_under_ccf_amt) {
		this.hni_100_20_under_ccf_amt = hni_100_20_under_ccf_amt;
	}
	public BigDecimal getHni_100_50_lcbg_balance() {
		return hni_100_50_lcbg_balance;
	}
	public void setHni_100_50_lcbg_balance(BigDecimal hni_100_50_lcbg_balance) {
		this.hni_100_50_lcbg_balance = hni_100_50_lcbg_balance;
	}
	public BigDecimal getHni_100_50_acceptance_amount() {
		return hni_100_50_acceptance_amount;
	}
	public void setHni_100_50_acceptance_amount(BigDecimal hni_100_50_acceptance_amount) {
		this.hni_100_50_acceptance_amount = hni_100_50_acceptance_amount;
	}
	public BigDecimal getHni_100_50_lcbg_crm() {
		return hni_100_50_lcbg_crm;
	}
	public void setHni_100_50_lcbg_crm(BigDecimal hni_100_50_lcbg_crm) {
		this.hni_100_50_lcbg_crm = hni_100_50_lcbg_crm;
	}
	public BigDecimal getHni_100_50_rwa() {
		return hni_100_50_rwa;
	}
	public void setHni_100_50_rwa(BigDecimal hni_100_50_rwa) {
		this.hni_100_50_rwa = hni_100_50_rwa;
	}
	public BigDecimal getHni_100_50_under_ccf_amt() {
		return hni_100_50_under_ccf_amt;
	}
	public void setHni_100_50_under_ccf_amt(BigDecimal hni_100_50_under_ccf_amt) {
		this.hni_100_50_under_ccf_amt = hni_100_50_under_ccf_amt;
	}
	public BigDecimal getHni_100_10_lcbg_balance() {
		return hni_100_10_lcbg_balance;
	}
	public void setHni_100_10_lcbg_balance(BigDecimal hni_100_10_lcbg_balance) {
		this.hni_100_10_lcbg_balance = hni_100_10_lcbg_balance;
	}
	public BigDecimal getHni_100_10_acceptance_amount() {
		return hni_100_10_acceptance_amount;
	}
	public void setHni_100_10_acceptance_amount(BigDecimal hni_100_10_acceptance_amount) {
		this.hni_100_10_acceptance_amount = hni_100_10_acceptance_amount;
	}
	public BigDecimal getHni_100_10_lcbg_crm() {
		return hni_100_10_lcbg_crm;
	}
	public void setHni_100_10_lcbg_crm(BigDecimal hni_100_10_lcbg_crm) {
		this.hni_100_10_lcbg_crm = hni_100_10_lcbg_crm;
	}
	public BigDecimal getHni_100_10_rwa() {
		return hni_100_10_rwa;
	}
	public void setHni_100_10_rwa(BigDecimal hni_100_10_rwa) {
		this.hni_100_10_rwa = hni_100_10_rwa;
	}
	public BigDecimal getHni_100_10_under_ccf_amt() {
		return hni_100_10_under_ccf_amt;
	}
	public void setHni_100_10_under_ccf_amt(BigDecimal hni_100_10_under_ccf_amt) {
		this.hni_100_10_under_ccf_amt = hni_100_10_under_ccf_amt;
	}
	public BigDecimal getHni_100_lcbg_balance() {
		return hni_100_lcbg_balance;
	}
	public void setHni_100_lcbg_balance(BigDecimal hni_100_lcbg_balance) {
		this.hni_100_lcbg_balance = hni_100_lcbg_balance;
	}
	public BigDecimal getHni_100_acceptance_amount() {
		return hni_100_acceptance_amount;
	}
	public void setHni_100_acceptance_amount(BigDecimal hni_100_acceptance_amount) {
		this.hni_100_acceptance_amount = hni_100_acceptance_amount;
	}
	public BigDecimal getHni_100_lcbg_crm() {
		return hni_100_lcbg_crm;
	}
	public void setHni_100_lcbg_crm(BigDecimal hni_100_lcbg_crm) {
		this.hni_100_lcbg_crm = hni_100_lcbg_crm;
	}
	public BigDecimal getHni_100_rwa() {
		return hni_100_rwa;
	}
	public void setHni_100_rwa(BigDecimal hni_100_rwa) {
		this.hni_100_rwa = hni_100_rwa;
	}
	public BigDecimal getHni_100_under_ccf_amt() {
		return hni_100_under_ccf_amt;
	}
	public void setHni_100_under_ccf_amt(BigDecimal hni_100_under_ccf_amt) {
		this.hni_100_under_ccf_amt = hni_100_under_ccf_amt;
	}
	public BigDecimal getHni_150_20_lcbg_balance() {
		return hni_150_20_lcbg_balance;
	}
	public void setHni_150_20_lcbg_balance(BigDecimal hni_150_20_lcbg_balance) {
		this.hni_150_20_lcbg_balance = hni_150_20_lcbg_balance;
	}
	public BigDecimal getHni_150_20_acceptance_amount() {
		return hni_150_20_acceptance_amount;
	}
	public void setHni_150_20_acceptance_amount(BigDecimal hni_150_20_acceptance_amount) {
		this.hni_150_20_acceptance_amount = hni_150_20_acceptance_amount;
	}
	public BigDecimal getHni_150_20_lcbg_crm() {
		return hni_150_20_lcbg_crm;
	}
	public void setHni_150_20_lcbg_crm(BigDecimal hni_150_20_lcbg_crm) {
		this.hni_150_20_lcbg_crm = hni_150_20_lcbg_crm;
	}
	public BigDecimal getHni_150_20_rwa() {
		return hni_150_20_rwa;
	}
	public void setHni_150_20_rwa(BigDecimal hni_150_20_rwa) {
		this.hni_150_20_rwa = hni_150_20_rwa;
	}
	public BigDecimal getHni_150_20_under_ccf_amt() {
		return hni_150_20_under_ccf_amt;
	}
	public void setHni_150_20_under_ccf_amt(BigDecimal hni_150_20_under_ccf_amt) {
		this.hni_150_20_under_ccf_amt = hni_150_20_under_ccf_amt;
	}
	public BigDecimal getHni_150_50_lcbg_balance() {
		return hni_150_50_lcbg_balance;
	}
	public void setHni_150_50_lcbg_balance(BigDecimal hni_150_50_lcbg_balance) {
		this.hni_150_50_lcbg_balance = hni_150_50_lcbg_balance;
	}
	public BigDecimal getHni_150_50_acceptance_amount() {
		return hni_150_50_acceptance_amount;
	}
	public void setHni_150_50_acceptance_amount(BigDecimal hni_150_50_acceptance_amount) {
		this.hni_150_50_acceptance_amount = hni_150_50_acceptance_amount;
	}
	public BigDecimal getHni_150_50_lcbg_crm() {
		return hni_150_50_lcbg_crm;
	}
	public void setHni_150_50_lcbg_crm(BigDecimal hni_150_50_lcbg_crm) {
		this.hni_150_50_lcbg_crm = hni_150_50_lcbg_crm;
	}
	public BigDecimal getHni_150_50_rwa() {
		return hni_150_50_rwa;
	}
	public void setHni_150_50_rwa(BigDecimal hni_150_50_rwa) {
		this.hni_150_50_rwa = hni_150_50_rwa;
	}
	public BigDecimal getHni_150_50_under_ccf_amt() {
		return hni_150_50_under_ccf_amt;
	}
	public void setHni_150_50_under_ccf_amt(BigDecimal hni_150_50_under_ccf_amt) {
		this.hni_150_50_under_ccf_amt = hni_150_50_under_ccf_amt;
	}
	public BigDecimal getHni_150_10_lcbg_balance() {
		return hni_150_10_lcbg_balance;
	}
	public void setHni_150_10_lcbg_balance(BigDecimal hni_150_10_lcbg_balance) {
		this.hni_150_10_lcbg_balance = hni_150_10_lcbg_balance;
	}
	public BigDecimal getHni_150_10_acceptance_amount() {
		return hni_150_10_acceptance_amount;
	}
	public void setHni_150_10_acceptance_amount(BigDecimal hni_150_10_acceptance_amount) {
		this.hni_150_10_acceptance_amount = hni_150_10_acceptance_amount;
	}
	public BigDecimal getHni_150_10_lcbg_crm() {
		return hni_150_10_lcbg_crm;
	}
	public void setHni_150_10_lcbg_crm(BigDecimal hni_150_10_lcbg_crm) {
		this.hni_150_10_lcbg_crm = hni_150_10_lcbg_crm;
	}
	public BigDecimal getHni_150_10_rwa() {
		return hni_150_10_rwa;
	}
	public void setHni_150_10_rwa(BigDecimal hni_150_10_rwa) {
		this.hni_150_10_rwa = hni_150_10_rwa;
	}
	public BigDecimal getHni_150_10_under_ccf_amt() {
		return hni_150_10_under_ccf_amt;
	}
	public void setHni_150_10_under_ccf_amt(BigDecimal hni_150_10_under_ccf_amt) {
		this.hni_150_10_under_ccf_amt = hni_150_10_under_ccf_amt;
	}
	public BigDecimal getHni_150_lcbg_balance() {
		return hni_150_lcbg_balance;
	}
	public void setHni_150_lcbg_balance(BigDecimal hni_150_lcbg_balance) {
		this.hni_150_lcbg_balance = hni_150_lcbg_balance;
	}
	public BigDecimal getHni_150_acceptance_amount() {
		return hni_150_acceptance_amount;
	}
	public void setHni_150_acceptance_amount(BigDecimal hni_150_acceptance_amount) {
		this.hni_150_acceptance_amount = hni_150_acceptance_amount;
	}
	public BigDecimal getHni_150_lcbg_crm() {
		return hni_150_lcbg_crm;
	}
	public void setHni_150_lcbg_crm(BigDecimal hni_150_lcbg_crm) {
		this.hni_150_lcbg_crm = hni_150_lcbg_crm;
	}
	public BigDecimal getHni_150_rwa() {
		return hni_150_rwa;
	}
	public void setHni_150_rwa(BigDecimal hni_150_rwa) {
		this.hni_150_rwa = hni_150_rwa;
	}
	public BigDecimal getHni_150_under_ccf_amt() {
		return hni_150_under_ccf_amt;
	}
	public void setHni_150_under_ccf_amt(BigDecimal hni_150_under_ccf_amt) {
		this.hni_150_under_ccf_amt = hni_150_under_ccf_amt;
	}
	public BigDecimal getPdl_0_20_lcbg_balance() {
		return pdl_0_20_lcbg_balance;
	}
	public void setPdl_0_20_lcbg_balance(BigDecimal pdl_0_20_lcbg_balance) {
		this.pdl_0_20_lcbg_balance = pdl_0_20_lcbg_balance;
	}
	public BigDecimal getPdl_0_20_acceptance_amount() {
		return pdl_0_20_acceptance_amount;
	}
	public void setPdl_0_20_acceptance_amount(BigDecimal pdl_0_20_acceptance_amount) {
		this.pdl_0_20_acceptance_amount = pdl_0_20_acceptance_amount;
	}
	public BigDecimal getPdl_0_20_lcbg_crm() {
		return pdl_0_20_lcbg_crm;
	}
	public void setPdl_0_20_lcbg_crm(BigDecimal pdl_0_20_lcbg_crm) {
		this.pdl_0_20_lcbg_crm = pdl_0_20_lcbg_crm;
	}
	public BigDecimal getPdl_0_20_rwa() {
		return pdl_0_20_rwa;
	}
	public void setPdl_0_20_rwa(BigDecimal pdl_0_20_rwa) {
		this.pdl_0_20_rwa = pdl_0_20_rwa;
	}
	public BigDecimal getPdl_0_20_under_ccf_amt() {
		return pdl_0_20_under_ccf_amt;
	}
	public void setPdl_0_20_under_ccf_amt(BigDecimal pdl_0_20_under_ccf_amt) {
		this.pdl_0_20_under_ccf_amt = pdl_0_20_under_ccf_amt;
	}
	public BigDecimal getPdl_0_50_lcbg_balance() {
		return pdl_0_50_lcbg_balance;
	}
	public void setPdl_0_50_lcbg_balance(BigDecimal pdl_0_50_lcbg_balance) {
		this.pdl_0_50_lcbg_balance = pdl_0_50_lcbg_balance;
	}
	public BigDecimal getPdl_0_50_acceptance_amount() {
		return pdl_0_50_acceptance_amount;
	}
	public void setPdl_0_50_acceptance_amount(BigDecimal pdl_0_50_acceptance_amount) {
		this.pdl_0_50_acceptance_amount = pdl_0_50_acceptance_amount;
	}
	public BigDecimal getPdl_0_50_lcbg_crm() {
		return pdl_0_50_lcbg_crm;
	}
	public void setPdl_0_50_lcbg_crm(BigDecimal pdl_0_50_lcbg_crm) {
		this.pdl_0_50_lcbg_crm = pdl_0_50_lcbg_crm;
	}
	public BigDecimal getPdl_0_50_rwa() {
		return pdl_0_50_rwa;
	}
	public void setPdl_0_50_rwa(BigDecimal pdl_0_50_rwa) {
		this.pdl_0_50_rwa = pdl_0_50_rwa;
	}
	public BigDecimal getPdl_0_50_under_ccf_amt() {
		return pdl_0_50_under_ccf_amt;
	}
	public void setPdl_0_50_under_ccf_amt(BigDecimal pdl_0_50_under_ccf_amt) {
		this.pdl_0_50_under_ccf_amt = pdl_0_50_under_ccf_amt;
	}
	public BigDecimal getPdl_0_10_lcbg_balance() {
		return pdl_0_10_lcbg_balance;
	}
	public void setPdl_0_10_lcbg_balance(BigDecimal pdl_0_10_lcbg_balance) {
		this.pdl_0_10_lcbg_balance = pdl_0_10_lcbg_balance;
	}
	public BigDecimal getPdl_0_10_acceptance_amount() {
		return pdl_0_10_acceptance_amount;
	}
	public void setPdl_0_10_acceptance_amount(BigDecimal pdl_0_10_acceptance_amount) {
		this.pdl_0_10_acceptance_amount = pdl_0_10_acceptance_amount;
	}
	public BigDecimal getPdl_0_10_lcbg_crm() {
		return pdl_0_10_lcbg_crm;
	}
	public void setPdl_0_10_lcbg_crm(BigDecimal pdl_0_10_lcbg_crm) {
		this.pdl_0_10_lcbg_crm = pdl_0_10_lcbg_crm;
	}
	public BigDecimal getPdl_0_10_rwa() {
		return pdl_0_10_rwa;
	}
	public void setPdl_0_10_rwa(BigDecimal pdl_0_10_rwa) {
		this.pdl_0_10_rwa = pdl_0_10_rwa;
	}
	public BigDecimal getPdl_0_10_under_ccf_amt() {
		return pdl_0_10_under_ccf_amt;
	}
	public void setPdl_0_10_under_ccf_amt(BigDecimal pdl_0_10_under_ccf_amt) {
		this.pdl_0_10_under_ccf_amt = pdl_0_10_under_ccf_amt;
	}
	public BigDecimal getPdl_0_lcbg_balance() {
		return pdl_0_lcbg_balance;
	}
	public void setPdl_0_lcbg_balance(BigDecimal pdl_0_lcbg_balance) {
		this.pdl_0_lcbg_balance = pdl_0_lcbg_balance;
	}
	public BigDecimal getPdl_0_acceptance_amount() {
		return pdl_0_acceptance_amount;
	}
	public void setPdl_0_acceptance_amount(BigDecimal pdl_0_acceptance_amount) {
		this.pdl_0_acceptance_amount = pdl_0_acceptance_amount;
	}
	public BigDecimal getPdl_0_lcbg_crm() {
		return pdl_0_lcbg_crm;
	}
	public void setPdl_0_lcbg_crm(BigDecimal pdl_0_lcbg_crm) {
		this.pdl_0_lcbg_crm = pdl_0_lcbg_crm;
	}
	public BigDecimal getPdl_0_rwa() {
		return pdl_0_rwa;
	}
	public void setPdl_0_rwa(BigDecimal pdl_0_rwa) {
		this.pdl_0_rwa = pdl_0_rwa;
	}
	public BigDecimal getPdl_0_under_ccf_amt() {
		return pdl_0_under_ccf_amt;
	}
	public void setPdl_0_under_ccf_amt(BigDecimal pdl_0_under_ccf_amt) {
		this.pdl_0_under_ccf_amt = pdl_0_under_ccf_amt;
	}
	public BigDecimal getPdl_20_20_lcbg_balance() {
		return pdl_20_20_lcbg_balance;
	}
	public void setPdl_20_20_lcbg_balance(BigDecimal pdl_20_20_lcbg_balance) {
		this.pdl_20_20_lcbg_balance = pdl_20_20_lcbg_balance;
	}
	public BigDecimal getPdl_20_20_acceptance_amount() {
		return pdl_20_20_acceptance_amount;
	}
	public void setPdl_20_20_acceptance_amount(BigDecimal pdl_20_20_acceptance_amount) {
		this.pdl_20_20_acceptance_amount = pdl_20_20_acceptance_amount;
	}
	public BigDecimal getPdl_20_20_lcbg_crm() {
		return pdl_20_20_lcbg_crm;
	}
	public void setPdl_20_20_lcbg_crm(BigDecimal pdl_20_20_lcbg_crm) {
		this.pdl_20_20_lcbg_crm = pdl_20_20_lcbg_crm;
	}
	public BigDecimal getPdl_20_20_rwa() {
		return pdl_20_20_rwa;
	}
	public void setPdl_20_20_rwa(BigDecimal pdl_20_20_rwa) {
		this.pdl_20_20_rwa = pdl_20_20_rwa;
	}
	public BigDecimal getPdl_20_20_under_ccf_amt() {
		return pdl_20_20_under_ccf_amt;
	}
	public void setPdl_20_20_under_ccf_amt(BigDecimal pdl_20_20_under_ccf_amt) {
		this.pdl_20_20_under_ccf_amt = pdl_20_20_under_ccf_amt;
	}
	public BigDecimal getPdl_20_50_lcbg_balance() {
		return pdl_20_50_lcbg_balance;
	}
	public void setPdl_20_50_lcbg_balance(BigDecimal pdl_20_50_lcbg_balance) {
		this.pdl_20_50_lcbg_balance = pdl_20_50_lcbg_balance;
	}
	public BigDecimal getPdl_20_50_acceptance_amount() {
		return pdl_20_50_acceptance_amount;
	}
	public void setPdl_20_50_acceptance_amount(BigDecimal pdl_20_50_acceptance_amount) {
		this.pdl_20_50_acceptance_amount = pdl_20_50_acceptance_amount;
	}
	public BigDecimal getPdl_20_50_lcbg_crm() {
		return pdl_20_50_lcbg_crm;
	}
	public void setPdl_20_50_lcbg_crm(BigDecimal pdl_20_50_lcbg_crm) {
		this.pdl_20_50_lcbg_crm = pdl_20_50_lcbg_crm;
	}
	public BigDecimal getPdl_20_50_rwa() {
		return pdl_20_50_rwa;
	}
	public void setPdl_20_50_rwa(BigDecimal pdl_20_50_rwa) {
		this.pdl_20_50_rwa = pdl_20_50_rwa;
	}
	public BigDecimal getPdl_20_50_under_ccf_amt() {
		return pdl_20_50_under_ccf_amt;
	}
	public void setPdl_20_50_under_ccf_amt(BigDecimal pdl_20_50_under_ccf_amt) {
		this.pdl_20_50_under_ccf_amt = pdl_20_50_under_ccf_amt;
	}
	public BigDecimal getPdl_20_10_lcbg_balance() {
		return pdl_20_10_lcbg_balance;
	}
	public void setPdl_20_10_lcbg_balance(BigDecimal pdl_20_10_lcbg_balance) {
		this.pdl_20_10_lcbg_balance = pdl_20_10_lcbg_balance;
	}
	public BigDecimal getPdl_20_10_acceptance_amount() {
		return pdl_20_10_acceptance_amount;
	}
	public void setPdl_20_10_acceptance_amount(BigDecimal pdl_20_10_acceptance_amount) {
		this.pdl_20_10_acceptance_amount = pdl_20_10_acceptance_amount;
	}
	public BigDecimal getPdl_20_10_lcbg_crm() {
		return pdl_20_10_lcbg_crm;
	}
	public void setPdl_20_10_lcbg_crm(BigDecimal pdl_20_10_lcbg_crm) {
		this.pdl_20_10_lcbg_crm = pdl_20_10_lcbg_crm;
	}
	public BigDecimal getPdl_20_10_rwa() {
		return pdl_20_10_rwa;
	}
	public void setPdl_20_10_rwa(BigDecimal pdl_20_10_rwa) {
		this.pdl_20_10_rwa = pdl_20_10_rwa;
	}
	public BigDecimal getPdl_20_10_under_ccf_amt() {
		return pdl_20_10_under_ccf_amt;
	}
	public void setPdl_20_10_under_ccf_amt(BigDecimal pdl_20_10_under_ccf_amt) {
		this.pdl_20_10_under_ccf_amt = pdl_20_10_under_ccf_amt;
	}
	public BigDecimal getPdl_20_lcbg_balance() {
		return pdl_20_lcbg_balance;
	}
	public void setPdl_20_lcbg_balance(BigDecimal pdl_20_lcbg_balance) {
		this.pdl_20_lcbg_balance = pdl_20_lcbg_balance;
	}
	public BigDecimal getPdl_20_acceptance_amount() {
		return pdl_20_acceptance_amount;
	}
	public void setPdl_20_acceptance_amount(BigDecimal pdl_20_acceptance_amount) {
		this.pdl_20_acceptance_amount = pdl_20_acceptance_amount;
	}
	public BigDecimal getPdl_20_lcbg_crm() {
		return pdl_20_lcbg_crm;
	}
	public void setPdl_20_lcbg_crm(BigDecimal pdl_20_lcbg_crm) {
		this.pdl_20_lcbg_crm = pdl_20_lcbg_crm;
	}
	public BigDecimal getPdl_20_rwa() {
		return pdl_20_rwa;
	}
	public void setPdl_20_rwa(BigDecimal pdl_20_rwa) {
		this.pdl_20_rwa = pdl_20_rwa;
	}
	public BigDecimal getPdl_20_under_ccf_amt() {
		return pdl_20_under_ccf_amt;
	}
	public void setPdl_20_under_ccf_amt(BigDecimal pdl_20_under_ccf_amt) {
		this.pdl_20_under_ccf_amt = pdl_20_under_ccf_amt;
	}
	public BigDecimal getPdl_50_20_lcbg_balance() {
		return pdl_50_20_lcbg_balance;
	}
	public void setPdl_50_20_lcbg_balance(BigDecimal pdl_50_20_lcbg_balance) {
		this.pdl_50_20_lcbg_balance = pdl_50_20_lcbg_balance;
	}
	public BigDecimal getPdl_50_20_acceptance_amount() {
		return pdl_50_20_acceptance_amount;
	}
	public void setPdl_50_20_acceptance_amount(BigDecimal pdl_50_20_acceptance_amount) {
		this.pdl_50_20_acceptance_amount = pdl_50_20_acceptance_amount;
	}
	public BigDecimal getPdl_50_20_lcbg_crm() {
		return pdl_50_20_lcbg_crm;
	}
	public void setPdl_50_20_lcbg_crm(BigDecimal pdl_50_20_lcbg_crm) {
		this.pdl_50_20_lcbg_crm = pdl_50_20_lcbg_crm;
	}
	public BigDecimal getPdl_50_20_rwa() {
		return pdl_50_20_rwa;
	}
	public void setPdl_50_20_rwa(BigDecimal pdl_50_20_rwa) {
		this.pdl_50_20_rwa = pdl_50_20_rwa;
	}
	public BigDecimal getPdl_50_20_under_ccf_amt() {
		return pdl_50_20_under_ccf_amt;
	}
	public void setPdl_50_20_under_ccf_amt(BigDecimal pdl_50_20_under_ccf_amt) {
		this.pdl_50_20_under_ccf_amt = pdl_50_20_under_ccf_amt;
	}
	public BigDecimal getPdl_50_50_lcbg_balance() {
		return pdl_50_50_lcbg_balance;
	}
	public void setPdl_50_50_lcbg_balance(BigDecimal pdl_50_50_lcbg_balance) {
		this.pdl_50_50_lcbg_balance = pdl_50_50_lcbg_balance;
	}
	public BigDecimal getPdl_50_50_acceptance_amount() {
		return pdl_50_50_acceptance_amount;
	}
	public void setPdl_50_50_acceptance_amount(BigDecimal pdl_50_50_acceptance_amount) {
		this.pdl_50_50_acceptance_amount = pdl_50_50_acceptance_amount;
	}
	public BigDecimal getPdl_50_50_lcbg_crm() {
		return pdl_50_50_lcbg_crm;
	}
	public void setPdl_50_50_lcbg_crm(BigDecimal pdl_50_50_lcbg_crm) {
		this.pdl_50_50_lcbg_crm = pdl_50_50_lcbg_crm;
	}
	public BigDecimal getPdl_50_50_rwa() {
		return pdl_50_50_rwa;
	}
	public void setPdl_50_50_rwa(BigDecimal pdl_50_50_rwa) {
		this.pdl_50_50_rwa = pdl_50_50_rwa;
	}
	public BigDecimal getPdl_50_50_under_ccf_amt() {
		return pdl_50_50_under_ccf_amt;
	}
	public void setPdl_50_50_under_ccf_amt(BigDecimal pdl_50_50_under_ccf_amt) {
		this.pdl_50_50_under_ccf_amt = pdl_50_50_under_ccf_amt;
	}
	public BigDecimal getPdl_50_10_lcbg_balance() {
		return pdl_50_10_lcbg_balance;
	}
	public void setPdl_50_10_lcbg_balance(BigDecimal pdl_50_10_lcbg_balance) {
		this.pdl_50_10_lcbg_balance = pdl_50_10_lcbg_balance;
	}
	public BigDecimal getPdl_50_10_acceptance_amount() {
		return pdl_50_10_acceptance_amount;
	}
	public void setPdl_50_10_acceptance_amount(BigDecimal pdl_50_10_acceptance_amount) {
		this.pdl_50_10_acceptance_amount = pdl_50_10_acceptance_amount;
	}
	public BigDecimal getPdl_50_10_lcbg_crm() {
		return pdl_50_10_lcbg_crm;
	}
	public void setPdl_50_10_lcbg_crm(BigDecimal pdl_50_10_lcbg_crm) {
		this.pdl_50_10_lcbg_crm = pdl_50_10_lcbg_crm;
	}
	public BigDecimal getPdl_50_10_rwa() {
		return pdl_50_10_rwa;
	}
	public void setPdl_50_10_rwa(BigDecimal pdl_50_10_rwa) {
		this.pdl_50_10_rwa = pdl_50_10_rwa;
	}
	public BigDecimal getPdl_50_10_under_ccf_amt() {
		return pdl_50_10_under_ccf_amt;
	}
	public void setPdl_50_10_under_ccf_amt(BigDecimal pdl_50_10_under_ccf_amt) {
		this.pdl_50_10_under_ccf_amt = pdl_50_10_under_ccf_amt;
	}
	public BigDecimal getPdl_50_lcbg_balance() {
		return pdl_50_lcbg_balance;
	}
	public void setPdl_50_lcbg_balance(BigDecimal pdl_50_lcbg_balance) {
		this.pdl_50_lcbg_balance = pdl_50_lcbg_balance;
	}
	public BigDecimal getPdl_50_acceptance_amount() {
		return pdl_50_acceptance_amount;
	}
	public void setPdl_50_acceptance_amount(BigDecimal pdl_50_acceptance_amount) {
		this.pdl_50_acceptance_amount = pdl_50_acceptance_amount;
	}
	public BigDecimal getPdl_50_lcbg_crm() {
		return pdl_50_lcbg_crm;
	}
	public void setPdl_50_lcbg_crm(BigDecimal pdl_50_lcbg_crm) {
		this.pdl_50_lcbg_crm = pdl_50_lcbg_crm;
	}
	public BigDecimal getPdl_50_rwa() {
		return pdl_50_rwa;
	}
	public void setPdl_50_rwa(BigDecimal pdl_50_rwa) {
		this.pdl_50_rwa = pdl_50_rwa;
	}
	public BigDecimal getPdl_50_under_ccf_amt() {
		return pdl_50_under_ccf_amt;
	}
	public void setPdl_50_under_ccf_amt(BigDecimal pdl_50_under_ccf_amt) {
		this.pdl_50_under_ccf_amt = pdl_50_under_ccf_amt;
	}
	public BigDecimal getRes_0_20_lcbg_balance() {
		return res_0_20_lcbg_balance;
	}
	public void setRes_0_20_lcbg_balance(BigDecimal res_0_20_lcbg_balance) {
		this.res_0_20_lcbg_balance = res_0_20_lcbg_balance;
	}
	public BigDecimal getRes_0_20_acceptance_amount() {
		return res_0_20_acceptance_amount;
	}
	public void setRes_0_20_acceptance_amount(BigDecimal res_0_20_acceptance_amount) {
		this.res_0_20_acceptance_amount = res_0_20_acceptance_amount;
	}
	public BigDecimal getRes_0_20_lcbg_crm() {
		return res_0_20_lcbg_crm;
	}
	public void setRes_0_20_lcbg_crm(BigDecimal res_0_20_lcbg_crm) {
		this.res_0_20_lcbg_crm = res_0_20_lcbg_crm;
	}
	public BigDecimal getRes_0_20_rwa() {
		return res_0_20_rwa;
	}
	public void setRes_0_20_rwa(BigDecimal res_0_20_rwa) {
		this.res_0_20_rwa = res_0_20_rwa;
	}
	public BigDecimal getRes_0_20_under_ccf_amt() {
		return res_0_20_under_ccf_amt;
	}
	public void setRes_0_20_under_ccf_amt(BigDecimal res_0_20_under_ccf_amt) {
		this.res_0_20_under_ccf_amt = res_0_20_under_ccf_amt;
	}
	public BigDecimal getRes_0_50_lcbg_balance() {
		return res_0_50_lcbg_balance;
	}
	public void setRes_0_50_lcbg_balance(BigDecimal res_0_50_lcbg_balance) {
		this.res_0_50_lcbg_balance = res_0_50_lcbg_balance;
	}
	public BigDecimal getRes_0_50_acceptance_amount() {
		return res_0_50_acceptance_amount;
	}
	public void setRes_0_50_acceptance_amount(BigDecimal res_0_50_acceptance_amount) {
		this.res_0_50_acceptance_amount = res_0_50_acceptance_amount;
	}
	public BigDecimal getRes_0_50_lcbg_crm() {
		return res_0_50_lcbg_crm;
	}
	public void setRes_0_50_lcbg_crm(BigDecimal res_0_50_lcbg_crm) {
		this.res_0_50_lcbg_crm = res_0_50_lcbg_crm;
	}
	public BigDecimal getRes_0_50_rwa() {
		return res_0_50_rwa;
	}
	public void setRes_0_50_rwa(BigDecimal res_0_50_rwa) {
		this.res_0_50_rwa = res_0_50_rwa;
	}
	public BigDecimal getRes_0_50_under_ccf_amt() {
		return res_0_50_under_ccf_amt;
	}
	public void setRes_0_50_under_ccf_amt(BigDecimal res_0_50_under_ccf_amt) {
		this.res_0_50_under_ccf_amt = res_0_50_under_ccf_amt;
	}
	public BigDecimal getRes_0_10_lcbg_balance() {
		return res_0_10_lcbg_balance;
	}
	public void setRes_0_10_lcbg_balance(BigDecimal res_0_10_lcbg_balance) {
		this.res_0_10_lcbg_balance = res_0_10_lcbg_balance;
	}
	public BigDecimal getRes_0_10_acceptance_amount() {
		return res_0_10_acceptance_amount;
	}
	public void setRes_0_10_acceptance_amount(BigDecimal res_0_10_acceptance_amount) {
		this.res_0_10_acceptance_amount = res_0_10_acceptance_amount;
	}
	public BigDecimal getRes_0_10_lcbg_crm() {
		return res_0_10_lcbg_crm;
	}
	public void setRes_0_10_lcbg_crm(BigDecimal res_0_10_lcbg_crm) {
		this.res_0_10_lcbg_crm = res_0_10_lcbg_crm;
	}
	public BigDecimal getRes_0_10_rwa() {
		return res_0_10_rwa;
	}
	public void setRes_0_10_rwa(BigDecimal res_0_10_rwa) {
		this.res_0_10_rwa = res_0_10_rwa;
	}
	public BigDecimal getRes_0_10_under_ccf_amt() {
		return res_0_10_under_ccf_amt;
	}
	public void setRes_0_10_under_ccf_amt(BigDecimal res_0_10_under_ccf_amt) {
		this.res_0_10_under_ccf_amt = res_0_10_under_ccf_amt;
	}
	public BigDecimal getRes_0_lcbg_balance() {
		return res_0_lcbg_balance;
	}
	public void setRes_0_lcbg_balance(BigDecimal res_0_lcbg_balance) {
		this.res_0_lcbg_balance = res_0_lcbg_balance;
	}
	public BigDecimal getRes_0_acceptance_amount() {
		return res_0_acceptance_amount;
	}
	public void setRes_0_acceptance_amount(BigDecimal res_0_acceptance_amount) {
		this.res_0_acceptance_amount = res_0_acceptance_amount;
	}
	public BigDecimal getRes_0_lcbg_crm() {
		return res_0_lcbg_crm;
	}
	public void setRes_0_lcbg_crm(BigDecimal res_0_lcbg_crm) {
		this.res_0_lcbg_crm = res_0_lcbg_crm;
	}
	public BigDecimal getRes_0_rwa() {
		return res_0_rwa;
	}
	public void setRes_0_rwa(BigDecimal res_0_rwa) {
		this.res_0_rwa = res_0_rwa;
	}
	public BigDecimal getRes_0_under_ccf_amt() {
		return res_0_under_ccf_amt;
	}
	public void setRes_0_under_ccf_amt(BigDecimal res_0_under_ccf_amt) {
		this.res_0_under_ccf_amt = res_0_under_ccf_amt;
	}
	public BigDecimal getRes_20_20_lcbg_balance() {
		return res_20_20_lcbg_balance;
	}
	public void setRes_20_20_lcbg_balance(BigDecimal res_20_20_lcbg_balance) {
		this.res_20_20_lcbg_balance = res_20_20_lcbg_balance;
	}
	public BigDecimal getRes_20_20_acceptance_amount() {
		return res_20_20_acceptance_amount;
	}
	public void setRes_20_20_acceptance_amount(BigDecimal res_20_20_acceptance_amount) {
		this.res_20_20_acceptance_amount = res_20_20_acceptance_amount;
	}
	public BigDecimal getRes_20_20_lcbg_crm() {
		return res_20_20_lcbg_crm;
	}
	public void setRes_20_20_lcbg_crm(BigDecimal res_20_20_lcbg_crm) {
		this.res_20_20_lcbg_crm = res_20_20_lcbg_crm;
	}
	public BigDecimal getRes_20_20_rwa() {
		return res_20_20_rwa;
	}
	public void setRes_20_20_rwa(BigDecimal res_20_20_rwa) {
		this.res_20_20_rwa = res_20_20_rwa;
	}
	public BigDecimal getRes_20_20_under_ccf_amt() {
		return res_20_20_under_ccf_amt;
	}
	public void setRes_20_20_under_ccf_amt(BigDecimal res_20_20_under_ccf_amt) {
		this.res_20_20_under_ccf_amt = res_20_20_under_ccf_amt;
	}
	public BigDecimal getRes_20_50_lcbg_balance() {
		return res_20_50_lcbg_balance;
	}
	public void setRes_20_50_lcbg_balance(BigDecimal res_20_50_lcbg_balance) {
		this.res_20_50_lcbg_balance = res_20_50_lcbg_balance;
	}
	public BigDecimal getRes_20_50_acceptance_amount() {
		return res_20_50_acceptance_amount;
	}
	public void setRes_20_50_acceptance_amount(BigDecimal res_20_50_acceptance_amount) {
		this.res_20_50_acceptance_amount = res_20_50_acceptance_amount;
	}
	public BigDecimal getRes_20_50_lcbg_crm() {
		return res_20_50_lcbg_crm;
	}
	public void setRes_20_50_lcbg_crm(BigDecimal res_20_50_lcbg_crm) {
		this.res_20_50_lcbg_crm = res_20_50_lcbg_crm;
	}
	public BigDecimal getRes_20_50_rwa() {
		return res_20_50_rwa;
	}
	public void setRes_20_50_rwa(BigDecimal res_20_50_rwa) {
		this.res_20_50_rwa = res_20_50_rwa;
	}
	public BigDecimal getRes_20_50_under_ccf_amt() {
		return res_20_50_under_ccf_amt;
	}
	public void setRes_20_50_under_ccf_amt(BigDecimal res_20_50_under_ccf_amt) {
		this.res_20_50_under_ccf_amt = res_20_50_under_ccf_amt;
	}
	public BigDecimal getRes_20_10_lcbg_balance() {
		return res_20_10_lcbg_balance;
	}
	public void setRes_20_10_lcbg_balance(BigDecimal res_20_10_lcbg_balance) {
		this.res_20_10_lcbg_balance = res_20_10_lcbg_balance;
	}
	public BigDecimal getRes_20_10_acceptance_amount() {
		return res_20_10_acceptance_amount;
	}
	public void setRes_20_10_acceptance_amount(BigDecimal res_20_10_acceptance_amount) {
		this.res_20_10_acceptance_amount = res_20_10_acceptance_amount;
	}
	public BigDecimal getRes_20_10_lcbg_crm() {
		return res_20_10_lcbg_crm;
	}
	public void setRes_20_10_lcbg_crm(BigDecimal res_20_10_lcbg_crm) {
		this.res_20_10_lcbg_crm = res_20_10_lcbg_crm;
	}
	public BigDecimal getRes_20_10_rwa() {
		return res_20_10_rwa;
	}
	public void setRes_20_10_rwa(BigDecimal res_20_10_rwa) {
		this.res_20_10_rwa = res_20_10_rwa;
	}
	public BigDecimal getRes_20_10_under_ccf_amt() {
		return res_20_10_under_ccf_amt;
	}
	public void setRes_20_10_under_ccf_amt(BigDecimal res_20_10_under_ccf_amt) {
		this.res_20_10_under_ccf_amt = res_20_10_under_ccf_amt;
	}
	public BigDecimal getRes_20_lcbg_balance() {
		return res_20_lcbg_balance;
	}
	public void setRes_20_lcbg_balance(BigDecimal res_20_lcbg_balance) {
		this.res_20_lcbg_balance = res_20_lcbg_balance;
	}
	public BigDecimal getRes_20_acceptance_amount() {
		return res_20_acceptance_amount;
	}
	public void setRes_20_acceptance_amount(BigDecimal res_20_acceptance_amount) {
		this.res_20_acceptance_amount = res_20_acceptance_amount;
	}
	public BigDecimal getRes_20_lcbg_crm() {
		return res_20_lcbg_crm;
	}
	public void setRes_20_lcbg_crm(BigDecimal res_20_lcbg_crm) {
		this.res_20_lcbg_crm = res_20_lcbg_crm;
	}
	public BigDecimal getRes_20_rwa() {
		return res_20_rwa;
	}
	public void setRes_20_rwa(BigDecimal res_20_rwa) {
		this.res_20_rwa = res_20_rwa;
	}
	public BigDecimal getRes_20_under_ccf_amt() {
		return res_20_under_ccf_amt;
	}
	public void setRes_20_under_ccf_amt(BigDecimal res_20_under_ccf_amt) {
		this.res_20_under_ccf_amt = res_20_under_ccf_amt;
	}
	public BigDecimal getRes_50_20_lcbg_balance() {
		return res_50_20_lcbg_balance;
	}
	public void setRes_50_20_lcbg_balance(BigDecimal res_50_20_lcbg_balance) {
		this.res_50_20_lcbg_balance = res_50_20_lcbg_balance;
	}
	public BigDecimal getRes_50_20_acceptance_amount() {
		return res_50_20_acceptance_amount;
	}
	public void setRes_50_20_acceptance_amount(BigDecimal res_50_20_acceptance_amount) {
		this.res_50_20_acceptance_amount = res_50_20_acceptance_amount;
	}
	public BigDecimal getRes_50_20_lcbg_crm() {
		return res_50_20_lcbg_crm;
	}
	public void setRes_50_20_lcbg_crm(BigDecimal res_50_20_lcbg_crm) {
		this.res_50_20_lcbg_crm = res_50_20_lcbg_crm;
	}
	public BigDecimal getRes_50_20_rwa() {
		return res_50_20_rwa;
	}
	public void setRes_50_20_rwa(BigDecimal res_50_20_rwa) {
		this.res_50_20_rwa = res_50_20_rwa;
	}
	public BigDecimal getRes_50_20_under_ccf_amt() {
		return res_50_20_under_ccf_amt;
	}
	public void setRes_50_20_under_ccf_amt(BigDecimal res_50_20_under_ccf_amt) {
		this.res_50_20_under_ccf_amt = res_50_20_under_ccf_amt;
	}
	public BigDecimal getRes_50_50_lcbg_balance() {
		return res_50_50_lcbg_balance;
	}
	public void setRes_50_50_lcbg_balance(BigDecimal res_50_50_lcbg_balance) {
		this.res_50_50_lcbg_balance = res_50_50_lcbg_balance;
	}
	public BigDecimal getRes_50_50_acceptance_amount() {
		return res_50_50_acceptance_amount;
	}
	public void setRes_50_50_acceptance_amount(BigDecimal res_50_50_acceptance_amount) {
		this.res_50_50_acceptance_amount = res_50_50_acceptance_amount;
	}
	public BigDecimal getRes_50_50_lcbg_crm() {
		return res_50_50_lcbg_crm;
	}
	public void setRes_50_50_lcbg_crm(BigDecimal res_50_50_lcbg_crm) {
		this.res_50_50_lcbg_crm = res_50_50_lcbg_crm;
	}
	public BigDecimal getRes_50_50_rwa() {
		return res_50_50_rwa;
	}
	public void setRes_50_50_rwa(BigDecimal res_50_50_rwa) {
		this.res_50_50_rwa = res_50_50_rwa;
	}
	public BigDecimal getRes_50_50_under_ccf_amt() {
		return res_50_50_under_ccf_amt;
	}
	public void setRes_50_50_under_ccf_amt(BigDecimal res_50_50_under_ccf_amt) {
		this.res_50_50_under_ccf_amt = res_50_50_under_ccf_amt;
	}
	public BigDecimal getRes_50_10_lcbg_balance() {
		return res_50_10_lcbg_balance;
	}
	public void setRes_50_10_lcbg_balance(BigDecimal res_50_10_lcbg_balance) {
		this.res_50_10_lcbg_balance = res_50_10_lcbg_balance;
	}
	public BigDecimal getRes_50_10_acceptance_amount() {
		return res_50_10_acceptance_amount;
	}
	public void setRes_50_10_acceptance_amount(BigDecimal res_50_10_acceptance_amount) {
		this.res_50_10_acceptance_amount = res_50_10_acceptance_amount;
	}
	public BigDecimal getRes_50_10_lcbg_crm() {
		return res_50_10_lcbg_crm;
	}
	public void setRes_50_10_lcbg_crm(BigDecimal res_50_10_lcbg_crm) {
		this.res_50_10_lcbg_crm = res_50_10_lcbg_crm;
	}
	public BigDecimal getRes_50_10_rwa() {
		return res_50_10_rwa;
	}
	public void setRes_50_10_rwa(BigDecimal res_50_10_rwa) {
		this.res_50_10_rwa = res_50_10_rwa;
	}
	public BigDecimal getRes_50_10_under_ccf_amt() {
		return res_50_10_under_ccf_amt;
	}
	public void setRes_50_10_under_ccf_amt(BigDecimal res_50_10_under_ccf_amt) {
		this.res_50_10_under_ccf_amt = res_50_10_under_ccf_amt;
	}
	public BigDecimal getRes_50_lcbg_balance() {
		return res_50_lcbg_balance;
	}
	public void setRes_50_lcbg_balance(BigDecimal res_50_lcbg_balance) {
		this.res_50_lcbg_balance = res_50_lcbg_balance;
	}
	public BigDecimal getRes_50_acceptance_amount() {
		return res_50_acceptance_amount;
	}
	public void setRes_50_acceptance_amount(BigDecimal res_50_acceptance_amount) {
		this.res_50_acceptance_amount = res_50_acceptance_amount;
	}
	public BigDecimal getRes_50_lcbg_crm() {
		return res_50_lcbg_crm;
	}
	public void setRes_50_lcbg_crm(BigDecimal res_50_lcbg_crm) {
		this.res_50_lcbg_crm = res_50_lcbg_crm;
	}
	public BigDecimal getRes_50_rwa() {
		return res_50_rwa;
	}
	public void setRes_50_rwa(BigDecimal res_50_rwa) {
		this.res_50_rwa = res_50_rwa;
	}
	public BigDecimal getRes_50_under_ccf_amt() {
		return res_50_under_ccf_amt;
	}
	public void setRes_50_under_ccf_amt(BigDecimal res_50_under_ccf_amt) {
		this.res_50_under_ccf_amt = res_50_under_ccf_amt;
	}
	public BigDecimal getRes_150_20_lcbg_balance() {
		return res_150_20_lcbg_balance;
	}
	public void setRes_150_20_lcbg_balance(BigDecimal res_150_20_lcbg_balance) {
		this.res_150_20_lcbg_balance = res_150_20_lcbg_balance;
	}
	public BigDecimal getRes_150_20_acceptance_amount() {
		return res_150_20_acceptance_amount;
	}
	public void setRes_150_20_acceptance_amount(BigDecimal res_150_20_acceptance_amount) {
		this.res_150_20_acceptance_amount = res_150_20_acceptance_amount;
	}
	public BigDecimal getRes_150_20_lcbg_crm() {
		return res_150_20_lcbg_crm;
	}
	public void setRes_150_20_lcbg_crm(BigDecimal res_150_20_lcbg_crm) {
		this.res_150_20_lcbg_crm = res_150_20_lcbg_crm;
	}
	public BigDecimal getRes_150_20_rwa() {
		return res_150_20_rwa;
	}
	public void setRes_150_20_rwa(BigDecimal res_150_20_rwa) {
		this.res_150_20_rwa = res_150_20_rwa;
	}
	public BigDecimal getRes_150_20_under_ccf_amt() {
		return res_150_20_under_ccf_amt;
	}
	public void setRes_150_20_under_ccf_amt(BigDecimal res_150_20_under_ccf_amt) {
		this.res_150_20_under_ccf_amt = res_150_20_under_ccf_amt;
	}
	public BigDecimal getRes_150_50_lcbg_balance() {
		return res_150_50_lcbg_balance;
	}
	public void setRes_150_50_lcbg_balance(BigDecimal res_150_50_lcbg_balance) {
		this.res_150_50_lcbg_balance = res_150_50_lcbg_balance;
	}
	public BigDecimal getRes_150_50_acceptance_amount() {
		return res_150_50_acceptance_amount;
	}
	public void setRes_150_50_acceptance_amount(BigDecimal res_150_50_acceptance_amount) {
		this.res_150_50_acceptance_amount = res_150_50_acceptance_amount;
	}
	public BigDecimal getRes_150_50_lcbg_crm() {
		return res_150_50_lcbg_crm;
	}
	public void setRes_150_50_lcbg_crm(BigDecimal res_150_50_lcbg_crm) {
		this.res_150_50_lcbg_crm = res_150_50_lcbg_crm;
	}
	public BigDecimal getRes_150_50_rwa() {
		return res_150_50_rwa;
	}
	public void setRes_150_50_rwa(BigDecimal res_150_50_rwa) {
		this.res_150_50_rwa = res_150_50_rwa;
	}
	public BigDecimal getRes_150_50_under_ccf_amt() {
		return res_150_50_under_ccf_amt;
	}
	public void setRes_150_50_under_ccf_amt(BigDecimal res_150_50_under_ccf_amt) {
		this.res_150_50_under_ccf_amt = res_150_50_under_ccf_amt;
	}
	public BigDecimal getRes_150_10_lcbg_balance() {
		return res_150_10_lcbg_balance;
	}
	public void setRes_150_10_lcbg_balance(BigDecimal res_150_10_lcbg_balance) {
		this.res_150_10_lcbg_balance = res_150_10_lcbg_balance;
	}
	public BigDecimal getRes_150_10_acceptance_amount() {
		return res_150_10_acceptance_amount;
	}
	public void setRes_150_10_acceptance_amount(BigDecimal res_150_10_acceptance_amount) {
		this.res_150_10_acceptance_amount = res_150_10_acceptance_amount;
	}
	public BigDecimal getRes_150_10_lcbg_crm() {
		return res_150_10_lcbg_crm;
	}
	public void setRes_150_10_lcbg_crm(BigDecimal res_150_10_lcbg_crm) {
		this.res_150_10_lcbg_crm = res_150_10_lcbg_crm;
	}
	public BigDecimal getRes_150_10_rwa() {
		return res_150_10_rwa;
	}
	public void setRes_150_10_rwa(BigDecimal res_150_10_rwa) {
		this.res_150_10_rwa = res_150_10_rwa;
	}
	public BigDecimal getRes_150_10_under_ccf_amt() {
		return res_150_10_under_ccf_amt;
	}
	public void setRes_150_10_under_ccf_amt(BigDecimal res_150_10_under_ccf_amt) {
		this.res_150_10_under_ccf_amt = res_150_10_under_ccf_amt;
	}
	public BigDecimal getRes_150_lcbg_balance() {
		return res_150_lcbg_balance;
	}
	public void setRes_150_lcbg_balance(BigDecimal res_150_lcbg_balance) {
		this.res_150_lcbg_balance = res_150_lcbg_balance;
	}
	public BigDecimal getRes_150_acceptance_amount() {
		return res_150_acceptance_amount;
	}
	public void setRes_150_acceptance_amount(BigDecimal res_150_acceptance_amount) {
		this.res_150_acceptance_amount = res_150_acceptance_amount;
	}
	public BigDecimal getRes_150_lcbg_crm() {
		return res_150_lcbg_crm;
	}
	public void setRes_150_lcbg_crm(BigDecimal res_150_lcbg_crm) {
		this.res_150_lcbg_crm = res_150_lcbg_crm;
	}
	public BigDecimal getRes_150_rwa() {
		return res_150_rwa;
	}
	public void setRes_150_rwa(BigDecimal res_150_rwa) {
		this.res_150_rwa = res_150_rwa;
	}
	public BigDecimal getRes_150_under_ccf_amt() {
		return res_150_under_ccf_amt;
	}
	public void setRes_150_under_ccf_amt(BigDecimal res_150_under_ccf_amt) {
		this.res_150_under_ccf_amt = res_150_under_ccf_amt;
	}
	public BigDecimal getRrp_inde1_0_20_lcbg_balance() {
		return rrp_inde1_0_20_lcbg_balance;
	}
	public void setRrp_inde1_0_20_lcbg_balance(BigDecimal rrp_inde1_0_20_lcbg_balance) {
		this.rrp_inde1_0_20_lcbg_balance = rrp_inde1_0_20_lcbg_balance;
	}
	public BigDecimal getRrp_inde1_0_20_acceptance_amount() {
		return rrp_inde1_0_20_acceptance_amount;
	}
	public void setRrp_inde1_0_20_acceptance_amount(BigDecimal rrp_inde1_0_20_acceptance_amount) {
		this.rrp_inde1_0_20_acceptance_amount = rrp_inde1_0_20_acceptance_amount;
	}
	public BigDecimal getRrp_inde1_0_20_lcbg_crm() {
		return rrp_inde1_0_20_lcbg_crm;
	}
	public void setRrp_inde1_0_20_lcbg_crm(BigDecimal rrp_inde1_0_20_lcbg_crm) {
		this.rrp_inde1_0_20_lcbg_crm = rrp_inde1_0_20_lcbg_crm;
	}
	public BigDecimal getRrp_inde1_0_20_rwa() {
		return rrp_inde1_0_20_rwa;
	}
	public void setRrp_inde1_0_20_rwa(BigDecimal rrp_inde1_0_20_rwa) {
		this.rrp_inde1_0_20_rwa = rrp_inde1_0_20_rwa;
	}
	public BigDecimal getRrp_inde1_0_20_under_ccf_amt() {
		return rrp_inde1_0_20_under_ccf_amt;
	}
	public void setRrp_inde1_0_20_under_ccf_amt(BigDecimal rrp_inde1_0_20_under_ccf_amt) {
		this.rrp_inde1_0_20_under_ccf_amt = rrp_inde1_0_20_under_ccf_amt;
	}
	public BigDecimal getRrp_inde1_0_50_lcbg_balance() {
		return rrp_inde1_0_50_lcbg_balance;
	}
	public void setRrp_inde1_0_50_lcbg_balance(BigDecimal rrp_inde1_0_50_lcbg_balance) {
		this.rrp_inde1_0_50_lcbg_balance = rrp_inde1_0_50_lcbg_balance;
	}
	public BigDecimal getRrp_inde1_0_50_acceptance_amount() {
		return rrp_inde1_0_50_acceptance_amount;
	}
	public void setRrp_inde1_0_50_acceptance_amount(BigDecimal rrp_inde1_0_50_acceptance_amount) {
		this.rrp_inde1_0_50_acceptance_amount = rrp_inde1_0_50_acceptance_amount;
	}
	public BigDecimal getRrp_inde1_0_50_lcbg_crm() {
		return rrp_inde1_0_50_lcbg_crm;
	}
	public void setRrp_inde1_0_50_lcbg_crm(BigDecimal rrp_inde1_0_50_lcbg_crm) {
		this.rrp_inde1_0_50_lcbg_crm = rrp_inde1_0_50_lcbg_crm;
	}
	public BigDecimal getRrp_inde1_0_50_rwa() {
		return rrp_inde1_0_50_rwa;
	}
	public void setRrp_inde1_0_50_rwa(BigDecimal rrp_inde1_0_50_rwa) {
		this.rrp_inde1_0_50_rwa = rrp_inde1_0_50_rwa;
	}
	public BigDecimal getRrp_inde1_0_50_under_ccf_amt() {
		return rrp_inde1_0_50_under_ccf_amt;
	}
	public void setRrp_inde1_0_50_under_ccf_amt(BigDecimal rrp_inde1_0_50_under_ccf_amt) {
		this.rrp_inde1_0_50_under_ccf_amt = rrp_inde1_0_50_under_ccf_amt;
	}
	public BigDecimal getRrp_inde1_0_10_lcbg_balance() {
		return rrp_inde1_0_10_lcbg_balance;
	}
	public void setRrp_inde1_0_10_lcbg_balance(BigDecimal rrp_inde1_0_10_lcbg_balance) {
		this.rrp_inde1_0_10_lcbg_balance = rrp_inde1_0_10_lcbg_balance;
	}
	public BigDecimal getRrp_inde1_0_10_acceptance_amount() {
		return rrp_inde1_0_10_acceptance_amount;
	}
	public void setRrp_inde1_0_10_acceptance_amount(BigDecimal rrp_inde1_0_10_acceptance_amount) {
		this.rrp_inde1_0_10_acceptance_amount = rrp_inde1_0_10_acceptance_amount;
	}
	public BigDecimal getRrp_inde1_0_10_lcbg_crm() {
		return rrp_inde1_0_10_lcbg_crm;
	}
	public void setRrp_inde1_0_10_lcbg_crm(BigDecimal rrp_inde1_0_10_lcbg_crm) {
		this.rrp_inde1_0_10_lcbg_crm = rrp_inde1_0_10_lcbg_crm;
	}
	public BigDecimal getRrp_inde1_0_10_rwa() {
		return rrp_inde1_0_10_rwa;
	}
	public void setRrp_inde1_0_10_rwa(BigDecimal rrp_inde1_0_10_rwa) {
		this.rrp_inde1_0_10_rwa = rrp_inde1_0_10_rwa;
	}
	public BigDecimal getRrp_inde1_0_10_under_ccf_amt() {
		return rrp_inde1_0_10_under_ccf_amt;
	}
	public void setRrp_inde1_0_10_under_ccf_amt(BigDecimal rrp_inde1_0_10_under_ccf_amt) {
		this.rrp_inde1_0_10_under_ccf_amt = rrp_inde1_0_10_under_ccf_amt;
	}
	public BigDecimal getRrp_inde1_0_lcbg_balance() {
		return rrp_inde1_0_lcbg_balance;
	}
	public void setRrp_inde1_0_lcbg_balance(BigDecimal rrp_inde1_0_lcbg_balance) {
		this.rrp_inde1_0_lcbg_balance = rrp_inde1_0_lcbg_balance;
	}
	public BigDecimal getRrp_inde1_0_acceptance_amount() {
		return rrp_inde1_0_acceptance_amount;
	}
	public void setRrp_inde1_0_acceptance_amount(BigDecimal rrp_inde1_0_acceptance_amount) {
		this.rrp_inde1_0_acceptance_amount = rrp_inde1_0_acceptance_amount;
	}
	public BigDecimal getRrp_inde1_0_lcbg_crm() {
		return rrp_inde1_0_lcbg_crm;
	}
	public void setRrp_inde1_0_lcbg_crm(BigDecimal rrp_inde1_0_lcbg_crm) {
		this.rrp_inde1_0_lcbg_crm = rrp_inde1_0_lcbg_crm;
	}
	public BigDecimal getRrp_inde1_0_rwa() {
		return rrp_inde1_0_rwa;
	}
	public void setRrp_inde1_0_rwa(BigDecimal rrp_inde1_0_rwa) {
		this.rrp_inde1_0_rwa = rrp_inde1_0_rwa;
	}
	public BigDecimal getRrp_inde1_0_under_ccf_amt() {
		return rrp_inde1_0_under_ccf_amt;
	}
	public void setRrp_inde1_0_under_ccf_amt(BigDecimal rrp_inde1_0_under_ccf_amt) {
		this.rrp_inde1_0_under_ccf_amt = rrp_inde1_0_under_ccf_amt;
	}
	public BigDecimal getRrp_inde1_20_20_lcbg_balance() {
		return rrp_inde1_20_20_lcbg_balance;
	}
	public void setRrp_inde1_20_20_lcbg_balance(BigDecimal rrp_inde1_20_20_lcbg_balance) {
		this.rrp_inde1_20_20_lcbg_balance = rrp_inde1_20_20_lcbg_balance;
	}
	public BigDecimal getRrp_inde1_20_20_acceptance_amount() {
		return rrp_inde1_20_20_acceptance_amount;
	}
	public void setRrp_inde1_20_20_acceptance_amount(BigDecimal rrp_inde1_20_20_acceptance_amount) {
		this.rrp_inde1_20_20_acceptance_amount = rrp_inde1_20_20_acceptance_amount;
	}
	public BigDecimal getRrp_inde1_20_20_lcbg_crm() {
		return rrp_inde1_20_20_lcbg_crm;
	}
	public void setRrp_inde1_20_20_lcbg_crm(BigDecimal rrp_inde1_20_20_lcbg_crm) {
		this.rrp_inde1_20_20_lcbg_crm = rrp_inde1_20_20_lcbg_crm;
	}
	public BigDecimal getRrp_inde1_20_20_rwa() {
		return rrp_inde1_20_20_rwa;
	}
	public void setRrp_inde1_20_20_rwa(BigDecimal rrp_inde1_20_20_rwa) {
		this.rrp_inde1_20_20_rwa = rrp_inde1_20_20_rwa;
	}
	public BigDecimal getRrp_inde1_20_20_under_ccf_amt() {
		return rrp_inde1_20_20_under_ccf_amt;
	}
	public void setRrp_inde1_20_20_under_ccf_amt(BigDecimal rrp_inde1_20_20_under_ccf_amt) {
		this.rrp_inde1_20_20_under_ccf_amt = rrp_inde1_20_20_under_ccf_amt;
	}
	public BigDecimal getRrp_inde1_20_50_lcbg_balance() {
		return rrp_inde1_20_50_lcbg_balance;
	}
	public void setRrp_inde1_20_50_lcbg_balance(BigDecimal rrp_inde1_20_50_lcbg_balance) {
		this.rrp_inde1_20_50_lcbg_balance = rrp_inde1_20_50_lcbg_balance;
	}
	public BigDecimal getRrp_inde1_20_50_acceptance_amount() {
		return rrp_inde1_20_50_acceptance_amount;
	}
	public void setRrp_inde1_20_50_acceptance_amount(BigDecimal rrp_inde1_20_50_acceptance_amount) {
		this.rrp_inde1_20_50_acceptance_amount = rrp_inde1_20_50_acceptance_amount;
	}
	public BigDecimal getRrp_inde1_20_50_lcbg_crm() {
		return rrp_inde1_20_50_lcbg_crm;
	}
	public void setRrp_inde1_20_50_lcbg_crm(BigDecimal rrp_inde1_20_50_lcbg_crm) {
		this.rrp_inde1_20_50_lcbg_crm = rrp_inde1_20_50_lcbg_crm;
	}
	public BigDecimal getRrp_inde1_20_50_rwa() {
		return rrp_inde1_20_50_rwa;
	}
	public void setRrp_inde1_20_50_rwa(BigDecimal rrp_inde1_20_50_rwa) {
		this.rrp_inde1_20_50_rwa = rrp_inde1_20_50_rwa;
	}
	public BigDecimal getRrp_inde1_20_50_under_ccf_amt() {
		return rrp_inde1_20_50_under_ccf_amt;
	}
	public void setRrp_inde1_20_50_under_ccf_amt(BigDecimal rrp_inde1_20_50_under_ccf_amt) {
		this.rrp_inde1_20_50_under_ccf_amt = rrp_inde1_20_50_under_ccf_amt;
	}
	public BigDecimal getRrp_inde1_20_10_lcbg_balance() {
		return rrp_inde1_20_10_lcbg_balance;
	}
	public void setRrp_inde1_20_10_lcbg_balance(BigDecimal rrp_inde1_20_10_lcbg_balance) {
		this.rrp_inde1_20_10_lcbg_balance = rrp_inde1_20_10_lcbg_balance;
	}
	public BigDecimal getRrp_inde1_20_10_acceptance_amount() {
		return rrp_inde1_20_10_acceptance_amount;
	}
	public void setRrp_inde1_20_10_acceptance_amount(BigDecimal rrp_inde1_20_10_acceptance_amount) {
		this.rrp_inde1_20_10_acceptance_amount = rrp_inde1_20_10_acceptance_amount;
	}
	public BigDecimal getRrp_inde1_20_10_lcbg_crm() {
		return rrp_inde1_20_10_lcbg_crm;
	}
	public void setRrp_inde1_20_10_lcbg_crm(BigDecimal rrp_inde1_20_10_lcbg_crm) {
		this.rrp_inde1_20_10_lcbg_crm = rrp_inde1_20_10_lcbg_crm;
	}
	public BigDecimal getRrp_inde1_20_10_rwa() {
		return rrp_inde1_20_10_rwa;
	}
	public void setRrp_inde1_20_10_rwa(BigDecimal rrp_inde1_20_10_rwa) {
		this.rrp_inde1_20_10_rwa = rrp_inde1_20_10_rwa;
	}
	public BigDecimal getRrp_inde1_20_10_under_ccf_amt() {
		return rrp_inde1_20_10_under_ccf_amt;
	}
	public void setRrp_inde1_20_10_under_ccf_amt(BigDecimal rrp_inde1_20_10_under_ccf_amt) {
		this.rrp_inde1_20_10_under_ccf_amt = rrp_inde1_20_10_under_ccf_amt;
	}
	public BigDecimal getRrp_inde1_20_lcbg_balance() {
		return rrp_inde1_20_lcbg_balance;
	}
	public void setRrp_inde1_20_lcbg_balance(BigDecimal rrp_inde1_20_lcbg_balance) {
		this.rrp_inde1_20_lcbg_balance = rrp_inde1_20_lcbg_balance;
	}
	public BigDecimal getRrp_inde1_20_acceptance_amount() {
		return rrp_inde1_20_acceptance_amount;
	}
	public void setRrp_inde1_20_acceptance_amount(BigDecimal rrp_inde1_20_acceptance_amount) {
		this.rrp_inde1_20_acceptance_amount = rrp_inde1_20_acceptance_amount;
	}
	public BigDecimal getRrp_inde1_20_lcbg_crm() {
		return rrp_inde1_20_lcbg_crm;
	}
	public void setRrp_inde1_20_lcbg_crm(BigDecimal rrp_inde1_20_lcbg_crm) {
		this.rrp_inde1_20_lcbg_crm = rrp_inde1_20_lcbg_crm;
	}
	public BigDecimal getRrp_inde1_20_rwa() {
		return rrp_inde1_20_rwa;
	}
	public void setRrp_inde1_20_rwa(BigDecimal rrp_inde1_20_rwa) {
		this.rrp_inde1_20_rwa = rrp_inde1_20_rwa;
	}
	public BigDecimal getRrp_inde1_20_under_ccf_amt() {
		return rrp_inde1_20_under_ccf_amt;
	}
	public void setRrp_inde1_20_under_ccf_amt(BigDecimal rrp_inde1_20_under_ccf_amt) {
		this.rrp_inde1_20_under_ccf_amt = rrp_inde1_20_under_ccf_amt;
	}
	public BigDecimal getRrp_inde1_50_20_lcbg_balance() {
		return rrp_inde1_50_20_lcbg_balance;
	}
	public void setRrp_inde1_50_20_lcbg_balance(BigDecimal rrp_inde1_50_20_lcbg_balance) {
		this.rrp_inde1_50_20_lcbg_balance = rrp_inde1_50_20_lcbg_balance;
	}
	public BigDecimal getRrp_inde1_50_20_acceptance_amount() {
		return rrp_inde1_50_20_acceptance_amount;
	}
	public void setRrp_inde1_50_20_acceptance_amount(BigDecimal rrp_inde1_50_20_acceptance_amount) {
		this.rrp_inde1_50_20_acceptance_amount = rrp_inde1_50_20_acceptance_amount;
	}
	public BigDecimal getRrp_inde1_50_20_lcbg_crm() {
		return rrp_inde1_50_20_lcbg_crm;
	}
	public void setRrp_inde1_50_20_lcbg_crm(BigDecimal rrp_inde1_50_20_lcbg_crm) {
		this.rrp_inde1_50_20_lcbg_crm = rrp_inde1_50_20_lcbg_crm;
	}
	public BigDecimal getRrp_inde1_50_20_rwa() {
		return rrp_inde1_50_20_rwa;
	}
	public void setRrp_inde1_50_20_rwa(BigDecimal rrp_inde1_50_20_rwa) {
		this.rrp_inde1_50_20_rwa = rrp_inde1_50_20_rwa;
	}
	public BigDecimal getRrp_inde1_50_20_under_ccf_amt() {
		return rrp_inde1_50_20_under_ccf_amt;
	}
	public void setRrp_inde1_50_20_under_ccf_amt(BigDecimal rrp_inde1_50_20_under_ccf_amt) {
		this.rrp_inde1_50_20_under_ccf_amt = rrp_inde1_50_20_under_ccf_amt;
	}
	public BigDecimal getRrp_inde1_50_50_lcbg_balance() {
		return rrp_inde1_50_50_lcbg_balance;
	}
	public void setRrp_inde1_50_50_lcbg_balance(BigDecimal rrp_inde1_50_50_lcbg_balance) {
		this.rrp_inde1_50_50_lcbg_balance = rrp_inde1_50_50_lcbg_balance;
	}
	public BigDecimal getRrp_inde1_50_50_acceptance_amount() {
		return rrp_inde1_50_50_acceptance_amount;
	}
	public void setRrp_inde1_50_50_acceptance_amount(BigDecimal rrp_inde1_50_50_acceptance_amount) {
		this.rrp_inde1_50_50_acceptance_amount = rrp_inde1_50_50_acceptance_amount;
	}
	public BigDecimal getRrp_inde1_50_50_lcbg_crm() {
		return rrp_inde1_50_50_lcbg_crm;
	}
	public void setRrp_inde1_50_50_lcbg_crm(BigDecimal rrp_inde1_50_50_lcbg_crm) {
		this.rrp_inde1_50_50_lcbg_crm = rrp_inde1_50_50_lcbg_crm;
	}
	public BigDecimal getRrp_inde1_50_50_rwa() {
		return rrp_inde1_50_50_rwa;
	}
	public void setRrp_inde1_50_50_rwa(BigDecimal rrp_inde1_50_50_rwa) {
		this.rrp_inde1_50_50_rwa = rrp_inde1_50_50_rwa;
	}
	public BigDecimal getRrp_inde1_50_50_under_ccf_amt() {
		return rrp_inde1_50_50_under_ccf_amt;
	}
	public void setRrp_inde1_50_50_under_ccf_amt(BigDecimal rrp_inde1_50_50_under_ccf_amt) {
		this.rrp_inde1_50_50_under_ccf_amt = rrp_inde1_50_50_under_ccf_amt;
	}
	public BigDecimal getRrp_inde1_50_10_lcbg_balance() {
		return rrp_inde1_50_10_lcbg_balance;
	}
	public void setRrp_inde1_50_10_lcbg_balance(BigDecimal rrp_inde1_50_10_lcbg_balance) {
		this.rrp_inde1_50_10_lcbg_balance = rrp_inde1_50_10_lcbg_balance;
	}
	public BigDecimal getRrp_inde1_50_10_acceptance_amount() {
		return rrp_inde1_50_10_acceptance_amount;
	}
	public void setRrp_inde1_50_10_acceptance_amount(BigDecimal rrp_inde1_50_10_acceptance_amount) {
		this.rrp_inde1_50_10_acceptance_amount = rrp_inde1_50_10_acceptance_amount;
	}
	public BigDecimal getRrp_inde1_50_10_lcbg_crm() {
		return rrp_inde1_50_10_lcbg_crm;
	}
	public void setRrp_inde1_50_10_lcbg_crm(BigDecimal rrp_inde1_50_10_lcbg_crm) {
		this.rrp_inde1_50_10_lcbg_crm = rrp_inde1_50_10_lcbg_crm;
	}
	public BigDecimal getRrp_inde1_50_10_rwa() {
		return rrp_inde1_50_10_rwa;
	}
	public void setRrp_inde1_50_10_rwa(BigDecimal rrp_inde1_50_10_rwa) {
		this.rrp_inde1_50_10_rwa = rrp_inde1_50_10_rwa;
	}
	public BigDecimal getRrp_inde1_50_10_under_ccf_amt() {
		return rrp_inde1_50_10_under_ccf_amt;
	}
	public void setRrp_inde1_50_10_under_ccf_amt(BigDecimal rrp_inde1_50_10_under_ccf_amt) {
		this.rrp_inde1_50_10_under_ccf_amt = rrp_inde1_50_10_under_ccf_amt;
	}
	public BigDecimal getRrp_inde1_50_lcbg_balance() {
		return rrp_inde1_50_lcbg_balance;
	}
	public void setRrp_inde1_50_lcbg_balance(BigDecimal rrp_inde1_50_lcbg_balance) {
		this.rrp_inde1_50_lcbg_balance = rrp_inde1_50_lcbg_balance;
	}
	public BigDecimal getRrp_inde1_50_acceptance_amount() {
		return rrp_inde1_50_acceptance_amount;
	}
	public void setRrp_inde1_50_acceptance_amount(BigDecimal rrp_inde1_50_acceptance_amount) {
		this.rrp_inde1_50_acceptance_amount = rrp_inde1_50_acceptance_amount;
	}
	public BigDecimal getRrp_inde1_50_lcbg_crm() {
		return rrp_inde1_50_lcbg_crm;
	}
	public void setRrp_inde1_50_lcbg_crm(BigDecimal rrp_inde1_50_lcbg_crm) {
		this.rrp_inde1_50_lcbg_crm = rrp_inde1_50_lcbg_crm;
	}
	public BigDecimal getRrp_inde1_50_rwa() {
		return rrp_inde1_50_rwa;
	}
	public void setRrp_inde1_50_rwa(BigDecimal rrp_inde1_50_rwa) {
		this.rrp_inde1_50_rwa = rrp_inde1_50_rwa;
	}
	public BigDecimal getRrp_inde1_50_under_ccf_amt() {
		return rrp_inde1_50_under_ccf_amt;
	}
	public void setRrp_inde1_50_under_ccf_amt(BigDecimal rrp_inde1_50_under_ccf_amt) {
		this.rrp_inde1_50_under_ccf_amt = rrp_inde1_50_under_ccf_amt;
	}
	public BigDecimal getRrp_inde1_100_20_lcbg_balance() {
		return rrp_inde1_100_20_lcbg_balance;
	}
	public void setRrp_inde1_100_20_lcbg_balance(BigDecimal rrp_inde1_100_20_lcbg_balance) {
		this.rrp_inde1_100_20_lcbg_balance = rrp_inde1_100_20_lcbg_balance;
	}
	public BigDecimal getRrp_inde1_100_20_acceptance_amount() {
		return rrp_inde1_100_20_acceptance_amount;
	}
	public void setRrp_inde1_100_20_acceptance_amount(BigDecimal rrp_inde1_100_20_acceptance_amount) {
		this.rrp_inde1_100_20_acceptance_amount = rrp_inde1_100_20_acceptance_amount;
	}
	public BigDecimal getRrp_inde1_100_20_lcbg_crm() {
		return rrp_inde1_100_20_lcbg_crm;
	}
	public void setRrp_inde1_100_20_lcbg_crm(BigDecimal rrp_inde1_100_20_lcbg_crm) {
		this.rrp_inde1_100_20_lcbg_crm = rrp_inde1_100_20_lcbg_crm;
	}
	public BigDecimal getRrp_inde1_100_20_rwa() {
		return rrp_inde1_100_20_rwa;
	}
	public void setRrp_inde1_100_20_rwa(BigDecimal rrp_inde1_100_20_rwa) {
		this.rrp_inde1_100_20_rwa = rrp_inde1_100_20_rwa;
	}
	public BigDecimal getRrp_inde1_100_20_under_ccf_amt() {
		return rrp_inde1_100_20_under_ccf_amt;
	}
	public void setRrp_inde1_100_20_under_ccf_amt(BigDecimal rrp_inde1_100_20_under_ccf_amt) {
		this.rrp_inde1_100_20_under_ccf_amt = rrp_inde1_100_20_under_ccf_amt;
	}
	public BigDecimal getRrp_inde1_100_50_lcbg_balance() {
		return rrp_inde1_100_50_lcbg_balance;
	}
	public void setRrp_inde1_100_50_lcbg_balance(BigDecimal rrp_inde1_100_50_lcbg_balance) {
		this.rrp_inde1_100_50_lcbg_balance = rrp_inde1_100_50_lcbg_balance;
	}
	public BigDecimal getRrp_inde1_100_50_acceptance_amount() {
		return rrp_inde1_100_50_acceptance_amount;
	}
	public void setRrp_inde1_100_50_acceptance_amount(BigDecimal rrp_inde1_100_50_acceptance_amount) {
		this.rrp_inde1_100_50_acceptance_amount = rrp_inde1_100_50_acceptance_amount;
	}
	public BigDecimal getRrp_inde1_100_50_lcbg_crm() {
		return rrp_inde1_100_50_lcbg_crm;
	}
	public void setRrp_inde1_100_50_lcbg_crm(BigDecimal rrp_inde1_100_50_lcbg_crm) {
		this.rrp_inde1_100_50_lcbg_crm = rrp_inde1_100_50_lcbg_crm;
	}
	public BigDecimal getRrp_inde1_100_50_rwa() {
		return rrp_inde1_100_50_rwa;
	}
	public void setRrp_inde1_100_50_rwa(BigDecimal rrp_inde1_100_50_rwa) {
		this.rrp_inde1_100_50_rwa = rrp_inde1_100_50_rwa;
	}
	public BigDecimal getRrp_inde1_100_50_under_ccf_amt() {
		return rrp_inde1_100_50_under_ccf_amt;
	}
	public void setRrp_inde1_100_50_under_ccf_amt(BigDecimal rrp_inde1_100_50_under_ccf_amt) {
		this.rrp_inde1_100_50_under_ccf_amt = rrp_inde1_100_50_under_ccf_amt;
	}
	public BigDecimal getRrp_inde1_100_10_lcbg_balance() {
		return rrp_inde1_100_10_lcbg_balance;
	}
	public void setRrp_inde1_100_10_lcbg_balance(BigDecimal rrp_inde1_100_10_lcbg_balance) {
		this.rrp_inde1_100_10_lcbg_balance = rrp_inde1_100_10_lcbg_balance;
	}
	public BigDecimal getRrp_inde1_100_10_acceptance_amount() {
		return rrp_inde1_100_10_acceptance_amount;
	}
	public void setRrp_inde1_100_10_acceptance_amount(BigDecimal rrp_inde1_100_10_acceptance_amount) {
		this.rrp_inde1_100_10_acceptance_amount = rrp_inde1_100_10_acceptance_amount;
	}
	public BigDecimal getRrp_inde1_100_10_lcbg_crm() {
		return rrp_inde1_100_10_lcbg_crm;
	}
	public void setRrp_inde1_100_10_lcbg_crm(BigDecimal rrp_inde1_100_10_lcbg_crm) {
		this.rrp_inde1_100_10_lcbg_crm = rrp_inde1_100_10_lcbg_crm;
	}
	public BigDecimal getRrp_inde1_100_10_rwa() {
		return rrp_inde1_100_10_rwa;
	}
	public void setRrp_inde1_100_10_rwa(BigDecimal rrp_inde1_100_10_rwa) {
		this.rrp_inde1_100_10_rwa = rrp_inde1_100_10_rwa;
	}
	public BigDecimal getRrp_inde1_100_10_under_ccf_amt() {
		return rrp_inde1_100_10_under_ccf_amt;
	}
	public void setRrp_inde1_100_10_under_ccf_amt(BigDecimal rrp_inde1_100_10_under_ccf_amt) {
		this.rrp_inde1_100_10_under_ccf_amt = rrp_inde1_100_10_under_ccf_amt;
	}
	public BigDecimal getRrp_inde1_100_lcbg_balance() {
		return rrp_inde1_100_lcbg_balance;
	}
	public void setRrp_inde1_100_lcbg_balance(BigDecimal rrp_inde1_100_lcbg_balance) {
		this.rrp_inde1_100_lcbg_balance = rrp_inde1_100_lcbg_balance;
	}
	public BigDecimal getRrp_inde1_100_acceptance_amount() {
		return rrp_inde1_100_acceptance_amount;
	}
	public void setRrp_inde1_100_acceptance_amount(BigDecimal rrp_inde1_100_acceptance_amount) {
		this.rrp_inde1_100_acceptance_amount = rrp_inde1_100_acceptance_amount;
	}
	public BigDecimal getRrp_inde1_100_lcbg_crm() {
		return rrp_inde1_100_lcbg_crm;
	}
	public void setRrp_inde1_100_lcbg_crm(BigDecimal rrp_inde1_100_lcbg_crm) {
		this.rrp_inde1_100_lcbg_crm = rrp_inde1_100_lcbg_crm;
	}
	public BigDecimal getRrp_inde1_100_rwa() {
		return rrp_inde1_100_rwa;
	}
	public void setRrp_inde1_100_rwa(BigDecimal rrp_inde1_100_rwa) {
		this.rrp_inde1_100_rwa = rrp_inde1_100_rwa;
	}
	public BigDecimal getRrp_inde1_100_under_ccf_amt() {
		return rrp_inde1_100_under_ccf_amt;
	}
	public void setRrp_inde1_100_under_ccf_amt(BigDecimal rrp_inde1_100_under_ccf_amt) {
		this.rrp_inde1_100_under_ccf_amt = rrp_inde1_100_under_ccf_amt;
	}
	public BigDecimal getRrp_inde1_150_20_lcbg_balance() {
		return rrp_inde1_150_20_lcbg_balance;
	}
	public void setRrp_inde1_150_20_lcbg_balance(BigDecimal rrp_inde1_150_20_lcbg_balance) {
		this.rrp_inde1_150_20_lcbg_balance = rrp_inde1_150_20_lcbg_balance;
	}
	public BigDecimal getRrp_inde1_150_20_acceptance_amount() {
		return rrp_inde1_150_20_acceptance_amount;
	}
	public void setRrp_inde1_150_20_acceptance_amount(BigDecimal rrp_inde1_150_20_acceptance_amount) {
		this.rrp_inde1_150_20_acceptance_amount = rrp_inde1_150_20_acceptance_amount;
	}
	public BigDecimal getRrp_inde1_150_20_lcbg_crm() {
		return rrp_inde1_150_20_lcbg_crm;
	}
	public void setRrp_inde1_150_20_lcbg_crm(BigDecimal rrp_inde1_150_20_lcbg_crm) {
		this.rrp_inde1_150_20_lcbg_crm = rrp_inde1_150_20_lcbg_crm;
	}
	public BigDecimal getRrp_inde1_150_20_rwa() {
		return rrp_inde1_150_20_rwa;
	}
	public void setRrp_inde1_150_20_rwa(BigDecimal rrp_inde1_150_20_rwa) {
		this.rrp_inde1_150_20_rwa = rrp_inde1_150_20_rwa;
	}
	public BigDecimal getRrp_inde1_150_20_under_ccf_amt() {
		return rrp_inde1_150_20_under_ccf_amt;
	}
	public void setRrp_inde1_150_20_under_ccf_amt(BigDecimal rrp_inde1_150_20_under_ccf_amt) {
		this.rrp_inde1_150_20_under_ccf_amt = rrp_inde1_150_20_under_ccf_amt;
	}
	public BigDecimal getRrp_inde1_150_50_lcbg_balance() {
		return rrp_inde1_150_50_lcbg_balance;
	}
	public void setRrp_inde1_150_50_lcbg_balance(BigDecimal rrp_inde1_150_50_lcbg_balance) {
		this.rrp_inde1_150_50_lcbg_balance = rrp_inde1_150_50_lcbg_balance;
	}
	public BigDecimal getRrp_inde1_150_50_acceptance_amount() {
		return rrp_inde1_150_50_acceptance_amount;
	}
	public void setRrp_inde1_150_50_acceptance_amount(BigDecimal rrp_inde1_150_50_acceptance_amount) {
		this.rrp_inde1_150_50_acceptance_amount = rrp_inde1_150_50_acceptance_amount;
	}
	public BigDecimal getRrp_inde1_150_50_lcbg_crm() {
		return rrp_inde1_150_50_lcbg_crm;
	}
	public void setRrp_inde1_150_50_lcbg_crm(BigDecimal rrp_inde1_150_50_lcbg_crm) {
		this.rrp_inde1_150_50_lcbg_crm = rrp_inde1_150_50_lcbg_crm;
	}
	public BigDecimal getRrp_inde1_150_50_rwa() {
		return rrp_inde1_150_50_rwa;
	}
	public void setRrp_inde1_150_50_rwa(BigDecimal rrp_inde1_150_50_rwa) {
		this.rrp_inde1_150_50_rwa = rrp_inde1_150_50_rwa;
	}
	public BigDecimal getRrp_inde1_150_50_under_ccf_amt() {
		return rrp_inde1_150_50_under_ccf_amt;
	}
	public void setRrp_inde1_150_50_under_ccf_amt(BigDecimal rrp_inde1_150_50_under_ccf_amt) {
		this.rrp_inde1_150_50_under_ccf_amt = rrp_inde1_150_50_under_ccf_amt;
	}
	public BigDecimal getRrp_inde1_150_10_lcbg_balance() {
		return rrp_inde1_150_10_lcbg_balance;
	}
	public void setRrp_inde1_150_10_lcbg_balance(BigDecimal rrp_inde1_150_10_lcbg_balance) {
		this.rrp_inde1_150_10_lcbg_balance = rrp_inde1_150_10_lcbg_balance;
	}
	public BigDecimal getRrp_inde1_150_10_acceptance_amount() {
		return rrp_inde1_150_10_acceptance_amount;
	}
	public void setRrp_inde1_150_10_acceptance_amount(BigDecimal rrp_inde1_150_10_acceptance_amount) {
		this.rrp_inde1_150_10_acceptance_amount = rrp_inde1_150_10_acceptance_amount;
	}
	public BigDecimal getRrp_inde1_150_10_lcbg_crm() {
		return rrp_inde1_150_10_lcbg_crm;
	}
	public void setRrp_inde1_150_10_lcbg_crm(BigDecimal rrp_inde1_150_10_lcbg_crm) {
		this.rrp_inde1_150_10_lcbg_crm = rrp_inde1_150_10_lcbg_crm;
	}
	public BigDecimal getRrp_inde1_150_10_rwa() {
		return rrp_inde1_150_10_rwa;
	}
	public void setRrp_inde1_150_10_rwa(BigDecimal rrp_inde1_150_10_rwa) {
		this.rrp_inde1_150_10_rwa = rrp_inde1_150_10_rwa;
	}
	public BigDecimal getRrp_inde1_150_10_under_ccf_amt() {
		return rrp_inde1_150_10_under_ccf_amt;
	}
	public void setRrp_inde1_150_10_under_ccf_amt(BigDecimal rrp_inde1_150_10_under_ccf_amt) {
		this.rrp_inde1_150_10_under_ccf_amt = rrp_inde1_150_10_under_ccf_amt;
	}
	public BigDecimal getRrp_inde1_150_lcbg_balance() {
		return rrp_inde1_150_lcbg_balance;
	}
	public void setRrp_inde1_150_lcbg_balance(BigDecimal rrp_inde1_150_lcbg_balance) {
		this.rrp_inde1_150_lcbg_balance = rrp_inde1_150_lcbg_balance;
	}
	public BigDecimal getRrp_inde1_150_acceptance_amount() {
		return rrp_inde1_150_acceptance_amount;
	}
	public void setRrp_inde1_150_acceptance_amount(BigDecimal rrp_inde1_150_acceptance_amount) {
		this.rrp_inde1_150_acceptance_amount = rrp_inde1_150_acceptance_amount;
	}
	public BigDecimal getRrp_inde1_150_lcbg_crm() {
		return rrp_inde1_150_lcbg_crm;
	}
	public void setRrp_inde1_150_lcbg_crm(BigDecimal rrp_inde1_150_lcbg_crm) {
		this.rrp_inde1_150_lcbg_crm = rrp_inde1_150_lcbg_crm;
	}
	public BigDecimal getRrp_inde1_150_rwa() {
		return rrp_inde1_150_rwa;
	}
	public void setRrp_inde1_150_rwa(BigDecimal rrp_inde1_150_rwa) {
		this.rrp_inde1_150_rwa = rrp_inde1_150_rwa;
	}
	public BigDecimal getRrp_inde1_150_under_ccf_amt() {
		return rrp_inde1_150_under_ccf_amt;
	}
	public void setRrp_inde1_150_under_ccf_amt(BigDecimal rrp_inde1_150_under_ccf_amt) {
		this.rrp_inde1_150_under_ccf_amt = rrp_inde1_150_under_ccf_amt;
	}
	public BigDecimal getRrp_inde2_0_20_lcbg_balance() {
		return rrp_inde2_0_20_lcbg_balance;
	}
	public void setRrp_inde2_0_20_lcbg_balance(BigDecimal rrp_inde2_0_20_lcbg_balance) {
		this.rrp_inde2_0_20_lcbg_balance = rrp_inde2_0_20_lcbg_balance;
	}
	public BigDecimal getRrp_inde2_0_20_acceptance_amount() {
		return rrp_inde2_0_20_acceptance_amount;
	}
	public void setRrp_inde2_0_20_acceptance_amount(BigDecimal rrp_inde2_0_20_acceptance_amount) {
		this.rrp_inde2_0_20_acceptance_amount = rrp_inde2_0_20_acceptance_amount;
	}
	public BigDecimal getRrp_inde2_0_20_lcbg_crm() {
		return rrp_inde2_0_20_lcbg_crm;
	}
	public void setRrp_inde2_0_20_lcbg_crm(BigDecimal rrp_inde2_0_20_lcbg_crm) {
		this.rrp_inde2_0_20_lcbg_crm = rrp_inde2_0_20_lcbg_crm;
	}
	public BigDecimal getRrp_inde2_0_20_rwa() {
		return rrp_inde2_0_20_rwa;
	}
	public void setRrp_inde2_0_20_rwa(BigDecimal rrp_inde2_0_20_rwa) {
		this.rrp_inde2_0_20_rwa = rrp_inde2_0_20_rwa;
	}
	public BigDecimal getRrp_inde2_0_20_under_ccf_amt() {
		return rrp_inde2_0_20_under_ccf_amt;
	}
	public void setRrp_inde2_0_20_under_ccf_amt(BigDecimal rrp_inde2_0_20_under_ccf_amt) {
		this.rrp_inde2_0_20_under_ccf_amt = rrp_inde2_0_20_under_ccf_amt;
	}
	public BigDecimal getRrp_inde2_0_50_lcbg_balance() {
		return rrp_inde2_0_50_lcbg_balance;
	}
	public void setRrp_inde2_0_50_lcbg_balance(BigDecimal rrp_inde2_0_50_lcbg_balance) {
		this.rrp_inde2_0_50_lcbg_balance = rrp_inde2_0_50_lcbg_balance;
	}
	public BigDecimal getRrp_inde2_0_50_acceptance_amount() {
		return rrp_inde2_0_50_acceptance_amount;
	}
	public void setRrp_inde2_0_50_acceptance_amount(BigDecimal rrp_inde2_0_50_acceptance_amount) {
		this.rrp_inde2_0_50_acceptance_amount = rrp_inde2_0_50_acceptance_amount;
	}
	public BigDecimal getRrp_inde2_0_50_lcbg_crm() {
		return rrp_inde2_0_50_lcbg_crm;
	}
	public void setRrp_inde2_0_50_lcbg_crm(BigDecimal rrp_inde2_0_50_lcbg_crm) {
		this.rrp_inde2_0_50_lcbg_crm = rrp_inde2_0_50_lcbg_crm;
	}
	public BigDecimal getRrp_inde2_0_50_rwa() {
		return rrp_inde2_0_50_rwa;
	}
	public void setRrp_inde2_0_50_rwa(BigDecimal rrp_inde2_0_50_rwa) {
		this.rrp_inde2_0_50_rwa = rrp_inde2_0_50_rwa;
	}
	public BigDecimal getRrp_inde2_0_50_under_ccf_amt() {
		return rrp_inde2_0_50_under_ccf_amt;
	}
	public void setRrp_inde2_0_50_under_ccf_amt(BigDecimal rrp_inde2_0_50_under_ccf_amt) {
		this.rrp_inde2_0_50_under_ccf_amt = rrp_inde2_0_50_under_ccf_amt;
	}
	public BigDecimal getRrp_inde2_0_10_lcbg_balance() {
		return rrp_inde2_0_10_lcbg_balance;
	}
	public void setRrp_inde2_0_10_lcbg_balance(BigDecimal rrp_inde2_0_10_lcbg_balance) {
		this.rrp_inde2_0_10_lcbg_balance = rrp_inde2_0_10_lcbg_balance;
	}
	public BigDecimal getRrp_inde2_0_10_acceptance_amount() {
		return rrp_inde2_0_10_acceptance_amount;
	}
	public void setRrp_inde2_0_10_acceptance_amount(BigDecimal rrp_inde2_0_10_acceptance_amount) {
		this.rrp_inde2_0_10_acceptance_amount = rrp_inde2_0_10_acceptance_amount;
	}
	public BigDecimal getRrp_inde2_0_10_lcbg_crm() {
		return rrp_inde2_0_10_lcbg_crm;
	}
	public void setRrp_inde2_0_10_lcbg_crm(BigDecimal rrp_inde2_0_10_lcbg_crm) {
		this.rrp_inde2_0_10_lcbg_crm = rrp_inde2_0_10_lcbg_crm;
	}
	public BigDecimal getRrp_inde2_0_10_rwa() {
		return rrp_inde2_0_10_rwa;
	}
	public void setRrp_inde2_0_10_rwa(BigDecimal rrp_inde2_0_10_rwa) {
		this.rrp_inde2_0_10_rwa = rrp_inde2_0_10_rwa;
	}
	public BigDecimal getRrp_inde2_0_10_under_ccf_amt() {
		return rrp_inde2_0_10_under_ccf_amt;
	}
	public void setRrp_inde2_0_10_under_ccf_amt(BigDecimal rrp_inde2_0_10_under_ccf_amt) {
		this.rrp_inde2_0_10_under_ccf_amt = rrp_inde2_0_10_under_ccf_amt;
	}
	public BigDecimal getRrp_inde2_0_lcbg_balance() {
		return rrp_inde2_0_lcbg_balance;
	}
	public void setRrp_inde2_0_lcbg_balance(BigDecimal rrp_inde2_0_lcbg_balance) {
		this.rrp_inde2_0_lcbg_balance = rrp_inde2_0_lcbg_balance;
	}
	public BigDecimal getRrp_inde2_0_acceptance_amount() {
		return rrp_inde2_0_acceptance_amount;
	}
	public void setRrp_inde2_0_acceptance_amount(BigDecimal rrp_inde2_0_acceptance_amount) {
		this.rrp_inde2_0_acceptance_amount = rrp_inde2_0_acceptance_amount;
	}
	public BigDecimal getRrp_inde2_0_lcbg_crm() {
		return rrp_inde2_0_lcbg_crm;
	}
	public void setRrp_inde2_0_lcbg_crm(BigDecimal rrp_inde2_0_lcbg_crm) {
		this.rrp_inde2_0_lcbg_crm = rrp_inde2_0_lcbg_crm;
	}
	public BigDecimal getRrp_inde2_0_rwa() {
		return rrp_inde2_0_rwa;
	}
	public void setRrp_inde2_0_rwa(BigDecimal rrp_inde2_0_rwa) {
		this.rrp_inde2_0_rwa = rrp_inde2_0_rwa;
	}
	public BigDecimal getRrp_inde2_0_under_ccf_amt() {
		return rrp_inde2_0_under_ccf_amt;
	}
	public void setRrp_inde2_0_under_ccf_amt(BigDecimal rrp_inde2_0_under_ccf_amt) {
		this.rrp_inde2_0_under_ccf_amt = rrp_inde2_0_under_ccf_amt;
	}
	public BigDecimal getRrp_inde2_20_20_lcbg_balance() {
		return rrp_inde2_20_20_lcbg_balance;
	}
	public void setRrp_inde2_20_20_lcbg_balance(BigDecimal rrp_inde2_20_20_lcbg_balance) {
		this.rrp_inde2_20_20_lcbg_balance = rrp_inde2_20_20_lcbg_balance;
	}
	public BigDecimal getRrp_inde2_20_20_acceptance_amount() {
		return rrp_inde2_20_20_acceptance_amount;
	}
	public void setRrp_inde2_20_20_acceptance_amount(BigDecimal rrp_inde2_20_20_acceptance_amount) {
		this.rrp_inde2_20_20_acceptance_amount = rrp_inde2_20_20_acceptance_amount;
	}
	public BigDecimal getRrp_inde2_20_20_lcbg_crm() {
		return rrp_inde2_20_20_lcbg_crm;
	}
	public void setRrp_inde2_20_20_lcbg_crm(BigDecimal rrp_inde2_20_20_lcbg_crm) {
		this.rrp_inde2_20_20_lcbg_crm = rrp_inde2_20_20_lcbg_crm;
	}
	public BigDecimal getRrp_inde2_20_20_rwa() {
		return rrp_inde2_20_20_rwa;
	}
	public void setRrp_inde2_20_20_rwa(BigDecimal rrp_inde2_20_20_rwa) {
		this.rrp_inde2_20_20_rwa = rrp_inde2_20_20_rwa;
	}
	public BigDecimal getRrp_inde2_20_20_under_ccf_amt() {
		return rrp_inde2_20_20_under_ccf_amt;
	}
	public void setRrp_inde2_20_20_under_ccf_amt(BigDecimal rrp_inde2_20_20_under_ccf_amt) {
		this.rrp_inde2_20_20_under_ccf_amt = rrp_inde2_20_20_under_ccf_amt;
	}
	public BigDecimal getRrp_inde2_20_50_lcbg_balance() {
		return rrp_inde2_20_50_lcbg_balance;
	}
	public void setRrp_inde2_20_50_lcbg_balance(BigDecimal rrp_inde2_20_50_lcbg_balance) {
		this.rrp_inde2_20_50_lcbg_balance = rrp_inde2_20_50_lcbg_balance;
	}
	public BigDecimal getRrp_inde2_20_50_acceptance_amount() {
		return rrp_inde2_20_50_acceptance_amount;
	}
	public void setRrp_inde2_20_50_acceptance_amount(BigDecimal rrp_inde2_20_50_acceptance_amount) {
		this.rrp_inde2_20_50_acceptance_amount = rrp_inde2_20_50_acceptance_amount;
	}
	public BigDecimal getRrp_inde2_20_50_lcbg_crm() {
		return rrp_inde2_20_50_lcbg_crm;
	}
	public void setRrp_inde2_20_50_lcbg_crm(BigDecimal rrp_inde2_20_50_lcbg_crm) {
		this.rrp_inde2_20_50_lcbg_crm = rrp_inde2_20_50_lcbg_crm;
	}
	public BigDecimal getRrp_inde2_20_50_rwa() {
		return rrp_inde2_20_50_rwa;
	}
	public void setRrp_inde2_20_50_rwa(BigDecimal rrp_inde2_20_50_rwa) {
		this.rrp_inde2_20_50_rwa = rrp_inde2_20_50_rwa;
	}
	public BigDecimal getRrp_inde2_20_50_under_ccf_amt() {
		return rrp_inde2_20_50_under_ccf_amt;
	}
	public void setRrp_inde2_20_50_under_ccf_amt(BigDecimal rrp_inde2_20_50_under_ccf_amt) {
		this.rrp_inde2_20_50_under_ccf_amt = rrp_inde2_20_50_under_ccf_amt;
	}
	public BigDecimal getRrp_inde2_20_10_lcbg_balance() {
		return rrp_inde2_20_10_lcbg_balance;
	}
	public void setRrp_inde2_20_10_lcbg_balance(BigDecimal rrp_inde2_20_10_lcbg_balance) {
		this.rrp_inde2_20_10_lcbg_balance = rrp_inde2_20_10_lcbg_balance;
	}
	public BigDecimal getRrp_inde2_20_10_acceptance_amount() {
		return rrp_inde2_20_10_acceptance_amount;
	}
	public void setRrp_inde2_20_10_acceptance_amount(BigDecimal rrp_inde2_20_10_acceptance_amount) {
		this.rrp_inde2_20_10_acceptance_amount = rrp_inde2_20_10_acceptance_amount;
	}
	public BigDecimal getRrp_inde2_20_10_lcbg_crm() {
		return rrp_inde2_20_10_lcbg_crm;
	}
	public void setRrp_inde2_20_10_lcbg_crm(BigDecimal rrp_inde2_20_10_lcbg_crm) {
		this.rrp_inde2_20_10_lcbg_crm = rrp_inde2_20_10_lcbg_crm;
	}
	public BigDecimal getRrp_inde2_20_10_rwa() {
		return rrp_inde2_20_10_rwa;
	}
	public void setRrp_inde2_20_10_rwa(BigDecimal rrp_inde2_20_10_rwa) {
		this.rrp_inde2_20_10_rwa = rrp_inde2_20_10_rwa;
	}
	public BigDecimal getRrp_inde2_20_10_under_ccf_amt() {
		return rrp_inde2_20_10_under_ccf_amt;
	}
	public void setRrp_inde2_20_10_under_ccf_amt(BigDecimal rrp_inde2_20_10_under_ccf_amt) {
		this.rrp_inde2_20_10_under_ccf_amt = rrp_inde2_20_10_under_ccf_amt;
	}
	public BigDecimal getRrp_inde2_20_lcbg_balance() {
		return rrp_inde2_20_lcbg_balance;
	}
	public void setRrp_inde2_20_lcbg_balance(BigDecimal rrp_inde2_20_lcbg_balance) {
		this.rrp_inde2_20_lcbg_balance = rrp_inde2_20_lcbg_balance;
	}
	public BigDecimal getRrp_inde2_20_acceptance_amount() {
		return rrp_inde2_20_acceptance_amount;
	}
	public void setRrp_inde2_20_acceptance_amount(BigDecimal rrp_inde2_20_acceptance_amount) {
		this.rrp_inde2_20_acceptance_amount = rrp_inde2_20_acceptance_amount;
	}
	public BigDecimal getRrp_inde2_20_lcbg_crm() {
		return rrp_inde2_20_lcbg_crm;
	}
	public void setRrp_inde2_20_lcbg_crm(BigDecimal rrp_inde2_20_lcbg_crm) {
		this.rrp_inde2_20_lcbg_crm = rrp_inde2_20_lcbg_crm;
	}
	public BigDecimal getRrp_inde2_20_rwa() {
		return rrp_inde2_20_rwa;
	}
	public void setRrp_inde2_20_rwa(BigDecimal rrp_inde2_20_rwa) {
		this.rrp_inde2_20_rwa = rrp_inde2_20_rwa;
	}
	public BigDecimal getRrp_inde2_20_under_ccf_amt() {
		return rrp_inde2_20_under_ccf_amt;
	}
	public void setRrp_inde2_20_under_ccf_amt(BigDecimal rrp_inde2_20_under_ccf_amt) {
		this.rrp_inde2_20_under_ccf_amt = rrp_inde2_20_under_ccf_amt;
	}
	public BigDecimal getRrp_inde2_50_20_lcbg_balance() {
		return rrp_inde2_50_20_lcbg_balance;
	}
	public void setRrp_inde2_50_20_lcbg_balance(BigDecimal rrp_inde2_50_20_lcbg_balance) {
		this.rrp_inde2_50_20_lcbg_balance = rrp_inde2_50_20_lcbg_balance;
	}
	public BigDecimal getRrp_inde2_50_20_acceptance_amount() {
		return rrp_inde2_50_20_acceptance_amount;
	}
	public void setRrp_inde2_50_20_acceptance_amount(BigDecimal rrp_inde2_50_20_acceptance_amount) {
		this.rrp_inde2_50_20_acceptance_amount = rrp_inde2_50_20_acceptance_amount;
	}
	public BigDecimal getRrp_inde2_50_20_lcbg_crm() {
		return rrp_inde2_50_20_lcbg_crm;
	}
	public void setRrp_inde2_50_20_lcbg_crm(BigDecimal rrp_inde2_50_20_lcbg_crm) {
		this.rrp_inde2_50_20_lcbg_crm = rrp_inde2_50_20_lcbg_crm;
	}
	public BigDecimal getRrp_inde2_50_20_rwa() {
		return rrp_inde2_50_20_rwa;
	}
	public void setRrp_inde2_50_20_rwa(BigDecimal rrp_inde2_50_20_rwa) {
		this.rrp_inde2_50_20_rwa = rrp_inde2_50_20_rwa;
	}
	public BigDecimal getRrp_inde2_50_20_under_ccf_amt() {
		return rrp_inde2_50_20_under_ccf_amt;
	}
	public void setRrp_inde2_50_20_under_ccf_amt(BigDecimal rrp_inde2_50_20_under_ccf_amt) {
		this.rrp_inde2_50_20_under_ccf_amt = rrp_inde2_50_20_under_ccf_amt;
	}
	public BigDecimal getRrp_inde2_50_50_lcbg_balance() {
		return rrp_inde2_50_50_lcbg_balance;
	}
	public void setRrp_inde2_50_50_lcbg_balance(BigDecimal rrp_inde2_50_50_lcbg_balance) {
		this.rrp_inde2_50_50_lcbg_balance = rrp_inde2_50_50_lcbg_balance;
	}
	public BigDecimal getRrp_inde2_50_50_acceptance_amount() {
		return rrp_inde2_50_50_acceptance_amount;
	}
	public void setRrp_inde2_50_50_acceptance_amount(BigDecimal rrp_inde2_50_50_acceptance_amount) {
		this.rrp_inde2_50_50_acceptance_amount = rrp_inde2_50_50_acceptance_amount;
	}
	public BigDecimal getRrp_inde2_50_50_lcbg_crm() {
		return rrp_inde2_50_50_lcbg_crm;
	}
	public void setRrp_inde2_50_50_lcbg_crm(BigDecimal rrp_inde2_50_50_lcbg_crm) {
		this.rrp_inde2_50_50_lcbg_crm = rrp_inde2_50_50_lcbg_crm;
	}
	public BigDecimal getRrp_inde2_50_50_rwa() {
		return rrp_inde2_50_50_rwa;
	}
	public void setRrp_inde2_50_50_rwa(BigDecimal rrp_inde2_50_50_rwa) {
		this.rrp_inde2_50_50_rwa = rrp_inde2_50_50_rwa;
	}
	public BigDecimal getRrp_inde2_50_50_under_ccf_amt() {
		return rrp_inde2_50_50_under_ccf_amt;
	}
	public void setRrp_inde2_50_50_under_ccf_amt(BigDecimal rrp_inde2_50_50_under_ccf_amt) {
		this.rrp_inde2_50_50_under_ccf_amt = rrp_inde2_50_50_under_ccf_amt;
	}
	public BigDecimal getRrp_inde2_50_10_lcbg_balance() {
		return rrp_inde2_50_10_lcbg_balance;
	}
	public void setRrp_inde2_50_10_lcbg_balance(BigDecimal rrp_inde2_50_10_lcbg_balance) {
		this.rrp_inde2_50_10_lcbg_balance = rrp_inde2_50_10_lcbg_balance;
	}
	public BigDecimal getRrp_inde2_50_10_acceptance_amount() {
		return rrp_inde2_50_10_acceptance_amount;
	}
	public void setRrp_inde2_50_10_acceptance_amount(BigDecimal rrp_inde2_50_10_acceptance_amount) {
		this.rrp_inde2_50_10_acceptance_amount = rrp_inde2_50_10_acceptance_amount;
	}
	public BigDecimal getRrp_inde2_50_10_lcbg_crm() {
		return rrp_inde2_50_10_lcbg_crm;
	}
	public void setRrp_inde2_50_10_lcbg_crm(BigDecimal rrp_inde2_50_10_lcbg_crm) {
		this.rrp_inde2_50_10_lcbg_crm = rrp_inde2_50_10_lcbg_crm;
	}
	public BigDecimal getRrp_inde2_50_10_rwa() {
		return rrp_inde2_50_10_rwa;
	}
	public void setRrp_inde2_50_10_rwa(BigDecimal rrp_inde2_50_10_rwa) {
		this.rrp_inde2_50_10_rwa = rrp_inde2_50_10_rwa;
	}
	public BigDecimal getRrp_inde2_50_10_under_ccf_amt() {
		return rrp_inde2_50_10_under_ccf_amt;
	}
	public void setRrp_inde2_50_10_under_ccf_amt(BigDecimal rrp_inde2_50_10_under_ccf_amt) {
		this.rrp_inde2_50_10_under_ccf_amt = rrp_inde2_50_10_under_ccf_amt;
	}
	public BigDecimal getRrp_inde2_50_lcbg_balance() {
		return rrp_inde2_50_lcbg_balance;
	}
	public void setRrp_inde2_50_lcbg_balance(BigDecimal rrp_inde2_50_lcbg_balance) {
		this.rrp_inde2_50_lcbg_balance = rrp_inde2_50_lcbg_balance;
	}
	public BigDecimal getRrp_inde2_50_acceptance_amount() {
		return rrp_inde2_50_acceptance_amount;
	}
	public void setRrp_inde2_50_acceptance_amount(BigDecimal rrp_inde2_50_acceptance_amount) {
		this.rrp_inde2_50_acceptance_amount = rrp_inde2_50_acceptance_amount;
	}
	public BigDecimal getRrp_inde2_50_lcbg_crm() {
		return rrp_inde2_50_lcbg_crm;
	}
	public void setRrp_inde2_50_lcbg_crm(BigDecimal rrp_inde2_50_lcbg_crm) {
		this.rrp_inde2_50_lcbg_crm = rrp_inde2_50_lcbg_crm;
	}
	public BigDecimal getRrp_inde2_50_rwa() {
		return rrp_inde2_50_rwa;
	}
	public void setRrp_inde2_50_rwa(BigDecimal rrp_inde2_50_rwa) {
		this.rrp_inde2_50_rwa = rrp_inde2_50_rwa;
	}
	public BigDecimal getRrp_inde2_50_under_ccf_amt() {
		return rrp_inde2_50_under_ccf_amt;
	}
	public void setRrp_inde2_50_under_ccf_amt(BigDecimal rrp_inde2_50_under_ccf_amt) {
		this.rrp_inde2_50_under_ccf_amt = rrp_inde2_50_under_ccf_amt;
	}
	public BigDecimal getRrp_inde2_150_20_lcbg_balance() {
		return rrp_inde2_150_20_lcbg_balance;
	}
	public void setRrp_inde2_150_20_lcbg_balance(BigDecimal rrp_inde2_150_20_lcbg_balance) {
		this.rrp_inde2_150_20_lcbg_balance = rrp_inde2_150_20_lcbg_balance;
	}
	public BigDecimal getRrp_inde2_150_20_acceptance_amount() {
		return rrp_inde2_150_20_acceptance_amount;
	}
	public void setRrp_inde2_150_20_acceptance_amount(BigDecimal rrp_inde2_150_20_acceptance_amount) {
		this.rrp_inde2_150_20_acceptance_amount = rrp_inde2_150_20_acceptance_amount;
	}
	public BigDecimal getRrp_inde2_150_20_lcbg_crm() {
		return rrp_inde2_150_20_lcbg_crm;
	}
	public void setRrp_inde2_150_20_lcbg_crm(BigDecimal rrp_inde2_150_20_lcbg_crm) {
		this.rrp_inde2_150_20_lcbg_crm = rrp_inde2_150_20_lcbg_crm;
	}
	public BigDecimal getRrp_inde2_150_20_rwa() {
		return rrp_inde2_150_20_rwa;
	}
	public void setRrp_inde2_150_20_rwa(BigDecimal rrp_inde2_150_20_rwa) {
		this.rrp_inde2_150_20_rwa = rrp_inde2_150_20_rwa;
	}
	public BigDecimal getRrp_inde2_150_20_under_ccf_amt() {
		return rrp_inde2_150_20_under_ccf_amt;
	}
	public void setRrp_inde2_150_20_under_ccf_amt(BigDecimal rrp_inde2_150_20_under_ccf_amt) {
		this.rrp_inde2_150_20_under_ccf_amt = rrp_inde2_150_20_under_ccf_amt;
	}
	public BigDecimal getRrp_inde2_150_50_lcbg_balance() {
		return rrp_inde2_150_50_lcbg_balance;
	}
	public void setRrp_inde2_150_50_lcbg_balance(BigDecimal rrp_inde2_150_50_lcbg_balance) {
		this.rrp_inde2_150_50_lcbg_balance = rrp_inde2_150_50_lcbg_balance;
	}
	public BigDecimal getRrp_inde2_150_50_acceptance_amount() {
		return rrp_inde2_150_50_acceptance_amount;
	}
	public void setRrp_inde2_150_50_acceptance_amount(BigDecimal rrp_inde2_150_50_acceptance_amount) {
		this.rrp_inde2_150_50_acceptance_amount = rrp_inde2_150_50_acceptance_amount;
	}
	public BigDecimal getRrp_inde2_150_50_lcbg_crm() {
		return rrp_inde2_150_50_lcbg_crm;
	}
	public void setRrp_inde2_150_50_lcbg_crm(BigDecimal rrp_inde2_150_50_lcbg_crm) {
		this.rrp_inde2_150_50_lcbg_crm = rrp_inde2_150_50_lcbg_crm;
	}
	public BigDecimal getRrp_inde2_150_50_rwa() {
		return rrp_inde2_150_50_rwa;
	}
	public void setRrp_inde2_150_50_rwa(BigDecimal rrp_inde2_150_50_rwa) {
		this.rrp_inde2_150_50_rwa = rrp_inde2_150_50_rwa;
	}
	public BigDecimal getRrp_inde2_150_50_under_ccf_amt() {
		return rrp_inde2_150_50_under_ccf_amt;
	}
	public void setRrp_inde2_150_50_under_ccf_amt(BigDecimal rrp_inde2_150_50_under_ccf_amt) {
		this.rrp_inde2_150_50_under_ccf_amt = rrp_inde2_150_50_under_ccf_amt;
	}
	public BigDecimal getRrp_inde2_150_10_lcbg_balance() {
		return rrp_inde2_150_10_lcbg_balance;
	}
	public void setRrp_inde2_150_10_lcbg_balance(BigDecimal rrp_inde2_150_10_lcbg_balance) {
		this.rrp_inde2_150_10_lcbg_balance = rrp_inde2_150_10_lcbg_balance;
	}
	public BigDecimal getRrp_inde2_150_10_acceptance_amount() {
		return rrp_inde2_150_10_acceptance_amount;
	}
	public void setRrp_inde2_150_10_acceptance_amount(BigDecimal rrp_inde2_150_10_acceptance_amount) {
		this.rrp_inde2_150_10_acceptance_amount = rrp_inde2_150_10_acceptance_amount;
	}
	public BigDecimal getRrp_inde2_150_10_lcbg_crm() {
		return rrp_inde2_150_10_lcbg_crm;
	}
	public void setRrp_inde2_150_10_lcbg_crm(BigDecimal rrp_inde2_150_10_lcbg_crm) {
		this.rrp_inde2_150_10_lcbg_crm = rrp_inde2_150_10_lcbg_crm;
	}
	public BigDecimal getRrp_inde2_150_10_rwa() {
		return rrp_inde2_150_10_rwa;
	}
	public void setRrp_inde2_150_10_rwa(BigDecimal rrp_inde2_150_10_rwa) {
		this.rrp_inde2_150_10_rwa = rrp_inde2_150_10_rwa;
	}
	public BigDecimal getRrp_inde2_150_10_under_ccf_amt() {
		return rrp_inde2_150_10_under_ccf_amt;
	}
	public void setRrp_inde2_150_10_under_ccf_amt(BigDecimal rrp_inde2_150_10_under_ccf_amt) {
		this.rrp_inde2_150_10_under_ccf_amt = rrp_inde2_150_10_under_ccf_amt;
	}
	public BigDecimal getRrp_inde2_150_lcbg_balance() {
		return rrp_inde2_150_lcbg_balance;
	}
	public void setRrp_inde2_150_lcbg_balance(BigDecimal rrp_inde2_150_lcbg_balance) {
		this.rrp_inde2_150_lcbg_balance = rrp_inde2_150_lcbg_balance;
	}
	public BigDecimal getRrp_inde2_150_acceptance_amount() {
		return rrp_inde2_150_acceptance_amount;
	}
	public void setRrp_inde2_150_acceptance_amount(BigDecimal rrp_inde2_150_acceptance_amount) {
		this.rrp_inde2_150_acceptance_amount = rrp_inde2_150_acceptance_amount;
	}
	public BigDecimal getRrp_inde2_150_lcbg_crm() {
		return rrp_inde2_150_lcbg_crm;
	}
	public void setRrp_inde2_150_lcbg_crm(BigDecimal rrp_inde2_150_lcbg_crm) {
		this.rrp_inde2_150_lcbg_crm = rrp_inde2_150_lcbg_crm;
	}
	public BigDecimal getRrp_inde2_150_rwa() {
		return rrp_inde2_150_rwa;
	}
	public void setRrp_inde2_150_rwa(BigDecimal rrp_inde2_150_rwa) {
		this.rrp_inde2_150_rwa = rrp_inde2_150_rwa;
	}
	public BigDecimal getRrp_inde2_150_under_ccf_amt() {
		return rrp_inde2_150_under_ccf_amt;
	}
	public void setRrp_inde2_150_under_ccf_amt(BigDecimal rrp_inde2_150_under_ccf_amt) {
		this.rrp_inde2_150_under_ccf_amt = rrp_inde2_150_under_ccf_amt;
	}
	public BigDecimal getRrp_smlb_0_20_lcbg_balance() {
		return rrp_smlb_0_20_lcbg_balance;
	}
	public void setRrp_smlb_0_20_lcbg_balance(BigDecimal rrp_smlb_0_20_lcbg_balance) {
		this.rrp_smlb_0_20_lcbg_balance = rrp_smlb_0_20_lcbg_balance;
	}
	public BigDecimal getRrp_smlb_0_20_acceptance_amount() {
		return rrp_smlb_0_20_acceptance_amount;
	}
	public void setRrp_smlb_0_20_acceptance_amount(BigDecimal rrp_smlb_0_20_acceptance_amount) {
		this.rrp_smlb_0_20_acceptance_amount = rrp_smlb_0_20_acceptance_amount;
	}
	public BigDecimal getRrp_smlb_0_20_lcbg_crm() {
		return rrp_smlb_0_20_lcbg_crm;
	}
	public void setRrp_smlb_0_20_lcbg_crm(BigDecimal rrp_smlb_0_20_lcbg_crm) {
		this.rrp_smlb_0_20_lcbg_crm = rrp_smlb_0_20_lcbg_crm;
	}
	public BigDecimal getRrp_smlb_0_20_rwa() {
		return rrp_smlb_0_20_rwa;
	}
	public void setRrp_smlb_0_20_rwa(BigDecimal rrp_smlb_0_20_rwa) {
		this.rrp_smlb_0_20_rwa = rrp_smlb_0_20_rwa;
	}
	public BigDecimal getRrp_smlb_0_20_under_ccf_amt() {
		return rrp_smlb_0_20_under_ccf_amt;
	}
	public void setRrp_smlb_0_20_under_ccf_amt(BigDecimal rrp_smlb_0_20_under_ccf_amt) {
		this.rrp_smlb_0_20_under_ccf_amt = rrp_smlb_0_20_under_ccf_amt;
	}
	public BigDecimal getRrp_smlb_0_50_lcbg_balance() {
		return rrp_smlb_0_50_lcbg_balance;
	}
	public void setRrp_smlb_0_50_lcbg_balance(BigDecimal rrp_smlb_0_50_lcbg_balance) {
		this.rrp_smlb_0_50_lcbg_balance = rrp_smlb_0_50_lcbg_balance;
	}
	public BigDecimal getRrp_smlb_0_50_acceptance_amount() {
		return rrp_smlb_0_50_acceptance_amount;
	}
	public void setRrp_smlb_0_50_acceptance_amount(BigDecimal rrp_smlb_0_50_acceptance_amount) {
		this.rrp_smlb_0_50_acceptance_amount = rrp_smlb_0_50_acceptance_amount;
	}
	public BigDecimal getRrp_smlb_0_50_lcbg_crm() {
		return rrp_smlb_0_50_lcbg_crm;
	}
	public void setRrp_smlb_0_50_lcbg_crm(BigDecimal rrp_smlb_0_50_lcbg_crm) {
		this.rrp_smlb_0_50_lcbg_crm = rrp_smlb_0_50_lcbg_crm;
	}
	public BigDecimal getRrp_smlb_0_50_rwa() {
		return rrp_smlb_0_50_rwa;
	}
	public void setRrp_smlb_0_50_rwa(BigDecimal rrp_smlb_0_50_rwa) {
		this.rrp_smlb_0_50_rwa = rrp_smlb_0_50_rwa;
	}
	public BigDecimal getRrp_smlb_0_50_under_ccf_amt() {
		return rrp_smlb_0_50_under_ccf_amt;
	}
	public void setRrp_smlb_0_50_under_ccf_amt(BigDecimal rrp_smlb_0_50_under_ccf_amt) {
		this.rrp_smlb_0_50_under_ccf_amt = rrp_smlb_0_50_under_ccf_amt;
	}
	public BigDecimal getRrp_smlb_0_10_lcbg_balance() {
		return rrp_smlb_0_10_lcbg_balance;
	}
	public void setRrp_smlb_0_10_lcbg_balance(BigDecimal rrp_smlb_0_10_lcbg_balance) {
		this.rrp_smlb_0_10_lcbg_balance = rrp_smlb_0_10_lcbg_balance;
	}
	public BigDecimal getRrp_smlb_0_10_acceptance_amount() {
		return rrp_smlb_0_10_acceptance_amount;
	}
	public void setRrp_smlb_0_10_acceptance_amount(BigDecimal rrp_smlb_0_10_acceptance_amount) {
		this.rrp_smlb_0_10_acceptance_amount = rrp_smlb_0_10_acceptance_amount;
	}
	public BigDecimal getRrp_smlb_0_10_lcbg_crm() {
		return rrp_smlb_0_10_lcbg_crm;
	}
	public void setRrp_smlb_0_10_lcbg_crm(BigDecimal rrp_smlb_0_10_lcbg_crm) {
		this.rrp_smlb_0_10_lcbg_crm = rrp_smlb_0_10_lcbg_crm;
	}
	public BigDecimal getRrp_smlb_0_10_rwa() {
		return rrp_smlb_0_10_rwa;
	}
	public void setRrp_smlb_0_10_rwa(BigDecimal rrp_smlb_0_10_rwa) {
		this.rrp_smlb_0_10_rwa = rrp_smlb_0_10_rwa;
	}
	public BigDecimal getRrp_smlb_0_10_under_ccf_amt() {
		return rrp_smlb_0_10_under_ccf_amt;
	}
	public void setRrp_smlb_0_10_under_ccf_amt(BigDecimal rrp_smlb_0_10_under_ccf_amt) {
		this.rrp_smlb_0_10_under_ccf_amt = rrp_smlb_0_10_under_ccf_amt;
	}
	public BigDecimal getRrp_smlb_0_lcbg_balance() {
		return rrp_smlb_0_lcbg_balance;
	}
	public void setRrp_smlb_0_lcbg_balance(BigDecimal rrp_smlb_0_lcbg_balance) {
		this.rrp_smlb_0_lcbg_balance = rrp_smlb_0_lcbg_balance;
	}
	public BigDecimal getRrp_smlb_0_acceptance_amount() {
		return rrp_smlb_0_acceptance_amount;
	}
	public void setRrp_smlb_0_acceptance_amount(BigDecimal rrp_smlb_0_acceptance_amount) {
		this.rrp_smlb_0_acceptance_amount = rrp_smlb_0_acceptance_amount;
	}
	public BigDecimal getRrp_smlb_0_lcbg_crm() {
		return rrp_smlb_0_lcbg_crm;
	}
	public void setRrp_smlb_0_lcbg_crm(BigDecimal rrp_smlb_0_lcbg_crm) {
		this.rrp_smlb_0_lcbg_crm = rrp_smlb_0_lcbg_crm;
	}
	public BigDecimal getRrp_smlb_0_rwa() {
		return rrp_smlb_0_rwa;
	}
	public void setRrp_smlb_0_rwa(BigDecimal rrp_smlb_0_rwa) {
		this.rrp_smlb_0_rwa = rrp_smlb_0_rwa;
	}
	public BigDecimal getRrp_smlb_0_under_ccf_amt() {
		return rrp_smlb_0_under_ccf_amt;
	}
	public void setRrp_smlb_0_under_ccf_amt(BigDecimal rrp_smlb_0_under_ccf_amt) {
		this.rrp_smlb_0_under_ccf_amt = rrp_smlb_0_under_ccf_amt;
	}
	public BigDecimal getRrp_smlb_20_20_lcbg_balance() {
		return rrp_smlb_20_20_lcbg_balance;
	}
	public void setRrp_smlb_20_20_lcbg_balance(BigDecimal rrp_smlb_20_20_lcbg_balance) {
		this.rrp_smlb_20_20_lcbg_balance = rrp_smlb_20_20_lcbg_balance;
	}
	public BigDecimal getRrp_smlb_20_20_acceptance_amount() {
		return rrp_smlb_20_20_acceptance_amount;
	}
	public void setRrp_smlb_20_20_acceptance_amount(BigDecimal rrp_smlb_20_20_acceptance_amount) {
		this.rrp_smlb_20_20_acceptance_amount = rrp_smlb_20_20_acceptance_amount;
	}
	public BigDecimal getRrp_smlb_20_20_lcbg_crm() {
		return rrp_smlb_20_20_lcbg_crm;
	}
	public void setRrp_smlb_20_20_lcbg_crm(BigDecimal rrp_smlb_20_20_lcbg_crm) {
		this.rrp_smlb_20_20_lcbg_crm = rrp_smlb_20_20_lcbg_crm;
	}
	public BigDecimal getRrp_smlb_20_20_rwa() {
		return rrp_smlb_20_20_rwa;
	}
	public void setRrp_smlb_20_20_rwa(BigDecimal rrp_smlb_20_20_rwa) {
		this.rrp_smlb_20_20_rwa = rrp_smlb_20_20_rwa;
	}
	public BigDecimal getRrp_smlb_20_20_under_ccf_amt() {
		return rrp_smlb_20_20_under_ccf_amt;
	}
	public void setRrp_smlb_20_20_under_ccf_amt(BigDecimal rrp_smlb_20_20_under_ccf_amt) {
		this.rrp_smlb_20_20_under_ccf_amt = rrp_smlb_20_20_under_ccf_amt;
	}
	public BigDecimal getRrp_smlb_20_50_lcbg_balance() {
		return rrp_smlb_20_50_lcbg_balance;
	}
	public void setRrp_smlb_20_50_lcbg_balance(BigDecimal rrp_smlb_20_50_lcbg_balance) {
		this.rrp_smlb_20_50_lcbg_balance = rrp_smlb_20_50_lcbg_balance;
	}
	public BigDecimal getRrp_smlb_20_50_acceptance_amount() {
		return rrp_smlb_20_50_acceptance_amount;
	}
	public void setRrp_smlb_20_50_acceptance_amount(BigDecimal rrp_smlb_20_50_acceptance_amount) {
		this.rrp_smlb_20_50_acceptance_amount = rrp_smlb_20_50_acceptance_amount;
	}
	public BigDecimal getRrp_smlb_20_50_lcbg_crm() {
		return rrp_smlb_20_50_lcbg_crm;
	}
	public void setRrp_smlb_20_50_lcbg_crm(BigDecimal rrp_smlb_20_50_lcbg_crm) {
		this.rrp_smlb_20_50_lcbg_crm = rrp_smlb_20_50_lcbg_crm;
	}
	public BigDecimal getRrp_smlb_20_50_rwa() {
		return rrp_smlb_20_50_rwa;
	}
	public void setRrp_smlb_20_50_rwa(BigDecimal rrp_smlb_20_50_rwa) {
		this.rrp_smlb_20_50_rwa = rrp_smlb_20_50_rwa;
	}
	public BigDecimal getRrp_smlb_20_50_under_ccf_amt() {
		return rrp_smlb_20_50_under_ccf_amt;
	}
	public void setRrp_smlb_20_50_under_ccf_amt(BigDecimal rrp_smlb_20_50_under_ccf_amt) {
		this.rrp_smlb_20_50_under_ccf_amt = rrp_smlb_20_50_under_ccf_amt;
	}
	public BigDecimal getRrp_smlb_20_10_lcbg_balance() {
		return rrp_smlb_20_10_lcbg_balance;
	}
	public void setRrp_smlb_20_10_lcbg_balance(BigDecimal rrp_smlb_20_10_lcbg_balance) {
		this.rrp_smlb_20_10_lcbg_balance = rrp_smlb_20_10_lcbg_balance;
	}
	public BigDecimal getRrp_smlb_20_10_acceptance_amount() {
		return rrp_smlb_20_10_acceptance_amount;
	}
	public void setRrp_smlb_20_10_acceptance_amount(BigDecimal rrp_smlb_20_10_acceptance_amount) {
		this.rrp_smlb_20_10_acceptance_amount = rrp_smlb_20_10_acceptance_amount;
	}
	public BigDecimal getRrp_smlb_20_10_lcbg_crm() {
		return rrp_smlb_20_10_lcbg_crm;
	}
	public void setRrp_smlb_20_10_lcbg_crm(BigDecimal rrp_smlb_20_10_lcbg_crm) {
		this.rrp_smlb_20_10_lcbg_crm = rrp_smlb_20_10_lcbg_crm;
	}
	public BigDecimal getRrp_smlb_20_10_rwa() {
		return rrp_smlb_20_10_rwa;
	}
	public void setRrp_smlb_20_10_rwa(BigDecimal rrp_smlb_20_10_rwa) {
		this.rrp_smlb_20_10_rwa = rrp_smlb_20_10_rwa;
	}
	public BigDecimal getRrp_smlb_20_10_under_ccf_amt() {
		return rrp_smlb_20_10_under_ccf_amt;
	}
	public void setRrp_smlb_20_10_under_ccf_amt(BigDecimal rrp_smlb_20_10_under_ccf_amt) {
		this.rrp_smlb_20_10_under_ccf_amt = rrp_smlb_20_10_under_ccf_amt;
	}
	public BigDecimal getRrp_smlb_20_lcbg_balance() {
		return rrp_smlb_20_lcbg_balance;
	}
	public void setRrp_smlb_20_lcbg_balance(BigDecimal rrp_smlb_20_lcbg_balance) {
		this.rrp_smlb_20_lcbg_balance = rrp_smlb_20_lcbg_balance;
	}
	public BigDecimal getRrp_smlb_20_acceptance_amount() {
		return rrp_smlb_20_acceptance_amount;
	}
	public void setRrp_smlb_20_acceptance_amount(BigDecimal rrp_smlb_20_acceptance_amount) {
		this.rrp_smlb_20_acceptance_amount = rrp_smlb_20_acceptance_amount;
	}
	public BigDecimal getRrp_smlb_20_lcbg_crm() {
		return rrp_smlb_20_lcbg_crm;
	}
	public void setRrp_smlb_20_lcbg_crm(BigDecimal rrp_smlb_20_lcbg_crm) {
		this.rrp_smlb_20_lcbg_crm = rrp_smlb_20_lcbg_crm;
	}
	public BigDecimal getRrp_smlb_20_rwa() {
		return rrp_smlb_20_rwa;
	}
	public void setRrp_smlb_20_rwa(BigDecimal rrp_smlb_20_rwa) {
		this.rrp_smlb_20_rwa = rrp_smlb_20_rwa;
	}
	public BigDecimal getRrp_smlb_20_under_ccf_amt() {
		return rrp_smlb_20_under_ccf_amt;
	}
	public void setRrp_smlb_20_under_ccf_amt(BigDecimal rrp_smlb_20_under_ccf_amt) {
		this.rrp_smlb_20_under_ccf_amt = rrp_smlb_20_under_ccf_amt;
	}
	public BigDecimal getRrp_smlb_50_20_lcbg_balance() {
		return rrp_smlb_50_20_lcbg_balance;
	}
	public void setRrp_smlb_50_20_lcbg_balance(BigDecimal rrp_smlb_50_20_lcbg_balance) {
		this.rrp_smlb_50_20_lcbg_balance = rrp_smlb_50_20_lcbg_balance;
	}
	public BigDecimal getRrp_smlb_50_20_acceptance_amount() {
		return rrp_smlb_50_20_acceptance_amount;
	}
	public void setRrp_smlb_50_20_acceptance_amount(BigDecimal rrp_smlb_50_20_acceptance_amount) {
		this.rrp_smlb_50_20_acceptance_amount = rrp_smlb_50_20_acceptance_amount;
	}
	public BigDecimal getRrp_smlb_50_20_lcbg_crm() {
		return rrp_smlb_50_20_lcbg_crm;
	}
	public void setRrp_smlb_50_20_lcbg_crm(BigDecimal rrp_smlb_50_20_lcbg_crm) {
		this.rrp_smlb_50_20_lcbg_crm = rrp_smlb_50_20_lcbg_crm;
	}
	public BigDecimal getRrp_smlb_50_20_rwa() {
		return rrp_smlb_50_20_rwa;
	}
	public void setRrp_smlb_50_20_rwa(BigDecimal rrp_smlb_50_20_rwa) {
		this.rrp_smlb_50_20_rwa = rrp_smlb_50_20_rwa;
	}
	public BigDecimal getRrp_smlb_50_20_under_ccf_amt() {
		return rrp_smlb_50_20_under_ccf_amt;
	}
	public void setRrp_smlb_50_20_under_ccf_amt(BigDecimal rrp_smlb_50_20_under_ccf_amt) {
		this.rrp_smlb_50_20_under_ccf_amt = rrp_smlb_50_20_under_ccf_amt;
	}
	public BigDecimal getRrp_smlb_50_50_lcbg_balance() {
		return rrp_smlb_50_50_lcbg_balance;
	}
	public void setRrp_smlb_50_50_lcbg_balance(BigDecimal rrp_smlb_50_50_lcbg_balance) {
		this.rrp_smlb_50_50_lcbg_balance = rrp_smlb_50_50_lcbg_balance;
	}
	public BigDecimal getRrp_smlb_50_50_acceptance_amount() {
		return rrp_smlb_50_50_acceptance_amount;
	}
	public void setRrp_smlb_50_50_acceptance_amount(BigDecimal rrp_smlb_50_50_acceptance_amount) {
		this.rrp_smlb_50_50_acceptance_amount = rrp_smlb_50_50_acceptance_amount;
	}
	public BigDecimal getRrp_smlb_50_50_lcbg_crm() {
		return rrp_smlb_50_50_lcbg_crm;
	}
	public void setRrp_smlb_50_50_lcbg_crm(BigDecimal rrp_smlb_50_50_lcbg_crm) {
		this.rrp_smlb_50_50_lcbg_crm = rrp_smlb_50_50_lcbg_crm;
	}
	public BigDecimal getRrp_smlb_50_50_rwa() {
		return rrp_smlb_50_50_rwa;
	}
	public void setRrp_smlb_50_50_rwa(BigDecimal rrp_smlb_50_50_rwa) {
		this.rrp_smlb_50_50_rwa = rrp_smlb_50_50_rwa;
	}
	public BigDecimal getRrp_smlb_50_50_under_ccf_amt() {
		return rrp_smlb_50_50_under_ccf_amt;
	}
	public void setRrp_smlb_50_50_under_ccf_amt(BigDecimal rrp_smlb_50_50_under_ccf_amt) {
		this.rrp_smlb_50_50_under_ccf_amt = rrp_smlb_50_50_under_ccf_amt;
	}
	public BigDecimal getRrp_smlb_50_10_lcbg_balance() {
		return rrp_smlb_50_10_lcbg_balance;
	}
	public void setRrp_smlb_50_10_lcbg_balance(BigDecimal rrp_smlb_50_10_lcbg_balance) {
		this.rrp_smlb_50_10_lcbg_balance = rrp_smlb_50_10_lcbg_balance;
	}
	public BigDecimal getRrp_smlb_50_10_acceptance_amount() {
		return rrp_smlb_50_10_acceptance_amount;
	}
	public void setRrp_smlb_50_10_acceptance_amount(BigDecimal rrp_smlb_50_10_acceptance_amount) {
		this.rrp_smlb_50_10_acceptance_amount = rrp_smlb_50_10_acceptance_amount;
	}
	public BigDecimal getRrp_smlb_50_10_lcbg_crm() {
		return rrp_smlb_50_10_lcbg_crm;
	}
	public void setRrp_smlb_50_10_lcbg_crm(BigDecimal rrp_smlb_50_10_lcbg_crm) {
		this.rrp_smlb_50_10_lcbg_crm = rrp_smlb_50_10_lcbg_crm;
	}
	public BigDecimal getRrp_smlb_50_10_rwa() {
		return rrp_smlb_50_10_rwa;
	}
	public void setRrp_smlb_50_10_rwa(BigDecimal rrp_smlb_50_10_rwa) {
		this.rrp_smlb_50_10_rwa = rrp_smlb_50_10_rwa;
	}
	public BigDecimal getRrp_smlb_50_10_under_ccf_amt() {
		return rrp_smlb_50_10_under_ccf_amt;
	}
	public void setRrp_smlb_50_10_under_ccf_amt(BigDecimal rrp_smlb_50_10_under_ccf_amt) {
		this.rrp_smlb_50_10_under_ccf_amt = rrp_smlb_50_10_under_ccf_amt;
	}
	public BigDecimal getRrp_smlb_50_lcbg_balance() {
		return rrp_smlb_50_lcbg_balance;
	}
	public void setRrp_smlb_50_lcbg_balance(BigDecimal rrp_smlb_50_lcbg_balance) {
		this.rrp_smlb_50_lcbg_balance = rrp_smlb_50_lcbg_balance;
	}
	public BigDecimal getRrp_smlb_50_acceptance_amount() {
		return rrp_smlb_50_acceptance_amount;
	}
	public void setRrp_smlb_50_acceptance_amount(BigDecimal rrp_smlb_50_acceptance_amount) {
		this.rrp_smlb_50_acceptance_amount = rrp_smlb_50_acceptance_amount;
	}
	public BigDecimal getRrp_smlb_50_lcbg_crm() {
		return rrp_smlb_50_lcbg_crm;
	}
	public void setRrp_smlb_50_lcbg_crm(BigDecimal rrp_smlb_50_lcbg_crm) {
		this.rrp_smlb_50_lcbg_crm = rrp_smlb_50_lcbg_crm;
	}
	public BigDecimal getRrp_smlb_50_rwa() {
		return rrp_smlb_50_rwa;
	}
	public void setRrp_smlb_50_rwa(BigDecimal rrp_smlb_50_rwa) {
		this.rrp_smlb_50_rwa = rrp_smlb_50_rwa;
	}
	public BigDecimal getRrp_smlb_50_under_ccf_amt() {
		return rrp_smlb_50_under_ccf_amt;
	}
	public void setRrp_smlb_50_under_ccf_amt(BigDecimal rrp_smlb_50_under_ccf_amt) {
		this.rrp_smlb_50_under_ccf_amt = rrp_smlb_50_under_ccf_amt;
	}
	public BigDecimal getRrp_smlb_100_20_lcbg_balance() {
		return rrp_smlb_100_20_lcbg_balance;
	}
	public void setRrp_smlb_100_20_lcbg_balance(BigDecimal rrp_smlb_100_20_lcbg_balance) {
		this.rrp_smlb_100_20_lcbg_balance = rrp_smlb_100_20_lcbg_balance;
	}
	public BigDecimal getRrp_smlb_100_20_acceptance_amount() {
		return rrp_smlb_100_20_acceptance_amount;
	}
	public void setRrp_smlb_100_20_acceptance_amount(BigDecimal rrp_smlb_100_20_acceptance_amount) {
		this.rrp_smlb_100_20_acceptance_amount = rrp_smlb_100_20_acceptance_amount;
	}
	public BigDecimal getRrp_smlb_100_20_lcbg_crm() {
		return rrp_smlb_100_20_lcbg_crm;
	}
	public void setRrp_smlb_100_20_lcbg_crm(BigDecimal rrp_smlb_100_20_lcbg_crm) {
		this.rrp_smlb_100_20_lcbg_crm = rrp_smlb_100_20_lcbg_crm;
	}
	public BigDecimal getRrp_smlb_100_20_rwa() {
		return rrp_smlb_100_20_rwa;
	}
	public void setRrp_smlb_100_20_rwa(BigDecimal rrp_smlb_100_20_rwa) {
		this.rrp_smlb_100_20_rwa = rrp_smlb_100_20_rwa;
	}
	public BigDecimal getRrp_smlb_100_20_under_ccf_amt() {
		return rrp_smlb_100_20_under_ccf_amt;
	}
	public void setRrp_smlb_100_20_under_ccf_amt(BigDecimal rrp_smlb_100_20_under_ccf_amt) {
		this.rrp_smlb_100_20_under_ccf_amt = rrp_smlb_100_20_under_ccf_amt;
	}
	public BigDecimal getRrp_smlb_100_50_lcbg_balance() {
		return rrp_smlb_100_50_lcbg_balance;
	}
	public void setRrp_smlb_100_50_lcbg_balance(BigDecimal rrp_smlb_100_50_lcbg_balance) {
		this.rrp_smlb_100_50_lcbg_balance = rrp_smlb_100_50_lcbg_balance;
	}
	public BigDecimal getRrp_smlb_100_50_acceptance_amount() {
		return rrp_smlb_100_50_acceptance_amount;
	}
	public void setRrp_smlb_100_50_acceptance_amount(BigDecimal rrp_smlb_100_50_acceptance_amount) {
		this.rrp_smlb_100_50_acceptance_amount = rrp_smlb_100_50_acceptance_amount;
	}
	public BigDecimal getRrp_smlb_100_50_lcbg_crm() {
		return rrp_smlb_100_50_lcbg_crm;
	}
	public void setRrp_smlb_100_50_lcbg_crm(BigDecimal rrp_smlb_100_50_lcbg_crm) {
		this.rrp_smlb_100_50_lcbg_crm = rrp_smlb_100_50_lcbg_crm;
	}
	public BigDecimal getRrp_smlb_100_50_rwa() {
		return rrp_smlb_100_50_rwa;
	}
	public void setRrp_smlb_100_50_rwa(BigDecimal rrp_smlb_100_50_rwa) {
		this.rrp_smlb_100_50_rwa = rrp_smlb_100_50_rwa;
	}
	public BigDecimal getRrp_smlb_100_50_under_ccf_amt() {
		return rrp_smlb_100_50_under_ccf_amt;
	}
	public void setRrp_smlb_100_50_under_ccf_amt(BigDecimal rrp_smlb_100_50_under_ccf_amt) {
		this.rrp_smlb_100_50_under_ccf_amt = rrp_smlb_100_50_under_ccf_amt;
	}
	public BigDecimal getRrp_smlb_100_10_lcbg_balance() {
		return rrp_smlb_100_10_lcbg_balance;
	}
	public void setRrp_smlb_100_10_lcbg_balance(BigDecimal rrp_smlb_100_10_lcbg_balance) {
		this.rrp_smlb_100_10_lcbg_balance = rrp_smlb_100_10_lcbg_balance;
	}
	public BigDecimal getRrp_smlb_100_10_acceptance_amount() {
		return rrp_smlb_100_10_acceptance_amount;
	}
	public void setRrp_smlb_100_10_acceptance_amount(BigDecimal rrp_smlb_100_10_acceptance_amount) {
		this.rrp_smlb_100_10_acceptance_amount = rrp_smlb_100_10_acceptance_amount;
	}
	public BigDecimal getRrp_smlb_100_10_lcbg_crm() {
		return rrp_smlb_100_10_lcbg_crm;
	}
	public void setRrp_smlb_100_10_lcbg_crm(BigDecimal rrp_smlb_100_10_lcbg_crm) {
		this.rrp_smlb_100_10_lcbg_crm = rrp_smlb_100_10_lcbg_crm;
	}
	public BigDecimal getRrp_smlb_100_10_rwa() {
		return rrp_smlb_100_10_rwa;
	}
	public void setRrp_smlb_100_10_rwa(BigDecimal rrp_smlb_100_10_rwa) {
		this.rrp_smlb_100_10_rwa = rrp_smlb_100_10_rwa;
	}
	public BigDecimal getRrp_smlb_100_10_under_ccf_amt() {
		return rrp_smlb_100_10_under_ccf_amt;
	}
	public void setRrp_smlb_100_10_under_ccf_amt(BigDecimal rrp_smlb_100_10_under_ccf_amt) {
		this.rrp_smlb_100_10_under_ccf_amt = rrp_smlb_100_10_under_ccf_amt;
	}
	public BigDecimal getRrp_smlb_100_lcbg_balance() {
		return rrp_smlb_100_lcbg_balance;
	}
	public void setRrp_smlb_100_lcbg_balance(BigDecimal rrp_smlb_100_lcbg_balance) {
		this.rrp_smlb_100_lcbg_balance = rrp_smlb_100_lcbg_balance;
	}
	public BigDecimal getRrp_smlb_100_acceptance_amount() {
		return rrp_smlb_100_acceptance_amount;
	}
	public void setRrp_smlb_100_acceptance_amount(BigDecimal rrp_smlb_100_acceptance_amount) {
		this.rrp_smlb_100_acceptance_amount = rrp_smlb_100_acceptance_amount;
	}
	public BigDecimal getRrp_smlb_100_lcbg_crm() {
		return rrp_smlb_100_lcbg_crm;
	}
	public void setRrp_smlb_100_lcbg_crm(BigDecimal rrp_smlb_100_lcbg_crm) {
		this.rrp_smlb_100_lcbg_crm = rrp_smlb_100_lcbg_crm;
	}
	public BigDecimal getRrp_smlb_100_rwa() {
		return rrp_smlb_100_rwa;
	}
	public void setRrp_smlb_100_rwa(BigDecimal rrp_smlb_100_rwa) {
		this.rrp_smlb_100_rwa = rrp_smlb_100_rwa;
	}
	public BigDecimal getRrp_smlb_100_under_ccf_amt() {
		return rrp_smlb_100_under_ccf_amt;
	}
	public void setRrp_smlb_100_under_ccf_amt(BigDecimal rrp_smlb_100_under_ccf_amt) {
		this.rrp_smlb_100_under_ccf_amt = rrp_smlb_100_under_ccf_amt;
	}
	public BigDecimal getRrp_smlb_150_20_lcbg_balance() {
		return rrp_smlb_150_20_lcbg_balance;
	}
	public void setRrp_smlb_150_20_lcbg_balance(BigDecimal rrp_smlb_150_20_lcbg_balance) {
		this.rrp_smlb_150_20_lcbg_balance = rrp_smlb_150_20_lcbg_balance;
	}
	public BigDecimal getRrp_smlb_150_20_acceptance_amount() {
		return rrp_smlb_150_20_acceptance_amount;
	}
	public void setRrp_smlb_150_20_acceptance_amount(BigDecimal rrp_smlb_150_20_acceptance_amount) {
		this.rrp_smlb_150_20_acceptance_amount = rrp_smlb_150_20_acceptance_amount;
	}
	public BigDecimal getRrp_smlb_150_20_lcbg_crm() {
		return rrp_smlb_150_20_lcbg_crm;
	}
	public void setRrp_smlb_150_20_lcbg_crm(BigDecimal rrp_smlb_150_20_lcbg_crm) {
		this.rrp_smlb_150_20_lcbg_crm = rrp_smlb_150_20_lcbg_crm;
	}
	public BigDecimal getRrp_smlb_150_20_rwa() {
		return rrp_smlb_150_20_rwa;
	}
	public void setRrp_smlb_150_20_rwa(BigDecimal rrp_smlb_150_20_rwa) {
		this.rrp_smlb_150_20_rwa = rrp_smlb_150_20_rwa;
	}
	public BigDecimal getRrp_smlb_150_20_under_ccf_amt() {
		return rrp_smlb_150_20_under_ccf_amt;
	}
	public void setRrp_smlb_150_20_under_ccf_amt(BigDecimal rrp_smlb_150_20_under_ccf_amt) {
		this.rrp_smlb_150_20_under_ccf_amt = rrp_smlb_150_20_under_ccf_amt;
	}
	public BigDecimal getRrp_smlb_150_50_lcbg_balance() {
		return rrp_smlb_150_50_lcbg_balance;
	}
	public void setRrp_smlb_150_50_lcbg_balance(BigDecimal rrp_smlb_150_50_lcbg_balance) {
		this.rrp_smlb_150_50_lcbg_balance = rrp_smlb_150_50_lcbg_balance;
	}
	public BigDecimal getRrp_smlb_150_50_acceptance_amount() {
		return rrp_smlb_150_50_acceptance_amount;
	}
	public void setRrp_smlb_150_50_acceptance_amount(BigDecimal rrp_smlb_150_50_acceptance_amount) {
		this.rrp_smlb_150_50_acceptance_amount = rrp_smlb_150_50_acceptance_amount;
	}
	public BigDecimal getRrp_smlb_150_50_lcbg_crm() {
		return rrp_smlb_150_50_lcbg_crm;
	}
	public void setRrp_smlb_150_50_lcbg_crm(BigDecimal rrp_smlb_150_50_lcbg_crm) {
		this.rrp_smlb_150_50_lcbg_crm = rrp_smlb_150_50_lcbg_crm;
	}
	public BigDecimal getRrp_smlb_150_50_rwa() {
		return rrp_smlb_150_50_rwa;
	}
	public void setRrp_smlb_150_50_rwa(BigDecimal rrp_smlb_150_50_rwa) {
		this.rrp_smlb_150_50_rwa = rrp_smlb_150_50_rwa;
	}
	public BigDecimal getRrp_smlb_150_50_under_ccf_amt() {
		return rrp_smlb_150_50_under_ccf_amt;
	}
	public void setRrp_smlb_150_50_under_ccf_amt(BigDecimal rrp_smlb_150_50_under_ccf_amt) {
		this.rrp_smlb_150_50_under_ccf_amt = rrp_smlb_150_50_under_ccf_amt;
	}
	public BigDecimal getRrp_smlb_150_10_lcbg_balance() {
		return rrp_smlb_150_10_lcbg_balance;
	}
	public void setRrp_smlb_150_10_lcbg_balance(BigDecimal rrp_smlb_150_10_lcbg_balance) {
		this.rrp_smlb_150_10_lcbg_balance = rrp_smlb_150_10_lcbg_balance;
	}
	public BigDecimal getRrp_smlb_150_10_acceptance_amount() {
		return rrp_smlb_150_10_acceptance_amount;
	}
	public void setRrp_smlb_150_10_acceptance_amount(BigDecimal rrp_smlb_150_10_acceptance_amount) {
		this.rrp_smlb_150_10_acceptance_amount = rrp_smlb_150_10_acceptance_amount;
	}
	public BigDecimal getRrp_smlb_150_10_lcbg_crm() {
		return rrp_smlb_150_10_lcbg_crm;
	}
	public void setRrp_smlb_150_10_lcbg_crm(BigDecimal rrp_smlb_150_10_lcbg_crm) {
		this.rrp_smlb_150_10_lcbg_crm = rrp_smlb_150_10_lcbg_crm;
	}
	public BigDecimal getRrp_smlb_150_10_rwa() {
		return rrp_smlb_150_10_rwa;
	}
	public void setRrp_smlb_150_10_rwa(BigDecimal rrp_smlb_150_10_rwa) {
		this.rrp_smlb_150_10_rwa = rrp_smlb_150_10_rwa;
	}
	public BigDecimal getRrp_smlb_150_10_under_ccf_amt() {
		return rrp_smlb_150_10_under_ccf_amt;
	}
	public void setRrp_smlb_150_10_under_ccf_amt(BigDecimal rrp_smlb_150_10_under_ccf_amt) {
		this.rrp_smlb_150_10_under_ccf_amt = rrp_smlb_150_10_under_ccf_amt;
	}
	public BigDecimal getRrp_smlb_150_lcbg_balance() {
		return rrp_smlb_150_lcbg_balance;
	}
	public void setRrp_smlb_150_lcbg_balance(BigDecimal rrp_smlb_150_lcbg_balance) {
		this.rrp_smlb_150_lcbg_balance = rrp_smlb_150_lcbg_balance;
	}
	public BigDecimal getRrp_smlb_150_acceptance_amount() {
		return rrp_smlb_150_acceptance_amount;
	}
	public void setRrp_smlb_150_acceptance_amount(BigDecimal rrp_smlb_150_acceptance_amount) {
		this.rrp_smlb_150_acceptance_amount = rrp_smlb_150_acceptance_amount;
	}
	public BigDecimal getRrp_smlb_150_lcbg_crm() {
		return rrp_smlb_150_lcbg_crm;
	}
	public void setRrp_smlb_150_lcbg_crm(BigDecimal rrp_smlb_150_lcbg_crm) {
		this.rrp_smlb_150_lcbg_crm = rrp_smlb_150_lcbg_crm;
	}
	public BigDecimal getRrp_smlb_150_rwa() {
		return rrp_smlb_150_rwa;
	}
	public void setRrp_smlb_150_rwa(BigDecimal rrp_smlb_150_rwa) {
		this.rrp_smlb_150_rwa = rrp_smlb_150_rwa;
	}
	public BigDecimal getRrp_smlb_150_under_ccf_amt() {
		return rrp_smlb_150_under_ccf_amt;
	}
	public void setRrp_smlb_150_under_ccf_amt(BigDecimal rrp_smlb_150_under_ccf_amt) {
		this.rrp_smlb_150_under_ccf_amt = rrp_smlb_150_under_ccf_amt;
	}
	public BigDecimal getRrp_smlb2_0_20_lcbg_balance() {
		return rrp_smlb2_0_20_lcbg_balance;
	}
	public void setRrp_smlb2_0_20_lcbg_balance(BigDecimal rrp_smlb2_0_20_lcbg_balance) {
		this.rrp_smlb2_0_20_lcbg_balance = rrp_smlb2_0_20_lcbg_balance;
	}
	public BigDecimal getRrp_smlb2_0_20_acceptance_amount() {
		return rrp_smlb2_0_20_acceptance_amount;
	}
	public void setRrp_smlb2_0_20_acceptance_amount(BigDecimal rrp_smlb2_0_20_acceptance_amount) {
		this.rrp_smlb2_0_20_acceptance_amount = rrp_smlb2_0_20_acceptance_amount;
	}
	public BigDecimal getRrp_smlb2_0_20_lcbg_crm() {
		return rrp_smlb2_0_20_lcbg_crm;
	}
	public void setRrp_smlb2_0_20_lcbg_crm(BigDecimal rrp_smlb2_0_20_lcbg_crm) {
		this.rrp_smlb2_0_20_lcbg_crm = rrp_smlb2_0_20_lcbg_crm;
	}
	public BigDecimal getRrp_smlb2_0_20_rwa() {
		return rrp_smlb2_0_20_rwa;
	}
	public void setRrp_smlb2_0_20_rwa(BigDecimal rrp_smlb2_0_20_rwa) {
		this.rrp_smlb2_0_20_rwa = rrp_smlb2_0_20_rwa;
	}
	public BigDecimal getRrp_smlb2_0_20_under_ccf_amt() {
		return rrp_smlb2_0_20_under_ccf_amt;
	}
	public void setRrp_smlb2_0_20_under_ccf_amt(BigDecimal rrp_smlb2_0_20_under_ccf_amt) {
		this.rrp_smlb2_0_20_under_ccf_amt = rrp_smlb2_0_20_under_ccf_amt;
	}
	public BigDecimal getRrp_smlb2_0_50_lcbg_balance() {
		return rrp_smlb2_0_50_lcbg_balance;
	}
	public void setRrp_smlb2_0_50_lcbg_balance(BigDecimal rrp_smlb2_0_50_lcbg_balance) {
		this.rrp_smlb2_0_50_lcbg_balance = rrp_smlb2_0_50_lcbg_balance;
	}
	public BigDecimal getRrp_smlb2_0_50_acceptance_amount() {
		return rrp_smlb2_0_50_acceptance_amount;
	}
	public void setRrp_smlb2_0_50_acceptance_amount(BigDecimal rrp_smlb2_0_50_acceptance_amount) {
		this.rrp_smlb2_0_50_acceptance_amount = rrp_smlb2_0_50_acceptance_amount;
	}
	public BigDecimal getRrp_smlb2_0_50_lcbg_crm() {
		return rrp_smlb2_0_50_lcbg_crm;
	}
	public void setRrp_smlb2_0_50_lcbg_crm(BigDecimal rrp_smlb2_0_50_lcbg_crm) {
		this.rrp_smlb2_0_50_lcbg_crm = rrp_smlb2_0_50_lcbg_crm;
	}
	public BigDecimal getRrp_smlb2_0_50_rwa() {
		return rrp_smlb2_0_50_rwa;
	}
	public void setRrp_smlb2_0_50_rwa(BigDecimal rrp_smlb2_0_50_rwa) {
		this.rrp_smlb2_0_50_rwa = rrp_smlb2_0_50_rwa;
	}
	public BigDecimal getRrp_smlb2_0_50_under_ccf_amt() {
		return rrp_smlb2_0_50_under_ccf_amt;
	}
	public void setRrp_smlb2_0_50_under_ccf_amt(BigDecimal rrp_smlb2_0_50_under_ccf_amt) {
		this.rrp_smlb2_0_50_under_ccf_amt = rrp_smlb2_0_50_under_ccf_amt;
	}
	public BigDecimal getRrp_smlb2_0_10_lcbg_balance() {
		return rrp_smlb2_0_10_lcbg_balance;
	}
	public void setRrp_smlb2_0_10_lcbg_balance(BigDecimal rrp_smlb2_0_10_lcbg_balance) {
		this.rrp_smlb2_0_10_lcbg_balance = rrp_smlb2_0_10_lcbg_balance;
	}
	public BigDecimal getRrp_smlb2_0_10_acceptance_amount() {
		return rrp_smlb2_0_10_acceptance_amount;
	}
	public void setRrp_smlb2_0_10_acceptance_amount(BigDecimal rrp_smlb2_0_10_acceptance_amount) {
		this.rrp_smlb2_0_10_acceptance_amount = rrp_smlb2_0_10_acceptance_amount;
	}
	public BigDecimal getRrp_smlb2_0_10_lcbg_crm() {
		return rrp_smlb2_0_10_lcbg_crm;
	}
	public void setRrp_smlb2_0_10_lcbg_crm(BigDecimal rrp_smlb2_0_10_lcbg_crm) {
		this.rrp_smlb2_0_10_lcbg_crm = rrp_smlb2_0_10_lcbg_crm;
	}
	public BigDecimal getRrp_smlb2_0_10_rwa() {
		return rrp_smlb2_0_10_rwa;
	}
	public void setRrp_smlb2_0_10_rwa(BigDecimal rrp_smlb2_0_10_rwa) {
		this.rrp_smlb2_0_10_rwa = rrp_smlb2_0_10_rwa;
	}
	public BigDecimal getRrp_smlb2_0_10_under_ccf_amt() {
		return rrp_smlb2_0_10_under_ccf_amt;
	}
	public void setRrp_smlb2_0_10_under_ccf_amt(BigDecimal rrp_smlb2_0_10_under_ccf_amt) {
		this.rrp_smlb2_0_10_under_ccf_amt = rrp_smlb2_0_10_under_ccf_amt;
	}
	public BigDecimal getRrp_smlb2_0_lcbg_balance() {
		return rrp_smlb2_0_lcbg_balance;
	}
	public void setRrp_smlb2_0_lcbg_balance(BigDecimal rrp_smlb2_0_lcbg_balance) {
		this.rrp_smlb2_0_lcbg_balance = rrp_smlb2_0_lcbg_balance;
	}
	public BigDecimal getRrp_smlb2_0_acceptance_amount() {
		return rrp_smlb2_0_acceptance_amount;
	}
	public void setRrp_smlb2_0_acceptance_amount(BigDecimal rrp_smlb2_0_acceptance_amount) {
		this.rrp_smlb2_0_acceptance_amount = rrp_smlb2_0_acceptance_amount;
	}
	public BigDecimal getRrp_smlb2_0_lcbg_crm() {
		return rrp_smlb2_0_lcbg_crm;
	}
	public void setRrp_smlb2_0_lcbg_crm(BigDecimal rrp_smlb2_0_lcbg_crm) {
		this.rrp_smlb2_0_lcbg_crm = rrp_smlb2_0_lcbg_crm;
	}
	public BigDecimal getRrp_smlb2_0_rwa() {
		return rrp_smlb2_0_rwa;
	}
	public void setRrp_smlb2_0_rwa(BigDecimal rrp_smlb2_0_rwa) {
		this.rrp_smlb2_0_rwa = rrp_smlb2_0_rwa;
	}
	public BigDecimal getRrp_smlb2_0_under_ccf_amt() {
		return rrp_smlb2_0_under_ccf_amt;
	}
	public void setRrp_smlb2_0_under_ccf_amt(BigDecimal rrp_smlb2_0_under_ccf_amt) {
		this.rrp_smlb2_0_under_ccf_amt = rrp_smlb2_0_under_ccf_amt;
	}
	public BigDecimal getRrp_smlb2_20_20_lcbg_balance() {
		return rrp_smlb2_20_20_lcbg_balance;
	}
	public void setRrp_smlb2_20_20_lcbg_balance(BigDecimal rrp_smlb2_20_20_lcbg_balance) {
		this.rrp_smlb2_20_20_lcbg_balance = rrp_smlb2_20_20_lcbg_balance;
	}
	public BigDecimal getRrp_smlb2_20_20_acceptance_amount() {
		return rrp_smlb2_20_20_acceptance_amount;
	}
	public void setRrp_smlb2_20_20_acceptance_amount(BigDecimal rrp_smlb2_20_20_acceptance_amount) {
		this.rrp_smlb2_20_20_acceptance_amount = rrp_smlb2_20_20_acceptance_amount;
	}
	public BigDecimal getRrp_smlb2_20_20_lcbg_crm() {
		return rrp_smlb2_20_20_lcbg_crm;
	}
	public void setRrp_smlb2_20_20_lcbg_crm(BigDecimal rrp_smlb2_20_20_lcbg_crm) {
		this.rrp_smlb2_20_20_lcbg_crm = rrp_smlb2_20_20_lcbg_crm;
	}
	public BigDecimal getRrp_smlb2_20_20_rwa() {
		return rrp_smlb2_20_20_rwa;
	}
	public void setRrp_smlb2_20_20_rwa(BigDecimal rrp_smlb2_20_20_rwa) {
		this.rrp_smlb2_20_20_rwa = rrp_smlb2_20_20_rwa;
	}
	public BigDecimal getRrp_smlb2_20_20_under_ccf_amt() {
		return rrp_smlb2_20_20_under_ccf_amt;
	}
	public void setRrp_smlb2_20_20_under_ccf_amt(BigDecimal rrp_smlb2_20_20_under_ccf_amt) {
		this.rrp_smlb2_20_20_under_ccf_amt = rrp_smlb2_20_20_under_ccf_amt;
	}
	public BigDecimal getRrp_smlb2_20_50_lcbg_balance() {
		return rrp_smlb2_20_50_lcbg_balance;
	}
	public void setRrp_smlb2_20_50_lcbg_balance(BigDecimal rrp_smlb2_20_50_lcbg_balance) {
		this.rrp_smlb2_20_50_lcbg_balance = rrp_smlb2_20_50_lcbg_balance;
	}
	public BigDecimal getRrp_smlb2_20_50_acceptance_amount() {
		return rrp_smlb2_20_50_acceptance_amount;
	}
	public void setRrp_smlb2_20_50_acceptance_amount(BigDecimal rrp_smlb2_20_50_acceptance_amount) {
		this.rrp_smlb2_20_50_acceptance_amount = rrp_smlb2_20_50_acceptance_amount;
	}
	public BigDecimal getRrp_smlb2_20_50_lcbg_crm() {
		return rrp_smlb2_20_50_lcbg_crm;
	}
	public void setRrp_smlb2_20_50_lcbg_crm(BigDecimal rrp_smlb2_20_50_lcbg_crm) {
		this.rrp_smlb2_20_50_lcbg_crm = rrp_smlb2_20_50_lcbg_crm;
	}
	public BigDecimal getRrp_smlb2_20_50_rwa() {
		return rrp_smlb2_20_50_rwa;
	}
	public void setRrp_smlb2_20_50_rwa(BigDecimal rrp_smlb2_20_50_rwa) {
		this.rrp_smlb2_20_50_rwa = rrp_smlb2_20_50_rwa;
	}
	public BigDecimal getRrp_smlb2_20_50_under_ccf_amt() {
		return rrp_smlb2_20_50_under_ccf_amt;
	}
	public void setRrp_smlb2_20_50_under_ccf_amt(BigDecimal rrp_smlb2_20_50_under_ccf_amt) {
		this.rrp_smlb2_20_50_under_ccf_amt = rrp_smlb2_20_50_under_ccf_amt;
	}
	public BigDecimal getRrp_smlb2_20_10_lcbg_balance() {
		return rrp_smlb2_20_10_lcbg_balance;
	}
	public void setRrp_smlb2_20_10_lcbg_balance(BigDecimal rrp_smlb2_20_10_lcbg_balance) {
		this.rrp_smlb2_20_10_lcbg_balance = rrp_smlb2_20_10_lcbg_balance;
	}
	public BigDecimal getRrp_smlb2_20_10_acceptance_amount() {
		return rrp_smlb2_20_10_acceptance_amount;
	}
	public void setRrp_smlb2_20_10_acceptance_amount(BigDecimal rrp_smlb2_20_10_acceptance_amount) {
		this.rrp_smlb2_20_10_acceptance_amount = rrp_smlb2_20_10_acceptance_amount;
	}
	public BigDecimal getRrp_smlb2_20_10_lcbg_crm() {
		return rrp_smlb2_20_10_lcbg_crm;
	}
	public void setRrp_smlb2_20_10_lcbg_crm(BigDecimal rrp_smlb2_20_10_lcbg_crm) {
		this.rrp_smlb2_20_10_lcbg_crm = rrp_smlb2_20_10_lcbg_crm;
	}
	public BigDecimal getRrp_smlb2_20_10_rwa() {
		return rrp_smlb2_20_10_rwa;
	}
	public void setRrp_smlb2_20_10_rwa(BigDecimal rrp_smlb2_20_10_rwa) {
		this.rrp_smlb2_20_10_rwa = rrp_smlb2_20_10_rwa;
	}
	public BigDecimal getRrp_smlb2_20_10_under_ccf_amt() {
		return rrp_smlb2_20_10_under_ccf_amt;
	}
	public void setRrp_smlb2_20_10_under_ccf_amt(BigDecimal rrp_smlb2_20_10_under_ccf_amt) {
		this.rrp_smlb2_20_10_under_ccf_amt = rrp_smlb2_20_10_under_ccf_amt;
	}
	public BigDecimal getRrp_smlb2_20_lcbg_balance() {
		return rrp_smlb2_20_lcbg_balance;
	}
	public void setRrp_smlb2_20_lcbg_balance(BigDecimal rrp_smlb2_20_lcbg_balance) {
		this.rrp_smlb2_20_lcbg_balance = rrp_smlb2_20_lcbg_balance;
	}
	public BigDecimal getRrp_smlb2_20_acceptance_amount() {
		return rrp_smlb2_20_acceptance_amount;
	}
	public void setRrp_smlb2_20_acceptance_amount(BigDecimal rrp_smlb2_20_acceptance_amount) {
		this.rrp_smlb2_20_acceptance_amount = rrp_smlb2_20_acceptance_amount;
	}
	public BigDecimal getRrp_smlb2_20_lcbg_crm() {
		return rrp_smlb2_20_lcbg_crm;
	}
	public void setRrp_smlb2_20_lcbg_crm(BigDecimal rrp_smlb2_20_lcbg_crm) {
		this.rrp_smlb2_20_lcbg_crm = rrp_smlb2_20_lcbg_crm;
	}
	public BigDecimal getRrp_smlb2_20_rwa() {
		return rrp_smlb2_20_rwa;
	}
	public void setRrp_smlb2_20_rwa(BigDecimal rrp_smlb2_20_rwa) {
		this.rrp_smlb2_20_rwa = rrp_smlb2_20_rwa;
	}
	public BigDecimal getRrp_smlb2_20_under_ccf_amt() {
		return rrp_smlb2_20_under_ccf_amt;
	}
	public void setRrp_smlb2_20_under_ccf_amt(BigDecimal rrp_smlb2_20_under_ccf_amt) {
		this.rrp_smlb2_20_under_ccf_amt = rrp_smlb2_20_under_ccf_amt;
	}
	public BigDecimal getRrp_smlb2_50_20_lcbg_balance() {
		return rrp_smlb2_50_20_lcbg_balance;
	}
	public void setRrp_smlb2_50_20_lcbg_balance(BigDecimal rrp_smlb2_50_20_lcbg_balance) {
		this.rrp_smlb2_50_20_lcbg_balance = rrp_smlb2_50_20_lcbg_balance;
	}
	public BigDecimal getRrp_smlb2_50_20_acceptance_amount() {
		return rrp_smlb2_50_20_acceptance_amount;
	}
	public void setRrp_smlb2_50_20_acceptance_amount(BigDecimal rrp_smlb2_50_20_acceptance_amount) {
		this.rrp_smlb2_50_20_acceptance_amount = rrp_smlb2_50_20_acceptance_amount;
	}
	public BigDecimal getRrp_smlb2_50_20_lcbg_crm() {
		return rrp_smlb2_50_20_lcbg_crm;
	}
	public void setRrp_smlb2_50_20_lcbg_crm(BigDecimal rrp_smlb2_50_20_lcbg_crm) {
		this.rrp_smlb2_50_20_lcbg_crm = rrp_smlb2_50_20_lcbg_crm;
	}
	public BigDecimal getRrp_smlb2_50_20_rwa() {
		return rrp_smlb2_50_20_rwa;
	}
	public void setRrp_smlb2_50_20_rwa(BigDecimal rrp_smlb2_50_20_rwa) {
		this.rrp_smlb2_50_20_rwa = rrp_smlb2_50_20_rwa;
	}
	public BigDecimal getRrp_smlb2_50_20_under_ccf_amt() {
		return rrp_smlb2_50_20_under_ccf_amt;
	}
	public void setRrp_smlb2_50_20_under_ccf_amt(BigDecimal rrp_smlb2_50_20_under_ccf_amt) {
		this.rrp_smlb2_50_20_under_ccf_amt = rrp_smlb2_50_20_under_ccf_amt;
	}
	public BigDecimal getRrp_smlb2_50_50_lcbg_balance() {
		return rrp_smlb2_50_50_lcbg_balance;
	}
	public void setRrp_smlb2_50_50_lcbg_balance(BigDecimal rrp_smlb2_50_50_lcbg_balance) {
		this.rrp_smlb2_50_50_lcbg_balance = rrp_smlb2_50_50_lcbg_balance;
	}
	public BigDecimal getRrp_smlb2_50_50_acceptance_amount() {
		return rrp_smlb2_50_50_acceptance_amount;
	}
	public void setRrp_smlb2_50_50_acceptance_amount(BigDecimal rrp_smlb2_50_50_acceptance_amount) {
		this.rrp_smlb2_50_50_acceptance_amount = rrp_smlb2_50_50_acceptance_amount;
	}
	public BigDecimal getRrp_smlb2_50_50_lcbg_crm() {
		return rrp_smlb2_50_50_lcbg_crm;
	}
	public void setRrp_smlb2_50_50_lcbg_crm(BigDecimal rrp_smlb2_50_50_lcbg_crm) {
		this.rrp_smlb2_50_50_lcbg_crm = rrp_smlb2_50_50_lcbg_crm;
	}
	public BigDecimal getRrp_smlb2_50_50_rwa() {
		return rrp_smlb2_50_50_rwa;
	}
	public void setRrp_smlb2_50_50_rwa(BigDecimal rrp_smlb2_50_50_rwa) {
		this.rrp_smlb2_50_50_rwa = rrp_smlb2_50_50_rwa;
	}
	public BigDecimal getRrp_smlb2_50_50_under_ccf_amt() {
		return rrp_smlb2_50_50_under_ccf_amt;
	}
	public void setRrp_smlb2_50_50_under_ccf_amt(BigDecimal rrp_smlb2_50_50_under_ccf_amt) {
		this.rrp_smlb2_50_50_under_ccf_amt = rrp_smlb2_50_50_under_ccf_amt;
	}
	public BigDecimal getRrp_smlb2_50_10_lcbg_balance() {
		return rrp_smlb2_50_10_lcbg_balance;
	}
	public void setRrp_smlb2_50_10_lcbg_balance(BigDecimal rrp_smlb2_50_10_lcbg_balance) {
		this.rrp_smlb2_50_10_lcbg_balance = rrp_smlb2_50_10_lcbg_balance;
	}
	public BigDecimal getRrp_smlb2_50_10_acceptance_amount() {
		return rrp_smlb2_50_10_acceptance_amount;
	}
	public void setRrp_smlb2_50_10_acceptance_amount(BigDecimal rrp_smlb2_50_10_acceptance_amount) {
		this.rrp_smlb2_50_10_acceptance_amount = rrp_smlb2_50_10_acceptance_amount;
	}
	public BigDecimal getRrp_smlb2_50_10_lcbg_crm() {
		return rrp_smlb2_50_10_lcbg_crm;
	}
	public void setRrp_smlb2_50_10_lcbg_crm(BigDecimal rrp_smlb2_50_10_lcbg_crm) {
		this.rrp_smlb2_50_10_lcbg_crm = rrp_smlb2_50_10_lcbg_crm;
	}
	public BigDecimal getRrp_smlb2_50_10_rwa() {
		return rrp_smlb2_50_10_rwa;
	}
	public void setRrp_smlb2_50_10_rwa(BigDecimal rrp_smlb2_50_10_rwa) {
		this.rrp_smlb2_50_10_rwa = rrp_smlb2_50_10_rwa;
	}
	public BigDecimal getRrp_smlb2_50_10_under_ccf_amt() {
		return rrp_smlb2_50_10_under_ccf_amt;
	}
	public void setRrp_smlb2_50_10_under_ccf_amt(BigDecimal rrp_smlb2_50_10_under_ccf_amt) {
		this.rrp_smlb2_50_10_under_ccf_amt = rrp_smlb2_50_10_under_ccf_amt;
	}
	public BigDecimal getRrp_smlb2_50_lcbg_balance() {
		return rrp_smlb2_50_lcbg_balance;
	}
	public void setRrp_smlb2_50_lcbg_balance(BigDecimal rrp_smlb2_50_lcbg_balance) {
		this.rrp_smlb2_50_lcbg_balance = rrp_smlb2_50_lcbg_balance;
	}
	public BigDecimal getRrp_smlb2_50_acceptance_amount() {
		return rrp_smlb2_50_acceptance_amount;
	}
	public void setRrp_smlb2_50_acceptance_amount(BigDecimal rrp_smlb2_50_acceptance_amount) {
		this.rrp_smlb2_50_acceptance_amount = rrp_smlb2_50_acceptance_amount;
	}
	public BigDecimal getRrp_smlb2_50_lcbg_crm() {
		return rrp_smlb2_50_lcbg_crm;
	}
	public void setRrp_smlb2_50_lcbg_crm(BigDecimal rrp_smlb2_50_lcbg_crm) {
		this.rrp_smlb2_50_lcbg_crm = rrp_smlb2_50_lcbg_crm;
	}
	public BigDecimal getRrp_smlb2_50_rwa() {
		return rrp_smlb2_50_rwa;
	}
	public void setRrp_smlb2_50_rwa(BigDecimal rrp_smlb2_50_rwa) {
		this.rrp_smlb2_50_rwa = rrp_smlb2_50_rwa;
	}
	public BigDecimal getRrp_smlb2_50_under_ccf_amt() {
		return rrp_smlb2_50_under_ccf_amt;
	}
	public void setRrp_smlb2_50_under_ccf_amt(BigDecimal rrp_smlb2_50_under_ccf_amt) {
		this.rrp_smlb2_50_under_ccf_amt = rrp_smlb2_50_under_ccf_amt;
	}
	public BigDecimal getRrp_smlb2_100_20_lcbg_balance() {
		return rrp_smlb2_100_20_lcbg_balance;
	}
	public void setRrp_smlb2_100_20_lcbg_balance(BigDecimal rrp_smlb2_100_20_lcbg_balance) {
		this.rrp_smlb2_100_20_lcbg_balance = rrp_smlb2_100_20_lcbg_balance;
	}
	public BigDecimal getRrp_smlb2_100_20_acceptance_amount() {
		return rrp_smlb2_100_20_acceptance_amount;
	}
	public void setRrp_smlb2_100_20_acceptance_amount(BigDecimal rrp_smlb2_100_20_acceptance_amount) {
		this.rrp_smlb2_100_20_acceptance_amount = rrp_smlb2_100_20_acceptance_amount;
	}
	public BigDecimal getRrp_smlb2_100_20_lcbg_crm() {
		return rrp_smlb2_100_20_lcbg_crm;
	}
	public void setRrp_smlb2_100_20_lcbg_crm(BigDecimal rrp_smlb2_100_20_lcbg_crm) {
		this.rrp_smlb2_100_20_lcbg_crm = rrp_smlb2_100_20_lcbg_crm;
	}
	public BigDecimal getRrp_smlb2_100_20_rwa() {
		return rrp_smlb2_100_20_rwa;
	}
	public void setRrp_smlb2_100_20_rwa(BigDecimal rrp_smlb2_100_20_rwa) {
		this.rrp_smlb2_100_20_rwa = rrp_smlb2_100_20_rwa;
	}
	public BigDecimal getRrp_smlb2_100_20_under_ccf_amt() {
		return rrp_smlb2_100_20_under_ccf_amt;
	}
	public void setRrp_smlb2_100_20_under_ccf_amt(BigDecimal rrp_smlb2_100_20_under_ccf_amt) {
		this.rrp_smlb2_100_20_under_ccf_amt = rrp_smlb2_100_20_under_ccf_amt;
	}
	public BigDecimal getRrp_smlb2_100_50_lcbg_balance() {
		return rrp_smlb2_100_50_lcbg_balance;
	}
	public void setRrp_smlb2_100_50_lcbg_balance(BigDecimal rrp_smlb2_100_50_lcbg_balance) {
		this.rrp_smlb2_100_50_lcbg_balance = rrp_smlb2_100_50_lcbg_balance;
	}
	public BigDecimal getRrp_smlb2_100_50_acceptance_amount() {
		return rrp_smlb2_100_50_acceptance_amount;
	}
	public void setRrp_smlb2_100_50_acceptance_amount(BigDecimal rrp_smlb2_100_50_acceptance_amount) {
		this.rrp_smlb2_100_50_acceptance_amount = rrp_smlb2_100_50_acceptance_amount;
	}
	public BigDecimal getRrp_smlb2_100_50_lcbg_crm() {
		return rrp_smlb2_100_50_lcbg_crm;
	}
	public void setRrp_smlb2_100_50_lcbg_crm(BigDecimal rrp_smlb2_100_50_lcbg_crm) {
		this.rrp_smlb2_100_50_lcbg_crm = rrp_smlb2_100_50_lcbg_crm;
	}
	public BigDecimal getRrp_smlb2_100_50_rwa() {
		return rrp_smlb2_100_50_rwa;
	}
	public void setRrp_smlb2_100_50_rwa(BigDecimal rrp_smlb2_100_50_rwa) {
		this.rrp_smlb2_100_50_rwa = rrp_smlb2_100_50_rwa;
	}
	public BigDecimal getRrp_smlb2_100_50_under_ccf_amt() {
		return rrp_smlb2_100_50_under_ccf_amt;
	}
	public void setRrp_smlb2_100_50_under_ccf_amt(BigDecimal rrp_smlb2_100_50_under_ccf_amt) {
		this.rrp_smlb2_100_50_under_ccf_amt = rrp_smlb2_100_50_under_ccf_amt;
	}
	public BigDecimal getRrp_smlb2_100_10_lcbg_balance() {
		return rrp_smlb2_100_10_lcbg_balance;
	}
	public void setRrp_smlb2_100_10_lcbg_balance(BigDecimal rrp_smlb2_100_10_lcbg_balance) {
		this.rrp_smlb2_100_10_lcbg_balance = rrp_smlb2_100_10_lcbg_balance;
	}
	public BigDecimal getRrp_smlb2_100_10_acceptance_amount() {
		return rrp_smlb2_100_10_acceptance_amount;
	}
	public void setRrp_smlb2_100_10_acceptance_amount(BigDecimal rrp_smlb2_100_10_acceptance_amount) {
		this.rrp_smlb2_100_10_acceptance_amount = rrp_smlb2_100_10_acceptance_amount;
	}
	public BigDecimal getRrp_smlb2_100_10_lcbg_crm() {
		return rrp_smlb2_100_10_lcbg_crm;
	}
	public void setRrp_smlb2_100_10_lcbg_crm(BigDecimal rrp_smlb2_100_10_lcbg_crm) {
		this.rrp_smlb2_100_10_lcbg_crm = rrp_smlb2_100_10_lcbg_crm;
	}
	public BigDecimal getRrp_smlb2_100_10_rwa() {
		return rrp_smlb2_100_10_rwa;
	}
	public void setRrp_smlb2_100_10_rwa(BigDecimal rrp_smlb2_100_10_rwa) {
		this.rrp_smlb2_100_10_rwa = rrp_smlb2_100_10_rwa;
	}
	public BigDecimal getRrp_smlb2_100_10_under_ccf_amt() {
		return rrp_smlb2_100_10_under_ccf_amt;
	}
	public void setRrp_smlb2_100_10_under_ccf_amt(BigDecimal rrp_smlb2_100_10_under_ccf_amt) {
		this.rrp_smlb2_100_10_under_ccf_amt = rrp_smlb2_100_10_under_ccf_amt;
	}
	public BigDecimal getRrp_smlb2_100_lcbg_balance() {
		return rrp_smlb2_100_lcbg_balance;
	}
	public void setRrp_smlb2_100_lcbg_balance(BigDecimal rrp_smlb2_100_lcbg_balance) {
		this.rrp_smlb2_100_lcbg_balance = rrp_smlb2_100_lcbg_balance;
	}
	public BigDecimal getRrp_smlb2_100_acceptance_amount() {
		return rrp_smlb2_100_acceptance_amount;
	}
	public void setRrp_smlb2_100_acceptance_amount(BigDecimal rrp_smlb2_100_acceptance_amount) {
		this.rrp_smlb2_100_acceptance_amount = rrp_smlb2_100_acceptance_amount;
	}
	public BigDecimal getRrp_smlb2_100_lcbg_crm() {
		return rrp_smlb2_100_lcbg_crm;
	}
	public void setRrp_smlb2_100_lcbg_crm(BigDecimal rrp_smlb2_100_lcbg_crm) {
		this.rrp_smlb2_100_lcbg_crm = rrp_smlb2_100_lcbg_crm;
	}
	public BigDecimal getRrp_smlb2_100_rwa() {
		return rrp_smlb2_100_rwa;
	}
	public void setRrp_smlb2_100_rwa(BigDecimal rrp_smlb2_100_rwa) {
		this.rrp_smlb2_100_rwa = rrp_smlb2_100_rwa;
	}
	public BigDecimal getRrp_smlb2_100_under_ccf_amt() {
		return rrp_smlb2_100_under_ccf_amt;
	}
	public void setRrp_smlb2_100_under_ccf_amt(BigDecimal rrp_smlb2_100_under_ccf_amt) {
		this.rrp_smlb2_100_under_ccf_amt = rrp_smlb2_100_under_ccf_amt;
	}
	public BigDecimal getRrp_smlb2_150_20_lcbg_balance() {
		return rrp_smlb2_150_20_lcbg_balance;
	}
	public void setRrp_smlb2_150_20_lcbg_balance(BigDecimal rrp_smlb2_150_20_lcbg_balance) {
		this.rrp_smlb2_150_20_lcbg_balance = rrp_smlb2_150_20_lcbg_balance;
	}
	public BigDecimal getRrp_smlb2_150_20_acceptance_amount() {
		return rrp_smlb2_150_20_acceptance_amount;
	}
	public void setRrp_smlb2_150_20_acceptance_amount(BigDecimal rrp_smlb2_150_20_acceptance_amount) {
		this.rrp_smlb2_150_20_acceptance_amount = rrp_smlb2_150_20_acceptance_amount;
	}
	public BigDecimal getRrp_smlb2_150_20_lcbg_crm() {
		return rrp_smlb2_150_20_lcbg_crm;
	}
	public void setRrp_smlb2_150_20_lcbg_crm(BigDecimal rrp_smlb2_150_20_lcbg_crm) {
		this.rrp_smlb2_150_20_lcbg_crm = rrp_smlb2_150_20_lcbg_crm;
	}
	public BigDecimal getRrp_smlb2_150_20_rwa() {
		return rrp_smlb2_150_20_rwa;
	}
	public void setRrp_smlb2_150_20_rwa(BigDecimal rrp_smlb2_150_20_rwa) {
		this.rrp_smlb2_150_20_rwa = rrp_smlb2_150_20_rwa;
	}
	public BigDecimal getRrp_smlb2_150_20_under_ccf_amt() {
		return rrp_smlb2_150_20_under_ccf_amt;
	}
	public void setRrp_smlb2_150_20_under_ccf_amt(BigDecimal rrp_smlb2_150_20_under_ccf_amt) {
		this.rrp_smlb2_150_20_under_ccf_amt = rrp_smlb2_150_20_under_ccf_amt;
	}
	public BigDecimal getRrp_smlb2_150_50_lcbg_balance() {
		return rrp_smlb2_150_50_lcbg_balance;
	}
	public void setRrp_smlb2_150_50_lcbg_balance(BigDecimal rrp_smlb2_150_50_lcbg_balance) {
		this.rrp_smlb2_150_50_lcbg_balance = rrp_smlb2_150_50_lcbg_balance;
	}
	public BigDecimal getRrp_smlb2_150_50_acceptance_amount() {
		return rrp_smlb2_150_50_acceptance_amount;
	}
	public void setRrp_smlb2_150_50_acceptance_amount(BigDecimal rrp_smlb2_150_50_acceptance_amount) {
		this.rrp_smlb2_150_50_acceptance_amount = rrp_smlb2_150_50_acceptance_amount;
	}
	public BigDecimal getRrp_smlb2_150_50_lcbg_crm() {
		return rrp_smlb2_150_50_lcbg_crm;
	}
	public void setRrp_smlb2_150_50_lcbg_crm(BigDecimal rrp_smlb2_150_50_lcbg_crm) {
		this.rrp_smlb2_150_50_lcbg_crm = rrp_smlb2_150_50_lcbg_crm;
	}
	public BigDecimal getRrp_smlb2_150_50_rwa() {
		return rrp_smlb2_150_50_rwa;
	}
	public void setRrp_smlb2_150_50_rwa(BigDecimal rrp_smlb2_150_50_rwa) {
		this.rrp_smlb2_150_50_rwa = rrp_smlb2_150_50_rwa;
	}
	public BigDecimal getRrp_smlb2_150_50_under_ccf_amt() {
		return rrp_smlb2_150_50_under_ccf_amt;
	}
	public void setRrp_smlb2_150_50_under_ccf_amt(BigDecimal rrp_smlb2_150_50_under_ccf_amt) {
		this.rrp_smlb2_150_50_under_ccf_amt = rrp_smlb2_150_50_under_ccf_amt;
	}
	public BigDecimal getRrp_smlb2_150_10_lcbg_balance() {
		return rrp_smlb2_150_10_lcbg_balance;
	}
	public void setRrp_smlb2_150_10_lcbg_balance(BigDecimal rrp_smlb2_150_10_lcbg_balance) {
		this.rrp_smlb2_150_10_lcbg_balance = rrp_smlb2_150_10_lcbg_balance;
	}
	public BigDecimal getRrp_smlb2_150_10_acceptance_amount() {
		return rrp_smlb2_150_10_acceptance_amount;
	}
	public void setRrp_smlb2_150_10_acceptance_amount(BigDecimal rrp_smlb2_150_10_acceptance_amount) {
		this.rrp_smlb2_150_10_acceptance_amount = rrp_smlb2_150_10_acceptance_amount;
	}
	public BigDecimal getRrp_smlb2_150_10_lcbg_crm() {
		return rrp_smlb2_150_10_lcbg_crm;
	}
	public void setRrp_smlb2_150_10_lcbg_crm(BigDecimal rrp_smlb2_150_10_lcbg_crm) {
		this.rrp_smlb2_150_10_lcbg_crm = rrp_smlb2_150_10_lcbg_crm;
	}
	public BigDecimal getRrp_smlb2_150_10_rwa() {
		return rrp_smlb2_150_10_rwa;
	}
	public void setRrp_smlb2_150_10_rwa(BigDecimal rrp_smlb2_150_10_rwa) {
		this.rrp_smlb2_150_10_rwa = rrp_smlb2_150_10_rwa;
	}
	public BigDecimal getRrp_smlb2_150_10_under_ccf_amt() {
		return rrp_smlb2_150_10_under_ccf_amt;
	}
	public void setRrp_smlb2_150_10_under_ccf_amt(BigDecimal rrp_smlb2_150_10_under_ccf_amt) {
		this.rrp_smlb2_150_10_under_ccf_amt = rrp_smlb2_150_10_under_ccf_amt;
	}
	public BigDecimal getRrp_smlb2_150_lcbg_balance() {
		return rrp_smlb2_150_lcbg_balance;
	}
	public void setRrp_smlb2_150_lcbg_balance(BigDecimal rrp_smlb2_150_lcbg_balance) {
		this.rrp_smlb2_150_lcbg_balance = rrp_smlb2_150_lcbg_balance;
	}
	public BigDecimal getRrp_smlb2_150_acceptance_amount() {
		return rrp_smlb2_150_acceptance_amount;
	}
	public void setRrp_smlb2_150_acceptance_amount(BigDecimal rrp_smlb2_150_acceptance_amount) {
		this.rrp_smlb2_150_acceptance_amount = rrp_smlb2_150_acceptance_amount;
	}
	public BigDecimal getRrp_smlb2_150_lcbg_crm() {
		return rrp_smlb2_150_lcbg_crm;
	}
	public void setRrp_smlb2_150_lcbg_crm(BigDecimal rrp_smlb2_150_lcbg_crm) {
		this.rrp_smlb2_150_lcbg_crm = rrp_smlb2_150_lcbg_crm;
	}
	public BigDecimal getRrp_smlb2_150_rwa() {
		return rrp_smlb2_150_rwa;
	}
	public void setRrp_smlb2_150_rwa(BigDecimal rrp_smlb2_150_rwa) {
		this.rrp_smlb2_150_rwa = rrp_smlb2_150_rwa;
	}
	public BigDecimal getRrp_smlb2_150_under_ccf_amt() {
		return rrp_smlb2_150_under_ccf_amt;
	}
	public void setRrp_smlb2_150_under_ccf_amt(BigDecimal rrp_smlb2_150_under_ccf_amt) {
		this.rrp_smlb2_150_under_ccf_amt = rrp_smlb2_150_under_ccf_amt;
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
