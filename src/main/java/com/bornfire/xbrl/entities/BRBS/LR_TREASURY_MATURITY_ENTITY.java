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
@Table(name="LR_TREASURY_MATURITY_TABLE")
public class LR_TREASURY_MATURITY_ENTITY {

	
	private BigDecimal	SRL_NUM;
	private String	NAME;
	private String	NAME_INVESTMENT;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date	MATURITY_DATE;
	private BigDecimal	NO_OF_UNIT_BOND;
	private BigDecimal	COST_PER_UNIT;
	private BigDecimal	FACE_VALUE_PER_UNIT;
	private BigDecimal	PURCHASE_PER_UNIT;
	private BigDecimal	COUPON;
	private BigDecimal	MARKET_RATE_PER_UNIT;
	private String	SOURCE_MRK_RATE;
	private String	CURRENCY;
	private BigDecimal	FACE_VALUE_LC;
	private BigDecimal	FACE_VALUE_INR;
	private BigDecimal	FACE_VALUE_USD;
	private BigDecimal	BOOK_VALUE_LC;
	private BigDecimal	BOOK_VALUE_INR;
	private BigDecimal	BOOK_VALUE_USD;
	private BigDecimal	MARKET_VALUE_LC;
	private BigDecimal	MARKET_VALUE_INR;
	private BigDecimal	MARKET_VALUE_USD;
	private BigDecimal	DIFFERENCE_LC;
	private BigDecimal	DIFFERENCE_INR;
	private BigDecimal	DIFFERENCE_USD;
	private BigDecimal	DEPRECIATION_LC;
	private BigDecimal	DEPRECIATION_INR;
	private BigDecimal	PRICE;
	private BigDecimal	INTEREST;
	private BigDecimal	MATURITY_NUMBER;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Id
	private Date	REPORT_DATE;
	private Date	DATE_OF_INVESTMENT;
	public BigDecimal getSRL_NUM() {
		return SRL_NUM;
	}
	public void setSRL_NUM(BigDecimal sRL_NUM) {
		SRL_NUM = sRL_NUM;
	}
	public String getNAME() {
		return NAME;
	}
	public void setNAME(String nAME) {
		NAME = nAME;
	}
	public String getNAME_INVESTMENT() {
		return NAME_INVESTMENT;
	}
	public void setNAME_INVESTMENT(String nAME_INVESTMENT) {
		NAME_INVESTMENT = nAME_INVESTMENT;
	}
	public Date getMATURITY_DATE() {
		return MATURITY_DATE;
	}
	public void setMATURITY_DATE(Date mATURITY_DATE) {
		MATURITY_DATE = mATURITY_DATE;
	}
	public BigDecimal getNO_OF_UNIT_BOND() {
		return NO_OF_UNIT_BOND;
	}
	public void setNO_OF_UNIT_BOND(BigDecimal nO_OF_UNIT_BOND) {
		NO_OF_UNIT_BOND = nO_OF_UNIT_BOND;
	}
	public BigDecimal getCOST_PER_UNIT() {
		return COST_PER_UNIT;
	}
	public void setCOST_PER_UNIT(BigDecimal cOST_PER_UNIT) {
		COST_PER_UNIT = cOST_PER_UNIT;
	}
	public BigDecimal getFACE_VALUE_PER_UNIT() {
		return FACE_VALUE_PER_UNIT;
	}
	public void setFACE_VALUE_PER_UNIT(BigDecimal fACE_VALUE_PER_UNIT) {
		FACE_VALUE_PER_UNIT = fACE_VALUE_PER_UNIT;
	}
	public BigDecimal getPURCHASE_PER_UNIT() {
		return PURCHASE_PER_UNIT;
	}
	public void setPURCHASE_PER_UNIT(BigDecimal pURCHASE_PER_UNIT) {
		PURCHASE_PER_UNIT = pURCHASE_PER_UNIT;
	}
	public BigDecimal getCOUPON() {
		return COUPON;
	}
	public void setCOUPON(BigDecimal cOUPON) {
		COUPON = cOUPON;
	}
	public BigDecimal getMARKET_RATE_PER_UNIT() {
		return MARKET_RATE_PER_UNIT;
	}
	public void setMARKET_RATE_PER_UNIT(BigDecimal mARKET_RATE_PER_UNIT) {
		MARKET_RATE_PER_UNIT = mARKET_RATE_PER_UNIT;
	}
	public String getSOURCE_MRK_RATE() {
		return SOURCE_MRK_RATE;
	}
	public void setSOURCE_MRK_RATE(String sOURCE_MRK_RATE) {
		SOURCE_MRK_RATE = sOURCE_MRK_RATE;
	}
	public String getCURRENCY() {
		return CURRENCY;
	}
	public void setCURRENCY(String cURRENCY) {
		CURRENCY = cURRENCY;
	}
	public BigDecimal getFACE_VALUE_LC() {
		return FACE_VALUE_LC;
	}
	public void setFACE_VALUE_LC(BigDecimal fACE_VALUE_LC) {
		FACE_VALUE_LC = fACE_VALUE_LC;
	}
	public BigDecimal getFACE_VALUE_INR() {
		return FACE_VALUE_INR;
	}
	public void setFACE_VALUE_INR(BigDecimal fACE_VALUE_INR) {
		FACE_VALUE_INR = fACE_VALUE_INR;
	}
	public BigDecimal getFACE_VALUE_USD() {
		return FACE_VALUE_USD;
	}
	public void setFACE_VALUE_USD(BigDecimal fACE_VALUE_USD) {
		FACE_VALUE_USD = fACE_VALUE_USD;
	}
	public BigDecimal getBOOK_VALUE_LC() {
		return BOOK_VALUE_LC;
	}
	public void setBOOK_VALUE_LC(BigDecimal bOOK_VALUE_LC) {
		BOOK_VALUE_LC = bOOK_VALUE_LC;
	}
	public BigDecimal getBOOK_VALUE_INR() {
		return BOOK_VALUE_INR;
	}
	public void setBOOK_VALUE_INR(BigDecimal bOOK_VALUE_INR) {
		BOOK_VALUE_INR = bOOK_VALUE_INR;
	}
	public BigDecimal getBOOK_VALUE_USD() {
		return BOOK_VALUE_USD;
	}
	public void setBOOK_VALUE_USD(BigDecimal bOOK_VALUE_USD) {
		BOOK_VALUE_USD = bOOK_VALUE_USD;
	}
	public BigDecimal getMARKET_VALUE_LC() {
		return MARKET_VALUE_LC;
	}
	public void setMARKET_VALUE_LC(BigDecimal mARKET_VALUE_LC) {
		MARKET_VALUE_LC = mARKET_VALUE_LC;
	}
	public BigDecimal getMARKET_VALUE_INR() {
		return MARKET_VALUE_INR;
	}
	public void setMARKET_VALUE_INR(BigDecimal mARKET_VALUE_INR) {
		MARKET_VALUE_INR = mARKET_VALUE_INR;
	}
	public BigDecimal getMARKET_VALUE_USD() {
		return MARKET_VALUE_USD;
	}
	public void setMARKET_VALUE_USD(BigDecimal mARKET_VALUE_USD) {
		MARKET_VALUE_USD = mARKET_VALUE_USD;
	}
	public BigDecimal getDIFFERENCE_LC() {
		return DIFFERENCE_LC;
	}
	public void setDIFFERENCE_LC(BigDecimal dIFFERENCE_LC) {
		DIFFERENCE_LC = dIFFERENCE_LC;
	}
	public BigDecimal getDIFFERENCE_INR() {
		return DIFFERENCE_INR;
	}
	public void setDIFFERENCE_INR(BigDecimal dIFFERENCE_INR) {
		DIFFERENCE_INR = dIFFERENCE_INR;
	}
	public BigDecimal getDIFFERENCE_USD() {
		return DIFFERENCE_USD;
	}
	public void setDIFFERENCE_USD(BigDecimal dIFFERENCE_USD) {
		DIFFERENCE_USD = dIFFERENCE_USD;
	}
	public BigDecimal getDEPRECIATION_LC() {
		return DEPRECIATION_LC;
	}
	public void setDEPRECIATION_LC(BigDecimal dEPRECIATION_LC) {
		DEPRECIATION_LC = dEPRECIATION_LC;
	}
	public BigDecimal getDEPRECIATION_INR() {
		return DEPRECIATION_INR;
	}
	public void setDEPRECIATION_INR(BigDecimal dEPRECIATION_INR) {
		DEPRECIATION_INR = dEPRECIATION_INR;
	}
	public BigDecimal getPRICE() {
		return PRICE;
	}
	public void setPRICE(BigDecimal pRICE) {
		PRICE = pRICE;
	}
	public BigDecimal getINTEREST() {
		return INTEREST;
	}
	public void setINTEREST(BigDecimal iNTEREST) {
		INTEREST = iNTEREST;
	}
	public BigDecimal getMATURITY_NUMBER() {
		return MATURITY_NUMBER;
	}
	public void setMATURITY_NUMBER(BigDecimal mATURITY_NUMBER) {
		MATURITY_NUMBER = mATURITY_NUMBER;
	}
	public Date getREPORT_DATE() {
		return REPORT_DATE;
	}
	public void setREPORT_DATE(Date rEPORT_DATE) {
		REPORT_DATE = rEPORT_DATE;
	}
	public Date getDATE_OF_INVESTMENT() {
		return DATE_OF_INVESTMENT;
	}
	public void setDATE_OF_INVESTMENT(Date dATE_OF_INVESTMENT) {
		DATE_OF_INVESTMENT = dATE_OF_INVESTMENT;
	}
	public LR_TREASURY_MATURITY_ENTITY(BigDecimal sRL_NUM, String nAME, String nAME_INVESTMENT, Date mATURITY_DATE,
			BigDecimal nO_OF_UNIT_BOND, BigDecimal cOST_PER_UNIT, BigDecimal fACE_VALUE_PER_UNIT,
			BigDecimal pURCHASE_PER_UNIT, BigDecimal cOUPON, BigDecimal mARKET_RATE_PER_UNIT, String sOURCE_MRK_RATE,
			String cURRENCY, BigDecimal fACE_VALUE_LC, BigDecimal fACE_VALUE_INR, BigDecimal fACE_VALUE_USD,
			BigDecimal bOOK_VALUE_LC, BigDecimal bOOK_VALUE_INR, BigDecimal bOOK_VALUE_USD, BigDecimal mARKET_VALUE_LC,
			BigDecimal mARKET_VALUE_INR, BigDecimal mARKET_VALUE_USD, BigDecimal dIFFERENCE_LC,
			BigDecimal dIFFERENCE_INR, BigDecimal dIFFERENCE_USD, BigDecimal dEPRECIATION_LC,
			BigDecimal dEPRECIATION_INR, BigDecimal pRICE, BigDecimal iNTEREST, BigDecimal mATURITY_NUMBER,
			Date rEPORT_DATE, Date dATE_OF_INVESTMENT) {
		super();
		SRL_NUM = sRL_NUM;
		NAME = nAME;
		NAME_INVESTMENT = nAME_INVESTMENT;
		MATURITY_DATE = mATURITY_DATE;
		NO_OF_UNIT_BOND = nO_OF_UNIT_BOND;
		COST_PER_UNIT = cOST_PER_UNIT;
		FACE_VALUE_PER_UNIT = fACE_VALUE_PER_UNIT;
		PURCHASE_PER_UNIT = pURCHASE_PER_UNIT;
		COUPON = cOUPON;
		MARKET_RATE_PER_UNIT = mARKET_RATE_PER_UNIT;
		SOURCE_MRK_RATE = sOURCE_MRK_RATE;
		CURRENCY = cURRENCY;
		FACE_VALUE_LC = fACE_VALUE_LC;
		FACE_VALUE_INR = fACE_VALUE_INR;
		FACE_VALUE_USD = fACE_VALUE_USD;
		BOOK_VALUE_LC = bOOK_VALUE_LC;
		BOOK_VALUE_INR = bOOK_VALUE_INR;
		BOOK_VALUE_USD = bOOK_VALUE_USD;
		MARKET_VALUE_LC = mARKET_VALUE_LC;
		MARKET_VALUE_INR = mARKET_VALUE_INR;
		MARKET_VALUE_USD = mARKET_VALUE_USD;
		DIFFERENCE_LC = dIFFERENCE_LC;
		DIFFERENCE_INR = dIFFERENCE_INR;
		DIFFERENCE_USD = dIFFERENCE_USD;
		DEPRECIATION_LC = dEPRECIATION_LC;
		DEPRECIATION_INR = dEPRECIATION_INR;
		PRICE = pRICE;
		INTEREST = iNTEREST;
		MATURITY_NUMBER = mATURITY_NUMBER;
		REPORT_DATE = rEPORT_DATE;
		DATE_OF_INVESTMENT = dATE_OF_INVESTMENT;
	}
	public LR_TREASURY_MATURITY_ENTITY() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
}
