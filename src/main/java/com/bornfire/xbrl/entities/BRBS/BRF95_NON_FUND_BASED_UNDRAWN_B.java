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
@Table(name="BRF95_NON_FUND_BASED_UNDRAWN_B")
public class BRF95_NON_FUND_BASED_UNDRAWN_B {
	private BigDecimal	b_bnk_0_undrwn_balance;
	private BigDecimal	b_bnk_0_undrwn_crm;
	private BigDecimal	b_bnk_0_undrwn_rwa;
	private BigDecimal	b_bnk_0_under_ccf_amt;
	private BigDecimal	b_bnk_20_undrwn_balance;
	private BigDecimal	b_bnk_20_undrwn_crm;
	private BigDecimal	b_bnk_20_undrwn_rwa;
	private BigDecimal	b_bnk_20_under_ccf_amt;
	private BigDecimal	b_bnk_50_undrwn_balance;
	private BigDecimal	b_bnk_50_undrwn_crm;
	private BigDecimal	b_bnk_50_undrwn_rwa;
	private BigDecimal	b_bnk_50_under_ccf_amt;
	private BigDecimal	b_bnk_100_undrwn_balance;
	private BigDecimal	b_bnk_100_undrwn_crm;
	private BigDecimal	b_bnk_100_undrwn_rwa;
	private BigDecimal	b_bnk_100_under_ccf_amt;
	private BigDecimal	b_bnk_150_undrwn_balance;
	private BigDecimal	b_bnk_150_undrwn_crm;
	private BigDecimal	b_bnk_150_undrwn_rwa;
	private BigDecimal	b_bnk_150_under_ccf_amt;
	private BigDecimal	b_cbs1_0_undrwn_balance;
	private BigDecimal	b_cbs1_0_undrwn_crm;
	private BigDecimal	b_cbs1_0_undrwn_rwa;
	private BigDecimal	b_cbs1_0_under_ccf_amt;
	private BigDecimal	b_cbs2_20_undrwn_balance;
	private BigDecimal	b_cbs2_20_undrwn_crm;
	private BigDecimal	b_cbs2_20_undrwn_rwa;
	private BigDecimal	b_cbs2_20_under_ccf_amt;
	private BigDecimal	b_cbs3_20_undrwn_balance;
	private BigDecimal	b_cbs3_20_undrwn_crm;
	private BigDecimal	b_cbs3_20_undrwn_rwa;
	private BigDecimal	b_cbs3_20_under_ccf_amt;
	private BigDecimal	b_cbs4_0_undrwn_balance;
	private BigDecimal	b_cbs4_0_undrwn_crm;
	private BigDecimal	b_cbs4_0_undrwn_rwa;
	private BigDecimal	b_cbs4_0_under_ccf_amt;
	private BigDecimal	b_cbs4_20_undrwn_balance;
	private BigDecimal	b_cbs4_20_undrwn_crm;
	private BigDecimal	b_cbs4_20_undrwn_rwa;
	private BigDecimal	b_cbs4_20_under_ccf_amt;
	private BigDecimal	b_cbs4_50_undrwn_balance;
	private BigDecimal	b_cbs4_50_undrwn_crm;
	private BigDecimal	b_cbs4_50_undrwn_rwa;
	private BigDecimal	b_cbs4_50_under_ccf_amt;
	private BigDecimal	b_cbs4_100_undrwn_balance;
	private BigDecimal	b_cbs4_100_undrwn_crm;
	private BigDecimal	b_cbs4_100_undrwn_rwa;
	private BigDecimal	b_cbs4_100_under_ccf_amt;
	private BigDecimal	b_cbs4_150_undrwn_balance;
	private BigDecimal	b_cbs4_150_undrwn_crm;
	private BigDecimal	b_cbs4_150_undrwn_rwa;
	private BigDecimal	b_cbs4_150_under_ccf_amt;
	private BigDecimal	b_cre_0_undrwn_balance;
	private BigDecimal	b_cre_0_undrwn_crm;
	private BigDecimal	b_cre_0_undrwn_rwa;
	private BigDecimal	b_cre_0_under_ccf_amt;
	private BigDecimal	b_cre_20_undrwn_balance;
	private BigDecimal	b_cre_20_undrwn_crm;
	private BigDecimal	b_cre_20_undrwn_rwa;
	private BigDecimal	b_cre_20_under_ccf_amt;
	private BigDecimal	b_cre_50_undrwn_balance;
	private BigDecimal	b_cre_50_undrwn_crm;
	private BigDecimal	b_cre_50_undrwn_rwa;
	private BigDecimal	b_cre_50_under_ccf_amt;
	private BigDecimal	b_cre_100_undrwn_balance;
	private BigDecimal	b_cre_100_undrwn_crm;
	private BigDecimal	b_cre_100_undrwn_rwa;
	private BigDecimal	b_cre_100_under_ccf_amt;
	private BigDecimal	b_cre_150_undrwn_balance;
	private BigDecimal	b_cre_150_undrwn_crm;
	private BigDecimal	b_cre_150_undrwn_rwa;
	private BigDecimal	b_cre_150_under_ccf_amt;
	private BigDecimal	b_crp_0_undrwn_balance;
	private BigDecimal	b_crp_0_undrwn_crm;
	private BigDecimal	b_crp_0_undrwn_rwa;
	private BigDecimal	b_crp_0_under_ccf_amt;
	private BigDecimal	b_crp_20_undrwn_balance;
	private BigDecimal	b_crp_20_undrwn_crm;
	private BigDecimal	b_crp_20_undrwn_rwa;
	private BigDecimal	b_crp_20_under_ccf_amt;
	private BigDecimal	b_crp_50_undrwn_balance;
	private BigDecimal	b_crp_50_undrwn_crm;
	private BigDecimal	b_crp_50_undrwn_rwa;
	private BigDecimal	b_crp_50_under_ccf_amt;
	private BigDecimal	b_crp_100_undrwn_balance;
	private BigDecimal	b_crp_100_undrwn_crm;
	private BigDecimal	b_crp_100_undrwn_rwa;
	private BigDecimal	b_crp_100_under_ccf_amt;
	private BigDecimal	b_crp_150_undrwn_balance;
	private BigDecimal	b_crp_150_undrwn_crm;
	private BigDecimal	b_crp_150_undrwn_rwa;
	private BigDecimal	b_crp_150_under_ccf_amt;
	private BigDecimal	b_hni_100_undrwn_balance;
	private BigDecimal	b_hni_100_undrwn_crm;
	private BigDecimal	b_hni_100_undrwn_rwa;
	private BigDecimal	b_hni_100_under_ccf_amt;
	private BigDecimal	b_pdl_100_undrwn_balance;
	private BigDecimal	b_pdl_100_undrwn_crm;
	private BigDecimal	b_pdl_100_undrwn_rwa;
	private BigDecimal	b_pdl_100_under_ccf_amt;
	private BigDecimal	b_pdl_150_undrwn_balance;
	private BigDecimal	b_pdl_150_undrwn_crm;
	private BigDecimal	b_pdl_150_undrwn_rwa;
	private BigDecimal	b_pdl_150_under_ccf_amt;
	private BigDecimal	b_psec_0_undrwn_balance;
	private BigDecimal	b_psec_0_undrwn_crm;
	private BigDecimal	b_psec_0_undrwn_rwa;
	private BigDecimal	b_psec_0_under_ccf_amt;
	private BigDecimal	b_psec_20_undrwn_balance;
	private BigDecimal	b_psec_20_undrwn_crm;
	private BigDecimal	b_psec_20_undrwn_rwa;
	private BigDecimal	b_psec_20_under_ccf_amt;
	private BigDecimal	b_psec_50_undrwn_balance;
	private BigDecimal	b_psec_50_undrwn_crm;
	private BigDecimal	b_psec_50_undrwn_rwa;
	private BigDecimal	b_psec_50_under_ccf_amt;
	private BigDecimal	b_psec_100_undrwn_balance;
	private BigDecimal	b_psec_100_undrwn_crm;
	private BigDecimal	b_psec_100_undrwn_rwa;
	private BigDecimal	b_psec_100_under_ccf_amt;
	private BigDecimal	b_psec_150_undrwn_balance;
	private BigDecimal	b_psec_150_undrwn_crm;
	private BigDecimal	b_psec_150_undrwn_rwa;
	private BigDecimal	b_psec_150_under_ccf_amt;
	private BigDecimal	b_res_35_undrwn_balance;
	private BigDecimal	b_res_35_undrwn_crm;
	private BigDecimal	b_res_35_undrwn_rwa;
	private BigDecimal	b_res_35_under_ccf_amt;
	private BigDecimal	b_res_100_undrwn_balance;
	private BigDecimal	b_res_100_undrwn_crm;
	private BigDecimal	b_res_100_undrwn_rwa;
	private BigDecimal	b_res_100_under_ccf_amt;
	private BigDecimal	b_rrp_inde1_75_undrwn_balance;
	private BigDecimal	b_rrp_inde1_75_undrwn_crm;
	private BigDecimal	b_rrp_inde1_75_undrwn_rwa;
	private BigDecimal	b_rrp_inde1_75_under_ccf_amt;
	private BigDecimal	b_rrp_inde2_100_undrwn_balance;
	private BigDecimal	b_rrp_inde2_100_undrwn_crm;
	private BigDecimal	b_rrp_inde2_100_undrwn_rwa;
	private BigDecimal	b_rrp_inde2_100_under_ccf_amt;
	private BigDecimal	b_rrp_smlb_75_undrwn_balance;
	private BigDecimal	b_rrp_smlb_75_undrwn_crm;
	private BigDecimal	b_rrp_smlb_75_undrwn_rwa;
	private BigDecimal	b_rrp_smlb_75_under_ccf_amt;
	private BigDecimal	b_rrp_smlb2_85_undrwn_balance;
	private BigDecimal	b_rrp_smlb2_85_undrwn_crm;
	private BigDecimal	b_rrp_smlb2_85_undrwn_rwa;
	private BigDecimal	b_rrp_smlb2_85_under_ccf_amt;
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
	public BigDecimal getB_bnk_0_undrwn_balance() {
		return b_bnk_0_undrwn_balance;
	}
	public void setB_bnk_0_undrwn_balance(BigDecimal b_bnk_0_undrwn_balance) {
		this.b_bnk_0_undrwn_balance = b_bnk_0_undrwn_balance;
	}
	public BigDecimal getB_bnk_0_undrwn_crm() {
		return b_bnk_0_undrwn_crm;
	}
	public void setB_bnk_0_undrwn_crm(BigDecimal b_bnk_0_undrwn_crm) {
		this.b_bnk_0_undrwn_crm = b_bnk_0_undrwn_crm;
	}
	public BigDecimal getB_bnk_0_undrwn_rwa() {
		return b_bnk_0_undrwn_rwa;
	}
	public void setB_bnk_0_undrwn_rwa(BigDecimal b_bnk_0_undrwn_rwa) {
		this.b_bnk_0_undrwn_rwa = b_bnk_0_undrwn_rwa;
	}
	public BigDecimal getB_bnk_0_under_ccf_amt() {
		return b_bnk_0_under_ccf_amt;
	}
	public void setB_bnk_0_under_ccf_amt(BigDecimal b_bnk_0_under_ccf_amt) {
		this.b_bnk_0_under_ccf_amt = b_bnk_0_under_ccf_amt;
	}
	public BigDecimal getB_bnk_20_undrwn_balance() {
		return b_bnk_20_undrwn_balance;
	}
	public void setB_bnk_20_undrwn_balance(BigDecimal b_bnk_20_undrwn_balance) {
		this.b_bnk_20_undrwn_balance = b_bnk_20_undrwn_balance;
	}
	public BigDecimal getB_bnk_20_undrwn_crm() {
		return b_bnk_20_undrwn_crm;
	}
	public void setB_bnk_20_undrwn_crm(BigDecimal b_bnk_20_undrwn_crm) {
		this.b_bnk_20_undrwn_crm = b_bnk_20_undrwn_crm;
	}
	public BigDecimal getB_bnk_20_undrwn_rwa() {
		return b_bnk_20_undrwn_rwa;
	}
	public void setB_bnk_20_undrwn_rwa(BigDecimal b_bnk_20_undrwn_rwa) {
		this.b_bnk_20_undrwn_rwa = b_bnk_20_undrwn_rwa;
	}
	public BigDecimal getB_bnk_20_under_ccf_amt() {
		return b_bnk_20_under_ccf_amt;
	}
	public void setB_bnk_20_under_ccf_amt(BigDecimal b_bnk_20_under_ccf_amt) {
		this.b_bnk_20_under_ccf_amt = b_bnk_20_under_ccf_amt;
	}
	public BigDecimal getB_bnk_50_undrwn_balance() {
		return b_bnk_50_undrwn_balance;
	}
	public void setB_bnk_50_undrwn_balance(BigDecimal b_bnk_50_undrwn_balance) {
		this.b_bnk_50_undrwn_balance = b_bnk_50_undrwn_balance;
	}
	public BigDecimal getB_bnk_50_undrwn_crm() {
		return b_bnk_50_undrwn_crm;
	}
	public void setB_bnk_50_undrwn_crm(BigDecimal b_bnk_50_undrwn_crm) {
		this.b_bnk_50_undrwn_crm = b_bnk_50_undrwn_crm;
	}
	public BigDecimal getB_bnk_50_undrwn_rwa() {
		return b_bnk_50_undrwn_rwa;
	}
	public void setB_bnk_50_undrwn_rwa(BigDecimal b_bnk_50_undrwn_rwa) {
		this.b_bnk_50_undrwn_rwa = b_bnk_50_undrwn_rwa;
	}
	public BigDecimal getB_bnk_50_under_ccf_amt() {
		return b_bnk_50_under_ccf_amt;
	}
	public void setB_bnk_50_under_ccf_amt(BigDecimal b_bnk_50_under_ccf_amt) {
		this.b_bnk_50_under_ccf_amt = b_bnk_50_under_ccf_amt;
	}
	public BigDecimal getB_bnk_100_undrwn_balance() {
		return b_bnk_100_undrwn_balance;
	}
	public void setB_bnk_100_undrwn_balance(BigDecimal b_bnk_100_undrwn_balance) {
		this.b_bnk_100_undrwn_balance = b_bnk_100_undrwn_balance;
	}
	public BigDecimal getB_bnk_100_undrwn_crm() {
		return b_bnk_100_undrwn_crm;
	}
	public void setB_bnk_100_undrwn_crm(BigDecimal b_bnk_100_undrwn_crm) {
		this.b_bnk_100_undrwn_crm = b_bnk_100_undrwn_crm;
	}
	public BigDecimal getB_bnk_100_undrwn_rwa() {
		return b_bnk_100_undrwn_rwa;
	}
	public void setB_bnk_100_undrwn_rwa(BigDecimal b_bnk_100_undrwn_rwa) {
		this.b_bnk_100_undrwn_rwa = b_bnk_100_undrwn_rwa;
	}
	public BigDecimal getB_bnk_100_under_ccf_amt() {
		return b_bnk_100_under_ccf_amt;
	}
	public void setB_bnk_100_under_ccf_amt(BigDecimal b_bnk_100_under_ccf_amt) {
		this.b_bnk_100_under_ccf_amt = b_bnk_100_under_ccf_amt;
	}
	public BigDecimal getB_bnk_150_undrwn_balance() {
		return b_bnk_150_undrwn_balance;
	}
	public void setB_bnk_150_undrwn_balance(BigDecimal b_bnk_150_undrwn_balance) {
		this.b_bnk_150_undrwn_balance = b_bnk_150_undrwn_balance;
	}
	public BigDecimal getB_bnk_150_undrwn_crm() {
		return b_bnk_150_undrwn_crm;
	}
	public void setB_bnk_150_undrwn_crm(BigDecimal b_bnk_150_undrwn_crm) {
		this.b_bnk_150_undrwn_crm = b_bnk_150_undrwn_crm;
	}
	public BigDecimal getB_bnk_150_undrwn_rwa() {
		return b_bnk_150_undrwn_rwa;
	}
	public void setB_bnk_150_undrwn_rwa(BigDecimal b_bnk_150_undrwn_rwa) {
		this.b_bnk_150_undrwn_rwa = b_bnk_150_undrwn_rwa;
	}
	public BigDecimal getB_bnk_150_under_ccf_amt() {
		return b_bnk_150_under_ccf_amt;
	}
	public void setB_bnk_150_under_ccf_amt(BigDecimal b_bnk_150_under_ccf_amt) {
		this.b_bnk_150_under_ccf_amt = b_bnk_150_under_ccf_amt;
	}
	public BigDecimal getB_cbs1_0_undrwn_balance() {
		return b_cbs1_0_undrwn_balance;
	}
	public void setB_cbs1_0_undrwn_balance(BigDecimal b_cbs1_0_undrwn_balance) {
		this.b_cbs1_0_undrwn_balance = b_cbs1_0_undrwn_balance;
	}
	public BigDecimal getB_cbs1_0_undrwn_crm() {
		return b_cbs1_0_undrwn_crm;
	}
	public void setB_cbs1_0_undrwn_crm(BigDecimal b_cbs1_0_undrwn_crm) {
		this.b_cbs1_0_undrwn_crm = b_cbs1_0_undrwn_crm;
	}
	public BigDecimal getB_cbs1_0_undrwn_rwa() {
		return b_cbs1_0_undrwn_rwa;
	}
	public void setB_cbs1_0_undrwn_rwa(BigDecimal b_cbs1_0_undrwn_rwa) {
		this.b_cbs1_0_undrwn_rwa = b_cbs1_0_undrwn_rwa;
	}
	public BigDecimal getB_cbs1_0_under_ccf_amt() {
		return b_cbs1_0_under_ccf_amt;
	}
	public void setB_cbs1_0_under_ccf_amt(BigDecimal b_cbs1_0_under_ccf_amt) {
		this.b_cbs1_0_under_ccf_amt = b_cbs1_0_under_ccf_amt;
	}
	public BigDecimal getB_cbs2_20_undrwn_balance() {
		return b_cbs2_20_undrwn_balance;
	}
	public void setB_cbs2_20_undrwn_balance(BigDecimal b_cbs2_20_undrwn_balance) {
		this.b_cbs2_20_undrwn_balance = b_cbs2_20_undrwn_balance;
	}
	public BigDecimal getB_cbs2_20_undrwn_crm() {
		return b_cbs2_20_undrwn_crm;
	}
	public void setB_cbs2_20_undrwn_crm(BigDecimal b_cbs2_20_undrwn_crm) {
		this.b_cbs2_20_undrwn_crm = b_cbs2_20_undrwn_crm;
	}
	public BigDecimal getB_cbs2_20_undrwn_rwa() {
		return b_cbs2_20_undrwn_rwa;
	}
	public void setB_cbs2_20_undrwn_rwa(BigDecimal b_cbs2_20_undrwn_rwa) {
		this.b_cbs2_20_undrwn_rwa = b_cbs2_20_undrwn_rwa;
	}
	public BigDecimal getB_cbs2_20_under_ccf_amt() {
		return b_cbs2_20_under_ccf_amt;
	}
	public void setB_cbs2_20_under_ccf_amt(BigDecimal b_cbs2_20_under_ccf_amt) {
		this.b_cbs2_20_under_ccf_amt = b_cbs2_20_under_ccf_amt;
	}
	public BigDecimal getB_cbs3_20_undrwn_balance() {
		return b_cbs3_20_undrwn_balance;
	}
	public void setB_cbs3_20_undrwn_balance(BigDecimal b_cbs3_20_undrwn_balance) {
		this.b_cbs3_20_undrwn_balance = b_cbs3_20_undrwn_balance;
	}
	public BigDecimal getB_cbs3_20_undrwn_crm() {
		return b_cbs3_20_undrwn_crm;
	}
	public void setB_cbs3_20_undrwn_crm(BigDecimal b_cbs3_20_undrwn_crm) {
		this.b_cbs3_20_undrwn_crm = b_cbs3_20_undrwn_crm;
	}
	public BigDecimal getB_cbs3_20_undrwn_rwa() {
		return b_cbs3_20_undrwn_rwa;
	}
	public void setB_cbs3_20_undrwn_rwa(BigDecimal b_cbs3_20_undrwn_rwa) {
		this.b_cbs3_20_undrwn_rwa = b_cbs3_20_undrwn_rwa;
	}
	public BigDecimal getB_cbs3_20_under_ccf_amt() {
		return b_cbs3_20_under_ccf_amt;
	}
	public void setB_cbs3_20_under_ccf_amt(BigDecimal b_cbs3_20_under_ccf_amt) {
		this.b_cbs3_20_under_ccf_amt = b_cbs3_20_under_ccf_amt;
	}
	public BigDecimal getB_cbs4_0_undrwn_balance() {
		return b_cbs4_0_undrwn_balance;
	}
	public void setB_cbs4_0_undrwn_balance(BigDecimal b_cbs4_0_undrwn_balance) {
		this.b_cbs4_0_undrwn_balance = b_cbs4_0_undrwn_balance;
	}
	public BigDecimal getB_cbs4_0_undrwn_crm() {
		return b_cbs4_0_undrwn_crm;
	}
	public void setB_cbs4_0_undrwn_crm(BigDecimal b_cbs4_0_undrwn_crm) {
		this.b_cbs4_0_undrwn_crm = b_cbs4_0_undrwn_crm;
	}
	public BigDecimal getB_cbs4_0_undrwn_rwa() {
		return b_cbs4_0_undrwn_rwa;
	}
	public void setB_cbs4_0_undrwn_rwa(BigDecimal b_cbs4_0_undrwn_rwa) {
		this.b_cbs4_0_undrwn_rwa = b_cbs4_0_undrwn_rwa;
	}
	public BigDecimal getB_cbs4_0_under_ccf_amt() {
		return b_cbs4_0_under_ccf_amt;
	}
	public void setB_cbs4_0_under_ccf_amt(BigDecimal b_cbs4_0_under_ccf_amt) {
		this.b_cbs4_0_under_ccf_amt = b_cbs4_0_under_ccf_amt;
	}
	public BigDecimal getB_cbs4_20_undrwn_balance() {
		return b_cbs4_20_undrwn_balance;
	}
	public void setB_cbs4_20_undrwn_balance(BigDecimal b_cbs4_20_undrwn_balance) {
		this.b_cbs4_20_undrwn_balance = b_cbs4_20_undrwn_balance;
	}
	public BigDecimal getB_cbs4_20_undrwn_crm() {
		return b_cbs4_20_undrwn_crm;
	}
	public void setB_cbs4_20_undrwn_crm(BigDecimal b_cbs4_20_undrwn_crm) {
		this.b_cbs4_20_undrwn_crm = b_cbs4_20_undrwn_crm;
	}
	public BigDecimal getB_cbs4_20_undrwn_rwa() {
		return b_cbs4_20_undrwn_rwa;
	}
	public void setB_cbs4_20_undrwn_rwa(BigDecimal b_cbs4_20_undrwn_rwa) {
		this.b_cbs4_20_undrwn_rwa = b_cbs4_20_undrwn_rwa;
	}
	public BigDecimal getB_cbs4_20_under_ccf_amt() {
		return b_cbs4_20_under_ccf_amt;
	}
	public void setB_cbs4_20_under_ccf_amt(BigDecimal b_cbs4_20_under_ccf_amt) {
		this.b_cbs4_20_under_ccf_amt = b_cbs4_20_under_ccf_amt;
	}
	public BigDecimal getB_cbs4_50_undrwn_balance() {
		return b_cbs4_50_undrwn_balance;
	}
	public void setB_cbs4_50_undrwn_balance(BigDecimal b_cbs4_50_undrwn_balance) {
		this.b_cbs4_50_undrwn_balance = b_cbs4_50_undrwn_balance;
	}
	public BigDecimal getB_cbs4_50_undrwn_crm() {
		return b_cbs4_50_undrwn_crm;
	}
	public void setB_cbs4_50_undrwn_crm(BigDecimal b_cbs4_50_undrwn_crm) {
		this.b_cbs4_50_undrwn_crm = b_cbs4_50_undrwn_crm;
	}
	public BigDecimal getB_cbs4_50_undrwn_rwa() {
		return b_cbs4_50_undrwn_rwa;
	}
	public void setB_cbs4_50_undrwn_rwa(BigDecimal b_cbs4_50_undrwn_rwa) {
		this.b_cbs4_50_undrwn_rwa = b_cbs4_50_undrwn_rwa;
	}
	public BigDecimal getB_cbs4_50_under_ccf_amt() {
		return b_cbs4_50_under_ccf_amt;
	}
	public void setB_cbs4_50_under_ccf_amt(BigDecimal b_cbs4_50_under_ccf_amt) {
		this.b_cbs4_50_under_ccf_amt = b_cbs4_50_under_ccf_amt;
	}
	public BigDecimal getB_cbs4_100_undrwn_balance() {
		return b_cbs4_100_undrwn_balance;
	}
	public void setB_cbs4_100_undrwn_balance(BigDecimal b_cbs4_100_undrwn_balance) {
		this.b_cbs4_100_undrwn_balance = b_cbs4_100_undrwn_balance;
	}
	public BigDecimal getB_cbs4_100_undrwn_crm() {
		return b_cbs4_100_undrwn_crm;
	}
	public void setB_cbs4_100_undrwn_crm(BigDecimal b_cbs4_100_undrwn_crm) {
		this.b_cbs4_100_undrwn_crm = b_cbs4_100_undrwn_crm;
	}
	public BigDecimal getB_cbs4_100_undrwn_rwa() {
		return b_cbs4_100_undrwn_rwa;
	}
	public void setB_cbs4_100_undrwn_rwa(BigDecimal b_cbs4_100_undrwn_rwa) {
		this.b_cbs4_100_undrwn_rwa = b_cbs4_100_undrwn_rwa;
	}
	public BigDecimal getB_cbs4_100_under_ccf_amt() {
		return b_cbs4_100_under_ccf_amt;
	}
	public void setB_cbs4_100_under_ccf_amt(BigDecimal b_cbs4_100_under_ccf_amt) {
		this.b_cbs4_100_under_ccf_amt = b_cbs4_100_under_ccf_amt;
	}
	public BigDecimal getB_cbs4_150_undrwn_balance() {
		return b_cbs4_150_undrwn_balance;
	}
	public void setB_cbs4_150_undrwn_balance(BigDecimal b_cbs4_150_undrwn_balance) {
		this.b_cbs4_150_undrwn_balance = b_cbs4_150_undrwn_balance;
	}
	public BigDecimal getB_cbs4_150_undrwn_crm() {
		return b_cbs4_150_undrwn_crm;
	}
	public void setB_cbs4_150_undrwn_crm(BigDecimal b_cbs4_150_undrwn_crm) {
		this.b_cbs4_150_undrwn_crm = b_cbs4_150_undrwn_crm;
	}
	public BigDecimal getB_cbs4_150_undrwn_rwa() {
		return b_cbs4_150_undrwn_rwa;
	}
	public void setB_cbs4_150_undrwn_rwa(BigDecimal b_cbs4_150_undrwn_rwa) {
		this.b_cbs4_150_undrwn_rwa = b_cbs4_150_undrwn_rwa;
	}
	public BigDecimal getB_cbs4_150_under_ccf_amt() {
		return b_cbs4_150_under_ccf_amt;
	}
	public void setB_cbs4_150_under_ccf_amt(BigDecimal b_cbs4_150_under_ccf_amt) {
		this.b_cbs4_150_under_ccf_amt = b_cbs4_150_under_ccf_amt;
	}
	public BigDecimal getB_cre_0_undrwn_balance() {
		return b_cre_0_undrwn_balance;
	}
	public void setB_cre_0_undrwn_balance(BigDecimal b_cre_0_undrwn_balance) {
		this.b_cre_0_undrwn_balance = b_cre_0_undrwn_balance;
	}
	public BigDecimal getB_cre_0_undrwn_crm() {
		return b_cre_0_undrwn_crm;
	}
	public void setB_cre_0_undrwn_crm(BigDecimal b_cre_0_undrwn_crm) {
		this.b_cre_0_undrwn_crm = b_cre_0_undrwn_crm;
	}
	public BigDecimal getB_cre_0_undrwn_rwa() {
		return b_cre_0_undrwn_rwa;
	}
	public void setB_cre_0_undrwn_rwa(BigDecimal b_cre_0_undrwn_rwa) {
		this.b_cre_0_undrwn_rwa = b_cre_0_undrwn_rwa;
	}
	public BigDecimal getB_cre_0_under_ccf_amt() {
		return b_cre_0_under_ccf_amt;
	}
	public void setB_cre_0_under_ccf_amt(BigDecimal b_cre_0_under_ccf_amt) {
		this.b_cre_0_under_ccf_amt = b_cre_0_under_ccf_amt;
	}
	public BigDecimal getB_cre_20_undrwn_balance() {
		return b_cre_20_undrwn_balance;
	}
	public void setB_cre_20_undrwn_balance(BigDecimal b_cre_20_undrwn_balance) {
		this.b_cre_20_undrwn_balance = b_cre_20_undrwn_balance;
	}
	public BigDecimal getB_cre_20_undrwn_crm() {
		return b_cre_20_undrwn_crm;
	}
	public void setB_cre_20_undrwn_crm(BigDecimal b_cre_20_undrwn_crm) {
		this.b_cre_20_undrwn_crm = b_cre_20_undrwn_crm;
	}
	public BigDecimal getB_cre_20_undrwn_rwa() {
		return b_cre_20_undrwn_rwa;
	}
	public void setB_cre_20_undrwn_rwa(BigDecimal b_cre_20_undrwn_rwa) {
		this.b_cre_20_undrwn_rwa = b_cre_20_undrwn_rwa;
	}
	public BigDecimal getB_cre_20_under_ccf_amt() {
		return b_cre_20_under_ccf_amt;
	}
	public void setB_cre_20_under_ccf_amt(BigDecimal b_cre_20_under_ccf_amt) {
		this.b_cre_20_under_ccf_amt = b_cre_20_under_ccf_amt;
	}
	public BigDecimal getB_cre_50_undrwn_balance() {
		return b_cre_50_undrwn_balance;
	}
	public void setB_cre_50_undrwn_balance(BigDecimal b_cre_50_undrwn_balance) {
		this.b_cre_50_undrwn_balance = b_cre_50_undrwn_balance;
	}
	public BigDecimal getB_cre_50_undrwn_crm() {
		return b_cre_50_undrwn_crm;
	}
	public void setB_cre_50_undrwn_crm(BigDecimal b_cre_50_undrwn_crm) {
		this.b_cre_50_undrwn_crm = b_cre_50_undrwn_crm;
	}
	public BigDecimal getB_cre_50_undrwn_rwa() {
		return b_cre_50_undrwn_rwa;
	}
	public void setB_cre_50_undrwn_rwa(BigDecimal b_cre_50_undrwn_rwa) {
		this.b_cre_50_undrwn_rwa = b_cre_50_undrwn_rwa;
	}
	public BigDecimal getB_cre_50_under_ccf_amt() {
		return b_cre_50_under_ccf_amt;
	}
	public void setB_cre_50_under_ccf_amt(BigDecimal b_cre_50_under_ccf_amt) {
		this.b_cre_50_under_ccf_amt = b_cre_50_under_ccf_amt;
	}
	public BigDecimal getB_cre_100_undrwn_balance() {
		return b_cre_100_undrwn_balance;
	}
	public void setB_cre_100_undrwn_balance(BigDecimal b_cre_100_undrwn_balance) {
		this.b_cre_100_undrwn_balance = b_cre_100_undrwn_balance;
	}
	public BigDecimal getB_cre_100_undrwn_crm() {
		return b_cre_100_undrwn_crm;
	}
	public void setB_cre_100_undrwn_crm(BigDecimal b_cre_100_undrwn_crm) {
		this.b_cre_100_undrwn_crm = b_cre_100_undrwn_crm;
	}
	public BigDecimal getB_cre_100_undrwn_rwa() {
		return b_cre_100_undrwn_rwa;
	}
	public void setB_cre_100_undrwn_rwa(BigDecimal b_cre_100_undrwn_rwa) {
		this.b_cre_100_undrwn_rwa = b_cre_100_undrwn_rwa;
	}
	public BigDecimal getB_cre_100_under_ccf_amt() {
		return b_cre_100_under_ccf_amt;
	}
	public void setB_cre_100_under_ccf_amt(BigDecimal b_cre_100_under_ccf_amt) {
		this.b_cre_100_under_ccf_amt = b_cre_100_under_ccf_amt;
	}
	public BigDecimal getB_cre_150_undrwn_balance() {
		return b_cre_150_undrwn_balance;
	}
	public void setB_cre_150_undrwn_balance(BigDecimal b_cre_150_undrwn_balance) {
		this.b_cre_150_undrwn_balance = b_cre_150_undrwn_balance;
	}
	public BigDecimal getB_cre_150_undrwn_crm() {
		return b_cre_150_undrwn_crm;
	}
	public void setB_cre_150_undrwn_crm(BigDecimal b_cre_150_undrwn_crm) {
		this.b_cre_150_undrwn_crm = b_cre_150_undrwn_crm;
	}
	public BigDecimal getB_cre_150_undrwn_rwa() {
		return b_cre_150_undrwn_rwa;
	}
	public void setB_cre_150_undrwn_rwa(BigDecimal b_cre_150_undrwn_rwa) {
		this.b_cre_150_undrwn_rwa = b_cre_150_undrwn_rwa;
	}
	public BigDecimal getB_cre_150_under_ccf_amt() {
		return b_cre_150_under_ccf_amt;
	}
	public void setB_cre_150_under_ccf_amt(BigDecimal b_cre_150_under_ccf_amt) {
		this.b_cre_150_under_ccf_amt = b_cre_150_under_ccf_amt;
	}
	public BigDecimal getB_crp_0_undrwn_balance() {
		return b_crp_0_undrwn_balance;
	}
	public void setB_crp_0_undrwn_balance(BigDecimal b_crp_0_undrwn_balance) {
		this.b_crp_0_undrwn_balance = b_crp_0_undrwn_balance;
	}
	public BigDecimal getB_crp_0_undrwn_crm() {
		return b_crp_0_undrwn_crm;
	}
	public void setB_crp_0_undrwn_crm(BigDecimal b_crp_0_undrwn_crm) {
		this.b_crp_0_undrwn_crm = b_crp_0_undrwn_crm;
	}
	public BigDecimal getB_crp_0_undrwn_rwa() {
		return b_crp_0_undrwn_rwa;
	}
	public void setB_crp_0_undrwn_rwa(BigDecimal b_crp_0_undrwn_rwa) {
		this.b_crp_0_undrwn_rwa = b_crp_0_undrwn_rwa;
	}
	public BigDecimal getB_crp_0_under_ccf_amt() {
		return b_crp_0_under_ccf_amt;
	}
	public void setB_crp_0_under_ccf_amt(BigDecimal b_crp_0_under_ccf_amt) {
		this.b_crp_0_under_ccf_amt = b_crp_0_under_ccf_amt;
	}
	public BigDecimal getB_crp_20_undrwn_balance() {
		return b_crp_20_undrwn_balance;
	}
	public void setB_crp_20_undrwn_balance(BigDecimal b_crp_20_undrwn_balance) {
		this.b_crp_20_undrwn_balance = b_crp_20_undrwn_balance;
	}
	public BigDecimal getB_crp_20_undrwn_crm() {
		return b_crp_20_undrwn_crm;
	}
	public void setB_crp_20_undrwn_crm(BigDecimal b_crp_20_undrwn_crm) {
		this.b_crp_20_undrwn_crm = b_crp_20_undrwn_crm;
	}
	public BigDecimal getB_crp_20_undrwn_rwa() {
		return b_crp_20_undrwn_rwa;
	}
	public void setB_crp_20_undrwn_rwa(BigDecimal b_crp_20_undrwn_rwa) {
		this.b_crp_20_undrwn_rwa = b_crp_20_undrwn_rwa;
	}
	public BigDecimal getB_crp_20_under_ccf_amt() {
		return b_crp_20_under_ccf_amt;
	}
	public void setB_crp_20_under_ccf_amt(BigDecimal b_crp_20_under_ccf_amt) {
		this.b_crp_20_under_ccf_amt = b_crp_20_under_ccf_amt;
	}
	public BigDecimal getB_crp_50_undrwn_balance() {
		return b_crp_50_undrwn_balance;
	}
	public void setB_crp_50_undrwn_balance(BigDecimal b_crp_50_undrwn_balance) {
		this.b_crp_50_undrwn_balance = b_crp_50_undrwn_balance;
	}
	public BigDecimal getB_crp_50_undrwn_crm() {
		return b_crp_50_undrwn_crm;
	}
	public void setB_crp_50_undrwn_crm(BigDecimal b_crp_50_undrwn_crm) {
		this.b_crp_50_undrwn_crm = b_crp_50_undrwn_crm;
	}
	public BigDecimal getB_crp_50_undrwn_rwa() {
		return b_crp_50_undrwn_rwa;
	}
	public void setB_crp_50_undrwn_rwa(BigDecimal b_crp_50_undrwn_rwa) {
		this.b_crp_50_undrwn_rwa = b_crp_50_undrwn_rwa;
	}
	public BigDecimal getB_crp_50_under_ccf_amt() {
		return b_crp_50_under_ccf_amt;
	}
	public void setB_crp_50_under_ccf_amt(BigDecimal b_crp_50_under_ccf_amt) {
		this.b_crp_50_under_ccf_amt = b_crp_50_under_ccf_amt;
	}
	public BigDecimal getB_crp_100_undrwn_balance() {
		return b_crp_100_undrwn_balance;
	}
	public void setB_crp_100_undrwn_balance(BigDecimal b_crp_100_undrwn_balance) {
		this.b_crp_100_undrwn_balance = b_crp_100_undrwn_balance;
	}
	public BigDecimal getB_crp_100_undrwn_crm() {
		return b_crp_100_undrwn_crm;
	}
	public void setB_crp_100_undrwn_crm(BigDecimal b_crp_100_undrwn_crm) {
		this.b_crp_100_undrwn_crm = b_crp_100_undrwn_crm;
	}
	public BigDecimal getB_crp_100_undrwn_rwa() {
		return b_crp_100_undrwn_rwa;
	}
	public void setB_crp_100_undrwn_rwa(BigDecimal b_crp_100_undrwn_rwa) {
		this.b_crp_100_undrwn_rwa = b_crp_100_undrwn_rwa;
	}
	public BigDecimal getB_crp_100_under_ccf_amt() {
		return b_crp_100_under_ccf_amt;
	}
	public void setB_crp_100_under_ccf_amt(BigDecimal b_crp_100_under_ccf_amt) {
		this.b_crp_100_under_ccf_amt = b_crp_100_under_ccf_amt;
	}
	public BigDecimal getB_crp_150_undrwn_balance() {
		return b_crp_150_undrwn_balance;
	}
	public void setB_crp_150_undrwn_balance(BigDecimal b_crp_150_undrwn_balance) {
		this.b_crp_150_undrwn_balance = b_crp_150_undrwn_balance;
	}
	public BigDecimal getB_crp_150_undrwn_crm() {
		return b_crp_150_undrwn_crm;
	}
	public void setB_crp_150_undrwn_crm(BigDecimal b_crp_150_undrwn_crm) {
		this.b_crp_150_undrwn_crm = b_crp_150_undrwn_crm;
	}
	public BigDecimal getB_crp_150_undrwn_rwa() {
		return b_crp_150_undrwn_rwa;
	}
	public void setB_crp_150_undrwn_rwa(BigDecimal b_crp_150_undrwn_rwa) {
		this.b_crp_150_undrwn_rwa = b_crp_150_undrwn_rwa;
	}
	public BigDecimal getB_crp_150_under_ccf_amt() {
		return b_crp_150_under_ccf_amt;
	}
	public void setB_crp_150_under_ccf_amt(BigDecimal b_crp_150_under_ccf_amt) {
		this.b_crp_150_under_ccf_amt = b_crp_150_under_ccf_amt;
	}
	public BigDecimal getB_hni_100_undrwn_balance() {
		return b_hni_100_undrwn_balance;
	}
	public void setB_hni_100_undrwn_balance(BigDecimal b_hni_100_undrwn_balance) {
		this.b_hni_100_undrwn_balance = b_hni_100_undrwn_balance;
	}
	public BigDecimal getB_hni_100_undrwn_crm() {
		return b_hni_100_undrwn_crm;
	}
	public void setB_hni_100_undrwn_crm(BigDecimal b_hni_100_undrwn_crm) {
		this.b_hni_100_undrwn_crm = b_hni_100_undrwn_crm;
	}
	public BigDecimal getB_hni_100_undrwn_rwa() {
		return b_hni_100_undrwn_rwa;
	}
	public void setB_hni_100_undrwn_rwa(BigDecimal b_hni_100_undrwn_rwa) {
		this.b_hni_100_undrwn_rwa = b_hni_100_undrwn_rwa;
	}
	public BigDecimal getB_hni_100_under_ccf_amt() {
		return b_hni_100_under_ccf_amt;
	}
	public void setB_hni_100_under_ccf_amt(BigDecimal b_hni_100_under_ccf_amt) {
		this.b_hni_100_under_ccf_amt = b_hni_100_under_ccf_amt;
	}
	public BigDecimal getB_pdl_100_undrwn_balance() {
		return b_pdl_100_undrwn_balance;
	}
	public void setB_pdl_100_undrwn_balance(BigDecimal b_pdl_100_undrwn_balance) {
		this.b_pdl_100_undrwn_balance = b_pdl_100_undrwn_balance;
	}
	public BigDecimal getB_pdl_100_undrwn_crm() {
		return b_pdl_100_undrwn_crm;
	}
	public void setB_pdl_100_undrwn_crm(BigDecimal b_pdl_100_undrwn_crm) {
		this.b_pdl_100_undrwn_crm = b_pdl_100_undrwn_crm;
	}
	public BigDecimal getB_pdl_100_undrwn_rwa() {
		return b_pdl_100_undrwn_rwa;
	}
	public void setB_pdl_100_undrwn_rwa(BigDecimal b_pdl_100_undrwn_rwa) {
		this.b_pdl_100_undrwn_rwa = b_pdl_100_undrwn_rwa;
	}
	public BigDecimal getB_pdl_100_under_ccf_amt() {
		return b_pdl_100_under_ccf_amt;
	}
	public void setB_pdl_100_under_ccf_amt(BigDecimal b_pdl_100_under_ccf_amt) {
		this.b_pdl_100_under_ccf_amt = b_pdl_100_under_ccf_amt;
	}
	public BigDecimal getB_pdl_150_undrwn_balance() {
		return b_pdl_150_undrwn_balance;
	}
	public void setB_pdl_150_undrwn_balance(BigDecimal b_pdl_150_undrwn_balance) {
		this.b_pdl_150_undrwn_balance = b_pdl_150_undrwn_balance;
	}
	public BigDecimal getB_pdl_150_undrwn_crm() {
		return b_pdl_150_undrwn_crm;
	}
	public void setB_pdl_150_undrwn_crm(BigDecimal b_pdl_150_undrwn_crm) {
		this.b_pdl_150_undrwn_crm = b_pdl_150_undrwn_crm;
	}
	public BigDecimal getB_pdl_150_undrwn_rwa() {
		return b_pdl_150_undrwn_rwa;
	}
	public void setB_pdl_150_undrwn_rwa(BigDecimal b_pdl_150_undrwn_rwa) {
		this.b_pdl_150_undrwn_rwa = b_pdl_150_undrwn_rwa;
	}
	public BigDecimal getB_pdl_150_under_ccf_amt() {
		return b_pdl_150_under_ccf_amt;
	}
	public void setB_pdl_150_under_ccf_amt(BigDecimal b_pdl_150_under_ccf_amt) {
		this.b_pdl_150_under_ccf_amt = b_pdl_150_under_ccf_amt;
	}
	public BigDecimal getB_psec_0_undrwn_balance() {
		return b_psec_0_undrwn_balance;
	}
	public void setB_psec_0_undrwn_balance(BigDecimal b_psec_0_undrwn_balance) {
		this.b_psec_0_undrwn_balance = b_psec_0_undrwn_balance;
	}
	public BigDecimal getB_psec_0_undrwn_crm() {
		return b_psec_0_undrwn_crm;
	}
	public void setB_psec_0_undrwn_crm(BigDecimal b_psec_0_undrwn_crm) {
		this.b_psec_0_undrwn_crm = b_psec_0_undrwn_crm;
	}
	public BigDecimal getB_psec_0_undrwn_rwa() {
		return b_psec_0_undrwn_rwa;
	}
	public void setB_psec_0_undrwn_rwa(BigDecimal b_psec_0_undrwn_rwa) {
		this.b_psec_0_undrwn_rwa = b_psec_0_undrwn_rwa;
	}
	public BigDecimal getB_psec_0_under_ccf_amt() {
		return b_psec_0_under_ccf_amt;
	}
	public void setB_psec_0_under_ccf_amt(BigDecimal b_psec_0_under_ccf_amt) {
		this.b_psec_0_under_ccf_amt = b_psec_0_under_ccf_amt;
	}
	public BigDecimal getB_psec_20_undrwn_balance() {
		return b_psec_20_undrwn_balance;
	}
	public void setB_psec_20_undrwn_balance(BigDecimal b_psec_20_undrwn_balance) {
		this.b_psec_20_undrwn_balance = b_psec_20_undrwn_balance;
	}
	public BigDecimal getB_psec_20_undrwn_crm() {
		return b_psec_20_undrwn_crm;
	}
	public void setB_psec_20_undrwn_crm(BigDecimal b_psec_20_undrwn_crm) {
		this.b_psec_20_undrwn_crm = b_psec_20_undrwn_crm;
	}
	public BigDecimal getB_psec_20_undrwn_rwa() {
		return b_psec_20_undrwn_rwa;
	}
	public void setB_psec_20_undrwn_rwa(BigDecimal b_psec_20_undrwn_rwa) {
		this.b_psec_20_undrwn_rwa = b_psec_20_undrwn_rwa;
	}
	public BigDecimal getB_psec_20_under_ccf_amt() {
		return b_psec_20_under_ccf_amt;
	}
	public void setB_psec_20_under_ccf_amt(BigDecimal b_psec_20_under_ccf_amt) {
		this.b_psec_20_under_ccf_amt = b_psec_20_under_ccf_amt;
	}
	public BigDecimal getB_psec_50_undrwn_balance() {
		return b_psec_50_undrwn_balance;
	}
	public void setB_psec_50_undrwn_balance(BigDecimal b_psec_50_undrwn_balance) {
		this.b_psec_50_undrwn_balance = b_psec_50_undrwn_balance;
	}
	public BigDecimal getB_psec_50_undrwn_crm() {
		return b_psec_50_undrwn_crm;
	}
	public void setB_psec_50_undrwn_crm(BigDecimal b_psec_50_undrwn_crm) {
		this.b_psec_50_undrwn_crm = b_psec_50_undrwn_crm;
	}
	public BigDecimal getB_psec_50_undrwn_rwa() {
		return b_psec_50_undrwn_rwa;
	}
	public void setB_psec_50_undrwn_rwa(BigDecimal b_psec_50_undrwn_rwa) {
		this.b_psec_50_undrwn_rwa = b_psec_50_undrwn_rwa;
	}
	public BigDecimal getB_psec_50_under_ccf_amt() {
		return b_psec_50_under_ccf_amt;
	}
	public void setB_psec_50_under_ccf_amt(BigDecimal b_psec_50_under_ccf_amt) {
		this.b_psec_50_under_ccf_amt = b_psec_50_under_ccf_amt;
	}
	public BigDecimal getB_psec_100_undrwn_balance() {
		return b_psec_100_undrwn_balance;
	}
	public void setB_psec_100_undrwn_balance(BigDecimal b_psec_100_undrwn_balance) {
		this.b_psec_100_undrwn_balance = b_psec_100_undrwn_balance;
	}
	public BigDecimal getB_psec_100_undrwn_crm() {
		return b_psec_100_undrwn_crm;
	}
	public void setB_psec_100_undrwn_crm(BigDecimal b_psec_100_undrwn_crm) {
		this.b_psec_100_undrwn_crm = b_psec_100_undrwn_crm;
	}
	public BigDecimal getB_psec_100_undrwn_rwa() {
		return b_psec_100_undrwn_rwa;
	}
	public void setB_psec_100_undrwn_rwa(BigDecimal b_psec_100_undrwn_rwa) {
		this.b_psec_100_undrwn_rwa = b_psec_100_undrwn_rwa;
	}
	public BigDecimal getB_psec_100_under_ccf_amt() {
		return b_psec_100_under_ccf_amt;
	}
	public void setB_psec_100_under_ccf_amt(BigDecimal b_psec_100_under_ccf_amt) {
		this.b_psec_100_under_ccf_amt = b_psec_100_under_ccf_amt;
	}
	public BigDecimal getB_psec_150_undrwn_balance() {
		return b_psec_150_undrwn_balance;
	}
	public void setB_psec_150_undrwn_balance(BigDecimal b_psec_150_undrwn_balance) {
		this.b_psec_150_undrwn_balance = b_psec_150_undrwn_balance;
	}
	public BigDecimal getB_psec_150_undrwn_crm() {
		return b_psec_150_undrwn_crm;
	}
	public void setB_psec_150_undrwn_crm(BigDecimal b_psec_150_undrwn_crm) {
		this.b_psec_150_undrwn_crm = b_psec_150_undrwn_crm;
	}
	public BigDecimal getB_psec_150_undrwn_rwa() {
		return b_psec_150_undrwn_rwa;
	}
	public void setB_psec_150_undrwn_rwa(BigDecimal b_psec_150_undrwn_rwa) {
		this.b_psec_150_undrwn_rwa = b_psec_150_undrwn_rwa;
	}
	public BigDecimal getB_psec_150_under_ccf_amt() {
		return b_psec_150_under_ccf_amt;
	}
	public void setB_psec_150_under_ccf_amt(BigDecimal b_psec_150_under_ccf_amt) {
		this.b_psec_150_under_ccf_amt = b_psec_150_under_ccf_amt;
	}
	public BigDecimal getB_res_35_undrwn_balance() {
		return b_res_35_undrwn_balance;
	}
	public void setB_res_35_undrwn_balance(BigDecimal b_res_35_undrwn_balance) {
		this.b_res_35_undrwn_balance = b_res_35_undrwn_balance;
	}
	public BigDecimal getB_res_35_undrwn_crm() {
		return b_res_35_undrwn_crm;
	}
	public void setB_res_35_undrwn_crm(BigDecimal b_res_35_undrwn_crm) {
		this.b_res_35_undrwn_crm = b_res_35_undrwn_crm;
	}
	public BigDecimal getB_res_35_undrwn_rwa() {
		return b_res_35_undrwn_rwa;
	}
	public void setB_res_35_undrwn_rwa(BigDecimal b_res_35_undrwn_rwa) {
		this.b_res_35_undrwn_rwa = b_res_35_undrwn_rwa;
	}
	public BigDecimal getB_res_35_under_ccf_amt() {
		return b_res_35_under_ccf_amt;
	}
	public void setB_res_35_under_ccf_amt(BigDecimal b_res_35_under_ccf_amt) {
		this.b_res_35_under_ccf_amt = b_res_35_under_ccf_amt;
	}
	public BigDecimal getB_res_100_undrwn_balance() {
		return b_res_100_undrwn_balance;
	}
	public void setB_res_100_undrwn_balance(BigDecimal b_res_100_undrwn_balance) {
		this.b_res_100_undrwn_balance = b_res_100_undrwn_balance;
	}
	public BigDecimal getB_res_100_undrwn_crm() {
		return b_res_100_undrwn_crm;
	}
	public void setB_res_100_undrwn_crm(BigDecimal b_res_100_undrwn_crm) {
		this.b_res_100_undrwn_crm = b_res_100_undrwn_crm;
	}
	public BigDecimal getB_res_100_undrwn_rwa() {
		return b_res_100_undrwn_rwa;
	}
	public void setB_res_100_undrwn_rwa(BigDecimal b_res_100_undrwn_rwa) {
		this.b_res_100_undrwn_rwa = b_res_100_undrwn_rwa;
	}
	public BigDecimal getB_res_100_under_ccf_amt() {
		return b_res_100_under_ccf_amt;
	}
	public void setB_res_100_under_ccf_amt(BigDecimal b_res_100_under_ccf_amt) {
		this.b_res_100_under_ccf_amt = b_res_100_under_ccf_amt;
	}
	public BigDecimal getB_rrp_inde1_75_undrwn_balance() {
		return b_rrp_inde1_75_undrwn_balance;
	}
	public void setB_rrp_inde1_75_undrwn_balance(BigDecimal b_rrp_inde1_75_undrwn_balance) {
		this.b_rrp_inde1_75_undrwn_balance = b_rrp_inde1_75_undrwn_balance;
	}
	public BigDecimal getB_rrp_inde1_75_undrwn_crm() {
		return b_rrp_inde1_75_undrwn_crm;
	}
	public void setB_rrp_inde1_75_undrwn_crm(BigDecimal b_rrp_inde1_75_undrwn_crm) {
		this.b_rrp_inde1_75_undrwn_crm = b_rrp_inde1_75_undrwn_crm;
	}
	public BigDecimal getB_rrp_inde1_75_undrwn_rwa() {
		return b_rrp_inde1_75_undrwn_rwa;
	}
	public void setB_rrp_inde1_75_undrwn_rwa(BigDecimal b_rrp_inde1_75_undrwn_rwa) {
		this.b_rrp_inde1_75_undrwn_rwa = b_rrp_inde1_75_undrwn_rwa;
	}
	public BigDecimal getB_rrp_inde1_75_under_ccf_amt() {
		return b_rrp_inde1_75_under_ccf_amt;
	}
	public void setB_rrp_inde1_75_under_ccf_amt(BigDecimal b_rrp_inde1_75_under_ccf_amt) {
		this.b_rrp_inde1_75_under_ccf_amt = b_rrp_inde1_75_under_ccf_amt;
	}
	public BigDecimal getB_rrp_inde2_100_undrwn_balance() {
		return b_rrp_inde2_100_undrwn_balance;
	}
	public void setB_rrp_inde2_100_undrwn_balance(BigDecimal b_rrp_inde2_100_undrwn_balance) {
		this.b_rrp_inde2_100_undrwn_balance = b_rrp_inde2_100_undrwn_balance;
	}
	public BigDecimal getB_rrp_inde2_100_undrwn_crm() {
		return b_rrp_inde2_100_undrwn_crm;
	}
	public void setB_rrp_inde2_100_undrwn_crm(BigDecimal b_rrp_inde2_100_undrwn_crm) {
		this.b_rrp_inde2_100_undrwn_crm = b_rrp_inde2_100_undrwn_crm;
	}
	public BigDecimal getB_rrp_inde2_100_undrwn_rwa() {
		return b_rrp_inde2_100_undrwn_rwa;
	}
	public void setB_rrp_inde2_100_undrwn_rwa(BigDecimal b_rrp_inde2_100_undrwn_rwa) {
		this.b_rrp_inde2_100_undrwn_rwa = b_rrp_inde2_100_undrwn_rwa;
	}
	public BigDecimal getB_rrp_inde2_100_under_ccf_amt() {
		return b_rrp_inde2_100_under_ccf_amt;
	}
	public void setB_rrp_inde2_100_under_ccf_amt(BigDecimal b_rrp_inde2_100_under_ccf_amt) {
		this.b_rrp_inde2_100_under_ccf_amt = b_rrp_inde2_100_under_ccf_amt;
	}
	public BigDecimal getB_rrp_smlb_75_undrwn_balance() {
		return b_rrp_smlb_75_undrwn_balance;
	}
	public void setB_rrp_smlb_75_undrwn_balance(BigDecimal b_rrp_smlb_75_undrwn_balance) {
		this.b_rrp_smlb_75_undrwn_balance = b_rrp_smlb_75_undrwn_balance;
	}
	public BigDecimal getB_rrp_smlb_75_undrwn_crm() {
		return b_rrp_smlb_75_undrwn_crm;
	}
	public void setB_rrp_smlb_75_undrwn_crm(BigDecimal b_rrp_smlb_75_undrwn_crm) {
		this.b_rrp_smlb_75_undrwn_crm = b_rrp_smlb_75_undrwn_crm;
	}
	public BigDecimal getB_rrp_smlb_75_undrwn_rwa() {
		return b_rrp_smlb_75_undrwn_rwa;
	}
	public void setB_rrp_smlb_75_undrwn_rwa(BigDecimal b_rrp_smlb_75_undrwn_rwa) {
		this.b_rrp_smlb_75_undrwn_rwa = b_rrp_smlb_75_undrwn_rwa;
	}
	public BigDecimal getB_rrp_smlb_75_under_ccf_amt() {
		return b_rrp_smlb_75_under_ccf_amt;
	}
	public void setB_rrp_smlb_75_under_ccf_amt(BigDecimal b_rrp_smlb_75_under_ccf_amt) {
		this.b_rrp_smlb_75_under_ccf_amt = b_rrp_smlb_75_under_ccf_amt;
	}
	public BigDecimal getB_rrp_smlb2_85_undrwn_balance() {
		return b_rrp_smlb2_85_undrwn_balance;
	}
	public void setB_rrp_smlb2_85_undrwn_balance(BigDecimal b_rrp_smlb2_85_undrwn_balance) {
		this.b_rrp_smlb2_85_undrwn_balance = b_rrp_smlb2_85_undrwn_balance;
	}
	public BigDecimal getB_rrp_smlb2_85_undrwn_crm() {
		return b_rrp_smlb2_85_undrwn_crm;
	}
	public void setB_rrp_smlb2_85_undrwn_crm(BigDecimal b_rrp_smlb2_85_undrwn_crm) {
		this.b_rrp_smlb2_85_undrwn_crm = b_rrp_smlb2_85_undrwn_crm;
	}
	public BigDecimal getB_rrp_smlb2_85_undrwn_rwa() {
		return b_rrp_smlb2_85_undrwn_rwa;
	}
	public void setB_rrp_smlb2_85_undrwn_rwa(BigDecimal b_rrp_smlb2_85_undrwn_rwa) {
		this.b_rrp_smlb2_85_undrwn_rwa = b_rrp_smlb2_85_undrwn_rwa;
	}
	public BigDecimal getB_rrp_smlb2_85_under_ccf_amt() {
		return b_rrp_smlb2_85_under_ccf_amt;
	}
	public void setB_rrp_smlb2_85_under_ccf_amt(BigDecimal b_rrp_smlb2_85_under_ccf_amt) {
		this.b_rrp_smlb2_85_under_ccf_amt = b_rrp_smlb2_85_under_ccf_amt;
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
