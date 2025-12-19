package com.bornfire.xbrl.entities;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="SCORE_CALCULATION_TABLE")
public class SCORE_CALCULATION_ENTITY {
	
	@Id
	private String	slno;
	private String	variable;
	private String	variable_bin;
	private BigDecimal	score;
	public String getSlno() {
		return slno;
	}
	public void setSlno(String slno) {
		this.slno = slno;
	}
	public String getVariable() {
		return variable;
	}
	public void setVariable(String variable) {
		this.variable = variable;
	}
	public String getVariable_bin() {
		return variable_bin;
	}
	public void setVariable_bin(String variable_bin) {
		this.variable_bin = variable_bin;
	}
	public BigDecimal getScore() {
		return score;
	}
	public void setScore(BigDecimal score) {
		this.score = score;
	}
	public SCORE_CALCULATION_ENTITY(String slno, String variable, String variable_bin, BigDecimal score) {
		super();
		this.slno = slno;
		this.variable = variable;
		this.variable_bin = variable_bin;
		this.score = score;
	}
	public SCORE_CALCULATION_ENTITY() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

}
