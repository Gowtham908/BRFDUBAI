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
@Table(name="BRF155_SUMMARYTABLE")
public class BRF155_ENTITY {
	private Date	deal_date;
	private BigDecimal	buy_usd;
	private BigDecimal	sell_aed;
	private BigDecimal	buy_aed;
	private BigDecimal	sell_usd;
	private String	ddm;
	@Id
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date	report_date;
	private String	report_label_1;
	private String	report_addl_criteria_1;
	private Date	report_from_date;
	private Date	report_to_date;
	private String	entity_flg;
	private String	modify_flg;
	private String	del_flg;
	private String	report_code;
	private Date	report_submit_date;
	public Date getDeal_date() {
		return deal_date;
	}
	public void setDeal_date(Date deal_date) {
		this.deal_date = deal_date;
	}
	public BigDecimal getBuy_usd() {
		return buy_usd;
	}
	public void setBuy_usd(BigDecimal buy_usd) {
		this.buy_usd = buy_usd;
	}
	public BigDecimal getSell_aed() {
		return sell_aed;
	}
	public void setSell_aed(BigDecimal sell_aed) {
		this.sell_aed = sell_aed;
	}
	public BigDecimal getBuy_aed() {
		return buy_aed;
	}
	public void setBuy_aed(BigDecimal buy_aed) {
		this.buy_aed = buy_aed;
	}
	public BigDecimal getSell_usd() {
		return sell_usd;
	}
	public void setSell_usd(BigDecimal sell_usd) {
		this.sell_usd = sell_usd;
	}
	public String getDdm() {
		return ddm;
	}
	public void setDdm(String ddm) {
		this.ddm = ddm;
	}
	public Date getReport_date() {
		return report_date;
	}
	public void setReport_date(Date report_date) {
		this.report_date = report_date;
	}
	public String getReport_label_1() {
		return report_label_1;
	}
	public void setReport_label_1(String report_label_1) {
		this.report_label_1 = report_label_1;
	}
	public String getReport_addl_criteria_1() {
		return report_addl_criteria_1;
	}
	public void setReport_addl_criteria_1(String report_addl_criteria_1) {
		this.report_addl_criteria_1 = report_addl_criteria_1;
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
	@Override
	public String toString() {
		return "BRF155_ENTITY [deal_date=" + deal_date + ", buy_usd=" + buy_usd + ", sell_aed=" + sell_aed
				+ ", buy_aed=" + buy_aed + ", sell_usd=" + sell_usd + ", ddm=" + ddm + ", report_date=" + report_date
				+ ", report_label_1=" + report_label_1 + ", report_addl_criteria_1=" + report_addl_criteria_1
				+ ", report_from_date=" + report_from_date + ", report_to_date=" + report_to_date + ", entity_flg="
				+ entity_flg + ", modify_flg=" + modify_flg + ", del_flg=" + del_flg + ", report_code=" + report_code
				+ ", report_submit_date=" + report_submit_date + ", getDeal_date()=" + getDeal_date()
				+ ", getBuy_usd()=" + getBuy_usd() + ", getSell_aed()=" + getSell_aed() + ", getBuy_aed()="
				+ getBuy_aed() + ", getSell_usd()=" + getSell_usd() + ", getDdm()=" + getDdm() + ", getReport_date()="
				+ getReport_date() + ", getReport_label_1()=" + getReport_label_1() + ", getReport_addl_criteria_1()="
				+ getReport_addl_criteria_1() + ", getReport_from_date()=" + getReport_from_date()
				+ ", getReport_to_date()=" + getReport_to_date() + ", getEntity_flg()=" + getEntity_flg()
				+ ", getModify_flg()=" + getModify_flg() + ", getDel_flg()=" + getDel_flg() + ", getReport_code()="
				+ getReport_code() + ", getReport_submit_date()=" + getReport_submit_date() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	public BRF155_ENTITY(Date deal_date, BigDecimal buy_usd, BigDecimal sell_aed, BigDecimal buy_aed,
			BigDecimal sell_usd, String ddm, Date report_date, String report_label_1, String report_addl_criteria_1,
			Date report_from_date, Date report_to_date, String entity_flg, String modify_flg, String del_flg,
			String report_code, Date report_submit_date) {
		super();
		this.deal_date = deal_date;
		this.buy_usd = buy_usd;
		this.sell_aed = sell_aed;
		this.buy_aed = buy_aed;
		this.sell_usd = sell_usd;
		this.ddm = ddm;
		this.report_date = report_date;
		this.report_label_1 = report_label_1;
		this.report_addl_criteria_1 = report_addl_criteria_1;
		this.report_from_date = report_from_date;
		this.report_to_date = report_to_date;
		this.entity_flg = entity_flg;
		this.modify_flg = modify_flg;
		this.del_flg = del_flg;
		this.report_code = report_code;
		this.report_submit_date = report_submit_date;
	}
	public BRF155_ENTITY() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
