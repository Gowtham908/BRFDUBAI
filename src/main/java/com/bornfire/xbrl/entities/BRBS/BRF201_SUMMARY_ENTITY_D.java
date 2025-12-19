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
@Table(name="BRF201_SUMMARYTABLE_D")
@IdClass(BRF201IDCLASS.class)
public class BRF201_SUMMARY_ENTITY_D {
	private String	r1_ban_name;
	private String	r1_ban_country_of_incorporation;
	private String	r1_ban_date_opened;
	private String	r1_ban_date_closed;
	private String	r1_ban_regulator;
	private String	r1_ban_ownership;
	private String	r1_ban_nature_of_business;
	private String	r1_ban_share_capital;
	private String	r1_ban_share_premium;
	private String	r1_ban_reserves;
	private String	r1_ban_accumulated_retained_earnings;
	private String	r1_ban_assets;
	private String	r1_ban_ceo_name;
	private String	r1_ban_no_of_staff;
	private String	r1_ban_no_of_uae_nationals;
	private String	r1_ban_no_of_branches;
	private String	r1_ban_no_of_atm;
	private String	r1_ban_cb_approval_ref_num;
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
	public String getR1_ban_name() {
		return r1_ban_name;
	}


	public void setR1_ban_name(String r1_ban_name) {
		this.r1_ban_name = r1_ban_name;
	}


	public String getR1_ban_country_of_incorporation() {
		return r1_ban_country_of_incorporation;
	}


	public void setR1_ban_country_of_incorporation(String r1_ban_country_of_incorporation) {
		this.r1_ban_country_of_incorporation = r1_ban_country_of_incorporation;
	}


	public String getR1_ban_date_opened() {
		return r1_ban_date_opened;
	}


	public void setR1_ban_date_opened(String r1_ban_date_opened) {
		this.r1_ban_date_opened = r1_ban_date_opened;
	}


	public String getR1_ban_date_closed() {
		return r1_ban_date_closed;
	}


	public void setR1_ban_date_closed(String r1_ban_date_closed) {
		this.r1_ban_date_closed = r1_ban_date_closed;
	}


	public String getR1_ban_regulator() {
		return r1_ban_regulator;
	}


	public void setR1_ban_regulator(String r1_ban_regulator) {
		this.r1_ban_regulator = r1_ban_regulator;
	}


	public String getR1_ban_ownership() {
		return r1_ban_ownership;
	}


	public void setR1_ban_ownership(String r1_ban_ownership) {
		this.r1_ban_ownership = r1_ban_ownership;
	}


	public String getR1_ban_nature_of_business() {
		return r1_ban_nature_of_business;
	}


	public void setR1_ban_nature_of_business(String r1_ban_nature_of_business) {
		this.r1_ban_nature_of_business = r1_ban_nature_of_business;
	}


	public String getR1_ban_share_capital() {
		return r1_ban_share_capital;
	}


	public void setR1_ban_share_capital(String r1_ban_share_capital) {
		this.r1_ban_share_capital = r1_ban_share_capital;
	}


	public String getR1_ban_share_premium() {
		return r1_ban_share_premium;
	}


	public void setR1_ban_share_premium(String r1_ban_share_premium) {
		this.r1_ban_share_premium = r1_ban_share_premium;
	}


	public String getR1_ban_reserves() {
		return r1_ban_reserves;
	}


	public void setR1_ban_reserves(String r1_ban_reserves) {
		this.r1_ban_reserves = r1_ban_reserves;
	}


	public String getR1_ban_accumulated_retained_earnings() {
		return r1_ban_accumulated_retained_earnings;
	}


	public void setR1_ban_accumulated_retained_earnings(String r1_ban_accumulated_retained_earnings) {
		this.r1_ban_accumulated_retained_earnings = r1_ban_accumulated_retained_earnings;
	}


	public String getR1_ban_assets() {
		return r1_ban_assets;
	}


	public void setR1_ban_assets(String r1_ban_assets) {
		this.r1_ban_assets = r1_ban_assets;
	}


	public String getR1_ban_ceo_name() {
		return r1_ban_ceo_name;
	}


	public void setR1_ban_ceo_name(String r1_ban_ceo_name) {
		this.r1_ban_ceo_name = r1_ban_ceo_name;
	}


	public String getR1_ban_no_of_staff() {
		return r1_ban_no_of_staff;
	}


	public void setR1_ban_no_of_staff(String r1_ban_no_of_staff) {
		this.r1_ban_no_of_staff = r1_ban_no_of_staff;
	}


	public String getR1_ban_no_of_uae_nationals() {
		return r1_ban_no_of_uae_nationals;
	}


	public void setR1_ban_no_of_uae_nationals(String r1_ban_no_of_uae_nationals) {
		this.r1_ban_no_of_uae_nationals = r1_ban_no_of_uae_nationals;
	}


	public String getR1_ban_no_of_branches() {
		return r1_ban_no_of_branches;
	}


	public void setR1_ban_no_of_branches(String r1_ban_no_of_branches) {
		this.r1_ban_no_of_branches = r1_ban_no_of_branches;
	}


	public String getR1_ban_no_of_atm() {
		return r1_ban_no_of_atm;
	}


	public void setR1_ban_no_of_atm(String r1_ban_no_of_atm) {
		this.r1_ban_no_of_atm = r1_ban_no_of_atm;
	}


	public String getR1_ban_cb_approval_ref_num() {
		return r1_ban_cb_approval_ref_num;
	}


	public void setR1_ban_cb_approval_ref_num(String r1_ban_cb_approval_ref_num) {
		this.r1_ban_cb_approval_ref_num = r1_ban_cb_approval_ref_num;
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
	public BRF201_SUMMARY_ENTITY_D(String r1_ban_name, String r1_ban_country_of_incorporation,
			String r1_ban_date_opened, String r1_ban_date_closed, String r1_ban_regulator, String r1_ban_ownership,
			String r1_ban_nature_of_business, String r1_ban_share_capital, String r1_ban_share_premium,
			String r1_ban_reserves, String r1_ban_accumulated_retained_earnings, String r1_ban_assets,
			String r1_ban_ceo_name, String r1_ban_no_of_staff, String r1_ban_no_of_uae_nationals,
			String r1_ban_no_of_branches, String r1_ban_no_of_atm, String r1_ban_cb_approval_ref_num,
			Date report_submit_date, Date report_date, Date report_from_date, Date report_to_date, String report_code,
			String entity_flg, String modify_flg, String del_flg, String entry_user, String modify_user,
			String verify_user, Date entry_time, Date modify_time, Date verify_time, BigDecimal srl_no) {
		super();
		this.r1_ban_name = r1_ban_name;
		this.r1_ban_country_of_incorporation = r1_ban_country_of_incorporation;
		this.r1_ban_date_opened = r1_ban_date_opened;
		this.r1_ban_date_closed = r1_ban_date_closed;
		this.r1_ban_regulator = r1_ban_regulator;
		this.r1_ban_ownership = r1_ban_ownership;
		this.r1_ban_nature_of_business = r1_ban_nature_of_business;
		this.r1_ban_share_capital = r1_ban_share_capital;
		this.r1_ban_share_premium = r1_ban_share_premium;
		this.r1_ban_reserves = r1_ban_reserves;
		this.r1_ban_accumulated_retained_earnings = r1_ban_accumulated_retained_earnings;
		this.r1_ban_assets = r1_ban_assets;
		this.r1_ban_ceo_name = r1_ban_ceo_name;
		this.r1_ban_no_of_staff = r1_ban_no_of_staff;
		this.r1_ban_no_of_uae_nationals = r1_ban_no_of_uae_nationals;
		this.r1_ban_no_of_branches = r1_ban_no_of_branches;
		this.r1_ban_no_of_atm = r1_ban_no_of_atm;
		this.r1_ban_cb_approval_ref_num = r1_ban_cb_approval_ref_num;
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


	public BRF201_SUMMARY_ENTITY_D() {
		super();
		// TODO Auto-generated constructor stub
	}


	@Override
	public String toString() {
		return "BRF201_SUMMARY_ENTITY_D [r1_ban_name=" + r1_ban_name + ", r1_ban_country_of_incorporation="
				+ r1_ban_country_of_incorporation + ", r1_ban_date_opened=" + r1_ban_date_opened
				+ ", r1_ban_date_closed=" + r1_ban_date_closed + ", r1_ban_regulator=" + r1_ban_regulator
				+ ", r1_ban_ownership=" + r1_ban_ownership + ", r1_ban_nature_of_business=" + r1_ban_nature_of_business
				+ ", r1_ban_share_capital=" + r1_ban_share_capital + ", r1_ban_share_premium=" + r1_ban_share_premium
				+ ", r1_ban_reserves=" + r1_ban_reserves + ", r1_ban_accumulated_retained_earnings="
				+ r1_ban_accumulated_retained_earnings + ", r1_ban_assets=" + r1_ban_assets + ", r1_ban_ceo_name="
				+ r1_ban_ceo_name + ", r1_ban_no_of_staff=" + r1_ban_no_of_staff + ", r1_ban_no_of_uae_nationals="
				+ r1_ban_no_of_uae_nationals + ", r1_ban_no_of_branches=" + r1_ban_no_of_branches
				+ ", r1_ban_no_of_atm=" + r1_ban_no_of_atm + ", r1_ban_cb_approval_ref_num="
				+ r1_ban_cb_approval_ref_num + ", srl_no=" + srl_no + "]";
	}
}
