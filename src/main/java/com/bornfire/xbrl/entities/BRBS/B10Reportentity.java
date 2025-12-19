
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
@Table(name="EIF_TABLE")
public class B10Reportentity {
	private String	r1_product;
	private BigDecimal	r1_value_of_bank;
	private String	r1_avg_risk_weight;
	private String	r1_approach_risk;
	private String	r1_lev_fund;
	private BigDecimal	r1_risk_weight;
	private String	r1_risk_weight_assets;
	private String	r2_product;
	private BigDecimal	r2_value_of_bank;
	private String	r2_avg_risk_weight;
	private String	r2_approach_risk;
	private String	r2_lev_fund;
	private BigDecimal	r2_risk_weight;
	private String	r2_risk_weight_assets;
	private String	r3_product;
	private BigDecimal	r3_value_of_bank;
	private String	r3_avg_risk_weight;
	private String	r3_approach_risk;
	private String	r3_lev_fund;
	private BigDecimal	r3_risk_weight;
	private String	r3_risk_weight_assets;
	private String	r4_product;
	private BigDecimal	r4_value_of_bank;
	private String	r4_avg_risk_weight;
	private String	r4_approach_risk;
	private String	r4_lev_fund;
	private BigDecimal	r4_risk_weight;
	private String	r4_risk_weight_assets;
	private String	r5_product;
	private BigDecimal	r5_value_of_bank;
	private String	r5_avg_risk_weight;
	private String	r5_approach_risk;
	private String	r5_lev_fund;
	private BigDecimal	r5_risk_weight;
	private String	r5_risk_weight_assets;
	private String	r6_product;
	private BigDecimal	r6_value_of_bank;
	private String	r6_avg_risk_weight;
	private String	r6_approach_risk;
	private String	r6_lev_fund;
	private BigDecimal	r6_risk_weight;
	private String	r6_risk_weight_assets;
	private Date	report_from_date;
	private Date	report_to_date;
	private String	entity_flg;
	private String	modify_flg;
	private String	del_flg;
	private String	report_code;
	private Date	report_submit_date;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Id
	private Date	report_date;
	public String getR1_product() {
		return r1_product;
	}
	public void setR1_product(String r1_product) {
		this.r1_product = r1_product;
	}
	public BigDecimal getR1_value_of_bank() {
		return r1_value_of_bank;
	}
	public void setR1_value_of_bank(BigDecimal r1_value_of_bank) {
		this.r1_value_of_bank = r1_value_of_bank;
	}
	public String getR1_avg_risk_weight() {
		return r1_avg_risk_weight;
	}
	public void setR1_avg_risk_weight(String r1_avg_risk_weight) {
		this.r1_avg_risk_weight = r1_avg_risk_weight;
	}
	public String getR1_approach_risk() {
		return r1_approach_risk;
	}
	public void setR1_approach_risk(String r1_approach_risk) {
		this.r1_approach_risk = r1_approach_risk;
	}
	public String getR1_lev_fund() {
		return r1_lev_fund;
	}
	public void setR1_lev_fund(String r1_lev_fund) {
		this.r1_lev_fund = r1_lev_fund;
	}
	public BigDecimal getR1_risk_weight() {
		return r1_risk_weight;
	}
	public void setR1_risk_weight(BigDecimal r1_risk_weight) {
		this.r1_risk_weight = r1_risk_weight;
	}
	public String getR1_risk_weight_assets() {
		return r1_risk_weight_assets;
	}
	public void setR1_risk_weight_assets(String r1_risk_weight_assets) {
		this.r1_risk_weight_assets = r1_risk_weight_assets;
	}
	public String getR2_product() {
		return r2_product;
	}
	public void setR2_product(String r2_product) {
		this.r2_product = r2_product;
	}
	public BigDecimal getR2_value_of_bank() {
		return r2_value_of_bank;
	}
	public void setR2_value_of_bank(BigDecimal r2_value_of_bank) {
		this.r2_value_of_bank = r2_value_of_bank;
	}
	public String getR2_avg_risk_weight() {
		return r2_avg_risk_weight;
	}
	public void setR2_avg_risk_weight(String r2_avg_risk_weight) {
		this.r2_avg_risk_weight = r2_avg_risk_weight;
	}
	public String getR2_approach_risk() {
		return r2_approach_risk;
	}
	public void setR2_approach_risk(String r2_approach_risk) {
		this.r2_approach_risk = r2_approach_risk;
	}
	public String getR2_lev_fund() {
		return r2_lev_fund;
	}
	public void setR2_lev_fund(String r2_lev_fund) {
		this.r2_lev_fund = r2_lev_fund;
	}
	public BigDecimal getR2_risk_weight() {
		return r2_risk_weight;
	}
	public void setR2_risk_weight(BigDecimal r2_risk_weight) {
		this.r2_risk_weight = r2_risk_weight;
	}
	public String getR2_risk_weight_assets() {
		return r2_risk_weight_assets;
	}
	public void setR2_risk_weight_assets(String r2_risk_weight_assets) {
		this.r2_risk_weight_assets = r2_risk_weight_assets;
	}
	public String getR3_product() {
		return r3_product;
	}
	public void setR3_product(String r3_product) {
		this.r3_product = r3_product;
	}
	public BigDecimal getR3_value_of_bank() {
		return r3_value_of_bank;
	}
	public void setR3_value_of_bank(BigDecimal r3_value_of_bank) {
		this.r3_value_of_bank = r3_value_of_bank;
	}
	public String getR3_avg_risk_weight() {
		return r3_avg_risk_weight;
	}
	public void setR3_avg_risk_weight(String r3_avg_risk_weight) {
		this.r3_avg_risk_weight = r3_avg_risk_weight;
	}
	public String getR3_approach_risk() {
		return r3_approach_risk;
	}
	public void setR3_approach_risk(String r3_approach_risk) {
		this.r3_approach_risk = r3_approach_risk;
	}
	public String getR3_lev_fund() {
		return r3_lev_fund;
	}
	public void setR3_lev_fund(String r3_lev_fund) {
		this.r3_lev_fund = r3_lev_fund;
	}
	public BigDecimal getR3_risk_weight() {
		return r3_risk_weight;
	}
	public void setR3_risk_weight(BigDecimal r3_risk_weight) {
		this.r3_risk_weight = r3_risk_weight;
	}
	public String getR3_risk_weight_assets() {
		return r3_risk_weight_assets;
	}
	public void setR3_risk_weight_assets(String r3_risk_weight_assets) {
		this.r3_risk_weight_assets = r3_risk_weight_assets;
	}
	public String getR4_product() {
		return r4_product;
	}
	public void setR4_product(String r4_product) {
		this.r4_product = r4_product;
	}
	public BigDecimal getR4_value_of_bank() {
		return r4_value_of_bank;
	}
	public void setR4_value_of_bank(BigDecimal r4_value_of_bank) {
		this.r4_value_of_bank = r4_value_of_bank;
	}
	public String getR4_avg_risk_weight() {
		return r4_avg_risk_weight;
	}
	public void setR4_avg_risk_weight(String r4_avg_risk_weight) {
		this.r4_avg_risk_weight = r4_avg_risk_weight;
	}
	public String getR4_approach_risk() {
		return r4_approach_risk;
	}
	public void setR4_approach_risk(String r4_approach_risk) {
		this.r4_approach_risk = r4_approach_risk;
	}
	public String getR4_lev_fund() {
		return r4_lev_fund;
	}
	public void setR4_lev_fund(String r4_lev_fund) {
		this.r4_lev_fund = r4_lev_fund;
	}
	public BigDecimal getR4_risk_weight() {
		return r4_risk_weight;
	}
	public void setR4_risk_weight(BigDecimal r4_risk_weight) {
		this.r4_risk_weight = r4_risk_weight;
	}
	public String getR4_risk_weight_assets() {
		return r4_risk_weight_assets;
	}
	public void setR4_risk_weight_assets(String r4_risk_weight_assets) {
		this.r4_risk_weight_assets = r4_risk_weight_assets;
	}
	public String getR5_product() {
		return r5_product;
	}
	public void setR5_product(String r5_product) {
		this.r5_product = r5_product;
	}
	public BigDecimal getR5_value_of_bank() {
		return r5_value_of_bank;
	}
	public void setR5_value_of_bank(BigDecimal r5_value_of_bank) {
		this.r5_value_of_bank = r5_value_of_bank;
	}
	public String getR5_avg_risk_weight() {
		return r5_avg_risk_weight;
	}
	public void setR5_avg_risk_weight(String r5_avg_risk_weight) {
		this.r5_avg_risk_weight = r5_avg_risk_weight;
	}
	public String getR5_approach_risk() {
		return r5_approach_risk;
	}
	public void setR5_approach_risk(String r5_approach_risk) {
		this.r5_approach_risk = r5_approach_risk;
	}
	public String getR5_lev_fund() {
		return r5_lev_fund;
	}
	public void setR5_lev_fund(String r5_lev_fund) {
		this.r5_lev_fund = r5_lev_fund;
	}
	public BigDecimal getR5_risk_weight() {
		return r5_risk_weight;
	}
	public void setR5_risk_weight(BigDecimal r5_risk_weight) {
		this.r5_risk_weight = r5_risk_weight;
	}
	public String getR5_risk_weight_assets() {
		return r5_risk_weight_assets;
	}
	public void setR5_risk_weight_assets(String r5_risk_weight_assets) {
		this.r5_risk_weight_assets = r5_risk_weight_assets;
	}
	public String getR6_product() {
		return r6_product;
	}
	public void setR6_product(String r6_product) {
		this.r6_product = r6_product;
	}
	public BigDecimal getR6_value_of_bank() {
		return r6_value_of_bank;
	}
	public void setR6_value_of_bank(BigDecimal r6_value_of_bank) {
		this.r6_value_of_bank = r6_value_of_bank;
	}
	public String getR6_avg_risk_weight() {
		return r6_avg_risk_weight;
	}
	public void setR6_avg_risk_weight(String r6_avg_risk_weight) {
		this.r6_avg_risk_weight = r6_avg_risk_weight;
	}
	public String getR6_approach_risk() {
		return r6_approach_risk;
	}
	public void setR6_approach_risk(String r6_approach_risk) {
		this.r6_approach_risk = r6_approach_risk;
	}
	public String getR6_lev_fund() {
		return r6_lev_fund;
	}
	public void setR6_lev_fund(String r6_lev_fund) {
		this.r6_lev_fund = r6_lev_fund;
	}
	public BigDecimal getR6_risk_weight() {
		return r6_risk_weight;
	}
	public void setR6_risk_weight(BigDecimal r6_risk_weight) {
		this.r6_risk_weight = r6_risk_weight;
	}
	public String getR6_risk_weight_assets() {
		return r6_risk_weight_assets;
	}
	public void setR6_risk_weight_assets(String r6_risk_weight_assets) {
		this.r6_risk_weight_assets = r6_risk_weight_assets;
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
	public Date getReport_date() {
		return report_date;
	}
	public void setReport_date(Date report_date) {
		this.report_date = report_date;
	}
	public B10Reportentity(String r1_product, BigDecimal r1_value_of_bank, String r1_avg_risk_weight,
			String r1_approach_risk, String r1_lev_fund, BigDecimal r1_risk_weight, String r1_risk_weight_assets,
			String r2_product, BigDecimal r2_value_of_bank, String r2_avg_risk_weight, String r2_approach_risk,
			String r2_lev_fund, BigDecimal r2_risk_weight, String r2_risk_weight_assets, String r3_product,
			BigDecimal r3_value_of_bank, String r3_avg_risk_weight, String r3_approach_risk, String r3_lev_fund,
			BigDecimal r3_risk_weight, String r3_risk_weight_assets, String r4_product, BigDecimal r4_value_of_bank,
			String r4_avg_risk_weight, String r4_approach_risk, String r4_lev_fund, BigDecimal r4_risk_weight,
			String r4_risk_weight_assets, String r5_product, BigDecimal r5_value_of_bank, String r5_avg_risk_weight,
			String r5_approach_risk, String r5_lev_fund, BigDecimal r5_risk_weight, String r5_risk_weight_assets,
			String r6_product, BigDecimal r6_value_of_bank, String r6_avg_risk_weight, String r6_approach_risk,
			String r6_lev_fund, BigDecimal r6_risk_weight, String r6_risk_weight_assets, Date report_from_date,
			Date report_to_date, String entity_flg, String modify_flg, String del_flg, String report_code,
			Date report_submit_date, Date report_date) {
		super();
		this.r1_product = r1_product;
		this.r1_value_of_bank = r1_value_of_bank;
		this.r1_avg_risk_weight = r1_avg_risk_weight;
		this.r1_approach_risk = r1_approach_risk;
		this.r1_lev_fund = r1_lev_fund;
		this.r1_risk_weight = r1_risk_weight;
		this.r1_risk_weight_assets = r1_risk_weight_assets;
		this.r2_product = r2_product;
		this.r2_value_of_bank = r2_value_of_bank;
		this.r2_avg_risk_weight = r2_avg_risk_weight;
		this.r2_approach_risk = r2_approach_risk;
		this.r2_lev_fund = r2_lev_fund;
		this.r2_risk_weight = r2_risk_weight;
		this.r2_risk_weight_assets = r2_risk_weight_assets;
		this.r3_product = r3_product;
		this.r3_value_of_bank = r3_value_of_bank;
		this.r3_avg_risk_weight = r3_avg_risk_weight;
		this.r3_approach_risk = r3_approach_risk;
		this.r3_lev_fund = r3_lev_fund;
		this.r3_risk_weight = r3_risk_weight;
		this.r3_risk_weight_assets = r3_risk_weight_assets;
		this.r4_product = r4_product;
		this.r4_value_of_bank = r4_value_of_bank;
		this.r4_avg_risk_weight = r4_avg_risk_weight;
		this.r4_approach_risk = r4_approach_risk;
		this.r4_lev_fund = r4_lev_fund;
		this.r4_risk_weight = r4_risk_weight;
		this.r4_risk_weight_assets = r4_risk_weight_assets;
		this.r5_product = r5_product;
		this.r5_value_of_bank = r5_value_of_bank;
		this.r5_avg_risk_weight = r5_avg_risk_weight;
		this.r5_approach_risk = r5_approach_risk;
		this.r5_lev_fund = r5_lev_fund;
		this.r5_risk_weight = r5_risk_weight;
		this.r5_risk_weight_assets = r5_risk_weight_assets;
		this.r6_product = r6_product;
		this.r6_value_of_bank = r6_value_of_bank;
		this.r6_avg_risk_weight = r6_avg_risk_weight;
		this.r6_approach_risk = r6_approach_risk;
		this.r6_lev_fund = r6_lev_fund;
		this.r6_risk_weight = r6_risk_weight;
		this.r6_risk_weight_assets = r6_risk_weight_assets;
		this.report_from_date = report_from_date;
		this.report_to_date = report_to_date;
		this.entity_flg = entity_flg;
		this.modify_flg = modify_flg;
		this.del_flg = del_flg;
		this.report_code = report_code;
		this.report_submit_date = report_submit_date;
		this.report_date = report_date;
	}
	public B10Reportentity() {
		super();
		// TODO Auto-generated constructor stub
	}


	
}
