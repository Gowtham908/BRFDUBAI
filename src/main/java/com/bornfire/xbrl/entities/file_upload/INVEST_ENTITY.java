package com.bornfire.xbrl.entities.file_upload;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "INVEST_MANUAL_TABLE")
public class INVEST_ENTITY {
	private String	acct_name;
	private String	acct_no;
	private BigDecimal	no_of_securities;
	@Id
	private String	isin_code;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd-MMM-yyyy")
	private Date	maturity_date;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd-MMM-yyyy")
	private Date	report_date;
	private String	acct_crncy_code;
	private BigDecimal	acct_balance_ac;
	private BigDecimal	acct_balance_lc;
	private String	nre_flg;
	private String	specific_provisions;
	private BigDecimal	provision_lc;
	private String	provision_nre_flg;
	private String	provision_crncy;
	private BigDecimal	market_value;
	private String	country_of_incorp;
	private BigDecimal	acct_balance_lc1;
	public String getAcct_name() {
		return acct_name;
	}
	public void setAcct_name(String acct_name) {
		this.acct_name = acct_name;
	}
	public String getAcct_no() {
		return acct_no;
	}
	public void setAcct_no(String acct_no) {
		this.acct_no = acct_no;
	}
	public BigDecimal getNo_of_securities() {
		return no_of_securities;
	}
	public void setNo_of_securities(BigDecimal no_of_securities) {
		this.no_of_securities = no_of_securities;
	}
	public String getIsin_code() {
		return isin_code;
	}
	public void setIsin_code(String isin_code) {
		this.isin_code = isin_code;
	}
	public Date getMaturity_date() {
		return maturity_date;
	}
	public void setMaturity_date(Date maturity_date) {
		this.maturity_date = maturity_date;
	}
	public Date getReport_date() {
		return report_date;
	}
	public void setReport_date(Date report_date) {
		this.report_date = report_date;
	}
	public String getAcct_crncy_code() {
		return acct_crncy_code;
	}
	public void setAcct_crncy_code(String acct_crncy_code) {
		this.acct_crncy_code = acct_crncy_code;
	}
	public BigDecimal getAcct_balance_ac() {
		return acct_balance_ac;
	}
	public void setAcct_balance_ac(BigDecimal acct_balance_ac) {
		this.acct_balance_ac = acct_balance_ac;
	}
	public BigDecimal getAcct_balance_lc() {
		return acct_balance_lc;
	}
	public void setAcct_balance_lc(BigDecimal acct_balance_lc) {
		this.acct_balance_lc = acct_balance_lc;
	}
	public String getNre_flg() {
		return nre_flg;
	}
	public void setNre_flg(String nre_flg) {
		this.nre_flg = nre_flg;
	}
	public String getSpecific_provisions() {
		return specific_provisions;
	}
	public void setSpecific_provisions(String specific_provisions) {
		this.specific_provisions = specific_provisions;
	}
	public BigDecimal getProvision_lc() {
		return provision_lc;
	}
	public void setProvision_lc(BigDecimal provision_lc) {
		this.provision_lc = provision_lc;
	}
	public String getProvision_nre_flg() {
		return provision_nre_flg;
	}
	public void setProvision_nre_flg(String provision_nre_flg) {
		this.provision_nre_flg = provision_nre_flg;
	}
	public String getProvision_crncy() {
		return provision_crncy;
	}
	public void setProvision_crncy(String provision_crncy) {
		this.provision_crncy = provision_crncy;
	}
	public BigDecimal getMarket_value() {
		return market_value;
	}
	public void setMarket_value(BigDecimal market_value) {
		this.market_value = market_value;
	}
	public String getCountry_of_incorp() {
		return country_of_incorp;
	}
	public void setCountry_of_incorp(String country_of_incorp) {
		this.country_of_incorp = country_of_incorp;
	}
	public BigDecimal getAcct_balance_lc1() {
		return acct_balance_lc1;
	}
	public void setAcct_balance_lc1(BigDecimal acct_balance_lc1) {
		this.acct_balance_lc1 = acct_balance_lc1;
	}
	
	
	@Override
	public String toString() {
		return "INVEST_ENTITY [acct_name=" + acct_name + ", acct_no=" + acct_no + ", no_of_securities="
				+ no_of_securities + ", isin_code=" + isin_code + ", maturity_date=" + maturity_date + ", report_date="
				+ report_date + ", acct_crncy_code=" + acct_crncy_code + ", acct_balance_ac=" + acct_balance_ac
				+ ", acct_balance_lc=" + acct_balance_lc + ", nre_flg=" + nre_flg + ", specific_provisions="
				+ specific_provisions + ", provision_lc=" + provision_lc + ", provision_nre_flg=" + provision_nre_flg
				+ ", provision_crncy=" + provision_crncy + ", market_value=" + market_value + ", country_of_incorp="
				+ country_of_incorp + ", acct_balance_lc1=" + acct_balance_lc1 + ", getAcct_name()=" + getAcct_name()
				+ ", getAcct_no()=" + getAcct_no() + ", getNo_of_securities()=" + getNo_of_securities()
				+ ", getIsin_code()=" + getIsin_code() + ", getMaturity_date()=" + getMaturity_date()
				+ ", getReport_date()=" + getReport_date() + ", getAcct_crncy_code()=" + getAcct_crncy_code()
				+ ", getAcct_balance_ac()=" + getAcct_balance_ac() + ", getAcct_balance_lc()=" + getAcct_balance_lc()
				+ ", getNre_flg()=" + getNre_flg() + ", getSpecific_provisions()=" + getSpecific_provisions()
				+ ", getProvision_lc()=" + getProvision_lc() + ", getProvision_nre_flg()=" + getProvision_nre_flg()
				+ ", getProvision_crncy()=" + getProvision_crncy() + ", getMarket_value()=" + getMarket_value()
				+ ", getCountry_of_incorp()=" + getCountry_of_incorp() + ", getAcct_balance_lc1()="
				+ getAcct_balance_lc1() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
	
	public INVEST_ENTITY(String acct_name, String acct_no, BigDecimal no_of_securities, String isin_code,
			Date maturity_date, Date report_date, String acct_crncy_code, BigDecimal acct_balance_ac,
			BigDecimal acct_balance_lc, String nre_flg, String specific_provisions, BigDecimal provision_lc,
			String provision_nre_flg, String provision_crncy, BigDecimal market_value, String country_of_incorp,
			BigDecimal acct_balance_lc1) {
		super();
		this.acct_name = acct_name;
		this.acct_no = acct_no;
		this.no_of_securities = no_of_securities;
		this.isin_code = isin_code;
		this.maturity_date = maturity_date;
		this.report_date = report_date;
		this.acct_crncy_code = acct_crncy_code;
		this.acct_balance_ac = acct_balance_ac;
		this.acct_balance_lc = acct_balance_lc;
		this.nre_flg = nre_flg;
		this.specific_provisions = specific_provisions;
		this.provision_lc = provision_lc;
		this.provision_nre_flg = provision_nre_flg;
		this.provision_crncy = provision_crncy;
		this.market_value = market_value;
		this.country_of_incorp = country_of_incorp;
		this.acct_balance_lc1 = acct_balance_lc1;
	}
	public INVEST_ENTITY() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
