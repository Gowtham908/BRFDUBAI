
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
@Table(name="BRF_154")
public class BRF154reportentity {
	private String	r1_cin;
	private String	r1_legalentity;
	private String	r1_customername;
	private String	r1_counter;
	private String	r1_country;
	private String	r1_ccy;
	private BigDecimal	r1_o_s;
	private String	r1_ccy_os;
	private BigDecimal	r1_unfunded;
	private String	r1_ccy_security;
	private BigDecimal	r1_amount;
	private String	r1_collaterals;
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
	public String getR1_cin() {
		return r1_cin;
	}
	public void setR1_cin(String r1_cin) {
		this.r1_cin = r1_cin;
	}
	public String getR1_legalentity() {
		return r1_legalentity;
	}
	public void setR1_legalentity(String r1_legalentity) {
		this.r1_legalentity = r1_legalentity;
	}
	public String getR1_customername() {
		return r1_customername;
	}
	public void setR1_customername(String r1_customername) {
		this.r1_customername = r1_customername;
	}
	public String getR1_counter() {
		return r1_counter;
	}
	public void setR1_counter(String r1_counter) {
		this.r1_counter = r1_counter;
	}
	public String getR1_country() {
		return r1_country;
	}
	public void setR1_country(String r1_country) {
		this.r1_country = r1_country;
	}
	public String getR1_ccy() {
		return r1_ccy;
	}
	public void setR1_ccy(String r1_ccy) {
		this.r1_ccy = r1_ccy;
	}
	public BigDecimal getR1_o_s() {
		return r1_o_s;
	}
	public void setR1_o_s(BigDecimal r1_o_s) {
		this.r1_o_s = r1_o_s;
	}
	public String getR1_ccy_os() {
		return r1_ccy_os;
	}
	public void setR1_ccy_os(String r1_ccy_os) {
		this.r1_ccy_os = r1_ccy_os;
	}
	public BigDecimal getR1_unfunded() {
		return r1_unfunded;
	}
	public void setR1_unfunded(BigDecimal r1_unfunded) {
		this.r1_unfunded = r1_unfunded;
	}
	public String getR1_ccy_security() {
		return r1_ccy_security;
	}
	public void setR1_ccy_security(String r1_ccy_security) {
		this.r1_ccy_security = r1_ccy_security;
	}
	public BigDecimal getR1_amount() {
		return r1_amount;
	}
	public void setR1_amount(BigDecimal r1_amount) {
		this.r1_amount = r1_amount;
	}
	public String getR1_collaterals() {
		return r1_collaterals;
	}
	public void setR1_collaterals(String r1_collaterals) {
		this.r1_collaterals = r1_collaterals;
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
	public BRF154reportentity() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
