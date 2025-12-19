package com.bornfire.xbrl.entities;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ECL_MAPPING_INFOFLG")
public class ECL_INFOFLG {
	
	@Id
	private BigDecimal	code;
	private String	type;
	public BigDecimal getCode() {
		return code;
	}
	public void setCode(BigDecimal code) {
		this.code = code;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public ECL_INFOFLG(BigDecimal code, String type) {
		super();
		this.code = code;
		this.type = type;
	}
	public ECL_INFOFLG() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	


}
