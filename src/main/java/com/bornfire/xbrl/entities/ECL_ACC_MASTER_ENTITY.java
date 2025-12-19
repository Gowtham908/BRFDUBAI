package com.bornfire.xbrl.entities;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="ECL_ACC_MASTER")

public class ECL_ACC_MASTER_ENTITY {
	private String	facility_id;
	@Id
	private String	customer_id;
	private String	product_id;
	private String	stage;
	private String	stage_reason;
	private Date	open_date;
	private Date	first_installment_date;
	private BigDecimal	pastdue_days;
	private BigDecimal	lgd_rate;
	private BigDecimal	undrawn_amount;
	private BigDecimal	drawn_amount;
	private BigDecimal	ccf;
	private String	ead;
	private String	impairment_amount;
	private Date	maturity_date;
	private BigDecimal	eir;
	private String	interest_accrued;
	private BigDecimal	payment_frequency;
	private BigDecimal	payment_type_id;
	private String	data_import_id;
	private String	modification_flag;
	private String	written_off_flag;
	private String	written_off_value;
	private BigDecimal	info_flag;
	private String	currency;
	private String	modification_value;
	private Date	record_input_date;
	private BigDecimal	base_pd;
	private BigDecimal	positive_pd;
	private BigDecimal	negative_pd;
	private String	dataimportentity_id;
	private String	row_id;
	private String	nominalinterest_rate;
	private String	portfolio;
	private String	watch_list;
	private Date	report_date;
	public String getFacility_id() {
		return facility_id;
	}
	public void setFacility_id(String facility_id) {
		this.facility_id = facility_id;
	}
	public String getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(String customer_id) {
		this.customer_id = customer_id;
	}
	public String getProduct_id() {
		return product_id;
	}
	public void setProduct_id(String product_id) {
		this.product_id = product_id;
	}
	public String getStage() {
		return stage;
	}
	public void setStage(String stage) {
		this.stage = stage;
	}
	public String getStage_reason() {
		return stage_reason;
	}
	public void setStage_reason(String stage_reason) {
		this.stage_reason = stage_reason;
	}
	public Date getOpen_date() {
		return open_date;
	}
	public void setOpen_date(Date open_date) {
		this.open_date = open_date;
	}
	public Date getFirst_installment_date() {
		return first_installment_date;
	}
	public void setFirst_installment_date(Date first_installment_date) {
		this.first_installment_date = first_installment_date;
	}
	public BigDecimal getPastdue_days() {
		return pastdue_days;
	}
	public void setPastdue_days(BigDecimal pastdue_days) {
		this.pastdue_days = pastdue_days;
	}
	public BigDecimal getLgd_rate() {
		return lgd_rate;
	}
	public void setLgd_rate(BigDecimal lgd_rate) {
		this.lgd_rate = lgd_rate;
	}
	public BigDecimal getUndrawn_amount() {
		return undrawn_amount;
	}
	public void setUndrawn_amount(BigDecimal undrawn_amount) {
		this.undrawn_amount = undrawn_amount;
	}
	public BigDecimal getDrawn_amount() {
		return drawn_amount;
	}
	public void setDrawn_amount(BigDecimal drawn_amount) {
		this.drawn_amount = drawn_amount;
	}
	public BigDecimal getCcf() {
		return ccf;
	}
	public void setCcf(BigDecimal ccf) {
		this.ccf = ccf;
	}
	public String getEad() {
		return ead;
	}
	public void setEad(String ead) {
		this.ead = ead;
	}
	public String getImpairment_amount() {
		return impairment_amount;
	}
	public void setImpairment_amount(String impairment_amount) {
		this.impairment_amount = impairment_amount;
	}
	public Date getMaturity_date() {
		return maturity_date;
	}
	public void setMaturity_date(Date maturity_date) {
		this.maturity_date = maturity_date;
	}
	public BigDecimal getEir() {
		return eir;
	}
	public void setEir(BigDecimal eir) {
		this.eir = eir;
	}
	public String getInterest_accrued() {
		return interest_accrued;
	}
	public void setInterest_accrued(String interest_accrued) {
		this.interest_accrued = interest_accrued;
	}
	public BigDecimal getPayment_frequency() {
		return payment_frequency;
	}
	public void setPayment_frequency(BigDecimal payment_frequency) {
		this.payment_frequency = payment_frequency;
	}
	public BigDecimal getPayment_type_id() {
		return payment_type_id;
	}
	public void setPayment_type_id(BigDecimal payment_type_id) {
		this.payment_type_id = payment_type_id;
	}
	public String getData_import_id() {
		return data_import_id;
	}
	public void setData_import_id(String data_import_id) {
		this.data_import_id = data_import_id;
	}
	public String getModification_flag() {
		return modification_flag;
	}
	public void setModification_flag(String modification_flag) {
		this.modification_flag = modification_flag;
	}
	public String getWritten_off_flag() {
		return written_off_flag;
	}
	public void setWritten_off_flag(String written_off_flag) {
		this.written_off_flag = written_off_flag;
	}
	public String getWritten_off_value() {
		return written_off_value;
	}
	public void setWritten_off_value(String written_off_value) {
		this.written_off_value = written_off_value;
	}
	public BigDecimal getInfo_flag() {
		return info_flag;
	}
	public void setInfo_flag(BigDecimal info_flag) {
		this.info_flag = info_flag;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public String getModification_value() {
		return modification_value;
	}
	public void setModification_value(String modification_value) {
		this.modification_value = modification_value;
	}
	public Date getRecord_input_date() {
		return record_input_date;
	}
	public void setRecord_input_date(Date record_input_date) {
		this.record_input_date = record_input_date;
	}
	public BigDecimal getBase_pd() {
		return base_pd;
	}
	public void setBase_pd(BigDecimal base_pd) {
		this.base_pd = base_pd;
	}
	public BigDecimal getPositive_pd() {
		return positive_pd;
	}
	public void setPositive_pd(BigDecimal positive_pd) {
		this.positive_pd = positive_pd;
	}
	public BigDecimal getNegative_pd() {
		return negative_pd;
	}
	public void setNegative_pd(BigDecimal negative_pd) {
		this.negative_pd = negative_pd;
	}
	public String getDataimportentity_id() {
		return dataimportentity_id;
	}
	public void setDataimportentity_id(String dataimportentity_id) {
		this.dataimportentity_id = dataimportentity_id;
	}
	public String getRow_id() {
		return row_id;
	}
	public void setRow_id(String row_id) {
		this.row_id = row_id;
	}
	public String getNominalinterest_rate() {
		return nominalinterest_rate;
	}
	public void setNominalinterest_rate(String nominalinterest_rate) {
		this.nominalinterest_rate = nominalinterest_rate;
	}
	public String getPortfolio() {
		return portfolio;
	}
	public void setPortfolio(String portfolio) {
		this.portfolio = portfolio;
	}
	public String getWatch_list() {
		return watch_list;
	}
	public void setWatch_list(String watch_list) {
		this.watch_list = watch_list;
	}
	public Date getReport_date() {
		return report_date;
	}
	public void setReport_date(Date report_date) {
		this.report_date = report_date;
	}
	public ECL_ACC_MASTER_ENTITY(String facility_id, String customer_id, String product_id, String stage,
			String stage_reason, Date open_date, Date first_installment_date, BigDecimal pastdue_days,
			BigDecimal lgd_rate, BigDecimal undrawn_amount, BigDecimal drawn_amount, BigDecimal ccf, String ead,
			String impairment_amount, Date maturity_date, BigDecimal eir, String interest_accrued,
			BigDecimal payment_frequency, BigDecimal payment_type_id, String data_import_id, String modification_flag,
			String written_off_flag, String written_off_value, BigDecimal info_flag, String currency,
			String modification_value, Date record_input_date, BigDecimal base_pd, BigDecimal positive_pd,
			BigDecimal negative_pd, String dataimportentity_id, String row_id, String nominalinterest_rate,
			String portfolio, String watch_list, Date report_date) {
		super();
		this.facility_id = facility_id;
		this.customer_id = customer_id;
		this.product_id = product_id;
		this.stage = stage;
		this.stage_reason = stage_reason;
		this.open_date = open_date;
		this.first_installment_date = first_installment_date;
		this.pastdue_days = pastdue_days;
		this.lgd_rate = lgd_rate;
		this.undrawn_amount = undrawn_amount;
		this.drawn_amount = drawn_amount;
		this.ccf = ccf;
		this.ead = ead;
		this.impairment_amount = impairment_amount;
		this.maturity_date = maturity_date;
		this.eir = eir;
		this.interest_accrued = interest_accrued;
		this.payment_frequency = payment_frequency;
		this.payment_type_id = payment_type_id;
		this.data_import_id = data_import_id;
		this.modification_flag = modification_flag;
		this.written_off_flag = written_off_flag;
		this.written_off_value = written_off_value;
		this.info_flag = info_flag;
		this.currency = currency;
		this.modification_value = modification_value;
		this.record_input_date = record_input_date;
		this.base_pd = base_pd;
		this.positive_pd = positive_pd;
		this.negative_pd = negative_pd;
		this.dataimportentity_id = dataimportentity_id;
		this.row_id = row_id;
		this.nominalinterest_rate = nominalinterest_rate;
		this.portfolio = portfolio;
		this.watch_list = watch_list;
		this.report_date = report_date;
	}
	public ECL_ACC_MASTER_ENTITY() {
		super();
		// TODO Auto-generated constructor stub
	}
}

