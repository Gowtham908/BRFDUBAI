package com.bornfire.xbrl.entities.M_BILL;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class BRF_M_BILL_REPORT_ID implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	
	private String	numero_piece;
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date	report_date;
	
	
	public String getNumero_piece() {
		return numero_piece;
	}
	public void setNumero_piece(String numero_piece) {
		this.numero_piece = numero_piece;
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
	public BRF_M_BILL_REPORT_ID() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public BRF_M_BILL_REPORT_ID(String numero_piece, Date report_date) {
		super();
		this.numero_piece = numero_piece;
		this.report_date = report_date;
	}
	
	public BRF_M_BILL_REPORT_ID(BigDecimal instance_code, Date report_date2) {
		// TODO Auto-generated constructor stub
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((numero_piece == null) ? 0 : numero_piece.hashCode());
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
		BRF_M_BILL_REPORT_ID other = (BRF_M_BILL_REPORT_ID) obj;
		if (numero_piece == null) {
			if (other.numero_piece != null)
				return false;
		} else if (!numero_piece.equals(other.numero_piece))
			return false;
		if (report_date == null) {
			if (other.report_date != null)
				return false;
		} else if (!report_date.equals(other.report_date))
			return false;
		return true;
	}
	
}
