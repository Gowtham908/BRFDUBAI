package com.bornfire.xbrl.entities.BRBS;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
@Entity
@Table(name="ECL_BRF107_DETAIL_TABLE")

public class BRF107_DETAIL_ENTITY{
	@Id
	private String	cust_id;
	private String	cust_name;
	private String	branch_name;
	private String	productname;
	private String	currency;
	private BigDecimal	drawnamount;
	private BigDecimal	undrawnamount;
	private BigDecimal	ead;
	private Date	report_date;
	private Date	maturitydate;
	private String	weighted_pd;
	private BigDecimal	finalweightedecl;
	private BigDecimal	ecl_incul_deferral;
	private BigDecimal	ecl_mgmt_overlay;
	private BigDecimal	specific_provision;
	private BigDecimal	interest_suspense;
	private String	country;
	private String	brf_1_classification;
	private String	brf_107;
	private String	basel_2_category;
	private String	provision_coverage;
	private String	mgmtoverlay;
	private BigDecimal	total_rwa;
	private String	report_lable;
	private String	report_addl_criteria1;
	private String	report_addl_criteria2;
	private String	facilityid;
	public String getCust_id() {
		return cust_id;
	}
	public void setCust_id(String cust_id) {
		this.cust_id = cust_id;
	}
	public String getCust_name() {
		return cust_name;
	}
	public void setCust_name(String cust_name) {
		this.cust_name = cust_name;
	}
	public String getBranch_name() {
		return branch_name;
	}
	public void setBranch_name(String branch_name) {
		this.branch_name = branch_name;
	}
	public String getProductname() {
		return productname;
	}
	public void setProductname(String productname) {
		this.productname = productname;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public BigDecimal getDrawnamount() {
		return drawnamount;
	}
	public void setDrawnamount(BigDecimal drawnamount) {
		this.drawnamount = drawnamount;
	}
	public BigDecimal getUndrawnamount() {
		return undrawnamount;
	}
	public void setUndrawnamount(BigDecimal undrawnamount) {
		this.undrawnamount = undrawnamount;
	}
	public BigDecimal getEad() {
		return ead;
	}
	public void setEad(BigDecimal ead) {
		this.ead = ead;
	}
	public Date getReport_date() {
		return report_date;
	}
	public void setReport_date(Date report_date) {
		this.report_date = report_date;
	}
	public Date getMaturitydate() {
		return maturitydate;
	}
	public void setMaturitydate(Date maturitydate) {
		this.maturitydate = maturitydate;
	}
	public String getWeighted_pd() {
		return weighted_pd;
	}
	public void setWeighted_pd(String weighted_pd) {
		this.weighted_pd = weighted_pd;
	}
	public BigDecimal getFinalweightedecl() {
		return finalweightedecl;
	}
	public void setFinalweightedecl(BigDecimal finalweightedecl) {
		this.finalweightedecl = finalweightedecl;
	}
	public BigDecimal getEcl_incul_deferral() {
		return ecl_incul_deferral;
	}
	public void setEcl_incul_deferral(BigDecimal ecl_incul_deferral) {
		this.ecl_incul_deferral = ecl_incul_deferral;
	}
	public BigDecimal getEcl_mgmt_overlay() {
		return ecl_mgmt_overlay;
	}
	public void setEcl_mgmt_overlay(BigDecimal ecl_mgmt_overlay) {
		this.ecl_mgmt_overlay = ecl_mgmt_overlay;
	}
	public BigDecimal getSpecific_provision() {
		return specific_provision;
	}
	public void setSpecific_provision(BigDecimal specific_provision) {
		this.specific_provision = specific_provision;
	}
	public BigDecimal getInterest_suspense() {
		return interest_suspense;
	}
	public void setInterest_suspense(BigDecimal interest_suspense) {
		this.interest_suspense = interest_suspense;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getBrf_1_classification() {
		return brf_1_classification;
	}
	public void setBrf_1_classification(String brf_1_classification) {
		this.brf_1_classification = brf_1_classification;
	}
	public String getBrf_107() {
		return brf_107;
	}
	public void setBrf_107(String brf_107) {
		this.brf_107 = brf_107;
	}
	public String getBasel_2_category() {
		return basel_2_category;
	}
	public void setBasel_2_category(String basel_2_category) {
		this.basel_2_category = basel_2_category;
	}
	public String getProvision_coverage() {
		return provision_coverage;
	}
	public void setProvision_coverage(String provision_coverage) {
		this.provision_coverage = provision_coverage;
	}
	public String getMgmtoverlay() {
		return mgmtoverlay;
	}
	public void setMgmtoverlay(String mgmtoverlay) {
		this.mgmtoverlay = mgmtoverlay;
	}
	public BigDecimal getTotal_rwa() {
		return total_rwa;
	}
	public void setTotal_rwa(BigDecimal total_rwa) {
		this.total_rwa = total_rwa;
	}
	public String getReport_lable() {
		return report_lable;
	}
	public void setReport_lable(String report_lable) {
		this.report_lable = report_lable;
	}
	public String getReport_addl_criteria1() {
		return report_addl_criteria1;
	}
	public void setReport_addl_criteria1(String report_addl_criteria1) {
		this.report_addl_criteria1 = report_addl_criteria1;
	}
	public String getReport_addl_criteria2() {
		return report_addl_criteria2;
	}
	public void setReport_addl_criteria2(String report_addl_criteria2) {
		this.report_addl_criteria2 = report_addl_criteria2;
	}
	public String getFacilityid() {
		return facilityid;
	}
	public void setFacilityid(String facilityid) {
		this.facilityid = facilityid;
	}
	public BRF107_DETAIL_ENTITY(String cust_id, String cust_name, String branch_name, String productname,
			String currency, BigDecimal drawnamount, BigDecimal undrawnamount, BigDecimal ead, Date report_date,
			Date maturitydate, String weighted_pd, BigDecimal finalweightedecl, BigDecimal ecl_incul_deferral,
			BigDecimal ecl_mgmt_overlay, BigDecimal specific_provision, BigDecimal interest_suspense, String country,
			String brf_1_classification, String brf_107, String basel_2_category, String provision_coverage,
			String mgmtoverlay, BigDecimal total_rwa, String report_lable, String report_addl_criteria1,
			String report_addl_criteria2, String facilityid) {
		super();
		this.cust_id = cust_id;
		this.cust_name = cust_name;
		this.branch_name = branch_name;
		this.productname = productname;
		this.currency = currency;
		this.drawnamount = drawnamount;
		this.undrawnamount = undrawnamount;
		this.ead = ead;
		this.report_date = report_date;
		this.maturitydate = maturitydate;
		this.weighted_pd = weighted_pd;
		this.finalweightedecl = finalweightedecl;
		this.ecl_incul_deferral = ecl_incul_deferral;
		this.ecl_mgmt_overlay = ecl_mgmt_overlay;
		this.specific_provision = specific_provision;
		this.interest_suspense = interest_suspense;
		this.country = country;
		this.brf_1_classification = brf_1_classification;
		this.brf_107 = brf_107;
		this.basel_2_category = basel_2_category;
		this.provision_coverage = provision_coverage;
		this.mgmtoverlay = mgmtoverlay;
		this.total_rwa = total_rwa;
		this.report_lable = report_lable;
		this.report_addl_criteria1 = report_addl_criteria1;
		this.report_addl_criteria2 = report_addl_criteria2;
		this.facilityid = facilityid;
	}
	public BRF107_DETAIL_ENTITY() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
}