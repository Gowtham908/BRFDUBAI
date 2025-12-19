package com.bornfire.xbrl.entities.BLS0100;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "BLS0100_TREASURY_MASTER_TB")
public class BLS0100Treasury_ENTITY {
	
	private String	entity;
	private String	acct_no;
	private String	currency;
	private String	amount;
	private String	lcy;
	private String	v_description;
	private String	gl_freeze;
	private String	amount_ac;
	private String	amount_usd;
	private String	amount_lc;
	private String	acct_name;
	@Id
	private Date	report_date;
	private String	del_flg;
	private String	rcre_user_id;
	private Date	rcre_time;
	private String	lchg_user_id;
	private Date	lchg_time;
	private String	verify_user_id;
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
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getLcy() {
		return lcy;
	}
	public void setLcy(String lcy) {
		this.lcy = lcy;
	}
	public String getV_description() {
		return v_description;
	}
	public void setV_description(String v_description) {
		this.v_description = v_description;
	}
	public String getGl_freeze() {
		return gl_freeze;
	}
	public void setGl_freeze(String gl_freeze) {
		this.gl_freeze = gl_freeze;
	}
	public String getAmount_ac() {
		return amount_ac;
	}
	public void setAmount_ac(String amount_ac) {
		this.amount_ac = amount_ac;
	}
	public String getAmount_usd() {
		return amount_usd;
	}
	public void setAmount_usd(String amount_usd) {
		this.amount_usd = amount_usd;
	}
	public String getAmount_lc() {
		return amount_lc;
	}
	public void setAmount_lc(String amount_lc) {
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
	public BLS0100Treasury_ENTITY(String entity, String acct_no, String currency, String amount, String lcy,
			String v_description, String gl_freeze, String amount_ac, String amount_usd, String amount_lc,
			String acct_name, Date report_date, String del_flg, String rcre_user_id, Date rcre_time,
			String lchg_user_id, Date lchg_time, String verify_user_id, Date verify_time) {
		super();
		this.entity = entity;
		this.acct_no = acct_no;
		this.currency = currency;
		this.amount = amount;
		this.lcy = lcy;
		this.v_description = v_description;
		this.gl_freeze = gl_freeze;
		this.amount_ac = amount_ac;
		this.amount_usd = amount_usd;
		this.amount_lc = amount_lc;
		this.acct_name = acct_name;
		this.report_date = report_date;
		this.del_flg = del_flg;
		this.rcre_user_id = rcre_user_id;
		this.rcre_time = rcre_time;
		this.lchg_user_id = lchg_user_id;
		this.lchg_time = lchg_time;
		this.verify_user_id = verify_user_id;
		this.verify_time = verify_time;
	}
	public BLS0100Treasury_ENTITY() {
		super();
	
	}
	
	


}
