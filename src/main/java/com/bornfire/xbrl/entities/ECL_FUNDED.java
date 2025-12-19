package com.bornfire.xbrl.entities;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ECL_FB_NFB_TABLE")

public class ECL_FUNDED {
	
	private String	branch_name;
	@Id
	private String	cust_id;
	private String	account_id;
	private String	account_name;
	private String	gl_code;
	private String	gl_code_desc;
	private String	const_id;
	private String	const_desc;
	private String	schm;
	private String	schm_code_desc;
	private Date	open_date;
	private Date	maturity_date;
	private String	act_class;
	private String	currency;
	private BigDecimal	limit;
	private BigDecimal	balance;
	private BigDecimal	undrwn_balance;
	private BigDecimal	security_fdr;
	private String	ccf;
	private String	country;
	private String	int_rate;
	private String	info_flag;
	private String	payment_frequency;
	private String	ifrs_info_flag;
	private String	payment_frequency_2;
	private String	ifrs_product_id;
	private String	portfolio;
	private String	ifrs_country;
	private String	portfolio_2;
	private String	retail_segment;
	private Date	report_date;
	public String getBranch_name() {
		return branch_name;
	}
	public void setBranch_name(String branch_name) {
		this.branch_name = branch_name;
	}
	public String getCust_id() {
		return cust_id;
	}
	public void setCust_id(String cust_id) {
		this.cust_id = cust_id;
	}
	public String getAccount_id() {
		return account_id;
	}
	public void setAccount_id(String account_id) {
		this.account_id = account_id;
	}
	public String getAccount_name() {
		return account_name;
	}
	public void setAccount_name(String account_name) {
		this.account_name = account_name;
	}
	public String getGl_code() {
		return gl_code;
	}
	public void setGl_code(String gl_code) {
		this.gl_code = gl_code;
	}
	public String getGl_code_desc() {
		return gl_code_desc;
	}
	public void setGl_code_desc(String gl_code_desc) {
		this.gl_code_desc = gl_code_desc;
	}
	public String getConst_id() {
		return const_id;
	}
	public void setConst_id(String const_id) {
		this.const_id = const_id;
	}
	public String getConst_desc() {
		return const_desc;
	}
	public void setConst_desc(String const_desc) {
		this.const_desc = const_desc;
	}
	public String getSchm() {
		return schm;
	}
	public void setSchm(String schm) {
		this.schm = schm;
	}
	public String getSchm_code_desc() {
		return schm_code_desc;
	}
	public void setSchm_code_desc(String schm_code_desc) {
		this.schm_code_desc = schm_code_desc;
	}
	public Date getOpen_date() {
		return open_date;
	}
	public void setOpen_date(Date open_date) {
		this.open_date = open_date;
	}
	public Date getMaturity_date() {
		return maturity_date;
	}
	public void setMaturity_date(Date maturity_date) {
		this.maturity_date = maturity_date;
	}
	public String getAct_class() {
		return act_class;
	}
	public void setAct_class(String act_class) {
		this.act_class = act_class;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public BigDecimal getLimit() {
		return limit;
	}
	public void setLimit(BigDecimal limit) {
		this.limit = limit;
	}
	public BigDecimal getBalance() {
		return balance;
	}
	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}
	public BigDecimal getUndrwn_balance() {
		return undrwn_balance;
	}
	public void setUndrwn_balance(BigDecimal undrwn_balance) {
		this.undrwn_balance = undrwn_balance;
	}
	public BigDecimal getSecurity_fdr() {
		return security_fdr;
	}
	public void setSecurity_fdr(BigDecimal security_fdr) {
		this.security_fdr = security_fdr;
	}
	public String getCcf() {
		return ccf;
	}
	public void setCcf(String ccf) {
		this.ccf = ccf;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getInt_rate() {
		return int_rate;
	}
	public void setInt_rate(String int_rate) {
		this.int_rate = int_rate;
	}
	public String getInfo_flag() {
		return info_flag;
	}
	public void setInfo_flag(String info_flag) {
		this.info_flag = info_flag;
	}
	public String getPayment_frequency() {
		return payment_frequency;
	}
	public void setPayment_frequency(String payment_frequency) {
		this.payment_frequency = payment_frequency;
	}
	public String getIfrs_info_flag() {
		return ifrs_info_flag;
	}
	public void setIfrs_info_flag(String ifrs_info_flag) {
		this.ifrs_info_flag = ifrs_info_flag;
	}
	public String getPayment_frequency_2() {
		return payment_frequency_2;
	}
	public void setPayment_frequency_2(String payment_frequency_2) {
		this.payment_frequency_2 = payment_frequency_2;
	}
	public String getIfrs_product_id() {
		return ifrs_product_id;
	}
	public void setIfrs_product_id(String ifrs_product_id) {
		this.ifrs_product_id = ifrs_product_id;
	}
	public String getPortfolio() {
		return portfolio;
	}
	public void setPortfolio(String portfolio) {
		this.portfolio = portfolio;
	}
	public String getIfrs_country() {
		return ifrs_country;
	}
	public void setIfrs_country(String ifrs_country) {
		this.ifrs_country = ifrs_country;
	}
	public String getPortfolio_2() {
		return portfolio_2;
	}
	public void setPortfolio_2(String portfolio_2) {
		this.portfolio_2 = portfolio_2;
	}
	public String getRetail_segment() {
		return retail_segment;
	}
	public void setRetail_segment(String retail_segment) {
		this.retail_segment = retail_segment;
	}
	public Date getReport_date() {
		return report_date;
	}
	public void setReport_date(Date report_date) {
		this.report_date = report_date;
	}
	public ECL_FUNDED(String branch_name, String cust_id, String account_id, String account_name, String gl_code,
			String gl_code_desc, String const_id, String const_desc, String schm, String schm_code_desc, Date open_date,
			Date maturity_date, String act_class, String currency, BigDecimal limit, BigDecimal balance,
			BigDecimal undrwn_balance, BigDecimal security_fdr, String ccf, String country, String int_rate,
			String info_flag, String payment_frequency, String ifrs_info_flag, String payment_frequency_2,
			String ifrs_product_id, String portfolio, String ifrs_country, String portfolio_2, String retail_segment,
			Date report_date) {
		super();
		this.branch_name = branch_name;
		this.cust_id = cust_id;
		this.account_id = account_id;
		this.account_name = account_name;
		this.gl_code = gl_code;
		this.gl_code_desc = gl_code_desc;
		this.const_id = const_id;
		this.const_desc = const_desc;
		this.schm = schm;
		this.schm_code_desc = schm_code_desc;
		this.open_date = open_date;
		this.maturity_date = maturity_date;
		this.act_class = act_class;
		this.currency = currency;
		this.limit = limit;
		this.balance = balance;
		this.undrwn_balance = undrwn_balance;
		this.security_fdr = security_fdr;
		this.ccf = ccf;
		this.country = country;
		this.int_rate = int_rate;
		this.info_flag = info_flag;
		this.payment_frequency = payment_frequency;
		this.ifrs_info_flag = ifrs_info_flag;
		this.payment_frequency_2 = payment_frequency_2;
		this.ifrs_product_id = ifrs_product_id;
		this.portfolio = portfolio;
		this.ifrs_country = ifrs_country;
		this.portfolio_2 = portfolio_2;
		this.retail_segment = retail_segment;
		this.report_date = report_date;
	}
	public ECL_FUNDED() {
		super();
		// TODO Auto-generated constructor stub
	}
}
