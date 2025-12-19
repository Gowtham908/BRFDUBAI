package com.bornfire.xbrl.entities;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="GL_BALANCE_RECONCILIATION_TABLE")
public class Gl_balance_recon_entity {

	private String	gl_code;
	private String	gl_head_code;
	private String	gl_sub_head_code;
	private String	acct_crncy_code;
	private BigDecimal	acct_balance_amt_ac;
	private BigDecimal	acct_balance_amt_lc;
	private BigDecimal	upload_gl_acct_balance_amt_ac;
	private BigDecimal	upload_acct_balance_amt_lc;
	private Date	report_date;
	@Id
	private String srl_no;
	private String status;
	public String getGl_sub_head_code() {
		return gl_sub_head_code;
	}
	public void setGl_sub_head_code(String gl_sub_head_code) {
		this.gl_sub_head_code = gl_sub_head_code;
	}
	public String getAcct_crncy_code() {
		return acct_crncy_code;
	}
	public void setAcct_crncy_code(String acct_crncy_code) {
		this.acct_crncy_code = acct_crncy_code;
	}
	public BigDecimal getAcct_balance_amt_ac() {
		return acct_balance_amt_ac;
	}
	public void setAcct_balance_amt_ac(BigDecimal acct_balance_amt_ac) {
		this.acct_balance_amt_ac = acct_balance_amt_ac;
	}
	public BigDecimal getAcct_balance_amt_lc() {
		return acct_balance_amt_lc;
	}
	public void setAcct_balance_amt_lc(BigDecimal acct_balance_amt_lc) {
		this.acct_balance_amt_lc = acct_balance_amt_lc;
	}
	public BigDecimal getUpload_gl_acct_balance_amt_ac() {
		return upload_gl_acct_balance_amt_ac;
	}
	public void setUpload_gl_acct_balance_amt_ac(BigDecimal upload_gl_acct_balance_amt_ac) {
		this.upload_gl_acct_balance_amt_ac = upload_gl_acct_balance_amt_ac;
	}
	public BigDecimal getUpload_acct_balance_amt_lc() {
		return upload_acct_balance_amt_lc;
	}
	public void setUpload_acct_balance_amt_lc(BigDecimal upload_acct_balance_amt_lc) {
		this.upload_acct_balance_amt_lc = upload_acct_balance_amt_lc;
	}
	public Date getReport_date() {
		return report_date;
	}
	public void setReport_date(Date report_date) {
		this.report_date = report_date;
	}
	public String getSrl_no() {
		return srl_no;
	}
	public void setSrl_no(String srl_no) {
		this.srl_no = srl_no;
	}
	public String getGl_head_code() {
		return gl_head_code;
	}
	public void setGl_head_code(String gl_head_code) {
		this.gl_head_code = gl_head_code;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getGl_code() {
		return gl_code;
	}
	public void setGl_code(String gl_code) {
		this.gl_code = gl_code;
	}
	@Override
	public String toString() {
		return "Gl_balance_recon_entity [gl_code=" + gl_code + ", gl_head_code=" + gl_head_code + ", gl_sub_head_code="
				+ gl_sub_head_code + ", acct_crncy_code=" + acct_crncy_code + ", acct_balance_amt_ac="
				+ acct_balance_amt_ac + ", acct_balance_amt_lc=" + acct_balance_amt_lc
				+ ", upload_gl_acct_balance_amt_ac=" + upload_gl_acct_balance_amt_ac + ", upload_acct_balance_amt_lc="
				+ upload_acct_balance_amt_lc + ", report_date=" + report_date + ", srl_no=" + srl_no + ", status="
				+ status + "]";
	}
	public Gl_balance_recon_entity(String gl_code, String gl_head_code, String gl_sub_head_code, String acct_crncy_code,
			BigDecimal acct_balance_amt_ac, BigDecimal acct_balance_amt_lc, BigDecimal upload_gl_acct_balance_amt_ac,
			BigDecimal upload_acct_balance_amt_lc, Date report_date, String srl_no, String status) {
		super();
		this.gl_code = gl_code;
		this.gl_head_code = gl_head_code;
		this.gl_sub_head_code = gl_sub_head_code;
		this.acct_crncy_code = acct_crncy_code;
		this.acct_balance_amt_ac = acct_balance_amt_ac;
		this.acct_balance_amt_lc = acct_balance_amt_lc;
		this.upload_gl_acct_balance_amt_ac = upload_gl_acct_balance_amt_ac;
		this.upload_acct_balance_amt_lc = upload_acct_balance_amt_lc;
		this.report_date = report_date;
		this.srl_no = srl_no;
		this.status = status;
	}
	public Gl_balance_recon_entity() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	

}
