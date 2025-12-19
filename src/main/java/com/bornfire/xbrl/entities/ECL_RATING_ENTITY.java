package com.bornfire.xbrl.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="ECL_RATING_DATA")

public class ECL_RATING_ENTITY {

	@Id
	private String	customerid;
	private String	final_rating;
	private String	new_rating;
	private String	old_rating;
	private Date	report_date;
	public String getCustomerid() {
		return customerid;
	}
	public void setCustomerid(String customerid) {
		this.customerid = customerid;
	}
	public String getFinal_rating() {
		return final_rating;
	}
	public void setFinal_rating(String final_rating) {
		this.final_rating = final_rating;
	}
	public String getNew_rating() {
		return new_rating;
	}
	public void setNew_rating(String new_rating) {
		this.new_rating = new_rating;
	}
	public String getOld_rating() {
		return old_rating;
	}
	public void setOld_rating(String old_rating) {
		this.old_rating = old_rating;
	}
	public Date getReport_date() {
		return report_date;
	}
	public void setReport_date(Date report_date) {
		this.report_date = report_date;
	}
	public ECL_RATING_ENTITY() {
		super();
		// TODO Auto-generated constructor stub
	}
}