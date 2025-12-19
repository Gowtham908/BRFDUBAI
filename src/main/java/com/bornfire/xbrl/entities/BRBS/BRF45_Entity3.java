package com.bornfire.xbrl.entities.BRBS;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "BRF45C_SUMMARYTABLE")
public class BRF45_Entity3 {
	private String country;
	private BigDecimal government_resident;
	private BigDecimal gre_resident;
	private BigDecimal private_resident;
	private BigDecimal hni_resident;
	private BigDecimal individual_resident;
	private BigDecimal banking_resident;
	private BigDecimal trade_resident;
	private BigDecimal government_non_resident;
	private BigDecimal gre_non_resident;
	private BigDecimal private_non_resident;
	private BigDecimal hni_non_resident;
	private BigDecimal individual_non_resident;
	private BigDecimal banking_non_resident;
	private BigDecimal trade_non_resident;
	private String country_rem;
	private BigDecimal government_resident_rem;
	private BigDecimal gre_resident_rem;
	private BigDecimal private_resident_rem;
	private BigDecimal hni_resident_rem;
	private BigDecimal individual_resident_rem;
	private BigDecimal banking_resident_rem;
	private BigDecimal trade_resident_rem;
	private BigDecimal government_non_resident_rem;
	private BigDecimal gre_non_resident_rem;
	private BigDecimal private_non_resident_rem;
	private BigDecimal hni_non_resident_rem;
	private BigDecimal individual_non_resident_rem;
	private BigDecimal banking_non_resident_rem;
	private BigDecimal trade_non_resident_rem;
	private String report_label;
	@Id
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date report_date;
	private Date report_from_date;
	private Date report_to_date;
	private String entity_flg;
	private String modify_flg;
	private String del_flg;
	private String report_code;
	private Date report_submit_date;
	private String repdesc;
	private String frequency;

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public BigDecimal getGovernment_resident() {
		return government_resident;
	}

	public void setGovernment_resident(BigDecimal government_resident) {
		this.government_resident = government_resident;
	}

	public BigDecimal getGre_resident() {
		return gre_resident;
	}

	public void setGre_resident(BigDecimal gre_resident) {
		this.gre_resident = gre_resident;
	}

	public BigDecimal getPrivate_resident() {
		return private_resident;
	}

	public void setPrivate_resident(BigDecimal private_resident) {
		this.private_resident = private_resident;
	}

	public BigDecimal getHni_resident() {
		return hni_resident;
	}

	public void setHni_resident(BigDecimal hni_resident) {
		this.hni_resident = hni_resident;
	}

	public BigDecimal getIndividual_resident() {
		return individual_resident;
	}

	public void setIndividual_resident(BigDecimal individual_resident) {
		this.individual_resident = individual_resident;
	}

	public BigDecimal getBanking_resident() {
		return banking_resident;
	}

	public void setBanking_resident(BigDecimal banking_resident) {
		this.banking_resident = banking_resident;
	}

	public BigDecimal getTrade_resident() {
		return trade_resident;
	}

	public void setTrade_resident(BigDecimal trade_resident) {
		this.trade_resident = trade_resident;
	}

	public BigDecimal getGovernment_non_resident() {
		return government_non_resident;
	}

	public void setGovernment_non_resident(BigDecimal government_non_resident) {
		this.government_non_resident = government_non_resident;
	}

	public BigDecimal getGre_non_resident() {
		return gre_non_resident;
	}

	public void setGre_non_resident(BigDecimal gre_non_resident) {
		this.gre_non_resident = gre_non_resident;
	}

	public BigDecimal getPrivate_non_resident() {
		return private_non_resident;
	}

	public void setPrivate_non_resident(BigDecimal private_non_resident) {
		this.private_non_resident = private_non_resident;
	}

	public BigDecimal getHni_non_resident() {
		return hni_non_resident;
	}

	public void setHni_non_resident(BigDecimal hni_non_resident) {
		this.hni_non_resident = hni_non_resident;
	}

	public BigDecimal getIndividual_non_resident() {
		return individual_non_resident;
	}

	public void setIndividual_non_resident(BigDecimal individual_non_resident) {
		this.individual_non_resident = individual_non_resident;
	}

	public BigDecimal getBanking_non_resident() {
		return banking_non_resident;
	}

	public void setBanking_non_resident(BigDecimal banking_non_resident) {
		this.banking_non_resident = banking_non_resident;
	}

	public BigDecimal getTrade_non_resident() {
		return trade_non_resident;
	}

	public void setTrade_non_resident(BigDecimal trade_non_resident) {
		this.trade_non_resident = trade_non_resident;
	}

	public String getCountry_rem() {
		return country_rem;
	}

	public void setCountry_rem(String country_rem) {
		this.country_rem = country_rem;
	}

	public BigDecimal getGovernment_resident_rem() {
		return government_resident_rem;
	}

	public void setGovernment_resident_rem(BigDecimal government_resident_rem) {
		this.government_resident_rem = government_resident_rem;
	}

	public BigDecimal getGre_resident_rem() {
		return gre_resident_rem;
	}

	public void setGre_resident_rem(BigDecimal gre_resident_rem) {
		this.gre_resident_rem = gre_resident_rem;
	}

	public BigDecimal getPrivate_resident_rem() {
		return private_resident_rem;
	}

	public void setPrivate_resident_rem(BigDecimal private_resident_rem) {
		this.private_resident_rem = private_resident_rem;
	}

	public BigDecimal getHni_resident_rem() {
		return hni_resident_rem;
	}

	public void setHni_resident_rem(BigDecimal hni_resident_rem) {
		this.hni_resident_rem = hni_resident_rem;
	}

	public BigDecimal getIndividual_resident_rem() {
		return individual_resident_rem;
	}

	public void setIndividual_resident_rem(BigDecimal individual_resident_rem) {
		this.individual_resident_rem = individual_resident_rem;
	}

	public BigDecimal getBanking_resident_rem() {
		return banking_resident_rem;
	}

	public void setBanking_resident_rem(BigDecimal banking_resident_rem) {
		this.banking_resident_rem = banking_resident_rem;
	}

	public BigDecimal getTrade_resident_rem() {
		return trade_resident_rem;
	}

	public void setTrade_resident_rem(BigDecimal trade_resident_rem) {
		this.trade_resident_rem = trade_resident_rem;
	}

	public BigDecimal getGovernment_non_resident_rem() {
		return government_non_resident_rem;
	}

	public void setGovernment_non_resident_rem(BigDecimal government_non_resident_rem) {
		this.government_non_resident_rem = government_non_resident_rem;
	}

	public BigDecimal getGre_non_resident_rem() {
		return gre_non_resident_rem;
	}

	public void setGre_non_resident_rem(BigDecimal gre_non_resident_rem) {
		this.gre_non_resident_rem = gre_non_resident_rem;
	}

	public BigDecimal getPrivate_non_resident_rem() {
		return private_non_resident_rem;
	}

	public void setPrivate_non_resident_rem(BigDecimal private_non_resident_rem) {
		this.private_non_resident_rem = private_non_resident_rem;
	}

	public BigDecimal getHni_non_resident_rem() {
		return hni_non_resident_rem;
	}

	public void setHni_non_resident_rem(BigDecimal hni_non_resident_rem) {
		this.hni_non_resident_rem = hni_non_resident_rem;
	}

	public BigDecimal getIndividual_non_resident_rem() {
		return individual_non_resident_rem;
	}

	public void setIndividual_non_resident_rem(BigDecimal individual_non_resident_rem) {
		this.individual_non_resident_rem = individual_non_resident_rem;
	}

	public BigDecimal getBanking_non_resident_rem() {
		return banking_non_resident_rem;
	}

	public void setBanking_non_resident_rem(BigDecimal banking_non_resident_rem) {
		this.banking_non_resident_rem = banking_non_resident_rem;
	}

	public BigDecimal getTrade_non_resident_rem() {
		return trade_non_resident_rem;
	}

	public void setTrade_non_resident_rem(BigDecimal trade_non_resident_rem) {
		this.trade_non_resident_rem = trade_non_resident_rem;
	}

	public String getReport_label() {
		return report_label;
	}

	public void setReport_label(String report_label) {
		this.report_label = report_label;
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

	public BRF45_Entity3(String country, BigDecimal government_resident, BigDecimal gre_resident,
			BigDecimal private_resident, BigDecimal hni_resident, BigDecimal individual_resident,
			BigDecimal banking_resident, BigDecimal trade_resident, BigDecimal government_non_resident,
			BigDecimal gre_non_resident, BigDecimal private_non_resident, BigDecimal hni_non_resident,
			BigDecimal individual_non_resident, BigDecimal banking_non_resident, BigDecimal trade_non_resident,
			String country_rem, BigDecimal government_resident_rem, BigDecimal gre_resident_rem,
			BigDecimal private_resident_rem, BigDecimal hni_resident_rem, BigDecimal individual_resident_rem,
			BigDecimal banking_resident_rem, BigDecimal trade_resident_rem, BigDecimal government_non_resident_rem,
			BigDecimal gre_non_resident_rem, BigDecimal private_non_resident_rem, BigDecimal hni_non_resident_rem,
			BigDecimal individual_non_resident_rem, BigDecimal banking_non_resident_rem,
			BigDecimal trade_non_resident_rem, String report_label, Date report_date, Date report_from_date,
			Date report_to_date, String entity_flg, String modify_flg, String del_flg, String report_code,
			Date report_submit_date, String repdesc, String frequency) {
		super();
		this.country = country;
		this.government_resident = government_resident;
		this.gre_resident = gre_resident;
		this.private_resident = private_resident;
		this.hni_resident = hni_resident;
		this.individual_resident = individual_resident;
		this.banking_resident = banking_resident;
		this.trade_resident = trade_resident;
		this.government_non_resident = government_non_resident;
		this.gre_non_resident = gre_non_resident;
		this.private_non_resident = private_non_resident;
		this.hni_non_resident = hni_non_resident;
		this.individual_non_resident = individual_non_resident;
		this.banking_non_resident = banking_non_resident;
		this.trade_non_resident = trade_non_resident;
		this.country_rem = country_rem;
		this.government_resident_rem = government_resident_rem;
		this.gre_resident_rem = gre_resident_rem;
		this.private_resident_rem = private_resident_rem;
		this.hni_resident_rem = hni_resident_rem;
		this.individual_resident_rem = individual_resident_rem;
		this.banking_resident_rem = banking_resident_rem;
		this.trade_resident_rem = trade_resident_rem;
		this.government_non_resident_rem = government_non_resident_rem;
		this.gre_non_resident_rem = gre_non_resident_rem;
		this.private_non_resident_rem = private_non_resident_rem;
		this.hni_non_resident_rem = hni_non_resident_rem;
		this.individual_non_resident_rem = individual_non_resident_rem;
		this.banking_non_resident_rem = banking_non_resident_rem;
		this.trade_non_resident_rem = trade_non_resident_rem;
		this.report_label = report_label;
		this.report_date = report_date;
		this.report_from_date = report_from_date;
		this.report_to_date = report_to_date;
		this.entity_flg = entity_flg;
		this.modify_flg = modify_flg;
		this.del_flg = del_flg;
		this.report_code = report_code;
		this.report_submit_date = report_submit_date;
		this.repdesc = repdesc;
		this.frequency = frequency;
	}

	public BRF45_Entity3() {
		super();
		// TODO Auto-generated constructor stub
	}
}
