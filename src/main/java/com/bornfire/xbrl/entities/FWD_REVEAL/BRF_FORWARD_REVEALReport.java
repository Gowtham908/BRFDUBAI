package com.bornfire.xbrl.entities.FWD_REVEAL;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="BRF_FORWARD_REVEAL_RPT_TB")
public class BRF_FORWARD_REVEALReport {
	
	@EmbeddedId
	BRF_FORWARD_REVEALReport_Id BRF_FORWARD_REVEALReport_Id;
	
	private String	report_id;
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date	from_date;
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date	to_date;
	private String	version_no;
	private String	instance_name;
	private BigDecimal	resident;
	private BigDecimal	non_resident;
	private BigDecimal	total;
	
	
	
	
	
	
		public String getReport_id() {
		return report_id;
	}
	public void setReport_id(String report_id) {
		this.report_id = report_id;
	}
	public Date getFrom_date() {
		return from_date;
	}
	public void setFrom_date(Date from_date) {
		this.from_date = from_date;
	}
	public Date getTo_date() {
		return to_date;
	}
	public void setTo_date(Date to_date) {
		this.to_date = to_date;
	}
	public String getVersion_no() {
		return version_no;
	}
	public void setVersion_no(String version_no) {
		this.version_no = version_no;
	}
	public String getInstance_name() {
		return instance_name;
	}
	public void setInstance_name(String instance_name) {
		this.instance_name = instance_name;
	}
	public BigDecimal getResident() {
		return resident;
	}
	public void setResident(BigDecimal resident) {
		this.resident = resident;
	}
	public BigDecimal getNon_resident() {
		return non_resident;
	}
	public void setNon_resident(BigDecimal non_resident) {
		this.non_resident = non_resident;
	}
	public BigDecimal getTotal() {
		return total;
	}
	public void setTotal(BigDecimal total) {
		this.total = total;
	}
	public BRF_FORWARD_REVEALReport_Id getBRF_FORWARD_REVEALReport_Id() {
		return BRF_FORWARD_REVEALReport_Id;
	}
	public void setBRF_FORWARD_REVEALReport_Id(BRF_FORWARD_REVEALReport_Id bRF_FORWARD_REVEALReport_Id) {
		BRF_FORWARD_REVEALReport_Id = bRF_FORWARD_REVEALReport_Id;
	}
	public BRF_FORWARD_REVEALReport(
			com.bornfire.xbrl.entities.FWD_REVEAL.BRF_FORWARD_REVEALReport_Id bRF_FORWARD_REVEALReport_Id,
			String report_id, Date from_date, Date to_date, String version_no, String instance_name,
			BigDecimal resident, BigDecimal non_resident, BigDecimal total) {
		super();
		BRF_FORWARD_REVEALReport_Id = bRF_FORWARD_REVEALReport_Id;
		this.report_id = report_id;
		this.from_date = from_date;
		this.to_date = to_date;
		this.version_no = version_no;
		this.instance_name = instance_name;
		this.resident = resident;
		this.non_resident = non_resident;
		this.total = total;
	}
	@Override
	public String toString() {
		return "BRF_FORWARD_REVEALReport [BRF_FORWARD_REVEALReport_Id=" + BRF_FORWARD_REVEALReport_Id + ", report_id="
				+ report_id + ", from_date=" + from_date + ", to_date=" + to_date + ", version_no=" + version_no
				+ ", instance_name=" + instance_name + ", resident=" + resident + ", non_resident=" + non_resident
				+ ", total=" + total + ", getReport_id()=" + getReport_id() + ", getFrom_date()=" + getFrom_date()
				+ ", getTo_date()=" + getTo_date() + ", getVersion_no()=" + getVersion_no() + ", getInstance_name()="
				+ getInstance_name() + ", getResident()=" + getResident() + ", getNon_resident()=" + getNon_resident()
				+ ", getTotal()=" + getTotal() + ", getBRF_FORWARD_REVEALReport_Id()="
				+ getBRF_FORWARD_REVEALReport_Id() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}

	
	
	
}
