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
@Table(name="BRF156_SUMMARYTABLE")

public class BRF156reportentity {
	private BigDecimal	r1_sno;
	private Date	r1_deal;
	private BigDecimal	r1_usd_amount;
	private BigDecimal	r1_aed_amount;
	private Date	r1_ddm;
	private String	r1_country;
	@Id
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date	report_date;
	private Date	report_from_date;
	private Date	report_to_date;
	private String	entity_flg;
	private String	modify_flg;
	private String	del_flg;
	private String	report_code;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date	deal    ;
	private BigDecimal	usd_amount ;
	private BigDecimal	aed_amount   ;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date	ddm;
	private String	country ;
	public BigDecimal getR1_sno() {
		return r1_sno;
	}
	public void setR1_sno(BigDecimal r1_sno) {
		this.r1_sno = r1_sno;
	}
	public Date getR1_deal() {
		return r1_deal;
	}
	public void setR1_deal(Date r1_deal) {
		this.r1_deal = r1_deal;
	}
	public BigDecimal getR1_usd_amount() {
		return r1_usd_amount;
	}
	public void setR1_usd_amount(BigDecimal r1_usd_amount) {
		this.r1_usd_amount = r1_usd_amount;
	}
	public BigDecimal getR1_aed_amount() {
		return r1_aed_amount;
	}
	public void setR1_aed_amount(BigDecimal r1_aed_amount) {
		this.r1_aed_amount = r1_aed_amount;
	}
	public Date getR1_ddm() {
		return r1_ddm;
	}
	public void setR1_ddm(Date r1_ddm) {
		this.r1_ddm = r1_ddm;
	}
	public String getR1_country() {
		return r1_country;
	}
	public void setR1_country(String r1_country) {
		this.r1_country = r1_country;
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
	public Date getDeal() {
		return deal;
	}
	public void setDeal(Date deal) {
		this.deal = deal;
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
	public Date getDdm() {
		return ddm;
	}
	public void setDdm(Date ddm) {
		this.ddm = ddm;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public BRF156reportentity() {
		super();
		// TODO Auto-generated constructor stub
	}
	    
	

}
