package com.bornfire.xbrl.entities.BRBS;

import java.math.BigDecimal;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="BRF208_SUMMARYTABLE2")
public class BRF208_Entity2 {
	
	@Id
	private Date	report_date;
	private String	r91_product;
	private BigDecimal	r91_bank_operations;
	private BigDecimal	r91_banking_subsidiaries;
	private BigDecimal	r91_financial_subsidiaries_uae;
	private BigDecimal	r91_financial_subsidiaries_outside_uae;
	private BigDecimal	r91_all_other_subs_uae;
	private BigDecimal	r91_all_other_subs_outside_uae;
	private BigDecimal	r91_gross_liabilities;
	private BigDecimal	r91_elimination;
	private BigDecimal	r91_reclassification;
	private BigDecimal	r91_consolidated_liabilities;
	private String	r92_product;
	private BigDecimal	r92_bank_operations;
	private BigDecimal	r92_banking_subsidiaries;
	private BigDecimal	r92_financial_subsidiaries_uae;
	private BigDecimal	r92_financial_subsidiaries_outside_uae;
	private BigDecimal	r92_all_other_subs_uae;
	private BigDecimal	r92_all_other_subs_outside_uae;
	private BigDecimal	r92_gross_liabilities;
	private BigDecimal	r92_elimination;
	private BigDecimal	r92_reclassification;
	private BigDecimal	r92_consolidated_liabilities;
	private String	r93_product;
	private BigDecimal	r93_bank_operations;
	private BigDecimal	r93_banking_subsidiaries;
	private BigDecimal	r93_financial_subsidiaries_uae;
	private BigDecimal	r93_financial_subsidiaries_outside_uae;
	private BigDecimal	r93_all_other_subs_uae;
	private BigDecimal	r93_all_other_subs_outside_uae;
	private BigDecimal	r93_gross_liabilities;
	private BigDecimal	r93_elimination;
	private BigDecimal	r93_reclassification;
	private BigDecimal	r93_consolidated_liabilities;
	private String	r94_product;
	private BigDecimal	r94_bank_operations;
	private BigDecimal	r94_banking_subsidiaries;
	private BigDecimal	r94_financial_subsidiaries_uae;
	private BigDecimal	r94_financial_subsidiaries_outside_uae;
	private BigDecimal	r94_all_other_subs_uae;
	private BigDecimal	r94_all_other_subs_outside_uae;
	private BigDecimal	r94_gross_liabilities;
	private BigDecimal	r94_elimination;
	private BigDecimal	r94_reclassification;
	private BigDecimal	r94_consolidated_liabilities;
	private String	r95_product;
	private BigDecimal	r95_bank_operations;
	private BigDecimal	r95_banking_subsidiaries;
	private BigDecimal	r95_financial_subsidiaries_uae;
	private BigDecimal	r95_financial_subsidiaries_outside_uae;
	private BigDecimal	r95_all_other_subs_uae;
	private BigDecimal	r95_all_other_subs_outside_uae;
	private BigDecimal	r95_gross_liabilities;
	private BigDecimal	r95_elimination;
	private BigDecimal	r95_reclassification;
	private BigDecimal	r95_consolidated_liabilities;
	private String	r96_product;
	private BigDecimal	r96_bank_operations;
	private BigDecimal	r96_banking_subsidiaries;
	private BigDecimal	r96_financial_subsidiaries_uae;
	private BigDecimal	r96_financial_subsidiaries_outside_uae;
	private BigDecimal	r96_all_other_subs_uae;
	private BigDecimal	r96_all_other_subs_outside_uae;
	private BigDecimal	r96_gross_liabilities;
	private BigDecimal	r96_elimination;
	private BigDecimal	r96_reclassification;
	private BigDecimal	r96_consolidated_liabilities;
	private String	r97_product;
	private BigDecimal	r97_stage3_loans;
	private BigDecimal	r97_stage3_investments;
	private BigDecimal	r97_all_other_assets;
	private BigDecimal	r97_loan_advances;
	private BigDecimal	r97_legacy_interest;
	private BigDecimal	r97_provision;
	private BigDecimal	r97_total;
	private String	r98_product;
	private BigDecimal	r98_stage3_loans;
	private BigDecimal	r98_stage3_investments;
	private BigDecimal	r98_all_other_assets;
	private BigDecimal	r98_loan_advances;
	private BigDecimal	r98_legacy_interest;
	private BigDecimal	r98_provision;
	private BigDecimal	r98_total;
	private String	r99_product;
	private BigDecimal	r99_stage3_loans;
	private BigDecimal	r99_stage3_investments;
	private BigDecimal	r99_all_other_assets;
	private BigDecimal	r99_loan_advances;
	private BigDecimal	r99_legacy_interest;
	private BigDecimal	r99_provision;
	private BigDecimal	r99_total;
	private String	r100_product;
	private BigDecimal	r100_stage3_loans;
	private BigDecimal	r100_stage3_investments;
	private BigDecimal	r100_all_other_assets;
	private BigDecimal	r100_loan_advances;
	private BigDecimal	r100_legacy_interest;
	private BigDecimal	r100_provision;
	private BigDecimal	r100_total;
	private String	r101_product;
	private BigDecimal	r101_stage3_loans;
	private BigDecimal	r101_stage3_investments;
	private BigDecimal	r101_all_other_assets;
	private BigDecimal	r101_loan_advances;
	private BigDecimal	r101_legacy_interest;
	private BigDecimal	r101_provision;
	private BigDecimal	r101_total;
	private Date	report_submit_date;
	private Date	report_from_date;
	private Date	report_to_date;
	private String	report_code;
	private String	entity_flg;
	private String	modify_flg;
	private String	del_flg;
	private String	repdesc;
	private String	frequency;
	public Date getReport_date() {
		return report_date;
	}
	public void setReport_date(Date report_date) {
		this.report_date = report_date;
	}
	public String getR91_product() {
		return r91_product;
	}
	public void setR91_product(String r91_product) {
		this.r91_product = r91_product;
	}
	public BigDecimal getR91_bank_operations() {
		return r91_bank_operations;
	}
	public void setR91_bank_operations(BigDecimal r91_bank_operations) {
		this.r91_bank_operations = r91_bank_operations;
	}
	public BigDecimal getR91_banking_subsidiaries() {
		return r91_banking_subsidiaries;
	}
	public void setR91_banking_subsidiaries(BigDecimal r91_banking_subsidiaries) {
		this.r91_banking_subsidiaries = r91_banking_subsidiaries;
	}
	public BigDecimal getR91_financial_subsidiaries_uae() {
		return r91_financial_subsidiaries_uae;
	}
	public void setR91_financial_subsidiaries_uae(BigDecimal r91_financial_subsidiaries_uae) {
		this.r91_financial_subsidiaries_uae = r91_financial_subsidiaries_uae;
	}
	public BigDecimal getR91_financial_subsidiaries_outside_uae() {
		return r91_financial_subsidiaries_outside_uae;
	}
	public void setR91_financial_subsidiaries_outside_uae(BigDecimal r91_financial_subsidiaries_outside_uae) {
		this.r91_financial_subsidiaries_outside_uae = r91_financial_subsidiaries_outside_uae;
	}
	public BigDecimal getR91_all_other_subs_uae() {
		return r91_all_other_subs_uae;
	}
	public void setR91_all_other_subs_uae(BigDecimal r91_all_other_subs_uae) {
		this.r91_all_other_subs_uae = r91_all_other_subs_uae;
	}
	public BigDecimal getR91_all_other_subs_outside_uae() {
		return r91_all_other_subs_outside_uae;
	}
	public void setR91_all_other_subs_outside_uae(BigDecimal r91_all_other_subs_outside_uae) {
		this.r91_all_other_subs_outside_uae = r91_all_other_subs_outside_uae;
	}
	public BigDecimal getR91_gross_liabilities() {
		return r91_gross_liabilities;
	}
	public void setR91_gross_liabilities(BigDecimal r91_gross_liabilities) {
		this.r91_gross_liabilities = r91_gross_liabilities;
	}
	public BigDecimal getR91_elimination() {
		return r91_elimination;
	}
	public void setR91_elimination(BigDecimal r91_elimination) {
		this.r91_elimination = r91_elimination;
	}
	public BigDecimal getR91_reclassification() {
		return r91_reclassification;
	}
	public void setR91_reclassification(BigDecimal r91_reclassification) {
		this.r91_reclassification = r91_reclassification;
	}
	public BigDecimal getR91_consolidated_liabilities() {
		return r91_consolidated_liabilities;
	}
	public void setR91_consolidated_liabilities(BigDecimal r91_consolidated_liabilities) {
		this.r91_consolidated_liabilities = r91_consolidated_liabilities;
	}
	public String getR92_product() {
		return r92_product;
	}
	public void setR92_product(String r92_product) {
		this.r92_product = r92_product;
	}
	public BigDecimal getR92_bank_operations() {
		return r92_bank_operations;
	}
	public void setR92_bank_operations(BigDecimal r92_bank_operations) {
		this.r92_bank_operations = r92_bank_operations;
	}
	public BigDecimal getR92_banking_subsidiaries() {
		return r92_banking_subsidiaries;
	}
	public void setR92_banking_subsidiaries(BigDecimal r92_banking_subsidiaries) {
		this.r92_banking_subsidiaries = r92_banking_subsidiaries;
	}
	public BigDecimal getR92_financial_subsidiaries_uae() {
		return r92_financial_subsidiaries_uae;
	}
	public void setR92_financial_subsidiaries_uae(BigDecimal r92_financial_subsidiaries_uae) {
		this.r92_financial_subsidiaries_uae = r92_financial_subsidiaries_uae;
	}
	public BigDecimal getR92_financial_subsidiaries_outside_uae() {
		return r92_financial_subsidiaries_outside_uae;
	}
	public void setR92_financial_subsidiaries_outside_uae(BigDecimal r92_financial_subsidiaries_outside_uae) {
		this.r92_financial_subsidiaries_outside_uae = r92_financial_subsidiaries_outside_uae;
	}
	public BigDecimal getR92_all_other_subs_uae() {
		return r92_all_other_subs_uae;
	}
	public void setR92_all_other_subs_uae(BigDecimal r92_all_other_subs_uae) {
		this.r92_all_other_subs_uae = r92_all_other_subs_uae;
	}
	public BigDecimal getR92_all_other_subs_outside_uae() {
		return r92_all_other_subs_outside_uae;
	}
	public void setR92_all_other_subs_outside_uae(BigDecimal r92_all_other_subs_outside_uae) {
		this.r92_all_other_subs_outside_uae = r92_all_other_subs_outside_uae;
	}
	public BigDecimal getR92_gross_liabilities() {
		return r92_gross_liabilities;
	}
	public void setR92_gross_liabilities(BigDecimal r92_gross_liabilities) {
		this.r92_gross_liabilities = r92_gross_liabilities;
	}
	public BigDecimal getR92_elimination() {
		return r92_elimination;
	}
	public void setR92_elimination(BigDecimal r92_elimination) {
		this.r92_elimination = r92_elimination;
	}
	public BigDecimal getR92_reclassification() {
		return r92_reclassification;
	}
	public void setR92_reclassification(BigDecimal r92_reclassification) {
		this.r92_reclassification = r92_reclassification;
	}
	public BigDecimal getR92_consolidated_liabilities() {
		return r92_consolidated_liabilities;
	}
	public void setR92_consolidated_liabilities(BigDecimal r92_consolidated_liabilities) {
		this.r92_consolidated_liabilities = r92_consolidated_liabilities;
	}
	public String getR93_product() {
		return r93_product;
	}
	public void setR93_product(String r93_product) {
		this.r93_product = r93_product;
	}
	public BigDecimal getR93_bank_operations() {
		return r93_bank_operations;
	}
	public void setR93_bank_operations(BigDecimal r93_bank_operations) {
		this.r93_bank_operations = r93_bank_operations;
	}
	public BigDecimal getR93_banking_subsidiaries() {
		return r93_banking_subsidiaries;
	}
	public void setR93_banking_subsidiaries(BigDecimal r93_banking_subsidiaries) {
		this.r93_banking_subsidiaries = r93_banking_subsidiaries;
	}
	public BigDecimal getR93_financial_subsidiaries_uae() {
		return r93_financial_subsidiaries_uae;
	}
	public void setR93_financial_subsidiaries_uae(BigDecimal r93_financial_subsidiaries_uae) {
		this.r93_financial_subsidiaries_uae = r93_financial_subsidiaries_uae;
	}
	public BigDecimal getR93_financial_subsidiaries_outside_uae() {
		return r93_financial_subsidiaries_outside_uae;
	}
	public void setR93_financial_subsidiaries_outside_uae(BigDecimal r93_financial_subsidiaries_outside_uae) {
		this.r93_financial_subsidiaries_outside_uae = r93_financial_subsidiaries_outside_uae;
	}
	public BigDecimal getR93_all_other_subs_uae() {
		return r93_all_other_subs_uae;
	}
	public void setR93_all_other_subs_uae(BigDecimal r93_all_other_subs_uae) {
		this.r93_all_other_subs_uae = r93_all_other_subs_uae;
	}
	public BigDecimal getR93_all_other_subs_outside_uae() {
		return r93_all_other_subs_outside_uae;
	}
	public void setR93_all_other_subs_outside_uae(BigDecimal r93_all_other_subs_outside_uae) {
		this.r93_all_other_subs_outside_uae = r93_all_other_subs_outside_uae;
	}
	public BigDecimal getR93_gross_liabilities() {
		return r93_gross_liabilities;
	}
	public void setR93_gross_liabilities(BigDecimal r93_gross_liabilities) {
		this.r93_gross_liabilities = r93_gross_liabilities;
	}
	public BigDecimal getR93_elimination() {
		return r93_elimination;
	}
	public void setR93_elimination(BigDecimal r93_elimination) {
		this.r93_elimination = r93_elimination;
	}
	public BigDecimal getR93_reclassification() {
		return r93_reclassification;
	}
	public void setR93_reclassification(BigDecimal r93_reclassification) {
		this.r93_reclassification = r93_reclassification;
	}
	public BigDecimal getR93_consolidated_liabilities() {
		return r93_consolidated_liabilities;
	}
	public void setR93_consolidated_liabilities(BigDecimal r93_consolidated_liabilities) {
		this.r93_consolidated_liabilities = r93_consolidated_liabilities;
	}
	public String getR94_product() {
		return r94_product;
	}
	public void setR94_product(String r94_product) {
		this.r94_product = r94_product;
	}
	public BigDecimal getR94_bank_operations() {
		return r94_bank_operations;
	}
	public void setR94_bank_operations(BigDecimal r94_bank_operations) {
		this.r94_bank_operations = r94_bank_operations;
	}
	public BigDecimal getR94_banking_subsidiaries() {
		return r94_banking_subsidiaries;
	}
	public void setR94_banking_subsidiaries(BigDecimal r94_banking_subsidiaries) {
		this.r94_banking_subsidiaries = r94_banking_subsidiaries;
	}
	public BigDecimal getR94_financial_subsidiaries_uae() {
		return r94_financial_subsidiaries_uae;
	}
	public void setR94_financial_subsidiaries_uae(BigDecimal r94_financial_subsidiaries_uae) {
		this.r94_financial_subsidiaries_uae = r94_financial_subsidiaries_uae;
	}
	public BigDecimal getR94_financial_subsidiaries_outside_uae() {
		return r94_financial_subsidiaries_outside_uae;
	}
	public void setR94_financial_subsidiaries_outside_uae(BigDecimal r94_financial_subsidiaries_outside_uae) {
		this.r94_financial_subsidiaries_outside_uae = r94_financial_subsidiaries_outside_uae;
	}
	public BigDecimal getR94_all_other_subs_uae() {
		return r94_all_other_subs_uae;
	}
	public void setR94_all_other_subs_uae(BigDecimal r94_all_other_subs_uae) {
		this.r94_all_other_subs_uae = r94_all_other_subs_uae;
	}
	public BigDecimal getR94_all_other_subs_outside_uae() {
		return r94_all_other_subs_outside_uae;
	}
	public void setR94_all_other_subs_outside_uae(BigDecimal r94_all_other_subs_outside_uae) {
		this.r94_all_other_subs_outside_uae = r94_all_other_subs_outside_uae;
	}
	public BigDecimal getR94_gross_liabilities() {
		return r94_gross_liabilities;
	}
	public void setR94_gross_liabilities(BigDecimal r94_gross_liabilities) {
		this.r94_gross_liabilities = r94_gross_liabilities;
	}
	public BigDecimal getR94_elimination() {
		return r94_elimination;
	}
	public void setR94_elimination(BigDecimal r94_elimination) {
		this.r94_elimination = r94_elimination;
	}
	public BigDecimal getR94_reclassification() {
		return r94_reclassification;
	}
	public void setR94_reclassification(BigDecimal r94_reclassification) {
		this.r94_reclassification = r94_reclassification;
	}
	public BigDecimal getR94_consolidated_liabilities() {
		return r94_consolidated_liabilities;
	}
	public void setR94_consolidated_liabilities(BigDecimal r94_consolidated_liabilities) {
		this.r94_consolidated_liabilities = r94_consolidated_liabilities;
	}
	public String getR95_product() {
		return r95_product;
	}
	public void setR95_product(String r95_product) {
		this.r95_product = r95_product;
	}
	public BigDecimal getR95_bank_operations() {
		return r95_bank_operations;
	}
	public void setR95_bank_operations(BigDecimal r95_bank_operations) {
		this.r95_bank_operations = r95_bank_operations;
	}
	public BigDecimal getR95_banking_subsidiaries() {
		return r95_banking_subsidiaries;
	}
	public void setR95_banking_subsidiaries(BigDecimal r95_banking_subsidiaries) {
		this.r95_banking_subsidiaries = r95_banking_subsidiaries;
	}
	public BigDecimal getR95_financial_subsidiaries_uae() {
		return r95_financial_subsidiaries_uae;
	}
	public void setR95_financial_subsidiaries_uae(BigDecimal r95_financial_subsidiaries_uae) {
		this.r95_financial_subsidiaries_uae = r95_financial_subsidiaries_uae;
	}
	public BigDecimal getR95_financial_subsidiaries_outside_uae() {
		return r95_financial_subsidiaries_outside_uae;
	}
	public void setR95_financial_subsidiaries_outside_uae(BigDecimal r95_financial_subsidiaries_outside_uae) {
		this.r95_financial_subsidiaries_outside_uae = r95_financial_subsidiaries_outside_uae;
	}
	public BigDecimal getR95_all_other_subs_uae() {
		return r95_all_other_subs_uae;
	}
	public void setR95_all_other_subs_uae(BigDecimal r95_all_other_subs_uae) {
		this.r95_all_other_subs_uae = r95_all_other_subs_uae;
	}
	public BigDecimal getR95_all_other_subs_outside_uae() {
		return r95_all_other_subs_outside_uae;
	}
	public void setR95_all_other_subs_outside_uae(BigDecimal r95_all_other_subs_outside_uae) {
		this.r95_all_other_subs_outside_uae = r95_all_other_subs_outside_uae;
	}
	public BigDecimal getR95_gross_liabilities() {
		return r95_gross_liabilities;
	}
	public void setR95_gross_liabilities(BigDecimal r95_gross_liabilities) {
		this.r95_gross_liabilities = r95_gross_liabilities;
	}
	public BigDecimal getR95_elimination() {
		return r95_elimination;
	}
	public void setR95_elimination(BigDecimal r95_elimination) {
		this.r95_elimination = r95_elimination;
	}
	public BigDecimal getR95_reclassification() {
		return r95_reclassification;
	}
	public void setR95_reclassification(BigDecimal r95_reclassification) {
		this.r95_reclassification = r95_reclassification;
	}
	public BigDecimal getR95_consolidated_liabilities() {
		return r95_consolidated_liabilities;
	}
	public void setR95_consolidated_liabilities(BigDecimal r95_consolidated_liabilities) {
		this.r95_consolidated_liabilities = r95_consolidated_liabilities;
	}
	public String getR96_product() {
		return r96_product;
	}
	public void setR96_product(String r96_product) {
		this.r96_product = r96_product;
	}
	public BigDecimal getR96_bank_operations() {
		return r96_bank_operations;
	}
	public void setR96_bank_operations(BigDecimal r96_bank_operations) {
		this.r96_bank_operations = r96_bank_operations;
	}
	public BigDecimal getR96_banking_subsidiaries() {
		return r96_banking_subsidiaries;
	}
	public void setR96_banking_subsidiaries(BigDecimal r96_banking_subsidiaries) {
		this.r96_banking_subsidiaries = r96_banking_subsidiaries;
	}
	public BigDecimal getR96_financial_subsidiaries_uae() {
		return r96_financial_subsidiaries_uae;
	}
	public void setR96_financial_subsidiaries_uae(BigDecimal r96_financial_subsidiaries_uae) {
		this.r96_financial_subsidiaries_uae = r96_financial_subsidiaries_uae;
	}
	public BigDecimal getR96_financial_subsidiaries_outside_uae() {
		return r96_financial_subsidiaries_outside_uae;
	}
	public void setR96_financial_subsidiaries_outside_uae(BigDecimal r96_financial_subsidiaries_outside_uae) {
		this.r96_financial_subsidiaries_outside_uae = r96_financial_subsidiaries_outside_uae;
	}
	public BigDecimal getR96_all_other_subs_uae() {
		return r96_all_other_subs_uae;
	}
	public void setR96_all_other_subs_uae(BigDecimal r96_all_other_subs_uae) {
		this.r96_all_other_subs_uae = r96_all_other_subs_uae;
	}
	public BigDecimal getR96_all_other_subs_outside_uae() {
		return r96_all_other_subs_outside_uae;
	}
	public void setR96_all_other_subs_outside_uae(BigDecimal r96_all_other_subs_outside_uae) {
		this.r96_all_other_subs_outside_uae = r96_all_other_subs_outside_uae;
	}
	public BigDecimal getR96_gross_liabilities() {
		return r96_gross_liabilities;
	}
	public void setR96_gross_liabilities(BigDecimal r96_gross_liabilities) {
		this.r96_gross_liabilities = r96_gross_liabilities;
	}
	public BigDecimal getR96_elimination() {
		return r96_elimination;
	}
	public void setR96_elimination(BigDecimal r96_elimination) {
		this.r96_elimination = r96_elimination;
	}
	public BigDecimal getR96_reclassification() {
		return r96_reclassification;
	}
	public void setR96_reclassification(BigDecimal r96_reclassification) {
		this.r96_reclassification = r96_reclassification;
	}
	public BigDecimal getR96_consolidated_liabilities() {
		return r96_consolidated_liabilities;
	}
	public void setR96_consolidated_liabilities(BigDecimal r96_consolidated_liabilities) {
		this.r96_consolidated_liabilities = r96_consolidated_liabilities;
	}
	public String getR97_product() {
		return r97_product;
	}
	public void setR97_product(String r97_product) {
		this.r97_product = r97_product;
	}
	public BigDecimal getR97_stage3_loans() {
		return r97_stage3_loans;
	}
	public void setR97_stage3_loans(BigDecimal r97_stage3_loans) {
		this.r97_stage3_loans = r97_stage3_loans;
	}
	public BigDecimal getR97_stage3_investments() {
		return r97_stage3_investments;
	}
	public void setR97_stage3_investments(BigDecimal r97_stage3_investments) {
		this.r97_stage3_investments = r97_stage3_investments;
	}
	public BigDecimal getR97_all_other_assets() {
		return r97_all_other_assets;
	}
	public void setR97_all_other_assets(BigDecimal r97_all_other_assets) {
		this.r97_all_other_assets = r97_all_other_assets;
	}
	public BigDecimal getR97_loan_advances() {
		return r97_loan_advances;
	}
	public void setR97_loan_advances(BigDecimal r97_loan_advances) {
		this.r97_loan_advances = r97_loan_advances;
	}
	public BigDecimal getR97_legacy_interest() {
		return r97_legacy_interest;
	}
	public void setR97_legacy_interest(BigDecimal r97_legacy_interest) {
		this.r97_legacy_interest = r97_legacy_interest;
	}
	public BigDecimal getR97_provision() {
		return r97_provision;
	}
	public void setR97_provision(BigDecimal r97_provision) {
		this.r97_provision = r97_provision;
	}
	public BigDecimal getR97_total() {
		return r97_total;
	}
	public void setR97_total(BigDecimal r97_total) {
		this.r97_total = r97_total;
	}
	public String getR98_product() {
		return r98_product;
	}
	public void setR98_product(String r98_product) {
		this.r98_product = r98_product;
	}
	public BigDecimal getR98_stage3_loans() {
		return r98_stage3_loans;
	}
	public void setR98_stage3_loans(BigDecimal r98_stage3_loans) {
		this.r98_stage3_loans = r98_stage3_loans;
	}
	public BigDecimal getR98_stage3_investments() {
		return r98_stage3_investments;
	}
	public void setR98_stage3_investments(BigDecimal r98_stage3_investments) {
		this.r98_stage3_investments = r98_stage3_investments;
	}
	public BigDecimal getR98_all_other_assets() {
		return r98_all_other_assets;
	}
	public void setR98_all_other_assets(BigDecimal r98_all_other_assets) {
		this.r98_all_other_assets = r98_all_other_assets;
	}
	public BigDecimal getR98_loan_advances() {
		return r98_loan_advances;
	}
	public void setR98_loan_advances(BigDecimal r98_loan_advances) {
		this.r98_loan_advances = r98_loan_advances;
	}
	public BigDecimal getR98_legacy_interest() {
		return r98_legacy_interest;
	}
	public void setR98_legacy_interest(BigDecimal r98_legacy_interest) {
		this.r98_legacy_interest = r98_legacy_interest;
	}
	public BigDecimal getR98_provision() {
		return r98_provision;
	}
	public void setR98_provision(BigDecimal r98_provision) {
		this.r98_provision = r98_provision;
	}
	public BigDecimal getR98_total() {
		return r98_total;
	}
	public void setR98_total(BigDecimal r98_total) {
		this.r98_total = r98_total;
	}
	public String getR99_product() {
		return r99_product;
	}
	public void setR99_product(String r99_product) {
		this.r99_product = r99_product;
	}
	public BigDecimal getR99_stage3_loans() {
		return r99_stage3_loans;
	}
	public void setR99_stage3_loans(BigDecimal r99_stage3_loans) {
		this.r99_stage3_loans = r99_stage3_loans;
	}
	public BigDecimal getR99_stage3_investments() {
		return r99_stage3_investments;
	}
	public void setR99_stage3_investments(BigDecimal r99_stage3_investments) {
		this.r99_stage3_investments = r99_stage3_investments;
	}
	public BigDecimal getR99_all_other_assets() {
		return r99_all_other_assets;
	}
	public void setR99_all_other_assets(BigDecimal r99_all_other_assets) {
		this.r99_all_other_assets = r99_all_other_assets;
	}
	public BigDecimal getR99_loan_advances() {
		return r99_loan_advances;
	}
	public void setR99_loan_advances(BigDecimal r99_loan_advances) {
		this.r99_loan_advances = r99_loan_advances;
	}
	public BigDecimal getR99_legacy_interest() {
		return r99_legacy_interest;
	}
	public void setR99_legacy_interest(BigDecimal r99_legacy_interest) {
		this.r99_legacy_interest = r99_legacy_interest;
	}
	public BigDecimal getR99_provision() {
		return r99_provision;
	}
	public void setR99_provision(BigDecimal r99_provision) {
		this.r99_provision = r99_provision;
	}
	public BigDecimal getR99_total() {
		return r99_total;
	}
	public void setR99_total(BigDecimal r99_total) {
		this.r99_total = r99_total;
	}
	public String getR100_product() {
		return r100_product;
	}
	public void setR100_product(String r100_product) {
		this.r100_product = r100_product;
	}
	public BigDecimal getR100_stage3_loans() {
		return r100_stage3_loans;
	}
	public void setR100_stage3_loans(BigDecimal r100_stage3_loans) {
		this.r100_stage3_loans = r100_stage3_loans;
	}
	public BigDecimal getR100_stage3_investments() {
		return r100_stage3_investments;
	}
	public void setR100_stage3_investments(BigDecimal r100_stage3_investments) {
		this.r100_stage3_investments = r100_stage3_investments;
	}
	public BigDecimal getR100_all_other_assets() {
		return r100_all_other_assets;
	}
	public void setR100_all_other_assets(BigDecimal r100_all_other_assets) {
		this.r100_all_other_assets = r100_all_other_assets;
	}
	public BigDecimal getR100_loan_advances() {
		return r100_loan_advances;
	}
	public void setR100_loan_advances(BigDecimal r100_loan_advances) {
		this.r100_loan_advances = r100_loan_advances;
	}
	public BigDecimal getR100_legacy_interest() {
		return r100_legacy_interest;
	}
	public void setR100_legacy_interest(BigDecimal r100_legacy_interest) {
		this.r100_legacy_interest = r100_legacy_interest;
	}
	public BigDecimal getR100_provision() {
		return r100_provision;
	}
	public void setR100_provision(BigDecimal r100_provision) {
		this.r100_provision = r100_provision;
	}
	public BigDecimal getR100_total() {
		return r100_total;
	}
	public void setR100_total(BigDecimal r100_total) {
		this.r100_total = r100_total;
	}
	public String getR101_product() {
		return r101_product;
	}
	public void setR101_product(String r101_product) {
		this.r101_product = r101_product;
	}
	public BigDecimal getR101_stage3_loans() {
		return r101_stage3_loans;
	}
	public void setR101_stage3_loans(BigDecimal r101_stage3_loans) {
		this.r101_stage3_loans = r101_stage3_loans;
	}
	public BigDecimal getR101_stage3_investments() {
		return r101_stage3_investments;
	}
	public void setR101_stage3_investments(BigDecimal r101_stage3_investments) {
		this.r101_stage3_investments = r101_stage3_investments;
	}
	public BigDecimal getR101_all_other_assets() {
		return r101_all_other_assets;
	}
	public void setR101_all_other_assets(BigDecimal r101_all_other_assets) {
		this.r101_all_other_assets = r101_all_other_assets;
	}
	public BigDecimal getR101_loan_advances() {
		return r101_loan_advances;
	}
	public void setR101_loan_advances(BigDecimal r101_loan_advances) {
		this.r101_loan_advances = r101_loan_advances;
	}
	public BigDecimal getR101_legacy_interest() {
		return r101_legacy_interest;
	}
	public void setR101_legacy_interest(BigDecimal r101_legacy_interest) {
		this.r101_legacy_interest = r101_legacy_interest;
	}
	public BigDecimal getR101_provision() {
		return r101_provision;
	}
	public void setR101_provision(BigDecimal r101_provision) {
		this.r101_provision = r101_provision;
	}
	public BigDecimal getR101_total() {
		return r101_total;
	}
	public void setR101_total(BigDecimal r101_total) {
		this.r101_total = r101_total;
	}
	public Date getReport_submit_date() {
		return report_submit_date;
	}
	public void setReport_submit_date(Date report_submit_date) {
		this.report_submit_date = report_submit_date;
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
	public BRF208_Entity2() {
		super();
		// TODO Auto-generated constructor stub
	}
}