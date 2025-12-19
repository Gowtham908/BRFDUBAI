package com.bornfire.xbrl.entities.BLS0100;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="BLS0100_MAST_H_TABLE")
public class BLS0100History {
	@Transient
	private String remarks;
	private String	acct_crncy_code;
	private String	glsh_code;
	private String	sch_type;
	private String	sch_code;
	private String	cust_id;
	
	@EmbeddedId
	private BLS0100DetailId bls0100DetailId;
	
	private String	acct_name;
	@DateTimeFormat(pattern="dd-mm-yyyy")
	private Date	eab_date;
	private BigDecimal	eab_bal;
	private Character	del_flg;
	private String	rcre_user_id;
	private Date	rcre_time;
	private String	lchg_user_id;
	private Date	lchg_time;
	private String	verify_user_id;
	private Date	verify_time;
	
	
	
	public BLS0100History() {
		
		
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


	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}


	public BLS0100DetailId getBls0100DetailId() {
		return bls0100DetailId;
	}


	public void setBls0100DetailId(BLS0100DetailId bls0100DetailId) {
		this.bls0100DetailId = bls0100DetailId;
	}


	public BLS0100History(String remarks, String acct_crncy_code, String glsh_code, String sch_type, String sch_code,
			String cust_id, BLS0100DetailId bls0100DetailId, String acct_name, Date eab_date, BigDecimal eab_bal,
			Character del_flg, String rcre_user_id, Date rcre_time, String lchg_user_id, Date lchg_time,
			String verify_user_id, Date verify_time) {
		super();
		this.remarks = remarks;
		this.acct_crncy_code = acct_crncy_code;
		this.glsh_code = glsh_code;
		this.sch_type = sch_type;
		this.sch_code = sch_code;
		this.cust_id = cust_id;
		this.bls0100DetailId = bls0100DetailId;
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

	public BLS0100History(BLS0100Mod mod) {
		
		this.bls0100DetailId = new BLS0100DetailId(mod.getBls0100ModId());
		this.acct_crncy_code = mod.getAcct_crncy_code();
		this.glsh_code = mod.getGlsh_code();
		this.sch_type =  mod.getSch_type();
		this.sch_code =  mod.getSch_code();
		this.cust_id =  mod.getCust_id();
		this.acct_name =  mod.getAcct_name();
		this.eab_date =  mod.getEab_date();
		this.eab_bal =  mod.getEab_bal();
		this.del_flg =  mod.getDel_flg();
		this.rcre_user_id =  mod.getRcre_user_id();
		this.rcre_time =  mod.getRcre_time();
		this.lchg_user_id = mod.getLchg_user_id();
		this.lchg_time =  mod.getLchg_time();
		this.verify_user_id =  mod.getVerify_user_id();
		this.verify_time =  mod.getVerify_time();
	}
	

}
