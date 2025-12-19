package com.bornfire.xbrl.entities.BRBS;

import java.math.BigDecimal;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="BRF_77")
public class BRF77_TABLE {
	@Id
	private Date	report_date;
	private BigDecimal	capital_case;
	private String	r1_product;
	private BigDecimal	r1_fund_os;
	private BigDecimal	r1_debt_securities;
	private BigDecimal	r1_unfund_os;
	private BigDecimal	r1_unfund_ccf;
	private BigDecimal	r1_unused_unfund_ccf;
	private BigDecimal	r1_total_exposure_ccf;
	private String	r2_product;
	private BigDecimal	r2_fund_os;
	private BigDecimal	r2_debt_securities;
	private BigDecimal	r2_unfund_os;
	private BigDecimal	r2_unfund_ccf;
	private BigDecimal	r2_unused_unfund_ccf;
	private BigDecimal	r2_total_exposure_ccf;
	private String	r3_product;
	private BigDecimal	r3_fund_os;
	private BigDecimal	r3_debt_securities;
	private BigDecimal	r3_unfund_os;
	private BigDecimal	r3_unfund_ccf;
	private BigDecimal	r3_unused_unfund_ccf;
	private BigDecimal	r3_total_exposure_ccf;
	private String	r4_product;
	private BigDecimal	r4_fund_os;
	private BigDecimal	r4_debt_securities;
	private BigDecimal	r4_unfund_os;
	private BigDecimal	r4_unfund_ccf;
	private BigDecimal	r4_unused_unfund_ccf;
	private BigDecimal	r4_total_exposure_ccf;
	private String	r5_product;
	private BigDecimal	r5_fund_os;
	private BigDecimal	r5_debt_securities;
	private BigDecimal	r5_unfund_os;
	private BigDecimal	r5_unfund_ccf;
	private BigDecimal	r5_unused_unfund_ccf;
	private BigDecimal	r5_total_exposure_ccf;
	private Date	report_from_date;
	private Date	report_to_date;
	private Date	report_submit_date;
	private String	entity_flg;
	private String	modify_flg;
	private String	del_flg;
	public Date getReport_date() {
		return report_date;
	}
	public void setReport_date(Date report_date) {
		this.report_date = report_date;
	}
	public BigDecimal getCapital_case() {
		return capital_case;
	}
	public void setCapital_case(BigDecimal capital_case) {
		this.capital_case = capital_case;
	}
	public String getR1_product() {
		return r1_product;
	}
	public void setR1_product(String r1_product) {
		this.r1_product = r1_product;
	}
	public BigDecimal getR1_fund_os() {
		return r1_fund_os;
	}
	public void setR1_fund_os(BigDecimal r1_fund_os) {
		this.r1_fund_os = r1_fund_os;
	}
	public BigDecimal getR1_debt_securities() {
		return r1_debt_securities;
	}
	public void setR1_debt_securities(BigDecimal r1_debt_securities) {
		this.r1_debt_securities = r1_debt_securities;
	}
	public BigDecimal getR1_unfund_os() {
		return r1_unfund_os;
	}
	public void setR1_unfund_os(BigDecimal r1_unfund_os) {
		this.r1_unfund_os = r1_unfund_os;
	}
	public BigDecimal getR1_unfund_ccf() {
		return r1_unfund_ccf;
	}
	public void setR1_unfund_ccf(BigDecimal r1_unfund_ccf) {
		this.r1_unfund_ccf = r1_unfund_ccf;
	}
	public BigDecimal getR1_unused_unfund_ccf() {
		return r1_unused_unfund_ccf;
	}
	public void setR1_unused_unfund_ccf(BigDecimal r1_unused_unfund_ccf) {
		this.r1_unused_unfund_ccf = r1_unused_unfund_ccf;
	}
	public BigDecimal getR1_total_exposure_ccf() {
		return r1_total_exposure_ccf;
	}
	public void setR1_total_exposure_ccf(BigDecimal r1_total_exposure_ccf) {
		this.r1_total_exposure_ccf = r1_total_exposure_ccf;
	}
	public String getR2_product() {
		return r2_product;
	}
	public void setR2_product(String r2_product) {
		this.r2_product = r2_product;
	}
	public BigDecimal getR2_fund_os() {
		return r2_fund_os;
	}
	public void setR2_fund_os(BigDecimal r2_fund_os) {
		this.r2_fund_os = r2_fund_os;
	}
	public BigDecimal getR2_debt_securities() {
		return r2_debt_securities;
	}
	public void setR2_debt_securities(BigDecimal r2_debt_securities) {
		this.r2_debt_securities = r2_debt_securities;
	}
	public BigDecimal getR2_unfund_os() {
		return r2_unfund_os;
	}
	public void setR2_unfund_os(BigDecimal r2_unfund_os) {
		this.r2_unfund_os = r2_unfund_os;
	}
	public BigDecimal getR2_unfund_ccf() {
		return r2_unfund_ccf;
	}
	public void setR2_unfund_ccf(BigDecimal r2_unfund_ccf) {
		this.r2_unfund_ccf = r2_unfund_ccf;
	}
	public BigDecimal getR2_unused_unfund_ccf() {
		return r2_unused_unfund_ccf;
	}
	public void setR2_unused_unfund_ccf(BigDecimal r2_unused_unfund_ccf) {
		this.r2_unused_unfund_ccf = r2_unused_unfund_ccf;
	}
	public BigDecimal getR2_total_exposure_ccf() {
		return r2_total_exposure_ccf;
	}
	public void setR2_total_exposure_ccf(BigDecimal r2_total_exposure_ccf) {
		this.r2_total_exposure_ccf = r2_total_exposure_ccf;
	}
	public String getR3_product() {
		return r3_product;
	}
	public void setR3_product(String r3_product) {
		this.r3_product = r3_product;
	}
	public BigDecimal getR3_fund_os() {
		return r3_fund_os;
	}
	public void setR3_fund_os(BigDecimal r3_fund_os) {
		this.r3_fund_os = r3_fund_os;
	}
	public BigDecimal getR3_debt_securities() {
		return r3_debt_securities;
	}
	public void setR3_debt_securities(BigDecimal r3_debt_securities) {
		this.r3_debt_securities = r3_debt_securities;
	}
	public BigDecimal getR3_unfund_os() {
		return r3_unfund_os;
	}
	public void setR3_unfund_os(BigDecimal r3_unfund_os) {
		this.r3_unfund_os = r3_unfund_os;
	}
	public BigDecimal getR3_unfund_ccf() {
		return r3_unfund_ccf;
	}
	public void setR3_unfund_ccf(BigDecimal r3_unfund_ccf) {
		this.r3_unfund_ccf = r3_unfund_ccf;
	}
	public BigDecimal getR3_unused_unfund_ccf() {
		return r3_unused_unfund_ccf;
	}
	public void setR3_unused_unfund_ccf(BigDecimal r3_unused_unfund_ccf) {
		this.r3_unused_unfund_ccf = r3_unused_unfund_ccf;
	}
	public BigDecimal getR3_total_exposure_ccf() {
		return r3_total_exposure_ccf;
	}
	public void setR3_total_exposure_ccf(BigDecimal r3_total_exposure_ccf) {
		this.r3_total_exposure_ccf = r3_total_exposure_ccf;
	}
	public String getR4_product() {
		return r4_product;
	}
	public void setR4_product(String r4_product) {
		this.r4_product = r4_product;
	}
	public BigDecimal getR4_fund_os() {
		return r4_fund_os;
	}
	public void setR4_fund_os(BigDecimal r4_fund_os) {
		this.r4_fund_os = r4_fund_os;
	}
	public BigDecimal getR4_debt_securities() {
		return r4_debt_securities;
	}
	public void setR4_debt_securities(BigDecimal r4_debt_securities) {
		this.r4_debt_securities = r4_debt_securities;
	}
	public BigDecimal getR4_unfund_os() {
		return r4_unfund_os;
	}
	public void setR4_unfund_os(BigDecimal r4_unfund_os) {
		this.r4_unfund_os = r4_unfund_os;
	}
	public BigDecimal getR4_unfund_ccf() {
		return r4_unfund_ccf;
	}
	public void setR4_unfund_ccf(BigDecimal r4_unfund_ccf) {
		this.r4_unfund_ccf = r4_unfund_ccf;
	}
	public BigDecimal getR4_unused_unfund_ccf() {
		return r4_unused_unfund_ccf;
	}
	public void setR4_unused_unfund_ccf(BigDecimal r4_unused_unfund_ccf) {
		this.r4_unused_unfund_ccf = r4_unused_unfund_ccf;
	}
	public BigDecimal getR4_total_exposure_ccf() {
		return r4_total_exposure_ccf;
	}
	public void setR4_total_exposure_ccf(BigDecimal r4_total_exposure_ccf) {
		this.r4_total_exposure_ccf = r4_total_exposure_ccf;
	}
	public String getR5_product() {
		return r5_product;
	}
	public void setR5_product(String r5_product) {
		this.r5_product = r5_product;
	}
	public BigDecimal getR5_fund_os() {
		return r5_fund_os;
	}
	public void setR5_fund_os(BigDecimal r5_fund_os) {
		this.r5_fund_os = r5_fund_os;
	}
	public BigDecimal getR5_debt_securities() {
		return r5_debt_securities;
	}
	public void setR5_debt_securities(BigDecimal r5_debt_securities) {
		this.r5_debt_securities = r5_debt_securities;
	}
	public BigDecimal getR5_unfund_os() {
		return r5_unfund_os;
	}
	public void setR5_unfund_os(BigDecimal r5_unfund_os) {
		this.r5_unfund_os = r5_unfund_os;
	}
	public BigDecimal getR5_unfund_ccf() {
		return r5_unfund_ccf;
	}
	public void setR5_unfund_ccf(BigDecimal r5_unfund_ccf) {
		this.r5_unfund_ccf = r5_unfund_ccf;
	}
	public BigDecimal getR5_unused_unfund_ccf() {
		return r5_unused_unfund_ccf;
	}
	public void setR5_unused_unfund_ccf(BigDecimal r5_unused_unfund_ccf) {
		this.r5_unused_unfund_ccf = r5_unused_unfund_ccf;
	}
	public BigDecimal getR5_total_exposure_ccf() {
		return r5_total_exposure_ccf;
	}
	public void setR5_total_exposure_ccf(BigDecimal r5_total_exposure_ccf) {
		this.r5_total_exposure_ccf = r5_total_exposure_ccf;
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
	public Date getReport_submit_date() {
		return report_submit_date;
	}
	public void setReport_submit_date(Date report_submit_date) {
		this.report_submit_date = report_submit_date;
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
	public BRF77_TABLE(Date report_date, BigDecimal capital_case, String r1_product, BigDecimal r1_fund_os,
			BigDecimal r1_debt_securities, BigDecimal r1_unfund_os, BigDecimal r1_unfund_ccf,
			BigDecimal r1_unused_unfund_ccf, BigDecimal r1_total_exposure_ccf, String r2_product, BigDecimal r2_fund_os,
			BigDecimal r2_debt_securities, BigDecimal r2_unfund_os, BigDecimal r2_unfund_ccf,
			BigDecimal r2_unused_unfund_ccf, BigDecimal r2_total_exposure_ccf, String r3_product, BigDecimal r3_fund_os,
			BigDecimal r3_debt_securities, BigDecimal r3_unfund_os, BigDecimal r3_unfund_ccf,
			BigDecimal r3_unused_unfund_ccf, BigDecimal r3_total_exposure_ccf, String r4_product, BigDecimal r4_fund_os,
			BigDecimal r4_debt_securities, BigDecimal r4_unfund_os, BigDecimal r4_unfund_ccf,
			BigDecimal r4_unused_unfund_ccf, BigDecimal r4_total_exposure_ccf, String r5_product, BigDecimal r5_fund_os,
			BigDecimal r5_debt_securities, BigDecimal r5_unfund_os, BigDecimal r5_unfund_ccf,
			BigDecimal r5_unused_unfund_ccf, BigDecimal r5_total_exposure_ccf, Date report_from_date,
			Date report_to_date, Date report_submit_date, String entity_flg, String modify_flg, String del_flg) {
		super();
		this.report_date = report_date;
		this.capital_case = capital_case;
		this.r1_product = r1_product;
		this.r1_fund_os = r1_fund_os;
		this.r1_debt_securities = r1_debt_securities;
		this.r1_unfund_os = r1_unfund_os;
		this.r1_unfund_ccf = r1_unfund_ccf;
		this.r1_unused_unfund_ccf = r1_unused_unfund_ccf;
		this.r1_total_exposure_ccf = r1_total_exposure_ccf;
		this.r2_product = r2_product;
		this.r2_fund_os = r2_fund_os;
		this.r2_debt_securities = r2_debt_securities;
		this.r2_unfund_os = r2_unfund_os;
		this.r2_unfund_ccf = r2_unfund_ccf;
		this.r2_unused_unfund_ccf = r2_unused_unfund_ccf;
		this.r2_total_exposure_ccf = r2_total_exposure_ccf;
		this.r3_product = r3_product;
		this.r3_fund_os = r3_fund_os;
		this.r3_debt_securities = r3_debt_securities;
		this.r3_unfund_os = r3_unfund_os;
		this.r3_unfund_ccf = r3_unfund_ccf;
		this.r3_unused_unfund_ccf = r3_unused_unfund_ccf;
		this.r3_total_exposure_ccf = r3_total_exposure_ccf;
		this.r4_product = r4_product;
		this.r4_fund_os = r4_fund_os;
		this.r4_debt_securities = r4_debt_securities;
		this.r4_unfund_os = r4_unfund_os;
		this.r4_unfund_ccf = r4_unfund_ccf;
		this.r4_unused_unfund_ccf = r4_unused_unfund_ccf;
		this.r4_total_exposure_ccf = r4_total_exposure_ccf;
		this.r5_product = r5_product;
		this.r5_fund_os = r5_fund_os;
		this.r5_debt_securities = r5_debt_securities;
		this.r5_unfund_os = r5_unfund_os;
		this.r5_unfund_ccf = r5_unfund_ccf;
		this.r5_unused_unfund_ccf = r5_unused_unfund_ccf;
		this.r5_total_exposure_ccf = r5_total_exposure_ccf;
		this.report_from_date = report_from_date;
		this.report_to_date = report_to_date;
		this.report_submit_date = report_submit_date;
		this.entity_flg = entity_flg;
		this.modify_flg = modify_flg;
		this.del_flg = del_flg;
	}
	public BRF77_TABLE() {
		super();
		// TODO Auto-generated constructor stub
	}
	


}
