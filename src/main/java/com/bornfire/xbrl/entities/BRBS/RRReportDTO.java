package com.bornfire.xbrl.entities.BRBS;

import java.util.Date;

public class RRReportDTO {
    private String rpt_code;
    private String rpt_description;
    private String DOMAIN;
    private Date end_date;
    private String remarks_3;
	public String getRpt_code() {
		return rpt_code;
	}
	public void setRpt_code(String rpt_code) {
		this.rpt_code = rpt_code;
	}
	public String getRpt_description() {
		return rpt_description;
	}
	public void setRpt_description(String rpt_description) {
		this.rpt_description = rpt_description;
	}
	public String getDOMAIN() {
		return DOMAIN;
	}
	public void setDOMAIN(String dOMAIN) {
		DOMAIN = dOMAIN;
	}
	public Date getEnd_date() {
		return end_date;
	}
	public void setEnd_date(Date end_date) {
		this.end_date = end_date;
	}
	public String getRemarks_3() {
		return remarks_3;
	}
	public void setRemarks_3(String remarks_3) {
		this.remarks_3 = remarks_3;
	}
	public RRReportDTO(String rpt_code, String rpt_description, String dOMAIN, Date end_date, String remarks_3) {
		super();
		this.rpt_code = rpt_code;
		this.rpt_description = rpt_description;
		DOMAIN = dOMAIN;
		this.end_date = end_date;
		this.remarks_3 = remarks_3;
	}
	public RRReportDTO() {
		super();
		// TODO Auto-generated constructor stub
	}


    
}
