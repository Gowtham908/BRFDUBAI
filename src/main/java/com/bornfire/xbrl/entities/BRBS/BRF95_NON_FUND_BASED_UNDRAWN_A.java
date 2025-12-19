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
@Table(name="BRF95_NON_FUND_BASED_UNDRAWN_A")

public class BRF95_NON_FUND_BASED_UNDRAWN_A {
	private BigDecimal	bnk_0_undrwn_balance;
	private BigDecimal	bnk_0_undrwn_crm;
	private BigDecimal	bnk_0_undrwn_rwa;
	private BigDecimal	bnk_0_under_ccf_amt;
	private BigDecimal	bnk_20_undrwn_balance;
	private BigDecimal	bnk_20_undrwn_crm;
	private BigDecimal	bnk_20_undrwn_rwa;
	private BigDecimal	bnk_20_under_ccf_amt;
	private BigDecimal	bnk_50_undrwn_balance;
	private BigDecimal	bnk_50_undrwn_crm;
	private BigDecimal	bnk_50_undrwn_rwa;
	private BigDecimal	bnk_50_under_ccf_amt;
	private BigDecimal	bnk_100_undrwn_balance;
	private BigDecimal	bnk_100_undrwn_crm;
	private BigDecimal	bnk_100_undrwn_rwa;
	private BigDecimal	bnk_100_under_ccf_amt;
	private BigDecimal	bnk_150_undrwn_balance;
	private BigDecimal	bnk_150_undrwn_crm;
	private BigDecimal	bnk_150_undrwn_rwa;
	private BigDecimal	bnk_150_under_ccf_amt;
	private BigDecimal	cbs1_0_undrwn_balance;
	private BigDecimal	cbs1_0_undrwn_crm;
	private BigDecimal	cbs1_0_undrwn_rwa;
	private BigDecimal	cbs1_0_under_ccf_amt;
	private BigDecimal	cbs2_20_undrwn_balance;
	private BigDecimal	cbs2_20_undrwn_crm;
	private BigDecimal	cbs2_20_undrwn_rwa;
	private BigDecimal	cbs2_20_under_ccf_amt;
	private BigDecimal	cbs3_20_undrwn_balance;
	private BigDecimal	cbs3_20_undrwn_crm;
	private BigDecimal	cbs3_20_undrwn_rwa;
	private BigDecimal	cbs3_20_under_ccf_amt;
	private BigDecimal	cbs4_0_undrwn_balance;
	private BigDecimal	cbs4_0_undrwn_crm;
	private BigDecimal	cbs4_0_undrwn_rwa;
	private BigDecimal	cbs4_0_under_ccf_amt;
	private BigDecimal	cbs4_20_undrwn_balance;
	private BigDecimal	cbs4_20_undrwn_crm;
	private BigDecimal	cbs4_20_undrwn_rwa;
	private BigDecimal	cbs4_20_under_ccf_amt;
	private BigDecimal	cbs4_50_undrwn_balance;
	private BigDecimal	cbs4_50_undrwn_crm;
	private BigDecimal	cbs4_50_undrwn_rwa;
	private BigDecimal	cbs4_50_under_ccf_amt;
	private BigDecimal	cbs4_100_undrwn_balance;
	private BigDecimal	cbs4_100_undrwn_crm;
	private BigDecimal	cbs4_100_undrwn_rwa;
	private BigDecimal	cbs4_100_under_ccf_amt;
	private BigDecimal	cbs4_150_undrwn_balance;
	private BigDecimal	cbs4_150_undrwn_crm;
	private BigDecimal	cbs4_150_undrwn_rwa;
	private BigDecimal	cbs4_150_under_ccf_amt;
	private BigDecimal	cre_0_undrwn_balance;
	private BigDecimal	cre_0_undrwn_crm;
	private BigDecimal	cre_0_undrwn_rwa;
	private BigDecimal	cre_0_under_ccf_amt;
	private BigDecimal	cre_20_undrwn_balance;
	private BigDecimal	cre_20_undrwn_crm;
	private BigDecimal	cre_20_undrwn_rwa;
	private BigDecimal	cre_20_under_ccf_amt;
	private BigDecimal	cre_50_undrwn_balance;
	private BigDecimal	cre_50_undrwn_crm;
	private BigDecimal	cre_50_undrwn_rwa;
	private BigDecimal	cre_50_under_ccf_amt;
	private BigDecimal	cre_100_undrwn_balance;
	private BigDecimal	cre_100_undrwn_crm;
	private BigDecimal	cre_100_undrwn_rwa;
	private BigDecimal	cre_100_under_ccf_amt;
	private BigDecimal	cre_150_undrwn_balance;
	private BigDecimal	cre_150_undrwn_crm;
	private BigDecimal	cre_150_undrwn_rwa;
	private BigDecimal	cre_150_under_ccf_amt;
	private BigDecimal	crp_0_undrwn_balance;
	private BigDecimal	crp_0_undrwn_crm;
	private BigDecimal	crp_0_undrwn_rwa;
	private BigDecimal	crp_0_under_ccf_amt;
	private BigDecimal	crp_20_undrwn_balance;
	private BigDecimal	crp_20_undrwn_crm;
	private BigDecimal	crp_20_undrwn_rwa;
	private BigDecimal	crp_20_under_ccf_amt;
	private BigDecimal	crp_50_undrwn_balance;
	private BigDecimal	crp_50_undrwn_crm;
	private BigDecimal	crp_50_undrwn_rwa;
	private BigDecimal	crp_50_under_ccf_amt;
	private BigDecimal	crp_100_undrwn_balance;
	private BigDecimal	crp_100_undrwn_crm;
	private BigDecimal	crp_100_undrwn_rwa;
	private BigDecimal	crp_100_under_ccf_amt;
	private BigDecimal	crp_150_undrwn_balance;
	private BigDecimal	crp_150_undrwn_crm;
	private BigDecimal	crp_150_undrwn_rwa;
	private BigDecimal	crp_150_under_ccf_amt;
	private BigDecimal	hni_100_undrwn_balance;
	private BigDecimal	hni_100_undrwn_crm;
	private BigDecimal	hni_100_undrwn_rwa;
	private BigDecimal	hni_100_under_ccf_amt;
	private BigDecimal	pdl_100_undrwn_balance;
	private BigDecimal	pdl_100_undrwn_crm;
	private BigDecimal	pdl_100_undrwn_rwa;
	private BigDecimal	pdl_100_under_ccf_amt;
	private BigDecimal	pdl_150_undrwn_balance;
	private BigDecimal	pdl_150_undrwn_crm;
	private BigDecimal	pdl_150_undrwn_rwa;
	private BigDecimal	pdl_150_under_ccf_amt;
	private BigDecimal	psec_0_undrwn_balance;
	private BigDecimal	psec_0_undrwn_crm;
	private BigDecimal	psec_0_undrwn_rwa;
	private BigDecimal	psec_0_under_ccf_amt;
	private BigDecimal	psec_20_undrwn_balance;
	private BigDecimal	psec_20_undrwn_crm;
	private BigDecimal	psec_20_undrwn_rwa;
	private BigDecimal	psec_20_under_ccf_amt;
	private BigDecimal	psec_50_undrwn_balance;
	private BigDecimal	psec_50_undrwn_crm;
	private BigDecimal	psec_50_undrwn_rwa;
	private BigDecimal	psec_50_under_ccf_amt;
	private BigDecimal	psec_100_undrwn_balance;
	private BigDecimal	psec_100_undrwn_crm;
	private BigDecimal	psec_100_undrwn_rwa;
	private BigDecimal	psec_100_under_ccf_amt;
	private BigDecimal	psec_150_undrwn_balance;
	private BigDecimal	psec_150_undrwn_crm;
	private BigDecimal	psec_150_undrwn_rwa;
	private BigDecimal	psec_150_under_ccf_amt;
	private BigDecimal	res_35_undrwn_balance;
	private BigDecimal	res_35_undrwn_crm;
	private BigDecimal	res_35_undrwn_rwa;
	private BigDecimal	res_35_under_ccf_amt;
	private BigDecimal	res_100_undrwn_balance;
	private BigDecimal	res_100_undrwn_crm;
	private BigDecimal	res_100_undrwn_rwa;
	private BigDecimal	res_100_under_ccf_amt;
	private BigDecimal	rrp_inde1_75_undrwn_balance;
	private BigDecimal	rrp_inde1_75_undrwn_crm;
	private BigDecimal	rrp_inde1_75_undrwn_rwa;
	private BigDecimal	rrp_inde1_75_under_ccf_amt;
	private BigDecimal	rrp_inde2_100_undrwn_balance;
	private BigDecimal	rrp_inde2_100_undrwn_crm;
	private BigDecimal	rrp_inde2_100_undrwn_rwa;
	private BigDecimal	rrp_inde2_100_under_ccf_amt;
	private BigDecimal	rrp_smlb_75_undrwn_balance;
	private BigDecimal	rrp_smlb_75_undrwn_crm;
	private BigDecimal	rrp_smlb_75_undrwn_rwa;
	private BigDecimal	rrp_smlb_75_under_ccf_amt;
	private BigDecimal	rrp_smlb2_85_undrwn_balance;
	private BigDecimal	rrp_smlb2_85_undrwn_crm;
	private BigDecimal	rrp_smlb2_85_undrwn_rwa;
	private BigDecimal	rrp_smlb2_85_under_ccf_amt;

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
	public BigDecimal getBnk_0_undrwn_balance() {
		return bnk_0_undrwn_balance;
	}
	public void setBnk_0_undrwn_balance(BigDecimal bnk_0_undrwn_balance) {
		this.bnk_0_undrwn_balance = bnk_0_undrwn_balance;
	}
	public BigDecimal getBnk_0_undrwn_crm() {
		return bnk_0_undrwn_crm;
	}
	public void setBnk_0_undrwn_crm(BigDecimal bnk_0_undrwn_crm) {
		this.bnk_0_undrwn_crm = bnk_0_undrwn_crm;
	}
	public BigDecimal getBnk_0_undrwn_rwa() {
		return bnk_0_undrwn_rwa;
	}
	public void setBnk_0_undrwn_rwa(BigDecimal bnk_0_undrwn_rwa) {
		this.bnk_0_undrwn_rwa = bnk_0_undrwn_rwa;
	}
	public BigDecimal getBnk_0_under_ccf_amt() {
		return bnk_0_under_ccf_amt;
	}
	public void setBnk_0_under_ccf_amt(BigDecimal bnk_0_under_ccf_amt) {
		this.bnk_0_under_ccf_amt = bnk_0_under_ccf_amt;
	}
	public BigDecimal getBnk_20_undrwn_balance() {
		return bnk_20_undrwn_balance;
	}
	public void setBnk_20_undrwn_balance(BigDecimal bnk_20_undrwn_balance) {
		this.bnk_20_undrwn_balance = bnk_20_undrwn_balance;
	}
	public BigDecimal getBnk_20_undrwn_crm() {
		return bnk_20_undrwn_crm;
	}
	public void setBnk_20_undrwn_crm(BigDecimal bnk_20_undrwn_crm) {
		this.bnk_20_undrwn_crm = bnk_20_undrwn_crm;
	}
	public BigDecimal getBnk_20_undrwn_rwa() {
		return bnk_20_undrwn_rwa;
	}
	public void setBnk_20_undrwn_rwa(BigDecimal bnk_20_undrwn_rwa) {
		this.bnk_20_undrwn_rwa = bnk_20_undrwn_rwa;
	}
	public BigDecimal getBnk_20_under_ccf_amt() {
		return bnk_20_under_ccf_amt;
	}
	public void setBnk_20_under_ccf_amt(BigDecimal bnk_20_under_ccf_amt) {
		this.bnk_20_under_ccf_amt = bnk_20_under_ccf_amt;
	}
	public BigDecimal getBnk_50_undrwn_balance() {
		return bnk_50_undrwn_balance;
	}
	public void setBnk_50_undrwn_balance(BigDecimal bnk_50_undrwn_balance) {
		this.bnk_50_undrwn_balance = bnk_50_undrwn_balance;
	}
	public BigDecimal getBnk_50_undrwn_crm() {
		return bnk_50_undrwn_crm;
	}
	public void setBnk_50_undrwn_crm(BigDecimal bnk_50_undrwn_crm) {
		this.bnk_50_undrwn_crm = bnk_50_undrwn_crm;
	}
	public BigDecimal getBnk_50_undrwn_rwa() {
		return bnk_50_undrwn_rwa;
	}
	public void setBnk_50_undrwn_rwa(BigDecimal bnk_50_undrwn_rwa) {
		this.bnk_50_undrwn_rwa = bnk_50_undrwn_rwa;
	}
	public BigDecimal getBnk_50_under_ccf_amt() {
		return bnk_50_under_ccf_amt;
	}
	public void setBnk_50_under_ccf_amt(BigDecimal bnk_50_under_ccf_amt) {
		this.bnk_50_under_ccf_amt = bnk_50_under_ccf_amt;
	}
	public BigDecimal getBnk_100_undrwn_balance() {
		return bnk_100_undrwn_balance;
	}
	public void setBnk_100_undrwn_balance(BigDecimal bnk_100_undrwn_balance) {
		this.bnk_100_undrwn_balance = bnk_100_undrwn_balance;
	}
	public BigDecimal getBnk_100_undrwn_crm() {
		return bnk_100_undrwn_crm;
	}
	public void setBnk_100_undrwn_crm(BigDecimal bnk_100_undrwn_crm) {
		this.bnk_100_undrwn_crm = bnk_100_undrwn_crm;
	}
	public BigDecimal getBnk_100_undrwn_rwa() {
		return bnk_100_undrwn_rwa;
	}
	public void setBnk_100_undrwn_rwa(BigDecimal bnk_100_undrwn_rwa) {
		this.bnk_100_undrwn_rwa = bnk_100_undrwn_rwa;
	}
	public BigDecimal getBnk_100_under_ccf_amt() {
		return bnk_100_under_ccf_amt;
	}
	public void setBnk_100_under_ccf_amt(BigDecimal bnk_100_under_ccf_amt) {
		this.bnk_100_under_ccf_amt = bnk_100_under_ccf_amt;
	}
	public BigDecimal getBnk_150_undrwn_balance() {
		return bnk_150_undrwn_balance;
	}
	public void setBnk_150_undrwn_balance(BigDecimal bnk_150_undrwn_balance) {
		this.bnk_150_undrwn_balance = bnk_150_undrwn_balance;
	}
	public BigDecimal getBnk_150_undrwn_crm() {
		return bnk_150_undrwn_crm;
	}
	public void setBnk_150_undrwn_crm(BigDecimal bnk_150_undrwn_crm) {
		this.bnk_150_undrwn_crm = bnk_150_undrwn_crm;
	}
	public BigDecimal getBnk_150_undrwn_rwa() {
		return bnk_150_undrwn_rwa;
	}
	public void setBnk_150_undrwn_rwa(BigDecimal bnk_150_undrwn_rwa) {
		this.bnk_150_undrwn_rwa = bnk_150_undrwn_rwa;
	}
	public BigDecimal getBnk_150_under_ccf_amt() {
		return bnk_150_under_ccf_amt;
	}
	public void setBnk_150_under_ccf_amt(BigDecimal bnk_150_under_ccf_amt) {
		this.bnk_150_under_ccf_amt = bnk_150_under_ccf_amt;
	}
	public BigDecimal getCbs1_0_undrwn_balance() {
		return cbs1_0_undrwn_balance;
	}
	public void setCbs1_0_undrwn_balance(BigDecimal cbs1_0_undrwn_balance) {
		this.cbs1_0_undrwn_balance = cbs1_0_undrwn_balance;
	}
	public BigDecimal getCbs1_0_undrwn_crm() {
		return cbs1_0_undrwn_crm;
	}
	public void setCbs1_0_undrwn_crm(BigDecimal cbs1_0_undrwn_crm) {
		this.cbs1_0_undrwn_crm = cbs1_0_undrwn_crm;
	}
	public BigDecimal getCbs1_0_undrwn_rwa() {
		return cbs1_0_undrwn_rwa;
	}
	public void setCbs1_0_undrwn_rwa(BigDecimal cbs1_0_undrwn_rwa) {
		this.cbs1_0_undrwn_rwa = cbs1_0_undrwn_rwa;
	}
	public BigDecimal getCbs1_0_under_ccf_amt() {
		return cbs1_0_under_ccf_amt;
	}
	public void setCbs1_0_under_ccf_amt(BigDecimal cbs1_0_under_ccf_amt) {
		this.cbs1_0_under_ccf_amt = cbs1_0_under_ccf_amt;
	}
	public BigDecimal getCbs2_20_undrwn_balance() {
		return cbs2_20_undrwn_balance;
	}
	public void setCbs2_20_undrwn_balance(BigDecimal cbs2_20_undrwn_balance) {
		this.cbs2_20_undrwn_balance = cbs2_20_undrwn_balance;
	}
	public BigDecimal getCbs2_20_undrwn_crm() {
		return cbs2_20_undrwn_crm;
	}
	public void setCbs2_20_undrwn_crm(BigDecimal cbs2_20_undrwn_crm) {
		this.cbs2_20_undrwn_crm = cbs2_20_undrwn_crm;
	}
	public BigDecimal getCbs2_20_undrwn_rwa() {
		return cbs2_20_undrwn_rwa;
	}
	public void setCbs2_20_undrwn_rwa(BigDecimal cbs2_20_undrwn_rwa) {
		this.cbs2_20_undrwn_rwa = cbs2_20_undrwn_rwa;
	}
	public BigDecimal getCbs2_20_under_ccf_amt() {
		return cbs2_20_under_ccf_amt;
	}
	public void setCbs2_20_under_ccf_amt(BigDecimal cbs2_20_under_ccf_amt) {
		this.cbs2_20_under_ccf_amt = cbs2_20_under_ccf_amt;
	}
	public BigDecimal getCbs3_20_undrwn_balance() {
		return cbs3_20_undrwn_balance;
	}
	public void setCbs3_20_undrwn_balance(BigDecimal cbs3_20_undrwn_balance) {
		this.cbs3_20_undrwn_balance = cbs3_20_undrwn_balance;
	}
	public BigDecimal getCbs3_20_undrwn_crm() {
		return cbs3_20_undrwn_crm;
	}
	public void setCbs3_20_undrwn_crm(BigDecimal cbs3_20_undrwn_crm) {
		this.cbs3_20_undrwn_crm = cbs3_20_undrwn_crm;
	}
	public BigDecimal getCbs3_20_undrwn_rwa() {
		return cbs3_20_undrwn_rwa;
	}
	public void setCbs3_20_undrwn_rwa(BigDecimal cbs3_20_undrwn_rwa) {
		this.cbs3_20_undrwn_rwa = cbs3_20_undrwn_rwa;
	}
	public BigDecimal getCbs3_20_under_ccf_amt() {
		return cbs3_20_under_ccf_amt;
	}
	public void setCbs3_20_under_ccf_amt(BigDecimal cbs3_20_under_ccf_amt) {
		this.cbs3_20_under_ccf_amt = cbs3_20_under_ccf_amt;
	}
	public BigDecimal getCbs4_0_undrwn_balance() {
		return cbs4_0_undrwn_balance;
	}
	public void setCbs4_0_undrwn_balance(BigDecimal cbs4_0_undrwn_balance) {
		this.cbs4_0_undrwn_balance = cbs4_0_undrwn_balance;
	}
	public BigDecimal getCbs4_0_undrwn_crm() {
		return cbs4_0_undrwn_crm;
	}
	public void setCbs4_0_undrwn_crm(BigDecimal cbs4_0_undrwn_crm) {
		this.cbs4_0_undrwn_crm = cbs4_0_undrwn_crm;
	}
	public BigDecimal getCbs4_0_undrwn_rwa() {
		return cbs4_0_undrwn_rwa;
	}
	public void setCbs4_0_undrwn_rwa(BigDecimal cbs4_0_undrwn_rwa) {
		this.cbs4_0_undrwn_rwa = cbs4_0_undrwn_rwa;
	}
	public BigDecimal getCbs4_0_under_ccf_amt() {
		return cbs4_0_under_ccf_amt;
	}
	public void setCbs4_0_under_ccf_amt(BigDecimal cbs4_0_under_ccf_amt) {
		this.cbs4_0_under_ccf_amt = cbs4_0_under_ccf_amt;
	}
	public BigDecimal getCbs4_20_undrwn_balance() {
		return cbs4_20_undrwn_balance;
	}
	public void setCbs4_20_undrwn_balance(BigDecimal cbs4_20_undrwn_balance) {
		this.cbs4_20_undrwn_balance = cbs4_20_undrwn_balance;
	}
	public BigDecimal getCbs4_20_undrwn_crm() {
		return cbs4_20_undrwn_crm;
	}
	public void setCbs4_20_undrwn_crm(BigDecimal cbs4_20_undrwn_crm) {
		this.cbs4_20_undrwn_crm = cbs4_20_undrwn_crm;
	}
	public BigDecimal getCbs4_20_undrwn_rwa() {
		return cbs4_20_undrwn_rwa;
	}
	public void setCbs4_20_undrwn_rwa(BigDecimal cbs4_20_undrwn_rwa) {
		this.cbs4_20_undrwn_rwa = cbs4_20_undrwn_rwa;
	}
	public BigDecimal getCbs4_20_under_ccf_amt() {
		return cbs4_20_under_ccf_amt;
	}
	public void setCbs4_20_under_ccf_amt(BigDecimal cbs4_20_under_ccf_amt) {
		this.cbs4_20_under_ccf_amt = cbs4_20_under_ccf_amt;
	}
	public BigDecimal getCbs4_50_undrwn_balance() {
		return cbs4_50_undrwn_balance;
	}
	public void setCbs4_50_undrwn_balance(BigDecimal cbs4_50_undrwn_balance) {
		this.cbs4_50_undrwn_balance = cbs4_50_undrwn_balance;
	}
	public BigDecimal getCbs4_50_undrwn_crm() {
		return cbs4_50_undrwn_crm;
	}
	public void setCbs4_50_undrwn_crm(BigDecimal cbs4_50_undrwn_crm) {
		this.cbs4_50_undrwn_crm = cbs4_50_undrwn_crm;
	}
	public BigDecimal getCbs4_50_undrwn_rwa() {
		return cbs4_50_undrwn_rwa;
	}
	public void setCbs4_50_undrwn_rwa(BigDecimal cbs4_50_undrwn_rwa) {
		this.cbs4_50_undrwn_rwa = cbs4_50_undrwn_rwa;
	}
	public BigDecimal getCbs4_50_under_ccf_amt() {
		return cbs4_50_under_ccf_amt;
	}
	public void setCbs4_50_under_ccf_amt(BigDecimal cbs4_50_under_ccf_amt) {
		this.cbs4_50_under_ccf_amt = cbs4_50_under_ccf_amt;
	}
	public BigDecimal getCbs4_100_undrwn_balance() {
		return cbs4_100_undrwn_balance;
	}
	public void setCbs4_100_undrwn_balance(BigDecimal cbs4_100_undrwn_balance) {
		this.cbs4_100_undrwn_balance = cbs4_100_undrwn_balance;
	}
	public BigDecimal getCbs4_100_undrwn_crm() {
		return cbs4_100_undrwn_crm;
	}
	public void setCbs4_100_undrwn_crm(BigDecimal cbs4_100_undrwn_crm) {
		this.cbs4_100_undrwn_crm = cbs4_100_undrwn_crm;
	}
	public BigDecimal getCbs4_100_undrwn_rwa() {
		return cbs4_100_undrwn_rwa;
	}
	public void setCbs4_100_undrwn_rwa(BigDecimal cbs4_100_undrwn_rwa) {
		this.cbs4_100_undrwn_rwa = cbs4_100_undrwn_rwa;
	}
	public BigDecimal getCbs4_100_under_ccf_amt() {
		return cbs4_100_under_ccf_amt;
	}
	public void setCbs4_100_under_ccf_amt(BigDecimal cbs4_100_under_ccf_amt) {
		this.cbs4_100_under_ccf_amt = cbs4_100_under_ccf_amt;
	}
	public BigDecimal getCbs4_150_undrwn_balance() {
		return cbs4_150_undrwn_balance;
	}
	public void setCbs4_150_undrwn_balance(BigDecimal cbs4_150_undrwn_balance) {
		this.cbs4_150_undrwn_balance = cbs4_150_undrwn_balance;
	}
	public BigDecimal getCbs4_150_undrwn_crm() {
		return cbs4_150_undrwn_crm;
	}
	public void setCbs4_150_undrwn_crm(BigDecimal cbs4_150_undrwn_crm) {
		this.cbs4_150_undrwn_crm = cbs4_150_undrwn_crm;
	}
	public BigDecimal getCbs4_150_undrwn_rwa() {
		return cbs4_150_undrwn_rwa;
	}
	public void setCbs4_150_undrwn_rwa(BigDecimal cbs4_150_undrwn_rwa) {
		this.cbs4_150_undrwn_rwa = cbs4_150_undrwn_rwa;
	}
	public BigDecimal getCbs4_150_under_ccf_amt() {
		return cbs4_150_under_ccf_amt;
	}
	public void setCbs4_150_under_ccf_amt(BigDecimal cbs4_150_under_ccf_amt) {
		this.cbs4_150_under_ccf_amt = cbs4_150_under_ccf_amt;
	}
	public BigDecimal getCre_0_undrwn_balance() {
		return cre_0_undrwn_balance;
	}
	public void setCre_0_undrwn_balance(BigDecimal cre_0_undrwn_balance) {
		this.cre_0_undrwn_balance = cre_0_undrwn_balance;
	}
	public BigDecimal getCre_0_undrwn_crm() {
		return cre_0_undrwn_crm;
	}
	public void setCre_0_undrwn_crm(BigDecimal cre_0_undrwn_crm) {
		this.cre_0_undrwn_crm = cre_0_undrwn_crm;
	}
	public BigDecimal getCre_0_undrwn_rwa() {
		return cre_0_undrwn_rwa;
	}
	public void setCre_0_undrwn_rwa(BigDecimal cre_0_undrwn_rwa) {
		this.cre_0_undrwn_rwa = cre_0_undrwn_rwa;
	}
	public BigDecimal getCre_0_under_ccf_amt() {
		return cre_0_under_ccf_amt;
	}
	public void setCre_0_under_ccf_amt(BigDecimal cre_0_under_ccf_amt) {
		this.cre_0_under_ccf_amt = cre_0_under_ccf_amt;
	}
	public BigDecimal getCre_20_undrwn_balance() {
		return cre_20_undrwn_balance;
	}
	public void setCre_20_undrwn_balance(BigDecimal cre_20_undrwn_balance) {
		this.cre_20_undrwn_balance = cre_20_undrwn_balance;
	}
	public BigDecimal getCre_20_undrwn_crm() {
		return cre_20_undrwn_crm;
	}
	public void setCre_20_undrwn_crm(BigDecimal cre_20_undrwn_crm) {
		this.cre_20_undrwn_crm = cre_20_undrwn_crm;
	}
	public BigDecimal getCre_20_undrwn_rwa() {
		return cre_20_undrwn_rwa;
	}
	public void setCre_20_undrwn_rwa(BigDecimal cre_20_undrwn_rwa) {
		this.cre_20_undrwn_rwa = cre_20_undrwn_rwa;
	}
	public BigDecimal getCre_20_under_ccf_amt() {
		return cre_20_under_ccf_amt;
	}
	public void setCre_20_under_ccf_amt(BigDecimal cre_20_under_ccf_amt) {
		this.cre_20_under_ccf_amt = cre_20_under_ccf_amt;
	}
	public BigDecimal getCre_50_undrwn_balance() {
		return cre_50_undrwn_balance;
	}
	public void setCre_50_undrwn_balance(BigDecimal cre_50_undrwn_balance) {
		this.cre_50_undrwn_balance = cre_50_undrwn_balance;
	}
	public BigDecimal getCre_50_undrwn_crm() {
		return cre_50_undrwn_crm;
	}
	public void setCre_50_undrwn_crm(BigDecimal cre_50_undrwn_crm) {
		this.cre_50_undrwn_crm = cre_50_undrwn_crm;
	}
	public BigDecimal getCre_50_undrwn_rwa() {
		return cre_50_undrwn_rwa;
	}
	public void setCre_50_undrwn_rwa(BigDecimal cre_50_undrwn_rwa) {
		this.cre_50_undrwn_rwa = cre_50_undrwn_rwa;
	}
	public BigDecimal getCre_50_under_ccf_amt() {
		return cre_50_under_ccf_amt;
	}
	public void setCre_50_under_ccf_amt(BigDecimal cre_50_under_ccf_amt) {
		this.cre_50_under_ccf_amt = cre_50_under_ccf_amt;
	}
	public BigDecimal getCre_100_undrwn_balance() {
		return cre_100_undrwn_balance;
	}
	public void setCre_100_undrwn_balance(BigDecimal cre_100_undrwn_balance) {
		this.cre_100_undrwn_balance = cre_100_undrwn_balance;
	}
	public BigDecimal getCre_100_undrwn_crm() {
		return cre_100_undrwn_crm;
	}
	public void setCre_100_undrwn_crm(BigDecimal cre_100_undrwn_crm) {
		this.cre_100_undrwn_crm = cre_100_undrwn_crm;
	}
	public BigDecimal getCre_100_undrwn_rwa() {
		return cre_100_undrwn_rwa;
	}
	public void setCre_100_undrwn_rwa(BigDecimal cre_100_undrwn_rwa) {
		this.cre_100_undrwn_rwa = cre_100_undrwn_rwa;
	}
	public BigDecimal getCre_100_under_ccf_amt() {
		return cre_100_under_ccf_amt;
	}
	public void setCre_100_under_ccf_amt(BigDecimal cre_100_under_ccf_amt) {
		this.cre_100_under_ccf_amt = cre_100_under_ccf_amt;
	}
	public BigDecimal getCre_150_undrwn_balance() {
		return cre_150_undrwn_balance;
	}
	public void setCre_150_undrwn_balance(BigDecimal cre_150_undrwn_balance) {
		this.cre_150_undrwn_balance = cre_150_undrwn_balance;
	}
	public BigDecimal getCre_150_undrwn_crm() {
		return cre_150_undrwn_crm;
	}
	public void setCre_150_undrwn_crm(BigDecimal cre_150_undrwn_crm) {
		this.cre_150_undrwn_crm = cre_150_undrwn_crm;
	}
	public BigDecimal getCre_150_undrwn_rwa() {
		return cre_150_undrwn_rwa;
	}
	public void setCre_150_undrwn_rwa(BigDecimal cre_150_undrwn_rwa) {
		this.cre_150_undrwn_rwa = cre_150_undrwn_rwa;
	}
	public BigDecimal getCre_150_under_ccf_amt() {
		return cre_150_under_ccf_amt;
	}
	public void setCre_150_under_ccf_amt(BigDecimal cre_150_under_ccf_amt) {
		this.cre_150_under_ccf_amt = cre_150_under_ccf_amt;
	}
	public BigDecimal getCrp_0_undrwn_balance() {
		return crp_0_undrwn_balance;
	}
	public void setCrp_0_undrwn_balance(BigDecimal crp_0_undrwn_balance) {
		this.crp_0_undrwn_balance = crp_0_undrwn_balance;
	}
	public BigDecimal getCrp_0_undrwn_crm() {
		return crp_0_undrwn_crm;
	}
	public void setCrp_0_undrwn_crm(BigDecimal crp_0_undrwn_crm) {
		this.crp_0_undrwn_crm = crp_0_undrwn_crm;
	}
	public BigDecimal getCrp_0_undrwn_rwa() {
		return crp_0_undrwn_rwa;
	}
	public void setCrp_0_undrwn_rwa(BigDecimal crp_0_undrwn_rwa) {
		this.crp_0_undrwn_rwa = crp_0_undrwn_rwa;
	}
	public BigDecimal getCrp_0_under_ccf_amt() {
		return crp_0_under_ccf_amt;
	}
	public void setCrp_0_under_ccf_amt(BigDecimal crp_0_under_ccf_amt) {
		this.crp_0_under_ccf_amt = crp_0_under_ccf_amt;
	}
	public BigDecimal getCrp_20_undrwn_balance() {
		return crp_20_undrwn_balance;
	}
	public void setCrp_20_undrwn_balance(BigDecimal crp_20_undrwn_balance) {
		this.crp_20_undrwn_balance = crp_20_undrwn_balance;
	}
	public BigDecimal getCrp_20_undrwn_crm() {
		return crp_20_undrwn_crm;
	}
	public void setCrp_20_undrwn_crm(BigDecimal crp_20_undrwn_crm) {
		this.crp_20_undrwn_crm = crp_20_undrwn_crm;
	}
	public BigDecimal getCrp_20_undrwn_rwa() {
		return crp_20_undrwn_rwa;
	}
	public void setCrp_20_undrwn_rwa(BigDecimal crp_20_undrwn_rwa) {
		this.crp_20_undrwn_rwa = crp_20_undrwn_rwa;
	}
	public BigDecimal getCrp_20_under_ccf_amt() {
		return crp_20_under_ccf_amt;
	}
	public void setCrp_20_under_ccf_amt(BigDecimal crp_20_under_ccf_amt) {
		this.crp_20_under_ccf_amt = crp_20_under_ccf_amt;
	}
	public BigDecimal getCrp_50_undrwn_balance() {
		return crp_50_undrwn_balance;
	}
	public void setCrp_50_undrwn_balance(BigDecimal crp_50_undrwn_balance) {
		this.crp_50_undrwn_balance = crp_50_undrwn_balance;
	}
	public BigDecimal getCrp_50_undrwn_crm() {
		return crp_50_undrwn_crm;
	}
	public void setCrp_50_undrwn_crm(BigDecimal crp_50_undrwn_crm) {
		this.crp_50_undrwn_crm = crp_50_undrwn_crm;
	}
	public BigDecimal getCrp_50_undrwn_rwa() {
		return crp_50_undrwn_rwa;
	}
	public void setCrp_50_undrwn_rwa(BigDecimal crp_50_undrwn_rwa) {
		this.crp_50_undrwn_rwa = crp_50_undrwn_rwa;
	}
	public BigDecimal getCrp_50_under_ccf_amt() {
		return crp_50_under_ccf_amt;
	}
	public void setCrp_50_under_ccf_amt(BigDecimal crp_50_under_ccf_amt) {
		this.crp_50_under_ccf_amt = crp_50_under_ccf_amt;
	}
	public BigDecimal getCrp_100_undrwn_balance() {
		return crp_100_undrwn_balance;
	}
	public void setCrp_100_undrwn_balance(BigDecimal crp_100_undrwn_balance) {
		this.crp_100_undrwn_balance = crp_100_undrwn_balance;
	}
	public BigDecimal getCrp_100_undrwn_crm() {
		return crp_100_undrwn_crm;
	}
	public void setCrp_100_undrwn_crm(BigDecimal crp_100_undrwn_crm) {
		this.crp_100_undrwn_crm = crp_100_undrwn_crm;
	}
	public BigDecimal getCrp_100_undrwn_rwa() {
		return crp_100_undrwn_rwa;
	}
	public void setCrp_100_undrwn_rwa(BigDecimal crp_100_undrwn_rwa) {
		this.crp_100_undrwn_rwa = crp_100_undrwn_rwa;
	}
	public BigDecimal getCrp_100_under_ccf_amt() {
		return crp_100_under_ccf_amt;
	}
	public void setCrp_100_under_ccf_amt(BigDecimal crp_100_under_ccf_amt) {
		this.crp_100_under_ccf_amt = crp_100_under_ccf_amt;
	}
	public BigDecimal getCrp_150_undrwn_balance() {
		return crp_150_undrwn_balance;
	}
	public void setCrp_150_undrwn_balance(BigDecimal crp_150_undrwn_balance) {
		this.crp_150_undrwn_balance = crp_150_undrwn_balance;
	}
	public BigDecimal getCrp_150_undrwn_crm() {
		return crp_150_undrwn_crm;
	}
	public void setCrp_150_undrwn_crm(BigDecimal crp_150_undrwn_crm) {
		this.crp_150_undrwn_crm = crp_150_undrwn_crm;
	}
	public BigDecimal getCrp_150_undrwn_rwa() {
		return crp_150_undrwn_rwa;
	}
	public void setCrp_150_undrwn_rwa(BigDecimal crp_150_undrwn_rwa) {
		this.crp_150_undrwn_rwa = crp_150_undrwn_rwa;
	}
	public BigDecimal getCrp_150_under_ccf_amt() {
		return crp_150_under_ccf_amt;
	}
	public void setCrp_150_under_ccf_amt(BigDecimal crp_150_under_ccf_amt) {
		this.crp_150_under_ccf_amt = crp_150_under_ccf_amt;
	}
	public BigDecimal getHni_100_undrwn_balance() {
		return hni_100_undrwn_balance;
	}
	public void setHni_100_undrwn_balance(BigDecimal hni_100_undrwn_balance) {
		this.hni_100_undrwn_balance = hni_100_undrwn_balance;
	}
	public BigDecimal getHni_100_undrwn_crm() {
		return hni_100_undrwn_crm;
	}
	public void setHni_100_undrwn_crm(BigDecimal hni_100_undrwn_crm) {
		this.hni_100_undrwn_crm = hni_100_undrwn_crm;
	}
	public BigDecimal getHni_100_undrwn_rwa() {
		return hni_100_undrwn_rwa;
	}
	public void setHni_100_undrwn_rwa(BigDecimal hni_100_undrwn_rwa) {
		this.hni_100_undrwn_rwa = hni_100_undrwn_rwa;
	}
	public BigDecimal getHni_100_under_ccf_amt() {
		return hni_100_under_ccf_amt;
	}
	public void setHni_100_under_ccf_amt(BigDecimal hni_100_under_ccf_amt) {
		this.hni_100_under_ccf_amt = hni_100_under_ccf_amt;
	}
	public BigDecimal getPdl_100_undrwn_balance() {
		return pdl_100_undrwn_balance;
	}
	public void setPdl_100_undrwn_balance(BigDecimal pdl_100_undrwn_balance) {
		this.pdl_100_undrwn_balance = pdl_100_undrwn_balance;
	}
	public BigDecimal getPdl_100_undrwn_crm() {
		return pdl_100_undrwn_crm;
	}
	public void setPdl_100_undrwn_crm(BigDecimal pdl_100_undrwn_crm) {
		this.pdl_100_undrwn_crm = pdl_100_undrwn_crm;
	}
	public BigDecimal getPdl_100_undrwn_rwa() {
		return pdl_100_undrwn_rwa;
	}
	public void setPdl_100_undrwn_rwa(BigDecimal pdl_100_undrwn_rwa) {
		this.pdl_100_undrwn_rwa = pdl_100_undrwn_rwa;
	}
	public BigDecimal getPdl_100_under_ccf_amt() {
		return pdl_100_under_ccf_amt;
	}
	public void setPdl_100_under_ccf_amt(BigDecimal pdl_100_under_ccf_amt) {
		this.pdl_100_under_ccf_amt = pdl_100_under_ccf_amt;
	}
	public BigDecimal getPdl_150_undrwn_balance() {
		return pdl_150_undrwn_balance;
	}
	public void setPdl_150_undrwn_balance(BigDecimal pdl_150_undrwn_balance) {
		this.pdl_150_undrwn_balance = pdl_150_undrwn_balance;
	}
	public BigDecimal getPdl_150_undrwn_crm() {
		return pdl_150_undrwn_crm;
	}
	public void setPdl_150_undrwn_crm(BigDecimal pdl_150_undrwn_crm) {
		this.pdl_150_undrwn_crm = pdl_150_undrwn_crm;
	}
	public BigDecimal getPdl_150_undrwn_rwa() {
		return pdl_150_undrwn_rwa;
	}
	public void setPdl_150_undrwn_rwa(BigDecimal pdl_150_undrwn_rwa) {
		this.pdl_150_undrwn_rwa = pdl_150_undrwn_rwa;
	}
	public BigDecimal getPdl_150_under_ccf_amt() {
		return pdl_150_under_ccf_amt;
	}
	public void setPdl_150_under_ccf_amt(BigDecimal pdl_150_under_ccf_amt) {
		this.pdl_150_under_ccf_amt = pdl_150_under_ccf_amt;
	}
	public BigDecimal getPsec_0_undrwn_balance() {
		return psec_0_undrwn_balance;
	}
	public void setPsec_0_undrwn_balance(BigDecimal psec_0_undrwn_balance) {
		this.psec_0_undrwn_balance = psec_0_undrwn_balance;
	}
	public BigDecimal getPsec_0_undrwn_crm() {
		return psec_0_undrwn_crm;
	}
	public void setPsec_0_undrwn_crm(BigDecimal psec_0_undrwn_crm) {
		this.psec_0_undrwn_crm = psec_0_undrwn_crm;
	}
	public BigDecimal getPsec_0_undrwn_rwa() {
		return psec_0_undrwn_rwa;
	}
	public void setPsec_0_undrwn_rwa(BigDecimal psec_0_undrwn_rwa) {
		this.psec_0_undrwn_rwa = psec_0_undrwn_rwa;
	}
	public BigDecimal getPsec_0_under_ccf_amt() {
		return psec_0_under_ccf_amt;
	}
	public void setPsec_0_under_ccf_amt(BigDecimal psec_0_under_ccf_amt) {
		this.psec_0_under_ccf_amt = psec_0_under_ccf_amt;
	}
	public BigDecimal getPsec_20_undrwn_balance() {
		return psec_20_undrwn_balance;
	}
	public void setPsec_20_undrwn_balance(BigDecimal psec_20_undrwn_balance) {
		this.psec_20_undrwn_balance = psec_20_undrwn_balance;
	}
	public BigDecimal getPsec_20_undrwn_crm() {
		return psec_20_undrwn_crm;
	}
	public void setPsec_20_undrwn_crm(BigDecimal psec_20_undrwn_crm) {
		this.psec_20_undrwn_crm = psec_20_undrwn_crm;
	}
	public BigDecimal getPsec_20_undrwn_rwa() {
		return psec_20_undrwn_rwa;
	}
	public void setPsec_20_undrwn_rwa(BigDecimal psec_20_undrwn_rwa) {
		this.psec_20_undrwn_rwa = psec_20_undrwn_rwa;
	}
	public BigDecimal getPsec_20_under_ccf_amt() {
		return psec_20_under_ccf_amt;
	}
	public void setPsec_20_under_ccf_amt(BigDecimal psec_20_under_ccf_amt) {
		this.psec_20_under_ccf_amt = psec_20_under_ccf_amt;
	}
	public BigDecimal getPsec_50_undrwn_balance() {
		return psec_50_undrwn_balance;
	}
	public void setPsec_50_undrwn_balance(BigDecimal psec_50_undrwn_balance) {
		this.psec_50_undrwn_balance = psec_50_undrwn_balance;
	}
	public BigDecimal getPsec_50_undrwn_crm() {
		return psec_50_undrwn_crm;
	}
	public void setPsec_50_undrwn_crm(BigDecimal psec_50_undrwn_crm) {
		this.psec_50_undrwn_crm = psec_50_undrwn_crm;
	}
	public BigDecimal getPsec_50_undrwn_rwa() {
		return psec_50_undrwn_rwa;
	}
	public void setPsec_50_undrwn_rwa(BigDecimal psec_50_undrwn_rwa) {
		this.psec_50_undrwn_rwa = psec_50_undrwn_rwa;
	}
	public BigDecimal getPsec_50_under_ccf_amt() {
		return psec_50_under_ccf_amt;
	}
	public void setPsec_50_under_ccf_amt(BigDecimal psec_50_under_ccf_amt) {
		this.psec_50_under_ccf_amt = psec_50_under_ccf_amt;
	}
	public BigDecimal getPsec_100_undrwn_balance() {
		return psec_100_undrwn_balance;
	}
	public void setPsec_100_undrwn_balance(BigDecimal psec_100_undrwn_balance) {
		this.psec_100_undrwn_balance = psec_100_undrwn_balance;
	}
	public BigDecimal getPsec_100_undrwn_crm() {
		return psec_100_undrwn_crm;
	}
	public void setPsec_100_undrwn_crm(BigDecimal psec_100_undrwn_crm) {
		this.psec_100_undrwn_crm = psec_100_undrwn_crm;
	}
	public BigDecimal getPsec_100_undrwn_rwa() {
		return psec_100_undrwn_rwa;
	}
	public void setPsec_100_undrwn_rwa(BigDecimal psec_100_undrwn_rwa) {
		this.psec_100_undrwn_rwa = psec_100_undrwn_rwa;
	}
	public BigDecimal getPsec_100_under_ccf_amt() {
		return psec_100_under_ccf_amt;
	}
	public void setPsec_100_under_ccf_amt(BigDecimal psec_100_under_ccf_amt) {
		this.psec_100_under_ccf_amt = psec_100_under_ccf_amt;
	}
	public BigDecimal getPsec_150_undrwn_balance() {
		return psec_150_undrwn_balance;
	}
	public void setPsec_150_undrwn_balance(BigDecimal psec_150_undrwn_balance) {
		this.psec_150_undrwn_balance = psec_150_undrwn_balance;
	}
	public BigDecimal getPsec_150_undrwn_crm() {
		return psec_150_undrwn_crm;
	}
	public void setPsec_150_undrwn_crm(BigDecimal psec_150_undrwn_crm) {
		this.psec_150_undrwn_crm = psec_150_undrwn_crm;
	}
	public BigDecimal getPsec_150_undrwn_rwa() {
		return psec_150_undrwn_rwa;
	}
	public void setPsec_150_undrwn_rwa(BigDecimal psec_150_undrwn_rwa) {
		this.psec_150_undrwn_rwa = psec_150_undrwn_rwa;
	}
	public BigDecimal getPsec_150_under_ccf_amt() {
		return psec_150_under_ccf_amt;
	}
	public void setPsec_150_under_ccf_amt(BigDecimal psec_150_under_ccf_amt) {
		this.psec_150_under_ccf_amt = psec_150_under_ccf_amt;
	}
	public BigDecimal getRes_35_undrwn_balance() {
		return res_35_undrwn_balance;
	}
	public void setRes_35_undrwn_balance(BigDecimal res_35_undrwn_balance) {
		this.res_35_undrwn_balance = res_35_undrwn_balance;
	}
	public BigDecimal getRes_35_undrwn_crm() {
		return res_35_undrwn_crm;
	}
	public void setRes_35_undrwn_crm(BigDecimal res_35_undrwn_crm) {
		this.res_35_undrwn_crm = res_35_undrwn_crm;
	}
	public BigDecimal getRes_35_undrwn_rwa() {
		return res_35_undrwn_rwa;
	}
	public void setRes_35_undrwn_rwa(BigDecimal res_35_undrwn_rwa) {
		this.res_35_undrwn_rwa = res_35_undrwn_rwa;
	}
	public BigDecimal getRes_35_under_ccf_amt() {
		return res_35_under_ccf_amt;
	}
	public void setRes_35_under_ccf_amt(BigDecimal res_35_under_ccf_amt) {
		this.res_35_under_ccf_amt = res_35_under_ccf_amt;
	}
	public BigDecimal getRes_100_undrwn_balance() {
		return res_100_undrwn_balance;
	}
	public void setRes_100_undrwn_balance(BigDecimal res_100_undrwn_balance) {
		this.res_100_undrwn_balance = res_100_undrwn_balance;
	}
	public BigDecimal getRes_100_undrwn_crm() {
		return res_100_undrwn_crm;
	}
	public void setRes_100_undrwn_crm(BigDecimal res_100_undrwn_crm) {
		this.res_100_undrwn_crm = res_100_undrwn_crm;
	}
	public BigDecimal getRes_100_undrwn_rwa() {
		return res_100_undrwn_rwa;
	}
	public void setRes_100_undrwn_rwa(BigDecimal res_100_undrwn_rwa) {
		this.res_100_undrwn_rwa = res_100_undrwn_rwa;
	}
	public BigDecimal getRes_100_under_ccf_amt() {
		return res_100_under_ccf_amt;
	}
	public void setRes_100_under_ccf_amt(BigDecimal res_100_under_ccf_amt) {
		this.res_100_under_ccf_amt = res_100_under_ccf_amt;
	}
	public BigDecimal getRrp_inde1_75_undrwn_balance() {
		return rrp_inde1_75_undrwn_balance;
	}
	public void setRrp_inde1_75_undrwn_balance(BigDecimal rrp_inde1_75_undrwn_balance) {
		this.rrp_inde1_75_undrwn_balance = rrp_inde1_75_undrwn_balance;
	}
	public BigDecimal getRrp_inde1_75_undrwn_crm() {
		return rrp_inde1_75_undrwn_crm;
	}
	public void setRrp_inde1_75_undrwn_crm(BigDecimal rrp_inde1_75_undrwn_crm) {
		this.rrp_inde1_75_undrwn_crm = rrp_inde1_75_undrwn_crm;
	}
	public BigDecimal getRrp_inde1_75_undrwn_rwa() {
		return rrp_inde1_75_undrwn_rwa;
	}
	public void setRrp_inde1_75_undrwn_rwa(BigDecimal rrp_inde1_75_undrwn_rwa) {
		this.rrp_inde1_75_undrwn_rwa = rrp_inde1_75_undrwn_rwa;
	}
	public BigDecimal getRrp_inde1_75_under_ccf_amt() {
		return rrp_inde1_75_under_ccf_amt;
	}
	public void setRrp_inde1_75_under_ccf_amt(BigDecimal rrp_inde1_75_under_ccf_amt) {
		this.rrp_inde1_75_under_ccf_amt = rrp_inde1_75_under_ccf_amt;
	}
	public BigDecimal getRrp_inde2_100_undrwn_balance() {
		return rrp_inde2_100_undrwn_balance;
	}
	public void setRrp_inde2_100_undrwn_balance(BigDecimal rrp_inde2_100_undrwn_balance) {
		this.rrp_inde2_100_undrwn_balance = rrp_inde2_100_undrwn_balance;
	}
	public BigDecimal getRrp_inde2_100_undrwn_crm() {
		return rrp_inde2_100_undrwn_crm;
	}
	public void setRrp_inde2_100_undrwn_crm(BigDecimal rrp_inde2_100_undrwn_crm) {
		this.rrp_inde2_100_undrwn_crm = rrp_inde2_100_undrwn_crm;
	}
	public BigDecimal getRrp_inde2_100_undrwn_rwa() {
		return rrp_inde2_100_undrwn_rwa;
	}
	public void setRrp_inde2_100_undrwn_rwa(BigDecimal rrp_inde2_100_undrwn_rwa) {
		this.rrp_inde2_100_undrwn_rwa = rrp_inde2_100_undrwn_rwa;
	}
	public BigDecimal getRrp_inde2_100_under_ccf_amt() {
		return rrp_inde2_100_under_ccf_amt;
	}
	public void setRrp_inde2_100_under_ccf_amt(BigDecimal rrp_inde2_100_under_ccf_amt) {
		this.rrp_inde2_100_under_ccf_amt = rrp_inde2_100_under_ccf_amt;
	}
	public BigDecimal getRrp_smlb_75_undrwn_balance() {
		return rrp_smlb_75_undrwn_balance;
	}
	public void setRrp_smlb_75_undrwn_balance(BigDecimal rrp_smlb_75_undrwn_balance) {
		this.rrp_smlb_75_undrwn_balance = rrp_smlb_75_undrwn_balance;
	}
	public BigDecimal getRrp_smlb_75_undrwn_crm() {
		return rrp_smlb_75_undrwn_crm;
	}
	public void setRrp_smlb_75_undrwn_crm(BigDecimal rrp_smlb_75_undrwn_crm) {
		this.rrp_smlb_75_undrwn_crm = rrp_smlb_75_undrwn_crm;
	}
	public BigDecimal getRrp_smlb_75_undrwn_rwa() {
		return rrp_smlb_75_undrwn_rwa;
	}
	public void setRrp_smlb_75_undrwn_rwa(BigDecimal rrp_smlb_75_undrwn_rwa) {
		this.rrp_smlb_75_undrwn_rwa = rrp_smlb_75_undrwn_rwa;
	}
	public BigDecimal getRrp_smlb_75_under_ccf_amt() {
		return rrp_smlb_75_under_ccf_amt;
	}
	public void setRrp_smlb_75_under_ccf_amt(BigDecimal rrp_smlb_75_under_ccf_amt) {
		this.rrp_smlb_75_under_ccf_amt = rrp_smlb_75_under_ccf_amt;
	}
	public BigDecimal getRrp_smlb2_85_undrwn_balance() {
		return rrp_smlb2_85_undrwn_balance;
	}
	public void setRrp_smlb2_85_undrwn_balance(BigDecimal rrp_smlb2_85_undrwn_balance) {
		this.rrp_smlb2_85_undrwn_balance = rrp_smlb2_85_undrwn_balance;
	}
	public BigDecimal getRrp_smlb2_85_undrwn_crm() {
		return rrp_smlb2_85_undrwn_crm;
	}
	public void setRrp_smlb2_85_undrwn_crm(BigDecimal rrp_smlb2_85_undrwn_crm) {
		this.rrp_smlb2_85_undrwn_crm = rrp_smlb2_85_undrwn_crm;
	}
	public BigDecimal getRrp_smlb2_85_undrwn_rwa() {
		return rrp_smlb2_85_undrwn_rwa;
	}
	public void setRrp_smlb2_85_undrwn_rwa(BigDecimal rrp_smlb2_85_undrwn_rwa) {
		this.rrp_smlb2_85_undrwn_rwa = rrp_smlb2_85_undrwn_rwa;
	}
	public BigDecimal getRrp_smlb2_85_under_ccf_amt() {
		return rrp_smlb2_85_under_ccf_amt;
	}
	public void setRrp_smlb2_85_under_ccf_amt(BigDecimal rrp_smlb2_85_under_ccf_amt) {
		this.rrp_smlb2_85_under_ccf_amt = rrp_smlb2_85_under_ccf_amt;
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
	public BRF95_NON_FUND_BASED_UNDRAWN_A() {
		super();
		// TODO Auto-generated constructor stub
	}
}
