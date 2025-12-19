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
@Table(name="BRF95_TABLE6")
public class BRF95_TABLE6 {
	private BigDecimal	b_hni_0_undrwn_balance;
	private BigDecimal	b_hni_0_undrwn_crm;
	private BigDecimal	b_hni_0_undrwn_rwa;
	private BigDecimal	b_hni_0_under_ccf_amt;
	private BigDecimal	b_hni_20_undrwn_balance;
	private BigDecimal	b_hni_20_undrwn_crm;
	private BigDecimal	b_hni_20_undrwn_rwa;
	private BigDecimal	b_hni_20_under_ccf_amt;
	private BigDecimal	b_hni_50_undrwn_balance;
	private BigDecimal	b_hni_50_undrwn_crm;
	private BigDecimal	b_hni_50_undrwn_rwa;
	private BigDecimal	b_hni_50_under_ccf_amt;
	private BigDecimal	b_hni_150_undrwn_balance;
	private BigDecimal	b_hni_150_undrwn_crm;
	private BigDecimal	b_hni_150_undrwn_rwa;
	private BigDecimal	b_hni_150_under_ccf_amt;
	private BigDecimal	b_pdl_0_undrwn_balance;
	private BigDecimal	b_pdl_0_undrwn_crm;
	private BigDecimal	b_pdl_0_undrwn_rwa;
	private BigDecimal	b_pdl_0_under_ccf_amt;
	private BigDecimal	b_pdl_20_undrwn_balance;
	private BigDecimal	b_pdl_20_undrwn_crm;
	private BigDecimal	b_pdl_20_undrwn_rwa;
	private BigDecimal	b_pdl_20_under_ccf_amt;
	private BigDecimal	b_pdl_50_undrwn_balance;
	private BigDecimal	b_pdl_50_undrwn_crm;
	private BigDecimal	b_pdl_50_undrwn_rwa;
	private BigDecimal	b_pdl_50_under_ccf_amt;
	private BigDecimal	b_res_0_undrwn_balance;
	private BigDecimal	b_res_0_undrwn_crm;
	private BigDecimal	b_res_0_undrwn_rwa;
	private BigDecimal	b_res_0_under_ccf_amt;
	private BigDecimal	b_res_20_undrwn_balance;
	private BigDecimal	b_res_20_undrwn_crm;
	private BigDecimal	b_res_20_undrwn_rwa;
	private BigDecimal	b_res_20_under_ccf_amt;
	private BigDecimal	b_res_50_undrwn_balance;
	private BigDecimal	b_res_50_undrwn_crm;
	private BigDecimal	b_res_50_undrwn_rwa;
	private BigDecimal	b_res_50_under_ccf_amt;
	private BigDecimal	b_res_150_undrwn_balance;
	private BigDecimal	b_res_150_undrwn_crm;
	private BigDecimal	b_res_150_undrwn_rwa;
	private BigDecimal	b_res_150_under_ccf_amt;
	private BigDecimal	b_rrp_inde1_0_undrwn_balance;
	private BigDecimal	b_rrp_inde1_0_undrwn_crm;
	private BigDecimal	b_rrp_inde1_0_undrwn_rwa;
	private BigDecimal	b_rrp_inde1_0_under_ccf_amt;
	private BigDecimal	b_rrp_inde1_20_undrwn_balance;
	private BigDecimal	b_rrp_inde1_20_undrwn_crm;
	private BigDecimal	b_rrp_inde1_20_undrwn_rwa;
	private BigDecimal	b_rrp_inde1_20_under_ccf_amt;
	private BigDecimal	b_rrp_inde1_50_undrwn_balance;
	private BigDecimal	b_rrp_inde1_50_undrwn_crm;
	private BigDecimal	b_rrp_inde1_50_undrwn_rwa;
	private BigDecimal	b_rrp_inde1_50_under_ccf_amt;
	private BigDecimal	b_rrp_inde1_100_undrwn_balance;
	private BigDecimal	b_rrp_inde1_100_undrwn_crm;
	private BigDecimal	b_rrp_inde1_100_undrwn_rwa;
	private BigDecimal	b_rrp_inde1_100_under_ccf_amt;
	private BigDecimal	b_rrp_inde1_150_undrwn_balance;
	private BigDecimal	b_rrp_inde1_150_undrwn_crm;
	private BigDecimal	b_rrp_inde1_150_undrwn_rwa;
	private BigDecimal	b_rrp_inde1_150_under_ccf_amt;
	private BigDecimal	b_rrp_inde2_0_undrwn_balance;
	private BigDecimal	b_rrp_inde2_0_undrwn_crm;
	private BigDecimal	b_rrp_inde2_0_undrwn_rwa;
	private BigDecimal	b_rrp_inde2_0_under_ccf_amt;
	private BigDecimal	b_rrp_inde2_20_undrwn_balance;
	private BigDecimal	b_rrp_inde2_20_undrwn_crm;
	private BigDecimal	b_rrp_inde2_20_undrwn_rwa;
	private BigDecimal	b_rrp_inde2_20_under_ccf_amt;
	private BigDecimal	b_rrp_inde2_50_undrwn_balance;
	private BigDecimal	b_rrp_inde2_50_undrwn_crm;
	private BigDecimal	b_rrp_inde2_50_undrwn_rwa;
	private BigDecimal	b_rrp_inde2_50_under_ccf_amt;
	private BigDecimal	b_rrp_inde2_150_undrwn_balance;
	private BigDecimal	b_rrp_inde2_150_undrwn_crm;
	private BigDecimal	b_rrp_inde2_150_undrwn_rwa;
	private BigDecimal	b_rrp_inde2_150_under_ccf_amt;
	private BigDecimal	b_rrp_smlb_0_undrwn_balance;
	private BigDecimal	b_rrp_smlb_0_undrwn_crm;
	private BigDecimal	b_rrp_smlb_0_undrwn_rwa;
	private BigDecimal	b_rrp_smlb_0_under_ccf_amt;
	private BigDecimal	b_rrp_smlb_20_undrwn_balance;
	private BigDecimal	b_rrp_smlb_20_undrwn_crm;
	private BigDecimal	b_rrp_smlb_20_undrwn_rwa;
	private BigDecimal	b_rrp_smlb_20_under_ccf_amt;
	private BigDecimal	b_rrp_smlb_50_undrwn_balance;
	private BigDecimal	b_rrp_smlb_50_undrwn_crm;
	private BigDecimal	b_rrp_smlb_50_undrwn_rwa;
	private BigDecimal	b_rrp_smlb_50_under_ccf_amt;
	private BigDecimal	b_rrp_smlb_100_undrwn_balance;
	private BigDecimal	b_rrp_smlb_100_undrwn_crm;
	private BigDecimal	b_rrp_smlb_100_undrwn_rwa;
	private BigDecimal	b_rrp_smlb_100_under_ccf_amt;
	private BigDecimal	b_rrp_smlb_150_undrwn_balance;
	private BigDecimal	b_rrp_smlb_150_undrwn_crm;
	private BigDecimal	b_rrp_smlb_150_undrwn_rwa;
	private BigDecimal	b_rrp_smlb_150_under_ccf_amt;
	private BigDecimal	b_rrp_smlb2_0_undrwn_balance;
	private BigDecimal	b_rrp_smlb2_0_undrwn_crm;
	private BigDecimal	b_rrp_smlb2_0_undrwn_rwa;
	private BigDecimal	b_rrp_smlb2_0_under_ccf_amt;
	private BigDecimal	b_rrp_smlb2_20_undrwn_balance;
	private BigDecimal	b_rrp_smlb2_20_undrwn_crm;
	private BigDecimal	b_rrp_smlb2_20_undrwn_rwa;
	private BigDecimal	b_rrp_smlb2_20_under_ccf_amt;
	private BigDecimal	b_rrp_smlb2_50_undrwn_balance;
	private BigDecimal	b_rrp_smlb2_50_undrwn_crm;
	private BigDecimal	b_rrp_smlb2_50_undrwn_rwa;
	private BigDecimal	b_rrp_smlb2_50_under_ccf_amt;
	private BigDecimal	b_rrp_smlb2_100_undrwn_balance;
	private BigDecimal	b_rrp_smlb2_100_undrwn_crm;
	private BigDecimal	b_rrp_smlb2_100_undrwn_rwa;
	private BigDecimal	b_rrp_smlb2_100_under_ccf_amt;
	private BigDecimal	b_rrp_smlb2_150_undrwn_balance;
	private BigDecimal	b_rrp_smlb2_150_undrwn_crm;
	private BigDecimal	b_rrp_smlb2_150_undrwn_rwa;
	private BigDecimal	b_rrp_smlb2_150_under_ccf_amt;
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
	public BigDecimal getB_hni_0_undrwn_balance() {
		return b_hni_0_undrwn_balance;
	}
	public void setB_hni_0_undrwn_balance(BigDecimal b_hni_0_undrwn_balance) {
		this.b_hni_0_undrwn_balance = b_hni_0_undrwn_balance;
	}
	public BigDecimal getB_hni_0_undrwn_crm() {
		return b_hni_0_undrwn_crm;
	}
	public void setB_hni_0_undrwn_crm(BigDecimal b_hni_0_undrwn_crm) {
		this.b_hni_0_undrwn_crm = b_hni_0_undrwn_crm;
	}
	public BigDecimal getB_hni_0_undrwn_rwa() {
		return b_hni_0_undrwn_rwa;
	}
	public void setB_hni_0_undrwn_rwa(BigDecimal b_hni_0_undrwn_rwa) {
		this.b_hni_0_undrwn_rwa = b_hni_0_undrwn_rwa;
	}
	public BigDecimal getB_hni_0_under_ccf_amt() {
		return b_hni_0_under_ccf_amt;
	}
	public void setB_hni_0_under_ccf_amt(BigDecimal b_hni_0_under_ccf_amt) {
		this.b_hni_0_under_ccf_amt = b_hni_0_under_ccf_amt;
	}
	public BigDecimal getB_hni_20_undrwn_balance() {
		return b_hni_20_undrwn_balance;
	}
	public void setB_hni_20_undrwn_balance(BigDecimal b_hni_20_undrwn_balance) {
		this.b_hni_20_undrwn_balance = b_hni_20_undrwn_balance;
	}
	public BigDecimal getB_hni_20_undrwn_crm() {
		return b_hni_20_undrwn_crm;
	}
	public void setB_hni_20_undrwn_crm(BigDecimal b_hni_20_undrwn_crm) {
		this.b_hni_20_undrwn_crm = b_hni_20_undrwn_crm;
	}
	public BigDecimal getB_hni_20_undrwn_rwa() {
		return b_hni_20_undrwn_rwa;
	}
	public void setB_hni_20_undrwn_rwa(BigDecimal b_hni_20_undrwn_rwa) {
		this.b_hni_20_undrwn_rwa = b_hni_20_undrwn_rwa;
	}
	public BigDecimal getB_hni_20_under_ccf_amt() {
		return b_hni_20_under_ccf_amt;
	}
	public void setB_hni_20_under_ccf_amt(BigDecimal b_hni_20_under_ccf_amt) {
		this.b_hni_20_under_ccf_amt = b_hni_20_under_ccf_amt;
	}
	public BigDecimal getB_hni_50_undrwn_balance() {
		return b_hni_50_undrwn_balance;
	}
	public void setB_hni_50_undrwn_balance(BigDecimal b_hni_50_undrwn_balance) {
		this.b_hni_50_undrwn_balance = b_hni_50_undrwn_balance;
	}
	public BigDecimal getB_hni_50_undrwn_crm() {
		return b_hni_50_undrwn_crm;
	}
	public void setB_hni_50_undrwn_crm(BigDecimal b_hni_50_undrwn_crm) {
		this.b_hni_50_undrwn_crm = b_hni_50_undrwn_crm;
	}
	public BigDecimal getB_hni_50_undrwn_rwa() {
		return b_hni_50_undrwn_rwa;
	}
	public void setB_hni_50_undrwn_rwa(BigDecimal b_hni_50_undrwn_rwa) {
		this.b_hni_50_undrwn_rwa = b_hni_50_undrwn_rwa;
	}
	public BigDecimal getB_hni_50_under_ccf_amt() {
		return b_hni_50_under_ccf_amt;
	}
	public void setB_hni_50_under_ccf_amt(BigDecimal b_hni_50_under_ccf_amt) {
		this.b_hni_50_under_ccf_amt = b_hni_50_under_ccf_amt;
	}
	public BigDecimal getB_hni_150_undrwn_balance() {
		return b_hni_150_undrwn_balance;
	}
	public void setB_hni_150_undrwn_balance(BigDecimal b_hni_150_undrwn_balance) {
		this.b_hni_150_undrwn_balance = b_hni_150_undrwn_balance;
	}
	public BigDecimal getB_hni_150_undrwn_crm() {
		return b_hni_150_undrwn_crm;
	}
	public void setB_hni_150_undrwn_crm(BigDecimal b_hni_150_undrwn_crm) {
		this.b_hni_150_undrwn_crm = b_hni_150_undrwn_crm;
	}
	public BigDecimal getB_hni_150_undrwn_rwa() {
		return b_hni_150_undrwn_rwa;
	}
	public void setB_hni_150_undrwn_rwa(BigDecimal b_hni_150_undrwn_rwa) {
		this.b_hni_150_undrwn_rwa = b_hni_150_undrwn_rwa;
	}
	public BigDecimal getB_hni_150_under_ccf_amt() {
		return b_hni_150_under_ccf_amt;
	}
	public void setB_hni_150_under_ccf_amt(BigDecimal b_hni_150_under_ccf_amt) {
		this.b_hni_150_under_ccf_amt = b_hni_150_under_ccf_amt;
	}
	public BigDecimal getB_pdl_0_undrwn_balance() {
		return b_pdl_0_undrwn_balance;
	}
	public void setB_pdl_0_undrwn_balance(BigDecimal b_pdl_0_undrwn_balance) {
		this.b_pdl_0_undrwn_balance = b_pdl_0_undrwn_balance;
	}
	public BigDecimal getB_pdl_0_undrwn_crm() {
		return b_pdl_0_undrwn_crm;
	}
	public void setB_pdl_0_undrwn_crm(BigDecimal b_pdl_0_undrwn_crm) {
		this.b_pdl_0_undrwn_crm = b_pdl_0_undrwn_crm;
	}
	public BigDecimal getB_pdl_0_undrwn_rwa() {
		return b_pdl_0_undrwn_rwa;
	}
	public void setB_pdl_0_undrwn_rwa(BigDecimal b_pdl_0_undrwn_rwa) {
		this.b_pdl_0_undrwn_rwa = b_pdl_0_undrwn_rwa;
	}
	public BigDecimal getB_pdl_0_under_ccf_amt() {
		return b_pdl_0_under_ccf_amt;
	}
	public void setB_pdl_0_under_ccf_amt(BigDecimal b_pdl_0_under_ccf_amt) {
		this.b_pdl_0_under_ccf_amt = b_pdl_0_under_ccf_amt;
	}
	public BigDecimal getB_pdl_20_undrwn_balance() {
		return b_pdl_20_undrwn_balance;
	}
	public void setB_pdl_20_undrwn_balance(BigDecimal b_pdl_20_undrwn_balance) {
		this.b_pdl_20_undrwn_balance = b_pdl_20_undrwn_balance;
	}
	public BigDecimal getB_pdl_20_undrwn_crm() {
		return b_pdl_20_undrwn_crm;
	}
	public void setB_pdl_20_undrwn_crm(BigDecimal b_pdl_20_undrwn_crm) {
		this.b_pdl_20_undrwn_crm = b_pdl_20_undrwn_crm;
	}
	public BigDecimal getB_pdl_20_undrwn_rwa() {
		return b_pdl_20_undrwn_rwa;
	}
	public void setB_pdl_20_undrwn_rwa(BigDecimal b_pdl_20_undrwn_rwa) {
		this.b_pdl_20_undrwn_rwa = b_pdl_20_undrwn_rwa;
	}
	public BigDecimal getB_pdl_20_under_ccf_amt() {
		return b_pdl_20_under_ccf_amt;
	}
	public void setB_pdl_20_under_ccf_amt(BigDecimal b_pdl_20_under_ccf_amt) {
		this.b_pdl_20_under_ccf_amt = b_pdl_20_under_ccf_amt;
	}
	public BigDecimal getB_pdl_50_undrwn_balance() {
		return b_pdl_50_undrwn_balance;
	}
	public void setB_pdl_50_undrwn_balance(BigDecimal b_pdl_50_undrwn_balance) {
		this.b_pdl_50_undrwn_balance = b_pdl_50_undrwn_balance;
	}
	public BigDecimal getB_pdl_50_undrwn_crm() {
		return b_pdl_50_undrwn_crm;
	}
	public void setB_pdl_50_undrwn_crm(BigDecimal b_pdl_50_undrwn_crm) {
		this.b_pdl_50_undrwn_crm = b_pdl_50_undrwn_crm;
	}
	public BigDecimal getB_pdl_50_undrwn_rwa() {
		return b_pdl_50_undrwn_rwa;
	}
	public void setB_pdl_50_undrwn_rwa(BigDecimal b_pdl_50_undrwn_rwa) {
		this.b_pdl_50_undrwn_rwa = b_pdl_50_undrwn_rwa;
	}
	public BigDecimal getB_pdl_50_under_ccf_amt() {
		return b_pdl_50_under_ccf_amt;
	}
	public void setB_pdl_50_under_ccf_amt(BigDecimal b_pdl_50_under_ccf_amt) {
		this.b_pdl_50_under_ccf_amt = b_pdl_50_under_ccf_amt;
	}
	public BigDecimal getB_res_0_undrwn_balance() {
		return b_res_0_undrwn_balance;
	}
	public void setB_res_0_undrwn_balance(BigDecimal b_res_0_undrwn_balance) {
		this.b_res_0_undrwn_balance = b_res_0_undrwn_balance;
	}
	public BigDecimal getB_res_0_undrwn_crm() {
		return b_res_0_undrwn_crm;
	}
	public void setB_res_0_undrwn_crm(BigDecimal b_res_0_undrwn_crm) {
		this.b_res_0_undrwn_crm = b_res_0_undrwn_crm;
	}
	public BigDecimal getB_res_0_undrwn_rwa() {
		return b_res_0_undrwn_rwa;
	}
	public void setB_res_0_undrwn_rwa(BigDecimal b_res_0_undrwn_rwa) {
		this.b_res_0_undrwn_rwa = b_res_0_undrwn_rwa;
	}
	public BigDecimal getB_res_0_under_ccf_amt() {
		return b_res_0_under_ccf_amt;
	}
	public void setB_res_0_under_ccf_amt(BigDecimal b_res_0_under_ccf_amt) {
		this.b_res_0_under_ccf_amt = b_res_0_under_ccf_amt;
	}
	public BigDecimal getB_res_20_undrwn_balance() {
		return b_res_20_undrwn_balance;
	}
	public void setB_res_20_undrwn_balance(BigDecimal b_res_20_undrwn_balance) {
		this.b_res_20_undrwn_balance = b_res_20_undrwn_balance;
	}
	public BigDecimal getB_res_20_undrwn_crm() {
		return b_res_20_undrwn_crm;
	}
	public void setB_res_20_undrwn_crm(BigDecimal b_res_20_undrwn_crm) {
		this.b_res_20_undrwn_crm = b_res_20_undrwn_crm;
	}
	public BigDecimal getB_res_20_undrwn_rwa() {
		return b_res_20_undrwn_rwa;
	}
	public void setB_res_20_undrwn_rwa(BigDecimal b_res_20_undrwn_rwa) {
		this.b_res_20_undrwn_rwa = b_res_20_undrwn_rwa;
	}
	public BigDecimal getB_res_20_under_ccf_amt() {
		return b_res_20_under_ccf_amt;
	}
	public void setB_res_20_under_ccf_amt(BigDecimal b_res_20_under_ccf_amt) {
		this.b_res_20_under_ccf_amt = b_res_20_under_ccf_amt;
	}
	public BigDecimal getB_res_50_undrwn_balance() {
		return b_res_50_undrwn_balance;
	}
	public void setB_res_50_undrwn_balance(BigDecimal b_res_50_undrwn_balance) {
		this.b_res_50_undrwn_balance = b_res_50_undrwn_balance;
	}
	public BigDecimal getB_res_50_undrwn_crm() {
		return b_res_50_undrwn_crm;
	}
	public void setB_res_50_undrwn_crm(BigDecimal b_res_50_undrwn_crm) {
		this.b_res_50_undrwn_crm = b_res_50_undrwn_crm;
	}
	public BigDecimal getB_res_50_undrwn_rwa() {
		return b_res_50_undrwn_rwa;
	}
	public void setB_res_50_undrwn_rwa(BigDecimal b_res_50_undrwn_rwa) {
		this.b_res_50_undrwn_rwa = b_res_50_undrwn_rwa;
	}
	public BigDecimal getB_res_50_under_ccf_amt() {
		return b_res_50_under_ccf_amt;
	}
	public void setB_res_50_under_ccf_amt(BigDecimal b_res_50_under_ccf_amt) {
		this.b_res_50_under_ccf_amt = b_res_50_under_ccf_amt;
	}
	public BigDecimal getB_res_150_undrwn_balance() {
		return b_res_150_undrwn_balance;
	}
	public void setB_res_150_undrwn_balance(BigDecimal b_res_150_undrwn_balance) {
		this.b_res_150_undrwn_balance = b_res_150_undrwn_balance;
	}
	public BigDecimal getB_res_150_undrwn_crm() {
		return b_res_150_undrwn_crm;
	}
	public void setB_res_150_undrwn_crm(BigDecimal b_res_150_undrwn_crm) {
		this.b_res_150_undrwn_crm = b_res_150_undrwn_crm;
	}
	public BigDecimal getB_res_150_undrwn_rwa() {
		return b_res_150_undrwn_rwa;
	}
	public void setB_res_150_undrwn_rwa(BigDecimal b_res_150_undrwn_rwa) {
		this.b_res_150_undrwn_rwa = b_res_150_undrwn_rwa;
	}
	public BigDecimal getB_res_150_under_ccf_amt() {
		return b_res_150_under_ccf_amt;
	}
	public void setB_res_150_under_ccf_amt(BigDecimal b_res_150_under_ccf_amt) {
		this.b_res_150_under_ccf_amt = b_res_150_under_ccf_amt;
	}
	public BigDecimal getB_rrp_inde1_0_undrwn_balance() {
		return b_rrp_inde1_0_undrwn_balance;
	}
	public void setB_rrp_inde1_0_undrwn_balance(BigDecimal b_rrp_inde1_0_undrwn_balance) {
		this.b_rrp_inde1_0_undrwn_balance = b_rrp_inde1_0_undrwn_balance;
	}
	public BigDecimal getB_rrp_inde1_0_undrwn_crm() {
		return b_rrp_inde1_0_undrwn_crm;
	}
	public void setB_rrp_inde1_0_undrwn_crm(BigDecimal b_rrp_inde1_0_undrwn_crm) {
		this.b_rrp_inde1_0_undrwn_crm = b_rrp_inde1_0_undrwn_crm;
	}
	public BigDecimal getB_rrp_inde1_0_undrwn_rwa() {
		return b_rrp_inde1_0_undrwn_rwa;
	}
	public void setB_rrp_inde1_0_undrwn_rwa(BigDecimal b_rrp_inde1_0_undrwn_rwa) {
		this.b_rrp_inde1_0_undrwn_rwa = b_rrp_inde1_0_undrwn_rwa;
	}
	public BigDecimal getB_rrp_inde1_0_under_ccf_amt() {
		return b_rrp_inde1_0_under_ccf_amt;
	}
	public void setB_rrp_inde1_0_under_ccf_amt(BigDecimal b_rrp_inde1_0_under_ccf_amt) {
		this.b_rrp_inde1_0_under_ccf_amt = b_rrp_inde1_0_under_ccf_amt;
	}
	public BigDecimal getB_rrp_inde1_20_undrwn_balance() {
		return b_rrp_inde1_20_undrwn_balance;
	}
	public void setB_rrp_inde1_20_undrwn_balance(BigDecimal b_rrp_inde1_20_undrwn_balance) {
		this.b_rrp_inde1_20_undrwn_balance = b_rrp_inde1_20_undrwn_balance;
	}
	public BigDecimal getB_rrp_inde1_20_undrwn_crm() {
		return b_rrp_inde1_20_undrwn_crm;
	}
	public void setB_rrp_inde1_20_undrwn_crm(BigDecimal b_rrp_inde1_20_undrwn_crm) {
		this.b_rrp_inde1_20_undrwn_crm = b_rrp_inde1_20_undrwn_crm;
	}
	public BigDecimal getB_rrp_inde1_20_undrwn_rwa() {
		return b_rrp_inde1_20_undrwn_rwa;
	}
	public void setB_rrp_inde1_20_undrwn_rwa(BigDecimal b_rrp_inde1_20_undrwn_rwa) {
		this.b_rrp_inde1_20_undrwn_rwa = b_rrp_inde1_20_undrwn_rwa;
	}
	public BigDecimal getB_rrp_inde1_20_under_ccf_amt() {
		return b_rrp_inde1_20_under_ccf_amt;
	}
	public void setB_rrp_inde1_20_under_ccf_amt(BigDecimal b_rrp_inde1_20_under_ccf_amt) {
		this.b_rrp_inde1_20_under_ccf_amt = b_rrp_inde1_20_under_ccf_amt;
	}
	public BigDecimal getB_rrp_inde1_50_undrwn_balance() {
		return b_rrp_inde1_50_undrwn_balance;
	}
	public void setB_rrp_inde1_50_undrwn_balance(BigDecimal b_rrp_inde1_50_undrwn_balance) {
		this.b_rrp_inde1_50_undrwn_balance = b_rrp_inde1_50_undrwn_balance;
	}
	public BigDecimal getB_rrp_inde1_50_undrwn_crm() {
		return b_rrp_inde1_50_undrwn_crm;
	}
	public void setB_rrp_inde1_50_undrwn_crm(BigDecimal b_rrp_inde1_50_undrwn_crm) {
		this.b_rrp_inde1_50_undrwn_crm = b_rrp_inde1_50_undrwn_crm;
	}
	public BigDecimal getB_rrp_inde1_50_undrwn_rwa() {
		return b_rrp_inde1_50_undrwn_rwa;
	}
	public void setB_rrp_inde1_50_undrwn_rwa(BigDecimal b_rrp_inde1_50_undrwn_rwa) {
		this.b_rrp_inde1_50_undrwn_rwa = b_rrp_inde1_50_undrwn_rwa;
	}
	public BigDecimal getB_rrp_inde1_50_under_ccf_amt() {
		return b_rrp_inde1_50_under_ccf_amt;
	}
	public void setB_rrp_inde1_50_under_ccf_amt(BigDecimal b_rrp_inde1_50_under_ccf_amt) {
		this.b_rrp_inde1_50_under_ccf_amt = b_rrp_inde1_50_under_ccf_amt;
	}
	public BigDecimal getB_rrp_inde1_100_undrwn_balance() {
		return b_rrp_inde1_100_undrwn_balance;
	}
	public void setB_rrp_inde1_100_undrwn_balance(BigDecimal b_rrp_inde1_100_undrwn_balance) {
		this.b_rrp_inde1_100_undrwn_balance = b_rrp_inde1_100_undrwn_balance;
	}
	public BigDecimal getB_rrp_inde1_100_undrwn_crm() {
		return b_rrp_inde1_100_undrwn_crm;
	}
	public void setB_rrp_inde1_100_undrwn_crm(BigDecimal b_rrp_inde1_100_undrwn_crm) {
		this.b_rrp_inde1_100_undrwn_crm = b_rrp_inde1_100_undrwn_crm;
	}
	public BigDecimal getB_rrp_inde1_100_undrwn_rwa() {
		return b_rrp_inde1_100_undrwn_rwa;
	}
	public void setB_rrp_inde1_100_undrwn_rwa(BigDecimal b_rrp_inde1_100_undrwn_rwa) {
		this.b_rrp_inde1_100_undrwn_rwa = b_rrp_inde1_100_undrwn_rwa;
	}
	public BigDecimal getB_rrp_inde1_100_under_ccf_amt() {
		return b_rrp_inde1_100_under_ccf_amt;
	}
	public void setB_rrp_inde1_100_under_ccf_amt(BigDecimal b_rrp_inde1_100_under_ccf_amt) {
		this.b_rrp_inde1_100_under_ccf_amt = b_rrp_inde1_100_under_ccf_amt;
	}
	public BigDecimal getB_rrp_inde1_150_undrwn_balance() {
		return b_rrp_inde1_150_undrwn_balance;
	}
	public void setB_rrp_inde1_150_undrwn_balance(BigDecimal b_rrp_inde1_150_undrwn_balance) {
		this.b_rrp_inde1_150_undrwn_balance = b_rrp_inde1_150_undrwn_balance;
	}
	public BigDecimal getB_rrp_inde1_150_undrwn_crm() {
		return b_rrp_inde1_150_undrwn_crm;
	}
	public void setB_rrp_inde1_150_undrwn_crm(BigDecimal b_rrp_inde1_150_undrwn_crm) {
		this.b_rrp_inde1_150_undrwn_crm = b_rrp_inde1_150_undrwn_crm;
	}
	public BigDecimal getB_rrp_inde1_150_undrwn_rwa() {
		return b_rrp_inde1_150_undrwn_rwa;
	}
	public void setB_rrp_inde1_150_undrwn_rwa(BigDecimal b_rrp_inde1_150_undrwn_rwa) {
		this.b_rrp_inde1_150_undrwn_rwa = b_rrp_inde1_150_undrwn_rwa;
	}
	public BigDecimal getB_rrp_inde1_150_under_ccf_amt() {
		return b_rrp_inde1_150_under_ccf_amt;
	}
	public void setB_rrp_inde1_150_under_ccf_amt(BigDecimal b_rrp_inde1_150_under_ccf_amt) {
		this.b_rrp_inde1_150_under_ccf_amt = b_rrp_inde1_150_under_ccf_amt;
	}
	public BigDecimal getB_rrp_inde2_0_undrwn_balance() {
		return b_rrp_inde2_0_undrwn_balance;
	}
	public void setB_rrp_inde2_0_undrwn_balance(BigDecimal b_rrp_inde2_0_undrwn_balance) {
		this.b_rrp_inde2_0_undrwn_balance = b_rrp_inde2_0_undrwn_balance;
	}
	public BigDecimal getB_rrp_inde2_0_undrwn_crm() {
		return b_rrp_inde2_0_undrwn_crm;
	}
	public void setB_rrp_inde2_0_undrwn_crm(BigDecimal b_rrp_inde2_0_undrwn_crm) {
		this.b_rrp_inde2_0_undrwn_crm = b_rrp_inde2_0_undrwn_crm;
	}
	public BigDecimal getB_rrp_inde2_0_undrwn_rwa() {
		return b_rrp_inde2_0_undrwn_rwa;
	}
	public void setB_rrp_inde2_0_undrwn_rwa(BigDecimal b_rrp_inde2_0_undrwn_rwa) {
		this.b_rrp_inde2_0_undrwn_rwa = b_rrp_inde2_0_undrwn_rwa;
	}
	public BigDecimal getB_rrp_inde2_0_under_ccf_amt() {
		return b_rrp_inde2_0_under_ccf_amt;
	}
	public void setB_rrp_inde2_0_under_ccf_amt(BigDecimal b_rrp_inde2_0_under_ccf_amt) {
		this.b_rrp_inde2_0_under_ccf_amt = b_rrp_inde2_0_under_ccf_amt;
	}
	public BigDecimal getB_rrp_inde2_20_undrwn_balance() {
		return b_rrp_inde2_20_undrwn_balance;
	}
	public void setB_rrp_inde2_20_undrwn_balance(BigDecimal b_rrp_inde2_20_undrwn_balance) {
		this.b_rrp_inde2_20_undrwn_balance = b_rrp_inde2_20_undrwn_balance;
	}
	public BigDecimal getB_rrp_inde2_20_undrwn_crm() {
		return b_rrp_inde2_20_undrwn_crm;
	}
	public void setB_rrp_inde2_20_undrwn_crm(BigDecimal b_rrp_inde2_20_undrwn_crm) {
		this.b_rrp_inde2_20_undrwn_crm = b_rrp_inde2_20_undrwn_crm;
	}
	public BigDecimal getB_rrp_inde2_20_undrwn_rwa() {
		return b_rrp_inde2_20_undrwn_rwa;
	}
	public void setB_rrp_inde2_20_undrwn_rwa(BigDecimal b_rrp_inde2_20_undrwn_rwa) {
		this.b_rrp_inde2_20_undrwn_rwa = b_rrp_inde2_20_undrwn_rwa;
	}
	public BigDecimal getB_rrp_inde2_20_under_ccf_amt() {
		return b_rrp_inde2_20_under_ccf_amt;
	}
	public void setB_rrp_inde2_20_under_ccf_amt(BigDecimal b_rrp_inde2_20_under_ccf_amt) {
		this.b_rrp_inde2_20_under_ccf_amt = b_rrp_inde2_20_under_ccf_amt;
	}
	public BigDecimal getB_rrp_inde2_50_undrwn_balance() {
		return b_rrp_inde2_50_undrwn_balance;
	}
	public void setB_rrp_inde2_50_undrwn_balance(BigDecimal b_rrp_inde2_50_undrwn_balance) {
		this.b_rrp_inde2_50_undrwn_balance = b_rrp_inde2_50_undrwn_balance;
	}
	public BigDecimal getB_rrp_inde2_50_undrwn_crm() {
		return b_rrp_inde2_50_undrwn_crm;
	}
	public void setB_rrp_inde2_50_undrwn_crm(BigDecimal b_rrp_inde2_50_undrwn_crm) {
		this.b_rrp_inde2_50_undrwn_crm = b_rrp_inde2_50_undrwn_crm;
	}
	public BigDecimal getB_rrp_inde2_50_undrwn_rwa() {
		return b_rrp_inde2_50_undrwn_rwa;
	}
	public void setB_rrp_inde2_50_undrwn_rwa(BigDecimal b_rrp_inde2_50_undrwn_rwa) {
		this.b_rrp_inde2_50_undrwn_rwa = b_rrp_inde2_50_undrwn_rwa;
	}
	public BigDecimal getB_rrp_inde2_50_under_ccf_amt() {
		return b_rrp_inde2_50_under_ccf_amt;
	}
	public void setB_rrp_inde2_50_under_ccf_amt(BigDecimal b_rrp_inde2_50_under_ccf_amt) {
		this.b_rrp_inde2_50_under_ccf_amt = b_rrp_inde2_50_under_ccf_amt;
	}
	public BigDecimal getB_rrp_inde2_150_undrwn_balance() {
		return b_rrp_inde2_150_undrwn_balance;
	}
	public void setB_rrp_inde2_150_undrwn_balance(BigDecimal b_rrp_inde2_150_undrwn_balance) {
		this.b_rrp_inde2_150_undrwn_balance = b_rrp_inde2_150_undrwn_balance;
	}
	public BigDecimal getB_rrp_inde2_150_undrwn_crm() {
		return b_rrp_inde2_150_undrwn_crm;
	}
	public void setB_rrp_inde2_150_undrwn_crm(BigDecimal b_rrp_inde2_150_undrwn_crm) {
		this.b_rrp_inde2_150_undrwn_crm = b_rrp_inde2_150_undrwn_crm;
	}
	public BigDecimal getB_rrp_inde2_150_undrwn_rwa() {
		return b_rrp_inde2_150_undrwn_rwa;
	}
	public void setB_rrp_inde2_150_undrwn_rwa(BigDecimal b_rrp_inde2_150_undrwn_rwa) {
		this.b_rrp_inde2_150_undrwn_rwa = b_rrp_inde2_150_undrwn_rwa;
	}
	public BigDecimal getB_rrp_inde2_150_under_ccf_amt() {
		return b_rrp_inde2_150_under_ccf_amt;
	}
	public void setB_rrp_inde2_150_under_ccf_amt(BigDecimal b_rrp_inde2_150_under_ccf_amt) {
		this.b_rrp_inde2_150_under_ccf_amt = b_rrp_inde2_150_under_ccf_amt;
	}
	public BigDecimal getB_rrp_smlb_0_undrwn_balance() {
		return b_rrp_smlb_0_undrwn_balance;
	}
	public void setB_rrp_smlb_0_undrwn_balance(BigDecimal b_rrp_smlb_0_undrwn_balance) {
		this.b_rrp_smlb_0_undrwn_balance = b_rrp_smlb_0_undrwn_balance;
	}
	public BigDecimal getB_rrp_smlb_0_undrwn_crm() {
		return b_rrp_smlb_0_undrwn_crm;
	}
	public void setB_rrp_smlb_0_undrwn_crm(BigDecimal b_rrp_smlb_0_undrwn_crm) {
		this.b_rrp_smlb_0_undrwn_crm = b_rrp_smlb_0_undrwn_crm;
	}
	public BigDecimal getB_rrp_smlb_0_undrwn_rwa() {
		return b_rrp_smlb_0_undrwn_rwa;
	}
	public void setB_rrp_smlb_0_undrwn_rwa(BigDecimal b_rrp_smlb_0_undrwn_rwa) {
		this.b_rrp_smlb_0_undrwn_rwa = b_rrp_smlb_0_undrwn_rwa;
	}
	public BigDecimal getB_rrp_smlb_0_under_ccf_amt() {
		return b_rrp_smlb_0_under_ccf_amt;
	}
	public void setB_rrp_smlb_0_under_ccf_amt(BigDecimal b_rrp_smlb_0_under_ccf_amt) {
		this.b_rrp_smlb_0_under_ccf_amt = b_rrp_smlb_0_under_ccf_amt;
	}
	public BigDecimal getB_rrp_smlb_20_undrwn_balance() {
		return b_rrp_smlb_20_undrwn_balance;
	}
	public void setB_rrp_smlb_20_undrwn_balance(BigDecimal b_rrp_smlb_20_undrwn_balance) {
		this.b_rrp_smlb_20_undrwn_balance = b_rrp_smlb_20_undrwn_balance;
	}
	public BigDecimal getB_rrp_smlb_20_undrwn_crm() {
		return b_rrp_smlb_20_undrwn_crm;
	}
	public void setB_rrp_smlb_20_undrwn_crm(BigDecimal b_rrp_smlb_20_undrwn_crm) {
		this.b_rrp_smlb_20_undrwn_crm = b_rrp_smlb_20_undrwn_crm;
	}
	public BigDecimal getB_rrp_smlb_20_undrwn_rwa() {
		return b_rrp_smlb_20_undrwn_rwa;
	}
	public void setB_rrp_smlb_20_undrwn_rwa(BigDecimal b_rrp_smlb_20_undrwn_rwa) {
		this.b_rrp_smlb_20_undrwn_rwa = b_rrp_smlb_20_undrwn_rwa;
	}
	public BigDecimal getB_rrp_smlb_20_under_ccf_amt() {
		return b_rrp_smlb_20_under_ccf_amt;
	}
	public void setB_rrp_smlb_20_under_ccf_amt(BigDecimal b_rrp_smlb_20_under_ccf_amt) {
		this.b_rrp_smlb_20_under_ccf_amt = b_rrp_smlb_20_under_ccf_amt;
	}
	public BigDecimal getB_rrp_smlb_50_undrwn_balance() {
		return b_rrp_smlb_50_undrwn_balance;
	}
	public void setB_rrp_smlb_50_undrwn_balance(BigDecimal b_rrp_smlb_50_undrwn_balance) {
		this.b_rrp_smlb_50_undrwn_balance = b_rrp_smlb_50_undrwn_balance;
	}
	public BigDecimal getB_rrp_smlb_50_undrwn_crm() {
		return b_rrp_smlb_50_undrwn_crm;
	}
	public void setB_rrp_smlb_50_undrwn_crm(BigDecimal b_rrp_smlb_50_undrwn_crm) {
		this.b_rrp_smlb_50_undrwn_crm = b_rrp_smlb_50_undrwn_crm;
	}
	public BigDecimal getB_rrp_smlb_50_undrwn_rwa() {
		return b_rrp_smlb_50_undrwn_rwa;
	}
	public void setB_rrp_smlb_50_undrwn_rwa(BigDecimal b_rrp_smlb_50_undrwn_rwa) {
		this.b_rrp_smlb_50_undrwn_rwa = b_rrp_smlb_50_undrwn_rwa;
	}
	public BigDecimal getB_rrp_smlb_50_under_ccf_amt() {
		return b_rrp_smlb_50_under_ccf_amt;
	}
	public void setB_rrp_smlb_50_under_ccf_amt(BigDecimal b_rrp_smlb_50_under_ccf_amt) {
		this.b_rrp_smlb_50_under_ccf_amt = b_rrp_smlb_50_under_ccf_amt;
	}
	public BigDecimal getB_rrp_smlb_100_undrwn_balance() {
		return b_rrp_smlb_100_undrwn_balance;
	}
	public void setB_rrp_smlb_100_undrwn_balance(BigDecimal b_rrp_smlb_100_undrwn_balance) {
		this.b_rrp_smlb_100_undrwn_balance = b_rrp_smlb_100_undrwn_balance;
	}
	public BigDecimal getB_rrp_smlb_100_undrwn_crm() {
		return b_rrp_smlb_100_undrwn_crm;
	}
	public void setB_rrp_smlb_100_undrwn_crm(BigDecimal b_rrp_smlb_100_undrwn_crm) {
		this.b_rrp_smlb_100_undrwn_crm = b_rrp_smlb_100_undrwn_crm;
	}
	public BigDecimal getB_rrp_smlb_100_undrwn_rwa() {
		return b_rrp_smlb_100_undrwn_rwa;
	}
	public void setB_rrp_smlb_100_undrwn_rwa(BigDecimal b_rrp_smlb_100_undrwn_rwa) {
		this.b_rrp_smlb_100_undrwn_rwa = b_rrp_smlb_100_undrwn_rwa;
	}
	public BigDecimal getB_rrp_smlb_100_under_ccf_amt() {
		return b_rrp_smlb_100_under_ccf_amt;
	}
	public void setB_rrp_smlb_100_under_ccf_amt(BigDecimal b_rrp_smlb_100_under_ccf_amt) {
		this.b_rrp_smlb_100_under_ccf_amt = b_rrp_smlb_100_under_ccf_amt;
	}
	public BigDecimal getB_rrp_smlb_150_undrwn_balance() {
		return b_rrp_smlb_150_undrwn_balance;
	}
	public void setB_rrp_smlb_150_undrwn_balance(BigDecimal b_rrp_smlb_150_undrwn_balance) {
		this.b_rrp_smlb_150_undrwn_balance = b_rrp_smlb_150_undrwn_balance;
	}
	public BigDecimal getB_rrp_smlb_150_undrwn_crm() {
		return b_rrp_smlb_150_undrwn_crm;
	}
	public void setB_rrp_smlb_150_undrwn_crm(BigDecimal b_rrp_smlb_150_undrwn_crm) {
		this.b_rrp_smlb_150_undrwn_crm = b_rrp_smlb_150_undrwn_crm;
	}
	public BigDecimal getB_rrp_smlb_150_undrwn_rwa() {
		return b_rrp_smlb_150_undrwn_rwa;
	}
	public void setB_rrp_smlb_150_undrwn_rwa(BigDecimal b_rrp_smlb_150_undrwn_rwa) {
		this.b_rrp_smlb_150_undrwn_rwa = b_rrp_smlb_150_undrwn_rwa;
	}
	public BigDecimal getB_rrp_smlb_150_under_ccf_amt() {
		return b_rrp_smlb_150_under_ccf_amt;
	}
	public void setB_rrp_smlb_150_under_ccf_amt(BigDecimal b_rrp_smlb_150_under_ccf_amt) {
		this.b_rrp_smlb_150_under_ccf_amt = b_rrp_smlb_150_under_ccf_amt;
	}
	public BigDecimal getB_rrp_smlb2_0_undrwn_balance() {
		return b_rrp_smlb2_0_undrwn_balance;
	}
	public void setB_rrp_smlb2_0_undrwn_balance(BigDecimal b_rrp_smlb2_0_undrwn_balance) {
		this.b_rrp_smlb2_0_undrwn_balance = b_rrp_smlb2_0_undrwn_balance;
	}
	public BigDecimal getB_rrp_smlb2_0_undrwn_crm() {
		return b_rrp_smlb2_0_undrwn_crm;
	}
	public void setB_rrp_smlb2_0_undrwn_crm(BigDecimal b_rrp_smlb2_0_undrwn_crm) {
		this.b_rrp_smlb2_0_undrwn_crm = b_rrp_smlb2_0_undrwn_crm;
	}
	public BigDecimal getB_rrp_smlb2_0_undrwn_rwa() {
		return b_rrp_smlb2_0_undrwn_rwa;
	}
	public void setB_rrp_smlb2_0_undrwn_rwa(BigDecimal b_rrp_smlb2_0_undrwn_rwa) {
		this.b_rrp_smlb2_0_undrwn_rwa = b_rrp_smlb2_0_undrwn_rwa;
	}
	public BigDecimal getB_rrp_smlb2_0_under_ccf_amt() {
		return b_rrp_smlb2_0_under_ccf_amt;
	}
	public void setB_rrp_smlb2_0_under_ccf_amt(BigDecimal b_rrp_smlb2_0_under_ccf_amt) {
		this.b_rrp_smlb2_0_under_ccf_amt = b_rrp_smlb2_0_under_ccf_amt;
	}
	public BigDecimal getB_rrp_smlb2_20_undrwn_balance() {
		return b_rrp_smlb2_20_undrwn_balance;
	}
	public void setB_rrp_smlb2_20_undrwn_balance(BigDecimal b_rrp_smlb2_20_undrwn_balance) {
		this.b_rrp_smlb2_20_undrwn_balance = b_rrp_smlb2_20_undrwn_balance;
	}
	public BigDecimal getB_rrp_smlb2_20_undrwn_crm() {
		return b_rrp_smlb2_20_undrwn_crm;
	}
	public void setB_rrp_smlb2_20_undrwn_crm(BigDecimal b_rrp_smlb2_20_undrwn_crm) {
		this.b_rrp_smlb2_20_undrwn_crm = b_rrp_smlb2_20_undrwn_crm;
	}
	public BigDecimal getB_rrp_smlb2_20_undrwn_rwa() {
		return b_rrp_smlb2_20_undrwn_rwa;
	}
	public void setB_rrp_smlb2_20_undrwn_rwa(BigDecimal b_rrp_smlb2_20_undrwn_rwa) {
		this.b_rrp_smlb2_20_undrwn_rwa = b_rrp_smlb2_20_undrwn_rwa;
	}
	public BigDecimal getB_rrp_smlb2_20_under_ccf_amt() {
		return b_rrp_smlb2_20_under_ccf_amt;
	}
	public void setB_rrp_smlb2_20_under_ccf_amt(BigDecimal b_rrp_smlb2_20_under_ccf_amt) {
		this.b_rrp_smlb2_20_under_ccf_amt = b_rrp_smlb2_20_under_ccf_amt;
	}
	public BigDecimal getB_rrp_smlb2_50_undrwn_balance() {
		return b_rrp_smlb2_50_undrwn_balance;
	}
	public void setB_rrp_smlb2_50_undrwn_balance(BigDecimal b_rrp_smlb2_50_undrwn_balance) {
		this.b_rrp_smlb2_50_undrwn_balance = b_rrp_smlb2_50_undrwn_balance;
	}
	public BigDecimal getB_rrp_smlb2_50_undrwn_crm() {
		return b_rrp_smlb2_50_undrwn_crm;
	}
	public void setB_rrp_smlb2_50_undrwn_crm(BigDecimal b_rrp_smlb2_50_undrwn_crm) {
		this.b_rrp_smlb2_50_undrwn_crm = b_rrp_smlb2_50_undrwn_crm;
	}
	public BigDecimal getB_rrp_smlb2_50_undrwn_rwa() {
		return b_rrp_smlb2_50_undrwn_rwa;
	}
	public void setB_rrp_smlb2_50_undrwn_rwa(BigDecimal b_rrp_smlb2_50_undrwn_rwa) {
		this.b_rrp_smlb2_50_undrwn_rwa = b_rrp_smlb2_50_undrwn_rwa;
	}
	public BigDecimal getB_rrp_smlb2_50_under_ccf_amt() {
		return b_rrp_smlb2_50_under_ccf_amt;
	}
	public void setB_rrp_smlb2_50_under_ccf_amt(BigDecimal b_rrp_smlb2_50_under_ccf_amt) {
		this.b_rrp_smlb2_50_under_ccf_amt = b_rrp_smlb2_50_under_ccf_amt;
	}
	public BigDecimal getB_rrp_smlb2_100_undrwn_balance() {
		return b_rrp_smlb2_100_undrwn_balance;
	}
	public void setB_rrp_smlb2_100_undrwn_balance(BigDecimal b_rrp_smlb2_100_undrwn_balance) {
		this.b_rrp_smlb2_100_undrwn_balance = b_rrp_smlb2_100_undrwn_balance;
	}
	public BigDecimal getB_rrp_smlb2_100_undrwn_crm() {
		return b_rrp_smlb2_100_undrwn_crm;
	}
	public void setB_rrp_smlb2_100_undrwn_crm(BigDecimal b_rrp_smlb2_100_undrwn_crm) {
		this.b_rrp_smlb2_100_undrwn_crm = b_rrp_smlb2_100_undrwn_crm;
	}
	public BigDecimal getB_rrp_smlb2_100_undrwn_rwa() {
		return b_rrp_smlb2_100_undrwn_rwa;
	}
	public void setB_rrp_smlb2_100_undrwn_rwa(BigDecimal b_rrp_smlb2_100_undrwn_rwa) {
		this.b_rrp_smlb2_100_undrwn_rwa = b_rrp_smlb2_100_undrwn_rwa;
	}
	public BigDecimal getB_rrp_smlb2_100_under_ccf_amt() {
		return b_rrp_smlb2_100_under_ccf_amt;
	}
	public void setB_rrp_smlb2_100_under_ccf_amt(BigDecimal b_rrp_smlb2_100_under_ccf_amt) {
		this.b_rrp_smlb2_100_under_ccf_amt = b_rrp_smlb2_100_under_ccf_amt;
	}
	public BigDecimal getB_rrp_smlb2_150_undrwn_balance() {
		return b_rrp_smlb2_150_undrwn_balance;
	}
	public void setB_rrp_smlb2_150_undrwn_balance(BigDecimal b_rrp_smlb2_150_undrwn_balance) {
		this.b_rrp_smlb2_150_undrwn_balance = b_rrp_smlb2_150_undrwn_balance;
	}
	public BigDecimal getB_rrp_smlb2_150_undrwn_crm() {
		return b_rrp_smlb2_150_undrwn_crm;
	}
	public void setB_rrp_smlb2_150_undrwn_crm(BigDecimal b_rrp_smlb2_150_undrwn_crm) {
		this.b_rrp_smlb2_150_undrwn_crm = b_rrp_smlb2_150_undrwn_crm;
	}
	public BigDecimal getB_rrp_smlb2_150_undrwn_rwa() {
		return b_rrp_smlb2_150_undrwn_rwa;
	}
	public void setB_rrp_smlb2_150_undrwn_rwa(BigDecimal b_rrp_smlb2_150_undrwn_rwa) {
		this.b_rrp_smlb2_150_undrwn_rwa = b_rrp_smlb2_150_undrwn_rwa;
	}
	public BigDecimal getB_rrp_smlb2_150_under_ccf_amt() {
		return b_rrp_smlb2_150_under_ccf_amt;
	}
	public void setB_rrp_smlb2_150_under_ccf_amt(BigDecimal b_rrp_smlb2_150_under_ccf_amt) {
		this.b_rrp_smlb2_150_under_ccf_amt = b_rrp_smlb2_150_under_ccf_amt;
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
	public BRF95_TABLE6(BigDecimal b_hni_0_undrwn_balance, BigDecimal b_hni_0_undrwn_crm, BigDecimal b_hni_0_undrwn_rwa,
			BigDecimal b_hni_0_under_ccf_amt, BigDecimal b_hni_20_undrwn_balance, BigDecimal b_hni_20_undrwn_crm,
			BigDecimal b_hni_20_undrwn_rwa, BigDecimal b_hni_20_under_ccf_amt, BigDecimal b_hni_50_undrwn_balance,
			BigDecimal b_hni_50_undrwn_crm, BigDecimal b_hni_50_undrwn_rwa, BigDecimal b_hni_50_under_ccf_amt,
			BigDecimal b_hni_150_undrwn_balance, BigDecimal b_hni_150_undrwn_crm, BigDecimal b_hni_150_undrwn_rwa,
			BigDecimal b_hni_150_under_ccf_amt, BigDecimal b_pdl_0_undrwn_balance, BigDecimal b_pdl_0_undrwn_crm,
			BigDecimal b_pdl_0_undrwn_rwa, BigDecimal b_pdl_0_under_ccf_amt, BigDecimal b_pdl_20_undrwn_balance,
			BigDecimal b_pdl_20_undrwn_crm, BigDecimal b_pdl_20_undrwn_rwa, BigDecimal b_pdl_20_under_ccf_amt,
			BigDecimal b_pdl_50_undrwn_balance, BigDecimal b_pdl_50_undrwn_crm, BigDecimal b_pdl_50_undrwn_rwa,
			BigDecimal b_pdl_50_under_ccf_amt, BigDecimal b_res_0_undrwn_balance, BigDecimal b_res_0_undrwn_crm,
			BigDecimal b_res_0_undrwn_rwa, BigDecimal b_res_0_under_ccf_amt, BigDecimal b_res_20_undrwn_balance,
			BigDecimal b_res_20_undrwn_crm, BigDecimal b_res_20_undrwn_rwa, BigDecimal b_res_20_under_ccf_amt,
			BigDecimal b_res_50_undrwn_balance, BigDecimal b_res_50_undrwn_crm, BigDecimal b_res_50_undrwn_rwa,
			BigDecimal b_res_50_under_ccf_amt, BigDecimal b_res_150_undrwn_balance, BigDecimal b_res_150_undrwn_crm,
			BigDecimal b_res_150_undrwn_rwa, BigDecimal b_res_150_under_ccf_amt,
			BigDecimal b_rrp_inde1_0_undrwn_balance, BigDecimal b_rrp_inde1_0_undrwn_crm,
			BigDecimal b_rrp_inde1_0_undrwn_rwa, BigDecimal b_rrp_inde1_0_under_ccf_amt,
			BigDecimal b_rrp_inde1_20_undrwn_balance, BigDecimal b_rrp_inde1_20_undrwn_crm,
			BigDecimal b_rrp_inde1_20_undrwn_rwa, BigDecimal b_rrp_inde1_20_under_ccf_amt,
			BigDecimal b_rrp_inde1_50_undrwn_balance, BigDecimal b_rrp_inde1_50_undrwn_crm,
			BigDecimal b_rrp_inde1_50_undrwn_rwa, BigDecimal b_rrp_inde1_50_under_ccf_amt,
			BigDecimal b_rrp_inde1_100_undrwn_balance, BigDecimal b_rrp_inde1_100_undrwn_crm,
			BigDecimal b_rrp_inde1_100_undrwn_rwa, BigDecimal b_rrp_inde1_100_under_ccf_amt,
			BigDecimal b_rrp_inde1_150_undrwn_balance, BigDecimal b_rrp_inde1_150_undrwn_crm,
			BigDecimal b_rrp_inde1_150_undrwn_rwa, BigDecimal b_rrp_inde1_150_under_ccf_amt,
			BigDecimal b_rrp_inde2_0_undrwn_balance, BigDecimal b_rrp_inde2_0_undrwn_crm,
			BigDecimal b_rrp_inde2_0_undrwn_rwa, BigDecimal b_rrp_inde2_0_under_ccf_amt,
			BigDecimal b_rrp_inde2_20_undrwn_balance, BigDecimal b_rrp_inde2_20_undrwn_crm,
			BigDecimal b_rrp_inde2_20_undrwn_rwa, BigDecimal b_rrp_inde2_20_under_ccf_amt,
			BigDecimal b_rrp_inde2_50_undrwn_balance, BigDecimal b_rrp_inde2_50_undrwn_crm,
			BigDecimal b_rrp_inde2_50_undrwn_rwa, BigDecimal b_rrp_inde2_50_under_ccf_amt,
			BigDecimal b_rrp_inde2_150_undrwn_balance, BigDecimal b_rrp_inde2_150_undrwn_crm,
			BigDecimal b_rrp_inde2_150_undrwn_rwa, BigDecimal b_rrp_inde2_150_under_ccf_amt,
			BigDecimal b_rrp_smlb_0_undrwn_balance, BigDecimal b_rrp_smlb_0_undrwn_crm,
			BigDecimal b_rrp_smlb_0_undrwn_rwa, BigDecimal b_rrp_smlb_0_under_ccf_amt,
			BigDecimal b_rrp_smlb_20_undrwn_balance, BigDecimal b_rrp_smlb_20_undrwn_crm,
			BigDecimal b_rrp_smlb_20_undrwn_rwa, BigDecimal b_rrp_smlb_20_under_ccf_amt,
			BigDecimal b_rrp_smlb_50_undrwn_balance, BigDecimal b_rrp_smlb_50_undrwn_crm,
			BigDecimal b_rrp_smlb_50_undrwn_rwa, BigDecimal b_rrp_smlb_50_under_ccf_amt,
			BigDecimal b_rrp_smlb_100_undrwn_balance, BigDecimal b_rrp_smlb_100_undrwn_crm,
			BigDecimal b_rrp_smlb_100_undrwn_rwa, BigDecimal b_rrp_smlb_100_under_ccf_amt,
			BigDecimal b_rrp_smlb_150_undrwn_balance, BigDecimal b_rrp_smlb_150_undrwn_crm,
			BigDecimal b_rrp_smlb_150_undrwn_rwa, BigDecimal b_rrp_smlb_150_under_ccf_amt,
			BigDecimal b_rrp_smlb2_0_undrwn_balance, BigDecimal b_rrp_smlb2_0_undrwn_crm,
			BigDecimal b_rrp_smlb2_0_undrwn_rwa, BigDecimal b_rrp_smlb2_0_under_ccf_amt,
			BigDecimal b_rrp_smlb2_20_undrwn_balance, BigDecimal b_rrp_smlb2_20_undrwn_crm,
			BigDecimal b_rrp_smlb2_20_undrwn_rwa, BigDecimal b_rrp_smlb2_20_under_ccf_amt,
			BigDecimal b_rrp_smlb2_50_undrwn_balance, BigDecimal b_rrp_smlb2_50_undrwn_crm,
			BigDecimal b_rrp_smlb2_50_undrwn_rwa, BigDecimal b_rrp_smlb2_50_under_ccf_amt,
			BigDecimal b_rrp_smlb2_100_undrwn_balance, BigDecimal b_rrp_smlb2_100_undrwn_crm,
			BigDecimal b_rrp_smlb2_100_undrwn_rwa, BigDecimal b_rrp_smlb2_100_under_ccf_amt,
			BigDecimal b_rrp_smlb2_150_undrwn_balance, BigDecimal b_rrp_smlb2_150_undrwn_crm,
			BigDecimal b_rrp_smlb2_150_undrwn_rwa, BigDecimal b_rrp_smlb2_150_under_ccf_amt, Date report_submit_date,
			Date report_date, Date report_from_date, Date report_to_date, String report_code, String entity_flg,
			String modify_flg, String del_flg) {
		super();
		this.b_hni_0_undrwn_balance = b_hni_0_undrwn_balance;
		this.b_hni_0_undrwn_crm = b_hni_0_undrwn_crm;
		this.b_hni_0_undrwn_rwa = b_hni_0_undrwn_rwa;
		this.b_hni_0_under_ccf_amt = b_hni_0_under_ccf_amt;
		this.b_hni_20_undrwn_balance = b_hni_20_undrwn_balance;
		this.b_hni_20_undrwn_crm = b_hni_20_undrwn_crm;
		this.b_hni_20_undrwn_rwa = b_hni_20_undrwn_rwa;
		this.b_hni_20_under_ccf_amt = b_hni_20_under_ccf_amt;
		this.b_hni_50_undrwn_balance = b_hni_50_undrwn_balance;
		this.b_hni_50_undrwn_crm = b_hni_50_undrwn_crm;
		this.b_hni_50_undrwn_rwa = b_hni_50_undrwn_rwa;
		this.b_hni_50_under_ccf_amt = b_hni_50_under_ccf_amt;
		this.b_hni_150_undrwn_balance = b_hni_150_undrwn_balance;
		this.b_hni_150_undrwn_crm = b_hni_150_undrwn_crm;
		this.b_hni_150_undrwn_rwa = b_hni_150_undrwn_rwa;
		this.b_hni_150_under_ccf_amt = b_hni_150_under_ccf_amt;
		this.b_pdl_0_undrwn_balance = b_pdl_0_undrwn_balance;
		this.b_pdl_0_undrwn_crm = b_pdl_0_undrwn_crm;
		this.b_pdl_0_undrwn_rwa = b_pdl_0_undrwn_rwa;
		this.b_pdl_0_under_ccf_amt = b_pdl_0_under_ccf_amt;
		this.b_pdl_20_undrwn_balance = b_pdl_20_undrwn_balance;
		this.b_pdl_20_undrwn_crm = b_pdl_20_undrwn_crm;
		this.b_pdl_20_undrwn_rwa = b_pdl_20_undrwn_rwa;
		this.b_pdl_20_under_ccf_amt = b_pdl_20_under_ccf_amt;
		this.b_pdl_50_undrwn_balance = b_pdl_50_undrwn_balance;
		this.b_pdl_50_undrwn_crm = b_pdl_50_undrwn_crm;
		this.b_pdl_50_undrwn_rwa = b_pdl_50_undrwn_rwa;
		this.b_pdl_50_under_ccf_amt = b_pdl_50_under_ccf_amt;
		this.b_res_0_undrwn_balance = b_res_0_undrwn_balance;
		this.b_res_0_undrwn_crm = b_res_0_undrwn_crm;
		this.b_res_0_undrwn_rwa = b_res_0_undrwn_rwa;
		this.b_res_0_under_ccf_amt = b_res_0_under_ccf_amt;
		this.b_res_20_undrwn_balance = b_res_20_undrwn_balance;
		this.b_res_20_undrwn_crm = b_res_20_undrwn_crm;
		this.b_res_20_undrwn_rwa = b_res_20_undrwn_rwa;
		this.b_res_20_under_ccf_amt = b_res_20_under_ccf_amt;
		this.b_res_50_undrwn_balance = b_res_50_undrwn_balance;
		this.b_res_50_undrwn_crm = b_res_50_undrwn_crm;
		this.b_res_50_undrwn_rwa = b_res_50_undrwn_rwa;
		this.b_res_50_under_ccf_amt = b_res_50_under_ccf_amt;
		this.b_res_150_undrwn_balance = b_res_150_undrwn_balance;
		this.b_res_150_undrwn_crm = b_res_150_undrwn_crm;
		this.b_res_150_undrwn_rwa = b_res_150_undrwn_rwa;
		this.b_res_150_under_ccf_amt = b_res_150_under_ccf_amt;
		this.b_rrp_inde1_0_undrwn_balance = b_rrp_inde1_0_undrwn_balance;
		this.b_rrp_inde1_0_undrwn_crm = b_rrp_inde1_0_undrwn_crm;
		this.b_rrp_inde1_0_undrwn_rwa = b_rrp_inde1_0_undrwn_rwa;
		this.b_rrp_inde1_0_under_ccf_amt = b_rrp_inde1_0_under_ccf_amt;
		this.b_rrp_inde1_20_undrwn_balance = b_rrp_inde1_20_undrwn_balance;
		this.b_rrp_inde1_20_undrwn_crm = b_rrp_inde1_20_undrwn_crm;
		this.b_rrp_inde1_20_undrwn_rwa = b_rrp_inde1_20_undrwn_rwa;
		this.b_rrp_inde1_20_under_ccf_amt = b_rrp_inde1_20_under_ccf_amt;
		this.b_rrp_inde1_50_undrwn_balance = b_rrp_inde1_50_undrwn_balance;
		this.b_rrp_inde1_50_undrwn_crm = b_rrp_inde1_50_undrwn_crm;
		this.b_rrp_inde1_50_undrwn_rwa = b_rrp_inde1_50_undrwn_rwa;
		this.b_rrp_inde1_50_under_ccf_amt = b_rrp_inde1_50_under_ccf_amt;
		this.b_rrp_inde1_100_undrwn_balance = b_rrp_inde1_100_undrwn_balance;
		this.b_rrp_inde1_100_undrwn_crm = b_rrp_inde1_100_undrwn_crm;
		this.b_rrp_inde1_100_undrwn_rwa = b_rrp_inde1_100_undrwn_rwa;
		this.b_rrp_inde1_100_under_ccf_amt = b_rrp_inde1_100_under_ccf_amt;
		this.b_rrp_inde1_150_undrwn_balance = b_rrp_inde1_150_undrwn_balance;
		this.b_rrp_inde1_150_undrwn_crm = b_rrp_inde1_150_undrwn_crm;
		this.b_rrp_inde1_150_undrwn_rwa = b_rrp_inde1_150_undrwn_rwa;
		this.b_rrp_inde1_150_under_ccf_amt = b_rrp_inde1_150_under_ccf_amt;
		this.b_rrp_inde2_0_undrwn_balance = b_rrp_inde2_0_undrwn_balance;
		this.b_rrp_inde2_0_undrwn_crm = b_rrp_inde2_0_undrwn_crm;
		this.b_rrp_inde2_0_undrwn_rwa = b_rrp_inde2_0_undrwn_rwa;
		this.b_rrp_inde2_0_under_ccf_amt = b_rrp_inde2_0_under_ccf_amt;
		this.b_rrp_inde2_20_undrwn_balance = b_rrp_inde2_20_undrwn_balance;
		this.b_rrp_inde2_20_undrwn_crm = b_rrp_inde2_20_undrwn_crm;
		this.b_rrp_inde2_20_undrwn_rwa = b_rrp_inde2_20_undrwn_rwa;
		this.b_rrp_inde2_20_under_ccf_amt = b_rrp_inde2_20_under_ccf_amt;
		this.b_rrp_inde2_50_undrwn_balance = b_rrp_inde2_50_undrwn_balance;
		this.b_rrp_inde2_50_undrwn_crm = b_rrp_inde2_50_undrwn_crm;
		this.b_rrp_inde2_50_undrwn_rwa = b_rrp_inde2_50_undrwn_rwa;
		this.b_rrp_inde2_50_under_ccf_amt = b_rrp_inde2_50_under_ccf_amt;
		this.b_rrp_inde2_150_undrwn_balance = b_rrp_inde2_150_undrwn_balance;
		this.b_rrp_inde2_150_undrwn_crm = b_rrp_inde2_150_undrwn_crm;
		this.b_rrp_inde2_150_undrwn_rwa = b_rrp_inde2_150_undrwn_rwa;
		this.b_rrp_inde2_150_under_ccf_amt = b_rrp_inde2_150_under_ccf_amt;
		this.b_rrp_smlb_0_undrwn_balance = b_rrp_smlb_0_undrwn_balance;
		this.b_rrp_smlb_0_undrwn_crm = b_rrp_smlb_0_undrwn_crm;
		this.b_rrp_smlb_0_undrwn_rwa = b_rrp_smlb_0_undrwn_rwa;
		this.b_rrp_smlb_0_under_ccf_amt = b_rrp_smlb_0_under_ccf_amt;
		this.b_rrp_smlb_20_undrwn_balance = b_rrp_smlb_20_undrwn_balance;
		this.b_rrp_smlb_20_undrwn_crm = b_rrp_smlb_20_undrwn_crm;
		this.b_rrp_smlb_20_undrwn_rwa = b_rrp_smlb_20_undrwn_rwa;
		this.b_rrp_smlb_20_under_ccf_amt = b_rrp_smlb_20_under_ccf_amt;
		this.b_rrp_smlb_50_undrwn_balance = b_rrp_smlb_50_undrwn_balance;
		this.b_rrp_smlb_50_undrwn_crm = b_rrp_smlb_50_undrwn_crm;
		this.b_rrp_smlb_50_undrwn_rwa = b_rrp_smlb_50_undrwn_rwa;
		this.b_rrp_smlb_50_under_ccf_amt = b_rrp_smlb_50_under_ccf_amt;
		this.b_rrp_smlb_100_undrwn_balance = b_rrp_smlb_100_undrwn_balance;
		this.b_rrp_smlb_100_undrwn_crm = b_rrp_smlb_100_undrwn_crm;
		this.b_rrp_smlb_100_undrwn_rwa = b_rrp_smlb_100_undrwn_rwa;
		this.b_rrp_smlb_100_under_ccf_amt = b_rrp_smlb_100_under_ccf_amt;
		this.b_rrp_smlb_150_undrwn_balance = b_rrp_smlb_150_undrwn_balance;
		this.b_rrp_smlb_150_undrwn_crm = b_rrp_smlb_150_undrwn_crm;
		this.b_rrp_smlb_150_undrwn_rwa = b_rrp_smlb_150_undrwn_rwa;
		this.b_rrp_smlb_150_under_ccf_amt = b_rrp_smlb_150_under_ccf_amt;
		this.b_rrp_smlb2_0_undrwn_balance = b_rrp_smlb2_0_undrwn_balance;
		this.b_rrp_smlb2_0_undrwn_crm = b_rrp_smlb2_0_undrwn_crm;
		this.b_rrp_smlb2_0_undrwn_rwa = b_rrp_smlb2_0_undrwn_rwa;
		this.b_rrp_smlb2_0_under_ccf_amt = b_rrp_smlb2_0_under_ccf_amt;
		this.b_rrp_smlb2_20_undrwn_balance = b_rrp_smlb2_20_undrwn_balance;
		this.b_rrp_smlb2_20_undrwn_crm = b_rrp_smlb2_20_undrwn_crm;
		this.b_rrp_smlb2_20_undrwn_rwa = b_rrp_smlb2_20_undrwn_rwa;
		this.b_rrp_smlb2_20_under_ccf_amt = b_rrp_smlb2_20_under_ccf_amt;
		this.b_rrp_smlb2_50_undrwn_balance = b_rrp_smlb2_50_undrwn_balance;
		this.b_rrp_smlb2_50_undrwn_crm = b_rrp_smlb2_50_undrwn_crm;
		this.b_rrp_smlb2_50_undrwn_rwa = b_rrp_smlb2_50_undrwn_rwa;
		this.b_rrp_smlb2_50_under_ccf_amt = b_rrp_smlb2_50_under_ccf_amt;
		this.b_rrp_smlb2_100_undrwn_balance = b_rrp_smlb2_100_undrwn_balance;
		this.b_rrp_smlb2_100_undrwn_crm = b_rrp_smlb2_100_undrwn_crm;
		this.b_rrp_smlb2_100_undrwn_rwa = b_rrp_smlb2_100_undrwn_rwa;
		this.b_rrp_smlb2_100_under_ccf_amt = b_rrp_smlb2_100_under_ccf_amt;
		this.b_rrp_smlb2_150_undrwn_balance = b_rrp_smlb2_150_undrwn_balance;
		this.b_rrp_smlb2_150_undrwn_crm = b_rrp_smlb2_150_undrwn_crm;
		this.b_rrp_smlb2_150_undrwn_rwa = b_rrp_smlb2_150_undrwn_rwa;
		this.b_rrp_smlb2_150_under_ccf_amt = b_rrp_smlb2_150_under_ccf_amt;
		this.report_submit_date = report_submit_date;
		this.report_date = report_date;
		this.report_from_date = report_from_date;
		this.report_to_date = report_to_date;
		this.report_code = report_code;
		this.entity_flg = entity_flg;
		this.modify_flg = modify_flg;
		this.del_flg = del_flg;
	}
	public BRF95_TABLE6() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	
	
	

}
