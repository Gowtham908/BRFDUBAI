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
@Table(name="BRF48_SUMMARYTABLE")
public class BRF48_Entity {
	private String	r10_class_a;
	private BigDecimal	r10_market_values;
	private BigDecimal	r10_eligible_values;
	private BigDecimal	r10_mv_unencumbered;
	private BigDecimal	r10_ev_unencumbered;
	private BigDecimal	r10_mv_encumbered;
	private BigDecimal	r10_ev_encumbered;
	private String	r11_class_b;
	private BigDecimal	r11_market_values;
	private BigDecimal	r11_eligible_values;
	private BigDecimal	r11_mv_unencumbered;
	private BigDecimal	r11_ev_unencumbered;
	private BigDecimal	r11_mv_encumbered;
	private BigDecimal	r11_ev_encumbered;
	private String	r12_class_c;
	private BigDecimal	r12_market_values;
	private BigDecimal	r12_eligible_values;
	private BigDecimal	r12_mv_unencumbered;
	private BigDecimal	r12_ev_unencumbered;
	private BigDecimal	r12_mv_encumbered;
	private BigDecimal	r12_ev_encumbered;
	private String	r13_class_d;
	private BigDecimal	r13_market_values;
	private BigDecimal	r13_eligible_values;
	private BigDecimal	r13_mv_unencumbered;
	private BigDecimal	r13_ev_unencumbered;
	private BigDecimal	r13_mv_encumbered;
	private BigDecimal	r13_ev_encumbered;
	private String	r14_class_e;
	private BigDecimal	r14_market_values;
	private BigDecimal	r14_eligible_values;
	private BigDecimal	r14_mv_unencumbered;
	private BigDecimal	r14_ev_unencumbered;
	private BigDecimal	r14_mv_encumbered;
	private BigDecimal	r14_ev_encumbered;
	private String	r15_non_elegible;
	private BigDecimal	r15_market_values;
	private String	r15_eligible_values;
	private BigDecimal	r15_mv_unencumbered;
	private String	r15_ev_unencumbered;
	private BigDecimal	r15_mv_encumbered;
	private String	r15_ev_encumbered;
	private String	r16_total;
	private BigDecimal	r16_market_values;
	private BigDecimal	r16_eligible_values;
	private BigDecimal	r16_mv_unencumbered;
	private BigDecimal	r16_ev_unencumbered;
	private BigDecimal	r16_mv_encumbered;
	private BigDecimal	r16_ev_encumbered;
	@Id
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date	report_date;
	private Date	report_from_date;
	private String	report_to_date;
	private String	entity_flg;
	private String	modify_flg;
	private String	del_flg;
	private String	report_code;
	private Date	report_submit_date;
	private String	repdesc;
	private String	frequency;
	public String getR10_class_a() {
		return r10_class_a;
	}
	public void setR10_class_a(String r10_class_a) {
		this.r10_class_a = r10_class_a;
	}
	public BigDecimal getR10_market_values() {
		return r10_market_values;
	}
	public void setR10_market_values(BigDecimal r10_market_values) {
		this.r10_market_values = r10_market_values;
	}
	public BigDecimal getR10_eligible_values() {
		return r10_eligible_values;
	}
	public void setR10_eligible_values(BigDecimal r10_eligible_values) {
		this.r10_eligible_values = r10_eligible_values;
	}
	public BigDecimal getR10_mv_unencumbered() {
		return r10_mv_unencumbered;
	}
	public void setR10_mv_unencumbered(BigDecimal r10_mv_unencumbered) {
		this.r10_mv_unencumbered = r10_mv_unencumbered;
	}
	public BigDecimal getR10_ev_unencumbered() {
		return r10_ev_unencumbered;
	}
	public void setR10_ev_unencumbered(BigDecimal r10_ev_unencumbered) {
		this.r10_ev_unencumbered = r10_ev_unencumbered;
	}
	public BigDecimal getR10_mv_encumbered() {
		return r10_mv_encumbered;
	}
	public void setR10_mv_encumbered(BigDecimal r10_mv_encumbered) {
		this.r10_mv_encumbered = r10_mv_encumbered;
	}
	public BigDecimal getR10_ev_encumbered() {
		return r10_ev_encumbered;
	}
	public void setR10_ev_encumbered(BigDecimal r10_ev_encumbered) {
		this.r10_ev_encumbered = r10_ev_encumbered;
	}
	public String getR11_class_b() {
		return r11_class_b;
	}
	public void setR11_class_b(String r11_class_b) {
		this.r11_class_b = r11_class_b;
	}
	public BigDecimal getR11_market_values() {
		return r11_market_values;
	}
	public void setR11_market_values(BigDecimal r11_market_values) {
		this.r11_market_values = r11_market_values;
	}
	public BigDecimal getR11_eligible_values() {
		return r11_eligible_values;
	}
	public void setR11_eligible_values(BigDecimal r11_eligible_values) {
		this.r11_eligible_values = r11_eligible_values;
	}
	public BigDecimal getR11_mv_unencumbered() {
		return r11_mv_unencumbered;
	}
	public void setR11_mv_unencumbered(BigDecimal r11_mv_unencumbered) {
		this.r11_mv_unencumbered = r11_mv_unencumbered;
	}
	public BigDecimal getR11_ev_unencumbered() {
		return r11_ev_unencumbered;
	}
	public void setR11_ev_unencumbered(BigDecimal r11_ev_unencumbered) {
		this.r11_ev_unencumbered = r11_ev_unencumbered;
	}
	public BigDecimal getR11_mv_encumbered() {
		return r11_mv_encumbered;
	}
	public void setR11_mv_encumbered(BigDecimal r11_mv_encumbered) {
		this.r11_mv_encumbered = r11_mv_encumbered;
	}
	public BigDecimal getR11_ev_encumbered() {
		return r11_ev_encumbered;
	}
	public void setR11_ev_encumbered(BigDecimal r11_ev_encumbered) {
		this.r11_ev_encumbered = r11_ev_encumbered;
	}
	public String getR12_class_c() {
		return r12_class_c;
	}
	public void setR12_class_c(String r12_class_c) {
		this.r12_class_c = r12_class_c;
	}
	public BigDecimal getR12_market_values() {
		return r12_market_values;
	}
	public void setR12_market_values(BigDecimal r12_market_values) {
		this.r12_market_values = r12_market_values;
	}
	public BigDecimal getR12_eligible_values() {
		return r12_eligible_values;
	}
	public void setR12_eligible_values(BigDecimal r12_eligible_values) {
		this.r12_eligible_values = r12_eligible_values;
	}
	public BigDecimal getR12_mv_unencumbered() {
		return r12_mv_unencumbered;
	}
	public void setR12_mv_unencumbered(BigDecimal r12_mv_unencumbered) {
		this.r12_mv_unencumbered = r12_mv_unencumbered;
	}
	public BigDecimal getR12_ev_unencumbered() {
		return r12_ev_unencumbered;
	}
	public void setR12_ev_unencumbered(BigDecimal r12_ev_unencumbered) {
		this.r12_ev_unencumbered = r12_ev_unencumbered;
	}
	public BigDecimal getR12_mv_encumbered() {
		return r12_mv_encumbered;
	}
	public void setR12_mv_encumbered(BigDecimal r12_mv_encumbered) {
		this.r12_mv_encumbered = r12_mv_encumbered;
	}
	public BigDecimal getR12_ev_encumbered() {
		return r12_ev_encumbered;
	}
	public void setR12_ev_encumbered(BigDecimal r12_ev_encumbered) {
		this.r12_ev_encumbered = r12_ev_encumbered;
	}
	public String getR13_class_d() {
		return r13_class_d;
	}
	public void setR13_class_d(String r13_class_d) {
		this.r13_class_d = r13_class_d;
	}
	public BigDecimal getR13_market_values() {
		return r13_market_values;
	}
	public void setR13_market_values(BigDecimal r13_market_values) {
		this.r13_market_values = r13_market_values;
	}
	public BigDecimal getR13_eligible_values() {
		return r13_eligible_values;
	}
	public void setR13_eligible_values(BigDecimal r13_eligible_values) {
		this.r13_eligible_values = r13_eligible_values;
	}
	public BigDecimal getR13_mv_unencumbered() {
		return r13_mv_unencumbered;
	}
	public void setR13_mv_unencumbered(BigDecimal r13_mv_unencumbered) {
		this.r13_mv_unencumbered = r13_mv_unencumbered;
	}
	public BigDecimal getR13_ev_unencumbered() {
		return r13_ev_unencumbered;
	}
	public void setR13_ev_unencumbered(BigDecimal r13_ev_unencumbered) {
		this.r13_ev_unencumbered = r13_ev_unencumbered;
	}
	public BigDecimal getR13_mv_encumbered() {
		return r13_mv_encumbered;
	}
	public void setR13_mv_encumbered(BigDecimal r13_mv_encumbered) {
		this.r13_mv_encumbered = r13_mv_encumbered;
	}
	public BigDecimal getR13_ev_encumbered() {
		return r13_ev_encumbered;
	}
	public void setR13_ev_encumbered(BigDecimal r13_ev_encumbered) {
		this.r13_ev_encumbered = r13_ev_encumbered;
	}
	public String getR14_class_e() {
		return r14_class_e;
	}
	public void setR14_class_e(String r14_class_e) {
		this.r14_class_e = r14_class_e;
	}
	public BigDecimal getR14_market_values() {
		return r14_market_values;
	}
	public void setR14_market_values(BigDecimal r14_market_values) {
		this.r14_market_values = r14_market_values;
	}
	public BigDecimal getR14_eligible_values() {
		return r14_eligible_values;
	}
	public void setR14_eligible_values(BigDecimal r14_eligible_values) {
		this.r14_eligible_values = r14_eligible_values;
	}
	public BigDecimal getR14_mv_unencumbered() {
		return r14_mv_unencumbered;
	}
	public void setR14_mv_unencumbered(BigDecimal r14_mv_unencumbered) {
		this.r14_mv_unencumbered = r14_mv_unencumbered;
	}
	public BigDecimal getR14_ev_unencumbered() {
		return r14_ev_unencumbered;
	}
	public void setR14_ev_unencumbered(BigDecimal r14_ev_unencumbered) {
		this.r14_ev_unencumbered = r14_ev_unencumbered;
	}
	public BigDecimal getR14_mv_encumbered() {
		return r14_mv_encumbered;
	}
	public void setR14_mv_encumbered(BigDecimal r14_mv_encumbered) {
		this.r14_mv_encumbered = r14_mv_encumbered;
	}
	public BigDecimal getR14_ev_encumbered() {
		return r14_ev_encumbered;
	}
	public void setR14_ev_encumbered(BigDecimal r14_ev_encumbered) {
		this.r14_ev_encumbered = r14_ev_encumbered;
	}
	public String getR15_non_elegible() {
		return r15_non_elegible;
	}
	public void setR15_non_elegible(String r15_non_elegible) {
		this.r15_non_elegible = r15_non_elegible;
	}
	public BigDecimal getR15_market_values() {
		return r15_market_values;
	}
	public void setR15_market_values(BigDecimal r15_market_values) {
		this.r15_market_values = r15_market_values;
	}
	public String getR15_eligible_values() {
		return r15_eligible_values;
	}
	public void setR15_eligible_values(String r15_eligible_values) {
		this.r15_eligible_values = r15_eligible_values;
	}
	public BigDecimal getR15_mv_unencumbered() {
		return r15_mv_unencumbered;
	}
	public void setR15_mv_unencumbered(BigDecimal r15_mv_unencumbered) {
		this.r15_mv_unencumbered = r15_mv_unencumbered;
	}
	public String getR15_ev_unencumbered() {
		return r15_ev_unencumbered;
	}
	public void setR15_ev_unencumbered(String r15_ev_unencumbered) {
		this.r15_ev_unencumbered = r15_ev_unencumbered;
	}
	public BigDecimal getR15_mv_encumbered() {
		return r15_mv_encumbered;
	}
	public void setR15_mv_encumbered(BigDecimal r15_mv_encumbered) {
		this.r15_mv_encumbered = r15_mv_encumbered;
	}
	public String getR15_ev_encumbered() {
		return r15_ev_encumbered;
	}
	public void setR15_ev_encumbered(String r15_ev_encumbered) {
		this.r15_ev_encumbered = r15_ev_encumbered;
	}
	public String getR16_total() {
		return r16_total;
	}
	public void setR16_total(String r16_total) {
		this.r16_total = r16_total;
	}
	public BigDecimal getR16_market_values() {
		return r16_market_values;
	}
	public void setR16_market_values(BigDecimal r16_market_values) {
		this.r16_market_values = r16_market_values;
	}
	public BigDecimal getR16_eligible_values() {
		return r16_eligible_values;
	}
	public void setR16_eligible_values(BigDecimal r16_eligible_values) {
		this.r16_eligible_values = r16_eligible_values;
	}
	public BigDecimal getR16_mv_unencumbered() {
		return r16_mv_unencumbered;
	}
	public void setR16_mv_unencumbered(BigDecimal r16_mv_unencumbered) {
		this.r16_mv_unencumbered = r16_mv_unencumbered;
	}
	public BigDecimal getR16_ev_unencumbered() {
		return r16_ev_unencumbered;
	}
	public void setR16_ev_unencumbered(BigDecimal r16_ev_unencumbered) {
		this.r16_ev_unencumbered = r16_ev_unencumbered;
	}
	public BigDecimal getR16_mv_encumbered() {
		return r16_mv_encumbered;
	}
	public void setR16_mv_encumbered(BigDecimal r16_mv_encumbered) {
		this.r16_mv_encumbered = r16_mv_encumbered;
	}
	public BigDecimal getR16_ev_encumbered() {
		return r16_ev_encumbered;
	}
	public void setR16_ev_encumbered(BigDecimal r16_ev_encumbered) {
		this.r16_ev_encumbered = r16_ev_encumbered;
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
	public String getReport_to_date() {
		return report_to_date;
	}
	public void setReport_to_date(String report_to_date) {
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
	public BRF48_Entity() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
