package com.bornfire.xbrl.entities;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="ECL_WATCHLIST_TABLE")
public class ECL_WATCHLIST_ENTITY {
	@Id
	private BigDecimal	sno;
	private String	branch;
	private String	customer_id;
	private String	rbr_cinno;
	private String	customername;
	private BigDecimal	osin_aed;
	private BigDecimal	days_past_due;
	private BigDecimal	overdue_amtinaed;
	private String	rbr_classification;
	private Date	overdue_from;
	private BigDecimal	diff_in_days;
	private BigDecimal	sep_30_2023;
	private String	watchlist;
	private Date	report_date;
	public BigDecimal getSno() {
		return sno;
	}
	public void setSno(BigDecimal sno) {
		this.sno = sno;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	public String getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(String customer_id) {
		this.customer_id = customer_id;
	}
	public String getRbr_cinno() {
		return rbr_cinno;
	}
	public void setRbr_cinno(String rbr_cinno) {
		this.rbr_cinno = rbr_cinno;
	}
	public String getCustomername() {
		return customername;
	}
	public void setCustomername(String customername) {
		this.customername = customername;
	}
	public BigDecimal getOsin_aed() {
		return osin_aed;
	}
	public void setOsin_aed(BigDecimal osin_aed) {
		this.osin_aed = osin_aed;
	}
	public BigDecimal getDays_past_due() {
		return days_past_due;
	}
	public void setDays_past_due(BigDecimal days_past_due) {
		this.days_past_due = days_past_due;
	}
	public BigDecimal getOverdue_amtinaed() {
		return overdue_amtinaed;
	}
	public void setOverdue_amtinaed(BigDecimal overdue_amtinaed) {
		this.overdue_amtinaed = overdue_amtinaed;
	}
	public String getRbr_classification() {
		return rbr_classification;
	}
	public void setRbr_classification(String rbr_classification) {
		this.rbr_classification = rbr_classification;
	}
	public Date getOverdue_from() {
		return overdue_from;
	}
	public void setOverdue_from(Date overdue_from) {
		this.overdue_from = overdue_from;
	}
	public BigDecimal getDiff_in_days() {
		return diff_in_days;
	}
	public void setDiff_in_days(BigDecimal diff_in_days) {
		this.diff_in_days = diff_in_days;
	}
	public BigDecimal getSep_30_2023() {
		return sep_30_2023;
	}
	public void setSep_30_2023(BigDecimal sep_30_2023) {
		this.sep_30_2023 = sep_30_2023;
	}
	public String getWatchlist() {
		return watchlist;
	}
	public void setWatchlist(String watchlist) {
		this.watchlist = watchlist;
	}
	public Date getReport_date() {
		return report_date;
	}
	public void setReport_date(Date report_date) {
		this.report_date = report_date;
	}
	public ECL_WATCHLIST_ENTITY() {
		super();
		// TODO Auto-generated constructor stub
	}
}