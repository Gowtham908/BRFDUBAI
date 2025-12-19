package com.bornfire.xbrl.entities.BRBS;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Embeddable;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;

@Embeddable
public class BRF108IDCLASS implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	private String r1_s_no;
	@Id
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date report_date;
	/**
	 * @return the r1_s_no
	 */
	public String getR1_s_no() {
		return r1_s_no;
	}
	/**
	 * @param r1_s_no the r1_s_no to set
	 */
	public void setR1_s_no(String r1_s_no) {
		this.r1_s_no = r1_s_no;
	}
	/**
	 * @return the report_date
	 */
	public Date getReport_date() {
		return report_date;
	}
	/**
	 * @param report_date the report_date to set
	 */
	public void setReport_date(Date report_date) {
		this.report_date = report_date;
	}

}

