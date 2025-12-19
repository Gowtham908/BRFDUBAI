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
@Table(name="SR1")
public class BASELL_12_ENTITY {
	private String	r6_product;
	private BigDecimal	r6_unset_tra_set_price;
	private BigDecimal	r6_pri_dif_expo_unset_tran;
	private BigDecimal	r6_risk_multipier;
	private BigDecimal	r6_capital_req_basel;
	private BigDecimal	r6_capital_req_uae;
	private String	r7_product;
	private BigDecimal	r7_unset_tra_set_price;
	private BigDecimal	r7_pri_dif_expo_unset_tran;
	private BigDecimal	r7_risk_multipier;
	private BigDecimal	r7_capital_req_basel;
	private BigDecimal	r7_capital_req_uae;
	private String	r8_product;
	private BigDecimal	r8_unset_tra_set_price;
	private BigDecimal	r8_pri_dif_expo_unset_tran;
	private BigDecimal	r8_risk_multipier;
	private BigDecimal	r8_capital_req_basel;
	private BigDecimal	r8_capital_req_uae;
	private String	r9_product;
	private BigDecimal	r9_unset_tra_set_price;
	private BigDecimal	r9_pri_dif_expo_unset_tran;
	private BigDecimal	r9_risk_multipier;
	private BigDecimal	r9_capital_req_basel;
	private BigDecimal	r9_capital_req_uae;
	private String	r10_product;
	private BigDecimal	r10_unset_tra_set_price;
	private BigDecimal	r10_pri_dif_expo_unset_tran;
	private BigDecimal	r10_risk_multipier;
	private BigDecimal	r10_capital_req_basel;
	private BigDecimal	r10_capital_req_uae;
	private String	r11_product;
	private BigDecimal	r11_unset_tra_set_price;
	private BigDecimal	r11_pri_dif_expo_unset_tran;
	private BigDecimal	r11_risk_multipier;
	private BigDecimal	r11_capital_req_basel;
	private BigDecimal	r11_capital_req_uae;
	private String	r14_product;
	private BigDecimal	r14_capital_req_basel;
	private BigDecimal	r14_capital_req_uae;
	private String	r19_product;
	private String	r19_xyz_bank;
	private String	r20_product;

	
	private Date	r20_reporting_date;

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
	public String getR6_product() {
		return r6_product;
	}
	public void setR6_product(String r6_product) {
		this.r6_product = r6_product;
	}
	public BigDecimal getR6_unset_tra_set_price() {
		return r6_unset_tra_set_price;
	}
	public void setR6_unset_tra_set_price(BigDecimal r6_unset_tra_set_price) {
		this.r6_unset_tra_set_price = r6_unset_tra_set_price;
	}
	public BigDecimal getR6_pri_dif_expo_unset_tran() {
		return r6_pri_dif_expo_unset_tran;
	}
	public void setR6_pri_dif_expo_unset_tran(BigDecimal r6_pri_dif_expo_unset_tran) {
		this.r6_pri_dif_expo_unset_tran = r6_pri_dif_expo_unset_tran;
	}
	public BigDecimal getR6_risk_multipier() {
		return r6_risk_multipier;
	}
	public void setR6_risk_multipier(BigDecimal r6_risk_multipier) {
		this.r6_risk_multipier = r6_risk_multipier;
	}
	public BigDecimal getR6_capital_req_basel() {
		return r6_capital_req_basel;
	}
	public void setR6_capital_req_basel(BigDecimal r6_capital_req_basel) {
		this.r6_capital_req_basel = r6_capital_req_basel;
	}
	public BigDecimal getR6_capital_req_uae() {
		return r6_capital_req_uae;
	}
	public void setR6_capital_req_uae(BigDecimal r6_capital_req_uae) {
		this.r6_capital_req_uae = r6_capital_req_uae;
	}
	public String getR7_product() {
		return r7_product;
	}
	public void setR7_product(String r7_product) {
		this.r7_product = r7_product;
	}
	public BigDecimal getR7_unset_tra_set_price() {
		return r7_unset_tra_set_price;
	}
	public void setR7_unset_tra_set_price(BigDecimal r7_unset_tra_set_price) {
		this.r7_unset_tra_set_price = r7_unset_tra_set_price;
	}
	public BigDecimal getR7_pri_dif_expo_unset_tran() {
		return r7_pri_dif_expo_unset_tran;
	}
	public void setR7_pri_dif_expo_unset_tran(BigDecimal r7_pri_dif_expo_unset_tran) {
		this.r7_pri_dif_expo_unset_tran = r7_pri_dif_expo_unset_tran;
	}
	public BigDecimal getR7_risk_multipier() {
		return r7_risk_multipier;
	}
	public void setR7_risk_multipier(BigDecimal r7_risk_multipier) {
		this.r7_risk_multipier = r7_risk_multipier;
	}
	public BigDecimal getR7_capital_req_basel() {
		return r7_capital_req_basel;
	}
	public void setR7_capital_req_basel(BigDecimal r7_capital_req_basel) {
		this.r7_capital_req_basel = r7_capital_req_basel;
	}
	public BigDecimal getR7_capital_req_uae() {
		return r7_capital_req_uae;
	}
	public void setR7_capital_req_uae(BigDecimal r7_capital_req_uae) {
		this.r7_capital_req_uae = r7_capital_req_uae;
	}
	public String getR8_product() {
		return r8_product;
	}
	public void setR8_product(String r8_product) {
		this.r8_product = r8_product;
	}
	public BigDecimal getR8_unset_tra_set_price() {
		return r8_unset_tra_set_price;
	}
	public void setR8_unset_tra_set_price(BigDecimal r8_unset_tra_set_price) {
		this.r8_unset_tra_set_price = r8_unset_tra_set_price;
	}
	public BigDecimal getR8_pri_dif_expo_unset_tran() {
		return r8_pri_dif_expo_unset_tran;
	}
	public void setR8_pri_dif_expo_unset_tran(BigDecimal r8_pri_dif_expo_unset_tran) {
		this.r8_pri_dif_expo_unset_tran = r8_pri_dif_expo_unset_tran;
	}
	public BigDecimal getR8_risk_multipier() {
		return r8_risk_multipier;
	}
	public void setR8_risk_multipier(BigDecimal r8_risk_multipier) {
		this.r8_risk_multipier = r8_risk_multipier;
	}
	public BigDecimal getR8_capital_req_basel() {
		return r8_capital_req_basel;
	}
	public void setR8_capital_req_basel(BigDecimal r8_capital_req_basel) {
		this.r8_capital_req_basel = r8_capital_req_basel;
	}
	public BigDecimal getR8_capital_req_uae() {
		return r8_capital_req_uae;
	}
	public void setR8_capital_req_uae(BigDecimal r8_capital_req_uae) {
		this.r8_capital_req_uae = r8_capital_req_uae;
	}
	public String getR9_product() {
		return r9_product;
	}
	public void setR9_product(String r9_product) {
		this.r9_product = r9_product;
	}
	public BigDecimal getR9_unset_tra_set_price() {
		return r9_unset_tra_set_price;
	}
	public void setR9_unset_tra_set_price(BigDecimal r9_unset_tra_set_price) {
		this.r9_unset_tra_set_price = r9_unset_tra_set_price;
	}
	public BigDecimal getR9_pri_dif_expo_unset_tran() {
		return r9_pri_dif_expo_unset_tran;
	}
	public void setR9_pri_dif_expo_unset_tran(BigDecimal r9_pri_dif_expo_unset_tran) {
		this.r9_pri_dif_expo_unset_tran = r9_pri_dif_expo_unset_tran;
	}
	public BigDecimal getR9_risk_multipier() {
		return r9_risk_multipier;
	}
	public void setR9_risk_multipier(BigDecimal r9_risk_multipier) {
		this.r9_risk_multipier = r9_risk_multipier;
	}
	public BigDecimal getR9_capital_req_basel() {
		return r9_capital_req_basel;
	}
	public void setR9_capital_req_basel(BigDecimal r9_capital_req_basel) {
		this.r9_capital_req_basel = r9_capital_req_basel;
	}
	public BigDecimal getR9_capital_req_uae() {
		return r9_capital_req_uae;
	}
	public void setR9_capital_req_uae(BigDecimal r9_capital_req_uae) {
		this.r9_capital_req_uae = r9_capital_req_uae;
	}
	public String getR10_product() {
		return r10_product;
	}
	public void setR10_product(String r10_product) {
		this.r10_product = r10_product;
	}
	public BigDecimal getR10_unset_tra_set_price() {
		return r10_unset_tra_set_price;
	}
	public void setR10_unset_tra_set_price(BigDecimal r10_unset_tra_set_price) {
		this.r10_unset_tra_set_price = r10_unset_tra_set_price;
	}
	public BigDecimal getR10_pri_dif_expo_unset_tran() {
		return r10_pri_dif_expo_unset_tran;
	}
	public void setR10_pri_dif_expo_unset_tran(BigDecimal r10_pri_dif_expo_unset_tran) {
		this.r10_pri_dif_expo_unset_tran = r10_pri_dif_expo_unset_tran;
	}
	public BigDecimal getR10_risk_multipier() {
		return r10_risk_multipier;
	}
	public void setR10_risk_multipier(BigDecimal r10_risk_multipier) {
		this.r10_risk_multipier = r10_risk_multipier;
	}
	public BigDecimal getR10_capital_req_basel() {
		return r10_capital_req_basel;
	}
	public void setR10_capital_req_basel(BigDecimal r10_capital_req_basel) {
		this.r10_capital_req_basel = r10_capital_req_basel;
	}
	public BigDecimal getR10_capital_req_uae() {
		return r10_capital_req_uae;
	}
	public void setR10_capital_req_uae(BigDecimal r10_capital_req_uae) {
		this.r10_capital_req_uae = r10_capital_req_uae;
	}
	public String getR11_product() {
		return r11_product;
	}
	public void setR11_product(String r11_product) {
		this.r11_product = r11_product;
	}
	public BigDecimal getR11_unset_tra_set_price() {
		return r11_unset_tra_set_price;
	}
	public void setR11_unset_tra_set_price(BigDecimal r11_unset_tra_set_price) {
		this.r11_unset_tra_set_price = r11_unset_tra_set_price;
	}
	public BigDecimal getR11_pri_dif_expo_unset_tran() {
		return r11_pri_dif_expo_unset_tran;
	}
	public void setR11_pri_dif_expo_unset_tran(BigDecimal r11_pri_dif_expo_unset_tran) {
		this.r11_pri_dif_expo_unset_tran = r11_pri_dif_expo_unset_tran;
	}
	public BigDecimal getR11_risk_multipier() {
		return r11_risk_multipier;
	}
	public void setR11_risk_multipier(BigDecimal r11_risk_multipier) {
		this.r11_risk_multipier = r11_risk_multipier;
	}
	public BigDecimal getR11_capital_req_basel() {
		return r11_capital_req_basel;
	}
	public void setR11_capital_req_basel(BigDecimal r11_capital_req_basel) {
		this.r11_capital_req_basel = r11_capital_req_basel;
	}
	public BigDecimal getR11_capital_req_uae() {
		return r11_capital_req_uae;
	}
	public void setR11_capital_req_uae(BigDecimal r11_capital_req_uae) {
		this.r11_capital_req_uae = r11_capital_req_uae;
	}
	public String getR14_product() {
		return r14_product;
	}
	public void setR14_product(String r14_product) {
		this.r14_product = r14_product;
	}
	public BigDecimal getR14_capital_req_basel() {
		return r14_capital_req_basel;
	}
	public void setR14_capital_req_basel(BigDecimal r14_capital_req_basel) {
		this.r14_capital_req_basel = r14_capital_req_basel;
	}
	public BigDecimal getR14_capital_req_uae() {
		return r14_capital_req_uae;
	}
	public void setR14_capital_req_uae(BigDecimal r14_capital_req_uae) {
		this.r14_capital_req_uae = r14_capital_req_uae;
	}
	public String getR19_product() {
		return r19_product;
	}
	public void setR19_product(String r19_product) {
		this.r19_product = r19_product;
	}
	public String getR19_xyz_bank() {
		return r19_xyz_bank;
	}
	public void setR19_xyz_bank(String r19_xyz_bank) {
		this.r19_xyz_bank = r19_xyz_bank;
	}
	public String getR20_product() {
		return r20_product;
	}
	public void setR20_product(String r20_product) {
		this.r20_product = r20_product;
	}
	public Date getR20_reporting_date() {
		return r20_reporting_date;
	}
	public void setR20_reporting_date(Date r20_reporting_date) {
		this.r20_reporting_date = r20_reporting_date;
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
	public BASELL_12_ENTITY() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}