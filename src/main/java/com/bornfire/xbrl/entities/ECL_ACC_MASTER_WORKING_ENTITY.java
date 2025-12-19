package com.bornfire.xbrl.entities;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="ECL_ACC_MASTER_WORKING")
public class ECL_ACC_MASTER_WORKING_ENTITY {
	private String	facility_id;
	@Id
	private String	customer_id;
	private String	product_id;
	private String	stage;
	private String	stage_reason;
	private Date	open_date;
	private Date	first_installment_date;
	private String	pastdue_days;
	private String	lgd_rate;
	private BigDecimal	undrawn_amount;
	private BigDecimal	drawn_amount;
	private String	ccf;
	private String	ead;
	private BigDecimal	impairment_amount;
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
	private String	customer_master_inputs;
	private String	ifrs_rating;
	private BigDecimal	internal_rating;
	private String	rating_for_pd;
	private String	ifrs_portfolio_code;
	private String	portfolio_code_working_1;
	private String	portfolio_code_working_2;
	private String	portfolio_code_working_3;
	private String	ifrs_subportfolio_code;
	private BigDecimal	asset_cat;
	private String	asset_cat_description;
	private String	scheme_code;
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
	public String getPastdue_days() {
		return pastdue_days;
	}
	public void setPastdue_days(String pastdue_days) {
		this.pastdue_days = pastdue_days;
	}
	public String getLgd_rate() {
		return lgd_rate;
	}
	public void setLgd_rate(String lgd_rate) {
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
	public String getCcf() {
		return ccf;
	}
	public void setCcf(String ccf) {
		this.ccf = ccf;
	}
	public String getEad() {
		return ead;
	}
	public void setEad(String ead) {
		this.ead = ead;
	}
	public BigDecimal getImpairment_amount() {
		return impairment_amount;
	}
	public void setImpairment_amount(BigDecimal impairment_amount) {
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
	public String getCustomer_master_inputs() {
		return customer_master_inputs;
	}
	public void setCustomer_master_inputs(String customer_master_inputs) {
		this.customer_master_inputs = customer_master_inputs;
	}
	public String getIfrs_rating() {
		return ifrs_rating;
	}
	public void setIfrs_rating(String ifrs_rating) {
		this.ifrs_rating = ifrs_rating;
	}
	public BigDecimal getInternal_rating() {
		return internal_rating;
	}
	public void setInternal_rating(BigDecimal internal_rating) {
		this.internal_rating = internal_rating;
	}
	public String getRating_for_pd() {
		return rating_for_pd;
	}
	public void setRating_for_pd(String rating_for_pd) {
		this.rating_for_pd = rating_for_pd;
	}
	public String getIfrs_portfolio_code() {
		return ifrs_portfolio_code;
	}
	public void setIfrs_portfolio_code(String ifrs_portfolio_code) {
		this.ifrs_portfolio_code = ifrs_portfolio_code;
	}
	public String getPortfolio_code_working_1() {
		return portfolio_code_working_1;
	}
	public void setPortfolio_code_working_1(String portfolio_code_working_1) {
		this.portfolio_code_working_1 = portfolio_code_working_1;
	}
	public String getPortfolio_code_working_2() {
		return portfolio_code_working_2;
	}
	public void setPortfolio_code_working_2(String portfolio_code_working_2) {
		this.portfolio_code_working_2 = portfolio_code_working_2;
	}
	public String getPortfolio_code_working_3() {
		return portfolio_code_working_3;
	}
	public void setPortfolio_code_working_3(String portfolio_code_working_3) {
		this.portfolio_code_working_3 = portfolio_code_working_3;
	}
	public String getIfrs_subportfolio_code() {
		return ifrs_subportfolio_code;
	}
	public void setIfrs_subportfolio_code(String ifrs_subportfolio_code) {
		this.ifrs_subportfolio_code = ifrs_subportfolio_code;
	}
	public BigDecimal getAsset_cat() {
		return asset_cat;
	}
	public void setAsset_cat(BigDecimal asset_cat) {
		this.asset_cat = asset_cat;
	}
	public String getAsset_cat_description() {
		return asset_cat_description;
	}
	public void setAsset_cat_description(String asset_cat_description) {
		this.asset_cat_description = asset_cat_description;
	}
	public String getScheme_code() {
		return scheme_code;
	}
	public void setScheme_code(String scheme_code) {
		this.scheme_code = scheme_code;
	}
	public Date getReport_date() {
		return report_date;
	}
	public void setReport_date(Date report_date) {
		this.report_date = report_date;
	}
	public ECL_ACC_MASTER_WORKING_ENTITY(String facility_id, String customer_id, String product_id, String stage,
			String stage_reason, Date open_date, Date first_installment_date, String pastdue_days, String lgd_rate,
			BigDecimal undrawn_amount, BigDecimal drawn_amount, String ccf, String ead, BigDecimal impairment_amount,
			Date maturity_date, BigDecimal eir, String interest_accrued, BigDecimal payment_frequency,
			BigDecimal payment_type_id, String data_import_id, String modification_flag, String written_off_flag,
			String written_off_value, BigDecimal info_flag, String currency, String modification_value,
			Date record_input_date, BigDecimal base_pd, BigDecimal positive_pd, BigDecimal negative_pd,
			String dataimportentity_id, String row_id, String nominalinterest_rate, String customer_master_inputs,
			String ifrs_rating, BigDecimal internal_rating, String rating_for_pd, String ifrs_portfolio_code,
			String portfolio_code_working_1, String portfolio_code_working_2, String portfolio_code_working_3,
			String ifrs_subportfolio_code, BigDecimal asset_cat, String asset_cat_description, String scheme_code,
			Date report_date) {
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
		this.customer_master_inputs = customer_master_inputs;
		this.ifrs_rating = ifrs_rating;
		this.internal_rating = internal_rating;
		this.rating_for_pd = rating_for_pd;
		this.ifrs_portfolio_code = ifrs_portfolio_code;
		this.portfolio_code_working_1 = portfolio_code_working_1;
		this.portfolio_code_working_2 = portfolio_code_working_2;
		this.portfolio_code_working_3 = portfolio_code_working_3;
		this.ifrs_subportfolio_code = ifrs_subportfolio_code;
		this.asset_cat = asset_cat;
		this.asset_cat_description = asset_cat_description;
		this.scheme_code = scheme_code;
		this.report_date = report_date;
	}
	public ECL_ACC_MASTER_WORKING_ENTITY() {
		super();
		// TODO Auto-generated constructor stub
	}
}