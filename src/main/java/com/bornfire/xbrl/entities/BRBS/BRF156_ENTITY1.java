package com.bornfire.xbrl.entities.BRBS;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "BRF156_SUMMARYTABLE1")
public class BRF156_ENTITY1 {

	private Date deal_date;
	private BigDecimal usd_amount;
	private BigDecimal aed_amount;
	private Date deal_maturity_date;
	private String counterparty_type;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy")

	private Date report_date;
	private Date report_from_date;
	private Date report_to_date;
	private String entity_flg;
	private String modify_flg;
	private String del_flg;
	private String report_code;
	private Date report_submit_date;
	@Id
	private String row_label;
	private String repdesc;
	private String frequency;

	public Date getDeal_date() {
		return deal_date;
	}

	public void setDeal_date(Date deal_date) {
		this.deal_date = deal_date;
	}

	public BigDecimal getUsd_amount() {
		return usd_amount;
	}

	public void setUsd_amount(BigDecimal usd_amount) {
		this.usd_amount = usd_amount;
	}

	public BigDecimal getAed_amount() {
		return aed_amount;
	}

	public void setAed_amount(BigDecimal aed_amount) {
		this.aed_amount = aed_amount;
	}

	public Date getDeal_maturity_date() {
		return deal_maturity_date;
	}

	public void setDeal_maturity_date(Date deal_maturity_date) {
		this.deal_maturity_date = deal_maturity_date;
	}

	public String getCounterparty_type() {
		return counterparty_type;
	}

	public void setCounterparty_type(String counterparty_type) {
		this.counterparty_type = counterparty_type;
	}

	public Date getReport_date() {
		return report_date;
	}

	public void setReport_date(Date report_date) {
		this.report_date = report_date;
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

	public String getReport_code() {
		return report_code;
	}

	public void setReport_code(String report_code) {
		this.report_code = report_code;
	}

	public Date getReport_submit_date() {
		return report_submit_date;
	}

	public void setReport_submit_date(Date report_submit_date) {
		this.report_submit_date = report_submit_date;
	}

	public String getRow_label() {
		return row_label;
	}

	public void setRow_label(String row_label) {
		this.row_label = row_label;
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

	public BRF156_ENTITY1(Date deal_date, BigDecimal usd_amount, BigDecimal aed_amount, Date deal_maturity_date,
			String counterparty_type, Date report_date, Date report_from_date, Date report_to_date, String entity_flg,
			String modify_flg, String del_flg, String report_code, Date report_submit_date, String row_label,
			String repdesc, String frequency) {
		super();
		this.deal_date = deal_date;
		this.usd_amount = usd_amount;
		this.aed_amount = aed_amount;
		this.deal_maturity_date = deal_maturity_date;
		this.counterparty_type = counterparty_type;
		this.report_date = report_date;
		this.report_from_date = report_from_date;
		this.report_to_date = report_to_date;
		this.entity_flg = entity_flg;
		this.modify_flg = modify_flg;
		this.del_flg = del_flg;
		this.report_code = report_code;
		this.report_submit_date = report_submit_date;
		this.row_label = row_label;
		this.repdesc = repdesc;
		this.frequency = frequency;
	}

	public BRF156_ENTITY1() {
		super();
		// TODO Auto-generated constructor stub
	}

}
