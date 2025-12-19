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
@Table(name = "BRF5_TRASURY_MANUAL_TABLE")
public class BRF5_TRASURY_MANUAL_ENTITY {
	private String	acct_no;
	private String	acct_name;
	private BigDecimal	acct_balance_ac;
	private BigDecimal	acct_balance_lc;
	private String	acct_crncy_code;
	private String	nre_flg;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "MM/dd/yyyy")
	private Date	report_date;
	@Id
	private String	isin_code;
	private BigDecimal	no_securities;
	public String getAcct_no() {
		return acct_no;
	}
	public void setAcct_no(String acct_no) {
		this.acct_no = acct_no;
	}
	public String getAcct_name() {
		return acct_name;
	}
	public void setAcct_name(String acct_name) {
		this.acct_name = acct_name;
	}
	public BigDecimal getAcct_balance_ac() {
		return acct_balance_ac;
	}
	public void setAcct_balance_ac(BigDecimal acct_balance_ac) {
		this.acct_balance_ac = acct_balance_ac;
	}
	public BigDecimal getAcct_balance_lc() {
		return acct_balance_lc;
	}
	public void setAcct_balance_lc(BigDecimal acct_balance_lc) {
		this.acct_balance_lc = acct_balance_lc;
	}
	public String getAcct_crncy_code() {
		return acct_crncy_code;
	}
	public void setAcct_crncy_code(String acct_crncy_code) {
		this.acct_crncy_code = acct_crncy_code;
	}
	public String getNre_flg() {
		return nre_flg;
	}
	public void setNre_flg(String nre_flg) {
		this.nre_flg = nre_flg;
	}
	public Date getReport_date() {
		return report_date;
	}
	public void setReport_date(Date report_date) {
		this.report_date = report_date;
	}
	public String getIsin_code() {
		return isin_code;
	}
	public void setIsin_code(String isin_code) {
		this.isin_code = isin_code;
	}
	public BigDecimal getNo_securities() {
		return no_securities;
	}
	public void setNo_securities(BigDecimal no_securities) {
		this.no_securities = no_securities;
	}
	public BRF5_TRASURY_MANUAL_ENTITY(String acct_no, String acct_name, BigDecimal acct_balance_ac,
			BigDecimal acct_balance_lc, String acct_crncy_code, String nre_flg, Date report_date, String isin_code,
			BigDecimal no_securities) {
		super();
		this.acct_no = acct_no;
		this.acct_name = acct_name;
		this.acct_balance_ac = acct_balance_ac;
		this.acct_balance_lc = acct_balance_lc;
		this.acct_crncy_code = acct_crncy_code;
		this.nre_flg = nre_flg;
		this.report_date = report_date;
		this.isin_code = isin_code;
		this.no_securities = no_securities;
	}
	public BRF5_TRASURY_MANUAL_ENTITY() {
		super();
		// TODO Auto-generated constructor stub
	}

}
