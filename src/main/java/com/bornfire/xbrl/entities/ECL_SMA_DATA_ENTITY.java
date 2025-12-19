package com.bornfire.xbrl.entities;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="ECL_SMA_DATA_TABLE")

public class ECL_SMA_DATA_ENTITY {
	
	private String	territory;
	private String	branch;
	private BigDecimal	sol_id;
	@Id
	private String	customer_id;
	private String	accountname;
	private BigDecimal	accountno;
	private String	bill_id;
	private String	scheme_code;
	private BigDecimal	gl_sub_head;
	private String	account_ccy;
	private BigDecimal	clear_balamt;
	private BigDecimal	credit_turnover;
	private BigDecimal	int_chargesamt;
	private BigDecimal	cont_excesssince;
	private BigDecimal	earliestdemandoverdue;
	private BigDecimal	totaloverdue;
	private BigDecimal	sma0;
	private BigDecimal	sma1;
	private BigDecimal	sma2;
	private Date	review_date;
	private Date	stkstatment_date;
	private String	reason_fordegradation;
	private BigDecimal	customer_wiseoorsbalance;
	private Date	npadate;
	private BigDecimal	dpd;
	private Date	as_on_date;
	private String	pan_number;
	private Date	report_date;
	public String getTerritory() {
		return territory;
	}
	public void setTerritory(String territory) {
		this.territory = territory;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	public BigDecimal getSol_id() {
		return sol_id;
	}
	public void setSol_id(BigDecimal sol_id) {
		this.sol_id = sol_id;
	}
	public String getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(String customer_id) {
		this.customer_id = customer_id;
	}
	public String getAccountname() {
		return accountname;
	}
	public void setAccountname(String accountname) {
		this.accountname = accountname;
	}
	public BigDecimal getAccountno() {
		return accountno;
	}
	public void setAccountno(BigDecimal accountno) {
		this.accountno = accountno;
	}
	public String getBill_id() {
		return bill_id;
	}
	public void setBill_id(String bill_id) {
		this.bill_id = bill_id;
	}
	public String getScheme_code() {
		return scheme_code;
	}
	public void setScheme_code(String scheme_code) {
		this.scheme_code = scheme_code;
	}
	public BigDecimal getGl_sub_head() {
		return gl_sub_head;
	}
	public void setGl_sub_head(BigDecimal gl_sub_head) {
		this.gl_sub_head = gl_sub_head;
	}
	public String getAccount_ccy() {
		return account_ccy;
	}
	public void setAccount_ccy(String account_ccy) {
		this.account_ccy = account_ccy;
	}
	public BigDecimal getClear_balamt() {
		return clear_balamt;
	}
	public void setClear_balamt(BigDecimal clear_balamt) {
		this.clear_balamt = clear_balamt;
	}
	public BigDecimal getCredit_turnover() {
		return credit_turnover;
	}
	public void setCredit_turnover(BigDecimal credit_turnover) {
		this.credit_turnover = credit_turnover;
	}
	public BigDecimal getInt_chargesamt() {
		return int_chargesamt;
	}
	public void setInt_chargesamt(BigDecimal int_chargesamt) {
		this.int_chargesamt = int_chargesamt;
	}
	public BigDecimal getCont_excesssince() {
		return cont_excesssince;
	}
	public void setCont_excesssince(BigDecimal cont_excesssince) {
		this.cont_excesssince = cont_excesssince;
	}
	public BigDecimal getEarliestdemandoverdue() {
		return earliestdemandoverdue;
	}
	public void setEarliestdemandoverdue(BigDecimal earliestdemandoverdue) {
		this.earliestdemandoverdue = earliestdemandoverdue;
	}
	public BigDecimal getTotaloverdue() {
		return totaloverdue;
	}
	public void setTotaloverdue(BigDecimal totaloverdue) {
		this.totaloverdue = totaloverdue;
	}
	public BigDecimal getSma0() {
		return sma0;
	}
	public void setSma0(BigDecimal sma0) {
		this.sma0 = sma0;
	}
	public BigDecimal getSma1() {
		return sma1;
	}
	public void setSma1(BigDecimal sma1) {
		this.sma1 = sma1;
	}
	public BigDecimal getSma2() {
		return sma2;
	}
	public void setSma2(BigDecimal sma2) {
		this.sma2 = sma2;
	}
	public Date getReview_date() {
		return review_date;
	}
	public void setReview_date(Date review_date) {
		this.review_date = review_date;
	}
	public Date getStkstatment_date() {
		return stkstatment_date;
	}
	public void setStkstatment_date(Date stkstatment_date) {
		this.stkstatment_date = stkstatment_date;
	}
	public String getReason_fordegradation() {
		return reason_fordegradation;
	}
	public void setReason_fordegradation(String reason_fordegradation) {
		this.reason_fordegradation = reason_fordegradation;
	}
	public BigDecimal getCustomer_wiseoorsbalance() {
		return customer_wiseoorsbalance;
	}
	public void setCustomer_wiseoorsbalance(BigDecimal customer_wiseoorsbalance) {
		this.customer_wiseoorsbalance = customer_wiseoorsbalance;
	}
	public Date getNpadate() {
		return npadate;
	}
	public void setNpadate(Date npadate) {
		this.npadate = npadate;
	}
	public BigDecimal getDpd() {
		return dpd;
	}
	public void setDpd(BigDecimal dpd) {
		this.dpd = dpd;
	}
	public Date getAs_on_date() {
		return as_on_date;
	}
	public void setAs_on_date(Date as_on_date) {
		this.as_on_date = as_on_date;
	}
	public String getPan_number() {
		return pan_number;
	}
	public void setPan_number(String pan_number) {
		this.pan_number = pan_number;
	}
	public Date getReport_date() {
		return report_date;
	}
	public void setReport_date(Date report_date) {
		this.report_date = report_date;
	}
	public ECL_SMA_DATA_ENTITY(String territory, String branch, BigDecimal sol_id, String customer_id,
			String accountname, BigDecimal accountno, String bill_id, String scheme_code, BigDecimal gl_sub_head,
			String account_ccy, BigDecimal clear_balamt, BigDecimal credit_turnover, BigDecimal int_chargesamt,
			BigDecimal cont_excesssince, BigDecimal earliestdemandoverdue, BigDecimal totaloverdue, BigDecimal sma0,
			BigDecimal sma1, BigDecimal sma2, Date review_date, Date stkstatment_date, String reason_fordegradation,
			BigDecimal customer_wiseoorsbalance, Date npadate, BigDecimal dpd, Date as_on_date, String pan_number,
			Date report_date) {
		super();
		this.territory = territory;
		this.branch = branch;
		this.sol_id = sol_id;
		this.customer_id = customer_id;
		this.accountname = accountname;
		this.accountno = accountno;
		this.bill_id = bill_id;
		this.scheme_code = scheme_code;
		this.gl_sub_head = gl_sub_head;
		this.account_ccy = account_ccy;
		this.clear_balamt = clear_balamt;
		this.credit_turnover = credit_turnover;
		this.int_chargesamt = int_chargesamt;
		this.cont_excesssince = cont_excesssince;
		this.earliestdemandoverdue = earliestdemandoverdue;
		this.totaloverdue = totaloverdue;
		this.sma0 = sma0;
		this.sma1 = sma1;
		this.sma2 = sma2;
		this.review_date = review_date;
		this.stkstatment_date = stkstatment_date;
		this.reason_fordegradation = reason_fordegradation;
		this.customer_wiseoorsbalance = customer_wiseoorsbalance;
		this.npadate = npadate;
		this.dpd = dpd;
		this.as_on_date = as_on_date;
		this.pan_number = pan_number;
		this.report_date = report_date;
	}
	public ECL_SMA_DATA_ENTITY() {
		super();
		// TODO Auto-generated constructor stub
	}
}