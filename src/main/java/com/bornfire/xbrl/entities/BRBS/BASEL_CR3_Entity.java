package com.bornfire.xbrl.entities.BRBS;
import java.math.BigDecimal;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CR3")

public class BASEL_CR3_Entity {
	private String	r11_product;
	private BigDecimal	r11_exposure_before;
	private BigDecimal	r11_crm;
	private String	r11_credit_conversion;
	private BigDecimal	r11_exposure_after;
	private String	r13_product;
	private BigDecimal	r13_exposure_before;
	private BigDecimal	r13_crm;
	private String	r13_credit_conversion;
	private BigDecimal	r13_exposure_after;
	private String	r15_product;
	private BigDecimal	r15_exposure_before;
	private BigDecimal	r15_crm;
	private String	r15_credit_conversion;
	private BigDecimal	r15_exposure_after;
	private String	r17_product;
	private BigDecimal	r17_exposure_before;
	private BigDecimal	r17_crm;
	private String	r17_credit_conversion;
	private BigDecimal	r17_exposure_after;
	private String	r19_product;
	private BigDecimal	r19_exposure_before;
	private BigDecimal	r19_crm;
	private BigDecimal	r19_exposure_after;
	private String	r22_product;
	private BigDecimal	r22_exposure_before;
	private BigDecimal	r22_crm;
	private String	r22_credit_conversion;
	private BigDecimal	r22_exposure_after;
	private String	r24_product;
	private BigDecimal	r24_exposure_before;
	private BigDecimal	r24_crm;
	private String	r24_credit_conversion;
	private BigDecimal	r24_exposure_after;
	private String	r26_product;
	private BigDecimal	r26_exposure_before;
	private BigDecimal	r26_crm;
	private String	r26_credit_conversion;
	private BigDecimal	r26_exposure_after;
	private String	r28_product;
	private BigDecimal	r28_exposure_before;
	private BigDecimal	r28_crm;
	private String	r31_product;
	private BigDecimal	r31_exposure_before;
	private BigDecimal	r31_crm;
	private String	r31_credit_conversion;
	private BigDecimal	r31_exposure_after;
	private String	r33_product;
	private BigDecimal	r33_exposure_before;
	private BigDecimal	r33_crm;
	private String	r33_credit_conversion;
	private BigDecimal	r33_exposure_after;
	private String	r35_product;
	private BigDecimal	r35_exposure_before;
	private BigDecimal	r35_crm;
	private String	r35_credit_conversion;
	private BigDecimal	r35_exposure_after;
	private String	r38_product;
	private BigDecimal	r38_exposure_before;
	private BigDecimal	r38_crm;
	private String	r38_credit_conversion;
	private BigDecimal	r38_exposure_after;
	private String	r41_product;
	private BigDecimal	r41_exposure_before;
	private BigDecimal	r41_crm;
	private BigDecimal	r41_exposure_after;
	private String	r44_product;
	private BigDecimal	r44_exposure_before;
	private String	r47_product;
	private BigDecimal	r47_exposure_before;
	private String	bank_name;
	private String	reporing_date;
	private BigDecimal	r28_exposure_after;
	@Id
	private Date	report_date;
	private Date	report_from_date;
	private Date	report_to_date;
	private String	entity_flg;
	private String	modify_flg;
	private String	del_flg;
	private String	report_code;
	private Date	report_submit_date;
	public String getR11_product() {
		return r11_product;
	}
	public void setR11_product(String r11_product) {
		this.r11_product = r11_product;
	}
	public BigDecimal getR11_exposure_before() {
		return r11_exposure_before;
	}
	public void setR11_exposure_before(BigDecimal r11_exposure_before) {
		this.r11_exposure_before = r11_exposure_before;
	}
	public BigDecimal getR11_crm() {
		return r11_crm;
	}
	public void setR11_crm(BigDecimal r11_crm) {
		this.r11_crm = r11_crm;
	}
	public String getR11_credit_conversion() {
		return r11_credit_conversion;
	}
	public void setR11_credit_conversion(String r11_credit_conversion) {
		this.r11_credit_conversion = r11_credit_conversion;
	}
	public BigDecimal getR11_exposure_after() {
		return r11_exposure_after;
	}
	public void setR11_exposure_after(BigDecimal r11_exposure_after) {
		this.r11_exposure_after = r11_exposure_after;
	}
	public String getR13_product() {
		return r13_product;
	}
	public void setR13_product(String r13_product) {
		this.r13_product = r13_product;
	}
	public BigDecimal getR13_exposure_before() {
		return r13_exposure_before;
	}
	public void setR13_exposure_before(BigDecimal r13_exposure_before) {
		this.r13_exposure_before = r13_exposure_before;
	}
	public BigDecimal getR13_crm() {
		return r13_crm;
	}
	public void setR13_crm(BigDecimal r13_crm) {
		this.r13_crm = r13_crm;
	}
	public String getR13_credit_conversion() {
		return r13_credit_conversion;
	}
	public void setR13_credit_conversion(String r13_credit_conversion) {
		this.r13_credit_conversion = r13_credit_conversion;
	}
	public BigDecimal getR13_exposure_after() {
		return r13_exposure_after;
	}
	public void setR13_exposure_after(BigDecimal r13_exposure_after) {
		this.r13_exposure_after = r13_exposure_after;
	}
	public String getR15_product() {
		return r15_product;
	}
	public void setR15_product(String r15_product) {
		this.r15_product = r15_product;
	}
	public BigDecimal getR15_exposure_before() {
		return r15_exposure_before;
	}
	public void setR15_exposure_before(BigDecimal r15_exposure_before) {
		this.r15_exposure_before = r15_exposure_before;
	}
	public BigDecimal getR15_crm() {
		return r15_crm;
	}
	public void setR15_crm(BigDecimal r15_crm) {
		this.r15_crm = r15_crm;
	}
	public String getR15_credit_conversion() {
		return r15_credit_conversion;
	}
	public void setR15_credit_conversion(String r15_credit_conversion) {
		this.r15_credit_conversion = r15_credit_conversion;
	}
	public BigDecimal getR15_exposure_after() {
		return r15_exposure_after;
	}
	public void setR15_exposure_after(BigDecimal r15_exposure_after) {
		this.r15_exposure_after = r15_exposure_after;
	}
	public String getR17_product() {
		return r17_product;
	}
	public void setR17_product(String r17_product) {
		this.r17_product = r17_product;
	}
	public BigDecimal getR17_exposure_before() {
		return r17_exposure_before;
	}
	public void setR17_exposure_before(BigDecimal r17_exposure_before) {
		this.r17_exposure_before = r17_exposure_before;
	}
	public BigDecimal getR17_crm() {
		return r17_crm;
	}
	public void setR17_crm(BigDecimal r17_crm) {
		this.r17_crm = r17_crm;
	}
	public String getR17_credit_conversion() {
		return r17_credit_conversion;
	}
	public void setR17_credit_conversion(String r17_credit_conversion) {
		this.r17_credit_conversion = r17_credit_conversion;
	}
	public BigDecimal getR17_exposure_after() {
		return r17_exposure_after;
	}
	public void setR17_exposure_after(BigDecimal r17_exposure_after) {
		this.r17_exposure_after = r17_exposure_after;
	}
	public String getR19_product() {
		return r19_product;
	}
	public void setR19_product(String r19_product) {
		this.r19_product = r19_product;
	}
	public BigDecimal getR19_exposure_before() {
		return r19_exposure_before;
	}
	public void setR19_exposure_before(BigDecimal r19_exposure_before) {
		this.r19_exposure_before = r19_exposure_before;
	}
	public BigDecimal getR19_crm() {
		return r19_crm;
	}
	public void setR19_crm(BigDecimal r19_crm) {
		this.r19_crm = r19_crm;
	}
	public BigDecimal getR19_exposure_after() {
		return r19_exposure_after;
	}
	public void setR19_exposure_after(BigDecimal r19_exposure_after) {
		this.r19_exposure_after = r19_exposure_after;
	}
	public String getR22_product() {
		return r22_product;
	}
	public void setR22_product(String r22_product) {
		this.r22_product = r22_product;
	}
	public BigDecimal getR22_exposure_before() {
		return r22_exposure_before;
	}
	public void setR22_exposure_before(BigDecimal r22_exposure_before) {
		this.r22_exposure_before = r22_exposure_before;
	}
	public BigDecimal getR22_crm() {
		return r22_crm;
	}
	public void setR22_crm(BigDecimal r22_crm) {
		this.r22_crm = r22_crm;
	}
	public String getR22_credit_conversion() {
		return r22_credit_conversion;
	}
	public void setR22_credit_conversion(String r22_credit_conversion) {
		this.r22_credit_conversion = r22_credit_conversion;
	}
	public BigDecimal getR22_exposure_after() {
		return r22_exposure_after;
	}
	public void setR22_exposure_after(BigDecimal r22_exposure_after) {
		this.r22_exposure_after = r22_exposure_after;
	}
	public String getR24_product() {
		return r24_product;
	}
	public void setR24_product(String r24_product) {
		this.r24_product = r24_product;
	}
	public BigDecimal getR24_exposure_before() {
		return r24_exposure_before;
	}
	public void setR24_exposure_before(BigDecimal r24_exposure_before) {
		this.r24_exposure_before = r24_exposure_before;
	}
	public BigDecimal getR24_crm() {
		return r24_crm;
	}
	public void setR24_crm(BigDecimal r24_crm) {
		this.r24_crm = r24_crm;
	}
	public String getR24_credit_conversion() {
		return r24_credit_conversion;
	}
	public void setR24_credit_conversion(String r24_credit_conversion) {
		this.r24_credit_conversion = r24_credit_conversion;
	}
	public BigDecimal getR24_exposure_after() {
		return r24_exposure_after;
	}
	public void setR24_exposure_after(BigDecimal r24_exposure_after) {
		this.r24_exposure_after = r24_exposure_after;
	}
	public String getR26_product() {
		return r26_product;
	}
	public void setR26_product(String r26_product) {
		this.r26_product = r26_product;
	}
	public BigDecimal getR26_exposure_before() {
		return r26_exposure_before;
	}
	public void setR26_exposure_before(BigDecimal r26_exposure_before) {
		this.r26_exposure_before = r26_exposure_before;
	}
	public BigDecimal getR26_crm() {
		return r26_crm;
	}
	public void setR26_crm(BigDecimal r26_crm) {
		this.r26_crm = r26_crm;
	}
	public String getR26_credit_conversion() {
		return r26_credit_conversion;
	}
	public void setR26_credit_conversion(String r26_credit_conversion) {
		this.r26_credit_conversion = r26_credit_conversion;
	}
	public BigDecimal getR26_exposure_after() {
		return r26_exposure_after;
	}
	public void setR26_exposure_after(BigDecimal r26_exposure_after) {
		this.r26_exposure_after = r26_exposure_after;
	}
	public String getR28_product() {
		return r28_product;
	}
	public void setR28_product(String r28_product) {
		this.r28_product = r28_product;
	}
	public BigDecimal getR28_exposure_before() {
		return r28_exposure_before;
	}
	public void setR28_exposure_before(BigDecimal r28_exposure_before) {
		this.r28_exposure_before = r28_exposure_before;
	}
	public BigDecimal getR28_crm() {
		return r28_crm;
	}
	public void setR28_crm(BigDecimal r28_crm) {
		this.r28_crm = r28_crm;
	}
	public String getR31_product() {
		return r31_product;
	}
	public void setR31_product(String r31_product) {
		this.r31_product = r31_product;
	}
	public BigDecimal getR31_exposure_before() {
		return r31_exposure_before;
	}
	public void setR31_exposure_before(BigDecimal r31_exposure_before) {
		this.r31_exposure_before = r31_exposure_before;
	}
	public BigDecimal getR31_crm() {
		return r31_crm;
	}
	public void setR31_crm(BigDecimal r31_crm) {
		this.r31_crm = r31_crm;
	}
	public String getR31_credit_conversion() {
		return r31_credit_conversion;
	}
	public void setR31_credit_conversion(String r31_credit_conversion) {
		this.r31_credit_conversion = r31_credit_conversion;
	}
	public BigDecimal getR31_exposure_after() {
		return r31_exposure_after;
	}
	public void setR31_exposure_after(BigDecimal r31_exposure_after) {
		this.r31_exposure_after = r31_exposure_after;
	}
	public String getR33_product() {
		return r33_product;
	}
	public void setR33_product(String r33_product) {
		this.r33_product = r33_product;
	}
	public BigDecimal getR33_exposure_before() {
		return r33_exposure_before;
	}
	public void setR33_exposure_before(BigDecimal r33_exposure_before) {
		this.r33_exposure_before = r33_exposure_before;
	}
	public BigDecimal getR33_crm() {
		return r33_crm;
	}
	public void setR33_crm(BigDecimal r33_crm) {
		this.r33_crm = r33_crm;
	}
	public String getR33_credit_conversion() {
		return r33_credit_conversion;
	}
	public void setR33_credit_conversion(String r33_credit_conversion) {
		this.r33_credit_conversion = r33_credit_conversion;
	}
	public BigDecimal getR33_exposure_after() {
		return r33_exposure_after;
	}
	public void setR33_exposure_after(BigDecimal r33_exposure_after) {
		this.r33_exposure_after = r33_exposure_after;
	}
	public String getR35_product() {
		return r35_product;
	}
	public void setR35_product(String r35_product) {
		this.r35_product = r35_product;
	}
	public BigDecimal getR35_exposure_before() {
		return r35_exposure_before;
	}
	public void setR35_exposure_before(BigDecimal r35_exposure_before) {
		this.r35_exposure_before = r35_exposure_before;
	}
	public BigDecimal getR35_crm() {
		return r35_crm;
	}
	public void setR35_crm(BigDecimal r35_crm) {
		this.r35_crm = r35_crm;
	}
	public String getR35_credit_conversion() {
		return r35_credit_conversion;
	}
	public void setR35_credit_conversion(String r35_credit_conversion) {
		this.r35_credit_conversion = r35_credit_conversion;
	}
	public BigDecimal getR35_exposure_after() {
		return r35_exposure_after;
	}
	public void setR35_exposure_after(BigDecimal r35_exposure_after) {
		this.r35_exposure_after = r35_exposure_after;
	}
	public String getR38_product() {
		return r38_product;
	}
	public void setR38_product(String r38_product) {
		this.r38_product = r38_product;
	}
	public BigDecimal getR38_exposure_before() {
		return r38_exposure_before;
	}
	public void setR38_exposure_before(BigDecimal r38_exposure_before) {
		this.r38_exposure_before = r38_exposure_before;
	}
	public BigDecimal getR38_crm() {
		return r38_crm;
	}
	public void setR38_crm(BigDecimal r38_crm) {
		this.r38_crm = r38_crm;
	}
	public String getR38_credit_conversion() {
		return r38_credit_conversion;
	}
	public void setR38_credit_conversion(String r38_credit_conversion) {
		this.r38_credit_conversion = r38_credit_conversion;
	}
	public BigDecimal getR38_exposure_after() {
		return r38_exposure_after;
	}
	public void setR38_exposure_after(BigDecimal r38_exposure_after) {
		this.r38_exposure_after = r38_exposure_after;
	}
	public String getR41_product() {
		return r41_product;
	}
	public void setR41_product(String r41_product) {
		this.r41_product = r41_product;
	}
	public BigDecimal getR41_exposure_before() {
		return r41_exposure_before;
	}
	public void setR41_exposure_before(BigDecimal r41_exposure_before) {
		this.r41_exposure_before = r41_exposure_before;
	}
	public BigDecimal getR41_crm() {
		return r41_crm;
	}
	public void setR41_crm(BigDecimal r41_crm) {
		this.r41_crm = r41_crm;
	}
	public BigDecimal getR41_exposure_after() {
		return r41_exposure_after;
	}
	public void setR41_exposure_after(BigDecimal r41_exposure_after) {
		this.r41_exposure_after = r41_exposure_after;
	}
	public String getR44_product() {
		return r44_product;
	}
	public void setR44_product(String r44_product) {
		this.r44_product = r44_product;
	}
	public BigDecimal getR44_exposure_before() {
		return r44_exposure_before;
	}
	public void setR44_exposure_before(BigDecimal r44_exposure_before) {
		this.r44_exposure_before = r44_exposure_before;
	}
	public String getR47_product() {
		return r47_product;
	}
	public void setR47_product(String r47_product) {
		this.r47_product = r47_product;
	}
	public BigDecimal getR47_exposure_before() {
		return r47_exposure_before;
	}
	public void setR47_exposure_before(BigDecimal r47_exposure_before) {
		this.r47_exposure_before = r47_exposure_before;
	}
	public String getBank_name() {
		return bank_name;
	}
	public void setBank_name(String bank_name) {
		this.bank_name = bank_name;
	}
	public String getReporing_date() {
		return reporing_date;
	}
	public void setReporing_date(String reporing_date) {
		this.reporing_date = reporing_date;
	}
	public BigDecimal getR28_exposure_after() {
		return r28_exposure_after;
	}
	public void setR28_exposure_after(BigDecimal r28_exposure_after) {
		this.r28_exposure_after = r28_exposure_after;
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
	public BASEL_CR3_Entity() {
		super();
		// TODO Auto-generated constructor stub
	}

}
