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
@Table(name = "BRF43B_SUMMARYTABLE")
public class BRF43B_ENTITY {
	private String name;
	private String categorya;
	private String categoryb;
	private BigDecimal funded;
	private BigDecimal unfunded;
	private BigDecimal unused_limit;
	private BigDecimal total_exposure;
	private String security_provided;
	private String row_label;
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
	private String repdesc;
	private String frequency;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategorya() {
		return categorya;
	}

	public void setCategorya(String categorya) {
		this.categorya = categorya;
	}

	public String getCategoryb() {
		return categoryb;
	}

	public void setCategoryb(String categoryb) {
		this.categoryb = categoryb;
	}

	public BigDecimal getFunded() {
		return funded;
	}

	public void setFunded(BigDecimal funded) {
		this.funded = funded;
	}

	public BigDecimal getUnfunded() {
		return unfunded;
	}

	public void setUnfunded(BigDecimal unfunded) {
		this.unfunded = unfunded;
	}

	public BigDecimal getUnused_limit() {
		return unused_limit;
	}

	public void setUnused_limit(BigDecimal unused_limit) {
		this.unused_limit = unused_limit;
	}

	public BigDecimal getTotal_exposure() {
		return total_exposure;
	}

	public void setTotal_exposure(BigDecimal total_exposure) {
		this.total_exposure = total_exposure;
	}

	public String getSecurity_provided() {
		return security_provided;
	}

	public void setSecurity_provided(String security_provided) {
		this.security_provided = security_provided;
	}

	public String getRow_label() {
		return row_label;
	}

	public void setRow_label(String row_label) {
		this.row_label = row_label;
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

	@Override
	public String toString() {
		return "BRF43B_ENTITY [name=" + name + ", categorya=" + categorya + ", categoryb=" + categoryb + ", funded="
				+ funded + ", unfunded=" + unfunded + ", unused_limit=" + unused_limit + ", total_exposure="
				+ total_exposure + ", security_provided=" + security_provided + ", row_label=" + row_label
				+ ", report_date=" + report_date + ", report_from_date=" + report_from_date + ", report_to_date="
				+ report_to_date + ", entity_flg=" + entity_flg + ", modify_flg=" + modify_flg + ", del_flg=" + del_flg
				+ ", report_code=" + report_code + ", report_submit_date=" + report_submit_date + ", repdesc=" + repdesc
				+ ", frequency=" + frequency + ", getName()=" + getName() + ", getCategorya()=" + getCategorya()
				+ ", getCategoryb()=" + getCategoryb() + ", getFunded()=" + getFunded() + ", getUnfunded()="
				+ getUnfunded() + ", getUnused_limit()=" + getUnused_limit() + ", getTotal_exposure()="
				+ getTotal_exposure() + ", getSecurity_provided()=" + getSecurity_provided() + ", getRow_label()="
				+ getRow_label() + ", getReport_date()=" + getReport_date() + ", getReport_from_date()="
				+ getReport_from_date() + ", getReport_to_date()=" + getReport_to_date() + ", getEntity_flg()="
				+ getEntity_flg() + ", getModify_flg()=" + getModify_flg() + ", getDel_flg()=" + getDel_flg()
				+ ", getReport_code()=" + getReport_code() + ", getReport_submit_date()=" + getReport_submit_date()
				+ ", getRepdesc()=" + getRepdesc() + ", getFrequency()=" + getFrequency() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

	public BRF43B_ENTITY(String name, String categorya, String categoryb, BigDecimal funded, BigDecimal unfunded,
			BigDecimal unused_limit, BigDecimal total_exposure, String security_provided, String row_label,
			Date report_date, Date report_from_date, Date report_to_date, String entity_flg, String modify_flg,
			String del_flg, String report_code, Date report_submit_date, String repdesc, String frequency) {
		super();
		this.name = name;
		this.categorya = categorya;
		this.categoryb = categoryb;
		this.funded = funded;
		this.unfunded = unfunded;
		this.unused_limit = unused_limit;
		this.total_exposure = total_exposure;
		this.security_provided = security_provided;
		this.row_label = row_label;
		this.report_date = report_date;
		this.report_from_date = report_from_date;
		this.report_to_date = report_to_date;
		this.entity_flg = entity_flg;
		this.modify_flg = modify_flg;
		this.del_flg = del_flg;
		this.report_code = report_code;
		this.report_submit_date = report_submit_date;
		this.repdesc = repdesc;
		this.frequency = frequency;
	}

	public BRF43B_ENTITY() {
		super();
		// TODO Auto-generated constructor stub
	}
}
