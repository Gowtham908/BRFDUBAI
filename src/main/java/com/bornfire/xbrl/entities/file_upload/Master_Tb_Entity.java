package com.bornfire.xbrl.entities.file_upload;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "master_tb_manual_table")
public class Master_Tb_Entity {
	private String	entity;
	@Id
	private String	acct_no;
	private String	currency;
	private BigDecimal	amount_ac;
	private BigDecimal	amount_usd;
	private BigDecimal	amount_lc;
	private String	acct_name;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd-MMM-yyyy")
	private Date	report_date;
	private String	del_flg;
	private String	rcre_user_id;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd-MMM-yyyy")
	private Date	rcre_time;
	private String	lchg_user_id;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd-MMM-yyyy")
	private Date	lchg_time;
	private String	verify_user_id;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd-MMM-yyyy")
	private Date	verify_time;
	public String getEntity() {
		return entity;
	}
	public void setEntity(String entity) {
		this.entity = entity;
	}
	public String getAcct_no() {
		return acct_no;
	}
	public void setAcct_no(String acct_no) {
		this.acct_no = acct_no;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public BigDecimal getAmount_ac() {
		return amount_ac;
	}
	public void setAmount_ac(BigDecimal amount_ac) {
		this.amount_ac = amount_ac;
	}
	public BigDecimal getAmount_usd() {
		return amount_usd;
	}
	public void setAmount_usd(BigDecimal amount_usd) {
		this.amount_usd = amount_usd;
	}
	public BigDecimal getAmount_lc() {
		return amount_lc;
	}
	public void setAmount_lc(BigDecimal amount_lc) {
		this.amount_lc = amount_lc;
	}
	public String getAcct_name() {
		return acct_name;
	}
	public void setAcct_name(String acct_name) {
		this.acct_name = acct_name;
	}
	public Date getReport_date() {
		return report_date;
	}
	public void setReport_date(Date report_date) {
		this.report_date = report_date;
	}
	public String getDel_flg() {
		return del_flg;
	}
	public void setDel_flg(String del_flg) {
		this.del_flg = del_flg;
	}
	public String getRcre_user_id() {
		return rcre_user_id;
	}
	public void setRcre_user_id(String rcre_user_id) {
		this.rcre_user_id = rcre_user_id;
	}
	public Date getRcre_time() {
		return rcre_time;
	}
	public void setRcre_time(Date rcre_time) {
		this.rcre_time = rcre_time;
	}
	public String getLchg_user_id() {
		return lchg_user_id;
	}
	public void setLchg_user_id(String lchg_user_id) {
		this.lchg_user_id = lchg_user_id;
	}
	public Date getLchg_time() {
		return lchg_time;
	}
	public void setLchg_time(Date lchg_time) {
		this.lchg_time = lchg_time;
	}
	public String getVerify_user_id() {
		return verify_user_id;
	}
	public void setVerify_user_id(String verify_user_id) {
		this.verify_user_id = verify_user_id;
	}
	public Date getVerify_time() {
		return verify_time;
	}
	public void setVerify_time(Date verify_time) {
		this.verify_time = verify_time;
	}
	public Master_Tb_Entity(String entity, String acct_no, String currency, BigDecimal amount_ac, BigDecimal amount_usd,
	        BigDecimal amount_lc, String acct_name, Date report_date1, String del_flg, String rcre_user_id,
	        Date rcre_time1, String lchg_user_id, Date lchg_time1, String verify_user_id, Date verify_time1) {
	    super();
	    this.entity = entity;
	    this.acct_no = acct_no;
	    this.currency = currency;
	    this.amount_ac = amount_ac;
	    this.amount_usd = amount_usd;
	    this.amount_lc = amount_lc;
	    this.acct_name = acct_name;
	    this.report_date = report_date1;
	    this.del_flg = del_flg;
	    this.rcre_user_id = rcre_user_id;
	    this.rcre_time = rcre_time1;
	    this.lchg_user_id = lchg_user_id;
	    this.lchg_time = lchg_time1;
	    this.verify_user_id = verify_user_id;
	    this.verify_time = verify_time1;
	}

	public Master_Tb_Entity() {
		super();
		// TODO Auto-generated constructor stub
	}


}
