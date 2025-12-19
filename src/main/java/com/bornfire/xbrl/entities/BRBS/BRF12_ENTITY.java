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
@Table(name="BRF12_SUMMARYTABLE")
public class BRF12_ENTITY{
	
	
	private String	r1_product;
	private BigDecimal	r1_up_3_mon_aed_resident;
	private BigDecimal	r1_above_3_up_6_aed_resident;
	private BigDecimal	r1_above_6_up_12_aed_resident;
	private BigDecimal	r1_exc_12_mon_aed_resident;
	private BigDecimal	r1_up_3_mon_fcy_resident;
	private BigDecimal	r1_above_3_up_6_fcy_resident;
	private BigDecimal	r1_above_6_up_12_fcy_resident;
	private BigDecimal	r1_exc_12_mon_fcy_resident;
	private BigDecimal	r1_total_resident;
	private BigDecimal	r1_up_3_mon_aed_non_resident;
	private BigDecimal	r1_above_3_up_6_aed_non_resident;
	private BigDecimal	r1_above_6_up_12_aed_non_resident;
	private BigDecimal	r1_exc_12_mon_aed_non_resident;
	private BigDecimal	r1_up_3_mon_fcy_non_resident;
	private BigDecimal	r1_above_3_up_6_fcy_non_resident;
	private BigDecimal	r1_above_6_up_12_fcy_non_resident;
	private BigDecimal	r1_exc_12_mon_fcy_non_resident;
	private BigDecimal	r1_total_non_resident;
	private BigDecimal	r1_grand_total_amount;
	private String	r2_product;
	private BigDecimal	r2_up_3_mon_aed_resident;
	private BigDecimal	r2_above_3_up_6_aed_resident;
	private BigDecimal	r2_above_6_up_12_aed_resident;
	private BigDecimal	r2_exc_12_mon_aed_resident;
	private BigDecimal	r2_up_3_mon_fcy_resident;
	private BigDecimal	r2_above_3_up_6_fcy_resident;
	private BigDecimal	r2_above_6_up_12_fcy_resident;
	private BigDecimal	r2_exc_12_mon_fcy_resident;
	private BigDecimal	r2_total_resident;
	private BigDecimal	r2_up_3_mon_aed_non_resident;
	private BigDecimal	r2_above_3_up_6_aed_non_resident;
	private BigDecimal	r2_above_6_up_12_aed_non_resident;
	private BigDecimal	r2_exc_12_mon_aed_non_resident;
	private BigDecimal	r2_up_3_mon_fcy_non_resident;
	private BigDecimal	r2_above_3_up_6_fcy_non_resident;
	private BigDecimal	r2_above_6_up_12_fcy_non_resident;
	private BigDecimal	r2_exc_12_mon_fcy_non_resident;
	private BigDecimal	r2_total_non_resident;
	private BigDecimal	r2_grand_total_amount;
	private String	r3_product;
	private BigDecimal	r3_up_3_mon_aed_resident;
	private BigDecimal	r3_above_3_up_6_aed_resident;
	private BigDecimal	r3_above_6_up_12_aed_resident;
	private BigDecimal	r3_exc_12_mon_aed_resident;
	private BigDecimal	r3_up_3_mon_fcy_resident;
	private BigDecimal	r3_above_3_up_6_fcy_resident;
	private BigDecimal	r3_above_6_up_12_fcy_resident;
	private BigDecimal	r3_exc_12_mon_fcy_resident;
	private BigDecimal	r3_total_resident;
	private BigDecimal	r3_up_3_mon_aed_non_resident;
	private BigDecimal	r3_above_3_up_6_aed_non_resident;
	private BigDecimal	r3_above_6_up_12_aed_non_resident;
	private BigDecimal	r3_exc_12_mon_aed_non_resident;
	private BigDecimal	r3_up_3_mon_fcy_non_resident;
	private BigDecimal	r3_above_3_up_6_fcy_non_resident;
	private BigDecimal	r3_above_6_up_12_fcy_non_resident;
	private BigDecimal	r3_exc_12_mon_fcy_non_resident;
	private BigDecimal	r3_total_non_resident;
	private BigDecimal	r3_grand_total_amount;
	private String	r4_product;
	private BigDecimal	r4_up_3_mon_aed_resident;
	private BigDecimal	r4_above_3_up_6_aed_resident;
	private BigDecimal	r4_above_6_up_12_aed_resident;
	private BigDecimal	r4_exc_12_mon_aed_resident;
	private BigDecimal	r4_up_3_mon_fcy_resident;
	private BigDecimal	r4_above_3_up_6_fcy_resident;
	private BigDecimal	r4_above_6_up_12_fcy_resident;
	private BigDecimal	r4_exc_12_mon_fcy_resident;
	private BigDecimal	r4_total_resident;
	private BigDecimal	r4_up_3_mon_aed_non_resident;
	private BigDecimal	r4_above_3_up_6_aed_non_resident;
	private BigDecimal	r4_above_6_up_12_aed_non_resident;
	private BigDecimal	r4_exc_12_mon_aed_non_resident;
	private BigDecimal	r4_up_3_mon_fcy_non_resident;
	private BigDecimal	r4_above_3_up_6_fcy_non_resident;
	private BigDecimal	r4_above_6_up_12_fcy_non_resident;
	private BigDecimal	r4_exc_12_mon_fcy_non_resident;
	private BigDecimal	r4_total_non_resident;
	private BigDecimal	r4_grand_total_amount;
	private String	r5_product;
	private BigDecimal	r5_up_3_mon_aed_resident;
	private BigDecimal	r5_above_3_up_6_aed_resident;
	private BigDecimal	r5_above_6_up_12_aed_resident;
	private BigDecimal	r5_exc_12_mon_aed_resident;
	private BigDecimal	r5_up_3_mon_fcy_resident;
	private BigDecimal	r5_above_3_up_6_fcy_resident;
	private BigDecimal	r5_above_6_up_12_fcy_resident;
	private BigDecimal	r5_exc_12_mon_fcy_resident;
	private BigDecimal	r5_total_resident;
	private BigDecimal	r5_up_3_mon_aed_non_resident;
	private BigDecimal	r5_above_3_up_6_aed_non_resident;
	private BigDecimal	r5_above_6_up_12_aed_non_resident;
	private BigDecimal	r5_exc_12_mon_aed_non_resident;
	private BigDecimal	r5_up_3_mon_fcy_non_resident;
	private BigDecimal	r5_above_3_up_6_fcy_non_resident;
	private BigDecimal	r5_above_6_up_12_fcy_non_resident;
	private BigDecimal	r5_exc_12_mon_fcy_non_resident;
	private BigDecimal	r5_total_non_resident;
	private BigDecimal	r5_grand_total_amount;
	private String	r6_product;
	private BigDecimal	r6_up_3_mon_aed_resident;
	private BigDecimal	r6_above_3_up_6_aed_resident;
	private BigDecimal	r6_above_6_up_12_aed_resident;
	private BigDecimal	r6_exc_12_mon_aed_resident;
	private BigDecimal	r6_up_3_mon_fcy_resident;
	private BigDecimal	r6_above_3_up_6_fcy_resident;
	private BigDecimal	r6_above_6_up_12_fcy_resident;
	private BigDecimal	r6_exc_12_mon_fcy_resident;
	private BigDecimal	r6_total_resident;
	private BigDecimal	r6_up_3_mon_aed_non_resident;
	private BigDecimal	r6_above_3_up_6_aed_non_resident;
	private BigDecimal	r6_above_6_up_12_aed_non_resident;
	private BigDecimal	r6_exc_12_mon_aed_non_resident;
	private BigDecimal	r6_up_3_mon_fcy_non_resident;
	private BigDecimal	r6_above_3_up_6_fcy_non_resident;
	private BigDecimal	r6_above_6_up_12_fcy_non_resident;
	private BigDecimal	r6_exc_12_mon_fcy_non_resident;
	private BigDecimal	r6_total_non_resident;
	private BigDecimal	r6_grand_total_amount;
	private String	r7_product;
	private BigDecimal	r7_up_3_mon_aed_resident;
	private BigDecimal	r7_above_3_up_6_aed_resident;
	private BigDecimal	r7_above_6_up_12_aed_resident;
	private BigDecimal	r7_exc_12_mon_aed_resident;
	private BigDecimal	r7_up_3_mon_fcy_resident;
	private BigDecimal	r7_above_3_up_6_fcy_resident;
	private BigDecimal	r7_above_6_up_12_fcy_resident;
	private BigDecimal	r7_exc_12_mon_fcy_resident;
	private BigDecimal	r7_total_resident;
	private BigDecimal	r7_up_3_mon_aed_non_resident;
	private BigDecimal	r7_above_3_up_6_aed_non_resident;
	private BigDecimal	r7_above_6_up_12_aed_non_resident;
	private BigDecimal	r7_exc_12_mon_aed_non_resident;
	private BigDecimal	r7_up_3_mon_fcy_non_resident;
	private BigDecimal	r7_above_3_up_6_fcy_non_resident;
	private BigDecimal	r7_above_6_up_12_fcy_non_resident;
	private BigDecimal	r7_exc_12_mon_fcy_non_resident;
	private BigDecimal	r7_total_non_resident;
	private BigDecimal	r7_grand_total_amount;
	private String	r8_product;
	private BigDecimal	r8_up_3_mon_aed_resident;
	private BigDecimal	r8_above_3_up_6_aed_resident;
	private BigDecimal	r8_above_6_up_12_aed_resident;
	private BigDecimal	r8_exc_12_mon_aed_resident;
	private BigDecimal	r8_up_3_mon_fcy_resident;
	private BigDecimal	r8_above_3_up_6_fcy_resident;
	private BigDecimal	r8_above_6_up_12_fcy_resident;
	private BigDecimal	r8_exc_12_mon_fcy_resident;
	private BigDecimal	r8_total_resident;
	private BigDecimal	r8_up_3_mon_aed_non_resident;
	private BigDecimal	r8_above_3_up_6_aed_non_resident;
	private BigDecimal	r8_above_6_up_12_aed_non_resident;
	private BigDecimal	r8_exc_12_mon_aed_non_resident;
	private BigDecimal	r8_up_3_mon_fcy_non_resident;
	private BigDecimal	r8_above_3_up_6_fcy_non_resident;
	private BigDecimal	r8_above_6_up_12_fcy_non_resident;
	private BigDecimal	r8_exc_12_mon_fcy_non_resident;
	private BigDecimal	r8_total_non_resident;
	private BigDecimal	r8_grand_total_amount;
	private String	r9_product;
	private BigDecimal	r9_up_3_mon_aed_resident;
	private BigDecimal	r9_above_3_up_6_aed_resident;
	private BigDecimal	r9_above_6_up_12_aed_resident;
	private BigDecimal	r9_exc_12_mon_aed_resident;
	private BigDecimal	r9_up_3_mon_fcy_resident;
	private BigDecimal	r9_above_3_up_6_fcy_resident;
	private BigDecimal	r9_above_6_up_12_fcy_resident;
	private BigDecimal	r9_exc_12_mon_fcy_resident;
	private BigDecimal	r9_total_resident;
	private BigDecimal	r9_up_3_mon_aed_non_resident;
	private BigDecimal	r9_above_3_up_6_aed_non_resident;
	private BigDecimal	r9_above_6_up_12_aed_non_resident;
	private BigDecimal	r9_exc_12_mon_aed_non_resident;
	private BigDecimal	r9_up_3_mon_fcy_non_resident;
	private BigDecimal	r9_above_3_up_6_fcy_non_resident;
	private BigDecimal	r9_above_6_up_12_fcy_non_resident;
	private BigDecimal	r9_exc_12_mon_fcy_non_resident;
	private BigDecimal	r9_total_non_resident;
	private BigDecimal	r9_grand_total_amount;
	private String	r10_product;
	private BigDecimal	r10_up_3_mon_aed_resident;
	private BigDecimal	r10_above_3_up_6_aed_resident;
	private BigDecimal	r10_above_6_up_12_aed_resident;
	private BigDecimal	r10_exc_12_mon_aed_resident;
	private BigDecimal	r10_up_3_mon_fcy_resident;
	private BigDecimal	r10_above_3_up_6_fcy_resident;
	private BigDecimal	r10_above_6_up_12_fcy_resident;
	private BigDecimal	r10_exc_12_mon_fcy_resident;
	private BigDecimal	r10_total_resident;
	private BigDecimal	r10_up_3_mon_aed_non_resident;
	private BigDecimal	r10_above_3_up_6_aed_non_resident;
	private BigDecimal	r10_above_6_up_12_aed_non_resident;
	private BigDecimal	r10_exc_12_mon_aed_non_resident;
	private BigDecimal	r10_up_3_mon_fcy_non_resident;
	private BigDecimal	r10_above_3_up_6_fcy_non_resident;
	private BigDecimal	r10_above_6_up_12_fcy_non_resident;
	private BigDecimal	r10_exc_12_mon_fcy_non_resident;
	private BigDecimal	r10_total_non_resident;
	private BigDecimal	r10_grand_total_amount;
	private String	r11_product;
	private BigDecimal	r11_up_3_mon_aed_resident;
	private BigDecimal	r11_above_3_up_6_aed_resident;
	private BigDecimal	r11_above_6_up_12_aed_resident;
	private BigDecimal	r11_exc_12_mon_aed_resident;
	private BigDecimal	r11_up_3_mon_fcy_resident;
	private BigDecimal	r11_above_3_up_6_fcy_resident;
	private BigDecimal	r11_above_6_up_12_fcy_resident;
	private BigDecimal	r11_exc_12_mon_fcy_resident;
	private BigDecimal	r11_total_resident;
	private BigDecimal	r11_up_3_mon_aed_non_resident;
	private BigDecimal	r11_above_3_up_6_aed_non_resident;
	private BigDecimal	r11_above_6_up_12_aed_non_resident;
	private BigDecimal	r11_exc_12_mon_aed_non_resident;
	private BigDecimal	r11_up_3_mon_fcy_non_resident;
	private BigDecimal	r11_above_3_up_6_fcy_non_resident;
	private BigDecimal	r11_above_6_up_12_fcy_non_resident;
	private BigDecimal	r11_exc_12_mon_fcy_non_resident;
	private BigDecimal	r11_total_non_resident;
	private BigDecimal	r11_grand_total_amount;
	private String	r12_product;
	private BigDecimal	r12_up_3_mon_aed_resident;
	private BigDecimal	r12_above_3_up_6_aed_resident;
	private BigDecimal	r12_above_6_up_12_aed_resident;
	private BigDecimal	r12_exc_12_mon_aed_resident;
	private BigDecimal	r12_up_3_mon_fcy_resident;
	private BigDecimal	r12_above_3_up_6_fcy_resident;
	private BigDecimal	r12_above_6_up_12_fcy_resident;
	private BigDecimal	r12_exc_12_mon_fcy_resident;
	private BigDecimal	r12_total_resident;
	private BigDecimal	r12_up_3_mon_aed_non_resident;
	private BigDecimal	r12_above_3_up_6_aed_non_resident;
	private BigDecimal	r12_above_6_up_12_aed_non_resident;
	private BigDecimal	r12_exc_12_mon_aed_non_resident;
	private BigDecimal	r12_up_3_mon_fcy_non_resident;
	private BigDecimal	r12_above_3_up_6_fcy_non_resident;
	private BigDecimal	r12_above_6_up_12_fcy_non_resident;
	private BigDecimal	r12_exc_12_mon_fcy_non_resident;
	private BigDecimal	r12_total_non_resident;
	private BigDecimal	r12_grand_total_amount;
	private String	r13_product;
	private BigDecimal	r13_up_3_mon_aed_resident;
	private BigDecimal	r13_above_3_up_6_aed_resident;
	private BigDecimal	r13_above_6_up_12_aed_resident;
	private BigDecimal	r13_exc_12_mon_aed_resident;
	private BigDecimal	r13_up_3_mon_fcy_resident;
	private BigDecimal	r13_above_3_up_6_fcy_resident;
	private BigDecimal	r13_above_6_up_12_fcy_resident;
	private BigDecimal	r13_exc_12_mon_fcy_resident;
	private BigDecimal	r13_total_resident;
	private BigDecimal	r13_up_3_mon_aed_non_resident;
	private BigDecimal	r13_above_3_up_6_aed_non_resident;
	private BigDecimal	r13_above_6_up_12_aed_non_resident;
	private BigDecimal	r13_exc_12_mon_aed_non_resident;
	private BigDecimal	r13_up_3_mon_fcy_non_resident;
	private BigDecimal	r13_above_3_up_6_fcy_non_resident;
	private BigDecimal	r13_above_6_up_12_fcy_non_resident;
	private BigDecimal	r13_exc_12_mon_fcy_non_resident;
	private BigDecimal	r13_total_non_resident;
	private BigDecimal	r13_grand_total_amount;
	private String	r14_product;
	private BigDecimal	r14_up_3_mon_aed_resident;
	private BigDecimal	r14_above_3_up_6_aed_resident;
	private BigDecimal	r14_above_6_up_12_aed_resident;
	private BigDecimal	r14_exc_12_mon_aed_resident;
	private BigDecimal	r14_up_3_mon_fcy_resident;
	private BigDecimal	r14_above_3_up_6_fcy_resident;
	private BigDecimal	r14_above_6_up_12_fcy_resident;
	private BigDecimal	r14_exc_12_mon_fcy_resident;
	private BigDecimal	r14_total_resident;
	private BigDecimal	r14_up_3_mon_aed_non_resident;
	private BigDecimal	r14_above_3_up_6_aed_non_resident;
	private BigDecimal	r14_above_6_up_12_aed_non_resident;
	private BigDecimal	r14_exc_12_mon_aed_non_resident;
	private BigDecimal	r14_up_3_mon_fcy_non_resident;
	private BigDecimal	r14_above_3_up_6_fcy_non_resident;
	private BigDecimal	r14_above_6_up_12_fcy_non_resident;
	private BigDecimal	r14_exc_12_mon_fcy_non_resident;
	private BigDecimal	r14_total_non_resident;
	private BigDecimal	r14_grand_total_amount;
	private String	r15_product;
	private BigDecimal	r15_up_3_mon_aed_resident;
	private BigDecimal	r15_above_3_up_6_aed_resident;
	private BigDecimal	r15_above_6_up_12_aed_resident;
	private BigDecimal	r15_exc_12_mon_aed_resident;
	private BigDecimal	r15_up_3_mon_fcy_resident;
	private BigDecimal	r15_above_3_up_6_fcy_resident;
	private BigDecimal	r15_above_6_up_12_fcy_resident;
	private BigDecimal	r15_exc_12_mon_fcy_resident;
	private BigDecimal	r15_total_resident;
	private BigDecimal	r15_up_3_mon_aed_non_resident;
	private BigDecimal	r15_above_3_up_6_aed_non_resident;
	private BigDecimal	r15_above_6_up_12_aed_non_resident;
	private BigDecimal	r15_exc_12_mon_aed_non_resident;
	private BigDecimal	r15_up_3_mon_fcy_non_resident;
	private BigDecimal	r15_above_3_up_6_fcy_non_resident;
	private BigDecimal	r15_above_6_up_12_fcy_non_resident;
	private BigDecimal	r15_exc_12_mon_fcy_non_resident;
	private BigDecimal	r15_total_non_resident;
	private BigDecimal	r15_grand_total_amount;
	private String	r16_product;
	private BigDecimal	r16_up_3_mon_aed_resident;
	private BigDecimal	r16_above_3_up_6_aed_resident;
	private BigDecimal	r16_above_6_up_12_aed_resident;
	private BigDecimal	r16_exc_12_mon_aed_resident;
	private BigDecimal	r16_up_3_mon_fcy_resident;
	private BigDecimal	r16_above_3_up_6_fcy_resident;
	private BigDecimal	r16_above_6_up_12_fcy_resident;
	private BigDecimal	r16_exc_12_mon_fcy_resident;
	private BigDecimal	r16_total_resident;
	private BigDecimal	r16_up_3_mon_aed_non_resident;
	private BigDecimal	r16_above_3_up_6_aed_non_resident;
	private BigDecimal	r16_above_6_up_12_aed_non_resident;
	private BigDecimal	r16_exc_12_mon_aed_non_resident;
	private BigDecimal	r16_up_3_mon_fcy_non_resident;
	private BigDecimal	r16_above_3_up_6_fcy_non_resident;
	private BigDecimal	r16_above_6_up_12_fcy_non_resident;
	private BigDecimal	r16_exc_12_mon_fcy_non_resident;
	private BigDecimal	r16_total_non_resident;
	private BigDecimal	r16_grand_total_amount;

	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Id
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
	public BigDecimal getR1_up_3_mon_aed_resident() {
		return r1_up_3_mon_aed_resident;
	}
	public void setR1_up_3_mon_aed_resident(BigDecimal r1_up_3_mon_aed_resident) {
		this.r1_up_3_mon_aed_resident = r1_up_3_mon_aed_resident;
	}
	public BigDecimal getR1_above_3_up_6_aed_resident() {
		return r1_above_3_up_6_aed_resident;
	}
	public void setR1_above_3_up_6_aed_resident(BigDecimal r1_above_3_up_6_aed_resident) {
		this.r1_above_3_up_6_aed_resident = r1_above_3_up_6_aed_resident;
	}
	public BigDecimal getR1_above_6_up_12_aed_resident() {
		return r1_above_6_up_12_aed_resident;
	}
	public void setR1_above_6_up_12_aed_resident(BigDecimal r1_above_6_up_12_aed_resident) {
		this.r1_above_6_up_12_aed_resident = r1_above_6_up_12_aed_resident;
	}
	public BigDecimal getR1_exc_12_mon_aed_resident() {
		return r1_exc_12_mon_aed_resident;
	}
	public void setR1_exc_12_mon_aed_resident(BigDecimal r1_exc_12_mon_aed_resident) {
		this.r1_exc_12_mon_aed_resident = r1_exc_12_mon_aed_resident;
	}
	public BigDecimal getR1_up_3_mon_fcy_resident() {
		return r1_up_3_mon_fcy_resident;
	}
	public void setR1_up_3_mon_fcy_resident(BigDecimal r1_up_3_mon_fcy_resident) {
		this.r1_up_3_mon_fcy_resident = r1_up_3_mon_fcy_resident;
	}
	public BigDecimal getR1_above_3_up_6_fcy_resident() {
		return r1_above_3_up_6_fcy_resident;
	}
	public void setR1_above_3_up_6_fcy_resident(BigDecimal r1_above_3_up_6_fcy_resident) {
		this.r1_above_3_up_6_fcy_resident = r1_above_3_up_6_fcy_resident;
	}
	public BigDecimal getR1_above_6_up_12_fcy_resident() {
		return r1_above_6_up_12_fcy_resident;
	}
	public void setR1_above_6_up_12_fcy_resident(BigDecimal r1_above_6_up_12_fcy_resident) {
		this.r1_above_6_up_12_fcy_resident = r1_above_6_up_12_fcy_resident;
	}
	public BigDecimal getR1_exc_12_mon_fcy_resident() {
		return r1_exc_12_mon_fcy_resident;
	}
	public void setR1_exc_12_mon_fcy_resident(BigDecimal r1_exc_12_mon_fcy_resident) {
		this.r1_exc_12_mon_fcy_resident = r1_exc_12_mon_fcy_resident;
	}
	public BigDecimal getR1_total_resident() {
		return r1_total_resident;
	}
	public void setR1_total_resident(BigDecimal r1_total_resident) {
		this.r1_total_resident = r1_total_resident;
	}
	public BigDecimal getR1_up_3_mon_aed_non_resident() {
		return r1_up_3_mon_aed_non_resident;
	}
	public void setR1_up_3_mon_aed_non_resident(BigDecimal r1_up_3_mon_aed_non_resident) {
		this.r1_up_3_mon_aed_non_resident = r1_up_3_mon_aed_non_resident;
	}
	public BigDecimal getR1_above_3_up_6_aed_non_resident() {
		return r1_above_3_up_6_aed_non_resident;
	}
	public void setR1_above_3_up_6_aed_non_resident(BigDecimal r1_above_3_up_6_aed_non_resident) {
		this.r1_above_3_up_6_aed_non_resident = r1_above_3_up_6_aed_non_resident;
	}
	public BigDecimal getR1_above_6_up_12_aed_non_resident() {
		return r1_above_6_up_12_aed_non_resident;
	}
	public void setR1_above_6_up_12_aed_non_resident(BigDecimal r1_above_6_up_12_aed_non_resident) {
		this.r1_above_6_up_12_aed_non_resident = r1_above_6_up_12_aed_non_resident;
	}
	public BigDecimal getR1_exc_12_mon_aed_non_resident() {
		return r1_exc_12_mon_aed_non_resident;
	}
	public void setR1_exc_12_mon_aed_non_resident(BigDecimal r1_exc_12_mon_aed_non_resident) {
		this.r1_exc_12_mon_aed_non_resident = r1_exc_12_mon_aed_non_resident;
	}
	public BigDecimal getR1_up_3_mon_fcy_non_resident() {
		return r1_up_3_mon_fcy_non_resident;
	}
	public void setR1_up_3_mon_fcy_non_resident(BigDecimal r1_up_3_mon_fcy_non_resident) {
		this.r1_up_3_mon_fcy_non_resident = r1_up_3_mon_fcy_non_resident;
	}
	public BigDecimal getR1_above_3_up_6_fcy_non_resident() {
		return r1_above_3_up_6_fcy_non_resident;
	}
	public void setR1_above_3_up_6_fcy_non_resident(BigDecimal r1_above_3_up_6_fcy_non_resident) {
		this.r1_above_3_up_6_fcy_non_resident = r1_above_3_up_6_fcy_non_resident;
	}
	public BigDecimal getR1_above_6_up_12_fcy_non_resident() {
		return r1_above_6_up_12_fcy_non_resident;
	}
	public void setR1_above_6_up_12_fcy_non_resident(BigDecimal r1_above_6_up_12_fcy_non_resident) {
		this.r1_above_6_up_12_fcy_non_resident = r1_above_6_up_12_fcy_non_resident;
	}
	public BigDecimal getR1_exc_12_mon_fcy_non_resident() {
		return r1_exc_12_mon_fcy_non_resident;
	}
	public void setR1_exc_12_mon_fcy_non_resident(BigDecimal r1_exc_12_mon_fcy_non_resident) {
		this.r1_exc_12_mon_fcy_non_resident = r1_exc_12_mon_fcy_non_resident;
	}
	public BigDecimal getR1_total_non_resident() {
		return r1_total_non_resident;
	}
	public void setR1_total_non_resident(BigDecimal r1_total_non_resident) {
		this.r1_total_non_resident = r1_total_non_resident;
	}
	public BigDecimal getR1_grand_total_amount() {
		return r1_grand_total_amount;
	}
	public void setR1_grand_total_amount(BigDecimal r1_grand_total_amount) {
		this.r1_grand_total_amount = r1_grand_total_amount;
	}
	public String getR2_product() {
		return r2_product;
	}
	public void setR2_product(String r2_product) {
		this.r2_product = r2_product;
	}
	public BigDecimal getR2_up_3_mon_aed_resident() {
		return r2_up_3_mon_aed_resident;
	}
	public void setR2_up_3_mon_aed_resident(BigDecimal r2_up_3_mon_aed_resident) {
		this.r2_up_3_mon_aed_resident = r2_up_3_mon_aed_resident;
	}
	public BigDecimal getR2_above_3_up_6_aed_resident() {
		return r2_above_3_up_6_aed_resident;
	}
	public void setR2_above_3_up_6_aed_resident(BigDecimal r2_above_3_up_6_aed_resident) {
		this.r2_above_3_up_6_aed_resident = r2_above_3_up_6_aed_resident;
	}
	public BigDecimal getR2_above_6_up_12_aed_resident() {
		return r2_above_6_up_12_aed_resident;
	}
	public void setR2_above_6_up_12_aed_resident(BigDecimal r2_above_6_up_12_aed_resident) {
		this.r2_above_6_up_12_aed_resident = r2_above_6_up_12_aed_resident;
	}
	public BigDecimal getR2_exc_12_mon_aed_resident() {
		return r2_exc_12_mon_aed_resident;
	}
	public void setR2_exc_12_mon_aed_resident(BigDecimal r2_exc_12_mon_aed_resident) {
		this.r2_exc_12_mon_aed_resident = r2_exc_12_mon_aed_resident;
	}
	public BigDecimal getR2_up_3_mon_fcy_resident() {
		return r2_up_3_mon_fcy_resident;
	}
	public void setR2_up_3_mon_fcy_resident(BigDecimal r2_up_3_mon_fcy_resident) {
		this.r2_up_3_mon_fcy_resident = r2_up_3_mon_fcy_resident;
	}
	public BigDecimal getR2_above_3_up_6_fcy_resident() {
		return r2_above_3_up_6_fcy_resident;
	}
	public void setR2_above_3_up_6_fcy_resident(BigDecimal r2_above_3_up_6_fcy_resident) {
		this.r2_above_3_up_6_fcy_resident = r2_above_3_up_6_fcy_resident;
	}
	public BigDecimal getR2_above_6_up_12_fcy_resident() {
		return r2_above_6_up_12_fcy_resident;
	}
	public void setR2_above_6_up_12_fcy_resident(BigDecimal r2_above_6_up_12_fcy_resident) {
		this.r2_above_6_up_12_fcy_resident = r2_above_6_up_12_fcy_resident;
	}
	public BigDecimal getR2_exc_12_mon_fcy_resident() {
		return r2_exc_12_mon_fcy_resident;
	}
	public void setR2_exc_12_mon_fcy_resident(BigDecimal r2_exc_12_mon_fcy_resident) {
		this.r2_exc_12_mon_fcy_resident = r2_exc_12_mon_fcy_resident;
	}
	public BigDecimal getR2_total_resident() {
		return r2_total_resident;
	}
	public void setR2_total_resident(BigDecimal r2_total_resident) {
		this.r2_total_resident = r2_total_resident;
	}
	public BigDecimal getR2_up_3_mon_aed_non_resident() {
		return r2_up_3_mon_aed_non_resident;
	}
	public void setR2_up_3_mon_aed_non_resident(BigDecimal r2_up_3_mon_aed_non_resident) {
		this.r2_up_3_mon_aed_non_resident = r2_up_3_mon_aed_non_resident;
	}
	public BigDecimal getR2_above_3_up_6_aed_non_resident() {
		return r2_above_3_up_6_aed_non_resident;
	}
	public void setR2_above_3_up_6_aed_non_resident(BigDecimal r2_above_3_up_6_aed_non_resident) {
		this.r2_above_3_up_6_aed_non_resident = r2_above_3_up_6_aed_non_resident;
	}
	public BigDecimal getR2_above_6_up_12_aed_non_resident() {
		return r2_above_6_up_12_aed_non_resident;
	}
	public void setR2_above_6_up_12_aed_non_resident(BigDecimal r2_above_6_up_12_aed_non_resident) {
		this.r2_above_6_up_12_aed_non_resident = r2_above_6_up_12_aed_non_resident;
	}
	public BigDecimal getR2_exc_12_mon_aed_non_resident() {
		return r2_exc_12_mon_aed_non_resident;
	}
	public void setR2_exc_12_mon_aed_non_resident(BigDecimal r2_exc_12_mon_aed_non_resident) {
		this.r2_exc_12_mon_aed_non_resident = r2_exc_12_mon_aed_non_resident;
	}
	public BigDecimal getR2_up_3_mon_fcy_non_resident() {
		return r2_up_3_mon_fcy_non_resident;
	}
	public void setR2_up_3_mon_fcy_non_resident(BigDecimal r2_up_3_mon_fcy_non_resident) {
		this.r2_up_3_mon_fcy_non_resident = r2_up_3_mon_fcy_non_resident;
	}
	public BigDecimal getR2_above_3_up_6_fcy_non_resident() {
		return r2_above_3_up_6_fcy_non_resident;
	}
	public void setR2_above_3_up_6_fcy_non_resident(BigDecimal r2_above_3_up_6_fcy_non_resident) {
		this.r2_above_3_up_6_fcy_non_resident = r2_above_3_up_6_fcy_non_resident;
	}
	public BigDecimal getR2_above_6_up_12_fcy_non_resident() {
		return r2_above_6_up_12_fcy_non_resident;
	}
	public void setR2_above_6_up_12_fcy_non_resident(BigDecimal r2_above_6_up_12_fcy_non_resident) {
		this.r2_above_6_up_12_fcy_non_resident = r2_above_6_up_12_fcy_non_resident;
	}
	public BigDecimal getR2_exc_12_mon_fcy_non_resident() {
		return r2_exc_12_mon_fcy_non_resident;
	}
	public void setR2_exc_12_mon_fcy_non_resident(BigDecimal r2_exc_12_mon_fcy_non_resident) {
		this.r2_exc_12_mon_fcy_non_resident = r2_exc_12_mon_fcy_non_resident;
	}
	public BigDecimal getR2_total_non_resident() {
		return r2_total_non_resident;
	}
	public void setR2_total_non_resident(BigDecimal r2_total_non_resident) {
		this.r2_total_non_resident = r2_total_non_resident;
	}
	public BigDecimal getR2_grand_total_amount() {
		return r2_grand_total_amount;
	}
	public void setR2_grand_total_amount(BigDecimal r2_grand_total_amount) {
		this.r2_grand_total_amount = r2_grand_total_amount;
	}
	public String getR3_product() {
		return r3_product;
	}
	public void setR3_product(String r3_product) {
		this.r3_product = r3_product;
	}
	public BigDecimal getR3_up_3_mon_aed_resident() {
		return r3_up_3_mon_aed_resident;
	}
	public void setR3_up_3_mon_aed_resident(BigDecimal r3_up_3_mon_aed_resident) {
		this.r3_up_3_mon_aed_resident = r3_up_3_mon_aed_resident;
	}
	public BigDecimal getR3_above_3_up_6_aed_resident() {
		return r3_above_3_up_6_aed_resident;
	}
	public void setR3_above_3_up_6_aed_resident(BigDecimal r3_above_3_up_6_aed_resident) {
		this.r3_above_3_up_6_aed_resident = r3_above_3_up_6_aed_resident;
	}
	public BigDecimal getR3_above_6_up_12_aed_resident() {
		return r3_above_6_up_12_aed_resident;
	}
	public void setR3_above_6_up_12_aed_resident(BigDecimal r3_above_6_up_12_aed_resident) {
		this.r3_above_6_up_12_aed_resident = r3_above_6_up_12_aed_resident;
	}
	public BigDecimal getR3_exc_12_mon_aed_resident() {
		return r3_exc_12_mon_aed_resident;
	}
	public void setR3_exc_12_mon_aed_resident(BigDecimal r3_exc_12_mon_aed_resident) {
		this.r3_exc_12_mon_aed_resident = r3_exc_12_mon_aed_resident;
	}
	public BigDecimal getR3_up_3_mon_fcy_resident() {
		return r3_up_3_mon_fcy_resident;
	}
	public void setR3_up_3_mon_fcy_resident(BigDecimal r3_up_3_mon_fcy_resident) {
		this.r3_up_3_mon_fcy_resident = r3_up_3_mon_fcy_resident;
	}
	public BigDecimal getR3_above_3_up_6_fcy_resident() {
		return r3_above_3_up_6_fcy_resident;
	}
	public void setR3_above_3_up_6_fcy_resident(BigDecimal r3_above_3_up_6_fcy_resident) {
		this.r3_above_3_up_6_fcy_resident = r3_above_3_up_6_fcy_resident;
	}
	public BigDecimal getR3_above_6_up_12_fcy_resident() {
		return r3_above_6_up_12_fcy_resident;
	}
	public void setR3_above_6_up_12_fcy_resident(BigDecimal r3_above_6_up_12_fcy_resident) {
		this.r3_above_6_up_12_fcy_resident = r3_above_6_up_12_fcy_resident;
	}
	public BigDecimal getR3_exc_12_mon_fcy_resident() {
		return r3_exc_12_mon_fcy_resident;
	}
	public void setR3_exc_12_mon_fcy_resident(BigDecimal r3_exc_12_mon_fcy_resident) {
		this.r3_exc_12_mon_fcy_resident = r3_exc_12_mon_fcy_resident;
	}
	public BigDecimal getR3_total_resident() {
		return r3_total_resident;
	}
	public void setR3_total_resident(BigDecimal r3_total_resident) {
		this.r3_total_resident = r3_total_resident;
	}
	public BigDecimal getR3_up_3_mon_aed_non_resident() {
		return r3_up_3_mon_aed_non_resident;
	}
	public void setR3_up_3_mon_aed_non_resident(BigDecimal r3_up_3_mon_aed_non_resident) {
		this.r3_up_3_mon_aed_non_resident = r3_up_3_mon_aed_non_resident;
	}
	public BigDecimal getR3_above_3_up_6_aed_non_resident() {
		return r3_above_3_up_6_aed_non_resident;
	}
	public void setR3_above_3_up_6_aed_non_resident(BigDecimal r3_above_3_up_6_aed_non_resident) {
		this.r3_above_3_up_6_aed_non_resident = r3_above_3_up_6_aed_non_resident;
	}
	public BigDecimal getR3_above_6_up_12_aed_non_resident() {
		return r3_above_6_up_12_aed_non_resident;
	}
	public void setR3_above_6_up_12_aed_non_resident(BigDecimal r3_above_6_up_12_aed_non_resident) {
		this.r3_above_6_up_12_aed_non_resident = r3_above_6_up_12_aed_non_resident;
	}
	public BigDecimal getR3_exc_12_mon_aed_non_resident() {
		return r3_exc_12_mon_aed_non_resident;
	}
	public void setR3_exc_12_mon_aed_non_resident(BigDecimal r3_exc_12_mon_aed_non_resident) {
		this.r3_exc_12_mon_aed_non_resident = r3_exc_12_mon_aed_non_resident;
	}
	public BigDecimal getR3_up_3_mon_fcy_non_resident() {
		return r3_up_3_mon_fcy_non_resident;
	}
	public void setR3_up_3_mon_fcy_non_resident(BigDecimal r3_up_3_mon_fcy_non_resident) {
		this.r3_up_3_mon_fcy_non_resident = r3_up_3_mon_fcy_non_resident;
	}
	public BigDecimal getR3_above_3_up_6_fcy_non_resident() {
		return r3_above_3_up_6_fcy_non_resident;
	}
	public void setR3_above_3_up_6_fcy_non_resident(BigDecimal r3_above_3_up_6_fcy_non_resident) {
		this.r3_above_3_up_6_fcy_non_resident = r3_above_3_up_6_fcy_non_resident;
	}
	public BigDecimal getR3_above_6_up_12_fcy_non_resident() {
		return r3_above_6_up_12_fcy_non_resident;
	}
	public void setR3_above_6_up_12_fcy_non_resident(BigDecimal r3_above_6_up_12_fcy_non_resident) {
		this.r3_above_6_up_12_fcy_non_resident = r3_above_6_up_12_fcy_non_resident;
	}
	public BigDecimal getR3_exc_12_mon_fcy_non_resident() {
		return r3_exc_12_mon_fcy_non_resident;
	}
	public void setR3_exc_12_mon_fcy_non_resident(BigDecimal r3_exc_12_mon_fcy_non_resident) {
		this.r3_exc_12_mon_fcy_non_resident = r3_exc_12_mon_fcy_non_resident;
	}
	public BigDecimal getR3_total_non_resident() {
		return r3_total_non_resident;
	}
	public void setR3_total_non_resident(BigDecimal r3_total_non_resident) {
		this.r3_total_non_resident = r3_total_non_resident;
	}
	public BigDecimal getR3_grand_total_amount() {
		return r3_grand_total_amount;
	}
	public void setR3_grand_total_amount(BigDecimal r3_grand_total_amount) {
		this.r3_grand_total_amount = r3_grand_total_amount;
	}
	public String getR4_product() {
		return r4_product;
	}
	public void setR4_product(String r4_product) {
		this.r4_product = r4_product;
	}
	public BigDecimal getR4_up_3_mon_aed_resident() {
		return r4_up_3_mon_aed_resident;
	}
	public void setR4_up_3_mon_aed_resident(BigDecimal r4_up_3_mon_aed_resident) {
		this.r4_up_3_mon_aed_resident = r4_up_3_mon_aed_resident;
	}
	public BigDecimal getR4_above_3_up_6_aed_resident() {
		return r4_above_3_up_6_aed_resident;
	}
	public void setR4_above_3_up_6_aed_resident(BigDecimal r4_above_3_up_6_aed_resident) {
		this.r4_above_3_up_6_aed_resident = r4_above_3_up_6_aed_resident;
	}
	public BigDecimal getR4_above_6_up_12_aed_resident() {
		return r4_above_6_up_12_aed_resident;
	}
	public void setR4_above_6_up_12_aed_resident(BigDecimal r4_above_6_up_12_aed_resident) {
		this.r4_above_6_up_12_aed_resident = r4_above_6_up_12_aed_resident;
	}
	public BigDecimal getR4_exc_12_mon_aed_resident() {
		return r4_exc_12_mon_aed_resident;
	}
	public void setR4_exc_12_mon_aed_resident(BigDecimal r4_exc_12_mon_aed_resident) {
		this.r4_exc_12_mon_aed_resident = r4_exc_12_mon_aed_resident;
	}
	public BigDecimal getR4_up_3_mon_fcy_resident() {
		return r4_up_3_mon_fcy_resident;
	}
	public void setR4_up_3_mon_fcy_resident(BigDecimal r4_up_3_mon_fcy_resident) {
		this.r4_up_3_mon_fcy_resident = r4_up_3_mon_fcy_resident;
	}
	public BigDecimal getR4_above_3_up_6_fcy_resident() {
		return r4_above_3_up_6_fcy_resident;
	}
	public void setR4_above_3_up_6_fcy_resident(BigDecimal r4_above_3_up_6_fcy_resident) {
		this.r4_above_3_up_6_fcy_resident = r4_above_3_up_6_fcy_resident;
	}
	public BigDecimal getR4_above_6_up_12_fcy_resident() {
		return r4_above_6_up_12_fcy_resident;
	}
	public void setR4_above_6_up_12_fcy_resident(BigDecimal r4_above_6_up_12_fcy_resident) {
		this.r4_above_6_up_12_fcy_resident = r4_above_6_up_12_fcy_resident;
	}
	public BigDecimal getR4_exc_12_mon_fcy_resident() {
		return r4_exc_12_mon_fcy_resident;
	}
	public void setR4_exc_12_mon_fcy_resident(BigDecimal r4_exc_12_mon_fcy_resident) {
		this.r4_exc_12_mon_fcy_resident = r4_exc_12_mon_fcy_resident;
	}
	public BigDecimal getR4_total_resident() {
		return r4_total_resident;
	}
	public void setR4_total_resident(BigDecimal r4_total_resident) {
		this.r4_total_resident = r4_total_resident;
	}
	public BigDecimal getR4_up_3_mon_aed_non_resident() {
		return r4_up_3_mon_aed_non_resident;
	}
	public void setR4_up_3_mon_aed_non_resident(BigDecimal r4_up_3_mon_aed_non_resident) {
		this.r4_up_3_mon_aed_non_resident = r4_up_3_mon_aed_non_resident;
	}
	public BigDecimal getR4_above_3_up_6_aed_non_resident() {
		return r4_above_3_up_6_aed_non_resident;
	}
	public void setR4_above_3_up_6_aed_non_resident(BigDecimal r4_above_3_up_6_aed_non_resident) {
		this.r4_above_3_up_6_aed_non_resident = r4_above_3_up_6_aed_non_resident;
	}
	public BigDecimal getR4_above_6_up_12_aed_non_resident() {
		return r4_above_6_up_12_aed_non_resident;
	}
	public void setR4_above_6_up_12_aed_non_resident(BigDecimal r4_above_6_up_12_aed_non_resident) {
		this.r4_above_6_up_12_aed_non_resident = r4_above_6_up_12_aed_non_resident;
	}
	public BigDecimal getR4_exc_12_mon_aed_non_resident() {
		return r4_exc_12_mon_aed_non_resident;
	}
	public void setR4_exc_12_mon_aed_non_resident(BigDecimal r4_exc_12_mon_aed_non_resident) {
		this.r4_exc_12_mon_aed_non_resident = r4_exc_12_mon_aed_non_resident;
	}
	public BigDecimal getR4_up_3_mon_fcy_non_resident() {
		return r4_up_3_mon_fcy_non_resident;
	}
	public void setR4_up_3_mon_fcy_non_resident(BigDecimal r4_up_3_mon_fcy_non_resident) {
		this.r4_up_3_mon_fcy_non_resident = r4_up_3_mon_fcy_non_resident;
	}
	public BigDecimal getR4_above_3_up_6_fcy_non_resident() {
		return r4_above_3_up_6_fcy_non_resident;
	}
	public void setR4_above_3_up_6_fcy_non_resident(BigDecimal r4_above_3_up_6_fcy_non_resident) {
		this.r4_above_3_up_6_fcy_non_resident = r4_above_3_up_6_fcy_non_resident;
	}
	public BigDecimal getR4_above_6_up_12_fcy_non_resident() {
		return r4_above_6_up_12_fcy_non_resident;
	}
	public void setR4_above_6_up_12_fcy_non_resident(BigDecimal r4_above_6_up_12_fcy_non_resident) {
		this.r4_above_6_up_12_fcy_non_resident = r4_above_6_up_12_fcy_non_resident;
	}
	public BigDecimal getR4_exc_12_mon_fcy_non_resident() {
		return r4_exc_12_mon_fcy_non_resident;
	}
	public void setR4_exc_12_mon_fcy_non_resident(BigDecimal r4_exc_12_mon_fcy_non_resident) {
		this.r4_exc_12_mon_fcy_non_resident = r4_exc_12_mon_fcy_non_resident;
	}
	public BigDecimal getR4_total_non_resident() {
		return r4_total_non_resident;
	}
	public void setR4_total_non_resident(BigDecimal r4_total_non_resident) {
		this.r4_total_non_resident = r4_total_non_resident;
	}
	public BigDecimal getR4_grand_total_amount() {
		return r4_grand_total_amount;
	}
	public void setR4_grand_total_amount(BigDecimal r4_grand_total_amount) {
		this.r4_grand_total_amount = r4_grand_total_amount;
	}
	public String getR5_product() {
		return r5_product;
	}
	public void setR5_product(String r5_product) {
		this.r5_product = r5_product;
	}
	public BigDecimal getR5_up_3_mon_aed_resident() {
		return r5_up_3_mon_aed_resident;
	}
	public void setR5_up_3_mon_aed_resident(BigDecimal r5_up_3_mon_aed_resident) {
		this.r5_up_3_mon_aed_resident = r5_up_3_mon_aed_resident;
	}
	public BigDecimal getR5_above_3_up_6_aed_resident() {
		return r5_above_3_up_6_aed_resident;
	}
	public void setR5_above_3_up_6_aed_resident(BigDecimal r5_above_3_up_6_aed_resident) {
		this.r5_above_3_up_6_aed_resident = r5_above_3_up_6_aed_resident;
	}
	public BigDecimal getR5_above_6_up_12_aed_resident() {
		return r5_above_6_up_12_aed_resident;
	}
	public void setR5_above_6_up_12_aed_resident(BigDecimal r5_above_6_up_12_aed_resident) {
		this.r5_above_6_up_12_aed_resident = r5_above_6_up_12_aed_resident;
	}
	public BigDecimal getR5_exc_12_mon_aed_resident() {
		return r5_exc_12_mon_aed_resident;
	}
	public void setR5_exc_12_mon_aed_resident(BigDecimal r5_exc_12_mon_aed_resident) {
		this.r5_exc_12_mon_aed_resident = r5_exc_12_mon_aed_resident;
	}
	public BigDecimal getR5_up_3_mon_fcy_resident() {
		return r5_up_3_mon_fcy_resident;
	}
	public void setR5_up_3_mon_fcy_resident(BigDecimal r5_up_3_mon_fcy_resident) {
		this.r5_up_3_mon_fcy_resident = r5_up_3_mon_fcy_resident;
	}
	public BigDecimal getR5_above_3_up_6_fcy_resident() {
		return r5_above_3_up_6_fcy_resident;
	}
	public void setR5_above_3_up_6_fcy_resident(BigDecimal r5_above_3_up_6_fcy_resident) {
		this.r5_above_3_up_6_fcy_resident = r5_above_3_up_6_fcy_resident;
	}
	public BigDecimal getR5_above_6_up_12_fcy_resident() {
		return r5_above_6_up_12_fcy_resident;
	}
	public void setR5_above_6_up_12_fcy_resident(BigDecimal r5_above_6_up_12_fcy_resident) {
		this.r5_above_6_up_12_fcy_resident = r5_above_6_up_12_fcy_resident;
	}
	public BigDecimal getR5_exc_12_mon_fcy_resident() {
		return r5_exc_12_mon_fcy_resident;
	}
	public void setR5_exc_12_mon_fcy_resident(BigDecimal r5_exc_12_mon_fcy_resident) {
		this.r5_exc_12_mon_fcy_resident = r5_exc_12_mon_fcy_resident;
	}
	public BigDecimal getR5_total_resident() {
		return r5_total_resident;
	}
	public void setR5_total_resident(BigDecimal r5_total_resident) {
		this.r5_total_resident = r5_total_resident;
	}
	public BigDecimal getR5_up_3_mon_aed_non_resident() {
		return r5_up_3_mon_aed_non_resident;
	}
	public void setR5_up_3_mon_aed_non_resident(BigDecimal r5_up_3_mon_aed_non_resident) {
		this.r5_up_3_mon_aed_non_resident = r5_up_3_mon_aed_non_resident;
	}
	public BigDecimal getR5_above_3_up_6_aed_non_resident() {
		return r5_above_3_up_6_aed_non_resident;
	}
	public void setR5_above_3_up_6_aed_non_resident(BigDecimal r5_above_3_up_6_aed_non_resident) {
		this.r5_above_3_up_6_aed_non_resident = r5_above_3_up_6_aed_non_resident;
	}
	public BigDecimal getR5_above_6_up_12_aed_non_resident() {
		return r5_above_6_up_12_aed_non_resident;
	}
	public void setR5_above_6_up_12_aed_non_resident(BigDecimal r5_above_6_up_12_aed_non_resident) {
		this.r5_above_6_up_12_aed_non_resident = r5_above_6_up_12_aed_non_resident;
	}
	public BigDecimal getR5_exc_12_mon_aed_non_resident() {
		return r5_exc_12_mon_aed_non_resident;
	}
	public void setR5_exc_12_mon_aed_non_resident(BigDecimal r5_exc_12_mon_aed_non_resident) {
		this.r5_exc_12_mon_aed_non_resident = r5_exc_12_mon_aed_non_resident;
	}
	public BigDecimal getR5_up_3_mon_fcy_non_resident() {
		return r5_up_3_mon_fcy_non_resident;
	}
	public void setR5_up_3_mon_fcy_non_resident(BigDecimal r5_up_3_mon_fcy_non_resident) {
		this.r5_up_3_mon_fcy_non_resident = r5_up_3_mon_fcy_non_resident;
	}
	public BigDecimal getR5_above_3_up_6_fcy_non_resident() {
		return r5_above_3_up_6_fcy_non_resident;
	}
	public void setR5_above_3_up_6_fcy_non_resident(BigDecimal r5_above_3_up_6_fcy_non_resident) {
		this.r5_above_3_up_6_fcy_non_resident = r5_above_3_up_6_fcy_non_resident;
	}
	public BigDecimal getR5_above_6_up_12_fcy_non_resident() {
		return r5_above_6_up_12_fcy_non_resident;
	}
	public void setR5_above_6_up_12_fcy_non_resident(BigDecimal r5_above_6_up_12_fcy_non_resident) {
		this.r5_above_6_up_12_fcy_non_resident = r5_above_6_up_12_fcy_non_resident;
	}
	public BigDecimal getR5_exc_12_mon_fcy_non_resident() {
		return r5_exc_12_mon_fcy_non_resident;
	}
	public void setR5_exc_12_mon_fcy_non_resident(BigDecimal r5_exc_12_mon_fcy_non_resident) {
		this.r5_exc_12_mon_fcy_non_resident = r5_exc_12_mon_fcy_non_resident;
	}
	public BigDecimal getR5_total_non_resident() {
		return r5_total_non_resident;
	}
	public void setR5_total_non_resident(BigDecimal r5_total_non_resident) {
		this.r5_total_non_resident = r5_total_non_resident;
	}
	public BigDecimal getR5_grand_total_amount() {
		return r5_grand_total_amount;
	}
	public void setR5_grand_total_amount(BigDecimal r5_grand_total_amount) {
		this.r5_grand_total_amount = r5_grand_total_amount;
	}
	public String getR6_product() {
		return r6_product;
	}
	public void setR6_product(String r6_product) {
		this.r6_product = r6_product;
	}
	public BigDecimal getR6_up_3_mon_aed_resident() {
		return r6_up_3_mon_aed_resident;
	}
	public void setR6_up_3_mon_aed_resident(BigDecimal r6_up_3_mon_aed_resident) {
		this.r6_up_3_mon_aed_resident = r6_up_3_mon_aed_resident;
	}
	public BigDecimal getR6_above_3_up_6_aed_resident() {
		return r6_above_3_up_6_aed_resident;
	}
	public void setR6_above_3_up_6_aed_resident(BigDecimal r6_above_3_up_6_aed_resident) {
		this.r6_above_3_up_6_aed_resident = r6_above_3_up_6_aed_resident;
	}
	public BigDecimal getR6_above_6_up_12_aed_resident() {
		return r6_above_6_up_12_aed_resident;
	}
	public void setR6_above_6_up_12_aed_resident(BigDecimal r6_above_6_up_12_aed_resident) {
		this.r6_above_6_up_12_aed_resident = r6_above_6_up_12_aed_resident;
	}
	public BigDecimal getR6_exc_12_mon_aed_resident() {
		return r6_exc_12_mon_aed_resident;
	}
	public void setR6_exc_12_mon_aed_resident(BigDecimal r6_exc_12_mon_aed_resident) {
		this.r6_exc_12_mon_aed_resident = r6_exc_12_mon_aed_resident;
	}
	public BigDecimal getR6_up_3_mon_fcy_resident() {
		return r6_up_3_mon_fcy_resident;
	}
	public void setR6_up_3_mon_fcy_resident(BigDecimal r6_up_3_mon_fcy_resident) {
		this.r6_up_3_mon_fcy_resident = r6_up_3_mon_fcy_resident;
	}
	public BigDecimal getR6_above_3_up_6_fcy_resident() {
		return r6_above_3_up_6_fcy_resident;
	}
	public void setR6_above_3_up_6_fcy_resident(BigDecimal r6_above_3_up_6_fcy_resident) {
		this.r6_above_3_up_6_fcy_resident = r6_above_3_up_6_fcy_resident;
	}
	public BigDecimal getR6_above_6_up_12_fcy_resident() {
		return r6_above_6_up_12_fcy_resident;
	}
	public void setR6_above_6_up_12_fcy_resident(BigDecimal r6_above_6_up_12_fcy_resident) {
		this.r6_above_6_up_12_fcy_resident = r6_above_6_up_12_fcy_resident;
	}
	public BigDecimal getR6_exc_12_mon_fcy_resident() {
		return r6_exc_12_mon_fcy_resident;
	}
	public void setR6_exc_12_mon_fcy_resident(BigDecimal r6_exc_12_mon_fcy_resident) {
		this.r6_exc_12_mon_fcy_resident = r6_exc_12_mon_fcy_resident;
	}
	public BigDecimal getR6_total_resident() {
		return r6_total_resident;
	}
	public void setR6_total_resident(BigDecimal r6_total_resident) {
		this.r6_total_resident = r6_total_resident;
	}
	public BigDecimal getR6_up_3_mon_aed_non_resident() {
		return r6_up_3_mon_aed_non_resident;
	}
	public void setR6_up_3_mon_aed_non_resident(BigDecimal r6_up_3_mon_aed_non_resident) {
		this.r6_up_3_mon_aed_non_resident = r6_up_3_mon_aed_non_resident;
	}
	public BigDecimal getR6_above_3_up_6_aed_non_resident() {
		return r6_above_3_up_6_aed_non_resident;
	}
	public void setR6_above_3_up_6_aed_non_resident(BigDecimal r6_above_3_up_6_aed_non_resident) {
		this.r6_above_3_up_6_aed_non_resident = r6_above_3_up_6_aed_non_resident;
	}
	public BigDecimal getR6_above_6_up_12_aed_non_resident() {
		return r6_above_6_up_12_aed_non_resident;
	}
	public void setR6_above_6_up_12_aed_non_resident(BigDecimal r6_above_6_up_12_aed_non_resident) {
		this.r6_above_6_up_12_aed_non_resident = r6_above_6_up_12_aed_non_resident;
	}
	public BigDecimal getR6_exc_12_mon_aed_non_resident() {
		return r6_exc_12_mon_aed_non_resident;
	}
	public void setR6_exc_12_mon_aed_non_resident(BigDecimal r6_exc_12_mon_aed_non_resident) {
		this.r6_exc_12_mon_aed_non_resident = r6_exc_12_mon_aed_non_resident;
	}
	public BigDecimal getR6_up_3_mon_fcy_non_resident() {
		return r6_up_3_mon_fcy_non_resident;
	}
	public void setR6_up_3_mon_fcy_non_resident(BigDecimal r6_up_3_mon_fcy_non_resident) {
		this.r6_up_3_mon_fcy_non_resident = r6_up_3_mon_fcy_non_resident;
	}
	public BigDecimal getR6_above_3_up_6_fcy_non_resident() {
		return r6_above_3_up_6_fcy_non_resident;
	}
	public void setR6_above_3_up_6_fcy_non_resident(BigDecimal r6_above_3_up_6_fcy_non_resident) {
		this.r6_above_3_up_6_fcy_non_resident = r6_above_3_up_6_fcy_non_resident;
	}
	public BigDecimal getR6_above_6_up_12_fcy_non_resident() {
		return r6_above_6_up_12_fcy_non_resident;
	}
	public void setR6_above_6_up_12_fcy_non_resident(BigDecimal r6_above_6_up_12_fcy_non_resident) {
		this.r6_above_6_up_12_fcy_non_resident = r6_above_6_up_12_fcy_non_resident;
	}
	public BigDecimal getR6_exc_12_mon_fcy_non_resident() {
		return r6_exc_12_mon_fcy_non_resident;
	}
	public void setR6_exc_12_mon_fcy_non_resident(BigDecimal r6_exc_12_mon_fcy_non_resident) {
		this.r6_exc_12_mon_fcy_non_resident = r6_exc_12_mon_fcy_non_resident;
	}
	public BigDecimal getR6_total_non_resident() {
		return r6_total_non_resident;
	}
	public void setR6_total_non_resident(BigDecimal r6_total_non_resident) {
		this.r6_total_non_resident = r6_total_non_resident;
	}
	public BigDecimal getR6_grand_total_amount() {
		return r6_grand_total_amount;
	}
	public void setR6_grand_total_amount(BigDecimal r6_grand_total_amount) {
		this.r6_grand_total_amount = r6_grand_total_amount;
	}
	public String getR7_product() {
		return r7_product;
	}
	public void setR7_product(String r7_product) {
		this.r7_product = r7_product;
	}
	public BigDecimal getR7_up_3_mon_aed_resident() {
		return r7_up_3_mon_aed_resident;
	}
	public void setR7_up_3_mon_aed_resident(BigDecimal r7_up_3_mon_aed_resident) {
		this.r7_up_3_mon_aed_resident = r7_up_3_mon_aed_resident;
	}
	public BigDecimal getR7_above_3_up_6_aed_resident() {
		return r7_above_3_up_6_aed_resident;
	}
	public void setR7_above_3_up_6_aed_resident(BigDecimal r7_above_3_up_6_aed_resident) {
		this.r7_above_3_up_6_aed_resident = r7_above_3_up_6_aed_resident;
	}
	public BigDecimal getR7_above_6_up_12_aed_resident() {
		return r7_above_6_up_12_aed_resident;
	}
	public void setR7_above_6_up_12_aed_resident(BigDecimal r7_above_6_up_12_aed_resident) {
		this.r7_above_6_up_12_aed_resident = r7_above_6_up_12_aed_resident;
	}
	public BigDecimal getR7_exc_12_mon_aed_resident() {
		return r7_exc_12_mon_aed_resident;
	}
	public void setR7_exc_12_mon_aed_resident(BigDecimal r7_exc_12_mon_aed_resident) {
		this.r7_exc_12_mon_aed_resident = r7_exc_12_mon_aed_resident;
	}
	public BigDecimal getR7_up_3_mon_fcy_resident() {
		return r7_up_3_mon_fcy_resident;
	}
	public void setR7_up_3_mon_fcy_resident(BigDecimal r7_up_3_mon_fcy_resident) {
		this.r7_up_3_mon_fcy_resident = r7_up_3_mon_fcy_resident;
	}
	public BigDecimal getR7_above_3_up_6_fcy_resident() {
		return r7_above_3_up_6_fcy_resident;
	}
	public void setR7_above_3_up_6_fcy_resident(BigDecimal r7_above_3_up_6_fcy_resident) {
		this.r7_above_3_up_6_fcy_resident = r7_above_3_up_6_fcy_resident;
	}
	public BigDecimal getR7_above_6_up_12_fcy_resident() {
		return r7_above_6_up_12_fcy_resident;
	}
	public void setR7_above_6_up_12_fcy_resident(BigDecimal r7_above_6_up_12_fcy_resident) {
		this.r7_above_6_up_12_fcy_resident = r7_above_6_up_12_fcy_resident;
	}
	public BigDecimal getR7_exc_12_mon_fcy_resident() {
		return r7_exc_12_mon_fcy_resident;
	}
	public void setR7_exc_12_mon_fcy_resident(BigDecimal r7_exc_12_mon_fcy_resident) {
		this.r7_exc_12_mon_fcy_resident = r7_exc_12_mon_fcy_resident;
	}
	public BigDecimal getR7_total_resident() {
		return r7_total_resident;
	}
	public void setR7_total_resident(BigDecimal r7_total_resident) {
		this.r7_total_resident = r7_total_resident;
	}
	public BigDecimal getR7_up_3_mon_aed_non_resident() {
		return r7_up_3_mon_aed_non_resident;
	}
	public void setR7_up_3_mon_aed_non_resident(BigDecimal r7_up_3_mon_aed_non_resident) {
		this.r7_up_3_mon_aed_non_resident = r7_up_3_mon_aed_non_resident;
	}
	public BigDecimal getR7_above_3_up_6_aed_non_resident() {
		return r7_above_3_up_6_aed_non_resident;
	}
	public void setR7_above_3_up_6_aed_non_resident(BigDecimal r7_above_3_up_6_aed_non_resident) {
		this.r7_above_3_up_6_aed_non_resident = r7_above_3_up_6_aed_non_resident;
	}
	public BigDecimal getR7_above_6_up_12_aed_non_resident() {
		return r7_above_6_up_12_aed_non_resident;
	}
	public void setR7_above_6_up_12_aed_non_resident(BigDecimal r7_above_6_up_12_aed_non_resident) {
		this.r7_above_6_up_12_aed_non_resident = r7_above_6_up_12_aed_non_resident;
	}
	public BigDecimal getR7_exc_12_mon_aed_non_resident() {
		return r7_exc_12_mon_aed_non_resident;
	}
	public void setR7_exc_12_mon_aed_non_resident(BigDecimal r7_exc_12_mon_aed_non_resident) {
		this.r7_exc_12_mon_aed_non_resident = r7_exc_12_mon_aed_non_resident;
	}
	public BigDecimal getR7_up_3_mon_fcy_non_resident() {
		return r7_up_3_mon_fcy_non_resident;
	}
	public void setR7_up_3_mon_fcy_non_resident(BigDecimal r7_up_3_mon_fcy_non_resident) {
		this.r7_up_3_mon_fcy_non_resident = r7_up_3_mon_fcy_non_resident;
	}
	public BigDecimal getR7_above_3_up_6_fcy_non_resident() {
		return r7_above_3_up_6_fcy_non_resident;
	}
	public void setR7_above_3_up_6_fcy_non_resident(BigDecimal r7_above_3_up_6_fcy_non_resident) {
		this.r7_above_3_up_6_fcy_non_resident = r7_above_3_up_6_fcy_non_resident;
	}
	public BigDecimal getR7_above_6_up_12_fcy_non_resident() {
		return r7_above_6_up_12_fcy_non_resident;
	}
	public void setR7_above_6_up_12_fcy_non_resident(BigDecimal r7_above_6_up_12_fcy_non_resident) {
		this.r7_above_6_up_12_fcy_non_resident = r7_above_6_up_12_fcy_non_resident;
	}
	public BigDecimal getR7_exc_12_mon_fcy_non_resident() {
		return r7_exc_12_mon_fcy_non_resident;
	}
	public void setR7_exc_12_mon_fcy_non_resident(BigDecimal r7_exc_12_mon_fcy_non_resident) {
		this.r7_exc_12_mon_fcy_non_resident = r7_exc_12_mon_fcy_non_resident;
	}
	public BigDecimal getR7_total_non_resident() {
		return r7_total_non_resident;
	}
	public void setR7_total_non_resident(BigDecimal r7_total_non_resident) {
		this.r7_total_non_resident = r7_total_non_resident;
	}
	public BigDecimal getR7_grand_total_amount() {
		return r7_grand_total_amount;
	}
	public void setR7_grand_total_amount(BigDecimal r7_grand_total_amount) {
		this.r7_grand_total_amount = r7_grand_total_amount;
	}
	public String getR8_product() {
		return r8_product;
	}
	public void setR8_product(String r8_product) {
		this.r8_product = r8_product;
	}
	public BigDecimal getR8_up_3_mon_aed_resident() {
		return r8_up_3_mon_aed_resident;
	}
	public void setR8_up_3_mon_aed_resident(BigDecimal r8_up_3_mon_aed_resident) {
		this.r8_up_3_mon_aed_resident = r8_up_3_mon_aed_resident;
	}
	public BigDecimal getR8_above_3_up_6_aed_resident() {
		return r8_above_3_up_6_aed_resident;
	}
	public void setR8_above_3_up_6_aed_resident(BigDecimal r8_above_3_up_6_aed_resident) {
		this.r8_above_3_up_6_aed_resident = r8_above_3_up_6_aed_resident;
	}
	public BigDecimal getR8_above_6_up_12_aed_resident() {
		return r8_above_6_up_12_aed_resident;
	}
	public void setR8_above_6_up_12_aed_resident(BigDecimal r8_above_6_up_12_aed_resident) {
		this.r8_above_6_up_12_aed_resident = r8_above_6_up_12_aed_resident;
	}
	public BigDecimal getR8_exc_12_mon_aed_resident() {
		return r8_exc_12_mon_aed_resident;
	}
	public void setR8_exc_12_mon_aed_resident(BigDecimal r8_exc_12_mon_aed_resident) {
		this.r8_exc_12_mon_aed_resident = r8_exc_12_mon_aed_resident;
	}
	public BigDecimal getR8_up_3_mon_fcy_resident() {
		return r8_up_3_mon_fcy_resident;
	}
	public void setR8_up_3_mon_fcy_resident(BigDecimal r8_up_3_mon_fcy_resident) {
		this.r8_up_3_mon_fcy_resident = r8_up_3_mon_fcy_resident;
	}
	public BigDecimal getR8_above_3_up_6_fcy_resident() {
		return r8_above_3_up_6_fcy_resident;
	}
	public void setR8_above_3_up_6_fcy_resident(BigDecimal r8_above_3_up_6_fcy_resident) {
		this.r8_above_3_up_6_fcy_resident = r8_above_3_up_6_fcy_resident;
	}
	public BigDecimal getR8_above_6_up_12_fcy_resident() {
		return r8_above_6_up_12_fcy_resident;
	}
	public void setR8_above_6_up_12_fcy_resident(BigDecimal r8_above_6_up_12_fcy_resident) {
		this.r8_above_6_up_12_fcy_resident = r8_above_6_up_12_fcy_resident;
	}
	public BigDecimal getR8_exc_12_mon_fcy_resident() {
		return r8_exc_12_mon_fcy_resident;
	}
	public void setR8_exc_12_mon_fcy_resident(BigDecimal r8_exc_12_mon_fcy_resident) {
		this.r8_exc_12_mon_fcy_resident = r8_exc_12_mon_fcy_resident;
	}
	public BigDecimal getR8_total_resident() {
		return r8_total_resident;
	}
	public void setR8_total_resident(BigDecimal r8_total_resident) {
		this.r8_total_resident = r8_total_resident;
	}
	public BigDecimal getR8_up_3_mon_aed_non_resident() {
		return r8_up_3_mon_aed_non_resident;
	}
	public void setR8_up_3_mon_aed_non_resident(BigDecimal r8_up_3_mon_aed_non_resident) {
		this.r8_up_3_mon_aed_non_resident = r8_up_3_mon_aed_non_resident;
	}
	public BigDecimal getR8_above_3_up_6_aed_non_resident() {
		return r8_above_3_up_6_aed_non_resident;
	}
	public void setR8_above_3_up_6_aed_non_resident(BigDecimal r8_above_3_up_6_aed_non_resident) {
		this.r8_above_3_up_6_aed_non_resident = r8_above_3_up_6_aed_non_resident;
	}
	public BigDecimal getR8_above_6_up_12_aed_non_resident() {
		return r8_above_6_up_12_aed_non_resident;
	}
	public void setR8_above_6_up_12_aed_non_resident(BigDecimal r8_above_6_up_12_aed_non_resident) {
		this.r8_above_6_up_12_aed_non_resident = r8_above_6_up_12_aed_non_resident;
	}
	public BigDecimal getR8_exc_12_mon_aed_non_resident() {
		return r8_exc_12_mon_aed_non_resident;
	}
	public void setR8_exc_12_mon_aed_non_resident(BigDecimal r8_exc_12_mon_aed_non_resident) {
		this.r8_exc_12_mon_aed_non_resident = r8_exc_12_mon_aed_non_resident;
	}
	public BigDecimal getR8_up_3_mon_fcy_non_resident() {
		return r8_up_3_mon_fcy_non_resident;
	}
	public void setR8_up_3_mon_fcy_non_resident(BigDecimal r8_up_3_mon_fcy_non_resident) {
		this.r8_up_3_mon_fcy_non_resident = r8_up_3_mon_fcy_non_resident;
	}
	public BigDecimal getR8_above_3_up_6_fcy_non_resident() {
		return r8_above_3_up_6_fcy_non_resident;
	}
	public void setR8_above_3_up_6_fcy_non_resident(BigDecimal r8_above_3_up_6_fcy_non_resident) {
		this.r8_above_3_up_6_fcy_non_resident = r8_above_3_up_6_fcy_non_resident;
	}
	public BigDecimal getR8_above_6_up_12_fcy_non_resident() {
		return r8_above_6_up_12_fcy_non_resident;
	}
	public void setR8_above_6_up_12_fcy_non_resident(BigDecimal r8_above_6_up_12_fcy_non_resident) {
		this.r8_above_6_up_12_fcy_non_resident = r8_above_6_up_12_fcy_non_resident;
	}
	public BigDecimal getR8_exc_12_mon_fcy_non_resident() {
		return r8_exc_12_mon_fcy_non_resident;
	}
	public void setR8_exc_12_mon_fcy_non_resident(BigDecimal r8_exc_12_mon_fcy_non_resident) {
		this.r8_exc_12_mon_fcy_non_resident = r8_exc_12_mon_fcy_non_resident;
	}
	public BigDecimal getR8_total_non_resident() {
		return r8_total_non_resident;
	}
	public void setR8_total_non_resident(BigDecimal r8_total_non_resident) {
		this.r8_total_non_resident = r8_total_non_resident;
	}
	public BigDecimal getR8_grand_total_amount() {
		return r8_grand_total_amount;
	}
	public void setR8_grand_total_amount(BigDecimal r8_grand_total_amount) {
		this.r8_grand_total_amount = r8_grand_total_amount;
	}
	public String getR9_product() {
		return r9_product;
	}
	public void setR9_product(String r9_product) {
		this.r9_product = r9_product;
	}
	public BigDecimal getR9_up_3_mon_aed_resident() {
		return r9_up_3_mon_aed_resident;
	}
	public void setR9_up_3_mon_aed_resident(BigDecimal r9_up_3_mon_aed_resident) {
		this.r9_up_3_mon_aed_resident = r9_up_3_mon_aed_resident;
	}
	public BigDecimal getR9_above_3_up_6_aed_resident() {
		return r9_above_3_up_6_aed_resident;
	}
	public void setR9_above_3_up_6_aed_resident(BigDecimal r9_above_3_up_6_aed_resident) {
		this.r9_above_3_up_6_aed_resident = r9_above_3_up_6_aed_resident;
	}
	public BigDecimal getR9_above_6_up_12_aed_resident() {
		return r9_above_6_up_12_aed_resident;
	}
	public void setR9_above_6_up_12_aed_resident(BigDecimal r9_above_6_up_12_aed_resident) {
		this.r9_above_6_up_12_aed_resident = r9_above_6_up_12_aed_resident;
	}
	public BigDecimal getR9_exc_12_mon_aed_resident() {
		return r9_exc_12_mon_aed_resident;
	}
	public void setR9_exc_12_mon_aed_resident(BigDecimal r9_exc_12_mon_aed_resident) {
		this.r9_exc_12_mon_aed_resident = r9_exc_12_mon_aed_resident;
	}
	public BigDecimal getR9_up_3_mon_fcy_resident() {
		return r9_up_3_mon_fcy_resident;
	}
	public void setR9_up_3_mon_fcy_resident(BigDecimal r9_up_3_mon_fcy_resident) {
		this.r9_up_3_mon_fcy_resident = r9_up_3_mon_fcy_resident;
	}
	public BigDecimal getR9_above_3_up_6_fcy_resident() {
		return r9_above_3_up_6_fcy_resident;
	}
	public void setR9_above_3_up_6_fcy_resident(BigDecimal r9_above_3_up_6_fcy_resident) {
		this.r9_above_3_up_6_fcy_resident = r9_above_3_up_6_fcy_resident;
	}
	public BigDecimal getR9_above_6_up_12_fcy_resident() {
		return r9_above_6_up_12_fcy_resident;
	}
	public void setR9_above_6_up_12_fcy_resident(BigDecimal r9_above_6_up_12_fcy_resident) {
		this.r9_above_6_up_12_fcy_resident = r9_above_6_up_12_fcy_resident;
	}
	public BigDecimal getR9_exc_12_mon_fcy_resident() {
		return r9_exc_12_mon_fcy_resident;
	}
	public void setR9_exc_12_mon_fcy_resident(BigDecimal r9_exc_12_mon_fcy_resident) {
		this.r9_exc_12_mon_fcy_resident = r9_exc_12_mon_fcy_resident;
	}
	public BigDecimal getR9_total_resident() {
		return r9_total_resident;
	}
	public void setR9_total_resident(BigDecimal r9_total_resident) {
		this.r9_total_resident = r9_total_resident;
	}
	public BigDecimal getR9_up_3_mon_aed_non_resident() {
		return r9_up_3_mon_aed_non_resident;
	}
	public void setR9_up_3_mon_aed_non_resident(BigDecimal r9_up_3_mon_aed_non_resident) {
		this.r9_up_3_mon_aed_non_resident = r9_up_3_mon_aed_non_resident;
	}
	public BigDecimal getR9_above_3_up_6_aed_non_resident() {
		return r9_above_3_up_6_aed_non_resident;
	}
	public void setR9_above_3_up_6_aed_non_resident(BigDecimal r9_above_3_up_6_aed_non_resident) {
		this.r9_above_3_up_6_aed_non_resident = r9_above_3_up_6_aed_non_resident;
	}
	public BigDecimal getR9_above_6_up_12_aed_non_resident() {
		return r9_above_6_up_12_aed_non_resident;
	}
	public void setR9_above_6_up_12_aed_non_resident(BigDecimal r9_above_6_up_12_aed_non_resident) {
		this.r9_above_6_up_12_aed_non_resident = r9_above_6_up_12_aed_non_resident;
	}
	public BigDecimal getR9_exc_12_mon_aed_non_resident() {
		return r9_exc_12_mon_aed_non_resident;
	}
	public void setR9_exc_12_mon_aed_non_resident(BigDecimal r9_exc_12_mon_aed_non_resident) {
		this.r9_exc_12_mon_aed_non_resident = r9_exc_12_mon_aed_non_resident;
	}
	public BigDecimal getR9_up_3_mon_fcy_non_resident() {
		return r9_up_3_mon_fcy_non_resident;
	}
	public void setR9_up_3_mon_fcy_non_resident(BigDecimal r9_up_3_mon_fcy_non_resident) {
		this.r9_up_3_mon_fcy_non_resident = r9_up_3_mon_fcy_non_resident;
	}
	public BigDecimal getR9_above_3_up_6_fcy_non_resident() {
		return r9_above_3_up_6_fcy_non_resident;
	}
	public void setR9_above_3_up_6_fcy_non_resident(BigDecimal r9_above_3_up_6_fcy_non_resident) {
		this.r9_above_3_up_6_fcy_non_resident = r9_above_3_up_6_fcy_non_resident;
	}
	public BigDecimal getR9_above_6_up_12_fcy_non_resident() {
		return r9_above_6_up_12_fcy_non_resident;
	}
	public void setR9_above_6_up_12_fcy_non_resident(BigDecimal r9_above_6_up_12_fcy_non_resident) {
		this.r9_above_6_up_12_fcy_non_resident = r9_above_6_up_12_fcy_non_resident;
	}
	public BigDecimal getR9_exc_12_mon_fcy_non_resident() {
		return r9_exc_12_mon_fcy_non_resident;
	}
	public void setR9_exc_12_mon_fcy_non_resident(BigDecimal r9_exc_12_mon_fcy_non_resident) {
		this.r9_exc_12_mon_fcy_non_resident = r9_exc_12_mon_fcy_non_resident;
	}
	public BigDecimal getR9_total_non_resident() {
		return r9_total_non_resident;
	}
	public void setR9_total_non_resident(BigDecimal r9_total_non_resident) {
		this.r9_total_non_resident = r9_total_non_resident;
	}
	public BigDecimal getR9_grand_total_amount() {
		return r9_grand_total_amount;
	}
	public void setR9_grand_total_amount(BigDecimal r9_grand_total_amount) {
		this.r9_grand_total_amount = r9_grand_total_amount;
	}
	public String getR10_product() {
		return r10_product;
	}
	public void setR10_product(String r10_product) {
		this.r10_product = r10_product;
	}
	public BigDecimal getR10_up_3_mon_aed_resident() {
		return r10_up_3_mon_aed_resident;
	}
	public void setR10_up_3_mon_aed_resident(BigDecimal r10_up_3_mon_aed_resident) {
		this.r10_up_3_mon_aed_resident = r10_up_3_mon_aed_resident;
	}
	public BigDecimal getR10_above_3_up_6_aed_resident() {
		return r10_above_3_up_6_aed_resident;
	}
	public void setR10_above_3_up_6_aed_resident(BigDecimal r10_above_3_up_6_aed_resident) {
		this.r10_above_3_up_6_aed_resident = r10_above_3_up_6_aed_resident;
	}
	public BigDecimal getR10_above_6_up_12_aed_resident() {
		return r10_above_6_up_12_aed_resident;
	}
	public void setR10_above_6_up_12_aed_resident(BigDecimal r10_above_6_up_12_aed_resident) {
		this.r10_above_6_up_12_aed_resident = r10_above_6_up_12_aed_resident;
	}
	public BigDecimal getR10_exc_12_mon_aed_resident() {
		return r10_exc_12_mon_aed_resident;
	}
	public void setR10_exc_12_mon_aed_resident(BigDecimal r10_exc_12_mon_aed_resident) {
		this.r10_exc_12_mon_aed_resident = r10_exc_12_mon_aed_resident;
	}
	public BigDecimal getR10_up_3_mon_fcy_resident() {
		return r10_up_3_mon_fcy_resident;
	}
	public void setR10_up_3_mon_fcy_resident(BigDecimal r10_up_3_mon_fcy_resident) {
		this.r10_up_3_mon_fcy_resident = r10_up_3_mon_fcy_resident;
	}
	public BigDecimal getR10_above_3_up_6_fcy_resident() {
		return r10_above_3_up_6_fcy_resident;
	}
	public void setR10_above_3_up_6_fcy_resident(BigDecimal r10_above_3_up_6_fcy_resident) {
		this.r10_above_3_up_6_fcy_resident = r10_above_3_up_6_fcy_resident;
	}
	public BigDecimal getR10_above_6_up_12_fcy_resident() {
		return r10_above_6_up_12_fcy_resident;
	}
	public void setR10_above_6_up_12_fcy_resident(BigDecimal r10_above_6_up_12_fcy_resident) {
		this.r10_above_6_up_12_fcy_resident = r10_above_6_up_12_fcy_resident;
	}
	public BigDecimal getR10_exc_12_mon_fcy_resident() {
		return r10_exc_12_mon_fcy_resident;
	}
	public void setR10_exc_12_mon_fcy_resident(BigDecimal r10_exc_12_mon_fcy_resident) {
		this.r10_exc_12_mon_fcy_resident = r10_exc_12_mon_fcy_resident;
	}
	public BigDecimal getR10_total_resident() {
		return r10_total_resident;
	}
	public void setR10_total_resident(BigDecimal r10_total_resident) {
		this.r10_total_resident = r10_total_resident;
	}
	public BigDecimal getR10_up_3_mon_aed_non_resident() {
		return r10_up_3_mon_aed_non_resident;
	}
	public void setR10_up_3_mon_aed_non_resident(BigDecimal r10_up_3_mon_aed_non_resident) {
		this.r10_up_3_mon_aed_non_resident = r10_up_3_mon_aed_non_resident;
	}
	public BigDecimal getR10_above_3_up_6_aed_non_resident() {
		return r10_above_3_up_6_aed_non_resident;
	}
	public void setR10_above_3_up_6_aed_non_resident(BigDecimal r10_above_3_up_6_aed_non_resident) {
		this.r10_above_3_up_6_aed_non_resident = r10_above_3_up_6_aed_non_resident;
	}
	public BigDecimal getR10_above_6_up_12_aed_non_resident() {
		return r10_above_6_up_12_aed_non_resident;
	}
	public void setR10_above_6_up_12_aed_non_resident(BigDecimal r10_above_6_up_12_aed_non_resident) {
		this.r10_above_6_up_12_aed_non_resident = r10_above_6_up_12_aed_non_resident;
	}
	public BigDecimal getR10_exc_12_mon_aed_non_resident() {
		return r10_exc_12_mon_aed_non_resident;
	}
	public void setR10_exc_12_mon_aed_non_resident(BigDecimal r10_exc_12_mon_aed_non_resident) {
		this.r10_exc_12_mon_aed_non_resident = r10_exc_12_mon_aed_non_resident;
	}
	public BigDecimal getR10_up_3_mon_fcy_non_resident() {
		return r10_up_3_mon_fcy_non_resident;
	}
	public void setR10_up_3_mon_fcy_non_resident(BigDecimal r10_up_3_mon_fcy_non_resident) {
		this.r10_up_3_mon_fcy_non_resident = r10_up_3_mon_fcy_non_resident;
	}
	public BigDecimal getR10_above_3_up_6_fcy_non_resident() {
		return r10_above_3_up_6_fcy_non_resident;
	}
	public void setR10_above_3_up_6_fcy_non_resident(BigDecimal r10_above_3_up_6_fcy_non_resident) {
		this.r10_above_3_up_6_fcy_non_resident = r10_above_3_up_6_fcy_non_resident;
	}
	public BigDecimal getR10_above_6_up_12_fcy_non_resident() {
		return r10_above_6_up_12_fcy_non_resident;
	}
	public void setR10_above_6_up_12_fcy_non_resident(BigDecimal r10_above_6_up_12_fcy_non_resident) {
		this.r10_above_6_up_12_fcy_non_resident = r10_above_6_up_12_fcy_non_resident;
	}
	public BigDecimal getR10_exc_12_mon_fcy_non_resident() {
		return r10_exc_12_mon_fcy_non_resident;
	}
	public void setR10_exc_12_mon_fcy_non_resident(BigDecimal r10_exc_12_mon_fcy_non_resident) {
		this.r10_exc_12_mon_fcy_non_resident = r10_exc_12_mon_fcy_non_resident;
	}
	public BigDecimal getR10_total_non_resident() {
		return r10_total_non_resident;
	}
	public void setR10_total_non_resident(BigDecimal r10_total_non_resident) {
		this.r10_total_non_resident = r10_total_non_resident;
	}
	public BigDecimal getR10_grand_total_amount() {
		return r10_grand_total_amount;
	}
	public void setR10_grand_total_amount(BigDecimal r10_grand_total_amount) {
		this.r10_grand_total_amount = r10_grand_total_amount;
	}
	public String getR11_product() {
		return r11_product;
	}
	public void setR11_product(String r11_product) {
		this.r11_product = r11_product;
	}
	public BigDecimal getR11_up_3_mon_aed_resident() {
		return r11_up_3_mon_aed_resident;
	}
	public void setR11_up_3_mon_aed_resident(BigDecimal r11_up_3_mon_aed_resident) {
		this.r11_up_3_mon_aed_resident = r11_up_3_mon_aed_resident;
	}
	public BigDecimal getR11_above_3_up_6_aed_resident() {
		return r11_above_3_up_6_aed_resident;
	}
	public void setR11_above_3_up_6_aed_resident(BigDecimal r11_above_3_up_6_aed_resident) {
		this.r11_above_3_up_6_aed_resident = r11_above_3_up_6_aed_resident;
	}
	public BigDecimal getR11_above_6_up_12_aed_resident() {
		return r11_above_6_up_12_aed_resident;
	}
	public void setR11_above_6_up_12_aed_resident(BigDecimal r11_above_6_up_12_aed_resident) {
		this.r11_above_6_up_12_aed_resident = r11_above_6_up_12_aed_resident;
	}
	public BigDecimal getR11_exc_12_mon_aed_resident() {
		return r11_exc_12_mon_aed_resident;
	}
	public void setR11_exc_12_mon_aed_resident(BigDecimal r11_exc_12_mon_aed_resident) {
		this.r11_exc_12_mon_aed_resident = r11_exc_12_mon_aed_resident;
	}
	public BigDecimal getR11_up_3_mon_fcy_resident() {
		return r11_up_3_mon_fcy_resident;
	}
	public void setR11_up_3_mon_fcy_resident(BigDecimal r11_up_3_mon_fcy_resident) {
		this.r11_up_3_mon_fcy_resident = r11_up_3_mon_fcy_resident;
	}
	public BigDecimal getR11_above_3_up_6_fcy_resident() {
		return r11_above_3_up_6_fcy_resident;
	}
	public void setR11_above_3_up_6_fcy_resident(BigDecimal r11_above_3_up_6_fcy_resident) {
		this.r11_above_3_up_6_fcy_resident = r11_above_3_up_6_fcy_resident;
	}
	public BigDecimal getR11_above_6_up_12_fcy_resident() {
		return r11_above_6_up_12_fcy_resident;
	}
	public void setR11_above_6_up_12_fcy_resident(BigDecimal r11_above_6_up_12_fcy_resident) {
		this.r11_above_6_up_12_fcy_resident = r11_above_6_up_12_fcy_resident;
	}
	public BigDecimal getR11_exc_12_mon_fcy_resident() {
		return r11_exc_12_mon_fcy_resident;
	}
	public void setR11_exc_12_mon_fcy_resident(BigDecimal r11_exc_12_mon_fcy_resident) {
		this.r11_exc_12_mon_fcy_resident = r11_exc_12_mon_fcy_resident;
	}
	public BigDecimal getR11_total_resident() {
		return r11_total_resident;
	}
	public void setR11_total_resident(BigDecimal r11_total_resident) {
		this.r11_total_resident = r11_total_resident;
	}
	public BigDecimal getR11_up_3_mon_aed_non_resident() {
		return r11_up_3_mon_aed_non_resident;
	}
	public void setR11_up_3_mon_aed_non_resident(BigDecimal r11_up_3_mon_aed_non_resident) {
		this.r11_up_3_mon_aed_non_resident = r11_up_3_mon_aed_non_resident;
	}
	public BigDecimal getR11_above_3_up_6_aed_non_resident() {
		return r11_above_3_up_6_aed_non_resident;
	}
	public void setR11_above_3_up_6_aed_non_resident(BigDecimal r11_above_3_up_6_aed_non_resident) {
		this.r11_above_3_up_6_aed_non_resident = r11_above_3_up_6_aed_non_resident;
	}
	public BigDecimal getR11_above_6_up_12_aed_non_resident() {
		return r11_above_6_up_12_aed_non_resident;
	}
	public void setR11_above_6_up_12_aed_non_resident(BigDecimal r11_above_6_up_12_aed_non_resident) {
		this.r11_above_6_up_12_aed_non_resident = r11_above_6_up_12_aed_non_resident;
	}
	public BigDecimal getR11_exc_12_mon_aed_non_resident() {
		return r11_exc_12_mon_aed_non_resident;
	}
	public void setR11_exc_12_mon_aed_non_resident(BigDecimal r11_exc_12_mon_aed_non_resident) {
		this.r11_exc_12_mon_aed_non_resident = r11_exc_12_mon_aed_non_resident;
	}
	public BigDecimal getR11_up_3_mon_fcy_non_resident() {
		return r11_up_3_mon_fcy_non_resident;
	}
	public void setR11_up_3_mon_fcy_non_resident(BigDecimal r11_up_3_mon_fcy_non_resident) {
		this.r11_up_3_mon_fcy_non_resident = r11_up_3_mon_fcy_non_resident;
	}
	public BigDecimal getR11_above_3_up_6_fcy_non_resident() {
		return r11_above_3_up_6_fcy_non_resident;
	}
	public void setR11_above_3_up_6_fcy_non_resident(BigDecimal r11_above_3_up_6_fcy_non_resident) {
		this.r11_above_3_up_6_fcy_non_resident = r11_above_3_up_6_fcy_non_resident;
	}
	public BigDecimal getR11_above_6_up_12_fcy_non_resident() {
		return r11_above_6_up_12_fcy_non_resident;
	}
	public void setR11_above_6_up_12_fcy_non_resident(BigDecimal r11_above_6_up_12_fcy_non_resident) {
		this.r11_above_6_up_12_fcy_non_resident = r11_above_6_up_12_fcy_non_resident;
	}
	public BigDecimal getR11_exc_12_mon_fcy_non_resident() {
		return r11_exc_12_mon_fcy_non_resident;
	}
	public void setR11_exc_12_mon_fcy_non_resident(BigDecimal r11_exc_12_mon_fcy_non_resident) {
		this.r11_exc_12_mon_fcy_non_resident = r11_exc_12_mon_fcy_non_resident;
	}
	public BigDecimal getR11_total_non_resident() {
		return r11_total_non_resident;
	}
	public void setR11_total_non_resident(BigDecimal r11_total_non_resident) {
		this.r11_total_non_resident = r11_total_non_resident;
	}
	public BigDecimal getR11_grand_total_amount() {
		return r11_grand_total_amount;
	}
	public void setR11_grand_total_amount(BigDecimal r11_grand_total_amount) {
		this.r11_grand_total_amount = r11_grand_total_amount;
	}
	public String getR12_product() {
		return r12_product;
	}
	public void setR12_product(String r12_product) {
		this.r12_product = r12_product;
	}
	public BigDecimal getR12_up_3_mon_aed_resident() {
		return r12_up_3_mon_aed_resident;
	}
	public void setR12_up_3_mon_aed_resident(BigDecimal r12_up_3_mon_aed_resident) {
		this.r12_up_3_mon_aed_resident = r12_up_3_mon_aed_resident;
	}
	public BigDecimal getR12_above_3_up_6_aed_resident() {
		return r12_above_3_up_6_aed_resident;
	}
	public void setR12_above_3_up_6_aed_resident(BigDecimal r12_above_3_up_6_aed_resident) {
		this.r12_above_3_up_6_aed_resident = r12_above_3_up_6_aed_resident;
	}
	public BigDecimal getR12_above_6_up_12_aed_resident() {
		return r12_above_6_up_12_aed_resident;
	}
	public void setR12_above_6_up_12_aed_resident(BigDecimal r12_above_6_up_12_aed_resident) {
		this.r12_above_6_up_12_aed_resident = r12_above_6_up_12_aed_resident;
	}
	public BigDecimal getR12_exc_12_mon_aed_resident() {
		return r12_exc_12_mon_aed_resident;
	}
	public void setR12_exc_12_mon_aed_resident(BigDecimal r12_exc_12_mon_aed_resident) {
		this.r12_exc_12_mon_aed_resident = r12_exc_12_mon_aed_resident;
	}
	public BigDecimal getR12_up_3_mon_fcy_resident() {
		return r12_up_3_mon_fcy_resident;
	}
	public void setR12_up_3_mon_fcy_resident(BigDecimal r12_up_3_mon_fcy_resident) {
		this.r12_up_3_mon_fcy_resident = r12_up_3_mon_fcy_resident;
	}
	public BigDecimal getR12_above_3_up_6_fcy_resident() {
		return r12_above_3_up_6_fcy_resident;
	}
	public void setR12_above_3_up_6_fcy_resident(BigDecimal r12_above_3_up_6_fcy_resident) {
		this.r12_above_3_up_6_fcy_resident = r12_above_3_up_6_fcy_resident;
	}
	public BigDecimal getR12_above_6_up_12_fcy_resident() {
		return r12_above_6_up_12_fcy_resident;
	}
	public void setR12_above_6_up_12_fcy_resident(BigDecimal r12_above_6_up_12_fcy_resident) {
		this.r12_above_6_up_12_fcy_resident = r12_above_6_up_12_fcy_resident;
	}
	public BigDecimal getR12_exc_12_mon_fcy_resident() {
		return r12_exc_12_mon_fcy_resident;
	}
	public void setR12_exc_12_mon_fcy_resident(BigDecimal r12_exc_12_mon_fcy_resident) {
		this.r12_exc_12_mon_fcy_resident = r12_exc_12_mon_fcy_resident;
	}
	public BigDecimal getR12_total_resident() {
		return r12_total_resident;
	}
	public void setR12_total_resident(BigDecimal r12_total_resident) {
		this.r12_total_resident = r12_total_resident;
	}
	public BigDecimal getR12_up_3_mon_aed_non_resident() {
		return r12_up_3_mon_aed_non_resident;
	}
	public void setR12_up_3_mon_aed_non_resident(BigDecimal r12_up_3_mon_aed_non_resident) {
		this.r12_up_3_mon_aed_non_resident = r12_up_3_mon_aed_non_resident;
	}
	public BigDecimal getR12_above_3_up_6_aed_non_resident() {
		return r12_above_3_up_6_aed_non_resident;
	}
	public void setR12_above_3_up_6_aed_non_resident(BigDecimal r12_above_3_up_6_aed_non_resident) {
		this.r12_above_3_up_6_aed_non_resident = r12_above_3_up_6_aed_non_resident;
	}
	public BigDecimal getR12_above_6_up_12_aed_non_resident() {
		return r12_above_6_up_12_aed_non_resident;
	}
	public void setR12_above_6_up_12_aed_non_resident(BigDecimal r12_above_6_up_12_aed_non_resident) {
		this.r12_above_6_up_12_aed_non_resident = r12_above_6_up_12_aed_non_resident;
	}
	public BigDecimal getR12_exc_12_mon_aed_non_resident() {
		return r12_exc_12_mon_aed_non_resident;
	}
	public void setR12_exc_12_mon_aed_non_resident(BigDecimal r12_exc_12_mon_aed_non_resident) {
		this.r12_exc_12_mon_aed_non_resident = r12_exc_12_mon_aed_non_resident;
	}
	public BigDecimal getR12_up_3_mon_fcy_non_resident() {
		return r12_up_3_mon_fcy_non_resident;
	}
	public void setR12_up_3_mon_fcy_non_resident(BigDecimal r12_up_3_mon_fcy_non_resident) {
		this.r12_up_3_mon_fcy_non_resident = r12_up_3_mon_fcy_non_resident;
	}
	public BigDecimal getR12_above_3_up_6_fcy_non_resident() {
		return r12_above_3_up_6_fcy_non_resident;
	}
	public void setR12_above_3_up_6_fcy_non_resident(BigDecimal r12_above_3_up_6_fcy_non_resident) {
		this.r12_above_3_up_6_fcy_non_resident = r12_above_3_up_6_fcy_non_resident;
	}
	public BigDecimal getR12_above_6_up_12_fcy_non_resident() {
		return r12_above_6_up_12_fcy_non_resident;
	}
	public void setR12_above_6_up_12_fcy_non_resident(BigDecimal r12_above_6_up_12_fcy_non_resident) {
		this.r12_above_6_up_12_fcy_non_resident = r12_above_6_up_12_fcy_non_resident;
	}
	public BigDecimal getR12_exc_12_mon_fcy_non_resident() {
		return r12_exc_12_mon_fcy_non_resident;
	}
	public void setR12_exc_12_mon_fcy_non_resident(BigDecimal r12_exc_12_mon_fcy_non_resident) {
		this.r12_exc_12_mon_fcy_non_resident = r12_exc_12_mon_fcy_non_resident;
	}
	public BigDecimal getR12_total_non_resident() {
		return r12_total_non_resident;
	}
	public void setR12_total_non_resident(BigDecimal r12_total_non_resident) {
		this.r12_total_non_resident = r12_total_non_resident;
	}
	public BigDecimal getR12_grand_total_amount() {
		return r12_grand_total_amount;
	}
	public void setR12_grand_total_amount(BigDecimal r12_grand_total_amount) {
		this.r12_grand_total_amount = r12_grand_total_amount;
	}
	public String getR13_product() {
		return r13_product;
	}
	public void setR13_product(String r13_product) {
		this.r13_product = r13_product;
	}
	public BigDecimal getR13_up_3_mon_aed_resident() {
		return r13_up_3_mon_aed_resident;
	}
	public void setR13_up_3_mon_aed_resident(BigDecimal r13_up_3_mon_aed_resident) {
		this.r13_up_3_mon_aed_resident = r13_up_3_mon_aed_resident;
	}
	public BigDecimal getR13_above_3_up_6_aed_resident() {
		return r13_above_3_up_6_aed_resident;
	}
	public void setR13_above_3_up_6_aed_resident(BigDecimal r13_above_3_up_6_aed_resident) {
		this.r13_above_3_up_6_aed_resident = r13_above_3_up_6_aed_resident;
	}
	public BigDecimal getR13_above_6_up_12_aed_resident() {
		return r13_above_6_up_12_aed_resident;
	}
	public void setR13_above_6_up_12_aed_resident(BigDecimal r13_above_6_up_12_aed_resident) {
		this.r13_above_6_up_12_aed_resident = r13_above_6_up_12_aed_resident;
	}
	public BigDecimal getR13_exc_12_mon_aed_resident() {
		return r13_exc_12_mon_aed_resident;
	}
	public void setR13_exc_12_mon_aed_resident(BigDecimal r13_exc_12_mon_aed_resident) {
		this.r13_exc_12_mon_aed_resident = r13_exc_12_mon_aed_resident;
	}
	public BigDecimal getR13_up_3_mon_fcy_resident() {
		return r13_up_3_mon_fcy_resident;
	}
	public void setR13_up_3_mon_fcy_resident(BigDecimal r13_up_3_mon_fcy_resident) {
		this.r13_up_3_mon_fcy_resident = r13_up_3_mon_fcy_resident;
	}
	public BigDecimal getR13_above_3_up_6_fcy_resident() {
		return r13_above_3_up_6_fcy_resident;
	}
	public void setR13_above_3_up_6_fcy_resident(BigDecimal r13_above_3_up_6_fcy_resident) {
		this.r13_above_3_up_6_fcy_resident = r13_above_3_up_6_fcy_resident;
	}
	public BigDecimal getR13_above_6_up_12_fcy_resident() {
		return r13_above_6_up_12_fcy_resident;
	}
	public void setR13_above_6_up_12_fcy_resident(BigDecimal r13_above_6_up_12_fcy_resident) {
		this.r13_above_6_up_12_fcy_resident = r13_above_6_up_12_fcy_resident;
	}
	public BigDecimal getR13_exc_12_mon_fcy_resident() {
		return r13_exc_12_mon_fcy_resident;
	}
	public void setR13_exc_12_mon_fcy_resident(BigDecimal r13_exc_12_mon_fcy_resident) {
		this.r13_exc_12_mon_fcy_resident = r13_exc_12_mon_fcy_resident;
	}
	public BigDecimal getR13_total_resident() {
		return r13_total_resident;
	}
	public void setR13_total_resident(BigDecimal r13_total_resident) {
		this.r13_total_resident = r13_total_resident;
	}
	public BigDecimal getR13_up_3_mon_aed_non_resident() {
		return r13_up_3_mon_aed_non_resident;
	}
	public void setR13_up_3_mon_aed_non_resident(BigDecimal r13_up_3_mon_aed_non_resident) {
		this.r13_up_3_mon_aed_non_resident = r13_up_3_mon_aed_non_resident;
	}
	public BigDecimal getR13_above_3_up_6_aed_non_resident() {
		return r13_above_3_up_6_aed_non_resident;
	}
	public void setR13_above_3_up_6_aed_non_resident(BigDecimal r13_above_3_up_6_aed_non_resident) {
		this.r13_above_3_up_6_aed_non_resident = r13_above_3_up_6_aed_non_resident;
	}
	public BigDecimal getR13_above_6_up_12_aed_non_resident() {
		return r13_above_6_up_12_aed_non_resident;
	}
	public void setR13_above_6_up_12_aed_non_resident(BigDecimal r13_above_6_up_12_aed_non_resident) {
		this.r13_above_6_up_12_aed_non_resident = r13_above_6_up_12_aed_non_resident;
	}
	public BigDecimal getR13_exc_12_mon_aed_non_resident() {
		return r13_exc_12_mon_aed_non_resident;
	}
	public void setR13_exc_12_mon_aed_non_resident(BigDecimal r13_exc_12_mon_aed_non_resident) {
		this.r13_exc_12_mon_aed_non_resident = r13_exc_12_mon_aed_non_resident;
	}
	public BigDecimal getR13_up_3_mon_fcy_non_resident() {
		return r13_up_3_mon_fcy_non_resident;
	}
	public void setR13_up_3_mon_fcy_non_resident(BigDecimal r13_up_3_mon_fcy_non_resident) {
		this.r13_up_3_mon_fcy_non_resident = r13_up_3_mon_fcy_non_resident;
	}
	public BigDecimal getR13_above_3_up_6_fcy_non_resident() {
		return r13_above_3_up_6_fcy_non_resident;
	}
	public void setR13_above_3_up_6_fcy_non_resident(BigDecimal r13_above_3_up_6_fcy_non_resident) {
		this.r13_above_3_up_6_fcy_non_resident = r13_above_3_up_6_fcy_non_resident;
	}
	public BigDecimal getR13_above_6_up_12_fcy_non_resident() {
		return r13_above_6_up_12_fcy_non_resident;
	}
	public void setR13_above_6_up_12_fcy_non_resident(BigDecimal r13_above_6_up_12_fcy_non_resident) {
		this.r13_above_6_up_12_fcy_non_resident = r13_above_6_up_12_fcy_non_resident;
	}
	public BigDecimal getR13_exc_12_mon_fcy_non_resident() {
		return r13_exc_12_mon_fcy_non_resident;
	}
	public void setR13_exc_12_mon_fcy_non_resident(BigDecimal r13_exc_12_mon_fcy_non_resident) {
		this.r13_exc_12_mon_fcy_non_resident = r13_exc_12_mon_fcy_non_resident;
	}
	public BigDecimal getR13_total_non_resident() {
		return r13_total_non_resident;
	}
	public void setR13_total_non_resident(BigDecimal r13_total_non_resident) {
		this.r13_total_non_resident = r13_total_non_resident;
	}
	public BigDecimal getR13_grand_total_amount() {
		return r13_grand_total_amount;
	}
	public void setR13_grand_total_amount(BigDecimal r13_grand_total_amount) {
		this.r13_grand_total_amount = r13_grand_total_amount;
	}
	public String getR14_product() {
		return r14_product;
	}
	public void setR14_product(String r14_product) {
		this.r14_product = r14_product;
	}
	public BigDecimal getR14_up_3_mon_aed_resident() {
		return r14_up_3_mon_aed_resident;
	}
	public void setR14_up_3_mon_aed_resident(BigDecimal r14_up_3_mon_aed_resident) {
		this.r14_up_3_mon_aed_resident = r14_up_3_mon_aed_resident;
	}
	public BigDecimal getR14_above_3_up_6_aed_resident() {
		return r14_above_3_up_6_aed_resident;
	}
	public void setR14_above_3_up_6_aed_resident(BigDecimal r14_above_3_up_6_aed_resident) {
		this.r14_above_3_up_6_aed_resident = r14_above_3_up_6_aed_resident;
	}
	public BigDecimal getR14_above_6_up_12_aed_resident() {
		return r14_above_6_up_12_aed_resident;
	}
	public void setR14_above_6_up_12_aed_resident(BigDecimal r14_above_6_up_12_aed_resident) {
		this.r14_above_6_up_12_aed_resident = r14_above_6_up_12_aed_resident;
	}
	public BigDecimal getR14_exc_12_mon_aed_resident() {
		return r14_exc_12_mon_aed_resident;
	}
	public void setR14_exc_12_mon_aed_resident(BigDecimal r14_exc_12_mon_aed_resident) {
		this.r14_exc_12_mon_aed_resident = r14_exc_12_mon_aed_resident;
	}
	public BigDecimal getR14_up_3_mon_fcy_resident() {
		return r14_up_3_mon_fcy_resident;
	}
	public void setR14_up_3_mon_fcy_resident(BigDecimal r14_up_3_mon_fcy_resident) {
		this.r14_up_3_mon_fcy_resident = r14_up_3_mon_fcy_resident;
	}
	public BigDecimal getR14_above_3_up_6_fcy_resident() {
		return r14_above_3_up_6_fcy_resident;
	}
	public void setR14_above_3_up_6_fcy_resident(BigDecimal r14_above_3_up_6_fcy_resident) {
		this.r14_above_3_up_6_fcy_resident = r14_above_3_up_6_fcy_resident;
	}
	public BigDecimal getR14_above_6_up_12_fcy_resident() {
		return r14_above_6_up_12_fcy_resident;
	}
	public void setR14_above_6_up_12_fcy_resident(BigDecimal r14_above_6_up_12_fcy_resident) {
		this.r14_above_6_up_12_fcy_resident = r14_above_6_up_12_fcy_resident;
	}
	public BigDecimal getR14_exc_12_mon_fcy_resident() {
		return r14_exc_12_mon_fcy_resident;
	}
	public void setR14_exc_12_mon_fcy_resident(BigDecimal r14_exc_12_mon_fcy_resident) {
		this.r14_exc_12_mon_fcy_resident = r14_exc_12_mon_fcy_resident;
	}
	public BigDecimal getR14_total_resident() {
		return r14_total_resident;
	}
	public void setR14_total_resident(BigDecimal r14_total_resident) {
		this.r14_total_resident = r14_total_resident;
	}
	public BigDecimal getR14_up_3_mon_aed_non_resident() {
		return r14_up_3_mon_aed_non_resident;
	}
	public void setR14_up_3_mon_aed_non_resident(BigDecimal r14_up_3_mon_aed_non_resident) {
		this.r14_up_3_mon_aed_non_resident = r14_up_3_mon_aed_non_resident;
	}
	public BigDecimal getR14_above_3_up_6_aed_non_resident() {
		return r14_above_3_up_6_aed_non_resident;
	}
	public void setR14_above_3_up_6_aed_non_resident(BigDecimal r14_above_3_up_6_aed_non_resident) {
		this.r14_above_3_up_6_aed_non_resident = r14_above_3_up_6_aed_non_resident;
	}
	public BigDecimal getR14_above_6_up_12_aed_non_resident() {
		return r14_above_6_up_12_aed_non_resident;
	}
	public void setR14_above_6_up_12_aed_non_resident(BigDecimal r14_above_6_up_12_aed_non_resident) {
		this.r14_above_6_up_12_aed_non_resident = r14_above_6_up_12_aed_non_resident;
	}
	public BigDecimal getR14_exc_12_mon_aed_non_resident() {
		return r14_exc_12_mon_aed_non_resident;
	}
	public void setR14_exc_12_mon_aed_non_resident(BigDecimal r14_exc_12_mon_aed_non_resident) {
		this.r14_exc_12_mon_aed_non_resident = r14_exc_12_mon_aed_non_resident;
	}
	public BigDecimal getR14_up_3_mon_fcy_non_resident() {
		return r14_up_3_mon_fcy_non_resident;
	}
	public void setR14_up_3_mon_fcy_non_resident(BigDecimal r14_up_3_mon_fcy_non_resident) {
		this.r14_up_3_mon_fcy_non_resident = r14_up_3_mon_fcy_non_resident;
	}
	public BigDecimal getR14_above_3_up_6_fcy_non_resident() {
		return r14_above_3_up_6_fcy_non_resident;
	}
	public void setR14_above_3_up_6_fcy_non_resident(BigDecimal r14_above_3_up_6_fcy_non_resident) {
		this.r14_above_3_up_6_fcy_non_resident = r14_above_3_up_6_fcy_non_resident;
	}
	public BigDecimal getR14_above_6_up_12_fcy_non_resident() {
		return r14_above_6_up_12_fcy_non_resident;
	}
	public void setR14_above_6_up_12_fcy_non_resident(BigDecimal r14_above_6_up_12_fcy_non_resident) {
		this.r14_above_6_up_12_fcy_non_resident = r14_above_6_up_12_fcy_non_resident;
	}
	public BigDecimal getR14_exc_12_mon_fcy_non_resident() {
		return r14_exc_12_mon_fcy_non_resident;
	}
	public void setR14_exc_12_mon_fcy_non_resident(BigDecimal r14_exc_12_mon_fcy_non_resident) {
		this.r14_exc_12_mon_fcy_non_resident = r14_exc_12_mon_fcy_non_resident;
	}
	public BigDecimal getR14_total_non_resident() {
		return r14_total_non_resident;
	}
	public void setR14_total_non_resident(BigDecimal r14_total_non_resident) {
		this.r14_total_non_resident = r14_total_non_resident;
	}
	public BigDecimal getR14_grand_total_amount() {
		return r14_grand_total_amount;
	}
	public void setR14_grand_total_amount(BigDecimal r14_grand_total_amount) {
		this.r14_grand_total_amount = r14_grand_total_amount;
	}
	public String getR15_product() {
		return r15_product;
	}
	public void setR15_product(String r15_product) {
		this.r15_product = r15_product;
	}
	public BigDecimal getR15_up_3_mon_aed_resident() {
		return r15_up_3_mon_aed_resident;
	}
	public void setR15_up_3_mon_aed_resident(BigDecimal r15_up_3_mon_aed_resident) {
		this.r15_up_3_mon_aed_resident = r15_up_3_mon_aed_resident;
	}
	public BigDecimal getR15_above_3_up_6_aed_resident() {
		return r15_above_3_up_6_aed_resident;
	}
	public void setR15_above_3_up_6_aed_resident(BigDecimal r15_above_3_up_6_aed_resident) {
		this.r15_above_3_up_6_aed_resident = r15_above_3_up_6_aed_resident;
	}
	public BigDecimal getR15_above_6_up_12_aed_resident() {
		return r15_above_6_up_12_aed_resident;
	}
	public void setR15_above_6_up_12_aed_resident(BigDecimal r15_above_6_up_12_aed_resident) {
		this.r15_above_6_up_12_aed_resident = r15_above_6_up_12_aed_resident;
	}
	public BigDecimal getR15_exc_12_mon_aed_resident() {
		return r15_exc_12_mon_aed_resident;
	}
	public void setR15_exc_12_mon_aed_resident(BigDecimal r15_exc_12_mon_aed_resident) {
		this.r15_exc_12_mon_aed_resident = r15_exc_12_mon_aed_resident;
	}
	public BigDecimal getR15_up_3_mon_fcy_resident() {
		return r15_up_3_mon_fcy_resident;
	}
	public void setR15_up_3_mon_fcy_resident(BigDecimal r15_up_3_mon_fcy_resident) {
		this.r15_up_3_mon_fcy_resident = r15_up_3_mon_fcy_resident;
	}
	public BigDecimal getR15_above_3_up_6_fcy_resident() {
		return r15_above_3_up_6_fcy_resident;
	}
	public void setR15_above_3_up_6_fcy_resident(BigDecimal r15_above_3_up_6_fcy_resident) {
		this.r15_above_3_up_6_fcy_resident = r15_above_3_up_6_fcy_resident;
	}
	public BigDecimal getR15_above_6_up_12_fcy_resident() {
		return r15_above_6_up_12_fcy_resident;
	}
	public void setR15_above_6_up_12_fcy_resident(BigDecimal r15_above_6_up_12_fcy_resident) {
		this.r15_above_6_up_12_fcy_resident = r15_above_6_up_12_fcy_resident;
	}
	public BigDecimal getR15_exc_12_mon_fcy_resident() {
		return r15_exc_12_mon_fcy_resident;
	}
	public void setR15_exc_12_mon_fcy_resident(BigDecimal r15_exc_12_mon_fcy_resident) {
		this.r15_exc_12_mon_fcy_resident = r15_exc_12_mon_fcy_resident;
	}
	public BigDecimal getR15_total_resident() {
		return r15_total_resident;
	}
	public void setR15_total_resident(BigDecimal r15_total_resident) {
		this.r15_total_resident = r15_total_resident;
	}
	public BigDecimal getR15_up_3_mon_aed_non_resident() {
		return r15_up_3_mon_aed_non_resident;
	}
	public void setR15_up_3_mon_aed_non_resident(BigDecimal r15_up_3_mon_aed_non_resident) {
		this.r15_up_3_mon_aed_non_resident = r15_up_3_mon_aed_non_resident;
	}
	public BigDecimal getR15_above_3_up_6_aed_non_resident() {
		return r15_above_3_up_6_aed_non_resident;
	}
	public void setR15_above_3_up_6_aed_non_resident(BigDecimal r15_above_3_up_6_aed_non_resident) {
		this.r15_above_3_up_6_aed_non_resident = r15_above_3_up_6_aed_non_resident;
	}
	public BigDecimal getR15_above_6_up_12_aed_non_resident() {
		return r15_above_6_up_12_aed_non_resident;
	}
	public void setR15_above_6_up_12_aed_non_resident(BigDecimal r15_above_6_up_12_aed_non_resident) {
		this.r15_above_6_up_12_aed_non_resident = r15_above_6_up_12_aed_non_resident;
	}
	public BigDecimal getR15_exc_12_mon_aed_non_resident() {
		return r15_exc_12_mon_aed_non_resident;
	}
	public void setR15_exc_12_mon_aed_non_resident(BigDecimal r15_exc_12_mon_aed_non_resident) {
		this.r15_exc_12_mon_aed_non_resident = r15_exc_12_mon_aed_non_resident;
	}
	public BigDecimal getR15_up_3_mon_fcy_non_resident() {
		return r15_up_3_mon_fcy_non_resident;
	}
	public void setR15_up_3_mon_fcy_non_resident(BigDecimal r15_up_3_mon_fcy_non_resident) {
		this.r15_up_3_mon_fcy_non_resident = r15_up_3_mon_fcy_non_resident;
	}
	public BigDecimal getR15_above_3_up_6_fcy_non_resident() {
		return r15_above_3_up_6_fcy_non_resident;
	}
	public void setR15_above_3_up_6_fcy_non_resident(BigDecimal r15_above_3_up_6_fcy_non_resident) {
		this.r15_above_3_up_6_fcy_non_resident = r15_above_3_up_6_fcy_non_resident;
	}
	public BigDecimal getR15_above_6_up_12_fcy_non_resident() {
		return r15_above_6_up_12_fcy_non_resident;
	}
	public void setR15_above_6_up_12_fcy_non_resident(BigDecimal r15_above_6_up_12_fcy_non_resident) {
		this.r15_above_6_up_12_fcy_non_resident = r15_above_6_up_12_fcy_non_resident;
	}
	public BigDecimal getR15_exc_12_mon_fcy_non_resident() {
		return r15_exc_12_mon_fcy_non_resident;
	}
	public void setR15_exc_12_mon_fcy_non_resident(BigDecimal r15_exc_12_mon_fcy_non_resident) {
		this.r15_exc_12_mon_fcy_non_resident = r15_exc_12_mon_fcy_non_resident;
	}
	public BigDecimal getR15_total_non_resident() {
		return r15_total_non_resident;
	}
	public void setR15_total_non_resident(BigDecimal r15_total_non_resident) {
		this.r15_total_non_resident = r15_total_non_resident;
	}
	public BigDecimal getR15_grand_total_amount() {
		return r15_grand_total_amount;
	}
	public void setR15_grand_total_amount(BigDecimal r15_grand_total_amount) {
		this.r15_grand_total_amount = r15_grand_total_amount;
	}
	public String getR16_product() {
		return r16_product;
	}
	public void setR16_product(String r16_product) {
		this.r16_product = r16_product;
	}
	public BigDecimal getR16_up_3_mon_aed_resident() {
		return r16_up_3_mon_aed_resident;
	}
	public void setR16_up_3_mon_aed_resident(BigDecimal r16_up_3_mon_aed_resident) {
		this.r16_up_3_mon_aed_resident = r16_up_3_mon_aed_resident;
	}
	public BigDecimal getR16_above_3_up_6_aed_resident() {
		return r16_above_3_up_6_aed_resident;
	}
	public void setR16_above_3_up_6_aed_resident(BigDecimal r16_above_3_up_6_aed_resident) {
		this.r16_above_3_up_6_aed_resident = r16_above_3_up_6_aed_resident;
	}
	public BigDecimal getR16_above_6_up_12_aed_resident() {
		return r16_above_6_up_12_aed_resident;
	}
	public void setR16_above_6_up_12_aed_resident(BigDecimal r16_above_6_up_12_aed_resident) {
		this.r16_above_6_up_12_aed_resident = r16_above_6_up_12_aed_resident;
	}
	public BigDecimal getR16_exc_12_mon_aed_resident() {
		return r16_exc_12_mon_aed_resident;
	}
	public void setR16_exc_12_mon_aed_resident(BigDecimal r16_exc_12_mon_aed_resident) {
		this.r16_exc_12_mon_aed_resident = r16_exc_12_mon_aed_resident;
	}
	public BigDecimal getR16_up_3_mon_fcy_resident() {
		return r16_up_3_mon_fcy_resident;
	}
	public void setR16_up_3_mon_fcy_resident(BigDecimal r16_up_3_mon_fcy_resident) {
		this.r16_up_3_mon_fcy_resident = r16_up_3_mon_fcy_resident;
	}
	public BigDecimal getR16_above_3_up_6_fcy_resident() {
		return r16_above_3_up_6_fcy_resident;
	}
	public void setR16_above_3_up_6_fcy_resident(BigDecimal r16_above_3_up_6_fcy_resident) {
		this.r16_above_3_up_6_fcy_resident = r16_above_3_up_6_fcy_resident;
	}
	public BigDecimal getR16_above_6_up_12_fcy_resident() {
		return r16_above_6_up_12_fcy_resident;
	}
	public void setR16_above_6_up_12_fcy_resident(BigDecimal r16_above_6_up_12_fcy_resident) {
		this.r16_above_6_up_12_fcy_resident = r16_above_6_up_12_fcy_resident;
	}
	public BigDecimal getR16_exc_12_mon_fcy_resident() {
		return r16_exc_12_mon_fcy_resident;
	}
	public void setR16_exc_12_mon_fcy_resident(BigDecimal r16_exc_12_mon_fcy_resident) {
		this.r16_exc_12_mon_fcy_resident = r16_exc_12_mon_fcy_resident;
	}
	public BigDecimal getR16_total_resident() {
		return r16_total_resident;
	}
	public void setR16_total_resident(BigDecimal r16_total_resident) {
		this.r16_total_resident = r16_total_resident;
	}
	public BigDecimal getR16_up_3_mon_aed_non_resident() {
		return r16_up_3_mon_aed_non_resident;
	}
	public void setR16_up_3_mon_aed_non_resident(BigDecimal r16_up_3_mon_aed_non_resident) {
		this.r16_up_3_mon_aed_non_resident = r16_up_3_mon_aed_non_resident;
	}
	public BigDecimal getR16_above_3_up_6_aed_non_resident() {
		return r16_above_3_up_6_aed_non_resident;
	}
	public void setR16_above_3_up_6_aed_non_resident(BigDecimal r16_above_3_up_6_aed_non_resident) {
		this.r16_above_3_up_6_aed_non_resident = r16_above_3_up_6_aed_non_resident;
	}
	public BigDecimal getR16_above_6_up_12_aed_non_resident() {
		return r16_above_6_up_12_aed_non_resident;
	}
	public void setR16_above_6_up_12_aed_non_resident(BigDecimal r16_above_6_up_12_aed_non_resident) {
		this.r16_above_6_up_12_aed_non_resident = r16_above_6_up_12_aed_non_resident;
	}
	public BigDecimal getR16_exc_12_mon_aed_non_resident() {
		return r16_exc_12_mon_aed_non_resident;
	}
	public void setR16_exc_12_mon_aed_non_resident(BigDecimal r16_exc_12_mon_aed_non_resident) {
		this.r16_exc_12_mon_aed_non_resident = r16_exc_12_mon_aed_non_resident;
	}
	public BigDecimal getR16_up_3_mon_fcy_non_resident() {
		return r16_up_3_mon_fcy_non_resident;
	}
	public void setR16_up_3_mon_fcy_non_resident(BigDecimal r16_up_3_mon_fcy_non_resident) {
		this.r16_up_3_mon_fcy_non_resident = r16_up_3_mon_fcy_non_resident;
	}
	public BigDecimal getR16_above_3_up_6_fcy_non_resident() {
		return r16_above_3_up_6_fcy_non_resident;
	}
	public void setR16_above_3_up_6_fcy_non_resident(BigDecimal r16_above_3_up_6_fcy_non_resident) {
		this.r16_above_3_up_6_fcy_non_resident = r16_above_3_up_6_fcy_non_resident;
	}
	public BigDecimal getR16_above_6_up_12_fcy_non_resident() {
		return r16_above_6_up_12_fcy_non_resident;
	}
	public void setR16_above_6_up_12_fcy_non_resident(BigDecimal r16_above_6_up_12_fcy_non_resident) {
		this.r16_above_6_up_12_fcy_non_resident = r16_above_6_up_12_fcy_non_resident;
	}
	public BigDecimal getR16_exc_12_mon_fcy_non_resident() {
		return r16_exc_12_mon_fcy_non_resident;
	}
	public void setR16_exc_12_mon_fcy_non_resident(BigDecimal r16_exc_12_mon_fcy_non_resident) {
		this.r16_exc_12_mon_fcy_non_resident = r16_exc_12_mon_fcy_non_resident;
	}
	public BigDecimal getR16_total_non_resident() {
		return r16_total_non_resident;
	}
	public void setR16_total_non_resident(BigDecimal r16_total_non_resident) {
		this.r16_total_non_resident = r16_total_non_resident;
	}
	public BigDecimal getR16_grand_total_amount() {
		return r16_grand_total_amount;
	}
	public void setR16_grand_total_amount(BigDecimal r16_grand_total_amount) {
		this.r16_grand_total_amount = r16_grand_total_amount;
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
	public BRF12_ENTITY() {
		super();
		// TODO Auto-generated constructor stub
	}
}