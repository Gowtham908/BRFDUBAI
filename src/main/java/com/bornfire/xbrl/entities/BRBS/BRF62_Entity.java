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
@Table(name="BRF62_SUMMARYTABLE")

public class BRF62_Entity {
	private String	r1_product;
	private BigDecimal	r1_number1;
	private BigDecimal	r1_bal1;
	private BigDecimal	r1_number2;
	private BigDecimal	r1_bal2;
	private BigDecimal	r1_number3;
	private BigDecimal	r1_bal3;
	private BigDecimal	r1_number4;
	private BigDecimal	r1_bal4;
	private BigDecimal	r1_number5;
	private BigDecimal	r1_bal5;
	private String	r2_product;
	private BigDecimal	r2_number1;
	private BigDecimal	r2_bal1;
	private BigDecimal	r2_number2;
	private BigDecimal	r2_bal2;
	private BigDecimal	r2_number3;
	private BigDecimal	r2_bal3;
	private BigDecimal	r2_number4;
	private BigDecimal	r2_bal4;
	private BigDecimal	r2_number5;
	private BigDecimal	r2_bal5;
	private String	r3_product;
	private BigDecimal	r3_number1;
	private BigDecimal	r3_bal1;
	private BigDecimal	r3_number2;
	private BigDecimal	r3_bal2;
	private BigDecimal	r3_number3;
	private BigDecimal	r3_bal3;
	private BigDecimal	r3_number4;
	private BigDecimal	r3_bal4;
	private BigDecimal	r3_number5;
	private BigDecimal	r3_bal5;
	private String	r4_product;
	private BigDecimal	r4_number1;
	private BigDecimal	r4_bal1;
	private BigDecimal	r4_number2;
	private BigDecimal	r4_bal2;
	private BigDecimal	r4_number3;
	private BigDecimal	r4_bal3;
	private BigDecimal	r4_number4;
	private BigDecimal	r4_bal4;
	private BigDecimal	r4_number5;
	private BigDecimal	r4_bal5;
	private String	r5_product;
	private BigDecimal	r5_number1;
	private BigDecimal	r5_bal1;
	private BigDecimal	r5_number2;
	private BigDecimal	r5_bal2;
	private BigDecimal	r5_number3;
	private BigDecimal	r5_bal3;
	private BigDecimal	r5_number4;
	private BigDecimal	r5_bal4;
	private BigDecimal	r5_number5;
	private BigDecimal	r5_bal5;
	private String	r6_product;
	private BigDecimal	r6_number1;
	private BigDecimal	r6_bal1;
	private BigDecimal	r6_number2;
	private BigDecimal	r6_bal2;
	private BigDecimal	r6_number3;
	private BigDecimal	r6_bal3;
	private BigDecimal	r6_number4;
	private BigDecimal	r6_bal4;
	private BigDecimal	r6_number5;
	private BigDecimal	r6_bal5;
	private String	r7_product;
	private BigDecimal	r7_number1;
	private BigDecimal	r7_bal1;
	private BigDecimal	r7_number2;
	private BigDecimal	r7_bal2;
	private BigDecimal	r7_number3;
	private BigDecimal	r7_bal3;
	private BigDecimal	r7_number4;
	private BigDecimal	r7_bal4;
	private BigDecimal	r7_number5;
	private BigDecimal	r7_bal5;
	private String	r8_product;
	private BigDecimal	r8_number1;
	private BigDecimal	r8_bal1;
	private BigDecimal	r8_number2;
	private BigDecimal	r8_bal2;
	private BigDecimal	r8_number3;
	private BigDecimal	r8_bal3;
	private BigDecimal	r8_number4;
	private BigDecimal	r8_bal4;
	private BigDecimal	r8_number5;
	private BigDecimal	r8_bal5;
	private String	r9_product;
	private BigDecimal	r9_number1;
	private BigDecimal	r9_bal1;
	private BigDecimal	r9_number2;
	private BigDecimal	r9_bal2;
	private BigDecimal	r9_number3;
	private BigDecimal	r9_bal3;
	private BigDecimal	r9_number4;
	private BigDecimal	r9_bal4;
	private BigDecimal	r9_number5;
	private BigDecimal	r9_bal5;
	private String	r10_product;
	private BigDecimal	r10_number1;
	private BigDecimal	r10_bal1;
	private BigDecimal	r10_number2;
	private BigDecimal	r10_bal2;
	private BigDecimal	r10_number3;
	private BigDecimal	r10_bal3;
	private BigDecimal	r10_number4;
	private BigDecimal	r10_bal4;
	private BigDecimal	r10_number5;
	private BigDecimal	r10_bal5;
	private String	r11_product;
	private BigDecimal	r11_number1;
	private BigDecimal	r11_bal1;
	private BigDecimal	r11_number2;
	private BigDecimal	r11_bal2;
	private BigDecimal	r11_number3;
	private BigDecimal	r11_bal3;
	private BigDecimal	r11_number4;
	private BigDecimal	r11_bal4;
	private BigDecimal	r11_number5;
	private BigDecimal	r11_bal5;
	private String	r12_product;
	private BigDecimal	r12_number1;
	private BigDecimal	r12_bal1;
	private BigDecimal	r12_number2;
	private BigDecimal	r12_bal2;
	private BigDecimal	r12_number3;
	private BigDecimal	r12_bal3;
	private BigDecimal	r12_number4;
	private BigDecimal	r12_bal4;
	private BigDecimal	r12_number5;
	private BigDecimal	r12_bal5;
	private String	r13_product;
	private BigDecimal	r13_number1;
	private BigDecimal	r13_bal1;
	private BigDecimal	r13_number2;
	private BigDecimal	r13_bal2;
	private BigDecimal	r13_number3;
	private BigDecimal	r13_bal3;
	private BigDecimal	r13_number4;
	private BigDecimal	r13_bal4;
	private BigDecimal	r13_number5;
	private BigDecimal	r13_bal5;
	private String	r14_product;
	private BigDecimal	r14_number1;
	private BigDecimal	r14_bal1;
	private BigDecimal	r14_number2;
	private BigDecimal	r14_bal2;
	private BigDecimal	r14_number3;
	private BigDecimal	r14_bal3;
	private BigDecimal	r14_number4;
	private BigDecimal	r14_bal4;
	private BigDecimal	r14_number5;
	private BigDecimal	r14_bal5;
	private String	r15_product;
	private BigDecimal	r15_number1;
	private BigDecimal	r15_bal1;
	private BigDecimal	r15_number2;
	private BigDecimal	r15_bal2;
	private BigDecimal	r15_number3;
	private BigDecimal	r15_bal3;
	private BigDecimal	r15_number4;
	private BigDecimal	r15_bal4;
	private BigDecimal	r15_number5;
	private BigDecimal	r15_bal5;
	private String	r16_product;
	private BigDecimal	r16_number1;
	private BigDecimal	r16_bal1;
	private BigDecimal	r16_number2;
	private BigDecimal	r16_bal2;
	private BigDecimal	r16_number3;
	private BigDecimal	r16_bal3;
	private BigDecimal	r16_number4;
	private BigDecimal	r16_bal4;
	private BigDecimal	r16_number5;
	private BigDecimal	r16_bal5;
	private String	r17_product;
	private BigDecimal	r17_number1;
	private BigDecimal	r17_bal1;
	private BigDecimal	r17_number2;
	private BigDecimal	r17_bal2;
	private BigDecimal	r17_number3;
	private BigDecimal	r17_bal3;
	private BigDecimal	r17_number4;
	private BigDecimal	r17_bal4;
	private BigDecimal	r17_number5;
	private BigDecimal	r17_bal5;
	private String	r18_product;
	private BigDecimal	r18_number1;
	private BigDecimal	r18_bal1;
	private BigDecimal	r18_number2;
	private BigDecimal	r18_bal2;
	private BigDecimal	r18_number3;
	private BigDecimal	r18_bal3;
	private BigDecimal	r18_number4;
	private BigDecimal	r18_bal4;
	private BigDecimal	r18_number5;
	private BigDecimal	r18_bal5;
	private String	r19_product;
	private BigDecimal	r19_number1;
	private BigDecimal	r19_bal1;
	private BigDecimal	r19_number2;
	private BigDecimal	r19_bal2;
	private BigDecimal	r19_number3;
	private BigDecimal	r19_bal3;
	private BigDecimal	r19_number4;
	private BigDecimal	r19_bal4;
	private BigDecimal	r19_number5;
	private BigDecimal	r19_bal5;
	private String	r20_product;
	private BigDecimal	r20_number1;
	private BigDecimal	r20_bal1;
	private BigDecimal	r20_number2;
	private BigDecimal	r20_bal2;
	private BigDecimal	r20_number3;
	private BigDecimal	r20_bal3;
	private BigDecimal	r20_number4;
	private BigDecimal	r20_bal4;
	private BigDecimal	r20_number5;
	private BigDecimal	r20_bal5;

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
	public String getR1_product() {
		return r1_product;
	}
	public void setR1_product(String r1_product) {
		this.r1_product = r1_product;
	}
	public BigDecimal getR1_number1() {
		return r1_number1;
	}
	public void setR1_number1(BigDecimal r1_number1) {
		this.r1_number1 = r1_number1;
	}
	public BigDecimal getR1_bal1() {
		return r1_bal1;
	}
	public void setR1_bal1(BigDecimal r1_bal1) {
		this.r1_bal1 = r1_bal1;
	}
	public BigDecimal getR1_number2() {
		return r1_number2;
	}
	public void setR1_number2(BigDecimal r1_number2) {
		this.r1_number2 = r1_number2;
	}
	public BigDecimal getR1_bal2() {
		return r1_bal2;
	}
	public void setR1_bal2(BigDecimal r1_bal2) {
		this.r1_bal2 = r1_bal2;
	}
	public BigDecimal getR1_number3() {
		return r1_number3;
	}
	public void setR1_number3(BigDecimal r1_number3) {
		this.r1_number3 = r1_number3;
	}
	public BigDecimal getR1_bal3() {
		return r1_bal3;
	}
	public void setR1_bal3(BigDecimal r1_bal3) {
		this.r1_bal3 = r1_bal3;
	}
	public BigDecimal getR1_number4() {
		return r1_number4;
	}
	public void setR1_number4(BigDecimal r1_number4) {
		this.r1_number4 = r1_number4;
	}
	public BigDecimal getR1_bal4() {
		return r1_bal4;
	}
	public void setR1_bal4(BigDecimal r1_bal4) {
		this.r1_bal4 = r1_bal4;
	}
	public BigDecimal getR1_number5() {
		return r1_number5;
	}
	public void setR1_number5(BigDecimal r1_number5) {
		this.r1_number5 = r1_number5;
	}
	public BigDecimal getR1_bal5() {
		return r1_bal5;
	}
	public void setR1_bal5(BigDecimal r1_bal5) {
		this.r1_bal5 = r1_bal5;
	}
	public String getR2_product() {
		return r2_product;
	}
	public void setR2_product(String r2_product) {
		this.r2_product = r2_product;
	}
	public BigDecimal getR2_number1() {
		return r2_number1;
	}
	public void setR2_number1(BigDecimal r2_number1) {
		this.r2_number1 = r2_number1;
	}
	public BigDecimal getR2_bal1() {
		return r2_bal1;
	}
	public void setR2_bal1(BigDecimal r2_bal1) {
		this.r2_bal1 = r2_bal1;
	}
	public BigDecimal getR2_number2() {
		return r2_number2;
	}
	public void setR2_number2(BigDecimal r2_number2) {
		this.r2_number2 = r2_number2;
	}
	public BigDecimal getR2_bal2() {
		return r2_bal2;
	}
	public void setR2_bal2(BigDecimal r2_bal2) {
		this.r2_bal2 = r2_bal2;
	}
	public BigDecimal getR2_number3() {
		return r2_number3;
	}
	public void setR2_number3(BigDecimal r2_number3) {
		this.r2_number3 = r2_number3;
	}
	public BigDecimal getR2_bal3() {
		return r2_bal3;
	}
	public void setR2_bal3(BigDecimal r2_bal3) {
		this.r2_bal3 = r2_bal3;
	}
	public BigDecimal getR2_number4() {
		return r2_number4;
	}
	public void setR2_number4(BigDecimal r2_number4) {
		this.r2_number4 = r2_number4;
	}
	public BigDecimal getR2_bal4() {
		return r2_bal4;
	}
	public void setR2_bal4(BigDecimal r2_bal4) {
		this.r2_bal4 = r2_bal4;
	}
	public BigDecimal getR2_number5() {
		return r2_number5;
	}
	public void setR2_number5(BigDecimal r2_number5) {
		this.r2_number5 = r2_number5;
	}
	public BigDecimal getR2_bal5() {
		return r2_bal5;
	}
	public void setR2_bal5(BigDecimal r2_bal5) {
		this.r2_bal5 = r2_bal5;
	}
	public String getR3_product() {
		return r3_product;
	}
	public void setR3_product(String r3_product) {
		this.r3_product = r3_product;
	}
	public BigDecimal getR3_number1() {
		return r3_number1;
	}
	public void setR3_number1(BigDecimal r3_number1) {
		this.r3_number1 = r3_number1;
	}
	public BigDecimal getR3_bal1() {
		return r3_bal1;
	}
	public void setR3_bal1(BigDecimal r3_bal1) {
		this.r3_bal1 = r3_bal1;
	}
	public BigDecimal getR3_number2() {
		return r3_number2;
	}
	public void setR3_number2(BigDecimal r3_number2) {
		this.r3_number2 = r3_number2;
	}
	public BigDecimal getR3_bal2() {
		return r3_bal2;
	}
	public void setR3_bal2(BigDecimal r3_bal2) {
		this.r3_bal2 = r3_bal2;
	}
	public BigDecimal getR3_number3() {
		return r3_number3;
	}
	public void setR3_number3(BigDecimal r3_number3) {
		this.r3_number3 = r3_number3;
	}
	public BigDecimal getR3_bal3() {
		return r3_bal3;
	}
	public void setR3_bal3(BigDecimal r3_bal3) {
		this.r3_bal3 = r3_bal3;
	}
	public BigDecimal getR3_number4() {
		return r3_number4;
	}
	public void setR3_number4(BigDecimal r3_number4) {
		this.r3_number4 = r3_number4;
	}
	public BigDecimal getR3_bal4() {
		return r3_bal4;
	}
	public void setR3_bal4(BigDecimal r3_bal4) {
		this.r3_bal4 = r3_bal4;
	}
	public BigDecimal getR3_number5() {
		return r3_number5;
	}
	public void setR3_number5(BigDecimal r3_number5) {
		this.r3_number5 = r3_number5;
	}
	public BigDecimal getR3_bal5() {
		return r3_bal5;
	}
	public void setR3_bal5(BigDecimal r3_bal5) {
		this.r3_bal5 = r3_bal5;
	}
	public String getR4_product() {
		return r4_product;
	}
	public void setR4_product(String r4_product) {
		this.r4_product = r4_product;
	}
	public BigDecimal getR4_number1() {
		return r4_number1;
	}
	public void setR4_number1(BigDecimal r4_number1) {
		this.r4_number1 = r4_number1;
	}
	public BigDecimal getR4_bal1() {
		return r4_bal1;
	}
	public void setR4_bal1(BigDecimal r4_bal1) {
		this.r4_bal1 = r4_bal1;
	}
	public BigDecimal getR4_number2() {
		return r4_number2;
	}
	public void setR4_number2(BigDecimal r4_number2) {
		this.r4_number2 = r4_number2;
	}
	public BigDecimal getR4_bal2() {
		return r4_bal2;
	}
	public void setR4_bal2(BigDecimal r4_bal2) {
		this.r4_bal2 = r4_bal2;
	}
	public BigDecimal getR4_number3() {
		return r4_number3;
	}
	public void setR4_number3(BigDecimal r4_number3) {
		this.r4_number3 = r4_number3;
	}
	public BigDecimal getR4_bal3() {
		return r4_bal3;
	}
	public void setR4_bal3(BigDecimal r4_bal3) {
		this.r4_bal3 = r4_bal3;
	}
	public BigDecimal getR4_number4() {
		return r4_number4;
	}
	public void setR4_number4(BigDecimal r4_number4) {
		this.r4_number4 = r4_number4;
	}
	public BigDecimal getR4_bal4() {
		return r4_bal4;
	}
	public void setR4_bal4(BigDecimal r4_bal4) {
		this.r4_bal4 = r4_bal4;
	}
	public BigDecimal getR4_number5() {
		return r4_number5;
	}
	public void setR4_number5(BigDecimal r4_number5) {
		this.r4_number5 = r4_number5;
	}
	public BigDecimal getR4_bal5() {
		return r4_bal5;
	}
	public void setR4_bal5(BigDecimal r4_bal5) {
		this.r4_bal5 = r4_bal5;
	}
	public String getR5_product() {
		return r5_product;
	}
	public void setR5_product(String r5_product) {
		this.r5_product = r5_product;
	}
	public BigDecimal getR5_number1() {
		return r5_number1;
	}
	public void setR5_number1(BigDecimal r5_number1) {
		this.r5_number1 = r5_number1;
	}
	public BigDecimal getR5_bal1() {
		return r5_bal1;
	}
	public void setR5_bal1(BigDecimal r5_bal1) {
		this.r5_bal1 = r5_bal1;
	}
	public BigDecimal getR5_number2() {
		return r5_number2;
	}
	public void setR5_number2(BigDecimal r5_number2) {
		this.r5_number2 = r5_number2;
	}
	public BigDecimal getR5_bal2() {
		return r5_bal2;
	}
	public void setR5_bal2(BigDecimal r5_bal2) {
		this.r5_bal2 = r5_bal2;
	}
	public BigDecimal getR5_number3() {
		return r5_number3;
	}
	public void setR5_number3(BigDecimal r5_number3) {
		this.r5_number3 = r5_number3;
	}
	public BigDecimal getR5_bal3() {
		return r5_bal3;
	}
	public void setR5_bal3(BigDecimal r5_bal3) {
		this.r5_bal3 = r5_bal3;
	}
	public BigDecimal getR5_number4() {
		return r5_number4;
	}
	public void setR5_number4(BigDecimal r5_number4) {
		this.r5_number4 = r5_number4;
	}
	public BigDecimal getR5_bal4() {
		return r5_bal4;
	}
	public void setR5_bal4(BigDecimal r5_bal4) {
		this.r5_bal4 = r5_bal4;
	}
	public BigDecimal getR5_number5() {
		return r5_number5;
	}
	public void setR5_number5(BigDecimal r5_number5) {
		this.r5_number5 = r5_number5;
	}
	public BigDecimal getR5_bal5() {
		return r5_bal5;
	}
	public void setR5_bal5(BigDecimal r5_bal5) {
		this.r5_bal5 = r5_bal5;
	}
	public String getR6_product() {
		return r6_product;
	}
	public void setR6_product(String r6_product) {
		this.r6_product = r6_product;
	}
	public BigDecimal getR6_number1() {
		return r6_number1;
	}
	public void setR6_number1(BigDecimal r6_number1) {
		this.r6_number1 = r6_number1;
	}
	public BigDecimal getR6_bal1() {
		return r6_bal1;
	}
	public void setR6_bal1(BigDecimal r6_bal1) {
		this.r6_bal1 = r6_bal1;
	}
	public BigDecimal getR6_number2() {
		return r6_number2;
	}
	public void setR6_number2(BigDecimal r6_number2) {
		this.r6_number2 = r6_number2;
	}
	public BigDecimal getR6_bal2() {
		return r6_bal2;
	}
	public void setR6_bal2(BigDecimal r6_bal2) {
		this.r6_bal2 = r6_bal2;
	}
	public BigDecimal getR6_number3() {
		return r6_number3;
	}
	public void setR6_number3(BigDecimal r6_number3) {
		this.r6_number3 = r6_number3;
	}
	public BigDecimal getR6_bal3() {
		return r6_bal3;
	}
	public void setR6_bal3(BigDecimal r6_bal3) {
		this.r6_bal3 = r6_bal3;
	}
	public BigDecimal getR6_number4() {
		return r6_number4;
	}
	public void setR6_number4(BigDecimal r6_number4) {
		this.r6_number4 = r6_number4;
	}
	public BigDecimal getR6_bal4() {
		return r6_bal4;
	}
	public void setR6_bal4(BigDecimal r6_bal4) {
		this.r6_bal4 = r6_bal4;
	}
	public BigDecimal getR6_number5() {
		return r6_number5;
	}
	public void setR6_number5(BigDecimal r6_number5) {
		this.r6_number5 = r6_number5;
	}
	public BigDecimal getR6_bal5() {
		return r6_bal5;
	}
	public void setR6_bal5(BigDecimal r6_bal5) {
		this.r6_bal5 = r6_bal5;
	}
	public String getR7_product() {
		return r7_product;
	}
	public void setR7_product(String r7_product) {
		this.r7_product = r7_product;
	}
	public BigDecimal getR7_number1() {
		return r7_number1;
	}
	public void setR7_number1(BigDecimal r7_number1) {
		this.r7_number1 = r7_number1;
	}
	public BigDecimal getR7_bal1() {
		return r7_bal1;
	}
	public void setR7_bal1(BigDecimal r7_bal1) {
		this.r7_bal1 = r7_bal1;
	}
	public BigDecimal getR7_number2() {
		return r7_number2;
	}
	public void setR7_number2(BigDecimal r7_number2) {
		this.r7_number2 = r7_number2;
	}
	public BigDecimal getR7_bal2() {
		return r7_bal2;
	}
	public void setR7_bal2(BigDecimal r7_bal2) {
		this.r7_bal2 = r7_bal2;
	}
	public BigDecimal getR7_number3() {
		return r7_number3;
	}
	public void setR7_number3(BigDecimal r7_number3) {
		this.r7_number3 = r7_number3;
	}
	public BigDecimal getR7_bal3() {
		return r7_bal3;
	}
	public void setR7_bal3(BigDecimal r7_bal3) {
		this.r7_bal3 = r7_bal3;
	}
	public BigDecimal getR7_number4() {
		return r7_number4;
	}
	public void setR7_number4(BigDecimal r7_number4) {
		this.r7_number4 = r7_number4;
	}
	public BigDecimal getR7_bal4() {
		return r7_bal4;
	}
	public void setR7_bal4(BigDecimal r7_bal4) {
		this.r7_bal4 = r7_bal4;
	}
	public BigDecimal getR7_number5() {
		return r7_number5;
	}
	public void setR7_number5(BigDecimal r7_number5) {
		this.r7_number5 = r7_number5;
	}
	public BigDecimal getR7_bal5() {
		return r7_bal5;
	}
	public void setR7_bal5(BigDecimal r7_bal5) {
		this.r7_bal5 = r7_bal5;
	}
	public String getR8_product() {
		return r8_product;
	}
	public void setR8_product(String r8_product) {
		this.r8_product = r8_product;
	}
	public BigDecimal getR8_number1() {
		return r8_number1;
	}
	public void setR8_number1(BigDecimal r8_number1) {
		this.r8_number1 = r8_number1;
	}
	public BigDecimal getR8_bal1() {
		return r8_bal1;
	}
	public void setR8_bal1(BigDecimal r8_bal1) {
		this.r8_bal1 = r8_bal1;
	}
	public BigDecimal getR8_number2() {
		return r8_number2;
	}
	public void setR8_number2(BigDecimal r8_number2) {
		this.r8_number2 = r8_number2;
	}
	public BigDecimal getR8_bal2() {
		return r8_bal2;
	}
	public void setR8_bal2(BigDecimal r8_bal2) {
		this.r8_bal2 = r8_bal2;
	}
	public BigDecimal getR8_number3() {
		return r8_number3;
	}
	public void setR8_number3(BigDecimal r8_number3) {
		this.r8_number3 = r8_number3;
	}
	public BigDecimal getR8_bal3() {
		return r8_bal3;
	}
	public void setR8_bal3(BigDecimal r8_bal3) {
		this.r8_bal3 = r8_bal3;
	}
	public BigDecimal getR8_number4() {
		return r8_number4;
	}
	public void setR8_number4(BigDecimal r8_number4) {
		this.r8_number4 = r8_number4;
	}
	public BigDecimal getR8_bal4() {
		return r8_bal4;
	}
	public void setR8_bal4(BigDecimal r8_bal4) {
		this.r8_bal4 = r8_bal4;
	}
	public BigDecimal getR8_number5() {
		return r8_number5;
	}
	public void setR8_number5(BigDecimal r8_number5) {
		this.r8_number5 = r8_number5;
	}
	public BigDecimal getR8_bal5() {
		return r8_bal5;
	}
	public void setR8_bal5(BigDecimal r8_bal5) {
		this.r8_bal5 = r8_bal5;
	}
	public String getR9_product() {
		return r9_product;
	}
	public void setR9_product(String r9_product) {
		this.r9_product = r9_product;
	}
	public BigDecimal getR9_number1() {
		return r9_number1;
	}
	public void setR9_number1(BigDecimal r9_number1) {
		this.r9_number1 = r9_number1;
	}
	public BigDecimal getR9_bal1() {
		return r9_bal1;
	}
	public void setR9_bal1(BigDecimal r9_bal1) {
		this.r9_bal1 = r9_bal1;
	}
	public BigDecimal getR9_number2() {
		return r9_number2;
	}
	public void setR9_number2(BigDecimal r9_number2) {
		this.r9_number2 = r9_number2;
	}
	public BigDecimal getR9_bal2() {
		return r9_bal2;
	}
	public void setR9_bal2(BigDecimal r9_bal2) {
		this.r9_bal2 = r9_bal2;
	}
	public BigDecimal getR9_number3() {
		return r9_number3;
	}
	public void setR9_number3(BigDecimal r9_number3) {
		this.r9_number3 = r9_number3;
	}
	public BigDecimal getR9_bal3() {
		return r9_bal3;
	}
	public void setR9_bal3(BigDecimal r9_bal3) {
		this.r9_bal3 = r9_bal3;
	}
	public BigDecimal getR9_number4() {
		return r9_number4;
	}
	public void setR9_number4(BigDecimal r9_number4) {
		this.r9_number4 = r9_number4;
	}
	public BigDecimal getR9_bal4() {
		return r9_bal4;
	}
	public void setR9_bal4(BigDecimal r9_bal4) {
		this.r9_bal4 = r9_bal4;
	}
	public BigDecimal getR9_number5() {
		return r9_number5;
	}
	public void setR9_number5(BigDecimal r9_number5) {
		this.r9_number5 = r9_number5;
	}
	public BigDecimal getR9_bal5() {
		return r9_bal5;
	}
	public void setR9_bal5(BigDecimal r9_bal5) {
		this.r9_bal5 = r9_bal5;
	}
	public String getR10_product() {
		return r10_product;
	}
	public void setR10_product(String r10_product) {
		this.r10_product = r10_product;
	}
	public BigDecimal getR10_number1() {
		return r10_number1;
	}
	public void setR10_number1(BigDecimal r10_number1) {
		this.r10_number1 = r10_number1;
	}
	public BigDecimal getR10_bal1() {
		return r10_bal1;
	}
	public void setR10_bal1(BigDecimal r10_bal1) {
		this.r10_bal1 = r10_bal1;
	}
	public BigDecimal getR10_number2() {
		return r10_number2;
	}
	public void setR10_number2(BigDecimal r10_number2) {
		this.r10_number2 = r10_number2;
	}
	public BigDecimal getR10_bal2() {
		return r10_bal2;
	}
	public void setR10_bal2(BigDecimal r10_bal2) {
		this.r10_bal2 = r10_bal2;
	}
	public BigDecimal getR10_number3() {
		return r10_number3;
	}
	public void setR10_number3(BigDecimal r10_number3) {
		this.r10_number3 = r10_number3;
	}
	public BigDecimal getR10_bal3() {
		return r10_bal3;
	}
	public void setR10_bal3(BigDecimal r10_bal3) {
		this.r10_bal3 = r10_bal3;
	}
	public BigDecimal getR10_number4() {
		return r10_number4;
	}
	public void setR10_number4(BigDecimal r10_number4) {
		this.r10_number4 = r10_number4;
	}
	public BigDecimal getR10_bal4() {
		return r10_bal4;
	}
	public void setR10_bal4(BigDecimal r10_bal4) {
		this.r10_bal4 = r10_bal4;
	}
	public BigDecimal getR10_number5() {
		return r10_number5;
	}
	public void setR10_number5(BigDecimal r10_number5) {
		this.r10_number5 = r10_number5;
	}
	public BigDecimal getR10_bal5() {
		return r10_bal5;
	}
	public void setR10_bal5(BigDecimal r10_bal5) {
		this.r10_bal5 = r10_bal5;
	}
	public String getR11_product() {
		return r11_product;
	}
	public void setR11_product(String r11_product) {
		this.r11_product = r11_product;
	}
	public BigDecimal getR11_number1() {
		return r11_number1;
	}
	public void setR11_number1(BigDecimal r11_number1) {
		this.r11_number1 = r11_number1;
	}
	public BigDecimal getR11_bal1() {
		return r11_bal1;
	}
	public void setR11_bal1(BigDecimal r11_bal1) {
		this.r11_bal1 = r11_bal1;
	}
	public BigDecimal getR11_number2() {
		return r11_number2;
	}
	public void setR11_number2(BigDecimal r11_number2) {
		this.r11_number2 = r11_number2;
	}
	public BigDecimal getR11_bal2() {
		return r11_bal2;
	}
	public void setR11_bal2(BigDecimal r11_bal2) {
		this.r11_bal2 = r11_bal2;
	}
	public BigDecimal getR11_number3() {
		return r11_number3;
	}
	public void setR11_number3(BigDecimal r11_number3) {
		this.r11_number3 = r11_number3;
	}
	public BigDecimal getR11_bal3() {
		return r11_bal3;
	}
	public void setR11_bal3(BigDecimal r11_bal3) {
		this.r11_bal3 = r11_bal3;
	}
	public BigDecimal getR11_number4() {
		return r11_number4;
	}
	public void setR11_number4(BigDecimal r11_number4) {
		this.r11_number4 = r11_number4;
	}
	public BigDecimal getR11_bal4() {
		return r11_bal4;
	}
	public void setR11_bal4(BigDecimal r11_bal4) {
		this.r11_bal4 = r11_bal4;
	}
	public BigDecimal getR11_number5() {
		return r11_number5;
	}
	public void setR11_number5(BigDecimal r11_number5) {
		this.r11_number5 = r11_number5;
	}
	public BigDecimal getR11_bal5() {
		return r11_bal5;
	}
	public void setR11_bal5(BigDecimal r11_bal5) {
		this.r11_bal5 = r11_bal5;
	}
	public String getR12_product() {
		return r12_product;
	}
	public void setR12_product(String r12_product) {
		this.r12_product = r12_product;
	}
	public BigDecimal getR12_number1() {
		return r12_number1;
	}
	public void setR12_number1(BigDecimal r12_number1) {
		this.r12_number1 = r12_number1;
	}
	public BigDecimal getR12_bal1() {
		return r12_bal1;
	}
	public void setR12_bal1(BigDecimal r12_bal1) {
		this.r12_bal1 = r12_bal1;
	}
	public BigDecimal getR12_number2() {
		return r12_number2;
	}
	public void setR12_number2(BigDecimal r12_number2) {
		this.r12_number2 = r12_number2;
	}
	public BigDecimal getR12_bal2() {
		return r12_bal2;
	}
	public void setR12_bal2(BigDecimal r12_bal2) {
		this.r12_bal2 = r12_bal2;
	}
	public BigDecimal getR12_number3() {
		return r12_number3;
	}
	public void setR12_number3(BigDecimal r12_number3) {
		this.r12_number3 = r12_number3;
	}
	public BigDecimal getR12_bal3() {
		return r12_bal3;
	}
	public void setR12_bal3(BigDecimal r12_bal3) {
		this.r12_bal3 = r12_bal3;
	}
	public BigDecimal getR12_number4() {
		return r12_number4;
	}
	public void setR12_number4(BigDecimal r12_number4) {
		this.r12_number4 = r12_number4;
	}
	public BigDecimal getR12_bal4() {
		return r12_bal4;
	}
	public void setR12_bal4(BigDecimal r12_bal4) {
		this.r12_bal4 = r12_bal4;
	}
	public BigDecimal getR12_number5() {
		return r12_number5;
	}
	public void setR12_number5(BigDecimal r12_number5) {
		this.r12_number5 = r12_number5;
	}
	public BigDecimal getR12_bal5() {
		return r12_bal5;
	}
	public void setR12_bal5(BigDecimal r12_bal5) {
		this.r12_bal5 = r12_bal5;
	}
	public String getR13_product() {
		return r13_product;
	}
	public void setR13_product(String r13_product) {
		this.r13_product = r13_product;
	}
	public BigDecimal getR13_number1() {
		return r13_number1;
	}
	public void setR13_number1(BigDecimal r13_number1) {
		this.r13_number1 = r13_number1;
	}
	public BigDecimal getR13_bal1() {
		return r13_bal1;
	}
	public void setR13_bal1(BigDecimal r13_bal1) {
		this.r13_bal1 = r13_bal1;
	}
	public BigDecimal getR13_number2() {
		return r13_number2;
	}
	public void setR13_number2(BigDecimal r13_number2) {
		this.r13_number2 = r13_number2;
	}
	public BigDecimal getR13_bal2() {
		return r13_bal2;
	}
	public void setR13_bal2(BigDecimal r13_bal2) {
		this.r13_bal2 = r13_bal2;
	}
	public BigDecimal getR13_number3() {
		return r13_number3;
	}
	public void setR13_number3(BigDecimal r13_number3) {
		this.r13_number3 = r13_number3;
	}
	public BigDecimal getR13_bal3() {
		return r13_bal3;
	}
	public void setR13_bal3(BigDecimal r13_bal3) {
		this.r13_bal3 = r13_bal3;
	}
	public BigDecimal getR13_number4() {
		return r13_number4;
	}
	public void setR13_number4(BigDecimal r13_number4) {
		this.r13_number4 = r13_number4;
	}
	public BigDecimal getR13_bal4() {
		return r13_bal4;
	}
	public void setR13_bal4(BigDecimal r13_bal4) {
		this.r13_bal4 = r13_bal4;
	}
	public BigDecimal getR13_number5() {
		return r13_number5;
	}
	public void setR13_number5(BigDecimal r13_number5) {
		this.r13_number5 = r13_number5;
	}
	public BigDecimal getR13_bal5() {
		return r13_bal5;
	}
	public void setR13_bal5(BigDecimal r13_bal5) {
		this.r13_bal5 = r13_bal5;
	}
	public String getR14_product() {
		return r14_product;
	}
	public void setR14_product(String r14_product) {
		this.r14_product = r14_product;
	}
	public BigDecimal getR14_number1() {
		return r14_number1;
	}
	public void setR14_number1(BigDecimal r14_number1) {
		this.r14_number1 = r14_number1;
	}
	public BigDecimal getR14_bal1() {
		return r14_bal1;
	}
	public void setR14_bal1(BigDecimal r14_bal1) {
		this.r14_bal1 = r14_bal1;
	}
	public BigDecimal getR14_number2() {
		return r14_number2;
	}
	public void setR14_number2(BigDecimal r14_number2) {
		this.r14_number2 = r14_number2;
	}
	public BigDecimal getR14_bal2() {
		return r14_bal2;
	}
	public void setR14_bal2(BigDecimal r14_bal2) {
		this.r14_bal2 = r14_bal2;
	}
	public BigDecimal getR14_number3() {
		return r14_number3;
	}
	public void setR14_number3(BigDecimal r14_number3) {
		this.r14_number3 = r14_number3;
	}
	public BigDecimal getR14_bal3() {
		return r14_bal3;
	}
	public void setR14_bal3(BigDecimal r14_bal3) {
		this.r14_bal3 = r14_bal3;
	}
	public BigDecimal getR14_number4() {
		return r14_number4;
	}
	public void setR14_number4(BigDecimal r14_number4) {
		this.r14_number4 = r14_number4;
	}
	public BigDecimal getR14_bal4() {
		return r14_bal4;
	}
	public void setR14_bal4(BigDecimal r14_bal4) {
		this.r14_bal4 = r14_bal4;
	}
	public BigDecimal getR14_number5() {
		return r14_number5;
	}
	public void setR14_number5(BigDecimal r14_number5) {
		this.r14_number5 = r14_number5;
	}
	public BigDecimal getR14_bal5() {
		return r14_bal5;
	}
	public void setR14_bal5(BigDecimal r14_bal5) {
		this.r14_bal5 = r14_bal5;
	}
	public String getR15_product() {
		return r15_product;
	}
	public void setR15_product(String r15_product) {
		this.r15_product = r15_product;
	}
	public BigDecimal getR15_number1() {
		return r15_number1;
	}
	public void setR15_number1(BigDecimal r15_number1) {
		this.r15_number1 = r15_number1;
	}
	public BigDecimal getR15_bal1() {
		return r15_bal1;
	}
	public void setR15_bal1(BigDecimal r15_bal1) {
		this.r15_bal1 = r15_bal1;
	}
	public BigDecimal getR15_number2() {
		return r15_number2;
	}
	public void setR15_number2(BigDecimal r15_number2) {
		this.r15_number2 = r15_number2;
	}
	public BigDecimal getR15_bal2() {
		return r15_bal2;
	}
	public void setR15_bal2(BigDecimal r15_bal2) {
		this.r15_bal2 = r15_bal2;
	}
	public BigDecimal getR15_number3() {
		return r15_number3;
	}
	public void setR15_number3(BigDecimal r15_number3) {
		this.r15_number3 = r15_number3;
	}
	public BigDecimal getR15_bal3() {
		return r15_bal3;
	}
	public void setR15_bal3(BigDecimal r15_bal3) {
		this.r15_bal3 = r15_bal3;
	}
	public BigDecimal getR15_number4() {
		return r15_number4;
	}
	public void setR15_number4(BigDecimal r15_number4) {
		this.r15_number4 = r15_number4;
	}
	public BigDecimal getR15_bal4() {
		return r15_bal4;
	}
	public void setR15_bal4(BigDecimal r15_bal4) {
		this.r15_bal4 = r15_bal4;
	}
	public BigDecimal getR15_number5() {
		return r15_number5;
	}
	public void setR15_number5(BigDecimal r15_number5) {
		this.r15_number5 = r15_number5;
	}
	public BigDecimal getR15_bal5() {
		return r15_bal5;
	}
	public void setR15_bal5(BigDecimal r15_bal5) {
		this.r15_bal5 = r15_bal5;
	}
	public String getR16_product() {
		return r16_product;
	}
	public void setR16_product(String r16_product) {
		this.r16_product = r16_product;
	}
	public BigDecimal getR16_number1() {
		return r16_number1;
	}
	public void setR16_number1(BigDecimal r16_number1) {
		this.r16_number1 = r16_number1;
	}
	public BigDecimal getR16_bal1() {
		return r16_bal1;
	}
	public void setR16_bal1(BigDecimal r16_bal1) {
		this.r16_bal1 = r16_bal1;
	}
	public BigDecimal getR16_number2() {
		return r16_number2;
	}
	public void setR16_number2(BigDecimal r16_number2) {
		this.r16_number2 = r16_number2;
	}
	public BigDecimal getR16_bal2() {
		return r16_bal2;
	}
	public void setR16_bal2(BigDecimal r16_bal2) {
		this.r16_bal2 = r16_bal2;
	}
	public BigDecimal getR16_number3() {
		return r16_number3;
	}
	public void setR16_number3(BigDecimal r16_number3) {
		this.r16_number3 = r16_number3;
	}
	public BigDecimal getR16_bal3() {
		return r16_bal3;
	}
	public void setR16_bal3(BigDecimal r16_bal3) {
		this.r16_bal3 = r16_bal3;
	}
	public BigDecimal getR16_number4() {
		return r16_number4;
	}
	public void setR16_number4(BigDecimal r16_number4) {
		this.r16_number4 = r16_number4;
	}
	public BigDecimal getR16_bal4() {
		return r16_bal4;
	}
	public void setR16_bal4(BigDecimal r16_bal4) {
		this.r16_bal4 = r16_bal4;
	}
	public BigDecimal getR16_number5() {
		return r16_number5;
	}
	public void setR16_number5(BigDecimal r16_number5) {
		this.r16_number5 = r16_number5;
	}
	public BigDecimal getR16_bal5() {
		return r16_bal5;
	}
	public void setR16_bal5(BigDecimal r16_bal5) {
		this.r16_bal5 = r16_bal5;
	}
	public String getR17_product() {
		return r17_product;
	}
	public void setR17_product(String r17_product) {
		this.r17_product = r17_product;
	}
	public BigDecimal getR17_number1() {
		return r17_number1;
	}
	public void setR17_number1(BigDecimal r17_number1) {
		this.r17_number1 = r17_number1;
	}
	public BigDecimal getR17_bal1() {
		return r17_bal1;
	}
	public void setR17_bal1(BigDecimal r17_bal1) {
		this.r17_bal1 = r17_bal1;
	}
	public BigDecimal getR17_number2() {
		return r17_number2;
	}
	public void setR17_number2(BigDecimal r17_number2) {
		this.r17_number2 = r17_number2;
	}
	public BigDecimal getR17_bal2() {
		return r17_bal2;
	}
	public void setR17_bal2(BigDecimal r17_bal2) {
		this.r17_bal2 = r17_bal2;
	}
	public BigDecimal getR17_number3() {
		return r17_number3;
	}
	public void setR17_number3(BigDecimal r17_number3) {
		this.r17_number3 = r17_number3;
	}
	public BigDecimal getR17_bal3() {
		return r17_bal3;
	}
	public void setR17_bal3(BigDecimal r17_bal3) {
		this.r17_bal3 = r17_bal3;
	}
	public BigDecimal getR17_number4() {
		return r17_number4;
	}
	public void setR17_number4(BigDecimal r17_number4) {
		this.r17_number4 = r17_number4;
	}
	public BigDecimal getR17_bal4() {
		return r17_bal4;
	}
	public void setR17_bal4(BigDecimal r17_bal4) {
		this.r17_bal4 = r17_bal4;
	}
	public BigDecimal getR17_number5() {
		return r17_number5;
	}
	public void setR17_number5(BigDecimal r17_number5) {
		this.r17_number5 = r17_number5;
	}
	public BigDecimal getR17_bal5() {
		return r17_bal5;
	}
	public void setR17_bal5(BigDecimal r17_bal5) {
		this.r17_bal5 = r17_bal5;
	}
	public String getR18_product() {
		return r18_product;
	}
	public void setR18_product(String r18_product) {
		this.r18_product = r18_product;
	}
	public BigDecimal getR18_number1() {
		return r18_number1;
	}
	public void setR18_number1(BigDecimal r18_number1) {
		this.r18_number1 = r18_number1;
	}
	public BigDecimal getR18_bal1() {
		return r18_bal1;
	}
	public void setR18_bal1(BigDecimal r18_bal1) {
		this.r18_bal1 = r18_bal1;
	}
	public BigDecimal getR18_number2() {
		return r18_number2;
	}
	public void setR18_number2(BigDecimal r18_number2) {
		this.r18_number2 = r18_number2;
	}
	public BigDecimal getR18_bal2() {
		return r18_bal2;
	}
	public void setR18_bal2(BigDecimal r18_bal2) {
		this.r18_bal2 = r18_bal2;
	}
	public BigDecimal getR18_number3() {
		return r18_number3;
	}
	public void setR18_number3(BigDecimal r18_number3) {
		this.r18_number3 = r18_number3;
	}
	public BigDecimal getR18_bal3() {
		return r18_bal3;
	}
	public void setR18_bal3(BigDecimal r18_bal3) {
		this.r18_bal3 = r18_bal3;
	}
	public BigDecimal getR18_number4() {
		return r18_number4;
	}
	public void setR18_number4(BigDecimal r18_number4) {
		this.r18_number4 = r18_number4;
	}
	public BigDecimal getR18_bal4() {
		return r18_bal4;
	}
	public void setR18_bal4(BigDecimal r18_bal4) {
		this.r18_bal4 = r18_bal4;
	}
	public BigDecimal getR18_number5() {
		return r18_number5;
	}
	public void setR18_number5(BigDecimal r18_number5) {
		this.r18_number5 = r18_number5;
	}
	public BigDecimal getR18_bal5() {
		return r18_bal5;
	}
	public void setR18_bal5(BigDecimal r18_bal5) {
		this.r18_bal5 = r18_bal5;
	}
	public String getR19_product() {
		return r19_product;
	}
	public void setR19_product(String r19_product) {
		this.r19_product = r19_product;
	}
	public BigDecimal getR19_number1() {
		return r19_number1;
	}
	public void setR19_number1(BigDecimal r19_number1) {
		this.r19_number1 = r19_number1;
	}
	public BigDecimal getR19_bal1() {
		return r19_bal1;
	}
	public void setR19_bal1(BigDecimal r19_bal1) {
		this.r19_bal1 = r19_bal1;
	}
	public BigDecimal getR19_number2() {
		return r19_number2;
	}
	public void setR19_number2(BigDecimal r19_number2) {
		this.r19_number2 = r19_number2;
	}
	public BigDecimal getR19_bal2() {
		return r19_bal2;
	}
	public void setR19_bal2(BigDecimal r19_bal2) {
		this.r19_bal2 = r19_bal2;
	}
	public BigDecimal getR19_number3() {
		return r19_number3;
	}
	public void setR19_number3(BigDecimal r19_number3) {
		this.r19_number3 = r19_number3;
	}
	public BigDecimal getR19_bal3() {
		return r19_bal3;
	}
	public void setR19_bal3(BigDecimal r19_bal3) {
		this.r19_bal3 = r19_bal3;
	}
	public BigDecimal getR19_number4() {
		return r19_number4;
	}
	public void setR19_number4(BigDecimal r19_number4) {
		this.r19_number4 = r19_number4;
	}
	public BigDecimal getR19_bal4() {
		return r19_bal4;
	}
	public void setR19_bal4(BigDecimal r19_bal4) {
		this.r19_bal4 = r19_bal4;
	}
	public BigDecimal getR19_number5() {
		return r19_number5;
	}
	public void setR19_number5(BigDecimal r19_number5) {
		this.r19_number5 = r19_number5;
	}
	public BigDecimal getR19_bal5() {
		return r19_bal5;
	}
	public void setR19_bal5(BigDecimal r19_bal5) {
		this.r19_bal5 = r19_bal5;
	}
	public String getR20_product() {
		return r20_product;
	}
	public void setR20_product(String r20_product) {
		this.r20_product = r20_product;
	}
	public BigDecimal getR20_number1() {
		return r20_number1;
	}
	public void setR20_number1(BigDecimal r20_number1) {
		this.r20_number1 = r20_number1;
	}
	public BigDecimal getR20_bal1() {
		return r20_bal1;
	}
	public void setR20_bal1(BigDecimal r20_bal1) {
		this.r20_bal1 = r20_bal1;
	}
	public BigDecimal getR20_number2() {
		return r20_number2;
	}
	public void setR20_number2(BigDecimal r20_number2) {
		this.r20_number2 = r20_number2;
	}
	public BigDecimal getR20_bal2() {
		return r20_bal2;
	}
	public void setR20_bal2(BigDecimal r20_bal2) {
		this.r20_bal2 = r20_bal2;
	}
	public BigDecimal getR20_number3() {
		return r20_number3;
	}
	public void setR20_number3(BigDecimal r20_number3) {
		this.r20_number3 = r20_number3;
	}
	public BigDecimal getR20_bal3() {
		return r20_bal3;
	}
	public void setR20_bal3(BigDecimal r20_bal3) {
		this.r20_bal3 = r20_bal3;
	}
	public BigDecimal getR20_number4() {
		return r20_number4;
	}
	public void setR20_number4(BigDecimal r20_number4) {
		this.r20_number4 = r20_number4;
	}
	public BigDecimal getR20_bal4() {
		return r20_bal4;
	}
	public void setR20_bal4(BigDecimal r20_bal4) {
		this.r20_bal4 = r20_bal4;
	}
	public BigDecimal getR20_number5() {
		return r20_number5;
	}
	public void setR20_number5(BigDecimal r20_number5) {
		this.r20_number5 = r20_number5;
	}
	public BigDecimal getR20_bal5() {
		return r20_bal5;
	}
	public void setR20_bal5(BigDecimal r20_bal5) {
		this.r20_bal5 = r20_bal5;
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
	public BRF62_Entity() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
