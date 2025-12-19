package com.bornfire.xbrl.entities;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table (name="ECL_STATUS_TABLE")

public class ECL_STATUS_ENTITY {
	
	private String	sol_id;
	@Id
	private String	cust_id;
	private String	map_key;
	private String	company_name;
	
	private String	status;
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date	status_date;
	private String	year_2011;
	private String	year_2012;
	private String	year_2013;
	private String	year_2014;
	private String	year_2015;
	private String	year_2016;
	private String	year_2017;
	private String	year_2018;
	private String	year_2019;
	private String	year_2020;
	private String	year_2021;
	private String	year_2022;
	private String	year_2023;
	private String	year_2024;
	private String	year_2025;
	private String	year_2026;
	private String	year_2027;
	private String	year_2028;
	private String	year_2029;
	private String	year_2030;
	private String	remarks_1;
	private String	remarks_2;
	private String	del_flg;
	private String	upload_flg;
	private Date	upload_date;
	private String	entity_flg;
	private String	entry_user;
	private Date	entry_time;
	public String getSol_id() {
		return sol_id;
	}
	public void setSol_id(String sol_id) {
		this.sol_id = sol_id;
	}
	public String getCust_id() {
		return cust_id;
	}
	public void setCust_id(String cust_id) {
		this.cust_id = cust_id;
	}
	public String getMap_key() {
		return map_key;
	}
	public void setMap_key(String map_key) {
		this.map_key = map_key;
	}
	public String getCompany_name() {
		return company_name;
	}
	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getStatus_date() {
		return status_date;
	}
	public void setStatus_date(Date status_date) {
		this.status_date = status_date;
	}
	public String getYear_2011() {
		return year_2011;
	}
	public void setYear_2011(String year_2011) {
		this.year_2011 = year_2011;
	}
	public String getYear_2012() {
		return year_2012;
	}
	public void setYear_2012(String year_2012) {
		this.year_2012 = year_2012;
	}
	public String getYear_2013() {
		return year_2013;
	}
	public void setYear_2013(String year_2013) {
		this.year_2013 = year_2013;
	}
	public String getYear_2014() {
		return year_2014;
	}
	public void setYear_2014(String year_2014) {
		this.year_2014 = year_2014;
	}
	public String getYear_2015() {
		return year_2015;
	}
	public void setYear_2015(String year_2015) {
		this.year_2015 = year_2015;
	}
	public String getYear_2016() {
		return year_2016;
	}
	public void setYear_2016(String year_2016) {
		this.year_2016 = year_2016;
	}
	public String getYear_2017() {
		return year_2017;
	}
	public void setYear_2017(String year_2017) {
		this.year_2017 = year_2017;
	}
	public String getYear_2018() {
		return year_2018;
	}
	public void setYear_2018(String year_2018) {
		this.year_2018 = year_2018;
	}
	public String getYear_2019() {
		return year_2019;
	}
	public void setYear_2019(String year_2019) {
		this.year_2019 = year_2019;
	}
	public String getYear_2020() {
		return year_2020;
	}
	public void setYear_2020(String year_2020) {
		this.year_2020 = year_2020;
	}
	public String getYear_2021() {
		return year_2021;
	}
	public void setYear_2021(String year_2021) {
		this.year_2021 = year_2021;
	}
	public String getYear_2022() {
		return year_2022;
	}
	public void setYear_2022(String year_2022) {
		this.year_2022 = year_2022;
	}
	public String getYear_2023() {
		return year_2023;
	}
	public void setYear_2023(String year_2023) {
		this.year_2023 = year_2023;
	}
	public String getYear_2024() {
		return year_2024;
	}
	public void setYear_2024(String year_2024) {
		this.year_2024 = year_2024;
	}
	public String getYear_2025() {
		return year_2025;
	}
	public void setYear_2025(String year_2025) {
		this.year_2025 = year_2025;
	}
	public String getYear_2026() {
		return year_2026;
	}
	public void setYear_2026(String year_2026) {
		this.year_2026 = year_2026;
	}
	public String getYear_2027() {
		return year_2027;
	}
	public void setYear_2027(String year_2027) {
		this.year_2027 = year_2027;
	}
	public String getYear_2028() {
		return year_2028;
	}
	public void setYear_2028(String year_2028) {
		this.year_2028 = year_2028;
	}
	public String getYear_2029() {
		return year_2029;
	}
	public void setYear_2029(String year_2029) {
		this.year_2029 = year_2029;
	}
	public String getYear_2030() {
		return year_2030;
	}
	public void setYear_2030(String year_2030) {
		this.year_2030 = year_2030;
	}
	public String getRemarks_1() {
		return remarks_1;
	}
	public void setRemarks_1(String remarks_1) {
		this.remarks_1 = remarks_1;
	}
	public String getRemarks_2() {
		return remarks_2;
	}
	public void setRemarks_2(String remarks_2) {
		this.remarks_2 = remarks_2;
	}
	public String getDel_flg() {
		return del_flg;
	}
	public void setDel_flg(String del_flg) {
		this.del_flg = del_flg;
	}
	public String getUpload_flg() {
		return upload_flg;
	}
	public void setUpload_flg(String upload_flg) {
		this.upload_flg = upload_flg;
	}
	public Date getUpload_date() {
		return upload_date;
	}
	public void setUpload_date(Date upload_date) {
		this.upload_date = upload_date;
	}
	public String getEntity_flg() {
		return entity_flg;
	}
	public void setEntity_flg(String entity_flg) {
		this.entity_flg = entity_flg;
	}
	public String getEntry_user() {
		return entry_user;
	}
	public void setEntry_user(String entry_user) {
		this.entry_user = entry_user;
	}
	public Date getEntry_time() {
		return entry_time;
	}
	public void setEntry_time(Date entry_time) {
		this.entry_time = entry_time;
	}
	public ECL_STATUS_ENTITY(String sol_id, String cust_id, String map_key, String company_name, String status,
			Date status_date, String year_2011, String year_2012, String year_2013, String year_2014, String year_2015,
			String year_2016, String year_2017, String year_2018, String year_2019, String year_2020, String year_2021,
			String year_2022, String year_2023, String year_2024, String year_2025, String year_2026, String year_2027,
			String year_2028, String year_2029, String year_2030, String remarks_1, String remarks_2, String del_flg,
			String upload_flg, Date upload_date, String entity_flg, String entry_user, Date entry_time) {
		super();
		this.sol_id = sol_id;
		this.cust_id = cust_id;
		this.map_key = map_key;
		this.company_name = company_name;
		this.status = status;
		this.status_date = status_date;
		this.year_2011 = year_2011;
		this.year_2012 = year_2012;
		this.year_2013 = year_2013;
		this.year_2014 = year_2014;
		this.year_2015 = year_2015;
		this.year_2016 = year_2016;
		this.year_2017 = year_2017;
		this.year_2018 = year_2018;
		this.year_2019 = year_2019;
		this.year_2020 = year_2020;
		this.year_2021 = year_2021;
		this.year_2022 = year_2022;
		this.year_2023 = year_2023;
		this.year_2024 = year_2024;
		this.year_2025 = year_2025;
		this.year_2026 = year_2026;
		this.year_2027 = year_2027;
		this.year_2028 = year_2028;
		this.year_2029 = year_2029;
		this.year_2030 = year_2030;
		this.remarks_1 = remarks_1;
		this.remarks_2 = remarks_2;
		this.del_flg = del_flg;
		this.upload_flg = upload_flg;
		this.upload_date = upload_date;
		this.entity_flg = entity_flg;
		this.entry_user = entry_user;
		this.entry_time = entry_time;
	}
	public ECL_STATUS_ENTITY() {
		super();
		// TODO Auto-generated constructor stub
	}
	


	
}
