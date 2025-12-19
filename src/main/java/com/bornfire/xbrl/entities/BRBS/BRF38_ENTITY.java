package com.bornfire.xbrl.entities.BRBS;


import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;



@Entity
@Table(name="BRF38_SUMMARYTABLE")
public class BRF38_ENTITY {
	private String	country_break_down;
	private String	north_american_countries;
	private String	european_countries;
	private String	gcc_countries;
	private String	mena_countries;
	private String	sub_saharan_countries;
	private String	asian_countries;
	private String	latin_american_countries1;
	private String	oceania_countries;
	private String	remaining_countries;
	private String	grand_total;
	private BigDecimal	outward_family;
	private BigDecimal	outward_investment;
	private BigDecimal	outward_trade;
	private BigDecimal	outward_other;
	private BigDecimal	outward_total;
	private BigDecimal	inward_family;
	private BigDecimal	inward_investment;
	private BigDecimal	inward_trade;
	private BigDecimal	inward_other;
	private BigDecimal	inward_total;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date	report_date;
	private Date	report_from_date;
	private Date	report_to_date;
	private String	entity_flg;
	private String	modify_flg;
	private String	del_flg;
	private String	report_code;
	private Date	report_submit_date;
	@Id
	private String	row_label;
	public String getCountry_break_down() {
		return country_break_down;
	}
	public void setCountry_break_down(String country_break_down) {
		this.country_break_down = country_break_down;
	}
	public String getNorth_american_countries() {
		return north_american_countries;
	}
	public void setNorth_american_countries(String north_american_countries) {
		this.north_american_countries = north_american_countries;
	}
	public String getEuropean_countries() {
		return european_countries;
	}
	public void setEuropean_countries(String european_countries) {
		this.european_countries = european_countries;
	}
	public String getGcc_countries() {
		return gcc_countries;
	}
	public void setGcc_countries(String gcc_countries) {
		this.gcc_countries = gcc_countries;
	}
	public String getMena_countries() {
		return mena_countries;
	}
	public void setMena_countries(String mena_countries) {
		this.mena_countries = mena_countries;
	}
	public String getSub_saharan_countries() {
		return sub_saharan_countries;
	}
	public void setSub_saharan_countries(String sub_saharan_countries) {
		this.sub_saharan_countries = sub_saharan_countries;
	}
	public String getAsian_countries() {
		return asian_countries;
	}
	public void setAsian_countries(String asian_countries) {
		this.asian_countries = asian_countries;
	}
	public String getLatin_american_countries1() {
		return latin_american_countries1;
	}
	public void setLatin_american_countries1(String latin_american_countries1) {
		this.latin_american_countries1 = latin_american_countries1;
	}
	public String getOceania_countries() {
		return oceania_countries;
	}
	public void setOceania_countries(String oceania_countries) {
		this.oceania_countries = oceania_countries;
	}
	public String getRemaining_countries() {
		return remaining_countries;
	}
	public void setRemaining_countries(String remaining_countries) {
		this.remaining_countries = remaining_countries;
	}
	public String getGrand_total() {
		return grand_total;
	}
	public void setGrand_total(String grand_total) {
		this.grand_total = grand_total;
	}
	public BigDecimal getOutward_family() {
		return outward_family;
	}
	public void setOutward_family(BigDecimal outward_family) {
		this.outward_family = outward_family;
	}
	public BigDecimal getOutward_investment() {
		return outward_investment;
	}
	public void setOutward_investment(BigDecimal outward_investment) {
		this.outward_investment = outward_investment;
	}
	public BigDecimal getOutward_trade() {
		return outward_trade;
	}
	public void setOutward_trade(BigDecimal outward_trade) {
		this.outward_trade = outward_trade;
	}
	public BigDecimal getOutward_other() {
		return outward_other;
	}
	public void setOutward_other(BigDecimal outward_other) {
		this.outward_other = outward_other;
	}
	public BigDecimal getOutward_total() {
		return outward_total;
	}
	public void setOutward_total(BigDecimal outward_total) {
		this.outward_total = outward_total;
	}
	public BigDecimal getInward_family() {
		return inward_family;
	}
	public void setInward_family(BigDecimal inward_family) {
		this.inward_family = inward_family;
	}
	public BigDecimal getInward_investment() {
		return inward_investment;
	}
	public void setInward_investment(BigDecimal inward_investment) {
		this.inward_investment = inward_investment;
	}
	public BigDecimal getInward_trade() {
		return inward_trade;
	}
	public void setInward_trade(BigDecimal inward_trade) {
		this.inward_trade = inward_trade;
	}
	public BigDecimal getInward_other() {
		return inward_other;
	}
	public void setInward_other(BigDecimal inward_other) {
		this.inward_other = inward_other;
	}
	public BigDecimal getInward_total() {
		return inward_total;
	}
	public void setInward_total(BigDecimal inward_total) {
		this.inward_total = inward_total;
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
	public String getRow_label() {
		return row_label;
	}
	public void setRow_label(String row_label) {
		this.row_label = row_label;
	}
	@Override
	public String toString() {
		return "BRF038_ENTITY1 [country_break_down=" + country_break_down + ", north_american_countries="
				+ north_american_countries + ", european_countries=" + european_countries + ", gcc_countries="
				+ gcc_countries + ", mena_countries=" + mena_countries + ", sub_saharan_countries="
				+ sub_saharan_countries + ", asian_countries=" + asian_countries + ", latin_american_countries1="
				+ latin_american_countries1 + ", oceania_countries=" + oceania_countries + ", remaining_countries="
				+ remaining_countries + ", grand_total=" + grand_total + ", outward_family=" + outward_family
				+ ", outward_investment=" + outward_investment + ", outward_trade=" + outward_trade + ", outward_other="
				+ outward_other + ", outward_total=" + outward_total + ", inward_family=" + inward_family
				+ ", inward_investment=" + inward_investment + ", inward_trade=" + inward_trade + ", inward_other="
				+ inward_other + ", inward_total=" + inward_total + ", report_date=" + report_date
				+ ", report_from_date=" + report_from_date + ", report_to_date=" + report_to_date + ", entity_flg="
				+ entity_flg + ", modify_flg=" + modify_flg + ", del_flg=" + del_flg + ", report_code=" + report_code
				+ ", report_submit_date=" + report_submit_date + ", row_label=" + row_label
				+ ", getCountry_break_down()=" + getCountry_break_down() + ", getNorth_american_countries()="
				+ getNorth_american_countries() + ", getEuropean_countries()=" + getEuropean_countries()
				+ ", getGcc_countries()=" + getGcc_countries() + ", getMena_countries()=" + getMena_countries()
				+ ", getSub_saharan_countries()=" + getSub_saharan_countries() + ", getAsian_countries()="
				+ getAsian_countries() + ", getLatin_american_countries1()=" + getLatin_american_countries1()
				+ ", getOceania_countries()=" + getOceania_countries() + ", getRemaining_countries()="
				+ getRemaining_countries() + ", getGrand_total()=" + getGrand_total() + ", getOutward_family()="
				+ getOutward_family() + ", getOutward_investment()=" + getOutward_investment() + ", getOutward_trade()="
				+ getOutward_trade() + ", getOutward_other()=" + getOutward_other() + ", getOutward_total()="
				+ getOutward_total() + ", getInward_family()=" + getInward_family() + ", getInward_investment()="
				+ getInward_investment() + ", getInward_trade()=" + getInward_trade() + ", getInward_other()="
				+ getInward_other() + ", getInward_total()=" + getInward_total() + ", getReport_date()="
				+ getReport_date() + ", getReport_from_date()=" + getReport_from_date() + ", getReport_to_date()="
				+ getReport_to_date() + ", getEntity_flg()=" + getEntity_flg() + ", getModify_flg()=" + getModify_flg()
				+ ", getDel_flg()=" + getDel_flg() + ", getReport_code()=" + getReport_code()
				+ ", getReport_submit_date()=" + getReport_submit_date() + ", getRow_label()=" + getRow_label()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
	public BRF38_ENTITY(String country_break_down, String north_american_countries, String european_countries,
			String gcc_countries, String mena_countries, String sub_saharan_countries, String asian_countries,
			String latin_american_countries1, String oceania_countries, String remaining_countries, String grand_total,
			BigDecimal outward_family, BigDecimal outward_investment, BigDecimal outward_trade,
			BigDecimal outward_other, BigDecimal outward_total, BigDecimal inward_family, BigDecimal inward_investment,
			BigDecimal inward_trade, BigDecimal inward_other, BigDecimal inward_total, Date report_date,
			Date report_from_date, Date report_to_date, String entity_flg, String modify_flg, String del_flg,
			String report_code, Date report_submit_date, String row_label) {
		super();
		this.country_break_down = country_break_down;
		this.north_american_countries = north_american_countries;
		this.european_countries = european_countries;
		this.gcc_countries = gcc_countries;
		this.mena_countries = mena_countries;
		this.sub_saharan_countries = sub_saharan_countries;
		this.asian_countries = asian_countries;
		this.latin_american_countries1 = latin_american_countries1;
		this.oceania_countries = oceania_countries;
		this.remaining_countries = remaining_countries;
		this.grand_total = grand_total;
		this.outward_family = outward_family;
		this.outward_investment = outward_investment;
		this.outward_trade = outward_trade;
		this.outward_other = outward_other;
		this.outward_total = outward_total;
		this.inward_family = inward_family;
		this.inward_investment = inward_investment;
		this.inward_trade = inward_trade;
		this.inward_other = inward_other;
		this.inward_total = inward_total;
		this.report_date = report_date;
		this.report_from_date = report_from_date;
		this.report_to_date = report_to_date;
		this.entity_flg = entity_flg;
		this.modify_flg = modify_flg;
		this.del_flg = del_flg;
		this.report_code = report_code;
		this.report_submit_date = report_submit_date;
		this.row_label = row_label;
	}
	public BRF38_ENTITY() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
