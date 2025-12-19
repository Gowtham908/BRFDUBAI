package com.bornfire.xbrl.entities;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ECL_COOLOFF_2")
public class ECL_COOLOFF_2 {

    private BigDecimal DATA_30_09_2023;
    private BigDecimal DATA_30_06_2023;
    private BigDecimal DATA_31_03_2023;
    private BigDecimal DATA_31_12_2022;
    private BigDecimal DATA_30_09_2022;
    private BigDecimal DATA_30_06_2022;
    private BigDecimal DATA_31_03_2022;
    private BigDecimal DATA_31_12_2021;
    private BigDecimal DATA_30_09_2021;
	@Id
	private Date REPORT_DATE;
	public BigDecimal getDATA_30_09_2023() {
		return DATA_30_09_2023;
	}
	public void setDATA_30_09_2023(BigDecimal dATA_30_09_2023) {
		DATA_30_09_2023 = dATA_30_09_2023;
	}
	public BigDecimal getDATA_30_06_2023() {
		return DATA_30_06_2023;
	}
	public void setDATA_30_06_2023(BigDecimal dATA_30_06_2023) {
		DATA_30_06_2023 = dATA_30_06_2023;
	}
	public BigDecimal getDATA_31_03_2023() {
		return DATA_31_03_2023;
	}
	public void setDATA_31_03_2023(BigDecimal dATA_31_03_2023) {
		DATA_31_03_2023 = dATA_31_03_2023;
	}
	public BigDecimal getDATA_31_12_2022() {
		return DATA_31_12_2022;
	}
	public void setDATA_31_12_2022(BigDecimal dATA_31_12_2022) {
		DATA_31_12_2022 = dATA_31_12_2022;
	}
	public BigDecimal getDATA_30_09_2022() {
		return DATA_30_09_2022;
	}
	public void setDATA_30_09_2022(BigDecimal dATA_30_09_2022) {
		DATA_30_09_2022 = dATA_30_09_2022;
	}
	public BigDecimal getDATA_30_06_2022() {
		return DATA_30_06_2022;
	}
	public void setDATA_30_06_2022(BigDecimal dATA_30_06_2022) {
		DATA_30_06_2022 = dATA_30_06_2022;
	}
	public BigDecimal getDATA_31_03_2022() {
		return DATA_31_03_2022;
	}
	public void setDATA_31_03_2022(BigDecimal dATA_31_03_2022) {
		DATA_31_03_2022 = dATA_31_03_2022;
	}
	public BigDecimal getDATA_31_12_2021() {
		return DATA_31_12_2021;
	}
	public void setDATA_31_12_2021(BigDecimal dATA_31_12_2021) {
		DATA_31_12_2021 = dATA_31_12_2021;
	}
	public BigDecimal getDATA_30_09_2021() {
		return DATA_30_09_2021;
	}
	public void setDATA_30_09_2021(BigDecimal dATA_30_09_2021) {
		DATA_30_09_2021 = dATA_30_09_2021;
	}
	public Date getREPORT_DATE() {
		return REPORT_DATE;
	}
	public void setREPORT_DATE(Date rEPORT_DATE) {
		REPORT_DATE = rEPORT_DATE;
	}
	public ECL_COOLOFF_2() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
