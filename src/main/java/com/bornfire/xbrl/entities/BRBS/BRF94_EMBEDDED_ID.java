package com.bornfire.xbrl.entities.BRBS;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.Id;

@Embeddable
public class BRF94_EMBEDDED_ID implements Serializable  {
	@Id
	private String	foracid;
	private String	report_addl_criteria_2;
	private String purpose_of_rem;
	public String getForacid() {
		return foracid;
	}
	public void setForacid(String foracid) {
		this.foracid = foracid;
	}
	public String getReport_addl_criteria_2() {
		return report_addl_criteria_2;
	}
	public void setReport_addl_criteria_2(String report_addl_criteria_2) {
		this.report_addl_criteria_2 = report_addl_criteria_2;
	}
	public String getPurpose_of_rem() {
		return purpose_of_rem;
	}
	public void setPurpose_of_rem(String purpose_of_rem) {
		this.purpose_of_rem = purpose_of_rem;
	}
	
}
