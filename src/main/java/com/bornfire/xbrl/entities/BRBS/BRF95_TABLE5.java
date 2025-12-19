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
@Table(name="BRF95_TABLE5")
public class BRF95_TABLE5 {
	private BigDecimal	hni_0_undrwn_balance;
	private BigDecimal	hni_0_undrwn_crm;
	private BigDecimal	hni_0_undrwn_rwa;
	private BigDecimal	hni_0_under_ccf_amt;
	private BigDecimal	hni_20_undrwn_balance;
	private BigDecimal	hni_20_undrwn_crm;
	private BigDecimal	hni_20_undrwn_rwa;
	private BigDecimal	hni_20_under_ccf_amt;
	private BigDecimal	hni_50_undrwn_balance;
	private BigDecimal	hni_50_undrwn_crm;
	private BigDecimal	hni_50_undrwn_rwa;
	private BigDecimal	hni_50_under_ccf_amt;
	private BigDecimal	hni_150_undrwn_balance;
	private BigDecimal	hni_150_undrwn_crm;
	private BigDecimal	hni_150_undrwn_rwa;
	private BigDecimal	hni_150_under_ccf_amt;
	private BigDecimal	pdl_0_undrwn_balance;
	private BigDecimal	pdl_0_undrwn_crm;
	private BigDecimal	pdl_0_undrwn_rwa;
	private BigDecimal	pdl_0_under_ccf_amt;
	private BigDecimal	pdl_20_undrwn_balance;
	private BigDecimal	pdl_20_undrwn_crm;
	private BigDecimal	pdl_20_undrwn_rwa;
	private BigDecimal	pdl_20_under_ccf_amt;
	private BigDecimal	pdl_50_undrwn_balance;
	private BigDecimal	pdl_50_undrwn_crm;
	private BigDecimal	pdl_50_undrwn_rwa;
	private BigDecimal	pdl_50_under_ccf_amt;
	private BigDecimal	res_0_undrwn_balance;
	private BigDecimal	res_0_undrwn_crm;
	private BigDecimal	res_0_undrwn_rwa;
	private BigDecimal	res_0_under_ccf_amt;
	private BigDecimal	res_20_undrwn_balance;
	private BigDecimal	res_20_undrwn_crm;
	private BigDecimal	res_20_undrwn_rwa;
	private BigDecimal	res_20_under_ccf_amt;
	private BigDecimal	res_50_undrwn_balance;
	private BigDecimal	res_50_undrwn_crm;
	private BigDecimal	res_50_undrwn_rwa;
	private BigDecimal	res_50_under_ccf_amt;
	private BigDecimal	res_150_undrwn_balance;
	private BigDecimal	res_150_undrwn_crm;
	private BigDecimal	res_150_undrwn_rwa;
	private BigDecimal	res_150_under_ccf_amt;
	private BigDecimal	rrp_inde1_0_undrwn_balance;
	private BigDecimal	rrp_inde1_0_undrwn_crm;
	private BigDecimal	rrp_inde1_0_undrwn_rwa;
	private BigDecimal	rrp_inde1_0_under_ccf_amt;
	private BigDecimal	rrp_inde1_20_undrwn_balance;
	private BigDecimal	rrp_inde1_20_undrwn_crm;
	private BigDecimal	rrp_inde1_20_undrwn_rwa;
	private BigDecimal	rrp_inde1_20_under_ccf_amt;
	private BigDecimal	rrp_inde1_50_undrwn_balance;
	private BigDecimal	rrp_inde1_50_undrwn_crm;
	private BigDecimal	rrp_inde1_50_undrwn_rwa;
	private BigDecimal	rrp_inde1_50_under_ccf_amt;
	private BigDecimal	rrp_inde1_100_undrwn_balance;
	private BigDecimal	rrp_inde1_100_undrwn_crm;
	private BigDecimal	rrp_inde1_100_undrwn_rwa;
	private BigDecimal	rrp_inde1_100_under_ccf_amt;
	private BigDecimal	rrp_inde1_150_undrwn_balance;
	private BigDecimal	rrp_inde1_150_undrwn_crm;
	private BigDecimal	rrp_inde1_150_undrwn_rwa;
	private BigDecimal	rrp_inde1_150_under_ccf_amt;
	private BigDecimal	rrp_inde2_0_undrwn_balance;
	private BigDecimal	rrp_inde2_0_undrwn_crm;
	private BigDecimal	rrp_inde2_0_undrwn_rwa;
	private BigDecimal	rrp_inde2_0_under_ccf_amt;
	private BigDecimal	rrp_inde2_20_undrwn_balance;
	private BigDecimal	rrp_inde2_20_undrwn_crm;
	private BigDecimal	rrp_inde2_20_undrwn_rwa;
	private BigDecimal	rrp_inde2_20_under_ccf_amt;
	private BigDecimal	rrp_inde2_50_undrwn_balance;
	private BigDecimal	rrp_inde2_50_undrwn_crm;
	private BigDecimal	rrp_inde2_50_undrwn_rwa;
	private BigDecimal	rrp_inde2_50_under_ccf_amt;
	private BigDecimal	rrp_inde2_150_undrwn_balance;
	private BigDecimal	rrp_inde2_150_undrwn_crm;
	private BigDecimal	rrp_inde2_150_undrwn_rwa;
	private BigDecimal	rrp_inde2_150_under_ccf_amt;
	private BigDecimal	rrp_smlb_0_undrwn_balance;
	private BigDecimal	rrp_smlb_0_undrwn_crm;
	private BigDecimal	rrp_smlb_0_undrwn_rwa;
	private BigDecimal	rrp_smlb_0_under_ccf_amt;
	private BigDecimal	rrp_smlb_20_undrwn_balance;
	private BigDecimal	rrp_smlb_20_undrwn_crm;
	private BigDecimal	rrp_smlb_20_undrwn_rwa;
	private BigDecimal	rrp_smlb_20_under_ccf_amt;
	private BigDecimal	rrp_smlb_50_undrwn_balance;
	private BigDecimal	rrp_smlb_50_undrwn_crm;
	private BigDecimal	rrp_smlb_50_undrwn_rwa;
	private BigDecimal	rrp_smlb_50_under_ccf_amt;
	private BigDecimal	rrp_smlb_100_undrwn_balance;
	private BigDecimal	rrp_smlb_100_undrwn_crm;
	private BigDecimal	rrp_smlb_100_undrwn_rwa;
	private BigDecimal	rrp_smlb_100_under_ccf_amt;
	private BigDecimal	rrp_smlb_150_undrwn_balance;
	private BigDecimal	rrp_smlb_150_undrwn_crm;
	private BigDecimal	rrp_smlb_150_undrwn_rwa;
	private BigDecimal	rrp_smlb_150_under_ccf_amt;
	private BigDecimal	rrp_smlb2_0_undrwn_balance;
	private BigDecimal	rrp_smlb2_0_undrwn_crm;
	private BigDecimal	rrp_smlb2_0_undrwn_rwa;
	private BigDecimal	rrp_smlb2_0_under_ccf_amt;
	private BigDecimal	rrp_smlb2_20_undrwn_balance;
	private BigDecimal	rrp_smlb2_20_undrwn_crm;
	private BigDecimal	rrp_smlb2_20_undrwn_rwa;
	private BigDecimal	rrp_smlb2_20_under_ccf_amt;
	private BigDecimal	rrp_smlb2_50_undrwn_balance;
	private BigDecimal	rrp_smlb2_50_undrwn_crm;
	private BigDecimal	rrp_smlb2_50_undrwn_rwa;
	private BigDecimal	rrp_smlb2_50_under_ccf_amt;
	private BigDecimal	rrp_smlb2_100_undrwn_balance;
	private BigDecimal	rrp_smlb2_100_undrwn_crm;
	private BigDecimal	rrp_smlb2_100_undrwn_rwa;
	private BigDecimal	rrp_smlb2_100_under_ccf_amt;
	private BigDecimal	rrp_smlb2_150_undrwn_balance;
	private BigDecimal	rrp_smlb2_150_undrwn_crm;
	private BigDecimal	rrp_smlb2_150_undrwn_rwa;
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
	public BigDecimal getHni_0_undrwn_balance() {
		return hni_0_undrwn_balance;
	}
	public void setHni_0_undrwn_balance(BigDecimal hni_0_undrwn_balance) {
		this.hni_0_undrwn_balance = hni_0_undrwn_balance;
	}
	public BigDecimal getHni_0_undrwn_crm() {
		return hni_0_undrwn_crm;
	}
	public void setHni_0_undrwn_crm(BigDecimal hni_0_undrwn_crm) {
		this.hni_0_undrwn_crm = hni_0_undrwn_crm;
	}
	public BigDecimal getHni_0_undrwn_rwa() {
		return hni_0_undrwn_rwa;
	}
	public void setHni_0_undrwn_rwa(BigDecimal hni_0_undrwn_rwa) {
		this.hni_0_undrwn_rwa = hni_0_undrwn_rwa;
	}
	public BigDecimal getHni_0_under_ccf_amt() {
		return hni_0_under_ccf_amt;
	}
	public void setHni_0_under_ccf_amt(BigDecimal hni_0_under_ccf_amt) {
		this.hni_0_under_ccf_amt = hni_0_under_ccf_amt;
	}
	public BigDecimal getHni_20_undrwn_balance() {
		return hni_20_undrwn_balance;
	}
	public void setHni_20_undrwn_balance(BigDecimal hni_20_undrwn_balance) {
		this.hni_20_undrwn_balance = hni_20_undrwn_balance;
	}
	public BigDecimal getHni_20_undrwn_crm() {
		return hni_20_undrwn_crm;
	}
	public void setHni_20_undrwn_crm(BigDecimal hni_20_undrwn_crm) {
		this.hni_20_undrwn_crm = hni_20_undrwn_crm;
	}
	public BigDecimal getHni_20_undrwn_rwa() {
		return hni_20_undrwn_rwa;
	}
	public void setHni_20_undrwn_rwa(BigDecimal hni_20_undrwn_rwa) {
		this.hni_20_undrwn_rwa = hni_20_undrwn_rwa;
	}
	public BigDecimal getHni_20_under_ccf_amt() {
		return hni_20_under_ccf_amt;
	}
	public void setHni_20_under_ccf_amt(BigDecimal hni_20_under_ccf_amt) {
		this.hni_20_under_ccf_amt = hni_20_under_ccf_amt;
	}
	public BigDecimal getHni_50_undrwn_balance() {
		return hni_50_undrwn_balance;
	}
	public void setHni_50_undrwn_balance(BigDecimal hni_50_undrwn_balance) {
		this.hni_50_undrwn_balance = hni_50_undrwn_balance;
	}
	public BigDecimal getHni_50_undrwn_crm() {
		return hni_50_undrwn_crm;
	}
	public void setHni_50_undrwn_crm(BigDecimal hni_50_undrwn_crm) {
		this.hni_50_undrwn_crm = hni_50_undrwn_crm;
	}
	public BigDecimal getHni_50_undrwn_rwa() {
		return hni_50_undrwn_rwa;
	}
	public void setHni_50_undrwn_rwa(BigDecimal hni_50_undrwn_rwa) {
		this.hni_50_undrwn_rwa = hni_50_undrwn_rwa;
	}
	public BigDecimal getHni_50_under_ccf_amt() {
		return hni_50_under_ccf_amt;
	}
	public void setHni_50_under_ccf_amt(BigDecimal hni_50_under_ccf_amt) {
		this.hni_50_under_ccf_amt = hni_50_under_ccf_amt;
	}
	public BigDecimal getHni_150_undrwn_balance() {
		return hni_150_undrwn_balance;
	}
	public void setHni_150_undrwn_balance(BigDecimal hni_150_undrwn_balance) {
		this.hni_150_undrwn_balance = hni_150_undrwn_balance;
	}
	public BigDecimal getHni_150_undrwn_crm() {
		return hni_150_undrwn_crm;
	}
	public void setHni_150_undrwn_crm(BigDecimal hni_150_undrwn_crm) {
		this.hni_150_undrwn_crm = hni_150_undrwn_crm;
	}
	public BigDecimal getHni_150_undrwn_rwa() {
		return hni_150_undrwn_rwa;
	}
	public void setHni_150_undrwn_rwa(BigDecimal hni_150_undrwn_rwa) {
		this.hni_150_undrwn_rwa = hni_150_undrwn_rwa;
	}
	public BigDecimal getHni_150_under_ccf_amt() {
		return hni_150_under_ccf_amt;
	}
	public void setHni_150_under_ccf_amt(BigDecimal hni_150_under_ccf_amt) {
		this.hni_150_under_ccf_amt = hni_150_under_ccf_amt;
	}
	public BigDecimal getPdl_0_undrwn_balance() {
		return pdl_0_undrwn_balance;
	}
	public void setPdl_0_undrwn_balance(BigDecimal pdl_0_undrwn_balance) {
		this.pdl_0_undrwn_balance = pdl_0_undrwn_balance;
	}
	public BigDecimal getPdl_0_undrwn_crm() {
		return pdl_0_undrwn_crm;
	}
	public void setPdl_0_undrwn_crm(BigDecimal pdl_0_undrwn_crm) {
		this.pdl_0_undrwn_crm = pdl_0_undrwn_crm;
	}
	public BigDecimal getPdl_0_undrwn_rwa() {
		return pdl_0_undrwn_rwa;
	}
	public void setPdl_0_undrwn_rwa(BigDecimal pdl_0_undrwn_rwa) {
		this.pdl_0_undrwn_rwa = pdl_0_undrwn_rwa;
	}
	public BigDecimal getPdl_0_under_ccf_amt() {
		return pdl_0_under_ccf_amt;
	}
	public void setPdl_0_under_ccf_amt(BigDecimal pdl_0_under_ccf_amt) {
		this.pdl_0_under_ccf_amt = pdl_0_under_ccf_amt;
	}
	public BigDecimal getPdl_20_undrwn_balance() {
		return pdl_20_undrwn_balance;
	}
	public void setPdl_20_undrwn_balance(BigDecimal pdl_20_undrwn_balance) {
		this.pdl_20_undrwn_balance = pdl_20_undrwn_balance;
	}
	public BigDecimal getPdl_20_undrwn_crm() {
		return pdl_20_undrwn_crm;
	}
	public void setPdl_20_undrwn_crm(BigDecimal pdl_20_undrwn_crm) {
		this.pdl_20_undrwn_crm = pdl_20_undrwn_crm;
	}
	public BigDecimal getPdl_20_undrwn_rwa() {
		return pdl_20_undrwn_rwa;
	}
	public void setPdl_20_undrwn_rwa(BigDecimal pdl_20_undrwn_rwa) {
		this.pdl_20_undrwn_rwa = pdl_20_undrwn_rwa;
	}
	public BigDecimal getPdl_20_under_ccf_amt() {
		return pdl_20_under_ccf_amt;
	}
	public void setPdl_20_under_ccf_amt(BigDecimal pdl_20_under_ccf_amt) {
		this.pdl_20_under_ccf_amt = pdl_20_under_ccf_amt;
	}
	public BigDecimal getPdl_50_undrwn_balance() {
		return pdl_50_undrwn_balance;
	}
	public void setPdl_50_undrwn_balance(BigDecimal pdl_50_undrwn_balance) {
		this.pdl_50_undrwn_balance = pdl_50_undrwn_balance;
	}
	public BigDecimal getPdl_50_undrwn_crm() {
		return pdl_50_undrwn_crm;
	}
	public void setPdl_50_undrwn_crm(BigDecimal pdl_50_undrwn_crm) {
		this.pdl_50_undrwn_crm = pdl_50_undrwn_crm;
	}
	public BigDecimal getPdl_50_undrwn_rwa() {
		return pdl_50_undrwn_rwa;
	}
	public void setPdl_50_undrwn_rwa(BigDecimal pdl_50_undrwn_rwa) {
		this.pdl_50_undrwn_rwa = pdl_50_undrwn_rwa;
	}
	public BigDecimal getPdl_50_under_ccf_amt() {
		return pdl_50_under_ccf_amt;
	}
	public void setPdl_50_under_ccf_amt(BigDecimal pdl_50_under_ccf_amt) {
		this.pdl_50_under_ccf_amt = pdl_50_under_ccf_amt;
	}
	public BigDecimal getRes_0_undrwn_balance() {
		return res_0_undrwn_balance;
	}
	public void setRes_0_undrwn_balance(BigDecimal res_0_undrwn_balance) {
		this.res_0_undrwn_balance = res_0_undrwn_balance;
	}
	public BigDecimal getRes_0_undrwn_crm() {
		return res_0_undrwn_crm;
	}
	public void setRes_0_undrwn_crm(BigDecimal res_0_undrwn_crm) {
		this.res_0_undrwn_crm = res_0_undrwn_crm;
	}
	public BigDecimal getRes_0_undrwn_rwa() {
		return res_0_undrwn_rwa;
	}
	public void setRes_0_undrwn_rwa(BigDecimal res_0_undrwn_rwa) {
		this.res_0_undrwn_rwa = res_0_undrwn_rwa;
	}
	public BigDecimal getRes_0_under_ccf_amt() {
		return res_0_under_ccf_amt;
	}
	public void setRes_0_under_ccf_amt(BigDecimal res_0_under_ccf_amt) {
		this.res_0_under_ccf_amt = res_0_under_ccf_amt;
	}
	public BigDecimal getRes_20_undrwn_balance() {
		return res_20_undrwn_balance;
	}
	public void setRes_20_undrwn_balance(BigDecimal res_20_undrwn_balance) {
		this.res_20_undrwn_balance = res_20_undrwn_balance;
	}
	public BigDecimal getRes_20_undrwn_crm() {
		return res_20_undrwn_crm;
	}
	public void setRes_20_undrwn_crm(BigDecimal res_20_undrwn_crm) {
		this.res_20_undrwn_crm = res_20_undrwn_crm;
	}
	public BigDecimal getRes_20_undrwn_rwa() {
		return res_20_undrwn_rwa;
	}
	public void setRes_20_undrwn_rwa(BigDecimal res_20_undrwn_rwa) {
		this.res_20_undrwn_rwa = res_20_undrwn_rwa;
	}
	public BigDecimal getRes_20_under_ccf_amt() {
		return res_20_under_ccf_amt;
	}
	public void setRes_20_under_ccf_amt(BigDecimal res_20_under_ccf_amt) {
		this.res_20_under_ccf_amt = res_20_under_ccf_amt;
	}
	public BigDecimal getRes_50_undrwn_balance() {
		return res_50_undrwn_balance;
	}
	public void setRes_50_undrwn_balance(BigDecimal res_50_undrwn_balance) {
		this.res_50_undrwn_balance = res_50_undrwn_balance;
	}
	public BigDecimal getRes_50_undrwn_crm() {
		return res_50_undrwn_crm;
	}
	public void setRes_50_undrwn_crm(BigDecimal res_50_undrwn_crm) {
		this.res_50_undrwn_crm = res_50_undrwn_crm;
	}
	public BigDecimal getRes_50_undrwn_rwa() {
		return res_50_undrwn_rwa;
	}
	public void setRes_50_undrwn_rwa(BigDecimal res_50_undrwn_rwa) {
		this.res_50_undrwn_rwa = res_50_undrwn_rwa;
	}
	public BigDecimal getRes_50_under_ccf_amt() {
		return res_50_under_ccf_amt;
	}
	public void setRes_50_under_ccf_amt(BigDecimal res_50_under_ccf_amt) {
		this.res_50_under_ccf_amt = res_50_under_ccf_amt;
	}
	public BigDecimal getRes_150_undrwn_balance() {
		return res_150_undrwn_balance;
	}
	public void setRes_150_undrwn_balance(BigDecimal res_150_undrwn_balance) {
		this.res_150_undrwn_balance = res_150_undrwn_balance;
	}
	public BigDecimal getRes_150_undrwn_crm() {
		return res_150_undrwn_crm;
	}
	public void setRes_150_undrwn_crm(BigDecimal res_150_undrwn_crm) {
		this.res_150_undrwn_crm = res_150_undrwn_crm;
	}
	public BigDecimal getRes_150_undrwn_rwa() {
		return res_150_undrwn_rwa;
	}
	public void setRes_150_undrwn_rwa(BigDecimal res_150_undrwn_rwa) {
		this.res_150_undrwn_rwa = res_150_undrwn_rwa;
	}
	public BigDecimal getRes_150_under_ccf_amt() {
		return res_150_under_ccf_amt;
	}
	public void setRes_150_under_ccf_amt(BigDecimal res_150_under_ccf_amt) {
		this.res_150_under_ccf_amt = res_150_under_ccf_amt;
	}
	public BigDecimal getRrp_inde1_0_undrwn_balance() {
		return rrp_inde1_0_undrwn_balance;
	}
	public void setRrp_inde1_0_undrwn_balance(BigDecimal rrp_inde1_0_undrwn_balance) {
		this.rrp_inde1_0_undrwn_balance = rrp_inde1_0_undrwn_balance;
	}
	public BigDecimal getRrp_inde1_0_undrwn_crm() {
		return rrp_inde1_0_undrwn_crm;
	}
	public void setRrp_inde1_0_undrwn_crm(BigDecimal rrp_inde1_0_undrwn_crm) {
		this.rrp_inde1_0_undrwn_crm = rrp_inde1_0_undrwn_crm;
	}
	public BigDecimal getRrp_inde1_0_undrwn_rwa() {
		return rrp_inde1_0_undrwn_rwa;
	}
	public void setRrp_inde1_0_undrwn_rwa(BigDecimal rrp_inde1_0_undrwn_rwa) {
		this.rrp_inde1_0_undrwn_rwa = rrp_inde1_0_undrwn_rwa;
	}
	public BigDecimal getRrp_inde1_0_under_ccf_amt() {
		return rrp_inde1_0_under_ccf_amt;
	}
	public void setRrp_inde1_0_under_ccf_amt(BigDecimal rrp_inde1_0_under_ccf_amt) {
		this.rrp_inde1_0_under_ccf_amt = rrp_inde1_0_under_ccf_amt;
	}
	public BigDecimal getRrp_inde1_20_undrwn_balance() {
		return rrp_inde1_20_undrwn_balance;
	}
	public void setRrp_inde1_20_undrwn_balance(BigDecimal rrp_inde1_20_undrwn_balance) {
		this.rrp_inde1_20_undrwn_balance = rrp_inde1_20_undrwn_balance;
	}
	public BigDecimal getRrp_inde1_20_undrwn_crm() {
		return rrp_inde1_20_undrwn_crm;
	}
	public void setRrp_inde1_20_undrwn_crm(BigDecimal rrp_inde1_20_undrwn_crm) {
		this.rrp_inde1_20_undrwn_crm = rrp_inde1_20_undrwn_crm;
	}
	public BigDecimal getRrp_inde1_20_undrwn_rwa() {
		return rrp_inde1_20_undrwn_rwa;
	}
	public void setRrp_inde1_20_undrwn_rwa(BigDecimal rrp_inde1_20_undrwn_rwa) {
		this.rrp_inde1_20_undrwn_rwa = rrp_inde1_20_undrwn_rwa;
	}
	public BigDecimal getRrp_inde1_20_under_ccf_amt() {
		return rrp_inde1_20_under_ccf_amt;
	}
	public void setRrp_inde1_20_under_ccf_amt(BigDecimal rrp_inde1_20_under_ccf_amt) {
		this.rrp_inde1_20_under_ccf_amt = rrp_inde1_20_under_ccf_amt;
	}
	public BigDecimal getRrp_inde1_50_undrwn_balance() {
		return rrp_inde1_50_undrwn_balance;
	}
	public void setRrp_inde1_50_undrwn_balance(BigDecimal rrp_inde1_50_undrwn_balance) {
		this.rrp_inde1_50_undrwn_balance = rrp_inde1_50_undrwn_balance;
	}
	public BigDecimal getRrp_inde1_50_undrwn_crm() {
		return rrp_inde1_50_undrwn_crm;
	}
	public void setRrp_inde1_50_undrwn_crm(BigDecimal rrp_inde1_50_undrwn_crm) {
		this.rrp_inde1_50_undrwn_crm = rrp_inde1_50_undrwn_crm;
	}
	public BigDecimal getRrp_inde1_50_undrwn_rwa() {
		return rrp_inde1_50_undrwn_rwa;
	}
	public void setRrp_inde1_50_undrwn_rwa(BigDecimal rrp_inde1_50_undrwn_rwa) {
		this.rrp_inde1_50_undrwn_rwa = rrp_inde1_50_undrwn_rwa;
	}
	public BigDecimal getRrp_inde1_50_under_ccf_amt() {
		return rrp_inde1_50_under_ccf_amt;
	}
	public void setRrp_inde1_50_under_ccf_amt(BigDecimal rrp_inde1_50_under_ccf_amt) {
		this.rrp_inde1_50_under_ccf_amt = rrp_inde1_50_under_ccf_amt;
	}
	public BigDecimal getRrp_inde1_100_undrwn_balance() {
		return rrp_inde1_100_undrwn_balance;
	}
	public void setRrp_inde1_100_undrwn_balance(BigDecimal rrp_inde1_100_undrwn_balance) {
		this.rrp_inde1_100_undrwn_balance = rrp_inde1_100_undrwn_balance;
	}
	public BigDecimal getRrp_inde1_100_undrwn_crm() {
		return rrp_inde1_100_undrwn_crm;
	}
	public void setRrp_inde1_100_undrwn_crm(BigDecimal rrp_inde1_100_undrwn_crm) {
		this.rrp_inde1_100_undrwn_crm = rrp_inde1_100_undrwn_crm;
	}
	public BigDecimal getRrp_inde1_100_undrwn_rwa() {
		return rrp_inde1_100_undrwn_rwa;
	}
	public void setRrp_inde1_100_undrwn_rwa(BigDecimal rrp_inde1_100_undrwn_rwa) {
		this.rrp_inde1_100_undrwn_rwa = rrp_inde1_100_undrwn_rwa;
	}
	public BigDecimal getRrp_inde1_100_under_ccf_amt() {
		return rrp_inde1_100_under_ccf_amt;
	}
	public void setRrp_inde1_100_under_ccf_amt(BigDecimal rrp_inde1_100_under_ccf_amt) {
		this.rrp_inde1_100_under_ccf_amt = rrp_inde1_100_under_ccf_amt;
	}
	public BigDecimal getRrp_inde1_150_undrwn_balance() {
		return rrp_inde1_150_undrwn_balance;
	}
	public void setRrp_inde1_150_undrwn_balance(BigDecimal rrp_inde1_150_undrwn_balance) {
		this.rrp_inde1_150_undrwn_balance = rrp_inde1_150_undrwn_balance;
	}
	public BigDecimal getRrp_inde1_150_undrwn_crm() {
		return rrp_inde1_150_undrwn_crm;
	}
	public void setRrp_inde1_150_undrwn_crm(BigDecimal rrp_inde1_150_undrwn_crm) {
		this.rrp_inde1_150_undrwn_crm = rrp_inde1_150_undrwn_crm;
	}
	public BigDecimal getRrp_inde1_150_undrwn_rwa() {
		return rrp_inde1_150_undrwn_rwa;
	}
	public void setRrp_inde1_150_undrwn_rwa(BigDecimal rrp_inde1_150_undrwn_rwa) {
		this.rrp_inde1_150_undrwn_rwa = rrp_inde1_150_undrwn_rwa;
	}
	public BigDecimal getRrp_inde1_150_under_ccf_amt() {
		return rrp_inde1_150_under_ccf_amt;
	}
	public void setRrp_inde1_150_under_ccf_amt(BigDecimal rrp_inde1_150_under_ccf_amt) {
		this.rrp_inde1_150_under_ccf_amt = rrp_inde1_150_under_ccf_amt;
	}
	public BigDecimal getRrp_inde2_0_undrwn_balance() {
		return rrp_inde2_0_undrwn_balance;
	}
	public void setRrp_inde2_0_undrwn_balance(BigDecimal rrp_inde2_0_undrwn_balance) {
		this.rrp_inde2_0_undrwn_balance = rrp_inde2_0_undrwn_balance;
	}
	public BigDecimal getRrp_inde2_0_undrwn_crm() {
		return rrp_inde2_0_undrwn_crm;
	}
	public void setRrp_inde2_0_undrwn_crm(BigDecimal rrp_inde2_0_undrwn_crm) {
		this.rrp_inde2_0_undrwn_crm = rrp_inde2_0_undrwn_crm;
	}
	public BigDecimal getRrp_inde2_0_undrwn_rwa() {
		return rrp_inde2_0_undrwn_rwa;
	}
	public void setRrp_inde2_0_undrwn_rwa(BigDecimal rrp_inde2_0_undrwn_rwa) {
		this.rrp_inde2_0_undrwn_rwa = rrp_inde2_0_undrwn_rwa;
	}
	public BigDecimal getRrp_inde2_0_under_ccf_amt() {
		return rrp_inde2_0_under_ccf_amt;
	}
	public void setRrp_inde2_0_under_ccf_amt(BigDecimal rrp_inde2_0_under_ccf_amt) {
		this.rrp_inde2_0_under_ccf_amt = rrp_inde2_0_under_ccf_amt;
	}
	public BigDecimal getRrp_inde2_20_undrwn_balance() {
		return rrp_inde2_20_undrwn_balance;
	}
	public void setRrp_inde2_20_undrwn_balance(BigDecimal rrp_inde2_20_undrwn_balance) {
		this.rrp_inde2_20_undrwn_balance = rrp_inde2_20_undrwn_balance;
	}
	public BigDecimal getRrp_inde2_20_undrwn_crm() {
		return rrp_inde2_20_undrwn_crm;
	}
	public void setRrp_inde2_20_undrwn_crm(BigDecimal rrp_inde2_20_undrwn_crm) {
		this.rrp_inde2_20_undrwn_crm = rrp_inde2_20_undrwn_crm;
	}
	public BigDecimal getRrp_inde2_20_undrwn_rwa() {
		return rrp_inde2_20_undrwn_rwa;
	}
	public void setRrp_inde2_20_undrwn_rwa(BigDecimal rrp_inde2_20_undrwn_rwa) {
		this.rrp_inde2_20_undrwn_rwa = rrp_inde2_20_undrwn_rwa;
	}
	public BigDecimal getRrp_inde2_20_under_ccf_amt() {
		return rrp_inde2_20_under_ccf_amt;
	}
	public void setRrp_inde2_20_under_ccf_amt(BigDecimal rrp_inde2_20_under_ccf_amt) {
		this.rrp_inde2_20_under_ccf_amt = rrp_inde2_20_under_ccf_amt;
	}
	public BigDecimal getRrp_inde2_50_undrwn_balance() {
		return rrp_inde2_50_undrwn_balance;
	}
	public void setRrp_inde2_50_undrwn_balance(BigDecimal rrp_inde2_50_undrwn_balance) {
		this.rrp_inde2_50_undrwn_balance = rrp_inde2_50_undrwn_balance;
	}
	public BigDecimal getRrp_inde2_50_undrwn_crm() {
		return rrp_inde2_50_undrwn_crm;
	}
	public void setRrp_inde2_50_undrwn_crm(BigDecimal rrp_inde2_50_undrwn_crm) {
		this.rrp_inde2_50_undrwn_crm = rrp_inde2_50_undrwn_crm;
	}
	public BigDecimal getRrp_inde2_50_undrwn_rwa() {
		return rrp_inde2_50_undrwn_rwa;
	}
	public void setRrp_inde2_50_undrwn_rwa(BigDecimal rrp_inde2_50_undrwn_rwa) {
		this.rrp_inde2_50_undrwn_rwa = rrp_inde2_50_undrwn_rwa;
	}
	public BigDecimal getRrp_inde2_50_under_ccf_amt() {
		return rrp_inde2_50_under_ccf_amt;
	}
	public void setRrp_inde2_50_under_ccf_amt(BigDecimal rrp_inde2_50_under_ccf_amt) {
		this.rrp_inde2_50_under_ccf_amt = rrp_inde2_50_under_ccf_amt;
	}
	public BigDecimal getRrp_inde2_150_undrwn_balance() {
		return rrp_inde2_150_undrwn_balance;
	}
	public void setRrp_inde2_150_undrwn_balance(BigDecimal rrp_inde2_150_undrwn_balance) {
		this.rrp_inde2_150_undrwn_balance = rrp_inde2_150_undrwn_balance;
	}
	public BigDecimal getRrp_inde2_150_undrwn_crm() {
		return rrp_inde2_150_undrwn_crm;
	}
	public void setRrp_inde2_150_undrwn_crm(BigDecimal rrp_inde2_150_undrwn_crm) {
		this.rrp_inde2_150_undrwn_crm = rrp_inde2_150_undrwn_crm;
	}
	public BigDecimal getRrp_inde2_150_undrwn_rwa() {
		return rrp_inde2_150_undrwn_rwa;
	}
	public void setRrp_inde2_150_undrwn_rwa(BigDecimal rrp_inde2_150_undrwn_rwa) {
		this.rrp_inde2_150_undrwn_rwa = rrp_inde2_150_undrwn_rwa;
	}
	public BigDecimal getRrp_inde2_150_under_ccf_amt() {
		return rrp_inde2_150_under_ccf_amt;
	}
	public void setRrp_inde2_150_under_ccf_amt(BigDecimal rrp_inde2_150_under_ccf_amt) {
		this.rrp_inde2_150_under_ccf_amt = rrp_inde2_150_under_ccf_amt;
	}
	public BigDecimal getRrp_smlb_0_undrwn_balance() {
		return rrp_smlb_0_undrwn_balance;
	}
	public void setRrp_smlb_0_undrwn_balance(BigDecimal rrp_smlb_0_undrwn_balance) {
		this.rrp_smlb_0_undrwn_balance = rrp_smlb_0_undrwn_balance;
	}
	public BigDecimal getRrp_smlb_0_undrwn_crm() {
		return rrp_smlb_0_undrwn_crm;
	}
	public void setRrp_smlb_0_undrwn_crm(BigDecimal rrp_smlb_0_undrwn_crm) {
		this.rrp_smlb_0_undrwn_crm = rrp_smlb_0_undrwn_crm;
	}
	public BigDecimal getRrp_smlb_0_undrwn_rwa() {
		return rrp_smlb_0_undrwn_rwa;
	}
	public void setRrp_smlb_0_undrwn_rwa(BigDecimal rrp_smlb_0_undrwn_rwa) {
		this.rrp_smlb_0_undrwn_rwa = rrp_smlb_0_undrwn_rwa;
	}
	public BigDecimal getRrp_smlb_0_under_ccf_amt() {
		return rrp_smlb_0_under_ccf_amt;
	}
	public void setRrp_smlb_0_under_ccf_amt(BigDecimal rrp_smlb_0_under_ccf_amt) {
		this.rrp_smlb_0_under_ccf_amt = rrp_smlb_0_under_ccf_amt;
	}
	public BigDecimal getRrp_smlb_20_undrwn_balance() {
		return rrp_smlb_20_undrwn_balance;
	}
	public void setRrp_smlb_20_undrwn_balance(BigDecimal rrp_smlb_20_undrwn_balance) {
		this.rrp_smlb_20_undrwn_balance = rrp_smlb_20_undrwn_balance;
	}
	public BigDecimal getRrp_smlb_20_undrwn_crm() {
		return rrp_smlb_20_undrwn_crm;
	}
	public void setRrp_smlb_20_undrwn_crm(BigDecimal rrp_smlb_20_undrwn_crm) {
		this.rrp_smlb_20_undrwn_crm = rrp_smlb_20_undrwn_crm;
	}
	public BigDecimal getRrp_smlb_20_undrwn_rwa() {
		return rrp_smlb_20_undrwn_rwa;
	}
	public void setRrp_smlb_20_undrwn_rwa(BigDecimal rrp_smlb_20_undrwn_rwa) {
		this.rrp_smlb_20_undrwn_rwa = rrp_smlb_20_undrwn_rwa;
	}
	public BigDecimal getRrp_smlb_20_under_ccf_amt() {
		return rrp_smlb_20_under_ccf_amt;
	}
	public void setRrp_smlb_20_under_ccf_amt(BigDecimal rrp_smlb_20_under_ccf_amt) {
		this.rrp_smlb_20_under_ccf_amt = rrp_smlb_20_under_ccf_amt;
	}
	public BigDecimal getRrp_smlb_50_undrwn_balance() {
		return rrp_smlb_50_undrwn_balance;
	}
	public void setRrp_smlb_50_undrwn_balance(BigDecimal rrp_smlb_50_undrwn_balance) {
		this.rrp_smlb_50_undrwn_balance = rrp_smlb_50_undrwn_balance;
	}
	public BigDecimal getRrp_smlb_50_undrwn_crm() {
		return rrp_smlb_50_undrwn_crm;
	}
	public void setRrp_smlb_50_undrwn_crm(BigDecimal rrp_smlb_50_undrwn_crm) {
		this.rrp_smlb_50_undrwn_crm = rrp_smlb_50_undrwn_crm;
	}
	public BigDecimal getRrp_smlb_50_undrwn_rwa() {
		return rrp_smlb_50_undrwn_rwa;
	}
	public void setRrp_smlb_50_undrwn_rwa(BigDecimal rrp_smlb_50_undrwn_rwa) {
		this.rrp_smlb_50_undrwn_rwa = rrp_smlb_50_undrwn_rwa;
	}
	public BigDecimal getRrp_smlb_50_under_ccf_amt() {
		return rrp_smlb_50_under_ccf_amt;
	}
	public void setRrp_smlb_50_under_ccf_amt(BigDecimal rrp_smlb_50_under_ccf_amt) {
		this.rrp_smlb_50_under_ccf_amt = rrp_smlb_50_under_ccf_amt;
	}
	public BigDecimal getRrp_smlb_100_undrwn_balance() {
		return rrp_smlb_100_undrwn_balance;
	}
	public void setRrp_smlb_100_undrwn_balance(BigDecimal rrp_smlb_100_undrwn_balance) {
		this.rrp_smlb_100_undrwn_balance = rrp_smlb_100_undrwn_balance;
	}
	public BigDecimal getRrp_smlb_100_undrwn_crm() {
		return rrp_smlb_100_undrwn_crm;
	}
	public void setRrp_smlb_100_undrwn_crm(BigDecimal rrp_smlb_100_undrwn_crm) {
		this.rrp_smlb_100_undrwn_crm = rrp_smlb_100_undrwn_crm;
	}
	public BigDecimal getRrp_smlb_100_undrwn_rwa() {
		return rrp_smlb_100_undrwn_rwa;
	}
	public void setRrp_smlb_100_undrwn_rwa(BigDecimal rrp_smlb_100_undrwn_rwa) {
		this.rrp_smlb_100_undrwn_rwa = rrp_smlb_100_undrwn_rwa;
	}
	public BigDecimal getRrp_smlb_100_under_ccf_amt() {
		return rrp_smlb_100_under_ccf_amt;
	}
	public void setRrp_smlb_100_under_ccf_amt(BigDecimal rrp_smlb_100_under_ccf_amt) {
		this.rrp_smlb_100_under_ccf_amt = rrp_smlb_100_under_ccf_amt;
	}
	public BigDecimal getRrp_smlb_150_undrwn_balance() {
		return rrp_smlb_150_undrwn_balance;
	}
	public void setRrp_smlb_150_undrwn_balance(BigDecimal rrp_smlb_150_undrwn_balance) {
		this.rrp_smlb_150_undrwn_balance = rrp_smlb_150_undrwn_balance;
	}
	public BigDecimal getRrp_smlb_150_undrwn_crm() {
		return rrp_smlb_150_undrwn_crm;
	}
	public void setRrp_smlb_150_undrwn_crm(BigDecimal rrp_smlb_150_undrwn_crm) {
		this.rrp_smlb_150_undrwn_crm = rrp_smlb_150_undrwn_crm;
	}
	public BigDecimal getRrp_smlb_150_undrwn_rwa() {
		return rrp_smlb_150_undrwn_rwa;
	}
	public void setRrp_smlb_150_undrwn_rwa(BigDecimal rrp_smlb_150_undrwn_rwa) {
		this.rrp_smlb_150_undrwn_rwa = rrp_smlb_150_undrwn_rwa;
	}
	public BigDecimal getRrp_smlb_150_under_ccf_amt() {
		return rrp_smlb_150_under_ccf_amt;
	}
	public void setRrp_smlb_150_under_ccf_amt(BigDecimal rrp_smlb_150_under_ccf_amt) {
		this.rrp_smlb_150_under_ccf_amt = rrp_smlb_150_under_ccf_amt;
	}
	public BigDecimal getRrp_smlb2_0_undrwn_balance() {
		return rrp_smlb2_0_undrwn_balance;
	}
	public void setRrp_smlb2_0_undrwn_balance(BigDecimal rrp_smlb2_0_undrwn_balance) {
		this.rrp_smlb2_0_undrwn_balance = rrp_smlb2_0_undrwn_balance;
	}
	public BigDecimal getRrp_smlb2_0_undrwn_crm() {
		return rrp_smlb2_0_undrwn_crm;
	}
	public void setRrp_smlb2_0_undrwn_crm(BigDecimal rrp_smlb2_0_undrwn_crm) {
		this.rrp_smlb2_0_undrwn_crm = rrp_smlb2_0_undrwn_crm;
	}
	public BigDecimal getRrp_smlb2_0_undrwn_rwa() {
		return rrp_smlb2_0_undrwn_rwa;
	}
	public void setRrp_smlb2_0_undrwn_rwa(BigDecimal rrp_smlb2_0_undrwn_rwa) {
		this.rrp_smlb2_0_undrwn_rwa = rrp_smlb2_0_undrwn_rwa;
	}
	public BigDecimal getRrp_smlb2_0_under_ccf_amt() {
		return rrp_smlb2_0_under_ccf_amt;
	}
	public void setRrp_smlb2_0_under_ccf_amt(BigDecimal rrp_smlb2_0_under_ccf_amt) {
		this.rrp_smlb2_0_under_ccf_amt = rrp_smlb2_0_under_ccf_amt;
	}
	public BigDecimal getRrp_smlb2_20_undrwn_balance() {
		return rrp_smlb2_20_undrwn_balance;
	}
	public void setRrp_smlb2_20_undrwn_balance(BigDecimal rrp_smlb2_20_undrwn_balance) {
		this.rrp_smlb2_20_undrwn_balance = rrp_smlb2_20_undrwn_balance;
	}
	public BigDecimal getRrp_smlb2_20_undrwn_crm() {
		return rrp_smlb2_20_undrwn_crm;
	}
	public void setRrp_smlb2_20_undrwn_crm(BigDecimal rrp_smlb2_20_undrwn_crm) {
		this.rrp_smlb2_20_undrwn_crm = rrp_smlb2_20_undrwn_crm;
	}
	public BigDecimal getRrp_smlb2_20_undrwn_rwa() {
		return rrp_smlb2_20_undrwn_rwa;
	}
	public void setRrp_smlb2_20_undrwn_rwa(BigDecimal rrp_smlb2_20_undrwn_rwa) {
		this.rrp_smlb2_20_undrwn_rwa = rrp_smlb2_20_undrwn_rwa;
	}
	public BigDecimal getRrp_smlb2_20_under_ccf_amt() {
		return rrp_smlb2_20_under_ccf_amt;
	}
	public void setRrp_smlb2_20_under_ccf_amt(BigDecimal rrp_smlb2_20_under_ccf_amt) {
		this.rrp_smlb2_20_under_ccf_amt = rrp_smlb2_20_under_ccf_amt;
	}
	public BigDecimal getRrp_smlb2_50_undrwn_balance() {
		return rrp_smlb2_50_undrwn_balance;
	}
	public void setRrp_smlb2_50_undrwn_balance(BigDecimal rrp_smlb2_50_undrwn_balance) {
		this.rrp_smlb2_50_undrwn_balance = rrp_smlb2_50_undrwn_balance;
	}
	public BigDecimal getRrp_smlb2_50_undrwn_crm() {
		return rrp_smlb2_50_undrwn_crm;
	}
	public void setRrp_smlb2_50_undrwn_crm(BigDecimal rrp_smlb2_50_undrwn_crm) {
		this.rrp_smlb2_50_undrwn_crm = rrp_smlb2_50_undrwn_crm;
	}
	public BigDecimal getRrp_smlb2_50_undrwn_rwa() {
		return rrp_smlb2_50_undrwn_rwa;
	}
	public void setRrp_smlb2_50_undrwn_rwa(BigDecimal rrp_smlb2_50_undrwn_rwa) {
		this.rrp_smlb2_50_undrwn_rwa = rrp_smlb2_50_undrwn_rwa;
	}
	public BigDecimal getRrp_smlb2_50_under_ccf_amt() {
		return rrp_smlb2_50_under_ccf_amt;
	}
	public void setRrp_smlb2_50_under_ccf_amt(BigDecimal rrp_smlb2_50_under_ccf_amt) {
		this.rrp_smlb2_50_under_ccf_amt = rrp_smlb2_50_under_ccf_amt;
	}
	public BigDecimal getRrp_smlb2_100_undrwn_balance() {
		return rrp_smlb2_100_undrwn_balance;
	}
	public void setRrp_smlb2_100_undrwn_balance(BigDecimal rrp_smlb2_100_undrwn_balance) {
		this.rrp_smlb2_100_undrwn_balance = rrp_smlb2_100_undrwn_balance;
	}
	public BigDecimal getRrp_smlb2_100_undrwn_crm() {
		return rrp_smlb2_100_undrwn_crm;
	}
	public void setRrp_smlb2_100_undrwn_crm(BigDecimal rrp_smlb2_100_undrwn_crm) {
		this.rrp_smlb2_100_undrwn_crm = rrp_smlb2_100_undrwn_crm;
	}
	public BigDecimal getRrp_smlb2_100_undrwn_rwa() {
		return rrp_smlb2_100_undrwn_rwa;
	}
	public void setRrp_smlb2_100_undrwn_rwa(BigDecimal rrp_smlb2_100_undrwn_rwa) {
		this.rrp_smlb2_100_undrwn_rwa = rrp_smlb2_100_undrwn_rwa;
	}
	public BigDecimal getRrp_smlb2_100_under_ccf_amt() {
		return rrp_smlb2_100_under_ccf_amt;
	}
	public void setRrp_smlb2_100_under_ccf_amt(BigDecimal rrp_smlb2_100_under_ccf_amt) {
		this.rrp_smlb2_100_under_ccf_amt = rrp_smlb2_100_under_ccf_amt;
	}
	public BigDecimal getRrp_smlb2_150_undrwn_balance() {
		return rrp_smlb2_150_undrwn_balance;
	}
	public void setRrp_smlb2_150_undrwn_balance(BigDecimal rrp_smlb2_150_undrwn_balance) {
		this.rrp_smlb2_150_undrwn_balance = rrp_smlb2_150_undrwn_balance;
	}
	public BigDecimal getRrp_smlb2_150_undrwn_crm() {
		return rrp_smlb2_150_undrwn_crm;
	}
	public void setRrp_smlb2_150_undrwn_crm(BigDecimal rrp_smlb2_150_undrwn_crm) {
		this.rrp_smlb2_150_undrwn_crm = rrp_smlb2_150_undrwn_crm;
	}
	public BigDecimal getRrp_smlb2_150_undrwn_rwa() {
		return rrp_smlb2_150_undrwn_rwa;
	}
	public void setRrp_smlb2_150_undrwn_rwa(BigDecimal rrp_smlb2_150_undrwn_rwa) {
		this.rrp_smlb2_150_undrwn_rwa = rrp_smlb2_150_undrwn_rwa;
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
