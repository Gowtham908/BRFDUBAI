package com.bornfire.xbrl.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="BOB_RAM")


public class BOB_RAM_ENTITY {
	
	
	private String	status_2022;
	private String	status_2021;
	private String	status_2020;
	private String	status_2019;
	private String	status_2018;
	private String	status_2017;
	private String	status_2016;
	private String	status_2015;
	private String	status_2014;
	private String	status_2013;
	
	@Id
	private String	cust_id;
	private String	company_name;
	private String	branch_name;
	public String getStatus_2022() {
		return status_2022;
	}
	public void setStatus_2022(String status_2022) {
		this.status_2022 = status_2022;
	}
	public String getStatus_2021() {
		return status_2021;
	}
	public void setStatus_2021(String status_2021) {
		this.status_2021 = status_2021;
	}
	public String getStatus_2020() {
		return status_2020;
	}
	public void setStatus_2020(String status_2020) {
		this.status_2020 = status_2020;
	}
	public String getStatus_2019() {
		return status_2019;
	}
	public void setStatus_2019(String status_2019) {
		this.status_2019 = status_2019;
	}
	public String getStatus_2018() {
		return status_2018;
	}
	public void setStatus_2018(String status_2018) {
		this.status_2018 = status_2018;
	}
	public String getStatus_2017() {
		return status_2017;
	}
	public void setStatus_2017(String status_2017) {
		this.status_2017 = status_2017;
	}
	public String getStatus_2016() {
		return status_2016;
	}
	public void setStatus_2016(String status_2016) {
		this.status_2016 = status_2016;
	}
	public String getStatus_2015() {
		return status_2015;
	}
	public void setStatus_2015(String status_2015) {
		this.status_2015 = status_2015;
	}
	public String getStatus_2014() {
		return status_2014;
	}
	public void setStatus_2014(String status_2014) {
		this.status_2014 = status_2014;
	}
	public String getStatus_2013() {
		return status_2013;
	}
	public void setStatus_2013(String status_2013) {
		this.status_2013 = status_2013;
	}
	public String getCust_id() {
		return cust_id;
	}
	public void setCust_id(String cust_id) {
		this.cust_id = cust_id;
	}
	public String getCompany_name() {
		return company_name;
	}
	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}
	public String getBranch_name() {
		return branch_name;
	}
	public void setBranch_name(String branch_name) {
		this.branch_name = branch_name;
	}
	public BOB_RAM_ENTITY(String status_2022, String status_2021, String status_2020, String status_2019,
			String status_2018, String status_2017, String status_2016, String status_2015, String status_2014,
			String status_2013, String cust_id, String company_name, String branch_name) {
		super();
		this.status_2022 = status_2022;
		this.status_2021 = status_2021;
		this.status_2020 = status_2020;
		this.status_2019 = status_2019;
		this.status_2018 = status_2018;
		this.status_2017 = status_2017;
		this.status_2016 = status_2016;
		this.status_2015 = status_2015;
		this.status_2014 = status_2014;
		this.status_2013 = status_2013;
		this.cust_id = cust_id;
		this.company_name = company_name;
		this.branch_name = branch_name;
	}
	public BOB_RAM_ENTITY() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	


}
