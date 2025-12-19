package com.bornfire.xbrl.entities.BRBS;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="BRF201_SUMMARYTABLE_G")
@IdClass(BRF201IDCLASS.class)
public class BRF201_SUMMARY_ENTITY_G {
	 private BigDecimal	r1_total_network_numbers;
		private BigDecimal	r1_domestic_foreign_branches;
		private BigDecimal	r1_rep_offices;
		private BigDecimal	r1_banking_subsidiaries;
		private BigDecimal	r1_non_banking_financial_subsidiaries;
		private BigDecimal	r1_non_financial_subsidiaries;
		private BigDecimal	r1_pay_offices;
		private BigDecimal	r1_elec_business_units;
		private BigDecimal	r1_atms;
		private BigDecimal	r1_admins_office_uae;
		private BigDecimal	r1_admins_office_outside_uae;
		private BigDecimal	r1_no_of_mobile_banking_user;
		private BigDecimal	r1_no_of_internet_banking_user;
	private Date	report_submit_date;
	@Id
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date	report_date;
	private Date	report_from_date;
	private Date	report_to_date;
	private String	report_code;
	private String	entity_flg;
	private String	modify_flg;
	private String	del_flg;
	private String	entry_user;
	private String	modify_user;
	private String	verify_user;
	private Date	entry_time;
	private Date	modify_time;
	private Date	verify_time;
	@Id
	private BigDecimal	srl_no;
	 
	public BigDecimal getR1_total_network_numbers() {
		return r1_total_network_numbers;
	}

	public void setR1_total_network_numbers(BigDecimal r1_total_network_numbers) {
		this.r1_total_network_numbers = r1_total_network_numbers;
	}

	public BigDecimal getR1_domestic_foreign_branches() {
		return r1_domestic_foreign_branches;
	}

	public void setR1_domestic_foreign_branches(BigDecimal r1_domestic_foreign_branches) {
		this.r1_domestic_foreign_branches = r1_domestic_foreign_branches;
	}

	public BigDecimal getR1_rep_offices() {
		return r1_rep_offices;
	}

	public void setR1_rep_offices(BigDecimal r1_rep_offices) {
		this.r1_rep_offices = r1_rep_offices;
	}

	public BigDecimal getR1_banking_subsidiaries() {
		return r1_banking_subsidiaries;
	}

	public void setR1_banking_subsidiaries(BigDecimal r1_banking_subsidiaries) {
		this.r1_banking_subsidiaries = r1_banking_subsidiaries;
	}

	public BigDecimal getR1_non_banking_financial_subsidiaries() {
		return r1_non_banking_financial_subsidiaries;
	}

	public void setR1_non_banking_financial_subsidiaries(BigDecimal r1_non_banking_financial_subsidiaries) {
		this.r1_non_banking_financial_subsidiaries = r1_non_banking_financial_subsidiaries;
	}

	public BigDecimal getR1_non_financial_subsidiaries() {
		return r1_non_financial_subsidiaries;
	}

	public void setR1_non_financial_subsidiaries(BigDecimal r1_non_financial_subsidiaries) {
		this.r1_non_financial_subsidiaries = r1_non_financial_subsidiaries;
	}

	public BigDecimal getR1_pay_offices() {
		return r1_pay_offices;
	}

	public void setR1_pay_offices(BigDecimal r1_pay_offices) {
		this.r1_pay_offices = r1_pay_offices;
	}

	public BigDecimal getR1_elec_business_units() {
		return r1_elec_business_units;
	}

	public void setR1_elec_business_units(BigDecimal r1_elec_business_units) {
		this.r1_elec_business_units = r1_elec_business_units;
	}

	public BigDecimal getR1_atms() {
		return r1_atms;
	}

	public void setR1_atms(BigDecimal r1_atms) {
		this.r1_atms = r1_atms;
	}

	public BigDecimal getR1_admins_office_uae() {
		return r1_admins_office_uae;
	}

	public void setR1_admins_office_uae(BigDecimal r1_admins_office_uae) {
		this.r1_admins_office_uae = r1_admins_office_uae;
	}

	public BigDecimal getR1_admins_office_outside_uae() {
		return r1_admins_office_outside_uae;
	}

	public void setR1_admins_office_outside_uae(BigDecimal r1_admins_office_outside_uae) {
		this.r1_admins_office_outside_uae = r1_admins_office_outside_uae;
	}

	public BigDecimal getR1_no_of_mobile_banking_user() {
		return r1_no_of_mobile_banking_user;
	}

	public void setR1_no_of_mobile_banking_user(BigDecimal r1_no_of_mobile_banking_user) {
		this.r1_no_of_mobile_banking_user = r1_no_of_mobile_banking_user;
	}

	public BigDecimal getR1_no_of_internet_banking_user() {
		return r1_no_of_internet_banking_user;
	}

	public void setR1_no_of_internet_banking_user(BigDecimal r1_no_of_internet_banking_user) {
		this.r1_no_of_internet_banking_user = r1_no_of_internet_banking_user;
	}

	public Date getReport_submit_date() {
		return report_submit_date;
	}

	public void setReport_submit_date(Date report_submit_date) {
		this.report_submit_date = report_submit_date;
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

	public String getReport_code() {
		return report_code;
	}

	public void setReport_code(String report_code) {
		this.report_code = report_code;
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

	public BigDecimal getSrl_no() {
		return srl_no;
	}

	public void setSrl_no(BigDecimal srl_no) {
		this.srl_no = srl_no;
	}
	@Override
	public String toString() {
		return "BRF201_SUMMARY_ENTITY_G [r1_total_network_numbers=" + r1_total_network_numbers
				+ ", r1_domestic_foreign_branches=" + r1_domestic_foreign_branches + ", r1_rep_offices="
				+ r1_rep_offices + ", r1_banking_subsidiaries=" + r1_banking_subsidiaries
				+ ", r1_non_banking_financial_subsidiaries=" + r1_non_banking_financial_subsidiaries
				+ ", r1_non_financial_subsidiaries=" + r1_non_financial_subsidiaries + ", r1_pay_offices="
				+ r1_pay_offices + ", r1_elec_business_units=" + r1_elec_business_units + ", r1_atms=" + r1_atms
				+ ", r1_admins_office_uae=" + r1_admins_office_uae + ", r1_admins_office_outside_uae="
				+ r1_admins_office_outside_uae + ", r1_no_of_mobile_banking_user=" + r1_no_of_mobile_banking_user
				+ ", r1_no_of_internet_banking_user=" + r1_no_of_internet_banking_user + ", srl_no=" + srl_no + "]";
	}
	public BRF201_SUMMARY_ENTITY_G(BigDecimal r1_total_network_numbers, BigDecimal r1_domestic_foreign_branches,
			BigDecimal r1_rep_offices, BigDecimal r1_banking_subsidiaries,
			BigDecimal r1_non_banking_financial_subsidiaries, BigDecimal r1_non_financial_subsidiaries,
			BigDecimal r1_pay_offices, BigDecimal r1_elec_business_units, BigDecimal r1_atms,
			BigDecimal r1_admins_office_uae, BigDecimal r1_admins_office_outside_uae,
			BigDecimal r1_no_of_mobile_banking_user, BigDecimal r1_no_of_internet_banking_user, Date report_submit_date,
			Date report_date, Date report_from_date, Date report_to_date, String report_code, String entity_flg,
			String modify_flg, String del_flg, String entry_user, String modify_user, String verify_user,
			Date entry_time, Date modify_time, Date verify_time, BigDecimal srl_no) {
		super();
		this.r1_total_network_numbers = r1_total_network_numbers;
		this.r1_domestic_foreign_branches = r1_domestic_foreign_branches;
		this.r1_rep_offices = r1_rep_offices;
		this.r1_banking_subsidiaries = r1_banking_subsidiaries;
		this.r1_non_banking_financial_subsidiaries = r1_non_banking_financial_subsidiaries;
		this.r1_non_financial_subsidiaries = r1_non_financial_subsidiaries;
		this.r1_pay_offices = r1_pay_offices;
		this.r1_elec_business_units = r1_elec_business_units;
		this.r1_atms = r1_atms;
		this.r1_admins_office_uae = r1_admins_office_uae;
		this.r1_admins_office_outside_uae = r1_admins_office_outside_uae;
		this.r1_no_of_mobile_banking_user = r1_no_of_mobile_banking_user;
		this.r1_no_of_internet_banking_user = r1_no_of_internet_banking_user;
		this.report_submit_date = report_submit_date;
		this.report_date = report_date;
		this.report_from_date = report_from_date;
		this.report_to_date = report_to_date;
		this.report_code = report_code;
		this.entity_flg = entity_flg;
		this.modify_flg = modify_flg;
		this.del_flg = del_flg;
		this.entry_user = entry_user;
		this.modify_user = modify_user;
		this.verify_user = verify_user;
		this.entry_time = entry_time;
		this.modify_time = modify_time;
		this.verify_time = verify_time;
		this.srl_no = srl_no;
	}

	public BRF201_SUMMARY_ENTITY_G() {
		super();
		// TODO Auto-generated constructor stub
	}
}
