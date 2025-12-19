package com.bornfire.xbrl.entities.M_BILL;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Embedded;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.format.annotation.DateTimeFormat;

import com.bornfire.xbrl.entities.BLS0100.BLS0100Mod;
import com.bornfire.xbrl.entities.FWD_REVEAL.BRF_FORWARD_REVEALDetail_Id;

@Entity

@Table(name="BRF_M_BILL_H_TB")
public class BRF_M_BILL_History {
	
	@EmbeddedId
	BRF_M_BILL_DETAIL_ID BRF_M_BILL_HistoryId;
	@Transient
	private String	num_compta;
	//private String	numero_piece;
	private String	op_finance;
	private String	op_evenement;
	
	private String	compte;
	private String	entite_groupe;
	private String	tiers;
	private String	description;
	private String	entite_operation;
	private String	poste;
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date	date_compta;
	private String	devise;
	private String	montant;
	private String	cours;
	private String	contrevaleur;
	private String	signe;
	private String	devise_compta;
	private String	entite;
	private String	flag_od;
	
	private String	tri_1;
	private String	tri_2;
	private String	tri_3;
	private String	type_instrument;
	private String	standard;
	//@DateTimeFormat(pattern = "dd-MM-yyyy")
	//private Date	report_date;
	 private String del_flg;
		private String rcre_user_id;
		private Date rcre_time;
		private String lchg_user_id;
		private Date lchg_time;
		private String verify_user_id;
		private Date verify_time;
		public BRF_M_BILL_DETAIL_ID getBRF_M_BILL_HistoryId() {
			return BRF_M_BILL_HistoryId;
		}
		public void setBRF_M_BILL_HistoryId(BRF_M_BILL_DETAIL_ID bRF_M_BILL_HistoryId) {
			BRF_M_BILL_HistoryId = bRF_M_BILL_HistoryId;
		}
		public String getNum_compta() {
			return num_compta;
		}
		public void setNum_compta(String num_compta) {
			this.num_compta = num_compta;
		}
	/*	public String getNumero_piece() {
			return numero_piece;
		}
		public void setNumero_piece(String numero_piece) {
			this.numero_piece = numero_piece;
		}*/
		public String getOp_finance() {
			return op_finance;
		}
		public void setOp_finance(String op_finance) {
			this.op_finance = op_finance;
		}
		public String getOp_evenement() {
			return op_evenement;
		}
		public void setOp_evenement(String op_evenement) {
			this.op_evenement = op_evenement;
		}
		public String getCompte() {
			return compte;
		}
		public void setCompte(String compte) {
			this.compte = compte;
		}
		public String getEntite_groupe() {
			return entite_groupe;
		}
		public void setEntite_groupe(String entite_groupe) {
			this.entite_groupe = entite_groupe;
		}
		public String getTiers() {
			return tiers;
		}
		public void setTiers(String tiers) {
			this.tiers = tiers;
		}
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
		public String getEntite_operation() {
			return entite_operation;
		}
		public void setEntite_operation(String entite_operation) {
			this.entite_operation = entite_operation;
		}
		public String getPoste() {
			return poste;
		}
		public void setPoste(String poste) {
			this.poste = poste;
		}
		public Date getDate_compta() {
			return date_compta;
		}
		public void setDate_compta(Date date_compta) {
			this.date_compta = date_compta;
		}
		public String getDevise() {
			return devise;
		}
		public void setDevise(String devise) {
			this.devise = devise;
		}
		public String getMontant() {
			return montant;
		}
		public void setMontant(String montant) {
			this.montant = montant;
		}
		public String getCours() {
			return cours;
		}
		public void setCours(String cours) {
			this.cours = cours;
		}
		public String getContrevaleur() {
			return contrevaleur;
		}
		public void setContrevaleur(String contrevaleur) {
			this.contrevaleur = contrevaleur;
		}
		public String getSigne() {
			return signe;
		}
		public void setSigne(String signe) {
			this.signe = signe;
		}
		public String getDevise_compta() {
			return devise_compta;
		}
		public void setDevise_compta(String devise_compta) {
			this.devise_compta = devise_compta;
		}
		public String getEntite() {
			return entite;
		}
		public void setEntite(String entite) {
			this.entite = entite;
		}
		public String getFlag_od() {
			return flag_od;
		}
		public void setFlag_od(String flag_od) {
			this.flag_od = flag_od;
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
		public String getType_instrument() {
			return type_instrument;
		}
		public void setType_instrument(String type_instrument) {
			this.type_instrument = type_instrument;
		}
		public String getStandard() {
			return standard;
		}
		public void setStandard(String standard) {
			this.standard = standard;
		}
	/*	public Date getReport_date() {
			return report_date;
		}
		public void setReport_date(Date report_date) {
			this.report_date = report_date;
		}*/
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
		public BRF_M_BILL_History(BRF_M_BILL_DETAIL_ID bRF_M_BILL_HistoryId, String num_compta, String numero_piece,
				String op_finance, String op_evenement, String compte, String entite_groupe, String tiers,
				String description, String entite_operation, String poste, Date date_compta, String devise,
				String montant, String cours, String contrevaleur, String signe, String devise_compta, String entite,
				String flag_od, String tri_1, String tri_2, String tri_3, String type_instrument, String standard,
				Date report_date, String del_flg, String rcre_user_id, Date rcre_time, String lchg_user_id,
				Date lchg_time, String verify_user_id, Date verify_time) {
			super();
			BRF_M_BILL_HistoryId = bRF_M_BILL_HistoryId;
			this.num_compta = num_compta;
			//this.numero_piece = numero_piece;
			this.op_finance = op_finance;
			this.op_evenement = op_evenement;
			this.compte = compte;
			this.entite_groupe = entite_groupe;
			this.tiers = tiers;
			this.description = description;
			this.entite_operation = entite_operation;
			this.poste = poste;
			this.date_compta = date_compta;
			this.devise = devise;
			this.montant = montant;
			this.cours = cours;
			this.contrevaleur = contrevaleur;
			this.signe = signe;
			this.devise_compta = devise_compta;
			this.entite = entite;
			this.flag_od = flag_od;
			this.tri_1 = tri_1;
			this.tri_2 = tri_2;
			this.tri_3 = tri_3;
			this.type_instrument = type_instrument;
			this.standard = standard;
			//this.report_date = report_date;
			this.del_flg = del_flg;
			this.rcre_user_id = rcre_user_id;
			this.rcre_time = rcre_time;
			this.lchg_user_id = lchg_user_id;
			this.lchg_time = lchg_time;
			this.verify_user_id = verify_user_id;
			this.verify_time = verify_time;
		}
	
		public BRF_M_BILL_History(BRF_M_BILL_MOD mod) {
			this.setNum_compta	(mod.getNum_compta	());
			//this.setNumero_piece	(mod.getNumero_piece	());
			this.setOp_finance	(mod.getOp_finance	());
			this.setOp_evenement	(mod.getOp_evenement	());
			this.setCompte	(mod.getCompte	());
			this.setEntite_groupe	(mod.getEntite_groupe	());
			this.setTiers	(mod.getTiers	());
			this.setDescription	(mod.getDescription	());
			this.setEntite_operation	(mod.getEntite_operation	());
			this.setPoste	(mod.getPoste	());
			this.setDate_compta	(mod.getDate_compta	());
			this.setDevise	(mod.getDevise	());
			this.setMontant	(mod.getMontant	());
			this.setCours	(mod.getCours	());
			this.setContrevaleur	(mod.getContrevaleur	());
			this.setSigne	(mod.getSigne	());
			this.setDevise_compta	(mod.getDevise_compta	());
			this.setEntite	(mod.getEntite	());
			this.setFlag_od(mod.getFlag_od	());
			this.setDescription	(mod.getDescription	());
			this.setTri_1	(mod.getTri_1	());
			this.setTri_2	(mod.getTri_2	());
			this.setTri_3	(mod.getTri_3	());
			this.setType_instrument	(mod.getType_instrument	());
			this.setStandard	(mod.getStandard	());
			//this.setReport_date	(mod.getReport_date	());
			this.setDel_flg	(mod.getDel_flg	());
			this.setRcre_user_id	(mod.getRcre_user_id	());
			this.setRcre_time	(mod.getRcre_time	());
			this.setLchg_user_id	(mod.getLchg_user_id	());
			this.setLchg_time	(mod.getLchg_time	());
			this.setVerify_user_id	(mod.getVerify_user_id	());
			this.setVerify_time	(mod.getVerify_time	());


		}
		
}
