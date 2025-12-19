

package com.bornfire.xbrl.entities.Profitloss;
import java.io.Serializable;


import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import org.springframework.format.annotation.DateTimeFormat;

import com.bornfire.xbrl.entities.BLS0100.BLS0100ModId;



@Embeddable
public class BrfProfitlossDetailId implements Serializable{
	private static final long serialVersionUID =  -6151524056824907655L;
	//@Column(name="num_operation")
	private String	num_operation;
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date	report_date;
	public String getNum_operation() {
		return num_operation;
	}
	public void setNum_operation(String num_operation) {
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
	public BrfProfitlossDetailId(String num_operation, Date report_date) {
		super();
		this.num_operation = num_operation;
		this.report_date = report_date;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((num_operation == null) ? 0 : num_operation.hashCode());
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
		BrfProfitlossDetailId other = (BrfProfitlossDetailId) obj;
		if (num_operation == null) {
			if (other.num_operation != null)
				return false;
		} else if (!num_operation.equals(other.num_operation))
			return false;
		if (report_date == null) {
			if (other.report_date != null)
				return false;
		} else if (!report_date.equals(other.report_date))
			return false;
		return true;
	}
	public BrfProfitlossDetailId(BRFPROFITLOSSMod_Id mod) {
		super();
		this.num_operation = mod.getNum_operation();
		this.report_date = mod.getReport_date();
		
	}
	public BrfProfitlossDetailId(BigDecimal instance_code, Date report_date2) {
		// TODO Auto-generated constructor stub
	}
	
	

}
