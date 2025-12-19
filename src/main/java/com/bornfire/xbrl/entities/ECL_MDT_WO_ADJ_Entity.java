package com.bornfire.xbrl.entities;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="ECL_MASTER_DATA_WO_ADJ1")
public class ECL_MDT_WO_ADJ_Entity {


	private String	sol_id;
	@Id
	private String	cust_id;
	private String	map_key;
	private String	cust_name;
	private String	nature_asset_desc;
	private String	activity;
	@DateTimeFormat(pattern="dd-MM-yyyy")
	private Date	disbursement_date;
	@DateTimeFormat(pattern="dd-MM-yyyy")
	private Date	npa_date;
	private BigDecimal	limit_sanctioned;
	private String	int_rate;
	private BigDecimal	coll_cash_security;
	private BigDecimal	coll_non_crm_security;
	private BigDecimal	pri_cash_security;
	private BigDecimal	pri_non_crm_security;
	private BigDecimal	osbal_npa_date;
	private BigDecimal	write_off_amount;
	@DateTimeFormat(pattern="dd-MM-yyyy")
	private Date	write_off_date;
	private BigDecimal	dec_2013;
	private BigDecimal	mar_2014;
	private BigDecimal	jun_2014;
	private BigDecimal	sep_2014;
	private BigDecimal	dec_2014;
	private BigDecimal	mar_2015;
	private BigDecimal	jun_2015;
	private BigDecimal	sep_2015;
	private BigDecimal	dec_2015;
	private BigDecimal	mar_2016;
	private BigDecimal	jun_2016;
	private BigDecimal	sep_2016;
	private BigDecimal	dec_2016;
	private BigDecimal	mar_2017;
	private BigDecimal	jun_2017;
	private BigDecimal	sep_2017;
	private BigDecimal	dec_2017;
	private BigDecimal	mar_2018;
	private BigDecimal	jun_2018;
	private BigDecimal	sep_2018;
	private BigDecimal	dec_2018;
	private BigDecimal	mar_2019;
	private BigDecimal	jun_2019;
	private BigDecimal	sep_2019;
	private BigDecimal	dec_2019;
	private BigDecimal	mar_2020;
	private BigDecimal	jun_2020;
	private BigDecimal	sep_2020;
	private BigDecimal	dec_2020;
	private BigDecimal	mar_2021;
	private BigDecimal	jun_2021;
	private BigDecimal	sep_2021;
	private BigDecimal	dec_2021;
	private BigDecimal	mar_2022;
	private BigDecimal	jun_2022;
	private BigDecimal	sep_2022;
	private BigDecimal	dec_2022;
	private String	remarks_1;
	private BigDecimal	mar_2023;
	private BigDecimal	jun_2023;
	private BigDecimal	sep_2023;
	private BigDecimal	dec_2023;
	private BigDecimal	mar_2024;
	private BigDecimal	jun_2024;
	private BigDecimal	sep_2024;
	private BigDecimal	dec_2024;
	private BigDecimal	mar_2025;
	private BigDecimal	jun_2025;
	private BigDecimal	sep_2025;
	private BigDecimal	dec_2025;
	private BigDecimal	mar_2026;
	private BigDecimal	jun_2026;
	private BigDecimal	sep_2026;
	private BigDecimal	dec_2026;
	private BigDecimal	mar_2027;
	private BigDecimal	jun_2027;
	private BigDecimal	sep_2027;
	private BigDecimal	dec_2027;
	private BigDecimal	mar_2028;
	private BigDecimal	jun_2028;
	private BigDecimal	sep_2028;
	private BigDecimal	dec_2028;
	private BigDecimal	mar_2029;
	private BigDecimal	jun_2029;
	private BigDecimal	sep_2029;
	private BigDecimal	dec_2029;
	private BigDecimal	mar_2030;
	private BigDecimal	jun_2030;
	private BigDecimal	sep_2030;
	private BigDecimal	dec_2030;
	private BigDecimal	mar_2031;
	private BigDecimal	jun_2031;
	private BigDecimal	sep_2031;
	private BigDecimal	dec_2031;
	private String	status;
	@DateTimeFormat(pattern="dd-MM-yyyy")
	private Date	status_date;
	private String	remarks_2;
	private String	remarks_3;
	private String	del_flg;
	private String	upload_flg;
	@DateTimeFormat(pattern="dd-MM-yyyy")
	private Date	upload_date;
	private String	entity_flg;
	private String	entry_user;
	@DateTimeFormat(pattern="dd-MM-yyyy")
	private Date	entry_time;
	private String	modify_user;
	@DateTimeFormat(pattern="dd-MM-yyyy")
	private Date	modify_time;
	private String	verify_user;
	@DateTimeFormat(pattern="dd-MM-yyyy")
	private Date	verify_time;
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
	public String getCust_name() {
		return cust_name;
	}
	public void setCust_name(String cust_name) {
		this.cust_name = cust_name;
	}
	public String getNature_asset_desc() {
		return nature_asset_desc;
	}
	public void setNature_asset_desc(String nature_asset_desc) {
		this.nature_asset_desc = nature_asset_desc;
	}
	public String getActivity() {
		return activity;
	}
	public void setActivity(String activity) {
		this.activity = activity;
	}
	public Date getDisbursement_date() {
		return disbursement_date;
	}
	public void setDisbursement_date(Date disbursement_date) {
		this.disbursement_date = disbursement_date;
	}
	public Date getNpa_date() {
		return npa_date;
	}
	public void setNpa_date(Date npa_date) {
		this.npa_date = npa_date;
	}
	public BigDecimal getLimit_sanctioned() {
		return limit_sanctioned;
	}
	public void setLimit_sanctioned(BigDecimal limit_sanctioned) {
		this.limit_sanctioned = limit_sanctioned;
	}
	public String getInt_rate() {
		return int_rate;
	}
	public void setInt_rate(String int_rate) {
		this.int_rate = int_rate;
	}
	public BigDecimal getColl_cash_security() {
		return coll_cash_security;
	}
	public void setColl_cash_security(BigDecimal coll_cash_security) {
		this.coll_cash_security = coll_cash_security;
	}
	public BigDecimal getColl_non_crm_security() {
		return coll_non_crm_security;
	}
	public void setColl_non_crm_security(BigDecimal coll_non_crm_security) {
		this.coll_non_crm_security = coll_non_crm_security;
	}
	public BigDecimal getPri_cash_security() {
		return pri_cash_security;
	}
	public void setPri_cash_security(BigDecimal pri_cash_security) {
		this.pri_cash_security = pri_cash_security;
	}
	public BigDecimal getPri_non_crm_security() {
		return pri_non_crm_security;
	}
	public void setPri_non_crm_security(BigDecimal pri_non_crm_security) {
		this.pri_non_crm_security = pri_non_crm_security;
	}
	public BigDecimal getOsbal_npa_date() {
		return osbal_npa_date;
	}
	public void setOsbal_npa_date(BigDecimal osbal_npa_date) {
		this.osbal_npa_date = osbal_npa_date;
	}
	public BigDecimal getWrite_off_amount() {
		return write_off_amount;
	}
	public void setWrite_off_amount(BigDecimal write_off_amount) {
		this.write_off_amount = write_off_amount;
	}
	public Date getWrite_off_date() {
		return write_off_date;
	}
	public void setWrite_off_date(Date write_off_date) {
		this.write_off_date = write_off_date;
	}
	public BigDecimal getDec_2013() {
		return dec_2013;
	}
	public void setDec_2013(BigDecimal dec_2013) {
		this.dec_2013 = dec_2013;
	}
	public BigDecimal getMar_2014() {
		return mar_2014;
	}
	public void setMar_2014(BigDecimal mar_2014) {
		this.mar_2014 = mar_2014;
	}
	public BigDecimal getJun_2014() {
		return jun_2014;
	}
	public void setJun_2014(BigDecimal jun_2014) {
		this.jun_2014 = jun_2014;
	}
	public BigDecimal getSep_2014() {
		return sep_2014;
	}
	public void setSep_2014(BigDecimal sep_2014) {
		this.sep_2014 = sep_2014;
	}
	public BigDecimal getDec_2014() {
		return dec_2014;
	}
	public void setDec_2014(BigDecimal dec_2014) {
		this.dec_2014 = dec_2014;
	}
	public BigDecimal getMar_2015() {
		return mar_2015;
	}
	public void setMar_2015(BigDecimal mar_2015) {
		this.mar_2015 = mar_2015;
	}
	public BigDecimal getJun_2015() {
		return jun_2015;
	}
	public void setJun_2015(BigDecimal jun_2015) {
		this.jun_2015 = jun_2015;
	}
	public BigDecimal getSep_2015() {
		return sep_2015;
	}
	public void setSep_2015(BigDecimal sep_2015) {
		this.sep_2015 = sep_2015;
	}
	public BigDecimal getDec_2015() {
		return dec_2015;
	}
	public void setDec_2015(BigDecimal dec_2015) {
		this.dec_2015 = dec_2015;
	}
	public BigDecimal getMar_2016() {
		return mar_2016;
	}
	public void setMar_2016(BigDecimal mar_2016) {
		this.mar_2016 = mar_2016;
	}
	public BigDecimal getJun_2016() {
		return jun_2016;
	}
	public void setJun_2016(BigDecimal jun_2016) {
		this.jun_2016 = jun_2016;
	}
	public BigDecimal getSep_2016() {
		return sep_2016;
	}
	public void setSep_2016(BigDecimal sep_2016) {
		this.sep_2016 = sep_2016;
	}
	public BigDecimal getDec_2016() {
		return dec_2016;
	}
	public void setDec_2016(BigDecimal dec_2016) {
		this.dec_2016 = dec_2016;
	}
	public BigDecimal getMar_2017() {
		return mar_2017;
	}
	public void setMar_2017(BigDecimal mar_2017) {
		this.mar_2017 = mar_2017;
	}
	public BigDecimal getJun_2017() {
		return jun_2017;
	}
	public void setJun_2017(BigDecimal jun_2017) {
		this.jun_2017 = jun_2017;
	}
	public BigDecimal getSep_2017() {
		return sep_2017;
	}
	public void setSep_2017(BigDecimal sep_2017) {
		this.sep_2017 = sep_2017;
	}
	public BigDecimal getDec_2017() {
		return dec_2017;
	}
	public void setDec_2017(BigDecimal dec_2017) {
		this.dec_2017 = dec_2017;
	}
	public BigDecimal getMar_2018() {
		return mar_2018;
	}
	public void setMar_2018(BigDecimal mar_2018) {
		this.mar_2018 = mar_2018;
	}
	public BigDecimal getJun_2018() {
		return jun_2018;
	}
	public void setJun_2018(BigDecimal jun_2018) {
		this.jun_2018 = jun_2018;
	}
	public BigDecimal getSep_2018() {
		return sep_2018;
	}
	public void setSep_2018(BigDecimal sep_2018) {
		this.sep_2018 = sep_2018;
	}
	public BigDecimal getDec_2018() {
		return dec_2018;
	}
	public void setDec_2018(BigDecimal dec_2018) {
		this.dec_2018 = dec_2018;
	}
	public BigDecimal getMar_2019() {
		return mar_2019;
	}
	public void setMar_2019(BigDecimal mar_2019) {
		this.mar_2019 = mar_2019;
	}
	public BigDecimal getJun_2019() {
		return jun_2019;
	}
	public void setJun_2019(BigDecimal jun_2019) {
		this.jun_2019 = jun_2019;
	}
	public BigDecimal getSep_2019() {
		return sep_2019;
	}
	public void setSep_2019(BigDecimal sep_2019) {
		this.sep_2019 = sep_2019;
	}
	public BigDecimal getDec_2019() {
		return dec_2019;
	}
	public void setDec_2019(BigDecimal dec_2019) {
		this.dec_2019 = dec_2019;
	}
	public BigDecimal getMar_2020() {
		return mar_2020;
	}
	public void setMar_2020(BigDecimal mar_2020) {
		this.mar_2020 = mar_2020;
	}
	public BigDecimal getJun_2020() {
		return jun_2020;
	}
	public void setJun_2020(BigDecimal jun_2020) {
		this.jun_2020 = jun_2020;
	}
	public BigDecimal getSep_2020() {
		return sep_2020;
	}
	public void setSep_2020(BigDecimal sep_2020) {
		this.sep_2020 = sep_2020;
	}
	public BigDecimal getDec_2020() {
		return dec_2020;
	}
	public void setDec_2020(BigDecimal dec_2020) {
		this.dec_2020 = dec_2020;
	}
	public BigDecimal getMar_2021() {
		return mar_2021;
	}
	public void setMar_2021(BigDecimal mar_2021) {
		this.mar_2021 = mar_2021;
	}
	public BigDecimal getJun_2021() {
		return jun_2021;
	}
	public void setJun_2021(BigDecimal jun_2021) {
		this.jun_2021 = jun_2021;
	}
	public BigDecimal getSep_2021() {
		return sep_2021;
	}
	public void setSep_2021(BigDecimal sep_2021) {
		this.sep_2021 = sep_2021;
	}
	public BigDecimal getDec_2021() {
		return dec_2021;
	}
	public void setDec_2021(BigDecimal dec_2021) {
		this.dec_2021 = dec_2021;
	}
	public BigDecimal getMar_2022() {
		return mar_2022;
	}
	public void setMar_2022(BigDecimal mar_2022) {
		this.mar_2022 = mar_2022;
	}
	public BigDecimal getJun_2022() {
		return jun_2022;
	}
	public void setJun_2022(BigDecimal jun_2022) {
		this.jun_2022 = jun_2022;
	}
	public BigDecimal getSep_2022() {
		return sep_2022;
	}
	public void setSep_2022(BigDecimal sep_2022) {
		this.sep_2022 = sep_2022;
	}
	public BigDecimal getDec_2022() {
		return dec_2022;
	}
	public void setDec_2022(BigDecimal dec_2022) {
		this.dec_2022 = dec_2022;
	}
	public String getRemarks_1() {
		return remarks_1;
	}
	public void setRemarks_1(String remarks_1) {
		this.remarks_1 = remarks_1;
	}
	public BigDecimal getMar_2023() {
		return mar_2023;
	}
	public void setMar_2023(BigDecimal mar_2023) {
		this.mar_2023 = mar_2023;
	}
	public BigDecimal getJun_2023() {
		return jun_2023;
	}
	public void setJun_2023(BigDecimal jun_2023) {
		this.jun_2023 = jun_2023;
	}
	public BigDecimal getSep_2023() {
		return sep_2023;
	}
	public void setSep_2023(BigDecimal sep_2023) {
		this.sep_2023 = sep_2023;
	}
	public BigDecimal getDec_2023() {
		return dec_2023;
	}
	public void setDec_2023(BigDecimal dec_2023) {
		this.dec_2023 = dec_2023;
	}
	public BigDecimal getMar_2024() {
		return mar_2024;
	}
	public void setMar_2024(BigDecimal mar_2024) {
		this.mar_2024 = mar_2024;
	}
	public BigDecimal getJun_2024() {
		return jun_2024;
	}
	public void setJun_2024(BigDecimal jun_2024) {
		this.jun_2024 = jun_2024;
	}
	public BigDecimal getSep_2024() {
		return sep_2024;
	}
	public void setSep_2024(BigDecimal sep_2024) {
		this.sep_2024 = sep_2024;
	}
	public BigDecimal getDec_2024() {
		return dec_2024;
	}
	public void setDec_2024(BigDecimal dec_2024) {
		this.dec_2024 = dec_2024;
	}
	public BigDecimal getMar_2025() {
		return mar_2025;
	}
	public void setMar_2025(BigDecimal mar_2025) {
		this.mar_2025 = mar_2025;
	}
	public BigDecimal getJun_2025() {
		return jun_2025;
	}
	public void setJun_2025(BigDecimal jun_2025) {
		this.jun_2025 = jun_2025;
	}
	public BigDecimal getSep_2025() {
		return sep_2025;
	}
	public void setSep_2025(BigDecimal sep_2025) {
		this.sep_2025 = sep_2025;
	}
	public BigDecimal getDec_2025() {
		return dec_2025;
	}
	public void setDec_2025(BigDecimal dec_2025) {
		this.dec_2025 = dec_2025;
	}
	public BigDecimal getMar_2026() {
		return mar_2026;
	}
	public void setMar_2026(BigDecimal mar_2026) {
		this.mar_2026 = mar_2026;
	}
	public BigDecimal getJun_2026() {
		return jun_2026;
	}
	public void setJun_2026(BigDecimal jun_2026) {
		this.jun_2026 = jun_2026;
	}
	public BigDecimal getSep_2026() {
		return sep_2026;
	}
	public void setSep_2026(BigDecimal sep_2026) {
		this.sep_2026 = sep_2026;
	}
	public BigDecimal getDec_2026() {
		return dec_2026;
	}
	public void setDec_2026(BigDecimal dec_2026) {
		this.dec_2026 = dec_2026;
	}
	public BigDecimal getMar_2027() {
		return mar_2027;
	}
	public void setMar_2027(BigDecimal mar_2027) {
		this.mar_2027 = mar_2027;
	}
	public BigDecimal getJun_2027() {
		return jun_2027;
	}
	public void setJun_2027(BigDecimal jun_2027) {
		this.jun_2027 = jun_2027;
	}
	public BigDecimal getSep_2027() {
		return sep_2027;
	}
	public void setSep_2027(BigDecimal sep_2027) {
		this.sep_2027 = sep_2027;
	}
	public BigDecimal getDec_2027() {
		return dec_2027;
	}
	public void setDec_2027(BigDecimal dec_2027) {
		this.dec_2027 = dec_2027;
	}
	public BigDecimal getMar_2028() {
		return mar_2028;
	}
	public void setMar_2028(BigDecimal mar_2028) {
		this.mar_2028 = mar_2028;
	}
	public BigDecimal getJun_2028() {
		return jun_2028;
	}
	public void setJun_2028(BigDecimal jun_2028) {
		this.jun_2028 = jun_2028;
	}
	public BigDecimal getSep_2028() {
		return sep_2028;
	}
	public void setSep_2028(BigDecimal sep_2028) {
		this.sep_2028 = sep_2028;
	}
	public BigDecimal getDec_2028() {
		return dec_2028;
	}
	public void setDec_2028(BigDecimal dec_2028) {
		this.dec_2028 = dec_2028;
	}
	public BigDecimal getMar_2029() {
		return mar_2029;
	}
	public void setMar_2029(BigDecimal mar_2029) {
		this.mar_2029 = mar_2029;
	}
	public BigDecimal getJun_2029() {
		return jun_2029;
	}
	public void setJun_2029(BigDecimal jun_2029) {
		this.jun_2029 = jun_2029;
	}
	public BigDecimal getSep_2029() {
		return sep_2029;
	}
	public void setSep_2029(BigDecimal sep_2029) {
		this.sep_2029 = sep_2029;
	}
	public BigDecimal getDec_2029() {
		return dec_2029;
	}
	public void setDec_2029(BigDecimal dec_2029) {
		this.dec_2029 = dec_2029;
	}
	public BigDecimal getMar_2030() {
		return mar_2030;
	}
	public void setMar_2030(BigDecimal mar_2030) {
		this.mar_2030 = mar_2030;
	}
	public BigDecimal getJun_2030() {
		return jun_2030;
	}
	public void setJun_2030(BigDecimal jun_2030) {
		this.jun_2030 = jun_2030;
	}
	public BigDecimal getSep_2030() {
		return sep_2030;
	}
	public void setSep_2030(BigDecimal sep_2030) {
		this.sep_2030 = sep_2030;
	}
	public BigDecimal getDec_2030() {
		return dec_2030;
	}
	public void setDec_2030(BigDecimal dec_2030) {
		this.dec_2030 = dec_2030;
	}
	public BigDecimal getMar_2031() {
		return mar_2031;
	}
	public void setMar_2031(BigDecimal mar_2031) {
		this.mar_2031 = mar_2031;
	}
	public BigDecimal getJun_2031() {
		return jun_2031;
	}
	public void setJun_2031(BigDecimal jun_2031) {
		this.jun_2031 = jun_2031;
	}
	public BigDecimal getSep_2031() {
		return sep_2031;
	}
	public void setSep_2031(BigDecimal sep_2031) {
		this.sep_2031 = sep_2031;
	}
	public BigDecimal getDec_2031() {
		return dec_2031;
	}
	public void setDec_2031(BigDecimal dec_2031) {
		this.dec_2031 = dec_2031;
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
	public String getRemarks_2() {
		return remarks_2;
	}
	public void setRemarks_2(String remarks_2) {
		this.remarks_2 = remarks_2;
	}
	public String getRemarks_3() {
		return remarks_3;
	}
	public void setRemarks_3(String remarks_3) {
		this.remarks_3 = remarks_3;
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
	public ECL_MDT_WO_ADJ_Entity(String sol_id, String cust_id, String map_key, String cust_name,
			String nature_asset_desc, String activity, Date disbursement_date, Date npa_date,
			BigDecimal limit_sanctioned, String int_rate, BigDecimal coll_cash_security,
			BigDecimal coll_non_crm_security, BigDecimal pri_cash_security, BigDecimal pri_non_crm_security,
			BigDecimal osbal_npa_date, BigDecimal write_off_amount, Date write_off_date, BigDecimal dec_2013,
			BigDecimal mar_2014, BigDecimal jun_2014, BigDecimal sep_2014, BigDecimal dec_2014, BigDecimal mar_2015,
			BigDecimal jun_2015, BigDecimal sep_2015, BigDecimal dec_2015, BigDecimal mar_2016, BigDecimal jun_2016,
			BigDecimal sep_2016, BigDecimal dec_2016, BigDecimal mar_2017, BigDecimal jun_2017, BigDecimal sep_2017,
			BigDecimal dec_2017, BigDecimal mar_2018, BigDecimal jun_2018, BigDecimal sep_2018, BigDecimal dec_2018,
			BigDecimal mar_2019, BigDecimal jun_2019, BigDecimal sep_2019, BigDecimal dec_2019, BigDecimal mar_2020,
			BigDecimal jun_2020, BigDecimal sep_2020, BigDecimal dec_2020, BigDecimal mar_2021, BigDecimal jun_2021,
			BigDecimal sep_2021, BigDecimal dec_2021, BigDecimal mar_2022, BigDecimal jun_2022, BigDecimal sep_2022,
			BigDecimal dec_2022, String remarks_1, BigDecimal mar_2023, BigDecimal jun_2023, BigDecimal sep_2023,
			BigDecimal dec_2023, BigDecimal mar_2024, BigDecimal jun_2024, BigDecimal sep_2024, BigDecimal dec_2024,
			BigDecimal mar_2025, BigDecimal jun_2025, BigDecimal sep_2025, BigDecimal dec_2025, BigDecimal mar_2026,
			BigDecimal jun_2026, BigDecimal sep_2026, BigDecimal dec_2026, BigDecimal mar_2027, BigDecimal jun_2027,
			BigDecimal sep_2027, BigDecimal dec_2027, BigDecimal mar_2028, BigDecimal jun_2028, BigDecimal sep_2028,
			BigDecimal dec_2028, BigDecimal mar_2029, BigDecimal jun_2029, BigDecimal sep_2029, BigDecimal dec_2029,
			BigDecimal mar_2030, BigDecimal jun_2030, BigDecimal sep_2030, BigDecimal dec_2030, BigDecimal mar_2031,
			BigDecimal jun_2031, BigDecimal sep_2031, BigDecimal dec_2031, String status, Date status_date,
			String remarks_2, String remarks_3, String del_flg, String upload_flg, Date upload_date, String entity_flg,
			String entry_user, Date entry_time, String modify_user, Date modify_time, String verify_user,
			Date verify_time) {
		super();
		this.sol_id = sol_id;
		this.cust_id = cust_id;
		this.map_key = map_key;
		this.cust_name = cust_name;
		this.nature_asset_desc = nature_asset_desc;
		this.activity = activity;
		this.disbursement_date = disbursement_date;
		this.npa_date = npa_date;
		this.limit_sanctioned = limit_sanctioned;
		this.int_rate = int_rate;
		this.coll_cash_security = coll_cash_security;
		this.coll_non_crm_security = coll_non_crm_security;
		this.pri_cash_security = pri_cash_security;
		this.pri_non_crm_security = pri_non_crm_security;
		this.osbal_npa_date = osbal_npa_date;
		this.write_off_amount = write_off_amount;
		this.write_off_date = write_off_date;
		this.dec_2013 = dec_2013;
		this.mar_2014 = mar_2014;
		this.jun_2014 = jun_2014;
		this.sep_2014 = sep_2014;
		this.dec_2014 = dec_2014;
		this.mar_2015 = mar_2015;
		this.jun_2015 = jun_2015;
		this.sep_2015 = sep_2015;
		this.dec_2015 = dec_2015;
		this.mar_2016 = mar_2016;
		this.jun_2016 = jun_2016;
		this.sep_2016 = sep_2016;
		this.dec_2016 = dec_2016;
		this.mar_2017 = mar_2017;
		this.jun_2017 = jun_2017;
		this.sep_2017 = sep_2017;
		this.dec_2017 = dec_2017;
		this.mar_2018 = mar_2018;
		this.jun_2018 = jun_2018;
		this.sep_2018 = sep_2018;
		this.dec_2018 = dec_2018;
		this.mar_2019 = mar_2019;
		this.jun_2019 = jun_2019;
		this.sep_2019 = sep_2019;
		this.dec_2019 = dec_2019;
		this.mar_2020 = mar_2020;
		this.jun_2020 = jun_2020;
		this.sep_2020 = sep_2020;
		this.dec_2020 = dec_2020;
		this.mar_2021 = mar_2021;
		this.jun_2021 = jun_2021;
		this.sep_2021 = sep_2021;
		this.dec_2021 = dec_2021;
		this.mar_2022 = mar_2022;
		this.jun_2022 = jun_2022;
		this.sep_2022 = sep_2022;
		this.dec_2022 = dec_2022;
		this.remarks_1 = remarks_1;
		this.mar_2023 = mar_2023;
		this.jun_2023 = jun_2023;
		this.sep_2023 = sep_2023;
		this.dec_2023 = dec_2023;
		this.mar_2024 = mar_2024;
		this.jun_2024 = jun_2024;
		this.sep_2024 = sep_2024;
		this.dec_2024 = dec_2024;
		this.mar_2025 = mar_2025;
		this.jun_2025 = jun_2025;
		this.sep_2025 = sep_2025;
		this.dec_2025 = dec_2025;
		this.mar_2026 = mar_2026;
		this.jun_2026 = jun_2026;
		this.sep_2026 = sep_2026;
		this.dec_2026 = dec_2026;
		this.mar_2027 = mar_2027;
		this.jun_2027 = jun_2027;
		this.sep_2027 = sep_2027;
		this.dec_2027 = dec_2027;
		this.mar_2028 = mar_2028;
		this.jun_2028 = jun_2028;
		this.sep_2028 = sep_2028;
		this.dec_2028 = dec_2028;
		this.mar_2029 = mar_2029;
		this.jun_2029 = jun_2029;
		this.sep_2029 = sep_2029;
		this.dec_2029 = dec_2029;
		this.mar_2030 = mar_2030;
		this.jun_2030 = jun_2030;
		this.sep_2030 = sep_2030;
		this.dec_2030 = dec_2030;
		this.mar_2031 = mar_2031;
		this.jun_2031 = jun_2031;
		this.sep_2031 = sep_2031;
		this.dec_2031 = dec_2031;
		this.status = status;
		this.status_date = status_date;
		this.remarks_2 = remarks_2;
		this.remarks_3 = remarks_3;
		this.del_flg = del_flg;
		this.upload_flg = upload_flg;
		this.upload_date = upload_date;
		this.entity_flg = entity_flg;
		this.entry_user = entry_user;
		this.entry_time = entry_time;
		this.modify_user = modify_user;
		this.modify_time = modify_time;
		this.verify_user = verify_user;
		this.verify_time = verify_time;
	}
	public ECL_MDT_WO_ADJ_Entity() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
