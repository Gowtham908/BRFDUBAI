package com.bornfire.xbrl.entities.BRBS;
import java.math.BigDecimal;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="SEC_TB")
public class B18_BASEL_SECURITIZATION_TRADING_RPT {
	
	@Id
	private Date	report_date;
	private String	r1_securitization;
	private BigDecimal	r1_onbalance_asinvestor_simple;
	private BigDecimal	r1_offbalance_asinvestor_simple;
	private BigDecimal	r1_totalexposure_asinvestor_simple;
	private BigDecimal	r1_rwa_asinvestor_simple;
	private BigDecimal	r1_onbalance_notinvestor_simple;
	private BigDecimal	r1_offbalance_notinvestor_simple;
	private BigDecimal	r1_totalexposure_notinvestor_simple;
	private BigDecimal	r1_rwa_notinvestor_simple;
	private BigDecimal	r1_onbalance_asinvestor_resecuritization;
	private BigDecimal	r1_offbalance_asinvestor_resecuritization;
	private BigDecimal	r1_totalexposure_asinvestor_resecuritization;
	private BigDecimal	r1_rwa_asinvestor_resecuritization;
	private BigDecimal	r1_onbalance_notinvestor_resecuritization;
	private BigDecimal	r1_offbalance_notinvestor_resecuritization;
	private BigDecimal	r1_totalexposure_notinvestor_resecuritization;
	private BigDecimal	r1_rwa_notinvestor_resecuritization;
	private BigDecimal	r1_onbalance_asinvestor_traditional;
	private BigDecimal	r1_offbalance_asinvestor_traditional;
	private BigDecimal	r1_totalexposure_asinvestor_traditional;
	private BigDecimal	r1_rwa_asinvestor_traditional;
	private BigDecimal	r1_onbalance_notinvestor_traditional;
	private BigDecimal	r1_offbalance_notinvestor_traditional;
	private BigDecimal	r1_totalexposure_notinvestor_traditional;
	private BigDecimal	r1_rwa_notinvestor_traditional;
	private BigDecimal	r1_onbalance_asinvestor_synthetic;
	private BigDecimal	r1_offbalance_asinvestor_synthetic;
	private BigDecimal	r1_totalexposure_asinvestor_synthetic;
	private BigDecimal	r1_rwa_asinvestor_synthetic;
	private BigDecimal	r1_onbalance_notinvestor_synthetic;
	private BigDecimal	r1_offbalance_notinvestor_synthetic;
	private BigDecimal	r1_totalexposure_notinvestor_synthetic;
	private BigDecimal	r1_rwa_notinvestor_synthetic;
	private BigDecimal	r1_onbalance_asinvestor_total;
	private BigDecimal	r1_offbalance_asinvestor_total;
	private BigDecimal	r1_totalexposure_asinvestor_total;
	private BigDecimal	r1_rwa_asinvestor_total;
	private BigDecimal	r1_onbalance_notinvestor_total;
	private BigDecimal	r1_offbalance_notinvestor_total;
	private BigDecimal	r1_totalexposure_notinvestor_total;
	private BigDecimal	r1_rwa_notinvestor_total;
	private BigDecimal	r1_total;
	private String	r2_securitization;
	private BigDecimal	r2_onbalance_asinvestor_simple;
	private BigDecimal	r2_offbalance_asinvestor_simple;
	private BigDecimal	r2_totalexposure_asinvestor_simple;
	private BigDecimal	r2_rwa_asinvestor_simple;
	private BigDecimal	r2_onbalance_notinvestor_simple;
	private BigDecimal	r2_offbalance_notinvestor_simple;
	private BigDecimal	r2_totalexposure_notinvestor_simple;
	private BigDecimal	r2_rwa_notinvestor_simple;
	private BigDecimal	r2_onbalance_asinvestor_resecuritization;
	private BigDecimal	r2_offbalance_asinvestor_resecuritization;
	private BigDecimal	r2_totalexposure_asinvestor_resecuritization;
	private BigDecimal	r2_rwa_asinvestor_resecuritization;
	private BigDecimal	r2_onbalance_notinvestor_resecuritization;
	private BigDecimal	r2_offbalance_notinvestor_resecuritization;
	private BigDecimal	r2_totalexposure_notinvestor_resecuritization;
	private BigDecimal	r2_rwa_notinvestor_resecuritization;
	private BigDecimal	r2_onbalance_asinvestor_traditional;
	private BigDecimal	r2_offbalance_asinvestor_traditional;
	private BigDecimal	r2_totalexposure_asinvestor_traditional;
	private BigDecimal	r2_rwa_asinvestor_traditional;
	private BigDecimal	r2_onbalance_notinvestor_traditional;
	private BigDecimal	r2_offbalance_notinvestor_traditional;
	private BigDecimal	r2_totalexposure_notinvestor_traditional;
	private BigDecimal	r2_rwa_notinvestor_traditional;
	private BigDecimal	r2_onbalance_asinvestor_synthetic;
	private BigDecimal	r2_offbalance_asinvestor_synthetic;
	private BigDecimal	r2_totalexposure_asinvestor_synthetic;
	private BigDecimal	r2_rwa_asinvestor_synthetic;
	private BigDecimal	r2_onbalance_notinvestor_synthetic;
	private BigDecimal	r2_offbalance_notinvestor_synthetic;
	private BigDecimal	r2_totalexposure_notinvestor_synthetic;
	private BigDecimal	r2_rwa_notinvestor_synthetic;
	private BigDecimal	r2_onbalance_asinvestor_total;
	private BigDecimal	r2_offbalance_asinvestor_total;
	private BigDecimal	r2_totalexposure_asinvestor_total;
	private BigDecimal	r2_rwa_asinvestor_total;
	private BigDecimal	r2_onbalance_notinvestor_total;
	private BigDecimal	r2_offbalance_notinvestor_total;
	private BigDecimal	r2_totalexposure_notinvestor_total;
	private BigDecimal	r2_rwa_notinvestor_total;
	private BigDecimal	r2_total;
	private String	r3_securitization;
	private BigDecimal	r3_onbalance_asinvestor_simple;
	private BigDecimal	r3_offbalance_asinvestor_simple;
	private BigDecimal	r3_totalexposure_asinvestor_simple;
	private BigDecimal	r3_rwa_asinvestor_simple;
	private BigDecimal	r3_onbalance_notinvestor_simple;
	private BigDecimal	r3_offbalance_notinvestor_simple;
	private BigDecimal	r3_totalexposure_notinvestor_simple;
	private BigDecimal	r3_rwa_notinvestor_simple;
	private BigDecimal	r3_onbalance_asinvestor_resecuritization;
	private BigDecimal	r3_offbalance_asinvestor_resecuritization;
	private BigDecimal	r3_totalexposure_asinvestor_resecuritization;
	private BigDecimal	r3_rwa_asinvestor_resecuritization;
	private BigDecimal	r3_onbalance_notinvestor_resecuritization;
	private BigDecimal	r3_offbalance_notinvestor_resecuritization;
	private BigDecimal	r3_totalexposure_notinvestor_resecuritization;
	private BigDecimal	r3_rwa_notinvestor_resecuritization;
	private BigDecimal	r3_onbalance_asinvestor_traditional;
	private BigDecimal	r3_offbalance_asinvestor_traditional;
	private BigDecimal	r3_totalexposure_asinvestor_traditional;
	private BigDecimal	r3_rwa_asinvestor_traditional;
	private BigDecimal	r3_onbalance_notinvestor_traditional;
	private BigDecimal	r3_offbalance_notinvestor_traditional;
	private BigDecimal	r3_totalexposure_notinvestor_traditional;
	private BigDecimal	r3_rwa_notinvestor_traditional;
	private BigDecimal	r3_onbalance_asinvestor_synthetic;
	private BigDecimal	r3_offbalance_asinvestor_synthetic;
	private BigDecimal	r3_totalexposure_asinvestor_synthetic;
	private BigDecimal	r3_rwa_asinvestor_synthetic;
	private BigDecimal	r3_onbalance_notinvestor_synthetic;
	private BigDecimal	r3_offbalance_notinvestor_synthetic;
	private BigDecimal	r3_totalexposure_notinvestor_synthetic;
	private BigDecimal	r3_rwa_notinvestor_synthetic;
	private BigDecimal	r3_onbalance_asinvestor_total;
	private BigDecimal	r3_offbalance_asinvestor_total;
	private BigDecimal	r3_totalexposure_asinvestor_total;
	private BigDecimal	r3_rwa_asinvestor_total;
	private BigDecimal	r3_onbalance_notinvestor_total;
	private BigDecimal	r3_offbalance_notinvestor_total;
	private BigDecimal	r3_totalexposure_notinvestor_total;
	private BigDecimal	r3_rwa_notinvestor_total;
	private BigDecimal	r3_total;
	private String	r4_securitization;
	private BigDecimal	r4_onbalance_asinvestor_simple;
	private BigDecimal	r4_offbalance_asinvestor_simple;
	private BigDecimal	r4_totalexposure_asinvestor_simple;
	private BigDecimal	r4_rwa_asinvestor_simple;
	private BigDecimal	r4_onbalance_notinvestor_simple;
	private BigDecimal	r4_offbalance_notinvestor_simple;
	private BigDecimal	r4_totalexposure_notinvestor_simple;
	private BigDecimal	r4_rwa_notinvestor_simple;
	private BigDecimal	r4_onbalance_asinvestor_resecuritization;
	private BigDecimal	r4_offbalance_asinvestor_resecuritization;
	private BigDecimal	r4_totalexposure_asinvestor_resecuritization;
	private BigDecimal	r4_rwa_asinvestor_resecuritization;
	private BigDecimal	r4_onbalance_notinvestor_resecuritization;
	private BigDecimal	r4_offbalance_notinvestor_resecuritization;
	private BigDecimal	r4_totalexposure_notinvestor_resecuritization;
	private BigDecimal	r4_rwa_notinvestor_resecuritization;
	private BigDecimal	r4_onbalance_asinvestor_traditional;
	private BigDecimal	r4_offbalance_asinvestor_traditional;
	private BigDecimal	r4_totalexposure_asinvestor_traditional;
	private BigDecimal	r4_rwa_asinvestor_traditional;
	private BigDecimal	r4_onbalance_notinvestor_traditional;
	private BigDecimal	r4_offbalance_notinvestor_traditional;
	private BigDecimal	r4_totalexposure_notinvestor_traditional;
	private BigDecimal	r4_rwa_notinvestor_traditional;
	private BigDecimal	r4_onbalance_asinvestor_synthetic;
	private BigDecimal	r4_offbalance_asinvestor_synthetic;
	private BigDecimal	r4_totalexposure_asinvestor_synthetic;
	private BigDecimal	r4_rwa_asinvestor_synthetic;
	private BigDecimal	r4_onbalance_notinvestor_synthetic;
	private BigDecimal	r4_offbalance_notinvestor_synthetic;
	private BigDecimal	r4_totalexposure_notinvestor_synthetic;
	private BigDecimal	r4_rwa_notinvestor_synthetic;
	private BigDecimal	r4_onbalance_asinvestor_total;
	private BigDecimal	r4_offbalance_asinvestor_total;
	private BigDecimal	r4_totalexposure_asinvestor_total;
	private BigDecimal	r4_rwa_asinvestor_total;
	private BigDecimal	r4_onbalance_notinvestor_total;
	private BigDecimal	r4_offbalance_notinvestor_total;
	private BigDecimal	r4_totalexposure_notinvestor_total;
	private BigDecimal	r4_rwa_notinvestor_total;
	private BigDecimal	r4_total;
	private String	r5_securitization;
	private BigDecimal	r5_onbalance_asinvestor_simple;
	private BigDecimal	r5_offbalance_asinvestor_simple;
	private BigDecimal	r5_totalexposure_asinvestor_simple;
	private BigDecimal	r5_rwa_asinvestor_simple;
	private BigDecimal	r5_onbalance_notinvestor_simple;
	private BigDecimal	r5_offbalance_notinvestor_simple;
	private BigDecimal	r5_totalexposure_notinvestor_simple;
	private BigDecimal	r5_rwa_notinvestor_simple;
	private BigDecimal	r5_onbalance_asinvestor_resecuritization;
	private BigDecimal	r5_offbalance_asinvestor_resecuritization;
	private BigDecimal	r5_totalexposure_asinvestor_resecuritization;
	private BigDecimal	r5_rwa_asinvestor_resecuritization;
	private BigDecimal	r5_onbalance_notinvestor_resecuritization;
	private BigDecimal	r5_offbalance_notinvestor_resecuritization;
	private BigDecimal	r5_totalexposure_notinvestor_resecuritization;
	private BigDecimal	r5_rwa_notinvestor_resecuritization;
	private BigDecimal	r5_onbalance_asinvestor_traditional;
	private BigDecimal	r5_offbalance_asinvestor_traditional;
	private BigDecimal	r5_totalexposure_asinvestor_traditional;
	private BigDecimal	r5_rwa_asinvestor_traditional;
	private BigDecimal	r5_onbalance_notinvestor_traditional;
	private BigDecimal	r5_offbalance_notinvestor_traditional;
	private BigDecimal	r5_totalexposure_notinvestor_traditional;
	private BigDecimal	r5_rwa_notinvestor_traditional;
	private BigDecimal	r5_onbalance_asinvestor_synthetic;
	private BigDecimal	r5_offbalance_asinvestor_synthetic;
	private BigDecimal	r5_totalexposure_asinvestor_synthetic;
	private BigDecimal	r5_rwa_asinvestor_synthetic;
	private BigDecimal	r5_onbalance_notinvestor_synthetic;
	private BigDecimal	r5_offbalance_notinvestor_synthetic;
	private BigDecimal	r5_totalexposure_notinvestor_synthetic;
	private BigDecimal	r5_rwa_notinvestor_synthetic;
	private BigDecimal	r5_onbalance_asinvestor_total;
	private BigDecimal	r5_offbalance_asinvestor_total;
	private BigDecimal	r5_totalexposure_asinvestor_total;
	private BigDecimal	r5_rwa_asinvestor_total;
	private BigDecimal	r5_onbalance_notinvestor_total;
	private BigDecimal	r5_offbalance_notinvestor_total;
	private BigDecimal	r5_totalexposure_notinvestor_total;
	private BigDecimal	r5_rwa_notinvestor_total;
	private BigDecimal	r5_total;
	private String	r6_securitization;
	private BigDecimal	r6_onbalance_asinvestor_simple;
	private BigDecimal	r6_offbalance_asinvestor_simple;
	private BigDecimal	r6_totalexposure_asinvestor_simple;
	private BigDecimal	r6_rwa_asinvestor_simple;
	private BigDecimal	r6_onbalance_notinvestor_simple;
	private BigDecimal	r6_offbalance_notinvestor_simple;
	private BigDecimal	r6_totalexposure_notinvestor_simple;
	private BigDecimal	r6_rwa_notinvestor_simple;
	private BigDecimal	r6_onbalance_asinvestor_resecuritization;
	private BigDecimal	r6_offbalance_asinvestor_resecuritization;
	private BigDecimal	r6_totalexposure_asinvestor_resecuritization;
	private BigDecimal	r6_rwa_asinvestor_resecuritization;
	private BigDecimal	r6_onbalance_notinvestor_resecuritization;
	private BigDecimal	r6_offbalance_notinvestor_resecuritization;
	private BigDecimal	r6_totalexposure_notinvestor_resecuritization;
	private BigDecimal	r6_rwa_notinvestor_resecuritization;
	private BigDecimal	r6_onbalance_asinvestor_traditional;
	private BigDecimal	r6_offbalance_asinvestor_traditional;
	private BigDecimal	r6_totalexposure_asinvestor_traditional;
	private BigDecimal	r6_rwa_asinvestor_traditional;
	private BigDecimal	r6_onbalance_notinvestor_traditional;
	private BigDecimal	r6_offbalance_notinvestor_traditional;
	private BigDecimal	r6_totalexposure_notinvestor_traditional;
	private BigDecimal	r6_rwa_notinvestor_traditional;
	private BigDecimal	r6_onbalance_asinvestor_synthetic;
	private BigDecimal	r6_offbalance_asinvestor_synthetic;
	private BigDecimal	r6_totalexposure_asinvestor_synthetic;
	private BigDecimal	r6_rwa_asinvestor_synthetic;
	private BigDecimal	r6_onbalance_notinvestor_synthetic;
	private BigDecimal	r6_offbalance_notinvestor_synthetic;
	private BigDecimal	r6_totalexposure_notinvestor_synthetic;
	private BigDecimal	r6_rwa_notinvestor_synthetic;
	private BigDecimal	r6_onbalance_asinvestor_total;
	private BigDecimal	r6_offbalance_asinvestor_total;
	private BigDecimal	r6_totalexposure_asinvestor_total;
	private BigDecimal	r6_rwa_asinvestor_total;
	private BigDecimal	r6_onbalance_notinvestor_total;
	private BigDecimal	r6_offbalance_notinvestor_total;
	private BigDecimal	r6_totalexposure_notinvestor_total;
	private BigDecimal	r6_rwa_notinvestor_total;
	private BigDecimal	r6_total;
	private Date	report_submit_date;
	private Date	report_from_date;
	private Date	report_to_date;
	private String	report_code;
	private String	entity_flg;
	private String	modify_flg;
	private String	del_flg;
	public Date getReport_date() {
		return report_date;
	}
	public void setReport_date(Date report_date) {
		this.report_date = report_date;
	}
	public String getR1_securitization() {
		return r1_securitization;
	}
	public void setR1_securitization(String r1_securitization) {
		this.r1_securitization = r1_securitization;
	}
	public BigDecimal getR1_onbalance_asinvestor_simple() {
		return r1_onbalance_asinvestor_simple;
	}
	public void setR1_onbalance_asinvestor_simple(BigDecimal r1_onbalance_asinvestor_simple) {
		this.r1_onbalance_asinvestor_simple = r1_onbalance_asinvestor_simple;
	}
	public BigDecimal getR1_offbalance_asinvestor_simple() {
		return r1_offbalance_asinvestor_simple;
	}
	public void setR1_offbalance_asinvestor_simple(BigDecimal r1_offbalance_asinvestor_simple) {
		this.r1_offbalance_asinvestor_simple = r1_offbalance_asinvestor_simple;
	}
	public BigDecimal getR1_totalexposure_asinvestor_simple() {
		return r1_totalexposure_asinvestor_simple;
	}
	public void setR1_totalexposure_asinvestor_simple(BigDecimal r1_totalexposure_asinvestor_simple) {
		this.r1_totalexposure_asinvestor_simple = r1_totalexposure_asinvestor_simple;
	}
	public BigDecimal getR1_rwa_asinvestor_simple() {
		return r1_rwa_asinvestor_simple;
	}
	public void setR1_rwa_asinvestor_simple(BigDecimal r1_rwa_asinvestor_simple) {
		this.r1_rwa_asinvestor_simple = r1_rwa_asinvestor_simple;
	}
	public BigDecimal getR1_onbalance_notinvestor_simple() {
		return r1_onbalance_notinvestor_simple;
	}
	public void setR1_onbalance_notinvestor_simple(BigDecimal r1_onbalance_notinvestor_simple) {
		this.r1_onbalance_notinvestor_simple = r1_onbalance_notinvestor_simple;
	}
	public BigDecimal getR1_offbalance_notinvestor_simple() {
		return r1_offbalance_notinvestor_simple;
	}
	public void setR1_offbalance_notinvestor_simple(BigDecimal r1_offbalance_notinvestor_simple) {
		this.r1_offbalance_notinvestor_simple = r1_offbalance_notinvestor_simple;
	}
	public BigDecimal getR1_totalexposure_notinvestor_simple() {
		return r1_totalexposure_notinvestor_simple;
	}
	public void setR1_totalexposure_notinvestor_simple(BigDecimal r1_totalexposure_notinvestor_simple) {
		this.r1_totalexposure_notinvestor_simple = r1_totalexposure_notinvestor_simple;
	}
	public BigDecimal getR1_rwa_notinvestor_simple() {
		return r1_rwa_notinvestor_simple;
	}
	public void setR1_rwa_notinvestor_simple(BigDecimal r1_rwa_notinvestor_simple) {
		this.r1_rwa_notinvestor_simple = r1_rwa_notinvestor_simple;
	}
	public BigDecimal getR1_onbalance_asinvestor_resecuritization() {
		return r1_onbalance_asinvestor_resecuritization;
	}
	public void setR1_onbalance_asinvestor_resecuritization(BigDecimal r1_onbalance_asinvestor_resecuritization) {
		this.r1_onbalance_asinvestor_resecuritization = r1_onbalance_asinvestor_resecuritization;
	}
	public BigDecimal getR1_offbalance_asinvestor_resecuritization() {
		return r1_offbalance_asinvestor_resecuritization;
	}
	public void setR1_offbalance_asinvestor_resecuritization(BigDecimal r1_offbalance_asinvestor_resecuritization) {
		this.r1_offbalance_asinvestor_resecuritization = r1_offbalance_asinvestor_resecuritization;
	}
	public BigDecimal getR1_totalexposure_asinvestor_resecuritization() {
		return r1_totalexposure_asinvestor_resecuritization;
	}
	public void setR1_totalexposure_asinvestor_resecuritization(
			BigDecimal r1_totalexposure_asinvestor_resecuritization) {
		this.r1_totalexposure_asinvestor_resecuritization = r1_totalexposure_asinvestor_resecuritization;
	}
	public BigDecimal getR1_rwa_asinvestor_resecuritization() {
		return r1_rwa_asinvestor_resecuritization;
	}
	public void setR1_rwa_asinvestor_resecuritization(BigDecimal r1_rwa_asinvestor_resecuritization) {
		this.r1_rwa_asinvestor_resecuritization = r1_rwa_asinvestor_resecuritization;
	}
	public BigDecimal getR1_onbalance_notinvestor_resecuritization() {
		return r1_onbalance_notinvestor_resecuritization;
	}
	public void setR1_onbalance_notinvestor_resecuritization(BigDecimal r1_onbalance_notinvestor_resecuritization) {
		this.r1_onbalance_notinvestor_resecuritization = r1_onbalance_notinvestor_resecuritization;
	}
	public BigDecimal getR1_offbalance_notinvestor_resecuritization() {
		return r1_offbalance_notinvestor_resecuritization;
	}
	public void setR1_offbalance_notinvestor_resecuritization(BigDecimal r1_offbalance_notinvestor_resecuritization) {
		this.r1_offbalance_notinvestor_resecuritization = r1_offbalance_notinvestor_resecuritization;
	}
	public BigDecimal getR1_totalexposure_notinvestor_resecuritization() {
		return r1_totalexposure_notinvestor_resecuritization;
	}
	public void setR1_totalexposure_notinvestor_resecuritization(
			BigDecimal r1_totalexposure_notinvestor_resecuritization) {
		this.r1_totalexposure_notinvestor_resecuritization = r1_totalexposure_notinvestor_resecuritization;
	}
	public BigDecimal getR1_rwa_notinvestor_resecuritization() {
		return r1_rwa_notinvestor_resecuritization;
	}
	public void setR1_rwa_notinvestor_resecuritization(BigDecimal r1_rwa_notinvestor_resecuritization) {
		this.r1_rwa_notinvestor_resecuritization = r1_rwa_notinvestor_resecuritization;
	}
	public BigDecimal getR1_onbalance_asinvestor_traditional() {
		return r1_onbalance_asinvestor_traditional;
	}
	public void setR1_onbalance_asinvestor_traditional(BigDecimal r1_onbalance_asinvestor_traditional) {
		this.r1_onbalance_asinvestor_traditional = r1_onbalance_asinvestor_traditional;
	}
	public BigDecimal getR1_offbalance_asinvestor_traditional() {
		return r1_offbalance_asinvestor_traditional;
	}
	public void setR1_offbalance_asinvestor_traditional(BigDecimal r1_offbalance_asinvestor_traditional) {
		this.r1_offbalance_asinvestor_traditional = r1_offbalance_asinvestor_traditional;
	}
	public BigDecimal getR1_totalexposure_asinvestor_traditional() {
		return r1_totalexposure_asinvestor_traditional;
	}
	public void setR1_totalexposure_asinvestor_traditional(BigDecimal r1_totalexposure_asinvestor_traditional) {
		this.r1_totalexposure_asinvestor_traditional = r1_totalexposure_asinvestor_traditional;
	}
	public BigDecimal getR1_rwa_asinvestor_traditional() {
		return r1_rwa_asinvestor_traditional;
	}
	public void setR1_rwa_asinvestor_traditional(BigDecimal r1_rwa_asinvestor_traditional) {
		this.r1_rwa_asinvestor_traditional = r1_rwa_asinvestor_traditional;
	}
	public BigDecimal getR1_onbalance_notinvestor_traditional() {
		return r1_onbalance_notinvestor_traditional;
	}
	public void setR1_onbalance_notinvestor_traditional(BigDecimal r1_onbalance_notinvestor_traditional) {
		this.r1_onbalance_notinvestor_traditional = r1_onbalance_notinvestor_traditional;
	}
	public BigDecimal getR1_offbalance_notinvestor_traditional() {
		return r1_offbalance_notinvestor_traditional;
	}
	public void setR1_offbalance_notinvestor_traditional(BigDecimal r1_offbalance_notinvestor_traditional) {
		this.r1_offbalance_notinvestor_traditional = r1_offbalance_notinvestor_traditional;
	}
	public BigDecimal getR1_totalexposure_notinvestor_traditional() {
		return r1_totalexposure_notinvestor_traditional;
	}
	public void setR1_totalexposure_notinvestor_traditional(BigDecimal r1_totalexposure_notinvestor_traditional) {
		this.r1_totalexposure_notinvestor_traditional = r1_totalexposure_notinvestor_traditional;
	}
	public BigDecimal getR1_rwa_notinvestor_traditional() {
		return r1_rwa_notinvestor_traditional;
	}
	public void setR1_rwa_notinvestor_traditional(BigDecimal r1_rwa_notinvestor_traditional) {
		this.r1_rwa_notinvestor_traditional = r1_rwa_notinvestor_traditional;
	}
	public BigDecimal getR1_onbalance_asinvestor_synthetic() {
		return r1_onbalance_asinvestor_synthetic;
	}
	public void setR1_onbalance_asinvestor_synthetic(BigDecimal r1_onbalance_asinvestor_synthetic) {
		this.r1_onbalance_asinvestor_synthetic = r1_onbalance_asinvestor_synthetic;
	}
	public BigDecimal getR1_offbalance_asinvestor_synthetic() {
		return r1_offbalance_asinvestor_synthetic;
	}
	public void setR1_offbalance_asinvestor_synthetic(BigDecimal r1_offbalance_asinvestor_synthetic) {
		this.r1_offbalance_asinvestor_synthetic = r1_offbalance_asinvestor_synthetic;
	}
	public BigDecimal getR1_totalexposure_asinvestor_synthetic() {
		return r1_totalexposure_asinvestor_synthetic;
	}
	public void setR1_totalexposure_asinvestor_synthetic(BigDecimal r1_totalexposure_asinvestor_synthetic) {
		this.r1_totalexposure_asinvestor_synthetic = r1_totalexposure_asinvestor_synthetic;
	}
	public BigDecimal getR1_rwa_asinvestor_synthetic() {
		return r1_rwa_asinvestor_synthetic;
	}
	public void setR1_rwa_asinvestor_synthetic(BigDecimal r1_rwa_asinvestor_synthetic) {
		this.r1_rwa_asinvestor_synthetic = r1_rwa_asinvestor_synthetic;
	}
	public BigDecimal getR1_onbalance_notinvestor_synthetic() {
		return r1_onbalance_notinvestor_synthetic;
	}
	public void setR1_onbalance_notinvestor_synthetic(BigDecimal r1_onbalance_notinvestor_synthetic) {
		this.r1_onbalance_notinvestor_synthetic = r1_onbalance_notinvestor_synthetic;
	}
	public BigDecimal getR1_offbalance_notinvestor_synthetic() {
		return r1_offbalance_notinvestor_synthetic;
	}
	public void setR1_offbalance_notinvestor_synthetic(BigDecimal r1_offbalance_notinvestor_synthetic) {
		this.r1_offbalance_notinvestor_synthetic = r1_offbalance_notinvestor_synthetic;
	}
	public BigDecimal getR1_totalexposure_notinvestor_synthetic() {
		return r1_totalexposure_notinvestor_synthetic;
	}
	public void setR1_totalexposure_notinvestor_synthetic(BigDecimal r1_totalexposure_notinvestor_synthetic) {
		this.r1_totalexposure_notinvestor_synthetic = r1_totalexposure_notinvestor_synthetic;
	}
	public BigDecimal getR1_rwa_notinvestor_synthetic() {
		return r1_rwa_notinvestor_synthetic;
	}
	public void setR1_rwa_notinvestor_synthetic(BigDecimal r1_rwa_notinvestor_synthetic) {
		this.r1_rwa_notinvestor_synthetic = r1_rwa_notinvestor_synthetic;
	}
	public BigDecimal getR1_onbalance_asinvestor_total() {
		return r1_onbalance_asinvestor_total;
	}
	public void setR1_onbalance_asinvestor_total(BigDecimal r1_onbalance_asinvestor_total) {
		this.r1_onbalance_asinvestor_total = r1_onbalance_asinvestor_total;
	}
	public BigDecimal getR1_offbalance_asinvestor_total() {
		return r1_offbalance_asinvestor_total;
	}
	public void setR1_offbalance_asinvestor_total(BigDecimal r1_offbalance_asinvestor_total) {
		this.r1_offbalance_asinvestor_total = r1_offbalance_asinvestor_total;
	}
	public BigDecimal getR1_totalexposure_asinvestor_total() {
		return r1_totalexposure_asinvestor_total;
	}
	public void setR1_totalexposure_asinvestor_total(BigDecimal r1_totalexposure_asinvestor_total) {
		this.r1_totalexposure_asinvestor_total = r1_totalexposure_asinvestor_total;
	}
	public BigDecimal getR1_rwa_asinvestor_total() {
		return r1_rwa_asinvestor_total;
	}
	public void setR1_rwa_asinvestor_total(BigDecimal r1_rwa_asinvestor_total) {
		this.r1_rwa_asinvestor_total = r1_rwa_asinvestor_total;
	}
	public BigDecimal getR1_onbalance_notinvestor_total() {
		return r1_onbalance_notinvestor_total;
	}
	public void setR1_onbalance_notinvestor_total(BigDecimal r1_onbalance_notinvestor_total) {
		this.r1_onbalance_notinvestor_total = r1_onbalance_notinvestor_total;
	}
	public BigDecimal getR1_offbalance_notinvestor_total() {
		return r1_offbalance_notinvestor_total;
	}
	public void setR1_offbalance_notinvestor_total(BigDecimal r1_offbalance_notinvestor_total) {
		this.r1_offbalance_notinvestor_total = r1_offbalance_notinvestor_total;
	}
	public BigDecimal getR1_totalexposure_notinvestor_total() {
		return r1_totalexposure_notinvestor_total;
	}
	public void setR1_totalexposure_notinvestor_total(BigDecimal r1_totalexposure_notinvestor_total) {
		this.r1_totalexposure_notinvestor_total = r1_totalexposure_notinvestor_total;
	}
	public BigDecimal getR1_rwa_notinvestor_total() {
		return r1_rwa_notinvestor_total;
	}
	public void setR1_rwa_notinvestor_total(BigDecimal r1_rwa_notinvestor_total) {
		this.r1_rwa_notinvestor_total = r1_rwa_notinvestor_total;
	}
	public BigDecimal getR1_total() {
		return r1_total;
	}
	public void setR1_total(BigDecimal r1_total) {
		this.r1_total = r1_total;
	}
	public String getR2_securitization() {
		return r2_securitization;
	}
	public void setR2_securitization(String r2_securitization) {
		this.r2_securitization = r2_securitization;
	}
	public BigDecimal getR2_onbalance_asinvestor_simple() {
		return r2_onbalance_asinvestor_simple;
	}
	public void setR2_onbalance_asinvestor_simple(BigDecimal r2_onbalance_asinvestor_simple) {
		this.r2_onbalance_asinvestor_simple = r2_onbalance_asinvestor_simple;
	}
	public BigDecimal getR2_offbalance_asinvestor_simple() {
		return r2_offbalance_asinvestor_simple;
	}
	public void setR2_offbalance_asinvestor_simple(BigDecimal r2_offbalance_asinvestor_simple) {
		this.r2_offbalance_asinvestor_simple = r2_offbalance_asinvestor_simple;
	}
	public BigDecimal getR2_totalexposure_asinvestor_simple() {
		return r2_totalexposure_asinvestor_simple;
	}
	public void setR2_totalexposure_asinvestor_simple(BigDecimal r2_totalexposure_asinvestor_simple) {
		this.r2_totalexposure_asinvestor_simple = r2_totalexposure_asinvestor_simple;
	}
	public BigDecimal getR2_rwa_asinvestor_simple() {
		return r2_rwa_asinvestor_simple;
	}
	public void setR2_rwa_asinvestor_simple(BigDecimal r2_rwa_asinvestor_simple) {
		this.r2_rwa_asinvestor_simple = r2_rwa_asinvestor_simple;
	}
	public BigDecimal getR2_onbalance_notinvestor_simple() {
		return r2_onbalance_notinvestor_simple;
	}
	public void setR2_onbalance_notinvestor_simple(BigDecimal r2_onbalance_notinvestor_simple) {
		this.r2_onbalance_notinvestor_simple = r2_onbalance_notinvestor_simple;
	}
	public BigDecimal getR2_offbalance_notinvestor_simple() {
		return r2_offbalance_notinvestor_simple;
	}
	public void setR2_offbalance_notinvestor_simple(BigDecimal r2_offbalance_notinvestor_simple) {
		this.r2_offbalance_notinvestor_simple = r2_offbalance_notinvestor_simple;
	}
	public BigDecimal getR2_totalexposure_notinvestor_simple() {
		return r2_totalexposure_notinvestor_simple;
	}
	public void setR2_totalexposure_notinvestor_simple(BigDecimal r2_totalexposure_notinvestor_simple) {
		this.r2_totalexposure_notinvestor_simple = r2_totalexposure_notinvestor_simple;
	}
	public BigDecimal getR2_rwa_notinvestor_simple() {
		return r2_rwa_notinvestor_simple;
	}
	public void setR2_rwa_notinvestor_simple(BigDecimal r2_rwa_notinvestor_simple) {
		this.r2_rwa_notinvestor_simple = r2_rwa_notinvestor_simple;
	}
	public BigDecimal getR2_onbalance_asinvestor_resecuritization() {
		return r2_onbalance_asinvestor_resecuritization;
	}
	public void setR2_onbalance_asinvestor_resecuritization(BigDecimal r2_onbalance_asinvestor_resecuritization) {
		this.r2_onbalance_asinvestor_resecuritization = r2_onbalance_asinvestor_resecuritization;
	}
	public BigDecimal getR2_offbalance_asinvestor_resecuritization() {
		return r2_offbalance_asinvestor_resecuritization;
	}
	public void setR2_offbalance_asinvestor_resecuritization(BigDecimal r2_offbalance_asinvestor_resecuritization) {
		this.r2_offbalance_asinvestor_resecuritization = r2_offbalance_asinvestor_resecuritization;
	}
	public BigDecimal getR2_totalexposure_asinvestor_resecuritization() {
		return r2_totalexposure_asinvestor_resecuritization;
	}
	public void setR2_totalexposure_asinvestor_resecuritization(
			BigDecimal r2_totalexposure_asinvestor_resecuritization) {
		this.r2_totalexposure_asinvestor_resecuritization = r2_totalexposure_asinvestor_resecuritization;
	}
	public BigDecimal getR2_rwa_asinvestor_resecuritization() {
		return r2_rwa_asinvestor_resecuritization;
	}
	public void setR2_rwa_asinvestor_resecuritization(BigDecimal r2_rwa_asinvestor_resecuritization) {
		this.r2_rwa_asinvestor_resecuritization = r2_rwa_asinvestor_resecuritization;
	}
	public BigDecimal getR2_onbalance_notinvestor_resecuritization() {
		return r2_onbalance_notinvestor_resecuritization;
	}
	public void setR2_onbalance_notinvestor_resecuritization(BigDecimal r2_onbalance_notinvestor_resecuritization) {
		this.r2_onbalance_notinvestor_resecuritization = r2_onbalance_notinvestor_resecuritization;
	}
	public BigDecimal getR2_offbalance_notinvestor_resecuritization() {
		return r2_offbalance_notinvestor_resecuritization;
	}
	public void setR2_offbalance_notinvestor_resecuritization(BigDecimal r2_offbalance_notinvestor_resecuritization) {
		this.r2_offbalance_notinvestor_resecuritization = r2_offbalance_notinvestor_resecuritization;
	}
	public BigDecimal getR2_totalexposure_notinvestor_resecuritization() {
		return r2_totalexposure_notinvestor_resecuritization;
	}
	public void setR2_totalexposure_notinvestor_resecuritization(
			BigDecimal r2_totalexposure_notinvestor_resecuritization) {
		this.r2_totalexposure_notinvestor_resecuritization = r2_totalexposure_notinvestor_resecuritization;
	}
	public BigDecimal getR2_rwa_notinvestor_resecuritization() {
		return r2_rwa_notinvestor_resecuritization;
	}
	public void setR2_rwa_notinvestor_resecuritization(BigDecimal r2_rwa_notinvestor_resecuritization) {
		this.r2_rwa_notinvestor_resecuritization = r2_rwa_notinvestor_resecuritization;
	}
	public BigDecimal getR2_onbalance_asinvestor_traditional() {
		return r2_onbalance_asinvestor_traditional;
	}
	public void setR2_onbalance_asinvestor_traditional(BigDecimal r2_onbalance_asinvestor_traditional) {
		this.r2_onbalance_asinvestor_traditional = r2_onbalance_asinvestor_traditional;
	}
	public BigDecimal getR2_offbalance_asinvestor_traditional() {
		return r2_offbalance_asinvestor_traditional;
	}
	public void setR2_offbalance_asinvestor_traditional(BigDecimal r2_offbalance_asinvestor_traditional) {
		this.r2_offbalance_asinvestor_traditional = r2_offbalance_asinvestor_traditional;
	}
	public BigDecimal getR2_totalexposure_asinvestor_traditional() {
		return r2_totalexposure_asinvestor_traditional;
	}
	public void setR2_totalexposure_asinvestor_traditional(BigDecimal r2_totalexposure_asinvestor_traditional) {
		this.r2_totalexposure_asinvestor_traditional = r2_totalexposure_asinvestor_traditional;
	}
	public BigDecimal getR2_rwa_asinvestor_traditional() {
		return r2_rwa_asinvestor_traditional;
	}
	public void setR2_rwa_asinvestor_traditional(BigDecimal r2_rwa_asinvestor_traditional) {
		this.r2_rwa_asinvestor_traditional = r2_rwa_asinvestor_traditional;
	}
	public BigDecimal getR2_onbalance_notinvestor_traditional() {
		return r2_onbalance_notinvestor_traditional;
	}
	public void setR2_onbalance_notinvestor_traditional(BigDecimal r2_onbalance_notinvestor_traditional) {
		this.r2_onbalance_notinvestor_traditional = r2_onbalance_notinvestor_traditional;
	}
	public BigDecimal getR2_offbalance_notinvestor_traditional() {
		return r2_offbalance_notinvestor_traditional;
	}
	public void setR2_offbalance_notinvestor_traditional(BigDecimal r2_offbalance_notinvestor_traditional) {
		this.r2_offbalance_notinvestor_traditional = r2_offbalance_notinvestor_traditional;
	}
	public BigDecimal getR2_totalexposure_notinvestor_traditional() {
		return r2_totalexposure_notinvestor_traditional;
	}
	public void setR2_totalexposure_notinvestor_traditional(BigDecimal r2_totalexposure_notinvestor_traditional) {
		this.r2_totalexposure_notinvestor_traditional = r2_totalexposure_notinvestor_traditional;
	}
	public BigDecimal getR2_rwa_notinvestor_traditional() {
		return r2_rwa_notinvestor_traditional;
	}
	public void setR2_rwa_notinvestor_traditional(BigDecimal r2_rwa_notinvestor_traditional) {
		this.r2_rwa_notinvestor_traditional = r2_rwa_notinvestor_traditional;
	}
	public BigDecimal getR2_onbalance_asinvestor_synthetic() {
		return r2_onbalance_asinvestor_synthetic;
	}
	public void setR2_onbalance_asinvestor_synthetic(BigDecimal r2_onbalance_asinvestor_synthetic) {
		this.r2_onbalance_asinvestor_synthetic = r2_onbalance_asinvestor_synthetic;
	}
	public BigDecimal getR2_offbalance_asinvestor_synthetic() {
		return r2_offbalance_asinvestor_synthetic;
	}
	public void setR2_offbalance_asinvestor_synthetic(BigDecimal r2_offbalance_asinvestor_synthetic) {
		this.r2_offbalance_asinvestor_synthetic = r2_offbalance_asinvestor_synthetic;
	}
	public BigDecimal getR2_totalexposure_asinvestor_synthetic() {
		return r2_totalexposure_asinvestor_synthetic;
	}
	public void setR2_totalexposure_asinvestor_synthetic(BigDecimal r2_totalexposure_asinvestor_synthetic) {
		this.r2_totalexposure_asinvestor_synthetic = r2_totalexposure_asinvestor_synthetic;
	}
	public BigDecimal getR2_rwa_asinvestor_synthetic() {
		return r2_rwa_asinvestor_synthetic;
	}
	public void setR2_rwa_asinvestor_synthetic(BigDecimal r2_rwa_asinvestor_synthetic) {
		this.r2_rwa_asinvestor_synthetic = r2_rwa_asinvestor_synthetic;
	}
	public BigDecimal getR2_onbalance_notinvestor_synthetic() {
		return r2_onbalance_notinvestor_synthetic;
	}
	public void setR2_onbalance_notinvestor_synthetic(BigDecimal r2_onbalance_notinvestor_synthetic) {
		this.r2_onbalance_notinvestor_synthetic = r2_onbalance_notinvestor_synthetic;
	}
	public BigDecimal getR2_offbalance_notinvestor_synthetic() {
		return r2_offbalance_notinvestor_synthetic;
	}
	public void setR2_offbalance_notinvestor_synthetic(BigDecimal r2_offbalance_notinvestor_synthetic) {
		this.r2_offbalance_notinvestor_synthetic = r2_offbalance_notinvestor_synthetic;
	}
	public BigDecimal getR2_totalexposure_notinvestor_synthetic() {
		return r2_totalexposure_notinvestor_synthetic;
	}
	public void setR2_totalexposure_notinvestor_synthetic(BigDecimal r2_totalexposure_notinvestor_synthetic) {
		this.r2_totalexposure_notinvestor_synthetic = r2_totalexposure_notinvestor_synthetic;
	}
	public BigDecimal getR2_rwa_notinvestor_synthetic() {
		return r2_rwa_notinvestor_synthetic;
	}
	public void setR2_rwa_notinvestor_synthetic(BigDecimal r2_rwa_notinvestor_synthetic) {
		this.r2_rwa_notinvestor_synthetic = r2_rwa_notinvestor_synthetic;
	}
	public BigDecimal getR2_onbalance_asinvestor_total() {
		return r2_onbalance_asinvestor_total;
	}
	public void setR2_onbalance_asinvestor_total(BigDecimal r2_onbalance_asinvestor_total) {
		this.r2_onbalance_asinvestor_total = r2_onbalance_asinvestor_total;
	}
	public BigDecimal getR2_offbalance_asinvestor_total() {
		return r2_offbalance_asinvestor_total;
	}
	public void setR2_offbalance_asinvestor_total(BigDecimal r2_offbalance_asinvestor_total) {
		this.r2_offbalance_asinvestor_total = r2_offbalance_asinvestor_total;
	}
	public BigDecimal getR2_totalexposure_asinvestor_total() {
		return r2_totalexposure_asinvestor_total;
	}
	public void setR2_totalexposure_asinvestor_total(BigDecimal r2_totalexposure_asinvestor_total) {
		this.r2_totalexposure_asinvestor_total = r2_totalexposure_asinvestor_total;
	}
	public BigDecimal getR2_rwa_asinvestor_total() {
		return r2_rwa_asinvestor_total;
	}
	public void setR2_rwa_asinvestor_total(BigDecimal r2_rwa_asinvestor_total) {
		this.r2_rwa_asinvestor_total = r2_rwa_asinvestor_total;
	}
	public BigDecimal getR2_onbalance_notinvestor_total() {
		return r2_onbalance_notinvestor_total;
	}
	public void setR2_onbalance_notinvestor_total(BigDecimal r2_onbalance_notinvestor_total) {
		this.r2_onbalance_notinvestor_total = r2_onbalance_notinvestor_total;
	}
	public BigDecimal getR2_offbalance_notinvestor_total() {
		return r2_offbalance_notinvestor_total;
	}
	public void setR2_offbalance_notinvestor_total(BigDecimal r2_offbalance_notinvestor_total) {
		this.r2_offbalance_notinvestor_total = r2_offbalance_notinvestor_total;
	}
	public BigDecimal getR2_totalexposure_notinvestor_total() {
		return r2_totalexposure_notinvestor_total;
	}
	public void setR2_totalexposure_notinvestor_total(BigDecimal r2_totalexposure_notinvestor_total) {
		this.r2_totalexposure_notinvestor_total = r2_totalexposure_notinvestor_total;
	}
	public BigDecimal getR2_rwa_notinvestor_total() {
		return r2_rwa_notinvestor_total;
	}
	public void setR2_rwa_notinvestor_total(BigDecimal r2_rwa_notinvestor_total) {
		this.r2_rwa_notinvestor_total = r2_rwa_notinvestor_total;
	}
	public BigDecimal getR2_total() {
		return r2_total;
	}
	public void setR2_total(BigDecimal r2_total) {
		this.r2_total = r2_total;
	}
	public String getR3_securitization() {
		return r3_securitization;
	}
	public void setR3_securitization(String r3_securitization) {
		this.r3_securitization = r3_securitization;
	}
	public BigDecimal getR3_onbalance_asinvestor_simple() {
		return r3_onbalance_asinvestor_simple;
	}
	public void setR3_onbalance_asinvestor_simple(BigDecimal r3_onbalance_asinvestor_simple) {
		this.r3_onbalance_asinvestor_simple = r3_onbalance_asinvestor_simple;
	}
	public BigDecimal getR3_offbalance_asinvestor_simple() {
		return r3_offbalance_asinvestor_simple;
	}
	public void setR3_offbalance_asinvestor_simple(BigDecimal r3_offbalance_asinvestor_simple) {
		this.r3_offbalance_asinvestor_simple = r3_offbalance_asinvestor_simple;
	}
	public BigDecimal getR3_totalexposure_asinvestor_simple() {
		return r3_totalexposure_asinvestor_simple;
	}
	public void setR3_totalexposure_asinvestor_simple(BigDecimal r3_totalexposure_asinvestor_simple) {
		this.r3_totalexposure_asinvestor_simple = r3_totalexposure_asinvestor_simple;
	}
	public BigDecimal getR3_rwa_asinvestor_simple() {
		return r3_rwa_asinvestor_simple;
	}
	public void setR3_rwa_asinvestor_simple(BigDecimal r3_rwa_asinvestor_simple) {
		this.r3_rwa_asinvestor_simple = r3_rwa_asinvestor_simple;
	}
	public BigDecimal getR3_onbalance_notinvestor_simple() {
		return r3_onbalance_notinvestor_simple;
	}
	public void setR3_onbalance_notinvestor_simple(BigDecimal r3_onbalance_notinvestor_simple) {
		this.r3_onbalance_notinvestor_simple = r3_onbalance_notinvestor_simple;
	}
	public BigDecimal getR3_offbalance_notinvestor_simple() {
		return r3_offbalance_notinvestor_simple;
	}
	public void setR3_offbalance_notinvestor_simple(BigDecimal r3_offbalance_notinvestor_simple) {
		this.r3_offbalance_notinvestor_simple = r3_offbalance_notinvestor_simple;
	}
	public BigDecimal getR3_totalexposure_notinvestor_simple() {
		return r3_totalexposure_notinvestor_simple;
	}
	public void setR3_totalexposure_notinvestor_simple(BigDecimal r3_totalexposure_notinvestor_simple) {
		this.r3_totalexposure_notinvestor_simple = r3_totalexposure_notinvestor_simple;
	}
	public BigDecimal getR3_rwa_notinvestor_simple() {
		return r3_rwa_notinvestor_simple;
	}
	public void setR3_rwa_notinvestor_simple(BigDecimal r3_rwa_notinvestor_simple) {
		this.r3_rwa_notinvestor_simple = r3_rwa_notinvestor_simple;
	}
	public BigDecimal getR3_onbalance_asinvestor_resecuritization() {
		return r3_onbalance_asinvestor_resecuritization;
	}
	public void setR3_onbalance_asinvestor_resecuritization(BigDecimal r3_onbalance_asinvestor_resecuritization) {
		this.r3_onbalance_asinvestor_resecuritization = r3_onbalance_asinvestor_resecuritization;
	}
	public BigDecimal getR3_offbalance_asinvestor_resecuritization() {
		return r3_offbalance_asinvestor_resecuritization;
	}
	public void setR3_offbalance_asinvestor_resecuritization(BigDecimal r3_offbalance_asinvestor_resecuritization) {
		this.r3_offbalance_asinvestor_resecuritization = r3_offbalance_asinvestor_resecuritization;
	}
	public BigDecimal getR3_totalexposure_asinvestor_resecuritization() {
		return r3_totalexposure_asinvestor_resecuritization;
	}
	public void setR3_totalexposure_asinvestor_resecuritization(
			BigDecimal r3_totalexposure_asinvestor_resecuritization) {
		this.r3_totalexposure_asinvestor_resecuritization = r3_totalexposure_asinvestor_resecuritization;
	}
	public BigDecimal getR3_rwa_asinvestor_resecuritization() {
		return r3_rwa_asinvestor_resecuritization;
	}
	public void setR3_rwa_asinvestor_resecuritization(BigDecimal r3_rwa_asinvestor_resecuritization) {
		this.r3_rwa_asinvestor_resecuritization = r3_rwa_asinvestor_resecuritization;
	}
	public BigDecimal getR3_onbalance_notinvestor_resecuritization() {
		return r3_onbalance_notinvestor_resecuritization;
	}
	public void setR3_onbalance_notinvestor_resecuritization(BigDecimal r3_onbalance_notinvestor_resecuritization) {
		this.r3_onbalance_notinvestor_resecuritization = r3_onbalance_notinvestor_resecuritization;
	}
	public BigDecimal getR3_offbalance_notinvestor_resecuritization() {
		return r3_offbalance_notinvestor_resecuritization;
	}
	public void setR3_offbalance_notinvestor_resecuritization(BigDecimal r3_offbalance_notinvestor_resecuritization) {
		this.r3_offbalance_notinvestor_resecuritization = r3_offbalance_notinvestor_resecuritization;
	}
	public BigDecimal getR3_totalexposure_notinvestor_resecuritization() {
		return r3_totalexposure_notinvestor_resecuritization;
	}
	public void setR3_totalexposure_notinvestor_resecuritization(
			BigDecimal r3_totalexposure_notinvestor_resecuritization) {
		this.r3_totalexposure_notinvestor_resecuritization = r3_totalexposure_notinvestor_resecuritization;
	}
	public BigDecimal getR3_rwa_notinvestor_resecuritization() {
		return r3_rwa_notinvestor_resecuritization;
	}
	public void setR3_rwa_notinvestor_resecuritization(BigDecimal r3_rwa_notinvestor_resecuritization) {
		this.r3_rwa_notinvestor_resecuritization = r3_rwa_notinvestor_resecuritization;
	}
	public BigDecimal getR3_onbalance_asinvestor_traditional() {
		return r3_onbalance_asinvestor_traditional;
	}
	public void setR3_onbalance_asinvestor_traditional(BigDecimal r3_onbalance_asinvestor_traditional) {
		this.r3_onbalance_asinvestor_traditional = r3_onbalance_asinvestor_traditional;
	}
	public BigDecimal getR3_offbalance_asinvestor_traditional() {
		return r3_offbalance_asinvestor_traditional;
	}
	public void setR3_offbalance_asinvestor_traditional(BigDecimal r3_offbalance_asinvestor_traditional) {
		this.r3_offbalance_asinvestor_traditional = r3_offbalance_asinvestor_traditional;
	}
	public BigDecimal getR3_totalexposure_asinvestor_traditional() {
		return r3_totalexposure_asinvestor_traditional;
	}
	public void setR3_totalexposure_asinvestor_traditional(BigDecimal r3_totalexposure_asinvestor_traditional) {
		this.r3_totalexposure_asinvestor_traditional = r3_totalexposure_asinvestor_traditional;
	}
	public BigDecimal getR3_rwa_asinvestor_traditional() {
		return r3_rwa_asinvestor_traditional;
	}
	public void setR3_rwa_asinvestor_traditional(BigDecimal r3_rwa_asinvestor_traditional) {
		this.r3_rwa_asinvestor_traditional = r3_rwa_asinvestor_traditional;
	}
	public BigDecimal getR3_onbalance_notinvestor_traditional() {
		return r3_onbalance_notinvestor_traditional;
	}
	public void setR3_onbalance_notinvestor_traditional(BigDecimal r3_onbalance_notinvestor_traditional) {
		this.r3_onbalance_notinvestor_traditional = r3_onbalance_notinvestor_traditional;
	}
	public BigDecimal getR3_offbalance_notinvestor_traditional() {
		return r3_offbalance_notinvestor_traditional;
	}
	public void setR3_offbalance_notinvestor_traditional(BigDecimal r3_offbalance_notinvestor_traditional) {
		this.r3_offbalance_notinvestor_traditional = r3_offbalance_notinvestor_traditional;
	}
	public BigDecimal getR3_totalexposure_notinvestor_traditional() {
		return r3_totalexposure_notinvestor_traditional;
	}
	public void setR3_totalexposure_notinvestor_traditional(BigDecimal r3_totalexposure_notinvestor_traditional) {
		this.r3_totalexposure_notinvestor_traditional = r3_totalexposure_notinvestor_traditional;
	}
	public BigDecimal getR3_rwa_notinvestor_traditional() {
		return r3_rwa_notinvestor_traditional;
	}
	public void setR3_rwa_notinvestor_traditional(BigDecimal r3_rwa_notinvestor_traditional) {
		this.r3_rwa_notinvestor_traditional = r3_rwa_notinvestor_traditional;
	}
	public BigDecimal getR3_onbalance_asinvestor_synthetic() {
		return r3_onbalance_asinvestor_synthetic;
	}
	public void setR3_onbalance_asinvestor_synthetic(BigDecimal r3_onbalance_asinvestor_synthetic) {
		this.r3_onbalance_asinvestor_synthetic = r3_onbalance_asinvestor_synthetic;
	}
	public BigDecimal getR3_offbalance_asinvestor_synthetic() {
		return r3_offbalance_asinvestor_synthetic;
	}
	public void setR3_offbalance_asinvestor_synthetic(BigDecimal r3_offbalance_asinvestor_synthetic) {
		this.r3_offbalance_asinvestor_synthetic = r3_offbalance_asinvestor_synthetic;
	}
	public BigDecimal getR3_totalexposure_asinvestor_synthetic() {
		return r3_totalexposure_asinvestor_synthetic;
	}
	public void setR3_totalexposure_asinvestor_synthetic(BigDecimal r3_totalexposure_asinvestor_synthetic) {
		this.r3_totalexposure_asinvestor_synthetic = r3_totalexposure_asinvestor_synthetic;
	}
	public BigDecimal getR3_rwa_asinvestor_synthetic() {
		return r3_rwa_asinvestor_synthetic;
	}
	public void setR3_rwa_asinvestor_synthetic(BigDecimal r3_rwa_asinvestor_synthetic) {
		this.r3_rwa_asinvestor_synthetic = r3_rwa_asinvestor_synthetic;
	}
	public BigDecimal getR3_onbalance_notinvestor_synthetic() {
		return r3_onbalance_notinvestor_synthetic;
	}
	public void setR3_onbalance_notinvestor_synthetic(BigDecimal r3_onbalance_notinvestor_synthetic) {
		this.r3_onbalance_notinvestor_synthetic = r3_onbalance_notinvestor_synthetic;
	}
	public BigDecimal getR3_offbalance_notinvestor_synthetic() {
		return r3_offbalance_notinvestor_synthetic;
	}
	public void setR3_offbalance_notinvestor_synthetic(BigDecimal r3_offbalance_notinvestor_synthetic) {
		this.r3_offbalance_notinvestor_synthetic = r3_offbalance_notinvestor_synthetic;
	}
	public BigDecimal getR3_totalexposure_notinvestor_synthetic() {
		return r3_totalexposure_notinvestor_synthetic;
	}
	public void setR3_totalexposure_notinvestor_synthetic(BigDecimal r3_totalexposure_notinvestor_synthetic) {
		this.r3_totalexposure_notinvestor_synthetic = r3_totalexposure_notinvestor_synthetic;
	}
	public BigDecimal getR3_rwa_notinvestor_synthetic() {
		return r3_rwa_notinvestor_synthetic;
	}
	public void setR3_rwa_notinvestor_synthetic(BigDecimal r3_rwa_notinvestor_synthetic) {
		this.r3_rwa_notinvestor_synthetic = r3_rwa_notinvestor_synthetic;
	}
	public BigDecimal getR3_onbalance_asinvestor_total() {
		return r3_onbalance_asinvestor_total;
	}
	public void setR3_onbalance_asinvestor_total(BigDecimal r3_onbalance_asinvestor_total) {
		this.r3_onbalance_asinvestor_total = r3_onbalance_asinvestor_total;
	}
	public BigDecimal getR3_offbalance_asinvestor_total() {
		return r3_offbalance_asinvestor_total;
	}
	public void setR3_offbalance_asinvestor_total(BigDecimal r3_offbalance_asinvestor_total) {
		this.r3_offbalance_asinvestor_total = r3_offbalance_asinvestor_total;
	}
	public BigDecimal getR3_totalexposure_asinvestor_total() {
		return r3_totalexposure_asinvestor_total;
	}
	public void setR3_totalexposure_asinvestor_total(BigDecimal r3_totalexposure_asinvestor_total) {
		this.r3_totalexposure_asinvestor_total = r3_totalexposure_asinvestor_total;
	}
	public BigDecimal getR3_rwa_asinvestor_total() {
		return r3_rwa_asinvestor_total;
	}
	public void setR3_rwa_asinvestor_total(BigDecimal r3_rwa_asinvestor_total) {
		this.r3_rwa_asinvestor_total = r3_rwa_asinvestor_total;
	}
	public BigDecimal getR3_onbalance_notinvestor_total() {
		return r3_onbalance_notinvestor_total;
	}
	public void setR3_onbalance_notinvestor_total(BigDecimal r3_onbalance_notinvestor_total) {
		this.r3_onbalance_notinvestor_total = r3_onbalance_notinvestor_total;
	}
	public BigDecimal getR3_offbalance_notinvestor_total() {
		return r3_offbalance_notinvestor_total;
	}
	public void setR3_offbalance_notinvestor_total(BigDecimal r3_offbalance_notinvestor_total) {
		this.r3_offbalance_notinvestor_total = r3_offbalance_notinvestor_total;
	}
	public BigDecimal getR3_totalexposure_notinvestor_total() {
		return r3_totalexposure_notinvestor_total;
	}
	public void setR3_totalexposure_notinvestor_total(BigDecimal r3_totalexposure_notinvestor_total) {
		this.r3_totalexposure_notinvestor_total = r3_totalexposure_notinvestor_total;
	}
	public BigDecimal getR3_rwa_notinvestor_total() {
		return r3_rwa_notinvestor_total;
	}
	public void setR3_rwa_notinvestor_total(BigDecimal r3_rwa_notinvestor_total) {
		this.r3_rwa_notinvestor_total = r3_rwa_notinvestor_total;
	}
	public BigDecimal getR3_total() {
		return r3_total;
	}
	public void setR3_total(BigDecimal r3_total) {
		this.r3_total = r3_total;
	}
	public String getR4_securitization() {
		return r4_securitization;
	}
	public void setR4_securitization(String r4_securitization) {
		this.r4_securitization = r4_securitization;
	}
	public BigDecimal getR4_onbalance_asinvestor_simple() {
		return r4_onbalance_asinvestor_simple;
	}
	public void setR4_onbalance_asinvestor_simple(BigDecimal r4_onbalance_asinvestor_simple) {
		this.r4_onbalance_asinvestor_simple = r4_onbalance_asinvestor_simple;
	}
	public BigDecimal getR4_offbalance_asinvestor_simple() {
		return r4_offbalance_asinvestor_simple;
	}
	public void setR4_offbalance_asinvestor_simple(BigDecimal r4_offbalance_asinvestor_simple) {
		this.r4_offbalance_asinvestor_simple = r4_offbalance_asinvestor_simple;
	}
	public BigDecimal getR4_totalexposure_asinvestor_simple() {
		return r4_totalexposure_asinvestor_simple;
	}
	public void setR4_totalexposure_asinvestor_simple(BigDecimal r4_totalexposure_asinvestor_simple) {
		this.r4_totalexposure_asinvestor_simple = r4_totalexposure_asinvestor_simple;
	}
	public BigDecimal getR4_rwa_asinvestor_simple() {
		return r4_rwa_asinvestor_simple;
	}
	public void setR4_rwa_asinvestor_simple(BigDecimal r4_rwa_asinvestor_simple) {
		this.r4_rwa_asinvestor_simple = r4_rwa_asinvestor_simple;
	}
	public BigDecimal getR4_onbalance_notinvestor_simple() {
		return r4_onbalance_notinvestor_simple;
	}
	public void setR4_onbalance_notinvestor_simple(BigDecimal r4_onbalance_notinvestor_simple) {
		this.r4_onbalance_notinvestor_simple = r4_onbalance_notinvestor_simple;
	}
	public BigDecimal getR4_offbalance_notinvestor_simple() {
		return r4_offbalance_notinvestor_simple;
	}
	public void setR4_offbalance_notinvestor_simple(BigDecimal r4_offbalance_notinvestor_simple) {
		this.r4_offbalance_notinvestor_simple = r4_offbalance_notinvestor_simple;
	}
	public BigDecimal getR4_totalexposure_notinvestor_simple() {
		return r4_totalexposure_notinvestor_simple;
	}
	public void setR4_totalexposure_notinvestor_simple(BigDecimal r4_totalexposure_notinvestor_simple) {
		this.r4_totalexposure_notinvestor_simple = r4_totalexposure_notinvestor_simple;
	}
	public BigDecimal getR4_rwa_notinvestor_simple() {
		return r4_rwa_notinvestor_simple;
	}
	public void setR4_rwa_notinvestor_simple(BigDecimal r4_rwa_notinvestor_simple) {
		this.r4_rwa_notinvestor_simple = r4_rwa_notinvestor_simple;
	}
	public BigDecimal getR4_onbalance_asinvestor_resecuritization() {
		return r4_onbalance_asinvestor_resecuritization;
	}
	public void setR4_onbalance_asinvestor_resecuritization(BigDecimal r4_onbalance_asinvestor_resecuritization) {
		this.r4_onbalance_asinvestor_resecuritization = r4_onbalance_asinvestor_resecuritization;
	}
	public BigDecimal getR4_offbalance_asinvestor_resecuritization() {
		return r4_offbalance_asinvestor_resecuritization;
	}
	public void setR4_offbalance_asinvestor_resecuritization(BigDecimal r4_offbalance_asinvestor_resecuritization) {
		this.r4_offbalance_asinvestor_resecuritization = r4_offbalance_asinvestor_resecuritization;
	}
	public BigDecimal getR4_totalexposure_asinvestor_resecuritization() {
		return r4_totalexposure_asinvestor_resecuritization;
	}
	public void setR4_totalexposure_asinvestor_resecuritization(
			BigDecimal r4_totalexposure_asinvestor_resecuritization) {
		this.r4_totalexposure_asinvestor_resecuritization = r4_totalexposure_asinvestor_resecuritization;
	}
	public BigDecimal getR4_rwa_asinvestor_resecuritization() {
		return r4_rwa_asinvestor_resecuritization;
	}
	public void setR4_rwa_asinvestor_resecuritization(BigDecimal r4_rwa_asinvestor_resecuritization) {
		this.r4_rwa_asinvestor_resecuritization = r4_rwa_asinvestor_resecuritization;
	}
	public BigDecimal getR4_onbalance_notinvestor_resecuritization() {
		return r4_onbalance_notinvestor_resecuritization;
	}
	public void setR4_onbalance_notinvestor_resecuritization(BigDecimal r4_onbalance_notinvestor_resecuritization) {
		this.r4_onbalance_notinvestor_resecuritization = r4_onbalance_notinvestor_resecuritization;
	}
	public BigDecimal getR4_offbalance_notinvestor_resecuritization() {
		return r4_offbalance_notinvestor_resecuritization;
	}
	public void setR4_offbalance_notinvestor_resecuritization(BigDecimal r4_offbalance_notinvestor_resecuritization) {
		this.r4_offbalance_notinvestor_resecuritization = r4_offbalance_notinvestor_resecuritization;
	}
	public BigDecimal getR4_totalexposure_notinvestor_resecuritization() {
		return r4_totalexposure_notinvestor_resecuritization;
	}
	public void setR4_totalexposure_notinvestor_resecuritization(
			BigDecimal r4_totalexposure_notinvestor_resecuritization) {
		this.r4_totalexposure_notinvestor_resecuritization = r4_totalexposure_notinvestor_resecuritization;
	}
	public BigDecimal getR4_rwa_notinvestor_resecuritization() {
		return r4_rwa_notinvestor_resecuritization;
	}
	public void setR4_rwa_notinvestor_resecuritization(BigDecimal r4_rwa_notinvestor_resecuritization) {
		this.r4_rwa_notinvestor_resecuritization = r4_rwa_notinvestor_resecuritization;
	}
	public BigDecimal getR4_onbalance_asinvestor_traditional() {
		return r4_onbalance_asinvestor_traditional;
	}
	public void setR4_onbalance_asinvestor_traditional(BigDecimal r4_onbalance_asinvestor_traditional) {
		this.r4_onbalance_asinvestor_traditional = r4_onbalance_asinvestor_traditional;
	}
	public BigDecimal getR4_offbalance_asinvestor_traditional() {
		return r4_offbalance_asinvestor_traditional;
	}
	public void setR4_offbalance_asinvestor_traditional(BigDecimal r4_offbalance_asinvestor_traditional) {
		this.r4_offbalance_asinvestor_traditional = r4_offbalance_asinvestor_traditional;
	}
	public BigDecimal getR4_totalexposure_asinvestor_traditional() {
		return r4_totalexposure_asinvestor_traditional;
	}
	public void setR4_totalexposure_asinvestor_traditional(BigDecimal r4_totalexposure_asinvestor_traditional) {
		this.r4_totalexposure_asinvestor_traditional = r4_totalexposure_asinvestor_traditional;
	}
	public BigDecimal getR4_rwa_asinvestor_traditional() {
		return r4_rwa_asinvestor_traditional;
	}
	public void setR4_rwa_asinvestor_traditional(BigDecimal r4_rwa_asinvestor_traditional) {
		this.r4_rwa_asinvestor_traditional = r4_rwa_asinvestor_traditional;
	}
	public BigDecimal getR4_onbalance_notinvestor_traditional() {
		return r4_onbalance_notinvestor_traditional;
	}
	public void setR4_onbalance_notinvestor_traditional(BigDecimal r4_onbalance_notinvestor_traditional) {
		this.r4_onbalance_notinvestor_traditional = r4_onbalance_notinvestor_traditional;
	}
	public BigDecimal getR4_offbalance_notinvestor_traditional() {
		return r4_offbalance_notinvestor_traditional;
	}
	public void setR4_offbalance_notinvestor_traditional(BigDecimal r4_offbalance_notinvestor_traditional) {
		this.r4_offbalance_notinvestor_traditional = r4_offbalance_notinvestor_traditional;
	}
	public BigDecimal getR4_totalexposure_notinvestor_traditional() {
		return r4_totalexposure_notinvestor_traditional;
	}
	public void setR4_totalexposure_notinvestor_traditional(BigDecimal r4_totalexposure_notinvestor_traditional) {
		this.r4_totalexposure_notinvestor_traditional = r4_totalexposure_notinvestor_traditional;
	}
	public BigDecimal getR4_rwa_notinvestor_traditional() {
		return r4_rwa_notinvestor_traditional;
	}
	public void setR4_rwa_notinvestor_traditional(BigDecimal r4_rwa_notinvestor_traditional) {
		this.r4_rwa_notinvestor_traditional = r4_rwa_notinvestor_traditional;
	}
	public BigDecimal getR4_onbalance_asinvestor_synthetic() {
		return r4_onbalance_asinvestor_synthetic;
	}
	public void setR4_onbalance_asinvestor_synthetic(BigDecimal r4_onbalance_asinvestor_synthetic) {
		this.r4_onbalance_asinvestor_synthetic = r4_onbalance_asinvestor_synthetic;
	}
	public BigDecimal getR4_offbalance_asinvestor_synthetic() {
		return r4_offbalance_asinvestor_synthetic;
	}
	public void setR4_offbalance_asinvestor_synthetic(BigDecimal r4_offbalance_asinvestor_synthetic) {
		this.r4_offbalance_asinvestor_synthetic = r4_offbalance_asinvestor_synthetic;
	}
	public BigDecimal getR4_totalexposure_asinvestor_synthetic() {
		return r4_totalexposure_asinvestor_synthetic;
	}
	public void setR4_totalexposure_asinvestor_synthetic(BigDecimal r4_totalexposure_asinvestor_synthetic) {
		this.r4_totalexposure_asinvestor_synthetic = r4_totalexposure_asinvestor_synthetic;
	}
	public BigDecimal getR4_rwa_asinvestor_synthetic() {
		return r4_rwa_asinvestor_synthetic;
	}
	public void setR4_rwa_asinvestor_synthetic(BigDecimal r4_rwa_asinvestor_synthetic) {
		this.r4_rwa_asinvestor_synthetic = r4_rwa_asinvestor_synthetic;
	}
	public BigDecimal getR4_onbalance_notinvestor_synthetic() {
		return r4_onbalance_notinvestor_synthetic;
	}
	public void setR4_onbalance_notinvestor_synthetic(BigDecimal r4_onbalance_notinvestor_synthetic) {
		this.r4_onbalance_notinvestor_synthetic = r4_onbalance_notinvestor_synthetic;
	}
	public BigDecimal getR4_offbalance_notinvestor_synthetic() {
		return r4_offbalance_notinvestor_synthetic;
	}
	public void setR4_offbalance_notinvestor_synthetic(BigDecimal r4_offbalance_notinvestor_synthetic) {
		this.r4_offbalance_notinvestor_synthetic = r4_offbalance_notinvestor_synthetic;
	}
	public BigDecimal getR4_totalexposure_notinvestor_synthetic() {
		return r4_totalexposure_notinvestor_synthetic;
	}
	public void setR4_totalexposure_notinvestor_synthetic(BigDecimal r4_totalexposure_notinvestor_synthetic) {
		this.r4_totalexposure_notinvestor_synthetic = r4_totalexposure_notinvestor_synthetic;
	}
	public BigDecimal getR4_rwa_notinvestor_synthetic() {
		return r4_rwa_notinvestor_synthetic;
	}
	public void setR4_rwa_notinvestor_synthetic(BigDecimal r4_rwa_notinvestor_synthetic) {
		this.r4_rwa_notinvestor_synthetic = r4_rwa_notinvestor_synthetic;
	}
	public BigDecimal getR4_onbalance_asinvestor_total() {
		return r4_onbalance_asinvestor_total;
	}
	public void setR4_onbalance_asinvestor_total(BigDecimal r4_onbalance_asinvestor_total) {
		this.r4_onbalance_asinvestor_total = r4_onbalance_asinvestor_total;
	}
	public BigDecimal getR4_offbalance_asinvestor_total() {
		return r4_offbalance_asinvestor_total;
	}
	public void setR4_offbalance_asinvestor_total(BigDecimal r4_offbalance_asinvestor_total) {
		this.r4_offbalance_asinvestor_total = r4_offbalance_asinvestor_total;
	}
	public BigDecimal getR4_totalexposure_asinvestor_total() {
		return r4_totalexposure_asinvestor_total;
	}
	public void setR4_totalexposure_asinvestor_total(BigDecimal r4_totalexposure_asinvestor_total) {
		this.r4_totalexposure_asinvestor_total = r4_totalexposure_asinvestor_total;
	}
	public BigDecimal getR4_rwa_asinvestor_total() {
		return r4_rwa_asinvestor_total;
	}
	public void setR4_rwa_asinvestor_total(BigDecimal r4_rwa_asinvestor_total) {
		this.r4_rwa_asinvestor_total = r4_rwa_asinvestor_total;
	}
	public BigDecimal getR4_onbalance_notinvestor_total() {
		return r4_onbalance_notinvestor_total;
	}
	public void setR4_onbalance_notinvestor_total(BigDecimal r4_onbalance_notinvestor_total) {
		this.r4_onbalance_notinvestor_total = r4_onbalance_notinvestor_total;
	}
	public BigDecimal getR4_offbalance_notinvestor_total() {
		return r4_offbalance_notinvestor_total;
	}
	public void setR4_offbalance_notinvestor_total(BigDecimal r4_offbalance_notinvestor_total) {
		this.r4_offbalance_notinvestor_total = r4_offbalance_notinvestor_total;
	}
	public BigDecimal getR4_totalexposure_notinvestor_total() {
		return r4_totalexposure_notinvestor_total;
	}
	public void setR4_totalexposure_notinvestor_total(BigDecimal r4_totalexposure_notinvestor_total) {
		this.r4_totalexposure_notinvestor_total = r4_totalexposure_notinvestor_total;
	}
	public BigDecimal getR4_rwa_notinvestor_total() {
		return r4_rwa_notinvestor_total;
	}
	public void setR4_rwa_notinvestor_total(BigDecimal r4_rwa_notinvestor_total) {
		this.r4_rwa_notinvestor_total = r4_rwa_notinvestor_total;
	}
	public BigDecimal getR4_total() {
		return r4_total;
	}
	public void setR4_total(BigDecimal r4_total) {
		this.r4_total = r4_total;
	}
	public String getR5_securitization() {
		return r5_securitization;
	}
	public void setR5_securitization(String r5_securitization) {
		this.r5_securitization = r5_securitization;
	}
	public BigDecimal getR5_onbalance_asinvestor_simple() {
		return r5_onbalance_asinvestor_simple;
	}
	public void setR5_onbalance_asinvestor_simple(BigDecimal r5_onbalance_asinvestor_simple) {
		this.r5_onbalance_asinvestor_simple = r5_onbalance_asinvestor_simple;
	}
	public BigDecimal getR5_offbalance_asinvestor_simple() {
		return r5_offbalance_asinvestor_simple;
	}
	public void setR5_offbalance_asinvestor_simple(BigDecimal r5_offbalance_asinvestor_simple) {
		this.r5_offbalance_asinvestor_simple = r5_offbalance_asinvestor_simple;
	}
	public BigDecimal getR5_totalexposure_asinvestor_simple() {
		return r5_totalexposure_asinvestor_simple;
	}
	public void setR5_totalexposure_asinvestor_simple(BigDecimal r5_totalexposure_asinvestor_simple) {
		this.r5_totalexposure_asinvestor_simple = r5_totalexposure_asinvestor_simple;
	}
	public BigDecimal getR5_rwa_asinvestor_simple() {
		return r5_rwa_asinvestor_simple;
	}
	public void setR5_rwa_asinvestor_simple(BigDecimal r5_rwa_asinvestor_simple) {
		this.r5_rwa_asinvestor_simple = r5_rwa_asinvestor_simple;
	}
	public BigDecimal getR5_onbalance_notinvestor_simple() {
		return r5_onbalance_notinvestor_simple;
	}
	public void setR5_onbalance_notinvestor_simple(BigDecimal r5_onbalance_notinvestor_simple) {
		this.r5_onbalance_notinvestor_simple = r5_onbalance_notinvestor_simple;
	}
	public BigDecimal getR5_offbalance_notinvestor_simple() {
		return r5_offbalance_notinvestor_simple;
	}
	public void setR5_offbalance_notinvestor_simple(BigDecimal r5_offbalance_notinvestor_simple) {
		this.r5_offbalance_notinvestor_simple = r5_offbalance_notinvestor_simple;
	}
	public BigDecimal getR5_totalexposure_notinvestor_simple() {
		return r5_totalexposure_notinvestor_simple;
	}
	public void setR5_totalexposure_notinvestor_simple(BigDecimal r5_totalexposure_notinvestor_simple) {
		this.r5_totalexposure_notinvestor_simple = r5_totalexposure_notinvestor_simple;
	}
	public BigDecimal getR5_rwa_notinvestor_simple() {
		return r5_rwa_notinvestor_simple;
	}
	public void setR5_rwa_notinvestor_simple(BigDecimal r5_rwa_notinvestor_simple) {
		this.r5_rwa_notinvestor_simple = r5_rwa_notinvestor_simple;
	}
	public BigDecimal getR5_onbalance_asinvestor_resecuritization() {
		return r5_onbalance_asinvestor_resecuritization;
	}
	public void setR5_onbalance_asinvestor_resecuritization(BigDecimal r5_onbalance_asinvestor_resecuritization) {
		this.r5_onbalance_asinvestor_resecuritization = r5_onbalance_asinvestor_resecuritization;
	}
	public BigDecimal getR5_offbalance_asinvestor_resecuritization() {
		return r5_offbalance_asinvestor_resecuritization;
	}
	public void setR5_offbalance_asinvestor_resecuritization(BigDecimal r5_offbalance_asinvestor_resecuritization) {
		this.r5_offbalance_asinvestor_resecuritization = r5_offbalance_asinvestor_resecuritization;
	}
	public BigDecimal getR5_totalexposure_asinvestor_resecuritization() {
		return r5_totalexposure_asinvestor_resecuritization;
	}
	public void setR5_totalexposure_asinvestor_resecuritization(
			BigDecimal r5_totalexposure_asinvestor_resecuritization) {
		this.r5_totalexposure_asinvestor_resecuritization = r5_totalexposure_asinvestor_resecuritization;
	}
	public BigDecimal getR5_rwa_asinvestor_resecuritization() {
		return r5_rwa_asinvestor_resecuritization;
	}
	public void setR5_rwa_asinvestor_resecuritization(BigDecimal r5_rwa_asinvestor_resecuritization) {
		this.r5_rwa_asinvestor_resecuritization = r5_rwa_asinvestor_resecuritization;
	}
	public BigDecimal getR5_onbalance_notinvestor_resecuritization() {
		return r5_onbalance_notinvestor_resecuritization;
	}
	public void setR5_onbalance_notinvestor_resecuritization(BigDecimal r5_onbalance_notinvestor_resecuritization) {
		this.r5_onbalance_notinvestor_resecuritization = r5_onbalance_notinvestor_resecuritization;
	}
	public BigDecimal getR5_offbalance_notinvestor_resecuritization() {
		return r5_offbalance_notinvestor_resecuritization;
	}
	public void setR5_offbalance_notinvestor_resecuritization(BigDecimal r5_offbalance_notinvestor_resecuritization) {
		this.r5_offbalance_notinvestor_resecuritization = r5_offbalance_notinvestor_resecuritization;
	}
	public BigDecimal getR5_totalexposure_notinvestor_resecuritization() {
		return r5_totalexposure_notinvestor_resecuritization;
	}
	public void setR5_totalexposure_notinvestor_resecuritization(
			BigDecimal r5_totalexposure_notinvestor_resecuritization) {
		this.r5_totalexposure_notinvestor_resecuritization = r5_totalexposure_notinvestor_resecuritization;
	}
	public BigDecimal getR5_rwa_notinvestor_resecuritization() {
		return r5_rwa_notinvestor_resecuritization;
	}
	public void setR5_rwa_notinvestor_resecuritization(BigDecimal r5_rwa_notinvestor_resecuritization) {
		this.r5_rwa_notinvestor_resecuritization = r5_rwa_notinvestor_resecuritization;
	}
	public BigDecimal getR5_onbalance_asinvestor_traditional() {
		return r5_onbalance_asinvestor_traditional;
	}
	public void setR5_onbalance_asinvestor_traditional(BigDecimal r5_onbalance_asinvestor_traditional) {
		this.r5_onbalance_asinvestor_traditional = r5_onbalance_asinvestor_traditional;
	}
	public BigDecimal getR5_offbalance_asinvestor_traditional() {
		return r5_offbalance_asinvestor_traditional;
	}
	public void setR5_offbalance_asinvestor_traditional(BigDecimal r5_offbalance_asinvestor_traditional) {
		this.r5_offbalance_asinvestor_traditional = r5_offbalance_asinvestor_traditional;
	}
	public BigDecimal getR5_totalexposure_asinvestor_traditional() {
		return r5_totalexposure_asinvestor_traditional;
	}
	public void setR5_totalexposure_asinvestor_traditional(BigDecimal r5_totalexposure_asinvestor_traditional) {
		this.r5_totalexposure_asinvestor_traditional = r5_totalexposure_asinvestor_traditional;
	}
	public BigDecimal getR5_rwa_asinvestor_traditional() {
		return r5_rwa_asinvestor_traditional;
	}
	public void setR5_rwa_asinvestor_traditional(BigDecimal r5_rwa_asinvestor_traditional) {
		this.r5_rwa_asinvestor_traditional = r5_rwa_asinvestor_traditional;
	}
	public BigDecimal getR5_onbalance_notinvestor_traditional() {
		return r5_onbalance_notinvestor_traditional;
	}
	public void setR5_onbalance_notinvestor_traditional(BigDecimal r5_onbalance_notinvestor_traditional) {
		this.r5_onbalance_notinvestor_traditional = r5_onbalance_notinvestor_traditional;
	}
	public BigDecimal getR5_offbalance_notinvestor_traditional() {
		return r5_offbalance_notinvestor_traditional;
	}
	public void setR5_offbalance_notinvestor_traditional(BigDecimal r5_offbalance_notinvestor_traditional) {
		this.r5_offbalance_notinvestor_traditional = r5_offbalance_notinvestor_traditional;
	}
	public BigDecimal getR5_totalexposure_notinvestor_traditional() {
		return r5_totalexposure_notinvestor_traditional;
	}
	public void setR5_totalexposure_notinvestor_traditional(BigDecimal r5_totalexposure_notinvestor_traditional) {
		this.r5_totalexposure_notinvestor_traditional = r5_totalexposure_notinvestor_traditional;
	}
	public BigDecimal getR5_rwa_notinvestor_traditional() {
		return r5_rwa_notinvestor_traditional;
	}
	public void setR5_rwa_notinvestor_traditional(BigDecimal r5_rwa_notinvestor_traditional) {
		this.r5_rwa_notinvestor_traditional = r5_rwa_notinvestor_traditional;
	}
	public BigDecimal getR5_onbalance_asinvestor_synthetic() {
		return r5_onbalance_asinvestor_synthetic;
	}
	public void setR5_onbalance_asinvestor_synthetic(BigDecimal r5_onbalance_asinvestor_synthetic) {
		this.r5_onbalance_asinvestor_synthetic = r5_onbalance_asinvestor_synthetic;
	}
	public BigDecimal getR5_offbalance_asinvestor_synthetic() {
		return r5_offbalance_asinvestor_synthetic;
	}
	public void setR5_offbalance_asinvestor_synthetic(BigDecimal r5_offbalance_asinvestor_synthetic) {
		this.r5_offbalance_asinvestor_synthetic = r5_offbalance_asinvestor_synthetic;
	}
	public BigDecimal getR5_totalexposure_asinvestor_synthetic() {
		return r5_totalexposure_asinvestor_synthetic;
	}
	public void setR5_totalexposure_asinvestor_synthetic(BigDecimal r5_totalexposure_asinvestor_synthetic) {
		this.r5_totalexposure_asinvestor_synthetic = r5_totalexposure_asinvestor_synthetic;
	}
	public BigDecimal getR5_rwa_asinvestor_synthetic() {
		return r5_rwa_asinvestor_synthetic;
	}
	public void setR5_rwa_asinvestor_synthetic(BigDecimal r5_rwa_asinvestor_synthetic) {
		this.r5_rwa_asinvestor_synthetic = r5_rwa_asinvestor_synthetic;
	}
	public BigDecimal getR5_onbalance_notinvestor_synthetic() {
		return r5_onbalance_notinvestor_synthetic;
	}
	public void setR5_onbalance_notinvestor_synthetic(BigDecimal r5_onbalance_notinvestor_synthetic) {
		this.r5_onbalance_notinvestor_synthetic = r5_onbalance_notinvestor_synthetic;
	}
	public BigDecimal getR5_offbalance_notinvestor_synthetic() {
		return r5_offbalance_notinvestor_synthetic;
	}
	public void setR5_offbalance_notinvestor_synthetic(BigDecimal r5_offbalance_notinvestor_synthetic) {
		this.r5_offbalance_notinvestor_synthetic = r5_offbalance_notinvestor_synthetic;
	}
	public BigDecimal getR5_totalexposure_notinvestor_synthetic() {
		return r5_totalexposure_notinvestor_synthetic;
	}
	public void setR5_totalexposure_notinvestor_synthetic(BigDecimal r5_totalexposure_notinvestor_synthetic) {
		this.r5_totalexposure_notinvestor_synthetic = r5_totalexposure_notinvestor_synthetic;
	}
	public BigDecimal getR5_rwa_notinvestor_synthetic() {
		return r5_rwa_notinvestor_synthetic;
	}
	public void setR5_rwa_notinvestor_synthetic(BigDecimal r5_rwa_notinvestor_synthetic) {
		this.r5_rwa_notinvestor_synthetic = r5_rwa_notinvestor_synthetic;
	}
	public BigDecimal getR5_onbalance_asinvestor_total() {
		return r5_onbalance_asinvestor_total;
	}
	public void setR5_onbalance_asinvestor_total(BigDecimal r5_onbalance_asinvestor_total) {
		this.r5_onbalance_asinvestor_total = r5_onbalance_asinvestor_total;
	}
	public BigDecimal getR5_offbalance_asinvestor_total() {
		return r5_offbalance_asinvestor_total;
	}
	public void setR5_offbalance_asinvestor_total(BigDecimal r5_offbalance_asinvestor_total) {
		this.r5_offbalance_asinvestor_total = r5_offbalance_asinvestor_total;
	}
	public BigDecimal getR5_totalexposure_asinvestor_total() {
		return r5_totalexposure_asinvestor_total;
	}
	public void setR5_totalexposure_asinvestor_total(BigDecimal r5_totalexposure_asinvestor_total) {
		this.r5_totalexposure_asinvestor_total = r5_totalexposure_asinvestor_total;
	}
	public BigDecimal getR5_rwa_asinvestor_total() {
		return r5_rwa_asinvestor_total;
	}
	public void setR5_rwa_asinvestor_total(BigDecimal r5_rwa_asinvestor_total) {
		this.r5_rwa_asinvestor_total = r5_rwa_asinvestor_total;
	}
	public BigDecimal getR5_onbalance_notinvestor_total() {
		return r5_onbalance_notinvestor_total;
	}
	public void setR5_onbalance_notinvestor_total(BigDecimal r5_onbalance_notinvestor_total) {
		this.r5_onbalance_notinvestor_total = r5_onbalance_notinvestor_total;
	}
	public BigDecimal getR5_offbalance_notinvestor_total() {
		return r5_offbalance_notinvestor_total;
	}
	public void setR5_offbalance_notinvestor_total(BigDecimal r5_offbalance_notinvestor_total) {
		this.r5_offbalance_notinvestor_total = r5_offbalance_notinvestor_total;
	}
	public BigDecimal getR5_totalexposure_notinvestor_total() {
		return r5_totalexposure_notinvestor_total;
	}
	public void setR5_totalexposure_notinvestor_total(BigDecimal r5_totalexposure_notinvestor_total) {
		this.r5_totalexposure_notinvestor_total = r5_totalexposure_notinvestor_total;
	}
	public BigDecimal getR5_rwa_notinvestor_total() {
		return r5_rwa_notinvestor_total;
	}
	public void setR5_rwa_notinvestor_total(BigDecimal r5_rwa_notinvestor_total) {
		this.r5_rwa_notinvestor_total = r5_rwa_notinvestor_total;
	}
	public BigDecimal getR5_total() {
		return r5_total;
	}
	public void setR5_total(BigDecimal r5_total) {
		this.r5_total = r5_total;
	}
	public String getR6_securitization() {
		return r6_securitization;
	}
	public void setR6_securitization(String r6_securitization) {
		this.r6_securitization = r6_securitization;
	}
	public BigDecimal getR6_onbalance_asinvestor_simple() {
		return r6_onbalance_asinvestor_simple;
	}
	public void setR6_onbalance_asinvestor_simple(BigDecimal r6_onbalance_asinvestor_simple) {
		this.r6_onbalance_asinvestor_simple = r6_onbalance_asinvestor_simple;
	}
	public BigDecimal getR6_offbalance_asinvestor_simple() {
		return r6_offbalance_asinvestor_simple;
	}
	public void setR6_offbalance_asinvestor_simple(BigDecimal r6_offbalance_asinvestor_simple) {
		this.r6_offbalance_asinvestor_simple = r6_offbalance_asinvestor_simple;
	}
	public BigDecimal getR6_totalexposure_asinvestor_simple() {
		return r6_totalexposure_asinvestor_simple;
	}
	public void setR6_totalexposure_asinvestor_simple(BigDecimal r6_totalexposure_asinvestor_simple) {
		this.r6_totalexposure_asinvestor_simple = r6_totalexposure_asinvestor_simple;
	}
	public BigDecimal getR6_rwa_asinvestor_simple() {
		return r6_rwa_asinvestor_simple;
	}
	public void setR6_rwa_asinvestor_simple(BigDecimal r6_rwa_asinvestor_simple) {
		this.r6_rwa_asinvestor_simple = r6_rwa_asinvestor_simple;
	}
	public BigDecimal getR6_onbalance_notinvestor_simple() {
		return r6_onbalance_notinvestor_simple;
	}
	public void setR6_onbalance_notinvestor_simple(BigDecimal r6_onbalance_notinvestor_simple) {
		this.r6_onbalance_notinvestor_simple = r6_onbalance_notinvestor_simple;
	}
	public BigDecimal getR6_offbalance_notinvestor_simple() {
		return r6_offbalance_notinvestor_simple;
	}
	public void setR6_offbalance_notinvestor_simple(BigDecimal r6_offbalance_notinvestor_simple) {
		this.r6_offbalance_notinvestor_simple = r6_offbalance_notinvestor_simple;
	}
	public BigDecimal getR6_totalexposure_notinvestor_simple() {
		return r6_totalexposure_notinvestor_simple;
	}
	public void setR6_totalexposure_notinvestor_simple(BigDecimal r6_totalexposure_notinvestor_simple) {
		this.r6_totalexposure_notinvestor_simple = r6_totalexposure_notinvestor_simple;
	}
	public BigDecimal getR6_rwa_notinvestor_simple() {
		return r6_rwa_notinvestor_simple;
	}
	public void setR6_rwa_notinvestor_simple(BigDecimal r6_rwa_notinvestor_simple) {
		this.r6_rwa_notinvestor_simple = r6_rwa_notinvestor_simple;
	}
	public BigDecimal getR6_onbalance_asinvestor_resecuritization() {
		return r6_onbalance_asinvestor_resecuritization;
	}
	public void setR6_onbalance_asinvestor_resecuritization(BigDecimal r6_onbalance_asinvestor_resecuritization) {
		this.r6_onbalance_asinvestor_resecuritization = r6_onbalance_asinvestor_resecuritization;
	}
	public BigDecimal getR6_offbalance_asinvestor_resecuritization() {
		return r6_offbalance_asinvestor_resecuritization;
	}
	public void setR6_offbalance_asinvestor_resecuritization(BigDecimal r6_offbalance_asinvestor_resecuritization) {
		this.r6_offbalance_asinvestor_resecuritization = r6_offbalance_asinvestor_resecuritization;
	}
	public BigDecimal getR6_totalexposure_asinvestor_resecuritization() {
		return r6_totalexposure_asinvestor_resecuritization;
	}
	public void setR6_totalexposure_asinvestor_resecuritization(
			BigDecimal r6_totalexposure_asinvestor_resecuritization) {
		this.r6_totalexposure_asinvestor_resecuritization = r6_totalexposure_asinvestor_resecuritization;
	}
	public BigDecimal getR6_rwa_asinvestor_resecuritization() {
		return r6_rwa_asinvestor_resecuritization;
	}
	public void setR6_rwa_asinvestor_resecuritization(BigDecimal r6_rwa_asinvestor_resecuritization) {
		this.r6_rwa_asinvestor_resecuritization = r6_rwa_asinvestor_resecuritization;
	}
	public BigDecimal getR6_onbalance_notinvestor_resecuritization() {
		return r6_onbalance_notinvestor_resecuritization;
	}
	public void setR6_onbalance_notinvestor_resecuritization(BigDecimal r6_onbalance_notinvestor_resecuritization) {
		this.r6_onbalance_notinvestor_resecuritization = r6_onbalance_notinvestor_resecuritization;
	}
	public BigDecimal getR6_offbalance_notinvestor_resecuritization() {
		return r6_offbalance_notinvestor_resecuritization;
	}
	public void setR6_offbalance_notinvestor_resecuritization(BigDecimal r6_offbalance_notinvestor_resecuritization) {
		this.r6_offbalance_notinvestor_resecuritization = r6_offbalance_notinvestor_resecuritization;
	}
	public BigDecimal getR6_totalexposure_notinvestor_resecuritization() {
		return r6_totalexposure_notinvestor_resecuritization;
	}
	public void setR6_totalexposure_notinvestor_resecuritization(
			BigDecimal r6_totalexposure_notinvestor_resecuritization) {
		this.r6_totalexposure_notinvestor_resecuritization = r6_totalexposure_notinvestor_resecuritization;
	}
	public BigDecimal getR6_rwa_notinvestor_resecuritization() {
		return r6_rwa_notinvestor_resecuritization;
	}
	public void setR6_rwa_notinvestor_resecuritization(BigDecimal r6_rwa_notinvestor_resecuritization) {
		this.r6_rwa_notinvestor_resecuritization = r6_rwa_notinvestor_resecuritization;
	}
	public BigDecimal getR6_onbalance_asinvestor_traditional() {
		return r6_onbalance_asinvestor_traditional;
	}
	public void setR6_onbalance_asinvestor_traditional(BigDecimal r6_onbalance_asinvestor_traditional) {
		this.r6_onbalance_asinvestor_traditional = r6_onbalance_asinvestor_traditional;
	}
	public BigDecimal getR6_offbalance_asinvestor_traditional() {
		return r6_offbalance_asinvestor_traditional;
	}
	public void setR6_offbalance_asinvestor_traditional(BigDecimal r6_offbalance_asinvestor_traditional) {
		this.r6_offbalance_asinvestor_traditional = r6_offbalance_asinvestor_traditional;
	}
	public BigDecimal getR6_totalexposure_asinvestor_traditional() {
		return r6_totalexposure_asinvestor_traditional;
	}
	public void setR6_totalexposure_asinvestor_traditional(BigDecimal r6_totalexposure_asinvestor_traditional) {
		this.r6_totalexposure_asinvestor_traditional = r6_totalexposure_asinvestor_traditional;
	}
	public BigDecimal getR6_rwa_asinvestor_traditional() {
		return r6_rwa_asinvestor_traditional;
	}
	public void setR6_rwa_asinvestor_traditional(BigDecimal r6_rwa_asinvestor_traditional) {
		this.r6_rwa_asinvestor_traditional = r6_rwa_asinvestor_traditional;
	}
	public BigDecimal getR6_onbalance_notinvestor_traditional() {
		return r6_onbalance_notinvestor_traditional;
	}
	public void setR6_onbalance_notinvestor_traditional(BigDecimal r6_onbalance_notinvestor_traditional) {
		this.r6_onbalance_notinvestor_traditional = r6_onbalance_notinvestor_traditional;
	}
	public BigDecimal getR6_offbalance_notinvestor_traditional() {
		return r6_offbalance_notinvestor_traditional;
	}
	public void setR6_offbalance_notinvestor_traditional(BigDecimal r6_offbalance_notinvestor_traditional) {
		this.r6_offbalance_notinvestor_traditional = r6_offbalance_notinvestor_traditional;
	}
	public BigDecimal getR6_totalexposure_notinvestor_traditional() {
		return r6_totalexposure_notinvestor_traditional;
	}
	public void setR6_totalexposure_notinvestor_traditional(BigDecimal r6_totalexposure_notinvestor_traditional) {
		this.r6_totalexposure_notinvestor_traditional = r6_totalexposure_notinvestor_traditional;
	}
	public BigDecimal getR6_rwa_notinvestor_traditional() {
		return r6_rwa_notinvestor_traditional;
	}
	public void setR6_rwa_notinvestor_traditional(BigDecimal r6_rwa_notinvestor_traditional) {
		this.r6_rwa_notinvestor_traditional = r6_rwa_notinvestor_traditional;
	}
	public BigDecimal getR6_onbalance_asinvestor_synthetic() {
		return r6_onbalance_asinvestor_synthetic;
	}
	public void setR6_onbalance_asinvestor_synthetic(BigDecimal r6_onbalance_asinvestor_synthetic) {
		this.r6_onbalance_asinvestor_synthetic = r6_onbalance_asinvestor_synthetic;
	}
	public BigDecimal getR6_offbalance_asinvestor_synthetic() {
		return r6_offbalance_asinvestor_synthetic;
	}
	public void setR6_offbalance_asinvestor_synthetic(BigDecimal r6_offbalance_asinvestor_synthetic) {
		this.r6_offbalance_asinvestor_synthetic = r6_offbalance_asinvestor_synthetic;
	}
	public BigDecimal getR6_totalexposure_asinvestor_synthetic() {
		return r6_totalexposure_asinvestor_synthetic;
	}
	public void setR6_totalexposure_asinvestor_synthetic(BigDecimal r6_totalexposure_asinvestor_synthetic) {
		this.r6_totalexposure_asinvestor_synthetic = r6_totalexposure_asinvestor_synthetic;
	}
	public BigDecimal getR6_rwa_asinvestor_synthetic() {
		return r6_rwa_asinvestor_synthetic;
	}
	public void setR6_rwa_asinvestor_synthetic(BigDecimal r6_rwa_asinvestor_synthetic) {
		this.r6_rwa_asinvestor_synthetic = r6_rwa_asinvestor_synthetic;
	}
	public BigDecimal getR6_onbalance_notinvestor_synthetic() {
		return r6_onbalance_notinvestor_synthetic;
	}
	public void setR6_onbalance_notinvestor_synthetic(BigDecimal r6_onbalance_notinvestor_synthetic) {
		this.r6_onbalance_notinvestor_synthetic = r6_onbalance_notinvestor_synthetic;
	}
	public BigDecimal getR6_offbalance_notinvestor_synthetic() {
		return r6_offbalance_notinvestor_synthetic;
	}
	public void setR6_offbalance_notinvestor_synthetic(BigDecimal r6_offbalance_notinvestor_synthetic) {
		this.r6_offbalance_notinvestor_synthetic = r6_offbalance_notinvestor_synthetic;
	}
	public BigDecimal getR6_totalexposure_notinvestor_synthetic() {
		return r6_totalexposure_notinvestor_synthetic;
	}
	public void setR6_totalexposure_notinvestor_synthetic(BigDecimal r6_totalexposure_notinvestor_synthetic) {
		this.r6_totalexposure_notinvestor_synthetic = r6_totalexposure_notinvestor_synthetic;
	}
	public BigDecimal getR6_rwa_notinvestor_synthetic() {
		return r6_rwa_notinvestor_synthetic;
	}
	public void setR6_rwa_notinvestor_synthetic(BigDecimal r6_rwa_notinvestor_synthetic) {
		this.r6_rwa_notinvestor_synthetic = r6_rwa_notinvestor_synthetic;
	}
	public BigDecimal getR6_onbalance_asinvestor_total() {
		return r6_onbalance_asinvestor_total;
	}
	public void setR6_onbalance_asinvestor_total(BigDecimal r6_onbalance_asinvestor_total) {
		this.r6_onbalance_asinvestor_total = r6_onbalance_asinvestor_total;
	}
	public BigDecimal getR6_offbalance_asinvestor_total() {
		return r6_offbalance_asinvestor_total;
	}
	public void setR6_offbalance_asinvestor_total(BigDecimal r6_offbalance_asinvestor_total) {
		this.r6_offbalance_asinvestor_total = r6_offbalance_asinvestor_total;
	}
	public BigDecimal getR6_totalexposure_asinvestor_total() {
		return r6_totalexposure_asinvestor_total;
	}
	public void setR6_totalexposure_asinvestor_total(BigDecimal r6_totalexposure_asinvestor_total) {
		this.r6_totalexposure_asinvestor_total = r6_totalexposure_asinvestor_total;
	}
	public BigDecimal getR6_rwa_asinvestor_total() {
		return r6_rwa_asinvestor_total;
	}
	public void setR6_rwa_asinvestor_total(BigDecimal r6_rwa_asinvestor_total) {
		this.r6_rwa_asinvestor_total = r6_rwa_asinvestor_total;
	}
	public BigDecimal getR6_onbalance_notinvestor_total() {
		return r6_onbalance_notinvestor_total;
	}
	public void setR6_onbalance_notinvestor_total(BigDecimal r6_onbalance_notinvestor_total) {
		this.r6_onbalance_notinvestor_total = r6_onbalance_notinvestor_total;
	}
	public BigDecimal getR6_offbalance_notinvestor_total() {
		return r6_offbalance_notinvestor_total;
	}
	public void setR6_offbalance_notinvestor_total(BigDecimal r6_offbalance_notinvestor_total) {
		this.r6_offbalance_notinvestor_total = r6_offbalance_notinvestor_total;
	}
	public BigDecimal getR6_totalexposure_notinvestor_total() {
		return r6_totalexposure_notinvestor_total;
	}
	public void setR6_totalexposure_notinvestor_total(BigDecimal r6_totalexposure_notinvestor_total) {
		this.r6_totalexposure_notinvestor_total = r6_totalexposure_notinvestor_total;
	}
	public BigDecimal getR6_rwa_notinvestor_total() {
		return r6_rwa_notinvestor_total;
	}
	public void setR6_rwa_notinvestor_total(BigDecimal r6_rwa_notinvestor_total) {
		this.r6_rwa_notinvestor_total = r6_rwa_notinvestor_total;
	}
	public BigDecimal getR6_total() {
		return r6_total;
	}
	public void setR6_total(BigDecimal r6_total) {
		this.r6_total = r6_total;
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
	public B18_BASEL_SECURITIZATION_TRADING_RPT() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	

}
