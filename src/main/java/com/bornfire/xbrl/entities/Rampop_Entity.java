package com.bornfire.xbrl.entities;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity

public class Rampop_Entity {
	
	@Id
	private String status_start;
	private String bob1;
	private String bob2;
	private String bob3;
	private String bob4;
	private String bob5;
	private String bob6;
	private String bob7;
	private String bob10;
	public String getStatus_start() {
		return status_start;
	}
	public void setStatus_start(String status_start) {
		this.status_start = status_start;
	}
	public String getBob1() {
		return bob1;
	}
	public void setBob1(String bob1) {
		this.bob1 = bob1;
	}
	public String getBob2() {
		return bob2;
	}
	public void setBob2(String bob2) {
		this.bob2 = bob2;
	}
	public String getBob3() {
		return bob3;
	}
	public void setBob3(String bob3) {
		this.bob3 = bob3;
	}
	public String getBob4() {
		return bob4;
	}
	public void setBob4(String bob4) {
		this.bob4 = bob4;
	}
	public String getBob5() {
		return bob5;
	}
	public void setBob5(String bob5) {
		this.bob5 = bob5;
	}
	public String getBob6() {
		return bob6;
	}
	public void setBob6(String bob6) {
		this.bob6 = bob6;
	}
	public String getBob7() {
		return bob7;
	}
	public void setBob7(String bob7) {
		this.bob7 = bob7;
	}
	public String getBob10() {
		return bob10;
	}
	public void setBob10(String bob10) {
		this.bob10 = bob10;
	}
	public Rampop_Entity(String status_start, String bob1, String bob2, String bob3, String bob4, String bob5,
			String bob6, String bob7, String bob10) {
		super();
		this.status_start = status_start;
		this.bob1 = bob1;
		this.bob2 = bob2;
		this.bob3 = bob3;
		this.bob4 = bob4;
		this.bob5 = bob5;
		this.bob6 = bob6;
		this.bob7 = bob7;
		this.bob10 = bob10;
	}
	public Rampop_Entity() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
