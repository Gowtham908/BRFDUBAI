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
@Table(name="BRF57_SUMMARYTABLE")

public class BRF57_ENTITY {
	private BigDecimal	r1_bank;
	private BigDecimal	r1_rented;
	private BigDecimal	r1_total_area;
	private BigDecimal	r1_book_value;
	private String	r1_remarks;
	private BigDecimal	r2_bank;
	private BigDecimal	r2_rented;
	private BigDecimal	r2_total_area;
	private BigDecimal	r2_book_value;
	private String	r2_remarks;
	private BigDecimal	r3_bank;
	private BigDecimal	r3_rented;
	private BigDecimal	r3_total_area;
	private BigDecimal	r3_book_value;
	private String	r3_remarks;
	private BigDecimal	r4_bank;
	private BigDecimal	r4_rented;
	private BigDecimal	r4_total_area;
	private BigDecimal	r4_book_value;
	private String	r4_remarks;
	private BigDecimal	r5_bank;
	private BigDecimal	r5_rented;
	private BigDecimal	r5_total_area;
	private BigDecimal	r5_book_value;
	private String	r5_remarks;
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
	private String	repdesc;
	private String	frequency;
	public BigDecimal getR1_bank() {
		return r1_bank;
	}
	public void setR1_bank(BigDecimal r1_bank) {
		this.r1_bank = r1_bank;
	}
	public BigDecimal getR1_rented() {
		return r1_rented;
	}
	public void setR1_rented(BigDecimal r1_rented) {
		this.r1_rented = r1_rented;
	}
	public BigDecimal getR1_total_area() {
		return r1_total_area;
	}
	public void setR1_total_area(BigDecimal r1_total_area) {
		this.r1_total_area = r1_total_area;
	}
	public BigDecimal getR1_book_value() {
		return r1_book_value;
	}
	public void setR1_book_value(BigDecimal r1_book_value) {
		this.r1_book_value = r1_book_value;
	}
	public String getR1_remarks() {
		return r1_remarks;
	}
	public void setR1_remarks(String r1_remarks) {
		this.r1_remarks = r1_remarks;
	}
	public BigDecimal getR2_bank() {
		return r2_bank;
	}
	public void setR2_bank(BigDecimal r2_bank) {
		this.r2_bank = r2_bank;
	}
	public BigDecimal getR2_rented() {
		return r2_rented;
	}
	public void setR2_rented(BigDecimal r2_rented) {
		this.r2_rented = r2_rented;
	}
	public BigDecimal getR2_total_area() {
		return r2_total_area;
	}
	public void setR2_total_area(BigDecimal r2_total_area) {
		this.r2_total_area = r2_total_area;
	}
	public BigDecimal getR2_book_value() {
		return r2_book_value;
	}
	public void setR2_book_value(BigDecimal r2_book_value) {
		this.r2_book_value = r2_book_value;
	}
	public String getR2_remarks() {
		return r2_remarks;
	}
	public void setR2_remarks(String r2_remarks) {
		this.r2_remarks = r2_remarks;
	}
	public BigDecimal getR3_bank() {
		return r3_bank;
	}
	public void setR3_bank(BigDecimal r3_bank) {
		this.r3_bank = r3_bank;
	}
	public BigDecimal getR3_rented() {
		return r3_rented;
	}
	public void setR3_rented(BigDecimal r3_rented) {
		this.r3_rented = r3_rented;
	}
	public BigDecimal getR3_total_area() {
		return r3_total_area;
	}
	public void setR3_total_area(BigDecimal r3_total_area) {
		this.r3_total_area = r3_total_area;
	}
	public BigDecimal getR3_book_value() {
		return r3_book_value;
	}
	public void setR3_book_value(BigDecimal r3_book_value) {
		this.r3_book_value = r3_book_value;
	}
	public String getR3_remarks() {
		return r3_remarks;
	}
	public void setR3_remarks(String r3_remarks) {
		this.r3_remarks = r3_remarks;
	}
	public BigDecimal getR4_bank() {
		return r4_bank;
	}
	public void setR4_bank(BigDecimal r4_bank) {
		this.r4_bank = r4_bank;
	}
	public BigDecimal getR4_rented() {
		return r4_rented;
	}
	public void setR4_rented(BigDecimal r4_rented) {
		this.r4_rented = r4_rented;
	}
	public BigDecimal getR4_total_area() {
		return r4_total_area;
	}
	public void setR4_total_area(BigDecimal r4_total_area) {
		this.r4_total_area = r4_total_area;
	}
	public BigDecimal getR4_book_value() {
		return r4_book_value;
	}
	public void setR4_book_value(BigDecimal r4_book_value) {
		this.r4_book_value = r4_book_value;
	}
	public String getR4_remarks() {
		return r4_remarks;
	}
	public void setR4_remarks(String r4_remarks) {
		this.r4_remarks = r4_remarks;
	}
	public BigDecimal getR5_bank() {
		return r5_bank;
	}
	public void setR5_bank(BigDecimal r5_bank) {
		this.r5_bank = r5_bank;
	}
	public BigDecimal getR5_rented() {
		return r5_rented;
	}
	public void setR5_rented(BigDecimal r5_rented) {
		this.r5_rented = r5_rented;
	}
	public BigDecimal getR5_total_area() {
		return r5_total_area;
	}
	public void setR5_total_area(BigDecimal r5_total_area) {
		this.r5_total_area = r5_total_area;
	}
	public BigDecimal getR5_book_value() {
		return r5_book_value;
	}
	public void setR5_book_value(BigDecimal r5_book_value) {
		this.r5_book_value = r5_book_value;
	}
	public String getR5_remarks() {
		return r5_remarks;
	}
	public void setR5_remarks(String r5_remarks) {
		this.r5_remarks = r5_remarks;
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
	public BRF57_ENTITY() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}