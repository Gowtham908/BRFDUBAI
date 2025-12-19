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
@Table(name="CR1")
public class BASEL_B2_REPORT_ENTITY {
	private String	R1_ASSET ;
	private BigDecimal	R1_ONBALANCE_SHEET ;
	private BigDecimal	R1_OFFBALANCE_SHEET ;
	private BigDecimal	R1_EXPOSURE_CREDIT ;
	private BigDecimal	R1_CRM_CREDIT ;
	private BigDecimal	R1_ON_OFF_BALANCE_SHEET ;
	private BigDecimal	R1_RISK ;
	private String	R2_ASSET ;
	private BigDecimal	R2_ONBALANCE_SHEET ;
	private BigDecimal	R2_OFFBALANCE_SHEET ;
	private BigDecimal	R2_EXPOSURE_CREDIT ;
	private BigDecimal	R2_CRM_CREDIT ;
	private BigDecimal	R2_ON_OFF_BALANCE_SHEET ;
	private BigDecimal	R2_RISK ;
	private String	R3_ASSET ;
	private BigDecimal	R3_ONBALANCE_SHEET ;
	private BigDecimal	R3_OFFBALANCE_SHEET ;
	private BigDecimal	R3_EXPOSURE_CREDIT ;
	private BigDecimal	R3_CRM_CREDIT ;
	private BigDecimal	R3_ON_OFF_BALANCE_SHEET ;
	private BigDecimal	R3_RISK ;
	private String	R4_ASSET ;
	private BigDecimal	R4_ONBALANCE_SHEET ;
	private BigDecimal	R4_OFFBALANCE_SHEET ;
	private BigDecimal	R4_EXPOSURE_CREDIT ;
	private BigDecimal	R4_CRM_CREDIT ;
	private BigDecimal	R4_ON_OFF_BALANCE_SHEET ;
	private BigDecimal	R4_RISK ;
	private String	R5_ASSET ;
	private BigDecimal	R5_ONBALANCE_SHEET ;
	private BigDecimal	R5_OFFBALANCE_SHEET ;
	private BigDecimal	R5_EXPOSURE_CREDIT ;
	private BigDecimal	R5_CRM_CREDIT ;
	private BigDecimal	R5_ON_OFF_BALANCE_SHEET ;
	private BigDecimal	R5_RISK ;
	private String	R6_ASSET ;
	private BigDecimal	R6_ONBALANCE_SHEET ;
	private BigDecimal	R6_OFFBALANCE_SHEET ;
	private BigDecimal	R6_EXPOSURE_CREDIT ;
	private BigDecimal	R6_CRM_CREDIT ;
	private BigDecimal	R6_ON_OFF_BALANCE_SHEET ;
	private BigDecimal	R6_RISK ;
	private String	R7_ASSET ;
	private BigDecimal	R7_ONBALANCE_SHEET ;
	private BigDecimal	R7_OFFBALANCE_SHEET ;
	private BigDecimal	R7_EXPOSURE_CREDIT ;
	private BigDecimal	R7_CRM_CREDIT ;
	private BigDecimal	R7_ON_OFF_BALANCE_SHEET ;
	private BigDecimal	R7_RISK ;
	private String	R8_ASSET ;
	private BigDecimal	R8_ONBALANCE_SHEET ;
	private BigDecimal	R8_OFFBALANCE_SHEET ;
	private BigDecimal	R8_EXPOSURE_CREDIT ;
	private BigDecimal	R8_CRM_CREDIT ;
	private BigDecimal	R8_ON_OFF_BALANCE_SHEET ;
	private BigDecimal	R8_RISK ;
	private String	R9_ASSET ;
	private BigDecimal	R9_ONBALANCE_SHEET ;
	private BigDecimal	R9_OFFBALANCE_SHEET ;
	private BigDecimal	R9_EXPOSURE_CREDIT ;
	private BigDecimal	R9_CRM_CREDIT ;
	private BigDecimal	R9_ON_OFF_BALANCE_SHEET ;
	private BigDecimal	R9_RISK ;
	private String	R10_ASSET ;
	private BigDecimal	R10_ONBALANCE_SHEET ;
	private BigDecimal	R10_OFFBALANCE_SHEET ;
	private BigDecimal	R10_EXPOSURE_CREDIT ;
	private BigDecimal	R10_CRM_CREDIT ;
	private BigDecimal	R10_ON_OFF_BALANCE_SHEET ;
	private BigDecimal	R10_RISK ;
	private String	R11_ASSET ;
	private BigDecimal	R11_ONBALANCE_SHEET ;
	private BigDecimal	R11_OFFBALANCE_SHEET ;
	private BigDecimal	R11_EXPOSURE_CREDIT ;
	private BigDecimal	R11_CRM_CREDIT ;
	private BigDecimal	R11_ON_OFF_BALANCE_SHEET ;
	private BigDecimal	R11_RISK ;
	private String	R12_ASSET ;
	private BigDecimal	R12_ONBALANCE_SHEET ;
	private BigDecimal	R12_OFFBALANCE_SHEET ;
	private BigDecimal	R12_EXPOSURE_CREDIT ;
	private BigDecimal	R12_CRM_CREDIT ;
	private BigDecimal	R12_ON_OFF_BALANCE_SHEET ;
	private BigDecimal	R12_RISK ;
	private String	R13_ASSET ;
	private BigDecimal	R13_ONBALANCE_SHEET ;
	private BigDecimal	R13_OFFBALANCE_SHEET ;
	private BigDecimal	R13_EXPOSURE_CREDIT ;
	private BigDecimal	R13_CRM_CREDIT ;
	private BigDecimal	R13_ON_OFF_BALANCE_SHEET ;
	private BigDecimal	R13_RISK ;
	private String	R14_ASSET ;
	private BigDecimal	R14_ONBALANCE_SHEET ;
	private BigDecimal	R14_OFFBALANCE_SHEET ;
	private BigDecimal	R14_EXPOSURE_CREDIT ;
	private BigDecimal	R14_CRM_CREDIT ;
	private BigDecimal	R14_ON_OFF_BALANCE_SHEET ;
	private BigDecimal	R14_RISK ;
	private String	R15_ASSET ;
	private BigDecimal	R15_ONBALANCE_SHEET ;
	private BigDecimal	R15_OFFBALANCE_SHEET ;
	private BigDecimal	R15_EXPOSURE_CREDIT ;
	private BigDecimal	R15_CRM_CREDIT ;
	private BigDecimal	R15_ON_OFF_BALANCE_SHEET ;
	private BigDecimal	R15_RISK ;

	@Id
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date	report_date;
	private Date	report_from_date;
	private Date	report_to_date;
	private String	entity_flg;
	private String	modify_flg;
	private String	del_flg;
	private String	report_code;
	private Date	report_submit_date;
	public String getR1_ASSET() {
		return R1_ASSET;
	}
	public void setR1_ASSET(String r1_ASSET) {
		R1_ASSET = r1_ASSET;
	}
	public BigDecimal getR1_ONBALANCE_SHEET() {
		return R1_ONBALANCE_SHEET;
	}
	public void setR1_ONBALANCE_SHEET(BigDecimal r1_ONBALANCE_SHEET) {
		R1_ONBALANCE_SHEET = r1_ONBALANCE_SHEET;
	}
	public BigDecimal getR1_OFFBALANCE_SHEET() {
		return R1_OFFBALANCE_SHEET;
	}
	public void setR1_OFFBALANCE_SHEET(BigDecimal r1_OFFBALANCE_SHEET) {
		R1_OFFBALANCE_SHEET = r1_OFFBALANCE_SHEET;
	}
	public BigDecimal getR1_EXPOSURE_CREDIT() {
		return R1_EXPOSURE_CREDIT;
	}
	public void setR1_EXPOSURE_CREDIT(BigDecimal r1_EXPOSURE_CREDIT) {
		R1_EXPOSURE_CREDIT = r1_EXPOSURE_CREDIT;
	}
	public BigDecimal getR1_CRM_CREDIT() {
		return R1_CRM_CREDIT;
	}
	public void setR1_CRM_CREDIT(BigDecimal r1_CRM_CREDIT) {
		R1_CRM_CREDIT = r1_CRM_CREDIT;
	}
	public BigDecimal getR1_ON_OFF_BALANCE_SHEET() {
		return R1_ON_OFF_BALANCE_SHEET;
	}
	public void setR1_ON_OFF_BALANCE_SHEET(BigDecimal r1_ON_OFF_BALANCE_SHEET) {
		R1_ON_OFF_BALANCE_SHEET = r1_ON_OFF_BALANCE_SHEET;
	}
	public BigDecimal getR1_RISK() {
		return R1_RISK;
	}
	public void setR1_RISK(BigDecimal r1_RISK) {
		R1_RISK = r1_RISK;
	}
	public String getR2_ASSET() {
		return R2_ASSET;
	}
	public void setR2_ASSET(String r2_ASSET) {
		R2_ASSET = r2_ASSET;
	}
	public BigDecimal getR2_ONBALANCE_SHEET() {
		return R2_ONBALANCE_SHEET;
	}
	public void setR2_ONBALANCE_SHEET(BigDecimal r2_ONBALANCE_SHEET) {
		R2_ONBALANCE_SHEET = r2_ONBALANCE_SHEET;
	}
	public BigDecimal getR2_OFFBALANCE_SHEET() {
		return R2_OFFBALANCE_SHEET;
	}
	public void setR2_OFFBALANCE_SHEET(BigDecimal r2_OFFBALANCE_SHEET) {
		R2_OFFBALANCE_SHEET = r2_OFFBALANCE_SHEET;
	}
	public BigDecimal getR2_EXPOSURE_CREDIT() {
		return R2_EXPOSURE_CREDIT;
	}
	public void setR2_EXPOSURE_CREDIT(BigDecimal r2_EXPOSURE_CREDIT) {
		R2_EXPOSURE_CREDIT = r2_EXPOSURE_CREDIT;
	}
	public BigDecimal getR2_CRM_CREDIT() {
		return R2_CRM_CREDIT;
	}
	public void setR2_CRM_CREDIT(BigDecimal r2_CRM_CREDIT) {
		R2_CRM_CREDIT = r2_CRM_CREDIT;
	}
	public BigDecimal getR2_ON_OFF_BALANCE_SHEET() {
		return R2_ON_OFF_BALANCE_SHEET;
	}
	public void setR2_ON_OFF_BALANCE_SHEET(BigDecimal r2_ON_OFF_BALANCE_SHEET) {
		R2_ON_OFF_BALANCE_SHEET = r2_ON_OFF_BALANCE_SHEET;
	}
	public BigDecimal getR2_RISK() {
		return R2_RISK;
	}
	public void setR2_RISK(BigDecimal r2_RISK) {
		R2_RISK = r2_RISK;
	}
	public String getR3_ASSET() {
		return R3_ASSET;
	}
	public void setR3_ASSET(String r3_ASSET) {
		R3_ASSET = r3_ASSET;
	}
	public BigDecimal getR3_ONBALANCE_SHEET() {
		return R3_ONBALANCE_SHEET;
	}
	public void setR3_ONBALANCE_SHEET(BigDecimal r3_ONBALANCE_SHEET) {
		R3_ONBALANCE_SHEET = r3_ONBALANCE_SHEET;
	}
	public BigDecimal getR3_OFFBALANCE_SHEET() {
		return R3_OFFBALANCE_SHEET;
	}
	public void setR3_OFFBALANCE_SHEET(BigDecimal r3_OFFBALANCE_SHEET) {
		R3_OFFBALANCE_SHEET = r3_OFFBALANCE_SHEET;
	}
	public BigDecimal getR3_EXPOSURE_CREDIT() {
		return R3_EXPOSURE_CREDIT;
	}
	public void setR3_EXPOSURE_CREDIT(BigDecimal r3_EXPOSURE_CREDIT) {
		R3_EXPOSURE_CREDIT = r3_EXPOSURE_CREDIT;
	}
	public BigDecimal getR3_CRM_CREDIT() {
		return R3_CRM_CREDIT;
	}
	public void setR3_CRM_CREDIT(BigDecimal r3_CRM_CREDIT) {
		R3_CRM_CREDIT = r3_CRM_CREDIT;
	}
	public BigDecimal getR3_ON_OFF_BALANCE_SHEET() {
		return R3_ON_OFF_BALANCE_SHEET;
	}
	public void setR3_ON_OFF_BALANCE_SHEET(BigDecimal r3_ON_OFF_BALANCE_SHEET) {
		R3_ON_OFF_BALANCE_SHEET = r3_ON_OFF_BALANCE_SHEET;
	}
	public BigDecimal getR3_RISK() {
		return R3_RISK;
	}
	public void setR3_RISK(BigDecimal r3_RISK) {
		R3_RISK = r3_RISK;
	}
	public String getR4_ASSET() {
		return R4_ASSET;
	}
	public void setR4_ASSET(String r4_ASSET) {
		R4_ASSET = r4_ASSET;
	}
	public BigDecimal getR4_ONBALANCE_SHEET() {
		return R4_ONBALANCE_SHEET;
	}
	public void setR4_ONBALANCE_SHEET(BigDecimal r4_ONBALANCE_SHEET) {
		R4_ONBALANCE_SHEET = r4_ONBALANCE_SHEET;
	}
	public BigDecimal getR4_OFFBALANCE_SHEET() {
		return R4_OFFBALANCE_SHEET;
	}
	public void setR4_OFFBALANCE_SHEET(BigDecimal r4_OFFBALANCE_SHEET) {
		R4_OFFBALANCE_SHEET = r4_OFFBALANCE_SHEET;
	}
	public BigDecimal getR4_EXPOSURE_CREDIT() {
		return R4_EXPOSURE_CREDIT;
	}
	public void setR4_EXPOSURE_CREDIT(BigDecimal r4_EXPOSURE_CREDIT) {
		R4_EXPOSURE_CREDIT = r4_EXPOSURE_CREDIT;
	}
	public BigDecimal getR4_CRM_CREDIT() {
		return R4_CRM_CREDIT;
	}
	public void setR4_CRM_CREDIT(BigDecimal r4_CRM_CREDIT) {
		R4_CRM_CREDIT = r4_CRM_CREDIT;
	}
	public BigDecimal getR4_ON_OFF_BALANCE_SHEET() {
		return R4_ON_OFF_BALANCE_SHEET;
	}
	public void setR4_ON_OFF_BALANCE_SHEET(BigDecimal r4_ON_OFF_BALANCE_SHEET) {
		R4_ON_OFF_BALANCE_SHEET = r4_ON_OFF_BALANCE_SHEET;
	}
	public BigDecimal getR4_RISK() {
		return R4_RISK;
	}
	public void setR4_RISK(BigDecimal r4_RISK) {
		R4_RISK = r4_RISK;
	}
	public String getR5_ASSET() {
		return R5_ASSET;
	}
	public void setR5_ASSET(String r5_ASSET) {
		R5_ASSET = r5_ASSET;
	}
	public BigDecimal getR5_ONBALANCE_SHEET() {
		return R5_ONBALANCE_SHEET;
	}
	public void setR5_ONBALANCE_SHEET(BigDecimal r5_ONBALANCE_SHEET) {
		R5_ONBALANCE_SHEET = r5_ONBALANCE_SHEET;
	}
	public BigDecimal getR5_OFFBALANCE_SHEET() {
		return R5_OFFBALANCE_SHEET;
	}
	public void setR5_OFFBALANCE_SHEET(BigDecimal r5_OFFBALANCE_SHEET) {
		R5_OFFBALANCE_SHEET = r5_OFFBALANCE_SHEET;
	}
	public BigDecimal getR5_EXPOSURE_CREDIT() {
		return R5_EXPOSURE_CREDIT;
	}
	public void setR5_EXPOSURE_CREDIT(BigDecimal r5_EXPOSURE_CREDIT) {
		R5_EXPOSURE_CREDIT = r5_EXPOSURE_CREDIT;
	}
	public BigDecimal getR5_CRM_CREDIT() {
		return R5_CRM_CREDIT;
	}
	public void setR5_CRM_CREDIT(BigDecimal r5_CRM_CREDIT) {
		R5_CRM_CREDIT = r5_CRM_CREDIT;
	}
	public BigDecimal getR5_ON_OFF_BALANCE_SHEET() {
		return R5_ON_OFF_BALANCE_SHEET;
	}
	public void setR5_ON_OFF_BALANCE_SHEET(BigDecimal r5_ON_OFF_BALANCE_SHEET) {
		R5_ON_OFF_BALANCE_SHEET = r5_ON_OFF_BALANCE_SHEET;
	}
	public BigDecimal getR5_RISK() {
		return R5_RISK;
	}
	public void setR5_RISK(BigDecimal r5_RISK) {
		R5_RISK = r5_RISK;
	}
	public String getR6_ASSET() {
		return R6_ASSET;
	}
	public void setR6_ASSET(String r6_ASSET) {
		R6_ASSET = r6_ASSET;
	}
	public BigDecimal getR6_ONBALANCE_SHEET() {
		return R6_ONBALANCE_SHEET;
	}
	public void setR6_ONBALANCE_SHEET(BigDecimal r6_ONBALANCE_SHEET) {
		R6_ONBALANCE_SHEET = r6_ONBALANCE_SHEET;
	}
	public BigDecimal getR6_OFFBALANCE_SHEET() {
		return R6_OFFBALANCE_SHEET;
	}
	public void setR6_OFFBALANCE_SHEET(BigDecimal r6_OFFBALANCE_SHEET) {
		R6_OFFBALANCE_SHEET = r6_OFFBALANCE_SHEET;
	}
	public BigDecimal getR6_EXPOSURE_CREDIT() {
		return R6_EXPOSURE_CREDIT;
	}
	public void setR6_EXPOSURE_CREDIT(BigDecimal r6_EXPOSURE_CREDIT) {
		R6_EXPOSURE_CREDIT = r6_EXPOSURE_CREDIT;
	}
	public BigDecimal getR6_CRM_CREDIT() {
		return R6_CRM_CREDIT;
	}
	public void setR6_CRM_CREDIT(BigDecimal r6_CRM_CREDIT) {
		R6_CRM_CREDIT = r6_CRM_CREDIT;
	}
	public BigDecimal getR6_ON_OFF_BALANCE_SHEET() {
		return R6_ON_OFF_BALANCE_SHEET;
	}
	public void setR6_ON_OFF_BALANCE_SHEET(BigDecimal r6_ON_OFF_BALANCE_SHEET) {
		R6_ON_OFF_BALANCE_SHEET = r6_ON_OFF_BALANCE_SHEET;
	}
	public BigDecimal getR6_RISK() {
		return R6_RISK;
	}
	public void setR6_RISK(BigDecimal r6_RISK) {
		R6_RISK = r6_RISK;
	}
	public String getR7_ASSET() {
		return R7_ASSET;
	}
	public void setR7_ASSET(String r7_ASSET) {
		R7_ASSET = r7_ASSET;
	}
	public BigDecimal getR7_ONBALANCE_SHEET() {
		return R7_ONBALANCE_SHEET;
	}
	public void setR7_ONBALANCE_SHEET(BigDecimal r7_ONBALANCE_SHEET) {
		R7_ONBALANCE_SHEET = r7_ONBALANCE_SHEET;
	}
	public BigDecimal getR7_OFFBALANCE_SHEET() {
		return R7_OFFBALANCE_SHEET;
	}
	public void setR7_OFFBALANCE_SHEET(BigDecimal r7_OFFBALANCE_SHEET) {
		R7_OFFBALANCE_SHEET = r7_OFFBALANCE_SHEET;
	}
	public BigDecimal getR7_EXPOSURE_CREDIT() {
		return R7_EXPOSURE_CREDIT;
	}
	public void setR7_EXPOSURE_CREDIT(BigDecimal r7_EXPOSURE_CREDIT) {
		R7_EXPOSURE_CREDIT = r7_EXPOSURE_CREDIT;
	}
	public BigDecimal getR7_CRM_CREDIT() {
		return R7_CRM_CREDIT;
	}
	public void setR7_CRM_CREDIT(BigDecimal r7_CRM_CREDIT) {
		R7_CRM_CREDIT = r7_CRM_CREDIT;
	}
	public BigDecimal getR7_ON_OFF_BALANCE_SHEET() {
		return R7_ON_OFF_BALANCE_SHEET;
	}
	public void setR7_ON_OFF_BALANCE_SHEET(BigDecimal r7_ON_OFF_BALANCE_SHEET) {
		R7_ON_OFF_BALANCE_SHEET = r7_ON_OFF_BALANCE_SHEET;
	}
	public BigDecimal getR7_RISK() {
		return R7_RISK;
	}
	public void setR7_RISK(BigDecimal r7_RISK) {
		R7_RISK = r7_RISK;
	}
	public String getR8_ASSET() {
		return R8_ASSET;
	}
	public void setR8_ASSET(String r8_ASSET) {
		R8_ASSET = r8_ASSET;
	}
	public BigDecimal getR8_ONBALANCE_SHEET() {
		return R8_ONBALANCE_SHEET;
	}
	public void setR8_ONBALANCE_SHEET(BigDecimal r8_ONBALANCE_SHEET) {
		R8_ONBALANCE_SHEET = r8_ONBALANCE_SHEET;
	}
	public BigDecimal getR8_OFFBALANCE_SHEET() {
		return R8_OFFBALANCE_SHEET;
	}
	public void setR8_OFFBALANCE_SHEET(BigDecimal r8_OFFBALANCE_SHEET) {
		R8_OFFBALANCE_SHEET = r8_OFFBALANCE_SHEET;
	}
	public BigDecimal getR8_EXPOSURE_CREDIT() {
		return R8_EXPOSURE_CREDIT;
	}
	public void setR8_EXPOSURE_CREDIT(BigDecimal r8_EXPOSURE_CREDIT) {
		R8_EXPOSURE_CREDIT = r8_EXPOSURE_CREDIT;
	}
	public BigDecimal getR8_CRM_CREDIT() {
		return R8_CRM_CREDIT;
	}
	public void setR8_CRM_CREDIT(BigDecimal r8_CRM_CREDIT) {
		R8_CRM_CREDIT = r8_CRM_CREDIT;
	}
	public BigDecimal getR8_ON_OFF_BALANCE_SHEET() {
		return R8_ON_OFF_BALANCE_SHEET;
	}
	public void setR8_ON_OFF_BALANCE_SHEET(BigDecimal r8_ON_OFF_BALANCE_SHEET) {
		R8_ON_OFF_BALANCE_SHEET = r8_ON_OFF_BALANCE_SHEET;
	}
	public BigDecimal getR8_RISK() {
		return R8_RISK;
	}
	public void setR8_RISK(BigDecimal r8_RISK) {
		R8_RISK = r8_RISK;
	}
	public String getR9_ASSET() {
		return R9_ASSET;
	}
	public void setR9_ASSET(String r9_ASSET) {
		R9_ASSET = r9_ASSET;
	}
	public BigDecimal getR9_ONBALANCE_SHEET() {
		return R9_ONBALANCE_SHEET;
	}
	public void setR9_ONBALANCE_SHEET(BigDecimal r9_ONBALANCE_SHEET) {
		R9_ONBALANCE_SHEET = r9_ONBALANCE_SHEET;
	}
	public BigDecimal getR9_OFFBALANCE_SHEET() {
		return R9_OFFBALANCE_SHEET;
	}
	public void setR9_OFFBALANCE_SHEET(BigDecimal r9_OFFBALANCE_SHEET) {
		R9_OFFBALANCE_SHEET = r9_OFFBALANCE_SHEET;
	}
	public BigDecimal getR9_EXPOSURE_CREDIT() {
		return R9_EXPOSURE_CREDIT;
	}
	public void setR9_EXPOSURE_CREDIT(BigDecimal r9_EXPOSURE_CREDIT) {
		R9_EXPOSURE_CREDIT = r9_EXPOSURE_CREDIT;
	}
	public BigDecimal getR9_CRM_CREDIT() {
		return R9_CRM_CREDIT;
	}
	public void setR9_CRM_CREDIT(BigDecimal r9_CRM_CREDIT) {
		R9_CRM_CREDIT = r9_CRM_CREDIT;
	}
	public BigDecimal getR9_ON_OFF_BALANCE_SHEET() {
		return R9_ON_OFF_BALANCE_SHEET;
	}
	public void setR9_ON_OFF_BALANCE_SHEET(BigDecimal r9_ON_OFF_BALANCE_SHEET) {
		R9_ON_OFF_BALANCE_SHEET = r9_ON_OFF_BALANCE_SHEET;
	}
	public BigDecimal getR9_RISK() {
		return R9_RISK;
	}
	public void setR9_RISK(BigDecimal r9_RISK) {
		R9_RISK = r9_RISK;
	}
	public String getR10_ASSET() {
		return R10_ASSET;
	}
	public void setR10_ASSET(String r10_ASSET) {
		R10_ASSET = r10_ASSET;
	}
	public BigDecimal getR10_ONBALANCE_SHEET() {
		return R10_ONBALANCE_SHEET;
	}
	public void setR10_ONBALANCE_SHEET(BigDecimal r10_ONBALANCE_SHEET) {
		R10_ONBALANCE_SHEET = r10_ONBALANCE_SHEET;
	}
	public BigDecimal getR10_OFFBALANCE_SHEET() {
		return R10_OFFBALANCE_SHEET;
	}
	public void setR10_OFFBALANCE_SHEET(BigDecimal r10_OFFBALANCE_SHEET) {
		R10_OFFBALANCE_SHEET = r10_OFFBALANCE_SHEET;
	}
	public BigDecimal getR10_EXPOSURE_CREDIT() {
		return R10_EXPOSURE_CREDIT;
	}
	public void setR10_EXPOSURE_CREDIT(BigDecimal r10_EXPOSURE_CREDIT) {
		R10_EXPOSURE_CREDIT = r10_EXPOSURE_CREDIT;
	}
	public BigDecimal getR10_CRM_CREDIT() {
		return R10_CRM_CREDIT;
	}
	public void setR10_CRM_CREDIT(BigDecimal r10_CRM_CREDIT) {
		R10_CRM_CREDIT = r10_CRM_CREDIT;
	}
	public BigDecimal getR10_ON_OFF_BALANCE_SHEET() {
		return R10_ON_OFF_BALANCE_SHEET;
	}
	public void setR10_ON_OFF_BALANCE_SHEET(BigDecimal r10_ON_OFF_BALANCE_SHEET) {
		R10_ON_OFF_BALANCE_SHEET = r10_ON_OFF_BALANCE_SHEET;
	}
	public BigDecimal getR10_RISK() {
		return R10_RISK;
	}
	public void setR10_RISK(BigDecimal r10_RISK) {
		R10_RISK = r10_RISK;
	}
	public String getR11_ASSET() {
		return R11_ASSET;
	}
	public void setR11_ASSET(String r11_ASSET) {
		R11_ASSET = r11_ASSET;
	}
	public BigDecimal getR11_ONBALANCE_SHEET() {
		return R11_ONBALANCE_SHEET;
	}
	public void setR11_ONBALANCE_SHEET(BigDecimal r11_ONBALANCE_SHEET) {
		R11_ONBALANCE_SHEET = r11_ONBALANCE_SHEET;
	}
	public BigDecimal getR11_OFFBALANCE_SHEET() {
		return R11_OFFBALANCE_SHEET;
	}
	public void setR11_OFFBALANCE_SHEET(BigDecimal r11_OFFBALANCE_SHEET) {
		R11_OFFBALANCE_SHEET = r11_OFFBALANCE_SHEET;
	}
	public BigDecimal getR11_EXPOSURE_CREDIT() {
		return R11_EXPOSURE_CREDIT;
	}
	public void setR11_EXPOSURE_CREDIT(BigDecimal r11_EXPOSURE_CREDIT) {
		R11_EXPOSURE_CREDIT = r11_EXPOSURE_CREDIT;
	}
	public BigDecimal getR11_CRM_CREDIT() {
		return R11_CRM_CREDIT;
	}
	public void setR11_CRM_CREDIT(BigDecimal r11_CRM_CREDIT) {
		R11_CRM_CREDIT = r11_CRM_CREDIT;
	}
	public BigDecimal getR11_ON_OFF_BALANCE_SHEET() {
		return R11_ON_OFF_BALANCE_SHEET;
	}
	public void setR11_ON_OFF_BALANCE_SHEET(BigDecimal r11_ON_OFF_BALANCE_SHEET) {
		R11_ON_OFF_BALANCE_SHEET = r11_ON_OFF_BALANCE_SHEET;
	}
	public BigDecimal getR11_RISK() {
		return R11_RISK;
	}
	public void setR11_RISK(BigDecimal r11_RISK) {
		R11_RISK = r11_RISK;
	}
	public String getR12_ASSET() {
		return R12_ASSET;
	}
	public void setR12_ASSET(String r12_ASSET) {
		R12_ASSET = r12_ASSET;
	}
	public BigDecimal getR12_ONBALANCE_SHEET() {
		return R12_ONBALANCE_SHEET;
	}
	public void setR12_ONBALANCE_SHEET(BigDecimal r12_ONBALANCE_SHEET) {
		R12_ONBALANCE_SHEET = r12_ONBALANCE_SHEET;
	}
	public BigDecimal getR12_OFFBALANCE_SHEET() {
		return R12_OFFBALANCE_SHEET;
	}
	public void setR12_OFFBALANCE_SHEET(BigDecimal r12_OFFBALANCE_SHEET) {
		R12_OFFBALANCE_SHEET = r12_OFFBALANCE_SHEET;
	}
	public BigDecimal getR12_EXPOSURE_CREDIT() {
		return R12_EXPOSURE_CREDIT;
	}
	public void setR12_EXPOSURE_CREDIT(BigDecimal r12_EXPOSURE_CREDIT) {
		R12_EXPOSURE_CREDIT = r12_EXPOSURE_CREDIT;
	}
	public BigDecimal getR12_CRM_CREDIT() {
		return R12_CRM_CREDIT;
	}
	public void setR12_CRM_CREDIT(BigDecimal r12_CRM_CREDIT) {
		R12_CRM_CREDIT = r12_CRM_CREDIT;
	}
	public BigDecimal getR12_ON_OFF_BALANCE_SHEET() {
		return R12_ON_OFF_BALANCE_SHEET;
	}
	public void setR12_ON_OFF_BALANCE_SHEET(BigDecimal r12_ON_OFF_BALANCE_SHEET) {
		R12_ON_OFF_BALANCE_SHEET = r12_ON_OFF_BALANCE_SHEET;
	}
	public BigDecimal getR12_RISK() {
		return R12_RISK;
	}
	public void setR12_RISK(BigDecimal r12_RISK) {
		R12_RISK = r12_RISK;
	}
	public String getR13_ASSET() {
		return R13_ASSET;
	}
	public void setR13_ASSET(String r13_ASSET) {
		R13_ASSET = r13_ASSET;
	}
	public BigDecimal getR13_ONBALANCE_SHEET() {
		return R13_ONBALANCE_SHEET;
	}
	public void setR13_ONBALANCE_SHEET(BigDecimal r13_ONBALANCE_SHEET) {
		R13_ONBALANCE_SHEET = r13_ONBALANCE_SHEET;
	}
	public BigDecimal getR13_OFFBALANCE_SHEET() {
		return R13_OFFBALANCE_SHEET;
	}
	public void setR13_OFFBALANCE_SHEET(BigDecimal r13_OFFBALANCE_SHEET) {
		R13_OFFBALANCE_SHEET = r13_OFFBALANCE_SHEET;
	}
	public BigDecimal getR13_EXPOSURE_CREDIT() {
		return R13_EXPOSURE_CREDIT;
	}
	public void setR13_EXPOSURE_CREDIT(BigDecimal r13_EXPOSURE_CREDIT) {
		R13_EXPOSURE_CREDIT = r13_EXPOSURE_CREDIT;
	}
	public BigDecimal getR13_CRM_CREDIT() {
		return R13_CRM_CREDIT;
	}
	public void setR13_CRM_CREDIT(BigDecimal r13_CRM_CREDIT) {
		R13_CRM_CREDIT = r13_CRM_CREDIT;
	}
	public BigDecimal getR13_ON_OFF_BALANCE_SHEET() {
		return R13_ON_OFF_BALANCE_SHEET;
	}
	public void setR13_ON_OFF_BALANCE_SHEET(BigDecimal r13_ON_OFF_BALANCE_SHEET) {
		R13_ON_OFF_BALANCE_SHEET = r13_ON_OFF_BALANCE_SHEET;
	}
	public BigDecimal getR13_RISK() {
		return R13_RISK;
	}
	public void setR13_RISK(BigDecimal r13_RISK) {
		R13_RISK = r13_RISK;
	}
	public String getR14_ASSET() {
		return R14_ASSET;
	}
	public void setR14_ASSET(String r14_ASSET) {
		R14_ASSET = r14_ASSET;
	}
	public BigDecimal getR14_ONBALANCE_SHEET() {
		return R14_ONBALANCE_SHEET;
	}
	public void setR14_ONBALANCE_SHEET(BigDecimal r14_ONBALANCE_SHEET) {
		R14_ONBALANCE_SHEET = r14_ONBALANCE_SHEET;
	}
	public BigDecimal getR14_OFFBALANCE_SHEET() {
		return R14_OFFBALANCE_SHEET;
	}
	public void setR14_OFFBALANCE_SHEET(BigDecimal r14_OFFBALANCE_SHEET) {
		R14_OFFBALANCE_SHEET = r14_OFFBALANCE_SHEET;
	}
	public BigDecimal getR14_EXPOSURE_CREDIT() {
		return R14_EXPOSURE_CREDIT;
	}
	public void setR14_EXPOSURE_CREDIT(BigDecimal r14_EXPOSURE_CREDIT) {
		R14_EXPOSURE_CREDIT = r14_EXPOSURE_CREDIT;
	}
	public BigDecimal getR14_CRM_CREDIT() {
		return R14_CRM_CREDIT;
	}
	public void setR14_CRM_CREDIT(BigDecimal r14_CRM_CREDIT) {
		R14_CRM_CREDIT = r14_CRM_CREDIT;
	}
	public BigDecimal getR14_ON_OFF_BALANCE_SHEET() {
		return R14_ON_OFF_BALANCE_SHEET;
	}
	public void setR14_ON_OFF_BALANCE_SHEET(BigDecimal r14_ON_OFF_BALANCE_SHEET) {
		R14_ON_OFF_BALANCE_SHEET = r14_ON_OFF_BALANCE_SHEET;
	}
	public BigDecimal getR14_RISK() {
		return R14_RISK;
	}
	public void setR14_RISK(BigDecimal r14_RISK) {
		R14_RISK = r14_RISK;
	}
	public String getR15_ASSET() {
		return R15_ASSET;
	}
	public void setR15_ASSET(String r15_ASSET) {
		R15_ASSET = r15_ASSET;
	}
	public BigDecimal getR15_ONBALANCE_SHEET() {
		return R15_ONBALANCE_SHEET;
	}
	public void setR15_ONBALANCE_SHEET(BigDecimal r15_ONBALANCE_SHEET) {
		R15_ONBALANCE_SHEET = r15_ONBALANCE_SHEET;
	}
	public BigDecimal getR15_OFFBALANCE_SHEET() {
		return R15_OFFBALANCE_SHEET;
	}
	public void setR15_OFFBALANCE_SHEET(BigDecimal r15_OFFBALANCE_SHEET) {
		R15_OFFBALANCE_SHEET = r15_OFFBALANCE_SHEET;
	}
	public BigDecimal getR15_EXPOSURE_CREDIT() {
		return R15_EXPOSURE_CREDIT;
	}
	public void setR15_EXPOSURE_CREDIT(BigDecimal r15_EXPOSURE_CREDIT) {
		R15_EXPOSURE_CREDIT = r15_EXPOSURE_CREDIT;
	}
	public BigDecimal getR15_CRM_CREDIT() {
		return R15_CRM_CREDIT;
	}
	public void setR15_CRM_CREDIT(BigDecimal r15_CRM_CREDIT) {
		R15_CRM_CREDIT = r15_CRM_CREDIT;
	}
	public BigDecimal getR15_ON_OFF_BALANCE_SHEET() {
		return R15_ON_OFF_BALANCE_SHEET;
	}
	public void setR15_ON_OFF_BALANCE_SHEET(BigDecimal r15_ON_OFF_BALANCE_SHEET) {
		R15_ON_OFF_BALANCE_SHEET = r15_ON_OFF_BALANCE_SHEET;
	}
	public BigDecimal getR15_RISK() {
		return R15_RISK;
	}
	public void setR15_RISK(BigDecimal r15_RISK) {
		R15_RISK = r15_RISK;
	}
	public Date getReport_date() {
		return report_date;
	}
	public void setReport_date(Date report_date) {
		this.report_date = report_date;
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
	public BASEL_B2_REPORT_ENTITY() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
