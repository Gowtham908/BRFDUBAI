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
@Table(name="BRF95_FINAL_CCFREPORT")

public class BRF95_FINAL_CCFREPORT {
	private BigDecimal	ccf0_final_before_ccf;
	private BigDecimal	ccf0_final_crm;
	private BigDecimal	ccf0_final_after_crm;
	private BigDecimal	ccfp2_final_before_ccf;
	private BigDecimal	ccfp2_final_crm;
	private BigDecimal	ccfp2_final_after_crm;
	private BigDecimal	ccfp5_final_before_ccf;
	private BigDecimal	ccfp5_final_crm;
	private BigDecimal	ccfp5_final_after_crm;
	private BigDecimal	ccf1_final_before_ccf;
	private BigDecimal	ccf1_final_crm;
	private BigDecimal	ccf1_final_after_crm;
	private BigDecimal	total_final_before_ccf;
	private BigDecimal	total_final_crm;
	private BigDecimal	total_final_after_crm;

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
	
	public BigDecimal getTotal_final_before_ccf() {
		return total_final_before_ccf;
	}
	public void setTotal_final_before_ccf(BigDecimal total_final_before_ccf) {
		this.total_final_before_ccf = total_final_before_ccf;
	}
	public BigDecimal getTotal_final_crm() {
		return total_final_crm;
	}
	public void setTotal_final_crm(BigDecimal total_final_crm) {
		this.total_final_crm = total_final_crm;
	}
	public BigDecimal getTotal_final_after_crm() {
		return total_final_after_crm;
	}
	public void setTotal_final_after_crm(BigDecimal total_final_after_crm) {
		this.total_final_after_crm = total_final_after_crm;
	}
	public BigDecimal getCcf0_final_before_ccf() {
		return ccf0_final_before_ccf;
	}
	public void setCcf0_final_before_ccf(BigDecimal ccf0_final_before_ccf) {
		this.ccf0_final_before_ccf = ccf0_final_before_ccf;
	}
	public BigDecimal getCcf0_final_crm() {
		return ccf0_final_crm;
	}
	public void setCcf0_final_crm(BigDecimal ccf0_final_crm) {
		this.ccf0_final_crm = ccf0_final_crm;
	}
	public BigDecimal getCcf0_final_after_crm() {
		return ccf0_final_after_crm;
	}
	public void setCcf0_final_after_crm(BigDecimal ccf0_final_after_crm) {
		this.ccf0_final_after_crm = ccf0_final_after_crm;
	}
	public BigDecimal getCcfp2_final_before_ccf() {
		return ccfp2_final_before_ccf;
	}
	public void setCcfp2_final_before_ccf(BigDecimal ccfp2_final_before_ccf) {
		this.ccfp2_final_before_ccf = ccfp2_final_before_ccf;
	}
	public BigDecimal getCcfp2_final_crm() {
		return ccfp2_final_crm;
	}
	public void setCcfp2_final_crm(BigDecimal ccfp2_final_crm) {
		this.ccfp2_final_crm = ccfp2_final_crm;
	}
	public BigDecimal getCcfp2_final_after_crm() {
		return ccfp2_final_after_crm;
	}
	public void setCcfp2_final_after_crm(BigDecimal ccfp2_final_after_crm) {
		this.ccfp2_final_after_crm = ccfp2_final_after_crm;
	}
	public BigDecimal getCcfp5_final_before_ccf() {
		return ccfp5_final_before_ccf;
	}
	public void setCcfp5_final_before_ccf(BigDecimal ccfp5_final_before_ccf) {
		this.ccfp5_final_before_ccf = ccfp5_final_before_ccf;
	}
	public BigDecimal getCcfp5_final_crm() {
		return ccfp5_final_crm;
	}
	public void setCcfp5_final_crm(BigDecimal ccfp5_final_crm) {
		this.ccfp5_final_crm = ccfp5_final_crm;
	}
	public BigDecimal getCcfp5_final_after_crm() {
		return ccfp5_final_after_crm;
	}
	public void setCcfp5_final_after_crm(BigDecimal ccfp5_final_after_crm) {
		this.ccfp5_final_after_crm = ccfp5_final_after_crm;
	}
	public BigDecimal getCcf1_final_before_ccf() {
		return ccf1_final_before_ccf;
	}
	public void setCcf1_final_before_ccf(BigDecimal ccf1_final_before_ccf) {
		this.ccf1_final_before_ccf = ccf1_final_before_ccf;
	}
	public BigDecimal getCcf1_final_crm() {
		return ccf1_final_crm;
	}
	public void setCcf1_final_crm(BigDecimal ccf1_final_crm) {
		this.ccf1_final_crm = ccf1_final_crm;
	}
	public BigDecimal getCcf1_final_after_crm() {
		return ccf1_final_after_crm;
	}
	public void setCcf1_final_after_crm(BigDecimal ccf1_final_after_crm) {
		this.ccf1_final_after_crm = ccf1_final_after_crm;
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
	
	public BRF95_FINAL_CCFREPORT(BigDecimal ccf0_final_before_ccf, BigDecimal ccf0_final_crm,
			BigDecimal ccf0_final_after_crm, BigDecimal ccfp2_final_before_ccf, BigDecimal ccfp2_final_crm,
			BigDecimal ccfp2_final_after_crm, BigDecimal ccfp5_final_before_ccf, BigDecimal ccfp5_final_crm,
			BigDecimal ccfp5_final_after_crm, BigDecimal ccf1_final_before_ccf, BigDecimal ccf1_final_crm,
			BigDecimal ccf1_final_after_crm, BigDecimal total_final_before_ccf, BigDecimal total_final_crm,
			BigDecimal total_final_after_crm, Date report_date, Date report_from_date, Date report_to_date,
			Date report_submit_date, String entity_flg, String modify_flg, String del_flg) {
		super();
		this.ccf0_final_before_ccf = ccf0_final_before_ccf;
		this.ccf0_final_crm = ccf0_final_crm;
		this.ccf0_final_after_crm = ccf0_final_after_crm;
		this.ccfp2_final_before_ccf = ccfp2_final_before_ccf;
		this.ccfp2_final_crm = ccfp2_final_crm;
		this.ccfp2_final_after_crm = ccfp2_final_after_crm;
		this.ccfp5_final_before_ccf = ccfp5_final_before_ccf;
		this.ccfp5_final_crm = ccfp5_final_crm;
		this.ccfp5_final_after_crm = ccfp5_final_after_crm;
		this.ccf1_final_before_ccf = ccf1_final_before_ccf;
		this.ccf1_final_crm = ccf1_final_crm;
		this.ccf1_final_after_crm = ccf1_final_after_crm;
		this.total_final_before_ccf = total_final_before_ccf;
		this.total_final_crm = total_final_crm;
		this.total_final_after_crm = total_final_after_crm;
		this.report_date = report_date;
		this.report_from_date = report_from_date;
		this.report_to_date = report_to_date;
		this.report_submit_date = report_submit_date;
		this.entity_flg = entity_flg;
		this.modify_flg = modify_flg;
		this.del_flg = del_flg;
	}
	@Override
	public String toString() {
		return "BRF95_FINAL_CCFREPORT [ccf0_final_before_ccf=" + ccf0_final_before_ccf + ", ccf0_final_crm="
				+ ccf0_final_crm + ", ccf0_final_after_crm=" + ccf0_final_after_crm + ", ccfp2_final_before_ccf="
				+ ccfp2_final_before_ccf + ", ccfp2_final_crm=" + ccfp2_final_crm + ", ccfp2_final_after_crm="
				+ ccfp2_final_after_crm + ", ccfp5_final_before_ccf=" + ccfp5_final_before_ccf + ", ccfp5_final_crm="
				+ ccfp5_final_crm + ", ccfp5_final_after_crm=" + ccfp5_final_after_crm + ", ccf1_final_before_ccf="
				+ ccf1_final_before_ccf + ", ccf1_final_crm=" + ccf1_final_crm + ", ccf1_final_after_crm="
				+ ccf1_final_after_crm + ", total_final_before_ccf=" + total_final_before_ccf + ", total_final_crm="
				+ total_final_crm + ", total_final_after_crm=" + total_final_after_crm + ", report_date=" + report_date
				+ ", report_from_date=" + report_from_date + ", report_to_date=" + report_to_date
				+ ", report_submit_date=" + report_submit_date + ", entity_flg=" + entity_flg + ", modify_flg="
				+ modify_flg + ", del_flg=" + del_flg + ", getTotal_final_before_ccf()=" + getTotal_final_before_ccf()
				+ ", getTotal_final_crm()=" + getTotal_final_crm() + ", getTotal_final_after_crm()="
				+ getTotal_final_after_crm() + ", getCcf0_final_before_ccf()=" + getCcf0_final_before_ccf()
				+ ", getCcf0_final_crm()=" + getCcf0_final_crm() + ", getCcf0_final_after_crm()="
				+ getCcf0_final_after_crm() + ", getCcfp2_final_before_ccf()=" + getCcfp2_final_before_ccf()
				+ ", getCcfp2_final_crm()=" + getCcfp2_final_crm() + ", getCcfp2_final_after_crm()="
				+ getCcfp2_final_after_crm() + ", getCcfp5_final_before_ccf()=" + getCcfp5_final_before_ccf()
				+ ", getCcfp5_final_crm()=" + getCcfp5_final_crm() + ", getCcfp5_final_after_crm()="
				+ getCcfp5_final_after_crm() + ", getCcf1_final_before_ccf()=" + getCcf1_final_before_ccf()
				+ ", getCcf1_final_crm()=" + getCcf1_final_crm() + ", getCcf1_final_after_crm()="
				+ getCcf1_final_after_crm() + ", getReport_date()=" + getReport_date() + ", getReport_from_date()="
				+ getReport_from_date() + ", getReport_to_date()=" + getReport_to_date() + ", getReport_submit_date()="
				+ getReport_submit_date() + ", getEntity_flg()=" + getEntity_flg() + ", getModify_flg()="
				+ getModify_flg() + ", getDel_flg()=" + getDel_flg() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}
	public BRF95_FINAL_CCFREPORT() {
		super();
		// TODO Auto-generated constructor stub
	}


}
