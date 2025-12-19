package com.bornfire.xbrl.entities.BRBS;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "BRF102_SUMMARYTABLE")
public class BRF102_Entity {
	private String customer_name;
	private String account_number;
	private String customer_last;
	private String bank_branch_name;
	private String account_type;
	private Date last_transaction_date;
	private Date last_communication_date;
	private BigDecimal account_balance;
	private String currency;
	private BigDecimal interest_rate_applicable;
	private String type_customer_id;
	private Date id_expiry_date;
	@Id
	private BigDecimal srl_no;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date report_date;
	private Date report_submit_date;
	private Date report_from_date;
	private Date report_to_date;
	private String report_code;
	private String entity_flg;
	private String modify_flg;
	private String del_flg;
	private String entry_user;
	private String modify_user;
	private String verify_user;
	private Date entry_time;
	private Date modify_time;
	private Date verify_time;
	private String repdesc;
	private String frequency;

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

	public String getCustomer_last() {
		return customer_last;
	}

	public void setCustomer_last(String customer_last) {
		this.customer_last = customer_last;
	}

	public String getBank_branch_name() {
		return bank_branch_name;
	}

	public void setBank_branch_name(String bank_branch_name) {
		this.bank_branch_name = bank_branch_name;
	}

	public String getAccount_type() {
		return account_type;
	}

	public void setAccount_type(String account_type) {
		this.account_type = account_type;
	}

	public Date getLast_transaction_date() {
		return last_transaction_date;
	}

	public void setLast_transaction_date(Date last_transaction_date) {
		this.last_transaction_date = last_transaction_date;
	}

	public Date getLast_communication_date() {
		return last_communication_date;
	}

	public void setLast_communication_date(Date last_communication_date) {
		this.last_communication_date = last_communication_date;
	}

	public BigDecimal getAccount_balance() {
		return account_balance;
	}

	public void setAccount_balance(BigDecimal account_balance) {
		this.account_balance = account_balance;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public BigDecimal getInterest_rate_applicable() {
		return interest_rate_applicable;
	}

	public void setInterest_rate_applicable(BigDecimal interest_rate_applicable) {
		this.interest_rate_applicable = interest_rate_applicable;
	}

	public String getType_customer_id() {
		return type_customer_id;
	}

	public void setType_customer_id(String type_customer_id) {
		this.type_customer_id = type_customer_id;
	}

	public Date getId_expiry_date() {
		return id_expiry_date;
	}

	public void setId_expiry_date(Date id_expiry_date) {
		this.id_expiry_date = id_expiry_date;
	}

	public BigDecimal getSrl_no() {
		return srl_no;
	}

	public void setSrl_no(BigDecimal srl_no) {
		this.srl_no = srl_no;
	}

	public Date getReport_date() {
		return report_date;
	}

	public void setReport_date(Date report_date) {
		this.report_date = report_date;
	}

	public Date getReport_submit_date() {
		return report_submit_date;
	}

	public void setReport_submit_date(Date report_submit_date) {
		this.report_submit_date = report_submit_date;
	}

	public Date getReport_from_date() {
		return report_from_date;
	}

	public void setReport_from_date(Date report_from_date) {
		this.report_from_date = report_from_date;
	}

	public Date getReport_to_date() {
		return report_to_date;
	}

	public void setReport_to_date(Date report_to_date) {
		this.report_to_date = report_to_date;
	}

	public String getReport_code() {
		return report_code;
	}

	public void setReport_code(String report_code) {
		this.report_code = report_code;
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

	public String getDel_flg() {
		return del_flg;
	}

	public void setDel_flg(String del_flg) {
		this.del_flg = del_flg;
	}

	public String getEntry_user() {
		return entry_user;
	}

	public void setEntry_user(String entry_user) {
		this.entry_user = entry_user;
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

	public Date getEntry_time() {
		return entry_time;
	}

	public void setEntry_time(Date entry_time) {
		this.entry_time = entry_time;
	}

	public Date getModify_time() {
		return modify_time;
	}

	public void setModify_time(Date modify_time) {
		this.modify_time = modify_time;
	}

	public Date getVerify_time() {
		return verify_time;
	}

	public void setVerify_time(Date verify_time) {
		this.verify_time = verify_time;
	}

	public String getRepdesc() {
		return repdesc;
	}

	public void setRepdesc(String repdesc) {
		this.repdesc = repdesc;
	}

	public String getFrequency() {
		return frequency;
	}

	public void setFrequency(String frequency) {
		this.frequency = frequency;
	}

	public BRF102_Entity(String customer_name, String account_number, String customer_last, String bank_branch_name,
			String account_type, Date last_transaction_date, Date last_communication_date, BigDecimal account_balance,
			String currency, BigDecimal interest_rate_applicable, String type_customer_id, Date id_expiry_date,
			BigDecimal srl_no, Date report_date, Date report_submit_date, Date report_from_date, Date report_to_date,
			String report_code, String entity_flg, String modify_flg, String del_flg, String entry_user,
			String modify_user, String verify_user, Date entry_time, Date modify_time, Date verify_time, String repdesc,
			String frequency) {
		super();
		this.customer_name = customer_name;
		this.account_number = account_number;
		this.customer_last = customer_last;
		this.bank_branch_name = bank_branch_name;
		this.account_type = account_type;
		this.last_transaction_date = last_transaction_date;
		this.last_communication_date = last_communication_date;
		this.account_balance = account_balance;
		this.currency = currency;
		this.interest_rate_applicable = interest_rate_applicable;
		this.type_customer_id = type_customer_id;
		this.id_expiry_date = id_expiry_date;
		this.srl_no = srl_no;
		this.report_date = report_date;
		this.report_submit_date = report_submit_date;
		this.report_from_date = report_from_date;
		this.report_to_date = report_to_date;
		this.report_code = report_code;
		this.entity_flg = entity_flg;
		this.modify_flg = modify_flg;
		this.del_flg = del_flg;
		this.entry_user = entry_user;
		this.modify_user = modify_user;
		this.verify_user = verify_user;
		this.entry_time = entry_time;
		this.modify_time = modify_time;
		this.verify_time = verify_time;
		this.repdesc = repdesc;
		this.frequency = frequency;
	}

	@Override
	public String toString() {
		return "BRF102_Entity [customer_name=" + customer_name + ", account_number=" + account_number
				+ ", customer_last=" + customer_last + ", bank_branch_name=" + bank_branch_name + ", account_type="
				+ account_type + ", last_transaction_date=" + last_transaction_date + ", last_communication_date="
				+ last_communication_date + ", account_balance=" + account_balance + ", currency=" + currency
				+ ", interest_rate_applicable=" + interest_rate_applicable + ", type_customer_id=" + type_customer_id
				+ ", id_expiry_date=" + id_expiry_date + ", srl_no=" + srl_no + ", report_date=" + report_date
				+ ", report_submit_date=" + report_submit_date + ", report_from_date=" + report_from_date
				+ ", report_to_date=" + report_to_date + ", report_code=" + report_code + ", entity_flg=" + entity_flg
				+ ", modify_flg=" + modify_flg + ", del_flg=" + del_flg + ", entry_user=" + entry_user
				+ ", modify_user=" + modify_user + ", verify_user=" + verify_user + ", entry_time=" + entry_time
				+ ", modify_time=" + modify_time + ", verify_time=" + verify_time + ", repdesc=" + repdesc
				+ ", frequency=" + frequency + "]";
	}

	public BRF102_Entity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void setLast_communication_date(String formattedDate) {
		// Parse the formatted date string and set it to the last_communication_date
		// field
		try {
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
			Date parsedDate = dateFormat.parse(formattedDate);
			this.last_communication_date = parsedDate;
		} catch (ParseException e) {
			// Handle parsing exception if needed
			System.out.println("Error parsing last communication date: " + e.getMessage());
			e.printStackTrace();
		}
	}
}