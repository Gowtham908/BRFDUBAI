package com.bornfire.xbrl.entities.BRBS;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

public class ReportBRF108Data {
    private List<BRF108_ENTITY> brf108_entity;
    
    @JsonDeserialize(using = CustomDateDeserializer.class)
    private Date from_date;

	public List<BRF108_ENTITY> getBrf108_entity() {
		return brf108_entity;
	}

	public void setBrf108_entity(List<BRF108_ENTITY> brf108_entity) {
		this.brf108_entity = brf108_entity;
	}
	
	public Date getFrom_date() {
		return from_date;
	}


	public void setFrom_date(Date from_date) {
		this.from_date = from_date;
	}

}
