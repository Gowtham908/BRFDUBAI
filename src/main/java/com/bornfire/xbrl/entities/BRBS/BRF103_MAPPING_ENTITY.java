package com.bornfire.xbrl.entities.BRBS;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "BRF103_MAPPING_TABLE")
public class BRF103_MAPPING_ENTITY extends BRF_MAPPING_PARENT{
	private String	acct_crncy_code;
	private String	acct_name;
	private String	acid;
	private String	bacid;
	private String	constitution_code;
	private String	constitution_desc;
	private String	country;
	private String	country_of_incorp;
	private Date	create_time;
	private String	create_user;
	private String	cust_id;
	private String	cust_type;
	private Character	del_flg;
	private Character	entity_flg;
	@Id
	private String	foracid;
	private String	gender;
	private String	gl_code;
	private String	gl_sub_head_code;
	private String	gl_sub_head_desc;
	private String	group_id;
	private BigDecimal	hni_networth;
	private String	legal_entity_type;
	private Date	maturity_date;
	private Character	modify_flg;
	private Date	modify_time;
	private String	modify_user;
	private Character	nre_flg;
	private Character	nre_status;
	private String	purpose_of_advn;
	private String	remarks;
	private String	report_addl_criteria_1;
	private String	report_addl_criteria_2;
	private String	report_addl_criteria_3;
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date	report_date;
	private String	report_label_1;
	private String	report_name_1;
	private String	schm_code;
	private String	schm_type;
	private String	sector;
	private String	sector_code;
	private String	segment;
	private String	sol_id;
	private String	sub_sector;
	private String	sub_segment;
	private String	turnover;
	private Date	verify_time;
	private String	verify_user;
	private String	version;
	public String getAcct_crncy_code() {
		return acct_crncy_code;
	}
	public void setAcct_crncy_code(String acct_crncy_code) {
		this.acct_crncy_code = acct_crncy_code;
	}
	public String getAcct_name() {
		return acct_name;
	}
	public void setAcct_name(String acct_name) {
		this.acct_name = acct_name;
	}
	public String getAcid() {
		return acid;
	}
	public void setAcid(String acid) {
		this.acid = acid;
	}
	public String getBacid() {
		return bacid;
	}
	public void setBacid(String bacid) {
		this.bacid = bacid;
	}
	public String getConstitution_code() {
		return constitution_code;
	}
	public void setConstitution_code(String constitution_code) {
		this.constitution_code = constitution_code;
	}
	public String getConstitution_desc() {
		return constitution_desc;
	}
	public void setConstitution_desc(String constitution_desc) {
		this.constitution_desc = constitution_desc;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getCountry_of_incorp() {
		return country_of_incorp;
	}
	public void setCountry_of_incorp(String country_of_incorp) {
		this.country_of_incorp = country_of_incorp;
	}
	public Date getCreate_time() {
		return create_time;
	}
	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}
	public String getCreate_user() {
		return create_user;
	}
	public void setCreate_user(String create_user) {
		this.create_user = create_user;
	}
	public String getCust_id() {
		return cust_id;
	}
	public void setCust_id(String cust_id) {
		this.cust_id = cust_id;
	}
	public String getCust_type() {
		return cust_type;
	}
	public void setCust_type(String cust_type) {
		this.cust_type = cust_type;
	}
	public Character getDel_flg() {
		return del_flg;
	}
	public void setDel_flg(Character del_flg) {
		this.del_flg = del_flg;
	}
	public Character getEntity_flg() {
		return entity_flg;
	}
	public void setEntity_flg(Character entity_flg) {
		this.entity_flg = entity_flg;
	}
	public String getForacid() {
		return foracid;
	}
	public void setForacid(String foracid) {
		this.foracid = foracid;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getGl_code() {
		return gl_code;
	}
	public void setGl_code(String gl_code) {
		this.gl_code = gl_code;
	}
	public String getGl_sub_head_code() {
		return gl_sub_head_code;
	}
	public void setGl_sub_head_code(String gl_sub_head_code) {
		this.gl_sub_head_code = gl_sub_head_code;
	}
	public String getGl_sub_head_desc() {
		return gl_sub_head_desc;
	}
	public void setGl_sub_head_desc(String gl_sub_head_desc) {
		this.gl_sub_head_desc = gl_sub_head_desc;
	}
	public String getGroup_id() {
		return group_id;
	}
	public void setGroup_id(String group_id) {
		this.group_id = group_id;
	}
	public BigDecimal getHni_networth() {
		return hni_networth;
	}
	public void setHni_networth(BigDecimal hni_networth) {
		this.hni_networth = hni_networth;
	}
	public String getLegal_entity_type() {
		return legal_entity_type;
	}
	public void setLegal_entity_type(String legal_entity_type) {
		this.legal_entity_type = legal_entity_type;
	}
	public Date getMaturity_date() {
		return maturity_date;
	}
	public void setMaturity_date(Date maturity_date) {
		this.maturity_date = maturity_date;
	}
	public Character getModify_flg() {
		return modify_flg;
	}
	public void setModify_flg(Character modify_flg) {
		this.modify_flg = modify_flg;
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
	public Character getNre_flg() {
		return nre_flg;
	}
	public void setNre_flg(Character nre_flg) {
		this.nre_flg = nre_flg;
	}
	public Character getNre_status() {
		return nre_status;
	}
	public void setNre_status(Character nre_status) {
		this.nre_status = nre_status;
	}
	public String getPurpose_of_advn() {
		return purpose_of_advn;
	}
	public void setPurpose_of_advn(String purpose_of_advn) {
		this.purpose_of_advn = purpose_of_advn;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
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
	public Date getReport_date() {
		return report_date;
	}
	public void setReport_date(Date report_date) {
		this.report_date = report_date;
	}
	public String getReport_label_1() {
		return report_label_1;
	}
	public void setReport_label_1(String report_label_1) {
		this.report_label_1 = report_label_1;
	}
	public String getReport_name_1() {
		return report_name_1;
	}
	public void setReport_name_1(String report_name_1) {
		this.report_name_1 = report_name_1;
	}
	public String getSchm_code() {
		return schm_code;
	}
	public void setSchm_code(String schm_code) {
		this.schm_code = schm_code;
	}
	public String getSchm_type() {
		return schm_type;
	}
	public void setSchm_type(String schm_type) {
		this.schm_type = schm_type;
	}
	public String getSector() {
		return sector;
	}
	public void setSector(String sector) {
		this.sector = sector;
	}
	public String getSector_code() {
		return sector_code;
	}
	public void setSector_code(String sector_code) {
		this.sector_code = sector_code;
	}
	public String getSegment() {
		return segment;
	}
	public void setSegment(String segment) {
		this.segment = segment;
	}
	public String getSol_id() {
		return sol_id;
	}
	public void setSol_id(String sol_id) {
		this.sol_id = sol_id;
	}
	public String getSub_sector() {
		return sub_sector;
	}
	public void setSub_sector(String sub_sector) {
		this.sub_sector = sub_sector;
	}
	public String getSub_segment() {
		return sub_segment;
	}
	public void setSub_segment(String sub_segment) {
		this.sub_segment = sub_segment;
	}
	public String getTurnover() {
		return turnover;
	}
	public void setTurnover(String turnover) {
		this.turnover = turnover;
	}
	public Date getVerify_time() {
		return verify_time;
	}
	public void setVerify_time(Date verify_time) {
		this.verify_time = verify_time;
	}
	public String getVerify_user() {
		return verify_user;
	}
	public void setVerify_user(String verify_user) {
		this.verify_user = verify_user;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	@Override
	public String toString() {
		return "BRF103_MAPPING_ENTITY [acct_crncy_code=" + acct_crncy_code + ", acct_name=" + acct_name + ", acid="
				+ acid + ", bacid=" + bacid + ", constitution_code=" + constitution_code + ", constitution_desc="
				+ constitution_desc + ", country=" + country + ", country_of_incorp=" + country_of_incorp
				+ ", create_time=" + create_time + ", create_user=" + create_user + ", cust_id=" + cust_id
				+ ", cust_type=" + cust_type + ", del_flg=" + del_flg + ", entity_flg=" + entity_flg + ", foracid="
				+ foracid + ", gender=" + gender + ", gl_code=" + gl_code + ", gl_sub_head_code=" + gl_sub_head_code
				+ ", gl_sub_head_desc=" + gl_sub_head_desc + ", group_id=" + group_id + ", hni_networth=" + hni_networth
				+ ", legal_entity_type=" + legal_entity_type + ", maturity_date=" + maturity_date + ", modify_flg="
				+ modify_flg + ", modify_time=" + modify_time + ", modify_user=" + modify_user + ", nre_flg=" + nre_flg
				+ ", nre_status=" + nre_status + ", purpose_of_advn=" + purpose_of_advn + ", remarks=" + remarks
				+ ", report_addl_criteria_1=" + report_addl_criteria_1 + ", report_addl_criteria_2="
				+ report_addl_criteria_2 + ", report_addl_criteria_3=" + report_addl_criteria_3 + ", report_date="
				+ report_date + ", report_label_1=" + report_label_1 + ", report_name_1=" + report_name_1
				+ ", schm_code=" + schm_code + ", schm_type=" + schm_type + ", sector=" + sector + ", sector_code="
				+ sector_code + ", segment=" + segment + ", sol_id=" + sol_id + ", sub_sector=" + sub_sector
				+ ", sub_segment=" + sub_segment + ", turnover=" + turnover + ", verify_time=" + verify_time
				+ ", verify_user=" + verify_user + ", version=" + version + ", getAcct_crncy_code()="
				+ getAcct_crncy_code() + ", getAcct_name()=" + getAcct_name() + ", getAcid()=" + getAcid()
				+ ", getBacid()=" + getBacid() + ", getConstitution_code()=" + getConstitution_code()
				+ ", getConstitution_desc()=" + getConstitution_desc() + ", getCountry()=" + getCountry()
				+ ", getCountry_of_incorp()=" + getCountry_of_incorp() + ", getCreate_time()=" + getCreate_time()
				+ ", getCreate_user()=" + getCreate_user() + ", getCust_id()=" + getCust_id() + ", getCust_type()="
				+ getCust_type() + ", getDel_flg()=" + getDel_flg() + ", getEntity_flg()=" + getEntity_flg()
				+ ", getForacid()=" + getForacid() + ", getGender()=" + getGender() + ", getGl_code()=" + getGl_code()
				+ ", getGl_sub_head_code()=" + getGl_sub_head_code() + ", getGl_sub_head_desc()="
				+ getGl_sub_head_desc() + ", getGroup_id()=" + getGroup_id() + ", getHni_networth()="
				+ getHni_networth() + ", getLegal_entity_type()=" + getLegal_entity_type() + ", getMaturity_date()="
				+ getMaturity_date() + ", getModify_flg()=" + getModify_flg() + ", getModify_time()=" + getModify_time()
				+ ", getModify_user()=" + getModify_user() + ", getNre_flg()=" + getNre_flg() + ", getNre_status()="
				+ getNre_status() + ", getPurpose_of_advn()=" + getPurpose_of_advn() + ", getRemarks()=" + getRemarks()
				+ ", getReport_addl_criteria_1()=" + getReport_addl_criteria_1() + ", getReport_addl_criteria_2()="
				+ getReport_addl_criteria_2() + ", getReport_addl_criteria_3()=" + getReport_addl_criteria_3()
				+ ", getReport_date()=" + getReport_date() + ", getReport_label_1()=" + getReport_label_1()
				+ ", getReport_name_1()=" + getReport_name_1() + ", getSchm_code()=" + getSchm_code()
				+ ", getSchm_type()=" + getSchm_type() + ", getSector()=" + getSector() + ", getSector_code()="
				+ getSector_code() + ", getSegment()=" + getSegment() + ", getSol_id()=" + getSol_id()
				+ ", getSub_sector()=" + getSub_sector() + ", getSub_segment()=" + getSub_segment() + ", getTurnover()="
				+ getTurnover() + ", getVerify_time()=" + getVerify_time() + ", getVerify_user()=" + getVerify_user()
				+ ", getVersion()=" + getVersion() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
	public BRF103_MAPPING_ENTITY(String cust_id, String foracid, String acct_name, String acct_crncy_code,
			String gl_code, String gl_sub_head_code, String gl_sub_head_desc, String country_of_incorp,
			String cust_type, String schm_code, String schm_type, String sol_id, String acid, String segment,
			String sub_segment, String sector, String sub_sector, String sector_code, String group_id,
			String constitution_code, String country, String legal_entity_type, String constitution_desc,
			String purpose_of_advn, BigDecimal hni_networth, String turnover, String bacid, String report_name_1,
			String report_label_1, String report_addl_criteria_1, String report_addl_criteria_2,
			String report_addl_criteria_3, String create_user, Date create_time, String modify_user, Date modify_time,
			String verify_user, Date verify_time, Character entity_flg, Character modify_flg, Character del_flg,
			Character nre_status, Date report_date, Date maturity_date, String gender, String version, String remarks,
			Character nre_flg, String acct_crncy_code2, String acct_name2, String acid2, String bacid2,
			String constitution_code2, String constitution_desc2, String country2, String country_of_incorp2,
			Date create_time2, String create_user2, String cust_id2, String cust_type2, Character del_flg2,
			Character entity_flg2, String foracid2, String gender2, String gl_code2, String gl_sub_head_code2,
			String gl_sub_head_desc2, String group_id2, BigDecimal hni_networth2, String legal_entity_type2,
			Date maturity_date2, Character modify_flg2, Date modify_time2, String modify_user2, Character nre_flg2,
			Character nre_status2, String purpose_of_advn2, String remarks2, String report_addl_criteria_12,
			String report_addl_criteria_22, String report_addl_criteria_32, Date report_date2, String report_label_12,
			String report_name_12, String schm_code2, String schm_type2, String sector2, String sector_code2,
			String segment2, String sol_id2, String sub_sector2, String sub_segment2, String turnover2,
			Date verify_time2, String verify_user2, String version2) {
		super(cust_id, foracid, acct_name, acct_crncy_code, gl_code, gl_sub_head_code, gl_sub_head_desc,
				country_of_incorp, cust_type, schm_code, schm_type, sol_id, acid, segment, sub_segment, sector,
				sub_sector, sector_code, group_id, constitution_code, country, legal_entity_type, constitution_desc,
				purpose_of_advn, hni_networth, turnover, bacid, report_name_1, report_label_1, report_addl_criteria_1,
				report_addl_criteria_2, report_addl_criteria_3, create_user, create_time, modify_user, modify_time,
				verify_user, verify_time, entity_flg, modify_flg, del_flg, nre_status, report_date, maturity_date,
				gender, version, remarks, nre_flg);
		acct_crncy_code = acct_crncy_code2;
		acct_name = acct_name2;
		acid = acid2;
		bacid = bacid2;
		constitution_code = constitution_code2;
		constitution_desc = constitution_desc2;
		country = country2;
		country_of_incorp = country_of_incorp2;
		create_time = create_time2;
		create_user = create_user2;
		cust_id = cust_id2;
		cust_type = cust_type2;
		del_flg = del_flg2;
		entity_flg = entity_flg2;
		foracid = foracid2;
		gender = gender2;
		gl_code = gl_code2;
		gl_sub_head_code = gl_sub_head_code2;
		gl_sub_head_desc = gl_sub_head_desc2;
		group_id = group_id2;
		hni_networth = hni_networth2;
		legal_entity_type = legal_entity_type2;
		maturity_date = maturity_date2;
		modify_flg = modify_flg2;
		modify_time = modify_time2;
		modify_user = modify_user2;
		nre_flg = nre_flg2;
		nre_status = nre_status2;
		purpose_of_advn = purpose_of_advn2;
		remarks = remarks2;
		report_addl_criteria_1 = report_addl_criteria_12;
		report_addl_criteria_2 = report_addl_criteria_22;
		report_addl_criteria_3 = report_addl_criteria_32;
		report_date = report_date2;
		report_label_1 = report_label_12;
		report_name_1 = report_name_12;
		schm_code = schm_code2;
		schm_type = schm_type2;
		sector = sector2;
		sector_code = sector_code2;
		segment = segment2;
		sol_id = sol_id2;
		sub_sector = sub_sector2;
		sub_segment = sub_segment2;
		turnover = turnover2;
		verify_time = verify_time2;
		verify_user = verify_user2;
		version = version2;
	}
	public BRF103_MAPPING_ENTITY() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
