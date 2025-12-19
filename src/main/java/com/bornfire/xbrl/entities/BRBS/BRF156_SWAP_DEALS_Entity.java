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
@Table(name = "BRF_TREASURY_SWAP_DEALS_MANUAL_TABLE")
public class BRF156_SWAP_DEALS_Entity {
	@Id
	private String	deal_id;
	private String	type_of_deal;
	private BigDecimal	k_plus;
	private BigDecimal	ktp;
	private String	type_of_event;
	private BigDecimal	blk_no;
	private BigDecimal	amount1;
	private BigDecimal	amount2;
	private BigDecimal	rate_price;
	private String	strike;
	private BigDecimal	cl_rate;
	private String	cl_margin;
	private String	security;
	private String	security_name;

	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "MM/dd/yyyy")
	private Date	trade_date;

	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "MM/dd/yyyy")
	private Date	value_date;

	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "MM/dd/yyyy")
	private Date	mat_date;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "MM/dd/yyyy")
	private Date	liquidation_date;
	private BigDecimal	quantity;
	private String	broker;
	private String	cpty;
	private String	cpty_name;
	private String	create_user;
	private String	last_user;
	private String	folder;
	private String	comments;

	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "MM/dd/yyyy")
	private Date	last_date;
	private String	download_key;

	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "MM/dd/yyyy")
	private Date	report_date;
	public String getDeal_id() {
		return deal_id;
	}
	public void setDeal_id(String deal_id) {
		this.deal_id = deal_id;
	}
	public String getType_of_deal() {
		return type_of_deal;
	}
	public void setType_of_deal(String type_of_deal) {
		this.type_of_deal = type_of_deal;
	}
	public BigDecimal getK_plus() {
		return k_plus;
	}
	public void setK_plus(BigDecimal k_plus) {
		this.k_plus = k_plus;
	}
	public BigDecimal getKtp() {
		return ktp;
	}
	public void setKtp(BigDecimal ktp) {
		this.ktp = ktp;
	}
	public String getType_of_event() {
		return type_of_event;
	}
	public void setType_of_event(String type_of_event) {
		this.type_of_event = type_of_event;
	}
	public BigDecimal getBlk_no() {
		return blk_no;
	}
	public void setBlk_no(BigDecimal blk_no) {
		this.blk_no = blk_no;
	}
	public BigDecimal getAmount1() {
		return amount1;
	}
	public void setAmount1(BigDecimal amount1) {
		this.amount1 = amount1;
	}
	public BigDecimal getAmount2() {
		return amount2;
	}
	public void setAmount2(BigDecimal amount2) {
		this.amount2 = amount2;
	}
	public BigDecimal getRate_price() {
		return rate_price;
	}
	public void setRate_price(BigDecimal rate_price) {
		this.rate_price = rate_price;
	}
	public String getStrike() {
		return strike;
	}
	public void setStrike(String strike) {
		this.strike = strike;
	}
	public BigDecimal getCl_rate() {
		return cl_rate;
	}
	public void setCl_rate(BigDecimal cl_rate) {
		this.cl_rate = cl_rate;
	}
	public String getCl_margin() {
		return cl_margin;
	}
	public void setCl_margin(String cl_margin) {
		this.cl_margin = cl_margin;
	}
	public String getSecurity() {
		return security;
	}
	public void setSecurity(String security) {
		this.security = security;
	}
	public String getSecurity_name() {
		return security_name;
	}
	public void setSecurity_name(String security_name) {
		this.security_name = security_name;
	}
	public Date getTrade_date() {
		return trade_date;
	}
	public void setTrade_date(Date trade_date) {
		this.trade_date = trade_date;
	}
	public Date getValue_date() {
		return value_date;
	}
	public void setValue_date(Date value_date) {
		this.value_date = value_date;
	}
	public Date getMat_date() {
		return mat_date;
	}
	public void setMat_date(Date mat_date) {
		this.mat_date = mat_date;
	}
	public Date getLiquidation_date() {
		return liquidation_date;
	}
	public void setLiquidation_date(Date liquidation_date) {
		this.liquidation_date = liquidation_date;
	}
	public BigDecimal getQuantity() {
		return quantity;
	}
	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}
	public String getBroker() {
		return broker;
	}
	public void setBroker(String broker) {
		this.broker = broker;
	}
	public String getCpty() {
		return cpty;
	}
	public void setCpty(String cpty) {
		this.cpty = cpty;
	}
	public String getCpty_name() {
		return cpty_name;
	}
	public void setCpty_name(String cpty_name) {
		this.cpty_name = cpty_name;
	}
	public String getCreate_user() {
		return create_user;
	}
	public void setCreate_user(String create_user) {
		this.create_user = create_user;
	}
	public String getLast_user() {
		return last_user;
	}
	public void setLast_user(String last_user) {
		this.last_user = last_user;
	}
	public String getFolder() {
		return folder;
	}
	public void setFolder(String folder) {
		this.folder = folder;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public Date getLast_date() {
		return last_date;
	}
	public void setLast_date(Date last_date) {
		this.last_date = last_date;
	}
	public String getDownload_key() {
		return download_key;
	}
	public void setDownload_key(String download_key) {
		this.download_key = download_key;
	}
	public Date getReport_date() {
		return report_date;
	}
	public void setReport_date(Date report_date) {
		this.report_date = report_date;
	}
	public BRF156_SWAP_DEALS_Entity(String deal_id, String type_of_deal, BigDecimal k_plus, BigDecimal ktp,
			String type_of_event, BigDecimal blk_no, BigDecimal amount1, BigDecimal amount2, BigDecimal rate_price,
			String strike, BigDecimal cl_rate, String cl_margin, String security, String security_name, Date trade_date,
			Date value_date, Date mat_date, Date liquidation_date, BigDecimal quantity, String broker, String cpty,
			String cpty_name, String create_user, String last_user, String folder, String comments, Date last_date,
			String download_key, Date report_date) {
		super();
		this.deal_id = deal_id;
		this.type_of_deal = type_of_deal;
		this.k_plus = k_plus;
		this.ktp = ktp;
		this.type_of_event = type_of_event;
		this.blk_no = blk_no;
		this.amount1 = amount1;
		this.amount2 = amount2;
		this.rate_price = rate_price;
		this.strike = strike;
		this.cl_rate = cl_rate;
		this.cl_margin = cl_margin;
		this.security = security;
		this.security_name = security_name;
		this.trade_date = trade_date;
		this.value_date = value_date;
		this.mat_date = mat_date;
		this.liquidation_date = liquidation_date;
		this.quantity = quantity;
		this.broker = broker;
		this.cpty = cpty;
		this.cpty_name = cpty_name;
		this.create_user = create_user;
		this.last_user = last_user;
		this.folder = folder;
		this.comments = comments;
		this.last_date = last_date;
		this.download_key = download_key;
		this.report_date = report_date;
	}
	public BRF156_SWAP_DEALS_Entity() {
		super();
		// TODO Auto-generated constructor stub
	}

	

}
