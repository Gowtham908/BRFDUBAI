
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
@Table(name="CAR_T1")

public class BASEL_002_A1_REPORT_ENTITY {

	private String	r1_col1;
	private BigDecimal	r1_col2;
	private BigDecimal	r2_col1;
	private String	r2_col2;
	private BigDecimal	r3_col1;
	private String	r3_col2;
	private BigDecimal	r4_col1;
	private String	r4_col2;
	private BigDecimal	r5_col1;
	private String	r5_col2;
	private BigDecimal	r6_col1;
	private String	r6_col2;
	private BigDecimal	r7_col1;
	private String	r7_col2;
	private BigDecimal	r8_col1;
	private String	r8_col2;
	private BigDecimal	r9_col1;
	private String	r9_col2;
	private BigDecimal	r10_col1;
	private String	r10_col2;
	private BigDecimal	r11_col1;
	private String	r11_col2;
	private BigDecimal	r12_col1;
	private String	r12_col2;
	private BigDecimal	r13_col1;
	private String	r13_col2;
	private BigDecimal	r14_col1;
	private String	r14_col2;
	private BigDecimal	r15_col1;
	private String	r15_col2;
	private BigDecimal	r16_col1;
	private String	r16_col2;
	private String	r17_col1;
	private String	r17_col2;
	private String	r17_col3;
	private String	r17_col4;
	private String	r17_col5;
	private String	r17_col6;
	private String	r18_col1;
	private BigDecimal	r18_col2;
	private BigDecimal	r18_col3;
	private String	r18_col4;
	private BigDecimal	r18_col5;
	private String	r18_col6;
	private String	r19_col1;
	private BigDecimal	r19_col2;
	private BigDecimal	r19_col3;
	private String	r19_col4;
	private BigDecimal	r19_col5;
	private String	r19_col6;
	private String	r20_col1;
	private BigDecimal	r20_col2;
	private BigDecimal	r20_col3;
	private String	r20_col4;
	private BigDecimal	r20_col5;
	private String	r20_col6;

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
	public String getR1_col1() {
		return r1_col1;
	}
	public void setR1_col1(String r1_col1) {
		this.r1_col1 = r1_col1;
	}
	public BigDecimal getR1_col2() {
		return r1_col2;
	}
	public void setR1_col2(BigDecimal r1_col2) {
		this.r1_col2 = r1_col2;
	}
	public BigDecimal getR2_col1() {
		return r2_col1;
	}
	public void setR2_col1(BigDecimal r2_col1) {
		this.r2_col1 = r2_col1;
	}
	public String getR2_col2() {
		return r2_col2;
	}
	public void setR2_col2(String r2_col2) {
		this.r2_col2 = r2_col2;
	}
	public BigDecimal getR3_col1() {
		return r3_col1;
	}
	public void setR3_col1(BigDecimal r3_col1) {
		this.r3_col1 = r3_col1;
	}
	public String getR3_col2() {
		return r3_col2;
	}
	public void setR3_col2(String r3_col2) {
		this.r3_col2 = r3_col2;
	}
	public BigDecimal getR4_col1() {
		return r4_col1;
	}
	public void setR4_col1(BigDecimal r4_col1) {
		this.r4_col1 = r4_col1;
	}
	public String getR4_col2() {
		return r4_col2;
	}
	public void setR4_col2(String r4_col2) {
		this.r4_col2 = r4_col2;
	}
	public BigDecimal getR5_col1() {
		return r5_col1;
	}
	public void setR5_col1(BigDecimal r5_col1) {
		this.r5_col1 = r5_col1;
	}
	public String getR5_col2() {
		return r5_col2;
	}
	public void setR5_col2(String r5_col2) {
		this.r5_col2 = r5_col2;
	}
	public BigDecimal getR6_col1() {
		return r6_col1;
	}
	public void setR6_col1(BigDecimal r6_col1) {
		this.r6_col1 = r6_col1;
	}
	public String getR6_col2() {
		return r6_col2;
	}
	public void setR6_col2(String r6_col2) {
		this.r6_col2 = r6_col2;
	}
	public BigDecimal getR7_col1() {
		return r7_col1;
	}
	public void setR7_col1(BigDecimal r7_col1) {
		this.r7_col1 = r7_col1;
	}
	public String getR7_col2() {
		return r7_col2;
	}
	public void setR7_col2(String r7_col2) {
		this.r7_col2 = r7_col2;
	}
	public BigDecimal getR8_col1() {
		return r8_col1;
	}
	public void setR8_col1(BigDecimal r8_col1) {
		this.r8_col1 = r8_col1;
	}
	public String getR8_col2() {
		return r8_col2;
	}
	public void setR8_col2(String r8_col2) {
		this.r8_col2 = r8_col2;
	}
	public BigDecimal getR9_col1() {
		return r9_col1;
	}
	public void setR9_col1(BigDecimal r9_col1) {
		this.r9_col1 = r9_col1;
	}
	public String getR9_col2() {
		return r9_col2;
	}
	public void setR9_col2(String r9_col2) {
		this.r9_col2 = r9_col2;
	}
	public BigDecimal getR10_col1() {
		return r10_col1;
	}
	public void setR10_col1(BigDecimal r10_col1) {
		this.r10_col1 = r10_col1;
	}
	public String getR10_col2() {
		return r10_col2;
	}
	public void setR10_col2(String r10_col2) {
		this.r10_col2 = r10_col2;
	}
	public BigDecimal getR11_col1() {
		return r11_col1;
	}
	public void setR11_col1(BigDecimal r11_col1) {
		this.r11_col1 = r11_col1;
	}
	public String getR11_col2() {
		return r11_col2;
	}
	public void setR11_col2(String r11_col2) {
		this.r11_col2 = r11_col2;
	}
	public BigDecimal getR12_col1() {
		return r12_col1;
	}
	public void setR12_col1(BigDecimal r12_col1) {
		this.r12_col1 = r12_col1;
	}
	public String getR12_col2() {
		return r12_col2;
	}
	public void setR12_col2(String r12_col2) {
		this.r12_col2 = r12_col2;
	}
	public BigDecimal getR13_col1() {
		return r13_col1;
	}
	public void setR13_col1(BigDecimal r13_col1) {
		this.r13_col1 = r13_col1;
	}
	public String getR13_col2() {
		return r13_col2;
	}
	public void setR13_col2(String r13_col2) {
		this.r13_col2 = r13_col2;
	}
	public BigDecimal getR14_col1() {
		return r14_col1;
	}
	public void setR14_col1(BigDecimal r14_col1) {
		this.r14_col1 = r14_col1;
	}
	public String getR14_col2() {
		return r14_col2;
	}
	public void setR14_col2(String r14_col2) {
		this.r14_col2 = r14_col2;
	}
	public BigDecimal getR15_col1() {
		return r15_col1;
	}
	public void setR15_col1(BigDecimal r15_col1) {
		this.r15_col1 = r15_col1;
	}
	public String getR15_col2() {
		return r15_col2;
	}
	public void setR15_col2(String r15_col2) {
		this.r15_col2 = r15_col2;
	}
	public BigDecimal getR16_col1() {
		return r16_col1;
	}
	public void setR16_col1(BigDecimal r16_col1) {
		this.r16_col1 = r16_col1;
	}
	public String getR16_col2() {
		return r16_col2;
	}
	public void setR16_col2(String r16_col2) {
		this.r16_col2 = r16_col2;
	}
	public String getR17_col1() {
		return r17_col1;
	}
	public void setR17_col1(String r17_col1) {
		this.r17_col1 = r17_col1;
	}
	public String getR17_col2() {
		return r17_col2;
	}
	public void setR17_col2(String r17_col2) {
		this.r17_col2 = r17_col2;
	}
	public String getR17_col3() {
		return r17_col3;
	}
	public void setR17_col3(String r17_col3) {
		this.r17_col3 = r17_col3;
	}
	public String getR17_col4() {
		return r17_col4;
	}
	public void setR17_col4(String r17_col4) {
		this.r17_col4 = r17_col4;
	}
	public String getR17_col5() {
		return r17_col5;
	}
	public void setR17_col5(String r17_col5) {
		this.r17_col5 = r17_col5;
	}
	public String getR17_col6() {
		return r17_col6;
	}
	public void setR17_col6(String r17_col6) {
		this.r17_col6 = r17_col6;
	}
	public String getR18_col1() {
		return r18_col1;
	}
	public void setR18_col1(String r18_col1) {
		this.r18_col1 = r18_col1;
	}
	public BigDecimal getR18_col2() {
		return r18_col2;
	}
	public void setR18_col2(BigDecimal r18_col2) {
		this.r18_col2 = r18_col2;
	}
	public BigDecimal getR18_col3() {
		return r18_col3;
	}
	public void setR18_col3(BigDecimal r18_col3) {
		this.r18_col3 = r18_col3;
	}
	public String getR18_col4() {
		return r18_col4;
	}
	public void setR18_col4(String r18_col4) {
		this.r18_col4 = r18_col4;
	}
	public BigDecimal getR18_col5() {
		return r18_col5;
	}
	public void setR18_col5(BigDecimal r18_col5) {
		this.r18_col5 = r18_col5;
	}
	public String getR18_col6() {
		return r18_col6;
	}
	public void setR18_col6(String r18_col6) {
		this.r18_col6 = r18_col6;
	}
	public String getR19_col1() {
		return r19_col1;
	}
	public void setR19_col1(String r19_col1) {
		this.r19_col1 = r19_col1;
	}
	public BigDecimal getR19_col2() {
		return r19_col2;
	}
	public void setR19_col2(BigDecimal r19_col2) {
		this.r19_col2 = r19_col2;
	}
	public BigDecimal getR19_col3() {
		return r19_col3;
	}
	public void setR19_col3(BigDecimal r19_col3) {
		this.r19_col3 = r19_col3;
	}
	public String getR19_col4() {
		return r19_col4;
	}
	public void setR19_col4(String r19_col4) {
		this.r19_col4 = r19_col4;
	}
	public BigDecimal getR19_col5() {
		return r19_col5;
	}
	public void setR19_col5(BigDecimal r19_col5) {
		this.r19_col5 = r19_col5;
	}
	public String getR19_col6() {
		return r19_col6;
	}
	public void setR19_col6(String r19_col6) {
		this.r19_col6 = r19_col6;
	}
	public String getR20_col1() {
		return r20_col1;
	}
	public void setR20_col1(String r20_col1) {
		this.r20_col1 = r20_col1;
	}
	public BigDecimal getR20_col2() {
		return r20_col2;
	}
	public void setR20_col2(BigDecimal r20_col2) {
		this.r20_col2 = r20_col2;
	}
	public BigDecimal getR20_col3() {
		return r20_col3;
	}
	public void setR20_col3(BigDecimal r20_col3) {
		this.r20_col3 = r20_col3;
	}
	public String getR20_col4() {
		return r20_col4;
	}
	public void setR20_col4(String r20_col4) {
		this.r20_col4 = r20_col4;
	}
	public BigDecimal getR20_col5() {
		return r20_col5;
	}
	public void setR20_col5(BigDecimal r20_col5) {
		this.r20_col5 = r20_col5;
	}
	public String getR20_col6() {
		return r20_col6;
	}
	public void setR20_col6(String r20_col6) {
		this.r20_col6 = r20_col6;
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
	public BASEL_002_A1_REPORT_ENTITY() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
