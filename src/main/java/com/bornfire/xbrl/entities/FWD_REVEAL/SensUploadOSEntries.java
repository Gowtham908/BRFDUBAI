package com.bornfire.xbrl.entities.FWD_REVEAL;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;




@Entity
@Table(name="OUTSTD_ENTRIES_TABLE")
public class SensUploadOSEntries implements Serializable {
	
	private static final long serialVersionUID = 1L;

	/*
	 * @EmbeddedId SensUploadOSEntriesId sensUploadOSEntriesId;
	 */
	
	@Id
	private String srl_num;
	private String sol_id;
	private String	bacid;

	private String	foracid;
	private String	acct_name;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date	tran_date;
	private String	tran_id;
	private BigDecimal	part_tran_id;
	private String	part_tran_type;
	private String	tran_crncy;
	private BigDecimal	tran_amt;
	private BigDecimal	tran_amt_inr;
	private String	tran_ref;
	private String	tran_particular;
	private String	tran_remarks;
	private String	rev_flg;
	private Date	reversal_date;
	private String	rev_tran_id;
	private BigDecimal	rev_part_tran_id;
	private BigDecimal	rev_tran_amt;
	private String	rev_tran_ref;
	private String	rev_tran_particular;
	private String	rev_tran_remarks;
	private String	rev_remarks;
	private String	rev_observations;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date	upl_date;
	private String	del_flg;
	private String	modify_flg;
	private String	modify_user;
	private String	verify_user;
	private Date	verify_time;
	
	
	
	
	public String getBacid() {
		return bacid;
	}
	public void setBacid(String bacid) {
		this.bacid = bacid;
	}
	public String getForacid() {
		return foracid;
	}
	public void setForacid(String foracid) {
		this.foracid = foracid;
	}
	public String getAcct_name() {
		return acct_name;
	}
	public void setAcct_name(String acct_name) {
		this.acct_name = acct_name;
	}
	public Date getTran_date() {
		return tran_date;
	}
	public void setTran_date(Date tran_date) {
		this.tran_date = tran_date;
	}
	public String getTran_id() {
		return tran_id;
	}
	public void setTran_id(String tran_id) {
		this.tran_id = tran_id;
	}
	public BigDecimal getPart_tran_id() {
		return part_tran_id;
	}
	public void setPart_tran_id(BigDecimal part_tran_id) {
		this.part_tran_id = part_tran_id;
	}
	public String getPart_tran_type() {
		return part_tran_type;
	}
	public void setPart_tran_type(String part_tran_type) {
		this.part_tran_type = part_tran_type;
	}
	public String getTran_crncy() {
		return tran_crncy;
	}
	public void setTran_crncy(String tran_crncy) {
		this.tran_crncy = tran_crncy;
	}
	public BigDecimal getTran_amt() {
		return tran_amt;
	}
	public void setTran_amt(BigDecimal tran_amt) {
		this.tran_amt = tran_amt;
	}
	public BigDecimal getTran_amt_inr() {
		return tran_amt_inr;
	}
	public void setTran_amt_inr(BigDecimal tran_amt_inr) {
		this.tran_amt_inr = tran_amt_inr;
	}
	public String getTran_ref() {
		return tran_ref;
	}
	public void setTran_ref(String tran_ref) {
		this.tran_ref = tran_ref;
	}
	public String getTran_particular() {
		return tran_particular;
	}
	public void setTran_particular(String tran_particular) {
		this.tran_particular = tran_particular;
	}
	public String getTran_remarks() {
		return tran_remarks;
	}
	public void setTran_remarks(String tran_remarks) {
		this.tran_remarks = tran_remarks;
	}
	public String getRev_flg() {
		return rev_flg;
	}
	public void setRev_flg(String rev_flg) {
		this.rev_flg = rev_flg;
	}
	public Date getReversal_date() {
		return reversal_date;
	}
	public void setReversal_date(Date reversal_date) {
		this.reversal_date = reversal_date;
	}
	public String getRev_tran_id() {
		return rev_tran_id;
	}
	public void setRev_tran_id(String rev_tran_id) {
		this.rev_tran_id = rev_tran_id;
	}
	public BigDecimal getRev_part_tran_id() {
		return rev_part_tran_id;
	}
	public void setRev_part_tran_id(BigDecimal rev_part_tran_id) {
		this.rev_part_tran_id = rev_part_tran_id;
	}
	public BigDecimal getRev_tran_amt() {
		return rev_tran_amt;
	}
	public void setRev_tran_amt(BigDecimal rev_tran_amt) {
		this.rev_tran_amt = rev_tran_amt;
	}
	public String getRev_tran_ref() {
		return rev_tran_ref;
	}
	public void setRev_tran_ref(String rev_tran_ref) {
		this.rev_tran_ref = rev_tran_ref;
	}
	public String getRev_tran_particular() {
		return rev_tran_particular;
	}
	public void setRev_tran_particular(String rev_tran_particular) {
		this.rev_tran_particular = rev_tran_particular;
	}
	public String getRev_tran_remarks() {
		return rev_tran_remarks;
	}
	public void setRev_tran_remarks(String rev_tran_remarks) {
		this.rev_tran_remarks = rev_tran_remarks;
	}
	public String getRev_remarks() {
		return rev_remarks;
	}
	public void setRev_remarks(String rev_remarks) {
		this.rev_remarks = rev_remarks;
	}
	public String getRev_observations() {
		return rev_observations;
	}
	public void setRev_observations(String rev_observations) {
		this.rev_observations = rev_observations;
	}
	public Date getUpl_date() {
		return upl_date;
	}
	public void setUpl_date(Date upl_date) {
		this.upl_date = upl_date;
	}
	public String getDel_flg() {
		return del_flg;
	}
	public void setDel_flg(String del_flg) {
		this.del_flg = del_flg;
	}
	public String getModify_flg() {
		return modify_flg;
	}
	public void setModify_flg(String modify_flg) {
		this.modify_flg = modify_flg;
	}
	public String getModify_user() {
		return modify_user;
	}
	public void setModify_user(String modify_user) {
		this.modify_user = modify_user;
	}
	public String getVerify_user() {
		return verify_user;
	}
	public void setVerify_user(String verify_user) {
		this.verify_user = verify_user;
	}
	public Date getVerify_time() {
		return verify_time;
	}
	public void setVerify_time(Date verify_time) {
		this.verify_time = verify_time;
	}
	
	
	
	
	public String getSol_id() {
		return sol_id;
	}
	public void setSol_id(String sol_id) {
		this.sol_id = sol_id;
	}
	
	
	
	
	public String getSrl_num() {
		return srl_num;
	}
	public void setSrl_num(String srl_num) {
		this.srl_num = srl_num;
	}
	public SensUploadOSEntries() {
		super();
		// TODO Auto-generated constructor stub
		
	}
//	public SensUploadOSEntries(String srl_num, String sol_id, String bacid, String foracid, String acct_name,
//			Date tran_date, String tran_id, BigDecimal part_tran_id, String part_tran_type, String tran_crncy,
//			BigDecimal tran_amt, BigDecimal tran_amt_inr, String tran_ref, String tran_particular, String tran_remarks,
//			String rev_flg, Date reversal_date, String rev_tran_id, BigDecimal rev_part_tran_id,
//			BigDecimal rev_tran_amt, String rev_tran_ref, String rev_tran_particular, String rev_tran_remarks,
//			String rev_remarks, String rev_observations, Date upl_date, String del_flg, String modify_flg,
//			String modify_user, String verify_user, Date verify_time) {
//		super();
//		this.srl_num = srl_num;
//		this.sol_id = sol_id;
//		this.bacid = bacid;
//		this.foracid = foracid;
//		this.acct_name = acct_name;
//		this.tran_date = tran_date;
//		this.tran_id = tran_id;
//		this.part_tran_id = part_tran_id;
//		this.part_tran_type = part_tran_type;
//		this.tran_crncy = tran_crncy;
//		this.tran_amt = tran_amt;
//		this.tran_amt_inr = tran_amt_inr;
//		this.tran_ref = tran_ref;
//		this.tran_particular = tran_particular;
//		this.tran_remarks = tran_remarks;
//		this.rev_flg = rev_flg;
//		this.reversal_date = reversal_date;
//		this.rev_tran_id = rev_tran_id;
//		this.rev_part_tran_id = rev_part_tran_id;
//		this.rev_tran_amt = rev_tran_amt;
//		this.rev_tran_ref = rev_tran_ref;
//		this.rev_tran_particular = rev_tran_particular;
//		this.rev_tran_remarks = rev_tran_remarks;
//		this.rev_remarks = rev_remarks;
//		this.rev_observations = rev_observations;
//		this.upl_date = upl_date;
//		this.del_flg = del_flg;
//		this.modify_flg = modify_flg;
//		this.modify_user = modify_user;
//		this.verify_user = verify_user;
//		this.verify_time = verify_time;
//	}
	public SensUploadOSEntries(String sol_id, String bacid, String foracid, String acct_name, Date tran_date,
			String tran_id, BigDecimal part_tran_id, BigDecimal tran_amt, BigDecimal tran_amt_inr, String tran_ref,
			String tran_particular, Date reversal_date, Date upl_date, String del_flg, String modify_flg,
			String modify_user) {
		this.sol_id = sol_id;
		this.bacid = bacid;
		this.foracid = foracid;
		this.acct_name = acct_name;
		this.tran_date = tran_date;
		this.tran_id = tran_id;
		this.part_tran_id = part_tran_id;
		this.tran_amt = tran_amt;
		this.tran_amt_inr = tran_amt_inr;
		this.tran_ref = tran_ref;
		this.tran_particular = tran_particular;
		this.reversal_date = reversal_date;
		this.upl_date = upl_date;
		this.del_flg = del_flg;
		this.modify_flg = modify_flg;
		this.modify_user = modify_user;
		
	}
	
	
	
	
		}
