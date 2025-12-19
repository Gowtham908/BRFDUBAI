package com.bornfire.xbrl.entities;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="PD_LGD_TABLE2")
public class ECL_PDLGD_ENTITY2 {
	private Date	extract_date;
	private String	external_rating;
	private String	rating_agency;
	private BigDecimal	mapping;
	private Date	recordinput_date;
	private BigDecimal	dataimport_id;
	private BigDecimal	base_pd;
	private BigDecimal	positive_pd;
	private BigDecimal	negative_pd;
	private BigDecimal	dataimport_entity_id;
	private BigDecimal	row_id;
	@Id
	private Date	report_date;
	private Date	report_from_date;
	private Date	report_to_date;
	private String	entity_flg;
	private String	modify_flg;
	private String	del_flg;
	private String	report_code;
	private Date	report_submit_date;
	public Date getExtract_date() {
		return extract_date;
	}
	public void setExtract_date(Date extract_date) {
		this.extract_date = extract_date;
	}
	public String getExternal_rating() {
		return external_rating;
	}
	public void setExternal_rating(String external_rating) {
		this.external_rating = external_rating;
	}
	public String getRating_agency() {
		return rating_agency;
	}
	public void setRating_agency(String rating_agency) {
		this.rating_agency = rating_agency;
	}
	public BigDecimal getMapping() {
		return mapping;
	}
	public void setMapping(BigDecimal mapping) {
		this.mapping = mapping;
	}
	public Date getRecordinput_date() {
		return recordinput_date;
	}
	public void setRecordinput_date(Date recordinput_date) {
		this.recordinput_date = recordinput_date;
	}
	public BigDecimal getDataimport_id() {
		return dataimport_id;
	}
	public void setDataimport_id(BigDecimal dataimport_id) {
		this.dataimport_id = dataimport_id;
	}
	public BigDecimal getBase_pd() {
		return base_pd;
	}
	public void setBase_pd(BigDecimal base_pd) {
		this.base_pd = base_pd;
	}
	public BigDecimal getPositive_pd() {
		return positive_pd;
	}
	public void setPositive_pd(BigDecimal positive_pd) {
		this.positive_pd = positive_pd;
	}
	public BigDecimal getNegative_pd() {
		return negative_pd;
	}
	public void setNegative_pd(BigDecimal negative_pd) {
		this.negative_pd = negative_pd;
	}
	public BigDecimal getDataimport_entity_id() {
		return dataimport_entity_id;
	}
	public void setDataimport_entity_id(BigDecimal dataimport_entity_id) {
		this.dataimport_entity_id = dataimport_entity_id;
	}
	public BigDecimal getRow_id() {
		return row_id;
	}
	public void setRow_id(BigDecimal row_id) {
		this.row_id = row_id;
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
	public ECL_PDLGD_ENTITY2(Date extract_date, String external_rating, String rating_agency, BigDecimal mapping,
			Date recordinput_date, BigDecimal dataimport_id, BigDecimal base_pd, BigDecimal positive_pd,
			BigDecimal negative_pd, BigDecimal dataimport_entity_id, BigDecimal row_id, Date report_date,
			Date report_from_date, Date report_to_date, String entity_flg, String modify_flg, String del_flg,
			String report_code, Date report_submit_date) {
		super();
		this.extract_date = extract_date;
		this.external_rating = external_rating;
		this.rating_agency = rating_agency;
		this.mapping = mapping;
		this.recordinput_date = recordinput_date;
		this.dataimport_id = dataimport_id;
		this.base_pd = base_pd;
		this.positive_pd = positive_pd;
		this.negative_pd = negative_pd;
		this.dataimport_entity_id = dataimport_entity_id;
		this.row_id = row_id;
		this.report_date = report_date;
		this.report_from_date = report_from_date;
		this.report_to_date = report_to_date;
		this.entity_flg = entity_flg;
		this.modify_flg = modify_flg;
		this.del_flg = del_flg;
		this.report_code = report_code;
		this.report_submit_date = report_submit_date;
	}
	public ECL_PDLGD_ENTITY2() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	

}
