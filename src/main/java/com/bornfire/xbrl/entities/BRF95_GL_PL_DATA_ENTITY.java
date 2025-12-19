package com.bornfire.xbrl.entities;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="BRF95_GL_PL_DATA_TABLE")
public class BRF95_GL_PL_DATA_ENTITY {
	@Id
	private String	sch;
	private String	particulers;
	private String	gl_code;
	private BigDecimal	aed_full_figure;
	private BigDecimal	inr_full_figure;
	
	private Date	report_date;
	public String getSch() {
		return sch;
	}
	public void setSch(String sch) {
		this.sch = sch;
	}
	public String getParticulers() {
		return particulers;
	}
	public void setParticulers(String particulers) {
		this.particulers = particulers;
	}
	public String getGl_code() {
		return gl_code;
	}
	public void setGl_code(String gl_code) {
		this.gl_code = gl_code;
	}
	public BigDecimal getAed_full_figure() {
		return aed_full_figure;
	}
	public void setAed_full_figure(BigDecimal aed_full_figure) {
		this.aed_full_figure = aed_full_figure;
	}
	public BigDecimal getInr_full_figure() {
		return inr_full_figure;
	}
	public void setInr_full_figure(BigDecimal inr_full_figure) {
		this.inr_full_figure = inr_full_figure;
	}
	public Date getReport_date() {
		return report_date;
	}
	public void setReport_date(Date report_date) {
		this.report_date = report_date;
	}
	public BRF95_GL_PL_DATA_ENTITY(String sch, String particulers, String gl_code, BigDecimal aed_full_figure,
			BigDecimal inr_full_figure, Date report_date) {
		super();
		this.sch = sch;
		this.particulers = particulers;
		this.gl_code = gl_code;
		this.aed_full_figure = aed_full_figure;
		this.inr_full_figure = inr_full_figure;
		this.report_date = report_date;
	}
	public BRF95_GL_PL_DATA_ENTITY() {
		super();
		// TODO Auto-generated constructor stub
	}


	
	
	

}
