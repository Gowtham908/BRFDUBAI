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
@Table(name = "BRF202_SUMMARYTABLE")
@IdClass(BRF202AIDCLASS.class)
public class BRF202A_entity implements Serializable {
	@Id
	private String	r1_s_no;
	private String	r1_employee_name;
	private String	r1_first_name;
	private String	r1_middle_name;
	private String	r1_last_name;
	private String	r1_rt_code;
	private Date	r1_date_of_joining;
	private Date	r1_date_of_birth;
	private String	r1_age;
	private String	r1_emirates_id_number;
	private String	r1_gender;
	private String	r1_nationality;
	private String	r1_if_nationality_is_ae_select_emirate;
	private String	r1_emirate_work_location;
	private String	r1_incase_nationality_is_aewhether_they_hold_family_book;
	private String	r1_family_book_number;
	private String	r1_marital_status;
	private String	r1_position;
	private String	r1_department;
	private String	r1_designation;
	private String	r1_number_of_reportees;
	private String	r1_highest_level_of_education;
	private String	r1_professional_certification;
	private String	r1_number_of_years_of_experience;
	private String	r1_number_of_dependents;
	private String	r1_basic_salary_per_month;
	private String	r1_monthly_national_allowance;
	private String	r1_monthly_other_benifits;
	private String	r1_monthly_salary_applicable_for_pention;
	private String	r1_gross_salary_per_month;
	private String	r1_pension_registration_reference;
	private String	r1_critical;
	private String	r1_type_of_contract;
	private String	r1_previously_sponsored_student;
	private BigDecimal	r1_training_hours_ytd;
	private BigDecimal	r1_training_spent_aed;
	private String	r1_emiratization_kpi_included;
	private String	r1_percentage_of_kpi;
	private String	r1_ceo_and_staff_reporting_directly_to_ceocountry_manager;
	@Id
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date	report_date;
	private Date	report_from_date;
	private Date	report_to_date;
	private String	entity_flg;
	private String	modify_flg;
	private String	del_flg;
	private String	report_code;
	private Date	report_submit_date;
	private BigDecimal	r2_training_hours_ytd;
	private BigDecimal	r2_training_spent_aed;
	private String	total_spending_on_trainings_attended_by_both_emiratis_and_expats;
	private String	total_number_of_trainees_on_trainings_attended_by_both_emiratis_and_expats;
	private String	total_number_of_emiratis_attended_trainings_for_all_employees;
	private String	total_number_of_emiratis_in_company;
	private String	total_spending_on_trainings_attended_by_emiratis_only;
	private String	number_of_others_left_during_the_reporting_period;
	private String	number_of_emiratis_left_during_the_reporting_period;
	private String	entry_user;
	private String	modify_user;
	private String	verify_user;
	private Date	entry_time;
	private Date	modify_time;
	private Date	verify_time;
	
	public String getR1_s_no() {
		return r1_s_no;
	}

	public void setR1_s_no(String r1_s_no) {
		this.r1_s_no = r1_s_no;
	}

	public String getR1_employee_name() {
		return r1_employee_name;
	}

	public void setR1_employee_name(String r1_employee_name) {
		this.r1_employee_name = r1_employee_name;
	}

	public String getR1_first_name() {
		return r1_first_name;
	}

	public void setR1_first_name(String r1_first_name) {
		this.r1_first_name = r1_first_name;
	}

	public String getR1_middle_name() {
		return r1_middle_name;
	}

	public void setR1_middle_name(String r1_middle_name) {
		this.r1_middle_name = r1_middle_name;
	}

	public String getR1_last_name() {
		return r1_last_name;
	}

	public void setR1_last_name(String r1_last_name) {
		this.r1_last_name = r1_last_name;
	}

	public String getR1_rt_code() {
		return r1_rt_code;
	}

	public void setR1_rt_code(String r1_rt_code) {
		this.r1_rt_code = r1_rt_code;
	}

	public Date getR1_date_of_joining() {
		return r1_date_of_joining;
	}

	public void setR1_date_of_joining(Date r1_date_of_joining) {
		this.r1_date_of_joining = r1_date_of_joining;
	}

	public Date getR1_date_of_birth() {
		return r1_date_of_birth;
	}

	public void setR1_date_of_birth(Date r1_date_of_birth) {
		this.r1_date_of_birth = r1_date_of_birth;
	}

	public String getR1_age() {
		return r1_age;
	}

	public void setR1_age(String r1_age) {
		this.r1_age = r1_age;
	}

	public String getR1_emirates_id_number() {
		return r1_emirates_id_number;
	}

	public void setR1_emirates_id_number(String r1_emirates_id_number) {
		this.r1_emirates_id_number = r1_emirates_id_number;
	}

	public String getR1_gender() {
		return r1_gender;
	}

	public void setR1_gender(String r1_gender) {
		this.r1_gender = r1_gender;
	}

	public String getR1_nationality() {
		return r1_nationality;
	}

	public void setR1_nationality(String r1_nationality) {
		this.r1_nationality = r1_nationality;
	}

	public String getR1_if_nationality_is_ae_select_emirate() {
		return r1_if_nationality_is_ae_select_emirate;
	}

	public void setR1_if_nationality_is_ae_select_emirate(String r1_if_nationality_is_ae_select_emirate) {
		this.r1_if_nationality_is_ae_select_emirate = r1_if_nationality_is_ae_select_emirate;
	}

	public String getR1_emirate_work_location() {
		return r1_emirate_work_location;
	}

	public void setR1_emirate_work_location(String r1_emirate_work_location) {
		this.r1_emirate_work_location = r1_emirate_work_location;
	}

	public String getR1_incase_nationality_is_aewhether_they_hold_family_book() {
		return r1_incase_nationality_is_aewhether_they_hold_family_book;
	}

	public void setR1_incase_nationality_is_aewhether_they_hold_family_book(
			String r1_incase_nationality_is_aewhether_they_hold_family_book) {
		this.r1_incase_nationality_is_aewhether_they_hold_family_book = r1_incase_nationality_is_aewhether_they_hold_family_book;
	}

	public String getR1_family_book_number() {
		return r1_family_book_number;
	}

	public void setR1_family_book_number(String r1_family_book_number) {
		this.r1_family_book_number = r1_family_book_number;
	}

	public String getR1_marital_status() {
		return r1_marital_status;
	}

	public void setR1_marital_status(String r1_marital_status) {
		this.r1_marital_status = r1_marital_status;
	}

	public String getR1_position() {
		return r1_position;
	}

	public void setR1_position(String r1_position) {
		this.r1_position = r1_position;
	}

	public String getR1_department() {
		return r1_department;
	}

	public void setR1_department(String r1_department) {
		this.r1_department = r1_department;
	}

	public String getR1_designation() {
		return r1_designation;
	}

	public void setR1_designation(String r1_designation) {
		this.r1_designation = r1_designation;
	}

	public String getR1_number_of_reportees() {
		return r1_number_of_reportees;
	}

	public void setR1_number_of_reportees(String r1_number_of_reportees) {
		this.r1_number_of_reportees = r1_number_of_reportees;
	}

	public String getR1_highest_level_of_education() {
		return r1_highest_level_of_education;
	}

	public void setR1_highest_level_of_education(String r1_highest_level_of_education) {
		this.r1_highest_level_of_education = r1_highest_level_of_education;
	}

	public String getR1_professional_certification() {
		return r1_professional_certification;
	}

	public void setR1_professional_certification(String r1_professional_certification) {
		this.r1_professional_certification = r1_professional_certification;
	}

	public String getR1_number_of_years_of_experience() {
		return r1_number_of_years_of_experience;
	}

	public void setR1_number_of_years_of_experience(String r1_number_of_years_of_experience) {
		this.r1_number_of_years_of_experience = r1_number_of_years_of_experience;
	}

	public String getR1_number_of_dependents() {
		return r1_number_of_dependents;
	}

	public void setR1_number_of_dependents(String r1_number_of_dependents) {
		this.r1_number_of_dependents = r1_number_of_dependents;
	}

	public String getR1_basic_salary_per_month() {
		return r1_basic_salary_per_month;
	}

	public void setR1_basic_salary_per_month(String r1_basic_salary_per_month) {
		this.r1_basic_salary_per_month = r1_basic_salary_per_month;
	}

	public String getR1_monthly_national_allowance() {
		return r1_monthly_national_allowance;
	}

	public void setR1_monthly_national_allowance(String r1_monthly_national_allowance) {
		this.r1_monthly_national_allowance = r1_monthly_national_allowance;
	}

	public String getR1_monthly_other_benifits() {
		return r1_monthly_other_benifits;
	}

	public void setR1_monthly_other_benifits(String r1_monthly_other_benifits) {
		this.r1_monthly_other_benifits = r1_monthly_other_benifits;
	}

	public String getR1_monthly_salary_applicable_for_pention() {
		return r1_monthly_salary_applicable_for_pention;
	}

	public void setR1_monthly_salary_applicable_for_pention(String r1_monthly_salary_applicable_for_pention) {
		this.r1_monthly_salary_applicable_for_pention = r1_monthly_salary_applicable_for_pention;
	}

	public String getR1_gross_salary_per_month() {
		return r1_gross_salary_per_month;
	}

	public void setR1_gross_salary_per_month(String r1_gross_salary_per_month) {
		this.r1_gross_salary_per_month = r1_gross_salary_per_month;
	}

	public String getR1_pension_registration_reference() {
		return r1_pension_registration_reference;
	}

	public void setR1_pension_registration_reference(String r1_pension_registration_reference) {
		this.r1_pension_registration_reference = r1_pension_registration_reference;
	}

	public String getR1_critical() {
		return r1_critical;
	}

	public void setR1_critical(String r1_critical) {
		this.r1_critical = r1_critical;
	}

	public String getR1_type_of_contract() {
		return r1_type_of_contract;
	}

	public void setR1_type_of_contract(String r1_type_of_contract) {
		this.r1_type_of_contract = r1_type_of_contract;
	}

	public String getR1_previously_sponsored_student() {
		return r1_previously_sponsored_student;
	}

	public void setR1_previously_sponsored_student(String r1_previously_sponsored_student) {
		this.r1_previously_sponsored_student = r1_previously_sponsored_student;
	}

	public BigDecimal getR1_training_hours_ytd() {
		return r1_training_hours_ytd;
	}

	public void setR1_training_hours_ytd(BigDecimal r1_training_hours_ytd) {
		this.r1_training_hours_ytd = r1_training_hours_ytd;
	}

	public BigDecimal getR1_training_spent_aed() {
		return r1_training_spent_aed;
	}

	public void setR1_training_spent_aed(BigDecimal r1_training_spent_aed) {
		this.r1_training_spent_aed = r1_training_spent_aed;
	}

	public String getR1_emiratization_kpi_included() {
		return r1_emiratization_kpi_included;
	}

	public void setR1_emiratization_kpi_included(String r1_emiratization_kpi_included) {
		this.r1_emiratization_kpi_included = r1_emiratization_kpi_included;
	}

	public String getR1_percentage_of_kpi() {
		return r1_percentage_of_kpi;
	}

	public void setR1_percentage_of_kpi(String r1_percentage_of_kpi) {
		this.r1_percentage_of_kpi = r1_percentage_of_kpi;
	}

	public String getR1_ceo_and_staff_reporting_directly_to_ceocountry_manager() {
		return r1_ceo_and_staff_reporting_directly_to_ceocountry_manager;
	}

	public void setR1_ceo_and_staff_reporting_directly_to_ceocountry_manager(
			String r1_ceo_and_staff_reporting_directly_to_ceocountry_manager) {
		this.r1_ceo_and_staff_reporting_directly_to_ceocountry_manager = r1_ceo_and_staff_reporting_directly_to_ceocountry_manager;
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

	public BigDecimal getR2_training_hours_ytd() {
		return r2_training_hours_ytd;
	}

	public void setR2_training_hours_ytd(BigDecimal r2_training_hours_ytd) {
		this.r2_training_hours_ytd = r2_training_hours_ytd;
	}

	public BigDecimal getR2_training_spent_aed() {
		return r2_training_spent_aed;
	}

	public void setR2_training_spent_aed(BigDecimal r2_training_spent_aed) {
		this.r2_training_spent_aed = r2_training_spent_aed;
	}

	public String getTotal_spending_on_trainings_attended_by_both_emiratis_and_expats() {
		return total_spending_on_trainings_attended_by_both_emiratis_and_expats;
	}

	public void setTotal_spending_on_trainings_attended_by_both_emiratis_and_expats(
			String total_spending_on_trainings_attended_by_both_emiratis_and_expats) {
		this.total_spending_on_trainings_attended_by_both_emiratis_and_expats = total_spending_on_trainings_attended_by_both_emiratis_and_expats;
	}

	public String getTotal_number_of_trainees_on_trainings_attended_by_both_emiratis_and_expats() {
		return total_number_of_trainees_on_trainings_attended_by_both_emiratis_and_expats;
	}

	public void setTotal_number_of_trainees_on_trainings_attended_by_both_emiratis_and_expats(
			String total_number_of_trainees_on_trainings_attended_by_both_emiratis_and_expats) {
		this.total_number_of_trainees_on_trainings_attended_by_both_emiratis_and_expats = total_number_of_trainees_on_trainings_attended_by_both_emiratis_and_expats;
	}

	public String getTotal_number_of_emiratis_attended_trainings_for_all_employees() {
		return total_number_of_emiratis_attended_trainings_for_all_employees;
	}

	public void setTotal_number_of_emiratis_attended_trainings_for_all_employees(
			String total_number_of_emiratis_attended_trainings_for_all_employees) {
		this.total_number_of_emiratis_attended_trainings_for_all_employees = total_number_of_emiratis_attended_trainings_for_all_employees;
	}

	public String getTotal_number_of_emiratis_in_company() {
		return total_number_of_emiratis_in_company;
	}

	public void setTotal_number_of_emiratis_in_company(String total_number_of_emiratis_in_company) {
		this.total_number_of_emiratis_in_company = total_number_of_emiratis_in_company;
	}

	public String getTotal_spending_on_trainings_attended_by_emiratis_only() {
		return total_spending_on_trainings_attended_by_emiratis_only;
	}

	public void setTotal_spending_on_trainings_attended_by_emiratis_only(
			String total_spending_on_trainings_attended_by_emiratis_only) {
		this.total_spending_on_trainings_attended_by_emiratis_only = total_spending_on_trainings_attended_by_emiratis_only;
	}

	public String getNumber_of_others_left_during_the_reporting_period() {
		return number_of_others_left_during_the_reporting_period;
	}

	public void setNumber_of_others_left_during_the_reporting_period(
			String number_of_others_left_during_the_reporting_period) {
		this.number_of_others_left_during_the_reporting_period = number_of_others_left_during_the_reporting_period;
	}

	public String getNumber_of_emiratis_left_during_the_reporting_period() {
		return number_of_emiratis_left_during_the_reporting_period;
	}

	public void setNumber_of_emiratis_left_during_the_reporting_period(
			String number_of_emiratis_left_during_the_reporting_period) {
		this.number_of_emiratis_left_during_the_reporting_period = number_of_emiratis_left_during_the_reporting_period;
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

	public BRF202A_entity(String r1_s_no, String r1_employee_name, String r1_first_name, String r1_middle_name,
			String r1_last_name, String r1_rt_code, Date r1_date_of_joining, Date r1_date_of_birth, String r1_age,
			String r1_emirates_id_number, String r1_gender, String r1_nationality,
			String r1_if_nationality_is_ae_select_emirate, String r1_emirate_work_location,
			String r1_incase_nationality_is_aewhether_they_hold_family_book, String r1_family_book_number,
			String r1_marital_status, String r1_position, String r1_department, String r1_designation,
			String r1_number_of_reportees, String r1_highest_level_of_education, String r1_professional_certification,
			String r1_number_of_years_of_experience, String r1_number_of_dependents, String r1_basic_salary_per_month,
			String r1_monthly_national_allowance, String r1_monthly_other_benifits,
			String r1_monthly_salary_applicable_for_pention, String r1_gross_salary_per_month,
			String r1_pension_registration_reference, String r1_critical, String r1_type_of_contract,
			String r1_previously_sponsored_student, BigDecimal r1_training_hours_ytd, BigDecimal r1_training_spent_aed,
			String r1_emiratization_kpi_included, String r1_percentage_of_kpi,
			String r1_ceo_and_staff_reporting_directly_to_ceocountry_manager, Date report_date, Date report_from_date,
			Date report_to_date, String entity_flg, String modify_flg, String del_flg, String report_code,
			Date report_submit_date, BigDecimal r2_training_hours_ytd, BigDecimal r2_training_spent_aed,
			String total_spending_on_trainings_attended_by_both_emiratis_and_expats,
			String total_number_of_trainees_on_trainings_attended_by_both_emiratis_and_expats,
			String total_number_of_emiratis_attended_trainings_for_all_employees,
			String total_number_of_emiratis_in_company, String total_spending_on_trainings_attended_by_emiratis_only,
			String number_of_others_left_during_the_reporting_period,
			String number_of_emiratis_left_during_the_reporting_period, String entry_user, String modify_user,
			String verify_user, Date entry_time, Date modify_time, Date verify_time) {
		super();
		this.r1_s_no = r1_s_no;
		this.r1_employee_name = r1_employee_name;
		this.r1_first_name = r1_first_name;
		this.r1_middle_name = r1_middle_name;
		this.r1_last_name = r1_last_name;
		this.r1_rt_code = r1_rt_code;
		this.r1_date_of_joining = r1_date_of_joining;
		this.r1_date_of_birth = r1_date_of_birth;
		this.r1_age = r1_age;
		this.r1_emirates_id_number = r1_emirates_id_number;
		this.r1_gender = r1_gender;
		this.r1_nationality = r1_nationality;
		this.r1_if_nationality_is_ae_select_emirate = r1_if_nationality_is_ae_select_emirate;
		this.r1_emirate_work_location = r1_emirate_work_location;
		this.r1_incase_nationality_is_aewhether_they_hold_family_book = r1_incase_nationality_is_aewhether_they_hold_family_book;
		this.r1_family_book_number = r1_family_book_number;
		this.r1_marital_status = r1_marital_status;
		this.r1_position = r1_position;
		this.r1_department = r1_department;
		this.r1_designation = r1_designation;
		this.r1_number_of_reportees = r1_number_of_reportees;
		this.r1_highest_level_of_education = r1_highest_level_of_education;
		this.r1_professional_certification = r1_professional_certification;
		this.r1_number_of_years_of_experience = r1_number_of_years_of_experience;
		this.r1_number_of_dependents = r1_number_of_dependents;
		this.r1_basic_salary_per_month = r1_basic_salary_per_month;
		this.r1_monthly_national_allowance = r1_monthly_national_allowance;
		this.r1_monthly_other_benifits = r1_monthly_other_benifits;
		this.r1_monthly_salary_applicable_for_pention = r1_monthly_salary_applicable_for_pention;
		this.r1_gross_salary_per_month = r1_gross_salary_per_month;
		this.r1_pension_registration_reference = r1_pension_registration_reference;
		this.r1_critical = r1_critical;
		this.r1_type_of_contract = r1_type_of_contract;
		this.r1_previously_sponsored_student = r1_previously_sponsored_student;
		this.r1_training_hours_ytd = r1_training_hours_ytd;
		this.r1_training_spent_aed = r1_training_spent_aed;
		this.r1_emiratization_kpi_included = r1_emiratization_kpi_included;
		this.r1_percentage_of_kpi = r1_percentage_of_kpi;
		this.r1_ceo_and_staff_reporting_directly_to_ceocountry_manager = r1_ceo_and_staff_reporting_directly_to_ceocountry_manager;
		this.report_date = report_date;
		this.report_from_date = report_from_date;
		this.report_to_date = report_to_date;
		this.entity_flg = entity_flg;
		this.modify_flg = modify_flg;
		this.del_flg = del_flg;
		this.report_code = report_code;
		this.report_submit_date = report_submit_date;
		this.r2_training_hours_ytd = r2_training_hours_ytd;
		this.r2_training_spent_aed = r2_training_spent_aed;
		this.total_spending_on_trainings_attended_by_both_emiratis_and_expats = total_spending_on_trainings_attended_by_both_emiratis_and_expats;
		this.total_number_of_trainees_on_trainings_attended_by_both_emiratis_and_expats = total_number_of_trainees_on_trainings_attended_by_both_emiratis_and_expats;
		this.total_number_of_emiratis_attended_trainings_for_all_employees = total_number_of_emiratis_attended_trainings_for_all_employees;
		this.total_number_of_emiratis_in_company = total_number_of_emiratis_in_company;
		this.total_spending_on_trainings_attended_by_emiratis_only = total_spending_on_trainings_attended_by_emiratis_only;
		this.number_of_others_left_during_the_reporting_period = number_of_others_left_during_the_reporting_period;
		this.number_of_emiratis_left_during_the_reporting_period = number_of_emiratis_left_during_the_reporting_period;
		this.entry_user = entry_user;
		this.modify_user = modify_user;
		this.verify_user = verify_user;
		this.entry_time = entry_time;
		this.modify_time = modify_time;
		this.verify_time = verify_time;
	}

	public BRF202A_entity() {
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
		BRF202A_entity other = (BRF202A_entity) obj;
		return Objects.equals(r1_s_no, other.r1_s_no) && Objects.equals(report_date, other.report_date);
	}

	@Override
	public String toString() {
		return "BRF202A_entity [r1_s_no=" + r1_s_no + ", r1_employee_name=" + r1_employee_name + ", r1_first_name="
				+ r1_first_name + ", r1_middle_name=" + r1_middle_name + ", r1_last_name=" + r1_last_name
				+ ", r1_rt_code=" + r1_rt_code + ", r1_date_of_joining=" + r1_date_of_joining + ", r1_date_of_birth="
				+ r1_date_of_birth + ", r1_age=" + r1_age + ", r1_emirates_id_number=" + r1_emirates_id_number
				+ ", r1_gender=" + r1_gender + ", r1_nationality=" + r1_nationality
				+ ", r1_if_nationality_is_ae_select_emirate=" + r1_if_nationality_is_ae_select_emirate
				+ ", r1_emirate_work_location=" + r1_emirate_work_location
				+ ", r1_incase_nationality_is_aewhether_they_hold_family_book="
				+ r1_incase_nationality_is_aewhether_they_hold_family_book + ", r1_family_book_number="
				+ r1_family_book_number + ", r1_marital_status=" + r1_marital_status + ", r1_position=" + r1_position
				+ ", r1_department=" + r1_department + ", r1_designation=" + r1_designation
				+ ", r1_number_of_reportees=" + r1_number_of_reportees + ", r1_highest_level_of_education="
				+ r1_highest_level_of_education + ", r1_professional_certification=" + r1_professional_certification
				+ ", r1_number_of_years_of_experience=" + r1_number_of_years_of_experience
				+ ", r1_number_of_dependents=" + r1_number_of_dependents + ", r1_basic_salary_per_month="
				+ r1_basic_salary_per_month + ", r1_monthly_national_allowance=" + r1_monthly_national_allowance
				+ ", r1_monthly_other_benifits=" + r1_monthly_other_benifits
				+ ", r1_monthly_salary_applicable_for_pention=" + r1_monthly_salary_applicable_for_pention
				+ ", r1_gross_salary_per_month=" + r1_gross_salary_per_month + ", r1_pension_registration_reference="
				+ r1_pension_registration_reference + ", r1_critical=" + r1_critical + ", r1_type_of_contract="
				+ r1_type_of_contract + ", r1_previously_sponsored_student=" + r1_previously_sponsored_student
				+ ", r1_training_hours_ytd=" + r1_training_hours_ytd + ", r1_training_spent_aed="
				+ r1_training_spent_aed + ", r1_emiratization_kpi_included=" + r1_emiratization_kpi_included
				+ ", r1_percentage_of_kpi=" + r1_percentage_of_kpi
				+ ", r1_ceo_and_staff_reporting_directly_to_ceocountry_manager="
				+ r1_ceo_and_staff_reporting_directly_to_ceocountry_manager + ", r2_training_hours_ytd="
				+ r2_training_hours_ytd + ", r2_training_spent_aed=" + r2_training_spent_aed
				+ ", total_spending_on_trainings_attended_by_both_emiratis_and_expats="
				+ total_spending_on_trainings_attended_by_both_emiratis_and_expats
				+ ", total_number_of_trainees_on_trainings_attended_by_both_emiratis_and_expats="
				+ total_number_of_trainees_on_trainings_attended_by_both_emiratis_and_expats
				+ ", total_number_of_emiratis_attended_trainings_for_all_employees="
				+ total_number_of_emiratis_attended_trainings_for_all_employees
				+ ", total_number_of_emiratis_in_company=" + total_number_of_emiratis_in_company
				+ ", total_spending_on_trainings_attended_by_emiratis_only="
				+ total_spending_on_trainings_attended_by_emiratis_only
				+ ", number_of_others_left_during_the_reporting_period="
				+ number_of_others_left_during_the_reporting_period
				+ ", number_of_emiratis_left_during_the_reporting_period="
				+ number_of_emiratis_left_during_the_reporting_period + "]";
	}

	

}
