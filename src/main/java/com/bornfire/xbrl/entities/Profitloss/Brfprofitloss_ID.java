

package com.bornfire.xbrl.entities.Profitloss;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Embeddable;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;
@Embeddable
public class Brfprofitloss_ID implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private BigDecimal	num_operation;
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date	report_date;
	public BigDecimal getNum_operation() {
		return num_operation;
	}
	public void setNum_operation(BigDecimal num_operation) {
		this.num_operation = num_operation;
	}
	public Date getReport_date() {
		return report_date;
	}
	public void setReport_date(Date report_date) {
		this.report_date = report_date;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(num_operation, report_date);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Brfprofitloss_ID other = (Brfprofitloss_ID) obj;
		return Objects.equals(num_operation, other.num_operation) && Objects.equals(report_date, other.report_date);
	
	}
	public Brfprofitloss_ID(BigDecimal num_operation, Date report_date) {
		super();
		this.num_operation = num_operation;
		this.report_date = report_date;
	}
	public Brfprofitloss_ID() {
		super();
		// TODO Auto-generated constructor stub
	}
    

}

