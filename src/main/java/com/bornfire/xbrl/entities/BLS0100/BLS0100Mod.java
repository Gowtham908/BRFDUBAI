package com.bornfire.xbrl.entities.BLS0100;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="BLS0100_MOD_TABLE")
public class BLS0100Mod {
	
	private String	acct_crncy_code;
	private String	glsh_code;
	private String	sch_type;
	private String	sch_code;
	private String	cust_id;
	@EmbeddedId
	private BLS0100ModId bls0100ModId;
	private String	acct_name;
	@DateTimeFormat(pattern="dd-MM-yyyy")
	private Date	eab_date;
	private BigDecimal	eab_bal;
	private Character	del_flg;
	private String	rcre_user_id;
	private Date	rcre_time;
	private String	lchg_user_id;
	private Date	lchg_time;
	private String	verify_user_id;
	private Date	verify_time;
	
	
	
	public BLS0100Mod() {
		
		
	}
	
	
	public String getAcct_crncy_code() {
		return acct_crncy_code;
	}
	public void setAcct_crncy_code(String acct_crncy_code) {
		this.acct_crncy_code = acct_crncy_code;
	}
	public String getGlsh_code() {
		return glsh_code;
	}
	public void setGlsh_code(String glsh_code) {
		this.glsh_code = glsh_code;
	}
	public String getSch_type() {
		return sch_type;
	}
	public void setSch_type(String sch_type) {
		this.sch_type = sch_type;
	}
	public String getSch_code() {
		return sch_code;
	}
	public void setSch_code(String sch_code) {
		this.sch_code = sch_code;
	}
	public String getCust_id() {
		return cust_id;
	}
	public void setCust_id(String cust_id) {
		this.cust_id = cust_id;
	}
	
	public String getAcct_name() {
		return acct_name;
	}
	public void setAcct_name(String acct_name) {
		this.acct_name = acct_name;
	}
	public Date getEab_date() {
		return eab_date;
	}
	public void setEab_date(Date eab_date) {
		this.eab_date = eab_date;
	}
	public BigDecimal getEab_bal() {
		return eab_bal;
	}
	public void setEab_bal(BigDecimal eab_bal) {
		this.eab_bal = eab_bal;
	}
	
	public Character getDel_flg() {
		return del_flg;
	}
	public void setDel_flg(Character del_flg) {
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

	

	public BLS0100ModId getBls0100ModId() {
		return bls0100ModId;
	}


	public void setBls0100ModId(BLS0100ModId bls0100ModId) {
		this.bls0100ModId = bls0100ModId;
	}


	public BLS0100Mod(String acct_crncy_code, String glsh_code, String sch_type, String sch_code, String cust_id,
			BLS0100ModId bls0100ModId, String acct_name, Date eab_date, BigDecimal eab_bal, Character del_flg,
			String rcre_user_id, Date rcre_time, String lchg_user_id, Date lchg_time, String verify_user_id,
			Date verify_time) {
		super();
		this.acct_crncy_code = acct_crncy_code;
		this.glsh_code = glsh_code;
		this.sch_type = sch_type;
		this.sch_code = sch_code;
		this.cust_id = cust_id;
		this.bls0100ModId = bls0100ModId;
		this.acct_name = acct_name;
		this.eab_date = eab_date;
		this.eab_bal = eab_bal;
		this.del_flg = del_flg;
		this.rcre_user_id = rcre_user_id;
		this.rcre_time = rcre_time;
		this.lchg_user_id = lchg_user_id;
		this.lchg_time = lchg_time;
		this.verify_user_id = verify_user_id;
		this.verify_time = verify_time;
	}
	
	public BLS0100Mod(BLS0100Detail detail) {
		super();
		this.bls0100ModId = new BLS0100ModId(detail.getBls0100DetailId());
		this.acct_crncy_code = detail.getAcct_crncy_code();
		this.glsh_code = detail.getGlsh_code();
		this.sch_type =  detail.getSch_type();
		this.sch_code =  detail.getSch_code();
		this.cust_id =  detail.getCust_id();
		this.acct_name =  detail.getAcct_name();
		this.eab_date =  detail.getEab_date();
		this.eab_bal =  detail.getEab_bal();
		this.del_flg =  detail.getDel_flg();
		this.rcre_user_id =  detail.getRcre_user_id();
		this.rcre_time =  detail.getRcre_time();
		this.lchg_user_id = detail.getLchg_user_id();
		this.lchg_time =  detail.getLchg_time();
		this.verify_user_id =  detail.getVerify_user_id();
		this.verify_time =  detail.getVerify_time();
		
	}

}
