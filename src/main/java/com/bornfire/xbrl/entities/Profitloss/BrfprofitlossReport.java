


package com.bornfire.xbrl.entities.Profitloss;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name="BRF_PROFIT_LOSS_RPT_TB")
public class BrfprofitlossReport {
	
	@EmbeddedId
	BrfprofitlossReportId BrfprofitlossReportId;
	
	private String	report_id;
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date	from_date;
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date	to_date;
	private String	version_no;
	private String	currency;
	private String	ref_code_desc;
	private BigDecimal	central_bank;
	private BigDecimal	banks;
	private BigDecimal	non_bnk;
	private BigDecimal	credit_unions;
	private BigDecimal	fin_gbc1;
	private BigDecimal	trusts_nr_gbc;
	private BigDecimal	insurance_corp;
	private BigDecimal	pension;
	private BigDecimal	investment;
	private BigDecimal	holding_comp;
	private BigDecimal	financial_aux;
	private BigDecimal	central_gov;
	private BigDecimal	state_loc_gov;
	private BigDecimal	non_finance_gbc;
	private BigDecimal	gbc2;
	private BigDecimal	public_non_fin_corp;
	private BigDecimal	oth_non_fin_corp;
	private BigDecimal	household;
	private BigDecimal	non_prof_institute;
	private BigDecimal	aff_nr;
	private BigDecimal	oth_nr;
	private BigDecimal	tot_lc;
	private BigDecimal	fc_central_bnk;
	private BigDecimal	fc_banks;
	private BigDecimal	fc_non_bnk;
	private BigDecimal	fc_credit_unions;
	private BigDecimal	fc_fin_gbc1;
	private BigDecimal	fc_trusts_nr_gbc;
	private BigDecimal	fc_insurance_corp;
	private BigDecimal	fc_pension;
	private BigDecimal	fc_investment;
	private BigDecimal	fc_holding_comp;
	private BigDecimal	fc_financial_aux;
	private BigDecimal	fc_central_gov;
	private BigDecimal	fc_state_loc_gov;
	private BigDecimal	fc_non_finance_gbc;
	private BigDecimal	fc_gbc2;
	private BigDecimal	fc_public_non_fin_corp;
	private BigDecimal	fc_oth_non_fin_corp;
	private BigDecimal	fc_household;
	private BigDecimal	fc_non_prof_institute;
	private BigDecimal	fc_aff_nr_bnk;
	private BigDecimal	fc_aff_nr_non_bnk;
	private BigDecimal	fc_oth_nr_bnk;
	private BigDecimal	fc_oth_nr_non_bnk;
	private BigDecimal	tot_fc;
	private BigDecimal	grand_tot;
	
	
	public BrfprofitlossReportId getBrfprofitlossReportId() {
		return BrfprofitlossReportId;
	}
	public void setBrfprofitlossReportId(BrfprofitlossReportId brfprofitlossReportId) {
		BrfprofitlossReportId = brfprofitlossReportId;
	}
	public String getReport_id() {
		return report_id;
	}
	public void setReport_id(String report_id) {
		this.report_id = report_id;
	}
	public Date getFrom_date() {
		return from_date;
	}
	public void setFrom_date(Date from_date) {
		this.from_date = from_date;
	}
	public Date getTo_date() {
		return to_date;
	}
	public void setTo_date(Date to_date) {
		this.to_date = to_date;
	}
	public String getVersion_no() {
		return version_no;
	}
	public void setVersion_no(String version_no) {
		this.version_no = version_no;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public String getRef_code_desc() {
		return ref_code_desc;
	}
	public void setRef_code_desc(String ref_code_desc) {
		this.ref_code_desc = ref_code_desc;
	}
	public BigDecimal getCentral_bank() {
		return central_bank;
	}
	public void setCentral_bank(BigDecimal central_bank) {
		this.central_bank = central_bank;
	}
	public BigDecimal getBanks() {
		return banks;
	}
	public void setBanks(BigDecimal banks) {
		this.banks = banks;
	}
	public BigDecimal getNon_bnk() {
		return non_bnk;
	}
	public void setNon_bnk(BigDecimal non_bnk) {
		this.non_bnk = non_bnk;
	}
	public BigDecimal getCredit_unions() {
		return credit_unions;
	}
	public void setCredit_unions(BigDecimal credit_unions) {
		this.credit_unions = credit_unions;
	}
	public BigDecimal getFin_gbc1() {
		return fin_gbc1;
	}
	public void setFin_gbc1(BigDecimal fin_gbc1) {
		this.fin_gbc1 = fin_gbc1;
	}
	public BigDecimal getTrusts_nr_gbc() {
		return trusts_nr_gbc;
	}
	public void setTrusts_nr_gbc(BigDecimal trusts_nr_gbc) {
		this.trusts_nr_gbc = trusts_nr_gbc;
	}
	public BigDecimal getInsurance_corp() {
		return insurance_corp;
	}
	public void setInsurance_corp(BigDecimal insurance_corp) {
		this.insurance_corp = insurance_corp;
	}
	public BigDecimal getPension() {
		return pension;
	}
	public void setPension(BigDecimal pension) {
		this.pension = pension;
	}
	public BigDecimal getInvestment() {
		return investment;
	}
	public void setInvestment(BigDecimal investment) {
		this.investment = investment;
	}
	public BigDecimal getHolding_comp() {
		return holding_comp;
	}
	public void setHolding_comp(BigDecimal holding_comp) {
		this.holding_comp = holding_comp;
	}
	public BigDecimal getFinancial_aux() {
		return financial_aux;
	}
	public void setFinancial_aux(BigDecimal financial_aux) {
		this.financial_aux = financial_aux;
	}
	public BigDecimal getCentral_gov() {
		return central_gov;
	}
	public void setCentral_gov(BigDecimal central_gov) {
		this.central_gov = central_gov;
	}
	public BigDecimal getState_loc_gov() {
		return state_loc_gov;
	}
	public void setState_loc_gov(BigDecimal state_loc_gov) {
		this.state_loc_gov = state_loc_gov;
	}
	public BigDecimal getNon_finance_gbc() {
		return non_finance_gbc;
	}
	public void setNon_finance_gbc(BigDecimal non_finance_gbc) {
		this.non_finance_gbc = non_finance_gbc;
	}
	public BigDecimal getGbc2() {
		return gbc2;
	}
	public void setGbc2(BigDecimal gbc2) {
		this.gbc2 = gbc2;
	}
	public BigDecimal getPublic_non_fin_corp() {
		return public_non_fin_corp;
	}
	public void setPublic_non_fin_corp(BigDecimal public_non_fin_corp) {
		this.public_non_fin_corp = public_non_fin_corp;
	}
	public BigDecimal getOth_non_fin_corp() {
		return oth_non_fin_corp;
	}
	public void setOth_non_fin_corp(BigDecimal oth_non_fin_corp) {
		this.oth_non_fin_corp = oth_non_fin_corp;
	}
	public BigDecimal getHousehold() {
		return household;
	}
	public void setHousehold(BigDecimal household) {
		this.household = household;
	}
	public BigDecimal getNon_prof_institute() {
		return non_prof_institute;
	}
	public void setNon_prof_institute(BigDecimal non_prof_institute) {
		this.non_prof_institute = non_prof_institute;
	}
	public BigDecimal getAff_nr() {
		return aff_nr;
	}
	public void setAff_nr(BigDecimal aff_nr) {
		this.aff_nr = aff_nr;
	}
	public BigDecimal getOth_nr() {
		return oth_nr;
	}
	public void setOth_nr(BigDecimal oth_nr) {
		this.oth_nr = oth_nr;
	}
	public BigDecimal getTot_lc() {
		return tot_lc;
	}
	public void setTot_lc(BigDecimal tot_lc) {
		this.tot_lc = tot_lc;
	}
	public BigDecimal getFc_central_bnk() {
		return fc_central_bnk;
	}
	public void setFc_central_bnk(BigDecimal fc_central_bnk) {
		this.fc_central_bnk = fc_central_bnk;
	}
	public BigDecimal getFc_banks() {
		return fc_banks;
	}
	public void setFc_banks(BigDecimal fc_banks) {
		this.fc_banks = fc_banks;
	}
	public BigDecimal getFc_non_bnk() {
		return fc_non_bnk;
	}
	public void setFc_non_bnk(BigDecimal fc_non_bnk) {
		this.fc_non_bnk = fc_non_bnk;
	}
	public BigDecimal getFc_credit_unions() {
		return fc_credit_unions;
	}
	public void setFc_credit_unions(BigDecimal fc_credit_unions) {
		this.fc_credit_unions = fc_credit_unions;
	}
	public BigDecimal getFc_fin_gbc1() {
		return fc_fin_gbc1;
	}
	public void setFc_fin_gbc1(BigDecimal fc_fin_gbc1) {
		this.fc_fin_gbc1 = fc_fin_gbc1;
	}
	public BigDecimal getFc_trusts_nr_gbc() {
		return fc_trusts_nr_gbc;
	}
	public void setFc_trusts_nr_gbc(BigDecimal fc_trusts_nr_gbc) {
		this.fc_trusts_nr_gbc = fc_trusts_nr_gbc;
	}
	public BigDecimal getFc_insurance_corp() {
		return fc_insurance_corp;
	}
	public void setFc_insurance_corp(BigDecimal fc_insurance_corp) {
		this.fc_insurance_corp = fc_insurance_corp;
	}
	public BigDecimal getFc_pension() {
		return fc_pension;
	}
	public void setFc_pension(BigDecimal fc_pension) {
		this.fc_pension = fc_pension;
	}
	public BigDecimal getFc_investment() {
		return fc_investment;
	}
	public void setFc_investment(BigDecimal fc_investment) {
		this.fc_investment = fc_investment;
	}
	public BigDecimal getFc_holding_comp() {
		return fc_holding_comp;
	}
	public void setFc_holding_comp(BigDecimal fc_holding_comp) {
		this.fc_holding_comp = fc_holding_comp;
	}
	public BigDecimal getFc_financial_aux() {
		return fc_financial_aux;
	}
	public void setFc_financial_aux(BigDecimal fc_financial_aux) {
		this.fc_financial_aux = fc_financial_aux;
	}
	public BigDecimal getFc_central_gov() {
		return fc_central_gov;
	}
	public void setFc_central_gov(BigDecimal fc_central_gov) {
		this.fc_central_gov = fc_central_gov;
	}
	public BigDecimal getFc_state_loc_gov() {
		return fc_state_loc_gov;
	}
	public void setFc_state_loc_gov(BigDecimal fc_state_loc_gov) {
		this.fc_state_loc_gov = fc_state_loc_gov;
	}
	public BigDecimal getFc_non_finance_gbc() {
		return fc_non_finance_gbc;
	}
	public void setFc_non_finance_gbc(BigDecimal fc_non_finance_gbc) {
		this.fc_non_finance_gbc = fc_non_finance_gbc;
	}
	public BigDecimal getFc_gbc2() {
		return fc_gbc2;
	}
	public void setFc_gbc2(BigDecimal fc_gbc2) {
		this.fc_gbc2 = fc_gbc2;
	}
	public BigDecimal getFc_public_non_fin_corp() {
		return fc_public_non_fin_corp;
	}
	public void setFc_public_non_fin_corp(BigDecimal fc_public_non_fin_corp) {
		this.fc_public_non_fin_corp = fc_public_non_fin_corp;
	}
	public BigDecimal getFc_oth_non_fin_corp() {
		return fc_oth_non_fin_corp;
	}
	public void setFc_oth_non_fin_corp(BigDecimal fc_oth_non_fin_corp) {
		this.fc_oth_non_fin_corp = fc_oth_non_fin_corp;
	}
	public BigDecimal getFc_household() {
		return fc_household;
	}
	public void setFc_household(BigDecimal fc_household) {
		this.fc_household = fc_household;
	}
	public BigDecimal getFc_non_prof_institute() {
		return fc_non_prof_institute;
	}
	public void setFc_non_prof_institute(BigDecimal fc_non_prof_institute) {
		this.fc_non_prof_institute = fc_non_prof_institute;
	}
	public BigDecimal getFc_aff_nr_bnk() {
		return fc_aff_nr_bnk;
	}
	public void setFc_aff_nr_bnk(BigDecimal fc_aff_nr_bnk) {
		this.fc_aff_nr_bnk = fc_aff_nr_bnk;
	}
	public BigDecimal getFc_aff_nr_non_bnk() {
		return fc_aff_nr_non_bnk;
	}
	public void setFc_aff_nr_non_bnk(BigDecimal fc_aff_nr_non_bnk) {
		this.fc_aff_nr_non_bnk = fc_aff_nr_non_bnk;
	}
	public BigDecimal getFc_oth_nr_bnk() {
		return fc_oth_nr_bnk;
	}
	public void setFc_oth_nr_bnk(BigDecimal fc_oth_nr_bnk) {
		this.fc_oth_nr_bnk = fc_oth_nr_bnk;
	}
	public BigDecimal getFc_oth_nr_non_bnk() {
		return fc_oth_nr_non_bnk;
	}
	public void setFc_oth_nr_non_bnk(BigDecimal fc_oth_nr_non_bnk) {
		this.fc_oth_nr_non_bnk = fc_oth_nr_non_bnk;
	}
	public BigDecimal getTot_fc() {
		return tot_fc;
	}
	public void setTot_fc(BigDecimal tot_fc) {
		this.tot_fc = tot_fc;
	}
	public BigDecimal getGrand_tot() {
		return grand_tot;
	}
	public void setGrand_tot(BigDecimal grand_tot) {
		this.grand_tot = grand_tot;
	}
	
	public BrfprofitlossReport(com.bornfire.xbrl.entities.Profitloss.BrfprofitlossReportId brfprofitlossReportId,
			String report_id, Date from_date, Date to_date, String version_no, String currency, String ref_code_desc,
			BigDecimal central_bank, BigDecimal banks, BigDecimal non_bnk, BigDecimal credit_unions,
			BigDecimal fin_gbc1, BigDecimal trusts_nr_gbc, BigDecimal insurance_corp, BigDecimal pension,
			BigDecimal investment, BigDecimal holding_comp, BigDecimal financial_aux, BigDecimal central_gov,
			BigDecimal state_loc_gov, BigDecimal non_finance_gbc, BigDecimal gbc2, BigDecimal public_non_fin_corp,
			BigDecimal oth_non_fin_corp, BigDecimal household, BigDecimal non_prof_institute, BigDecimal aff_nr,
			BigDecimal oth_nr, BigDecimal tot_lc, BigDecimal fc_central_bnk, BigDecimal fc_banks, BigDecimal fc_non_bnk,
			BigDecimal fc_credit_unions, BigDecimal fc_fin_gbc1, BigDecimal fc_trusts_nr_gbc,
			BigDecimal fc_insurance_corp, BigDecimal fc_pension, BigDecimal fc_investment, BigDecimal fc_holding_comp,
			BigDecimal fc_financial_aux, BigDecimal fc_central_gov, BigDecimal fc_state_loc_gov,
			BigDecimal fc_non_finance_gbc, BigDecimal fc_gbc2, BigDecimal fc_public_non_fin_corp,
			BigDecimal fc_oth_non_fin_corp, BigDecimal fc_household, BigDecimal fc_non_prof_institute,
			BigDecimal fc_aff_nr_bnk, BigDecimal fc_aff_nr_non_bnk, BigDecimal fc_oth_nr_bnk,
			BigDecimal fc_oth_nr_non_bnk, BigDecimal tot_fc, BigDecimal grand_tot) {
		super();
		BrfprofitlossReportId = brfprofitlossReportId;
		this.report_id = report_id;
		this.from_date = from_date;
		this.to_date = to_date;
		this.version_no = version_no;
		this.currency = currency;
		this.ref_code_desc = ref_code_desc;
		this.central_bank = central_bank;
		this.banks = banks;
		this.non_bnk = non_bnk;
		this.credit_unions = credit_unions;
		this.fin_gbc1 = fin_gbc1;
		this.trusts_nr_gbc = trusts_nr_gbc;
		this.insurance_corp = insurance_corp;
		this.pension = pension;
		this.investment = investment;
		this.holding_comp = holding_comp;
		this.financial_aux = financial_aux;
		this.central_gov = central_gov;
		this.state_loc_gov = state_loc_gov;
		this.non_finance_gbc = non_finance_gbc;
		this.gbc2 = gbc2;
		this.public_non_fin_corp = public_non_fin_corp;
		this.oth_non_fin_corp = oth_non_fin_corp;
		this.household = household;
		this.non_prof_institute = non_prof_institute;
		this.aff_nr = aff_nr;
		this.oth_nr = oth_nr;
		this.tot_lc = tot_lc;
		this.fc_central_bnk = fc_central_bnk;
		this.fc_banks = fc_banks;
		this.fc_non_bnk = fc_non_bnk;
		this.fc_credit_unions = fc_credit_unions;
		this.fc_fin_gbc1 = fc_fin_gbc1;
		this.fc_trusts_nr_gbc = fc_trusts_nr_gbc;
		this.fc_insurance_corp = fc_insurance_corp;
		this.fc_pension = fc_pension;
		this.fc_investment = fc_investment;
		this.fc_holding_comp = fc_holding_comp;
		this.fc_financial_aux = fc_financial_aux;
		this.fc_central_gov = fc_central_gov;
		this.fc_state_loc_gov = fc_state_loc_gov;
		this.fc_non_finance_gbc = fc_non_finance_gbc;
		this.fc_gbc2 = fc_gbc2;
		this.fc_public_non_fin_corp = fc_public_non_fin_corp;
		this.fc_oth_non_fin_corp = fc_oth_non_fin_corp;
		this.fc_household = fc_household;
		this.fc_non_prof_institute = fc_non_prof_institute;
		this.fc_aff_nr_bnk = fc_aff_nr_bnk;
		this.fc_aff_nr_non_bnk = fc_aff_nr_non_bnk;
		this.fc_oth_nr_bnk = fc_oth_nr_bnk;
		this.fc_oth_nr_non_bnk = fc_oth_nr_non_bnk;
		this.tot_fc = tot_fc;
		this.grand_tot = grand_tot;
	}
	public BrfprofitlossReport() {
		
	}
	public BrfprofitlossReport(
			com.bornfire.xbrl.entities.Profitloss.BrfprofitlossReportId BrfprofitlossReportId2,
			String report_id2, Date from_date2, Date to_date2, String version_no2, String instance_name,
			BigDecimal resident, BigDecimal non_resident, BigDecimal total) {
		
	}
	
	
	

}
