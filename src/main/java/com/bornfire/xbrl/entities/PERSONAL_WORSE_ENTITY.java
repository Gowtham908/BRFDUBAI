package com.bornfire.xbrl.entities;

import java.math.BigDecimal;

public class PERSONAL_WORSE_ENTITY {

	private String	variable;
	private BigDecimal	group_dbr;
	private String	bin_value;
	private BigDecimal	partial_score;
	private BigDecimal	effactive_partial_score;
	private BigDecimal	weight;
	private BigDecimal	max_score;
	private BigDecimal	min_score;
	private BigDecimal	avg_score;
	public String getVariable() {
		return variable;
	}
	public void setVariable(String variable) {
		this.variable = variable;
	}
	public BigDecimal getGroup_dbr() {
		return group_dbr;
	}
	public void setGroup_dbr(BigDecimal group_dbr) {
		this.group_dbr = group_dbr;
	}
	public String getBin_value() {
		return bin_value;
	}
	public void setBin_value(String bin_value) {
		this.bin_value = bin_value;
	}
	public BigDecimal getPartial_score() {
		return partial_score;
	}
	public void setPartial_score(BigDecimal partial_score) {
		this.partial_score = partial_score;
	}
	public BigDecimal getEffactive_partial_score() {
		return effactive_partial_score;
	}
	public void setEffactive_partial_score(BigDecimal effactive_partial_score) {
		this.effactive_partial_score = effactive_partial_score;
	}
	public BigDecimal getWeight() {
		return weight;
	}
	public void setWeight(BigDecimal weight) {
		this.weight = weight;
	}
	public BigDecimal getMax_score() {
		return max_score;
	}
	public void setMax_score(BigDecimal max_score) {
		this.max_score = max_score;
	}
	public BigDecimal getMin_score() {
		return min_score;
	}
	public void setMin_score(BigDecimal min_score) {
		this.min_score = min_score;
	}
	public BigDecimal getAvg_score() {
		return avg_score;
	}
	public void setAvg_score(BigDecimal avg_score) {
		this.avg_score = avg_score;
	}
	public PERSONAL_WORSE_ENTITY(String variable, BigDecimal group_dbr, String bin_value, BigDecimal partial_score,
			BigDecimal effactive_partial_score, BigDecimal weight, BigDecimal max_score, BigDecimal min_score,
			BigDecimal avg_score) {
		super();
		this.variable = variable;
		this.group_dbr = group_dbr;
		this.bin_value = bin_value;
		this.partial_score = partial_score;
		this.effactive_partial_score = effactive_partial_score;
		this.weight = weight;
		this.max_score = max_score;
		this.min_score = min_score;
		this.avg_score = avg_score;
	}
	public PERSONAL_WORSE_ENTITY() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	
}
