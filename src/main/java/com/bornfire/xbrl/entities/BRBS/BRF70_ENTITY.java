package com.bornfire.xbrl.entities.BRBS;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="BRF70_SUMMARYTABLE")
public class BRF70_ENTITY {
	private String	R1_S_NO;
	private String	R1_CATEGORY;
	private BigDecimal	R1_COL_1;
	private BigDecimal	R1_COL_2;
	private BigDecimal	R1_COL_3;
	private BigDecimal	R1_COL_4;
	private BigDecimal	R1_COL_5;
	private BigDecimal	R1_COL_6;
	private BigDecimal	R1_COL_7;
	private BigDecimal	R1_COL_8;
	private BigDecimal	R1_COL_9;
	private BigDecimal	R1_COL_10;
	private BigDecimal	R1_COL_11;
	private BigDecimal	R1_COL_12;
	private BigDecimal	R1_COL_13;
	private BigDecimal	R1_COL_14;
	private String	R2_S_NO;
	private String	R2_CATEGORY;
	private BigDecimal	R2_COL_1;
	private BigDecimal	R2_COL_2;
	private BigDecimal	R2_COL_3;
	private BigDecimal	R2_COL_4;
	private BigDecimal	R2_COL_5;
	private BigDecimal	R2_COL_6;
	private BigDecimal	R2_COL_7;
	private BigDecimal	R2_COL_8;
	private BigDecimal	R2_COL_9;
	private BigDecimal	R2_COL_10;
	private BigDecimal	R2_COL_11;
	private BigDecimal	R2_COL_12;
	private BigDecimal	R2_COL_13;
	private BigDecimal	R2_COL_14;
	private String	R3_S_NO;
	private String	R3_CATEGORY;
	private BigDecimal	R3_COL_1;
	private BigDecimal	R3_COL_2;
	private BigDecimal	R3_COL_3;
	private BigDecimal	R3_COL_4;
	private BigDecimal	R3_COL_5;
	private BigDecimal	R3_COL_6;
	private BigDecimal	R3_COL_7;
	private BigDecimal	R3_COL_8;
	private BigDecimal	R3_COL_9;
	private BigDecimal	R3_COL_10;
	private BigDecimal	R3_COL_11;
	private BigDecimal	R3_COL_12;
	private BigDecimal	R3_COL_13;
	private BigDecimal	R3_COL_14;
	private String	R4_S_NO;
	private String	R4_CATEGORY;
	private BigDecimal	R4_COL_1;
	private BigDecimal	R4_COL_2;
	private BigDecimal	R4_COL_3;
	private BigDecimal	R4_COL_4;
	private BigDecimal	R4_COL_5;
	private BigDecimal	R4_COL_6;
	private BigDecimal	R4_COL_7;
	private BigDecimal	R4_COL_8;
	private BigDecimal	R4_COL_9;
	private BigDecimal	R4_COL_10;
	private BigDecimal	R4_COL_11;
	private BigDecimal	R4_COL_12;
	private BigDecimal	R4_COL_13;
	private BigDecimal	R4_COL_14;
	private String	R5_S_NO;
	private String	R5_CATEGORY;
	private BigDecimal	R5_COL_1;
	private BigDecimal	R5_COL_2;
	private BigDecimal	R5_COL_3;
	private BigDecimal	R5_COL_4;
	private BigDecimal	R5_COL_5;
	private BigDecimal	R5_COL_6;
	private BigDecimal	R5_COL_7;
	private BigDecimal	R5_COL_8;
	private BigDecimal	R5_COL_9;
	private BigDecimal	R5_COL_10;
	private BigDecimal	R5_COL_11;
	private BigDecimal	R5_COL_12;
	private BigDecimal	R5_COL_13;
	private BigDecimal	R5_COL_14;
	private String	R6_S_NO;
	private String	R6_CATEGORY;
	private BigDecimal	R6_COL_1;
	private BigDecimal	R6_COL_2;
	private BigDecimal	R6_COL_3;
	private BigDecimal	R6_COL_4;
	private BigDecimal	R6_COL_5;
	private BigDecimal	R6_COL_6;
	private BigDecimal	R6_COL_7;
	private BigDecimal	R6_COL_8;
	private BigDecimal	R6_COL_9;
	private BigDecimal	R6_COL_10;
	private BigDecimal	R6_COL_11;
	private BigDecimal	R6_COL_12;
	private BigDecimal	R6_COL_13;
	private BigDecimal	R6_COL_14;
	private String	R7_S_NO;
	private String	R7_CATEGORY;
	private BigDecimal	R7_COL_1;
	private BigDecimal	R7_COL_2;
	private BigDecimal	R7_COL_3;
	private BigDecimal	R7_COL_4;
	private BigDecimal	R7_COL_5;
	private BigDecimal	R7_COL_6;
	private BigDecimal	R7_COL_7;
	private BigDecimal	R7_COL_8;
	private BigDecimal	R7_COL_9;
	private BigDecimal	R7_COL_10;
	private BigDecimal	R7_COL_11;
	private BigDecimal	R7_COL_12;
	private BigDecimal	R7_COL_13;
	private BigDecimal	R7_COL_14;
	private String	R8_S_NO;
	private String	R8_CATEGORY;
	private BigDecimal	R8_COL_1;
	private BigDecimal	R8_COL_2;
	private BigDecimal	R8_COL_3;
	private BigDecimal	R8_COL_4;
	private BigDecimal	R8_COL_5;
	private BigDecimal	R8_COL_6;
	private String	R9_S_NO;
	private String	R9_CATEGORY;
	private BigDecimal	R9_COL_1;
	private BigDecimal	R9_COL_2;
	private BigDecimal	R9_COL_3;
	private BigDecimal	R9_COL_4;
	private BigDecimal	R9_COL_5;
	private BigDecimal	R9_COL_6;
	private String	R10_S_NO;
	private String	R10_CATEGORY;
	private BigDecimal	R10_COL_1;
	private BigDecimal	R10_COL_2;
	private BigDecimal	R10_COL_3;
	private BigDecimal	R10_COL_4;
	private BigDecimal	R10_COL_5;
	private BigDecimal	R10_COL_6;
	private String	R11_S_NO;
	private String	R11_CATEGORY;
	private BigDecimal	R11_COL_1;
	private BigDecimal	R11_COL_2;
	private BigDecimal	R11_COL_3;
	private BigDecimal	R11_COL_4;
	private BigDecimal	R11_COL_5;
	private BigDecimal	R11_COL_6;
	private String	R12_S_NO;
	private String	R12_CATEGORY;
	private BigDecimal	R12_COL_1;
	private BigDecimal	R12_COL_2;
	private BigDecimal	R12_COL_3;
	private BigDecimal	R12_COL_4;
	private BigDecimal	R12_COL_5;
	private BigDecimal	R12_COL_6;
	private String	R13_S_NO;
	private String	R13_CATEGORY;
	private BigDecimal	R13_COL_1;
	private BigDecimal	R13_COL_2;
	private BigDecimal	R13_COL_3;
	private BigDecimal	R13_COL_4;
	private BigDecimal	R13_COL_5;
	private BigDecimal	R13_COL_6;
	private String	R14_S_NO;
	private String	R14_CATEGORY;
	private BigDecimal	R14_COL_1;
	private BigDecimal	R14_COL_2;
	private BigDecimal	R14_COL_3;
	private BigDecimal	R14_COL_4;
	private BigDecimal	R14_COL_5;
	private BigDecimal	R14_COL_6;

	@Id
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date	report_date;
	private Date	report_from_date;
	private Date	report_to_date;
	private String	entity_flg;
	private String	modify_flg;
	private String	del_flg;
	private String	report_code;
	private Date	report_submit_date;
	private String	entry_user;
	private String	modify_user;
	private String	verify_user;
	private Date	entry_time;
	private Date	modify_time;
	private Date	verify_time;
	private String	repdesc;
	private String	frequency;
	
	public String getRepdesc() {
		return repdesc;
	}
	public void setRepdesc(String repdesc) {
		this.repdesc = repdesc;
	}
	public String getFrequency() {
		return frequency;
	}
	public void setFrequency(String frequency) {
		this.frequency = frequency;
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
	public String getR1_S_NO() {
		return R1_S_NO;
	}
	public void setR1_S_NO(String r1_S_NO) {
		R1_S_NO = r1_S_NO;
	}
	public String getR1_CATEGORY() {
		return R1_CATEGORY;
	}
	public void setR1_CATEGORY(String r1_CATEGORY) {
		R1_CATEGORY = r1_CATEGORY;
	}
	public BigDecimal getR1_COL_1() {
		return R1_COL_1;
	}
	public void setR1_COL_1(BigDecimal r1_COL_1) {
		R1_COL_1 = r1_COL_1;
	}
	public BigDecimal getR1_COL_2() {
		return R1_COL_2;
	}
	public void setR1_COL_2(BigDecimal r1_COL_2) {
		R1_COL_2 = r1_COL_2;
	}
	public BigDecimal getR1_COL_3() {
		return R1_COL_3;
	}
	public void setR1_COL_3(BigDecimal r1_COL_3) {
		R1_COL_3 = r1_COL_3;
	}
	public BigDecimal getR1_COL_4() {
		return R1_COL_4;
	}
	public void setR1_COL_4(BigDecimal r1_COL_4) {
		R1_COL_4 = r1_COL_4;
	}
	public BigDecimal getR1_COL_5() {
		return R1_COL_5;
	}
	public void setR1_COL_5(BigDecimal r1_COL_5) {
		R1_COL_5 = r1_COL_5;
	}
	public BigDecimal getR1_COL_6() {
		return R1_COL_6;
	}
	public void setR1_COL_6(BigDecimal r1_COL_6) {
		R1_COL_6 = r1_COL_6;
	}
	public BigDecimal getR1_COL_7() {
		return R1_COL_7;
	}
	public void setR1_COL_7(BigDecimal r1_COL_7) {
		R1_COL_7 = r1_COL_7;
	}
	public BigDecimal getR1_COL_8() {
		return R1_COL_8;
	}
	public void setR1_COL_8(BigDecimal r1_COL_8) {
		R1_COL_8 = r1_COL_8;
	}
	public BigDecimal getR1_COL_9() {
		return R1_COL_9;
	}
	public void setR1_COL_9(BigDecimal r1_COL_9) {
		R1_COL_9 = r1_COL_9;
	}
	public BigDecimal getR1_COL_10() {
		return R1_COL_10;
	}
	public void setR1_COL_10(BigDecimal r1_COL_10) {
		R1_COL_10 = r1_COL_10;
	}
	public BigDecimal getR1_COL_11() {
		return R1_COL_11;
	}
	public void setR1_COL_11(BigDecimal r1_COL_11) {
		R1_COL_11 = r1_COL_11;
	}
	public BigDecimal getR1_COL_12() {
		return R1_COL_12;
	}
	public void setR1_COL_12(BigDecimal r1_COL_12) {
		R1_COL_12 = r1_COL_12;
	}
	public BigDecimal getR1_COL_13() {
		return R1_COL_13;
	}
	public void setR1_COL_13(BigDecimal r1_COL_13) {
		R1_COL_13 = r1_COL_13;
	}
	public BigDecimal getR1_COL_14() {
		return R1_COL_14;
	}
	public void setR1_COL_14(BigDecimal r1_COL_14) {
		R1_COL_14 = r1_COL_14;
	}
	public String getR2_S_NO() {
		return R2_S_NO;
	}
	public void setR2_S_NO(String r2_S_NO) {
		R2_S_NO = r2_S_NO;
	}
	public String getR2_CATEGORY() {
		return R2_CATEGORY;
	}
	public void setR2_CATEGORY(String r2_CATEGORY) {
		R2_CATEGORY = r2_CATEGORY;
	}
	public BigDecimal getR2_COL_1() {
		return R2_COL_1;
	}
	public void setR2_COL_1(BigDecimal r2_COL_1) {
		R2_COL_1 = r2_COL_1;
	}
	public BigDecimal getR2_COL_2() {
		return R2_COL_2;
	}
	public void setR2_COL_2(BigDecimal r2_COL_2) {
		R2_COL_2 = r2_COL_2;
	}
	public BigDecimal getR2_COL_3() {
		return R2_COL_3;
	}
	public void setR2_COL_3(BigDecimal r2_COL_3) {
		R2_COL_3 = r2_COL_3;
	}
	public BigDecimal getR2_COL_4() {
		return R2_COL_4;
	}
	public void setR2_COL_4(BigDecimal r2_COL_4) {
		R2_COL_4 = r2_COL_4;
	}
	public BigDecimal getR2_COL_5() {
		return R2_COL_5;
	}
	public void setR2_COL_5(BigDecimal r2_COL_5) {
		R2_COL_5 = r2_COL_5;
	}
	public BigDecimal getR2_COL_6() {
		return R2_COL_6;
	}
	public void setR2_COL_6(BigDecimal r2_COL_6) {
		R2_COL_6 = r2_COL_6;
	}
	public BigDecimal getR2_COL_7() {
		return R2_COL_7;
	}
	public void setR2_COL_7(BigDecimal r2_COL_7) {
		R2_COL_7 = r2_COL_7;
	}
	public BigDecimal getR2_COL_8() {
		return R2_COL_8;
	}
	public void setR2_COL_8(BigDecimal r2_COL_8) {
		R2_COL_8 = r2_COL_8;
	}
	public BigDecimal getR2_COL_9() {
		return R2_COL_9;
	}
	public void setR2_COL_9(BigDecimal r2_COL_9) {
		R2_COL_9 = r2_COL_9;
	}
	public BigDecimal getR2_COL_10() {
		return R2_COL_10;
	}
	public void setR2_COL_10(BigDecimal r2_COL_10) {
		R2_COL_10 = r2_COL_10;
	}
	public BigDecimal getR2_COL_11() {
		return R2_COL_11;
	}
	public void setR2_COL_11(BigDecimal r2_COL_11) {
		R2_COL_11 = r2_COL_11;
	}
	public BigDecimal getR2_COL_12() {
		return R2_COL_12;
	}
	public void setR2_COL_12(BigDecimal r2_COL_12) {
		R2_COL_12 = r2_COL_12;
	}
	public BigDecimal getR2_COL_13() {
		return R2_COL_13;
	}
	public void setR2_COL_13(BigDecimal r2_COL_13) {
		R2_COL_13 = r2_COL_13;
	}
	public BigDecimal getR2_COL_14() {
		return R2_COL_14;
	}
	public void setR2_COL_14(BigDecimal r2_COL_14) {
		R2_COL_14 = r2_COL_14;
	}
	public String getR3_S_NO() {
		return R3_S_NO;
	}
	public void setR3_S_NO(String r3_S_NO) {
		R3_S_NO = r3_S_NO;
	}
	public String getR3_CATEGORY() {
		return R3_CATEGORY;
	}
	public void setR3_CATEGORY(String r3_CATEGORY) {
		R3_CATEGORY = r3_CATEGORY;
	}
	public BigDecimal getR3_COL_1() {
		return R3_COL_1;
	}
	public void setR3_COL_1(BigDecimal r3_COL_1) {
		R3_COL_1 = r3_COL_1;
	}
	public BigDecimal getR3_COL_2() {
		return R3_COL_2;
	}
	public void setR3_COL_2(BigDecimal r3_COL_2) {
		R3_COL_2 = r3_COL_2;
	}
	public BigDecimal getR3_COL_3() {
		return R3_COL_3;
	}
	public void setR3_COL_3(BigDecimal r3_COL_3) {
		R3_COL_3 = r3_COL_3;
	}
	public BigDecimal getR3_COL_4() {
		return R3_COL_4;
	}
	public void setR3_COL_4(BigDecimal r3_COL_4) {
		R3_COL_4 = r3_COL_4;
	}
	public BigDecimal getR3_COL_5() {
		return R3_COL_5;
	}
	public void setR3_COL_5(BigDecimal r3_COL_5) {
		R3_COL_5 = r3_COL_5;
	}
	public BigDecimal getR3_COL_6() {
		return R3_COL_6;
	}
	public void setR3_COL_6(BigDecimal r3_COL_6) {
		R3_COL_6 = r3_COL_6;
	}
	public BigDecimal getR3_COL_7() {
		return R3_COL_7;
	}
	public void setR3_COL_7(BigDecimal r3_COL_7) {
		R3_COL_7 = r3_COL_7;
	}
	public BigDecimal getR3_COL_8() {
		return R3_COL_8;
	}
	public void setR3_COL_8(BigDecimal r3_COL_8) {
		R3_COL_8 = r3_COL_8;
	}
	public BigDecimal getR3_COL_9() {
		return R3_COL_9;
	}
	public void setR3_COL_9(BigDecimal r3_COL_9) {
		R3_COL_9 = r3_COL_9;
	}
	public BigDecimal getR3_COL_10() {
		return R3_COL_10;
	}
	public void setR3_COL_10(BigDecimal r3_COL_10) {
		R3_COL_10 = r3_COL_10;
	}
	public BigDecimal getR3_COL_11() {
		return R3_COL_11;
	}
	public void setR3_COL_11(BigDecimal r3_COL_11) {
		R3_COL_11 = r3_COL_11;
	}
	public BigDecimal getR3_COL_12() {
		return R3_COL_12;
	}
	public void setR3_COL_12(BigDecimal r3_COL_12) {
		R3_COL_12 = r3_COL_12;
	}
	public BigDecimal getR3_COL_13() {
		return R3_COL_13;
	}
	public void setR3_COL_13(BigDecimal r3_COL_13) {
		R3_COL_13 = r3_COL_13;
	}
	public BigDecimal getR3_COL_14() {
		return R3_COL_14;
	}
	public void setR3_COL_14(BigDecimal r3_COL_14) {
		R3_COL_14 = r3_COL_14;
	}
	public String getR4_S_NO() {
		return R4_S_NO;
	}
	public void setR4_S_NO(String r4_S_NO) {
		R4_S_NO = r4_S_NO;
	}
	public String getR4_CATEGORY() {
		return R4_CATEGORY;
	}
	public void setR4_CATEGORY(String r4_CATEGORY) {
		R4_CATEGORY = r4_CATEGORY;
	}
	public BigDecimal getR4_COL_1() {
		return R4_COL_1;
	}
	public void setR4_COL_1(BigDecimal r4_COL_1) {
		R4_COL_1 = r4_COL_1;
	}
	public BigDecimal getR4_COL_2() {
		return R4_COL_2;
	}
	public void setR4_COL_2(BigDecimal r4_COL_2) {
		R4_COL_2 = r4_COL_2;
	}
	public BigDecimal getR4_COL_3() {
		return R4_COL_3;
	}
	public void setR4_COL_3(BigDecimal r4_COL_3) {
		R4_COL_3 = r4_COL_3;
	}
	public BigDecimal getR4_COL_4() {
		return R4_COL_4;
	}
	public void setR4_COL_4(BigDecimal r4_COL_4) {
		R4_COL_4 = r4_COL_4;
	}
	public BigDecimal getR4_COL_5() {
		return R4_COL_5;
	}
	public void setR4_COL_5(BigDecimal r4_COL_5) {
		R4_COL_5 = r4_COL_5;
	}
	public BigDecimal getR4_COL_6() {
		return R4_COL_6;
	}
	public void setR4_COL_6(BigDecimal r4_COL_6) {
		R4_COL_6 = r4_COL_6;
	}
	public BigDecimal getR4_COL_7() {
		return R4_COL_7;
	}
	public void setR4_COL_7(BigDecimal r4_COL_7) {
		R4_COL_7 = r4_COL_7;
	}
	public BigDecimal getR4_COL_8() {
		return R4_COL_8;
	}
	public void setR4_COL_8(BigDecimal r4_COL_8) {
		R4_COL_8 = r4_COL_8;
	}
	public BigDecimal getR4_COL_9() {
		return R4_COL_9;
	}
	public void setR4_COL_9(BigDecimal r4_COL_9) {
		R4_COL_9 = r4_COL_9;
	}
	public BigDecimal getR4_COL_10() {
		return R4_COL_10;
	}
	public void setR4_COL_10(BigDecimal r4_COL_10) {
		R4_COL_10 = r4_COL_10;
	}
	public BigDecimal getR4_COL_11() {
		return R4_COL_11;
	}
	public void setR4_COL_11(BigDecimal r4_COL_11) {
		R4_COL_11 = r4_COL_11;
	}
	public BigDecimal getR4_COL_12() {
		return R4_COL_12;
	}
	public void setR4_COL_12(BigDecimal r4_COL_12) {
		R4_COL_12 = r4_COL_12;
	}
	public BigDecimal getR4_COL_13() {
		return R4_COL_13;
	}
	public void setR4_COL_13(BigDecimal r4_COL_13) {
		R4_COL_13 = r4_COL_13;
	}
	public BigDecimal getR4_COL_14() {
		return R4_COL_14;
	}
	public void setR4_COL_14(BigDecimal r4_COL_14) {
		R4_COL_14 = r4_COL_14;
	}
	public String getR5_S_NO() {
		return R5_S_NO;
	}
	public void setR5_S_NO(String r5_S_NO) {
		R5_S_NO = r5_S_NO;
	}
	public String getR5_CATEGORY() {
		return R5_CATEGORY;
	}
	public void setR5_CATEGORY(String r5_CATEGORY) {
		R5_CATEGORY = r5_CATEGORY;
	}
	public BigDecimal getR5_COL_1() {
		return R5_COL_1;
	}
	public void setR5_COL_1(BigDecimal r5_COL_1) {
		R5_COL_1 = r5_COL_1;
	}
	public BigDecimal getR5_COL_2() {
		return R5_COL_2;
	}
	public void setR5_COL_2(BigDecimal r5_COL_2) {
		R5_COL_2 = r5_COL_2;
	}
	public BigDecimal getR5_COL_3() {
		return R5_COL_3;
	}
	public void setR5_COL_3(BigDecimal r5_COL_3) {
		R5_COL_3 = r5_COL_3;
	}
	public BigDecimal getR5_COL_4() {
		return R5_COL_4;
	}
	public void setR5_COL_4(BigDecimal r5_COL_4) {
		R5_COL_4 = r5_COL_4;
	}
	public BigDecimal getR5_COL_5() {
		return R5_COL_5;
	}
	public void setR5_COL_5(BigDecimal r5_COL_5) {
		R5_COL_5 = r5_COL_5;
	}
	public BigDecimal getR5_COL_6() {
		return R5_COL_6;
	}
	public void setR5_COL_6(BigDecimal r5_COL_6) {
		R5_COL_6 = r5_COL_6;
	}
	public BigDecimal getR5_COL_7() {
		return R5_COL_7;
	}
	public void setR5_COL_7(BigDecimal r5_COL_7) {
		R5_COL_7 = r5_COL_7;
	}
	public BigDecimal getR5_COL_8() {
		return R5_COL_8;
	}
	public void setR5_COL_8(BigDecimal r5_COL_8) {
		R5_COL_8 = r5_COL_8;
	}
	public BigDecimal getR5_COL_9() {
		return R5_COL_9;
	}
	public void setR5_COL_9(BigDecimal r5_COL_9) {
		R5_COL_9 = r5_COL_9;
	}
	public BigDecimal getR5_COL_10() {
		return R5_COL_10;
	}
	public void setR5_COL_10(BigDecimal r5_COL_10) {
		R5_COL_10 = r5_COL_10;
	}
	public BigDecimal getR5_COL_11() {
		return R5_COL_11;
	}
	public void setR5_COL_11(BigDecimal r5_COL_11) {
		R5_COL_11 = r5_COL_11;
	}
	public BigDecimal getR5_COL_12() {
		return R5_COL_12;
	}
	public void setR5_COL_12(BigDecimal r5_COL_12) {
		R5_COL_12 = r5_COL_12;
	}
	public BigDecimal getR5_COL_13() {
		return R5_COL_13;
	}
	public void setR5_COL_13(BigDecimal r5_COL_13) {
		R5_COL_13 = r5_COL_13;
	}
	public BigDecimal getR5_COL_14() {
		return R5_COL_14;
	}
	public void setR5_COL_14(BigDecimal r5_COL_14) {
		R5_COL_14 = r5_COL_14;
	}
	public String getR6_S_NO() {
		return R6_S_NO;
	}
	public void setR6_S_NO(String r6_S_NO) {
		R6_S_NO = r6_S_NO;
	}
	public String getR6_CATEGORY() {
		return R6_CATEGORY;
	}
	public void setR6_CATEGORY(String r6_CATEGORY) {
		R6_CATEGORY = r6_CATEGORY;
	}
	public BigDecimal getR6_COL_1() {
		return R6_COL_1;
	}
	public void setR6_COL_1(BigDecimal r6_COL_1) {
		R6_COL_1 = r6_COL_1;
	}
	public BigDecimal getR6_COL_2() {
		return R6_COL_2;
	}
	public void setR6_COL_2(BigDecimal r6_COL_2) {
		R6_COL_2 = r6_COL_2;
	}
	public BigDecimal getR6_COL_3() {
		return R6_COL_3;
	}
	public void setR6_COL_3(BigDecimal r6_COL_3) {
		R6_COL_3 = r6_COL_3;
	}
	public BigDecimal getR6_COL_4() {
		return R6_COL_4;
	}
	public void setR6_COL_4(BigDecimal r6_COL_4) {
		R6_COL_4 = r6_COL_4;
	}
	public BigDecimal getR6_COL_5() {
		return R6_COL_5;
	}
	public void setR6_COL_5(BigDecimal r6_COL_5) {
		R6_COL_5 = r6_COL_5;
	}
	public BigDecimal getR6_COL_6() {
		return R6_COL_6;
	}
	public void setR6_COL_6(BigDecimal r6_COL_6) {
		R6_COL_6 = r6_COL_6;
	}
	public BigDecimal getR6_COL_7() {
		return R6_COL_7;
	}
	public void setR6_COL_7(BigDecimal r6_COL_7) {
		R6_COL_7 = r6_COL_7;
	}
	public BigDecimal getR6_COL_8() {
		return R6_COL_8;
	}
	public void setR6_COL_8(BigDecimal r6_COL_8) {
		R6_COL_8 = r6_COL_8;
	}
	public BigDecimal getR6_COL_9() {
		return R6_COL_9;
	}
	public void setR6_COL_9(BigDecimal r6_COL_9) {
		R6_COL_9 = r6_COL_9;
	}
	public BigDecimal getR6_COL_10() {
		return R6_COL_10;
	}
	public void setR6_COL_10(BigDecimal r6_COL_10) {
		R6_COL_10 = r6_COL_10;
	}
	public BigDecimal getR6_COL_11() {
		return R6_COL_11;
	}
	public void setR6_COL_11(BigDecimal r6_COL_11) {
		R6_COL_11 = r6_COL_11;
	}
	public BigDecimal getR6_COL_12() {
		return R6_COL_12;
	}
	public void setR6_COL_12(BigDecimal r6_COL_12) {
		R6_COL_12 = r6_COL_12;
	}
	public BigDecimal getR6_COL_13() {
		return R6_COL_13;
	}
	public void setR6_COL_13(BigDecimal r6_COL_13) {
		R6_COL_13 = r6_COL_13;
	}
	public BigDecimal getR6_COL_14() {
		return R6_COL_14;
	}
	public void setR6_COL_14(BigDecimal r6_COL_14) {
		R6_COL_14 = r6_COL_14;
	}
	public String getR7_S_NO() {
		return R7_S_NO;
	}
	public void setR7_S_NO(String r7_S_NO) {
		R7_S_NO = r7_S_NO;
	}
	public String getR7_CATEGORY() {
		return R7_CATEGORY;
	}
	public void setR7_CATEGORY(String r7_CATEGORY) {
		R7_CATEGORY = r7_CATEGORY;
	}
	public BigDecimal getR7_COL_1() {
		return R7_COL_1;
	}
	public void setR7_COL_1(BigDecimal r7_COL_1) {
		R7_COL_1 = r7_COL_1;
	}
	public BigDecimal getR7_COL_2() {
		return R7_COL_2;
	}
	public void setR7_COL_2(BigDecimal r7_COL_2) {
		R7_COL_2 = r7_COL_2;
	}
	public BigDecimal getR7_COL_3() {
		return R7_COL_3;
	}
	public void setR7_COL_3(BigDecimal r7_COL_3) {
		R7_COL_3 = r7_COL_3;
	}
	public BigDecimal getR7_COL_4() {
		return R7_COL_4;
	}
	public void setR7_COL_4(BigDecimal r7_COL_4) {
		R7_COL_4 = r7_COL_4;
	}
	public BigDecimal getR7_COL_5() {
		return R7_COL_5;
	}
	public void setR7_COL_5(BigDecimal r7_COL_5) {
		R7_COL_5 = r7_COL_5;
	}
	public BigDecimal getR7_COL_6() {
		return R7_COL_6;
	}
	public void setR7_COL_6(BigDecimal r7_COL_6) {
		R7_COL_6 = r7_COL_6;
	}
	public BigDecimal getR7_COL_7() {
		return R7_COL_7;
	}
	public void setR7_COL_7(BigDecimal r7_COL_7) {
		R7_COL_7 = r7_COL_7;
	}
	public BigDecimal getR7_COL_8() {
		return R7_COL_8;
	}
	public void setR7_COL_8(BigDecimal r7_COL_8) {
		R7_COL_8 = r7_COL_8;
	}
	public BigDecimal getR7_COL_9() {
		return R7_COL_9;
	}
	public void setR7_COL_9(BigDecimal r7_COL_9) {
		R7_COL_9 = r7_COL_9;
	}
	public BigDecimal getR7_COL_10() {
		return R7_COL_10;
	}
	public void setR7_COL_10(BigDecimal r7_COL_10) {
		R7_COL_10 = r7_COL_10;
	}
	public BigDecimal getR7_COL_11() {
		return R7_COL_11;
	}
	public void setR7_COL_11(BigDecimal r7_COL_11) {
		R7_COL_11 = r7_COL_11;
	}
	public BigDecimal getR7_COL_12() {
		return R7_COL_12;
	}
	public void setR7_COL_12(BigDecimal r7_COL_12) {
		R7_COL_12 = r7_COL_12;
	}
	public BigDecimal getR7_COL_13() {
		return R7_COL_13;
	}
	public void setR7_COL_13(BigDecimal r7_COL_13) {
		R7_COL_13 = r7_COL_13;
	}
	public BigDecimal getR7_COL_14() {
		return R7_COL_14;
	}
	public void setR7_COL_14(BigDecimal r7_COL_14) {
		R7_COL_14 = r7_COL_14;
	}
	public String getR8_S_NO() {
		return R8_S_NO;
	}
	public void setR8_S_NO(String r8_S_NO) {
		R8_S_NO = r8_S_NO;
	}
	public String getR8_CATEGORY() {
		return R8_CATEGORY;
	}
	public void setR8_CATEGORY(String r8_CATEGORY) {
		R8_CATEGORY = r8_CATEGORY;
	}
	public BigDecimal getR8_COL_1() {
		return R8_COL_1;
	}
	public void setR8_COL_1(BigDecimal r8_COL_1) {
		R8_COL_1 = r8_COL_1;
	}
	public BigDecimal getR8_COL_2() {
		return R8_COL_2;
	}
	public void setR8_COL_2(BigDecimal r8_COL_2) {
		R8_COL_2 = r8_COL_2;
	}
	public BigDecimal getR8_COL_3() {
		return R8_COL_3;
	}
	public void setR8_COL_3(BigDecimal r8_COL_3) {
		R8_COL_3 = r8_COL_3;
	}
	public BigDecimal getR8_COL_4() {
		return R8_COL_4;
	}
	public void setR8_COL_4(BigDecimal r8_COL_4) {
		R8_COL_4 = r8_COL_4;
	}
	public BigDecimal getR8_COL_5() {
		return R8_COL_5;
	}
	public void setR8_COL_5(BigDecimal r8_COL_5) {
		R8_COL_5 = r8_COL_5;
	}
	public BigDecimal getR8_COL_6() {
		return R8_COL_6;
	}
	public void setR8_COL_6(BigDecimal r8_COL_6) {
		R8_COL_6 = r8_COL_6;
	}
	public String getR9_S_NO() {
		return R9_S_NO;
	}
	public void setR9_S_NO(String r9_S_NO) {
		R9_S_NO = r9_S_NO;
	}
	public String getR9_CATEGORY() {
		return R9_CATEGORY;
	}
	public void setR9_CATEGORY(String r9_CATEGORY) {
		R9_CATEGORY = r9_CATEGORY;
	}
	public BigDecimal getR9_COL_1() {
		return R9_COL_1;
	}
	public void setR9_COL_1(BigDecimal r9_COL_1) {
		R9_COL_1 = r9_COL_1;
	}
	public BigDecimal getR9_COL_2() {
		return R9_COL_2;
	}
	public void setR9_COL_2(BigDecimal r9_COL_2) {
		R9_COL_2 = r9_COL_2;
	}
	public BigDecimal getR9_COL_3() {
		return R9_COL_3;
	}
	public void setR9_COL_3(BigDecimal r9_COL_3) {
		R9_COL_3 = r9_COL_3;
	}
	public BigDecimal getR9_COL_4() {
		return R9_COL_4;
	}
	public void setR9_COL_4(BigDecimal r9_COL_4) {
		R9_COL_4 = r9_COL_4;
	}
	public BigDecimal getR9_COL_5() {
		return R9_COL_5;
	}
	public void setR9_COL_5(BigDecimal r9_COL_5) {
		R9_COL_5 = r9_COL_5;
	}
	public BigDecimal getR9_COL_6() {
		return R9_COL_6;
	}
	public void setR9_COL_6(BigDecimal r9_COL_6) {
		R9_COL_6 = r9_COL_6;
	}
	public String getR10_S_NO() {
		return R10_S_NO;
	}
	public void setR10_S_NO(String r10_S_NO) {
		R10_S_NO = r10_S_NO;
	}
	public String getR10_CATEGORY() {
		return R10_CATEGORY;
	}
	public void setR10_CATEGORY(String r10_CATEGORY) {
		R10_CATEGORY = r10_CATEGORY;
	}
	public BigDecimal getR10_COL_1() {
		return R10_COL_1;
	}
	public void setR10_COL_1(BigDecimal r10_COL_1) {
		R10_COL_1 = r10_COL_1;
	}
	public BigDecimal getR10_COL_2() {
		return R10_COL_2;
	}
	public void setR10_COL_2(BigDecimal r10_COL_2) {
		R10_COL_2 = r10_COL_2;
	}
	public BigDecimal getR10_COL_3() {
		return R10_COL_3;
	}
	public void setR10_COL_3(BigDecimal r10_COL_3) {
		R10_COL_3 = r10_COL_3;
	}
	public BigDecimal getR10_COL_4() {
		return R10_COL_4;
	}
	public void setR10_COL_4(BigDecimal r10_COL_4) {
		R10_COL_4 = r10_COL_4;
	}
	public BigDecimal getR10_COL_5() {
		return R10_COL_5;
	}
	public void setR10_COL_5(BigDecimal r10_COL_5) {
		R10_COL_5 = r10_COL_5;
	}
	public BigDecimal getR10_COL_6() {
		return R10_COL_6;
	}
	public void setR10_COL_6(BigDecimal r10_COL_6) {
		R10_COL_6 = r10_COL_6;
	}
	public String getR11_S_NO() {
		return R11_S_NO;
	}
	public void setR11_S_NO(String r11_S_NO) {
		R11_S_NO = r11_S_NO;
	}
	public String getR11_CATEGORY() {
		return R11_CATEGORY;
	}
	public void setR11_CATEGORY(String r11_CATEGORY) {
		R11_CATEGORY = r11_CATEGORY;
	}
	public BigDecimal getR11_COL_1() {
		return R11_COL_1;
	}
	public void setR11_COL_1(BigDecimal r11_COL_1) {
		R11_COL_1 = r11_COL_1;
	}
	public BigDecimal getR11_COL_2() {
		return R11_COL_2;
	}
	public void setR11_COL_2(BigDecimal r11_COL_2) {
		R11_COL_2 = r11_COL_2;
	}
	public BigDecimal getR11_COL_3() {
		return R11_COL_3;
	}
	public void setR11_COL_3(BigDecimal r11_COL_3) {
		R11_COL_3 = r11_COL_3;
	}
	public BigDecimal getR11_COL_4() {
		return R11_COL_4;
	}
	public void setR11_COL_4(BigDecimal r11_COL_4) {
		R11_COL_4 = r11_COL_4;
	}
	public BigDecimal getR11_COL_5() {
		return R11_COL_5;
	}
	public void setR11_COL_5(BigDecimal r11_COL_5) {
		R11_COL_5 = r11_COL_5;
	}
	public BigDecimal getR11_COL_6() {
		return R11_COL_6;
	}
	public void setR11_COL_6(BigDecimal r11_COL_6) {
		R11_COL_6 = r11_COL_6;
	}
	public String getR12_S_NO() {
		return R12_S_NO;
	}
	public void setR12_S_NO(String r12_S_NO) {
		R12_S_NO = r12_S_NO;
	}
	public String getR12_CATEGORY() {
		return R12_CATEGORY;
	}
	public void setR12_CATEGORY(String r12_CATEGORY) {
		R12_CATEGORY = r12_CATEGORY;
	}
	public BigDecimal getR12_COL_1() {
		return R12_COL_1;
	}
	public void setR12_COL_1(BigDecimal r12_COL_1) {
		R12_COL_1 = r12_COL_1;
	}
	public BigDecimal getR12_COL_2() {
		return R12_COL_2;
	}
	public void setR12_COL_2(BigDecimal r12_COL_2) {
		R12_COL_2 = r12_COL_2;
	}
	public BigDecimal getR12_COL_3() {
		return R12_COL_3;
	}
	public void setR12_COL_3(BigDecimal r12_COL_3) {
		R12_COL_3 = r12_COL_3;
	}
	public BigDecimal getR12_COL_4() {
		return R12_COL_4;
	}
	public void setR12_COL_4(BigDecimal r12_COL_4) {
		R12_COL_4 = r12_COL_4;
	}
	public BigDecimal getR12_COL_5() {
		return R12_COL_5;
	}
	public void setR12_COL_5(BigDecimal r12_COL_5) {
		R12_COL_5 = r12_COL_5;
	}
	public BigDecimal getR12_COL_6() {
		return R12_COL_6;
	}
	public void setR12_COL_6(BigDecimal r12_COL_6) {
		R12_COL_6 = r12_COL_6;
	}
	public String getR13_S_NO() {
		return R13_S_NO;
	}
	public void setR13_S_NO(String r13_S_NO) {
		R13_S_NO = r13_S_NO;
	}
	public String getR13_CATEGORY() {
		return R13_CATEGORY;
	}
	public void setR13_CATEGORY(String r13_CATEGORY) {
		R13_CATEGORY = r13_CATEGORY;
	}
	public BigDecimal getR13_COL_1() {
		return R13_COL_1;
	}
	public void setR13_COL_1(BigDecimal r13_COL_1) {
		R13_COL_1 = r13_COL_1;
	}
	public BigDecimal getR13_COL_2() {
		return R13_COL_2;
	}
	public void setR13_COL_2(BigDecimal r13_COL_2) {
		R13_COL_2 = r13_COL_2;
	}
	public BigDecimal getR13_COL_3() {
		return R13_COL_3;
	}
	public void setR13_COL_3(BigDecimal r13_COL_3) {
		R13_COL_3 = r13_COL_3;
	}
	public BigDecimal getR13_COL_4() {
		return R13_COL_4;
	}
	public void setR13_COL_4(BigDecimal r13_COL_4) {
		R13_COL_4 = r13_COL_4;
	}
	public BigDecimal getR13_COL_5() {
		return R13_COL_5;
	}
	public void setR13_COL_5(BigDecimal r13_COL_5) {
		R13_COL_5 = r13_COL_5;
	}
	public BigDecimal getR13_COL_6() {
		return R13_COL_6;
	}
	public void setR13_COL_6(BigDecimal r13_COL_6) {
		R13_COL_6 = r13_COL_6;
	}
	public String getR14_S_NO() {
		return R14_S_NO;
	}
	public void setR14_S_NO(String r14_S_NO) {
		R14_S_NO = r14_S_NO;
	}
	public String getR14_CATEGORY() {
		return R14_CATEGORY;
	}
	public void setR14_CATEGORY(String r14_CATEGORY) {
		R14_CATEGORY = r14_CATEGORY;
	}
	public BigDecimal getR14_COL_1() {
		return R14_COL_1;
	}
	public void setR14_COL_1(BigDecimal r14_COL_1) {
		R14_COL_1 = r14_COL_1;
	}
	public BigDecimal getR14_COL_2() {
		return R14_COL_2;
	}
	public void setR14_COL_2(BigDecimal r14_COL_2) {
		R14_COL_2 = r14_COL_2;
	}
	public BigDecimal getR14_COL_3() {
		return R14_COL_3;
	}
	public void setR14_COL_3(BigDecimal r14_COL_3) {
		R14_COL_3 = r14_COL_3;
	}
	public BigDecimal getR14_COL_4() {
		return R14_COL_4;
	}
	public void setR14_COL_4(BigDecimal r14_COL_4) {
		R14_COL_4 = r14_COL_4;
	}
	public BigDecimal getR14_COL_5() {
		return R14_COL_5;
	}
	public void setR14_COL_5(BigDecimal r14_COL_5) {
		R14_COL_5 = r14_COL_5;
	}
	public BigDecimal getR14_COL_6() {
		return R14_COL_6;
	}
	public void setR14_COL_6(BigDecimal r14_COL_6) {
		R14_COL_6 = r14_COL_6;
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
	public String getReport_code() {
		return report_code;
	}
	public void setReport_code(String report_code) {
		this.report_code = report_code;
	}
	public Date getReport_submit_date() {
		return report_submit_date;
	}
	public void setReport_submit_date(Date report_submit_date) {
		this.report_submit_date = report_submit_date;
	}
	public  BRF70_ENTITY () {
		super();
		// TODO Auto-generated constructor stub
	}
	@OneToMany(mappedBy = "parentEntity", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<BRF70_ENTITY> brf70_REPORTENTITY;  // Child entities

    @ManyToOne
    @JoinColumn(name = "report_date", insertable = false, updatable = false)  // Foreign key column to link parent entity
    private BRF70_ENTITY parentEntity;  // Parent entity

    // Getter and setter for brf70_REPORTENTITY
    public List<BRF70_ENTITY> getBrf70_REPORTENTITY() {
        return brf70_REPORTENTITY;
    }

    public void setBrf70_REPORTENTITY(List<BRF70_ENTITY> brf70_REPORTENTITY) {
        this.brf70_REPORTENTITY = brf70_REPORTENTITY;
    }

    // Getter and setter for parentEntity
    public BRF70_ENTITY getParentEntity() {
        return parentEntity;
    }

    public void setParentEntity(BRF70_ENTITY parentEntity) {
        this.parentEntity = parentEntity;
    }
   

	
}
