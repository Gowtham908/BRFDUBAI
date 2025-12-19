package com.bornfire.xbrl.entities.BLS0100;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import org.springframework.format.annotation.DateTimeFormat;

@Embeddable
public class BLS0100ModId implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Column(name="acct_no")
	private String	acctno;
	@DateTimeFormat(pattern="dd-MM-yyyy")
	private Date	report_date;
	public String getAcctno() {
		return acctno;
	}
	public void setAcctno(String acctno) {
		this.acctno = acctno;
	}
	public Date getReport_date() {
		return report_date;
	}
	public void setReport_date(Date report_date) {
		this.report_date = report_date;
	}
	public BLS0100ModId(String acctno, Date report_date) {
		super();
		this.acctno = acctno;
		this.report_date = report_date;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((acctno == null) ? 0 : acctno.hashCode());
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
		BLS0100ModId other = (BLS0100ModId) obj;
		if (acctno == null) {
			if (other.acctno != null)
				return false;
		} else if (!acctno.equals(other.acctno))
			return false;
		if (report_date == null) {
			if (other.report_date != null)
				return false;
		} else if (!report_date.equals(other.report_date))
			return false;
		return true;
	}
	
	public BLS0100ModId() {
		super();
		
	}
	public BLS0100ModId(BLS0100DetailId detail) {
		super();
		this.acctno = detail.getAcctno();
		this.report_date = detail.getReport_date();
	}

	
	

}
