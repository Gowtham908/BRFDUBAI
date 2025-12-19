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
@Table(name="CV1_T2")

public class B13_1Reportentity {
	private String	r3_col1;
	private BigDecimal	r3_col2;
	private BigDecimal	r3_col3;
	private BigDecimal	r3_col4;
	private BigDecimal	r3_col5;
	private BigDecimal	r3_col6;
	private String	r4_col1;
	private BigDecimal	r4_col2;
	private BigDecimal	r4_col3;
	private BigDecimal	r4_col4;
	private BigDecimal	r4_col5;
	private BigDecimal	r4_col6;
	private String	r5_col1;
	private BigDecimal	r5_col2;
	private BigDecimal	r5_col3;
	private BigDecimal	r5_col4;
	private BigDecimal	r5_col5;
	private BigDecimal	r5_col6;
	private String	r6_col1;
	private BigDecimal	r6_col2;
	private BigDecimal	r6_col3;
	private BigDecimal	r6_col4;
	private BigDecimal	r6_col5;
	private BigDecimal	r6_col6;
	private String	r7_col1;
	private BigDecimal	r7_col2;
	private BigDecimal	r7_col3;
	private BigDecimal	r7_col4;
	private BigDecimal	r7_col5;
	private BigDecimal	r7_col6;
	private String	r8_col1;
	private BigDecimal	r8_col2;
	private BigDecimal	r8_col3;
	private BigDecimal	r8_col4;
	private BigDecimal	r8_col5;
	private BigDecimal	r8_col6;
	private String	r9_col1;
	private BigDecimal	r9_col2;
	private BigDecimal	r9_col3;
	private BigDecimal	r9_col4;
	private BigDecimal	r9_col5;
	private BigDecimal	r9_col6;
	private String	r10_col1;
	private BigDecimal	r10_col2;
	private BigDecimal	r10_col3;
	private BigDecimal	r10_col4;
	private BigDecimal	r10_col5;
	private BigDecimal	r10_col6;
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
		public BigDecimal getR3_col3() {
			return r3_col3;
		}
		public void setR3_col3(BigDecimal r3_col3) {
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
		public BigDecimal getR3_col6() {
			return r3_col6;
		}
		public void setR3_col6(BigDecimal r3_col6) {
			this.r3_col6 = r3_col6;
		}
		public String getR4_col1() {
			return r4_col1;
		}
		public void setR4_col1(String r4_col1) {
			this.r4_col1 = r4_col1;
		}
		public BigDecimal getR4_col2() {
			return r4_col2;
		}
		public void setR4_col2(BigDecimal r4_col2) {
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
		public BigDecimal getR4_col6() {
			return r4_col6;
		}
		public void setR4_col6(BigDecimal r4_col6) {
			this.r4_col6 = r4_col6;
		}
		public String getR5_col1() {
			return r5_col1;
		}
		public void setR5_col1(String r5_col1) {
			this.r5_col1 = r5_col1;
		}
		public BigDecimal getR5_col2() {
			return r5_col2;
		}
		public void setR5_col2(BigDecimal r5_col2) {
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
		public BigDecimal getR5_col6() {
			return r5_col6;
		}
		public void setR5_col6(BigDecimal r5_col6) {
			this.r5_col6 = r5_col6;
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
		public BigDecimal getR6_col3() {
			return r6_col3;
		}
		public void setR6_col3(BigDecimal r6_col3) {
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
		public BigDecimal getR6_col6() {
			return r6_col6;
		}
		public void setR6_col6(BigDecimal r6_col6) {
			this.r6_col6 = r6_col6;
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
		public BigDecimal getR7_col3() {
			return r7_col3;
		}
		public void setR7_col3(BigDecimal r7_col3) {
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
		public BigDecimal getR7_col6() {
			return r7_col6;
		}
		public void setR7_col6(BigDecimal r7_col6) {
			this.r7_col6 = r7_col6;
		}
		public String getR8_col1() {
			return r8_col1;
		}
		public void setR8_col1(String r8_col1) {
			this.r8_col1 = r8_col1;
		}
		public BigDecimal getR8_col2() {
			return r8_col2;
		}
		public void setR8_col2(BigDecimal r8_col2) {
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
		public BigDecimal getR8_col6() {
			return r8_col6;
		}
		public void setR8_col6(BigDecimal r8_col6) {
			this.r8_col6 = r8_col6;
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
		public BigDecimal getR9_col3() {
			return r9_col3;
		}
		public void setR9_col3(BigDecimal r9_col3) {
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
		public BigDecimal getR9_col6() {
			return r9_col6;
		}
		public void setR9_col6(BigDecimal r9_col6) {
			this.r9_col6 = r9_col6;
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
		public BigDecimal getR10_col3() {
			return r10_col3;
		}
		public void setR10_col3(BigDecimal r10_col3) {
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
		public BigDecimal getR10_col6() {
			return r10_col6;
		}
		public void setR10_col6(BigDecimal r10_col6) {
			this.r10_col6 = r10_col6;
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
		public B13_1Reportentity() {
			super();
			// TODO Auto-generated constructor stub
		}
		
}
