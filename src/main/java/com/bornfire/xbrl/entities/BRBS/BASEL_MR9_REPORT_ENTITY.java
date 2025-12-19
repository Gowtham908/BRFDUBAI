package com.bornfire.xbrl.entities.BRBS;
import java.math.BigDecimal;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="MR9")


public class BASEL_MR9_REPORT_ENTITY {
	
	private  String	r1_product;
	private BigDecimal	r1_marketvalue;
	private BigDecimal	r1_deltaweighted;
	private BigDecimal	r1_calculation;
	private BigDecimal	r1_gammaimpact;
	private BigDecimal	r1_gammacapitalcharge;
	private BigDecimal	r1_vegacharge;
	private BigDecimal	r1_capitalcharge;
	private String	r2_product;
	private BigDecimal	r2_marketvalue;
	private BigDecimal	r2_deltaweighted;
	private BigDecimal	r2_calculation;
	private BigDecimal	r2_gammaimpact;
	private BigDecimal	r2_gammacapitalcharge;
	private BigDecimal	r2_vegacharge;
	private BigDecimal	r2_capitalcharge;
	private String	r3_product;
	private BigDecimal	r3_marketvalue;
	private BigDecimal	r3_deltaweighted;
	private BigDecimal	r3_calculation;
	private BigDecimal	r3_gammaimpact;
	private BigDecimal	r3_gammacapitalcharge;
	private BigDecimal	r3_vegacharge;
	private BigDecimal	r3_capitalcharge;
	private String	r4_product;
	private BigDecimal	r4_marketvalue;
	private BigDecimal	r4_deltaweighted;
	private BigDecimal	r4_calculation;
	private BigDecimal	r4_gammaimpact;
	private BigDecimal	r4_gammacapitalcharge;
	private BigDecimal	r4_vegacharge;
	private BigDecimal	r4_capitalcharge;
	private String	r5_product;
	private BigDecimal	r5_marketvalue;
	private BigDecimal	r5_deltaweighted;
	private BigDecimal	r5_calculation;
	private BigDecimal	r5_gammaimpact;
	private BigDecimal	r5_gammacapitalcharge;
	private BigDecimal       r5_vegacharge;
	private BigDecimal	r5_capitalcharge;
	@Id
		private Date	report_date;
		private Date	report_from_date;
		private	Date report_to_date;
		private String	entity_flg;
		private String	modify_flg;
		private String	del_flg;
		private String	report_code;
		private Date	report_submit_date;
		public String getR1_product() {
			return r1_product;
		}
		public void setR1_product(String r1_product) {
			this.r1_product = r1_product;
		}
		public BigDecimal getR1_marketvalue() {
			return r1_marketvalue;
		}
		public void setR1_marketvalue(BigDecimal r1_marketvalue) {
			this.r1_marketvalue = r1_marketvalue;
		}
		public BigDecimal getR1_deltaweighted() {
			return r1_deltaweighted;
		}
		public void setR1_deltaweighted(BigDecimal r1_deltaweighted) {
			this.r1_deltaweighted = r1_deltaweighted;
		}
		public BigDecimal getR1_calculation() {
			return r1_calculation;
		}
		public void setR1_calculation(BigDecimal r1_calculation) {
			this.r1_calculation = r1_calculation;
		}
		public BigDecimal getR1_gammaimpact() {
			return r1_gammaimpact;
		}
		public void setR1_gammaimpact(BigDecimal r1_gammaimpact) {
			this.r1_gammaimpact = r1_gammaimpact;
		}
		public BigDecimal getR1_gammacapitalcharge() {
			return r1_gammacapitalcharge;
		}
		public void setR1_gammacapitalcharge(BigDecimal r1_gammacapitalcharge) {
			this.r1_gammacapitalcharge = r1_gammacapitalcharge;
		}
		public BigDecimal getR1_vegacharge() {
			return r1_vegacharge;
		}
		public void setR1_vegacharge(BigDecimal r1_vegacharge) {
			this.r1_vegacharge = r1_vegacharge;
		}
		public BigDecimal getR1_capitalcharge() {
			return r1_capitalcharge;
		}
		public void setR1_capitalcharge(BigDecimal r1_capitalcharge) {
			this.r1_capitalcharge = r1_capitalcharge;
		}
		public String getR2_product() {
			return r2_product;
		}
		public void setR2_product(String r2_product) {
			this.r2_product = r2_product;
		}
		public BigDecimal getR2_marketvalue() {
			return r2_marketvalue;
		}
		public void setR2_marketvalue(BigDecimal r2_marketvalue) {
			this.r2_marketvalue = r2_marketvalue;
		}
		public BigDecimal getR2_deltaweighted() {
			return r2_deltaweighted;
		}
		public void setR2_deltaweighted(BigDecimal r2_deltaweighted) {
			this.r2_deltaweighted = r2_deltaweighted;
		}
		public BigDecimal getR2_calculation() {
			return r2_calculation;
		}
		public void setR2_calculation(BigDecimal r2_calculation) {
			this.r2_calculation = r2_calculation;
		}
		public BigDecimal getR2_gammaimpact() {
			return r2_gammaimpact;
		}
		public void setR2_gammaimpact(BigDecimal r2_gammaimpact) {
			this.r2_gammaimpact = r2_gammaimpact;
		}
		public BigDecimal getR2_gammacapitalcharge() {
			return r2_gammacapitalcharge;
		}
		public void setR2_gammacapitalcharge(BigDecimal r2_gammacapitalcharge) {
			this.r2_gammacapitalcharge = r2_gammacapitalcharge;
		}
		public BigDecimal getR2_vegacharge() {
			return r2_vegacharge;
		}
		public void setR2_vegacharge(BigDecimal r2_vegacharge) {
			this.r2_vegacharge = r2_vegacharge;
		}
		public BigDecimal getR2_capitalcharge() {
			return r2_capitalcharge;
		}
		public void setR2_capitalcharge(BigDecimal r2_capitalcharge) {
			this.r2_capitalcharge = r2_capitalcharge;
		}
		public String getR3_product() {
			return r3_product;
		}
		public void setR3_product(String r3_product) {
			this.r3_product = r3_product;
		}
		public BigDecimal getR3_marketvalue() {
			return r3_marketvalue;
		}
		public void setR3_marketvalue(BigDecimal r3_marketvalue) {
			this.r3_marketvalue = r3_marketvalue;
		}
		public BigDecimal getR3_deltaweighted() {
			return r3_deltaweighted;
		}
		public void setR3_deltaweighted(BigDecimal r3_deltaweighted) {
			this.r3_deltaweighted = r3_deltaweighted;
		}
		public BigDecimal getR3_calculation() {
			return r3_calculation;
		}
		public void setR3_calculation(BigDecimal r3_calculation) {
			this.r3_calculation = r3_calculation;
		}
		public BigDecimal getR3_gammaimpact() {
			return r3_gammaimpact;
		}
		public void setR3_gammaimpact(BigDecimal r3_gammaimpact) {
			this.r3_gammaimpact = r3_gammaimpact;
		}
		public BigDecimal getR3_gammacapitalcharge() {
			return r3_gammacapitalcharge;
		}
		public void setR3_gammacapitalcharge(BigDecimal r3_gammacapitalcharge) {
			this.r3_gammacapitalcharge = r3_gammacapitalcharge;
		}
		public BigDecimal getR3_vegacharge() {
			return r3_vegacharge;
		}
		public void setR3_vegacharge(BigDecimal r3_vegacharge) {
			this.r3_vegacharge = r3_vegacharge;
		}
		public BigDecimal getR3_capitalcharge() {
			return r3_capitalcharge;
		}
		public void setR3_capitalcharge(BigDecimal r3_capitalcharge) {
			this.r3_capitalcharge = r3_capitalcharge;
		}
		public String getR4_product() {
			return r4_product;
		}
		public void setR4_product(String r4_product) {
			this.r4_product = r4_product;
		}
		public BigDecimal getR4_marketvalue() {
			return r4_marketvalue;
		}
		public void setR4_marketvalue(BigDecimal r4_marketvalue) {
			this.r4_marketvalue = r4_marketvalue;
		}
		public BigDecimal getR4_deltaweighted() {
			return r4_deltaweighted;
		}
		public void setR4_deltaweighted(BigDecimal r4_deltaweighted) {
			this.r4_deltaweighted = r4_deltaweighted;
		}
		public BigDecimal getR4_calculation() {
			return r4_calculation;
		}
		public void setR4_calculation(BigDecimal r4_calculation) {
			this.r4_calculation = r4_calculation;
		}
		public BigDecimal getR4_gammaimpact() {
			return r4_gammaimpact;
		}
		public void setR4_gammaimpact(BigDecimal r4_gammaimpact) {
			this.r4_gammaimpact = r4_gammaimpact;
		}
		public BigDecimal getR4_gammacapitalcharge() {
			return r4_gammacapitalcharge;
		}
		public void setR4_gammacapitalcharge(BigDecimal r4_gammacapitalcharge) {
			this.r4_gammacapitalcharge = r4_gammacapitalcharge;
		}
		public BigDecimal getR4_vegacharge() {
			return r4_vegacharge;
		}
		public void setR4_vegacharge(BigDecimal r4_vegacharge) {
			this.r4_vegacharge = r4_vegacharge;
		}
		public BigDecimal getR4_capitalcharge() {
			return r4_capitalcharge;
		}
		public void setR4_capitalcharge(BigDecimal r4_capitalcharge) {
			this.r4_capitalcharge = r4_capitalcharge;
		}
		public String getR5_product() {
			return r5_product;
		}
		public void setR5_product(String r5_product) {
			this.r5_product = r5_product;
		}
		public BigDecimal getR5_marketvalue() {
			return r5_marketvalue;
		}
		public void setR5_marketvalue(BigDecimal r5_marketvalue) {
			this.r5_marketvalue = r5_marketvalue;
		}
		public BigDecimal getR5_deltaweighted() {
			return r5_deltaweighted;
		}
		public void setR5_deltaweighted(BigDecimal r5_deltaweighted) {
			this.r5_deltaweighted = r5_deltaweighted;
		}
		public BigDecimal getR5_calculation() {
			return r5_calculation;
		}
		public void setR5_calculation(BigDecimal r5_calculation) {
			this.r5_calculation = r5_calculation;
		}
		public BigDecimal getR5_gammaimpact() {
			return r5_gammaimpact;
		}
		public void setR5_gammaimpact(BigDecimal r5_gammaimpact) {
			this.r5_gammaimpact = r5_gammaimpact;
		}
		public BigDecimal getR5_gammacapitalcharge() {
			return r5_gammacapitalcharge;
		}
		public void setR5_gammacapitalcharge(BigDecimal r5_gammacapitalcharge) {
			this.r5_gammacapitalcharge = r5_gammacapitalcharge;
		}
		public BigDecimal getR5_vegacharge() {
			return r5_vegacharge;
		}
		public void setR5_vegacharge(BigDecimal r5_vegacharge) {
			this.r5_vegacharge = r5_vegacharge;
		}
		public BigDecimal getR5_capitalcharge() {
			return r5_capitalcharge;
		}
		public void setR5_capitalcharge(BigDecimal r5_capitalcharge) {
			this.r5_capitalcharge = r5_capitalcharge;
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
		public BASEL_MR9_REPORT_ENTITY() {
			super();
			// TODO Auto-generated constructor stub
		}

		}
