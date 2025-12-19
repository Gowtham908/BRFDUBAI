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
@Table(name = "BRF54_SUMMARYTABLE")
public class BRF54_ENTITY {
	private String r1_items;
	private BigDecimal r1_amount;
	private String r2_items;
	private BigDecimal r2_amount;
	private String r3_items;
	private BigDecimal r3_amount;
	private String r4_items;
	private BigDecimal r4_amount;
	private String r5_items;
	private BigDecimal r5_amount;
	private String r6_items;
	private BigDecimal r6_amount;
	private String r7_items;
	private BigDecimal r7_amount;
	private String r8_items;
	private BigDecimal r8_amount;
	private String r9_items;
	private BigDecimal r9_amount;
	private String r10_items;
	private BigDecimal r10_amount;
	private String r11_items;
	private BigDecimal r11_amount;
	private String r12_items;
	private BigDecimal r12_amount;
	private String r13_items;
	private BigDecimal r13_amount;
	private String r14_items;
	private BigDecimal r14_amount;
	private String r15_items;
	private BigDecimal r15_amount;
	private String r16_items;
	private BigDecimal r16_amount;
	private String r17_items;
	private BigDecimal r17_amount;
	private String r18_items;
	private BigDecimal r18_amount;
	private String r19_items;
	private BigDecimal r19_amount;
	private String r20_items;
	private BigDecimal r20_amount;
	private String r21_items;
	private BigDecimal r21_amount;
	private String r22_items;
	private BigDecimal r22_amount;
	private String r23_items;
	private BigDecimal r23_amount;
	private String r24_items;
	private BigDecimal r24_amount;
	private String r25_items;
	private BigDecimal r25_amount;
	private String r26_items;
	private BigDecimal r26_amount;
	private String r27_items;
	private BigDecimal r27_amount;
	private String r28_items;
	private BigDecimal r28_amount;
	@Id
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date report_date;
	private Date report_from_date;
	private Date report_to_date;
	private String entity_flg;
	private String modify_flg;
	private String del_flg;
	private String report_code;
	private Date report_submit_date;
	private String repdesc;
	private String frequency;

	public String getR1_items() {
		return r1_items;
	}

	public BigDecimal getR1_amount() {
		return r1_amount;
	}

	public String getR2_items() {
		return r2_items;
	}

	public BigDecimal getR2_amount() {
		return r2_amount;
	}

	public String getR3_items() {
		return r3_items;
	}

	public BigDecimal getR3_amount() {
		return r3_amount;
	}

	public String getR4_items() {
		return r4_items;
	}

	public BigDecimal getR4_amount() {
		return r4_amount;
	}

	public String getR5_items() {
		return r5_items;
	}

	public BigDecimal getR5_amount() {
		return r5_amount;
	}

	public String getR6_items() {
		return r6_items;
	}

	public BigDecimal getR6_amount() {
		return r6_amount;
	}

	public String getR7_items() {
		return r7_items;
	}

	public BigDecimal getR7_amount() {
		return r7_amount;
	}

	public String getR8_items() {
		return r8_items;
	}

	public BigDecimal getR8_amount() {
		return r8_amount;
	}

	public String getR9_items() {
		return r9_items;
	}

	public BigDecimal getR9_amount() {
		return r9_amount;
	}

	public String getR10_items() {
		return r10_items;
	}

	public BigDecimal getR10_amount() {
		return r10_amount;
	}

	public String getR11_items() {
		return r11_items;
	}

	public BigDecimal getR11_amount() {
		return r11_amount;
	}

	public String getR12_items() {
		return r12_items;
	}

	public BigDecimal getR12_amount() {
		return r12_amount;
	}

	public String getR13_items() {
		return r13_items;
	}

	public BigDecimal getR13_amount() {
		return r13_amount;
	}

	public String getR14_items() {
		return r14_items;
	}

	public BigDecimal getR14_amount() {
		return r14_amount;
	}

	public String getR15_items() {
		return r15_items;
	}

	public BigDecimal getR15_amount() {
		return r15_amount;
	}

	public String getR16_items() {
		return r16_items;
	}

	public BigDecimal getR16_amount() {
		return r16_amount;
	}

	public String getR17_items() {
		return r17_items;
	}

	public BigDecimal getR17_amount() {
		return r17_amount;
	}

	public String getR18_items() {
		return r18_items;
	}

	public BigDecimal getR18_amount() {
		return r18_amount;
	}

	public String getR19_items() {
		return r19_items;
	}

	public BigDecimal getR19_amount() {
		return r19_amount;
	}

	public String getR20_items() {
		return r20_items;
	}

	public BigDecimal getR20_amount() {
		return r20_amount;
	}

	public String getR21_items() {
		return r21_items;
	}

	public BigDecimal getR21_amount() {
		return r21_amount;
	}

	public String getR22_items() {
		return r22_items;
	}

	public BigDecimal getR22_amount() {
		return r22_amount;
	}

	public String getR23_items() {
		return r23_items;
	}

	public BigDecimal getR23_amount() {
		return r23_amount;
	}

	public String getR24_items() {
		return r24_items;
	}

	public BigDecimal getR24_amount() {
		return r24_amount;
	}

	public String getR25_items() {
		return r25_items;
	}

	public BigDecimal getR25_amount() {
		return r25_amount;
	}

	public String getR26_items() {
		return r26_items;
	}

	public BigDecimal getR26_amount() {
		return r26_amount;
	}

	public String getR27_items() {
		return r27_items;
	}

	public BigDecimal getR27_amount() {
		return r27_amount;
	}

	public String getR28_items() {
		return r28_items;
	}

	public BigDecimal getR28_amount() {
		return r28_amount;
	}

	public Date getReport_date() {
		return report_date;
	}

	public Date getReport_from_date() {
		return report_from_date;
	}

	public Date getReport_to_date() {
		return report_to_date;
	}

	public String getEntity_flg() {
		return entity_flg;
	}

	public String getModify_flg() {
		return modify_flg;
	}

	public String getDel_flg() {
		return del_flg;
	}

	public String getReport_code() {
		return report_code;
	}

	public Date getReport_submit_date() {
		return report_submit_date;
	}

	public String getRepdesc() {
		return repdesc;
	}

	public String getFrequency() {
		return frequency;
	}

	public void setR1_items(String r1_items) {
		this.r1_items = r1_items;
	}

	public void setR1_amount(BigDecimal r1_amount) {
		this.r1_amount = r1_amount;
	}

	public void setR2_items(String r2_items) {
		this.r2_items = r2_items;
	}

	public void setR2_amount(BigDecimal r2_amount) {
		this.r2_amount = r2_amount;
	}

	public void setR3_items(String r3_items) {
		this.r3_items = r3_items;
	}

	public void setR3_amount(BigDecimal r3_amount) {
		this.r3_amount = r3_amount;
	}

	public void setR4_items(String r4_items) {
		this.r4_items = r4_items;
	}

	public void setR4_amount(BigDecimal r4_amount) {
		this.r4_amount = r4_amount;
	}

	public void setR5_items(String r5_items) {
		this.r5_items = r5_items;
	}

	public void setR5_amount(BigDecimal r5_amount) {
		this.r5_amount = r5_amount;
	}

	public void setR6_items(String r6_items) {
		this.r6_items = r6_items;
	}

	public void setR6_amount(BigDecimal r6_amount) {
		this.r6_amount = r6_amount;
	}

	public void setR7_items(String r7_items) {
		this.r7_items = r7_items;
	}

	public void setR7_amount(BigDecimal r7_amount) {
		this.r7_amount = r7_amount;
	}

	public void setR8_items(String r8_items) {
		this.r8_items = r8_items;
	}

	public void setR8_amount(BigDecimal r8_amount) {
		this.r8_amount = r8_amount;
	}

	public void setR9_items(String r9_items) {
		this.r9_items = r9_items;
	}

	public void setR9_amount(BigDecimal r9_amount) {
		this.r9_amount = r9_amount;
	}

	public void setR10_items(String r10_items) {
		this.r10_items = r10_items;
	}

	public void setR10_amount(BigDecimal r10_amount) {
		this.r10_amount = r10_amount;
	}

	public void setR11_items(String r11_items) {
		this.r11_items = r11_items;
	}

	public void setR11_amount(BigDecimal r11_amount) {
		this.r11_amount = r11_amount;
	}

	public void setR12_items(String r12_items) {
		this.r12_items = r12_items;
	}

	public void setR12_amount(BigDecimal r12_amount) {
		this.r12_amount = r12_amount;
	}

	public void setR13_items(String r13_items) {
		this.r13_items = r13_items;
	}

	public void setR13_amount(BigDecimal r13_amount) {
		this.r13_amount = r13_amount;
	}

	public void setR14_items(String r14_items) {
		this.r14_items = r14_items;
	}

	public void setR14_amount(BigDecimal r14_amount) {
		this.r14_amount = r14_amount;
	}

	public void setR15_items(String r15_items) {
		this.r15_items = r15_items;
	}

	public void setR15_amount(BigDecimal r15_amount) {
		this.r15_amount = r15_amount;
	}

	public void setR16_items(String r16_items) {
		this.r16_items = r16_items;
	}

	public void setR16_amount(BigDecimal r16_amount) {
		this.r16_amount = r16_amount;
	}

	public void setR17_items(String r17_items) {
		this.r17_items = r17_items;
	}

	public void setR17_amount(BigDecimal r17_amount) {
		this.r17_amount = r17_amount;
	}

	public void setR18_items(String r18_items) {
		this.r18_items = r18_items;
	}

	public void setR18_amount(BigDecimal r18_amount) {
		this.r18_amount = r18_amount;
	}

	public void setR19_items(String r19_items) {
		this.r19_items = r19_items;
	}

	public void setR19_amount(BigDecimal r19_amount) {
		this.r19_amount = r19_amount;
	}

	public void setR20_items(String r20_items) {
		this.r20_items = r20_items;
	}

	public void setR20_amount(BigDecimal r20_amount) {
		this.r20_amount = r20_amount;
	}

	public void setR21_items(String r21_items) {
		this.r21_items = r21_items;
	}

	public void setR21_amount(BigDecimal r21_amount) {
		this.r21_amount = r21_amount;
	}

	public void setR22_items(String r22_items) {
		this.r22_items = r22_items;
	}

	public void setR22_amount(BigDecimal r22_amount) {
		this.r22_amount = r22_amount;
	}

	public void setR23_items(String r23_items) {
		this.r23_items = r23_items;
	}

	public void setR23_amount(BigDecimal r23_amount) {
		this.r23_amount = r23_amount;
	}

	public void setR24_items(String r24_items) {
		this.r24_items = r24_items;
	}

	public void setR24_amount(BigDecimal r24_amount) {
		this.r24_amount = r24_amount;
	}

	public void setR25_items(String r25_items) {
		this.r25_items = r25_items;
	}

	public void setR25_amount(BigDecimal r25_amount) {
		this.r25_amount = r25_amount;
	}

	public void setR26_items(String r26_items) {
		this.r26_items = r26_items;
	}

	public void setR26_amount(BigDecimal r26_amount) {
		this.r26_amount = r26_amount;
	}

	public void setR27_items(String r27_items) {
		this.r27_items = r27_items;
	}

	public void setR27_amount(BigDecimal r27_amount) {
		this.r27_amount = r27_amount;
	}

	public void setR28_items(String r28_items) {
		this.r28_items = r28_items;
	}

	public void setR28_amount(BigDecimal r28_amount) {
		this.r28_amount = r28_amount;
	}

	public void setReport_date(Date report_date) {
		this.report_date = report_date;
	}

	public void setReport_from_date(Date report_from_date) {
		this.report_from_date = report_from_date;
	}

	public void setReport_to_date(Date report_to_date) {
		this.report_to_date = report_to_date;
	}

	public void setEntity_flg(String entity_flg) {
		this.entity_flg = entity_flg;
	}

	public void setModify_flg(String modify_flg) {
		this.modify_flg = modify_flg;
	}

	public void setDel_flg(String del_flg) {
		this.del_flg = del_flg;
	}

	public void setReport_code(String report_code) {
		this.report_code = report_code;
	}

	public void setReport_submit_date(Date report_submit_date) {
		this.report_submit_date = report_submit_date;
	}

	public void setRepdesc(String repdesc) {
		this.repdesc = repdesc;
	}

	public void setFrequency(String frequency) {
		this.frequency = frequency;
	}

	public BRF54_ENTITY() {
		super();
		// TODO Auto-generated constructor stub
	}
}
