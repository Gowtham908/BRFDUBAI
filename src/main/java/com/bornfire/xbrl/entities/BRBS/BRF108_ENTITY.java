package com.bornfire.xbrl.entities.BRBS;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "BRF108_SUMMARYTABLE")
@IdClass(BRF108IDCLASS.class)
public class BRF108_ENTITY implements Serializable {
	@Id
	private String r1_s_no;
	private String r1_customer_name;
	private String r1_customer_id;
	private Date r1_exp_date;
	private String r1_act_num;
	private String r1_customer_add;
	private String r1_branch_name;
	private String r1_act_type;
	private Date r1_trans_date;
	private Date r1_com_date;
	private String r1_dep_no;
	private Date r1_safe_date;
	private BigDecimal r1_dormant;
	private Date r1_drill_date;
	private BigDecimal r1_drill_charge;
	private BigDecimal r1_total;
	private String r1_description;
	private String entry_user;
	private String modify_user;
	private String verify_user;
	private Date entry_time;
	private Date modify_time;
	private Date verify_time;
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

	public String getR1_s_no() {
		return r1_s_no;
	}

	public void setR1_s_no(String r1_s_no) {
		this.r1_s_no = r1_s_no;
	}

	public String getR1_customer_name() {
		return r1_customer_name;
	}

	public void setR1_customer_name(String r1_customer_name) {
		this.r1_customer_name = r1_customer_name;
	}

	public String getR1_customer_id() {
		return r1_customer_id;
	}

	public void setR1_customer_id(String r1_customer_id) {
		this.r1_customer_id = r1_customer_id;
	}

	public Date getR1_exp_date() {
		return r1_exp_date;
	}

	public void setR1_exp_date(Date r1_exp_date) {
		this.r1_exp_date = r1_exp_date;
	}

	public String getR1_act_num() {
		return r1_act_num;
	}

	public void setR1_act_num(String r1_act_num) {
		this.r1_act_num = r1_act_num;
	}

	public String getR1_customer_add() {
		return r1_customer_add;
	}

	public void setR1_customer_add(String r1_customer_add) {
		this.r1_customer_add = r1_customer_add;
	}

	public String getR1_branch_name() {
		return r1_branch_name;
	}

	public void setR1_branch_name(String r1_branch_name) {
		this.r1_branch_name = r1_branch_name;
	}

	public String getR1_act_type() {
		return r1_act_type;
	}

	public void setR1_act_type(String r1_act_type) {
		this.r1_act_type = r1_act_type;
	}

	public Date getR1_trans_date() {
		return r1_trans_date;
	}

	public void setR1_trans_date(Date r1_trans_date) {
		this.r1_trans_date = r1_trans_date;
	}

	public Date getR1_com_date() {
		return r1_com_date;
	}

	public void setR1_com_date(Date r1_com_date) {
		this.r1_com_date = r1_com_date;
	}

	public String getR1_dep_no() {
		return r1_dep_no;
	}

	public void setR1_dep_no(String r1_dep_no) {
		this.r1_dep_no = r1_dep_no;
	}

	public Date getR1_safe_date() {
		return r1_safe_date;
	}

	public void setR1_safe_date(Date r1_safe_date) {
		this.r1_safe_date = r1_safe_date;
	}

	public BigDecimal getR1_dormant() {
		return r1_dormant;
	}

	public void setR1_dormant(BigDecimal r1_dormant) {
		this.r1_dormant = r1_dormant;
	}

	public Date getR1_drill_date() {
		return r1_drill_date;
	}

	public void setR1_drill_date(Date r1_drill_date) {
		this.r1_drill_date = r1_drill_date;
	}

	public BigDecimal getR1_drill_charge() {
		return r1_drill_charge;
	}

	public void setR1_drill_charge(BigDecimal r1_drill_charge) {
		this.r1_drill_charge = r1_drill_charge;
	}

	public BigDecimal getR1_total() {
		return r1_total;
	}

	public void setR1_total(BigDecimal r1_total) {
		this.r1_total = r1_total;
	}

	public String getR1_description() {
		return r1_description;
	}

	public void setR1_description(String r1_description) {
		this.r1_description = r1_description;
	}

	public String getEntry_user() {
		return entry_user;
	}

	public void setEntry_user(String entry_user) {
		this.entry_user = entry_user;
	}

	public String getModify_user() {
		return modify_user;
	}

	public void setModify_user(String modify_user) {
		this.modify_user = modify_user;
	}

	public String getVerify_user() {
		return verify_user;
	}

	public void setVerify_user(String verify_user) {
		this.verify_user = verify_user;
	}

	public Date getEntry_time() {
		return entry_time;
	}

	public void setEntry_time(Date entry_time) {
		this.entry_time = entry_time;
	}

	public Date getModify_time() {
		return modify_time;
	}

	public void setModify_time(Date modify_time) {
		this.modify_time = modify_time;
	}

	public Date getVerify_time() {
		return verify_time;
	}

	public void setVerify_time(Date verify_time) {
		this.verify_time = verify_time;
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

	public BRF108_ENTITY(String r1_s_no, String r1_customer_name, String r1_customer_id, Date r1_exp_date,
			String r1_act_num, String r1_customer_add, String r1_branch_name, String r1_act_type, Date r1_trans_date,
			Date r1_com_date, String r1_dep_no, Date r1_safe_date, BigDecimal r1_dormant, Date r1_drill_date,
			BigDecimal r1_drill_charge, BigDecimal r1_total, String r1_description, String entry_user,
			String modify_user, String verify_user, Date entry_time, Date modify_time, Date verify_time,
			Date report_date, Date report_from_date, Date report_to_date, String entity_flg, String modify_flg,
			String del_flg, String report_code, Date report_submit_date, String repdesc, String frequency) {
		super();
		this.r1_s_no = r1_s_no;
		this.r1_customer_name = r1_customer_name;
		this.r1_customer_id = r1_customer_id;
		this.r1_exp_date = r1_exp_date;
		this.r1_act_num = r1_act_num;
		this.r1_customer_add = r1_customer_add;
		this.r1_branch_name = r1_branch_name;
		this.r1_act_type = r1_act_type;
		this.r1_trans_date = r1_trans_date;
		this.r1_com_date = r1_com_date;
		this.r1_dep_no = r1_dep_no;
		this.r1_safe_date = r1_safe_date;
		this.r1_dormant = r1_dormant;
		this.r1_drill_date = r1_drill_date;
		this.r1_drill_charge = r1_drill_charge;
		this.r1_total = r1_total;
		this.r1_description = r1_description;
		this.entry_user = entry_user;
		this.modify_user = modify_user;
		this.verify_user = verify_user;
		this.entry_time = entry_time;
		this.modify_time = modify_time;
		this.verify_time = verify_time;
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

	public BRF108_ENTITY() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Object getValue() {
		// TODO Auto-generated method stub
		return null;
	}

	public Object getBigDecimalField() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String toString() {
		return "BRF108_ENTITY [r1_s_no=" + r1_s_no + ", r1_customer_name=" + r1_customer_name + ", r1_customer_id="
				+ r1_customer_id + ", r1_exp_date=" + r1_exp_date + ", r1_act_num=" + r1_act_num + ", r1_customer_add="
				+ r1_customer_add + ", r1_branch_name=" + r1_branch_name + ", r1_act_type=" + r1_act_type
				+ ", r1_trans_date=" + r1_trans_date + ", r1_com_date=" + r1_com_date + ", r1_dep_no=" + r1_dep_no
				+ ", r1_safe_date=" + r1_safe_date + ", r1_dormant=" + r1_dormant + ", r1_drill_date=" + r1_drill_date
				+ ", r1_drill_charge=" + r1_drill_charge + ", r1_total=" + r1_total + ", r1_description="
				+ r1_description + ", entry_user=" + entry_user + ", modify_user=" + modify_user + ", verify_user="
				+ verify_user + ", entry_time=" + entry_time + ", modify_time=" + modify_time + ", verify_time="
				+ verify_time + ", report_date=" + report_date + ", report_from_date=" + report_from_date
				+ ", report_to_date=" + report_to_date + ", entity_flg=" + entity_flg + ", modify_flg=" + modify_flg
				+ ", del_flg=" + del_flg + ", report_code=" + report_code + ", report_submit_date=" + report_submit_date
				+ ", repdesc=" + repdesc + ", frequency=" + frequency + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(r1_s_no, report_date);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BRF108_ENTITY other = (BRF108_ENTITY) obj;
		return Objects.equals(r1_s_no, other.r1_s_no) && Objects.equals(report_date, other.report_date);
	}
}
