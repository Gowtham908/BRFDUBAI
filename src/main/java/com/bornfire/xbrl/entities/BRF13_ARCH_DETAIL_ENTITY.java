package com.bornfire.xbrl.entities;

import java.math.BigDecimal;
import java.util.Date;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name="BRF13_ARCH_DETAIL")
public class BRF13_ARCH_DETAIL_ENTITY {
	
	private String	cust_id;
	@Id
	private String	foracid;
	private String	acct_name;
	private BigDecimal	act_balance_amt_lc;
	private String	report_name_1;
	private String	report_label_1;
	private String	report_addl_criteria_1;
	private String	report_addl_criteria_2;
	private String	report_addl_criteria_3;
	private String	create_user;
	private Date	create_time;
	private String	modify_user;
	private Date	modify_time;
	private String	verify_user;
	private Date	verify_time;
	private String	entity_flg;
	private String	modify_flg;
	private String	del_flg;
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date	report_date;
	private String	remarks;
	private String	version;
	
	
	public String getCust_id() {
		return cust_id;
	}
	public void setCust_id(String cust_id) {
		this.cust_id = cust_id;
	}
	public String getForacid() {
		return foracid;
	}
	public void setForacid(String foracid) {
		this.foracid = foracid;
	}
	public String getAcct_name() {
		return acct_name;
	}
	public void setAcct_name(String acct_name) {
		this.acct_name = acct_name;
	}
	public BigDecimal getAct_balance_amt_lc() {
		return act_balance_amt_lc;
	}
	public void setAct_balance_amt_lc(BigDecimal act_balance_amt_lc) {
		this.act_balance_amt_lc = act_balance_amt_lc;
	}
	public String getReport_name_1() {
		return report_name_1;
	}
	public void setReport_name_1(String report_name_1) {
		this.report_name_1 = report_name_1;
	}
	public String getReport_label_1() {
		return report_label_1;
	}
	public void setReport_label_1(String report_label_1) {
		this.report_label_1 = report_label_1;
	}
	public String getReport_addl_criteria_1() {
		return report_addl_criteria_1;
	}
	public void setReport_addl_criteria_1(String report_addl_criteria_1) {
		this.report_addl_criteria_1 = report_addl_criteria_1;
	}
	public String getReport_addl_criteria_2() {
		return report_addl_criteria_2;
	}
	public void setReport_addl_criteria_2(String report_addl_criteria_2) {
		this.report_addl_criteria_2 = report_addl_criteria_2;
	}
	public String getReport_addl_criteria_3() {
		return report_addl_criteria_3;
	}
	public void setReport_addl_criteria_3(String report_addl_criteria_3) {
		this.report_addl_criteria_3 = report_addl_criteria_3;
	}
	public String getCreate_user() {
		return create_user;
	}
	public void setCreate_user(String create_user) {
		this.create_user = create_user;
	}
	public Date getCreate_time() {
		return create_time;
	}
	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}
	public String getModify_user() {
		return modify_user;
	}
	public void setModify_user(String modify_user) {
		this.modify_user = modify_user;
	}
	public Date getModify_time() {
		return modify_time;
	}
	public void setModify_time(Date modify_time) {
		this.modify_time = modify_time;
	}
	public String getVerify_user() {
		return verify_user;
	}
	public void setVerify_user(String verify_user) {
		this.verify_user = verify_user;
	}
	public Date getVerify_time() {
		return verify_time;
	}
	public void setVerify_time(Date verify_time) {
		this.verify_time = verify_time;
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
	public Date getReport_date() {
		return report_date;
	}
	public void setReport_date(Date report_date) {
		this.report_date = report_date;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	
	public BRF13_ARCH_DETAIL_ENTITY(String cust_id, String foracid, String acct_name, BigDecimal act_balance_amt_lc,
			String report_name_1, String report_label_1, String report_addl_criteria_1, String report_addl_criteria_2,
			String report_addl_criteria_3, String create_user, Date create_time, String modify_user, Date modify_time,
			String verify_user, Date verify_time, String entity_flg, String modify_flg, String del_flg,
			Date report_date, String remarks, String version) {
		super();
		this.cust_id = cust_id;
		this.foracid = foracid;
		this.acct_name = acct_name;
		this.act_balance_amt_lc = act_balance_amt_lc;
		this.report_name_1 = report_name_1;
		this.report_label_1 = report_label_1;
		this.report_addl_criteria_1 = report_addl_criteria_1;
		this.report_addl_criteria_2 = report_addl_criteria_2;
		this.report_addl_criteria_3 = report_addl_criteria_3;
		this.create_user = create_user;
		this.create_time = create_time;
		this.modify_user = modify_user;
		this.modify_time = modify_time;
		this.verify_user = verify_user;
		this.verify_time = verify_time;
		this.entity_flg = entity_flg;
		this.modify_flg = modify_flg;
		this.del_flg = del_flg;
		this.report_date = report_date;
		this.remarks = remarks;
		this.version = version;
	
	}
	public BRF13_ARCH_DETAIL_ENTITY() {
		super();
	}
	
 

}
