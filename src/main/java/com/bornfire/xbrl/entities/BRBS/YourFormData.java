package com.bornfire.xbrl.entities.BRBS;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

public class YourFormData {
	
	private List<BRF69_SUMMARY_A_ENTITY> brf69_REPORTENTITY;
	private List<BRF069_SUMMARY_B_ENTITY> brf069_SUMMARY_2_ENTITY;
	private List<BRF069_SUMMARY_C_ENTITY> brf069_SUMMARY_3_ENTITY;
	private List<BRF069_SUMMARY_D_ENTITY> brf069_SUMMARY_4_ENTITY;

	
    @JsonDeserialize(using = CustomDateDeserializer.class)
    private Date from_date;


	public List<BRF69_SUMMARY_A_ENTITY> getBrf69_REPORTENTITY() {
		return brf69_REPORTENTITY;
	}


	public void setBrf69_REPORTENTITY(List<BRF69_SUMMARY_A_ENTITY> brf69_REPORTENTITY) {
		this.brf69_REPORTENTITY = brf69_REPORTENTITY;
	}


	public List<BRF069_SUMMARY_B_ENTITY> getBrf069_SUMMARY_2_ENTITY() {
		return brf069_SUMMARY_2_ENTITY;
	}


	public void setBrf069_SUMMARY_2_ENTITY(List<BRF069_SUMMARY_B_ENTITY> brf069_SUMMARY_2_ENTITY) {
		this.brf069_SUMMARY_2_ENTITY = brf069_SUMMARY_2_ENTITY;
	}


	public List<BRF069_SUMMARY_C_ENTITY> getBrf069_SUMMARY_3_ENTITY() {
		return brf069_SUMMARY_3_ENTITY;
	}


	public void setBrf069_SUMMARY_3_ENTITY(List<BRF069_SUMMARY_C_ENTITY> brf069_SUMMARY_3_ENTITY) {
		this.brf069_SUMMARY_3_ENTITY = brf069_SUMMARY_3_ENTITY;
	}


	public List<BRF069_SUMMARY_D_ENTITY> getBrf069_SUMMARY_4_ENTITY() {
		return brf069_SUMMARY_4_ENTITY;
	}


	public void setBrf069_SUMMARY_4_ENTITY(List<BRF069_SUMMARY_D_ENTITY> brf069_SUMMARY_4_ENTITY) {
		this.brf069_SUMMARY_4_ENTITY = brf069_SUMMARY_4_ENTITY;
	}


	public Date getFrom_date() {
		return from_date;
	}


	public void setFrom_date(Date from_date) {
		this.from_date = from_date;
	}

    
}
