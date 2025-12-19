package com.bornfire.xbrl.entities;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "VAT_LEDGER_DAILY_DATA")
public class Vat_Ledger_Entity {

	@Column(name = "COMPANY_NAME_OU_NAME")
	private String COMPANY_NAME_OU_NAME;

	@Column(name = "COMPANY_TRN")
	private String COMPANY_TRN;

	@Column(name = "RETURN_TYPE")
	private String RETURN_TYPE;

	@Column(name = "SOURCE_DOCUMENT_ID")
	private String SOURCE_DOCUMENT_ID;

	@Column(name = "SOURCE_TYPE")
	private String SOURCE_TYPE;

	@Column(name = "GOODS_SERVICES")
	private String GOODS_SERVICES;

	@Column(name = "IS_ECOM_SUPPLIES")
	private String IS_ECOM_SUPPLIES;
@Id
	@Column(name = "ACCOUNT_ID")
	private String ACCOUNT_ID;

	@Column(name = "ACCOUNT_NAME")
	private String ACCOUNT_NAME;

	@Column(name = "CUST_NAME")
	private String CUST_NAME;

	@Column(name = "TRANSACTION_ID")
	private String TRANSACTION_ID;

	@Column(name = "TRANSACTION_DATE")
	private Date TRANSACTION_DATE;

	@Column(name = "TRANSACTION_DESCRIPTION")
	private String TRANSACTION_DESCRIPTION;

	@Column(name = "TRANSACTION_AMOUNT")
	private BigDecimal TRANSACTION_AMOUNT;

	@Column(name = "TRANSACTION_TYPE")
	private String TRANSACTION_TYPE;

	@Column(name = "BALANCE_AMOUNT_IN_AED")
	private BigDecimal BALANCE_AMOUNT_IN_AED;

	@Column(name = "TRN")
	private String TRN;

	@Column(name = "LOCATION")
	private String LOCATION;

	@Column(name = "INVOICE_NUMBER")
	private String INVOICE_NUMBER;

	@Column(name = "INVOICE_DATE")

	private Date INVOICE_DATE;

	@Column(name = "TAX_CODE")
	private String TAX_CODE;

	@Column(name = "RATE")
	private String RATE;

	@Column(name = "SUPPLY_PURCHASE_VALUE_AED")
	private String SUPPLY_PURCHASE_VALUE_AED;

	@Column(name = "VAT_VALUE_AED")
	private String VAT_VALUE_AED;

	@Column(name = "FCY_CODE")
	private String FCY_CODE;

	@Column(name = "FCYCCR")
	private BigDecimal FCYCCR;

	@Column(name = "CUSTOM1")
	private String CUSTOM1;

	@Column(name = "CUSTOM2")
	private String CUSTOM2;

	@Column(name = "CUSTOM3")
	private String CUSTOM3;

	@Column(name = "CUSTOM4")
	private String CUSTOM4;

	@Column(name = "CUSTOM5")
	private String CUSTOM5;

	@Column(name = "CUSTOM6")
	private String CUSTOM6;

	@Column(name = "CUSTOM7")
	private String CUSTOM7;

	@Column(name = "CUSTOM8")
	private String CUSTOM8;

	@Column(name = "CUSTOM9")
	private String CUSTOM9;

	@Column(name = "CUSTOM10")
	private String CUSTOM10;

	@Column(name = "REPORT_DATE")
	private Date REPORT_DATE;

	public String getCOMPANY_NAME_OU_NAME() {
		return COMPANY_NAME_OU_NAME;
	}

	public void setCOMPANY_NAME_OU_NAME(String cOMPANY_NAME_OU_NAME) {
		COMPANY_NAME_OU_NAME = cOMPANY_NAME_OU_NAME;
	}

	public String getCOMPANY_TRN() {
		return COMPANY_TRN;
	}

	public void setCOMPANY_TRN(String cOMPANY_TRN) {
		COMPANY_TRN = cOMPANY_TRN;
	}

	public String getRETURN_TYPE() {
		return RETURN_TYPE;
	}

	public void setRETURN_TYPE(String rETURN_TYPE) {
		RETURN_TYPE = rETURN_TYPE;
	}

	public String getSOURCE_DOCUMENT_ID() {
		return SOURCE_DOCUMENT_ID;
	}

	public void setSOURCE_DOCUMENT_ID(String sOURCE_DOCUMENT_ID) {
		SOURCE_DOCUMENT_ID = sOURCE_DOCUMENT_ID;
	}

	public String getSOURCE_TYPE() {
		return SOURCE_TYPE;
	}

	public void setSOURCE_TYPE(String sOURCE_TYPE) {
		SOURCE_TYPE = sOURCE_TYPE;
	}

	public String getGOODS_SERVICES() {
		return GOODS_SERVICES;
	}

	public void setGOODS_SERVICES(String gOODS_SERVICES) {
		GOODS_SERVICES = gOODS_SERVICES;
	}

	public String getIS_ECOM_SUPPLIES() {
		return IS_ECOM_SUPPLIES;
	}

	public void setIS_ECOM_SUPPLIES(String iS_ECOM_SUPPLIES) {
		IS_ECOM_SUPPLIES = iS_ECOM_SUPPLIES;
	}

	public String getACCOUNT_ID() {
		return ACCOUNT_ID;
	}

	public void setACCOUNT_ID(String aCCOUNT_ID) {
		ACCOUNT_ID = aCCOUNT_ID;
	}

	public String getACCOUNT_NAME() {
		return ACCOUNT_NAME;
	}

	public void setACCOUNT_NAME(String aCCOUNT_NAME) {
		ACCOUNT_NAME = aCCOUNT_NAME;
	}

	public String getCUST_NAME() {
		return CUST_NAME;
	}

	public void setCUST_NAME(String cUST_NAME) {
		CUST_NAME = cUST_NAME;
	}

	public String getTRANSACTION_ID() {
		return TRANSACTION_ID;
	}

	public void setTRANSACTION_ID(String tRANSACTION_ID) {
		TRANSACTION_ID = tRANSACTION_ID;
	}

	public Date getTRANSACTION_DATE() {
		return TRANSACTION_DATE;
	}

	public void setTRANSACTION_DATE(Date tRANSACTION_DATE) {
		TRANSACTION_DATE = tRANSACTION_DATE;
	}

	public String getTRANSACTION_DESCRIPTION() {
		return TRANSACTION_DESCRIPTION;
	}

	public void setTRANSACTION_DESCRIPTION(String tRANSACTION_DESCRIPTION) {
		TRANSACTION_DESCRIPTION = tRANSACTION_DESCRIPTION;
	}

	public BigDecimal getTRANSACTION_AMOUNT() {
		return TRANSACTION_AMOUNT;
	}

	public void setTRANSACTION_AMOUNT(BigDecimal tRANSACTION_AMOUNT) {
		TRANSACTION_AMOUNT = tRANSACTION_AMOUNT;
	}

	public String getTRANSACTION_TYPE() {
		return TRANSACTION_TYPE;
	}

	public void setTRANSACTION_TYPE(String tRANSACTION_TYPE) {
		TRANSACTION_TYPE = tRANSACTION_TYPE;
	}

	public BigDecimal getBALANCE_AMOUNT_IN_AED() {
		return BALANCE_AMOUNT_IN_AED;
	}

	public void setBALANCE_AMOUNT_IN_AED(BigDecimal bALANCE_AMOUNT_IN_AED) {
		BALANCE_AMOUNT_IN_AED = bALANCE_AMOUNT_IN_AED;
	}

	public String getTRN() {
		return TRN;
	}

	public void setTRN(String tRN) {
		TRN = tRN;
	}

	public String getLOCATION() {
		return LOCATION;
	}

	public void setLOCATION(String lOCATION) {
		LOCATION = lOCATION;
	}

	public String getINVOICE_NUMBER() {
		return INVOICE_NUMBER;
	}

	public void setINVOICE_NUMBER(String iNVOICE_NUMBER) {
		INVOICE_NUMBER = iNVOICE_NUMBER;
	}

	public Date getINVOICE_DATE() {
		return INVOICE_DATE;
	}

	public void setINVOICE_DATE(Date iNVOICE_DATE) {
		INVOICE_DATE = iNVOICE_DATE;
	}

	public String getTAX_CODE() {
		return TAX_CODE;
	}

	public void setTAX_CODE(String tAX_CODE) {
		TAX_CODE = tAX_CODE;
	}

	public String getRATE() {
		return RATE;
	}

	public void setRATE(String rATE) {
		RATE = rATE;
	}

	public String getSUPPLY_PURCHASE_VALUE_AED() {
		return SUPPLY_PURCHASE_VALUE_AED;
	}

	public void setSUPPLY_PURCHASE_VALUE_AED(String sUPPLY_PURCHASE_VALUE_AED) {
		SUPPLY_PURCHASE_VALUE_AED = sUPPLY_PURCHASE_VALUE_AED;
	}

	public String getVAT_VALUE_AED() {
		return VAT_VALUE_AED;
	}

	public void setVAT_VALUE_AED(String vAT_VALUE_AED) {
		VAT_VALUE_AED = vAT_VALUE_AED;
	}

	public String getFCY_CODE() {
		return FCY_CODE;
	}

	public void setFCY_CODE(String fCY_CODE) {
		FCY_CODE = fCY_CODE;
	}

	public BigDecimal getFCYCCR() {
		return FCYCCR;
	}

	public void setFCYCCR(BigDecimal fCYCCR) {
		FCYCCR = fCYCCR;
	}

	public String getCUSTOM1() {
		return CUSTOM1;
	}

	public void setCUSTOM1(String cUSTOM1) {
		CUSTOM1 = cUSTOM1;
	}

	public String getCUSTOM2() {
		return CUSTOM2;
	}

	public void setCUSTOM2(String cUSTOM2) {
		CUSTOM2 = cUSTOM2;
	}

	public String getCUSTOM3() {
		return CUSTOM3;
	}

	public void setCUSTOM3(String cUSTOM3) {
		CUSTOM3 = cUSTOM3;
	}

	public String getCUSTOM4() {
		return CUSTOM4;
	}

	public void setCUSTOM4(String cUSTOM4) {
		CUSTOM4 = cUSTOM4;
	}

	public String getCUSTOM5() {
		return CUSTOM5;
	}

	public void setCUSTOM5(String cUSTOM5) {
		CUSTOM5 = cUSTOM5;
	}

	public String getCUSTOM6() {
		return CUSTOM6;
	}

	public void setCUSTOM6(String cUSTOM6) {
		CUSTOM6 = cUSTOM6;
	}

	public String getCUSTOM7() {
		return CUSTOM7;
	}

	public void setCUSTOM7(String cUSTOM7) {
		CUSTOM7 = cUSTOM7;
	}

	public String getCUSTOM8() {
		return CUSTOM8;
	}

	public void setCUSTOM8(String cUSTOM8) {
		CUSTOM8 = cUSTOM8;
	}

	public String getCUSTOM9() {
		return CUSTOM9;
	}

	public void setCUSTOM9(String cUSTOM9) {
		CUSTOM9 = cUSTOM9;
	}

	public String getCUSTOM10() {
		return CUSTOM10;
	}

	public void setCUSTOM10(String cUSTOM10) {
		CUSTOM10 = cUSTOM10;
	}

	public Date getREPORT_DATE() {
		return REPORT_DATE;
	}

	public void setREPORT_DATE(Date rEPORT_DATE) {
		REPORT_DATE = rEPORT_DATE;
	}
}
