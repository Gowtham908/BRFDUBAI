package com.bornfire.xbrl.entities.BRBS;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "BRF69_SUMMARYTABLE_D")
@IdClass(BRF069IDCLASS.class)
public class BRF069_SUMMARY_D_ENTITY {
	private String r5_col1;
	private String r5_col2;
	private String r5_col3;
	private String r5_col4;
	private String r5_col5;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date r5_col6;
	private String r5_col7;
	private String r5_col8;
	private String r5_col9;
	private String r5_col10;
	@Id
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date report_date;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date report_from_date;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date report_to_date;
	private String entity_flg;
	private String modify_flg;
	private String del_flg;
	private String report_code;
	private Date report_submit_date;
	@Id
	private String srl_no;
	private String entry_user;
	private String modify_user;
	private String verify_user;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date entry_time;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date modify_time;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date verify_time;
	private String repdesc;
	private String frequency;

	public String getR5_col1() {
		return r5_col1;
	}

	public String getR5_col2() {
		return r5_col2;
	}

	public String getR5_col3() {
		return r5_col3;
	}

	public String getR5_col4() {
		return r5_col4;
	}

	public String getR5_col5() {
		return r5_col5;
	}

	public Date getR5_col6() {
		return r5_col6;
	}

	public String getR5_col7() {
		return r5_col7;
	}

	public String getR5_col8() {
		return r5_col8;
	}

	public String getR5_col9() {
		return r5_col9;
	}

	public String getR5_col10() {
		return r5_col10;
	}

	public Date getReport_date() {
		return report_date;
	}

	public Date getReport_from_date() {
		return report_from_date;
	}

	public Date getReport_to_date() {
		return report_to_date;
	}

	public String getEntity_flg() {
		return entity_flg;
	}

	public String getModify_flg() {
		return modify_flg;
	}

	public String getDel_flg() {
		return del_flg;
	}

	public String getReport_code() {
		return report_code;
	}

	public Date getReport_submit_date() {
		return report_submit_date;
	}

	public String getSrl_no() {
		return srl_no;
	}

	public String getEntry_user() {
		return entry_user;
	}

	public String getModify_user() {
		return modify_user;
	}

	public String getVerify_user() {
		return verify_user;
	}

	public Date getEntry_time() {
		return entry_time;
	}

	public Date getModify_time() {
		return modify_time;
	}

	public Date getVerify_time() {
		return verify_time;
	}

	public String getRepdesc() {
		return repdesc;
	}

	public String getFrequency() {
		return frequency;
	}

	public void setR5_col1(String r5_col1) {
		this.r5_col1 = r5_col1;
	}

	public void setR5_col2(String r5_col2) {
		this.r5_col2 = r5_col2;
	}

	public void setR5_col3(String r5_col3) {
		this.r5_col3 = r5_col3;
	}

	public void setR5_col4(String r5_col4) {
		this.r5_col4 = r5_col4;
	}

	public void setR5_col5(String r5_col5) {
		this.r5_col5 = r5_col5;
	}

	public void setR5_col6(Date r5_col6) {
		this.r5_col6 = r5_col6;
	}

	public void setR5_col7(String r5_col7) {
		this.r5_col7 = r5_col7;
	}

	public void setR5_col8(String r5_col8) {
		this.r5_col8 = r5_col8;
	}

	public void setR5_col9(String r5_col9) {
		this.r5_col9 = r5_col9;
	}

	public void setR5_col10(String r5_col10) {
		this.r5_col10 = r5_col10;
	}

	public void setReport_date(Date report_date) {
		this.report_date = report_date;
	}

	public void setReport_from_date(Date report_from_date) {
		this.report_from_date = report_from_date;
	}

	public void setReport_to_date(Date report_to_date) {
		this.report_to_date = report_to_date;
	}

	public void setEntity_flg(String entity_flg) {
		this.entity_flg = entity_flg;
	}

	public void setModify_flg(String modify_flg) {
		this.modify_flg = modify_flg;
	}

	public void setDel_flg(String del_flg) {
		this.del_flg = del_flg;
	}

	public void setReport_code(String report_code) {
		this.report_code = report_code;
	}

	public void setReport_submit_date(Date report_submit_date) {
		this.report_submit_date = report_submit_date;
	}

	public void setSrl_no(String srl_no) {
		this.srl_no = srl_no;
	}

	public void setEntry_user(String entry_user) {
		this.entry_user = entry_user;
	}

	public void setModify_user(String modify_user) {
		this.modify_user = modify_user;
	}

	public void setVerify_user(String verify_user) {
		this.verify_user = verify_user;
	}

	public void setEntry_time(Date entry_time) {
		this.entry_time = entry_time;
	}

	public void setModify_time(Date modify_time) {
		this.modify_time = modify_time;
	}

	public void setVerify_time(Date verify_time) {
		this.verify_time = verify_time;
	}

	public void setRepdesc(String repdesc) {
		this.repdesc = repdesc;
	}

	public void setFrequency(String frequency) {
		this.frequency = frequency;
	}

	public BRF069_SUMMARY_D_ENTITY(String r5_col1, String r5_col2, String r5_col3, String r5_col4, String r5_col5,
			Date r5_col6, String r5_col7, String r5_col8, String r5_col9, String r5_col10, Date report_date,
			Date report_from_date, Date report_to_date, String entity_flg, String modify_flg, String del_flg,
			String report_code, Date report_submit_date, String srl_no, String entry_user, String modify_user,
			String verify_user, Date entry_time, Date modify_time, Date verify_time, String repdesc, String frequency) {
		super();
		this.r5_col1 = r5_col1;
		this.r5_col2 = r5_col2;
		this.r5_col3 = r5_col3;
		this.r5_col4 = r5_col4;
		this.r5_col5 = r5_col5;
		this.r5_col6 = r5_col6;
		this.r5_col7 = r5_col7;
		this.r5_col8 = r5_col8;
		this.r5_col9 = r5_col9;
		this.r5_col10 = r5_col10;
		this.report_date = report_date;
		this.report_from_date = report_from_date;
		this.report_to_date = report_to_date;
		this.entity_flg = entity_flg;
		this.modify_flg = modify_flg;
		this.del_flg = del_flg;
		this.report_code = report_code;
		this.report_submit_date = report_submit_date;
		this.srl_no = srl_no;
		this.entry_user = entry_user;
		this.modify_user = modify_user;
		this.verify_user = verify_user;
		this.entry_time = entry_time;
		this.modify_time = modify_time;
		this.verify_time = verify_time;
		this.repdesc = repdesc;
		this.frequency = frequency;
	}

	public BRF069_SUMMARY_D_ENTITY() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Object getValue() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String toString() {
		return "BRF069_SUMMARY_D_ENTITY [r5_col1=" + r5_col1 + ", r5_col2=" + r5_col2 + ", r5_col3=" + r5_col3
				+ ", r5_col4=" + r5_col4 + ", r5_col5=" + r5_col5 + ", r5_col6=" + r5_col6 + ", r5_col7=" + r5_col7
				+ ", r5_col8=" + r5_col8 + ", r5_col9=" + r5_col9 + ", r5_col10=" + r5_col10 + ", report_date="
				+ report_date + ", report_from_date=" + report_from_date + ", report_to_date=" + report_to_date
				+ ", entity_flg=" + entity_flg + ", modify_flg=" + modify_flg + ", del_flg=" + del_flg
				+ ", report_code=" + report_code + ", report_submit_date=" + report_submit_date + ", srl_no=" + srl_no
				+ ", entry_user=" + entry_user + ", modify_user=" + modify_user + ", verify_user=" + verify_user
				+ ", entry_time=" + entry_time + ", modify_time=" + modify_time + ", verify_time=" + verify_time
				+ ", repdesc=" + repdesc + ", frequency=" + frequency + "]";
	}
}
