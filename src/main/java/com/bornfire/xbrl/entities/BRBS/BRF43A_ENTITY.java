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
@Table(name = "BRF43A_SUMMARYTABLE")
public class BRF43A_ENTITY {
	private String r10_category_a1;
	private BigDecimal r10_funded;
	private BigDecimal r10_unfunded;
	private BigDecimal r10_unused_limit;
	private BigDecimal r10_total_exposure;
	private String r10_security_provided;
	private String r11_category_a2;
	private BigDecimal r11_funded;
	private BigDecimal r11_unfunded;
	private BigDecimal r11_unused_limit;
	private BigDecimal r11_total_exposure;
	private String r11_security_provided;
	private String r12_category_a3;
	private BigDecimal r12_funded;
	private BigDecimal r12_unfunded;
	private BigDecimal r12_unused_limit;
	private BigDecimal r12_total_exposure;
	private String r12_security_provided;
	private String r13_category_a4;
	private BigDecimal r13_funded;
	private BigDecimal r13_unfunded;
	private BigDecimal r13_unused_limit;
	private BigDecimal r13_total_exposure;
	private String r13_security_provided;
	private String r14_subtotal1;
	private BigDecimal r14_funded;
	private BigDecimal r14_unfunded;
	private BigDecimal r14_unused_limit;
	private BigDecimal r14_total_exposure;
	private String r14_security_provided;
	private Date report_from_date;
	private Date report_to_date;
	private String entity_flg;
	private String modify_flg;
	private String del_flg;
	private String report_code;
	private Date report_submit_date;
	@Id
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date report_date;
	private BigDecimal fund_total;
	private BigDecimal unfund_total;
	private BigDecimal unusedlimit_total;
	private BigDecimal totexpo_total;
	private String repdesc;
	private String frequency;

	public String getR10_category_a1() {
		return r10_category_a1;
	}

	public void setR10_category_a1(String r10_category_a1) {
		this.r10_category_a1 = r10_category_a1;
	}

	public BigDecimal getR10_funded() {
		return r10_funded;
	}

	public void setR10_funded(BigDecimal r10_funded) {
		this.r10_funded = r10_funded;
	}

	public BigDecimal getR10_unfunded() {
		return r10_unfunded;
	}

	public void setR10_unfunded(BigDecimal r10_unfunded) {
		this.r10_unfunded = r10_unfunded;
	}

	public BigDecimal getR10_unused_limit() {
		return r10_unused_limit;
	}

	public void setR10_unused_limit(BigDecimal r10_unused_limit) {
		this.r10_unused_limit = r10_unused_limit;
	}

	public BigDecimal getR10_total_exposure() {
		return r10_total_exposure;
	}

	public void setR10_total_exposure(BigDecimal r10_total_exposure) {
		this.r10_total_exposure = r10_total_exposure;
	}

	public String getR10_security_provided() {
		return r10_security_provided;
	}

	public void setR10_security_provided(String r10_security_provided) {
		this.r10_security_provided = r10_security_provided;
	}

	public String getR11_category_a2() {
		return r11_category_a2;
	}

	public void setR11_category_a2(String r11_category_a2) {
		this.r11_category_a2 = r11_category_a2;
	}

	public BigDecimal getR11_funded() {
		return r11_funded;
	}

	public void setR11_funded(BigDecimal r11_funded) {
		this.r11_funded = r11_funded;
	}

	public BigDecimal getR11_unfunded() {
		return r11_unfunded;
	}

	public void setR11_unfunded(BigDecimal r11_unfunded) {
		this.r11_unfunded = r11_unfunded;
	}

	public BigDecimal getR11_unused_limit() {
		return r11_unused_limit;
	}

	public void setR11_unused_limit(BigDecimal r11_unused_limit) {
		this.r11_unused_limit = r11_unused_limit;
	}

	public BigDecimal getR11_total_exposure() {
		return r11_total_exposure;
	}

	public void setR11_total_exposure(BigDecimal r11_total_exposure) {
		this.r11_total_exposure = r11_total_exposure;
	}

	public String getR11_security_provided() {
		return r11_security_provided;
	}

	public void setR11_security_provided(String r11_security_provided) {
		this.r11_security_provided = r11_security_provided;
	}

	public String getR12_category_a3() {
		return r12_category_a3;
	}

	public void setR12_category_a3(String r12_category_a3) {
		this.r12_category_a3 = r12_category_a3;
	}

	public BigDecimal getR12_funded() {
		return r12_funded;
	}

	public void setR12_funded(BigDecimal r12_funded) {
		this.r12_funded = r12_funded;
	}

	public BigDecimal getR12_unfunded() {
		return r12_unfunded;
	}

	public void setR12_unfunded(BigDecimal r12_unfunded) {
		this.r12_unfunded = r12_unfunded;
	}

	public BigDecimal getR12_unused_limit() {
		return r12_unused_limit;
	}

	public void setR12_unused_limit(BigDecimal r12_unused_limit) {
		this.r12_unused_limit = r12_unused_limit;
	}

	public BigDecimal getR12_total_exposure() {
		return r12_total_exposure;
	}

	public void setR12_total_exposure(BigDecimal r12_total_exposure) {
		this.r12_total_exposure = r12_total_exposure;
	}

	public String getR12_security_provided() {
		return r12_security_provided;
	}

	public void setR12_security_provided(String r12_security_provided) {
		this.r12_security_provided = r12_security_provided;
	}

	public String getR13_category_a4() {
		return r13_category_a4;
	}

	public void setR13_category_a4(String r13_category_a4) {
		this.r13_category_a4 = r13_category_a4;
	}

	public BigDecimal getR13_funded() {
		return r13_funded;
	}

	public void setR13_funded(BigDecimal r13_funded) {
		this.r13_funded = r13_funded;
	}

	public BigDecimal getR13_unfunded() {
		return r13_unfunded;
	}

	public void setR13_unfunded(BigDecimal r13_unfunded) {
		this.r13_unfunded = r13_unfunded;
	}

	public BigDecimal getR13_unused_limit() {
		return r13_unused_limit;
	}

	public void setR13_unused_limit(BigDecimal r13_unused_limit) {
		this.r13_unused_limit = r13_unused_limit;
	}

	public BigDecimal getR13_total_exposure() {
		return r13_total_exposure;
	}

	public void setR13_total_exposure(BigDecimal r13_total_exposure) {
		this.r13_total_exposure = r13_total_exposure;
	}

	public String getR13_security_provided() {
		return r13_security_provided;
	}

	public void setR13_security_provided(String r13_security_provided) {
		this.r13_security_provided = r13_security_provided;
	}

	public String getR14_subtotal1() {
		return r14_subtotal1;
	}

	public void setR14_subtotal1(String r14_subtotal1) {
		this.r14_subtotal1 = r14_subtotal1;
	}

	public BigDecimal getR14_funded() {
		return r14_funded;
	}

	public void setR14_funded(BigDecimal r14_funded) {
		this.r14_funded = r14_funded;
	}

	public BigDecimal getR14_unfunded() {
		return r14_unfunded;
	}

	public void setR14_unfunded(BigDecimal r14_unfunded) {
		this.r14_unfunded = r14_unfunded;
	}

	public BigDecimal getR14_unused_limit() {
		return r14_unused_limit;
	}

	public void setR14_unused_limit(BigDecimal r14_unused_limit) {
		this.r14_unused_limit = r14_unused_limit;
	}

	public BigDecimal getR14_total_exposure() {
		return r14_total_exposure;
	}

	public void setR14_total_exposure(BigDecimal r14_total_exposure) {
		this.r14_total_exposure = r14_total_exposure;
	}

	public String getR14_security_provided() {
		return r14_security_provided;
	}

	public void setR14_security_provided(String r14_security_provided) {
		this.r14_security_provided = r14_security_provided;
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

	public Date getReport_date() {
		return report_date;
	}

	public void setReport_date(Date report_date) {
		this.report_date = report_date;
	}

	public BigDecimal getFund_total() {
		return fund_total;
	}

	public void setFund_total(BigDecimal fund_total) {
		this.fund_total = fund_total;
	}

	public BigDecimal getUnfund_total() {
		return unfund_total;
	}

	public void setUnfund_total(BigDecimal unfund_total) {
		this.unfund_total = unfund_total;
	}

	public BigDecimal getUnusedlimit_total() {
		return unusedlimit_total;
	}

	public void setUnusedlimit_total(BigDecimal unusedlimit_total) {
		this.unusedlimit_total = unusedlimit_total;
	}

	public BigDecimal getTotexpo_total() {
		return totexpo_total;
	}

	public void setTotexpo_total(BigDecimal totexpo_total) {
		this.totexpo_total = totexpo_total;
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
		return "BRF43A_ENTITY [r10_category_a1=" + r10_category_a1 + ", r10_funded=" + r10_funded + ", r10_unfunded="
				+ r10_unfunded + ", r10_unused_limit=" + r10_unused_limit + ", r10_total_exposure=" + r10_total_exposure
				+ ", r10_security_provided=" + r10_security_provided + ", r11_category_a2=" + r11_category_a2
				+ ", r11_funded=" + r11_funded + ", r11_unfunded=" + r11_unfunded + ", r11_unused_limit="
				+ r11_unused_limit + ", r11_total_exposure=" + r11_total_exposure + ", r11_security_provided="
				+ r11_security_provided + ", r12_category_a3=" + r12_category_a3 + ", r12_funded=" + r12_funded
				+ ", r12_unfunded=" + r12_unfunded + ", r12_unused_limit=" + r12_unused_limit + ", r12_total_exposure="
				+ r12_total_exposure + ", r12_security_provided=" + r12_security_provided + ", r13_category_a4="
				+ r13_category_a4 + ", r13_funded=" + r13_funded + ", r13_unfunded=" + r13_unfunded
				+ ", r13_unused_limit=" + r13_unused_limit + ", r13_total_exposure=" + r13_total_exposure
				+ ", r13_security_provided=" + r13_security_provided + ", r14_subtotal1=" + r14_subtotal1
				+ ", r14_funded=" + r14_funded + ", r14_unfunded=" + r14_unfunded + ", r14_unused_limit="
				+ r14_unused_limit + ", r14_total_exposure=" + r14_total_exposure + ", r14_security_provided="
				+ r14_security_provided + ", report_from_date=" + report_from_date + ", report_to_date="
				+ report_to_date + ", entity_flg=" + entity_flg + ", modify_flg=" + modify_flg + ", del_flg=" + del_flg
				+ ", report_code=" + report_code + ", report_submit_date=" + report_submit_date + ", report_date="
				+ report_date + ", fund_total=" + fund_total + ", unfund_total=" + unfund_total + ", unusedlimit_total="
				+ unusedlimit_total + ", totexpo_total=" + totexpo_total + ", repdesc=" + repdesc + ", frequency="
				+ frequency + ", getR10_category_a1()=" + getR10_category_a1() + ", getR10_funded()=" + getR10_funded()
				+ ", getR10_unfunded()=" + getR10_unfunded() + ", getR10_unused_limit()=" + getR10_unused_limit()
				+ ", getR10_total_exposure()=" + getR10_total_exposure() + ", getR10_security_provided()="
				+ getR10_security_provided() + ", getR11_category_a2()=" + getR11_category_a2() + ", getR11_funded()="
				+ getR11_funded() + ", getR11_unfunded()=" + getR11_unfunded() + ", getR11_unused_limit()="
				+ getR11_unused_limit() + ", getR11_total_exposure()=" + getR11_total_exposure()
				+ ", getR11_security_provided()=" + getR11_security_provided() + ", getR12_category_a3()="
				+ getR12_category_a3() + ", getR12_funded()=" + getR12_funded() + ", getR12_unfunded()="
				+ getR12_unfunded() + ", getR12_unused_limit()=" + getR12_unused_limit() + ", getR12_total_exposure()="
				+ getR12_total_exposure() + ", getR12_security_provided()=" + getR12_security_provided()
				+ ", getR13_category_a4()=" + getR13_category_a4() + ", getR13_funded()=" + getR13_funded()
				+ ", getR13_unfunded()=" + getR13_unfunded() + ", getR13_unused_limit()=" + getR13_unused_limit()
				+ ", getR13_total_exposure()=" + getR13_total_exposure() + ", getR13_security_provided()="
				+ getR13_security_provided() + ", getR14_subtotal1()=" + getR14_subtotal1() + ", getR14_funded()="
				+ getR14_funded() + ", getR14_unfunded()=" + getR14_unfunded() + ", getR14_unused_limit()="
				+ getR14_unused_limit() + ", getR14_total_exposure()=" + getR14_total_exposure()
				+ ", getR14_security_provided()=" + getR14_security_provided() + ", getReport_from_date()="
				+ getReport_from_date() + ", getReport_to_date()=" + getReport_to_date() + ", getEntity_flg()="
				+ getEntity_flg() + ", getModify_flg()=" + getModify_flg() + ", getDel_flg()=" + getDel_flg()
				+ ", getReport_code()=" + getReport_code() + ", getReport_submit_date()=" + getReport_submit_date()
				+ ", getReport_date()=" + getReport_date() + ", getFund_total()=" + getFund_total()
				+ ", getUnfund_total()=" + getUnfund_total() + ", getUnusedlimit_total()=" + getUnusedlimit_total()
				+ ", getTotexpo_total()=" + getTotexpo_total() + ", getRepdesc()=" + getRepdesc() + ", getFrequency()="
				+ getFrequency() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}

	public BRF43A_ENTITY(String r10_category_a1, BigDecimal r10_funded, BigDecimal r10_unfunded,
			BigDecimal r10_unused_limit, BigDecimal r10_total_exposure, String r10_security_provided,
			String r11_category_a2, BigDecimal r11_funded, BigDecimal r11_unfunded, BigDecimal r11_unused_limit,
			BigDecimal r11_total_exposure, String r11_security_provided, String r12_category_a3, BigDecimal r12_funded,
			BigDecimal r12_unfunded, BigDecimal r12_unused_limit, BigDecimal r12_total_exposure,
			String r12_security_provided, String r13_category_a4, BigDecimal r13_funded, BigDecimal r13_unfunded,
			BigDecimal r13_unused_limit, BigDecimal r13_total_exposure, String r13_security_provided,
			String r14_subtotal1, BigDecimal r14_funded, BigDecimal r14_unfunded, BigDecimal r14_unused_limit,
			BigDecimal r14_total_exposure, String r14_security_provided, Date report_from_date, Date report_to_date,
			String entity_flg, String modify_flg, String del_flg, String report_code, Date report_submit_date,
			Date report_date, BigDecimal fund_total, BigDecimal unfund_total, BigDecimal unusedlimit_total,
			BigDecimal totexpo_total, String repdesc, String frequency) {
		super();
		this.r10_category_a1 = r10_category_a1;
		this.r10_funded = r10_funded;
		this.r10_unfunded = r10_unfunded;
		this.r10_unused_limit = r10_unused_limit;
		this.r10_total_exposure = r10_total_exposure;
		this.r10_security_provided = r10_security_provided;
		this.r11_category_a2 = r11_category_a2;
		this.r11_funded = r11_funded;
		this.r11_unfunded = r11_unfunded;
		this.r11_unused_limit = r11_unused_limit;
		this.r11_total_exposure = r11_total_exposure;
		this.r11_security_provided = r11_security_provided;
		this.r12_category_a3 = r12_category_a3;
		this.r12_funded = r12_funded;
		this.r12_unfunded = r12_unfunded;
		this.r12_unused_limit = r12_unused_limit;
		this.r12_total_exposure = r12_total_exposure;
		this.r12_security_provided = r12_security_provided;
		this.r13_category_a4 = r13_category_a4;
		this.r13_funded = r13_funded;
		this.r13_unfunded = r13_unfunded;
		this.r13_unused_limit = r13_unused_limit;
		this.r13_total_exposure = r13_total_exposure;
		this.r13_security_provided = r13_security_provided;
		this.r14_subtotal1 = r14_subtotal1;
		this.r14_funded = r14_funded;
		this.r14_unfunded = r14_unfunded;
		this.r14_unused_limit = r14_unused_limit;
		this.r14_total_exposure = r14_total_exposure;
		this.r14_security_provided = r14_security_provided;
		this.report_from_date = report_from_date;
		this.report_to_date = report_to_date;
		this.entity_flg = entity_flg;
		this.modify_flg = modify_flg;
		this.del_flg = del_flg;
		this.report_code = report_code;
		this.report_submit_date = report_submit_date;
		this.report_date = report_date;
		this.fund_total = fund_total;
		this.unfund_total = unfund_total;
		this.unusedlimit_total = unusedlimit_total;
		this.totexpo_total = totexpo_total;
		this.repdesc = repdesc;
		this.frequency = frequency;
	}

	public BRF43A_ENTITY() {
		super();
		// TODO Auto-generated constructor stub
	}
}
