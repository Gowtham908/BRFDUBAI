package com.bornfire.xbrl.entities.BRBS;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;

public class BRF069IDCLASS implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	private String srl_no;
	@Id
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date report_date;

	public String getSrl_no() {
		return srl_no;
	}

	public void setSrl_no(String srl_no) {
		this.srl_no = srl_no;
	}

	public Date getReport_date() {
		return report_date;
	}

	public void setReport_date(Date report_date) {
		this.report_date = report_date;
	}

}
