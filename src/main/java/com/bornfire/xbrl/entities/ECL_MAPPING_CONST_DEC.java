package com.bornfire.xbrl.entities;


import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ECL_MAPPING_CUST_CONST_CODE")

public class ECL_MAPPING_CONST_DEC {
	@Id
    private String	cust_const_code;
	private String	constitution_desc;
	private String	major_portfolio_code;
	private String	second_level_portfolio_code;
	private Date	entry_time;
	private String	entryuser;
	private Date	modify_time;
	private String	modify_user;
	private String	rcre_user_id;
	private Date	rcre_time;
	private String	del_flg;
	private String	lchg_user_id;
	private Date	lchg_time;
	public String getCust_const_code() {
		return cust_const_code;
	}
	public void setCust_const_code(String cust_const_code) {
		this.cust_const_code = cust_const_code;
	}
	public String getConstitution_desc() {
		return constitution_desc;
	}
	public void setConstitution_desc(String constitution_desc) {
		this.constitution_desc = constitution_desc;
	}
	public String getMajor_portfolio_code() {
		return major_portfolio_code;
	}
	public void setMajor_portfolio_code(String major_portfolio_code) {
		this.major_portfolio_code = major_portfolio_code;
	}
	public String getSecond_level_portfolio_code() {
		return second_level_portfolio_code;
	}
	public void setSecond_level_portfolio_code(String second_level_portfolio_code) {
		this.second_level_portfolio_code = second_level_portfolio_code;
	}
	public Date getEntry_time() {
		return entry_time;
	}
	public void setEntry_time(Date entry_time) {
		this.entry_time = entry_time;
	}
	public String getEntryuser() {
		return entryuser;
	}
	public void setEntryuser(String entryuser) {
		this.entryuser = entryuser;
	}
	public Date getModify_time() {
		return modify_time;
	}
	public void setModify_time(Date modify_time) {
		this.modify_time = modify_time;
	}
	public String getModify_user() {
		return modify_user;
	}
	public void setModify_user(String modify_user) {
		this.modify_user = modify_user;
	}
	public String getRcre_user_id() {
		return rcre_user_id;
	}
	public void setRcre_user_id(String rcre_user_id) {
		this.rcre_user_id = rcre_user_id;
	}
	public Date getRcre_time() {
		return rcre_time;
	}
	public void setRcre_time(Date rcre_time) {
		this.rcre_time = rcre_time;
	}
	public String getDel_flg() {
		return del_flg;
	}
	public void setDel_flg(String del_flg) {
		this.del_flg = del_flg;
	}
	public String getLchg_user_id() {
		return lchg_user_id;
	}
	public void setLchg_user_id(String lchg_user_id) {
		this.lchg_user_id = lchg_user_id;
	}
	public Date getLchg_time() {
		return lchg_time;
	}
	public void setLchg_time(Date lchg_time) {
		this.lchg_time = lchg_time;
	}
	public ECL_MAPPING_CONST_DEC(String cust_const_code, String constitution_desc, String major_portfolio_code,
			String second_level_portfolio_code, Date entry_time, String entryuser, Date modify_time, String modify_user,
			String rcre_user_id, Date rcre_time, String del_flg, String lchg_user_id, Date lchg_time) {
		super();
		this.cust_const_code = cust_const_code;
		this.constitution_desc = constitution_desc;
		this.major_portfolio_code = major_portfolio_code;
		this.second_level_portfolio_code = second_level_portfolio_code;
		this.entry_time = entry_time;
		this.entryuser = entryuser;
		this.modify_time = modify_time;
		this.modify_user = modify_user;
		this.rcre_user_id = rcre_user_id;
		this.rcre_time = rcre_time;
		this.del_flg = del_flg;
		this.lchg_user_id = lchg_user_id;
		this.lchg_time = lchg_time;
	}
	public ECL_MAPPING_CONST_DEC() {
		super();
		// TODO Auto-generated constructor stub
	}

	

}
