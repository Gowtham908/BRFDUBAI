package com.bornfire.xbrl.entities;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ECL_COOLOFF_1")
public class ECL_COOLOFF_1 {

	private BigDecimal CUST_ID;
	private BigDecimal STAGE;
	private String STAGE_REASON;
	private String Final_Status_As_on_Date;
	private String Asset_Classification_as_on_Date;
	private BigDecimal SMA;
	private String WATCH_LIST;
	private String OtherReason;
	private String ELIGIBLE2;
	private String Eligible1_Change_Formula_Range;
	private String OLD_REASON;
	@Id
	private Date REPORT_DATE;
	public BigDecimal getCUST_ID() {
		return CUST_ID;
	}
	public void setCUST_ID(BigDecimal cUST_ID) {
		CUST_ID = cUST_ID;
	}
	public BigDecimal getSTAGE() {
		return STAGE;
	}
	public void setSTAGE(BigDecimal sTAGE) {
		STAGE = sTAGE;
	}
	public String getSTAGE_REASON() {
		return STAGE_REASON;
	}
	public void setSTAGE_REASON(String sTAGE_REASON) {
		STAGE_REASON = sTAGE_REASON;
	}
	public String getFinal_Status_As_on_Date() {
		return Final_Status_As_on_Date;
	}
	public void setFinal_Status_As_on_Date(String final_Status_As_on_Date) {
		Final_Status_As_on_Date = final_Status_As_on_Date;
	}
	public String getAsset_Classification_as_on_Date() {
		return Asset_Classification_as_on_Date;
	}
	public void setAsset_Classification_as_on_Date(String asset_Classification_as_on_Date) {
		Asset_Classification_as_on_Date = asset_Classification_as_on_Date;
	}
	public BigDecimal getSMA() {
		return SMA;
	}
	public void setSMA(BigDecimal sMA) {
		SMA = sMA;
	}
	public String getWATCH_LIST() {
		return WATCH_LIST;
	}
	public void setWATCH_LIST(String wATCH_LIST) {
		WATCH_LIST = wATCH_LIST;
	}
	public String getOtherReason() {
		return OtherReason;
	}
	public void setOtherReason(String otherReason) {
		OtherReason = otherReason;
	}
	public String getELIGIBLE2() {
		return ELIGIBLE2;
	}
	public void setELIGIBLE2(String eLIGIBLE2) {
		ELIGIBLE2 = eLIGIBLE2;
	}
	public String getEligible1_Change_Formula_Range() {
		return Eligible1_Change_Formula_Range;
	}
	public void setEligible1_Change_Formula_Range(String eligible1_Change_Formula_Range) {
		Eligible1_Change_Formula_Range = eligible1_Change_Formula_Range;
	}
	public String getOLD_REASON() {
		return OLD_REASON;
	}
	public void setOLD_REASON(String oLD_REASON) {
		OLD_REASON = oLD_REASON;
	}
	public Date getREPORT_DATE() {
		return REPORT_DATE;
	}
	public void setREPORT_DATE(Date rEPORT_DATE) {
		REPORT_DATE = rEPORT_DATE;
	}
	public ECL_COOLOFF_1() {
		super();
		// TODO Auto-generated constructor stub
	}

}
