package com.bornfire.xbrl.entities.BRBS;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;
@Entity
@Table(name="BRF103_SUMMARYTABLE")
public class BRF103_ENTITY {
	
	private String	R1_S_NO ;	
	private String	R1_REGULATIONS ;	
	private String	R1_DORMANT ;	
	private BigDecimal	R1_ACCOUNTS_AED_1YEAR ;	
	private BigDecimal	R1_AMOUNT_AED_1YEAR ;	
	private BigDecimal	R1_ACCOUNTS_FCY_1YEAR ;	
	private BigDecimal	R1_AMOUNT_FCY_1YEAR ;	
	private BigDecimal	R1_ACCOUNTS_AED_2YEAR ;	
	private BigDecimal	R1_AMOUNT_AED_2YEAR ;	
	private BigDecimal	R1_ACCOUNTS_FCY_2YEAR ;	
	private BigDecimal	R1_AMOUNT_FCY_2YEAR ;	
	private BigDecimal	R1_ACCOUNTS_AED_3YEAR ;	
	private BigDecimal	R1_AMOUNT_AED_3YEAR ;	
	private BigDecimal	R1_ACCOUNTS_FCY_3YEAR ;	
	private BigDecimal	R1_AMOUNT_FCY_3YEAR ;	
	private BigDecimal	R1_ACCOUNTS_AED_5YEAR ;	
	private BigDecimal	R1_AMOUNT_AED_5YEAR ;	
	private BigDecimal	R1_ACCOUNTS_FCY_5YEAR ;	
	private BigDecimal	R1_AMOUNT_FCY_5YEAR ;	
	private BigDecimal	R1_ACCOUNTS_AED_ABOVE ;	
	private BigDecimal	R1_AMOUNT_AED_ABOVE ;	
	private BigDecimal	R1_ACCOUNTS_FCY_ABOVE ;	
	private BigDecimal	R1_AMOUNT_FCY_ABOVE ;	
	private BigDecimal	R1_ACCOUNTS_AED_INACTIVE ;	
	private BigDecimal	R1_AMOUNT_AED_INACTIVE ;	
	private BigDecimal	R1_ACCOUNTS_FCY_INACTIVE ;	
	private BigDecimal	R1_AMOUNT_FCY_INACTIVE ;	
	private BigDecimal	R1_ACCOUNTS_AED_DORMANT ;	
	private BigDecimal	R1_AMOUNT_AED_DORMANT ;	
	private BigDecimal	R1_ACCOUNTS_FCY_DORMANT ;	
	private BigDecimal	R1_AMOUNT_FCY_DORMANT ;	
	private String	R2_S_NO ;	
	private String	R2_REGULATIONS ;	
	private String	R2_DORMANT ;	
	private BigDecimal	R2_ACCOUNTS_AED_1YEAR ;	
	private BigDecimal	R2_AMOUNT_AED_1YEAR ;	
	private BigDecimal	R2_ACCOUNTS_FCY_1YEAR ;	
	private BigDecimal	R2_AMOUNT_FCY_1YEAR ;	
	private BigDecimal	R2_ACCOUNTS_AED_2YEAR ;	
	private BigDecimal	R2_AMOUNT_AED_2YEAR ;	
	private BigDecimal	R2_ACCOUNTS_FCY_2YEAR ;	
	private BigDecimal	R2_AMOUNT_FCY_2YEAR ;	
	private BigDecimal	R2_ACCOUNTS_AED_3YEAR ;	
	private BigDecimal	R2_AMOUNT_AED_3YEAR ;	
	private BigDecimal	R2_ACCOUNTS_FCY_3YEAR ;	
	private BigDecimal	R2_AMOUNT_FCY_3YEAR ;	
	private BigDecimal	R2_ACCOUNTS_AED_5YEAR ;	
	private BigDecimal	R2_AMOUNT_AED_5YEAR ;	
	private BigDecimal	R2_ACCOUNTS_FCY_5YEAR ;	
	private BigDecimal	R2_AMOUNT_FCY_5YEAR ;	
	private BigDecimal	R2_ACCOUNTS_AED_ABOVE ;	
	private BigDecimal	R2_AMOUNT_AED_ABOVE ;	
	private BigDecimal	R2_ACCOUNTS_FCY_ABOVE ;	
	private BigDecimal	R2_AMOUNT_FCY_ABOVE ;	
	private BigDecimal	R2_ACCOUNTS_AED_INACTIVE ;	
	private BigDecimal	R2_AMOUNT_AED_INACTIVE ;	
	private BigDecimal	R2_ACCOUNTS_FCY_INACTIVE ;	
	private BigDecimal	R2_AMOUNT_FCY_INACTIVE ;	
	private BigDecimal	R2_ACCOUNTS_AED_DORMANT ;	
	private BigDecimal	R2_AMOUNT_AED_DORMANT ;	
	private BigDecimal	R2_ACCOUNTS_FCY_DORMANT ;	
	private BigDecimal	R2_AMOUNT_FCY_DORMANT ;	
	private String	R3_S_NO ;	
	private String	R3_REGULATIONS ;	
	private String	R3_DORMANT ;	
	private BigDecimal	R3_ACCOUNTS_AED_1YEAR ;	
	private BigDecimal	R3_AMOUNT_AED_1YEAR ;	
	private BigDecimal	R3_ACCOUNTS_FCY_1YEAR ;	
	private BigDecimal	R3_AMOUNT_FCY_1YEAR ;	
	private BigDecimal	R3_ACCOUNTS_AED_2YEAR ;	
	private BigDecimal	R3_AMOUNT_AED_2YEAR ;	
	private BigDecimal	R3_ACCOUNTS_FCY_2YEAR ;	
	private BigDecimal	R3_AMOUNT_FCY_2YEAR ;	
	private BigDecimal	R3_ACCOUNTS_AED_3YEAR ;	
	private BigDecimal	R3_AMOUNT_AED_3YEAR ;	
	private BigDecimal	R3_ACCOUNTS_FCY_3YEAR ;	
	private BigDecimal	R3_AMOUNT_FCY_3YEAR ;	
	private BigDecimal	R3_ACCOUNTS_AED_5YEAR ;	
	private BigDecimal	R3_AMOUNT_AED_5YEAR ;	
	private BigDecimal	R3_ACCOUNTS_FCY_5YEAR ;	
	private BigDecimal	R3_AMOUNT_FCY_5YEAR ;	
	private BigDecimal	R3_ACCOUNTS_AED_ABOVE ;	
	private BigDecimal	R3_AMOUNT_AED_ABOVE ;	
	private BigDecimal	R3_ACCOUNTS_FCY_ABOVE ;	
	private BigDecimal	R3_AMOUNT_FCY_ABOVE ;	
	private BigDecimal	R3_ACCOUNTS_AED_INACTIVE ;	
	private BigDecimal	R3_AMOUNT_AED_INACTIVE ;	
	private BigDecimal	R3_ACCOUNTS_FCY_INACTIVE ;	
	private BigDecimal	R3_AMOUNT_FCY_INACTIVE ;	
	private BigDecimal	R3_ACCOUNTS_AED_DORMANT ;	
	private BigDecimal	R3_AMOUNT_AED_DORMANT ;	
	private BigDecimal	R3_ACCOUNTS_FCY_DORMANT ;	
	private BigDecimal	R3_AMOUNT_FCY_DORMANT ;	
	private String	R4_S_NO ;	
	private String	R4_REGULATIONS ;	
	private String	R4_DORMANT ;	
	private BigDecimal	R4_ACCOUNTS_AED_1YEAR ;	
	private BigDecimal	R4_AMOUNT_AED_1YEAR ;	
	private BigDecimal	R4_ACCOUNTS_FCY_1YEAR ;	
	private BigDecimal	R4_AMOUNT_FCY_1YEAR ;	
	private BigDecimal	R4_ACCOUNTS_AED_2YEAR ;	
	private BigDecimal	R4_AMOUNT_AED_2YEAR ;	
	private BigDecimal	R4_ACCOUNTS_FCY_2YEAR ;	
	private BigDecimal	R4_AMOUNT_FCY_2YEAR ;	
	private BigDecimal	R4_ACCOUNTS_AED_3YEAR ;	
	private BigDecimal	R4_AMOUNT_AED_3YEAR ;	
	private BigDecimal	R4_ACCOUNTS_FCY_3YEAR ;	
	private BigDecimal	R4_AMOUNT_FCY_3YEAR ;	
	private BigDecimal	R4_ACCOUNTS_AED_5YEAR ;	
	private BigDecimal	R4_AMOUNT_AED_5YEAR ;	
	private BigDecimal	R4_ACCOUNTS_FCY_5YEAR ;	
	private BigDecimal	R4_AMOUNT_FCY_5YEAR ;	
	private BigDecimal	R4_ACCOUNTS_AED_ABOVE ;	
	private BigDecimal	R4_AMOUNT_AED_ABOVE ;	
	private BigDecimal	R4_ACCOUNTS_FCY_ABOVE ;	
	private BigDecimal	R4_AMOUNT_FCY_ABOVE ;	
	private BigDecimal	R4_ACCOUNTS_AED_INACTIVE ;	
	private BigDecimal	R4_AMOUNT_AED_INACTIVE ;	
	private BigDecimal	R4_ACCOUNTS_FCY_INACTIVE ;	
	private BigDecimal	R4_AMOUNT_FCY_INACTIVE ;	
	private BigDecimal	R4_ACCOUNTS_AED_DORMANT ;	
	private BigDecimal	R4_AMOUNT_AED_DORMANT ;	
	private BigDecimal	R4_ACCOUNTS_FCY_DORMANT ;	
	private BigDecimal	R4_AMOUNT_FCY_DORMANT ;	
	private String	R5_S_NO ;	
	private String	R5_REGULATIONS ;	
	private String	R5_DORMANT ;	
	private BigDecimal	R5_ACCOUNTS_AED_1YEAR ;	
	private BigDecimal	R5_AMOUNT_AED_1YEAR ;	
	private BigDecimal	R5_ACCOUNTS_FCY_1YEAR ;	
	private BigDecimal	R5_AMOUNT_FCY_1YEAR ;	
	private BigDecimal	R5_ACCOUNTS_AED_2YEAR ;	
	private BigDecimal	R5_AMOUNT_AED_2YEAR ;	
	private BigDecimal	R5_ACCOUNTS_FCY_2YEAR ;	
	private BigDecimal	R5_AMOUNT_FCY_2YEAR ;	
	private BigDecimal	R5_ACCOUNTS_AED_3YEAR ;	
	private BigDecimal	R5_AMOUNT_AED_3YEAR ;	
	private BigDecimal	R5_ACCOUNTS_FCY_3YEAR ;	
	private BigDecimal	R5_AMOUNT_FCY_3YEAR ;	
	private BigDecimal	R5_ACCOUNTS_AED_5YEAR ;	
	private BigDecimal	R5_AMOUNT_AED_5YEAR ;	
	private BigDecimal	R5_ACCOUNTS_FCY_5YEAR ;	
	private BigDecimal	R5_AMOUNT_FCY_5YEAR ;	
	private BigDecimal	R5_ACCOUNTS_AED_ABOVE ;	
	private BigDecimal	R5_AMOUNT_AED_ABOVE ;	
	private BigDecimal	R5_ACCOUNTS_FCY_ABOVE ;	
	private BigDecimal	R5_AMOUNT_FCY_ABOVE ;	
	private BigDecimal	R5_ACCOUNTS_AED_INACTIVE ;	
	private BigDecimal	R5_AMOUNT_AED_INACTIVE ;	
	private BigDecimal	R5_ACCOUNTS_FCY_INACTIVE ;	
	private BigDecimal	R5_AMOUNT_FCY_INACTIVE ;	
	private BigDecimal	R5_ACCOUNTS_AED_DORMANT ;	
	private BigDecimal	R5_AMOUNT_AED_DORMANT ;	
	private BigDecimal	R5_ACCOUNTS_FCY_DORMANT ;	
	private BigDecimal	R5_AMOUNT_FCY_DORMANT ;	
	private String	R6_S_NO ;	
	private String	R6_REGULATIONS ;	
	private String	R6_DORMANT ;	
	private BigDecimal	R6_ACCOUNTS_AED_1YEAR ;	
	private BigDecimal	R6_AMOUNT_AED_1YEAR ;	
	private BigDecimal	R6_ACCOUNTS_FCY_1YEAR ;	
	private BigDecimal	R6_AMOUNT_FCY_1YEAR ;	
	private BigDecimal	R6_ACCOUNTS_AED_2YEAR ;	
	private BigDecimal	R6_AMOUNT_AED_2YEAR ;	
	private BigDecimal	R6_ACCOUNTS_FCY_2YEAR ;	
	private BigDecimal	R6_AMOUNT_FCY_2YEAR ;	
	private BigDecimal	R6_ACCOUNTS_AED_3YEAR ;	
	private BigDecimal	R6_AMOUNT_AED_3YEAR ;	
	private BigDecimal	R6_ACCOUNTS_FCY_3YEAR ;	
	private BigDecimal	R6_AMOUNT_FCY_3YEAR ;	
	private BigDecimal	R6_ACCOUNTS_AED_5YEAR ;	
	private BigDecimal	R6_AMOUNT_AED_5YEAR ;	
	private BigDecimal	R6_ACCOUNTS_FCY_5YEAR ;	
	private BigDecimal	R6_AMOUNT_FCY_5YEAR ;	
	private BigDecimal	R6_ACCOUNTS_AED_ABOVE ;	
	private BigDecimal	R6_AMOUNT_AED_ABOVE ;	
	private BigDecimal	R6_ACCOUNTS_FCY_ABOVE ;	
	private BigDecimal	R6_AMOUNT_FCY_ABOVE ;	
	private BigDecimal	R6_ACCOUNTS_AED_INACTIVE ;	
	private BigDecimal	R6_AMOUNT_AED_INACTIVE ;	
	private BigDecimal	R6_ACCOUNTS_FCY_INACTIVE ;	
	private BigDecimal	R6_AMOUNT_FCY_INACTIVE ;	
	private BigDecimal	R6_ACCOUNTS_AED_DORMANT ;	
	private BigDecimal	R6_AMOUNT_AED_DORMANT ;	
	private BigDecimal	R6_ACCOUNTS_FCY_DORMANT ;	
	private BigDecimal	R6_AMOUNT_FCY_DORMANT ;	
	private String	R7_S_NO ;	
	private String	R7_REGULATIONS ;	
	private String	R7_DORMANT ;	
	private BigDecimal	R7_ACCOUNTS_AED_1YEAR ;	
	private BigDecimal	R7_AMOUNT_AED_1YEAR ;	
	private BigDecimal	R7_ACCOUNTS_FCY_1YEAR ;	
	private BigDecimal	R7_AMOUNT_FCY_1YEAR ;	
	private BigDecimal	R7_ACCOUNTS_AED_2YEAR ;	
	private BigDecimal	R7_AMOUNT_AED_2YEAR ;	
	private BigDecimal	R7_ACCOUNTS_FCY_2YEAR ;	
	private BigDecimal	R7_AMOUNT_FCY_2YEAR ;	
	private BigDecimal	R7_ACCOUNTS_AED_3YEAR ;	
	private BigDecimal	R7_AMOUNT_AED_3YEAR ;	
	private BigDecimal	R7_ACCOUNTS_FCY_3YEAR ;	
	private BigDecimal	R7_AMOUNT_FCY_3YEAR ;	
	private BigDecimal	R7_ACCOUNTS_AED_5YEAR ;	
	private BigDecimal	R7_AMOUNT_AED_5YEAR ;	
	private BigDecimal	R7_ACCOUNTS_FCY_5YEAR ;	
	private BigDecimal	R7_AMOUNT_FCY_5YEAR ;	
	private BigDecimal	R7_ACCOUNTS_AED_ABOVE ;	
	private BigDecimal	R7_AMOUNT_AED_ABOVE ;	
	private BigDecimal	R7_ACCOUNTS_FCY_ABOVE ;	
	private BigDecimal	R7_AMOUNT_FCY_ABOVE ;	
	private BigDecimal	R7_ACCOUNTS_AED_INACTIVE ;	
	private BigDecimal	R7_AMOUNT_AED_INACTIVE ;	
	private BigDecimal	R7_ACCOUNTS_FCY_INACTIVE ;	
	private BigDecimal	R7_AMOUNT_FCY_INACTIVE ;	
	private BigDecimal	R7_ACCOUNTS_AED_DORMANT ;	
	private BigDecimal	R7_AMOUNT_AED_DORMANT ;	
	private BigDecimal	R7_ACCOUNTS_FCY_DORMANT ;	
	private BigDecimal	R7_AMOUNT_FCY_DORMANT ;	
	private String	R8_S_NO ;	
	private String	R8_REGULATIONS ;	
	private String	R8_DORMANT ;	
	private BigDecimal	R8_ACCOUNTS_AED_1YEAR ;	
	private BigDecimal	R8_AMOUNT_AED_1YEAR ;	
	private BigDecimal	R8_ACCOUNTS_FCY_1YEAR ;	
	private BigDecimal	R8_AMOUNT_FCY_1YEAR ;	
	private BigDecimal	R8_ACCOUNTS_AED_2YEAR ;	
	private BigDecimal	R8_AMOUNT_AED_2YEAR ;	
	private BigDecimal	R8_ACCOUNTS_FCY_2YEAR ;	
	private BigDecimal	R8_AMOUNT_FCY_2YEAR ;	
	private BigDecimal	R8_ACCOUNTS_AED_3YEAR ;	
	private BigDecimal	R8_AMOUNT_AED_3YEAR ;	
	private BigDecimal	R8_ACCOUNTS_FCY_3YEAR ;	
	private BigDecimal	R8_AMOUNT_FCY_3YEAR ;	
	private BigDecimal	R8_ACCOUNTS_AED_5YEAR ;	
	private BigDecimal	R8_AMOUNT_AED_5YEAR ;	
	private BigDecimal	R8_ACCOUNTS_FCY_5YEAR ;	
	private BigDecimal	R8_AMOUNT_FCY_5YEAR ;	
	private BigDecimal	R8_ACCOUNTS_AED_ABOVE ;	
	private BigDecimal	R8_AMOUNT_AED_ABOVE ;	
	private BigDecimal	R8_ACCOUNTS_FCY_ABOVE ;	
	private BigDecimal	R8_AMOUNT_FCY_ABOVE ;	
	private BigDecimal	R8_ACCOUNTS_AED_INACTIVE ;	
	private BigDecimal	R8_AMOUNT_AED_INACTIVE ;	
	private BigDecimal	R8_ACCOUNTS_FCY_INACTIVE ;	
	private BigDecimal	R8_AMOUNT_FCY_INACTIVE ;	
	private BigDecimal	R8_ACCOUNTS_AED_DORMANT ;	
	private BigDecimal	R8_AMOUNT_AED_DORMANT ;	
	private BigDecimal	R8_ACCOUNTS_FCY_DORMANT ;	
	private BigDecimal	R8_AMOUNT_FCY_DORMANT ;	
	private String	R9_S_NO ;	
	private String	R9_REGULATIONS ;	
	private String	R9_DORMANT ;	
	private BigDecimal	R9_ACCOUNTS_AED_1YEAR ;	
	private BigDecimal	R9_AMOUNT_AED_1YEAR ;	
	private BigDecimal	R9_ACCOUNTS_FCY_1YEAR ;	
	private BigDecimal	R9_AMOUNT_FCY_1YEAR ;	
	private BigDecimal	R9_ACCOUNTS_AED_2YEAR ;	
	private BigDecimal	R9_AMOUNT_AED_2YEAR ;	
	private BigDecimal	R9_ACCOUNTS_FCY_2YEAR ;	
	private BigDecimal	R9_AMOUNT_FCY_2YEAR ;	
	private BigDecimal	R9_ACCOUNTS_AED_3YEAR ;	
	private BigDecimal	R9_AMOUNT_AED_3YEAR ;	
	private BigDecimal	R9_ACCOUNTS_FCY_3YEAR ;	
	private BigDecimal	R9_AMOUNT_FCY_3YEAR ;	
	private BigDecimal	R9_ACCOUNTS_AED_5YEAR ;	
	private BigDecimal	R9_AMOUNT_AED_5YEAR ;	
	private BigDecimal	R9_ACCOUNTS_FCY_5YEAR ;	
	private BigDecimal	R9_AMOUNT_FCY_5YEAR ;	
	private BigDecimal	R9_ACCOUNTS_AED_ABOVE ;	
	private BigDecimal	R9_AMOUNT_AED_ABOVE ;	
	private BigDecimal	R9_ACCOUNTS_FCY_ABOVE ;	
	private BigDecimal	R9_AMOUNT_FCY_ABOVE ;	
	private BigDecimal	R9_ACCOUNTS_AED_INACTIVE ;	
	private BigDecimal	R9_AMOUNT_AED_INACTIVE ;	
	private BigDecimal	R9_ACCOUNTS_FCY_INACTIVE ;	
	private BigDecimal	R9_AMOUNT_FCY_INACTIVE ;	
	private BigDecimal	R9_ACCOUNTS_AED_DORMANT ;	
	private BigDecimal	R9_AMOUNT_AED_DORMANT ;	
	private BigDecimal	R9_ACCOUNTS_FCY_DORMANT ;	
	private BigDecimal	R9_AMOUNT_FCY_DORMANT ;	
	private String	R10_S_NO ;	
	private String	R10_REGULATIONS ;	
	private String	R10_DORMANT ;	
	private BigDecimal	R10_ACCOUNTS_AED_1YEAR ;	
	private BigDecimal	R10_AMOUNT_AED_1YEAR ;	
	private BigDecimal	R10_ACCOUNTS_FCY_1YEAR ;	
	private BigDecimal	R10_AMOUNT_FCY_1YEAR ;	
	private BigDecimal	R10_ACCOUNTS_AED_2YEAR ;	
	private BigDecimal	R10_AMOUNT_AED_2YEAR ;	
	private BigDecimal	R10_ACCOUNTS_FCY_2YEAR ;	
	private BigDecimal	R10_AMOUNT_FCY_2YEAR ;	
	private BigDecimal	R10_ACCOUNTS_AED_3YEAR ;	
	private BigDecimal	R10_AMOUNT_AED_3YEAR ;	
	private BigDecimal	R10_ACCOUNTS_FCY_3YEAR ;	
	private BigDecimal	R10_AMOUNT_FCY_3YEAR ;	
	private BigDecimal	R10_ACCOUNTS_AED_5YEAR ;	
	private BigDecimal	R10_AMOUNT_AED_5YEAR ;	
	private BigDecimal	R10_ACCOUNTS_FCY_5YEAR ;	
	private BigDecimal	R10_AMOUNT_FCY_5YEAR ;	
	private BigDecimal	R10_ACCOUNTS_AED_ABOVE ;	
	private BigDecimal	R10_AMOUNT_AED_ABOVE ;	
	private BigDecimal	R10_ACCOUNTS_FCY_ABOVE ;	
	private BigDecimal	R10_AMOUNT_FCY_ABOVE ;	
	private BigDecimal	R10_ACCOUNTS_AED_INACTIVE ;	
	private BigDecimal	R10_AMOUNT_AED_INACTIVE ;	
	private BigDecimal	R10_ACCOUNTS_FCY_INACTIVE ;	
	private BigDecimal	R10_AMOUNT_FCY_INACTIVE ;	
	private BigDecimal	R10_ACCOUNTS_AED_DORMANT ;	
	private BigDecimal	R10_AMOUNT_AED_DORMANT ;	
	private BigDecimal	R10_ACCOUNTS_FCY_DORMANT ;	
	private BigDecimal	R10_AMOUNT_FCY_DORMANT ;	
	private String	R11_S_NO ;	
	private String	R11_REGULATIONS ;	
	private String	R11_DORMANT ;	
	private BigDecimal	R11_ACCOUNTS_AED_1YEAR ;	
	private BigDecimal	R11_AMOUNT_AED_1YEAR ;	
	private BigDecimal	R11_ACCOUNTS_FCY_1YEAR ;	
	private BigDecimal	R11_AMOUNT_FCY_1YEAR ;	
	private BigDecimal	R11_ACCOUNTS_AED_2YEAR ;	
	private BigDecimal	R11_AMOUNT_AED_2YEAR ;	
	private BigDecimal	R11_ACCOUNTS_FCY_2YEAR ;	
	private BigDecimal	R11_AMOUNT_FCY_2YEAR ;	
	private BigDecimal	R11_ACCOUNTS_AED_3YEAR ;	
	private BigDecimal	R11_AMOUNT_AED_3YEAR ;	
	private BigDecimal	R11_ACCOUNTS_FCY_3YEAR ;	
	private BigDecimal	R11_AMOUNT_FCY_3YEAR ;	
	private BigDecimal	R11_ACCOUNTS_AED_5YEAR ;	
	private BigDecimal	R11_AMOUNT_AED_5YEAR ;	
	private BigDecimal	R11_ACCOUNTS_FCY_5YEAR ;	
	private BigDecimal	R11_AMOUNT_FCY_5YEAR ;	
	private BigDecimal	R11_ACCOUNTS_AED_ABOVE ;	
	private BigDecimal	R11_AMOUNT_AED_ABOVE ;	
	private BigDecimal	R11_ACCOUNTS_FCY_ABOVE ;	
	private BigDecimal	R11_AMOUNT_FCY_ABOVE ;	
	private BigDecimal	R11_ACCOUNTS_AED_INACTIVE ;	
	private BigDecimal	R11_AMOUNT_AED_INACTIVE ;	
	private BigDecimal	R11_ACCOUNTS_FCY_INACTIVE ;	
	private BigDecimal	R11_AMOUNT_FCY_INACTIVE ;	
	private BigDecimal	R11_ACCOUNTS_AED_DORMANT ;	
	private BigDecimal	R11_AMOUNT_AED_DORMANT ;	
	private BigDecimal	R11_ACCOUNTS_FCY_DORMANT ;	
	private BigDecimal	R11_AMOUNT_FCY_DORMANT ;	
	private String	R12_S_NO ;	
	private String	R12_REGULATIONS ;	
	private String	R12_DORMANT ;	
	private BigDecimal	R12_ACCOUNTS_AED_1YEAR ;	
	private BigDecimal	R12_AMOUNT_AED_1YEAR ;	
	private BigDecimal	R12_ACCOUNTS_FCY_1YEAR ;	
	private BigDecimal	R12_AMOUNT_FCY_1YEAR ;	
	private BigDecimal	R12_ACCOUNTS_AED_2YEAR ;	
	private BigDecimal	R12_AMOUNT_AED_2YEAR ;	
	private BigDecimal	R12_ACCOUNTS_FCY_2YEAR ;	
	private BigDecimal	R12_AMOUNT_FCY_2YEAR ;	
	private BigDecimal	R12_ACCOUNTS_AED_3YEAR ;	
	private BigDecimal	R12_AMOUNT_AED_3YEAR ;	
	private BigDecimal	R12_ACCOUNTS_FCY_3YEAR ;	
	private BigDecimal	R12_AMOUNT_FCY_3YEAR ;	
	private BigDecimal	R12_ACCOUNTS_AED_5YEAR ;	
	private BigDecimal	R12_AMOUNT_AED_5YEAR ;	
	private BigDecimal	R12_ACCOUNTS_FCY_5YEAR ;	
	private BigDecimal	R12_AMOUNT_FCY_5YEAR ;	
	private BigDecimal	R12_ACCOUNTS_AED_ABOVE ;	
	private BigDecimal	R12_AMOUNT_AED_ABOVE ;	
	private BigDecimal	R12_ACCOUNTS_FCY_ABOVE ;	
	private BigDecimal	R12_AMOUNT_FCY_ABOVE ;	
	private BigDecimal	R12_ACCOUNTS_AED_INACTIVE ;	
	private BigDecimal	R12_AMOUNT_AED_INACTIVE ;	
	private BigDecimal	R12_ACCOUNTS_FCY_INACTIVE ;	
	private BigDecimal	R12_AMOUNT_FCY_INACTIVE ;	
	private BigDecimal	R12_ACCOUNTS_AED_DORMANT ;	
	private BigDecimal	R12_AMOUNT_AED_DORMANT ;	
	private BigDecimal	R12_ACCOUNTS_FCY_DORMANT ;	
	private BigDecimal	R12_AMOUNT_FCY_DORMANT ;	
	private String	R13_S_NO ;	
	private String	R13_REGULATIONS ;	
	private String	R13_DORMANT ;	
	private BigDecimal	R13_ACCOUNTS_AED_1YEAR ;	
	private BigDecimal	R13_AMOUNT_AED_1YEAR ;	
	private BigDecimal	R13_ACCOUNTS_FCY_1YEAR ;	
	private BigDecimal	R13_AMOUNT_FCY_1YEAR ;	
	private BigDecimal	R13_ACCOUNTS_AED_2YEAR ;	
	private BigDecimal	R13_AMOUNT_AED_2YEAR ;	
	private BigDecimal	R13_ACCOUNTS_FCY_2YEAR ;	
	private BigDecimal	R13_AMOUNT_FCY_2YEAR ;	
	private BigDecimal	R13_ACCOUNTS_AED_3YEAR ;	
	private BigDecimal	R13_AMOUNT_AED_3YEAR ;	
	private BigDecimal	R13_ACCOUNTS_FCY_3YEAR ;	
	private BigDecimal	R13_AMOUNT_FCY_3YEAR ;	
	private BigDecimal	R13_ACCOUNTS_AED_5YEAR ;	
	private BigDecimal	R13_AMOUNT_AED_5YEAR ;	
	private BigDecimal	R13_ACCOUNTS_FCY_5YEAR ;	
	private BigDecimal	R13_AMOUNT_FCY_5YEAR ;	
	private BigDecimal	R13_ACCOUNTS_AED_ABOVE ;	
	private BigDecimal	R13_AMOUNT_AED_ABOVE ;	
	private BigDecimal	R13_ACCOUNTS_FCY_ABOVE ;	
	private BigDecimal	R13_AMOUNT_FCY_ABOVE ;	
	private BigDecimal	R13_ACCOUNTS_AED_INACTIVE ;	
	private BigDecimal	R13_AMOUNT_AED_INACTIVE ;	
	private BigDecimal	R13_ACCOUNTS_FCY_INACTIVE ;	
	private BigDecimal	R13_AMOUNT_FCY_INACTIVE ;	
	private BigDecimal	R13_ACCOUNTS_AED_DORMANT ;	
	private BigDecimal	R13_AMOUNT_AED_DORMANT ;	
	private BigDecimal	R13_ACCOUNTS_FCY_DORMANT ;	
	private BigDecimal	R13_AMOUNT_FCY_DORMANT ;	
	private String	R14_S_NO ;	
	private String	R14_REGULATIONS ;	
	private String	R14_DORMANT ;	
	private BigDecimal	R14_ACCOUNTS_AED_1YEAR ;	
	private BigDecimal	R14_AMOUNT_AED_1YEAR ;	
	private BigDecimal	R14_ACCOUNTS_FCY_1YEAR ;	
	private BigDecimal	R14_AMOUNT_FCY_1YEAR ;	
	private BigDecimal	R14_ACCOUNTS_AED_2YEAR ;	
	private BigDecimal	R14_AMOUNT_AED_2YEAR ;	
	private BigDecimal	R14_ACCOUNTS_FCY_2YEAR ;	
	private BigDecimal	R14_AMOUNT_FCY_2YEAR ;	
	private BigDecimal	R14_ACCOUNTS_AED_3YEAR ;	
	private BigDecimal	R14_AMOUNT_AED_3YEAR ;	
	private BigDecimal	R14_ACCOUNTS_FCY_3YEAR ;	
	private BigDecimal	R14_AMOUNT_FCY_3YEAR ;	
	private BigDecimal	R14_ACCOUNTS_AED_5YEAR ;	
	private BigDecimal	R14_AMOUNT_AED_5YEAR ;	
	private BigDecimal	R14_ACCOUNTS_FCY_5YEAR ;	
	private BigDecimal	R14_AMOUNT_FCY_5YEAR ;	
	private BigDecimal	R14_ACCOUNTS_AED_ABOVE ;	
	private BigDecimal	R14_AMOUNT_AED_ABOVE ;	
	private BigDecimal	R14_ACCOUNTS_FCY_ABOVE ;	
	private BigDecimal	R14_AMOUNT_FCY_ABOVE ;	
	private BigDecimal	R14_ACCOUNTS_AED_INACTIVE ;	
	private BigDecimal	R14_AMOUNT_AED_INACTIVE ;	
	private BigDecimal	R14_ACCOUNTS_FCY_INACTIVE ;	
	private BigDecimal	R14_AMOUNT_FCY_INACTIVE ;	
	private BigDecimal	R14_ACCOUNTS_AED_DORMANT ;	
	private BigDecimal	R14_AMOUNT_AED_DORMANT ;	
	private BigDecimal	R14_ACCOUNTS_FCY_DORMANT ;	
	private BigDecimal	R14_AMOUNT_FCY_DORMANT ;	
	private String	R15_S_NO ;	
	private String	R15_REGULATIONS ;	
	private String	R15_DORMANT ;	
	private BigDecimal	R15_ACCOUNTS_AED_1YEAR ;	
	private BigDecimal	R15_AMOUNT_AED_1YEAR ;	
	private BigDecimal	R15_ACCOUNTS_FCY_1YEAR ;	
	private BigDecimal	R15_AMOUNT_FCY_1YEAR ;	
	private BigDecimal	R15_ACCOUNTS_AED_2YEAR ;	
	private BigDecimal	R15_AMOUNT_AED_2YEAR ;	
	private BigDecimal	R15_ACCOUNTS_FCY_2YEAR ;	
	private BigDecimal	R15_AMOUNT_FCY_2YEAR ;	
	private BigDecimal	R15_ACCOUNTS_AED_3YEAR ;	
	private BigDecimal	R15_AMOUNT_AED_3YEAR ;	
	private BigDecimal	R15_ACCOUNTS_FCY_3YEAR ;	
	private BigDecimal	R15_AMOUNT_FCY_3YEAR ;	
	private BigDecimal	R15_ACCOUNTS_AED_5YEAR ;	
	private BigDecimal	R15_AMOUNT_AED_5YEAR ;	
	private BigDecimal	R15_ACCOUNTS_FCY_5YEAR ;	
	private BigDecimal	R15_AMOUNT_FCY_5YEAR ;	
	private BigDecimal	R15_ACCOUNTS_AED_ABOVE ;	
	private BigDecimal	R15_AMOUNT_AED_ABOVE ;	
	private BigDecimal	R15_ACCOUNTS_FCY_ABOVE ;	
	private BigDecimal	R15_AMOUNT_FCY_ABOVE ;	
	private BigDecimal	R15_ACCOUNTS_AED_INACTIVE ;	
	private BigDecimal	R15_AMOUNT_AED_INACTIVE ;	
	private BigDecimal	R15_ACCOUNTS_FCY_INACTIVE ;	
	private BigDecimal	R15_AMOUNT_FCY_INACTIVE ;	
	private BigDecimal	R15_ACCOUNTS_AED_DORMANT ;	
	private BigDecimal	R15_AMOUNT_AED_DORMANT ;	
	private BigDecimal	R15_ACCOUNTS_FCY_DORMANT ;	
	private BigDecimal	R15_AMOUNT_FCY_DORMANT ;	
	private String	R16_S_NO ;	
	private String	R16_REGULATIONS ;	
	private String	R16_DORMANT ;	
	private BigDecimal	R16_ACCOUNTS_AED_1YEAR ;	
	private BigDecimal	R16_AMOUNT_AED_1YEAR ;	
	private BigDecimal	R16_ACCOUNTS_FCY_1YEAR ;	
	private BigDecimal	R16_AMOUNT_FCY_1YEAR ;	
	private BigDecimal	R16_ACCOUNTS_AED_2YEAR ;	
	private BigDecimal	R16_AMOUNT_AED_2YEAR ;	
	private BigDecimal	R16_ACCOUNTS_FCY_2YEAR ;	
	private BigDecimal	R16_AMOUNT_FCY_2YEAR ;	
	private BigDecimal	R16_ACCOUNTS_AED_3YEAR ;	
	private BigDecimal	R16_AMOUNT_AED_3YEAR ;	
	private BigDecimal	R16_ACCOUNTS_FCY_3YEAR ;	
	private BigDecimal	R16_AMOUNT_FCY_3YEAR ;	
	private BigDecimal	R16_ACCOUNTS_AED_5YEAR ;	
	private BigDecimal	R16_AMOUNT_AED_5YEAR ;	
	private BigDecimal	R16_ACCOUNTS_FCY_5YEAR ;	
	private BigDecimal	R16_AMOUNT_FCY_5YEAR ;	
	private BigDecimal	R16_ACCOUNTS_AED_ABOVE ;	
	private BigDecimal	R16_AMOUNT_AED_ABOVE ;	
	private BigDecimal	R16_ACCOUNTS_FCY_ABOVE ;	
	private BigDecimal	R16_AMOUNT_FCY_ABOVE ;	
	private BigDecimal	R16_ACCOUNTS_AED_INACTIVE ;	
	private BigDecimal	R16_AMOUNT_AED_INACTIVE ;	
	private BigDecimal	R16_ACCOUNTS_FCY_INACTIVE ;	
	private BigDecimal	R16_AMOUNT_FCY_INACTIVE ;	
	private BigDecimal	R16_ACCOUNTS_AED_DORMANT ;	
	private BigDecimal	R16_AMOUNT_AED_DORMANT ;	
	private BigDecimal	R16_ACCOUNTS_FCY_DORMANT ;	
	private BigDecimal	R16_AMOUNT_FCY_DORMANT ;	
	private String	R17_S_NO ;	
	private String	R17_REGULATIONS ;	
	private String	R17_DORMANT ;	
	private BigDecimal	R17_ACCOUNTS_AED_1YEAR ;	
	private BigDecimal	R17_AMOUNT_AED_1YEAR ;	
	private BigDecimal	R17_ACCOUNTS_FCY_1YEAR ;	
	private BigDecimal	R17_AMOUNT_FCY_1YEAR ;	
	private BigDecimal	R17_ACCOUNTS_AED_2YEAR ;	
	private BigDecimal	R17_AMOUNT_AED_2YEAR ;	
	private BigDecimal	R17_ACCOUNTS_FCY_2YEAR ;	
	private BigDecimal	R17_AMOUNT_FCY_2YEAR ;	
	private BigDecimal	R17_ACCOUNTS_AED_3YEAR ;	
	private BigDecimal	R17_AMOUNT_AED_3YEAR ;	
	private BigDecimal	R17_ACCOUNTS_FCY_3YEAR ;	
	private BigDecimal	R17_AMOUNT_FCY_3YEAR ;	
	private BigDecimal	R17_ACCOUNTS_AED_5YEAR ;	
	private BigDecimal	R17_AMOUNT_AED_5YEAR ;	
	private BigDecimal	R17_ACCOUNTS_FCY_5YEAR ;	
	private BigDecimal	R17_AMOUNT_FCY_5YEAR ;	
	private BigDecimal	R17_ACCOUNTS_AED_ABOVE ;	
	private BigDecimal	R17_AMOUNT_AED_ABOVE ;	
	private BigDecimal	R17_ACCOUNTS_FCY_ABOVE ;	
	private BigDecimal	R17_AMOUNT_FCY_ABOVE ;	
	private BigDecimal	R17_ACCOUNTS_AED_INACTIVE ;	
	private BigDecimal	R17_AMOUNT_AED_INACTIVE ;	
	private BigDecimal	R17_ACCOUNTS_FCY_INACTIVE ;	
	private BigDecimal	R17_AMOUNT_FCY_INACTIVE ;	
	private BigDecimal	R17_ACCOUNTS_AED_DORMANT ;	
	private BigDecimal	R17_AMOUNT_AED_DORMANT ;	
	private BigDecimal	R17_ACCOUNTS_FCY_DORMANT ;	
	private BigDecimal	R17_AMOUNT_FCY_DORMANT ;	
	private String	R18_S_NO ;	
	private String	R18_REGULATIONS ;	
	private String	R18_DORMANT ;	
	private BigDecimal	R18_ACCOUNTS_AED_1YEAR ;	
	private BigDecimal	R18_AMOUNT_AED_1YEAR ;	
	private BigDecimal	R18_ACCOUNTS_FCY_1YEAR ;	
	private BigDecimal	R18_AMOUNT_FCY_1YEAR ;	
	private BigDecimal	R18_ACCOUNTS_AED_2YEAR ;	
	private BigDecimal	R18_AMOUNT_AED_2YEAR ;	
	private BigDecimal	R18_ACCOUNTS_FCY_2YEAR ;	
	private BigDecimal	R18_AMOUNT_FCY_2YEAR ;	
	private BigDecimal	R18_ACCOUNTS_AED_3YEAR ;	
	private BigDecimal	R18_AMOUNT_AED_3YEAR ;	
	private BigDecimal	R18_ACCOUNTS_FCY_3YEAR ;	
	private BigDecimal	R18_AMOUNT_FCY_3YEAR ;	
	private BigDecimal	R18_ACCOUNTS_AED_5YEAR ;	
	private BigDecimal	R18_AMOUNT_AED_5YEAR ;	
	private BigDecimal	R18_ACCOUNTS_FCY_5YEAR ;	
	private BigDecimal	R18_AMOUNT_FCY_5YEAR ;	
	private BigDecimal	R18_ACCOUNTS_AED_ABOVE ;	
	private BigDecimal	R18_AMOUNT_AED_ABOVE ;	
	private BigDecimal	R18_ACCOUNTS_FCY_ABOVE ;	
	private BigDecimal	R18_AMOUNT_FCY_ABOVE ;	
	private BigDecimal	R18_ACCOUNTS_AED_INACTIVE ;	
	private BigDecimal	R18_AMOUNT_AED_INACTIVE ;	
	private BigDecimal	R18_ACCOUNTS_FCY_INACTIVE ;	
	private BigDecimal	R18_AMOUNT_FCY_INACTIVE ;	
	private BigDecimal	R18_ACCOUNTS_AED_DORMANT ;	
	private BigDecimal	R18_AMOUNT_AED_DORMANT ;	
	private BigDecimal	R18_ACCOUNTS_FCY_DORMANT ;	
	private BigDecimal	R18_AMOUNT_FCY_DORMANT ;	
	private String	R19_S_NO ;	
	private String	R19_REGULATIONS ;	
	private String	R19_DORMANT ;	
	private BigDecimal	R19_ACCOUNTS_AED_1YEAR ;	
	private BigDecimal	R19_AMOUNT_AED_1YEAR ;	
	private BigDecimal	R19_ACCOUNTS_FCY_1YEAR ;	
	private BigDecimal	R19_AMOUNT_FCY_1YEAR ;	
	private BigDecimal	R19_ACCOUNTS_AED_2YEAR ;	
	private BigDecimal	R19_AMOUNT_AED_2YEAR ;	
	private BigDecimal	R19_ACCOUNTS_FCY_2YEAR ;	
	private BigDecimal	R19_AMOUNT_FCY_2YEAR ;	
	private BigDecimal	R19_ACCOUNTS_AED_3YEAR ;	
	private BigDecimal	R19_AMOUNT_AED_3YEAR ;	
	private BigDecimal	R19_ACCOUNTS_FCY_3YEAR ;	
	private BigDecimal	R19_AMOUNT_FCY_3YEAR ;	
	private BigDecimal	R19_ACCOUNTS_AED_5YEAR ;	
	private BigDecimal	R19_AMOUNT_AED_5YEAR ;	
	private BigDecimal	R19_ACCOUNTS_FCY_5YEAR ;	
	private BigDecimal	R19_AMOUNT_FCY_5YEAR ;	
	private BigDecimal	R19_ACCOUNTS_AED_ABOVE ;	
	private BigDecimal	R19_AMOUNT_AED_ABOVE ;	
	private BigDecimal	R19_ACCOUNTS_FCY_ABOVE ;	
	private BigDecimal	R19_AMOUNT_FCY_ABOVE ;	
	private BigDecimal	R19_ACCOUNTS_AED_INACTIVE ;	
	private BigDecimal	R19_AMOUNT_AED_INACTIVE ;	
	private BigDecimal	R19_ACCOUNTS_FCY_INACTIVE ;	
	private BigDecimal	R19_AMOUNT_FCY_INACTIVE ;	
	private BigDecimal	R19_ACCOUNTS_AED_DORMANT ;	
	private BigDecimal	R19_AMOUNT_AED_DORMANT ;	
	private BigDecimal	R19_ACCOUNTS_FCY_DORMANT ;	
	private BigDecimal	R19_AMOUNT_FCY_DORMANT ;	
	private String	R20_S_NO ;	
	private String	R20_REGULATIONS ;	
	private String	R20_DORMANT ;	
	private BigDecimal	R20_ACCOUNTS_AED_1YEAR ;	
	private BigDecimal	R20_AMOUNT_AED_1YEAR ;	
	private BigDecimal	R20_ACCOUNTS_FCY_1YEAR ;	
	private BigDecimal	R20_AMOUNT_FCY_1YEAR ;	
	private BigDecimal	R20_ACCOUNTS_AED_2YEAR ;	
	private BigDecimal	R20_AMOUNT_AED_2YEAR ;	
	private BigDecimal	R20_ACCOUNTS_FCY_2YEAR ;	
	private BigDecimal	R20_AMOUNT_FCY_2YEAR ;	
	private BigDecimal	R20_ACCOUNTS_AED_3YEAR ;	
	private BigDecimal	R20_AMOUNT_AED_3YEAR ;	
	private BigDecimal	R20_ACCOUNTS_FCY_3YEAR ;	
	private BigDecimal	R20_AMOUNT_FCY_3YEAR ;	
	private BigDecimal	R20_ACCOUNTS_AED_5YEAR ;	
	private BigDecimal	R20_AMOUNT_AED_5YEAR ;	
	private BigDecimal	R20_ACCOUNTS_FCY_5YEAR ;	
	private BigDecimal	R20_AMOUNT_FCY_5YEAR ;	
	private BigDecimal	R20_ACCOUNTS_AED_ABOVE ;	
	private BigDecimal	R20_AMOUNT_AED_ABOVE ;	
	private BigDecimal	R20_ACCOUNTS_FCY_ABOVE ;	
	private BigDecimal	R20_AMOUNT_FCY_ABOVE ;	
	private BigDecimal	R20_ACCOUNTS_AED_INACTIVE ;	
	private BigDecimal	R20_AMOUNT_AED_INACTIVE ;	
	private BigDecimal	R20_ACCOUNTS_FCY_INACTIVE ;	
	private BigDecimal	R20_AMOUNT_FCY_INACTIVE ;	
	private BigDecimal	R20_ACCOUNTS_AED_DORMANT ;	
	private BigDecimal	R20_AMOUNT_AED_DORMANT ;	
	private BigDecimal	R20_ACCOUNTS_FCY_DORMANT ;	
	private BigDecimal	R20_AMOUNT_FCY_DORMANT ;	
	private String	R21_S_NO ;	
	private String	R21_REGULATIONS ;	
	private String	R21_DORMANT ;	
	private BigDecimal	R21_ACCOUNTS_AED_1YEAR ;	
	private BigDecimal	R21_AMOUNT_AED_1YEAR ;	
	private BigDecimal	R21_ACCOUNTS_FCY_1YEAR ;	
	private BigDecimal	R21_AMOUNT_FCY_1YEAR ;	
	private BigDecimal	R21_ACCOUNTS_AED_2YEAR ;	
	private BigDecimal	R21_AMOUNT_AED_2YEAR ;	
	private BigDecimal	R21_ACCOUNTS_FCY_2YEAR ;	
	private BigDecimal	R21_AMOUNT_FCY_2YEAR ;	
	private BigDecimal	R21_ACCOUNTS_AED_3YEAR ;	
	private BigDecimal	R21_AMOUNT_AED_3YEAR ;	
	private BigDecimal	R21_ACCOUNTS_FCY_3YEAR ;	
	private BigDecimal	R21_AMOUNT_FCY_3YEAR ;	
	private BigDecimal	R21_ACCOUNTS_AED_5YEAR ;	
	private BigDecimal	R21_AMOUNT_AED_5YEAR ;	
	private BigDecimal	R21_ACCOUNTS_FCY_5YEAR ;	
	private BigDecimal	R21_AMOUNT_FCY_5YEAR ;	
	private BigDecimal	R21_ACCOUNTS_AED_ABOVE ;	
	private BigDecimal	R21_AMOUNT_AED_ABOVE ;	
	private BigDecimal	R21_ACCOUNTS_FCY_ABOVE ;	
	private BigDecimal	R21_AMOUNT_FCY_ABOVE ;	
	private BigDecimal	R21_ACCOUNTS_AED_INACTIVE ;	
	private BigDecimal	R21_AMOUNT_AED_INACTIVE ;	
	private BigDecimal	R21_ACCOUNTS_FCY_INACTIVE ;	
	private BigDecimal	R21_AMOUNT_FCY_INACTIVE ;	
	private BigDecimal	R21_ACCOUNTS_AED_DORMANT ;	
	private BigDecimal	R21_AMOUNT_AED_DORMANT ;	
	private BigDecimal	R21_ACCOUNTS_FCY_DORMANT ;	
	private BigDecimal	R21_AMOUNT_FCY_DORMANT ;	
	private String	R22_S_NO ;	
	private String	R22_REGULATIONS ;	
	private String	R22_DORMANT ;	
	private BigDecimal	R22_ACCOUNTS_AED_1YEAR ;	
	private BigDecimal	R22_AMOUNT_AED_1YEAR ;	
	private BigDecimal	R22_ACCOUNTS_FCY_1YEAR ;	
	private BigDecimal	R22_AMOUNT_FCY_1YEAR ;	
	private BigDecimal	R22_ACCOUNTS_AED_2YEAR ;	
	private BigDecimal	R22_AMOUNT_AED_2YEAR ;	
	private BigDecimal	R22_ACCOUNTS_FCY_2YEAR ;	
	private BigDecimal	R22_AMOUNT_FCY_2YEAR ;	
	private BigDecimal	R22_ACCOUNTS_AED_3YEAR ;	
	private BigDecimal	R22_AMOUNT_AED_3YEAR ;	
	private BigDecimal	R22_ACCOUNTS_FCY_3YEAR ;	
	private BigDecimal	R22_AMOUNT_FCY_3YEAR ;	
	private BigDecimal	R22_ACCOUNTS_AED_5YEAR ;	
	private BigDecimal	R22_AMOUNT_AED_5YEAR ;	
	private BigDecimal	R22_ACCOUNTS_FCY_5YEAR ;	
	private BigDecimal	R22_AMOUNT_FCY_5YEAR ;	
	private BigDecimal	R22_ACCOUNTS_AED_ABOVE ;	
	private BigDecimal	R22_AMOUNT_AED_ABOVE ;	
	private BigDecimal	R22_ACCOUNTS_FCY_ABOVE ;	
	private BigDecimal	R22_AMOUNT_FCY_ABOVE ;	
	private BigDecimal	R22_ACCOUNTS_AED_INACTIVE ;	
	private BigDecimal	R22_AMOUNT_AED_INACTIVE ;	
	private BigDecimal	R22_ACCOUNTS_FCY_INACTIVE ;	
	private BigDecimal	R22_AMOUNT_FCY_INACTIVE ;	
	private BigDecimal	R22_ACCOUNTS_AED_DORMANT ;	
	private BigDecimal	R22_AMOUNT_AED_DORMANT ;	
	private BigDecimal	R22_ACCOUNTS_FCY_DORMANT ;	
	private BigDecimal	R22_AMOUNT_FCY_DORMANT ;	
	private String	R23_S_NO ;	
	private String	R23_REGULATIONS ;	
	private String	R23_DORMANT ;	
	private BigDecimal	R23_ACCOUNTS_AED_1YEAR ;	
	private BigDecimal	R23_AMOUNT_AED_1YEAR ;	
	private BigDecimal	R23_ACCOUNTS_FCY_1YEAR ;	
	private BigDecimal	R23_AMOUNT_FCY_1YEAR ;	
	private BigDecimal	R23_ACCOUNTS_AED_2YEAR ;	
	private BigDecimal	R23_AMOUNT_AED_2YEAR ;	
	private BigDecimal	R23_ACCOUNTS_FCY_2YEAR ;	
	private BigDecimal	R23_AMOUNT_FCY_2YEAR ;	
	private BigDecimal	R23_ACCOUNTS_AED_3YEAR ;	
	private BigDecimal	R23_AMOUNT_AED_3YEAR ;	
	private BigDecimal	R23_ACCOUNTS_FCY_3YEAR ;	
	private BigDecimal	R23_AMOUNT_FCY_3YEAR ;	
	private BigDecimal	R23_ACCOUNTS_AED_5YEAR ;	
	private BigDecimal	R23_AMOUNT_AED_5YEAR ;	
	private BigDecimal	R23_ACCOUNTS_FCY_5YEAR ;	
	private BigDecimal	R23_AMOUNT_FCY_5YEAR ;	
	private BigDecimal	R23_ACCOUNTS_AED_ABOVE ;	
	private BigDecimal	R23_AMOUNT_AED_ABOVE ;	
	private BigDecimal	R23_ACCOUNTS_FCY_ABOVE ;	
	private BigDecimal	R23_AMOUNT_FCY_ABOVE ;	
	private BigDecimal	R23_ACCOUNTS_AED_INACTIVE ;	
	private BigDecimal	R23_AMOUNT_AED_INACTIVE ;	
	private BigDecimal	R23_ACCOUNTS_FCY_INACTIVE ;	
	private BigDecimal	R23_AMOUNT_FCY_INACTIVE ;	
	private BigDecimal	R23_ACCOUNTS_AED_DORMANT ;	
	private BigDecimal	R23_AMOUNT_AED_DORMANT ;	
	private BigDecimal	R23_ACCOUNTS_FCY_DORMANT ;	
	private BigDecimal	R23_AMOUNT_FCY_DORMANT ;	
	private String	R24_S_NO ;	
	private String	R24_REGULATIONS ;	
	private String	R24_DORMANT ;	
	private BigDecimal	R24_ACCOUNTS_AED_1YEAR ;	
	private BigDecimal	R24_AMOUNT_AED_1YEAR ;	
	private BigDecimal	R24_ACCOUNTS_FCY_1YEAR ;	
	private BigDecimal	R24_AMOUNT_FCY_1YEAR ;	
	private BigDecimal	R24_ACCOUNTS_AED_2YEAR ;	
	private BigDecimal	R24_AMOUNT_AED_2YEAR ;	
	private BigDecimal	R24_ACCOUNTS_FCY_2YEAR ;	
	private BigDecimal	R24_AMOUNT_FCY_2YEAR ;	
	private BigDecimal	R24_ACCOUNTS_AED_3YEAR ;	
	private BigDecimal	R24_AMOUNT_AED_3YEAR ;	
	private BigDecimal	R24_ACCOUNTS_FCY_3YEAR ;	
	private BigDecimal	R24_AMOUNT_FCY_3YEAR ;	
	private BigDecimal	R24_ACCOUNTS_AED_5YEAR ;	
	private BigDecimal	R24_AMOUNT_AED_5YEAR ;	
	private BigDecimal	R24_ACCOUNTS_FCY_5YEAR ;	
	private BigDecimal	R24_AMOUNT_FCY_5YEAR ;	
	private BigDecimal	R24_ACCOUNTS_AED_ABOVE ;	
	private BigDecimal	R24_AMOUNT_AED_ABOVE ;	
	private BigDecimal	R24_ACCOUNTS_FCY_ABOVE ;	
	private BigDecimal	R24_AMOUNT_FCY_ABOVE ;	
	private BigDecimal	R24_ACCOUNTS_AED_INACTIVE ;	
	private BigDecimal	R24_AMOUNT_AED_INACTIVE ;	
	private BigDecimal	R24_ACCOUNTS_FCY_INACTIVE ;	
	private BigDecimal	R24_AMOUNT_FCY_INACTIVE ;	
	private BigDecimal	R24_ACCOUNTS_AED_DORMANT ;	
	private BigDecimal	R24_AMOUNT_AED_DORMANT ;	
	private BigDecimal	R24_ACCOUNTS_FCY_DORMANT ;	
	private BigDecimal	R24_AMOUNT_FCY_DORMANT ;	
	private String	R25_S_NO ;	
	private String	R25_REGULATIONS ;	
	private String	R25_DORMANT ;	
	private BigDecimal	R25_ACCOUNTS_AED_1YEAR ;	
	private BigDecimal	R25_AMOUNT_AED_1YEAR ;	
	private BigDecimal	R25_ACCOUNTS_FCY_1YEAR ;	
	private BigDecimal	R25_AMOUNT_FCY_1YEAR ;	
	private BigDecimal	R25_ACCOUNTS_AED_2YEAR ;	
	private BigDecimal	R25_AMOUNT_AED_2YEAR ;	
	private BigDecimal	R25_ACCOUNTS_FCY_2YEAR ;	
	private BigDecimal	R25_AMOUNT_FCY_2YEAR ;	
	private BigDecimal	R25_ACCOUNTS_AED_3YEAR ;	
	private BigDecimal	R25_AMOUNT_AED_3YEAR ;	
	private BigDecimal	R25_ACCOUNTS_FCY_3YEAR ;	
	private BigDecimal	R25_AMOUNT_FCY_3YEAR ;	
	private BigDecimal	R25_ACCOUNTS_AED_5YEAR ;	
	private BigDecimal	R25_AMOUNT_AED_5YEAR ;	
	private BigDecimal	R25_ACCOUNTS_FCY_5YEAR ;	
	private BigDecimal	R25_AMOUNT_FCY_5YEAR ;	
	private BigDecimal	R25_ACCOUNTS_AED_ABOVE ;	
	private BigDecimal	R25_AMOUNT_AED_ABOVE ;	
	private BigDecimal	R25_ACCOUNTS_FCY_ABOVE ;	
	private BigDecimal	R25_AMOUNT_FCY_ABOVE ;	
	private BigDecimal	R25_ACCOUNTS_AED_INACTIVE ;	
	private BigDecimal	R25_AMOUNT_AED_INACTIVE ;	
	private BigDecimal	R25_ACCOUNTS_FCY_INACTIVE ;	
	private BigDecimal	R25_AMOUNT_FCY_INACTIVE ;	
	private BigDecimal	R25_ACCOUNTS_AED_DORMANT ;	
	private BigDecimal	R25_AMOUNT_AED_DORMANT ;	
	private BigDecimal	R25_ACCOUNTS_FCY_DORMANT ;	
	private BigDecimal	R25_AMOUNT_FCY_DORMANT ;	
	private String	R26_S_NO ;	
	private String	R26_REGULATIONS ;	
	private String	R26_DORMANT ;	
	private BigDecimal	R26_ACCOUNTS_AED_1YEAR ;	
	private BigDecimal	R26_AMOUNT_AED_1YEAR ;	
	private BigDecimal	R26_ACCOUNTS_FCY_1YEAR ;	
	private BigDecimal	R26_AMOUNT_FCY_1YEAR ;	
	private BigDecimal	R26_ACCOUNTS_AED_2YEAR ;	
	private BigDecimal	R26_AMOUNT_AED_2YEAR ;	
	private BigDecimal	R26_ACCOUNTS_FCY_2YEAR ;	
	private BigDecimal	R26_AMOUNT_FCY_2YEAR ;	
	private BigDecimal	R26_ACCOUNTS_AED_3YEAR ;	
	private BigDecimal	R26_AMOUNT_AED_3YEAR ;	
	private BigDecimal	R26_ACCOUNTS_FCY_3YEAR ;	
	private BigDecimal	R26_AMOUNT_FCY_3YEAR ;	
	private BigDecimal	R26_ACCOUNTS_AED_5YEAR ;	
	private BigDecimal	R26_AMOUNT_AED_5YEAR ;	
	private BigDecimal	R26_ACCOUNTS_FCY_5YEAR ;	
	private BigDecimal	R26_AMOUNT_FCY_5YEAR ;	
	private BigDecimal	R26_ACCOUNTS_AED_ABOVE ;	
	private BigDecimal	R26_AMOUNT_AED_ABOVE ;	
	private BigDecimal	R26_ACCOUNTS_FCY_ABOVE ;	
	private BigDecimal	R26_AMOUNT_FCY_ABOVE ;	
	private BigDecimal	R26_ACCOUNTS_AED_INACTIVE ;	
	private BigDecimal	R26_AMOUNT_AED_INACTIVE ;	
	private BigDecimal	R26_ACCOUNTS_FCY_INACTIVE ;	
	private BigDecimal	R26_AMOUNT_FCY_INACTIVE ;	
	private BigDecimal	R26_ACCOUNTS_AED_DORMANT ;	
	private BigDecimal	R26_AMOUNT_AED_DORMANT ;	
	private BigDecimal	R26_ACCOUNTS_FCY_DORMANT ;	
	private BigDecimal	R26_AMOUNT_FCY_DORMANT ;	
	private String	R27_S_NO ;	
	private String	R27_REGULATIONS ;	
	private String	R27_DORMANT ;	
	private BigDecimal	R27_ACCOUNTS_AED_1YEAR ;	
	private BigDecimal	R27_AMOUNT_AED_1YEAR ;	
	private BigDecimal	R27_ACCOUNTS_FCY_1YEAR ;	
	private BigDecimal	R27_AMOUNT_FCY_1YEAR ;	
	private BigDecimal	R27_ACCOUNTS_AED_2YEAR ;	
	private BigDecimal	R27_AMOUNT_AED_2YEAR ;	
	private BigDecimal	R27_ACCOUNTS_FCY_2YEAR ;	
	private BigDecimal	R27_AMOUNT_FCY_2YEAR ;	
	private BigDecimal	R27_ACCOUNTS_AED_3YEAR ;	
	private BigDecimal	R27_AMOUNT_AED_3YEAR ;	
	private BigDecimal	R27_ACCOUNTS_FCY_3YEAR ;	
	private BigDecimal	R27_AMOUNT_FCY_3YEAR ;	
	private BigDecimal	R27_ACCOUNTS_AED_5YEAR ;	
	private BigDecimal	R27_AMOUNT_AED_5YEAR ;	
	private BigDecimal	R27_ACCOUNTS_FCY_5YEAR ;	
	private BigDecimal	R27_AMOUNT_FCY_5YEAR ;	
	private BigDecimal	R27_ACCOUNTS_AED_ABOVE ;	
	private BigDecimal	R27_AMOUNT_AED_ABOVE ;	
	private BigDecimal	R27_ACCOUNTS_FCY_ABOVE ;	
	private BigDecimal	R27_AMOUNT_FCY_ABOVE ;	
	private BigDecimal	R27_ACCOUNTS_AED_INACTIVE ;	
	private BigDecimal	R27_AMOUNT_AED_INACTIVE ;	
	private BigDecimal	R27_ACCOUNTS_FCY_INACTIVE ;	
	private BigDecimal	R27_AMOUNT_FCY_INACTIVE ;	
	private BigDecimal	R27_ACCOUNTS_AED_DORMANT ;	
	private BigDecimal	R27_AMOUNT_AED_DORMANT ;	
	private BigDecimal	R27_ACCOUNTS_FCY_DORMANT ;	
	private BigDecimal	R27_AMOUNT_FCY_DORMANT ;	
	private String	R28_S_NO ;	
	private String	R28_REGULATIONS ;	
	private String	R28_DORMANT ;	
	private BigDecimal	R28_ACCOUNTS_AED_1YEAR ;	
	private BigDecimal	R28_AMOUNT_AED_1YEAR ;	
	private BigDecimal	R28_ACCOUNTS_FCY_1YEAR ;	
	private BigDecimal	R28_AMOUNT_FCY_1YEAR ;	
	private BigDecimal	R28_ACCOUNTS_AED_2YEAR ;	
	private BigDecimal	R28_AMOUNT_AED_2YEAR ;	
	private BigDecimal	R28_ACCOUNTS_FCY_2YEAR ;	
	private BigDecimal	R28_AMOUNT_FCY_2YEAR ;	
	private BigDecimal	R28_ACCOUNTS_AED_3YEAR ;	
	private BigDecimal	R28_AMOUNT_AED_3YEAR ;	
	private BigDecimal	R28_ACCOUNTS_FCY_3YEAR ;	
	private BigDecimal	R28_AMOUNT_FCY_3YEAR ;	
	private BigDecimal	R28_ACCOUNTS_AED_5YEAR ;	
	private BigDecimal	R28_AMOUNT_AED_5YEAR ;	
	private BigDecimal	R28_ACCOUNTS_FCY_5YEAR ;	
	private BigDecimal	R28_AMOUNT_FCY_5YEAR ;	
	private BigDecimal	R28_ACCOUNTS_AED_ABOVE ;	
	private BigDecimal	R28_AMOUNT_AED_ABOVE ;	
	private BigDecimal	R28_ACCOUNTS_FCY_ABOVE ;	
	private BigDecimal	R28_AMOUNT_FCY_ABOVE ;	
	private BigDecimal	R28_ACCOUNTS_AED_INACTIVE ;	
	private BigDecimal	R28_AMOUNT_AED_INACTIVE ;	
	private BigDecimal	R28_ACCOUNTS_FCY_INACTIVE ;	
	private BigDecimal	R28_AMOUNT_FCY_INACTIVE ;	
	private BigDecimal	R28_ACCOUNTS_AED_DORMANT ;	
	private BigDecimal	R28_AMOUNT_AED_DORMANT ;	
	private BigDecimal	R28_ACCOUNTS_FCY_DORMANT ;	
	private BigDecimal	R28_AMOUNT_FCY_DORMANT ;	
	private String	R29_S_NO ;	
	private String	R29_REGULATIONS ;	
	private String	R29_DORMANT ;	
	private BigDecimal	R29_ACCOUNTS_AED_1YEAR ;	
	private BigDecimal	R29_AMOUNT_AED_1YEAR ;	
	private BigDecimal	R29_ACCOUNTS_FCY_1YEAR ;	
	private BigDecimal	R29_AMOUNT_FCY_1YEAR ;	
	private BigDecimal	R29_ACCOUNTS_AED_2YEAR ;	
	private BigDecimal	R29_AMOUNT_AED_2YEAR ;	
	private BigDecimal	R29_ACCOUNTS_FCY_2YEAR ;	
	private BigDecimal	R29_AMOUNT_FCY_2YEAR ;	
	private BigDecimal	R29_ACCOUNTS_AED_3YEAR ;	
	private BigDecimal	R29_AMOUNT_AED_3YEAR ;	
	private BigDecimal	R29_ACCOUNTS_FCY_3YEAR ;	
	private BigDecimal	R29_AMOUNT_FCY_3YEAR ;	
	private BigDecimal	R29_ACCOUNTS_AED_5YEAR ;	
	private BigDecimal	R29_AMOUNT_AED_5YEAR ;	
	private BigDecimal	R29_ACCOUNTS_FCY_5YEAR ;	
	private BigDecimal	R29_AMOUNT_FCY_5YEAR ;	
	private BigDecimal	R29_ACCOUNTS_AED_ABOVE ;	
	private BigDecimal	R29_AMOUNT_AED_ABOVE ;	
	private BigDecimal	R29_ACCOUNTS_FCY_ABOVE ;	
	private BigDecimal	R29_AMOUNT_FCY_ABOVE ;	
	private BigDecimal	R29_ACCOUNTS_AED_INACTIVE ;	
	private BigDecimal	R29_AMOUNT_AED_INACTIVE ;	
	private BigDecimal	R29_ACCOUNTS_FCY_INACTIVE ;	
	private BigDecimal	R29_AMOUNT_FCY_INACTIVE ;	
	private BigDecimal	R29_ACCOUNTS_AED_DORMANT ;	
	private BigDecimal	R29_AMOUNT_AED_DORMANT ;	
	private BigDecimal	R29_ACCOUNTS_FCY_DORMANT ;	
	private BigDecimal	R29_AMOUNT_FCY_DORMANT ;	
	private String	R30_S_NO ;	
	private String	R30_REGULATIONS ;	
	private String	R30_DORMANT ;	
	private BigDecimal	R30_ACCOUNTS_AED_1YEAR ;	
	private BigDecimal	R30_AMOUNT_AED_1YEAR ;	
	private BigDecimal	R30_ACCOUNTS_FCY_1YEAR ;	
	private BigDecimal	R30_AMOUNT_FCY_1YEAR ;	
	private BigDecimal	R30_ACCOUNTS_AED_2YEAR ;	
	private BigDecimal	R30_AMOUNT_AED_2YEAR ;	
	private BigDecimal	R30_ACCOUNTS_FCY_2YEAR ;	
	private BigDecimal	R30_AMOUNT_FCY_2YEAR ;	
	private BigDecimal	R30_ACCOUNTS_AED_3YEAR ;	
	private BigDecimal	R30_AMOUNT_AED_3YEAR ;	
	private BigDecimal	R30_ACCOUNTS_FCY_3YEAR ;	
	private BigDecimal	R30_AMOUNT_FCY_3YEAR ;	
	private BigDecimal	R30_ACCOUNTS_AED_5YEAR ;	
	private BigDecimal	R30_AMOUNT_AED_5YEAR ;	
	private BigDecimal	R30_ACCOUNTS_FCY_5YEAR ;	
	private BigDecimal	R30_AMOUNT_FCY_5YEAR ;	
	private BigDecimal	R30_ACCOUNTS_AED_ABOVE ;	
	private BigDecimal	R30_AMOUNT_AED_ABOVE ;	
	private BigDecimal	R30_ACCOUNTS_FCY_ABOVE ;	
	private BigDecimal	R30_AMOUNT_FCY_ABOVE ;	
	private BigDecimal	R30_ACCOUNTS_AED_INACTIVE ;	
	private BigDecimal	R30_AMOUNT_AED_INACTIVE ;	
	private BigDecimal	R30_ACCOUNTS_FCY_INACTIVE ;	
	private BigDecimal	R30_AMOUNT_FCY_INACTIVE ;	
	private BigDecimal	R30_ACCOUNTS_AED_DORMANT ;	
	private BigDecimal	R30_AMOUNT_AED_DORMANT ;	
	private BigDecimal	R30_ACCOUNTS_FCY_DORMANT ;	
	private BigDecimal	R30_AMOUNT_FCY_DORMANT ;	
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
	private String	modify_user;
	private Date	modify_time;
	private String	verify_flg;
	private String	verify_user;
	private Date	verify_time;

	private String	repdesc;
	private String	frequency;
	public String getR1_S_NO() {
		return R1_S_NO;
	}
	public void setR1_S_NO(String r1_S_NO) {
		R1_S_NO = r1_S_NO;
	}
	public String getR1_REGULATIONS() {
		return R1_REGULATIONS;
	}
	public void setR1_REGULATIONS(String r1_REGULATIONS) {
		R1_REGULATIONS = r1_REGULATIONS;
	}
	public String getR1_DORMANT() {
		return R1_DORMANT;
	}
	public void setR1_DORMANT(String r1_DORMANT) {
		R1_DORMANT = r1_DORMANT;
	}
	public BigDecimal getR1_ACCOUNTS_AED_1YEAR() {
		return R1_ACCOUNTS_AED_1YEAR;
	}
	public void setR1_ACCOUNTS_AED_1YEAR(BigDecimal r1_ACCOUNTS_AED_1YEAR) {
		R1_ACCOUNTS_AED_1YEAR = r1_ACCOUNTS_AED_1YEAR;
	}
	public BigDecimal getR1_AMOUNT_AED_1YEAR() {
		return R1_AMOUNT_AED_1YEAR;
	}
	public void setR1_AMOUNT_AED_1YEAR(BigDecimal r1_AMOUNT_AED_1YEAR) {
		R1_AMOUNT_AED_1YEAR = r1_AMOUNT_AED_1YEAR;
	}
	public BigDecimal getR1_ACCOUNTS_FCY_1YEAR() {
		return R1_ACCOUNTS_FCY_1YEAR;
	}
	public void setR1_ACCOUNTS_FCY_1YEAR(BigDecimal r1_ACCOUNTS_FCY_1YEAR) {
		R1_ACCOUNTS_FCY_1YEAR = r1_ACCOUNTS_FCY_1YEAR;
	}
	public BigDecimal getR1_AMOUNT_FCY_1YEAR() {
		return R1_AMOUNT_FCY_1YEAR;
	}
	public void setR1_AMOUNT_FCY_1YEAR(BigDecimal r1_AMOUNT_FCY_1YEAR) {
		R1_AMOUNT_FCY_1YEAR = r1_AMOUNT_FCY_1YEAR;
	}
	public BigDecimal getR1_ACCOUNTS_AED_2YEAR() {
		return R1_ACCOUNTS_AED_2YEAR;
	}
	public void setR1_ACCOUNTS_AED_2YEAR(BigDecimal r1_ACCOUNTS_AED_2YEAR) {
		R1_ACCOUNTS_AED_2YEAR = r1_ACCOUNTS_AED_2YEAR;
	}
	public BigDecimal getR1_AMOUNT_AED_2YEAR() {
		return R1_AMOUNT_AED_2YEAR;
	}
	public void setR1_AMOUNT_AED_2YEAR(BigDecimal r1_AMOUNT_AED_2YEAR) {
		R1_AMOUNT_AED_2YEAR = r1_AMOUNT_AED_2YEAR;
	}
	public BigDecimal getR1_ACCOUNTS_FCY_2YEAR() {
		return R1_ACCOUNTS_FCY_2YEAR;
	}
	public void setR1_ACCOUNTS_FCY_2YEAR(BigDecimal r1_ACCOUNTS_FCY_2YEAR) {
		R1_ACCOUNTS_FCY_2YEAR = r1_ACCOUNTS_FCY_2YEAR;
	}
	public BigDecimal getR1_AMOUNT_FCY_2YEAR() {
		return R1_AMOUNT_FCY_2YEAR;
	}
	public void setR1_AMOUNT_FCY_2YEAR(BigDecimal r1_AMOUNT_FCY_2YEAR) {
		R1_AMOUNT_FCY_2YEAR = r1_AMOUNT_FCY_2YEAR;
	}
	public BigDecimal getR1_ACCOUNTS_AED_3YEAR() {
		return R1_ACCOUNTS_AED_3YEAR;
	}
	public void setR1_ACCOUNTS_AED_3YEAR(BigDecimal r1_ACCOUNTS_AED_3YEAR) {
		R1_ACCOUNTS_AED_3YEAR = r1_ACCOUNTS_AED_3YEAR;
	}
	public BigDecimal getR1_AMOUNT_AED_3YEAR() {
		return R1_AMOUNT_AED_3YEAR;
	}
	public void setR1_AMOUNT_AED_3YEAR(BigDecimal r1_AMOUNT_AED_3YEAR) {
		R1_AMOUNT_AED_3YEAR = r1_AMOUNT_AED_3YEAR;
	}
	public BigDecimal getR1_ACCOUNTS_FCY_3YEAR() {
		return R1_ACCOUNTS_FCY_3YEAR;
	}
	public void setR1_ACCOUNTS_FCY_3YEAR(BigDecimal r1_ACCOUNTS_FCY_3YEAR) {
		R1_ACCOUNTS_FCY_3YEAR = r1_ACCOUNTS_FCY_3YEAR;
	}
	public BigDecimal getR1_AMOUNT_FCY_3YEAR() {
		return R1_AMOUNT_FCY_3YEAR;
	}
	public void setR1_AMOUNT_FCY_3YEAR(BigDecimal r1_AMOUNT_FCY_3YEAR) {
		R1_AMOUNT_FCY_3YEAR = r1_AMOUNT_FCY_3YEAR;
	}
	public BigDecimal getR1_ACCOUNTS_AED_5YEAR() {
		return R1_ACCOUNTS_AED_5YEAR;
	}
	public void setR1_ACCOUNTS_AED_5YEAR(BigDecimal r1_ACCOUNTS_AED_5YEAR) {
		R1_ACCOUNTS_AED_5YEAR = r1_ACCOUNTS_AED_5YEAR;
	}
	public BigDecimal getR1_AMOUNT_AED_5YEAR() {
		return R1_AMOUNT_AED_5YEAR;
	}
	public void setR1_AMOUNT_AED_5YEAR(BigDecimal r1_AMOUNT_AED_5YEAR) {
		R1_AMOUNT_AED_5YEAR = r1_AMOUNT_AED_5YEAR;
	}
	public BigDecimal getR1_ACCOUNTS_FCY_5YEAR() {
		return R1_ACCOUNTS_FCY_5YEAR;
	}
	public void setR1_ACCOUNTS_FCY_5YEAR(BigDecimal r1_ACCOUNTS_FCY_5YEAR) {
		R1_ACCOUNTS_FCY_5YEAR = r1_ACCOUNTS_FCY_5YEAR;
	}
	public BigDecimal getR1_AMOUNT_FCY_5YEAR() {
		return R1_AMOUNT_FCY_5YEAR;
	}
	public void setR1_AMOUNT_FCY_5YEAR(BigDecimal r1_AMOUNT_FCY_5YEAR) {
		R1_AMOUNT_FCY_5YEAR = r1_AMOUNT_FCY_5YEAR;
	}
	public BigDecimal getR1_ACCOUNTS_AED_ABOVE() {
		return R1_ACCOUNTS_AED_ABOVE;
	}
	public void setR1_ACCOUNTS_AED_ABOVE(BigDecimal r1_ACCOUNTS_AED_ABOVE) {
		R1_ACCOUNTS_AED_ABOVE = r1_ACCOUNTS_AED_ABOVE;
	}
	public BigDecimal getR1_AMOUNT_AED_ABOVE() {
		return R1_AMOUNT_AED_ABOVE;
	}
	public void setR1_AMOUNT_AED_ABOVE(BigDecimal r1_AMOUNT_AED_ABOVE) {
		R1_AMOUNT_AED_ABOVE = r1_AMOUNT_AED_ABOVE;
	}
	public BigDecimal getR1_ACCOUNTS_FCY_ABOVE() {
		return R1_ACCOUNTS_FCY_ABOVE;
	}
	public void setR1_ACCOUNTS_FCY_ABOVE(BigDecimal r1_ACCOUNTS_FCY_ABOVE) {
		R1_ACCOUNTS_FCY_ABOVE = r1_ACCOUNTS_FCY_ABOVE;
	}
	public BigDecimal getR1_AMOUNT_FCY_ABOVE() {
		return R1_AMOUNT_FCY_ABOVE;
	}
	public void setR1_AMOUNT_FCY_ABOVE(BigDecimal r1_AMOUNT_FCY_ABOVE) {
		R1_AMOUNT_FCY_ABOVE = r1_AMOUNT_FCY_ABOVE;
	}
	public BigDecimal getR1_ACCOUNTS_AED_INACTIVE() {
		return R1_ACCOUNTS_AED_INACTIVE;
	}
	public void setR1_ACCOUNTS_AED_INACTIVE(BigDecimal r1_ACCOUNTS_AED_INACTIVE) {
		R1_ACCOUNTS_AED_INACTIVE = r1_ACCOUNTS_AED_INACTIVE;
	}
	public BigDecimal getR1_AMOUNT_AED_INACTIVE() {
		return R1_AMOUNT_AED_INACTIVE;
	}
	public void setR1_AMOUNT_AED_INACTIVE(BigDecimal r1_AMOUNT_AED_INACTIVE) {
		R1_AMOUNT_AED_INACTIVE = r1_AMOUNT_AED_INACTIVE;
	}
	public BigDecimal getR1_ACCOUNTS_FCY_INACTIVE() {
		return R1_ACCOUNTS_FCY_INACTIVE;
	}
	public void setR1_ACCOUNTS_FCY_INACTIVE(BigDecimal r1_ACCOUNTS_FCY_INACTIVE) {
		R1_ACCOUNTS_FCY_INACTIVE = r1_ACCOUNTS_FCY_INACTIVE;
	}
	public BigDecimal getR1_AMOUNT_FCY_INACTIVE() {
		return R1_AMOUNT_FCY_INACTIVE;
	}
	public void setR1_AMOUNT_FCY_INACTIVE(BigDecimal r1_AMOUNT_FCY_INACTIVE) {
		R1_AMOUNT_FCY_INACTIVE = r1_AMOUNT_FCY_INACTIVE;
	}
	public BigDecimal getR1_ACCOUNTS_AED_DORMANT() {
		return R1_ACCOUNTS_AED_DORMANT;
	}
	public void setR1_ACCOUNTS_AED_DORMANT(BigDecimal r1_ACCOUNTS_AED_DORMANT) {
		R1_ACCOUNTS_AED_DORMANT = r1_ACCOUNTS_AED_DORMANT;
	}
	public BigDecimal getR1_AMOUNT_AED_DORMANT() {
		return R1_AMOUNT_AED_DORMANT;
	}
	public void setR1_AMOUNT_AED_DORMANT(BigDecimal r1_AMOUNT_AED_DORMANT) {
		R1_AMOUNT_AED_DORMANT = r1_AMOUNT_AED_DORMANT;
	}
	public BigDecimal getR1_ACCOUNTS_FCY_DORMANT() {
		return R1_ACCOUNTS_FCY_DORMANT;
	}
	public void setR1_ACCOUNTS_FCY_DORMANT(BigDecimal r1_ACCOUNTS_FCY_DORMANT) {
		R1_ACCOUNTS_FCY_DORMANT = r1_ACCOUNTS_FCY_DORMANT;
	}
	public BigDecimal getR1_AMOUNT_FCY_DORMANT() {
		return R1_AMOUNT_FCY_DORMANT;
	}
	public void setR1_AMOUNT_FCY_DORMANT(BigDecimal r1_AMOUNT_FCY_DORMANT) {
		R1_AMOUNT_FCY_DORMANT = r1_AMOUNT_FCY_DORMANT;
	}
	public String getR2_S_NO() {
		return R2_S_NO;
	}
	public void setR2_S_NO(String r2_S_NO) {
		R2_S_NO = r2_S_NO;
	}
	public String getR2_REGULATIONS() {
		return R2_REGULATIONS;
	}
	public void setR2_REGULATIONS(String r2_REGULATIONS) {
		R2_REGULATIONS = r2_REGULATIONS;
	}
	public String getR2_DORMANT() {
		return R2_DORMANT;
	}
	public void setR2_DORMANT(String r2_DORMANT) {
		R2_DORMANT = r2_DORMANT;
	}
	public BigDecimal getR2_ACCOUNTS_AED_1YEAR() {
		return R2_ACCOUNTS_AED_1YEAR;
	}
	public void setR2_ACCOUNTS_AED_1YEAR(BigDecimal r2_ACCOUNTS_AED_1YEAR) {
		R2_ACCOUNTS_AED_1YEAR = r2_ACCOUNTS_AED_1YEAR;
	}
	public BigDecimal getR2_AMOUNT_AED_1YEAR() {
		return R2_AMOUNT_AED_1YEAR;
	}
	public void setR2_AMOUNT_AED_1YEAR(BigDecimal r2_AMOUNT_AED_1YEAR) {
		R2_AMOUNT_AED_1YEAR = r2_AMOUNT_AED_1YEAR;
	}
	public BigDecimal getR2_ACCOUNTS_FCY_1YEAR() {
		return R2_ACCOUNTS_FCY_1YEAR;
	}
	public void setR2_ACCOUNTS_FCY_1YEAR(BigDecimal r2_ACCOUNTS_FCY_1YEAR) {
		R2_ACCOUNTS_FCY_1YEAR = r2_ACCOUNTS_FCY_1YEAR;
	}
	public BigDecimal getR2_AMOUNT_FCY_1YEAR() {
		return R2_AMOUNT_FCY_1YEAR;
	}
	public void setR2_AMOUNT_FCY_1YEAR(BigDecimal r2_AMOUNT_FCY_1YEAR) {
		R2_AMOUNT_FCY_1YEAR = r2_AMOUNT_FCY_1YEAR;
	}
	public BigDecimal getR2_ACCOUNTS_AED_2YEAR() {
		return R2_ACCOUNTS_AED_2YEAR;
	}
	public void setR2_ACCOUNTS_AED_2YEAR(BigDecimal r2_ACCOUNTS_AED_2YEAR) {
		R2_ACCOUNTS_AED_2YEAR = r2_ACCOUNTS_AED_2YEAR;
	}
	public BigDecimal getR2_AMOUNT_AED_2YEAR() {
		return R2_AMOUNT_AED_2YEAR;
	}
	public void setR2_AMOUNT_AED_2YEAR(BigDecimal r2_AMOUNT_AED_2YEAR) {
		R2_AMOUNT_AED_2YEAR = r2_AMOUNT_AED_2YEAR;
	}
	public BigDecimal getR2_ACCOUNTS_FCY_2YEAR() {
		return R2_ACCOUNTS_FCY_2YEAR;
	}
	public void setR2_ACCOUNTS_FCY_2YEAR(BigDecimal r2_ACCOUNTS_FCY_2YEAR) {
		R2_ACCOUNTS_FCY_2YEAR = r2_ACCOUNTS_FCY_2YEAR;
	}
	public BigDecimal getR2_AMOUNT_FCY_2YEAR() {
		return R2_AMOUNT_FCY_2YEAR;
	}
	public void setR2_AMOUNT_FCY_2YEAR(BigDecimal r2_AMOUNT_FCY_2YEAR) {
		R2_AMOUNT_FCY_2YEAR = r2_AMOUNT_FCY_2YEAR;
	}
	public BigDecimal getR2_ACCOUNTS_AED_3YEAR() {
		return R2_ACCOUNTS_AED_3YEAR;
	}
	public void setR2_ACCOUNTS_AED_3YEAR(BigDecimal r2_ACCOUNTS_AED_3YEAR) {
		R2_ACCOUNTS_AED_3YEAR = r2_ACCOUNTS_AED_3YEAR;
	}
	public BigDecimal getR2_AMOUNT_AED_3YEAR() {
		return R2_AMOUNT_AED_3YEAR;
	}
	public void setR2_AMOUNT_AED_3YEAR(BigDecimal r2_AMOUNT_AED_3YEAR) {
		R2_AMOUNT_AED_3YEAR = r2_AMOUNT_AED_3YEAR;
	}
	public BigDecimal getR2_ACCOUNTS_FCY_3YEAR() {
		return R2_ACCOUNTS_FCY_3YEAR;
	}
	public void setR2_ACCOUNTS_FCY_3YEAR(BigDecimal r2_ACCOUNTS_FCY_3YEAR) {
		R2_ACCOUNTS_FCY_3YEAR = r2_ACCOUNTS_FCY_3YEAR;
	}
	public BigDecimal getR2_AMOUNT_FCY_3YEAR() {
		return R2_AMOUNT_FCY_3YEAR;
	}
	public void setR2_AMOUNT_FCY_3YEAR(BigDecimal r2_AMOUNT_FCY_3YEAR) {
		R2_AMOUNT_FCY_3YEAR = r2_AMOUNT_FCY_3YEAR;
	}
	public BigDecimal getR2_ACCOUNTS_AED_5YEAR() {
		return R2_ACCOUNTS_AED_5YEAR;
	}
	public void setR2_ACCOUNTS_AED_5YEAR(BigDecimal r2_ACCOUNTS_AED_5YEAR) {
		R2_ACCOUNTS_AED_5YEAR = r2_ACCOUNTS_AED_5YEAR;
	}
	public BigDecimal getR2_AMOUNT_AED_5YEAR() {
		return R2_AMOUNT_AED_5YEAR;
	}
	public void setR2_AMOUNT_AED_5YEAR(BigDecimal r2_AMOUNT_AED_5YEAR) {
		R2_AMOUNT_AED_5YEAR = r2_AMOUNT_AED_5YEAR;
	}
	public BigDecimal getR2_ACCOUNTS_FCY_5YEAR() {
		return R2_ACCOUNTS_FCY_5YEAR;
	}
	public void setR2_ACCOUNTS_FCY_5YEAR(BigDecimal r2_ACCOUNTS_FCY_5YEAR) {
		R2_ACCOUNTS_FCY_5YEAR = r2_ACCOUNTS_FCY_5YEAR;
	}
	public BigDecimal getR2_AMOUNT_FCY_5YEAR() {
		return R2_AMOUNT_FCY_5YEAR;
	}
	public void setR2_AMOUNT_FCY_5YEAR(BigDecimal r2_AMOUNT_FCY_5YEAR) {
		R2_AMOUNT_FCY_5YEAR = r2_AMOUNT_FCY_5YEAR;
	}
	public BigDecimal getR2_ACCOUNTS_AED_ABOVE() {
		return R2_ACCOUNTS_AED_ABOVE;
	}
	public void setR2_ACCOUNTS_AED_ABOVE(BigDecimal r2_ACCOUNTS_AED_ABOVE) {
		R2_ACCOUNTS_AED_ABOVE = r2_ACCOUNTS_AED_ABOVE;
	}
	public BigDecimal getR2_AMOUNT_AED_ABOVE() {
		return R2_AMOUNT_AED_ABOVE;
	}
	public void setR2_AMOUNT_AED_ABOVE(BigDecimal r2_AMOUNT_AED_ABOVE) {
		R2_AMOUNT_AED_ABOVE = r2_AMOUNT_AED_ABOVE;
	}
	public BigDecimal getR2_ACCOUNTS_FCY_ABOVE() {
		return R2_ACCOUNTS_FCY_ABOVE;
	}
	public void setR2_ACCOUNTS_FCY_ABOVE(BigDecimal r2_ACCOUNTS_FCY_ABOVE) {
		R2_ACCOUNTS_FCY_ABOVE = r2_ACCOUNTS_FCY_ABOVE;
	}
	public BigDecimal getR2_AMOUNT_FCY_ABOVE() {
		return R2_AMOUNT_FCY_ABOVE;
	}
	public void setR2_AMOUNT_FCY_ABOVE(BigDecimal r2_AMOUNT_FCY_ABOVE) {
		R2_AMOUNT_FCY_ABOVE = r2_AMOUNT_FCY_ABOVE;
	}
	public BigDecimal getR2_ACCOUNTS_AED_INACTIVE() {
		return R2_ACCOUNTS_AED_INACTIVE;
	}
	public void setR2_ACCOUNTS_AED_INACTIVE(BigDecimal r2_ACCOUNTS_AED_INACTIVE) {
		R2_ACCOUNTS_AED_INACTIVE = r2_ACCOUNTS_AED_INACTIVE;
	}
	public BigDecimal getR2_AMOUNT_AED_INACTIVE() {
		return R2_AMOUNT_AED_INACTIVE;
	}
	public void setR2_AMOUNT_AED_INACTIVE(BigDecimal r2_AMOUNT_AED_INACTIVE) {
		R2_AMOUNT_AED_INACTIVE = r2_AMOUNT_AED_INACTIVE;
	}
	public BigDecimal getR2_ACCOUNTS_FCY_INACTIVE() {
		return R2_ACCOUNTS_FCY_INACTIVE;
	}
	public void setR2_ACCOUNTS_FCY_INACTIVE(BigDecimal r2_ACCOUNTS_FCY_INACTIVE) {
		R2_ACCOUNTS_FCY_INACTIVE = r2_ACCOUNTS_FCY_INACTIVE;
	}
	public BigDecimal getR2_AMOUNT_FCY_INACTIVE() {
		return R2_AMOUNT_FCY_INACTIVE;
	}
	public void setR2_AMOUNT_FCY_INACTIVE(BigDecimal r2_AMOUNT_FCY_INACTIVE) {
		R2_AMOUNT_FCY_INACTIVE = r2_AMOUNT_FCY_INACTIVE;
	}
	public BigDecimal getR2_ACCOUNTS_AED_DORMANT() {
		return R2_ACCOUNTS_AED_DORMANT;
	}
	public void setR2_ACCOUNTS_AED_DORMANT(BigDecimal r2_ACCOUNTS_AED_DORMANT) {
		R2_ACCOUNTS_AED_DORMANT = r2_ACCOUNTS_AED_DORMANT;
	}
	public BigDecimal getR2_AMOUNT_AED_DORMANT() {
		return R2_AMOUNT_AED_DORMANT;
	}
	public void setR2_AMOUNT_AED_DORMANT(BigDecimal r2_AMOUNT_AED_DORMANT) {
		R2_AMOUNT_AED_DORMANT = r2_AMOUNT_AED_DORMANT;
	}
	public BigDecimal getR2_ACCOUNTS_FCY_DORMANT() {
		return R2_ACCOUNTS_FCY_DORMANT;
	}
	public void setR2_ACCOUNTS_FCY_DORMANT(BigDecimal r2_ACCOUNTS_FCY_DORMANT) {
		R2_ACCOUNTS_FCY_DORMANT = r2_ACCOUNTS_FCY_DORMANT;
	}
	public BigDecimal getR2_AMOUNT_FCY_DORMANT() {
		return R2_AMOUNT_FCY_DORMANT;
	}
	public void setR2_AMOUNT_FCY_DORMANT(BigDecimal r2_AMOUNT_FCY_DORMANT) {
		R2_AMOUNT_FCY_DORMANT = r2_AMOUNT_FCY_DORMANT;
	}
	public String getR3_S_NO() {
		return R3_S_NO;
	}
	public void setR3_S_NO(String r3_S_NO) {
		R3_S_NO = r3_S_NO;
	}
	public String getR3_REGULATIONS() {
		return R3_REGULATIONS;
	}
	public void setR3_REGULATIONS(String r3_REGULATIONS) {
		R3_REGULATIONS = r3_REGULATIONS;
	}
	public String getR3_DORMANT() {
		return R3_DORMANT;
	}
	public void setR3_DORMANT(String r3_DORMANT) {
		R3_DORMANT = r3_DORMANT;
	}
	public BigDecimal getR3_ACCOUNTS_AED_1YEAR() {
		return R3_ACCOUNTS_AED_1YEAR;
	}
	public void setR3_ACCOUNTS_AED_1YEAR(BigDecimal r3_ACCOUNTS_AED_1YEAR) {
		R3_ACCOUNTS_AED_1YEAR = r3_ACCOUNTS_AED_1YEAR;
	}
	public BigDecimal getR3_AMOUNT_AED_1YEAR() {
		return R3_AMOUNT_AED_1YEAR;
	}
	public void setR3_AMOUNT_AED_1YEAR(BigDecimal r3_AMOUNT_AED_1YEAR) {
		R3_AMOUNT_AED_1YEAR = r3_AMOUNT_AED_1YEAR;
	}
	public BigDecimal getR3_ACCOUNTS_FCY_1YEAR() {
		return R3_ACCOUNTS_FCY_1YEAR;
	}
	public void setR3_ACCOUNTS_FCY_1YEAR(BigDecimal r3_ACCOUNTS_FCY_1YEAR) {
		R3_ACCOUNTS_FCY_1YEAR = r3_ACCOUNTS_FCY_1YEAR;
	}
	public BigDecimal getR3_AMOUNT_FCY_1YEAR() {
		return R3_AMOUNT_FCY_1YEAR;
	}
	public void setR3_AMOUNT_FCY_1YEAR(BigDecimal r3_AMOUNT_FCY_1YEAR) {
		R3_AMOUNT_FCY_1YEAR = r3_AMOUNT_FCY_1YEAR;
	}
	public BigDecimal getR3_ACCOUNTS_AED_2YEAR() {
		return R3_ACCOUNTS_AED_2YEAR;
	}
	public void setR3_ACCOUNTS_AED_2YEAR(BigDecimal r3_ACCOUNTS_AED_2YEAR) {
		R3_ACCOUNTS_AED_2YEAR = r3_ACCOUNTS_AED_2YEAR;
	}
	public BigDecimal getR3_AMOUNT_AED_2YEAR() {
		return R3_AMOUNT_AED_2YEAR;
	}
	public void setR3_AMOUNT_AED_2YEAR(BigDecimal r3_AMOUNT_AED_2YEAR) {
		R3_AMOUNT_AED_2YEAR = r3_AMOUNT_AED_2YEAR;
	}
	public BigDecimal getR3_ACCOUNTS_FCY_2YEAR() {
		return R3_ACCOUNTS_FCY_2YEAR;
	}
	public void setR3_ACCOUNTS_FCY_2YEAR(BigDecimal r3_ACCOUNTS_FCY_2YEAR) {
		R3_ACCOUNTS_FCY_2YEAR = r3_ACCOUNTS_FCY_2YEAR;
	}
	public BigDecimal getR3_AMOUNT_FCY_2YEAR() {
		return R3_AMOUNT_FCY_2YEAR;
	}
	public void setR3_AMOUNT_FCY_2YEAR(BigDecimal r3_AMOUNT_FCY_2YEAR) {
		R3_AMOUNT_FCY_2YEAR = r3_AMOUNT_FCY_2YEAR;
	}
	public BigDecimal getR3_ACCOUNTS_AED_3YEAR() {
		return R3_ACCOUNTS_AED_3YEAR;
	}
	public void setR3_ACCOUNTS_AED_3YEAR(BigDecimal r3_ACCOUNTS_AED_3YEAR) {
		R3_ACCOUNTS_AED_3YEAR = r3_ACCOUNTS_AED_3YEAR;
	}
	public BigDecimal getR3_AMOUNT_AED_3YEAR() {
		return R3_AMOUNT_AED_3YEAR;
	}
	public void setR3_AMOUNT_AED_3YEAR(BigDecimal r3_AMOUNT_AED_3YEAR) {
		R3_AMOUNT_AED_3YEAR = r3_AMOUNT_AED_3YEAR;
	}
	public BigDecimal getR3_ACCOUNTS_FCY_3YEAR() {
		return R3_ACCOUNTS_FCY_3YEAR;
	}
	public void setR3_ACCOUNTS_FCY_3YEAR(BigDecimal r3_ACCOUNTS_FCY_3YEAR) {
		R3_ACCOUNTS_FCY_3YEAR = r3_ACCOUNTS_FCY_3YEAR;
	}
	public BigDecimal getR3_AMOUNT_FCY_3YEAR() {
		return R3_AMOUNT_FCY_3YEAR;
	}
	public void setR3_AMOUNT_FCY_3YEAR(BigDecimal r3_AMOUNT_FCY_3YEAR) {
		R3_AMOUNT_FCY_3YEAR = r3_AMOUNT_FCY_3YEAR;
	}
	public BigDecimal getR3_ACCOUNTS_AED_5YEAR() {
		return R3_ACCOUNTS_AED_5YEAR;
	}
	public void setR3_ACCOUNTS_AED_5YEAR(BigDecimal r3_ACCOUNTS_AED_5YEAR) {
		R3_ACCOUNTS_AED_5YEAR = r3_ACCOUNTS_AED_5YEAR;
	}
	public BigDecimal getR3_AMOUNT_AED_5YEAR() {
		return R3_AMOUNT_AED_5YEAR;
	}
	public void setR3_AMOUNT_AED_5YEAR(BigDecimal r3_AMOUNT_AED_5YEAR) {
		R3_AMOUNT_AED_5YEAR = r3_AMOUNT_AED_5YEAR;
	}
	public BigDecimal getR3_ACCOUNTS_FCY_5YEAR() {
		return R3_ACCOUNTS_FCY_5YEAR;
	}
	public void setR3_ACCOUNTS_FCY_5YEAR(BigDecimal r3_ACCOUNTS_FCY_5YEAR) {
		R3_ACCOUNTS_FCY_5YEAR = r3_ACCOUNTS_FCY_5YEAR;
	}
	public BigDecimal getR3_AMOUNT_FCY_5YEAR() {
		return R3_AMOUNT_FCY_5YEAR;
	}
	public void setR3_AMOUNT_FCY_5YEAR(BigDecimal r3_AMOUNT_FCY_5YEAR) {
		R3_AMOUNT_FCY_5YEAR = r3_AMOUNT_FCY_5YEAR;
	}
	public BigDecimal getR3_ACCOUNTS_AED_ABOVE() {
		return R3_ACCOUNTS_AED_ABOVE;
	}
	public void setR3_ACCOUNTS_AED_ABOVE(BigDecimal r3_ACCOUNTS_AED_ABOVE) {
		R3_ACCOUNTS_AED_ABOVE = r3_ACCOUNTS_AED_ABOVE;
	}
	public BigDecimal getR3_AMOUNT_AED_ABOVE() {
		return R3_AMOUNT_AED_ABOVE;
	}
	public void setR3_AMOUNT_AED_ABOVE(BigDecimal r3_AMOUNT_AED_ABOVE) {
		R3_AMOUNT_AED_ABOVE = r3_AMOUNT_AED_ABOVE;
	}
	public BigDecimal getR3_ACCOUNTS_FCY_ABOVE() {
		return R3_ACCOUNTS_FCY_ABOVE;
	}
	public void setR3_ACCOUNTS_FCY_ABOVE(BigDecimal r3_ACCOUNTS_FCY_ABOVE) {
		R3_ACCOUNTS_FCY_ABOVE = r3_ACCOUNTS_FCY_ABOVE;
	}
	public BigDecimal getR3_AMOUNT_FCY_ABOVE() {
		return R3_AMOUNT_FCY_ABOVE;
	}
	public void setR3_AMOUNT_FCY_ABOVE(BigDecimal r3_AMOUNT_FCY_ABOVE) {
		R3_AMOUNT_FCY_ABOVE = r3_AMOUNT_FCY_ABOVE;
	}
	public BigDecimal getR3_ACCOUNTS_AED_INACTIVE() {
		return R3_ACCOUNTS_AED_INACTIVE;
	}
	public void setR3_ACCOUNTS_AED_INACTIVE(BigDecimal r3_ACCOUNTS_AED_INACTIVE) {
		R3_ACCOUNTS_AED_INACTIVE = r3_ACCOUNTS_AED_INACTIVE;
	}
	public BigDecimal getR3_AMOUNT_AED_INACTIVE() {
		return R3_AMOUNT_AED_INACTIVE;
	}
	public void setR3_AMOUNT_AED_INACTIVE(BigDecimal r3_AMOUNT_AED_INACTIVE) {
		R3_AMOUNT_AED_INACTIVE = r3_AMOUNT_AED_INACTIVE;
	}
	public BigDecimal getR3_ACCOUNTS_FCY_INACTIVE() {
		return R3_ACCOUNTS_FCY_INACTIVE;
	}
	public void setR3_ACCOUNTS_FCY_INACTIVE(BigDecimal r3_ACCOUNTS_FCY_INACTIVE) {
		R3_ACCOUNTS_FCY_INACTIVE = r3_ACCOUNTS_FCY_INACTIVE;
	}
	public BigDecimal getR3_AMOUNT_FCY_INACTIVE() {
		return R3_AMOUNT_FCY_INACTIVE;
	}
	public void setR3_AMOUNT_FCY_INACTIVE(BigDecimal r3_AMOUNT_FCY_INACTIVE) {
		R3_AMOUNT_FCY_INACTIVE = r3_AMOUNT_FCY_INACTIVE;
	}
	public BigDecimal getR3_ACCOUNTS_AED_DORMANT() {
		return R3_ACCOUNTS_AED_DORMANT;
	}
	public void setR3_ACCOUNTS_AED_DORMANT(BigDecimal r3_ACCOUNTS_AED_DORMANT) {
		R3_ACCOUNTS_AED_DORMANT = r3_ACCOUNTS_AED_DORMANT;
	}
	public BigDecimal getR3_AMOUNT_AED_DORMANT() {
		return R3_AMOUNT_AED_DORMANT;
	}
	public void setR3_AMOUNT_AED_DORMANT(BigDecimal r3_AMOUNT_AED_DORMANT) {
		R3_AMOUNT_AED_DORMANT = r3_AMOUNT_AED_DORMANT;
	}
	public BigDecimal getR3_ACCOUNTS_FCY_DORMANT() {
		return R3_ACCOUNTS_FCY_DORMANT;
	}
	public void setR3_ACCOUNTS_FCY_DORMANT(BigDecimal r3_ACCOUNTS_FCY_DORMANT) {
		R3_ACCOUNTS_FCY_DORMANT = r3_ACCOUNTS_FCY_DORMANT;
	}
	public BigDecimal getR3_AMOUNT_FCY_DORMANT() {
		return R3_AMOUNT_FCY_DORMANT;
	}
	public void setR3_AMOUNT_FCY_DORMANT(BigDecimal r3_AMOUNT_FCY_DORMANT) {
		R3_AMOUNT_FCY_DORMANT = r3_AMOUNT_FCY_DORMANT;
	}
	public String getR4_S_NO() {
		return R4_S_NO;
	}
	public void setR4_S_NO(String r4_S_NO) {
		R4_S_NO = r4_S_NO;
	}
	public String getR4_REGULATIONS() {
		return R4_REGULATIONS;
	}
	public void setR4_REGULATIONS(String r4_REGULATIONS) {
		R4_REGULATIONS = r4_REGULATIONS;
	}
	public String getR4_DORMANT() {
		return R4_DORMANT;
	}
	public void setR4_DORMANT(String r4_DORMANT) {
		R4_DORMANT = r4_DORMANT;
	}
	public BigDecimal getR4_ACCOUNTS_AED_1YEAR() {
		return R4_ACCOUNTS_AED_1YEAR;
	}
	public void setR4_ACCOUNTS_AED_1YEAR(BigDecimal r4_ACCOUNTS_AED_1YEAR) {
		R4_ACCOUNTS_AED_1YEAR = r4_ACCOUNTS_AED_1YEAR;
	}
	public BigDecimal getR4_AMOUNT_AED_1YEAR() {
		return R4_AMOUNT_AED_1YEAR;
	}
	public void setR4_AMOUNT_AED_1YEAR(BigDecimal r4_AMOUNT_AED_1YEAR) {
		R4_AMOUNT_AED_1YEAR = r4_AMOUNT_AED_1YEAR;
	}
	public BigDecimal getR4_ACCOUNTS_FCY_1YEAR() {
		return R4_ACCOUNTS_FCY_1YEAR;
	}
	public void setR4_ACCOUNTS_FCY_1YEAR(BigDecimal r4_ACCOUNTS_FCY_1YEAR) {
		R4_ACCOUNTS_FCY_1YEAR = r4_ACCOUNTS_FCY_1YEAR;
	}
	public BigDecimal getR4_AMOUNT_FCY_1YEAR() {
		return R4_AMOUNT_FCY_1YEAR;
	}
	public void setR4_AMOUNT_FCY_1YEAR(BigDecimal r4_AMOUNT_FCY_1YEAR) {
		R4_AMOUNT_FCY_1YEAR = r4_AMOUNT_FCY_1YEAR;
	}
	public BigDecimal getR4_ACCOUNTS_AED_2YEAR() {
		return R4_ACCOUNTS_AED_2YEAR;
	}
	public void setR4_ACCOUNTS_AED_2YEAR(BigDecimal r4_ACCOUNTS_AED_2YEAR) {
		R4_ACCOUNTS_AED_2YEAR = r4_ACCOUNTS_AED_2YEAR;
	}
	public BigDecimal getR4_AMOUNT_AED_2YEAR() {
		return R4_AMOUNT_AED_2YEAR;
	}
	public void setR4_AMOUNT_AED_2YEAR(BigDecimal r4_AMOUNT_AED_2YEAR) {
		R4_AMOUNT_AED_2YEAR = r4_AMOUNT_AED_2YEAR;
	}
	public BigDecimal getR4_ACCOUNTS_FCY_2YEAR() {
		return R4_ACCOUNTS_FCY_2YEAR;
	}
	public void setR4_ACCOUNTS_FCY_2YEAR(BigDecimal r4_ACCOUNTS_FCY_2YEAR) {
		R4_ACCOUNTS_FCY_2YEAR = r4_ACCOUNTS_FCY_2YEAR;
	}
	public BigDecimal getR4_AMOUNT_FCY_2YEAR() {
		return R4_AMOUNT_FCY_2YEAR;
	}
	public void setR4_AMOUNT_FCY_2YEAR(BigDecimal r4_AMOUNT_FCY_2YEAR) {
		R4_AMOUNT_FCY_2YEAR = r4_AMOUNT_FCY_2YEAR;
	}
	public BigDecimal getR4_ACCOUNTS_AED_3YEAR() {
		return R4_ACCOUNTS_AED_3YEAR;
	}
	public void setR4_ACCOUNTS_AED_3YEAR(BigDecimal r4_ACCOUNTS_AED_3YEAR) {
		R4_ACCOUNTS_AED_3YEAR = r4_ACCOUNTS_AED_3YEAR;
	}
	public BigDecimal getR4_AMOUNT_AED_3YEAR() {
		return R4_AMOUNT_AED_3YEAR;
	}
	public void setR4_AMOUNT_AED_3YEAR(BigDecimal r4_AMOUNT_AED_3YEAR) {
		R4_AMOUNT_AED_3YEAR = r4_AMOUNT_AED_3YEAR;
	}
	public BigDecimal getR4_ACCOUNTS_FCY_3YEAR() {
		return R4_ACCOUNTS_FCY_3YEAR;
	}
	public void setR4_ACCOUNTS_FCY_3YEAR(BigDecimal r4_ACCOUNTS_FCY_3YEAR) {
		R4_ACCOUNTS_FCY_3YEAR = r4_ACCOUNTS_FCY_3YEAR;
	}
	public BigDecimal getR4_AMOUNT_FCY_3YEAR() {
		return R4_AMOUNT_FCY_3YEAR;
	}
	public void setR4_AMOUNT_FCY_3YEAR(BigDecimal r4_AMOUNT_FCY_3YEAR) {
		R4_AMOUNT_FCY_3YEAR = r4_AMOUNT_FCY_3YEAR;
	}
	public BigDecimal getR4_ACCOUNTS_AED_5YEAR() {
		return R4_ACCOUNTS_AED_5YEAR;
	}
	public void setR4_ACCOUNTS_AED_5YEAR(BigDecimal r4_ACCOUNTS_AED_5YEAR) {
		R4_ACCOUNTS_AED_5YEAR = r4_ACCOUNTS_AED_5YEAR;
	}
	public BigDecimal getR4_AMOUNT_AED_5YEAR() {
		return R4_AMOUNT_AED_5YEAR;
	}
	public void setR4_AMOUNT_AED_5YEAR(BigDecimal r4_AMOUNT_AED_5YEAR) {
		R4_AMOUNT_AED_5YEAR = r4_AMOUNT_AED_5YEAR;
	}
	public BigDecimal getR4_ACCOUNTS_FCY_5YEAR() {
		return R4_ACCOUNTS_FCY_5YEAR;
	}
	public void setR4_ACCOUNTS_FCY_5YEAR(BigDecimal r4_ACCOUNTS_FCY_5YEAR) {
		R4_ACCOUNTS_FCY_5YEAR = r4_ACCOUNTS_FCY_5YEAR;
	}
	public BigDecimal getR4_AMOUNT_FCY_5YEAR() {
		return R4_AMOUNT_FCY_5YEAR;
	}
	public void setR4_AMOUNT_FCY_5YEAR(BigDecimal r4_AMOUNT_FCY_5YEAR) {
		R4_AMOUNT_FCY_5YEAR = r4_AMOUNT_FCY_5YEAR;
	}
	public BigDecimal getR4_ACCOUNTS_AED_ABOVE() {
		return R4_ACCOUNTS_AED_ABOVE;
	}
	public void setR4_ACCOUNTS_AED_ABOVE(BigDecimal r4_ACCOUNTS_AED_ABOVE) {
		R4_ACCOUNTS_AED_ABOVE = r4_ACCOUNTS_AED_ABOVE;
	}
	public BigDecimal getR4_AMOUNT_AED_ABOVE() {
		return R4_AMOUNT_AED_ABOVE;
	}
	public void setR4_AMOUNT_AED_ABOVE(BigDecimal r4_AMOUNT_AED_ABOVE) {
		R4_AMOUNT_AED_ABOVE = r4_AMOUNT_AED_ABOVE;
	}
	public BigDecimal getR4_ACCOUNTS_FCY_ABOVE() {
		return R4_ACCOUNTS_FCY_ABOVE;
	}
	public void setR4_ACCOUNTS_FCY_ABOVE(BigDecimal r4_ACCOUNTS_FCY_ABOVE) {
		R4_ACCOUNTS_FCY_ABOVE = r4_ACCOUNTS_FCY_ABOVE;
	}
	public BigDecimal getR4_AMOUNT_FCY_ABOVE() {
		return R4_AMOUNT_FCY_ABOVE;
	}
	public void setR4_AMOUNT_FCY_ABOVE(BigDecimal r4_AMOUNT_FCY_ABOVE) {
		R4_AMOUNT_FCY_ABOVE = r4_AMOUNT_FCY_ABOVE;
	}
	public BigDecimal getR4_ACCOUNTS_AED_INACTIVE() {
		return R4_ACCOUNTS_AED_INACTIVE;
	}
	public void setR4_ACCOUNTS_AED_INACTIVE(BigDecimal r4_ACCOUNTS_AED_INACTIVE) {
		R4_ACCOUNTS_AED_INACTIVE = r4_ACCOUNTS_AED_INACTIVE;
	}
	public BigDecimal getR4_AMOUNT_AED_INACTIVE() {
		return R4_AMOUNT_AED_INACTIVE;
	}
	public void setR4_AMOUNT_AED_INACTIVE(BigDecimal r4_AMOUNT_AED_INACTIVE) {
		R4_AMOUNT_AED_INACTIVE = r4_AMOUNT_AED_INACTIVE;
	}
	public BigDecimal getR4_ACCOUNTS_FCY_INACTIVE() {
		return R4_ACCOUNTS_FCY_INACTIVE;
	}
	public void setR4_ACCOUNTS_FCY_INACTIVE(BigDecimal r4_ACCOUNTS_FCY_INACTIVE) {
		R4_ACCOUNTS_FCY_INACTIVE = r4_ACCOUNTS_FCY_INACTIVE;
	}
	public BigDecimal getR4_AMOUNT_FCY_INACTIVE() {
		return R4_AMOUNT_FCY_INACTIVE;
	}
	public void setR4_AMOUNT_FCY_INACTIVE(BigDecimal r4_AMOUNT_FCY_INACTIVE) {
		R4_AMOUNT_FCY_INACTIVE = r4_AMOUNT_FCY_INACTIVE;
	}
	public BigDecimal getR4_ACCOUNTS_AED_DORMANT() {
		return R4_ACCOUNTS_AED_DORMANT;
	}
	public void setR4_ACCOUNTS_AED_DORMANT(BigDecimal r4_ACCOUNTS_AED_DORMANT) {
		R4_ACCOUNTS_AED_DORMANT = r4_ACCOUNTS_AED_DORMANT;
	}
	public BigDecimal getR4_AMOUNT_AED_DORMANT() {
		return R4_AMOUNT_AED_DORMANT;
	}
	public void setR4_AMOUNT_AED_DORMANT(BigDecimal r4_AMOUNT_AED_DORMANT) {
		R4_AMOUNT_AED_DORMANT = r4_AMOUNT_AED_DORMANT;
	}
	public BigDecimal getR4_ACCOUNTS_FCY_DORMANT() {
		return R4_ACCOUNTS_FCY_DORMANT;
	}
	public void setR4_ACCOUNTS_FCY_DORMANT(BigDecimal r4_ACCOUNTS_FCY_DORMANT) {
		R4_ACCOUNTS_FCY_DORMANT = r4_ACCOUNTS_FCY_DORMANT;
	}
	public BigDecimal getR4_AMOUNT_FCY_DORMANT() {
		return R4_AMOUNT_FCY_DORMANT;
	}
	public void setR4_AMOUNT_FCY_DORMANT(BigDecimal r4_AMOUNT_FCY_DORMANT) {
		R4_AMOUNT_FCY_DORMANT = r4_AMOUNT_FCY_DORMANT;
	}
	public String getR5_S_NO() {
		return R5_S_NO;
	}
	public void setR5_S_NO(String r5_S_NO) {
		R5_S_NO = r5_S_NO;
	}
	public String getR5_REGULATIONS() {
		return R5_REGULATIONS;
	}
	public void setR5_REGULATIONS(String r5_REGULATIONS) {
		R5_REGULATIONS = r5_REGULATIONS;
	}
	public String getR5_DORMANT() {
		return R5_DORMANT;
	}
	public void setR5_DORMANT(String r5_DORMANT) {
		R5_DORMANT = r5_DORMANT;
	}
	public BigDecimal getR5_ACCOUNTS_AED_1YEAR() {
		return R5_ACCOUNTS_AED_1YEAR;
	}
	public void setR5_ACCOUNTS_AED_1YEAR(BigDecimal r5_ACCOUNTS_AED_1YEAR) {
		R5_ACCOUNTS_AED_1YEAR = r5_ACCOUNTS_AED_1YEAR;
	}
	public BigDecimal getR5_AMOUNT_AED_1YEAR() {
		return R5_AMOUNT_AED_1YEAR;
	}
	public void setR5_AMOUNT_AED_1YEAR(BigDecimal r5_AMOUNT_AED_1YEAR) {
		R5_AMOUNT_AED_1YEAR = r5_AMOUNT_AED_1YEAR;
	}
	public BigDecimal getR5_ACCOUNTS_FCY_1YEAR() {
		return R5_ACCOUNTS_FCY_1YEAR;
	}
	public void setR5_ACCOUNTS_FCY_1YEAR(BigDecimal r5_ACCOUNTS_FCY_1YEAR) {
		R5_ACCOUNTS_FCY_1YEAR = r5_ACCOUNTS_FCY_1YEAR;
	}
	public BigDecimal getR5_AMOUNT_FCY_1YEAR() {
		return R5_AMOUNT_FCY_1YEAR;
	}
	public void setR5_AMOUNT_FCY_1YEAR(BigDecimal r5_AMOUNT_FCY_1YEAR) {
		R5_AMOUNT_FCY_1YEAR = r5_AMOUNT_FCY_1YEAR;
	}
	public BigDecimal getR5_ACCOUNTS_AED_2YEAR() {
		return R5_ACCOUNTS_AED_2YEAR;
	}
	public void setR5_ACCOUNTS_AED_2YEAR(BigDecimal r5_ACCOUNTS_AED_2YEAR) {
		R5_ACCOUNTS_AED_2YEAR = r5_ACCOUNTS_AED_2YEAR;
	}
	public BigDecimal getR5_AMOUNT_AED_2YEAR() {
		return R5_AMOUNT_AED_2YEAR;
	}
	public void setR5_AMOUNT_AED_2YEAR(BigDecimal r5_AMOUNT_AED_2YEAR) {
		R5_AMOUNT_AED_2YEAR = r5_AMOUNT_AED_2YEAR;
	}
	public BigDecimal getR5_ACCOUNTS_FCY_2YEAR() {
		return R5_ACCOUNTS_FCY_2YEAR;
	}
	public void setR5_ACCOUNTS_FCY_2YEAR(BigDecimal r5_ACCOUNTS_FCY_2YEAR) {
		R5_ACCOUNTS_FCY_2YEAR = r5_ACCOUNTS_FCY_2YEAR;
	}
	public BigDecimal getR5_AMOUNT_FCY_2YEAR() {
		return R5_AMOUNT_FCY_2YEAR;
	}
	public void setR5_AMOUNT_FCY_2YEAR(BigDecimal r5_AMOUNT_FCY_2YEAR) {
		R5_AMOUNT_FCY_2YEAR = r5_AMOUNT_FCY_2YEAR;
	}
	public BigDecimal getR5_ACCOUNTS_AED_3YEAR() {
		return R5_ACCOUNTS_AED_3YEAR;
	}
	public void setR5_ACCOUNTS_AED_3YEAR(BigDecimal r5_ACCOUNTS_AED_3YEAR) {
		R5_ACCOUNTS_AED_3YEAR = r5_ACCOUNTS_AED_3YEAR;
	}
	public BigDecimal getR5_AMOUNT_AED_3YEAR() {
		return R5_AMOUNT_AED_3YEAR;
	}
	public void setR5_AMOUNT_AED_3YEAR(BigDecimal r5_AMOUNT_AED_3YEAR) {
		R5_AMOUNT_AED_3YEAR = r5_AMOUNT_AED_3YEAR;
	}
	public BigDecimal getR5_ACCOUNTS_FCY_3YEAR() {
		return R5_ACCOUNTS_FCY_3YEAR;
	}
	public void setR5_ACCOUNTS_FCY_3YEAR(BigDecimal r5_ACCOUNTS_FCY_3YEAR) {
		R5_ACCOUNTS_FCY_3YEAR = r5_ACCOUNTS_FCY_3YEAR;
	}
	public BigDecimal getR5_AMOUNT_FCY_3YEAR() {
		return R5_AMOUNT_FCY_3YEAR;
	}
	public void setR5_AMOUNT_FCY_3YEAR(BigDecimal r5_AMOUNT_FCY_3YEAR) {
		R5_AMOUNT_FCY_3YEAR = r5_AMOUNT_FCY_3YEAR;
	}
	public BigDecimal getR5_ACCOUNTS_AED_5YEAR() {
		return R5_ACCOUNTS_AED_5YEAR;
	}
	public void setR5_ACCOUNTS_AED_5YEAR(BigDecimal r5_ACCOUNTS_AED_5YEAR) {
		R5_ACCOUNTS_AED_5YEAR = r5_ACCOUNTS_AED_5YEAR;
	}
	public BigDecimal getR5_AMOUNT_AED_5YEAR() {
		return R5_AMOUNT_AED_5YEAR;
	}
	public void setR5_AMOUNT_AED_5YEAR(BigDecimal r5_AMOUNT_AED_5YEAR) {
		R5_AMOUNT_AED_5YEAR = r5_AMOUNT_AED_5YEAR;
	}
	public BigDecimal getR5_ACCOUNTS_FCY_5YEAR() {
		return R5_ACCOUNTS_FCY_5YEAR;
	}
	public void setR5_ACCOUNTS_FCY_5YEAR(BigDecimal r5_ACCOUNTS_FCY_5YEAR) {
		R5_ACCOUNTS_FCY_5YEAR = r5_ACCOUNTS_FCY_5YEAR;
	}
	public BigDecimal getR5_AMOUNT_FCY_5YEAR() {
		return R5_AMOUNT_FCY_5YEAR;
	}
	public void setR5_AMOUNT_FCY_5YEAR(BigDecimal r5_AMOUNT_FCY_5YEAR) {
		R5_AMOUNT_FCY_5YEAR = r5_AMOUNT_FCY_5YEAR;
	}
	public BigDecimal getR5_ACCOUNTS_AED_ABOVE() {
		return R5_ACCOUNTS_AED_ABOVE;
	}
	public void setR5_ACCOUNTS_AED_ABOVE(BigDecimal r5_ACCOUNTS_AED_ABOVE) {
		R5_ACCOUNTS_AED_ABOVE = r5_ACCOUNTS_AED_ABOVE;
	}
	public BigDecimal getR5_AMOUNT_AED_ABOVE() {
		return R5_AMOUNT_AED_ABOVE;
	}
	public void setR5_AMOUNT_AED_ABOVE(BigDecimal r5_AMOUNT_AED_ABOVE) {
		R5_AMOUNT_AED_ABOVE = r5_AMOUNT_AED_ABOVE;
	}
	public BigDecimal getR5_ACCOUNTS_FCY_ABOVE() {
		return R5_ACCOUNTS_FCY_ABOVE;
	}
	public void setR5_ACCOUNTS_FCY_ABOVE(BigDecimal r5_ACCOUNTS_FCY_ABOVE) {
		R5_ACCOUNTS_FCY_ABOVE = r5_ACCOUNTS_FCY_ABOVE;
	}
	public BigDecimal getR5_AMOUNT_FCY_ABOVE() {
		return R5_AMOUNT_FCY_ABOVE;
	}
	public void setR5_AMOUNT_FCY_ABOVE(BigDecimal r5_AMOUNT_FCY_ABOVE) {
		R5_AMOUNT_FCY_ABOVE = r5_AMOUNT_FCY_ABOVE;
	}
	public BigDecimal getR5_ACCOUNTS_AED_INACTIVE() {
		return R5_ACCOUNTS_AED_INACTIVE;
	}
	public void setR5_ACCOUNTS_AED_INACTIVE(BigDecimal r5_ACCOUNTS_AED_INACTIVE) {
		R5_ACCOUNTS_AED_INACTIVE = r5_ACCOUNTS_AED_INACTIVE;
	}
	public BigDecimal getR5_AMOUNT_AED_INACTIVE() {
		return R5_AMOUNT_AED_INACTIVE;
	}
	public void setR5_AMOUNT_AED_INACTIVE(BigDecimal r5_AMOUNT_AED_INACTIVE) {
		R5_AMOUNT_AED_INACTIVE = r5_AMOUNT_AED_INACTIVE;
	}
	public BigDecimal getR5_ACCOUNTS_FCY_INACTIVE() {
		return R5_ACCOUNTS_FCY_INACTIVE;
	}
	public void setR5_ACCOUNTS_FCY_INACTIVE(BigDecimal r5_ACCOUNTS_FCY_INACTIVE) {
		R5_ACCOUNTS_FCY_INACTIVE = r5_ACCOUNTS_FCY_INACTIVE;
	}
	public BigDecimal getR5_AMOUNT_FCY_INACTIVE() {
		return R5_AMOUNT_FCY_INACTIVE;
	}
	public void setR5_AMOUNT_FCY_INACTIVE(BigDecimal r5_AMOUNT_FCY_INACTIVE) {
		R5_AMOUNT_FCY_INACTIVE = r5_AMOUNT_FCY_INACTIVE;
	}
	public BigDecimal getR5_ACCOUNTS_AED_DORMANT() {
		return R5_ACCOUNTS_AED_DORMANT;
	}
	public void setR5_ACCOUNTS_AED_DORMANT(BigDecimal r5_ACCOUNTS_AED_DORMANT) {
		R5_ACCOUNTS_AED_DORMANT = r5_ACCOUNTS_AED_DORMANT;
	}
	public BigDecimal getR5_AMOUNT_AED_DORMANT() {
		return R5_AMOUNT_AED_DORMANT;
	}
	public void setR5_AMOUNT_AED_DORMANT(BigDecimal r5_AMOUNT_AED_DORMANT) {
		R5_AMOUNT_AED_DORMANT = r5_AMOUNT_AED_DORMANT;
	}
	public BigDecimal getR5_ACCOUNTS_FCY_DORMANT() {
		return R5_ACCOUNTS_FCY_DORMANT;
	}
	public void setR5_ACCOUNTS_FCY_DORMANT(BigDecimal r5_ACCOUNTS_FCY_DORMANT) {
		R5_ACCOUNTS_FCY_DORMANT = r5_ACCOUNTS_FCY_DORMANT;
	}
	public BigDecimal getR5_AMOUNT_FCY_DORMANT() {
		return R5_AMOUNT_FCY_DORMANT;
	}
	public void setR5_AMOUNT_FCY_DORMANT(BigDecimal r5_AMOUNT_FCY_DORMANT) {
		R5_AMOUNT_FCY_DORMANT = r5_AMOUNT_FCY_DORMANT;
	}
	public String getR6_S_NO() {
		return R6_S_NO;
	}
	public void setR6_S_NO(String r6_S_NO) {
		R6_S_NO = r6_S_NO;
	}
	public String getR6_REGULATIONS() {
		return R6_REGULATIONS;
	}
	public void setR6_REGULATIONS(String r6_REGULATIONS) {
		R6_REGULATIONS = r6_REGULATIONS;
	}
	public String getR6_DORMANT() {
		return R6_DORMANT;
	}
	public void setR6_DORMANT(String r6_DORMANT) {
		R6_DORMANT = r6_DORMANT;
	}
	public BigDecimal getR6_ACCOUNTS_AED_1YEAR() {
		return R6_ACCOUNTS_AED_1YEAR;
	}
	public void setR6_ACCOUNTS_AED_1YEAR(BigDecimal r6_ACCOUNTS_AED_1YEAR) {
		R6_ACCOUNTS_AED_1YEAR = r6_ACCOUNTS_AED_1YEAR;
	}
	public BigDecimal getR6_AMOUNT_AED_1YEAR() {
		return R6_AMOUNT_AED_1YEAR;
	}
	public void setR6_AMOUNT_AED_1YEAR(BigDecimal r6_AMOUNT_AED_1YEAR) {
		R6_AMOUNT_AED_1YEAR = r6_AMOUNT_AED_1YEAR;
	}
	public BigDecimal getR6_ACCOUNTS_FCY_1YEAR() {
		return R6_ACCOUNTS_FCY_1YEAR;
	}
	public void setR6_ACCOUNTS_FCY_1YEAR(BigDecimal r6_ACCOUNTS_FCY_1YEAR) {
		R6_ACCOUNTS_FCY_1YEAR = r6_ACCOUNTS_FCY_1YEAR;
	}
	public BigDecimal getR6_AMOUNT_FCY_1YEAR() {
		return R6_AMOUNT_FCY_1YEAR;
	}
	public void setR6_AMOUNT_FCY_1YEAR(BigDecimal r6_AMOUNT_FCY_1YEAR) {
		R6_AMOUNT_FCY_1YEAR = r6_AMOUNT_FCY_1YEAR;
	}
	public BigDecimal getR6_ACCOUNTS_AED_2YEAR() {
		return R6_ACCOUNTS_AED_2YEAR;
	}
	public void setR6_ACCOUNTS_AED_2YEAR(BigDecimal r6_ACCOUNTS_AED_2YEAR) {
		R6_ACCOUNTS_AED_2YEAR = r6_ACCOUNTS_AED_2YEAR;
	}
	public BigDecimal getR6_AMOUNT_AED_2YEAR() {
		return R6_AMOUNT_AED_2YEAR;
	}
	public void setR6_AMOUNT_AED_2YEAR(BigDecimal r6_AMOUNT_AED_2YEAR) {
		R6_AMOUNT_AED_2YEAR = r6_AMOUNT_AED_2YEAR;
	}
	public BigDecimal getR6_ACCOUNTS_FCY_2YEAR() {
		return R6_ACCOUNTS_FCY_2YEAR;
	}
	public void setR6_ACCOUNTS_FCY_2YEAR(BigDecimal r6_ACCOUNTS_FCY_2YEAR) {
		R6_ACCOUNTS_FCY_2YEAR = r6_ACCOUNTS_FCY_2YEAR;
	}
	public BigDecimal getR6_AMOUNT_FCY_2YEAR() {
		return R6_AMOUNT_FCY_2YEAR;
	}
	public void setR6_AMOUNT_FCY_2YEAR(BigDecimal r6_AMOUNT_FCY_2YEAR) {
		R6_AMOUNT_FCY_2YEAR = r6_AMOUNT_FCY_2YEAR;
	}
	public BigDecimal getR6_ACCOUNTS_AED_3YEAR() {
		return R6_ACCOUNTS_AED_3YEAR;
	}
	public void setR6_ACCOUNTS_AED_3YEAR(BigDecimal r6_ACCOUNTS_AED_3YEAR) {
		R6_ACCOUNTS_AED_3YEAR = r6_ACCOUNTS_AED_3YEAR;
	}
	public BigDecimal getR6_AMOUNT_AED_3YEAR() {
		return R6_AMOUNT_AED_3YEAR;
	}
	public void setR6_AMOUNT_AED_3YEAR(BigDecimal r6_AMOUNT_AED_3YEAR) {
		R6_AMOUNT_AED_3YEAR = r6_AMOUNT_AED_3YEAR;
	}
	public BigDecimal getR6_ACCOUNTS_FCY_3YEAR() {
		return R6_ACCOUNTS_FCY_3YEAR;
	}
	public void setR6_ACCOUNTS_FCY_3YEAR(BigDecimal r6_ACCOUNTS_FCY_3YEAR) {
		R6_ACCOUNTS_FCY_3YEAR = r6_ACCOUNTS_FCY_3YEAR;
	}
	public BigDecimal getR6_AMOUNT_FCY_3YEAR() {
		return R6_AMOUNT_FCY_3YEAR;
	}
	public void setR6_AMOUNT_FCY_3YEAR(BigDecimal r6_AMOUNT_FCY_3YEAR) {
		R6_AMOUNT_FCY_3YEAR = r6_AMOUNT_FCY_3YEAR;
	}
	public BigDecimal getR6_ACCOUNTS_AED_5YEAR() {
		return R6_ACCOUNTS_AED_5YEAR;
	}
	public void setR6_ACCOUNTS_AED_5YEAR(BigDecimal r6_ACCOUNTS_AED_5YEAR) {
		R6_ACCOUNTS_AED_5YEAR = r6_ACCOUNTS_AED_5YEAR;
	}
	public BigDecimal getR6_AMOUNT_AED_5YEAR() {
		return R6_AMOUNT_AED_5YEAR;
	}
	public void setR6_AMOUNT_AED_5YEAR(BigDecimal r6_AMOUNT_AED_5YEAR) {
		R6_AMOUNT_AED_5YEAR = r6_AMOUNT_AED_5YEAR;
	}
	public BigDecimal getR6_ACCOUNTS_FCY_5YEAR() {
		return R6_ACCOUNTS_FCY_5YEAR;
	}
	public void setR6_ACCOUNTS_FCY_5YEAR(BigDecimal r6_ACCOUNTS_FCY_5YEAR) {
		R6_ACCOUNTS_FCY_5YEAR = r6_ACCOUNTS_FCY_5YEAR;
	}
	public BigDecimal getR6_AMOUNT_FCY_5YEAR() {
		return R6_AMOUNT_FCY_5YEAR;
	}
	public void setR6_AMOUNT_FCY_5YEAR(BigDecimal r6_AMOUNT_FCY_5YEAR) {
		R6_AMOUNT_FCY_5YEAR = r6_AMOUNT_FCY_5YEAR;
	}
	public BigDecimal getR6_ACCOUNTS_AED_ABOVE() {
		return R6_ACCOUNTS_AED_ABOVE;
	}
	public void setR6_ACCOUNTS_AED_ABOVE(BigDecimal r6_ACCOUNTS_AED_ABOVE) {
		R6_ACCOUNTS_AED_ABOVE = r6_ACCOUNTS_AED_ABOVE;
	}
	public BigDecimal getR6_AMOUNT_AED_ABOVE() {
		return R6_AMOUNT_AED_ABOVE;
	}
	public void setR6_AMOUNT_AED_ABOVE(BigDecimal r6_AMOUNT_AED_ABOVE) {
		R6_AMOUNT_AED_ABOVE = r6_AMOUNT_AED_ABOVE;
	}
	public BigDecimal getR6_ACCOUNTS_FCY_ABOVE() {
		return R6_ACCOUNTS_FCY_ABOVE;
	}
	public void setR6_ACCOUNTS_FCY_ABOVE(BigDecimal r6_ACCOUNTS_FCY_ABOVE) {
		R6_ACCOUNTS_FCY_ABOVE = r6_ACCOUNTS_FCY_ABOVE;
	}
	public BigDecimal getR6_AMOUNT_FCY_ABOVE() {
		return R6_AMOUNT_FCY_ABOVE;
	}
	public void setR6_AMOUNT_FCY_ABOVE(BigDecimal r6_AMOUNT_FCY_ABOVE) {
		R6_AMOUNT_FCY_ABOVE = r6_AMOUNT_FCY_ABOVE;
	}
	public BigDecimal getR6_ACCOUNTS_AED_INACTIVE() {
		return R6_ACCOUNTS_AED_INACTIVE;
	}
	public void setR6_ACCOUNTS_AED_INACTIVE(BigDecimal r6_ACCOUNTS_AED_INACTIVE) {
		R6_ACCOUNTS_AED_INACTIVE = r6_ACCOUNTS_AED_INACTIVE;
	}
	public BigDecimal getR6_AMOUNT_AED_INACTIVE() {
		return R6_AMOUNT_AED_INACTIVE;
	}
	public void setR6_AMOUNT_AED_INACTIVE(BigDecimal r6_AMOUNT_AED_INACTIVE) {
		R6_AMOUNT_AED_INACTIVE = r6_AMOUNT_AED_INACTIVE;
	}
	public BigDecimal getR6_ACCOUNTS_FCY_INACTIVE() {
		return R6_ACCOUNTS_FCY_INACTIVE;
	}
	public void setR6_ACCOUNTS_FCY_INACTIVE(BigDecimal r6_ACCOUNTS_FCY_INACTIVE) {
		R6_ACCOUNTS_FCY_INACTIVE = r6_ACCOUNTS_FCY_INACTIVE;
	}
	public BigDecimal getR6_AMOUNT_FCY_INACTIVE() {
		return R6_AMOUNT_FCY_INACTIVE;
	}
	public void setR6_AMOUNT_FCY_INACTIVE(BigDecimal r6_AMOUNT_FCY_INACTIVE) {
		R6_AMOUNT_FCY_INACTIVE = r6_AMOUNT_FCY_INACTIVE;
	}
	public BigDecimal getR6_ACCOUNTS_AED_DORMANT() {
		return R6_ACCOUNTS_AED_DORMANT;
	}
	public void setR6_ACCOUNTS_AED_DORMANT(BigDecimal r6_ACCOUNTS_AED_DORMANT) {
		R6_ACCOUNTS_AED_DORMANT = r6_ACCOUNTS_AED_DORMANT;
	}
	public BigDecimal getR6_AMOUNT_AED_DORMANT() {
		return R6_AMOUNT_AED_DORMANT;
	}
	public void setR6_AMOUNT_AED_DORMANT(BigDecimal r6_AMOUNT_AED_DORMANT) {
		R6_AMOUNT_AED_DORMANT = r6_AMOUNT_AED_DORMANT;
	}
	public BigDecimal getR6_ACCOUNTS_FCY_DORMANT() {
		return R6_ACCOUNTS_FCY_DORMANT;
	}
	public void setR6_ACCOUNTS_FCY_DORMANT(BigDecimal r6_ACCOUNTS_FCY_DORMANT) {
		R6_ACCOUNTS_FCY_DORMANT = r6_ACCOUNTS_FCY_DORMANT;
	}
	public BigDecimal getR6_AMOUNT_FCY_DORMANT() {
		return R6_AMOUNT_FCY_DORMANT;
	}
	public void setR6_AMOUNT_FCY_DORMANT(BigDecimal r6_AMOUNT_FCY_DORMANT) {
		R6_AMOUNT_FCY_DORMANT = r6_AMOUNT_FCY_DORMANT;
	}
	public String getR7_S_NO() {
		return R7_S_NO;
	}
	public void setR7_S_NO(String r7_S_NO) {
		R7_S_NO = r7_S_NO;
	}
	public String getR7_REGULATIONS() {
		return R7_REGULATIONS;
	}
	public void setR7_REGULATIONS(String r7_REGULATIONS) {
		R7_REGULATIONS = r7_REGULATIONS;
	}
	public String getR7_DORMANT() {
		return R7_DORMANT;
	}
	public void setR7_DORMANT(String r7_DORMANT) {
		R7_DORMANT = r7_DORMANT;
	}
	public BigDecimal getR7_ACCOUNTS_AED_1YEAR() {
		return R7_ACCOUNTS_AED_1YEAR;
	}
	public void setR7_ACCOUNTS_AED_1YEAR(BigDecimal r7_ACCOUNTS_AED_1YEAR) {
		R7_ACCOUNTS_AED_1YEAR = r7_ACCOUNTS_AED_1YEAR;
	}
	public BigDecimal getR7_AMOUNT_AED_1YEAR() {
		return R7_AMOUNT_AED_1YEAR;
	}
	public void setR7_AMOUNT_AED_1YEAR(BigDecimal r7_AMOUNT_AED_1YEAR) {
		R7_AMOUNT_AED_1YEAR = r7_AMOUNT_AED_1YEAR;
	}
	public BigDecimal getR7_ACCOUNTS_FCY_1YEAR() {
		return R7_ACCOUNTS_FCY_1YEAR;
	}
	public void setR7_ACCOUNTS_FCY_1YEAR(BigDecimal r7_ACCOUNTS_FCY_1YEAR) {
		R7_ACCOUNTS_FCY_1YEAR = r7_ACCOUNTS_FCY_1YEAR;
	}
	public BigDecimal getR7_AMOUNT_FCY_1YEAR() {
		return R7_AMOUNT_FCY_1YEAR;
	}
	public void setR7_AMOUNT_FCY_1YEAR(BigDecimal r7_AMOUNT_FCY_1YEAR) {
		R7_AMOUNT_FCY_1YEAR = r7_AMOUNT_FCY_1YEAR;
	}
	public BigDecimal getR7_ACCOUNTS_AED_2YEAR() {
		return R7_ACCOUNTS_AED_2YEAR;
	}
	public void setR7_ACCOUNTS_AED_2YEAR(BigDecimal r7_ACCOUNTS_AED_2YEAR) {
		R7_ACCOUNTS_AED_2YEAR = r7_ACCOUNTS_AED_2YEAR;
	}
	public BigDecimal getR7_AMOUNT_AED_2YEAR() {
		return R7_AMOUNT_AED_2YEAR;
	}
	public void setR7_AMOUNT_AED_2YEAR(BigDecimal r7_AMOUNT_AED_2YEAR) {
		R7_AMOUNT_AED_2YEAR = r7_AMOUNT_AED_2YEAR;
	}
	public BigDecimal getR7_ACCOUNTS_FCY_2YEAR() {
		return R7_ACCOUNTS_FCY_2YEAR;
	}
	public void setR7_ACCOUNTS_FCY_2YEAR(BigDecimal r7_ACCOUNTS_FCY_2YEAR) {
		R7_ACCOUNTS_FCY_2YEAR = r7_ACCOUNTS_FCY_2YEAR;
	}
	public BigDecimal getR7_AMOUNT_FCY_2YEAR() {
		return R7_AMOUNT_FCY_2YEAR;
	}
	public void setR7_AMOUNT_FCY_2YEAR(BigDecimal r7_AMOUNT_FCY_2YEAR) {
		R7_AMOUNT_FCY_2YEAR = r7_AMOUNT_FCY_2YEAR;
	}
	public BigDecimal getR7_ACCOUNTS_AED_3YEAR() {
		return R7_ACCOUNTS_AED_3YEAR;
	}
	public void setR7_ACCOUNTS_AED_3YEAR(BigDecimal r7_ACCOUNTS_AED_3YEAR) {
		R7_ACCOUNTS_AED_3YEAR = r7_ACCOUNTS_AED_3YEAR;
	}
	public BigDecimal getR7_AMOUNT_AED_3YEAR() {
		return R7_AMOUNT_AED_3YEAR;
	}
	public void setR7_AMOUNT_AED_3YEAR(BigDecimal r7_AMOUNT_AED_3YEAR) {
		R7_AMOUNT_AED_3YEAR = r7_AMOUNT_AED_3YEAR;
	}
	public BigDecimal getR7_ACCOUNTS_FCY_3YEAR() {
		return R7_ACCOUNTS_FCY_3YEAR;
	}
	public void setR7_ACCOUNTS_FCY_3YEAR(BigDecimal r7_ACCOUNTS_FCY_3YEAR) {
		R7_ACCOUNTS_FCY_3YEAR = r7_ACCOUNTS_FCY_3YEAR;
	}
	public BigDecimal getR7_AMOUNT_FCY_3YEAR() {
		return R7_AMOUNT_FCY_3YEAR;
	}
	public void setR7_AMOUNT_FCY_3YEAR(BigDecimal r7_AMOUNT_FCY_3YEAR) {
		R7_AMOUNT_FCY_3YEAR = r7_AMOUNT_FCY_3YEAR;
	}
	public BigDecimal getR7_ACCOUNTS_AED_5YEAR() {
		return R7_ACCOUNTS_AED_5YEAR;
	}
	public void setR7_ACCOUNTS_AED_5YEAR(BigDecimal r7_ACCOUNTS_AED_5YEAR) {
		R7_ACCOUNTS_AED_5YEAR = r7_ACCOUNTS_AED_5YEAR;
	}
	public BigDecimal getR7_AMOUNT_AED_5YEAR() {
		return R7_AMOUNT_AED_5YEAR;
	}
	public void setR7_AMOUNT_AED_5YEAR(BigDecimal r7_AMOUNT_AED_5YEAR) {
		R7_AMOUNT_AED_5YEAR = r7_AMOUNT_AED_5YEAR;
	}
	public BigDecimal getR7_ACCOUNTS_FCY_5YEAR() {
		return R7_ACCOUNTS_FCY_5YEAR;
	}
	public void setR7_ACCOUNTS_FCY_5YEAR(BigDecimal r7_ACCOUNTS_FCY_5YEAR) {
		R7_ACCOUNTS_FCY_5YEAR = r7_ACCOUNTS_FCY_5YEAR;
	}
	public BigDecimal getR7_AMOUNT_FCY_5YEAR() {
		return R7_AMOUNT_FCY_5YEAR;
	}
	public void setR7_AMOUNT_FCY_5YEAR(BigDecimal r7_AMOUNT_FCY_5YEAR) {
		R7_AMOUNT_FCY_5YEAR = r7_AMOUNT_FCY_5YEAR;
	}
	public BigDecimal getR7_ACCOUNTS_AED_ABOVE() {
		return R7_ACCOUNTS_AED_ABOVE;
	}
	public void setR7_ACCOUNTS_AED_ABOVE(BigDecimal r7_ACCOUNTS_AED_ABOVE) {
		R7_ACCOUNTS_AED_ABOVE = r7_ACCOUNTS_AED_ABOVE;
	}
	public BigDecimal getR7_AMOUNT_AED_ABOVE() {
		return R7_AMOUNT_AED_ABOVE;
	}
	public void setR7_AMOUNT_AED_ABOVE(BigDecimal r7_AMOUNT_AED_ABOVE) {
		R7_AMOUNT_AED_ABOVE = r7_AMOUNT_AED_ABOVE;
	}
	public BigDecimal getR7_ACCOUNTS_FCY_ABOVE() {
		return R7_ACCOUNTS_FCY_ABOVE;
	}
	public void setR7_ACCOUNTS_FCY_ABOVE(BigDecimal r7_ACCOUNTS_FCY_ABOVE) {
		R7_ACCOUNTS_FCY_ABOVE = r7_ACCOUNTS_FCY_ABOVE;
	}
	public BigDecimal getR7_AMOUNT_FCY_ABOVE() {
		return R7_AMOUNT_FCY_ABOVE;
	}
	public void setR7_AMOUNT_FCY_ABOVE(BigDecimal r7_AMOUNT_FCY_ABOVE) {
		R7_AMOUNT_FCY_ABOVE = r7_AMOUNT_FCY_ABOVE;
	}
	public BigDecimal getR7_ACCOUNTS_AED_INACTIVE() {
		return R7_ACCOUNTS_AED_INACTIVE;
	}
	public void setR7_ACCOUNTS_AED_INACTIVE(BigDecimal r7_ACCOUNTS_AED_INACTIVE) {
		R7_ACCOUNTS_AED_INACTIVE = r7_ACCOUNTS_AED_INACTIVE;
	}
	public BigDecimal getR7_AMOUNT_AED_INACTIVE() {
		return R7_AMOUNT_AED_INACTIVE;
	}
	public void setR7_AMOUNT_AED_INACTIVE(BigDecimal r7_AMOUNT_AED_INACTIVE) {
		R7_AMOUNT_AED_INACTIVE = r7_AMOUNT_AED_INACTIVE;
	}
	public BigDecimal getR7_ACCOUNTS_FCY_INACTIVE() {
		return R7_ACCOUNTS_FCY_INACTIVE;
	}
	public void setR7_ACCOUNTS_FCY_INACTIVE(BigDecimal r7_ACCOUNTS_FCY_INACTIVE) {
		R7_ACCOUNTS_FCY_INACTIVE = r7_ACCOUNTS_FCY_INACTIVE;
	}
	public BigDecimal getR7_AMOUNT_FCY_INACTIVE() {
		return R7_AMOUNT_FCY_INACTIVE;
	}
	public void setR7_AMOUNT_FCY_INACTIVE(BigDecimal r7_AMOUNT_FCY_INACTIVE) {
		R7_AMOUNT_FCY_INACTIVE = r7_AMOUNT_FCY_INACTIVE;
	}
	public BigDecimal getR7_ACCOUNTS_AED_DORMANT() {
		return R7_ACCOUNTS_AED_DORMANT;
	}
	public void setR7_ACCOUNTS_AED_DORMANT(BigDecimal r7_ACCOUNTS_AED_DORMANT) {
		R7_ACCOUNTS_AED_DORMANT = r7_ACCOUNTS_AED_DORMANT;
	}
	public BigDecimal getR7_AMOUNT_AED_DORMANT() {
		return R7_AMOUNT_AED_DORMANT;
	}
	public void setR7_AMOUNT_AED_DORMANT(BigDecimal r7_AMOUNT_AED_DORMANT) {
		R7_AMOUNT_AED_DORMANT = r7_AMOUNT_AED_DORMANT;
	}
	public BigDecimal getR7_ACCOUNTS_FCY_DORMANT() {
		return R7_ACCOUNTS_FCY_DORMANT;
	}
	public void setR7_ACCOUNTS_FCY_DORMANT(BigDecimal r7_ACCOUNTS_FCY_DORMANT) {
		R7_ACCOUNTS_FCY_DORMANT = r7_ACCOUNTS_FCY_DORMANT;
	}
	public BigDecimal getR7_AMOUNT_FCY_DORMANT() {
		return R7_AMOUNT_FCY_DORMANT;
	}
	public void setR7_AMOUNT_FCY_DORMANT(BigDecimal r7_AMOUNT_FCY_DORMANT) {
		R7_AMOUNT_FCY_DORMANT = r7_AMOUNT_FCY_DORMANT;
	}
	public String getR8_S_NO() {
		return R8_S_NO;
	}
	public void setR8_S_NO(String r8_S_NO) {
		R8_S_NO = r8_S_NO;
	}
	public String getR8_REGULATIONS() {
		return R8_REGULATIONS;
	}
	public void setR8_REGULATIONS(String r8_REGULATIONS) {
		R8_REGULATIONS = r8_REGULATIONS;
	}
	public String getR8_DORMANT() {
		return R8_DORMANT;
	}
	public void setR8_DORMANT(String r8_DORMANT) {
		R8_DORMANT = r8_DORMANT;
	}
	public BigDecimal getR8_ACCOUNTS_AED_1YEAR() {
		return R8_ACCOUNTS_AED_1YEAR;
	}
	public void setR8_ACCOUNTS_AED_1YEAR(BigDecimal r8_ACCOUNTS_AED_1YEAR) {
		R8_ACCOUNTS_AED_1YEAR = r8_ACCOUNTS_AED_1YEAR;
	}
	public BigDecimal getR8_AMOUNT_AED_1YEAR() {
		return R8_AMOUNT_AED_1YEAR;
	}
	public void setR8_AMOUNT_AED_1YEAR(BigDecimal r8_AMOUNT_AED_1YEAR) {
		R8_AMOUNT_AED_1YEAR = r8_AMOUNT_AED_1YEAR;
	}
	public BigDecimal getR8_ACCOUNTS_FCY_1YEAR() {
		return R8_ACCOUNTS_FCY_1YEAR;
	}
	public void setR8_ACCOUNTS_FCY_1YEAR(BigDecimal r8_ACCOUNTS_FCY_1YEAR) {
		R8_ACCOUNTS_FCY_1YEAR = r8_ACCOUNTS_FCY_1YEAR;
	}
	public BigDecimal getR8_AMOUNT_FCY_1YEAR() {
		return R8_AMOUNT_FCY_1YEAR;
	}
	public void setR8_AMOUNT_FCY_1YEAR(BigDecimal r8_AMOUNT_FCY_1YEAR) {
		R8_AMOUNT_FCY_1YEAR = r8_AMOUNT_FCY_1YEAR;
	}
	public BigDecimal getR8_ACCOUNTS_AED_2YEAR() {
		return R8_ACCOUNTS_AED_2YEAR;
	}
	public void setR8_ACCOUNTS_AED_2YEAR(BigDecimal r8_ACCOUNTS_AED_2YEAR) {
		R8_ACCOUNTS_AED_2YEAR = r8_ACCOUNTS_AED_2YEAR;
	}
	public BigDecimal getR8_AMOUNT_AED_2YEAR() {
		return R8_AMOUNT_AED_2YEAR;
	}
	public void setR8_AMOUNT_AED_2YEAR(BigDecimal r8_AMOUNT_AED_2YEAR) {
		R8_AMOUNT_AED_2YEAR = r8_AMOUNT_AED_2YEAR;
	}
	public BigDecimal getR8_ACCOUNTS_FCY_2YEAR() {
		return R8_ACCOUNTS_FCY_2YEAR;
	}
	public void setR8_ACCOUNTS_FCY_2YEAR(BigDecimal r8_ACCOUNTS_FCY_2YEAR) {
		R8_ACCOUNTS_FCY_2YEAR = r8_ACCOUNTS_FCY_2YEAR;
	}
	public BigDecimal getR8_AMOUNT_FCY_2YEAR() {
		return R8_AMOUNT_FCY_2YEAR;
	}
	public void setR8_AMOUNT_FCY_2YEAR(BigDecimal r8_AMOUNT_FCY_2YEAR) {
		R8_AMOUNT_FCY_2YEAR = r8_AMOUNT_FCY_2YEAR;
	}
	public BigDecimal getR8_ACCOUNTS_AED_3YEAR() {
		return R8_ACCOUNTS_AED_3YEAR;
	}
	public void setR8_ACCOUNTS_AED_3YEAR(BigDecimal r8_ACCOUNTS_AED_3YEAR) {
		R8_ACCOUNTS_AED_3YEAR = r8_ACCOUNTS_AED_3YEAR;
	}
	public BigDecimal getR8_AMOUNT_AED_3YEAR() {
		return R8_AMOUNT_AED_3YEAR;
	}
	public void setR8_AMOUNT_AED_3YEAR(BigDecimal r8_AMOUNT_AED_3YEAR) {
		R8_AMOUNT_AED_3YEAR = r8_AMOUNT_AED_3YEAR;
	}
	public BigDecimal getR8_ACCOUNTS_FCY_3YEAR() {
		return R8_ACCOUNTS_FCY_3YEAR;
	}
	public void setR8_ACCOUNTS_FCY_3YEAR(BigDecimal r8_ACCOUNTS_FCY_3YEAR) {
		R8_ACCOUNTS_FCY_3YEAR = r8_ACCOUNTS_FCY_3YEAR;
	}
	public BigDecimal getR8_AMOUNT_FCY_3YEAR() {
		return R8_AMOUNT_FCY_3YEAR;
	}
	public void setR8_AMOUNT_FCY_3YEAR(BigDecimal r8_AMOUNT_FCY_3YEAR) {
		R8_AMOUNT_FCY_3YEAR = r8_AMOUNT_FCY_3YEAR;
	}
	public BigDecimal getR8_ACCOUNTS_AED_5YEAR() {
		return R8_ACCOUNTS_AED_5YEAR;
	}
	public void setR8_ACCOUNTS_AED_5YEAR(BigDecimal r8_ACCOUNTS_AED_5YEAR) {
		R8_ACCOUNTS_AED_5YEAR = r8_ACCOUNTS_AED_5YEAR;
	}
	public BigDecimal getR8_AMOUNT_AED_5YEAR() {
		return R8_AMOUNT_AED_5YEAR;
	}
	public void setR8_AMOUNT_AED_5YEAR(BigDecimal r8_AMOUNT_AED_5YEAR) {
		R8_AMOUNT_AED_5YEAR = r8_AMOUNT_AED_5YEAR;
	}
	public BigDecimal getR8_ACCOUNTS_FCY_5YEAR() {
		return R8_ACCOUNTS_FCY_5YEAR;
	}
	public void setR8_ACCOUNTS_FCY_5YEAR(BigDecimal r8_ACCOUNTS_FCY_5YEAR) {
		R8_ACCOUNTS_FCY_5YEAR = r8_ACCOUNTS_FCY_5YEAR;
	}
	public BigDecimal getR8_AMOUNT_FCY_5YEAR() {
		return R8_AMOUNT_FCY_5YEAR;
	}
	public void setR8_AMOUNT_FCY_5YEAR(BigDecimal r8_AMOUNT_FCY_5YEAR) {
		R8_AMOUNT_FCY_5YEAR = r8_AMOUNT_FCY_5YEAR;
	}
	public BigDecimal getR8_ACCOUNTS_AED_ABOVE() {
		return R8_ACCOUNTS_AED_ABOVE;
	}
	public void setR8_ACCOUNTS_AED_ABOVE(BigDecimal r8_ACCOUNTS_AED_ABOVE) {
		R8_ACCOUNTS_AED_ABOVE = r8_ACCOUNTS_AED_ABOVE;
	}
	public BigDecimal getR8_AMOUNT_AED_ABOVE() {
		return R8_AMOUNT_AED_ABOVE;
	}
	public void setR8_AMOUNT_AED_ABOVE(BigDecimal r8_AMOUNT_AED_ABOVE) {
		R8_AMOUNT_AED_ABOVE = r8_AMOUNT_AED_ABOVE;
	}
	public BigDecimal getR8_ACCOUNTS_FCY_ABOVE() {
		return R8_ACCOUNTS_FCY_ABOVE;
	}
	public void setR8_ACCOUNTS_FCY_ABOVE(BigDecimal r8_ACCOUNTS_FCY_ABOVE) {
		R8_ACCOUNTS_FCY_ABOVE = r8_ACCOUNTS_FCY_ABOVE;
	}
	public BigDecimal getR8_AMOUNT_FCY_ABOVE() {
		return R8_AMOUNT_FCY_ABOVE;
	}
	public void setR8_AMOUNT_FCY_ABOVE(BigDecimal r8_AMOUNT_FCY_ABOVE) {
		R8_AMOUNT_FCY_ABOVE = r8_AMOUNT_FCY_ABOVE;
	}
	public BigDecimal getR8_ACCOUNTS_AED_INACTIVE() {
		return R8_ACCOUNTS_AED_INACTIVE;
	}
	public void setR8_ACCOUNTS_AED_INACTIVE(BigDecimal r8_ACCOUNTS_AED_INACTIVE) {
		R8_ACCOUNTS_AED_INACTIVE = r8_ACCOUNTS_AED_INACTIVE;
	}
	public BigDecimal getR8_AMOUNT_AED_INACTIVE() {
		return R8_AMOUNT_AED_INACTIVE;
	}
	public void setR8_AMOUNT_AED_INACTIVE(BigDecimal r8_AMOUNT_AED_INACTIVE) {
		R8_AMOUNT_AED_INACTIVE = r8_AMOUNT_AED_INACTIVE;
	}
	public BigDecimal getR8_ACCOUNTS_FCY_INACTIVE() {
		return R8_ACCOUNTS_FCY_INACTIVE;
	}
	public void setR8_ACCOUNTS_FCY_INACTIVE(BigDecimal r8_ACCOUNTS_FCY_INACTIVE) {
		R8_ACCOUNTS_FCY_INACTIVE = r8_ACCOUNTS_FCY_INACTIVE;
	}
	public BigDecimal getR8_AMOUNT_FCY_INACTIVE() {
		return R8_AMOUNT_FCY_INACTIVE;
	}
	public void setR8_AMOUNT_FCY_INACTIVE(BigDecimal r8_AMOUNT_FCY_INACTIVE) {
		R8_AMOUNT_FCY_INACTIVE = r8_AMOUNT_FCY_INACTIVE;
	}
	public BigDecimal getR8_ACCOUNTS_AED_DORMANT() {
		return R8_ACCOUNTS_AED_DORMANT;
	}
	public void setR8_ACCOUNTS_AED_DORMANT(BigDecimal r8_ACCOUNTS_AED_DORMANT) {
		R8_ACCOUNTS_AED_DORMANT = r8_ACCOUNTS_AED_DORMANT;
	}
	public BigDecimal getR8_AMOUNT_AED_DORMANT() {
		return R8_AMOUNT_AED_DORMANT;
	}
	public void setR8_AMOUNT_AED_DORMANT(BigDecimal r8_AMOUNT_AED_DORMANT) {
		R8_AMOUNT_AED_DORMANT = r8_AMOUNT_AED_DORMANT;
	}
	public BigDecimal getR8_ACCOUNTS_FCY_DORMANT() {
		return R8_ACCOUNTS_FCY_DORMANT;
	}
	public void setR8_ACCOUNTS_FCY_DORMANT(BigDecimal r8_ACCOUNTS_FCY_DORMANT) {
		R8_ACCOUNTS_FCY_DORMANT = r8_ACCOUNTS_FCY_DORMANT;
	}
	public BigDecimal getR8_AMOUNT_FCY_DORMANT() {
		return R8_AMOUNT_FCY_DORMANT;
	}
	public void setR8_AMOUNT_FCY_DORMANT(BigDecimal r8_AMOUNT_FCY_DORMANT) {
		R8_AMOUNT_FCY_DORMANT = r8_AMOUNT_FCY_DORMANT;
	}
	public String getR9_S_NO() {
		return R9_S_NO;
	}
	public void setR9_S_NO(String r9_S_NO) {
		R9_S_NO = r9_S_NO;
	}
	public String getR9_REGULATIONS() {
		return R9_REGULATIONS;
	}
	public void setR9_REGULATIONS(String r9_REGULATIONS) {
		R9_REGULATIONS = r9_REGULATIONS;
	}
	public String getR9_DORMANT() {
		return R9_DORMANT;
	}
	public void setR9_DORMANT(String r9_DORMANT) {
		R9_DORMANT = r9_DORMANT;
	}
	public BigDecimal getR9_ACCOUNTS_AED_1YEAR() {
		return R9_ACCOUNTS_AED_1YEAR;
	}
	public void setR9_ACCOUNTS_AED_1YEAR(BigDecimal r9_ACCOUNTS_AED_1YEAR) {
		R9_ACCOUNTS_AED_1YEAR = r9_ACCOUNTS_AED_1YEAR;
	}
	public BigDecimal getR9_AMOUNT_AED_1YEAR() {
		return R9_AMOUNT_AED_1YEAR;
	}
	public void setR9_AMOUNT_AED_1YEAR(BigDecimal r9_AMOUNT_AED_1YEAR) {
		R9_AMOUNT_AED_1YEAR = r9_AMOUNT_AED_1YEAR;
	}
	public BigDecimal getR9_ACCOUNTS_FCY_1YEAR() {
		return R9_ACCOUNTS_FCY_1YEAR;
	}
	public void setR9_ACCOUNTS_FCY_1YEAR(BigDecimal r9_ACCOUNTS_FCY_1YEAR) {
		R9_ACCOUNTS_FCY_1YEAR = r9_ACCOUNTS_FCY_1YEAR;
	}
	public BigDecimal getR9_AMOUNT_FCY_1YEAR() {
		return R9_AMOUNT_FCY_1YEAR;
	}
	public void setR9_AMOUNT_FCY_1YEAR(BigDecimal r9_AMOUNT_FCY_1YEAR) {
		R9_AMOUNT_FCY_1YEAR = r9_AMOUNT_FCY_1YEAR;
	}
	public BigDecimal getR9_ACCOUNTS_AED_2YEAR() {
		return R9_ACCOUNTS_AED_2YEAR;
	}
	public void setR9_ACCOUNTS_AED_2YEAR(BigDecimal r9_ACCOUNTS_AED_2YEAR) {
		R9_ACCOUNTS_AED_2YEAR = r9_ACCOUNTS_AED_2YEAR;
	}
	public BigDecimal getR9_AMOUNT_AED_2YEAR() {
		return R9_AMOUNT_AED_2YEAR;
	}
	public void setR9_AMOUNT_AED_2YEAR(BigDecimal r9_AMOUNT_AED_2YEAR) {
		R9_AMOUNT_AED_2YEAR = r9_AMOUNT_AED_2YEAR;
	}
	public BigDecimal getR9_ACCOUNTS_FCY_2YEAR() {
		return R9_ACCOUNTS_FCY_2YEAR;
	}
	public void setR9_ACCOUNTS_FCY_2YEAR(BigDecimal r9_ACCOUNTS_FCY_2YEAR) {
		R9_ACCOUNTS_FCY_2YEAR = r9_ACCOUNTS_FCY_2YEAR;
	}
	public BigDecimal getR9_AMOUNT_FCY_2YEAR() {
		return R9_AMOUNT_FCY_2YEAR;
	}
	public void setR9_AMOUNT_FCY_2YEAR(BigDecimal r9_AMOUNT_FCY_2YEAR) {
		R9_AMOUNT_FCY_2YEAR = r9_AMOUNT_FCY_2YEAR;
	}
	public BigDecimal getR9_ACCOUNTS_AED_3YEAR() {
		return R9_ACCOUNTS_AED_3YEAR;
	}
	public void setR9_ACCOUNTS_AED_3YEAR(BigDecimal r9_ACCOUNTS_AED_3YEAR) {
		R9_ACCOUNTS_AED_3YEAR = r9_ACCOUNTS_AED_3YEAR;
	}
	public BigDecimal getR9_AMOUNT_AED_3YEAR() {
		return R9_AMOUNT_AED_3YEAR;
	}
	public void setR9_AMOUNT_AED_3YEAR(BigDecimal r9_AMOUNT_AED_3YEAR) {
		R9_AMOUNT_AED_3YEAR = r9_AMOUNT_AED_3YEAR;
	}
	public BigDecimal getR9_ACCOUNTS_FCY_3YEAR() {
		return R9_ACCOUNTS_FCY_3YEAR;
	}
	public void setR9_ACCOUNTS_FCY_3YEAR(BigDecimal r9_ACCOUNTS_FCY_3YEAR) {
		R9_ACCOUNTS_FCY_3YEAR = r9_ACCOUNTS_FCY_3YEAR;
	}
	public BigDecimal getR9_AMOUNT_FCY_3YEAR() {
		return R9_AMOUNT_FCY_3YEAR;
	}
	public void setR9_AMOUNT_FCY_3YEAR(BigDecimal r9_AMOUNT_FCY_3YEAR) {
		R9_AMOUNT_FCY_3YEAR = r9_AMOUNT_FCY_3YEAR;
	}
	public BigDecimal getR9_ACCOUNTS_AED_5YEAR() {
		return R9_ACCOUNTS_AED_5YEAR;
	}
	public void setR9_ACCOUNTS_AED_5YEAR(BigDecimal r9_ACCOUNTS_AED_5YEAR) {
		R9_ACCOUNTS_AED_5YEAR = r9_ACCOUNTS_AED_5YEAR;
	}
	public BigDecimal getR9_AMOUNT_AED_5YEAR() {
		return R9_AMOUNT_AED_5YEAR;
	}
	public void setR9_AMOUNT_AED_5YEAR(BigDecimal r9_AMOUNT_AED_5YEAR) {
		R9_AMOUNT_AED_5YEAR = r9_AMOUNT_AED_5YEAR;
	}
	public BigDecimal getR9_ACCOUNTS_FCY_5YEAR() {
		return R9_ACCOUNTS_FCY_5YEAR;
	}
	public void setR9_ACCOUNTS_FCY_5YEAR(BigDecimal r9_ACCOUNTS_FCY_5YEAR) {
		R9_ACCOUNTS_FCY_5YEAR = r9_ACCOUNTS_FCY_5YEAR;
	}
	public BigDecimal getR9_AMOUNT_FCY_5YEAR() {
		return R9_AMOUNT_FCY_5YEAR;
	}
	public void setR9_AMOUNT_FCY_5YEAR(BigDecimal r9_AMOUNT_FCY_5YEAR) {
		R9_AMOUNT_FCY_5YEAR = r9_AMOUNT_FCY_5YEAR;
	}
	public BigDecimal getR9_ACCOUNTS_AED_ABOVE() {
		return R9_ACCOUNTS_AED_ABOVE;
	}
	public void setR9_ACCOUNTS_AED_ABOVE(BigDecimal r9_ACCOUNTS_AED_ABOVE) {
		R9_ACCOUNTS_AED_ABOVE = r9_ACCOUNTS_AED_ABOVE;
	}
	public BigDecimal getR9_AMOUNT_AED_ABOVE() {
		return R9_AMOUNT_AED_ABOVE;
	}
	public void setR9_AMOUNT_AED_ABOVE(BigDecimal r9_AMOUNT_AED_ABOVE) {
		R9_AMOUNT_AED_ABOVE = r9_AMOUNT_AED_ABOVE;
	}
	public BigDecimal getR9_ACCOUNTS_FCY_ABOVE() {
		return R9_ACCOUNTS_FCY_ABOVE;
	}
	public void setR9_ACCOUNTS_FCY_ABOVE(BigDecimal r9_ACCOUNTS_FCY_ABOVE) {
		R9_ACCOUNTS_FCY_ABOVE = r9_ACCOUNTS_FCY_ABOVE;
	}
	public BigDecimal getR9_AMOUNT_FCY_ABOVE() {
		return R9_AMOUNT_FCY_ABOVE;
	}
	public void setR9_AMOUNT_FCY_ABOVE(BigDecimal r9_AMOUNT_FCY_ABOVE) {
		R9_AMOUNT_FCY_ABOVE = r9_AMOUNT_FCY_ABOVE;
	}
	public BigDecimal getR9_ACCOUNTS_AED_INACTIVE() {
		return R9_ACCOUNTS_AED_INACTIVE;
	}
	public void setR9_ACCOUNTS_AED_INACTIVE(BigDecimal r9_ACCOUNTS_AED_INACTIVE) {
		R9_ACCOUNTS_AED_INACTIVE = r9_ACCOUNTS_AED_INACTIVE;
	}
	public BigDecimal getR9_AMOUNT_AED_INACTIVE() {
		return R9_AMOUNT_AED_INACTIVE;
	}
	public void setR9_AMOUNT_AED_INACTIVE(BigDecimal r9_AMOUNT_AED_INACTIVE) {
		R9_AMOUNT_AED_INACTIVE = r9_AMOUNT_AED_INACTIVE;
	}
	public BigDecimal getR9_ACCOUNTS_FCY_INACTIVE() {
		return R9_ACCOUNTS_FCY_INACTIVE;
	}
	public void setR9_ACCOUNTS_FCY_INACTIVE(BigDecimal r9_ACCOUNTS_FCY_INACTIVE) {
		R9_ACCOUNTS_FCY_INACTIVE = r9_ACCOUNTS_FCY_INACTIVE;
	}
	public BigDecimal getR9_AMOUNT_FCY_INACTIVE() {
		return R9_AMOUNT_FCY_INACTIVE;
	}
	public void setR9_AMOUNT_FCY_INACTIVE(BigDecimal r9_AMOUNT_FCY_INACTIVE) {
		R9_AMOUNT_FCY_INACTIVE = r9_AMOUNT_FCY_INACTIVE;
	}
	public BigDecimal getR9_ACCOUNTS_AED_DORMANT() {
		return R9_ACCOUNTS_AED_DORMANT;
	}
	public void setR9_ACCOUNTS_AED_DORMANT(BigDecimal r9_ACCOUNTS_AED_DORMANT) {
		R9_ACCOUNTS_AED_DORMANT = r9_ACCOUNTS_AED_DORMANT;
	}
	public BigDecimal getR9_AMOUNT_AED_DORMANT() {
		return R9_AMOUNT_AED_DORMANT;
	}
	public void setR9_AMOUNT_AED_DORMANT(BigDecimal r9_AMOUNT_AED_DORMANT) {
		R9_AMOUNT_AED_DORMANT = r9_AMOUNT_AED_DORMANT;
	}
	public BigDecimal getR9_ACCOUNTS_FCY_DORMANT() {
		return R9_ACCOUNTS_FCY_DORMANT;
	}
	public void setR9_ACCOUNTS_FCY_DORMANT(BigDecimal r9_ACCOUNTS_FCY_DORMANT) {
		R9_ACCOUNTS_FCY_DORMANT = r9_ACCOUNTS_FCY_DORMANT;
	}
	public BigDecimal getR9_AMOUNT_FCY_DORMANT() {
		return R9_AMOUNT_FCY_DORMANT;
	}
	public void setR9_AMOUNT_FCY_DORMANT(BigDecimal r9_AMOUNT_FCY_DORMANT) {
		R9_AMOUNT_FCY_DORMANT = r9_AMOUNT_FCY_DORMANT;
	}
	public String getR10_S_NO() {
		return R10_S_NO;
	}
	public void setR10_S_NO(String r10_S_NO) {
		R10_S_NO = r10_S_NO;
	}
	public String getR10_REGULATIONS() {
		return R10_REGULATIONS;
	}
	public void setR10_REGULATIONS(String r10_REGULATIONS) {
		R10_REGULATIONS = r10_REGULATIONS;
	}
	public String getR10_DORMANT() {
		return R10_DORMANT;
	}
	public void setR10_DORMANT(String r10_DORMANT) {
		R10_DORMANT = r10_DORMANT;
	}
	public BigDecimal getR10_ACCOUNTS_AED_1YEAR() {
		return R10_ACCOUNTS_AED_1YEAR;
	}
	public void setR10_ACCOUNTS_AED_1YEAR(BigDecimal r10_ACCOUNTS_AED_1YEAR) {
		R10_ACCOUNTS_AED_1YEAR = r10_ACCOUNTS_AED_1YEAR;
	}
	public BigDecimal getR10_AMOUNT_AED_1YEAR() {
		return R10_AMOUNT_AED_1YEAR;
	}
	public void setR10_AMOUNT_AED_1YEAR(BigDecimal r10_AMOUNT_AED_1YEAR) {
		R10_AMOUNT_AED_1YEAR = r10_AMOUNT_AED_1YEAR;
	}
	public BigDecimal getR10_ACCOUNTS_FCY_1YEAR() {
		return R10_ACCOUNTS_FCY_1YEAR;
	}
	public void setR10_ACCOUNTS_FCY_1YEAR(BigDecimal r10_ACCOUNTS_FCY_1YEAR) {
		R10_ACCOUNTS_FCY_1YEAR = r10_ACCOUNTS_FCY_1YEAR;
	}
	public BigDecimal getR10_AMOUNT_FCY_1YEAR() {
		return R10_AMOUNT_FCY_1YEAR;
	}
	public void setR10_AMOUNT_FCY_1YEAR(BigDecimal r10_AMOUNT_FCY_1YEAR) {
		R10_AMOUNT_FCY_1YEAR = r10_AMOUNT_FCY_1YEAR;
	}
	public BigDecimal getR10_ACCOUNTS_AED_2YEAR() {
		return R10_ACCOUNTS_AED_2YEAR;
	}
	public void setR10_ACCOUNTS_AED_2YEAR(BigDecimal r10_ACCOUNTS_AED_2YEAR) {
		R10_ACCOUNTS_AED_2YEAR = r10_ACCOUNTS_AED_2YEAR;
	}
	public BigDecimal getR10_AMOUNT_AED_2YEAR() {
		return R10_AMOUNT_AED_2YEAR;
	}
	public void setR10_AMOUNT_AED_2YEAR(BigDecimal r10_AMOUNT_AED_2YEAR) {
		R10_AMOUNT_AED_2YEAR = r10_AMOUNT_AED_2YEAR;
	}
	public BigDecimal getR10_ACCOUNTS_FCY_2YEAR() {
		return R10_ACCOUNTS_FCY_2YEAR;
	}
	public void setR10_ACCOUNTS_FCY_2YEAR(BigDecimal r10_ACCOUNTS_FCY_2YEAR) {
		R10_ACCOUNTS_FCY_2YEAR = r10_ACCOUNTS_FCY_2YEAR;
	}
	public BigDecimal getR10_AMOUNT_FCY_2YEAR() {
		return R10_AMOUNT_FCY_2YEAR;
	}
	public void setR10_AMOUNT_FCY_2YEAR(BigDecimal r10_AMOUNT_FCY_2YEAR) {
		R10_AMOUNT_FCY_2YEAR = r10_AMOUNT_FCY_2YEAR;
	}
	public BigDecimal getR10_ACCOUNTS_AED_3YEAR() {
		return R10_ACCOUNTS_AED_3YEAR;
	}
	public void setR10_ACCOUNTS_AED_3YEAR(BigDecimal r10_ACCOUNTS_AED_3YEAR) {
		R10_ACCOUNTS_AED_3YEAR = r10_ACCOUNTS_AED_3YEAR;
	}
	public BigDecimal getR10_AMOUNT_AED_3YEAR() {
		return R10_AMOUNT_AED_3YEAR;
	}
	public void setR10_AMOUNT_AED_3YEAR(BigDecimal r10_AMOUNT_AED_3YEAR) {
		R10_AMOUNT_AED_3YEAR = r10_AMOUNT_AED_3YEAR;
	}
	public BigDecimal getR10_ACCOUNTS_FCY_3YEAR() {
		return R10_ACCOUNTS_FCY_3YEAR;
	}
	public void setR10_ACCOUNTS_FCY_3YEAR(BigDecimal r10_ACCOUNTS_FCY_3YEAR) {
		R10_ACCOUNTS_FCY_3YEAR = r10_ACCOUNTS_FCY_3YEAR;
	}
	public BigDecimal getR10_AMOUNT_FCY_3YEAR() {
		return R10_AMOUNT_FCY_3YEAR;
	}
	public void setR10_AMOUNT_FCY_3YEAR(BigDecimal r10_AMOUNT_FCY_3YEAR) {
		R10_AMOUNT_FCY_3YEAR = r10_AMOUNT_FCY_3YEAR;
	}
	public BigDecimal getR10_ACCOUNTS_AED_5YEAR() {
		return R10_ACCOUNTS_AED_5YEAR;
	}
	public void setR10_ACCOUNTS_AED_5YEAR(BigDecimal r10_ACCOUNTS_AED_5YEAR) {
		R10_ACCOUNTS_AED_5YEAR = r10_ACCOUNTS_AED_5YEAR;
	}
	public BigDecimal getR10_AMOUNT_AED_5YEAR() {
		return R10_AMOUNT_AED_5YEAR;
	}
	public void setR10_AMOUNT_AED_5YEAR(BigDecimal r10_AMOUNT_AED_5YEAR) {
		R10_AMOUNT_AED_5YEAR = r10_AMOUNT_AED_5YEAR;
	}
	public BigDecimal getR10_ACCOUNTS_FCY_5YEAR() {
		return R10_ACCOUNTS_FCY_5YEAR;
	}
	public void setR10_ACCOUNTS_FCY_5YEAR(BigDecimal r10_ACCOUNTS_FCY_5YEAR) {
		R10_ACCOUNTS_FCY_5YEAR = r10_ACCOUNTS_FCY_5YEAR;
	}
	public BigDecimal getR10_AMOUNT_FCY_5YEAR() {
		return R10_AMOUNT_FCY_5YEAR;
	}
	public void setR10_AMOUNT_FCY_5YEAR(BigDecimal r10_AMOUNT_FCY_5YEAR) {
		R10_AMOUNT_FCY_5YEAR = r10_AMOUNT_FCY_5YEAR;
	}
	public BigDecimal getR10_ACCOUNTS_AED_ABOVE() {
		return R10_ACCOUNTS_AED_ABOVE;
	}
	public void setR10_ACCOUNTS_AED_ABOVE(BigDecimal r10_ACCOUNTS_AED_ABOVE) {
		R10_ACCOUNTS_AED_ABOVE = r10_ACCOUNTS_AED_ABOVE;
	}
	public BigDecimal getR10_AMOUNT_AED_ABOVE() {
		return R10_AMOUNT_AED_ABOVE;
	}
	public void setR10_AMOUNT_AED_ABOVE(BigDecimal r10_AMOUNT_AED_ABOVE) {
		R10_AMOUNT_AED_ABOVE = r10_AMOUNT_AED_ABOVE;
	}
	public BigDecimal getR10_ACCOUNTS_FCY_ABOVE() {
		return R10_ACCOUNTS_FCY_ABOVE;
	}
	public void setR10_ACCOUNTS_FCY_ABOVE(BigDecimal r10_ACCOUNTS_FCY_ABOVE) {
		R10_ACCOUNTS_FCY_ABOVE = r10_ACCOUNTS_FCY_ABOVE;
	}
	public BigDecimal getR10_AMOUNT_FCY_ABOVE() {
		return R10_AMOUNT_FCY_ABOVE;
	}
	public void setR10_AMOUNT_FCY_ABOVE(BigDecimal r10_AMOUNT_FCY_ABOVE) {
		R10_AMOUNT_FCY_ABOVE = r10_AMOUNT_FCY_ABOVE;
	}
	public BigDecimal getR10_ACCOUNTS_AED_INACTIVE() {
		return R10_ACCOUNTS_AED_INACTIVE;
	}
	public void setR10_ACCOUNTS_AED_INACTIVE(BigDecimal r10_ACCOUNTS_AED_INACTIVE) {
		R10_ACCOUNTS_AED_INACTIVE = r10_ACCOUNTS_AED_INACTIVE;
	}
	public BigDecimal getR10_AMOUNT_AED_INACTIVE() {
		return R10_AMOUNT_AED_INACTIVE;
	}
	public void setR10_AMOUNT_AED_INACTIVE(BigDecimal r10_AMOUNT_AED_INACTIVE) {
		R10_AMOUNT_AED_INACTIVE = r10_AMOUNT_AED_INACTIVE;
	}
	public BigDecimal getR10_ACCOUNTS_FCY_INACTIVE() {
		return R10_ACCOUNTS_FCY_INACTIVE;
	}
	public void setR10_ACCOUNTS_FCY_INACTIVE(BigDecimal r10_ACCOUNTS_FCY_INACTIVE) {
		R10_ACCOUNTS_FCY_INACTIVE = r10_ACCOUNTS_FCY_INACTIVE;
	}
	public BigDecimal getR10_AMOUNT_FCY_INACTIVE() {
		return R10_AMOUNT_FCY_INACTIVE;
	}
	public void setR10_AMOUNT_FCY_INACTIVE(BigDecimal r10_AMOUNT_FCY_INACTIVE) {
		R10_AMOUNT_FCY_INACTIVE = r10_AMOUNT_FCY_INACTIVE;
	}
	public BigDecimal getR10_ACCOUNTS_AED_DORMANT() {
		return R10_ACCOUNTS_AED_DORMANT;
	}
	public void setR10_ACCOUNTS_AED_DORMANT(BigDecimal r10_ACCOUNTS_AED_DORMANT) {
		R10_ACCOUNTS_AED_DORMANT = r10_ACCOUNTS_AED_DORMANT;
	}
	public BigDecimal getR10_AMOUNT_AED_DORMANT() {
		return R10_AMOUNT_AED_DORMANT;
	}
	public void setR10_AMOUNT_AED_DORMANT(BigDecimal r10_AMOUNT_AED_DORMANT) {
		R10_AMOUNT_AED_DORMANT = r10_AMOUNT_AED_DORMANT;
	}
	public BigDecimal getR10_ACCOUNTS_FCY_DORMANT() {
		return R10_ACCOUNTS_FCY_DORMANT;
	}
	public void setR10_ACCOUNTS_FCY_DORMANT(BigDecimal r10_ACCOUNTS_FCY_DORMANT) {
		R10_ACCOUNTS_FCY_DORMANT = r10_ACCOUNTS_FCY_DORMANT;
	}
	public BigDecimal getR10_AMOUNT_FCY_DORMANT() {
		return R10_AMOUNT_FCY_DORMANT;
	}
	public void setR10_AMOUNT_FCY_DORMANT(BigDecimal r10_AMOUNT_FCY_DORMANT) {
		R10_AMOUNT_FCY_DORMANT = r10_AMOUNT_FCY_DORMANT;
	}
	public String getR11_S_NO() {
		return R11_S_NO;
	}
	public void setR11_S_NO(String r11_S_NO) {
		R11_S_NO = r11_S_NO;
	}
	public String getR11_REGULATIONS() {
		return R11_REGULATIONS;
	}
	public void setR11_REGULATIONS(String r11_REGULATIONS) {
		R11_REGULATIONS = r11_REGULATIONS;
	}
	public String getR11_DORMANT() {
		return R11_DORMANT;
	}
	public void setR11_DORMANT(String r11_DORMANT) {
		R11_DORMANT = r11_DORMANT;
	}
	public BigDecimal getR11_ACCOUNTS_AED_1YEAR() {
		return R11_ACCOUNTS_AED_1YEAR;
	}
	public void setR11_ACCOUNTS_AED_1YEAR(BigDecimal r11_ACCOUNTS_AED_1YEAR) {
		R11_ACCOUNTS_AED_1YEAR = r11_ACCOUNTS_AED_1YEAR;
	}
	public BigDecimal getR11_AMOUNT_AED_1YEAR() {
		return R11_AMOUNT_AED_1YEAR;
	}
	public void setR11_AMOUNT_AED_1YEAR(BigDecimal r11_AMOUNT_AED_1YEAR) {
		R11_AMOUNT_AED_1YEAR = r11_AMOUNT_AED_1YEAR;
	}
	public BigDecimal getR11_ACCOUNTS_FCY_1YEAR() {
		return R11_ACCOUNTS_FCY_1YEAR;
	}
	public void setR11_ACCOUNTS_FCY_1YEAR(BigDecimal r11_ACCOUNTS_FCY_1YEAR) {
		R11_ACCOUNTS_FCY_1YEAR = r11_ACCOUNTS_FCY_1YEAR;
	}
	public BigDecimal getR11_AMOUNT_FCY_1YEAR() {
		return R11_AMOUNT_FCY_1YEAR;
	}
	public void setR11_AMOUNT_FCY_1YEAR(BigDecimal r11_AMOUNT_FCY_1YEAR) {
		R11_AMOUNT_FCY_1YEAR = r11_AMOUNT_FCY_1YEAR;
	}
	public BigDecimal getR11_ACCOUNTS_AED_2YEAR() {
		return R11_ACCOUNTS_AED_2YEAR;
	}
	public void setR11_ACCOUNTS_AED_2YEAR(BigDecimal r11_ACCOUNTS_AED_2YEAR) {
		R11_ACCOUNTS_AED_2YEAR = r11_ACCOUNTS_AED_2YEAR;
	}
	public BigDecimal getR11_AMOUNT_AED_2YEAR() {
		return R11_AMOUNT_AED_2YEAR;
	}
	public void setR11_AMOUNT_AED_2YEAR(BigDecimal r11_AMOUNT_AED_2YEAR) {
		R11_AMOUNT_AED_2YEAR = r11_AMOUNT_AED_2YEAR;
	}
	public BigDecimal getR11_ACCOUNTS_FCY_2YEAR() {
		return R11_ACCOUNTS_FCY_2YEAR;
	}
	public void setR11_ACCOUNTS_FCY_2YEAR(BigDecimal r11_ACCOUNTS_FCY_2YEAR) {
		R11_ACCOUNTS_FCY_2YEAR = r11_ACCOUNTS_FCY_2YEAR;
	}
	public BigDecimal getR11_AMOUNT_FCY_2YEAR() {
		return R11_AMOUNT_FCY_2YEAR;
	}
	public void setR11_AMOUNT_FCY_2YEAR(BigDecimal r11_AMOUNT_FCY_2YEAR) {
		R11_AMOUNT_FCY_2YEAR = r11_AMOUNT_FCY_2YEAR;
	}
	public BigDecimal getR11_ACCOUNTS_AED_3YEAR() {
		return R11_ACCOUNTS_AED_3YEAR;
	}
	public void setR11_ACCOUNTS_AED_3YEAR(BigDecimal r11_ACCOUNTS_AED_3YEAR) {
		R11_ACCOUNTS_AED_3YEAR = r11_ACCOUNTS_AED_3YEAR;
	}
	public BigDecimal getR11_AMOUNT_AED_3YEAR() {
		return R11_AMOUNT_AED_3YEAR;
	}
	public void setR11_AMOUNT_AED_3YEAR(BigDecimal r11_AMOUNT_AED_3YEAR) {
		R11_AMOUNT_AED_3YEAR = r11_AMOUNT_AED_3YEAR;
	}
	public BigDecimal getR11_ACCOUNTS_FCY_3YEAR() {
		return R11_ACCOUNTS_FCY_3YEAR;
	}
	public void setR11_ACCOUNTS_FCY_3YEAR(BigDecimal r11_ACCOUNTS_FCY_3YEAR) {
		R11_ACCOUNTS_FCY_3YEAR = r11_ACCOUNTS_FCY_3YEAR;
	}
	public BigDecimal getR11_AMOUNT_FCY_3YEAR() {
		return R11_AMOUNT_FCY_3YEAR;
	}
	public void setR11_AMOUNT_FCY_3YEAR(BigDecimal r11_AMOUNT_FCY_3YEAR) {
		R11_AMOUNT_FCY_3YEAR = r11_AMOUNT_FCY_3YEAR;
	}
	public BigDecimal getR11_ACCOUNTS_AED_5YEAR() {
		return R11_ACCOUNTS_AED_5YEAR;
	}
	public void setR11_ACCOUNTS_AED_5YEAR(BigDecimal r11_ACCOUNTS_AED_5YEAR) {
		R11_ACCOUNTS_AED_5YEAR = r11_ACCOUNTS_AED_5YEAR;
	}
	public BigDecimal getR11_AMOUNT_AED_5YEAR() {
		return R11_AMOUNT_AED_5YEAR;
	}
	public void setR11_AMOUNT_AED_5YEAR(BigDecimal r11_AMOUNT_AED_5YEAR) {
		R11_AMOUNT_AED_5YEAR = r11_AMOUNT_AED_5YEAR;
	}
	public BigDecimal getR11_ACCOUNTS_FCY_5YEAR() {
		return R11_ACCOUNTS_FCY_5YEAR;
	}
	public void setR11_ACCOUNTS_FCY_5YEAR(BigDecimal r11_ACCOUNTS_FCY_5YEAR) {
		R11_ACCOUNTS_FCY_5YEAR = r11_ACCOUNTS_FCY_5YEAR;
	}
	public BigDecimal getR11_AMOUNT_FCY_5YEAR() {
		return R11_AMOUNT_FCY_5YEAR;
	}
	public void setR11_AMOUNT_FCY_5YEAR(BigDecimal r11_AMOUNT_FCY_5YEAR) {
		R11_AMOUNT_FCY_5YEAR = r11_AMOUNT_FCY_5YEAR;
	}
	public BigDecimal getR11_ACCOUNTS_AED_ABOVE() {
		return R11_ACCOUNTS_AED_ABOVE;
	}
	public void setR11_ACCOUNTS_AED_ABOVE(BigDecimal r11_ACCOUNTS_AED_ABOVE) {
		R11_ACCOUNTS_AED_ABOVE = r11_ACCOUNTS_AED_ABOVE;
	}
	public BigDecimal getR11_AMOUNT_AED_ABOVE() {
		return R11_AMOUNT_AED_ABOVE;
	}
	public void setR11_AMOUNT_AED_ABOVE(BigDecimal r11_AMOUNT_AED_ABOVE) {
		R11_AMOUNT_AED_ABOVE = r11_AMOUNT_AED_ABOVE;
	}
	public BigDecimal getR11_ACCOUNTS_FCY_ABOVE() {
		return R11_ACCOUNTS_FCY_ABOVE;
	}
	public void setR11_ACCOUNTS_FCY_ABOVE(BigDecimal r11_ACCOUNTS_FCY_ABOVE) {
		R11_ACCOUNTS_FCY_ABOVE = r11_ACCOUNTS_FCY_ABOVE;
	}
	public BigDecimal getR11_AMOUNT_FCY_ABOVE() {
		return R11_AMOUNT_FCY_ABOVE;
	}
	public void setR11_AMOUNT_FCY_ABOVE(BigDecimal r11_AMOUNT_FCY_ABOVE) {
		R11_AMOUNT_FCY_ABOVE = r11_AMOUNT_FCY_ABOVE;
	}
	public BigDecimal getR11_ACCOUNTS_AED_INACTIVE() {
		return R11_ACCOUNTS_AED_INACTIVE;
	}
	public void setR11_ACCOUNTS_AED_INACTIVE(BigDecimal r11_ACCOUNTS_AED_INACTIVE) {
		R11_ACCOUNTS_AED_INACTIVE = r11_ACCOUNTS_AED_INACTIVE;
	}
	public BigDecimal getR11_AMOUNT_AED_INACTIVE() {
		return R11_AMOUNT_AED_INACTIVE;
	}
	public void setR11_AMOUNT_AED_INACTIVE(BigDecimal r11_AMOUNT_AED_INACTIVE) {
		R11_AMOUNT_AED_INACTIVE = r11_AMOUNT_AED_INACTIVE;
	}
	public BigDecimal getR11_ACCOUNTS_FCY_INACTIVE() {
		return R11_ACCOUNTS_FCY_INACTIVE;
	}
	public void setR11_ACCOUNTS_FCY_INACTIVE(BigDecimal r11_ACCOUNTS_FCY_INACTIVE) {
		R11_ACCOUNTS_FCY_INACTIVE = r11_ACCOUNTS_FCY_INACTIVE;
	}
	public BigDecimal getR11_AMOUNT_FCY_INACTIVE() {
		return R11_AMOUNT_FCY_INACTIVE;
	}
	public void setR11_AMOUNT_FCY_INACTIVE(BigDecimal r11_AMOUNT_FCY_INACTIVE) {
		R11_AMOUNT_FCY_INACTIVE = r11_AMOUNT_FCY_INACTIVE;
	}
	public BigDecimal getR11_ACCOUNTS_AED_DORMANT() {
		return R11_ACCOUNTS_AED_DORMANT;
	}
	public void setR11_ACCOUNTS_AED_DORMANT(BigDecimal r11_ACCOUNTS_AED_DORMANT) {
		R11_ACCOUNTS_AED_DORMANT = r11_ACCOUNTS_AED_DORMANT;
	}
	public BigDecimal getR11_AMOUNT_AED_DORMANT() {
		return R11_AMOUNT_AED_DORMANT;
	}
	public void setR11_AMOUNT_AED_DORMANT(BigDecimal r11_AMOUNT_AED_DORMANT) {
		R11_AMOUNT_AED_DORMANT = r11_AMOUNT_AED_DORMANT;
	}
	public BigDecimal getR11_ACCOUNTS_FCY_DORMANT() {
		return R11_ACCOUNTS_FCY_DORMANT;
	}
	public void setR11_ACCOUNTS_FCY_DORMANT(BigDecimal r11_ACCOUNTS_FCY_DORMANT) {
		R11_ACCOUNTS_FCY_DORMANT = r11_ACCOUNTS_FCY_DORMANT;
	}
	public BigDecimal getR11_AMOUNT_FCY_DORMANT() {
		return R11_AMOUNT_FCY_DORMANT;
	}
	public void setR11_AMOUNT_FCY_DORMANT(BigDecimal r11_AMOUNT_FCY_DORMANT) {
		R11_AMOUNT_FCY_DORMANT = r11_AMOUNT_FCY_DORMANT;
	}
	public String getR12_S_NO() {
		return R12_S_NO;
	}
	public void setR12_S_NO(String r12_S_NO) {
		R12_S_NO = r12_S_NO;
	}
	public String getR12_REGULATIONS() {
		return R12_REGULATIONS;
	}
	public void setR12_REGULATIONS(String r12_REGULATIONS) {
		R12_REGULATIONS = r12_REGULATIONS;
	}
	public String getR12_DORMANT() {
		return R12_DORMANT;
	}
	public void setR12_DORMANT(String r12_DORMANT) {
		R12_DORMANT = r12_DORMANT;
	}
	public BigDecimal getR12_ACCOUNTS_AED_1YEAR() {
		return R12_ACCOUNTS_AED_1YEAR;
	}
	public void setR12_ACCOUNTS_AED_1YEAR(BigDecimal r12_ACCOUNTS_AED_1YEAR) {
		R12_ACCOUNTS_AED_1YEAR = r12_ACCOUNTS_AED_1YEAR;
	}
	public BigDecimal getR12_AMOUNT_AED_1YEAR() {
		return R12_AMOUNT_AED_1YEAR;
	}
	public void setR12_AMOUNT_AED_1YEAR(BigDecimal r12_AMOUNT_AED_1YEAR) {
		R12_AMOUNT_AED_1YEAR = r12_AMOUNT_AED_1YEAR;
	}
	public BigDecimal getR12_ACCOUNTS_FCY_1YEAR() {
		return R12_ACCOUNTS_FCY_1YEAR;
	}
	public void setR12_ACCOUNTS_FCY_1YEAR(BigDecimal r12_ACCOUNTS_FCY_1YEAR) {
		R12_ACCOUNTS_FCY_1YEAR = r12_ACCOUNTS_FCY_1YEAR;
	}
	public BigDecimal getR12_AMOUNT_FCY_1YEAR() {
		return R12_AMOUNT_FCY_1YEAR;
	}
	public void setR12_AMOUNT_FCY_1YEAR(BigDecimal r12_AMOUNT_FCY_1YEAR) {
		R12_AMOUNT_FCY_1YEAR = r12_AMOUNT_FCY_1YEAR;
	}
	public BigDecimal getR12_ACCOUNTS_AED_2YEAR() {
		return R12_ACCOUNTS_AED_2YEAR;
	}
	public void setR12_ACCOUNTS_AED_2YEAR(BigDecimal r12_ACCOUNTS_AED_2YEAR) {
		R12_ACCOUNTS_AED_2YEAR = r12_ACCOUNTS_AED_2YEAR;
	}
	public BigDecimal getR12_AMOUNT_AED_2YEAR() {
		return R12_AMOUNT_AED_2YEAR;
	}
	public void setR12_AMOUNT_AED_2YEAR(BigDecimal r12_AMOUNT_AED_2YEAR) {
		R12_AMOUNT_AED_2YEAR = r12_AMOUNT_AED_2YEAR;
	}
	public BigDecimal getR12_ACCOUNTS_FCY_2YEAR() {
		return R12_ACCOUNTS_FCY_2YEAR;
	}
	public void setR12_ACCOUNTS_FCY_2YEAR(BigDecimal r12_ACCOUNTS_FCY_2YEAR) {
		R12_ACCOUNTS_FCY_2YEAR = r12_ACCOUNTS_FCY_2YEAR;
	}
	public BigDecimal getR12_AMOUNT_FCY_2YEAR() {
		return R12_AMOUNT_FCY_2YEAR;
	}
	public void setR12_AMOUNT_FCY_2YEAR(BigDecimal r12_AMOUNT_FCY_2YEAR) {
		R12_AMOUNT_FCY_2YEAR = r12_AMOUNT_FCY_2YEAR;
	}
	public BigDecimal getR12_ACCOUNTS_AED_3YEAR() {
		return R12_ACCOUNTS_AED_3YEAR;
	}
	public void setR12_ACCOUNTS_AED_3YEAR(BigDecimal r12_ACCOUNTS_AED_3YEAR) {
		R12_ACCOUNTS_AED_3YEAR = r12_ACCOUNTS_AED_3YEAR;
	}
	public BigDecimal getR12_AMOUNT_AED_3YEAR() {
		return R12_AMOUNT_AED_3YEAR;
	}
	public void setR12_AMOUNT_AED_3YEAR(BigDecimal r12_AMOUNT_AED_3YEAR) {
		R12_AMOUNT_AED_3YEAR = r12_AMOUNT_AED_3YEAR;
	}
	public BigDecimal getR12_ACCOUNTS_FCY_3YEAR() {
		return R12_ACCOUNTS_FCY_3YEAR;
	}
	public void setR12_ACCOUNTS_FCY_3YEAR(BigDecimal r12_ACCOUNTS_FCY_3YEAR) {
		R12_ACCOUNTS_FCY_3YEAR = r12_ACCOUNTS_FCY_3YEAR;
	}
	public BigDecimal getR12_AMOUNT_FCY_3YEAR() {
		return R12_AMOUNT_FCY_3YEAR;
	}
	public void setR12_AMOUNT_FCY_3YEAR(BigDecimal r12_AMOUNT_FCY_3YEAR) {
		R12_AMOUNT_FCY_3YEAR = r12_AMOUNT_FCY_3YEAR;
	}
	public BigDecimal getR12_ACCOUNTS_AED_5YEAR() {
		return R12_ACCOUNTS_AED_5YEAR;
	}
	public void setR12_ACCOUNTS_AED_5YEAR(BigDecimal r12_ACCOUNTS_AED_5YEAR) {
		R12_ACCOUNTS_AED_5YEAR = r12_ACCOUNTS_AED_5YEAR;
	}
	public BigDecimal getR12_AMOUNT_AED_5YEAR() {
		return R12_AMOUNT_AED_5YEAR;
	}
	public void setR12_AMOUNT_AED_5YEAR(BigDecimal r12_AMOUNT_AED_5YEAR) {
		R12_AMOUNT_AED_5YEAR = r12_AMOUNT_AED_5YEAR;
	}
	public BigDecimal getR12_ACCOUNTS_FCY_5YEAR() {
		return R12_ACCOUNTS_FCY_5YEAR;
	}
	public void setR12_ACCOUNTS_FCY_5YEAR(BigDecimal r12_ACCOUNTS_FCY_5YEAR) {
		R12_ACCOUNTS_FCY_5YEAR = r12_ACCOUNTS_FCY_5YEAR;
	}
	public BigDecimal getR12_AMOUNT_FCY_5YEAR() {
		return R12_AMOUNT_FCY_5YEAR;
	}
	public void setR12_AMOUNT_FCY_5YEAR(BigDecimal r12_AMOUNT_FCY_5YEAR) {
		R12_AMOUNT_FCY_5YEAR = r12_AMOUNT_FCY_5YEAR;
	}
	public BigDecimal getR12_ACCOUNTS_AED_ABOVE() {
		return R12_ACCOUNTS_AED_ABOVE;
	}
	public void setR12_ACCOUNTS_AED_ABOVE(BigDecimal r12_ACCOUNTS_AED_ABOVE) {
		R12_ACCOUNTS_AED_ABOVE = r12_ACCOUNTS_AED_ABOVE;
	}
	public BigDecimal getR12_AMOUNT_AED_ABOVE() {
		return R12_AMOUNT_AED_ABOVE;
	}
	public void setR12_AMOUNT_AED_ABOVE(BigDecimal r12_AMOUNT_AED_ABOVE) {
		R12_AMOUNT_AED_ABOVE = r12_AMOUNT_AED_ABOVE;
	}
	public BigDecimal getR12_ACCOUNTS_FCY_ABOVE() {
		return R12_ACCOUNTS_FCY_ABOVE;
	}
	public void setR12_ACCOUNTS_FCY_ABOVE(BigDecimal r12_ACCOUNTS_FCY_ABOVE) {
		R12_ACCOUNTS_FCY_ABOVE = r12_ACCOUNTS_FCY_ABOVE;
	}
	public BigDecimal getR12_AMOUNT_FCY_ABOVE() {
		return R12_AMOUNT_FCY_ABOVE;
	}
	public void setR12_AMOUNT_FCY_ABOVE(BigDecimal r12_AMOUNT_FCY_ABOVE) {
		R12_AMOUNT_FCY_ABOVE = r12_AMOUNT_FCY_ABOVE;
	}
	public BigDecimal getR12_ACCOUNTS_AED_INACTIVE() {
		return R12_ACCOUNTS_AED_INACTIVE;
	}
	public void setR12_ACCOUNTS_AED_INACTIVE(BigDecimal r12_ACCOUNTS_AED_INACTIVE) {
		R12_ACCOUNTS_AED_INACTIVE = r12_ACCOUNTS_AED_INACTIVE;
	}
	public BigDecimal getR12_AMOUNT_AED_INACTIVE() {
		return R12_AMOUNT_AED_INACTIVE;
	}
	public void setR12_AMOUNT_AED_INACTIVE(BigDecimal r12_AMOUNT_AED_INACTIVE) {
		R12_AMOUNT_AED_INACTIVE = r12_AMOUNT_AED_INACTIVE;
	}
	public BigDecimal getR12_ACCOUNTS_FCY_INACTIVE() {
		return R12_ACCOUNTS_FCY_INACTIVE;
	}
	public void setR12_ACCOUNTS_FCY_INACTIVE(BigDecimal r12_ACCOUNTS_FCY_INACTIVE) {
		R12_ACCOUNTS_FCY_INACTIVE = r12_ACCOUNTS_FCY_INACTIVE;
	}
	public BigDecimal getR12_AMOUNT_FCY_INACTIVE() {
		return R12_AMOUNT_FCY_INACTIVE;
	}
	public void setR12_AMOUNT_FCY_INACTIVE(BigDecimal r12_AMOUNT_FCY_INACTIVE) {
		R12_AMOUNT_FCY_INACTIVE = r12_AMOUNT_FCY_INACTIVE;
	}
	public BigDecimal getR12_ACCOUNTS_AED_DORMANT() {
		return R12_ACCOUNTS_AED_DORMANT;
	}
	public void setR12_ACCOUNTS_AED_DORMANT(BigDecimal r12_ACCOUNTS_AED_DORMANT) {
		R12_ACCOUNTS_AED_DORMANT = r12_ACCOUNTS_AED_DORMANT;
	}
	public BigDecimal getR12_AMOUNT_AED_DORMANT() {
		return R12_AMOUNT_AED_DORMANT;
	}
	public void setR12_AMOUNT_AED_DORMANT(BigDecimal r12_AMOUNT_AED_DORMANT) {
		R12_AMOUNT_AED_DORMANT = r12_AMOUNT_AED_DORMANT;
	}
	public BigDecimal getR12_ACCOUNTS_FCY_DORMANT() {
		return R12_ACCOUNTS_FCY_DORMANT;
	}
	public void setR12_ACCOUNTS_FCY_DORMANT(BigDecimal r12_ACCOUNTS_FCY_DORMANT) {
		R12_ACCOUNTS_FCY_DORMANT = r12_ACCOUNTS_FCY_DORMANT;
	}
	public BigDecimal getR12_AMOUNT_FCY_DORMANT() {
		return R12_AMOUNT_FCY_DORMANT;
	}
	public void setR12_AMOUNT_FCY_DORMANT(BigDecimal r12_AMOUNT_FCY_DORMANT) {
		R12_AMOUNT_FCY_DORMANT = r12_AMOUNT_FCY_DORMANT;
	}
	public String getR13_S_NO() {
		return R13_S_NO;
	}
	public void setR13_S_NO(String r13_S_NO) {
		R13_S_NO = r13_S_NO;
	}
	public String getR13_REGULATIONS() {
		return R13_REGULATIONS;
	}
	public void setR13_REGULATIONS(String r13_REGULATIONS) {
		R13_REGULATIONS = r13_REGULATIONS;
	}
	public String getR13_DORMANT() {
		return R13_DORMANT;
	}
	public void setR13_DORMANT(String r13_DORMANT) {
		R13_DORMANT = r13_DORMANT;
	}
	public BigDecimal getR13_ACCOUNTS_AED_1YEAR() {
		return R13_ACCOUNTS_AED_1YEAR;
	}
	public void setR13_ACCOUNTS_AED_1YEAR(BigDecimal r13_ACCOUNTS_AED_1YEAR) {
		R13_ACCOUNTS_AED_1YEAR = r13_ACCOUNTS_AED_1YEAR;
	}
	public BigDecimal getR13_AMOUNT_AED_1YEAR() {
		return R13_AMOUNT_AED_1YEAR;
	}
	public void setR13_AMOUNT_AED_1YEAR(BigDecimal r13_AMOUNT_AED_1YEAR) {
		R13_AMOUNT_AED_1YEAR = r13_AMOUNT_AED_1YEAR;
	}
	public BigDecimal getR13_ACCOUNTS_FCY_1YEAR() {
		return R13_ACCOUNTS_FCY_1YEAR;
	}
	public void setR13_ACCOUNTS_FCY_1YEAR(BigDecimal r13_ACCOUNTS_FCY_1YEAR) {
		R13_ACCOUNTS_FCY_1YEAR = r13_ACCOUNTS_FCY_1YEAR;
	}
	public BigDecimal getR13_AMOUNT_FCY_1YEAR() {
		return R13_AMOUNT_FCY_1YEAR;
	}
	public void setR13_AMOUNT_FCY_1YEAR(BigDecimal r13_AMOUNT_FCY_1YEAR) {
		R13_AMOUNT_FCY_1YEAR = r13_AMOUNT_FCY_1YEAR;
	}
	public BigDecimal getR13_ACCOUNTS_AED_2YEAR() {
		return R13_ACCOUNTS_AED_2YEAR;
	}
	public void setR13_ACCOUNTS_AED_2YEAR(BigDecimal r13_ACCOUNTS_AED_2YEAR) {
		R13_ACCOUNTS_AED_2YEAR = r13_ACCOUNTS_AED_2YEAR;
	}
	public BigDecimal getR13_AMOUNT_AED_2YEAR() {
		return R13_AMOUNT_AED_2YEAR;
	}
	public void setR13_AMOUNT_AED_2YEAR(BigDecimal r13_AMOUNT_AED_2YEAR) {
		R13_AMOUNT_AED_2YEAR = r13_AMOUNT_AED_2YEAR;
	}
	public BigDecimal getR13_ACCOUNTS_FCY_2YEAR() {
		return R13_ACCOUNTS_FCY_2YEAR;
	}
	public void setR13_ACCOUNTS_FCY_2YEAR(BigDecimal r13_ACCOUNTS_FCY_2YEAR) {
		R13_ACCOUNTS_FCY_2YEAR = r13_ACCOUNTS_FCY_2YEAR;
	}
	public BigDecimal getR13_AMOUNT_FCY_2YEAR() {
		return R13_AMOUNT_FCY_2YEAR;
	}
	public void setR13_AMOUNT_FCY_2YEAR(BigDecimal r13_AMOUNT_FCY_2YEAR) {
		R13_AMOUNT_FCY_2YEAR = r13_AMOUNT_FCY_2YEAR;
	}
	public BigDecimal getR13_ACCOUNTS_AED_3YEAR() {
		return R13_ACCOUNTS_AED_3YEAR;
	}
	public void setR13_ACCOUNTS_AED_3YEAR(BigDecimal r13_ACCOUNTS_AED_3YEAR) {
		R13_ACCOUNTS_AED_3YEAR = r13_ACCOUNTS_AED_3YEAR;
	}
	public BigDecimal getR13_AMOUNT_AED_3YEAR() {
		return R13_AMOUNT_AED_3YEAR;
	}
	public void setR13_AMOUNT_AED_3YEAR(BigDecimal r13_AMOUNT_AED_3YEAR) {
		R13_AMOUNT_AED_3YEAR = r13_AMOUNT_AED_3YEAR;
	}
	public BigDecimal getR13_ACCOUNTS_FCY_3YEAR() {
		return R13_ACCOUNTS_FCY_3YEAR;
	}
	public void setR13_ACCOUNTS_FCY_3YEAR(BigDecimal r13_ACCOUNTS_FCY_3YEAR) {
		R13_ACCOUNTS_FCY_3YEAR = r13_ACCOUNTS_FCY_3YEAR;
	}
	public BigDecimal getR13_AMOUNT_FCY_3YEAR() {
		return R13_AMOUNT_FCY_3YEAR;
	}
	public void setR13_AMOUNT_FCY_3YEAR(BigDecimal r13_AMOUNT_FCY_3YEAR) {
		R13_AMOUNT_FCY_3YEAR = r13_AMOUNT_FCY_3YEAR;
	}
	public BigDecimal getR13_ACCOUNTS_AED_5YEAR() {
		return R13_ACCOUNTS_AED_5YEAR;
	}
	public void setR13_ACCOUNTS_AED_5YEAR(BigDecimal r13_ACCOUNTS_AED_5YEAR) {
		R13_ACCOUNTS_AED_5YEAR = r13_ACCOUNTS_AED_5YEAR;
	}
	public BigDecimal getR13_AMOUNT_AED_5YEAR() {
		return R13_AMOUNT_AED_5YEAR;
	}
	public void setR13_AMOUNT_AED_5YEAR(BigDecimal r13_AMOUNT_AED_5YEAR) {
		R13_AMOUNT_AED_5YEAR = r13_AMOUNT_AED_5YEAR;
	}
	public BigDecimal getR13_ACCOUNTS_FCY_5YEAR() {
		return R13_ACCOUNTS_FCY_5YEAR;
	}
	public void setR13_ACCOUNTS_FCY_5YEAR(BigDecimal r13_ACCOUNTS_FCY_5YEAR) {
		R13_ACCOUNTS_FCY_5YEAR = r13_ACCOUNTS_FCY_5YEAR;
	}
	public BigDecimal getR13_AMOUNT_FCY_5YEAR() {
		return R13_AMOUNT_FCY_5YEAR;
	}
	public void setR13_AMOUNT_FCY_5YEAR(BigDecimal r13_AMOUNT_FCY_5YEAR) {
		R13_AMOUNT_FCY_5YEAR = r13_AMOUNT_FCY_5YEAR;
	}
	public BigDecimal getR13_ACCOUNTS_AED_ABOVE() {
		return R13_ACCOUNTS_AED_ABOVE;
	}
	public void setR13_ACCOUNTS_AED_ABOVE(BigDecimal r13_ACCOUNTS_AED_ABOVE) {
		R13_ACCOUNTS_AED_ABOVE = r13_ACCOUNTS_AED_ABOVE;
	}
	public BigDecimal getR13_AMOUNT_AED_ABOVE() {
		return R13_AMOUNT_AED_ABOVE;
	}
	public void setR13_AMOUNT_AED_ABOVE(BigDecimal r13_AMOUNT_AED_ABOVE) {
		R13_AMOUNT_AED_ABOVE = r13_AMOUNT_AED_ABOVE;
	}
	public BigDecimal getR13_ACCOUNTS_FCY_ABOVE() {
		return R13_ACCOUNTS_FCY_ABOVE;
	}
	public void setR13_ACCOUNTS_FCY_ABOVE(BigDecimal r13_ACCOUNTS_FCY_ABOVE) {
		R13_ACCOUNTS_FCY_ABOVE = r13_ACCOUNTS_FCY_ABOVE;
	}
	public BigDecimal getR13_AMOUNT_FCY_ABOVE() {
		return R13_AMOUNT_FCY_ABOVE;
	}
	public void setR13_AMOUNT_FCY_ABOVE(BigDecimal r13_AMOUNT_FCY_ABOVE) {
		R13_AMOUNT_FCY_ABOVE = r13_AMOUNT_FCY_ABOVE;
	}
	public BigDecimal getR13_ACCOUNTS_AED_INACTIVE() {
		return R13_ACCOUNTS_AED_INACTIVE;
	}
	public void setR13_ACCOUNTS_AED_INACTIVE(BigDecimal r13_ACCOUNTS_AED_INACTIVE) {
		R13_ACCOUNTS_AED_INACTIVE = r13_ACCOUNTS_AED_INACTIVE;
	}
	public BigDecimal getR13_AMOUNT_AED_INACTIVE() {
		return R13_AMOUNT_AED_INACTIVE;
	}
	public void setR13_AMOUNT_AED_INACTIVE(BigDecimal r13_AMOUNT_AED_INACTIVE) {
		R13_AMOUNT_AED_INACTIVE = r13_AMOUNT_AED_INACTIVE;
	}
	public BigDecimal getR13_ACCOUNTS_FCY_INACTIVE() {
		return R13_ACCOUNTS_FCY_INACTIVE;
	}
	public void setR13_ACCOUNTS_FCY_INACTIVE(BigDecimal r13_ACCOUNTS_FCY_INACTIVE) {
		R13_ACCOUNTS_FCY_INACTIVE = r13_ACCOUNTS_FCY_INACTIVE;
	}
	public BigDecimal getR13_AMOUNT_FCY_INACTIVE() {
		return R13_AMOUNT_FCY_INACTIVE;
	}
	public void setR13_AMOUNT_FCY_INACTIVE(BigDecimal r13_AMOUNT_FCY_INACTIVE) {
		R13_AMOUNT_FCY_INACTIVE = r13_AMOUNT_FCY_INACTIVE;
	}
	public BigDecimal getR13_ACCOUNTS_AED_DORMANT() {
		return R13_ACCOUNTS_AED_DORMANT;
	}
	public void setR13_ACCOUNTS_AED_DORMANT(BigDecimal r13_ACCOUNTS_AED_DORMANT) {
		R13_ACCOUNTS_AED_DORMANT = r13_ACCOUNTS_AED_DORMANT;
	}
	public BigDecimal getR13_AMOUNT_AED_DORMANT() {
		return R13_AMOUNT_AED_DORMANT;
	}
	public void setR13_AMOUNT_AED_DORMANT(BigDecimal r13_AMOUNT_AED_DORMANT) {
		R13_AMOUNT_AED_DORMANT = r13_AMOUNT_AED_DORMANT;
	}
	public BigDecimal getR13_ACCOUNTS_FCY_DORMANT() {
		return R13_ACCOUNTS_FCY_DORMANT;
	}
	public void setR13_ACCOUNTS_FCY_DORMANT(BigDecimal r13_ACCOUNTS_FCY_DORMANT) {
		R13_ACCOUNTS_FCY_DORMANT = r13_ACCOUNTS_FCY_DORMANT;
	}
	public BigDecimal getR13_AMOUNT_FCY_DORMANT() {
		return R13_AMOUNT_FCY_DORMANT;
	}
	public void setR13_AMOUNT_FCY_DORMANT(BigDecimal r13_AMOUNT_FCY_DORMANT) {
		R13_AMOUNT_FCY_DORMANT = r13_AMOUNT_FCY_DORMANT;
	}
	public String getR14_S_NO() {
		return R14_S_NO;
	}
	public void setR14_S_NO(String r14_S_NO) {
		R14_S_NO = r14_S_NO;
	}
	public String getR14_REGULATIONS() {
		return R14_REGULATIONS;
	}
	public void setR14_REGULATIONS(String r14_REGULATIONS) {
		R14_REGULATIONS = r14_REGULATIONS;
	}
	public String getR14_DORMANT() {
		return R14_DORMANT;
	}
	public void setR14_DORMANT(String r14_DORMANT) {
		R14_DORMANT = r14_DORMANT;
	}
	public BigDecimal getR14_ACCOUNTS_AED_1YEAR() {
		return R14_ACCOUNTS_AED_1YEAR;
	}
	public void setR14_ACCOUNTS_AED_1YEAR(BigDecimal r14_ACCOUNTS_AED_1YEAR) {
		R14_ACCOUNTS_AED_1YEAR = r14_ACCOUNTS_AED_1YEAR;
	}
	public BigDecimal getR14_AMOUNT_AED_1YEAR() {
		return R14_AMOUNT_AED_1YEAR;
	}
	public void setR14_AMOUNT_AED_1YEAR(BigDecimal r14_AMOUNT_AED_1YEAR) {
		R14_AMOUNT_AED_1YEAR = r14_AMOUNT_AED_1YEAR;
	}
	public BigDecimal getR14_ACCOUNTS_FCY_1YEAR() {
		return R14_ACCOUNTS_FCY_1YEAR;
	}
	public void setR14_ACCOUNTS_FCY_1YEAR(BigDecimal r14_ACCOUNTS_FCY_1YEAR) {
		R14_ACCOUNTS_FCY_1YEAR = r14_ACCOUNTS_FCY_1YEAR;
	}
	public BigDecimal getR14_AMOUNT_FCY_1YEAR() {
		return R14_AMOUNT_FCY_1YEAR;
	}
	public void setR14_AMOUNT_FCY_1YEAR(BigDecimal r14_AMOUNT_FCY_1YEAR) {
		R14_AMOUNT_FCY_1YEAR = r14_AMOUNT_FCY_1YEAR;
	}
	public BigDecimal getR14_ACCOUNTS_AED_2YEAR() {
		return R14_ACCOUNTS_AED_2YEAR;
	}
	public void setR14_ACCOUNTS_AED_2YEAR(BigDecimal r14_ACCOUNTS_AED_2YEAR) {
		R14_ACCOUNTS_AED_2YEAR = r14_ACCOUNTS_AED_2YEAR;
	}
	public BigDecimal getR14_AMOUNT_AED_2YEAR() {
		return R14_AMOUNT_AED_2YEAR;
	}
	public void setR14_AMOUNT_AED_2YEAR(BigDecimal r14_AMOUNT_AED_2YEAR) {
		R14_AMOUNT_AED_2YEAR = r14_AMOUNT_AED_2YEAR;
	}
	public BigDecimal getR14_ACCOUNTS_FCY_2YEAR() {
		return R14_ACCOUNTS_FCY_2YEAR;
	}
	public void setR14_ACCOUNTS_FCY_2YEAR(BigDecimal r14_ACCOUNTS_FCY_2YEAR) {
		R14_ACCOUNTS_FCY_2YEAR = r14_ACCOUNTS_FCY_2YEAR;
	}
	public BigDecimal getR14_AMOUNT_FCY_2YEAR() {
		return R14_AMOUNT_FCY_2YEAR;
	}
	public void setR14_AMOUNT_FCY_2YEAR(BigDecimal r14_AMOUNT_FCY_2YEAR) {
		R14_AMOUNT_FCY_2YEAR = r14_AMOUNT_FCY_2YEAR;
	}
	public BigDecimal getR14_ACCOUNTS_AED_3YEAR() {
		return R14_ACCOUNTS_AED_3YEAR;
	}
	public void setR14_ACCOUNTS_AED_3YEAR(BigDecimal r14_ACCOUNTS_AED_3YEAR) {
		R14_ACCOUNTS_AED_3YEAR = r14_ACCOUNTS_AED_3YEAR;
	}
	public BigDecimal getR14_AMOUNT_AED_3YEAR() {
		return R14_AMOUNT_AED_3YEAR;
	}
	public void setR14_AMOUNT_AED_3YEAR(BigDecimal r14_AMOUNT_AED_3YEAR) {
		R14_AMOUNT_AED_3YEAR = r14_AMOUNT_AED_3YEAR;
	}
	public BigDecimal getR14_ACCOUNTS_FCY_3YEAR() {
		return R14_ACCOUNTS_FCY_3YEAR;
	}
	public void setR14_ACCOUNTS_FCY_3YEAR(BigDecimal r14_ACCOUNTS_FCY_3YEAR) {
		R14_ACCOUNTS_FCY_3YEAR = r14_ACCOUNTS_FCY_3YEAR;
	}
	public BigDecimal getR14_AMOUNT_FCY_3YEAR() {
		return R14_AMOUNT_FCY_3YEAR;
	}
	public void setR14_AMOUNT_FCY_3YEAR(BigDecimal r14_AMOUNT_FCY_3YEAR) {
		R14_AMOUNT_FCY_3YEAR = r14_AMOUNT_FCY_3YEAR;
	}
	public BigDecimal getR14_ACCOUNTS_AED_5YEAR() {
		return R14_ACCOUNTS_AED_5YEAR;
	}
	public void setR14_ACCOUNTS_AED_5YEAR(BigDecimal r14_ACCOUNTS_AED_5YEAR) {
		R14_ACCOUNTS_AED_5YEAR = r14_ACCOUNTS_AED_5YEAR;
	}
	public BigDecimal getR14_AMOUNT_AED_5YEAR() {
		return R14_AMOUNT_AED_5YEAR;
	}
	public void setR14_AMOUNT_AED_5YEAR(BigDecimal r14_AMOUNT_AED_5YEAR) {
		R14_AMOUNT_AED_5YEAR = r14_AMOUNT_AED_5YEAR;
	}
	public BigDecimal getR14_ACCOUNTS_FCY_5YEAR() {
		return R14_ACCOUNTS_FCY_5YEAR;
	}
	public void setR14_ACCOUNTS_FCY_5YEAR(BigDecimal r14_ACCOUNTS_FCY_5YEAR) {
		R14_ACCOUNTS_FCY_5YEAR = r14_ACCOUNTS_FCY_5YEAR;
	}
	public BigDecimal getR14_AMOUNT_FCY_5YEAR() {
		return R14_AMOUNT_FCY_5YEAR;
	}
	public void setR14_AMOUNT_FCY_5YEAR(BigDecimal r14_AMOUNT_FCY_5YEAR) {
		R14_AMOUNT_FCY_5YEAR = r14_AMOUNT_FCY_5YEAR;
	}
	public BigDecimal getR14_ACCOUNTS_AED_ABOVE() {
		return R14_ACCOUNTS_AED_ABOVE;
	}
	public void setR14_ACCOUNTS_AED_ABOVE(BigDecimal r14_ACCOUNTS_AED_ABOVE) {
		R14_ACCOUNTS_AED_ABOVE = r14_ACCOUNTS_AED_ABOVE;
	}
	public BigDecimal getR14_AMOUNT_AED_ABOVE() {
		return R14_AMOUNT_AED_ABOVE;
	}
	public void setR14_AMOUNT_AED_ABOVE(BigDecimal r14_AMOUNT_AED_ABOVE) {
		R14_AMOUNT_AED_ABOVE = r14_AMOUNT_AED_ABOVE;
	}
	public BigDecimal getR14_ACCOUNTS_FCY_ABOVE() {
		return R14_ACCOUNTS_FCY_ABOVE;
	}
	public void setR14_ACCOUNTS_FCY_ABOVE(BigDecimal r14_ACCOUNTS_FCY_ABOVE) {
		R14_ACCOUNTS_FCY_ABOVE = r14_ACCOUNTS_FCY_ABOVE;
	}
	public BigDecimal getR14_AMOUNT_FCY_ABOVE() {
		return R14_AMOUNT_FCY_ABOVE;
	}
	public void setR14_AMOUNT_FCY_ABOVE(BigDecimal r14_AMOUNT_FCY_ABOVE) {
		R14_AMOUNT_FCY_ABOVE = r14_AMOUNT_FCY_ABOVE;
	}
	public BigDecimal getR14_ACCOUNTS_AED_INACTIVE() {
		return R14_ACCOUNTS_AED_INACTIVE;
	}
	public void setR14_ACCOUNTS_AED_INACTIVE(BigDecimal r14_ACCOUNTS_AED_INACTIVE) {
		R14_ACCOUNTS_AED_INACTIVE = r14_ACCOUNTS_AED_INACTIVE;
	}
	public BigDecimal getR14_AMOUNT_AED_INACTIVE() {
		return R14_AMOUNT_AED_INACTIVE;
	}
	public void setR14_AMOUNT_AED_INACTIVE(BigDecimal r14_AMOUNT_AED_INACTIVE) {
		R14_AMOUNT_AED_INACTIVE = r14_AMOUNT_AED_INACTIVE;
	}
	public BigDecimal getR14_ACCOUNTS_FCY_INACTIVE() {
		return R14_ACCOUNTS_FCY_INACTIVE;
	}
	public void setR14_ACCOUNTS_FCY_INACTIVE(BigDecimal r14_ACCOUNTS_FCY_INACTIVE) {
		R14_ACCOUNTS_FCY_INACTIVE = r14_ACCOUNTS_FCY_INACTIVE;
	}
	public BigDecimal getR14_AMOUNT_FCY_INACTIVE() {
		return R14_AMOUNT_FCY_INACTIVE;
	}
	public void setR14_AMOUNT_FCY_INACTIVE(BigDecimal r14_AMOUNT_FCY_INACTIVE) {
		R14_AMOUNT_FCY_INACTIVE = r14_AMOUNT_FCY_INACTIVE;
	}
	public BigDecimal getR14_ACCOUNTS_AED_DORMANT() {
		return R14_ACCOUNTS_AED_DORMANT;
	}
	public void setR14_ACCOUNTS_AED_DORMANT(BigDecimal r14_ACCOUNTS_AED_DORMANT) {
		R14_ACCOUNTS_AED_DORMANT = r14_ACCOUNTS_AED_DORMANT;
	}
	public BigDecimal getR14_AMOUNT_AED_DORMANT() {
		return R14_AMOUNT_AED_DORMANT;
	}
	public void setR14_AMOUNT_AED_DORMANT(BigDecimal r14_AMOUNT_AED_DORMANT) {
		R14_AMOUNT_AED_DORMANT = r14_AMOUNT_AED_DORMANT;
	}
	public BigDecimal getR14_ACCOUNTS_FCY_DORMANT() {
		return R14_ACCOUNTS_FCY_DORMANT;
	}
	public void setR14_ACCOUNTS_FCY_DORMANT(BigDecimal r14_ACCOUNTS_FCY_DORMANT) {
		R14_ACCOUNTS_FCY_DORMANT = r14_ACCOUNTS_FCY_DORMANT;
	}
	public BigDecimal getR14_AMOUNT_FCY_DORMANT() {
		return R14_AMOUNT_FCY_DORMANT;
	}
	public void setR14_AMOUNT_FCY_DORMANT(BigDecimal r14_AMOUNT_FCY_DORMANT) {
		R14_AMOUNT_FCY_DORMANT = r14_AMOUNT_FCY_DORMANT;
	}
	public String getR15_S_NO() {
		return R15_S_NO;
	}
	public void setR15_S_NO(String r15_S_NO) {
		R15_S_NO = r15_S_NO;
	}
	public String getR15_REGULATIONS() {
		return R15_REGULATIONS;
	}
	public void setR15_REGULATIONS(String r15_REGULATIONS) {
		R15_REGULATIONS = r15_REGULATIONS;
	}
	public String getR15_DORMANT() {
		return R15_DORMANT;
	}
	public void setR15_DORMANT(String r15_DORMANT) {
		R15_DORMANT = r15_DORMANT;
	}
	public BigDecimal getR15_ACCOUNTS_AED_1YEAR() {
		return R15_ACCOUNTS_AED_1YEAR;
	}
	public void setR15_ACCOUNTS_AED_1YEAR(BigDecimal r15_ACCOUNTS_AED_1YEAR) {
		R15_ACCOUNTS_AED_1YEAR = r15_ACCOUNTS_AED_1YEAR;
	}
	public BigDecimal getR15_AMOUNT_AED_1YEAR() {
		return R15_AMOUNT_AED_1YEAR;
	}
	public void setR15_AMOUNT_AED_1YEAR(BigDecimal r15_AMOUNT_AED_1YEAR) {
		R15_AMOUNT_AED_1YEAR = r15_AMOUNT_AED_1YEAR;
	}
	public BigDecimal getR15_ACCOUNTS_FCY_1YEAR() {
		return R15_ACCOUNTS_FCY_1YEAR;
	}
	public void setR15_ACCOUNTS_FCY_1YEAR(BigDecimal r15_ACCOUNTS_FCY_1YEAR) {
		R15_ACCOUNTS_FCY_1YEAR = r15_ACCOUNTS_FCY_1YEAR;
	}
	public BigDecimal getR15_AMOUNT_FCY_1YEAR() {
		return R15_AMOUNT_FCY_1YEAR;
	}
	public void setR15_AMOUNT_FCY_1YEAR(BigDecimal r15_AMOUNT_FCY_1YEAR) {
		R15_AMOUNT_FCY_1YEAR = r15_AMOUNT_FCY_1YEAR;
	}
	public BigDecimal getR15_ACCOUNTS_AED_2YEAR() {
		return R15_ACCOUNTS_AED_2YEAR;
	}
	public void setR15_ACCOUNTS_AED_2YEAR(BigDecimal r15_ACCOUNTS_AED_2YEAR) {
		R15_ACCOUNTS_AED_2YEAR = r15_ACCOUNTS_AED_2YEAR;
	}
	public BigDecimal getR15_AMOUNT_AED_2YEAR() {
		return R15_AMOUNT_AED_2YEAR;
	}
	public void setR15_AMOUNT_AED_2YEAR(BigDecimal r15_AMOUNT_AED_2YEAR) {
		R15_AMOUNT_AED_2YEAR = r15_AMOUNT_AED_2YEAR;
	}
	public BigDecimal getR15_ACCOUNTS_FCY_2YEAR() {
		return R15_ACCOUNTS_FCY_2YEAR;
	}
	public void setR15_ACCOUNTS_FCY_2YEAR(BigDecimal r15_ACCOUNTS_FCY_2YEAR) {
		R15_ACCOUNTS_FCY_2YEAR = r15_ACCOUNTS_FCY_2YEAR;
	}
	public BigDecimal getR15_AMOUNT_FCY_2YEAR() {
		return R15_AMOUNT_FCY_2YEAR;
	}
	public void setR15_AMOUNT_FCY_2YEAR(BigDecimal r15_AMOUNT_FCY_2YEAR) {
		R15_AMOUNT_FCY_2YEAR = r15_AMOUNT_FCY_2YEAR;
	}
	public BigDecimal getR15_ACCOUNTS_AED_3YEAR() {
		return R15_ACCOUNTS_AED_3YEAR;
	}
	public void setR15_ACCOUNTS_AED_3YEAR(BigDecimal r15_ACCOUNTS_AED_3YEAR) {
		R15_ACCOUNTS_AED_3YEAR = r15_ACCOUNTS_AED_3YEAR;
	}
	public BigDecimal getR15_AMOUNT_AED_3YEAR() {
		return R15_AMOUNT_AED_3YEAR;
	}
	public void setR15_AMOUNT_AED_3YEAR(BigDecimal r15_AMOUNT_AED_3YEAR) {
		R15_AMOUNT_AED_3YEAR = r15_AMOUNT_AED_3YEAR;
	}
	public BigDecimal getR15_ACCOUNTS_FCY_3YEAR() {
		return R15_ACCOUNTS_FCY_3YEAR;
	}
	public void setR15_ACCOUNTS_FCY_3YEAR(BigDecimal r15_ACCOUNTS_FCY_3YEAR) {
		R15_ACCOUNTS_FCY_3YEAR = r15_ACCOUNTS_FCY_3YEAR;
	}
	public BigDecimal getR15_AMOUNT_FCY_3YEAR() {
		return R15_AMOUNT_FCY_3YEAR;
	}
	public void setR15_AMOUNT_FCY_3YEAR(BigDecimal r15_AMOUNT_FCY_3YEAR) {
		R15_AMOUNT_FCY_3YEAR = r15_AMOUNT_FCY_3YEAR;
	}
	public BigDecimal getR15_ACCOUNTS_AED_5YEAR() {
		return R15_ACCOUNTS_AED_5YEAR;
	}
	public void setR15_ACCOUNTS_AED_5YEAR(BigDecimal r15_ACCOUNTS_AED_5YEAR) {
		R15_ACCOUNTS_AED_5YEAR = r15_ACCOUNTS_AED_5YEAR;
	}
	public BigDecimal getR15_AMOUNT_AED_5YEAR() {
		return R15_AMOUNT_AED_5YEAR;
	}
	public void setR15_AMOUNT_AED_5YEAR(BigDecimal r15_AMOUNT_AED_5YEAR) {
		R15_AMOUNT_AED_5YEAR = r15_AMOUNT_AED_5YEAR;
	}
	public BigDecimal getR15_ACCOUNTS_FCY_5YEAR() {
		return R15_ACCOUNTS_FCY_5YEAR;
	}
	public void setR15_ACCOUNTS_FCY_5YEAR(BigDecimal r15_ACCOUNTS_FCY_5YEAR) {
		R15_ACCOUNTS_FCY_5YEAR = r15_ACCOUNTS_FCY_5YEAR;
	}
	public BigDecimal getR15_AMOUNT_FCY_5YEAR() {
		return R15_AMOUNT_FCY_5YEAR;
	}
	public void setR15_AMOUNT_FCY_5YEAR(BigDecimal r15_AMOUNT_FCY_5YEAR) {
		R15_AMOUNT_FCY_5YEAR = r15_AMOUNT_FCY_5YEAR;
	}
	public BigDecimal getR15_ACCOUNTS_AED_ABOVE() {
		return R15_ACCOUNTS_AED_ABOVE;
	}
	public void setR15_ACCOUNTS_AED_ABOVE(BigDecimal r15_ACCOUNTS_AED_ABOVE) {
		R15_ACCOUNTS_AED_ABOVE = r15_ACCOUNTS_AED_ABOVE;
	}
	public BigDecimal getR15_AMOUNT_AED_ABOVE() {
		return R15_AMOUNT_AED_ABOVE;
	}
	public void setR15_AMOUNT_AED_ABOVE(BigDecimal r15_AMOUNT_AED_ABOVE) {
		R15_AMOUNT_AED_ABOVE = r15_AMOUNT_AED_ABOVE;
	}
	public BigDecimal getR15_ACCOUNTS_FCY_ABOVE() {
		return R15_ACCOUNTS_FCY_ABOVE;
	}
	public void setR15_ACCOUNTS_FCY_ABOVE(BigDecimal r15_ACCOUNTS_FCY_ABOVE) {
		R15_ACCOUNTS_FCY_ABOVE = r15_ACCOUNTS_FCY_ABOVE;
	}
	public BigDecimal getR15_AMOUNT_FCY_ABOVE() {
		return R15_AMOUNT_FCY_ABOVE;
	}
	public void setR15_AMOUNT_FCY_ABOVE(BigDecimal r15_AMOUNT_FCY_ABOVE) {
		R15_AMOUNT_FCY_ABOVE = r15_AMOUNT_FCY_ABOVE;
	}
	public BigDecimal getR15_ACCOUNTS_AED_INACTIVE() {
		return R15_ACCOUNTS_AED_INACTIVE;
	}
	public void setR15_ACCOUNTS_AED_INACTIVE(BigDecimal r15_ACCOUNTS_AED_INACTIVE) {
		R15_ACCOUNTS_AED_INACTIVE = r15_ACCOUNTS_AED_INACTIVE;
	}
	public BigDecimal getR15_AMOUNT_AED_INACTIVE() {
		return R15_AMOUNT_AED_INACTIVE;
	}
	public void setR15_AMOUNT_AED_INACTIVE(BigDecimal r15_AMOUNT_AED_INACTIVE) {
		R15_AMOUNT_AED_INACTIVE = r15_AMOUNT_AED_INACTIVE;
	}
	public BigDecimal getR15_ACCOUNTS_FCY_INACTIVE() {
		return R15_ACCOUNTS_FCY_INACTIVE;
	}
	public void setR15_ACCOUNTS_FCY_INACTIVE(BigDecimal r15_ACCOUNTS_FCY_INACTIVE) {
		R15_ACCOUNTS_FCY_INACTIVE = r15_ACCOUNTS_FCY_INACTIVE;
	}
	public BigDecimal getR15_AMOUNT_FCY_INACTIVE() {
		return R15_AMOUNT_FCY_INACTIVE;
	}
	public void setR15_AMOUNT_FCY_INACTIVE(BigDecimal r15_AMOUNT_FCY_INACTIVE) {
		R15_AMOUNT_FCY_INACTIVE = r15_AMOUNT_FCY_INACTIVE;
	}
	public BigDecimal getR15_ACCOUNTS_AED_DORMANT() {
		return R15_ACCOUNTS_AED_DORMANT;
	}
	public void setR15_ACCOUNTS_AED_DORMANT(BigDecimal r15_ACCOUNTS_AED_DORMANT) {
		R15_ACCOUNTS_AED_DORMANT = r15_ACCOUNTS_AED_DORMANT;
	}
	public BigDecimal getR15_AMOUNT_AED_DORMANT() {
		return R15_AMOUNT_AED_DORMANT;
	}
	public void setR15_AMOUNT_AED_DORMANT(BigDecimal r15_AMOUNT_AED_DORMANT) {
		R15_AMOUNT_AED_DORMANT = r15_AMOUNT_AED_DORMANT;
	}
	public BigDecimal getR15_ACCOUNTS_FCY_DORMANT() {
		return R15_ACCOUNTS_FCY_DORMANT;
	}
	public void setR15_ACCOUNTS_FCY_DORMANT(BigDecimal r15_ACCOUNTS_FCY_DORMANT) {
		R15_ACCOUNTS_FCY_DORMANT = r15_ACCOUNTS_FCY_DORMANT;
	}
	public BigDecimal getR15_AMOUNT_FCY_DORMANT() {
		return R15_AMOUNT_FCY_DORMANT;
	}
	public void setR15_AMOUNT_FCY_DORMANT(BigDecimal r15_AMOUNT_FCY_DORMANT) {
		R15_AMOUNT_FCY_DORMANT = r15_AMOUNT_FCY_DORMANT;
	}
	public String getR16_S_NO() {
		return R16_S_NO;
	}
	public void setR16_S_NO(String r16_S_NO) {
		R16_S_NO = r16_S_NO;
	}
	public String getR16_REGULATIONS() {
		return R16_REGULATIONS;
	}
	public void setR16_REGULATIONS(String r16_REGULATIONS) {
		R16_REGULATIONS = r16_REGULATIONS;
	}
	public String getR16_DORMANT() {
		return R16_DORMANT;
	}
	public void setR16_DORMANT(String r16_DORMANT) {
		R16_DORMANT = r16_DORMANT;
	}
	public BigDecimal getR16_ACCOUNTS_AED_1YEAR() {
		return R16_ACCOUNTS_AED_1YEAR;
	}
	public void setR16_ACCOUNTS_AED_1YEAR(BigDecimal r16_ACCOUNTS_AED_1YEAR) {
		R16_ACCOUNTS_AED_1YEAR = r16_ACCOUNTS_AED_1YEAR;
	}
	public BigDecimal getR16_AMOUNT_AED_1YEAR() {
		return R16_AMOUNT_AED_1YEAR;
	}
	public void setR16_AMOUNT_AED_1YEAR(BigDecimal r16_AMOUNT_AED_1YEAR) {
		R16_AMOUNT_AED_1YEAR = r16_AMOUNT_AED_1YEAR;
	}
	public BigDecimal getR16_ACCOUNTS_FCY_1YEAR() {
		return R16_ACCOUNTS_FCY_1YEAR;
	}
	public void setR16_ACCOUNTS_FCY_1YEAR(BigDecimal r16_ACCOUNTS_FCY_1YEAR) {
		R16_ACCOUNTS_FCY_1YEAR = r16_ACCOUNTS_FCY_1YEAR;
	}
	public BigDecimal getR16_AMOUNT_FCY_1YEAR() {
		return R16_AMOUNT_FCY_1YEAR;
	}
	public void setR16_AMOUNT_FCY_1YEAR(BigDecimal r16_AMOUNT_FCY_1YEAR) {
		R16_AMOUNT_FCY_1YEAR = r16_AMOUNT_FCY_1YEAR;
	}
	public BigDecimal getR16_ACCOUNTS_AED_2YEAR() {
		return R16_ACCOUNTS_AED_2YEAR;
	}
	public void setR16_ACCOUNTS_AED_2YEAR(BigDecimal r16_ACCOUNTS_AED_2YEAR) {
		R16_ACCOUNTS_AED_2YEAR = r16_ACCOUNTS_AED_2YEAR;
	}
	public BigDecimal getR16_AMOUNT_AED_2YEAR() {
		return R16_AMOUNT_AED_2YEAR;
	}
	public void setR16_AMOUNT_AED_2YEAR(BigDecimal r16_AMOUNT_AED_2YEAR) {
		R16_AMOUNT_AED_2YEAR = r16_AMOUNT_AED_2YEAR;
	}
	public BigDecimal getR16_ACCOUNTS_FCY_2YEAR() {
		return R16_ACCOUNTS_FCY_2YEAR;
	}
	public void setR16_ACCOUNTS_FCY_2YEAR(BigDecimal r16_ACCOUNTS_FCY_2YEAR) {
		R16_ACCOUNTS_FCY_2YEAR = r16_ACCOUNTS_FCY_2YEAR;
	}
	public BigDecimal getR16_AMOUNT_FCY_2YEAR() {
		return R16_AMOUNT_FCY_2YEAR;
	}
	public void setR16_AMOUNT_FCY_2YEAR(BigDecimal r16_AMOUNT_FCY_2YEAR) {
		R16_AMOUNT_FCY_2YEAR = r16_AMOUNT_FCY_2YEAR;
	}
	public BigDecimal getR16_ACCOUNTS_AED_3YEAR() {
		return R16_ACCOUNTS_AED_3YEAR;
	}
	public void setR16_ACCOUNTS_AED_3YEAR(BigDecimal r16_ACCOUNTS_AED_3YEAR) {
		R16_ACCOUNTS_AED_3YEAR = r16_ACCOUNTS_AED_3YEAR;
	}
	public BigDecimal getR16_AMOUNT_AED_3YEAR() {
		return R16_AMOUNT_AED_3YEAR;
	}
	public void setR16_AMOUNT_AED_3YEAR(BigDecimal r16_AMOUNT_AED_3YEAR) {
		R16_AMOUNT_AED_3YEAR = r16_AMOUNT_AED_3YEAR;
	}
	public BigDecimal getR16_ACCOUNTS_FCY_3YEAR() {
		return R16_ACCOUNTS_FCY_3YEAR;
	}
	public void setR16_ACCOUNTS_FCY_3YEAR(BigDecimal r16_ACCOUNTS_FCY_3YEAR) {
		R16_ACCOUNTS_FCY_3YEAR = r16_ACCOUNTS_FCY_3YEAR;
	}
	public BigDecimal getR16_AMOUNT_FCY_3YEAR() {
		return R16_AMOUNT_FCY_3YEAR;
	}
	public void setR16_AMOUNT_FCY_3YEAR(BigDecimal r16_AMOUNT_FCY_3YEAR) {
		R16_AMOUNT_FCY_3YEAR = r16_AMOUNT_FCY_3YEAR;
	}
	public BigDecimal getR16_ACCOUNTS_AED_5YEAR() {
		return R16_ACCOUNTS_AED_5YEAR;
	}
	public void setR16_ACCOUNTS_AED_5YEAR(BigDecimal r16_ACCOUNTS_AED_5YEAR) {
		R16_ACCOUNTS_AED_5YEAR = r16_ACCOUNTS_AED_5YEAR;
	}
	public BigDecimal getR16_AMOUNT_AED_5YEAR() {
		return R16_AMOUNT_AED_5YEAR;
	}
	public void setR16_AMOUNT_AED_5YEAR(BigDecimal r16_AMOUNT_AED_5YEAR) {
		R16_AMOUNT_AED_5YEAR = r16_AMOUNT_AED_5YEAR;
	}
	public BigDecimal getR16_ACCOUNTS_FCY_5YEAR() {
		return R16_ACCOUNTS_FCY_5YEAR;
	}
	public void setR16_ACCOUNTS_FCY_5YEAR(BigDecimal r16_ACCOUNTS_FCY_5YEAR) {
		R16_ACCOUNTS_FCY_5YEAR = r16_ACCOUNTS_FCY_5YEAR;
	}
	public BigDecimal getR16_AMOUNT_FCY_5YEAR() {
		return R16_AMOUNT_FCY_5YEAR;
	}
	public void setR16_AMOUNT_FCY_5YEAR(BigDecimal r16_AMOUNT_FCY_5YEAR) {
		R16_AMOUNT_FCY_5YEAR = r16_AMOUNT_FCY_5YEAR;
	}
	public BigDecimal getR16_ACCOUNTS_AED_ABOVE() {
		return R16_ACCOUNTS_AED_ABOVE;
	}
	public void setR16_ACCOUNTS_AED_ABOVE(BigDecimal r16_ACCOUNTS_AED_ABOVE) {
		R16_ACCOUNTS_AED_ABOVE = r16_ACCOUNTS_AED_ABOVE;
	}
	public BigDecimal getR16_AMOUNT_AED_ABOVE() {
		return R16_AMOUNT_AED_ABOVE;
	}
	public void setR16_AMOUNT_AED_ABOVE(BigDecimal r16_AMOUNT_AED_ABOVE) {
		R16_AMOUNT_AED_ABOVE = r16_AMOUNT_AED_ABOVE;
	}
	public BigDecimal getR16_ACCOUNTS_FCY_ABOVE() {
		return R16_ACCOUNTS_FCY_ABOVE;
	}
	public void setR16_ACCOUNTS_FCY_ABOVE(BigDecimal r16_ACCOUNTS_FCY_ABOVE) {
		R16_ACCOUNTS_FCY_ABOVE = r16_ACCOUNTS_FCY_ABOVE;
	}
	public BigDecimal getR16_AMOUNT_FCY_ABOVE() {
		return R16_AMOUNT_FCY_ABOVE;
	}
	public void setR16_AMOUNT_FCY_ABOVE(BigDecimal r16_AMOUNT_FCY_ABOVE) {
		R16_AMOUNT_FCY_ABOVE = r16_AMOUNT_FCY_ABOVE;
	}
	public BigDecimal getR16_ACCOUNTS_AED_INACTIVE() {
		return R16_ACCOUNTS_AED_INACTIVE;
	}
	public void setR16_ACCOUNTS_AED_INACTIVE(BigDecimal r16_ACCOUNTS_AED_INACTIVE) {
		R16_ACCOUNTS_AED_INACTIVE = r16_ACCOUNTS_AED_INACTIVE;
	}
	public BigDecimal getR16_AMOUNT_AED_INACTIVE() {
		return R16_AMOUNT_AED_INACTIVE;
	}
	public void setR16_AMOUNT_AED_INACTIVE(BigDecimal r16_AMOUNT_AED_INACTIVE) {
		R16_AMOUNT_AED_INACTIVE = r16_AMOUNT_AED_INACTIVE;
	}
	public BigDecimal getR16_ACCOUNTS_FCY_INACTIVE() {
		return R16_ACCOUNTS_FCY_INACTIVE;
	}
	public void setR16_ACCOUNTS_FCY_INACTIVE(BigDecimal r16_ACCOUNTS_FCY_INACTIVE) {
		R16_ACCOUNTS_FCY_INACTIVE = r16_ACCOUNTS_FCY_INACTIVE;
	}
	public BigDecimal getR16_AMOUNT_FCY_INACTIVE() {
		return R16_AMOUNT_FCY_INACTIVE;
	}
	public void setR16_AMOUNT_FCY_INACTIVE(BigDecimal r16_AMOUNT_FCY_INACTIVE) {
		R16_AMOUNT_FCY_INACTIVE = r16_AMOUNT_FCY_INACTIVE;
	}
	public BigDecimal getR16_ACCOUNTS_AED_DORMANT() {
		return R16_ACCOUNTS_AED_DORMANT;
	}
	public void setR16_ACCOUNTS_AED_DORMANT(BigDecimal r16_ACCOUNTS_AED_DORMANT) {
		R16_ACCOUNTS_AED_DORMANT = r16_ACCOUNTS_AED_DORMANT;
	}
	public BigDecimal getR16_AMOUNT_AED_DORMANT() {
		return R16_AMOUNT_AED_DORMANT;
	}
	public void setR16_AMOUNT_AED_DORMANT(BigDecimal r16_AMOUNT_AED_DORMANT) {
		R16_AMOUNT_AED_DORMANT = r16_AMOUNT_AED_DORMANT;
	}
	public BigDecimal getR16_ACCOUNTS_FCY_DORMANT() {
		return R16_ACCOUNTS_FCY_DORMANT;
	}
	public void setR16_ACCOUNTS_FCY_DORMANT(BigDecimal r16_ACCOUNTS_FCY_DORMANT) {
		R16_ACCOUNTS_FCY_DORMANT = r16_ACCOUNTS_FCY_DORMANT;
	}
	public BigDecimal getR16_AMOUNT_FCY_DORMANT() {
		return R16_AMOUNT_FCY_DORMANT;
	}
	public void setR16_AMOUNT_FCY_DORMANT(BigDecimal r16_AMOUNT_FCY_DORMANT) {
		R16_AMOUNT_FCY_DORMANT = r16_AMOUNT_FCY_DORMANT;
	}
	public String getR17_S_NO() {
		return R17_S_NO;
	}
	public void setR17_S_NO(String r17_S_NO) {
		R17_S_NO = r17_S_NO;
	}
	public String getR17_REGULATIONS() {
		return R17_REGULATIONS;
	}
	public void setR17_REGULATIONS(String r17_REGULATIONS) {
		R17_REGULATIONS = r17_REGULATIONS;
	}
	public String getR17_DORMANT() {
		return R17_DORMANT;
	}
	public void setR17_DORMANT(String r17_DORMANT) {
		R17_DORMANT = r17_DORMANT;
	}
	public BigDecimal getR17_ACCOUNTS_AED_1YEAR() {
		return R17_ACCOUNTS_AED_1YEAR;
	}
	public void setR17_ACCOUNTS_AED_1YEAR(BigDecimal r17_ACCOUNTS_AED_1YEAR) {
		R17_ACCOUNTS_AED_1YEAR = r17_ACCOUNTS_AED_1YEAR;
	}
	public BigDecimal getR17_AMOUNT_AED_1YEAR() {
		return R17_AMOUNT_AED_1YEAR;
	}
	public void setR17_AMOUNT_AED_1YEAR(BigDecimal r17_AMOUNT_AED_1YEAR) {
		R17_AMOUNT_AED_1YEAR = r17_AMOUNT_AED_1YEAR;
	}
	public BigDecimal getR17_ACCOUNTS_FCY_1YEAR() {
		return R17_ACCOUNTS_FCY_1YEAR;
	}
	public void setR17_ACCOUNTS_FCY_1YEAR(BigDecimal r17_ACCOUNTS_FCY_1YEAR) {
		R17_ACCOUNTS_FCY_1YEAR = r17_ACCOUNTS_FCY_1YEAR;
	}
	public BigDecimal getR17_AMOUNT_FCY_1YEAR() {
		return R17_AMOUNT_FCY_1YEAR;
	}
	public void setR17_AMOUNT_FCY_1YEAR(BigDecimal r17_AMOUNT_FCY_1YEAR) {
		R17_AMOUNT_FCY_1YEAR = r17_AMOUNT_FCY_1YEAR;
	}
	public BigDecimal getR17_ACCOUNTS_AED_2YEAR() {
		return R17_ACCOUNTS_AED_2YEAR;
	}
	public void setR17_ACCOUNTS_AED_2YEAR(BigDecimal r17_ACCOUNTS_AED_2YEAR) {
		R17_ACCOUNTS_AED_2YEAR = r17_ACCOUNTS_AED_2YEAR;
	}
	public BigDecimal getR17_AMOUNT_AED_2YEAR() {
		return R17_AMOUNT_AED_2YEAR;
	}
	public void setR17_AMOUNT_AED_2YEAR(BigDecimal r17_AMOUNT_AED_2YEAR) {
		R17_AMOUNT_AED_2YEAR = r17_AMOUNT_AED_2YEAR;
	}
	public BigDecimal getR17_ACCOUNTS_FCY_2YEAR() {
		return R17_ACCOUNTS_FCY_2YEAR;
	}
	public void setR17_ACCOUNTS_FCY_2YEAR(BigDecimal r17_ACCOUNTS_FCY_2YEAR) {
		R17_ACCOUNTS_FCY_2YEAR = r17_ACCOUNTS_FCY_2YEAR;
	}
	public BigDecimal getR17_AMOUNT_FCY_2YEAR() {
		return R17_AMOUNT_FCY_2YEAR;
	}
	public void setR17_AMOUNT_FCY_2YEAR(BigDecimal r17_AMOUNT_FCY_2YEAR) {
		R17_AMOUNT_FCY_2YEAR = r17_AMOUNT_FCY_2YEAR;
	}
	public BigDecimal getR17_ACCOUNTS_AED_3YEAR() {
		return R17_ACCOUNTS_AED_3YEAR;
	}
	public void setR17_ACCOUNTS_AED_3YEAR(BigDecimal r17_ACCOUNTS_AED_3YEAR) {
		R17_ACCOUNTS_AED_3YEAR = r17_ACCOUNTS_AED_3YEAR;
	}
	public BigDecimal getR17_AMOUNT_AED_3YEAR() {
		return R17_AMOUNT_AED_3YEAR;
	}
	public void setR17_AMOUNT_AED_3YEAR(BigDecimal r17_AMOUNT_AED_3YEAR) {
		R17_AMOUNT_AED_3YEAR = r17_AMOUNT_AED_3YEAR;
	}
	public BigDecimal getR17_ACCOUNTS_FCY_3YEAR() {
		return R17_ACCOUNTS_FCY_3YEAR;
	}
	public void setR17_ACCOUNTS_FCY_3YEAR(BigDecimal r17_ACCOUNTS_FCY_3YEAR) {
		R17_ACCOUNTS_FCY_3YEAR = r17_ACCOUNTS_FCY_3YEAR;
	}
	public BigDecimal getR17_AMOUNT_FCY_3YEAR() {
		return R17_AMOUNT_FCY_3YEAR;
	}
	public void setR17_AMOUNT_FCY_3YEAR(BigDecimal r17_AMOUNT_FCY_3YEAR) {
		R17_AMOUNT_FCY_3YEAR = r17_AMOUNT_FCY_3YEAR;
	}
	public BigDecimal getR17_ACCOUNTS_AED_5YEAR() {
		return R17_ACCOUNTS_AED_5YEAR;
	}
	public void setR17_ACCOUNTS_AED_5YEAR(BigDecimal r17_ACCOUNTS_AED_5YEAR) {
		R17_ACCOUNTS_AED_5YEAR = r17_ACCOUNTS_AED_5YEAR;
	}
	public BigDecimal getR17_AMOUNT_AED_5YEAR() {
		return R17_AMOUNT_AED_5YEAR;
	}
	public void setR17_AMOUNT_AED_5YEAR(BigDecimal r17_AMOUNT_AED_5YEAR) {
		R17_AMOUNT_AED_5YEAR = r17_AMOUNT_AED_5YEAR;
	}
	public BigDecimal getR17_ACCOUNTS_FCY_5YEAR() {
		return R17_ACCOUNTS_FCY_5YEAR;
	}
	public void setR17_ACCOUNTS_FCY_5YEAR(BigDecimal r17_ACCOUNTS_FCY_5YEAR) {
		R17_ACCOUNTS_FCY_5YEAR = r17_ACCOUNTS_FCY_5YEAR;
	}
	public BigDecimal getR17_AMOUNT_FCY_5YEAR() {
		return R17_AMOUNT_FCY_5YEAR;
	}
	public void setR17_AMOUNT_FCY_5YEAR(BigDecimal r17_AMOUNT_FCY_5YEAR) {
		R17_AMOUNT_FCY_5YEAR = r17_AMOUNT_FCY_5YEAR;
	}
	public BigDecimal getR17_ACCOUNTS_AED_ABOVE() {
		return R17_ACCOUNTS_AED_ABOVE;
	}
	public void setR17_ACCOUNTS_AED_ABOVE(BigDecimal r17_ACCOUNTS_AED_ABOVE) {
		R17_ACCOUNTS_AED_ABOVE = r17_ACCOUNTS_AED_ABOVE;
	}
	public BigDecimal getR17_AMOUNT_AED_ABOVE() {
		return R17_AMOUNT_AED_ABOVE;
	}
	public void setR17_AMOUNT_AED_ABOVE(BigDecimal r17_AMOUNT_AED_ABOVE) {
		R17_AMOUNT_AED_ABOVE = r17_AMOUNT_AED_ABOVE;
	}
	public BigDecimal getR17_ACCOUNTS_FCY_ABOVE() {
		return R17_ACCOUNTS_FCY_ABOVE;
	}
	public void setR17_ACCOUNTS_FCY_ABOVE(BigDecimal r17_ACCOUNTS_FCY_ABOVE) {
		R17_ACCOUNTS_FCY_ABOVE = r17_ACCOUNTS_FCY_ABOVE;
	}
	public BigDecimal getR17_AMOUNT_FCY_ABOVE() {
		return R17_AMOUNT_FCY_ABOVE;
	}
	public void setR17_AMOUNT_FCY_ABOVE(BigDecimal r17_AMOUNT_FCY_ABOVE) {
		R17_AMOUNT_FCY_ABOVE = r17_AMOUNT_FCY_ABOVE;
	}
	public BigDecimal getR17_ACCOUNTS_AED_INACTIVE() {
		return R17_ACCOUNTS_AED_INACTIVE;
	}
	public void setR17_ACCOUNTS_AED_INACTIVE(BigDecimal r17_ACCOUNTS_AED_INACTIVE) {
		R17_ACCOUNTS_AED_INACTIVE = r17_ACCOUNTS_AED_INACTIVE;
	}
	public BigDecimal getR17_AMOUNT_AED_INACTIVE() {
		return R17_AMOUNT_AED_INACTIVE;
	}
	public void setR17_AMOUNT_AED_INACTIVE(BigDecimal r17_AMOUNT_AED_INACTIVE) {
		R17_AMOUNT_AED_INACTIVE = r17_AMOUNT_AED_INACTIVE;
	}
	public BigDecimal getR17_ACCOUNTS_FCY_INACTIVE() {
		return R17_ACCOUNTS_FCY_INACTIVE;
	}
	public void setR17_ACCOUNTS_FCY_INACTIVE(BigDecimal r17_ACCOUNTS_FCY_INACTIVE) {
		R17_ACCOUNTS_FCY_INACTIVE = r17_ACCOUNTS_FCY_INACTIVE;
	}
	public BigDecimal getR17_AMOUNT_FCY_INACTIVE() {
		return R17_AMOUNT_FCY_INACTIVE;
	}
	public void setR17_AMOUNT_FCY_INACTIVE(BigDecimal r17_AMOUNT_FCY_INACTIVE) {
		R17_AMOUNT_FCY_INACTIVE = r17_AMOUNT_FCY_INACTIVE;
	}
	public BigDecimal getR17_ACCOUNTS_AED_DORMANT() {
		return R17_ACCOUNTS_AED_DORMANT;
	}
	public void setR17_ACCOUNTS_AED_DORMANT(BigDecimal r17_ACCOUNTS_AED_DORMANT) {
		R17_ACCOUNTS_AED_DORMANT = r17_ACCOUNTS_AED_DORMANT;
	}
	public BigDecimal getR17_AMOUNT_AED_DORMANT() {
		return R17_AMOUNT_AED_DORMANT;
	}
	public void setR17_AMOUNT_AED_DORMANT(BigDecimal r17_AMOUNT_AED_DORMANT) {
		R17_AMOUNT_AED_DORMANT = r17_AMOUNT_AED_DORMANT;
	}
	public BigDecimal getR17_ACCOUNTS_FCY_DORMANT() {
		return R17_ACCOUNTS_FCY_DORMANT;
	}
	public void setR17_ACCOUNTS_FCY_DORMANT(BigDecimal r17_ACCOUNTS_FCY_DORMANT) {
		R17_ACCOUNTS_FCY_DORMANT = r17_ACCOUNTS_FCY_DORMANT;
	}
	public BigDecimal getR17_AMOUNT_FCY_DORMANT() {
		return R17_AMOUNT_FCY_DORMANT;
	}
	public void setR17_AMOUNT_FCY_DORMANT(BigDecimal r17_AMOUNT_FCY_DORMANT) {
		R17_AMOUNT_FCY_DORMANT = r17_AMOUNT_FCY_DORMANT;
	}
	public String getR18_S_NO() {
		return R18_S_NO;
	}
	public void setR18_S_NO(String r18_S_NO) {
		R18_S_NO = r18_S_NO;
	}
	public String getR18_REGULATIONS() {
		return R18_REGULATIONS;
	}
	public void setR18_REGULATIONS(String r18_REGULATIONS) {
		R18_REGULATIONS = r18_REGULATIONS;
	}
	public String getR18_DORMANT() {
		return R18_DORMANT;
	}
	public void setR18_DORMANT(String r18_DORMANT) {
		R18_DORMANT = r18_DORMANT;
	}
	public BigDecimal getR18_ACCOUNTS_AED_1YEAR() {
		return R18_ACCOUNTS_AED_1YEAR;
	}
	public void setR18_ACCOUNTS_AED_1YEAR(BigDecimal r18_ACCOUNTS_AED_1YEAR) {
		R18_ACCOUNTS_AED_1YEAR = r18_ACCOUNTS_AED_1YEAR;
	}
	public BigDecimal getR18_AMOUNT_AED_1YEAR() {
		return R18_AMOUNT_AED_1YEAR;
	}
	public void setR18_AMOUNT_AED_1YEAR(BigDecimal r18_AMOUNT_AED_1YEAR) {
		R18_AMOUNT_AED_1YEAR = r18_AMOUNT_AED_1YEAR;
	}
	public BigDecimal getR18_ACCOUNTS_FCY_1YEAR() {
		return R18_ACCOUNTS_FCY_1YEAR;
	}
	public void setR18_ACCOUNTS_FCY_1YEAR(BigDecimal r18_ACCOUNTS_FCY_1YEAR) {
		R18_ACCOUNTS_FCY_1YEAR = r18_ACCOUNTS_FCY_1YEAR;
	}
	public BigDecimal getR18_AMOUNT_FCY_1YEAR() {
		return R18_AMOUNT_FCY_1YEAR;
	}
	public void setR18_AMOUNT_FCY_1YEAR(BigDecimal r18_AMOUNT_FCY_1YEAR) {
		R18_AMOUNT_FCY_1YEAR = r18_AMOUNT_FCY_1YEAR;
	}
	public BigDecimal getR18_ACCOUNTS_AED_2YEAR() {
		return R18_ACCOUNTS_AED_2YEAR;
	}
	public void setR18_ACCOUNTS_AED_2YEAR(BigDecimal r18_ACCOUNTS_AED_2YEAR) {
		R18_ACCOUNTS_AED_2YEAR = r18_ACCOUNTS_AED_2YEAR;
	}
	public BigDecimal getR18_AMOUNT_AED_2YEAR() {
		return R18_AMOUNT_AED_2YEAR;
	}
	public void setR18_AMOUNT_AED_2YEAR(BigDecimal r18_AMOUNT_AED_2YEAR) {
		R18_AMOUNT_AED_2YEAR = r18_AMOUNT_AED_2YEAR;
	}
	public BigDecimal getR18_ACCOUNTS_FCY_2YEAR() {
		return R18_ACCOUNTS_FCY_2YEAR;
	}
	public void setR18_ACCOUNTS_FCY_2YEAR(BigDecimal r18_ACCOUNTS_FCY_2YEAR) {
		R18_ACCOUNTS_FCY_2YEAR = r18_ACCOUNTS_FCY_2YEAR;
	}
	public BigDecimal getR18_AMOUNT_FCY_2YEAR() {
		return R18_AMOUNT_FCY_2YEAR;
	}
	public void setR18_AMOUNT_FCY_2YEAR(BigDecimal r18_AMOUNT_FCY_2YEAR) {
		R18_AMOUNT_FCY_2YEAR = r18_AMOUNT_FCY_2YEAR;
	}
	public BigDecimal getR18_ACCOUNTS_AED_3YEAR() {
		return R18_ACCOUNTS_AED_3YEAR;
	}
	public void setR18_ACCOUNTS_AED_3YEAR(BigDecimal r18_ACCOUNTS_AED_3YEAR) {
		R18_ACCOUNTS_AED_3YEAR = r18_ACCOUNTS_AED_3YEAR;
	}
	public BigDecimal getR18_AMOUNT_AED_3YEAR() {
		return R18_AMOUNT_AED_3YEAR;
	}
	public void setR18_AMOUNT_AED_3YEAR(BigDecimal r18_AMOUNT_AED_3YEAR) {
		R18_AMOUNT_AED_3YEAR = r18_AMOUNT_AED_3YEAR;
	}
	public BigDecimal getR18_ACCOUNTS_FCY_3YEAR() {
		return R18_ACCOUNTS_FCY_3YEAR;
	}
	public void setR18_ACCOUNTS_FCY_3YEAR(BigDecimal r18_ACCOUNTS_FCY_3YEAR) {
		R18_ACCOUNTS_FCY_3YEAR = r18_ACCOUNTS_FCY_3YEAR;
	}
	public BigDecimal getR18_AMOUNT_FCY_3YEAR() {
		return R18_AMOUNT_FCY_3YEAR;
	}
	public void setR18_AMOUNT_FCY_3YEAR(BigDecimal r18_AMOUNT_FCY_3YEAR) {
		R18_AMOUNT_FCY_3YEAR = r18_AMOUNT_FCY_3YEAR;
	}
	public BigDecimal getR18_ACCOUNTS_AED_5YEAR() {
		return R18_ACCOUNTS_AED_5YEAR;
	}
	public void setR18_ACCOUNTS_AED_5YEAR(BigDecimal r18_ACCOUNTS_AED_5YEAR) {
		R18_ACCOUNTS_AED_5YEAR = r18_ACCOUNTS_AED_5YEAR;
	}
	public BigDecimal getR18_AMOUNT_AED_5YEAR() {
		return R18_AMOUNT_AED_5YEAR;
	}
	public void setR18_AMOUNT_AED_5YEAR(BigDecimal r18_AMOUNT_AED_5YEAR) {
		R18_AMOUNT_AED_5YEAR = r18_AMOUNT_AED_5YEAR;
	}
	public BigDecimal getR18_ACCOUNTS_FCY_5YEAR() {
		return R18_ACCOUNTS_FCY_5YEAR;
	}
	public void setR18_ACCOUNTS_FCY_5YEAR(BigDecimal r18_ACCOUNTS_FCY_5YEAR) {
		R18_ACCOUNTS_FCY_5YEAR = r18_ACCOUNTS_FCY_5YEAR;
	}
	public BigDecimal getR18_AMOUNT_FCY_5YEAR() {
		return R18_AMOUNT_FCY_5YEAR;
	}
	public void setR18_AMOUNT_FCY_5YEAR(BigDecimal r18_AMOUNT_FCY_5YEAR) {
		R18_AMOUNT_FCY_5YEAR = r18_AMOUNT_FCY_5YEAR;
	}
	public BigDecimal getR18_ACCOUNTS_AED_ABOVE() {
		return R18_ACCOUNTS_AED_ABOVE;
	}
	public void setR18_ACCOUNTS_AED_ABOVE(BigDecimal r18_ACCOUNTS_AED_ABOVE) {
		R18_ACCOUNTS_AED_ABOVE = r18_ACCOUNTS_AED_ABOVE;
	}
	public BigDecimal getR18_AMOUNT_AED_ABOVE() {
		return R18_AMOUNT_AED_ABOVE;
	}
	public void setR18_AMOUNT_AED_ABOVE(BigDecimal r18_AMOUNT_AED_ABOVE) {
		R18_AMOUNT_AED_ABOVE = r18_AMOUNT_AED_ABOVE;
	}
	public BigDecimal getR18_ACCOUNTS_FCY_ABOVE() {
		return R18_ACCOUNTS_FCY_ABOVE;
	}
	public void setR18_ACCOUNTS_FCY_ABOVE(BigDecimal r18_ACCOUNTS_FCY_ABOVE) {
		R18_ACCOUNTS_FCY_ABOVE = r18_ACCOUNTS_FCY_ABOVE;
	}
	public BigDecimal getR18_AMOUNT_FCY_ABOVE() {
		return R18_AMOUNT_FCY_ABOVE;
	}
	public void setR18_AMOUNT_FCY_ABOVE(BigDecimal r18_AMOUNT_FCY_ABOVE) {
		R18_AMOUNT_FCY_ABOVE = r18_AMOUNT_FCY_ABOVE;
	}
	public BigDecimal getR18_ACCOUNTS_AED_INACTIVE() {
		return R18_ACCOUNTS_AED_INACTIVE;
	}
	public void setR18_ACCOUNTS_AED_INACTIVE(BigDecimal r18_ACCOUNTS_AED_INACTIVE) {
		R18_ACCOUNTS_AED_INACTIVE = r18_ACCOUNTS_AED_INACTIVE;
	}
	public BigDecimal getR18_AMOUNT_AED_INACTIVE() {
		return R18_AMOUNT_AED_INACTIVE;
	}
	public void setR18_AMOUNT_AED_INACTIVE(BigDecimal r18_AMOUNT_AED_INACTIVE) {
		R18_AMOUNT_AED_INACTIVE = r18_AMOUNT_AED_INACTIVE;
	}
	public BigDecimal getR18_ACCOUNTS_FCY_INACTIVE() {
		return R18_ACCOUNTS_FCY_INACTIVE;
	}
	public void setR18_ACCOUNTS_FCY_INACTIVE(BigDecimal r18_ACCOUNTS_FCY_INACTIVE) {
		R18_ACCOUNTS_FCY_INACTIVE = r18_ACCOUNTS_FCY_INACTIVE;
	}
	public BigDecimal getR18_AMOUNT_FCY_INACTIVE() {
		return R18_AMOUNT_FCY_INACTIVE;
	}
	public void setR18_AMOUNT_FCY_INACTIVE(BigDecimal r18_AMOUNT_FCY_INACTIVE) {
		R18_AMOUNT_FCY_INACTIVE = r18_AMOUNT_FCY_INACTIVE;
	}
	public BigDecimal getR18_ACCOUNTS_AED_DORMANT() {
		return R18_ACCOUNTS_AED_DORMANT;
	}
	public void setR18_ACCOUNTS_AED_DORMANT(BigDecimal r18_ACCOUNTS_AED_DORMANT) {
		R18_ACCOUNTS_AED_DORMANT = r18_ACCOUNTS_AED_DORMANT;
	}
	public BigDecimal getR18_AMOUNT_AED_DORMANT() {
		return R18_AMOUNT_AED_DORMANT;
	}
	public void setR18_AMOUNT_AED_DORMANT(BigDecimal r18_AMOUNT_AED_DORMANT) {
		R18_AMOUNT_AED_DORMANT = r18_AMOUNT_AED_DORMANT;
	}
	public BigDecimal getR18_ACCOUNTS_FCY_DORMANT() {
		return R18_ACCOUNTS_FCY_DORMANT;
	}
	public void setR18_ACCOUNTS_FCY_DORMANT(BigDecimal r18_ACCOUNTS_FCY_DORMANT) {
		R18_ACCOUNTS_FCY_DORMANT = r18_ACCOUNTS_FCY_DORMANT;
	}
	public BigDecimal getR18_AMOUNT_FCY_DORMANT() {
		return R18_AMOUNT_FCY_DORMANT;
	}
	public void setR18_AMOUNT_FCY_DORMANT(BigDecimal r18_AMOUNT_FCY_DORMANT) {
		R18_AMOUNT_FCY_DORMANT = r18_AMOUNT_FCY_DORMANT;
	}
	public String getR19_S_NO() {
		return R19_S_NO;
	}
	public void setR19_S_NO(String r19_S_NO) {
		R19_S_NO = r19_S_NO;
	}
	public String getR19_REGULATIONS() {
		return R19_REGULATIONS;
	}
	public void setR19_REGULATIONS(String r19_REGULATIONS) {
		R19_REGULATIONS = r19_REGULATIONS;
	}
	public String getR19_DORMANT() {
		return R19_DORMANT;
	}
	public void setR19_DORMANT(String r19_DORMANT) {
		R19_DORMANT = r19_DORMANT;
	}
	public BigDecimal getR19_ACCOUNTS_AED_1YEAR() {
		return R19_ACCOUNTS_AED_1YEAR;
	}
	public void setR19_ACCOUNTS_AED_1YEAR(BigDecimal r19_ACCOUNTS_AED_1YEAR) {
		R19_ACCOUNTS_AED_1YEAR = r19_ACCOUNTS_AED_1YEAR;
	}
	public BigDecimal getR19_AMOUNT_AED_1YEAR() {
		return R19_AMOUNT_AED_1YEAR;
	}
	public void setR19_AMOUNT_AED_1YEAR(BigDecimal r19_AMOUNT_AED_1YEAR) {
		R19_AMOUNT_AED_1YEAR = r19_AMOUNT_AED_1YEAR;
	}
	public BigDecimal getR19_ACCOUNTS_FCY_1YEAR() {
		return R19_ACCOUNTS_FCY_1YEAR;
	}
	public void setR19_ACCOUNTS_FCY_1YEAR(BigDecimal r19_ACCOUNTS_FCY_1YEAR) {
		R19_ACCOUNTS_FCY_1YEAR = r19_ACCOUNTS_FCY_1YEAR;
	}
	public BigDecimal getR19_AMOUNT_FCY_1YEAR() {
		return R19_AMOUNT_FCY_1YEAR;
	}
	public void setR19_AMOUNT_FCY_1YEAR(BigDecimal r19_AMOUNT_FCY_1YEAR) {
		R19_AMOUNT_FCY_1YEAR = r19_AMOUNT_FCY_1YEAR;
	}
	public BigDecimal getR19_ACCOUNTS_AED_2YEAR() {
		return R19_ACCOUNTS_AED_2YEAR;
	}
	public void setR19_ACCOUNTS_AED_2YEAR(BigDecimal r19_ACCOUNTS_AED_2YEAR) {
		R19_ACCOUNTS_AED_2YEAR = r19_ACCOUNTS_AED_2YEAR;
	}
	public BigDecimal getR19_AMOUNT_AED_2YEAR() {
		return R19_AMOUNT_AED_2YEAR;
	}
	public void setR19_AMOUNT_AED_2YEAR(BigDecimal r19_AMOUNT_AED_2YEAR) {
		R19_AMOUNT_AED_2YEAR = r19_AMOUNT_AED_2YEAR;
	}
	public BigDecimal getR19_ACCOUNTS_FCY_2YEAR() {
		return R19_ACCOUNTS_FCY_2YEAR;
	}
	public void setR19_ACCOUNTS_FCY_2YEAR(BigDecimal r19_ACCOUNTS_FCY_2YEAR) {
		R19_ACCOUNTS_FCY_2YEAR = r19_ACCOUNTS_FCY_2YEAR;
	}
	public BigDecimal getR19_AMOUNT_FCY_2YEAR() {
		return R19_AMOUNT_FCY_2YEAR;
	}
	public void setR19_AMOUNT_FCY_2YEAR(BigDecimal r19_AMOUNT_FCY_2YEAR) {
		R19_AMOUNT_FCY_2YEAR = r19_AMOUNT_FCY_2YEAR;
	}
	public BigDecimal getR19_ACCOUNTS_AED_3YEAR() {
		return R19_ACCOUNTS_AED_3YEAR;
	}
	public void setR19_ACCOUNTS_AED_3YEAR(BigDecimal r19_ACCOUNTS_AED_3YEAR) {
		R19_ACCOUNTS_AED_3YEAR = r19_ACCOUNTS_AED_3YEAR;
	}
	public BigDecimal getR19_AMOUNT_AED_3YEAR() {
		return R19_AMOUNT_AED_3YEAR;
	}
	public void setR19_AMOUNT_AED_3YEAR(BigDecimal r19_AMOUNT_AED_3YEAR) {
		R19_AMOUNT_AED_3YEAR = r19_AMOUNT_AED_3YEAR;
	}
	public BigDecimal getR19_ACCOUNTS_FCY_3YEAR() {
		return R19_ACCOUNTS_FCY_3YEAR;
	}
	public void setR19_ACCOUNTS_FCY_3YEAR(BigDecimal r19_ACCOUNTS_FCY_3YEAR) {
		R19_ACCOUNTS_FCY_3YEAR = r19_ACCOUNTS_FCY_3YEAR;
	}
	public BigDecimal getR19_AMOUNT_FCY_3YEAR() {
		return R19_AMOUNT_FCY_3YEAR;
	}
	public void setR19_AMOUNT_FCY_3YEAR(BigDecimal r19_AMOUNT_FCY_3YEAR) {
		R19_AMOUNT_FCY_3YEAR = r19_AMOUNT_FCY_3YEAR;
	}
	public BigDecimal getR19_ACCOUNTS_AED_5YEAR() {
		return R19_ACCOUNTS_AED_5YEAR;
	}
	public void setR19_ACCOUNTS_AED_5YEAR(BigDecimal r19_ACCOUNTS_AED_5YEAR) {
		R19_ACCOUNTS_AED_5YEAR = r19_ACCOUNTS_AED_5YEAR;
	}
	public BigDecimal getR19_AMOUNT_AED_5YEAR() {
		return R19_AMOUNT_AED_5YEAR;
	}
	public void setR19_AMOUNT_AED_5YEAR(BigDecimal r19_AMOUNT_AED_5YEAR) {
		R19_AMOUNT_AED_5YEAR = r19_AMOUNT_AED_5YEAR;
	}
	public BigDecimal getR19_ACCOUNTS_FCY_5YEAR() {
		return R19_ACCOUNTS_FCY_5YEAR;
	}
	public void setR19_ACCOUNTS_FCY_5YEAR(BigDecimal r19_ACCOUNTS_FCY_5YEAR) {
		R19_ACCOUNTS_FCY_5YEAR = r19_ACCOUNTS_FCY_5YEAR;
	}
	public BigDecimal getR19_AMOUNT_FCY_5YEAR() {
		return R19_AMOUNT_FCY_5YEAR;
	}
	public void setR19_AMOUNT_FCY_5YEAR(BigDecimal r19_AMOUNT_FCY_5YEAR) {
		R19_AMOUNT_FCY_5YEAR = r19_AMOUNT_FCY_5YEAR;
	}
	public BigDecimal getR19_ACCOUNTS_AED_ABOVE() {
		return R19_ACCOUNTS_AED_ABOVE;
	}
	public void setR19_ACCOUNTS_AED_ABOVE(BigDecimal r19_ACCOUNTS_AED_ABOVE) {
		R19_ACCOUNTS_AED_ABOVE = r19_ACCOUNTS_AED_ABOVE;
	}
	public BigDecimal getR19_AMOUNT_AED_ABOVE() {
		return R19_AMOUNT_AED_ABOVE;
	}
	public void setR19_AMOUNT_AED_ABOVE(BigDecimal r19_AMOUNT_AED_ABOVE) {
		R19_AMOUNT_AED_ABOVE = r19_AMOUNT_AED_ABOVE;
	}
	public BigDecimal getR19_ACCOUNTS_FCY_ABOVE() {
		return R19_ACCOUNTS_FCY_ABOVE;
	}
	public void setR19_ACCOUNTS_FCY_ABOVE(BigDecimal r19_ACCOUNTS_FCY_ABOVE) {
		R19_ACCOUNTS_FCY_ABOVE = r19_ACCOUNTS_FCY_ABOVE;
	}
	public BigDecimal getR19_AMOUNT_FCY_ABOVE() {
		return R19_AMOUNT_FCY_ABOVE;
	}
	public void setR19_AMOUNT_FCY_ABOVE(BigDecimal r19_AMOUNT_FCY_ABOVE) {
		R19_AMOUNT_FCY_ABOVE = r19_AMOUNT_FCY_ABOVE;
	}
	public BigDecimal getR19_ACCOUNTS_AED_INACTIVE() {
		return R19_ACCOUNTS_AED_INACTIVE;
	}
	public void setR19_ACCOUNTS_AED_INACTIVE(BigDecimal r19_ACCOUNTS_AED_INACTIVE) {
		R19_ACCOUNTS_AED_INACTIVE = r19_ACCOUNTS_AED_INACTIVE;
	}
	public BigDecimal getR19_AMOUNT_AED_INACTIVE() {
		return R19_AMOUNT_AED_INACTIVE;
	}
	public void setR19_AMOUNT_AED_INACTIVE(BigDecimal r19_AMOUNT_AED_INACTIVE) {
		R19_AMOUNT_AED_INACTIVE = r19_AMOUNT_AED_INACTIVE;
	}
	public BigDecimal getR19_ACCOUNTS_FCY_INACTIVE() {
		return R19_ACCOUNTS_FCY_INACTIVE;
	}
	public void setR19_ACCOUNTS_FCY_INACTIVE(BigDecimal r19_ACCOUNTS_FCY_INACTIVE) {
		R19_ACCOUNTS_FCY_INACTIVE = r19_ACCOUNTS_FCY_INACTIVE;
	}
	public BigDecimal getR19_AMOUNT_FCY_INACTIVE() {
		return R19_AMOUNT_FCY_INACTIVE;
	}
	public void setR19_AMOUNT_FCY_INACTIVE(BigDecimal r19_AMOUNT_FCY_INACTIVE) {
		R19_AMOUNT_FCY_INACTIVE = r19_AMOUNT_FCY_INACTIVE;
	}
	public BigDecimal getR19_ACCOUNTS_AED_DORMANT() {
		return R19_ACCOUNTS_AED_DORMANT;
	}
	public void setR19_ACCOUNTS_AED_DORMANT(BigDecimal r19_ACCOUNTS_AED_DORMANT) {
		R19_ACCOUNTS_AED_DORMANT = r19_ACCOUNTS_AED_DORMANT;
	}
	public BigDecimal getR19_AMOUNT_AED_DORMANT() {
		return R19_AMOUNT_AED_DORMANT;
	}
	public void setR19_AMOUNT_AED_DORMANT(BigDecimal r19_AMOUNT_AED_DORMANT) {
		R19_AMOUNT_AED_DORMANT = r19_AMOUNT_AED_DORMANT;
	}
	public BigDecimal getR19_ACCOUNTS_FCY_DORMANT() {
		return R19_ACCOUNTS_FCY_DORMANT;
	}
	public void setR19_ACCOUNTS_FCY_DORMANT(BigDecimal r19_ACCOUNTS_FCY_DORMANT) {
		R19_ACCOUNTS_FCY_DORMANT = r19_ACCOUNTS_FCY_DORMANT;
	}
	public BigDecimal getR19_AMOUNT_FCY_DORMANT() {
		return R19_AMOUNT_FCY_DORMANT;
	}
	public void setR19_AMOUNT_FCY_DORMANT(BigDecimal r19_AMOUNT_FCY_DORMANT) {
		R19_AMOUNT_FCY_DORMANT = r19_AMOUNT_FCY_DORMANT;
	}
	public String getR20_S_NO() {
		return R20_S_NO;
	}
	public void setR20_S_NO(String r20_S_NO) {
		R20_S_NO = r20_S_NO;
	}
	public String getR20_REGULATIONS() {
		return R20_REGULATIONS;
	}
	public void setR20_REGULATIONS(String r20_REGULATIONS) {
		R20_REGULATIONS = r20_REGULATIONS;
	}
	public String getR20_DORMANT() {
		return R20_DORMANT;
	}
	public void setR20_DORMANT(String r20_DORMANT) {
		R20_DORMANT = r20_DORMANT;
	}
	public BigDecimal getR20_ACCOUNTS_AED_1YEAR() {
		return R20_ACCOUNTS_AED_1YEAR;
	}
	public void setR20_ACCOUNTS_AED_1YEAR(BigDecimal r20_ACCOUNTS_AED_1YEAR) {
		R20_ACCOUNTS_AED_1YEAR = r20_ACCOUNTS_AED_1YEAR;
	}
	public BigDecimal getR20_AMOUNT_AED_1YEAR() {
		return R20_AMOUNT_AED_1YEAR;
	}
	public void setR20_AMOUNT_AED_1YEAR(BigDecimal r20_AMOUNT_AED_1YEAR) {
		R20_AMOUNT_AED_1YEAR = r20_AMOUNT_AED_1YEAR;
	}
	public BigDecimal getR20_ACCOUNTS_FCY_1YEAR() {
		return R20_ACCOUNTS_FCY_1YEAR;
	}
	public void setR20_ACCOUNTS_FCY_1YEAR(BigDecimal r20_ACCOUNTS_FCY_1YEAR) {
		R20_ACCOUNTS_FCY_1YEAR = r20_ACCOUNTS_FCY_1YEAR;
	}
	public BigDecimal getR20_AMOUNT_FCY_1YEAR() {
		return R20_AMOUNT_FCY_1YEAR;
	}
	public void setR20_AMOUNT_FCY_1YEAR(BigDecimal r20_AMOUNT_FCY_1YEAR) {
		R20_AMOUNT_FCY_1YEAR = r20_AMOUNT_FCY_1YEAR;
	}
	public BigDecimal getR20_ACCOUNTS_AED_2YEAR() {
		return R20_ACCOUNTS_AED_2YEAR;
	}
	public void setR20_ACCOUNTS_AED_2YEAR(BigDecimal r20_ACCOUNTS_AED_2YEAR) {
		R20_ACCOUNTS_AED_2YEAR = r20_ACCOUNTS_AED_2YEAR;
	}
	public BigDecimal getR20_AMOUNT_AED_2YEAR() {
		return R20_AMOUNT_AED_2YEAR;
	}
	public void setR20_AMOUNT_AED_2YEAR(BigDecimal r20_AMOUNT_AED_2YEAR) {
		R20_AMOUNT_AED_2YEAR = r20_AMOUNT_AED_2YEAR;
	}
	public BigDecimal getR20_ACCOUNTS_FCY_2YEAR() {
		return R20_ACCOUNTS_FCY_2YEAR;
	}
	public void setR20_ACCOUNTS_FCY_2YEAR(BigDecimal r20_ACCOUNTS_FCY_2YEAR) {
		R20_ACCOUNTS_FCY_2YEAR = r20_ACCOUNTS_FCY_2YEAR;
	}
	public BigDecimal getR20_AMOUNT_FCY_2YEAR() {
		return R20_AMOUNT_FCY_2YEAR;
	}
	public void setR20_AMOUNT_FCY_2YEAR(BigDecimal r20_AMOUNT_FCY_2YEAR) {
		R20_AMOUNT_FCY_2YEAR = r20_AMOUNT_FCY_2YEAR;
	}
	public BigDecimal getR20_ACCOUNTS_AED_3YEAR() {
		return R20_ACCOUNTS_AED_3YEAR;
	}
	public void setR20_ACCOUNTS_AED_3YEAR(BigDecimal r20_ACCOUNTS_AED_3YEAR) {
		R20_ACCOUNTS_AED_3YEAR = r20_ACCOUNTS_AED_3YEAR;
	}
	public BigDecimal getR20_AMOUNT_AED_3YEAR() {
		return R20_AMOUNT_AED_3YEAR;
	}
	public void setR20_AMOUNT_AED_3YEAR(BigDecimal r20_AMOUNT_AED_3YEAR) {
		R20_AMOUNT_AED_3YEAR = r20_AMOUNT_AED_3YEAR;
	}
	public BigDecimal getR20_ACCOUNTS_FCY_3YEAR() {
		return R20_ACCOUNTS_FCY_3YEAR;
	}
	public void setR20_ACCOUNTS_FCY_3YEAR(BigDecimal r20_ACCOUNTS_FCY_3YEAR) {
		R20_ACCOUNTS_FCY_3YEAR = r20_ACCOUNTS_FCY_3YEAR;
	}
	public BigDecimal getR20_AMOUNT_FCY_3YEAR() {
		return R20_AMOUNT_FCY_3YEAR;
	}
	public void setR20_AMOUNT_FCY_3YEAR(BigDecimal r20_AMOUNT_FCY_3YEAR) {
		R20_AMOUNT_FCY_3YEAR = r20_AMOUNT_FCY_3YEAR;
	}
	public BigDecimal getR20_ACCOUNTS_AED_5YEAR() {
		return R20_ACCOUNTS_AED_5YEAR;
	}
	public void setR20_ACCOUNTS_AED_5YEAR(BigDecimal r20_ACCOUNTS_AED_5YEAR) {
		R20_ACCOUNTS_AED_5YEAR = r20_ACCOUNTS_AED_5YEAR;
	}
	public BigDecimal getR20_AMOUNT_AED_5YEAR() {
		return R20_AMOUNT_AED_5YEAR;
	}
	public void setR20_AMOUNT_AED_5YEAR(BigDecimal r20_AMOUNT_AED_5YEAR) {
		R20_AMOUNT_AED_5YEAR = r20_AMOUNT_AED_5YEAR;
	}
	public BigDecimal getR20_ACCOUNTS_FCY_5YEAR() {
		return R20_ACCOUNTS_FCY_5YEAR;
	}
	public void setR20_ACCOUNTS_FCY_5YEAR(BigDecimal r20_ACCOUNTS_FCY_5YEAR) {
		R20_ACCOUNTS_FCY_5YEAR = r20_ACCOUNTS_FCY_5YEAR;
	}
	public BigDecimal getR20_AMOUNT_FCY_5YEAR() {
		return R20_AMOUNT_FCY_5YEAR;
	}
	public void setR20_AMOUNT_FCY_5YEAR(BigDecimal r20_AMOUNT_FCY_5YEAR) {
		R20_AMOUNT_FCY_5YEAR = r20_AMOUNT_FCY_5YEAR;
	}
	public BigDecimal getR20_ACCOUNTS_AED_ABOVE() {
		return R20_ACCOUNTS_AED_ABOVE;
	}
	public void setR20_ACCOUNTS_AED_ABOVE(BigDecimal r20_ACCOUNTS_AED_ABOVE) {
		R20_ACCOUNTS_AED_ABOVE = r20_ACCOUNTS_AED_ABOVE;
	}
	public BigDecimal getR20_AMOUNT_AED_ABOVE() {
		return R20_AMOUNT_AED_ABOVE;
	}
	public void setR20_AMOUNT_AED_ABOVE(BigDecimal r20_AMOUNT_AED_ABOVE) {
		R20_AMOUNT_AED_ABOVE = r20_AMOUNT_AED_ABOVE;
	}
	public BigDecimal getR20_ACCOUNTS_FCY_ABOVE() {
		return R20_ACCOUNTS_FCY_ABOVE;
	}
	public void setR20_ACCOUNTS_FCY_ABOVE(BigDecimal r20_ACCOUNTS_FCY_ABOVE) {
		R20_ACCOUNTS_FCY_ABOVE = r20_ACCOUNTS_FCY_ABOVE;
	}
	public BigDecimal getR20_AMOUNT_FCY_ABOVE() {
		return R20_AMOUNT_FCY_ABOVE;
	}
	public void setR20_AMOUNT_FCY_ABOVE(BigDecimal r20_AMOUNT_FCY_ABOVE) {
		R20_AMOUNT_FCY_ABOVE = r20_AMOUNT_FCY_ABOVE;
	}
	public BigDecimal getR20_ACCOUNTS_AED_INACTIVE() {
		return R20_ACCOUNTS_AED_INACTIVE;
	}
	public void setR20_ACCOUNTS_AED_INACTIVE(BigDecimal r20_ACCOUNTS_AED_INACTIVE) {
		R20_ACCOUNTS_AED_INACTIVE = r20_ACCOUNTS_AED_INACTIVE;
	}
	public BigDecimal getR20_AMOUNT_AED_INACTIVE() {
		return R20_AMOUNT_AED_INACTIVE;
	}
	public void setR20_AMOUNT_AED_INACTIVE(BigDecimal r20_AMOUNT_AED_INACTIVE) {
		R20_AMOUNT_AED_INACTIVE = r20_AMOUNT_AED_INACTIVE;
	}
	public BigDecimal getR20_ACCOUNTS_FCY_INACTIVE() {
		return R20_ACCOUNTS_FCY_INACTIVE;
	}
	public void setR20_ACCOUNTS_FCY_INACTIVE(BigDecimal r20_ACCOUNTS_FCY_INACTIVE) {
		R20_ACCOUNTS_FCY_INACTIVE = r20_ACCOUNTS_FCY_INACTIVE;
	}
	public BigDecimal getR20_AMOUNT_FCY_INACTIVE() {
		return R20_AMOUNT_FCY_INACTIVE;
	}
	public void setR20_AMOUNT_FCY_INACTIVE(BigDecimal r20_AMOUNT_FCY_INACTIVE) {
		R20_AMOUNT_FCY_INACTIVE = r20_AMOUNT_FCY_INACTIVE;
	}
	public BigDecimal getR20_ACCOUNTS_AED_DORMANT() {
		return R20_ACCOUNTS_AED_DORMANT;
	}
	public void setR20_ACCOUNTS_AED_DORMANT(BigDecimal r20_ACCOUNTS_AED_DORMANT) {
		R20_ACCOUNTS_AED_DORMANT = r20_ACCOUNTS_AED_DORMANT;
	}
	public BigDecimal getR20_AMOUNT_AED_DORMANT() {
		return R20_AMOUNT_AED_DORMANT;
	}
	public void setR20_AMOUNT_AED_DORMANT(BigDecimal r20_AMOUNT_AED_DORMANT) {
		R20_AMOUNT_AED_DORMANT = r20_AMOUNT_AED_DORMANT;
	}
	public BigDecimal getR20_ACCOUNTS_FCY_DORMANT() {
		return R20_ACCOUNTS_FCY_DORMANT;
	}
	public void setR20_ACCOUNTS_FCY_DORMANT(BigDecimal r20_ACCOUNTS_FCY_DORMANT) {
		R20_ACCOUNTS_FCY_DORMANT = r20_ACCOUNTS_FCY_DORMANT;
	}
	public BigDecimal getR20_AMOUNT_FCY_DORMANT() {
		return R20_AMOUNT_FCY_DORMANT;
	}
	public void setR20_AMOUNT_FCY_DORMANT(BigDecimal r20_AMOUNT_FCY_DORMANT) {
		R20_AMOUNT_FCY_DORMANT = r20_AMOUNT_FCY_DORMANT;
	}
	public String getR21_S_NO() {
		return R21_S_NO;
	}
	public void setR21_S_NO(String r21_S_NO) {
		R21_S_NO = r21_S_NO;
	}
	public String getR21_REGULATIONS() {
		return R21_REGULATIONS;
	}
	public void setR21_REGULATIONS(String r21_REGULATIONS) {
		R21_REGULATIONS = r21_REGULATIONS;
	}
	public String getR21_DORMANT() {
		return R21_DORMANT;
	}
	public void setR21_DORMANT(String r21_DORMANT) {
		R21_DORMANT = r21_DORMANT;
	}
	public BigDecimal getR21_ACCOUNTS_AED_1YEAR() {
		return R21_ACCOUNTS_AED_1YEAR;
	}
	public void setR21_ACCOUNTS_AED_1YEAR(BigDecimal r21_ACCOUNTS_AED_1YEAR) {
		R21_ACCOUNTS_AED_1YEAR = r21_ACCOUNTS_AED_1YEAR;
	}
	public BigDecimal getR21_AMOUNT_AED_1YEAR() {
		return R21_AMOUNT_AED_1YEAR;
	}
	public void setR21_AMOUNT_AED_1YEAR(BigDecimal r21_AMOUNT_AED_1YEAR) {
		R21_AMOUNT_AED_1YEAR = r21_AMOUNT_AED_1YEAR;
	}
	public BigDecimal getR21_ACCOUNTS_FCY_1YEAR() {
		return R21_ACCOUNTS_FCY_1YEAR;
	}
	public void setR21_ACCOUNTS_FCY_1YEAR(BigDecimal r21_ACCOUNTS_FCY_1YEAR) {
		R21_ACCOUNTS_FCY_1YEAR = r21_ACCOUNTS_FCY_1YEAR;
	}
	public BigDecimal getR21_AMOUNT_FCY_1YEAR() {
		return R21_AMOUNT_FCY_1YEAR;
	}
	public void setR21_AMOUNT_FCY_1YEAR(BigDecimal r21_AMOUNT_FCY_1YEAR) {
		R21_AMOUNT_FCY_1YEAR = r21_AMOUNT_FCY_1YEAR;
	}
	public BigDecimal getR21_ACCOUNTS_AED_2YEAR() {
		return R21_ACCOUNTS_AED_2YEAR;
	}
	public void setR21_ACCOUNTS_AED_2YEAR(BigDecimal r21_ACCOUNTS_AED_2YEAR) {
		R21_ACCOUNTS_AED_2YEAR = r21_ACCOUNTS_AED_2YEAR;
	}
	public BigDecimal getR21_AMOUNT_AED_2YEAR() {
		return R21_AMOUNT_AED_2YEAR;
	}
	public void setR21_AMOUNT_AED_2YEAR(BigDecimal r21_AMOUNT_AED_2YEAR) {
		R21_AMOUNT_AED_2YEAR = r21_AMOUNT_AED_2YEAR;
	}
	public BigDecimal getR21_ACCOUNTS_FCY_2YEAR() {
		return R21_ACCOUNTS_FCY_2YEAR;
	}
	public void setR21_ACCOUNTS_FCY_2YEAR(BigDecimal r21_ACCOUNTS_FCY_2YEAR) {
		R21_ACCOUNTS_FCY_2YEAR = r21_ACCOUNTS_FCY_2YEAR;
	}
	public BigDecimal getR21_AMOUNT_FCY_2YEAR() {
		return R21_AMOUNT_FCY_2YEAR;
	}
	public void setR21_AMOUNT_FCY_2YEAR(BigDecimal r21_AMOUNT_FCY_2YEAR) {
		R21_AMOUNT_FCY_2YEAR = r21_AMOUNT_FCY_2YEAR;
	}
	public BigDecimal getR21_ACCOUNTS_AED_3YEAR() {
		return R21_ACCOUNTS_AED_3YEAR;
	}
	public void setR21_ACCOUNTS_AED_3YEAR(BigDecimal r21_ACCOUNTS_AED_3YEAR) {
		R21_ACCOUNTS_AED_3YEAR = r21_ACCOUNTS_AED_3YEAR;
	}
	public BigDecimal getR21_AMOUNT_AED_3YEAR() {
		return R21_AMOUNT_AED_3YEAR;
	}
	public void setR21_AMOUNT_AED_3YEAR(BigDecimal r21_AMOUNT_AED_3YEAR) {
		R21_AMOUNT_AED_3YEAR = r21_AMOUNT_AED_3YEAR;
	}
	public BigDecimal getR21_ACCOUNTS_FCY_3YEAR() {
		return R21_ACCOUNTS_FCY_3YEAR;
	}
	public void setR21_ACCOUNTS_FCY_3YEAR(BigDecimal r21_ACCOUNTS_FCY_3YEAR) {
		R21_ACCOUNTS_FCY_3YEAR = r21_ACCOUNTS_FCY_3YEAR;
	}
	public BigDecimal getR21_AMOUNT_FCY_3YEAR() {
		return R21_AMOUNT_FCY_3YEAR;
	}
	public void setR21_AMOUNT_FCY_3YEAR(BigDecimal r21_AMOUNT_FCY_3YEAR) {
		R21_AMOUNT_FCY_3YEAR = r21_AMOUNT_FCY_3YEAR;
	}
	public BigDecimal getR21_ACCOUNTS_AED_5YEAR() {
		return R21_ACCOUNTS_AED_5YEAR;
	}
	public void setR21_ACCOUNTS_AED_5YEAR(BigDecimal r21_ACCOUNTS_AED_5YEAR) {
		R21_ACCOUNTS_AED_5YEAR = r21_ACCOUNTS_AED_5YEAR;
	}
	public BigDecimal getR21_AMOUNT_AED_5YEAR() {
		return R21_AMOUNT_AED_5YEAR;
	}
	public void setR21_AMOUNT_AED_5YEAR(BigDecimal r21_AMOUNT_AED_5YEAR) {
		R21_AMOUNT_AED_5YEAR = r21_AMOUNT_AED_5YEAR;
	}
	public BigDecimal getR21_ACCOUNTS_FCY_5YEAR() {
		return R21_ACCOUNTS_FCY_5YEAR;
	}
	public void setR21_ACCOUNTS_FCY_5YEAR(BigDecimal r21_ACCOUNTS_FCY_5YEAR) {
		R21_ACCOUNTS_FCY_5YEAR = r21_ACCOUNTS_FCY_5YEAR;
	}
	public BigDecimal getR21_AMOUNT_FCY_5YEAR() {
		return R21_AMOUNT_FCY_5YEAR;
	}
	public void setR21_AMOUNT_FCY_5YEAR(BigDecimal r21_AMOUNT_FCY_5YEAR) {
		R21_AMOUNT_FCY_5YEAR = r21_AMOUNT_FCY_5YEAR;
	}
	public BigDecimal getR21_ACCOUNTS_AED_ABOVE() {
		return R21_ACCOUNTS_AED_ABOVE;
	}
	public void setR21_ACCOUNTS_AED_ABOVE(BigDecimal r21_ACCOUNTS_AED_ABOVE) {
		R21_ACCOUNTS_AED_ABOVE = r21_ACCOUNTS_AED_ABOVE;
	}
	public BigDecimal getR21_AMOUNT_AED_ABOVE() {
		return R21_AMOUNT_AED_ABOVE;
	}
	public void setR21_AMOUNT_AED_ABOVE(BigDecimal r21_AMOUNT_AED_ABOVE) {
		R21_AMOUNT_AED_ABOVE = r21_AMOUNT_AED_ABOVE;
	}
	public BigDecimal getR21_ACCOUNTS_FCY_ABOVE() {
		return R21_ACCOUNTS_FCY_ABOVE;
	}
	public void setR21_ACCOUNTS_FCY_ABOVE(BigDecimal r21_ACCOUNTS_FCY_ABOVE) {
		R21_ACCOUNTS_FCY_ABOVE = r21_ACCOUNTS_FCY_ABOVE;
	}
	public BigDecimal getR21_AMOUNT_FCY_ABOVE() {
		return R21_AMOUNT_FCY_ABOVE;
	}
	public void setR21_AMOUNT_FCY_ABOVE(BigDecimal r21_AMOUNT_FCY_ABOVE) {
		R21_AMOUNT_FCY_ABOVE = r21_AMOUNT_FCY_ABOVE;
	}
	public BigDecimal getR21_ACCOUNTS_AED_INACTIVE() {
		return R21_ACCOUNTS_AED_INACTIVE;
	}
	public void setR21_ACCOUNTS_AED_INACTIVE(BigDecimal r21_ACCOUNTS_AED_INACTIVE) {
		R21_ACCOUNTS_AED_INACTIVE = r21_ACCOUNTS_AED_INACTIVE;
	}
	public BigDecimal getR21_AMOUNT_AED_INACTIVE() {
		return R21_AMOUNT_AED_INACTIVE;
	}
	public void setR21_AMOUNT_AED_INACTIVE(BigDecimal r21_AMOUNT_AED_INACTIVE) {
		R21_AMOUNT_AED_INACTIVE = r21_AMOUNT_AED_INACTIVE;
	}
	public BigDecimal getR21_ACCOUNTS_FCY_INACTIVE() {
		return R21_ACCOUNTS_FCY_INACTIVE;
	}
	public void setR21_ACCOUNTS_FCY_INACTIVE(BigDecimal r21_ACCOUNTS_FCY_INACTIVE) {
		R21_ACCOUNTS_FCY_INACTIVE = r21_ACCOUNTS_FCY_INACTIVE;
	}
	public BigDecimal getR21_AMOUNT_FCY_INACTIVE() {
		return R21_AMOUNT_FCY_INACTIVE;
	}
	public void setR21_AMOUNT_FCY_INACTIVE(BigDecimal r21_AMOUNT_FCY_INACTIVE) {
		R21_AMOUNT_FCY_INACTIVE = r21_AMOUNT_FCY_INACTIVE;
	}
	public BigDecimal getR21_ACCOUNTS_AED_DORMANT() {
		return R21_ACCOUNTS_AED_DORMANT;
	}
	public void setR21_ACCOUNTS_AED_DORMANT(BigDecimal r21_ACCOUNTS_AED_DORMANT) {
		R21_ACCOUNTS_AED_DORMANT = r21_ACCOUNTS_AED_DORMANT;
	}
	public BigDecimal getR21_AMOUNT_AED_DORMANT() {
		return R21_AMOUNT_AED_DORMANT;
	}
	public void setR21_AMOUNT_AED_DORMANT(BigDecimal r21_AMOUNT_AED_DORMANT) {
		R21_AMOUNT_AED_DORMANT = r21_AMOUNT_AED_DORMANT;
	}
	public BigDecimal getR21_ACCOUNTS_FCY_DORMANT() {
		return R21_ACCOUNTS_FCY_DORMANT;
	}
	public void setR21_ACCOUNTS_FCY_DORMANT(BigDecimal r21_ACCOUNTS_FCY_DORMANT) {
		R21_ACCOUNTS_FCY_DORMANT = r21_ACCOUNTS_FCY_DORMANT;
	}
	public BigDecimal getR21_AMOUNT_FCY_DORMANT() {
		return R21_AMOUNT_FCY_DORMANT;
	}
	public void setR21_AMOUNT_FCY_DORMANT(BigDecimal r21_AMOUNT_FCY_DORMANT) {
		R21_AMOUNT_FCY_DORMANT = r21_AMOUNT_FCY_DORMANT;
	}
	public String getR22_S_NO() {
		return R22_S_NO;
	}
	public void setR22_S_NO(String r22_S_NO) {
		R22_S_NO = r22_S_NO;
	}
	public String getR22_REGULATIONS() {
		return R22_REGULATIONS;
	}
	public void setR22_REGULATIONS(String r22_REGULATIONS) {
		R22_REGULATIONS = r22_REGULATIONS;
	}
	public String getR22_DORMANT() {
		return R22_DORMANT;
	}
	public void setR22_DORMANT(String r22_DORMANT) {
		R22_DORMANT = r22_DORMANT;
	}
	public BigDecimal getR22_ACCOUNTS_AED_1YEAR() {
		return R22_ACCOUNTS_AED_1YEAR;
	}
	public void setR22_ACCOUNTS_AED_1YEAR(BigDecimal r22_ACCOUNTS_AED_1YEAR) {
		R22_ACCOUNTS_AED_1YEAR = r22_ACCOUNTS_AED_1YEAR;
	}
	public BigDecimal getR22_AMOUNT_AED_1YEAR() {
		return R22_AMOUNT_AED_1YEAR;
	}
	public void setR22_AMOUNT_AED_1YEAR(BigDecimal r22_AMOUNT_AED_1YEAR) {
		R22_AMOUNT_AED_1YEAR = r22_AMOUNT_AED_1YEAR;
	}
	public BigDecimal getR22_ACCOUNTS_FCY_1YEAR() {
		return R22_ACCOUNTS_FCY_1YEAR;
	}
	public void setR22_ACCOUNTS_FCY_1YEAR(BigDecimal r22_ACCOUNTS_FCY_1YEAR) {
		R22_ACCOUNTS_FCY_1YEAR = r22_ACCOUNTS_FCY_1YEAR;
	}
	public BigDecimal getR22_AMOUNT_FCY_1YEAR() {
		return R22_AMOUNT_FCY_1YEAR;
	}
	public void setR22_AMOUNT_FCY_1YEAR(BigDecimal r22_AMOUNT_FCY_1YEAR) {
		R22_AMOUNT_FCY_1YEAR = r22_AMOUNT_FCY_1YEAR;
	}
	public BigDecimal getR22_ACCOUNTS_AED_2YEAR() {
		return R22_ACCOUNTS_AED_2YEAR;
	}
	public void setR22_ACCOUNTS_AED_2YEAR(BigDecimal r22_ACCOUNTS_AED_2YEAR) {
		R22_ACCOUNTS_AED_2YEAR = r22_ACCOUNTS_AED_2YEAR;
	}
	public BigDecimal getR22_AMOUNT_AED_2YEAR() {
		return R22_AMOUNT_AED_2YEAR;
	}
	public void setR22_AMOUNT_AED_2YEAR(BigDecimal r22_AMOUNT_AED_2YEAR) {
		R22_AMOUNT_AED_2YEAR = r22_AMOUNT_AED_2YEAR;
	}
	public BigDecimal getR22_ACCOUNTS_FCY_2YEAR() {
		return R22_ACCOUNTS_FCY_2YEAR;
	}
	public void setR22_ACCOUNTS_FCY_2YEAR(BigDecimal r22_ACCOUNTS_FCY_2YEAR) {
		R22_ACCOUNTS_FCY_2YEAR = r22_ACCOUNTS_FCY_2YEAR;
	}
	public BigDecimal getR22_AMOUNT_FCY_2YEAR() {
		return R22_AMOUNT_FCY_2YEAR;
	}
	public void setR22_AMOUNT_FCY_2YEAR(BigDecimal r22_AMOUNT_FCY_2YEAR) {
		R22_AMOUNT_FCY_2YEAR = r22_AMOUNT_FCY_2YEAR;
	}
	public BigDecimal getR22_ACCOUNTS_AED_3YEAR() {
		return R22_ACCOUNTS_AED_3YEAR;
	}
	public void setR22_ACCOUNTS_AED_3YEAR(BigDecimal r22_ACCOUNTS_AED_3YEAR) {
		R22_ACCOUNTS_AED_3YEAR = r22_ACCOUNTS_AED_3YEAR;
	}
	public BigDecimal getR22_AMOUNT_AED_3YEAR() {
		return R22_AMOUNT_AED_3YEAR;
	}
	public void setR22_AMOUNT_AED_3YEAR(BigDecimal r22_AMOUNT_AED_3YEAR) {
		R22_AMOUNT_AED_3YEAR = r22_AMOUNT_AED_3YEAR;
	}
	public BigDecimal getR22_ACCOUNTS_FCY_3YEAR() {
		return R22_ACCOUNTS_FCY_3YEAR;
	}
	public void setR22_ACCOUNTS_FCY_3YEAR(BigDecimal r22_ACCOUNTS_FCY_3YEAR) {
		R22_ACCOUNTS_FCY_3YEAR = r22_ACCOUNTS_FCY_3YEAR;
	}
	public BigDecimal getR22_AMOUNT_FCY_3YEAR() {
		return R22_AMOUNT_FCY_3YEAR;
	}
	public void setR22_AMOUNT_FCY_3YEAR(BigDecimal r22_AMOUNT_FCY_3YEAR) {
		R22_AMOUNT_FCY_3YEAR = r22_AMOUNT_FCY_3YEAR;
	}
	public BigDecimal getR22_ACCOUNTS_AED_5YEAR() {
		return R22_ACCOUNTS_AED_5YEAR;
	}
	public void setR22_ACCOUNTS_AED_5YEAR(BigDecimal r22_ACCOUNTS_AED_5YEAR) {
		R22_ACCOUNTS_AED_5YEAR = r22_ACCOUNTS_AED_5YEAR;
	}
	public BigDecimal getR22_AMOUNT_AED_5YEAR() {
		return R22_AMOUNT_AED_5YEAR;
	}
	public void setR22_AMOUNT_AED_5YEAR(BigDecimal r22_AMOUNT_AED_5YEAR) {
		R22_AMOUNT_AED_5YEAR = r22_AMOUNT_AED_5YEAR;
	}
	public BigDecimal getR22_ACCOUNTS_FCY_5YEAR() {
		return R22_ACCOUNTS_FCY_5YEAR;
	}
	public void setR22_ACCOUNTS_FCY_5YEAR(BigDecimal r22_ACCOUNTS_FCY_5YEAR) {
		R22_ACCOUNTS_FCY_5YEAR = r22_ACCOUNTS_FCY_5YEAR;
	}
	public BigDecimal getR22_AMOUNT_FCY_5YEAR() {
		return R22_AMOUNT_FCY_5YEAR;
	}
	public void setR22_AMOUNT_FCY_5YEAR(BigDecimal r22_AMOUNT_FCY_5YEAR) {
		R22_AMOUNT_FCY_5YEAR = r22_AMOUNT_FCY_5YEAR;
	}
	public BigDecimal getR22_ACCOUNTS_AED_ABOVE() {
		return R22_ACCOUNTS_AED_ABOVE;
	}
	public void setR22_ACCOUNTS_AED_ABOVE(BigDecimal r22_ACCOUNTS_AED_ABOVE) {
		R22_ACCOUNTS_AED_ABOVE = r22_ACCOUNTS_AED_ABOVE;
	}
	public BigDecimal getR22_AMOUNT_AED_ABOVE() {
		return R22_AMOUNT_AED_ABOVE;
	}
	public void setR22_AMOUNT_AED_ABOVE(BigDecimal r22_AMOUNT_AED_ABOVE) {
		R22_AMOUNT_AED_ABOVE = r22_AMOUNT_AED_ABOVE;
	}
	public BigDecimal getR22_ACCOUNTS_FCY_ABOVE() {
		return R22_ACCOUNTS_FCY_ABOVE;
	}
	public void setR22_ACCOUNTS_FCY_ABOVE(BigDecimal r22_ACCOUNTS_FCY_ABOVE) {
		R22_ACCOUNTS_FCY_ABOVE = r22_ACCOUNTS_FCY_ABOVE;
	}
	public BigDecimal getR22_AMOUNT_FCY_ABOVE() {
		return R22_AMOUNT_FCY_ABOVE;
	}
	public void setR22_AMOUNT_FCY_ABOVE(BigDecimal r22_AMOUNT_FCY_ABOVE) {
		R22_AMOUNT_FCY_ABOVE = r22_AMOUNT_FCY_ABOVE;
	}
	public BigDecimal getR22_ACCOUNTS_AED_INACTIVE() {
		return R22_ACCOUNTS_AED_INACTIVE;
	}
	public void setR22_ACCOUNTS_AED_INACTIVE(BigDecimal r22_ACCOUNTS_AED_INACTIVE) {
		R22_ACCOUNTS_AED_INACTIVE = r22_ACCOUNTS_AED_INACTIVE;
	}
	public BigDecimal getR22_AMOUNT_AED_INACTIVE() {
		return R22_AMOUNT_AED_INACTIVE;
	}
	public void setR22_AMOUNT_AED_INACTIVE(BigDecimal r22_AMOUNT_AED_INACTIVE) {
		R22_AMOUNT_AED_INACTIVE = r22_AMOUNT_AED_INACTIVE;
	}
	public BigDecimal getR22_ACCOUNTS_FCY_INACTIVE() {
		return R22_ACCOUNTS_FCY_INACTIVE;
	}
	public void setR22_ACCOUNTS_FCY_INACTIVE(BigDecimal r22_ACCOUNTS_FCY_INACTIVE) {
		R22_ACCOUNTS_FCY_INACTIVE = r22_ACCOUNTS_FCY_INACTIVE;
	}
	public BigDecimal getR22_AMOUNT_FCY_INACTIVE() {
		return R22_AMOUNT_FCY_INACTIVE;
	}
	public void setR22_AMOUNT_FCY_INACTIVE(BigDecimal r22_AMOUNT_FCY_INACTIVE) {
		R22_AMOUNT_FCY_INACTIVE = r22_AMOUNT_FCY_INACTIVE;
	}
	public BigDecimal getR22_ACCOUNTS_AED_DORMANT() {
		return R22_ACCOUNTS_AED_DORMANT;
	}
	public void setR22_ACCOUNTS_AED_DORMANT(BigDecimal r22_ACCOUNTS_AED_DORMANT) {
		R22_ACCOUNTS_AED_DORMANT = r22_ACCOUNTS_AED_DORMANT;
	}
	public BigDecimal getR22_AMOUNT_AED_DORMANT() {
		return R22_AMOUNT_AED_DORMANT;
	}
	public void setR22_AMOUNT_AED_DORMANT(BigDecimal r22_AMOUNT_AED_DORMANT) {
		R22_AMOUNT_AED_DORMANT = r22_AMOUNT_AED_DORMANT;
	}
	public BigDecimal getR22_ACCOUNTS_FCY_DORMANT() {
		return R22_ACCOUNTS_FCY_DORMANT;
	}
	public void setR22_ACCOUNTS_FCY_DORMANT(BigDecimal r22_ACCOUNTS_FCY_DORMANT) {
		R22_ACCOUNTS_FCY_DORMANT = r22_ACCOUNTS_FCY_DORMANT;
	}
	public BigDecimal getR22_AMOUNT_FCY_DORMANT() {
		return R22_AMOUNT_FCY_DORMANT;
	}
	public void setR22_AMOUNT_FCY_DORMANT(BigDecimal r22_AMOUNT_FCY_DORMANT) {
		R22_AMOUNT_FCY_DORMANT = r22_AMOUNT_FCY_DORMANT;
	}
	public String getR23_S_NO() {
		return R23_S_NO;
	}
	public void setR23_S_NO(String r23_S_NO) {
		R23_S_NO = r23_S_NO;
	}
	public String getR23_REGULATIONS() {
		return R23_REGULATIONS;
	}
	public void setR23_REGULATIONS(String r23_REGULATIONS) {
		R23_REGULATIONS = r23_REGULATIONS;
	}
	public String getR23_DORMANT() {
		return R23_DORMANT;
	}
	public void setR23_DORMANT(String r23_DORMANT) {
		R23_DORMANT = r23_DORMANT;
	}
	public BigDecimal getR23_ACCOUNTS_AED_1YEAR() {
		return R23_ACCOUNTS_AED_1YEAR;
	}
	public void setR23_ACCOUNTS_AED_1YEAR(BigDecimal r23_ACCOUNTS_AED_1YEAR) {
		R23_ACCOUNTS_AED_1YEAR = r23_ACCOUNTS_AED_1YEAR;
	}
	public BigDecimal getR23_AMOUNT_AED_1YEAR() {
		return R23_AMOUNT_AED_1YEAR;
	}
	public void setR23_AMOUNT_AED_1YEAR(BigDecimal r23_AMOUNT_AED_1YEAR) {
		R23_AMOUNT_AED_1YEAR = r23_AMOUNT_AED_1YEAR;
	}
	public BigDecimal getR23_ACCOUNTS_FCY_1YEAR() {
		return R23_ACCOUNTS_FCY_1YEAR;
	}
	public void setR23_ACCOUNTS_FCY_1YEAR(BigDecimal r23_ACCOUNTS_FCY_1YEAR) {
		R23_ACCOUNTS_FCY_1YEAR = r23_ACCOUNTS_FCY_1YEAR;
	}
	public BigDecimal getR23_AMOUNT_FCY_1YEAR() {
		return R23_AMOUNT_FCY_1YEAR;
	}
	public void setR23_AMOUNT_FCY_1YEAR(BigDecimal r23_AMOUNT_FCY_1YEAR) {
		R23_AMOUNT_FCY_1YEAR = r23_AMOUNT_FCY_1YEAR;
	}
	public BigDecimal getR23_ACCOUNTS_AED_2YEAR() {
		return R23_ACCOUNTS_AED_2YEAR;
	}
	public void setR23_ACCOUNTS_AED_2YEAR(BigDecimal r23_ACCOUNTS_AED_2YEAR) {
		R23_ACCOUNTS_AED_2YEAR = r23_ACCOUNTS_AED_2YEAR;
	}
	public BigDecimal getR23_AMOUNT_AED_2YEAR() {
		return R23_AMOUNT_AED_2YEAR;
	}
	public void setR23_AMOUNT_AED_2YEAR(BigDecimal r23_AMOUNT_AED_2YEAR) {
		R23_AMOUNT_AED_2YEAR = r23_AMOUNT_AED_2YEAR;
	}
	public BigDecimal getR23_ACCOUNTS_FCY_2YEAR() {
		return R23_ACCOUNTS_FCY_2YEAR;
	}
	public void setR23_ACCOUNTS_FCY_2YEAR(BigDecimal r23_ACCOUNTS_FCY_2YEAR) {
		R23_ACCOUNTS_FCY_2YEAR = r23_ACCOUNTS_FCY_2YEAR;
	}
	public BigDecimal getR23_AMOUNT_FCY_2YEAR() {
		return R23_AMOUNT_FCY_2YEAR;
	}
	public void setR23_AMOUNT_FCY_2YEAR(BigDecimal r23_AMOUNT_FCY_2YEAR) {
		R23_AMOUNT_FCY_2YEAR = r23_AMOUNT_FCY_2YEAR;
	}
	public BigDecimal getR23_ACCOUNTS_AED_3YEAR() {
		return R23_ACCOUNTS_AED_3YEAR;
	}
	public void setR23_ACCOUNTS_AED_3YEAR(BigDecimal r23_ACCOUNTS_AED_3YEAR) {
		R23_ACCOUNTS_AED_3YEAR = r23_ACCOUNTS_AED_3YEAR;
	}
	public BigDecimal getR23_AMOUNT_AED_3YEAR() {
		return R23_AMOUNT_AED_3YEAR;
	}
	public void setR23_AMOUNT_AED_3YEAR(BigDecimal r23_AMOUNT_AED_3YEAR) {
		R23_AMOUNT_AED_3YEAR = r23_AMOUNT_AED_3YEAR;
	}
	public BigDecimal getR23_ACCOUNTS_FCY_3YEAR() {
		return R23_ACCOUNTS_FCY_3YEAR;
	}
	public void setR23_ACCOUNTS_FCY_3YEAR(BigDecimal r23_ACCOUNTS_FCY_3YEAR) {
		R23_ACCOUNTS_FCY_3YEAR = r23_ACCOUNTS_FCY_3YEAR;
	}
	public BigDecimal getR23_AMOUNT_FCY_3YEAR() {
		return R23_AMOUNT_FCY_3YEAR;
	}
	public void setR23_AMOUNT_FCY_3YEAR(BigDecimal r23_AMOUNT_FCY_3YEAR) {
		R23_AMOUNT_FCY_3YEAR = r23_AMOUNT_FCY_3YEAR;
	}
	public BigDecimal getR23_ACCOUNTS_AED_5YEAR() {
		return R23_ACCOUNTS_AED_5YEAR;
	}
	public void setR23_ACCOUNTS_AED_5YEAR(BigDecimal r23_ACCOUNTS_AED_5YEAR) {
		R23_ACCOUNTS_AED_5YEAR = r23_ACCOUNTS_AED_5YEAR;
	}
	public BigDecimal getR23_AMOUNT_AED_5YEAR() {
		return R23_AMOUNT_AED_5YEAR;
	}
	public void setR23_AMOUNT_AED_5YEAR(BigDecimal r23_AMOUNT_AED_5YEAR) {
		R23_AMOUNT_AED_5YEAR = r23_AMOUNT_AED_5YEAR;
	}
	public BigDecimal getR23_ACCOUNTS_FCY_5YEAR() {
		return R23_ACCOUNTS_FCY_5YEAR;
	}
	public void setR23_ACCOUNTS_FCY_5YEAR(BigDecimal r23_ACCOUNTS_FCY_5YEAR) {
		R23_ACCOUNTS_FCY_5YEAR = r23_ACCOUNTS_FCY_5YEAR;
	}
	public BigDecimal getR23_AMOUNT_FCY_5YEAR() {
		return R23_AMOUNT_FCY_5YEAR;
	}
	public void setR23_AMOUNT_FCY_5YEAR(BigDecimal r23_AMOUNT_FCY_5YEAR) {
		R23_AMOUNT_FCY_5YEAR = r23_AMOUNT_FCY_5YEAR;
	}
	public BigDecimal getR23_ACCOUNTS_AED_ABOVE() {
		return R23_ACCOUNTS_AED_ABOVE;
	}
	public void setR23_ACCOUNTS_AED_ABOVE(BigDecimal r23_ACCOUNTS_AED_ABOVE) {
		R23_ACCOUNTS_AED_ABOVE = r23_ACCOUNTS_AED_ABOVE;
	}
	public BigDecimal getR23_AMOUNT_AED_ABOVE() {
		return R23_AMOUNT_AED_ABOVE;
	}
	public void setR23_AMOUNT_AED_ABOVE(BigDecimal r23_AMOUNT_AED_ABOVE) {
		R23_AMOUNT_AED_ABOVE = r23_AMOUNT_AED_ABOVE;
	}
	public BigDecimal getR23_ACCOUNTS_FCY_ABOVE() {
		return R23_ACCOUNTS_FCY_ABOVE;
	}
	public void setR23_ACCOUNTS_FCY_ABOVE(BigDecimal r23_ACCOUNTS_FCY_ABOVE) {
		R23_ACCOUNTS_FCY_ABOVE = r23_ACCOUNTS_FCY_ABOVE;
	}
	public BigDecimal getR23_AMOUNT_FCY_ABOVE() {
		return R23_AMOUNT_FCY_ABOVE;
	}
	public void setR23_AMOUNT_FCY_ABOVE(BigDecimal r23_AMOUNT_FCY_ABOVE) {
		R23_AMOUNT_FCY_ABOVE = r23_AMOUNT_FCY_ABOVE;
	}
	public BigDecimal getR23_ACCOUNTS_AED_INACTIVE() {
		return R23_ACCOUNTS_AED_INACTIVE;
	}
	public void setR23_ACCOUNTS_AED_INACTIVE(BigDecimal r23_ACCOUNTS_AED_INACTIVE) {
		R23_ACCOUNTS_AED_INACTIVE = r23_ACCOUNTS_AED_INACTIVE;
	}
	public BigDecimal getR23_AMOUNT_AED_INACTIVE() {
		return R23_AMOUNT_AED_INACTIVE;
	}
	public void setR23_AMOUNT_AED_INACTIVE(BigDecimal r23_AMOUNT_AED_INACTIVE) {
		R23_AMOUNT_AED_INACTIVE = r23_AMOUNT_AED_INACTIVE;
	}
	public BigDecimal getR23_ACCOUNTS_FCY_INACTIVE() {
		return R23_ACCOUNTS_FCY_INACTIVE;
	}
	public void setR23_ACCOUNTS_FCY_INACTIVE(BigDecimal r23_ACCOUNTS_FCY_INACTIVE) {
		R23_ACCOUNTS_FCY_INACTIVE = r23_ACCOUNTS_FCY_INACTIVE;
	}
	public BigDecimal getR23_AMOUNT_FCY_INACTIVE() {
		return R23_AMOUNT_FCY_INACTIVE;
	}
	public void setR23_AMOUNT_FCY_INACTIVE(BigDecimal r23_AMOUNT_FCY_INACTIVE) {
		R23_AMOUNT_FCY_INACTIVE = r23_AMOUNT_FCY_INACTIVE;
	}
	public BigDecimal getR23_ACCOUNTS_AED_DORMANT() {
		return R23_ACCOUNTS_AED_DORMANT;
	}
	public void setR23_ACCOUNTS_AED_DORMANT(BigDecimal r23_ACCOUNTS_AED_DORMANT) {
		R23_ACCOUNTS_AED_DORMANT = r23_ACCOUNTS_AED_DORMANT;
	}
	public BigDecimal getR23_AMOUNT_AED_DORMANT() {
		return R23_AMOUNT_AED_DORMANT;
	}
	public void setR23_AMOUNT_AED_DORMANT(BigDecimal r23_AMOUNT_AED_DORMANT) {
		R23_AMOUNT_AED_DORMANT = r23_AMOUNT_AED_DORMANT;
	}
	public BigDecimal getR23_ACCOUNTS_FCY_DORMANT() {
		return R23_ACCOUNTS_FCY_DORMANT;
	}
	public void setR23_ACCOUNTS_FCY_DORMANT(BigDecimal r23_ACCOUNTS_FCY_DORMANT) {
		R23_ACCOUNTS_FCY_DORMANT = r23_ACCOUNTS_FCY_DORMANT;
	}
	public BigDecimal getR23_AMOUNT_FCY_DORMANT() {
		return R23_AMOUNT_FCY_DORMANT;
	}
	public void setR23_AMOUNT_FCY_DORMANT(BigDecimal r23_AMOUNT_FCY_DORMANT) {
		R23_AMOUNT_FCY_DORMANT = r23_AMOUNT_FCY_DORMANT;
	}
	public String getR24_S_NO() {
		return R24_S_NO;
	}
	public void setR24_S_NO(String r24_S_NO) {
		R24_S_NO = r24_S_NO;
	}
	public String getR24_REGULATIONS() {
		return R24_REGULATIONS;
	}
	public void setR24_REGULATIONS(String r24_REGULATIONS) {
		R24_REGULATIONS = r24_REGULATIONS;
	}
	public String getR24_DORMANT() {
		return R24_DORMANT;
	}
	public void setR24_DORMANT(String r24_DORMANT) {
		R24_DORMANT = r24_DORMANT;
	}
	public BigDecimal getR24_ACCOUNTS_AED_1YEAR() {
		return R24_ACCOUNTS_AED_1YEAR;
	}
	public void setR24_ACCOUNTS_AED_1YEAR(BigDecimal r24_ACCOUNTS_AED_1YEAR) {
		R24_ACCOUNTS_AED_1YEAR = r24_ACCOUNTS_AED_1YEAR;
	}
	public BigDecimal getR24_AMOUNT_AED_1YEAR() {
		return R24_AMOUNT_AED_1YEAR;
	}
	public void setR24_AMOUNT_AED_1YEAR(BigDecimal r24_AMOUNT_AED_1YEAR) {
		R24_AMOUNT_AED_1YEAR = r24_AMOUNT_AED_1YEAR;
	}
	public BigDecimal getR24_ACCOUNTS_FCY_1YEAR() {
		return R24_ACCOUNTS_FCY_1YEAR;
	}
	public void setR24_ACCOUNTS_FCY_1YEAR(BigDecimal r24_ACCOUNTS_FCY_1YEAR) {
		R24_ACCOUNTS_FCY_1YEAR = r24_ACCOUNTS_FCY_1YEAR;
	}
	public BigDecimal getR24_AMOUNT_FCY_1YEAR() {
		return R24_AMOUNT_FCY_1YEAR;
	}
	public void setR24_AMOUNT_FCY_1YEAR(BigDecimal r24_AMOUNT_FCY_1YEAR) {
		R24_AMOUNT_FCY_1YEAR = r24_AMOUNT_FCY_1YEAR;
	}
	public BigDecimal getR24_ACCOUNTS_AED_2YEAR() {
		return R24_ACCOUNTS_AED_2YEAR;
	}
	public void setR24_ACCOUNTS_AED_2YEAR(BigDecimal r24_ACCOUNTS_AED_2YEAR) {
		R24_ACCOUNTS_AED_2YEAR = r24_ACCOUNTS_AED_2YEAR;
	}
	public BigDecimal getR24_AMOUNT_AED_2YEAR() {
		return R24_AMOUNT_AED_2YEAR;
	}
	public void setR24_AMOUNT_AED_2YEAR(BigDecimal r24_AMOUNT_AED_2YEAR) {
		R24_AMOUNT_AED_2YEAR = r24_AMOUNT_AED_2YEAR;
	}
	public BigDecimal getR24_ACCOUNTS_FCY_2YEAR() {
		return R24_ACCOUNTS_FCY_2YEAR;
	}
	public void setR24_ACCOUNTS_FCY_2YEAR(BigDecimal r24_ACCOUNTS_FCY_2YEAR) {
		R24_ACCOUNTS_FCY_2YEAR = r24_ACCOUNTS_FCY_2YEAR;
	}
	public BigDecimal getR24_AMOUNT_FCY_2YEAR() {
		return R24_AMOUNT_FCY_2YEAR;
	}
	public void setR24_AMOUNT_FCY_2YEAR(BigDecimal r24_AMOUNT_FCY_2YEAR) {
		R24_AMOUNT_FCY_2YEAR = r24_AMOUNT_FCY_2YEAR;
	}
	public BigDecimal getR24_ACCOUNTS_AED_3YEAR() {
		return R24_ACCOUNTS_AED_3YEAR;
	}
	public void setR24_ACCOUNTS_AED_3YEAR(BigDecimal r24_ACCOUNTS_AED_3YEAR) {
		R24_ACCOUNTS_AED_3YEAR = r24_ACCOUNTS_AED_3YEAR;
	}
	public BigDecimal getR24_AMOUNT_AED_3YEAR() {
		return R24_AMOUNT_AED_3YEAR;
	}
	public void setR24_AMOUNT_AED_3YEAR(BigDecimal r24_AMOUNT_AED_3YEAR) {
		R24_AMOUNT_AED_3YEAR = r24_AMOUNT_AED_3YEAR;
	}
	public BigDecimal getR24_ACCOUNTS_FCY_3YEAR() {
		return R24_ACCOUNTS_FCY_3YEAR;
	}
	public void setR24_ACCOUNTS_FCY_3YEAR(BigDecimal r24_ACCOUNTS_FCY_3YEAR) {
		R24_ACCOUNTS_FCY_3YEAR = r24_ACCOUNTS_FCY_3YEAR;
	}
	public BigDecimal getR24_AMOUNT_FCY_3YEAR() {
		return R24_AMOUNT_FCY_3YEAR;
	}
	public void setR24_AMOUNT_FCY_3YEAR(BigDecimal r24_AMOUNT_FCY_3YEAR) {
		R24_AMOUNT_FCY_3YEAR = r24_AMOUNT_FCY_3YEAR;
	}
	public BigDecimal getR24_ACCOUNTS_AED_5YEAR() {
		return R24_ACCOUNTS_AED_5YEAR;
	}
	public void setR24_ACCOUNTS_AED_5YEAR(BigDecimal r24_ACCOUNTS_AED_5YEAR) {
		R24_ACCOUNTS_AED_5YEAR = r24_ACCOUNTS_AED_5YEAR;
	}
	public BigDecimal getR24_AMOUNT_AED_5YEAR() {
		return R24_AMOUNT_AED_5YEAR;
	}
	public void setR24_AMOUNT_AED_5YEAR(BigDecimal r24_AMOUNT_AED_5YEAR) {
		R24_AMOUNT_AED_5YEAR = r24_AMOUNT_AED_5YEAR;
	}
	public BigDecimal getR24_ACCOUNTS_FCY_5YEAR() {
		return R24_ACCOUNTS_FCY_5YEAR;
	}
	public void setR24_ACCOUNTS_FCY_5YEAR(BigDecimal r24_ACCOUNTS_FCY_5YEAR) {
		R24_ACCOUNTS_FCY_5YEAR = r24_ACCOUNTS_FCY_5YEAR;
	}
	public BigDecimal getR24_AMOUNT_FCY_5YEAR() {
		return R24_AMOUNT_FCY_5YEAR;
	}
	public void setR24_AMOUNT_FCY_5YEAR(BigDecimal r24_AMOUNT_FCY_5YEAR) {
		R24_AMOUNT_FCY_5YEAR = r24_AMOUNT_FCY_5YEAR;
	}
	public BigDecimal getR24_ACCOUNTS_AED_ABOVE() {
		return R24_ACCOUNTS_AED_ABOVE;
	}
	public void setR24_ACCOUNTS_AED_ABOVE(BigDecimal r24_ACCOUNTS_AED_ABOVE) {
		R24_ACCOUNTS_AED_ABOVE = r24_ACCOUNTS_AED_ABOVE;
	}
	public BigDecimal getR24_AMOUNT_AED_ABOVE() {
		return R24_AMOUNT_AED_ABOVE;
	}
	public void setR24_AMOUNT_AED_ABOVE(BigDecimal r24_AMOUNT_AED_ABOVE) {
		R24_AMOUNT_AED_ABOVE = r24_AMOUNT_AED_ABOVE;
	}
	public BigDecimal getR24_ACCOUNTS_FCY_ABOVE() {
		return R24_ACCOUNTS_FCY_ABOVE;
	}
	public void setR24_ACCOUNTS_FCY_ABOVE(BigDecimal r24_ACCOUNTS_FCY_ABOVE) {
		R24_ACCOUNTS_FCY_ABOVE = r24_ACCOUNTS_FCY_ABOVE;
	}
	public BigDecimal getR24_AMOUNT_FCY_ABOVE() {
		return R24_AMOUNT_FCY_ABOVE;
	}
	public void setR24_AMOUNT_FCY_ABOVE(BigDecimal r24_AMOUNT_FCY_ABOVE) {
		R24_AMOUNT_FCY_ABOVE = r24_AMOUNT_FCY_ABOVE;
	}
	public BigDecimal getR24_ACCOUNTS_AED_INACTIVE() {
		return R24_ACCOUNTS_AED_INACTIVE;
	}
	public void setR24_ACCOUNTS_AED_INACTIVE(BigDecimal r24_ACCOUNTS_AED_INACTIVE) {
		R24_ACCOUNTS_AED_INACTIVE = r24_ACCOUNTS_AED_INACTIVE;
	}
	public BigDecimal getR24_AMOUNT_AED_INACTIVE() {
		return R24_AMOUNT_AED_INACTIVE;
	}
	public void setR24_AMOUNT_AED_INACTIVE(BigDecimal r24_AMOUNT_AED_INACTIVE) {
		R24_AMOUNT_AED_INACTIVE = r24_AMOUNT_AED_INACTIVE;
	}
	public BigDecimal getR24_ACCOUNTS_FCY_INACTIVE() {
		return R24_ACCOUNTS_FCY_INACTIVE;
	}
	public void setR24_ACCOUNTS_FCY_INACTIVE(BigDecimal r24_ACCOUNTS_FCY_INACTIVE) {
		R24_ACCOUNTS_FCY_INACTIVE = r24_ACCOUNTS_FCY_INACTIVE;
	}
	public BigDecimal getR24_AMOUNT_FCY_INACTIVE() {
		return R24_AMOUNT_FCY_INACTIVE;
	}
	public void setR24_AMOUNT_FCY_INACTIVE(BigDecimal r24_AMOUNT_FCY_INACTIVE) {
		R24_AMOUNT_FCY_INACTIVE = r24_AMOUNT_FCY_INACTIVE;
	}
	public BigDecimal getR24_ACCOUNTS_AED_DORMANT() {
		return R24_ACCOUNTS_AED_DORMANT;
	}
	public void setR24_ACCOUNTS_AED_DORMANT(BigDecimal r24_ACCOUNTS_AED_DORMANT) {
		R24_ACCOUNTS_AED_DORMANT = r24_ACCOUNTS_AED_DORMANT;
	}
	public BigDecimal getR24_AMOUNT_AED_DORMANT() {
		return R24_AMOUNT_AED_DORMANT;
	}
	public void setR24_AMOUNT_AED_DORMANT(BigDecimal r24_AMOUNT_AED_DORMANT) {
		R24_AMOUNT_AED_DORMANT = r24_AMOUNT_AED_DORMANT;
	}
	public BigDecimal getR24_ACCOUNTS_FCY_DORMANT() {
		return R24_ACCOUNTS_FCY_DORMANT;
	}
	public void setR24_ACCOUNTS_FCY_DORMANT(BigDecimal r24_ACCOUNTS_FCY_DORMANT) {
		R24_ACCOUNTS_FCY_DORMANT = r24_ACCOUNTS_FCY_DORMANT;
	}
	public BigDecimal getR24_AMOUNT_FCY_DORMANT() {
		return R24_AMOUNT_FCY_DORMANT;
	}
	public void setR24_AMOUNT_FCY_DORMANT(BigDecimal r24_AMOUNT_FCY_DORMANT) {
		R24_AMOUNT_FCY_DORMANT = r24_AMOUNT_FCY_DORMANT;
	}
	public String getR25_S_NO() {
		return R25_S_NO;
	}
	public void setR25_S_NO(String r25_S_NO) {
		R25_S_NO = r25_S_NO;
	}
	public String getR25_REGULATIONS() {
		return R25_REGULATIONS;
	}
	public void setR25_REGULATIONS(String r25_REGULATIONS) {
		R25_REGULATIONS = r25_REGULATIONS;
	}
	public String getR25_DORMANT() {
		return R25_DORMANT;
	}
	public void setR25_DORMANT(String r25_DORMANT) {
		R25_DORMANT = r25_DORMANT;
	}
	public BigDecimal getR25_ACCOUNTS_AED_1YEAR() {
		return R25_ACCOUNTS_AED_1YEAR;
	}
	public void setR25_ACCOUNTS_AED_1YEAR(BigDecimal r25_ACCOUNTS_AED_1YEAR) {
		R25_ACCOUNTS_AED_1YEAR = r25_ACCOUNTS_AED_1YEAR;
	}
	public BigDecimal getR25_AMOUNT_AED_1YEAR() {
		return R25_AMOUNT_AED_1YEAR;
	}
	public void setR25_AMOUNT_AED_1YEAR(BigDecimal r25_AMOUNT_AED_1YEAR) {
		R25_AMOUNT_AED_1YEAR = r25_AMOUNT_AED_1YEAR;
	}
	public BigDecimal getR25_ACCOUNTS_FCY_1YEAR() {
		return R25_ACCOUNTS_FCY_1YEAR;
	}
	public void setR25_ACCOUNTS_FCY_1YEAR(BigDecimal r25_ACCOUNTS_FCY_1YEAR) {
		R25_ACCOUNTS_FCY_1YEAR = r25_ACCOUNTS_FCY_1YEAR;
	}
	public BigDecimal getR25_AMOUNT_FCY_1YEAR() {
		return R25_AMOUNT_FCY_1YEAR;
	}
	public void setR25_AMOUNT_FCY_1YEAR(BigDecimal r25_AMOUNT_FCY_1YEAR) {
		R25_AMOUNT_FCY_1YEAR = r25_AMOUNT_FCY_1YEAR;
	}
	public BigDecimal getR25_ACCOUNTS_AED_2YEAR() {
		return R25_ACCOUNTS_AED_2YEAR;
	}
	public void setR25_ACCOUNTS_AED_2YEAR(BigDecimal r25_ACCOUNTS_AED_2YEAR) {
		R25_ACCOUNTS_AED_2YEAR = r25_ACCOUNTS_AED_2YEAR;
	}
	public BigDecimal getR25_AMOUNT_AED_2YEAR() {
		return R25_AMOUNT_AED_2YEAR;
	}
	public void setR25_AMOUNT_AED_2YEAR(BigDecimal r25_AMOUNT_AED_2YEAR) {
		R25_AMOUNT_AED_2YEAR = r25_AMOUNT_AED_2YEAR;
	}
	public BigDecimal getR25_ACCOUNTS_FCY_2YEAR() {
		return R25_ACCOUNTS_FCY_2YEAR;
	}
	public void setR25_ACCOUNTS_FCY_2YEAR(BigDecimal r25_ACCOUNTS_FCY_2YEAR) {
		R25_ACCOUNTS_FCY_2YEAR = r25_ACCOUNTS_FCY_2YEAR;
	}
	public BigDecimal getR25_AMOUNT_FCY_2YEAR() {
		return R25_AMOUNT_FCY_2YEAR;
	}
	public void setR25_AMOUNT_FCY_2YEAR(BigDecimal r25_AMOUNT_FCY_2YEAR) {
		R25_AMOUNT_FCY_2YEAR = r25_AMOUNT_FCY_2YEAR;
	}
	public BigDecimal getR25_ACCOUNTS_AED_3YEAR() {
		return R25_ACCOUNTS_AED_3YEAR;
	}
	public void setR25_ACCOUNTS_AED_3YEAR(BigDecimal r25_ACCOUNTS_AED_3YEAR) {
		R25_ACCOUNTS_AED_3YEAR = r25_ACCOUNTS_AED_3YEAR;
	}
	public BigDecimal getR25_AMOUNT_AED_3YEAR() {
		return R25_AMOUNT_AED_3YEAR;
	}
	public void setR25_AMOUNT_AED_3YEAR(BigDecimal r25_AMOUNT_AED_3YEAR) {
		R25_AMOUNT_AED_3YEAR = r25_AMOUNT_AED_3YEAR;
	}
	public BigDecimal getR25_ACCOUNTS_FCY_3YEAR() {
		return R25_ACCOUNTS_FCY_3YEAR;
	}
	public void setR25_ACCOUNTS_FCY_3YEAR(BigDecimal r25_ACCOUNTS_FCY_3YEAR) {
		R25_ACCOUNTS_FCY_3YEAR = r25_ACCOUNTS_FCY_3YEAR;
	}
	public BigDecimal getR25_AMOUNT_FCY_3YEAR() {
		return R25_AMOUNT_FCY_3YEAR;
	}
	public void setR25_AMOUNT_FCY_3YEAR(BigDecimal r25_AMOUNT_FCY_3YEAR) {
		R25_AMOUNT_FCY_3YEAR = r25_AMOUNT_FCY_3YEAR;
	}
	public BigDecimal getR25_ACCOUNTS_AED_5YEAR() {
		return R25_ACCOUNTS_AED_5YEAR;
	}
	public void setR25_ACCOUNTS_AED_5YEAR(BigDecimal r25_ACCOUNTS_AED_5YEAR) {
		R25_ACCOUNTS_AED_5YEAR = r25_ACCOUNTS_AED_5YEAR;
	}
	public BigDecimal getR25_AMOUNT_AED_5YEAR() {
		return R25_AMOUNT_AED_5YEAR;
	}
	public void setR25_AMOUNT_AED_5YEAR(BigDecimal r25_AMOUNT_AED_5YEAR) {
		R25_AMOUNT_AED_5YEAR = r25_AMOUNT_AED_5YEAR;
	}
	public BigDecimal getR25_ACCOUNTS_FCY_5YEAR() {
		return R25_ACCOUNTS_FCY_5YEAR;
	}
	public void setR25_ACCOUNTS_FCY_5YEAR(BigDecimal r25_ACCOUNTS_FCY_5YEAR) {
		R25_ACCOUNTS_FCY_5YEAR = r25_ACCOUNTS_FCY_5YEAR;
	}
	public BigDecimal getR25_AMOUNT_FCY_5YEAR() {
		return R25_AMOUNT_FCY_5YEAR;
	}
	public void setR25_AMOUNT_FCY_5YEAR(BigDecimal r25_AMOUNT_FCY_5YEAR) {
		R25_AMOUNT_FCY_5YEAR = r25_AMOUNT_FCY_5YEAR;
	}
	public BigDecimal getR25_ACCOUNTS_AED_ABOVE() {
		return R25_ACCOUNTS_AED_ABOVE;
	}
	public void setR25_ACCOUNTS_AED_ABOVE(BigDecimal r25_ACCOUNTS_AED_ABOVE) {
		R25_ACCOUNTS_AED_ABOVE = r25_ACCOUNTS_AED_ABOVE;
	}
	public BigDecimal getR25_AMOUNT_AED_ABOVE() {
		return R25_AMOUNT_AED_ABOVE;
	}
	public void setR25_AMOUNT_AED_ABOVE(BigDecimal r25_AMOUNT_AED_ABOVE) {
		R25_AMOUNT_AED_ABOVE = r25_AMOUNT_AED_ABOVE;
	}
	public BigDecimal getR25_ACCOUNTS_FCY_ABOVE() {
		return R25_ACCOUNTS_FCY_ABOVE;
	}
	public void setR25_ACCOUNTS_FCY_ABOVE(BigDecimal r25_ACCOUNTS_FCY_ABOVE) {
		R25_ACCOUNTS_FCY_ABOVE = r25_ACCOUNTS_FCY_ABOVE;
	}
	public BigDecimal getR25_AMOUNT_FCY_ABOVE() {
		return R25_AMOUNT_FCY_ABOVE;
	}
	public void setR25_AMOUNT_FCY_ABOVE(BigDecimal r25_AMOUNT_FCY_ABOVE) {
		R25_AMOUNT_FCY_ABOVE = r25_AMOUNT_FCY_ABOVE;
	}
	public BigDecimal getR25_ACCOUNTS_AED_INACTIVE() {
		return R25_ACCOUNTS_AED_INACTIVE;
	}
	public void setR25_ACCOUNTS_AED_INACTIVE(BigDecimal r25_ACCOUNTS_AED_INACTIVE) {
		R25_ACCOUNTS_AED_INACTIVE = r25_ACCOUNTS_AED_INACTIVE;
	}
	public BigDecimal getR25_AMOUNT_AED_INACTIVE() {
		return R25_AMOUNT_AED_INACTIVE;
	}
	public void setR25_AMOUNT_AED_INACTIVE(BigDecimal r25_AMOUNT_AED_INACTIVE) {
		R25_AMOUNT_AED_INACTIVE = r25_AMOUNT_AED_INACTIVE;
	}
	public BigDecimal getR25_ACCOUNTS_FCY_INACTIVE() {
		return R25_ACCOUNTS_FCY_INACTIVE;
	}
	public void setR25_ACCOUNTS_FCY_INACTIVE(BigDecimal r25_ACCOUNTS_FCY_INACTIVE) {
		R25_ACCOUNTS_FCY_INACTIVE = r25_ACCOUNTS_FCY_INACTIVE;
	}
	public BigDecimal getR25_AMOUNT_FCY_INACTIVE() {
		return R25_AMOUNT_FCY_INACTIVE;
	}
	public void setR25_AMOUNT_FCY_INACTIVE(BigDecimal r25_AMOUNT_FCY_INACTIVE) {
		R25_AMOUNT_FCY_INACTIVE = r25_AMOUNT_FCY_INACTIVE;
	}
	public BigDecimal getR25_ACCOUNTS_AED_DORMANT() {
		return R25_ACCOUNTS_AED_DORMANT;
	}
	public void setR25_ACCOUNTS_AED_DORMANT(BigDecimal r25_ACCOUNTS_AED_DORMANT) {
		R25_ACCOUNTS_AED_DORMANT = r25_ACCOUNTS_AED_DORMANT;
	}
	public BigDecimal getR25_AMOUNT_AED_DORMANT() {
		return R25_AMOUNT_AED_DORMANT;
	}
	public void setR25_AMOUNT_AED_DORMANT(BigDecimal r25_AMOUNT_AED_DORMANT) {
		R25_AMOUNT_AED_DORMANT = r25_AMOUNT_AED_DORMANT;
	}
	public BigDecimal getR25_ACCOUNTS_FCY_DORMANT() {
		return R25_ACCOUNTS_FCY_DORMANT;
	}
	public void setR25_ACCOUNTS_FCY_DORMANT(BigDecimal r25_ACCOUNTS_FCY_DORMANT) {
		R25_ACCOUNTS_FCY_DORMANT = r25_ACCOUNTS_FCY_DORMANT;
	}
	public BigDecimal getR25_AMOUNT_FCY_DORMANT() {
		return R25_AMOUNT_FCY_DORMANT;
	}
	public void setR25_AMOUNT_FCY_DORMANT(BigDecimal r25_AMOUNT_FCY_DORMANT) {
		R25_AMOUNT_FCY_DORMANT = r25_AMOUNT_FCY_DORMANT;
	}
	public String getR26_S_NO() {
		return R26_S_NO;
	}
	public void setR26_S_NO(String r26_S_NO) {
		R26_S_NO = r26_S_NO;
	}
	public String getR26_REGULATIONS() {
		return R26_REGULATIONS;
	}
	public void setR26_REGULATIONS(String r26_REGULATIONS) {
		R26_REGULATIONS = r26_REGULATIONS;
	}
	public String getR26_DORMANT() {
		return R26_DORMANT;
	}
	public void setR26_DORMANT(String r26_DORMANT) {
		R26_DORMANT = r26_DORMANT;
	}
	public BigDecimal getR26_ACCOUNTS_AED_1YEAR() {
		return R26_ACCOUNTS_AED_1YEAR;
	}
	public void setR26_ACCOUNTS_AED_1YEAR(BigDecimal r26_ACCOUNTS_AED_1YEAR) {
		R26_ACCOUNTS_AED_1YEAR = r26_ACCOUNTS_AED_1YEAR;
	}
	public BigDecimal getR26_AMOUNT_AED_1YEAR() {
		return R26_AMOUNT_AED_1YEAR;
	}
	public void setR26_AMOUNT_AED_1YEAR(BigDecimal r26_AMOUNT_AED_1YEAR) {
		R26_AMOUNT_AED_1YEAR = r26_AMOUNT_AED_1YEAR;
	}
	public BigDecimal getR26_ACCOUNTS_FCY_1YEAR() {
		return R26_ACCOUNTS_FCY_1YEAR;
	}
	public void setR26_ACCOUNTS_FCY_1YEAR(BigDecimal r26_ACCOUNTS_FCY_1YEAR) {
		R26_ACCOUNTS_FCY_1YEAR = r26_ACCOUNTS_FCY_1YEAR;
	}
	public BigDecimal getR26_AMOUNT_FCY_1YEAR() {
		return R26_AMOUNT_FCY_1YEAR;
	}
	public void setR26_AMOUNT_FCY_1YEAR(BigDecimal r26_AMOUNT_FCY_1YEAR) {
		R26_AMOUNT_FCY_1YEAR = r26_AMOUNT_FCY_1YEAR;
	}
	public BigDecimal getR26_ACCOUNTS_AED_2YEAR() {
		return R26_ACCOUNTS_AED_2YEAR;
	}
	public void setR26_ACCOUNTS_AED_2YEAR(BigDecimal r26_ACCOUNTS_AED_2YEAR) {
		R26_ACCOUNTS_AED_2YEAR = r26_ACCOUNTS_AED_2YEAR;
	}
	public BigDecimal getR26_AMOUNT_AED_2YEAR() {
		return R26_AMOUNT_AED_2YEAR;
	}
	public void setR26_AMOUNT_AED_2YEAR(BigDecimal r26_AMOUNT_AED_2YEAR) {
		R26_AMOUNT_AED_2YEAR = r26_AMOUNT_AED_2YEAR;
	}
	public BigDecimal getR26_ACCOUNTS_FCY_2YEAR() {
		return R26_ACCOUNTS_FCY_2YEAR;
	}
	public void setR26_ACCOUNTS_FCY_2YEAR(BigDecimal r26_ACCOUNTS_FCY_2YEAR) {
		R26_ACCOUNTS_FCY_2YEAR = r26_ACCOUNTS_FCY_2YEAR;
	}
	public BigDecimal getR26_AMOUNT_FCY_2YEAR() {
		return R26_AMOUNT_FCY_2YEAR;
	}
	public void setR26_AMOUNT_FCY_2YEAR(BigDecimal r26_AMOUNT_FCY_2YEAR) {
		R26_AMOUNT_FCY_2YEAR = r26_AMOUNT_FCY_2YEAR;
	}
	public BigDecimal getR26_ACCOUNTS_AED_3YEAR() {
		return R26_ACCOUNTS_AED_3YEAR;
	}
	public void setR26_ACCOUNTS_AED_3YEAR(BigDecimal r26_ACCOUNTS_AED_3YEAR) {
		R26_ACCOUNTS_AED_3YEAR = r26_ACCOUNTS_AED_3YEAR;
	}
	public BigDecimal getR26_AMOUNT_AED_3YEAR() {
		return R26_AMOUNT_AED_3YEAR;
	}
	public void setR26_AMOUNT_AED_3YEAR(BigDecimal r26_AMOUNT_AED_3YEAR) {
		R26_AMOUNT_AED_3YEAR = r26_AMOUNT_AED_3YEAR;
	}
	public BigDecimal getR26_ACCOUNTS_FCY_3YEAR() {
		return R26_ACCOUNTS_FCY_3YEAR;
	}
	public void setR26_ACCOUNTS_FCY_3YEAR(BigDecimal r26_ACCOUNTS_FCY_3YEAR) {
		R26_ACCOUNTS_FCY_3YEAR = r26_ACCOUNTS_FCY_3YEAR;
	}
	public BigDecimal getR26_AMOUNT_FCY_3YEAR() {
		return R26_AMOUNT_FCY_3YEAR;
	}
	public void setR26_AMOUNT_FCY_3YEAR(BigDecimal r26_AMOUNT_FCY_3YEAR) {
		R26_AMOUNT_FCY_3YEAR = r26_AMOUNT_FCY_3YEAR;
	}
	public BigDecimal getR26_ACCOUNTS_AED_5YEAR() {
		return R26_ACCOUNTS_AED_5YEAR;
	}
	public void setR26_ACCOUNTS_AED_5YEAR(BigDecimal r26_ACCOUNTS_AED_5YEAR) {
		R26_ACCOUNTS_AED_5YEAR = r26_ACCOUNTS_AED_5YEAR;
	}
	public BigDecimal getR26_AMOUNT_AED_5YEAR() {
		return R26_AMOUNT_AED_5YEAR;
	}
	public void setR26_AMOUNT_AED_5YEAR(BigDecimal r26_AMOUNT_AED_5YEAR) {
		R26_AMOUNT_AED_5YEAR = r26_AMOUNT_AED_5YEAR;
	}
	public BigDecimal getR26_ACCOUNTS_FCY_5YEAR() {
		return R26_ACCOUNTS_FCY_5YEAR;
	}
	public void setR26_ACCOUNTS_FCY_5YEAR(BigDecimal r26_ACCOUNTS_FCY_5YEAR) {
		R26_ACCOUNTS_FCY_5YEAR = r26_ACCOUNTS_FCY_5YEAR;
	}
	public BigDecimal getR26_AMOUNT_FCY_5YEAR() {
		return R26_AMOUNT_FCY_5YEAR;
	}
	public void setR26_AMOUNT_FCY_5YEAR(BigDecimal r26_AMOUNT_FCY_5YEAR) {
		R26_AMOUNT_FCY_5YEAR = r26_AMOUNT_FCY_5YEAR;
	}
	public BigDecimal getR26_ACCOUNTS_AED_ABOVE() {
		return R26_ACCOUNTS_AED_ABOVE;
	}
	public void setR26_ACCOUNTS_AED_ABOVE(BigDecimal r26_ACCOUNTS_AED_ABOVE) {
		R26_ACCOUNTS_AED_ABOVE = r26_ACCOUNTS_AED_ABOVE;
	}
	public BigDecimal getR26_AMOUNT_AED_ABOVE() {
		return R26_AMOUNT_AED_ABOVE;
	}
	public void setR26_AMOUNT_AED_ABOVE(BigDecimal r26_AMOUNT_AED_ABOVE) {
		R26_AMOUNT_AED_ABOVE = r26_AMOUNT_AED_ABOVE;
	}
	public BigDecimal getR26_ACCOUNTS_FCY_ABOVE() {
		return R26_ACCOUNTS_FCY_ABOVE;
	}
	public void setR26_ACCOUNTS_FCY_ABOVE(BigDecimal r26_ACCOUNTS_FCY_ABOVE) {
		R26_ACCOUNTS_FCY_ABOVE = r26_ACCOUNTS_FCY_ABOVE;
	}
	public BigDecimal getR26_AMOUNT_FCY_ABOVE() {
		return R26_AMOUNT_FCY_ABOVE;
	}
	public void setR26_AMOUNT_FCY_ABOVE(BigDecimal r26_AMOUNT_FCY_ABOVE) {
		R26_AMOUNT_FCY_ABOVE = r26_AMOUNT_FCY_ABOVE;
	}
	public BigDecimal getR26_ACCOUNTS_AED_INACTIVE() {
		return R26_ACCOUNTS_AED_INACTIVE;
	}
	public void setR26_ACCOUNTS_AED_INACTIVE(BigDecimal r26_ACCOUNTS_AED_INACTIVE) {
		R26_ACCOUNTS_AED_INACTIVE = r26_ACCOUNTS_AED_INACTIVE;
	}
	public BigDecimal getR26_AMOUNT_AED_INACTIVE() {
		return R26_AMOUNT_AED_INACTIVE;
	}
	public void setR26_AMOUNT_AED_INACTIVE(BigDecimal r26_AMOUNT_AED_INACTIVE) {
		R26_AMOUNT_AED_INACTIVE = r26_AMOUNT_AED_INACTIVE;
	}
	public BigDecimal getR26_ACCOUNTS_FCY_INACTIVE() {
		return R26_ACCOUNTS_FCY_INACTIVE;
	}
	public void setR26_ACCOUNTS_FCY_INACTIVE(BigDecimal r26_ACCOUNTS_FCY_INACTIVE) {
		R26_ACCOUNTS_FCY_INACTIVE = r26_ACCOUNTS_FCY_INACTIVE;
	}
	public BigDecimal getR26_AMOUNT_FCY_INACTIVE() {
		return R26_AMOUNT_FCY_INACTIVE;
	}
	public void setR26_AMOUNT_FCY_INACTIVE(BigDecimal r26_AMOUNT_FCY_INACTIVE) {
		R26_AMOUNT_FCY_INACTIVE = r26_AMOUNT_FCY_INACTIVE;
	}
	public BigDecimal getR26_ACCOUNTS_AED_DORMANT() {
		return R26_ACCOUNTS_AED_DORMANT;
	}
	public void setR26_ACCOUNTS_AED_DORMANT(BigDecimal r26_ACCOUNTS_AED_DORMANT) {
		R26_ACCOUNTS_AED_DORMANT = r26_ACCOUNTS_AED_DORMANT;
	}
	public BigDecimal getR26_AMOUNT_AED_DORMANT() {
		return R26_AMOUNT_AED_DORMANT;
	}
	public void setR26_AMOUNT_AED_DORMANT(BigDecimal r26_AMOUNT_AED_DORMANT) {
		R26_AMOUNT_AED_DORMANT = r26_AMOUNT_AED_DORMANT;
	}
	public BigDecimal getR26_ACCOUNTS_FCY_DORMANT() {
		return R26_ACCOUNTS_FCY_DORMANT;
	}
	public void setR26_ACCOUNTS_FCY_DORMANT(BigDecimal r26_ACCOUNTS_FCY_DORMANT) {
		R26_ACCOUNTS_FCY_DORMANT = r26_ACCOUNTS_FCY_DORMANT;
	}
	public BigDecimal getR26_AMOUNT_FCY_DORMANT() {
		return R26_AMOUNT_FCY_DORMANT;
	}
	public void setR26_AMOUNT_FCY_DORMANT(BigDecimal r26_AMOUNT_FCY_DORMANT) {
		R26_AMOUNT_FCY_DORMANT = r26_AMOUNT_FCY_DORMANT;
	}
	public String getR27_S_NO() {
		return R27_S_NO;
	}
	public void setR27_S_NO(String r27_S_NO) {
		R27_S_NO = r27_S_NO;
	}
	public String getR27_REGULATIONS() {
		return R27_REGULATIONS;
	}
	public void setR27_REGULATIONS(String r27_REGULATIONS) {
		R27_REGULATIONS = r27_REGULATIONS;
	}
	public String getR27_DORMANT() {
		return R27_DORMANT;
	}
	public void setR27_DORMANT(String r27_DORMANT) {
		R27_DORMANT = r27_DORMANT;
	}
	public BigDecimal getR27_ACCOUNTS_AED_1YEAR() {
		return R27_ACCOUNTS_AED_1YEAR;
	}
	public void setR27_ACCOUNTS_AED_1YEAR(BigDecimal r27_ACCOUNTS_AED_1YEAR) {
		R27_ACCOUNTS_AED_1YEAR = r27_ACCOUNTS_AED_1YEAR;
	}
	public BigDecimal getR27_AMOUNT_AED_1YEAR() {
		return R27_AMOUNT_AED_1YEAR;
	}
	public void setR27_AMOUNT_AED_1YEAR(BigDecimal r27_AMOUNT_AED_1YEAR) {
		R27_AMOUNT_AED_1YEAR = r27_AMOUNT_AED_1YEAR;
	}
	public BigDecimal getR27_ACCOUNTS_FCY_1YEAR() {
		return R27_ACCOUNTS_FCY_1YEAR;
	}
	public void setR27_ACCOUNTS_FCY_1YEAR(BigDecimal r27_ACCOUNTS_FCY_1YEAR) {
		R27_ACCOUNTS_FCY_1YEAR = r27_ACCOUNTS_FCY_1YEAR;
	}
	public BigDecimal getR27_AMOUNT_FCY_1YEAR() {
		return R27_AMOUNT_FCY_1YEAR;
	}
	public void setR27_AMOUNT_FCY_1YEAR(BigDecimal r27_AMOUNT_FCY_1YEAR) {
		R27_AMOUNT_FCY_1YEAR = r27_AMOUNT_FCY_1YEAR;
	}
	public BigDecimal getR27_ACCOUNTS_AED_2YEAR() {
		return R27_ACCOUNTS_AED_2YEAR;
	}
	public void setR27_ACCOUNTS_AED_2YEAR(BigDecimal r27_ACCOUNTS_AED_2YEAR) {
		R27_ACCOUNTS_AED_2YEAR = r27_ACCOUNTS_AED_2YEAR;
	}
	public BigDecimal getR27_AMOUNT_AED_2YEAR() {
		return R27_AMOUNT_AED_2YEAR;
	}
	public void setR27_AMOUNT_AED_2YEAR(BigDecimal r27_AMOUNT_AED_2YEAR) {
		R27_AMOUNT_AED_2YEAR = r27_AMOUNT_AED_2YEAR;
	}
	public BigDecimal getR27_ACCOUNTS_FCY_2YEAR() {
		return R27_ACCOUNTS_FCY_2YEAR;
	}
	public void setR27_ACCOUNTS_FCY_2YEAR(BigDecimal r27_ACCOUNTS_FCY_2YEAR) {
		R27_ACCOUNTS_FCY_2YEAR = r27_ACCOUNTS_FCY_2YEAR;
	}
	public BigDecimal getR27_AMOUNT_FCY_2YEAR() {
		return R27_AMOUNT_FCY_2YEAR;
	}
	public void setR27_AMOUNT_FCY_2YEAR(BigDecimal r27_AMOUNT_FCY_2YEAR) {
		R27_AMOUNT_FCY_2YEAR = r27_AMOUNT_FCY_2YEAR;
	}
	public BigDecimal getR27_ACCOUNTS_AED_3YEAR() {
		return R27_ACCOUNTS_AED_3YEAR;
	}
	public void setR27_ACCOUNTS_AED_3YEAR(BigDecimal r27_ACCOUNTS_AED_3YEAR) {
		R27_ACCOUNTS_AED_3YEAR = r27_ACCOUNTS_AED_3YEAR;
	}
	public BigDecimal getR27_AMOUNT_AED_3YEAR() {
		return R27_AMOUNT_AED_3YEAR;
	}
	public void setR27_AMOUNT_AED_3YEAR(BigDecimal r27_AMOUNT_AED_3YEAR) {
		R27_AMOUNT_AED_3YEAR = r27_AMOUNT_AED_3YEAR;
	}
	public BigDecimal getR27_ACCOUNTS_FCY_3YEAR() {
		return R27_ACCOUNTS_FCY_3YEAR;
	}
	public void setR27_ACCOUNTS_FCY_3YEAR(BigDecimal r27_ACCOUNTS_FCY_3YEAR) {
		R27_ACCOUNTS_FCY_3YEAR = r27_ACCOUNTS_FCY_3YEAR;
	}
	public BigDecimal getR27_AMOUNT_FCY_3YEAR() {
		return R27_AMOUNT_FCY_3YEAR;
	}
	public void setR27_AMOUNT_FCY_3YEAR(BigDecimal r27_AMOUNT_FCY_3YEAR) {
		R27_AMOUNT_FCY_3YEAR = r27_AMOUNT_FCY_3YEAR;
	}
	public BigDecimal getR27_ACCOUNTS_AED_5YEAR() {
		return R27_ACCOUNTS_AED_5YEAR;
	}
	public void setR27_ACCOUNTS_AED_5YEAR(BigDecimal r27_ACCOUNTS_AED_5YEAR) {
		R27_ACCOUNTS_AED_5YEAR = r27_ACCOUNTS_AED_5YEAR;
	}
	public BigDecimal getR27_AMOUNT_AED_5YEAR() {
		return R27_AMOUNT_AED_5YEAR;
	}
	public void setR27_AMOUNT_AED_5YEAR(BigDecimal r27_AMOUNT_AED_5YEAR) {
		R27_AMOUNT_AED_5YEAR = r27_AMOUNT_AED_5YEAR;
	}
	public BigDecimal getR27_ACCOUNTS_FCY_5YEAR() {
		return R27_ACCOUNTS_FCY_5YEAR;
	}
	public void setR27_ACCOUNTS_FCY_5YEAR(BigDecimal r27_ACCOUNTS_FCY_5YEAR) {
		R27_ACCOUNTS_FCY_5YEAR = r27_ACCOUNTS_FCY_5YEAR;
	}
	public BigDecimal getR27_AMOUNT_FCY_5YEAR() {
		return R27_AMOUNT_FCY_5YEAR;
	}
	public void setR27_AMOUNT_FCY_5YEAR(BigDecimal r27_AMOUNT_FCY_5YEAR) {
		R27_AMOUNT_FCY_5YEAR = r27_AMOUNT_FCY_5YEAR;
	}
	public BigDecimal getR27_ACCOUNTS_AED_ABOVE() {
		return R27_ACCOUNTS_AED_ABOVE;
	}
	public void setR27_ACCOUNTS_AED_ABOVE(BigDecimal r27_ACCOUNTS_AED_ABOVE) {
		R27_ACCOUNTS_AED_ABOVE = r27_ACCOUNTS_AED_ABOVE;
	}
	public BigDecimal getR27_AMOUNT_AED_ABOVE() {
		return R27_AMOUNT_AED_ABOVE;
	}
	public void setR27_AMOUNT_AED_ABOVE(BigDecimal r27_AMOUNT_AED_ABOVE) {
		R27_AMOUNT_AED_ABOVE = r27_AMOUNT_AED_ABOVE;
	}
	public BigDecimal getR27_ACCOUNTS_FCY_ABOVE() {
		return R27_ACCOUNTS_FCY_ABOVE;
	}
	public void setR27_ACCOUNTS_FCY_ABOVE(BigDecimal r27_ACCOUNTS_FCY_ABOVE) {
		R27_ACCOUNTS_FCY_ABOVE = r27_ACCOUNTS_FCY_ABOVE;
	}
	public BigDecimal getR27_AMOUNT_FCY_ABOVE() {
		return R27_AMOUNT_FCY_ABOVE;
	}
	public void setR27_AMOUNT_FCY_ABOVE(BigDecimal r27_AMOUNT_FCY_ABOVE) {
		R27_AMOUNT_FCY_ABOVE = r27_AMOUNT_FCY_ABOVE;
	}
	public BigDecimal getR27_ACCOUNTS_AED_INACTIVE() {
		return R27_ACCOUNTS_AED_INACTIVE;
	}
	public void setR27_ACCOUNTS_AED_INACTIVE(BigDecimal r27_ACCOUNTS_AED_INACTIVE) {
		R27_ACCOUNTS_AED_INACTIVE = r27_ACCOUNTS_AED_INACTIVE;
	}
	public BigDecimal getR27_AMOUNT_AED_INACTIVE() {
		return R27_AMOUNT_AED_INACTIVE;
	}
	public void setR27_AMOUNT_AED_INACTIVE(BigDecimal r27_AMOUNT_AED_INACTIVE) {
		R27_AMOUNT_AED_INACTIVE = r27_AMOUNT_AED_INACTIVE;
	}
	public BigDecimal getR27_ACCOUNTS_FCY_INACTIVE() {
		return R27_ACCOUNTS_FCY_INACTIVE;
	}
	public void setR27_ACCOUNTS_FCY_INACTIVE(BigDecimal r27_ACCOUNTS_FCY_INACTIVE) {
		R27_ACCOUNTS_FCY_INACTIVE = r27_ACCOUNTS_FCY_INACTIVE;
	}
	public BigDecimal getR27_AMOUNT_FCY_INACTIVE() {
		return R27_AMOUNT_FCY_INACTIVE;
	}
	public void setR27_AMOUNT_FCY_INACTIVE(BigDecimal r27_AMOUNT_FCY_INACTIVE) {
		R27_AMOUNT_FCY_INACTIVE = r27_AMOUNT_FCY_INACTIVE;
	}
	public BigDecimal getR27_ACCOUNTS_AED_DORMANT() {
		return R27_ACCOUNTS_AED_DORMANT;
	}
	public void setR27_ACCOUNTS_AED_DORMANT(BigDecimal r27_ACCOUNTS_AED_DORMANT) {
		R27_ACCOUNTS_AED_DORMANT = r27_ACCOUNTS_AED_DORMANT;
	}
	public BigDecimal getR27_AMOUNT_AED_DORMANT() {
		return R27_AMOUNT_AED_DORMANT;
	}
	public void setR27_AMOUNT_AED_DORMANT(BigDecimal r27_AMOUNT_AED_DORMANT) {
		R27_AMOUNT_AED_DORMANT = r27_AMOUNT_AED_DORMANT;
	}
	public BigDecimal getR27_ACCOUNTS_FCY_DORMANT() {
		return R27_ACCOUNTS_FCY_DORMANT;
	}
	public void setR27_ACCOUNTS_FCY_DORMANT(BigDecimal r27_ACCOUNTS_FCY_DORMANT) {
		R27_ACCOUNTS_FCY_DORMANT = r27_ACCOUNTS_FCY_DORMANT;
	}
	public BigDecimal getR27_AMOUNT_FCY_DORMANT() {
		return R27_AMOUNT_FCY_DORMANT;
	}
	public void setR27_AMOUNT_FCY_DORMANT(BigDecimal r27_AMOUNT_FCY_DORMANT) {
		R27_AMOUNT_FCY_DORMANT = r27_AMOUNT_FCY_DORMANT;
	}
	public String getR28_S_NO() {
		return R28_S_NO;
	}
	public void setR28_S_NO(String r28_S_NO) {
		R28_S_NO = r28_S_NO;
	}
	public String getR28_REGULATIONS() {
		return R28_REGULATIONS;
	}
	public void setR28_REGULATIONS(String r28_REGULATIONS) {
		R28_REGULATIONS = r28_REGULATIONS;
	}
	public String getR28_DORMANT() {
		return R28_DORMANT;
	}
	public void setR28_DORMANT(String r28_DORMANT) {
		R28_DORMANT = r28_DORMANT;
	}
	public BigDecimal getR28_ACCOUNTS_AED_1YEAR() {
		return R28_ACCOUNTS_AED_1YEAR;
	}
	public void setR28_ACCOUNTS_AED_1YEAR(BigDecimal r28_ACCOUNTS_AED_1YEAR) {
		R28_ACCOUNTS_AED_1YEAR = r28_ACCOUNTS_AED_1YEAR;
	}
	public BigDecimal getR28_AMOUNT_AED_1YEAR() {
		return R28_AMOUNT_AED_1YEAR;
	}
	public void setR28_AMOUNT_AED_1YEAR(BigDecimal r28_AMOUNT_AED_1YEAR) {
		R28_AMOUNT_AED_1YEAR = r28_AMOUNT_AED_1YEAR;
	}
	public BigDecimal getR28_ACCOUNTS_FCY_1YEAR() {
		return R28_ACCOUNTS_FCY_1YEAR;
	}
	public void setR28_ACCOUNTS_FCY_1YEAR(BigDecimal r28_ACCOUNTS_FCY_1YEAR) {
		R28_ACCOUNTS_FCY_1YEAR = r28_ACCOUNTS_FCY_1YEAR;
	}
	public BigDecimal getR28_AMOUNT_FCY_1YEAR() {
		return R28_AMOUNT_FCY_1YEAR;
	}
	public void setR28_AMOUNT_FCY_1YEAR(BigDecimal r28_AMOUNT_FCY_1YEAR) {
		R28_AMOUNT_FCY_1YEAR = r28_AMOUNT_FCY_1YEAR;
	}
	public BigDecimal getR28_ACCOUNTS_AED_2YEAR() {
		return R28_ACCOUNTS_AED_2YEAR;
	}
	public void setR28_ACCOUNTS_AED_2YEAR(BigDecimal r28_ACCOUNTS_AED_2YEAR) {
		R28_ACCOUNTS_AED_2YEAR = r28_ACCOUNTS_AED_2YEAR;
	}
	public BigDecimal getR28_AMOUNT_AED_2YEAR() {
		return R28_AMOUNT_AED_2YEAR;
	}
	public void setR28_AMOUNT_AED_2YEAR(BigDecimal r28_AMOUNT_AED_2YEAR) {
		R28_AMOUNT_AED_2YEAR = r28_AMOUNT_AED_2YEAR;
	}
	public BigDecimal getR28_ACCOUNTS_FCY_2YEAR() {
		return R28_ACCOUNTS_FCY_2YEAR;
	}
	public void setR28_ACCOUNTS_FCY_2YEAR(BigDecimal r28_ACCOUNTS_FCY_2YEAR) {
		R28_ACCOUNTS_FCY_2YEAR = r28_ACCOUNTS_FCY_2YEAR;
	}
	public BigDecimal getR28_AMOUNT_FCY_2YEAR() {
		return R28_AMOUNT_FCY_2YEAR;
	}
	public void setR28_AMOUNT_FCY_2YEAR(BigDecimal r28_AMOUNT_FCY_2YEAR) {
		R28_AMOUNT_FCY_2YEAR = r28_AMOUNT_FCY_2YEAR;
	}
	public BigDecimal getR28_ACCOUNTS_AED_3YEAR() {
		return R28_ACCOUNTS_AED_3YEAR;
	}
	public void setR28_ACCOUNTS_AED_3YEAR(BigDecimal r28_ACCOUNTS_AED_3YEAR) {
		R28_ACCOUNTS_AED_3YEAR = r28_ACCOUNTS_AED_3YEAR;
	}
	public BigDecimal getR28_AMOUNT_AED_3YEAR() {
		return R28_AMOUNT_AED_3YEAR;
	}
	public void setR28_AMOUNT_AED_3YEAR(BigDecimal r28_AMOUNT_AED_3YEAR) {
		R28_AMOUNT_AED_3YEAR = r28_AMOUNT_AED_3YEAR;
	}
	public BigDecimal getR28_ACCOUNTS_FCY_3YEAR() {
		return R28_ACCOUNTS_FCY_3YEAR;
	}
	public void setR28_ACCOUNTS_FCY_3YEAR(BigDecimal r28_ACCOUNTS_FCY_3YEAR) {
		R28_ACCOUNTS_FCY_3YEAR = r28_ACCOUNTS_FCY_3YEAR;
	}
	public BigDecimal getR28_AMOUNT_FCY_3YEAR() {
		return R28_AMOUNT_FCY_3YEAR;
	}
	public void setR28_AMOUNT_FCY_3YEAR(BigDecimal r28_AMOUNT_FCY_3YEAR) {
		R28_AMOUNT_FCY_3YEAR = r28_AMOUNT_FCY_3YEAR;
	}
	public BigDecimal getR28_ACCOUNTS_AED_5YEAR() {
		return R28_ACCOUNTS_AED_5YEAR;
	}
	public void setR28_ACCOUNTS_AED_5YEAR(BigDecimal r28_ACCOUNTS_AED_5YEAR) {
		R28_ACCOUNTS_AED_5YEAR = r28_ACCOUNTS_AED_5YEAR;
	}
	public BigDecimal getR28_AMOUNT_AED_5YEAR() {
		return R28_AMOUNT_AED_5YEAR;
	}
	public void setR28_AMOUNT_AED_5YEAR(BigDecimal r28_AMOUNT_AED_5YEAR) {
		R28_AMOUNT_AED_5YEAR = r28_AMOUNT_AED_5YEAR;
	}
	public BigDecimal getR28_ACCOUNTS_FCY_5YEAR() {
		return R28_ACCOUNTS_FCY_5YEAR;
	}
	public void setR28_ACCOUNTS_FCY_5YEAR(BigDecimal r28_ACCOUNTS_FCY_5YEAR) {
		R28_ACCOUNTS_FCY_5YEAR = r28_ACCOUNTS_FCY_5YEAR;
	}
	public BigDecimal getR28_AMOUNT_FCY_5YEAR() {
		return R28_AMOUNT_FCY_5YEAR;
	}
	public void setR28_AMOUNT_FCY_5YEAR(BigDecimal r28_AMOUNT_FCY_5YEAR) {
		R28_AMOUNT_FCY_5YEAR = r28_AMOUNT_FCY_5YEAR;
	}
	public BigDecimal getR28_ACCOUNTS_AED_ABOVE() {
		return R28_ACCOUNTS_AED_ABOVE;
	}
	public void setR28_ACCOUNTS_AED_ABOVE(BigDecimal r28_ACCOUNTS_AED_ABOVE) {
		R28_ACCOUNTS_AED_ABOVE = r28_ACCOUNTS_AED_ABOVE;
	}
	public BigDecimal getR28_AMOUNT_AED_ABOVE() {
		return R28_AMOUNT_AED_ABOVE;
	}
	public void setR28_AMOUNT_AED_ABOVE(BigDecimal r28_AMOUNT_AED_ABOVE) {
		R28_AMOUNT_AED_ABOVE = r28_AMOUNT_AED_ABOVE;
	}
	public BigDecimal getR28_ACCOUNTS_FCY_ABOVE() {
		return R28_ACCOUNTS_FCY_ABOVE;
	}
	public void setR28_ACCOUNTS_FCY_ABOVE(BigDecimal r28_ACCOUNTS_FCY_ABOVE) {
		R28_ACCOUNTS_FCY_ABOVE = r28_ACCOUNTS_FCY_ABOVE;
	}
	public BigDecimal getR28_AMOUNT_FCY_ABOVE() {
		return R28_AMOUNT_FCY_ABOVE;
	}
	public void setR28_AMOUNT_FCY_ABOVE(BigDecimal r28_AMOUNT_FCY_ABOVE) {
		R28_AMOUNT_FCY_ABOVE = r28_AMOUNT_FCY_ABOVE;
	}
	public BigDecimal getR28_ACCOUNTS_AED_INACTIVE() {
		return R28_ACCOUNTS_AED_INACTIVE;
	}
	public void setR28_ACCOUNTS_AED_INACTIVE(BigDecimal r28_ACCOUNTS_AED_INACTIVE) {
		R28_ACCOUNTS_AED_INACTIVE = r28_ACCOUNTS_AED_INACTIVE;
	}
	public BigDecimal getR28_AMOUNT_AED_INACTIVE() {
		return R28_AMOUNT_AED_INACTIVE;
	}
	public void setR28_AMOUNT_AED_INACTIVE(BigDecimal r28_AMOUNT_AED_INACTIVE) {
		R28_AMOUNT_AED_INACTIVE = r28_AMOUNT_AED_INACTIVE;
	}
	public BigDecimal getR28_ACCOUNTS_FCY_INACTIVE() {
		return R28_ACCOUNTS_FCY_INACTIVE;
	}
	public void setR28_ACCOUNTS_FCY_INACTIVE(BigDecimal r28_ACCOUNTS_FCY_INACTIVE) {
		R28_ACCOUNTS_FCY_INACTIVE = r28_ACCOUNTS_FCY_INACTIVE;
	}
	public BigDecimal getR28_AMOUNT_FCY_INACTIVE() {
		return R28_AMOUNT_FCY_INACTIVE;
	}
	public void setR28_AMOUNT_FCY_INACTIVE(BigDecimal r28_AMOUNT_FCY_INACTIVE) {
		R28_AMOUNT_FCY_INACTIVE = r28_AMOUNT_FCY_INACTIVE;
	}
	public BigDecimal getR28_ACCOUNTS_AED_DORMANT() {
		return R28_ACCOUNTS_AED_DORMANT;
	}
	public void setR28_ACCOUNTS_AED_DORMANT(BigDecimal r28_ACCOUNTS_AED_DORMANT) {
		R28_ACCOUNTS_AED_DORMANT = r28_ACCOUNTS_AED_DORMANT;
	}
	public BigDecimal getR28_AMOUNT_AED_DORMANT() {
		return R28_AMOUNT_AED_DORMANT;
	}
	public void setR28_AMOUNT_AED_DORMANT(BigDecimal r28_AMOUNT_AED_DORMANT) {
		R28_AMOUNT_AED_DORMANT = r28_AMOUNT_AED_DORMANT;
	}
	public BigDecimal getR28_ACCOUNTS_FCY_DORMANT() {
		return R28_ACCOUNTS_FCY_DORMANT;
	}
	public void setR28_ACCOUNTS_FCY_DORMANT(BigDecimal r28_ACCOUNTS_FCY_DORMANT) {
		R28_ACCOUNTS_FCY_DORMANT = r28_ACCOUNTS_FCY_DORMANT;
	}
	public BigDecimal getR28_AMOUNT_FCY_DORMANT() {
		return R28_AMOUNT_FCY_DORMANT;
	}
	public void setR28_AMOUNT_FCY_DORMANT(BigDecimal r28_AMOUNT_FCY_DORMANT) {
		R28_AMOUNT_FCY_DORMANT = r28_AMOUNT_FCY_DORMANT;
	}
	public String getR29_S_NO() {
		return R29_S_NO;
	}
	public void setR29_S_NO(String r29_S_NO) {
		R29_S_NO = r29_S_NO;
	}
	public String getR29_REGULATIONS() {
		return R29_REGULATIONS;
	}
	public void setR29_REGULATIONS(String r29_REGULATIONS) {
		R29_REGULATIONS = r29_REGULATIONS;
	}
	public String getR29_DORMANT() {
		return R29_DORMANT;
	}
	public void setR29_DORMANT(String r29_DORMANT) {
		R29_DORMANT = r29_DORMANT;
	}
	public BigDecimal getR29_ACCOUNTS_AED_1YEAR() {
		return R29_ACCOUNTS_AED_1YEAR;
	}
	public void setR29_ACCOUNTS_AED_1YEAR(BigDecimal r29_ACCOUNTS_AED_1YEAR) {
		R29_ACCOUNTS_AED_1YEAR = r29_ACCOUNTS_AED_1YEAR;
	}
	public BigDecimal getR29_AMOUNT_AED_1YEAR() {
		return R29_AMOUNT_AED_1YEAR;
	}
	public void setR29_AMOUNT_AED_1YEAR(BigDecimal r29_AMOUNT_AED_1YEAR) {
		R29_AMOUNT_AED_1YEAR = r29_AMOUNT_AED_1YEAR;
	}
	public BigDecimal getR29_ACCOUNTS_FCY_1YEAR() {
		return R29_ACCOUNTS_FCY_1YEAR;
	}
	public void setR29_ACCOUNTS_FCY_1YEAR(BigDecimal r29_ACCOUNTS_FCY_1YEAR) {
		R29_ACCOUNTS_FCY_1YEAR = r29_ACCOUNTS_FCY_1YEAR;
	}
	public BigDecimal getR29_AMOUNT_FCY_1YEAR() {
		return R29_AMOUNT_FCY_1YEAR;
	}
	public void setR29_AMOUNT_FCY_1YEAR(BigDecimal r29_AMOUNT_FCY_1YEAR) {
		R29_AMOUNT_FCY_1YEAR = r29_AMOUNT_FCY_1YEAR;
	}
	public BigDecimal getR29_ACCOUNTS_AED_2YEAR() {
		return R29_ACCOUNTS_AED_2YEAR;
	}
	public void setR29_ACCOUNTS_AED_2YEAR(BigDecimal r29_ACCOUNTS_AED_2YEAR) {
		R29_ACCOUNTS_AED_2YEAR = r29_ACCOUNTS_AED_2YEAR;
	}
	public BigDecimal getR29_AMOUNT_AED_2YEAR() {
		return R29_AMOUNT_AED_2YEAR;
	}
	public void setR29_AMOUNT_AED_2YEAR(BigDecimal r29_AMOUNT_AED_2YEAR) {
		R29_AMOUNT_AED_2YEAR = r29_AMOUNT_AED_2YEAR;
	}
	public BigDecimal getR29_ACCOUNTS_FCY_2YEAR() {
		return R29_ACCOUNTS_FCY_2YEAR;
	}
	public void setR29_ACCOUNTS_FCY_2YEAR(BigDecimal r29_ACCOUNTS_FCY_2YEAR) {
		R29_ACCOUNTS_FCY_2YEAR = r29_ACCOUNTS_FCY_2YEAR;
	}
	public BigDecimal getR29_AMOUNT_FCY_2YEAR() {
		return R29_AMOUNT_FCY_2YEAR;
	}
	public void setR29_AMOUNT_FCY_2YEAR(BigDecimal r29_AMOUNT_FCY_2YEAR) {
		R29_AMOUNT_FCY_2YEAR = r29_AMOUNT_FCY_2YEAR;
	}
	public BigDecimal getR29_ACCOUNTS_AED_3YEAR() {
		return R29_ACCOUNTS_AED_3YEAR;
	}
	public void setR29_ACCOUNTS_AED_3YEAR(BigDecimal r29_ACCOUNTS_AED_3YEAR) {
		R29_ACCOUNTS_AED_3YEAR = r29_ACCOUNTS_AED_3YEAR;
	}
	public BigDecimal getR29_AMOUNT_AED_3YEAR() {
		return R29_AMOUNT_AED_3YEAR;
	}
	public void setR29_AMOUNT_AED_3YEAR(BigDecimal r29_AMOUNT_AED_3YEAR) {
		R29_AMOUNT_AED_3YEAR = r29_AMOUNT_AED_3YEAR;
	}
	public BigDecimal getR29_ACCOUNTS_FCY_3YEAR() {
		return R29_ACCOUNTS_FCY_3YEAR;
	}
	public void setR29_ACCOUNTS_FCY_3YEAR(BigDecimal r29_ACCOUNTS_FCY_3YEAR) {
		R29_ACCOUNTS_FCY_3YEAR = r29_ACCOUNTS_FCY_3YEAR;
	}
	public BigDecimal getR29_AMOUNT_FCY_3YEAR() {
		return R29_AMOUNT_FCY_3YEAR;
	}
	public void setR29_AMOUNT_FCY_3YEAR(BigDecimal r29_AMOUNT_FCY_3YEAR) {
		R29_AMOUNT_FCY_3YEAR = r29_AMOUNT_FCY_3YEAR;
	}
	public BigDecimal getR29_ACCOUNTS_AED_5YEAR() {
		return R29_ACCOUNTS_AED_5YEAR;
	}
	public void setR29_ACCOUNTS_AED_5YEAR(BigDecimal r29_ACCOUNTS_AED_5YEAR) {
		R29_ACCOUNTS_AED_5YEAR = r29_ACCOUNTS_AED_5YEAR;
	}
	public BigDecimal getR29_AMOUNT_AED_5YEAR() {
		return R29_AMOUNT_AED_5YEAR;
	}
	public void setR29_AMOUNT_AED_5YEAR(BigDecimal r29_AMOUNT_AED_5YEAR) {
		R29_AMOUNT_AED_5YEAR = r29_AMOUNT_AED_5YEAR;
	}
	public BigDecimal getR29_ACCOUNTS_FCY_5YEAR() {
		return R29_ACCOUNTS_FCY_5YEAR;
	}
	public void setR29_ACCOUNTS_FCY_5YEAR(BigDecimal r29_ACCOUNTS_FCY_5YEAR) {
		R29_ACCOUNTS_FCY_5YEAR = r29_ACCOUNTS_FCY_5YEAR;
	}
	public BigDecimal getR29_AMOUNT_FCY_5YEAR() {
		return R29_AMOUNT_FCY_5YEAR;
	}
	public void setR29_AMOUNT_FCY_5YEAR(BigDecimal r29_AMOUNT_FCY_5YEAR) {
		R29_AMOUNT_FCY_5YEAR = r29_AMOUNT_FCY_5YEAR;
	}
	public BigDecimal getR29_ACCOUNTS_AED_ABOVE() {
		return R29_ACCOUNTS_AED_ABOVE;
	}
	public void setR29_ACCOUNTS_AED_ABOVE(BigDecimal r29_ACCOUNTS_AED_ABOVE) {
		R29_ACCOUNTS_AED_ABOVE = r29_ACCOUNTS_AED_ABOVE;
	}
	public BigDecimal getR29_AMOUNT_AED_ABOVE() {
		return R29_AMOUNT_AED_ABOVE;
	}
	public void setR29_AMOUNT_AED_ABOVE(BigDecimal r29_AMOUNT_AED_ABOVE) {
		R29_AMOUNT_AED_ABOVE = r29_AMOUNT_AED_ABOVE;
	}
	public BigDecimal getR29_ACCOUNTS_FCY_ABOVE() {
		return R29_ACCOUNTS_FCY_ABOVE;
	}
	public void setR29_ACCOUNTS_FCY_ABOVE(BigDecimal r29_ACCOUNTS_FCY_ABOVE) {
		R29_ACCOUNTS_FCY_ABOVE = r29_ACCOUNTS_FCY_ABOVE;
	}
	public BigDecimal getR29_AMOUNT_FCY_ABOVE() {
		return R29_AMOUNT_FCY_ABOVE;
	}
	public void setR29_AMOUNT_FCY_ABOVE(BigDecimal r29_AMOUNT_FCY_ABOVE) {
		R29_AMOUNT_FCY_ABOVE = r29_AMOUNT_FCY_ABOVE;
	}
	public BigDecimal getR29_ACCOUNTS_AED_INACTIVE() {
		return R29_ACCOUNTS_AED_INACTIVE;
	}
	public void setR29_ACCOUNTS_AED_INACTIVE(BigDecimal r29_ACCOUNTS_AED_INACTIVE) {
		R29_ACCOUNTS_AED_INACTIVE = r29_ACCOUNTS_AED_INACTIVE;
	}
	public BigDecimal getR29_AMOUNT_AED_INACTIVE() {
		return R29_AMOUNT_AED_INACTIVE;
	}
	public void setR29_AMOUNT_AED_INACTIVE(BigDecimal r29_AMOUNT_AED_INACTIVE) {
		R29_AMOUNT_AED_INACTIVE = r29_AMOUNT_AED_INACTIVE;
	}
	public BigDecimal getR29_ACCOUNTS_FCY_INACTIVE() {
		return R29_ACCOUNTS_FCY_INACTIVE;
	}
	public void setR29_ACCOUNTS_FCY_INACTIVE(BigDecimal r29_ACCOUNTS_FCY_INACTIVE) {
		R29_ACCOUNTS_FCY_INACTIVE = r29_ACCOUNTS_FCY_INACTIVE;
	}
	public BigDecimal getR29_AMOUNT_FCY_INACTIVE() {
		return R29_AMOUNT_FCY_INACTIVE;
	}
	public void setR29_AMOUNT_FCY_INACTIVE(BigDecimal r29_AMOUNT_FCY_INACTIVE) {
		R29_AMOUNT_FCY_INACTIVE = r29_AMOUNT_FCY_INACTIVE;
	}
	public BigDecimal getR29_ACCOUNTS_AED_DORMANT() {
		return R29_ACCOUNTS_AED_DORMANT;
	}
	public void setR29_ACCOUNTS_AED_DORMANT(BigDecimal r29_ACCOUNTS_AED_DORMANT) {
		R29_ACCOUNTS_AED_DORMANT = r29_ACCOUNTS_AED_DORMANT;
	}
	public BigDecimal getR29_AMOUNT_AED_DORMANT() {
		return R29_AMOUNT_AED_DORMANT;
	}
	public void setR29_AMOUNT_AED_DORMANT(BigDecimal r29_AMOUNT_AED_DORMANT) {
		R29_AMOUNT_AED_DORMANT = r29_AMOUNT_AED_DORMANT;
	}
	public BigDecimal getR29_ACCOUNTS_FCY_DORMANT() {
		return R29_ACCOUNTS_FCY_DORMANT;
	}
	public void setR29_ACCOUNTS_FCY_DORMANT(BigDecimal r29_ACCOUNTS_FCY_DORMANT) {
		R29_ACCOUNTS_FCY_DORMANT = r29_ACCOUNTS_FCY_DORMANT;
	}
	public BigDecimal getR29_AMOUNT_FCY_DORMANT() {
		return R29_AMOUNT_FCY_DORMANT;
	}
	public void setR29_AMOUNT_FCY_DORMANT(BigDecimal r29_AMOUNT_FCY_DORMANT) {
		R29_AMOUNT_FCY_DORMANT = r29_AMOUNT_FCY_DORMANT;
	}
	public String getR30_S_NO() {
		return R30_S_NO;
	}
	public void setR30_S_NO(String r30_S_NO) {
		R30_S_NO = r30_S_NO;
	}
	public String getR30_REGULATIONS() {
		return R30_REGULATIONS;
	}
	public void setR30_REGULATIONS(String r30_REGULATIONS) {
		R30_REGULATIONS = r30_REGULATIONS;
	}
	public String getR30_DORMANT() {
		return R30_DORMANT;
	}
	public void setR30_DORMANT(String r30_DORMANT) {
		R30_DORMANT = r30_DORMANT;
	}
	public BigDecimal getR30_ACCOUNTS_AED_1YEAR() {
		return R30_ACCOUNTS_AED_1YEAR;
	}
	public void setR30_ACCOUNTS_AED_1YEAR(BigDecimal r30_ACCOUNTS_AED_1YEAR) {
		R30_ACCOUNTS_AED_1YEAR = r30_ACCOUNTS_AED_1YEAR;
	}
	public BigDecimal getR30_AMOUNT_AED_1YEAR() {
		return R30_AMOUNT_AED_1YEAR;
	}
	public void setR30_AMOUNT_AED_1YEAR(BigDecimal r30_AMOUNT_AED_1YEAR) {
		R30_AMOUNT_AED_1YEAR = r30_AMOUNT_AED_1YEAR;
	}
	public BigDecimal getR30_ACCOUNTS_FCY_1YEAR() {
		return R30_ACCOUNTS_FCY_1YEAR;
	}
	public void setR30_ACCOUNTS_FCY_1YEAR(BigDecimal r30_ACCOUNTS_FCY_1YEAR) {
		R30_ACCOUNTS_FCY_1YEAR = r30_ACCOUNTS_FCY_1YEAR;
	}
	public BigDecimal getR30_AMOUNT_FCY_1YEAR() {
		return R30_AMOUNT_FCY_1YEAR;
	}
	public void setR30_AMOUNT_FCY_1YEAR(BigDecimal r30_AMOUNT_FCY_1YEAR) {
		R30_AMOUNT_FCY_1YEAR = r30_AMOUNT_FCY_1YEAR;
	}
	public BigDecimal getR30_ACCOUNTS_AED_2YEAR() {
		return R30_ACCOUNTS_AED_2YEAR;
	}
	public void setR30_ACCOUNTS_AED_2YEAR(BigDecimal r30_ACCOUNTS_AED_2YEAR) {
		R30_ACCOUNTS_AED_2YEAR = r30_ACCOUNTS_AED_2YEAR;
	}
	public BigDecimal getR30_AMOUNT_AED_2YEAR() {
		return R30_AMOUNT_AED_2YEAR;
	}
	public void setR30_AMOUNT_AED_2YEAR(BigDecimal r30_AMOUNT_AED_2YEAR) {
		R30_AMOUNT_AED_2YEAR = r30_AMOUNT_AED_2YEAR;
	}
	public BigDecimal getR30_ACCOUNTS_FCY_2YEAR() {
		return R30_ACCOUNTS_FCY_2YEAR;
	}
	public void setR30_ACCOUNTS_FCY_2YEAR(BigDecimal r30_ACCOUNTS_FCY_2YEAR) {
		R30_ACCOUNTS_FCY_2YEAR = r30_ACCOUNTS_FCY_2YEAR;
	}
	public BigDecimal getR30_AMOUNT_FCY_2YEAR() {
		return R30_AMOUNT_FCY_2YEAR;
	}
	public void setR30_AMOUNT_FCY_2YEAR(BigDecimal r30_AMOUNT_FCY_2YEAR) {
		R30_AMOUNT_FCY_2YEAR = r30_AMOUNT_FCY_2YEAR;
	}
	public BigDecimal getR30_ACCOUNTS_AED_3YEAR() {
		return R30_ACCOUNTS_AED_3YEAR;
	}
	public void setR30_ACCOUNTS_AED_3YEAR(BigDecimal r30_ACCOUNTS_AED_3YEAR) {
		R30_ACCOUNTS_AED_3YEAR = r30_ACCOUNTS_AED_3YEAR;
	}
	public BigDecimal getR30_AMOUNT_AED_3YEAR() {
		return R30_AMOUNT_AED_3YEAR;
	}
	public void setR30_AMOUNT_AED_3YEAR(BigDecimal r30_AMOUNT_AED_3YEAR) {
		R30_AMOUNT_AED_3YEAR = r30_AMOUNT_AED_3YEAR;
	}
	public BigDecimal getR30_ACCOUNTS_FCY_3YEAR() {
		return R30_ACCOUNTS_FCY_3YEAR;
	}
	public void setR30_ACCOUNTS_FCY_3YEAR(BigDecimal r30_ACCOUNTS_FCY_3YEAR) {
		R30_ACCOUNTS_FCY_3YEAR = r30_ACCOUNTS_FCY_3YEAR;
	}
	public BigDecimal getR30_AMOUNT_FCY_3YEAR() {
		return R30_AMOUNT_FCY_3YEAR;
	}
	public void setR30_AMOUNT_FCY_3YEAR(BigDecimal r30_AMOUNT_FCY_3YEAR) {
		R30_AMOUNT_FCY_3YEAR = r30_AMOUNT_FCY_3YEAR;
	}
	public BigDecimal getR30_ACCOUNTS_AED_5YEAR() {
		return R30_ACCOUNTS_AED_5YEAR;
	}
	public void setR30_ACCOUNTS_AED_5YEAR(BigDecimal r30_ACCOUNTS_AED_5YEAR) {
		R30_ACCOUNTS_AED_5YEAR = r30_ACCOUNTS_AED_5YEAR;
	}
	public BigDecimal getR30_AMOUNT_AED_5YEAR() {
		return R30_AMOUNT_AED_5YEAR;
	}
	public void setR30_AMOUNT_AED_5YEAR(BigDecimal r30_AMOUNT_AED_5YEAR) {
		R30_AMOUNT_AED_5YEAR = r30_AMOUNT_AED_5YEAR;
	}
	public BigDecimal getR30_ACCOUNTS_FCY_5YEAR() {
		return R30_ACCOUNTS_FCY_5YEAR;
	}
	public void setR30_ACCOUNTS_FCY_5YEAR(BigDecimal r30_ACCOUNTS_FCY_5YEAR) {
		R30_ACCOUNTS_FCY_5YEAR = r30_ACCOUNTS_FCY_5YEAR;
	}
	public BigDecimal getR30_AMOUNT_FCY_5YEAR() {
		return R30_AMOUNT_FCY_5YEAR;
	}
	public void setR30_AMOUNT_FCY_5YEAR(BigDecimal r30_AMOUNT_FCY_5YEAR) {
		R30_AMOUNT_FCY_5YEAR = r30_AMOUNT_FCY_5YEAR;
	}
	public BigDecimal getR30_ACCOUNTS_AED_ABOVE() {
		return R30_ACCOUNTS_AED_ABOVE;
	}
	public void setR30_ACCOUNTS_AED_ABOVE(BigDecimal r30_ACCOUNTS_AED_ABOVE) {
		R30_ACCOUNTS_AED_ABOVE = r30_ACCOUNTS_AED_ABOVE;
	}
	public BigDecimal getR30_AMOUNT_AED_ABOVE() {
		return R30_AMOUNT_AED_ABOVE;
	}
	public void setR30_AMOUNT_AED_ABOVE(BigDecimal r30_AMOUNT_AED_ABOVE) {
		R30_AMOUNT_AED_ABOVE = r30_AMOUNT_AED_ABOVE;
	}
	public BigDecimal getR30_ACCOUNTS_FCY_ABOVE() {
		return R30_ACCOUNTS_FCY_ABOVE;
	}
	public void setR30_ACCOUNTS_FCY_ABOVE(BigDecimal r30_ACCOUNTS_FCY_ABOVE) {
		R30_ACCOUNTS_FCY_ABOVE = r30_ACCOUNTS_FCY_ABOVE;
	}
	public BigDecimal getR30_AMOUNT_FCY_ABOVE() {
		return R30_AMOUNT_FCY_ABOVE;
	}
	public void setR30_AMOUNT_FCY_ABOVE(BigDecimal r30_AMOUNT_FCY_ABOVE) {
		R30_AMOUNT_FCY_ABOVE = r30_AMOUNT_FCY_ABOVE;
	}
	public BigDecimal getR30_ACCOUNTS_AED_INACTIVE() {
		return R30_ACCOUNTS_AED_INACTIVE;
	}
	public void setR30_ACCOUNTS_AED_INACTIVE(BigDecimal r30_ACCOUNTS_AED_INACTIVE) {
		R30_ACCOUNTS_AED_INACTIVE = r30_ACCOUNTS_AED_INACTIVE;
	}
	public BigDecimal getR30_AMOUNT_AED_INACTIVE() {
		return R30_AMOUNT_AED_INACTIVE;
	}
	public void setR30_AMOUNT_AED_INACTIVE(BigDecimal r30_AMOUNT_AED_INACTIVE) {
		R30_AMOUNT_AED_INACTIVE = r30_AMOUNT_AED_INACTIVE;
	}
	public BigDecimal getR30_ACCOUNTS_FCY_INACTIVE() {
		return R30_ACCOUNTS_FCY_INACTIVE;
	}
	public void setR30_ACCOUNTS_FCY_INACTIVE(BigDecimal r30_ACCOUNTS_FCY_INACTIVE) {
		R30_ACCOUNTS_FCY_INACTIVE = r30_ACCOUNTS_FCY_INACTIVE;
	}
	public BigDecimal getR30_AMOUNT_FCY_INACTIVE() {
		return R30_AMOUNT_FCY_INACTIVE;
	}
	public void setR30_AMOUNT_FCY_INACTIVE(BigDecimal r30_AMOUNT_FCY_INACTIVE) {
		R30_AMOUNT_FCY_INACTIVE = r30_AMOUNT_FCY_INACTIVE;
	}
	public BigDecimal getR30_ACCOUNTS_AED_DORMANT() {
		return R30_ACCOUNTS_AED_DORMANT;
	}
	public void setR30_ACCOUNTS_AED_DORMANT(BigDecimal r30_ACCOUNTS_AED_DORMANT) {
		R30_ACCOUNTS_AED_DORMANT = r30_ACCOUNTS_AED_DORMANT;
	}
	public BigDecimal getR30_AMOUNT_AED_DORMANT() {
		return R30_AMOUNT_AED_DORMANT;
	}
	public void setR30_AMOUNT_AED_DORMANT(BigDecimal r30_AMOUNT_AED_DORMANT) {
		R30_AMOUNT_AED_DORMANT = r30_AMOUNT_AED_DORMANT;
	}
	public BigDecimal getR30_ACCOUNTS_FCY_DORMANT() {
		return R30_ACCOUNTS_FCY_DORMANT;
	}
	public void setR30_ACCOUNTS_FCY_DORMANT(BigDecimal r30_ACCOUNTS_FCY_DORMANT) {
		R30_ACCOUNTS_FCY_DORMANT = r30_ACCOUNTS_FCY_DORMANT;
	}
	public BigDecimal getR30_AMOUNT_FCY_DORMANT() {
		return R30_AMOUNT_FCY_DORMANT;
	}
	public void setR30_AMOUNT_FCY_DORMANT(BigDecimal r30_AMOUNT_FCY_DORMANT) {
		R30_AMOUNT_FCY_DORMANT = r30_AMOUNT_FCY_DORMANT;
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
	public String getModify_user() {
		return modify_user;
	}
	public void setModify_user(String modify_user) {
		this.modify_user = modify_user;
	}
	public Date getModify_time() {
		return modify_time;
	}
	public void setModify_time(Date modify_time) {
		this.modify_time = modify_time;
	}
	public String getVerify_flg() {
		return verify_flg;
	}
	public void setVerify_flg(String verify_flg) {
		this.verify_flg = verify_flg;
	}
	public String getVerify_user() {
		return verify_user;
	}
	public void setVerify_user(String verify_user) {
		this.verify_user = verify_user;
	}
	public Date getVerify_time() {
		return verify_time;
	}
	public void setVerify_time(Date verify_time) {
		this.verify_time = verify_time;
	}
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
	public BRF103_ENTITY() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}