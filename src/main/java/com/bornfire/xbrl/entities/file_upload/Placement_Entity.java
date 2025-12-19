package com.bornfire.xbrl.entities.file_upload;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "PLACEMENT_MANUAL_TABLE")
public class Placement_Entity {
	@Id
	private BigDecimal	num_operation;
	private BigDecimal	entite_operation;
	private String	poste;
	private String	titre;
	private String	devise_1;
	private BigDecimal	nominal_1;
	private Date	date_operation;
	private Date	date_valeur;
	private Date	date_echeance;
	private String	preavis;
	private String	entite;
	private String	portefeuille;
	private String	contrepartie;
	private String	acct_no;
	private Date	report_date;
	private String	acct_name;
	private BigDecimal	acct_bal;
	private String	nre_status;
	public BigDecimal getNum_operation() {
		return num_operation;
	}
	public void setNum_operation(BigDecimal num_operation) {
		this.num_operation = num_operation;
	}
	public BigDecimal getEntite_operation() {
		return entite_operation;
	}
	public void setEntite_operation(BigDecimal entite_operation) {
		this.entite_operation = entite_operation;
	}
	public String getPoste() {
		return poste;
	}
	public void setPoste(String poste) {
		this.poste = poste;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public String getDevise_1() {
		return devise_1;
	}
	public void setDevise_1(String devise_1) {
		this.devise_1 = devise_1;
	}
	public BigDecimal getNominal_1() {
		return nominal_1;
	}
	public void setNominal_1(BigDecimal nominal_1) {
		this.nominal_1 = nominal_1;
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
	public String getPreavis() {
		return preavis;
	}
	public void setPreavis(String preavis) {
		this.preavis = preavis;
	}
	public String getEntite() {
		return entite;
	}
	public void setEntite(String entite) {
		this.entite = entite;
	}
	public String getPortefeuille() {
		return portefeuille;
	}
	public void setPortefeuille(String portefeuille) {
		this.portefeuille = portefeuille;
	}
	public String getContrepartie() {
		return contrepartie;
	}
	public void setContrepartie(String contrepartie) {
		this.contrepartie = contrepartie;
	}
	public String getAcct_no() {
		return acct_no;
	}
	public void setAcct_no(String acct_no) {
		this.acct_no = acct_no;
	}
	public Date getReport_date() {
		return report_date;
	}
	public void setReport_date(Date report_date) {
		this.report_date = report_date;
	}
	public String getAcct_name() {
		return acct_name;
	}
	public void setAcct_name(String acct_name) {
		this.acct_name = acct_name;
	}
	public BigDecimal getAcct_bal() {
		return acct_bal;
	}
	public void setAcct_bal(BigDecimal acct_bal) {
		this.acct_bal = acct_bal;
	}
	public String getNre_status() {
		return nre_status;
	}
	public void setNre_status(String nre_status) {
		this.nre_status = nre_status;
	}
	public Placement_Entity(BigDecimal num_operation, BigDecimal entite_operation, String poste, String titre,
			String devise_1, BigDecimal nominal_1, Date date_operation, Date date_valeur, Date date_echeance,
			String preavis, String entite, String portefeuille, String contrepartie, String acct_no, Date report_date,
			String acct_name, BigDecimal acct_bal, String nre_status) {
		super();
		this.num_operation = num_operation;
		this.entite_operation = entite_operation;
		this.poste = poste;
		this.titre = titre;
		this.devise_1 = devise_1;
		this.nominal_1 = nominal_1;
		this.date_operation = date_operation;
		this.date_valeur = date_valeur;
		this.date_echeance = date_echeance;
		this.preavis = preavis;
		this.entite = entite;
		this.portefeuille = portefeuille;
		this.contrepartie = contrepartie;
		this.acct_no = acct_no;
		this.report_date = report_date;
		this.acct_name = acct_name;
		this.acct_bal = acct_bal;
		this.nre_status = nre_status;
	}
	public Placement_Entity() {
		super();
		// TODO Auto-generated constructor stub
	}

}
