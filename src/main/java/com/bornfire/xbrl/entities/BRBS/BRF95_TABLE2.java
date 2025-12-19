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
@Table(name="BRF95_TABLE2")

public class BRF95_TABLE2 {
	private BigDecimal	hni_0_undrawn_bal;
	private BigDecimal	hni_0_loan_undrwn_adj_crm;
	private BigDecimal	hni_0_loan_undrwn_rwa;
	private BigDecimal	hni_0_loan_under_ccf_amt;
	private BigDecimal	hni_20_undrawn_bal;
	private BigDecimal	hni_20_loan_undrwn_adj_crm;
	private BigDecimal	hni_20_loan_undrwn_rwa;
	private BigDecimal	hni_20_loan_under_ccf_amt;
	private BigDecimal	hni_50_undrawn_bal;
	private BigDecimal	hni_50_loan_undrwn_adj_crm;
	private BigDecimal	hni_50_loan_undrwn_rwa;
	private BigDecimal	hni_50_loan_under_ccf_amt;
	private BigDecimal	hni_150_undrawn_bal;
	private BigDecimal	hni_150_loan_undrwn_adj_crm;
	private BigDecimal	hni_150_loan_undrwn_rwa;
	private BigDecimal	hni_150_loan_under_ccf_amt;
	private BigDecimal	pdl_0_undrawn_bal;
	private BigDecimal	pdl_0_loan_undrwn_adj_crm;
	private BigDecimal	pdl_0_loan_undrwn_rwa;
	private BigDecimal	pdl_0_loan_under_ccf_amt;
	private BigDecimal	pdl_20_undrawn_bal;
	private BigDecimal	pdl_20_loan_undrwn_adj_crm;
	private BigDecimal	pdl_20_loan_undrwn_rwa;
	private BigDecimal	pdl_20_loan_under_ccf_amt;
	private BigDecimal	pdl_50_undrawn_bal;
	private BigDecimal	pdl_50_loan_undrwn_adj_crm;
	private BigDecimal	pdl_50_loan_undrwn_rwa;
	private BigDecimal	pdl_50_loan_under_ccf_amt;
	private BigDecimal	res_0_undrawn_bal;
	private BigDecimal	res_0_loan_undrwn_adj_crm;
	private BigDecimal	res_0_loan_undrwn_rwa;
	private BigDecimal	res_0_loan_under_ccf_amt;
	private BigDecimal	res_20_undrawn_bal;
	private BigDecimal	res_20_loan_undrwn_adj_crm;
	private BigDecimal	res_20_loan_undrwn_rwa;
	private BigDecimal	res_20_loan_under_ccf_amt;
	private BigDecimal	res_50_undrawn_bal;
	private BigDecimal	res_50_loan_undrwn_adj_crm;
	private BigDecimal	res_50_loan_undrwn_rwa;
	private BigDecimal	res_50_loan_under_ccf_amt;
	private BigDecimal	res_150_undrawn_bal;
	private BigDecimal	res_150_loan_undrwn_adj_crm;
	private BigDecimal	res_150_loan_undrwn_rwa;
	private BigDecimal	res_150_loan_under_ccf_amt;
	private BigDecimal	rrp_inde1_0_undrawn_bal;
	private BigDecimal	rrp_inde1_0_loan_undrwn_adj_crm;
	private BigDecimal	rrp_inde1_0_loan_undrwn_rwa;
	private BigDecimal	rrp_inde1_0_loan_under_ccf_amt;
	private BigDecimal	rrp_inde1_20_undrawn_bal;
	private BigDecimal	rrp_inde1_20_loan_undrwn_adj_crm;
	private BigDecimal	rrp_inde1_20_loan_undrwn_rwa;
	private BigDecimal	rrp_inde1_20_loan_under_ccf_amt;
	private BigDecimal	rrp_inde1_50_undrawn_bal;
	private BigDecimal	rrp_inde1_50_loan_undrwn_adj_crm;
	private BigDecimal	rrp_inde1_50_loan_undrwn_rwa;
	private BigDecimal	rrp_inde1_50_loan_under_ccf_amt;
	private BigDecimal	rrp_inde1_100_undrawn_bal;
	private BigDecimal	rrp_inde1_100_loan_undrwn_adj_crm;
	private BigDecimal	rrp_inde1_100_loan_undrwn_rwa;
	private BigDecimal	rrp_inde1_100_loan_under_ccf_amt;
	private BigDecimal	rrp_inde1_150_undrawn_bal;
	private BigDecimal	rrp_inde1_150_loan_undrwn_adj_crm;
	private BigDecimal	rrp_inde1_150_loan_undrwn_rwa;
	private BigDecimal	rrp_inde1_150_loan_under_ccf_amt;
	private BigDecimal	rrp_inde2_0_undrawn_bal;
	private BigDecimal	rrp_inde2_0_loan_undrwn_adj_crm;
	private BigDecimal	rrp_inde2_0_loan_undrwn_rwa;
	private BigDecimal	rrp_inde2_0_loan_under_ccf_amt;
	private BigDecimal	rrp_inde2_20_undrawn_bal;
	private BigDecimal	rrp_inde2_20_loan_undrwn_adj_crm;
	private BigDecimal	rrp_inde2_20_loan_undrwn_rwa;
	private BigDecimal	rrp_inde2_20_loan_under_ccf_amt;
	private BigDecimal	rrp_inde2_50_undrawn_bal;
	private BigDecimal	rrp_inde2_50_loan_undrwn_adj_crm;
	private BigDecimal	rrp_inde2_50_loan_undrwn_rwa;
	private BigDecimal	rrp_inde2_50_loan_under_ccf_amt;
	private BigDecimal	rrp_inde2_150_undrawn_bal;
	private BigDecimal	rrp_inde2_150_loan_undrwn_adj_crm;
	private BigDecimal	rrp_inde2_150_loan_undrwn_rwa;
	private BigDecimal	rrp_inde2_150_loan_under_ccf_amt;
	private BigDecimal	rrp_smlb_0_undrawn_bal;
	private BigDecimal	rrp_smlb_0_loan_undrwn_adj_crm;
	private BigDecimal	rrp_smlb_0_loan_undrwn_rwa;
	private BigDecimal	rrp_smlb_0_loan_under_ccf_amt;
	private BigDecimal	rrp_smlb_20_undrawn_bal;
	private BigDecimal	rrp_smlb_20_loan_undrwn_adj_crm;
	private BigDecimal	rrp_smlb_20_loan_undrwn_rwa;
	private BigDecimal	rrp_smlb_20_loan_under_ccf_amt;
	private BigDecimal	rrp_smlb_50_undrawn_bal;
	private BigDecimal	rrp_smlb_50_loan_undrwn_adj_crm;
	private BigDecimal	rrp_smlb_50_loan_undrwn_rwa;
	private BigDecimal	rrp_smlb_50_loan_under_ccf_amt;
	private BigDecimal	rrp_smlb_100_undrawn_bal;
	private BigDecimal	rrp_smlb_100_loan_undrwn_adj_crm;
	private BigDecimal	rrp_smlb_100_loan_undrwn_rwa;
	private BigDecimal	rrp_smlb_100_loan_under_ccf_amt;
	private BigDecimal	rrp_smlb_150_undrawn_bal;
	private BigDecimal	rrp_smlb_150_loan_undrwn_adj_crm;
	private BigDecimal	rrp_smlb_150_loan_undrwn_rwa;
	private BigDecimal	rrp_smlb_150_loan_under_ccf_amt;
	private BigDecimal	rrp_smlb2_0_undrawn_bal;
	private BigDecimal	rrp_smlb2_0_loan_undrwn_adj_crm;
	private BigDecimal	rrp_smlb2_0_loan_undrwn_rwa;
	private BigDecimal	rrp_smlb2_0_loan_under_ccf_amt;
	private BigDecimal	rrp_smlb2_20_undrawn_bal;
	private BigDecimal	rrp_smlb2_20_loan_undrwn_adj_crm;
	private BigDecimal	rrp_smlb2_20_loan_undrwn_rwa;
	private BigDecimal	rrp_smlb2_20_loan_under_ccf_amt;
	private BigDecimal	rrp_smlb2_50_undrawn_bal;
	private BigDecimal	rrp_smlb2_50_loan_undrwn_adj_crm;
	private BigDecimal	rrp_smlb2_50_loan_undrwn_rwa;
	private BigDecimal	rrp_smlb2_50_loan_under_ccf_amt;
	private BigDecimal	rrp_smlb2_100_undrawn_bal;
	private BigDecimal	rrp_smlb2_100_loan_undrwn_adj_crm;
	private BigDecimal	rrp_smlb2_100_loan_undrwn_rwa;
	private BigDecimal	rrp_smlb2_100_loan_under_ccf_amt;
	private BigDecimal	rrp_smlb2_150_undrawn_bal;
	private BigDecimal	rrp_smlb2_150_loan_undrwn_adj_crm;
	private BigDecimal	rrp_smlb2_150_loan_undrwn_rwa;
	private BigDecimal	rrp_smlb2_150_loan_under_ccf_amt;
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
	public BigDecimal getHni_0_undrawn_bal() {
		return hni_0_undrawn_bal;
	}
	public void setHni_0_undrawn_bal(BigDecimal hni_0_undrawn_bal) {
		this.hni_0_undrawn_bal = hni_0_undrawn_bal;
	}
	public BigDecimal getHni_0_loan_undrwn_adj_crm() {
		return hni_0_loan_undrwn_adj_crm;
	}
	public void setHni_0_loan_undrwn_adj_crm(BigDecimal hni_0_loan_undrwn_adj_crm) {
		this.hni_0_loan_undrwn_adj_crm = hni_0_loan_undrwn_adj_crm;
	}
	public BigDecimal getHni_0_loan_undrwn_rwa() {
		return hni_0_loan_undrwn_rwa;
	}
	public void setHni_0_loan_undrwn_rwa(BigDecimal hni_0_loan_undrwn_rwa) {
		this.hni_0_loan_undrwn_rwa = hni_0_loan_undrwn_rwa;
	}
	public BigDecimal getHni_0_loan_under_ccf_amt() {
		return hni_0_loan_under_ccf_amt;
	}
	public void setHni_0_loan_under_ccf_amt(BigDecimal hni_0_loan_under_ccf_amt) {
		this.hni_0_loan_under_ccf_amt = hni_0_loan_under_ccf_amt;
	}
	public BigDecimal getHni_20_undrawn_bal() {
		return hni_20_undrawn_bal;
	}
	public void setHni_20_undrawn_bal(BigDecimal hni_20_undrawn_bal) {
		this.hni_20_undrawn_bal = hni_20_undrawn_bal;
	}
	public BigDecimal getHni_20_loan_undrwn_adj_crm() {
		return hni_20_loan_undrwn_adj_crm;
	}
	public void setHni_20_loan_undrwn_adj_crm(BigDecimal hni_20_loan_undrwn_adj_crm) {
		this.hni_20_loan_undrwn_adj_crm = hni_20_loan_undrwn_adj_crm;
	}
	public BigDecimal getHni_20_loan_undrwn_rwa() {
		return hni_20_loan_undrwn_rwa;
	}
	public void setHni_20_loan_undrwn_rwa(BigDecimal hni_20_loan_undrwn_rwa) {
		this.hni_20_loan_undrwn_rwa = hni_20_loan_undrwn_rwa;
	}
	public BigDecimal getHni_20_loan_under_ccf_amt() {
		return hni_20_loan_under_ccf_amt;
	}
	public void setHni_20_loan_under_ccf_amt(BigDecimal hni_20_loan_under_ccf_amt) {
		this.hni_20_loan_under_ccf_amt = hni_20_loan_under_ccf_amt;
	}
	public BigDecimal getHni_50_undrawn_bal() {
		return hni_50_undrawn_bal;
	}
	public void setHni_50_undrawn_bal(BigDecimal hni_50_undrawn_bal) {
		this.hni_50_undrawn_bal = hni_50_undrawn_bal;
	}
	public BigDecimal getHni_50_loan_undrwn_adj_crm() {
		return hni_50_loan_undrwn_adj_crm;
	}
	public void setHni_50_loan_undrwn_adj_crm(BigDecimal hni_50_loan_undrwn_adj_crm) {
		this.hni_50_loan_undrwn_adj_crm = hni_50_loan_undrwn_adj_crm;
	}
	public BigDecimal getHni_50_loan_undrwn_rwa() {
		return hni_50_loan_undrwn_rwa;
	}
	public void setHni_50_loan_undrwn_rwa(BigDecimal hni_50_loan_undrwn_rwa) {
		this.hni_50_loan_undrwn_rwa = hni_50_loan_undrwn_rwa;
	}
	public BigDecimal getHni_50_loan_under_ccf_amt() {
		return hni_50_loan_under_ccf_amt;
	}
	public void setHni_50_loan_under_ccf_amt(BigDecimal hni_50_loan_under_ccf_amt) {
		this.hni_50_loan_under_ccf_amt = hni_50_loan_under_ccf_amt;
	}
	public BigDecimal getHni_150_undrawn_bal() {
		return hni_150_undrawn_bal;
	}
	public void setHni_150_undrawn_bal(BigDecimal hni_150_undrawn_bal) {
		this.hni_150_undrawn_bal = hni_150_undrawn_bal;
	}
	public BigDecimal getHni_150_loan_undrwn_adj_crm() {
		return hni_150_loan_undrwn_adj_crm;
	}
	public void setHni_150_loan_undrwn_adj_crm(BigDecimal hni_150_loan_undrwn_adj_crm) {
		this.hni_150_loan_undrwn_adj_crm = hni_150_loan_undrwn_adj_crm;
	}
	public BigDecimal getHni_150_loan_undrwn_rwa() {
		return hni_150_loan_undrwn_rwa;
	}
	public void setHni_150_loan_undrwn_rwa(BigDecimal hni_150_loan_undrwn_rwa) {
		this.hni_150_loan_undrwn_rwa = hni_150_loan_undrwn_rwa;
	}
	public BigDecimal getHni_150_loan_under_ccf_amt() {
		return hni_150_loan_under_ccf_amt;
	}
	public void setHni_150_loan_under_ccf_amt(BigDecimal hni_150_loan_under_ccf_amt) {
		this.hni_150_loan_under_ccf_amt = hni_150_loan_under_ccf_amt;
	}
	public BigDecimal getPdl_0_undrawn_bal() {
		return pdl_0_undrawn_bal;
	}
	public void setPdl_0_undrawn_bal(BigDecimal pdl_0_undrawn_bal) {
		this.pdl_0_undrawn_bal = pdl_0_undrawn_bal;
	}
	public BigDecimal getPdl_0_loan_undrwn_adj_crm() {
		return pdl_0_loan_undrwn_adj_crm;
	}
	public void setPdl_0_loan_undrwn_adj_crm(BigDecimal pdl_0_loan_undrwn_adj_crm) {
		this.pdl_0_loan_undrwn_adj_crm = pdl_0_loan_undrwn_adj_crm;
	}
	public BigDecimal getPdl_0_loan_undrwn_rwa() {
		return pdl_0_loan_undrwn_rwa;
	}
	public void setPdl_0_loan_undrwn_rwa(BigDecimal pdl_0_loan_undrwn_rwa) {
		this.pdl_0_loan_undrwn_rwa = pdl_0_loan_undrwn_rwa;
	}
	public BigDecimal getPdl_0_loan_under_ccf_amt() {
		return pdl_0_loan_under_ccf_amt;
	}
	public void setPdl_0_loan_under_ccf_amt(BigDecimal pdl_0_loan_under_ccf_amt) {
		this.pdl_0_loan_under_ccf_amt = pdl_0_loan_under_ccf_amt;
	}
	public BigDecimal getPdl_20_undrawn_bal() {
		return pdl_20_undrawn_bal;
	}
	public void setPdl_20_undrawn_bal(BigDecimal pdl_20_undrawn_bal) {
		this.pdl_20_undrawn_bal = pdl_20_undrawn_bal;
	}
	public BigDecimal getPdl_20_loan_undrwn_adj_crm() {
		return pdl_20_loan_undrwn_adj_crm;
	}
	public void setPdl_20_loan_undrwn_adj_crm(BigDecimal pdl_20_loan_undrwn_adj_crm) {
		this.pdl_20_loan_undrwn_adj_crm = pdl_20_loan_undrwn_adj_crm;
	}
	public BigDecimal getPdl_20_loan_undrwn_rwa() {
		return pdl_20_loan_undrwn_rwa;
	}
	public void setPdl_20_loan_undrwn_rwa(BigDecimal pdl_20_loan_undrwn_rwa) {
		this.pdl_20_loan_undrwn_rwa = pdl_20_loan_undrwn_rwa;
	}
	public BigDecimal getPdl_20_loan_under_ccf_amt() {
		return pdl_20_loan_under_ccf_amt;
	}
	public void setPdl_20_loan_under_ccf_amt(BigDecimal pdl_20_loan_under_ccf_amt) {
		this.pdl_20_loan_under_ccf_amt = pdl_20_loan_under_ccf_amt;
	}
	public BigDecimal getPdl_50_undrawn_bal() {
		return pdl_50_undrawn_bal;
	}
	public void setPdl_50_undrawn_bal(BigDecimal pdl_50_undrawn_bal) {
		this.pdl_50_undrawn_bal = pdl_50_undrawn_bal;
	}
	public BigDecimal getPdl_50_loan_undrwn_adj_crm() {
		return pdl_50_loan_undrwn_adj_crm;
	}
	public void setPdl_50_loan_undrwn_adj_crm(BigDecimal pdl_50_loan_undrwn_adj_crm) {
		this.pdl_50_loan_undrwn_adj_crm = pdl_50_loan_undrwn_adj_crm;
	}
	public BigDecimal getPdl_50_loan_undrwn_rwa() {
		return pdl_50_loan_undrwn_rwa;
	}
	public void setPdl_50_loan_undrwn_rwa(BigDecimal pdl_50_loan_undrwn_rwa) {
		this.pdl_50_loan_undrwn_rwa = pdl_50_loan_undrwn_rwa;
	}
	public BigDecimal getPdl_50_loan_under_ccf_amt() {
		return pdl_50_loan_under_ccf_amt;
	}
	public void setPdl_50_loan_under_ccf_amt(BigDecimal pdl_50_loan_under_ccf_amt) {
		this.pdl_50_loan_under_ccf_amt = pdl_50_loan_under_ccf_amt;
	}
	public BigDecimal getRes_0_undrawn_bal() {
		return res_0_undrawn_bal;
	}
	public void setRes_0_undrawn_bal(BigDecimal res_0_undrawn_bal) {
		this.res_0_undrawn_bal = res_0_undrawn_bal;
	}
	public BigDecimal getRes_0_loan_undrwn_adj_crm() {
		return res_0_loan_undrwn_adj_crm;
	}
	public void setRes_0_loan_undrwn_adj_crm(BigDecimal res_0_loan_undrwn_adj_crm) {
		this.res_0_loan_undrwn_adj_crm = res_0_loan_undrwn_adj_crm;
	}
	public BigDecimal getRes_0_loan_undrwn_rwa() {
		return res_0_loan_undrwn_rwa;
	}
	public void setRes_0_loan_undrwn_rwa(BigDecimal res_0_loan_undrwn_rwa) {
		this.res_0_loan_undrwn_rwa = res_0_loan_undrwn_rwa;
	}
	public BigDecimal getRes_0_loan_under_ccf_amt() {
		return res_0_loan_under_ccf_amt;
	}
	public void setRes_0_loan_under_ccf_amt(BigDecimal res_0_loan_under_ccf_amt) {
		this.res_0_loan_under_ccf_amt = res_0_loan_under_ccf_amt;
	}
	public BigDecimal getRes_20_undrawn_bal() {
		return res_20_undrawn_bal;
	}
	public void setRes_20_undrawn_bal(BigDecimal res_20_undrawn_bal) {
		this.res_20_undrawn_bal = res_20_undrawn_bal;
	}
	public BigDecimal getRes_20_loan_undrwn_adj_crm() {
		return res_20_loan_undrwn_adj_crm;
	}
	public void setRes_20_loan_undrwn_adj_crm(BigDecimal res_20_loan_undrwn_adj_crm) {
		this.res_20_loan_undrwn_adj_crm = res_20_loan_undrwn_adj_crm;
	}
	public BigDecimal getRes_20_loan_undrwn_rwa() {
		return res_20_loan_undrwn_rwa;
	}
	public void setRes_20_loan_undrwn_rwa(BigDecimal res_20_loan_undrwn_rwa) {
		this.res_20_loan_undrwn_rwa = res_20_loan_undrwn_rwa;
	}
	public BigDecimal getRes_20_loan_under_ccf_amt() {
		return res_20_loan_under_ccf_amt;
	}
	public void setRes_20_loan_under_ccf_amt(BigDecimal res_20_loan_under_ccf_amt) {
		this.res_20_loan_under_ccf_amt = res_20_loan_under_ccf_amt;
	}
	public BigDecimal getRes_50_undrawn_bal() {
		return res_50_undrawn_bal;
	}
	public void setRes_50_undrawn_bal(BigDecimal res_50_undrawn_bal) {
		this.res_50_undrawn_bal = res_50_undrawn_bal;
	}
	public BigDecimal getRes_50_loan_undrwn_adj_crm() {
		return res_50_loan_undrwn_adj_crm;
	}
	public void setRes_50_loan_undrwn_adj_crm(BigDecimal res_50_loan_undrwn_adj_crm) {
		this.res_50_loan_undrwn_adj_crm = res_50_loan_undrwn_adj_crm;
	}
	public BigDecimal getRes_50_loan_undrwn_rwa() {
		return res_50_loan_undrwn_rwa;
	}
	public void setRes_50_loan_undrwn_rwa(BigDecimal res_50_loan_undrwn_rwa) {
		this.res_50_loan_undrwn_rwa = res_50_loan_undrwn_rwa;
	}
	public BigDecimal getRes_50_loan_under_ccf_amt() {
		return res_50_loan_under_ccf_amt;
	}
	public void setRes_50_loan_under_ccf_amt(BigDecimal res_50_loan_under_ccf_amt) {
		this.res_50_loan_under_ccf_amt = res_50_loan_under_ccf_amt;
	}
	public BigDecimal getRes_150_undrawn_bal() {
		return res_150_undrawn_bal;
	}
	public void setRes_150_undrawn_bal(BigDecimal res_150_undrawn_bal) {
		this.res_150_undrawn_bal = res_150_undrawn_bal;
	}
	public BigDecimal getRes_150_loan_undrwn_adj_crm() {
		return res_150_loan_undrwn_adj_crm;
	}
	public void setRes_150_loan_undrwn_adj_crm(BigDecimal res_150_loan_undrwn_adj_crm) {
		this.res_150_loan_undrwn_adj_crm = res_150_loan_undrwn_adj_crm;
	}
	public BigDecimal getRes_150_loan_undrwn_rwa() {
		return res_150_loan_undrwn_rwa;
	}
	public void setRes_150_loan_undrwn_rwa(BigDecimal res_150_loan_undrwn_rwa) {
		this.res_150_loan_undrwn_rwa = res_150_loan_undrwn_rwa;
	}
	public BigDecimal getRes_150_loan_under_ccf_amt() {
		return res_150_loan_under_ccf_amt;
	}
	public void setRes_150_loan_under_ccf_amt(BigDecimal res_150_loan_under_ccf_amt) {
		this.res_150_loan_under_ccf_amt = res_150_loan_under_ccf_amt;
	}
	public BigDecimal getRrp_inde1_0_undrawn_bal() {
		return rrp_inde1_0_undrawn_bal;
	}
	public void setRrp_inde1_0_undrawn_bal(BigDecimal rrp_inde1_0_undrawn_bal) {
		this.rrp_inde1_0_undrawn_bal = rrp_inde1_0_undrawn_bal;
	}
	public BigDecimal getRrp_inde1_0_loan_undrwn_adj_crm() {
		return rrp_inde1_0_loan_undrwn_adj_crm;
	}
	public void setRrp_inde1_0_loan_undrwn_adj_crm(BigDecimal rrp_inde1_0_loan_undrwn_adj_crm) {
		this.rrp_inde1_0_loan_undrwn_adj_crm = rrp_inde1_0_loan_undrwn_adj_crm;
	}
	public BigDecimal getRrp_inde1_0_loan_undrwn_rwa() {
		return rrp_inde1_0_loan_undrwn_rwa;
	}
	public void setRrp_inde1_0_loan_undrwn_rwa(BigDecimal rrp_inde1_0_loan_undrwn_rwa) {
		this.rrp_inde1_0_loan_undrwn_rwa = rrp_inde1_0_loan_undrwn_rwa;
	}
	public BigDecimal getRrp_inde1_0_loan_under_ccf_amt() {
		return rrp_inde1_0_loan_under_ccf_amt;
	}
	public void setRrp_inde1_0_loan_under_ccf_amt(BigDecimal rrp_inde1_0_loan_under_ccf_amt) {
		this.rrp_inde1_0_loan_under_ccf_amt = rrp_inde1_0_loan_under_ccf_amt;
	}
	public BigDecimal getRrp_inde1_20_undrawn_bal() {
		return rrp_inde1_20_undrawn_bal;
	}
	public void setRrp_inde1_20_undrawn_bal(BigDecimal rrp_inde1_20_undrawn_bal) {
		this.rrp_inde1_20_undrawn_bal = rrp_inde1_20_undrawn_bal;
	}
	public BigDecimal getRrp_inde1_20_loan_undrwn_adj_crm() {
		return rrp_inde1_20_loan_undrwn_adj_crm;
	}
	public void setRrp_inde1_20_loan_undrwn_adj_crm(BigDecimal rrp_inde1_20_loan_undrwn_adj_crm) {
		this.rrp_inde1_20_loan_undrwn_adj_crm = rrp_inde1_20_loan_undrwn_adj_crm;
	}
	public BigDecimal getRrp_inde1_20_loan_undrwn_rwa() {
		return rrp_inde1_20_loan_undrwn_rwa;
	}
	public void setRrp_inde1_20_loan_undrwn_rwa(BigDecimal rrp_inde1_20_loan_undrwn_rwa) {
		this.rrp_inde1_20_loan_undrwn_rwa = rrp_inde1_20_loan_undrwn_rwa;
	}
	public BigDecimal getRrp_inde1_20_loan_under_ccf_amt() {
		return rrp_inde1_20_loan_under_ccf_amt;
	}
	public void setRrp_inde1_20_loan_under_ccf_amt(BigDecimal rrp_inde1_20_loan_under_ccf_amt) {
		this.rrp_inde1_20_loan_under_ccf_amt = rrp_inde1_20_loan_under_ccf_amt;
	}
	public BigDecimal getRrp_inde1_50_undrawn_bal() {
		return rrp_inde1_50_undrawn_bal;
	}
	public void setRrp_inde1_50_undrawn_bal(BigDecimal rrp_inde1_50_undrawn_bal) {
		this.rrp_inde1_50_undrawn_bal = rrp_inde1_50_undrawn_bal;
	}
	public BigDecimal getRrp_inde1_50_loan_undrwn_adj_crm() {
		return rrp_inde1_50_loan_undrwn_adj_crm;
	}
	public void setRrp_inde1_50_loan_undrwn_adj_crm(BigDecimal rrp_inde1_50_loan_undrwn_adj_crm) {
		this.rrp_inde1_50_loan_undrwn_adj_crm = rrp_inde1_50_loan_undrwn_adj_crm;
	}
	public BigDecimal getRrp_inde1_50_loan_undrwn_rwa() {
		return rrp_inde1_50_loan_undrwn_rwa;
	}
	public void setRrp_inde1_50_loan_undrwn_rwa(BigDecimal rrp_inde1_50_loan_undrwn_rwa) {
		this.rrp_inde1_50_loan_undrwn_rwa = rrp_inde1_50_loan_undrwn_rwa;
	}
	public BigDecimal getRrp_inde1_50_loan_under_ccf_amt() {
		return rrp_inde1_50_loan_under_ccf_amt;
	}
	public void setRrp_inde1_50_loan_under_ccf_amt(BigDecimal rrp_inde1_50_loan_under_ccf_amt) {
		this.rrp_inde1_50_loan_under_ccf_amt = rrp_inde1_50_loan_under_ccf_amt;
	}
	public BigDecimal getRrp_inde1_100_undrawn_bal() {
		return rrp_inde1_100_undrawn_bal;
	}
	public void setRrp_inde1_100_undrawn_bal(BigDecimal rrp_inde1_100_undrawn_bal) {
		this.rrp_inde1_100_undrawn_bal = rrp_inde1_100_undrawn_bal;
	}
	public BigDecimal getRrp_inde1_100_loan_undrwn_adj_crm() {
		return rrp_inde1_100_loan_undrwn_adj_crm;
	}
	public void setRrp_inde1_100_loan_undrwn_adj_crm(BigDecimal rrp_inde1_100_loan_undrwn_adj_crm) {
		this.rrp_inde1_100_loan_undrwn_adj_crm = rrp_inde1_100_loan_undrwn_adj_crm;
	}
	public BigDecimal getRrp_inde1_100_loan_undrwn_rwa() {
		return rrp_inde1_100_loan_undrwn_rwa;
	}
	public void setRrp_inde1_100_loan_undrwn_rwa(BigDecimal rrp_inde1_100_loan_undrwn_rwa) {
		this.rrp_inde1_100_loan_undrwn_rwa = rrp_inde1_100_loan_undrwn_rwa;
	}
	public BigDecimal getRrp_inde1_100_loan_under_ccf_amt() {
		return rrp_inde1_100_loan_under_ccf_amt;
	}
	public void setRrp_inde1_100_loan_under_ccf_amt(BigDecimal rrp_inde1_100_loan_under_ccf_amt) {
		this.rrp_inde1_100_loan_under_ccf_amt = rrp_inde1_100_loan_under_ccf_amt;
	}
	public BigDecimal getRrp_inde1_150_undrawn_bal() {
		return rrp_inde1_150_undrawn_bal;
	}
	public void setRrp_inde1_150_undrawn_bal(BigDecimal rrp_inde1_150_undrawn_bal) {
		this.rrp_inde1_150_undrawn_bal = rrp_inde1_150_undrawn_bal;
	}
	public BigDecimal getRrp_inde1_150_loan_undrwn_adj_crm() {
		return rrp_inde1_150_loan_undrwn_adj_crm;
	}
	public void setRrp_inde1_150_loan_undrwn_adj_crm(BigDecimal rrp_inde1_150_loan_undrwn_adj_crm) {
		this.rrp_inde1_150_loan_undrwn_adj_crm = rrp_inde1_150_loan_undrwn_adj_crm;
	}
	public BigDecimal getRrp_inde1_150_loan_undrwn_rwa() {
		return rrp_inde1_150_loan_undrwn_rwa;
	}
	public void setRrp_inde1_150_loan_undrwn_rwa(BigDecimal rrp_inde1_150_loan_undrwn_rwa) {
		this.rrp_inde1_150_loan_undrwn_rwa = rrp_inde1_150_loan_undrwn_rwa;
	}
	public BigDecimal getRrp_inde1_150_loan_under_ccf_amt() {
		return rrp_inde1_150_loan_under_ccf_amt;
	}
	public void setRrp_inde1_150_loan_under_ccf_amt(BigDecimal rrp_inde1_150_loan_under_ccf_amt) {
		this.rrp_inde1_150_loan_under_ccf_amt = rrp_inde1_150_loan_under_ccf_amt;
	}
	public BigDecimal getRrp_inde2_0_undrawn_bal() {
		return rrp_inde2_0_undrawn_bal;
	}
	public void setRrp_inde2_0_undrawn_bal(BigDecimal rrp_inde2_0_undrawn_bal) {
		this.rrp_inde2_0_undrawn_bal = rrp_inde2_0_undrawn_bal;
	}
	public BigDecimal getRrp_inde2_0_loan_undrwn_adj_crm() {
		return rrp_inde2_0_loan_undrwn_adj_crm;
	}
	public void setRrp_inde2_0_loan_undrwn_adj_crm(BigDecimal rrp_inde2_0_loan_undrwn_adj_crm) {
		this.rrp_inde2_0_loan_undrwn_adj_crm = rrp_inde2_0_loan_undrwn_adj_crm;
	}
	public BigDecimal getRrp_inde2_0_loan_undrwn_rwa() {
		return rrp_inde2_0_loan_undrwn_rwa;
	}
	public void setRrp_inde2_0_loan_undrwn_rwa(BigDecimal rrp_inde2_0_loan_undrwn_rwa) {
		this.rrp_inde2_0_loan_undrwn_rwa = rrp_inde2_0_loan_undrwn_rwa;
	}
	public BigDecimal getRrp_inde2_0_loan_under_ccf_amt() {
		return rrp_inde2_0_loan_under_ccf_amt;
	}
	public void setRrp_inde2_0_loan_under_ccf_amt(BigDecimal rrp_inde2_0_loan_under_ccf_amt) {
		this.rrp_inde2_0_loan_under_ccf_amt = rrp_inde2_0_loan_under_ccf_amt;
	}
	public BigDecimal getRrp_inde2_20_undrawn_bal() {
		return rrp_inde2_20_undrawn_bal;
	}
	public void setRrp_inde2_20_undrawn_bal(BigDecimal rrp_inde2_20_undrawn_bal) {
		this.rrp_inde2_20_undrawn_bal = rrp_inde2_20_undrawn_bal;
	}
	public BigDecimal getRrp_inde2_20_loan_undrwn_adj_crm() {
		return rrp_inde2_20_loan_undrwn_adj_crm;
	}
	public void setRrp_inde2_20_loan_undrwn_adj_crm(BigDecimal rrp_inde2_20_loan_undrwn_adj_crm) {
		this.rrp_inde2_20_loan_undrwn_adj_crm = rrp_inde2_20_loan_undrwn_adj_crm;
	}
	public BigDecimal getRrp_inde2_20_loan_undrwn_rwa() {
		return rrp_inde2_20_loan_undrwn_rwa;
	}
	public void setRrp_inde2_20_loan_undrwn_rwa(BigDecimal rrp_inde2_20_loan_undrwn_rwa) {
		this.rrp_inde2_20_loan_undrwn_rwa = rrp_inde2_20_loan_undrwn_rwa;
	}
	public BigDecimal getRrp_inde2_20_loan_under_ccf_amt() {
		return rrp_inde2_20_loan_under_ccf_amt;
	}
	public void setRrp_inde2_20_loan_under_ccf_amt(BigDecimal rrp_inde2_20_loan_under_ccf_amt) {
		this.rrp_inde2_20_loan_under_ccf_amt = rrp_inde2_20_loan_under_ccf_amt;
	}
	public BigDecimal getRrp_inde2_50_undrawn_bal() {
		return rrp_inde2_50_undrawn_bal;
	}
	public void setRrp_inde2_50_undrawn_bal(BigDecimal rrp_inde2_50_undrawn_bal) {
		this.rrp_inde2_50_undrawn_bal = rrp_inde2_50_undrawn_bal;
	}
	public BigDecimal getRrp_inde2_50_loan_undrwn_adj_crm() {
		return rrp_inde2_50_loan_undrwn_adj_crm;
	}
	public void setRrp_inde2_50_loan_undrwn_adj_crm(BigDecimal rrp_inde2_50_loan_undrwn_adj_crm) {
		this.rrp_inde2_50_loan_undrwn_adj_crm = rrp_inde2_50_loan_undrwn_adj_crm;
	}
	public BigDecimal getRrp_inde2_50_loan_undrwn_rwa() {
		return rrp_inde2_50_loan_undrwn_rwa;
	}
	public void setRrp_inde2_50_loan_undrwn_rwa(BigDecimal rrp_inde2_50_loan_undrwn_rwa) {
		this.rrp_inde2_50_loan_undrwn_rwa = rrp_inde2_50_loan_undrwn_rwa;
	}
	public BigDecimal getRrp_inde2_50_loan_under_ccf_amt() {
		return rrp_inde2_50_loan_under_ccf_amt;
	}
	public void setRrp_inde2_50_loan_under_ccf_amt(BigDecimal rrp_inde2_50_loan_under_ccf_amt) {
		this.rrp_inde2_50_loan_under_ccf_amt = rrp_inde2_50_loan_under_ccf_amt;
	}
	public BigDecimal getRrp_inde2_150_undrawn_bal() {
		return rrp_inde2_150_undrawn_bal;
	}
	public void setRrp_inde2_150_undrawn_bal(BigDecimal rrp_inde2_150_undrawn_bal) {
		this.rrp_inde2_150_undrawn_bal = rrp_inde2_150_undrawn_bal;
	}
	public BigDecimal getRrp_inde2_150_loan_undrwn_adj_crm() {
		return rrp_inde2_150_loan_undrwn_adj_crm;
	}
	public void setRrp_inde2_150_loan_undrwn_adj_crm(BigDecimal rrp_inde2_150_loan_undrwn_adj_crm) {
		this.rrp_inde2_150_loan_undrwn_adj_crm = rrp_inde2_150_loan_undrwn_adj_crm;
	}
	public BigDecimal getRrp_inde2_150_loan_undrwn_rwa() {
		return rrp_inde2_150_loan_undrwn_rwa;
	}
	public void setRrp_inde2_150_loan_undrwn_rwa(BigDecimal rrp_inde2_150_loan_undrwn_rwa) {
		this.rrp_inde2_150_loan_undrwn_rwa = rrp_inde2_150_loan_undrwn_rwa;
	}
	public BigDecimal getRrp_inde2_150_loan_under_ccf_amt() {
		return rrp_inde2_150_loan_under_ccf_amt;
	}
	public void setRrp_inde2_150_loan_under_ccf_amt(BigDecimal rrp_inde2_150_loan_under_ccf_amt) {
		this.rrp_inde2_150_loan_under_ccf_amt = rrp_inde2_150_loan_under_ccf_amt;
	}
	public BigDecimal getRrp_smlb_0_undrawn_bal() {
		return rrp_smlb_0_undrawn_bal;
	}
	public void setRrp_smlb_0_undrawn_bal(BigDecimal rrp_smlb_0_undrawn_bal) {
		this.rrp_smlb_0_undrawn_bal = rrp_smlb_0_undrawn_bal;
	}
	public BigDecimal getRrp_smlb_0_loan_undrwn_adj_crm() {
		return rrp_smlb_0_loan_undrwn_adj_crm;
	}
	public void setRrp_smlb_0_loan_undrwn_adj_crm(BigDecimal rrp_smlb_0_loan_undrwn_adj_crm) {
		this.rrp_smlb_0_loan_undrwn_adj_crm = rrp_smlb_0_loan_undrwn_adj_crm;
	}
	public BigDecimal getRrp_smlb_0_loan_undrwn_rwa() {
		return rrp_smlb_0_loan_undrwn_rwa;
	}
	public void setRrp_smlb_0_loan_undrwn_rwa(BigDecimal rrp_smlb_0_loan_undrwn_rwa) {
		this.rrp_smlb_0_loan_undrwn_rwa = rrp_smlb_0_loan_undrwn_rwa;
	}
	public BigDecimal getRrp_smlb_0_loan_under_ccf_amt() {
		return rrp_smlb_0_loan_under_ccf_amt;
	}
	public void setRrp_smlb_0_loan_under_ccf_amt(BigDecimal rrp_smlb_0_loan_under_ccf_amt) {
		this.rrp_smlb_0_loan_under_ccf_amt = rrp_smlb_0_loan_under_ccf_amt;
	}
	public BigDecimal getRrp_smlb_20_undrawn_bal() {
		return rrp_smlb_20_undrawn_bal;
	}
	public void setRrp_smlb_20_undrawn_bal(BigDecimal rrp_smlb_20_undrawn_bal) {
		this.rrp_smlb_20_undrawn_bal = rrp_smlb_20_undrawn_bal;
	}
	public BigDecimal getRrp_smlb_20_loan_undrwn_adj_crm() {
		return rrp_smlb_20_loan_undrwn_adj_crm;
	}
	public void setRrp_smlb_20_loan_undrwn_adj_crm(BigDecimal rrp_smlb_20_loan_undrwn_adj_crm) {
		this.rrp_smlb_20_loan_undrwn_adj_crm = rrp_smlb_20_loan_undrwn_adj_crm;
	}
	public BigDecimal getRrp_smlb_20_loan_undrwn_rwa() {
		return rrp_smlb_20_loan_undrwn_rwa;
	}
	public void setRrp_smlb_20_loan_undrwn_rwa(BigDecimal rrp_smlb_20_loan_undrwn_rwa) {
		this.rrp_smlb_20_loan_undrwn_rwa = rrp_smlb_20_loan_undrwn_rwa;
	}
	public BigDecimal getRrp_smlb_20_loan_under_ccf_amt() {
		return rrp_smlb_20_loan_under_ccf_amt;
	}
	public void setRrp_smlb_20_loan_under_ccf_amt(BigDecimal rrp_smlb_20_loan_under_ccf_amt) {
		this.rrp_smlb_20_loan_under_ccf_amt = rrp_smlb_20_loan_under_ccf_amt;
	}
	public BigDecimal getRrp_smlb_50_undrawn_bal() {
		return rrp_smlb_50_undrawn_bal;
	}
	public void setRrp_smlb_50_undrawn_bal(BigDecimal rrp_smlb_50_undrawn_bal) {
		this.rrp_smlb_50_undrawn_bal = rrp_smlb_50_undrawn_bal;
	}
	public BigDecimal getRrp_smlb_50_loan_undrwn_adj_crm() {
		return rrp_smlb_50_loan_undrwn_adj_crm;
	}
	public void setRrp_smlb_50_loan_undrwn_adj_crm(BigDecimal rrp_smlb_50_loan_undrwn_adj_crm) {
		this.rrp_smlb_50_loan_undrwn_adj_crm = rrp_smlb_50_loan_undrwn_adj_crm;
	}
	public BigDecimal getRrp_smlb_50_loan_undrwn_rwa() {
		return rrp_smlb_50_loan_undrwn_rwa;
	}
	public void setRrp_smlb_50_loan_undrwn_rwa(BigDecimal rrp_smlb_50_loan_undrwn_rwa) {
		this.rrp_smlb_50_loan_undrwn_rwa = rrp_smlb_50_loan_undrwn_rwa;
	}
	public BigDecimal getRrp_smlb_50_loan_under_ccf_amt() {
		return rrp_smlb_50_loan_under_ccf_amt;
	}
	public void setRrp_smlb_50_loan_under_ccf_amt(BigDecimal rrp_smlb_50_loan_under_ccf_amt) {
		this.rrp_smlb_50_loan_under_ccf_amt = rrp_smlb_50_loan_under_ccf_amt;
	}
	public BigDecimal getRrp_smlb_100_undrawn_bal() {
		return rrp_smlb_100_undrawn_bal;
	}
	public void setRrp_smlb_100_undrawn_bal(BigDecimal rrp_smlb_100_undrawn_bal) {
		this.rrp_smlb_100_undrawn_bal = rrp_smlb_100_undrawn_bal;
	}
	public BigDecimal getRrp_smlb_100_loan_undrwn_adj_crm() {
		return rrp_smlb_100_loan_undrwn_adj_crm;
	}
	public void setRrp_smlb_100_loan_undrwn_adj_crm(BigDecimal rrp_smlb_100_loan_undrwn_adj_crm) {
		this.rrp_smlb_100_loan_undrwn_adj_crm = rrp_smlb_100_loan_undrwn_adj_crm;
	}
	public BigDecimal getRrp_smlb_100_loan_undrwn_rwa() {
		return rrp_smlb_100_loan_undrwn_rwa;
	}
	public void setRrp_smlb_100_loan_undrwn_rwa(BigDecimal rrp_smlb_100_loan_undrwn_rwa) {
		this.rrp_smlb_100_loan_undrwn_rwa = rrp_smlb_100_loan_undrwn_rwa;
	}
	public BigDecimal getRrp_smlb_100_loan_under_ccf_amt() {
		return rrp_smlb_100_loan_under_ccf_amt;
	}
	public void setRrp_smlb_100_loan_under_ccf_amt(BigDecimal rrp_smlb_100_loan_under_ccf_amt) {
		this.rrp_smlb_100_loan_under_ccf_amt = rrp_smlb_100_loan_under_ccf_amt;
	}
	public BigDecimal getRrp_smlb_150_undrawn_bal() {
		return rrp_smlb_150_undrawn_bal;
	}
	public void setRrp_smlb_150_undrawn_bal(BigDecimal rrp_smlb_150_undrawn_bal) {
		this.rrp_smlb_150_undrawn_bal = rrp_smlb_150_undrawn_bal;
	}
	public BigDecimal getRrp_smlb_150_loan_undrwn_adj_crm() {
		return rrp_smlb_150_loan_undrwn_adj_crm;
	}
	public void setRrp_smlb_150_loan_undrwn_adj_crm(BigDecimal rrp_smlb_150_loan_undrwn_adj_crm) {
		this.rrp_smlb_150_loan_undrwn_adj_crm = rrp_smlb_150_loan_undrwn_adj_crm;
	}
	public BigDecimal getRrp_smlb_150_loan_undrwn_rwa() {
		return rrp_smlb_150_loan_undrwn_rwa;
	}
	public void setRrp_smlb_150_loan_undrwn_rwa(BigDecimal rrp_smlb_150_loan_undrwn_rwa) {
		this.rrp_smlb_150_loan_undrwn_rwa = rrp_smlb_150_loan_undrwn_rwa;
	}
	public BigDecimal getRrp_smlb_150_loan_under_ccf_amt() {
		return rrp_smlb_150_loan_under_ccf_amt;
	}
	public void setRrp_smlb_150_loan_under_ccf_amt(BigDecimal rrp_smlb_150_loan_under_ccf_amt) {
		this.rrp_smlb_150_loan_under_ccf_amt = rrp_smlb_150_loan_under_ccf_amt;
	}
	public BigDecimal getRrp_smlb2_0_undrawn_bal() {
		return rrp_smlb2_0_undrawn_bal;
	}
	public void setRrp_smlb2_0_undrawn_bal(BigDecimal rrp_smlb2_0_undrawn_bal) {
		this.rrp_smlb2_0_undrawn_bal = rrp_smlb2_0_undrawn_bal;
	}
	public BigDecimal getRrp_smlb2_0_loan_undrwn_adj_crm() {
		return rrp_smlb2_0_loan_undrwn_adj_crm;
	}
	public void setRrp_smlb2_0_loan_undrwn_adj_crm(BigDecimal rrp_smlb2_0_loan_undrwn_adj_crm) {
		this.rrp_smlb2_0_loan_undrwn_adj_crm = rrp_smlb2_0_loan_undrwn_adj_crm;
	}
	public BigDecimal getRrp_smlb2_0_loan_undrwn_rwa() {
		return rrp_smlb2_0_loan_undrwn_rwa;
	}
	public void setRrp_smlb2_0_loan_undrwn_rwa(BigDecimal rrp_smlb2_0_loan_undrwn_rwa) {
		this.rrp_smlb2_0_loan_undrwn_rwa = rrp_smlb2_0_loan_undrwn_rwa;
	}
	public BigDecimal getRrp_smlb2_0_loan_under_ccf_amt() {
		return rrp_smlb2_0_loan_under_ccf_amt;
	}
	public void setRrp_smlb2_0_loan_under_ccf_amt(BigDecimal rrp_smlb2_0_loan_under_ccf_amt) {
		this.rrp_smlb2_0_loan_under_ccf_amt = rrp_smlb2_0_loan_under_ccf_amt;
	}
	public BigDecimal getRrp_smlb2_20_undrawn_bal() {
		return rrp_smlb2_20_undrawn_bal;
	}
	public void setRrp_smlb2_20_undrawn_bal(BigDecimal rrp_smlb2_20_undrawn_bal) {
		this.rrp_smlb2_20_undrawn_bal = rrp_smlb2_20_undrawn_bal;
	}
	public BigDecimal getRrp_smlb2_20_loan_undrwn_adj_crm() {
		return rrp_smlb2_20_loan_undrwn_adj_crm;
	}
	public void setRrp_smlb2_20_loan_undrwn_adj_crm(BigDecimal rrp_smlb2_20_loan_undrwn_adj_crm) {
		this.rrp_smlb2_20_loan_undrwn_adj_crm = rrp_smlb2_20_loan_undrwn_adj_crm;
	}
	public BigDecimal getRrp_smlb2_20_loan_undrwn_rwa() {
		return rrp_smlb2_20_loan_undrwn_rwa;
	}
	public void setRrp_smlb2_20_loan_undrwn_rwa(BigDecimal rrp_smlb2_20_loan_undrwn_rwa) {
		this.rrp_smlb2_20_loan_undrwn_rwa = rrp_smlb2_20_loan_undrwn_rwa;
	}
	public BigDecimal getRrp_smlb2_20_loan_under_ccf_amt() {
		return rrp_smlb2_20_loan_under_ccf_amt;
	}
	public void setRrp_smlb2_20_loan_under_ccf_amt(BigDecimal rrp_smlb2_20_loan_under_ccf_amt) {
		this.rrp_smlb2_20_loan_under_ccf_amt = rrp_smlb2_20_loan_under_ccf_amt;
	}
	public BigDecimal getRrp_smlb2_50_undrawn_bal() {
		return rrp_smlb2_50_undrawn_bal;
	}
	public void setRrp_smlb2_50_undrawn_bal(BigDecimal rrp_smlb2_50_undrawn_bal) {
		this.rrp_smlb2_50_undrawn_bal = rrp_smlb2_50_undrawn_bal;
	}
	public BigDecimal getRrp_smlb2_50_loan_undrwn_adj_crm() {
		return rrp_smlb2_50_loan_undrwn_adj_crm;
	}
	public void setRrp_smlb2_50_loan_undrwn_adj_crm(BigDecimal rrp_smlb2_50_loan_undrwn_adj_crm) {
		this.rrp_smlb2_50_loan_undrwn_adj_crm = rrp_smlb2_50_loan_undrwn_adj_crm;
	}
	public BigDecimal getRrp_smlb2_50_loan_undrwn_rwa() {
		return rrp_smlb2_50_loan_undrwn_rwa;
	}
	public void setRrp_smlb2_50_loan_undrwn_rwa(BigDecimal rrp_smlb2_50_loan_undrwn_rwa) {
		this.rrp_smlb2_50_loan_undrwn_rwa = rrp_smlb2_50_loan_undrwn_rwa;
	}
	public BigDecimal getRrp_smlb2_50_loan_under_ccf_amt() {
		return rrp_smlb2_50_loan_under_ccf_amt;
	}
	public void setRrp_smlb2_50_loan_under_ccf_amt(BigDecimal rrp_smlb2_50_loan_under_ccf_amt) {
		this.rrp_smlb2_50_loan_under_ccf_amt = rrp_smlb2_50_loan_under_ccf_amt;
	}
	public BigDecimal getRrp_smlb2_100_undrawn_bal() {
		return rrp_smlb2_100_undrawn_bal;
	}
	public void setRrp_smlb2_100_undrawn_bal(BigDecimal rrp_smlb2_100_undrawn_bal) {
		this.rrp_smlb2_100_undrawn_bal = rrp_smlb2_100_undrawn_bal;
	}
	public BigDecimal getRrp_smlb2_100_loan_undrwn_adj_crm() {
		return rrp_smlb2_100_loan_undrwn_adj_crm;
	}
	public void setRrp_smlb2_100_loan_undrwn_adj_crm(BigDecimal rrp_smlb2_100_loan_undrwn_adj_crm) {
		this.rrp_smlb2_100_loan_undrwn_adj_crm = rrp_smlb2_100_loan_undrwn_adj_crm;
	}
	public BigDecimal getRrp_smlb2_100_loan_undrwn_rwa() {
		return rrp_smlb2_100_loan_undrwn_rwa;
	}
	public void setRrp_smlb2_100_loan_undrwn_rwa(BigDecimal rrp_smlb2_100_loan_undrwn_rwa) {
		this.rrp_smlb2_100_loan_undrwn_rwa = rrp_smlb2_100_loan_undrwn_rwa;
	}
	public BigDecimal getRrp_smlb2_100_loan_under_ccf_amt() {
		return rrp_smlb2_100_loan_under_ccf_amt;
	}
	public void setRrp_smlb2_100_loan_under_ccf_amt(BigDecimal rrp_smlb2_100_loan_under_ccf_amt) {
		this.rrp_smlb2_100_loan_under_ccf_amt = rrp_smlb2_100_loan_under_ccf_amt;
	}
	public BigDecimal getRrp_smlb2_150_undrawn_bal() {
		return rrp_smlb2_150_undrawn_bal;
	}
	public void setRrp_smlb2_150_undrawn_bal(BigDecimal rrp_smlb2_150_undrawn_bal) {
		this.rrp_smlb2_150_undrawn_bal = rrp_smlb2_150_undrawn_bal;
	}
	public BigDecimal getRrp_smlb2_150_loan_undrwn_adj_crm() {
		return rrp_smlb2_150_loan_undrwn_adj_crm;
	}
	public void setRrp_smlb2_150_loan_undrwn_adj_crm(BigDecimal rrp_smlb2_150_loan_undrwn_adj_crm) {
		this.rrp_smlb2_150_loan_undrwn_adj_crm = rrp_smlb2_150_loan_undrwn_adj_crm;
	}
	public BigDecimal getRrp_smlb2_150_loan_undrwn_rwa() {
		return rrp_smlb2_150_loan_undrwn_rwa;
	}
	public void setRrp_smlb2_150_loan_undrwn_rwa(BigDecimal rrp_smlb2_150_loan_undrwn_rwa) {
		this.rrp_smlb2_150_loan_undrwn_rwa = rrp_smlb2_150_loan_undrwn_rwa;
	}
	public BigDecimal getRrp_smlb2_150_loan_under_ccf_amt() {
		return rrp_smlb2_150_loan_under_ccf_amt;
	}
	public void setRrp_smlb2_150_loan_under_ccf_amt(BigDecimal rrp_smlb2_150_loan_under_ccf_amt) {
		this.rrp_smlb2_150_loan_under_ccf_amt = rrp_smlb2_150_loan_under_ccf_amt;
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
	public BRF95_TABLE2(BigDecimal hni_0_undrawn_bal, BigDecimal hni_0_loan_undrwn_adj_crm,
			BigDecimal hni_0_loan_undrwn_rwa, BigDecimal hni_0_loan_under_ccf_amt, BigDecimal hni_20_undrawn_bal,
			BigDecimal hni_20_loan_undrwn_adj_crm, BigDecimal hni_20_loan_undrwn_rwa,
			BigDecimal hni_20_loan_under_ccf_amt, BigDecimal hni_50_undrawn_bal, BigDecimal hni_50_loan_undrwn_adj_crm,
			BigDecimal hni_50_loan_undrwn_rwa, BigDecimal hni_50_loan_under_ccf_amt, BigDecimal hni_150_undrawn_bal,
			BigDecimal hni_150_loan_undrwn_adj_crm, BigDecimal hni_150_loan_undrwn_rwa,
			BigDecimal hni_150_loan_under_ccf_amt, BigDecimal pdl_0_undrawn_bal, BigDecimal pdl_0_loan_undrwn_adj_crm,
			BigDecimal pdl_0_loan_undrwn_rwa, BigDecimal pdl_0_loan_under_ccf_amt, BigDecimal pdl_20_undrawn_bal,
			BigDecimal pdl_20_loan_undrwn_adj_crm, BigDecimal pdl_20_loan_undrwn_rwa,
			BigDecimal pdl_20_loan_under_ccf_amt, BigDecimal pdl_50_undrawn_bal, BigDecimal pdl_50_loan_undrwn_adj_crm,
			BigDecimal pdl_50_loan_undrwn_rwa, BigDecimal pdl_50_loan_under_ccf_amt, BigDecimal res_0_undrawn_bal,
			BigDecimal res_0_loan_undrwn_adj_crm, BigDecimal res_0_loan_undrwn_rwa, BigDecimal res_0_loan_under_ccf_amt,
			BigDecimal res_20_undrawn_bal, BigDecimal res_20_loan_undrwn_adj_crm, BigDecimal res_20_loan_undrwn_rwa,
			BigDecimal res_20_loan_under_ccf_amt, BigDecimal res_50_undrawn_bal, BigDecimal res_50_loan_undrwn_adj_crm,
			BigDecimal res_50_loan_undrwn_rwa, BigDecimal res_50_loan_under_ccf_amt, BigDecimal res_150_undrawn_bal,
			BigDecimal res_150_loan_undrwn_adj_crm, BigDecimal res_150_loan_undrwn_rwa,
			BigDecimal res_150_loan_under_ccf_amt, BigDecimal rrp_inde1_0_undrawn_bal,
			BigDecimal rrp_inde1_0_loan_undrwn_adj_crm, BigDecimal rrp_inde1_0_loan_undrwn_rwa,
			BigDecimal rrp_inde1_0_loan_under_ccf_amt, BigDecimal rrp_inde1_20_undrawn_bal,
			BigDecimal rrp_inde1_20_loan_undrwn_adj_crm, BigDecimal rrp_inde1_20_loan_undrwn_rwa,
			BigDecimal rrp_inde1_20_loan_under_ccf_amt, BigDecimal rrp_inde1_50_undrawn_bal,
			BigDecimal rrp_inde1_50_loan_undrwn_adj_crm, BigDecimal rrp_inde1_50_loan_undrwn_rwa,
			BigDecimal rrp_inde1_50_loan_under_ccf_amt, BigDecimal rrp_inde1_100_undrawn_bal,
			BigDecimal rrp_inde1_100_loan_undrwn_adj_crm, BigDecimal rrp_inde1_100_loan_undrwn_rwa,
			BigDecimal rrp_inde1_100_loan_under_ccf_amt, BigDecimal rrp_inde1_150_undrawn_bal,
			BigDecimal rrp_inde1_150_loan_undrwn_adj_crm, BigDecimal rrp_inde1_150_loan_undrwn_rwa,
			BigDecimal rrp_inde1_150_loan_under_ccf_amt, BigDecimal rrp_inde2_0_undrawn_bal,
			BigDecimal rrp_inde2_0_loan_undrwn_adj_crm, BigDecimal rrp_inde2_0_loan_undrwn_rwa,
			BigDecimal rrp_inde2_0_loan_under_ccf_amt, BigDecimal rrp_inde2_20_undrawn_bal,
			BigDecimal rrp_inde2_20_loan_undrwn_adj_crm, BigDecimal rrp_inde2_20_loan_undrwn_rwa,
			BigDecimal rrp_inde2_20_loan_under_ccf_amt, BigDecimal rrp_inde2_50_undrawn_bal,
			BigDecimal rrp_inde2_50_loan_undrwn_adj_crm, BigDecimal rrp_inde2_50_loan_undrwn_rwa,
			BigDecimal rrp_inde2_50_loan_under_ccf_amt, BigDecimal rrp_inde2_150_undrawn_bal,
			BigDecimal rrp_inde2_150_loan_undrwn_adj_crm, BigDecimal rrp_inde2_150_loan_undrwn_rwa,
			BigDecimal rrp_inde2_150_loan_under_ccf_amt, BigDecimal rrp_smlb_0_undrawn_bal,
			BigDecimal rrp_smlb_0_loan_undrwn_adj_crm, BigDecimal rrp_smlb_0_loan_undrwn_rwa,
			BigDecimal rrp_smlb_0_loan_under_ccf_amt, BigDecimal rrp_smlb_20_undrawn_bal,
			BigDecimal rrp_smlb_20_loan_undrwn_adj_crm, BigDecimal rrp_smlb_20_loan_undrwn_rwa,
			BigDecimal rrp_smlb_20_loan_under_ccf_amt, BigDecimal rrp_smlb_50_undrawn_bal,
			BigDecimal rrp_smlb_50_loan_undrwn_adj_crm, BigDecimal rrp_smlb_50_loan_undrwn_rwa,
			BigDecimal rrp_smlb_50_loan_under_ccf_amt, BigDecimal rrp_smlb_100_undrawn_bal,
			BigDecimal rrp_smlb_100_loan_undrwn_adj_crm, BigDecimal rrp_smlb_100_loan_undrwn_rwa,
			BigDecimal rrp_smlb_100_loan_under_ccf_amt, BigDecimal rrp_smlb_150_undrawn_bal,
			BigDecimal rrp_smlb_150_loan_undrwn_adj_crm, BigDecimal rrp_smlb_150_loan_undrwn_rwa,
			BigDecimal rrp_smlb_150_loan_under_ccf_amt, BigDecimal rrp_smlb2_0_undrawn_bal,
			BigDecimal rrp_smlb2_0_loan_undrwn_adj_crm, BigDecimal rrp_smlb2_0_loan_undrwn_rwa,
			BigDecimal rrp_smlb2_0_loan_under_ccf_amt, BigDecimal rrp_smlb2_20_undrawn_bal,
			BigDecimal rrp_smlb2_20_loan_undrwn_adj_crm, BigDecimal rrp_smlb2_20_loan_undrwn_rwa,
			BigDecimal rrp_smlb2_20_loan_under_ccf_amt, BigDecimal rrp_smlb2_50_undrawn_bal,
			BigDecimal rrp_smlb2_50_loan_undrwn_adj_crm, BigDecimal rrp_smlb2_50_loan_undrwn_rwa,
			BigDecimal rrp_smlb2_50_loan_under_ccf_amt, BigDecimal rrp_smlb2_100_undrawn_bal,
			BigDecimal rrp_smlb2_100_loan_undrwn_adj_crm, BigDecimal rrp_smlb2_100_loan_undrwn_rwa,
			BigDecimal rrp_smlb2_100_loan_under_ccf_amt, BigDecimal rrp_smlb2_150_undrawn_bal,
			BigDecimal rrp_smlb2_150_loan_undrwn_adj_crm, BigDecimal rrp_smlb2_150_loan_undrwn_rwa,
			BigDecimal rrp_smlb2_150_loan_under_ccf_amt, Date report_submit_date, Date report_date,
			Date report_from_date, Date report_to_date, String report_code, String entity_flg, String modify_flg,
			String del_flg) {
		super();
		this.hni_0_undrawn_bal = hni_0_undrawn_bal;
		this.hni_0_loan_undrwn_adj_crm = hni_0_loan_undrwn_adj_crm;
		this.hni_0_loan_undrwn_rwa = hni_0_loan_undrwn_rwa;
		this.hni_0_loan_under_ccf_amt = hni_0_loan_under_ccf_amt;
		this.hni_20_undrawn_bal = hni_20_undrawn_bal;
		this.hni_20_loan_undrwn_adj_crm = hni_20_loan_undrwn_adj_crm;
		this.hni_20_loan_undrwn_rwa = hni_20_loan_undrwn_rwa;
		this.hni_20_loan_under_ccf_amt = hni_20_loan_under_ccf_amt;
		this.hni_50_undrawn_bal = hni_50_undrawn_bal;
		this.hni_50_loan_undrwn_adj_crm = hni_50_loan_undrwn_adj_crm;
		this.hni_50_loan_undrwn_rwa = hni_50_loan_undrwn_rwa;
		this.hni_50_loan_under_ccf_amt = hni_50_loan_under_ccf_amt;
		this.hni_150_undrawn_bal = hni_150_undrawn_bal;
		this.hni_150_loan_undrwn_adj_crm = hni_150_loan_undrwn_adj_crm;
		this.hni_150_loan_undrwn_rwa = hni_150_loan_undrwn_rwa;
		this.hni_150_loan_under_ccf_amt = hni_150_loan_under_ccf_amt;
		this.pdl_0_undrawn_bal = pdl_0_undrawn_bal;
		this.pdl_0_loan_undrwn_adj_crm = pdl_0_loan_undrwn_adj_crm;
		this.pdl_0_loan_undrwn_rwa = pdl_0_loan_undrwn_rwa;
		this.pdl_0_loan_under_ccf_amt = pdl_0_loan_under_ccf_amt;
		this.pdl_20_undrawn_bal = pdl_20_undrawn_bal;
		this.pdl_20_loan_undrwn_adj_crm = pdl_20_loan_undrwn_adj_crm;
		this.pdl_20_loan_undrwn_rwa = pdl_20_loan_undrwn_rwa;
		this.pdl_20_loan_under_ccf_amt = pdl_20_loan_under_ccf_amt;
		this.pdl_50_undrawn_bal = pdl_50_undrawn_bal;
		this.pdl_50_loan_undrwn_adj_crm = pdl_50_loan_undrwn_adj_crm;
		this.pdl_50_loan_undrwn_rwa = pdl_50_loan_undrwn_rwa;
		this.pdl_50_loan_under_ccf_amt = pdl_50_loan_under_ccf_amt;
		this.res_0_undrawn_bal = res_0_undrawn_bal;
		this.res_0_loan_undrwn_adj_crm = res_0_loan_undrwn_adj_crm;
		this.res_0_loan_undrwn_rwa = res_0_loan_undrwn_rwa;
		this.res_0_loan_under_ccf_amt = res_0_loan_under_ccf_amt;
		this.res_20_undrawn_bal = res_20_undrawn_bal;
		this.res_20_loan_undrwn_adj_crm = res_20_loan_undrwn_adj_crm;
		this.res_20_loan_undrwn_rwa = res_20_loan_undrwn_rwa;
		this.res_20_loan_under_ccf_amt = res_20_loan_under_ccf_amt;
		this.res_50_undrawn_bal = res_50_undrawn_bal;
		this.res_50_loan_undrwn_adj_crm = res_50_loan_undrwn_adj_crm;
		this.res_50_loan_undrwn_rwa = res_50_loan_undrwn_rwa;
		this.res_50_loan_under_ccf_amt = res_50_loan_under_ccf_amt;
		this.res_150_undrawn_bal = res_150_undrawn_bal;
		this.res_150_loan_undrwn_adj_crm = res_150_loan_undrwn_adj_crm;
		this.res_150_loan_undrwn_rwa = res_150_loan_undrwn_rwa;
		this.res_150_loan_under_ccf_amt = res_150_loan_under_ccf_amt;
		this.rrp_inde1_0_undrawn_bal = rrp_inde1_0_undrawn_bal;
		this.rrp_inde1_0_loan_undrwn_adj_crm = rrp_inde1_0_loan_undrwn_adj_crm;
		this.rrp_inde1_0_loan_undrwn_rwa = rrp_inde1_0_loan_undrwn_rwa;
		this.rrp_inde1_0_loan_under_ccf_amt = rrp_inde1_0_loan_under_ccf_amt;
		this.rrp_inde1_20_undrawn_bal = rrp_inde1_20_undrawn_bal;
		this.rrp_inde1_20_loan_undrwn_adj_crm = rrp_inde1_20_loan_undrwn_adj_crm;
		this.rrp_inde1_20_loan_undrwn_rwa = rrp_inde1_20_loan_undrwn_rwa;
		this.rrp_inde1_20_loan_under_ccf_amt = rrp_inde1_20_loan_under_ccf_amt;
		this.rrp_inde1_50_undrawn_bal = rrp_inde1_50_undrawn_bal;
		this.rrp_inde1_50_loan_undrwn_adj_crm = rrp_inde1_50_loan_undrwn_adj_crm;
		this.rrp_inde1_50_loan_undrwn_rwa = rrp_inde1_50_loan_undrwn_rwa;
		this.rrp_inde1_50_loan_under_ccf_amt = rrp_inde1_50_loan_under_ccf_amt;
		this.rrp_inde1_100_undrawn_bal = rrp_inde1_100_undrawn_bal;
		this.rrp_inde1_100_loan_undrwn_adj_crm = rrp_inde1_100_loan_undrwn_adj_crm;
		this.rrp_inde1_100_loan_undrwn_rwa = rrp_inde1_100_loan_undrwn_rwa;
		this.rrp_inde1_100_loan_under_ccf_amt = rrp_inde1_100_loan_under_ccf_amt;
		this.rrp_inde1_150_undrawn_bal = rrp_inde1_150_undrawn_bal;
		this.rrp_inde1_150_loan_undrwn_adj_crm = rrp_inde1_150_loan_undrwn_adj_crm;
		this.rrp_inde1_150_loan_undrwn_rwa = rrp_inde1_150_loan_undrwn_rwa;
		this.rrp_inde1_150_loan_under_ccf_amt = rrp_inde1_150_loan_under_ccf_amt;
		this.rrp_inde2_0_undrawn_bal = rrp_inde2_0_undrawn_bal;
		this.rrp_inde2_0_loan_undrwn_adj_crm = rrp_inde2_0_loan_undrwn_adj_crm;
		this.rrp_inde2_0_loan_undrwn_rwa = rrp_inde2_0_loan_undrwn_rwa;
		this.rrp_inde2_0_loan_under_ccf_amt = rrp_inde2_0_loan_under_ccf_amt;
		this.rrp_inde2_20_undrawn_bal = rrp_inde2_20_undrawn_bal;
		this.rrp_inde2_20_loan_undrwn_adj_crm = rrp_inde2_20_loan_undrwn_adj_crm;
		this.rrp_inde2_20_loan_undrwn_rwa = rrp_inde2_20_loan_undrwn_rwa;
		this.rrp_inde2_20_loan_under_ccf_amt = rrp_inde2_20_loan_under_ccf_amt;
		this.rrp_inde2_50_undrawn_bal = rrp_inde2_50_undrawn_bal;
		this.rrp_inde2_50_loan_undrwn_adj_crm = rrp_inde2_50_loan_undrwn_adj_crm;
		this.rrp_inde2_50_loan_undrwn_rwa = rrp_inde2_50_loan_undrwn_rwa;
		this.rrp_inde2_50_loan_under_ccf_amt = rrp_inde2_50_loan_under_ccf_amt;
		this.rrp_inde2_150_undrawn_bal = rrp_inde2_150_undrawn_bal;
		this.rrp_inde2_150_loan_undrwn_adj_crm = rrp_inde2_150_loan_undrwn_adj_crm;
		this.rrp_inde2_150_loan_undrwn_rwa = rrp_inde2_150_loan_undrwn_rwa;
		this.rrp_inde2_150_loan_under_ccf_amt = rrp_inde2_150_loan_under_ccf_amt;
		this.rrp_smlb_0_undrawn_bal = rrp_smlb_0_undrawn_bal;
		this.rrp_smlb_0_loan_undrwn_adj_crm = rrp_smlb_0_loan_undrwn_adj_crm;
		this.rrp_smlb_0_loan_undrwn_rwa = rrp_smlb_0_loan_undrwn_rwa;
		this.rrp_smlb_0_loan_under_ccf_amt = rrp_smlb_0_loan_under_ccf_amt;
		this.rrp_smlb_20_undrawn_bal = rrp_smlb_20_undrawn_bal;
		this.rrp_smlb_20_loan_undrwn_adj_crm = rrp_smlb_20_loan_undrwn_adj_crm;
		this.rrp_smlb_20_loan_undrwn_rwa = rrp_smlb_20_loan_undrwn_rwa;
		this.rrp_smlb_20_loan_under_ccf_amt = rrp_smlb_20_loan_under_ccf_amt;
		this.rrp_smlb_50_undrawn_bal = rrp_smlb_50_undrawn_bal;
		this.rrp_smlb_50_loan_undrwn_adj_crm = rrp_smlb_50_loan_undrwn_adj_crm;
		this.rrp_smlb_50_loan_undrwn_rwa = rrp_smlb_50_loan_undrwn_rwa;
		this.rrp_smlb_50_loan_under_ccf_amt = rrp_smlb_50_loan_under_ccf_amt;
		this.rrp_smlb_100_undrawn_bal = rrp_smlb_100_undrawn_bal;
		this.rrp_smlb_100_loan_undrwn_adj_crm = rrp_smlb_100_loan_undrwn_adj_crm;
		this.rrp_smlb_100_loan_undrwn_rwa = rrp_smlb_100_loan_undrwn_rwa;
		this.rrp_smlb_100_loan_under_ccf_amt = rrp_smlb_100_loan_under_ccf_amt;
		this.rrp_smlb_150_undrawn_bal = rrp_smlb_150_undrawn_bal;
		this.rrp_smlb_150_loan_undrwn_adj_crm = rrp_smlb_150_loan_undrwn_adj_crm;
		this.rrp_smlb_150_loan_undrwn_rwa = rrp_smlb_150_loan_undrwn_rwa;
		this.rrp_smlb_150_loan_under_ccf_amt = rrp_smlb_150_loan_under_ccf_amt;
		this.rrp_smlb2_0_undrawn_bal = rrp_smlb2_0_undrawn_bal;
		this.rrp_smlb2_0_loan_undrwn_adj_crm = rrp_smlb2_0_loan_undrwn_adj_crm;
		this.rrp_smlb2_0_loan_undrwn_rwa = rrp_smlb2_0_loan_undrwn_rwa;
		this.rrp_smlb2_0_loan_under_ccf_amt = rrp_smlb2_0_loan_under_ccf_amt;
		this.rrp_smlb2_20_undrawn_bal = rrp_smlb2_20_undrawn_bal;
		this.rrp_smlb2_20_loan_undrwn_adj_crm = rrp_smlb2_20_loan_undrwn_adj_crm;
		this.rrp_smlb2_20_loan_undrwn_rwa = rrp_smlb2_20_loan_undrwn_rwa;
		this.rrp_smlb2_20_loan_under_ccf_amt = rrp_smlb2_20_loan_under_ccf_amt;
		this.rrp_smlb2_50_undrawn_bal = rrp_smlb2_50_undrawn_bal;
		this.rrp_smlb2_50_loan_undrwn_adj_crm = rrp_smlb2_50_loan_undrwn_adj_crm;
		this.rrp_smlb2_50_loan_undrwn_rwa = rrp_smlb2_50_loan_undrwn_rwa;
		this.rrp_smlb2_50_loan_under_ccf_amt = rrp_smlb2_50_loan_under_ccf_amt;
		this.rrp_smlb2_100_undrawn_bal = rrp_smlb2_100_undrawn_bal;
		this.rrp_smlb2_100_loan_undrwn_adj_crm = rrp_smlb2_100_loan_undrwn_adj_crm;
		this.rrp_smlb2_100_loan_undrwn_rwa = rrp_smlb2_100_loan_undrwn_rwa;
		this.rrp_smlb2_100_loan_under_ccf_amt = rrp_smlb2_100_loan_under_ccf_amt;
		this.rrp_smlb2_150_undrawn_bal = rrp_smlb2_150_undrawn_bal;
		this.rrp_smlb2_150_loan_undrwn_adj_crm = rrp_smlb2_150_loan_undrwn_adj_crm;
		this.rrp_smlb2_150_loan_undrwn_rwa = rrp_smlb2_150_loan_undrwn_rwa;
		this.rrp_smlb2_150_loan_under_ccf_amt = rrp_smlb2_150_loan_under_ccf_amt;
		this.report_submit_date = report_submit_date;
		this.report_date = report_date;
		this.report_from_date = report_from_date;
		this.report_to_date = report_to_date;
		this.report_code = report_code;
		this.entity_flg = entity_flg;
		this.modify_flg = modify_flg;
		this.del_flg = del_flg;
	}
	public BRF95_TABLE2() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	


}
