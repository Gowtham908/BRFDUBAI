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
@Table(name="BRF38B_SUMMARYTABLE")
public class BRF38_ENTITY2 {
	private String	country_break_down;
	private String	remaining_countries;
	private BigDecimal	outward_family1;
	private BigDecimal	outward_investment1;
	private BigDecimal	outward_trade1;
	private BigDecimal	outward_other1;
	private BigDecimal	outward_total1;
	private BigDecimal	inward_family1;
	private BigDecimal	inward_investment1;
	private BigDecimal	inward_trade1;
	private BigDecimal	inward_other1;
	private BigDecimal	inward_total1;
	private String	grand_total;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Id
	private Date	report_date;
	private Date	report_from_date;
	private Date	report_to_date;
	private String	entity_flg;
	private String	modify_flg;
	private String	del_flg;
	private String	report_code;
	private Date	report_submit_date;
	private String	row_label;
	private BigDecimal	outward_family_rem;
	private BigDecimal	outward_investment_rem;
	private BigDecimal	outward_trade_rem;
	private BigDecimal	outward_other_rem;
	private BigDecimal	outward_total_rem;
	private BigDecimal	inward_family_rem;
	private BigDecimal	inward_investment_rem;
	private BigDecimal	inward_trade_rem;
	private BigDecimal	inward_other_rem;
	private BigDecimal	inward_total_rem;
	private String	repdesc;
	private String	frequency;
	public String getCountry_break_down() {
		return country_break_down;
	}
	public void setCountry_break_down(String country_break_down) {
		this.country_break_down = country_break_down;
	}
	public String getRemaining_countries() {
		return remaining_countries;
	}
	public void setRemaining_countries(String remaining_countries) {
		this.remaining_countries = remaining_countries;
	}
	public BigDecimal getOutward_family1() {
		return outward_family1;
	}
	public void setOutward_family1(BigDecimal outward_family1) {
		this.outward_family1 = outward_family1;
	}
	public BigDecimal getOutward_investment1() {
		return outward_investment1;
	}
	public void setOutward_investment1(BigDecimal outward_investment1) {
		this.outward_investment1 = outward_investment1;
	}
	public BigDecimal getOutward_trade1() {
		return outward_trade1;
	}
	public void setOutward_trade1(BigDecimal outward_trade1) {
		this.outward_trade1 = outward_trade1;
	}
	public BigDecimal getOutward_other1() {
		return outward_other1;
	}
	public void setOutward_other1(BigDecimal outward_other1) {
		this.outward_other1 = outward_other1;
	}
	public BigDecimal getOutward_total1() {
		return outward_total1;
	}
	public void setOutward_total1(BigDecimal outward_total1) {
		this.outward_total1 = outward_total1;
	}
	public BigDecimal getInward_family1() {
		return inward_family1;
	}
	public void setInward_family1(BigDecimal inward_family1) {
		this.inward_family1 = inward_family1;
	}
	public BigDecimal getInward_investment1() {
		return inward_investment1;
	}
	public void setInward_investment1(BigDecimal inward_investment1) {
		this.inward_investment1 = inward_investment1;
	}
	public BigDecimal getInward_trade1() {
		return inward_trade1;
	}
	public void setInward_trade1(BigDecimal inward_trade1) {
		this.inward_trade1 = inward_trade1;
	}
	public BigDecimal getInward_other1() {
		return inward_other1;
	}
	public void setInward_other1(BigDecimal inward_other1) {
		this.inward_other1 = inward_other1;
	}
	public BigDecimal getInward_total1() {
		return inward_total1;
	}
	public void setInward_total1(BigDecimal inward_total1) {
		this.inward_total1 = inward_total1;
	}
	public String getGrand_total() {
		return grand_total;
	}
	public void setGrand_total(String grand_total) {
		this.grand_total = grand_total;
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
	public BigDecimal getOutward_family_rem() {
		return outward_family_rem;
	}
	public void setOutward_family_rem(BigDecimal outward_family_rem) {
		this.outward_family_rem = outward_family_rem;
	}
	public BigDecimal getOutward_investment_rem() {
		return outward_investment_rem;
	}
	public void setOutward_investment_rem(BigDecimal outward_investment_rem) {
		this.outward_investment_rem = outward_investment_rem;
	}
	public BigDecimal getOutward_trade_rem() {
		return outward_trade_rem;
	}
	public void setOutward_trade_rem(BigDecimal outward_trade_rem) {
		this.outward_trade_rem = outward_trade_rem;
	}
	public BigDecimal getOutward_other_rem() {
		return outward_other_rem;
	}
	public void setOutward_other_rem(BigDecimal outward_other_rem) {
		this.outward_other_rem = outward_other_rem;
	}
	public BigDecimal getOutward_total_rem() {
		return outward_total_rem;
	}
	public void setOutward_total_rem(BigDecimal outward_total_rem) {
		this.outward_total_rem = outward_total_rem;
	}
	public BigDecimal getInward_family_rem() {
		return inward_family_rem;
	}
	public void setInward_family_rem(BigDecimal inward_family_rem) {
		this.inward_family_rem = inward_family_rem;
	}
	public BigDecimal getInward_investment_rem() {
		return inward_investment_rem;
	}
	public void setInward_investment_rem(BigDecimal inward_investment_rem) {
		this.inward_investment_rem = inward_investment_rem;
	}
	public BigDecimal getInward_trade_rem() {
		return inward_trade_rem;
	}
	public void setInward_trade_rem(BigDecimal inward_trade_rem) {
		this.inward_trade_rem = inward_trade_rem;
	}
	public BigDecimal getInward_other_rem() {
		return inward_other_rem;
	}
	public void setInward_other_rem(BigDecimal inward_other_rem) {
		this.inward_other_rem = inward_other_rem;
	}
	public BigDecimal getInward_total_rem() {
		return inward_total_rem;
	}
	public void setInward_total_rem(BigDecimal inward_total_rem) {
		this.inward_total_rem = inward_total_rem;
	}
	public String getRepdesc() {
		return repdesc;
	}
	public void setRepdesc(String repdesc) {
		this.repdesc = repdesc;
	}
	public String getFrequency() {
		return frequency;
	}
	public void setFrequency(String frequency) {
		this.frequency = frequency;
	}
	public BRF38_ENTITY2(String country_break_down, String remaining_countries, BigDecimal outward_family1,
			BigDecimal outward_investment1, BigDecimal outward_trade1, BigDecimal outward_other1,
			BigDecimal outward_total1, BigDecimal inward_family1, BigDecimal inward_investment1,
			BigDecimal inward_trade1, BigDecimal inward_other1, BigDecimal inward_total1, String grand_total,
			Date report_date, Date report_from_date, Date report_to_date, String entity_flg, String modify_flg,
			String del_flg, String report_code, Date report_submit_date, String row_label,
			BigDecimal outward_family_rem, BigDecimal outward_investment_rem, BigDecimal outward_trade_rem,
			BigDecimal outward_other_rem, BigDecimal outward_total_rem, BigDecimal inward_family_rem,
			BigDecimal inward_investment_rem, BigDecimal inward_trade_rem, BigDecimal inward_other_rem,
			BigDecimal inward_total_rem, String repdesc, String frequency) {
		super();
		this.country_break_down = country_break_down;
		this.remaining_countries = remaining_countries;
		this.outward_family1 = outward_family1;
		this.outward_investment1 = outward_investment1;
		this.outward_trade1 = outward_trade1;
		this.outward_other1 = outward_other1;
		this.outward_total1 = outward_total1;
		this.inward_family1 = inward_family1;
		this.inward_investment1 = inward_investment1;
		this.inward_trade1 = inward_trade1;
		this.inward_other1 = inward_other1;
		this.inward_total1 = inward_total1;
		this.grand_total = grand_total;
		this.report_date = report_date;
		this.report_from_date = report_from_date;
		this.report_to_date = report_to_date;
		this.entity_flg = entity_flg;
		this.modify_flg = modify_flg;
		this.del_flg = del_flg;
		this.report_code = report_code;
		this.report_submit_date = report_submit_date;
		this.row_label = row_label;
		this.outward_family_rem = outward_family_rem;
		this.outward_investment_rem = outward_investment_rem;
		this.outward_trade_rem = outward_trade_rem;
		this.outward_other_rem = outward_other_rem;
		this.outward_total_rem = outward_total_rem;
		this.inward_family_rem = inward_family_rem;
		this.inward_investment_rem = inward_investment_rem;
		this.inward_trade_rem = inward_trade_rem;
		this.inward_other_rem = inward_other_rem;
		this.inward_total_rem = inward_total_rem;
		this.repdesc = repdesc;
		this.frequency = frequency;
	}
	public BRF38_ENTITY2() {
		super();
		// TODO Auto-generated constructor stub
	}
}
