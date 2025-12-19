package com.bornfire.xbrl.entities.BrfOutstandingEntries;

import java.io.Serializable;


import javax.persistence.Embeddable;

@Embeddable
public class BRF_OUTSTANDING_ENTRIES_ManualId implements Serializable {

	private static final long serialVersionUID = 1L;
	private String	report_date;
	private String	num_operation;
	public String getReport_date() {
		return report_date;
	}
	public void setReport_date(String report_date) {
		this.report_date = report_date;
	}
	public String getNum_operation() {
		return num_operation;
	}
	public void setNum_operation(String num_operation) {
		this.num_operation = num_operation;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public BRF_OUTSTANDING_ENTRIES_ManualId(String report_date, String num_operation) {
		super();
		this.report_date = report_date;
		this.num_operation = num_operation;
	}
	public BRF_OUTSTANDING_ENTRIES_ManualId() {
		
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
		BRF_OUTSTANDING_ENTRIES_ManualId other = (BRF_OUTSTANDING_ENTRIES_ManualId) obj;
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
	

}
