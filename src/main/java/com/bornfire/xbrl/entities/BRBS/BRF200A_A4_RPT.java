package com.bornfire.xbrl.entities.BRBS;
import java.math.BigDecimal;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="BRF200D_SUMMARYTABLE")
public class BRF200A_A4_RPT {
	
	@Id
	private Date	report_date;
	private String	r136_income_aed;
	private String	r136_dbr;
	private BigDecimal	r136_borrowers_less_than_30;
	private BigDecimal	r136_loan_amt_less_than_30;
	private BigDecimal	r136_npl_borrowers_less_than_30;
	private BigDecimal	r136_npl_amt_less_than_30;
	private BigDecimal	r136_borrowers_30_45_years;
	private BigDecimal	r136_loan_amt_30_45_years;
	private BigDecimal	r136_npl_borrowers_30_45_years;
	private BigDecimal	r136_npl_amt_30_45_years;
	private BigDecimal	r136_borrowers_45_60_years;
	private BigDecimal	r136_loan_amt_45_60_years;
	private BigDecimal	r136_npl_borrowers_45_60_years;
	private BigDecimal	r136_npl_amt_45_60_years;
	private BigDecimal	r136_borrowers_above_60_years;
	private BigDecimal	r136_loan_amt_above_60_years;
	private BigDecimal	r136_npl_borrowers_above_60_years;
	private BigDecimal	r136_npl_amt_above_60_years;
	private BigDecimal	r136_borrowers_female_borrowers;
	private BigDecimal	r136_loan_amt_female_borrowers;
	private BigDecimal	r136_npl_borrowers_female_borrowers;
	private BigDecimal	r136_npl_amt_female_borrowers;

	private String	repdesc;
	private String	frequency;
	public Date getReport_date() {
		return report_date;
	}
	public void setReport_date(Date report_date) {
		this.report_date = report_date;
	}
	public String getR136_income_aed() {
		return r136_income_aed;
	}
	public void setR136_income_aed(String r136_income_aed) {
		this.r136_income_aed = r136_income_aed;
	}
	public String getR136_dbr() {
		return r136_dbr;
	}
	public void setR136_dbr(String r136_dbr) {
		this.r136_dbr = r136_dbr;
	}
	public BigDecimal getR136_borrowers_less_than_30() {
		return r136_borrowers_less_than_30;
	}
	public void setR136_borrowers_less_than_30(BigDecimal r136_borrowers_less_than_30) {
		this.r136_borrowers_less_than_30 = r136_borrowers_less_than_30;
	}
	public BigDecimal getR136_loan_amt_less_than_30() {
		return r136_loan_amt_less_than_30;
	}
	public void setR136_loan_amt_less_than_30(BigDecimal r136_loan_amt_less_than_30) {
		this.r136_loan_amt_less_than_30 = r136_loan_amt_less_than_30;
	}
	public BigDecimal getR136_npl_borrowers_less_than_30() {
		return r136_npl_borrowers_less_than_30;
	}
	public void setR136_npl_borrowers_less_than_30(BigDecimal r136_npl_borrowers_less_than_30) {
		this.r136_npl_borrowers_less_than_30 = r136_npl_borrowers_less_than_30;
	}
	public BigDecimal getR136_npl_amt_less_than_30() {
		return r136_npl_amt_less_than_30;
	}
	public void setR136_npl_amt_less_than_30(BigDecimal r136_npl_amt_less_than_30) {
		this.r136_npl_amt_less_than_30 = r136_npl_amt_less_than_30;
	}
	public BigDecimal getR136_borrowers_30_45_years() {
		return r136_borrowers_30_45_years;
	}
	public void setR136_borrowers_30_45_years(BigDecimal r136_borrowers_30_45_years) {
		this.r136_borrowers_30_45_years = r136_borrowers_30_45_years;
	}
	public BigDecimal getR136_loan_amt_30_45_years() {
		return r136_loan_amt_30_45_years;
	}
	public void setR136_loan_amt_30_45_years(BigDecimal r136_loan_amt_30_45_years) {
		this.r136_loan_amt_30_45_years = r136_loan_amt_30_45_years;
	}
	public BigDecimal getR136_npl_borrowers_30_45_years() {
		return r136_npl_borrowers_30_45_years;
	}
	public void setR136_npl_borrowers_30_45_years(BigDecimal r136_npl_borrowers_30_45_years) {
		this.r136_npl_borrowers_30_45_years = r136_npl_borrowers_30_45_years;
	}
	public BigDecimal getR136_npl_amt_30_45_years() {
		return r136_npl_amt_30_45_years;
	}
	public void setR136_npl_amt_30_45_years(BigDecimal r136_npl_amt_30_45_years) {
		this.r136_npl_amt_30_45_years = r136_npl_amt_30_45_years;
	}
	public BigDecimal getR136_borrowers_45_60_years() {
		return r136_borrowers_45_60_years;
	}
	public void setR136_borrowers_45_60_years(BigDecimal r136_borrowers_45_60_years) {
		this.r136_borrowers_45_60_years = r136_borrowers_45_60_years;
	}
	public BigDecimal getR136_loan_amt_45_60_years() {
		return r136_loan_amt_45_60_years;
	}
	public void setR136_loan_amt_45_60_years(BigDecimal r136_loan_amt_45_60_years) {
		this.r136_loan_amt_45_60_years = r136_loan_amt_45_60_years;
	}
	public BigDecimal getR136_npl_borrowers_45_60_years() {
		return r136_npl_borrowers_45_60_years;
	}
	public void setR136_npl_borrowers_45_60_years(BigDecimal r136_npl_borrowers_45_60_years) {
		this.r136_npl_borrowers_45_60_years = r136_npl_borrowers_45_60_years;
	}
	public BigDecimal getR136_npl_amt_45_60_years() {
		return r136_npl_amt_45_60_years;
	}
	public void setR136_npl_amt_45_60_years(BigDecimal r136_npl_amt_45_60_years) {
		this.r136_npl_amt_45_60_years = r136_npl_amt_45_60_years;
	}
	public BigDecimal getR136_borrowers_above_60_years() {
		return r136_borrowers_above_60_years;
	}
	public void setR136_borrowers_above_60_years(BigDecimal r136_borrowers_above_60_years) {
		this.r136_borrowers_above_60_years = r136_borrowers_above_60_years;
	}
	public BigDecimal getR136_loan_amt_above_60_years() {
		return r136_loan_amt_above_60_years;
	}
	public void setR136_loan_amt_above_60_years(BigDecimal r136_loan_amt_above_60_years) {
		this.r136_loan_amt_above_60_years = r136_loan_amt_above_60_years;
	}
	public BigDecimal getR136_npl_borrowers_above_60_years() {
		return r136_npl_borrowers_above_60_years;
	}
	public void setR136_npl_borrowers_above_60_years(BigDecimal r136_npl_borrowers_above_60_years) {
		this.r136_npl_borrowers_above_60_years = r136_npl_borrowers_above_60_years;
	}
	public BigDecimal getR136_npl_amt_above_60_years() {
		return r136_npl_amt_above_60_years;
	}
	public void setR136_npl_amt_above_60_years(BigDecimal r136_npl_amt_above_60_years) {
		this.r136_npl_amt_above_60_years = r136_npl_amt_above_60_years;
	}
	public BigDecimal getR136_borrowers_female_borrowers() {
		return r136_borrowers_female_borrowers;
	}
	public void setR136_borrowers_female_borrowers(BigDecimal r136_borrowers_female_borrowers) {
		this.r136_borrowers_female_borrowers = r136_borrowers_female_borrowers;
	}
	public BigDecimal getR136_loan_amt_female_borrowers() {
		return r136_loan_amt_female_borrowers;
	}
	public void setR136_loan_amt_female_borrowers(BigDecimal r136_loan_amt_female_borrowers) {
		this.r136_loan_amt_female_borrowers = r136_loan_amt_female_borrowers;
	}
	public BigDecimal getR136_npl_borrowers_female_borrowers() {
		return r136_npl_borrowers_female_borrowers;
	}
	public void setR136_npl_borrowers_female_borrowers(BigDecimal r136_npl_borrowers_female_borrowers) {
		this.r136_npl_borrowers_female_borrowers = r136_npl_borrowers_female_borrowers;
	}
	public BigDecimal getR136_npl_amt_female_borrowers() {
		return r136_npl_amt_female_borrowers;
	}
	public void setR136_npl_amt_female_borrowers(BigDecimal r136_npl_amt_female_borrowers) {
		this.r136_npl_amt_female_borrowers = r136_npl_amt_female_borrowers;
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
	public BRF200A_A4_RPT() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}