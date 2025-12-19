package com.bornfire.xbrl.entities.BLS0100;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Embeddable;

import org.springframework.format.annotation.DateTimeFormat;

@Embeddable
public class BLS0100RepId implements Serializable {
	
	@DateTimeFormat(pattern="dd-MM-yyyy")
	private Date	report_date;
	private BigDecimal	instance_code;
	public Date getReport_date() {
		return report_date;
	}
	public void setReport_date(Date report_date) {
		this.report_date = report_date;
	}
	public BigDecimal getInstance_code() {
		return instance_code;
	}
	public void setInstance_code(BigDecimal instance_code) {
		this.instance_code = instance_code;
	}
	
	public BLS0100RepId(Date report_date, BigDecimal instance_code) {
		super();
		this.report_date = report_date;
		this.instance_code = instance_code;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((instance_code == null) ? 0 : instance_code.hashCode());
		result = prime * result + ((report_date == null) ? 0 : report_date.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BLS0100RepId other = (BLS0100RepId) obj;
		if (instance_code == null) {
			if (other.instance_code != null)
				return false;
		} else if (!instance_code.equals(other.instance_code))
			return false;
		if (report_date == null) {
			if (other.report_date != null)
				return false;
		} else if (!report_date.equals(other.report_date))
			return false;
		return true;
	}
	public BLS0100RepId() {
		
	}
	
	

}
