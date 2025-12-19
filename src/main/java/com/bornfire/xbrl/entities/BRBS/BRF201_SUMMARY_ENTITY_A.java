package com.bornfire.xbrl.entities.BRBS;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="BRF201_SUMMARYTABLE_A")
@IdClass(BRF201IDCLASS.class)
public class BRF201_SUMMARY_ENTITY_A {
	private String	r1_network_in_uae;
	private BigDecimal	r1_beginning_of_period;
	private BigDecimal	r1_opened_during_period;
	private BigDecimal	r1_closed_during_period;
	private BigDecimal	r1_end_of_period;
	private BigDecimal	r1_abudhabi;
	private BigDecimal	r1_dubai;
	private BigDecimal	r1_sharjah;
	private BigDecimal	r1_ajman;
	private BigDecimal	r1_rak;
	private BigDecimal	r1_fujairah;
	private BigDecimal	r1_uaq;
	private BigDecimal	r1_total;
	private String	r2_network_in_uae;
	private BigDecimal	r2_beginning_of_period;
	private BigDecimal	r2_opened_during_period;
	private BigDecimal	r2_closed_during_period;
	private BigDecimal	r2_end_of_period;
	private BigDecimal	r2_abudhabi;
	private BigDecimal	r2_dubai;
	private BigDecimal	r2_sharjah;
	private BigDecimal	r2_ajman;
	private BigDecimal	r2_rak;
	private BigDecimal	r2_fujairah;
	private BigDecimal	r2_uaq;
	private BigDecimal	r2_total;
	private String	r3_network_in_uae;
	private BigDecimal	r3_beginning_of_period;
	private BigDecimal	r3_opened_during_period;
	private BigDecimal	r3_closed_during_period;
	private BigDecimal	r3_end_of_period;
	private BigDecimal	r3_abudhabi;
	private BigDecimal	r3_dubai;
	private BigDecimal	r3_sharjah;
	private BigDecimal	r3_ajman;
	private BigDecimal	r3_rak;
	private BigDecimal	r3_fujairah;
	private BigDecimal	r3_uaq;
	private BigDecimal	r3_total;
	private String	r4_network_in_uae;
	private BigDecimal	r4_beginning_of_period;
	private BigDecimal	r4_opened_during_period;
	private BigDecimal	r4_closed_during_period;
	private BigDecimal	r4_end_of_period;
	private BigDecimal	r4_abudhabi;
	private BigDecimal	r4_dubai;
	private BigDecimal	r4_sharjah;
	private BigDecimal	r4_ajman;
	private BigDecimal	r4_rak;
	private BigDecimal	r4_fujairah;
	private BigDecimal	r4_uaq;
	private BigDecimal	r4_total;
	private String	r5_network_in_uae;
	private BigDecimal	r5_beginning_of_period;
	private BigDecimal	r5_opened_during_period;
	private BigDecimal	r5_closed_during_period;
	private BigDecimal	r5_end_of_period;
	private BigDecimal	r5_abudhabi;
	private BigDecimal	r5_dubai;
	private BigDecimal	r5_sharjah;
	private BigDecimal	r5_ajman;
	private BigDecimal	r5_rak;
	private BigDecimal	r5_fujairah;
	private BigDecimal	r5_uaq;
	private BigDecimal	r5_total;
	private String	r6_network_in_uae;
	private BigDecimal	r6_beginning_of_period;
	private BigDecimal	r6_opened_during_period;
	private BigDecimal	r6_closed_during_period;
	private BigDecimal	r6_end_of_period;
	private BigDecimal	r6_abudhabi;
	private BigDecimal	r6_dubai;
	private BigDecimal	r6_sharjah;
	private BigDecimal	r6_ajman;
	private BigDecimal	r6_rak;
	private BigDecimal	r6_fujairah;
	private BigDecimal	r6_uaq;
	private BigDecimal	r6_total;
	private String	r7_network_in_uae;
	private BigDecimal	r7_beginning_of_period;
	private BigDecimal	r7_opened_during_period;
	private BigDecimal	r7_closed_during_period;
	private BigDecimal	r7_end_of_period;
	private BigDecimal	r7_abudhabi;
	private BigDecimal	r7_dubai;
	private BigDecimal	r7_sharjah;
	private BigDecimal	r7_ajman;
	private BigDecimal	r7_rak;
	private BigDecimal	r7_fujairah;
	private BigDecimal	r7_uaq;
	private BigDecimal	r7_total;
	private Date	report_submit_date;
	@Id
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date	report_date;
	private Date	report_from_date;
	private Date	report_to_date;
	private String	report_code;
	private String	entity_flg;
	private String	modify_flg;
	private String	del_flg;
	private String	entry_user;
	private String	modify_user;
	private String	verify_user;
	private Date	entry_time;
	private Date	modify_time;
	private Date	verify_time;
	@Id
	private BigDecimal	srl_no;

	 
	 

	public String getR1_network_in_uae() {
		return r1_network_in_uae;
	}

	public void setR1_network_in_uae(String r1_network_in_uae) {
		this.r1_network_in_uae = r1_network_in_uae;
	}

	public BigDecimal getR1_beginning_of_period() {
		return r1_beginning_of_period;
	}

	public void setR1_beginning_of_period(BigDecimal r1_beginning_of_period) {
		this.r1_beginning_of_period = r1_beginning_of_period;
	}

	public BigDecimal getR1_opened_during_period() {
		return r1_opened_during_period;
	}

	public void setR1_opened_during_period(BigDecimal r1_opened_during_period) {
		this.r1_opened_during_period = r1_opened_during_period;
	}

	public BigDecimal getR1_closed_during_period() {
		return r1_closed_during_period;
	}

	public void setR1_closed_during_period(BigDecimal r1_closed_during_period) {
		this.r1_closed_during_period = r1_closed_during_period;
	}

	public BigDecimal getR1_end_of_period() {
		return r1_end_of_period;
	}

	public void setR1_end_of_period(BigDecimal r1_end_of_period) {
		this.r1_end_of_period = r1_end_of_period;
	}

	public BigDecimal getR1_abudhabi() {
		return r1_abudhabi;
	}

	public void setR1_abudhabi(BigDecimal r1_abudhabi) {
		this.r1_abudhabi = r1_abudhabi;
	}

	public BigDecimal getR1_dubai() {
		return r1_dubai;
	}

	public void setR1_dubai(BigDecimal r1_dubai) {
		this.r1_dubai = r1_dubai;
	}

	public BigDecimal getR1_sharjah() {
		return r1_sharjah;
	}

	public void setR1_sharjah(BigDecimal r1_sharjah) {
		this.r1_sharjah = r1_sharjah;
	}

	public BigDecimal getR1_ajman() {
		return r1_ajman;
	}

	public void setR1_ajman(BigDecimal r1_ajman) {
		this.r1_ajman = r1_ajman;
	}

	public BigDecimal getR1_rak() {
		return r1_rak;
	}

	public void setR1_rak(BigDecimal r1_rak) {
		this.r1_rak = r1_rak;
	}

	public BigDecimal getR1_fujairah() {
		return r1_fujairah;
	}

	public void setR1_fujairah(BigDecimal r1_fujairah) {
		this.r1_fujairah = r1_fujairah;
	}

	public BigDecimal getR1_uaq() {
		return r1_uaq;
	}

	public void setR1_uaq(BigDecimal r1_uaq) {
		this.r1_uaq = r1_uaq;
	}

	public BigDecimal getR1_total() {
		return r1_total;
	}

	public void setR1_total(BigDecimal r1_total) {
		this.r1_total = r1_total;
	}

	public String getR2_network_in_uae() {
		return r2_network_in_uae;
	}

	public void setR2_network_in_uae(String r2_network_in_uae) {
		this.r2_network_in_uae = r2_network_in_uae;
	}

	public BigDecimal getR2_beginning_of_period() {
		return r2_beginning_of_period;
	}

	public void setR2_beginning_of_period(BigDecimal r2_beginning_of_period) {
		this.r2_beginning_of_period = r2_beginning_of_period;
	}

	public BigDecimal getR2_opened_during_period() {
		return r2_opened_during_period;
	}

	public void setR2_opened_during_period(BigDecimal r2_opened_during_period) {
		this.r2_opened_during_period = r2_opened_during_period;
	}

	public BigDecimal getR2_closed_during_period() {
		return r2_closed_during_period;
	}

	public void setR2_closed_during_period(BigDecimal r2_closed_during_period) {
		this.r2_closed_during_period = r2_closed_during_period;
	}

	public BigDecimal getR2_end_of_period() {
		return r2_end_of_period;
	}

	public void setR2_end_of_period(BigDecimal r2_end_of_period) {
		this.r2_end_of_period = r2_end_of_period;
	}

	public BigDecimal getR2_abudhabi() {
		return r2_abudhabi;
	}

	public void setR2_abudhabi(BigDecimal r2_abudhabi) {
		this.r2_abudhabi = r2_abudhabi;
	}

	public BigDecimal getR2_dubai() {
		return r2_dubai;
	}

	public void setR2_dubai(BigDecimal r2_dubai) {
		this.r2_dubai = r2_dubai;
	}

	public BigDecimal getR2_sharjah() {
		return r2_sharjah;
	}

	public void setR2_sharjah(BigDecimal r2_sharjah) {
		this.r2_sharjah = r2_sharjah;
	}

	public BigDecimal getR2_ajman() {
		return r2_ajman;
	}

	public void setR2_ajman(BigDecimal r2_ajman) {
		this.r2_ajman = r2_ajman;
	}

	public BigDecimal getR2_rak() {
		return r2_rak;
	}

	public void setR2_rak(BigDecimal r2_rak) {
		this.r2_rak = r2_rak;
	}

	public BigDecimal getR2_fujairah() {
		return r2_fujairah;
	}

	public void setR2_fujairah(BigDecimal r2_fujairah) {
		this.r2_fujairah = r2_fujairah;
	}

	public BigDecimal getR2_uaq() {
		return r2_uaq;
	}

	public void setR2_uaq(BigDecimal r2_uaq) {
		this.r2_uaq = r2_uaq;
	}

	public BigDecimal getR2_total() {
		return r2_total;
	}

	public void setR2_total(BigDecimal r2_total) {
		this.r2_total = r2_total;
	}

	public String getR3_network_in_uae() {
		return r3_network_in_uae;
	}

	public void setR3_network_in_uae(String r3_network_in_uae) {
		this.r3_network_in_uae = r3_network_in_uae;
	}

	public BigDecimal getR3_beginning_of_period() {
		return r3_beginning_of_period;
	}

	public void setR3_beginning_of_period(BigDecimal r3_beginning_of_period) {
		this.r3_beginning_of_period = r3_beginning_of_period;
	}

	public BigDecimal getR3_opened_during_period() {
		return r3_opened_during_period;
	}

	public void setR3_opened_during_period(BigDecimal r3_opened_during_period) {
		this.r3_opened_during_period = r3_opened_during_period;
	}

	public BigDecimal getR3_closed_during_period() {
		return r3_closed_during_period;
	}

	public void setR3_closed_during_period(BigDecimal r3_closed_during_period) {
		this.r3_closed_during_period = r3_closed_during_period;
	}

	public BigDecimal getR3_end_of_period() {
		return r3_end_of_period;
	}

	public void setR3_end_of_period(BigDecimal r3_end_of_period) {
		this.r3_end_of_period = r3_end_of_period;
	}

	public BigDecimal getR3_abudhabi() {
		return r3_abudhabi;
	}

	public void setR3_abudhabi(BigDecimal r3_abudhabi) {
		this.r3_abudhabi = r3_abudhabi;
	}

	public BigDecimal getR3_dubai() {
		return r3_dubai;
	}

	public void setR3_dubai(BigDecimal r3_dubai) {
		this.r3_dubai = r3_dubai;
	}

	public BigDecimal getR3_sharjah() {
		return r3_sharjah;
	}

	public void setR3_sharjah(BigDecimal r3_sharjah) {
		this.r3_sharjah = r3_sharjah;
	}

	public BigDecimal getR3_ajman() {
		return r3_ajman;
	}

	public void setR3_ajman(BigDecimal r3_ajman) {
		this.r3_ajman = r3_ajman;
	}

	public BigDecimal getR3_rak() {
		return r3_rak;
	}

	public void setR3_rak(BigDecimal r3_rak) {
		this.r3_rak = r3_rak;
	}

	public BigDecimal getR3_fujairah() {
		return r3_fujairah;
	}

	public void setR3_fujairah(BigDecimal r3_fujairah) {
		this.r3_fujairah = r3_fujairah;
	}

	public BigDecimal getR3_uaq() {
		return r3_uaq;
	}

	public void setR3_uaq(BigDecimal r3_uaq) {
		this.r3_uaq = r3_uaq;
	}

	public BigDecimal getR3_total() {
		return r3_total;
	}

	public void setR3_total(BigDecimal r3_total) {
		this.r3_total = r3_total;
	}

	public String getR4_network_in_uae() {
		return r4_network_in_uae;
	}

	public void setR4_network_in_uae(String r4_network_in_uae) {
		this.r4_network_in_uae = r4_network_in_uae;
	}

	public BigDecimal getR4_beginning_of_period() {
		return r4_beginning_of_period;
	}

	public void setR4_beginning_of_period(BigDecimal r4_beginning_of_period) {
		this.r4_beginning_of_period = r4_beginning_of_period;
	}

	public BigDecimal getR4_opened_during_period() {
		return r4_opened_during_period;
	}

	public void setR4_opened_during_period(BigDecimal r4_opened_during_period) {
		this.r4_opened_during_period = r4_opened_during_period;
	}

	public BigDecimal getR4_closed_during_period() {
		return r4_closed_during_period;
	}

	public void setR4_closed_during_period(BigDecimal r4_closed_during_period) {
		this.r4_closed_during_period = r4_closed_during_period;
	}

	public BigDecimal getR4_end_of_period() {
		return r4_end_of_period;
	}

	public void setR4_end_of_period(BigDecimal r4_end_of_period) {
		this.r4_end_of_period = r4_end_of_period;
	}

	public BigDecimal getR4_abudhabi() {
		return r4_abudhabi;
	}

	public void setR4_abudhabi(BigDecimal r4_abudhabi) {
		this.r4_abudhabi = r4_abudhabi;
	}

	public BigDecimal getR4_dubai() {
		return r4_dubai;
	}

	public void setR4_dubai(BigDecimal r4_dubai) {
		this.r4_dubai = r4_dubai;
	}

	public BigDecimal getR4_sharjah() {
		return r4_sharjah;
	}

	public void setR4_sharjah(BigDecimal r4_sharjah) {
		this.r4_sharjah = r4_sharjah;
	}

	public BigDecimal getR4_ajman() {
		return r4_ajman;
	}

	public void setR4_ajman(BigDecimal r4_ajman) {
		this.r4_ajman = r4_ajman;
	}

	public BigDecimal getR4_rak() {
		return r4_rak;
	}

	public void setR4_rak(BigDecimal r4_rak) {
		this.r4_rak = r4_rak;
	}

	public BigDecimal getR4_fujairah() {
		return r4_fujairah;
	}

	public void setR4_fujairah(BigDecimal r4_fujairah) {
		this.r4_fujairah = r4_fujairah;
	}

	public BigDecimal getR4_uaq() {
		return r4_uaq;
	}

	public void setR4_uaq(BigDecimal r4_uaq) {
		this.r4_uaq = r4_uaq;
	}

	public BigDecimal getR4_total() {
		return r4_total;
	}

	public void setR4_total(BigDecimal r4_total) {
		this.r4_total = r4_total;
	}

	public String getR5_network_in_uae() {
		return r5_network_in_uae;
	}

	public void setR5_network_in_uae(String r5_network_in_uae) {
		this.r5_network_in_uae = r5_network_in_uae;
	}

	public BigDecimal getR5_beginning_of_period() {
		return r5_beginning_of_period;
	}

	public void setR5_beginning_of_period(BigDecimal r5_beginning_of_period) {
		this.r5_beginning_of_period = r5_beginning_of_period;
	}

	public BigDecimal getR5_opened_during_period() {
		return r5_opened_during_period;
	}

	public void setR5_opened_during_period(BigDecimal r5_opened_during_period) {
		this.r5_opened_during_period = r5_opened_during_period;
	}

	public BigDecimal getR5_closed_during_period() {
		return r5_closed_during_period;
	}

	public void setR5_closed_during_period(BigDecimal r5_closed_during_period) {
		this.r5_closed_during_period = r5_closed_during_period;
	}

	public BigDecimal getR5_end_of_period() {
		return r5_end_of_period;
	}

	public void setR5_end_of_period(BigDecimal r5_end_of_period) {
		this.r5_end_of_period = r5_end_of_period;
	}

	public BigDecimal getR5_abudhabi() {
		return r5_abudhabi;
	}

	public void setR5_abudhabi(BigDecimal r5_abudhabi) {
		this.r5_abudhabi = r5_abudhabi;
	}

	public BigDecimal getR5_dubai() {
		return r5_dubai;
	}

	public void setR5_dubai(BigDecimal r5_dubai) {
		this.r5_dubai = r5_dubai;
	}

	public BigDecimal getR5_sharjah() {
		return r5_sharjah;
	}

	public void setR5_sharjah(BigDecimal r5_sharjah) {
		this.r5_sharjah = r5_sharjah;
	}

	public BigDecimal getR5_ajman() {
		return r5_ajman;
	}

	public void setR5_ajman(BigDecimal r5_ajman) {
		this.r5_ajman = r5_ajman;
	}

	public BigDecimal getR5_rak() {
		return r5_rak;
	}

	public void setR5_rak(BigDecimal r5_rak) {
		this.r5_rak = r5_rak;
	}

	public BigDecimal getR5_fujairah() {
		return r5_fujairah;
	}

	public void setR5_fujairah(BigDecimal r5_fujairah) {
		this.r5_fujairah = r5_fujairah;
	}

	public BigDecimal getR5_uaq() {
		return r5_uaq;
	}

	public void setR5_uaq(BigDecimal r5_uaq) {
		this.r5_uaq = r5_uaq;
	}

	public BigDecimal getR5_total() {
		return r5_total;
	}

	public void setR5_total(BigDecimal r5_total) {
		this.r5_total = r5_total;
	}

	public String getR6_network_in_uae() {
		return r6_network_in_uae;
	}

	public void setR6_network_in_uae(String r6_network_in_uae) {
		this.r6_network_in_uae = r6_network_in_uae;
	}

	public BigDecimal getR6_beginning_of_period() {
		return r6_beginning_of_period;
	}

	public void setR6_beginning_of_period(BigDecimal r6_beginning_of_period) {
		this.r6_beginning_of_period = r6_beginning_of_period;
	}

	public BigDecimal getR6_opened_during_period() {
		return r6_opened_during_period;
	}

	public void setR6_opened_during_period(BigDecimal r6_opened_during_period) {
		this.r6_opened_during_period = r6_opened_during_period;
	}

	public BigDecimal getR6_closed_during_period() {
		return r6_closed_during_period;
	}

	public void setR6_closed_during_period(BigDecimal r6_closed_during_period) {
		this.r6_closed_during_period = r6_closed_during_period;
	}

	public BigDecimal getR6_end_of_period() {
		return r6_end_of_period;
	}

	public void setR6_end_of_period(BigDecimal r6_end_of_period) {
		this.r6_end_of_period = r6_end_of_period;
	}

	public BigDecimal getR6_abudhabi() {
		return r6_abudhabi;
	}

	public void setR6_abudhabi(BigDecimal r6_abudhabi) {
		this.r6_abudhabi = r6_abudhabi;
	}

	public BigDecimal getR6_dubai() {
		return r6_dubai;
	}

	public void setR6_dubai(BigDecimal r6_dubai) {
		this.r6_dubai = r6_dubai;
	}

	public BigDecimal getR6_sharjah() {
		return r6_sharjah;
	}

	public void setR6_sharjah(BigDecimal r6_sharjah) {
		this.r6_sharjah = r6_sharjah;
	}

	public BigDecimal getR6_ajman() {
		return r6_ajman;
	}

	public void setR6_ajman(BigDecimal r6_ajman) {
		this.r6_ajman = r6_ajman;
	}

	public BigDecimal getR6_rak() {
		return r6_rak;
	}

	public void setR6_rak(BigDecimal r6_rak) {
		this.r6_rak = r6_rak;
	}

	public BigDecimal getR6_fujairah() {
		return r6_fujairah;
	}

	public void setR6_fujairah(BigDecimal r6_fujairah) {
		this.r6_fujairah = r6_fujairah;
	}

	public BigDecimal getR6_uaq() {
		return r6_uaq;
	}

	public void setR6_uaq(BigDecimal r6_uaq) {
		this.r6_uaq = r6_uaq;
	}

	public BigDecimal getR6_total() {
		return r6_total;
	}

	public void setR6_total(BigDecimal r6_total) {
		this.r6_total = r6_total;
	}

	public String getR7_network_in_uae() {
		return r7_network_in_uae;
	}

	public void setR7_network_in_uae(String r7_network_in_uae) {
		this.r7_network_in_uae = r7_network_in_uae;
	}

	public BigDecimal getR7_beginning_of_period() {
		return r7_beginning_of_period;
	}

	public void setR7_beginning_of_period(BigDecimal r7_beginning_of_period) {
		this.r7_beginning_of_period = r7_beginning_of_period;
	}

	public BigDecimal getR7_opened_during_period() {
		return r7_opened_during_period;
	}

	public void setR7_opened_during_period(BigDecimal r7_opened_during_period) {
		this.r7_opened_during_period = r7_opened_during_period;
	}

	public BigDecimal getR7_closed_during_period() {
		return r7_closed_during_period;
	}

	public void setR7_closed_during_period(BigDecimal r7_closed_during_period) {
		this.r7_closed_during_period = r7_closed_during_period;
	}

	public BigDecimal getR7_end_of_period() {
		return r7_end_of_period;
	}

	public void setR7_end_of_period(BigDecimal r7_end_of_period) {
		this.r7_end_of_period = r7_end_of_period;
	}

	public BigDecimal getR7_abudhabi() {
		return r7_abudhabi;
	}

	public void setR7_abudhabi(BigDecimal r7_abudhabi) {
		this.r7_abudhabi = r7_abudhabi;
	}

	public BigDecimal getR7_dubai() {
		return r7_dubai;
	}

	public void setR7_dubai(BigDecimal r7_dubai) {
		this.r7_dubai = r7_dubai;
	}

	public BigDecimal getR7_sharjah() {
		return r7_sharjah;
	}

	public void setR7_sharjah(BigDecimal r7_sharjah) {
		this.r7_sharjah = r7_sharjah;
	}

	public BigDecimal getR7_ajman() {
		return r7_ajman;
	}

	public void setR7_ajman(BigDecimal r7_ajman) {
		this.r7_ajman = r7_ajman;
	}

	public BigDecimal getR7_rak() {
		return r7_rak;
	}

	public void setR7_rak(BigDecimal r7_rak) {
		this.r7_rak = r7_rak;
	}

	public BigDecimal getR7_fujairah() {
		return r7_fujairah;
	}

	public void setR7_fujairah(BigDecimal r7_fujairah) {
		this.r7_fujairah = r7_fujairah;
	}

	public BigDecimal getR7_uaq() {
		return r7_uaq;
	}

	public void setR7_uaq(BigDecimal r7_uaq) {
		this.r7_uaq = r7_uaq;
	}

	public BigDecimal getR7_total() {
		return r7_total;
	}

	public void setR7_total(BigDecimal r7_total) {
		this.r7_total = r7_total;
	}

	public Date getReport_submit_date() {
		return report_submit_date;
	}

	public void setReport_submit_date(Date report_submit_date) {
		this.report_submit_date = report_submit_date;
	}

	public Date getReport_date() {
		return report_date;
	}

	public void setReport_date(Date report_date) {
		this.report_date = report_date;
	}

	public Date getReport_from_date() {
		return report_from_date;
	}

	public void setReport_from_date(Date report_from_date) {
		this.report_from_date = report_from_date;
	}

	public Date getReport_to_date() {
		return report_to_date;
	}

	public void setReport_to_date(Date report_to_date) {
		this.report_to_date = report_to_date;
	}

	public String getReport_code() {
		return report_code;
	}

	public void setReport_code(String report_code) {
		this.report_code = report_code;
	}

	public String getEntity_flg() {
		return entity_flg;
	}

	public void setEntity_flg(String entity_flg) {
		this.entity_flg = entity_flg;
	}

	public String getModify_flg() {
		return modify_flg;
	}

	public void setModify_flg(String modify_flg) {
		this.modify_flg = modify_flg;
	}

	public String getDel_flg() {
		return del_flg;
	}

	public void setDel_flg(String del_flg) {
		this.del_flg = del_flg;
	}

	public String getEntry_user() {
		return entry_user;
	}

	public void setEntry_user(String entry_user) {
		this.entry_user = entry_user;
	}

	public String getModify_user() {
		return modify_user;
	}

	public void setModify_user(String modify_user) {
		this.modify_user = modify_user;
	}

	public String getVerify_user() {
		return verify_user;
	}

	public void setVerify_user(String verify_user) {
		this.verify_user = verify_user;
	}

	public Date getEntry_time() {
		return entry_time;
	}

	public void setEntry_time(Date entry_time) {
		this.entry_time = entry_time;
	}

	public Date getModify_time() {
		return modify_time;
	}

	public void setModify_time(Date modify_time) {
		this.modify_time = modify_time;
	}

	public Date getVerify_time() {
		return verify_time;
	}

	public void setVerify_time(Date verify_time) {
		this.verify_time = verify_time;
	}

	public BigDecimal getSrl_no() {
		return srl_no;
	}

	public void setSrl_no(BigDecimal srl_no) {
		this.srl_no = srl_no;
	}

	public BRF201_SUMMARY_ENTITY_A(String r1_network_in_uae, BigDecimal r1_beginning_of_period,
			BigDecimal r1_opened_during_period, BigDecimal r1_closed_during_period, BigDecimal r1_end_of_period,
			BigDecimal r1_abudhabi, BigDecimal r1_dubai, BigDecimal r1_sharjah, BigDecimal r1_ajman, BigDecimal r1_rak,
			BigDecimal r1_fujairah, BigDecimal r1_uaq, BigDecimal r1_total, String r2_network_in_uae,
			BigDecimal r2_beginning_of_period, BigDecimal r2_opened_during_period, BigDecimal r2_closed_during_period,
			BigDecimal r2_end_of_period, BigDecimal r2_abudhabi, BigDecimal r2_dubai, BigDecimal r2_sharjah,
			BigDecimal r2_ajman, BigDecimal r2_rak, BigDecimal r2_fujairah, BigDecimal r2_uaq, BigDecimal r2_total,
			String r3_network_in_uae, BigDecimal r3_beginning_of_period, BigDecimal r3_opened_during_period,
			BigDecimal r3_closed_during_period, BigDecimal r3_end_of_period, BigDecimal r3_abudhabi,
			BigDecimal r3_dubai, BigDecimal r3_sharjah, BigDecimal r3_ajman, BigDecimal r3_rak, BigDecimal r3_fujairah,
			BigDecimal r3_uaq, BigDecimal r3_total, String r4_network_in_uae, BigDecimal r4_beginning_of_period,
			BigDecimal r4_opened_during_period, BigDecimal r4_closed_during_period, BigDecimal r4_end_of_period,
			BigDecimal r4_abudhabi, BigDecimal r4_dubai, BigDecimal r4_sharjah, BigDecimal r4_ajman, BigDecimal r4_rak,
			BigDecimal r4_fujairah, BigDecimal r4_uaq, BigDecimal r4_total, String r5_network_in_uae,
			BigDecimal r5_beginning_of_period, BigDecimal r5_opened_during_period, BigDecimal r5_closed_during_period,
			BigDecimal r5_end_of_period, BigDecimal r5_abudhabi, BigDecimal r5_dubai, BigDecimal r5_sharjah,
			BigDecimal r5_ajman, BigDecimal r5_rak, BigDecimal r5_fujairah, BigDecimal r5_uaq, BigDecimal r5_total,
			String r6_network_in_uae, BigDecimal r6_beginning_of_period, BigDecimal r6_opened_during_period,
			BigDecimal r6_closed_during_period, BigDecimal r6_end_of_period, BigDecimal r6_abudhabi,
			BigDecimal r6_dubai, BigDecimal r6_sharjah, BigDecimal r6_ajman, BigDecimal r6_rak, BigDecimal r6_fujairah,
			BigDecimal r6_uaq, BigDecimal r6_total, String r7_network_in_uae, BigDecimal r7_beginning_of_period,
			BigDecimal r7_opened_during_period, BigDecimal r7_closed_during_period, BigDecimal r7_end_of_period,
			BigDecimal r7_abudhabi, BigDecimal r7_dubai, BigDecimal r7_sharjah, BigDecimal r7_ajman, BigDecimal r7_rak,
			BigDecimal r7_fujairah, BigDecimal r7_uaq, BigDecimal r7_total, Date report_submit_date, Date report_date,
			Date report_from_date, Date report_to_date, String report_code, String entity_flg, String modify_flg,
			String del_flg, String entry_user, String modify_user, String verify_user, Date entry_time,
			Date modify_time, Date verify_time, BigDecimal srl_no) {
		super();
		this.r1_network_in_uae = r1_network_in_uae;
		this.r1_beginning_of_period = r1_beginning_of_period;
		this.r1_opened_during_period = r1_opened_during_period;
		this.r1_closed_during_period = r1_closed_during_period;
		this.r1_end_of_period = r1_end_of_period;
		this.r1_abudhabi = r1_abudhabi;
		this.r1_dubai = r1_dubai;
		this.r1_sharjah = r1_sharjah;
		this.r1_ajman = r1_ajman;
		this.r1_rak = r1_rak;
		this.r1_fujairah = r1_fujairah;
		this.r1_uaq = r1_uaq;
		this.r1_total = r1_total;
		this.r2_network_in_uae = r2_network_in_uae;
		this.r2_beginning_of_period = r2_beginning_of_period;
		this.r2_opened_during_period = r2_opened_during_period;
		this.r2_closed_during_period = r2_closed_during_period;
		this.r2_end_of_period = r2_end_of_period;
		this.r2_abudhabi = r2_abudhabi;
		this.r2_dubai = r2_dubai;
		this.r2_sharjah = r2_sharjah;
		this.r2_ajman = r2_ajman;
		this.r2_rak = r2_rak;
		this.r2_fujairah = r2_fujairah;
		this.r2_uaq = r2_uaq;
		this.r2_total = r2_total;
		this.r3_network_in_uae = r3_network_in_uae;
		this.r3_beginning_of_period = r3_beginning_of_period;
		this.r3_opened_during_period = r3_opened_during_period;
		this.r3_closed_during_period = r3_closed_during_period;
		this.r3_end_of_period = r3_end_of_period;
		this.r3_abudhabi = r3_abudhabi;
		this.r3_dubai = r3_dubai;
		this.r3_sharjah = r3_sharjah;
		this.r3_ajman = r3_ajman;
		this.r3_rak = r3_rak;
		this.r3_fujairah = r3_fujairah;
		this.r3_uaq = r3_uaq;
		this.r3_total = r3_total;
		this.r4_network_in_uae = r4_network_in_uae;
		this.r4_beginning_of_period = r4_beginning_of_period;
		this.r4_opened_during_period = r4_opened_during_period;
		this.r4_closed_during_period = r4_closed_during_period;
		this.r4_end_of_period = r4_end_of_period;
		this.r4_abudhabi = r4_abudhabi;
		this.r4_dubai = r4_dubai;
		this.r4_sharjah = r4_sharjah;
		this.r4_ajman = r4_ajman;
		this.r4_rak = r4_rak;
		this.r4_fujairah = r4_fujairah;
		this.r4_uaq = r4_uaq;
		this.r4_total = r4_total;
		this.r5_network_in_uae = r5_network_in_uae;
		this.r5_beginning_of_period = r5_beginning_of_period;
		this.r5_opened_during_period = r5_opened_during_period;
		this.r5_closed_during_period = r5_closed_during_period;
		this.r5_end_of_period = r5_end_of_period;
		this.r5_abudhabi = r5_abudhabi;
		this.r5_dubai = r5_dubai;
		this.r5_sharjah = r5_sharjah;
		this.r5_ajman = r5_ajman;
		this.r5_rak = r5_rak;
		this.r5_fujairah = r5_fujairah;
		this.r5_uaq = r5_uaq;
		this.r5_total = r5_total;
		this.r6_network_in_uae = r6_network_in_uae;
		this.r6_beginning_of_period = r6_beginning_of_period;
		this.r6_opened_during_period = r6_opened_during_period;
		this.r6_closed_during_period = r6_closed_during_period;
		this.r6_end_of_period = r6_end_of_period;
		this.r6_abudhabi = r6_abudhabi;
		this.r6_dubai = r6_dubai;
		this.r6_sharjah = r6_sharjah;
		this.r6_ajman = r6_ajman;
		this.r6_rak = r6_rak;
		this.r6_fujairah = r6_fujairah;
		this.r6_uaq = r6_uaq;
		this.r6_total = r6_total;
		this.r7_network_in_uae = r7_network_in_uae;
		this.r7_beginning_of_period = r7_beginning_of_period;
		this.r7_opened_during_period = r7_opened_during_period;
		this.r7_closed_during_period = r7_closed_during_period;
		this.r7_end_of_period = r7_end_of_period;
		this.r7_abudhabi = r7_abudhabi;
		this.r7_dubai = r7_dubai;
		this.r7_sharjah = r7_sharjah;
		this.r7_ajman = r7_ajman;
		this.r7_rak = r7_rak;
		this.r7_fujairah = r7_fujairah;
		this.r7_uaq = r7_uaq;
		this.r7_total = r7_total;
		this.report_submit_date = report_submit_date;
		this.report_date = report_date;
		this.report_from_date = report_from_date;
		this.report_to_date = report_to_date;
		this.report_code = report_code;
		this.entity_flg = entity_flg;
		this.modify_flg = modify_flg;
		this.del_flg = del_flg;
		this.entry_user = entry_user;
		this.modify_user = modify_user;
		this.verify_user = verify_user;
		this.entry_time = entry_time;
		this.modify_time = modify_time;
		this.verify_time = verify_time;
		this.srl_no = srl_no;
	}

	@Override
	public String toString() {
		return "BRF201_SUMMARY_ENTITY_A [r1_network_in_uae=" + r1_network_in_uae + ", r1_beginning_of_period="
				+ r1_beginning_of_period + ", r1_opened_during_period=" + r1_opened_during_period
				+ ", r1_closed_during_period=" + r1_closed_during_period + ", r1_end_of_period=" + r1_end_of_period
				+ ", r1_abudhabi=" + r1_abudhabi + ", r1_dubai=" + r1_dubai + ", r1_sharjah=" + r1_sharjah
				+ ", r1_ajman=" + r1_ajman + ", r1_rak=" + r1_rak + ", r1_fujairah=" + r1_fujairah + ", r1_uaq="
				+ r1_uaq + ", r1_total=" + r1_total + ", r2_network_in_uae=" + r2_network_in_uae
				+ ", r2_beginning_of_period=" + r2_beginning_of_period + ", r2_opened_during_period="
				+ r2_opened_during_period + ", r2_closed_during_period=" + r2_closed_during_period
				+ ", r2_end_of_period=" + r2_end_of_period + ", r2_abudhabi=" + r2_abudhabi + ", r2_dubai=" + r2_dubai
				+ ", r2_sharjah=" + r2_sharjah + ", r2_ajman=" + r2_ajman + ", r2_rak=" + r2_rak + ", r2_fujairah="
				+ r2_fujairah + ", r2_uaq=" + r2_uaq + ", r2_total=" + r2_total + ", r3_network_in_uae="
				+ r3_network_in_uae + ", r3_beginning_of_period=" + r3_beginning_of_period
				+ ", r3_opened_during_period=" + r3_opened_during_period + ", r3_closed_during_period="
				+ r3_closed_during_period + ", r3_end_of_period=" + r3_end_of_period + ", r3_abudhabi=" + r3_abudhabi
				+ ", r3_dubai=" + r3_dubai + ", r3_sharjah=" + r3_sharjah + ", r3_ajman=" + r3_ajman + ", r3_rak="
				+ r3_rak + ", r3_fujairah=" + r3_fujairah + ", r3_uaq=" + r3_uaq + ", r3_total=" + r3_total
				+ ", r4_network_in_uae=" + r4_network_in_uae + ", r4_beginning_of_period=" + r4_beginning_of_period
				+ ", r4_opened_during_period=" + r4_opened_during_period + ", r4_closed_during_period="
				+ r4_closed_during_period + ", r4_end_of_period=" + r4_end_of_period + ", r4_abudhabi=" + r4_abudhabi
				+ ", r4_dubai=" + r4_dubai + ", r4_sharjah=" + r4_sharjah + ", r4_ajman=" + r4_ajman + ", r4_rak="
				+ r4_rak + ", r4_fujairah=" + r4_fujairah + ", r4_uaq=" + r4_uaq + ", r4_total=" + r4_total
				+ ", r5_network_in_uae=" + r5_network_in_uae + ", r5_beginning_of_period=" + r5_beginning_of_period
				+ ", r5_opened_during_period=" + r5_opened_during_period + ", r5_closed_during_period="
				+ r5_closed_during_period + ", r5_end_of_period=" + r5_end_of_period + ", r5_abudhabi=" + r5_abudhabi
				+ ", r5_dubai=" + r5_dubai + ", r5_sharjah=" + r5_sharjah + ", r5_ajman=" + r5_ajman + ", r5_rak="
				+ r5_rak + ", r5_fujairah=" + r5_fujairah + ", r5_uaq=" + r5_uaq + ", r5_total=" + r5_total
				+ ", r6_network_in_uae=" + r6_network_in_uae + ", r6_beginning_of_period=" + r6_beginning_of_period
				+ ", r6_opened_during_period=" + r6_opened_during_period + ", r6_closed_during_period="
				+ r6_closed_during_period + ", r6_end_of_period=" + r6_end_of_period + ", r6_abudhabi=" + r6_abudhabi
				+ ", r6_dubai=" + r6_dubai + ", r6_sharjah=" + r6_sharjah + ", r6_ajman=" + r6_ajman + ", r6_rak="
				+ r6_rak + ", r6_fujairah=" + r6_fujairah + ", r6_uaq=" + r6_uaq + ", r6_total=" + r6_total
				+ ", r7_network_in_uae=" + r7_network_in_uae + ", r7_beginning_of_period=" + r7_beginning_of_period
				+ ", r7_opened_during_period=" + r7_opened_during_period + ", r7_closed_during_period="
				+ r7_closed_during_period + ", r7_end_of_period=" + r7_end_of_period + ", r7_abudhabi=" + r7_abudhabi
				+ ", r7_dubai=" + r7_dubai + ", r7_sharjah=" + r7_sharjah + ", r7_ajman=" + r7_ajman + ", r7_rak="
				+ r7_rak + ", r7_fujairah=" + r7_fujairah + ", r7_uaq=" + r7_uaq + ", r7_total=" + r7_total
				+ ", report_submit_date=" + report_submit_date + ", report_date=" + report_date + ", report_from_date="
				+ report_from_date + ", report_to_date=" + report_to_date + ", report_code=" + report_code
				+ ", entity_flg=" + entity_flg + ", modify_flg=" + modify_flg + ", del_flg=" + del_flg + ", entry_user="
				+ entry_user + ", modify_user=" + modify_user + ", verify_user=" + verify_user + ", entry_time="
				+ entry_time + ", modify_time=" + modify_time + ", verify_time=" + verify_time + ", srl_no=" + srl_no
				+ ", getR1_network_in_uae()=" + getR1_network_in_uae() + ", getR1_beginning_of_period()="
				+ getR1_beginning_of_period() + ", getR1_opened_during_period()=" + getR1_opened_during_period()
				+ ", getR1_closed_during_period()=" + getR1_closed_during_period() + ", getR1_end_of_period()="
				+ getR1_end_of_period() + ", getR1_abudhabi()=" + getR1_abudhabi() + ", getR1_dubai()=" + getR1_dubai()
				+ ", getR1_sharjah()=" + getR1_sharjah() + ", getR1_ajman()=" + getR1_ajman() + ", getR1_rak()="
				+ getR1_rak() + ", getR1_fujairah()=" + getR1_fujairah() + ", getR1_uaq()=" + getR1_uaq()
				+ ", getR1_total()=" + getR1_total() + ", getR2_network_in_uae()=" + getR2_network_in_uae()
				+ ", getR2_beginning_of_period()=" + getR2_beginning_of_period() + ", getR2_opened_during_period()="
				+ getR2_opened_during_period() + ", getR2_closed_during_period()=" + getR2_closed_during_period()
				+ ", getR2_end_of_period()=" + getR2_end_of_period() + ", getR2_abudhabi()=" + getR2_abudhabi()
				+ ", getR2_dubai()=" + getR2_dubai() + ", getR2_sharjah()=" + getR2_sharjah() + ", getR2_ajman()="
				+ getR2_ajman() + ", getR2_rak()=" + getR2_rak() + ", getR2_fujairah()=" + getR2_fujairah()
				+ ", getR2_uaq()=" + getR2_uaq() + ", getR2_total()=" + getR2_total() + ", getR3_network_in_uae()="
				+ getR3_network_in_uae() + ", getR3_beginning_of_period()=" + getR3_beginning_of_period()
				+ ", getR3_opened_during_period()=" + getR3_opened_during_period() + ", getR3_closed_during_period()="
				+ getR3_closed_during_period() + ", getR3_end_of_period()=" + getR3_end_of_period()
				+ ", getR3_abudhabi()=" + getR3_abudhabi() + ", getR3_dubai()=" + getR3_dubai() + ", getR3_sharjah()="
				+ getR3_sharjah() + ", getR3_ajman()=" + getR3_ajman() + ", getR3_rak()=" + getR3_rak()
				+ ", getR3_fujairah()=" + getR3_fujairah() + ", getR3_uaq()=" + getR3_uaq() + ", getR3_total()="
				+ getR3_total() + ", getR4_network_in_uae()=" + getR4_network_in_uae()
				+ ", getR4_beginning_of_period()=" + getR4_beginning_of_period() + ", getR4_opened_during_period()="
				+ getR4_opened_during_period() + ", getR4_closed_during_period()=" + getR4_closed_during_period()
				+ ", getR4_end_of_period()=" + getR4_end_of_period() + ", getR4_abudhabi()=" + getR4_abudhabi()
				+ ", getR4_dubai()=" + getR4_dubai() + ", getR4_sharjah()=" + getR4_sharjah() + ", getR4_ajman()="
				+ getR4_ajman() + ", getR4_rak()=" + getR4_rak() + ", getR4_fujairah()=" + getR4_fujairah()
				+ ", getR4_uaq()=" + getR4_uaq() + ", getR4_total()=" + getR4_total() + ", getR5_network_in_uae()="
				+ getR5_network_in_uae() + ", getR5_beginning_of_period()=" + getR5_beginning_of_period()
				+ ", getR5_opened_during_period()=" + getR5_opened_during_period() + ", getR5_closed_during_period()="
				+ getR5_closed_during_period() + ", getR5_end_of_period()=" + getR5_end_of_period()
				+ ", getR5_abudhabi()=" + getR5_abudhabi() + ", getR5_dubai()=" + getR5_dubai() + ", getR5_sharjah()="
				+ getR5_sharjah() + ", getR5_ajman()=" + getR5_ajman() + ", getR5_rak()=" + getR5_rak()
				+ ", getR5_fujairah()=" + getR5_fujairah() + ", getR5_uaq()=" + getR5_uaq() + ", getR5_total()="
				+ getR5_total() + ", getR6_network_in_uae()=" + getR6_network_in_uae()
				+ ", getR6_beginning_of_period()=" + getR6_beginning_of_period() + ", getR6_opened_during_period()="
				+ getR6_opened_during_period() + ", getR6_closed_during_period()=" + getR6_closed_during_period()
				+ ", getR6_end_of_period()=" + getR6_end_of_period() + ", getR6_abudhabi()=" + getR6_abudhabi()
				+ ", getR6_dubai()=" + getR6_dubai() + ", getR6_sharjah()=" + getR6_sharjah() + ", getR6_ajman()="
				+ getR6_ajman() + ", getR6_rak()=" + getR6_rak() + ", getR6_fujairah()=" + getR6_fujairah()
				+ ", getR6_uaq()=" + getR6_uaq() + ", getR6_total()=" + getR6_total() + ", getR7_network_in_uae()="
				+ getR7_network_in_uae() + ", getR7_beginning_of_period()=" + getR7_beginning_of_period()
				+ ", getR7_opened_during_period()=" + getR7_opened_during_period() + ", getR7_closed_during_period()="
				+ getR7_closed_during_period() + ", getR7_end_of_period()=" + getR7_end_of_period()
				+ ", getR7_abudhabi()=" + getR7_abudhabi() + ", getR7_dubai()=" + getR7_dubai() + ", getR7_sharjah()="
				+ getR7_sharjah() + ", getR7_ajman()=" + getR7_ajman() + ", getR7_rak()=" + getR7_rak()
				+ ", getR7_fujairah()=" + getR7_fujairah() + ", getR7_uaq()=" + getR7_uaq() + ", getR7_total()="
				+ getR7_total() + ", getReport_submit_date()=" + getReport_submit_date() + ", getReport_date()="
				+ getReport_date() + ", getReport_from_date()=" + getReport_from_date() + ", getReport_to_date()="
				+ getReport_to_date() + ", getReport_code()=" + getReport_code() + ", getEntity_flg()="
				+ getEntity_flg() + ", getModify_flg()=" + getModify_flg() + ", getDel_flg()=" + getDel_flg()
				+ ", getEntry_user()=" + getEntry_user() + ", getModify_user()=" + getModify_user()
				+ ", getVerify_user()=" + getVerify_user() + ", getEntry_time()=" + getEntry_time()
				+ ", getModify_time()=" + getModify_time() + ", getVerify_time()=" + getVerify_time() + ", getSrl_no()="
				+ getSrl_no() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}

	public BRF201_SUMMARY_ENTITY_A() {
		super();
		// TODO Auto-generated constructor stub
	}
}