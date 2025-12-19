package com.bornfire.xbrl.entities.BrfOutstandingEntries;

import java.math.BigDecimal;

import java.util.Date;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;



@Entity
@Table(name="BRF_OUSTANDING_ENTRY_MOD_TABLE")

public class BrfOutstandingEntryMod {
	
	@EmbeddedId
	private BrfOustandingEntryMod_Id BrfOutstandingEntryMod_Id;
	
	
	private String	nostor_code;
	private String	type;
	private String	bucket;
	private String	days;
	//private String	num_operation;
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date	date_import;
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date	date_operation;
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date	date_valeur;
	private String	amount;
	private String	devise;
	private String	poste;
	private String	tiers;
	private String	op_finance;
	private String	groupe1;
	private String	groupe2;
	private String	groupe3;
	private String	corresp_sender1;
	private String	corresp_sender2;
	
	//private Date	report_date;
	private String del_flg;
	private String rcre_user_id;
	private Date rcre_time;
	private String lchg_user_id;
	private Date lchg_time;
	private String verify_user_id;
	private Date verify_time;

	public BrfOustandingEntryMod_Id getBrfOutstandingEntryMod_Id() {
		return BrfOutstandingEntryMod_Id;
	}



	public void setBrfOutstandingEntryMod_Id(BrfOustandingEntryMod_Id brfOutstandingEntryMod_Id) {
		BrfOutstandingEntryMod_Id = brfOutstandingEntryMod_Id;
	}



	public String getNostor_code() {
		return nostor_code;
	}



	public void setNostor_code(String nostor_code) {
		this.nostor_code = nostor_code;
	}



	public String getType() {
		return type;
	}



	public void setType(String type) {
		this.type = type;
	}



	public String getBucket() {
		return bucket;
	}



	public void setBucket(String bucket) {
		this.bucket = bucket;
	}



	public String getDays() {
		return days;
	}



	public void setDays(String days) {
		this.days = days;
	}



	public Date getDate_import() {
		return date_import;
	}



	public void setDate_import(Date date_import) {
		this.date_import = date_import;
	}



	public Date getDate_operation() {
		return date_operation;
	}



	public void setDate_operation(Date date_operation) {
		this.date_operation = date_operation;
	}



	public Date getDate_valeur() {
		return date_valeur;
	}



	public void setDate_valeur(Date date_valeur) {
		this.date_valeur = date_valeur;
	}



	public String getAmount() {
		return amount;
	}



	public void setAmount(String amount) {
		this.amount = amount;
	}



	public String getDevise() {
		return devise;
	}



	public void setDevise(String devise) {
		this.devise = devise;
	}



	public String getPoste() {
		return poste;
	}



	public void setPoste(String poste) {
		this.poste = poste;
	}



	public String getTiers() {
		return tiers;
	}



	public void setTiers(String tiers) {
		this.tiers = tiers;
	}



	public String getOp_finance() {
		return op_finance;
	}



	public void setOp_finance(String op_finance) {
		this.op_finance = op_finance;
	}



	public String getGroupe1() {
		return groupe1;
	}



	public void setGroupe1(String groupe1) {
		this.groupe1 = groupe1;
	}



	public String getGroupe2() {
		return groupe2;
	}



	public void setGroupe2(String groupe2) {
		this.groupe2 = groupe2;
	}



	public String getGroupe3() {
		return groupe3;
	}



	public void setGroupe3(String groupe3) {
		this.groupe3 = groupe3;
	}



	public String getCorresp_sender1() {
		return corresp_sender1;
	}



	public void setCorresp_sender1(String corresp_sender1) {
		this.corresp_sender1 = corresp_sender1;
	}



	public String getCorresp_sender2() {
		return corresp_sender2;
	}



	public void setCorresp_sender2(String corresp_sender2) {
		this.corresp_sender2 = corresp_sender2;
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



	public BrfOutstandingEntryMod(BrfOustandingEntryMod_Id brfOutstandingEntryMod_Id, String nostor_code, String type,
			String bucket, String days, Date date_import, Date date_operation, Date date_valeur, String amount,
			String devise, String poste, String tiers, String op_finance, String groupe1, String groupe2,
			String groupe3, String corresp_sender1, String corresp_sender2, String del_flg, String rcre_user_id,
			Date rcre_time, String lchg_user_id, Date lchg_time, String verify_user_id, Date verify_time) {
		super();
		BrfOutstandingEntryMod_Id = brfOutstandingEntryMod_Id;
		this.nostor_code = nostor_code;
		this.type = type;
		this.bucket = bucket;
		this.days = days;
		this.date_import = date_import;
		this.date_operation = date_operation;
		this.date_valeur = date_valeur;
		this.amount = amount;
		this.devise = devise;
		this.poste = poste;
		this.tiers = tiers;
		this.op_finance = op_finance;
		this.groupe1 = groupe1;
		this.groupe2 = groupe2;
		this.groupe3 = groupe3;
		this.corresp_sender1 = corresp_sender1;
		this.corresp_sender2 = corresp_sender2;
		this.del_flg = del_flg;
		this.rcre_user_id = rcre_user_id;
		this.rcre_time = rcre_time;
		this.lchg_user_id = lchg_user_id;
		this.lchg_time = lchg_time;
		this.verify_user_id = verify_user_id;
		this.verify_time = verify_time;
	}



	public BrfOutstandingEntryMod(BrfOutstandingEntryDetail detail) {
		super();
		this.BrfOutstandingEntryMod_Id = detail.getBrfOutstandingEntryMod_Id(detail.getBrfOutstandingEntryDetailId());
	this.	nostor_code	=	detail.getNostor_code	();
	this.	type	=	detail.getType	();
	this.	bucket	=	detail.getBucket	();
	this.	days	=	detail.getDays	();
	//this.	num_operation	=	detail.getNum_operation	();
	this.	date_import	=	detail.getDate_import	();
	this.	date_operation	=	detail.getDate_operation	();
	this.	date_valeur	=	detail.getDate_valeur	();
	this.	amount	=	detail.getAmount	();
	this.	devise	=	detail.getDevise	();
	this.	poste	=	detail.getPoste	();
	this.	tiers	=	detail.getTiers	();
	this.	op_finance	=	detail.getOp_finance	();
	this.	groupe1	=	detail.getGroupe1	();
	this.	groupe2	=	detail.getGroupe2	();
	this.	groupe3	=	detail.getGroupe3	();
	this.	corresp_sender1	=	detail.getCorresp_sender1	();
	this.	corresp_sender2	=	detail.getCorresp_sender2	();
	//this.	report_date	=	detail.getReport_date	();
	this.del_flg =  detail.getDel_flg();
	this.rcre_user_id =  detail.getRcre_user_id();
	this.rcre_time =  detail.getRcre_time();
	this.lchg_user_id = detail.getLchg_user_id();
	this.lchg_time =  detail.getLchg_time();
	this.verify_user_id =  detail.getVerify_user_id();
	this.verify_time =  detail.getVerify_time();
	

	}
	
	
	
	public BrfOutstandingEntryMod() {
		
	}
	public void setDel_flg(Character changeType) {
		// TODO Auto-generated method stub
		
	}
	
}
