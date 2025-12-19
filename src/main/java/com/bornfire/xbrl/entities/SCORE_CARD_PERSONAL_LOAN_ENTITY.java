package com.bornfire.xbrl.entities;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "SCORE_CARD_PERSONAL_LOAN")
public class SCORE_CARD_PERSONAL_LOAN_ENTITY {
    
    @Id
    private String	customer_id;
    private String	customer_name;
    private String	account_number;
    private BigDecimal	total_score;
    private String	risk_level;
    private Date	entry_date;
	public String getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(String customer_id) {
		this.customer_id = customer_id;
	}
	public String getCustomer_name() {
		return customer_name;
	}
	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}
	public String getAccount_number() {
		return account_number;
	}
	public void setAccount_number(String account_number) {
		this.account_number = account_number;
	}
	public BigDecimal getTotal_score() {
		return total_score;
	}
	public void setTotal_score(BigDecimal total_score) {
		this.total_score = total_score;
	}
	public String getRisk_level() {
		return risk_level;
	}
	public void setRisk_level(String risk_level) {
		this.risk_level = risk_level;
	}
	public Date getEntry_date() {
		return entry_date;
	}
	public void setEntry_date(Date entry_date) {
		this.entry_date = entry_date;
	}
	public SCORE_CARD_PERSONAL_LOAN_ENTITY(String customer_id, String customer_name, String account_number,
			BigDecimal total_score, String risk_level, Date entry_date) {
		super();
		this.customer_id = customer_id;
		this.customer_name = customer_name;
		this.account_number = account_number;
		this.total_score = total_score;
		this.risk_level = risk_level;
		this.entry_date = entry_date;
	}
	public SCORE_CARD_PERSONAL_LOAN_ENTITY() {
		super();
		// TODO Auto-generated constructor stub
	}

	
    
    
}