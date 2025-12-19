package com.bornfire.xbrl.entities.Profitloss;

import java.util.Date;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.format.annotation.DateTimeFormat;

import com.bornfire.xbrl.entities.BrfOutstandingEntries.BrfOutstandingEntryDetailId;

@Entity
@Table(name = "BRF_PROFIT_LOSS_MAST_H_TABLE")
public class BrfprofitlossHistory {
	
    @EmbeddedId
	
	private BrfProfitlossDetailId BrfProfitlossDetailId;
	@Transient
	
	//private Date	report_date;
	private String	op_finance;
	//private String	num_operation;
	private String	entite;
	private String	compte;
	private String	portefeuille;
	private String	mode_reglement;
	private String	flag_commission;
	private String	tiers;
	private String	flag_stade;
	private String	description1;
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date	date_operation;
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date	date_valeur;
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date	date_echeance;
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date	date_emission;
	private String	devise;
	private String	montant_signe;
	private String	montant_signe_origine;
	private String	devise_origine;
	private String	nombre_operations;
	private String	tri_1;
	private String	tri_2;
	private String	tri_3;
	private String	tri_devise;
	private String	contrevaleur;
	private String	contrevaleur_origine;
	private String	devise_cv;
	private String	reconciliation_flag;
	private String	del_flg;
	private String	rcre_user_id;
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date	rcre_time;
	
	private String	lchg_user_id;
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date	lchg_time;
	
	private String	verify_user_id;
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date	verify_time;

	public BrfProfitlossDetailId getBrfProfitlossDetailId() {
		return BrfProfitlossDetailId;
	}
	public void setBrfProfitlossDetailId(BrfProfitlossDetailId brfProfitlossDetailId) {
		BrfProfitlossDetailId = brfProfitlossDetailId;
	}
	public String getOp_finance() {
		return op_finance;
	}
	public void setOp_finance(String op_finance) {
		this.op_finance = op_finance;
	}
	public String getEntite() {
		return entite;
	}
	public void setEntite(String entite) {
		this.entite = entite;
	}
	public String getCompte() {
		return compte;
	}
	public void setCompte(String compte) {
		this.compte = compte;
	}
	public String getPortefeuille() {
		return portefeuille;
	}
	public void setPortefeuille(String portefeuille) {
		this.portefeuille = portefeuille;
	}
	public String getMode_reglement() {
		return mode_reglement;
	}
	public void setMode_reglement(String mode_reglement) {
		this.mode_reglement = mode_reglement;
	}
	public String getFlag_commission() {
		return flag_commission;
	}
	public void setFlag_commission(String flag_commission) {
		this.flag_commission = flag_commission;
	}
	public String getTiers() {
		return tiers;
	}
	public void setTiers(String tiers) {
		this.tiers = tiers;
	}
	public String getFlag_stade() {
		return flag_stade;
	}
	public void setFlag_stade(String flag_stade) {
		this.flag_stade = flag_stade;
	}
	public String getDescription1() {
		return description1;
	}
	public void setDescription1(String description1) {
		this.description1 = description1;
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
	public Date getDate_echeance() {
		return date_echeance;
	}
	public void setDate_echeance(Date date_echeance) {
		this.date_echeance = date_echeance;
	}
	public Date getDate_emission() {
		return date_emission;
	}
	public void setDate_emission(Date date_emission) {
		this.date_emission = date_emission;
	}
	public String getDevise() {
		return devise;
	}
	public void setDevise(String devise) {
		this.devise = devise;
	}
	public String getMontant_signe() {
		return montant_signe;
	}
	public void setMontant_signe(String montant_signe) {
		this.montant_signe = montant_signe;
	}
	public String getMontant_signe_origine() {
		return montant_signe_origine;
	}
	public void setMontant_signe_origine(String montant_signe_origine) {
		this.montant_signe_origine = montant_signe_origine;
	}
	public String getDevise_origine() {
		return devise_origine;
	}
	public void setDevise_origine(String devise_origine) {
		this.devise_origine = devise_origine;
	}
	public String getNombre_operations() {
		return nombre_operations;
	}
	public void setNombre_operations(String nombre_operations) {
		this.nombre_operations = nombre_operations;
	}
	public String getTri_1() {
		return tri_1;
	}
	public void setTri_1(String tri_1) {
		this.tri_1 = tri_1;
	}
	public String getTri_2() {
		return tri_2;
	}
	public void setTri_2(String tri_2) {
		this.tri_2 = tri_2;
	}
	public String getTri_3() {
		return tri_3;
	}
	public void setTri_3(String tri_3) {
		this.tri_3 = tri_3;
	}
	public String getTri_devise() {
		return tri_devise;
	}
	public void setTri_devise(String tri_devise) {
		this.tri_devise = tri_devise;
	}
	public String getContrevaleur() {
		return contrevaleur;
	}
	public void setContrevaleur(String contrevaleur) {
		this.contrevaleur = contrevaleur;
	}
	public String getContrevaleur_origine() {
		return contrevaleur_origine;
	}
	public void setContrevaleur_origine(String contrevaleur_origine) {
		this.contrevaleur_origine = contrevaleur_origine;
	}
	public String getDevise_cv() {
		return devise_cv;
	}
	public void setDevise_cv(String devise_cv) {
		this.devise_cv = devise_cv;
	}
	public String getReconciliation_flag() {
		return reconciliation_flag;
	}
	public void setReconciliation_flag(String reconciliation_flag) {
		this.reconciliation_flag = reconciliation_flag;
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
	public BrfprofitlossHistory(BrfProfitlossDetailId brfProfitlossDetailId,
			String op_finance, String entite, String compte, String portefeuille, String mode_reglement,
			String flag_commission, String tiers, String flag_stade, String description1, Date date_operation,
			Date date_valeur, Date date_echeance, Date date_emission, String devise, String montant_signe,
			String montant_signe_origine, String devise_origine, String nombre_operations, String tri_1, String tri_2,
			String tri_3, String tri_devise, String contrevaleur, String contrevaleur_origine, String devise_cv,
			String reconciliation_flag, String del_flg, String rcre_user_id, Date rcre_time, String lchg_user_id,
			Date lchg_time, String verify_user_id, Date verify_time) {
		super();
		BrfProfitlossDetailId = brfProfitlossDetailId;
		this.op_finance = op_finance;
		this.entite = entite;
		this.compte = compte;
		this.portefeuille = portefeuille;
		this.mode_reglement = mode_reglement;
		this.flag_commission = flag_commission;
		this.tiers = tiers;
		this.flag_stade = flag_stade;
		this.description1 = description1;
		this.date_operation = date_operation;
		this.date_valeur = date_valeur;
		this.date_echeance = date_echeance;
		this.date_emission = date_emission;
		this.devise = devise;
		this.montant_signe = montant_signe;
		this.montant_signe_origine = montant_signe_origine;
		this.devise_origine = devise_origine;
		this.nombre_operations = nombre_operations;
		this.tri_1 = tri_1;
		this.tri_2 = tri_2;
		this.tri_3 = tri_3;
		this.tri_devise = tri_devise;
		this.contrevaleur = contrevaleur;
		this.contrevaleur_origine = contrevaleur_origine;
		this.devise_cv = devise_cv;
		this.reconciliation_flag = reconciliation_flag;
		this.del_flg = del_flg;
		this.rcre_user_id = rcre_user_id;
		this.rcre_time = rcre_time;
		this.lchg_user_id = lchg_user_id;
		this.lchg_time = lchg_time;
		this.verify_user_id = verify_user_id;
		this.verify_time = verify_time;
	}


	
	
}
