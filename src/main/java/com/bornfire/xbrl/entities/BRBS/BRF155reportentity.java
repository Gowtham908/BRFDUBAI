package com.bornfire.xbrl.entities.BRBS;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;
 
@Entity
@Table(name="BRF_155")
//@IdClass(BRF155reportid.class)
public class BRF155reportentity {
	 
	private Date	r1_deal_date;
	private BigDecimal	r1_buy_usd;
	private BigDecimal	r1_sell_aed;
	private BigDecimal	r1_buy_aed;
	private BigDecimal	r1_sell_usd;
	private String	r1_ddm;

	@Id
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date	report_date;
	private Date	report_from_date;
	private Date	report_to_date; 
	private String	entity_flg;
	private String	modify_flg;
	private String	del_flg;
	private String	report_code;
	private Date	report_submit_date;
	 
	 
	 @DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date	deal_date    ; 	
	private BigDecimal	buy_usd ;
	private BigDecimal	sell_aed   ;
	private BigDecimal	buy_aed   ;
	private BigDecimal	sell_usd ;
	private String	ddm    ;

	private BigDecimal	srl_no   ;
	public Date getR1_deal_date() {
		return r1_deal_date;
	}
	public void setR1_deal_date(Date r1_deal_date) {
		this.r1_deal_date = r1_deal_date;
	}
	public BigDecimal getR1_buy_usd() {
		return r1_buy_usd;
	}
	public void setR1_buy_usd(BigDecimal r1_buy_usd) {
		this.r1_buy_usd = r1_buy_usd;
	}
	public BigDecimal getR1_sell_aed() {
		return r1_sell_aed;
	}
	public void setR1_sell_aed(BigDecimal r1_sell_aed) {
		this.r1_sell_aed = r1_sell_aed;
	}
	public BigDecimal getR1_buy_aed() {
		return r1_buy_aed;
	}
	public void setR1_buy_aed(BigDecimal r1_buy_aed) {
		this.r1_buy_aed = r1_buy_aed;
	}
	public BigDecimal getR1_sell_usd() {
		return r1_sell_usd;
	}
	public void setR1_sell_usd(BigDecimal r1_sell_usd) {
		this.r1_sell_usd = r1_sell_usd;
	}
	public String getR1_ddm() {
		return r1_ddm;
	}
	public void setR1_ddm(String r1_ddm) {
		this.r1_ddm = r1_ddm;
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
	public Date getDeal_date() {
		return deal_date;
	}
	public void setDeal_date(Date deal_date) {
		this.deal_date = deal_date;
	}
	public BigDecimal getBuy_usd() {
		return buy_usd;
	}
	public void setBuy_usd(BigDecimal buy_usd) {
		this.buy_usd = buy_usd;
	}
	public BigDecimal getSell_aed() {
		return sell_aed;
	}
	public void setSell_aed(BigDecimal sell_aed) {
		this.sell_aed = sell_aed;
	}
	public BigDecimal getBuy_aed() {
		return buy_aed;
	}
	public void setBuy_aed(BigDecimal buy_aed) {
		this.buy_aed = buy_aed;
	}
	public BigDecimal getSell_usd() {
		return sell_usd;
	}
	public void setSell_usd(BigDecimal sell_usd) {
		this.sell_usd = sell_usd;
	}
	public String getDdm() {
		return ddm;
	}
	public void setDdm(String ddm) {
		this.ddm = ddm;
	}
	public BigDecimal getSrl_no() {
		return srl_no;
	}
	public void setSrl_no(BigDecimal srl_no) {
		this.srl_no = srl_no;
	}
	public BRF155reportentity() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
