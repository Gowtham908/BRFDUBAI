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
@Table(name = "BRF094F_SUMMARYTABLE")

public class BRF094_SUMMARYENTITY6 {
	private String country_break_down;
	private String remaining_countries;
	private BigDecimal govt_finan_invest_no_of_transactions;
	private BigDecimal govt_finan_invest_amount;
	private BigDecimal govt_direct_invest_no_of_transactions;
	private BigDecimal govt_direct_invest_amount;
	private BigDecimal govt_service_no_of_transactions;
	private BigDecimal govt_service_invest_amount;
	private BigDecimal govt_trade_no_of_transactions;
	private BigDecimal govt_trade_invest_amount;
	private BigDecimal reserve_finan_invest_no_of_transactions;
	private BigDecimal reserve_finan_invest_amount;
	private BigDecimal reserve_direct_invest_no_of_transactions;
	private BigDecimal reserve_direct_invest_amount;
	private BigDecimal reserve_service_no_of_transactions;
	private BigDecimal reserve_service_invest_amount;
	private BigDecimal reserve_trade_no_of_transactions;
	private BigDecimal reserve_trade_invest_amount;
	private BigDecimal gre_finan_invest_no_of_transactions;
	private BigDecimal gre_finan_invest_amount;
	private BigDecimal gre_direct_invest_no_of_transactions;
	private BigDecimal gre_direct_invest_amount;
	private BigDecimal gre_service_no_of_transactions;
	private BigDecimal gre_service_invest_amount;
	private BigDecimal gre_trade_no_of_transactions;
	private BigDecimal gre_trade_invest_amount;
	private BigDecimal corporate_finan_invest_no_of_transactions;
	private BigDecimal corporate_finan_invest_amount;
	private BigDecimal corporate_direct_invest_no_of_transactions;
	private BigDecimal corporate_direct_invest_amount;
	private BigDecimal corporate_service_no_of_transactions;
	private BigDecimal corporate_service_invest_amount;
	private BigDecimal corporate_trade_no_of_transactions;
	private BigDecimal corporate_trade_invest_amount;
	private BigDecimal sme_finan_invest_no_of_transactions;
	private BigDecimal sme_finan_invest_amount;
	private BigDecimal sme_direct_invest_no_of_transactions;
	private BigDecimal sme_direct_invest_amount;
	private BigDecimal sme_service_no_of_transactions;
	private BigDecimal sme_service_invest_amount;
	private BigDecimal sme_trade_no_of_transactions;
	private BigDecimal sme_trade_invest_amount;
	private BigDecimal indvidual_finan_invest_no_of_transactions;
	private BigDecimal indvidual_finan_invest_amount;
	private BigDecimal indvidual_direct_invest_no_of_transactions;
	private BigDecimal indvidual_direct_invest_amount;
	private BigDecimal indvidual_family_no_of_transactions;
	private BigDecimal indvidual_family_invest_amount;
	private BigDecimal indvidual_educate_no_of_transactions;
	private BigDecimal indvidual_educate_invest_amount;
	private BigDecimal indvidual_medical_no_of_transactions;
	private BigDecimal indvidual_medical_invest_amount;
	private BigDecimal indvidual_tour_no_of_transactions;
	private BigDecimal indvidual_tour_invest_amount;
	private BigDecimal indvidual_debt_no_of_transactions;
	private BigDecimal indvidual_debt_invest_amount;
	private BigDecimal indvidual_other_no_of_transactions;
	private BigDecimal indvidual_other_invest_amount;
	private BigDecimal transactions;
	private BigDecimal amount;
	private BigDecimal rem_govt_finan_invest_no_of_transactions_total;
	private BigDecimal rem_govt_finan_invest_amount_total;
	private BigDecimal rem_govt_direct_invest_no_of_transactions_total;
	private BigDecimal rem_govt_direct_invest_amount_total;
	private BigDecimal rem_govt_service_no_of_transactions_total;
	private BigDecimal rem_govt_service_invest_amount_total;
	private BigDecimal rem_govt_trade_no_of_transactions_total;
	private BigDecimal rem_govt_trade_invest_amount_total;
	private BigDecimal rem_reserve_finan_invest_no_of_transactions_total;
	private BigDecimal rem_reserve_finan_invest_amount_total;
	private BigDecimal rem_reserve_direct_invest_no_of_transactions_total;
	private BigDecimal rem_reserve_direct_invest_amount_total;
	private BigDecimal rem_reserve_service_no_of_transactions_total;
	private BigDecimal rem_reserve_service_invest_amount_total;
	private BigDecimal rem_reserve_trade_no_of_transactions_total;
	private BigDecimal rem_reserve_trade_invest_amount_total;
	private BigDecimal rem_gre_finan_invest_no_of_transactions_total;
	private BigDecimal rem_gre_finan_invest_amount_total;
	private BigDecimal rem_gre_direct_invest_no_of_transactions_total;
	private BigDecimal rem_gre_direct_invest_amount_total;
	private BigDecimal rem_gre_service_no_of_transactions_total;
	private BigDecimal rem_gre_service_invest_amount_total;
	private BigDecimal rem_gre_trade_no_of_transactions_total;
	private BigDecimal rem_gre_trade_invest_amount_total;
	private BigDecimal rem_corporate_finan_invest_no_of_transactions_total;
	private BigDecimal rem_corporate_finan_invest_amount_total;
	private BigDecimal rem_corporate_direct_invest_no_of_transactions_total;
	private BigDecimal rem_corporate_direct_invest_amount_total;
	private BigDecimal rem_corporate_service_no_of_transactions_total;
	private BigDecimal rem_corporate_service_invest_amount_total;
	private BigDecimal rem_corporate_trade_no_of_transactions_total;
	private BigDecimal rem_corporate_trade_invest_amount_total;
	private BigDecimal rem_sme_finan_invest_no_of_transactions_total;
	private BigDecimal rem_sme_finan_invest_amount_total;
	private BigDecimal rem_sme_direct_invest_no_of_transactions_total;
	private BigDecimal rem_sme_direct_invest_amount_total;
	private BigDecimal rem_sme_service_no_of_transactions_total;
	private BigDecimal rem_sme_service_invest_amount_total;
	private BigDecimal rem_sme_trade_no_of_transactions_total;
	private BigDecimal rem_sme_trade_invest_amount_total;
	private BigDecimal rem_indvidual_finan_invest_no_of_transactions_total;
	private BigDecimal rem_indvidual_finan_invest_amount_total;
	private BigDecimal rem_indvidual_direct_invest_no_of_transactions_total;
	private BigDecimal rem_indvidual_direct_invest_amount_total;
	private BigDecimal rem_indvidual_family_no_of_transactions_total;
	private BigDecimal rem_indvidual_family_invest_amount_total;
	private BigDecimal rem_indvidual_educate_no_of_transactions_total;
	private BigDecimal rem_indvidual_educate_invest_amount_total;
	private BigDecimal rem_indvidual_medical_no_of_transactions_total;
	private BigDecimal rem_indvidual_medical_invest_amount_total;
	private BigDecimal rem_indvidual_tour_no_of_transactions_total;
	private BigDecimal rem_indvidual_tour_invest_amount_total;
	private BigDecimal rem_indvidual_debt_no_of_transactions_total;
	private BigDecimal rem_indvidual_debt_invest_amount_total;
	private BigDecimal rem_indvidual_other_no_of_transactions_total;
	private BigDecimal rem_indvidual_other_invest_amount_total;
	private BigDecimal rem_transactions_total;
	private BigDecimal rem_amount_total;
	@Id
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
	private String row_label;
	private String repdesc;
	private String frequency;

	public String getCountry_break_down() {
		return country_break_down;
	}

	public String getRemaining_countries() {
		return remaining_countries;
	}

	public BigDecimal getGovt_finan_invest_no_of_transactions() {
		return govt_finan_invest_no_of_transactions;
	}

	public BigDecimal getGovt_finan_invest_amount() {
		return govt_finan_invest_amount;
	}

	public BigDecimal getGovt_direct_invest_no_of_transactions() {
		return govt_direct_invest_no_of_transactions;
	}

	public BigDecimal getGovt_direct_invest_amount() {
		return govt_direct_invest_amount;
	}

	public BigDecimal getGovt_service_no_of_transactions() {
		return govt_service_no_of_transactions;
	}

	public BigDecimal getGovt_service_invest_amount() {
		return govt_service_invest_amount;
	}

	public BigDecimal getGovt_trade_no_of_transactions() {
		return govt_trade_no_of_transactions;
	}

	public BigDecimal getGovt_trade_invest_amount() {
		return govt_trade_invest_amount;
	}

	public BigDecimal getReserve_finan_invest_no_of_transactions() {
		return reserve_finan_invest_no_of_transactions;
	}

	public BigDecimal getReserve_finan_invest_amount() {
		return reserve_finan_invest_amount;
	}

	public BigDecimal getReserve_direct_invest_no_of_transactions() {
		return reserve_direct_invest_no_of_transactions;
	}

	public BigDecimal getReserve_direct_invest_amount() {
		return reserve_direct_invest_amount;
	}

	public BigDecimal getReserve_service_no_of_transactions() {
		return reserve_service_no_of_transactions;
	}

	public BigDecimal getReserve_service_invest_amount() {
		return reserve_service_invest_amount;
	}

	public BigDecimal getReserve_trade_no_of_transactions() {
		return reserve_trade_no_of_transactions;
	}

	public BigDecimal getReserve_trade_invest_amount() {
		return reserve_trade_invest_amount;
	}

	public BigDecimal getGre_finan_invest_no_of_transactions() {
		return gre_finan_invest_no_of_transactions;
	}

	public BigDecimal getGre_finan_invest_amount() {
		return gre_finan_invest_amount;
	}

	public BigDecimal getGre_direct_invest_no_of_transactions() {
		return gre_direct_invest_no_of_transactions;
	}

	public BigDecimal getGre_direct_invest_amount() {
		return gre_direct_invest_amount;
	}

	public BigDecimal getGre_service_no_of_transactions() {
		return gre_service_no_of_transactions;
	}

	public BigDecimal getGre_service_invest_amount() {
		return gre_service_invest_amount;
	}

	public BigDecimal getGre_trade_no_of_transactions() {
		return gre_trade_no_of_transactions;
	}

	public BigDecimal getGre_trade_invest_amount() {
		return gre_trade_invest_amount;
	}

	public BigDecimal getCorporate_finan_invest_no_of_transactions() {
		return corporate_finan_invest_no_of_transactions;
	}

	public BigDecimal getCorporate_finan_invest_amount() {
		return corporate_finan_invest_amount;
	}

	public BigDecimal getCorporate_direct_invest_no_of_transactions() {
		return corporate_direct_invest_no_of_transactions;
	}

	public BigDecimal getCorporate_direct_invest_amount() {
		return corporate_direct_invest_amount;
	}

	public BigDecimal getCorporate_service_no_of_transactions() {
		return corporate_service_no_of_transactions;
	}

	public BigDecimal getCorporate_service_invest_amount() {
		return corporate_service_invest_amount;
	}

	public BigDecimal getCorporate_trade_no_of_transactions() {
		return corporate_trade_no_of_transactions;
	}

	public BigDecimal getCorporate_trade_invest_amount() {
		return corporate_trade_invest_amount;
	}

	public BigDecimal getSme_finan_invest_no_of_transactions() {
		return sme_finan_invest_no_of_transactions;
	}

	public BigDecimal getSme_finan_invest_amount() {
		return sme_finan_invest_amount;
	}

	public BigDecimal getSme_direct_invest_no_of_transactions() {
		return sme_direct_invest_no_of_transactions;
	}

	public BigDecimal getSme_direct_invest_amount() {
		return sme_direct_invest_amount;
	}

	public BigDecimal getSme_service_no_of_transactions() {
		return sme_service_no_of_transactions;
	}

	public BigDecimal getSme_service_invest_amount() {
		return sme_service_invest_amount;
	}

	public BigDecimal getSme_trade_no_of_transactions() {
		return sme_trade_no_of_transactions;
	}

	public BigDecimal getSme_trade_invest_amount() {
		return sme_trade_invest_amount;
	}

	public BigDecimal getIndvidual_finan_invest_no_of_transactions() {
		return indvidual_finan_invest_no_of_transactions;
	}

	public BigDecimal getIndvidual_finan_invest_amount() {
		return indvidual_finan_invest_amount;
	}

	public BigDecimal getIndvidual_direct_invest_no_of_transactions() {
		return indvidual_direct_invest_no_of_transactions;
	}

	public BigDecimal getIndvidual_direct_invest_amount() {
		return indvidual_direct_invest_amount;
	}

	public BigDecimal getIndvidual_family_no_of_transactions() {
		return indvidual_family_no_of_transactions;
	}

	public BigDecimal getIndvidual_family_invest_amount() {
		return indvidual_family_invest_amount;
	}

	public BigDecimal getIndvidual_educate_no_of_transactions() {
		return indvidual_educate_no_of_transactions;
	}

	public BigDecimal getIndvidual_educate_invest_amount() {
		return indvidual_educate_invest_amount;
	}

	public BigDecimal getIndvidual_medical_no_of_transactions() {
		return indvidual_medical_no_of_transactions;
	}

	public BigDecimal getIndvidual_medical_invest_amount() {
		return indvidual_medical_invest_amount;
	}

	public BigDecimal getIndvidual_tour_no_of_transactions() {
		return indvidual_tour_no_of_transactions;
	}

	public BigDecimal getIndvidual_tour_invest_amount() {
		return indvidual_tour_invest_amount;
	}

	public BigDecimal getIndvidual_debt_no_of_transactions() {
		return indvidual_debt_no_of_transactions;
	}

	public BigDecimal getIndvidual_debt_invest_amount() {
		return indvidual_debt_invest_amount;
	}

	public BigDecimal getIndvidual_other_no_of_transactions() {
		return indvidual_other_no_of_transactions;
	}

	public BigDecimal getIndvidual_other_invest_amount() {
		return indvidual_other_invest_amount;
	}

	public BigDecimal getTransactions() {
		return transactions;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public BigDecimal getRem_govt_finan_invest_no_of_transactions_total() {
		return rem_govt_finan_invest_no_of_transactions_total;
	}

	public BigDecimal getRem_govt_finan_invest_amount_total() {
		return rem_govt_finan_invest_amount_total;
	}

	public BigDecimal getRem_govt_direct_invest_no_of_transactions_total() {
		return rem_govt_direct_invest_no_of_transactions_total;
	}

	public BigDecimal getRem_govt_direct_invest_amount_total() {
		return rem_govt_direct_invest_amount_total;
	}

	public BigDecimal getRem_govt_service_no_of_transactions_total() {
		return rem_govt_service_no_of_transactions_total;
	}

	public BigDecimal getRem_govt_service_invest_amount_total() {
		return rem_govt_service_invest_amount_total;
	}

	public BigDecimal getRem_govt_trade_no_of_transactions_total() {
		return rem_govt_trade_no_of_transactions_total;
	}

	public BigDecimal getRem_govt_trade_invest_amount_total() {
		return rem_govt_trade_invest_amount_total;
	}

	public BigDecimal getRem_reserve_finan_invest_no_of_transactions_total() {
		return rem_reserve_finan_invest_no_of_transactions_total;
	}

	public BigDecimal getRem_reserve_finan_invest_amount_total() {
		return rem_reserve_finan_invest_amount_total;
	}

	public BigDecimal getRem_reserve_direct_invest_no_of_transactions_total() {
		return rem_reserve_direct_invest_no_of_transactions_total;
	}

	public BigDecimal getRem_reserve_direct_invest_amount_total() {
		return rem_reserve_direct_invest_amount_total;
	}

	public BigDecimal getRem_reserve_service_no_of_transactions_total() {
		return rem_reserve_service_no_of_transactions_total;
	}

	public BigDecimal getRem_reserve_service_invest_amount_total() {
		return rem_reserve_service_invest_amount_total;
	}

	public BigDecimal getRem_reserve_trade_no_of_transactions_total() {
		return rem_reserve_trade_no_of_transactions_total;
	}

	public BigDecimal getRem_reserve_trade_invest_amount_total() {
		return rem_reserve_trade_invest_amount_total;
	}

	public BigDecimal getRem_gre_finan_invest_no_of_transactions_total() {
		return rem_gre_finan_invest_no_of_transactions_total;
	}

	public BigDecimal getRem_gre_finan_invest_amount_total() {
		return rem_gre_finan_invest_amount_total;
	}

	public BigDecimal getRem_gre_direct_invest_no_of_transactions_total() {
		return rem_gre_direct_invest_no_of_transactions_total;
	}

	public BigDecimal getRem_gre_direct_invest_amount_total() {
		return rem_gre_direct_invest_amount_total;
	}

	public BigDecimal getRem_gre_service_no_of_transactions_total() {
		return rem_gre_service_no_of_transactions_total;
	}

	public BigDecimal getRem_gre_service_invest_amount_total() {
		return rem_gre_service_invest_amount_total;
	}

	public BigDecimal getRem_gre_trade_no_of_transactions_total() {
		return rem_gre_trade_no_of_transactions_total;
	}

	public BigDecimal getRem_gre_trade_invest_amount_total() {
		return rem_gre_trade_invest_amount_total;
	}

	public BigDecimal getRem_corporate_finan_invest_no_of_transactions_total() {
		return rem_corporate_finan_invest_no_of_transactions_total;
	}

	public BigDecimal getRem_corporate_finan_invest_amount_total() {
		return rem_corporate_finan_invest_amount_total;
	}

	public BigDecimal getRem_corporate_direct_invest_no_of_transactions_total() {
		return rem_corporate_direct_invest_no_of_transactions_total;
	}

	public BigDecimal getRem_corporate_direct_invest_amount_total() {
		return rem_corporate_direct_invest_amount_total;
	}

	public BigDecimal getRem_corporate_service_no_of_transactions_total() {
		return rem_corporate_service_no_of_transactions_total;
	}

	public BigDecimal getRem_corporate_service_invest_amount_total() {
		return rem_corporate_service_invest_amount_total;
	}

	public BigDecimal getRem_corporate_trade_no_of_transactions_total() {
		return rem_corporate_trade_no_of_transactions_total;
	}

	public BigDecimal getRem_corporate_trade_invest_amount_total() {
		return rem_corporate_trade_invest_amount_total;
	}

	public BigDecimal getRem_sme_finan_invest_no_of_transactions_total() {
		return rem_sme_finan_invest_no_of_transactions_total;
	}

	public BigDecimal getRem_sme_finan_invest_amount_total() {
		return rem_sme_finan_invest_amount_total;
	}

	public BigDecimal getRem_sme_direct_invest_no_of_transactions_total() {
		return rem_sme_direct_invest_no_of_transactions_total;
	}

	public BigDecimal getRem_sme_direct_invest_amount_total() {
		return rem_sme_direct_invest_amount_total;
	}

	public BigDecimal getRem_sme_service_no_of_transactions_total() {
		return rem_sme_service_no_of_transactions_total;
	}

	public BigDecimal getRem_sme_service_invest_amount_total() {
		return rem_sme_service_invest_amount_total;
	}

	public BigDecimal getRem_sme_trade_no_of_transactions_total() {
		return rem_sme_trade_no_of_transactions_total;
	}

	public BigDecimal getRem_sme_trade_invest_amount_total() {
		return rem_sme_trade_invest_amount_total;
	}

	public BigDecimal getRem_indvidual_finan_invest_no_of_transactions_total() {
		return rem_indvidual_finan_invest_no_of_transactions_total;
	}

	public BigDecimal getRem_indvidual_finan_invest_amount_total() {
		return rem_indvidual_finan_invest_amount_total;
	}

	public BigDecimal getRem_indvidual_direct_invest_no_of_transactions_total() {
		return rem_indvidual_direct_invest_no_of_transactions_total;
	}

	public BigDecimal getRem_indvidual_direct_invest_amount_total() {
		return rem_indvidual_direct_invest_amount_total;
	}

	public BigDecimal getRem_indvidual_family_no_of_transactions_total() {
		return rem_indvidual_family_no_of_transactions_total;
	}

	public BigDecimal getRem_indvidual_family_invest_amount_total() {
		return rem_indvidual_family_invest_amount_total;
	}

	public BigDecimal getRem_indvidual_educate_no_of_transactions_total() {
		return rem_indvidual_educate_no_of_transactions_total;
	}

	public BigDecimal getRem_indvidual_educate_invest_amount_total() {
		return rem_indvidual_educate_invest_amount_total;
	}

	public BigDecimal getRem_indvidual_medical_no_of_transactions_total() {
		return rem_indvidual_medical_no_of_transactions_total;
	}

	public BigDecimal getRem_indvidual_medical_invest_amount_total() {
		return rem_indvidual_medical_invest_amount_total;
	}

	public BigDecimal getRem_indvidual_tour_no_of_transactions_total() {
		return rem_indvidual_tour_no_of_transactions_total;
	}

	public BigDecimal getRem_indvidual_tour_invest_amount_total() {
		return rem_indvidual_tour_invest_amount_total;
	}

	public BigDecimal getRem_indvidual_debt_no_of_transactions_total() {
		return rem_indvidual_debt_no_of_transactions_total;
	}

	public BigDecimal getRem_indvidual_debt_invest_amount_total() {
		return rem_indvidual_debt_invest_amount_total;
	}

	public BigDecimal getRem_indvidual_other_no_of_transactions_total() {
		return rem_indvidual_other_no_of_transactions_total;
	}

	public BigDecimal getRem_indvidual_other_invest_amount_total() {
		return rem_indvidual_other_invest_amount_total;
	}

	public BigDecimal getRem_transactions_total() {
		return rem_transactions_total;
	}

	public BigDecimal getRem_amount_total() {
		return rem_amount_total;
	}

	public Date getReport_date() {
		return report_date;
	}

	public Date getReport_from_date() {
		return report_from_date;
	}

	public Date getReport_to_date() {
		return report_to_date;
	}

	public String getEntity_flg() {
		return entity_flg;
	}

	public String getModify_flg() {
		return modify_flg;
	}

	public String getDel_flg() {
		return del_flg;
	}

	public String getReport_code() {
		return report_code;
	}

	public Date getReport_submit_date() {
		return report_submit_date;
	}

	public String getRow_label() {
		return row_label;
	}

	public String getRepdesc() {
		return repdesc;
	}

	public String getFrequency() {
		return frequency;
	}

	public void setCountry_break_down(String country_break_down) {
		this.country_break_down = country_break_down;
	}

	public void setRemaining_countries(String remaining_countries) {
		this.remaining_countries = remaining_countries;
	}

	public void setGovt_finan_invest_no_of_transactions(BigDecimal govt_finan_invest_no_of_transactions) {
		this.govt_finan_invest_no_of_transactions = govt_finan_invest_no_of_transactions;
	}

	public void setGovt_finan_invest_amount(BigDecimal govt_finan_invest_amount) {
		this.govt_finan_invest_amount = govt_finan_invest_amount;
	}

	public void setGovt_direct_invest_no_of_transactions(BigDecimal govt_direct_invest_no_of_transactions) {
		this.govt_direct_invest_no_of_transactions = govt_direct_invest_no_of_transactions;
	}

	public void setGovt_direct_invest_amount(BigDecimal govt_direct_invest_amount) {
		this.govt_direct_invest_amount = govt_direct_invest_amount;
	}

	public void setGovt_service_no_of_transactions(BigDecimal govt_service_no_of_transactions) {
		this.govt_service_no_of_transactions = govt_service_no_of_transactions;
	}

	public void setGovt_service_invest_amount(BigDecimal govt_service_invest_amount) {
		this.govt_service_invest_amount = govt_service_invest_amount;
	}

	public void setGovt_trade_no_of_transactions(BigDecimal govt_trade_no_of_transactions) {
		this.govt_trade_no_of_transactions = govt_trade_no_of_transactions;
	}

	public void setGovt_trade_invest_amount(BigDecimal govt_trade_invest_amount) {
		this.govt_trade_invest_amount = govt_trade_invest_amount;
	}

	public void setReserve_finan_invest_no_of_transactions(BigDecimal reserve_finan_invest_no_of_transactions) {
		this.reserve_finan_invest_no_of_transactions = reserve_finan_invest_no_of_transactions;
	}

	public void setReserve_finan_invest_amount(BigDecimal reserve_finan_invest_amount) {
		this.reserve_finan_invest_amount = reserve_finan_invest_amount;
	}

	public void setReserve_direct_invest_no_of_transactions(BigDecimal reserve_direct_invest_no_of_transactions) {
		this.reserve_direct_invest_no_of_transactions = reserve_direct_invest_no_of_transactions;
	}

	public void setReserve_direct_invest_amount(BigDecimal reserve_direct_invest_amount) {
		this.reserve_direct_invest_amount = reserve_direct_invest_amount;
	}

	public void setReserve_service_no_of_transactions(BigDecimal reserve_service_no_of_transactions) {
		this.reserve_service_no_of_transactions = reserve_service_no_of_transactions;
	}

	public void setReserve_service_invest_amount(BigDecimal reserve_service_invest_amount) {
		this.reserve_service_invest_amount = reserve_service_invest_amount;
	}

	public void setReserve_trade_no_of_transactions(BigDecimal reserve_trade_no_of_transactions) {
		this.reserve_trade_no_of_transactions = reserve_trade_no_of_transactions;
	}

	public void setReserve_trade_invest_amount(BigDecimal reserve_trade_invest_amount) {
		this.reserve_trade_invest_amount = reserve_trade_invest_amount;
	}

	public void setGre_finan_invest_no_of_transactions(BigDecimal gre_finan_invest_no_of_transactions) {
		this.gre_finan_invest_no_of_transactions = gre_finan_invest_no_of_transactions;
	}

	public void setGre_finan_invest_amount(BigDecimal gre_finan_invest_amount) {
		this.gre_finan_invest_amount = gre_finan_invest_amount;
	}

	public void setGre_direct_invest_no_of_transactions(BigDecimal gre_direct_invest_no_of_transactions) {
		this.gre_direct_invest_no_of_transactions = gre_direct_invest_no_of_transactions;
	}

	public void setGre_direct_invest_amount(BigDecimal gre_direct_invest_amount) {
		this.gre_direct_invest_amount = gre_direct_invest_amount;
	}

	public void setGre_service_no_of_transactions(BigDecimal gre_service_no_of_transactions) {
		this.gre_service_no_of_transactions = gre_service_no_of_transactions;
	}

	public void setGre_service_invest_amount(BigDecimal gre_service_invest_amount) {
		this.gre_service_invest_amount = gre_service_invest_amount;
	}

	public void setGre_trade_no_of_transactions(BigDecimal gre_trade_no_of_transactions) {
		this.gre_trade_no_of_transactions = gre_trade_no_of_transactions;
	}

	public void setGre_trade_invest_amount(BigDecimal gre_trade_invest_amount) {
		this.gre_trade_invest_amount = gre_trade_invest_amount;
	}

	public void setCorporate_finan_invest_no_of_transactions(BigDecimal corporate_finan_invest_no_of_transactions) {
		this.corporate_finan_invest_no_of_transactions = corporate_finan_invest_no_of_transactions;
	}

	public void setCorporate_finan_invest_amount(BigDecimal corporate_finan_invest_amount) {
		this.corporate_finan_invest_amount = corporate_finan_invest_amount;
	}

	public void setCorporate_direct_invest_no_of_transactions(BigDecimal corporate_direct_invest_no_of_transactions) {
		this.corporate_direct_invest_no_of_transactions = corporate_direct_invest_no_of_transactions;
	}

	public void setCorporate_direct_invest_amount(BigDecimal corporate_direct_invest_amount) {
		this.corporate_direct_invest_amount = corporate_direct_invest_amount;
	}

	public void setCorporate_service_no_of_transactions(BigDecimal corporate_service_no_of_transactions) {
		this.corporate_service_no_of_transactions = corporate_service_no_of_transactions;
	}

	public void setCorporate_service_invest_amount(BigDecimal corporate_service_invest_amount) {
		this.corporate_service_invest_amount = corporate_service_invest_amount;
	}

	public void setCorporate_trade_no_of_transactions(BigDecimal corporate_trade_no_of_transactions) {
		this.corporate_trade_no_of_transactions = corporate_trade_no_of_transactions;
	}

	public void setCorporate_trade_invest_amount(BigDecimal corporate_trade_invest_amount) {
		this.corporate_trade_invest_amount = corporate_trade_invest_amount;
	}

	public void setSme_finan_invest_no_of_transactions(BigDecimal sme_finan_invest_no_of_transactions) {
		this.sme_finan_invest_no_of_transactions = sme_finan_invest_no_of_transactions;
	}

	public void setSme_finan_invest_amount(BigDecimal sme_finan_invest_amount) {
		this.sme_finan_invest_amount = sme_finan_invest_amount;
	}

	public void setSme_direct_invest_no_of_transactions(BigDecimal sme_direct_invest_no_of_transactions) {
		this.sme_direct_invest_no_of_transactions = sme_direct_invest_no_of_transactions;
	}

	public void setSme_direct_invest_amount(BigDecimal sme_direct_invest_amount) {
		this.sme_direct_invest_amount = sme_direct_invest_amount;
	}

	public void setSme_service_no_of_transactions(BigDecimal sme_service_no_of_transactions) {
		this.sme_service_no_of_transactions = sme_service_no_of_transactions;
	}

	public void setSme_service_invest_amount(BigDecimal sme_service_invest_amount) {
		this.sme_service_invest_amount = sme_service_invest_amount;
	}

	public void setSme_trade_no_of_transactions(BigDecimal sme_trade_no_of_transactions) {
		this.sme_trade_no_of_transactions = sme_trade_no_of_transactions;
	}

	public void setSme_trade_invest_amount(BigDecimal sme_trade_invest_amount) {
		this.sme_trade_invest_amount = sme_trade_invest_amount;
	}

	public void setIndvidual_finan_invest_no_of_transactions(BigDecimal indvidual_finan_invest_no_of_transactions) {
		this.indvidual_finan_invest_no_of_transactions = indvidual_finan_invest_no_of_transactions;
	}

	public void setIndvidual_finan_invest_amount(BigDecimal indvidual_finan_invest_amount) {
		this.indvidual_finan_invest_amount = indvidual_finan_invest_amount;
	}

	public void setIndvidual_direct_invest_no_of_transactions(BigDecimal indvidual_direct_invest_no_of_transactions) {
		this.indvidual_direct_invest_no_of_transactions = indvidual_direct_invest_no_of_transactions;
	}

	public void setIndvidual_direct_invest_amount(BigDecimal indvidual_direct_invest_amount) {
		this.indvidual_direct_invest_amount = indvidual_direct_invest_amount;
	}

	public void setIndvidual_family_no_of_transactions(BigDecimal indvidual_family_no_of_transactions) {
		this.indvidual_family_no_of_transactions = indvidual_family_no_of_transactions;
	}

	public void setIndvidual_family_invest_amount(BigDecimal indvidual_family_invest_amount) {
		this.indvidual_family_invest_amount = indvidual_family_invest_amount;
	}

	public void setIndvidual_educate_no_of_transactions(BigDecimal indvidual_educate_no_of_transactions) {
		this.indvidual_educate_no_of_transactions = indvidual_educate_no_of_transactions;
	}

	public void setIndvidual_educate_invest_amount(BigDecimal indvidual_educate_invest_amount) {
		this.indvidual_educate_invest_amount = indvidual_educate_invest_amount;
	}

	public void setIndvidual_medical_no_of_transactions(BigDecimal indvidual_medical_no_of_transactions) {
		this.indvidual_medical_no_of_transactions = indvidual_medical_no_of_transactions;
	}

	public void setIndvidual_medical_invest_amount(BigDecimal indvidual_medical_invest_amount) {
		this.indvidual_medical_invest_amount = indvidual_medical_invest_amount;
	}

	public void setIndvidual_tour_no_of_transactions(BigDecimal indvidual_tour_no_of_transactions) {
		this.indvidual_tour_no_of_transactions = indvidual_tour_no_of_transactions;
	}

	public void setIndvidual_tour_invest_amount(BigDecimal indvidual_tour_invest_amount) {
		this.indvidual_tour_invest_amount = indvidual_tour_invest_amount;
	}

	public void setIndvidual_debt_no_of_transactions(BigDecimal indvidual_debt_no_of_transactions) {
		this.indvidual_debt_no_of_transactions = indvidual_debt_no_of_transactions;
	}

	public void setIndvidual_debt_invest_amount(BigDecimal indvidual_debt_invest_amount) {
		this.indvidual_debt_invest_amount = indvidual_debt_invest_amount;
	}

	public void setIndvidual_other_no_of_transactions(BigDecimal indvidual_other_no_of_transactions) {
		this.indvidual_other_no_of_transactions = indvidual_other_no_of_transactions;
	}

	public void setIndvidual_other_invest_amount(BigDecimal indvidual_other_invest_amount) {
		this.indvidual_other_invest_amount = indvidual_other_invest_amount;
	}

	public void setTransactions(BigDecimal transactions) {
		this.transactions = transactions;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public void setRem_govt_finan_invest_no_of_transactions_total(
			BigDecimal rem_govt_finan_invest_no_of_transactions_total) {
		this.rem_govt_finan_invest_no_of_transactions_total = rem_govt_finan_invest_no_of_transactions_total;
	}

	public void setRem_govt_finan_invest_amount_total(BigDecimal rem_govt_finan_invest_amount_total) {
		this.rem_govt_finan_invest_amount_total = rem_govt_finan_invest_amount_total;
	}

	public void setRem_govt_direct_invest_no_of_transactions_total(
			BigDecimal rem_govt_direct_invest_no_of_transactions_total) {
		this.rem_govt_direct_invest_no_of_transactions_total = rem_govt_direct_invest_no_of_transactions_total;
	}

	public void setRem_govt_direct_invest_amount_total(BigDecimal rem_govt_direct_invest_amount_total) {
		this.rem_govt_direct_invest_amount_total = rem_govt_direct_invest_amount_total;
	}

	public void setRem_govt_service_no_of_transactions_total(BigDecimal rem_govt_service_no_of_transactions_total) {
		this.rem_govt_service_no_of_transactions_total = rem_govt_service_no_of_transactions_total;
	}

	public void setRem_govt_service_invest_amount_total(BigDecimal rem_govt_service_invest_amount_total) {
		this.rem_govt_service_invest_amount_total = rem_govt_service_invest_amount_total;
	}

	public void setRem_govt_trade_no_of_transactions_total(BigDecimal rem_govt_trade_no_of_transactions_total) {
		this.rem_govt_trade_no_of_transactions_total = rem_govt_trade_no_of_transactions_total;
	}

	public void setRem_govt_trade_invest_amount_total(BigDecimal rem_govt_trade_invest_amount_total) {
		this.rem_govt_trade_invest_amount_total = rem_govt_trade_invest_amount_total;
	}

	public void setRem_reserve_finan_invest_no_of_transactions_total(
			BigDecimal rem_reserve_finan_invest_no_of_transactions_total) {
		this.rem_reserve_finan_invest_no_of_transactions_total = rem_reserve_finan_invest_no_of_transactions_total;
	}

	public void setRem_reserve_finan_invest_amount_total(BigDecimal rem_reserve_finan_invest_amount_total) {
		this.rem_reserve_finan_invest_amount_total = rem_reserve_finan_invest_amount_total;
	}

	public void setRem_reserve_direct_invest_no_of_transactions_total(
			BigDecimal rem_reserve_direct_invest_no_of_transactions_total) {
		this.rem_reserve_direct_invest_no_of_transactions_total = rem_reserve_direct_invest_no_of_transactions_total;
	}

	public void setRem_reserve_direct_invest_amount_total(BigDecimal rem_reserve_direct_invest_amount_total) {
		this.rem_reserve_direct_invest_amount_total = rem_reserve_direct_invest_amount_total;
	}

	public void setRem_reserve_service_no_of_transactions_total(
			BigDecimal rem_reserve_service_no_of_transactions_total) {
		this.rem_reserve_service_no_of_transactions_total = rem_reserve_service_no_of_transactions_total;
	}

	public void setRem_reserve_service_invest_amount_total(BigDecimal rem_reserve_service_invest_amount_total) {
		this.rem_reserve_service_invest_amount_total = rem_reserve_service_invest_amount_total;
	}

	public void setRem_reserve_trade_no_of_transactions_total(BigDecimal rem_reserve_trade_no_of_transactions_total) {
		this.rem_reserve_trade_no_of_transactions_total = rem_reserve_trade_no_of_transactions_total;
	}

	public void setRem_reserve_trade_invest_amount_total(BigDecimal rem_reserve_trade_invest_amount_total) {
		this.rem_reserve_trade_invest_amount_total = rem_reserve_trade_invest_amount_total;
	}

	public void setRem_gre_finan_invest_no_of_transactions_total(
			BigDecimal rem_gre_finan_invest_no_of_transactions_total) {
		this.rem_gre_finan_invest_no_of_transactions_total = rem_gre_finan_invest_no_of_transactions_total;
	}

	public void setRem_gre_finan_invest_amount_total(BigDecimal rem_gre_finan_invest_amount_total) {
		this.rem_gre_finan_invest_amount_total = rem_gre_finan_invest_amount_total;
	}

	public void setRem_gre_direct_invest_no_of_transactions_total(
			BigDecimal rem_gre_direct_invest_no_of_transactions_total) {
		this.rem_gre_direct_invest_no_of_transactions_total = rem_gre_direct_invest_no_of_transactions_total;
	}

	public void setRem_gre_direct_invest_amount_total(BigDecimal rem_gre_direct_invest_amount_total) {
		this.rem_gre_direct_invest_amount_total = rem_gre_direct_invest_amount_total;
	}

	public void setRem_gre_service_no_of_transactions_total(BigDecimal rem_gre_service_no_of_transactions_total) {
		this.rem_gre_service_no_of_transactions_total = rem_gre_service_no_of_transactions_total;
	}

	public void setRem_gre_service_invest_amount_total(BigDecimal rem_gre_service_invest_amount_total) {
		this.rem_gre_service_invest_amount_total = rem_gre_service_invest_amount_total;
	}

	public void setRem_gre_trade_no_of_transactions_total(BigDecimal rem_gre_trade_no_of_transactions_total) {
		this.rem_gre_trade_no_of_transactions_total = rem_gre_trade_no_of_transactions_total;
	}

	public void setRem_gre_trade_invest_amount_total(BigDecimal rem_gre_trade_invest_amount_total) {
		this.rem_gre_trade_invest_amount_total = rem_gre_trade_invest_amount_total;
	}

	public void setRem_corporate_finan_invest_no_of_transactions_total(
			BigDecimal rem_corporate_finan_invest_no_of_transactions_total) {
		this.rem_corporate_finan_invest_no_of_transactions_total = rem_corporate_finan_invest_no_of_transactions_total;
	}

	public void setRem_corporate_finan_invest_amount_total(BigDecimal rem_corporate_finan_invest_amount_total) {
		this.rem_corporate_finan_invest_amount_total = rem_corporate_finan_invest_amount_total;
	}

	public void setRem_corporate_direct_invest_no_of_transactions_total(
			BigDecimal rem_corporate_direct_invest_no_of_transactions_total) {
		this.rem_corporate_direct_invest_no_of_transactions_total = rem_corporate_direct_invest_no_of_transactions_total;
	}

	public void setRem_corporate_direct_invest_amount_total(BigDecimal rem_corporate_direct_invest_amount_total) {
		this.rem_corporate_direct_invest_amount_total = rem_corporate_direct_invest_amount_total;
	}

	public void setRem_corporate_service_no_of_transactions_total(
			BigDecimal rem_corporate_service_no_of_transactions_total) {
		this.rem_corporate_service_no_of_transactions_total = rem_corporate_service_no_of_transactions_total;
	}

	public void setRem_corporate_service_invest_amount_total(BigDecimal rem_corporate_service_invest_amount_total) {
		this.rem_corporate_service_invest_amount_total = rem_corporate_service_invest_amount_total;
	}

	public void setRem_corporate_trade_no_of_transactions_total(
			BigDecimal rem_corporate_trade_no_of_transactions_total) {
		this.rem_corporate_trade_no_of_transactions_total = rem_corporate_trade_no_of_transactions_total;
	}

	public void setRem_corporate_trade_invest_amount_total(BigDecimal rem_corporate_trade_invest_amount_total) {
		this.rem_corporate_trade_invest_amount_total = rem_corporate_trade_invest_amount_total;
	}

	public void setRem_sme_finan_invest_no_of_transactions_total(
			BigDecimal rem_sme_finan_invest_no_of_transactions_total) {
		this.rem_sme_finan_invest_no_of_transactions_total = rem_sme_finan_invest_no_of_transactions_total;
	}

	public void setRem_sme_finan_invest_amount_total(BigDecimal rem_sme_finan_invest_amount_total) {
		this.rem_sme_finan_invest_amount_total = rem_sme_finan_invest_amount_total;
	}

	public void setRem_sme_direct_invest_no_of_transactions_total(
			BigDecimal rem_sme_direct_invest_no_of_transactions_total) {
		this.rem_sme_direct_invest_no_of_transactions_total = rem_sme_direct_invest_no_of_transactions_total;
	}

	public void setRem_sme_direct_invest_amount_total(BigDecimal rem_sme_direct_invest_amount_total) {
		this.rem_sme_direct_invest_amount_total = rem_sme_direct_invest_amount_total;
	}

	public void setRem_sme_service_no_of_transactions_total(BigDecimal rem_sme_service_no_of_transactions_total) {
		this.rem_sme_service_no_of_transactions_total = rem_sme_service_no_of_transactions_total;
	}

	public void setRem_sme_service_invest_amount_total(BigDecimal rem_sme_service_invest_amount_total) {
		this.rem_sme_service_invest_amount_total = rem_sme_service_invest_amount_total;
	}

	public void setRem_sme_trade_no_of_transactions_total(BigDecimal rem_sme_trade_no_of_transactions_total) {
		this.rem_sme_trade_no_of_transactions_total = rem_sme_trade_no_of_transactions_total;
	}

	public void setRem_sme_trade_invest_amount_total(BigDecimal rem_sme_trade_invest_amount_total) {
		this.rem_sme_trade_invest_amount_total = rem_sme_trade_invest_amount_total;
	}

	public void setRem_indvidual_finan_invest_no_of_transactions_total(
			BigDecimal rem_indvidual_finan_invest_no_of_transactions_total) {
		this.rem_indvidual_finan_invest_no_of_transactions_total = rem_indvidual_finan_invest_no_of_transactions_total;
	}

	public void setRem_indvidual_finan_invest_amount_total(BigDecimal rem_indvidual_finan_invest_amount_total) {
		this.rem_indvidual_finan_invest_amount_total = rem_indvidual_finan_invest_amount_total;
	}

	public void setRem_indvidual_direct_invest_no_of_transactions_total(
			BigDecimal rem_indvidual_direct_invest_no_of_transactions_total) {
		this.rem_indvidual_direct_invest_no_of_transactions_total = rem_indvidual_direct_invest_no_of_transactions_total;
	}

	public void setRem_indvidual_direct_invest_amount_total(BigDecimal rem_indvidual_direct_invest_amount_total) {
		this.rem_indvidual_direct_invest_amount_total = rem_indvidual_direct_invest_amount_total;
	}

	public void setRem_indvidual_family_no_of_transactions_total(
			BigDecimal rem_indvidual_family_no_of_transactions_total) {
		this.rem_indvidual_family_no_of_transactions_total = rem_indvidual_family_no_of_transactions_total;
	}

	public void setRem_indvidual_family_invest_amount_total(BigDecimal rem_indvidual_family_invest_amount_total) {
		this.rem_indvidual_family_invest_amount_total = rem_indvidual_family_invest_amount_total;
	}

	public void setRem_indvidual_educate_no_of_transactions_total(
			BigDecimal rem_indvidual_educate_no_of_transactions_total) {
		this.rem_indvidual_educate_no_of_transactions_total = rem_indvidual_educate_no_of_transactions_total;
	}

	public void setRem_indvidual_educate_invest_amount_total(BigDecimal rem_indvidual_educate_invest_amount_total) {
		this.rem_indvidual_educate_invest_amount_total = rem_indvidual_educate_invest_amount_total;
	}

	public void setRem_indvidual_medical_no_of_transactions_total(
			BigDecimal rem_indvidual_medical_no_of_transactions_total) {
		this.rem_indvidual_medical_no_of_transactions_total = rem_indvidual_medical_no_of_transactions_total;
	}

	public void setRem_indvidual_medical_invest_amount_total(BigDecimal rem_indvidual_medical_invest_amount_total) {
		this.rem_indvidual_medical_invest_amount_total = rem_indvidual_medical_invest_amount_total;
	}

	public void setRem_indvidual_tour_no_of_transactions_total(BigDecimal rem_indvidual_tour_no_of_transactions_total) {
		this.rem_indvidual_tour_no_of_transactions_total = rem_indvidual_tour_no_of_transactions_total;
	}

	public void setRem_indvidual_tour_invest_amount_total(BigDecimal rem_indvidual_tour_invest_amount_total) {
		this.rem_indvidual_tour_invest_amount_total = rem_indvidual_tour_invest_amount_total;
	}

	public void setRem_indvidual_debt_no_of_transactions_total(BigDecimal rem_indvidual_debt_no_of_transactions_total) {
		this.rem_indvidual_debt_no_of_transactions_total = rem_indvidual_debt_no_of_transactions_total;
	}

	public void setRem_indvidual_debt_invest_amount_total(BigDecimal rem_indvidual_debt_invest_amount_total) {
		this.rem_indvidual_debt_invest_amount_total = rem_indvidual_debt_invest_amount_total;
	}

	public void setRem_indvidual_other_no_of_transactions_total(
			BigDecimal rem_indvidual_other_no_of_transactions_total) {
		this.rem_indvidual_other_no_of_transactions_total = rem_indvidual_other_no_of_transactions_total;
	}

	public void setRem_indvidual_other_invest_amount_total(BigDecimal rem_indvidual_other_invest_amount_total) {
		this.rem_indvidual_other_invest_amount_total = rem_indvidual_other_invest_amount_total;
	}

	public void setRem_transactions_total(BigDecimal rem_transactions_total) {
		this.rem_transactions_total = rem_transactions_total;
	}

	public void setRem_amount_total(BigDecimal rem_amount_total) {
		this.rem_amount_total = rem_amount_total;
	}

	public void setReport_date(Date report_date) {
		this.report_date = report_date;
	}

	public void setReport_from_date(Date report_from_date) {
		this.report_from_date = report_from_date;
	}

	public void setReport_to_date(Date report_to_date) {
		this.report_to_date = report_to_date;
	}

	public void setEntity_flg(String entity_flg) {
		this.entity_flg = entity_flg;
	}

	public void setModify_flg(String modify_flg) {
		this.modify_flg = modify_flg;
	}

	public void setDel_flg(String del_flg) {
		this.del_flg = del_flg;
	}

	public void setReport_code(String report_code) {
		this.report_code = report_code;
	}

	public void setReport_submit_date(Date report_submit_date) {
		this.report_submit_date = report_submit_date;
	}

	public void setRow_label(String row_label) {
		this.row_label = row_label;
	}

	public void setRepdesc(String repdesc) {
		this.repdesc = repdesc;
	}

	public void setFrequency(String frequency) {
		this.frequency = frequency;
	}

	public BRF094_SUMMARYENTITY6() {
		super();
		// TODO Auto-generated constructor stub
	}
}
