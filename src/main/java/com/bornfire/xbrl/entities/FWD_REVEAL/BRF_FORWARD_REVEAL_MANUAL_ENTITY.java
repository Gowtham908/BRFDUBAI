package com.bornfire.xbrl.entities.FWD_REVEAL;


import java.util.Date;


import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;


@Entity
@Table(name = "BRF_FORWARD_REVEAL_MANUAL_TABLE")
@IdClass(BRF_FORWARD_REVEAL_MANUAL_ID.class)
public class BRF_FORWARD_REVEAL_MANUAL_ENTITY {
	
 
         @Id
         private String	num_operation;
         @Id
         private String  report_date;
private String	gl_values;
private String	op_reference;
private String	poste;
private Date	dealdate;
private Date	valuedate;
private Date	maturitydate;
private String	currency1;
private String	currency2;
private String	nominal_1;
private String	ramount;
private String	no_of_days;
private String	amount1;
private String	dealrate;
private String	amount2;
private String	reval_rate;
private String	reval_amount;
private String	profitloss;
private String	contrepartie;
private String	branch_code;
private String	lcyrate;
private String	lcyprofitloss;
private String	entry_user;
private Date	entry_time;
private String	modify_user;
private Date	modify_time;
private String	verify_user;
private Date	verify_time;
private String	del_flg;
private String	entity_flg;
private String	modify_flg;





public String getNum_operation() {
	return num_operation;
}
public void setNum_operation(String num_operation) {
	this.num_operation = num_operation;
}
public String getReport_date() {
	return report_date;
}
public void setReport_date(String report_date) {
	this.report_date = report_date;
}
public String getGl_values() {
	return gl_values;
}
public void setGl_values(String gl_values) {
	this.gl_values = gl_values;
}
public String getOp_reference() {
	return op_reference;
}
public void setOp_reference(String op_reference) {
	this.op_reference = op_reference;
}
public String getPoste() {
	return poste;
}
public void setPoste(String poste) {
	this.poste = poste;
}
public Date getDealdate() {
	return dealdate;
}
public void setDealdate(Date dealdate) {
	this.dealdate = dealdate;
}
public Date getValuedate() {
	return valuedate;
}
public void setValuedate(Date valuedate) {
	this.valuedate = valuedate;
}
public Date getMaturitydate() {
	return maturitydate;
}
public void setMaturitydate(Date maturitydate) {
	this.maturitydate = maturitydate;
}
public String getCurrency1() {
	return currency1;
}
public void setCurrency1(String currency1) {
	this.currency1 = currency1;
}
public String getCurrency2() {
	return currency2;
}
public void setCurrency2(String currency2) {
	this.currency2 = currency2;
}
public String getNominal_1() {
	return nominal_1;
}
public void setNominal_1(String nominal_1) {
	this.nominal_1 = nominal_1;
}
public String getRamount() {
	return ramount;
}
public void setRamount(String ramount) {
	this.ramount = ramount;
}
public String getNo_of_days() {
	return no_of_days;
}
public void setNo_of_days(String no_of_days) {
	this.no_of_days = no_of_days;
}
public String getAmount1() {
	return amount1;
}
public void setAmount1(String amount1) {
	this.amount1 = amount1;
}
public String getDealrate() {
	return dealrate;
}
public void setDealrate(String dealrate) {
	this.dealrate = dealrate;
}
public String getAmount2() {
	return amount2;
}
public void setAmount2(String amount2) {
	this.amount2 = amount2;
}
public String getReval_rate() {
	return reval_rate;
}
public void setReval_rate(String reval_rate) {
	this.reval_rate = reval_rate;
}
public String getReval_amount() {
	return reval_amount;
}
public void setReval_amount(String reval_amount) {
	this.reval_amount = reval_amount;
}
public String getProfitloss() {
	return profitloss;
}
public void setProfitloss(String profitloss) {
	this.profitloss = profitloss;
}
public String getContrepartie() {
	return contrepartie;
}
public void setContrepartie(String contrepartie) {
	this.contrepartie = contrepartie;
}
public String getBranch_code() {
	return branch_code;
}
public void setBranch_code(String branch_code) {
	this.branch_code = branch_code;
}
public String getLcyrate() {
	return lcyrate;
}
public void setLcyrate(String lcyrate) {
	this.lcyrate = lcyrate;
}
public String getLcyprofitloss() {
	return lcyprofitloss;
}
public void setLcyprofitloss(String lcyprofitloss) {
	this.lcyprofitloss = lcyprofitloss;
}
public String getEntry_user() {
	return entry_user;
}
public void setEntry_user(String entry_user) {
	this.entry_user = entry_user;
}
public Date getEntry_time() {
	return entry_time;
}
public void setEntry_time(Date entry_time) {
	this.entry_time = entry_time;
}
public String getModify_user() {
	return modify_user;
}
public void setModify_user(String modify_user) {
	this.modify_user = modify_user;
}
public Date getModify_time() {
	return modify_time;
}
public void setModify_time(Date modify_time) {
	this.modify_time = modify_time;
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
public String getDel_flg() {
	return del_flg;
}
public void setDel_flg(String del_flg) {
	this.del_flg = del_flg;
}
public String getEntity_flg() {
	return entity_flg;
}
public void setEntity_flg(String entity_flg) {
	this.entity_flg = entity_flg;
}
public String getModify_flg() {
	return modify_flg;
}
public void setModify_flg(String modify_flg) {
	this.modify_flg = modify_flg;
}
public BRF_FORWARD_REVEAL_MANUAL_ENTITY(String num_operation, String report_date, String gl_values, String op_reference,
		String poste, Date dealdate, Date valuedate, Date maturitydate, String currency1, String currency2,
		String nominal_1, String ramount, String no_of_days, String amount1, String dealrate, String amount2,
		String reval_rate, String reval_amount, String profitloss, String contrepartie, String branch_code,
		String lcyrate, String lcyprofitloss, String entry_user, Date entry_time, String modify_user, Date modify_time,
		String verify_user, Date verify_time, String del_flg, String entity_flg, String modify_flg) {
	super();
	this.num_operation = num_operation;
	this.report_date = report_date;
	this.gl_values = gl_values;
	this.op_reference = op_reference;
	this.poste = poste;
	this.dealdate = dealdate;
	this.valuedate = valuedate;
	this.maturitydate = maturitydate;
	this.currency1 = currency1;
	this.currency2 = currency2;
	this.nominal_1 = nominal_1;
	this.ramount = ramount;
	this.no_of_days = no_of_days;
	this.amount1 = amount1;
	this.dealrate = dealrate;
	this.amount2 = amount2;
	this.reval_rate = reval_rate;
	this.reval_amount = reval_amount;
	this.profitloss = profitloss;
	this.contrepartie = contrepartie;
	this.branch_code = branch_code;
	this.lcyrate = lcyrate;
	this.lcyprofitloss = lcyprofitloss;
	this.entry_user = entry_user;
	this.entry_time = entry_time;
	this.modify_user = modify_user;
	this.modify_time = modify_time;
	this.verify_user = verify_user;
	this.verify_time = verify_time;
	this.del_flg = del_flg;
	this.entity_flg = entity_flg;
	this.modify_flg = modify_flg;
}
public BRF_FORWARD_REVEAL_MANUAL_ENTITY(String num_operation2, String report_date2, String gl_values2,
		String op_reference2, String poste2, String currency12, String currency22, String nominal_12, String ramount2,
		String no_of_days2, String amount12, String dealrate2, String amount22, String reval_rate2,
		String reval_amount2, String profitloss2, String contrepartie2, String branch_code2, String lcyrate2,
		String lcyprofitloss2, String entry_user2, String modify_user2, String verify_user2, String del_flg2,
		String entity_flg2, String modify_flg2, Date date) {
	// TODO Auto-generated constructor stub
}
public BRF_FORWARD_REVEAL_MANUAL_ENTITY() {
	super();
	// TODO Auto-generated constructor stub
}





}
