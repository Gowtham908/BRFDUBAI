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
@Table(name="BRF60_SUMMARYTABLE")

public class BRF060Reportentity {

	private String	r1_product;
	private BigDecimal	r1_no;
	private BigDecimal	r1_amount;
	private String	r2_product;
	private BigDecimal	r2_no;
	private BigDecimal	r2_amount;
	private String	r3_product;
	private BigDecimal	r3_no;
	private BigDecimal	r3_amount;
	private String	r4_product;
	private BigDecimal	r4_no;
	private BigDecimal	r4_amount;
	private String	r5_product;
	private BigDecimal	r5_no;
	private BigDecimal	r5_amount;
	private String	r6_product;
	private BigDecimal	r6_no;
	private BigDecimal	r6_amount;
	private String	r7_product;
	private BigDecimal	r7_no;
	private BigDecimal	r7_amount;
	private String	r8_product;
	private BigDecimal	r8_no;
	private BigDecimal	r8_amount;
	private String	r9_product;
	private BigDecimal	r9_no;
	private BigDecimal	r9_amount;
	private String	r10_product;
	private BigDecimal	r10_no;
	private BigDecimal	r10_amount;
	private String	r11_product;
	private BigDecimal	r11_no;
	private BigDecimal	r11_amount;
	private String	r12_product;
	private BigDecimal	r12_no;
	private BigDecimal	r12_amount;
	private String	r13_product;
	private BigDecimal	r13_no;
	private BigDecimal	r13_amount;
	private String	r14_product;
	private BigDecimal	r14_no;
	private BigDecimal	r14_amount;
	private String	r15_product;
	private BigDecimal	r15_no;
	private BigDecimal	r15_amount;
	private String	r16_product;
	private BigDecimal	r16_no;
	private BigDecimal	r16_amount;
	private String	r17_product;
	private BigDecimal	r17_no;
	private BigDecimal	r17_amount;
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
	private String	repdesc;
	private String	frequency;
	public String getR1_product() {
		return r1_product;
	}
	public void setR1_product(String r1_product) {
		this.r1_product = r1_product;
	}
	public BigDecimal getR1_no() {
		return r1_no;
	}
	public void setR1_no(BigDecimal r1_no) {
		this.r1_no = r1_no;
	}
	public BigDecimal getR1_amount() {
		return r1_amount;
	}
	public void setR1_amount(BigDecimal r1_amount) {
		this.r1_amount = r1_amount;
	}
	public String getR2_product() {
		return r2_product;
	}
	public void setR2_product(String r2_product) {
		this.r2_product = r2_product;
	}
	public BigDecimal getR2_no() {
		return r2_no;
	}
	public void setR2_no(BigDecimal r2_no) {
		this.r2_no = r2_no;
	}
	public BigDecimal getR2_amount() {
		return r2_amount;
	}
	public void setR2_amount(BigDecimal r2_amount) {
		this.r2_amount = r2_amount;
	}
	public String getR3_product() {
		return r3_product;
	}
	public void setR3_product(String r3_product) {
		this.r3_product = r3_product;
	}
	public BigDecimal getR3_no() {
		return r3_no;
	}
	public void setR3_no(BigDecimal r3_no) {
		this.r3_no = r3_no;
	}
	public BigDecimal getR3_amount() {
		return r3_amount;
	}
	public void setR3_amount(BigDecimal r3_amount) {
		this.r3_amount = r3_amount;
	}
	public String getR4_product() {
		return r4_product;
	}
	public void setR4_product(String r4_product) {
		this.r4_product = r4_product;
	}
	public BigDecimal getR4_no() {
		return r4_no;
	}
	public void setR4_no(BigDecimal r4_no) {
		this.r4_no = r4_no;
	}
	public BigDecimal getR4_amount() {
		return r4_amount;
	}
	public void setR4_amount(BigDecimal r4_amount) {
		this.r4_amount = r4_amount;
	}
	public String getR5_product() {
		return r5_product;
	}
	public void setR5_product(String r5_product) {
		this.r5_product = r5_product;
	}
	public BigDecimal getR5_no() {
		return r5_no;
	}
	public void setR5_no(BigDecimal r5_no) {
		this.r5_no = r5_no;
	}
	public BigDecimal getR5_amount() {
		return r5_amount;
	}
	public void setR5_amount(BigDecimal r5_amount) {
		this.r5_amount = r5_amount;
	}
	public String getR6_product() {
		return r6_product;
	}
	public void setR6_product(String r6_product) {
		this.r6_product = r6_product;
	}
	public BigDecimal getR6_no() {
		return r6_no;
	}
	public void setR6_no(BigDecimal r6_no) {
		this.r6_no = r6_no;
	}
	public BigDecimal getR6_amount() {
		return r6_amount;
	}
	public void setR6_amount(BigDecimal r6_amount) {
		this.r6_amount = r6_amount;
	}
	public String getR7_product() {
		return r7_product;
	}
	public void setR7_product(String r7_product) {
		this.r7_product = r7_product;
	}
	public BigDecimal getR7_no() {
		return r7_no;
	}
	public void setR7_no(BigDecimal r7_no) {
		this.r7_no = r7_no;
	}
	public BigDecimal getR7_amount() {
		return r7_amount;
	}
	public void setR7_amount(BigDecimal r7_amount) {
		this.r7_amount = r7_amount;
	}
	public String getR8_product() {
		return r8_product;
	}
	public void setR8_product(String r8_product) {
		this.r8_product = r8_product;
	}
	public BigDecimal getR8_no() {
		return r8_no;
	}
	public void setR8_no(BigDecimal r8_no) {
		this.r8_no = r8_no;
	}
	public BigDecimal getR8_amount() {
		return r8_amount;
	}
	public void setR8_amount(BigDecimal r8_amount) {
		this.r8_amount = r8_amount;
	}
	public String getR9_product() {
		return r9_product;
	}
	public void setR9_product(String r9_product) {
		this.r9_product = r9_product;
	}
	public BigDecimal getR9_no() {
		return r9_no;
	}
	public void setR9_no(BigDecimal r9_no) {
		this.r9_no = r9_no;
	}
	public BigDecimal getR9_amount() {
		return r9_amount;
	}
	public void setR9_amount(BigDecimal r9_amount) {
		this.r9_amount = r9_amount;
	}
	public String getR10_product() {
		return r10_product;
	}
	public void setR10_product(String r10_product) {
		this.r10_product = r10_product;
	}
	public BigDecimal getR10_no() {
		return r10_no;
	}
	public void setR10_no(BigDecimal r10_no) {
		this.r10_no = r10_no;
	}
	public BigDecimal getR10_amount() {
		return r10_amount;
	}
	public void setR10_amount(BigDecimal r10_amount) {
		this.r10_amount = r10_amount;
	}
	public String getR11_product() {
		return r11_product;
	}
	public void setR11_product(String r11_product) {
		this.r11_product = r11_product;
	}
	public BigDecimal getR11_no() {
		return r11_no;
	}
	public void setR11_no(BigDecimal r11_no) {
		this.r11_no = r11_no;
	}
	public BigDecimal getR11_amount() {
		return r11_amount;
	}
	public void setR11_amount(BigDecimal r11_amount) {
		this.r11_amount = r11_amount;
	}
	public String getR12_product() {
		return r12_product;
	}
	public void setR12_product(String r12_product) {
		this.r12_product = r12_product;
	}
	public BigDecimal getR12_no() {
		return r12_no;
	}
	public void setR12_no(BigDecimal r12_no) {
		this.r12_no = r12_no;
	}
	public BigDecimal getR12_amount() {
		return r12_amount;
	}
	public void setR12_amount(BigDecimal r12_amount) {
		this.r12_amount = r12_amount;
	}
	public String getR13_product() {
		return r13_product;
	}
	public void setR13_product(String r13_product) {
		this.r13_product = r13_product;
	}
	public BigDecimal getR13_no() {
		return r13_no;
	}
	public void setR13_no(BigDecimal r13_no) {
		this.r13_no = r13_no;
	}
	public BigDecimal getR13_amount() {
		return r13_amount;
	}
	public void setR13_amount(BigDecimal r13_amount) {
		this.r13_amount = r13_amount;
	}
	public String getR14_product() {
		return r14_product;
	}
	public void setR14_product(String r14_product) {
		this.r14_product = r14_product;
	}
	public BigDecimal getR14_no() {
		return r14_no;
	}
	public void setR14_no(BigDecimal r14_no) {
		this.r14_no = r14_no;
	}
	public BigDecimal getR14_amount() {
		return r14_amount;
	}
	public void setR14_amount(BigDecimal r14_amount) {
		this.r14_amount = r14_amount;
	}
	public String getR15_product() {
		return r15_product;
	}
	public void setR15_product(String r15_product) {
		this.r15_product = r15_product;
	}
	public BigDecimal getR15_no() {
		return r15_no;
	}
	public void setR15_no(BigDecimal r15_no) {
		this.r15_no = r15_no;
	}
	public BigDecimal getR15_amount() {
		return r15_amount;
	}
	public void setR15_amount(BigDecimal r15_amount) {
		this.r15_amount = r15_amount;
	}
	public String getR16_product() {
		return r16_product;
	}
	public void setR16_product(String r16_product) {
		this.r16_product = r16_product;
	}
	public BigDecimal getR16_no() {
		return r16_no;
	}
	public void setR16_no(BigDecimal r16_no) {
		this.r16_no = r16_no;
	}
	public BigDecimal getR16_amount() {
		return r16_amount;
	}
	public void setR16_amount(BigDecimal r16_amount) {
		this.r16_amount = r16_amount;
	}
	public String getR17_product() {
		return r17_product;
	}
	public void setR17_product(String r17_product) {
		this.r17_product = r17_product;
	}
	public BigDecimal getR17_no() {
		return r17_no;
	}
	public void setR17_no(BigDecimal r17_no) {
		this.r17_no = r17_no;
	}
	public BigDecimal getR17_amount() {
		return r17_amount;
	}
	public void setR17_amount(BigDecimal r17_amount) {
		this.r17_amount = r17_amount;
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
	public BRF060Reportentity() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
