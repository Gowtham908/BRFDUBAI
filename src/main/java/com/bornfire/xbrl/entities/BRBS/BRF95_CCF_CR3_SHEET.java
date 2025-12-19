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
@Table(name="BRF95_CCF_CR3_SHEET")
public class BRF95_CCF_CR3_SHEET {
	private BigDecimal	ccf0_fund_undrwn_before_offbs;
	private BigDecimal	ccf0_fund_undrwn_crm;
	private BigDecimal	ccf0_fund_after_crm;
	private BigDecimal	ccf0_nonfund_before_offbs;
	private BigDecimal	ccf0_nonfund_crm;
	private BigDecimal	ccf0_nonfund_after_crm;
	private BigDecimal	ccf0_nonfund_undrwn_before_offbs;
	private BigDecimal	ccf0_nonfund_undrwn_crm;
	private BigDecimal	ccf0_nonfund_undrwn_after_crm;
	private BigDecimal	ccfp2_fund_undrwn_before_offbs;
	private BigDecimal	ccfp2_fund_undrwn_crm;
	private BigDecimal	ccfp2_fund_after_crm;
	private BigDecimal	ccfp2_nonfund_before_offbs;
	private BigDecimal	ccfp2_nonfund_crm;
	private BigDecimal	ccfp2_nonfund_after_crm;
	private BigDecimal	ccfp2_nonfund_undrwn_before_offbs;
	private BigDecimal	ccfp2_nonfund_undrwn_crm;
	private BigDecimal	ccfp2_nonfund_undrwn_after_crm;
	private BigDecimal	ccfp5_fund_undrwn_before_offbs;
	private BigDecimal	ccfp5_fund_undrwn_crm;
	private BigDecimal	ccfp5_fund_after_crm;
	private BigDecimal	ccfp5_nonfund_before_offbs;
	private BigDecimal	ccfp5_nonfund_crm;
	private BigDecimal	ccfp5_nonfund_after_crm;
	private BigDecimal	ccfp5_nonfund_undrwn_before_offbs;
	private BigDecimal	ccfp5_nonfund_undrwn_crm;
	private BigDecimal	ccfp5_nonfund_undrwn_after_crm;
	private BigDecimal	ccf1_fund_undrwn_before_offbs;
	private BigDecimal	ccf1_fund_undrwn_crm;
	private BigDecimal	ccf1_fund_after_crm;
	private BigDecimal	ccf1_nonfund_before_offbs;
	private BigDecimal	ccf1_nonfund_crm;
	private BigDecimal	ccf1_nonfund_after_crm;
	private BigDecimal	ccf1_nonfund_undrwn_before_offbs;
	private BigDecimal	ccf1_nonfund_undrwn_crm;
	private BigDecimal	ccf1_nonfund_undrwn_after_crm;
	@Id
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date	report_date;
	private Date	report_from_date;
	private Date	report_to_date;
	private Date	report_submit_date;
	private String	entity_flg;
	private String	modify_flg;
	private String	del_flg;
	public BigDecimal getCcf0_fund_undrwn_before_offbs() {
		return ccf0_fund_undrwn_before_offbs;
	}
	public void setCcf0_fund_undrwn_before_offbs(BigDecimal ccf0_fund_undrwn_before_offbs) {
		this.ccf0_fund_undrwn_before_offbs = ccf0_fund_undrwn_before_offbs;
	}
	public BigDecimal getCcf0_fund_undrwn_crm() {
		return ccf0_fund_undrwn_crm;
	}
	public void setCcf0_fund_undrwn_crm(BigDecimal ccf0_fund_undrwn_crm) {
		this.ccf0_fund_undrwn_crm = ccf0_fund_undrwn_crm;
	}
	public BigDecimal getCcf0_fund_after_crm() {
		return ccf0_fund_after_crm;
	}
	public void setCcf0_fund_after_crm(BigDecimal ccf0_fund_after_crm) {
		this.ccf0_fund_after_crm = ccf0_fund_after_crm;
	}
	public BigDecimal getCcf0_nonfund_before_offbs() {
		return ccf0_nonfund_before_offbs;
	}
	public void setCcf0_nonfund_before_offbs(BigDecimal ccf0_nonfund_before_offbs) {
		this.ccf0_nonfund_before_offbs = ccf0_nonfund_before_offbs;
	}
	public BigDecimal getCcf0_nonfund_crm() {
		return ccf0_nonfund_crm;
	}
	public void setCcf0_nonfund_crm(BigDecimal ccf0_nonfund_crm) {
		this.ccf0_nonfund_crm = ccf0_nonfund_crm;
	}
	public BigDecimal getCcf0_nonfund_after_crm() {
		return ccf0_nonfund_after_crm;
	}
	public void setCcf0_nonfund_after_crm(BigDecimal ccf0_nonfund_after_crm) {
		this.ccf0_nonfund_after_crm = ccf0_nonfund_after_crm;
	}
	public BigDecimal getCcf0_nonfund_undrwn_before_offbs() {
		return ccf0_nonfund_undrwn_before_offbs;
	}
	public void setCcf0_nonfund_undrwn_before_offbs(BigDecimal ccf0_nonfund_undrwn_before_offbs) {
		this.ccf0_nonfund_undrwn_before_offbs = ccf0_nonfund_undrwn_before_offbs;
	}
	public BigDecimal getCcf0_nonfund_undrwn_crm() {
		return ccf0_nonfund_undrwn_crm;
	}
	public void setCcf0_nonfund_undrwn_crm(BigDecimal ccf0_nonfund_undrwn_crm) {
		this.ccf0_nonfund_undrwn_crm = ccf0_nonfund_undrwn_crm;
	}
	public BigDecimal getCcf0_nonfund_undrwn_after_crm() {
		return ccf0_nonfund_undrwn_after_crm;
	}
	public void setCcf0_nonfund_undrwn_after_crm(BigDecimal ccf0_nonfund_undrwn_after_crm) {
		this.ccf0_nonfund_undrwn_after_crm = ccf0_nonfund_undrwn_after_crm;
	}
	public BigDecimal getCcfp2_fund_undrwn_before_offbs() {
		return ccfp2_fund_undrwn_before_offbs;
	}
	public void setCcfp2_fund_undrwn_before_offbs(BigDecimal ccfp2_fund_undrwn_before_offbs) {
		this.ccfp2_fund_undrwn_before_offbs = ccfp2_fund_undrwn_before_offbs;
	}
	public BigDecimal getCcfp2_fund_undrwn_crm() {
		return ccfp2_fund_undrwn_crm;
	}
	public void setCcfp2_fund_undrwn_crm(BigDecimal ccfp2_fund_undrwn_crm) {
		this.ccfp2_fund_undrwn_crm = ccfp2_fund_undrwn_crm;
	}
	public BigDecimal getCcfp2_fund_after_crm() {
		return ccfp2_fund_after_crm;
	}
	public void setCcfp2_fund_after_crm(BigDecimal ccfp2_fund_after_crm) {
		this.ccfp2_fund_after_crm = ccfp2_fund_after_crm;
	}
	public BigDecimal getCcfp2_nonfund_before_offbs() {
		return ccfp2_nonfund_before_offbs;
	}
	public void setCcfp2_nonfund_before_offbs(BigDecimal ccfp2_nonfund_before_offbs) {
		this.ccfp2_nonfund_before_offbs = ccfp2_nonfund_before_offbs;
	}
	public BigDecimal getCcfp2_nonfund_crm() {
		return ccfp2_nonfund_crm;
	}
	public void setCcfp2_nonfund_crm(BigDecimal ccfp2_nonfund_crm) {
		this.ccfp2_nonfund_crm = ccfp2_nonfund_crm;
	}
	public BigDecimal getCcfp2_nonfund_after_crm() {
		return ccfp2_nonfund_after_crm;
	}
	public void setCcfp2_nonfund_after_crm(BigDecimal ccfp2_nonfund_after_crm) {
		this.ccfp2_nonfund_after_crm = ccfp2_nonfund_after_crm;
	}
	public BigDecimal getCcfp2_nonfund_undrwn_before_offbs() {
		return ccfp2_nonfund_undrwn_before_offbs;
	}
	public void setCcfp2_nonfund_undrwn_before_offbs(BigDecimal ccfp2_nonfund_undrwn_before_offbs) {
		this.ccfp2_nonfund_undrwn_before_offbs = ccfp2_nonfund_undrwn_before_offbs;
	}
	public BigDecimal getCcfp2_nonfund_undrwn_crm() {
		return ccfp2_nonfund_undrwn_crm;
	}
	public void setCcfp2_nonfund_undrwn_crm(BigDecimal ccfp2_nonfund_undrwn_crm) {
		this.ccfp2_nonfund_undrwn_crm = ccfp2_nonfund_undrwn_crm;
	}
	public BigDecimal getCcfp2_nonfund_undrwn_after_crm() {
		return ccfp2_nonfund_undrwn_after_crm;
	}
	public void setCcfp2_nonfund_undrwn_after_crm(BigDecimal ccfp2_nonfund_undrwn_after_crm) {
		this.ccfp2_nonfund_undrwn_after_crm = ccfp2_nonfund_undrwn_after_crm;
	}
	public BigDecimal getCcfp5_fund_undrwn_before_offbs() {
		return ccfp5_fund_undrwn_before_offbs;
	}
	public void setCcfp5_fund_undrwn_before_offbs(BigDecimal ccfp5_fund_undrwn_before_offbs) {
		this.ccfp5_fund_undrwn_before_offbs = ccfp5_fund_undrwn_before_offbs;
	}
	public BigDecimal getCcfp5_fund_undrwn_crm() {
		return ccfp5_fund_undrwn_crm;
	}
	public void setCcfp5_fund_undrwn_crm(BigDecimal ccfp5_fund_undrwn_crm) {
		this.ccfp5_fund_undrwn_crm = ccfp5_fund_undrwn_crm;
	}
	public BigDecimal getCcfp5_fund_after_crm() {
		return ccfp5_fund_after_crm;
	}
	public void setCcfp5_fund_after_crm(BigDecimal ccfp5_fund_after_crm) {
		this.ccfp5_fund_after_crm = ccfp5_fund_after_crm;
	}
	public BigDecimal getCcfp5_nonfund_before_offbs() {
		return ccfp5_nonfund_before_offbs;
	}
	public void setCcfp5_nonfund_before_offbs(BigDecimal ccfp5_nonfund_before_offbs) {
		this.ccfp5_nonfund_before_offbs = ccfp5_nonfund_before_offbs;
	}
	public BigDecimal getCcfp5_nonfund_crm() {
		return ccfp5_nonfund_crm;
	}
	public void setCcfp5_nonfund_crm(BigDecimal ccfp5_nonfund_crm) {
		this.ccfp5_nonfund_crm = ccfp5_nonfund_crm;
	}
	public BigDecimal getCcfp5_nonfund_after_crm() {
		return ccfp5_nonfund_after_crm;
	}
	public void setCcfp5_nonfund_after_crm(BigDecimal ccfp5_nonfund_after_crm) {
		this.ccfp5_nonfund_after_crm = ccfp5_nonfund_after_crm;
	}
	public BigDecimal getCcfp5_nonfund_undrwn_before_offbs() {
		return ccfp5_nonfund_undrwn_before_offbs;
	}
	public void setCcfp5_nonfund_undrwn_before_offbs(BigDecimal ccfp5_nonfund_undrwn_before_offbs) {
		this.ccfp5_nonfund_undrwn_before_offbs = ccfp5_nonfund_undrwn_before_offbs;
	}
	public BigDecimal getCcfp5_nonfund_undrwn_crm() {
		return ccfp5_nonfund_undrwn_crm;
	}
	public void setCcfp5_nonfund_undrwn_crm(BigDecimal ccfp5_nonfund_undrwn_crm) {
		this.ccfp5_nonfund_undrwn_crm = ccfp5_nonfund_undrwn_crm;
	}
	public BigDecimal getCcfp5_nonfund_undrwn_after_crm() {
		return ccfp5_nonfund_undrwn_after_crm;
	}
	public void setCcfp5_nonfund_undrwn_after_crm(BigDecimal ccfp5_nonfund_undrwn_after_crm) {
		this.ccfp5_nonfund_undrwn_after_crm = ccfp5_nonfund_undrwn_after_crm;
	}
	public BigDecimal getCcf1_fund_undrwn_before_offbs() {
		return ccf1_fund_undrwn_before_offbs;
	}
	public void setCcf1_fund_undrwn_before_offbs(BigDecimal ccf1_fund_undrwn_before_offbs) {
		this.ccf1_fund_undrwn_before_offbs = ccf1_fund_undrwn_before_offbs;
	}
	public BigDecimal getCcf1_fund_undrwn_crm() {
		return ccf1_fund_undrwn_crm;
	}
	public void setCcf1_fund_undrwn_crm(BigDecimal ccf1_fund_undrwn_crm) {
		this.ccf1_fund_undrwn_crm = ccf1_fund_undrwn_crm;
	}
	public BigDecimal getCcf1_fund_after_crm() {
		return ccf1_fund_after_crm;
	}
	public void setCcf1_fund_after_crm(BigDecimal ccf1_fund_after_crm) {
		this.ccf1_fund_after_crm = ccf1_fund_after_crm;
	}
	public BigDecimal getCcf1_nonfund_before_offbs() {
		return ccf1_nonfund_before_offbs;
	}
	public void setCcf1_nonfund_before_offbs(BigDecimal ccf1_nonfund_before_offbs) {
		this.ccf1_nonfund_before_offbs = ccf1_nonfund_before_offbs;
	}
	public BigDecimal getCcf1_nonfund_crm() {
		return ccf1_nonfund_crm;
	}
	public void setCcf1_nonfund_crm(BigDecimal ccf1_nonfund_crm) {
		this.ccf1_nonfund_crm = ccf1_nonfund_crm;
	}
	public BigDecimal getCcf1_nonfund_after_crm() {
		return ccf1_nonfund_after_crm;
	}
	public void setCcf1_nonfund_after_crm(BigDecimal ccf1_nonfund_after_crm) {
		this.ccf1_nonfund_after_crm = ccf1_nonfund_after_crm;
	}
	public BigDecimal getCcf1_nonfund_undrwn_before_offbs() {
		return ccf1_nonfund_undrwn_before_offbs;
	}
	public void setCcf1_nonfund_undrwn_before_offbs(BigDecimal ccf1_nonfund_undrwn_before_offbs) {
		this.ccf1_nonfund_undrwn_before_offbs = ccf1_nonfund_undrwn_before_offbs;
	}
	public BigDecimal getCcf1_nonfund_undrwn_crm() {
		return ccf1_nonfund_undrwn_crm;
	}
	public void setCcf1_nonfund_undrwn_crm(BigDecimal ccf1_nonfund_undrwn_crm) {
		this.ccf1_nonfund_undrwn_crm = ccf1_nonfund_undrwn_crm;
	}
	public BigDecimal getCcf1_nonfund_undrwn_after_crm() {
		return ccf1_nonfund_undrwn_after_crm;
	}
	public void setCcf1_nonfund_undrwn_after_crm(BigDecimal ccf1_nonfund_undrwn_after_crm) {
		this.ccf1_nonfund_undrwn_after_crm = ccf1_nonfund_undrwn_after_crm;
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
	public Date getReport_submit_date() {
		return report_submit_date;
	}
	public void setReport_submit_date(Date report_submit_date) {
		this.report_submit_date = report_submit_date;
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
	public BRF95_CCF_CR3_SHEET() {
		super();
		// TODO Auto-generated constructor stub
	}

}
