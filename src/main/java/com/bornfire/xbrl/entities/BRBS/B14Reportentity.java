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
@Table(name="MR1")

public class B14Reportentity {
	private String	r1_col1;
	private BigDecimal	r1_col2;
	private String	r1_col3;
	private BigDecimal	r1_col4;
	private BigDecimal	r1_col5;
	private String	r2_col1;
	private BigDecimal	r2_col2;
	private String	r2_col3;
	private BigDecimal	r2_col4;
	private BigDecimal	r2_col5;
	private String	r3_col1;
	private BigDecimal	r3_col2;
	private String	r3_col3;
	private BigDecimal	r3_col4;
	private BigDecimal	r3_col5;
	private String	r4_col1;
	private String	r4_col2;
	private BigDecimal	r4_col3;
	private BigDecimal	r4_col4;
	private BigDecimal	r4_col5;
	private String	r5_col1;
	private String	r5_col2;
	private BigDecimal	r5_col3;
	private BigDecimal	r5_col4;
	private BigDecimal	r5_col5;
	private String	r6_col1;
	private BigDecimal	r6_col2;
	private String	r6_col3;
	private BigDecimal	r6_col4;
	private BigDecimal	r6_col5;
	private String	r7_col1;
	private BigDecimal	r7_col2;
	private String	r7_col3;
	private BigDecimal	r7_col4;
	private BigDecimal	r7_col5;
	private String	r8_col1;
	private String	r8_col2;
	private BigDecimal	r8_col3;
	private BigDecimal	r8_col4;
	private BigDecimal	r8_col5;
	private String	r9_col1;
	private BigDecimal	r9_col2;
	private String	r9_col3;
	private BigDecimal	r9_col4;
	private BigDecimal	r9_col5;
	private String	r10_col1;
	private BigDecimal	r10_col2;
	private String	r10_col3;
	private BigDecimal	r10_col4;
	private BigDecimal	r10_col5;
	private String	r11_col1;
	private String	r11_col2;
	private BigDecimal	r11_col3;
	private BigDecimal	r11_col4;
	private BigDecimal	r11_col5;
	private String	r12_col1;
	private BigDecimal	r12_col2;
	private String	r12_col3;
	private BigDecimal	r12_col4;
	private BigDecimal	r12_col5;
	private String	r13_col1;
	private BigDecimal	r13_col2;
	private String	r13_col3;
	private BigDecimal	r13_col4;
	private BigDecimal	r13_col5;
	private String	r14_col1;
	private String	r14_col2;
	private BigDecimal	r14_col3;
	private BigDecimal	r14_col4;
	private BigDecimal	r14_col5;
	private String BANK_NAME;
	private Date	REPORTING_DATE;
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
		private String bank_name;
		public String getBank_name() {
			return bank_name;
		}
		public void setBank_name(String bank_name) {
			this.bank_name = bank_name;
		}
		public Date getReporting_date() {
			return reporting_date;
		}
		public void setReporting_date(Date reporting_date) {
			this.reporting_date = reporting_date;
		}
		private Date reporting_date;
		
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
		public String getR1_col3() {
			return r1_col3;
		}
		public void setR1_col3(String r1_col3) {
			this.r1_col3 = r1_col3;
		}
		public BigDecimal getR1_col4() {
			return r1_col4;
		}
		public void setR1_col4(BigDecimal r1_col4) {
			this.r1_col4 = r1_col4;
		}
		public BigDecimal getR1_col5() {
			return r1_col5;
		}
		public void setR1_col5(BigDecimal r1_col5) {
			this.r1_col5 = r1_col5;
		}
		public String getR2_col1() {
			return r2_col1;
		}
		public void setR2_col1(String r2_col1) {
			this.r2_col1 = r2_col1;
		}
		public BigDecimal getR2_col2() {
			return r2_col2;
		}
		public void setR2_col2(BigDecimal r2_col2) {
			this.r2_col2 = r2_col2;
		}
		public String getR2_col3() {
			return r2_col3;
		}
		public void setR2_col3(String r2_col3) {
			this.r2_col3 = r2_col3;
		}
		public BigDecimal getR2_col4() {
			return r2_col4;
		}
		public void setR2_col4(BigDecimal r2_col4) {
			this.r2_col4 = r2_col4;
		}
		public BigDecimal getR2_col5() {
			return r2_col5;
		}
		public void setR2_col5(BigDecimal r2_col5) {
			this.r2_col5 = r2_col5;
		}
		public String getR3_col1() {
			return r3_col1;
		}
		public void setR3_col1(String r3_col1) {
			this.r3_col1 = r3_col1;
		}
		public BigDecimal getR3_col2() {
			return r3_col2;
		}
		public void setR3_col2(BigDecimal r3_col2) {
			this.r3_col2 = r3_col2;
		}
		public String getR3_col3() {
			return r3_col3;
		}
		public void setR3_col3(String r3_col3) {
			this.r3_col3 = r3_col3;
		}
		public BigDecimal getR3_col4() {
			return r3_col4;
		}
		public void setR3_col4(BigDecimal r3_col4) {
			this.r3_col4 = r3_col4;
		}
		public BigDecimal getR3_col5() {
			return r3_col5;
		}
		public void setR3_col5(BigDecimal r3_col5) {
			this.r3_col5 = r3_col5;
		}
		public String getR4_col1() {
			return r4_col1;
		}
		public void setR4_col1(String r4_col1) {
			this.r4_col1 = r4_col1;
		}
		public String getR4_col2() {
			return r4_col2;
		}
		public void setR4_col2(String r4_col2) {
			this.r4_col2 = r4_col2;
		}
		public BigDecimal getR4_col3() {
			return r4_col3;
		}
		public void setR4_col3(BigDecimal r4_col3) {
			this.r4_col3 = r4_col3;
		}
		public BigDecimal getR4_col4() {
			return r4_col4;
		}
		public void setR4_col4(BigDecimal r4_col4) {
			this.r4_col4 = r4_col4;
		}
		public BigDecimal getR4_col5() {
			return r4_col5;
		}
		public void setR4_col5(BigDecimal r4_col5) {
			this.r4_col5 = r4_col5;
		}
		public String getR5_col1() {
			return r5_col1;
		}
		public void setR5_col1(String r5_col1) {
			this.r5_col1 = r5_col1;
		}
		public String getR5_col2() {
			return r5_col2;
		}
		public void setR5_col2(String r5_col2) {
			this.r5_col2 = r5_col2;
		}
		public BigDecimal getR5_col3() {
			return r5_col3;
		}
		public void setR5_col3(BigDecimal r5_col3) {
			this.r5_col3 = r5_col3;
		}
		public BigDecimal getR5_col4() {
			return r5_col4;
		}
		public void setR5_col4(BigDecimal r5_col4) {
			this.r5_col4 = r5_col4;
		}
		public BigDecimal getR5_col5() {
			return r5_col5;
		}
		public void setR5_col5(BigDecimal r5_col5) {
			this.r5_col5 = r5_col5;
		}
		public String getR6_col1() {
			return r6_col1;
		}
		public void setR6_col1(String r6_col1) {
			this.r6_col1 = r6_col1;
		}
		public BigDecimal getR6_col2() {
			return r6_col2;
		}
		public void setR6_col2(BigDecimal r6_col2) {
			this.r6_col2 = r6_col2;
		}
		public String getR6_col3() {
			return r6_col3;
		}
		public void setR6_col3(String r6_col3) {
			this.r6_col3 = r6_col3;
		}
		public BigDecimal getR6_col4() {
			return r6_col4;
		}
		public void setR6_col4(BigDecimal r6_col4) {
			this.r6_col4 = r6_col4;
		}
		public BigDecimal getR6_col5() {
			return r6_col5;
		}
		public void setR6_col5(BigDecimal r6_col5) {
			this.r6_col5 = r6_col5;
		}
		public String getR7_col1() {
			return r7_col1;
		}
		public void setR7_col1(String r7_col1) {
			this.r7_col1 = r7_col1;
		}
		public BigDecimal getR7_col2() {
			return r7_col2;
		}
		public void setR7_col2(BigDecimal r7_col2) {
			this.r7_col2 = r7_col2;
		}
		public String getR7_col3() {
			return r7_col3;
		}
		public void setR7_col3(String r7_col3) {
			this.r7_col3 = r7_col3;
		}
		public BigDecimal getR7_col4() {
			return r7_col4;
		}
		public void setR7_col4(BigDecimal r7_col4) {
			this.r7_col4 = r7_col4;
		}
		public BigDecimal getR7_col5() {
			return r7_col5;
		}
		public void setR7_col5(BigDecimal r7_col5) {
			this.r7_col5 = r7_col5;
		}
		public String getR8_col1() {
			return r8_col1;
		}
		public void setR8_col1(String r8_col1) {
			this.r8_col1 = r8_col1;
		}
		public String getR8_col2() {
			return r8_col2;
		}
		public void setR8_col2(String r8_col2) {
			this.r8_col2 = r8_col2;
		}
		public BigDecimal getR8_col3() {
			return r8_col3;
		}
		public void setR8_col3(BigDecimal r8_col3) {
			this.r8_col3 = r8_col3;
		}
		public BigDecimal getR8_col4() {
			return r8_col4;
		}
		public void setR8_col4(BigDecimal r8_col4) {
			this.r8_col4 = r8_col4;
		}
		public BigDecimal getR8_col5() {
			return r8_col5;
		}
		public void setR8_col5(BigDecimal r8_col5) {
			this.r8_col5 = r8_col5;
		}
		public String getR9_col1() {
			return r9_col1;
		}
		public void setR9_col1(String r9_col1) {
			this.r9_col1 = r9_col1;
		}
		public BigDecimal getR9_col2() {
			return r9_col2;
		}
		public void setR9_col2(BigDecimal r9_col2) {
			this.r9_col2 = r9_col2;
		}
		public String getR9_col3() {
			return r9_col3;
		}
		public void setR9_col3(String r9_col3) {
			this.r9_col3 = r9_col3;
		}
		public BigDecimal getR9_col4() {
			return r9_col4;
		}
		public void setR9_col4(BigDecimal r9_col4) {
			this.r9_col4 = r9_col4;
		}
		public BigDecimal getR9_col5() {
			return r9_col5;
		}
		public void setR9_col5(BigDecimal r9_col5) {
			this.r9_col5 = r9_col5;
		}
		public String getR10_col1() {
			return r10_col1;
		}
		public void setR10_col1(String r10_col1) {
			this.r10_col1 = r10_col1;
		}
		public BigDecimal getR10_col2() {
			return r10_col2;
		}
		public void setR10_col2(BigDecimal r10_col2) {
			this.r10_col2 = r10_col2;
		}
		public String getR10_col3() {
			return r10_col3;
		}
		public void setR10_col3(String r10_col3) {
			this.r10_col3 = r10_col3;
		}
		public BigDecimal getR10_col4() {
			return r10_col4;
		}
		public void setR10_col4(BigDecimal r10_col4) {
			this.r10_col4 = r10_col4;
		}
		public BigDecimal getR10_col5() {
			return r10_col5;
		}
		public void setR10_col5(BigDecimal r10_col5) {
			this.r10_col5 = r10_col5;
		}
		public String getR11_col1() {
			return r11_col1;
		}
		public void setR11_col1(String r11_col1) {
			this.r11_col1 = r11_col1;
		}
		public String getR11_col2() {
			return r11_col2;
		}
		public void setR11_col2(String r11_col2) {
			this.r11_col2 = r11_col2;
		}
		public BigDecimal getR11_col3() {
			return r11_col3;
		}
		public void setR11_col3(BigDecimal r11_col3) {
			this.r11_col3 = r11_col3;
		}
		public BigDecimal getR11_col4() {
			return r11_col4;
		}
		public void setR11_col4(BigDecimal r11_col4) {
			this.r11_col4 = r11_col4;
		}
		public BigDecimal getR11_col5() {
			return r11_col5;
		}
		public void setR11_col5(BigDecimal r11_col5) {
			this.r11_col5 = r11_col5;
		}
		public String getR12_col1() {
			return r12_col1;
		}
		public void setR12_col1(String r12_col1) {
			this.r12_col1 = r12_col1;
		}
		public BigDecimal getR12_col2() {
			return r12_col2;
		}
		public void setR12_col2(BigDecimal r12_col2) {
			this.r12_col2 = r12_col2;
		}
		public String getR12_col3() {
			return r12_col3;
		}
		public void setR12_col3(String r12_col3) {
			this.r12_col3 = r12_col3;
		}
		public BigDecimal getR12_col4() {
			return r12_col4;
		}
		public void setR12_col4(BigDecimal r12_col4) {
			this.r12_col4 = r12_col4;
		}
		public BigDecimal getR12_col5() {
			return r12_col5;
		}
		public void setR12_col5(BigDecimal r12_col5) {
			this.r12_col5 = r12_col5;
		}
		public String getR13_col1() {
			return r13_col1;
		}
		public void setR13_col1(String r13_col1) {
			this.r13_col1 = r13_col1;
		}
		public BigDecimal getR13_col2() {
			return r13_col2;
		}
		public void setR13_col2(BigDecimal r13_col2) {
			this.r13_col2 = r13_col2;
		}
		public String getR13_col3() {
			return r13_col3;
		}
		public void setR13_col3(String r13_col3) {
			this.r13_col3 = r13_col3;
		}
		public BigDecimal getR13_col4() {
			return r13_col4;
		}
		public void setR13_col4(BigDecimal r13_col4) {
			this.r13_col4 = r13_col4;
		}
		public BigDecimal getR13_col5() {
			return r13_col5;
		}
		public void setR13_col5(BigDecimal r13_col5) {
			this.r13_col5 = r13_col5;
		}
		public String getR14_col1() {
			return r14_col1;
		}
		public void setR14_col1(String r14_col1) {
			this.r14_col1 = r14_col1;
		}
		public String getR14_col2() {
			return r14_col2;
		}
		public void setR14_col2(String r14_col2) {
			this.r14_col2 = r14_col2;
		}
		public BigDecimal getR14_col3() {
			return r14_col3;
		}
		public void setR14_col3(BigDecimal r14_col3) {
			this.r14_col3 = r14_col3;
		}
		public BigDecimal getR14_col4() {
			return r14_col4;
		}
		public void setR14_col4(BigDecimal r14_col4) {
			this.r14_col4 = r14_col4;
		}
		public BigDecimal getR14_col5() {
			return r14_col5;
		}
		public void setR14_col5(BigDecimal r14_col5) {
			this.r14_col5 = r14_col5;
		}
		public String getBANK_NAME() {
			return BANK_NAME;
		}
		public void setBANK_NAME(String bANK_NAME) {
			BANK_NAME = bANK_NAME;
		}
		public Date getREPORTING_DATE() {
			return REPORTING_DATE;
		}
		public void setREPORTING_DATE(Date rEPORTING_DATE) {
			REPORTING_DATE = rEPORTING_DATE;
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
		public B14Reportentity() {
			super();
			// TODO Auto-generated constructor stub
		}
		
}