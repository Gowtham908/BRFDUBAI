package com.bornfire.xbrl.entities.BRBS;

import java.math.BigDecimal;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="BRF76_SUMMARYTABLE")
public class BRF76_ENTITY {
	@Id
	private Date	report_date;
	private BigDecimal	capital_case;
	private String	r1_product;
	private String	r1_agg_reg_limits;
	private BigDecimal	r1_total_exposure;
	private BigDecimal	r1_per_capital_case;
	private String	r1_brf_nos;
	private String	r2_product;
	private String	r2_agg_reg_limits;
	private BigDecimal	r2_total_exposure;
	private BigDecimal	r2_per_capital_case;
	private String	r2_brf_nos;
	private String	r3_product;
	private String	r3_agg_reg_limits;
	private BigDecimal	r3_total_exposure;
	private BigDecimal	r3_per_capital_case;
	private String	r3_brf_nos;
	private String	r4_product;
	private String	r4_agg_reg_limits;
	private BigDecimal	r4_total_exposure;
	private String	r4_brf_nos;
	private String	r5_product;
	private String	r5_agg_reg_limits;
	private BigDecimal	r5_total_exposure;
	private String	r5_brf_nos;
	private String	r6_product;
	private String	r6_agg_reg_limits;
	private BigDecimal	r6_total_exposure;
	private BigDecimal	r6_per_capital_case;
	private String	r6_brf_nos;
	private String	r7_product;
	private String	r7_agg_reg_limits;
	private BigDecimal	r7_total_exposure;
	private String	r7_brf_nos;
	private String	r8_product;
	private String	r8_agg_reg_limits;
	private BigDecimal	r8_total_exposure;
	private String	r8_brf_nos;
	private String	r9_product;
	private String	r9_agg_reg_limits;
	private BigDecimal	r9_total_exposure;
	private BigDecimal	r9_per_capital_case;
	private String	r9_brf_nos;
	private String	r10_product;
	private String	r10_agg_reg_limits;
	private BigDecimal	r10_total_exposure;
	private BigDecimal	r10_per_capital_case;
	private String	r10_brf_nos;
	private String	r11_product;
	private String	r11_agg_reg_limits;
	private BigDecimal	r11_total_exposure;
	private BigDecimal	r11_per_capital_case;
	private String	r11_brf_nos;
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
	public String getR1_agg_reg_limits() {
		return r1_agg_reg_limits;
	}
	public void setR1_agg_reg_limits(String r1_agg_reg_limits) {
		this.r1_agg_reg_limits = r1_agg_reg_limits;
	}
	public BigDecimal getR1_total_exposure() {
		return r1_total_exposure;
	}
	public void setR1_total_exposure(BigDecimal r1_total_exposure) {
		this.r1_total_exposure = r1_total_exposure;
	}
	public BigDecimal getR1_per_capital_case() {
		return r1_per_capital_case;
	}
	public void setR1_per_capital_case(BigDecimal r1_per_capital_case) {
		this.r1_per_capital_case = r1_per_capital_case;
	}
	public String getR1_brf_nos() {
		return r1_brf_nos;
	}
	public void setR1_brf_nos(String r1_brf_nos) {
		this.r1_brf_nos = r1_brf_nos;
	}
	public String getR2_product() {
		return r2_product;
	}
	public void setR2_product(String r2_product) {
		this.r2_product = r2_product;
	}
	public String getR2_agg_reg_limits() {
		return r2_agg_reg_limits;
	}
	public void setR2_agg_reg_limits(String r2_agg_reg_limits) {
		this.r2_agg_reg_limits = r2_agg_reg_limits;
	}
	public BigDecimal getR2_total_exposure() {
		return r2_total_exposure;
	}
	public void setR2_total_exposure(BigDecimal r2_total_exposure) {
		this.r2_total_exposure = r2_total_exposure;
	}
	public BigDecimal getR2_per_capital_case() {
		return r2_per_capital_case;
	}
	public void setR2_per_capital_case(BigDecimal r2_per_capital_case) {
		this.r2_per_capital_case = r2_per_capital_case;
	}
	public String getR2_brf_nos() {
		return r2_brf_nos;
	}
	public void setR2_brf_nos(String r2_brf_nos) {
		this.r2_brf_nos = r2_brf_nos;
	}
	public String getR3_product() {
		return r3_product;
	}
	public void setR3_product(String r3_product) {
		this.r3_product = r3_product;
	}
	public String getR3_agg_reg_limits() {
		return r3_agg_reg_limits;
	}
	public void setR3_agg_reg_limits(String r3_agg_reg_limits) {
		this.r3_agg_reg_limits = r3_agg_reg_limits;
	}
	public BigDecimal getR3_total_exposure() {
		return r3_total_exposure;
	}
	public void setR3_total_exposure(BigDecimal r3_total_exposure) {
		this.r3_total_exposure = r3_total_exposure;
	}
	public BigDecimal getR3_per_capital_case() {
		return r3_per_capital_case;
	}
	public void setR3_per_capital_case(BigDecimal r3_per_capital_case) {
		this.r3_per_capital_case = r3_per_capital_case;
	}
	public String getR3_brf_nos() {
		return r3_brf_nos;
	}
	public void setR3_brf_nos(String r3_brf_nos) {
		this.r3_brf_nos = r3_brf_nos;
	}
	public String getR4_product() {
		return r4_product;
	}
	public void setR4_product(String r4_product) {
		this.r4_product = r4_product;
	}
	public String getR4_agg_reg_limits() {
		return r4_agg_reg_limits;
	}
	public void setR4_agg_reg_limits(String r4_agg_reg_limits) {
		this.r4_agg_reg_limits = r4_agg_reg_limits;
	}
	public BigDecimal getR4_total_exposure() {
		return r4_total_exposure;
	}
	public void setR4_total_exposure(BigDecimal r4_total_exposure) {
		this.r4_total_exposure = r4_total_exposure;
	}
	public String getR4_brf_nos() {
		return r4_brf_nos;
	}
	public void setR4_brf_nos(String r4_brf_nos) {
		this.r4_brf_nos = r4_brf_nos;
	}
	public String getR5_product() {
		return r5_product;
	}
	public void setR5_product(String r5_product) {
		this.r5_product = r5_product;
	}
	public String getR5_agg_reg_limits() {
		return r5_agg_reg_limits;
	}
	public void setR5_agg_reg_limits(String r5_agg_reg_limits) {
		this.r5_agg_reg_limits = r5_agg_reg_limits;
	}
	public BigDecimal getR5_total_exposure() {
		return r5_total_exposure;
	}
	public void setR5_total_exposure(BigDecimal r5_total_exposure) {
		this.r5_total_exposure = r5_total_exposure;
	}
	public String getR5_brf_nos() {
		return r5_brf_nos;
	}
	public void setR5_brf_nos(String r5_brf_nos) {
		this.r5_brf_nos = r5_brf_nos;
	}
	public String getR6_product() {
		return r6_product;
	}
	public void setR6_product(String r6_product) {
		this.r6_product = r6_product;
	}
	public String getR6_agg_reg_limits() {
		return r6_agg_reg_limits;
	}
	public void setR6_agg_reg_limits(String r6_agg_reg_limits) {
		this.r6_agg_reg_limits = r6_agg_reg_limits;
	}
	public BigDecimal getR6_total_exposure() {
		return r6_total_exposure;
	}
	public void setR6_total_exposure(BigDecimal r6_total_exposure) {
		this.r6_total_exposure = r6_total_exposure;
	}
	public BigDecimal getR6_per_capital_case() {
		return r6_per_capital_case;
	}
	public void setR6_per_capital_case(BigDecimal r6_per_capital_case) {
		this.r6_per_capital_case = r6_per_capital_case;
	}
	public String getR6_brf_nos() {
		return r6_brf_nos;
	}
	public void setR6_brf_nos(String r6_brf_nos) {
		this.r6_brf_nos = r6_brf_nos;
	}
	public String getR7_product() {
		return r7_product;
	}
	public void setR7_product(String r7_product) {
		this.r7_product = r7_product;
	}
	public String getR7_agg_reg_limits() {
		return r7_agg_reg_limits;
	}
	public void setR7_agg_reg_limits(String r7_agg_reg_limits) {
		this.r7_agg_reg_limits = r7_agg_reg_limits;
	}
	public BigDecimal getR7_total_exposure() {
		return r7_total_exposure;
	}
	public void setR7_total_exposure(BigDecimal r7_total_exposure) {
		this.r7_total_exposure = r7_total_exposure;
	}
	public String getR7_brf_nos() {
		return r7_brf_nos;
	}
	public void setR7_brf_nos(String r7_brf_nos) {
		this.r7_brf_nos = r7_brf_nos;
	}
	public String getR8_product() {
		return r8_product;
	}
	public void setR8_product(String r8_product) {
		this.r8_product = r8_product;
	}
	public String getR8_agg_reg_limits() {
		return r8_agg_reg_limits;
	}
	public void setR8_agg_reg_limits(String r8_agg_reg_limits) {
		this.r8_agg_reg_limits = r8_agg_reg_limits;
	}
	public BigDecimal getR8_total_exposure() {
		return r8_total_exposure;
	}
	public void setR8_total_exposure(BigDecimal r8_total_exposure) {
		this.r8_total_exposure = r8_total_exposure;
	}
	public String getR8_brf_nos() {
		return r8_brf_nos;
	}
	public void setR8_brf_nos(String r8_brf_nos) {
		this.r8_brf_nos = r8_brf_nos;
	}
	public String getR9_product() {
		return r9_product;
	}
	public void setR9_product(String r9_product) {
		this.r9_product = r9_product;
	}
	public String getR9_agg_reg_limits() {
		return r9_agg_reg_limits;
	}
	public void setR9_agg_reg_limits(String r9_agg_reg_limits) {
		this.r9_agg_reg_limits = r9_agg_reg_limits;
	}
	public BigDecimal getR9_total_exposure() {
		return r9_total_exposure;
	}
	public void setR9_total_exposure(BigDecimal r9_total_exposure) {
		this.r9_total_exposure = r9_total_exposure;
	}
	public BigDecimal getR9_per_capital_case() {
		return r9_per_capital_case;
	}
	public void setR9_per_capital_case(BigDecimal r9_per_capital_case) {
		this.r9_per_capital_case = r9_per_capital_case;
	}
	public String getR9_brf_nos() {
		return r9_brf_nos;
	}
	public void setR9_brf_nos(String r9_brf_nos) {
		this.r9_brf_nos = r9_brf_nos;
	}
	public String getR10_product() {
		return r10_product;
	}
	public void setR10_product(String r10_product) {
		this.r10_product = r10_product;
	}
	public String getR10_agg_reg_limits() {
		return r10_agg_reg_limits;
	}
	public void setR10_agg_reg_limits(String r10_agg_reg_limits) {
		this.r10_agg_reg_limits = r10_agg_reg_limits;
	}
	public BigDecimal getR10_total_exposure() {
		return r10_total_exposure;
	}
	public void setR10_total_exposure(BigDecimal r10_total_exposure) {
		this.r10_total_exposure = r10_total_exposure;
	}
	public BigDecimal getR10_per_capital_case() {
		return r10_per_capital_case;
	}
	public void setR10_per_capital_case(BigDecimal r10_per_capital_case) {
		this.r10_per_capital_case = r10_per_capital_case;
	}
	public String getR10_brf_nos() {
		return r10_brf_nos;
	}
	public void setR10_brf_nos(String r10_brf_nos) {
		this.r10_brf_nos = r10_brf_nos;
	}
	public String getR11_product() {
		return r11_product;
	}
	public void setR11_product(String r11_product) {
		this.r11_product = r11_product;
	}
	public String getR11_agg_reg_limits() {
		return r11_agg_reg_limits;
	}
	public void setR11_agg_reg_limits(String r11_agg_reg_limits) {
		this.r11_agg_reg_limits = r11_agg_reg_limits;
	}
	public BigDecimal getR11_total_exposure() {
		return r11_total_exposure;
	}
	public void setR11_total_exposure(BigDecimal r11_total_exposure) {
		this.r11_total_exposure = r11_total_exposure;
	}
	public BigDecimal getR11_per_capital_case() {
		return r11_per_capital_case;
	}
	public void setR11_per_capital_case(BigDecimal r11_per_capital_case) {
		this.r11_per_capital_case = r11_per_capital_case;
	}
	public String getR11_brf_nos() {
		return r11_brf_nos;
	}
	public void setR11_brf_nos(String r11_brf_nos) {
		this.r11_brf_nos = r11_brf_nos;
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
	public BRF76_ENTITY(Date report_date, BigDecimal capital_case, String r1_product, String r1_agg_reg_limits,
			BigDecimal r1_total_exposure, BigDecimal r1_per_capital_case, String r1_brf_nos, String r2_product,
			String r2_agg_reg_limits, BigDecimal r2_total_exposure, BigDecimal r2_per_capital_case, String r2_brf_nos,
			String r3_product, String r3_agg_reg_limits, BigDecimal r3_total_exposure, BigDecimal r3_per_capital_case,
			String r3_brf_nos, String r4_product, String r4_agg_reg_limits, BigDecimal r4_total_exposure,
			String r4_brf_nos, String r5_product, String r5_agg_reg_limits, BigDecimal r5_total_exposure,
			String r5_brf_nos, String r6_product, String r6_agg_reg_limits, BigDecimal r6_total_exposure,
			BigDecimal r6_per_capital_case, String r6_brf_nos, String r7_product, String r7_agg_reg_limits,
			BigDecimal r7_total_exposure, String r7_brf_nos, String r8_product, String r8_agg_reg_limits,
			BigDecimal r8_total_exposure, String r8_brf_nos, String r9_product, String r9_agg_reg_limits,
			BigDecimal r9_total_exposure, BigDecimal r9_per_capital_case, String r9_brf_nos, String r10_product,
			String r10_agg_reg_limits, BigDecimal r10_total_exposure, BigDecimal r10_per_capital_case,
			String r10_brf_nos, String r11_product, String r11_agg_reg_limits, BigDecimal r11_total_exposure,
			BigDecimal r11_per_capital_case, String r11_brf_nos, Date report_from_date, Date report_to_date,
			Date report_submit_date, String entity_flg, String modify_flg, String del_flg) {
		super();
		this.report_date = report_date;
		this.capital_case = capital_case;
		this.r1_product = r1_product;
		this.r1_agg_reg_limits = r1_agg_reg_limits;
		this.r1_total_exposure = r1_total_exposure;
		this.r1_per_capital_case = r1_per_capital_case;
		this.r1_brf_nos = r1_brf_nos;
		this.r2_product = r2_product;
		this.r2_agg_reg_limits = r2_agg_reg_limits;
		this.r2_total_exposure = r2_total_exposure;
		this.r2_per_capital_case = r2_per_capital_case;
		this.r2_brf_nos = r2_brf_nos;
		this.r3_product = r3_product;
		this.r3_agg_reg_limits = r3_agg_reg_limits;
		this.r3_total_exposure = r3_total_exposure;
		this.r3_per_capital_case = r3_per_capital_case;
		this.r3_brf_nos = r3_brf_nos;
		this.r4_product = r4_product;
		this.r4_agg_reg_limits = r4_agg_reg_limits;
		this.r4_total_exposure = r4_total_exposure;
		this.r4_brf_nos = r4_brf_nos;
		this.r5_product = r5_product;
		this.r5_agg_reg_limits = r5_agg_reg_limits;
		this.r5_total_exposure = r5_total_exposure;
		this.r5_brf_nos = r5_brf_nos;
		this.r6_product = r6_product;
		this.r6_agg_reg_limits = r6_agg_reg_limits;
		this.r6_total_exposure = r6_total_exposure;
		this.r6_per_capital_case = r6_per_capital_case;
		this.r6_brf_nos = r6_brf_nos;
		this.r7_product = r7_product;
		this.r7_agg_reg_limits = r7_agg_reg_limits;
		this.r7_total_exposure = r7_total_exposure;
		this.r7_brf_nos = r7_brf_nos;
		this.r8_product = r8_product;
		this.r8_agg_reg_limits = r8_agg_reg_limits;
		this.r8_total_exposure = r8_total_exposure;
		this.r8_brf_nos = r8_brf_nos;
		this.r9_product = r9_product;
		this.r9_agg_reg_limits = r9_agg_reg_limits;
		this.r9_total_exposure = r9_total_exposure;
		this.r9_per_capital_case = r9_per_capital_case;
		this.r9_brf_nos = r9_brf_nos;
		this.r10_product = r10_product;
		this.r10_agg_reg_limits = r10_agg_reg_limits;
		this.r10_total_exposure = r10_total_exposure;
		this.r10_per_capital_case = r10_per_capital_case;
		this.r10_brf_nos = r10_brf_nos;
		this.r11_product = r11_product;
		this.r11_agg_reg_limits = r11_agg_reg_limits;
		this.r11_total_exposure = r11_total_exposure;
		this.r11_per_capital_case = r11_per_capital_case;
		this.r11_brf_nos = r11_brf_nos;
		this.report_from_date = report_from_date;
		this.report_to_date = report_to_date;
		this.report_submit_date = report_submit_date;
		this.entity_flg = entity_flg;
		this.modify_flg = modify_flg;
		this.del_flg = del_flg;
	}
	public BRF76_ENTITY() {
		super();
		// TODO Auto-generated constructor stub
	}
	


}
