package com.bornfire.xbrl.entities.BrfOutstandingEntries;

import java.math.BigDecimal;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.format.annotation.DateTimeFormat;







@Entity
@Table(name="BRF_OUSTANDING_ENTRY_MAST_TABLE")
public class BrfOutstandingEntryDetail {
	
	@EmbeddedId
	private BrfOutstandingEntryDetailId brfOutstandingEntryDetailId;
	@Transient
	private String	nostor_code;
	private String	type;
	private String	bucket;
	private String	days;
	//@Column(name="num_operation")
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
	private String	del_flg;
	private String	rcre_user_id;
	private Date	rcre_time;
	private String	lchg_user_id;
	private Date	lchg_time;
	private String	verify_user_id;
	private Date	verify_time;
	
	public BrfOutstandingEntryDetailId getBrfOutstandingEntryDetailId() {
		return brfOutstandingEntryDetailId;
	}

	public void setBrfOutstandingEntryDetailId(BrfOutstandingEntryDetailId brfOutstandingEntryDetailId) {
		this.brfOutstandingEntryDetailId = brfOutstandingEntryDetailId;
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
	

	public BrfOutstandingEntryDetail(BrfOutstandingEntryDetailId brfOutstandingEntryDetailId, String nostor_code,
			String type, String bucket, String days, Date date_import, Date date_operation, Date date_valeur,
			String amount, String devise, String poste, String tiers, String op_finance, String groupe1, String groupe2,
			String groupe3, String corresp_sender1, String corresp_sender2, String del_flg, String rcre_user_id,
			Date rcre_time, String lchg_user_id, Date lchg_time, String verify_user_id, Date verify_time) {
		super();
		this.brfOutstandingEntryDetailId = brfOutstandingEntryDetailId;
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

	public BrfOutstandingEntryDetail() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BrfOutstandingEntryDetail(BrfOutstandingEntryMod mod) {

		this.brfOutstandingEntryDetailId = new BrfOutstandingEntryDetailId(mod.getBrfOutstandingEntryMod_Id());
		this.	nostor_code	=	mod.getNostor_code();
		this.	type	=	mod.getType();
		this.	bucket	=	mod.getBucket();
		this.	days	=	mod.getDays();
		//this.	num_operation	=	mod.getNum_operation();
		this.	date_import	=	mod.getDate_import();
		this.	date_operation	=	mod.getDate_operation();
		this.	date_valeur	=	mod.getDate_valeur();
		this.	amount	=	mod.getAmount();
		this.	devise	=	mod.getDevise();
		this.	poste	=	mod.getPoste();
		this.	tiers	=	mod.getTiers();
		this.	op_finance	=	mod.getOp_finance();
		this.	groupe1	=	mod.getGroupe1	();
		this.	groupe2	=	mod.getGroupe2	();
		this.	groupe3	=	mod.getGroupe3	();
		this.	corresp_sender1	=	mod.getCorresp_sender1	();
		this.	corresp_sender2	=	mod.getCorresp_sender2	();
		//this.	report_date	=	mod.getReport_date	();
		this.del_flg = mod.getDel_flg();
		this.rcre_user_id = mod.getRcre_user_id();
		this.rcre_time = mod.getRcre_time();
		this.lchg_user_id = mod.getLchg_user_id();
		this.lchg_time = mod.getLchg_time();
		this.verify_user_id = mod.getVerify_user_id();
		this.verify_time = mod.getVerify_time();	

	}
	
	public BrfOutstandingEntryDetail(BrfOutstandingEntryHistory hist) {

		this.brfOutstandingEntryDetailId = hist.getBrfOutstandingEntryDetailId();
	this.nostor_code	=	hist.getNostor_code	();
	this.	type	=	hist.getType	();
	this.	bucket	=	hist.getBucket	();
	this.	days	=	hist.getDays	();
	//this.	num_operation	=	hist.getNum_operation	();
	this.	date_import	=	hist.getDate_import	();
	this.	date_operation	=	hist.getDate_operation	();
	this.	date_valeur	=	hist.getDate_valeur	();
	this.	amount	=	hist.getAmount	();
	this.	devise	=	hist.getDevise	();
	this.	poste	=	hist.getPoste	();
	this.	tiers	=	hist.getTiers	();
	this.	op_finance	=	hist.getOp_finance	();
	this.	groupe1	=	hist.getGroupe1	();
	this.	groupe2	=	hist.getGroupe2	();
	this.	groupe3	=	hist.getGroupe3	();
	this.	corresp_sender1	=	hist.getCorresp_sender1	();
	this.	corresp_sender2	=	hist.getCorresp_sender2	();
	//this.	report_date	=	hist.getReport_date	();
	this.del_flg = hist.getDel_flg();
	this.rcre_user_id = hist.getRcre_user_id();
	this.rcre_time = hist.getRcre_time();
	this.lchg_user_id = hist.getLchg_user_id();
	this.lchg_time = hist.getLchg_time();
	this.verify_user_id = hist.getVerify_user_id();
	this.verify_time = hist.getVerify_time();
	}
	public BrfOutstandingEntryDetail(String nostor_code2, String type2, String bucket2, String days2,
			String num_operation, String date_import2, String date_operation2, String date_valeur2, Date amount2,
			BigDecimal devise2, String poste2, String tiers2, String op_finance2, String groupe12, String groupe22,
			String groupe32, String corresp_sender12, String corresp_sender22, Date report_date, Character del_flg2,
			String rcre_user_id2, Date rcre_time2, String lchg_user_id2, Date lchg_time2, String verify_user_id2,
			Date verify_time2) {
		// TODO Auto-generated constructor stub
	}

	public BrfOustandingEntryMod_Id getBrfOutstandingEntryMod_Id(
			BrfOutstandingEntryDetailId brfOutstandingEntryDetailId2) {
		// TODO Auto-generated method stub
		return null;
	}
}



