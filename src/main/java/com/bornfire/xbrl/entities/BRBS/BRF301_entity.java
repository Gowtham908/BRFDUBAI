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
@Table(name = "BRF301_SUMMARYTABLE")
@IdClass(BRF301IDCLASS.class)
public class BRF301_entity implements Serializable {
	@Id
	private String r1_s_no;
	private String r1_domain;
	private String r1_description;
	private String r1_receiver;
	private String r1_material;
	private String r1_cbuae;
	private String r1_out_jobs;
	private String r1_critical_jobs;
	private String r1_third_parties;
	private String r1_nature_data;
	private String r1_service;
	private String r1_vendor;
	private String r1_country_reg;
	private String r1_lei;
	private String r1_company;
	private String r1_country_service;
	private String r1_country_data;
	private String r1_gov_law;
	private BigDecimal r1_annual_con;
	private BigDecimal r1_total_con;
	private Date r1_ser_date;
	private Date r1_exp_date;
	private String r1_risk;
	private String r1_sub1;
	private String r1_sub2;
	private Date r1_last_date;
	private String r1_comments;
	private String r1_reserve1;
	private String r1_reserve2;
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

	public String getR1_domain() {
		return r1_domain;
	}

	public void setR1_domain(String r1_domain) {
		this.r1_domain = r1_domain;
	}

	public String getR1_description() {
		return r1_description;
	}

	public void setR1_description(String r1_description) {
		this.r1_description = r1_description;
	}

	public String getR1_receiver() {
		return r1_receiver;
	}

	public void setR1_receiver(String r1_receiver) {
		this.r1_receiver = r1_receiver;
	}

	public String getR1_material() {
		return r1_material;
	}

	public void setR1_material(String r1_material) {
		this.r1_material = r1_material;
	}

	public String getR1_cbuae() {
		return r1_cbuae;
	}

	public void setR1_cbuae(String r1_cbuae) {
		this.r1_cbuae = r1_cbuae;
	}

	public String getR1_out_jobs() {
		return r1_out_jobs;
	}

	public void setR1_out_jobs(String r1_out_jobs) {
		this.r1_out_jobs = r1_out_jobs;
	}

	public String getR1_critical_jobs() {
		return r1_critical_jobs;
	}

	public void setR1_critical_jobs(String r1_critical_jobs) {
		this.r1_critical_jobs = r1_critical_jobs;
	}

	public String getR1_third_parties() {
		return r1_third_parties;
	}

	public void setR1_third_parties(String r1_third_parties) {
		this.r1_third_parties = r1_third_parties;
	}

	public String getR1_nature_data() {
		return r1_nature_data;
	}

	public void setR1_nature_data(String r1_nature_data) {
		this.r1_nature_data = r1_nature_data;
	}

	public String getR1_service() {
		return r1_service;
	}

	public void setR1_service(String r1_service) {
		this.r1_service = r1_service;
	}

	public String getR1_vendor() {
		return r1_vendor;
	}

	public void setR1_vendor(String r1_vendor) {
		this.r1_vendor = r1_vendor;
	}

	public String getR1_country_reg() {
		return r1_country_reg;
	}

	public void setR1_country_reg(String r1_country_reg) {
		this.r1_country_reg = r1_country_reg;
	}

	public String getR1_lei() {
		return r1_lei;
	}

	public void setR1_lei(String r1_lei) {
		this.r1_lei = r1_lei;
	}

	public String getR1_company() {
		return r1_company;
	}

	public void setR1_company(String r1_company) {
		this.r1_company = r1_company;
	}

	public String getR1_country_service() {
		return r1_country_service;
	}

	public void setR1_country_service(String r1_country_service) {
		this.r1_country_service = r1_country_service;
	}

	public String getR1_country_data() {
		return r1_country_data;
	}

	public void setR1_country_data(String r1_country_data) {
		this.r1_country_data = r1_country_data;
	}

	public String getR1_gov_law() {
		return r1_gov_law;
	}

	public void setR1_gov_law(String r1_gov_law) {
		this.r1_gov_law = r1_gov_law;
	}

	public BigDecimal getR1_annual_con() {
		return r1_annual_con;
	}

	public void setR1_annual_con(BigDecimal r1_annual_con) {
		this.r1_annual_con = r1_annual_con;
	}

	public BigDecimal getR1_total_con() {
		return r1_total_con;
	}

	public void setR1_total_con(BigDecimal r1_total_con) {
		this.r1_total_con = r1_total_con;
	}

	public Date getR1_ser_date() {
		return r1_ser_date;
	}

	public void setR1_ser_date(Date r1_ser_date) {
		this.r1_ser_date = r1_ser_date;
	}

	public Date getR1_exp_date() {
		return r1_exp_date;
	}

	public void setR1_exp_date(Date r1_exp_date) {
		this.r1_exp_date = r1_exp_date;
	}

	public String getR1_risk() {
		return r1_risk;
	}

	public void setR1_risk(String r1_risk) {
		this.r1_risk = r1_risk;
	}

	public String getR1_sub1() {
		return r1_sub1;
	}

	public void setR1_sub1(String r1_sub1) {
		this.r1_sub1 = r1_sub1;
	}

	public String getR1_sub2() {
		return r1_sub2;
	}

	public void setR1_sub2(String r1_sub2) {
		this.r1_sub2 = r1_sub2;
	}

	public Date getR1_last_date() {
		return r1_last_date;
	}

	public void setR1_last_date(Date r1_last_date) {
		this.r1_last_date = r1_last_date;
	}

	public String getR1_comments() {
		return r1_comments;
	}

	public void setR1_comments(String r1_comments) {
		this.r1_comments = r1_comments;
	}

	public String getR1_reserve1() {
		return r1_reserve1;
	}

	public void setR1_reserve1(String r1_reserve1) {
		this.r1_reserve1 = r1_reserve1;
	}

	public String getR1_reserve2() {
		return r1_reserve2;
	}

	public void setR1_reserve2(String r1_reserve2) {
		this.r1_reserve2 = r1_reserve2;
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

	public BRF301_entity(String r1_s_no, String r1_domain, String r1_description, String r1_receiver,
			String r1_material, String r1_cbuae, String r1_out_jobs, String r1_critical_jobs, String r1_third_parties,
			String r1_nature_data, String r1_service, String r1_vendor, String r1_country_reg, String r1_lei,
			String r1_company, String r1_country_service, String r1_country_data, String r1_gov_law,
			BigDecimal r1_annual_con, BigDecimal r1_total_con, Date r1_ser_date, Date r1_exp_date, String r1_risk,
			String r1_sub1, String r1_sub2, Date r1_last_date, String r1_comments, String r1_reserve1,
			String r1_reserve2, String entry_user, String modify_user, String verify_user, Date entry_time,
			Date modify_time, Date verify_time, Date report_date, Date report_from_date, Date report_to_date,
			String entity_flg, String modify_flg, String del_flg, String report_code, Date report_submit_date,
			String repdesc, String frequency) {
		super();
		this.r1_s_no = r1_s_no;
		this.r1_domain = r1_domain;
		this.r1_description = r1_description;
		this.r1_receiver = r1_receiver;
		this.r1_material = r1_material;
		this.r1_cbuae = r1_cbuae;
		this.r1_out_jobs = r1_out_jobs;
		this.r1_critical_jobs = r1_critical_jobs;
		this.r1_third_parties = r1_third_parties;
		this.r1_nature_data = r1_nature_data;
		this.r1_service = r1_service;
		this.r1_vendor = r1_vendor;
		this.r1_country_reg = r1_country_reg;
		this.r1_lei = r1_lei;
		this.r1_company = r1_company;
		this.r1_country_service = r1_country_service;
		this.r1_country_data = r1_country_data;
		this.r1_gov_law = r1_gov_law;
		this.r1_annual_con = r1_annual_con;
		this.r1_total_con = r1_total_con;
		this.r1_ser_date = r1_ser_date;
		this.r1_exp_date = r1_exp_date;
		this.r1_risk = r1_risk;
		this.r1_sub1 = r1_sub1;
		this.r1_sub2 = r1_sub2;
		this.r1_last_date = r1_last_date;
		this.r1_comments = r1_comments;
		this.r1_reserve1 = r1_reserve1;
		this.r1_reserve2 = r1_reserve2;
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

	public BRF301_entity() {
		super();
		// TODO Auto-generated constructor stub
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
		BRF301_entity other = (BRF301_entity) obj;
		return Objects.equals(r1_s_no, other.r1_s_no) && Objects.equals(report_date, other.report_date);
	}

	@Override
	public String toString() {
		return "BRF301_entity [r1_s_no=" + r1_s_no + ", r1_domain=" + r1_domain + ", r1_description=" + r1_description
				+ ", r1_receiver=" + r1_receiver + ", r1_material=" + r1_material + ", r1_cbuae=" + r1_cbuae
				+ ", r1_out_jobs=" + r1_out_jobs + ", r1_critical_jobs=" + r1_critical_jobs + ", r1_third_parties="
				+ r1_third_parties + ", r1_nature_data=" + r1_nature_data + ", r1_service=" + r1_service
				+ ", r1_vendor=" + r1_vendor + ", r1_country_reg=" + r1_country_reg + ", r1_lei=" + r1_lei
				+ ", r1_company=" + r1_company + ", r1_country_service=" + r1_country_service + ", r1_country_data="
				+ r1_country_data + ", r1_gov_law=" + r1_gov_law + ", r1_annual_con=" + r1_annual_con
				+ ", r1_total_con=" + r1_total_con + ", r1_ser_date=" + r1_ser_date + ", r1_exp_date=" + r1_exp_date
				+ ", r1_risk=" + r1_risk + ", r1_sub1=" + r1_sub1 + ", r1_sub2=" + r1_sub2 + ", r1_last_date="
				+ r1_last_date + ", r1_comments=" + r1_comments + ", r1_reserve1=" + r1_reserve1 + ", r1_reserve2="
				+ r1_reserve2 + ", entry_user=" + entry_user + ", modify_user=" + modify_user + ", verify_user="
				+ verify_user + ", entry_time=" + entry_time + ", modify_time=" + modify_time + ", verify_time="
				+ verify_time + ", report_date=" + report_date + ", report_from_date=" + report_from_date
				+ ", report_to_date=" + report_to_date + ", entity_flg=" + entity_flg + ", modify_flg=" + modify_flg
				+ ", del_flg=" + del_flg + ", report_code=" + report_code + ", report_submit_date=" + report_submit_date
				+ ", repdesc=" + repdesc + ", frequency=" + frequency + "]";
	}
}