package com.bornfire.xbrl.entities.BRBS;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="BRF87_SUMMARYTABLE")
public class BRF87_ENTITY {
	private BigDecimal  r1_no_of_loans     ;
	private BigDecimal  r1_balance_os     ;
	private BigDecimal  r2_no_of_loans     ;
	private BigDecimal  r2_balance_os     ;
	private BigDecimal  r3_no_of_loans     ;
	private BigDecimal  r3_balance_os     ;
	private BigDecimal  r4_no_of_loans     ;
	private BigDecimal  r4_balance_os     ;
 	@Id
	private Date	report_date;
	private Date	report_from_date;
	private Date	report_to_date;
	private Date	report_submit_date;
	private String	entity_flg;
	private String	modify_flg;
	private String	del_flg;
	private String	report_code;
	private String	repdesc;
	private String	frequency;
	public BigDecimal getR1_no_of_loans() {
		return r1_no_of_loans;
	}
	public void setR1_no_of_loans(BigDecimal r1_no_of_loans) {
		this.r1_no_of_loans = r1_no_of_loans;
	}
	public BigDecimal getR1_balance_os() {
		return r1_balance_os;
	}
	public void setR1_balance_os(BigDecimal r1_balance_os) {
		this.r1_balance_os = r1_balance_os;
	}
	public BigDecimal getR2_no_of_loans() {
		return r2_no_of_loans;
	}
	public void setR2_no_of_loans(BigDecimal r2_no_of_loans) {
		this.r2_no_of_loans = r2_no_of_loans;
	}
	public BigDecimal getR2_balance_os() {
		return r2_balance_os;
	}
	public void setR2_balance_os(BigDecimal r2_balance_os) {
		this.r2_balance_os = r2_balance_os;
	}
	public BigDecimal getR3_no_of_loans() {
		return r3_no_of_loans;
	}
	public void setR3_no_of_loans(BigDecimal r3_no_of_loans) {
		this.r3_no_of_loans = r3_no_of_loans;
	}
	public BigDecimal getR3_balance_os() {
		return r3_balance_os;
	}
	public void setR3_balance_os(BigDecimal r3_balance_os) {
		this.r3_balance_os = r3_balance_os;
	}
	public BigDecimal getR4_no_of_loans() {
		return r4_no_of_loans;
	}
	public void setR4_no_of_loans(BigDecimal r4_no_of_loans) {
		this.r4_no_of_loans = r4_no_of_loans;
	}
	public BigDecimal getR4_balance_os() {
		return r4_balance_os;
	}
	public void setR4_balance_os(BigDecimal r4_balance_os) {
		this.r4_balance_os = r4_balance_os;
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
	public Date getReport_submit_date() {
		return report_submit_date;
	}
	public void setReport_submit_date(Date report_submit_date) {
		this.report_submit_date = report_submit_date;
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
	public BRF87_ENTITY() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}