package com.bornfire.xbrl.entities.BLS0100;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class BLS0100ManualId implements Serializable {

	private static final long serialVersionUID = 1L;
	private String	report_date;
	private String	acct_no;
	private String	currency;
	private String	acct_name;
	public String getReport_date() {
		return report_date;
	}
	public void setReport_date(String report_date) {
		this.report_date = report_date;
	}
	public String getAcct_no() {
		return acct_no;
	}
	public void setAcct_no(String acct_no) {
		this.acct_no = acct_no;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public String getAcct_name() {
		return acct_name;
	}
	public void setAcct_name(String acct_name) {
		this.acct_name = acct_name;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public BLS0100ManualId(String report_date, String acct_no, String currency, String acct_name) {
		this.report_date = report_date;
		this.acct_no = acct_no;
		this.currency = currency;
		this.acct_name = acct_name;
	}
	
	public BLS0100ManualId() {}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((acct_name == null) ? 0 : acct_name.hashCode());
		result = prime * result + ((acct_no == null) ? 0 : acct_no.hashCode());
		result = prime * result + ((currency == null) ? 0 : currency.hashCode());
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
		BLS0100ManualId other = (BLS0100ManualId) obj;
		if (acct_name == null) {
			if (other.acct_name != null)
				return false;
		} else if (!acct_name.equals(other.acct_name))
			return false;
		if (acct_no == null) {
			if (other.acct_no != null)
				return false;
		} else if (!acct_no.equals(other.acct_no))
			return false;
		if (currency == null) {
			if (other.currency != null)
				return false;
		} else if (!currency.equals(other.currency))
			return false;
		if (report_date == null) {
			if (other.report_date != null)
				return false;
		} else if (!report_date.equals(other.report_date))
			return false;
		return true;
	}
	
	
		
	
	

}
