
package com.bornfire.xbrl.entities.Profitloss;
import java.io.Serializable;

import java.math.BigDecimal;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;


public class BrfprofitlossReportId implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	
	private BigDecimal	instance_code;
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date	report_date;
	
	
	
	
	public BigDecimal getInstance_code() {
		return instance_code;
	}
	public void setInstance_code(BigDecimal instance_code) {
		this.instance_code = instance_code;
	}
	public Date getReport_date() {
		return report_date;
	}
	public void setReport_date(Date report_date) {
		this.report_date = report_date;
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
		BrfprofitlossReportId other = (BrfprofitlossReportId) obj;
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
   public BrfprofitlossReportId() {
		
		// TODO Auto-generated constructor stub
	}
public BrfprofitlossReportId(BigDecimal instance_code, Date report_date) {
	super();
	this.instance_code = instance_code;
	this.report_date = report_date;
}
public BrfprofitlossReportId(Date report_date2, BigDecimal instance_code2) {
	// TODO Auto-generated constructor stub
}

	
	
}

