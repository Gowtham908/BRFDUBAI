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
@Table(name="BRF95_FUND_BASED_UNDRAWN")
public class BRF95_FUND_BASED_UNDRAWN {
	private BigDecimal	r57_bnk_0_undrawn_bal;
	private BigDecimal	r57_bnk_0_loan_undrwn_adj_crm;
	private BigDecimal	r57_bnk_0_loan_undrwn_rwa;
	private BigDecimal	r57_bnk_0_loan_under_ccf_amt;
	private BigDecimal	r58_bnk_20_undrawn_bal;
	private BigDecimal	r58_bnk_20_loan_undrwn_adj_crm;
	private BigDecimal	r58_bnk_20_loan_undrwn_rwa;
	private BigDecimal	r58_bnk_20_loan_under_ccf_amt;
	private BigDecimal	r59_bnk_50_undrawn_bal;
	private BigDecimal	r59_bnk_50_loan_undrwn_adj_crm;
	private BigDecimal	r59_bnk_50_loan_undrwn_rwa;
	private BigDecimal	r59_bnk_50_loan_under_ccf_amt;
	private BigDecimal	r60_bnk_100_undrawn_bal;
	private BigDecimal	r60_bnk_100_loan_undrwn_adj_crm;
	private BigDecimal	r60_bnk_100_loan_undrwn_rwa;
	private BigDecimal	r60_bnk_100_loan_under_ccf_amt;
	private BigDecimal	r61_bnk_150_undrawn_bal;
	private BigDecimal	r61_bnk_150_loan_undrwn_adj_crm;
	private BigDecimal	r61_bnk_150_loan_undrwn_rwa;
	private BigDecimal	r61_bnk_150_loan_under_ccf_amt;
	private BigDecimal	r62_cbs_0_undrawn_bal;
	private BigDecimal	r62_cbs_0_loan_undrwn_adj_crm;
	private BigDecimal	r62_cbs_0_loan_undrwn_rwa;
	private BigDecimal	r62_cbs_0_loan_under_ccf_amt;
	private BigDecimal	r63_cbs_20_undrawn_bal;
	private BigDecimal	r63_cbs_20_loan_undrwn_adj_crm;
	private BigDecimal	r63_cbs_20_loan_undrwn_rwa;
	private BigDecimal	r63_cbs_20_loan_under_ccf_amt;
	private BigDecimal	r64_cbs_20_undrawn_bal;
	private BigDecimal	r64_cbs_20_loan_undrwn_adj_crm;
	private BigDecimal	r64_cbs_20_loan_undrwn_rwa;
	private BigDecimal	r64_cbs_20_loan_under_ccf_amt;
	private BigDecimal	r65_cbs_0_undrawn_bal;
	private BigDecimal	r65_cbs_0_loan_undrwn_adj_crm;
	private BigDecimal	r65_cbs_0_loan_undrwn_rwa;
	private BigDecimal	r65_cbs_0_loan_under_ccf_amt;
	private BigDecimal	r66_cbs_20_undrawn_bal;
	private BigDecimal	r66_cbs_20_loan_undrwn_adj_crm;
	private BigDecimal	r66_cbs_20_loan_undrwn_rwa;
	private BigDecimal	r66_cbs_20_loan_under_ccf_amt;
	private BigDecimal	r67_cbs_50_undrawn_bal;
	private BigDecimal	r67_cbs_50_loan_undrwn_adj_crm;
	private BigDecimal	r67_cbs_50_loan_undrwn_rwa;
	private BigDecimal	r67_cbs_50_loan_under_ccf_amt;
	private BigDecimal	r68_cbs_100_undrawn_bal;
	private BigDecimal	r68_cbs_100_loan_undrwn_adj_crm;
	private BigDecimal	r68_cbs_100_loan_undrwn_rwa;
	private BigDecimal	r68_cbs_100_loan_under_ccf_amt;
	private BigDecimal	r69_cbs_150_undrawn_bal;
	private BigDecimal	r69_cbs_150_loan_undrwn_adj_crm;
	private BigDecimal	r69_cbs_150_loan_undrwn_rwa;
	private BigDecimal	r69_cbs_150_loan_under_ccf_amt;
	private BigDecimal	r70_cre_0_undrawn_bal;
	private BigDecimal	r70_cre_0_loan_undrwn_adj_crm;
	private BigDecimal	r70_cre_0_loan_undrwn_rwa;
	private BigDecimal	r70_cre_0_loan_under_ccf_amt;
	private BigDecimal	r71_cre_20_undrawn_bal;
	private BigDecimal	r71_cre_20_loan_undrwn_adj_crm;
	private BigDecimal	r71_cre_20_loan_undrwn_rwa;
	private BigDecimal	r71_cre_20_loan_under_ccf_amt;
	private BigDecimal	r72_cre_50_undrawn_bal;
	private BigDecimal	r72_cre_50_loan_undrwn_adj_crm;
	private BigDecimal	r72_cre_50_loan_undrwn_rwa;
	private BigDecimal	r72_cre_50_loan_under_ccf_amt;
	private BigDecimal	r73_cre_100_undrawn_bal;
	private BigDecimal	r73_cre_100_loan_undrwn_adj_crm;
	private BigDecimal	r73_cre_100_loan_undrwn_rwa;
	private BigDecimal	r73_cre_100_loan_under_ccf_amt;
	private BigDecimal	r74_cre_150_undrawn_bal;
	private BigDecimal	r74_cre_150_loan_undrwn_adj_crm;
	private BigDecimal	r74_cre_150_loan_undrwn_rwa;
	private BigDecimal	r74_cre_150_loan_under_ccf_amt;
	private BigDecimal	r75_crt_0_undrawn_bal;
	private BigDecimal	r75_crt_0_loan_undrwn_adj_crm;
	private BigDecimal	r75_crt_0_loan_undrwn_rwa;
	private BigDecimal	r75_crt_0_loan_under_ccf_amt;
	private BigDecimal	r76_crt_20_undrawn_bal;
	private BigDecimal	r76_crt_20_loan_undrwn_adj_crm;
	private BigDecimal	r76_crt_20_loan_undrwn_rwa;
	private BigDecimal	r76_crt_20_loan_under_ccf_amt;
	private BigDecimal	r77_crt_50_undrawn_bal;
	private BigDecimal	r77_crt_50_loan_undrwn_adj_crm;
	private BigDecimal	r77_crt_50_loan_undrwn_rwa;
	private BigDecimal	r77_crt_50_loan_under_ccf_amt;
	private BigDecimal	r78_crt_100_undrawn_bal;
	private BigDecimal	r78_crt_100_loan_undrwn_adj_crm;
	private BigDecimal	r78_crt_100_loan_undrwn_rwa;
	private BigDecimal	r78_crt_100_loan_under_ccf_amt;
	private BigDecimal	r79_crt_150_undrawn_bal;
	private BigDecimal	r79_crt_150_loan_undrwn_adj_crm;
	private BigDecimal	r79_crt_150_loan_undrwn_rwa;
	private BigDecimal	r79_crt_150_loan_under_ccf_amt;
	private BigDecimal	r80_hni_150_undrawn_bal;
	private BigDecimal	r80_hni_150_loan_undrwn_adj_crm;
	private BigDecimal	r80_hni_150_loan_undrwn_rwa;
	private BigDecimal	r80_hni_150_loan_under_ccf_amt;
	private BigDecimal	r81_pdl_100_undrawn_bal;
	private BigDecimal	r81_pdl_100_loan_undrwn_adj_crm;
	private BigDecimal	r81_pdl_100_loan_undrwn_rwa;
	private BigDecimal	r81_pdl_100_loan_under_ccf_amt;
	private BigDecimal	r82_pdl_150_undrawn_bal;
	private BigDecimal	r82_pdl_150_loan_undrwn_adj_crm;
	private BigDecimal	r82_pdl_150_loan_undrwn_rwa;
	private BigDecimal	r82_pdl_150_loan_under_ccf_amt;
	private BigDecimal	r83_pse_0_undrawn_bal;
	private BigDecimal	r83_pse_0_loan_undrwn_adj_crm;
	private BigDecimal	r83_pse_0_loan_undrwn_rwa;
	private BigDecimal	r83_pse_0_loan_under_ccf_amt;
	private BigDecimal	r84_pse_20_undrawn_bal;
	private BigDecimal	r84_pse_20_loan_undrwn_adj_crm;
	private BigDecimal	r84_pse_20_loan_undrwn_rwa;
	private BigDecimal	r84_pse_20_loan_under_ccf_amt;
	private BigDecimal	r85_pse_50_undrawn_bal;
	private BigDecimal	r85_pse_50_loan_undrwn_adj_crm;
	private BigDecimal	r85_pse_50_loan_undrwn_rwa;
	private BigDecimal	r85_pse_50_loan_under_ccf_amt;
	private BigDecimal	r86_pse_100_undrawn_bal;
	private BigDecimal	r86_pse_100_loan_undrwn_adj_crm;
	private BigDecimal	r86_pse_100_loan_undrwn_rwa;
	private BigDecimal	r86_pse_100_loan_under_ccf_amt;
	private BigDecimal	r87_pse_150_undrawn_bal;
	private BigDecimal	r87_pse_150_loan_undrwn_adj_crm;
	private BigDecimal	r87_pse_150_loan_undrwn_rwa;
	private BigDecimal	r87_pse_150_loan_under_ccf_amt;
	private BigDecimal	r88_rse_35_undrawn_bal;
	private BigDecimal	r88_rse_35_loan_undrwn_adj_crm;
	private BigDecimal	r88_rse_35_loan_undrwn_rwa;
	private BigDecimal	r88_rse_35_loan_under_ccf_amt;
	private BigDecimal	r89_rse_100_undrawn_bal;
	private BigDecimal	r89_rse_100_loan_undrwn_adj_crm;
	private BigDecimal	r89_rse_100_loan_undrwn_rwa;
	private BigDecimal	r89_rse_100_loan_under_ccf_amt;
	private BigDecimal	r90_pse_75_undrawn_bal;
	private BigDecimal	r90_pse_75_loan_undrwn_adj_crm;
	private BigDecimal	r90_pse_75_loan_undrwn_rwa;
	private BigDecimal	r90_pse_75_loan_under_ccf_amt;
	private BigDecimal	r91_pse_100_undrawn_bal;
	private BigDecimal	r91_pse_100_loan_undrwn_adj_crm;
	private BigDecimal	r91_pse_100_loan_undrwn_rwa;
	private BigDecimal	r91_pse_100_loan_under_ccf_amt;
	private BigDecimal	r92_pse_75_undrawn_bal;
	private BigDecimal	r92_pse_75_loan_undrwn_adj_crm;
	private BigDecimal	r92_pse_75_loan_undrwn_rwa;
	private BigDecimal	r92_pse_75_loan_under_ccf_amt;
	private BigDecimal	r93_pse_100_undrawn_bal;
	private BigDecimal	r93_pse_100_loan_undrwn_adj_crm;
	private BigDecimal	r93_pse_100_loan_undrwn_rwa;
	private BigDecimal	r93_pse_100_loan_under_ccf_amt;
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
	public BigDecimal getR57_bnk_0_undrawn_bal() {
		return r57_bnk_0_undrawn_bal;
	}
	public void setR57_bnk_0_undrawn_bal(BigDecimal r57_bnk_0_undrawn_bal) {
		this.r57_bnk_0_undrawn_bal = r57_bnk_0_undrawn_bal;
	}
	public BigDecimal getR57_bnk_0_loan_undrwn_adj_crm() {
		return r57_bnk_0_loan_undrwn_adj_crm;
	}
	public void setR57_bnk_0_loan_undrwn_adj_crm(BigDecimal r57_bnk_0_loan_undrwn_adj_crm) {
		this.r57_bnk_0_loan_undrwn_adj_crm = r57_bnk_0_loan_undrwn_adj_crm;
	}
	public BigDecimal getR57_bnk_0_loan_undrwn_rwa() {
		return r57_bnk_0_loan_undrwn_rwa;
	}
	public void setR57_bnk_0_loan_undrwn_rwa(BigDecimal r57_bnk_0_loan_undrwn_rwa) {
		this.r57_bnk_0_loan_undrwn_rwa = r57_bnk_0_loan_undrwn_rwa;
	}
	public BigDecimal getR57_bnk_0_loan_under_ccf_amt() {
		return r57_bnk_0_loan_under_ccf_amt;
	}
	public void setR57_bnk_0_loan_under_ccf_amt(BigDecimal r57_bnk_0_loan_under_ccf_amt) {
		this.r57_bnk_0_loan_under_ccf_amt = r57_bnk_0_loan_under_ccf_amt;
	}
	public BigDecimal getR58_bnk_20_undrawn_bal() {
		return r58_bnk_20_undrawn_bal;
	}
	public void setR58_bnk_20_undrawn_bal(BigDecimal r58_bnk_20_undrawn_bal) {
		this.r58_bnk_20_undrawn_bal = r58_bnk_20_undrawn_bal;
	}
	public BigDecimal getR58_bnk_20_loan_undrwn_adj_crm() {
		return r58_bnk_20_loan_undrwn_adj_crm;
	}
	public void setR58_bnk_20_loan_undrwn_adj_crm(BigDecimal r58_bnk_20_loan_undrwn_adj_crm) {
		this.r58_bnk_20_loan_undrwn_adj_crm = r58_bnk_20_loan_undrwn_adj_crm;
	}
	public BigDecimal getR58_bnk_20_loan_undrwn_rwa() {
		return r58_bnk_20_loan_undrwn_rwa;
	}
	public void setR58_bnk_20_loan_undrwn_rwa(BigDecimal r58_bnk_20_loan_undrwn_rwa) {
		this.r58_bnk_20_loan_undrwn_rwa = r58_bnk_20_loan_undrwn_rwa;
	}
	public BigDecimal getR58_bnk_20_loan_under_ccf_amt() {
		return r58_bnk_20_loan_under_ccf_amt;
	}
	public void setR58_bnk_20_loan_under_ccf_amt(BigDecimal r58_bnk_20_loan_under_ccf_amt) {
		this.r58_bnk_20_loan_under_ccf_amt = r58_bnk_20_loan_under_ccf_amt;
	}
	public BigDecimal getR59_bnk_50_undrawn_bal() {
		return r59_bnk_50_undrawn_bal;
	}
	public void setR59_bnk_50_undrawn_bal(BigDecimal r59_bnk_50_undrawn_bal) {
		this.r59_bnk_50_undrawn_bal = r59_bnk_50_undrawn_bal;
	}
	public BigDecimal getR59_bnk_50_loan_undrwn_adj_crm() {
		return r59_bnk_50_loan_undrwn_adj_crm;
	}
	public void setR59_bnk_50_loan_undrwn_adj_crm(BigDecimal r59_bnk_50_loan_undrwn_adj_crm) {
		this.r59_bnk_50_loan_undrwn_adj_crm = r59_bnk_50_loan_undrwn_adj_crm;
	}
	public BigDecimal getR59_bnk_50_loan_undrwn_rwa() {
		return r59_bnk_50_loan_undrwn_rwa;
	}
	public void setR59_bnk_50_loan_undrwn_rwa(BigDecimal r59_bnk_50_loan_undrwn_rwa) {
		this.r59_bnk_50_loan_undrwn_rwa = r59_bnk_50_loan_undrwn_rwa;
	}
	public BigDecimal getR59_bnk_50_loan_under_ccf_amt() {
		return r59_bnk_50_loan_under_ccf_amt;
	}
	public void setR59_bnk_50_loan_under_ccf_amt(BigDecimal r59_bnk_50_loan_under_ccf_amt) {
		this.r59_bnk_50_loan_under_ccf_amt = r59_bnk_50_loan_under_ccf_amt;
	}
	public BigDecimal getR60_bnk_100_undrawn_bal() {
		return r60_bnk_100_undrawn_bal;
	}
	public void setR60_bnk_100_undrawn_bal(BigDecimal r60_bnk_100_undrawn_bal) {
		this.r60_bnk_100_undrawn_bal = r60_bnk_100_undrawn_bal;
	}
	public BigDecimal getR60_bnk_100_loan_undrwn_adj_crm() {
		return r60_bnk_100_loan_undrwn_adj_crm;
	}
	public void setR60_bnk_100_loan_undrwn_adj_crm(BigDecimal r60_bnk_100_loan_undrwn_adj_crm) {
		this.r60_bnk_100_loan_undrwn_adj_crm = r60_bnk_100_loan_undrwn_adj_crm;
	}
	public BigDecimal getR60_bnk_100_loan_undrwn_rwa() {
		return r60_bnk_100_loan_undrwn_rwa;
	}
	public void setR60_bnk_100_loan_undrwn_rwa(BigDecimal r60_bnk_100_loan_undrwn_rwa) {
		this.r60_bnk_100_loan_undrwn_rwa = r60_bnk_100_loan_undrwn_rwa;
	}
	public BigDecimal getR60_bnk_100_loan_under_ccf_amt() {
		return r60_bnk_100_loan_under_ccf_amt;
	}
	public void setR60_bnk_100_loan_under_ccf_amt(BigDecimal r60_bnk_100_loan_under_ccf_amt) {
		this.r60_bnk_100_loan_under_ccf_amt = r60_bnk_100_loan_under_ccf_amt;
	}
	public BigDecimal getR61_bnk_150_undrawn_bal() {
		return r61_bnk_150_undrawn_bal;
	}
	public void setR61_bnk_150_undrawn_bal(BigDecimal r61_bnk_150_undrawn_bal) {
		this.r61_bnk_150_undrawn_bal = r61_bnk_150_undrawn_bal;
	}
	public BigDecimal getR61_bnk_150_loan_undrwn_adj_crm() {
		return r61_bnk_150_loan_undrwn_adj_crm;
	}
	public void setR61_bnk_150_loan_undrwn_adj_crm(BigDecimal r61_bnk_150_loan_undrwn_adj_crm) {
		this.r61_bnk_150_loan_undrwn_adj_crm = r61_bnk_150_loan_undrwn_adj_crm;
	}
	public BigDecimal getR61_bnk_150_loan_undrwn_rwa() {
		return r61_bnk_150_loan_undrwn_rwa;
	}
	public void setR61_bnk_150_loan_undrwn_rwa(BigDecimal r61_bnk_150_loan_undrwn_rwa) {
		this.r61_bnk_150_loan_undrwn_rwa = r61_bnk_150_loan_undrwn_rwa;
	}
	public BigDecimal getR61_bnk_150_loan_under_ccf_amt() {
		return r61_bnk_150_loan_under_ccf_amt;
	}
	public void setR61_bnk_150_loan_under_ccf_amt(BigDecimal r61_bnk_150_loan_under_ccf_amt) {
		this.r61_bnk_150_loan_under_ccf_amt = r61_bnk_150_loan_under_ccf_amt;
	}
	public BigDecimal getR62_cbs_0_undrawn_bal() {
		return r62_cbs_0_undrawn_bal;
	}
	public void setR62_cbs_0_undrawn_bal(BigDecimal r62_cbs_0_undrawn_bal) {
		this.r62_cbs_0_undrawn_bal = r62_cbs_0_undrawn_bal;
	}
	public BigDecimal getR62_cbs_0_loan_undrwn_adj_crm() {
		return r62_cbs_0_loan_undrwn_adj_crm;
	}
	public void setR62_cbs_0_loan_undrwn_adj_crm(BigDecimal r62_cbs_0_loan_undrwn_adj_crm) {
		this.r62_cbs_0_loan_undrwn_adj_crm = r62_cbs_0_loan_undrwn_adj_crm;
	}
	public BigDecimal getR62_cbs_0_loan_undrwn_rwa() {
		return r62_cbs_0_loan_undrwn_rwa;
	}
	public void setR62_cbs_0_loan_undrwn_rwa(BigDecimal r62_cbs_0_loan_undrwn_rwa) {
		this.r62_cbs_0_loan_undrwn_rwa = r62_cbs_0_loan_undrwn_rwa;
	}
	public BigDecimal getR62_cbs_0_loan_under_ccf_amt() {
		return r62_cbs_0_loan_under_ccf_amt;
	}
	public void setR62_cbs_0_loan_under_ccf_amt(BigDecimal r62_cbs_0_loan_under_ccf_amt) {
		this.r62_cbs_0_loan_under_ccf_amt = r62_cbs_0_loan_under_ccf_amt;
	}
	public BigDecimal getR63_cbs_20_undrawn_bal() {
		return r63_cbs_20_undrawn_bal;
	}
	public void setR63_cbs_20_undrawn_bal(BigDecimal r63_cbs_20_undrawn_bal) {
		this.r63_cbs_20_undrawn_bal = r63_cbs_20_undrawn_bal;
	}
	public BigDecimal getR63_cbs_20_loan_undrwn_adj_crm() {
		return r63_cbs_20_loan_undrwn_adj_crm;
	}
	public void setR63_cbs_20_loan_undrwn_adj_crm(BigDecimal r63_cbs_20_loan_undrwn_adj_crm) {
		this.r63_cbs_20_loan_undrwn_adj_crm = r63_cbs_20_loan_undrwn_adj_crm;
	}
	public BigDecimal getR63_cbs_20_loan_undrwn_rwa() {
		return r63_cbs_20_loan_undrwn_rwa;
	}
	public void setR63_cbs_20_loan_undrwn_rwa(BigDecimal r63_cbs_20_loan_undrwn_rwa) {
		this.r63_cbs_20_loan_undrwn_rwa = r63_cbs_20_loan_undrwn_rwa;
	}
	public BigDecimal getR63_cbs_20_loan_under_ccf_amt() {
		return r63_cbs_20_loan_under_ccf_amt;
	}
	public void setR63_cbs_20_loan_under_ccf_amt(BigDecimal r63_cbs_20_loan_under_ccf_amt) {
		this.r63_cbs_20_loan_under_ccf_amt = r63_cbs_20_loan_under_ccf_amt;
	}
	public BigDecimal getR64_cbs_20_undrawn_bal() {
		return r64_cbs_20_undrawn_bal;
	}
	public void setR64_cbs_20_undrawn_bal(BigDecimal r64_cbs_20_undrawn_bal) {
		this.r64_cbs_20_undrawn_bal = r64_cbs_20_undrawn_bal;
	}
	public BigDecimal getR64_cbs_20_loan_undrwn_adj_crm() {
		return r64_cbs_20_loan_undrwn_adj_crm;
	}
	public void setR64_cbs_20_loan_undrwn_adj_crm(BigDecimal r64_cbs_20_loan_undrwn_adj_crm) {
		this.r64_cbs_20_loan_undrwn_adj_crm = r64_cbs_20_loan_undrwn_adj_crm;
	}
	public BigDecimal getR64_cbs_20_loan_undrwn_rwa() {
		return r64_cbs_20_loan_undrwn_rwa;
	}
	public void setR64_cbs_20_loan_undrwn_rwa(BigDecimal r64_cbs_20_loan_undrwn_rwa) {
		this.r64_cbs_20_loan_undrwn_rwa = r64_cbs_20_loan_undrwn_rwa;
	}
	public BigDecimal getR64_cbs_20_loan_under_ccf_amt() {
		return r64_cbs_20_loan_under_ccf_amt;
	}
	public void setR64_cbs_20_loan_under_ccf_amt(BigDecimal r64_cbs_20_loan_under_ccf_amt) {
		this.r64_cbs_20_loan_under_ccf_amt = r64_cbs_20_loan_under_ccf_amt;
	}
	public BigDecimal getR65_cbs_0_undrawn_bal() {
		return r65_cbs_0_undrawn_bal;
	}
	public void setR65_cbs_0_undrawn_bal(BigDecimal r65_cbs_0_undrawn_bal) {
		this.r65_cbs_0_undrawn_bal = r65_cbs_0_undrawn_bal;
	}
	public BigDecimal getR65_cbs_0_loan_undrwn_adj_crm() {
		return r65_cbs_0_loan_undrwn_adj_crm;
	}
	public void setR65_cbs_0_loan_undrwn_adj_crm(BigDecimal r65_cbs_0_loan_undrwn_adj_crm) {
		this.r65_cbs_0_loan_undrwn_adj_crm = r65_cbs_0_loan_undrwn_adj_crm;
	}
	public BigDecimal getR65_cbs_0_loan_undrwn_rwa() {
		return r65_cbs_0_loan_undrwn_rwa;
	}
	public void setR65_cbs_0_loan_undrwn_rwa(BigDecimal r65_cbs_0_loan_undrwn_rwa) {
		this.r65_cbs_0_loan_undrwn_rwa = r65_cbs_0_loan_undrwn_rwa;
	}
	public BigDecimal getR65_cbs_0_loan_under_ccf_amt() {
		return r65_cbs_0_loan_under_ccf_amt;
	}
	public void setR65_cbs_0_loan_under_ccf_amt(BigDecimal r65_cbs_0_loan_under_ccf_amt) {
		this.r65_cbs_0_loan_under_ccf_amt = r65_cbs_0_loan_under_ccf_amt;
	}
	public BigDecimal getR66_cbs_20_undrawn_bal() {
		return r66_cbs_20_undrawn_bal;
	}
	public void setR66_cbs_20_undrawn_bal(BigDecimal r66_cbs_20_undrawn_bal) {
		this.r66_cbs_20_undrawn_bal = r66_cbs_20_undrawn_bal;
	}
	public BigDecimal getR66_cbs_20_loan_undrwn_adj_crm() {
		return r66_cbs_20_loan_undrwn_adj_crm;
	}
	public void setR66_cbs_20_loan_undrwn_adj_crm(BigDecimal r66_cbs_20_loan_undrwn_adj_crm) {
		this.r66_cbs_20_loan_undrwn_adj_crm = r66_cbs_20_loan_undrwn_adj_crm;
	}
	public BigDecimal getR66_cbs_20_loan_undrwn_rwa() {
		return r66_cbs_20_loan_undrwn_rwa;
	}
	public void setR66_cbs_20_loan_undrwn_rwa(BigDecimal r66_cbs_20_loan_undrwn_rwa) {
		this.r66_cbs_20_loan_undrwn_rwa = r66_cbs_20_loan_undrwn_rwa;
	}
	public BigDecimal getR66_cbs_20_loan_under_ccf_amt() {
		return r66_cbs_20_loan_under_ccf_amt;
	}
	public void setR66_cbs_20_loan_under_ccf_amt(BigDecimal r66_cbs_20_loan_under_ccf_amt) {
		this.r66_cbs_20_loan_under_ccf_amt = r66_cbs_20_loan_under_ccf_amt;
	}
	public BigDecimal getR67_cbs_50_undrawn_bal() {
		return r67_cbs_50_undrawn_bal;
	}
	public void setR67_cbs_50_undrawn_bal(BigDecimal r67_cbs_50_undrawn_bal) {
		this.r67_cbs_50_undrawn_bal = r67_cbs_50_undrawn_bal;
	}
	public BigDecimal getR67_cbs_50_loan_undrwn_adj_crm() {
		return r67_cbs_50_loan_undrwn_adj_crm;
	}
	public void setR67_cbs_50_loan_undrwn_adj_crm(BigDecimal r67_cbs_50_loan_undrwn_adj_crm) {
		this.r67_cbs_50_loan_undrwn_adj_crm = r67_cbs_50_loan_undrwn_adj_crm;
	}
	public BigDecimal getR67_cbs_50_loan_undrwn_rwa() {
		return r67_cbs_50_loan_undrwn_rwa;
	}
	public void setR67_cbs_50_loan_undrwn_rwa(BigDecimal r67_cbs_50_loan_undrwn_rwa) {
		this.r67_cbs_50_loan_undrwn_rwa = r67_cbs_50_loan_undrwn_rwa;
	}
	public BigDecimal getR67_cbs_50_loan_under_ccf_amt() {
		return r67_cbs_50_loan_under_ccf_amt;
	}
	public void setR67_cbs_50_loan_under_ccf_amt(BigDecimal r67_cbs_50_loan_under_ccf_amt) {
		this.r67_cbs_50_loan_under_ccf_amt = r67_cbs_50_loan_under_ccf_amt;
	}
	public BigDecimal getR68_cbs_100_undrawn_bal() {
		return r68_cbs_100_undrawn_bal;
	}
	public void setR68_cbs_100_undrawn_bal(BigDecimal r68_cbs_100_undrawn_bal) {
		this.r68_cbs_100_undrawn_bal = r68_cbs_100_undrawn_bal;
	}
	public BigDecimal getR68_cbs_100_loan_undrwn_adj_crm() {
		return r68_cbs_100_loan_undrwn_adj_crm;
	}
	public void setR68_cbs_100_loan_undrwn_adj_crm(BigDecimal r68_cbs_100_loan_undrwn_adj_crm) {
		this.r68_cbs_100_loan_undrwn_adj_crm = r68_cbs_100_loan_undrwn_adj_crm;
	}
	public BigDecimal getR68_cbs_100_loan_undrwn_rwa() {
		return r68_cbs_100_loan_undrwn_rwa;
	}
	public void setR68_cbs_100_loan_undrwn_rwa(BigDecimal r68_cbs_100_loan_undrwn_rwa) {
		this.r68_cbs_100_loan_undrwn_rwa = r68_cbs_100_loan_undrwn_rwa;
	}
	public BigDecimal getR68_cbs_100_loan_under_ccf_amt() {
		return r68_cbs_100_loan_under_ccf_amt;
	}
	public void setR68_cbs_100_loan_under_ccf_amt(BigDecimal r68_cbs_100_loan_under_ccf_amt) {
		this.r68_cbs_100_loan_under_ccf_amt = r68_cbs_100_loan_under_ccf_amt;
	}
	public BigDecimal getR69_cbs_150_undrawn_bal() {
		return r69_cbs_150_undrawn_bal;
	}
	public void setR69_cbs_150_undrawn_bal(BigDecimal r69_cbs_150_undrawn_bal) {
		this.r69_cbs_150_undrawn_bal = r69_cbs_150_undrawn_bal;
	}
	public BigDecimal getR69_cbs_150_loan_undrwn_adj_crm() {
		return r69_cbs_150_loan_undrwn_adj_crm;
	}
	public void setR69_cbs_150_loan_undrwn_adj_crm(BigDecimal r69_cbs_150_loan_undrwn_adj_crm) {
		this.r69_cbs_150_loan_undrwn_adj_crm = r69_cbs_150_loan_undrwn_adj_crm;
	}
	public BigDecimal getR69_cbs_150_loan_undrwn_rwa() {
		return r69_cbs_150_loan_undrwn_rwa;
	}
	public void setR69_cbs_150_loan_undrwn_rwa(BigDecimal r69_cbs_150_loan_undrwn_rwa) {
		this.r69_cbs_150_loan_undrwn_rwa = r69_cbs_150_loan_undrwn_rwa;
	}
	public BigDecimal getR69_cbs_150_loan_under_ccf_amt() {
		return r69_cbs_150_loan_under_ccf_amt;
	}
	public void setR69_cbs_150_loan_under_ccf_amt(BigDecimal r69_cbs_150_loan_under_ccf_amt) {
		this.r69_cbs_150_loan_under_ccf_amt = r69_cbs_150_loan_under_ccf_amt;
	}
	public BigDecimal getR70_cre_0_undrawn_bal() {
		return r70_cre_0_undrawn_bal;
	}
	public void setR70_cre_0_undrawn_bal(BigDecimal r70_cre_0_undrawn_bal) {
		this.r70_cre_0_undrawn_bal = r70_cre_0_undrawn_bal;
	}
	public BigDecimal getR70_cre_0_loan_undrwn_adj_crm() {
		return r70_cre_0_loan_undrwn_adj_crm;
	}
	public void setR70_cre_0_loan_undrwn_adj_crm(BigDecimal r70_cre_0_loan_undrwn_adj_crm) {
		this.r70_cre_0_loan_undrwn_adj_crm = r70_cre_0_loan_undrwn_adj_crm;
	}
	public BigDecimal getR70_cre_0_loan_undrwn_rwa() {
		return r70_cre_0_loan_undrwn_rwa;
	}
	public void setR70_cre_0_loan_undrwn_rwa(BigDecimal r70_cre_0_loan_undrwn_rwa) {
		this.r70_cre_0_loan_undrwn_rwa = r70_cre_0_loan_undrwn_rwa;
	}
	public BigDecimal getR70_cre_0_loan_under_ccf_amt() {
		return r70_cre_0_loan_under_ccf_amt;
	}
	public void setR70_cre_0_loan_under_ccf_amt(BigDecimal r70_cre_0_loan_under_ccf_amt) {
		this.r70_cre_0_loan_under_ccf_amt = r70_cre_0_loan_under_ccf_amt;
	}
	public BigDecimal getR71_cre_20_undrawn_bal() {
		return r71_cre_20_undrawn_bal;
	}
	public void setR71_cre_20_undrawn_bal(BigDecimal r71_cre_20_undrawn_bal) {
		this.r71_cre_20_undrawn_bal = r71_cre_20_undrawn_bal;
	}
	public BigDecimal getR71_cre_20_loan_undrwn_adj_crm() {
		return r71_cre_20_loan_undrwn_adj_crm;
	}
	public void setR71_cre_20_loan_undrwn_adj_crm(BigDecimal r71_cre_20_loan_undrwn_adj_crm) {
		this.r71_cre_20_loan_undrwn_adj_crm = r71_cre_20_loan_undrwn_adj_crm;
	}
	public BigDecimal getR71_cre_20_loan_undrwn_rwa() {
		return r71_cre_20_loan_undrwn_rwa;
	}
	public void setR71_cre_20_loan_undrwn_rwa(BigDecimal r71_cre_20_loan_undrwn_rwa) {
		this.r71_cre_20_loan_undrwn_rwa = r71_cre_20_loan_undrwn_rwa;
	}
	public BigDecimal getR71_cre_20_loan_under_ccf_amt() {
		return r71_cre_20_loan_under_ccf_amt;
	}
	public void setR71_cre_20_loan_under_ccf_amt(BigDecimal r71_cre_20_loan_under_ccf_amt) {
		this.r71_cre_20_loan_under_ccf_amt = r71_cre_20_loan_under_ccf_amt;
	}
	public BigDecimal getR72_cre_50_undrawn_bal() {
		return r72_cre_50_undrawn_bal;
	}
	public void setR72_cre_50_undrawn_bal(BigDecimal r72_cre_50_undrawn_bal) {
		this.r72_cre_50_undrawn_bal = r72_cre_50_undrawn_bal;
	}
	public BigDecimal getR72_cre_50_loan_undrwn_adj_crm() {
		return r72_cre_50_loan_undrwn_adj_crm;
	}
	public void setR72_cre_50_loan_undrwn_adj_crm(BigDecimal r72_cre_50_loan_undrwn_adj_crm) {
		this.r72_cre_50_loan_undrwn_adj_crm = r72_cre_50_loan_undrwn_adj_crm;
	}
	public BigDecimal getR72_cre_50_loan_undrwn_rwa() {
		return r72_cre_50_loan_undrwn_rwa;
	}
	public void setR72_cre_50_loan_undrwn_rwa(BigDecimal r72_cre_50_loan_undrwn_rwa) {
		this.r72_cre_50_loan_undrwn_rwa = r72_cre_50_loan_undrwn_rwa;
	}
	public BigDecimal getR72_cre_50_loan_under_ccf_amt() {
		return r72_cre_50_loan_under_ccf_amt;
	}
	public void setR72_cre_50_loan_under_ccf_amt(BigDecimal r72_cre_50_loan_under_ccf_amt) {
		this.r72_cre_50_loan_under_ccf_amt = r72_cre_50_loan_under_ccf_amt;
	}
	public BigDecimal getR73_cre_100_undrawn_bal() {
		return r73_cre_100_undrawn_bal;
	}
	public void setR73_cre_100_undrawn_bal(BigDecimal r73_cre_100_undrawn_bal) {
		this.r73_cre_100_undrawn_bal = r73_cre_100_undrawn_bal;
	}
	public BigDecimal getR73_cre_100_loan_undrwn_adj_crm() {
		return r73_cre_100_loan_undrwn_adj_crm;
	}
	public void setR73_cre_100_loan_undrwn_adj_crm(BigDecimal r73_cre_100_loan_undrwn_adj_crm) {
		this.r73_cre_100_loan_undrwn_adj_crm = r73_cre_100_loan_undrwn_adj_crm;
	}
	public BigDecimal getR73_cre_100_loan_undrwn_rwa() {
		return r73_cre_100_loan_undrwn_rwa;
	}
	public void setR73_cre_100_loan_undrwn_rwa(BigDecimal r73_cre_100_loan_undrwn_rwa) {
		this.r73_cre_100_loan_undrwn_rwa = r73_cre_100_loan_undrwn_rwa;
	}
	public BigDecimal getR73_cre_100_loan_under_ccf_amt() {
		return r73_cre_100_loan_under_ccf_amt;
	}
	public void setR73_cre_100_loan_under_ccf_amt(BigDecimal r73_cre_100_loan_under_ccf_amt) {
		this.r73_cre_100_loan_under_ccf_amt = r73_cre_100_loan_under_ccf_amt;
	}
	public BigDecimal getR74_cre_150_undrawn_bal() {
		return r74_cre_150_undrawn_bal;
	}
	public void setR74_cre_150_undrawn_bal(BigDecimal r74_cre_150_undrawn_bal) {
		this.r74_cre_150_undrawn_bal = r74_cre_150_undrawn_bal;
	}
	public BigDecimal getR74_cre_150_loan_undrwn_adj_crm() {
		return r74_cre_150_loan_undrwn_adj_crm;
	}
	public void setR74_cre_150_loan_undrwn_adj_crm(BigDecimal r74_cre_150_loan_undrwn_adj_crm) {
		this.r74_cre_150_loan_undrwn_adj_crm = r74_cre_150_loan_undrwn_adj_crm;
	}
	public BigDecimal getR74_cre_150_loan_undrwn_rwa() {
		return r74_cre_150_loan_undrwn_rwa;
	}
	public void setR74_cre_150_loan_undrwn_rwa(BigDecimal r74_cre_150_loan_undrwn_rwa) {
		this.r74_cre_150_loan_undrwn_rwa = r74_cre_150_loan_undrwn_rwa;
	}
	public BigDecimal getR74_cre_150_loan_under_ccf_amt() {
		return r74_cre_150_loan_under_ccf_amt;
	}
	public void setR74_cre_150_loan_under_ccf_amt(BigDecimal r74_cre_150_loan_under_ccf_amt) {
		this.r74_cre_150_loan_under_ccf_amt = r74_cre_150_loan_under_ccf_amt;
	}
	public BigDecimal getR75_crt_0_undrawn_bal() {
		return r75_crt_0_undrawn_bal;
	}
	public void setR75_crt_0_undrawn_bal(BigDecimal r75_crt_0_undrawn_bal) {
		this.r75_crt_0_undrawn_bal = r75_crt_0_undrawn_bal;
	}
	public BigDecimal getR75_crt_0_loan_undrwn_adj_crm() {
		return r75_crt_0_loan_undrwn_adj_crm;
	}
	public void setR75_crt_0_loan_undrwn_adj_crm(BigDecimal r75_crt_0_loan_undrwn_adj_crm) {
		this.r75_crt_0_loan_undrwn_adj_crm = r75_crt_0_loan_undrwn_adj_crm;
	}
	public BigDecimal getR75_crt_0_loan_undrwn_rwa() {
		return r75_crt_0_loan_undrwn_rwa;
	}
	public void setR75_crt_0_loan_undrwn_rwa(BigDecimal r75_crt_0_loan_undrwn_rwa) {
		this.r75_crt_0_loan_undrwn_rwa = r75_crt_0_loan_undrwn_rwa;
	}
	public BigDecimal getR75_crt_0_loan_under_ccf_amt() {
		return r75_crt_0_loan_under_ccf_amt;
	}
	public void setR75_crt_0_loan_under_ccf_amt(BigDecimal r75_crt_0_loan_under_ccf_amt) {
		this.r75_crt_0_loan_under_ccf_amt = r75_crt_0_loan_under_ccf_amt;
	}
	public BigDecimal getR76_crt_20_undrawn_bal() {
		return r76_crt_20_undrawn_bal;
	}
	public void setR76_crt_20_undrawn_bal(BigDecimal r76_crt_20_undrawn_bal) {
		this.r76_crt_20_undrawn_bal = r76_crt_20_undrawn_bal;
	}
	public BigDecimal getR76_crt_20_loan_undrwn_adj_crm() {
		return r76_crt_20_loan_undrwn_adj_crm;
	}
	public void setR76_crt_20_loan_undrwn_adj_crm(BigDecimal r76_crt_20_loan_undrwn_adj_crm) {
		this.r76_crt_20_loan_undrwn_adj_crm = r76_crt_20_loan_undrwn_adj_crm;
	}
	public BigDecimal getR76_crt_20_loan_undrwn_rwa() {
		return r76_crt_20_loan_undrwn_rwa;
	}
	public void setR76_crt_20_loan_undrwn_rwa(BigDecimal r76_crt_20_loan_undrwn_rwa) {
		this.r76_crt_20_loan_undrwn_rwa = r76_crt_20_loan_undrwn_rwa;
	}
	public BigDecimal getR76_crt_20_loan_under_ccf_amt() {
		return r76_crt_20_loan_under_ccf_amt;
	}
	public void setR76_crt_20_loan_under_ccf_amt(BigDecimal r76_crt_20_loan_under_ccf_amt) {
		this.r76_crt_20_loan_under_ccf_amt = r76_crt_20_loan_under_ccf_amt;
	}
	public BigDecimal getR77_crt_50_undrawn_bal() {
		return r77_crt_50_undrawn_bal;
	}
	public void setR77_crt_50_undrawn_bal(BigDecimal r77_crt_50_undrawn_bal) {
		this.r77_crt_50_undrawn_bal = r77_crt_50_undrawn_bal;
	}
	public BigDecimal getR77_crt_50_loan_undrwn_adj_crm() {
		return r77_crt_50_loan_undrwn_adj_crm;
	}
	public void setR77_crt_50_loan_undrwn_adj_crm(BigDecimal r77_crt_50_loan_undrwn_adj_crm) {
		this.r77_crt_50_loan_undrwn_adj_crm = r77_crt_50_loan_undrwn_adj_crm;
	}
	public BigDecimal getR77_crt_50_loan_undrwn_rwa() {
		return r77_crt_50_loan_undrwn_rwa;
	}
	public void setR77_crt_50_loan_undrwn_rwa(BigDecimal r77_crt_50_loan_undrwn_rwa) {
		this.r77_crt_50_loan_undrwn_rwa = r77_crt_50_loan_undrwn_rwa;
	}
	public BigDecimal getR77_crt_50_loan_under_ccf_amt() {
		return r77_crt_50_loan_under_ccf_amt;
	}
	public void setR77_crt_50_loan_under_ccf_amt(BigDecimal r77_crt_50_loan_under_ccf_amt) {
		this.r77_crt_50_loan_under_ccf_amt = r77_crt_50_loan_under_ccf_amt;
	}
	public BigDecimal getR78_crt_100_undrawn_bal() {
		return r78_crt_100_undrawn_bal;
	}
	public void setR78_crt_100_undrawn_bal(BigDecimal r78_crt_100_undrawn_bal) {
		this.r78_crt_100_undrawn_bal = r78_crt_100_undrawn_bal;
	}
	public BigDecimal getR78_crt_100_loan_undrwn_adj_crm() {
		return r78_crt_100_loan_undrwn_adj_crm;
	}
	public void setR78_crt_100_loan_undrwn_adj_crm(BigDecimal r78_crt_100_loan_undrwn_adj_crm) {
		this.r78_crt_100_loan_undrwn_adj_crm = r78_crt_100_loan_undrwn_adj_crm;
	}
	public BigDecimal getR78_crt_100_loan_undrwn_rwa() {
		return r78_crt_100_loan_undrwn_rwa;
	}
	public void setR78_crt_100_loan_undrwn_rwa(BigDecimal r78_crt_100_loan_undrwn_rwa) {
		this.r78_crt_100_loan_undrwn_rwa = r78_crt_100_loan_undrwn_rwa;
	}
	public BigDecimal getR78_crt_100_loan_under_ccf_amt() {
		return r78_crt_100_loan_under_ccf_amt;
	}
	public void setR78_crt_100_loan_under_ccf_amt(BigDecimal r78_crt_100_loan_under_ccf_amt) {
		this.r78_crt_100_loan_under_ccf_amt = r78_crt_100_loan_under_ccf_amt;
	}
	public BigDecimal getR79_crt_150_undrawn_bal() {
		return r79_crt_150_undrawn_bal;
	}
	public void setR79_crt_150_undrawn_bal(BigDecimal r79_crt_150_undrawn_bal) {
		this.r79_crt_150_undrawn_bal = r79_crt_150_undrawn_bal;
	}
	public BigDecimal getR79_crt_150_loan_undrwn_adj_crm() {
		return r79_crt_150_loan_undrwn_adj_crm;
	}
	public void setR79_crt_150_loan_undrwn_adj_crm(BigDecimal r79_crt_150_loan_undrwn_adj_crm) {
		this.r79_crt_150_loan_undrwn_adj_crm = r79_crt_150_loan_undrwn_adj_crm;
	}
	public BigDecimal getR79_crt_150_loan_undrwn_rwa() {
		return r79_crt_150_loan_undrwn_rwa;
	}
	public void setR79_crt_150_loan_undrwn_rwa(BigDecimal r79_crt_150_loan_undrwn_rwa) {
		this.r79_crt_150_loan_undrwn_rwa = r79_crt_150_loan_undrwn_rwa;
	}
	public BigDecimal getR79_crt_150_loan_under_ccf_amt() {
		return r79_crt_150_loan_under_ccf_amt;
	}
	public void setR79_crt_150_loan_under_ccf_amt(BigDecimal r79_crt_150_loan_under_ccf_amt) {
		this.r79_crt_150_loan_under_ccf_amt = r79_crt_150_loan_under_ccf_amt;
	}
	public BigDecimal getR80_hni_150_undrawn_bal() {
		return r80_hni_150_undrawn_bal;
	}
	public void setR80_hni_150_undrawn_bal(BigDecimal r80_hni_150_undrawn_bal) {
		this.r80_hni_150_undrawn_bal = r80_hni_150_undrawn_bal;
	}
	public BigDecimal getR80_hni_150_loan_undrwn_adj_crm() {
		return r80_hni_150_loan_undrwn_adj_crm;
	}
	public void setR80_hni_150_loan_undrwn_adj_crm(BigDecimal r80_hni_150_loan_undrwn_adj_crm) {
		this.r80_hni_150_loan_undrwn_adj_crm = r80_hni_150_loan_undrwn_adj_crm;
	}
	public BigDecimal getR80_hni_150_loan_undrwn_rwa() {
		return r80_hni_150_loan_undrwn_rwa;
	}
	public void setR80_hni_150_loan_undrwn_rwa(BigDecimal r80_hni_150_loan_undrwn_rwa) {
		this.r80_hni_150_loan_undrwn_rwa = r80_hni_150_loan_undrwn_rwa;
	}
	public BigDecimal getR80_hni_150_loan_under_ccf_amt() {
		return r80_hni_150_loan_under_ccf_amt;
	}
	public void setR80_hni_150_loan_under_ccf_amt(BigDecimal r80_hni_150_loan_under_ccf_amt) {
		this.r80_hni_150_loan_under_ccf_amt = r80_hni_150_loan_under_ccf_amt;
	}
	public BigDecimal getR81_pdl_100_undrawn_bal() {
		return r81_pdl_100_undrawn_bal;
	}
	public void setR81_pdl_100_undrawn_bal(BigDecimal r81_pdl_100_undrawn_bal) {
		this.r81_pdl_100_undrawn_bal = r81_pdl_100_undrawn_bal;
	}
	public BigDecimal getR81_pdl_100_loan_undrwn_adj_crm() {
		return r81_pdl_100_loan_undrwn_adj_crm;
	}
	public void setR81_pdl_100_loan_undrwn_adj_crm(BigDecimal r81_pdl_100_loan_undrwn_adj_crm) {
		this.r81_pdl_100_loan_undrwn_adj_crm = r81_pdl_100_loan_undrwn_adj_crm;
	}
	public BigDecimal getR81_pdl_100_loan_undrwn_rwa() {
		return r81_pdl_100_loan_undrwn_rwa;
	}
	public void setR81_pdl_100_loan_undrwn_rwa(BigDecimal r81_pdl_100_loan_undrwn_rwa) {
		this.r81_pdl_100_loan_undrwn_rwa = r81_pdl_100_loan_undrwn_rwa;
	}
	public BigDecimal getR81_pdl_100_loan_under_ccf_amt() {
		return r81_pdl_100_loan_under_ccf_amt;
	}
	public void setR81_pdl_100_loan_under_ccf_amt(BigDecimal r81_pdl_100_loan_under_ccf_amt) {
		this.r81_pdl_100_loan_under_ccf_amt = r81_pdl_100_loan_under_ccf_amt;
	}
	public BigDecimal getR82_pdl_150_undrawn_bal() {
		return r82_pdl_150_undrawn_bal;
	}
	public void setR82_pdl_150_undrawn_bal(BigDecimal r82_pdl_150_undrawn_bal) {
		this.r82_pdl_150_undrawn_bal = r82_pdl_150_undrawn_bal;
	}
	public BigDecimal getR82_pdl_150_loan_undrwn_adj_crm() {
		return r82_pdl_150_loan_undrwn_adj_crm;
	}
	public void setR82_pdl_150_loan_undrwn_adj_crm(BigDecimal r82_pdl_150_loan_undrwn_adj_crm) {
		this.r82_pdl_150_loan_undrwn_adj_crm = r82_pdl_150_loan_undrwn_adj_crm;
	}
	public BigDecimal getR82_pdl_150_loan_undrwn_rwa() {
		return r82_pdl_150_loan_undrwn_rwa;
	}
	public void setR82_pdl_150_loan_undrwn_rwa(BigDecimal r82_pdl_150_loan_undrwn_rwa) {
		this.r82_pdl_150_loan_undrwn_rwa = r82_pdl_150_loan_undrwn_rwa;
	}
	public BigDecimal getR82_pdl_150_loan_under_ccf_amt() {
		return r82_pdl_150_loan_under_ccf_amt;
	}
	public void setR82_pdl_150_loan_under_ccf_amt(BigDecimal r82_pdl_150_loan_under_ccf_amt) {
		this.r82_pdl_150_loan_under_ccf_amt = r82_pdl_150_loan_under_ccf_amt;
	}
	public BigDecimal getR83_pse_0_undrawn_bal() {
		return r83_pse_0_undrawn_bal;
	}
	public void setR83_pse_0_undrawn_bal(BigDecimal r83_pse_0_undrawn_bal) {
		this.r83_pse_0_undrawn_bal = r83_pse_0_undrawn_bal;
	}
	public BigDecimal getR83_pse_0_loan_undrwn_adj_crm() {
		return r83_pse_0_loan_undrwn_adj_crm;
	}
	public void setR83_pse_0_loan_undrwn_adj_crm(BigDecimal r83_pse_0_loan_undrwn_adj_crm) {
		this.r83_pse_0_loan_undrwn_adj_crm = r83_pse_0_loan_undrwn_adj_crm;
	}
	public BigDecimal getR83_pse_0_loan_undrwn_rwa() {
		return r83_pse_0_loan_undrwn_rwa;
	}
	public void setR83_pse_0_loan_undrwn_rwa(BigDecimal r83_pse_0_loan_undrwn_rwa) {
		this.r83_pse_0_loan_undrwn_rwa = r83_pse_0_loan_undrwn_rwa;
	}
	public BigDecimal getR83_pse_0_loan_under_ccf_amt() {
		return r83_pse_0_loan_under_ccf_amt;
	}
	public void setR83_pse_0_loan_under_ccf_amt(BigDecimal r83_pse_0_loan_under_ccf_amt) {
		this.r83_pse_0_loan_under_ccf_amt = r83_pse_0_loan_under_ccf_amt;
	}
	public BigDecimal getR84_pse_20_undrawn_bal() {
		return r84_pse_20_undrawn_bal;
	}
	public void setR84_pse_20_undrawn_bal(BigDecimal r84_pse_20_undrawn_bal) {
		this.r84_pse_20_undrawn_bal = r84_pse_20_undrawn_bal;
	}
	public BigDecimal getR84_pse_20_loan_undrwn_adj_crm() {
		return r84_pse_20_loan_undrwn_adj_crm;
	}
	public void setR84_pse_20_loan_undrwn_adj_crm(BigDecimal r84_pse_20_loan_undrwn_adj_crm) {
		this.r84_pse_20_loan_undrwn_adj_crm = r84_pse_20_loan_undrwn_adj_crm;
	}
	public BigDecimal getR84_pse_20_loan_undrwn_rwa() {
		return r84_pse_20_loan_undrwn_rwa;
	}
	public void setR84_pse_20_loan_undrwn_rwa(BigDecimal r84_pse_20_loan_undrwn_rwa) {
		this.r84_pse_20_loan_undrwn_rwa = r84_pse_20_loan_undrwn_rwa;
	}
	public BigDecimal getR84_pse_20_loan_under_ccf_amt() {
		return r84_pse_20_loan_under_ccf_amt;
	}
	public void setR84_pse_20_loan_under_ccf_amt(BigDecimal r84_pse_20_loan_under_ccf_amt) {
		this.r84_pse_20_loan_under_ccf_amt = r84_pse_20_loan_under_ccf_amt;
	}
	public BigDecimal getR85_pse_50_undrawn_bal() {
		return r85_pse_50_undrawn_bal;
	}
	public void setR85_pse_50_undrawn_bal(BigDecimal r85_pse_50_undrawn_bal) {
		this.r85_pse_50_undrawn_bal = r85_pse_50_undrawn_bal;
	}
	public BigDecimal getR85_pse_50_loan_undrwn_adj_crm() {
		return r85_pse_50_loan_undrwn_adj_crm;
	}
	public void setR85_pse_50_loan_undrwn_adj_crm(BigDecimal r85_pse_50_loan_undrwn_adj_crm) {
		this.r85_pse_50_loan_undrwn_adj_crm = r85_pse_50_loan_undrwn_adj_crm;
	}
	public BigDecimal getR85_pse_50_loan_undrwn_rwa() {
		return r85_pse_50_loan_undrwn_rwa;
	}
	public void setR85_pse_50_loan_undrwn_rwa(BigDecimal r85_pse_50_loan_undrwn_rwa) {
		this.r85_pse_50_loan_undrwn_rwa = r85_pse_50_loan_undrwn_rwa;
	}
	public BigDecimal getR85_pse_50_loan_under_ccf_amt() {
		return r85_pse_50_loan_under_ccf_amt;
	}
	public void setR85_pse_50_loan_under_ccf_amt(BigDecimal r85_pse_50_loan_under_ccf_amt) {
		this.r85_pse_50_loan_under_ccf_amt = r85_pse_50_loan_under_ccf_amt;
	}
	public BigDecimal getR86_pse_100_undrawn_bal() {
		return r86_pse_100_undrawn_bal;
	}
	public void setR86_pse_100_undrawn_bal(BigDecimal r86_pse_100_undrawn_bal) {
		this.r86_pse_100_undrawn_bal = r86_pse_100_undrawn_bal;
	}
	public BigDecimal getR86_pse_100_loan_undrwn_adj_crm() {
		return r86_pse_100_loan_undrwn_adj_crm;
	}
	public void setR86_pse_100_loan_undrwn_adj_crm(BigDecimal r86_pse_100_loan_undrwn_adj_crm) {
		this.r86_pse_100_loan_undrwn_adj_crm = r86_pse_100_loan_undrwn_adj_crm;
	}
	public BigDecimal getR86_pse_100_loan_undrwn_rwa() {
		return r86_pse_100_loan_undrwn_rwa;
	}
	public void setR86_pse_100_loan_undrwn_rwa(BigDecimal r86_pse_100_loan_undrwn_rwa) {
		this.r86_pse_100_loan_undrwn_rwa = r86_pse_100_loan_undrwn_rwa;
	}
	public BigDecimal getR86_pse_100_loan_under_ccf_amt() {
		return r86_pse_100_loan_under_ccf_amt;
	}
	public void setR86_pse_100_loan_under_ccf_amt(BigDecimal r86_pse_100_loan_under_ccf_amt) {
		this.r86_pse_100_loan_under_ccf_amt = r86_pse_100_loan_under_ccf_amt;
	}
	public BigDecimal getR87_pse_150_undrawn_bal() {
		return r87_pse_150_undrawn_bal;
	}
	public void setR87_pse_150_undrawn_bal(BigDecimal r87_pse_150_undrawn_bal) {
		this.r87_pse_150_undrawn_bal = r87_pse_150_undrawn_bal;
	}
	public BigDecimal getR87_pse_150_loan_undrwn_adj_crm() {
		return r87_pse_150_loan_undrwn_adj_crm;
	}
	public void setR87_pse_150_loan_undrwn_adj_crm(BigDecimal r87_pse_150_loan_undrwn_adj_crm) {
		this.r87_pse_150_loan_undrwn_adj_crm = r87_pse_150_loan_undrwn_adj_crm;
	}
	public BigDecimal getR87_pse_150_loan_undrwn_rwa() {
		return r87_pse_150_loan_undrwn_rwa;
	}
	public void setR87_pse_150_loan_undrwn_rwa(BigDecimal r87_pse_150_loan_undrwn_rwa) {
		this.r87_pse_150_loan_undrwn_rwa = r87_pse_150_loan_undrwn_rwa;
	}
	public BigDecimal getR87_pse_150_loan_under_ccf_amt() {
		return r87_pse_150_loan_under_ccf_amt;
	}
	public void setR87_pse_150_loan_under_ccf_amt(BigDecimal r87_pse_150_loan_under_ccf_amt) {
		this.r87_pse_150_loan_under_ccf_amt = r87_pse_150_loan_under_ccf_amt;
	}
	public BigDecimal getR88_rse_35_undrawn_bal() {
		return r88_rse_35_undrawn_bal;
	}
	public void setR88_rse_35_undrawn_bal(BigDecimal r88_rse_35_undrawn_bal) {
		this.r88_rse_35_undrawn_bal = r88_rse_35_undrawn_bal;
	}
	public BigDecimal getR88_rse_35_loan_undrwn_adj_crm() {
		return r88_rse_35_loan_undrwn_adj_crm;
	}
	public void setR88_rse_35_loan_undrwn_adj_crm(BigDecimal r88_rse_35_loan_undrwn_adj_crm) {
		this.r88_rse_35_loan_undrwn_adj_crm = r88_rse_35_loan_undrwn_adj_crm;
	}
	public BigDecimal getR88_rse_35_loan_undrwn_rwa() {
		return r88_rse_35_loan_undrwn_rwa;
	}
	public void setR88_rse_35_loan_undrwn_rwa(BigDecimal r88_rse_35_loan_undrwn_rwa) {
		this.r88_rse_35_loan_undrwn_rwa = r88_rse_35_loan_undrwn_rwa;
	}
	public BigDecimal getR88_rse_35_loan_under_ccf_amt() {
		return r88_rse_35_loan_under_ccf_amt;
	}
	public void setR88_rse_35_loan_under_ccf_amt(BigDecimal r88_rse_35_loan_under_ccf_amt) {
		this.r88_rse_35_loan_under_ccf_amt = r88_rse_35_loan_under_ccf_amt;
	}
	public BigDecimal getR89_rse_100_undrawn_bal() {
		return r89_rse_100_undrawn_bal;
	}
	public void setR89_rse_100_undrawn_bal(BigDecimal r89_rse_100_undrawn_bal) {
		this.r89_rse_100_undrawn_bal = r89_rse_100_undrawn_bal;
	}
	public BigDecimal getR89_rse_100_loan_undrwn_adj_crm() {
		return r89_rse_100_loan_undrwn_adj_crm;
	}
	public void setR89_rse_100_loan_undrwn_adj_crm(BigDecimal r89_rse_100_loan_undrwn_adj_crm) {
		this.r89_rse_100_loan_undrwn_adj_crm = r89_rse_100_loan_undrwn_adj_crm;
	}
	public BigDecimal getR89_rse_100_loan_undrwn_rwa() {
		return r89_rse_100_loan_undrwn_rwa;
	}
	public void setR89_rse_100_loan_undrwn_rwa(BigDecimal r89_rse_100_loan_undrwn_rwa) {
		this.r89_rse_100_loan_undrwn_rwa = r89_rse_100_loan_undrwn_rwa;
	}
	public BigDecimal getR89_rse_100_loan_under_ccf_amt() {
		return r89_rse_100_loan_under_ccf_amt;
	}
	public void setR89_rse_100_loan_under_ccf_amt(BigDecimal r89_rse_100_loan_under_ccf_amt) {
		this.r89_rse_100_loan_under_ccf_amt = r89_rse_100_loan_under_ccf_amt;
	}
	public BigDecimal getR90_pse_75_undrawn_bal() {
		return r90_pse_75_undrawn_bal;
	}
	public void setR90_pse_75_undrawn_bal(BigDecimal r90_pse_75_undrawn_bal) {
		this.r90_pse_75_undrawn_bal = r90_pse_75_undrawn_bal;
	}
	public BigDecimal getR90_pse_75_loan_undrwn_adj_crm() {
		return r90_pse_75_loan_undrwn_adj_crm;
	}
	public void setR90_pse_75_loan_undrwn_adj_crm(BigDecimal r90_pse_75_loan_undrwn_adj_crm) {
		this.r90_pse_75_loan_undrwn_adj_crm = r90_pse_75_loan_undrwn_adj_crm;
	}
	public BigDecimal getR90_pse_75_loan_undrwn_rwa() {
		return r90_pse_75_loan_undrwn_rwa;
	}
	public void setR90_pse_75_loan_undrwn_rwa(BigDecimal r90_pse_75_loan_undrwn_rwa) {
		this.r90_pse_75_loan_undrwn_rwa = r90_pse_75_loan_undrwn_rwa;
	}
	public BigDecimal getR90_pse_75_loan_under_ccf_amt() {
		return r90_pse_75_loan_under_ccf_amt;
	}
	public void setR90_pse_75_loan_under_ccf_amt(BigDecimal r90_pse_75_loan_under_ccf_amt) {
		this.r90_pse_75_loan_under_ccf_amt = r90_pse_75_loan_under_ccf_amt;
	}
	public BigDecimal getR91_pse_100_undrawn_bal() {
		return r91_pse_100_undrawn_bal;
	}
	public void setR91_pse_100_undrawn_bal(BigDecimal r91_pse_100_undrawn_bal) {
		this.r91_pse_100_undrawn_bal = r91_pse_100_undrawn_bal;
	}
	public BigDecimal getR91_pse_100_loan_undrwn_adj_crm() {
		return r91_pse_100_loan_undrwn_adj_crm;
	}
	public void setR91_pse_100_loan_undrwn_adj_crm(BigDecimal r91_pse_100_loan_undrwn_adj_crm) {
		this.r91_pse_100_loan_undrwn_adj_crm = r91_pse_100_loan_undrwn_adj_crm;
	}
	public BigDecimal getR91_pse_100_loan_undrwn_rwa() {
		return r91_pse_100_loan_undrwn_rwa;
	}
	public void setR91_pse_100_loan_undrwn_rwa(BigDecimal r91_pse_100_loan_undrwn_rwa) {
		this.r91_pse_100_loan_undrwn_rwa = r91_pse_100_loan_undrwn_rwa;
	}
	public BigDecimal getR91_pse_100_loan_under_ccf_amt() {
		return r91_pse_100_loan_under_ccf_amt;
	}
	public void setR91_pse_100_loan_under_ccf_amt(BigDecimal r91_pse_100_loan_under_ccf_amt) {
		this.r91_pse_100_loan_under_ccf_amt = r91_pse_100_loan_under_ccf_amt;
	}
	public BigDecimal getR92_pse_75_undrawn_bal() {
		return r92_pse_75_undrawn_bal;
	}
	public void setR92_pse_75_undrawn_bal(BigDecimal r92_pse_75_undrawn_bal) {
		this.r92_pse_75_undrawn_bal = r92_pse_75_undrawn_bal;
	}
	public BigDecimal getR92_pse_75_loan_undrwn_adj_crm() {
		return r92_pse_75_loan_undrwn_adj_crm;
	}
	public void setR92_pse_75_loan_undrwn_adj_crm(BigDecimal r92_pse_75_loan_undrwn_adj_crm) {
		this.r92_pse_75_loan_undrwn_adj_crm = r92_pse_75_loan_undrwn_adj_crm;
	}
	public BigDecimal getR92_pse_75_loan_undrwn_rwa() {
		return r92_pse_75_loan_undrwn_rwa;
	}
	public void setR92_pse_75_loan_undrwn_rwa(BigDecimal r92_pse_75_loan_undrwn_rwa) {
		this.r92_pse_75_loan_undrwn_rwa = r92_pse_75_loan_undrwn_rwa;
	}
	public BigDecimal getR92_pse_75_loan_under_ccf_amt() {
		return r92_pse_75_loan_under_ccf_amt;
	}
	public void setR92_pse_75_loan_under_ccf_amt(BigDecimal r92_pse_75_loan_under_ccf_amt) {
		this.r92_pse_75_loan_under_ccf_amt = r92_pse_75_loan_under_ccf_amt;
	}
	public BigDecimal getR93_pse_100_undrawn_bal() {
		return r93_pse_100_undrawn_bal;
	}
	public void setR93_pse_100_undrawn_bal(BigDecimal r93_pse_100_undrawn_bal) {
		this.r93_pse_100_undrawn_bal = r93_pse_100_undrawn_bal;
	}
	public BigDecimal getR93_pse_100_loan_undrwn_adj_crm() {
		return r93_pse_100_loan_undrwn_adj_crm;
	}
	public void setR93_pse_100_loan_undrwn_adj_crm(BigDecimal r93_pse_100_loan_undrwn_adj_crm) {
		this.r93_pse_100_loan_undrwn_adj_crm = r93_pse_100_loan_undrwn_adj_crm;
	}
	public BigDecimal getR93_pse_100_loan_undrwn_rwa() {
		return r93_pse_100_loan_undrwn_rwa;
	}
	public void setR93_pse_100_loan_undrwn_rwa(BigDecimal r93_pse_100_loan_undrwn_rwa) {
		this.r93_pse_100_loan_undrwn_rwa = r93_pse_100_loan_undrwn_rwa;
	}
	public BigDecimal getR93_pse_100_loan_under_ccf_amt() {
		return r93_pse_100_loan_under_ccf_amt;
	}
	public void setR93_pse_100_loan_under_ccf_amt(BigDecimal r93_pse_100_loan_under_ccf_amt) {
		this.r93_pse_100_loan_under_ccf_amt = r93_pse_100_loan_under_ccf_amt;
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
	public BRF95_FUND_BASED_UNDRAWN() {
		super();
		// TODO Auto-generated constructor stub
	}


}
