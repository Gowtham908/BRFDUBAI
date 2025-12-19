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
@Table(name="CV1_T1")

public class B13Reportentity {
	private String	r1_col1;
	private BigDecimal	r1_col2;
	private BigDecimal	r1_col3;
	private BigDecimal	r1_col4;
	private BigDecimal	r1_col5;
	private BigDecimal	r1_col6;
	private String	r2_col1;
	private BigDecimal	r2_col2;
	private BigDecimal	r2_col3;
	private BigDecimal	r2_col4;
	private BigDecimal	r2_col5;
	private BigDecimal	r2_col6;
	
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
	private Date	report_submit_date;
	public String getR1_col1() {
		return r1_col1;
	}
	public void setR1_col1(String r1_col1) {
		this.r1_col1 = r1_col1;
	}
	public BigDecimal getR1_col2() {
		return r1_col2;
	}
	public void setR1_col2(BigDecimal r1_col2) {
		this.r1_col2 = r1_col2;
	}
	public BigDecimal getR1_col3() {
		return r1_col3;
	}
	public void setR1_col3(BigDecimal r1_col3) {
		this.r1_col3 = r1_col3;
	}
	public BigDecimal getR1_col4() {
		return r1_col4;
	}
	public void setR1_col4(BigDecimal r1_col4) {
		this.r1_col4 = r1_col4;
	}
	public BigDecimal getR1_col5() {
		return r1_col5;
	}
	public void setR1_col5(BigDecimal r1_col5) {
		this.r1_col5 = r1_col5;
	}
	public BigDecimal getR1_col6() {
		return r1_col6;
	}
	public void setR1_col6(BigDecimal r1_col6) {
		this.r1_col6 = r1_col6;
	}
	public String getR2_col1() {
		return r2_col1;
	}
	public void setR2_col1(String r2_col1) {
		this.r2_col1 = r2_col1;
	}
	public BigDecimal getR2_col2() {
		return r2_col2;
	}
	public void setR2_col2(BigDecimal r2_col2) {
		this.r2_col2 = r2_col2;
	}
	public BigDecimal getR2_col3() {
		return r2_col3;
	}
	public void setR2_col3(BigDecimal r2_col3) {
		this.r2_col3 = r2_col3;
	}
	public BigDecimal getR2_col4() {
		return r2_col4;
	}
	public void setR2_col4(BigDecimal r2_col4) {
		this.r2_col4 = r2_col4;
	}
	public BigDecimal getR2_col5() {
		return r2_col5;
	}
	public void setR2_col5(BigDecimal r2_col5) {
		this.r2_col5 = r2_col5;
	}
	public BigDecimal getR2_col6() {
		return r2_col6;
	}
	public void setR2_col6(BigDecimal r2_col6) {
		this.r2_col6 = r2_col6;
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
	public B13Reportentity() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	}