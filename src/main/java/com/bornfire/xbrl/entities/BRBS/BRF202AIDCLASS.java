package com.bornfire.xbrl.entities.BRBS;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Embeddable;
import javax.persistence.Id;

@Embeddable
public class BRF202AIDCLASS implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	private String r1_s_no;
	@Id
	private Date report_date;

}
