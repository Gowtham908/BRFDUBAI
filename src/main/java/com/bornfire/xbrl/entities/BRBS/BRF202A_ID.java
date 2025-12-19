package com.bornfire.xbrl.entities.BRBS;

import java.util.Date;
import java.util.Objects;

import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;


public class BRF202A_ID {
	@Id
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date	report_date;
	@Id
	private String	r1_s_no;
	public Date getReport_date() {
		return report_date;
	}
	public void setReport_date(Date report_date) {
		this.report_date = report_date;
	}
	public String getR1_s_no() {
		return r1_s_no;
	}
	public void setR1_s_no(String r1_s_no) {
		this.r1_s_no = r1_s_no;
	}
	@Override
	public int hashCode() {
		return Objects.hash(r1_s_no, report_date);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BRF202A_ID other = (BRF202A_ID) obj;
		return Objects.equals(r1_s_no, other.r1_s_no) && Objects.equals(report_date, other.report_date);
	}
	
	
	
}
